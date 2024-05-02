<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TPB_0128.jsp
*@FileTitle  :  TPB Inquiry
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
<%@ page import="com.clt.apps.opus.esd.tpb.jocasemanage.jostatusinquiry.event.EsdTpb0128Event"%>
<%@ page import="com.clt.apps.opus.esd.tpb.common.TPBUtils"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsdTpb0128Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Server Exception
	String strErrMsg = "";						//Error message
	int rowCount	 = 0;						//DB ResultSet list count

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.Jocasemanage.Jostatusinquiry");
	
	String ofc_cd = "";
	String n3pty_no = "";

	String ots_sts_cd = JSPUtil.getNull(request.getParameter("s_h_ots_sts_cd"));
	String s_trd_party_code = JSPUtil.getNull(request.getParameter("s_trd_party_code"));
	String s_h_vndr_cust_div_cd = JSPUtil.getNull(request.getParameter("s_h_vndr_cust_div_cd"));

	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		
		ofc_cd = account.getOfc_cd();

		event = (EsdTpb0128Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// Add logic information data from the server when loading the initial screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
	
	// office level
	String[] officeInfo = TPBUtils.getHandleOfficeLevel( ofc_cd ); // 0:Office Level / 1:Office Code / 2:R.HQ Code / 3:HO Code
	String ofc_lvl = JSPUtil.getNull( officeInfo[0] ); // Office Level


	// retrieve only
	boolean isReadOnly = false;
	String strReadOnly = "";
	String strBgColor = "";
	String flagReadOnly = JSPUtil.getNull(request.getParameter("s_readonly"));

	if ( n3pty_no.trim().equals("") || flagReadOnly.equals("Y") ) {
		isReadOnly = true;
		strReadOnly = " readonly";
		strBgColor = ".background-color:#EEEEEE;";
	}

    String s_direct_tpb_no = JSPUtil.getNull(request.getParameter("s_direct_tpb_no"));
    if ( s_direct_tpb_no.length() > 0 ) {
    	n3pty_no = s_direct_tpb_no;
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


<form name="form" id="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<!-- 개발자 작업	-->
<input type="hidden" name="iPage" id="iPage" />
<input type="hidden" name="s_last_vndr_cust_div_cd" value="" id="s_last_vndr_cust_div_cd" />
<input type="hidden" name="s_vndr_cnt_cd" id="s_vndr_cnt_cd" />
<input type="hidden" name="s_vndr_seq" id="s_vndr_seq" />
<input type="hidden" name="s_cust_cnt_cd" id="s_cust_cnt_cd" />
<input type="hidden" name="s_cust_seq" id="s_cust_seq" />
<input type="hidden" name="s_n3pty_ofc_cd" id="s_n3pty_ofc_cd" />
<input type="hidden" name="toEmail" id="toEmail" />
<input type="hidden" name="s_process_close_message" value="" id="s_process_close_message" />
<input type="hidden" name="s_readonly" value="<% if(isReadOnly){out.print("Y");} %>">
<input type="hidden" name="s_detail_n3pty_no" value="<%=n3pty_no%>">
<input type="hidden" name="s_usr_ofc_cd" value="<%=ofc_cd%>">
<input type="hidden" name="s_ots_sts_cd" value="<%=ots_sts_cd%>">
<input type="hidden" name="s_h_ots_sts_cd" value="<%=ots_sts_cd%>">
<input type="hidden" name="s_n3pty_bil_tp_cd" value="">
<input type="hidden" name="s_length_n3pty_bil_tp_cd" value="1">
<input type="hidden" name="s_trd_party_code" value="<%=s_trd_party_code%>">
<input type="hidden" name="s_h_vndr_cust_div_cd" value="<%=s_h_vndr_cust_div_cd%>">

<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
	<% if(!isReadOnly){%>
		<button class="btn_accent" name="btn_invoicecreation" id="btn_invoicecreation" type="button" style="display:none;">Invoice Creation</button><!--
	--><button class="btn_normal" name="btn_settlement" id="btn_settlement" type="button" style="display:none;">Settlement</button><% } %><% if(!isReadOnly){ %><% if(ofc_lvl.equals("R")){%><!--
	--><button class="btn_normal" name="btn_cancel_process" id="btn_cancel_process" type="button" style="display:none;">Cancel Process</button><% } %><% if(ofc_lvl.equals("G") || ofc_lvl.equals("")){%><!--
	--><button class="btn_normal" name="btn_close_process" id="btn_close_process" type="button" style="display:none;">Close Process</button><% } %><!--
	--><button class="btn_normal" name="btn_save" id="btn_save" type="button" style="display:none;">Save</button><% } %><!--
	--><button class="btn_normal" name="btn_retrieve" id="btn_retrieve" type="button">Retrieve</button><!--
	--><button class="btn_normal" name="btn_new" id="btn_new" type="button">New</button><!--
	--><button class="btn_normal" name="btn_collectionactivity" id="btn_collectionactivity" type="button">Recovery Activity</button><!--
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
	<div class="opus_design_inquiry">
		<table>
			<colgroup>
				<col width="86"/>
				<col width="253"/>
				<col width="100"/>
				<col width="*"/>
			</colgroup> 
			<tr>
				<th>TPB No.</th>
				<td><input type="text" style="width:150px;" name="s_n3pty_no" id="s_n3pty_no" maxlength="14" value=<%=n3pty_no %>></td>
				<th>Invoice No.</th>
				<td><input type="text" style="width:150px;" name="s_n3pty_inv_no" id="s_n3pty_inv_no" maxlength="11"></td>
			</tr>
		</table>

		<table class="line_bluedot"><tr><td></td></tr></table>
		
		<table>
			<colgroup>
				<col width="86"/>
				<col width="253"/>
				<col width="100"/>
				<col width="298"/>
				<col width="60"/>
				<col width="*"/>
			</colgroup> 
			<tr>
				<th>Office</th>
				<td><input type="text" style="width:150px;.background-color:#EEEEEE" name="s_ofc_cd" id="s_ofc_cd" <%=strReadOnly%>></td>
				<th>TPB Status</th>
				<td><input type="text" style="width:150px;.background-color:#EEEEEE" name="s_ots_sts_nm" id="s_ots_sts_nm"<%=strReadOnly%>></td>
				<th>Overdue</th>
				<td><input type="text" style="width:150px;.background-color:#EEEEEE" name="s_overdue" id="s_overdue" <%=strReadOnly%>></td>
			</tr>
		</table>
		<table>
			<colgroup>
				<col width="86"/>
				<col width="660"/>
				<col width="50"/>				
				<col width="*"/>
			</colgroup>
			<tr>
				<th>3rd Party</th>
				<td><%=JSPUtil.getCodeCombo("s_vndr_cust_div_cd", "", "style='width:80px;"+strBgColor+"'"+(isReadOnly?" disabled":"")+"", "CD00583", 0, "001: :&lt;&lt;Select&gt;&gt;|")%><input type="text" style="width:66px;<%=strBgColor%>" name="s_trd_party_val" id="s_trd_party_val" maxlength="8" <%=strReadOnly%>>
			<% if(!isReadOnly){ // %>
				<button type="button" id="btn_3rdParty" name="btn_3rdParty" class="input_seach_btn"></button>
			<% } %>
				<input type="text" style="width:346px;<%=strBgColor%>" name="s_trd_party_nm" id="s_trd_party_nm" readonly>
				<th>CSR No.</th>
				<td><input type="text" style="width:150px;.background-color:#EEEEEE" name="s_csr_no" id="s_csr_no" value="" <%=strReadOnly%>></td>
			</tr>
		</table>
		<table>
			<colgroup>
				<col width="86"/>
				<col width="253"/>
				<col width="100"/>				
				<col width="*"/>
			</colgroup> 
			<tr>
				<th>Res. Office</th>
				<td><input type="text" style="width:150px;.background-color:#EEEEEE" name="s_roc_in" id="s_roc_in" <%=strReadOnly%>></td>
				<th>ROC-out (from)</th>
				<td><input type="text" style="width:150px;.background-color:#EEEEEE" name="s_roc_out" id="s_roc_out" <%=strReadOnly%>></td>
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
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">		
		<script type="text/javascript">ComSheetObject('sheet2');</script>		
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>
<script type="text/javascript">
<!--

	  /*
		Showing screent of user input info by event
	  */
	  with(document.form)
	  {
	  }
-->
</script>