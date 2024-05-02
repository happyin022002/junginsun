/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CntrRepoExecutionPlanEstablishBC.java
*@FileTitle : Execution Plan
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.basic;

import java.util.List;

import com.clt.apps.opus.ees.eqr.common.eqrcommon.vo.CommonVO;
import com.clt.apps.opus.ees.eqr.common.eqrcommon.vo.EesCommonConditionVO;
import com.clt.apps.opus.ees.eqr.common.eqrcommon.vo.EesCommonVO;
import com.clt.apps.opus.ees.eqr.common.eqrcommon.vo.EqrCommonVO;
import com.clt.apps.opus.ees.eqr.common.vo.CommonRsVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.EesEqr0059ConditionVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.EesEqr0059MultiVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.EesEqr0080MultiVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.EesEqr0081MultiVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.EesEqr0083MultiVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.EesEqr0094ConditionVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.EesEqr0108ConditionVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.EesEqr0108MultiVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.EesEqr0112ConditionVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.EesEqr0113ConditionVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.EesEqr0130ConditionVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.EesEqr0131ConditionVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.EesEqr0143MultiVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.ModifyFromTrsOffHireReturnVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.MtyBkgVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.SearchBeforeCntrInfoVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.SearchCheckCntrInfoVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.SearchCntrRepoExecutionPlanEstablishVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.SearchEqrAllWeeksPlanAccessGrantVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.SearchEqrOrganizationVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.SearchExecutionPlanBkgNoVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.SearchExecutionPlanCntrInfoExcelVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.SearchExecutionPlanCntrInfoVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.SearchExecutionPlanCntrListVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.SearchExecutionPlanSplitCntrVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.SearchInlandRouteVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.SearchSendHistoryVO;
import com.clt.apps.opus.esd.trs.cydoorsomanage.singletransportationsomanage.vo.SingleTransportationVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.MtyBookingCreateVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.MtyBookingSplitVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * -Repoplanmanage Business Logic Command Interface<br>
 *
 * @author Haeng-ji,Lee
 * @see Ees_eqr_0059EventResponse
 * @since J2EE 1.6
 */

public interface CntrRepoExecutionPlanEstablishBC {

	/**
	 * [EES_EQR_0059 : ]<br>
	 * retrieving for Trunk vessel and feeder CNTR repo pla
	 * @param EesEqr0059ConditionVO eesEqr0059ConditionVO
	 * @param account SignOnUserAccount
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchTrunkVesselAndFeederCntrRepoPlan(EesEqr0059ConditionVO eesEqr0059ConditionVO, SignOnUserAccount account) throws EventException;
	/**
	 * [EES_EQR_0059 : ]<br>
	 * retrieving for Bkg No., when adding VD
	 * @param EesEqr0059ConditionVO eesEqr0059ConditionVO
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchTrunkVesselAndFeederCntrRepoPlanBKGNOInfo(EesEqr0059ConditionVO eesEqr0059ConditionVO) throws EventException;
	/**
	 * [EES_EQR_0059 : ]<br>
	 * retrieving for Bkg No., when adding VD
	 * @param EesEqr0059ConditionVO eesEqr0059ConditionVO
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchTrunkVesselAndFeederCntrRepoPlanBKGNO(EesEqr0059ConditionVO eesEqr0059ConditionVO) throws EventException;
	/**
	 * [EES_EQR_0059 & EES_EQR_0080 : MTY Booking Creation ]<br>
	 * creating repo BKG
	 * @param commonVO EesEqr0059ConditionVO 
	 * @param account SignOnUserAccount
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public MtyBookingCreateVO createRepoBKG(CommonVO commonVO, SignOnUserAccount account) throws EventException;
	/**
	 * [EES_EQR_0059 : MTY BKG Split Creation ]<br>
	 * creating BKG Split No. 
	 * @param eesEqr0059MultiVO	EesEqr0059MultiVO 
	 * @param account			SignOnUserAccount
	 * @return MtyBookingSplitVO
	 * @exception EventException
	 */
	public MtyBookingSplitVO createRepoBKGSplit(EesEqr0059MultiVO eesEqr0059MultiVO, SignOnUserAccount account) throws EventException;
	/**
	 * [EES_EQR_0059 : ]<br>
	 * saving trunk vessel and feeder cntr repo plan
	 * @param eesEqr0059MultiVOs EesEqr0059MultiVO[]
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyTrunkVesselAndFeederCntrRepoPlan(EesEqr0059MultiVO[] eesEqr0059MultiVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * [EES_EQR_0059 & EES_EQR_0080 :  ]<br>
	 * updating Bkg No., after MTY Booking Creation
	 * @param mtyBkgVO MtyBkgVO
	 * @param commonVO CommonVO
	 * @exception EventException
	 */
	public void modifyMtyBkgNo(MtyBkgVO mtyBkgVO, CommonVO commonVO) throws EventException;
	/**
	 * retrieving for Cntr Repo Execution Plan Establish<br>
	 * 
	 * @param condiVO EesEqr0113ConditionVO
	 * @return List<SearchCntrRepoExecutionPlanEstablishVO>
	 * @exception EventException
	 */
	public List<SearchCntrRepoExecutionPlanEstablishVO> searchCntrRepoExecutionPlanEstablish(EesEqr0113ConditionVO condiVO) throws EventException;
	/**
	 * retrieving for CNTR Repo Execution Plan CNTR List<br>
	 * 
	 * @param  conditionVO EesEqr0094ConditionVO
	 * @return List<SearchExecutionPlanCntrListVO>
	 * @exception EventException
	 */
	public List<SearchExecutionPlanCntrListVO> searchCntrRepoExecutionPlanCntrList(EesEqr0094ConditionVO conditionVO) throws EventException;
	/**
	 * retrieving for CNTR Repo Execution Plan CNTR Info<br>
	 * 
	 * @param  conditionVO EesEqr0094ConditionVO
	 * @return List<SearchExecutionPlanCntrInfoVO>
	 * @exception EventException
	 */
	public List<SearchExecutionPlanCntrInfoVO> searchCntrRepoExecutionPlanCntrInfo(EesEqr0094ConditionVO conditionVO) throws EventException;
	/**
	 * retrieving CNTR Repo Execution Plan CNTR Info Excel<br>
	 * Excel
	 * @param  conditionVO EesEqr0094ConditionVO
	 * @return List<SearchExecutionPlanCntrInfoExcelVO>
	 * @exception EventException
	 */
	public List<SearchExecutionPlanCntrInfoExcelVO> searchCntrRepoExecutionPlanCntrInfoExcel(EesEqr0094ConditionVO conditionVO) throws EventException;
	/**
	 * checking CNTR info<br>
	 * 
	 * @param  conditionVO EesEqr0094ConditionVO
	 * @return List<SearchCheckCntrInfoVO>
	 * @exception EventException
	 */
	public List<SearchCheckCntrInfoVO> searchCheckCntrInfo(EesEqr0094ConditionVO conditionVO) throws EventException;
	/**
	 * retrieving for before CNTR info<br>
	 * 
	 * @param  conditionVO EesEqr0094ConditionVO
	 * @return List<SearchBeforeCntrInfoVO>
	 * @exception EventException
	 */
	public List<SearchBeforeCntrInfoVO> searchBeforeCntrInfo(EesEqr0094ConditionVO conditionVO) throws EventException;
	
	/**
	 * [BKG/DOC InterFace : Volume Change ]<br>
	 * changing Volume
	 * @param  MtyBkgVO mtyBkgVO
	 * @exception EventException
	 */
	public void modifyMtyBkgVolChange(MtyBkgVO mtyBkgVO) throws EventException;
	
	/**
	 * [BKG/DOC InterFace : Volume Cancel ]<br>
	 * Canceling Mty Booking
	 * @param  mtyBkgVO MtyBkgVO
	 * @exception EventException
	 */
	public void modifyMtyBkgCancel(MtyBkgVO mtyBkgVO) throws EventException;
	
	/**
	 * retrieving for truck and rail and barge CNTR repo plan<br>
	 * 
	 * @param eesEqr0059ConditionVO EesEqr0059ConditionVO
	 * @param account SignOnUserAccount
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchTruckAndRailAndBargeCntrRepoPlan(EesEqr0059ConditionVO eesEqr0059ConditionVO , SignOnUserAccount account) throws EventException;
	/**
	 * saving for truck and rail and barge CNTR repo plan<br>
	 * 
	 * @param EesEqr0059ConditionVO eesEqr0059ConditionVO
	 * @param EesEqr0080MultiVO[] eesEqr0080MultiVOS
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyTruckAndRailAndBargeCntrRepoPlan(EesEqr0059ConditionVO eesEqr0059ConditionVO ,EesEqr0080MultiVO[] eesEqr0080MultiVOS , SignOnUserAccount account) throws EventException;
  /**
	 * sending truck and rail and barge CNTR repo plan<br>
   * 
   * @param conditionVO EesEqr0059ConditionVO
   * @param vos EesEqr0080MultiVO[]
   * @param account SignOnUserAccount
   * @exception EventException
   */
    public void soSendTruckAndRailAndBargeCntrRepoPlan(EesEqr0059ConditionVO conditionVO ,EesEqr0080MultiVO[] vos , SignOnUserAccount account) throws EventException;
	
	/**
	 * saving combin execution<br>
	 * 
	 * @param eesEqr0108ConditionVO EesEqr0108ConditionVO
	 * @param eesEqr0108MultiVOS EesEqr0108MultiVO[]
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyCombineExecution(EesEqr0108ConditionVO eesEqr0108ConditionVO ,EesEqr0108MultiVO[] eesEqr0108MultiVOS , SignOnUserAccount account) throws EventException;
	
	/**
	 * [ EES_EQR_0130 : BKG Split Create - Default]<br>
	 * retrieving for CNTR repo exection plan bkg no. info.
	 * @param bkg_no String 
	 * @return List<SearchExecutionPlanBkgNoVO>
	 * @exception EventException
	 */
	public List<SearchExecutionPlanBkgNoVO> searchCntrRepoExecutionPlanBkgNoInfo(String bkg_no) throws EventException;
	
	/**
	 * [ EES_EQR_0130 : BKG Split Create - Container List ]<br>
	 * retrieving for CNTR repo exection plan aplit CNTR list
	 * @param eesEqr0130ConditionVO EesEqr0130ConditionVO 
	 * @return List<SearchExecutionPlanSplitCntrVO>
	 * @exception EventException
	 */
	public List<SearchExecutionPlanSplitCntrVO> searchCntrRepoExecutionPlanSplitCntrList(EesEqr0130ConditionVO eesEqr0130ConditionVO) throws EventException;
	
	/**
	 * [ EES_EQR_0139 : EQR Organization Chart - Default  ]<br>
	 * retrieving for EQR Oragnization cart count
	 * @return SearchEqrOrganizationVO
	 * @exception EventException
	 */
	public SearchEqrOrganizationVO searchEqrOrganizationChartCount() throws EventException;
	
	/**
	 * [ EES_EQR_0139 : EQR Organization Chart - List  ]<br>
	 * retrieving for EQR organization chart
	 * @return List<SearchEqrOrganizationVO>
	 * @exception EventException
	 */
	public List<SearchEqrOrganizationVO> searchEqrOrganizationChart() throws EventException;
	
	/**
	 * canceling sending truck and rail and barge CNTR repo plan  <br>           
	 *          
	 * @param conditionVO EesEqr0059ConditionVO
	 * @param vos EesEqr0080MultiVO[]
	 * @param account SignOnUserAccount
     * @exception EventException
     */
    public void soCancelTruckAndRailAndBargeCntrRepoPlan(EesEqr0059ConditionVO conditionVO ,EesEqr0080MultiVO[] vos , SignOnUserAccount account) throws EventException;
    /**
	 * retrieving for on hire and off hire CNTR repo plan<br>
	 * 
	 * @param eesEqr0059ConditionVO EesEqr0059ConditionVO
	 * @param account SignOnUserAccount
	 * @return CommonRsVO
	 * @exception EventException
	 */
    public CommonRsVO searchOnHireAndOffHireCntrRepoPlan(EesEqr0059ConditionVO eesEqr0059ConditionVO , SignOnUserAccount account) throws EventException;
    /**
     * saving for on hire and off hire CNTR repo plan<br>
     * 
     * @param eesEqr0059ConditionVO EesEqr0059ConditionVO
	 * @param eesEqr0081MultiVOS EesEqr0081MultiVO[]
	 * @param account SignOnUserAccount 
     * @exception EventException
     */
	public void modifyOnHireAndOffHireCntrRepoPlan(EesEqr0059ConditionVO eesEqr0059ConditionVO ,EesEqr0081MultiVO[] eesEqr0081MultiVOS , SignOnUserAccount account) throws EventException;
	/**
     * sending on hire and off hire CNTR repo plan<br>
     * 
     * @param eesEqr0059ConditionVO EesEqr0059ConditionVO
	 * @param eesEqr0081MultiVOS EesEqr0081MultiVO[]
	 * @param account SignOnUserAccount 
     * @exception EventException
     */
    public void soSendOnHireAndOffHireCntrRepoPlan(EesEqr0059ConditionVO eesEqr0059ConditionVO ,EesEqr0081MultiVO[] eesEqr0081MultiVOS , SignOnUserAccount account) throws EventException;
    
    /**
     * Canceling sending on hire and off hire CNTR repo plan<br>
     * 
     * @param eesEqr0059ConditionVO EesEqr0059ConditionVO
	 * @param eesEqr0081MultiVOS EesEqr0081MultiVO[]
	 * @param account SignOnUserAccount 
     * @exception EventException
     */
	public void soCancelOnHireAndOffHireCntrRepoPlan(EesEqr0059ConditionVO eesEqr0059ConditionVO ,EesEqr0081MultiVO[] eesEqr0081MultiVOS , SignOnUserAccount account) throws EventException;
	/**
	 * EES_EQR_0131 eMail  Send.<br>
	 * sending email
	 * @param conditionVO EesEqr0131ConditionVO
	 * @param account SignOnUserAccount 
	 * @exception EventException
	 */
	public void sendEmail(EesEqr0131ConditionVO conditionVO, SignOnUserAccount account) throws EventException;
	/**
	 * EES_EQR_0131 Fax  Send.<br>
	 * sending fax
	 * @param conditionVO EesEqr0131ConditionVO
	 * @param account SignOnUserAccount 
	 * @exception EventException
	 */
	public void sendFax(EesEqr0131ConditionVO conditionVO, SignOnUserAccount account) throws EventException;
	/**
	 * EES_EQR_0132 <br>
	 * retrieving for Send History email / FAX
	 * @param target String 
	 * @param job_cd String
	 * @param user_id String
	 * @return List<SearchSendHistoryVO>
	 * @exception EventException
	 */
	public List<SearchSendHistoryVO> searchSenderHistory( String target , String job_cd , String user_id)throws EventException;
	/**
	 * retrieving for shuttle CNTR repo plan<br>
	 * 
	 * @param EesEqr0059ConditionVO eesEqr0059ConditionVO 
	 * @param account SignOnUserAccount
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchShuttleCntrRepoPlan(EesEqr0059ConditionVO eesEqr0059ConditionVO ,  SignOnUserAccount account) throws EventException;
	/**
	 * aving suttle CNTR repo plan<br>
	 * 
	 * @param eesEqr0059ConditionVO
	 * @param vos EesEqr0083MultiVO[]
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyShuttleCntrRepoPlan(EesEqr0059ConditionVO eesEqr0059ConditionVO , EesEqr0083MultiVO[] vos ,  SignOnUserAccount account) throws EventException;
	/**
     * sending shuttle CNTR repo plan<br>
     * 
     * @param eesEqr0059ConditionVO
     * @param vos EesEqr0083MultiVO[]
     * @param account SignOnUserAccount
     * @exception EventException
     */
	public void soSendShuttleCntrRepoPlan(EesEqr0059ConditionVO eesEqr0059ConditionVO , EesEqr0083MultiVO[] vos ,  SignOnUserAccount account) throws EventException;
	/**
     * Canceling sending shuttle CNTR repo plan<br>
     * 
     * @param eesEqr0059ConditionVO
     * @param vos EesEqr0083MultiVO[]
     * @param account SignOnUserAccount
     * @exception EventException
     */
    public void soCancelShuttleCntrRepoPlan(EesEqr0059ConditionVO eesEqr0059ConditionVO , EesEqr0083MultiVO[] vos ,  SignOnUserAccount account) throws EventException;
    /**
	 * [ EES_EQR_0112 :  ]<br>
	 * Forecasted Land Inventory
	 * @param eesEqr0112ConditionVO EesEqr0112ConditionVO	
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchLocalForecastedLandInv(EesEqr0112ConditionVO eesEqr0112ConditionVO) throws EventException;
	/**
	 * [ EES_EQR_0092 : Total ]<br>
	 * retrieving for tatal CNTR repo plan
	 * @param eesEqr0059ConditionVO EesEqr0059ConditionVO	
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchTotalCntrRepoPlan(EesEqr0059ConditionVO eesEqr0059ConditionVO) throws EventException;
	/**
	 * in case of creating/modifying/removing S/O from TRS, updating S/O status on EQR_REPO_EXE_SO_IF
     * 
	 * @param singleTransportationVO SingleTransportationVO
	 * @return boolean
	 * @exception EventException
	 */
	public boolean modifyFromTrsSOIFPlanSoSts( SingleTransportationVO singleTransportationVO) throws EventException;
	/**
	 * modifying ONF_HIR_EXE_PLN, S/O , CNTR info(new REF_ID and TO_YD_CD )
	 * @param vo ModifyFromTrsOffHireReturnVO
	 * @param account SignOnUserAccount
	 * @return ModifyFromTrsOffHireReturnVO NewRefId , ReturnCode
	 * @exception EventException
	 */
	public ModifyFromTrsOffHireReturnVO modifyFromTrsOffHireReturn( ModifyFromTrsOffHireReturnVO vo , SignOnUserAccount account)throws EventException ;
	
	/**
	 * retreiving for EQR All-Weeks' Plan?Access Grant<br>
	 * 
	 * @return List<SearchEqrAllWeeksPlanAccessGrantVO>
	 * @exception EventException
	 */
	public List<SearchEqrAllWeeksPlanAccessGrantVO> searchEqrAllWeeksPlanAccessGrant() throws EventException;
	
	/**
	 * modifying EQR All-Weeks' Plan?Access Grant<br>
	 * 
	 * @param eesEqr0143MultiVOs EesEqr0143MultiVO[]
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyEqrAllWeeksPlanAccessGrant(EesEqr0143MultiVO[] eesEqr0143MultiVOs, SignOnUserAccount account) throws EventException;

	/**
	 * retrieving for LOC YARD <br>
	 * @param conditionVO EesCommonConditionVO
	 * @return EesCommonVO
	 * @exception EventException
	 */			
	public EesCommonVO searchLocYardInfo(EesCommonConditionVO conditionVO) throws EventException;
	
	/**
	 * EES_EQR_0059_POP : retrieve <br>
	* EQR Search
	* @category EES_EQR_0059_POP
	* @category searchInlandRouteListBasic 
	* @param SearchInlandRouteVO searchInlandRouteVO
	* @return List<SearchInlandRouteVO> 
	* @exception EventException
	*/	
	public List<SearchInlandRouteVO> searchInlandRouteListBasic(SearchInlandRouteVO searchInlandRouteVO) throws EventException;
	
	/**
	 * vvd check : retrieve <br>
	 * @param conditionVO EesEqr0059ConditionVO
	 * @param vos EesEqr0080MultiVO[]
	 * @param account SignOnUserAccount
	 * @return String
	 * @exception EventException
	 */
	public String searchCheckVvdLocationInfo( EesEqr0059ConditionVO conditionVO ,EesEqr0080MultiVO[] vos , SignOnUserAccount account) throws EventException;
	
	/**
	 * vvd dup check : retrieve <br>
	 * @param conditionVO EesEqr0059ConditionVO
	 * @param vos EesEqr0080MultiVO[]
	 * @param account SignOnUserAccount
	 * @return String
	 * @exception EventException
	 */
	public String searchDupCheckVvdLocationInfo( EesEqr0059ConditionVO conditionVO ,EesEqr0080MultiVO[] vos , SignOnUserAccount account) throws EventException;
	
	/**
	 * saving for truck and rail and barge CNTR repo plan<br>
	 * 
	 * @param EesEqr0059ConditionVO eesEqr0059ConditionVO
	 * @param EesEqr0080MultiVO[] eesEqr0080MultiVOS
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyCntrRepoExePlan(EesEqr0059ConditionVO eesEqr0059ConditionVO ,EesEqr0080MultiVO[] eesEqr0080MultiVOS , SignOnUserAccount account) throws EventException;
	
	/**
	 * retrieving for truck and rail and barge CNTR repo plan<br>
	 * 
	 * @param eesEqr0059ConditionVO EesEqr0059ConditionVO
	 * @param account SignOnUserAccount
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchRepoExePlanList(EesEqr0059ConditionVO eesEqr0059ConditionVO , SignOnUserAccount account) throws EventException;
	
	/**
	 * sending truck and rail and barge CNTR repo plan<br>
   * 
   * @param conditionVO EesEqr0059ConditionVO
   * @param vos EesEqr0080MultiVO[]
   * @param account SignOnUserAccount
   * @exception EventException
   */
    public void soSendCntrRepoExePlan(EesEqr0059ConditionVO conditionVO ,EesEqr0080MultiVO[] vos , SignOnUserAccount account) throws EventException;
        
    /**
	 * canceling sending truck and rail and barge CNTR repo plan  <br>           
	 *          
	 * @param conditionVO EesEqr0059ConditionVO
	 * @param vos EesEqr0080MultiVO[]
	 * @param account SignOnUserAccount
     * @exception EventException
     */
    public void soCancelSendCntrRepoExePlan(EesEqr0059ConditionVO conditionVO ,EesEqr0080MultiVO[] vos , SignOnUserAccount account) throws EventException;
	
    /**
     * Repo Plan Delete
     * 
     * @param eesEqr0059ConditionVO
     * @param account
     * @return String
     * @throws EventException
     */
    public String deleteRepoExePlanId(EesEqr0059ConditionVO eesEqr0059ConditionVO,SignOnUserAccount account) throws EventException;
    
    /**
     * 
     * @param conditionVO
     * @param account
     * @return
     * @throws EventException
     */
	public List<EqrCommonVO> searchRepoExePlanTypeSizeList(EesEqr0059ConditionVO conditionVO ,SignOnUserAccount account) throws EventException;
}