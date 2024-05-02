<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TPB_0103.js
*@FileTitle  : Repair Estimate EDI Auditing
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/17
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.bizcommon.util.BizComUtil"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.tpb.candidatemanage.manualregister.event.EsdTpb0103Event"%>
<%@ page import="com.clt.apps.opus.esd.tpb.common.TPBUtils"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.apps.opus.esd.tpb.common.combo.basic.CommonCodeBCImpl"%>

<%
	EsdTpb0103Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Server Exception
	String strErrMsg = "";						//Error message
	int rowCount	 = 0;						//DB ResultSet list count

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.CandidateManage.ManualRegister");
	
	String ofc_cd = "";
	String rhq_cd = "";
	String cnt_cd = "";
	String currentDay = DateTime.getFormatString("yyyy-MM-dd");
	
	int p_state = 0;
	String p_n3pty_expn_tp_cd = "";
	String p_n3pty_bil_tp_cd = "";
	String p_bkg_no = JSPUtil.getNull(request.getParameter("p_bkg_no"));
	String p_bl_no = "";
	String p_trd_party_val = "";
	String p_curr_cd = "";
	String p_eq_no = "";
	String p_eq_tpsz_cd = "";
	String p_if_amt = "";
	
	
	
	if(!"".equals(p_bkg_no)){
		p_state = 1;
		p_n3pty_expn_tp_cd = JSPUtil.getNull(request.getParameter("p_n3pty_expn_tp_cd"));
		p_n3pty_bil_tp_cd = JSPUtil.getNull(request.getParameter("p_n3pty_bil_tp_cd"));
		p_bl_no = JSPUtil.getNull(request.getParameter("p_bl_no"));
		p_trd_party_val = JSPUtil.getNull(request.getParameter("p_trd_party_val"));
		p_curr_cd = JSPUtil.getNull(request.getParameter("p_curr_cd"));
		p_curr_cd = "USD";
		p_eq_no = JSPUtil.getNull(request.getParameter("p_eq_no"));
		p_eq_tpsz_cd = JSPUtil.getNull(request.getParameter("p_eq_tpsz_cd"));
		p_if_amt = JSPUtil.getNull(request.getParameter("p_if_amt"));
	}
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		ofc_cd = account.getOfc_cd();
		//cnt_cd = account.getCnt_cd();
		cnt_cd = JSPUtil.getNull(new CommonCodeBCImpl().getMDMCntCd(ofc_cd));
		
		event = (EsdTpb0103Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// Add logic information data from the server when loading the initial screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
	
	String[] officeInfo = TPBUtils.getHandleOfficeLevel( ofc_cd ); // 0:Office Level / 1:Office Code / 2:R.HQ Code / 3:HO Code
	rhq_cd  = JSPUtil.getNull( officeInfo[2] ); // RHQ Code

%>

<script type="text/javascript">
<%= JSPUtil.getIBCodeCombo("combo01", "01", "CD01132", 0, "")%>
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		var p_state = "<%=p_state%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		
		loadPage(p_state); 
		_text_ChangeUpperCase(); // automatic change to uppercase
	}
</script>

<form method="post" name="form" >
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->
<input type="hidden" name="p_state" value="<%=p_state%>">
<input type="hidden" name="p_curr_cd" value="<%=p_curr_cd%>">
<input type="hidden" name="p_eq_no" value="<%=p_eq_no%>">
<input type="hidden" name="p_eq_tpsz_cd" value="<%=p_eq_tpsz_cd%>">
<input type="hidden" name="p_if_amt" value="<%=p_if_amt%>">

<input type="hidden" name="s_tpb_seq">
<input type="hidden" name="s_bil_tp_cd">
<input type="hidden" name="s_bkg_no">
<input type="hidden" name="s_bl_no">
<input type="hidden" name="s_vsl_cd">
<input type="hidden" name="s_skd_voy_no">
<input type="hidden" name="s_skd_dir_cd">
<input type="hidden" name="s_vndr_cnt_cd">
<input type="hidden" name="s_vndr_seq">
<input type="hidden" name="s_cust_cnt_cd">
<input type="hidden" name="s_cust_seq">
<input type="hidden" name="s_n3pty_ofc_cd">
<input type="hidden" name="s_src_vndr_cnt_cd">
<input type="hidden" name="s_src_vndr_seq">
<input type="hidden" name="s_eq_knd_cd">
<input type="hidden" name="s_eq_no">
<input type="hidden" name="s_ofc_cd" value="<%=ofc_cd%>">
<input type="hidden" name="s_rhq_cd" value="<%=rhq_cd%>">
<input type="hidden" name="s_cnt_cd" value="<%=cnt_cd%>">
<input type="hidden" name="s_sdate" value="<%=DateTime.addDays(currentDay, -7, "yyyy-MM-dd")%>">
<input type="hidden" name="s_edate" value="<%=currentDay%>">
<input type="hidden" name="s_jo_display" value="N">
<input type="hidden" name="s_n3pty_if_tp_cd" value="S">

<input type="hidden" name="isChecked" value="1">

<%=JSPUtil.getIncludeString(request) %>
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_new" 		id="btn_new">New</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_save" 			id="btn_save">Save</button>			
	</div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">	
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
	
</div>
<!-- page_title_area(E) -->
<!-- wrap_search(S) -->
<div class="wrap_search">
<!-- opus_design_inquiry(S) -->
<div class="opus_design_inquiry wFit" >
	<table>
		<tbody>
			<colgroup>
				<col width="100" />
				<col width="120" />
				<col width="142" />
				<col width="170" />
				<col width="100" />
				<col width="*" />
			</colgroup>
			<tr class="h23">
				<th>Expense Type</th>
				<% if(p_state == 1){ %>
				<td>
					<select class="input1" name="s_n3pty_expn_tp_cd" id="s_n3pty_expn_tp_cd" style="width:100px;" required caption="Expense Type" onchange="changeBillingCase(this.form)">
					<option value=''>Select</option>
					<option value='TRS'>TRS</option>
					<option value='TES'>TES</option>
					<option value='MNR'>MNR</option>
					</select>
				</td>
				<% }else{ %>
				<td><select class="input1" name="s_n3pty_expn_tp_cd" id="s_n3pty_expn_tp_cd" style="width:100px;" required caption="Expense Type" onchange="changeBillingCase(this.form)">
					<option value=''>Select</option>
					</select>
				</td>
				<% } %>
				<th>TPB Code</th>
				<td><select class="input1" name="s_n3pty_bil_tp_cd" id="s_n3pty_bil_tp_cd" style="width:165px;" required caption="Billing Case">
					<option value=''>Select</option>
					</select></td>
					
				<th></th>
				<td>
				<%//=JSPUtil.getCodeCombo("s_n3pty_if_tp_cd", "", "style='width:110', class='input1'  onchange='changeExpenseType(this.form)' required caption='Interface Type'", "CD00581", 0, "001: :Select|")%>
				<%--=TPBUtils.getCodeCombo("s_n3pty_if_tp_cd", "", "style='width:110px', class='input1'  onchange='changeExpenseType(this.form)' required caption='Interface Type'", "CD00581", 0, "", "!M")--%>
				</td >					
			</tr>			
		</tbody>
	</table>
	</div>	
	
	<div class="line_bluedot"></div>
	
	<div class="opus_design_inquiry wFit" >	
	<table>
		<tbody>
			<colgroup>
				<col width="100" />
				<col width="120" />
				<col width="100" />
				<col width="170" />
				<col width="100" />
				<col width="200" />
				<col width="*" />
			</colgroup>
			<tr>
				<th>Office</th>
				<td><input id="s_if_ofc_cd" class="input1" style="width: 100;" value="<%=ofc_cd%>" required="" caption="Office" name="s_if_ofc_cd" readonly type="text"/></td>
				<th>S/P Invoice No.</th>
				<td><input id="s_n3pty_src_no" class="" style="width: 130px;" name="s_n3pty_src_no"  onKeyUp='upper(this);' maxlength="30" type="text" /></td>
				<th>S/P</th>
				<td><input id="s_src_vndr_no" class="" style="width: 80px;" name="s_src_vndr_no" maxlength="6" type="text" /><button class="input_seach_btn" name="btn_3rdParty_v" id="btn_3rdParty_v" type="button"></button></td>
				<td></td>
			</tr>
			<tr>
				<th>Booking No.</th>
				<td><input id="s_bkg_no_all" class="input1" style="width: 104px;" name="s_bkg_no_all" value="<%=p_bkg_no%>" maxlength="13" type="text" /></td>
				<th>Bill of Lading No.</th>
				<td><input id="s_bl_no_all" style="width: 130px;" name="s_bl_no_all" value="<%=p_bl_no%>" maxlength="12" type="text" /></td>
				<th>Currency</th>
				<% if(p_state == 1){ %>
					<td>
						<select class="input1" style="width: 100px;" name="s_curr_cd" id="s_curr_cd" required caption="Currency">
							<option value="<%=p_curr_cd%>" selected><%=p_curr_cd%></option>
						</select>
					</td>
					<% }else{ %>
					<td>
						<select class="input1" style="width: 108px;" name="s_curr_cd" id="s_curr_cd" required caption="Currency">
							<option value="" selected>Select</option>
						</select>
					</td>
				<% } %>
				<td></td>
			</tr>
			<tr>
				<th>Date</th>
				<td><input id="s_if_dt" name="s_if_dt" style="width: 75px;" value="<%=currentDay%>" data_format="ymd" caption="Date" onkeydown="tpb_isNumD(this, 'Y');" onblur="tpb_validateDateObj(this);" type="text" /><button class="calendar ir" name="btns_calendar1" id="btns_calendar1" type="button"></button></td>
				<th title="Vessel Voyage Direction">VVD</th>
				<td><input id="s_vvd" style="width: 130px;" name="s_vvd" maxlength="9"  type="text" /><button class="input_seach_btn" name="btn_vvd" id="btn_vvd" type="button"></button></td>
				<th>Location</th>
				<td><input id="s_yd_cd" style="width: 80px;" name="s_yd_cd" maxlength="7" type="text" /><button class="input_seach_btn" name="btn_location" id="btn_location" type="button"></button></td>
				<td></td>
			</tr>
		</tbody>
	</table>
	<table>
		<tbody>
			<colgroup>
				<col width="100" />
				<col width="1000" />
				<col width="*" />
			</colgroup>
			<tr>
				<th>3rd Party</th>
				<% if(p_state == 1){ %>
					<td><select name="s_vndr_cust_div_cd" style="width: 75px;"><option value='C' selected>Customer</option></select><input type="text" style="width: 70px;" name="s_trd_party_val" id="s_trd_party_val" value="<%=p_trd_party_val%>" maxlength="8" !readonly><button type="button" class="input_seach_btn" name="btn_3rdParty" id="btn_3rdParty"></button><input type="text" style="width: 710px;" name="s_trd_party_nm" readonly></td>
					<% } else{ %>
					<td><%=JSPUtil.getCodeCombo("s_vndr_cust_div_cd", "", "style='width: 75px'", "CD00583", 0, "001: :Select|")%><input type="text" style="width: 70px;" name="s_trd_party_val" id="s_trd_party_val" value="<%=p_trd_party_val%>" maxlength="8" !readonly><button type="button" class="input_seach_btn" name="btn_3rdParty" id="btn_3rdParty"></button><input type="text" style="width: 810px;" name="s_trd_party_nm" id="s_trd_party_nm" readonly></td>
				<% } %>
				<td></td>
			</tr>
			<tr>
				<th>Remarks</th>
				<td><textarea name="s_if_rmk" id="s_if_rmk" class="input" style="width:992px; height: 70px;"></textarea></td>
				<td></td>
			</tr>
		</tbody>
	</table>
</div>
<!-- opus_design_inquiry(E) -->
</div>
<!-- wrap_search(E) -->

<!-- wrap_result(S) -->
<div class="wrap_result">
<!-- opus_design_grid(S) -->
<div class="opus_design_grid">
	<div class="opus_design_btn">
		<button type="button" class="btn_normal" name="btn_add" id="btn_add">Row Add</button>
	</div>
	<script type="text/javascript">ComSheetObject('sheet1');</script>
</div>
<!-- opus_design_grid(E) -->
</div>
<!-- wrap_result(E) -->
</form>
