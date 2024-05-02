/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GEMPlanningPerformanceBC.java
*@FileTitle : Expense PerformanceBC Maintenance
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
package com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.basic;

import java.util.List;

import org.apache.xmlbeans.XmlObject;

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
import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.vo.PlanningVO;
import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.vo.RatioReasonVO;
import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.vo.Report0023R1VO;
import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.vo.Report0025R1VO;
import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.vo.ReportAfterClosingVO;
import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.vo.RqsNoVO;
import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.vo.RqstInfoVO;
import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.vo.RqstPlanInfoVO;
import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.vo.SearchOfficeCurrencyVO;
import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.vo.SearchProcessingStatusVO;
import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.vo.SearchRqstNoReferenceVO;
import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.vo.SearchYearlyExpenseVO;
import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.vo.SlipPerformanceVO;
import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.vo.SubsPerfVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;

/**
 * NIS2010-GEMPlanningPerformance Business Logic Command Interface<br>
 * - NIS2010-GEMPlanningPerformance에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author choijungmi
 * @see GEMPlanningPerformanceBCImpl 참조
 * @since J2EE 1.4
 */

public interface GEMPlanningPerformanceBC {
    
	
    // ===========================================================================
    // J.Y.O
    // ===========================================================================
    /**
     *  해당 사용자 Role정보 취득
     * process status
     * @author J.Y.O
     * @category CPS_GEM-0002
     * @category searchUsrRole
     * @param usrId 유저아이디   
     * @return 
     * @throws EventException
     */    
    public String[] searchUserRole(String usrId) throws EventException ;
    
    
    /**
     *  로그인 사용자의 GEM office 코드 취득 
     * @author J.Y.O
     * @category CPS_GEM-0002
     * @category searchUsrRole
     * @param usrOfcCd 로그인세션 ofc_cd   
     * @return Gem OfcCd
     * @throws EventException
     */    
    public String searchUserOfficeCd(String usrOfcCd) throws EventException;
    
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
     * @return 승인받은 비용코드 리스트
     * @throws EventException
     */
    public List<AuthExpnInfoVO> searchAuthorizedExpenseInfo(String ofcCd,
			String genExpnCd,String genExpnGroupCd, String ticCd) throws EventException;

    
    /**
     * 1st 비용그룹을 취득한다.<br>
     * 
     * @author J.Y.O
     * @category CPS_GEM_0101
     * @category searchExpenseGroupByLvl
     * @param genExpnGrpLvl 레벨      
     * @return
     * @throws EventException
     */    
    public List<GemExpenseVO> searchExpenseGroupByLvl(String genExpnGrpLvl) throws EventException ;
        
    
	// ---------------------------------------------------------------------------
	// [CPS_GEM_0104] Assigned Expense
	// ---------------------------------------------------------------------------
    
    /**
     * 추가배정, 비용이관을 수행하기 위해 최초확정된 비용계획 정보를 조회 한다<br>
     * 
     * @author J.Y.O
     * @category CPS_GEM-0104
     * @category searchAssignedExpenseInfo
     * @param plnYrmon 계획년월
     * @param ofcCd 오피스코드
     * @param genExpnCd 비용코드 
     * @return
     * @throws EventException
     */
    public List<AssignedExpnVO> searchAssignedExpenseInfo(String plnYrmon,
			String ofcCd,String genExpnCd) throws EventException ;    
    
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
     * @throws EventException
     */
    public List<RqsNoVO> searchRqstNoReference(SearchRqstNoReferenceVO paramVo)throws EventException ;
    
    
	// ---------------------------------------------------------------------------
	// [CPS_GEM_0001_01] Expense Request – Initial & Additional
	// ---------------------------------------------------------------------------
	
    /**
	 * Request 테이블의 update date 취득
	 * YYYYMMDDHH24MISS 리턴  
     * @author J.Y.O
     * @category CPS_GEM-0001-01
     * @category searchReqUpdDate    
     * @param genExpnRqstNo Request no
     * @return YYYYMMDDHH24MISS 리턴
     * @throws EventException
     */
     public String searchReqUpdDt(String genExpnRqstNo) throws EventException;    
    
    /**
	 * Item 테이블의 update date 취득
	 * YYYYMMDDHH24MISS 리턴  
     * @author J.Y.O
     * @category CPS_GEM-0001-01
     * @category searchItmUpdDt    
     * @param genExpnRqstNo Request no
     * @param genExpnRqstSeq Request seq
     * @return YYYYMMDDHH24MISS 리턴
     * @throws EventException
     */
     public String searchItmUpdDt(String genExpnRqstNo , String genExpnRqstSeq)  throws EventException;         
    
    /**
	 * 로그인 조직(Office)이 GEM 시스템 사용시 권한 조회 ( 집행단위 , BU CTRL , 지역그룹 , 비용주관팀 , 사무국 으로 분류 ) 및 Request 요건 정보
     * 
     * @author J.Y.O
     * @category CPS_GEM_0001_01
     * @category searchOfficeRqstInfo
     * @param String ofcCd
     * @param String acctXchRtYrmon
     * @return OfficeLevelVO
     * @throws EventException
     */
     public OfficeLevelVO searchOfficeRqstInfo(String ofcCd,
			String acctXchRtYrmon) throws EventException;     
    
     
     /**
 	 * 로그인 조직(Office)의 Hierarchy 구조 조회
 	 * 
 	 * @author J.Y.O
 	 * @category CPS_GEM_0001_01
 	 * @category searchOfficeHierarchy
 	 * @param ofcCd
 	 *            로그인 오피스코드 (요청 오피스코드)
 	 * @return
 	 * @throws EventException
 	 */
       
     public OfficeHierarchyVO searchOfficeHierarchy(String ofcCd) throws EventException;
     
     /**
  	 * 로그인 조직(Office)의 Hierarchy 구조 조회 및 환율정보 취득
       * 
       * @author J.Y.O
       * @category CPS_GEM_0001_03 ,CPS_GEM-0003
       * @category searchOfficeCurrency
       * @param ofcCd 로그인 오피스코드 (요청 오피스코드)       
       * @param acctXchRtYrmon 예산년도
  	 * @return
  	 * @throws EventException
  	 */
      public SearchOfficeCurrencyVO searchOfficeCurrency(String ofcCd ,String acctXchRtYrmon) throws EventException;     
     
     /**
 	 * 계획비용 요청시 입력 마감일정 정보 조회
 	 * 
 	 * @author J.Y.O
 	 * @category CPS_GEM_0001_01
 	 * @category searchClosingDate
     * @param clzYrmon 예산년도(yyyy)
     * @param usrOfcCd 로그인 ofc_cd
 	 * @return
 	 * @throws EventException
 	 */
 	public ClosingDateVO searchClosingDate(String clzYrmon , String usrOfcCd)
 			throws EventException ;     
 	
    /**
	 * 계획비용 요청시 입력 차년도 계획 마감일정 정보 조회
     * 
     * @author J.Y.O
     * @category CPS_GEM_0001_01
     * @category searchInitialDate
     * @param String clzYrmon
     * @param String usrOfcCd
	 * @return
	 * @throws EventException
	 */
	public ClosingDateVO searchInitialDate(String clzYrmon, String usrOfcCd) 
			throws EventException; 	
	
	
    /**
     * 조직별 비용계획 수립 가능한 비용코드를 체크하고, 비용 코드의 한글약어명,영문약어명,비용주관팀 정보
     * @author J.Y.O
     * @category CPS_GEM_0001_01
     * @category searchRqstExpense
     * @param ofcCd 오피스 코드     
     * @param genExpnCd 비용코드
     * @param ticCd 비용주관팀
     * @param genExpnGroupCd 비용그룹 
	 * @return GemExpenseVO
	 * @throws EventException
     */
    public GemExpenseVO searchRqstExpense(String ofcCd , String genExpnCd  , String ticCd , String genExpnGroupCd) 
			throws EventException;	
	
    /**
     * 비용계획 요청시 비용코드의 MAX(Item) + 1
     * @author J.Y.O
     * @category CPS_GEM_0001_01
     * @category searchMaxItem
     * @param plnYrmon 예산년도
     * @param ofcCd 오피스 코드     
     * @param genExpnCd 비용코드 
     * @return 비용코드의 MAX(Item) + 1
     * @throws EventException
     */
    public String searchMaxItem(String plnYrmon ,String ofcCd , String genExpnCd)
			throws EventException ;	
	
    
    /**
     * 유형별(계획비용, 추가배정, 예산이관) 요청한 계획비용 정보를 수정한다 
     * @author J.Y.O
     * @category CPS_GEM_0001_01
     * @category manageExpensePlanning
     * @param planningVO 계획비용 정보
     * @throws EventException
     */
    public void manageExpensePlanning(PlanningVO planningVO)
			throws EventException ;    
    
    /**
     * 집행단위, 지역그룹|BU CTRL , 비용주관팀 , 사무국 에서 등록한 비용계획을 조회
     * GEM_ITEM
     * @author J.Y.O
     * @category CPS_GEM_0001_01
     * @category searchExpensePlanning
     * @param genExpnRqstNo RequestNO   
     * @param rqstOfcCd 요청부서 로그인부서  
     * @param creUsrId 로그인유저 아이디    
     * @return 
     * @throws EventException
     */    
    public List<ItemVO> searchExpensePlanning(String genExpnRqstNo,String rqstOfcCd , String creUsrId)
			throws EventException;   
    
    
    /**
	 * 계획비용 요청 정보 조회
     * table GEM_REQUEST
     * @author J.Y.O
     * @category CPS_GEM_0001_01
     * @category searchExpenseRequest
     * @param genExpnRqstNo 비용요청번호      
     * @return
     * @throws EventException
     */
    public GemRequestVO searchExpenseRequest(String genExpnRqstNo)
			throws EventException;    
    
    
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
     * @throws EventException
     */    
    public List<GemItemVO> searchTransferItem(String genExpnRqstNo,String rqstOfcCd,String creUsrId) throws EventException;    

    
    /**
	 * 계획비용 ITEM 정보 조회
     * table GEM_REQUEST
     * @author J.Y.O
     * @category CPS_GEM_0001_01
     * @category searchExpenseItem
     * @param gemItemVO 비용요청번호    검색 조건
     * @return
     * @throws EventException
     */
    public List<GemItemVO> searchExpenseItem(GemItemVO gemItemVO)
			throws EventException;
    
    
    /**
	 * 계획비용 Apro Step 정보 조회
     * table GEM_REQUEST
     * @author J.Y.O
     * @category CPS_GEM_0001_01
     * @category searchExpenseAproStep
     * @param gemApprovalStepVO 검색 조건      
     * @return
     * @throws EventException
     */
    public List<GemApprovalStepVO> searchExpenseAproStep(GemApprovalStepVO gemApprovalStepVO)
			throws EventException;
    
    
    /**
	 * 계획비용 요청 정보 조회
     * table GEM_REQUEST
     * @author J.Y.O
     * @category CPS_GEM_0001_01
     * @category searchExpenseRequest
     * @param genExpnRqstNo 비용요청번호      
     * @throws EventException
     */
    public void removeExpensePlanning(String genExpnRqstNo)
			throws EventException ;    
    
    
    /**
     * TO 오피스 레벨3(L3) 조직 정보 취득 
     * Transfer
     * @author J.Y.O
     * @category CPS_GEM_0001_02
     * @category SearchToOfficeL3List
     * @param toSlsOfcDivCd HQ,HO구분    
     * @param toOfcLvl2 to office 레벨2
     * @param fmOfcLvl3 from office 레벨3
     * @return 
     * @throws DAOException
     */    
    public String[] searchToOfficeL3List(String toSlsOfcDivCd , String toOfcLvl2 , String fmOfcLvl3) 
			throws EventException;
    
    
    /**
     * TO 오피스 레벨2(L2) 조직 정보 취득 
     * Transfer
     * @author J.Y.O
     * @category CPS_GEM_0001_02
     * @category SearchToOfficeL2List
     * @param toSlsOfcDivCd HQ,HO구분    
     * @param toOfcLvl1 to office 레벨1
     * @param fmOfcLvl2 from office 레벨2
     * @param fmOfcLvl3 from office 레벨3
     * @return 
     * @throws DAOException
     */    
    public String[] searchToOfficeL2List(String toSlsOfcDivCd , String toOfcLvl1 ,String fmOfcLvl2 , String fmOfcLvl3) 
			throws EventException;
			
    
	// ---------------------------------------------------------------------------
	// [CPS_GEM-0001_03] Expense Request – Adjustment
	// ---------------------------------------------------------------------------
    /**
     * 집행단위, 지역그룹|BU CTRL , 비용주관팀 , 사무국 에서 등록한 비용계획을 조회
     * GEM_ITEM
     * @author J.Y.O
     * @category CPS_GEM_0001_03
     * @category searchExpensePlanningStatus
     * @param planningStatusCondVO 검색조건VO   
     * @return 
     * @throws EventException
     */    
    public List<PlanningStatusVO> searchExpensePlanningStatus(PlanningStatusCondVO planningStatusCondVO)
			throws EventException;
    
    /**
     * 유형별(계획비용, 추가배정, 예산이관) 요청한 계획비용 정보를 수정한다 
     * @author J.Y.O
     * @category CPS_GEM_0001_03
     * @category manageExpensePlanning03
     * @param planningVO 계획비용 정보
     * @throws EventException
     */
    public void manageExpensePlanning03(PlanningVO planningVO)
			throws EventException;    
    
	// ---------------------------------------------------------------------------
	// [CPS_GEM-0002] Processing Status 
	// ---------------------------------------------------------------------------
    /**
     * Processing Status
     * @author J.Y.O
     * @category CPS_GEM-0002
     * @category searchProcessingStatus
     * @param planningStatusCondVO 검색조건
     * @return 
     * @throws EventException
     */    
    public List<SearchProcessingStatusVO> searchProcessingStatus(PlanningStatusCondVO planningStatusCondVO) throws EventException;    
    
    
	// ---------------------------------------------------------------------------
	// [CPS_GEM_0003] Approval of Requested expense
	// --------------------------------------------------------------------------- 

    /**
     * 리스트에서 다건 승인처리 
     * @author J.Y.O
     * @category CPS_GEM-0003
     * @category manageExpensePlanning04
     * @param PlanningVO[] planningVOs 계획비용 정보
     * @throws EventException
     */
    public void manageExpensePlanning04(PlanningVO[] planningVOs)
			throws EventException;   
 
    
	// ---------------------------------------------------------------------------
	// [CPS_GEM_0023] Request / Initial _ Print
	// ---------------------------------------------------------------------------
     
    /**
     * Expense Request 중 Initial 인쇄 화면
     * @author J.Y.O
     * @category CPS_GEM_0001_02
     * @category report0023R1
     * @param genExpnRqstNo request no
     * @param genExpnRqstSeq request sequence
     * @param langDiv 언어구분 KOR , ENG   
     * @param acctXchRtYrmon 예산년도 yyyy
     * @return 
     * @throws EventException
     */    
    public List<Report0023R1VO> report0023R1(String  genExpnRqstNo ,  String genExpnRqstSeq, String langDiv , String acctXchRtYrmon) throws EventException ; 
    
	// ---------------------------------------------------------------------------
	// [CPS_GEM_0025] Adjustment / Initial _ Print
	// ---------------------------------------------------------------------------
    /**
     * Adjustment / Initial _ Print
     * @author J.Y.O
     * @category CPS_GEM_0025
     * @category report0025R1
     * @param genExpnRqstNo request no
     * @param genExpnRqstSeq request sequence  
     * @param langDiv 언어구분 KOR , ENG   
     * @return 
     * @throws EventException
     */    
    public List<Report0025R1VO> report0025R1(String  genExpnRqstNo ,String genExpnRqstSeq , String langDiv) throws EventException;   
    
    // ===========================================================================
    // C.J.M
    // ===========================================================================
    
    // ---------------------------------------------------------------------------
	// [FNS009-0001, FNS003-0001] Receive WebLogic JMS Queue Proxy
	// ---------------------------------------------------------------------------
    	
    /**
     * ERP(G/L)로부터 일반관리비 비용집계 대상 전표(실적)에 대하여 회계마감(G/L마감) 이후 월 1회 I/F 
     * GEM_SLP_IF 테이블에 XML에서 받은 값을 저장
     * 
     * @author choijungmi
	 * @category FNS009-0001, FNS003-0001
	 * @category createSlip
	 * 
	 * @param GemSlpIfVO gemSlpIfVO
     * @return int
     * @exception EventException
     */
    public int createSlip(GemSlpIfVO gemSlpIfVO) throws EventException;
    
    /**
     * ERP연동시 GEM_SLP_IF에 SLP_TJ_NO, SLP_SEQ_NO에 관한 중복체크를 한다.
     * 
     * @author choijungmi
	 * @category FNS009-0001, FNS003-0001 
	 * @category searchSlpIfCheck
	 * 
     * @param slpTjNo
	 * @param slpSeqNo
     * @return boolean
     * @exception EventException
     */
    public boolean searchSlpIfCheck(String slpTjNo, String slpSeqNo) throws EventException;
    
    /**
     * ERP연동시 GEM_SLP_IF에 SLP_TJ_NO, SLP_SEQ_NO에 관한 정보를 조회한다.
     * 
     * @author choijungmi
	 * @category FNS009-0001, FNS003-0001 
	 * @category searchSlpIf
	 * 
     * @param slpTjNo
	 * @param slpSeqNo
	 * @param glEffDt
     * @return boolean
     * @exception EventException
     */
    public List<GemSlpIfVO> searchSlpIf(String slpTjNo, String slpSeqNo, String glEffDt) throws EventException;
        
    /**
     * 월마감시 집계되지 않은 전표에 대하여 반영한다.
     * 
     * @author choijungmi
	 * @category FNS009-0001, FNS003-0001 
	 * @category createSlipClosing
	 * @param GemSlpIfVO gemSlpIfVO
     * @exception EventException
     */
    public void createSlipClosing(GemSlpIfVO gemSlpIfVO) throws EventException;

    // ---------------------------------------------------------------------------
	// [CPS_GEM_0006] Closing Confirmation & Interface Status
	// ---------------------------------------------------------------------------
    
    /**
     * 월마감시 집계되지 않은 전표에 대하여 반영한다.
     * 
     * @author choijungmi
	 * @category CPS_GEM_0006
	 * @category createSlipClosing2
	 * 
     * @return returnStr (0:실패, 1:성공, 2:작업내용없음)
     * @exception EventException
     */
    //public String createSlipClosing2(String inClzYrmon) throws EventException;
    
    // ---------------------------------------------------------------------------
	// [FNS051-0001] Receive WebLogic JMS Queue Proxy
	// ---------------------------------------------------------------------------
        
    /**
     * ERP(A/P) 로부터 기 I/F 된 전표번호를 받아, 조직별 비용예산 및 실적집계 , 예산대비실적 집행률 을 전송한다.
     * 
     * @author choijungmi
	 * @category FNS051-0001
	 * @category searchPerformanceRatio
	 * 
	 * @param slpTjNo
     * @return String
     * @exception EventException
     */
    public List<GemSlpPerfVO> searchPerformanceRatio(String slpTjNo) throws EventException;
    
    // ---------------------------------------------------------------------------
	// [FNS061-0001] Receive WebLogic JMS Queue Proxy
	// ---------------------------------------------------------------------------
    
    /**
     * ERP(A/P)에서 ERP스케줄러에 의하여 당일 승인한 품의서의 품의자 ID , 승인자 ID 정보를 전송한다.  
     * 
     * @author choijungmi
     * @category FNS061-0001
     * @category modifyApproUsrId 
     * @param String slpTjNo
     * @param String prprUsrId
     * @param String aproUsrId
     * @param String updUsrId 
     */
    public void modifyApproUsrId(String slpTjNo, String prprUsrId, String aproUsrId, String updUsrId) throws EventException;
    
    // ---------------------------------------------------------------------------
	// [CPS_GEM_0019] Detail_Yearly Expense
	// ---------------------------------------------------------------------------
    
    /**
	 * CPS_GEM_0019(01)화면의 Detail Yearly Expense의 BackEndJob 처리를 위한 JobKey요청
	 * 
	 * @author choijungmi
	 * @category CPS_GEM_0019_01
	 * @category searchDetailByYearlyExpenseByBackEndJobKey
	 * 
	 * @param searchYearlyExpenseVO
	 * @param acctUsrId
	 * @return String
	 * @throws Exception
	 */
    public String searchDetailByYearlyExpenseByBackEndJobKey(SearchYearlyExpenseVO searchYearlyExpenseVO, String acctUsrId) throws EventException;
    
    /**
	 * CPS_GEM_0019(01)화면의 Detail Yearly Expense의 BackEndJob 처리 결과를 조회
	 * 
	 * @author choijungmi
	 * @category CPS_GEM_0019_01
	 * @category getBackEndJobResutYearlyExpense
	 * 
	 * @param key
	 * @return List<DetailYearlyExpenseVO>
	 * @throws Exception
	 * @throws DAOException
	 */
    public List<DetailYearlyExpenseVO> getBackEndJobResutYearlyExpense(String key) throws EventException;
    
    /**
	 * CPS_GEM_0019(02)화면의 Detail Request Expense of Initial의 BackEndJob 처리를 위한 JobKey요청
	 * 
	 * @author choijungmi
	 * @category CPS_GEM_0019_02
	 * @category searchDetailByRequestExpenseByBackEndJobKey
	 * 
	 * @param searchYearlyExpenseVO
	 * @param acctUsrId
	 * @return String
	 * @throws Exception
	 */
    public String searchDetailByRequestExpenseByBackEndJobKey(SearchYearlyExpenseVO searchYearlyExpenseVO, String acctUsrId) throws EventException;
    
    /**
	 * CPS_GEM_0019(02)화면의 Detail Request Expense of Initial의 BackEndJob 처리 결과를 조회
	 * 
	 * @author choijungmi
	 * @category CPS_GEM_0019_02
	 * @category getBackEndJobResutRequestExpense
	 * 
	 * @param key
	 * @return List<DetailRequestExpenseVO>
	 * @throws Exception
	 * @throws DAOException
	 */
    public List<DetailRequestExpenseVO> getBackEndJobResutRequestExpense(String key) throws EventException;
    
    /**
	 * CPS_GEM_0019(03)화면의 Detail Request Expense of Initial의 Target이 Detail RQST NO인경우의 BackEndJob 처리를 위한 JobKey요청
	 * 
	 * @author choijungmi
	 * @category CPS_GEM_0019_03
	 * @category searchDetailByRequestExpenseRqstNoByBackEndJobKey
	 * 
	 * @param searchYearlyExpenseVO
	 * @param acctUsrId
	 * @return String
	 * @throws Exception
	 */
    public String searchDetailByRequestExpenseRqstNoByBackEndJobKey(SearchYearlyExpenseVO searchYearlyExpenseVO, String acctUsrId) throws EventException;
    
    /**
	 * CPS_GEM_0019(03)화면의 Detail Request Expense of Initial의 Target이 Detail RQST NO인경우의 BackEndJob 처리 결과를 조회
	 * 
	 * @author choijungmi
	 * @category CPS_GEM_0019_03
	 * @category getBackEndJobResutRequestExpenseRqstNo
	 * 
	 * @param key
	 * @return List<DetailRequestExpenseRqstNoVO>
	 * @throws Exception
	 * @throws DAOException
	 */
    public List<DetailRequestExpenseRqstNoVO> getBackEndJobResutRequestExpenseRqstNo(String key) throws EventException;
            
    // ===========================================================================
    // P.C.J
    // ===========================================================================
    /**
     * 현지법인의 실적을 월별로 조회한다
     * @author P.C.J
     * @category CPS_GEM-0004
     * @category searchSubsidiaryActualResults     
     * @param ActRsltSubsPerfVO actRsltSubsPerfVO
     * @return List<SubsPerfVO>
     * @throws EventException
     */
    public List<SubsPerfVO> searchSubsidiaryActualResults(ActRsltSubsPerfVO actRsltSubsPerfVO)
			throws EventException ;	  
    
    /**
     * 월별 현지법인 실적 입력을 위해서, 마감 일정을 조회한다, 최종 마감 년월을 조회하여, 실적을 입력할 년월을 구한다.
     * @author P.C.J
     * @category CPS_GEM_0004
     * @category searchPerfClosingDate
     * @param String ofcCd
     * @return 실적을 입력할 년월
     * @throws EventException
     */
    public String searchPerfClosingDate(String ofcCd)
			throws EventException ;
    
    /**
     * ClosingDate를 구한다.
     * @author P.C.J
     * @category CPS_GEM-0015
     * @category searchPlanningPerfClosingDate
     * @return ClosingDate
     * @throws EventException
     */
    public String searchPlanningPerfClosingDate()
			throws EventException ;
    
    /**
     * 일반관리비 비용계획을 요청할수 있는 집행단위 조직이 사용할수 있는 비용코드(Expense Code)를 조회한다
     * @author P.C.J
     * @category CPS_GEM-0004
     * @category searchOfficeExpenseMatrixLIstByExpense     
     * @param ActRsltSubsPerfVO actRsltSubsPerfVO
     * @return List<SubsPerfVO>
     * @throws EventException
     */
    public List<SubsPerfVO> searchOfficeExpenseMatrixLIstByExpense(ActRsltSubsPerfVO actRsltSubsPerfVO)
			throws EventException ;	
    
    /**
	 * CPS_GEM-0004 멀티 이벤트 처리<br>
	 * 현지법인 실적을 월별 생성한다<br>
	 * 
	 * @author P.C.J
     * @category CPS_GEM-0004
     * @category manageSubsidiaryActualResults
     * 
	 * @param SubsPerfVO[] subsPerfVOs
	 * @exception EventException
	 */
    public void manageSubsidiaryActualResults(SubsPerfVO[] subsPerfVOs) throws EventException;
	
    // ---------------------------------------------------------------------------
	// [CPS_GEM_0004] Actual Results for Subsidiaries
	// ---------------------------------------------------------------------------
    
    /**
     * ERP 에서 I/F 받은 전표 정보 조회
     * @author P.C.J
     * @category CPS_GEM-0016
     * @category searchSlipInq     
     * @param RqstInfoVO rqstInfoVO
     * @return List<SlipPerformanceVO>
     * @throws EventException
     */
    public List<SlipPerformanceVO> searchSlipInq(RqstInfoVO rqstInfoVO)
			throws EventException ;	
    
    // ---------------------------------------------------------------------------
	// [CPS_GEM_0016] Slip Inquiry by Performance
	// ---------------------------------------------------------------------------

    /**
     * 확정된 비용계획과 비용실적 정보 조회
     * @author P.C.J
     * @category CPS_GEM-0015
     * @category searchPlanningPerformance    
     * @param RqstInfoVO rqstInfoVO
     * @return List<PlanningPerformanceVO>
     * @throws EventException
     */
    public List<PlanningPerformanceVO> searchPlanningPerformance(RqstInfoVO rqstInfoVO) 
			throws EventException ;	
    
    /**
	 * CPS_GEM-0015 멀티 이벤트 처리<br>
	 * 조회대상 Month의 년간 누계 집행율에 대한 과다/과소 사유 저장<br>
	 * 
	 * @author P.C.J
     * @category CPS_GEM_0015
     * @category modifyExceedReason
     * 
	 * @param RatioReasonVO[] ratioReasonVOs	
	 * @exception EventException
	 */
    public void modifyExceedReason(RatioReasonVO[] ratioReasonVOs) throws EventException;
    
    // ---------------------------------------------------------------------------
	// [CPS_GEM_0015] Expense Vs Performance
	// ---------------------------------------------------------------------------
    
    /**
     * 수립된 비용계획에 대한 요청 정보를 승인단계별로 비교 조회한다
     * @author P.C.J
     * @category CPS_GEM-0014_01
     * @category searchComparisonPlanning     
     * @param RqstInfoVO rqstInfoVO
     * @return List<ComparisonPlanningVO>
     * @throws EventException
     */
    public List<ComparisonPlanningVO> searchComparisonPlanning(RqstInfoVO rqstInfoVO) 
			throws EventException ;	
    
    // ---------------------------------------------------------------------------
	// [CPS_GEM_0014_01] Requested expense Vs Approved expense
	// ---------------------------------------------------------------------------
    
    /**
     * 요청된 비용계획에 대하여 승인 정보를 조회한다<br>
     * 
     * @author P.C.J
     * @category CPS_GEM-0106
     * @category searchApprovalOpinionInfo
     * @param genExpnRqstNo 비용계획 요청 번호
     * @param genExpnCd 비용코드
     * @param genExpnItemNo 비용코드의 아이템번호
     * @return  List<GemApprovalStepVO> 요청된 비용계획에 대하여 승인 정보 리스트
     * @throws EventException
     */
    public List<GemApprovalStepVO> searchApprovalOpinionInfo(String genExpnRqstNo,
			String genExpnCd,String genExpnItemNo) throws EventException;
    
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
     * @return List<RqstPlanInfoVO> 유형별(계획비용,추가배정,예산이관) Request 요청된 정보 리스트
     * @throws EventException
     */
    public List<RqstPlanInfoVO> searchRqstInfo(RqstInfoVO rqstInfoVO) throws EventException;
    
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
     * @return List<PerformanceInfoVO> 비용계획을 요청중인 조직의 현재까지의 실적 정보 리스트
     * @throws EventException
     */
    public List<PerformanceInfoVO> searchPerformanceInquiry(PerfInqVO perfInqVO) throws EventException;
    
    // ---------------------------------------------------------------------------
	// [CPS_GEM_0108] Performance Inquiry_Additional
	// ---------------------------------------------------------------------------
    
    /**
     * 조직별 예산과 실적을 조회한다
     * @author P.C.J
     * @category CPS_GEM-0018_01
     * @category searchReportAfterClosingAll     
     * @param RqstInfoVO rqstInfoVO
     * @return List<ReportAfterClosingVO> 
     * @throws EventException
     */
    public List<ReportAfterClosingVO> searchReportAfterClosingAll(RqstInfoVO rqstInfoVO) 
			throws EventException ;	
    
    /**
     * 조회 기간에 대한 비목별 집행실적 분석 Report
     * @author P.C.J
     * @category CPS_GEM-0018_02
     * @category searchReportAfterClosingExpense      
     * @param RqstInfoVO rqstInfoVO
     * @return List<ReportAfterClosingVO>
     * @throws EventException
     */
    public List<ReportAfterClosingVO> searchReportAfterClosingExpense(RqstInfoVO rqstInfoVO) 
			throws EventException ;
    
    /**
     * 조회 기간에 대하여 Closing 반영된 집행단위별 집행실적 분석 Report
     * @author P.C.J
     * @category CPS_GEM-0018_03
     * @category searchReportAfterClosingOffice     
     * @param RqstInfoVO rqstInfoVO
     * @return List<ReportAfterClosingVO>
     * @throws EventException
     */
    public List<ReportAfterClosingVO> searchReportAfterClosingOffice(RqstInfoVO rqstInfoVO) 
			throws EventException ;
    
    /**
     * 조회 기간에 대하여 Closing 반영된 투자법인 집행단위별 집행실적 분석 Report
     * @author P.C.J
     * @category CPS_GEM-0018_04
     * @category searchReportAfterClosingSubsidiary     
     * @param RqstInfoVO rqstInfoVO 
     * @return List<ReportAfterClosingVO>
     * @throws EventException
     */
    public List<ReportAfterClosingVO> searchReportAfterClosingSubsidiary(RqstInfoVO rqstInfoVO) 
			throws EventException ;
    
    /**
     * 조회 대상/기간에 대하여 월별 배정 비용 리포트-해외배정비용현황 송부 참조용 Report
     * @author P.C.J
     * @category CPS_GEM-0018_05
     * @category searchReportAfterClosingMonthly      
     * @param RqstInfoVO rqstInfoVO
     * @return List<ReportAfterClosingVO>
     * @throws EventException
     */
    public List<ReportAfterClosingVO> searchReportAfterClosingMonthly(RqstInfoVO rqstInfoVO) 
			throws EventException ;
    
    /**
     * 조회 대상/기간에 대하여 월별 배정 비용 리포트-해외배정비용현황 송부 참조용 Report 커맨트
     * @author P.C.J
     * @category CPS_GEM-0018_05
     * @category searchReportAfterClosingMonthlyComment     
     * @param RqstInfoVO rqstInfoVO
     * @return List<ReportAfterClosingVO>
     * @throws EventException
     */
    public List<ReportAfterClosingVO> searchReportAfterClosingMonthlyComment(RqstInfoVO rqstInfoVO) 
			throws EventException ;
    
    /**
     * 조회 대상/기간에 대하여 월별 배정 비용 리포트-해외배정비용현황 송부 참조용 Report
     * @author P.C.J
     * @category CPS_GEM-0018_05
     * @category searchReportAfterClosingSinwaExpense     
     * @param RqstInfoVO rqstInfoVO
     * @return List<ReportAfterClosingVO> 
     * @throws EventException
     */
    public List<ReportAfterClosingVO> searchReportAfterClosingSinwaExpense(RqstInfoVO rqstInfoVO) 
			throws EventException ;
    
    /**
	 * CPS_GEM_0018_01화면의 DownExcel클릭시 Report After Closing BackEndJob 처리를 위한 JobKey요청
	 * 
	 * @author P.C.J
	 * @category CPS_GEM_0018_01
	 * @category searchReportAfterClosingAllBackEndJobKey
	 * 
	 * @param RqstInfoVO rqstInfoVO
	 * @param String acctUsrId
	 * @return String
	 * @throws Exception
	 */
    public String searchReportAfterClosingAllBackEndJobKey(RqstInfoVO rqstInfoVO, String acctUsrId) throws EventException;
    
    /**
	 * CPS_GEM_0018화면의 Report After Closing의 BackEndJob 처리 결과를 조회
	 * 
	 * @author P.C.J
	 * @category CPS_GEM_0018_01
	 * @category getBackEndJobResutReportAfterClosingAll
	 * 
	 * @param key
	 * @return List<ReportAfterClosingVO>
	 * @throws Exception
	 * @throws DAOException
	 */
    public List<ReportAfterClosingVO> getBackEndJobResutReportAfterClosingAll(String key) throws EventException;
    
    // ---------------------------------------------------------------------------
	// [CPS_GEM_0018] Summary_After Closing
	// ---------------------------------------------------------------------------
    
}