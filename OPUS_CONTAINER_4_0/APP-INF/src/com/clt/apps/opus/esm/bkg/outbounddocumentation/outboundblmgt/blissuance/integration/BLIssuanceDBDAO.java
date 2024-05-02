/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : BLIssuanceDBDAO.java
 *@FileTitle : Group & Multi B/L Print
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.29
 *@LastModifier : 박준용
 *@LastVersion : 1.0
 * 2009.04.29 박준용
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.BlIssVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.OtsRcvInfoVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.basic.BLIssuanceBCImpl;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.AgentEmlVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.AuthCustVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.BkgDocIssHisVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.BkgDocIssRdemVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.BkgWebService004VO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.BlIssInfoVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.BlPrintRcvFtpVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.BlStatusVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.CanonEmlBkgVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.CanonEmlVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.DblEdiCntrVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.DblEdiInVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.DblEdiInfoVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.DblWblCntVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.DblWblVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.DocRqstVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.EmlBkgInfoVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.GrpBlDtInVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.GrpBlDtListVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.GrpBlPrtInVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.GrpBlPrtVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.InDblWblInVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.MultiNtcHisVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.ObDblWblInVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.RdApplCdFtpVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.ReIssueInfoVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.SeaWayBillPrintVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.SearchBlCompleteRcvEmlVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.SearchBlNtcHisVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.SearchBlPrintRcvEmlVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.SearchRcvEmlVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.SrndVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.DblEdiCmdtCntrVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.DblEdiBlClauseVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.BkgAutoEmlVO;
import com.clt.syscommon.common.table.BkgBlIssVO;
import com.clt.syscommon.common.table.BkgBookingVO;

/**
 * OPUS BLIssuanceDBDAO <br>
 * - OPUS-OutboundBLMgt system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Joon Yong Park
 * @see BLIssuanceBCImpl 참조
 * @since J2EE 1.4
 */
public class BLIssuanceDBDAO extends DBDAOSupport {
	private static final long serialVersionUID = 1709192861312284848L;

 
	/**
	 * searchBlStatus 상태값을 조회한다.(ESM_BKG_0079_09)<br>
	 * @author 	LEE JIN SEO
	 * @param 	String bkgNo
	 * @return 	BlStatusVO
	 * @exception 	DAOException
	 */
	 @SuppressWarnings("unchecked")
	public BlStatusVO searchBlStatus(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<BlStatusVO> list = null;
		BlStatusVO blStatusVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			param.put("bkg_no", bkgNo);
			velParam.put("bkg_no", bkgNo);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BLIssuanceDBDAOsearchBlStatusRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BlStatusVO .class);
			if(list != null && list.size() > 0){
				blStatusVO = list.get(0);
			}
		}catch(SQLException ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}catch(Exception ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return blStatusVO;
	}
	/**
	 * B/L Issue 정보 조회 데이타 모델에 해당되는 값을 불러온다.<br>
	 * B/L Type, Freight 지불 여부 등의 B/L 발행 전 필요사항을 기입
	 * ESM_BKG-0079-9	연동 System	
	 * @author LEE JIN SEO
	 * @param String bkg_no
	 * @param String usr_id
	 * @return List<BlIssInfoVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BlIssInfoVO> searchBlIssInfo(String bkg_no, String usr_id) throws DAOException {
		DBRowSet dbRowset = null;
		List<BlIssInfoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("bkg_no", bkg_no);
			param.put("usr_id", usr_id);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BLIssuanceDBDAOSearchBlIssInfoRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BlIssInfoVO.class);

		} catch (SQLException ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * B/L Issue  VALIDATION 체크 .<br>
	 * ESM_BKG-0079-9	연동 System	
	 * @author LEE JIN SEO
	 * @param String bkg_no
	 * @return String
	 * @exception DAOException
	 */
	public String searchBLNotReady(String bkg_no) throws DAOException {
		DBRowSet dbRowset = null;
		String strResult = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("bkg_no", bkg_no);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BLIssuanceDBDAOSearchBlIssInfo1RSQL(), param, velParam);
	    	if(dbRowset.next()) {
	    		strResult = dbRowset.getString("BL_NOT_READY");
	    	}
		} catch (SQLException ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return strResult;
	}
	/**
	 * Issue Type 관련 정보를 관리한다.<br>
	 * ESM_BKG-0079-9	연동 System	
	 * @author LEE JIN SEO
	 * @param BlIssInfoVO blIssInfoVO
	 * @exception DAOException
	 */
	public void manageBlIssueFlg(BlIssInfoVO blIssInfoVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {
			Map<String, String> mapVO = blIssInfoVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new BLIssuanceDBDAOmanageBlIssueFlgUSQL(), param, velParam);
			
			if (result == Statement.EXECUTE_FAILED)				throw new DAOException("Fail to insert SQL");
		} catch (SQLException ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	/**
	 * Issue Type 관련 정보를 관리한다.<br>
	 * ESM_BKG-0079-9	연동 System	
	 * @param BlIssInfoVO blIssInfoVO
	 * @exception DAOException
	 */
	public void manageBlIssueFlgHistory(BlIssInfoVO blIssInfoVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {
			Map<String, String> mapVO = blIssInfoVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new BLIssuanceDBDAOmanageBlIssueFlgHistoryUSQL(), param, velParam);
			
			if (result == Statement.EXECUTE_FAILED)				throw new DAOException("Fail to insert SQL");
		} catch (SQLException ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	/**
	 * manageIntAuth 관련 정보를 관리한다.<br>
	 * ESM_BKG-0079-9	연동 System	
	 * @author LEE JIN SEO
	 * @param BlIssInfoVO blIssInfoVO
	 * @exception DAOException
	 */
	public void manageIntAuth(BlIssInfoVO blIssInfoVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {
			Map<String, String> mapVO = blIssInfoVO.getColumnValues();

			param.putAll(mapVO);
			velParam.put("buttonType", blIssInfoVO.getButtontype());
			
			SQLExecuter sqlExe = new SQLExecuter("");
			
			result = sqlExe.executeUpdate((ISQLTemplate) new BLIssuanceDBDAOmanageIntAuthCSQL(), param, velParam);

			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	/**
	 * bl issue 관련 정보를 관리한다.<br>
	 * ESM_BKG-0079-9	연동 System	
	 * @author LEE JIN SEO
	 * @param BlIssInfoVO blIssInfoVO
	 * @exception DAOException
	 */
	public void manageBlIssInfo(BlIssInfoVO blIssInfoVO) throws DAOException, Exception {
		SQLExecuter sqlExe = new SQLExecuter("");
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		DBRowSet dbRowset = null;
		int insCnt = 0 ;
		int count = 0 ;
		
		try {
			Map<String, String> mapVO = blIssInfoVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			velParam.put("sql_type", "count");
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BLIssuanceDBDAOManageBlIssInfoUSQL(), param, velParam);
			if (dbRowset.next()) {
				 count = dbRowset.getInt(1);
			}
			if(count>0){
				velParam.put("sql_type", "update");
				insCnt = sqlExe.executeUpdate((ISQLTemplate) new BLIssuanceDBDAOManageBlIssInfoUSQL(), param, velParam);
			}else{
				velParam.put("sql_type", "insert");
				insCnt = sqlExe.executeUpdate((ISQLTemplate) new BLIssuanceDBDAOManageBlIssInfoUSQL(), param, velParam);
			}
			log.debug("* insert : " + insCnt);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	/**
	 * bl issue 관련 정보를 관리한다.<br>
	 * ESM_BKG-0079-9	연동 System	
	 * @param BlIssInfoVO blIssInfoVO
	 * @exception DAOException
	 */
	public void manageBlIssInfoHistory(BlIssInfoVO blIssInfoVO) throws DAOException, Exception {
		SQLExecuter sqlExe = new SQLExecuter("");
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		int insCnt = 0 ;
		
		try {
			Map<String, String> mapVO = blIssInfoVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			insCnt = sqlExe.executeUpdate((ISQLTemplate) new BLIssuanceDBDAOManageBlIssInfoHistoryUSQL(), param, velParam);
			log.debug("* insert : " + insCnt);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	
	/**
	 * B/L Issue 정보 조회 데이타 모델에 해당되는 값을 불러온다.<br>
	 * B/L Type, Freight 지불 여부 등의 B/L 발행 전 필요사항을 기입
	 * ESM_BKG-0079-9	연동 System	
	 * @author LEE JIN SEO
	 * @param String bkg_no
	 * @param String vsl_pre_pst_cd
	 * @return List<BkgComboVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgComboVO> searchComboVVDInfo(String bkg_no, String vsl_pre_pst_cd) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgComboVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("bkg_no", bkg_no);
			param.put("vsl_pre_pst_cd", vsl_pre_pst_cd);
			velParam.put("vsl_pre_pst_cd", vsl_pre_pst_cd);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BLIssuanceDBDAOSearchComboVVDInfoRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgComboVO.class);

		} catch (SQLException ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	/**
	 * B/L Issue 정보 조회 정보 조회<br>
	 * ESM_BKG-0649	연동 System	
	 * @author LEE JIN SEO
	 * @param String bkg_no
	 * @return List<ReIssueInfoVO>
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
    public List<ReIssueInfoVO> searchBlReIssueInfo(String bkg_no) throws DAOException {
		log.debug("============================>[[ BLIssuanceBCImpl  searchBlReIssueInfo START ]]<============================");
		DBRowSet dbRowset = null;
		List<ReIssueInfoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("bkg_no", bkg_no);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BLIssuanceDBDAOSearchBlReIssueInfoRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ReIssueInfoVO.class);

		} catch (SQLException ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		log.debug("============================>[[ BLIssuanceBCImpl  searchBlReIssueInfo END ]]<============================");
		return list;
	}
	/**
	 * B/L Issue History 정보 조회<br>
	 * ESM_BKG-0649	연동 System	
	 * @author LEE JIN SEO
	 * @param String bkg_no
	 * @return List<BkgDocIssHisVO>
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
    public List<BkgDocIssHisVO> searchBlReIssueHist(String bkg_no) throws DAOException {
		log.debug("============================>[[ BLIssuanceBCImpl  searchBlReIssueHist START ]]<============================");
		DBRowSet dbRowset = null;
		List<BkgDocIssHisVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("bkg_no", bkg_no);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BLIssuanceDBDAOSearchBlReIssueHistRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgDocIssHisVO.class);

		} catch (SQLException ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		log.debug("============================>[[ BLIssuanceBCImpl  searchBlReIssueHist END ]]<============================");
		return list;
	}
	/**
	 * B/L Issue Collect 정보 조회<br>
	 * ESM_BKG-0649	연동 System	
	 * @author LEE JIN SEO
	 * @param String bkg_no
	 * @return List<BkgDocIssRdemVO>
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
    public List<BkgDocIssRdemVO> searchBlReIssueCollect(String bkg_no) throws DAOException {
		log.debug("============================>[[ BLIssuanceBCImpl  searchBlReIssueCollect START ]]<============================");
		DBRowSet dbRowset = null;
		List<BkgDocIssRdemVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("bkg_no", bkg_no);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BLIssuanceDBDAOSearchBlReIssueCollectRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgDocIssRdemVO.class);

		} catch (SQLException ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		log.debug("============================>[[ BLIssuanceBCImpl  searchBlReIssueCollect END ]]<============================");
		return list;
	}
	/**
	 * 다건의 B/L Issue History 에 해당하는 정보를 저장한다.<br>
	 * ESM_BKG-0649	연동 System	
	 * @author LEE JIN SEO
	 * @param List<BkgDocIssHisVO> listVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
    public void manageBlReIssue(List<BkgDocIssHisVO> listVO) throws DAOException, Exception {
		
		SQLExecuter sqlExe = new SQLExecuter("");
		DBRowSet dbRowset = null;
		
		try {
			//int cnt[] = null;
			int size = listVO.size();
			if (size > 0) {
				// query parameter
				Map<String, Object> param = new HashMap<String, Object>();
				// velocity parameter
				Map<String, Object> velParam = new HashMap<String, Object>();
				Iterator list = listVO.iterator();
				while (list.hasNext()) {
					BkgDocIssHisVO bkgDocIssHisVO = (BkgDocIssHisVO) list.next();
					Map<String, String> mapVO = bkgDocIssHisVO.getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO);

					velParam.put("sql_type", "count");
					
					int insCnt = 0 ;
					int count = 0 ;
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BLIssuanceDBDAOManageBlReIssueUSQL(), param, velParam);
					
					if (dbRowset.next()) {
						 count = dbRowset.getInt(1);
					}
					
					if( count>0){
						// update
						velParam.put("sql_type", "update");
						insCnt = sqlExe.executeUpdate((ISQLTemplate) new BLIssuanceDBDAOManageBlReIssueUSQL(), param, velParam);
										
					}else{
						// insert
						param.put("bkg_evnt_knd_cd", "R");
						param.put("riss_flg", "Y");
						
						velParam.put("sql_type", "insert");
						insCnt = sqlExe.executeUpdate((ISQLTemplate) new BLIssuanceDBDAOManageBlReIssueUSQL(), param, velParam);
										
					}

					if (insCnt == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
				}
			}
		} catch (SQLException ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * 다건의 B/L Issue Collect에 해당하는 정보를 저장한다.<br>
	 * ESM_BKG-0649	연동 System	
	 * @author LEE JIN SEO
	 * @param List<BkgDocIssRdemVO> listVO
	 * @param String type
	 * 
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
    public void manageBlReIssueCollect(List<BkgDocIssRdemVO> listVO, String type) throws DAOException, Exception {
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			//int cnt[] = null;
			int size = listVO.size();
			if (size > 0) {
				log.debug("====>[[ BLIssuanceBCImpl  manageBlReIssueCollect START ]]<====="+size);
				// query parameter
				Map<String, Object> param = new HashMap<String, Object>();
				// velocity parameter
				Map<String, Object> velParam = new HashMap<String, Object>();
				Iterator list = listVO.iterator();
				
				if("C".equals(type)){
					while (list.hasNext()) {
						BkgDocIssRdemVO bkgDocIssRdemVO = (BkgDocIssRdemVO) list.next();
						Map<String, String> mapVO = bkgDocIssRdemVO.getColumnValues();
						param.putAll(mapVO);
						velParam.putAll(mapVO);
						int insCnt = sqlExe.executeUpdate((ISQLTemplate) new BLIssuanceDBDAOManageBlReIssueCollectCSQL(), param, velParam);
						if (insCnt == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert SQL");
					}
				}else if("D".equals(type)){
					while (list.hasNext()) {
						BkgDocIssRdemVO bkgDocIssRdemVO = (BkgDocIssRdemVO) list.next();
						Map<String, String> mapVO = bkgDocIssRdemVO.getColumnValues();
						param.putAll(mapVO);
						velParam.putAll(mapVO);
						int insCnt = sqlExe.executeUpdate((ISQLTemplate) new BLIssuanceDBDAOManageBlReIssueCollectDSQL(), param, velParam);
						if (insCnt == Statement.EXECUTE_FAILED) throw new DAOException("Fail to delete SQL");
					}
				}else{
					while (list.hasNext()) {
						BkgDocIssRdemVO bkgDocIssRdemVO = (BkgDocIssRdemVO) list.next();
						Map<String, String> mapVO = bkgDocIssRdemVO.getColumnValues();
						param.putAll(mapVO);
						velParam.putAll(mapVO);
						int insCnt = sqlExe.executeUpdate((ISQLTemplate) new BLIssuanceDBDAOManageBlReIssueCollectUSQL(), param, velParam);
						if (insCnt == Statement.EXECUTE_FAILED) throw new DAOException("Fail to update SQL");
					}
				}
				
			}
		} catch (SQLException ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	/**
	 * ESM_BKG-0649	연동 System	
	 * B/L Issue Collect에 해당하는 confirm 저장한다.<br>
	 * 
	 * @param String bkg_no
	 * @exception DAOException
	 */
	public void confirmBlReIssue(String bkg_no) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {
			
			param.put("bkg_no", bkg_no);		
			velParam.put("sql_type", "COMFIRM");
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new BLIssuanceDBDAOManageBlReIssueCollectUSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
		} catch (SQLException ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	/**
	 * ESM_BKG-0400	연동 System	
	 * O/BL Surrender 정보 조회<br>
	 * 
	 * @author LEE JIN SEO
	 * @param String bkg_no
	 * @param String bl_no
	 * @return List<SrndVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
    public List<SrndVO> searchSurrenderInfo(String bkg_no,String bl_no) throws DAOException {
		log.debug("============================>[[ BLIssuanceBCImpl  searchSurrenderInfo START ]]<============================");
		DBRowSet dbRowset = null;
		List<SrndVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("bkg_no", bkg_no);
			param.put("bl_no", bl_no);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BLIssuanceDBDAOSearchSurrenderInfoRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SrndVO.class);

		} catch (SQLException ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		log.debug("============================>[[ BLIssuanceBCImpl  searchSurrenderInfo END ]]<============================");
		return list;
	}
	/**
	 * ESM_BKG-0400	연동 System	
	 * D/O Status  정보 조회<br>
	 * 
	 * @author LEE JIN SEO
	 * @param String bkg_no
	 * @return String
	 * @exception EventException
	 */
	public String searchDoStatus(String bkg_no) throws DAOException {
		log.debug("============================>[[ BLIssuanceBCImpl  searchSurrenderInfo START ]]<============================");
		DBRowSet dbRowset = null;
		String result = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("bkg_no", bkg_no);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BLIssuanceDBDAOSearchDoStatusRSQL(), param, velParam);
            if (dbRowset.next()) {
        	   result = dbRowset.getString(1);
            }
		} catch (SQLException ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		log.debug("============================>[[ BLIssuanceBCImpl  searchSurrenderInfo END ]]<============================");
		return result;
	}
	/**
	 * ESM_BKG-0400	연동 System	
	 * B/L 정보에서 Surrender 관련사항을 업데이트.<br>
	 * 
	 * @param SrndVO srndVO
	 * @exception DAOException
	 */
	public void modifySurrenderInfo(SrndVO srndVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {
			Map<String, String> mapVO = srndVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new BLIssuanceDBDAOModifySurrenderInfoUSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
		} catch (SQLException ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	/**
	 * ESM_BKG-0400	연동 System	
	 * B/L 정보에서 Surrender 관련사항을 업데이트.<br>
	 * 
	 * @param SrndVO srndVO
	 * @exception DAOException
	 */
	public void modifySurrenderInfoHistory(SrndVO srndVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {
			Map<String, String> mapVO = srndVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new BLIssuanceDBDAOModifySurrenderInfoHistoryUSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
		} catch (SQLException ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	
	/**
	 * ESM_BKG-0400	연동 System	
	 * Surrender 정보를 초기화 한다.<br>
	 * 
	 * @param String bkg_no
	 * @exception DAOException
	 */
	public void removeSurrenderInfo(String bkg_no) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {
			param.put("bkg_no", bkg_no);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new BLIssuanceDBDAORemoveSurrenderInfoDSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to delete SQL");
		} catch (SQLException ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	/**
	 * ESM_BKG-0400	연동 System	
	 * Surrender 정보를 초기화 한다.<br>
	 * 
	 * @param String bkg_no
	 * @exception DAOException
	 */
	public void removeSurrenderInfoHistory(String bkg_no) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {
			param.put("bkg_no", bkg_no);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new BLIssuanceDBDAORemoveSurrenderInfoHistoryDSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to delete SQL");
		} catch (SQLException ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	
	/**
	 * ESM_BKG-0059	연동 System	
	 * Documentation Requirement 데이터를 조회<br>
	 * 
	 * @author LEE JIN SEO
	 * @param String bkg_no
	 * @param String ofc_cd
	 * @return List<DocRqstVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
    public List<DocRqstVO> searchDocRqst(String bkg_no ,String ofc_cd) throws DAOException {
		log.debug("============================>[[ BLIssuanceBCImpl  searchSurrenderInfo START ]]<============================");
		DBRowSet dbRowset = null;
		List<DocRqstVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("bkg_no", bkg_no);
			param.put("ofc_cd", ofc_cd);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BLIssuanceDBDAOSearchDocRqstRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, DocRqstVO.class);

		} catch (SQLException ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		log.debug("============================>[[ BLIssuanceBCImpl  searchSurrenderInfo END ]]<============================");
		return list;
	}
	/**
	 * ESM_BKG-0059	연동 System	
	 * Documentation Requirement 데이터를 수정<br>
	 * 
	 * @param DocRqstVO docRqstVO
	 * @return int
	 * @exception DAOException
	 */
	public int  modifyDocRqst(DocRqstVO docRqstVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {
			Map<String, String> mapVO = docRqstVO.getColumnValues();
 
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new BLIssuanceDBDAOModifyDocRqstUSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
		} catch (SQLException ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	/**
	 * ESM_BKG-0059	연동 System	
	 * Documentation Requirement 데이터를 추가<br>
	 * 
	 * @param DocRqstVO docRqstVO
	 * @return int
	 * @exception DAOException
	 */
	public int  addDocRqst(DocRqstVO docRqstVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {
			Map<String, String> mapVO = docRqstVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new BLIssuanceDBDAOAddDocRqstCSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
		} catch (SQLException ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * BLIssuanceDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param model
	 *            데이타 모델
	 * @return DBRowSet
	 * @exception DAOException
	 */

	/**
	 *  MultiCombo 조회 이벤트 처리 ESM_BKG_0278
	 *
	 * @param bkgComboVO
	 * @return List<BkgComboVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgComboVO> searchSRouteFromList(BkgComboVO bkgComboVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgComboVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (bkgComboVO != null) {
				Map<String, String> mapVO = bkgComboVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BLIssuanceDBDAOsearchSRouteFromListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgComboVO.class);
		} catch (SQLException ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 *  ESM_BKG_0280화면에 대한 조회 이벤트 처리
	 *
	 * @param grpBlPrtInVO
	 * @return GrpBlPrtOutVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<GrpBlPrtVO> searchBkgListForGrpBlPr(GrpBlPrtInVO grpBlPrtInVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<GrpBlPrtVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (grpBlPrtInVO != null) {
				// 기존에 작성한 쿼리문 ${조회조건변수명} / @[조회조건변수명] 값에 설정
				Map<String, String> mapVO = grpBlPrtInVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				// master_bl_no
				if (!grpBlPrtInVO.getMasterBlNo().equals("")) {
					velParam.put("masterBlnos", setparam_In(grpBlPrtInVO.getMasterBlNo(), "|"));
				}

				// Customer Type - cust_tp_cd
				if (!grpBlPrtInVO.getCustTpCd().equals("")) {
					velParam.put("custTpCds", setparam_In(grpBlPrtInVO.getCustTpCd(), "|"));
				}

				// R/D Term - booking_rcv_term_cd
				if (!grpBlPrtInVO.getBookingRcvTermCd().equals("")) {
					velParam.put("bkgRcvTermCds", setparam_In(grpBlPrtInVO.getBookingRcvTermCd(), "|"));
				}

				// R/D Term - booking_de_term_cd
				if (!grpBlPrtInVO.getBookingDeTermCd().equals("")) {
					velParam.put("bkgDeTermCds", setparam_In(grpBlPrtInVO.getBookingDeTermCd(), "|"));
				}

				// S.Route - org_sconti_cd
				if (!grpBlPrtInVO.getOrgScontiCd().equals("")) {
					velParam.put("orgScontiCds", setparam_In(grpBlPrtInVO.getOrgScontiCd(), "|"));
				}

				// S.Route - desc_sconti_cd
				if (!grpBlPrtInVO.getDescScontiCd().equals("")) {
					velParam.put("descScontiCds", setparam_In(grpBlPrtInVO.getDescScontiCd(), "|"));
				}

				// S.Mode - org_svc_mod_cd
				if (!grpBlPrtInVO.getOrgSvcModCd().equals("")) {
					velParam.put("orgSvcModCds", setparam_In(grpBlPrtInVO.getOrgSvcModCd(), "|"));
				}

				// S.Mode - desc_inlnd_svc_mod_cd
				if (!grpBlPrtInVO.getDescInlndSvcModCd().equals("")) {
					velParam.put("descInlndSvcModCds", setparam_In(grpBlPrtInVO.getDescInlndSvcModCd(), "|"));
				}

				// Cargo Type - bkg_cgo_tp_cd
				if (!grpBlPrtInVO.getBkgCgoTpCd().equals("")) {
					velParam.put("bkgCgoTpCds", setparam_In(grpBlPrtInVO.getBkgCgoTpCd(), "|"));
				}

				// Booking Status - bkg_sts_cd
				if (!grpBlPrtInVO.getBkgStsCd().equals("")) {
					velParam.put("bkgStsCds", setparam_In(grpBlPrtInVO.getBkgStsCd(), "|"));
				}

				// Memo B/L Type - adv_shtg_cd
				if (!grpBlPrtInVO.getAdvShtgCd().equals("")) {
					velParam.put("advShtgCds", setparam_In(grpBlPrtInVO.getAdvShtgCd(), "|"));
				}

				// Revenue - revenue
				if (!grpBlPrtInVO.getRevenue().equals("")) {
					velParam.put("revenueCds", setparam_In(grpBlPrtInVO.getRevenue(), "|"));
				}
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BLIssuanceDBDAOsearchBkgListForGrpBlPrRSQL(), param, velParam, true);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, GrpBlPrtVO.class);
		} catch (SQLException ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * IN Query 사용시 조합<br>
	 * 
	 * @param String
	 *            strParam
	 * @param String
	 *            strIterator
	 * @return List<ArrayList>
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<String> setparam_In(String strParam, String strIterator) throws EventException {
		try {
			ArrayList<String> arrString = new ArrayList();
			StringTokenizer st = new StringTokenizer(strParam, strIterator);

			while (st.hasMoreTokens()) {
				arrString.add(st.nextToken());
			}

			return arrString;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Original B/L 회수 여부와 상세 정보를 수정한다.<br>
	 * 
	 * @param BlIssVO blIss
	 * @return int
	 * @exception DAOException
	 */
	public int modifyOblRcvByIbd(BlIssVO blIss) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {
			Map<String, String> mapVO = blIss.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new BLIssuanceDBDAOModifyOblRcvByIbdUSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}

	/**
     * Original B/L 회수 여부와 상세 정보를 입력한다.<br>
     *
     * @param BlIssVO blIss
     * @exception DAOException
     */
    public void addOblRcvByIbd(BlIssVO blIss) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        int result =0;
        try {
            Map<String, String> mapVO = blIss.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            result = sqlExe.executeUpdate((ISQLTemplate)new BLIssuanceDBDAOAddOblRcvByIbdCSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to insert SQL");
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }
    
    /**
     * Original Bill of Lading Status 수정
     * @param BkgBlIssVO blStatusVO
     * @param SignOnUserAccount account
     * @return int
     * @exception DAOException
     */
    public int modifyOblRcvByUsCgo(BkgBlIssVO blStatusVO,SignOnUserAccount account) throws DAOException{

        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        int result = 0;

        try{
            Map<String, String> mapVO = blStatusVO.getColumnValues();
            mapVO.put("usr_id", account.getUsr_id());
            mapVO.put("ofc_cd", account.getOfc_cd());
            param.putAll(mapVO);
            velParam.putAll(mapVO);

            result = new SQLExecuter("").executeUpdate((ISQLTemplate)new BLIssuanceDBDAOModifyOblRcvByUsCgoUSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to insert SQL");

        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;

    }

    /**
     * Original Bill of Lading Status 추가
     * @param BkgBlIssVO blStatusVO
     * @param SignOnUserAccount account
     * @return int
     * @exception DAOException
     */
    public int addOblRcvByUsCgo(BkgBlIssVO blStatusVO,SignOnUserAccount account) throws DAOException{

        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        int result = 0;

        try{
            Map<String, String> mapVO = blStatusVO.getColumnValues();
            mapVO.put("usr_id", account.getUsr_id());
            mapVO.put("ofc_cd", account.getOfc_cd());
            param.putAll(mapVO);
            velParam.putAll(mapVO);

            result = new SQLExecuter("").executeUpdate((ISQLTemplate)new BLIssuanceDBDAOaddOblRcvByUsCgoCSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to insert SQL");

        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;

    }
    
	/**
	 * search B/L List For Group Update
	 * 
	 * @param GrpBlDtInVO grpBlDtInVO
	 * @return List<GrpBlDtListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<GrpBlDtListVO> searchBlListForGroupUpdate(GrpBlDtInVO grpBlDtInVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<GrpBlDtListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (grpBlDtInVO != null) {
				Map<String, String> mapVO = grpBlDtInVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

				String vvd = grpBlDtInVO.getVvd();
				param.put("vsl_cd", vvd.substring(0, 4));
				param.put("voy_no", vvd.substring(4, 8));
				param.put("dir_cd", vvd.substring(8, 9));
				String shpr_cd = grpBlDtInVO.getShipperCd();
				if(shpr_cd != null && shpr_cd.length()>=2){
	                param.put("cust_cnt_cd", shpr_cd.substring(0, 2));
	                int r = 0;
	                r = Integer.parseInt(shpr_cd.substring(2));
	                param.put("cust_seq", ""+r);
				}else{
				    velParam.put("shipper_cd", "");
				}
			}
			SQLExecuter sqlExec = new SQLExecuter("DEFAULT");
			BLIssuanceDBDAOGrpBlDtListRSQL template = new BLIssuanceDBDAOGrpBlDtListRSQL();
			dbRowset = sqlExec.executeQuery(template, param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, GrpBlDtListVO.class);
		} catch (SQLException ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * modifyBlIssueDt
	 * 
	 * @param GrpBlDtListVO grpBlDtListVO
	 * @exception DAOException
	 */
	public void modifyBlIssueDt(GrpBlDtListVO grpBlDtListVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {
			if (grpBlDtListVO != null) {
				Map<String, String> mapVO = grpBlDtListVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			BLIssuanceDBDAOBlIssueDtUSQL template = new BLIssuanceDBDAOBlIssueDtUSQL();
			result = sqlExe.executeUpdate(template, param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * modifyBlIssueDtHistory
	 * 
	 * @param GrpBlDtListVO grpBlDtListVO
	 * @exception DAOException
	 */
	public void modifyBlIssueDtHistory(GrpBlDtListVO grpBlDtListVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {
			if (grpBlDtListVO != null) {
				Map<String, String> mapVO = grpBlDtListVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			BLIssuanceDBDAOBlIssueDtHistoryUSQL template = new BLIssuanceDBDAOBlIssueDtHistoryUSQL();
			result = sqlExe.executeUpdate(template, param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	/**
	 *  Rider 여부판단 ESM_BKG_0927
	 *
	 * @param String bkg_no
	 * @param String hiddenData
	 * @param String rate
	 * @param String cntr
	 * @param String corr_no
	 * @return String
	 * @exception DAOException
	 */
	public String searchRiderYn(String bkg_no, String hiddenData, String rate, String cntr, String corr_no) throws DAOException {
		DBRowSet dbRowset = null;
		String strResult = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (bkg_no != null) {
				/*
				log.debug("####################################################");
				log.debug("");
				log.debug("bkg_no : [" + bkg_no + "]");
				log.debug("hiddenData : [" + hiddenData + "]");
				log.debug("rate : [" + rate + "]");
				log.debug("cntr : [" + cntr + "]");
				log.debug("corr_no : [" + corr_no + "]");
				log.debug("");
				log.debug("####################################################");
				*/
				param.put("bkg_no", bkg_no);
				param.put("hiddenData", hiddenData);
				param.put("rate", rate);
				param.put("cntr", cntr);
				param.put("corr_no", corr_no);
				
				velParam.put("bkg_no", bkg_no);
				velParam.put("hiddenData", hiddenData);
				velParam.put("rate", rate);
				velParam.put("cntr", cntr);
				velParam.put("corr_no", corr_no);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BLIssuanceDBDAOSearchRiderYnRSQL(), param, velParam);
	    	if(dbRowset.next()) {
	    		strResult = dbRowset.getString("RIDER_YN");
	    	}
		} catch (SQLException ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return strResult;
	}
	
	/**
	 *  HouseB/L 여부판단 ESM_BKG_0927
	 *
	 * @param String bkg_no
	 * @return String
	 * @exception DAOException
	 */
	public String searchHouseBlYn(String bkg_no) throws DAOException {
		DBRowSet dbRowset = null;
		String strResult = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (bkg_no != null) {

				param.put("bkg_no", bkg_no);
				velParam.put("bkg_no", bkg_no);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BLIssuanceDBDAOSearchHouseBlYnRSQL(), param, velParam);
	    	if(dbRowset.next()) {
	    		strResult = dbRowset.getString("NVO_HBS_YN");
	    	}
		} catch (SQLException ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return strResult;
	}
	
	/**
	 * HouseB/L 여부판단 ESM_BKG_0927
	 * 
	 * @param String bkg_no
	 * @param String corr_no
	 * @return String
	 * @exception DAOException
	 */
	public String searchOblRlseFlg(String bkg_no, String corr_no) throws DAOException {
		DBRowSet dbRowset = null;
		String strResult = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (bkg_no != null) {

				param.put("bkg_no", bkg_no);
				param.put("corr_no", corr_no);
				velParam.put("bkg_no", bkg_no);
				velParam.put("corr_no", corr_no);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BLIssuanceDBDAOSearchOblRlseFlgRSQL(), param, velParam);
	    	if(dbRowset.next()) {
	    		strResult = dbRowset.getString("obl_rlse_flg");
	    	}
		} catch (SQLException ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return strResult;
	}

	/**
	 * OBL_ISS_FLG ESM_BKG_0927
	 * 
	 * @param String bkg_no
	 * @return String
	 * @exception DAOException
	 */
	public String searchOblIssFlg(String bkg_no) throws DAOException {
		DBRowSet dbRowset = null;
		String strResult = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (bkg_no != null) {

				param.put("bkg_no", bkg_no);
				velParam.put("bkg_no", bkg_no);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BLIssuanceDBDAOSearchOblIssFlgRSQL(), param, velParam);
	    	if(dbRowset.next()) {
	    		strResult = dbRowset.getString("obl_iss_flg");
	    	}
		} catch (SQLException ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return strResult;
	}

	/**
	 * Draft BL 및 Waybill 전송을 위한 Outbound booking list를 조회한다.
	 * 
	 * @param ObDblWblInVO obDblWblInVO
	 * @return List<DblWblVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<DblWblVO> searchBkgListForObDrblWbl(ObDblWblInVO obDblWblInVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<DblWblVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (null!=obDblWblInVO) {
				Map<String, String> mapVO = obDblWblInVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				SQLExecuter sqlExec = new SQLExecuter("DEFAULT");
				BLIssuanceDBDAOSearchBkgListForObDrblWblRSQL template = new BLIssuanceDBDAOSearchBkgListForObDrblWblRSQL();
				dbRowset = sqlExec.executeQuery(template, param, velParam, true);
				list = (List) RowSetUtil.rowSetToVOs(dbRowset, DblWblVO.class);
			}
		} catch (SQLException ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * Draft BL 및 Waybill 전송을 위한 Outbound booking count를 조회한다.
	 * 
	 * @param ObDblWblInVO obDblWblInVO
	 * @return List<DblWblCntVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<DblWblCntVO> searchBkgListForObDrblWblCnt(ObDblWblInVO obDblWblInVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<DblWblCntVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (null!=obDblWblInVO) {
				Map<String, String> mapVO = obDblWblInVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				SQLExecuter sqlExec = new SQLExecuter("DEFAULT");
				BLIssuanceDBDAOSearchBkgListForObDrblWblCntRSQL template = new BLIssuanceDBDAOSearchBkgListForObDrblWblCntRSQL();
				dbRowset = sqlExec.executeQuery(template, param, velParam);
				list = (List) RowSetUtil.rowSetToVOs(dbRowset, DblWblCntVO.class);
			}
		} catch (SQLException ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * Draft BL 및 Waybill 전송을 위한 Inbound booking list를 조회한다.
	 * 
	 * @param InDblWblInVO inDblWblInVO
	 * @return List<DblWblVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<DblWblVO> searchBkgListForIbDrblWbl(InDblWblInVO inDblWblInVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<DblWblVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (null!=inDblWblInVO) {
				Map<String, String> mapVO = inDblWblInVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				SQLExecuter sqlExec = new SQLExecuter("DEFAULT");
				BLIssuanceDBDAOSearchBkgListForIbDrblWblRSQL template = new BLIssuanceDBDAOSearchBkgListForIbDrblWblRSQL();
				dbRowset = sqlExec.executeQuery(template, param, velParam);
				list = (List) RowSetUtil.rowSetToVOs(dbRowset, DblWblVO.class);
			}
		} catch (SQLException ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * Draft BL 및 Waybill 전송을 위한 Inbound booking count를 조회한다.
	 * 
	 * @param InDblWblInVO inDblWblInVO
	 * @return List<DblWblCntVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<DblWblCntVO> searchBkgListForIbDrblWblCnt(InDblWblInVO inDblWblInVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<DblWblCntVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (null!=inDblWblInVO) {
				Map<String, String> mapVO = inDblWblInVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				SQLExecuter sqlExec = new SQLExecuter("DEFAULT");
				BLIssuanceDBDAOSearchBkgListForIbDrblWblCntRSQL template = new BLIssuanceDBDAOSearchBkgListForIbDrblWblCntRSQL();
				dbRowset = sqlExec.executeQuery(template, param, velParam);
				list = (List) RowSetUtil.rowSetToVOs(dbRowset, DblWblCntVO.class);
			}
		} catch (SQLException ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * BKG에 해당하는 Draft B/L 전송시 Chinese Booking Agent Code에 있는 Email 주소 조회한다.<br>
	 * 
	 * @param List<String> bkgNos
	 * @return List<AgentEmlVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<AgentEmlVO> searchBkgAgentEml(List<String> bkgNos) throws DAOException {
		DBRowSet dbRowset = null;
		List<AgentEmlVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (null!=bkgNos && 0<bkgNos.size()) {
				Map<String,List<String>> mapVO = new HashMap<String,List<String>>(bkgNos.size());
				mapVO.put("bkg_nos", bkgNos);
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				SQLExecuter sqlExec = new SQLExecuter("DEFAULT");
				BLIssuanceDBDAOsearchBkgAgentEmlRSQL template = new BLIssuanceDBDAOsearchBkgAgentEmlRSQL();
				dbRowset = sqlExec.executeQuery(template, param, velParam);
				list = (List) RowSetUtil.rowSetToVOs(dbRowset, AgentEmlVO.class);
			}
		} catch (SQLException ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * Booking 별 Fax, Mail의 전송결과를 조회한다.
	 * 
	 * @param MultiNtcHisVO multiNtcHisVO
	 * @return List<MultiNtcHisVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<MultiNtcHisVO> searchMultiNtcHis(MultiNtcHisVO multiNtcHisVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MultiNtcHisVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (null!=multiNtcHisVO) {
				Map<String, String> mapVO = multiNtcHisVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				SQLExecuter sqlExec = new SQLExecuter("DEFAULT");
				BLIssuanceDBDAOsearchMultiNtcHisRSQL template = new BLIssuanceDBDAOsearchMultiNtcHisRSQL();
				dbRowset = sqlExec.executeQuery(template, param, velParam);
				list = (List) RowSetUtil.rowSetToVOs(dbRowset, MultiNtcHisVO.class);
			}
		} catch (SQLException ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

    /**
     * @param CanonEmlVO canonEml
     * @return List<BkgAutoEmlVO>
     * @exception DAOException 
     */
    @SuppressWarnings("unchecked")
    public List<CanonEmlBkgVO> searchCanonEmlBkg(CanonEmlVO canonEml) throws DAOException {
        DBRowSet dbRowset = null;
        List<CanonEmlBkgVO> list = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = canonEml.getColumnValues();
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExec = new SQLExecuter("DEFAULT");
            BLIssuanceDBDAOCanonEmlBkgRSQL template = new BLIssuanceDBDAOCanonEmlBkgRSQL();
            dbRowset = sqlExec.executeQuery(template, param, velParam);
            
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, CanonEmlBkgVO.class);
            
        } catch (SQLException ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch (Exception ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
    }

    /**
     * searchCanonEmlRmkXchRt
     * 
     * @param BkgAutoEmlVO autoEmlVO
     * @return String
     * @exception DAOException 
     */
    public String searchCanonEmlRmkXchRt(BkgAutoEmlVO autoEmlVO) throws DAOException {
        DBRowSet dbRowset = null;
        String result = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = autoEmlVO.getColumnValues();
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExec = new SQLExecuter("DEFAULT");
            BLIssuanceDBDAOCanonEmlRmkXchRtRSQL template = new BLIssuanceDBDAOCanonEmlRmkXchRtRSQL();
            dbRowset = sqlExec.executeQuery(template, param, velParam);
            if(dbRowset.next()){
                result = dbRowset.getString(1);
            }else{
                result = "";
            }
        } catch (SQLException ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch (Exception ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;
    }

    /**
     * searchCanonEmlRmkMrn
     * 
     * @param BkgAutoEmlVO autoEmlVO
     * @return String
     * @exception DAOException
     */
    public String searchCanonEmlRmkMrn(BkgAutoEmlVO autoEmlVO) throws DAOException {
        DBRowSet dbRowset = null;
        String result = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = autoEmlVO.getColumnValues();
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExec = new SQLExecuter("DEFAULT");
            BLIssuanceDBDAOCanonEmlRmkMrnRSQL template = new BLIssuanceDBDAOCanonEmlRmkMrnRSQL();
            dbRowset = sqlExec.executeQuery(template, param, velParam);
            if(dbRowset.next()){
                result = dbRowset.getString(1);
            }else{
                result = "";
            }
        } catch (SQLException ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch (Exception ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;
    }

    /**
     * searchCanonEmlRmkVslCallSign
     * 
     * @param BkgAutoEmlVO autoEmlVO
     * @return String
     * @exception DAOException
     */
    public String searchCanonEmlRmkVslCallSign(BkgAutoEmlVO autoEmlVO) throws DAOException {
        DBRowSet dbRowset = null;
        String result = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = autoEmlVO.getColumnValues();
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExec = new SQLExecuter("DEFAULT");
            BLIssuanceDBDAOCanonEmlRmkVslCallSignRSQL template = new BLIssuanceDBDAOCanonEmlRmkVslCallSignRSQL();
            dbRowset = sqlExec.executeQuery(template, param, velParam);
            if(dbRowset.next()){
                result = dbRowset.getString(1);
            }else{
                result = "";
            }
        } catch (SQLException ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch (Exception ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;
    }

    /**
     * searchCanonEmlRmkCcn
     * 
     * @param BkgAutoEmlVO autoEmlVO
     * @return String
     * @exception DAOException
     */
    public String searchCanonEmlRmkCcn(BkgAutoEmlVO autoEmlVO) throws DAOException {
        DBRowSet dbRowset = null;
        String result = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = autoEmlVO.getColumnValues();
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExec = new SQLExecuter("DEFAULT");
            BLIssuanceDBDAOCanonEmlRmkCcnRSQL template = new BLIssuanceDBDAOCanonEmlRmkCcnRSQL();
            dbRowset = sqlExec.executeQuery(template, param, velParam);
            if(dbRowset.next()){
                result = dbRowset.getString(1);
            }else{
                result = "";
            }
        } catch (SQLException ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch (Exception ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;
    }

    /**
     * searchCanonEmlRmUsrDflt
     * 
     * @param BkgAutoEmlVO autoEmlVO
     * @return String
     * @exception DAOException
     */
    public String searchCanonEmlRmUsrDflt(BkgAutoEmlVO autoEmlVO) throws DAOException {
        DBRowSet dbRowset = null;
        String result = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = autoEmlVO.getColumnValues();
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExec = new SQLExecuter("DEFAULT");
            BLIssuanceDBDAOCanonEmlRmUsrDfltRSQL template = new BLIssuanceDBDAOCanonEmlRmUsrDfltRSQL();
            dbRowset = sqlExec.executeQuery(template, param, velParam);
            if(dbRowset.next()){
                result = dbRowset.getString(1);
            }else{
                result = "";
            }
        } catch (SQLException ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch (Exception ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;
    }

    /**
     * searchCanonEmlUsrEmlAddr
     * 
     * @param BkgAutoEmlVO autoEmlVO
     * @return String
     * @exception DAOException
     */
    public String searchCanonEmlUsrEmlAddr(BkgAutoEmlVO autoEmlVO) throws DAOException {
        DBRowSet dbRowset = null;
        String result = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = autoEmlVO.getColumnValues();
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExec = new SQLExecuter("DEFAULT");
            BLIssuanceDBDAOCanonEmlUsrEmlAddrRSQL template = new BLIssuanceDBDAOCanonEmlUsrEmlAddrRSQL();
            dbRowset = sqlExec.executeQuery(template, param, velParam);
            if(dbRowset.next()){
                String tmp = dbRowset.getString(1);
                result = (tmp==null) ? "nobody@cyberlogitec.com" : tmp.substring(0, tmp.length()-1);
            }
        } catch (SQLException ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch (Exception ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;
    }

    /**
     * searchCanonEmlSubject
     * 
     * @param BkgAutoEmlVO autoEmlVO
     * @return String
     * @exception DAOException
     */
    public String searchCanonEmlSubject(BkgAutoEmlVO autoEmlVO) throws DAOException {
        DBRowSet dbRowset = null;
        String result = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = autoEmlVO.getColumnValues();
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExec = new SQLExecuter("DEFAULT");
            BLIssuanceDBDAOCanonEmlSubjectRSQL template = new BLIssuanceDBDAOCanonEmlSubjectRSQL();
            dbRowset = sqlExec.executeQuery(template, param, velParam);
            if(dbRowset.next()){
                result = dbRowset.getString(1);
            }
        } catch (SQLException ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch (Exception ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;
    }

    /**
     * createAutoEml
     * 
     * @param BkgAutoEmlVO autoEmlVO
     * @exception DAOException 
     */
    public void createAutoEml(BkgAutoEmlVO autoEmlVO) throws DAOException {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        try {
            Map<String, String> mapVO = autoEmlVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            BLIssuanceDBDAOAutoEmlCSQL template = new BLIssuanceDBDAOAutoEmlCSQL();
            int result = sqlExe.executeUpdate(template, param, velParam);
            if (result == Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to update SQL");
        } catch (SQLException ex) {
            //log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch (Exception ex) {
            //log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }
    
	/**
	 * B/L 발행 송부 - Draft B/L 발송 - Consignee의 Name 누락여부
	 * 
	 * @param DblEdiInVO dblEdiInVO
	 * @return String
	 * @exception DAOException
	 */
    public String searchDblEdiCneeNm(DblEdiInVO dblEdiInVO) throws DAOException {
        DBRowSet dbRowset = null;
        String result = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = dblEdiInVO.getColumnValues();
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExec = new SQLExecuter("DEFAULT");
            BLIssuanceDBDAOsearchDblEdiCneeNmRSQL template = new BLIssuanceDBDAOsearchDblEdiCneeNmRSQL();
            dbRowset = sqlExec.executeQuery(template, param, velParam);
            if(dbRowset.next()){
                result = dbRowset.getString(1);
            }
        } catch (SQLException ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch (Exception ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;
    }
    
	/**
	 * B/L 발행 송부 - Draft B/L 발송 - TTL Package and Description 누락여부
	 * 
	 * @param DblEdiInVO dblEdiInVO
	 * @return String
	 * @exception DAOException
	 */
    public String searchDblEdiTtlPkgDesc(DblEdiInVO dblEdiInVO) throws DAOException {
        DBRowSet dbRowset = null;
        String result = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = dblEdiInVO.getColumnValues();
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExec = new SQLExecuter("DEFAULT");
            BLIssuanceDBDAOsearchDblEdiTtlPkgDescRSQL template = new BLIssuanceDBDAOsearchDblEdiTtlPkgDescRSQL();
            dbRowset = sqlExec.executeQuery(template, param, velParam);
            if(dbRowset.next()){
                result = dbRowset.getString(1);
            }
        } catch (SQLException ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch (Exception ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;
    }
    
	/**
	 * B/L 발행 송부 - Draft B/L 발송 - CNTR No 존재 여부
	 * 
	 * @param DblEdiInVO dblEdiInVO
	 * @return String
	 * @exception DAOException
	 */
    public String searchDblEdiCntrNo(DblEdiInVO dblEdiInVO) throws DAOException {
        DBRowSet dbRowset = null;
        String result = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = dblEdiInVO.getColumnValues();
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExec = new SQLExecuter("DEFAULT");
            BLIssuanceDBDAOsearchDblEdiCntrNoRSQL template = new BLIssuanceDBDAOsearchDblEdiCntrNoRSQL();
            dbRowset = sqlExec.executeQuery(template, param, velParam);
            if(dbRowset.next()){
                result = dbRowset.getString(1);
            }
        } catch (SQLException ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch (Exception ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;
    }
    
	/**
	 * B/L 발행 송부 - BKG_MISC Table에 booking info가 없다면 B/L Issue가 필요
	 * 
	 * @param DblEdiInVO dblEdiInVO
	 * @return DblEdiInVO
	 * @exception DAOException
	 */
    public String searchDblEdiIssCnt(DblEdiInVO dblEdiInVO) throws DAOException {
        DBRowSet dbRowset = null;
        String result = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = dblEdiInVO.getColumnValues();
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExec = new SQLExecuter("DEFAULT");
            BLIssuanceDBDAOsearchDblEdiIssCntRSQL template = new BLIssuanceDBDAOsearchDblEdiIssCntRSQL();
            dbRowset = sqlExec.executeQuery(template, param, velParam);
            if(dbRowset.next()){
            	result = dbRowset.getString(1);
            }
        } catch (SQLException ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch (Exception ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;
    }
    
	/**
	 * B/L 발행 송부 - BL Type Check - W : Waybill, Null : B/L
	 * 
	 * @param DblEdiInVO dblEdiInVO
	 * @return String
	 * @exception DAOException
	 */
    public String searchDblEdiBlTp(DblEdiInVO dblEdiInVO) throws DAOException {
        DBRowSet dbRowset = null;
        String result = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = dblEdiInVO.getColumnValues();
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExec = new SQLExecuter("DEFAULT");
            BLIssuanceDBDAOsearchDblEdiBlTpRSQL template = new BLIssuanceDBDAOsearchDblEdiBlTpRSQL();
            dbRowset = sqlExec.executeQuery(template, param, velParam);
            if(dbRowset.next()){
                result = dbRowset.getString(1);
            }
        } catch (SQLException ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch (Exception ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;
    }
    
	/**
	 * B/L 발행 송부 - TotalNumberOfContainersOrPackages 체크
	 * 
	 * @param DblEdiInVO dblEdiInVO
	 * @return String
	 * @exception DAOException
	 */
    public String searchDblEdiPkgWord(DblEdiInVO dblEdiInVO) throws DAOException {
        DBRowSet dbRowset = null;
        String result = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = dblEdiInVO.getColumnValues();
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExec = new SQLExecuter("DEFAULT");
            BLIssuanceDBDAOsearchDblEdiPkgWordRSQL template = new BLIssuanceDBDAOsearchDblEdiPkgWordRSQL();
            dbRowset = sqlExec.executeQuery(template, param, velParam);
            if(dbRowset.next()){
                result = dbRowset.getString(1);
            }
        } catch (SQLException ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch (Exception ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;
    }
    
	/**
	 * B/L 발행 송부 - LG(LGELA010), 범한(PKEXM010)의 경우, bkg_ref_no  Check : SI_REF_NO 없으면  -> 전송 불가
	 * 
	 * @param DblEdiInVO dblEdiInVO
	 * @return String
	 * @exception DAOException
	 */
    public String searchDblEdiRefNo(DblEdiInVO dblEdiInVO) throws DAOException {
        DBRowSet dbRowset = null;
        String result = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = dblEdiInVO.getColumnValues();
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExec = new SQLExecuter("DEFAULT");
            BLIssuanceDBDAOsearchDblEdiRefNoRSQL template = new BLIssuanceDBDAOsearchDblEdiRefNoRSQL();
            dbRowset = sqlExec.executeQuery(template, param, velParam);
            if(dbRowset.next()){
                result = dbRowset.getString(1);
            }
        } catch (SQLException ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch (Exception ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;
    }

    /**
     * DblEdiSamf 조회 메소드 
     * 
     * @author KimYoungchul
     * @param dblEdiInVO
     * @return String
     * @exception DAOException 
     */
    public String searchDblEdiSamf(DblEdiInVO dblEdiInVO) throws DAOException {
        DBRowSet dbRowset = null;
        String result = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = dblEdiInVO.getColumnValues();
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExec = new SQLExecuter("DEFAULT");
            BLIssuanceDBDAOsearchDblEdiSamfRSQL template = new BLIssuanceDBDAOsearchDblEdiSamfRSQL();
            dbRowset = sqlExec.executeQuery(template, param, velParam);
            if(dbRowset.next()){
                result = dbRowset.getString(1);
            }
        } catch (SQLException ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch (Exception ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;
    }
    
    /**
    * search Edi Rcv Id By Klnet
    * 
    * @author KimYoungchul
    * @param dblEdiInVO
    * @return String
    * @exception DAOException 
    */
   public String[] searchEdiRcvIdByKlnet(DblEdiInVO dblEdiInVO) throws DAOException {
       DBRowSet dbRowset = null;
       String[] result = null;
       // query parameter
       Map<String, Object> param = new HashMap<String, Object>();
       // velocity parameter
       Map<String, Object> velParam = new HashMap<String, Object>();
       try {
           Map<String, String> mapVO = dblEdiInVO.getColumnValues();
           
           param.putAll(mapVO);
           velParam.putAll(mapVO);
           
           SQLExecuter sqlExec = new SQLExecuter("DEFAULT");
           BLIssuanceDBDAOsearchDblEdiRcvIdByKlnetRSQL template = new BLIssuanceDBDAOsearchDblEdiRcvIdByKlnetRSQL();
           dbRowset = sqlExec.executeQuery(template, param, velParam);
           
           result = new String[1];
           if(dbRowset.next()){
               result[0] = dblEdiInVO.getEdiReceiveId();
           }
       } catch (SQLException ex) {
           throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
       } catch (Exception ex) {
           throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
       }
       return result;
   }

   /**
    * search Edi Rcv Id By Lehxml
    * 
    * @author KimYoungchul
    * @param dblEdiInVO
    * @return String
    * @exception DAOException 
    */
   public String[] searchEdiRcvIdByLehxml(DblEdiInVO dblEdiInVO) throws DAOException {
       DBRowSet dbRowset = null;
       String[] result = null;
       // query parameter
       Map<String, Object> param = new HashMap<String, Object>();
       // velocity parameter
       Map<String, Object> velParam = new HashMap<String, Object>();
       try {
           Map<String, String> mapVO = dblEdiInVO.getColumnValues();
           
           param.putAll(mapVO);
           velParam.putAll(mapVO);
           
           SQLExecuter sqlExec = new SQLExecuter("DEFAULT");
           BLIssuanceDBDAOsearchDblEdiRcvIdByLehxmlRSQL template = new BLIssuanceDBDAOsearchDblEdiRcvIdByLehxmlRSQL();
           dbRowset = sqlExec.executeQuery(template, param, velParam);
           
           result = new String[dbRowset.getRowCount()];
           int idx = 0;
           while(dbRowset.next()){
               result[idx++] = dbRowset.getString(1);
           }
       } catch (SQLException ex) {
           throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
       } catch (Exception ex) {
           throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
       }
       return result;
   }

   /**
    * search Edi Rcv Id 
    * 
    * @author KimYoungchul
    * @param dblEdiInVO
    * @return String
    * @exception DAOException 
    */
   public String[] searchEdiRcvId(DblEdiInVO dblEdiInVO) throws DAOException {
       DBRowSet dbRowset = null;
       String[] result = null;
       // query parameter
       Map<String, Object> param = new HashMap<String, Object>();
       // velocity parameter
       Map<String, Object> velParam = new HashMap<String, Object>();
       try {
           Map<String, String> mapVO = dblEdiInVO.getColumnValues();
           
           param.putAll(mapVO);
           velParam.putAll(mapVO);
           
           SQLExecuter sqlExec = new SQLExecuter("DEFAULT");
           BLIssuanceDBDAOsearchDblEdiRcvIdRSQL template = new BLIssuanceDBDAOsearchDblEdiRcvIdRSQL();
           dbRowset = sqlExec.executeQuery(template, param, velParam);
           
           result = new String[dbRowset.getRowCount()];
           int idx = 0;
           while(dbRowset.next()){
               result[idx++] = dbRowset.getString(1);
           }
       } catch (SQLException ex) {
           throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
       } catch (Exception ex) {
           throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
       }
       return result;
   }

	/**
	 * copyTypeCd 에 따라, BKG_BL_ISS/BKG_BL_ISS_HIS 에 copy함
	 * 
     * @author Lee NamKyung
     * @param  BkgBlNoVO vo
     * @param  String copyTypeCd
     * @exception DAOException
     */
	public void createIssCA(BkgBlNoVO vo, String copyTypeCd) throws DAOException {
		Map<String, Object> param    = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				param.put   ("copy_type_cd", copyTypeCd);
				velParam.putAll(mapVO);
				velParam.put("copy_type_cd", copyTypeCd);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new BLIssuanceDBDAOCreateIssCACSQL(), param, velParam);
			if(updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");

		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
     * copyTypeCd에 따라, BKG_BL_ISS/BKG_BL_ISS_HIS 를 delete함
     * @author Lee NamKyung
	 * @param  BkgBlNoVO vo
	 * @param  String copyTypeCd
	 * @exception DAOException
	 */
	public void removeIssCA(BkgBlNoVO vo, String copyTypeCd) throws DAOException {
		Map<String, Object> param    = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {			
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				param.put   ("copy_type_cd", copyTypeCd);
				velParam.putAll(mapVO);
				velParam.put("copy_type_cd", copyTypeCd);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new BLIssuanceDBDAORemoveIssCADSQL(), param, velParam);
			if(updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to delete SQL");
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

    /**
     *
     * search Dbl Edi Fnc Code
     * 
     * @author KimYoungchul
     * @param dblEdiInVO
     * @return String
     * @exception DAOException 
     */
    public String searchDblEdiFncCode(DblEdiInVO dblEdiInVO) throws DAOException{
        DBRowSet dbRowset = null;
        String result = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = dblEdiInVO.getColumnValues();
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExec = new SQLExecuter("DEFAULT");
            BLIssuanceDBDAOsearchDblEdiFncCodeRSQL template = new BLIssuanceDBDAOsearchDblEdiFncCodeRSQL();
            dbRowset = sqlExec.executeQuery(template, param, velParam);
            if(dbRowset.next()){
                result = "5"; // Update
            }else{
                result = "9"; // 최초전송
            }        
        } catch (SQLException ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch (Exception ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;
    }

    /**
     * search Dbl Edi Grp Id 
     * 
     * @author KimYoungchul
     * @param dblEdiInVO
     * @return String[]
     * @exception DAOException 
     */
    public String[] searchDblEdiGrpId(DblEdiInVO dblEdiInVO) throws DAOException {
        DBRowSet dbRowset = null;
        String[] grp_code = new String[3];
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = dblEdiInVO.getColumnValues();
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExec = new SQLExecuter("DEFAULT");
            BLIssuanceDBDAOsearchDblEdiGrpIdRSQL template = new BLIssuanceDBDAOsearchDblEdiGrpIdRSQL();
            dbRowset = sqlExec.executeQuery(template, param, velParam);
            if(dbRowset.next()){
                grp_code[0] = dbRowset.getString(1);
                grp_code[1] = dbRowset.getString(2);
                grp_code[2] = dbRowset.getString(3);
            }
        } catch (SQLException ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch (Exception ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return grp_code;
    }

    /**
     * search Final Eta 11
     * 
     * @author KimYoungchul
     * @param dblEdiInVO
     * @return String
     * @exception DAOException 
     */
    public String searchFinalEta11(DblEdiInVO dblEdiInVO) throws DAOException {
        DBRowSet dbRowset = null;
        String result = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = dblEdiInVO.getColumnValues();
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExec = new SQLExecuter("DEFAULT");
            BLIssuanceDBDAOsearchDblEdiFnlEta11RSQL template = new BLIssuanceDBDAOsearchDblEdiFnlEta11RSQL();
            dbRowset = sqlExec.executeQuery(template, param, velParam);
            if(dbRowset.next()){
                result = dbRowset.getString(1);
            }
        } catch (SQLException ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch (Exception ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;
    }

    /**
     * search Final Eta 12
     * 
     * @author KimYoungchul
     * @param dblEdiInVO
     * @return String
     * @exception DAOException 
     */
    public String searchFinalEta12(DblEdiInVO dblEdiInVO) throws DAOException {
        DBRowSet dbRowset = null;
        String result = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = dblEdiInVO.getColumnValues();
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExec = new SQLExecuter("DEFAULT");
            BLIssuanceDBDAOsearchDblEdiFnlEta12RSQL template = new BLIssuanceDBDAOsearchDblEdiFnlEta12RSQL();
            dbRowset = sqlExec.executeQuery(template, param, velParam);
            if(dbRowset.next()){
                result = dbRowset.getString(1);
            }       
        } catch (SQLException ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch (Exception ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;
    }

    /**
     * search Final Eta 13
     * 
     * @author KimYoungchul
     * @param dblEdiInVO
     * @return String
     * @exception DAOException 
     */
    public String searchFinalEta13(DblEdiInVO dblEdiInVO) throws DAOException {
        DBRowSet dbRowset = null;
        String result = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = dblEdiInVO.getColumnValues();
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExec = new SQLExecuter("DEFAULT");
            BLIssuanceDBDAOsearchDblEdiFnlEta13RSQL template = new BLIssuanceDBDAOsearchDblEdiFnlEta13RSQL();
            dbRowset = sqlExec.executeQuery(template, param, velParam);
            if(dbRowset.next()){
                result = dbRowset.getString(1);
            }       
        } catch (SQLException ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch (Exception ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;
    }

    /**
     * search Final Eta 14
     * 
     * @author KimYoungchul
     * @param dblEdiInVO
     * @return String
     * @exception DAOException 
     */
    public String searchFinalEta14(DblEdiInVO dblEdiInVO) throws DAOException {
        DBRowSet dbRowset = null;
        String result = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = dblEdiInVO.getColumnValues();
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExec = new SQLExecuter("DEFAULT");
            BLIssuanceDBDAOsearchDblEdiFnlEta14RSQL template = new BLIssuanceDBDAOsearchDblEdiFnlEta14RSQL();
            dbRowset = sqlExec.executeQuery(template, param, velParam);
            if(dbRowset.next()){
                result = dbRowset.getString(1);
            }       
        } catch (SQLException ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch (Exception ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;
    }
    
    /**
     * search Final Eta 15
     * 
     * @author KimYoungchul
     * @param dblEdiInVO
     * @return String
     * @exception DAOException 
     */
    public String searchFinalAta15(DblEdiInVO dblEdiInVO) throws DAOException {
        DBRowSet dbRowset = null;
        String result = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = dblEdiInVO.getColumnValues();
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExec = new SQLExecuter("DEFAULT");
            BLIssuanceDBDAOsearchDblEdiFnlAta15RSQL template = new BLIssuanceDBDAOsearchDblEdiFnlAta15RSQL();
            dbRowset = sqlExec.executeQuery(template, param, velParam);
            if(dbRowset.next()){
                result = dbRowset.getString(1);
            }       
        } catch (SQLException ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch (Exception ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;
    }

    /**
     * search Final Eta 21
     * 
     * @author KimYoungchul
     * @param dblEdiInVO
     * @return String
     * @exception DAOException 
     */
    public String searchFinalEta21(DblEdiInVO dblEdiInVO) throws DAOException {
        DBRowSet dbRowset = null;
        String result = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = dblEdiInVO.getColumnValues();
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExec = new SQLExecuter("DEFAULT");
            BLIssuanceDBDAOsearchDblEdiFnlEta21RSQL template = new BLIssuanceDBDAOsearchDblEdiFnlEta21RSQL();
            dbRowset = sqlExec.executeQuery(template, param, velParam);
            if(dbRowset.next()){
                result = dbRowset.getString(1);
            }       
        } catch (SQLException ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch (Exception ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;
    }

    /**
     * search Final Eta 22
     * 
     * @author KimYoungchul
     * @param dblEdiInVO
     * @return String
     * @exception DAOException 
     */
    public String searchFinalEta22(DblEdiInVO dblEdiInVO) throws DAOException {
        DBRowSet dbRowset = null;
        String result = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = dblEdiInVO.getColumnValues();
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExec = new SQLExecuter("DEFAULT");
            BLIssuanceDBDAOsearchDblEdiFnlEta22RSQL template = new BLIssuanceDBDAOsearchDblEdiFnlEta22RSQL();
            dbRowset = sqlExec.executeQuery(template, param, velParam);
            if(dbRowset.next()){
                result = dbRowset.getString(1);
            }       
        } catch (SQLException ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch (Exception ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;
    }

    /**
     * search Final Eta 31
     * 
     * @author KimYoungchul
     * @param dblEdiInVO
     * @return String
     * @exception DAOException 
     */
    public String searchFinalEta31(DblEdiInVO dblEdiInVO) throws DAOException {
        DBRowSet dbRowset = null;
        String result = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = dblEdiInVO.getColumnValues();
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExec = new SQLExecuter("DEFAULT");
            BLIssuanceDBDAOsearchDblEdiFnlEta31RSQL template = new BLIssuanceDBDAOsearchDblEdiFnlEta31RSQL();
            dbRowset = sqlExec.executeQuery(template, param, velParam);
            if(dbRowset.next()){
                result = dbRowset.getString(1);
            }       
        } catch (SQLException ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch (Exception ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;
    }

    /**
     * search Edi Sndr By Klnettcs
     * 
     * @author KimYoungchul
     * @param dblEdiInVO
     * @return String
     * @exception DAOException 
     */
    public String searchEdiSndrByKlnettcs(DblEdiInVO dblEdiInVO) throws DAOException {
        DBRowSet dbRowset = null;
        String result = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = dblEdiInVO.getColumnValues();
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExec = new SQLExecuter("DEFAULT");
            BLIssuanceDBDAOsearchDblEdiSndrByKlnettcsRSQL template = new BLIssuanceDBDAOsearchDblEdiSndrByKlnettcsRSQL();
            dbRowset = sqlExec.executeQuery(template, param, velParam);
            if(dbRowset.next()){
                result = dbRowset.getString(1);
            }       
        } catch (SQLException ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch (Exception ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;
    }

    /**
     * search Edi Sndr 1
     * 
     * @author KimYoungchul
     * @param dblEdiInVO
     * @return String
     * @exception DAOException 
     */
    public String searchEdiSndr1(DblEdiInVO dblEdiInVO) throws DAOException {
        DBRowSet dbRowset = null;
        String result = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = dblEdiInVO.getColumnValues();
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExec = new SQLExecuter("DEFAULT");
            BLIssuanceDBDAOsearchDblEdiSndr1RSQL template = new BLIssuanceDBDAOsearchDblEdiSndr1RSQL();
            dbRowset = sqlExec.executeQuery(template, param, velParam);
            if(dbRowset.next()){
                result = dbRowset.getString(1);
            }       
        } catch (SQLException ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch (Exception ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;
    }

    /**
     * search Edi Sndr 2
     * 
     * @author KimYoungchul
     * @param dblEdiInVO
     * @return String
     * @exception DAOException 
     */
    public String searchEdiSndr2(DblEdiInVO dblEdiInVO) throws DAOException {
        DBRowSet dbRowset = null;
        String result = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = dblEdiInVO.getColumnValues();
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExec = new SQLExecuter("DEFAULT");
            BLIssuanceDBDAOsearchDblEdiSndr2RSQL template = new BLIssuanceDBDAOsearchDblEdiSndr2RSQL();
            dbRowset = sqlExec.executeQuery(template, param, velParam);
            if(dbRowset.next()){
                result = dbRowset.getString(1);
            }       
        } catch (SQLException ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch (Exception ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;
    }

    /**
     * search Dbl Edi Ib No
     * 
     * @author KimYoungchul
     * @param dblEdiInVO
     * @return String
     * @exception DAOException 
     */
    public String searchDblEdiIbNo(DblEdiInVO dblEdiInVO) throws DAOException {
        DBRowSet dbRowset = null;
        String result = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = dblEdiInVO.getColumnValues();
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExec = new SQLExecuter("DEFAULT");
            BLIssuanceDBDAOsearchDblEdiIbNoRSQL template = new BLIssuanceDBDAOsearchDblEdiIbNoRSQL();
            dbRowset = sqlExec.executeQuery(template, param, velParam);
            if(dbRowset.next()){
                result = dbRowset.getString(1);
            }       
        } catch (SQLException ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch (Exception ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;
    }

    /**
     * search Dbl Edi Max Rqst Seq
     * 
     * @author KimYoungchul
     * @param dblEdiInVO
     * @return String
     * @exception DAOException 
     */
    public String searchDblEdiMaxIbSeq(DblEdiInVO dblEdiInVO) throws DAOException {
        DBRowSet dbRowset = null;
        String result = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = dblEdiInVO.getColumnValues();
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExec = new SQLExecuter("DEFAULT");
            BLIssuanceDBDAOsearchDblEdiMaxIbSeqRSQL template = new BLIssuanceDBDAOsearchDblEdiMaxIbSeqRSQL();
            dbRowset = sqlExec.executeQuery(template, param, velParam);
            if(dbRowset.next()){
                result = dbRowset.getString(1);
            }       
        } catch (SQLException ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch (Exception ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;
    }

    /**
     * search Dbl Edi Info 1
     * 
     * @author KimYoungchul
     * @param dblEdiInVO
     * @return DblEdiInfoVO
     * @exception DAOException 
     */
    @SuppressWarnings("unchecked")
    public DblEdiInfoVO searchDblEdiInfo1(DblEdiInVO dblEdiInVO) throws DAOException {
        DBRowSet dbRowset = null;
        DblEdiInfoVO rsVO = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = dblEdiInVO.getColumnValues();
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExec = new SQLExecuter("DEFAULT");
            BLIssuanceDBDAOsearchDblEdiInfo1RSQL template = new BLIssuanceDBDAOsearchDblEdiInfo1RSQL();
            dbRowset = sqlExec.executeQuery(template, param, velParam);
            
            List<DblEdiInfoVO> list = (List) RowSetUtil.rowSetToVOs(dbRowset, DblEdiInfoVO.class);
            if(list.size() > 0){
                rsVO = list.get(0);
            }else{
                rsVO = new DblEdiInfoVO();
            }
        } catch (SQLException ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch (Exception ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return rsVO;
    }

    /**
     * search Dbl Edi Info 2
     * 
     * @author KimYoungchul
     * @param ediInfo
     * @return DblEdiInfoVO
     * @exception DAOException 
     */
    @SuppressWarnings("unchecked")
    public DblEdiInfoVO searchDblEdiInfo2(DblEdiInfoVO ediInfo) throws DAOException {
        DBRowSet dbRowset = null;
        DblEdiInfoVO rsVO = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = ediInfo.getColumnValues();
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExec = new SQLExecuter("DEFAULT");
            BLIssuanceDBDAOsearchDblEdiInfo2RSQL template = new BLIssuanceDBDAOsearchDblEdiInfo2RSQL();
            dbRowset = sqlExec.executeQuery(template, param, velParam);
            
            List<DblEdiInfoVO> list = (List) RowSetUtil.rowSetToVOs(dbRowset, DblEdiInfoVO.class);
            if(list.size() > 0){
                rsVO = list.get(0);
            }else{
                rsVO = new DblEdiInfoVO();
            }
        } catch (SQLException ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch (Exception ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return rsVO;
    }

    /**
     * search Dbl Edi Main 11
     * 
     * @author KimYoungchul
     * @param dblEdiInVO
     * @return String
     * @exception DAOException 
     */
    public String searchDblEdiMain11(DblEdiInVO dblEdiInVO) throws DAOException {
        DBRowSet dbRowset = null;
        String result = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = dblEdiInVO.getColumnValues();
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExec = new SQLExecuter("DEFAULT");
            BLIssuanceDBDAOsearchDblEdiMain11RSQL template = new BLIssuanceDBDAOsearchDblEdiMain11RSQL();
            dbRowset = sqlExec.executeQuery(template, param, velParam);
            if(dbRowset.next()){
                result = dbRowset.getString(1);
            }       
        } catch (SQLException ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch (Exception ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;
    }

    /**
     * search Dbl Edi Main 12
     * 
     * @author KimYoungchul
     * @param dblEdiInVO
     * @return String
     * @exception DAOException 
     */
    public String searchDblEdiMain12(DblEdiInVO dblEdiInVO) throws DAOException {
        DBRowSet dbRowset = null;
        String result = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = dblEdiInVO.getColumnValues();
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExec = new SQLExecuter("DEFAULT");
            BLIssuanceDBDAOsearchDblEdiMain12RSQL template = new BLIssuanceDBDAOsearchDblEdiMain12RSQL();
            dbRowset = sqlExec.executeQuery(template, param, velParam);
            if(dbRowset.next()){
                result = dbRowset.getString(1);
            }       
        } catch (SQLException ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch (Exception ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;
    }

    /**
     * search Dbl Edi Gmt
     * 
     * @author KimYoungchul
     * @param dblEdiInVO
     * @return String
     * @exception DAOException 
     */
    public String searchDblEdiGmt(DblEdiInVO dblEdiInVO) throws DAOException {
        DBRowSet dbRowset = null;
        String result = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = dblEdiInVO.getColumnValues();
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExec = new SQLExecuter("DEFAULT");
            BLIssuanceDBDAOsearchDblEdiGmtRSQL template = new BLIssuanceDBDAOsearchDblEdiGmtRSQL();
            dbRowset = sqlExec.executeQuery(template, param, velParam);
            if(dbRowset.next()){
                result = dbRowset.getString(1);
            }else{
                result = "DOC_CRDATE_GMT:";
            }
        } catch (SQLException ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch (Exception ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;
    }

    /**
     * search Dbl Edi Main 2
     * 
     * @author KimYoungchul
     * @param dblEdiInVO
     * @return String
     * @exception DAOException 
     */
    public String searchDblEdiMain2(DblEdiInVO dblEdiInVO) throws DAOException {
        DBRowSet dbRowset = null;
        String result = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = dblEdiInVO.getColumnValues();
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExec = new SQLExecuter("DEFAULT");
            BLIssuanceDBDAOsearchDblEdiMain2RSQL template = new BLIssuanceDBDAOsearchDblEdiMain2RSQL();
            dbRowset = sqlExec.executeQuery(template, param, velParam);
            if(dbRowset.next()){
                result = dbRowset.getString(1);
            }       
        } catch (SQLException ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch (Exception ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;
    }

    /**
     * search Dbl Edi Ms Ibcs
     * 
     * @author KimYoungchul
     * @param dblEdiInVO
     * @return String
     * @exception DAOException 
     */
    public String searchDblEdiMsIbcs(DblEdiInVO dblEdiInVO) throws DAOException {
        DBRowSet dbRowset = null;
        String result = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = dblEdiInVO.getColumnValues();
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExec = new SQLExecuter("DEFAULT");
            BLIssuanceDBDAOsearchDblEdiMsIbcsRSQL template = new BLIssuanceDBDAOsearchDblEdiMsIbcsRSQL();
            dbRowset = sqlExec.executeQuery(template, param, velParam);
            if(dbRowset.next()){
                result = dbRowset.getString(1);
            } else {
                result = "MS_IBCS_NM1:\n"
                       + "MS_IBCS_NM2:\n" 
                       + "MS_IBCS_ADDR1:\n" 
                       + "MS_IBCS_ADDR2:\n" 
                       + "MS_IBCS_ADDR3:\n"
                       + "MS_CUST_CD:\n" 
                       + "MS_CITY_NM:\n" 
                       + "MS_STAT_CD:\n" 
                       + "MS_ZIP_CD:\n"
                       + "MS_CNT_CD:\n";
            }
        } catch (SQLException ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch (Exception ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;
    }

    /**
     * search Dbl Edi Cust Ibcs
     * 
     * @author KimYoungchul
     * @param dblEdiInVO
     * @return String
     * @exception DAOException 
     */
    public String searchDblEdiCustIbcs(DblEdiInVO dblEdiInVO) throws DAOException {
        DBRowSet dbRowset = null;
        String result = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = dblEdiInVO.getColumnValues();
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExec = new SQLExecuter("DEFAULT");
            BLIssuanceDBDAOsearchDblEdiCustIbcsRSQL template = new BLIssuanceDBDAOsearchDblEdiCustIbcsRSQL();
            dbRowset = sqlExec.executeQuery(template, param, velParam);
            if(dbRowset.next()){
                result = dbRowset.getString(1);
            } else {             
                result = "SH_IBCS_C_NM1:\n"
                       + "SH_IBCS_C_NM2:\n" 
                       + "NF_IBCS_C_NM1:\n" 
                       + "NF_IBCS_C_NM2:\n" 
                       + "CN_IBCS_C_NM1:\n" 
                       + "CN_IBCS_C_NM2:\n" 
                       + "FW_IBCS_C_NM1:\n" 
                       + "FW_IBCS_C_NM2:\n" 
                       + "AN_IBCS_C_NM1:\n" 
                       + "AN_IBCS_C_NM2:\n";
            }
        } catch (SQLException ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch (Exception ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;
    }

    /**
     * search Dbl Edi Ib Sh Ref
     * 
     * @author KimYoungchul
     * @param dblEdiInVO
     * @return String
     * @exception DAOException 
     */
    public String searchDblEdiIbShRef(DblEdiInVO dblEdiInVO) throws DAOException {
        DBRowSet dbRowset = null;
        String result = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = dblEdiInVO.getColumnValues();
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExec = new SQLExecuter("DEFAULT");
            BLIssuanceDBDAOsearchDblEdiIbShRefRSQL template = new BLIssuanceDBDAOsearchDblEdiIbShRefRSQL();
            dbRowset = sqlExec.executeQuery(template, param, velParam);
            if(dbRowset.next()){
                result = dbRowset.getString(1);
            } else {             
                result = "IB_SH_REF_NO:\n"
                	   + "IB_EXP_REF_NO:\n"
                       + "IB_SC_NO:\n";
            }
        } catch (SQLException ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch (Exception ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;
    }

    /**
     * search Dbl Edi Send Cnt
     * 
     * @author KimYoungchul
     * @param dblEdiInVO
     * @return String
     * @exception DAOException 
     */
    public String searchDblEdiSendCnt(DblEdiInVO dblEdiInVO) throws DAOException {
        DBRowSet dbRowset = null;
        String result = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = dblEdiInVO.getColumnValues();
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExec = new SQLExecuter("DEFAULT");
            BLIssuanceDBDAOsearchDblEdiSendCntRSQL template = new BLIssuanceDBDAOsearchDblEdiSendCntRSQL();
            dbRowset = sqlExec.executeQuery(template, param, velParam);
            if(dbRowset.next()){
                result = dbRowset.getString(1);
            } else {             
                result = "BL_SEND_CNT:1\n";
            }
        } catch (SQLException ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch (Exception ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;
    }

    /**
     * search Dbl Edi Mrn No
     * 
     * @author KimYoungchul
     * @param dblEdiInVO
     * @return String
     * @exception DAOException 
     */
    public String searchDblEdiMrnNo(DblEdiInVO dblEdiInVO) throws DAOException {
        DBRowSet dbRowset = null;
        String result = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = dblEdiInVO.getColumnValues();
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExec = new SQLExecuter("DEFAULT");
            BLIssuanceDBDAOsearchDblEdiMrnNoRSQL template = new BLIssuanceDBDAOsearchDblEdiMrnNoRSQL();
            dbRowset = sqlExec.executeQuery(template, param, velParam);
            if(dbRowset.next()){
                result = dbRowset.getString(1);
            } else {             
                result = "MRN_NO: \n";
            }
        } catch (SQLException ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch (Exception ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;
    }

    /**
     * search Dbl Edi Pol Atd
     * 
     * @author KimYoungchul
     * @param dblEdiInVO
     * @return String
     * @exception DAOException 
     */
    public String searchDblEdiPolAtd(DblEdiInVO dblEdiInVO) throws DAOException {
        DBRowSet dbRowset = null;
        String result = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = dblEdiInVO.getColumnValues();
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExec = new SQLExecuter("DEFAULT");
            BLIssuanceDBDAOsearchDblEdiPolAtdRSQL template = new BLIssuanceDBDAOsearchDblEdiPolAtdRSQL();
            dbRowset = sqlExec.executeQuery(template, param, velParam);
            if(dbRowset.next()){
                result = dbRowset.getString(1);
            } else {             
                result = "POL_ATD: \n";
            }
        } catch (SQLException ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch (Exception ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;
    }

    /**
     * search Dbl Edi Pod Ata
     * 
     * @author KimYoungchul
     * @param dblEdiInVO
     * @return String
     * @exception DAOException 
     */
    public String searchDblEdiPodAta(DblEdiInVO dblEdiInVO) throws DAOException {
        DBRowSet dbRowset = null;
        String result = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = dblEdiInVO.getColumnValues();
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExec = new SQLExecuter("DEFAULT");
            BLIssuanceDBDAOsearchDblEdiPodAtaRSQL template = new BLIssuanceDBDAOsearchDblEdiPodAtaRSQL();
            dbRowset = sqlExec.executeQuery(template, param, velParam);
            if(dbRowset.next()){
                result = dbRowset.getString(1);
            } else {             
                result = "POD_ATA: \n";
            }
        } catch (SQLException ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch (Exception ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;
    }

    /**
     * search Dbl Edi Cust Ref
     * 
     * @author KimYoungchul
     * @param dblEdiInVO
     * @param blTp
     * @return String
     * @exception DAOException 
     */
    public String searchDblEdiCustRef(DblEdiInVO dblEdiInVO, String blTp) throws DAOException {
        DBRowSet dbRowset = null;
        String result = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = dblEdiInVO.getColumnValues();
            mapVO.put("bl_tp", blTp);
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExec = new SQLExecuter("DEFAULT");
            BLIssuanceDBDAOsearchDblEdiCustRefRSQL template = new BLIssuanceDBDAOsearchDblEdiCustRefRSQL();
            dbRowset = sqlExec.executeQuery(template, param, velParam);
            if(dbRowset.next()){
                result = dbRowset.getString(1);
            } else {             
                result = "SI_VIA: \n"
                       + "FRT_INCLUDE_IND:\n"
                       + "BKG_CUST_REF_NO: \n"
                       + "BKG_SH_REF_NO: \n"
                       + "BKG_FF_REF_NO: \n"
                       + "SI_CUST_REF_NO: \n"
                       + "SI_SH_REF_NO: \n"
                       + "SI_FF_REF_NO:\n";
            }
        } catch (SQLException ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch (Exception ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;
    }

    /**
     * search Dbl Edi Icust
     * 
     * @author KimYoungchul
     * @param dblEdiInVO
     * @return String
     * @exception DAOException 
     */
    public String searchDblEdiIcust(DblEdiInVO dblEdiInVO) throws DAOException {
        DBRowSet dbRowset = null;
        String result = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = dblEdiInVO.getColumnValues();
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExec = new SQLExecuter("DEFAULT");
            BLIssuanceDBDAOsearchDblEdiIcustRSQL template = new BLIssuanceDBDAOsearchDblEdiIcustRSQL();
            dbRowset = sqlExec.executeQuery(template, param, velParam);
            
            StringBuffer buf = new StringBuffer();
            while(dbRowset.next()){
            	buf.append(dbRowset.getString(1));
            } 

            if(buf.length() > 0){
            	result = buf.toString();
            }else{           
                result = "{I_BKG_CUST\n"
                       + "IBCS_TP:\n"
                       + "IBCS_NM1:\n"
                       + "IBCS_NM2:\n"
                       + "IBCS_ADDR1:\n"
                       + "IBCS_ADDR2:\n"
                       + "IBCS_ADDR3:\n"
                       + "IBCS_ADDR4:\n"
                       + "IBCS_ADDR5:\n"
                       + "IBCS_C_NM1:\n"
                       + "IBCS_C_NM2:\n"
                       + "CNT_CD:\n"
                       + "CUST_CD:\n"
                       + "UN_CUST_CD:\n"
                       + "PCC_CUST_CD:\n"
                       + "PARTNER_REF_NO:\n"
                       + "IBCS_CUST_LOC:\n"
                       + "IBCS_STREET:\n"
                       + "IBCS_LOC_CD:\n"
                       + "IBCS_LOC_NM:\n"
                       + "IBCS_STAT_CD:\n"
                       + "IBCS_ZIP_CD:\n"
                       + "IBCS_CNT_CD:\n"
                       + "IBCS_C_TP:\n"
                       + "IBCS_C_NM:\n"
                       + "IBCS_C_TEL:\n"
                       + "IBCS_C_FAX:\n"
                       + "IBCS_C_EMAIL:\n"
                       + "}I_BKG_CUST\n";
            }
        } catch (SQLException ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch (Exception ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;
    }

    /**
     * search Dbl Edi Bkg Info.
     * 
     * @author KimYoungchul
     * @param dblEdiInVO
     * @return String
     * @exception DAOException 
     */
    public String searchDblEdiBkgInfo(DblEdiInVO dblEdiInVO) throws DAOException {
        DBRowSet dbRowset = null;
        String result = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = dblEdiInVO.getColumnValues();
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExec = new SQLExecuter("DEFAULT");
            BLIssuanceDBDAOsearchDblEdiBkgInfoRSQL template = new BLIssuanceDBDAOsearchDblEdiBkgInfoRSQL();
            dbRowset = sqlExec.executeQuery(template, param, velParam);
            if(dbRowset.next()){
                result = dbRowset.getString(1);
            } else {             
                result = "{I_BKG_INFO\n"
                       + "IB_BKG_IND:\n"
                       + "IB_PKG_QTY:\n"
                       + "IB_PKG_CD:\n"
                       + "IBI_POR_CD:\n"
                       + "IBI_POR_CD_TP_CD:\n"
                       + "IBI_POR_NM:\n"
                       + "IBI_POL_CD:\n"
                       + "IBI_POL_CD_TP_CD:\n"
                       + "IBI_POL_NM:\n"
                       + "IBI_POD_CD:\n"
                       + "IBI_POD_CD_TP_CD:\n"
                       + "IBI_POD_NM:\n"
                       + "IBI_DEL_CD:\n"
                       + "IBI_DEL_CD_TP_CD:\n"
                       + "IBI_DEL_NM:\n"
                       + "IBI_TRANS_IND:\n"
                       + "IBI_SR_AMT:\n"
                       + "IBI_DOC_ID:\n"
                       + "IBI_DOC_SEQ:\n"
                       + "IBI_CHG_CD:\n"
                       + "}I_BKG_INFO\n";
            }
        } catch (SQLException ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch (Exception ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;
    }

    /**
     * search Dbl Edi Chg By Trax
     * 
     * @author KimYoungchul
     * @param dblEdiInVO
     * @return String[]
     * @exception DAOException 
     */
    public String[] searchDblEdiChgByTrax(DblEdiInVO dblEdiInVO) throws DAOException {
        DBRowSet dbRowset = null;
        String[] result = new String[3];
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = dblEdiInVO.getColumnValues();
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExec = new SQLExecuter("DEFAULT");
            BLIssuanceDBDAOsearchDblEdiChgByTraxRSQL template = new BLIssuanceDBDAOsearchDblEdiChgByTraxRSQL();
            dbRowset = sqlExec.executeQuery(template, param, velParam);
            if(dbRowset.next()){
                result[0] = dbRowset.getString(1);
                result[1] = dbRowset.getString(2);
                result[2] = dbRowset.getString(3);
            } else {             
                result[0] = "";
                result[1] = "";
                result[2] = "";
            }
        } catch (SQLException ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch (Exception ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;
    }

    /**
     * search Dbl Edi Chg By Chn Trax
     * 
     * @author KimYoungchul
     * @param dblEdiInVO
     * @return String
     * @exception DAOException 
     */
    public String searchDblEdiChgByChnTrax(DblEdiInVO dblEdiInVO) throws DAOException {
        DBRowSet dbRowset = null;
        String result = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = dblEdiInVO.getColumnValues();
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExec = new SQLExecuter("DEFAULT");
            BLIssuanceDBDAOsearchDblEdiChgByChnTraxRSQL template = new BLIssuanceDBDAOsearchDblEdiChgByChnTraxRSQL();
            dbRowset = sqlExec.executeQuery(template, param, velParam);
            
            StringBuffer buf = new StringBuffer();
            while(dbRowset.next()){
            	buf.append(dbRowset.getString(1));
//            	buf.append('\n');
            } 

            if(buf.length() > 0){
            	result = buf.toString();
            }else{
                result = "{CHARGE\n"
                       + "FCTYPE:\n"
                       + "RATE:\n"
                       + "RATED_AS:\n"
                       + "REVENUETON:\n"
                       + "DIF_AMT:\n"
                       + "PPD:\n"
                       + "CCT:\n"
                       + "CURRENCYCODE:\n"
                       + "TARIFF:\n"
                       + "PERTYPE:\n"
                       + "EXRATE:\n"
                       + "FRT_IND:\n"
                       + "}CHARGE\n";
            }
        } catch (SQLException ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch (Exception ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;
    }
    
    /**
     * search Dbl Edi Chg By Swa Trax
     * 
     * @author KimYoungchul
     * @param dblEdiInVO
     * @return String
     * @exception DAOException 
     */
    public String searchDblEdiChgBySwaTrax(DblEdiInVO dblEdiInVO) throws DAOException {
        DBRowSet dbRowset = null;
        String result = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = dblEdiInVO.getColumnValues();
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExec = new SQLExecuter("DEFAULT");
            BLIssuanceDBDAOsearchDblEdiChgBySwaTraxRSQL template = new BLIssuanceDBDAOsearchDblEdiChgBySwaTraxRSQL();
            dbRowset = sqlExec.executeQuery(template, param, velParam);
            
            StringBuffer buf = new StringBuffer();
            while(dbRowset.next()){
            	buf.append(dbRowset.getString(1));
//            	buf.append('\n');
            } 

            if(buf.length() > 0){
            	result = buf.toString();
            }else{
                result = "{CHARGE\n"
                       + "FCTYPE:\n"
                       + "RATE:\n"
                       + "RATED_AS:\n"
                       + "REVENUETON:\n"
                       + "DIF_AMT:\n"
                       + "PPD:\n"
                       + "CCT:\n"
                       + "CURRENCYCODE:\n"
                       + "TARIFF:\n"
                       + "PERTYPE:\n"
                       + "EXRATE:\n"
                       + "FRT_IND:\n"
                       + "}CHARGE\n";
            }
        } catch (SQLException ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch (Exception ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;
    }
    
    /**
     * search Dbl Edi Chg 
     * 
     * @author KimYoungchul
     * @param dblEdiInVO
     * @return String
     * @exception DAOException 
     */
    public String searchDblEdiChg(DblEdiInVO dblEdiInVO) throws DAOException {
        DBRowSet dbRowset = null;
        String result = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = dblEdiInVO.getColumnValues();
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExec = new SQLExecuter("DEFAULT");
            BLIssuanceDBDAOsearchDblEdiChgRSQL template = new BLIssuanceDBDAOsearchDblEdiChgRSQL();
            dbRowset = sqlExec.executeQuery(template, param, velParam);
            
            StringBuffer buf = new StringBuffer();
            while(dbRowset.next()){
            	buf.append(dbRowset.getString(1));
//            	buf.append('\n');
            } 

            if(buf.length() > 0){
            	result = buf.toString();
            }else{           
                result = "{CHARGE\n"
                       + "FCTYPE:\n"
                       + "RATE:\n"
                       + "RATED_AS:\n"
                       + "REVENUETON:\n"
                       + "DIF_AMT:\n"
                       + "PPD:\n"
                       + "CCT:\n"
                       + "CURRENCYCODE:\n"
                       + "TARIFF:\n"
                       + "PERTYPE:\n"
                       + "EXRATE:\n"
                       + "FRT_IND:\n"
                       + "}CHARGE\n";
            }
        } catch (SQLException ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch (Exception ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;
    }

    /**
     * search Dbl Edi Chg Detail 1
     * 
     * @author KimYoungchul
     * @param dblEdiInVO
     * @return String
     * @exception DAOException 
     */
    public String searchDblEdiChgDtl1(DblEdiInVO dblEdiInVO) throws DAOException {
        DBRowSet dbRowset = null;
        String result = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = dblEdiInVO.getColumnValues();
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExec = new SQLExecuter("DEFAULT");
            BLIssuanceDBDAOsearchDblEdiChgDtl1RSQL template = new BLIssuanceDBDAOsearchDblEdiChgDtl1RSQL();
            dbRowset = sqlExec.executeQuery(template, param, velParam);
            
            StringBuffer buf = new StringBuffer();
            while(dbRowset.next()){
            	buf.append(dbRowset.getString(1));
            } 

            if(buf.length() > 0){
            	result = buf.toString();
            }else{           
                result = "{CHARGE_TTL\n"
                       + "PPD_TOTAL:\n"
                       + "CCT_TOTAL:\n"
                       + "TOTAL_CUR:\n"
                       + "LCL_TOT_AMT:\n"
                       + "CGO_RCV_DT:\n"
                       + "ACT_CUST:\n"
                       + "}CHARGE_TTL\n";
            }
        } catch (SQLException ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch (Exception ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;
    }

    /**
     * search Dbl Edi Chg Detail 2
     * 
     * @author KimYoungchul
     * @param dblEdiInVO
     * @return String
     * @exception DAOException 
     */
    public String searchDblEdiChgDtl2(DblEdiInVO dblEdiInVO) throws DAOException {
        DBRowSet dbRowset = null;
        String result = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = dblEdiInVO.getColumnValues();
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExec = new SQLExecuter("DEFAULT");
            BLIssuanceDBDAOsearchDblEdiChgDtl2RSQL template = new BLIssuanceDBDAOsearchDblEdiChgDtl2RSQL();
            dbRowset = sqlExec.executeQuery(template, param, velParam);
            
            StringBuffer buf = new StringBuffer();
            while(dbRowset.next()){
            	buf.append(dbRowset.getString(1));
            } 

            if(buf.length() > 0){
            	result = buf.toString();
            }else{           
                result = "{CHARGE_TTL\n"
                       + "PPD_TOTAL:\n"
                       + "CCT_TOTAL:\n"
                       + "TOTAL_CUR:\n"
                       + "LCL_TOT_AMT:\n"
                       + "CGO_RCV_DT:\n"
                       + "ACT_CUST:\n"
                       + "}CHARGE_TTL\n";
            }
        } catch (SQLException ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch (Exception ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;
    }

    /**
     * search Dbl Edi Chg Detail 3
     * 
     * @author KimYoungchul
     * @param dblEdiInVO
     * @return String
     * @exception DAOException 
     */
    public String searchDblEdiChgDtl3(DblEdiInVO dblEdiInVO) throws DAOException {
        DBRowSet dbRowset = null;
        String result = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = dblEdiInVO.getColumnValues();
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExec = new SQLExecuter("DEFAULT");
            BLIssuanceDBDAOsearchDblEdiChgDtl3RSQL template = new BLIssuanceDBDAOsearchDblEdiChgDtl3RSQL();
            dbRowset = sqlExec.executeQuery(template, param, velParam);
            
            StringBuffer buf = new StringBuffer();
            while(dbRowset.next()){
            	buf.append(dbRowset.getString(1));
            } 

            if(buf.length() > 0){
            	result = buf.toString();
            }else{           
                result = "{CHARGE_TTL\n"
                       + "PPD_TOTAL:\n"
                       + "CCT_TOTAL:\n"
                       + "TOTAL_CUR:\n"
                       + "LCL_TOT_AMT:\n"
                       + "CGO_RCV_DT:\n"
                       + "ACT_CUST:\n"
                       + "}CHARGE_TTL\n";
            }
        } catch (SQLException ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch (Exception ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;
    }

    /**
     * search Dbl Edi Marks & Desc.
     * 
     * @author KimYoungchul
     * @param dblEdiInVO
     * @return String
     * @exception DAOException 
     */
    public String[] searchDblEdiMkDesc(DblEdiInVO dblEdiInVO) throws DAOException {
        DBRowSet dbRowset = null;
        String[] result = new String[2];
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = dblEdiInVO.getColumnValues();
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExec = new SQLExecuter("DEFAULT");
            BLIssuanceDBDAOsearchDblEdiMkDescRSQL template = new BLIssuanceDBDAOsearchDblEdiMkDescRSQL();
            dbRowset = sqlExec.executeQuery(template, param, velParam);
            if(dbRowset.next()){
                result[0] = dbRowset.getString(1);
                result[1] = dbRowset.getString(2);
            } else {             
                result[0] = "BL_DESC:\n";
                result[1] = "MARKNO:\n";
            }
        } catch (SQLException ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch (Exception ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;
    }

    /**
     * search Dbl Edi Container
     * 
     * @author KimYoungchul
     * @param dblEdiInVO
     * @return List<DblEdiCntrVO>
     * @exception DAOException 
     */
    @SuppressWarnings("unchecked")
    public List<DblEdiCntrVO> searchDblEdiCntr(DblEdiInVO dblEdiInVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<DblEdiCntrVO> list = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = dblEdiInVO.getColumnValues();
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExec = new SQLExecuter("DEFAULT");
            BLIssuanceDBDAOsearchDblEdiCntrRSQL template = new BLIssuanceDBDAOsearchDblEdiCntrRSQL();
            dbRowset = sqlExec.executeQuery(template, param, velParam);
            
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, DblEdiCntrVO.class);

        } catch (SQLException ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch (Exception ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
    }

    /**
     * search Dbl Edi Container
     * 
     * @author KimYoungchul
     * @param dblEdiInVO
     * @param cntrNo
     * @return String
     * @exception DAOException 
     */
    public String searchDblEdiCntrDg(DblEdiInVO dblEdiInVO, String cntrNo) throws DAOException {
        DBRowSet dbRowset = null;
        String result = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = dblEdiInVO.getColumnValues();
            mapVO.put("cntr_no", cntrNo);
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExec = new SQLExecuter("DEFAULT");
            BLIssuanceDBDAOsearchDblEdiCntrDgRSQL template = new BLIssuanceDBDAOsearchDblEdiCntrDgRSQL();
            dbRowset = sqlExec.executeQuery(template, param, velParam);
            
            StringBuffer buf = new StringBuffer();
            while(dbRowset.next()){
            	buf.append(dbRowset.getString(1));
            } 

            if(buf.length() > 0){
            	result = buf.toString();
            }else{
                result = "{CNTR_DANGER\n"
                    + "UNNBR:\n"
                    + "CLASS:\n"
                    + "DG_DESC:\n"
                    + "PHONE:\n"
                    + "PAGE:\n"
                    + "FLSH_TEMP:\n"
                    + "FLSH_UNIT:\n"
                    + "DG_REMARK:\n"
                    + "EMSNO:\n"
                    + "PSACLS:\n"
                    + "PKGGRP:\n"
                    + "MFAG1:\n"
                    + "MFAG2:\n"
                    + "MAR_POLL:\n"
                    + "LABEL_CD:\n"
                    + "LABEL_DESC:\n"
                    + "DG_PKG:\n"
                    + "DG_PKGUNIT:\n"
                    + "NWGT:\n"
                    + "NWGT_UNIT:\n"
                    + "GWGT:\n"
                    + "GWGT_UNIT:\n"
                    + "MEA:\n"
                    + "MEA_UNIT:\n"
                    + "HAZ_CONT:\n"
                    + "STWG:\n"
                    + "PACK_GP:\n"
                    + "}CNTR_DANGER\n";
            }
        } catch (SQLException ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch (Exception ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;
    }

    /**
     * search Dbl Edi Cntr Mf_desc
     * 
     * @author KimYoungchul
     * @param dblEdiInVO
     * @param cntrNo
     * @return String
     * @exception DAOException 
     */
    public String searchDblEdiCntrMf(DblEdiInVO dblEdiInVO, String cntrNo) throws DAOException {
        DBRowSet dbRowset = null;
        String result = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = dblEdiInVO.getColumnValues();
            mapVO.put("cntr_no", cntrNo);
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExec = new SQLExecuter("DEFAULT");
            BLIssuanceDBDAOsearchDblEdiCntrMfRSQL template = new BLIssuanceDBDAOsearchDblEdiCntrMfRSQL();
            dbRowset = sqlExec.executeQuery(template, param, velParam);
            
            StringBuffer buf = new StringBuffer();
            while(dbRowset.next()){
            	buf.append(dbRowset.getString(1));
            } 

            if(buf.length() > 0){
            	result = buf.toString();
            }else{
                result = "{CNTR_DESC:\n"
                       + "D_CMDT:\n"
                    + "D_PUNIT:\n"
                    + "D_PKG:\n"
                    + "D_WGT:\n"
                    + "D_MEAS:\n"
                    + "D_DESC:\n"
                    + "{CUS_MARK:\n"
                    + "D_MARK:\n"
                    + "}CUS_MARK:\n"
                    + "}CNTR_DESC:\n";
            }
        } catch (SQLException ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch (Exception ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;
    }    

    /**
     * search Dbl Edi Cntr PO No.
     * 
     * @author KimYoungchul
     * @param dblEdiInVO
     * @param cntrNo
     * @return String
     * @exception DAOException 
     */
    public String searchDblEdiCntrPo(DblEdiInVO dblEdiInVO, String cntrNo) throws DAOException {
        DBRowSet dbRowset = null;
        String result = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = dblEdiInVO.getColumnValues();
            mapVO.put("cntr_no", cntrNo);
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExec = new SQLExecuter("DEFAULT");
            BLIssuanceDBDAOsearchDblEdiCntrPoRSQL template = new BLIssuanceDBDAOsearchDblEdiCntrPoRSQL();
            dbRowset = sqlExec.executeQuery(template, param, velParam);
            
            StringBuffer buf = new StringBuffer();
            while(dbRowset.next()){
            	buf.append(dbRowset.getString(1));
            } 

            if(buf.length() > 0){
            	result = buf.toString();
            }else{
                result = "{MULTI_PO_NO:\n"
                       + "CNTR_PO_NO:\n"
                       + "}MULTI_PO_NO:\n";
            }
        } catch (SQLException ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch (Exception ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;
    }

    /**
     * search Dbl Edi Cntr Seal No.
     * 
     * @author KimYoungchul
     * @param dblEdiInVO
     * @param cntrNo
     * @return String
     * @exception DAOException 
     */
    public String searchDblEdiCntrSeal(DblEdiInVO dblEdiInVO, String cntrNo) throws DAOException {
        DBRowSet dbRowset = null;
        String result = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = dblEdiInVO.getColumnValues();
            mapVO.put("cntr_no", cntrNo);
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExec = new SQLExecuter("DEFAULT");
            BLIssuanceDBDAOsearchDblEdiCntrSealRSQL template = new BLIssuanceDBDAOsearchDblEdiCntrSealRSQL();
            dbRowset = sqlExec.executeQuery(template, param, velParam);
            
            StringBuffer buf = new StringBuffer();
            while(dbRowset.next()){
            	buf.append(dbRowset.getString(1));
            } 

            if(buf.length() > 0){
            	result = buf.toString();
            }else{
                result = "{MULTI_SEAL_NO:\n"
                       + "CNTR_SEAL_NO:\n"
                       + "}MULTI_SEAL_NO:\n";
            }
        } catch (SQLException ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch (Exception ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;
    }

    /**
     * search Dbl Edi Qty
     * 
     * @author KimYoungchul
     * @param dblEdiInVO
     * @return String
     * @exception DAOException 
     */
    public String searchDblEdiQty(DblEdiInVO dblEdiInVO) throws DAOException {
        DBRowSet dbRowset = null;
        String result = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = dblEdiInVO.getColumnValues();
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExec = new SQLExecuter("DEFAULT");
            BLIssuanceDBDAOsearchDblEdiQtyRSQL template = new BLIssuanceDBDAOsearchDblEdiQtyRSQL();
            dbRowset = sqlExec.executeQuery(template, param, velParam);
            
            StringBuffer buf = new StringBuffer();
            while(dbRowset.next()){
            	buf.append(dbRowset.getString(1));
            } 

            if(buf.length() > 0){
            	result = buf.toString();
            }else{
                result = "{QTY\n"
                       + "HANTYPE:"
                       + "COUNT:"
                       + "}QTY\n";
            }
        } catch (SQLException ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch (Exception ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;
    }

    /**
     * search Dbl Edi Vvd
     * 
     * @author KimYoungchul
     * @param dblEdiInVO
     * @return String
     * @exception DAOException 
     */
    public String searchDblEdiVvd(DblEdiInVO dblEdiInVO) throws DAOException {
        DBRowSet dbRowset = null;
        String result = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = dblEdiInVO.getColumnValues();
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExec = new SQLExecuter("DEFAULT");
            BLIssuanceDBDAOsearchDblEdiVvdRSQL template = new BLIssuanceDBDAOsearchDblEdiVvdRSQL();
            dbRowset = sqlExec.executeQuery(template, param, velParam);
            
            StringBuffer buf = new StringBuffer();
            while(dbRowset.next()){
            	buf.append(dbRowset.getString(1));
//            	buf.append('\n');
            } 

            if(buf.length() > 0){
            	result = buf.toString();
            }else{
                result = "{BKGVVD\n"
                    + "BVVD1:\n"
                    + "VSL_CALLSIGN1:\n"
                    + "VSL_LLOYDCODE1:\n"
                    + "VSL_FULLNAME1:\n"
                    + "BLPOL1:\n"
                    + "POL_FULLNAME1:\n"
                    + "BLPOD1:\n"
                    + "POD_FULLNAME1:\n"
                    + "POLETA1:\n"
                    + "POLETD1:\n"
                    + "PODETA1:\n"
                    + "PODETD1:\n"
                    + "VSLFLAG1:\n"
                    + "}BKGVVD\n";
            }
        } catch (SQLException ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch (Exception ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;
    }

    /**
     * search Dbl Edi Misc
     * 
     * @author KimYoungchul
     * @param DblEdiInVO dblEdiInVO
	 * @param String strSamf
     * @return String
     * @exception DAOException 
     */
    public String searchDblEdiMisc(DblEdiInVO dblEdiInVO, String strSamf) throws DAOException {
        DBRowSet dbRowset = null;
        String result = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = dblEdiInVO.getColumnValues();
            
            param.putAll(mapVO);
            param.put("samf", strSamf);
            velParam.putAll(mapVO);
            velParam.put("samf", strSamf);
            
            SQLExecuter sqlExec = new SQLExecuter("DEFAULT");
            BLIssuanceDBDAOsearchDblEdiMiscRSQL template = new BLIssuanceDBDAOsearchDblEdiMiscRSQL();
            dbRowset = sqlExec.executeQuery(template, param, velParam);
            if(dbRowset.next()){
                result = dbRowset.getString(1);
            }else{
                result = "{I_BKG_MISC\n"
                    + "IBM_PLANT_CD:\n"
                    + "IBM_PLANT_NM:\n"
                    + "IBM_DIV_CD:\n"
                    + "IBM_DIV_NM:\n"
                    + "IBM_BIZ_TP:\n"
                    + "IBM_BIZ_NM:\n"
                    + "IBM_TS_TP:\n"
                    + "IBM_TS_NM:\n"
                    + "IBM_POL_ZIP_CD:\n"
                    + "IBM_POL_POST_CD:\n"
                    + "IBM_POD_ZIP_CD:\n"
                    + "IBM_POD_POST_CD:\n"
                    + "IBM_DEL_ZIP_CD:\n"
                    + "IBM_DEL_POST_CD:\n"
                    + "IBM_PAY_MTH:\n"
                    + "IBM_INV_DT:\n"
                    + "IBM_LINE_CHG_WGT:\n"
                    + "IBM_LINE_CHG_WGT_CD:\n"
                    + "IBM_EDN_CHG_QTY:\n"
                    + "IBM_EDN_CHG_QTY_CD:\n"
                    + "IBM_EDN_CHG_WGT:\n"
                    + "IBM_EDN_CHG_WGT_CD:\n"
                    + "IBM_SUMCHG_WGT_QTY:\n"
                    + "IBM_SUMCHG_WGT_CD:\n"
                    + "IBM_MESSAGE_NO:\n"
                    + "}I_BKG_MISC\n";
            }
        } catch (SQLException ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch (Exception ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;
    }

    /**
     * search Dbl Edi Hp Swa
     * 
     * @author KimYoungchul
     * @param dblEdiInVO
     * @return String
     * @exception DAOException 
     */
    public String searchDblEdiHpSwa(DblEdiInVO dblEdiInVO) throws DAOException {
        DBRowSet dbRowset = null;
        String result = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = dblEdiInVO.getColumnValues();
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExec = new SQLExecuter("DEFAULT");
            BLIssuanceDBDAOsearchDblEdiHpSwaRSQL template = new BLIssuanceDBDAOsearchDblEdiHpSwaRSQL();
            dbRowset = sqlExec.executeQuery(template, param, velParam);
            
            StringBuffer buf = new StringBuffer();
            while(dbRowset.next()){
            	buf.append(dbRowset.getString(1));
            } 

            if(buf.length() > 0){
            	result = buf.toString();
            }else{
                result = "{HPSWA_INFO\n"
                       + "SHIP_ID:\n"
                       + "PART_NO:\n"
                       + "}HPSWA_INFO\n";
            }
        } catch (SQLException ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch (Exception ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;
    }

    /**
     * search Dbl Edi Chg Info
     * 
     * @author KimYoungchul
     * @param dblEdiInVO
     * @return String
     * @exception DAOException 
     */
    public String searchDblEdiChgInfo(DblEdiInVO dblEdiInVO) throws DAOException {
        DBRowSet dbRowset = null;
        String result = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = dblEdiInVO.getColumnValues();
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExec = new SQLExecuter("DEFAULT");
            BLIssuanceDBDAOsearchDblEdiChgInfoRSQL template = new BLIssuanceDBDAOsearchDblEdiChgInfoRSQL();
            dbRowset = sqlExec.executeQuery(template, param, velParam);
            
            StringBuffer buf = new StringBuffer();
            while(dbRowset.next()){
            	buf.append(dbRowset.getString(1));
            } 

            if(buf.length() > 0){
            	result = buf.toString();
            }else{
                result = "{CHARGE_INFO\n"
                       + "CHG_APPL_DT:\n"
                       + "}CHARGE_INFO\n";
            }
        } catch (SQLException ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch (Exception ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;
    }

    /**
     * search Dbl Edi Ntc
     * 
     * @author KimYoungchul
     * @param dblEdiInVO
     * @return String
     * @exception DAOException 
     */
    public String searchDblEdiNtc(DblEdiInVO dblEdiInVO) throws DAOException {
        DBRowSet dbRowset = null;
        String result = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = dblEdiInVO.getColumnValues();
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExec = new SQLExecuter("DEFAULT");
            BLIssuanceDBDAOsearchDblEdiNtcRSQL template = new BLIssuanceDBDAOsearchDblEdiNtcRSQL();
            dbRowset = sqlExec.executeQuery(template, param, velParam);
            
            StringBuffer buf = new StringBuffer();
            while(dbRowset.next()){
            	buf.append(dbRowset.getString(1));
            } 

            if(buf.length() > 0){
            	result = buf.toString();
            }else{
                result = "{BKG_NOTICE\n"
                       + "PU_CY:\n"
                       + "PU_CYNAME:\n"
                       + "PU_CYADDR1:\n"
                       + "PU_CYADDR2:\n"
                       + "PU_CYADDR3:\n"
                       + "PU_CYADDR4:\n"
                       + "PU_CYADDR5:\n"
                       + "PU_CYPOST:\n"
                       + "PU_CYTEL:\n"
                       + "PU_CYFAX:\n"
                       + "}BKG_NOTICE\n";
            }
        } catch (SQLException ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch (Exception ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;
    }

    /**
     * search Dbl Edi Ams Info
     * 
     * @author KimYoungchul
     * @param dblEdiInVO
     * @return String
     * @exception DAOException 
     */
    public String searchDblEdiAmsInfo(DblEdiInVO dblEdiInVO) throws DAOException {
        DBRowSet dbRowset = null;
        String result = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = dblEdiInVO.getColumnValues();
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExec = new SQLExecuter("DEFAULT");
            BLIssuanceDBDAOsearchDblEdiAmsInfoRSQL template = new BLIssuanceDBDAOsearchDblEdiAmsInfoRSQL();
            dbRowset = sqlExec.executeQuery(template, param, velParam);
            
            StringBuffer buf = new StringBuffer();
            while(dbRowset.next()){
            	buf.append(dbRowset.getString(1));
            } 

            if(buf.length() > 0){
            	result = buf.toString();
            }else{
                result = "{AMS_INFO\n"
                       + "HOUSE_BL_NO:\n"
                       + "HOUSE_SR_NO:\n"
                       + "AMS_FILE_NO:\n"
                       + "}AMS_INFO\n";
            }
        } catch (SQLException ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch (Exception ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;
    }

    /**
     * BL ISS 정보 UPDATE
     * 
     * @param BkgBlIssVO bkgBlIssVO
     * @exception DAOException
     */
    public void modifyIbDtlBlIss(BkgBlIssVO bkgBlIssVO) throws DAOException {

        try {
            // query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            // velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();
            Map<String, String> mapVO = bkgBlIssVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            sqlExe.executeUpdate((ISQLTemplate) new BLIssuanceDBDAOmodifyIbDtlBlIssUSQL(), param, velParam);

        } catch(SQLException se) {
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }
    
	/**
	 * BKG_BL_ISS테이블  OBL_RLSE_FLG 관련 정보를 관리한다.<br>
	 * ESM_BKG_0743	연동 System	
	 * 
	 * @param BlIssInfoVO blIssInfoVO
	 * @exception DAOException
	 */
	public void modifyOBLRlseFlg(BlIssInfoVO blIssInfoVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {
			Map<String, String> mapVO = blIssInfoVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			
			result = sqlExe.executeUpdate((ISQLTemplate) new BLIssuanceDBDAOmodifyOBLRlseFlgUSQL(), param, velParam);
			
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}    
	
	/**
	 * searchVesselNameByBkgNo<br>
	 * 이메일 제목에 vesselName 표시
	 *
	 * @param String bkgNo
	 * @return String
	 * @exception DAOException
	 */
	public String searchVesselNameByBkgNo(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		String strResult = "";
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			param.put("bkg_no", bkgNo);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BLIssuanceDBDAOsearchVesselNameByBkgNoRSQL(), param, velParam);
	    	if(dbRowset.next()) {
	    		strResult = dbRowset.getString("VSL_NM");
	    	}
		} catch (SQLException ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return strResult;
	}
	/**
     * BKG_BL_ISS_HIS를 BKG_BL_ISS 에 update함
     * @author Ryu Dae Young
     * @param  BkgBlNoVO bkgBlNoVO
     * @param  String copyTypeCd
     * @exception DAOException
     */
	public void modifyIssCa(BkgBlNoVO bkgBlNoVO, String copyTypeCd) throws DAOException {
		Map<String, Object> param    = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {			
			if(bkgBlNoVO != null){
				Map<String, String> mapVO = bkgBlNoVO.getColumnValues();
				param.putAll(mapVO);
				param.put   ("copy_type_cd", copyTypeCd);
				velParam.putAll(mapVO);
				velParam.put("copy_type_cd", copyTypeCd);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new BLIssuanceDBDAOModifyBlIssCAUSQL(), param, velParam);
			if(updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");

		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * BKG_BOOKING 을 조회한다.(ESM_BKG_0418)<br>
	 * 
	 * @param String bkgBlNo
	 * @return BkgBookingVO
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public BkgBookingVO searchBkgBookingByBkgBlNo(String bkgBlNo) throws DAOException {
		DBRowSet dbRowset = null;
		BkgBookingVO rsVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			param.put("bkg_bl_no", bkgBlNo);
			velParam.put("bkg_bl_no", bkgBlNo);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BLIssuanceDBDAOsearchBkgBookingByBkgBlNoRSQL(), param, velParam);
			List<BkgBookingVO> list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgBookingVO .class);
			if(list.size() > 0){
                rsVO = list.get(0);
            }else{
            	rsVO = new BkgBookingVO();
            }
		}catch(SQLException ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return rsVO;
	}
	/**
	 * searchBlStatus 상태값을 조회한다.(ESM_BKG_0079_09)<br>
	 * @author 	LEE JIN SEO
	 * @param 	String bkgNo
	 * @return 	List<AuthCustVO>
	 * @exception 	DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<AuthCustVO> searchCustInfo(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<AuthCustVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			param.put("bkg_no", bkgNo);
			velParam.put("bkg_no", bkgNo);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BLIssuanceDBDAOsearchCustInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AuthCustVO .class);
			
		}catch(SQLException ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}catch(Exception ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * BKG_BL_ISS의 BL_PRF_SHPR_FLG 상태값을 UPDATE한다.(ESM_BKG_0228)<br>
	 * @param 	BlIssInfoVO blIssInfoVO
	 * @exception 	DAOException
	 */
	public void modifyBlIssByBkgNo(BlIssInfoVO blIssInfoVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			Map<String, String> mapVO = blIssInfoVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			sqlExe.executeUpdate((ISQLTemplate)new BLIssuanceDBDAOModifyBlIssByBkgNoUSQL(), param, velParam);
			
		}catch(SQLException ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}catch(Exception ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	
	
	/**
	 * FREIGHT RECEIVE값을 조회한다.(ESM_BKG_0079_09)<br>
	 * @author 	KIM TAE KYUN
	 * @param 	String bkgNo
	 * @param 	String blNo
	 * @return 	OtsRcvInfoVO
	 * @exception 	DAOException
	 */
	 @SuppressWarnings("unchecked")
	public OtsRcvInfoVO searchFreightReceiveByBkgNo(String bkgNo, String blNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<OtsRcvInfoVO> list = null;
		OtsRcvInfoVO otsRcvInfoVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			param.put("bkg_no", bkgNo);
			param.put("bl_no", blNo);
			velParam.put("bkg_no", bkgNo);
			velParam.put("bl_no", blNo);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BLIssuanceDBDAOSearchFreightReceiveByBkgNoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, OtsRcvInfoVO .class);
			if(list != null && list.size() > 0){
				otsRcvInfoVO = list.get(0);
			}
		}catch(SQLException ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}catch(Exception ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return otsRcvInfoVO;
	}	
	 

	/**
	 * @author Jong-ho Kim
	 * @param BkgWebService004VO webVo
	 * @exception DAOException
	 */			
	public void modifyIntAuth(BkgWebService004VO webVo)throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		DBRowSet blRs = null;
		int blCheck = 0;

		try {
			Map<String, String> mapVO = webVo.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			int result = 0;
			
			SQLExecuter sqlExe = new SQLExecuter("");
			
			blRs = sqlExe.executeQuery(new BLIssuanceDBDAOModifyIntAuthRSQL(), param, velParam);
			if (blRs.next()) blCheck = blRs.getInt("chk");
			if (1 == blCheck) { //BKG_INET_BL_PRN_AUTH 에 해당 B/L이 있을 경우 업데이트
				result = sqlExe.executeUpdate((ISQLTemplate)new BLIssuanceDBDAOModifyIntAuthUSQL(), param, velParam);
			}else{ // 없을 경우 신규 추가
				result = sqlExe.executeUpdate((ISQLTemplate)new BLIssuanceDBDAOModifyIntAuthCSQL(), param, velParam);				

				if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}			
	}
	
	/**
	 * @author Jong-ho Kim
	 * @param BkgWebService004VO webVo
	 * @exception DAOException
	 */			
	public void modifyIntWblAuth(BkgWebService004VO webVo)throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = webVo.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			int result = 0;
			
			SQLExecuter sqlExe = new SQLExecuter("");
			
			result = sqlExe.executeUpdate((ISQLTemplate)new BLIssuanceDBDAOModifyIntWblAuthUSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}			
	}
	
	/**
	 * @author Jong-ho Kim
	 * @param BkgWebService004VO webVo
	 * @exception DAOException
	 */			
	public void modifyIntWblPrnAuth(BkgWebService004VO webVo)throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = webVo.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			int result = 0;
			
			SQLExecuter sqlExe = new SQLExecuter("");
			
			result = sqlExe.executeUpdate((ISQLTemplate)new BLIssuanceDBDAOModifyIntWblAuthCSQL(), param, velParam);	
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}			
	}

	
	/**
	 * BKG_BL_ISS테이블  WBL_PRN_FLG 관련 정보를 관리한다.<br>
	 * ESM_BKG_0743	연동 System	
	 * 
	 * @param BlIssInfoVO blIssInfoVO
	 * @exception DAOException
	 */
	public void modifyWaybillFlg(BlIssInfoVO blIssInfoVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {
			Map<String, String> mapVO = blIssInfoVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			
			result = sqlExe.executeUpdate((ISQLTemplate) new BLIssuanceDBDAOModifyWaybillFlgUSQL(), param, velParam);
			
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	/**
     * search Dbl Edi Ref Info
     * 
     * @author 
     * @param dblEdiInVO
     * @return String
     * @exception DAOException 
     */
    public String searchDblEdiRefInfo(DblEdiInVO dblEdiInVO) throws DAOException {
        DBRowSet dbRowset = null;
        String result = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = dblEdiInVO.getColumnValues();
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExec = new SQLExecuter("DEFAULT");
            BLIssuanceDBDAOsearchDblEdiRefInfoRSQL template = new BLIssuanceDBDAOsearchDblEdiRefInfoRSQL();
            dbRowset = sqlExec.executeQuery(template, param, velParam);
            
            StringBuffer buf = new StringBuffer();
            while(dbRowset.next()){
            	buf.append(dbRowset.getString(1));
            } 

            if(buf.length() > 0){
            	result = buf.toString();
            }else{
                result = "{I_BKG_REF\n"
                       + "IB_REF_CD:\n"
                       + "IB_REF_DESC:\n"
                       + "IB_REF_NO:\n"
                       + "}I_BKG_REF\n";
            }
        } catch (SQLException ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch (Exception ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;
    }
    
    /**
     * search Dbl Edi BlClause Info
     * 
     * @author KimYoungchul
     * @param dblEdiInVO
     * @return String
     * @exception DAOException 
     */
    public String searchDblEdiBlClauseInfo(DblEdiInVO dblEdiInVO) throws DAOException {
        DBRowSet dbRowset = null;
        String result = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = dblEdiInVO.getColumnValues();
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExec = new SQLExecuter("DEFAULT");
            BLIssuanceDBDAOsearchDblEdiBlClauseInfoRSQL template = new BLIssuanceDBDAOsearchDblEdiBlClauseInfoRSQL();
            dbRowset = sqlExec.executeQuery(template, param, velParam);
            
            StringBuffer buf = new StringBuffer();
            while(dbRowset.next()){
            	buf.append(dbRowset.getString(1));
            } 

            if(buf.length() > 0){
            	result = buf.toString();
            }else{
                result = "{I_BL_CLAUSE\n"
                       + "IB_BL_CLAUSE_DESC:\n"
                       + "IB_BL_CLAUSE_CD:\n"
                       + "}I_BL_CLAUSE\n";
            }
        } catch (SQLException ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch (Exception ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;
    }
	
	/**
	 * Booking BL Complete Info 정보를 조회한다.(ESM_BKG_0079_09)<br>
	 *
	 * @author Maeda
	 * @param String bkgNo
	 * @return EmlBkgInfoVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public EmlBkgInfoVO searchEmlBkgInfo(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		EmlBkgInfoVO emlBkgInfoVO = null;
		List<EmlBkgInfoVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgNo != null){
				param.put("bkg_no", bkgNo);
				velParam.put("bkg_no", bkgNo);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BLIssuanceDBDAOEmlBkgInfoVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, EmlBkgInfoVO.class);
			if (list != null && list.size() > 0) {
				emlBkgInfoVO = list.get(0);
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return emlBkgInfoVO;
	}

	/**
	 * Booking BL Complete Info 정보를 조회한다.(ESM_BKG_0079_09)<br>
	 *
	 * @author Maeda
	 * @param SearchBlNtcHisVO paramSearchNtcHisVO
	 * @return SearchBlNtcHisVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public SearchBlNtcHisVO searchBlNtcHis(SearchBlNtcHisVO paramSearchNtcHisVO) throws DAOException {
		DBRowSet dbRowset = null;
		SearchBlNtcHisVO searchBlNtcHisVO = null;
		List<SearchBlNtcHisVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = paramSearchNtcHisVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BLIssuanceDBDAOSearchBlNtcHisRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchBlNtcHisVO.class);
			if (list != null && list.size() > 0) {
				searchBlNtcHisVO = list.get(0);
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return searchBlNtcHisVO;
	}
	
	/**
	 * Booking BL Complete Info 정보를 조회한다.(ESM_BKG_0079_09)<br>
	 *
	 * @author Maeda
	 * @param SearchRcvEmlVO rcvEmlVO
	 * @return List<SearchRcvEmlVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchRcvEmlVO> searchRcvEml(SearchRcvEmlVO rcvEmlVO) throws DAOException {
		DBRowSet dbRowset = null;
//		SearchRcvEmlVO searchRcvEmlVO = null;
		List<SearchRcvEmlVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = rcvEmlVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BLIssuanceDBDAOSearchRcvEmlVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchRcvEmlVO.class);
//			if (list != null && list.size() > 0) {
//				searchRcvEmlVO = list.get(0);
//			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
//		return searchRcvEmlVO;
		return list;
	}
	
	/**
     * searchInvInfo
     * 
     * @author 
     * @param dblEdiInVO
     * @return String
     * @exception DAOException 
     */
    public String searchInvInfo(DblEdiInVO dblEdiInVO) throws DAOException {
        DBRowSet dbRowset = null;
        String result = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = dblEdiInVO.getColumnValues();
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExec = new SQLExecuter("DEFAULT");
            BLIssuanceDBDAOSearchInvoiceBlMainRSQL template = new BLIssuanceDBDAOSearchInvoiceBlMainRSQL();
            dbRowset = sqlExec.executeQuery(template, param, velParam);
            StringBuffer buf = new StringBuffer();
            while(dbRowset.next()){
            	buf.append(dbRowset.getString(1));
            } 

            if(buf.length() > 0){
            	result = buf.toString();
            }else{
                result = "INV_NO:\n"
                       + "ORG_INV_NO:\n"
                       + "INV_DT:\n"
                       + "INV_TP:\n"
                       + "INV_STATUS:\n"
                       + "BL_NO:\n"
                       + "INV_STATUS:\n"
                       + "POR_TRAFFIC_MD:\n"
                       + "POD_TRAFFIC_MD:\n"
                       + "PAY_DUE_DT:\n"
                       + "SAILING_ARR_DT:\n"
                       + "INV_CURR:\n"
                       + "INV_CURR_TTL:\n"
                       + "LOCAL_CURR:\n"
                       + "LOCAL_CURR_TTL:\n"
                       + "INV_EX_RATE:\n"
                       + "INV_PAYTERM_CLUS:\n"
                       + "REMARK:\n"
                       + "APP_DT:\n";
            }
        } catch (SQLException ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch (Exception ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;
    }
    
    /**
     * searchInvRefInfo
     * 
     * @author 
     * @param dblEdiInVO
     * @return String
     * @exception DAOException 
     */
    public String searchInvRefInfo(DblEdiInVO dblEdiInVO) throws DAOException {
        DBRowSet dbRowset = null;
        String result = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = dblEdiInVO.getColumnValues();
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExec = new SQLExecuter("DEFAULT");
            BLIssuanceDBDAOSearchRefNoRSQL template = new BLIssuanceDBDAOSearchRefNoRSQL();
            dbRowset = sqlExec.executeQuery(template, param, velParam);
            StringBuffer buf = new StringBuffer();
            while(dbRowset.next()){
            	buf.append(dbRowset.getString(1));
            } 

            if(buf.length() > 0){
            	result = buf.toString();
            }else{
                result = "{REF_INFO\n"
                       + "REF_TP_CD:\n"
                       + "REF_NO:\n"
                       + "}REF_INFO\n";
            }
        } catch (SQLException ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch (Exception ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;
    }
    
    /**
     * search Dbl Edi Container
     * 
     * @author KimYoungchul
     * @param dblEdiInVO
     * @return List<DblEdiCntrVO>
     * @exception DAOException 
     */
    @SuppressWarnings("unchecked")
    public List<DblEdiCntrVO> searchInvoiceEdiCntr(DblEdiInVO dblEdiInVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<DblEdiCntrVO> list = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = dblEdiInVO.getColumnValues();
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExec = new SQLExecuter("DEFAULT");
            BLIssuanceDBDAOSearchInvoiceEdiCntrRSQL template = new BLIssuanceDBDAOSearchInvoiceEdiCntrRSQL();
            dbRowset = sqlExec.executeQuery(template, param, velParam);
            
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, DblEdiCntrVO.class);

        } catch (SQLException ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch (Exception ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
    }
    
    /**
     * search Dbl Edi Cntr Seal No.
     * 
     * @author 
     * @param dblEdiInVO
     * @param cntrNo
     * @return String
     * @exception DAOException 
     */
    public String searchInvoiceEdiCntrSeal(DblEdiInVO dblEdiInVO, String cntrNo) throws DAOException {
        DBRowSet dbRowset = null;
        String result = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = dblEdiInVO.getColumnValues();
            mapVO.put("cntr_no", cntrNo);
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExec = new SQLExecuter("DEFAULT");
            BLIssuanceDBDAOSearchInvoiceEdiCntrSealRSQL template = new BLIssuanceDBDAOSearchInvoiceEdiCntrSealRSQL();
            dbRowset = sqlExec.executeQuery(template, param, velParam);
            
            StringBuffer buf = new StringBuffer();
            while(dbRowset.next()){
            	buf.append(dbRowset.getString(1));
            } 

            if(buf.length() > 0){
            	result = buf.toString();
            }else{
                result = "{SEAL_INFO\n"
                       + "SEAL_PT_CD:\n"
                       + "SEAL_NO:\n"
                       + "}SEAL_INFO\n";
            }
        } catch (SQLException ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch (Exception ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;
    }
    
    /**
     * search Dbl Edi Cntr Seal No.
     * 
     * @author 
     * @param dblEdiInVO
     * @param cntrNo
     * @return String
     * @exception DAOException 
     */
    public String searchInvoiceEdiCntrChgInfo(DblEdiInVO dblEdiInVO, String cntrNo) throws DAOException {
        DBRowSet dbRowset = null;
        String result = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = dblEdiInVO.getColumnValues();
            mapVO.put("cntr_no", cntrNo);
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExec = new SQLExecuter("DEFAULT");
            BLIssuanceDBDAOSearchInvoiceEdiCntrChgInfoRSQL template = new BLIssuanceDBDAOSearchInvoiceEdiCntrChgInfoRSQL();
            dbRowset = sqlExec.executeQuery(template, param, velParam);
            
            StringBuffer buf = new StringBuffer();
            while(dbRowset.next()){
            	buf.append(dbRowset.getString(1));
            } 

            if(buf.length() > 0){
            	result = buf.toString();
            }else{
                result = "{CNTR_CHARGE_INFO\n"
                       + "CHARGE_CD:\n"
                       + "CHARGE_DESC:\n"
                       + "CHARGE_TP_NM:\n"
                       + "CHARGE_CURR:\n"
                       + "CHARGE_AMT:\n"
                       + "CHARGE_AMT_USD:\n"
                       + "INV_CURR:\n"
                       + "INV_CURR_AMT:\n"
                       + "INV_TAX:\n"
                       + "INV_CURR_TTL_AMT:\n"
                       + "LOCAL_CURR:\n"
                       + "LOCAL_CURR_AMT:\n"
                       + "LOCAL_TAX:\n"
                       + "LOCAL_CURR_TTL_AMT:\n"
                       + "FRT_IND:\n"
                       + "RATED_AS:\n"
                       + "RATE:\n"
                       + "INV_EX_RATE:\n"
                       + "TAX_RATE:\n"
                       + "PERTYPE:\n"
                       + "TARIFF:\n"
                       + "}CNTR_CHARGE_INFO\n";
            }
        } catch (SQLException ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch (Exception ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;
    }
    
    /**
     * search Dbl Edi Cntr Mf_desc
     * 
     * @author KimYoungchul
     * @param dblEdiInVO
     * @param cntrNo
     * @return String
     * @exception DAOException 
     */
    public String searchInvoiceEdiCntrMf(DblEdiInVO dblEdiInVO, String cntrNo) throws DAOException {
        DBRowSet dbRowset = null;
        String result = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = dblEdiInVO.getColumnValues();
            mapVO.put("cntr_no", cntrNo);
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExec = new SQLExecuter("DEFAULT");
            BLIssuanceDBDAOSearchInvoiceEdiCntrMfRSQL template = new BLIssuanceDBDAOSearchInvoiceEdiCntrMfRSQL();
            dbRowset = sqlExec.executeQuery(template, param, velParam);
            
            StringBuffer buf = new StringBuffer();
            while(dbRowset.next()){
            	buf.append(dbRowset.getString(1));
            } 

            if(buf.length() > 0){
            	result = buf.toString();
            }else{
                result = "{CM_INFO\n"
                        + "CMD_CD:\n"
	                    + "CMD_DESC:\n"
	                    + "{PKG_INFO\n"
	                    + "CM_PKG_LVL:\n"
	                    + "CM_PKG_QTY:\n"
	                    + "CM_PKG_UNIT:\n"
	                    + "CM_PKG_UNIT_DESC:\n"
	                    + "}PKG_INFO\n"
	                    + "{MEA_INFO\n"
	                    + "CM_MEA_TP_CD:\n"	                    
	                    + "CM_MEA_UNIT:\n"
	                    + "CM_MEA_QTY:\n"
	                    + "}MEA_INFO\n"
	                    + "}CM_INFO\n";
            }
        } catch (SQLException ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch (Exception ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;
    }
    
    /**
     * searchInvoiceVslInfo
     * 
     * @author 
     * @param dblEdiInVO
     * @return String
     * @exception DAOException 
     */
    public String searchInvoiceVslInfo(DblEdiInVO dblEdiInVO) throws DAOException {
        DBRowSet dbRowset = null;
        String result = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = dblEdiInVO.getColumnValues();
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExec = new SQLExecuter("DEFAULT");
            BLIssuanceDBDAOSearchInvoiceEdiVslInfoRSQL template = new BLIssuanceDBDAOSearchInvoiceEdiVslInfoRSQL();
            dbRowset = sqlExec.executeQuery(template, param, velParam);
            StringBuffer buf = new StringBuffer();
            while(dbRowset.next()){
            	buf.append(dbRowset.getString(1));
            } 

            if(buf.length() > 0){
            	result = buf.toString();
            }else{
                result = "{VSL_INFO\n"
                       + "VSL_NM:\n"
                       + "VSL_CD:\n"
                       + "VSL_VOY_NO:\n"
                       + "EX_VOY_REF:\n"
                       + "VSL_LOYD_CD:\n"
                       + "}VSL_INFO\n";
            }
        } catch (SQLException ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch (Exception ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;
    }
    
    /**
     * searchInvoiceLocInfo
     * 
     * @author 
     * @param dblEdiInVO
     * @return String
     * @exception DAOException 
     */
    public String searchInvoiceLocInfo(DblEdiInVO dblEdiInVO) throws DAOException {
        DBRowSet dbRowset = null;
        String result = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = dblEdiInVO.getColumnValues();
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExec = new SQLExecuter("DEFAULT");
			BLIssuanceDBDAOSearchInvoiceEdiLocInfoRSQL template = new BLIssuanceDBDAOSearchInvoiceEdiLocInfoRSQL();
            dbRowset = sqlExec.executeQuery(template, param, velParam);
            StringBuffer buf = new StringBuffer();
            while(dbRowset.next()){
            	buf.append(dbRowset.getString(1));
            } 

            if(buf.length() > 0){
            	result = buf.toString();
            }else{
                result = "{LOC_INFO\n"
                       + "LOC_TP_CD:\n"
                       + "LOC_NM:\n"
                       + "LOC_CD:\n"
                       + "CITY:\n"
                       + "STATE:\n"
                       + "ZIP:\n"
                       + "CNT_CD:\n"
                       + "{LOC_DATE_INFO\n"
                       + "DATE_TP_CD:\n"
                       + "DATE:\n"
                       + "}LOC_DATE_INFO\n"
                       + "}LOC_INFO\n";
            }
        } catch (SQLException ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch (Exception ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;
    }
    
    /**
     * searchInvoiceCustInfo
     * 
     * @author 
     * @param dblEdiInVO
     * @return String
     * @exception DAOException 
     */
    public String searchInvoiceCustInfo(DblEdiInVO dblEdiInVO) throws DAOException {
        DBRowSet dbRowset = null;
        String result = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = dblEdiInVO.getColumnValues();
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExec = new SQLExecuter("DEFAULT");
            BLIssuanceDBDAOSearchInvoiceEdiCustInfoRSQL template = new BLIssuanceDBDAOSearchInvoiceEdiCustInfoRSQL();
            dbRowset = sqlExec.executeQuery(template, param, velParam);
            StringBuffer buf = new StringBuffer();
            while(dbRowset.next()){
            	buf.append(dbRowset.getString(1));
            } 

            if(buf.length() > 0){
            	result = buf.toString();
            }else{
                result = "{CUST_INFO\n"
                       + "CUST_TP_CD:\n"
                       + "CUST_NM:\n"
                       + "CUST_TAX_NO:\n"
                       + "CUST_BK_REMIT:\n"
                       + "CUST_ADDR1:\n"
                       + "CUST_ADDR2:\n"
                       + "CUST_ADDR3:\n"
                       + "CUST_ADDR4:\n"
                       + "CUST_ADDR5:\n"
                       + "CUST_CITY:\n"
                       + "CUST_STATE:\n"
                       + "CUST_ZIP:\n"
                       + "CUST_CNT_CD:\n"
                       + "{CONTACT_INFO\n"
                       + "CONTACT_NM:\n"
                       + "CONTACT_DEPT:\n"
                       + "CONTACT_EMAIL:\n"
                       + "CONTACT_FAX:\n"
                       + "CONTACT_TEL:\n"
                       + "}CONTACT_INFO\n"
                       + "{CUST_CD_INFO\n"
                       + "CUST_CD_TP_CD:\n"
                       + "CUST_CD:\n"
                       + "}CUST_CD_INFO\n"
                       + "{REGULATORY_INFO\n"
                       + "DUNS:\n"
                       + "}REGULATORY_INFO\n"
                       + "}CUST_INFO\n";
            }
        } catch (SQLException ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch (Exception ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;
    }
    
    /**
     * searchInvoiceChgInfo
     * 
     * @author 
     * @param dblEdiInVO
     * @return String
     * @exception DAOException 
     */
    public String searchInvoiceChgInfo(DblEdiInVO dblEdiInVO) throws DAOException {
        DBRowSet dbRowset = null;
        String result = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = dblEdiInVO.getColumnValues();
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExec = new SQLExecuter("DEFAULT");
            BLIssuanceDBDAOSearchInvoiceEdiChgInfoRSQL template = new BLIssuanceDBDAOSearchInvoiceEdiChgInfoRSQL();
            dbRowset = sqlExec.executeQuery(template, param, velParam);
            StringBuffer buf = new StringBuffer();
            while(dbRowset.next()){
            	buf.append(dbRowset.getString(1));
            } 

            if(buf.length() > 0){
            	result = buf.toString();
            }else{
                result = "{BL_CHARGE_INFO\n"
                       + "BL_CHARGE_CD:\n"
                       + "BL_CHARGE_DESC:\n"
                       + "BL_CHARGE_TP_NM:\n"
                       + "BL_CHARGE_CURR:\n"
                       + "BL_CHARGE_AMT:\n"
                       + "BL_CHARGE_AMT_USD:\n"
                       + "BL_INV_CURR:\n"
                       + "BL_INV_CURR_AMT:\n"
                       + "BL_INV_TAX:\n"
                       + "BL_INV_CURR_TTL_AMT:\n"
                       + "BL_LOCAL_CURR:\n"
                       + "BL_LOCAL_CURR_AMT:\n"
                       + "BL_LOCAL_TAX:\n"
                       + "BL_LOCAL_CURR_TTL_AMT:\n"
                       + "BL_FRT_IND:\n"
                       + "BL_RATED_AS:\n"
                       + "BL_RATE:\n"
                       + "BL_INV_EX_RATE:\n"
                       + "BL_TAX_RATE:\n"
                       + "BL_PERTYPE:\n"
                       + "BL_TARIFF:\n"
                       + "}BL_CHARGE_INFO\n";
            }
        } catch (SQLException ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch (Exception ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;
    }
    
    /**
     * search Dbl Edi cmdt
     * 
     * @author 
     * @param dblEdiInVO
     * @return String
     * @exception DAOException 
     */
    public String searchDblEdiCmdtInfo(DblEdiInVO dblEdiInVO) throws DAOException {
        DBRowSet dbRowset = null;
        String result = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = dblEdiInVO.getColumnValues();
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExec = new SQLExecuter("DEFAULT");
            BLIssuanceDBDAOsearchDblEdiCmdtInfoRSQL template = new BLIssuanceDBDAOsearchDblEdiCmdtInfoRSQL();
            dbRowset = sqlExec.executeQuery(template, param, velParam);
            
            StringBuffer buf = new StringBuffer();
            while(dbRowset.next()){
            	buf.append(dbRowset.getString(1));
            } 

            if(buf.length() > 0){
            	result = buf.toString();
            }else{
            	 result = "{CMDT_INFO\n"
                         + "CMDT_SEQ:\n"
                         + "CMDT_PKG_QTY:\n"
                         + "CMDT_PKG_CD:\n"
                         + "CMDT_PKG_CD_DESC:\n"
                         + "CMDT_WGT_QTY:\n"
                         + "CMDT_WGT_UNIT:\n"
                         + "CMDT_NET_WGT_QTY:\n"
                         + "CMDT_NET_WGT_UNIT:\n"
                         + "CMDT_MEA_QTY:\n"
                         + "CMDT_MEA_UNIT:\n"
                         + "CMDT_HTS_CD:\n"
                         + "CMDT_HS_CD:\n"
                         + "CMDT_NCM_CD:\n"
                         + "CMDT_DESC:\n"
                         + "CMDT_MARKNO:\n"
                         + "}CMDT_INFO\n";
            }
        } catch (SQLException ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch (Exception ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;
    }
    
	/**
	 * Booking BL Complete Info 정보를 조회한다.(ESM_BKG_0079_09)<br>
	 *
	 * @author Maeda
	 * @param String bkgNo
	 * @return List<SearchBlCompleteRcvEmlVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchBlCompleteRcvEmlVO> searchBlCompleteRcvEml(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
//		SearchRcvEmlVO searchRcvEmlVO = null;
		List<SearchBlCompleteRcvEmlVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			
			mapVO.put("bkg_no", bkgNo);

            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BLIssuanceDBDAOSearchBlCompleteRcvEmlVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchBlCompleteRcvEmlVO.class);
//			if (list != null && list.size() > 0) {
//				searchRcvEmlVO = list.get(0);
//			}
			
			if (list.size()==1){
				if(list.get(0).getUsrEml().equals("")){
					list = null;
				}
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
//		return searchRcvEmlVO;
		return list;
	}
	/**
	 * Booking BL Complete Info 정보를 조회한다.(ESM_BKG_0079_09)<br>
	 *
	 * @author Maeda
	 * @param String bkgNo
	 * @param String emlFlg
	 * @return List<SearchBlPrintRcvEmlVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchBlPrintRcvEmlVO> searchBlPrintRcvEml(String bkgNo, String emlFlg) throws DAOException {
		DBRowSet dbRowset = null;
//		SearchRcvEmlVO searchRcvEmlVO = null;
		List<SearchBlPrintRcvEmlVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			
			mapVO.put("bkg_no", bkgNo);
			mapVO.put("eml_flg", emlFlg);

            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BLIssuanceDBDAOSearchBlPrintRcvEmlVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchBlPrintRcvEmlVO.class);
//			if (list != null && list.size() > 0) {
//				searchRcvEmlVO = list.get(0);
//			}
			
			if (list.size()==1){
				if(list.get(0).getUsrEml().equals("")){
					list = null;
				}
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
//		return searchRcvEmlVO;
		return list;
	}
	
	/**
	 * bl remark 조회 (팝업)
	 * @param bkgNo
	 * @return
	 * @throws DAOException
	 */
	public String searchBlRemark(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		String strResult = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (bkgNo != null) {

				param.put("bkg_no", bkgNo);
				velParam.put("bkg_no", bkgNo);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BLIssuanceDBDDAOSearchBlRemakRSQL(), param, velParam);
	    	if(dbRowset.next()) {
	    		strResult = dbRowset.getString("OBL_ISS_RMK");
	    	}
		} catch (SQLException ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return strResult;
	}
	
    /**
     * search BL Clause Remark Info
     * 
     * @param String bkgNo
     * @return String
     * @exception DAOException 
     */
    public String searchBlClauseInfo(String bkgNo) throws DAOException {
        DBRowSet dbRowset = null;
        String result = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
        	param.put("bkg_no", bkgNo);
        	velParam.put("bkg_no", bkgNo);
            
            SQLExecuter sqlExec = new SQLExecuter("DEFAULT");
            BLIssuanceDBDAOSearchBlClauseInfoRSQL template = new BLIssuanceDBDAOSearchBlClauseInfoRSQL();
            dbRowset = sqlExec.executeQuery(template, param, velParam);
            
            StringBuffer buf = new StringBuffer();
            while(dbRowset.next()){
            	buf.append(dbRowset.getString("FF")).append("\n");
            }
            if(buf.length()>0){
                result=buf.substring(0,buf.length()-1).toString();
            }else{
                result=buf.toString();
            }
        } catch (SQLException ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch (Exception ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;
    }
    
    /**
     * B/L 타입을 조회 한다..<br>
     * @author 	
     * @param  	String bkgNo
     * @return 	String
     * @throws Exception
	 * @throws DAOException
     */
	public String searchBlTp(String bkgNo) throws DAOException {
	   	DBRowSet dbRowset = null;
		String rtn = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("bkg_no", bkgNo);
			velParam.put("bkg_no", bkgNo);

			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new BLIssuanceDBDAOSearchBlTpRSQL(), param, velParam);
			if (dbRowset.next()) {
				rtn = dbRowset.getString("RSLT");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return rtn;
	}
	
	/**
	 * Issue & Release Cancel 화면에서 Waybill 을 Cancel 하는 경우 BKG_BL_ISS 에 WBL_PRN_FLG 를 N 으로 변경<br>
	 * ESM_BKG_0649	연동 System	
	 * @param BlIssInfoVO blIssInfoVO
	 * @exception DAOException
	 */
	public void manageWayBillPrintFlag(BlIssInfoVO blIssInfoVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = blIssInfoVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
            SQLExecuter sqlExe = new SQLExecuter("");
            sqlExe.executeUpdate((ISQLTemplate) new BLIssuanceDBDAOManageWayBillPrintFlagUSQL(), param, velParam);

		} catch (SQLException ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}  
	
	
	/**
	 * Sea Waybill 출력시 BKG_INET_BL_PRN_AUTH 테이블에 저장할 데이터를 조회한다.(ESM_BKG_0743)<br>
	 * @param 	String bkgNo
	 * @return 	SeaWayBillPrintVO
	 * @exception 	DAOException
	 */
	public SeaWayBillPrintVO searchSeaWayBillPrint(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<SeaWayBillPrintVO> list = null;
		SeaWayBillPrintVO seaWayBillPrintVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			param.put("bkg_no", bkgNo);
			velParam.put("bkg_no", bkgNo);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BLIssuanceDBDAOSearchSeaWayBillPrintRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SeaWayBillPrintVO.class);
			if(list != null && list.size() > 0){
				seaWayBillPrintVO = list.get(0);
			}
		}catch(SQLException ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}catch(Exception ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return seaWayBillPrintVO;
	}	
	
	/**
	 * Sea Waybill 출력시 BKG_INET_BL_PRN_AUTH 에 저장한다.(ESM_BKG_0743)<br>
	 * @param SeaWayBillPrintVO seaWayBillPrintVO
	 * @exception DAOException
	 */
	public void addSeaWayBillPrint(SeaWayBillPrintVO seaWayBillPrintVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = seaWayBillPrintVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
            SQLExecuter sqlExe = new SQLExecuter("");
            sqlExe.executeUpdate((ISQLTemplate) new BLIssuanceDBDAOAddSeaWayBillPrintCSQL(), param, velParam);

		} catch (SQLException ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	} 	
	
	/**
	 * Sea Waybill 출력시 BKG_INET_BL_PRN_AUTH 에 이전 seq에 DELT_FLG 를 처리한다.(ESM_BKG_0743)<br>
	 * @param SeaWayBillPrintVO seaWayBillPrintVO
	 * @exception DAOException
	 */
	public void modifySeaWayBillPrint(SeaWayBillPrintVO seaWayBillPrintVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = seaWayBillPrintVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
            SQLExecuter sqlExe = new SQLExecuter("");
            sqlExe.executeUpdate((ISQLTemplate) new BLIssuanceDBDAOModifySeaWayBillPrintUSQL(), param, velParam);

		} catch (SQLException ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Booking BL 을 전송할 FTP 정보를 조회한다.(ESM_BKG_0079_09)<br>
	 *
	 * @param String bkgNo
	 * @param String ftpFlg
	 * @return List<BlPrintRcvFtpVO>
	 * @exception DAOException
	 */
	public List<BlPrintRcvFtpVO> searchBlPrintRcvFtp(String bkgNo, String ftpFlg) throws DAOException {
		DBRowSet dbRowset = null;
		List<BlPrintRcvFtpVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			
			mapVO.put("bkg_no", bkgNo);
			mapVO.put("ftp_flg", ftpFlg);

            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BLIssuanceDBDAOSearchBlPrintRcvFtpRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BlPrintRcvFtpVO.class);

		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}
	
	/**
	 * Booking BL 을 전송할 FTP 정보를 조회한다.(FTP Send)(ESM_BKG_0079_09)<br>
	 *
	 * @param String bkgNo
	 * @return List<BlPrintRcvFtpVO>
	 * @exception DAOException
	 */
	public List<BlPrintRcvFtpVO> searchBlPrintGrpRcvFtp(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<BlPrintRcvFtpVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			
			mapVO.put("bkg_no", bkgNo);

            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BLIssuanceDBDAOSearchBlPrintGrpRcvFtpRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BlPrintRcvFtpVO.class);

		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}	
	
	/**
	 * FTP , MRD 에 대한 RD_APPL_CD 조회(ESM_BKG_0079_09)<br>
	 *
	 * @param String mrdNm
	 * @return RdApplCdFtpVO
	 * @exception DAOException
	 */
	public RdApplCdFtpVO searchRdApplCdFtp(String mrdNm) throws DAOException {
		DBRowSet dbRowset = null;
		List<RdApplCdFtpVO> list = null;
		RdApplCdFtpVO rdApplCdFtpVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("mrd_nm", mrdNm);
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BLIssuanceDBDAOSearchRdApplCdFtpRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RdApplCdFtpVO.class);
			
			if(list.size()>0){
				rdApplCdFtpVO = list.get(0);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return rdApplCdFtpVO;
	}
	
	/**
     * search Dbl Edi Container
     * 
     * @author 
     * @param dblEdiInVO
     * @return List<DblEdiCmdtCntrVO>
     * @exception DAOException 
     */
    @SuppressWarnings("unchecked")
    public List<DblEdiCmdtCntrVO> searchDblEdiCmdt(DblEdiInVO dblEdiInVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<DblEdiCmdtCntrVO> list = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = dblEdiInVO.getColumnValues();
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExec = new SQLExecuter("DEFAULT");
            BLIssuanceDBDAOsearchDblEdiCmdtRSQL template = new BLIssuanceDBDAOsearchDblEdiCmdtRSQL();
            dbRowset = sqlExec.executeQuery(template, param, velParam);
            
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, DblEdiCmdtCntrVO.class);

        } catch (SQLException ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch (Exception ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
    }
    
    /**
     * search Dbl Edi cmdt
     * 
     * @author 
     * @param dblEdiCmdtCntrVO
     * @return String
     * @exception DAOException 
     */
    public String searchDblEdiCmdtHdr(DblEdiCmdtCntrVO dblEdiCmdtCntrVO) throws DAOException {
        DBRowSet dbRowset = null;
        String result = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = dblEdiCmdtCntrVO.getColumnValues();
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExec = new SQLExecuter("DEFAULT");
            BLIssuanceDBDAOsearchDblEdiCmdtHdrRSQL template = new BLIssuanceDBDAOsearchDblEdiCmdtHdrRSQL();
            dbRowset = sqlExec.executeQuery(template, param, velParam);
            
            StringBuffer buf = new StringBuffer();
            while(dbRowset.next()){
            	buf.append(dbRowset.getString(1));
            } 

            if(buf.length() > 0){
            	result = buf.toString();
            }else{
            	 result = "{CMDT_INFO\n"
                         + "CMDT_SEQ:\n"
                         + "CMDT_PKG_QTY:\n"
                         + "CMDT_PKG_CD:\n"
                         + "CMDT_PKG_CD_DESC:\n"
                         + "CMDT_WGT_QTY:\n"
                         + "CMDT_WGT_UNIT:\n"
                         + "CMDT_NET_WGT_QTY:\n"
                         + "CMDT_NET_WGT_UNIT:\n"
                         + "CMDT_MEA_QTY:\n"
                         + "CMDT_MEA_UNIT:\n"
                         + "CMDT_HTS_CD:\n"
                         + "CMDT_HS_CD:\n"
                         + "CMDT_NCM_CD:\n"
                         + "CMDT_DESC:\n"
                         + "CMDT_MARKNO:\n";
                         
            }
        } catch (SQLException ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch (Exception ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;
    }
    
    /**
     * search Dbl Edi cmdt
     * 
     * @author 
     * @param dblEdiCmdtCntrVO
     * @return String
     * @exception DAOException 
     */
    public String searchDblEdiCmdtDtl(DblEdiCmdtCntrVO dblEdiCmdtCntrVO) throws DAOException {
        DBRowSet dbRowset = null;
        String result = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = dblEdiCmdtCntrVO.getColumnValues();
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExec = new SQLExecuter("DEFAULT");
            BLIssuanceDBDAOsearchDblEdiCmdtDtlRSQL template = new BLIssuanceDBDAOsearchDblEdiCmdtDtlRSQL();
            dbRowset = sqlExec.executeQuery(template, param, velParam);
            
            StringBuffer buf = new StringBuffer();
            while(dbRowset.next()){
            	buf.append(dbRowset.getString(1));
            } 

            if(buf.length() > 0){
            	result = buf.toString();
            }else{
            	 result = "{CMDT_CNTRNBR\n"
                         + "CMDT_CNTRNBR:\n"
                         + "}CMDT_CNTRNBR\n";
                         
            }
        } catch (SQLException ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch (Exception ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;
    }

    /**
     * search BL Country Clause
     * 
     * @param String porCd
     * @param String polCd
     * @param String podCd
     * @param String delCd
     * @return String
     * @throws DAOException
     */
    public String searchBlCntClause(String porCd, String polCd, String podCd, String delCd) throws DAOException {
        DBRowSet dbRowset = null;
        String result = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
        	param.put("por_cnt_cd", porCd.substring(0, 2));
        	param.put("pol_cnt_cd", polCd.substring(0, 2));
        	param.put("pod_cnt_cd", podCd.substring(0, 2));
        	param.put("del_cnt_cd", delCd.substring(0, 2));
            
            SQLExecuter sqlExec = new SQLExecuter("DEFAULT");
            BLIssuanceDBDAOSearchBlCntClauseRSQL template = new BLIssuanceDBDAOSearchBlCntClauseRSQL();
            dbRowset = sqlExec.executeQuery(template, param, velParam);
            
            if(dbRowset.next()){
            	result = dbRowset.getString("CMDT_DESC");
            } 
        } catch (SQLException ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch (Exception ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;
    }
    
	/**
	 * Draft BL 전송을 위한 REMARK를 조회한다.
	 * 
	 * @param String bkgNo
	 * @return List<DblWblCntVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<DblWblVO> searchDblRemarkByBkgNo(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<DblWblVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			param.put("bkg_no", bkgNo);
			velParam.put("bkg_no", bkgNo);
			SQLExecuter sqlExec = new SQLExecuter("DEFAULT");
			BLIssuanceDBDAOSearchDblRemarkByBkgNoRSQL template = new BLIssuanceDBDAOSearchDblRemarkByBkgNoRSQL();
			dbRowset = sqlExec.executeQuery(template, param, velParam);
			
//			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BLIssuanceDBDAOSearchBlIssInfoRSQL(), param, velParam);
			
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, DblWblVO.class);
		} catch (SQLException ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}    

    /**
     * search Dbl Edi Container
     * 
     * @author 
     * @param dblEdiInVO
     * @return List<DblEdiBlClauseVO>
     * @exception DAOException 
     */
    @SuppressWarnings("unchecked")
    public List<DblEdiBlClauseVO> searchDblEdiBlClause(DblEdiInVO dblEdiInVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<DblEdiBlClauseVO> list = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = dblEdiInVO.getColumnValues();
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExec = new SQLExecuter("DEFAULT");
            BLIssuanceDBDAOSearchDblEdiRcvBlClauseRSQL template = new BLIssuanceDBDAOSearchDblEdiRcvBlClauseRSQL();
            dbRowset = sqlExec.executeQuery(template, param, velParam);
            
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, DblEdiBlClauseVO.class);

        } catch (SQLException ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch (Exception ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
    }
    
    /**
     * search Dbl Edi Chg 
     * 
     * @author KimYoungchul
     * @param dblEdiInVO
     * @return String
     * @exception DAOException 
     */
    public String searchDblEdiChgExch(DblEdiInVO dblEdiInVO) throws DAOException {
        DBRowSet dbRowset = null;
        String result = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = dblEdiInVO.getColumnValues();
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExec = new SQLExecuter("DEFAULT");
            BLIssuanceDBDAOSearchDblEdiChgExchRSQL template = new BLIssuanceDBDAOSearchDblEdiChgExchRSQL();
            dbRowset = sqlExec.executeQuery(template, param, velParam);
            
            StringBuffer buf = new StringBuffer();
            while(dbRowset.next()){
            	buf.append(dbRowset.getString(1));
//            	buf.append('\n');
            } 

            if(buf.length() > 0){
            	result = buf.toString();
            }else{           
                result = "{CHARGE\n"
                       + "FCTYPE:\n"
                       + "RATE:\n"
                       + "RATED_AS:\n"
                       + "REVENUETON:\n"
                       + "DIF_AMT:\n"
                       + "PPD:\n"
                       + "CCT:\n"
                       + "CURRENCYCODE:\n"
                       + "TARIFF:\n"
                       + "PERTYPE:\n"
                       + "EXRATE:\n"
                       + "FRT_IND:\n"
                       + "}CHARGE\n";
            }
        } catch (SQLException ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch (Exception ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;
    }
    
    /**
     * Original Bill download 할때 insert BKG_INET_BL_PRN_AUTH
     * @param String bkgNo
     * @param String blNo
     * @param SignOnUserAccount account
     * @return int
     * @exception DAOException
     */
    public int addInetBlPrnAuth(String bkgNo,String blNo, SignOnUserAccount account) throws DAOException{

        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        int result = 0;

        try{
        	param.put("bkg_no", bkgNo);
        	param.put("bl_no", blNo);
        	param.put("ofc_cd", account.getOfc_cd());
        	param.put("usr_id", account.getUsr_id());

            result = new SQLExecuter("").executeUpdate((ISQLTemplate)new BLIssuanceDBDAOAddInetBlPrnAuthCSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to insert SQL");

        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;

    }   
    
    /**
     * BKG_INET_BL_PRN_AUTH의 bkg별 max info seq 조회(벌룬 파라메터용) 
     * 
     * @param String bkgNo
     * @return int
     * @exception DAOException 
     */
    public int searchMaxInfoSeq(String bkgNo) throws DAOException {
        DBRowSet dbRowset = null;
        int result = 0;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            param.put("bkg_no", bkgNo);
            SQLExecuter sqlExec = new SQLExecuter("DEFAULT");
            BLIssuanceDBDAOSearchMaxInfoSeqRSQL template = new BLIssuanceDBDAOSearchMaxInfoSeqRSQL();
            dbRowset = sqlExec.executeQuery(template, param, velParam);
            
            while(dbRowset.next()){
            	result = dbRowset.getInt(1);
            } 
        } catch (SQLException ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch (Exception ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;
    }
    
    /**
     * Original Bill download 할때 먼저 delete flag 처리 BKG_INET_BL_PRN_AUTH
     * @param String bkgNo
     * @param SignOnUserAccount account
     * @exception DAOException
     */
    public void deleteBlPrnAuth(String bkgNo, SignOnUserAccount account) throws DAOException{

        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        int result = 0;

        try{
        	param.put("bkg_no", bkgNo);
        	param.put("ofc_cd", account.getOfc_cd());
        	param.put("usr_id", account.getUsr_id());

            result = new SQLExecuter("").executeUpdate((ISQLTemplate)new BLIssuanceDBDAODeleteBlPrnAuthUSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to delete SQL");
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }

    }   
    
    /**
     * file download key값을 저장 BKG_INET_BL_PRN_AUTH
     * @param String bkgNo
     * @param String fileSavId
     * @param String infoSeq
     * @param SignOnUserAccount account
     * @exception DAOException
     */
    public void modifyFileSavId(String bkgNo, String fileSavId, String infoSeq, SignOnUserAccount account) throws DAOException{

        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        int result = 0;

        try{
        	param.put("bkg_no", bkgNo);
        	param.put("file_sav_id", fileSavId);
        	param.put("info_seq", infoSeq);
        	param.put("usr_id", account.getUsr_id());

            result = new SQLExecuter("").executeUpdate((ISQLTemplate)new BLIssuanceDBDAOModifyFileSavIdInetBlPrnAuthUSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to update SQL");
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }

    }      
}