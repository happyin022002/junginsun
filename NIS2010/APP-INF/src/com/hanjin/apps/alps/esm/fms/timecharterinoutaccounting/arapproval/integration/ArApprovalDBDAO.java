/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ArApprovalDBDAO.java
*@FileTitle : Business Logic을 처리하기 위한 JDBC 작업수행
*Open Issues :
*Change history :
*@LastModifyDate : 2014-10-08
*@LastModifier : Jung Ho Min
*@LastVersion : 1.0
* 
* 1.0 최초 생성
*----------------------------------------------------------
* History
*  
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.arapproval.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.integration.TCharterIOConsultationDBDAOPrintComCsrBodyInfoRSQL;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.integration.TCharterIOConsultationDBDAOPrintComCsrHeaderInfoRSQL;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.integration.TCharterIOConsultationDBDAOPrintFmsCsrAgmtInfoRSQL;
import com.hanjin.bizcommon.approval.integration.ApprovalDBDAO;
import com.hanjin.bizcommon.approval.integration.ApprovalDBDAOUpdateAproGwFlgUSQL;
import com.hanjin.bizcommon.approval.integration.ApprovalDBDAOUpdateAproGwUrlUSQL;
import com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.vo.IfCsrListInputVO;
import com.hanjin.bizcommon.csr.csrapproval.vo.ComApCsrHisVO;
import com.hanjin.bizcommon.csr.csrapproval.vo.ComCsrInfoVO;
import com.hanjin.bizcommon.csr.csrapproval.vo.ComCsrRequestAgmtVO;
import com.hanjin.bizcommon.csr.csrapproval.vo.ComCsrRequestBodyVO;
import com.hanjin.bizcommon.csr.csrapproval.vo.ComCsrRequestHeaderVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

/**
 * Common CSR에 대한 DB 처리를 담당<br>
 * - Common CSR Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author JungHo Min
 * @see 
 * @since J2EE 1.4
 */

public class ArApprovalDBDAO extends DBDAOSupport {
	
	private static final long serialVersionUID = 1L;
	    
           
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
            
        	dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ArApprovalDBDAOSearchOfcCdRSQL(), param, velParam);
            
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

            //COM_AR_CSR_APRO_HIS_SEQ 신청
            
        	cnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new ArApprovalDBDAOSaveGWInfoCSQL(), param, velParam);
                        
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
            
        	dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ArApprovalDBDAOSearchRqstAproStepFlgRSQL(), param, velParam);
            
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
	 * groupware 전송 xmlData Header info<br>
	 * 
	 * @param String csrNo
     * @return ComCsrRequestHeaderVO 
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public ComCsrRequestHeaderVO printArCsrHeaderInfo(String csrNo) throws DAOException {
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
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ArApprovalDBDAOPrintArCsrHeaderInfoRSQL(), param, velParam);           
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
	 * @param String csrNo
     * @return List<ComCsrRequestBodyVO 
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<ComCsrRequestBodyVO> printArCsrBodyInfo(String csrNo) throws DAOException {
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
                    
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ArApprovalDBDAOPrintArCsrBodyInfoRSQL(), param, velParam);          
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
	 * groupware 전송 xmlData Agreement info<br>
	 *  
	 * @param String csrNo
     * @return List<ComCsrRequestAgmtVO>
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<ComCsrRequestAgmtVO> printFmsCsrAgmtInfo(String csrNo) throws DAOException {
    	DBRowSet dbRowset = null;     
        List<ComCsrRequestAgmtVO> list = null;        
       
        try{    
        	// query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            // velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();
            
        	//  Cargo Claim No
        	param.put("csr_no", csrNo);
        	
        	// velocity parameter 설정 
            velParam.putAll(param);
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOConsultationDBDAOPrintFmsCsrAgmtInfoRSQL(), param, velParam);          
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, ComCsrRequestAgmtVO.class);         
            
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
	 * GW에서 결과 값 전송 <br>
	 * AR_INV_HDR 의 GW Result 값에 따라 날짜 및 계약서 존재여부 업데이트
	 * 
	 * @param ComCsrInfoVO comCsrInfoVO
	 * @throws DAOException
	 */
	public void updateAproGwDt(ComCsrInfoVO comCsrInfoVO) throws DAOException {
		log.debug("\n DAO.updateAproGwDt --------------------------------------------------");
		
		Map<String, Object> param 		= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam 	= new HashMap<String, Object>();
		
		int cnt = 0;
		
		try {

			if(comCsrInfoVO != null){
				Map<String, String> mapVO = comCsrInfoVO.getColumnValues();
				param.putAll(mapVO);	
				velParam.putAll(mapVO);
			}

			cnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new ArApprovalDBDAOUpdateAproGwDtUSQL(), param, velParam);
			
			if(cnt == 0) {
				log.error("There is no updated data.");
				throw new DAOException("There is no updated data.");
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			//throw de;
			throw new DAOException(new ErrorHandler(de).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
	}
	
	/**
	 * AR_INV_HDR 의 RQST_APRO_STEP_FLG, 생성 날짜 업데이트
	 * 
	 * @param IfCsrListInputVO ifCsrListInputVO
	 * @exception DAOException
	 */
	public void updateAproGwFlg(IfCsrListInputVO ifCsrListInputVO) throws DAOException {
		log.debug("\n DAO.updateAproGwFlg --------------------------------------------------");
		
		Map<String, Object> param 		= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam 	= new HashMap<String, Object>();
		
		try {
			if(ifCsrListInputVO != null){
				Map<String, String> mapVO = ifCsrListInputVO.getColumnValues();
				param.putAll(mapVO);	
			}

			new SQLExecuter("").executeUpdate((ISQLTemplate)new ArApprovalDBDAOUpdateAproGwFlgUSQL(), param, velParam);

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
	}
	
	/**
	 * GW에서 결과 값 전송<br>
	 * AR_INV_HDR 의  GW Url, Request_id 업데이트
	 * @param csr_no
	 * @param request_id
	 * @param gw_url
	 * @throws DAOException
	 */
	public void updateAproGwUrl(String csr_no, String request_id, String gw_url) throws DAOException {
		log.debug("\n DAO.updateAproGwUrl --------------------------------------------------");
		
		Map<String, Object> mapVO 		= new HashMap<String, Object>();
		Map<String, Object> param 		= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam 	= new HashMap<String, Object>();
		
		try {
			mapVO.put("csr_no", csr_no);
			mapVO.put("request_id", request_id);
			mapVO.put("gw_url", gw_url);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			new SQLExecuter("").executeUpdate((ISQLTemplate)new ArApprovalDBDAOUpdateAproGwUrlUSQL(), param, velParam);

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
	}
}
