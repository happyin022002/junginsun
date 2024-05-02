/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_VSK_0010HTMLAction.java
*@FileTitle : Long Range SKD Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.14
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2009.04.21 유혁
* 1.0 Creation
* 
* History
* 2012.05.14 진마리아 CHM-201217742-01 PF 사용하여 SKD 생성시 DELETE YARD 제어 로직 추가
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.event;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.PfSkdVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.ActivationVvdVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.LongRangeSkdGRPVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.common.table.VskVslSkdHisVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.nis2010.vop.vsk.scheduleplanningoperation 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 SchedulePlanningOperationSC로 실행요청<br>
 * - SchedulePlanningOperationSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Ryu Hyuk
 * @see SchedulePlanningOperationEvent 참조
 * @since J2EE 1.4
 */

public class VOP_VSK_0010HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * UI_VSK_0010HTMLAction 객체를 생성
	 */
	public VOP_VSK_0010HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 SchedulePlanningOperationEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		VopVsk0010Event event = new VopVsk0010Event();
		
		if(command.isCommand(FormCommand.SEARCH)) {		// searchPfSkd 의 경우
			event.setPfSkdVO((PfSkdVO)getVO(request, PfSkdVO.class));
		}		
		else if(command.isCommand(FormCommand.SEARCH02) || command.isCommand(FormCommand.SEARCH10))		// simulateLongRngSkd
		{
			event = makeEvent(request);
			
			
//			event.setLongRangeSkdGRPVO((LongRangeSkdGRPVO)getVO(request, LongRangeSkdGRPVO.class));
//			
//			LongRangeSkdGRPVO grpvo = event.getLongRangeSkdGRPVO();
//			
//			List<String[]> vslInfo = new ArrayList<String[]>();
//			Map<String, String[]> vslInfoMap = new TreeMap<String, String[]>();
//			
//			for(Enumeration e = request.getParameterNames(); e.hasMoreElements(); ){
//				String name = (String)e.nextElement();
//				if(name.indexOf("Vsl_")>-1){
//					String vslCd = request.getParameterValues(name)[0];
//					if(vslCd!=null && vslCd.length()>0){
//						vslInfoMap.put(name, request.getParameterValues(name));
//					}
//				}
//			}
//			
//			for(Iterator i = vslInfoMap.entrySet().iterator(); i.hasNext(); ){
//				vslInfo.add(((Entry<String, String[]>) i.next()).getValue());
//			}
//			
//			grpvo.setVslInfo(vslInfo);
//			grpvo.setVslInfoMap(vslInfoMap);
			
		}
		else if(command.isCommand(FormCommand.SEARCH03))		// phaseIn
		{
			event = makeEvent(request);
			//-------------------
//			event.setLongRangeSkdGRPVO((LongRangeSkdGRPVO)getVO(request, LongRangeSkdGRPVO.class));
//			
//			LongRangeSkdGRPVO grpvo = event.getLongRangeSkdGRPVO();
//			
//			List<String[]> vslInfo = new ArrayList<String[]>();
//			Map<String, String[]> vslInfoMap = new TreeMap<String, String[]>();
//			
//			for(Enumeration e = request.getParameterNames(); e.hasMoreElements(); ){
//				String name = (String)e.nextElement();
//				if(name.indexOf("Vsl_")>-1){
//					String vslCd = request.getParameterValues(name)[0];
//					if(vslCd!=null && vslCd.length()>0){
//						vslInfoMap.put(name, request.getParameterValues(name));
//					}
//				}
//			}
//			
//			for(Iterator i = vslInfoMap.entrySet().iterator(); i.hasNext(); ){
//				vslInfo.add(((Entry<String, String[]>) i.next()).getValue());
//			}
//			
//			grpvo.setVslInfo(vslInfo);
//			grpvo.setVslInfoMap(vslInfoMap);
//			//-------------------
//			
//			Map<String, String[]> simInfoMap = new TreeMap<String, String[]>();
//			
//			for(Enumeration e = request.getParameterNames(); e.hasMoreElements(); ){
//				String name = (String)e.nextElement();
//				if(name.indexOf("ETB")>-1 || name.indexOf("ETD")>-1){
//					String estimateTime = request.getParameterValues(name)[0];
//					if(estimateTime!=null){
//						simInfoMap.put(name, request.getParameterValues(name));
//					}
//				}
//			}
//			
//			grpvo.setVVD1(request.getParameterValues("VVD1"));
//			grpvo.setVVD2(request.getParameterValues("VVD2"));
//			grpvo.setVVD3(request.getParameterValues("VVD3"));
//			
//			grpvo.setSimInfoMap(simInfoMap);
		}
		else if(command.isCommand(FormCommand.SEARCH04) ||
				command.isCommand(FormCommand.SEARCH05) || 
				command.isCommand(FormCommand.SEARCH06) )		// phasein cancel, add calling, add calling cancel
		{
			event = makeEvent(request);
			
//			event.setLongRangeSkdGRPVO((LongRangeSkdGRPVO)getVO(request, LongRangeSkdGRPVO.class));
//			LongRangeSkdGRPVO grpvo = event.getLongRangeSkdGRPVO();
//			
//			Map<String, String[]> simInfoMap = new TreeMap<String, String[]>();
//			
//			for(Enumeration e = request.getParameterNames(); e.hasMoreElements(); ){
//				String name = (String)e.nextElement();
//				if(name.indexOf("ETB")>-1 || name.indexOf("ETD")>-1){
//					String estimateTime = request.getParameterValues(name)[0];
//					if(estimateTime!=null){
//						simInfoMap.put(name, request.getParameterValues(name));
//					}
//				}
//			}
//			
//			grpvo.setVVD1(request.getParameterValues("VVD1"));
//			grpvo.setVVD2(request.getParameterValues("VVD2"));
//			grpvo.setVVD3(request.getParameterValues("VVD3"));
//			
//			grpvo.setSimInfoMap(simInfoMap);
//			
//			grpvo.setSkdRmk(request.getParameterValues("skd_rmk"));
//			
//			// P/F 정보
//			PfSkdVO[] pfSkdVOs = (PfSkdVO[])getVOs(request, PfSkdVO.class, "sheet3_");
//			grpvo.setPfSkdVOs(pfSkdVOs);
//			
//			
//			event.setPfSkdVOs(pfSkdVOs);
		}
		else if(command.isCommand(FormCommand.MULTI))		// save
		{
			event.setLongRangeSkdGRPVO((LongRangeSkdGRPVO)getVO(request, LongRangeSkdGRPVO.class));
			LongRangeSkdGRPVO grpvo = event.getLongRangeSkdGRPVO();
			
			Map<String, String[]> simInfoMap = new TreeMap<String, String[]>();
			
			for(Enumeration e = request.getParameterNames(); e.hasMoreElements(); ){
				String name = (String)e.nextElement();
				if(name.indexOf("ETB")>-1 || name.indexOf("ETD")>-1){
					String estimateTime = request.getParameterValues(name)[0];
					if(estimateTime!=null){
						simInfoMap.put(name, request.getParameterValues(name));
					}
				}
			}
			
			grpvo.setVVD1(request.getParameterValues("VVD1"));
			grpvo.setVVD2(request.getParameterValues("VVD2"));
			grpvo.setVVD3(request.getParameterValues("VVD3"));
			
			grpvo.setSimInfoMap(simInfoMap);
			
			grpvo.setSkdRmk(request.getParameterValues("skd_rmk"));
			grpvo.setPOutFlag(request.getParameterValues("out"));
			grpvo.setPInFlag(request.getParameterValues("in"));
			
			// P/F 정보
			PfSkdVO[] pfSkdVOs = (PfSkdVO[])getVOs(request, PfSkdVO.class, "sheet3_");
			event.setPfSkdVOs(pfSkdVOs);
			
			// Delete Reason 정보
			VskVslSkdHisVO vskVslSkdHisVO = (VskVslSkdHisVO)getVO(request, VskVslSkdHisVO.class);
			event.setVskVslSkdHisVO(vskVslSkdHisVO);
			
			// Booking이 없는 VVD
			ActivationVvdVO[] nonBkgVVDs = (ActivationVvdVO[])getVOs(request, ActivationVvdVO.class, "non_bkg_");
			// Bokking이 있는 VVD
			ActivationVvdVO[] bkgVVDs = (ActivationVvdVO[])getVOs(request, ActivationVvdVO.class, "bkg_");
			ActivationVvdVO[] virVVDs = (ActivationVvdVO[])getVOs(request, ActivationVvdVO.class, "vir_");
			ActivationVvdVO[] bkgVirVVDs = (ActivationVvdVO[])getVOs(request, ActivationVvdVO.class, "bkg_vir_");
			
			grpvo.setBkgVVDs(bkgVVDs);
			grpvo.setVirVVDs(virVVDs);
			grpvo.setBkgVirVVDs(bkgVirVVDs);
			grpvo.setNonBkgVVDs(nonBkgVVDs);
			
			
		}

		request.setAttribute("Event", event);
		return  event;
		
	}
	
	private VopVsk0010Event makeEvent(HttpServletRequest request){
		
		VopVsk0010Event event = new VopVsk0010Event();
		event.setLongRangeSkdGRPVO((LongRangeSkdGRPVO)getVO(request, LongRangeSkdGRPVO.class));
		
		LongRangeSkdGRPVO grpvo = event.getLongRangeSkdGRPVO();
		List<String[]> vslInfo = new ArrayList<String[]>();
		Map<String, String[]> vslInfoMap = new TreeMap<String, String[]>();
		
		for(Enumeration e = request.getParameterNames(); e.hasMoreElements(); ){
			String name = (String)e.nextElement();
			if(name.indexOf("Vsl_")>-1){
				String vslCd = request.getParameterValues(name)[0];
				if(vslCd!=null && vslCd.length()>0){
					vslInfoMap.put(name, request.getParameterValues(name));
				}
			}
		}
		
		for(Iterator i = vslInfoMap.entrySet().iterator(); i.hasNext(); ){
			vslInfo.add(((Entry<String, String[]>) i.next()).getValue());
		}
		
		grpvo.setVslInfo(vslInfo);
		grpvo.setVslInfoMap(vslInfoMap);
		
		Map<String, String[]> simInfoMap = new TreeMap<String, String[]>();
		
		for(Enumeration e = request.getParameterNames(); e.hasMoreElements(); ){
			String name = (String)e.nextElement();
			if(name.indexOf("ETB")>-1 || name.indexOf("ETD")>-1){
				String estimateTime = request.getParameterValues(name)[0];
				if(estimateTime!=null){
					simInfoMap.put(name, request.getParameterValues(name));
				}
			}
		}
		
		grpvo.setVVD1(request.getParameterValues("VVD1"));
		grpvo.setVVD2(request.getParameterValues("VVD2"));
		grpvo.setVVD3(request.getParameterValues("VVD3"));
		
		grpvo.setSimInfoMap(simInfoMap);
		
		grpvo.setSkdRmk(request.getParameterValues("skd_rmk"));
		
		// P/F 정보
		PfSkdVO[] pfSkdVOs = (PfSkdVO[])getVOs(request, PfSkdVO.class, "sheet3_");
		grpvo.setPfSkdVOs(pfSkdVOs);
		
		
		event.setPfSkdVOs(pfSkdVOs);
		
		return event;
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

	/**
	 * HttpRequest의 attribute에 HttpRequest 파싱 수행결과 값 저장<br>
	 * HttpRequest 파싱 수행결과 값 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @param event Event interface를 구현한 객체
	 */
	public void doEnd(HttpServletRequest request, Event event) {
		request.setAttribute("Event", event);
	}

}