/*=========================================================
*Copyright(c) 2008 CyberLogitec
*@FileName : ESD_SCE_0061HTMLAction.java
*@FileTitle : Cargo Tracking EDI Save/Send _ individual  팝업화면
*Open Issues :
*Change history :
*@LastModifyDate : 2009-11-06
*@LastModifier : 전병석
*@LastVersion : 1.6
* 2006-05-10 sanghyun-kim
* 1.0 최초 생성
* 2009-11-06 전병석
* 1.6 버전 커밋
=========================================================*/
package com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.event;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.vo.SearchCargoTrackingDataOptionsVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.vo.UpdateCargoTrackingDataVO;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.clt.apps 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 UserManagerSC로 실행요청<br>
 * - UserManagerSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author sang_hyun_kim
 * @see ReserveSendManagerEvent , PNSendManagerEventResponse 참조
 * @since J2EE 1.4
 */
public class ESD_SCE_0061HTMLAction  extends HTMLActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7008266167301928281L;
	/** Constructor
     * 
     */
	public ESD_SCE_0061HTMLAction(){}
	
	/**
     * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
     * HttpRequst의 정보를 IbatchVisibilityEvent로 파싱하여 request에 셋팅<br>
     * 
     * @param request HttpServletRequest HttpRequest
     * @return Event Event interface를 구현한 객체
     * @exception HTMLActionException
     */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		log.debug("Event 0061  spawn");
    	FormCommand command = FormCommand.fromRequest(request);
		EsdSce0061Event event = new EsdSce0061Event();
		
       if (command.isCommand(FormCommand.SEARCH01)) {
    	   event.setSchCtdOpts((SearchCargoTrackingDataOptionsVO) getVO(request,SearchCargoTrackingDataOptionsVO.class));
       }else if (command.isCommand(FormCommand.MULTI01) || command.isCommand(FormCommand.MULTI02)){
    	   //FOR SEARCHING DATA VO
    	   event.setSchCtdOpts((SearchCargoTrackingDataOptionsVO) getVO(request,SearchCargoTrackingDataOptionsVO.class));
    	   //FOR UPDATING OR SENDING VO
    	   List<UpdateCargoTrackingDataVO> updateCargoTrackingDataVOs = new ArrayList<UpdateCargoTrackingDataVO>();
    	   /*
    	    * There is the situation which IBSheet is able to send data on HTML Page 
    	    * with a type of array, therefore program should be compatible with this situation.   
    	    * */
    	   int length = request.getParameterValues("ibflg").length;
    	   String[] ibflgs  =  (JSPUtil.getParameter(request, "ibflg".trim(),           length));
    	   UpdateCargoTrackingDataVO[] uCTDVOs = new UpdateCargoTrackingDataVO[length];
    	   
    	   //data Arrays for raw data object of request  
    	   String[] act_dt_days  = (JSPUtil.getParameter(request, "act_dt_day".trim(),    length));
    	   String[] act_dt_hours = (JSPUtil.getParameter(request, "act_dt_hour".trim(),   length));
    	   String[] cust_stss    = (JSPUtil.getParameter(request, "cust_sts".trim(),   length));
    	   String[] nods         = (JSPUtil.getParameter(request, "nod".trim(),   length));
    	   log.debug("Event 0061 -The length of VOs is " + uCTDVOs.length);
    	   log.debug("Event 0061 - Updating or Sending Modul, VOs set manually.");
    	   /*for searching for the parameter which says "can be saved" */
    	   for(int i=0;i<length;i++){
    		   //if("I".equals(ibflgs[i])){
    		       uCTDVOs[i] = new UpdateCargoTrackingDataVO();
    			   String event_dt = act_dt_days[i] +  act_dt_hours[i];   	    	   
    			   log.debug("param[" + i + "][ibflg]" + ibflgs[i]);
    			   log.debug("param[" + i + "][dist]" + JSPUtil.getParameter(request, "dist", ""));
    	    	   log.debug("param[" + i + "][bkg_no]" + JSPUtil.getParameter(request, "bkg_no", ""));
    	    	   log.debug("param[" + i + "][bkg_no_split]" + JSPUtil.getParameter(request, "bkg_no_split", ""));
    	    	   log.debug("param[" + i + "][cntr_no]" + JSPUtil.getParameter(request, "cntr_no", ""));
    	    	   log.debug("param[" + i + "][edi_sts]" + JSPUtil.getParameter(request, "edi_sts", ""));
    	    	   log.debug("param[" + i + "][nod]" + nods[i]);
    	    	   log.debug("param[" + i + "][act_dt_day]"  + act_dt_days[i]);
    	    	   log.debug("param[" + i + "][act_dt_hour]" + act_dt_hours[i]);
    	    	   log.debug("param[" + i + "][cust_sts]" + cust_stss[i]);
    	    	   log.debug("param[" + i + "][usr_id]" + JSPUtil.getParameter(request, "upd_by", ""));
    			   log.debug("event_dt[" + i + "] :" + event_dt);
   
		    	   uCTDVOs[i].setIbflg(ibflgs[i]);
		    	   uCTDVOs[i].setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		    	   uCTDVOs[i].setBkgNoSplit(JSPUtil.getParameter(request, "bkg_no_split", ""));
		    	   uCTDVOs[i].setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		    	   uCTDVOs[i].setEdiSts(JSPUtil.getParameter(request, "edi_sts", ""));
		    	   uCTDVOs[i].setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		    	   uCTDVOs[i].setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		    	   uCTDVOs[i].setNod(nods[i]);
		    	   uCTDVOs[i].setEventDt(event_dt);
		    	   uCTDVOs[i].setCustSts(cust_stss[i]);
		    	   updateCargoTrackingDataVOs.add(uCTDVOs[i]);
    		    //}  
           }//for
    	   event.setUCTDVOs(updateCargoTrackingDataVOs);
       }  

		return  event;
    }
    /**
     * HttpRequest의 attribute에 업무시나리오 수행결과 값 저장<br>
     * ServiceCommand에서 View(JSP)로 실행결과를 전송하는 ResultSet을 request에 셋팅<br>
     * 
     * @param request HttpServletRequest HttpRequest
     * @param eventResponse EventResponse interface를 구현한 객체
     */
    public void doEnd(HttpServletRequest request, EventResponse eventResponse) {
        request.setAttribute("EventResponse", eventResponse);
    }
    /** HttpRequest의 attribute에 HttpRequest 파싱 수행결과 값 저장<br>
     * HttpRequest 파싱 수행결과 값 request에 셋팅<br>
     * 
     * @param request HttpServletRequest HttpRequest
     * @param event Event interface를 구현한 객체
     */
    public void doEnd(HttpServletRequest request, Event event) {
        request.setAttribute("Event", event);
    }
}


