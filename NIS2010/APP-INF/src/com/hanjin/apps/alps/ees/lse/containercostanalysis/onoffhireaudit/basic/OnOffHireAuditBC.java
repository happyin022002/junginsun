/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : IOnOffHireAuditBC.java
*@FileTitle : On off Hire Audit
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.19
*@LastModifier : 진준성
*@LastVersion : 1.0
* 2009.06.19 진준성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containercostanalysis.onoffhireaudit.basic;

import java.util.List;

import com.hanjin.apps.alps.ees.lse.containercostanalysis.onoffhireaudit.vo.OnOffHireAuditDetailVO;
import com.hanjin.apps.alps.ees.lse.containercostanalysis.onoffhireaudit.vo.OnOffHireAuditGroupVO;
import com.hanjin.apps.alps.ees.lse.containercostanalysis.onoffhireaudit.vo.OnOffHireAuditSearchVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * NIS2010-Containercostanalysis Business Logic Command Interface<br>
 * - NIS2010-Containercostanalysis에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Jin Jun Sung
 * @see Ees_lse_0055EventResponse 참조
 * @since J2EE 1.6
 */

public interface OnOffHireAuditBC {
	/**
	 * 조회 이벤트 처리<br>
	 * 임차 장비에 대한 임차-반납 조회<br>
	 *
	 * @param  OnOffHireAuditSearchVO onOffHireAuditSearchVO
	 * @return OnOffHireAuditGroupVO
	 * @exception EventException
	 */
	public OnOffHireAuditGroupVO searchAuditResultOnOffHirelistBasic(OnOffHireAuditSearchVO onOffHireAuditSearchVO) throws EventException;
	/**
	 * 조회 이벤트 처리<br>
	 * verify LSE_CTRT_NO 정합성 체크를 위한 조회<br>
	 *
	 * @param  OnOffHireAuditSearchVO onOffHireAuditSearchVO
	 * @return List<OnOffHireAuditSearchVO>
	 * @exception EventException
	 */
	public List<OnOffHireAuditSearchVO> verifyImportOnOffHireListBasic(OnOffHireAuditSearchVO onOffHireAuditSearchVO) throws EventException;
	/**
	 * 저장 이벤트 처리<br>
	 * Invodce File Import 화면에 대한 저장 이벤트 처리<br>
	 *
	 * @param OnOffHireAuditSearchVO[] onOffHireAuditSearchVOs
	 * @param account SignOnUserAccount
	 * @return String
	 * @exception EventException
	 */
	public String createImportOnOffHireListBasic(OnOffHireAuditSearchVO[] onOffHireAuditSearchVOs , SignOnUserAccount account) throws EventException;
	/**
	 * 조회 이벤트 처리<br>
	 * onoffhireaudit화면에 대한 조회 이벤트 처리<br>
	 * Audit 버전 리스트를 조회한다.
	 * @param  OnOffHireAuditSearchVO onOffHireAuditSearchVO
	 * @return List<OnOffHireAuditSearchVO>
	 * @exception EventException
	 */
	public List<OnOffHireAuditSearchVO> searchAuditResultOnOffHireVersionlistBasic(OnOffHireAuditSearchVO onOffHireAuditSearchVO) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * onoffhireaudit화면에 대한 조회 이벤트 처리<br>
	 * Lessor & HJS를 비교하여 Audit Result 리스트를 조회한다.
	 * @param  OnOffHireAuditDetailVO onOffHireAuditDetailVO
	 * @return List<List<OnOffHireAuditDetailVO>>
	 * @exception EventException
	 */
	public OnOffHireAuditGroupVO searchAuditResultOnOffHireBasic(OnOffHireAuditDetailVO onOffHireAuditDetailVO) throws EventException;



	/**
	 * 저장 이벤트 처리<br>
	 * onoffhireaudit화면에 대한 조회 이벤트 처리<br>
	 * Lessor & HJS를 비교하여  On/Off-Hire Audit 결과 저장
	 * @param OnOffHireAuditDetailVO onOffHireAuditDetailVO
	 * @param OnOffHireAuditDetailVO[] onOffHireAuditDetailVOs
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String createOnOffHireListBasic( OnOffHireAuditDetailVO onOffHireAuditDetailVO , OnOffHireAuditDetailVO[] onOffHireAuditDetailVOs , SignOnUserAccount account) throws EventException;

}