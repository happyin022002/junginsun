/*=========================================================
 *Copyright(c) 2012 CyberLogitec
 *@FileName : IHCGuideLineBC.java
 *@FileTitle : IHC Guide Line 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.05.08
 *@LastModifier : 이은섭
 *@LastVersion : 1.0
=========================================================
 * History
 * 2013.04.29 전윤주 [CHM-201324375] Inland Tariff 기능 병합  (Amend Type 추가)
 * 2013.06.10 서미진 [선처리 CSR] Load Excel data 의 증가로 backendjob으로 upload 로직 변경
 * 2013.07.08 서미진 [CHM-201325626] HAMRU 산하 TAE, TAW, ASE, ASW 인 경우 Local Currency 가 기준이 되도록 변경
 * 2013.07.26 전윤주 [CHM-201325898] Dry 일 경우 신규 Tariff 입력 시 40' AMT를 기준으로 Loc.Group을 할당해주는 로직 추가
 * 2013.08.01 전윤주 [CHM-201326002] DG Overweight Service flag가 'Y' 인 경우에만 버튼 색을 파란색으로 표시 
 * 2013.09.11 전윤주 [CHM-201326761] HAMRU 산하 EAS, EAN인 경우 Local Currency 가 기준이 되도록 추가
 * 2013.03.16 전지예 [CHM-201534279] Pricing Feeder/IHC tariff 45" 칼럼 추가 안
 * 2015.08.07 현성길 [CHM-201537109] Split19-[그룹사 표준 코드 시행] HJS 프로그램 대응 및 데이타 마이그레이션 작업 요청
=========================================================*/
package com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.basic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.integration.IHCGuideLineDBDAO;
import com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.vo.IHCDetailVO;
import com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.vo.IHCGuidelineDetailVO;
import com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.vo.IHCGuidelineMainVO;
import com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.vo.IHCTariffInquiryListVO;
import com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.vo.PriTrfIHCRtVO;
import com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.vo.SearchIHCAmendmentHistoryDetailVO;
import com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.vo.SearchIHCAmendmentHistoryMainVO;
import com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.vo.SearchIhcTariffInquiryVO;
import com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.vo.SearchUsInlandServiceModeTotalVO;
import com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.vo.SearchUsTariffInquiryListVO;
import com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.vo.SpecialCargoPopupListVO;
import com.hanjin.framework.component.backend.core.BackEndJobManager;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriTrfIhcProgVO;

/**
 * Business Logic Basic Command implementation<br>
 * 비지니스 로직을 처리한다.<br>
 * 
 * @author LEE EUN-SUP
 * @see IHCGuideLineDBDAO 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class IHCGuideLineBCImpl extends BasicCommandSupport implements IHCGuideLineBC {

	private IHCGuideLineDBDAO dao = null;

	/**
	 * IHCGuideLineBCImpl 객체 생성<br>
	 * IHCGuideLineBCImpl 생성한다.<br>
	 */
	public IHCGuideLineBCImpl() {
		dao = new IHCGuideLineDBDAO();
	}

	/**
	 * ESM_PRI_7004 :: IHC Tariff Inquiry
	 * 
	 * @param searchTariffInquiryVO
	 * @return List<IHCTariffInquiryListVO>
	 * @throws EventException
	 */
	public List<IHCTariffInquiryListVO> searchIhcTariffInquiryList(SearchIhcTariffInquiryVO searchIhcTariffInquiryVO) throws EventException {
		try {
			return dao.searchIhcTariffInquiryList(searchIhcTariffInquiryVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * ESM_PRI_7024 :: IHC Tariff Creation & Amendment ? Special Pop up
	 * 
	 * @param IHCGuidelineMainVO iHCGuidelineMainVO
	 * @return List<SpecialCargoPopupListVO>
	 * @throws EventException
	 */
	public List<SpecialCargoPopupListVO> searchSpecialCargoPopupList(IHCGuidelineMainVO iHCGuidelineMainVO) throws EventException {
		try {
			return dao.searchSpecialCargoPopupList(iHCGuidelineMainVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * ESM_PRI_7001 : Retrieve form <br>
	 * Retrieve form data <br>
	 * 
	 * @param IHCGuidelineMainVO iHCGuidelineMainVO
	 * @return List<IHCGuidelineMainVO>
	 * @exception EventException
	 */
	public List<IHCGuidelineMainVO> searchIHCGuidelineMain(IHCGuidelineMainVO iHCGuidelineMainVO) throws EventException {
		try {
			return dao.searchIHCGuidelineMain(iHCGuidelineMainVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * ESM_PRI_7001_01, ESM_PRI_7001_02 : Retrieve sheet <br>
	 * Retrieve sheet data <br>
	 * 
	 * @param IHCGuidelineDetailVO iHCGuidelineDetailVO
	 * @return List<IHCGuidelineDetailVO>
	 * @exception EventException
	 */
	public List<IHCGuidelineDetailVO> searchIHCGuidelineDetail(IHCGuidelineDetailVO iHCGuidelineDetailVO) throws EventException {
		try {
			return dao.searchIHCGuidelineDetail(iHCGuidelineDetailVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * ESM_PRI_7001 : Save <br>
	 * Save data <br>
	 * 
	 * @param IHCGuidelineMainVO iHCGuidelineMainVO
	 * @param SignOnUserAccount account
	 * @return void
	 * @exception EventException
	 */
	public void manageIHCGuidelineMain(IHCGuidelineMainVO iHCGuidelineMainVO, SignOnUserAccount account) throws EventException {
		// TODO Auto-generated method stub
		try {		
			// Main effective date
			if (iHCGuidelineMainVO != null) {
				iHCGuidelineMainVO.setUpdUsrId(account.getUsr_id());
				dao.modifyIHCGuidelineMain(iHCGuidelineMainVO);
				dao.modifyIHCTariffDuration(iHCGuidelineMainVO);
			}			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * ESM_PRI_7001_01 : Save <br>
	 * Save data <br>
	 * 
	 * @param IHCGuidelineMainVO iHCGuidelineMainVO
	 * @param IHCGuidelineDetailVO [] iHCGuidelineDetailVOs
	 * @param SignOnUserAccount account
	 * @return void
	 * @exception EventException
	 */
	public void manageIHCGuidelineDetail(IHCGuidelineMainVO iHCGuidelineMainVO, IHCGuidelineDetailVO[] iHCGuidelineDetailVOs, SignOnUserAccount account)
			throws EventException {
		// TODO Auto-generated method stub
		try {
			List<IHCGuidelineDetailVO> insertSheetVoList = new ArrayList<IHCGuidelineDetailVO>();
			List<IHCGuidelineDetailVO> updateSheetVoList = new ArrayList<IHCGuidelineDetailVO>();
			List<IHCGuidelineDetailVO> deleteSheetVoList = new ArrayList<IHCGuidelineDetailVO>();			
			IHCDetailVO iHCDetailVO = new IHCDetailVO();
			
			iHCDetailVO.setSvcScpCd(iHCGuidelineDetailVOs[0].getSvcScpCd());
			iHCDetailVO.setIhcTrfNo(iHCGuidelineDetailVOs[0].getIhcTrfNo());
			iHCDetailVO.setIhcCgoTpCd(iHCGuidelineDetailVOs[0].getIhcCgoTpCd());
			iHCDetailVO.setOrgDestTpCd(iHCGuidelineDetailVOs[0].getOrgDestTpCd());
			iHCDetailVO.setAmdtSeq(iHCGuidelineDetailVOs[0].getAmdtSeq());
			iHCDetailVO.setUpdUsrId(account.getUsr_id());
			
			
			if (iHCGuidelineDetailVOs != null) {
				for (int i = 0; i < iHCGuidelineDetailVOs.length; i++) {					
					
					// EUR이 아닐 경우 45' Cost 값이 없으므로 화면에서 40'Cost 값을 조회하고 있기 때문에 수정시에는 null 처리. 
					if(iHCGuidelineDetailVOs[i].getRhqCd() != null && !iHCGuidelineDetailVOs[i].getRhqCd().equals("HAMRU")) {
						iHCGuidelineDetailVOs[i].setCost45ftFrtRtAmt(null);
						iHCGuidelineDetailVOs[i].setCost45ftRailFrtRtAmt(null);
						iHCGuidelineDetailVOs[i].setCost45ftTrkFrtRtAmt(null);
						iHCGuidelineDetailVOs[i].setDiff45ft(null);
						iHCGuidelineDetailVOs[i].setDiffLocl45ft(null);
						iHCGuidelineDetailVOs[i].setDiffRail45ft(null);
						iHCGuidelineDetailVOs[i].setDiffTrk45ft(null);
						iHCGuidelineDetailVOs[i].setGline45ftFrtRtAmt(null);
						iHCGuidelineDetailVOs[i].setGlineLoclCurr45ftAmt(null);
						iHCGuidelineDetailVOs[i].setGline45ftRailFrtRtAmt(null);
						iHCGuidelineDetailVOs[i].setGline45ftTrkFrtRtAmt(null);
						iHCGuidelineDetailVOs[i].setLoclCurrCost45ftFrtRtAmt(null);
						iHCGuidelineDetailVOs[i].setMb45ftRto(null);
						iHCGuidelineDetailVOs[i].setMtyTrsp45ftCostAmt(null);
						iHCGuidelineDetailVOs[i].setTml45ftCostAmt(null);
						iHCGuidelineDetailVOs[i].setTrsp45ftAgmtWgt(null);
						iHCGuidelineDetailVOs[i].setTrsp45ftCostAmt(null);
						iHCGuidelineDetailVOs[i].setTrsp45ftRailCostAmt(null);
						iHCGuidelineDetailVOs[i].setTrsp45ftTrkCostAmt(null);
					}
					
					if (iHCGuidelineDetailVOs[i].getIbflag().equals("I")) {
						iHCGuidelineDetailVOs[i].setOptmTrspModFlg("Y");
						iHCGuidelineDetailVOs[i].setCreUsrId(account.getUsr_id());
						iHCGuidelineDetailVOs[i].setUpdUsrId(account.getUsr_id());
						insertSheetVoList.add(iHCGuidelineDetailVOs[i]);
						
					} else if (iHCGuidelineDetailVOs[i].getIbflag().equals("U")) {
						iHCGuidelineDetailVOs[i].setUpdUsrId(account.getUsr_id());
						updateSheetVoList.add(iHCGuidelineDetailVOs[i]);
					} else if (iHCGuidelineDetailVOs[i].getIbflag().equals("D")) {
						deleteSheetVoList.add(iHCGuidelineDetailVOs[i]);
					}
				}
			}

			if (insertSheetVoList.size() > 0) {
				dao.addIHCGuidelineDetail(insertSheetVoList);
					if (iHCDetailVO.getIhcCgoTpCd().equals("DR")){ // Dry만 loc.group 신규 할당
						for (int i = 0; i < iHCGuidelineDetailVOs.length; i++) {	
							dao.addIHCGuidelineDetailLocGroup(iHCDetailVO); //신규 입력된 Tariff에 대해 Loc.group 업데이트
						}
					}
			}	

			if (updateSheetVoList.size() > 0) {
				dao.modifyIHCGuidelineDetail(updateSheetVoList);
			}

			if (deleteSheetVoList.size() > 0) {
				dao.removeIHCGuidelineDetail(deleteSheetVoList);
			}

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * ESM_PRI_7001 : Confirm <br>
	 * Confirm <br>
	 * 
	 * @param IHCGuidelineMainVO iHCGuidelineMainVO
	 * @param PriTrfIhcProgVO priTrfIhcProgVO
	 * @param SignOnUserAccount account
	 * @return void
	 * @exception EventException
	 */
	public void confirmIHCGuidelineMain(IHCGuidelineMainVO iHCGuidelineMainVO, PriTrfIhcProgVO priTrfIhcProgVO, SignOnUserAccount account) throws EventException {
		// TODO Auto-generated method stub
		try {
			if (iHCGuidelineMainVO != null && priTrfIhcProgVO != null) {
				iHCGuidelineMainVO.setUpdUsrId(account.getUsr_id());
				iHCGuidelineMainVO.setCfmOfcCd(account.getOfc_cd());
				iHCGuidelineMainVO.setCfmUsrId(account.getUsr_id());
				priTrfIhcProgVO.setCreUsrId(account.getUsr_id());
				priTrfIhcProgVO.setProgUsrId(account.getUsr_id());
				priTrfIhcProgVO.setUpdUsrId(account.getUsr_id());
				priTrfIhcProgVO.setProgOfcCd(account.getOfc_cd());

				if (iHCGuidelineMainVO.getAmdtSeq().equals("0")) {
					dao.modifyIHCTariffDurationConfirm(iHCGuidelineMainVO);
					dao.modifyIHCGuidelineConfirmBefTrf(iHCGuidelineMainVO);
				}
				dao.modifyIHCGuidelineConfirmCur(iHCGuidelineMainVO);
				dao.addIHCGuidelineProgress(priTrfIhcProgVO);
				dao.modifyIHCGuidelineConfirmBef(iHCGuidelineMainVO);					
				if(iHCGuidelineMainVO.getRhqCd().equals("HAMRU")){ 					
					if(iHCGuidelineMainVO.getSvcScpCd().equals("TAE") || iHCGuidelineMainVO.getSvcScpCd().equals("TAW")|| iHCGuidelineMainVO.getSvcScpCd().equals("ASE") ||
					   iHCGuidelineMainVO.getSvcScpCd().equals("ASW") || iHCGuidelineMainVO.getSvcScpCd().equals("EAS")|| iHCGuidelineMainVO.getSvcScpCd().equals("EAN")){			
						dao.modifyIHCGuidelineDetailLocalDiff(iHCGuidelineMainVO);
						dao.modifyIHCGuidelineDetailLocalConfirm(iHCGuidelineMainVO);
						dao.modifyIHCGuidelineDetailLocalConfirmTuning(iHCGuidelineMainVO);
						dao.modifyIHCGuidelineDetailConfirmUSDExchangeRate(iHCGuidelineMainVO);
					}else{
						dao.modifyIHCGuidelineDetailDiff(iHCGuidelineMainVO);
						dao.modifyIHCGuidelineDetailConfirm(iHCGuidelineMainVO);
						dao.modifyIHCGuidelineDetailConfirmTuning(iHCGuidelineMainVO);
						dao.modifyIHCGuidelineDetailConfirmExchangeRate(iHCGuidelineMainVO);
					}					
				}else{		
					dao.modifyIHCGuidelineDetailDiff(iHCGuidelineMainVO);
					dao.modifyIHCGuidelineDetailConfirm(iHCGuidelineMainVO);
					dao.modifyIHCGuidelineDetailConfirmTuning(iHCGuidelineMainVO);
					dao.modifyIHCGuidelineDetailConfirmExchangeRate(iHCGuidelineMainVO);
				}
			}

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * ESM_PRI_7001 : Cancel <br>
	 * Cancel <br>
	 * 
	 * @param IHCGuidelineMainVO iHCGuidelineMainVO
	 * @param SignOnUserAccount account
	 * @return void
	 * @exception EventException
	 */
	public void cancelIHCGuidelineMain(IHCGuidelineMainVO iHCGuidelineMainVO, SignOnUserAccount account) throws EventException {
		// TODO Auto-generated method stub
		try {
			dao.removeIHCTariffDuration(iHCGuidelineMainVO);
			dao.removeIHCGuidelineProgress(iHCGuidelineMainVO);
			dao.removeIHCGuidelineDetailAll(iHCGuidelineMainVO);
			dao.removeIHCGuidelineMain(iHCGuidelineMainVO);

			iHCGuidelineMainVO.setUpdUsrId(account.getUsr_id());

			// Amend Seq. == 0 && FIC_PROP_STS_CD = I
			if (iHCGuidelineMainVO.getAmdtSeq().equals("0") && iHCGuidelineMainVO.getFicPropStsCd().equals("I")) {
				dao.removeIHCSpecialCargoRate(iHCGuidelineMainVO);
				dao.removeIHCGuidelineHeader(iHCGuidelineMainVO);
			} else {
				dao.modifyIHCGuidelineCancel(iHCGuidelineMainVO);
			}

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * ESM_PRI_7001 : Amend <br>
	 * Amend <br>
	 * 
	 * @param IHCGuidelineMainVO iHCGuidelineMainVO
	 * @param PriTrfIhcProgVO priTrfIhcProgVO
	 * @param SignOnUserAccount account
	 * @return void
	 * @exception EventException
	 */
	public void amendIHCGuideline(IHCGuidelineMainVO iHCGuidelineMainVO, PriTrfIhcProgVO priTrfIhcProgVO, SignOnUserAccount account) throws EventException {
		// TODO Auto-generated method stub
		try {
			if (iHCGuidelineMainVO != null && priTrfIhcProgVO != null) {
				iHCGuidelineMainVO.setUpdUsrId(account.getUsr_id());
				iHCGuidelineMainVO.setCreUsrId(account.getUsr_id());
				iHCGuidelineMainVO.setCreOfcCd(account.getOfc_cd());

				priTrfIhcProgVO.setCreUsrId(account.getUsr_id());
				priTrfIhcProgVO.setProgUsrId(account.getUsr_id());
				priTrfIhcProgVO.setUpdUsrId(account.getUsr_id());
				priTrfIhcProgVO.setFicPropStsCd("I");
				priTrfIhcProgVO.setAmdtSeq(iHCGuidelineMainVO.getTobeAmdtSeq());

				dao.addIHCGuidelineMainAmend(iHCGuidelineMainVO);
				dao.addIHCGuidelineProgress(priTrfIhcProgVO);
				dao.addIHCGuidelineDetailAmend(iHCGuidelineMainVO);
				dao.addIHCTariffDurationAmend(iHCGuidelineMainVO);
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * ESM_PRI_7001 : Confirm <br>
	 * Retrieve pre version eff_dt <br>
	 * 
	 * @param IHCGuidelineMainVO iHCGuidelineMainVO
	 * @return List<IHCGuidelineMainVO>
	 * @exception EventException
	 */
	public List<IHCGuidelineMainVO> checkPreIHCGuideline(IHCGuidelineMainVO iHCGuidelineMainVO) throws EventException {
		try {
			return dao.checkPreIHCGuideline(iHCGuidelineMainVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * ESM_PRI_7001 : Amend <br>
	 * Retrieve MAX COST_TRF_NO <br>
	 * 
	 * @param IHCGuidelineMainVO iHCGuidelineMainVO
	 * @return List<IHCGuidelineMainVO>
	 * @exception EventException
	 */
	public List<IHCGuidelineMainVO> checkMaxCostTrfNo(IHCGuidelineMainVO iHCGuidelineMainVO) throws EventException {
		try {
			return dao.checkMaxCostTrfNo(iHCGuidelineMainVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * ESM_PRI_7025 : IHC Tariff No. Combo <br>
	 * Retrieve IHC Tariff No. Combo <br>
	 * 
	 * @param SearchIHCAmendmentHistoryMainVO searchIHCAmendmentHistoryMainVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchIHCAmendmentHistoryMainCombo(SearchIHCAmendmentHistoryMainVO searchIHCAmendmentHistoryMainVO) throws EventException {
		try {
			return dao.searchIHCAmendmentHistoryMainCombo(searchIHCAmendmentHistoryMainVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * ESM_PRI_7025 : IHC Tariff Amendment History Main <br>
	 * Retrieve IHC Tariff Amendment History Main <br>
	 * 
	 * @param SearchIHCAmendmentHistoryMainVO searchIHCAmendmentHistoryMainVO
	 * @return List<SearchIHCAmendmentHistoryMainVO>
	 * @exception EventException
	 */
	public List<SearchIHCAmendmentHistoryMainVO> searchIHCAmendmentHistoryMain(SearchIHCAmendmentHistoryMainVO searchIHCAmendmentHistoryMainVO) throws EventException {
		try {
			return dao.searchIHCAmendmentHistoryMain(searchIHCAmendmentHistoryMainVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}
		
	/**
	 * ESM_PRI_7025 : IHC Tariff Amendment History Main <br>
	 * DG, Overweight 팝업 버튼 색 변경을 위한 조회 <br>
	 * 
	 * @param IHCTariffInquiryListVO iHCTariffInquiryListVO
	 * @return List<IHCTariffInquiryListVO>
	 * @exception EventException
	 */
	public List<IHCTariffInquiryListVO> searchIHCDgOverWeightFlag(IHCTariffInquiryListVO iHCTariffInquiryListVO) throws EventException {
		try {
			return dao.searchIHCDgOverWeightFlag(iHCTariffInquiryListVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * ESM_PRI_7025 : Retrieve Max seq. <br>
	 * Retrieve IHC Tariff Amendment History Max seq. <br>
	 * 
	 * @param SearchIHCAmendmentHistoryMainVO searchIHCAmendmentHistoryMainVO
	 * @return List<SearchIHCAmendmentHistoryMainVO>
	 * @exception EventException
	 */
	public List<SearchIHCAmendmentHistoryMainVO> searchIHCAmendmentHistoryMainMaxSeq(SearchIHCAmendmentHistoryMainVO searchIHCAmendmentHistoryMainVO)
			throws EventException {
		try {
			return dao.searchIHCAmendmentHistoryMainMaxSeq(searchIHCAmendmentHistoryMainVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * ESM_PRI_7025 : IHC Tariff Amendment History Detail <br>
	 * Retrieve IHC Tariff Amendment History detail <br>
	 * 
	 * @param SearchIHCAmendmentHistoryDetailVO searchIHCAmendmentHistoryDetailVO
	 * @return List<SearchIHCAmendmentHistoryDetailVO>
	 * @exception EventException
	 */
	public List<SearchIHCAmendmentHistoryDetailVO> searchIHCAmendmentHistoryDetail(SearchIHCAmendmentHistoryDetailVO searchIHCAmendmentHistoryDetailVO)
			throws EventException {
		try {
			return dao.searchIHCAmendmentHistoryDetail(searchIHCAmendmentHistoryDetailVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * ESM_PRI_7006 : update max IHC_TRF_NO's exp_dt <br>
	 * PRI_TRF_IHC_MN, PRI_TRF_IHC_DUR
	 * 
	 * @param IHCGuidelineMainVO[] iHCGuidelineMainVOs
	 * @param SignOnUserAccount account
	 * @return void
	 * @exception EventException
	 */
	public void confirmIHCExpDt(IHCGuidelineMainVO[] iHCGuidelineMainVOs, SignOnUserAccount account) throws EventException {
		// TODO Auto-generated method stub    modifyIHCTariffDurationConfirm
		try {
			if (iHCGuidelineMainVOs != null) {
				for (int i = 0; i < iHCGuidelineMainVOs.length; i++) {					
					if (iHCGuidelineMainVOs[i].getIbflag().equals("I")) {
						iHCGuidelineMainVOs[i].setUpdUsrId(account.getUsr_id());
						dao.modifyIHCGuidelineConfirmBefTrf(iHCGuidelineMainVOs[i]);
						dao.modifyIHCTariffDurationConfirm(iHCGuidelineMainVOs[i]);
					}
				}
			}     
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * ESM_PRI_7001_01 : Save <br>
	 * Save data <br>
	 * 
	 * @param IHCGuidelineMainVO iHCGuidelineMainVO
	 * @param IHCGuidelineDetailVO [] iHCGuidelineDetailVOs
	 * @param SignOnUserAccount account
	 * @return void
	 * @exception EventException
	 */
	public void manageUsIHCGuidelineDetail(IHCGuidelineMainVO iHCGuidelineMainVO, IHCGuidelineDetailVO[] iHCGuidelineDetailVOs, SignOnUserAccount account)
			throws EventException {
		// TODO Auto-generated method stub
		try {
			List<IHCGuidelineDetailVO> insertSheetVoList = new ArrayList<IHCGuidelineDetailVO>();
			List<IHCGuidelineDetailVO> updateSheetVoList = new ArrayList<IHCGuidelineDetailVO>();
			List<IHCGuidelineDetailVO> deleteSheetVoList = new ArrayList<IHCGuidelineDetailVO>();

			if (iHCGuidelineDetailVOs != null) {
				for (int i = 0; i < iHCGuidelineDetailVOs.length; i++) {					
					if (iHCGuidelineDetailVOs[i].getIbflag().equals("I")) {
						iHCGuidelineDetailVOs[i].setOptmTrspModFlg("Y");
						iHCGuidelineDetailVOs[i].setCreUsrId(account.getUsr_id());
						iHCGuidelineDetailVOs[i].setUpdUsrId(account.getUsr_id());
						insertSheetVoList.add(iHCGuidelineDetailVOs[i]);
					} else if (iHCGuidelineDetailVOs[i].getIbflag().equals("U")) {
						iHCGuidelineDetailVOs[i].setUpdUsrId(account.getUsr_id());
						updateSheetVoList.add(iHCGuidelineDetailVOs[i]);
					} else if (iHCGuidelineDetailVOs[i].getIbflag().equals("D")) {
						deleteSheetVoList.add(iHCGuidelineDetailVOs[i]);
					}
				}
			}

			if (insertSheetVoList.size() > 0) {
				dao.addUsIHCGuidelineDetail(insertSheetVoList);
			}

			if (updateSheetVoList.size() > 0) {
				dao.modifyUsIHCGuidelineDetail(updateSheetVoList);
			}

			if (deleteSheetVoList.size() > 0) {
				dao.removeIHCGuidelineDetail(deleteSheetVoList);
			}

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * ESM_PRI_7031_01, ESM_PRI_7031_02 : Retrieve sheet <br>
	 * Retrieve Inland SVC Mode data for US<br>
	 * 
	 * @param SearchUsInlandServiceModeTotalVO searchUsInlandServiceModeTotalVO
	 * @return List<SearchUsInlandServiceModeTotalVO>
	 * @exception EventException
	 */
	public List<SearchUsInlandServiceModeTotalVO> searchUsInlandServiceModeTotal(SearchUsInlandServiceModeTotalVO searchUsInlandServiceModeTotalVO) throws EventException {
		try {
			return dao.searchUsInlandServiceModeTotal(searchUsInlandServiceModeTotalVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * ESM_PRI_7033 : Route Retrieve  <br>
	 * Route Retrieve <br>
	 * 
	 * @param IHCGuidelineDetailVO iHCGuidelineDetailVO
	 * @return List<IHCGuidelineDetailVO>
	 * @exception EventException
	 */
	public List<IHCGuidelineDetailVO> searchUsRailIHCGuidelineDetail(IHCGuidelineDetailVO iHCGuidelineDetailVO) throws EventException {
		try {
			return dao.searchUsRailIHCGuidelineDetail(iHCGuidelineDetailVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * ESM_PRI_7033 : Apply to Tariff <br>
	 * Update Rate data<br>
	 * 
	 * @param IHCGuidelineDetailVO [] iHCGuidelineDetailVOs
	 * @param SignOnUserAccount account
	 * @return void
	 * @exception EventException
	 */
	public void manageUsRailIHCGuidelineDetail(IHCGuidelineDetailVO[] iHCGuidelineDetailVOs, SignOnUserAccount account)	throws EventException {
		// TODO Auto-generated method stub
		try {
			List<IHCGuidelineDetailVO> updateSheetVoList = new ArrayList<IHCGuidelineDetailVO>();
			if (iHCGuidelineDetailVOs != null) {
				for (int i = 0; i < iHCGuidelineDetailVOs.length; i++) {					
					if (!iHCGuidelineDetailVOs[i].getIbflag().equals("D")) {
						iHCGuidelineDetailVOs[i].setUpdUsrId(account.getUsr_id());
						updateSheetVoList.add(iHCGuidelineDetailVOs[i]);
					}
				}
			}

			if (updateSheetVoList.size() > 0) {
				dao.modifyUsRailIHCGuidelineDetail(updateSheetVoList);
			}

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * ESM_PRI_7033 : Check  <br>
	 * Check Point - Base port pair <br>
	 * 
	 * @param IHCGuidelineDetailVO [] iHCGuidelineDetailVOs
	 * @return List<IHCGuidelineDetailVO>
	 * @exception EventException
	 */
	public List<IHCGuidelineDetailVO> checkUsRailIHCGuidelineDetail(IHCGuidelineDetailVO[] iHCGuidelineDetailVOs) throws EventException {
		List<IHCGuidelineDetailVO> rsltlist = new ArrayList<IHCGuidelineDetailVO>();
		List<IHCGuidelineDetailVO> list = null;
		
		try {
			if (iHCGuidelineDetailVOs != null) {
				for(int i=0; i<iHCGuidelineDetailVOs.length; i++){
					if (!iHCGuidelineDetailVOs[i].getIbflag().equals("D")) {
						list = dao.checkUsRailIHCGuidelineDetail(iHCGuidelineDetailVOs[i]);											
						if(list.size() == 0){		
							list.add(iHCGuidelineDetailVOs[i]);				
							rsltlist.addAll(list);
						}
					}
				}
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return rsltlist;
	}
	
	/**
	 * ESM_PRI_7034 : Retrieve <br>
	 * Retrieve Inland add-on inquiry in local currency (TRO) <br>
	 * 
	 * @param SearchUsTariffInquiryListVO searchUsTariffInquiryListVO
	 * @return List<SearchUsTariffInquiryListVO>
	 * @exception EventException
	 */
	public List<SearchUsTariffInquiryListVO> searchUsTariffInquiryList(SearchUsTariffInquiryListVO searchUsTariffInquiryListVO) throws EventException {
		try {
			return dao.searchUsTariffInquiryList(searchUsTariffInquiryListVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * ESM_PRI_7031 : Confirm <br>
	 * validation check 1 - total value is 0 <br>
	 * 
	 * @param IHCGuidelineMainVO iHCGuidelineMainVO
	 * @return List<SearchUsInlandServiceModeTotalVO>
	 * @exception EventException
	 */
	public List<SearchUsInlandServiceModeTotalVO> checkUsIHCTariffTotal(IHCGuidelineMainVO iHCGuidelineMainVO) throws EventException {
		try {
			return dao.checkUsIHCTariffTotal(iHCGuidelineMainVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * ESM_PRI_7031 : Confirm <br>
	 * validation check 2 - rate tariff tuning or not <br>
	 * 
	 * @param IHCGuidelineMainVO iHCGuidelineMainVO
	 * @return List<SearchUsInlandServiceModeTotalVO>
	 * @exception EventException
	 */
	public List<SearchUsInlandServiceModeTotalVO> checkUsIHCTariffTuning(IHCGuidelineMainVO iHCGuidelineMainVO) throws EventException {
		try {
			return dao.checkUsIHCTariffTuning(iHCGuidelineMainVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * ESM_PRI_7001_02 : Save  <br>
	 * Check Add RF IHC GuidelineDetail <br>
	 * 
	 * @param IHCGuidelineDetailVO[] iHCGuidelineDetailVOs
	 * @return List<IHCGuidelineDetailVO>
	 * @exception EventException
	 */
	public List<IHCGuidelineDetailVO> checkAddRFIHCGuidelineDetail(IHCGuidelineDetailVO[] iHCGuidelineDetailVOs) throws EventException {
		List<IHCGuidelineDetailVO> rsltlist = new ArrayList<IHCGuidelineDetailVO>();
		List<IHCGuidelineDetailVO> list = null;
		
		try {
			if (iHCGuidelineDetailVOs != null) {
				for(int i=0; i<iHCGuidelineDetailVOs.length; i++){
					if (!iHCGuidelineDetailVOs[i].getIbflag().equals("D")) {
						list = dao.checkAddRFIHCGuidelineDetail(iHCGuidelineDetailVOs[i]);											
						if(list.size() == 0){		
							list.add(iHCGuidelineDetailVOs[i]);				
							rsltlist.addAll(list);
						}
					}
				}
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return rsltlist;
	}
	
	/**
	 * ESM_PRI_7035 : Delete from Tariff <br>
	 * Delete US Route<br>
	 * 
	 * @param IHCGuidelineDetailVO [] iHCGuidelineDetailVOs
	 * @param SignOnUserAccount account
	 * @return void
	 * @exception EventException
	 */
	public void manageUsRoute(IHCGuidelineDetailVO[] iHCGuidelineDetailVOs, SignOnUserAccount account) throws EventException {
		try {
			List<IHCGuidelineDetailVO> updateSheetVoList = new ArrayList<IHCGuidelineDetailVO>();
			List<IHCGuidelineDetailVO> deleteSheetVoList = new ArrayList<IHCGuidelineDetailVO>();

			if (iHCGuidelineDetailVOs != null) {
				for (int i = 0; i < iHCGuidelineDetailVOs.length; i++) {					
					if (iHCGuidelineDetailVOs[i].getIbflag().equals("I")) {
						if(iHCGuidelineDetailVOs[i].getAmdtSeq().equals("0")){
							deleteSheetVoList.add(iHCGuidelineDetailVOs[i]);
						}else{
							iHCGuidelineDetailVOs[i].setUpdUsrId(account.getUsr_id());
							updateSheetVoList.add(iHCGuidelineDetailVOs[i]);
						}
					}
				}
			}

			if (updateSheetVoList.size() > 0) {
				dao.modifyUSRoute(updateSheetVoList);
			}

			if (deleteSheetVoList.size() > 0) {
				dao.removeUSRoute(deleteSheetVoList);
			}

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	
	/**
	 * ESM_PRI_7014 : MULTI  <br>
	 * IHC Guideline Creation / Amend Load Excel <br>
	 * @param IHCDetailVO ihcDetailVO
	 * @param PriTrfIHCRtVO[] priTrfIHCRtVOs
	 * @return String
	 * @throws EventException
	 */
	public String uploadIHCCreation(IHCDetailVO ihcDetailVO, PriTrfIHCRtVO[] priTrfIHCRtVOs) throws EventException {
		BackEndJobManager backEndJobManager = new BackEndJobManager();
		IHCGuideLineUpload7014BackEndJob backEndJob = new IHCGuideLineUpload7014BackEndJob();
		try {
			backEndJob.setIHCDetailVO(ihcDetailVO);
			backEndJob.setPriTrfIHCRtVOs(priTrfIHCRtVOs);
			
			return backEndJobManager.execute(backEndJob, ihcDetailVO.getCreUsrId(), "IHC Tariff Creation - Load Excel ");

		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * ESM_PRI_7014 : SEARCH01  <br>
	 * IHC Guideline Creation / Amend Load Excel <br>
	 * IHC의 Status를 확인한다.
	 * @param IHCDetailVO ihcDetailVO
	 * @return String
	 * @throws EventException
	 */
	public String searchIHCStatus(IHCDetailVO ihcDetailVO) throws EventException {
		try {

			return dao.searchIHCStatus(ihcDetailVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * ESM_PRI_7014 : SEARCH  <br>
	 * IHC Guideline Creation / Amend Load Excel <br>
	 * loc_cd 중복체크
	 * @param PriTrfIHCRtVO[] priTrfIHCRtVOs
	 * @return List<String>
	 * @throws EventException
	 */
	public List<String> uploadIHCCreationCheck(PriTrfIHCRtVO[] priTrfIHCRtVOs) throws EventException { 
		try {
			Set<String> set = new HashSet<String>();
			List<String> rsltLists = new ArrayList<String>();
			if (priTrfIHCRtVOs != null) {
				for (PriTrfIHCRtVO priTrfIHCRtVO : priTrfIHCRtVOs) {
					set.add(priTrfIHCRtVO.getBsePortLocCd());
					set.add(priTrfIHCRtVO.getPntLocCd());
					set.add(priTrfIHCRtVO.getHubLocCd());
				}
				Object[] obj = set.toArray();
				for (int i = 0; i < obj.length; i++) {
					if (!dao.checkLocList(String.valueOf(obj[i]), priTrfIHCRtVOs[0].getSvcScpCd(), priTrfIHCRtVOs[0].getOrgDestTpCd())) {
						rsltLists.add(String.valueOf(obj[i]));
					}
				}
			}
			return rsltLists;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}

	}
}