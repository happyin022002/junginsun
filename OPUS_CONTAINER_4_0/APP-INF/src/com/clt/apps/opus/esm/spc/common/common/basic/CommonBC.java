/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName       : CommonBC.java
*@FileTitle      : Common
*Open Issues     :
*Change history  :
*@LastModifyDate : 2006-10-11
*@LastModifier   : 김원섭
*@LastVersion    : 1.0
* 2006-10-11
* 1.0 최초 생성  
=========================================================*/

package com.clt.apps.opus.esm.spc.common.common.basic;

import java.util.List;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.apps.opus.esm.spc.common.common.vo.SearchOfficeCondVO;

/**
 * Common Business Logic Command Interface<br>
 * - Common에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author 김원섭
 * @see ComboxEventResponse 참조
 * @since J2EE 1.4
 */

public interface CommonBC {

	/**
	 * 조회 이벤트 처리<br>
	 * Common화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e EsmSpcCodEvent
	 * @return EventResponse ESM_SPC_CODEventResponse
	 * @exception EventException
	 */
	public EventResponse searchCommonCodeList(Event e) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * Common화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESM_SAQ_116Event
	 * @return EventResponse ESM_SAQ_116EventResponse
	 * @exception EventException
	 */
	public EventResponse searchChildOfficeList(Event e) throws EventException;
	/**
	 * 조회 이벤트 처리<br>
	 * Common화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESM_SAQ_116Event
	 * @return EventResponse ESM_SAQ_116EventResponse
	 * @exception EventException
	 */
	public EventResponse searchChildTeamOfficeList(Event e) throws EventException;
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param Event e
	 * @param SignOnUserAccount account
	 * @return List<SearchOfficeCondVO>
	 * @exception EventException 
	 */
	public List<SearchOfficeCondVO> searchOfficeCond(Event e, SignOnUserAccount account) throws EventException;
}