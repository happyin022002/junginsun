/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PreventionDBDAO.java
*@FileTitle : Prevention 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.22
*@LastModifier : 진윤오
*@LastVersion : 1.0
* 2009.10.22 진윤오
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.cni.containercargoclaim.prevention.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.cps.cni.codemgt.filemgt.integration.FileMgtDBDAOAddFileUploadCSQL;
import com.clt.apps.opus.cps.cni.codemgt.filemgt.integration.FileMgtDBDAOModifyFileUploadUSQL;
import com.clt.apps.opus.cps.cni.codemgt.filemgt.integration.FileMgtDBDAORemoveFileUploadDSQL;
import com.clt.apps.opus.cps.cni.codemgt.filemgt.vo.CniAtchFileVO;
import com.clt.apps.opus.cps.cni.containercargoclaim.claimmain.basic.ClaimMainBCImpl;
import com.clt.apps.opus.cps.cni.containercargoclaim.prevention.vo.CniClmPrveVO;
import com.clt.apps.opus.cps.cni.containercargoclaim.prevention.vo.PreventionCondVO;
import com.clt.apps.opus.cps.cni.containercargoclaim.prevention.vo.PreventionInfoVO;
import com.clt.apps.opus.cps.cni.containercargoclaim.prevention.vo.PreventionVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;


/**
 * OPUS PreventionDBDAO <br>
 * - OPUS-CNI system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author 진윤오
 * @see ClaimMainBCImpl 참조
 * @since J2EE 1.4
 */
public class PreventionDBDAO extends DBDAOSupport {

	// ---------------------------------------------------------------------------
	// 공통 SQL
	// ---------------------------------------------------------------------------

	

	// ---------------------------------------------------------------------------
	// [CPS_CNI-0022] Prevention
	// ---------------------------------------------------------------------------   

	/**
	 * Prevention List<br>
	 * @author 진윤오 
	 * @category CPS_CNI_0022
	 * @category searchPreventionList 
	 * @param PreventionCondVO condVo
     * @return List<PreventionVO> 
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<PreventionVO> searchPreventionList(PreventionCondVO condVo) throws DAOException {
        DBRowSet dbRowset = null;
        
        List<PreventionVO> list = null;        
       
        try{    
        	// query parameter
            Map<String, String> param = new HashMap<String, String>();
            // velocity parameter
            Map<String, String> velParam = new HashMap<String, String>();            
        	// 조회조건
        	param = condVo.getColumnValues();        	
        	// velocity parameter 설정 
            velParam.putAll(param);
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PreventionDBDAOSearchPreventionListRSQL(), param, velParam);
            
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, PreventionVO.class);
                 
            return list;
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }
       
    }    
    
	// ---------------------------------------------------------------------------
	// [CPS_CNI-0023] Prevention-Register
	// ---------------------------------------------------------------------------   

	/**
	 * prevention no 별 Prevention Info 조회<br>
	 * @author 진윤오 
	 * @category CPS_CNI_0023
	 * @category searchPreventionInfo 
	 * @param String clmPrveNo
     * @return PreventionVO 
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public PreventionInfoVO searchPreventionInfo(String clmPrveNo) throws DAOException {
        DBRowSet dbRowset = null;
        
        List<PreventionInfoVO> list = null;        
       
        try{    
        	// query parameter
            Map<String, String> param = new HashMap<String, String>();
            // velocity parameter
            Map<String, String> velParam = new HashMap<String, String>();            
        	// 조회조건
        	param.put("clm_prve_no", clmPrveNo);   	
        	// velocity parameter 설정 
            velParam.putAll(param);
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PreventionDBDAOSearchPreventionInfoRSQL(), param, velParam);
            
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, PreventionInfoVO.class);
            
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
	 * prevention no 별 Prevention Info 조회<br>
	 * @author 진윤오 
	 * @category CPS_CNI_0023
	 * @category searchPreventionInfo 
     * @return String Max clmPrveNo 
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public String searchMaxClmPrevNo() throws DAOException {
        DBRowSet dbRowset = null;
     
        try{
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PreventionDBDAOSearchMaxClmPrevNoRSQL(), null, null);
            
            if (dbRowset.next()) {            	
            	String maxPrevNo = dbRowset.getString(1);            	 
            	return maxPrevNo;
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
	 * Prevention 추가<br>
	 * @author 진윤오
	 * @category CPS_CNI_0023
	 * @category addPrevention 
	 * @param CniClmPrveVO cniClmPrveVO
     * @throws DAOException
     */
    public void addPrevention(CniClmPrveVO cniClmPrveVO) throws DAOException {        
        try{    
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, Object> velParam = new HashMap<String, Object>();			
			Map<String , String> param = cniClmPrveVO.getColumnValues();
			velParam.putAll(param);			
			sqlExe.executeUpdate((ISQLTemplate) new PreventionDBDAOAddPreventionCSQL(), param, velParam);            
        } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
       
    }  	 

	/**
	 * Prevention 삭제<br>
	 * @author 진윤오
	 * @category CPS_CNI_0023
	 * @category removePrevention 
	 * @param String clmPrveNo
     * @throws DAOException
     */
    public void removePrevention(String clmPrveNo) throws DAOException {        
        try{    
			SQLExecuter sqlExe = new SQLExecuter("");
        	// query parameter
            Map<String, String> param = new HashMap<String, String>();
            // velocity parameter
            Map<String, String> velParam = new HashMap<String, String>();            
        	// 조회조건
        	param.put("clm_prve_no", clmPrveNo);   	
        	// velocity parameter 설정 
            velParam.putAll(param);	
			sqlExe.executeUpdate((ISQLTemplate) new PreventionDBDAORemovePreventionDSQL(), param, velParam);            
        } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
       
    }
    
    
	/**
	 * Prevention 수정<br>
	 * @author 진윤오
	 * @category CPS_CNI_0023
	 * @category modifyPrevention 
	 * @param CniClmPrveVO cniClmPrveVO
     * @throws DAOException
     */
    public void modifyPrevention(CniClmPrveVO cniClmPrveVO) throws DAOException {        
        try{    
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, Object> velParam = new HashMap<String, Object>();			
			Map<String , String> param = cniClmPrveVO.getColumnValues();
			velParam.putAll(param);			
			sqlExe.executeUpdate((ISQLTemplate) new PreventionDBDAOModifyPreventionUSQL(), param, velParam);            
        } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
       
    }  	    
            
	/**
	 * Prevention View Count + 1 수정<br>
	 * @author 진윤오
	 * @category CPS_CNI_0023
	 * @category modifyPrevention 
	 * @param String clmPrveNo
     * @throws DAOException
     */
    public void modifyPreventionViewCnt(String clmPrveNo) throws DAOException {        
        try{    
			SQLExecuter sqlExe = new SQLExecuter("");
        	// query parameter
            Map<String, String> param = new HashMap<String, String>();
            // velocity parameter
            Map<String, String> velParam = new HashMap<String, String>();            
        	// 조회조건
        	param.put("clm_prve_no", clmPrveNo);   	
        	// velocity parameter 설정 
            velParam.putAll(param);		
			sqlExe.executeUpdate((ISQLTemplate) new PreventionDBDAOModifyPreventionViewCntUSQL(), param, velParam);            
        } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
       
    }  	    
}
