/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FileMgtDBDAO.java
*@FileTitle : DWC,Insurance 파일 생성
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.16
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.10.16 윤세영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.cni.codemgt.filemgt.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.cps.cni.codemgt.filemgt.basic.FileMgtBCImpl;
import com.hanjin.apps.alps.cps.cni.codemgt.filemgt.vo.CniAtchFileVO;
import com.hanjin.apps.alps.cps.cni.codemgt.filemgt.vo.CustomFileDwcInsuranceVO;
import com.hanjin.apps.alps.cps.cni.codemgt.filemgt.vo.FileUploadCondVO;
import com.hanjin.apps.alps.cps.cni.codemgt.filemgt.vo.FileUploadVO;
import com.hanjin.apps.alps.cps.cni.codemgt.filemgt.vo.SearchFileDwcInsuranceListVO;
import com.hanjin.apps.alps.cps.cni.codemgt.filemgt.vo.SearchFileInsuranceListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;


/**
 * ALPS FileMgtDBDAO <br>
 * - ALPS-CodeMgt system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Yoon, Seyeong
 * @see FileMgtBCImpl 참조
 * @since J2EE 1.6
 */
public class FileMgtDBDAO extends DBDAOSupport {

	
	/**
	 * Dry Wet Claim 및 Insurance File를 생성한다.<br>
	 * 
	 * @param List<CustomFileDwcInsuranceVO> customFileDwcInsuranceVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addFileDwcInsurances(List<CustomFileDwcInsuranceVO> customFileDwcInsuranceVO) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(customFileDwcInsuranceVO .size() > 0){
				
				//velocity parameter
				Map<String, Object> velParam = new HashMap<String, Object>();
				
				velParam.put("inst_prm_insur_tp_cd", customFileDwcInsuranceVO.get(0).getInstPrmInsurTpCd());//Premium

				insCnt = sqlExe.executeBatch((ISQLTemplate)new FileMgtDBDAOCustomFileDwcInsuranceVOCSQL(), customFileDwcInsuranceVO,velParam);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
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
	 * Dry Wet Claim 및 Insurance File를 변경한다.<br>
	 * 
	 * @param List<CustomFileDwcInsuranceVO> customFileDwcInsuranceVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void modifyFileDwcInsurances(List<CustomFileDwcInsuranceVO> customFileDwcInsuranceVO) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(customFileDwcInsuranceVO .size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new FileMgtDBDAOCustomFileDwcInsuranceVOUSQL(), customFileDwcInsuranceVO,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
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
	 * Dry Wet Claim 및 Insurance File를 삭제한다.<br>
	 * 
	 * @param List<CustomFileDwcInsuranceVO> customFileDwcInsuranceVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void removeFileDwcInsurances(List<CustomFileDwcInsuranceVO> customFileDwcInsuranceVO) throws DAOException,Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(customFileDwcInsuranceVO .size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new FileMgtDBDAOCustomFileDwcInsuranceVODSQL(), customFileDwcInsuranceVO,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
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
	 * Dry & Wet Claim의 File 첨부내용을 조회한다.<br>
	 * 
	 * @param String dwClmNo
	 * @return List<SearchFileDwcInsuranceListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchFileDwcInsuranceListVO> searchFileDwcInsuranceList(String dwClmNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchFileDwcInsuranceListVO> searchFileDwcInsuranceListVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
	
		try{
			
			param.put("dw_clm_no", dwClmNo);
	
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new FileMgtDBDAOSearchFileDwcInsuranceListVORSQL(), param, null);
			searchFileDwcInsuranceListVO = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchFileDwcInsuranceListVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return searchFileDwcInsuranceListVO;
	}
	 
	 
	/**
	 * File Upload 리스트 조회<br>
	 * 
	 * @param FileUploadCondVO fileUploadCondVO
	 * @return List<FileUploadVO> 
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<FileUploadVO> searchFileUploadList(FileUploadCondVO fileUploadCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<FileUploadVO> list = null;
		//query parameter
		Map<String, String> param;
		Map<String, Object> vparam = new HashMap<String, Object>();
		try{			
			param = fileUploadCondVO.getColumnValues();			
			vparam.putAll(param);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new FileMgtDBDAOSearchFileUploadListRSQL(), param, vparam);
			
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, FileUploadVO.class);
			
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
	 * @author 진윤오
	 * @category CPS_CNI_0011
	 * @category addFileUpload 
	 * @param CniAtchFileVO cniAtchFileVO
     * @throws DAOException
     */
    public void addFileUpload(CniAtchFileVO cniAtchFileVO) throws DAOException {        
        try{    
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, Object> velParam = new HashMap<String, Object>();			
			Map<String , String> param = cniAtchFileVO.getColumnValues();
			velParam.putAll(param);			
			sqlExe.executeUpdate((ISQLTemplate) new FileMgtDBDAOAddFileUploadCSQL(), param, velParam);            
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
	 * @author 진윤오
	 * @category CPS_CNI_0011
	 * @category addFileUpload 
	 * @param CniAtchFileVO cniAtchFileVO
     * @throws DAOException
     */
    public void removeFileUpload(CniAtchFileVO cniAtchFileVO) throws DAOException {        
        try{    
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, Object> velParam = new HashMap<String, Object>();			
			Map<String , String> param = cniAtchFileVO.getColumnValues();
			velParam.putAll(param);			
			sqlExe.executeUpdate((ISQLTemplate) new FileMgtDBDAORemoveFileUploadDSQL(), param, velParam);            
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
	 * @author 진윤오
	 * @category CPS_CNI_0011
	 * @category addFileUpload 
	 * @param CniAtchFileVO cniAtchFileVO
     * @throws DAOException
     */
    public void modifyFileUpload(CniAtchFileVO cniAtchFileVO) throws DAOException {        
        try{    
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, Object> velParam = new HashMap<String, Object>();			
			Map<String , String> param = cniAtchFileVO.getColumnValues();
			velParam.putAll(param);			
			sqlExe.executeUpdate((ISQLTemplate) new FileMgtDBDAOModifyFileUploadUSQL(), param, velParam);            
        } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
       
    }  	    
    
    
	/**
	 * Insurance의 File 첨부내용을 조회한다.<br>
	 * 
	 * @param String insurTpCd
	 * @param String insurPlcyYr
	 * @param String insurClmPtyNo
	 * @param String insurPrmTpCd
	 * @param String clmFileTpCd
	 * @return List<SearchFileInsuranceListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchFileInsuranceListVO> searchFileInsuranceList(String insurTpCd, String insurPlcyYr, String insurClmPtyNo, String insurPrmTpCd, String clmFileTpCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchFileInsuranceListVO> searchFileInsuranceListVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
	
		try{
			
			param.put("insur_tp_cd", insurTpCd);
			param.put("insur_plcy_yr", insurPlcyYr);
			param.put("insur_clm_pty_no", insurClmPtyNo);
			param.put("insur_prm_tp_cd", insurPrmTpCd);
			param.put("clm_file_tp_cd", clmFileTpCd);
			
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			velParam.put("insur_prm_tp_cd", insurPrmTpCd);//Premium
			velParam.put("insur_clm_pty_no", insurClmPtyNo);//Insurer
	
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new FileMgtDBDAOSearchFileInsuranceListVORSQL(), param, velParam);
			searchFileInsuranceListVO = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchFileInsuranceListVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return searchFileInsuranceListVO;
	}
	/**
	 * Insurance File를 삭제한다.<br>
	 * 
	 * @param String insurTpCd
	 * @param String insurPlcyYr
	 * @param String insurClmPtyNo
	 * @throws DAOException
	 * @throws Exception
	 */
	public void removeInsuranceFile(String insurTpCd, String insurPlcyYr, String insurClmPtyNo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		int result = 0;
		try {
			
			param.put("insur_tp_cd", insurTpCd);
			param.put("insur_plcy_yr", insurPlcyYr);
			param.put("insur_clm_pty_no", insurClmPtyNo);
						
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new FileMgtDBDAORemoveInsuranceFileDSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
	
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	
	}
	/**
	 * Insurance Premium File를 삭제한다.<br>
	 * 
	 * @param String insurTpCd
	 * @param String insurPlcyYr
	 * @param String insurClmPtyNo
	 * @throws DAOException
	 * @throws Exception
	 */
	public void removePremiumFile(String insurTpCd, String insurPlcyYr, String insurClmPtyNo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		int result = 0;
		try {
			
			param.put("insur_tp_cd", insurTpCd);
			param.put("insur_plcy_yr", insurPlcyYr);
			param.put("insur_clm_pty_no", insurClmPtyNo);
						
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new FileMgtDBDAORemovePremiumFileDSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
	
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	
	}
	/**
	 * Insurance Premium File를 삭제한다.<br>
	 * 
	 * @param String insurTpCd
	 * @param String insurPlcyYr
	 * @param String insurClmPtyNo
	 * @param String insurPrmTpCd
	 * @throws DAOException
	 * @throws Exception
	 */
	public void removePremiumTypeFile(String insurTpCd, String insurPlcyYr, String insurClmPtyNo, String insurPrmTpCd) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		int result = 0;
		try {
			
			param.put("insur_tp_cd", insurTpCd);
			param.put("insur_plcy_yr", insurPlcyYr);
			param.put("insur_clm_pty_no", insurClmPtyNo);
			param.put("insur_prm_tp_cd", insurPrmTpCd);
						
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new FileMgtDBDAORemovePremiumTypeFileDSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
	
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	
	}  	 
    
    
    
}