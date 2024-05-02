/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : DodFileUploadDBDAO.java
*@FileTitle : DOD File Upload
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.04
*@LastModifier : 손진환
*@LastVersion : 1.0
* 2016.01.04 손진환
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dod.dodcommon.fileupload.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.ees.dod.dodcommon.fileupload.basic.DodFileUploadBCImpl;
import com.hanjin.apps.alps.ees.dod.dodcommon.fileupload.vo.FileUploadListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;


/**
 * ALPS DodFileUploadDBDAO <br>
 * - ALPS-FileUpload system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Son, Jin-Hwan
 * @see DodFileUploadBCImpl 참조
 * @since J2EE 1.6
 */
public class DodFileUploadDBDAO extends DBDAOSupport {

	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param String bkgNo
	 * @param String cntrNo
	 * @param String drpOffChgSeq
	 * @param String drpOffChgTrfSeq
	 * @param String caller
	 * @param String atchFileLnkId
	 * @return List<FileUploadListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<FileUploadListVO> searchDodFileUploadList(String bkgNo, String cntrNo, String drpOffChgSeq, String drpOffChgTrfSeq, String caller, String atchFileLnkId) throws DAOException {
		DBRowSet dbRowset = null;
		List<FileUploadListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("bkg_no", bkgNo);           
			param.put("cntr_no", cntrNo);
			param.put("drp_off_chg_seq", drpOffChgSeq);
			param.put("drp_off_chg_trf_seq", drpOffChgTrfSeq);
			param.put("atch_file_lnk_id", atchFileLnkId);
			velParam.putAll(param);

			if("CHG".equals(caller)) {
				if(!"".equals(atchFileLnkId)) {
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DodFileUploadDBDAOFileUploadListVOByIDRSQL(), param, velParam);
				}else{
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DodFileUploadDBDAOFileUploadListVORSQL(), param, velParam);				
					
				}
			}else{
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DodFileUploadDBDAOFileUploadListVOTrfRSQL(), param, velParam);
			}
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, FileUploadListVO.class);
			
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
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param FileUploadListVO fileUploadListVO
	 * @exception DAOException
	 * @exception Exception
	 */
	public void addFileUpload(FileUploadListVO fileUploadListVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = fileUploadListVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new DodFileUploadDBDAOFileUploadListVOCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param FileUploadListVO fileUploadListVO
	 * @return int
	 * @exception DAOException
	 * @exception Exception
	 */
	public int modifyFileUpload(FileUploadListVO fileUploadListVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = fileUploadListVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new DodFileUploadDBDAOFileUploadListVOUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
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
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param FileUploadListVO fileUploadListVO
	 * @return int
	 * @exception DAOException
	 * @exception Exception
	 */
	public int removeFileUpload(FileUploadListVO fileUploadListVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = fileUploadListVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new DodFileUploadDBDAOFileUploadListVODSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
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
	 * DOD_DRP_OFF_CHG > ATCH_FILE_LNK_ID Update<br>
	 * 
	 * @param FileUploadListVO fileUploadListVO
	 * @throws DAOException
	 */
	 public void updateDodDrpOffChg(FileUploadListVO fileUploadListVO) throws DAOException {        
	    try{    
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, Object> velParam = new HashMap<String, Object>();			
			Map<String , String> param = fileUploadListVO.getColumnValues();
			velParam.putAll(param);
			
			sqlExe.executeUpdate((ISQLTemplate) new DodFileUploadDBDAOUpdateDodDrpOffChgUSQL(), param, velParam);            
	    } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}	       
	}
	
		/**
		 * DOD_DRP_OFF_CHG_TRF > ATCH_FILE_LNK_ID Update<br>
		 * 
		 * @param FileUploadListVO fileUploadListVO
		 * @throws DAOException
		 */
		 public void updateDodDrpOffChgTrf(FileUploadListVO fileUploadListVO) throws DAOException {        
		    try{    
				SQLExecuter sqlExe = new SQLExecuter("");
				Map<String, Object> velParam = new HashMap<String, Object>();			
				Map<String , String> param = fileUploadListVO.getColumnValues();
				velParam.putAll(param);
				
				sqlExe.executeUpdate((ISQLTemplate) new DodFileUploadDBDAOUpdateDodDrpOffChgTrfUSQL(), param, velParam);            
		    } catch (SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			} catch (Exception ex) {
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}	       
		}
		 
	/**
	 * 첨부파일 ID 조회 <br>
	 * 
	 * @param String bkgNo
	 * @param String cntrNo
	 * @param String drpOffChgSeq
	 * @param String drpOffChgTrfSeq
	 * @param String caller
	 * @return String			 *
	 * @throws DAOException
	 */
	public String searchAtchFileLnkId(String bkgNo, String cntrNo, String drpOffChgSeq, String drpOffChgTrfSeq, String caller) throws DAOException {
        DBRowSet dbRowset = null;
        String rtnVal = "";		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
log.debug("\rcaller : " + caller);
		try {
			 param.put("bkg_no", bkgNo);           
			 param.put("cntr_no", cntrNo);
			 param.put("drp_off_chg_seq", drpOffChgSeq);
			 param.put("drp_off_chg_trf_seq", drpOffChgTrfSeq);
			 velParam.putAll(param);
			 
			 if("CHG".equals(caller)) {
				 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new DodFileUploadDBDAOSearchAtchFileLnkIdRSQL(),param, velParam);
			 }else{
				 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new DodFileUploadDBDAOSearchAtchFileLnkIdTrfRSQL(),param, velParam);
			 }
			
             if(dbRowset.next()){
                rtnVal = dbRowset.getString("ATCH_FILE_LNK_ID");            	
             }    			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnVal;
	}
	
	/**
	 * 첨부파일 ID 생성 <br>
	 * 
	 * @return String			 *
	 * @throws DAOException
	 */
	public String createAtchFileLnkId() throws DAOException {
        DBRowSet dbRowset = null;
        String rtnVal = "";		

		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new DodFileUploadDBDAOCreateAtchFileLnkIdCSQL(), null, null);

			if(dbRowset.next()){
				rtnVal = dbRowset.getString("ATCH_FILE_LNK_ID");            	
			}    			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnVal;
	}
	
}