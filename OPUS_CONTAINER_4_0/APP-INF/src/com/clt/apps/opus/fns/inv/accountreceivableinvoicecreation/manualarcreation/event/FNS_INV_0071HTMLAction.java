/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_INV_0071HTMLAction.java
*@FileTitle : FNS_INV_0071
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.15
*@LastModifier : 정휘택
*@LastVersion : 1.0
* 2009.05.15 정휘택
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.manualarcreation.event;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ARInvoiceCreationVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.BkgChgeListVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.manualarcreation.vo.BKGContainerVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.manualarcreation.vo.MRIInputVO;
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
 * @author Jung Hwi Taek
 * @see AccountReceivableInvoiceCreationEvent 참조
 * @since J2EE 1.4
 */

public class FNS_INV_0071HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * FNS_INV_0071HTMLAction 객체를 생성
	 */
	public FNS_INV_0071HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * 
	 * @param HttpServletRequest request
	 * @return Event
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		FnsInv0071Event event = new FnsInv0071Event();
//		ARInvoiceCreationVO invCreVo = new ARInvoiceCreationVO();
		ARInvoiceCreationVO invCreVo = null;
		
		if(command.isCommand(FormCommand.MULTI)) {
			
			VVDCustomerVO vvdCustomerVo = new VVDCustomerVO();
			
			String voy = "";
			String vsl = "";
			String dep = "";
			String lcl_vvd = request.getParameter("lcl_vvd");
			String bnd = request.getParameter("io_bnd_cd");
			String pol = request.getParameter("pol_cd");		
			String pod = request.getParameter("pod_cd");
			String del = request.getParameter("del_cd");
			String por = request.getParameter("por_cd");
			String svcScp = request.getParameter("svc_scp_cd");
			String arIfNo = request.getParameter("ar_if_no");
			//String invSvcScp = request.getParameter("inv_svc_scp_cd");
						
			if (lcl_vvd.length() >= 9) {
				vsl = request.getParameter("lcl_vvd").substring(0, 4);
				voy = request.getParameter("lcl_vvd").substring(4, 8);				
				dep = request.getParameter("lcl_vvd").substring(8, 9);
		    }	
			
            vvdCustomerVo.setVsl(vsl);
            vvdCustomerVo.setVoy(voy);
            vvdCustomerVo.setDep(dep);
            vvdCustomerVo.setBnd(bnd);
            vvdCustomerVo.setPol(pol);
            vvdCustomerVo.setPod(pod);
            vvdCustomerVo.setDel(del);
            vvdCustomerVo.setPor(por);
            vvdCustomerVo.setSvcScp(svcScp);
            
            vvdCustomerVo.setArIfNo(arIfNo);
			
			event.setVvdCustomerVo(vvdCustomerVo);		
			
			event.setARInvoiceCreationVO((ARInvoiceCreationVO)getVO(request, ARInvoiceCreationVO.class));			
			
			//////////////////////////////////////////////////////////////////////////////////////////////////////
			
			invCreVo = event.getARInvoiceCreationVO();

			BkgChgeListVO[] arrBkgChgeListVOs = (BkgChgeListVO[]) getVOs(request, BkgChgeListVO.class , "sheet1_");				
			
			if(arrBkgChgeListVOs != null) {
				List<BkgChgeListVO> bkgChgeListVOs = Arrays.asList(arrBkgChgeListVOs);
				invCreVo.setBkgChgeListVOs(bkgChgeListVOs);
			}			

			BKGContainerVO[] arrBKGContainerVOs = (BKGContainerVO[]) getVOs(request, BKGContainerVO.class, "sheet2_");			
			
			if(arrBKGContainerVOs != null) {
				List<BKGContainerVO> bkgContainerVOs = Arrays.asList(arrBKGContainerVOs);
				invCreVo.setBkgContainerVOs(bkgContainerVOs);	
			}						

			event.setARInvoiceCreationVO(invCreVo);
			
		}
		else if(command.isCommand(FormCommand.SEARCH)) {
			//event.setBKGInvoiceVO((BKGInvoiceVO)getVO(request, BKGInvoiceVO .class));
			String svrId = request.getParameter("svr_id");
			String blNo = request.getParameter("bl_no");
			String rhq = request.getParameter("rhq_cd");
			String ofcCd = request.getParameter("ofc_cd");	
			String locCd = request.getParameter("loc_cd");	
			
			event.setSvrId(svrId);
			event.setBlNo(blNo);
			event.setRhqCd(rhq);
			event.setOfcCd(ofcCd);
			event.setLocCd(locCd);
		
		}
		else if(command.isCommand(FormCommand.SEARCH04)) {
			
//			String svrId = request.getParameter("svr_id");
//			String rhqCd = request.getParameter("rhq_cd");
//			String ofcCd = request.getParameter("ofc_cd");	
			String pageType = request.getParameter("pagetype");
			
//			event.setSvrId(svrId);
//			event.setRhqCd(rhqCd);
//			event.setOfcCd(ofcCd);
			event.setPageType(pageType);
			
		}
		else if(command.isCommand(FormCommand.SEARCH05)) {
			
			event.setMriInputVO((MRIInputVO)getVO(request, MRIInputVO .class));
		
		}
		else if(command.isCommand(FormCommand.SEARCH06)) {
			
			String svrId = request.getParameter("svr_id");
			String rhqCd = request.getParameter("rhq_cd");
			String ofcCd = request.getParameter("ofc_cd");	
		
			event.setSvrId(svrId);
			event.setRhqCd(rhqCd);
			event.setOfcCd(ofcCd);
			
		}
		else if(command.isCommand(FormCommand.SEARCH07)) {
			
			String ofcCd = request.getParameter("ofc_cd");	
		
			event.setOfcCd(ofcCd);
			
		}
		else if(command.isCommand(FormCommand.SEARCH08) || command.isCommand(FormCommand.SEARCH12)) {
			
			String chgCd = request.getParameter("p_chg_cd");		
			String ofcCd = request.getParameter("ofc_cd");	
			event.setChgCd(chgCd);
			event.setOfcCd(ofcCd);
			
			//log.info("########## chgCd : "+chgCd);

			
		}
		else if(command.isCommand(FormCommand.SEARCH09)) {	
			
			VVDCustomerVO vvdCustomerVo = new VVDCustomerVO();
			
			String invCntryCd = request.getParameter("inv_cust_cnt_cd");
			String invCustCd = request.getParameter("inv_cust_seq");			
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
			//String svcScp = request.getParameter("svc_scp_cd");
			String svcScp = "";
			String svrId = request.getParameter("svr_id");	
			log.info("########## svrId2 : "+svrId);
			//if (svrId.equals("EUR") || svrId.equals("KOR")) {
			//	svcScp = "OTH";
			//} else {
				svcScp = request.getParameter("svc_scp_cd");
			//}					
			
			String bnd = request.getParameter("io_bnd_cd");
			String ofcCd = request.getParameter("ofc_cd");
			String bkgNo = request.getParameter("bkg_no");
			String saDt = request.getParameter("sail_arr_dt").replaceAll("-", "");			
			String pol = request.getParameter("pol_cd");
			String curr = request.getParameter("curr_cd");			
			String pod = request.getParameter("pod_cd");	
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
		else if(command.isCommand(FormCommand.SEARCH10)) {
			
			String arIfNo = request.getParameter("ar_if_no");		
			event.setArIfNo(arIfNo);
			
			//log.info("########## chgCd : "+chgCd);

			
		}
		else if(command.isCommand(FormCommand.SEARCH11)) {
			String ofcCd = request.getParameter("ofc_cd");	
			event.setOfcCd(ofcCd);
		
		}
		else if(command.isCommand(FormCommand.MULTI01)) {
			String ofcCd = request.getParameter("ofc_cd");	
			event.setOfcCd(ofcCd);
		
		}
		else if(command.isCommand(FormCommand.SEARCH13)) {
			String ofcCd = request.getParameter("ofc_cd");	
			String mstIfNo = request.getParameter("mst_if_no");	
			
			event.setMstIfNo(mstIfNo);
			event.setOfcCd(ofcCd);
		
		}
		else if(command.isCommand(FormCommand.SEARCH14)) {
			String blNo = request.getParameter("bl_no");	
			
			event.setBlNo(blNo);			
		
		}
		else if(command.isCommand(FormCommand.SEARCH15)) {
			String ofcCd = request.getParameter("ofc_cd");	
			String masterInv = request.getParameter("master_inv");	
			
			event.setMasterInv(masterInv);
			event.setOfcCd(ofcCd);
		
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