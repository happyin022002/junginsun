/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_VSK_0066HTMLAction.java
*@FileTitle : Slot Price 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.15
*@LastModifier : 서창열
*@LastVersion : 1.0
* 2009.07.15 서창열
* 1.0 Creation
* 
* History
* 2011.04.07 CHM-201110042-01 진마리아 불필요한 시스템 로그 출력 제거
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.event;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.BunkerCostVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.HireBaseVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.PortExpenseVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.SlotPriceGRPVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.SlotPriceVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.event.SchedulePlanningOperationEvent;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.YardVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 SchedulePlanningOperationSC로 실행요청<br>
 * - SchedulePlanningOperationSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author SEO CHANG YUL
 * @see SchedulePlanningOperationEvent 참조
 * @since J2EE 1.6
 */

public class VOP_VSK_0066HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * VOP_VSK_0066HTMLAction 객체를 생성
	 */
	public VOP_VSK_0066HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 SchedulePlanningOperationEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		VopVsk0066Event event = new VopVsk0066Event();
		
		if(command.isCommand(FormCommand.MULTI)) {
			//Master Data
			String durDay = request.getParameter("durDay");
			String seaDay = request.getParameter("seaDay");
			String maneDay = request.getParameter("maneDay");
			String portDay = request.getParameter("portDay");
			String durHrs = request.getParameter("durHrs");
			String seaHrs = request.getParameter("seaHrs");
			String maneHrs = request.getParameter("maneHrs");
			String portHrs = request.getParameter("portHrs");
			
			SlotPriceGRPVO grpVO = new SlotPriceGRPVO();
			
			//Master Data
			SlotPriceVO[] tempVOs = (SlotPriceVO[])getVOs(request, SlotPriceVO.class,"sheet1_");
			SlotPriceVO slotPriceVO = new SlotPriceVO();
			
			for(int i=0; i<tempVOs.length; i++){
				slotPriceVO = tempVOs[i];
			}
			
			slotPriceVO.setDurDay(durDay);
			slotPriceVO.setSeaDay(seaDay);
			slotPriceVO.setManeDay(maneDay);
			slotPriceVO.setPortDay(portDay);
			slotPriceVO.setDurHrs(durHrs);
			slotPriceVO.setSeaHrs(seaHrs);
			slotPriceVO.setManeHrs(maneHrs);
			slotPriceVO.setPortHrs(portHrs);
			
			
			grpVO.setSlotPriceVO(slotPriceVO);
			//Port Expense
			PortExpenseVO[] tempPortExpenseVOs = (PortExpenseVO[])getVOs(request, PortExpenseVO.class,"sheet2_");
			List<PortExpenseVO> portExpenseVOs = Arrays.asList(tempPortExpenseVOs);
			grpVO.setPortExpenseVOs(portExpenseVOs);
			
			BunkerCostVO[] tempBunkerCostVOs = (BunkerCostVO[])getVOs(request, BunkerCostVO.class,"sheet3_");
			List<BunkerCostVO> bunkerCostVOs = Arrays.asList(tempBunkerCostVOs);
			grpVO.setBunkerCostVOs(bunkerCostVOs);
			
			
			//Hise Base
			HireBaseVO[] tempHireBaseVOs = (HireBaseVO[])getVOs(request, HireBaseVO.class,"sheet4_");
			List<HireBaseVO> hisrBaseVOs = Arrays.asList(tempHireBaseVOs);
			grpVO.setHireBaseVOs(hisrBaseVOs);
			
			//Slot Price
			SlotPriceVO[] tempSlotPriceVOs = (SlotPriceVO[])getVOs(request, SlotPriceVO.class,"sheet5_");
			List<SlotPriceVO> slotPriceVOs = Arrays.asList(tempSlotPriceVOs);
			grpVO.setSlotPriceVOs(slotPriceVOs);
			
			event.setSlotPriceGRPVO(grpVO);
			
		}
		else if(command.isCommand(FormCommand.SEARCH)) {
			event.setSlotPriceVO((SlotPriceVO)getVO(request, SlotPriceVO .class));
			
			SlotPriceGRPVO grpVO = new SlotPriceGRPVO();
			SlotPriceVO slotPriceVO = event.getSlotPriceVO();
			String sltPrcWrkYr = slotPriceVO.getSltPrcWrkYr();
			String bseQtrCd = slotPriceVO.getBseQtrCd();
			String vpsEtaFmDt = "";
			String vpsEtaToDt = "";
			
			if("1Q".equals(bseQtrCd)){
				vpsEtaFmDt = sltPrcWrkYr+"0101";
				vpsEtaToDt = sltPrcWrkYr+"0301";
			}else if("2Q".equals(bseQtrCd)){
				vpsEtaFmDt = sltPrcWrkYr+"0401";
				vpsEtaToDt = sltPrcWrkYr+"0601";
			}else if("3Q".equals(bseQtrCd)){
				vpsEtaFmDt = sltPrcWrkYr+"0701";
				vpsEtaToDt = sltPrcWrkYr+"0901";
			}else{
				vpsEtaFmDt = sltPrcWrkYr+"1001";
				vpsEtaToDt = sltPrcWrkYr+"1201";
			}
			
			slotPriceVO.setVpsEtaFmDt(vpsEtaFmDt);
			slotPriceVO.setVpsEtaToDt(vpsEtaToDt);
			grpVO.setSlotPriceVO(event.getSlotPriceVO());
			
			event.setSlotPriceGRPVO(grpVO);
		}else if(command.isCommand(FormCommand.COMMAND01)){
			//Master Data
			String durDay = request.getParameter("durDay");
			String seaDay = request.getParameter("seaDay");
			String maneDay = request.getParameter("maneDay");
			String portDay = request.getParameter("portDay");
			String durHrs = request.getParameter("durHrs");
			String seaHrs = request.getParameter("seaHrs");
			String maneHrs = request.getParameter("maneHrs");
			String portHrs = request.getParameter("portHrs");
			
			SlotPriceVO[] masterVOs = (SlotPriceVO[])getVOs(request, SlotPriceVO.class,"sheet1_");
			SlotPriceVO masterVO = new SlotPriceVO();
			
			for(int i=0; i<masterVOs.length; i++){
				masterVO = masterVOs[i];
			}			
			
			SlotPriceGRPVO grpVO = new SlotPriceGRPVO();

			String sltPrcWrkYr = masterVO.getSltPrcWrkYr();
			String bseQtrCd = masterVO.getBseQtrCd();
			String vpsEtaFmDt = "";
			String vpsEtaToDt = "";

			if("1Q".equals(bseQtrCd)){
				vpsEtaFmDt = sltPrcWrkYr+"0101";
				vpsEtaToDt = sltPrcWrkYr+"0301";
			}else if("2Q".equals(bseQtrCd)){
				vpsEtaFmDt = sltPrcWrkYr+"0401";
				vpsEtaToDt = sltPrcWrkYr+"0601";
			}else if("3Q".equals(bseQtrCd)){
				vpsEtaFmDt = sltPrcWrkYr+"0701";
				vpsEtaToDt = sltPrcWrkYr+"0901";
			}else{
				vpsEtaFmDt = sltPrcWrkYr+"1001";
				vpsEtaToDt = sltPrcWrkYr+"1201";
			}
			
			masterVO.setVpsEtaFmDt(vpsEtaFmDt);
			masterVO.setVpsEtaToDt(vpsEtaToDt);
			masterVO.setDurDay(durDay);
			masterVO.setSeaDay(seaDay);
			masterVO.setManeDay(maneDay);
			masterVO.setPortDay(portDay);
			masterVO.setDurHrs(durHrs);
			masterVO.setSeaHrs(seaHrs);
			masterVO.setManeHrs(maneHrs);
			masterVO.setPortHrs(portHrs);
			grpVO.setSlotPriceVO(masterVO);
			
			// Port Expense
			PortExpenseVO[] portExpenseTempVOs = (PortExpenseVO[])getVOs(request, PortExpenseVO.class,"sheet2_");
			List<PortExpenseVO> portExpenseVOs = Arrays.asList(portExpenseTempVOs);
			grpVO.setPortExpenseVOs(portExpenseVOs);
			
			//Bunker Cost
			BunkerCostVO[] bunkerCostTempVOs = (BunkerCostVO[])getVOs(request, BunkerCostVO.class,"sheet3_");
			List<BunkerCostVO> bunkerCostVOs = Arrays.asList(bunkerCostTempVOs);
			grpVO.setBunkerCostVOs(bunkerCostVOs);
			
			//Hire Base
			HireBaseVO[] tempHireBaseVOs = (HireBaseVO[])getVOs(request, HireBaseVO.class,"sheet4_");			
			List<HireBaseVO> hisrBaseVOs = Arrays.asList(tempHireBaseVOs);

			if("1".equals(hisrBaseVOs.get(1).getVslOwnrFlg())){
				hisrBaseVOs.get(1).setVslOwnrFlg("Y");
				hisrBaseVOs.get(2).setVslOwnrFlg("N");
			}else{
				hisrBaseVOs.get(1).setVslOwnrFlg("N");
				hisrBaseVOs.get(2).setVslOwnrFlg("Y");
			}

			grpVO.setHireBaseVOs(hisrBaseVOs);
			
			event.setSlotPriceGRPVO(grpVO);
		}else if(command.isCommand(FormCommand.SEARCH03)){
			event.setYardVO((YardVO)getVO(request, YardVO .class));
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