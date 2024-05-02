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
package com.clt.apps.opus.ees.mnr.generalmanage.officegeneralinfomgt.basic;

import com.clt.apps.opus.ees.mnr.generalmanage.officegeneralinfomgt.vo.ColleagueTreeGRPVO;
import com.clt.apps.opus.ees.mnr.generalmanage.officegeneralinfomgt.vo.OfficeGeneralInfoListGRPVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * COM-Plan manage Business Logic Command Interface<br>
 * - COM-Plan manage interface of business logic<br>
 *
 * @author
 * @see 	Ees_mnr_0112EventResponse
 * @since 	J2EE 1.6
 */

public interface OfficeGeneralInfoMgtBC {
	
	/**
	 * [EES_MNR_0135]Retrieving "Repair Approval Authority" data<br>
	 *
	 * @param OfficeGeneralInfoListGRPVO officeGeneralInfoListGRPVO
	 * @return OfficeGeneralInfoListGRPVO
	 * @exception EventException
	 */
	public OfficeGeneralInfoListGRPVO searchOfficeGeneralInfoListBasic(OfficeGeneralInfoListGRPVO officeGeneralInfoListGRPVO) throws EventException ;

	/**
	 * [EES_MNR_0010]Adding, modifying, deleting "Repair Approval Authority" data<br>
	 *
	 * @param OfficeGeneralInfoListGRPVO officeGeneralInfoListGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageOfficeGeneralInfoListBasic(OfficeGeneralInfoListGRPVO officeGeneralInfoListGRPVO, SignOnUserAccount account) throws EventException;

	/**
	 * [EES_MNR_0217]Retrieving "M&R Colleague Tree" data<br>
	 *
	 * @param ColleagueTreeGRPVO colleagueTreeGRPVO
	 * @return ColleagueTreeGRPVO
	 * @exception EventException
	 */
	public ColleagueTreeGRPVO searchColleagueTreeListBasic(ColleagueTreeGRPVO colleagueTreeGRPVO) throws EventException ;
	
	/**
	 * [EES_MNR_0217]Adding, modifying, deleting "M&R Colleague Tree" data<br>
	 *
	 * @param ColleagueTreeGRPVO colleagueTreeGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageColleagueTreeBasic(ColleagueTreeGRPVO colleagueTreeGRPVO,SignOnUserAccount account) throws EventException;
}