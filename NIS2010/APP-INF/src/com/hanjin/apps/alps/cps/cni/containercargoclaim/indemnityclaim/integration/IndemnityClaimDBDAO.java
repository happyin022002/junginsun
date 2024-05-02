/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : IndemnityClaimDBDAO.java
*@FileTitle : Container Cargo Claim 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.22
*@LastModifier : 박제성
*@LastVersion : 1.0
* 2009.10.22 박제성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.cni.containercargoclaim.indemnityclaim.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.basic.ClaimMainBCImpl;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.indemnityclaim.vo.CniLiablePartyVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.indemnityclaim.vo.LiablePartyVO;
import com.hanjin.apps.alps.cps.gem.common.GemUtil;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;


/**
 * NIS2010 IndemnityClaimDBDAO <br>
 * - NIS2010-CNI system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author 박제성
 * @see ClaimMainBCImpl 참조
 * @since J2EE 1.4
 */
public class IndemnityClaimDBDAO extends DBDAOSupport {

	// ---------------------------------------------------------------------------
	// 공통 SQL
	// ---------------------------------------------------------------------------

	

	// ---------------------------------------------------------------------------
	// [CPS_CNI-0015] Indemnity Claim
	// ---------------------------------------------------------------------------   
	/**
	 * Survey 조회<br>
	 * @author 박제성
	 * @category CPS_CNI_0015
	 * @category searchLiablePartyList 
	 * @param String cgoClmNo
     * @return List<LiablePartyVO> 
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<LiablePartyVO> searchLiablePartyInfo(String cgoClmNo) throws DAOException {
        DBRowSet dbRowset = null;
        
        List<LiablePartyVO> list = null;        
       
        try{    
        	// query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            // velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();
            
        	// 조회조건
        	param.put("cgo_clm_no", cgoClmNo);
        	
        	// velocity parameter 설정 
            velParam.putAll(param);
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new IndemnityDBDAOSearchLiablePartyInfoRSQL(), param, velParam);
            
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, LiablePartyVO.class);
                 
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
	 * LiableParty 체크<br>
	 * @author 박제성
	 * @category CPS_CNI_0015
	 * @category searchLiablePartyExist 
	 * @param String cgoClmNo
     * @return String[] 
     * @throws DAOException
     */ 
    @SuppressWarnings("unchecked")
    public String searchLiablePartyExist(String cgoClmNo) throws DAOException {
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
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new IndemnityDBDAOSearchLiablePartyExistRSQL(), param, velParam);
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
	 * Survey 입력<br>
	 * @author 박제성
	 * @category CPS_CNI_0015
	 * @category addLiableParty 
	 * @param CniLiablePartyVO cniLiablePartyVO
     * @throws DAOException
     */ 
    @SuppressWarnings("unchecked")
    public void addLiableParty(CniLiablePartyVO cniLiablePartyVO) throws DAOException {        
        try{    
        	
        	log.debug(">>>>>>>>>   addLiableParty()");
        	
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, Object> velParam = new HashMap<String, Object>();			
			Map<String , String> paramMap = cniLiablePartyVO.getColumnValues();			
			sqlExe.executeUpdate((ISQLTemplate) new IndemnityDBDAOAddLiablePartyCSQL(), paramMap, velParam);
			

        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }
       
    }  
    
	/**
	 * LiableParty 수정<br>
	 * @author 박제성
	 * @category CPS_CNI_0015
	 * @category modifyLiableParty 
	 * @param CniLiablePartyVO cniLiablePartyVO   
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public void modifyLiableParty(CniLiablePartyVO cniLiablePartyVO) throws DAOException {        
        try{    
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, Object> velParam = new HashMap<String, Object>();			
			Map<String , String> paramMap = cniLiablePartyVO.getColumnValues();	
			
			sqlExe.executeUpdate((ISQLTemplate) new IndemnityDBDAOModifyLiablePartyUSQL(), paramMap, velParam);
						
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }
       
    }           
    

    
    
}
