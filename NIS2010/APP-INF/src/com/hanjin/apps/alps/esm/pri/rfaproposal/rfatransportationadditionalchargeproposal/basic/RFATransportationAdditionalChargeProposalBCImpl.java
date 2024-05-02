/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : RFATransportationAdditionalChargeProposalBCImpl.java
 *@FileTitle : RFA Proposal Origin/Destination Arbitrary Charge Creation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.18
 *@LastModifier : 김재연
 *@LastVersion : 1.0
 * 2009.05.18 김재연
 * 1.0 Creation
 =========================================================
 * History
 * 2015.11.10 SELCMU/김현경 [CHM-201538112] Tariff 변경시 현 RFA 상 Arbitiary 탭 미반영 로직수정
 * 2015.11.26 SELCMU/김현경 [CHM-201538236] RFA module 승인 절차 간소화 및 기능 개선
 * 2015.12.16 SELCMU/김현경 [CHM-201539304] Arbitrary GL Amt backendjob 으로 전환요청
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfatransportationadditionalchargeproposal.basic;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.PriRpComVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RpScpGlineCopyVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RsltRfaPropCopyVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfatransportationadditionalchargeproposal.integration.RFATransportationAdditionalChargeProposalDBDAO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfatransportationadditionalchargeproposal.vo.ChkFontStyleVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfatransportationadditionalchargeproposal.vo.CstPriRpScpTrspAddChgVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfatransportationadditionalchargeproposal.vo.FicRouteGLineVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfatransportationadditionalchargeproposal.vo.GLineInfoByFICRouteVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfatransportationadditionalchargeproposal.vo.RsltArbChgListVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfatransportationadditionalchargeproposal.vo.RsltPriRpScpTrspAddChgVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfatransportationadditionalchargeproposal.vo.SearchGuidelineRouteInquiryVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfatransportationadditionalchargeproposal.vo.SearchGuidelineRoutePopupListVO;
import com.hanjin.framework.component.backend.core.BackEndJobManager;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriRpMnVO;
import com.hanjin.syscommon.common.table.PriRpScpMnVO;
import com.hanjin.syscommon.common.table.PriRpScpRtCmdtHdrVO;
import com.hanjin.syscommon.common.table.PriRpScpTrspAddChgVO;

/**
 * NIS2010-RFAProposal Business Logic Basic Command implementation<br>
 * - NIS2010-RFAProposal에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author JaeYeon Kim
 * @see ESM_PRI_2003_04EventResponse,RFATransportationAdditionalChargeProposalBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class RFATransportationAdditionalChargeProposalBCImpl extends BasicCommandSupport implements RFATransportationAdditionalChargeProposalBC {

	// Database Access Object
	private transient RFATransportationAdditionalChargeProposalDBDAO dbDao = null;

	/**
	 * SCTransportationAdditionalChargeProposalBCImpl 객체 생성<br>
	 * SCTransportationAdditionalChargeProposalDBDAO를 생성한다.<br>
	 */
	public RFATransportationAdditionalChargeProposalBCImpl() {
		dbDao = new RFATransportationAdditionalChargeProposalDBDAO();
	}

	/**
	 * Arbitrary List를 조회합니다. <br>
	 * 
	 * @param PriRpScpTrspAddChgVO priRpScpTrspAddChgVO
	 * @param boolean addOnFlag
	 * @return List<RsltArbChgListVO>
	 * @exception EventException
	 */
	public List<RsltArbChgListVO> searchArbitraryChargeList(PriRpScpTrspAddChgVO priRpScpTrspAddChgVO, boolean addOnFlag) throws EventException {
		try {
			return dbDao.searchArbitraryChargeList(priRpScpTrspAddChgVO, addOnFlag);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Arbitrary를 수정합니다. <br>
	 * 
	 * @param PriRpScpTrspAddChgVO[] priRpScpTrspAddChgVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageArbitraryCharge(PriRpScpTrspAddChgVO[] priRpScpTrspAddChgVOs, SignOnUserAccount account) throws EventException {
		try {
			List<PriRpScpTrspAddChgVO> insertVoList = new ArrayList<PriRpScpTrspAddChgVO>();
			List<PriRpScpTrspAddChgVO> updateVoList = new ArrayList<PriRpScpTrspAddChgVO>();
			List<PriRpScpTrspAddChgVO> deleteVoList = new ArrayList<PriRpScpTrspAddChgVO>();

			for (int i = 0; i < priRpScpTrspAddChgVOs.length; i++) {
				if (priRpScpTrspAddChgVOs[i].getIbflag().equals("I")) {
					priRpScpTrspAddChgVOs[i].setCreUsrId(account.getUsr_id());
					priRpScpTrspAddChgVOs[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(priRpScpTrspAddChgVOs[i]);
				} else if (priRpScpTrspAddChgVOs[i].getIbflag().equals("U")) {
					priRpScpTrspAddChgVOs[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(priRpScpTrspAddChgVOs[i]);
				} else if (priRpScpTrspAddChgVOs[i].getIbflag().equals("D")) {
					priRpScpTrspAddChgVOs[i].setUpdUsrId(account.getUsr_id());
					deleteVoList.add(priRpScpTrspAddChgVOs[i]);
				}
			}

			if (insertVoList.size() > 0) {
				dbDao.addArbitraryCharge(insertVoList);
			}

			if (updateVoList.size() > 0) {
				dbDao.modifyArbitraryCharge(updateVoList, "N");
			}

			if (deleteVoList.size() > 0) {
				dbDao.removeArbitraryCharge(deleteVoList);
			}
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), de);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), de);
		}
	}

	/**
	 * Arbitrary accept를 실행한다. <br>
	 * 
	 * @param PriRpScpTrspAddChgVO[] priRpScpTrspAddChgVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptArbitraryCharge(PriRpScpTrspAddChgVO[] priRpScpTrspAddChgVOs, SignOnUserAccount account) throws EventException {
		try {
			List<PriRpScpTrspAddChgVO> updateVoList = new ArrayList<PriRpScpTrspAddChgVO>();

			for (int i = 0; priRpScpTrspAddChgVOs != null && i < priRpScpTrspAddChgVOs.length; i++) {
				if (priRpScpTrspAddChgVOs[i].getIbflag().equals("U")) {
					priRpScpTrspAddChgVOs[i].setUpdUsrId(account.getUsr_id());
					priRpScpTrspAddChgVOs[i].setAcptUsrId(account.getUsr_id());
					priRpScpTrspAddChgVOs[i].setAcptOfcCd(account.getOfc_cd());
					String currentDate = new SimpleDateFormat("yyyyMMdd").format(new Date());
					priRpScpTrspAddChgVOs[i].setAcptDt(currentDate);
					updateVoList.add(priRpScpTrspAddChgVOs[i]);
				}
			}

			if (updateVoList.size() > 0) {
				dbDao.modifyArbitraryCharge(updateVoList, "Y");
			}
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), de);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), de);
		}
	}

	/**
	 * Arbitrary Accept Cancel 실행한다. <br>
	 * 
	 * @param PriRpScpTrspAddChgVO[] priRpScpTrspAddChgVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelArbitraryCharge(PriRpScpTrspAddChgVO[] priRpScpTrspAddChgVOs, SignOnUserAccount account) throws EventException {
		try {

			List<PriRpScpTrspAddChgVO> updateVoList = new ArrayList<PriRpScpTrspAddChgVO>();

			for (int i = 0; priRpScpTrspAddChgVOs != null && i < priRpScpTrspAddChgVOs.length; i++) {
				if (priRpScpTrspAddChgVOs[i].getIbflag().equals("U")) {
					priRpScpTrspAddChgVOs[i].setUpdUsrId(account.getUsr_id());
					priRpScpTrspAddChgVOs[i].setFnlFrtRtAmt(null);
					priRpScpTrspAddChgVOs[i].setAcptUsrId("");
					priRpScpTrspAddChgVOs[i].setAcptOfcCd("");
					priRpScpTrspAddChgVOs[i].setAcptDt(null);
					updateVoList.add(priRpScpTrspAddChgVOs[i]);
				}
			}

			if (updateVoList.size() > 0) {
				dbDao.modifyArbitraryCharge(updateVoList, "Y");
			}
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), de);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), de);
		}
	}

	/**
	 * Arbitrary Accept all을 실행한다. <br>
	 * 
	 * @param PriRpScpTrspAddChgVO[] priRpScpTrspAddChgVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptAllArbitraryCharge(PriRpScpTrspAddChgVO[] priRpScpTrspAddChgVOs, SignOnUserAccount account) throws EventException {
		try {

			List<PriRpScpTrspAddChgVO> updateVoList = new ArrayList<PriRpScpTrspAddChgVO>();

			for (int i = 0; priRpScpTrspAddChgVOs != null && i < priRpScpTrspAddChgVOs.length; i++) {
				if (priRpScpTrspAddChgVOs[i].getIbflag().equals("U")) {
					priRpScpTrspAddChgVOs[i].setUpdUsrId(account.getUsr_id());
					priRpScpTrspAddChgVOs[i].setAcptUsrId(account.getUsr_id());
					priRpScpTrspAddChgVOs[i].setAcptOfcCd(account.getOfc_cd());
					String currentDate = new SimpleDateFormat("yyyyMMdd").format(new Date());
					priRpScpTrspAddChgVOs[i].setAcptDt(currentDate);
					updateVoList.add(priRpScpTrspAddChgVOs[i]);
				}
			}

			if (updateVoList.size() > 0) {
				dbDao.modifyArbitraryCharge(updateVoList, "Y");
			}
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), de);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), de);
		}
	}

	/**
	 * Arbitrary Accept Cancel을 실행한다. <br>
	 * 
	 * @param PriRpScpTrspAddChgVO[] priRpScpTrspAddChgVOs
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void cancelAllArbitraryCharge(PriRpScpTrspAddChgVO[] priRpScpTrspAddChgVOs, SignOnUserAccount account) throws EventException {
		try {

			List<PriRpScpTrspAddChgVO> updateVoList = new ArrayList<PriRpScpTrspAddChgVO>();

			for (int i = 0; priRpScpTrspAddChgVOs != null && i < priRpScpTrspAddChgVOs.length; i++) {
				if (priRpScpTrspAddChgVOs[i].getIbflag().equals("U")) {
					priRpScpTrspAddChgVOs[i].setUpdUsrId(account.getUsr_id());
					priRpScpTrspAddChgVOs[i].setFnlFrtRtAmt(null);
					priRpScpTrspAddChgVOs[i].setAcptUsrId("");
					priRpScpTrspAddChgVOs[i].setAcptOfcCd("");
					priRpScpTrspAddChgVOs[i].setAcptDt(null);
					updateVoList.add(priRpScpTrspAddChgVOs[i]);
				}
			}

			if (updateVoList.size() > 0) {
				dbDao.modifyArbitraryCharge(updateVoList, "Y");
			}
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), de);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), de);
		}
	}

	/**
	 * Arbitrary의 Guideline을 Copy 한다. <br>
	 * 
	 * @param CstPriRpScpTrspAddChgVO cstPriRpScpTrspAddChgVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void copyGuidelineArbitraryCharge(CstPriRpScpTrspAddChgVO cstPriRpScpTrspAddChgVO, SignOnUserAccount account) throws EventException {
		try {
			cstPriRpScpTrspAddChgVO.setCreUsrId(account.getUsr_id());
			cstPriRpScpTrspAddChgVO.setUpdUsrId(account.getUsr_id());

			dbDao.addCopyGuidelineArbitraryCharge(cstPriRpScpTrspAddChgVO, account);
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), de);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), de);
		}
	}

	/**
	 * Amend Data를 생성한다.<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void amendProposal(PriRpMnVO priRpMnVO, SignOnUserAccount account) throws EventException {
		try {

			List<PriRpMnVO> insertVoList = new ArrayList<PriRpMnVO>();

			priRpMnVO.setCreUsrId(account.getUsr_id());
			priRpMnVO.setUpdUsrId(account.getUsr_id());
			insertVoList.add(priRpMnVO);

			dbDao.addArbitraryChargeAmend(insertVoList);

		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), de);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), de);
		}
	}

	/**
	 * RFA Proposal Scope Transportation Additional Charge 정보를 Copy 합니다.<br>
	 * 
	 * @param RsltRfaPropCopyVO rsltRfaPropCopyVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void copyProposalScopeTransport(RsltRfaPropCopyVO rsltRfaPropCopyVO, SignOnUserAccount account) throws EventException {
		try {
			rsltRfaPropCopyVO.setCreUsrId(account.getUsr_id());
			rsltRfaPropCopyVO.setUpdUsrId(account.getUsr_id());
			rsltRfaPropCopyVO.setOfcCd(account.getOfc_cd());
			// PRI_RP_SCP_TRSP_ADD_CHG COPY
			dbDao.addCopyProposalScopeTransport(rsltRfaPropCopyVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Guideline Origin/Destination Arbitrary 를 Proposal 로 Copy 합니다.<br>
	 * 
	 * @param RpScpGlineCopyVO rpScpGlineCopyVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void copyScopeGuidelineArbitrary(RpScpGlineCopyVO rpScpGlineCopyVO, SignOnUserAccount account) throws EventException {
		try {
			rpScpGlineCopyVO.setCreUsrId(account.getUsr_id());
			rpScpGlineCopyVO.setUpdUsrId(account.getUsr_id());
			// PRI_SP_SCP_TRSP_ADD_CHG COPY
			dbDao.addCopyScopeGuidelineArbitrary(rpScpGlineCopyVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Guideline Copy 할 대상이 존재하는지 조회를 합니다. <br>
	 * 
	 * @param CstPriRpScpTrspAddChgVO cstPriRpScpTrspAddChgVO
	 * @return boolean
	 * @exception EventException
	 */
	public boolean checkGuidelineArbitraryChargeExist(CstPriRpScpTrspAddChgVO cstPriRpScpTrspAddChgVO) throws EventException {
		try {
			return dbDao.searchGuidelineArbitraryChargeExist(cstPriRpScpTrspAddChgVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Guideline Copy할 데이터의 GROUP LOCATION이 등록되어 있는지 확인한다.<br>
	 * 
	 * @param CstPriRpScpTrspAddChgVO cstPriRpScpTrspAddChgVO
	 * @return boolean
	 * @exception EventException
	 */
	public boolean checkGuidelineArbitraryChargeGroupLocationExist(CstPriRpScpTrspAddChgVO cstPriRpScpTrspAddChgVO) throws EventException {
		try {
			return dbDao.searchGuidelineArbitraryChargeGroupLocationExist(cstPriRpScpTrspAddChgVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Request Cancel시 Main Duration의 Accepted 데이터를 일괄 Init 으로 변경합니다.<br>
	 * 
	 * @param PriRpScpMnVO[] priRpScpMnVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalRequestCancel(PriRpScpMnVO[] priRpScpMnVOs, SignOnUserAccount account) throws EventException {
		try {
			List<PriRpScpMnVO> updateVoList = new ArrayList<PriRpScpMnVO>();

			for (int i = 0; priRpScpMnVOs != null && i < priRpScpMnVOs.length; i++) {
				priRpScpMnVOs[i].setUpdUsrId(account.getUsr_id());
				updateVoList.add(priRpScpMnVOs[i]);
			}
			if (updateVoList.size() > 0) {
				dbDao.modifyProposalRequestCancel(updateVoList);
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Main의 Init 상태를 Cancel시 해당 Amend Seq NO.의 모든 데이터를 삭제합니다.<br>
	 * 
	 * @param PriRpScpMnVO priRpScpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposal(PriRpScpMnVO priRpScpMnVO, SignOnUserAccount account) throws EventException {
		try {
			dbDao.removeProposal(priRpScpMnVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * 엑셀파일을 업로드합니다.<br>
	 * 
	 * @param PriRpScpTrspAddChgVO[] priRpScpTrspAddChgVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void uploadArbitraryChargeProposal(PriRpScpTrspAddChgVO[] priRpScpTrspAddChgVOs, SignOnUserAccount account) throws EventException {
		try {
			List<PriRpScpTrspAddChgVO> insertVoList = new ArrayList<PriRpScpTrspAddChgVO>();

			for (int i = 0; i < priRpScpTrspAddChgVOs.length; i++) {
				if (priRpScpTrspAddChgVOs[i].getIbflag().equals("I")) {
					priRpScpTrspAddChgVOs[i].setCreUsrId(account.getUsr_id());
					priRpScpTrspAddChgVOs[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(priRpScpTrspAddChgVOs[i]);
				}
			}

			if (insertVoList.size() > 0) {
				dbDao.addArbitraryExcel(insertVoList);
			}

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * 엑셀파일을 체크합니다.
	 * 
	 * @param RsltPriRpScpTrspAddChgVO[] rsltPriRpScpTrspAddChgVOs
	 * @return List<RsltPriRpScpTrspAddChgVO>
	 * @exception EventException
	 */
	public List<RsltPriRpScpTrspAddChgVO> searchCodeCheckResult(RsltPriRpScpTrspAddChgVO[] rsltPriRpScpTrspAddChgVOs) throws EventException {
		try {
			List<RsltPriRpScpTrspAddChgVO> checkVoList = new ArrayList<RsltPriRpScpTrspAddChgVO>();
			List<RsltCdListVO> cdList = new ArrayList<RsltCdListVO>();
			RsltCdListVO vo = new RsltCdListVO();
			// String custDefCd = "";

			for (int i = 0; i < rsltPriRpScpTrspAddChgVOs.length; i++) {
				RsltPriRpScpTrspAddChgVO priRpScpTrspAddChgVO = (RsltPriRpScpTrspAddChgVO) ((RsltPriRpScpTrspAddChgVO) rsltPriRpScpTrspAddChgVOs[i]).clone();
				// Point
				vo.setCd(priRpScpTrspAddChgVO.getRoutPntLocDefCd());
				cdList = dbDao.searchExcelCodeList(vo, "LOC");
				if (cdList != null && cdList.size() > 0) {
					rsltPriRpScpTrspAddChgVOs[i].setRoutPntLocDefCd("1");
				} else {
					rsltPriRpScpTrspAddChgVOs[i].setRoutPntLocDefCd("0");
				}

				// Base Port
				vo.setCd(priRpScpTrspAddChgVO.getBsePortDefCd());
				vo.setSvcScpCd(priRpScpTrspAddChgVO.getSvcScpCd());
				vo.setPropNo(priRpScpTrspAddChgVO.getPropNo());
				vo.setAmdtSeq(priRpScpTrspAddChgVO.getAmdtSeq());
				if (vo.getCd().length() == 4) {
					cdList = dbDao.searchExcelCodeList(vo, "GRP");
				} else {
					cdList = dbDao.searchExcelCodeList(vo, "LOC");
				}

				if (cdList != null && cdList.size() > 0) {
					rsltPriRpScpTrspAddChgVOs[i].setBsePortDefCd("1");
				} else {
					rsltPriRpScpTrspAddChgVOs[i].setBsePortDefCd("0");
				}

				vo.setEtc1(priRpScpTrspAddChgVO.getAddChgTpCd());
				vo.setEtc2(priRpScpTrspAddChgVO.getOrgDestTpCd());
				vo.setEtc3(priRpScpTrspAddChgVO.getBsePortTpCd());
				vo.setEtc4(priRpScpTrspAddChgVO.getBsePortDefCd());
				vo.setEtc5(priRpScpTrspAddChgVO.getRoutPntLocTpCd());
				vo.setEtc6(priRpScpTrspAddChgVO.getRoutPntLocDefCd());
				vo.setEtc7(priRpScpTrspAddChgVO.getRatUtCd());
				vo.setEtc8(priRpScpTrspAddChgVO.getPrcCgoTpCd());
				vo.setEtc9(priRpScpTrspAddChgVO.getPrcTrspModCd());
				vo.setEtc10(priRpScpTrspAddChgVO.getRcvDeTermCd());

				cdList = dbDao.searchExcelCodeList(vo, "ARBI_DUP");
				if (cdList != null && cdList.size() > 0) {
					rsltPriRpScpTrspAddChgVOs[i].setRoutPntLocDefCd("0");
					rsltPriRpScpTrspAddChgVOs[i].setRoutPntLocDefDesc("0");
					rsltPriRpScpTrspAddChgVOs[i].setRcvDeTermCd("0");
					rsltPriRpScpTrspAddChgVOs[i].setBsePortDefCd("0");
					rsltPriRpScpTrspAddChgVOs[i].setPrcTrspModCd("0");
					rsltPriRpScpTrspAddChgVOs[i].setRatUtCd("0");
					rsltPriRpScpTrspAddChgVOs[i].setPrcCgoTpCd("0");
				}

				checkVoList.add(rsltPriRpScpTrspAddChgVOs[i]);
			}

			return checkVoList;

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Arbitrary의 ORIGIN과 DESTINATION의 FONT STYLE를 조회합니다. <br>
	 * 
	 * @param CstPriRpScpTrspAddChgVO cstPriRpScpTrspAddChgVO
	 * @return List<ChkFontStyleVO>
	 * @exception EventException
	 */
	public List<ChkFontStyleVO> checkFontStyle(CstPriRpScpTrspAddChgVO cstPriRpScpTrspAddChgVO) throws EventException {
		try {
			return dbDao.searchFontStyle(cstPriRpScpTrspAddChgVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Arbitrary Amend History 리스트를 조회합니다. <br>
	 * 
	 * @param PriRpScpTrspAddChgVO priRpScpTrspAddChgVO
	 * @return List<RsltArbChgListVO>
	 * @exception EventException
	 */
	public List<RsltArbChgListVO> searchArbitraryChargeHistoryList(PriRpScpTrspAddChgVO priRpScpTrspAddChgVO) throws EventException {
		try {
			return dbDao.searchArbitraryChargeHistoryList(priRpScpTrspAddChgVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Arbitrary의 ORIGIN과 DESTINATION의 FONT STYLE를 조회합니다. <br>
	 * 
	 * @param CstPriRpScpTrspAddChgVO cstPriRpScpTrspAddChgVO
	 * @return List<ChkFontStyleVO>
	 * @exception EventException
	 */
	public List<ChkFontStyleVO> checkHistoryFontStyle(CstPriRpScpTrspAddChgVO cstPriRpScpTrspAddChgVO) throws EventException {
		try {
			return dbDao.searchHistoryFontStyle(cstPriRpScpTrspAddChgVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Arbitrary Inquiry List를 조회합니다. <br>
	 * 
	 * @param PriRpScpTrspAddChgVO priRpScpTrspAddChgVO
	 * @return List<RsltArbChgListVO>
	 * @exception EventException
	 */
	public List<RsltArbChgListVO> searchArbitraryChargeInquiryList(PriRpScpTrspAddChgVO priRpScpTrspAddChgVO) throws EventException {
		try {
			return dbDao.searchArbitraryChargeInquiryList(priRpScpTrspAddChgVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Guide Line을 이용하여 FIC Base Port List를 조회한다. <br>
	 * 
	 * @param FicRouteGLineVO ficRouteGLineVO
	 * @param boolean addOnFlag
	 * @return List<FicRouteGLineVO>
	 * @exception EventException
	 */
	public List<FicRouteGLineVO> searchFICBasePortListByGLine(FicRouteGLineVO ficRouteGLineVO, boolean addOnFlag) throws EventException {
		try {
			return dbDao.searchFICBasePortListByGLine(ficRouteGLineVO, addOnFlag);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Guile Line에 의한 Route를 조회합니다.<br>
	 * 
	 * @param FicRouteGLineVO ficRouteGLineVO
	 * @param boolean addOnFlag
	 * @return List<FicRouteGLineVO>
	 * @exception EventException
	 */
	public List<FicRouteGLineVO> searchFICRouteByGLine(FicRouteGLineVO ficRouteGLineVO, boolean addOnFlag) throws EventException {
		try {
			return dbDao.searchFICRouteByGLine(ficRouteGLineVO, addOnFlag);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Route 정보를 이용하여 Guide Line 정보를 조회한다.<br>
	 * 
	 * @param GLineInfoByFICRouteVO gLineInfoByFICRouteVO
	 * @param boolean addOnFlag
	 * @return List<GLineInfoByFICRouteVO>
	 * @exception EventException
	 */
	public List<GLineInfoByFICRouteVO> searchGLineInfoByFICRoute(GLineInfoByFICRouteVO gLineInfoByFICRouteVO, boolean addOnFlag) throws EventException {
		try {
			List<GLineInfoByFICRouteVO> gLineInfoByFICRouteVOs = dbDao.searchGLineInfoByFICRoute(gLineInfoByFICRouteVO, addOnFlag);
			if (gLineInfoByFICRouteVOs != null && gLineInfoByFICRouteVOs.size() > 0) {
				GLineInfoByFICRouteVO tgtVo = gLineInfoByFICRouteVOs.get(0);
				if (gLineInfoByFICRouteVO.getCurrCd() != null && !"USD".equals(gLineInfoByFICRouteVO.getCurrCd())) {
					if (gLineInfoByFICRouteVO.getCurrCd() != null && gLineInfoByFICRouteVO.getCurrCd().equals(gLineInfoByFICRouteVOs.get(0).getFicLoclCurrCd())) {
						gLineInfoByFICRouteVOs.get(0).setFicGlineRtAmt(gLineInfoByFICRouteVOs.get(0).getFicGlineLoclRtAmt());
					} else {
						tgtVo.setCurrCd(gLineInfoByFICRouteVO.getCurrCd());
						tgtVo.setEffDt(gLineInfoByFICRouteVO.getEffDt());
						gLineInfoByFICRouteVOs.set(0, dbDao.searchFicGlineRtLocalAmt(tgtVo));
					}
				}
			}
			return gLineInfoByFICRouteVOs;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * ESM_PRI_2029 : Guideline Route Search Pop-Up
	 * 
	 * @param searchGuidelineRouteInquiryVO
	 * @return List<SearchGuidelineRoutePopupListVO>
	 * @throws EventException
	 */
	public List<SearchGuidelineRoutePopupListVO> searchGuidelineRoutePopupList(SearchGuidelineRouteInquiryVO searchGuidelineRouteInquiryVO) throws EventException {
		try {
			return dbDao.searchGuidelineRoutePopupList(searchGuidelineRouteInquiryVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * 엑셀파일을 업로드합니다.<br>
	 * 
	 * @param PriRpScpTrspAddChgVO[] priRpScpTrspAddChgVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void uploadArbitraryChargeProposalForIHC(PriRpScpTrspAddChgVO[] priRpScpTrspAddChgVOs, SignOnUserAccount account) throws EventException {
		try {
			List<PriRpScpTrspAddChgVO> insertVoList = new ArrayList<PriRpScpTrspAddChgVO>();

			for (int i = 0; i < priRpScpTrspAddChgVOs.length; i++) {
				if (priRpScpTrspAddChgVOs[i].getIbflag().equals("I")) {
					priRpScpTrspAddChgVOs[i].setCreUsrId(account.getUsr_id());
					priRpScpTrspAddChgVOs[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(priRpScpTrspAddChgVOs[i]);
				}
			}

			if (insertVoList.size() > 0) {
				dbDao.addArbitraryExcelForIHC(insertVoList);
			}

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * 엑셀파일을 체크합니다.
	 * 
	 * @param RsltPriRpScpTrspAddChgVO[] rsltPriRpScpTrspAddChgVOs
	 * @return List<RsltPriRpScpTrspAddChgVO>
	 * @exception EventException
	 */
	public List<RsltPriRpScpTrspAddChgVO> searchCodeCheckResultForIHC(RsltPriRpScpTrspAddChgVO[] rsltPriRpScpTrspAddChgVOs) throws EventException {
		try {
			List<RsltPriRpScpTrspAddChgVO> checkVoList = new ArrayList<RsltPriRpScpTrspAddChgVO>();
			List<RsltCdListVO> cdList = new ArrayList<RsltCdListVO>();
			RsltCdListVO vo = new RsltCdListVO();

			for (int i = 0; i < rsltPriRpScpTrspAddChgVOs.length; i++) {
				// Point
				vo.setCd(rsltPriRpScpTrspAddChgVOs[i].getRoutPntLocDefCd());
				cdList = dbDao.searchExcelCodeList(vo, "LOC");
				if (cdList != null && cdList.size() > 0) {
					rsltPriRpScpTrspAddChgVOs[i].setRoutPntLocDefCd("1");
				} else {
					rsltPriRpScpTrspAddChgVOs[i].setRoutPntLocDefCd("0");
				}

				// Base Port
				vo.setCd(rsltPriRpScpTrspAddChgVOs[i].getBsePortDefCd());
				vo.setSvcScpCd(rsltPriRpScpTrspAddChgVOs[i].getSvcScpCd());
				vo.setPropNo(rsltPriRpScpTrspAddChgVOs[i].getPropNo());
				vo.setAmdtSeq(rsltPriRpScpTrspAddChgVOs[i].getAmdtSeq());
				if (vo.getCd().length() == 4) {
					cdList = dbDao.searchExcelCodeList(vo, "GRP");
				} else {
					cdList = dbDao.searchExcelCodeList(vo, "LOC");
				}

				if (cdList != null && cdList.size() > 0) {
					rsltPriRpScpTrspAddChgVOs[i].setBsePortDefCd("1");
				} else {
					rsltPriRpScpTrspAddChgVOs[i].setBsePortDefCd("0");
				}
				checkVoList.add(rsltPriRpScpTrspAddChgVOs[i]);
			}

			return checkVoList;

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * RFA Arbitrary 의 Guide 값을 업데이트 시켜줌.
	 * 
	 * @param PriRpComVO priRpComVO
	 * @param SignOnUserAccount account 
	 * @return String
	 * @exception EventException
	 */
	public String managePriRpScpTrspAddChgCopy(PriRpComVO priRpComVO, SignOnUserAccount account) throws EventException {
		BackEndJobManager backEndJobManager = new BackEndJobManager();
		 UpdatePriRpScpTrspAddChgGLBackEndJobImpl jobImpl = new UpdatePriRpScpTrspAddChgGLBackEndJobImpl();
		String key = null;
		
		try {
			jobImpl.setPriRpComVO(priRpComVO);
			jobImpl.setAccount(account);
			
			key = backEndJobManager.execute(jobImpl, account.getUsr_id(), "ESM_PRI_2003 - Arbitrary G/L Update");
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		
		return key;
	}
	
	/**
	 * Summary 팝업에서 승인 대상인 모든 Service Scope Arbitrary 리스트를 조회한다.<br>
	 * 
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @return List<RsltArbChgListVO>
	 * @exception EventException
	 */
	public List<RsltArbChgListVO> searchAllArbitraryList(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO) throws EventException {
		try {
			return dbDao.searchAllArbitraryList(priRpScpRtCmdtHdrVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}
}