/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SettlementClaimDBDAO.java
*@FileTitle : Settlement Claim 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.26
*@LastModifier : 박제성
*@LastVersion : 1.0
* 2009.11.26 박제성
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.cni.containercargoclaim.settlementclaim.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.cps.cni.containercargoclaim.claimmain.integration.SettlementClaimDBDAOClaimCancelUSQL;
import com.clt.apps.opus.cps.cni.containercargoclaim.settlementclaim.basic.SettlementClaimBCImpl;
import com.clt.apps.opus.cps.cni.containercargoclaim.settlementclaim.vo.CniSettlementVO;
import com.clt.apps.opus.cps.cni.containercargoclaim.settlementclaim.vo.SettlementVO;
import com.clt.apps.opus.cps.gem.common.GemUtil;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;


/**
 * OPUS SettlementClaimDBDAO <br>
 * - OPUS-CNI system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author 박제성
 * @see SettlementClaimBCImpl 참조
 * @since J2EE 1.4
 */
public class SettlementClaimDBDAO extends DBDAOSupport {

	// ---------------------------------------------------------------------------
	// 공통 SQL
	// ---------------------------------------------------------------------------

	

	// ---------------------------------------------------------------------------
	// [CPS_CNI-0014] Settlement Claim
	// ---------------------------------------------------------------------------   
	/**
	 * Settlement 조회<br>
	 * @author 박제성
	 * @category CPS_CNI_0014
	 * @category searchSettlementInfo 
	 * @param String cgoClmNo
     * @return List<LiablePartyVO> 
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<SettlementVO> searchSettlementInfo(String cgoClmNo) throws DAOException {
        DBRowSet dbRowset = null;
        
        List<SettlementVO> list = null;        
       
        try{    
        	// query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            // velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();
            
        	// 조회조건
        	param.put("cgo_clm_no", cgoClmNo);
        	
        	// velocity parameter 설정 
            velParam.putAll(param);
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SettlementClaimDBDAOSearchSettlementInfoRSQL(), param, velParam);
            
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, SettlementVO.class);
                 
            return list;
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }
       
    } 
    
    /**
	 * Settlement 체크<br>
	 * @author 박제성
	 * @category CPS_CNI_0014
	 * @category searchSettlementExist 
	 * @param String cgoClmNo
     * @return String[] 
     * @throws DAOException
     */ 
    @SuppressWarnings("unchecked")
    public String searchSettlementExist(String cgoClmNo) throws DAOException {
        DBRowSet dbRowset = null;
        
        //List<LiablePartyVO> list = null;
        String returnStr[] = null;
       
        try{    
        	// query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            // velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();
            
        	// 조회조건
        	param.put("cgo_clm_no", cgoClmNo);
        	
        	// velocity parameter 설정 
            velParam.putAll(param);
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SettlementClaimDBDAOSearchSettlementExistRSQL(), param, velParam);
            returnStr = GemUtil.getArrayString(dbRowset, "EXIST");        
            
            
            return returnStr[0].trim();
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }
       
    }     
    
	/**
	 * Settlement 입력<br>
	 * @author 박제성
	 * @category CPS_CNI_0014
	 * @category addSettlement 
	 * @param CniSettlementVO cniSettlementVO
     * @throws DAOException
     */ 
    @SuppressWarnings("unchecked")
    public void addSettlement(CniSettlementVO cniSettlementVO) throws DAOException {        
        try{    
        	
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, Object> velParam = new HashMap<String, Object>();			
			Map<String , String> paramMap = cniSettlementVO.getColumnValues();			
			sqlExe.executeUpdate((ISQLTemplate) new SettlementClaimDBDAOAddSettlementCSQL(), paramMap, velParam);
			

        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }
       
    }  
    
	/**
	 * Settlement 수정<br>
	 * @author 박제성
	 * @category CPS_CNI_0014
	 * @category modifySettlement 
	 * @param CniSettlementVO cniSettlementVO  
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public void modifySettlement(CniSettlementVO cniSettlementVO) throws DAOException {        
        try{    
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, Object> velParam = new HashMap<String, Object>();			
			Map<String , String> paramMap = cniSettlementVO.getColumnValues();	
			
			sqlExe.executeUpdate((ISQLTemplate) new SettlementClaimDBDAOModifySettlementUSQL(), paramMap, velParam);
						
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }
       
    }
    
	/**
	 * modifyClaimCancel 수정<br>
	 * @author 박제성
	 * @category CPS_CNI_0014
	 * @category modifyClaimCancel 
	 * @param CniSettlementVO cniSettlementVO  
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public void modifyClaimCancel(CniSettlementVO cniSettlementVO) throws DAOException {        
        try{    
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, Object> velParam = new HashMap<String, Object>();			
			Map<String , String> paramMap = cniSettlementVO.getColumnValues();	
			
			sqlExe.executeUpdate((ISQLTemplate) new SettlementClaimDBDAOClaimCancelUSQL(), paramMap, velParam);
						
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }
       
    }           
    
    /**
	 * Reopen 시 Settlement 정보 수정 <br>
	 * @author 정행룡
	 * @category CPS_CNI_0037
	 * @param String cgoClmNo
	 * @param String updUsrId
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public void modifyReOpenSettlement(String cgoClmNo , String updUsrId) throws DAOException {        
        try{    
        	SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, Object> velParam = new HashMap<String, Object>();			
			Map<String , String> paramMap = new HashMap<String , String>();
			paramMap.put("cgo_clm_no", cgoClmNo);
			paramMap.put("upd_usr_id", updUsrId);
			
			sqlExe.executeUpdate((ISQLTemplate) new SettlementClaimDBDAOModifyReOpenSettlementUSQL(), paramMap, velParam);
						
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }
       
    } 
    
}
