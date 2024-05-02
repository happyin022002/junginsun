/*=========================================================
 *Copyright(c) 2012 CyberLogitec
 *@FileName : FICCostInterfaceBCImpl.java
 *@FileTitle : Cost Table Interface
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012-05-09
 *@LastModifier : 이은섭
 *@LastVersion : 1.0
 * 2012.5.08 이은섭
 * 1.0 Creation
 * ------------------------------------------------------
 * History
 * 2013.04.29 김보배 [CHM-201324375] Publish 기능 이전 요청
 * 2015.07.08 현성길 [CHM-201536782] EUR와 SHA/SIN 로직 분리
 * 2015.08.07 현성길 [CHM-201537109] Split19-[그룹사 표준 코드 시행] HJS 프로그램 대응 및 데이타 마이그레이션 작업 요청
=========================================================*/

package com.hanjin.apps.alps.esm.pri.tariff.ficcostinterface.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import com.hanjin.apps.alps.esm.pri.tariff.ficcostinterface.integration.FICCostInterfaceDBDAO;
import com.hanjin.apps.alps.esm.pri.tariff.ficcostinterface.vo.AddOnCostTraiffListVO;
import com.hanjin.apps.alps.esm.pri.tariff.ficcostinterface.vo.CheckCopyServiceScopeVO;
import com.hanjin.apps.alps.esm.pri.tariff.ficcostinterface.vo.CheckFDRCopyServiceScopeVO;
import com.hanjin.apps.alps.esm.pri.tariff.ficcostinterface.vo.CopyTariffFdrVO;
import com.hanjin.apps.alps.esm.pri.tariff.ficcostinterface.vo.CopyTariffIhcVO;
import com.hanjin.apps.alps.esm.pri.tariff.ficcostinterface.vo.IHCCostTariffInterfaceListVO;
import com.hanjin.apps.alps.esm.pri.tariff.ficcostinterface.vo.PriTrfFdrHdrVO;
import com.hanjin.apps.alps.esm.pri.tariff.ficcostinterface.vo.PriTrfIhcHdrVO;
import com.hanjin.apps.alps.esm.pri.tariff.ficcostinterface.vo.TariffCodeMappingVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.CheckUtils;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * Business Logic Basic Command implementation<br>
 * 비지니스 로직을 처리한다.<br>
 * 
 * @author LEE EUN-SUP
 * @see FICCostInterfaceDBDAO 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class FICCostInterfaceBCImpl extends BasicCommandSupport implements FICCostInterfaceBC {
	private FICCostInterfaceDBDAO dao = null;

	/**
	 * FICCostInterfaceBCImpl 객체를 생성
	 */
	public FICCostInterfaceBCImpl() {
		dao = new FICCostInterfaceDBDAO();
	}

	/**
	 * ESM_PRI_7021_01 : Cost Table Interface - Add-on Tariff TAB ==> Retrieve
	 * 
	 * @param svcScpCd
	 * @param rhq_cd
	 * @param org_dest_tp_cd
	 * @return List<AddOnCostTraiffListVO>
	 * @throws EventException
	 */
	public List<AddOnCostTraiffListVO> searchAddOnCostTariff(String svcScpCd, String rhq_cd, String org_dest_tp_cd) throws EventException {
		try {
			return dao.searchAddOnCostTariffList(svcScpCd, rhq_cd, org_dest_tp_cd);		
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * ESM_PRI_7021_01 : Cost Table Interface - Add-on Tariff TAB ==> Cost I/F
	 * 
	 * @param addOnCostTraiffListVOs
	 * @param account
	 * @throws EventException
	 */
	public void managerAddOnCostTraiff(AddOnCostTraiffListVO[] addOnCostTraiffListVOs, SignOnUserAccount account) throws EventException {
		try {
			for (AddOnCostTraiffListVO vo : addOnCostTraiffListVOs) {
				if ("U".equals(vo.getIbflag())) {
					PriTrfFdrHdrVO priTrfFdrHdrVO = new PriTrfFdrHdrVO();
					setPriTrfFeederHdr(priTrfFdrHdrVO, vo, account);
					dao.addTariffFeederHeaderData(priTrfFdrHdrVO);
					dao.addTariffFeederMainData(priTrfFdrHdrVO);
					if(priTrfFdrHdrVO.getRhqCd().equals("HAMRU")){  // EUR 지역
						dao.addTariffFeederRateData(priTrfFdrHdrVO);
					}
					else{ // Asia(SIN,SHA) 지역  
						dao.addChnTariffFeederRateData(priTrfFdrHdrVO);
					}
					
					dao.addTariffFeederDurationData(priTrfFdrHdrVO);
					dao.addTariffFeederProgressData(priTrfFdrHdrVO);

					String[] costTrfNos = priTrfFdrHdrVO.getCostTrfNo().split(Pattern.quote(","));
					if (costTrfNos.length > 0) {
						int i = 0;
						for (String costTrfNo : costTrfNos) {
							if (!CheckUtils.isInBlank(costTrfNo)) {
								priTrfFdrHdrVO.setCostTrfNo(costTrfNo);
								priTrfFdrHdrVO.setVerMapgSeq(String.valueOf(++i));
								dao.addTariffFeederCostVersionMappingData(priTrfFdrHdrVO);
							}
						}
					}
				}
			}

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}

	}

	/**
	 * ESM_PRI_7021_02 : Cost Table Interface - IHC Tariff TAB ==> Retrieve
	 * 
	 * @param svcScpCd
	 * @param cntCd
	 * @param rhq_cd
	 * @param org_dest_tp_cd
	 * @return List<IHCCostTariffInterfaceListVO>
	 * @throws EventException
	 */
	public List<IHCCostTariffInterfaceListVO> searchIHCCostTariff(String svcScpCd, String cntCd, String rhq_cd, String org_dest_tp_cd) throws EventException {
		try {
			return dao.searchIHCCostTariffList(svcScpCd, cntCd, rhq_cd, org_dest_tp_cd );
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * ESM_PRI_7021_02 : Cost Table Interface - IHC Tariff TAB ==> Cost I/F
	 * 
	 * @param ihcCostTariffInterfaceListVOs
	 * @param account
	 * @throws EventException
	 */
	public void managerIHCCostTariff(IHCCostTariffInterfaceListVO[] ihcCostTariffInterfaceListVOs, SignOnUserAccount account) throws EventException {
		try {
			for (IHCCostTariffInterfaceListVO vo : ihcCostTariffInterfaceListVOs) {
				if ("U".equals(vo.getIbflag())) {
					PriTrfIhcHdrVO priTrfIhcHdrVO = new PriTrfIhcHdrVO();
					setPriTrfIhcHdr(priTrfIhcHdrVO, vo, account);
					dao.addTariffIhcHeaderData(priTrfIhcHdrVO);
					dao.addTariffIhcMainData(priTrfIhcHdrVO);
					if(priTrfIhcHdrVO.getRhqCd().equals("NYCRA")){
						dao.addUsTariffIhcRateData(priTrfIhcHdrVO);
					}
					else if(priTrfIhcHdrVO.getRhqCd().equals("HAMRU")){
						dao.addTariffIhcRateData(priTrfIhcHdrVO);
					}
					else{ // Asia 지역 (SIN, SHA)
						dao.addChnTariffIhcRateData(priTrfIhcHdrVO);
					}
					dao.addTariffIhcRFRateData(priTrfIhcHdrVO);
					dao.addTariffIhcProgressData(priTrfIhcHdrVO);
					dao.addTariffIhcDurationData(priTrfIhcHdrVO);
					dao.addTariffIhcSpecialCargoRateData(priTrfIhcHdrVO);
				}
			}

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * setting PriTrfIhcHdrVO
	 * 
	 * @param priTrfIhcHdrVO
	 * @param vo
	 * @param account
	 * @throws EventException
	 */
	private void setPriTrfIhcHdr(PriTrfIhcHdrVO priTrfIhcHdrVO, IHCCostTariffInterfaceListVO vo, SignOnUserAccount account) throws Exception {
		try {
			priTrfIhcHdrVO.setSvcScpCd(vo.getSvcScpCd());
			priTrfIhcHdrVO.setIhcTrfNo(dao.searchIhcTariffNumber(vo));
			priTrfIhcHdrVO.setCostTrfNo(vo.getCostTrfNo());
			priTrfIhcHdrVO.setCostCntCd(vo.getCntCd());
			priTrfIhcHdrVO.setRhqCd(vo.getRhqCd());
			priTrfIhcHdrVO.setCreUsrId(account.getUsr_id());
			priTrfIhcHdrVO.setUpdUsrId(account.getUsr_id());
			priTrfIhcHdrVO.setOfcCd(account.getOfc_cd());
			priTrfIhcHdrVO.setOrgDestTpCd(vo.getOrgDestTpCd());
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * setting PriTrfFdrHdrVO
	 * 
	 * @param priTrfFdrHdrVO
	 * @param vo
	 * @param account
	 * @throws Exception
	 */
	private void setPriTrfFeederHdr(PriTrfFdrHdrVO priTrfFdrHdrVO, AddOnCostTraiffListVO vo, SignOnUserAccount account) throws Exception {
		try {
			priTrfFdrHdrVO.setSvcScpCd(vo.getSvcScpCd());
			priTrfFdrHdrVO.setFdrTrfNo(dao.searchFeederTariffNumber(vo.getSvcScpCd(), vo.getOrgDestTpCd(), vo.getRhqCd()));
			priTrfFdrHdrVO.setCostTrfNo(vo.getCostTrfNo());
			priTrfFdrHdrVO.setRhqCd(vo.getRhqCd());
			priTrfFdrHdrVO.setCreUsrId(account.getUsr_id());
			priTrfFdrHdrVO.setUpdUsrId(account.getUsr_id());
			priTrfFdrHdrVO.setOfcCd(account.getOfc_cd());
			priTrfFdrHdrVO.setOrgDestTpCd(vo.getOrgDestTpCd());
		} catch (Exception e) {
			throw e;
		}
	}
	
	/**
	 * ESM_PRI_7006 : Check Copy Service Scope - SAVE validation 1 <br>
	 * 
	 * @param CheckCopyServiceScopeVO[] checkCopyServiceScopeVOs
	 * @return List<CheckCopyServiceScopeVO>
	 * @throws EventException
	 */
	public List<CheckCopyServiceScopeVO> checkCopyServiceScope(CheckCopyServiceScopeVO[] checkCopyServiceScopeVOs) throws EventException {
		try {
			return dao.checkCopyServiceScope(checkCopyServiceScopeVOs);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * ESM_PRI_7006 : Check Copy Service Scope - SAVE validation 2 <br>
	 * check exist IHC tariff's status <br>
	 * 
	 * @param CheckCopyServiceScopeVO[] checkCopyServiceScopeVOs
	 * @return List<CheckCopyServiceScopeVO>
	 * @throws EventException
	 */
	public List<CheckCopyServiceScopeVO> checkCopyServiceScopeInitial(CheckCopyServiceScopeVO[] checkCopyServiceScopeVOs) throws EventException {
		try {
			return dao.checkCopyServiceScopeInitial(checkCopyServiceScopeVOs);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * ESM_PRI_7006 : Check Copy Service Scope - SAVE validation 3 <br>
	 * check exist IHC tariff's effective date <br>
	 * 
	 * @param CheckCopyServiceScopeVO[] checkCopyServiceScopeVOs
	 * @return List<CheckCopyServiceScopeVO>
	 * @throws EventException
	 */
	public List<CheckCopyServiceScopeVO> checkCopyServiceScopeEffdt(CheckCopyServiceScopeVO[] checkCopyServiceScopeVOs) throws EventException {
		try {
			return dao.checkCopyServiceScopeEffdt(checkCopyServiceScopeVOs);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * ESM_PRI_7006 : Copy IHC
	 * 
	 * @param CopyTariffIhcVO[] copyTariffIhcVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageIHCCopy(CopyTariffIhcVO[] copyTariffIhcVOs, SignOnUserAccount account) throws EventException {
		// TODO Auto-generated method stub
		try {
			List<CopyTariffIhcVO> insertSheetVoList = new ArrayList<CopyTariffIhcVO>();
			IHCCostTariffInterfaceListVO vo = new IHCCostTariffInterfaceListVO();

			if (copyTariffIhcVOs != null) {
				for (int i = 0; i < copyTariffIhcVOs.length; i++) {					
					if (copyTariffIhcVOs[i].getIbflag().equals("I")) {
						copyTariffIhcVOs[i].setCreUsrId(account.getUsr_id());
						copyTariffIhcVOs[i].setUpdUsrId(account.getUsr_id());
						copyTariffIhcVOs[i].setCreOfcCd(account.getOfc_cd()); 
						vo.setSvcScpCd(copyTariffIhcVOs[i].getSvcScpCd());
						vo.setOrgDestTpCd(copyTariffIhcVOs[i].getOrgDestTpCd());
						vo.setCntCd(copyTariffIhcVOs[i].getCostCntCd());
						copyTariffIhcVOs[i].setIhcTrfNo(dao.searchIhcTariffNumber(vo));
						insertSheetVoList.add(copyTariffIhcVOs[i]);
					}
				}
			}

			if (insertSheetVoList.size() > 0) {
				dao.copyTariffIhcHeaderData(insertSheetVoList);
				dao.copyTariffIhcMainData(insertSheetVoList);
				dao.copyTariffIhcRateData(insertSheetVoList);
				dao.copyTariffIhcRFRateData(insertSheetVoList);
				dao.copyTariffIhcProgressData(insertSheetVoList);
				dao.copyTariffIhcDurationData(insertSheetVoList);
				dao.copyTariffIhcSpecialCargoRateData(insertSheetVoList);
			}

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * ESM_PRI_7007 : Check Copy Service Scope - SAVE validation 1 <br>
	 * check exist FDR tariff's status <br>
	 * 
	 * @param CheckFDRCopyServiceScopeVO[] checkFDRCopyServiceScopeVOs
	 * @return List<CheckFDRCopyServiceScopeVO>
	 * @throws EventException
	 */
	public List<CheckFDRCopyServiceScopeVO> checkFDRCopyServiceScopeInitial(CheckFDRCopyServiceScopeVO[] checkFDRCopyServiceScopeVOs) throws EventException {
		try {
			return dao.checkFDRCopyServiceScopeInitial(checkFDRCopyServiceScopeVOs);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * ESM_PRI_7007 : Check Copy Service Scope - SAVE validation 2 <br>
	 * check exist FDR tariff's effective date <br>
	 * 
	 * @param CheckFDRCopyServiceScopeVO[] checkFDRCopyServiceScopeVOs
	 * @return List<CheckFDRCopyServiceScopeVO>
	 * @throws EventException
	 */
	public List<CheckFDRCopyServiceScopeVO> checkFDRCopyServiceScopeEffdt(CheckFDRCopyServiceScopeVO[] checkFDRCopyServiceScopeVOs) throws EventException {
		try {
			return dao.checkFDRCopyServiceScopeEffdt(checkFDRCopyServiceScopeVOs);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * ESM_PRI_7007 : Copy FDR
	 * 
	 * @param CopyTariffFdrVO[] copyTariffFdrVOs
	 * @param account
	 * @throws EventException
	 */
	public void manageFDRCopy(CopyTariffFdrVO[] copyTariffFdrVOs, SignOnUserAccount account) throws EventException {
		// TODO Auto-generated method stub
		try {
			List<CopyTariffFdrVO> insertSheetVoList = new ArrayList<CopyTariffFdrVO>();
			AddOnCostTraiffListVO vo = new AddOnCostTraiffListVO();

			if (copyTariffFdrVOs != null) {
				for (int i = 0; i < copyTariffFdrVOs.length; i++) {					
					if (copyTariffFdrVOs[i].getIbflag().equals("I")) {
						copyTariffFdrVOs[i].setCreUsrId(account.getUsr_id());
						copyTariffFdrVOs[i].setUpdUsrId(account.getUsr_id());
						copyTariffFdrVOs[i].setCreOfcCd(account.getOfc_cd()); 
						vo.setSvcScpCd(copyTariffFdrVOs[i].getSvcScpCd());
						vo.setOrgDestTpCd(copyTariffFdrVOs[i].getOrgDestTpCd());      
						vo.setRhqCd(copyTariffFdrVOs[i].getRhqCd());
						copyTariffFdrVOs[i].setFdrTrfNo(dao.searchFeederTariffNumber(vo.getSvcScpCd(), vo.getOrgDestTpCd(), vo.getRhqCd()));
						insertSheetVoList.add(copyTariffFdrVOs[i]);
					}
				}
			}

			if (insertSheetVoList.size() > 0) {
				dao.copyTariffFdrHeaderData(insertSheetVoList);
				dao.copyTariffFdrMainData(insertSheetVoList);
				dao.copyTariffFdrDurationData(insertSheetVoList);
				dao.copyTariffFdrProgressData(insertSheetVoList);
				dao.copyTariffFeederCostVersionMappingData(insertSheetVoList);
				dao.copyTariffFdrRateData(insertSheetVoList);
			}

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}
	
	
	/**
	 * ESM_PRI_7022 : 조회<br>
	 * 
	 * @return List<TariffCodeMappingVO>
	 * @throws EventException
	 */
	public List<TariffCodeMappingVO> searchTariffCodeMapping() throws EventException {
		try {
			return dao.searchTariffCodeMapping();
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}		
	}
	
	
	/**
	 * ESM_PRI_7022 : 저장<br>
	 * 
	 * @param TariffCodeMappingVO[] tariffCodeMappingVOs
	 * @param account
	 * @throws EventException
	 */
	public void manageTariffCodeMapping(TariffCodeMappingVO[] tariffCodeMappingVOs, SignOnUserAccount account) throws EventException {
		try {
			if(tariffCodeMappingVOs != null && tariffCodeMappingVOs.length > 0){
				for(int i=0; i<tariffCodeMappingVOs.length; i++ ) {
					
                    if (tariffCodeMappingVOs[i].getIbflag().equals("I")){

                    	tariffCodeMappingVOs[i].setCreUsrId(account.getUsr_id());
                    	tariffCodeMappingVOs[i].setUpdUsrId(account.getUsr_id());
                    	dao.addTariffCodeMapping(tariffCodeMappingVOs[i]);
                    
                    } else if (tariffCodeMappingVOs[i].getIbflag().equals("D")){
                    	dao.removeTariffCodeMapping(tariffCodeMappingVOs[i]);
                    }
				} // for end
			} // if end
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
}
