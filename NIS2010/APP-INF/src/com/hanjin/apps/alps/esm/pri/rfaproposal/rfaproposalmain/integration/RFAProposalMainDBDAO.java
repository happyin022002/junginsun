/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : RFAProposalMainDBDAO.java
 *@FileTitle : Proposal & Amendment Creation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.08
 *@LastModifier : 변영주
 *@LastVersion : 1.0
 * 2009.05.08 변영주
 * 1.0 Creation
=========================================================
 * History
 * 2011.04.08 김민아 [CHM-201110030-01] Approve 상태에서 Save 시 Request Office 와 Sales Rep 을 비교하여 수정 사항이 존재할 경우 EDI 호출하도록 수정
 * 2013.07.08 전윤주 [CHM-201324601] RFA Request 시 Port 운임에 속한 Route (Origin, Dest) 를 체크하여 call_port_flag가 'N' 인 경우 validation 처리 
 * 2013.12.20 서미진 [선처리 CSR] RFA에 계약 구분인자 추가 (C : Contract, S : Spot)
 * 2014.09.15 최성환  [CHM-201431899] Guideline RFA 생성 요청 
 * 2014.11.25 최성환 [CHM-201432700] Retroactive RFA Minimization관련 시스템 개발요청
 * 2015.01.02 최성환 [CHM-201433110] RFA Proposal & Amendment Status 조회 기능 개선
 * 2015.04.22 전지예 [CHM-201535165] RFA match back 팝업화면 추가
 * 2016.05.03 RFA 효율화를 위한 요청 (1차) (CHM-201640671)
 * 2016.05.23.CHM-201641745_[RFA 효율화를 위한 요청 (1차)] APP 오류 발견(SHA16M0374 case) 및 Service Scope validation 미적용
 * 2016.07.13 CHM-201642363 Rate of Including IHC info (Mail Title : RFA -> request problem)
 * 2016.07.20 [CHM-201642287] Master RFA Cancel시 Basic RFA 점검 로직 개발 요청
 * =========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.PriEmailTargetListVO;
import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.basic.RFAProposalMainBCImpl;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.CstApprovalVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.CstRequestCheckVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.CstShHistVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.CstShRInqVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.DmtScExptVerVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.InPrsMQCEstimateVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.MasterInfoFromBasicVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.PriEdiRfGenInfVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.PriRpRetroVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RequestCheckForCalculationVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RequestCheckForMatchBackVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RfaSlsLdCtrtInfoVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RpScpGlineCopyVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RsltAmdtHisMnVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RsltCheckMQCEstimateVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RsltMQCEstimateVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RsltPriCrmSlLdVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RsltPriRpAmdHstMnVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RsltPriRpInqVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RsltPropAmdtSmryVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RsltPropCustInfoVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RsltPropMnInqVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RsltPropMnMstVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RsltPropMnScpInqListVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RsltPropMnScpListVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RsltPropMnVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RsltPropScpAmdtSmryVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RsltReturnVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RsltRfaAproRqstRefByOfcVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RsltRfaAproRqstRefVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RsltRfaMainStsVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RsltRfaPRSCMDataVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RsltRfaPropCopyVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RsltStatusVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.SchSaleLeadRfaVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltRoutHdrSmryListVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaquotationmain.vo.RsltCopyToProposalVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriRpAmdtSmryVO;
import com.hanjin.syscommon.common.table.PriRpAproRqstRefUsrVO;
import com.hanjin.syscommon.common.table.PriRpAproRqstRefVO;
import com.hanjin.syscommon.common.table.PriRpHdrVO;
import com.hanjin.syscommon.common.table.PriRpMnVO;
import com.hanjin.syscommon.common.table.PriRpProgVO;
import com.hanjin.syscommon.common.table.PriRpScpAmdtSmryVO;
import com.hanjin.syscommon.common.table.PriRpScpMnVO;
import com.hanjin.syscommon.common.table.PriRpScpProgVO;
import com.hanjin.syscommon.common.table.PriRpScpRtCmdtRoutVO;
import com.hanjin.syscommon.common.table.PriSpCtrtPtyVO;

/**
 * NIS2010 RFAProposalMainDBDAO <br>
 * - NIS2010-RFAProposal system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *  
 * @author Byeon Young Joo
 * @see RFAProposalMainBCImpl 참조
 * @since J2EE 1.4
 */
public class RFAProposalMainDBDAO extends DBDAOSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * RFA Main 정보를 조회합니다.<br>
	 * 
	 * @param PriRpHdrVO priRpHdrVO
	 * @param SignOnUserAccount account
	 * @return List<RsltPropMnVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltPropMnVO> searchProposalMain(PriRpHdrVO priRpHdrVO, SignOnUserAccount account) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPropMnVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		velParam.put("rfa_no", priRpHdrVO.getRfaNo());

		try {
			if (priRpHdrVO != null) {
				Map<String, String> mapVO = priRpHdrVO.getColumnValues();
				mapVO.put("usr_id", account.getUsr_id());
				mapVO.put("srep_cd", account.getSrep_cd());
				mapVO.put("ofc_cd", account.getOfc_cd());
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFAProposalMainDBDAORsltPropMnVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltPropMnVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * RFA Main 정보를 조회합니다.<br>
	 * 
	 * @param PriRpHdrVO priRpHdrVO
	 * @param SignOnUserAccount account
	 * @return List<RsltPropMnVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltPropMnVO> searchProposalMainSpot(PriRpHdrVO priRpHdrVO, SignOnUserAccount account) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPropMnVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		velParam.put("rfa_no", priRpHdrVO.getRfaNo());

		try {
			if (priRpHdrVO != null) {
				Map<String, String> mapVO = priRpHdrVO.getColumnValues();
				mapVO.put("usr_id", account.getUsr_id());
				mapVO.put("srep_cd", account.getSrep_cd());
				mapVO.put("ofc_cd", account.getOfc_cd());
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFAProposalMainDBDAORsltPropMnSpotVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltPropMnVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	

	/**
	 * Master RFA Main 정보를 조회합니다.<br>
	 * 
	 * @param PriRpHdrVO priRpHdrVO
	 * @param SignOnUserAccount account
	 * @return List<RsltPropMnMstVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltPropMnMstVO> searchProposalMainMst(PriRpHdrVO priRpHdrVO, SignOnUserAccount account) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPropMnMstVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		velParam.put("rfa_no", priRpHdrVO.getRfaNo());

		try {
			if (priRpHdrVO != null) {
				Map<String, String> mapVO = priRpHdrVO.getColumnValues();
				mapVO.put("usr_id", account.getUsr_id());
				mapVO.put("srep_cd", account.getSrep_cd());
				mapVO.put("ofc_cd", account.getOfc_cd());
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			
				// CHM-201641711 BKG Creation 화면에서 Master RFA View화면 호출 가능한 화면 구성 요청 
				// org_amdt_seq from Master RFA Display View (ESM_PRI_2220.js)
				log.debug("[RfaNo()["+priRpHdrVO.getRfaNo()+"]");
				log.debug("[OrgAmdtSeq()["+priRpHdrVO.getOrgAmdtSeq()+"]");
				if(!"".equals(priRpHdrVO.getRfaNo()) && !"".equals(priRpHdrVO.getOrgAmdtSeq())){
					//Master RFA View from BKG
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFAProposalMainDBDAORsltPropMnMstViewVORSQL(), param, velParam);
				} else {
					//Master RFA Creation 
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFAProposalMainDBDAORsltPropMnMstVORSQL(), param, velParam);	
				}
			}
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltPropMnMstVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * RFA Scope 정보를 조회합니다.<br>
	 * 
	 * @param PriRpHdrVO priRpHdrVO
	 * @param String usrId
	 * @return List<RsltPropMnScpListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltPropMnScpListVO> searchProposalMainScpList(PriRpHdrVO priRpHdrVO, String usrId) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPropMnScpListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		velParam.put("rfa_no", priRpHdrVO.getRfaNo());

		try {
			if (priRpHdrVO != null) {
				Map<String, String> mapVO = priRpHdrVO.getColumnValues();
				mapVO.put("usr_id", usrId);
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFAProposalMainDBDAORsltPropMnScpListVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltPropMnScpListVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * Customer 정보를 조회합니다.<br>
	 * 
	 * @param PriSpCtrtPtyVO priSpCtrtPtyVO
	 * @return List<RsltPropCustInfoVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltPropCustInfoVO> searchProposalCustomerInfo(PriSpCtrtPtyVO priSpCtrtPtyVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPropCustInfoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priSpCtrtPtyVO != null) {
				Map<String, String> mapVO = priSpCtrtPtyVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFAProposalMainDBDAORsltPropCustInfoVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltPropCustInfoVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * RFA Header 정보를 추가합니다.<br>
	 * 
	 * @param List<PriRpHdrVO> insModels
	 * @exception DAOException
	 */
	public void addProposalHeader(List<PriRpHdrVO> insModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new RFAProposalMainDBDAOPriRpHdrVOCSQL(), insModels, null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * RFA Main 정보를 추가합니다.<br>
	 * 
	 * @param List<PriRpMnVO> insModels
	 * @exception DAOException
	 */
	public void addProposalMain(List<PriRpMnVO> insModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new RFAProposalMainDBDAOPriRpMnVOCSQL(), insModels, null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * RFA Header 정보를 수정합니다.<br>
	 * 
	 * @param List<PriRpHdrVO> insModels
	 * @exception DAOException
	 */
	public void modifyProposalHeader(List<PriRpHdrVO> insModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new RFAProposalMainDBDAOPriRpHdrVOUSQL(), insModels, null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * RFA Main 정보를 수정합니다.<br>
	 * 
	 * @param List<PriRpMnVO> updModels
	 * @exception DAOException
	 */
	public void modifyProposalMain(List<PriRpMnVO> updModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (updModels.size() > 0) {
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("init_cancel", "N");
				updCnt = sqlExe.executeBatch((ISQLTemplate) new RFAProposalMainDBDAOPriRpMnVOUSQL(), updModels, velParam);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * RFA Scope 정보를 추가합니다.<br>
	 * 
	 * @param List<PriRpScpMnVO> insModels
	 * @exception DAOException
	 */
	public void addProposalScopeMain(List<PriRpScpMnVO> insModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new RFAProposalMainDBDAOPriRpScpMnVOCSQL(), insModels, null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * RFA Scope 정보를 수정합니다.<br>
	 * 
	 * @param List<PriRpScpMnVO> updModels
	 * @exception DAOException
	 */
	public void modifyProposalScopeMain(List<PriRpScpMnVO> updModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (updModels.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new RFAProposalMainDBDAOPriRpScpMnVOUSQL(), updModels, null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * RFA Main 정보를 삭제합니다.<br>
	 * 
	 * @param List<PriRpScpMnVO> delModels
	 * @exception DAOException
	 */
	public void removeProposalScopeMain(List<PriRpScpMnVO> delModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("IS_CASCADE", "N");

				delCnt = sqlExe.executeBatch((ISQLTemplate) new RFAProposalMainDBDAOPriRpScpMnVODSQL(), delModels, null);
				for (int i = 0; i < delCnt.length; i++) {
					if (delCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * 새로운 RFA Proposal Number 를 조회합니다.<br>
	 * 
	 * @param String ofcCd
	 * @return String
	 * @exception DAOException
	 */
	public String searchCreationProposalNo(String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnVal = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("ofc_cd", ofcCd);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFAProposalMainDBDAORsltCrePropNoVORSQL(), param, velParam);
			dbRowset.next();
			rtnVal = dbRowset.getString(1);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return rtnVal;
	}

	/**
	 * CRM에 전송할 RFA Sales Lead Contract Info 를 조회합니다.<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @return List<RfaSlsLdCtrtInfoVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RfaSlsLdCtrtInfoVO> searchRfaSalesLeadContractInfo(PriRpMnVO priRpMnVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RfaSlsLdCtrtInfoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priRpMnVO != null) {
				Map<String, String> mapVO = priRpMnVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFAProposalMainDBDAORfaSlsLdCtrtInfoVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RfaSlsLdCtrtInfoVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * Main Progress 테이블에 데이터를 추가 합니다.<br>
	 * 
	 * @param List<PriRpProgVO> insModels
	 * @exception DAOException
	 */
	public void addProposalProgress(List<PriRpProgVO> insModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new RFAProposalMainDBDAOPriRpProgVOCSQL(), insModels, null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Main의 Amendment Summary Table에 데이터를 추가합니다.<br>
	 * 
	 * @param List<PriRpAmdtSmryVO> insModels
	 * @exception DAOException
	 */
	public void addProposalAmendmentSummary(List<PriRpAmdtSmryVO> insModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new RFAProposalMainDBDAOPriRpAmdtSmryVOCSQL(), insModels, null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Proposal Main Amendment Summary 테이블에 데이터를 추가 합니다.<br>
	 * 
	 * @param PriRpAmdtSmryVO priRpAmdtSmryVO
	 * @exception DAOException
	 */
	public void addProposalAmendmentSummary(PriRpAmdtSmryVO priRpAmdtSmryVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priRpAmdtSmryVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new RFAProposalMainDBDAOPriRpAmdtSmryVOCSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to update SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Scope의 상태코드가 변경될 때 Scope Progress 테이블에 데이터를 추가합니다.<br>
	 * 
	 * @param List<PriRpScpProgVO> insModels
	 * @exception DAOException
	 */
	public void addProposalScopeProgress(List<PriRpScpProgVO> insModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new RFAProposalMainDBDAOPriRpScpProgVOCSQL(), insModels, null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Scope의 상태코드가 변경될 때 Scope Progress 테이블에 추가합니다.<br>
	 * 
	 * @param PriRpScpProgVO vo
	 * @exception DAOException
	 */
	public void addProposalScopeProgressChange(PriRpScpProgVO vo) throws DAOException {

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new RFAProposalMainDBDAOPriRpScpProgChgVOCSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Proposal Scope Amendment Summary 테이블에 데이터를 추가 합니다.<br>
	 * 
	 * @param List<PriRpScpAmdtSmryVO> insModels
	 * @exception DAOException
	 */
	public void addProposalScopeAmendmentSummary(List<PriRpScpAmdtSmryVO> insModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new RFAProposalMainDBDAOPriRpScpAmdtSmryVOCSQL(), insModels, null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Scope이 삭제될 때 해당 Amend seq에 해당하는 모든 데이터를 삭제처리합니다. <br>
	 * 
	 * @param List<PriRpScpMnVO> delModels
	 * @exception EventException
	 */
	public void removeProposalScopeAmdtSmry(List<PriRpScpMnVO> delModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				HashMap<String, Object> velParam = new HashMap<String, Object>();

				delCnt = sqlExe.executeBatch((ISQLTemplate) new RFAProposalMainDBDAOPriRpScpAmdtSmryVODSQL(), delModels, velParam);
				for (int i = 0; i < delCnt.length; i++) {
					if (delCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

	}

	/**
	 * Scope이 삭제될 때 해당 Amend seq에 해당하는 모든 데이터를 삭제처리합니다. <br>
	 * 
	 * @param List<PriRpScpMnVO> delModels
	 * @exception EventException
	 */
	public void removeProposalScopeProgress(List<PriRpScpMnVO> delModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				HashMap<String, Object> velParam = new HashMap<String, Object>();

				delCnt = sqlExe.executeBatch((ISQLTemplate) new RFAProposalMainDBDAOPriRpScpProgressVODSQL(), delModels, velParam);
				for (int i = 0; i < delCnt.length; i++) {
					if (delCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Amendment Summary 데이터를 Accept, Accept Cancel 상태로 수정합니다.<br>
	 * 
	 * @param List<PriRpAmdtSmryVO> updModels
	 * @exception DAOException
	 */
	public void modifyProposalAutoAcceptAmendmentSummary(List<PriRpAmdtSmryVO> updModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (updModels.size() > 0) {
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("auto_accept", "Y");
				updCnt = sqlExe.executeBatch((ISQLTemplate) new RFAProposalMainDBDAOPriRpAmdtSmryAllVOUSQL(), updModels, velParam);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * 자동 Accept되는 Terms의 상태 Flag를 수정합니다.<br>
	 * 
	 * @param List<PriRpScpAmdtSmryVO> updModels
	 * @exception DAOException
	 */
	public void modifyProposalScopeAutoAcceptAmendmentSummary(List<PriRpScpAmdtSmryVO> updModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (updModels.size() > 0) {
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("auto_accept", "Y");
				updCnt = sqlExe.executeBatch((ISQLTemplate) new RFAProposalMainDBDAOPriRpScpAllAmdtSmryVOUSQL(), updModels, velParam);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Scope이 삭제될 때 해당 Amend seq에 해당하는 모든 데이터를 삭제처리합니다. <br>
	 * 
	 * @param PriRpScpMnVO vo
	 * @exception EventException
	 */
	public void removeProposalScopeAmdtSmry(PriRpScpMnVO vo) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new RFAProposalMainDBDAOPriRpScpAmdtSmryVODSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to delete SQL");
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Scope이 삭제될 때 해당 Amend seq에 해당하는 모든 데이터를 삭제처리합니다. <br>
	 * 
	 * @param PriRpScpMnVO vo
	 * @exception EventException
	 */
	public void removeProposalScopeProgress(PriRpScpMnVO vo) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new RFAProposalMainDBDAOPriRpScpProgressVODSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to delete SQL");
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Terms의 Amendment Summary 정보를 조회 합니다.<br>
	 * 
	 * @param PriRpAmdtSmryVO priRpAmdtSmryVO
	 * @return List<RsltPropAmdtSmryVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltPropAmdtSmryVO> searchProposalAmendmentSummary(PriRpAmdtSmryVO priRpAmdtSmryVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPropAmdtSmryVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priRpAmdtSmryVO != null) {
				Map<String, String> mapVO = priRpAmdtSmryVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFAProposalMainDBDAORsltPropAmdtSmryVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltPropAmdtSmryVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * Scope Terms의 Amendment Summary 정보를 조회 합니다.<br>
	 * 
	 * @param PriRpScpAmdtSmryVO priRpScpAmdtSmryVO
	 * @return List<RsltPropScpAmdtSmryVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltPropScpAmdtSmryVO> searchProposalScopeAmendmentSummary(PriRpScpAmdtSmryVO priRpScpAmdtSmryVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPropScpAmdtSmryVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priRpScpAmdtSmryVO != null) {
				Map<String, String> mapVO = priRpScpAmdtSmryVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFAProposalMainDBDAORsltPropScpAmdtSmryVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltPropScpAmdtSmryVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * Terms가 ACCEPT 되었는지 조회 합니다.<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @return List<PriRpMnVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<PriRpMnVO> searchProposalAcceptCheck(PriRpMnVO priRpMnVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PriRpMnVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priRpMnVO != null) {
				Map<String, String> mapVO = priRpMnVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFAProposalMainDBDAORsltAcceptListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, PriRpMnVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * C/OFFER 시 TERMS에 INIT인 데이터가 있는지 조회합니다.<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @return List<RsltStatusVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltStatusVO> searchCountOfferStatus(PriRpMnVO priRpMnVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltStatusVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priRpMnVO != null) {
				Map<String, String> mapVO = priRpMnVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFAProposalMainDBDAORsltStatusVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltStatusVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * Rate Commodity Header 는 있고 detail은 없는 데이터를 조회합니다.<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @return List<CstRequestCheckVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CstRequestCheckVO> searchRequestTermsCheck(PriRpMnVO priRpMnVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CstRequestCheckVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priRpMnVO != null) {
				Map<String, String> mapVO = priRpMnVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFAProposalMainDBDAORequestCheckVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CstRequestCheckVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * Request 전 Calculate를 하지 않은 Scope를 조회합니다.<br>
	 * 
	 * @param PriRpScpMnVO priRpScpMnVO
	 * @return List<RequestCheckForCalculationVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RequestCheckForCalculationVO> searchRequestCheckCalculate(PriRpScpMnVO priRpScpMnVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RequestCheckForCalculationVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priRpScpMnVO != null) {
				Map<String, String> mapVO = priRpScpMnVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				velParam.put("is_calc_chk", "");
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFAProposalMainDBDAORequestCheckForCalculationVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RequestCheckForCalculationVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * Request 전 Match Back 조회 하지 않은 Scope를 조회합니다.<br>
	 * 
	 * @param PriRpScpMnVO priRpScpMnVO
	 * @return List<RequestCheckForMatchBackVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RequestCheckForMatchBackVO> searchRequestCheckMatchBack(PriRpScpMnVO priRpScpMnVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RequestCheckForMatchBackVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priRpScpMnVO != null) {
				Map<String, String> mapVO = priRpScpMnVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFAProposalMainDBDAORequestCheckForMatchBackVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RequestCheckForMatchBackVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * M/B 활성화 여부를 위해 calcutae 하지 않는 scope를 가져옵니다.<br>
	 * 
	 * @param PriRpScpMnVO priRpScpMnVO
	 * @return List<RequestCheckForCalculationVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RequestCheckForCalculationVO> searchMatchBackCheckCalculate(PriRpScpMnVO priRpScpMnVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RequestCheckForCalculationVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priRpScpMnVO != null) {
				Map<String, String> mapVO = priRpScpMnVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				velParam.put("is_calc_chk", "Y");
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFAProposalMainDBDAORequestCheckForCalculationVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RequestCheckForCalculationVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * Scope의 상태를 조회합니다. <br>
	 * 
	 * @param PriRpScpMnVO priRpScpMnVO
	 * @return List<PriRpScpMnVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<PriRpScpMnVO> searchProposalScopeStatusCheck(PriRpScpMnVO priRpScpMnVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PriRpScpMnVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priRpScpMnVO != null) {
				Map<String, String> mapVO = priRpScpMnVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFAProposalMainDBDAOPriRpScpMnStatusCheckVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, PriRpScpMnVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * Scope삭제시 Terms의 데이터가 있는지 확인합니다.<br>
	 * 
	 * @param PriRpScpMnVO priRpScpMn
	 * @return int
	 * @exception EventException
	 */
	public int searchProposalScopeDeleteCheck(PriRpScpMnVO priRpScpMn) throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int cnt = 0;
		try {
			if (priRpScpMn != null) {
				Map<String, String> mapVO = priRpScpMn.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFAProposalMainDBDAOPriRpScpCntVORSQL(), param, velParam);
			if (dbRowset.next()) {
				cnt = dbRowset.getInt(1);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return cnt;
	}

	/**
	 * Request 시 자동으로 Accept된 Terms를 Init 상태로 수정합니다.<br>
	 * 
	 * @param List<PriRpAmdtSmryVO> updModels
	 * @exception DAOException
	 */
	public void modifyProposalRequestCancelAmendmentSummary(List<PriRpAmdtSmryVO> updModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (updModels.size() > 0) {
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("auto_accept", "N");
				updCnt = sqlExe.executeBatch((ISQLTemplate) new RFAProposalMainDBDAOPriRpAmdtSmryAllVOUSQL(), updModels, velParam);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * 자동 Accept된 Terms의 Amendement Summary데이터를 이전 상태로 수정합니다.<br>
	 * 
	 * @param List<PriRpScpAmdtSmryVO> updModels
	 * @exception DAOException
	 */
	public void modifyProposalScopeRequestCancelAmendmentSummary(List<PriRpScpAmdtSmryVO> updModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (updModels.size() > 0) {
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("auto_accept", "N");
				updCnt = sqlExe.executeBatch((ISQLTemplate) new RFAProposalMainDBDAOPriRpScpAllAmdtSmryVOUSQL(), updModels, velParam);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Scope의 상태를 일괄 변경합니다.<br>
	 * 
	 * @param PriRpScpMnVO vo
	 * @exception DAOException
	 */
	public void modifyAllScopeStatus(PriRpScpMnVO vo) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new RFAProposalMainDBDAOPriRpScpMnAllStatusVOUSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to update SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * MAIN의 Expire Date를 변경 합니다.<br>
	 * 
	 * @param PriRpMnVO vo
	 * @exception DAOException
	 */
	public void modifyProposalMainExpiry(PriRpMnVO vo) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			velParam.put("init_cancel", "Y");
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new RFAProposalMainDBDAOPriRpMnVOUSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Init Cancel시 Main 데이터를 삭제처리합니다.<br>
	 * 
	 * @param PriRpMnVO vo
	 * @exception DAOException
	 */
	public void removeProposal(PriRpMnVO vo) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			param.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new RFAProposalMainDBDAOPriRpMnVODSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to delete SQL");
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Init Cancel시 Header 데이터를 삭제처리합니다.<br>
	 * 
	 * @param PriRpMnVO vo
	 * @exception DAOException
	 */
	public void removeProposalHdr(PriRpMnVO vo) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			param.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new RFAProposalMainDBDAOPriRpHdrVODSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to delete SQL");
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Init Cancel시 AproRqstRef 데이터를 삭제처리합니다.<br>
	 * 
	 * @param PriRpMnVO vo
	 * @exception DAOException
	 */
	public void removeProposalAproRqstRef(PriRpMnVO vo) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			param.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new RFAProposalMainDBDAOPriRpAproRqstRefInitVODSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to delete SQL");
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Init Cancel시 AproRqstRefUsr 데이터를 삭제처리합니다.<br>
	 * 
	 * @param PriRpMnVO vo
	 * @exception DAOException
	 */
	public void removeProposalAproRqstRefUsr(PriRpMnVO vo) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			param.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new RFAProposalMainDBDAOPriRpAproRqstRefUsrInitDSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to delete SQL");
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Init Cancel시 Amend seq에 해당하는 Main Progress 의 모든 데이터를 삭제처리합니다. <br>
	 * 
	 * @param PriRpMnVO vo
	 * @exception EventException
	 */
	public void removeProposalProgress(PriRpMnVO vo) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new RFAProposalMainDBDAOPriRpProgressVODSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to delete SQL");
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Init Cancel시 Amend seq에 해당하는 Amend Summary 데이터를 삭제처리합니다. <br>
	 * 
	 * @param PriRpMnVO vo
	 * @exception EventException
	 */
	public void removeProposalAmdtSmry(PriRpMnVO vo) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new RFAProposalMainDBDAOPriRpAmdtSmryVODSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to delete SQL");
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Init Cancel시 Amend seq에 해당하는 Scope Main 데이터를 삭제처리합니다. <br>
	 * 
	 * @param PriRpScpMnVO vo
	 * @exception EventException
	 */
	public void removeProposalScopeMain(PriRpScpMnVO vo) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new RFAProposalMainDBDAOPriRpScpMnVODSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to delete SQL");
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Scope MAIN의 Expire Date를 변경 합니다.<br>
	 * 
	 * @param PriRpScpMnVO vo
	 * @exception DAOException
	 */
	public void modifyProposalScopeMainExpiryChange(PriRpScpMnVO vo) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			velParam.put("init_cancel", "Y");
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new RFAProposalMainDBDAOPriRpScpMnExpVOUSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Main Amendment Summary 를 수정합니다.<br>
	 * 
	 * @param List<PriRpAmdtSmryVO> updModels
	 * @exception DAOException
	 */
	public void modifyProposalAmendmentSummary(List<PriRpAmdtSmryVO> updModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (updModels.size() > 0) {
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("prop_term_tp_cd", updModels.get(0).getPropTermTpCd());
				updCnt = sqlExe.executeBatch((ISQLTemplate) new RFAProposalMainDBDAOPriRpAmdtSmryVOUSQL(), updModels, velParam);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * RFA Proposal Main Amendment Summary 정보를 Copy 하여 수정합니다.<br>
	 * 
	 * @param PriRpAmdtSmryVO priRpAmdtSmryVO
	 * @exception DAOException
	 */
	public void modifyProposalAmendmentSummary(PriRpAmdtSmryVO priRpAmdtSmryVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priRpAmdtSmryVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new RFAProposalMainDBDAOPriRpAmdtSmryVOUSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to update SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * S/C Proposal Scope Main 정보를 Copy 하여 생성합니다.<br>
	 * 
	 * @param RsltRfaPropCopyVO vo
	 * @exception DAOException
	 */
	public void addCopyProposalScopeMain(RsltRfaPropCopyVO vo) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new RFAProposalMainDBDAOPropCpPriRpScpMnCSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Proposal Scope Amendment Summary 정보를 수정합니다.<br>
	 * 
	 * @param List<PriRpScpAmdtSmryVO> updModels
	 * @exception DAOException
	 */
	public void modifyProposalScopeAmendmentSummary(List<PriRpScpAmdtSmryVO> updModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (updModels.size() > 0) {
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("prop_scp_term_tp_cd", updModels.get(0).getPropScpTermTpCd());
				updCnt = sqlExe.executeBatch((ISQLTemplate) new RFAProposalMainDBDAOPriRpScpAmdtSmryVOUSQL(), updModels, velParam);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * RFA Proposal Scope Amendment Summary 정보를 한건 씩 수정합니다.<br>
	 * 
	 * @param PriRpScpAmdtSmryVO vo
	 * @exception DAOException
	 */
	public void modifyProposalScopeAmendmentSummary(PriRpScpAmdtSmryVO vo) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new RFAProposalMainDBDAOPriRpScpAmdtSmryVOUSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to update SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Scope Main의 Status를 수정합니다.<br>
	 * 
	 * @param List<PriRpScpAmdtSmryVO> updModels
	 * @exception DAOException
	 */
	public void modifyProposalScopeStatus(List<PriRpScpAmdtSmryVO> updModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (updModels.size() > 0) {
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				updCnt = sqlExe.executeBatch((ISQLTemplate) new RFAProposalMainDBDAOPriRpScpStsUSQL(), updModels, velParam);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Summary table에서 Accept 처리된 데이터를 조회합니다. <br>
	 * 
	 * @param PriRpScpMnVO priRpScpMnVO
	 * @return int
	 * @exception DAOException
	 */
	public int searchProposalScopeAcceptCheck(PriRpScpMnVO priRpScpMnVO) throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int cnt = 0;
		try {
			if (priRpScpMnVO != null) {
				Map<String, String> mapVO = priRpScpMnVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFAProposalMainDBDAOPriRpScpMnStatusVORSQL(), param, velParam);
			if (dbRowset.next()) {
				cnt = dbRowset.getInt(1);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return cnt;
	}

	/**
	 * Scope Main의 Status를 수정합니다.<br>
	 * 
	 * @param List<PriRpScpMnVO> updModels
	 * @exception DAOException
	 */
	public void modifyScopeStatus(List<PriRpScpMnVO> updModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (updModels.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new RFAProposalMainDBDAOPriRpScpMnStatusVOUSQL(), updModels, null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Terms중 하나라도 Returned 가 있다면 Scope의 상태를 Returned로 변경합니다.<br>
	 * 
	 * @param PriRpScpMnVO vo
	 * @exception EventException
	 */
	public void modifyAutoScopeReturnStatus(PriRpScpMnVO vo) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new RFAProposalMainDBDAOPriRpScpMnReturnedVOUSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Scope Progress와 Scope main의 상태를 조회합니다. <br>
	 * 
	 * @param PriRpScpMnVO priRpScpMn
	 * @return int
	 * @exception DAOException
	 */
	public int searchScopeProgressStatus(PriRpScpMnVO priRpScpMn) throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int cnt = 0;
		try {
			if (priRpScpMn != null) {
				Map<String, String> mapVO = priRpScpMn.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFAProposalMainDBDAOPriRpScpMnProgVORSQL(), param, velParam);
			if (dbRowset.next()) {
				cnt = dbRowset.getInt(1);

			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return cnt;
	}

	/**
	 * Scope Main의 Progress테이블에 데이터를 추가합니다. <br>
	 * 
	 * @param List<PriRpScpProgVO> insModels
	 * @exception DAOException
	 */
	public void addProposalScopeProgressScopeMn(List<PriRpScpProgVO> insModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new RFAProposalMainDBDAOPriRpScpMnProgVOCSQL(), insModels, null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Proposal Main의 status 를 수정합니다.<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @exception DAOException
	 */
	public void modifyMainStatus(PriRpMnVO priRpMnVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priRpMnVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new RFAProposalMainDBDAOPriStatusVOUSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to update SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

	}

	/**
	 * Scope MAIN의 Expire Date를 변경 합니다.<br>
	 * 
	 * @param PriRpMnVO vo
	 * @exception EventException
	 */
	public void modifyProposalScopeMainExpiry(PriRpMnVO vo) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			velParam.put("init_cancel", "N");
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new RFAProposalMainDBDAOPriRpScpMnExpVOUSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * 새로운 Proposal Number 를 조회합니다.<br>
	 * 
	 * @param String ofcCd
	 * @return String
	 * @exception DAOException
	 */
	public String searchCreationRFANo(String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnVal = "";
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("ofc_cd", ofcCd);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFAProposalMainDBDAORsltCreRFANoVORSQL(), param, velParam);
			dbRowset.next();
			rtnVal = dbRowset.getString(1);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return rtnVal;
	}

	/**
	 * 새로운 Proposal Number 를 조회합니다.<br>
	 * 
	 * @param String ofcCd
	 * @return String
	 * @exception DAOException
	 */
	public String searchCreationSpotRFANo(String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnVal = "";
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("ofc_cd", ofcCd);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFAProposalMainDBDAORsltCreSpotRFANoVORSQL(), param, velParam);
			dbRowset.next();
			rtnVal = dbRowset.getString(1);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return rtnVal;
	}
	
	/**
	 * 새로운 Master RFA Proposal Number 를 조회합니다.<br>
	 * 
	 * @param String ofcCd
	 * @return String
	 * @exception DAOException
	 */
	public String searchCreationMstRFANo(String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnVal = "";
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("ofc_cd", ofcCd);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFAProposalMainDBDAORsltCreMstRFANoVORSQL(), param, velParam);
			dbRowset.next();
			rtnVal = dbRowset.getString(1);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return rtnVal;
	}
	
	/**
	 * 새로운 Master Proposal Number 를 조회합니다.<br>
	 * RFA 효율화를 위한 요청 (1차) (CHM-201640671)<br>
	 * 
	 * @param String ofcCd
	 * @param String rfaCtrtTpCd
	 * @return String
	 * @exception DAOException
	 */
	public String searchMstCreationRFANo(String ofcCd, String rfaCtrtTpCd) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnVal = "";
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("ofc_cd", ofcCd);
			param.put("rfa_ctrt_tp_cd", rfaCtrtTpCd);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFAProposalMainDBDAORsltAllTypeRFANoVORSQL(), param, velParam);
			dbRowset.next();
			rtnVal = dbRowset.getString(1);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return rtnVal;
	}
	
	/**
	 * 해당 조건의 Proposal Main 데이터를 Amend Seq + 1하여 추가합니다.<br>
	 * 
	 * @param List<PriRpMnVO> insModels
	 * @exception DAOException
	 */
	public void addProposalMainAmend(List<PriRpMnVO> insModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new RFAProposalMainDBDAOPriRpMnAmdVOCSQL(), insModels, null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * 해당 조건의 Proposal Scope 데이터를 Amend Seq + 1하여 추가합니다.<br>
	 * 
	 * @param List<PriRpMnVO> insModels
	 * @exception DAOException
	 */
	public void addProposalScopeMainAmend(List<PriRpMnVO> insModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new RFAProposalMainDBDAOPriRpScpMnAmdVOCSQL(), insModels, null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * 이전 Amend Seq의 Main Expire Date를 수정합니다. <br>
	 * 
	 * @param List<PriRpMnVO> insModels
	 * @exception DAOException
	 */
	public void modifyProposalMainAmend(List<PriRpMnVO> insModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new RFAProposalMainDBDAOPriRpMnAmdVOUSQL(), insModels, null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * 이전 Amend Seq의 Main Expire Date를 수정합니다. <br>
	 * 
	 * @param List<PriRpMnVO> insModels
	 * @exception DAOException
	 */
	public void modifyProposalScopeMainAmend(List<PriRpMnVO> insModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new RFAProposalMainDBDAOPriRpScpMnAmdVOUSQL(), insModels, null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Main Progress 데이터를 현재 Amend No + 1하여 추가합니다. <br>
	 * 
	 * @param List<PriRpMnVO> insModels
	 * @exception DAOException
	 */
	public void addProposalProgressAmend(List<PriRpMnVO> insModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			// query parameter
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new RFAProposalMainDBDAOPriRpProgAmdVOCSQL(), insModels, null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Main Amendment Summary 데이터를 현재 Amend No + 1하여 추가합니다. <br>
	 * 
	 * @param List<PriRpMnVO> insModels
	 * @exception DAOException
	 */
	public void addProposalAmendmentSummaryAmend(List<PriRpMnVO> insModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new RFAProposalMainDBDAOPriRpAmdtSmryAmdVOCSQL(), insModels, null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Scope Progress 데이터를 현재 Amend No + 1하여 추가합니다. <br>
	 * 
	 * @param List<PriRpMnVO> insModels
	 * @exception DAOException
	 */
	public void addProposalScopeProgressAmend(List<PriRpMnVO> insModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insModels.size() > 0) {

				insCnt = sqlExe.executeBatch((ISQLTemplate) new RFAProposalMainDBDAOPriRpScpProgAmdVOCSQL(), insModels, null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Scope Amendment Summary 데이터를 현재 Amend No + 1하여 추가합니다. <br>
	 * 
	 * @param List<PriRpMnVO> insModels
	 * @exception DAOException
	 */
	public void addProposalScopeAmendmentSummaryAmend(List<PriRpMnVO> insModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new RFAProposalMainDBDAOPriRpScpAmdtSmryAmdVOCSQL(), insModels, null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
				// Summary에 IHC가 없을 경우 생성 (CHM-201642363)
				if(insCnt.length > 0) {
					sqlExe.executeBatch((ISQLTemplate) new RFAProposalMainDBDAOPriRpScpAmdtSmryAmd2CSQL(), insModels, null);
				}
				
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * c/offer 이 있는 terms 에서 returned 인 데이터를 조회합니다.<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @return List<RsltReturnVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltReturnVO> searchProposalReturnedList(PriRpMnVO priRpMnVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltReturnVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priRpMnVO != null) {
				Map<String, String> mapVO = priRpMnVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFAProposalMainDBDAORsltReturnVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltReturnVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * Main status 를 Returned 에서 Request로 변경합니다.<br>
	 * 
	 * @param PriRpMnVO vo
	 * @return int
	 * @exception DAOException
	 */
	public int modifyAutoChangeMainStatus(PriRpMnVO vo) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new RFAProposalMainDBDAOPriRpMnAutoVOUSQL(), param, velParam);

			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}

	/**
	 * Scope 코드를 조회합니다.<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @return List<PriRpScpMnVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<PriRpScpMnVO> searchProposalScope(PriRpMnVO priRpMnVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PriRpScpMnVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priRpMnVO != null) {
				Map<String, String> mapVO = priRpMnVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFAProposalMainDBDAOPriRpScpAutoVORSQL(), param, velParam);

			list = (List) RowSetUtil.rowSetToVOs(dbRowset, PriRpScpMnVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * Approve Cancel시 Main Expire Date를 Approve 이전 값으로 수정합니다.
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @exception DAOException
	 */
	public void modifyProposalApproveCancelMain(PriRpMnVO priRpMnVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		log.debug("<<<<<<<<<<<<<<<<<<<<<<<manageProposalApproveCancel<<<<<<<<<<<<<<<<<<<<<<<");
		int result = 0;
		try {
			Map<String, String> mapVO = priRpMnVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new RFAProposalMainDBDAOPriRpMnApproveCancelVOUSQL(), param, velParam);

			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Approve Cancel시 Scope Expire Date를 Approve 이전 값으로 수정합니다.
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @exception DAOException
	 */
	public void modifyProposalApproveCancelScopeMain(PriRpMnVO priRpMnVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		log.debug("<<<<<<<<<<<<<<<<<<<<<<<manageProposalApproveCancel<<<<<<<<<<<<<<<<<<<<<<<");
		int result = 0;
		try {
			Map<String, String> mapVO = priRpMnVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new RFAProposalMainDBDAOPriRpScpMnApproveCancelVOUSQL(), param, velParam);

			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * DMT_SC_EXPT_VER에서 Status를 조회합니다.<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @return List<DmtScExptVerVO>
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public List<DmtScExptVerVO> searchCheckDmdtList(PriRpMnVO priRpMnVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<DmtScExptVerVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priRpMnVO != null) {
				Map<String, String> mapVO = priRpMnVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFAProposalMainDBDAODmtScExptVerVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, DmtScExptVerVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * Duration(Main,Scope)과 Dem/Det 데이터가 변경 되었는지 조회 합니다.<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltCdListVO> searchCheckDurationList(PriRpMnVO priRpMnVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltCdListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priRpMnVO != null) {
				Map<String, String> mapVO = priRpMnVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFAProposalMainDBDAORsltRequestCheckVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltCdListVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * Sale Lead 데이터를 조회합니다.<br>
	 * 
	 * @param SchSaleLeadRfaVO schSaleLeadRfaVO
	 * @return List<RsltPriCrmSlLdVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltPriCrmSlLdVO> searchProposalMainSaleLeadList(SchSaleLeadRfaVO schSaleLeadRfaVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriCrmSlLdVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (schSaleLeadRfaVO != null) {
				Map<String, String> mapVO = schSaleLeadRfaVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFAProposalMainDBDAOPriCrmSILdVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltPriCrmSlLdVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * Amend History Main 데이터를 조회합니다.<br>
	 * 
	 * @param PriRpHdrVO priRpHdrVO
	 * @return List<RsltPriRpAmdHstMnVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltPriRpAmdHstMnVO> searchAmendmentHistoryMain(PriRpHdrVO priRpHdrVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriRpAmdHstMnVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priRpHdrVO != null) {
				Map<String, String> mapVO = priRpHdrVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFAProposalMainDBDAORsltPriRpAmdHstMnVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltPriRpAmdHstMnVO.class);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * Amend History Main Spot 데이터를 조회합니다.<br>
	 * 
	 * @param PriRpHdrVO priRpHdrVO
	 * @return List<RsltPriRpAmdHstMnVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltPriRpAmdHstMnVO> searchAmendmentHistoryMainSpot(PriRpHdrVO priRpHdrVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriRpAmdHstMnVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priRpHdrVO != null) {
				Map<String, String> mapVO = priRpHdrVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFAProposalMainDBDAORsltPriRpAmdHstMnSpotVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltPriRpAmdHstMnVO.class);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * Amend History List 데이터를 조회합니다.<br>
	 * 
	 * @param CstShHistVO cstShHistVO
	 * @return List<RsltAmdtHisMnVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltAmdtHisMnVO> searchAmendmentHistoryList(CstShHistVO cstShHistVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltAmdtHisMnVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (cstShHistVO != null) {
				Map<String, String> mapVO = cstShHistVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFAProposalMainDBDAORsltAmdtHisMnVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltAmdtHisMnVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * Amend 된 Terms를 조회합니다.<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @return List<RsltPropScpAmdtSmryVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltPropScpAmdtSmryVO> searchHistoryAmendTermList(PriRpMnVO priRpMnVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPropScpAmdtSmryVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priRpMnVO != null) {
				Map<String, String> mapVO = priRpMnVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFAProposalMainDBDAORsltHisAmdTermVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltPropScpAmdtSmryVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * Proposal No로 Scope Main에 등록된 모든 Scope을 조회합니다.<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @return List<RsltCdListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltCdListVO> searchHistoryScopeList(PriRpMnVO priRpMnVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltCdListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priRpMnVO != null) {
				Map<String, String> mapVO = priRpMnVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFAProposalMainDBDAORsltHisScpVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltCdListVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * Amend Summry 에서 amdt_flg가 Y 인 Terms 를 조회합니다 <br>
	 * 
	 * @param CstShHistVO cstShHistVO
	 * @return List<RsltPropScpAmdtSmryVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltPropScpAmdtSmryVO> searchAmendmentHistorySummary(CstShHistVO cstShHistVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPropScpAmdtSmryVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (cstShHistVO != null) {
				Map<String, String> mapVO = cstShHistVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFAProposalMainDBDAORsltHisAmdVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltPropScpAmdtSmryVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * RFA Proposal Affiliate 의 Copy 정보를 조회합니다.<br>
	 * 
	 * @param RsltRfaPropCopyVO rsltRfaPropCopyVO
	 * @return List<RsltRfaPropCopyVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltRfaPropCopyVO> searchProposalCopyAfilList(RsltRfaPropCopyVO rsltRfaPropCopyVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltRfaPropCopyVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (rsltRfaPropCopyVO != null) {
				Map<String, String> mapVO = rsltRfaPropCopyVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFAProposalMainDBDAORsltPropAfilVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltRfaPropCopyVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * RFA Proposal Main / Scope 의 Copy 정보를 조회합니다.<br>
	 * 
	 * @param RsltRfaPropCopyVO rsltRfaPropCopyVO
	 * @return List<RsltRfaPropCopyVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltRfaPropCopyVO> searchProposalCopyList(RsltRfaPropCopyVO rsltRfaPropCopyVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltRfaPropCopyVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (rsltRfaPropCopyVO != null) {
				Map<String, String> mapVO = rsltRfaPropCopyVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFAProposalMainDBDAORsltPropCopyVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltRfaPropCopyVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * RFA Proposal Main 정보를 Copy 해서 생성합니다.<br>
	 * 
	 * @param RsltRfaPropCopyVO vo
	 * @exception DAOException
	 */
	public void addCopyProposalMain(RsltRfaPropCopyVO vo) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new RFAProposalMainDBDAOPropCpPriRpMnCSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Master RFA Proposal Main 정보를 Copy 해서 생성합니다.<br>
	 * 
	 * @param RsltRfaPropCopyVO vo
	 * @param String rfaTypeCode
	 * @exception DAOException
	 */
	public void addCopyProposalMainMst(RsltRfaPropCopyVO vo, String rfaTypeCode) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			// Master RFA에서 복사 시 RFA Type Code를 변경한다.
			param.put("rfa_ctrt_tp_cd", rfaTypeCode);
			velParam.put("IS_MASTER_COPY", "Y");
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new RFAProposalMainDBDAOPropCpPriRpMnCSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * RFA Proposal HEADER 정보를 Copy 해서 생성합니다.<br>
	 * 
	 * @param RsltRfaPropCopyVO vo
	 * @exception DAOException
	 */
	public void addCopyProposalHdr(RsltRfaPropCopyVO vo) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new RFAProposalMainDBDAOPropCpPriRpHdrCSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Master RFA Proposal HEADER 정보를 Copy 해서 생성합니다.<br>
	 * 
	 * @param RsltRfaPropCopyVO vo
	 * @exception DAOException
	 */
	public void addCopyProposalHdrMst(RsltRfaPropCopyVO vo) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			velParam.put("IS_MASTER", "Y");
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new RFAProposalMainDBDAOPropCpPriRpHdrCSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * RFA Proposal PROGRESS 정보를 Copy 해서 생성합니다.<br>
	 * 
	 * @param RsltRfaPropCopyVO vo
	 * @exception DAOException
	 */
	public void addCopyProposalProg(RsltRfaPropCopyVO vo) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new RFAProposalMainDBDAOPropCpPriRpProgCSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Proposal Request 테이블의 새로운 SEQ 를 조회합니다.<br>
	 * 
	 * @param PriRpAproRqstRefVO vo
	 * @return String
	 * @exception DAOException
	 */
	public String searchProposalRequestNewSeq(PriRpAproRqstRefVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		String newSeq = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vo != null) {
				Map<String, String> mapVO = vo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFAProposalMainDBDAOPriRpAproRqstNewSeqRSQL(), param, velParam);

			if (dbRowset.next()) {
				newSeq = dbRowset.getString(1);
			} else {
				newSeq = "1";
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return newSeq;
	}

	/**
	 * Proposal Request 정보를 생성합니다.<br>
	 * 
	 * @param PriRpAproRqstRefVO vo
	 * @exception DAOException
	 */
	public void addProposalRequestRef(PriRpAproRqstRefVO vo) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new RFAProposalMainDBDAOPriRpAproRqstRefVOCSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Proposal Request User 정보를 생성합니다.<br>
	 * 
	 * @param PriRpAproRqstRefUsrVO vo
	 * @exception DAOException
	 */
	public void addProposalRequestRefUser(PriRpAproRqstRefUsrVO vo) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new RFAProposalMainDBDAOPriRpAproRqstRefUsrVOCSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Proposal Request 의 상태를 수정합니다.<br>
	 * 
	 * @param PriRpAproRqstRefVO vo
	 * @exception DAOException
	 */
	public void modifyProposalRequestStatus(PriRpAproRqstRefVO vo) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new RFAProposalMainDBDAOPriRpAproRqstRefVOUSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * RFA 승인을 위해 접수한 Proposal Request 를 조회합니다.<br>
	 * 
	 * @param RsltRfaAproRqstRefVO rsltRfaAproRqstRefVO
	 * @return List<RsltRfaAproRqstRefVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltRfaAproRqstRefVO> searchProposalReceivedRequestList(RsltRfaAproRqstRefVO rsltRfaAproRqstRefVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltRfaAproRqstRefVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (rsltRfaAproRqstRefVO != null) {
				Map<String, String> mapVO = rsltRfaAproRqstRefVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFAProposalMainDBDAOPriRpAproRcvdRqstRefVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltRfaAproRqstRefVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * RFA 승인을 위해 신청한 Proposal Request 를 조회합니다.<br>
	 * 
	 * @param RsltRfaAproRqstRefVO rsltRfaAproRqstRefVO
	 * @return List<RsltRfaAproRqstRefVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltRfaAproRqstRefVO> searchProposalSentRequestList(RsltRfaAproRqstRefVO rsltRfaAproRqstRefVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltRfaAproRqstRefVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (rsltRfaAproRqstRefVO != null) {
				Map<String, String> mapVO = rsltRfaAproRqstRefVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFAProposalMainDBDAOPriRpAproSentRqstRefVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltRfaAproRqstRefVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 *  RFA 대상에서  [Requested] 조건으로 Requested 정보와 Approval 정보를  조회합니다.<br>
	 * 
	 * @param RsltRfaAproRqstRefByOfcVO rsltRfaAproRqstRefByOfcVO
	 * @return List<RsltRfaAproRqstRefByOfcVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltRfaAproRqstRefByOfcVO> searchProposalRequestList(RsltRfaAproRqstRefByOfcVO rsltRfaAproRqstRefByOfcVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltRfaAproRqstRefByOfcVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (rsltRfaAproRqstRefByOfcVO != null) {
				Map<String, String> mapVO = rsltRfaAproRqstRefByOfcVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFAProposalMainDBDAOSearchProposalRequestListVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltRfaAproRqstRefByOfcVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 *  RFA 대상에서  [Approval] 조건으로 Requested 정보와 Approval 정보를  조회합니다.<br>
	 * 
	 * @param RsltRfaAproRqstRefByOfcVO rsltRfaAproRqstRefByOfcVO
	 * @return List<RsltRfaAproRqstRefByOfcVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltRfaAproRqstRefByOfcVO> searchProposalApprovalList(RsltRfaAproRqstRefByOfcVO rsltRfaAproRqstRefByOfcVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltRfaAproRqstRefByOfcVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (rsltRfaAproRqstRefByOfcVO != null) {
				Map<String, String> mapVO = rsltRfaAproRqstRefByOfcVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFAProposalMainDBDAOSearchProposalApprovalListVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltRfaAproRqstRefByOfcVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 *  RFA 대상에서  [Effective] 조건으로 Requested 정보와 Approval 정보를  조회합니다.<br>
	 * 
	 * @param RsltRfaAproRqstRefByOfcVO rsltRfaAproRqstRefByOfcVO
	 * @return List<RsltRfaAproRqstRefByOfcVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltRfaAproRqstRefByOfcVO> searchProposalEffectiveList(RsltRfaAproRqstRefByOfcVO rsltRfaAproRqstRefByOfcVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltRfaAproRqstRefByOfcVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (rsltRfaAproRqstRefByOfcVO != null) {
				Map<String, String> mapVO = rsltRfaAproRqstRefByOfcVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFAProposalMainDBDAOSearchProposalEffectiveListVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltRfaAproRqstRefByOfcVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * Proposal & Amendment Search List 를 조회합니다.<br>
	 * 
	 * @param CstShRInqVO cstShRInqVO
	 * @return List<RsltPriRpInqVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltPriRpInqVO> searchProposalMainInquiryList(CstShRInqVO cstShRInqVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriRpInqVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (cstShRInqVO != null) {
				Map<String, String> mapVO = cstShRInqVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFAProposalMainDBDAORsltPriRpInqVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltPriRpInqVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	//TODO:choi
	/**
	 * Proposal & Amendment Search List 를 조회합니다.<br>
	 * 
	 * @param CstShRInqVO cstShRInqVO
	 * @return List<RsltPriRpInqVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltPriRpInqVO> searchProposalMainSpotInquiryList(CstShRInqVO cstShRInqVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriRpInqVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (cstShRInqVO != null) {
				Map<String, String> mapVO = cstShRInqVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFAProposalMainDBDAORsltPriRpSpotInqVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltPriRpInqVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}	

	/**
	 * Proposal & Amendment Main을 조회합니다.<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @return List<RsltPropMnInqVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltPropMnInqVO> searchProposalMainInquiry(PriRpMnVO priRpMnVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPropMnInqVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priRpMnVO != null) {
				Map<String, String> mapVO = priRpMnVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFAProposalMainDBDAORsltPropMnInqVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltPropMnInqVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * Proposal & Amendment Main을 조회합니다.<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @return List<RsltPropMnInqVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltPropMnInqVO> searchProposalMainSpotInquiry(PriRpMnVO priRpMnVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPropMnInqVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priRpMnVO != null) {
				Map<String, String> mapVO = priRpMnVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFAProposalMainDBDAORsltPropMnSpotInqVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltPropMnInqVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * Proposal & Amendment Scope List를 조회합니다.<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @return List<RsltPropMnScpInqListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltPropMnScpInqListVO> searchProposalMainScpInquiryList(PriRpMnVO priRpMnVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPropMnScpInqListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priRpMnVO != null) {
				Map<String, String> mapVO = priRpMnVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFAProposalMainDBDAORsltPropMnScpInqListVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltPropMnScpInqListVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * Customer 데이터를 조회합니다.<br>
	 * 
	 * @param PriSpCtrtPtyVO priSpCtrtPtyVO
	 * @return List<RsltPropCustInfoVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltPropCustInfoVO> searchProposalCustomerInfoInquiry(PriSpCtrtPtyVO priSpCtrtPtyVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPropCustInfoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priSpCtrtPtyVO != null) {
				Map<String, String> mapVO = priSpCtrtPtyVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFAProposalMainDBDAORsltPropCustInfoVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltPropCustInfoVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * Summry 테이블에서 terms의 데이터가 수정 되었는지 조회합니다.<br>
	 * 
	 * @param PriRpScpAmdtSmryVO priRpScpAmdtSmryVO
	 * @return List<RsltPropScpAmdtSmryVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltPropScpAmdtSmryVO> searchProposalScopeAmendmentSummaryInquiry(PriRpScpAmdtSmryVO priRpScpAmdtSmryVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPropScpAmdtSmryVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priRpScpAmdtSmryVO != null) {
				Map<String, String> mapVO = priRpScpAmdtSmryVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFAProposalMainDBDAORsltPropScpAmdtSmryInqVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltPropScpAmdtSmryVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * BKG_BOOKING,BKG_RATE테이블에서 사용되는 RFA_NO가 있는지 조회합니다. <br>
	 * 
	 * @param CstApprovalVO cstApprovalVO
	 * @return List<RsltCdListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltCdListVO> searchApprovalCancelCheck(CstApprovalVO cstApprovalVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltCdListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (cstApprovalVO != null) {
				Map<String, String> mapVO = cstApprovalVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFAProposalMainDBDAOApprovalCancelVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltCdListVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * Guideline Copy 대상 정보를 조회합니다.<br>
	 * 
	 * @param RpScpGlineCopyVO rpScpGlineCopyVO
	 * @return List<RpScpGlineCopyVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RpScpGlineCopyVO> searchGuidelineCopyCheck(RpScpGlineCopyVO rpScpGlineCopyVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RpScpGlineCopyVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (rpScpGlineCopyVO != null) {
				Map<String, String> mapVO = rpScpGlineCopyVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFAProposalMainDBDAOGlineCopyCheckSelectRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RpScpGlineCopyVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * Copy 할 Guideline 의 gline_seq 를 가져온다. <br>
	 * 
	 * @param RpScpGlineCopyVO rpScpGlineCopyVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchCopyGlineSeq(RpScpGlineCopyVO rpScpGlineCopyVO) throws DAOException {
		DBRowSet dbRowset = null;
		String glineSeq = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (rpScpGlineCopyVO != null) {
				Map<String, String> mapVO = rpScpGlineCopyVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFAProposalMainDBDAOGlineCopyGetGlineSeqRSQL(), param, velParam);
			if (dbRowset.next()) {
				glineSeq = dbRowset.getString(1);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return glineSeq;
	}

	/**
	 * Amend Request 시 Duration을 변경할 경우 Scope Main 의 Expire Date를 변경합니다.<br>
	 * 
	 * @param List<PriRpMnVO> updModels
	 * @exception DAOException
	 */
	public void modifyProposalScopeMainAmd(List<PriRpMnVO> updModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;

			if (updModels.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new RFAProposalMainDBDAOPriRpScpMnAmdDurVOUSQL(), updModels, null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No" + i + " SQL");
				}
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * PRS 정보를 Copy 하여 RqCpPriRpAmdtSmry 정보를 생성합니다.<br>
	 * 
	 * @param RsltCopyToProposalVO vo
	 * @return int
	 * @exception DAOException
	 */
	public int addCopyRfaQuotationPriRpAmdtSmry(RsltCopyToProposalVO vo) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new RFAProposalMainDBDAORqCpPriRpAmdtSmryVOCSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
			}

			return result;
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * PRS 정보를 Copy 하여 RqCpPriRpHdr 정보를 생성합니다.<br>
	 * 
	 * @param RsltCopyToProposalVO vo
	 * @return int
	 * @exception DAOException
	 */
	public int addCopyRfaQuotationPriRpHdr(RsltCopyToProposalVO vo) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new RFAProposalMainDBDAORqCpPriRpHdrCSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
			}

			return result;
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * PRS 정보를 Copy 하여 RqCpPriRpMn 정보를 생성합니다.<br>
	 * 
	 * @param RsltCopyToProposalVO vo
	 * @return int
	 * @exception DAOException
	 */
	public int addCopyRfaQuotationPriRpMn(RsltCopyToProposalVO vo) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new RFAProposalMainDBDAORqCpPriRpMnCSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
			}

			return result;
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * PRS 정보를 Copy 하여 RqCpPriRpProg 정보를 생성합니다.<br>
	 * 
	 * @param RsltCopyToProposalVO vo
	 * @return int
	 * @exception DAOException
	 */
	public int addCopyRfaQuotationPriRpProg(RsltCopyToProposalVO vo) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new RFAProposalMainDBDAORqCpPriRpProgCSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
			}

			return result;
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * PRS 정보를 Copy 하여 RqCpPriRpScpAmdtSmry 정보를 생성합니다.<br>
	 * 
	 * @param RsltCopyToProposalVO vo
	 * @return int
	 * @exception DAOException
	 */
	public int addCopyRfaQuotationPriRpScpAmdtSmry(RsltCopyToProposalVO vo) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new RFAProposalMainDBDAORqCpPriRpScpAmdtSmryVOCSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
			}

			return result;
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * PRS 정보를 Copy 하여 RqCpPriRpScpMn 정보를 생성합니다.<br>
	 * 
	 * @param RsltCopyToProposalVO vo
	 * @return int
	 * @exception DAOException
	 */
	public int addCopyRfaQuotationPriRpScpMn(RsltCopyToProposalVO vo) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new RFAProposalMainDBDAORqCpPriRpScpMnCSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
			}

			return result;
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * PRS 정보를 Copy 하여 RqCpPriRpScpProg 정보를 생성합니다.<br>
	 * 
	 * @param RsltCopyToProposalVO vo
	 * @return int
	 * @exception DAOException
	 */
	public int addCopyRfaQuotationPriRpScpProg(RsltCopyToProposalVO vo) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new RFAProposalMainDBDAORqCpPriRpScpProgVOCSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
			}

			return result;
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * EDI에 전송할 RFA General Information 을 조회합니다.<br>
	 * 
	 * @param PriEdiRfGenInfVO priEdiRfGenInfVO
	 * @return List<PriEdiRfGenInfVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<PriEdiRfGenInfVO> searchRfaGeneralInfo(PriEdiRfGenInfVO priEdiRfGenInfVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PriEdiRfGenInfVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priEdiRfGenInfVO != null) {
				Map<String, String> mapVO = priEdiRfGenInfVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFAProposalMainDBDAOPriEdiRfGenInfVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, PriEdiRfGenInfVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * PRS CM Data를 조회합니다.<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @return List<RsltPRSCMDataVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltRfaPRSCMDataVO> searchProposalMainPRSCMData(PriRpMnVO priRpMnVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltRfaPRSCMDataVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priRpMnVO != null) {
				Map<String, String> mapVO = priRpMnVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFAProposalMainDBDAORsltRfaPRSCMDataVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltRfaPRSCMDataVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * Main의 상태를 조회한다.<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @return List<RsltRfaMainStsVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltRfaMainStsVO> searchProposalMainStatus(PriRpMnVO priRpMnVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltRfaMainStsVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priRpMnVO != null) {
				Map<String, String> mapVO = priRpMnVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFAProposalMainDBDAORsltRfaMainStsVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltRfaMainStsVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * Proposal No,Amend Seq 에 해당하는 Scope을 조회합니다.<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @return List<RsltCdListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltCdListVO> searchScopeList(PriRpMnVO priRpMnVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltCdListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priRpMnVO != null) {
				Map<String, String> mapVO = priRpMnVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFAProposalMainDBDAORsltRfaMainStsVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltCdListVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * Rate Save시, Scope Main의 PRS Calc 관련 테이블을 업데이트한다.<br>
	 * 
	 * @param PriRpScpMnVO priRpScpMnVO
	 * @exception EventException
	 */
	public void modifyPrsCalcFlgOnSaveRt(PriRpScpMnVO priRpScpMnVO) throws DAOException, Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = priRpScpMnVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new RFAProposalMainDBDAOPriRpScpMnPrsCalcFlgOnRtUSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Rate Save시, Scope Main의 PRS MB 관련 테이블을 업데이트한다.<br>
	 * 
	 * @param PriRpScpMnVO priRpScpMnVO
	 * @exception EventException
	 */
	public void modifyPrsMBFlgOnSaveRt(PriRpScpMnVO priRpScpMnVO) throws DAOException, Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = priRpScpMnVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new RFAProposalMainDBDAOPriRpScpMnPrsMBFlgOnRtUSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * C/Offer/Request Cancel 시 Rate CALCULATE Flag를 변경합니다.<br>
	 * 
	 * @param PriRpScpMnVO priRpScpMnVO
	 * @exception EventException
	 */
	public void modifyPrsCalcFlgOnChangeStatus(PriRpScpMnVO priRpScpMnVO) throws DAOException, Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = priRpScpMnVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new RFAProposalMainDBDAOPriRpScpMnPrsCalcFlgOnChangeStatusVOUSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Accept 가능 테이블에서 Accept, Returned 데이터가 있는지 조회한다.<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @return List<CstRequestCheckVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CstRequestCheckVO> searchProposalRequestCancelCheck(PriRpMnVO priRpMnVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CstRequestCheckVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priRpMnVO != null) {
				Map<String, String> mapVO = priRpMnVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFAProposalMainDBDAORequestCancelCheckVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CstRequestCheckVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * Main Approval Date 를 수정합니다.<br>
	 * 
	 * @param List<PriRpMnVO> updModels
	 * @exception DAOException
	 */
	public void modifyProposalApprovalDate(List<PriRpMnVO> updModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (updModels.size() > 0) {
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("prop_sts_cd", updModels.get(0).getPropStsCd());
				updCnt = sqlExe.executeBatch((ISQLTemplate) new RFAProposalMainDBDAOPriRpMnAproDtVOUSQL(), updModels, velParam);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Main table의 (PRI_RP_SCP_MN )의 CM 값을 갱신처리 합니다.
	 * 
	 * @param PriRpScpRtCmdtRoutVO updModels
	 * @exception DAOException
	 */
	public void modifyScopeMainSummary(PriRpScpRtCmdtRoutVO updModels) throws DAOException, Exception {
		try {
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			// velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			SQLExecuter sqlExe = new SQLExecuter("");

			if (updModels != null) {
				Map<String, String> mapVO = updModels.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				sqlExe.executeUpdate((ISQLTemplate) new RFAProposalMainDBDAOPriRpScpMnCmSummaryVOUSQL(), param, velParam);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Target MVC estimate 를 저정해 조회한다..<br>
	 * 
	 * @param InPrsMQCEstimateVO inPrsMQCEstimateVO
	 * @return List<RsltCheckMQCEstimateVO>
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltCheckMQCEstimateVO> searchCheckMQCEstimateList(InPrsMQCEstimateVO inPrsMQCEstimateVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltCheckMQCEstimateVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (inPrsMQCEstimateVO != null) {
				Map<String, String> mapVO = inPrsMQCEstimateVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFAProposalMainDBDAORsltCheckMQCEstimateVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltCheckMQCEstimateVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * Target MVC estimate Popup의 List를 조회한다..<br>
	 * 
	 * @param InPrsMQCEstimateVO inPrsMQCEstimateVO
	 * @return List<RsltMQCEstimateVO>
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltMQCEstimateVO> searchMQCEstimateList(InPrsMQCEstimateVO inPrsMQCEstimateVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltMQCEstimateVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (inPrsMQCEstimateVO != null) {
				Map<String, String> mapVO = inPrsMQCEstimateVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFAProposalMainDBDAORsltMQCEstimateVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltMQCEstimateVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * Target MVC estimate 를 수정합니다.<br>
	 * 
	 * @param List<PriRpScpMnVO> updModels
	 * @exception DAOException
	 */
	public void modifyMQCEstimateList(List<PriRpScpMnVO> updModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (updModels.size() > 0) {
				HashMap<String, Object> velParam = new HashMap<String, Object>();

				updCnt = sqlExe.executeBatch((ISQLTemplate) new RFAProposalMainDBDAORsltMQCEstimateVOUSQL(), updModels, velParam);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * RFA No 정보를 입력 합니다.<br>
	 * 
	 * @param List<PriRpHdrVO> insModels
	 * @exception DAOException
	 */
	public void modifyProposalRFANO(List<PriRpHdrVO> insModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new RFAProposalMainDBDAOPriRpHdrApproveVOUSQL(), insModels, null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Request Office 또는 Sales Rep 정보가 변경된 경우 EAI I/F 를 위한 정보를 조회한다.<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @return int
	 * @exception EventException
	 */
	public int searchCheckOfcSrepDiffList(PriRpMnVO priRpMnVO) throws DAOException {
		DBRowSet dbRowset = null;
		int result = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priRpMnVO != null) {
				Map<String, String> mapVO = priRpMnVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFAProposalMainDBDAOCheckOfcSrepDiffRSQL(), param, velParam);
			if (dbRowset.next()) {
				result = dbRowset.getInt(1);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}

	/**
	 * Proposal & Amendment Main을 조회합니다.<br>
	 * 
	 * @param PriRpHdrVO priRpHdrVO
	 * @return List<PriRpHdrVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<PriRpHdrVO> searchProposalNoFromRfaNo(PriRpHdrVO priRpHdrVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PriRpHdrVO> list = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priRpHdrVO != null) {
				Map<String, String> mapVO = priRpHdrVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFAProposalMainDBDAOSearchProposalNoFromRfaNoVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, PriRpHdrVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * ESM_PRI_2003 : Request Check <br>
	 * Rquest 처리시 Rate(AEE/AEW)의 FIC_PROP_RT_AMT값이 O인 값이 존재하는지 체크<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchProposalRequestIhcRateCheck(PriRpMnVO priRpMnVO) throws DAOException {
		DBRowSet dbRowset = null;
		String rslt = "";
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priRpMnVO != null) {
				Map<String, String> mapVO = priRpMnVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFAProposalMainDBDAOSearchProposalRequestIhcRateCheckRSQL(), param, velParam);
			if (dbRowset.next()) {
				rslt = dbRowset.getString(1);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return rslt;
	}
	
	
	/**
	 * ESM_PRI_2003 : Request Check <br>
	 * Rquest 처리 시 Port CY 운임에 Port 가 아닌 Route가 존재하는지 체크<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @return List<RsltCdListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltCdListVO> searchProposalRequestPortCyCheck(PriRpMnVO priRpMnVO) throws DAOException {
		DBRowSet dbRowset = null;		
		List<RsltCdListVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();		
		try {
			if (priRpMnVO != null) {				
				Map<String, String> mapVO = priRpMnVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFAProposalMainDBDAOSearchProposalRequestPortCyCheckRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltCdListVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
    /**
     * 메일 보내는 대상을 조회한다.<br>
     *
     * @param PriRpMnVO priRpMnVO
     * @return List<PriEmailTargetListVO>
     * @exception DAOException
     */
	@SuppressWarnings("unchecked")
    public List<PriEmailTargetListVO> searchEmailTargetUser(PriRpMnVO priRpMnVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<PriEmailTargetListVO> list = null;

        Map<String, Object> param = new HashMap<String, Object>();
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            if (priRpMnVO != null) {
                Map<String, String> mapVO = priRpMnVO.getColumnValues();

                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFAProposalMainDBDAOsearchEmailTargetUserListRSQL(),
                    param, velParam);  
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, PriEmailTargetListVO .class);
            
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
    }
	
	/**
	 * ESM_PRI_2003 : Requsest <br>
	 * RFA Type이 Contract 일때 마지막으로 actual customer가 commodity 별로 같은지 check<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @return String
	 * @exception DAOException
	 */
	public String checkRfaContractTpActCust(PriRpMnVO priRpMnVO) throws DAOException {
		DBRowSet dbRowset = null;
		String rslt = "";
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priRpMnVO != null) {
				Map<String, String> mapVO = priRpMnVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFAProposalMainDBDAOCheckRfaContractTpActCustRSQL(), param, velParam);
			if (dbRowset.next()) {
				rslt = dbRowset.getString(1);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return rslt;
	}
	
	/**
	 * ESM_PRI_2003 : Requsest <br>
	 * check Duration Basic Copy<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @return String
	 * @exception DAOException
	 */
	public String checkExpDurationBasicRFACopy(PriRpMnVO priRpMnVO) throws DAOException {
		DBRowSet dbRowset = null;
		String rslt = "";
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priRpMnVO != null) {
				Map<String, String> mapVO = priRpMnVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			// Basic RFA의 amdt가 0일때는 Copy한 Master의 Exp date를, amdt가 0이 아닐 때는 auto amend 대상 amdt의 Exp date를 취득한다.
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFAProposalMainDBDAOCheckExpDurationBasicRFACopyRSQL(), param, velParam);
			if (dbRowset.next()) {
				rslt = dbRowset.getString("org_exp_dt");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return rslt;
	}
	
	/**																	
	 * ESM_PRI_2003 : Approve Check <br>																
	 * Approve 처리시 Retroactive 대상이 존재하는지 체크<br>																
	 * 																
	 * @param PriRpMnVO priRpMnVO
	 * @param SignOnUserAccount account															
	 * @return String																
	 * @exception DAOException																
	 */																
	public String searchRetroactiveExistCheck(PriRpMnVO priRpMnVO, SignOnUserAccount account) throws DAOException {																
		DBRowSet dbRowset = null;															
		String rslt = "";															
		Map<String, Object> param = new HashMap<String, Object>();															
		Map<String, Object> velParam = new HashMap<String, Object>();															
																	
		try {															
			if (priRpMnVO != null) {														
				Map<String, String> mapVO = priRpMnVO.getColumnValues();
				//Session office code 
				mapVO.put("ofc_cd", account.getOfc_cd());
				param.putAll(mapVO);													
				velParam.putAll(mapVO);													
			}														
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFAProposalMainDBDAOSearchRetroactiveExistCheckRSQL(), param, velParam);														
			if (dbRowset.next()) {														
				rslt = dbRowset.getString(1);													
			}														
		} catch (SQLException se) {															
			log.error(se.getMessage(), se);														
			throw new DAOException(new ErrorHandler(se).getMessage(), se);														
		} catch (Exception ex) {															
			log.error(ex.getMessage(), ex);														
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);														
		}															
		return rslt;															
	}																
	
	/**
     *  Retroactive RFA 사유 코드 조회한다.<br>
     *
     * @return List<PriRpRetroVO>
     * @exception DAOException
     */
	@SuppressWarnings("unchecked")
    public List<PriRpRetroVO> searchRetroactiveRFANote() throws DAOException {
        DBRowSet dbRowset = null;
        List<PriRpRetroVO> list = null;

        Map<String, Object> param = new HashMap<String, Object>();
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFAProposalMainDBDAOSearchRetroactiveRFANoteListRSQL(),  //조회 sql 생성
                    param, velParam);  
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, PriRpRetroVO .class);
            
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
    }	
	
    /**
	 * ESM_PRI_2045 : Save <br>			
	 * Retroactive RFA 사유를 저장한다.<br>		
     * 
     * @param PriRpRetroVO priRpRetroVO
	 * @exception DAOException
     */    	
	public void addRetroactiveRFANote(PriRpRetroVO priRpRetroVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priRpRetroVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new RFAProposalMainDBDAOPriRpRetroVOCSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to update SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}		
	}
	
	// ============================ESM_PRI_2244_Start====================================
	
	/**				
	 * Master RFA Proposal Creation [Copy]를 조회한다.<br>			
	 * 			
	 * @param RsltRoutHdrSmryListVO  rsltRoutHdrSmryListVO		
	 * @return  List<RsltRoutHdrSmryListVO> 			
	 * @exception DAOException			
	 */
	@SuppressWarnings("unchecked")
	public List<RsltRoutHdrSmryListVO>  rfaProposalCreationCopy(RsltRoutHdrSmryListVO  rsltRoutHdrSmryListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltRoutHdrSmryListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (rsltRoutHdrSmryListVO != null) {
				Map<String, String> mapVO = rsltRoutHdrSmryListVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFAProposalMainDBDAORsltCopyRoutHdrSmryListVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltRoutHdrSmryListVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * Master 시점의 승인정보(ofc cd)를 조회합니다.<br>
	 * RFA 효율화를 위한 요청 (1차) (CHM-201640671)<br>
	 * 
	 * @param String propNo
	 * @param String amdtSeq
	 * @return String
	 * @exception DAOException
	 */
	public String searchMstAproOfcRslt(String propNo, String amdtSeq) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnVal = "";
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("prop_no", propNo);
			param.put("amdt_seq", amdtSeq);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFAProposalMainDBDAOSearchAproOfcRsltVORSQL(), param, velParam);
			dbRowset.next();
			rtnVal = dbRowset.getString(1);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return rtnVal;
	}
	
	/**
	 * Master 시점의 승인정보(user id)를 조회합니다.<br>
	 * RFA 효율화를 위한 요청 (1차) (CHM-201640671)<br>
	 * 
	 * @param String propNo
	 * @param String amdtSeq
	 * @return String
	 * @exception DAOException
	 */
	public String searchMstAproUsrRslt(String propNo, String amdtSeq) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnVal = "";
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("prop_no", propNo);
			param.put("amdt_seq", amdtSeq);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFAProposalMainDBDAOSearchAproUsrRsltVORSQL(), param, velParam);
			dbRowset.next();
			rtnVal = dbRowset.getString(1);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return rtnVal;
	}
	// ============================ESM_PRI_2244_End====================================

	/**
	 * Terms가 ACCEPT 되었는지 조회 합니다.<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @return List<PriRpMnVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<PriRpMnVO> searchProposalAcceptCheckMst(PriRpMnVO priRpMnVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PriRpMnVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priRpMnVO != null) {
				Map<String, String> mapVO = priRpMnVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFAProposalMainDBDAOMstRsltAcceptListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, PriRpMnVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * Master RFA에서 Approval Cancel 시 자식 Basic이 있는지 여부 체크 합니다. <br>
	 * 데이터가 있다면 화면에서 경고 alert 발생합니다.<br>
	 * 
	 * @param PriRpHdrVO priRpHdrVO
	 * @return List<RsltCdListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltCdListVO> searchApprovalCancelCheckChildren(PriRpHdrVO priRpHdrVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltCdListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if (priRpHdrVO != null) {
				Map<String, String> mapVO = priRpHdrVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFAProposalMainDBDAOApprovalCancelCheckChildrenRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltCdListVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * Approved Basic RFA 조회 시 Master RFA를 체크해서 Master의 AMD No.가 변경되었는지 체크한다.<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @return String
	 * @exception DAOException
	 */
	public String checkBasicAmendable(PriRpMnVO priRpMnVO) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnVal = "";
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("prop_no", priRpMnVO.getPropNo());
			param.put("amdt_seq", priRpMnVO.getAmdtSeq());
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFAProposalMainDBDAOCheckBasicAmendYNRSQL(), param, velParam);
			if (dbRowset.next()) {
				rtnVal = dbRowset.getString(1);
				log.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> amendable_yn : "  + rtnVal);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return rtnVal;
	}

	/**
	 * Basic RFA Amend 시 승인된 최종버전 Master RFA 정보를 조회한다.<br>
	 * 
	 * @param String
	 * @return List<PriRpScpMnVO>
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public List<PriRpScpMnVO> searchApprovedMstInfo(String mstRfaNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<PriRpScpMnVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			param.put("mst_rfa_no", mstRfaNo);
			velParam.put("mst_rfa_no", mstRfaNo);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFAProposalMainDBDAOApprovedMstInfoRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, PriRpScpMnVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	
	

    /**
     * Basic RFA의 Proposal No로 Master RFA의 Propsal no를 조회한다.<br>
     * 
     * @param PriRpMnVO priRpMnVO
     * @return List<MasterInfoFromBasicVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public List<MasterInfoFromBasicVO> searchMasterInfoFromBasicRFA(PriRpMnVO priRpMnVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<MasterInfoFromBasicVO> list = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            if (priRpMnVO != null) {
                Map<String, String> mapVO = priRpMnVO.getColumnValues();

                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFAProposalMainDBDAOMasterInfoFromBasicRSQL(), param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, MasterInfoFromBasicVO.class);
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
    }
	
}