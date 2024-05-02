/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GEMPlanningPerformanceDBDAO.java
*@FileTitle : Expense Office Maintenance
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.17
*@LastModifier : 최정미
*@LastVersion : 1.0
* 2009.04.17 최정미
* 1.0 Creation
* ------------------------------------------------------------------
* 2010.11.19 이준범 [CHM-201007198-01] Initial Plan - Closing date 설정 이후 INI RQ/AD/AP block 적용
* 1) searchInitialDate()
*   - searchInitialDate() usrOfcCd 파라미터 추가
*   - 화면에서 Closing DT 의 유효성을 식별할수 있도록 SQL 수정  
=========================================================*/
package com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.integration;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.clt.apps.opus.cps.gem.common.GemUtil;
import com.clt.apps.opus.cps.gem.gemcommon.gemmastercodemgt.basic.GEMMasterCodeMgtBCImpl;
import com.clt.apps.opus.cps.gem.gemcommon.gemmastercodemgt.vo.GemExpenseVO;
import com.clt.apps.opus.cps.gem.gemcommon.gemmastercodemgt.vo.GemOfficeVO;
import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.vo.ActRsltSubsPerfVO;
import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.vo.AssignedExpnVO;
import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.vo.AuthExpnInfoVO;
import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.vo.ClosingDateVO;
import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.vo.ComparisonPlanningVO;
import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.vo.DetailRequestExpenseRqstNoVO;
import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.vo.DetailRequestExpenseVO;
import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.vo.DetailYearlyExpenseVO;
import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.vo.GemApprovalStepVO;
import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.vo.GemItemVO;
import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.vo.GemRequestVO;
import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.vo.GemRsltSmryVO;
import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.vo.GemSlpIfVO;
import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.vo.GemSlpPerfVO;
import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.vo.ItemVO;
import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.vo.OfficeHierarchyVO;
import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.vo.OfficeLevelVO;
import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.vo.PerfInqVO;
import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.vo.PerformanceInfoVO;
import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.vo.PlanningPerformanceVO;
import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.vo.PlanningStatusCondVO;
import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.vo.PlanningStatusVO;
import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.vo.RatioReasonVO;
import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.vo.Report0023R1VO;
import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.vo.Report0025R1VO;
import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.vo.ReportAfterClosingVO;
import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.vo.RqsNoVO;
import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.vo.RqstInfoVO;
import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.vo.RqstPlanInfoVO;
import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.vo.RsltSlpIfVO;
import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.vo.SearchOfficeCurrencyVO;
import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.vo.SearchProcessingStatusVO;
import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.vo.SearchRqstNoReferenceVO;
import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.vo.SearchYearlyExpenseVO;
import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.vo.SlipPerformanceVO;
import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.vo.SubsPerfVO;
import com.clt.bizcommon.comm.Constants;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;


/**
 * NIS2010 GEMMasterCodeMgtDAO <br>
 * - NIS2010-GEMCommon system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author cjm
 * @see GEMMasterCodeMgtBCImpl 참조
 * @since J2EE 1.4
 */
public class GEMPlanningPerformanceDBDAO extends DBDAOSupport {

	// =================================================================================
	// J.Y.O 	
	// =================================================================================
	
	
    /**
     *  해당 사용자 Role정보 취득
     * process status
     * @author J.Y.O
     * @category CPS_GEM-0002
     * @category searchUsrRole
     * @param usrId 유저아이디    
     * @return 
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public String[] searchUserRole(String usrId) throws DAOException {
		DBRowSet dbRowset = null;
		String[] returnStr = null;
		
		try {
			Map<String,String> paramMap = new HashMap<String, String>();
	        //velocity parameter
	        Map<String, String> velParam = new HashMap<String, String>();
			paramMap.put("usr_id", usrId);
			velParam.putAll(paramMap);			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GEMPlanningPerformanceDBDAOSearchUserRoleRSQL(),paramMap, velParam);
			returnStr = GemUtil.getArrayString(dbRowset, "USR_ROLE_CD");			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return returnStr;
    }   	
	
	// ---------------------------------------------------------------------------
	// [CPS_GEM_0101] Authorized Expense Code
	// ---------------------------------------------------------------------------
	
    /**
     * 비용계획을 수립하기 위해서 조직별 승인받은 비용코드를 조회한다<br>
     * 
     * @author J.Y.O
     * @category CPS_GEM_0101
     * @category searchAuthorizedExpenseInfo
     * @param ofcCd 오피스코드
     * @param genExpnCd 비용코드
     * @param genExpnGroupCd 그룹비용코드
     * @param ticCd 비용주관팀 
     * @return
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<AuthExpnInfoVO> searchAuthorizedExpenseInfo(String ofcCd,
			String genExpnCd,String genExpnGroupCd, String ticCd) throws DAOException {
        DBRowSet dbRowset = null;
        
        List<AuthExpnInfoVO> list = null;
        
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
        	
        	if ( genExpnGroupCd != null && !genExpnGroupCd.equals("")) {
        		String[] str = genExpnGroupCd.split("\\,");
        		genExpnGroupCd = GemUtil.getInSqlChar(str);
        	}
        	
        	param.put("ofc_cd", ofcCd);
        	param.put("gen_expn_cd",genExpnCd );
        	param.put("gen_expn_group_cd",genExpnGroupCd );
        	param.put("tic_cd",ticCd );     
        	
        	velParam.put("gen_expn_cd",genExpnCd );
        	velParam.put("gen_expn_group_cd",genExpnGroupCd );
        	velParam.put("tic_cd",ticCd );     
        	
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GEMPlanningPerformanceDBDAOSearchAuthorizedExpenseInfoRSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, AuthExpnInfoVO.class);            
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
     * 1st 비용그룹을 취득한다.<br>
     * 
     * @author J.Y.O
     * @category CPS_GEM_0101
     * @category searchExpenseGroupByLvl
     * @param genExpnGrpLvl 레벨      
     * @return
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<GemExpenseVO> searchExpenseGroupByLvl(String genExpnGrpLvl) throws DAOException {
        DBRowSet dbRowset = null;
        
        List<GemExpenseVO> list = null;
        
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {	
        	param.put("gen_expn_grp_lvl",genExpnGrpLvl );        	
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GEMPlanningPerformanceDBDAOSearchExpenseGroupByLvlRSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, GemExpenseVO.class);            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        
        return list;
    }    
    
    
    
    
	// ---------------------------------------------------------------------------
	// [CPS_GEM_0104] Assigned Expense
	// ---------------------------------------------------------------------------
	
    /**
     * 추가배정, 비용이관을 수행하기 위해 최초확정된 비용계획 정보를 조회 한다<br>
     * 
     * @author J.Y.O
     * @category CPS_GEM-0104
     * @category searchAssignedExpenseInfo
     * @param plnYrmon 마감년월
     * @param ofcCd 오피스코드
     * @param genExpnCd 비용코드 
     * @return
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<AssignedExpnVO> searchAssignedExpenseInfo(String plnYrmon,
			String ofcCd,String genExpnCd) throws DAOException {
        DBRowSet dbRowset = null;
        
        List<AssignedExpnVO> list = null;
        
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
        	param.put("pln_yrmon",plnYrmon );
        	param.put("ofc_cd", ofcCd);
        	param.put("gen_expn_cd",genExpnCd );
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GEMPlanningPerformanceDBDAOSearchAssignedExpenseInfoRSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, AssignedExpnVO.class);            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        
        return list;
    }
    
	// ---------------------------------------------------------------------------
	// [CPS_GEM_0105] Request No. Reference
	// ---------------------------------------------------------------------------
	
    /**
     * 집행단위에서 수립한 비용계획에 대한 Rquest Number 를 조회한다
     * 
     * @author J.Y.O
     * @category CPS_GEM-0105
     * @category searchRqstNoReference
     * @param SearchRqstNoReferenceVO paramVo
     * @return
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<RqsNoVO> searchRqstNoReference(SearchRqstNoReferenceVO paramVo) throws DAOException {
        DBRowSet dbRowset = null;
        
        List<RqsNoVO> list = null;
        
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
        	param.put("pln_yrmon", paramVo.getPlnYrmon() );
        	param.put("rqst_ofc_cd", paramVo.getRqstOfcCd());
        	param.put("cre_usr_id", paramVo.getUpdUserId());
        	param.put("prg_id", paramVo.getPrgId());        	
        	param.put("auth_flg", paramVo.getAuthFlg());
        	String genExpnRqstTpCd = paramVo.getGenExpnRqstTpCd();
        	
        	if ( genExpnRqstTpCd != null && !genExpnRqstTpCd.equals("")) {
        		String[] str = genExpnRqstTpCd.split("\\,");
        		genExpnRqstTpCd = GemUtil.getInSqlChar(str);
        	}        	
        	param.put("gen_expn_rqst_tp_cd", genExpnRqstTpCd);        	
        	velParam.putAll(param);
        	        	
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GEMPlanningPerformanceDBDAOSearchRqstNoReferenceRSQL(), param, velParam);            
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, RqsNoVO.class);
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        
        return list;
    }    
    
    
	// ---------------------------------------------------------------------------
	// [CPS_GEM_0001_01] Expense Request ? Initial & Additional
	// ---------------------------------------------------------------------------
	
    /**
	 * Request 테이블의 update date 취득
	 * YYYYMMDDHH24MISS 리턴  
     * @author J.Y.O
     * @category CPS_GEM-0001-01
     * @category searchReqUpdDate    
     * @param genExpnRqstNo Request no
     * @return YYYYMMDDHH24MISS 리턴
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public String searchReqUpdDt(String genExpnRqstNo) throws DAOException {
			
        DBRowSet dbRowset = null;
        
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {        	
        	param.put("gen_expn_rqst_no",genExpnRqstNo );        	
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GEMPlanningPerformanceDBDAOSearchReqUpdDtRSQL(), param, velParam);            
            if (dbRowset.next()) {
            	return dbRowset.getString("UPD_DT");
            }            
            return null;
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        
        
    }          

    /**
	 * Item 테이블의 update date 취득
	 * YYYYMMDDHH24MISS 리턴  
     * @author J.Y.O
     * @category CPS_GEM-0001-01
     * @category searchItmUpdDt    
     * @param genExpnRqstNo Request no
     * @param genExpnRqstSeq Request seq
     * @return YYYYMMDDHH24MISS 리턴
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public String searchItmUpdDt(String genExpnRqstNo , String genExpnRqstSeq) throws DAOException {
			
        DBRowSet dbRowset = null;
        
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {        	
        	param.put("gen_expn_rqst_no",genExpnRqstNo );        	
        	param.put("gen_expn_rqst_seq",genExpnRqstSeq );
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GEMPlanningPerformanceDBDAOSearchItmUpdDtRSQL(), param, velParam);            
            if (dbRowset.next()) {
            	return dbRowset.getString("UPD_DT");
            }            
            return null;
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        
        
    }          
    
    
    /**
	 * 로그인 사용자의 로컬 DATE취득 
     * YYYYMMDD  형식 
     * @author J.Y.O
     * @category CPS_GEM-0001-01
     * @category searchLocalDate    
     * @param usrOfcCd 로그인 ofc_cd
     * @return YYYYMMDD  형식
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public String searchItmUpdDate(String usrOfcCd) throws DAOException {
			
        DBRowSet dbRowset = null;
        
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {        	
        	param.put("usr_ofc_cd",usrOfcCd );        	
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GEMPlanningPerformanceDBDAOSearchLocalDateRSQL(), param, velParam);            
            if (dbRowset.next()) {
            	return dbRowset.getString("LCL_DT");
            }            
            return null;
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        
        
    }    
    
    /**
	 * 로그인 조직(Office)이 GEM 시스템 사용시 권한 조회 ( 집행단위 , BU CTRL , 지역그룹 , 비용주관팀 , 사무국 으로 분류 ) 및 Request 요건 정보
     * 
     * @author J.Y.O
     * @category CPS_GEM_0001_01
     * @category searchOfficeRqstInfo
     * @param ofcCd 로그인 오피스코드 (요청 오피스코드)
     * @param acctXchRtYrmon 계획년      
     * @return
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public OfficeLevelVO searchOfficeRqstInfo(String ofcCd,
			String acctXchRtYrmon) throws DAOException {
        DBRowSet dbRowset = null;
        
        List<OfficeLevelVO> list = null;
        
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {

        	param.put("ofc_cd",ofcCd );
        	param.put("acct_xch_rt_yrmon", acctXchRtYrmon); 
        	
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GEMPlanningPerformanceDBDAOSearchOfficeRqstInfoRSQL(), param, velParam);            
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, OfficeLevelVO.class);
            
            if (list != null && !list.isEmpty()) {
            	return list.get(0);
            }
            
            return new OfficeLevelVO();
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        
        
    }        
    
    /**
	 * 로그인 조직(Office)의 Hierarchy 구조 조회
     * 
     * @author J.Y.O
     * @category CPS_GEM_0001_01
     * @category searchOfficeHierarchy
     * @param ofcCd 로그인 오피스코드 (요청 오피스코드)       
     * @return
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public OfficeHierarchyVO searchOfficeHierarchy(String ofcCd) throws DAOException {
			
        DBRowSet dbRowset = null;
        
        List<OfficeHierarchyVO> list = null;
        
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {

        	param.put("ofc_cd",ofcCd );
        	
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GEMPlanningPerformanceDBDAOSearchOfficeHierarchyRSQL(), param, velParam);            
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, OfficeHierarchyVO.class);
            
            if (list != null && !list.isEmpty()) {
            	return list.get(0);
            }
            
            return null;
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        
        
    }        
    
    /**
	 * 로그인 조직(Office)의 Hierarchy 구조 조회 및 환율정보 취득
     * 
     * @author J.Y.O
     * @category CPS_GEM_0001_03 ,CPS_GEM-0003
     * @category searchOfficeCurrency
     * @param ofcCd 로그인 오피스코드 (요청 오피스코드)       
     * @param acctXchRtYrmon 예산년도
     * @return
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public SearchOfficeCurrencyVO searchOfficeCurrency(String ofcCd ,String acctXchRtYrmon) throws DAOException {
			
        DBRowSet dbRowset = null;
        
        List<SearchOfficeCurrencyVO> list = null;
        
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {

        	param.put("ofc_cd",ofcCd );
        	param.put("acct_xch_rt_yrmon" , acctXchRtYrmon);
        	
        	velParam.putAll(param);
        	
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GEMPlanningPerformanceDBDAOSearchOfficeCurrencyRSQL(), param, velParam);            
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchOfficeCurrencyVO.class);
            
            if (list != null && !list.isEmpty()) {
            	return list.get(0);
            }
            
            return null;
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        
        
    }      
    
    
    /**
	 * 계획비용 요청시 입력 마감일정 정보 조회
     * 
     * @author J.Y.O
     * @category CPS_GEM_0001_01
     * @category searchClosingDate
     * @param clzYrmon 예산년도(yyyy)    
     * @param usrOfcCd 로그인 ofc_cd
     * @return
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public ClosingDateVO searchClosingDate(String clzYrmon , String usrOfcCd) throws DAOException {
			
        DBRowSet dbRowset = null;
        
        List<ClosingDateVO> list = null;
        
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
        	
        	param.put("clz_yrmon",clzYrmon );
        	param.put("usr_ofc_cd",usrOfcCd );
        	
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GEMPlanningPerformanceDBDAOSearchClosingDateRSQL(), param, velParam);            
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, ClosingDateVO.class);
            
            if (list != null && !list.isEmpty()) {
            	return list.get(0);
            }
            
            return null;
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        
        
    }            
    
    /**
	 * 로그인 사용자의 로컬 DATE취득 
     * YYYYMMDD  형식 
     * @author J.Y.O
     * @category CPS_GEM-0001-01
     * @category searchLocalDate    
     * @param usrOfcCd 로그인 ofc_cd
     * @return YYYYMMDD  형식
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public String searchLocalDate(String usrOfcCd) throws DAOException {
			
        DBRowSet dbRowset = null;
        
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {        	
        	param.put("usr_ofc_cd",usrOfcCd );        	
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GEMPlanningPerformanceDBDAOSearchLocalDateRSQL(), param, velParam);            
            if (dbRowset.next()) {
            	return dbRowset.getString("LCL_DT");
            }            
            return null;
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        
        
    }      
    
    /**
	 * 로그인 사용자의 GEM office 코드 취득
     * @author J.Y.O
     * @category CPS_GEM-0001-01
     * @category searchLocalDate    
     * @param usrOfcCd 로그인세션 ofc_cd
     * @return Gem OfcCd
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public String searchUserOfficeCd(String usrOfcCd) throws DAOException {
			
        DBRowSet dbRowset = null;
        
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {        	
        	param.put("ofc_cd",usrOfcCd );        	
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GEMPlanningPerformanceDBDAOSearchUserOfficeCdRSQL(), param, velParam);            
            if (dbRowset.next()) {
            	return dbRowset.getString("CNG_OFC_CD");
            }            
            return null;
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        
        
    }          
    
    
    /**
	 * 계획비용 요청시 입력 차년도 계획 마감일정 정보 조회
     * 
     * @author J.Y.O
     * @category CPS_GEM_0001_01
     * @category searchInitialDate
     * @param String clzYrmon
     * @param String usrOfcCd
     * @return
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public ClosingDateVO searchInitialDate(String clzYrmon, String usrOfcCd) throws DAOException {
			
        DBRowSet dbRowset = null;
        
        List<ClosingDateVO> list = null;
        
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
        	
        	param.put("clz_yrmon",clzYrmon );
        	param.put("usr_ofc_cd",usrOfcCd );
        	
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GEMPlanningPerformanceDBDAOSearchInitialDateRSQL(), param, velParam);            
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, ClosingDateVO.class);
            
            if (list != null && !list.isEmpty()) {
            	return list.get(0);
            }
            
            return null;
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        
        
    }     
    
    /**
	 * 계획비용 요청 정보 조회
     * table GEM_REQUEST
     * @author J.Y.O
     * @category CPS_GEM_0001_01
     * @category searchExpenseRequest
     * @param genExpnRqstNo 비용요청번호      
     * @return
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public GemRequestVO searchExpenseRequest(String genExpnRqstNo) throws DAOException {
			
        DBRowSet dbRowset = null;
        
        List<GemRequestVO> list = null;
        
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
        	
        	param.put("gen_expn_rqst_no" , genExpnRqstNo );
        	
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GEMPlanningPerformanceDBDAOSearchExpenseRequestRSQL(), param, velParam);            
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, GemRequestVO.class);
            
            if (list != null && !list.isEmpty()) {
            	return list.get(0);
            }
            
            return null;
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        
        
    }          
    
    /**
     * 계획비용 Transfer ITEM 정보 조회
     * 등록한 사용자 만 조회
     * @author J.Y.O
     * @category CPS_GEM_0001_02
     * @category searchTransferItem
     * @param   genExpnRqstNo request 번호
     * @param   rqstOfcCd 요청부서(로그인부서)
     * @param   creUsrId 로그인아이디
     * @return
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<GemItemVO> searchTransferItem(String genExpnRqstNo,String rqstOfcCd,String creUsrId) throws DAOException {
        DBRowSet dbRowset = null;
        
        List<GemItemVO> list = null;
        
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
        	param.put("gen_expn_rqst_no", genExpnRqstNo);
        	param.put("rqst_ofc_cd", rqstOfcCd);
        	param.put("cre_usr_id", creUsrId);
        	        	
        	velParam.putAll(param);        	
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GEMPlanningPerformanceDBDAOSearchTransferExpenseItemRSQL(), param, velParam);            
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, GemItemVO.class);
            
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
     * 계획비용 ITEM 정보 조회
     * GEM_ITEM
     * @author J.Y.O
     * @category CPS_GEM-0105
     * @category searchExpenseItem
     * @param gemItemVO item정보    
     * @return
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<GemItemVO> searchExpenseItem(GemItemVO gemItemVO) throws DAOException {
        DBRowSet dbRowset = null;
        
        List<GemItemVO> list = null;
        
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
        	Map<String, String> mapVO = 
        		gemItemVO.getColumnValues();
        	param.putAll(mapVO);        	
        	velParam.putAll(mapVO);        	
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GEMPlanningPerformanceDBDAOSearchExpenseItemRSQL(), param, velParam);            
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, GemItemVO.class);
            
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
     * 계획비용 apro step 정보 조회
     * GEM_ITEM
     * @author J.Y.O
     * @category CPS_GEM-0105
     * @category searchExpenseItem
     * @param GemApprovalStepVO gemApprovalStepVO item정보    
     * @return List<GemApprovalStepVO>
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<GemApprovalStepVO> searchExpenseAproStep(GemApprovalStepVO gemApprovalStepVO) throws DAOException {
        DBRowSet dbRowset = null;
        
        List<GemApprovalStepVO> list = null;
        
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
        	
        	Map<String, String> mapVO = 
        		gemApprovalStepVO.getColumnValues();
        	param.putAll(mapVO);
        	
        	velParam.putAll(mapVO);
        	
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GEMPlanningPerformanceDBDAOSearchExpenseAproStepRSQL(), param, velParam);            
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, GemApprovalStepVO.class);
            
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
     * 조직별 비용계획 수립 가능한 비용코드를 체크하고, 비용 코드의 한글약어명,영문약어명,비용주관팀 정보
     * @author J.Y.O
     * @category CPS_GEM_0001_01
     * @category searchRqstExpense
     * @param String ofcCd     
     * @param String genExpnCd
     * @param String ticCd 
     * @param String genExpnGroupCd
     * @return GemExpenseVO
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public GemExpenseVO searchRqstExpense(String ofcCd , String genExpnCd , String ticCd , String genExpnGroupCd) throws DAOException {
        
    	DBRowSet dbRowset = null;        
        
        List<GemExpenseVO> list = null;
        
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
        	param.put("ofc_cd", ofcCd);
        	param.put("gen_expn_cd", genExpnCd);
        	param.put("tic_cd", ticCd);
        	param.put("gen_expn_group_cd", genExpnGroupCd);
        	velParam.putAll(param);
        	
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GEMPlanningPerformanceDBDAOSearchRqstExpenseRSQL(), param, velParam);            
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, GemExpenseVO.class);
            
            if (list == null || list.isEmpty()) {
            	return null;
            } else {
            	return list.get(0);
            }
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        
        
    }      
    
    /**
     * 비용계획 요청시 비용코드의 MAX(Item) 
     * @author J.Y.O
     * @category CPS_GEM_0001_01
     * @category searchMaxItem
     * @param plnYrmon 예산년도
     * @param ofcCd 오피스 코드     
     * @param genExpnCd 비용코드 
     * @return null --> maxItem미존재 , maxItemNo
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public String searchMaxItem(String plnYrmon ,String ofcCd , String genExpnCd) throws DAOException {
        
    	DBRowSet dbRowset = null;        
        
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
        	param.put("pln_yrmon", plnYrmon);
        	param.put("ofc_cd", ofcCd);
        	param.put("gen_expn_cd", genExpnCd);        	
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GEMPlanningPerformanceDBDAOSearchMaxItemRSQL(), param, velParam);            
            
            if (dbRowset.next()) {
            	String maxItemNo = dbRowset.getString(1);
            	return maxItemNo;
            	 
            } else {
            	return null;
            }
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        
        
    }      
    
    /**
	 * 집행단위, 지역그룹|BU CTRL , 비용주관팀 , 사무국 에서 등록한 비용계획 생성<br>
	 * 
	 * @author J.Y.O
	 * @category CPS_GEM_0001_01
	 * @category addExpenseRequest
	 * 
     * @param gemRequestVO  집행단위, 지역그룹|BU CTRL , 비용주관팀 , 사무국 에서 등록한 비용계획 정보
     * @throws DAOException
     */
    public void addExpenseRequest (GemRequestVO gemRequestVO)  throws DAOException   {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, Object> velParam = new HashMap<String, Object>();			
			Map<String , String> paramMap = gemRequestVO.getColumnValues();			
			sqlExe.executeUpdate((ISQLTemplate) new GEMPlanningPerformanceDBDAOAddExpenseRequestCSQL(), paramMap, velParam);			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

    }     
    
    /**
	 * 집행단위, 지역그룹|BU CTRL , 비용주관팀 , 사무국 에서 등록한 비용계획 수정<br>
	 * 
	 * @author J.Y.O
	 * @category CPS_GEM_0001_01
	 * @category modifyExpenseRequest
	 * 
     * @param GemRequestVO gemRequestVO  집행단위, 지역그룹|BU CTRL , 비용주관팀 , 사무국 에서 등록한 비용계획 정보
     * @throws DAOException
     */
    public void modifyExpenseRequest (GemRequestVO gemRequestVO)  throws DAOException   {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, Object> velParam = new HashMap<String, Object>();			
			Map<String , String> paramMap = gemRequestVO.getColumnValues();
			velParam.putAll(paramMap);
			sqlExe.executeUpdate((ISQLTemplate) new GEMPlanningPerformanceDBDAOModifyExpenseRequestUSQL(), paramMap, velParam);			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

    }      
    
     
    
    /**
	 * 집행단위, 지역그룹|BU CTRL , 비용주관팀 , 사무국 에서 등록한 비용계획 삭제<br>
	 * 
	 * @author J.Y.O
	 * @category CPS_GEM_0001_01
	 * @category removeExpenseRequest 
     * @param String genExpnRqstNo
     * @throws DAOException
     */
    public void removeExpenseRequest (String genExpnRqstNo)  throws DAOException   {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, Object> velParam = new HashMap<String, Object>();			
			Map<String , Object> paramMap = new HashMap<String, Object>();
			paramMap.put("gen_expn_rqst_no", genExpnRqstNo);			
			sqlExe.executeUpdate((ISQLTemplate) new GEMPlanningPerformanceDBDAORemoveExpenseRequestDSQL(), paramMap, velParam);			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
    }      
    
    /**
	 * 집행단위, 지역그룹|BU CTRL , 비용주관팀 , 사무국 에서 등록한 비용계획 생성<br>
	 * 
	 * @author J.Y.O
	 * @category CPS_GEM_0001_01
	 * @category addExpenseItems
	 * 
     * @param List<GemItemVO> gemItemVOs  집행단위, 지역그룹|BU CTRL , 비용주관팀 , 사무국 에서 등록한 비용계획 정보
     * @throws DAOException
     */
    public void addExpenseItems (List<GemItemVO> gemItemVOs)  throws DAOException   {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (gemItemVOs.size() > 0) {
				Map<String, Object> velParam = new HashMap<String, Object>();
				insCnt = sqlExe.executeBatch((ISQLTemplate) new GEMPlanningPerformanceDBDAOAddExpenseItemsCSQL(), gemItemVOs, velParam);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

    }     
    
    /**
	 * 집행단위, 지역그룹|BU CTRL , 비용주관팀 , 사무국 에서 등록한 비용계획 수정<br>
	 * 
	 * @author J.Y.O
	 * @category CPS_GEM_0001_01
	 * @category modifyExpenseItems
	 * 
     * @param List<GemItemVO> gemItemVOs  집행단위, 지역그룹|BU CTRL , 비용주관팀 , 사무국 에서 등록한 비용계획 정보
     * @throws DAOException
     */
    public void modifyExpenseItems (List<GemItemVO> gemItemVOs)  throws DAOException   {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (gemItemVOs.size() > 0) {
				Map<String, Object> velParam = new HashMap<String, Object>();
				
				insCnt = sqlExe.executeBatch((ISQLTemplate) new GEMPlanningPerformanceDBDAOModifyExpenseItemsUSQL(), gemItemVOs, velParam);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

    }     
    
    /**
	 * 집행단위, 지역그룹|BU CTRL , 비용주관팀 , 사무국 에서 등록한 비용계획 수정<br>
	 * 
	 * @author J.Y.O
	 * @category CPS_GEM_0001_01
	 * @category modifyExpenseItem
	 * 
     * @param GemItemVO gemItemVO  집행단위, 지역그룹|BU CTRL , 비용주관팀 , 사무국 에서 등록한 비용계획 정보
     * @throws DAOException
     */
    public void modifyExpenseItem(GemItemVO gemItemVO)  throws DAOException   {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String , String> paramMap = gemItemVO.getColumnValues();			
			Map<String, String> velParam = paramMap;
			sqlExe.executeUpdate((ISQLTemplate) new GEMPlanningPerformanceDBDAOModifyExpenseItemUSQL(), paramMap, velParam);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

    }        
     
    /**
	 * 집행단위, 지역그룹|BU CTRL , 비용주관팀 , 사무국 에서 등록한 비용계획 삭제<br>
	 * 
	 * @author J.Y.O
	 * @category CPS_GEM_0001_01
	 * @category removeExpenseItems
	 * 
     * @param List<GemItemVO> gemItemVOs  집행단위, 지역그룹|BU CTRL , 비용주관팀 , 사무국 에서 등록한 비용계획 정보
     * @throws DAOException
     */
    public void removeExpenseItems (List<GemItemVO> gemItemVOs)  throws DAOException   {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (gemItemVOs.size() > 0) {
				Map<String, Object> velParam = new HashMap<String, Object>(); 
				insCnt = sqlExe.executeBatch((ISQLTemplate) new GEMPlanningPerformanceDBDAORemoveExpenseItemsDSQL(), gemItemVOs, velParam);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

    }     

    /**
	 * 집행단위, 지역그룹|BU CTRL , 비용주관팀 , 사무국 에서 등록한 비용계획 Request No별 삭제<br>
	 * 
	 * @author J.Y.O
	 * @category CPS_GEM_0001_01
	 * @category removeExpenseItemsByRqstNo
	 * 
     * @param String genExpnRqstNo
     * @throws DAOException
     */
    public void removeExpenseItemsByRqstNo (String genExpnRqstNo)  throws DAOException   {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String , Object> paramMap = new HashMap<String, Object>();
			paramMap.put("gen_expn_rqst_no", genExpnRqstNo);
			Map<String, Object> velParam = new HashMap<String, Object>();
			sqlExe.executeUpdate((ISQLTemplate) new GEMPlanningPerformanceDBDAORemoveExpenseItemsByRqstNoDSQL(), paramMap, velParam);						
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

    }       
    
    /**
	 * 집행단위, 지역그룹|BU CTRL , 비용주관팀 , 사무국 에서 등록한 비용계획 생성<br>
	 * 
	 * @author J.Y.O
	 * @category CPS_GEM_0001_01
	 * @category addExpenseApprovalSteps
	 * 
     * @param List<GemApprovalStepVO> gemApprovalStepVOs  집행단위, 지역그룹|BU CTRL , 비용주관팀 , 사무국 에서 등록한 비용계획 정보
     * @throws DAOException
     */
    public void addExpenseApprovalSteps (List<GemApprovalStepVO> gemApprovalStepVOs)  throws DAOException   {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (gemApprovalStepVOs.size() > 0) {
				Map<String, Object> velParam = new HashMap<String, Object>();
				insCnt = sqlExe.executeBatch((ISQLTemplate) new GEMPlanningPerformanceDBDAOAddExpenseApprovalStepsCSQL(), gemApprovalStepVOs, velParam);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

    }     
    
    /**
	 * 집행단위, 지역그룹|BU CTRL , 비용주관팀 , 사무국 에서 등록한 비용계획 생성<br>
	 * 
	 * @author J.Y.O
	 * @category CPS_GEM_0001_01
	 * @category addExpenseApprovalSteps
	 * 
     * @param GemApprovalStepVO gemApprovalStepVOs  집행단위, 지역그룹|BU CTRL , 비용주관팀 , 사무국 에서 등록한 비용계획 정보
     * @throws DAOException
     */
    public void addExpenseApprovalSteps (GemApprovalStepVO gemApprovalStepVOs)  throws DAOException   {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String , String> paramMap = gemApprovalStepVOs.getColumnValues();			
			Map<String, String> velParam = paramMap;
			sqlExe.executeUpdate((ISQLTemplate) new GEMPlanningPerformanceDBDAOAddExpenseApprovalStepsCSQL(), paramMap, velParam);						
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

    }     
    
    /**
	 * 집행단위, 지역그룹|BU CTRL , 비용주관팀 , 사무국 에서 등록한 비용계획 수정<br>
	 * 
	 * @author J.Y.O
	 * @category CPS_GEM_0001_01
	 * @category modifyExpenseApprovalSteps
	 * 
     * @param List<GemApprovalStepVO> gemApprovalStepVOs  집행단위, 지역그룹|BU CTRL , 비용주관팀 , 사무국 에서 등록한 비용계획 정보
     * @throws DAOException
     */
    public void modifyExpenseApprovalSteps (List<GemApprovalStepVO> gemApprovalStepVOs)  throws DAOException   {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (gemApprovalStepVOs.size() > 0) {
				Map<String, Object> velParam = new HashMap<String, Object>();
				insCnt = sqlExe.executeBatch((ISQLTemplate) new GEMPlanningPerformanceDBDAOModifyExpenseApprovalStepsUSQL(), gemApprovalStepVOs, velParam);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

    }     

    /**
	 * 집행단위, 지역그룹|BU CTRL , 비용주관팀 , 사무국 에서 등록한 비용계획 수정<br>
	 * 
	 * @author J.Y.O
	 * @category CPS_GEM_0001_01
	 * @category modifyExpenseApprovalStep
	 * 
     * @param GemApprovalStepVO gemApprovalStepVO  집행단위, 지역그룹|BU CTRL , 비용주관팀 , 사무국 에서 등록한 비용계획 정보
     * @throws DAOException
     */
    public void modifyExpenseApprovalStep(GemApprovalStepVO gemApprovalStepVO)  throws DAOException   {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String , String> paramMap = gemApprovalStepVO.getColumnValues();			
			Map<String, String> velParam = paramMap;
			sqlExe.executeUpdate((ISQLTemplate) new GEMPlanningPerformanceDBDAOModifyExpenseApprovalStepUSQL(), paramMap, velParam);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

    }     
    
    /**
	 * 집행단위, 지역그룹|BU CTRL , 비용주관팀 , 사무국 에서 등록한 비용계획 삭제<br>
	 * 
	 * @author J.Y.O
	 * @category CPS_GEM_0001_01
	 * @category modifyExpenseApprovalSteps
	 * 
     * @param List<GemApprovalStepVO> gemApprovalStepVOs  집행단위, 지역그룹|BU CTRL , 비용주관팀 , 사무국 에서 등록한 비용계획 정보
     * @throws DAOException
     */
    public void removeExpenseApprovalSteps (List<GemApprovalStepVO> gemApprovalStepVOs)  throws DAOException   {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (gemApprovalStepVOs.size() > 0) {
				Map<String, Object> velParam = new HashMap<String, Object>();
				insCnt = sqlExe.executeBatch((ISQLTemplate) new GEMPlanningPerformanceDBDAORemoveExpenseApprovalStepsDSQL(), gemApprovalStepVOs, velParam);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

    }     
    
    /**
	 * 집행단위, 지역그룹|BU CTRL , 비용주관팀 , 사무국 에서 등록한 비용계획 Request No별 삭제<br>
	 * 
	 * @author J.Y.O
	 * @category CPS_GEM_0001_01
	 * @category removeExpenseApprovalStepsByRqstNo
	 * 
     * @param String genExpnRqstNo  집행단위, 지역그룹|BU CTRL , 비용주관팀 , 사무국 에서 등록한 비용계획 정보
     * @throws DAOException
     */
    public void removeExpenseApprovalStepsByRqstNo (String genExpnRqstNo)  throws DAOException   {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String , Object> paramMap = new HashMap<String, Object>();
			paramMap.put("gen_expn_rqst_no", genExpnRqstNo);
			Map<String, Object> velParam = new HashMap<String, Object>();
			sqlExe.executeUpdate((ISQLTemplate) new GEMPlanningPerformanceDBDAORemoveExpenseApprovalStepsByRqstNoDSQL(), paramMap, velParam);						
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

    }     
    
    /**
     * 비용계획 요청시 비용코드의 MAX(Item) 
     * @author J.Y.O
     * @category CPS_GEM_0001_01
     * @category searchMaxRqstNo
     * @param String genExpnRqstTpCd 예산구분 (EA,EI,ET)
     * @param String rqstOfcCd 요청부서
     * @return String null --> maxRqstNo 미존재  , maxRqstNo
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public String searchMaxRqstNo(String genExpnRqstTpCd, String rqstOfcCd) throws DAOException {
        
    	DBRowSet dbRowset = null;        
        
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
        	param.put("gen_expn_rqst_tp_cd", genExpnRqstTpCd);
        	param.put("rqst_ofc_cd", rqstOfcCd);
        	        	
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GEMPlanningPerformanceDBDAOSearchMaxRqstNoRSQL(), param, velParam);            
            
            if (dbRowset.next()) {
            	String maxRqstNo = dbRowset.getString(1);            	
            	return maxRqstNo;
            	 
            } else {
            	return null;
            }
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        
        
    }          

    
    /**
     * 집행단위, 지역그룹|BU CTRL , 비용주관팀 , 사무국 에서 등록한 비용계획을 조회
     * GEM_ITEM
     * @author J.Y.O
     * @category CPS_GEM-0105
     * @category searchExpensePlanning
     * @param String genExpnRqstNo
     * @param String rqstOfcCd 요청부서 로그인부서  
     * @param String creUsrId 로그인유저 아이디    
     * @return List<ItemVO>
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<ItemVO> searchExpensePlanning(String genExpnRqstNo ,String rqstOfcCd , String creUsrId) throws DAOException {
        DBRowSet dbRowset = null;
        
        List<ItemVO> list = null;
        
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
        	param.put("gen_expn_rqst_no", genExpnRqstNo);
        	param.put("rqst_ofc_cd", rqstOfcCd);
        	param.put("cre_usr_id", creUsrId);
        	velParam.putAll(param);
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GEMPlanningPerformanceDBDAOSearchExpensePlanningRSQL(), param, velParam);            
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, ItemVO.class);
            
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
     * TO 오피스 레벨3(L3) 조직 정보 취득 
     * Transfer
     * @author J.Y.O
     * @category CPS_GEM_0001_03
     * @category SearchToOfficeL3List
     * @param String toSlsOfcDivCd HQ,HO구분    
     * @param String toOfcLvl2 to office 레벨2
     * @param String fmOfcLvl3 from office 레벨3
     * @param String ofcCoDivCd 오피스 구분 투자법인 S 그외 O
     * @return String[]
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public String[] searchToOfficeL3List(String toSlsOfcDivCd , String toOfcLvl2 , String fmOfcLvl3 , String ofcCoDivCd) throws DAOException {
		DBRowSet dbRowset = null;
		String[] returnStr = null;
		
		try {
			Map<String,String> paramMap = new HashMap<String, String>();
	        //velocity parameter
	        Map<String, String> velParam = new HashMap<String, String>();
	        
			paramMap.put("to_sls_ofc_div_cd", toSlsOfcDivCd);
			paramMap.put("to_ofc_lvl2", toOfcLvl2);
			paramMap.put("fm_ofc_lvl3", fmOfcLvl3);
			paramMap.put("ofc_co_div_cd", ofcCoDivCd);
			velParam.putAll(paramMap);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GEMPlanningPerformanceDBDAOSearchToOfficeL3ListRSQL(),paramMap, velParam);
			returnStr = GemUtil.getArrayString(dbRowset, "code");
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return returnStr;
    }
    
    /**
     * TO 오피스 레벨2(L2) 조직 정보 취득 
     * Transfer
     * @author J.Y.O
     * @category CPS_GEM_0001_03
     * @category SearchToOfficeL2List
     * @param String toSlsOfcDivCd HQ,HO구분    
     * @param String toOfcLvl1 to office 레벨1
     * @param String fmOfcLvl2 from office 레벨2
     * @param String fmOfcLvl3 from office 레벨3
     * @param String ofcCoDivCd 오피스 구분 투자법인 S 그외 O
     * @return String[]
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public String[] searchToOfficeL2List(String toSlsOfcDivCd , String toOfcLvl1 ,String fmOfcLvl2 , String fmOfcLvl3  , String ofcCoDivCd) throws DAOException {
		DBRowSet dbRowset = null;
		String[] returnStr = null;
		
		try {
			Map<String,String> paramMap = new HashMap<String, String>();
	        //velocity parameter
	        Map<String, String> velParam = new HashMap<String, String>();
			paramMap.put("to_sls_ofc_div_cd", toSlsOfcDivCd);
			paramMap.put("to_ofc_lvl1", toOfcLvl1);
			paramMap.put("fm_ofc_lvl2", fmOfcLvl2);
			paramMap.put("fm_ofc_lvl3", fmOfcLvl3);
			paramMap.put("ofc_co_div_cd", ofcCoDivCd);
			velParam.putAll(paramMap);
			
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GEMPlanningPerformanceDBDAOSearchToOfficeL2ListRSQL(),paramMap, velParam);
			returnStr = GemUtil.getArrayString(dbRowset, "code");
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return returnStr;
    }      
    
    
	// ---------------------------------------------------------------------------
	// [CPS_GEM-0001_03] Expense Request – Adjustment
	// ---------------------------------------------------------------------------

    /**
     * 계획비용 요청에 대한 현황을 조회한다
     * @author J.Y.O
     * @category CPS_GEM_0001_02
     * @category searchExpensePlanningStatus
     * @param PlanningStatusCondVO planningStatusCondVO
     * @return List<PlanningStatusVO>
     * @throws DAOException
     */    
    public List<PlanningStatusVO> searchExpensePlanningStatus(PlanningStatusCondVO planningStatusCondVO) throws DAOException {
        DBRowSet dbRowset = null;
        
        List<PlanningStatusVO> list = null;
        
        //query parameter
        Map<String, String> param = new HashMap<String, String>();        
        //velocity parameter
        Map<String, String> velParam = new HashMap<String, String>();

        try {
        	param = planningStatusCondVO.getColumnValues();        	
        	
        	param.putAll(param);
        	velParam.putAll(param);
        	
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GEMPlanningPerformanceDBDAOSearchExpensePlanningStatusRSQL(), param, velParam);            
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, PlanningStatusVO.class);
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        
        return list;
    }      
        
    
	// ---------------------------------------------------------------------------
	// [CPS_GEM-0003] Approve 
	// ---------------------------------------------------------------------------


    /**
     * 오피스 정보 조회
     * @author J.Y.O
     * @category CPS_GEM_0001_02
     * @category searchExpensePlanningStatus
     * @param GemOfficeVO gemOfficeVO  
     * @return List<GemOfficeVO>
     * @throws DAOException
     */    
    public List<GemOfficeVO> searchOfficeInfo(GemOfficeVO gemOfficeVO) throws DAOException {
        DBRowSet dbRowset = null;
        
        List<GemOfficeVO> list = null;
        
        //query parameter
        Map<String, String> param = new HashMap<String, String>();        
        //velocity parameter
        Map<String, String> velParam = new HashMap<String, String>();

        try {
        	param = gemOfficeVO.getColumnValues();        	
        	
        	param.putAll(param);
        	velParam.putAll(param);
        	
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GEMPlanningPerformanceDBDAOSearchOfficeInfoRSQL(), param, velParam);            
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, GemOfficeVO.class);
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        
        return list;
    }          
    
	// ---------------------------------------------------------------------------
	// [CPS_GEM-0002] Processing Status 
	// ---------------------------------------------------------------------------
    
    /**
     * Processing Status 정보 조회
     * @author J.Y.O
     * @category [CPS_GEM-0002] Processing Status
     * @category searchProcessingStatus
     * @param PlanningStatusCondVO planningStatusCondVO  
     * @return List<SearchProcessingStatusVO>
     * @throws DAOException
     */    
    public List<SearchProcessingStatusVO> searchProcessingStatus(PlanningStatusCondVO planningStatusCondVO) throws DAOException {
        DBRowSet dbRowset = null;
        
        List<SearchProcessingStatusVO> list = null;
        
        //query parameter
        Map<String, String> param = new HashMap<String, String>();        
        //velocity parameter
        Map<String, String> velParam = new HashMap<String, String>();

        try {
        	param = planningStatusCondVO.getColumnValues();        	
        	
        	param.putAll(param);
        	velParam.putAll(param);
        	
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GEMPlanningPerformanceDBDAOSearchProcessingStatusRSQL(), param, velParam);            
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchProcessingStatusVO.class);
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        
        return list;
    }       
    
    
	// ---------------------------------------------------------------------------
	// [CPS_GEM-0023] Request / Initial _ Print 
	// ---------------------------------------------------------------------------

    /**
     * Expense Request 중 Initial 인쇄 화면
     * @author J.Y.O
     * @category CPS_GEM_0001_02
     * @category report0023R1
     * @param String genExpnRqstNo request no
     * @param String genExpnRqstSeq request sequence
     * @param String langDiv 언어구분 KOR , ENG   
     * @param String acctXchRtYrmon 예산년도 yyyy
     * @return List<Report0023R1VO>
     * @throws DAOException
     */    
    public List<Report0023R1VO> report0023R1(String  genExpnRqstNo , String genExpnRqstSeq, String langDiv , String acctXchRtYrmon ) throws DAOException {
        DBRowSet dbRowset = null;
        
        List<Report0023R1VO> list = null;
        
        //query parameter
        Map<String, String> param = new HashMap<String, String>();        
        //velocity parameter
        Map<String, String> velParam = new HashMap<String, String>();

        try {
        	param.put("gen_expn_rqst_no", genExpnRqstNo);
        	param.put("gen_expn_rqst_seq", genExpnRqstSeq);
        	param.put("lang_div", langDiv);        	
        	param.put("acct_xch_rt_yrmon", acctXchRtYrmon);
        	velParam.putAll(param);        	
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GEMPlanningPerformanceDBDAOReport0023R1RSQL(), param, velParam);            
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, Report0023R1VO.class);
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        
        return list;
    }          
    
    
	// ---------------------------------------------------------------------------
	// [CPS_GEM-0025] Adjustment / Initial _ Print 
	// ---------------------------------------------------------------------------

    /**
     * Adjustment / Initial _ Print
     * 
     * @author J.Y.O
     * @category CPS_GEM_0025
     * @category report0025R1
     * @param genExpnRqstNo request no
     * @param genExpnRqstSeq request sequence
     * @param langDiv 언어구분 KOR , ENG   
     * @return List<Report0025R1VO>
     * @throws DAOException
     */    
    public List<Report0025R1VO> report0025R1(String  genExpnRqstNo ,String genExpnRqstSeq, String langDiv) throws DAOException {

    	DBRowSet dbRowset = null;
        
        List<Report0025R1VO> list = null;
        
        //query parameter
        Map<String, String> param = new HashMap<String, String>();        
        //velocity parameter
        Map<String, String> velParam = new HashMap<String, String>();

        try {
        	param.put("gen_expn_rqst_no", genExpnRqstNo);
        	param.put("gen_expn_rqst_seq", genExpnRqstSeq);
        	param.put("lang_div", langDiv);        	
        	
        	velParam.putAll(param);        	
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GEMPlanningPerformanceDBDAOReport0025R1RSQL(), param, velParam);            
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, Report0025R1VO.class);            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        
        return list;
    }              
    
	// =================================================================================
	// C.J.M 
	// =================================================================================
    
    // ---------------------------------------------------------------------------
	// [FNS009-0001] Receive WebLogic JMS Queue Proxy
	// ---------------------------------------------------------------------------
    
    /**
     * GEM_SLP_IF Table에 SLP_TJ_NO입력값을 중복 체크한다 <br>
	 * 
	 * @author choijungmi
     * @category FNS009_0001
     * @category searchSlpIfCheck
	 * 
	 * @param String slpTjNo
     * @param String slpSeqNo
	 * @return boolean 결과값 1 정상  2, 키에러  3, 잘못된코드
	 * @exception EventException
	 */
    public boolean searchSlpIfCheck(String slpTjNo, String slpSeqNo) throws DAOException {
    	  
        DBRowSet dbRowset = null;
        
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {    
        	param.put("slp_tj_no", slpTjNo);
        	param.put("slp_seq_no", slpSeqNo);
        	
        	velParam.put("slp_tj_no", slpTjNo);
        	velParam.put("slp_seq_no", slpSeqNo);
        	
        	//log.info("##### param : "+param.toString());
			//log.info("##### velParam : "+velParam.toString());
        	
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GEMPlanningPerformanceDBDAOSearchSlpIfCheckRSQL(), param, velParam);
			//log.info(":::::>>> dbRowset.getRowCount() : "+dbRowset.getRowCount());
			if (dbRowset.getRowCount() > 0) {
				return true;
			}

			return false;
           
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
        }         

    }
    
    /**
     * Data Transfer Object Including Parameters
     * 
     * @author choijungmi
     * @category FNS009-0001, FNS003-0001
     * @category addGemSlipIfs
     * 
     * @param GemSlpIfVO gemSlpIfVO
     * @return int
     * 
     */
    public int addSlipIf(GemSlpIfVO gemSlpIfVO) throws DAOException {
    	int insCnt = 0;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String , String> paramMap = gemSlpIfVO.getColumnValues();
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			log.info("::::: >>> addSlipIf : ");
			insCnt = sqlExe.executeUpdate((ISQLTemplate) new GEMPlanningPerformanceDBDAOAddSlipIfCSQL(), paramMap, velParam);			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		}
		return insCnt;
    }
    
    /**
	 * 3.ERP로부터 일반관리비 비용집계 대상 전표 정보 조회
     * 
     * @author choijungmi
     * @category FNS009-0001, FNS003-0001
     * @category searchSlpIf

     * @param  String slpTjNo
     * @param  String slpSeqNo
     * @param  String glEffDt    
     * @return List<GemSlpIfVO> 
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
	public List<GemSlpIfVO> searchSlpIf(String slpTjNo, String slpSeqNo, String glEffDt) throws DAOException {
    	DBRowSet dbRowset = null;
		List<GemSlpIfVO> list = new ArrayList<GemSlpIfVO>();

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		//velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("slp_tj_no", slpTjNo);
			param.put("slp_seq_no", slpSeqNo);
			param.put("gl_eff_dt", glEffDt);
			
			velParam.put("slp_tj_no", slpTjNo);
			velParam.put("slp_seq_no", slpSeqNo);
			velParam.put("gl_eff_dt", glEffDt);
			
			log.info("::::: >>> 3.searchSlpIf() ");
        	dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GEMPlanningPerformanceDBDAOSearchSlpIfRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, GemSlpIfVO.class);
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		}
		
		return list;
	}
    
    /**
	 * 4.A/P 품의서를 작성한 Center 의 Office 를 조회한다.
	 * 
	 * @author choijungmi
	 * @category FNS009-0001, FNS003-0001
	 * @category searchCsrCtr
	 * 
	 * @param String ofcCd
	 * @return String
	 * @throws DAOException
	 */
	public String searchCsrCtr(String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		String returnStr = "";
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		//velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
		try {
			param.put("code", ofcCd);
			velParam.put("code", ofcCd);
			
			log.info("::::: >>> 4.searchCsrCtr() ");
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GEMPlanningPerformanceDBDAOSearchCsrCtrRSQL(), param, velParam);
			if(dbRowset.getRowCount() > 0) {
				while(dbRowset.next()) {
					returnStr = dbRowset.getString("code");
				}
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		}
		return returnStr;
	}
	
	/**
	 * 5.품의서의 실제 지급 Center Code 에 대한 조직(Office) 를 조회한다.
	 * 
	 * @author choijungmi
	 * @category FNS009-0001, FNS003-0001
	 * @category searchCtrOfc
	 * 
	 * @param String slpCtrCd
	 * @return String
	 * @throws DAOException
	 */
	public String searchCtrOfc(String slpCtrCd) throws DAOException {
		DBRowSet dbRowset = null;
		String returnStr = "";
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		//velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
		try {
			param.put("code", slpCtrCd);
			velParam.put("code", slpCtrCd);
			
			log.info("::::: >>> 5.searchCtrOfc() ");
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GEMPlanningPerformanceDBDAOSearchCtrOfcRSQL(), param, velParam);
			if(dbRowset.getRowCount() == 1) {
				while(dbRowset.next()) {
					returnStr = dbRowset.getString("code");
				}
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		}
		return returnStr;
	}
	
	/**
	 * 6.품의서의 Office Code 와 Center Code 중 실제 실적 반영 조직을 조회한다.
	 * 
	 * @author choijungmi
	 * @category FNS009-0001, FNS003-0001
	 * @category searchSlpCtr
	 * 
	 * @param String csrCtrCd
	 * @param String csrOfcCd
	 * @param String slpCtrCd
	 * @param String acctCd
	 * @param String glEffDt
	 * @return String
	 * @throws DAOException
	 */
	public String searchSlpCtr(String csrCtrCd, String csrOfcCd, String slpCtrCd, String acctCd, String glEffDt) throws DAOException {
		DBRowSet dbRowset = null;
		String returnStr = "";
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		//velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
		try {
			param.put("csr_ctr_cd", csrCtrCd);
			param.put("csr_ofc_cd", csrOfcCd);			
			param.put("slp_ctr_cd", slpCtrCd);
			param.put("acct_cd", acctCd);
			param.put("gl_eff_dt", glEffDt);
			
			velParam.put("csr_ctr_cd", csrCtrCd);
			velParam.put("csr_ofc_cd", csrOfcCd);			
			velParam.put("slp_ctr_cd", slpCtrCd);
			velParam.put("acct_cd", acctCd);
			velParam.put("gl_eff_dt", glEffDt);
			
			//log.info("##### param : "+param.toString());
			//log.info("##### velParam : "+velParam.toString());
			
			log.info("::::: >>> 6.searchSlpCtr() ");
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GEMPlanningPerformanceDBDAOSearchSlpCtrRSQL(), param, velParam);
			if(dbRowset.getRowCount() > 0) {
				while(dbRowset.next()) {
					returnStr = dbRowset.getString("code");
				}
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		}
		return returnStr;
	}
	
	/**
	 * 7.일반관리비 실적 비용 집계를 위한 조직 코드 를 조회한다 ( office , sub office )
     * 
     * @author choijungmi
     * @category FNS009-0001, FNS003-0001
     * @category searchOfcBySubOfc

     * @param  String glEffDt
     * @param  String rsltCtrCd    
     * @return RsltSlpIfVO
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
	public RsltSlpIfVO searchOfcBySubOfc(String glEffDt, String rsltCtrCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltSlpIfVO> list = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		//velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("gl_eff_dt", glEffDt);
			param.put("rslt_ctr_cd", rsltCtrCd);
			
			velParam.put("gl_eff_dt", glEffDt);
			velParam.put("rslt_ctr_cd", rsltCtrCd);
			
			log.info("::::: >>> 7.searchOfcBySubOfc() ");
        	dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GEMPlanningPerformanceDBDAOSearchOfcBySubOfcRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltSlpIfVO.class);
			if (list != null && !list.isEmpty()) {
            	return list.get(0);
            }
            
            return null;			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		}
	}
    
    /**
	 * 8.일반관리비 실적 비용 집계를 위한 비용 코드 를 조회한다 ( expense , sub expense )
     * 
     * @author choijungmi
     * @category FNS009-0001, FNS003-0001
     * @category searchExpnBySubExpn

     * @param  String glEffDt
     * @param  String rsltOfcCd
     * @param  String acctCd    
     * @return RsltSlpIfVO
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
	public RsltSlpIfVO searchExpnBySubExpn(String glEffDt, String rsltOfcCd, String acctCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltSlpIfVO> list = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		//velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("gl_eff_dt", glEffDt);
			param.put("rslt_ofc_cd", rsltOfcCd);
			param.put("acct_cd", acctCd);
			
			velParam.put("gl_eff_dt", glEffDt);
			velParam.put("rslt_ofc_cd", rsltOfcCd);
			velParam.put("acct_cd", acctCd);
			
			log.info("::::: >>> 8.searchExpnBySubExpn() ");
        	dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GEMPlanningPerformanceDBDAOSearchExpnBySubExpnRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltSlpIfVO.class);
			if (list != null && !list.isEmpty()) {
            	return list.get(0);
            }
            
            return null;			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		}
	}
    
    /**
	 * 9. 품의서의 표기해줄 해당년월까지의 예산을 조회한다. ( 조직 , 비용별 )
     * 
     * @author choijungmi
     * @category FNS009-0001, FNS003-0001
     * @category searchPlanExpn

     * @param  String glEffDt
     * @param  String rsltOfcCd
     * @param  String rsltExpnCd    
     * @return BigDecimal
     * @throws DAOException
     */
    public BigDecimal searchPlanExpn(String glEffDt, String rsltOfcCd, String rsltExpnCd) throws DAOException {
		DBRowSet dbRowset = null;
		BigDecimal returnVal = new BigDecimal("0");

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		//velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("gl_eff_dt", glEffDt);
			param.put("rslt_ofc_cd", rsltOfcCd);
			param.put("rslt_expn_cd", rsltExpnCd);
			
			velParam.put("gl_eff_dt", glEffDt);
			velParam.put("rslt_ofc_cd", rsltOfcCd);
			velParam.put("rslt_expn_cd", rsltExpnCd);
			
			log.info("::::: >>> 9.searchPlanExpn() ");
        	dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GEMPlanningPerformanceDBDAOSearchPlanExpnRSQL(), param, velParam);
        	if(dbRowset.getRowCount() > 0) {
				while(dbRowset.next()) {
					returnVal = dbRowset.getBigDecimal("code");
				}
        	} else {returnVal = new BigDecimal(0);}
            
            return returnVal;			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		}
	}
    
    /**
	 * 10. 품의서의 표기해줄 해당년월까지의 누적실적을 조회한다 ( 조직 , 비용별 )
     * 
     * @author choijungmi
     * @category FNS009-0001, FNS003-0001
     * @category searchPerfSlp

     * @param  GemRsltSmryVO gemRsltSmryVO    
     * @return BigDecimal
     * @throws DAOException
     */
    public BigDecimal searchPerfSlp(GemRsltSmryVO gemRsltSmryVO) throws DAOException {
		DBRowSet dbRowset = null;
		BigDecimal returnVal = new BigDecimal("0");

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		//velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("gl_eff_dt", gemRsltSmryVO.getRsltYrmon());
			param.put("rslt_ofc_cd", gemRsltSmryVO.getOfcCd());
			param.put("sub_ofc_cd", gemRsltSmryVO.getSubOfcCd());
			param.put("rslt_expn_cd", gemRsltSmryVO.getGenExpnCd());
			param.put("sub_gen_expn_cd", gemRsltSmryVO.getSubGenExpnCd());
			param.put("ofc_co_div_cd", gemRsltSmryVO.getOfcCoDivCd());
			log.info("::::: >>> 10.searchPerfSlp() ");
        	dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GEMPlanningPerformanceDBDAOSearchPerfSlpRSQL(), param, velParam);
			if(dbRowset.getRowCount() > 0) {
				while(dbRowset.next()) {
					BigDecimal amt  = dbRowset.getBigDecimal("amt");					
					if (amt != null) {
						returnVal = returnVal.add(amt);
					}					
				}
			} else {returnVal = new BigDecimal(0);}
            
            return returnVal;			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		}
	}
    
    /**
	 * 11. 품의서의 전표금액을 조직의 Local Currency 기준으로 전환 한다.
     * 
     * @author choijungmi
     * @category FNS009-0001, FNS003-0001
     * @category searchSlpAmtConversion

     * @param  String glEffDt
     * @param  String slpCurrCd
     * @param  String ofcCurrCd
     * @param  String slpAmt    
     * @return BigDecimal
     * @throws DAOException
     */
    public BigDecimal searchSlpAmtConversion(String glEffDt, String slpCurrCd, String ofcCurrCd, String slpAmt) throws DAOException {
		DBRowSet dbRowset = null;
		BigDecimal returnVal = new BigDecimal("0");

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		//velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("gl_eff_dt", glEffDt);
			param.put("slp_curr_cd", slpCurrCd);
			param.put("ofc_curr_cd", ofcCurrCd);
			param.put("slp_amt", slpAmt);
			
			velParam.put("gl_eff_dt", glEffDt);
			velParam.put("slp_curr_cd", slpCurrCd);
			velParam.put("ofc_curr_cd", ofcCurrCd);
			velParam.put("slp_amt", slpAmt);
			
			//log.info("##### param : "+param.toString());
			//log.info("##### velParam : "+velParam.toString());
			
			log.info("::::: >>> 11.searchSlpAmtConversion() ");
        	dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GEMPlanningPerformanceDBDAOSearchSlpAmtConversionRSQL(), param, velParam);
        	//log.info("##### dbRowset.getRowCount() : "+dbRowset.getRowCount());
        	if(dbRowset.getRowCount() > 0) {
				while(dbRowset.next()) {
					returnVal = dbRowset.getBigDecimal("code");
				}
			} else {returnVal = new BigDecimal(0);}
            
            return returnVal;			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		}
	}
	
    /**
     * 12. ERP(G/L)로부터 일반관리비 비용집계 대상 전표(실적)에 대하여 회계마감(G/L마감) 이후 월 1회 I/F 
     * 
     * @author choijungmi
     * @category FNS009-0001, FNS003-0001
     * @category addGemSlpPerf
     * 
     * @param GemSlpPerfVO gemSlpPerfVO 
     * @exception DAOException 
     */
    public void addGemSlpPerf(GemSlpPerfVO gemSlpPerfVO) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String , String> paramMap = gemSlpPerfVO.getColumnValues();
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			log.info("::::: >>> 12.addGemSlpPerf() ");
			sqlExe.executeUpdate((ISQLTemplate) new GEMPlanningPerformanceDBDAOAddGemSlpPerfCSQL(), paramMap, velParam);			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		}

    }
    
    /**
     * 13.GEM_RSLT_SMRY Table에 입력값을 중복 체크한다 <br>
	 * 
	 * @author choijungmi
     * @category FNS009_0001, FNS003-0001
     * @category searchRsltSmryCheck
	 * 
	 * @param GemRsltSmryVO gemRsltSmryVO
	 * @return boolean
	 * @exception DAOException
	 */
    public boolean searchRsltSmryCheck(GemRsltSmryVO gemRsltSmryVO) throws DAOException {    	  
        DBRowSet dbRowset = null;
        
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        Boolean rtnStr = true;
        try {    
        	if(gemRsltSmryVO != null) {
	        	Map<String, String> mapVO = gemRsltSmryVO.getColumnValues();
	        	param.putAll(mapVO);
	        	velParam.putAll(mapVO);
        	}
        	
        	log.info("::::: >>> 13.searchRsltSmryCheck() ");
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GEMPlanningPerformanceDBDAOSearchRsltSmryCheckRSQL(), param, velParam);
			if (dbRowset.getRowCount() == 0) {
				rtnStr = false;
			}
			
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
        }         

        return rtnStr;
    }
    
    /**
     * 14. ERP(G/L)로부터 일반관리비 비용집계 대상 전표(실적)에 대하여 회계마감(G/L마감) 이후 월 1회 I/F  
     * 
     * @author choijungmi
     * @category FNS009-0001, FNS003-0001
     * @category addGemRsltSmry
     * 
     * @param GemRsltSmryVO gemRsltSmryVO 
     * @exception DAOException
     */
    public void addGemRsltSmry(GemRsltSmryVO gemRsltSmryVO) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String , String> paramMap = gemRsltSmryVO.getColumnValues();
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			log.info("::::: >>> 14.addGemRsltSmry() ");
			sqlExe.executeUpdate((ISQLTemplate) new GEMPlanningPerformanceDBDAOAddGemRsltSmryCSQL(), paramMap, velParam);			
		} catch (SQLException se) {
			log.error("DAO SQLException : "+se.getMessage(), se);
			throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		} catch (Exception ex) {
			log.error("DAO Exception : "+ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		}
    }
    
    /**
     * 15. ERP(G/L)로부터 일반관리비 비용집계 대상 전표(실적)에 대하여 회계마감(G/L마감) 이후 월 1회 I/F  
     * 
     * @author choijungmi
     * @category FNS009-0001, FNS003-0001
     * @category modifyGemRsltSmry
     * 
     * @param GemRsltSmryVO gemRsltSmryVO 
     * @exception DAOException
     */
    public void modifyGemRsltSmry(GemRsltSmryVO gemRsltSmryVO) throws DAOException {
		try {
			
			SQLExecuter sqlExe = new SQLExecuter("");			
	        //query parameter
	        Map<String, String> param = gemRsltSmryVO.getColumnValues();
	        Map<String, String> velParam = param;
	        
	        log.info("::::: >>> 15.modifyGemRsltSmry() ");
	        sqlExe.executeUpdate((ISQLTemplate) new GEMPlanningPerformanceDBDAOModifyGemRsltSmryUSQL() , param, velParam);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		}
    
    }
    
    /**
     * 16. 품의서의 기표된 전표가 모두 반영되었으면, Interface 완료 flag 를 update 한다.  
     * 
     * @author choijungmi
     * @category FNS009-0001, FNS003-0001
     * @category modifySlipIf
     * 
     * @param String slpTjNo
     * @param String slpSeqNo
     * @exception DAOException 
     */
    public void modifySlipIf(String slpTjNo, String slpSeqNo) throws DAOException {
		try {
			
			SQLExecuter sqlExe = new SQLExecuter("");			
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("slp_tj_no", slpTjNo);
			param.put("slp_seq_no", slpSeqNo);
			
			log.info("::::: >>> 16.modifySlipIf() ");
	        sqlExe.executeUpdate((ISQLTemplate) new GEMPlanningPerformanceDBDAOModifySlipIfUSQL() , param, null);			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		}    
    }
    
    // ---------------------------------------------------------------------------
	// [FNS051-0001] Receive WebLogic JMS Queue Proxy
	// ---------------------------------------------------------------------------
    
    /**
     * ERP(A/P) 로부터 기 I/F 된 전표번호를 받아, 조직별 비용예산 및 실적집계 , 예산대비실적 집행률 을 전송한다.<br>
	 * 
	 * @author choijungmi
     * @category FNS051_0001
     * @category searchPerformanceRatio
	 * 
	 * @param String slpTjNo
	 * @return List<GemSlpPerfVO>
	 * @exception DAOException
	 */
    @SuppressWarnings("unchecked")
	public List<GemSlpPerfVO> searchPerformanceRatio(String slpTjNo) throws DAOException {    	  
        DBRowSet dbRowset = null;
        List<GemSlpPerfVO> list = new ArrayList<GemSlpPerfVO>();
        //String returnStr = "";
        
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {    
        	param.put("slp_tj_no", slpTjNo);
        	velParam.put("slp_tj_no", slpTjNo);
        	
        	dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GEMPlanningPerformanceDBDAOSearchPerformanceRatioRSQL(), param, velParam);
        	list = (List) RowSetUtil.rowSetToVOs(dbRowset, GemSlpPerfVO.class);
        	/*
			if(dbRowset.getRowCount() > 0) {
				while(dbRowset.next()) {
					returnStr = dbRowset.getString("code");
				}
			}
			*/
        } catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
        } catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
        }
        return list;
    }    
    
    // ---------------------------------------------------------------------------
	// [FNS061-0001] Receive WebLogic JMS Queue Proxy
	// ---------------------------------------------------------------------------
    
    /**
     * ERP(A/P)에서 ERP스케줄러에 의하여 당일 승인한 품의서의 품의자 ID , 승인자 ID 정보를 전송한다.  
     * 
     * @author choijungmi
     * @category FNS061-0001
     * @category modifyApproUsrId
     * 
     * @param String slpTjNo
     * @param String prprUsrId
     * @param String aproUsrId
     * @param String updUsrId 
     * 
     */
    public void modifyApproUsrId(String slpTjNo, String prprUsrId, String aproUsrId, String updUsrId) throws DAOException {
		try {			
			SQLExecuter sqlExe = new SQLExecuter("");			

			//query parameter
	        Map<String, String> param = new HashMap<String, String>();
	        param.put("slp_tj_no", slpTjNo);
	        param.put("prpr_usr_id", prprUsrId);
	        param.put("apro_usr_id", aproUsrId);
	        param.put("upd_usr_id", updUsrId);
	        
	        log.info("::::: >>> modifyApproUsrId() ");
	        sqlExe.executeUpdate((ISQLTemplate) new GEMPlanningPerformanceDBDAOModifyGemSlpIfApproUsrIdUSQL() , param, null);
	        sqlExe.executeUpdate((ISQLTemplate) new GEMPlanningPerformanceDBDAOModifyGemSlpPerfApproUsrIdUSQL() , param, null);
	        
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		}    
    }
    
    // ---------------------------------------------------------------------------
	// [CPS_GEM_0019] Detail_Yearly Expense
	// ---------------------------------------------------------------------------
    
    /**
     * CPS_GEM_0019(01)화면의 DownExcel클릭시 Yearly Expense 검색관련 조회.
	 * 
	 * @author choijungmi
     * @category CPS_GEM_0019_01
     * @category searchDetailByYearlyExpense
	 * 
	 * @param SearchYearlyExpenseVO searchYearlyExpenseVO
	 * @return List<DetailYearlyExpenseVO>
	 * @exception DAOException
	 */
    @SuppressWarnings("unchecked")
	public List<DetailYearlyExpenseVO> searchDetailByYearlyExpense(SearchYearlyExpenseVO searchYearlyExpenseVO) throws DAOException {    	  
        DBRowSet dbRowset = null;
        List<DetailYearlyExpenseVO> list = new ArrayList<DetailYearlyExpenseVO>();
        
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {    
        	if(searchYearlyExpenseVO != null) {
        		Map<String, String> mapVO = searchYearlyExpenseVO.getColumnValues();
	        	param.putAll(mapVO);
	        	velParam.putAll(mapVO);
	        	
				 String schExpenseGroup  = searchYearlyExpenseVO.getSchExpenseGroup();				 
				 if (!StringUtils.isEmpty(schExpenseGroup)) {					 
					 schExpenseGroup = GemUtil.getInSqlChar(schExpenseGroup.split(","));
					 param.put("sch_expense_group", schExpenseGroup);
					 velParam.put("sch_expense_group", schExpenseGroup);
					 
				 }
				 
        	}
        	
        	dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GEMPlanningPerformanceDBDAOSearchDetailByYearlyExpenseRSQL(), param, velParam);
        	list = (List) RowSetUtil.rowSetToVOs(dbRowset, DetailYearlyExpenseVO.class);
        	
        } catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
        } catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
        }
        return list;
    }
    
    /**
     * CPS_GEM_0019(02)화면의 DownExcel클릭시 Request Expense of Initial 검색 관련 코드 조회.
	 * 
	 * @author choijungmi
     * @category CPS_GEM_0019_02
     * @category searchDetailByRequestExpense
	 * 
	 * @param SearchYearlyExpenseVO searchYearlyExpenseVO
	 * @return List<DetailRequestExpenseVO>
	 * @exception DAOException
	 */
    @SuppressWarnings("unchecked")
	public List<DetailRequestExpenseVO> searchDetailByRequestExpense(SearchYearlyExpenseVO searchYearlyExpenseVO) throws DAOException {    	  
        DBRowSet dbRowset = null;
        List<DetailRequestExpenseVO> list = new ArrayList<DetailRequestExpenseVO>();
        
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {    
        	if(searchYearlyExpenseVO != null) {
        		// 로그인한 조직 코드
        		//searchYearlyExpenseVO.setAuthOfcCd(authOfcCd);
        		String strSchAppDivGbn = searchYearlyExpenseVO.getSchAppDivGbn()==null?"ALL":"".equals(searchYearlyExpenseVO.getSchAppDivGbn())?"ALL":searchYearlyExpenseVO.getSchAppDivGbn();
        		searchYearlyExpenseVO.setSchAppDivGbn(strSchAppDivGbn);
	        	Map<String, String> mapVO = searchYearlyExpenseVO.getColumnValues();
	        	param.putAll(mapVO);
	        	velParam.putAll(mapVO);
        	}
        	
        	dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GEMPlanningPerformanceDBDAOSearchDetailByRequestExpenseRSQL(), param, velParam);
        	list = (List) RowSetUtil.rowSetToVOs(dbRowset, DetailRequestExpenseVO.class);
        	
        } catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
        } catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
        }
        return list;
    }
    
    /**
     * CPS_GEM_0019(03)화면의 DownExcel클릭시 Request Expense of Initial의 Detail RQST No 검색 관련 코드 조회.
	 * 
	 * @author choijungmi
     * @category CPS_GEM_0019_03
     * @category searchDetailByRequestExpenseRqstNo
	 * 
	 * @param SearchYearlyExpenseVO searchYearlyExpenseVO
	 * @return List<DetailRequestExpenseVO>
	 * @exception DAOException
	 */
    @SuppressWarnings("unchecked")
	public List<DetailRequestExpenseRqstNoVO> searchDetailByRequestExpenseRqstNo(SearchYearlyExpenseVO searchYearlyExpenseVO) throws DAOException {    	  
        DBRowSet dbRowset = null;
        List<DetailRequestExpenseRqstNoVO> list = new ArrayList<DetailRequestExpenseRqstNoVO>();
        
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {    
        	if(searchYearlyExpenseVO != null) {
        		Map<String, String> mapVO = searchYearlyExpenseVO.getColumnValues();
	        	param.putAll(mapVO);
	        	velParam.putAll(mapVO);
        	}
        	
        	dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GEMPlanningPerformanceDBDAOSearchDetailByRequestExpenseRqstNoRSQL(), param, velParam);
        	list = (List) RowSetUtil.rowSetToVOs(dbRowset, DetailRequestExpenseRqstNoVO.class);
        	
        } catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
        } catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
        }
        return list;
    }
    
    // =================================================================================
	// P.C.J 
	// =================================================================================
    /**
	 * 현지법인의 실적을 월별로 조회한다
     * 
     * @author P.C.J
     * @category CPS_GEM-0004
     * @category searchSubsidiaryActualResults     
     * @param ActRsltSubsPerfVO actRsltSubsPerfVO  
     * @return List<SubsPerfVO>
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<SubsPerfVO> searchSubsidiaryActualResults(ActRsltSubsPerfVO actRsltSubsPerfVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SubsPerfVO> list = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		//velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if(actRsltSubsPerfVO != null){
				 			 
				 Map<String, String> mapVO = actRsltSubsPerfVO.getColumnValues();
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);				 
				 				 
			 }			 
	 
        	dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GEMPlanningPerformanceDBDAOSearchSubsidiaryActualResultsRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SubsPerfVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		}
		return list;
	}
    
    /**
     * 월별 현지법인 실적 입력을 위해서, 마감 일정을 조회한다, 최종 마감 년월을 조회하여, 실적을 입력할 년월을 구한다. 
     * @author P.C.J
     * @category CPS_GEM-0004
     * @category searchPerfClosingDate
     * @param String ofcCd
     * @return String 실적을 입력할 년월
     * @throws DAOException
     */

    public String searchPerfClosingDate(String ofcCd) throws DAOException {
        
    	DBRowSet dbRowset = null;        
        
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {      	
        	
        	param.put("ofc_cd", ofcCd);
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GEMPlanningPerformanceDBDAOSearchPerfClosingDateRSQL(), param, velParam);            
            
            if (dbRowset.next()) {
            	String maxItemNo = dbRowset.getString(1);
            	return maxItemNo;
            	 
            } else {
            	return null;
            }
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
        }
        
        
    }
    
    /**
     * ClosingDate를 구한다.
     * @author P.C.J
     * @category CPS_GEM-0015
     * @category searchPlanningPerfClosingDate
     * @return String ClosingDate
     * @throws DAOException
     */

    public String searchPlanningPerfClosingDate() throws DAOException {
        
    	DBRowSet dbRowset = null;        
        
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {      	
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GEMPlanningPerformanceDBDAOSearchPlanningPerfClosingDateRSQL(), param, velParam);            
            
            if (dbRowset.next()) {
            	String maxItemNo = dbRowset.getString(1);
            	return maxItemNo;
            	 
            } else {
            	return null;
            }
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
        }
        
        
    }
    
    /**
	 * 일반관리비 비용계획을 요청할수 있는 집행단위 조직이 사용할수 있는 비용코드(Expense Code)를 조회한다
     * 
     * @author P.C.J
     * @category CPS_GEM-0004
     * @category searchOfficeExpenseMatrixLIstByExpense    
     * @param ActRsltSubsPerfVO actRsltSubsPerfVO      
     * @return List<SubsPerfVO>
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<SubsPerfVO> searchOfficeExpenseMatrixLIstByExpense(ActRsltSubsPerfVO actRsltSubsPerfVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SubsPerfVO> list = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		//velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if(actRsltSubsPerfVO != null){
				 			 
				 Map<String, String> mapVO = actRsltSubsPerfVO.getColumnValues();
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);				 
				 				 
			 }			 
	 
        	dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GEMPlanningPerformanceDBDAOSearchOfficeExpenseMatrixLIstByExpenseRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SubsPerfVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		}
		return list;
	}
    
    /**
     * 투자법인 실적을 저장하기 위해서, 기존의 데이타가 존재하는지 여부 체크 
     * @author P.C.J
     * @category CPS_GEM-0004
     * @category searchSubsidiaryCheck
     * @param String rsltYrmon
     * @param String ofcCd
     * @param String genExpnCd 
     * @return String --> I, not null --> U
     * @throws DAOException
     */

    public String searchSubsidiaryCheck(String rsltYrmon, String ofcCd, String genExpnCd) throws DAOException {
        
    	DBRowSet dbRowset = null;        
        
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
        	param.put("rslt_yrmon", rsltYrmon);
        	param.put("ofc_cd", ofcCd);
        	param.put("gen_expn_cd", genExpnCd);
        	        	
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GEMPlanningPerformanceDBDAOSearchSubsidiaryCheckRSQL(), param, velParam);            
            
            if (dbRowset.next()) {
            	String uiFlag = dbRowset.getString(1);            	
            	return uiFlag;
            	 
            } else {
            	return null;
            }
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
        }
        
        
    }
    
    /**
     * 투자법인 실적을 저장하기 위해서, 기존의 데이타가 존재하는지 여부 체크 
     * @author P.C.J
     * @category CPS_GEM-0004
     * @category searchMonSmryCheck
     * @param String rsltYrmon
     * @param String ofcCd
     * @param String genExpnCd
     * @return String --> I, not null --> U
     * @throws DAOException
     */

    public String searchMonSmryCheck(String rsltYrmon, String ofcCd, String genExpnCd) throws DAOException {
        
    	DBRowSet dbRowset = null;        
        
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
        	param.put("rslt_yrmon", rsltYrmon);
        	param.put("ofc_cd", ofcCd);
        	param.put("gen_expn_cd", genExpnCd);
        	        	
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GEMPlanningPerformanceDBDAOSearchMonSmryCheckRSQL(), param, velParam);            
            
            if (dbRowset.next()) {
            	String uiFlag = dbRowset.getString(1);            	
            	return uiFlag;
            	 
            } else {
            	return null;
            }
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
        }
        
        
    }
    
	/**
	 * 현지 법인 월별 실적 수정<br>
	 * 
	 * @author P.C.J
	 * @category CPS_GEM-0004
	 * @category modifySubsidiaryActualResults
	 * 
	 * @param List<SubsPerfVO> subsidiaryModifyVoList
	 *            데이터객체 배열
	 * @throws DAOException
	 */
    public void modifySubsidiaryActualResults(List<SubsPerfVO> subsidiaryModifyVoList) throws DAOException {
    	  
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (subsidiaryModifyVoList.size() > 0) {
				Map<String, Object> velParam = new HashMap<String, Object>();
				insCnt = sqlExe.executeBatch((ISQLTemplate) new GEMPlanningPerformanceDBDAOModifySubsidiaryActualResultsUSQL(), subsidiaryModifyVoList, velParam);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to modify No" + i + " SQL");
				}
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		}
    }
    
    
	/**
	 * 현지 법인 월별 실적 수정<br>
	 * 
	 * @author P.C.J
	 * @category CPS_GEM-0004
	 * @category modifySubsActRsltSmry
	 * 
	 * @param List<SubsPerfVO> monSmryModifyVoList
	 *            데이터객체 배열
	 * @throws DAOException
	 */
    public void modifySubsActRsltSmry(List<SubsPerfVO> monSmryModifyVoList) throws DAOException {
    	  
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (monSmryModifyVoList.size() > 0) {
				Map<String, Object> velParam = new HashMap<String, Object>();
				insCnt = sqlExe.executeBatch((ISQLTemplate) new GEMPlanningPerformanceDBDAOModifySubsActRsltSmryUSQL(), monSmryModifyVoList, velParam);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to modify No" + i + " SQL");
				}
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		}
    }
    
	/**
	 * 현지 법인 월별 실적 생성<br>
	 * 
	 * @author P.C.J
	 * @category CPS_GEM-0004
	 * @category addSubsidiaryActualResults
	 * 
	 * @param List<SubsPerfVO> subsidiaryInsertVoList
	 *            데이터객체 배열
	 * @throws DAOException
	 */
    public void addSubsidiaryActualResults(List<SubsPerfVO> subsidiaryInsertVoList) throws DAOException {
    	  
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (subsidiaryInsertVoList.size() > 0) {
				Map<String, Object> velParam = new HashMap<String, Object>();
				insCnt = sqlExe.executeBatch((ISQLTemplate) new GEMPlanningPerformanceDBDAOAddSubsidiaryActualResultsCSQL(), subsidiaryInsertVoList, velParam);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		}
    } 
    
    /**
	 * 현지 법인 월별 실적 생성<br>
	 * 
	 * @author P.C.J
	 * @category CPS_GEM-0004
	 * @category addSubsActRsltSmry
	 * 
	 * @param List<SubsPerfVO> monSmryInsertVoList
	 *            데이터객체 배열
	 * @throws DAOException
	 */
    public void addSubsActRsltSmry(List<SubsPerfVO> monSmryInsertVoList) throws DAOException {
    	  
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (monSmryInsertVoList.size() > 0) {
				Map<String, Object> velParam = new HashMap<String, Object>();
				insCnt = sqlExe.executeBatch((ISQLTemplate) new GEMPlanningPerformanceDBDAOAddSubsActRsltSmryCSQL(), monSmryInsertVoList, velParam);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		}
    }
    
	// ---------------------------------------------------------------------------
	// [CPS_GEM_0004] Actual Results for Subsidiaries
	// ---------------------------------------------------------------------------    
 
    /**
	 * ERP 에서 I/F 받은 전표 정보 조회
     * 
     * @author P.C.J
     * @category CPS_GEM-0016
     * @category searchSlipInq      
     * @param RqstInfoVO rqstInfoVO     
     * @return List<SlipPerformanceVO>
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<SlipPerformanceVO> searchSlipInq(RqstInfoVO rqstInfoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SlipPerformanceVO> list = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		//velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if(rqstInfoVO != null){
				 			 
				String pageNo = rqstInfoVO.getPageNo();
				
				int currentPage = 0;
				
				if (pageNo != null && !pageNo.equals("")) {
					currentPage = Integer.parseInt(pageNo);
				}
								
				if (currentPage > 0) {
					int startNo     = Constants.PAGE_SIZE_100 * (currentPage - 1) + 1;
					int endNo       = Constants.PAGE_SIZE_100 * currentPage;					
					param.put("start_page", startNo);
					param.put("end_page", endNo);			
				}
				
				Map<String, String> mapVO = rqstInfoVO.getColumnValues();
				param.putAll(mapVO);
				 
				param.put("from_rslt_yrmon", rqstInfoVO.getFromRsltYrmon().replaceAll("-",""));				 
				param.put("to_rslt_yrmon", rqstInfoVO.getToRsltYrmon().replaceAll("-",""));

				velParam.putAll(param);
			 }			 
	 
        	dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GEMPlanningPerformanceDBDAOSearchSlipInqRSQL(), param, velParam);
			
        	list = (List) RowSetUtil.rowSetToVOs(dbRowset, SlipPerformanceVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		}
		return list;
	}
    
 
    
    // ---------------------------------------------------------------------------
	// [CPS_GEM_0016] Slip Inquiry by Performance
	// --------------------------------------------------------------------------- 
    
    /**
	 * 확정된 비용계획과 비용실적 정보 조회
     * 
     * @author P.C.J
     * @category CPS_GEM-0015
     * @category searchPlanningPerformance      
     * @param RqstInfoVO rqstInfoVO    
     * @return List<PlanningPerformanceVO>
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<PlanningPerformanceVO> searchPlanningPerformance(RqstInfoVO rqstInfoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PlanningPerformanceVO> list = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		//velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if(rqstInfoVO != null){
				 			 
				 Map<String, String> mapVO = rqstInfoVO.getColumnValues();
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);				 
				 
				 param.put("from_rslt_yrmon", rqstInfoVO.getFromRsltYrmon().replaceAll("-",""));
				 velParam.put("from_rslt_yrmon", rqstInfoVO.getFromRsltYrmon().replaceAll("-",""));
				 
				 param.put("to_rslt_yrmon", rqstInfoVO.getToRsltYrmon().replaceAll("-",""));
				 velParam.put("to_rslt_yrmon", rqstInfoVO.getToRsltYrmon().replaceAll("-",""));
				 
				 //closing date가 입력 to date 값보다 크거나 같으면 closing date 값을 입력 to date 값으로 대치한다
				 if(Integer.parseInt(rqstInfoVO.getToRsltYrmon().replaceAll("-","")) <= Integer.parseInt(rqstInfoVO.getClosingDate())){
					 param.put("closing_date", rqstInfoVO.getToRsltYrmon().replaceAll("-",""));
					 velParam.put("closing_date", rqstInfoVO.getToRsltYrmon().replaceAll("-",""));
				 }
				 
				 //closing date가 입력 from date 값보다  크거나 같으면 from closing date 값을 입력 from date 값으로 대치한다
				 if(Integer.parseInt(rqstInfoVO.getFromRsltYrmon().replaceAll("-","")) <= Integer.parseInt(rqstInfoVO.getClosingDate())){
					 param.put("from_closing_date", rqstInfoVO.getFromRsltYrmon().replaceAll("-",""));
					 velParam.put("from_closing_date", rqstInfoVO.getFromRsltYrmon().replaceAll("-",""));
				 }else{
					 param.put("from_closing_date", rqstInfoVO.getClosingDate());
					 velParam.put("from_closing_date", rqstInfoVO.getClosingDate());
				 }
				 				 
			 }			 
	 
        	dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GEMPlanningPerformanceDBDAOSearchPlanningPerformanceRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, PlanningPerformanceVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		}
		return list;
	}
    
	/**
	 * 조회대상 Month의 년간 누계 집행율에 대한 과다/과소 사유<br>
	 * 
	 * @author P.C.J
	 * @category CPS_GEM-0015
	 * @category modifyExceedReason
	 * 
	 * @param List<RatioReasonVO> ratioreasonModifyVoList
	 *            데이터객체 배열
	 * @throws DAOException
	 */
    public void modifyExceedReason(List<RatioReasonVO> ratioreasonModifyVoList) throws DAOException {
    	  
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (ratioreasonModifyVoList.size() > 0) {
				Map<String, Object> velParam = new HashMap<String, Object>();
				insCnt = sqlExe.executeBatch((ISQLTemplate) new GEMPlanningPerformanceDBDAOModifyExceedReasonUSQL(), ratioreasonModifyVoList, velParam);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to modify No" + i + " SQL");
				}
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		}
    }
    
    // ---------------------------------------------------------------------------
	// [CPS_GEM_0015] Expense Vs Performance
	// ---------------------------------------------------------------------------
    
    /**
	 * 수립된 비용계획에 대한 요청 정보를 승인단계별로 비교 조회한다
     * 
     * @author P.C.J
     * @category CPS_GEM-0014_01
     * @category searchComparisonPlanning      
     * @param RqstInfoVO rqstInfoVO     
     * @return List<ComparisonPlanningVO>
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<ComparisonPlanningVO> searchComparisonPlanning(RqstInfoVO rqstInfoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ComparisonPlanningVO> list = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		//velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if(rqstInfoVO != null){
				 			 
				 Map<String, String> mapVO = rqstInfoVO.getColumnValues();
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
				 
				 param.put("rslt_yrmon", rqstInfoVO.getRsltYrmon().replaceAll("-",""));
				 velParam.put("rslt_yrmon", rqstInfoVO.getRsltYrmon().replaceAll("-",""));
				 				 
			 }			 
	 
        	dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GEMPlanningPerformanceDBDAOSearchComparisonPlanningRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ComparisonPlanningVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		}
		return list;
	}
    
    // ---------------------------------------------------------------------------
	// [CPS_GEM_0014_01] Requested expense Vs Approved expense
	// --------------------------------------------------------------------------- 
    
    /**
     * 요청된 비용계획에 대하여 승인 정보를 조회한다<br>
     * 
     * @author P.C.J
     * @category CPS_GEM-0106
     * @category searchApprovalOpinionInfo
     * @param String genExpnRqstNo 비용계획 요청 번호
     * @param String genExpnCd 비용코드
     * @param String genExpnItemNo 비용코드의 아이템번호
     * @return List<GemApprovalStepVO>
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<GemApprovalStepVO> searchApprovalOpinionInfo(String genExpnRqstNo,
			String genExpnCd,String genExpnItemNo) throws DAOException {
        DBRowSet dbRowset = null;
        
        List<GemApprovalStepVO> list = null;
        
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
        	
        	param.put("gen_expn_rqst_no", genExpnRqstNo);
        	param.put("gen_expn_cd",genExpnCd );
        	param.put("gen_expn_item_no",genExpnItemNo );     
        	
        	velParam.put("gen_expn_rqst_no", genExpnRqstNo );
        	velParam.put("gen_expn_cd",genExpnCd );
        	velParam.put("gen_expn_item_no",genExpnItemNo );     
        	
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GEMPlanningPerformanceDBDAOSearchApprovalOpinionInfoRSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, GemApprovalStepVO.class);            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
        }
        
        return list;
    }
    
    // ---------------------------------------------------------------------------
	// [CPS_GEM_0106] Approval Opinion
	// --------------------------------------------------------------------------- 
    
    /**
     * 유형별(계획비용,추가배정,예산이관) Request 요청된 정보를 상세조회한다<br>
     * 
     * @author P.C.J
     * @category CPS_GEM-0014_02
     * @category searchRqstInfo
     * @param RqstInfoVO rqstInfoVO
     * @return List<RqstPlanInfoVO>
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<RqstPlanInfoVO> searchRqstInfo(RqstInfoVO rqstInfoVO) throws DAOException {
        DBRowSet dbRowset = null;
        
        List<RqstPlanInfoVO> list = null;
        
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
        	
        	if(rqstInfoVO != null){
	 			 
				 Map<String, String> mapVO = rqstInfoVO.getColumnValues();
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
				 				 
			 }
        	
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GEMPlanningPerformanceDBDAOSearchRqstInfoRSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, RqstPlanInfoVO.class);            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
        }
        
        return list;
    }
    
    // ---------------------------------------------------------------------------
	// [CPS_GEM_0014_02] Request Information
	// ---------------------------------------------------------------------------
    
    /**
     * 비용계획을 요청중인 조직의 현재까지의 실적 정보를 조회한다<br>
     * 
     * @author P.C.J
     * @category CPS_GEM-0108
     * @category searchPerformanceInquiry
     * @param PerfInqVO perfInqVO
     * @return List<PerformanceInfoVO>
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<PerformanceInfoVO> searchPerformanceInquiry(PerfInqVO perfInqVO) throws DAOException {
        DBRowSet dbRowset = null;
        
        List<PerformanceInfoVO> list = null;
        
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
        	
        	if(perfInqVO != null){
	 			 
				 Map<String, String> mapVO = perfInqVO.getColumnValues();
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);				 
				 				 
			}     
        	
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GEMPlanningPerformanceDBDAOSearchPerformanceInquiryRSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, PerformanceInfoVO.class);            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
        }
        
        return list;
    }
    
    // ---------------------------------------------------------------------------
	// [CPS_GEM_0108] Performance Inquiry_Additional
	// ---------------------------------------------------------------------------
    
    /**
	 * 조직별 예산과 실적을 조회한다
     * 
     * @author P.C.J
     * @category CPS_GEM-0018_01
     * @category searchReportAfterClosingAll     
     * @param RqstInfoVO  rqstInfoVO   
     * @return List<ReportAfterClosingVO>
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<ReportAfterClosingVO> searchReportAfterClosingAll(RqstInfoVO rqstInfoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ReportAfterClosingVO> list = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		//velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if(rqstInfoVO != null){
				 			 
				 Map<String, String> mapVO = rqstInfoVO.getColumnValues();
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
				 
				 
				 //sch_expense_group
				 String schExpenseGroup  = rqstInfoVO.getSchExpenseGroup();				 
				 if (!StringUtils.isEmpty(schExpenseGroup)) {					 
					 schExpenseGroup = GemUtil.getInSqlChar(schExpenseGroup.split(","));
					 param.put("sch_expense_group", schExpenseGroup);
					 velParam.put("sch_expense_group", schExpenseGroup);
					 
				 }
				 
				 param.put("from_rslt_yrmon", rqstInfoVO.getFromRsltYrmon().replaceAll("-",""));
				 velParam.put("from_rslt_yrmon", rqstInfoVO.getFromRsltYrmon().replaceAll("-",""));
				 
				 
				 param.put("from_rslt_yrmon", rqstInfoVO.getFromRsltYrmon().replaceAll("-",""));
				 velParam.put("from_rslt_yrmon", rqstInfoVO.getFromRsltYrmon().replaceAll("-",""));
				 
				 param.put("to_rslt_yrmon", rqstInfoVO.getToRsltYrmon().replaceAll("-",""));
				 velParam.put("to_rslt_yrmon", rqstInfoVO.getToRsltYrmon().replaceAll("-",""));
				 				 
			 }			 
	 
        	dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GEMPlanningPerformanceDBDAOSearchReportAfterClosingAllRSQL(), param, velParam, true);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ReportAfterClosingVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		}
		return list;
	}
    
    /**
	 * 조회 기간에 대한 비목별 집행실적 분석 Report
     * 
     * @author P.C.J
     * @category CPS_GEM-0018_02
     * @category searchReportAfterClosingExpense     
     * @param RqstInfoVO rqstInfoVO
     * @return List<ReportAfterClosingVO>
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<ReportAfterClosingVO> searchReportAfterClosingExpense(RqstInfoVO rqstInfoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ReportAfterClosingVO> list = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		//velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if(rqstInfoVO != null){
				 			 
				 Map<String, String> mapVO = rqstInfoVO.getColumnValues();
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
				 
				 param.put("from_rslt_yrmon", rqstInfoVO.getFromRsltYrmon().replaceAll("-",""));
				 velParam.put("from_rslt_yrmon", rqstInfoVO.getFromRsltYrmon().replaceAll("-",""));
				 
				 param.put("to_rslt_yrmon", rqstInfoVO.getToRsltYrmon().replaceAll("-",""));
				 velParam.put("to_rslt_yrmon", rqstInfoVO.getToRsltYrmon().replaceAll("-",""));
				 				 
			 }			 
	 
        	dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GEMPlanningPerformanceDBDAOSearchReportAfterClosingExpenseRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ReportAfterClosingVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		}
		return list;
	}
    
    /**
	 * 조회 기간에 대하여 Closing 반영된 집행단위별 집행실적 분석 Report
     * 
     * @author P.C.J
     * @category CPS_GEM-0018_03
     * @category searchReportAfterClosingOffice     
     * @param RqstInfoVO rqstInfoVO     
     * @return List<ReportAfterClosingVO>
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<ReportAfterClosingVO> searchReportAfterClosingOffice(RqstInfoVO rqstInfoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ReportAfterClosingVO> list = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		//velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if(rqstInfoVO != null){
				 			 
				 Map<String, String> mapVO = rqstInfoVO.getColumnValues();
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
				 
				 param.put("from_rslt_yrmon", rqstInfoVO.getFromRsltYrmon().replaceAll("-",""));
				 velParam.put("from_rslt_yrmon", rqstInfoVO.getFromRsltYrmon().replaceAll("-",""));
				 
				 param.put("to_rslt_yrmon", rqstInfoVO.getToRsltYrmon().replaceAll("-",""));
				 velParam.put("to_rslt_yrmon", rqstInfoVO.getToRsltYrmon().replaceAll("-",""));
				 				 
			 }			 
	 
        	dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GEMPlanningPerformanceDBDAOSearchReportAfterClosingOfficeRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ReportAfterClosingVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		}
		return list;
	}
    
    /**
	 * 조회 기간에 대하여 Closing 반영된 투자법인 집행단위별 집행실적 분석 Report
     * 
     * @author P.C.J
     * @category CPS_GEM-0018_04
     * @category searchReportAfterClosingSubsidiary      
     * @param RqstInfoVO rqstInfoVO     
     * @return List<ReportAfterClosingVO>
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<ReportAfterClosingVO> searchReportAfterClosingSubsidiary(RqstInfoVO rqstInfoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ReportAfterClosingVO> list = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		//velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if(rqstInfoVO != null){
				 			 
				 Map<String, String> mapVO = rqstInfoVO.getColumnValues();
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
				 
				 param.put("from_rslt_yrmon", rqstInfoVO.getFromRsltYrmon().replaceAll("-",""));
				 velParam.put("from_rslt_yrmon", rqstInfoVO.getFromRsltYrmon().replaceAll("-",""));
				 
				 param.put("to_rslt_yrmon", rqstInfoVO.getToRsltYrmon().replaceAll("-",""));
				 velParam.put("to_rslt_yrmon", rqstInfoVO.getToRsltYrmon().replaceAll("-",""));
				 				 
			 }			 
	 
        	dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GEMPlanningPerformanceDBDAOSearchReportAfterClosingSubsidiaryRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ReportAfterClosingVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		}
		return list;
	}
    
    /**
	 * 조회 대상/기간에 대하여 월별 배정 비용 리포트-해외배정비용현황 송부 참조용 Report
     * 
     * @author P.C.J
     * @category CPS_GEM-0018_05
     * @category searchReportAfterClosingMonthly      
     * @param RqstInfoVO rqstInfoVO     
     * @return List<ReportAfterClosingVO>
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<ReportAfterClosingVO> searchReportAfterClosingMonthly(RqstInfoVO rqstInfoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ReportAfterClosingVO> list = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		//velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if(rqstInfoVO != null){
				 			 
				 Map<String, String> mapVO = rqstInfoVO.getColumnValues();
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
				 
				 param.put("from_rslt_yrmon", rqstInfoVO.getFromRsltYrmon().replaceAll("-",""));
				 velParam.put("from_rslt_yrmon", rqstInfoVO.getFromRsltYrmon().replaceAll("-",""));
				 
				 param.put("to_rslt_yrmon", rqstInfoVO.getToRsltYrmon().replaceAll("-",""));
				 velParam.put("to_rslt_yrmon", rqstInfoVO.getToRsltYrmon().replaceAll("-",""));
				 				 
			 }			 
	 
        	dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GEMPlanningPerformanceDBDAOSearchReportAfterClosingMonthlyRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ReportAfterClosingVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		}
		return list;
	}
    
    /**
	 * 조회 대상/기간에 대하여 월별 배정 비용 리포트-해외배정비용현황 송부 참조용 Report 커맨트
     * 
     * @author P.C.J
     * @category CPS_GEM-0018_05
     * @category searchReportAfterClosingMonthlyComment      
     * @param RqstInfoVO rqstInfoVO     
     * @return List<ReportAfterClosingVO>
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<ReportAfterClosingVO> searchReportAfterClosingMonthlyComment(RqstInfoVO rqstInfoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ReportAfterClosingVO> list = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		//velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if(rqstInfoVO != null){
				 			 
				 Map<String, String> mapVO = rqstInfoVO.getColumnValues();
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
				 
				 param.put("from_rslt_yrmon", rqstInfoVO.getFromRsltYrmon().replaceAll("-",""));
				 velParam.put("from_rslt_yrmon", rqstInfoVO.getFromRsltYrmon().replaceAll("-",""));
				 
				 param.put("to_rslt_yrmon", rqstInfoVO.getToRsltYrmon().replaceAll("-",""));
				 velParam.put("to_rslt_yrmon", rqstInfoVO.getToRsltYrmon().replaceAll("-",""));
				 				 
			 }			 
	 
        	dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GEMPlanningPerformanceDBDAOSearchReportAfterClosingMonthlyCommentRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ReportAfterClosingVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		}
		return list;
	}
    
    /**
	 * 조회 대상/기간에 대하여 월별 배정 비용 리포트-해외배정비용현황 송부 참조용 Report
     * 
     * @author P.C.J
     * @category CPS_GEM-0018_05
     * @category searchReportAfterClosingSinwaExpense     
     * @param RqstInfoVO rqstInfoVO   
     * @return List<ReportAfterClosingVO>
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<ReportAfterClosingVO> searchReportAfterClosingSinwaExpense(RqstInfoVO rqstInfoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ReportAfterClosingVO> list = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		//velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if(rqstInfoVO != null){
				 			 
				 Map<String, String> mapVO = rqstInfoVO.getColumnValues();
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
				 
				 param.put("from_rslt_yrmon", rqstInfoVO.getFromRsltYrmon().replaceAll("-",""));
				 velParam.put("from_rslt_yrmon", rqstInfoVO.getFromRsltYrmon().replaceAll("-",""));
				 
				 param.put("to_rslt_yrmon", rqstInfoVO.getToRsltYrmon().replaceAll("-",""));
				 velParam.put("to_rslt_yrmon", rqstInfoVO.getToRsltYrmon().replaceAll("-",""));
				 				 
			 }			 
	 
        	dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GEMPlanningPerformanceDBDAOSearchReportAfterClosingSinwaExpenseRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ReportAfterClosingVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		}
		return list;
	}
    
    // ---------------------------------------------------------------------------
	// [CPS_GEM_0018] Summary_After Closing
	// ---------------------------------------------------------------------------
    
}
