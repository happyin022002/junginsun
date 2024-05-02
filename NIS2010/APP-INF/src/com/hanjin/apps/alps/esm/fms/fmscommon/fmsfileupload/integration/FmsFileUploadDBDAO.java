/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FmsFileUploadDBDAO.java
*@FileTitle : File Upload
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.09
*@LastModifier : 이준범
*@LastVersion : 1.0
* 2010.11.09 이준범
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.fmscommon.fmsfileupload.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.fms.fmscommon.fmsfileupload.vo.FileUploadListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;


/**
 * ALPS FmsFileUploadDBDAO <br>
 * - ALPS-CodeMgt system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author 이준범 
 * @see FmsFileUploadBCImpl 참조
 * @since J2EE 1.6
 */
public class FmsFileUploadDBDAO extends DBDAOSupport {

	private static final long serialVersionUID = 1L;


		/**
		 * File Upload 리스트 조회<br>
		 * 
		 * @param String vslCd
		 * @param String vnorSeq
		 * @param String vnorItmSeq
		 * @return List<FileUploadListVO>
		 * @throws DAOException
		 */
		 @SuppressWarnings("unchecked")
		 public List<FileUploadListVO> searchCsrFileUploadList(String vslCd, String vnorSeq, String vnorItmSeq) throws DAOException {
			DBRowSet dbRowset = null;
			List<FileUploadListVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			try{
				param.put("vsl_cd", vslCd);
				param.put("vnor_seq", vnorSeq);
				param.put("vnor_itm_seq", vnorItmSeq);
				
				velParam.putAll(param);
				
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new FmsFileUploadDBDAOFileUploadListRSQL(), param, velParam);
				
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
			 * Fms Vnor Itm 수정<br>
			 * 
			 * @param FileUploadListVO fileUploadListVO
		     * @throws DAOException
		     */
			 public void updateFmsVndoItm(FileUploadListVO fileUploadListVO) throws DAOException {        
		        try{    
					SQLExecuter sqlExe = new SQLExecuter("");
					Map<String, Object> velParam = new HashMap<String, Object>();			
					Map<String , String> param = fileUploadListVO.getColumnValues();
					velParam.putAll(param);			
					sqlExe.executeUpdate((ISQLTemplate) new FmsFileUploadDBDAOUpdateFmsVndoItmUSQL(), param, velParam);            
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
			 * 
			 * @param FileUploadListVO fileUploadListVO
		     * @throws DAOException
		     */
		 public void addFileUpload(FileUploadListVO fileUploadListVO) throws DAOException {        
			 try{    
					SQLExecuter sqlExe = new SQLExecuter("");
					Map<String, Object> velParam = new HashMap<String, Object>();			
					Map<String , String> param = fileUploadListVO.getColumnValues();
					velParam.putAll(param);			
					sqlExe.executeUpdate((ISQLTemplate) new FmsFileUploadDBDAOFileUploadListCSQL(), param, velParam);            
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
		 * 
		 * @param FileUploadListVO fileUploadListVO
	     * @throws DAOException
	     */
		 public void removeFileUpload(FileUploadListVO fileUploadListVO) throws DAOException {        
	        try{    
					SQLExecuter sqlExe = new SQLExecuter("");
					Map<String, Object> velParam = new HashMap<String, Object>();			
					Map<String , String> param = fileUploadListVO.getColumnValues();
					velParam.putAll(param);			
					sqlExe.executeUpdate((ISQLTemplate) new FmsFileUploadDBDAOFileUploadListDSQL(), param, velParam);            
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
		 * 
		 * @param FileUploadListVO fileUploadListVO
	     * @throws DAOException
	     */
		 public void modifyFileUpload(FileUploadListVO fileUploadListVO) throws DAOException {        
	        try{    
				SQLExecuter sqlExe = new SQLExecuter("");
				Map<String, Object> velParam = new HashMap<String, Object>();			
				Map<String , String> param = fileUploadListVO.getColumnValues();
				velParam.putAll(param);			
				sqlExe.executeUpdate((ISQLTemplate) new FmsFileUploadDBDAOFileUploadListUSQL(), param, velParam);            
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
	 * @param String vslCd
	 * @param String vnorSeq
	 * @param String vnorItmSeq
	 * @return String			 *
	 * @throws DAOException
	 */
	public String searchAtchFileLnkId(String vslCd, String vnorSeq, String vnorItmSeq) throws DAOException {
		DBRowSet dbRowset = null;
	    String rtnVal = "";		
	    // query parameter
	    Map<String, Object> param = new HashMap<String, Object>();
	    // velocity parameter
	    Map<String, Object> velParam = new HashMap<String, Object>();
	
	    try {
	    	param.put("vsl_cd", vslCd);           
	    	param.put("vnor_seq", vnorSeq);
	    	param.put("vnor_itm_seq", vnorItmSeq);
	    	
	    	velParam.putAll(param);
	 
	    	dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new FmsFileUploadDBDAOSearchAtchFileLnkIdRSQL(),param, velParam);
	
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
	
	
	/******************************************************************************************************************
	 * Owner's Account 
	 */
	
	/**
	 * File Upload 리스트 조회<br>
	 * 
	 * @param String csrNo
	 * @return List<FileUploadListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	 public List<FileUploadListVO> searchCsrFileUploadListOA(String csrNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<FileUploadListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			param.put("csr_no", csrNo);
			velParam.putAll(param);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new FmsFileUploadDBDAOFileUploadListOARSQL(), param, velParam);
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
	 * 
	 * @param FileUploadListVO fileUploadListVO
	 * @throws DAOException
	 */
	public void addFileUploadOA(FileUploadListVO fileUploadListVO) throws DAOException {        
		try{    
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, Object> velParam = new HashMap<String, Object>();			
			Map<String , String> param = fileUploadListVO.getColumnValues();
			velParam.putAll(param);			
			sqlExe.executeUpdate((ISQLTemplate) new FmsFileUploadDBDAOFileUploadListOACSQL(), param, velParam);            
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	} 
		
	/**
	 * FMS_CSUL_SLP 수정<br>
	 * 
	 * @param FileUploadListVO fileUploadListVO
	 * @throws DAOException
	 */
	public void updateFmsCsulSlp(FileUploadListVO fileUploadListVO) throws DAOException {        
		try{    
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, Object> velParam = new HashMap<String, Object>();			
			Map<String , String> param = fileUploadListVO.getColumnValues();
			velParam.putAll(param);			
			sqlExe.executeUpdate((ISQLTemplate) new FmsFileUploadDBDAOUpdateFmsCsulSlpUSQL(), param, velParam);            
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
	 * 
	 * @param FileUploadListVO fileUploadListVO
	 * @throws DAOException
	 */
	 public void removeFileUploadOA(FileUploadListVO fileUploadListVO) throws DAOException {        
		 try{    
			 SQLExecuter sqlExe = new SQLExecuter("");
			 Map<String, Object> velParam = new HashMap<String, Object>();			
			 Map<String , String> param = fileUploadListVO.getColumnValues();
			 velParam.putAll(param);			
			 sqlExe.executeUpdate((ISQLTemplate) new FmsFileUploadDBDAOFileUploadListOADSQL(), param, velParam);            
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
	 * 
	 * @param FileUploadListVO fileUploadListVO
	 * @throws DAOException
	 */
	public void modifyFileUploadOA(FileUploadListVO fileUploadListVO) throws DAOException {       
		try{   
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, Object> velParam = new HashMap<String, Object>();			
			Map<String , String> param = fileUploadListVO.getColumnValues();
			velParam.putAll(param);			
			sqlExe.executeUpdate((ISQLTemplate) new FmsFileUploadDBDAOFileUploadListOAUSQL(), param, velParam);            
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}	       
	} 	

	
}