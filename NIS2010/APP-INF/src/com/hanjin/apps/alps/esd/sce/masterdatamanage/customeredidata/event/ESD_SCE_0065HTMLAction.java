/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_SCE_0065HTMLAction.java
*@FileTitle : EsdSce0065
*Open Issues :
*Change history :
*@LastModifyDate : 2009-11-18
*@LastModifier : 전병석
*@LastVersion : 1.0
* 2006-09-20 yongcheon_shin
* 1.0 최초 생성
* 2009-11-18 전병석
* 1.4 버전 커밋
=========================================================*/
package com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.event;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo.UpdateCargoTrackingDataVO;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 UserManagerSC로 실행요청<br>
 * - UserManagerSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author yong_cheon_shin
 * @see ReserveSendManagerEvent , PNSendManagerEventResponse 참조
 * @since J2EE 1.4
 */
public class ESD_SCE_0065HTMLAction  extends HTMLActionSupport{
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 105936528227199170L;

	/** Constructor
     * 
     */
    public ESD_SCE_0065HTMLAction(){
        
    }
    
    /**
     * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
     * HttpRequst의 정보를 IbatchVisibilityEvent로 파싱하여 request에 셋팅<br>
     * 
     * @param HttpServletRequest request
     * @return Event
     * @exception HTMLActionException
     */
    public Event perform(HttpServletRequest request) throws HTMLActionException {
	log.debug("Event 0065  spawn");
	FormCommand command = FormCommand.fromRequest(request);
	EsdSce0065Event event = new EsdSce0065Event();
	
   if (command.isCommand(FormCommand.SEARCH01)) {
         log.debug("0065 program ");
         
         int vo_size = 0;
         List<UpdateCargoTrackingDataVO> updateCargoTrackingDataVOs =new ArrayList<UpdateCargoTrackingDataVO>();
         UpdateCargoTrackingDataVO[] uCTDVOs = null;
         StringTokenizer st = null;
         ArrayList<String> bkg_nos  = new ArrayList<String>();
         ArrayList<String> cntr_nos = new ArrayList<String>();
         HashMap<String, String> map = getParameterArray(request);
         String bkg_no   = (String)map.get("bkg_no" );
         String cntr_no  = (String)map.get("cntr_no");
         String edi_sts  = (String)map.get("edi_sts");
         String cust_sts = (String)map.get("cust_sts");
         String nod      = (String)map.get("nod"    );
         String event_dt = (String)map.get("act_dt");
                event_dt = removeSymbolInString(event_dt,new String[]{"-",":"," ",".","/"});
         
         log.debug("0065 program - bkg_no :" + bkg_no);
         	/*다중처리*/
                st = new StringTokenizer(bkg_no,"|");
             while (st.hasMoreTokens()) {
             	bkg_nos.add(st.nextToken());
             }//while
                st = new StringTokenizer(cntr_no,"|");
             while (st.hasMoreTokens()) {
             	cntr_nos.add(st.nextToken());
             }
             if(bkg_nos != null && bkg_nos.size() >0 ){
            	    vo_size = bkg_nos.size();
            	    uCTDVOs = new UpdateCargoTrackingDataVO[vo_size];
             }//if
             for(int i = 0 ; i < vo_size ; i++){
            	 uCTDVOs[i] = new UpdateCargoTrackingDataVO();           	 
            	 uCTDVOs[i].setBkgNo(bkg_nos.get(i));
            	 uCTDVOs[i].setCntrNo(cntr_nos.get(i));
            	 uCTDVOs[i].setEdiSts(edi_sts);
            	 uCTDVOs[i].setCustSts(cust_sts);
            	 uCTDVOs[i].setNod(nod);
            	 uCTDVOs[i].setEventDt(event_dt);            	
            	 updateCargoTrackingDataVOs.add(uCTDVOs[i]);
             }//for
             event.setUCTDVOs(updateCargoTrackingDataVOs);
    }//if  
	return  event;
}
    
   /** request 내의 parameter의 값을 HashMap으로 반환한다.
    * @param HttpServletRequest request
    * @return HashMap
    */
   public HashMap<String, String> getParameterArray(HttpServletRequest request){
       String keyName = "";
       String keyValue = "";
       HashMap<String, String> hMap = new HashMap<String, String>();
       
       for (Enumeration en = request.getParameterNames(); en.hasMoreElements(); ){
           try{
           keyName = (String)en.nextElement();
           keyValue = JSPUtil.getParameter(request, keyName.trim(), "");
           }catch(Exception ex){
           	log.error("err " + ex.toString(), ex);
               keyValue = "";
           }
           hMap.put(keyName, keyValue);
       }
       return hMap;
   }  
   
	/** 
	 * request 내의 parameter의 값을 HashMap으로 반환한다.
	 * 
	 * @param HttpServletRequest request
	 * @param EventResponse eventResponse
	 */
	public void doEnd(HttpServletRequest request, EventResponse eventResponse) {
	    request.setAttribute("EventResponse", eventResponse);
	}
	
	/** 
	 * HttpRequest의 attribute에 HttpRequest 파싱 수행결과 값 저장<br>
	 * HttpRequest 파싱 수행결과 값 request에 셋팅<br>
	 * 
	 * @param HttpServletRequest request
	 * @param Event event
	 */
	public void doEnd(HttpServletRequest request, Event event) {
	    request.setAttribute("Event", event);
	}
	
	/** 
	 * 문자열에 해당 심볼을 찾아 제거 하는 함수
	 * 
	 * @param String org
	 * @param String[] sym
	 * @return String
	 * @throws 
	 */
	public String removeSymbolInString(String org,String[] sym){
		  if(org != null && sym != null){
			  for(int i=0;i<sym.length;i++){
				  String o = sym[i];
				  log.debug("Org -" + org);
				  log.debug("SYM -" + o);
				  org = org.replace(o, "");
			  }//for
		  }//if		  
		  return org;
	}
}
