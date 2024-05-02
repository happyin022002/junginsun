<%
/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TPB_0106.jsp
*@FileTitle  : TPB Handling 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/24
=========================================================
*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.bizcommon.util.BizComUtil"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.tpb.processmanage.invoicemanage.event.EsdTpb0106Event"%>
<%@ page import="com.clt.apps.opus.esd.tpb.common.TPBUtils"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsdTpb0106Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Server Exception
	String strErrMsg = "";						//Error message
	int rowCount	 = 0;						//DB ResultSet list count
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	Logger log = Logger.getLogger("com.clt.apps.ProcessManage.InvoiceManage");
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
		//out.println(strOfc_cd);
		event = (EsdTpb0106Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		// Add logic information data from the server when loading the initial screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
	} catch(Exception e) {
		out.println(e.toString());
	}
	String currentDay = DateTime.getFormatString("yyyy-MM-dd");
	String cfm_dt = JSPUtil.getNull(request.getParameter("s_cfm_dt"));
	String cfm_dt_prev = JSPUtil.getNull(request.getParameter("s_cfm_dt_prev"));
	String cfm_dt_last = JSPUtil.getNull(request.getParameter("s_cfm_dt_last"));
	String s_n3pty_no_strs_link = JSPUtil.getNull(request.getParameter("s_n3pty_no_strs_link"));
	String prevDay = "";
	if(cfm_dt.equals("")){
		if(cfm_dt_prev.equals("") || cfm_dt_last.equals("")){
			prevDay = DateTime.addDays(currentDay, -7, "yyyy-MM-dd");
		}else{
			prevDay = cfm_dt_prev;
			currentDay = cfm_dt_last;
		}
	}else{
		prevDay = cfm_dt;
		currentDay = cfm_dt;
	}
%>

<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
		_text_ChangeUpperCase(); // automatic change to uppercase
	}
</script>


<form name="form" method="post">
<input id="f_cmd" name="f_cmd" type="hidden" />
<input id="pagerows" name="pagerows" value="<%=pageRows%>" type="hidden" />
<!-- 개발자 작업	-->
<input id="iPage" name="iPage" type="hidden" />
<input id="s_user_ofc_cd" name="s_user_ofc_cd" value="<%=strOfc_cd%>" type="hidden" />
<input id="s_bkg_no" name="s_bkg_no" type="hidden" />
<input id="s_bkg_no_split" name="s_bkg_no_split" type="hidden" />
<input id="s_bl_no_chk" name="s_bl_no_chk" type="hidden" />
<input id="s_bl_no" name="s_bl_no" type="hidden" />
<input id="s_bl_no_tp" name="s_bl_no_tp" type="hidden" />
<input id="s_vsl_cd" name="s_vsl_cd" type="hidden" />
<input id="s_skd_voy_no" name="s_skd_voy_no" type="hidden" />
<input id="s_skd_dir_cd" name="s_skd_dir_cd" type="hidden" />
<!--  -->
<input id="s_vndr_cnt_cd" name="s_vndr_cnt_cd" type="hidden" />
<input id="s_vndr_seq" name="s_vndr_seq" type="hidden" />
<input id="s_cust_cnt_cd" name="s_cust_cnt_cd" type="hidden" />
<input id="s_cust_seq" name="s_cust_seq" type="hidden" />
<input id="s_n3pty_ofc_cd" name="s_n3pty_ofc_cd" type="hidden" />
<!--  -->
<input id="s_detail_n3pty_no" name="s_detail_n3pty_no" value="" type="hidden" />
<input id="s_trd_party_code" name="s_trd_party_code" type="hidden" />
<input id="s_h_vndr_cust_div_cd" name="s_h_vndr_cust_div_cd" type="hidden" />
<input id="s_dao_n3pty_no" name="s_dao_n3pty_no" value="<%=JSPUtil.getNull(request.getParameter("s_dao_n3pty_no")) %>" type="hidden" />

<input id="s_correction_yn" name="s_correction_yn" value="" type="hidden" />
<input id="s_n3pty_inv_no" name="s_n3pty_inv_no" value="" type="hidden" />
<input id="s_n3pty_inv_his_seq" name="s_n3pty_inv_his_seq" value="" type="hidden" />
<input id="s_n3pty_inv_rmd_cd" name="s_n3pty_inv_rmd_cd" value="" type="hidden" />
<input id="s_n3pty_inv_no_for_search" name="s_n3pty_inv_no_for_search" value="" type="hidden" />
<input id="s_length_n3pty_bil_tp_cd" name="s_length_n3pty_bil_tp_cd" value="" type="hidden" />
<input id="s_n3pty_no_strs_link" name="s_n3pty_no_strs_link" value="<%=s_n3pty_no_strs_link%>" type="hidden" />
<%=JSPUtil.getIncludeString(request) %>


<!-- page_title_area(S) -->
<div class="page_title_area clear ">
	<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title">
		<button type="button"><span id="title"></span></button>
	</h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button type="button" id="btn_cancel" name="btn_cancel" class="btn_normal" style="display: none">Cancel</button><!--
		--><button type="button" id="btn_modification_left" name="btn_modification_left" style="display: none"></button><!--
		--><button type="button" id="btn_modification" name="btn_modification" class="btn_normal" style="display: none">Modification</button><!--
		--><button type="button" id="btn_modification_right" name="btn_modification_right" style="display: none"></button><!--
		--><button type="button" id="btn_invoice_left" name="btn_invoice_left" style="display: none"></button><!--
		--><button type="button" id="btn_invoice" name="btn_invoice" class="btn_normal" style="display: none">Invoice Creation</button><!--
		--><button type="button" id="btn_invoice_right" name="btn_invoice_right" style="display: none"></button><!--
		--><button type="button" id="btn_roc_left" name="btn_roc_left" style="display: none"></button><!--
		--><button type="button" id="btn_roc" name="btn_roc" class="btn_normal" style="display: none">ROC</button><!--
		--><button type="button" id="btn_roc_right" name="btn_roc_right" style="display: none"></button><!--
		--><button type="button" id="btn_writeoff_left" name="btn_writeoff_left" style="display: none"></button><!--
		--><button type="button" id="btn_writeoff" name="btn_writeoff" class="btn_normal" style="display: none">Write-Off</button><!--
		--><button type="button" id="btn_writeoff_right" name="btn_writeoff_right" style="display: none"></button><!--
		--><button type="button" id="btn_revise_left" name="btn_revise_left" style="display: none"></button><!--
		--><button type="button" id="btn_revise" name="btn_revise" class="btn_normal" style="display: none">Revision Detail</button><!--
		--><button type="button" id="btn_revise_right" name="btn_revise_right" style="display: none"></button><!--
		--><button type="button" id="btn_erpif_left" name="btn_erpif_left" style="display: none"></button><!--
		--><button type="button" id="btn_erpif" name="btn_erpif" class="btn_normal" style="display: none">AR Interface</button><!--
		--><button type="button" id="btn_erpif_right" name="btn_erpif_right" style="display: none"></button><!--
		--><button type="button" name="btn_retrieve" id="btn_retrieve" class="btn_accent">Retrieve</button><!--
		--><button type="button" name="btn_new" id="btn_new" class="btn_normal">New</button><!--
		--><button type="button" name="btn_downexcel" id="btn_downexcel" class="btn_normal">Down Excel</button><!--
		--></div>
	<!-- opus_design_btn (E) -->
	<!-- page_location(S) -->
	<div class="location">	
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
	
</div>
<!-- page_title_area(E) -->


<div class="wrap_search ">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<tbody>
				<colgroup>
					<col width="80" />
					<col width="140" />
					<col width="80" />
					<col width="185" />
					<col width="80" />
					<col width="120" />
					<col width="80" />
					<col width="*" />
				</colgroup>
				<tr>
					<th>Confirmed Date</th>
					<td colspan="3"><input id="s_sdate" class="input1" name="s_sdate" style="width:75px;" value="<%=prevDay%>" dataformat="ymd" required="" caption="Date" type="text" /><input class="input1" type="text" name="s_edate" id="s_edate" style="width:75px" value="<%=currentDay%>" dataformat="ymd" required caption='Date'><button type="button" class="calendar ir" name="btns_calendar2" id="btns_calendar2"></button></td>	
					<th>3rd Party</th>
					<td colspan="3"><%=JSPUtil.getCodeCombo("s_vndr_cust_div_cd", "", "style='width:90px'", "CD00583", 0, "001: :&lt;&lt;Select&gt;&gt;|")%><input type="text" style="width:70px;" dataformat="engup" name="s_trd_party_val" id="s_trd_party_val" maxlength="8" !readonly ><button type="button" class="input_seach_btn" name="btn_3rdParty" id="btn_3rdParty"></button></td>
				</tr>
				<tr>
					<th>Status</th>
					<td>
						<SELECT name="s_status" id="s_status" style='width: 120px'>
							<OPTION value="">ALL</OPTION>
							<OPTION value="O" Selected>Confirmed</OPTION>
							<OPTION value="I">Invoiced</OPTION>
							<OPTION value="E">Closed</OPTION>
						</SELECT>
					</td>
					<th>Expense Type</th>
					<td colspan="5"><%=TPBUtils.getCodeCombo("s_n3pty_expn_tp_cd", "", "style='width:165px'", "CD00578", 0, "001: :&lt;&lt;Select&gt;&gt;|", "")%></td>	
				</tr>
				<tr>
					<th>TPB No.</th>
					<td><input id="s_n3pty_no" style="width:120px;" dataformat="engup" name="s_n3pty_no" maxlength="14" value="<%=JSPUtil.getNull(request.getParameter("s_n3pty_no")) %>" type="text" /></td>
					<th>Invoice No.</th>
					<td><input id="s_n3pty_inv_no_search" style="width:165px;" dataformat="engup" name="s_n3pty_inv_no_search" maxlength="11" type="text" /> </td>
					<th>S/P Invoice No.</th>
					<td><input id="s_n3pty_src_no" style="width:90px;" name="s_n3pty_src_no"  maxlength="30" type="text" /> </td>
					<th title="Vessel Voyage Direction">VVD</th>
					<td><input id="s_vvd" style="width:90px;" name="s_vvd" dataformat="engup" maxlength="9" type="text" /><button class="input_seach_btn" name="btn_vvd" id="btn_vvd" type="button"></button></td> 
				</tr>
				<tr >
					<th>Booking No.</th>
					<td><input id="s_bkg_no_all" style="width:120px;" name="s_bkg_no_all" dataformat="engup" maxlength="13" onblur="getBLNo(this.form,this,'s_')" type="text" /> </td>
					<th>B/L No.</th>
					<td><input id="s_bl_no_all" style="width:165px;" name="s_bl_no_all" dataformat="engup" maxlength="12" type="text" /> </td>
					<th>Equipment Type</th>
					<td><%=TPBUtils.getCodeCombo("s_eq_knd_cd", "", "style='width:90px'", "CD01132", 0, "001: :&lt;&lt;Select&gt;&gt;|", "")%></td>
					<th>Equipment No.</th>
					<td><input id="s_eq_no" style="width:90px;" name="s_eq_no" dataformat="engup" maxlength="11" type="text" /> </td> 
				</tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>
<div class="wrap_result">
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>	
</form>