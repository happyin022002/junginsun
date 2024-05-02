/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : RFATransportationAdditionalChargeProposalDBDAO.java
 *@FileTitle : RFA Proposal Origin/Destination Arbitrary Charge Creation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.30
 *@LastModifier : 김재연
 *@LastVersion : 1.0
 * 2009.07.30 김재연
 * 1.0 Creation
=========================================================
* History
* [CHM-201534517] 1월 소스 보안 결함 건 조치 요청
* 2015.10.28 SELCMU/김현경 [CHM-201538236] RFA module 승인 절차 간소화 및 기능 개선
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfatransportationadditionalchargeproposal.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.PriRpComVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RpScpGlineCopyVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RsltRfaPropCopyVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfatransportationadditionalchargeproposal.basic.RFATransportationAdditionalChargeProposalBCImpl;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfatransportationadditionalchargeproposal.vo.ChkFontStyleVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfatransportationadditionalchargeproposal.vo.CstPriRpScpTrspAddChgVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfatransportationadditionalchargeproposal.vo.FicRouteGLineVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfatransportationadditionalchargeproposal.vo.GLineInfoByFICRouteVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfatransportationadditionalchargeproposal.vo.RsltArbChgListVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfatransportationadditionalchargeproposal.vo.SearchGuidelineRouteInquiryVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfatransportationadditionalchargeproposal.vo.SearchGuidelineRoutePopupListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriRpMnVO;
import com.hanjin.syscommon.common.table.PriRpScpMnVO;
import com.hanjin.syscommon.common.table.PriRpScpRtCmdtHdrVO;
import com.hanjin.syscommon.common.table.PriRpScpTrspAddChgVO;

/**
 * NIS2010 RFATransportationAdditionalChargeProposalDBDAO <br>
 * - NIS2010-rfaproposal system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author JaeYeon Kim
 * @see RFATransportationAdditionalChargeProposalBCImpl 참조
 * @since J2EE 1.4
 */
public class RFATransportationAdditionalChargeProposalDBDAO extends DBDAOSupport {

	private static final long serialVersionUID = 1L;

	/**
	 * RFA Arbitrary List를 조회한다. <br>
	 * 
	 * @param PriRpScpTrspAddChgVO priRpScpTrspAddChgVO
	 * @param boolean addOnFlag
	 * @return List<RsltArbChgListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<RsltArbChgListVO> searchArbitraryChargeList(PriRpScpTrspAddChgVO priRpScpTrspAddChgVO, boolean addOnFlag) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltArbChgListVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		velParam.put("add_on_flag", addOnFlag ? "Y" : "N");
		try {
			if (priRpScpTrspAddChgVO != null) {
				Map<String, String> mapVO = priRpScpTrspAddChgVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFATransportationAdditionalChargeProposalDBDAORsltArbChgListVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltArbChgListVO.class);
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
	 * RFA Arbitrary 다건의 데이터를 일괄적으로 생성한다.<br>
	 * 
	 * @param List<PriRpScpTrspAddChgVO> insModels
	 * @exception DAOException
	 */
	public void addArbitraryCharge(List<PriRpScpTrspAddChgVO> insModels) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new RFATransportationAdditionalChargeProposalDBDAOPriRpScpTrspAddChgVOCSQL(), insModels, null);
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
	 * RFA Arbitrary를 수정합니다. <br>
	 * 
	 * @param List<PriRpScpTrspAddChgVO> updModels
	 * @param String chkAccept
	 * @exception DAOException
	 */
	public void modifyArbitraryCharge(List<PriRpScpTrspAddChgVO> updModels, String chkAccept) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (updModels.size() > 0) {
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("is_accept", chkAccept);

				updCnt = sqlExe.executeBatch((ISQLTemplate) new RFATransportationAdditionalChargeProposalDBDAOPriRpScpTrspAddChgVOUSQL(), updModels, velParam);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED)
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
	 * RFA Arbitrary 다건의 데이터를 일괄적으로 삭제한다.<br>
	 * 
	 * @param List<PriRpScpTrspAddChgVO> delModels
	 * @exception DAOException
	 */
	public void removeArbitraryCharge(List<PriRpScpTrspAddChgVO> delModels) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				delCnt = sqlExe.executeBatch((ISQLTemplate) new RFATransportationAdditionalChargeProposalDBDAOPriRpScpTrspAddChgVODSQL(), delModels, null);
				for (int i = 0; i < delCnt.length; i++) {
					if (delCnt[i] == Statement.EXECUTE_FAILED)
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
	 * Arbitrary의 Guideline을 생성한다. <br>
	 * 
	 * @param CstPriRpScpTrspAddChgVO cstPriRpScpTrspAddChgVO
	 * @param SignOnUserAccount account
	 * @return boolean
	 * @exception DAOException
	 */
	public boolean addCopyGuidelineArbitraryCharge(CstPriRpScpTrspAddChgVO cstPriRpScpTrspAddChgVO, SignOnUserAccount account) throws DAOException, Exception {
		boolean rtnValue = false;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = cstPriRpScpTrspAddChgVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new RFATransportationAdditionalChargeProposalDBDAOCopyGuidelineArbitraryChargeCSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
			if (result > 0) {
				rtnValue = true;
			} else {
				rtnValue = false;
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return rtnValue;
	}

	/**
	 * Arbitrary Amend를 실행합니다. <br>
	 * 
	 * @param List<PriRpMnVO> insModels
	 * @exception DAOException
	 */
	public void addArbitraryChargeAmend(List<PriRpMnVO> insModels) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new RFATransportationAdditionalChargeProposalDBDAOPriRpScpTrspAddChgAmdVOCSQL(), insModels, null);
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
	 * RFA Proposal Scope Transportation Additional Charge 정보를 Copy 하여 생성합니다.<br>
	 * 
	 * @param RsltRfaPropCopyVO rsltRfaPropCopyVO
	 * @exception DAOException
	 */
	public void addCopyProposalScopeTransport(RsltRfaPropCopyVO rsltRfaPropCopyVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = rsltRfaPropCopyVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new RFATransportationAdditionalChargeProposalDBDAOPropCpPriRpScpTrspAddChgCSQL(), param, velParam);
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
	 * Origin/Destination Arbitrary 를 Proposal 로 Copy 합니다.<br>
	 * 
	 * @param RpScpGlineCopyVO rpScpGlineCopyVO
	 * @exception DAOException
	 */
	public void addCopyScopeGuidelineArbitrary(RpScpGlineCopyVO rpScpGlineCopyVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = rpScpGlineCopyVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new RFATransportationAdditionalChargeProposalDBDAOGlineCopyPriRpScpTrspAddChgCSQL(), param, velParam);
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
	 * Guideline Copy 할 데이터가 존재하는지 확인한다. <br>
	 * 
	 * @param CstPriRpScpTrspAddChgVO cstPriRpScpTrspAddChgVO
	 * @return boolean
	 * @exception DAOException
	 */
	public boolean searchGuidelineArbitraryChargeExist(CstPriRpScpTrspAddChgVO cstPriRpScpTrspAddChgVO) throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		boolean rtnVal = false;
		try {
			if (cstPriRpScpTrspAddChgVO != null) {
				Map<String, String> mapVO = cstPriRpScpTrspAddChgVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFATransportationAdditionalChargeProposalDBDAOGuidelineArbitraryChargeExistRSQL(), param,
					velParam);
			if (dbRowset.next() && dbRowset.getInt("CNT") > 0) {
				rtnVal = true;
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
	 * Guideline Copy할 데이터의 GROUP LOCATION이 등록되어 있는지 확인한다. <br>
	 * 
	 * @param CstPriRpScpTrspAddChgVO cstPriRpScpTrspAddChgVO
	 * @return boolean
	 * @exception DAOException
	 */
	public boolean searchGuidelineArbitraryChargeGroupLocationExist(CstPriRpScpTrspAddChgVO cstPriRpScpTrspAddChgVO) throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		boolean rtnVal = true;
		try {
			if (cstPriRpScpTrspAddChgVO != null) {
				Map<String, String> mapVO = cstPriRpScpTrspAddChgVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new RFATransportationAdditionalChargeProposalDBDAOGuidelineArbitraryChargeGroupLocationExistRSQL(), param, velParam);
			if (dbRowset.next() && dbRowset.getInt("CNT") > 0) {
				rtnVal = false;
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
	 * Terms의 데이터 수를 가져온다.<br>
	 * 
	 * @param PriRpScpMnVO priSpScpMn
	 * @return int
	 * @exception EventException
	 */
	public int searchProposalScopeDeleteCheck(PriRpScpMnVO priSpScpMn) throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int cnt = 0;
		try {
			if (priSpScpMn != null) {
				Map<String, String> mapVO = priSpScpMn.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFATransportationAdditionalChargeProposalDBDAOPriRpScpTrspAddChgDeleteChkVORSQL(), param,
					velParam);
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
	 * Request Cancel시 Main Duration의 Accepted 데이터를 일괄 Init 으로 변경합니다.<br>
	 * 
	 * @param List<PriRpScpMnVO> updModels
	 * @exception EventException
	 */
	public void modifyProposalRequestCancel(List<PriRpScpMnVO> updModels) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (updModels.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new RFATransportationAdditionalChargeProposalDBDAOPriRpScpTrspAddChgRequestCancelVOUSQL(), updModels, null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED)
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
	 * Main의 Init 상태를 Cancel시 해당 Amend Seq NO.의 모든 데이터를 삭제합니다.<br>
	 * 
	 * @param PriRpScpMnVO priRpScpMnVO
	 * @exception DAOException
	 */
	public void removeProposal(PriRpScpMnVO priRpScpMnVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priRpScpMnVO.getColumnValues();

			param.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new RFATransportationAdditionalChargeProposalDBDAOPriRpScpTrspAddChgCancelVODSQL(), param, velParam);
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
	 * 엑셀파일데이터를 생성합니다.<br>
	 * 
	 * @param List<PriRpScpTrspAddChgVO> insModels
	 * @exception DAOException
	 */
	public void addArbitraryExcel(List<PriRpScpTrspAddChgVO> insModels) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new RFATransportationAdditionalChargeProposalDBDAOPriRpScpTrspAddChgExcelVOCSQL(), insModels, null);
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
	 * 공통코드를 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltCdListVO
	 * @param String CodeTp
	 * @return List<RsltCdListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltCdListVO> searchExcelCodeList(RsltCdListVO rsltCdListVO, String CodeTp) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltCdListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (rsltCdListVO != null) {
				Map<String, String> mapVO = rsltCdListVO.getColumnValues();

				param.putAll(mapVO);
				velParam.put("code_tp", CodeTp);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFATransportationAdditionalChargeProposalDBDAORsltCdListVORSQL(), param, velParam);
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
	 * Arbitrary의 ORIGIN과 DESTINATION의 FONT STYLE를 조회합니다. <br>
	 * 
	 * @param CstPriRpScpTrspAddChgVO cstPriRpScpTrspAddChgVO
	 * @return List<ChkFontStyleVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ChkFontStyleVO> searchFontStyle(CstPriRpScpTrspAddChgVO cstPriRpScpTrspAddChgVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ChkFontStyleVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (cstPriRpScpTrspAddChgVO != null) {
				Map<String, String> mapVO = cstPriRpScpTrspAddChgVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFATransportationAdditionalChargeProposalDBDAOChkFontStyleVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ChkFontStyleVO.class);
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
	 * Arbitrary Amend History List를 조회합니다. <br>
	 * 
	 * @param PriRpScpTrspAddChgVO priRpScpTrspAddChgVO
	 * @return List<RsltArbChgListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltArbChgListVO> searchArbitraryChargeHistoryList(PriRpScpTrspAddChgVO priRpScpTrspAddChgVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltArbChgListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priRpScpTrspAddChgVO != null) {
				Map<String, String> mapVO = priRpScpTrspAddChgVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFATransportationAdditionalChargeProposalDBDAORsltArbChgHistoryListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltArbChgListVO.class);
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
	 * Arbitrary의 ORIGIN과 DESTINATION의 FONT STYLE를 조회합니다. <br>
	 * 
	 * @param CstPriRpScpTrspAddChgVO cstPriRpScpTrspAddChgVO
	 * @return List<ChkFontStyleVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ChkFontStyleVO> searchHistoryFontStyle(CstPriRpScpTrspAddChgVO cstPriRpScpTrspAddChgVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ChkFontStyleVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (cstPriRpScpTrspAddChgVO != null) {
				Map<String, String> mapVO = cstPriRpScpTrspAddChgVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFATransportationAdditionalChargeProposalDBDAOChkHistoryFontStyleRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ChkFontStyleVO.class);
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
	 * Arbitrary Inquiry List를 조회합니다. <br>
	 * 
	 * @param PriRpScpTrspAddChgVO priRpScpTrspAddChgVO
	 * @return List<RsltArbChgListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltArbChgListVO> searchArbitraryChargeInquiryList(PriRpScpTrspAddChgVO priRpScpTrspAddChgVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltArbChgListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priRpScpTrspAddChgVO != null) {
				Map<String, String> mapVO = priRpScpTrspAddChgVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFATransportationAdditionalChargeProposalDBDAORsltArbChgInquiryListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltArbChgListVO.class);
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
	 * RFA Arbitrary List를 조회한다. <br>
	 * 
	 * @param FicRouteGLineVO ficRouteGLineVO
	 * @param boolean addOnFlag
	 * @return List<FicRouteGLineVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<FicRouteGLineVO> searchFICRouteByGLine(FicRouteGLineVO ficRouteGLineVO, boolean addOnFlag) throws DAOException {
		DBRowSet dbRowset = null;
		List<FicRouteGLineVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		velParam.put("add_on_flag", addOnFlag ? "Y" : "N");
		try {
			if (ficRouteGLineVO != null) {
				Map<String, String> mapVO = ficRouteGLineVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFATransportationAdditionalChargeProposalDBDAOFICRouteByGlineRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, FicRouteGLineVO.class);
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
	 * Guide Line을 이용하여 FIC Base Port List를 조회한다. <br>
	 * 
	 * @param FicRouteGLineVO ficRouteGLineVO
	 * @param boolean addOnFlag
	 * @return List<FicRouteGLineVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<FicRouteGLineVO> searchFICBasePortListByGLine(FicRouteGLineVO ficRouteGLineVO, boolean addOnFlag) throws DAOException {
		DBRowSet dbRowset = null;
		List<FicRouteGLineVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		velParam.put("add_on_flag", addOnFlag ? "Y" : "N");
		try {
			if (ficRouteGLineVO != null) {
				Map<String, String> mapVO = ficRouteGLineVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFATransportationAdditionalChargeProposalDBDAOFICBasePortListByGLineRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, FicRouteGLineVO.class);
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
	 * Route 정보를 이용하여 Guide Line 정보를 조회한다.<br>
	 * 
	 * @param GLineInfoByFICRouteVO gLineInfoByFICRouteVO
	 * @param boolean addOnFlag
	 * @return List<GLineInfoByFICRouteVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<GLineInfoByFICRouteVO> searchGLineInfoByFICRoute(GLineInfoByFICRouteVO gLineInfoByFICRouteVO, boolean addOnFlag) throws DAOException {
		DBRowSet dbRowset = null;
		List<GLineInfoByFICRouteVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		velParam.put("add_on_flag", addOnFlag ? "Y" : "N");
		try {
			if (gLineInfoByFICRouteVO != null) {
				Map<String, String> mapVO = gLineInfoByFICRouteVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFATransportationAdditionalChargeProposalDBDAOGLineInfoByFICRouteRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, GLineInfoByFICRouteVO.class);
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
	 * ESM_PRI_2029 : Guideline Route Search Pop-Up
	 * 
	 * @param searchGuidelineRouteInquiryVO
	 * @return List<SearchGuidelineRoutePopupListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SearchGuidelineRoutePopupListVO> searchGuidelineRoutePopupList(SearchGuidelineRouteInquiryVO searchGuidelineRouteInquiryVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchGuidelineRoutePopupListVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (searchGuidelineRouteInquiryVO != null) {
				Map<String, String> mapVO = searchGuidelineRouteInquiryVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				velParam.put("list_pnt_loc_cd", searchGuidelineRouteInquiryVO.getPntLocCds());
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFATransportationAdditionalChargeProposalDBDAOSearchGuidelineRoutePopupListRSQL(), param,
					velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchGuidelineRoutePopupListVO.class);
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
	 * Guideline Rate Amount를 Local Currency로 조회한다.
	 * 
	 * @param GLineInfoByFICRouteVO gLineInfoByFICRouteVO
	 * @return GLineInfoByFICRouteVO
	 * @exception DAOException
	 */
	public GLineInfoByFICRouteVO searchFicGlineRtLocalAmt(GLineInfoByFICRouteVO gLineInfoByFICRouteVO) throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (gLineInfoByFICRouteVO != null) {
				Map<String, String> mapVO = gLineInfoByFICRouteVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFATransportationAdditionalChargeProposalDBDAOFicGlineRtLocalAmtRSQL(), param, velParam);
				if (dbRowset.next()) {
					gLineInfoByFICRouteVO.setFicGlineRtAmt(dbRowset.getString(1));
				}
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return gLineInfoByFICRouteVO;
	}

	/**
	 * 엑셀파일데이터를 생성합니다.<br>
	 * 
	 * @param List<PriRpScpTrspAddChgVO> insModels
	 * @exception DAOException
	 */
	public void addArbitraryExcelForIHC(List<PriRpScpTrspAddChgVO> insModels) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new RFATransportationAdditionalChargeProposalDBDAOPriRpScpTrspAddChgExcelForIHCVOCSQL(), insModels, null);
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
	 * RFA Copy시 Arbitrary 의 Guide 값을 업데이트 시켜줌.
	 * 
	 * @param PriRpComVO priRpComVO
	 * @exception DAOException
	 */
	public void modifyPriRpScpTrspAddChgCopy(PriRpComVO priRpComVO) throws DAOException, Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priRpComVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			List<String> sparam = new ArrayList<String>();
			String[] s = priRpComVO.getExceSvcScpCd().split(Pattern.quote(","));
			for (int i = 0; i < s.length; i++) {
				sparam.add(s[i].trim());
			}
			if (sparam.size() > 0) {
				velParam.put("v_param", sparam);
			}

			new SQLExecuter("").executeUpdate((ISQLTemplate) new RFATransportationAdditionalChargeProposalDBDAOPriRpScpTrspAddChgCopyUSQL(), param, velParam);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Summary 팝업에서 승인 대상인 모든 Service Scope Arbitrary 리스트를 조회한다.<br>
	 * 
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @return List<RsltArbChgListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<RsltArbChgListVO> searchAllArbitraryList(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO) throws DAOException, Exception {
		DBRowSet dbRowset = null;
		List<RsltArbChgListVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priRpScpRtCmdtHdrVO != null) {
				Map<String, String> mapVO = priRpScpRtCmdtHdrVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFATransportationAdditionalChargeProposalDBDAORsltAllArbChgListVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltArbChgListVO.class);
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