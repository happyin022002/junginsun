/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : UI_COM_SYS_011HTMLAction.java
*@FileTitle : �꾨줈洹몃옩蹂���븷留ㅽ븨 愿�━
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-10
*@LastModifier : Kildong_hong
*@LastVersion : 1.0
* 2006-11-10 Kildong_hong
* 1.0 理쒖큹 �앹꽦
=========================================================*/
package com.hanjin.syscommon.management.alps.role.event;

import java.util.Collection;
import javax.servlet.http.HttpServletRequest;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

import com.hanjin.syscommon.common.table.ComPgmRoleVO;



/**
 * HTTP Parser<br>
 * - com.hanjin.syscommon �붾㈃���듯빐 �쒕쾭濡��꾩넚�섎뒗 HTML DOM 媛앹껜��Value瑜��먮컮 蹂�닔濡�Parsing<br> 
 * - Parsing ���뺣낫瑜�Event濡�蹂�솚, request���댁븘 RoleMappingManagementSCSC濡��ㅽ뻾�붿껌<br>
 * - RoleMappingManagementSCSC�먯꽌 View(JSP)濡��ㅽ뻾寃곌낵瑜��꾩넚�섎뒗 EventResponse瑜�request���뗮똿<br>
 *
 * @author Kildong_hong
 * @see ComSys011Event , UI_COM_SYS_011EventResponse 李몄“
 * @since J2EE 1.4
 */
public class COM_SYS_011HTMLAction extends HTMLActionSupport {

	/**
	 * UI_COM_SYS_011HTMLAction 媛앹껜瑜��앹꽦
	 */
	public COM_SYS_011HTMLAction() {
	}

	/**
	 * HTML DOM 媛앹껜��Value瑜��먮컮 蹂�닔濡�Parsing<br>
	 * HttpRequst���뺣낫瑜�UI_COM_SYS_011Event濡��뚯떛�섏뿬 request���뗮똿<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface瑜�援ы쁽��媛앹껜
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
    	FormCommand command = FormCommand.fromRequest(request);
		String pgm_no = JSPUtil.getParameter(request, "pgm_no".trim(), "");
		String pgm_nm = JSPUtil.getParameter(request, "pgm_nm".trim(), "");
		ComPgmRoleVO[] comPgmRoles = (ComPgmRoleVO[])getVOs(request, ComPgmRoleVO.class);
		//Role Mapping 팝업창 열 때 request는 null, Role Mapping에서 save할 시에 save 건이 request에 추가
		ComSys011Event event = new ComSys011Event();
		if(command.isCommand(FormCommand.MULTI)) {
			log.error("========command is : "+command.getCommand()+" and counts is : "+comPgmRoles.length);
		}
		
		event.setComPgmRoles(comPgmRoles);
		event.setComPgmRoleVO(null);
		event.setProgId(pgm_no);
		event.setProgNm(pgm_nm);
	
		request.setAttribute("Event", event);

		return  event;
	}

	/**
	 * HttpRequest��attribute���낅Т�쒕굹由ъ삤 �섑뻾寃곌낵 媛���옣<br>
	 * ServiceCommand�먯꽌 View(JSP)濡��ㅽ뻾寃곌낵瑜��꾩넚�섎뒗 ResultSet��request���뗮똿<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @param eventResponse EventResponse interface瑜�援ы쁽��媛앹껜
	 */
	public void doEnd(HttpServletRequest request, EventResponse eventResponse) {
		request.setAttribute("EventResponse", eventResponse);
	}

	/**
	 * HttpRequest��attribute��HttpRequest �뚯떛 �섑뻾寃곌낵 媛���옣<br>
	 * HttpRequest �뚯떛 �섑뻾寃곌낵 媛�request���뗮똿<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @param event Event interface瑜�援ы쁽��媛앹껜
	 */
	public void doEnd(HttpServletRequest request, Event event) {
		request.setAttribute("Event", event);
	}

}