/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_OPF_0036HTMLAction.java
*@FileTitle : TDR Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.06
*@LastModifier : 장석현
*@LastVersion : 1.0
* 2009.07.06 장석현
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.DischVolSGTdrVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.PortLogDetailVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.TdrDistLoadVolVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.TdrSlotHC45VO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.TdrUtilizeSlotPortVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.TerminalDepartureReportCondVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.TerminalDepartureReportConditionVO;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.common.table.OpfRstwgRsnCdVO;
import com.hanjin.syscommon.common.table.TdrAllocationVO;
import com.hanjin.syscommon.common.table.TdrCntrDetailVO;
import com.hanjin.syscommon.common.table.TdrHeaderVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.nis2010.vop.opf.cargoloadingresultmgt 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 CargoLoadingResultMgtSC로 실행요청<br>
 * - CargoLoadingResultMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Jang Suk Hyun
 * @see CargoLoadingResultMgtEvent 참조
 * @since J2EE 1.6
 */

public class VOP_OPF_0036HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * VOP_OPF_0036HTMLAction 객체를 생성
	 */
	public VOP_OPF_0036HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 CargoLoadingResultMgtEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		VopOpf0036Event event = new VopOpf0036Event();
		

		if(command.isCommand(FormCommand.SEARCHLIST13)) {
			event.setOpfRstwgRsnCdVO((OpfRstwgRsnCdVO)getVO(request, OpfRstwgRsnCdVO.class));
		}else if(command.isCommand(FormCommand.MULTI01)) {
            event.setAttribute("BTN_DELETE", JSPUtil.getNull(request.getParameter("BTN_DELETE"), "" ) );
			event.setTdrHeaderVOS((TdrHeaderVO[])getVOs(request, TdrHeaderVO.class, "sheetTdrH_"));

		}
		else if(command.isCommand(FormCommand.MULTI02)) {
			event.setTdrHeaderVOS((TdrHeaderVO[])getVOs(request, TdrHeaderVO.class, "sheetTdrH_"));
			event.setPortLogDetailVOS((PortLogDetailVO[])getVOs(request, PortLogDetailVO.class, "t2sheet1_"));

		}
		else if(command.isCommand(FormCommand.MULTI03)) {//"Disch. Vol."
            event.setTerminalDepartureReportCondVO((TerminalDepartureReportCondVO)getVO(request, TerminalDepartureReportCondVO.class));
			event.setTdrHeaderVOS((TdrHeaderVO[])getVOs(request, TdrHeaderVO.class, "sheetTdrH_"));
			event.setTdrDistLoadVolVOS((TdrDistLoadVolVO[])getVOs(request, TdrDistLoadVolVO.class, "t3sheet1_"));
			event.setDischVolSGTdrVOS((DischVolSGTdrVO[])getVOs(request, DischVolSGTdrVO.class, "t3sheet2_"));
			//2번 Special Cargo는 협의후 생성.
			event.setTdrCntrDetailVOS((TdrCntrDetailVO[])getVOs(request, TdrCntrDetailVO.class, "t3sheet3_"));
		}
		else if(command.isCommand(FormCommand.MULTI04)) {//"Load. Vol."
            event.setTerminalDepartureReportCondVO((TerminalDepartureReportCondVO)getVO(request, TerminalDepartureReportCondVO.class));
			event.setTdrHeaderVOS((TdrHeaderVO[])getVOs(request, TdrHeaderVO.class, "sheetTdrH_"));

			TdrDistLoadVolVO[][] list = new TdrDistLoadVolVO[2][];  
			
			int modifyCnt = 0;
			for(int cnt = 0; cnt < list.length; cnt++){
				list[cnt] = (TdrDistLoadVolVO[])getVOs(request, TdrDistLoadVolVO.class, "t4sheet" + (cnt + 1) + "_");
				modifyCnt += (list[cnt] == null ? 0 : list[cnt].length); 
			}
			
			TdrDistLoadVolVO[] listVo = new TdrDistLoadVolVO[modifyCnt];
			
			int idx = 0;
			for(int cnt = 0; cnt < list.length; cnt++){
				if(list[cnt] != null){
					for(int cnt1 = 0; cnt1 < list[cnt].length; cnt1++){
						listVo[idx] = list[cnt][cnt1];
						++idx;
					}
				}
			}
			
			event.setTdrDistLoadVolVOS(listVo);
			
			event.setDischVolSGTdrVOS((DischVolSGTdrVO[])getVOs(request, DischVolSGTdrVO.class, "t4sheet3_"));
			event.setTdrCntrDetailVOS((TdrCntrDetailVO[])getVOs(request, TdrCntrDetailVO.class, "t4sheet4_"));
		}
		else if(command.isCommand(FormCommand.MULTI05)) {
			event.setTdrHeaderVOS((TdrHeaderVO[])getVOs(request, TdrHeaderVO.class, "sheetTdrH_"));
			event.setTdrCntrDetailVOS((TdrCntrDetailVO[])getVOs(request, TdrCntrDetailVO.class, "t5sheet1_"));
		}
		else if(command.isCommand(FormCommand.MULTI06)) {
            event.setTerminalDepartureReportCondVO((TerminalDepartureReportCondVO)getVO(request, TerminalDepartureReportCondVO.class));
			event.setTdrHeaderVOS((TdrHeaderVO[])getVOs(request, TdrHeaderVO.class, "sheetTdrH_"));
			event.setTdrCntrDetailVOS((TdrCntrDetailVO[])getVOs(request, TdrCntrDetailVO.class, "t6sheet1_"));
		}
		else if(command.isCommand(FormCommand.MULTI07)) {
            event.setTerminalDepartureReportCondVO((TerminalDepartureReportCondVO)getVO(request, TerminalDepartureReportCondVO.class));
			event.setTdrHeaderVOS((TdrHeaderVO[])getVOs(request, TdrHeaderVO.class, "sheetTdrH_"));
			event.setTdrCntrDetailVOS((TdrCntrDetailVO[])getVOs(request, TdrCntrDetailVO.class, "t7sheet1_"));
		}
		else if(command.isCommand(FormCommand.MULTI08)) {
			event.setTdrHeaderVOS((TdrHeaderVO[])getVOs(request, TdrHeaderVO.class, "sheetTdrH_"));
			event.setTdrAllocationVOS((TdrAllocationVO[])getVOs(request, TdrAllocationVO.class, "t8sheet1_"));
			event.setTdrSlotHC45VO((TdrSlotHC45VO[])getVOs(request, TdrSlotHC45VO.class, "t8sheet2_"));

			TdrUtilizeSlotPortVO[][] list = new TdrUtilizeSlotPortVO[2][];  
			
			int modifyCnt = 0;
			for(int cnt = 0; cnt < list.length; cnt++){
				list[cnt] = (TdrUtilizeSlotPortVO[])getVOs(request, TdrUtilizeSlotPortVO.class, "t8sheet" + (cnt + 3) + "_");
				modifyCnt += (list[cnt] == null ? 0 : list[cnt].length); 
			}
			
			TdrUtilizeSlotPortVO[] listVo = new TdrUtilizeSlotPortVO[modifyCnt];
			
			int idx = 0;
			for(int cnt = 0; cnt < list.length; cnt++){
				if(list[cnt] != null){
					for(int cnt1 = 0; cnt1 < list[cnt].length; cnt1++){
						listVo[idx] = list[cnt][cnt1];
						++idx;
					}
				}
			}
			
			event.setTdrUtilizeSlotPortVO(listVo);
		}
		else if(command.isCommand(FormCommand.MULTI09)) {
			event.setTdrHeaderVOS((TdrHeaderVO[])getVOs(request, TdrHeaderVO.class, "sheetTdrH_"));
			event.setTdrCntrDetailVOS((TdrCntrDetailVO[])getVOs(request, TdrCntrDetailVO.class, "t9sheet1_"));
		}
		else if(command.isCommand(FormCommand.MULTI10)) {
			event.setTdrHeaderVOS((TdrHeaderVO[])getVOs(request, TdrHeaderVO.class, "sheetTdrH_"));
		}
        else if(command.isCommand(FormCommand.SEARCH09)) { 
            event.setTerminalDepartureReportConditionVO( (TerminalDepartureReportConditionVO)getVO(request, TerminalDepartureReportConditionVO.class));
        }
		else if(command.isCommand(FormCommand.SEARCH16)) {
			TdrCntrDetailVO tdrCntrDetailVO = (TdrCntrDetailVO)getVO(request, TdrCntrDetailVO.class );
			event.setTdrCntrDetailVOS(new TdrCntrDetailVO[] {tdrCntrDetailVO} );
		}
		else{
			event.setTerminalDepartureReportCondVO((TerminalDepartureReportCondVO)getVO(request, TerminalDepartureReportCondVO.class));
		}
		 
		request.setAttribute("Event", event);

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