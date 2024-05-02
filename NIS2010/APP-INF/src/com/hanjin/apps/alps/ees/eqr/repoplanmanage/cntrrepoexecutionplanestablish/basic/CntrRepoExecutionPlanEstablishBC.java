/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CntrRepoExecutionPlanEstablishBC.java
*@FileTitle : Execution Plan
*Open Issues :
*Change history :
*-----------------------------------------------------------------------------
*	No.    Ver.		Modifier		Modifier Date		Explanation
*-----------------------------------------------------------------------------
*					Haeng-Ji Lee	2009-01-07			CSR No : N200901060030 - Oranization Chart에서 (RCC, LCC, ECC, SCC) 에 대한 갯수를 초기화면에 DISPLAY
*														CSR No : R200903270008 - 소스 품질 개선(사용하지 않는 지역변수 삭제)
*					Lee Byoung Hun	2010.05.11		CSR No : CHM-201003779 - EES_EQR_0143(EQR All-Weeks' Plan Access Grant) 이벤트 처리 추가
*-----------------------------------------------------------------------------
*@LastModifyDate : 2009.08.17
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2009.08.13 이행지
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.basic;

import java.util.List;

import com.hanjin.apps.alps.ees.eqr.common.eqrcommon.vo.CommonVO;
import com.hanjin.apps.alps.ees.eqr.common.vo.CommonRsVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.EesEqr0059ConditionVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.EesEqr0059MultiVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.EesEqr0080MultiVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.EesEqr0081MultiVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.EesEqr0083MultiVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.EesEqr0094ConditionVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.EesEqr0108ConditionVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.EesEqr0108MultiVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.EesEqr0112ConditionVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.EesEqr0113ConditionVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.EesEqr0130ConditionVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.EesEqr0131ConditionVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.EesEqr0143MultiVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.ModifyFromTrsOffHireReturnVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.MtyBkgVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.SearchBeforeCntrInfoVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.SearchCheckCntrInfoVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.SearchCntrRepoExecutionPlanEstablishVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.SearchEqrAllWeeksPlanAccessGrantVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.SearchEqrOrganizationVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.SearchExecutionPlanBkgNoVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.SearchExecutionPlanCntrInfoExcelVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.SearchExecutionPlanCntrInfoVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.SearchExecutionPlanCntrListVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.SearchExecutionPlanSplitCntrVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.SearchSendHistoryVO;
import com.hanjin.apps.alps.esd.trs.cydoorsomanage.singletransportationsomanage.vo.SingleTransportationVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.MtyBookingCreateVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.MtyBookingSplitVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-Repoplanmanage Business Logic Command Interface<br>
 * - ALPS-Repoplanmanage에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Haeng-ji,Lee
 * @see Ees_eqr_0059EventResponse 참조
 * @since J2EE 1.6
 */

public interface CntrRepoExecutionPlanEstablishBC {

	/**
	 * [EES_EQR_0059 : ]<br>
	 * 
	 * @param EesEqr0059ConditionVO eesEqr0059ConditionVO
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchTrunkVesselAndFeederCntrRepoPlan(EesEqr0059ConditionVO eesEqr0059ConditionVO) throws EventException;
	/**
	 * [EES_EQR_0059 : ]<br>
	 * 
	 * @param EesEqr0059ConditionVO eesEqr0059ConditionVO
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchTrunkVesselAndFeederCntrRepoPlanBKGNOInfo(EesEqr0059ConditionVO eesEqr0059ConditionVO) throws EventException;
	/**
	 * [EES_EQR_0059 : ]<br>
	 * 
	 * @param EesEqr0059ConditionVO eesEqr0059ConditionVO
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchTrunkVesselAndFeederCntrRepoPlanBKGNO(EesEqr0059ConditionVO eesEqr0059ConditionVO) throws EventException;
	/**
	 * [EES_EQR_0059 & EES_EQR_0080 : MTY Booking Creation ]<br>
	 * 
	 * @param commonVO EesEqr0059ConditionVO 
	 * @param account SignOnUserAccount
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public MtyBookingCreateVO createRepoBKG(CommonVO commonVO, SignOnUserAccount account) throws EventException;
	/**
	 * [EES_EQR_0059 : MTY BKG Split Creation ]<br>
	 * 
	 * @param eesEqr0059MultiVO	EesEqr0059MultiVO 
	 * @param account			SignOnUserAccount
	 * @return MtyBookingSplitVO
	 * @exception EventException
	 */
	public MtyBookingSplitVO createRepoBKGSplit(EesEqr0059MultiVO eesEqr0059MultiVO, SignOnUserAccount account) throws EventException;
	/**
	 * [EES_EQR_0059 : ]<br>
	 * 
	 * @param eesEqr0059MultiVOs EesEqr0059MultiVO[]
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyTrunkVesselAndFeederCntrRepoPlan(EesEqr0059MultiVO[] eesEqr0059MultiVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * [EES_EQR_0059 & EES_EQR_0080 : MTY Booking Creation 후 각 테이블에 Bkg No. 업데이트 해주기. ]<br>
	 * 
	 * @param mtyBkgVO MtyBkgVO
	 * @param commonVO CommonVO
	 * @exception EventException
	 */
	public void modifyMtyBkgNo(MtyBkgVO mtyBkgVO, CommonVO commonVO) throws EventException;
	/**
	 * 조회 이벤트 처리<br>
	 * CntrRepoExecutionPlanEstablish화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param condiVO EesEqr0113ConditionVO
	 * @return List<SearchCntrRepoExecutionPlanEstablishVO>
	 * @exception EventException
	 */
	public List<SearchCntrRepoExecutionPlanEstablishVO> searchCntrRepoExecutionPlanEstablish(EesEqr0113ConditionVO condiVO) throws EventException;
	/**
	 * 조회 이벤트 처리<br>
	 * CntrRepoExecutionPlanEstablish화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param  conditionVO EesEqr0094ConditionVO
	 * @return List<SearchExecutionPlanCntrListVO>
	 * @exception EventException
	 */
	public List<SearchExecutionPlanCntrListVO> searchCntrRepoExecutionPlanCntrList(EesEqr0094ConditionVO conditionVO) throws EventException;
	/**
	 * 조회 이벤트 처리<br>
	 * CntrRepoExecutionPlanEstablish화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param  conditionVO EesEqr0094ConditionVO
	 * @return List<SearchExecutionPlanCntrInfoVO>
	 * @exception EventException
	 */
	public List<SearchExecutionPlanCntrInfoVO> searchCntrRepoExecutionPlanCntrInfo(EesEqr0094ConditionVO conditionVO) throws EventException;
	/**
	 * 조회 이벤트 처리<br>
	 * CntrRepoExecutionPlanEstablish화면에 대한 조회 이벤트 처리<br>
	 * Excel
	 * @param  conditionVO EesEqr0094ConditionVO
	 * @return List<SearchExecutionPlanCntrInfoExcelVO>
	 * @exception EventException
	 */
	public List<SearchExecutionPlanCntrInfoExcelVO> searchCntrRepoExecutionPlanCntrInfoExcel(EesEqr0094ConditionVO conditionVO) throws EventException;
	/**
	 * 조회 이벤트 처리<br>
	 * CntrRepoExecutionPlanEstablish화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param  conditionVO EesEqr0094ConditionVO
	 * @return List<SearchCheckCntrInfoVO>
	 * @exception EventException
	 */
	public List<SearchCheckCntrInfoVO> searchCheckCntrInfo(EesEqr0094ConditionVO conditionVO) throws EventException;
	/**
	 * 조회 이벤트 처리<br>
	 * CntrRepoExecutionPlanEstablish화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param  conditionVO EesEqr0094ConditionVO
	 * @return List<SearchBeforeCntrInfoVO>
	 * @exception EventException
	 */
	public List<SearchBeforeCntrInfoVO> searchBeforeCntrInfo(EesEqr0094ConditionVO conditionVO) throws EventException;
	
	/**
	 * [BKG/DOC InterFace : Volume Change ]<br>
	 * 
	 * @param  MtyBkgVO mtyBkgVO
	 * @exception EventException
	 */
	public void modifyMtyBkgVolChange(MtyBkgVO mtyBkgVO) throws EventException;
	
	/**
	 * [BKG/DOC InterFace : Volume Cancel ]<br>
	 * 
	 * @param  mtyBkgVO MtyBkgVO
	 * @exception EventException
	 */
	public void modifyMtyBkgCancel(MtyBkgVO mtyBkgVO) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * EES_EQR_080Event 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param eesEqr0059ConditionVO EesEqr0059ConditionVO
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchTruckAndRailAndBargeCntrRepoPlan(EesEqr0059ConditionVO eesEqr0059ConditionVO) throws EventException;
	/**
	 * 수정 이벤트 처리<br>
	 * EES_EQR_080 에 대한 추가 이벤트 처리<br>
	 * 
	 * @param EesEqr0059ConditionVO eesEqr0059ConditionVO
	 * @param EesEqr0080MultiVO[] eesEqr0080MultiVOS
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyTruckAndRailAndBargeCntrRepoPlan(EesEqr0059ConditionVO eesEqr0059ConditionVO ,EesEqr0080MultiVO[] eesEqr0080MultiVOS , SignOnUserAccount account) throws EventException;
  /**
   * 수정 이벤트 처리<br>
   * EES_EQR_080 에 대한 추가 이벤트 처리<br>
   * 
   * @param conditionVO EesEqr0059ConditionVO
   * @param vos EesEqr0080MultiVO[]
   * @param account SignOnUserAccount
   * @exception EventException
   */
    public void soSendTruckAndRailAndBargeCntrRepoPlan(EesEqr0059ConditionVO conditionVO ,EesEqr0080MultiVO[] vos , SignOnUserAccount account) throws EventException;
	
	/**
	 * 수정 이벤트 처리<br>
	 * EES_EQR_108 에 대한 추가 이벤트 처리<br>
	 * 
	 * @param eesEqr0108ConditionVO EesEqr0108ConditionVO
	 * @param eesEqr0108MultiVOS EesEqr0108MultiVO[]
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyCombineExecution(EesEqr0108ConditionVO eesEqr0108ConditionVO ,EesEqr0108MultiVO[] eesEqr0108MultiVOS , SignOnUserAccount account) throws EventException;
	
	/**
	 * [ EES_EQR_0130 : BKG Split Create - Default, 화면 로딩시 Booking 정보 조회하여 보여주기. ]<br>
	 * 
	 * @param bkg_no String 
	 * @return List<SearchExecutionPlanBkgNoVO>
	 * @exception EventException
	 */
	public List<SearchExecutionPlanBkgNoVO> searchCntrRepoExecutionPlanBkgNoInfo(String bkg_no) throws EventException;
	
	/**
	 * [ EES_EQR_0130 : BKG Split Create - Container List ]<br>
	 * 
	 * @param eesEqr0130ConditionVO EesEqr0130ConditionVO 
	 * @return List<SearchExecutionPlanSplitCntrVO>
	 * @exception EventException
	 */
	public List<SearchExecutionPlanSplitCntrVO> searchCntrRepoExecutionPlanSplitCntrList(EesEqr0130ConditionVO eesEqr0130ConditionVO) throws EventException;
	
	/**
	 * [ EES_EQR_0139 : EQR Organization Chart - Default  ]<br>
	 * 
	 * @return SearchEqrOrganizationVO
	 * @exception EventException
	 */
	public SearchEqrOrganizationVO searchEqrOrganizationChartCount() throws EventException;
	
	/**
	 * [ EES_EQR_0139 : EQR Organization Chart - List  ]<br>
	 * 
	 * @return List<SearchEqrOrganizationVO>
	 * @exception EventException
	 */
	public List<SearchEqrOrganizationVO> searchEqrOrganizationChart() throws EventException;
	
	/**
     *- W/O Issue 테이블로 Execute중에 REF_ID별로 S/O Send 체크박스 클릭한 것만 삭제<br>
      - EQR_REPO_EXE_SO_IF 테이블의 REF_ID중에 WO_EXE_FLG 가 'Y'가 1개도 업어야 함  <br>           
		
	   DELETE : REF_ID 별로 위의 검색요건을 만족하면 삭제 수행 <br>
	           - EQR_REPO_EXE_SO_IF       삭제   ( 해당 REF_ID )<br>		
	           - EQR_EXE_PLN_CNTR         삭제   ( 해당 REF_ID )<br>
	           - EQR_INLND_TRSP_EXE_PLN   삭제   ( 해당 REF_ID )<br>
	 *          
	 * @param conditionVO EesEqr0059ConditionVO
	 * @param vos EesEqr0080MultiVO[]
	 * @param account SignOnUserAccount
     * @exception EventException
     */
    public void soCancelTruckAndRailAndBargeCntrRepoPlan(EesEqr0059ConditionVO conditionVO ,EesEqr0080MultiVO[] vos , SignOnUserAccount account) throws EventException;
    /**
	 * 조회 이벤트 처리<br>
	 * EES_EQR_081Event 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param eesEqr0059ConditionVO EesEqr0059ConditionVO
	 * @return CommonRsVO
	 * @exception EventException
	 */
    public CommonRsVO searchOnHireAndOffHireCntrRepoPlan(EesEqr0059ConditionVO eesEqr0059ConditionVO) throws EventException;
    /**
     * 수정 이벤트 처리<br>
     * EES_EQR_081 에 대한 추가 이벤트 처리<br>
     * 
     * @param eesEqr0059ConditionVO EesEqr0059ConditionVO
	 * @param eesEqr0081MultiVOS EesEqr0081MultiVO[]
	 * @param account SignOnUserAccount 
     * @exception EventException
     */
	public void modifyOnHireAndOffHireCntrRepoPlan(EesEqr0059ConditionVO eesEqr0059ConditionVO ,EesEqr0081MultiVO[] eesEqr0081MultiVOS , SignOnUserAccount account) throws EventException;
	/**
     * 수정 이벤트 처리<br>
     * EES_EQR_081 에 대한 추가 이벤트 처리<br>
     * 
     * @param eesEqr0059ConditionVO EesEqr0059ConditionVO
	 * @param eesEqr0081MultiVOS EesEqr0081MultiVO[]
	 * @param account SignOnUserAccount 
     * @exception EventException
     */
    public void soSendOnHireAndOffHireCntrRepoPlan(EesEqr0059ConditionVO eesEqr0059ConditionVO ,EesEqr0081MultiVO[] eesEqr0081MultiVOS , SignOnUserAccount account) throws EventException;
    
    /**
     * 수정 이벤트 처리<br>
     * EES_EQR_081 에 대한 추가 이벤트 처리<br>
     * 
     * @param eesEqr0059ConditionVO EesEqr0059ConditionVO
	 * @param eesEqr0081MultiVOS EesEqr0081MultiVO[]
	 * @param account SignOnUserAccount 
     * @exception EventException
     */
	public void soCancelOnHireAndOffHireCntrRepoPlan(EesEqr0059ConditionVO eesEqr0059ConditionVO ,EesEqr0081MultiVO[] eesEqr0081MultiVOS , SignOnUserAccount account) throws EventException;
	/**
	 * EES_EQR_0131 eMail  Send.<br>
	 * 
	 * @param conditionVO EesEqr0131ConditionVO
	 * @param account SignOnUserAccount 
	 * @exception EventException
	 */
	public void sendEmail(EesEqr0131ConditionVO conditionVO, SignOnUserAccount account) throws EventException;
	/**
	 * EES_EQR_0131 Fax  Send.<br>
	 * 
	 * @param conditionVO EesEqr0131ConditionVO
	 * @param account SignOnUserAccount 
	 * @exception EventException
	 */
	public void sendFax(EesEqr0131ConditionVO conditionVO, SignOnUserAccount account) throws EventException;
	/**
	 * EES_EQR_0132 search Send History email / FAX <br>
	 * 
	 * @param target String 
	 * @param job_cd String
	 * @param user_id String
	 * @return List<SearchSendHistoryVO>
	 * @exception EventException
	 */
	public List<SearchSendHistoryVO> searchSenderHistory( String target , String job_cd , String user_id)throws EventException;
	/**
	 * 조회 이벤트 처리<br>
	 * EES_EQR_083Event 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param eesEqr0059ConditionVO 
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchShuttleCntrRepoPlan(EesEqr0059ConditionVO eesEqr0059ConditionVO) throws EventException;
	/**
	 * 수정 이벤트 처리<br>
	 * EES_EQR_083 에 대한 추가 이벤트 처리<br>
	 * 
	 * @param eesEqr0059ConditionVO
	 * @param vos EesEqr0083MultiVO[]
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyShuttleCntrRepoPlan(EesEqr0059ConditionVO eesEqr0059ConditionVO , EesEqr0083MultiVO[] vos ,  SignOnUserAccount account) throws EventException;
	/**
     * 수정 이벤트 처리<br>
     * EES_EQR_083 에 대한 추가 이벤트 처리<br>
     * 
     * @param eesEqr0059ConditionVO
     * @param vos EesEqr0083MultiVO[]
     * @param account SignOnUserAccount
     * @exception EventException
     */
	public void soSendShuttleCntrRepoPlan(EesEqr0059ConditionVO eesEqr0059ConditionVO , EesEqr0083MultiVO[] vos ,  SignOnUserAccount account) throws EventException;
	/**
     * 수정 이벤트 처리<br>
     * EES_EQR_083 에 대한 추가 이벤트 처리<br>
     * 
     * @param eesEqr0059ConditionVO
     * @param vos EesEqr0083MultiVO[]
     * @param account SignOnUserAccount
     * @exception EventException
     */
    public void soCancelShuttleCntrRepoPlan(EesEqr0059ConditionVO eesEqr0059ConditionVO , EesEqr0083MultiVO[] vos ,  SignOnUserAccount account) throws EventException;
    /**
	 * [ EES_EQR_0112 : Forecasted Land Inventory ]<br>
	 * 
	 * @param eesEqr0112ConditionVO EesEqr0112ConditionVO	
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchLocalForecastedLandInv(EesEqr0112ConditionVO eesEqr0112ConditionVO) throws EventException;
	/**
	 * [ EES_EQR_0092 : Total ]<br>
	 * 
	 * @param eesEqr0059ConditionVO EesEqr0059ConditionVO	
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchTotalCntrRepoPlan(EesEqr0059ConditionVO eesEqr0059ConditionVO) throws EventException;
	/**
	 * added by ChungEunHo 09.10.15
	 * TRS에서 S/O 생성/수정/삭제시 EQR_REPO_EXE_SO_IF 테이블에 S/O상태 Field를 UPDATE
     * 
	 * @param singleTransportationVO SingleTransportationVO
	 * @return boolean
	 * @exception EventException
	 */
	public boolean modifyFromTrsSOIFPlanSoSts( SingleTransportationVO singleTransportationVO) throws EventException;
	/**
	 * added by ChungEunHo 09.10.21
	 * TRS 에서 Off Hire 직반납 시  ONF_HIR_EXE_PLN 및 S/O , CNTR 정보(신규 REF_ID 및 TO_YD_CD ) 수정
	 * 동일 ECC 내에서 TO_YD_CD 정보 수정됨 ( validation 은 TRS 에서 메소드 호출 전에 이루어짐
	 * 필수 입력항목 REPO_PLN_ID , PLN_YRWK , REF_ID , CNTR_TPSZ_CD , cntrNoList , TRSP_SO_STS_CD , CHD_TO_YD_CD ,CHD_TO_YD_Dt , CHD_CNTR_QTY
	 * @param vo ModifyFromTrsOffHireReturnVO
	 * @param account SignOnUserAccount
	 * @return ModifyFromTrsOffHireReturnVO NewRefId , ReturnCode
	 * @exception EventException
	 */
	public ModifyFromTrsOffHireReturnVO modifyFromTrsOffHireReturn( ModifyFromTrsOffHireReturnVO vo , SignOnUserAccount account)throws EventException ;
	
	/**
	 * EQR All-Weeks' Plan Access Grant 조회 이벤트 처리<br>
	 * 
	 * @return List<SearchEqrAllWeeksPlanAccessGrantVO>
	 * @exception EventException
	 */
	public List<SearchEqrAllWeeksPlanAccessGrantVO> searchEqrAllWeeksPlanAccessGrant() throws EventException;
	
	/**
	 * EQR All-Weeks' Plan Access Grant 수정 이벤트 처리<br>
	 * 
	 * @param eesEqr0143MultiVOs EesEqr0143MultiVO[]
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyEqrAllWeeksPlanAccessGrant(EesEqr0143MultiVO[] eesEqr0143MultiVOs, SignOnUserAccount account) throws EventException;
	
}