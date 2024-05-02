/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InsuranceRecoveryDBDAO.java
*@FileTitle : Container Cargo Claim 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.30
*@LastModifier : 정행룡
*@LastVersion : 1.0
* 2009.10.29 정행룡
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.cni.containercargoclaim.insurancerecovery.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.cps.cni.containercargoclaim.insurancerecovery.basic.InsuranceRecoveryBCImpl;
import com.clt.apps.opus.cps.cni.containercargoclaim.insurancerecovery.vo.CniCgoClmInsurVO;
import com.clt.apps.opus.cps.cni.containercargoclaim.insurancerecovery.vo.EntryStatusVO;
import com.clt.apps.opus.cps.cni.containercargoclaim.insurancerecovery.vo.InsuranceRecoveryByCaseVO;
import com.clt.apps.opus.cps.cni.containercargoclaim.insurancerecovery.vo.InsuranceRecoveryByVvdVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;


/**
 * InsuranceRecoveryDBDAO <br>
 * Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author clt
 * @see InsuranceRecoveryBCImpl 참조
 * @since J2EE 1.4
 */
public class InsuranceRecoveryDBDAO extends DBDAOSupport {

	// ---------------------------------------------------------------------------
	// 공통 SQL
	// ---------------------------------------------------------------------------
	// 진윤오  ===========================================================================	
	
	// ---------------------------------------------------------------------------
	// [CPS_CNI_0016] Insurance Recovery by VVD 
	// ---------------------------------------------------------------------------
	
	/**
	 * vvd 정보 및 보험관련 조회<br>
	 * @author 진윤오
	 * @category CPS_CNI_0016
	 * @category searchEntryStatusInfo 
	 * @param String vslCd
	 * @param String insurClmPtyNo
	 * @param String insurPlcyYr
     * @return EntryStatusVO
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public EntryStatusVO searchEntryStatusInfo(String vslCd , String insurClmPtyNo , String insurPlcyYr) throws DAOException {
        DBRowSet dbRowset = null;
        
        List<EntryStatusVO> list = null;        
       
        try{    
        	// query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            // velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();

        	param.put("vsl_cd", vslCd);
        	param.put("insur_clm_pty_no", insurClmPtyNo);
        	param.put("insur_plcy_yr", insurPlcyYr);
        	// velocity parameter 설정 
            velParam.putAll(param);
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InsuranceRecoveryDBDAOSearchEntryStatusInfoRSQL(), param, velParam);
            
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, EntryStatusVO.class);
            
            if (list != null && !list.isEmpty()) {
            	return list.get(0);
            }
            
            return null;
            
        } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
        
    }
    
    
	/**
	 * VVD InsuranceRecovery정보 조회<br>
	 * @author 진윤오
	 * @category CPS_CNI_0016
	 * @category searchInsuranceRecoveryByVvdList 
	 * @param String trnkRefVvdNo
     * @return List<InsuranceRecoveryByVvdVO>
     * @throws DAOException
     */
    public List<InsuranceRecoveryByVvdVO> searchInsuranceRecoveryByVvdList(String trnkRefVvdNo) throws DAOException {
        DBRowSet dbRowset = null;
        
        List<InsuranceRecoveryByVvdVO> list = null;        
       
        try{    
        	// query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            // velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();

        	param.put("trnk_ref_vvd_no", trnkRefVvdNo);        	
        	// velocity parameter 설정 
            velParam.putAll(param);
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InsuranceRecoveryDBDAOSearchInsuranceRecoveryByVvdListRSQL(), param, velParam);
            
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, InsuranceRecoveryByVvdVO.class);
           
            return list;
            
        } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
        
    }    
    
    
    /**
	 * VVD InsuranceRecovery 등록<br>
	 * @author 진윤오
	 * @category CPS_CNI_0016
	 * @category addInsuranceRecoveryByVvd 
	 * @param CniCgoClmInsurVO cniCgoClmInsurVO   
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public void addInsuranceRecoveryByVvd(CniCgoClmInsurVO cniCgoClmInsurVO) throws DAOException {        
        try{    
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, Object> velParam = new HashMap<String, Object>();			
			Map<String , String> paramMap = cniCgoClmInsurVO.getColumnValues();	
			sqlExe.executeUpdate((ISQLTemplate) new InsuranceRecoveryDBDAOAddInsuranceRecoveryByVvdCSQL(), paramMap, velParam);			
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }
       
    }     
    
    /**
	 * VVD InsuranceRecovery정보 수정<br>
	 * @author 진윤오
	 * @category CPS_CNI_0016
	 * @category modifyInsuranceRecoveryByVvd 
	 * @param CniCgoClmInsurVO cniCgoClmInsurVO   
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public void modifyInsuranceRecoveryByVvd(CniCgoClmInsurVO cniCgoClmInsurVO) throws DAOException {        
        try{    
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, Object> velParam = new HashMap<String, Object>();			
			Map<String , String> paramMap = cniCgoClmInsurVO.getColumnValues();	
			sqlExe.executeUpdate((ISQLTemplate) new InsuranceRecoveryDBDAOModifyInsuranceRecoveryByVvdUSQL(), paramMap, velParam);
			
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }
       
    }       
    
	// ---------------------------------------------------------------------------
	// [CPS_CNI_0017] Insurance Recovery by Case 
	// ---------------------------------------------------------------------------
    
	/**
	 * Case InsuranceRecovery정보 조회<br>
	 * @author 진윤오
	 * @category CPS_CNI_0017
	 * @category searchInsuranceRecoveryByCaseInfo 
	 * @param String cgoClmNo
     * @return InsuranceRecoveryByCaseVO
     * @throws DAOException
     */
    public InsuranceRecoveryByCaseVO searchInsuranceRecoveryByCaseInfo(String cgoClmNo) throws DAOException {
        DBRowSet dbRowset = null;
        
        List<InsuranceRecoveryByCaseVO> list = null;        
       
        try{    
        	// query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            // velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();

        	param.put("cgo_clm_no", cgoClmNo);        	
        	// velocity parameter 설정 
            velParam.putAll(param);
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InsuranceRecoveryDBDAOSearchInsuranceRecoveryByCaseInfoRSQL(), param, velParam);
            
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, InsuranceRecoveryByCaseVO.class);
           
            if (list != null && !list.isEmpty()) {
            	return list.get(0);
            }
            
            return null;
            
        } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
        
    }    
        
    
    /**
	 * Case InsuranceRecovery정보 수정<br>
	 * @author 진윤오
	 * @category CPS_CNI_0017
	 * @category modifyInsuranceRecoveryByCase 
	 * @param CniCgoClmInsurVO cniCgoClmInsurVO   
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public void modifyInsuranceRecoveryByCase(CniCgoClmInsurVO cniCgoClmInsurVO) throws DAOException {        
        try{    
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, Object> velParam = new HashMap<String, Object>();			
			Map<String , String> paramMap = cniCgoClmInsurVO.getColumnValues();	
			sqlExe.executeUpdate((ISQLTemplate) new InsuranceRecoveryDBDAOModifyInsuranceRecoveryByCaseUSQL(), paramMap, velParam);
			
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }
       
    }       
    
    
    /**
	 * Case InsuranceRecovery Cancel<br>
	 * @author 진윤오
	 * @category CPS_CNI_0017
	 * @category modifyInsuranceRecoveryCancel 
	 * @param String cgoClmNo
	 * @param String updUsrId   
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public void modifyInsuranceRecoveryCancel(String cgoClmNo , String updUsrId) throws DAOException {        
        try{    
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, Object> velParam = new HashMap<String, Object>();			
			Map<String , String> paramMap = new HashMap<String , String>();
			
			paramMap.put("cgo_clm_no", cgoClmNo);
			paramMap.put("upd_usr_id", updUsrId);
			
			sqlExe.executeUpdate((ISQLTemplate) new InsuranceRecoveryDBDAOModifyInsuranceRecoveryCancelUSQL(), paramMap, velParam);
			
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }
       
    }      
    
   /**
	 * Insurance 체크<br>
	 * @author 정행룡
	 * @category CPS_CNI_0003
	 * @category searchInsuranceExist 
	 * @param String cgoClmNo
     * @return String
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public String searchInsuranceExist(String cgoClmNo) throws DAOException {
        DBRowSet dbRowset = null;
        
        String returnStr = null;
       
        try{    
        	// query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            // velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();
            
        	// 조회조건
        	param.put("cgo_clm_no", cgoClmNo);
        	
        	// velocity parameter 설정 
            velParam.putAll(param);
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InsuranceRecoveryDBDAOSearchInsuranceExistRSQL(), param, velParam);
            
            if (dbRowset.next()) {
            	returnStr = dbRowset.getString("chk_exist");
            }
            return returnStr;
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }
       
    }     
	
    /**
	 * Insurance 입력<br>
	 * @author 정행룡
	 * @category CPS_CNI_0003
	 * @category addInsurance 
	 * @param CniCgoClmInsurVO cniCgoClmInsurVO
     * @throws DAOException
     */ 
    @SuppressWarnings("unchecked")
    public void addInsurance(CniCgoClmInsurVO cniCgoClmInsurVO) throws DAOException {        
        try{    
        	
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, Object> velParam = new HashMap<String, Object>();			
			Map<String , String> paramMap = cniCgoClmInsurVO.getColumnValues();		
			
			//디폴트값세팅
			if("".equals(paramMap.get("rcvr_usd_amt"))){
				paramMap.put("rcvr_usd_amt","0");
			}
			if("".equals(paramMap.get("insur_dmnd_usd_amt"))){
				paramMap.put("insur_dmnd_usd_amt","0");
			}
			if("".equals(paramMap.get("insur_dmnd_amt"))){
				paramMap.put("insur_dmnd_amt","0");
			}
			if("".equals(paramMap.get("insur_xch_rt"))){
				paramMap.put("insur_xch_rt","0");
			}
			if("".equals(paramMap.get("insur_rcvr_usd_amt"))){
				paramMap.put("insur_rcvr_usd_amt","0");
			}
			if("".equals(paramMap.get("insur_rcvr_amt"))){
				paramMap.put("insur_rcvr_amt","0");
			}
			if("".equals(paramMap.get("insur_rcvr_xch_rt"))){
				paramMap.put("insur_rcvr_xch_rt","0");
			}
			
			sqlExe.executeUpdate((ISQLTemplate) new InsuranceRecoveryDBDAOAddInsuranceCSQL(), paramMap, velParam);

        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }
       
    }  
    
    /**
	 * Claim Main Insurance 수정<br>
	 * @author 정행룡
	 * @category CPS_CNI_0003
	 * @category modifyClaimMainInsurance 
	 * @param CniCgoClmInsurVO cniCgoClmInsurVO   
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public void modifyClaimMainInsurance(CniCgoClmInsurVO cniCgoClmInsurVO) throws DAOException {        
        try{    
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, Object> velParam = new HashMap<String, Object>();			
			Map<String , String> paramMap = cniCgoClmInsurVO.getColumnValues();	
			sqlExe.executeUpdate((ISQLTemplate) new InsuranceRecoveryDBDAOModifyClaimMainInsuranceUSQL(), paramMap, velParam);
			
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }
       
    } 
	
	
    
}
