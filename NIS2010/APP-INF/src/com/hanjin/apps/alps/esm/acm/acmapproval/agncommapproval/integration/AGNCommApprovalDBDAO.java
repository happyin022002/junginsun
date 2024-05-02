/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AGNCommApprovalDBDAO.java
*@FileTitle : AGNCommApprovalDBDAO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.09
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2012.04.09 김영오
* 1.0 Creation
* ---------------------------------------------------------
* History
* 2012.10.19 김봉균 [] Approval Request 시 History 저장
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmapproval.agncommapproval.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.acm.acmapproval.agncommapproval.basic.AGNCommApprovalBCImpl;
import com.hanjin.apps.alps.esm.acm.acmapproval.agncommapproval.vo.AGNCommApprovalDetailVO;
import com.hanjin.apps.alps.esm.acm.acmapproval.agncommapproval.vo.AGNCommApprovalMasterVO;
import com.hanjin.apps.alps.esm.acm.acmapproval.agncommapproval.vo.AGNCommApprovalRequestVO;
import com.hanjin.apps.alps.esm.acm.acmapproval.agncommapproval.vo.AGNCommAsaNoVO;
import com.hanjin.apps.alps.esm.acm.acmapproval.agncommapproval.vo.AGNCommInfoPrintDetailVO;
import com.hanjin.apps.alps.esm.acm.acmapproval.agncommapproval.vo.AGNCommInfoPrintMasterVO;
import com.hanjin.apps.alps.esm.acm.acmapproval.agncommapproval.vo.AGNCommVendorVO;
import com.hanjin.apps.alps.esm.acm.acmapproval.agncommapproval.vo.ReturnCSRDetailVO;
import com.hanjin.apps.alps.esm.acm.acmapproval.agncommapproval.vo.ReturnCSRMasterVO;
import com.hanjin.apps.alps.esm.agt.agtaudit.agtaudit.vo.AgentActualINFtoAPCheckVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

 
/**
 * ALPS AGNCommApprovalDBDAO <br>
 * - ALPS-ACMApproval system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author KIM YOUNG-OH
 * @see AGNCommApprovalBCImpl 참조
 * @since J2EE 1.6
 */
@SuppressWarnings("serial")
public class AGNCommApprovalDBDAO extends DBDAOSupport {

	/**
	 * [ESM_ACM_0009] Agent Commission CSR Creation 상단 Master 목록을 조회
	 * @param agnCommApprovalMasterVO
	 * @return List<AGNCommApprovalMasterVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<AGNCommApprovalMasterVO> searchAGNCommApprovalMaster(AGNCommApprovalMasterVO agnCommApprovalMasterVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AGNCommApprovalMasterVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>(); // query parameter
		Map<String, Object> velParam = new HashMap<String, Object>(); // velocity parameter

		try {
			if (agnCommApprovalMasterVO != null) {
				Map<String, String> mapVO = agnCommApprovalMasterVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGNCommApprovalDBDAOASearchGNCommApprovalMasterListRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, AGNCommApprovalMasterVO.class);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return list;
	}

	/**
	 * [ESM_ACM_0009] Agent Commission CSR Creation 하단 Detail 조회
	 * @param agnCommApprovalDatailVO
	 * @return List<AGNCommApprovalDetailVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<AGNCommApprovalDetailVO> searchAGNCommApprovalDatail(AGNCommApprovalDetailVO agnCommApprovalDatailVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AGNCommApprovalDetailVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>(); // query parameter
		Map<String, Object> velParam = new HashMap<String, Object>(); // velocity parameter

		try {
			if (agnCommApprovalDatailVO != null) {
				Map<String, String> mapVO = agnCommApprovalDatailVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGNCommApprovalDBDAOSearchAGNCommApprovalDetailListRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, AGNCommApprovalDetailVO.class);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return list;
	}

	/**
	 * [ESM_ACM_0009] Agent Commission CSR Creation ESM_ACM_0009 화면에 대한 보고서 출력(Master)
	 * @param acmCommInfoPrintMasterVO
	 * @return List<AGNCommInfoPrintMasterVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<AGNCommInfoPrintMasterVO> searchACMCommInfoPrintMaster(AGNCommInfoPrintMasterVO acmCommInfoPrintMasterVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AGNCommInfoPrintMasterVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>(); // query parameter
		Map<String, Object> velParam = new HashMap<String, Object>(); // velocity parameter

		try {
			if (acmCommInfoPrintMasterVO != null) {
				Map<String, String> mapVO = acmCommInfoPrintMasterVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGNCommApprovalDBDAOSearchACMCommInfoPrintMasterListRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, AGNCommInfoPrintMasterVO.class);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return list;
	}

	/**
	 * [ESM_ACM_0009] Agent Commission CSR Creation ESM_ACM_0009 화면에 대한 보고서 출력(Detail)
	 * @param acmCommInfoPrintDetailVO
	 * @return List<AGNCommInfoPrintDetailVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<AGNCommInfoPrintDetailVO> searchACMCommInfoPrintDetail(AGNCommInfoPrintDetailVO acmCommInfoPrintDetailVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AGNCommInfoPrintDetailVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>(); // query parameter
		Map<String, Object> velParam = new HashMap<String, Object>(); // velocity parameter

		try {
			if (acmCommInfoPrintDetailVO != null) {
				Map<String, String> mapVO = acmCommInfoPrintDetailVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGNCommApprovalDBDAOSearchACMCommInfoPrintDetailListRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, AGNCommInfoPrintDetailVO.class);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return list;
	}

	/**
	 * [ESM_ACM_0009] Agent Commission CSR Creation ESM_ACM_0009 화면 조회조건 ASA No 조회
	 * @param agnCommAsaNoVO
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<AGNCommAsaNoVO> getAsaNoList(AGNCommAsaNoVO agnCommAsaNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AGNCommAsaNoVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>(); // query parameter
		Map<String, Object> velParam = new HashMap<String, Object>(); // velocity parameter

		try {
			if (agnCommAsaNoVO != null) {
				Map<String, String> mapVO = agnCommAsaNoVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGNCommApprovalDBDAOGetACMCommAsaNoListRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, AGNCommAsaNoVO.class);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return list;
	}

	/**
	 * [ESM_ACM_0009] Agent Commission CSR Creation ESM_ACM_0009 화면 조회조건 Vendor 조회
	 * @param angCommVendorVO
	 * @return List<AGNCommVendorVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<AGNCommVendorVO> getVendorInfo(AGNCommVendorVO angCommVendorVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AGNCommVendorVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>(); // query parameter
		Map<String, Object> velParam = new HashMap<String, Object>(); // velocity parameter

		try {
			if (angCommVendorVO != null) {
				Map<String, String> mapVO = angCommVendorVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGNCommApprovalDBDAOGetACMCommVendorInfoRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, AGNCommVendorVO.class);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return list;
	}

	/**
	 * [ESM_ACM_0013] Returned CSR Master 목록을 조회
	 * @param returnCSRMasterVO
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<ReturnCSRMasterVO> searchReturnCSRMaster(ReturnCSRMasterVO returnCSRMasterVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ReturnCSRMasterVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>(); // query parameter
		Map<String, Object> velParam = new HashMap<String, Object>(); // velocity parameter

		try {
			if (returnCSRMasterVO != null) {
				Map<String, String> mapVO = returnCSRMasterVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGNCommApprovalDBDAOSearchReturnCSRMasterListRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, ReturnCSRMasterVO.class);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return list;
	}

	/**
	 * [ESM_ACM_0013] Returned CSR Detail 목록을 조회
	 * @param returnCSRMasterVO
	 * @return List<ReturnCSRDetailVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<ReturnCSRDetailVO> searchReturnCSRDetail(ReturnCSRMasterVO returnCSRMasterVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ReturnCSRDetailVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>(); // query parameter
		Map<String, Object> velParam = new HashMap<String, Object>(); // velocity parameter

		try {
			if (returnCSRMasterVO != null) {
				Map<String, String> mapVO = returnCSRMasterVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGNCommApprovalDBDAOSearchReturnCSRDetailListRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, ReturnCSRDetailVO.class);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return list;
	}

	/**
	 * [ESM_ACM_0013] Reprocess to Audit Confirm<br>
	 * Aud No.를 얻는다.<br>
	 *
	 * @param String csrNo
	 * @return String audNo
	 * @exception EventException
	 */
	public String getAudNo(String csrNo) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnValue = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			param.put("csr_no", csrNo);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGNCommApprovalDBDAOGetAudNoInfoRSQL(), param, null);
			if(dbRowset.next()) {
				rtnValue = dbRowset.getString("AUD_NO");
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
	}

	/**
	 * [ESM_ACM_0013] Reprocess to Audit Confirm<br>
	 * Aud No.를 업데이트 한다.<br>
	 *
	 * @param ReturnCSRMasterVO returnCSRMasterVO
	 * @throws DAOException
	 */
	public void modifyReturnCSRAuditConfirm(ReturnCSRMasterVO returnCSRMasterVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		int result = 0;
		try {
			if(returnCSRMasterVO != null){
				Map<String, String> mapVo = returnCSRMasterVO .getColumnValues();
				param.putAll(mapVo);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			result = sqlExe.executeUpdate((ISQLTemplate)new AGNCommApprovalDBDAOModifyReturnCSRAuditConfirmInfoUSQL(), param,null);
			log.debug("result==>"+result);
			if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_ACM_0013] Reprocess to Audit Confirm<br>
	 * Aud No.를 업데이트 한다.<br>
	 *
	 * @param ReturnCSRMasterVO returnCSRMasterVO
	 * @throws DAOException
	 */
	public void modifyReturnCSRAuditConfirm2(ReturnCSRMasterVO returnCSRMasterVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		int result = 0;
		try {
			if(returnCSRMasterVO != null){
				Map<String, String> mapVo = returnCSRMasterVO .getColumnValues();
				param.putAll(mapVo);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			result = sqlExe.executeUpdate((ISQLTemplate)new AGNCommApprovalDBDAOModifyReturnCSRAuditConfirmInfo2USQL(), param,null);
			log.debug("result==>"+result);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_ACM_0013] Audit Confirm 처리한 내용을 조회한다.
	 * @param returnCSRMasterVO
	 * @return List<ReturnCSRDetailVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<ReturnCSRDetailVO> searchReturnCSRAuditConfirm(ReturnCSRMasterVO returnCSRMasterVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ReturnCSRDetailVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>(); // query parameter

		try {
			if (returnCSRMasterVO != null) {
				param.putAll(returnCSRMasterVO.getColumnValues());

				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGNCommApprovalDBDAOSearchReturnCSRAuditConfirmListRSQL(), param, null);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, ReturnCSRDetailVO.class);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return list;
	}

	/**
	 * [ESM_ACM_0013] CSR Cancel<br>
	 * Interface Cancel 처리<br>
	 *
	 * @param AGNCommApprovalRequestVO agnCommApprovalRequestVO
	 * @throws DAOException
	 */
	public void manageAGNCommCSRCancel(AGNCommApprovalRequestVO agnCommApprovalRequestVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			if(agnCommApprovalRequestVO != null){
				Map<String, String> mapVo = agnCommApprovalRequestVO.getColumnValues();
				param.putAll(mapVo);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int result = sqlExe.executeUpdate((ISQLTemplate)new AGNCommApprovalDBDAOManageAGNCommCSRCancelUSQL(), param, null);
			
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_ACM_0009] Approval Request<br>
	 * Booking Status 를 체크한다.<br>
	 *
	 * @param AGNCommApprovalMasterVO agnCommApprovalMasterVO
	 * @return String
	 * @exception EventException
	 */
	public String getBKGStsCdInfo(AGNCommApprovalMasterVO agnCommApprovalMasterVO) throws DAOException {
		DBRowSet dbRowset = null;
		String bkgSts = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if(agnCommApprovalMasterVO != null){
				Map<String, String> mapVO = agnCommApprovalMasterVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGNCommApprovalDBDAOGetBKGStsCdInfoRSQL(), param, velParam);
			while(dbRowset.next()) {
				bkgSts = dbRowset.getString("BKG_STS_CD");
				if("X".equals(bkgSts) || "A".equals(bkgSts)) {
					return bkgSts;
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return "";
	}

	/**
	 * [ESM_ACM_0009] Approval Request<br>
	 * MDM_ORGANIZATION의 AR_OFC_CD를 얻는다.<br>
	 *
	 * @param String agnCd
	 * @return String 
	 * @exception EventException
	 */
	public String getMdmArOfcCd(String agnCd, String arOfcCd) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnValue = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			param.put("agn_cd", agnCd);
			param.put("ar_ofc_cd", arOfcCd);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGNCommApprovalDBDAOGetMdmArOfcCdInfoRSQL(), param, null);
			if(dbRowset.next()) {
				rtnValue = dbRowset.getString("AR_OFC_CD");
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
	}

	/**
	 * [ESM_ACM_0009] Approval Request<br>
	 * REV VVD를 수정한다.<br>
	 *
	 * @param AGNCommApprovalRequestVO agnCommApprovalRequestVO
	 * @exception DAOException
	 */
	public void modifyAcmCommBkgInfoRevVVD(AGNCommApprovalRequestVO agnCommApprovalRequestVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try{
			if(agnCommApprovalRequestVO != null){
				Map<String, String> mapVo = agnCommApprovalRequestVO .getColumnValues();
				param.putAll(mapVo);
				velParam.putAll(mapVo);
				log.debug("<==>"+param.toString());
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			result = sqlExe.executeUpdate((ISQLTemplate)new AGNCommApprovalDBDAOModifyAcmCommBkgInfoRevVVDUSQL(), param,velParam);

			if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_ACM_0009] Agent Commission CSR Creation 목록에 대한 체크조건을 조회한다.
	 * @param agnCommApprovalRequestVO
	 * @return AGNCommApprovalRequestVO
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public AGNCommApprovalRequestVO getAcmCsrCondInfo(AGNCommApprovalRequestVO agnCommApprovalRequestVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AGNCommApprovalRequestVO> list = null;
		AGNCommApprovalRequestVO result = null;
		Map<String, Object> param = new HashMap<String, Object>(); // query parameter
		Map<String, Object> velParam = new HashMap<String, Object>(); // velocity parameter

		try {
			if (agnCommApprovalRequestVO != null) {
				Map<String, String> mapVO = agnCommApprovalRequestVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGNCommApprovalDBDAOGetAcmCsrCondInfoRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, AGNCommApprovalRequestVO.class);
				if (list != null && list.size() > 0) {
					result = list.get(0);
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return result;
	}

	/**
	 * [ESM_ACM_0009] Approval Request<br>
	 * AP_CSR_NO 테이블에 csr_no를 생성한다.<br>
	 *
	 * @param AGNCommApprovalRequestVO agnCommApprovalRequestVO
	 * @throws DAOException
	 */
	public void addCsrHeaderApCsrNo(AGNCommApprovalRequestVO agnCommApprovalRequestVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try{
			if(agnCommApprovalRequestVO != null){
				Map<String, String> mapVo = agnCommApprovalRequestVO .getColumnValues();
				param.putAll(mapVo);
				velParam.putAll(mapVo);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			result = sqlExe.executeUpdate((ISQLTemplate)new AGNCommApprovalDBDAOAddCsrHeaderApCsrNoInfoCSQL(), param,velParam);

			if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_ACM_0009] ACM_AGN_COMM테이블에 해당 AUD_NO가 있는지를 조회
	 * @param agnCommApprovalRequestVO
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<AGNCommApprovalRequestVO> getAudNoFromAcmAgmComm(AGNCommApprovalRequestVO agnCommApprovalRequestVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AGNCommApprovalRequestVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>(); // query parameter
		Map<String, Object> velParam = new HashMap<String, Object>(); // velocity parameter

		try {
			if (agnCommApprovalRequestVO != null) {
				Map<String, String> mapVO = agnCommApprovalRequestVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGNCommApprovalDBDAOGetAudNoFromAcmAgmCommRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, AGNCommApprovalRequestVO.class);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return list;
	}

	/**
	 * [ESM_ACM_0009] Approval Request<br>
	 * ACM_AGN_COMM 테이블에 데이터를 업데이트한다.<br>
	 *
	 * @param AGNCommApprovalRequestVO agnCommApprovalRequestVO
	 * @throws DAOException
	 */
	public void modifyCsrHeaderAcmAgnComm(AGNCommApprovalRequestVO agnCommApprovalRequestVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {
			if(agnCommApprovalRequestVO != null){
				Map<String, String> mapVo = agnCommApprovalRequestVO .getColumnValues();
				param.putAll(mapVo);
				velParam.putAll(mapVo);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			result = sqlExe.executeUpdate((ISQLTemplate)new AGNCommApprovalDBDAOModifyCsrHeaderAcmAgnCommInfoUSQL(), param, velParam);

			if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_ACM_0009] Approval Request<br>
	 * ACM_AGN_COMM_DTL 테이블에 데이터를 업데이트한다.<br>
	 *
	 * @param AGNCommApprovalRequestVO agnCommApprovalRequestVO
	 * @throws DAOException
	 */
	public void modifyCsrHeaderAcmAgnCommDtl(AGNCommApprovalRequestVO agnCommApprovalRequestVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {
			if(agnCommApprovalRequestVO != null){
				Map<String, String> mapVo = agnCommApprovalRequestVO .getColumnValues();
				param.putAll(mapVo);
				velParam.putAll(mapVo);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			result = sqlExe.executeUpdate((ISQLTemplate)new AGNCommApprovalDBDAOModifyCsrHeaderAcmAgnCommDtlInfoUSQL(), param, velParam);

			if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_ACM_0009] Approval Request<br>
	 * ACM_AGN_OTR_COMM 테이블에 데이터를 업데이트한다.<br>
	 *
	 * @param AGNCommApprovalRequestVO agnCommApprovalRequestVO
	 * @throws DAOException
	 */
	public void modifyCsrHeaderAcmAgnOtrComm(AGNCommApprovalRequestVO agnCommApprovalRequestVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {
			if(agnCommApprovalRequestVO != null){
				Map<String, String> mapVo = agnCommApprovalRequestVO .getColumnValues();
				param.putAll(mapVo);
				velParam.putAll(mapVo);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			result = sqlExe.executeUpdate((ISQLTemplate)new AGNCommApprovalDBDAOModifyCsrHeaderAcmAgnOtrCommInfoUSQL(), param, velParam);

			if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_ACM_0009] Approval Request<br>
	 * AP_INV_HDR 테이블에 데이터를 생성한다.<br>
	 *
	 * @param AGNCommApprovalRequestVO agnCommApprovalRequestVO
	 * @throws DAOException
	 */
	public void addCsrHeaderApInvHdr(AGNCommApprovalRequestVO agnCommApprovalRequestVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {
			if(agnCommApprovalRequestVO != null){
				Map<String, String> mapVo = agnCommApprovalRequestVO .getColumnValues();
				param.putAll(mapVo);
				velParam.putAll(mapVo);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			result = sqlExe.executeUpdate((ISQLTemplate)new AGNCommApprovalDBDAOAddCsrHeaderApInvHdrInfoCSQL(), param,velParam);

			if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_ACM_0009] Approval Request<br>
	 * AP_INV_DTRB 테이블에 데이터를 생성한다.<br>
	 *
	 * @param AGNCommApprovalRequestVO agnCommApprovalRequestVO
	 * @throws DAOException
	 */
	public void addCsrHeaderApInvDtrb(AGNCommApprovalRequestVO agnCommApprovalRequestVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {
			if(agnCommApprovalRequestVO != null) {
				Map<String, String> mapVo = agnCommApprovalRequestVO .getColumnValues();
				param.putAll(mapVo);
				velParam.putAll(mapVo);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			result = sqlExe.executeUpdate((ISQLTemplate)new AGNCommApprovalDBDAOAddCsrHeaderApInvDtrbInfoCSQL(), param,velParam);

			if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_ACM_0009] Approval Request<br>
	 * AP_INV_DTRB 테이블에 데이터를 업데이트한다.<br>
	 *
	 * @param AGNCommApprovalRequestVO agnCommApprovalRequestVO
	 * @throws DAOException
	 */
	public void modifyCsrHeaderApInvDtrb(AGNCommApprovalRequestVO agnCommApprovalRequestVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {
			if(agnCommApprovalRequestVO != null) {
				Map<String, String> mapVo = agnCommApprovalRequestVO .getColumnValues();
				param.putAll(mapVo);
				velParam.putAll(mapVo);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			result = sqlExe.executeUpdate((ISQLTemplate)new AGNCommApprovalDBDAOModifyCsrHeaderApInvDtrbInfoUSQL(), param,velParam);

			if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_ACM_0009] Agent Commission CSR Creation 목록에 대한 체크조건을 조회한다.
	 * @param agnCommApprovalRequestVO
	 * @return AGNCommApprovalRequestVO
	 * @throws DAOException
	 * @throws EventException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public AGNCommApprovalRequestVO getCsrHeaderApInvHdrInfo(AGNCommApprovalRequestVO agnCommApprovalRequestVO) throws DAOException, EventException{
		DBRowSet dbRowset = null;
		List<AGNCommApprovalRequestVO> list = null;
		AGNCommApprovalRequestVO result = null;
		Map<String, Object> param = new HashMap<String, Object>(); // query parameter
		Map<String, Object> velParam = new HashMap<String, Object>(); // velocity parameter

		try {
			if (agnCommApprovalRequestVO != null) {
				Map<String, String> mapVO = agnCommApprovalRequestVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGNCommApprovalDBDAOGetCsrHeaderApInvHdrInfoRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, AGNCommApprovalRequestVO.class);
				if (list != null && list.size() > 0) {
					result = list.get(0);
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return result;
	}

	/**
	 * [ESM_ACM_0009] Approval Request<br>
	 * ACM_AGN_COMM 테이블에 데이터를 업데이트한다.<br>
	 *
	 * @param AGNCommApprovalRequestVO agnCommApprovalRequestVO
	 * @throws DAOException
	 */
	public void modifyCsrHeaderAcmAgnComm2(AGNCommApprovalRequestVO agnCommApprovalRequestVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {
			if(agnCommApprovalRequestVO != null) {
				Map<String, String> mapVo = agnCommApprovalRequestVO .getColumnValues();
				param.putAll(mapVo);
				velParam.putAll(mapVo);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			result = sqlExe.executeUpdate((ISQLTemplate)new AGNCommApprovalDBDAOModifyCsrHeaderAcmAgnComm2InfoUSQL(), param,velParam);

			if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_ACM_0009] Approval Request<br>
	 * ACM_AGN_OTR_COMM 테이블에 데이터를 업데이트한다.<br>
	 *
	 * @param AGNCommApprovalRequestVO agnCommApprovalRequestVO
	 * @throws DAOException
	 */
	public void modifyCsrHeaderAcmAgnOtrComm2(AGNCommApprovalRequestVO agnCommApprovalRequestVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {
			if(agnCommApprovalRequestVO != null) {
				Map<String, String> mapVo = agnCommApprovalRequestVO .getColumnValues();
				param.putAll(mapVo);
				velParam.putAll(mapVo);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			result = sqlExe.executeUpdate((ISQLTemplate)new AGNCommApprovalDBDAOModifyCsrHeaderAcmAgnOtrComm2InfoUSQL(), param,velParam);

			if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * [ESM_ACM_0009] Approval Request<br>
	 * ACM_AGN_OTR_COMM 테이블에 데이터를 업데이트한다.<br>
	 *
	 * @param AGNCommApprovalRequestVO agnCommApprovalRequestVO
	 * @throws DAOException
	 */
	public void modifyCsrHeaderAcmAgnOtrComm3(AGNCommApprovalRequestVO agnCommApprovalRequestVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {
			if(agnCommApprovalRequestVO != null) {
				Map<String, String> mapVo = agnCommApprovalRequestVO .getColumnValues();
				param.putAll(mapVo);
				velParam.putAll(mapVo);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			result = sqlExe.executeUpdate((ISQLTemplate)new AGNCommApprovalDBDAOModifyCsrHeaderAcmAgnOtrComm3InfoUSQL(), param,velParam);

			if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_ACM_0009] Approval Request<br>
	 * AP_INV_HDR 테이블에 데이터를 업데이트한다.<br>
	 *
	 * @param AGNCommApprovalRequestVO agnCommApprovalRequestVO
	 * @throws DAOException
	 */
	public void modifyCsrHeaderApInvHdr(AGNCommApprovalRequestVO agnCommApprovalRequestVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {
			if(agnCommApprovalRequestVO != null) {
				Map<String, String> mapVo = agnCommApprovalRequestVO .getColumnValues();
				param.putAll(mapVo);
				velParam.putAll(mapVo);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			result = sqlExe.executeUpdate((ISQLTemplate)new AGNCommApprovalDBDAOModifyCsrHeaderApInvHdrInfoUSQL(), param,velParam);

			if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_ACM_0009] Approval Request<br>
	 * CALC_NO를 구한다.<br>
	 *
	 * @return String
	 * @throws DAOException
	 */
	public String getCalcNo() throws DAOException {
		DBRowSet dbRowset = null;
		String calcNo = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGNCommApprovalDBDAOGetCalcNoInfoRSQL(), param, null);
			if(dbRowset.next()) {
				calcNo = dbRowset.getString(1);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return calcNo;
	}
	
	/**
	 * [ESM_ACM_0009] Approval Request<br>
	 * ACM_AGN_COMM_CHG_HIS 저장<br>
	 *
	 * @param AGNCommApprovalRequestVO agnCommApprovalRequestVO
	 * @throws DAOException
	 */
	public void addAcmAgnCommChgHis(AGNCommApprovalRequestVO agnCommApprovalRequestVO) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			if (agnCommApprovalRequestVO != null) {
				Map<String, String> mapVO= agnCommApprovalRequestVO.getColumnValues();
				
				param.putAll(mapVO);
			}
			int intCnt = sqlExe.executeUpdate((ISQLTemplate) new AGNCommApprovalDBDAOAddAcmAgnCommChgHisCSQL(), param, null);
			if (intCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert");
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * [ESM_ACM_0009] Approval Request<br>
	 * ACM_AGN_COMM_TRSP_HIS 저장<br>
	 *
	 * @param AGNCommApprovalRequestVO agnCommApprovalRequestVO
	 * @throws DAOException
	 */
	public void addAcmAgnCommTrspHis(AGNCommApprovalRequestVO agnCommApprovalRequestVO) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			if (agnCommApprovalRequestVO != null) {
				Map<String, String> mapVO= agnCommApprovalRequestVO.getColumnValues();
				
				param.putAll(mapVO);
			}
			int intCnt = sqlExe.executeUpdate((ISQLTemplate) new AGNCommApprovalDBDAOAddAcmAgnCommTrspHisCSQL(), param, null);
			if (intCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert");
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_ACM_0009] Approval Request<br>
	 * ACM_AGN_COMM_DTL_HIS 저장<br>
	 *
	 * @param AGNCommApprovalRequestVO agnCommApprovalRequestVO
	 * @throws DAOException
	 */
	public void addAcmAgnCommDtlHis(AGNCommApprovalRequestVO agnCommApprovalRequestVO) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			if (agnCommApprovalRequestVO != null) {
				Map<String, String> mapVO= agnCommApprovalRequestVO.getColumnValues();

				param.putAll(mapVO);
			}
			int intCnt = sqlExe.executeUpdate((ISQLTemplate) new AGNCommApprovalDBDAOAddAcmAgnCommDtlHisCSQL(), param, null);
			if (intCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert");

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_ACM_0009] Approval Request<br>
	 * ACM_AGN_COMM_HIS 저장<br>
	 *
	 * @param AGNCommApprovalRequestVO agnCommApprovalRequestVO
	 * @throws DAOException
	 */
	public void addAcmAgnCommHis(AGNCommApprovalRequestVO agnCommApprovalRequestVO) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			if (agnCommApprovalRequestVO != null) {
				Map<String, String> mapVO= agnCommApprovalRequestVO.getColumnValues();

				param.putAll(mapVO);
			}
			int intCnt = sqlExe.executeUpdate((ISQLTemplate) new AGNCommApprovalDBDAOAddAcmAgnCommHisCSQL(), param, null);
			if (intCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert");

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * [ESM_ACM_0009] Approval Request<br>
	 *  CSR Cancel 시의 ACM_AGN_COMM_HIS 저장<br>
	 *
	 * @param AGNCommApprovalRequestVO agnCommApprovalRequestVO
	 * @throws DAOException
	 */
	public void addAcmAgnCommCSRCancelHis(AGNCommApprovalRequestVO agnCommApprovalRequestVO) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			if (agnCommApprovalRequestVO != null) {
				Map<String, String> mapVO= agnCommApprovalRequestVO.getColumnValues();
				
				param.putAll(mapVO);
			}
			int intCnt = sqlExe.executeUpdate((ISQLTemplate) new AGNCommApprovalDBDAOAddAcmAgnCommCSRCancelHisCSQL(), param, null);
			if (intCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert");
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_ACM_0009] Approval Request<br>
	 * Agent Commission CSR Creation화면의 Audit Reject기능을 수행한다.<br>
	 *
	 * @param List<AGNCommApprovalMasterVO> agnCommApprovalMasterVO
	 * @throws DAOException
	 */
	public void modifyAGNCommAuditReject(List<AGNCommApprovalMasterVO> agnCommApprovalMasterVO) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (agnCommApprovalMasterVO.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate)new AGNCommApprovalDBDAOModifyAGNCommAuditRejectUSQL(), agnCommApprovalMasterVO, null);
				for (int i=0; i<updCnt.length; i++) {
					if (updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to Update No"+ i + " SQL");//AGNCommApprovalDBDAO
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * (ESM_AGT_017) Agent Commission AP Interface 대상리스트에 대한 체크조건을 조회 한다.<br>
	 * @param agentActualINFtoAPCheckVO
	 * @return AgentActualINFtoAPCheckVO
	 * @throws DAOException
	 * @throws EventException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public AgentActualINFtoAPCheckVO searchACMCSRInfo(AgentActualINFtoAPCheckVO agentActualINFtoAPCheckVO) throws DAOException, EventException{
		DBRowSet dbRowset = null;
		List<AgentActualINFtoAPCheckVO> list = null;
		AgentActualINFtoAPCheckVO result = null;
		Map<String, Object> param = new HashMap<String, Object>(); // query parameter
		Map<String, Object> velParam = new HashMap<String, Object>(); // velocity parameter

		try {
			if (agentActualINFtoAPCheckVO != null) {
				Map<String, String> mapVO = agentActualINFtoAPCheckVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGNCommApprovalDBDAOSearchACMCSRInfoRSQL(), param, velParam);
				if (0 < dbRowset.getRowCount()) {
					list = (List)RowSetUtil.rowSetToVOs(dbRowset, AgentActualINFtoAPCheckVO.class);
					result = list.get(0);
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return result;
    }

	/**
	 * (ESM_AGT_017) Ap_Csr_No 테이블에 csr_no를 생성한다.<br>
	 * @param AgentActualINFtoAPCheckVO agentActualINFtoAPCheckVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int modifyACMApprovalRequesttoEP(AgentActualINFtoAPCheckVO agentActualINFtoAPCheckVO) throws DAOException, Exception{
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try{
			if(agentActualINFtoAPCheckVO != null){
				Map<String, String> mapVo = agentActualINFtoAPCheckVO .getColumnValues();
				param.putAll(mapVo);
				velParam.putAll(mapVo);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			result = sqlExe.executeUpdate((ISQLTemplate)new AGNCommApprovalDBDAOModifyACMApprovalRequesttoEPUSQL(), param,velParam);
			
			if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
		}catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	/**
	 * (ESM_AGT_017) Ap_Csr_No 테이블에 csr_no를 생성한다.<br>
	 * @param AgentActualINFtoAPCheckVO agentActualINFtoAPCheckVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int modifyACMOtherApprovalRequesttoEP(AgentActualINFtoAPCheckVO agentActualINFtoAPCheckVO) throws DAOException, Exception{
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try{
			if(agentActualINFtoAPCheckVO != null){
				Map<String, String> mapVo = agentActualINFtoAPCheckVO .getColumnValues();
				param.putAll(mapVo);
				velParam.putAll(mapVo);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			result = sqlExe.executeUpdate((ISQLTemplate)new AGNCommApprovalDBDAOModifyACMOtherApprovalRequesttoEPUSQL(), param,velParam);
			
			if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
		}catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	/**
	 * (ESM_AGT_017) Agent Commission AP Interface 대상리스트에 대한 체크조건을 조회 한다.<br>
	 * @param AgentActualINFtoAPCheckVO agentActualINFtoAPCheckVO
	 * @return DBRowSet
	 * @throws DAOException
	 * @throws EventException
	 */
	public DBRowSet searchAgentActualINFtoAP(AgentActualINFtoAPCheckVO agentActualINFtoAPCheckVO) throws DAOException, EventException{
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(agentActualINFtoAPCheckVO != null){
				Map<String, String> mapVO = agentActualINFtoAPCheckVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				log.info("\n >>>>velParam="+velParam);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGNCommApprovalDBDAOSearchAgentActualINFtoAPRSQL(), param, velParam);
			if ( 1 > dbRowset.getRowCount())
			{
				//CSR No has already Interfaced! Please check up CSR No[$]
				throw new DAOException((new ErrorHandler("AGT00029", agentActualINFtoAPCheckVO.getCsrNo())).getMessage());
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
    }
	/**
	 * (ESM_AGT_017) Ap_Csr_No 테이블에 csr_no를 생성한다.<br>
	 * @param AgentActualINFtoAPCheckVO agentActualINFtoAPCheckVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int modifyApprovalStep(AgentActualINFtoAPCheckVO agentActualINFtoAPCheckVO) throws DAOException, Exception{
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try{
			if(agentActualINFtoAPCheckVO != null){
				Map<String, String> mapVo = agentActualINFtoAPCheckVO .getColumnValues();
				param.putAll(mapVo);
				velParam.putAll(mapVo);
				log.info("\n >>>>param="+param);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			result = sqlExe.executeUpdate((ISQLTemplate)new AGNCommApprovalDBDAOModifyApprovalStepUSQL(), param,velParam);
			
			if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
		}catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	/**
	 * (ESM_AGT_017) Ap_Csr_No 테이블에 csr_no를 생성한다.<br>
	 * @param AgentActualINFtoAPCheckVO agentActualINFtoAPCheckVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int modifyAGTCommInfo(AgentActualINFtoAPCheckVO agentActualINFtoAPCheckVO) throws DAOException, Exception{
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try{
			if(agentActualINFtoAPCheckVO != null){
				Map<String, String> mapVo = agentActualINFtoAPCheckVO .getColumnValues();
				param.putAll(mapVo);
				velParam.putAll(mapVo);
				log.info("\n >>>>param="+param);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			result = sqlExe.executeUpdate((ISQLTemplate)new AGNCommApprovalDBDAOModifyACMCommInfoUSQL(), param,velParam);
			
			if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
		}catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	/**
	 * (ESM_AGT_017) Ap_Csr_No 테이블에 csr_no를 생성한다.<br>
	 * @param AgentActualINFtoAPCheckVO agentActualINFtoAPCheckVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int modifyAGTOtherCommInfo(AgentActualINFtoAPCheckVO agentActualINFtoAPCheckVO) throws DAOException, Exception{
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try{
			if(agentActualINFtoAPCheckVO != null){
				Map<String, String> mapVo = agentActualINFtoAPCheckVO .getColumnValues();
				param.putAll(mapVo);
				velParam.putAll(mapVo);
				log.info("\n >>>>param="+param);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			result = sqlExe.executeUpdate((ISQLTemplate)new AGNCommApprovalDBDAOModifyACMOtherCommInfoUSQL(), param,velParam);
			
			if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
		}catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}

	/**
	 * GW&Approval 분기로직
	 * @param agnCommApprovalRequestVO
	 * @return AGNCommApprovalRequestVO
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public AGNCommApprovalRequestVO getApprovedYN(AGNCommApprovalRequestVO agnCommApprovalRequestVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AGNCommApprovalRequestVO> list = null;
		AGNCommApprovalRequestVO result = null;
		Map<String, Object> param = new HashMap<String, Object>(); // query parameter
		Map<String, Object> velParam = new HashMap<String, Object>(); // velocity parameter

		try {
			if (agnCommApprovalRequestVO != null) {
				Map<String, String> mapVO = agnCommApprovalRequestVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGNCommApprovalDBDAOGetApprovedYNRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, AGNCommApprovalRequestVO.class);
				if (list != null && list.size() > 0) {
					result = list.get(0);
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return result;
	}

	/**
	 * [ESM_ACM_0009] Agent Commission CSR Creation ESM_ACM_0009 GW 전송용 전표(Master)
	 * @param acmCommInfoPrintMasterVO
	 * @return List<AGNCommInfoPrintMasterVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<AGNCommInfoPrintMasterVO> searchGWACMCommInfoPrintMaster(AGNCommInfoPrintMasterVO acmCommInfoPrintMasterVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AGNCommInfoPrintMasterVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>(); // query parameter
		Map<String, Object> velParam = new HashMap<String, Object>(); // velocity parameter

		try {
			if (acmCommInfoPrintMasterVO != null) {
				Map<String, String> mapVO = acmCommInfoPrintMasterVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGNCommApprovalDBDAOSearchGWACMCommInfoPrintMasterListRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, AGNCommInfoPrintMasterVO.class);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return list;
	}

	/**
	 * [ESM_ACM_0009] Agent Commission CSR Creation ESM_ACM_0009 GW 전송용 전표(Detail)
	 * @param acmCommInfoPrintDetailVO
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<AGNCommInfoPrintDetailVO> searchGWACMCommInfoPrintDetail(AGNCommInfoPrintDetailVO acmCommInfoPrintDetailVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AGNCommInfoPrintDetailVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>(); // query parameter
		Map<String, Object> velParam = new HashMap<String, Object>(); // velocity parameter

		try {
			if (acmCommInfoPrintDetailVO != null) {
				Map<String, String> mapVO = acmCommInfoPrintDetailVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGNCommApprovalDBDAOSearchGWACMCommInfoPrintDetailListRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, AGNCommInfoPrintDetailVO.class);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return list;
	}	 
}