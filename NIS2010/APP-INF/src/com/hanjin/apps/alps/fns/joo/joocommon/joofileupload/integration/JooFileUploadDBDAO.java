/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JooFileUploadDBDAO.java
*@FileTitle : JO Member Information 파일 생성
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.09
*@LastModifier : 이준범
*@LastVersion : 1.0
* 2010.11.09 이준범
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.joocommon.joofileupload.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.fns.joo.joocommon.joofileupload.vo.FileUploadInfoVO;
import com.hanjin.apps.alps.fns.joo.joocommon.joofileupload.vo.FileUploadListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;


/**
 * ALPS JooFileUploadDBDAO <br>
 * - ALPS-CodeMgt system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author 이준범
 * @see JooFileUploadBCImpl 참조
 * @since J2EE 1.6
 */
public class JooFileUploadDBDAO extends DBDAOSupport {

	/**
	 * File Upload 리스트 조회<br>
	 * @author 이준범
	 * @category FNS_JOO_0082
	 * @param String joCrrCd
	 * @param String crrCntcSeq
	 * @return List<FileUploadListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	 public List<FileUploadListVO> searchFileUploadList(String joCrrCd, String crrCntcSeq) throws DAOException {
		DBRowSet dbRowset = null;
		List<FileUploadListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			param.put("jo_crr_cd", joCrrCd);
        	param.put("crr_cntc_seq", crrCntcSeq);
						
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JooFileUploadDBDAOFileUploadListRSQL(), param, velParam);
			
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, FileUploadListVO.class);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}	 
	 
		/**
		 * File Upload 추가<br>
		 * @author 이준범
		 * @category FNS_JOO_0082
		 * @category addFileUpload 
		 * @param FileUploadListVO fileUploadListVO
	     * @throws DAOException
	     */
	 public void addFileUpload(FileUploadListVO fileUploadListVO) throws DAOException {        
		 try{    
				SQLExecuter sqlExe = new SQLExecuter("");
				Map<String, Object> velParam = new HashMap<String, Object>();			
				Map<String , String> param = fileUploadListVO.getColumnValues();
				velParam.putAll(param);			
				sqlExe.executeUpdate((ISQLTemplate) new JooFileUploadDBDAOFileUploadListCSQL(), param, velParam);            
	        } catch (SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			} catch (Exception ex) {
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
	       
	    }  
	/**
	 * File Upload 추가<br>
	 * @author 이준범
	 * @category FNS_JOO_0082
	 * @category removeFileUpload 
	 * @param FileUploadListVO fileUploadListVO
     * @throws DAOException
     */
	 public void removeFileUpload(FileUploadListVO fileUploadListVO) throws DAOException {        
        try{    
				SQLExecuter sqlExe = new SQLExecuter("");
				Map<String, Object> velParam = new HashMap<String, Object>();			
				Map<String , String> param = fileUploadListVO.getColumnValues();
				velParam.putAll(param);			
				sqlExe.executeUpdate((ISQLTemplate) new JooFileUploadDBDAOFileUploadListDSQL(), param, velParam);            
	        } catch (SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			} catch (Exception ex) {
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
	       
	    }
	/**
	 * File Upload 추가<br>
	 * @author 이준범
	 * @category FNS_JOO_0082
	 * @category modifyFileUpload 
	 * @param FileUploadListVO fileUploadListVO
     * @throws DAOException
     */
	 public void modifyFileUpload(FileUploadListVO fileUploadListVO) throws DAOException {        
        try{    
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, Object> velParam = new HashMap<String, Object>();			
			Map<String , String> param = fileUploadListVO.getColumnValues();
			velParam.putAll(param);			
			sqlExe.executeUpdate((ISQLTemplate) new JooFileUploadDBDAOFileUploadListUSQL(), param, velParam);            
        } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
       
    } 
	 
		/**
		 * File Upload 리스트 조회<br>
		 * @author 민정호
		 * @category FNS_JOO_0098
		 * @param String csrNo
		 * @return List<FileUploadListVO>
		 * @throws DAOException
		 */
		 @SuppressWarnings("unchecked")
		 public List<FileUploadListVO> searchCsrFileUploadList(String csrNo) throws DAOException {
			DBRowSet dbRowset = null;
			List<FileUploadListVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			try{
				param.put("csr_no", csrNo);
				
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JooFileUploadDBDAOCsrFileUploadListRSQL(), param, velParam);
				
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, FileUploadListVO.class);
				
			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return list;
		}	 
		 
			/**
			 * File Upload 추가<br>
			 * @author 민정호
			 * @category FNS_JOO_0098
			 * @category addFileUpload 
			 * @param FileUploadListVO fileUploadListVO
		     * @throws DAOException
		     */
		 public void addCsrFileUpload(FileUploadListVO fileUploadListVO) throws DAOException {        
			 try{    
					SQLExecuter sqlExe = new SQLExecuter("");
					Map<String, Object> velParam = new HashMap<String, Object>();			
					Map<String , String> param = fileUploadListVO.getColumnValues();
					velParam.putAll(param);			
					sqlExe.executeUpdate((ISQLTemplate) new JooFileUploadDBDAOCsrFileUploadListCSQL(), param, velParam);            
		        } catch (SQLException se) {
					log.error(se.getMessage(), se);
					throw new DAOException(new ErrorHandler(se).getMessage(), se);
				} catch (Exception ex) {
					log.error(ex.getMessage(), ex);
					throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
				}
		       
		    }  
		/**
		 * File Upload 삭제<br>
		 * @author 민정호
		 * @category FNS_JOO_0098
		 * @category removeCsrFileUpload 
		 * @param FileUploadListVO fileUploadListVO
	     * @throws DAOException
	     */
		 public void removeCsrFileUpload(FileUploadListVO fileUploadListVO) throws DAOException {        
	        try{    
					SQLExecuter sqlExe = new SQLExecuter("");
					Map<String, Object> velParam = new HashMap<String, Object>();			
					Map<String , String> param = fileUploadListVO.getColumnValues();
					velParam.putAll(param);			
					sqlExe.executeUpdate((ISQLTemplate) new JooFileUploadDBDAOCsrFileUploadListDSQL(), param, velParam);            
		        } catch (SQLException se) {
					log.error(se.getMessage(), se);
					throw new DAOException(new ErrorHandler(se).getMessage(), se);
				} catch (Exception ex) {
					log.error(ex.getMessage(), ex);
					throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
				}
		       
		    }
		/**
		 * File Upload 수정<br>
		 * @author 민정호
		 * @category FNS_JOO_0098
		 * @category modifyCsrFileUpload 
		 * @param FileUploadListVO fileUploadListVO
	     * @throws DAOException
	     */
		 public void modifyCsrFileUpload(FileUploadListVO fileUploadListVO) throws DAOException {        
	        try{    
				SQLExecuter sqlExe = new SQLExecuter("");
				Map<String, Object> velParam = new HashMap<String, Object>();			
				Map<String , String> param = fileUploadListVO.getColumnValues();
				velParam.putAll(param);			
				sqlExe.executeUpdate((ISQLTemplate) new JooFileUploadDBDAOCsrFileUploadListUSQL(), param, velParam);            
	        } catch (SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			} catch (Exception ex) {
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
	       
	    } 	 
	 
	/**
	 * File Upload Info 리스트 조회<br>
	 * @author 김현주
	 * @category FNS_JOO_0097
	 * @param FileUploadInfoVO fileUploadInfoVO
	 * @return List<FileUploadInfoVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	 public List<FileUploadInfoVO> searchFileUploadInfo(FileUploadInfoVO fileUploadInfoVO) throws DAOException {
			 
		DBRowSet dbRowset = null;
		List<FileUploadInfoVO> list = null;
/*		//query parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		Map<String, String> param = fileUploadInfoVO.getColumnValues();
		velParam.putAll(param);	*/	
			
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		param.put("file_save_id", fileUploadInfoVO.getFileSaveId());

		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JooFileUploadDBDAOFileUploadInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, FileUploadInfoVO.class);
					
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}	 	  

	/**
	 * File Upload Info 저장, 삭제<br>
	 * @author 김현주
	 * @category FNS_JOO_0097
	 * @param FileUploadInfoVO fileUploadInfoVO
	 * @throws DAOException
	 */
	 public void modifyFileUploadInfo(FileUploadInfoVO fileUploadInfoVO) throws DAOException {        
		try{    
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, Object> velParam = new HashMap<String, Object>();			
			Map<String , String> param = fileUploadInfoVO.getColumnValues();
			velParam.putAll(param);			
			sqlExe.executeUpdate((ISQLTemplate) new JooFileUploadDBDAOFileUploadInfoUSQL(), param, velParam);            
	    } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
     }   
}