/*=========================================================
 *Copyright(c) 2012 CyberLogitec
 *@FileName : FeederChargeGuideLineBC.java
 *@FileTitle : Tariff Code Creation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.5.08
 *@LastModifier : 이은섭
 *@LastVersion : 1.0
 * 2012.5.08 이은섭
 * 1.0 Creation
 * 2013.07.31 [CHM-201326002] 전윤주 DG Service flag가 'Y' 인 경우에만 버튼 색을 파란색으로 표시 
 *                           DG Service flag check 메서드 추가
 *2013.03.16 [CHM-201534279] 전지예 Pricing Feeder/IHC tariff 45" 칼럼 추가 안
=========================================================*/

package com.hanjin.apps.alps.esm.pri.tariff.feederchargeguideline.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.hanjin.apps.alps.esm.pri.tariff.feederchargeguideline.integration.FeederChargeGuideLineDBDAO;
import com.hanjin.apps.alps.esm.pri.tariff.feederchargeguideline.vo.ComboFdrRhqCdListVO;
import com.hanjin.apps.alps.esm.pri.tariff.feederchargeguideline.vo.FDRDGSurchargeVO;
import com.hanjin.apps.alps.esm.pri.tariff.feederchargeguideline.vo.FDRDetailVO;
import com.hanjin.apps.alps.esm.pri.tariff.feederchargeguideline.vo.FDRMainVO;
import com.hanjin.apps.alps.esm.pri.tariff.feederchargeguideline.vo.FDRProgVO;
import com.hanjin.apps.alps.esm.pri.tariff.feederchargeguideline.vo.SearchFDRAmendmentHistoryDetailVO;
import com.hanjin.apps.alps.esm.pri.tariff.feederchargeguideline.vo.SearchFDRAmendmentHistoryMainVO;
import com.hanjin.apps.alps.esm.pri.tariff.feederchargeguideline.vo.SearchTariffInquiryVO;
import com.hanjin.apps.alps.esm.pri.tariff.feederchargeguideline.vo.TariffInquiryListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.CheckUtils;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriTrfFdrRtVO;

/**
 * Business Logic Basic Command implementation<br>
 * 비지니스 로직을 처리한다.<br>
 * 
 * @author LEE EUN-SUP
 * @see FeederChargeGuideLineDBDAO 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class FeederChargeGuideLineBCImpl extends BasicCommandSupport implements FeederChargeGuideLineBC {
	private FeederChargeGuideLineDBDAO dao = null;

	/**
	 * FeederChargeGuideLineBCImpl 객체 생성<br>
	 * FeederChargeGuideLineDBDAO를 생성한다.<br>
	 */
	public FeederChargeGuideLineBCImpl() {
		dao = new FeederChargeGuideLineDBDAO();
	}

	/**
	 *  ESM_PRI_7003_01, ESM_PRI_7003_02 : Feeder/IHC Tariff Inquiry
	 * 
	 * @param searchTariffInquiryVO
	 * @return List<TariffInquiryListVO>
	 * @throws EventException
	 */
	public List<TariffInquiryListVO> searchTariffInquiryList(SearchTariffInquiryVO searchTariffInquiryVO) throws EventException {
		try {
			return dao.searchTariffInquiryList(searchTariffInquiryVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 *  ESM_PRI_7003_01, ESM_PRI_7003_02 : Feeder/IHC Tariff Inquiry - 버튼 색 표시를 위한 조회
	 * 
	 * @param tariffInquiryListVO
	 * @return List<TariffInquiryListVO>
	 * @throws EventException
	 */
	public List<TariffInquiryListVO> searchTariffInquiryAddOnDgFlag(TariffInquiryListVO tariffInquiryListVO) throws EventException {
		try {
			return dao.searchTariffInquiryAddOnDgFlag(tariffInquiryListVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * ESM_PRI_7011 : Retrieve form <br>
	 * Retrieve form data <br>
	 * 
	 * @param FDRMainVO fDRMainVO
	 * @return List<FDRMainVO>
	 * @exception EventException
	 */
	public List<FDRMainVO> searchFDRMain(FDRMainVO fDRMainVO) throws EventException {
		try {
			return dao.searchFDRMain(fDRMainVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * ESM_PRI_7011 : Retrieve sheet <br>
	 * Retrieve sheet data <br>
	 * 
	 * @param FDRMainVO fDRMainVO
	 * @return List<IHCGuidelineDetailVO>
	 * @exception EventException
	 */
	public List<FDRDetailVO> searchFDRDetail(FDRMainVO fDRMainVO) throws EventException {
		try {
			return dao.searchFDRDetail(fDRMainVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * ESM_PRI_7011 : Save <br>
	 * Save data <br>
	 * 
	 * @param FDRMainVO fDRMainVO
	 * @param FDRDetailVO[] fDRDetailVOs
	 * @param SignOnUserAccount account
	 * @return void
	 * @exception EventException
	 */
	public void manageFDR(FDRMainVO fDRMainVO, FDRDetailVO[] fDRDetailVOs, SignOnUserAccount account) throws EventException {
		// TODO Auto-generated method stub
		try {
		    List<FDRDetailVO> insertSheetVoList = new ArrayList<FDRDetailVO>();
			List<FDRDetailVO> updateSheetVoList = new ArrayList<FDRDetailVO>();
			List<FDRDetailVO> deleteSheetVoList = new ArrayList<FDRDetailVO>();

			// Main effective date
			if (fDRMainVO != null && fDRMainVO.getAmdtSeq().equals("0")) {
				fDRMainVO.setUpdUsrId(account.getUsr_id());
				dao.modifyFDRMain(fDRMainVO);
				dao.modifyFDRTariffDuration(fDRMainVO);
			}

			if (fDRDetailVOs != null) {
				for (int i = 0; i < fDRDetailVOs.length; i++) {
					if (fDRDetailVOs[i].getIbflag().equals("I")) {
						fDRDetailVOs[i].setUpdUsrId(account.getUsr_id());
						fDRDetailVOs[i].setCreUsrId(account.getUsr_id());
						insertSheetVoList.add(fDRDetailVOs[i]);
					} else if (fDRDetailVOs[i].getIbflag().equals("U")) {
						fDRDetailVOs[i].setUpdUsrId(account.getUsr_id());
						updateSheetVoList.add(fDRDetailVOs[i]);
					} else if (fDRDetailVOs[i].getIbflag().equals("D")) {
						deleteSheetVoList.add(fDRDetailVOs[i]);
					}
				}
			}	

			if (insertSheetVoList.size() > 0) {
				dao.addFDRDetail(insertSheetVoList);
			}
			
			if (updateSheetVoList.size() > 0) {
				dao.modifyFDRDetail(updateSheetVoList);
			}

			if (deleteSheetVoList.size() > 0) {
				dao.removeFDRDetail(deleteSheetVoList);
			}

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * ESM_PRI_7011 : Confirm <br>
	 * Confirm <br>
	 * 
	 * @param FDRMainVO fDRMainVO
	 * @param FDRProgVO fDRProgVO
	 * @param SignOnUserAccount account
	 * @return void
	 * @exception EventException
	 */
	public void confirmFDR(FDRMainVO fDRMainVO, FDRProgVO fDRProgVO, SignOnUserAccount account) throws EventException {
		// TODO Auto-generated method stub
		try {
			if (fDRMainVO != null && fDRProgVO != null) {
				fDRMainVO.setUpdUsrId(account.getUsr_id());
				fDRMainVO.setCfmOfcCd(account.getOfc_cd());
				fDRMainVO.setCfmUsrId(account.getUsr_id());
				fDRProgVO.setCreUsrId(account.getUsr_id());
				fDRProgVO.setProgUsrId(account.getUsr_id());
				fDRProgVO.setUpdUsrId(account.getUsr_id());

				if (fDRMainVO.getAmdtSeq().equals("0")) {
					dao.modifyFDRTariffDurationConfirm(fDRMainVO);
					dao.modifyFDRMainConfirmBefTrf(fDRMainVO);
				}
				dao.modifyFDRMainConfirmCur(fDRMainVO);
				dao.addFDRMainProgress(fDRProgVO);
				dao.modifyFDRMainConfirmBef(fDRMainVO);
			}

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * ESM_PRI_7011 : Cancel <br>
	 * Cancel <br>
	 * 
	 * @param FDRMainVO fDRMainVO
	 * @param SignOnUserAccount account
	 * @return void
	 * @exception EventException
	 */
	public void cancelFDR(FDRMainVO fDRMainVO, SignOnUserAccount account) throws EventException {
		// TODO Auto-generated method stub
		try {
			dao.removeFDRTariffDuration(fDRMainVO);
			dao.removeFDRProgress(fDRMainVO);
			dao.removeFDRDetailAll(fDRMainVO);
			dao.removeFDRMain(fDRMainVO);

			fDRMainVO.setUpdUsrId(account.getUsr_id());

			// Amend Seq. == 0 && FIC_PROP_STS_CD = I
			if (fDRMainVO.getAmdtSeq().equals("0") && fDRMainVO.getFicPropStsCd().equals("I")) {
				dao.removeFDRCostVerMapg(fDRMainVO);
				dao.removeFDRHeader(fDRMainVO);
			} else {
				dao.modifyFDRMainCancel(fDRMainVO);
			}

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * ESM_PRI_7011 : Amend <br>
	 * Amend <br>
	 * 
	 * @param FDRMainVO fDRMainVO
	 * @param FDRProgVO fDRProgVO
	 * @param SignOnUserAccount account
	 * @return void
	 * @exception EventException
	 */
	public void amendFDR(FDRMainVO fDRMainVO, FDRProgVO fDRProgVO, SignOnUserAccount account) throws EventException {
		// TODO Auto-generated method stub
		try {
			if (fDRMainVO != null && fDRProgVO != null) {
				fDRMainVO.setUpdUsrId(account.getUsr_id());
				fDRMainVO.setCreUsrId(account.getUsr_id());

				fDRProgVO.setCreUsrId(account.getUsr_id());
				fDRProgVO.setProgUsrId(account.getUsr_id());
				fDRProgVO.setUpdUsrId(account.getUsr_id());
				fDRProgVO.setFicPropStsCd("I");
				fDRProgVO.setAmdtSeq(fDRMainVO.getTobeAmdtSeq());
				dao.addFDRMainAmend(fDRMainVO);
				dao.addFDRMainProgress(fDRProgVO);
				dao.addFDRDetailAmend(fDRMainVO);
				dao.addFDRTariffDurationAmend(fDRMainVO);
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * ESM_PRI_7011 : Confirm <br>
	 * Retrieve pre version eff_dt <br>
	 * 
	 * @param FDRMainVO fDRMainVO
	 * @return List<FDRMainVO>
	 * @exception EventException
	 */
	public List<FDRMainVO> checkPreFDR(FDRMainVO fDRMainVO) throws EventException {
		try {
			return dao.checkPreFDR(fDRMainVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * ESM_PRI_7011 : Amend <br>
	 * Retrieve MAX COST_TRF_NO <br>
	 * 
	 * @param FDRMainVO fDRMainVO
	 * @return List<FDRMainVO>
	 * @exception EventException
	 */
	public List<FDRMainVO> checkMaxCostTrfNoFDR(FDRMainVO fDRMainVO) throws EventException {
		try {
			return dao.checkMaxCostTrfNoFDR(fDRMainVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * ESM_PRI_7013 : EUR Add-on Guideline Creation / Amend – Load Excel <br>
	 * 
	 * @param fDRMainVOs
	 * @throws EventException
	 */
	public void uploadAddonCreation(FDRDetailVO inFdrDetailVO, PriTrfFdrRtVO[] priTrfFdrRtVOs) throws EventException {
		try {

			List<PriTrfFdrRtVO> dbList = dao.searchFDRList(inFdrDetailVO);
			Map<String, PriTrfFdrRtVO> dbListMap = new HashMap<String, PriTrfFdrRtVO>();
			for (PriTrfFdrRtVO priTrfFdrRtVO : dbList) {
				dbListMap.put(priTrfFdrRtVO.getPntLocCd() + priTrfFdrRtVO.getBsePortLocCd(), priTrfFdrRtVO);
			}

			FDRMainVO fdrMainVO = new FDRMainVO();
			fdrMainVO.setSvcScpCd(inFdrDetailVO.getSvcScpCd());
			fdrMainVO.setFdrTrfNo(inFdrDetailVO.getFdrTrfNo());
			fdrMainVO.setAmdtSeq(inFdrDetailVO.getAmdtSeq());
			fdrMainVO.setOrgDestTpCd(inFdrDetailVO.getOrgDestTpCd());
			dao.removeFDRDetailAll(fdrMainVO);

			Map<String, PriTrfFdrRtVO> map = new HashMap<String, PriTrfFdrRtVO>();
			String[] sort = new String[priTrfFdrRtVOs.length];
			int x = 0;
			for (PriTrfFdrRtVO priTrfFdrRtVO : priTrfFdrRtVOs) {
				if (CheckUtils.isInBlank(priTrfFdrRtVO.getPntLocCd()) || CheckUtils.isInBlank(priTrfFdrRtVO.getBsePortLocCd())) {
					continue;
				}
				priTrfFdrRtVO.setSvcScpCd(inFdrDetailVO.getSvcScpCd());
				priTrfFdrRtVO.setFdrTrfNo(inFdrDetailVO.getFdrTrfNo());
				priTrfFdrRtVO.setAmdtSeq(inFdrDetailVO.getAmdtSeq());
				priTrfFdrRtVO.setCreUsrId(inFdrDetailVO.getCreUsrId());
				priTrfFdrRtVO.setUpdUsrId(inFdrDetailVO.getUpdUsrId());
				priTrfFdrRtVO.setOrgDestTpCd(inFdrDetailVO.getOrgDestTpCd());
				map.put(priTrfFdrRtVO.getPntLocCd() + priTrfFdrRtVO.getBsePortLocCd(), priTrfFdrRtVO);
				sort[x++] = priTrfFdrRtVO.getPntLocCd() + priTrfFdrRtVO.getBsePortLocCd();
			}

			Arrays.sort(sort);
			for (int i = 0; i < sort.length; i++) {
				PriTrfFdrRtVO inPriTrfFdrRtVO = dbListMap.get(sort[i]);
				if (inPriTrfFdrRtVO == null) {
					inPriTrfFdrRtVO = new PriTrfFdrRtVO();
					inPriTrfFdrRtVO.setPntLocCd(map.get(sort[i]).getPntLocCd());
					inPriTrfFdrRtVO.setBsePortLocCd(map.get(sort[i]).getBsePortLocCd());
					inPriTrfFdrRtVO.setRhqCd(map.get(sort[i]).getRhqCd());					
				}
				inPriTrfFdrRtVO.setRcvDeTermCd(map.get(sort[i]).getRcvDeTermCd());
				inPriTrfFdrRtVO.setSvcScpCd(map.get(sort[i]).getSvcScpCd());
				inPriTrfFdrRtVO.setFdrTrfNo(map.get(sort[i]).getFdrTrfNo());
				inPriTrfFdrRtVO.setAmdtSeq(map.get(sort[i]).getAmdtSeq());
				inPriTrfFdrRtVO.setRtSeq(String.valueOf(i + 1));
				inPriTrfFdrRtVO.setGline20ftFrtRtAmt(map.get(sort[i]).getGline20ftFrtRtAmt());
				inPriTrfFdrRtVO.setGline40ftFrtRtAmt(map.get(sort[i]).getGline40ftFrtRtAmt());
				inPriTrfFdrRtVO.setGline45ftFrtRtAmt(map.get(sort[i]).getGline45ftFrtRtAmt());	// Dry 45' Cost 추가
				inPriTrfFdrRtVO.setN1stCmncAmdtSeq("0");
				inPriTrfFdrRtVO.setSrcInfoCd("NW");
				inPriTrfFdrRtVO.setFdrRtRmk(map.get(sort[i]).getFdrRtRmk());
				inPriTrfFdrRtVO.setCreUsrId(map.get(sort[i]).getCreUsrId());
				inPriTrfFdrRtVO.setUpdUsrId(map.get(sort[i]).getUpdUsrId());
				inPriTrfFdrRtVO.setGlineRf20ftFrtRtAmt(map.get(sort[i]).getGlineRf20ftFrtRtAmt());
				inPriTrfFdrRtVO.setGlineRf40ftFrtRtAmt(map.get(sort[i]).getGlineRf40ftFrtRtAmt());
				inPriTrfFdrRtVO.setRcSvcFlg(map.get(sort[i]).getRcSvcFlg());
				inPriTrfFdrRtVO.setOrgDestTpCd(map.get(sort[i]).getOrgDestTpCd());
				inPriTrfFdrRtVO.setLoclCurrCd(map.get(sort[i]).getLoclCurrCd());
				dao.uploadAddonCreation(inPriTrfFdrRtVO);
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * ESM_PRI_7013 : EUR Add-on Guideline Creation / Amend – Load Excel <br>
	 * CHECK 버튼
	 * 
	 * @param PriTrfFdrRtVO[] priTrfFdrRtVOs
	 * @return List<String>
	 * @throws EventException
	 */
	public List<String> uploadAddonCreationCheck(PriTrfFdrRtVO[] priTrfFdrRtVOs) throws EventException {
		try {
			Set<String> set = new HashSet<String>();
			List<String> rsltLists = new ArrayList<String>();
			if (priTrfFdrRtVOs != null) {
				for (PriTrfFdrRtVO priTrfFdrRtVO : priTrfFdrRtVOs) {
					set.add(priTrfFdrRtVO.getBsePortLocCd());
					set.add(priTrfFdrRtVO.getPntLocCd());
				}
				Object[] obj = set.toArray();
				for (int i = 0; i < obj.length; i++) {
					if (!dao.checkLocList(String.valueOf(obj[i]), priTrfFdrRtVOs[0].getSvcScpCd(), priTrfFdrRtVOs[0].getOrgDestTpCd())) {
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

	/**
	 * ESM_PRI_7013 : EUR Add-on Guideline Creation / Amend – Load Excel <br>
	 * 저장전 Feeder Status 조회
	 * 
	 * @param fdrDetailVO
	 * @return String
	 * @throws EventException
	 */
	public String searchFeederStatus(FDRDetailVO fdrDetailVO) throws EventException {
		try {

			return dao.searchFeederStatus(fdrDetailVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * 서비스 코드에 따른 RHQ_CD 조회
	 * 
	 * @param fdrDetailVO
	 * @return List<ComboFdrRhqCdListVO>
	 * @throws EventException
	 */
	public List<ComboFdrRhqCdListVO> comboFdrRhqCdList(FDRDetailVO fdrDetailVO) throws EventException {
		try {
			return dao.comboFdrRhqCdList(fdrDetailVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * ESM_PRI_7013 : EUR Add-on Guideline Creation / Amend – Load Excel <br>
	 * location 코드 존재 여부 체크
	 * 
	 * @param fdrDetailVO
	 * @return int
	 * @throws EventException
	 */
	public int checkLocCode(String locCd) throws EventException {
		try {
			return dao.checkLocCode(locCd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * ESM_PRI_7026 : FDR Tariff Amendment History Main <br>
	 * Retrieve FDR Tariff Amendment History Main <br>
	 * 
	 * @param SearchFDRAmendmentHistoryMainVO searchFDRAmendmentHistoryMainVO
	 * @return List<SearchFDRAmendmentHistoryMainVO>
	 * @exception EventException
	 */
	public List<SearchFDRAmendmentHistoryMainVO> searchFDRAmendmentHistoryMain(SearchFDRAmendmentHistoryMainVO searchFDRAmendmentHistoryMainVO) throws EventException {
		try {
			return dao.searchFDRAmendmentHistoryMain(searchFDRAmendmentHistoryMainVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * ESM_PRI_7026 : Add-on Tariff Amendment History Detail <br>
	 * Retrieve Add-on Tariff Amendment History detail <br>
	 * 
	 * @param SearchFDRAmendmentHistoryDetailVO searchFDRAmendmentHistoryDetailVO
	 * @return List<SearchFDRAmendmentHistoryDetailVO>
	 * @exception EventException
	 */
	public List<SearchFDRAmendmentHistoryDetailVO> searchFDRAmendmentHistoryDetail(SearchFDRAmendmentHistoryDetailVO searchFDRAmendmentHistoryDetailVO) throws EventException {
		try {
			return dao.searchFDRAmendmentHistoryDetail(searchFDRAmendmentHistoryDetailVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * ESM_PRI_7028 : Add-On Tariff Amendment DG Cargo Inquiry <br>
	 * Retrieve Add-On Tariff Amendment DG Cargo Inquiry <br>
	 * 
	 * @param FDRDGSurchargeVO fDRDGSurchargeVO
	 * @return List<FDRDGSurchargeVO>
	 * @exception EventException
	 */
	public List<FDRDGSurchargeVO> searchFDRDGSurcharge(FDRDGSurchargeVO fDRDGSurchargeVO) throws EventException {
		try {
			return dao.searchFDRDGSurcharge(fDRDGSurchargeVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * ESM_PRI_7007 : update max FDR_TRF_NO's exp_dt <br>
	 * PRI_TRF_FDR_MN, PRI_TRF_FDR_DUR
	 * 
	 * @param FDRMainVO[] fDRMainVOs
	 * @param SignOnUserAccount account
	 * @return void
	 * @exception EventException
	 */
	public void confirmFDRExpDt(FDRMainVO[] fDRMainVOs, SignOnUserAccount account) throws EventException {
		// TODO Auto-generated method stub    modifyIHCTariffDurationConfirm
		try {
			if (fDRMainVOs != null) {
				for (int i = 0; i < fDRMainVOs.length; i++) {					
					if (fDRMainVOs[i].getIbflag().equals("I")) {
						fDRMainVOs[i].setUpdUsrId(account.getUsr_id());
						dao.modifyFDRTariffDurationConfirm(fDRMainVOs[i]);
						dao.modifyFDRMainConfirmBefTrf(fDRMainVOs[i]);
					}
				}
			}     
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

}
