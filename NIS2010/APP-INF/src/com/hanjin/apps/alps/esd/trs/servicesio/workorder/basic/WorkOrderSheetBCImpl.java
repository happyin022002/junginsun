/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : WorkOrderSheetBCImpl.java
*@FileTitle : WO Sheet Inquiry
*Open Issues :
*Change history :
* 2007-08-03 Jung-Jae Kim : 프레임워크 표준에 따른 패키지 수정
*@LastModifyDate : 2007-08-03
*@LastModifier : Jung-Jae Kim
*@LastVersion : 1.1
* 2006-11-10 doomi
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.workorder.basic;

import com.hanjin.apps.alps.esd.trs.servicesio.common.document.WorkOrderSheetFormatType;
import com.hanjin.apps.alps.esd.trs.servicesio.common.document.WorkOrderSheet;
import com.hanjin.apps.alps.esd.trs.servicesio.common.document.WorkOrderSheetTotalQuantity;
import com.hanjin.apps.alps.esd.trs.servicesio.common.document.WorkOrderSheetList;
import com.hanjin.apps.alps.esd.trs.servicesio.common.document.WorkOrderSheetCargoAwkward;
import com.hanjin.apps.alps.esd.trs.servicesio.common.document.WorkOrderSheetCargoReefer;
import com.hanjin.apps.alps.esd.trs.servicesio.common.document.WorkOrderSheetCargoDg;
import com.hanjin.apps.alps.esd.trs.servicesio.common.document.WorkOrderSheetSecondList;

import com.hanjin.apps.alps.esd.trs.servicesio.workorder.event.ExpPap0006Event;
import com.hanjin.apps.alps.esd.trs.servicesio.workorder.event.ExpPap0006EventResponse;
import com.hanjin.apps.alps.esd.trs.servicesio.workorder.integration.WorkOrderSheetDBDAO;

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
 * @see ESD_TRS_006EventResponse,WorkOrderSheetBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class WorkOrderSheetBCImpl   extends BasicCommandSupport implements WorkOrderSheetBC {

	private static final long serialVersionUID = 1L;
	
	// Database Access Object
	private transient WorkOrderSheetDBDAO dbDao=null;

	/**
	 * WorkOrderSheetBCImpl 객체 생성<br>
	 * WorkOrderSheetDBDAO를 생성한다.<br>
	 */
	public WorkOrderSheetBCImpl(){
		dbDao = new WorkOrderSheetDBDAO();
	}


	/**
	 * WorkOrderSheet화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ExpPap0006Event
	 * @return EventResponse ExpPap0006EventResponse
	 * @exception EventException
	 */
   
	public EventResponse searchWorkOrderSheet(Event e) throws EventException {
		
		ExpPap0006Event event=(ExpPap0006Event)e;
        ExpPap0006EventResponse eventResponse = null;
        Object[] result2 = new Object[2];
        Object[] result8 = new Object[2];
        	try {
			
			Object result = dbDao.searchWorkOrderSheet(event);
			eventResponse = new ExpPap0006EventResponse((WorkOrderSheet)result,"SUCCESS"); 

			
            Object result1 = dbDao.searchWorkOrderSheetTotalQuantity(event);	
            eventResponse.setWorkOrderSheetTotalQuantity((WorkOrderSheetTotalQuantity)result1); 
			
            
            Object[] result3 = dbDao.searchSpecialCargoSummaryAwkward(event);	
            eventResponse.setWorkOrderSheetCargoAwkward((WorkOrderSheetCargoAwkward[])result3[0]); 
                      
            Object[] result4 = dbDao.searchSpecialCargoSummaryReefer(event);	
            eventResponse.setWorkOrderSheetCargoReefer((WorkOrderSheetCargoReefer[])result4[0]); 
            
            Object[] result5 = dbDao.searchSpecialCargoSummaryDG(event);	
            eventResponse.setWorkOrderSheetCargoDg((WorkOrderSheetCargoDg[])result5[0]); 

            Object result6 = dbDao.searchWorkOrderSheetFormatType(event);	
            eventResponse.setWorkOrderSheetFormatType((WorkOrderSheetFormatType)result6); 
            
            Object[] result7 = dbDao.searchWorkOrderSheetSecondList(event);	
            eventResponse.setWorkOrderSheetSecondList((WorkOrderSheetSecondList[])result7[0]); 
            
            
            
			String formatTypeCd = eventResponse.getWorkOrderSheetFormatType().getWorkOrderFormatTypeCd();
			if(log.isDebugEnabled())log.debug("getWorkOrderSheetFormatType =>  "+formatTypeCd);
			
			
	        if(formatTypeCd.equals("IB")||  //Combined Case 2-1(I/B Door + O/B Door)
	            formatTypeCd.equals("CY")|| //Combined Case 2-2 (CY+CY)
	            formatTypeCd.equals("CM")) //Combined Case 2-3 (CY+MT)
	       {
	            result2 = dbDao.searchWorkOrderSheetList(event, "-1");	
	            eventResponse.setWorkOrderSheetList((WorkOrderSheetList[])result2[0]); 
	  	        result8 = dbDao.searchWorkOrderSheetList(event, "-2");	
	  	        eventResponse.setWorkOrderSheetList2((WorkOrderSheetList[])result8[0]); 
	       }else{
	    	   /* PDF내용중 MM(Empty)일경우 pikup no 번호 조회 안함 최초 시간 업데이터 안됨 2008.08.21
	    	    * 수정시 WorkOrderSheetDBDAO 수정필수 
	    	    */ 
	    	   if (formatTypeCd.equals("MM")){
	    		   result2 = dbDao.searchWorkOrderSheetList(event,"MM");
	    	   } else {
	    		   result2 = dbDao.searchWorkOrderSheetList(event,"");
	    	   }
	           eventResponse.setWorkOrderSheetList((WorkOrderSheetList[])result2[0]); 
	       }
	       
            eventResponse.setTotalCount(((Integer)result2[1]).intValue());
         
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
		
		return eventResponse;
		
	}
	

	
	/**
	 * TRS 업무 시나리오 마감작업<br>
	 * WorkOrderSheet업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		dbDao = null;
	}
}