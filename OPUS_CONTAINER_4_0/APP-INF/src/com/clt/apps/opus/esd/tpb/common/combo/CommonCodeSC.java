/*=========================================================
*Copyright(c) 2006~2010 CyberLogitec
*@FileName : CommonCodeSC.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.tpb.common.combo;

import com.clt.apps.opus.esd.tpb.common.combo.basic.CommonCodeBC;
import com.clt.apps.opus.esd.tpb.common.combo.basic.CommonCodeBCImpl;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * -ESD Business Logic ServiceCommand<br>
 * - -ESD business transaction<br>
 * 
 * @author Youngchang_Kim
 * @see EsdTpb001EventResponse,CodeManageDBDAO reference
 * @since J2EE 1.4
 */
public class CommonCodeSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * ESD business scenario<br>
	 * CodeManage business scenario call<br>
	 */
	public void doStart() {
		try {
			// checking login
			account=getSignOnUserAccount();
		} catch (Exception e) {
			log.error("TPBCommonCodeSC 선행 작업 시 오류 " + e.toString(), e);
		}
	}

	/**
	 * ESD business scenario deadline<br>
	 * CodeManage business scenario deadline<br>
	 */
	public void doEnd() {
		// command.doEnd();
		log.debug("TPBCommonCodeSC 종료");
	}

	/**
	 * business scenario<br>
	 * branch processing all event by ESD business<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
//		log.debug("===========test==========");
		EventResponse eventResponse = null;
		
		eventResponse = searchCommonCode(e);

		return eventResponse;
	}

	/**
	 * retrieve event<br>
	 * list retrieve event<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCommonCode(Event e) throws EventException {
//		log.debug("===========test==========");
		EventResponse eventResponse = null;
		
		try {
			CommonCodeBC command = new CommonCodeBCImpl();
			eventResponse = command.searchCommonCode(e);
//			log.debug("=========searchCommonCode=========");
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

}
