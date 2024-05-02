/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CntrCommonSC.java
*@FileTitle : Common
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 
=========================================================*/

package com.clt.apps.opus.ees.eqr.cntrcommon;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.ees.eqr.cntrcommon.eqrcommon.basic.CommonBC;
import com.clt.apps.opus.ees.eqr.cntrcommon.eqrcommon.basic.CommonBCImpl;
import com.clt.apps.opus.ees.eqr.cntrcommon.eqrcommon.event.EesCommonEvent;
import com.clt.apps.opus.ees.eqr.cntrcommon.eqrcommon.vo.CommonVO;
import com.clt.apps.opus.ees.eqr.cntrcommon.eqrcommon.vo.EesCommonVO;
import com.clt.apps.opus.ees.eqr.common.eqrcommon.vo.EqrCommonVO;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * opus-Common Business Logic ServiceCommand
 * @author 
 * @see ComboxEventResponse,CommonDBDAO
 * @since J2EE 1.4
 */

public class CntrCommonSC extends ServiceCommandSupport {

	SignOnUserAccount account = null; 

	/**
	 * Common start
	 */
	public void doStart() {
		try {
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error("CntrCommonSC error occured " + e.toString(), e);
		}
	}

	/**
	 * Common end<br>
	 */
	public void doEnd() {
		log.debug("CntrCommonSC end");
	}

	/**
	 * opus-Common <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;
		
		
		if(e.getFormCommand().isCommand(FormCommand.SEARCH13)) {  // Trade Search
			eventResponse = searchTradeEqrAccess(e);
		}
		
		if(e.getFormCommand().isCommand(FormCommand.SEARCH12)) { // LOC YARD INITIAL VESSEL SEARCH
			eventResponse = searchLocYardInitialInfo(e);
						
		}
		
		if (e.getEventName().equalsIgnoreCase("EesEqrCodEvent")) {
			if (   e.getFormCommand().isCommand(FormCommand.SEARCHLIST01 )
					|| e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
					eventResponse = searchCommonCodeList(e);
			}
		}
		return eventResponse; 
	}



	/**
	 * Common의 event<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCommonCodeList(Event e) throws EventException {
		// DB Result Set
		EventResponse eventResponse = null;

		try {
			CommonBC command = new CommonBCImpl();
			eventResponse = command.searchCommonCodeList(e);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * LOC YARD initial<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	*/ 
	private EventResponse searchLocYardInitialInfo(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse(); 
		EesCommonEvent event = (EesCommonEvent)e; // PDTO(Data Transfer Object including VO Parameters)
		EesCommonVO retVO = null; 
		try {
			CommonBC command = new CommonBCImpl();
			retVO = command.searchLocYardInitialInfo(event.getEesCommonConditionVO());

			List<CommonVO> list = new  ArrayList<CommonVO>();
			CommonVO commonVO = new CommonVO();
			commonVO.setConditionVo(event.getEesCommonConditionVO());
			commonVO.setResultVo(retVO);
			list.add(commonVO);
			eventResponse.setRsVoList(list);
			return (eventResponse);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	
	/**
	 * retrieving for Trade <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	*/
	private EventResponse searchTradeEqrAccess(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse(); 
		
		CommonBC command = new CommonBCImpl();
		try {
			
			
			List<EqrCommonVO> list =  command.searchTradeList();
			StringBuffer codes = new StringBuffer();
			
			if (list != null && list.size() > 0) {
				//insert blank in the select box
				
				for (int i = 0 ; i < list.size() ; i++) {
					codes.append(list.get(i).getTrdCd());
					if (i < list.size() - 1) codes.append("|");
				}
			}
			eventResponse.setETCData("all_trade_cd", codes.toString());
			
			
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		
		return (eventResponse);
	}	
}