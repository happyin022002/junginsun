/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : scenariodefaultmanageBC.java
*@FileTitle : Demand Forecast Parameter Management 
*Open Issues :
*Change history :
* No.	Ver.		Modifier           	modifier date    explanation
* 1     1.0      	jungran yang		2006-09-05		 1.0 최초 생성
* 2     1.0      	Lee Byoung Hun      2009.06.30		 New Framework 적용 Renewal
*
*@LastModifyDate : 2009.06.30
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2009.06.30 이행지
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.ees.eqr.common.vo.CommonRsVO;
import com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.vo.EesEqr0042ConditionVO;
import com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.vo.EesEqr0043ConditionVO;
import com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.vo.EesEqr0116ConditionVO;
import com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.vo.EesEqr0117ConditionVO;
import com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.vo.EesEqr0121ConditionVO;
import com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.vo.EesEqr0122ConditionVO;
import com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.vo.EesEqr0123ConditionVO;
import com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.vo.EesEqr0137ConditionVO;
import com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.vo.ScenarioDefaultManageRsVO;
import com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.vo.SearchAutoRunParameterVO;
import com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.vo.SearchEccMasterVO;
import com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.vo.SearchEccTsTmlVO;
import com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.vo.SearchEqrHolidayEffectVO;
import com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.vo.SearchSafetyStockVO;
import com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.vo.SearchYearSubleaseDetailPlanMonthlyVO;
import com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.vo.SearchYearSubleaseDetailPlanWeeklyVO;
import com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.vo.SearchYearSubleasePlanVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.EqrAutoRunFcastParaVO;
import com.hanjin.syscommon.common.table.EqrDmstPlnVO;
import com.hanjin.syscommon.common.table.EqrEccLnkVO;
import com.hanjin.syscommon.common.table.EqrEccMstVO;
import com.hanjin.syscommon.common.table.EqrEccSftStkVO;
import com.hanjin.syscommon.common.table.EqrEccTurnTmVO;
import com.hanjin.syscommon.common.table.EqrHolEffRtoVO;
import com.hanjin.syscommon.common.table.EqrHolidayVO;
import com.hanjin.syscommon.common.table.EqrLongTermOffhCondVO;
import com.hanjin.syscommon.common.table.EqrNewVanLongTermVO;
import com.hanjin.syscommon.common.table.EqrPortDchgCnstVO;
import com.hanjin.syscommon.common.table.EqrRepoCnstVO;
import com.hanjin.syscommon.common.table.EqrShrtTermOffhCondVO;
import com.hanjin.syscommon.common.table.EqrShrtTermOnhCondVO;
import com.hanjin.syscommon.common.table.EqrSubleaseVO;
import com.hanjin.syscommon.common.table.EqrTsTmlVO;
/**
 * ALPS-Defaultmanage Business Logic Command Interface<br>
 * - ALPS-Defaultmanage에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Chae Change Ho
 * @see EventResponse 참조
 * @since J2EE 1.6
 */


public interface ScenarioDefaultManageBC {
	
	/**
	 * [ EES_EQR_0115 : Retrieve ]
	 * ECC 정보 조회<br>
	 * 
	 * @param String status
	 * @param String location
	 * @return List<SearchEccMasterVO>
	 * @exception EventException
	 */
	public List<SearchEccMasterVO> searchDefaultECCInfo(String status, String location) throws EventException;
	
	/**
	 * [ EES_EQR_0115 : 상단 Sheet-TS컬럼 DoubleClick ]
	 * ECC TS 정보 조회<br>
	 * 
	 * @param eccCd String
	 * @return List<SearchEccTsTmlVO>
	 * @exception EventException
	 */
	public List<SearchEccTsTmlVO> searchDefaultTSTMLInfo(String eccCd) throws EventException;
	
	/**
	 * [ EES_EQR_0115 : Save ]
	 * [ ECC 정보 CUD ] <br>
	 * 
	 * @param eqrEccMstVOs EqrEccMstVO[]
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyDefaultECCInfo(EqrEccMstVO[] eqrEccMstVOs,SignOnUserAccount account) throws EventException;
	
	/**
	 * [ EES_EQR_0115 : Save ]
	 * 
	 * @param eqrTsTmlVOs EqrTsTmlVO[]
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyDefaultTSTMLInfo(EqrTsTmlVO[] eqrTsTmlVOs,SignOnUserAccount account) throws EventException;
	
	/**
	 * S/T On Hire 조회 이벤트 처리<br>
	 * 
	 * @param eccWhereCondition String
	 * @param tpsztype String
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchDefaultSTOnHireInfo(String eccWhereCondition, String tpsztype) throws EventException;
	
	/**
	 * S/T On Hire 멀티 이벤트 처리<br>
	 * 
	 * @param eqrShrtTermOnhCondVOs EqrShrtTermOnhCondVO[]
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyDefaultSTOnHireInfo(EqrShrtTermOnhCondVO[] eqrShrtTermOnhCondVOs,SignOnUserAccount account) throws EventException;
	
	/**
	 * L/T Off-Hire 조회 이벤트 처리<br>
	 * 
	 * @param eccWhereCondition String
	 * @param tpsztype String
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchDefaultLTOffHireInfo(String eccWhereCondition, String tpsztype) throws EventException;
	
	/**
	 * L/T Off-Hire 멀티 이벤트 처리<br>
	 * 
	 * @param eqrLongTermOffhCondVOs EqrLongTermOffhCondVO[]
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyDefaultLTOffHireInfo(EqrLongTermOffhCondVO[] eqrLongTermOffhCondVOs,SignOnUserAccount account) throws EventException;
	
	/**
	 * Sublease Out 조회 이벤트 처리<br>
	 * 
	 * @param conditionVO EesEqr0123ConditionVO
	 * @return List<SearchYearSubleasePlanVO>
	 * @exception EventException
	 */
	public List<SearchYearSubleasePlanVO> searchDefaultYearSubleasePlan(EesEqr0123ConditionVO conditionVO) throws EventException;
	
	/**
	 * Sublease Out 조회 이벤트 처리<br>
	 * 
	 * @param conditionVO EesEqr0123ConditionVO
	 * @return List<SearchYearSubleaseDetailPlanMonthlyVO>
	 * @exception EventException
	 */
	public List<SearchYearSubleaseDetailPlanMonthlyVO> searchDefaultYearSubleaseDetailPlanMonthly(EesEqr0123ConditionVO conditionVO) throws EventException;
	
	/**
	 * Sublease Out 조회 이벤트 처리<br>
	 * 
	 * @param conditionVO EesEqr0123ConditionVO
	 * @return List<SearchYearSubleaseDetailPlanWeeklyVO>
	 * @exception EventException
	 */
	public List<SearchYearSubleaseDetailPlanWeeklyVO> searchDefaultYearSubleaseDetailPlanWeekly(EesEqr0123ConditionVO conditionVO) throws EventException;
	
	/**
	 * Sublease Out 멀티 이벤트 처리<br>
	 * 
	 * @param conditionVO EesEqr0123ConditionVO
	 * @param countWeek List<String>
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void createDefaultYearSubleasePlan(EesEqr0123ConditionVO conditionVO,List<String> countWeek,SignOnUserAccount account) throws EventException;
	
	/**
	 * Sublease Out 멀티 이벤트 처리<br>
	 * 
	 * @param eqrSubleaseVOs EqrSubleaseVO[]
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyDefaultYearSubleasePlan(EqrSubleaseVO[] eqrSubleaseVOs,SignOnUserAccount account) throws EventException;
	/**
	 * @param condiVo EesEqr042ConditionVO
	 * @return List<SearchEqrHolidayEffectVO>
	 * @exception EventException
	 */
	public List<SearchEqrHolidayEffectVO> searchDefaultHolidayEffectInfo(EesEqr0042ConditionVO condiVo) throws EventException;


	/**
	 * @param condiVo EesEqr042ConditionVO
	 * @return ScenarioDefaultManageRsVO
	 * @exception EventException
	 */
	public ScenarioDefaultManageRsVO searchDefaultHolidayEffectDetailInfo2(EesEqr0042ConditionVO condiVo) throws EventException;

	/**
	 * @param condiVo EesEqr042ConditionVO
	 * @return ScenarioDefaultManageRsVO
	 * @exception EventException
	 */
	public ScenarioDefaultManageRsVO searchDefaultHolidayEffectDetailInfo3(EesEqr0042ConditionVO condiVo) throws EventException;
	
	/**
	 * @param vos EqrHolidayVO[]
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyDefaultHolidayEffectInfo( EqrHolidayVO[] vos , SignOnUserAccount account) throws EventException;
	
	/**
	 * @param vos EqrHolEffRtoVO[]
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyDefaultHolidayEffectDetailInfo(EqrHolEffRtoVO[] vos , SignOnUserAccount account) throws EventException;
	
	
	/**
	 * @param condiVO EesEqr121ConditionVO
	 * @return ScenarioDefaultManageRsVO
	 * @exception EventException
	 */
	public ScenarioDefaultManageRsVO searchDefaultYearNewvanPlan(EesEqr0121ConditionVO condiVO) throws EventException;
	
	/**
	 * @param condiVO EesEqr121ConditionVO
	 * @return ScenarioDefaultManageRsVO
	 * @exception EventException
	 */
	public ScenarioDefaultManageRsVO searchDefaultWeekNewvanPlan(EesEqr0121ConditionVO condiVO) throws EventException;
	
	/**
	 * @param condiVO EesEqr121ConditionVO
	 * @param vos EqrNewVanLongTermVO[]
	 * @param account SignOnUserAccount
	 * @param monthWeek String[][]
	 * @exception EventException
	 */
	public void modifyDefaultYearNewvanPlan(EesEqr0121ConditionVO condiVO , EqrNewVanLongTermVO[] vos , SignOnUserAccount account, String[][] monthWeek) throws EventException;

	/**
	 * @param condiVO EesEqr121ConditionVO
	 * @param vos EqrNewVanLongTermVO[]
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyDefaultWeekNewvanPlan(EesEqr0121ConditionVO condiVO,EqrNewVanLongTermVO[] vos, SignOnUserAccount account) throws EventException;

	/**
	 * @param condiVo EesEqr116ConditionVO
	 * @param fromEccAL ArrayList<String>
	 * @param toEccAL ArrayList<String>
	 * @return List<EqrEccLnkVO>
	 * @exception EventException
	 */	
	public List<EqrEccLnkVO> searchDefaultECCLinkInfo(EesEqr0116ConditionVO condiVo, ArrayList<String> fromEccAL , ArrayList<String> toEccAL) throws EventException;

	/**
	 * @param vos EqrEccLnkVO[]
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */	
	public void modifyDefaultECCLinkInfo(EqrEccLnkVO[] vos, SignOnUserAccount account) throws EventException;

	/**
	 * [ EES_EQR_0043 : Retrieve ]<br>
	 * Turn Time 조회<br>
	 * 
	 * @param eesEqr0043ConditionVO EesEqr0043ConditionVO
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchDefaultCntrTurnTimeInfo(EesEqr0043ConditionVO eesEqr0043ConditionVO) throws EventException;
	
	/**
	 * [ EES_EQR_0043 : Save ]<br>
	 * Turn Time 수정 및 삭제]<br>
	 * 
	 * @param eqrEccTurnTmVO EqrEccTurnTmVO[]
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyDefaultCntrTurnTimeInfo(EqrEccTurnTmVO[] eqrEccTurnTmVO, SignOnUserAccount account) throws EventException;

	/**
	 * [EES_EQR_0119 : S/T Off Hire 조회]<br>
	 * 
	 * @param String status
	 * @param String location
	 * @param String tpsztype
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchDefaultSTOffHireInfo(String status, String location, String tpsztype) throws EventException;
	
	/**
	 * [EES_EQR_0119 : S/T Off Hire 수정,삭제]<br>
	 * 
	 * @param EqrShrtTermOffhCondVO[] eqrShrtTermOffhCondVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyDefaultSTOffHireInfo(EqrShrtTermOffhCondVO[] eqrShrtTermOffhCondVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * [EES_EQR_0124 : Cabotage & HJS Rule 조회]<br><br>
	 * 
	 * @param String cnsttype
	 * @param String tpsztype
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchDefaultEmptyRepoConstraintInfo(String cnsttype, String tpsztype) throws EventException;
	
	/**
	 * [EES_EQR_0124 : Cabotage & HJS Rule 수정,삭제]<br><br>
	 * 
	 * @param EqrRepoCnstVO[] eqrRepoCnstVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyDefaultEmptyRepoConstraintInfo(EqrRepoCnstVO[] eqrRepoCnstVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * [EES_EQR_0137 : Constraint by Lane/POD 조회]<br>
	 * 
	 * @param EesEqr0137ConditionVO eesEqr0137ConditionVO
	 * @return ScenarioDefaultManageRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchDefaultConstraintLandPod(EesEqr0137ConditionVO eesEqr0137ConditionVO) throws EventException;
	
	/**
	 * [EES_EQR_0137 : Constraint by Lane/POD 수정,삭제]<br>
	 * 
	 * @param eqrPortDchgCnstVO EqrPortDchgCnstVO[]
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyDefaultConstraintLandPod(EqrPortDchgCnstVO[] eqrPortDchgCnstVO,SignOnUserAccount account) throws EventException;
	
	
	/**
	 * 조회 이벤트 처리<br>
	 * Scenariodefaultmanage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param searchAutoRunParameter SearchAutoRunParameterVO
	 * @return List<SearchAutoRunParameterVO>
	 * @exception EventException
	 */
	public List<SearchAutoRunParameterVO> searchAutoRunParameter(SearchAutoRunParameterVO searchAutoRunParameter) throws EventException;
	
	/**
	 * multi 이벤트 처리.<br>
	 * Scenariodefaultmanage화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param eqrAutoRunFcastParaVO EqrAutoRunFcastParaVO[]
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void multiAutoRunParameter(EqrAutoRunFcastParaVO[] eqrAutoRunFcastParaVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * Scenariodefaultmanage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param SearchSafetyStockVo searchSafetyStockVO
	 * @param String loc
	 * @param String loctype
	 * @param String tpsz
	 * @param String tpsztype
	 * @param String tpsztypes
	 * @param String lvlcd
	 * @return List<SearchSafetyStockVO>
	 * @exception EventException
	 */
	public CommonRsVO searchDefaultCntrSafetyStock (SearchSafetyStockVO searchSafetyStockVo ,String loc ,String loctype , String tpsz ,String tpsztype ,String tpsztypes ,String lvlcd) throws EventException;
	
	
	/**
	 * 조회 이벤트 처리<br>
	 * Scenariodefaultmanage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param eesEqr0117ConditionVO EesEqr0117ConditionVO
	 * @return List<EesEqr0117ConditionVO>
	 * @exception EventException
	 */
	public List<EesEqr0117ConditionVO> searchDefaultCntrSafetyStockQty (EesEqr0117ConditionVO eesEqr0117ConditionVO ) throws EventException;
	
	/**
	 * multi 이벤트 처리.<br>
	 * Scenariodefaultmanage화면에 대한 멀티 이벤트 처리<br>* 
	 * @param eqrEccSftStkVO EqrEccSftStkVO[]
	 * @param account	SignOnUserAccount
	 * @param lvl_cd	lvl_cd
	 * @exception EventException
	 */
	public void multiDefaultCntrSafetyStock(EqrEccSftStkVO[] eqrEccSftStkVO,SignOnUserAccount account ,String lvl_cd) throws EventException;
	/**
	 * 조회이벤트 처리.<br>
	 * Scenariodefaultmanage화면에 대한 멀티 이벤트 처리<br>* 
	 * @param eesEqr0122ConditionVO EesEqr0122ConditionVO
	 * @return ScenarioDefaultManageRsVO
	 * @exception EventException
	 */
	public ScenarioDefaultManageRsVO  searchDefaultYearDomesticPlan(EesEqr0122ConditionVO eesEqr0122ConditionVO) throws EventException;
	
	/**
	 * 조회이벤트 처리.<br>
	 * Scenariodefaultmanage화면에 대한 멀티 이벤트 처리<br>* 
	 * @param eesEqr0122ConditionVO EesEqr0122ConditionVO
	 * @return ScenarioDefaultManageRsVO
	 * @exception EventException
	 */
	public ScenarioDefaultManageRsVO  searchDefaultYearDomesticDetailPlan(EesEqr0122ConditionVO eesEqr0122ConditionVO) throws EventException;
	
	/**
	 * Multi 이벤트 처리.<br>
	 * Scenariodefaultmanage화면에 대한 멀티 이벤트 처리<br> 
	 * @param eqrDmstPlnVO EqrDmstPlnVO[]
	 * @param eesEqr0122ConditionVO	EesEqr0122ConditionVO
	 * @param rsCount List
	 * @param rsWeek List
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public void createDefaultYearDomesticPlan(EqrDmstPlnVO[] eqrDmstPlnVO ,EesEqr0122ConditionVO eesEqr0122ConditionVO, List rsCount, List rsWeek, SignOnUserAccount account)throws EventException;
	
	/**
	 * Multi 이벤트 처리.<br>
	 * Scenariodefaultmanage화면에 대한 멀티 이벤트 처리<br>* 
	 * @param eqrDmstPlnVO EqrDmstPlnVO[]
	 * @param eesEqr0122ConditionVO EesEqr0122ConditionVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */	
	public void modifyDefaultYearDomesticPlan(EqrDmstPlnVO[] eqrDmstPlnVO ,EesEqr0122ConditionVO eesEqr0122ConditionVO, SignOnUserAccount account)throws EventException;
}
