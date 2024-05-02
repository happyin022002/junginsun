/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FileUploadDBDAO.java
*@FileTitle : 3자구상 파일업로드 공통팝업
*Open Issues :
*Change history :
*@LastModifyDate : 2009-12-02
*@LastModifier : Sun, CHOI
*@LastVersion : 1.1
* 2009-08-20 O Wan-Ki  1.0 최초 생성
* 2009-12-02 Sun, CHOI 1.1 ALPS Migration
=========================================================*/
package com.clt.apps.opus.esd.tpb.common.fileupload.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.clt.apps.opus.esd.tpb.common.fileupload.event.TPBFileUploadEvent;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.fileupload.basic.FileUploadBCImpl;
import com.clt.syscommon.common.table.TpbTtlFileMgmtVO;


/**
 * NIS-3rd Party Billing에 대한 DB 처리를 담당<br>
 * - NIS-3rd Party Billing Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Sun, CHOI
 * @see FileUploadBCImpl 참조
 * @since J2EE 1.4
 */
public class TPBFileUploadDBDAO extends DBDAOSupport {

	/**
	 * 해당 fileNo의 업로드된 파일정보(목록) 조회 이벤트 처리 <br>
	 * <b><font color=blue>[SQL]</font></b> SELECT tpb_ttl_file_mgmt <br>
	 * @param TPBFileUploadEvent event 
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public DBRowSet searchUploadFileInfo(TPBFileUploadEvent event) throws DAOException {
		 DBRowSet dbRowset = null;
		 
		 HashMap params = event.getEventParams();
		 
		 String fileNo      = JSPUtil.getNull((String)params.get("fileNo")); 
	   	 String user_ofc_cd = JSPUtil.getNull((String)params.get("user_ofc_cd"));	

		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
//		 Map<String, Object> velParam = new HashMap<String, Object>();
		
		 try{
			 if(fileNo != null && user_ofc_cd != null){				 
				 param.put("s_file_no", fileNo);
				 param.put("s_user_ofc_cd", user_ofc_cd);

			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TPBFileUploadDBDAOSearchUploadFileInfoRSQL(), param, null);
		 }catch(SQLException se){
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return dbRowset;				
	}
	
	/** selectUploadFileCnt
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public int selectUploadFileCnt(TPBFileUploadEvent event) throws DAOException {
		if(log.isDebugEnabled())log.debug("==========TPBFileUploadDBDAO    multiTerminalInvoiceDetailSearchCount() ============ ");
	
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int tpbCnt = 0;
		
		 HashMap params = event.getEventParams();
		 
		 String fileNo      = JSPUtil.getNull((String)params.get("fileNo")); 
	   	 String user_ofc_cd = JSPUtil.getNull((String)params.get("user_ofc_cd"));	
	   	 
		  
		try {
			 if(fileNo != null && user_ofc_cd != null){				 
				 param.put("file_no", fileNo);
			 }
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TPBFileUploadDBDAOSelectUploadFileCntRSQL(), param, velParam);
			dbRowset.next();
			tpbCnt = dbRowset.getInt("CNT");
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return tpbCnt;
	}
		
	/** updateFileNo
	 * 
	 * @param event
	 * @throws DAOException
	 */
	public void updateFileNo(TPBFileUploadEvent event) throws DAOException {
		
//		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		 HashMap params = event.getEventParams();
		 
		 String fileNo      = JSPUtil.getNull((String)params.get("fileNo")); 
	   	 
		 
		  
		try {
			 if(fileNo != null){				 
				 param.put("file_no", fileNo);
			 }
			
			new SQLExecuter("").executeUpdate((ISQLTemplate)new TPBFileUploadDBDAOUpdateFileNoUSQL(), param, velParam);

		} catch (SQLException se) {
			log.debug("#####################se.getMessage()============>"+se.getMessage());
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error("DAOException "+de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error("Exception:"+e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}

	}
	
//	/**
//	 * FileUpload정보 저장(생성) 이벤트 처리 <br>
//	 * <b><font color=blue>[SQL]</font></b> INSERT tpb_ttl_file_mgmt <br>
//	 * @param Collection models 
//	 * @param TPBFileUploadEvent event 
//	 * @return String[] {fileNo, fileNoSeq} 
//	 * @exception EventException
//	 * @throws DAOException 
//	 */
//	@SuppressWarnings("unchecked")
//	public String[] createUploadFileInfo(List<String> models, TPBFileUploadEvent event) throws DAOException {
//		
//		HashMap params = event.getEventParams();
//		
//		String fileNo      = (String)params.get("fileNo");
//		if ( fileNo == null || fileNo.trim().length() == 0 || fileNo.equals("0") ) {
//			fileNo = getNextFileNo();
//		}
//		String fileNoSeq   = getFileNoSeq(fileNo);
//		String fileLgcNm  = "";
//		String filePhysNm  = "";
//		String filePathNm  = "";
//		
//		
//		String user_id     = JSPUtil.getNull((String)params.get("user_id"));
//		String user_ofc_cd = JSPUtil.getNull((String)params.get("user_ofc_cd")); 
//
////		log.debug(" f_cmd======>" + f_cmd );
////		log.debug(" invNo======>" + invNo );
////		log.debug(" user_id======>" + user_id );
////		log.debug(" user_ofc_cd======>" + user_ofc_cd );
//	   	
//		//query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
//		//velocity parameter
////		Map<String, Object> velParam = new HashMap<String, Object>();
//		Iterator itr = models.iterator();
//		CreateUploadFileInfoVO model = null;
//		model = (CreateUploadFileInfoVO)itr.next();
//		try{
//			if(fileNo != null & user_ofc_cd != null & user_id != null){				 
//				param.put("s_file_phys_nm", model.getFile_phys_nm());
//				param.put("s_file_lgc_nm", model.getFile_lgc_nm());
//				param.put("s_file_path_nm", model.getFile_path_nm());
//				param.put("s_cre_usr_id", user_id);
//				param.put("s_file_no_seq", fileNoSeq);
//				param.put("s_upd_usr_id", user_id);
//				param.put("s_file_no", fileNo);
//				
//				fileLgcNm  = model.getFile_lgc_nm();
//				filePhysNm = model.getFile_phys_nm();
//				filePathNm = model.getFile_path_nm();
//				
////				log.debug("param==========>"+param);
////				log.debug("velParam==========>"+velParam);
//			}
//			new SQLExecuter("").executeUpdate((ISQLTemplate)new TPBFileUploadDBDAOCreateUploadFileInfoCSQL(), param, null);
//		}catch(SQLException se){
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		}catch(Exception ex){
//			log.error(ex.getMessage(),ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage());
//		}
//		return new String[]{fileNo, fileNoSeq, filePhysNm, fileLgcNm, filePathNm}; // 순서 주의		
//	}
	
	/** createUploadFileInfo
	 * 
	 * @param listTpbTtlFileMgmtVO
	 * @throws DAOException
	 */
	public void createUploadFileInfo(List<TpbTtlFileMgmtVO> listTpbTtlFileMgmtVO) throws DAOException {

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	
		
		try {
			int insCnt[] = null;
			
			if(listTpbTtlFileMgmtVO.size() > 0){
				insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new TPBFileUploadDBDAOCreateUploadFileInfoCSQL(), listTpbTtlFileMgmtVO, param, velParam);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}	
		

		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	
	
	/** updateUploadFiles
	 * 
	 * @param listTpbTtlFileMgmtVO
	 * @throws DAOException
	 */
	public void updateUploadFiles(List<TpbTtlFileMgmtVO> listTpbTtlFileMgmtVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	
		
		try {
			int insCnt[] = null;
			
			
			if(listTpbTtlFileMgmtVO.size() > 0){
				insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new TPBFileUploadDBDAOUpdateUploadFilesUSQL(), listTpbTtlFileMgmtVO, param, velParam);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}				

		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}		
	
	/** removeUploadFiles
	 * 
	 * @param listTpbTtlFileMgmtVO
	 * @throws DAOException
	 */
	public void removeUploadFiles(List<TpbTtlFileMgmtVO> listTpbTtlFileMgmtVO) throws DAOException {

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			
			if(listTpbTtlFileMgmtVO.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new TPBFileUploadDBDAODeleteUploadFilesDSQL(), listTpbTtlFileMgmtVO, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}

		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}		
	
	/**
	 * tpb_ttl_file_mgmt_seq1.nextval 값을 가져온다. <br>
	 * <b><font color=blue>[SQL]</font></b> SELECT DUAL USING tpb_ttl_file_mgmt_seq1 <br>
	 * @return 
	 * @throws DAOException
	 */
	public String getNextFileNo() throws DAOException {
		String nextFileNo = "";
		
		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		DBRowSet dbRowset = null;
		
	    Map<String, Object> param = new HashMap<String, Object>();
	    //velocity parameter
	    Map<String, Object> velParam = new HashMap<String, Object>();
	 
	    try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TPBFileUploadDBDAOSearchGetNextFileNoRSQL(), param, velParam);

			if ( dbRowset!=null && dbRowset.next() ){
				nextFileNo = dbRowset.getString(1);
			}
//			log.debug("nextFileNo=======>"+nextFileNo);
			dbRowset = null;
			
	    }catch(SQLException se){
			log.error(se.getMessage(),se);
		 	throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return nextFileNo;
	}

	/**
	 * tpb_ttl_file_mgmt의 fileNo에 대한 다음 file_no_seq 값을 가져온다. <br>
	 * <b><font color=blue>[SQL]</font></b> SELECT tpb_ttl_file_mgmt <br>
	 * @param fileNo 
	 * @return 
	 * @throws DAOException
	 */
	public String getFileNoSeq(String fileNo) throws DAOException {
		 DBRowSet dbRowset = null;
		
		 String nextFileNoSeq = null;
		 
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
//		 Map<String, Object> velParam = new HashMap<String, Object>();
		
		 try{
			 if(fileNo != null){				 
				 param.put("file_no", fileNo);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TPBFileUploadDBDAOSearchGetFileNoSeqRSQL(), param, null);
				
			 if ( dbRowset!=null && dbRowset.next() ){
				 nextFileNoSeq = dbRowset.getString(1);
			 }
			 dbRowset = null;
		 
		 }catch(SQLException se){
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return nextFileNoSeq;				
	}
	
	/**
	 * FileUpload정보 삭제 이벤트 처리 <br>
	 * <b><font color=blue>[SQL]</font></b> UPDATE tpb_ttl_file_mgmt <br>
	 * @param TPBFileUploadEvent event 
	 * @return boolean 
	 * @exception EventException
	 * @throws DAOException 
	 */
	@SuppressWarnings("unchecked")
	public boolean removeUploadFiles(TPBFileUploadEvent event) throws DAOException {
		boolean isSuccessFlag = false; // 성공여부
		 
		HashMap params = event.getEventParams();

		String fileNo      = (String)params.get("fileNo");
		String delFileNoSeqs	= (String)params.get("delFileNoSeqs");
	   	String user_id     = JSPUtil.getNull((String)params.get("user_id"));
	   	String user_ofc_cd = JSPUtil.getNull((String)params.get("user_ofc_cd")); 
	   	String physicalFileNm = JSPUtil.getNull((String)params.get("physicalFileNm"));
//	   	log.debug("fileNo==========>"+fileNo);
//	   	log.debug("delFileNoSeqs==========>"+delFileNoSeqs);
//	   	log.debug("user_id==========>"+user_id);
//	   	log.debug("user_ofc_cd==========>"+user_ofc_cd);
	   	log.debug("physicalFileNm==========>"+physicalFileNm);
	   	
//	   	ArrayList tempArrL = new ArrayList();
	   	StringTokenizer strTempFileNoSeq = null;
	   	String tempTempFileNoSeq = ""; 
	   	
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(fileNo != null & user_ofc_cd != null & user_id != null){				 
				param.put("s_file_no", fileNo);
				param.put("s_temp_file_no_seq", delFileNoSeqs);
				param.put("s_user_id", user_id);
				param.put("s_user_ofc_cd", user_ofc_cd);
				param.put("s_file_phys_nm", physicalFileNm);
				param.remove("s_temp_file_no_seq"); // s_temp_file_no_seq 처리를 위해 추가
				
				String s_temp_file_no_seq = delFileNoSeqs;
				int len_s_temp_file_no_seq = delFileNoSeqs.length();
				
				//s_temp_file_no_seq 넣는 부분
				if(!delFileNoSeqs.equals("")){
					s_temp_file_no_seq = s_temp_file_no_seq.substring(0,len_s_temp_file_no_seq - 1);
					strTempFileNoSeq = new StringTokenizer(s_temp_file_no_seq, "|");
					tempTempFileNoSeq = strTempFileNoSeq.nextToken();
//					log.debug("tempTempFileNoSeq ============>["+tempTempFileNoSeq+"]");
//					tempArrL.add(tempTempFileNoSeq);

					while(strTempFileNoSeq.hasMoreTokens()){
						tempTempFileNoSeq = strTempFileNoSeq.nextToken();
//						tempArrL.add(tempTempFileNoSeq);
					}
				}
//				if(tempArrL.size()>0){
					param.put("s_temp_file_no_seq", tempTempFileNoSeq);
//				}
				
//				log.debug("param==========>"+param);
//				log.debug("velParam==========>"+velParam);
			}
			new SQLExecuter("").executeUpdate((ISQLTemplate)new TPBFileUploadDBDAODeleteUploadFilesDSQL(), param, null);
			isSuccessFlag = true;
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return isSuccessFlag;			
	}
	
}
