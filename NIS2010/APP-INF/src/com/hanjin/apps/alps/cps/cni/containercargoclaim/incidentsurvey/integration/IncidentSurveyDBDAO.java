/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : IncidentSurveyDBDAO.java
*@FileTitle : Container Cargo Claim 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.07
*@LastModifier : 진윤오
*@LastVersion : 1.0
* 2009.04.17 진윤오
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.cni.containercargoclaim.incidentsurvey.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.basic.ClaimMainBCImpl;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.incidentsurvey.vo.CniCgoClmInciVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.incidentsurvey.vo.CniCgoClmSlvVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.incidentsurvey.vo.CniCgoClmSveyVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.incidentsurvey.vo.IncidentClaimInquiryVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.incidentsurvey.vo.IncidentCreationVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.incidentsurvey.vo.IncidentInquiryCondVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.incidentsurvey.vo.IncidentInquiryVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.incidentsurvey.vo.SalvageVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.incidentsurvey.vo.SurveyVO;
import com.hanjin.apps.alps.cps.gem.common.GemUtil;
import com.hanjin.bizcommon.comm.Constants;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.apps.alps.cps.cni.common.CniConst;

/**
 * NIS2010 IncidentSurveyDBDAO <br>
 * - NIS2010-GEMCommon system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author cjm
 * @see ClaimMainBCImpl 참조
 * @since J2EE 1.4
 */
public class IncidentSurveyDBDAO extends DBDAOSupport {

	// ---------------------------------------------------------------------------
	// 공통 SQL
	// ---------------------------------------------------------------------------
	
	//====================================================================================
    // 진윤오
    //====================================================================================

    //====================================================================================
    // 양정란
    //====================================================================================
	// ---------------------------------------------------------------------------
	// [CPS_CNI-0012] Survey
	// ---------------------------------------------------------------------------   
	/**
	 * Survey 조회<br>
	 * @author 양정란
	 * @category CPS_CNI_0012
	 * @category searchCargoClaimSurveyList 
	 * @param String cgoClmNo
     * @return List<SurveyVO> 
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<SurveyVO> searchSurveyInfo(String cgoClmNo) throws DAOException {
        DBRowSet dbRowset = null;
        
        List<SurveyVO> list = null;        
       
        try{    
        	// query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            // velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();
            
        	// 조회조건
        	param.put("cgo_clm_no", cgoClmNo);
        	
        	// velocity parameter 설정 
            velParam.putAll(param);
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new IncidentSurveyDBDAOSearchSurveyInfoRSQL(), param, velParam);
            
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, SurveyVO.class);
                 
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
	 * Survey 체크<br>
	 * @author 양정란
	 * @category CPS_CNI_0012
	 * @category searchSurveyExist 
	 * @param String cgoClmNo
     * @return String[] 
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public String[] searchSurveyExist(String cgoClmNo) throws DAOException {
        DBRowSet dbRowset = null;
        
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
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new IncidentSurveyDBDAOSearchSurveyExistRSQL(), param, velParam);
            returnStr = GemUtil.getArrayString(dbRowset, "EXIST");
            
            log.debug("searchSurveyInfo insert or update check" + returnStr[0]);
            
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
	 * Survey 입력<br>
	 * @author 양정란
	 * @category CPS_CNI_0012
	 * @category addSurvey 
	 * @param CniCgoClmSveyVO cniCgoClmSveyVO
     * @throws DAOException
     */ 
    @SuppressWarnings("unchecked")
    public void addSurvey(CniCgoClmSveyVO cniCgoClmSveyVO) throws DAOException {        
        try{    
        	
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, Object> velParam = new HashMap<String, Object>();			
			Map<String , String> paramMap = cniCgoClmSveyVO.getColumnValues();		
			
			//디폴트값세팅
			if("".equals(paramMap.get("svyr_fee_locl_amt"))){
				paramMap.put("svyr_fee_locl_amt","0");
			}
			if("".equals(paramMap.get("svyr_xch_rt"))){
				paramMap.put("svyr_xch_rt","0");
			}
			if("".equals(paramMap.get("svyr_fee_usd_amt"))){
				paramMap.put("svyr_fee_usd_amt","0");
			}
			
			sqlExe.executeUpdate((ISQLTemplate) new IncidentSurveyDBDAOAddSurveyCSQL(), paramMap, velParam);

        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }
       
    }  
    
	/**
	 * Survey 수정<br>
	 * @author 양정란
	 * @category CPS_CNI_0012
	 * @category modifySurvey 
	 * @param CniCgoClmSveyVO cniCgoClmSveyVO   
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public void modifySurvey(CniCgoClmSveyVO cniCgoClmSveyVO) throws DAOException {        
        try{    
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, Object> velParam = new HashMap<String, Object>();			
			Map<String , String> paramMap = cniCgoClmSveyVO.getColumnValues();	
			
			//디폴트값세팅
			if("".equals(paramMap.get("svyr_fee_locl_amt"))){
				paramMap.put("svyr_fee_locl_amt","0");
			}
			if("".equals(paramMap.get("svyr_xch_rt"))){
				paramMap.put("svyr_xch_rt","0");
			}
			if("".equals(paramMap.get("svyr_fee_usd_amt"))){
				paramMap.put("svyr_fee_usd_amt","0");
			}
	
			sqlExe.executeUpdate((ISQLTemplate) new IncidentSurveyDBDAOModifySurveyUSQL(), paramMap, velParam);
			
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }
       
    } 
    
    /**
	 * Claim Main Survey 수정<br>
	 * @author 정행룡
	 * @category CPS_CNI_0003
	 * @category modifyClaimMainSurvey 
	 * @param CniCgoClmSveyVO cniCgoClmSveyVO   
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public void modifyClaimMainSurvey(CniCgoClmSveyVO cniCgoClmSveyVO) throws DAOException {        
        try{    
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, Object> velParam = new HashMap<String, Object>();			
			Map<String , String> paramMap = cniCgoClmSveyVO.getColumnValues();	
			sqlExe.executeUpdate((ISQLTemplate) new IncidentSurveyDBDAOModifyClaimMainSurveyUSQL(), paramMap, velParam);
			
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }
       
    } 
    
	// ---------------------------------------------------------------------------
	// [CPS_CNI-0013] Salvage
	// ---------------------------------------------------------------------------   
	/**
	 * Salvage 조회<br>
	 * @author 양정란
	 * @category CPS_CNI_0013
	 * @category searchCargoClaimSalvageInfo 
	 * @param String cgoClmNo
     * @return List<SalvageVO> 
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<SalvageVO> searchSalvageInfo(String cgoClmNo) throws DAOException {
        DBRowSet dbRowset = null;
        
        List<SalvageVO> list = null;        
       
        try{    
        	// query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            // velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();
            
        	// 조회조건
        	param.put("cgo_clm_no", cgoClmNo);
        	
        	// velocity parameter 설정 
            velParam.putAll(param);
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new IncidentSurveyDBDAOSearchSalvageInfoRSQL(), param, velParam);
            
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, SalvageVO.class);
                 
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
	 * Salvage 체크<br>
	 * @author 양정란
	 * @category CPS_CNI_0012
	 * @category searchSalvageExist 
	 * @param String cgoClmNo
     * @return String[] 
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public String[] searchSalvageExist(String cgoClmNo) throws DAOException {
        DBRowSet dbRowset = null;
        
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
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new IncidentSurveyDBDAOSearchSalvageExistRSQL(), param, velParam);
            returnStr = GemUtil.getArrayString(dbRowset, "EXIST");
            
            log.debug("searchSalvageInfo insert or update check" + returnStr[0]);
            
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
	 * Salvage 입력<br>
	 * @author 양정란
	 * @category CPS_CNI_0013
	 * @category addSalvage 
	 * @param CniCgoClmSlvVO cniCgoClmSlvVO
     * @throws DAOException
     */ 
    @SuppressWarnings("unchecked")
    public void addSalvage(CniCgoClmSlvVO cniCgoClmSlvVO) throws DAOException {        
        try{    
        	
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, Object> velParam = new HashMap<String, Object>();			
			Map<String , String> paramMap = cniCgoClmSlvVO.getColumnValues();	
			
			//디폴트값세팅
			if("".equals(paramMap.get("slv_locl_amt"))){
				paramMap.put("slv_locl_amt","0");
			}
			if("".equals(paramMap.get("slv_xch_rt"))){
				paramMap.put("slv_xch_rt","0");
			}
			if("".equals(paramMap.get("slv_usd_amt"))){
				paramMap.put("slv_usd_amt","0");
			}
			
			sqlExe.executeUpdate((ISQLTemplate) new IncidentSurveyDBDAOAddSalvageCSQL(), paramMap, velParam);

        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }
       
    }  
    
	/**
	 * Salvage 수정<br>
	 * @author 양정란
	 * @category CPS_CNI_0013
	 * @category modifySalvage 
	 * @param CniCgoClmSlvVO cniSalvageVO   
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public void modifySalvage(CniCgoClmSlvVO cniSalvageVO) throws DAOException {        
        try{    
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, Object> velParam = new HashMap<String, Object>();			
			Map<String , String> paramMap = cniSalvageVO.getColumnValues();	
			
			//디폴트값세팅
			if("".equals(paramMap.get("slv_locl_amt"))){
				paramMap.put("slv_locl_amt","0");
			}
			if("".equals(paramMap.get("slv_xch_rt"))){
				paramMap.put("slv_xch_rt","0");
			}
			if("".equals(paramMap.get("slv_usd_amt"))){
				paramMap.put("slv_usd_amt","0");
			}			
			
			sqlExe.executeUpdate((ISQLTemplate) new IncidentSurveyDBDAOModifySalvageUSQL(), paramMap, velParam);
			
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }
       
    }     
          
	// ---------------------------------------------------------------------------
	// [CPS_CNI-0030] Incident-Creation
	// ---------------------------------------------------------------------------   
	/**
	 * Incident-Creation 조회<br>
	 * @author 양정란
	 * @category CPS_CNI_0030
	 * @category searchIncidentCreationInfo 
	 * @param String cgoClmInciNo
     * @return List<IncidentCreationVO> 
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<IncidentCreationVO> searchIncidentCreationInfo(String cgoClmInciNo) throws DAOException {
        DBRowSet dbRowset = null;
        
        List<IncidentCreationVO> list = null;        
       
        try{    
        	// query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            // velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();
            
        	// 조회조건
        	param.put("cgo_clm_inci_no", cgoClmInciNo);
        	
        	// velocity parameter 설정 
            velParam.putAll(param);
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new IncidentSurveyDBDAOSearchIncidentCreationInfoRSQL(), param, velParam);
            
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, IncidentCreationVO.class);
                 
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
	 * Incident-Creation 체크<br>
	 * @author 양정란
	 * @category CPS_CNI_0030
	 * @category searchIncidentExist 
	 * @param String cgoClmInciNo
     * @return String 
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public String searchIncidentExist(String cgoClmInciNo) throws DAOException {
        DBRowSet dbRowset = null;
        
        String returnStr = "";
       
        try{    
        	// query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            // velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();
            
        	// 조회조건
        	param.put("cgo_clm_inci_no", cgoClmInciNo);
        	
        	// velocity parameter 설정 
            velParam.putAll(param);
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new IncidentSurveyDBDAOSearchIncidentExistRSQL(), param, velParam);
			if (dbRowset.next()) {
            	return dbRowset.getString("EXIST");
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
	 * Location 체크<br>
	 * @author 양정란
	 * @category CPS_CNI_0030
	 * @category searchLocation 
	 * @param String locCd
     * @return String 
     * @throws DAOException
     */
	public String searchLocation(String locCd) throws DAOException {
		String result = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
	
		try{
		
			param.put("loc_cd", locCd);
	
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new IncidentSurveyDBDAOsearchLocationRSQL(), param, null);
	
			while (dbRowset.next()) {
				result = dbRowset.getString("loc_cd");
			}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	} 

    /**
	 * VVD 체크<br>
	 * @author 양정란
	 * @category CPS_CNI_0030
	 * @category searchVesselName 
	 * @param String vslCd
     * @return String 
     * @throws DAOException
     */
	public String searchVesselName(String vslCd) throws DAOException {
		String result = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
	
		try{
		
			param.put("vsl_cd", vslCd);
	
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new IncidentSurveyDBDAOsearchVesselNameRSQL(), param, null);
	
			while (dbRowset.next()) {
				result = dbRowset.getString("vsl_cd");
			}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}	
    
	/**
	 * Claim Inci No 채번<br>
	 * @author 양정란
	 * @category CPS_CNI_0030
	 * @category searchMaxClaimInciNo
	 * @return String
	 * @throws DAOException
	 */
	public String searchMaxClaimInciNo() throws DAOException {
		DBRowSet dbRowset = null;
		try {
			
			// query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            // velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();
        	
        	// velocity parameter 설정 
            velParam.putAll(param);
            
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new IncidentSurveyDBDAOSearchMaxClaimInciNoRSQL(),param, velParam);
			if (dbRowset.next()) {
            	return dbRowset.getString("cgo_clm_inci_no");
            }
			return null;
		} catch(SQLException se){
			log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(),se);
        } catch(Exception ex){
        	log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }
	}    
    
	/**
	 * Incident-Creation 입력<br>
	 * @author 양정란
	 * @category CPS_CNI_0030
	 * @category addIncident 
	 * @param CniCgoClmInciVO cniCgoClmInciVO
     * @throws DAOException
     */ 
    @SuppressWarnings("unchecked")
    public void addIncident(CniCgoClmInciVO cniCgoClmInciVO) throws DAOException {        
        try{    
        	
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, Object> velParam = new HashMap<String, Object>();			
			Map<String , String> paramMap = cniCgoClmInciVO.getColumnValues();	
			
			sqlExe.executeUpdate((ISQLTemplate) new IncidentSurveyDBDAOAddIncidentCSQL(), paramMap, velParam);

        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }
       
    }  
    
	/**
	 * Incident-Creation 수정<br>
	 * @author 양정란
	 * @category CPS_CNI_0030
	 * @category modifyIncident 
	 * @param CniCgoClmInciVO cniCgoClmInciVO   
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public void modifyIncident(CniCgoClmInciVO cniCgoClmInciVO) throws DAOException {        
        try{    
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, Object> velParam = new HashMap<String, Object>();			
			Map<String , String> paramMap = cniCgoClmInciVO.getColumnValues();	
			
			sqlExe.executeUpdate((ISQLTemplate) new IncidentSurveyDBDAOModifyIncidentUSQL(), paramMap, velParam);
			
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }
       
    }  
     
    // ---------------------------------------------------------------------------
    // [CPS_CNI_0031] Incident-Inquiry
    // ---------------------------------------------------------------------------	
	/**
	 * Incident-Inquiry 조회<br>
	 * @author 양정란
	 * @category CPS_CNI_0031
	 * @category searchIncidentInquiryList 
	 * @param IncidentInquiryCondVO incidentInquiryCondVO
     * @return List<IncidentInquiryVO>
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<IncidentInquiryVO> searchIncidentInquiryList(IncidentInquiryCondVO incidentInquiryCondVO) throws DAOException {
        DBRowSet dbRowset = null;
        
        List<IncidentInquiryVO> list = null;        
       
        try{    
        	// query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            // velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();
            
            //param
			String pageNo = incidentInquiryCondVO.getPageNo();
			String schCond = incidentInquiryCondVO.getSchCond();
			String schStr = incidentInquiryCondVO.getSchStr();
			String schArea = incidentInquiryCondVO.getSchArea();
			String schOfcCd = incidentInquiryCondVO.getSchOfcCd();
			String schCreUsrId = incidentInquiryCondVO.getSchCreUsrId();
			String schPlcTpCd = incidentInquiryCondVO.getSchPlcTpCd();
			String schLocCd = incidentInquiryCondVO.getSchLocCd();
			String schDuration = incidentInquiryCondVO.getSchDuration();
			String schToStr = incidentInquiryCondVO.getSchToStr();
			String schFromStr = incidentInquiryCondVO.getSchFromStr();
			
			int currentPage = 0;
			
			if (pageNo != null && !pageNo.equals("")) {
				currentPage = Integer.parseInt(pageNo);
			}
							
			if (currentPage > 0) {
				int startNo     = CniConst.CNI_PAGE_SIZE * (currentPage - 1) + 1;
				int endNo       = CniConst.CNI_PAGE_SIZE * currentPage;					
				param.put("start_page", startNo);
				param.put("end_page", endNo);	
			}
			if (pageNo.equals("")) {//print시 2000건 
				param.put("start_page", 1);
				param.put("end_page", 2000);
			} 
		            
        	// 조회조건
        	param.put("sch_cond", schCond);
        	param.put("sch_str", schStr);
        	param.put("sch_area", schArea);
        	param.put("sch_ofc_cd", schOfcCd);
        	param.put("sch_cre_usr_id", schCreUsrId);
        	param.put("sch_plc_tp_cd", schPlcTpCd);
        	param.put("sch_loc_cd", schLocCd);
        	param.put("sch_duration", schDuration);
        	param.put("sch_from_str", schFromStr);
        	param.put("sch_to_str", schToStr);
        	
        	// velocity parameter 설정 
            velParam.putAll(param);
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new IncidentSurveyDBDAOSearchIncidentInquiryListRSQL(), param, velParam);
            
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, IncidentInquiryVO.class);
                 
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
    // [CPS_CNI_0032] Incident-Claim Inquiry
    // ---------------------------------------------------------------------------	
	/**
	 * Incident-Claim Inquiry 조회<br>
	 * @author 양정란
	 * @category CPS_CNI_0032
	 * @category searchIncidentClaimInquiryList 
	 * @param String cgoClmInciNo
	 * @param String pageNo
     * @return List<IncidentClaimInquiryVO>
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<IncidentClaimInquiryVO> searchIncidentClaimInquiryList(String cgoClmInciNo, String pageNo) throws DAOException {
        DBRowSet dbRowset = null;
        
        List<IncidentClaimInquiryVO> list = null;        
       
        try{    
        	// query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            // velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();
            
            //param
            
			int currentPage = 0;
			
			if (pageNo != null && !pageNo.equals("")) {
				currentPage = Integer.parseInt(pageNo);
			}
							
			if (currentPage > 0) {
				int startNo     = CniConst.CNI_PAGE_SIZE * (currentPage - 1) + 1;
				int endNo       = CniConst.CNI_PAGE_SIZE * currentPage;					
				param.put("start_page", startNo);
				param.put("end_page", endNo);	
			}
			if (pageNo.equals("")) {//print시 2000건 
				param.put("start_page", 1);
				param.put("end_page", 2000);
			} 
		            
        	// 조회조건
        	param.put("cgo_clm_inci_no", cgoClmInciNo);

        	
        	// velocity parameter 설정 
            velParam.putAll(param);
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new IncidentSurveyDBDAOSearchIncidentClaimInquiryListRSQL(), param, velParam);
            
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, IncidentClaimInquiryVO.class);
                 
            return list;
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }
       
    }      
    
}
