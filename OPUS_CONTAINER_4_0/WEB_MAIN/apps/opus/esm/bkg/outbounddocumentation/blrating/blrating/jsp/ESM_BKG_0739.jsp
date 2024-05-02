<%
/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0739.jsp
*@FileTitle  : RFA Information 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/
=========================================================
*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.event.EsmBkg0739Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0739Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.BlRating.BlRating");
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		event = (EsmBkg0739Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
	} catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form">
<input id="f_cmd" name="f_cmd" type="hidden" />
<input id="pagerows" name="pagerows" type="hidden" />
<input id="frm_svc_scp_cd" name="frm_svc_scp_cd" type="hidden" />
<input id="frm_bdr_cng_flg" name="frm_bdr_cng_flg" type="hidden" />
<input id="bkg_no" name="bkg_no" value="<%=JSPUtil.getParameter(request, "bkg_no")%>" type="hidden" />
<input id="rfa_no" name="rfa_no" value="<%=JSPUtil.getParameter(request, "rfa_no")%>" type="hidden" />
<input id="application_date" name="application_date" value="<%=JSPUtil.getParameter(request, "application_date")%>" type="hidden" />
<input id="frm_t10sheet1_brk_dwn_flg" name="frm_t10sheet1_brk_dwn_flg" value="<%=JSPUtil.getParameter(request, "frm_t10sheet1_brk_dwn_flg")%>" type="hidden" />
<input id="tp_sz" name="tp_sz" value="<%=JSPUtil.getParameter(request, "tp_sz")%>" type="hidden" />
<input id="cgo" name="cgo" value="<%=JSPUtil.getParameter(request, "cgo")%>" type="hidden" />
<input id="qty" name="qty" value="<%=JSPUtil.getParameter(request, "qty")%>" type="hidden" />
<input id="term_cd" name="term_cd" value="<%=JSPUtil.getParameter(request, "frt_term_cd")%>" type="hidden" />
<input id="ca_flg" name="ca_flg" value="<%=JSPUtil.getParameter(request, "ca_flg")%>" type="hidden" />
<input id="svc_scp_cd" name="svc_scp_cd" value="<%=JSPUtil.getParameter(request, "svc_scp_cd")%>" type="hidden" />
<input id="ctrt_tp_cd" name="ctrt_tp_cd" value="R" type="hidden" />
<input id="rt_aud_tp_cd" name="rt_aud_tp_cd" value="R" type="hidden" />


<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title">
		<span>RFA Information</span>
	</h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button type="button" id="btn_Select" name="btn_Select" class="btn_accent">Select</button><!--
		--><button type="button" id="btn_Close" name="btn_Close" class="btn_normal">Close</button><!--
		--></div>
	<!-- opus_design_btn (E) -->
</div>
<!-- page_title_area(E) -->

<div class="wrap_search">
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>	
				<col width="50"/>
				<col width="150"/>
				<col width="30"/>
				<col width="150"/>
				<col width="50"/>
				<col width="120"/>
				<col width="*"/>
			</colgroup>
			<tr>
				<th>BKG No.</th>
				<td><input id="frm_bkg_no" style="width:110px;" class="input" name="frm_bkg_no" value="<%=JSPUtil.getParameter(request, " bkg_no") %>" type="text" readonly="readonly"/></td>
				<th>CRD</th>
				<td><input id="frm_cntr_cdr_dt" style="width:80px;text-align: center" class="input2" name="frm_cntr_cdr_dt" value="<%=JSPUtil.getParameter(request, " application_date") %>" type="text" readonly="readonly"/></td>
				<th>RFA No.</th>
				<td><input id="frm_ftaa_no" style="width:110px;" class="input" name="frm_ftaa_no" value="<%=JSPUtil.getParameter(request, " rfa_no") %>" type="text" readonly="readonly"/></td>
				<td></td>
			</tr>
		</table>
		

		
	<table style="border: 0; text-align: left; " >
		<tr>
		  <td>
			<div class="layout_vertical_3">
		      	<table style="border: 1; text-align: left; width: 670px" class="grid_2">
					<tr>
						<th><strong>Shipper	</strong></th>
						<td width="30" class="input2">
						<input id="frm_s_cust_cnt_cd" style="width: 100%; text-align: center" class="noinput2" name="frm_s_cust_cnt_cd" value="" readonly="" type="text" />
						</td>
						<td width="60" class="input2">
						<input id="frm_s_cust_seq" style="width: 100%; text-align: right" class="noinput2" name="frm_s_cust_seq" value="" readonly="" type="text" />
						</td>
						<td align="left" class="input2">
						<input id="frm_s_cust_nm" style="width: 100%; text-align: left" class="noinput2" name="frm_s_cust_nm" value="" readonly="" type="text" />
						</td>
					</tr>
					<tr>
						<th><strong>Consignee</strong></th>
						<td><input id="frm_c_cust_cnt_cd" style="width: 100%; text-align: center" class="noinput2" name="frm_c_cust_cnt_cd" value="" readonly type="text" /> 	</td>
						<td><input id="frm_c_cust_seq" style="width: 100%; text-align: right" class="noinput2" name="frm_c_cust_seq" value="" readonly type="text" /> 	</td>
						<td><input id="frm_c_cust_nm" style="width: 100%; text-align: left" class="noinput2" name="frm_c_cust_nm" value="" readonly type="text" /> </td>
					</tr>
					<tr>
						<th><strong>Notify			</strong></th>
						<td><input id="frm_n_cust_cnt_cd" style="width: 100%; text-align: center" class="noinput2" name="frm_n_cust_cnt_cd" value="" readonly type="text" /> 	</td>
						<td><input id="frm_n_cust_seq" style="width: 100%; text-align: right" class="noinput2" name="frm_n_cust_seq" value="" readonly type="text" /> 	</td>
						<td><input id="frm_n_cust_nm" style="width: 100%; text-align: left" class="noinput2" name="frm_n_cust_nm" value="" readonly type="text" /> </td>
					</tr>
					<tr>
						<th><strong>Also NTFY			</strong></th>
						<td><input id="frm_a_cust_cnt_cd" style="width: 100%; text-align: center" class="noinput2" name="frm_a_cust_cnt_cd" value="" readonly type="text" /> 	</td>
						<td><input id="frm_a_cust_seq" style="width: 100%; text-align: right" class="noinput2" name="frm_a_cust_seq" value="" readonly type="text" /> 	</td>
						<td><input id="frm_a_cust_nm" style="width: 100%; text-align: left" class="noinput2" name="frm_a_cust_nm" value="" readonly type="text" /> </td>
					</tr>
					<tr>
						<th><strong>RFA customer	</strong></th>
						<td><input id="frm_p_cust_cnt_cd" style="width: 100%; text-align: center" class="noinput2" name="frm_p_cust_cnt_cd" value="" readonly type="text" /> </td>
						<td><input id="frm_p_cust_seq" style="width: 100%; text-align: right" class="noinput2" name="frm_p_cust_seq" value="" readonly type="text" /> 	</td>
						<td><input id="frm_p_cust_nm" style="width: 100%; text-align: left" class="noinput2" name="frm_p_cust_nm" value="" readonly type="text" /> 	</td>
					</tr>
					<tr>
						<th><strong>Commodity	</strong></th>
						<td colspan="2"><input id="frm_cmdt_cd" style="width: 100%; text-align: right" class="noinput2" name="frm_cmdt_cd" value="" readonly type="text" /> 	</td>
						<td><input id="frm_cmdt_nm" style="width: 100%; text-align: left" class="noinput2" name="frm_cmdt_nm" value="" readonly type="text" /> </td>
					</tr>
					<tr>
						<th><strong>Rep. Commodity	</strong></th>
						<td colspan="2"><input id="frm_rep_cmdt_cd" style="width: 100%; text-align: right" class="noinput2" name="frm_rep_cmdt_cd" value="" readonly type="text" /> </td>
						<td><input id="frm_rep_cmdt_nm" style="width: 100%; text-align: left" class="noinput2" name="frm_rep_cmdt_nm" value="" readonly type="text" /> </td>
					</tr>
				</table>
								
		    </div>
		    </td>
		    <td width="10" valign="top"></td>
		    <td>
		    <div class="layout_flex_flex" style="padding-left:680px">
				<div class="opus_design_grid">
					<script type="text/javascript">ComSheetObject('sheet0');</script>
				</div>
			</div>
			</td>
	    </tr>
	    </table>
		    

		
		<table>
			<colgroup>	
				<col width="50"/>
				<col width="180"/>
				<col width="60"/>
				<col width="180"/>
				<col width="*"/>
			</colgroup>
			<tr>
				<th>Weight</th>
				<td><input id="frm_act_wgt" style="width:110px; text-align:right;" class="input2" name="frm_act_wgt" value="" readonly type="text" /><input id="" style="width:30px;text-align:right;" class="input2" name="" value="" readonly type="text" /></td>
				<th>Measure</th>
				<td><input id="frm_meas_qty" style="width:110px; text-align:right;" class="input2" name="frm_meas_qty" value="" readonly type="text" /><input id="frm_meas_ut_cd" style="width:40px;text-align:center;" class="input2" name="frm_meas_ut_cd" value="" readonly type="text" /> </td>
				<td></td>
			</tr>
		</table>
		
		<table>
			<colgroup>	
				<col width="120"/>
				<col width="70"/>
				<col width="40"/>
				<col width="70"/>
				<col width="40"/>
				<col width="70"/>
				<col width="40"/>
				<col width="70"/>
				<col width="40"/>
				<col width="70"/>
				<col width="40"/>
				<col width="70"/>
				<col width="*"/>
			</colgroup>
			<tr>
				<th>Booking Route Information</th>
				<td width="240">
					<input id="frm_bkg_por_cd" style="width:50px;" class="input2" name="frm_bkg_por_cd" value="" readonly="readonly" type="text" /><!--  
					--><input id="frm_bkg_pol_cd" style="width:50px;" class="input2" name="frm_bkg_pol_cd" value="" readonly="readonly" type="text" /><!--
					--><input id="frm_bkg_pod_cd" style="width:50px;" class="input2" name="frm_bkg_pod_cd" value="" readonly="readonly" type="text" /><!--
					--><input id="frm_del_cd" style="width:50px;" class="input2" name="frm_del_cd" value="" readonly="readonly" type="text" />
				</td>
				<th>Pre</th>
				<td><input id="frm_vv_pol_cd" style="width:50px;text-align:center;" class="input2" name="frm_vv_pol_cd" value="" readonly type="text" /></td>
				<th>Post</th>
				<td><input id="frm_vv_pod_cd" style="width:50px;text-align:center;" class="input2" name="frm_vv_pod_cd" value="" readonly type="text" /></td>
				<th>R/D</th>
				<td><input id="frm_rcv_term_cd" style="width:18px;text-align:center;" class="input2" name="frm_rcv_term_cd" value="" readonly type="text" /><input id="frm_de_term_cd" style="width:18px;text-align:center;" class="input2" name="frm_de_term_cd" value="" readonly type="text" /> </td>
				<th>Special</th>
				<td><input id="frm_special" style="width:18px;text-align:center;" class="input2" name="frm_special" value="" readonly type="text" /></td>
				<th>FRT Term</th>
				<td><input id="frm_frt_term_cd" style="width:18px;text-align:center;" class="input2" name="frm_frt_term_cd" value="<%=JSPUtil.getParameter(request, " frt_term_cd") %>" type="text" readonly="readonly"/></td>
				<td></td>
			</tr>
		</table>
		<table border="0" style="width:979" id="multi_curr_msg"> 
			<tr>
				<td align="left" style="color: red;">&nbsp;<span id="span_multi_curr_msg"/></span></td>
			</tr>
		</table>
	</div>
</div>

<div class="wrap_result">
		<div class="opus_design_grid" style="display: none; width:979px;">
    		<script type="text/javascript">ComSheetObject('sheet1');</script>
    	</div>
    	<div class="opus_design_grid" style="display: none; width:979px;">
     		<script type="text/javascript">ComSheetObject('sheet2');</script>
     	</div>
     	<div class="opus_design_grid">
    		<script type="text/javascript">ComSheetObject('sheet3');</script>
    	</div>
    	<div class="opus_design_grid" style="display: none; width:979px;">
     		<script type="text/javascript">ComSheetObject('sheet4');</script>
     	</div>
     	<div class="opus_design_grid" style="display: none; width:979px;"> 
    		<script type="text/javascript">ComSheetObject('sheet5');</script>
    	</div>
    	<div class="opus_design_grid" style="display: none; width:979px;"> 
    		<script type="text/javascript">ComSheetObject('sheet6');</script>
    	</div>
</div>
</form>