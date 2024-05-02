/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EXP_PAP_001RSC.java
*@FileTitle : 
*Open Issues :
*Change history :
* 2007-08-03 Jung-Jae Kim : 프레임워크 표준에 따른 패키지 수정
* 2007-08-13 Jung-Jae Kim : TRS 요청에 의해 bkg_no, bkg_no_split 추가.
*@LastModifyDate : 2007-08-13
*@LastModifier : Jung-Jae Kim
*@LastVersion : 1.2
* 2006-10-18 doomi
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.workorder;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.HashMap;

import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
//import com.hanjin.framework.core.layer.integration.DAOException;

import com.hanjin.apps.alps.esd.trs.servicesio.common.document.WorkOrderDetailSubmitRejectList;
import com.hanjin.apps.alps.esd.trs.servicesio.workorder.basic.WorkOrderDetailBC;
import com.hanjin.apps.alps.esd.trs.servicesio.workorder.basic.WorkOrderDetailBCImpl;
import com.hanjin.apps.alps.esd.trs.servicesio.workorder.event.ExpPap0002Event;
import com.hanjin.apps.alps.esd.trs.servicesio.workorder.event.ExpPap0002EventResponse;
import com.hanjin.apps.alps.esd.trs.servicesio.workorder.event.ExpPap0007Event;

/**
 * ESD-TRS Business Logic ServiceCommand<br>
 * - ESD-TRS에 대한 비지니스 트랜잭션을 처리한다.<br>
 * 
 * @author doomi
 * @see EXP_PAP_001EventResponse,PendingListDBDAO 참조
 * @since J2EE 1.4
 */
public class WorkOrderDetailRSC extends ServiceCommandSupport {
	
	
	// serial UID
	private static final long serialVersionUID = 1L;
	
    // Login User Information
    private SignOnUserAccount account = null;

    

    /**
     * TRS 업무 시나리오 선행작업<br>
     * WorkOrder업무 시나리오 호출시 관련 내부객체 생성<br>
     */
    public void doStart() {
        try {
            // 일단 comment --> 로그인 체크 부분
            account=getSignOnUserAccount();
        } catch (Exception e) {
            log.error("WorkOrderDetailRSC 선행 작업 시 오류 " + e.toString(), e);
        }
    }

    /**
     * TRS 업무 시나리오 마감작업<br>
     * WorkOrder업무 시나리오 종료시 관련 내부객체 해제<br>
     */
    public void doEnd() {
        // command.doEnd();
        log.debug("WorkOrderDetailRSC 종료");
    }    
    
	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ESD-TRS 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException { 
		
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;
		
		//log.debug("event : " + e);
	
		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("ExpPap0002Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchWorkOrderDetailList(e);		
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) {
				eventResponse = modifyWorkOrderDetail(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchDetailExcelPrint(e);
			} 
		
		}
		
		if (e.getEventName().equalsIgnoreCase("ExpPap0007Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDetailExcelUpload(e);
			}
		
		}
		
		
		return eventResponse;

	}


	
	/**
	 * 조회 이벤트 처리<br>
	 * searchWorkOrderDetailList의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	 
	private EventResponse searchWorkOrderDetailList(Event e) throws EventException {
		
		 // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
        EventResponse eventResponse = null;
        // PDTO(Data Transfer Object including Parameters)
		ExpPap0002Event event = (ExpPap0002Event)e;
	 
		try {
			WorkOrderDetailBC command = new WorkOrderDetailBCImpl();	
			eventResponse = command.searchWorkOrderDetailList(event); 
			
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception ee) {
			rollback();
	        log.error(ee.getMessage(), ee);
	        throw new EventException(ee.getMessage());
		 }
		return eventResponse;
	}
	




	/**
	 * 수정 이벤트 처리<br>
	 * WorkOrderDetailRSC의  event에 대한 수정 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	    
	private EventResponse modifyWorkOrderDetail(Event e) throws EventException {
		
		ExpPap0002EventResponse eventResponse1 = null;
		ExpPap0002Event event = (ExpPap0002Event)e;
		int resultCount = 0;
		
		//EdiSendEventResponse eventResponse = null;
		//WorkOrderDetailSubmitRejectList[]  workorderdetaildata = null;
		
		try {
			
			
			begin();
			
	        log.info("####  modify Date : 2007-09-27    " );
	         
	        log.info("####  event.getSubmitMode() = " + event.getSubmitMode());
		  //  log.error("####  workorderdetaildata.length = " + workorderdetaildata.length);
	        log.info("####  event.getUserID() = " + event.getUserID());
	        log.info("####  event.getVendorCode() = " + event.getVendorCode());
	        log.info("####  event.getWorkOrderNo() = " + event.getWorkOrderNo());
		
			log.info("==========================>> SubmitMode =  "+event.getSubmitMode());
    		if(event.getUserID() == null || event.getUserID().equals("")) {
    			throw new Exception("Please enter UserID.");
    		}
    		if(event.getVendorCode() == null || event.getVendorCode().equals("")) {
    			throw new Exception("Please enter VendorCode.");
    		}
    		if(event.getSubmitMode() == null || event.getSubmitMode().equals("")) {
    			throw new Exception("Please enter SubmitMode.");
    		}
    		if(event.getWorkOrderNo() == null || event.getWorkOrderNo().equals("")) {
    			throw new Exception("Please enter WorkOrderNumber.");
    		}
			
			if (event.getSubmitMode().equals("S")) {
				WorkOrderDetailBCImpl command = new WorkOrderDetailBCImpl();
				resultCount = command.modifyWorkOrderDetail(event);
			}
			/*
			else if (event.getSubmitMode().equals("R")) {
				WORejectManageBCImpl command = new WORejectManageBCImpl();
				resultCount =  command.multiWorkOrderManage(event);
				
			}*/
			
			eventResponse1 = new ExpPap0002EventResponse();
        	eventResponse1.setCount(resultCount); 
			
        	commit();
			
		
        	
			
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception ee) {
			rollback();
	        log.error(ee.getMessage(), ee);
	        throw new EventException(ee.getMessage());
		 }
		return eventResponse1; //this.searchRailSoManage(e);
	}
	 

	
	
	
	/**
	 * searchDetailExcelPrint 이벤트 처리<br>
	 * WorkOrderDetail 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDetailExcelPrint(Event e) throws EventException {

	    // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
        EventResponse eventResponse = null;
        ExpPap0002Event event = (ExpPap0002Event)e;
			 
		try { 
			WorkOrderDetailBC command = new WorkOrderDetailBCImpl();
			eventResponse = command.searchDetailExcelPrint(event); 
			
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception ee) {
			rollback();
	        log.error(ee.getMessage(), ee);
	        throw new EventException(ee.getMessage());
		 }
		return eventResponse;
	}	
	

	
	/**
	 * searchDetailExcelUpload 이벤트 처리<br>
	 * WorkOrderDetail 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDetailExcelUpload(Event e) throws EventException {
		
		
	    // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
        EventResponse eventResponse = null;
        ExpPap0007Event event = (ExpPap0007Event)e;
			 
		try { 
			WorkOrderDetailBC command = new WorkOrderDetailBCImpl();
			eventResponse = command.searchDetailExcelUpload(event); 
			
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception ee) {
			rollback();
	        log.error(ee.getMessage(), ee);
	        throw new EventException(ee.getMessage());
		 }
		return eventResponse;
	}	
		

}
