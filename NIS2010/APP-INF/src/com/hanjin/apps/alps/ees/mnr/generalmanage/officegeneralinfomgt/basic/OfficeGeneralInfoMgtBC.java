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
package com.hanjin.apps.alps.ees.mnr.generalmanage.officegeneralinfomgt.basic;

import com.hanjin.apps.alps.ees.mnr.generalmanage.officegeneralinfomgt.vo.ColleagueTreeGRPVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.officegeneralinfomgt.vo.OfficeGeneralInfoListGRPVO;
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

public interface OfficeGeneralInfoMgtBC {
	/**
	 * [EES_MNR_0135]Repair Approval Authority의 정보를 조회 합니다. <br>
	 *
	 * @param OfficeGeneralInfoListGRPVO officeGeneralInfoListGRPVO
	 * @return OfficeGeneralInfoListGRPVO
	 * @exception EventException
	 */
	public OfficeGeneralInfoListGRPVO searchOfficeGeneralInfoListBasic(OfficeGeneralInfoListGRPVO officeGeneralInfoListGRPVO) throws EventException ;
	/**
	 * [EES_MNR_0010]Repair Approval Authority의 정보를 추가/수정/삭제 합니다. <br>
	 *
	 * @param OfficeGeneralInfoListGRPVO officeGeneralInfoListGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageOfficeGeneralInfoListBasic(OfficeGeneralInfoListGRPVO officeGeneralInfoListGRPVO, SignOnUserAccount account) throws EventException;
	/**
	 * [EES_MNR_0217]M&R Colleague Tree의 정보를 조회 합니다. <br>
	 *
	 * @param ColleagueTreeGRPVO colleagueTreeGRPVO
	 * @return ColleagueTreeGRPVO
	 * @exception EventException
	 */
	public ColleagueTreeGRPVO searchColleagueTreeListBasic(ColleagueTreeGRPVO colleagueTreeGRPVO) throws EventException ;
	
	/**
	 * [EES_MNR_0217]M&R Colleague Tree의 정보를 추가/수정/삭제 합니다. <br>
	 *
	 * @param ColleagueTreeGRPVO colleagueTreeGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageColleagueTreeBasic(ColleagueTreeGRPVO colleagueTreeGRPVO,SignOnUserAccount account) throws EventException;
	
	
	
}