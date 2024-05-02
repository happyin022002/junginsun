/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ComCsrApprovalDBDAO.java
*@FileTitle : Business Logic을 처리하기 위한 JDBC 작업수행
*Open Issues :
*Change history :
*@LastModifyDate : 2014-10-08
*@LastModifier : Young Shin Kim
*@LastVersion : 1.0
* 
* 1.0 최초 생성
*----------------------------------------------------------
* History
* 2014.12.18 History table Search Method add
* 2014.12.18 I/F Data Update Method add
* 2015.03.13 COM_CSR_0015 심성윤 I/F Data 조회, Alps Data 승인자 조회 Method add
=========================================================*/
package com.hanjin.bizcommon.csr.csrapproval.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.bizcommon.csr.csrapproval.vo.ComApCsrHisVO;
import com.hanjin.bizcommon.csr.csrapproval.vo.ComCsrRequestBodyVO;
import com.hanjin.bizcommon.csr.csrapproval.vo.ComCsrRequestFileVO;
import com.hanjin.bizcommon.csr.csrapproval.vo.ComCsrRequestHeaderVO;
import com.hanjin.bizcommon.csr.csrapproval.vo.ComCsrInfoVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
//import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.bizcommon.csr.csrapproval.vo.ComCsrInfoVO;
/**
 * Common CSR에 대한 DB 처리를 담당<br>
 * - Common CSR Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Young Shin Kim
 * @see 
 * @since J2EE 1.4
 */

public class ComCsrApprovalDBDAO extends DBDAOSupport {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * groupware user id 조회<br>
	 *
	 * @param String usrId
	 * @return String groupware user id
     * @throws DAOException
     */
    public String searchGwUserId(String usrId) throws DAOException {        
        DBRowSet dbRowset = null;
        
        try{

        	// query parameter
            Map<String, String> param = new HashMap<String, String>();
            // velocity parameter
            Map<String, String> velParam = new HashMap<String, String>();            
        	// 조회조건
        	param.put("usr_id", usrId);   	
        	// velocity parameter 설정 
            velParam.putAll(param);
            
        	dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ComCsrApprovalDBDAOSearchGwUserIdRSQL(), param, velParam);
            
            if (dbRowset.next()) {            	
            	String epId = dbRowset.getString(1);            	 
            	return epId;
            }
            
            return null;
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }
       
    }  
    
    /**
	 * groupware 전송 xmlData Header info<br>
     *
	 * @param String csrNo
     * @return ComCsrRequestHeaderVO 
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public ComCsrRequestHeaderVO printComCsrHeaderInfo(String csrNo) throws DAOException {
    	DBRowSet dbRowset = null;      
        List<ComCsrRequestHeaderVO> list = null;        
       
        try{    
        	// query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            // velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();
            
        	//  Cargo Claim No
        	param.put("csr_no", csrNo);
        	
        	// velocity parameter 설정 
            velParam.putAll(param);
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ComCsrApprovalDBDAOPrintComCsrHeaderInfoRSQL(), param, velParam);           
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, ComCsrRequestHeaderVO.class);
            
            if (list != null && !list.isEmpty()) {
            	return list.get(0);
            }
            
            return null;
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }
    }  
    
    /**
	 * groupware 전송 xmlData Body info<br>
	 *
	 * @category printComCsrBodyInfo 
	 * @param String csrNo
     * @return List<ComCsrRequestBodyVO>
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<ComCsrRequestBodyVO> printComCsrBodyInfo(String csrNo) throws DAOException {
    	DBRowSet dbRowset = null;     
        List<ComCsrRequestBodyVO> list = null;        
       
        try{    
        	// query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            // velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();
            
        	//  Cargo Claim No
        	param.put("csr_no", csrNo);
        	
        	// velocity parameter 설정 
            velParam.putAll(param);
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ComCsrApprovalDBDAOPrintComCsrBodyInfoRSQL(), param, velParam);          
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, ComCsrRequestBodyVO.class);         
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }        
        return list;      
    }  
    
    /**
	 * groupware 전송 xmlData File info<br>
	 *
	 * @category printComCsrFileInfo 
	 * @param String csrNo
     * @return List<ComCsrRequestFileVO>
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<ComCsrRequestFileVO> printComCsrFileInfo(String csrNo) throws DAOException {
    	DBRowSet dbRowset = null;     
        List<ComCsrRequestFileVO> list = null;        
       
        try{    
        	// query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            // velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();
            
        	//  Cargo Claim No
        	param.put("csr_no", csrNo);
        	
        	// velocity parameter 설정  
            velParam.putAll(param);
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ComCsrApprovalDBDAOPrintComCsrFileInfoRSQL(), param, velParam);          
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, ComCsrRequestFileVO.class);         
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }        
        return list;      
    }  
    
    /**
	 * CSR_NO로 SUB_SYS_CD 조회<br>
	 * 
	 * @param String csrNo
	 * @return String subSysCd
     * @throws DAOException
     */
    public String searchSubSysCd(String csrNo) throws DAOException {        
        DBRowSet dbRowset = null;
        
        try{
        	// query parameter
            Map<String, String> param = new HashMap<String, String>();
            // velocity parameter
            Map<String, String> velParam = new HashMap<String, String>();     
            
        	// 조회조건
        	param.put("csr_no", csrNo);   	
        	// velocity parameter 설정 
            velParam.putAll(param);
            
        	dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ComCsrApprovalDBDAOSearchSubSysCdRSQL(), param, velParam);
            
            if (dbRowset.next()) {            	
            	String subSysCd = dbRowset.getString(1);            	 
            	return subSysCd;
            }
            
            return null;
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }
       
    }  
    
    /**
	 * CSR_NO로 OFC_CD 조회<br>
	 * 
	 * @param String csrNo
	 * @return String ofcCd
     * @throws DAOException
     */
    public String searchOfcCd(String csrNo) throws DAOException {        
        DBRowSet dbRowset = null;
        
        try{
        	// query parameter
            Map<String, String> param = new HashMap<String, String>();
            // velocity parameter
            Map<String, String> velParam = new HashMap<String, String>();            
        	// 조회조건
        	param.put("csr_no", csrNo);   	
        	// velocity parameter 설정 
            velParam.putAll(param);
            
        	dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ComCsrApprovalDBDAOSearchOfcCdRSQL(), param, velParam);
            
            if (dbRowset.next()) {            	
            	String ofcCd = dbRowset.getString(1);            	 
            	return ofcCd;
            }
            
            return null;
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }     
    }  

    /**
	 * History table insert<br>
	 * 
	 * @param ComApCsrHisVO comApCsrHisVO
     * @throws DAOException
     */
    public void saveGWInfo(ComApCsrHisVO comApCsrHisVO) throws DAOException {        
    	// query parameter
        Map<String, String> param = new HashMap<String, String>();
        // velocity parameter
        Map<String, String> velParam = new HashMap<String, String>(); 
        
        int cnt = 0;
        
        try{
            if(comApCsrHisVO != null){
				Map<String, String> mapVO = comApCsrHisVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);			
			}
            
        	cnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new ComCsrApprovalDBDAOSaveGWInfoCSQL(), param, velParam);
                        
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }       
    }  

    /**
	 * CSR_No로 RQST_APRO_STEP_FLG 상태를 조회한다.<br>
	 *
	 * @param String csrNo
	 * @return String AproStepFlg
     * @throws DAOException
     */
    public String searchRqstAproStepFlg(String csrNo) throws DAOException {        
        DBRowSet dbRowset = null;
        
        try{
        	// query parameter
            Map<String, String> param = new HashMap<String, String>();
            // velocity parameter
            Map<String, String> velParam = new HashMap<String, String>();            
        	// 조회조건
        	param.put("csr_no", csrNo);   	
        	// velocity parameter 설정 
            velParam.putAll(param);
            
        	dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ComCsrApprovalDBDAOSearchRqstAproStepFlgRSQL(), param, velParam);
            
            if (dbRowset.next()) {            	
            	String aproStepFlg = dbRowset.getString(1);            	 
            	return aproStepFlg;
            }
            
            return null;
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }     
    }  
    
    /**
	 * 모듈별 Subject를 조회한다.<br>
	 * 
	 * @param String invSubSydCd
	 * @return String subject
     * @throws DAOException
     */
    public String searchSubject(String invSubSydCd) throws DAOException {        
        DBRowSet dbRowset = null;
        
        try{
        	// query parameter
            Map<String, String> param = new HashMap<String, String>();
            // velocity parameter
            Map<String, String> velParam = new HashMap<String, String>();            
        	// 조회조건
        	param.put("inv_sub_sys_cd", invSubSydCd);   	
        	// velocity parameter 설정 
            velParam.putAll(param);
            
        	dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ComCsrApprovalDBDAOSearchSubjectRSQL(), param, velParam);
            
            if (dbRowset.next()) {            	
            	String subject = dbRowset.getString(1);            	 
            	return subject;
            }
            
            return null;
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }     
    }  
    
    /**
	 * I/F Flag의 상태를 조회한다. <br>
	 * COM_CSR_0015 <br>
	 * @author 2015513 심성윤 (2015.03.13)
	 * @param String csrNo
	 * @return String
	 * @throws EventException
	 */
       public String searchCheckIfFlg(String csrNo) throws DAOException {        
           DBRowSet dbRowset = null;
           
           try{
           	// query parameter
               Map<String, String> param = new HashMap<String, String>();
               // velocity parameter
               Map<String, String> velParam = new HashMap<String, String>();            
           	// 조회조건
               param.put("csr_no", csrNo);  	
           	// velocity parameter 설정 
               velParam.putAll(param);
               
           	dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ComCsrApprovalDBDAOSearchCheckIfFlgRSQL(), param, velParam);
               
               if (dbRowset.next()) {            	
               	String subject = dbRowset.getString(1);            	 
               	return subject;
               }
               
               return null;
               
           }catch(SQLException se){
               log.error(se.getMessage(),se);
               throw new DAOException(new ErrorHandler(se).getMessage(), se);
           }catch(Exception ex){
               log.error(ex.getMessage(),ex);
               throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
           }     
       }  
       
   /**
   	 * 기안이 완료 전 상태인지를 조회한다.<br>
   	 * CHM-201535042<br>
   	 * @author 심성윤 (2015.03.31)
   	 * @param String csrNo
   	 * @return String
   	 * @throws EventException
   	 */
          public String searchCheckAproStepFlg(String csrNo) throws DAOException {        
              DBRowSet dbRowset = null;
              
              try{
              	// query parameter
                  Map<String, String> param = new HashMap<String, String>();
                  // velocity parameter
                  Map<String, String> velParam = new HashMap<String, String>();            
              	// 조회조건
                  param.put("csr_no", csrNo);  	
              	// velocity parameter 설정 
                  velParam.putAll(param);
                  
              	dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ComCsrApprovalDBDAOsearchCheckAproStepFlgRSQL(), param, velParam);
                  
                  if (dbRowset.next()) {            	
                  	String subject = dbRowset.getString(1);            	 
                  	return subject;
                  }
                  
                  return null;
                  
              }catch(SQLException se){
                  log.error(se.getMessage(),se);
                  throw new DAOException(new ErrorHandler(se).getMessage(), se);
              }catch(Exception ex){
                  log.error(ex.getMessage(),ex);
                  throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
              }     
          }
    /**
	 * GW 승인자 정보를 조회한다<br>
     *
	 * @param String csrNo
     * @return ComApCsrHisVO 
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public ComApCsrHisVO searchCsrHisInfo(String csrNo) throws DAOException {
    	DBRowSet dbRowset = null;      
        List<ComApCsrHisVO> list = null;        
       
        try{    
        	// query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            // velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();
            
        	param.put("csr_no", csrNo);
        	
        	// velocity parameter 설정 
            velParam.putAll(param);
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ComCsrApprovalDBDAOSearchCsrHisInfoRSQL(), param, velParam);           
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, ComApCsrHisVO.class);
            
            if (list != null && !list.isEmpty()) {
            	return list.get(0);
            }
            
            return null;
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }
    }
    
    /**
   	 * AL 승인자 정보를 조회한다<br>
   	 * COM_CSR_0015 <br>
   	 * @param String csrNo
   	 * @Author 심성윤(2015.03.12)
     * @return ComApCsrHisVO 
     * @throws DAOException
     */
       @SuppressWarnings("unchecked")
       public ComCsrInfoVO searchCsrApAproInfo(String csrNo) throws DAOException {
       	DBRowSet dbRowset = null;      
           List<ComCsrInfoVO> list = null;        
          
           try{    
           	// query parameter
               Map<String, Object> param = new HashMap<String, Object>();
               // velocity parameter
               Map<String, Object> velParam = new HashMap<String, Object>();
               
           	param.put("csr_no", csrNo);
           	
           	// velocity parameter 설정 
               velParam.putAll(param);
               
               dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ComCsrApprovalDBDAOSearchCsrApAproInfoRSQL(), param, velParam);           
               list = (List)RowSetUtil.rowSetToVOs(dbRowset, ComCsrInfoVO.class);
               
               if (list != null && !list.isEmpty()) {
               	return list.get(0);
               }
               
               return null;
           }catch(SQLException se){
               log.error(se.getMessage(),se);
               throw new DAOException(new ErrorHandler(se).getMessage(), se);
           }catch(Exception ex){
               log.error(ex.getMessage(),ex);
               throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
           }
       }
    
    /**
	 * I/F DT update<br>
	 *
	 * @param String csrNo
	 * @throws DAOException
	 */
	public void updateErpInterface(String csrNo) throws DAOException {
		// query parameter
        Map<String, String> param = new HashMap<String, String>();
        // velocity parameter
        Map<String, String> velParam = new HashMap<String, String>(); 
        
        try{
        	param.put("csr_no", csrNo);   	
        	// velocity parameter 설정 
            velParam.putAll(param);
            
        	new SQLExecuter("").executeUpdate((ISQLTemplate)new ComCsrApprovalDBDAOUpdateErpInterfaceUSQL(), param, velParam);

        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }    
	}
	
	
	/**
	 * batch 대상 csr 조회
	 * @return List<ComCsrInfoVO>
	 * @throws DAOException
	 */
	public List<ComCsrInfoVO> searchBatchCsr() throws DAOException {
    	DBRowSet dbRowset = null;      
        List<ComCsrInfoVO> list = null;        
       
        try{    
        	// query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            // velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();
            
//        	param.put("csr_no", csrNo);
        	
        	// velocity parameter 설정 
            velParam.putAll(param);
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ComCsrApprovalDBDAOSearchBatchCsrRSQL(), param, velParam);           
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, ComCsrInfoVO.class);
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }
        return list;
    }
}
