/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : RdEmlInfoSC.java
*@FileTitle : Report Designer Insert
*Open Issues :
*Change history :
*@LastModifyDate : 2013-05-21
*@LastModifier : YongHoo-Kim
*@LastVersion : 1.0
* 2013-05-21 YongHoo-Kim
* 1.0 최초 생성
=========================================================*/
package com.hanjin.syscommon.management.alps;

import java.util.List;

import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.syscommon.management.alps.report.basic.ReportInsertBC;
import com.hanjin.syscommon.management.alps.report.basic.ReportInsertBCImpl;
import com.hanjin.syscommon.management.alps.report.event.RdEmlInfoEvent;
import com.hanjin.syscommon.management.alps.report.vo.ComEmlVO;

/**
 * NIS2010-ReportDesigner Business Logic ServiceCommand
 * - NIS2010-ReportDesigner에 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author YongHoo-Kim
 * @see  ReportInsertBC, ReportInsertBCImpl  참조
 * @since J2SE 6.0
 */
public class RdEmlInfoSC extends ServiceCommandSupport {

	/**
	 * E-mail RD 조회에 대한 업무 처리
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	@Override
	public EventResponse perform(Event e) throws EventException {
		RdEmlInfoEvent event = (RdEmlInfoEvent) e;
		ComEmlVO emlVO = event.getComEmlVO();
		ReportInsertBC reportInsertBC = new ReportInsertBCImpl();
		List<ComEmlVO> voList = reportInsertBC.searchRdEmlInfo(emlVO);
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(voList);
		
		return eventResponse;
	}
}
