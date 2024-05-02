/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_INV_0016_01HTMLAction.java
*@FileTitle : Invoice Item Correction(General)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.04
*@LastModifier : 김세일
*@LastVersion : 1.0
* 2009.06.04 김세일
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.event;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ARCreditInputVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ARInvoiceCreationVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.InvArChgVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.InvArCntrVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.InvArMnVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.InvNewCustVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.ARCorrectionCkVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.ARInvoiceChargeCorrectionVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.ARInvoiceContainerVO;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.nis2010.fns.inv.accountreceivableinvoicemgt 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 AccountReceivableInvoiceMgtSC로 실행요청<br>
 * - AccountReceivableInvoiceMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author saeil kim
 * @see AccountReceivableInvoiceMgtEvent 참조
 * @since J2EE 1.4
 */

public class FNS_INV_0016HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * FNS_INV_0016_01HTMLAction 객체를 생성
	 */
	public FNS_INV_0016HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 AccountReceivableInvoiceMgtEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		FnsInv0016Event event = new FnsInv0016Event();
		 
		if(command.isCommand(FormCommand.MULTI)) {
			
			event.setActInvFlag(request.getParameter("act_inv_flag"));
			event.setOtherFlag(request.getParameter("other_flag"));
			event.setIfNo(request.getParameter("if_no"));
			event.setOtsSmryCd(request.getParameter("ots_smry_cd"));
			event.setModFlag(request.getParameter("mod_flag"));
			event.setInvCustFlg(request.getParameter("inv_cust_flg"));
			
			event.setBlSrcNo(request.getParameter("bl_no"));
			event.setArOfcCd(request.getParameter("ofc_cd"));			
			
			HashMap<String, Object> paramMap = new HashMap<String,Object>();
			paramMap.put("changed_cust_cd", request.getParameter("changed_cust_cd"));
			event.setEventParams(paramMap);
			
			ARInvoiceCreationVO arInvoiceCreationVO = new ARInvoiceCreationVO();
			InvNewCustVO invNewCustVO = new InvNewCustVO();

			InvArMnVO[] invArMnVOList = (InvArMnVO[])getVOs(request, InvArMnVO.class,"sheet1_");
			InvArMnVO invArMnVO = invArMnVOList[0];
			
			invArMnVO.setFrtFwrdCustSeq(request.getParameter("frt_fwrd_cust_seq"));
			invArMnVO.setCgoWgt(request.getParameter("cgo_wgt"));
			invArMnVO.setCgoMeasQty(request.getParameter("cgo_meas_qty"));
			invArMnVO.setBkgFeuQty(request.getParameter("bkg_feu_qty"));
			invArMnVO.setBkgTeuQty(request.getParameter("bkg_teu_qty"));
			invArMnVO.setScNo(request.getParameter("sc_no"));
			invArMnVO.setRfaNo(request.getParameter("rfa_no"));
			invArMnVO.setSrepCd(request.getParameter("srep_cd"));
			invArMnVO.setMstBlNo(request.getParameter("mst_bl_no"));
			invArMnVO.setDueDt(request.getParameter("due_dt"));
			invArMnVO.setBlInvIfDt(request.getParameter("bl_inv_if_dt"));
			invArMnVO.setBlInvCfmDt(request.getParameter("bl_inv_cfm_dt"));
			invArMnVO.setGlEffDt(request.getParameter("gl_eff_dt"));
			invArMnVO.setArOfcCd(request.getParameter("ofc_cd"));			
			invArMnVO.setInvRmk(request.getParameter("inv_rmk"));
			invArMnVO.setBkgRefNo(request.getParameter("bkg_ref_no"));
			invArMnVO.setInvRefNo(request.getParameter("inv_ref_no"));
			invArMnVO.setSiRefNo(request.getParameter("si_ref_no"));
			invArMnVO.setHjsStfCtnt(request.getParameter("hjs_stf_ctnt"));
			invArMnVO.setWhfDeclNo(request.getParameter("whf_decl_no"));
			invArMnVO.setWhfDeclCfmDt(request.getParameter("whf_decl_cfm_dt"));
			invArMnVO.setBkgCorrNo(request.getParameter("bkg_corr_no"));
			invArMnVO.setBkgCorrDt(request.getParameter("bkg_corr_dt"));
			invArMnVO.setActCustCntCd(request.getParameter("act_cust_cnt_cd"));
			invArMnVO.setActCustSeq(request.getParameter("act_cust_seq"));
			invArMnVO.setRevTpCd(request.getParameter("rev_tp_cd"));
			invArMnVO.setRevSrcCd(request.getParameter("rev_src_cd"));
			invArMnVO.setVslCd(request.getParameter("local_vvd").length()==9 ? request.getParameter("local_vvd").substring(0,4) : "");
			invArMnVO.setSkdVoyNo(request.getParameter("local_vvd").length()==9 ?request.getParameter("local_vvd").substring(4,8): "");
			invArMnVO.setSkdDirCd(request.getParameter("local_vvd").length()==9 ?request.getParameter("local_vvd").substring(8,9): "");
			invArMnVO.setSailArrDt(request.getParameter("sail_arr_dt"));
			invArMnVO.setSailDt(request.getParameter("sail_dt"));
			invArMnVO.setSlanCd(request.getParameter("slan_cd"));
			invArMnVO.setIoBndCd(request.getParameter("io_bnd_cd").substring(0,1));
			invArMnVO.setTrnkVslCd(request.getParameter("trunk_vvd").length()==9 ? request.getParameter("trunk_vvd").substring(0,4): "");
			invArMnVO.setTrnkSkdVoyNo(request.getParameter("trunk_vvd").length()==9 ? request.getParameter("trunk_vvd").substring(4,8): "");
			invArMnVO.setTrnkSkdDirCd(request.getParameter("trunk_vvd").length()==9 ? request.getParameter("trunk_vvd").substring(8,9): "");
			invArMnVO.setPorCd(request.getParameter("por_cd"));
			invArMnVO.setPolCd(request.getParameter("pol_cd"));
			invArMnVO.setPodCd(request.getParameter("pod_cd"));
			invArMnVO.setDelCd(request.getParameter("del_cd"));
			invArMnVO.setInvCustCntCd(request.getParameter("inv_cust_cnt_cd"));
			invArMnVO.setInvCustSeq(request.getParameter("inv_cust_seq"));
			invArMnVO.setFrtFwrdCntCd(request.getParameter("frt_fwrd_cnt_cd"));
			invArMnVO.setInvTtlLoclAmt(request.getParameter("inv_ttl_locl_amt"));
			invArMnVO.setUsdXchRt(request.getParameter("usd_xch_rt"));
			invArMnVO.setUpdDt(request.getParameter("upd_dt"));
			invArMnVO.setZnIocCd(request.getParameter("zn_ioc_cd"));
			invArMnVO.setCrTermDys(request.getParameter("cr_term_dys"));
			invArMnVO.setCustCrFlg(request.getParameter("cust_cr_flg"));
			invArMnVO.setXchRtN3rdTpCd(request.getParameter("xch_rt_n3rd_tp_cd"));
			invArMnVO.setXchRtUsdTpCd(request.getParameter("xch_rt_usd_tp_cd"));
			invArMnVO.setXchRtDt(request.getParameter("xch_rt_dt"));
			invArMnVO.setBlSrcNo(request.getParameter("bl_no"));
			invArMnVO.setObrdCd(request.getParameter("obrd_cd"));
			invArMnVO.setArIfNo(request.getParameter("if_no"));
			invArMnVO.setLoclCurrCd(request.getParameter("lcl_curr"));	
			invArMnVO.setDestTrnsSvcModCd(request.getParameter("dest_trns_svc_mod_cd").trim());
			invArMnVO.setInvSvcScpCd(request.getParameter("inv_svc_scp_cd"));
			
			ARCorrectionCkVO arCorrectionCkVO = new ARCorrectionCkVO();
			arCorrectionCkVO.setOfcCd(request.getParameter("ofc"));
			arCorrectionCkVO.setVvdCd(request.getParameter("local_vvd"));
			arCorrectionCkVO.setPod(request.getParameter("pod_cd"));
			arCorrectionCkVO.setPol(request.getParameter("pol_cd"));
			arCorrectionCkVO.setSailingDt(request.getParameter("sail_dt"));
			arCorrectionCkVO.setBkgNo(request.getParameter("bkg_no"));
			arCorrectionCkVO.setRevTpCd(request.getParameter("rev_tp_cd"));
			arCorrectionCkVO.setRevSrcCd(request.getParameter("rev_src_cd"));
			arCorrectionCkVO.setInvCustFlg(request.getParameter("inv_cust_flg"));
			arCorrectionCkVO.setIoBndCd(request.getParameter("io_bnd_cd").substring(0,1));

			event.setArCorrectionCkVO(arCorrectionCkVO);
			event.setARInvoiceChargeCorrectionVOs((ARInvoiceChargeCorrectionVO[])getVOs(request, ARInvoiceChargeCorrectionVO.class,"t2sheet2_"));


			ARInvoiceChargeCorrectionVO list[] = event.getARInvoiceChargeCorrectionVOs();
			
			                                 
			List<InvArChgVO> invArChgVOs = new ArrayList<InvArChgVO>();
			
			for (int t1 = 0; t1 <list.length; t1++) {

				InvArChgVO invArChgVO = new InvArChgVO();

				invArChgVO.setMfDivCd(list[t1].getMfDivCd());
				invArChgVO.setChgCd(list[t1].getChgCd());
				invArChgVO.setCurrCd(list[t1].getCurrCd());
				invArChgVO.setPerTpCd(list[t1].getPerTpCd());
				invArChgVO.setTrfRtAmt(list[t1].getTrfRtAmt());
				invArChgVO.setRatAsCntrQty(list[t1].getRatAsCntrQty());
				invArChgVO.setChgAmt(list[t1].getChgAmt());
				invArChgVO.setInvXchRt(list[t1].getInvXchRt());
				invArChgVO.setArIfNo(request.getParameter("if_no"));
				invArChgVO.setArIfSerNo(list[t1].getArIfSerNo());
				invArChgVO.setChgSeq(list[t1].getChgSeq());
				invArChgVO.setTvaFlg(list[t1].getTvaFlg());
							
				invArChgVOs.add(invArChgVO);
				
			}
			
			event.setARInvoiceContainerVOs((ARInvoiceContainerVO[])getVOs(request, ARInvoiceContainerVO.class,"sheet2_"));
			
			ARInvoiceContainerVO listc[] = event.getARInvoiceContainerVOs();

			List<InvArCntrVO> invArCntrVOs = new ArrayList<InvArCntrVO>();
				if(event.getARInvoiceContainerVOs()!=null){
				for (int t1 = 0; t1 <listc.length; t1++) {
					InvArCntrVO invArCntrVO = new InvArCntrVO();;
					
					invArCntrVO.setArIfNo(request.getParameter("if_no"));
					invArCntrVO.setCntrSeq(listc[t1].getCntrSeq().toString());
					invArCntrVO.setCntrNo(listc[t1].getCntrNo().toString());
					invArCntrVO.setCntrTpszCd(listc[t1].getCntrTpszCd());
	
					invArCntrVOs.add(invArCntrVO);
					
				}
			}
					
			arInvoiceCreationVO.setInvArChgVOs(invArChgVOs);
			arInvoiceCreationVO.setInvArMnVO(invArMnVO);
			arInvoiceCreationVO.setInvArCntrVOs(invArCntrVOs);
			
			invNewCustVO.setInvArChgVOs(invArChgVOs);
			invNewCustVO.setInvArMnVO(invArMnVO);
			invNewCustVO.setInvArCntrVOs(invArCntrVOs);
			invNewCustVO.setUiType("I");
			invNewCustVO.setSplitFlag("C");
			invNewCustVO.setArIfNo(request.getParameter("if_no"));
			invNewCustVO.setOtsSmryCd(request.getParameter("ots_smry_cd"));
			
			event.setArInvoiceCreationVO(arInvoiceCreationVO);
			event.setInvNewCustVO(invNewCustVO);
			event.setInvArMnVOs((InvArMnVO[])getVOs(request, InvArMnVO.class,"sheet5_"));
			
		}
		else if(command.isCommand(FormCommand.SEARCH)) {	//open
			event.setOfcCd(request.getParameter("ofc").trim());
		}
		else if(command.isCommand(FormCommand.SEARCH01)) {	//retrive
			event.setOfcCd(request.getParameter("ofc").trim());
			event.setBlNo(request.getParameter("bl_no").trim());
			event.setInvNo(request.getParameter("str_inv_no").trim());
			event.setOtsSmryCd(request.getParameter("ots_smry_cd").trim());
		}
		else if(command.isCommand(FormCommand.SEARCH02)) {	//due date
			
			ARCreditInputVO arCrdtVo = new ARCreditInputVO();
			arCrdtVo.setActCustCntCd(request.getParameter("act_cust_cnt_cd").trim());
			arCrdtVo.setActCustSeq(request.getParameter("act_cust_seq").trim());
			arCrdtVo.setSailArrDt(request.getParameter("sail_arr_dt").trim().replaceAll("-", ""));
			arCrdtVo.setIoBndCd(request.getParameter("io_bnd_cd").trim().substring(0,1));
			arCrdtVo.setDestTrnsSvcModCd(request.getParameter("dest_trns_svc_mod_cd").trim());
			arCrdtVo.setArOfcCd(request.getParameter("ofc").trim());
			arCrdtVo.setLocCd(request.getParameter("loc_cd").trim().substring(0,2));
			arCrdtVo.setDelCd(request.getParameter("del_cd").trim());

			event.setARCreditInputVO(arCrdtVo);
			
		}else if(command.isCommand(FormCommand.DEFAULT)) {
        	String blSrcNo       = JSPUtil.getParameter(request, "bl_src_no");
            String arOfcCd     = JSPUtil.getParameter(request, "ar_ofc_cd");
            String classId     = JSPUtil.getParameter(request, "classId");
            event.setBlSrcNo(blSrcNo);
            event.setArOfcCd(arOfcCd);
            event.setClassId(classId);
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