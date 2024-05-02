/*=========================================================
*Copyright(c) 2017 Hipluscard
*@FileName : ESM_SAM_0302HTMLAction.java
*@FileTitle : customer
*Open Issues :
*Change history :
*@LastModifyDate : 2017.06.07
*@LastModifier : 
*@LastVersion : 1.0
* 2017.06.07
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sam.custmanage.custmain.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.sam.custmanage.custmain.vo.BkgSalesRepVO;
import com.hanjin.apps.alps.esm.sam.custmanage.custmain.vo.CustCoverTeamVO;
import com.hanjin.apps.alps.esm.sam.custmanage.custmain.vo.CustomerAddressVO;
import com.hanjin.apps.alps.esm.sam.custmanage.custmain.vo.CustomerContactVO;
import com.hanjin.apps.alps.esm.sam.custmanage.custmain.vo.CustomerIntegrationVO;
import com.hanjin.apps.alps.esm.sam.custmanage.custmain.vo.CustomerVO;
import com.hanjin.apps.alps.esm.sam.custmanage.custmain.vo.MdmCustomerVO;
import com.hanjin.apps.alps.esm.sam.custmanage.keymaninfo.vo.SamKeyManInfoVO;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.sam.commoncode 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 commoncodeSC로 실행요청<br>
 * - commoncodeSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author 
 * @see commoncodeEvent 참조
 * @since J2EE 1.6
 */

public class ESM_SAM_0302HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_SAM_0302HTMLAction 객체를 생성
	 */
	public ESM_SAM_0302HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 commoncodeEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsmSam0302Event event = new EsmSam0302Event();
		
		event.setIsNewYn(request.getParameter("is_new_yn"));

		if(command.isCommand(FormCommand.SEARCH)) {
			log.debug("getCustLglEngNm================================"+request.getParameter("cust_cnt_cd"));
			event.setCustSeq(request.getParameter("cust_seq"));
			event.setCustCntCd(request.getParameter("cust_cnt_cd"));
		}
//		else if(command.isCommand(FormCommand.SEARCH01)) {
//			
//		}
		else if(command.isCommand(FormCommand.SEARCH02)) {
			event.setCustCntCd(request.getParameter("cust_cnt_cd"));
		}else if(command.isCommand(FormCommand.SEARCH03)) {
			event.setLocCd(request.getParameter("loc_cd"));
		}else if(command.isCommand(FormCommand.SEARCH04)) {
			event.setOfcCd(request.getParameter("ofc_cd"));
		}else if(command.isCommand(FormCommand.SEARCH05)) {
			event.setVndrSeq(request.getParameter("vndr_seq"));
		}else if(command.isCommand(FormCommand.SEARCH06)) {
			event.setCapiCurrCd(request.getParameter("capi_curr_cd"));
		}else if(command.isCommand(FormCommand.SEARCH07)) {
			event.setLocCd(request.getParameter("loc_cd"));
		}else if(command.isCommand(FormCommand.MULTI) || command.isCommand(FormCommand.SEARCH13)) {
			log.debug("MULTI================================"+request.getParameter("cust_cnt_cd"));
			event.setCustomerVOS((CustomerVO[])getVOs(request, CustomerVO.class,""));
			event.setMdmCustomerVOS((MdmCustomerVO[])getVOs(request, MdmCustomerVO.class,""));
			event.setCustomerContactVOS((CustomerContactVO[])getVOs(request, CustomerContactVO .class,""));
			event.setBkgSalesRepVOS((BkgSalesRepVO[])getVOs(request, BkgSalesRepVO .class,"t2bsheet4_"));

			/** 추가 - B **/
			String custCntCd = JSPUtil.getParameter(request, "cust_cnt_cd");
			event.setCustCntCd(custCntCd);
			String custSeq = JSPUtil.getParameter(request, "cust_seq");
			event.setCustSeq(custSeq);
			String addrTpCd = JSPUtil.getParameter(request, "addr_tp_cd");
			event.setAddrTpCd(addrTpCd);
			String creflag = JSPUtil.getParameter(request, "creflag");
			event.setCreflag(creflag);
			String saveflag = JSPUtil.getParameter(request, "saveflag");
			event.setSaveflag(saveflag);
			
			
//			event.setMdmCustomerVOS2((MdmCustomerVO[])getVOs(request, MdmCustomerVO.class,"sheet2_"));
//			event.setMdmCustomerVOS3((MdmCustomerVO[])getVOs(request, MdmCustomerVO.class,"sheet3_"));
			event.setSamKeyManInfoVOS((SamKeyManInfoVO[])getVOs(request, SamKeyManInfoVO .class,"t2bsheet2_"));
			event.setCustomerAddressVOS((CustomerAddressVO[])getVOs(request, CustomerAddressVO .class,"t2bsheet3_"));
			event.setCustCoverTeamVOS((CustCoverTeamVO[])getVOs(request, CustCoverTeamVO .class,"t2bsheet4_"));
			/** 추가 - E **/
			
			CustomerIntegrationVO customerIntgVO = new CustomerIntegrationVO();
			customerIntgVO.setCustomerVO((CustomerVO)getVO(request, CustomerVO.class,""));
			//customerIntgVO.setCustomerContactVOs((CustomerContactVO[])getVOs(request, CustomerContactVO .class,"sheet3_"));
			customerIntgVO.setCustomerAddressVOs((CustomerAddressVO[])getVOs(request, CustomerAddressVO .class,"sheet2_"));
			
			if ("Y".equals(creflag)) {
				event.setBkgSalesRepVOS((BkgSalesRepVO[])getVOs(request, BkgSalesRepVO .class,""));
				event.setCustomerAddressVOS((CustomerAddressVO[])getVOs(request, CustomerAddressVO .class,""));
			}
			
			event.setCustomerIntgVO(customerIntgVO);			
			
			// test
			log.debug("\n\n ESM_SAM_0302HTMLAction --------- "
					+ "\n custCntCd : " + JSPUtil.getNull(custCntCd)
					+ "\n custSeq : " + JSPUtil.getNull(custSeq)
					+ "\n addrTpCd : " + JSPUtil.getNull(addrTpCd)
					+ " \n\n");

			CustomerVO[] csc = event.getCustomerVOS();
			for (int c=0; csc!=null && c<csc.length; c++){
				log.debug("\n csc["+c+"] : \n"+csc[c].toString()+"\n");
			}
			log.debug("\n\n");
			SamKeyManInfoVO[] csk = event.getSamKeyManInfoVOS();
			for (int c=0; csk!=null && c<csk.length; c++){
				log.debug("\n csk["+c+"] : \n"+csk[c].toString()+"\n");
			}
			log.debug("\n\n");
			CustomerAddressVO[] cas = event.getCustomerAddressVOS();
			for (int a=0; cas!=null && a<cas.length; a++){
				log.debug("\n cas["+a+"] : \n"+cas[a].toString()+"\n");
			}
			log.debug("\n\n");
		}else if(command.isCommand(FormCommand.MULTI01)) {	
			event.setCustomerVOS((CustomerVO[])getVOs(request, CustomerVO.class,""));
			event.setMdmCustomerVOS((MdmCustomerVO[])getVOs(request, MdmCustomerVO.class,""));

			/** 추가 - B **/
			String custCntCd = JSPUtil.getParameter(request, "cust_cnt_cd");
			event.setCustCntCd(custCntCd);
			String custSeq = JSPUtil.getParameter(request, "cust_seq");
			event.setCustSeq(custSeq);
			String creflag = JSPUtil.getParameter(request, "creflag");
			event.setCreflag(creflag);
			String saveflag = JSPUtil.getParameter(request, "saveflag");
			event.setSaveflag(saveflag);
			
			/** 추가 - E **/
			CustomerIntegrationVO customerIntgVO = new CustomerIntegrationVO();
			customerIntgVO.setCustomerVO((CustomerVO)getVO(request, CustomerVO.class,""));
			
			event.setCustomerIntgVO(customerIntgVO);			
			
			// test
			log.debug("\n\n ESM_SAM_0302HTMLAction --------- "
					+ "\n custCntCd : " + JSPUtil.getNull(custCntCd)
					+ "\n custSeq : " + JSPUtil.getNull(custSeq)
					+ " \n\n");

			CustomerVO[] csc = event.getCustomerVOS();
			for (int c=0; csc!=null && c<csc.length; c++){
				log.debug("\n csc["+c+"] : \n"+csc[c].toString()+"\n");
			}
			log.debug("\n\n");

		}else if(command.isCommand(FormCommand.SEARCH08)) {
			event.setIntlNo(request.getParameter("intl_no"));
	    }else if(command.isCommand(FormCommand.SEARCH09)) {
			event.setCustCd(request.getParameter("cust_cnt_cd")+request.getParameter("cust_seq"));
		}else if(command.isCommand(FormCommand.SEARCH10)) {
			event.setSrepCd(request.getParameter("srep_cd"));
	    }else if(command.isCommand(FormCommand.SEARCH11)) {
			event.setCustGrpId(request.getParameter("cust_grp_id"));
	    }else if(command.isCommand(FormCommand.SEARCH12)) {	
	    	event.setCntCd(request.getParameter("cnt_cd"));
	    	event.setSteCd(request.getParameter("ste_cd"));
	    }else if(command.isCommand(FormCommand.SEARCH14)) {	
	    	event.setCustCntCd(request.getParameter("sheet_cust_cnt_cd"));
	    }else if(command.isCommand(FormCommand.SEARCH15)) {
			event.setCustSeq(request.getParameter("cust_seq"));
			event.setCustCntCd(request.getParameter("cust_cnt_cd"));
		}else if(command.isCommand(FormCommand.SEARCH16)) {
			event.setTrdCd(request.getParameter("trd_cd"));
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