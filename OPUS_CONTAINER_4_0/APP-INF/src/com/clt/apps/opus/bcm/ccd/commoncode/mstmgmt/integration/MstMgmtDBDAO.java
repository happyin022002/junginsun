/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : MstMgmtDBDAO.java
*@FileTitle : BCM_CCD_2001
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.03
*@LastModifier : 
*@LastVersion : 1.0
* 2012.04.03 황효근
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.bcm.ccd.commoncode.mstmgmt.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.bcm.ccd.commoncode.mstmgmt.basic.MstMgmtBCImpl;
import com.clt.apps.opus.bcm.ccd.commoncode.mstmgmt.vo.MdmDatProcVO;
import com.clt.apps.opus.bcm.ccd.commoncode.mstmgmt.vo.MdmUsrAuthVO;
import com.clt.apps.opus.bcm.ccd.commoncode.mstmgmt.vo.SearchMdmHistoryListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

 
/**
 * OPUS MstMgmtDBDAO <br>
 * - OPUS-CommonCode system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author 
 * @see MstMgmtBCImpl 참조
 * @since J2EE 1.6
 */
public class MstMgmtDBDAO extends DBDAOSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7895768484510185646L;

	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param MdmUsrAuthVO mdmUsrAuthVO
	 * @return List<MdmUsrAuthVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<MdmUsrAuthVO> searchMdmUsrAuthList(MdmUsrAuthVO mdmUsrAuthVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MdmUsrAuthVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(mdmUsrAuthVO != null){
				Map<String, String> mapVO = mdmUsrAuthVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MstMgmtDBDAOSearchMdmUsrAuthVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MdmUsrAuthVO .class);
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
	  * 
	  * @param List<MdmUsrAuthVO> mdmUsrAuthVOList
	  * @throws DAOException
	  * @throws Exception
	  */
	public void addMdmUsrAuth(List<MdmUsrAuthVO> mdmUsrAuthVOList) throws DAOException,Exception {
		try {
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(mdmUsrAuthVOList.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new MstMgmtDBDAOAddMdmUsrAuthVOCSQL(), mdmUsrAuthVOList, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No "+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			
			if(se.getErrorCode() == 1) {
				throw new DAOException(new ErrorHandler("COM12226", new String[]{"Master Authority Data"}).getMessage(), se);
			} else {
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			}
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	 
	/**
	 * 
	 * @param mdmUsrAuthVOList
	 * @throws DAOException
	 * @throws Exception
	 */
	public void modifyMdmUsrAuth(List<MdmUsrAuthVO> mdmUsrAuthVOList) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(mdmUsrAuthVOList.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new MstMgmtDBDAOModifyMdmUsrAuthVOUSQL(), mdmUsrAuthVOList, null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to modify No "+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	} 
	
	/**
	 * 
	 * @param mdmUsrAuthVOList
	 * @throws DAOException
	 * @throws Exception
	 */
	public void removeMdmUsrAuth(List<MdmUsrAuthVO> mdmUsrAuthVOList) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(mdmUsrAuthVOList.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new MstMgmtDBDAORemoveMdmUsrAuthVODSQL(), mdmUsrAuthVOList, null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to remove No "+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	
	/**
	 * CNT_CD 별 CUST_MAX_SEQ 정보를 조회한다.
	 * 
	 * @param String cntCd
	 * @return String
	 * @throws DAOException	
	 */
	public String searchCustMaxSeq(String cntCd) throws DAOException {
		DBRowSet dbRowset = null;
		String result = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("cnt_cd", cntCd);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MstMgmtDBDAOSearchCustMaxSeqRSQL(), param, null);
			if(dbRowset.next()) {
				result = dbRowset.getString(1);
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
	 * CNT_CD 별 CUST_MAX_SEQ 정보를 추가한다.
	 * 
	 * @param String cntCd
	 * @param SignOnUserAccount account
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addCustMaxSeq(String cntCd, SignOnUserAccount account) throws DAOException, Exception {
		//query parameter ,String usrId
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();
		//parameter Setting
		
		int result = 0;
		try {
			param.put("cnt_cd", cntCd);
			param.put("usr_id", account.getUsr_id());
			param.put("ofc_cd", account.getOfc_cd());
			
			result = new SQLExecuter("").executeUpdate((ISQLTemplate)new MstMgmtDBDAOAddCustMaxSeqCSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED){
				throw new DAOException("Fail to insert SQL");		
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * CNT_CD 별 CUST_MAX_SEQ 정보를 수정한다.
	 * 
	 * @param String cntCd
	 * @param SignOnUserAccount account
	 * @throws DAOException
	 * @throws Exception
	 */
	public void modifyCustMaxSeq(String cntCd, SignOnUserAccount account) throws DAOException, Exception {
		//query parameter ,String usrId
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();
		//parameter Setting
		
		int result = 0;
		try {
			param.put("cnt_cd", cntCd);
			param.put("upd_usr_id", account.getUsr_id());
			param.put("ofc_cd", account.getOfc_cd());
			
			result = new SQLExecuter("").executeUpdate((ISQLTemplate)new MstMgmtDBDAOModifyCustMaxSeqUSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED){
				throw new DAOException("Fail to insert SQL");		
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	 
	 
	/**
	 * 
	 * @param mdmDatProcVO
	 * @return List<MdmDatProcVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<MdmDatProcVO> searchMdmDatProcRequestList(MdmDatProcVO mdmDatProcVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MdmDatProcVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(mdmDatProcVO != null){
				Map<String, String> mapVO = mdmDatProcVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MstMgmtDBDAOSearchMdmDatProcRequestListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MdmDatProcVO .class);
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
		 * 
		 * @param searchMdmHistoryListVO
		 * @return List<MdmDatProcVO>
		 * @throws DAOException
		 */
		 @SuppressWarnings("unchecked")
		public List<SearchMdmHistoryListVO> searchMdmHistoryList(SearchMdmHistoryListVO searchMdmHistoryListVO) throws DAOException {
			int currentPage = searchMdmHistoryListVO.getIPage();
			int pageRow	  = Integer.parseInt(searchMdmHistoryListVO.getPagerows());
		   	int startNo = pageRow * (currentPage -1) +1;
		   	int endNo   = pageRow *  currentPage;
			 
			DBRowSet dbRowset = null;
			List<SearchMdmHistoryListVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(searchMdmHistoryListVO != null){
					Map<String, String> mapVO = searchMdmHistoryListVO .getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
					
					param.put("startno", startNo);
					param.put("endno", endNo);
			        velParam.put("startno", startNo);
			        velParam.put("endno", endNo);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MstMgmtDBDAOSearchMdmHistoryListRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchMdmHistoryListVO .class);
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
	 * 
	 * 
	 * @param mdmDatProcVO
	 * @return List<MdmDatProcVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<MdmDatProcVO> searchMdmDatProcCompletionList(MdmDatProcVO mdmDatProcVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MdmDatProcVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(mdmDatProcVO != null){
				Map<String, String> mapVO = mdmDatProcVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MstMgmtDBDAOSearchMdmDatProcCompletionListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MdmDatProcVO .class);
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
	 * Master Data 의 Authority Type Code 정보를 조회한다.
	 * 
	 * @param mdmDatProcVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchAuthTpCd(MdmDatProcVO mdmDatProcVO) throws DAOException {
		DBRowSet dbRowset = null;
		String result = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(mdmDatProcVO != null){
				Map<String, String> mapVO = mdmDatProcVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MstMgmtDBDAOSearchAuthTpCdRSQL(), param, velParam);
			
			if(dbRowset.next()) {
				result = dbRowset.getString(1);
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
	 * Master Data Process 테이블의 새로운 Request No 정보를 조회한다.
	 * 
	 * @param String mstDatSubjCd
	 * @return String
	 * @throws DAOException
	 */
	public String searchMdmDatProcRqstNo(String mstDatSubjCd) throws DAOException {
		DBRowSet dbRowset = null;
		String result = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("mst_dat_subj_cd", mstDatSubjCd);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MstMgmtDBDAOSearchMdmDatProcRqstNoRSQL(), param, null);
			if(dbRowset.next()) {
				result = dbRowset.getString(1);
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
	 * MDM DATA PROCESS 정보를 추가한다.
	 * 
	 * @param mdmDatProcVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addMdmDatProc(MdmDatProcVO mdmDatProcVO) throws DAOException, Exception {
		//query parameter ,String usrId
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();
		//parameter Setting
		
		int result = 0;
		try {
			if(mdmDatProcVO != null){
				Map<String, String> mapVO = mdmDatProcVO .getColumnValues();
				param.putAll(mapVO);
			}
			
			result = new SQLExecuter("").executeUpdate((ISQLTemplate)new MstMgmtDBDAOAddMdmDatProcVOCSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED){
				throw new DAOException("Fail to insert SQL");		
		}

		}catch(SQLException se) 
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} 
		catch(Exception ex) 
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	
	/**
	 * MDM DATA PROCESS 정보를 수정한다.
	 * 
	 * @param mdmDatProcVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void modifyMdmDatProc(MdmDatProcVO mdmDatProcVO) throws DAOException, Exception {
		//query parameter ,String usrId
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		//parameter Setting
		
		int result = 0;
		try {
			if(mdmDatProcVO != null){
				Map<String, String> mapVO = mdmDatProcVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			result = new SQLExecuter("").executeUpdate((ISQLTemplate)new MstMgmtDBDAOModifyMdmDatProcVOUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED){
				throw new DAOException("Fail to insert SQL");		
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	
	/**
	 * MDM DATA PROCESS 정보를 수정한다.
	 * 
	 * @param mdmDatProcVOList
	 * @throws DAOException
	 * @throws Exception
	 */
	public void modifyMdmDatProc(List<MdmDatProcVO> mdmDatProcVOList) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			
			if(mdmDatProcVOList.size() > 0){
				Map<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("proc_tp_cd", mdmDatProcVOList.get(0).getProcTpCd());
				velParam.put("rqst_ofc_cd", mdmDatProcVOList.get(0).getRqstOfcCd());
				
				updCnt = sqlExe.executeBatch((ISQLTemplate)new MstMgmtDBDAOModifyMdmDatProcVOUSQL(), mdmDatProcVOList, velParam);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to modify No "+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	
	/**
	 * MDM DATA PROCESS 정보를 삭제 처리한다. 
	 * 
	 * @param mdmDatProcVOList
	 * @throws DAOException
	 * @throws Exception
	 */
	public void removeMdmDatProc(List<MdmDatProcVO> mdmDatProcVOList) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(mdmDatProcVOList.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new MstMgmtDBDAORemoveMdmDatProcVODSQL(), mdmDatProcVOList, null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to remove No "+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	
	/**
	 * User's Office Kind Code retrieve. 
	 * 
	 * @param String ofcCd
	 * @return String
	 * @throws DAOException
	 */
	public String searchOfcKndCd(String ofcCd) throws DAOException {	
		DBRowSet dbRowset = null;
		String result = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();

		try{
		//	param.put("usr_id", usrId);
			param.put("ofc_cd", ofcCd);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MstMgmtDBDAOSearchOfcKndCdRSQL(), param, null);
			
			if(dbRowset.next()) {
				result = dbRowset.getString(1);
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
	 * MDM DATA Process info retrieve. 
	 * 
	 * @param String rqstNo
	 * @return MdmDatProcVO
	 * @throws DAOException
	 */
	public MdmDatProcVO searchMdmDatProc(String rqstNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<MdmDatProcVO> list = null;
		MdmDatProcVO result = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("rqst_no", rqstNo);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MstMgmtDBDAOSearchMdmDatProcVORSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MdmDatProcVO .class);
			
			if(list != null && list.size() > 0) {
				result = list.get(0);
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
	 * [BCM_CCD_2003]MDA History Count <br>
	 *
	 * @param SearchMdmHistoryListVO searchMdmHistoryListVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchMdmHistoryCount(SearchMdmHistoryListVO searchMdmHistoryListVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String result = "";
		
		try{
			Map<String, String> mapVO = searchMdmHistoryListVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MstMgmtDBDAOSearchMdmHistoryCountRSQL(), param, velParam);
			if (dbRowset.next()) {
				result = dbRowset.getString("TOTAL_CNT");
			}

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	
}