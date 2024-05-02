/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ClaimMainDBDAO.java
*@FileTitle : Container Cargo Claim 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.07
*@LastModifier : 진윤오
*@LastVersion : 1.0
* 2009.04.17 진윤오
* 1.0 Creation
-----------------------------------------------------------
 * History 
 * 2011.02.16 이준범 CRM Call 삭제 
=========================================================*/
package com.clt.apps.opus.cps.cni.containercargoclaim.claimmain.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.cps.cni.common.CniConst;
import com.clt.apps.opus.cps.cni.containercargoclaim.claimmain.basic.ClaimMainBCImpl;
import com.clt.apps.opus.cps.cni.containercargoclaim.claimmain.vo.BlGetVO;
import com.clt.apps.opus.cps.cni.containercargoclaim.claimmain.vo.BookingNoVO;
import com.clt.apps.opus.cps.cni.containercargoclaim.claimmain.vo.ClaimMainVO;
import com.clt.apps.opus.cps.cni.containercargoclaim.claimmain.vo.CniAreaOfcVO;
import com.clt.apps.opus.cps.cni.containercargoclaim.claimmain.vo.CniCgoClmBlDtlVO;
import com.clt.apps.opus.cps.cni.containercargoclaim.claimmain.vo.CniCgoClmCntrDtlVO;
import com.clt.apps.opus.cps.cni.containercargoclaim.claimmain.vo.CniCgoClmCostVO;
import com.clt.apps.opus.cps.cni.containercargoclaim.claimmain.vo.CniCgoClmCtrtVO;
import com.clt.apps.opus.cps.cni.containercargoclaim.claimmain.vo.CniCgoClmLtgtVO;
import com.clt.apps.opus.cps.cni.containercargoclaim.claimmain.vo.CniCgoClmTrnsVO;
import com.clt.apps.opus.cps.cni.containercargoclaim.claimmain.vo.CniCgoClmVO;
import com.clt.apps.opus.cps.cni.containercargoclaim.claimmain.vo.ContractCarriageVO;
import com.clt.apps.opus.cps.cni.containercargoclaim.claimmain.vo.FindCondVO;
import com.clt.apps.opus.cps.cni.containercargoclaim.claimmain.vo.FindVO;
import com.clt.apps.opus.cps.cni.containercargoclaim.claimmain.vo.HandlingCostInfoVO;
import com.clt.apps.opus.cps.cni.containercargoclaim.claimmain.vo.HandlingCostVO;
import com.clt.apps.opus.cps.cni.containercargoclaim.claimmain.vo.ImpendingTBIndemnityClaimVO;
import com.clt.apps.opus.cps.cni.containercargoclaim.claimmain.vo.ImpendingTBMainClaimVO;
import com.clt.apps.opus.cps.cni.containercargoclaim.claimmain.vo.PaymentVO;
import com.clt.apps.opus.cps.cni.containercargoclaim.claimmain.vo.TransferCondVO;
import com.clt.apps.opus.cps.cni.containercargoclaim.claimmain.vo.TransferVO;
import com.clt.apps.opus.cps.cni.containercargoclaim.incidentsurvey.integration.ClaimMainDBDAOModifySurveyUsdAmtUSQL;
import com.clt.apps.opus.cps.cni.containercargoclaim.settlementclaim.vo.ApplicationStatusVO;
import com.clt.apps.opus.cps.gem.common.GemUtil;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;


/**
 * ClaimMainDBDAO <br>
 * Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author clt
 * @see ClaimMainBCImpl 참조
 * @since J2EE 1.4
 */
public class ClaimMainDBDAO extends DBDAOSupport {

	// ---------------------------------------------------------------------------
	// 공통 SQL
	// ---------------------------------------------------------------------------

	
	
	//====================================================================================
    // 진윤오
    //====================================================================================
	// ---------------------------------------------------------------------------
	// [COM005_R001] GW 웹서비스 승인정보 수신
	// ---------------------------------------------------------------------------	
	
	/**
	 * GW 웹서비스 승인정보 수신시 카고클레임 정보 취득<br>
	 * @author 진윤오
	 * @category COM005_R001
	 * @category searchCargoClaim 
	 * @param String cgoClmNo
	 * @return CniCgoClmVO
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public CniCgoClmVO searchCargoClaim(String cgoClmNo) throws DAOException {        
        	
        DBRowSet dbRowset = null;
        
        List<CniCgoClmVO> list = null;     
       
        try{    
        	// query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            // velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();
            
        	param.put("cgo_clm_no", cgoClmNo);
        	// velocity parameter 설정 
            velParam.putAll(param);
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ClaimMainDBDAOSearchCargoClaimRSQL(), param, velParam);
            
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, CniCgoClmVO.class);
                 
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
	 * Gw Status 정보 수정 EAI에서 수신<br>
	 * @author 진윤오
	 * @category COM005R001
	 * @param CniCgoClmVO cniCgoClmVO
     * @throws DAOException
     */
    public void modifyAppliedStatus(CniCgoClmVO cniCgoClmVO) throws DAOException {        
        try{    
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, Object> velParam = new HashMap<String, Object>();			
			Map<String , String> paramMap = cniCgoClmVO.getColumnValues();	
			velParam.putAll(paramMap);
			
			sqlExe.executeUpdate((ISQLTemplate) new ClaimMainDBDAOModifyAppliedStatusUSQL(), paramMap, velParam);
						
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }
       
    }    
    
	// ---------------------------------------------------------------------------
	// [CPS_CNI_0001] Client Default Setup
	// ---------------------------------------------------------------------------	
	/**
	 * Area Office 추가<br>
	 * @author 진윤오
	 * @category CPS_CNI_0001
	 * @category addAreaOfc 
	 * @param CniAreaOfcVO cniAreaOfcVO
     * @throws DAOException
     */
    public void addAreaOfc(CniAreaOfcVO cniAreaOfcVO) throws DAOException {        
        try{    
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, Object> velParam = new HashMap<String, Object>();			
			Map<String , String> paramMap = cniAreaOfcVO.getColumnValues();			
			sqlExe.executeUpdate((ISQLTemplate) new ClaimMainDBDAOAddAreaOfcCSQL(), paramMap, velParam);            
        } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
       
    }  
    
	/**
	 * Area Office 수정<br>
	 * @author 진윤오
	 * @category CPS_CNI_0001
	 * @category modifyAreaOfc 
	 * @param CniAreaOfcVO cniAreaOfcVO
     * @throws DAOException
     */
    public void modifyAreaOfc(CniAreaOfcVO cniAreaOfcVO) throws DAOException {        
        try{    
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, Object> velParam = new HashMap<String, Object>();			
			Map<String , String> paramMap = cniAreaOfcVO.getColumnValues();			
			sqlExe.executeUpdate((ISQLTemplate) new ClaimMainDBDAOModifyAreaOfcUSQL(), paramMap, velParam);            
        } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
       
    }  
    
	// ---------------------------------------------------------------------------
	// [CPS_CNI_0043] Impending TB Claim
	// ---------------------------------------------------------------------------	
	/**
	 * Impending TB Main Claim  조회<br>
	 * @author 진윤오
	 * @category CPS_CNI_0043
	 * @category searchImpendingTBMainClaimList 
	 * @param String usrId 로그인 사용자
	 * @param String condFor 검색 조건 1,2,3,4
     * @return List<ImpendingTBMainClaimVO>
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<ImpendingTBMainClaimVO> searchImpendingTBMainClaimList(String usrId , String condFor) throws DAOException {
        DBRowSet dbRowset = null;
        
        List<ImpendingTBMainClaimVO> list = null;        
       
        try{    
        	// query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            // velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();
            
        	param.put("usr_id", usrId);
        	param.put("cond_for", condFor);
        	
        	// velocity parameter 설정 
            velParam.putAll(param);
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ClaimMainDBDAOSearchImpendingTBMainClaimListRSQL(), param, velParam);
            
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, ImpendingTBMainClaimVO.class);
                 
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
	 * Impending TB Main Claim  조회<br>
	 * @author 진윤오
	 * @category CPS_CNI_0043
	 * @category searchImpendingTBIndemnityClaimList 
	 * @param String usrId 로그인 사용자
	 * @param String condFor 검색 조건 1,2,3,4
     * @return List<ImpendingTBIndemnityClaimVO>
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<ImpendingTBIndemnityClaimVO> searchImpendingTBIndemnityClaimList(String usrId , String condFor) throws DAOException {
        DBRowSet dbRowset = null;
        
        List<ImpendingTBIndemnityClaimVO> list = null;        
       
        try{    
        	// query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            // velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();
            
        	param.put("usr_id", usrId);
        	param.put("cond_for", condFor);
        	
        	// velocity parameter 설정 
            velParam.putAll(param);
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ClaimMainDBDAOSearchImpendingTBIndemnityClaimListRSQL(), param, velParam);
            
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, ImpendingTBIndemnityClaimVO.class);
                 
            return list;
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }
       
    }     
    
    //====================================================================================
    // 정행룡
    //====================================================================================
	// ---------------------------------------------------------------------------
	// [CPS_CNI-0003] Claim Main
	// ---------------------------------------------------------------------------    
    
    /**
	 * Claim No 존재 여부 확인<br>
	 * @author 정행룡
	 * @category CPS_CNI_0003
	 * @category searchClaimExist 
	 * @param String cgoClmNo
	 * @param String tableName
     * @return String
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public String  searchClaimExist(String cgoClmNo, String tableName) throws DAOException {
    	DBRowSet dbRowset = null;
        
        String retExist = null;        
       
        try{    
        	// query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            // velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();
            
        	//  Cargo Claim No
        	param.put("cgo_clm_no", cgoClmNo);
        	velParam.put("table_name", tableName);
        	
        	// velocity parameter 설정 
            velParam.putAll(param);
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ClaimMainDBDAOSearchClaimExistRSQL(), param, velParam);
            
            if (dbRowset.next()) {
            	retExist =  dbRowset.getString("chk_exist");
            }
            
            return retExist;
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }
       
    } 
       
	/**
	 * Claim Main 조회<br>
	 * @author 정행룡
	 * @category CPS_CNI_0003
	 * @category searchClaimMain 
	 * @param String cgoClmNo
     * @return ClaimMainVO 
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public ClaimMainVO searchClaimMain(String cgoClmNo) throws DAOException {
    	DBRowSet dbRowset = null;
        
        List<ClaimMainVO> list = null;        
       
        try{    
        	// query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            // velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();
            
        	//  Cargo Claim No
        	param.put("cgo_clm_no", cgoClmNo);
        	
        	// velocity parameter 설정 
            velParam.putAll(param);
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ClaimMainDBDAOSearchClaimMainRSQL(), param, velParam);
            
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, ClaimMainVO.class);
            
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
	 * B/L 정보 조회<br>
	 * @author 정행룡
	 * @category CPS_CNI_0003
	 * @category searchBlGet
	 * @param String cgoClmRefBlNo
     * @return BlGetVO 
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public BlGetVO searchBlGet(String cgoClmRefBlNo) throws DAOException {
    	DBRowSet dbRowset = null;
        
        List<BlGetVO> list = null;        
       
        try{    
        	// query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            // velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();
            
        	// B/L
        	param.put("cgo_clm_ref_bl_no", cgoClmRefBlNo);
        	
        	// velocity parameter 설정 
            velParam.putAll(param);
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ClaimMainDBDAOSearchBlGetRSQL(), param, velParam);
            
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, BlGetVO.class);
            
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
	 * Area Cd 조회<br>
	 * @author 정행룡
	 * @category CPS_CNI_0003
	 * @category searchAreaCd
	 * @param ofcCd Office Cd
     * @return Area Cd 정보 
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public CniAreaOfcVO searchAreaCd(String ofcCd) throws DAOException {
    	DBRowSet dbRowset = null;
        
        List<CniAreaOfcVO> list = null;        
       
        try{    
        	// query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            // velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();
            
        	//  Cargo Claim No
        	param.put("ofc_cd", ofcCd);
        	
        	// velocity parameter 설정 
            velParam.putAll(param);
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ClaimMainDBDAOSearchAreaCdRSQL(), param, velParam);
            
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, CniAreaOfcVO.class);
            
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
	 * Claim No 채번<br>
	 * @author 정행룡
	 * @category CPS_CNI_0003
	 * @category searchMaxClaimNo
	 * @return String
	 * @throws DAOException
	 */
	public String searchMaxClaimNo() throws DAOException {
		DBRowSet dbRowset = null;
		try {
			
			// query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            // velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();
        	
        	// velocity parameter 설정 
            velParam.putAll(param);
            
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ClaimMainDBDAOSearchMaxClaimNoRSQL(),param, velParam);
			if (dbRowset.next()) {
            	return dbRowset.getString("cgo_clm_no");
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
	 * Bl No Check<br>
	 * @author 정행룡
	 * @category CPS_CNI_0003
	 * @category searchBlGetChk
	 * @param String cgoClmRefBlNo
	 * @return String
	 * @throws DAOException
	 */
	public String searchBlGetChk(String cgoClmRefBlNo) throws DAOException {
		DBRowSet dbRowset = null;
		try {
			
			// query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            // velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();
        	
         // B/L
        	param.put("cgo_clm_ref_bl_no", cgoClmRefBlNo);
        	
        	// velocity parameter 설정 
            velParam.putAll(param);
            
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ClaimMainDBDAOSearchBlGetChkRSQL(),param, velParam);
			if (dbRowset.next()) {
            	return dbRowset.getString("cgo_clm_ref_bl_no");
            }
			return "";
		} catch(SQLException se){
			log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(),se);
        } catch(Exception ex){
        	log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }
	}
	
	/**
	 * Claim Main 추가<br>
	 * @author 정행룡
	 * @category CPS_CNI_0003
	 * @category addClaimMain
	 * @param CniCgoClmVO cniCgoClmVO
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public void addClaimMain(CniCgoClmVO cniCgoClmVO) throws DAOException {        
        try{    
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, Object> velParam = new HashMap<String, Object>();			
			Map<String , String> paramMap = cniCgoClmVO.getColumnValues();
			
			String trnsFlag       = cniCgoClmVO.getTrnsFlg();
			String cgoClmCxlFlg   = cniCgoClmVO.getCgoClmCxlFlg();
			String csClzRopnFlg   = cniCgoClmVO.getCsClzRopnFlg();
			String cgoClmSuitFlg  = cniCgoClmVO.getCgoClmSuitFlg();
			String clmtUsdAmt     = cniCgoClmVO.getClmtUsdAmt();
			String clmtLoclAmt    = cniCgoClmVO.getClmtLoclAmt();
			String clmtLoclXchRt  = cniCgoClmVO.getClmtLoclXchRt();
			
			if ((trnsFlag == null) || "".equals(trnsFlag)){
				paramMap.put("trns_flg", "N");
			}
			if ((cgoClmCxlFlg == null) || "".equals(cgoClmCxlFlg)){
				paramMap.put("cgo_clm_cxl_flg", "N");
			}
			if ((csClzRopnFlg == null) || "".equals(csClzRopnFlg)){
				paramMap.put("cs_clz_ropn_flg", "N");
			}
			if ((cgoClmSuitFlg == null) || "".equals(cgoClmSuitFlg)){
				paramMap.put("cgo_clm_suit_flg", "N");
			}
			if ((clmtUsdAmt == null) || "".equals(clmtUsdAmt)){
				paramMap.put("clmt_usd_amt", "0");
			}
			if ((clmtLoclAmt == null) || "".equals(clmtLoclAmt)){
				paramMap.put("clmt_locl_amt", "0");
			}
			if ((clmtLoclXchRt == null) || "".equals(clmtLoclXchRt)){
				paramMap.put("clmt_locl_xch_rt", "0");
			}
			
			sqlExe.executeUpdate((ISQLTemplate) new ClaimMainDBDAOAddClaimMainCSQL(), paramMap, velParam);   
			
        } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
    } 
    
    /**
	 * Claim Main 수정<br>
	 * @author 정행룡
	 * @category CPS_CNI_0003
	 * @category modifyClaimMain
	 * @param CniCgoClmVO cniCgoClmVO
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public void modifyClaimMain(CniCgoClmVO cniCgoClmVO) throws DAOException {        
        try{    
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, Object> velParam = new HashMap<String, Object>();			
			Map<String , String> paramMap = cniCgoClmVO.getColumnValues();
			
			String trnsFlag       = cniCgoClmVO.getTrnsFlg();
			String cgoClmCxlFlg   = cniCgoClmVO.getCgoClmCxlFlg();
			String csClzRopnFlg   = cniCgoClmVO.getCsClzRopnFlg();
			String cgoClmSuitFlg  = cniCgoClmVO.getCgoClmSuitFlg();
			String clmtUsdAmt     = cniCgoClmVO.getClmtUsdAmt();
			String clmtLoclAmt    = cniCgoClmVO.getClmtLoclAmt();
			String clmtLoclXchRt  = cniCgoClmVO.getClmtLoclXchRt();
			
			if ((trnsFlag == null) || "".equals(trnsFlag)){
				paramMap.put("trns_flg", "N");
			}
			if ((cgoClmCxlFlg == null) || "".equals(cgoClmCxlFlg)){
				paramMap.put("cgo_clm_cxl_flg", "N");
			}
			if ((csClzRopnFlg == null) || "".equals(csClzRopnFlg)){
				paramMap.put("cs_clz_ropn_flg", "N");
			}
			if ((cgoClmSuitFlg == null) || "".equals(cgoClmSuitFlg)){
				paramMap.put("cgo_clm_suit_flg", "N");
			}
			if ((clmtUsdAmt == null) || "".equals(clmtUsdAmt)){
				paramMap.put("clmt_usd_amt", "0");
			}
			if ((clmtLoclAmt == null) || "".equals(clmtLoclAmt)){
				paramMap.put("clmt_locl_amt", "0");
			}
			if ((clmtLoclXchRt == null) || "".equals(clmtLoclXchRt)){
				paramMap.put("clmt_locl_xch_rt", "0");
			}
			
			sqlExe.executeUpdate((ISQLTemplate) new ClaimMainDBDAOModifyClaimMainUSQL(), paramMap, velParam);            
        } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
    }
    /**
	 * Claim Status 변경<br>
	 * @author 정행룡
	 * @category CPS_CNI_0003
	 * @category modifyClaimStatus
	 * @param CniCgoClmVO cniCgoClmVO
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public void modifyClaimStatus(CniCgoClmVO cniCgoClmVO) throws DAOException {        
        try{    
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, Object> velParam = new HashMap<String, Object>();			
			Map<String , String> paramMap = cniCgoClmVO.getColumnValues();
			velParam.put("cgo_clm_sts_cd", cniCgoClmVO.getCgoClmStsCd());  	
			sqlExe.executeUpdate((ISQLTemplate) new ClaimMainDBDAOModifyClaimStatusUSQL(), paramMap, velParam);            
        } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
    }
    
    /**
	 * Claim ReOpen 변경<br>
	 * @author 정행룡
	 * @category CPS_CNI_0003
	 * @category modifyClaimReOpen
	 * @param String cgoClmNo
	 * @param String updUsrId 
	 * @param String cgoClmStlTpCd
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public void modifyClaimReOpen(String cgoClmNo , String updUsrId , String cgoClmStlTpCd ) throws DAOException {        
        try{    
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, Object> velParam = new HashMap<String, Object>();			
			Map<String , String> paramMap = new HashMap<String , String>();
			paramMap.put("cgo_clm_no", cgoClmNo);
			paramMap.put("upd_usr_id", updUsrId);
			velParam.put("cgo_clm_stl_tp_cd", cgoClmStlTpCd);
			sqlExe.executeUpdate((ISQLTemplate) new ClaimMainDBDAOModifyClaimReOpenUSQL(), paramMap, velParam);            
        } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
    }
    
    /**
	 * Transfer Claim Main수정<br>
	 * @author 양정란
	 * @category CPS_CNI_0036
	 * @category modifyTransferClaimMain
	 * @param String cgoClmNo
	 * @param String updUsrId
	 * @param String hdlrUsrId
	 * @param String hdlrOfcCd
	 * @param String clmTrnsAuthCd
	 * @throws DAOException
	 */
    @SuppressWarnings("unchecked")
    public void modifyTransferClaimMain(String cgoClmNo , String updUsrId , String hdlrUsrId, String hdlrOfcCd, String clmTrnsAuthCd) throws DAOException {    	  
		
        try{    
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, Object> velParam = new HashMap<String, Object>();			
			Map<String , String> paramMap = new HashMap<String , String>();			
			paramMap.put("cgo_clm_no", cgoClmNo);
			paramMap.put("upd_usr_id", updUsrId);
			paramMap.put("hdlr_usr_id", hdlrUsrId);
			paramMap.put("hdlr_ofc_cd", hdlrOfcCd);
			
			if(clmTrnsAuthCd.equals("A")){//Accepted 면 Claim Main 에 Update
				sqlExe.executeUpdate((ISQLTemplate) new ClaimMainDBDAOModifyTransferClaimMainUSQL(), paramMap, velParam);
			}
			
        } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
    	
    }    
    
    /**
	 * Claim Status 이전 단계 변경<br>
	 * @author 진윤오
	 * @category CPS_CNI_0003
	 * @category modifyClaimPreStatus
	 * @param String cgoClmNo
	 * @param String updUsrId 
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public void modifyClaimPreStatus(String cgoClmNo , String updUsrId) throws DAOException {        
        try{    
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, Object> velParam = new HashMap<String, Object>();			
			Map<String , String> paramMap = new HashMap<String , String>();
			paramMap.put("cgo_clm_no", cgoClmNo);
			paramMap.put("upd_usr_id", updUsrId);
			
			sqlExe.executeUpdate((ISQLTemplate) new ClaimMainDBDAOModifyClaimPreStatusUSQL(), paramMap, velParam);            
        } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
    }    
    
    
    /**
	 * Claim Status 취득<br>
	 * @author 진윤오
	 * @category CPS_CNI_0003
	 * @category searchClaimStatus
	 * @param String cgoClmNo 
	 * @return String
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public String searchClaimStatus(String cgoClmNo) throws DAOException {        

    	DBRowSet dbRowset = null;
        
        try{    
        	// query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            // velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();
            
        	//  Cargo Claim No
            param.put("cgo_clm_no", cgoClmNo);
        	
        	// velocity parameter 설정 
            velParam.putAll(param);
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ClaimMainDBDAOSearchClaimStatusRSQL(), param, velParam);
            
            if (dbRowset.next()) {
            	 return  dbRowset.getString(1);
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
	 * Claim Litigation 추가<br>
	 * @author 정행룡
	 * @category CPS_CNI_0003
	 * @category addClaimLitigation
	 * @param CniCgoClmLtgtVO cniCgoClmLtgtVO
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public void addClaimLitigation(CniCgoClmLtgtVO cniCgoClmLtgtVO) throws DAOException {        
        try{    
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, Object> velParam = new HashMap<String, Object>();			
			Map<String , String> paramMap = cniCgoClmLtgtVO.getColumnValues();
			
			sqlExe.executeUpdate((ISQLTemplate) new ClaimMainDBDAOAddClaimLitigationCSQL(), paramMap, velParam);   
			
        } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
    } 
    
    /**
	 * Claim Litigation  수정<br>
	 * @author 정행룡
	 * @category CPS_CNI_0003
	 * @category modifyClaimLitigation
	 * @param CniCgoClmLtgtVO cniCgoClmLtgtVO
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public void modifyClaimLitigation(CniCgoClmLtgtVO cniCgoClmLtgtVO) throws DAOException {        
        try{    
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, Object> velParam = new HashMap<String, Object>();			
			Map<String , String> paramMap = cniCgoClmLtgtVO.getColumnValues();

			sqlExe.executeUpdate((ISQLTemplate) new ClaimMainDBDAOModifyClaimLitigationUSQL(), paramMap, velParam);            
        } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
    } 
    
    /**
	 * Claim Contract 추가<br>
	 * @author 정행룡
	 * @category CPS_CNI_0003
	 * @category addContractCarriage
	 * @param CniCgoClmCtrtVO cniCgoClmCtrtVO
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public void addContractCarriage(CniCgoClmCtrtVO cniCgoClmCtrtVO) throws DAOException {        
        try{    
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, Object> velParam = new HashMap<String, Object>();			
			Map<String , String> paramMap = cniCgoClmCtrtVO.getColumnValues();
			
			String clmOfrtFlg  = cniCgoClmCtrtVO.getClmOfrtFlg();
			if ((clmOfrtFlg == null) || "".equals(clmOfrtFlg)){
				paramMap.put("clm_ofrt_flg", "N");
			}
			String clmOfrtAmt  = cniCgoClmCtrtVO.getClmOfrtAmt();
			if ((clmOfrtAmt == null) || "".equals(clmOfrtAmt)){
				paramMap.put("clm_ofrt_amt", "0");
			}
			sqlExe.executeUpdate((ISQLTemplate) new ClaimMainDBDAOAddContractCarriageCSQL(), paramMap, velParam);   
			
        } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
    }
    
    /**
	 * Claim Main Contract 수정<br>
	 * @author 정행룡
	 * @category CPS_CNI_0003
	 * @category modifyClaimMainContractCarriage
	 * @param CniCgoClmCtrtVO cniCgoClmCtrtVO
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public void modifyClaimMainContractCarriage(CniCgoClmCtrtVO cniCgoClmCtrtVO) throws DAOException {        
        try{    
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, Object> velParam = new HashMap<String, Object>();			
			Map<String , String> paramMap = cniCgoClmCtrtVO.getColumnValues();
			
			String clmOfrtFlg  = cniCgoClmCtrtVO.getClmOfrtFlg();
			if ((clmOfrtFlg == null) || "".equals(clmOfrtFlg)){
				paramMap.put("clm_ofrt_flg", "N");
			}
			String clmOfrtAmt  = cniCgoClmCtrtVO.getClmOfrtAmt();
			if ((clmOfrtAmt == null) || "".equals(clmOfrtAmt)){
				paramMap.put("clm_ofrt_amt", "0");
			}
			
			sqlExe.executeUpdate((ISQLTemplate) new ClaimMainDBDAOModifyClaimMainContractCarriageUSQL(), paramMap, velParam);            
        } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
    } 
    
    /**
	 * Claim BL Detail 추가<br>
	 * @author 정행룡
	 * @category CPS_CNI_0003
	 * @category addBlDetail
	 * @param CniCgoClmBlDtlVO cniCgoClmBlDtlVO
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public void addBlDetail(CniCgoClmBlDtlVO cniCgoClmBlDtlVO) throws DAOException {        
        try{    
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, Object> velParam = new HashMap<String, Object>();			
			Map<String , String> paramMap = cniCgoClmBlDtlVO.getColumnValues();
			
			String mnBlFlg  = cniCgoClmBlDtlVO.getMnBlFlg();
			
			if ((mnBlFlg == null) || "".equals(mnBlFlg)){
				paramMap.put("mn_bl_flg", "Y");
			}
			
			sqlExe.executeUpdate((ISQLTemplate) new ClaimMainDBDAOAddClaimBlDetailCSQL(), paramMap, velParam);   
			
        } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
    } 
    
    /**
	 * Claim BL Detail 수정<br>
	 * @author 정행룡
	 * @category CPS_CNI_0003
	 * @category modifyBlDetail
	 * @param CniCgoClmBlDtlVO cniCgoClmBlDtlVO
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public void modifyBlDetail(CniCgoClmBlDtlVO cniCgoClmBlDtlVO) throws DAOException {        
        try{    
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, Object> velParam = new HashMap<String, Object>();			
			Map<String , String> paramMap = cniCgoClmBlDtlVO.getColumnValues();
			
			String mnBlFlg  = cniCgoClmBlDtlVO.getMnBlFlg();
			if ((mnBlFlg == null) || "".equals(mnBlFlg)){
				paramMap.put("mn_bl_flg", "Y");
			}
			sqlExe.executeUpdate((ISQLTemplate) new ClaimMainDBDAOModifyClaimBlDetailUSQL(), paramMap, velParam);            
        } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
    }
    
	//====================================================================================
    // 양정란
    //====================================================================================
	
    // ---------------------------------------------------------------------------
    // [CPS_CNI_0002] Find
    // ---------------------------------------------------------------------------	
	/**
	 * Find 조회<br>
	 * @author 양정란
	 * @category CPS_CNI_0002
	 * @category searchFindList 
	 * @param FindCondVO FindCondVO
     * @return List<FindVO>
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<FindVO> searchFindList(FindCondVO findCondVO) throws DAOException {
        DBRowSet dbRowset = null;
        
        List<FindVO> list = null;        
       
        try{    
        	// query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            // velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();
            
            //param
			String pageNo = findCondVO.getPageNo();
			String schCond = findCondVO.getSchCond();
			String schStr = findCondVO.getSchStr();
			String miscCd = findCondVO.getMiscCd();
			String vt = findCondVO.getVt();
			
			int currentPage = 0;
			
			if (!"".equals(pageNo)) {
				currentPage = Integer.parseInt(pageNo);
			}
							
			if (currentPage > 0) {
				int startNo     = CniConst.CNI_PAGE_SIZE * (currentPage - 1) + 1;
				int endNo       = CniConst.CNI_PAGE_SIZE * currentPage;					
				param.put("start_page", startNo);
				param.put("end_page", endNo);	
			}
			if ("".equals(pageNo)) {//print시 2000건 
				param.put("start_page", 1);
				param.put("end_page", 2000);
			} 
			            
        	// 조회조건
        	param.put("sch_cond", schCond);
        	param.put("sch_str", schStr);
        	param.put("misc_cd", miscCd);
        	param.put("vt", vt);
        	
        	// velocity parameter 설정 
            velParam.putAll(param);
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ClaimMainDBDAOSearchFindListRSQL(), param, velParam);
            
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, FindVO.class);
                 
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
    // [CPS_CNI_0036] Transfer
    // ---------------------------------------------------------------------------	
	/**
	 * Transfer 조회<br>
	 * @author 양정란
	 * @category CPS_CNI_0036
	 * @category searchTransferList 
	 * @param TransferCondVO transferCondVO
     * @return List<TransferVO>
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<TransferVO> searchTransferList(TransferCondVO transferCondVO) throws DAOException {
        DBRowSet dbRowset = null;
        
        List<TransferVO> list = null;        
       
        try{    
        	// query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            // velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();
            
            //param
			String pageNo = transferCondVO.getPageNo();
			String schOfcCd = transferCondVO.getSchOfcCd();
			String schUsrId = transferCondVO.getSchUsrId();
			String schDateDiv = transferCondVO.getSchDateDiv();
			String schDateFrom = transferCondVO.getSchDateFrom();
			String schDateTo = transferCondVO.getSchDateTo();
			String schTrnsAuthCd = transferCondVO.getSchTrnsAuthCd();
			
			int currentPage = 0;
			
			if (!"".equals(pageNo)) {
				currentPage = Integer.parseInt(pageNo);
			}
							
			if (currentPage > 0) {
				int startNo     = CniConst.CNI_PAGE_SIZE * (currentPage - 1) + 1;
				int endNo       = CniConst.CNI_PAGE_SIZE * currentPage;					
				param.put("start_page", startNo);
				param.put("end_page", endNo);	
			}
			if ("".equals(pageNo)) {//print시 2000건 
				param.put("start_page", 1);
				param.put("end_page", 2000);
			} 
			            
        	// 조회조건
        	param.put("sch_ofc_cd", schOfcCd);
        	param.put("sch_usr_id", schUsrId);
        	param.put("sch_date_div", schDateDiv);
        	param.put("sch_date_from", schDateFrom);
        	param.put("sch_date_to", schDateTo);
        	param.put("sch_trns_auth_cd", schTrnsAuthCd);
        	
        	// velocity parameter 설정 
            velParam.putAll(param);
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ClaimMainDBDAOSearchTransferListRSQL(), param, velParam);
            
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, TransferVO.class);
                 
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
	 * Transfer 수정<br>
	 * @author 양정란
	 * @category CPS_CNI_0036
	 * @category modifyTransfer
	 * @param TransferVO transferVO
	 * @throws DAOException
	 */
    @SuppressWarnings("unchecked")
    public void modifyTransfer(TransferVO transferVO) throws DAOException {    	  
		
        try{    
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, Object> velParam = new HashMap<String, Object>();			
			Map<String , String> paramMap = transferVO.getColumnValues();			
			sqlExe.executeUpdate((ISQLTemplate) new ClaimMainDBDAOModifyTransferUSQL(), paramMap, velParam);  
			
			if(transferVO.getClmTrnsAuthCd().equals("A")){//Accepted 면 Claim Main 에 Update.
				sqlExe.executeUpdate((ISQLTemplate) new ClaimMainDBDAOModifyClaimMainTrnsFlgUSQL(), paramMap, velParam);  
			}
			
        } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
    	
    }    
    
    /**
	 * Claim Main Transfer 등록<br>
	 * @author 양정란
	 * @category CPS_CNI_0036
	 * @category AddTransfer
	 * @param CniCgoClmTrnsVO cniCgoClmTrnsVO
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public void addTransfer(CniCgoClmTrnsVO cniCgoClmTrnsVO) throws DAOException {        
        try{    
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, Object> velParam = new HashMap<String, Object>();			
			Map<String , String> paramMap = cniCgoClmTrnsVO.getColumnValues();

			sqlExe.executeUpdate((ISQLTemplate) new ClaimMainDBDAOAddTransferCSQL(), paramMap, velParam);            
        } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
    }
    
    /**
	 * Claim Main Transfer 삭제<br>
	 * @author 양정란
	 * @category CPS_CNI_0036
	 * @category removeTransfer
	 * @param CniCgoClmTrnsVO cniCgoClmTrnsVO
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public void removeTransfer(CniCgoClmTrnsVO cniCgoClmTrnsVO) throws DAOException {        
        try{    
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, Object> velParam = new HashMap<String, Object>();			
			Map<String , String> paramMap = cniCgoClmTrnsVO.getColumnValues();

			sqlExe.executeUpdate((ISQLTemplate) new ClaimMainDBDAORemoveTransferDSQL(), paramMap, velParam);            
        } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
    }
    
    // ---------------------------------------------------------------------------
    // [CPS_CNI_0008] Payment
    // ---------------------------------------------------------------------------	
	/**
	 * Payment 조회<br>
	 * @author 양정란
	 * @category CPS_CNI_0008
	 * @category searchPaymentInfo 
	 * @param String cgoClmNo
     * @return List<PaymentVO>
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<PaymentVO> searchPaymentInfo(String cgoClmNo) throws DAOException {
        DBRowSet dbRowset = null;
        
        List<PaymentVO> list = null;        
       
        try{    
        	// query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            // velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();
            
            //param
		            
        	// 조회조건
        	param.put("cgo_clm_no", cgoClmNo);
        	
        	// velocity parameter 설정 
            velParam.putAll(param);
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ClaimMainDBDAOSearchPaymentInfoRSQL(), param, velParam);
            
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, PaymentVO.class);
            
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
	 * Payment Remark 변경<br>
	 * @author 양정란
	 * @category CPS_CNI_0008
	 * @category managePayment
	 * @param PaymentVO paymentVO
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public void managePayment(PaymentVO paymentVO) throws DAOException {        
        try{    
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, Object> velParam = new HashMap<String, Object>();			
			Map<String , String> paramMap = paymentVO.getColumnValues();
			
			sqlExe.executeUpdate((ISQLTemplate) new ClaimMainDBDAOModifyClaimMainPayRmkUSQL(), paramMap, velParam);            
        } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
    } 
    
    // ---------------------------------------------------------------------------
    // [CPS_CNI_0009] Handling Costs
    // ---------------------------------------------------------------------------	
	/**
	 * Handling Costs 조회<br>
	 * @author 양정란
	 * @category CPS_CNI_0009
	 * @category searchHandlingCostList 
	 * @param String cgoClmNo
     * @return List<HandlingCostVO>
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<HandlingCostVO> searchHandlingCostList(String cgoClmNo) throws DAOException {
        DBRowSet dbRowset = null;
        
        List<HandlingCostVO> list = null;        
       
        try{    
        	// query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            // velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();
            
            //param
			
        	// 조회조건
        	param.put("cgo_clm_no", cgoClmNo);
        	
        	// velocity parameter 설정 
            velParam.putAll(param);
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ClaimMainDBDAOSearchHandlingCostListRSQL(), param, velParam);
            
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, HandlingCostVO.class);
                 
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
	 * Handling Costs 조회<br>
	 * @author 양정란
	 * @category CPS_CNI_0009
	 * @category searchHandlingCostInfo
	 * @param String cgoClmNo
     * @return HandlingCostInfoVO
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public HandlingCostInfoVO searchHandlingCostInfo(String cgoClmNo) throws DAOException {
        DBRowSet dbRowset = null;
        
        List<HandlingCostInfoVO> list = null;
       
        try{    
        	// query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            // velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();
            
            //param
			
        	// 조회조건
        	param.put("cgo_clm_no", cgoClmNo);
        	
        	// velocity parameter 설정 
            velParam.putAll(param);
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ClaimMainDBDAOSearchHandlingCostInfoRSQL(), param, velParam);
            
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, HandlingCostInfoVO.class);
            
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
	 * Handling Costs 등록<br>
	 * @author 양정란
	 * @category CPS_CNI_0009
	 * @category addHandlingCost
	 * @param CniCgoClmCostVO cniCgoClmCostVO
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public void addHandlingCost(CniCgoClmCostVO cniCgoClmCostVO) throws DAOException {        
        try{    
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, Object> velParam = new HashMap<String, Object>();			
			Map<String , String> paramMap = cniCgoClmCostVO.getColumnValues();
			
			//디폴트값세팅
			if(paramMap.get("inv_xch_rt").equals("")){
				paramMap.put("inv_xch_rt","0");
			}
			if(paramMap.get("inv_usd_amt").equals("")){
				paramMap.put("inv_usd_amt","0");
			}			

			sqlExe.executeUpdate((ISQLTemplate) new ClaimMainDBDAOAddHandlingCostCSQL(), paramMap, velParam);            
        } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
    }
    
    /**
	 * Handling Costs 수정<br>
	 * @author 양정란
	 * @category CPS_CNI_0009
	 * @category modifyHandlingCost
	 * @param CniCgoClmCostVO cniCgoClmCostVO
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public void modifyHandlingCost(CniCgoClmCostVO cniCgoClmCostVO) throws DAOException {        
        try{    
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, Object> velParam = new HashMap<String, Object>();			
			Map<String , String> paramMap = cniCgoClmCostVO.getColumnValues();
			
			//디폴트값세팅
			if(paramMap.get("inv_xch_rt").equals("")){
				paramMap.put("inv_xch_rt","0");
			}
			if(paramMap.get("inv_usd_amt").equals("")){
				paramMap.put("inv_usd_amt","0");
			}

			sqlExe.executeUpdate((ISQLTemplate) new ClaimMainDBDAOModifyHandlingCostUSQL(), paramMap, velParam);            
        } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
    }
    
    /**
	 * Handling Costs  INV_RGST_NO 갱신 <br>
	 * @author 진윤오
	 * @category CPS_CNI_0045
	 * @category modifyHandlingCost
	 * @param CniCgoClmCostVO cniCgoClmCostVO
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public void modifyHandlingCostInvRgstNo(CniCgoClmCostVO cniCgoClmCostVO) throws DAOException {        
        try{    
			SQLExecuter sqlExe = new SQLExecuter("");						
			Map<String , String> paramMap = cniCgoClmCostVO.getColumnValues();		
			sqlExe.executeUpdate((ISQLTemplate) new ClaimMainDBDAOModifyHandlingCostInvRgstNoUSQL(), paramMap, null);            
        } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
    }    
    
    /**
	 * Survey usd_amt 수정<br>
	 * @author 양정란
	 * @category CPS_CNI_0009
	 * @category modifySurveyUsdAmt
	 * @param String cgoClmNo
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public void modifySurveyUsdAmt(String cgoClmNo) throws DAOException {        
        try{    
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, Object> velParam = new HashMap<String, Object>();			
			Map<String , String> paramMap = new HashMap<String , String>();
			
			paramMap.put("cgo_clm_no", cgoClmNo);

			sqlExe.executeUpdate((ISQLTemplate) new ClaimMainDBDAOModifySurveyUsdAmtUSQL(), paramMap, velParam);            
        } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
    }    
    
    /**
	 * Handling Costs 삭제<br>
	 * @author 양정란
	 * @category CPS_CNI_0009
	 * @category removeHandlingCost
	 * @param CniCgoClmCostVO cniCgoClmCostVO
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public void removeHandlingCost(CniCgoClmCostVO cniCgoClmCostVO) throws DAOException {        
        try{    
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, Object> velParam = new HashMap<String, Object>();			
			Map<String , String> paramMap = cniCgoClmCostVO.getColumnValues();

			sqlExe.executeUpdate((ISQLTemplate) new ClaimMainDBDAORemoveHandlingCostDSQL(), paramMap, velParam);            
        } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
    }    
    
        
	// ---------------------------------------------------------------------------
	// [CPS_CNI-0015] Contract of Carriage
	// ---------------------------------------------------------------------------   
	/**
	 * ContractCarriage 조회<br>
	 * @author 박제성
	 * @category CPS_CNI_0010
	 * @category searchContractCarriageInfo
	 * @param  String cgoClmNo
     * @return ContractCarriageVO
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public ContractCarriageVO searchContractCarriageInfo(String cgoClmNo) throws DAOException {
        DBRowSet dbRowset = null;
        
        List<ContractCarriageVO> list = null;        
       
        try{    
        	// query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            // velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();
            
        	// 조회조건
        	param.put("cgo_clm_no", cgoClmNo);
        	
        	// velocity parameter 설정 
            velParam.putAll(param);
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ClaimMainDBDAOSearchContractCarriageRSQL(), param, velParam);
            
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, ContractCarriageVO.class);
                 
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
	 * ContractCarriage B/L Get<br>
	 * @author 박제성
	 * @category CPS_CNI_0010
	 * @category searchContractCarriageBLGet1
	 * @param  String blNo
     * @return ContractCarriageVO
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public ContractCarriageVO searchContractCarriageBLGet1(String blNo) throws DAOException {
        DBRowSet dbRowset = null;
        
        List<ContractCarriageVO> list = null;        
       
        try{    
        	// query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            // velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();
            
        	// 조회조건
        	param.put("bl_no", blNo);        	
        	// velocity parameter 설정 
            velParam.putAll(param);
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ClaimMainDBDAOSearchContractCarriageBLGet1RSQL(), param, velParam);
            
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, ContractCarriageVO.class);
                 
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
	 * ContractCarriage B/L Get<br>
	 * @author 박제성
	 * @category CPS_CNI_0010
	 * @category searchContractCarriageBLGet2
	 * @param  String bkgNo
     * @return ContractCarriageVO
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public ContractCarriageVO searchContractCarriageBLGet2(String bkgNo) throws DAOException {
        DBRowSet dbRowset = null;
        
        List<ContractCarriageVO> list = null;        
       
        try{    
        	// query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            // velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();
            
        	// 조회조건
        	param.put("bkg_no", bkgNo);        	
        	// velocity parameter 설정 
            velParam.putAll(param);
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ClaimMainDBDAOSearchContractCarriageBLGet2RSQL(), param, velParam);
            
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, ContractCarriageVO.class);
                 
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
	 * ContractCarriage B/L Get<br>
	 * @author 박제성
	 * @category CPS_CNI_0010
	 * @category searchContractCarriageBLGet3
	 * @param  String bkgNo
     * @return ContractCarriageVO
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public ContractCarriageVO searchContractCarriageBLGet3(String bkgNo) throws DAOException {
        DBRowSet dbRowset = null;
        
        List<ContractCarriageVO> list = null;        
       
        try{    
        	// query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            // velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();
            
        	// 조회조건
            param.put("bkg_no", bkgNo);    
        	// velocity parameter 설정 
            velParam.putAll(param);
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ClaimMainDBDAOSearchContractCarriageBLGet3RSQL(), param, velParam);
            
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, ContractCarriageVO.class);
                 
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
	 * ContractCarriage B/L Get<br>
	 * @author 박제성
	 * @category CPS_CNI_0010
	 * @category searchContractCarriageBLGet4
	 * @param  String bkgNo
     * @return ContractCarriageVO
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public ContractCarriageVO searchContractCarriageBLGet4(String bkgNo) throws DAOException {
        DBRowSet dbRowset = null;
        
        List<ContractCarriageVO> list = null;        
       
        try{    
        	// query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            // velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();
            
        	// 조회조건
            param.put("bkg_no", bkgNo);    
        	// velocity parameter 설정 
            velParam.putAll(param);
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ClaimMainDBDAOSearchContractCarriageBLGet4RSQL(), param, velParam);
            
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, ContractCarriageVO.class);
                 
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
	 * ContractCarriage B/L Get<br>
	 * @author 박제성
	 * @category CPS_CNI_0010
	 * @category searchContractCarriageBLGet5
	 * @param  String cgoClmNo
     * @return ContractCarriageVO
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public ContractCarriageVO searchContractCarriageBLGet5(String cgoClmNo) throws DAOException {
        DBRowSet dbRowset = null;
        
        List<ContractCarriageVO> list = null;        
       
        try{    
        	// query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            // velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();
            
        	// 조회조건
        	param.put("cgo_clm_no", cgoClmNo);        	
        	// velocity parameter 설정 
            velParam.putAll(param);
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ClaimMainDBDAOSearchContractCarriageBLGet5RSQL(), param, velParam);
            
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, ContractCarriageVO.class);
                 
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
	 * ContractCarriage B/L Get<br>
	 * @author 박제성
	 * @category CPS_CNI_0010
	 * @category searchContractCarriageBLGet6
	 * @param  String bkgNo
     * @return ContractCarriageVO
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public ContractCarriageVO searchContractCarriageBLGet6(String bkgNo) throws DAOException {
        DBRowSet dbRowset = null;
        
        List<ContractCarriageVO> list = null;        
       
        try{    
        	// query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            // velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();
            
        	// 조회조건
        	param.put("bkg_no", bkgNo);        	
        	// velocity parameter 설정 
            velParam.putAll(param);
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ClaimMainDBDAOSearchContractCarriageBLGet6RSQL(), param, velParam);
            
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, ContractCarriageVO.class);
                 
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
	 * ContractCarriage B/L Get<br>
	 * @author 박제성
	 * @category CPS_CNI_0010
	 * @category searchContractCarriageBLGet7
	 * @param  String bkgNo
     * @return ContractCarriageVO
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public ContractCarriageVO searchContractCarriageBLGet7(String bkgNo) throws DAOException {
        DBRowSet dbRowset = null;
        
        List<ContractCarriageVO> list = null;        
       
        try{    
        	// query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            // velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();
            
        	// 조회조건
            param.put("bkg_no", bkgNo);     	
        	// velocity parameter 설정 
            velParam.putAll(param);
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ClaimMainDBDAOSearchContractCarriageBLGet7RSQL(), param, velParam);
            
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, ContractCarriageVO.class);
                 
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
	 * ContractCarriage B/L Get<br>
	 * @author 박제성
	 * @category CPS_CNI_0010
	 * @category searchContractCarriageBLGet8
	 * @param  String bkgNo
     * @return ContractCarriageVO
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public ContractCarriageVO searchContractCarriageBLGet8(String bkgNo) throws DAOException {
        DBRowSet dbRowset = null;
        
        List<ContractCarriageVO> list = null;        
       
        try{    
        	// query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            // velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();
            
        	// 조회조건
            param.put("bkg_no", bkgNo);      	
        	// velocity parameter 설정 
            velParam.putAll(param);
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ClaimMainDBDAOSearchContractCarriageBLGet8RSQL(), param, velParam);
            
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, ContractCarriageVO.class);
                 
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
	 * ClaimBlDetailList 조회<br>
	 * @author 박제성
	 * @category CPS_CNI_0010
	 * @category searchClaimBlDetailList 
	 * @param String cgoClmNo
     * @return List<LiablePartyVO> 
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<CniCgoClmBlDtlVO> searchClaimBlDetailList(String cgoClmNo) throws DAOException {
        DBRowSet dbRowset = null;
        
        List<CniCgoClmBlDtlVO> list = null;        
       
        try{    
        	// query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            // velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();
            
        	// 조회조건
        	param.put("cgo_clm_no", cgoClmNo);
        	
        	// velocity parameter 설정 
            velParam.putAll(param);
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ClaimMainDBDAOSearchClaimBlDetailRSQL(), param, velParam);
            
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, CniCgoClmBlDtlVO.class);
                 
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
	 * ClaimContractDetail 조회<br>
	 * @author 박제성
	 * @category CPS_CNI_0010
	 * @category searchContractCarriageInfo 
	 * @param String cgoClmNo
	 * @param String cgoClmRefBlNo
     * @return List<CniCgoClmCntrDtlVO>
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<CniCgoClmCntrDtlVO> searchClaimContractDetailList(String cgoClmNo, String cgoClmRefBlNo) throws DAOException {
        DBRowSet dbRowset = null;
        
        List<CniCgoClmCntrDtlVO> list = null;        
       
        try{    
        	// query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            // velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();
            
        	// 조회조건
        	param.put("cgo_clm_no", cgoClmNo);
        	param.put("cgo_clm_ref_bl_no", cgoClmRefBlNo);
        	
        	// velocity parameter 설정 
            velParam.putAll(param);
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ClaimMainDBDAOSearchClaimContainerDetailRSQL(), param, velParam);
            
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, CniCgoClmCntrDtlVO.class);
                 
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
	 * ClaimContractDetail 조회<br>
	 * @author 박제성
	 * @category CPS_CNI_0010
	 * @category searchContractCarriageInfo 
	 * @param String cgoClmNo
	 * @param String cgoClmRefBlNo
     * @return List<CniCgoClmCntrDtlVO>
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<CniCgoClmCntrDtlVO> searchClaimContractBLGetDetailList(String cgoClmNo, String cgoClmRefBlNo) throws DAOException {
        DBRowSet dbRowset = null;
        
        List<CniCgoClmCntrDtlVO> list = null;        
       
        try{    
        	// query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            // velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();
            
        	// 조회조건
        	param.put("cgo_clm_no", cgoClmNo);
        	param.put("cgo_clm_ref_bl_no", cgoClmRefBlNo);
        	
        	// velocity parameter 설정 
            velParam.putAll(param);
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ClaimMainDBDAOSearchClaimContainerBLGetDetailRSQL(), param, velParam);
            
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, CniCgoClmCntrDtlVO.class);
                 
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
	 * ContractCarriage 체크<br>
	 * @author 박제성
	 * @category CPS_CNI_0010
	 * @category searchContractCarriageExist 
	 * @param String cgoClmNo
     * @return String[] 
     * @throws DAOException
     */ 
    @SuppressWarnings("unchecked")
    public String searchContractCarriageExist(String cgoClmNo) throws DAOException {
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
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ClaimMainDBDAOSearchContractCarriageExistRSQL(), param, velParam);
            returnStr = GemUtil.getArrayString(dbRowset, "EXIST");
            
            //log.debug("searchSurveyInfo insert or update check" + returnStr[0]);
            
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
	 * ContractCarriage 체크<br>
	 * @author 박제성
	 * @category CPS_CNI_0010
	 * @category searchContractCarriageExist 
	 * @param CniCgoClmCntrDtlVO cniCgoClmCntrDtlVO
     * @return String 
     * @throws DAOException
     */ 
    @SuppressWarnings("unchecked")
    public String searchContractCarriageCntrExist(CniCgoClmCntrDtlVO cniCgoClmCntrDtlVO) throws DAOException {
        DBRowSet dbRowset = null;
        
        
        String returnStr[] = null;
       
        try{    
			Map<String, Object> velParam = new HashMap<String, Object>();			
			Map<String , String> paramMap = cniCgoClmCntrDtlVO.getColumnValues();
        	
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ClaimMainDBDAOSearchContractCarriageCntrExistRSQL(), paramMap, velParam);
            returnStr = GemUtil.getArrayString(dbRowset, "CNT");
            
            //log.debug("searchSurveyInfo insert or update check" + returnStr[0]);
            
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
	 * ContractCarriage 수정<br>
	 * @author 박제성
	 * @category CPS_CNI_0010
	 * @category modifyContractCarriage
	 * @param CniCgoClmCtrtVO cniCgoClmCtrtVO
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public void modifyContractCarriage(CniCgoClmCtrtVO cniCgoClmCtrtVO) throws DAOException {        
        try{    
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, Object> velParam = new HashMap<String, Object>();			
			Map<String , String> paramMap = cniCgoClmCtrtVO.getColumnValues();

			sqlExe.executeUpdate((ISQLTemplate) new ClaimMainDBDAOModifyContractCarriageUSQL(), paramMap, velParam);            
        } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
    }
    
    /**
	 * Claim BL Detail 삭제<br>
	 * @author 박제성
	 * @category CPS_CNI_0010
	 * @category removeBlDetail
	 * @param CniCgoClmBlDtlVO cniCgoClmBlDtlVO
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public void removeBlDetail(CniCgoClmBlDtlVO cniCgoClmBlDtlVO) throws DAOException {        
        try{    
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, Object> velParam = new HashMap<String, Object>();			
			Map<String , String> paramMap = cniCgoClmBlDtlVO.getColumnValues();

			sqlExe.executeUpdate((ISQLTemplate) new ClaimMainDBDAORemoveClaimBlDetailDSQL(), paramMap, velParam);            
        } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
    }

    
    /**
	 * ContractDetail 추가<br>
	 * @author 박제성
	 * @category CPS_CNI_0010
	 * @category addContractDetail
	 * @param CniCgoClmCntrDtlVO cniCgoClmCntrDtlVO
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public void addContractDetail(CniCgoClmCntrDtlVO cniCgoClmCntrDtlVO) throws DAOException {        
        try{    
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, Object> velParam = new HashMap<String, Object>();			
			Map<String , String> paramMap = cniCgoClmCntrDtlVO.getColumnValues();
			
			String mnCntrFlg  = cniCgoClmCntrDtlVO.getMnCntrFlg();
			
			if ((mnCntrFlg == null) || "".equals(mnCntrFlg)){
				paramMap.put("mn_cntr_flg", "N");
			}
			
			sqlExe.executeUpdate((ISQLTemplate) new ClaimMainDBDAOAddClaimContainerDetailCSQL(), paramMap, velParam);   
			
        } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
    } 
    

    /**
	 * ContractDetail 삭제<br>
	 * @author 박제성
	 * @category CPS_CNI_0010
	 * @category removeContractDetail
	 * @param CniCgoClmCntrDtlVO cniCgoClmCntrDtlVO
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public void removeContractDetail(CniCgoClmCntrDtlVO cniCgoClmCntrDtlVO) throws DAOException {        
        try{    
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, Object> velParam = new HashMap<String, Object>();			
			Map<String , String> paramMap = cniCgoClmCntrDtlVO.getColumnValues();

			sqlExe.executeUpdate((ISQLTemplate) new ClaimMainDBDAORemoveClaimContainerDetailDSQL(), paramMap, velParam);            
        } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
    }
    
    
    /**
	 * Booking No 공통<br>
	 * @author 박제성
	 * @category CPS_CNI_0010
	 * @category searchBookingNoInfo 
	 * @param String blNo
     * @return String[] 
     * @throws DAOException
     */ 
    @SuppressWarnings("unchecked")
    public BookingNoVO searchBookingNoInfo(String blNo) throws DAOException {
    	DBRowSet dbRowset = null;
        
        List<BookingNoVO> list = null;        
       
        try{    
        	// query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            // velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();
            
        	//  B/L No
        	param.put("bl_no", blNo);
        	
        	// velocity parameter 설정 
            velParam.putAll(param);
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ClaimMainDBDAOSearchBookingNoInfoRSQL(), param, velParam);
            
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, BookingNoVO.class);
            
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
	 * Application 정보 수정<br>
	 * @author 이준범
	 * @category CPS_CNI_0014
	 * @category modifyApplication
	 * @param ApplicationStatusVO applicationStatusVO
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public void modifyApplication(ApplicationStatusVO applicationStatusVO) throws DAOException {        
        try{    
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, Object> velParam = new HashMap<String, Object>();			
			Map<String , String> paramMap = applicationStatusVO.getColumnValues();

			sqlExe.executeUpdate((ISQLTemplate) new ClaimMainDBDAOModifyApplicationUSQL(), paramMap, velParam);            
        } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
    }     

    
}
