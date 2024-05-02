/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_INV_0022HTMLAction.java
*@FileTitle : Other Revenue Invoice Entry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.27
*@LastModifier : 김세일
*@LastVersion : 1.0
* 2009.04.27 김세일
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.manualarcreation.event;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ARInvoiceCreationVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.InvArAmtVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.InvArChgVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.InvIssMainVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.IssueEachTargetVO;
import com.clt.apps.opus.fns.inv.invcommon.invcommon.vo.VVDCustomerVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 AccountReceivableInvoiceCreationSC로 실행요청<br>
 * - AccountReceivableInvoiceCreationSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author saeil kim
 * @see AccountReceivableInvoiceCreationEvent 참조
 * @since J2EE 1.4
 */

public class FNS_INV_0022HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * FNS_INV_0022HTMLAction 객체를 생성
	 */
	public FNS_INV_0022HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * 
	 * @param HttpServletRequest request
	 * @return Event
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		FnsInv0022Event event = new FnsInv0022Event();
		ARInvoiceCreationVO invCreVo = new ARInvoiceCreationVO();

		if(command.isCommand(FormCommand.SEARCH)) {
			String office = request.getParameter("ofc_cd");
			String arIfNo = request.getParameter("ar_if_no");
			
			event.setOffice(office);
			event.setArIfNo(arIfNo);
		}
		else if(command.isCommand(FormCommand.SEARCH05)) {
			String pageType = request.getParameter("pagetype");
			String glEffDt = request.getParameter("eff_dt");
			event.setPageType(pageType);
			event.setGlEffDt(glEffDt);
		}
		else if(command.isCommand(FormCommand.SEARCH06)) {
			String office = request.getParameter("ofc_cd");
			String glEffDt = request.getParameter("eff_dt");
			String currCd = request.getParameter("curr_cd");
			String localCurrCd = request.getParameter("lcl_curr");
			
			event.setOffice(office);
			event.setGlEffDt(glEffDt);
			event.setCurrCd(currCd);
			event.setLocalCurrCd(localCurrCd);
		}
		else if(command.isCommand(FormCommand.SEARCH07)) {
			String office = request.getParameter("ofc_cd");
			String blSrcNo = request.getParameter("bl_src_no");
			
			event.setOffice(office);
			event.setBlSrcNo(blSrcNo);
		}
		else if(command.isCommand(FormCommand.SEARCH09)) {	
			
			VVDCustomerVO vvdCustomerVo = new VVDCustomerVO();
			
			String invCntryCd = request.getParameter("cust_cnt_cd");
			String invCustCd = request.getParameter("cust_seq");			
			String lcl_vvd = request.getParameter("lcl_vvd");
			String voy = "";
			String vsl = "";
			String dep = "";
			if (lcl_vvd.length() >= 9) {
				voy = request.getParameter("lcl_vvd").substring(4, 8);
				vsl = request.getParameter("lcl_vvd").substring(0, 4);
				dep = request.getParameter("lcl_vvd").substring(8, 9);
		    }			
			String lclCurr = request.getParameter("lcl_curr");
			String svcScp = "";
			String svrId = request.getParameter("svr_id");	
			log.info("########## svrId2 : "+svrId);
			svcScp = request.getParameter("svc_scp_cd");
			
			String bnd = request.getParameter("io_bnd_cd");
			String ofcCd = request.getParameter("ofc_cd");
			String bkgNo = request.getParameter("bl_src_no");
			String saDt = request.getParameter("eff_dt").replaceAll("-", "");			
			String pol = request.getParameter("pol_cd");
			String curr = request.getParameter("curr_cd");			
			String pod = request.getParameter("pol_cd");	
			//String invSvcScp = request.getParameter("inv_svc_scp_cd");
			
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
		else if(command.isCommand(FormCommand.MULTI01)) {
			String office = request.getParameter("ofc_cd");
			event.setOffice(office);
		}
		else if(command.isCommand(FormCommand.MULTI)) {
			String office = request.getParameter("ofc_cd");
			event.setOffice(office);
			String sailArrDt = request.getParameter("sail_arr_dt");
			//log.info("SailArrDt21:"+sailArrDt);
			String effDt = request.getParameter("eff_dt").replaceAll("-", "");
			
			//INV_AR_MN
			invCreVo = (ARInvoiceCreationVO)getVO(request, ARInvoiceCreationVO.class);
			
			if(sailArrDt.length() == 0){
				invCreVo.setSailArrDt(effDt);
			} else {
				invCreVo.setSailArrDt(sailArrDt);
			}
			
			//INV_AR_AMT
			InvArAmtVO[] invArAmtVOLists = (InvArAmtVO[]) getVOs(request, InvArAmtVO.class , "sheet4_");
			if(invArAmtVOLists != null) {
				List<InvArAmtVO> invArAmtVOs = Arrays.asList(invArAmtVOLists);
				invCreVo.setInvArAmtVOs(invArAmtVOs);
			}

			//INV_AR_CHG
			InvArChgVO[] invArChgListVOs = (InvArChgVO[]) getVOs(request, InvArChgVO.class , "sheet1_");				
			if(invArChgListVOs != null) {
				List<InvArChgVO> invArChgVOs = Arrays.asList(invArChgListVOs);
				invCreVo.setInvArChgVOs(invArChgVOs);
			}
			
			event.setARInvoiceCreationVO(invCreVo);
		}
		else if(command.isCommand(FormCommand.MULTI02)) {
			String office = request.getParameter("ofc_cd");
			String arIfNo = request.getParameter("ar_if_no");
			String otsSmryCd = request.getParameter("ots_smry_cd");
			event.setOffice(office);
			event.setArIfNo(arIfNo);
			event.setOtsSmryCd(otsSmryCd);
			
			//INV_AR_ISS
			InvIssMainVO invIssCreVo = (InvIssMainVO)getVO(request, InvIssMainVO.class);

			//INV_AR_CHG
			IssueEachTargetVO[] invArChgListVOs = (IssueEachTargetVO[]) getVOs(request, IssueEachTargetVO.class , "sheet1_");				
			
			event.setInvIssMainVO(invIssCreVo);
			event.setIssEachTgtVOs(invArChgListVOs);
		}
		
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