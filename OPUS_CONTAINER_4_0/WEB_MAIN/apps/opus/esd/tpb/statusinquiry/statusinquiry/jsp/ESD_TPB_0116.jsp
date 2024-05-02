<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TPB_0116.jsp
*@FileTitle  : Status By TPB
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/17
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.tpb.statusinquiry.statusinquiry.event.EsdTpb0116Event"%>
<%@ page import="com.clt.apps.opus.esd.tpb.common.TPBUtils" %>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsdTpb0116Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Server Exception
	String strErrMsg = "";						//Error message
	int rowCount	 = 0;						//DB ResultSet list count

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	
	String ofc_cd = "";
	String rhq_cd = "";
	String priv_cd = "";
	String ofc_lvl = "";
	
	String currentDay = DateTime.getFormatString("yyyy-MM-dd");
	
	Logger log = Logger.getLogger("com.clt.apps.StatusInquiry.StatusInquiry");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		ofc_cd = account.getOfc_cd();

		event = (EsdTpb0116Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// Add logic information data from the server when loading the initial screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
	
	String[] officeInfo = TPBUtils.getHandleOfficeLevel( ofc_cd, true ); // 0:Office Level / 1:Office Code / 2:R.HQ Code / 3:HO Code
	ofc_lvl = JSPUtil.getNull( officeInfo[0] ); // Office Level
	rhq_cd  = JSPUtil.getNull( officeInfo[2] ); // RHQ Code
	priv_cd = JSPUtil.getNull( officeInfo[4] );
	
	String s_state = JSPUtil.getNull(request.getParameter("s_state"));
	//out.println(s_state);
	String p_sdate = "";
	String p_edate = "";
	String p_bkg_no_all = "";
	String p_n3pty_src_sub_sys_cd = "";
	String p_n3pty_src_sub_sys_cd_check = "";
	String p_n3pty_src_sub_sys_cd_check_trs = "";
	String p_n3pty_src_sub_sys_cd_check_tes = "";
	String p_n3pty_src_sub_sys_cd_check_mnr = "";
	String p_ots_sts_cd = "";

	if (s_state.equals("BKG")){
		p_sdate = JSPUtil.getNull(request.getParameter("s_sdate"));
		p_edate = JSPUtil.getNull(request.getParameter("s_edate"));
		p_bkg_no_all = JSPUtil.getNull(request.getParameter("s_bkg_no_all"));
		p_n3pty_src_sub_sys_cd = JSPUtil.getNull(request.getParameter("s_n3pty_src_sub_sys_cd"));
		p_n3pty_src_sub_sys_cd_check = JSPUtil.getNull(request.getParameter("s_n3pty_src_sub_sys_cd_check"));
		if (p_n3pty_src_sub_sys_cd_check.equals("TRS")){
			p_n3pty_src_sub_sys_cd_check_trs = "checked";
			p_n3pty_src_sub_sys_cd_check_tes = "unchecked";
			p_n3pty_src_sub_sys_cd_check_mnr = "unchecked";
		} else if (p_n3pty_src_sub_sys_cd_check.equals("TES")){
			p_n3pty_src_sub_sys_cd_check_trs = "unchecked";
			p_n3pty_src_sub_sys_cd_check_tes = "checked";
			p_n3pty_src_sub_sys_cd_check_mnr = "unchecked";
		} else if (p_n3pty_src_sub_sys_cd_check.equals("MNR")){	
			p_n3pty_src_sub_sys_cd_check_trs = "unchecked";
			p_n3pty_src_sub_sys_cd_check_tes = "unchecked";
			p_n3pty_src_sub_sys_cd_check_mnr = "checked";
		}
		p_ots_sts_cd = JSPUtil.getNull(request.getParameter("s_ots_sts_cd"));
	} else {
		p_sdate = DateTime.addMonths(currentDay, -1, "yyyy-MM-dd");
		p_edate = currentDay;
		p_bkg_no_all = "";
		//p_n3pty_src_sub_sys_cd = "001: :ALL|";
		p_n3pty_src_sub_sys_cd_check = "unchecked";
		//p_ots_sts_cd = "T";
	}
	//out.println(p_ots_sts_cd);
	//out.println(JSPUtil.getNull(request.getParameter("s_ots_sts_cd")));
%>

<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		<% if ( ofc_lvl.equals("R") ) { %>getTPBGenCombo('s_if_ctrl_cd','searchCtrlOffice','F','','2', new Array("s_if_rhq_cd","s_office_level"));<% } %>
		loadPage();
		_text_ChangeUpperCase(); // automatic change to uppercase
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />

<input type="hidden" name="iPage" id="iPage" />
<input type="hidden" name="s_bkg_no" id="s_bkg_no" />
<input type="hidden" name="s_bkg_no_split" id="s_bkg_no_split" />
<input type="hidden" name="s_bl_no_chk" id="s_bl_no_chk" />
<input type="hidden" name="s_bl_no" id="s_bl_no" />
<input type="hidden" name="s_bl_no_tp" id="s_bl_no_tp" />
<input type="hidden" name="s_vsl_cd" id="s_vsl_cd" />
<input type="hidden" name="s_skd_voy_no" id="s_skd_voy_no" />
<input type="hidden" name="s_skd_dir_cd" id="s_skd_dir_cd" />
<!--  -->
<input type="hidden" name="s_vndr_cnt_cd" id="s_vndr_cnt_cd" />
<input type="hidden" name="s_vndr_seq" id="s_vndr_seq" />
<input type="hidden" name="s_cust_cnt_cd" id="s_cust_cnt_cd" />
<input type="hidden" name="s_cust_seq" id="s_cust_seq" />
<input type="hidden" name="s_n3pty_ofc_cd" id="s_n3pty_ofc_cd" />
<!--  -->
<input type="hidden" name="sdate" value="<%=DateTime.addDays(currentDay, -7, "yyyy-MM-dd")%>">
<input type="hidden" name="edate" value="<%=currentDay%>">
<input type="hidden" name="s_n3pty_no" id="s_n3pty_no" />
<input type="hidden" name="s_dao_n3pty_no" id="s_dao_n3pty_no" />
<input type="hidden" name="s_h_ots_sts_cd" id="s_h_ots_sts_cd" />
<input type="hidden" name="s_trd_party_code" id="s_trd_party_code" />
<input type="hidden" name="s_h_vndr_cust_div_cd" id="s_h_vndr_cust_div_cd" />
<input type="hidden" name="s_h_n3pty_inv_no" id="s_h_n3pty_inv_no" />
<input type="hidden" name="s_cfm_dt" id="s_cfm_dt" />
<input type="hidden" name="s_cfm_dt_prev" id="s_cfm_dt_prev" />
<input type="hidden" name="s_cfm_dt_last" id="s_cfm_dt_last" />
<input type="hidden" name="s_user_ofc_cd" value="<%=ofc_cd%>">
<input type="hidden" name="s_office_level" value="<%=ofc_lvl%>">
<input type="hidden" name="s_rhq_cd_for_rhq" value="<%=rhq_cd%>">
<input type="hidden" name="s_ofc_cd_for_rhq" value="<%=ofc_cd%>">
<input type="hidden" name="s_state" value="<%=s_state%>">
<input type="hidden" name="priv_cd" value="<%=priv_cd%>">

	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	
		<!-- page_title(S) -->
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
		<!-- page_title(E) -->
		
		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn">
			<button class="btn_accent" name="btn_retrieve" id="btn_retrieve" type="button">Retrieve</button><!--
			--><button class="btn_normal" name="btn_new" id="btn_new" type="button">New</button><!--
			--><button class="btn_normal" style="display:none;" name="btn_settlement" id="btn_settlement" type="button">Settlement</button><!--
			--><button class="btn_normal" style="display:none;" name="btn_invoicecreation" id="btn_invoicecreation" type="button">Invoice Creation</button><!--
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
		<div class="opus_design_inquiry">
			<table>
				<colgroup>
					<col width="100"/>
					<col width="300"/>
					<col width="100"/>
					<col width="300"/>
					<col width="100"/>
					<col width="150"/>
					<col width="50"/>
					<col width="*" />				
			   	</colgroup> 
				<tr>
				    <th>Period</th>
					<td><input type="text" name="s_sdate" class="input" style="width:75px;" value="<%=p_sdate%>" caption="Date" data_format="ymd" onkeydown="tpb_isNumD(this, 'Y');" onblur="tpb_validateDateObj(this);" id="s_sdate" />~ <input type="text" name="s_edate" class="input" style="width:75px;" value="<%=p_edate%>" caption="Date" data_format="ymd" onkeydown="tpb_isNumD(this, 'Y');" onblur="tpb_validateDateObj(this);" id="s_edate" /><button type="button" id="btns_calendar2" name="btns_calendar2" class="calendar ir"></button></td>
					<th>RHQ</th>
					<td><% if(s_state.equals("BKG")){%><select style="width:120px;" name="s_if_rhq_cd" id="s_if_rhq_cd" required caption="RHQ"><option value="<%=rhq_cd%>" selected>&lt;Select&gt;</option></select><% }else{ %><select class="input1" style="width:120px;" name="s_if_rhq_cd" id="s_if_rhq_cd" required caption="RHQ"><option value="" selected>&lt;Select&gt;</option></select><% } %></td>
					<th>Control Office</th>
					<td><% if ( ofc_lvl.equals("C") ) { %><select style="width:100px;" name="s_if_ctrl_cd" id="s_if_ctrl_cd" caption="Control Office"><option value="<%=ofc_cd%>" selected><%=ofc_cd%></option></select><% } else { %><select style="width:100px;" name="s_if_ctrl_cd" id="s_if_ctrl_cd" caption="Control Office"><option value="" selected>&lt;Select&gt;</option></select><% } %></td>
					<th>Office</th>
					<td><select style="width:90px;" name="s_if_ofc_cd" id="s_if_ofc_cd" ><option value="" selected>&lt;Select&gt;</option></select></td>
				</tr>
			</table>
			<table>
				<colgroup>
					<col width="100"/>
					<col width="300"/>
					<col width="100"/>
					<col width="*" />				
			   	</colgroup> 
				<tr>
					<th>TPB Status</th>
					<td><% if(s_state.equals("BKG")){ %><SELECT name="s_ots_sts_cd" style='width:110px' onchange=checkPeriod(this.value)><OPTION value="T" <% if (p_ots_sts_cd.equals("T")) {%> selected <% } %>>Open</OPTION><OPTION value="P" <% if (p_ots_sts_cd.equals("P")) {%> selected <% } %>>Closed</OPTION></SELECT><% }else{ %><%=TPBUtils.getCodeCombo("s_ots_sts_cd", "", "style='width:110' onchange=checkPeriod(this.value)", "CD00952", 0, "999999:P:Closed", "T") %><% } %><%=TPBUtils.getCodeCombo("s_ots_sts_cd_detail_open", "", "style='width:120' ", "CD00588", 0, "0:ALL:ALL", "I|Y|O") %><%=TPBUtils.getCodeCombo("s_ots_sts_cd_detail_close", "", "style='width:120;display:none' ", "CD00588", 0, "0:ALL:ALL|999997:L:AR Interface|999998:D:Process Close|999999:S:RHQ Cancelled", "E") %></td>
					<th>3rd Party</th>
					<td><%=JSPUtil.getCodeCombo("s_vndr_cust_div_cd", "", "style='width:80px'", "CD00583", 0, "001: :&lt;&lt;Select&gt;&gt;|")%><input type="text" style="width:70px;" name="s_trd_party_val" maxlength="8" id="s_trd_party_val" /><button type="button" id="btn_3rdParty" name="btn_3rdParty" class="input_seach_btn"></button></td>
				</tr>
			</table>
			<table>
				<colgroup>
					<col width="100"/>
					<col width="300"/>
					<col width="100"/>
					<col width="300"/>
					<col width="100"/>
					<col width="*" />				
			   	</colgroup> 
				<tr>
					<th>Source</th>
					<td><% if(s_state.equals("BKG")){ %><SELECT name = "s_n3pty_src_sub_sys_cd" onchange='setSource(this);tpb_searchBillingCaseByExpenseType()' style='width:140px'><OPTION  value=""> ALL</OPTION><OPTION  value="TRS" <% if(p_n3pty_src_sub_sys_cd.equals("TRS")){ %> selected <% } %>> Transportation</OPTION><OPTION  value="TES" <% if(p_n3pty_src_sub_sys_cd.equals("TES")){ %> selected <% } %>> Terminal S/O</OPTION><OPTION  value="MNR" <% if(p_n3pty_src_sub_sys_cd.equals("MNR")){ %> selected <% } %>> Maintenance and Repair</OPTION></SELECT><% }else{ %><%=JSPUtil.getCodeCombo("s_n3pty_src_sub_sys_cd", "", "onchange='setSource(this);tpb_searchBillingCaseByExpenseType()' style='width:140px'", "CD00580", 0, "001: :ALL|")%><% } %></td>
					<th>Invoice No.</th>
					<td><input type="text" style="width:120px;" name="s_n3pty_inv_no" id="s_n3pty_inv_no" /> </td>
					<th>Overdue</th>
					<td><input type="text" style="width:100px;" name="s_overdue" id="s_overdue" />  Days</td>
				</tr>
			</table>
			<table>
				<colgroup>
					<col width="100"/>
					<col width="300"/>
					<col width="100"/>
					<col width="300"/>
					<col width="100"/>
					<col width="*" />				
			   	</colgroup>
				<tr>
					<th>Billing Case</th>
					<td><select name="s_n3pty_bil_tp_cd" id="s_n3pty_bil_tp_cd" style="width:140px;"><option value=''>&lt;&lt;Select&gt;&gt;</option></select></td>
					<th>Booking No.</th>
					<td><input type="text" style="width:120px;" name="s_bkg_no_all" value="<%=p_bkg_no_all%>" maxlength="13" onblur="getBLNo(this.form,this,'s_')" id="s_bkg_no_all" /> </td>
					<th>B/L No.</th>
					<td><input type="text" style="width:100px;" name="s_bl_no_all" maxlength="12" id="s_bl_no_all" /></td>
				</tr>
			</table>
			<table>
				<colgroup>
					<col width="100"/>
					<col width="300"/>
					<col width="100"/>
					<col width="300"/>
					<col width="100"/>
					<col width="*" />				
			   	</colgroup>
				<tr>
					<th title="Vessel Voyage Direction">VVD</th>
					<td><input type="text" style="width:117px;" name="s_vvd" maxlength="9" id="s_vvd" /><button type="button" id="btn_vvd" name="btn_vvd" class="input_seach_btn"></button></td>
					<th>TPB No</th>
					<td><input type="text" style="width:120px;" name="s_n3pty_no_search" maxlength="14" id="s_n3pty_no_search" /></td>
					<th></th>
					<td></td>
				</tr>
			</table>
			<table>
				<colgroup>
					<col width="100"/>
					<col width="300"/>
					<col width="100"/>
					<col width="*" />				
		   		</colgroup>
				<tr>
					<th>R.O.C From</th>
					<td><input type="text" style="width:140px;" name="s_fm_clt_cng_ofc_n3pty_no" id="s_fm_clt_cng_ofc_n3pty_no" /> </td>
					<th>R.O.C To</th>
					<td><input type="text" style="width:140px;" name="s_stl_to_clt_cng_ofc_cd" id="s_stl_to_clt_cng_ofc_cd" /> </td>
				</tr>
			</table>
			<table>
				<colgroup>
					<col width="100"/>
					<col width="300"/>
					<col width="100"/>
					<col width="*" />				
			   	</colgroup>
				<tr>
				    <th>Currency</th>
					<td><%=TPBUtils.getCodeCombo("s_curr_cd_tp", "", "style='width:60' ", "CD01382", 0, "", "")%></td>
				    <th>Amount</th>
					<td><input type="text" style="width:120px;" name="s_ots_amt_from" data_format="integer" id="s_ots_amt_from" />~ <input type="text" style="width:118px;" name="s_ots_amt_to" data_format="integer" id="s_ots_amt_to" /> </td>
				</tr>
			</table>
			<div class="line_bluedot"></div>
			<table>
				<colgroup>
					<col width="100"/>
					<col width="300"/>
					<col width="100"/>
					<col width="300"/>
					<col width="100"/>
					<col width="*" />				
			   	</colgroup>
				<tr>
					<th>Source No.</th>
					<td><input type="radio" name="s_n3pty_src_sub_sys_cd_check" value="TRS" class="trans" onclick="setSource(this)" <%=p_n3pty_src_sub_sys_cd_check_trs%>" id="s_n3pty_src_sub_sys_cd_check" onchange='setSource(this);tpb_searchBillingCaseByExpenseType()'/>&nbsp;&nbsp;TRS&nbsp;&nbsp;&nbsp;&nbsp;<!--  
						 --><input type="radio" name="s_n3pty_src_sub_sys_cd_check" value="TES" class="trans" onclick="setSource(this)" <%=p_n3pty_src_sub_sys_cd_check_tes%>" id="s_n3pty_src_sub_sys_cd_check" onchange='setSource(this);tpb_searchBillingCaseByExpenseType()'/>&nbsp;&nbsp;TES&nbsp;&nbsp;&nbsp;&nbsp;<!-- 
						 --><input type="radio" name="s_n3pty_src_sub_sys_cd_check" value="MNR" class="trans" onclick="setSource(this)" <%=p_n3pty_src_sub_sys_cd_check_mnr%>" id="s_n3pty_src_sub_sys_cd_check" onchange='setSource(this);tpb_searchBillingCaseByExpenseType()'/>&nbsp;&nbsp;MNR&nbsp;&nbsp;&nbsp;&nbsp;<!-- 
						 --><input type="text" style="width:100px;" name="s_n3pty_src_no" maxlength="30" id="s_n3pty_src_no" />
					</td>
					<th>CSR No.</th>
					<td><input type="text" style="width:142px;" name="s_csr_no" id="s_csr_no" /></td>
					<th>Equipment No.</th>
					<td><input type="text" style="width:108px;" name="s_eq_no" maxlength="11" id="s_eq_no" /> </td>
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