/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : INVCommonHTMLAction.java
*@FileTitle : INVCommon
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.24
*@LastModifier : 김세일
*@LastVersion : 1.0
* 2009.04.24 김세일
* 1.0 Creation
* 2010.11.22 이석준 CHM-201006884
*            code description 가져오는 function 추가* 
=========================================================*/
package com.clt.apps.opus.fns.inv.invcommon.invcommon.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.fns.inv.invcommon.invcommon.vo.CodeInputVO;
import com.clt.apps.opus.fns.inv.invcommon.invcommon.vo.VVDCustomerVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.fns.inv.invcommon 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 INVCommonSC로 실행요청<br>
 * - INVCommonSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author saeil kim
 * @see INVCommonEvent 참조
 * @since J2EE 1.4
 */
 
public class INVCommonHTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * INVCommonHTMLAction 객체를 생성
	 */
	public INVCommonHTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * 
	 * @param HttpServletRequest request
	 * @return Event
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
		FormCommand command = FormCommand.fromRequest(request);
		InvCommonEvent event = new InvCommonEvent();
		
//		PricommonEvent event = new PricommonEvent();
		
		log.info("HtmlAction:perform");

		if(command.isCommand(FormCommand.SEARCH04)) {
			
			String from_currCd = request.getParameter("curr_cd");
			String to_currCd = request.getParameter("locl_curr_cd");
			log.info("Action:"+request.getParameter("curr_cd"));
			String effDt = request.getParameter("eff_dt");		
			event.setFromCurrCd(from_currCd);
			event.setToCurrCd(to_currCd);
			event.setEffDt(effDt);
			log.info(event.getEffDt());
			log.info(event.getFromCurrCd());
			log.info(event.getToCurrCd());

		}
		else if(command.isCommand(FormCommand.SEARCH05)) {	
			
			//log.info("########## INVCommonHTMLAction:perform");
			
			VVDCustomerVO vvdCustomerVo = new VVDCustomerVO();
			
			String invCntryCd = request.getParameter("inv_cust_cnt_cd");
			String invCustCd = request.getParameter("inv_cust_seq");			
			String vvd = request.getParameter("lcl_vvd");
			log.info("\n########## vvd : "+vvd);
			String vsl = "";
			String voy = "";
			String dep = "";
			if (vvd.length() >= 9) {
				vsl = vvd.substring(0, 4);
				voy = vvd.substring(4, 8);
				dep = vvd.substring(8, 9);
		    }					
			String lclCurr = request.getParameter("lcl_curr");
			String svcScp = "";
			String svrId = request.getParameter("svr_id");	
			log.info("########## svrId1 : "+svrId);
			//2014.11.27 commented by sy park 
			/*if (svrId.equals("EUR") || svrId.equals("KOR")) {
				svcScp = "OTH";
			} else {
				svcScp = request.getParameter("svc_scp_cd");
			}*/	
			svcScp = request.getParameter("svc_scp_cd");
			String bnd = request.getParameter("io_bnd_cd");
			String ofcCd = request.getParameter("ofc_cd");
			String bkgNo = request.getParameter("bkg_no");
			String saDt = request.getParameter("sail_arr_dt").replaceAll("-", "");			
			String pol = request.getParameter("pol_cd");
			String curr = request.getParameter("curr_cd");			
			String pod = request.getParameter("pod_cd");	
						
			vvdCustomerVo.setInvCntryCd(invCntryCd);
			vvdCustomerVo.setInvCustCd(invCustCd);
			vvdCustomerVo.setVoy(voy);
			vvdCustomerVo.setLclCurr(lclCurr);
			vvdCustomerVo.setSvcScp(svcScp);
			vvdCustomerVo.setBnd(bnd);
			vvdCustomerVo.setOfcCd(ofcCd);
			vvdCustomerVo.setBkgNo(bkgNo);
			vvdCustomerVo.setSaDt(saDt);
			vvdCustomerVo.setVsl(vsl);
			vvdCustomerVo.setPol(pol);
			vvdCustomerVo.setCurr(curr);
			vvdCustomerVo.setDep(dep);
			vvdCustomerVo.setPod(pod);
			
			event.setVvdCustomerVo(vvdCustomerVo);
			
//			event.setVvdCustomerVo((VVDCustomerVO)getVO(request, VVDCustomerVO .class));			
	
		}
		else if(command.isCommand(FormCommand.SEARCH06)) {	
			
			String vvd = request.getParameter("vvd");
			event.setVvd(vvd);	
			
		}
		else if(command.isCommand(FormCommand.SEARCH07)) {	
			
			event.setVvd(request.getParameter("vvd"));	
			event.setPort(request.getParameter("port"));	
			event.setBnd(request.getParameter("bnd"));	
			
		}
		else if(command.isCommand(FormCommand.SEARCH08)) {	
			
			event.setBkgNo(request.getParameter("bkg_no"));
			
		}
		else if(command.isCommand(FormCommand.SEARCH09)) {	
			
			event.setOfcCd(request.getParameter("ofc_cd"));	
			event.setSailDt(request.getParameter("sail_dt"));
			
		}
		else if(command.isCommand(FormCommand.SEARCH10)) {	
			
			event.setOfcCd(request.getParameter("ofc_cd"));
		}
		else if(command.isCommand(FormCommand.SEARCH14)) {
			event.setLane(request.getParameter("lane"));
		}
		else if(command.isCommand(FormCommand.SEARCH15)) {
			event.setArOfcCd(request.getParameter("ar_ofc_cd"));
		}		
		else if(command.isCommand(FormCommand.SEARCH03)) {
			event.setCntryCd(request.getParameter("cust_cnt_cd"));
			event.setCustCd(request.getParameter("cust_seq"));	
		}
		else if(command.isCommand(FormCommand.SEARCH16)) {
			event.setCntryCd(request.getParameter("cust_cnt_cd"));
			event.setCustCd(request.getParameter("cust_seq"));	
			event.setCustRgstNo(request.getParameter("cust_rgst_no"));
		} else if(command.isCommand(FormCommand.COMMAND01)){
			event.setCodeInputVO((CodeInputVO)getVO(request, CodeInputVO .class));
		}
		else if(command.isCommand(FormCommand.COMMAND02)) {
			event.setArOfcCd(request.getParameter("ar_ofc_cd"));
			event.setFromCurrCd(request.getParameter("from_curr_cd"));
			event.setToCurrCd(request.getParameter("to_curr_cd"));			
		}
		else if(command.isCommand(FormCommand.COMMAND03)) {	//FNS_INV_0113 CALL
			event.setVvd(request.getParameter("vvd_cd"));						
		}
		
		String pageType = request.getParameter("pagetype");
		event.setPageType(pageType);	
		
//		String cntryCd = request.getParameter("cust_cnt_cd");
//		String custCd = request.getParameter("cust_seq");		
//		String custRgstNo = request.getParameter("cust_rgst_no");		
//		event.setCntryCd(cntryCd);
//		event.setCustCd(custCd);	
//		event.setCustRgstNo(custRgstNo);

		request.setAttribute("Event", event);

		return  event;
	}

	/**
	 * HttpRequest의 attribute에 업무시나리오 수행결과 값 저장<br>
	 * ServiceCommand에서 View(JSP)로 실행결과를 전송하는 ResultSet을 request에 셋팅<br>
	 * 
	 * @param HttpServletRequest request
	 * @param EventResponse eventResponse
	 */
	public void doEnd(HttpServletRequest request, EventResponse eventResponse) {
		request.setAttribute("EventResponse", eventResponse);
	}

	/**
	 * HttpRequest의 attribute에 업무시나리오 수행결과 값 저장<br>
	 * ServiceCommand에서 View(JSP)로 실행결과를 전송하는 ResultSet을 request에 셋팅<br>
	 * 
	 * @param HttpServletRequest request
	 * @param Event event
	 */
	public void doEnd(HttpServletRequest request, Event event) {
		request.setAttribute("Event", event);
	}

}