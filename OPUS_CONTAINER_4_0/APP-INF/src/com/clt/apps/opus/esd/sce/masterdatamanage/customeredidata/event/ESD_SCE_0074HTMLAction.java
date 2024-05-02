/*=========================================================
*Copyright(c) 2008 CyberLogitec
*@FileName : ESD_SCE_0074HTMLAction.java
*@FileTitle : EsdSce0074
*Open Issues :
*Change history :
*@LastModifyDate : 2008-06-10
*@LastModifier : sanghyun_kim
*@LastVersion : 1.0
* 2008-06-10 sanghyun_kim
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.vo.SearchMissingListVO;
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
 * @author yong_cheon_shin
 * @see ReserveSendManagerEvent , PNSendManagerEventResponse 참조
 * @since J2EE 1.4
 */
public class ESD_SCE_0074HTMLAction extends HTMLActionSupport{

	private static final long serialVersionUID = 1L;
	
	public ESD_SCE_0074HTMLAction(){}
	
	/**
     * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
     * HttpRequst의 정보를 IbatchVisibilityEvent로 파싱하여 request에 셋팅<br>
     * 
     * @param request HttpServletRequest HttpRequest
     * @return Event Event interface를 구현한 객체
     * @exception HTMLActionException
     */
	
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		EsdSce0074Event event = new EsdSce0074Event();
        FormCommand f_cmd = FormCommand.fromRequest(request);
        
        if (f_cmd.isCommand(FormCommand.SEARCH01) || f_cmd.isCommand(FormCommand.SEARCH02)){
        	log.debug("\n    SEARCH01 || SEARCH02");
//        	map = getParameterArray(request); 
//            iPage           = JSPUtil.getParameterAsInt(request, "iPage", 1);
//            event = new EsdSce0074Event(map);
//            event.setIPage(iPage);
			event.setSearchMissingList((SearchMissingListVO) getVO(request,SearchMissingListVO.class));        	
        }
        
        if (f_cmd.isCommand(FormCommand.MULTI01)){
        	log.debug("\n   MULTI01");        	
//        	map = getParameterArray(request); 
//            models = getParametersArray(request);
////            iPage           = JSPUtil.getParameterAsInt(request, "iPage", 1);
//            event = new EsdSce0074Event(map, models);
			event.setSearchMissingList((SearchMissingListVO) getVO(request,SearchMissingListVO.class));        	
			event.setSelectedMissingList((SearchMissingListVO[])getVOs(request, SearchMissingListVO .class,""));  
			String [] ibflag = request.getParameterValues("ibflag");
			
			log.debug("\n selectedMissingList:"+event.getSelectedMissingList()+"  ibflag:"+ibflag);
        }
        //request.setAttribute("Event", event);
        return event;
	}
	
	/** request 내의 parameter의 값을 HashMap으로 반환한다.
     * @param request
     * @return hMap
     */
//    public HashMap getParameterArray(HttpServletRequest request){
//        String keyName = "";
//        String keyValue = "";
//        HashMap hMap = new HashMap();
//        
//        for (Enumeration en = request.getParameterNames(); en.hasMoreElements(); ){
//            try{
//	            keyName = (String)en.nextElement();
//	            keyValue = JSPUtil.getParameter(request, keyName.trim(), "");
//            }catch(Exception ex){
//            	log.error("err " + ex.toString(), ex);
//                keyValue = "";
//            }
//            hMap.put(keyName, keyValue);
//        }
//        return hMap;
//    }
    
    /** HTMLAction 변수를 parsing하여 Collection에 담는다.
     * @param request
     * @return
     */
//    public Collection getParametersArray(HttpServletRequest request){
//        HashMap map = new HashMap();
//        Collection models = new ArrayList();
////        FormCommand f_cmd = FormCommand.fromRequest(request);
//        int length = request.getParameterValues("ibflg").length;
//
//        try {
//            String[] bkg_nos        =  (JSPUtil.getParameter(request, "bkg_nos".trim(),         length));
//            //String[] bkg_no_splits  =  (JSPUtil.getParameter(request, "bkg_no_splits".trim(),   length));
//            String[] cntr_nos       =  (JSPUtil.getParameter(request, "cntr_nos".trim(),        length));
//            String[] nod_cds        =  (JSPUtil.getParameter(request, "nod_cds".trim(),        length));
//            String[] act_stnd_sts   =  (JSPUtil.getParameter(request, "act_stnd_st".trim(),        length));
//            
//            String[] ibflgs          =  (JSPUtil.getParameter(request, "ibflg".trim(),           length));
//            String[] flags          =  (JSPUtil.getParameter(request, "flag".trim(),           length));
//            
//            
//            String[] actual_dt1     =  (JSPUtil.getParameter(request, "actual_dt1".trim(),      length));
//            String[] actual_dt2     =  (JSPUtil.getParameter(request, "actual_dt2".trim(),      length));
//
//            //20071116 cust_st추가
//            String[] cust_st        =  (JSPUtil.getParameter(request, "cust_st".trim(),        length));
//            
//            for (int i = 0; i < length; i++) {
//            	if(flags[i].equals("1")){
//	                map = new HashMap();
//	                
//	                map.put("bkg_no",          bkg_nos[i]);
//	                //map.put("bkg_no_split",    bkg_no_splits[i]);
//	                map.put("cntr_no",         cntr_nos[i]);
//	                map.put("ibflgs",            ibflgs[i]);
//	                map.put("flags",            flags[i]);
//	                map.put("act_dt_days",   actual_dt1[i]);
//	                map.put("act_dt_hours",   actual_dt2[i]);
//	                map.put("nod",   nod_cds[i]);
//	                map.put("edi_sts",   act_stnd_sts[i]);
//	                
//	                map.put("cust_st",   cust_st[i]);
//
//	                models.add(map);
//            	}
//            }
//        } catch (Exception ex) {
//        	log.error("err " + ex.toString(), ex);
//        }
//        return models;
//    }
    
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