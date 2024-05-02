/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ApprovalStepMgtBC.java
*@FileTitle : Approval Step
*Open Issues :
*Change history :
*@LastModifyDate : 2013.01.04
*@LastModifier : 조경완
*@LastVersion : 1.0
* 2013.01.04 조경완
* 1.0 Creation
* 2014-02-26 Jonghee HAN Live malfunction fixed 
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.generalmanage.approvalstepmgt.basic;

import java.util.List;

import com.hanjin.apps.alps.ees.mnr.generalmanage.approvalstepmgt.vo.ApprovalStepGRPVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.approvalstepmgt.vo.ApprovalStepINVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.approvalstepmgt.vo.CustomApprovalStepVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * alps-Generalmanage Business Logic Command Interface<br>
 * - alps-Generalmanage에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Cho Kyoung Wan
 * @see EventResponse 참조
 * @since J2EE 1.4
 */

public interface ApprovalStepMgtBC {
	/**
	 * [EES_MNR_0262]Approval Step 의 정보를 조회 합니다. <br>
	 *
	 * @param ApprovalStepGRPVO approvalStepGRPVO
	 * @param SignOnUserAccount account
	 * @return ApprovalStepGRPVO
	 * @exception EventException
	 */
	public ApprovalStepGRPVO searchApprovalStepBasic(ApprovalStepGRPVO approvalStepGRPVO, SignOnUserAccount account) throws EventException;

	/**
	 * [EES_MNR_0262]Approval Step History의 정보를 조회 합니다. <br>
	 *
	 * @param ApprovalStepGRPVO approvalStepGRPVO
	 * @return ApprovalStepGRPVO
	 * @exception EventException
	 */
	public ApprovalStepGRPVO searchApprovalStepHistoryBasic(ApprovalStepGRPVO approvalStepGRPVO) throws EventException;
	
	/**
	 * [EES_MNR_0262]Approval Step History 의 정보를 추가/수정/삭제 합니다. <br>
	 *
	 * @param ApprovalStepGRPVO approvalStepGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */ 
	public void manageApprovalStepHistoryBasic(ApprovalStepGRPVO approvalStepGRPVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * [EES_MNR_0263]Approval Step 의 Office Type를 조회 합니다. <br>
	 *
	 * @param ApprovalStepGRPVO approvalStepGRPVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String searchApprovalOfcTypeBasic(ApprovalStepGRPVO approvalStepGRPVO, SignOnUserAccount account) throws EventException;

	/**
	 * [EES_MNR_0265]Approval Step을 조회 합니다. <br>
	 *
	 * @param ApprovalStepGRPVO approvalStepGRPVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public ApprovalStepGRPVO searchApprovalStepRankBasic(ApprovalStepGRPVO approvalStepGRPVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Office Code 를 체크합니다 <br>
	 * 
	 * @param ApprovalStepINVO approvalStepINVO
	 * @return boolean
	 * @exception EventException
	 */
	public boolean checkOfficeBasic(ApprovalStepINVO approvalStepINVO) throws EventException;
	
	/**
	 * Office Code 를 중복체크합니다 <br>
	 * 
	 * @param ApprovalStepINVO approvalStepINVO
	 * @return boolean
	 * @exception EventException
	 */
	public boolean checkAproOfcBasic(ApprovalStepINVO approvalStepINVO) throws EventException;
	
	/**
	 * [EES_MNR_0265]User Name 을 조회합니다 <br>
	 *
	 * @param ApprovalStepINVO approvalStepINVO
	 * @param SignOnUserAccount account
	 * @return List<CustomApprovalStepVO>
	 * @exception EventException
	 */
	public List<CustomApprovalStepVO> searchUserNameBasic(ApprovalStepINVO approvalStepINVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * [EES_MNR_0265]Approval Step 정보를 추가/수정/삭제 합니다. <br>
	 *
	 * @param ApprovalStepGRPVO approvalStepGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */ 
	public void manageApprovalStepBasic(ApprovalStepGRPVO approvalStepGRPVO, SignOnUserAccount account) throws EventException;
}
