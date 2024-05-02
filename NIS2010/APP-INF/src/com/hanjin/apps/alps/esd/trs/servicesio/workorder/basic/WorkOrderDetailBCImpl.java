/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : WorkOrderDetailBCImpl.java
*@FileTitle : WO Inquiry
*Open Issues :
*Change history :
* 2007-08-13 Jung-Jae Kim : TRS 요청에 의해 bkg_no, bkg_no_split 추가.
*@LastModifyDate : 2007-08-13
*@LastModifier : Jung-Jae Kim
*@LastVersion : 1.2
* 2006-11-10 doomi
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.workorder.basic;

import com.hanjin.apps.alps.esd.trs.servicesio.common.document.WorkOrderDetailTitle;
import com.hanjin.apps.alps.esd.trs.servicesio.common.document.WorkOrderDetail;
import com.hanjin.apps.alps.esd.trs.servicesio.common.document.WorkOrderDetailList;
import com.hanjin.apps.alps.esd.trs.servicesio.common.document.WorkOrderDetailExcelUploadList;


import com.hanjin.apps.alps.esd.trs.servicesio.workorder.event.ExpPap0002Event;
import com.hanjin.apps.alps.esd.trs.servicesio.workorder.event.ExpPap0002EventResponse;
import com.hanjin.apps.alps.esd.trs.servicesio.workorder.event.ExpPap0007Event;
import com.hanjin.apps.alps.esd.trs.servicesio.workorder.event.ExpPap0007EventResponse;
import com.hanjin.apps.alps.esd.trs.servicesio.workorder.integration.WorkOrderDetailDBDAO;


import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

/**
 * ESD-TRS Business Logic Basic Command implementation<br>
 * - ESD-TRS에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author doomi
 * @see ESD_TRS_019EventResponse,WorkOrderDetailBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class WorkOrderDetailBCImpl   extends BasicCommandSupport implements WorkOrderDetailBC {

	private static final long serialVersionUID = 1L;
	
	// Database Access Object
	private transient WorkOrderDetailDBDAO dbDao=null;

	/**
	 * WorkOrderDetailBCImpl 객체 생성<br>
	 * WorkOrderDetailDBDAO를 생성한다.<br>
	 */
	public WorkOrderDetailBCImpl(){
		dbDao = new WorkOrderDetailDBDAO();
	}


	/**
	 * WorkOrderDetail화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e EXP_PAP_002Event
	 * @return EventResponse EXP_PAP_002EventResponse
	 * @exception EventException
	 */
   
	public EventResponse searchWorkOrderDetailList(Event e) throws EventException {
		
		// PDTO(Data Transfer Object including Parameters)
		ExpPap0002Event event=(ExpPap0002Event)e;
        ExpPap0002EventResponse eventResponse = null;
        
        //데이터 전송을 위해 DB ResultSet을 구현한 객체
		//DBRowSet rowSet=null;
		try {
			Object[] result = dbDao.searchWorkOrderDetailList(event);
            eventResponse = new ExpPap0002EventResponse((WorkOrderDetailList[])result[0],"SUCCESS"); 
            
            Object result2 = dbDao.searchWorkOrderDetail(event);
            WorkOrderDetail workOrderDetail = (WorkOrderDetail)result2;
            if(workOrderDetail == null) {
            	workOrderDetail = new WorkOrderDetail();
            }
            eventResponse.setWorkOrderDetail((WorkOrderDetail)result2); 
          
            Object result3 = dbDao.searchWorkOrderDetailTitle(event);	
            eventResponse.setWorkOrderDetailTitle((WorkOrderDetailTitle)result3);  
           
            
            eventResponse.setTotalCount(((Integer)result[1]).intValue());
           
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
		
		return eventResponse;
		
	}
	
	
	/**
	 * WorkOrderDetail화면에 대한 저장  이벤트 처리<br>
	 * TRS 요청에 의한 파라미터(bkg_no, bkg_no_split) 추가.
	 * @param e Event
	 * @return
	 * @exception EventException
	 */
	public int modifyWorkOrderDetail(Event e) throws EventException {
		
		ExpPap0002Event event=(ExpPap0002Event)e;
		
		int resultCount = 0;

		try {
			log.error("\n ##################### SPP modifyWorkOrderDetail Method Call  Start   ################## ");
				resultCount = dbDao.modifyWorkOrderDetail(event); 
				log.debug("==resultCount = " +resultCount);
				log.error("\n ##################### SPP modifyWorkOrderDetail Method Call  End    ###################");
				
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		 } catch (Exception ee) {
	         log.error(ee.getMessage(), ee);
	         throw new EventException(ee.getMessage());
		 }
	 
		return resultCount;
	}


	
	

	/**
	 * WorkOrderDetail화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e EXP_PAP_001Event
	 * @return response EXP_PAP_001EventResponse
	 * @exception EventException
	 */
	
	public EventResponse searchDetailExcelPrint(Event e) throws EventException { 
		
		// PDTO(Data Transfer Object including Parameters)
		ExpPap0002Event event=(ExpPap0002Event)e;
        ExpPap0002EventResponse eventResponse = null;


		try {
			Object[] result = dbDao.searchDetailExcelPrint(event);
            eventResponse = new ExpPap0002EventResponse((WorkOrderDetailList[])result[0],"SUCCESS"); 
            eventResponse.setTotalCount(((Integer)result[1]).intValue());
            
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
		
		return eventResponse;
		
		
	}		
	

	/**
	 * WorkOrderDetail화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ExpPap0007Event
	 * @return response ExpPap0007EventResponse
	 * @exception EventException
	 */
	
	public EventResponse searchDetailExcelUpload(Event e) throws EventException { 
		
		ExpPap0007Event event=(ExpPap0007Event)e;
        ExpPap0007EventResponse eventResponse = null;

		try {
			Object[] result = dbDao.searchDetailExcelUpload(event);
            eventResponse = new ExpPap0007EventResponse((WorkOrderDetailExcelUploadList[])result[0],"SUCCESS"); 
            eventResponse.setTotalCount(((Integer)result[1]).intValue());
            
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
		
		return eventResponse;
		
		
	}		

	
	
	/**
	 * TRS 업무 시나리오 마감작업<br>
	 * WorkOrderDetail업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		dbDao = null;
	}
}