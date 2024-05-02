/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ReportPreInsertSC.java
*@FileTitle : Report Designer Insert
*Open Issues :
*Change history :
*@LastModifyDate : 2013-05-03
*@LastModifier : YongHoo-Kim
*@LastVersion : 1.0
* 2013-05-03 YongHoo-Kim
* 1.0 최초 생성
=========================================================*/
package com.hanjin.syscommon.management.alps;

import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;

/**
 * NIS2010-ReportDesigner Business Logic ServiceCommand
 * - NIS2010-ReportDesigner에 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author YongHoo-Kim
 * @see  ReportInsertBC, ReportInsertBCImpl  참조
 * @since J2SE 6.0
 */
public class ReportPreInsertSC extends ServiceCommandSupport {

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * NIS2010-ReportDesigner system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	@Override
	public EventResponse perform(Event e) throws EventException {		
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
		return eventResponse;
	}
}