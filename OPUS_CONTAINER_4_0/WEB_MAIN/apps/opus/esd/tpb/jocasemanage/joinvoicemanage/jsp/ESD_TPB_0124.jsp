<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TPB_0124.jsp
*@FileTitle  : JO TPB Handling
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/19
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.tpb.jocasemanage.joinvoicemanage.event.EsdTpb0124Event"%>
<%@ page import="com.clt.apps.opus.esd.tpb.common.TPBUtils"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
/*
	EsdTpb0124Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Server Exception
	String strErrMsg = "";						//Error message
	int rowCount	 = 0;						//DB ResultSet list count

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.StatusInquiry.PerformanceInquiry");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsdTpb0124Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// Add logic information data from the server when loading the initial screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
*/
	String strErrMsg = "";						//Error message
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
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="iPage" id="iPage" />
<input type="hidden" name="s_bkg_no" id="s_bkg_no" />
<input type="hidden" name="s_bl_no" id="s_bl_no" />
<input type="hidden" name="s_vsl_cd" id="s_vsl_cd" />
<input type="hidden" name="s_skd_voy_no" id="s_skd_voy_no" />
<input type="hidden" name="s_skd_dir_cd" id="s_skd_dir_cd" />
<%--
<input type="hidden" name="s_vndr_cnt_cd" id="s_vndr_cnt_cd" />
<input type="hidden" name="s_vndr_seq" id="s_vndr_seq" />
<input type="hidden" name="s_cust_cnt_cd" id="s_cust_cnt_cd" />
<input type="hidden" name="s_cust_seq" id="s_cust_seq" />
<input type="hidden" name="s_n3pty_ofc_cd" id="s_n3pty_ofc_cd" />
--%>
<input type="hidden" name="s_detail_n3pty_no" value="" id="s_detail_n3pty_no" />
<input type="hidden" name="s_trd_party_code" id="s_trd_party_code" />
<input type="hidden" name="s_h_vndr_cust_div_cd" id="s_h_vndr_cust_div_cd" />
<input type="hidden" name="s_dao_n3pty_no" value="<%=JSPUtil.getNull(request.getParameter("s_dao_n3pty_no")) %>" id="s_dao_n3pty_no" />

<input type="hidden" name="s_correction_yn" value="" id="s_correction_yn" />
<input type="hidden" name="s_n3pty_inv_no" value="" id="s_n3pty_inv_no" />
<input type="hidden" name="s_n3pty_inv_his_seq" value="" id="s_n3pty_inv_his_seq" />
<input type="hidden" name="s_n3pty_inv_rmd_cd" value="" id="s_n3pty_inv_rmd_cd" />
<input type="hidden" name="s_n3pty_inv_no_for_search" value="" id="s_n3pty_inv_no_for_search" />
<input type="hidden" name="s_length_n3pty_bil_tp_cd" value="" id="s_length_n3pty_bil_tp_cd" />

<input type="hidden" name="s_n3pty_no_strs_link" value="<%=s_n3pty_no_strs_link%>" id="s_n3pty_no_strs_link" />
<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
			<button class="btn_normal" name="btn_modification" id="btn_modification" type="button" style="display:none;">Modification</button><!--
		--><button class="btn_normal" name="btn_invoice" id="btn_invoice" type="button" style="display:none;">Invoice Creation</button><!--
		--><button class="btn_normal" name="btn_roc" id="btn_roc" type="button" style="display:none;">ROC</button><!--
		--><button class="btn_normal" name="btn_writeoff" id="btn_writeoff" type="button" style="display:none;">Write-Off</button><!--
		--><button class="btn_normal" name="btn_revise" id="btn_revise" type="button" style="display:none;">Revision Detail</button><!--
		--><button class="btn_normal" name="btn_erpif" id="btn_erpif" type="button" style="display:none;">AR Interface</button><!--
		--><button class="btn_accent" name="btn_retrieve" id="btn_retrieve" type="button">Retrieve</button><!--
		--><button class="btn_normal" name="btn_new" id="btn_new" type="button">New</button><!--
		--><button class="btn_normal" name="btn_downexcel" id="btn_downexcel" type="button">Down Excel</button><!--
		--></div>
	<!-- opus_design_btn (E) -->

	<!-- page_location(S) -->
	<div class="location">	
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
	
</div>
<!-- page_title_area(E) -->

<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="100"/>
				<col width="100"/>
				<col width="110"/>
				<col width="100"/>
				<col width="*"/>
			</colgroup>
			<tr>
				<th>Confirmed Date</th>
				<td><input class="input1" type="text" name="s_sdate" style="width:80px;" value="<%=prevDay%>" dataformat="ymd" required caption="Date" id="s_sdate" />~ <input class="input1" type="text" name="s_edate" style="width:80px;" value="<%=currentDay%>" dataformat="ymd" required caption="Date" id="s_edate" /><button type="button" id="btns_calendar2" name="btns_calendar2" class="calendar ir"></button></td>
				<td></td>
				<th>3rd Party</th>
				<td><%=JSPUtil.getCodeCombo("s_vndr_cust_div_cd", "", "style='width:88'", "CD00583", 0, "001: :&lt;&lt;Select&gt;&gt;|")%><input type="text" style="width:75px;" name="s_trd_party_val" id="s_trd_party_val" /><button type="button" id="btn_3rdParty" name="btn_3rdParty" class="input_seach_btn"></button></td>
			</tr>
		</table>
		<table>
			<colgroup>
				<col width="100"/>
				<col width="100"/>
				<col width="207"/>
				<col width="100"/>
				<col width="*"/>
			</colgroup>
			<tr>
				<th>Status</th>
				<td>
					<SELECT name="s_status" style='width:105px'>
						<OPTION value="">ALL</OPTION>
						<OPTION value="O" Selected>Confirmed</OPTION>
						<OPTION value="I">Invoiced</OPTION>
						<OPTION value="E">Closed</OPTION>
					</SELECT>
				</td>
				<td></td>
				<th>Express Type</th>
				<td><%=JSPUtil.getCodeCombo("s_n3pty_src_sub_sys_cd", "", "style='width:167'", "CD00580", 0, "001: :ALL|")%></td>

			</tr>
		</table>
		<table>
			<colgroup>
				<col width="100"/>
				<col width="100"/>
				<col width="100"/>
				<col width="100"/>
				<col width="100"/>
				<col width="110"/>
				<col width="100"/>
				<col width="*"/>
			</colgroup>
			<tr>
				<th>TPB No.</th>
				<td><input type="text" style="width:105px;" name="s_n3pty_no" maxlength="14" value="<%=JSPUtil.getNull(request.getParameter("s_n3pty_no")) %>" id="s_n3pty_no" /></td>
				<th>Invoice No.</th>
				<td><input type="text" style="width:100px;" name="s_n3pty_inv_no_search" maxlength="11" id="s_n3pty_inv_no_search" /> </td>
				<th>S/P Invoice No.</th>
				<td><input type="text" style="width:93px;" name="s_n3pty_src_no" maxlength="30" id="s_n3pty_src_no" /> </td>
				<th title="Vessel Voyage Direction">VVD</th>
				<td><input type="text" style="width:90px;" name="s_vvd" maxlength="9" id="s_vvd" /><button type="button" id="btn_vvd" name="btn_vvd" class="input_seach_btn"></button></td>
			</tr>
		</table>
		<table>
			<colgroup>
				<col width="100"/>
				<col width="100"/>
				<col width="100"/>
				<col width="100"/>
				<col width="100"/>
				<col width="110"/>
				<col width="100"/>
				<col width="*"/>
			</colgroup>
			<tr>
				<th>Booking No.</th>
				<td><input type="text" style="width:105px;" name="s_bkg_no_all" maxlength="13" onblur="getBLNo(this.form,this,'s_')" id="s_bkg_no_all" /></td>
				<th>B/L No.</th>
				<td><input type="text" style="width:100px;" name="s_bl_no_all" maxlength="12" id="s_bl_no_all" /></td>
				<th>Equipment Type</th>
				<td><%=JSPUtil.getCodeCombo("s_eq_knd_cd", "", "style='width:100'", "CD01132", 0, "001: :&lt;&lt;Select&gt;&gt;|")%></td>
				<th>Equipment No.</th>
				<td><input type="text" style="width:90px;" name="s_eq_no" maxlength="11" id="s_eq_no" /></td>
			</tr>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet1');</script>		
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>