/*=========================================================
*Copyright(c) 2007 CyberLogitec
*@FileName : AGTBatchBCImpl.java
*@FileTitle :Closing Basic Command Implement
*Open Issues :
*Change history :
*@LastModifyDate : 2007-01-31
*@LastModifier : Hwang GyeongNam
*@LastVersion : 1.0
* 2007-01-31 Hwang GyeongNam
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esm.agt.agtbatch.agtbatch.basic;

import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.apps.alps.esm.agt.agtbatch.agtbatch.integration.AGTBatchDBDAO;
import com.hanjin.apps.alps.esm.agt.agtclosing.agtclosing.event.EsmAgt0019Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;


/**
 * eNIS-agt Business Logic Basic Command implementation<br>
 * - eNIS-agt에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author Hwang GyeongNam
 * @see ESM_AGT_BatchEventResponse,AGTBatchBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class AGTBatchBCImpl extends BasicCommandSupport implements AGTBatchBC {

	// Database Access Object
	private transient AGTBatchDBDAO dbDao=null;

	/**
	 * AGTBatchBCImpl 객체 생성<br>
	 * AGTBatchDBDAO를 생성한다.<br>
	 */
	public AGTBatchBCImpl(){
		dbDao = new AGTBatchDBDAO();
	}

	/**
	 * Agent Commission 추정 결산 처리<br>
	 * 
	 * @param Event ev
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse processAGTBatchBC( Event ev ) throws EventException{

		//EsmAgt0019Event event = (EsmAgt0019Event)ev;
		
		String ex_yrmon = "";
		
		try {

			//ex_yrmon = event.getString("selSubYearMm")==null?"":event.getString("selSubYearMm");

			log.debug("\n ex_yrmon:: "+ex_yrmon);
			
			dbDao.createTargetAGTComm(ex_yrmon);
//			dbDao.createTargetBRKGComm(ex_yrmon);
//			dbDao.createTargetFACComm(ex_yrmon);
			
			return null;
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * agt 업무 시나리오 마감작업<br>
	 * AGTClosing업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		dbDao = null;
	}
	
}