
<%
/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName   : ESM_BKG_0079_09.js
 *@FileTitle  : Cancel Issue Release
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/05/28
===============================================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.event.EsmBkg007909Event"%>
<%@ page import="com.clt.framework.core.controller.DefaultViewAdapter"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.core.view.template.Screen"%>
<%@ page import="com.clt.framework.core.controller.util.WebKeys"%>
<%@ page import="org.apache.log4j.Logger"%>
<%@ page import="com.clt.apps.opus.bcm.sup.valuemanage.util.ModuleMgr"%>
<%
	
	Logger log = Logger.getLogger("com.clt.apps.OutboundBLMgt.BLIssuance");
	EsmBkg007909Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //error from server
	String strErrMsg = ""; //error message
	int rowCount = 0; //count of DB resultSET list

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";
	String bkgNo = "";

	String strUsr_id = "";
	String strUsr_nm = "";
	String strOfc_cd = "";
	String isInquiry = "N";
	String inetFtpAuthFlg = "N";
	
	String sXml = null;
	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
		event = (EsmBkg007909Event) request.getAttribute("Event");
		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		bkgNo  = JSPUtil.getParameter(request, "bkg_no");
		Screen screen = (Screen) request.getAttribute(WebKeys.CURRENT_SCREEN);
		//inquiry mode
		if (screen.getName().indexOf("Q") >= 0){
			isInquiry = "Y";
		} else {
			isInquiry = "N";			
		}
		// getting data from server when load the initial screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		if("1".equals(eventResponse.getETCData("INET_FTP_AUTH_FLG"))){
			inetFtpAuthFlg="Y";
		}else{
			inetFtpAuthFlg="N";
		}
		
		DefaultViewAdapter adapter = new DefaultViewAdapter();
		sXml = adapter.makeXML(request, response);		
	} catch (Exception e) {
		out.println(e.toString());
	}
%>
<!--M2Soft(RD) 제품 include -->
<link rel="stylesheet" type="text/css" href="rpt/css/crownix-viewer.min.css">
<script type="text/javascript" src="rpt/js/crownix-viewer.min.js"></script>
<!--M2Soft(RD) 제품 include -->
<script language="javascript" src="/opuscntr/rpt/script/common_rd.js"></script>
<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="frm">
<input type="hidden" name="sXml" value="<%=JSPUtil.replace(sXml, "\"", "&quot;")%>" id="sXml">
</form>
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="strUsr_id" value="<%=strUsr_id%>" id="strUsr_id" />
<input type="hidden" name="strOfc_cd" value="<%=strOfc_cd%>" id="strOfc_cd" />
 
<input type="hidden" name="bkg_no" value="<%=bkgNo%>" id="bkg_no" />
<input type="hidden" name="bl_no" value="<%=JSPUtil.getParameter(request, "bl_no")%>" 	id="bl_no" />
<input type="hidden" name="frm_t11sheet1_doc_proc_modyflg" 								id="frm_t11sheet1_doc_proc_modyflg" />
<input type="hidden" name="frm_t11sheet1_doc_proc_type" 								id="frm_t11sheet1_doc_proc_type" />
<input type="hidden" name="frm_t11sheet1_doc_proc_seq" 									id="frm_t11sheet1_doc_proc_seq" />
<input type="hidden" name="frm_t11sheet1_doc_request_flag" 								id="frm_t11sheet1_doc_request_flag" />
<input type="hidden" name="frm_t11sheet1_auth_flag" 									id="frm_t11sheet1_auth_flag" />
<input type="hidden" name="frm_t11sheet1_internet_auth" 								id="frm_t11sheet1_internet_auth" />
<input type="hidden" name="frm_t11sheet1_tpb_indicator" 								id="frm_t11sheet1_tpb_indicator" />
<input type="hidden" name="frm_t11sheet1_tpb_status" 									id="frm_t11sheet1_tpb_status" />
<input type="hidden" name="frm_t11sheet1_black_customer_flag" 							id="frm_t11sheet1_black_customer_flag" />
<input type="hidden" name="frm_t11sheet1_flg_rate" 										id="frm_t11sheet1_flg_rate" />
<input type="hidden" name="frm_t11sheet1_flg_md" 										id="frm_t11sheet1_flg_md" />
<input type="hidden" name="frm_t11sheet1_flg_ppd" 										id="frm_t11sheet1_flg_ppd" />
<input type="hidden" name="frm_t11sheet1_flg_to_order" 									id="frm_t11sheet1_flg_to_order" />
<input type="hidden" name="frm_t11sheet1_flg_do" 										id="frm_t11sheet1_flg_do" />
<input type="hidden" name="frm_t11sheet1_cgo_rcv_dt" 									id="frm_t11sheet1_cgo_rcv_dt" />
<input type="hidden" name="vessel_direction" 											id="vessel_direction" />
<input type="hidden" name="pre_carriage_by" 											id="pre_carriage_by" />
<input type="hidden" name="oaXmlData" 													id="oaXmlData" />
<!-- TPB Status --> 
<input type="hidden" name="tpb_status" 													id="tpb_status" />
<input type="hidden" name="chg_ready" 													id="chg_ready" />
<input type="hidden" name="mk_ready" 													id="mk_ready" />
<input type="hidden" name="chg_ppd_ind" 												id="chg_ppd_ind" />
<input type="hidden" name="chg_ppd_third_ind" 											id="chg_ppd_third_ind" />
<input type="hidden" name="cust_cnt" 													id="cust_cnt" />
<input type="hidden" name="cntr_cnt" 													id="cntr_cnt" />
<input type="hidden" name="rate_cnt" 													id="rate_cnt" />
<input type="hidden" name="mnd_cnt" 													id="mnd_cnt" />
<input type="hidden" name="setupfocoblflag" value="N" 									id="setupfocoblflag" />
<input type="hidden" name="frm_t11sheet1_cust_to_ord_flg" 								id="frm_t11sheet1_cust_to_ord_flg" />
<input type="hidden" name="buttonType" 													id="buttonType" />
<input type="hidden" name="caflag" value="" 											id="caflag" />
<input type="hidden" name="bdrflag" value="" 											id="bdrflag" />
<input type="hidden" name="ca_exist_flg" value="" 										id="ca_exist_flg" />
<input type="hidden" class="noinput" name="modify_flag" value="N" 						id="modify_flag" />
<input type="hidden" name="isInquiry" value="<%=isInquiry%>" 							id="isInquiry" />
<!-- FTP 전송용 파라메터 -->
<input type="hidden" name="totalpage" 													id="totalpage" /> 
<input type="hidden" name="totalunrated" 												id="totalunrated" /> 
<input type="hidden" name="inetFtpAuthFlg"												id="inetFtpAuthFlg" value="<%=inetFtpAuthFlg%>"/> 
<!-- Doc Req. -->
<input type="hidden" name="docRqstTtl" 													id="docRqstTtl" /> 

<!-- opus_design_btn(S) -->
<div class="opus_design_btn opus_design_normal2">
		<button type="button" class="btn_normal2" name="btn_t11Retrieve" 		id="btn_t11Retrieve">Retrieve</button><!-- 
	 --><button type="button" class="btn_normal2" name="btn_t11New"  			id="btn_t11New">New</button><!-- 
	 --><button type="button" class="btn_normal2" name="btn_t11Save" 			id="btn_t11Save">Save</button><!-- 
	 --><!-- <button type="button" class="btn_normal2" name="btn_t11OBLRelease" 		id="btn_t11OBLRelease">O.B/L Release</button> --><!-- 
	 --><button type="button" class="btn_normal2" name="btn_t11BLRelease" 		id="btn_t11BLRelease">O.B/L / SWB Release</button><!--
	 --><button type="button" class="btn_normal2" name="btn_t11FtpSend" 		id="btn_t11FtpSend">FTP Send</button><!--
	 --><button type="button" class="btn_normal2" name="btn_t11InternetAUTH"		id="btn_t11InternetAUTH">Internet Auth</button><!-- 
	 --><button type="button" class="btn_normal2" name="btn_t11CancelAUTH" 		id="btn_t11CancelAUTH" 		style="display:none;">Cancel Auth</button><!-- 
	 --><!-- <button type="button" class="btn_normal2" name="btn_t11SWBRelease" 		id="btn_t11SWBRelease">SWB Release</button>--><!-- 
	 --><button type="button" class="btn_normal2" name="btn_t11CancelRelease" 	id="btn_t11CancelRelease">Issue/Release Cancel</button><br/><!-- 
	 --><button type="button" class="btn_normal2" name="btn_t11OBLSurrender" 	id="btn_t11OBLSurrender">O.B/L Surrender</button><!-- 	
	 --><button type="button" class="btn_normal2" name="btn_t11BLPrint" 			id="btn_t11BLPrint">B/L Print</button><!-- 
	 --><button type="button" class="btn_normal2" name="btn_t11SWBEmail"  		id="btn_t11SWBEmail">SWB E-mail</button>
</div>
<!-- opus_design_btn(E) -->

<!-- wrap_search (S) -->
<div class="wrap_search coupled_btn_normal2">
	<div class="opus_design_inquiry wFit"> 
		<table> 
        	<colgroup>
				<col width="55"/>
				<col width="150"/>
        		<col width="80" />
        		<col />
        	</colgroup>
			<tbody>
				<tr>
					<th>BKG No.</th>
					<td>
						<input type='text' name='frm_t11sheet1_bkg_no' id='frm_t11sheet1_bkg_no' style='width: 110px;' class='input1' dataformat="engup"  maxlength="13" value='<%=bkgNo%>'><!--
						--><button type="button" class="btn_down_list" name="btn_splitPop" id="btn_splitPop"></button>
					</td>
					<th>B/L No.</th>
					<td>
						<input type='text' name='frm_t11sheet1_bl_no' 	id='frm_t11sheet1_bl_no' style='width: 110px;' dataformat="engup"  maxlength="13"  value='' class='input1'>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
<!-- wrap_search (E) -->

<!-- wrap_result (S) -->
<div class="wrap_result coupled_btn_normal2">

			<!-- opus_design_inquiry (1) (S) -->
			<div class="opus_design_inquiry wFit mar_btm_none" >
				<table>
					<colgroup>
						<col width="55"/>
						<col width="95"/>
						<col width="65"/>
						<col width="50"/>
						<col width="60"/>
						<col width="165"/>
						<col />
				    </colgroup>
					<tbody>
						<tr>
							<th>T/VVD</th>
							<td>
								<input type="text" name="frm_t11sheet1_tvvd" 	id="frm_t11sheet1_tvvd" style="width: 85px;" value=""  class="input2" readonly>
							</td>
							<th>Status</th>
							<td>
								<input type="text" name="frm_t11sheet1_bkg_sts" id="frm_t11sheet1_bkg_sts" style="width: 20px;" value=""  class="input2" readonly>
							</td>
							<th>BDR&nbsp;
								<input type="checkbox" name="check_bdr" value="" class="trans" disabled><!-- 
								 --><input type="hidden" name="frm_t11sheet1_bdr" 	id="frm_t11sheet1_bdr">
							</th>
							<th>SHPR Name</th>
							<td>
								<input type="text" name="frm_t11sheet1_shpr_name" 		id="frm_t11sheet1_shpr_name" style="width: 300px;" value=""  class="input" readonly>
							</td>
						</tr>
					</tbody>
				</table>
				<table>
					<colgroup>
						<col width="55"/>
						<col width="350"/>
						<col width="85"/>
						<col />
				    </colgroup>
					<tbody>
						<tr>
							<th>Address</th>
							<td>
								<input type="text" name="frm_t11sheet1_shpr_address" 	id="frm_t11sheet1_shpr_address" style="width: 320px;" value="" class="input" readonly>
							</td>
							<th>F/FWD Name</th>
							<td>
								<input type="text" name ='f_fwd_name' 					id ='f_fwd_name' style="width: 300px;" value="" class="input mar_rgt_none" readonly><!-- 
								 --><input type='hidden' name ='frm_t11sheet1_f_fwd_name' 	id ='frm_t11sheet1_f_fwd_name'><!-- 
								 --><input type='hidden' name ='frm_t11sheet1_f_fwd_address' id ='frm_t11sheet1_f_fwd_address'><!-- 
							 --></td>				
						</tr>
					</tbody>
				</table>
				<table class="line_bluedot"><tr><td></td></tr></table>
			</div>
			<!-- opus_design_inquiry (1) (E) -->
			
			<!-- layout_wrap (1) (S) -->
			<div class="layout_wrap">
			
				<!-- layout_vertical_2 (1) (S) -->
			    <div class="layout_flex_fixed" style="width:500px">
			    	<div class="opus_design_inquiry sm">
						<h3 class="title_design2">VESSEL</h3>
						<table>
							<colgroup>
								<col width="160"/>
								<col />
						    </colgroup>
							<tbody>
								<tr>
									<th>Vessel Voyage Direction</th>
									<td>
										<script type="text/javascript">ComComboObject('select_vessel_direction', 1, 317, 0,0,0,true);</script>
										<input type="hidden" name="frm_t11sheet1_vessel_direction" id="frm_t11sheet1_vessel_direction">
									</td>
								</tr>
								<tr>
									<th>Pre-Carriage By</th>
									<td>
										<script type="text/javascript">ComComboObject('select_pre_carriage_by', 1, 317, 0, 0, 0, true);</script>
										<input type="hidden" name="frm_t11sheet1_pre_carriage_by" id="frm_t11sheet1_pre_carriage_by">
									</td>
								</tr>
							</tbody>
						</table>
					</div>
						
			    	<div class="opus_design_inquiry sm">
						<h3 class="title_design2">ROUTE</h3>
						<table>
							<colgroup>
								<col width="43"/>
								<col width="65"/>
								<col />
						    </colgroup>
							<tbody>
								<tr>
									<th title="Place of Receipt">POR</th>
									<td><input type="text" name="frm_t11sheet1_por_code" id="frm_t11sheet1_por_code" style="width: 58px;" value="" class="input2" readonly dataformat="enguponly"><!----></td>
									<td><input type="text" name="frm_t11sheet1_por_name" id="frm_t11sheet1_por_name" style="width: 341px;" value="" class="input" maxlength="25" dataformat="engup" otherchar="<%=getSpecialChars()%>" onpaste="javascript:mousePaste(this)"><button type="button" class="btn_down_list" id="pop_por" name="pop_por"></button>
								</tr>
								<tr>
									<th title="Port of Loading">POL</th>
									<td><input type="text" name="frm_t11sheet1_pol_code" id="frm_t11sheet1_pol_code" style="width: 58px;" value="" class="input2" readonly dataformat="enguponly"><!----></td>						
									<td><input type="text" name="frm_t11sheet1_pol_name" id="frm_t11sheet1_pol_name" style="width: 341px;" value="" class="input" maxlength="25" dataformat="engup" otherchar="<%=getSpecialChars()%>" onpaste="javascript:mousePaste(this)"><button type="button" class="btn_down_list" id="pop_pol" name="pop_pol"></button>
									</td>					
								</tr>
								<tr>
									<th title="Port of Discharging">POD</th>					
									<td>
										<input type="text" name="frm_t11sheet1_pod_code" id="frm_t11sheet1_pod_code" style="width: 58px;" value="" class="input2" readonly dataformat="enguponly"><!---->
									</td>
									<td>
										<input type="text" name="frm_t11sheet1_pod_name" id="frm_t11sheet1_pod_name" style="width: 341px;" value="" class="input" maxlength="25" dataformat="engup" otherchar="<%=getSpecialChars()%>" onpaste="javascript:mousePaste(this)"><button type="button" class="btn_down_list" id="pop_pod" name="pop_pod"></button>
									</td>					
								</tr>
								<tr>
									<th title="Place of Delivery">DEL</th>					
									<td>
										<input type="text" name="frm_t11sheet1_del_code" id="frm_t11sheet1_del_code" style="width: 58px;" value="" class="input2" readonly dataformat="enguponly">
									</td>
									<td>
										<input type="text" name="frm_t11sheet1_del_name" id="frm_t11sheet1_del_name" style="width: 341px;" value="" class="input" maxlength="25" dataformat="engup" otherchar="<%=getSpecialChars()%>" onpaste="javascript:mousePaste(this)"><button type="button" class="btn_down_list" id="pop_del" name="pop_del"></button>
									</td>					
								</tr>
								<tr>
									<th colspan="2">Move Type</th>					
									<td>
										<script type="text/javascript">ComComboObject('move_type', 2, 200, 1, 0, 1)</script><input type="hidden" name="frm_t11sheet1_move_type" id="frm_t11sheet1_move_type"/>
										(<label for="exID02">Print</label><input type="checkbox" name="frm_t11sheet1_bl_mv_tp_prn_flg" class="trans" value="Y" id="exID02" checked />&nbsp;)
										<%--
										<input type="text" name="frm_t11sheet1_move_type" id="frm_t11sheet1_move_type" style="width: 370px;" value="" class="input" maxlength="25" dataformat="engup" otherchar="<%=getSpecialChars()%>">
										 --%>
									</td>					
								</tr>
								<tr>
									<th colspan="2">R/D Term</th>					
									<td>
										(<label for="exID02">Print</label><input type="checkbox" name="frm_t11sheet1_rcv_de_term_prn_flg" class="trans" value="Y" id="exID02" checked />&nbsp;)
									</td>					
								</tr>
								<tr>
									<th colspan="2">Final Dest.</th>
									<td>
										<input type="text" name="frm_t11sheet1_final_dest" id="frm_t11sheet1_final_dest" style="width: 370px;" value="" class="input" maxlength="25" dataformat="engup" otherchar="<%=getSpecialChars()%>">
									</td>
								</tr>
							</tbody>
						</table>
					</div>
						
			    	<div class="opus_design_inquiry sm" style="padding-bottom:23px">
						<h3 class="title_design2">FREIGHT RECEIVE</h3>
						<table class="grid_2" style="width:478px;">
							<colgroup>
								<col width="65"/>
								<col width="40"/>
								<col width="60"/>
								<col width="90"/>
								<col width="*" />
						    </colgroup>
							<thead>
								<tr>
									<th>Term</th>
									<th>RCV</th>
									<th>Office</th>
									<th>By</th>
									<th>Date</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<th>PPD (Org.)</th>
									<td class="input2"><input type="text" style="width: 100%;text-align:center;" name="frm_t11sheet1_ppd_confirm" value=""   class="noinput2" readonly></td>
									<td class="input2"><input type="text" style="width: 100%;" name="frm_t11sheet1_ppd_rcv_user_office" id="frm_t11sheet1_ppd_rcv_user_office" value=""   class="noinput2" dataformat="engup" maxlength="6" readonly></td>
									<td class="input2"><input type="text" style="width: 100%;" name="frm_t11sheet1_ppd_rcv_user_id" id="frm_t11sheet1_ppd_rcv_user_id" value=""   class="noinput2" readonly></td>
									<td class="input2"><input type="text" style="width: 100%;" name="frm_t11sheet1_ppd_rcv_dt" id="frm_t11sheet1_ppd_rcv_dt" value=""   dateformat="ymd" class="noinput2" readonly></td>
								</tr>
								<tr>
									<th style="text-align:center">PPD (3rd)</th>
									<td class="input2"><input type="text" style="width: 100%;text-align:center;" name="frm_t11sheet1_trd_ppd_confirm" value=""   class="noinput2" readonly></td>
									<td class="input2"><input type="text" style="width: 100%;" 	name="frm_t11sheet1_trd_ppd_rcv_user_office" id="frm_t11sheet1_trd_ppd_rcv_user_office" value="" class="noinput2" dataformat="engup" maxlength="6" readonly></td>
									<td class="input2"><input type="text" style="width: 100%;" name="frm_t11sheet1_trd_ppd_rcv_user_id" id="frm_t11sheet1_trd_ppd_rcv_user_id" value="" class="noinput2" readonly></td>
									<td class="input2"><input type="text" style="width: 100%;" name="frm_t11sheet1_trd_ppd_rcv_dt" id="frm_t11sheet1_trd_ppd_rcv_dt" value="" class="noinput2" readonly></td>
								</tr>
								<tr>
									<th style="text-align:center">CCT (Dest.)</th>
									<td class="input2"><input type="text" style="width: 100%;text-align:center;" name="frm_t11sheet1_cct_confirm" value=""   class="noinput2" readonly></td>
									<td class="input2"><input type="text" style="width: 100%;"  name="frm_t11sheet1_cct_rcv_user_office" id="frm_t11sheet1_cct_rcv_user_office" value="" class="noinput2" dataformat="engup" maxlength="6" readonly></td>
									<td class="input2"><input type="text" style="width: 100%;" name="frm_t11sheet1_cct_rcv_user_id" id="frm_t11sheet1_cct_rcv_user_id" value="" class="noinput2" readonly></td>
									<td class="input2"><input type="text" style="width: 100%;" name="frm_t11sheet1_cct_rcv_dt" id="frm_t11sheet1_cct_rcv_dt" value="" class="noinput2" readonly></td>
								</tr>
								<tr>
									<th style="text-align:center">CCT (3rd)</th>
									<td class="input2"><input type="text" style="width: 100%;text-align:center;" name="frm_t11sheet1_trd_cct_confirm" value=""   class="noinput2" readonly></td>
									<td class="input2"><input type="text" style="width: 100%;"  name="frm_t11sheet1_trd_cct_rcv_user_office" id="frm_t11sheet1_trd_cct_rcv_user_office" value="" class="noinput2" dataformat="engup" maxlength="6" readonly></td>
									<td class="input2"><input type="text" style="width: 100%;" name="frm_t11sheet1_trd_cct_rcv_user_id" id="frm_t11sheet1_trd_cct_rcv_user_id" value="" class="noinput2" readonly></td>
									<td class="input2"><input type="text" style="width: 100%;" name="frm_t11sheet1_trd_cct_rcv_dt" id="frm_t11sheet1_trd_cct_rcv_dt" value="" class="noinput2" readonly></td>
								</tr>
							</tbody>
						</table>
						<table class="line_bluedot"><tr><td></td></tr></table>
						<table>
							<colgroup>
								<col width="100">
								<col />
							</colgroup>
							<tbody>
								<tr>
									<th>3rd Party Billing</th>
									<td>
										<img src="img/btng_icon_g.gif" width="13" height="13" alt="" border="0" align="absmiddle" id="tpb_icon">&nbsp;<!-- 
										 --><input type="text" class="input" style="width: 20px; text-align: center" name='tpb_cd' id='tpb_cd' value="" readonly><!-- 
										 --><%
											 if(ModuleMgr.isUsed(ModuleMgr.MODULE_TPB)){
										%><!-- 
											 --><button type="button" class="input_seach_btn" name="pop_tpb" id="pop_tpb"></button><!-- 
										 --><% 
											 }else{
										 %><!-- 
											 --><button type="button" class="input_seach_btn" disabled="disabled"></button><!-- 
										 --><%
											}
										%>
									</td>
								</tr>
							</tbody>
						</table>
					</div>
					
			    </div>
				<!-- layout_vertical_2 (1) (E) -->
			    
			    
				<!-- layout_vertical_2 (2) (S) -->
			    <div class="layout_flex_flex" style="padding-left:508px">
			    	<div class="opus_design_inquiry sm">
						<h3 class="title_design2">B/L DATA COMPLETE</h3>
				        <table class="mar_left_12">
							<colgroup>
								<col width="37"/>
								<col width="20"/>
								<col width="70"/>
								<col width="20"/>
								<col width="120"/>
								<col width="45"/>
								<col width="120"/>
								<col width="40"/>
								<col/>
						    </colgroup>
							<tbody>
								<tr>
									<td class="align_center"><input type="checkbox" name="bl_ready_checkbox" id="bl_ready_checkbox" value="Y" class="trans" onclick='fnBlReadyCheckbox(this)'></td>
									<th>At<input type="hidden" name="frm_t11sheet1_bl_ready_checkbox" id="frm_t11sheet1_bl_ready_checkbox"/></th>						
									<td><input type="text" style="width: 50px;"  name="frm_t11sheet1_bl_ready_office" id="frm_t11sheet1_bl_ready_office" value="" dataformat="engup" maxlength="8" class="input"></td>
									<th>By</th>
									<td><input type="text" style="width: 115px;" name="frm_t11sheet1_bl_ready_by" id="frm_t11sheet1_bl_ready_by" value="" dataformat="eng" maxlength="8" class="input"></td>
									<th>Date</th>
									<td>
										<input type="text" style="width: 80px;ime-mode:disabled" name="frm_t11sheet1_bl_ready_date" id="frm_t11sheet1_bl_ready_date" maxlength="10" dataformat="ymd" value="" class="input"><!-- 
										 --><button type="button" class="calendar ir" name="pop_bl_ready_date" id="pop_bl_ready_date"></button></td>
									<th>Type</th>
									<td><script type="text/javascript">ComComboObject('bl_ready_type', 2, 35, 1)</script><input type="hidden" name="frm_t11sheet1_bl_ready_type" id="frm_t11sheet1_bl_ready_type"/></td>
								</tr>
							</tbody>
						</table>
					</div>
					
					
			    	<div class="opus_design_inquiry sm">
						<h3 class="title_design2">B/L CONFIRM BY SHIPPER</h3>
				        <table class="mar_left_12">
							<colgroup>
								<col width="37"/>
								<col width="20"/>
								<col width="70"/>
								<col width="20"/>
								<col width="120"/>
								<col width="45"/>
								<col width="130"/>
								<col/>
						    </colgroup>
							<tbody>
								<tr>
									<td class="align_center"><input type="checkbox" name="bl_proofbyshipper_checkbox" id="bl_proofbyshipper_checkbox" value="Y" class="trans" onclick='fnBlProofbyshipperCheckbox(this)'></td>
									<th>At<input type="hidden" name="frm_t11sheet1_bl_proofbyshipper_checkbox"/></th>	
									<td><input type="text" style="width: 50px;"  name="frm_t11sheet1_bl_proofbyshipper_office" id="frm_t11sheet1_bl_proofbyshipper_office" value="" dataformat="engup" maxlength="8" class="input"></td>					
									<th>By</th>
									<td><input type="text" style="width: 115px;" name="frm_t11sheet1_bl_proofbyshipper_by" id="frm_t11sheet1_bl_proofbyshipper_by" value=""  dataformat="eng" maxlength="8" class="input"></td>
									<th>Date</th>
									<td><input type="text" style="width: 80px;ime-mode:disabled"  name="frm_t11sheet1_bl_proofbyshipper_date" id="frm_t11sheet1_bl_proofbyshipper_date" maxlength="10" dataformat="ymd" value="" class="input"><!-- 
										 --><button type="button" class="calendar ir" name="pop_bl_proofbyshipper_date" id="pop_bl_proofbyshipper_date"></button></td>
									<td><button type="button" class="btn_etc"    name="btn_t11Doc_Requirement" 	id="btn_t11Doc_Requirement">Doc Req.</button></td>
								</tr>
							</tbody>
						</table>
					</div>
					
					
			    	<div class="opus_design_inquiry sm">
						<h3 class="title_design2">ON BOARD</h3>
				        <table class="mar_left_12">
							<colgroup>
								<col width="60"/>
								<col width="60"/>
								<col width="49"/>
								<col width="130"/>
								<col width="30"/>
								<col width="104"/>
								<col />
						    </colgroup>
							<tbody>
								<tr>
									<th>Type</th>
									<td><script type="text/javascript">ComComboObject('on_board_type', 2, 35, 1)</script><input type="hidden" name="frm_t11sheet1_on_board_type" id="frm_t11sheet1_on_board_type"></td>
									<td><input type="checkbox" name="date_set_checkbox" id="date_set_checkbox" value="Y" class="trans" onclick='fnDateSetCheckbox(this)'>&nbsp;<strong>Date</strong><input type="hidden" name="frm_t11sheet1_date_set_checkbox" id="frm_t11sheet1_date_set_checkbox"/></td>					
									<td><input type="text" style="width: 75px;ime-mode:disabled" name="frm_t11sheet1_on_board_date" id="frm_t11sheet1_on_board_date" maxlength="10" dataformat="ymd" value="" class="input"><!-- 
										 --><button type="button" class="calendar ir" name="pop_on_board_date" id="pop_on_board_date"></button></td>
									<th>ETD</th>
									<td><input type="text" style="width: 75px;" name="frm_t11sheet1_pol_etd_dt" id="frm_t11sheet1_pol_etd_dt" value="" class="input2" readonly></td>
									<td><button type="button" class="btn_etc" name="btn_t11TS_Route" 	id="btn_t11TS_Route">T/S Route</button></td>
								</tr>
							</tbody>
						</table>
					</div>
					
					
			    	<div class="opus_design_inquiry sm">
						<h3 class="title_design2">B/L ISSUE</h3>
				        <table class="mar_left_12">
							<colgroup>
								<col width="37"/>
								<col width="20"/>
								<col width="66"/>
								<col width="80"/>
								<col width="20"/>
								<col width="90"/>
								<col width="60"/>
								<col width="130"/>
								<col/>
						    </colgroup>
							<tbody>
								<tr>
									<th colspan="2">B/L Type</th>
									<td colspan="2">
										<div onMouseOver='fngBkgToolTipView("frm_t11sheet1_bl_iss_tp_cd");' onmousemove="fngBkgToolTipMove(event)" onmouseout="fngBkgToolTipHide()">
										<input type="text" style="width:30px;cursor: pointer;" name="frm_t11sheet1_bl_iss_tp_cd" id="frm_t11sheet1_bl_iss_tp_cd" value="" class="input2" readonly>
										<script type="text/javascript">ComComboObject('bl_issuebl_type', 2, 105, 1, 0, 1)</script>
										<input type="hidden" name="frm_t11sheet1_bl_issuebl_type" id="frm_t11sheet1_bl_issuebl_type">
										</div>
									</td>
									<th>No.</th>
									<td><input type="text" style="width: 30px;" name="frm_t11sheet1_bl_issue_no" id="frm_t11sheet1_bl_issue_no" value="" dataformat="num" maxlength="1" style="ime-mode:disabled" class="input"></td>
									<th>Copy</th>
									<td><input type="text" style="width: 30px;" name="frm_t11sheet1_bl_cpy_no" id="frm_t11sheet1_bl_cpy_no" dataformat="num" maxlength="2" value="" style="ime-mode:disabled" class="input"></td>	
									<td align="left" style="color: red;"><span id="web_print_approved"/></span></td>
								</tr>
								<tr>
									<td class="align_center"><input type="checkbox" name="IssuerSet_checkbox" id="IssuerSet_checkbox" value="Y" class="trans" onclick='fnIssuerSetCheckbox(this)' class="trans"></td>
									<th>At</th>
									<td colspan="2"><input type="text" style="width: 55px;" name="frm_t11sheet1_bl_issue_at" id="frm_t11sheet1_bl_issue_at" dataformat="engup"  maxlength="5" value="" class="input"></td>
									<th>By</th>
									<td><input type="text" style="width: 80px;" name="frm_t11sheet1_bl_issue_by" id="frm_t11sheet1_bl_issue_by" dataformat="eng"  maxlength="8" value="" class="input"></td>						
									<th>Date</th>
									<td><input type="text" style="width:75px;ime-mode:disabled" name="frm_t11sheet1_bl_issue_date" id="frm_t11sheet1_bl_issue_date" maxlength="10" dataformat="ymd" value="" class="input"><!-- 
										 --><button type="button" class="calendar ir" name="pop_bl_issue_date" id="pop_bl_issue_date"></button></td>	
									<td><button type="button" class="btn_etc" name="btn_t11Issue" 	id="btn_t11Issue">Issue</button></td>
								</tr>
								<tr>
									<th colspan="2">Issued</th>
									<td><input type="text" style="width: 30px;" name="frm_t11sheet1_issued" id="frm_t11sheet1_issued" value="" class="input2" readonly></td>
									<th colspan="2">O.B/L Printed</th>
									<td><input type="text" style="width: 30px;" name="frm_t11sheet1_obl_prn_flg" id="frm_t11sheet1_obl_prn_flg" value="" class="input2" readonly></td>
									<th>Released</th>
									<td><input type="text" style="width: 30px;" name="frm_t11sheet1_released" id="frm_t11sheet1_released" value="" class="input2" readonly></td>
								</tr>
								<tr>
									<th colspan="3">Internet Control Party</th>
									<td colspan="6">
										<input type="text" style="width: 30px;text-transform:uppercase;" name="frm_t11sheet1_inet_ctrl_pty_nm" id="frm_t11sheet1_inet_ctrl_pty_nm" value ="" class="input" maxlength="2" dataformat="engup" ><!--
										--><button type="button" id="btn_inetCtrlPtyNo" name="btn_inetCtrlPtyNo" class="input_seach_btn"></button><!--
										--><input type="text" name="frm_t11sheet1_inet_ctrl_pty_no" id="frm_t11sheet1_inet_ctrl_pty_no" style="width:58px;" class="input" value="" maxlength=6  dataformat="num" onblur="javascript:bkg007909_blur();"><!--
										--><input type="text" style="width:145px;" class="input2" value="" name="frm_t11sheet1_inet_ctrl_pty_cust_nm" readonly="" id="frm_t11sheet1_inet_ctrl_pty_cust_nm" />
									</td>
								</tr>
							</tbody>
						</table>
					</div>
					
				
			    	<div class="opus_design_inquiry sm">
						<h3 class="title_design2">O.B/L RECEIVE</h3>
				        <table class="mar_left_12">
							<colgroup>
								<col width="30"/>
								<col width="35"/>
								<col width="20"/>
								<col width="35"/>
								<col width="30"/>
								<col width="98"/>
								<col width="20"/>
								<col width="98"/>
								<col width="20"/>
								<col width="95"/>
								<col width="65"/>
								<col />
						    </colgroup>
							<tbody>
								<tr>
									<th>Type</th>
									<td onMouseOver='fngBkgToolTipView("frm_t11sheet1_o_blreceive_type");' onMouseMove='fngBkgToolTipMove(event)' onMouseOut='fngBkgToolTipHide();'>
										<input type="text" style="width:20px;cursor: pointer;" name="frm_t11sheet1_o_blreceive_type" id="frm_t11sheet1_o_blreceive_type" value="" class="input2" readonly></td>
									<th>No</th>
									<td><input type="text" style="width: 20px;" name="frm_t11sheet1_o_blreceive_no" id="frm_t11sheet1_o_blreceive_no" value="" class="input2" readonly></td>
									<th>Date</th>
									<td><input type="text" style="width: 85px;" name="frm_t11sheet1_o_blreceive_date" id="frm_t11sheet1_o_blreceive_date" value="" class="input2" readonly></td>
									<th>At</th>
									<td><input type="text" style="width: 85px;" name="frm_t11sheet1_o_blreceive_at" id="frm_t11sheet1_o_blreceive_at" value="" class="input2" readonly></td>
									<th>By</th>
									<td><input type="text" style="width: 85px;" name="frm_t11sheet1_o_blreceive_by" id="frm_t11sheet1_o_blreceive_by" value="" class="input2" readonly></td>
									<th>Surrender</th>
									<td><input type="text" style="width: 30px;" name="frm_t11sheet1_surrender" id="frm_t11sheet1_surrender" value="" class="input2" readonly></td>
								</tr>
							</tbody>
						</table>
					</div>
	
	
			    	<div class="opus_design_inquiry sm">
						<h3 class="title_design2">D/O ISSUE</h3>
				        <table class="mar_left_12">
							<colgroup>
								<col width="30"/>
								<col width="120"/>
								<col width="35"/>
								<col width="111"/>
								<col width="20"/>
								<col width="122"/>
								<col width="20"/>
								<col />
						    </colgroup>
							<tbody>
								<tr>
									<th>No</th>
									<td><input type="text" style="width: 95px;" name="frm_t11sheet1_do_issue_no" id="frm_t11sheet1_do_issue_no" value="" class="input2" readonly></td>
									<th>Date</th>
									<td><input type="text" style="width: 85px"  name="frm_t11sheet1_do_issue_date" id="frm_t11sheet1_do_issue_date" value="" class="input2" readonly></td>
									<th>At</th>
									<td><input type="text" style="width: 95px;" name="frm_t11sheet1_do_issue_at" id="frm_t11sheet1_do_issue_at" value="" class="input2" readonly></td>
									<th>By</th>
									<td><input type="text" style="width: 85px;"  name="frm_t11sheet1_do_issue_by" id="frm_t11sheet1_do_issue_by" value="" class="input2" readonly></td>
								</tr>
							</tbody>
						</table>
					</div>
					
			    	<div class="opus_design_inquiry sm">
				        <table>
							<colgroup>
								<col width="50"/>
								<col />
						    </colgroup>
							<tbody>
								<tr>
									<th><button type="button" class="btn_etc" name="btn_t11Remark" 	id="btn_t11Remark">Remark(s)</button></th><!-- <button type="button" class="btn_etc" name="btn_t11Issue" 	id="btn_t11Issue">Issue</button> -->
									<td><textarea name="frm_t11sheet1_obl_iss_rmk" id="frm_t11sheet1_obl_iss_rmk" style="width: 100%; height: 40px; resize:none;" dataformat="engup" otherchar="<%=getSpecialChars()%>" onpaste="javascript:mousePaste(this)" ></textarea></td>
								</tr>
							</tbody>
						</table>
					</div>
					
				</div>
				<!-- layout_vertical_2 (2) (E) -->
			</div>
			<!-- layout_wrap (2) (E) -->
</div>
<!-- wrap_result(E) -->
<div id="helpbox" style="border-width: 0px; border-style: none; width: 0px; height: 0px; position: absolute; left: 0px; top: 0px; z-index: 1;"></div>
<div class="opus_design_grid" style="display: none;">
	<script type="text/javascript">ComSheetObject('t11sheet1');</script>
	<input type="hidden" name="org_bl_no" id="org_bl_no" >
</div>
<div id="orgBlNo" style="position:absolute;left:0;top:0;width:0;height:0;"></div> 	
<div id="layList" name="layList" style="position:absolute;z-index:999;display:none">
	<IFRAME id="ifrm" name="ifrm" src="apps/opus/esm/bkg/bookingcommon/bookingutil/jsp/esm_booking_split_no.html"  frameborder=0 marginHeight=0 marginWidth=0 width=115 height=82  style="position:absolute;border:1 #e9e9e9 solid" CELLSPACING=0 scrolling="no"></IFRAME>
</div>

		<div class="opus_design_RD"> 
			<script language="javascript">rdViewerObject();</script>
		</div>
</form>
<%!

	public String getSpecialChars() {
		return " ~!@#$%^&*()`_+-={}|[]\\\"\\':;,./?"; 
	}
		
%>