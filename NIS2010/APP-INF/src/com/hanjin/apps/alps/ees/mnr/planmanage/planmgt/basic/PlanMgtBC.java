/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PlanMgtBC.java
*@FileTitle : Expense Plan Creation by HO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.21
*@LastModifier : 정영훈
*@LastVersion : 1.0
* 2009.05.21 정영훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.planmanage.planmgt.basic;

import com.hanjin.apps.alps.ees.mnr.planmanage.planmgt.vo.OfficeInfoGRPVO;
import com.hanjin.apps.alps.ees.mnr.planmanage.planmgt.vo.DisposalPlanGRPVO;
import com.hanjin.apps.alps.ees.mnr.planmanage.planmgt.vo.GuidelineGRPVO;
import com.hanjin.apps.alps.ees.mnr.planmanage.planmgt.vo.RepairExpensePlanGRPVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;


/**
 * ALPS-Planmanage Business Logic Command Interface<br>
 * - ALPS-Planmanage에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author chung young hun
 * @see Ees_mnr_0112EventResponse 참조
 * @since J2EE 1.6
 */

public interface PlanMgtBC {
	/**
	 * [EES_MNR_0112]Expense Plan Creation by HO의 정보를 조회 합니다. <br>
	 *
	 * @param RepairExpensePlanGRPVO repairExpensePlanGRPVO
	 * @return RepairExpensePlanGRPVO
	 * @exception EventException
	 */
	public RepairExpensePlanGRPVO searchRepairExpensePlanListBasic(RepairExpensePlanGRPVO repairExpensePlanGRPVO) throws EventException ;
	
	/**
	 * [EES_MNR_0112]Expense Plan Creation by HO의 정보를 추가/수정/삭제 합니다. <br>
	 *
	 * @param RepairExpensePlanGRPVO repairExpensePlanGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageRepairExpensePlanBasic(RepairExpensePlanGRPVO repairExpensePlanGRPVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * [EES_MNR_0216]M&R Guideline & Information의 정보를 조회 합니다. <br>
	 *
	 * @param GuidelineGRPVO guidelineGRPVO
	 * @param SignOnUserAccount account
	 * @return GuidelineGRPVO
	 * @exception EventException
	 */
	public GuidelineGRPVO searchGuidelineInfoListBasic(GuidelineGRPVO guidelineGRPVO, SignOnUserAccount account) throws EventException ;
	
	/**
	 * [EES_MNR_0216]M&R Guideline & Information의 정보를 추가/수정/삭제 합니다. <br>
	 *
	 * @param GuidelineGRPVO guidelineGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageGuidelineInfoListBasic(GuidelineGRPVO guidelineGRPVO,SignOnUserAccount account) throws EventException;

	/**
	 * [EES_MNR_0153]Disposal Planning by Headquarter의 정보를 조회 합니다. <br>
	 *
	 * @param DisposalPlanGRPVO disposalPlanGRPVO
	 * @return DisposalPlanGRPVO
	 * @exception EventException
	 */
	public DisposalPlanGRPVO searchDisposalPlanBasic(DisposalPlanGRPVO disposalPlanGRPVO) throws EventException;

	/**
	 * [EES_MNR_0153]Disposal Planning by Headquarter의 정보를 추가/수정/삭제 합니다. <br>
	 *
	 * @param DisposalPlanGRPVO disposalPlanGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageDisposalPlanBasic(DisposalPlanGRPVO disposalPlanGRPVO, SignOnUserAccount account) throws EventException;


	/**
	 * [EES_MNR_0153]Disposal Planning by Headquarter의 정보를 체크 합니다. <br>
	 *
	 * @param DisposalPlanGRPVO disposalPlanGRPVO
	 * @return DisposalPlanGRPVO
	 * @exception EventException
	 */
	public DisposalPlanGRPVO checkDisposalPlanHeaderBasic(DisposalPlanGRPVO disposalPlanGRPVO) throws EventException;

	/**
	 * [EES_MNR_0212]M&R Regional Office Code Inquiry_Pop Up의 정보를 조회 합니다. <br>
	 *
	 * @param OfficeInfoGRPVO officeInfoGRPVO
	 * @return OfficeInfoGRPVO
	 * @exception EventException
	 */
	public OfficeInfoGRPVO searchOfficeCodeListBasic(OfficeInfoGRPVO officeInfoGRPVO) throws EventException;


}