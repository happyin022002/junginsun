/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FQAResultMgtBC.java
*@FileTitle : FQA Result Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.20
*@LastModifier : 성덕경
*@LastVersion : 1.0
* 2009.05.20 성덕경
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.generalmanage.fqaresultmgt.basic;

import com.hanjin.apps.alps.ees.mnr.generalmanage.fqaresultmgt.vo.FQAResultMgtGRPVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * alps-Generalmanage Business Logic Command Interface<br>
 * - alps-Generalmanage에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author SEONG DUK KYUNG
 * @see Ui_mnr_0029EventResponse 참조
 * @since J2EE 1.4
 */

public interface FQAResultMgtBC {
	/**
	 * [EES_MNR_0223]FQA Result Detail Pop Up의 정보를 조회 합니다. <br>
	 *
	 * @param FQAResultMgtGRPVO fQAResultMgtGRPVO
	 * @return FQAResultMgtGRPVO
	 * @exception EventException
	 */
	public FQAResultMgtGRPVO searchFQAResultListBasic(FQAResultMgtGRPVO fQAResultMgtGRPVO) throws EventException;

	/**
	 * [EES_MNR_0029]FQA Result Creation의 정보를 추가/수정/삭제 합니다. <br>
	 *
	 * @param FQAResultMgtGRPVO fQAResultMgtGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageFQAResultBasic(FQAResultMgtGRPVO fQAResultMgtGRPVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * [EES_MNR_0029]FQA Result Creation의 정보를 삭제 합니다. <br>
	 *
	 * @param FQAResultMgtGRPVO fQAResultMgtGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void removeFQAResultBasic(FQAResultMgtGRPVO fQAResultMgtGRPVO,SignOnUserAccount account) throws EventException;

	/**
	 * [EES_MNR_0222]FQA Result Inquiry의 정보를 조회 합니다. <br>
	 *
	 * @param FQAResultMgtGRPVO fQAResultMgtGRPVO
	 * @return FQAResultMgtGRPVO
	 * @exception EventException
	 */
	public FQAResultMgtGRPVO searchFQAListBasic(FQAResultMgtGRPVO fQAResultMgtGRPVO) throws EventException;

}