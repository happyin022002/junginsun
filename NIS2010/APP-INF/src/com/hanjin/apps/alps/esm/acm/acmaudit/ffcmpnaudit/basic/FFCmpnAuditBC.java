/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : FACommAuditBC.java
*@FileTitle : FACommAuditBC
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.02
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2012.04.02 김영오
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmaudit.ffcmpnaudit.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.acm.acmaudit.ffcmpnaudit.vo.FFCmpnAuditVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.apps.alps.esm.acm.acmaudit.ffcmpnaudit.vo.FFCmpnDetailBasicbyBlVO;
import com.hanjin.apps.alps.esm.acm.acmaudit.ffcmpnaudit.vo.FFCmpnDetailChargebyBlVO;
import com.hanjin.apps.alps.esm.acm.acmaudit.ffcmpnaudit.vo.FFCmpnDetailHistorybyBlVO;
import com.hanjin.apps.alps.esm.acm.acmaudit.ffcmpnaudit.vo.FFCmpnRateInfoVO;

/**
 * ALPS-ACMRequest Business Logic Command Interface<br>
 * - ALPS-ACMRequest에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author KIM, Young-Oh
 * @see Esm_Acm_0027EventResponse 참조
 * @since J2EE 1.6
 */

public interface FFCmpnAuditBC {

	/**
	 * [ESM_ACM_0027]
	 * FF Compensation Audit 목록을 조회<br>
	 *
	 * @param FFCmpnAuditVO ffcmpnAuditVO
	 * @return List<FFCmpnAuditVO>
	 * @exception EventException
	 */
	public List<FFCmpnAuditVO> searchFFCmpnAudit(FFCmpnAuditVO ffcmpnAuditVO) throws EventException;

	/**
	 * [ESM_ACM_0027]
	 * FAC Audit Re Calculate 버튼 클릭 시 처리 한다.<br>
	 *
	 * @param String bkg_no
	 * @param SignOnUserAccount account
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse reCalculateFFAudit(String bkg_no, SignOnUserAccount account) throws EventException;

	/**
	 * [ESM_ACM_0027]
	 * FF Compensation Audit 화면의 Reject 저장<br>
	 *
	 * @param FFCmpnAuditVO[] ffcmpnAuditVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageFFCmpnAudit(FFCmpnAuditVO[] ffcmpnAuditVOs, SignOnUserAccount account) throws EventException;

	/**
	 * [ESM_ACM_0117]-01
	 * FF Compensation Details &amp; History for B/L 기본 목록을 조회<br>
	 *
	 * @param FFCmpnDetailBasicbyBlVO ffCmpnDetailBasicbyBlVO
	 * @return List<FFCmpnDetailBasicbyBlVO>
	 * @exception EventException
	 */
	public List<FFCmpnDetailBasicbyBlVO> searchFFCmpnDetailBasicbyBlList(FFCmpnDetailBasicbyBlVO ffCmpnDetailBasicbyBlVO) throws EventException;

	/**
	 * [ESM_ACM_0117]-02
	 * FF Compensation Details &amp; History for B/L 기본 목록을 조회<br>
	 *
	 * @param FFCmpnDetailBasicbyBlVO ffCmpnDetailHistorybyBlVO
	 * @return List<FFCmpnDetailHistorybyBlVO>
	 * @exception EventException
	 */
	public List<FFCmpnDetailHistorybyBlVO> searchFFCmpnDetailHistorybyBlList(FFCmpnDetailBasicbyBlVO ffCmpnDetailHistorybyBlVO) throws EventException;

	/**
	 * [ESM_ACM_0117]-03
	 * FF Compensation Details &amp; History for B/L 기본 목록을 조회<br>
	 *
	 * @param FFCmpnDetailBasicbyBlVO ffCmpnDetailBasicbyBlVO
	 * @return List<FFCmpnDetailChargebyBlVO>
	 * @exception EventException
	 */
	public List<FFCmpnDetailChargebyBlVO> searchFFCmpnDetailChargebyBlList(FFCmpnDetailBasicbyBlVO ffCmpnDetailBasicbyBlVO) throws EventException;

	/**
	 * [ESM_ACM_0117]-04
	 * FF Compensation Details &amp; History for B/L 상세 목록을 조회<br>
	 *
	 * @param FFCmpnDetailHistorybyBlVO ffCmpnDetailHistorybyBlVO
	 * @return List<FFCmpnRateInfoVO>
	 * @exception EventException
	 */
	public List<FFCmpnRateInfoVO> searchFFCmpnRateInfoList(FFCmpnDetailHistorybyBlVO ffCmpnDetailHistorybyBlVO) throws EventException;

}