/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : PlanMgtBC.java
 *@FileTitle : Expense Plan Creation by HO
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier :
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.mnr.planmanage.planmgt.basic;

import com.clt.apps.opus.ees.mnr.planmanage.planmgt.vo.GuidelineGRPVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * COM-Plan manage Business Logic Command Interface<br>
 * - COM-Plan manage interface of business logic<br>
 *
 * @author
 * @see Ees_mnr_0112EventResponse
 * @since J2EE 1.6
 */

public interface PlanMgtBC {
	/**
	 * [EES_MNR_0216] Retrieve "M&R Guideline & Information" data<br>
	 *
	 * @param GuidelineGRPVO guidelineGRPVO
	 * @param SignOnUserAccount account
	 * @return GuidelineGRPVO
	 * @exception EventException
	 */
	public GuidelineGRPVO searchGuidelineInfoListBasic(GuidelineGRPVO guidelineGRPVO, SignOnUserAccount account) throws EventException ;
	
	/**
	 * [EES_MNR_0216] Add, modify, delete "M&R Guideline & Information" data<br>
	 *
	 * @param GuidelineGRPVO guidelineGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageGuidelineInfoListBasic(GuidelineGRPVO guidelineGRPVO,SignOnUserAccount account) throws EventException;
}