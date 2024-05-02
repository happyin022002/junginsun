<%
/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TPB_0104.jsp
*@FileTitle  : EAC Registration 
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
<%@ page import="com.clt.apps.opus.esd.tpb.candidatemanage.manualregister.event.EsdTpb0104Event"%>
<%@ page import="com.clt.apps.opus.esd.tpb.common.TPBUtils"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.apps.opus.esd.tpb.common.combo.basic.CommonCodeBCImpl"%>

<%
	EsdTpb0104Event  event = null;				//PDTO(Data Transfer Object including Parameters)
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
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		//out.println(strUsr_id);
		strUsr_nm = account.getUsr_nm();
		ofc_cd = account.getOfc_cd();
		//cnt_cd = account.getCnt_cd();
		cnt_cd = JSPUtil.getNull(new CommonCodeBCImpl().getMDMCntCd(ofc_cd));

		event = (EsdTpb0104Event)request.getAttribute("Event");
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
<!--
<%= JSPUtil.getIBCodeCombo("combo01", "01", "CD01132", 0, "")%>

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {			
			ComShowMessage(errMessage);
		} // end if
		loadPage();
		_text_ChangeUpperCase(); // automatic change to uppercase
	}
//-->
</script>


<form method="post" name="form" onSubmit="return false;">
<input id="f_cmd" name="f_cmd" type="hidden" />
<input id="pagerows" name="pagerows" type="hidden" />
<!-- 개발자 작업	-->
<input id="iPage" name="iPage" type="hidden" />
<input id="s_n3pty_if_tp_cd" name="s_n3pty_if_tp_cd" value="S" type="hidden" />
<input id="s_bil_tp_cd" name="s_bil_tp_cd" type="hidden" />
<input id="s_bkg_no" name="s_bkg_no" type="hidden" />
<input id="s_bkg_no_split" name="s_bkg_no_split" type="hidden" />
<input id="s_bl_no_chk" name="s_bl_no_chk" type="hidden" />
<input id="s_bl_no" name="s_bl_no" type="hidden" />
<input id="s_bl_no_tp" name="s_bl_no_tp" type="hidden" />
<input id="s_vsl_cd" name="s_vsl_cd" type="hidden" />
<input id="s_skd_voy_no" name="s_skd_voy_no" type="hidden" />
<input id="s_skd_dir_cd" name="s_skd_dir_cd" type="hidden" />
<input id="s_vndr_cnt_cd" name="s_vndr_cnt_cd" type="hidden" />
<input id="s_vndr_seq" name="s_vndr_seq" type="hidden" />
<input id="s_cust_cnt_cd" name="s_cust_cnt_cd" type="hidden" />
<input id="s_cust_seq" name="s_cust_seq" type="hidden" />
<input id="s_n3pty_ofc_cd" name="s_n3pty_ofc_cd" type="hidden" />
<input id="s_src_vndr_cnt_cd" name="s_src_vndr_cnt_cd" type="hidden" />
<input id="s_src_vndr_seq" name="s_src_vndr_seq" type="hidden" />


<input id="s_ofc_cd" name="s_ofc_cd" type="hidden" value="<%=ofc_cd%>" />
<input id="s_rhq_cd" name="s_rhq_cd" type="hidden" value="<%=rhq_cd%>" />
<input id="s_cnt_cd" name="s_cnt_cd" type="hidden" value="<%=cnt_cd%>" />

<input id="s_sdate" name="s_sdate" type="hidden" value='<%=DateTime.addDays(currentDay, -7, "yyyy-mm-dd") %>' />
<input id="s_edate" name="s_edate" type="hidden" value="<%=currentDay%>" />
<input id="s_user_id" name="s_user_id" type="hidden" value="<%=strUsr_id%>" type="hidden" />
<!--  <input type="hidden" name="s_eq_tp_cd">-->
<input id="s_eq_knd_cd" name="s_eq_knd_cd" type="hidden" />
<input id="s_eq_no" name="s_eq_no" type="hidden" />
<input id="s_if_amt" name="s_if_amt" type="hidden" />
<input id="s_reg_type" name="s_reg_type" value="G" type="hidden" />
<input id="s_jo_display" name="s_jo_display" value="N" type="hidden" />
<input id="isChecked" name="isChecked" value="1" type="hidden" />
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
		<button type="button" id="btn_new" name="btn_new" class="btn_accent">New</button><!--
		--><button type="button" id="btn_save" name="btn_save" class="btn_normal">Save</button><!--
		--></div>
	<!-- opus_design_btn (E) -->
	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->

<div class="wrap_search ">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry">
		<table>
			<tbody>
				<colgroup>
					<col width="10" />
					<col width="55" />
					<col width="120" />
					<col width="50" />
					<col width="20" />
					<col width="10" />
					<col width="100" />
					<col width="615" />
					<col width="50" />
					<col width="*" />
				</colgroup>
				<tr class="h23">
					<td></td>
					<th>EAC Type</th>
					<td><%=TPBUtils.getCodeCombo("s_edn_tp_cd", "", "style='width:150', class='input1'  required caption='EAC Type'", "CD00587", 0, "001: :Select|", "")%></td>
					<th>Expense Type</th>
					<td><%=TPBUtils.getCodeCombo("s_n3pty_expn_tp_cd", "", "style='width:150' class='input1'  onchange='changeBillingCase(this.form)' required caption='Expense Type'", "CD00578", 0, "001: :Select|", "")%></td>
					<th>Billing Case</th>
					<td><select class="input1" name="s_n3pty_bil_tp_cd" id="s_n3pty_bil_tp_cd" style="width:120px;" required caption="Billing Case">
						<option value=''>Select</option></select>
						</td>
					<td></td> 
				</tr>
			</tbody>
		</table>
		
		<div class="opus_design_grid "><table class="line_bluedot"><tr><td colspan="6"></td></tr></table></div>
		
		<table>
			<tbody>
				<colgroup>
					<col width="10" />
					<col width="55" />
					<col width="120" />
					<col width="50" />
					<col width="20" />
					<col width="10" />
					<col width="100" />
					<col width="615" />
					<col width="50" />
					<col width="*" />
				</colgroup>
				<tr>
					<td></td>
					<th>Office</th>
					<td><%=TPBUtils.getCodeCombo("s_edn_tp_cd", "", "style='width:150', class='input1'  required caption='EAC Type'", "CD00587", 0, "001: :Select|", "")%></td>
					<th>S/P Invoice No.</th>
					<td><input id="s_n3pty_src_no" class="input1" style="width:129px;" name="s_n3pty_src_no" required="" caption="S/P Invoice" maxlength="30" type="text" /></td>
					<th>S/P</th>
					<td><input id="s_src_vndr_no" class="input1" style="width:97px;" name="s_src_vndr_no" maxlength="6" required="" caption="S/P" type="text" /><button class="input_seach_btn" name="btn_3rdParty_v" id="btn_3rdParty_v" type="button"></button></td>
					<td></td> 
				</tr>
				<tr>
					<td></td>
					<th>Booking No.</th>
					<td><input id="s_bkg_no_all" class="input1" style="width:99px;" name="s_bkg_no_all" maxlength="13" type="text" /></td>
					<th>Bill of Lading No.</th>
					<td><input id="s_bl_no_all" style="width:129px;" name="s_bl_no_all" maxlength="12" type="text" /></td>
					<th>Currency</th>
					<td><select class="input1" style="width: 100px;" name="s_curr_cd" id="s_curr_cd" required caption="Currency"><option value="" selected>Select</option></select></td>
					<td></td> 
				</tr>
				<tr>
					<td></td>
					<th>Date</th>
					<td><input id="s_if_dt" name="s_if_dt" style="width:76px;" value="<%=currentDay%>" data_format="ymd" caption="Date" onkeydown="tpb_isNumD(this, 'Y');" onblur="tpb_validateDateObj(this);" type="text" /><button class="calendar ir" name="btns_calendar1" id="btns_calendar1" type="button"></button></td>
					<th title="Vessel Voyage Direction">VVD</th>
					<td><input id="s_vvd" style="width: 130px;" name="s_vvd" maxlength="9" type="text" /><button class="input_seach_btn" name="btn_vvd" id="btn_vvd" type="button"></button></td>
					<th>Location</th>
					<td><input id="s_yd_cd" style="width:97px;" name="s_yd_cd" maxlength="7" type="text" /><button class="input_seach_btn" name="btn_location" id="btn_location" type="button"></button></td>
					<td></td> 
				</tr>
			</tbody>
		</table>
		
		<table>
			<tbody>
				<colgroup>
					<col width="10" />
					<col width="55" />
					<col width="500" />
					<col width="*" />
				</colgroup>
				<tr>
					<td></td>
					<th>3rd Party</th>
					<td><%=JSPUtil.getCodeCombo("s_vndr_cust_div_cd", "", "style='width:75' class='input1' required  caption='3rd Party'", "CD00583", 0, "001: :Select|")%><!-- 
					 --><input class="input1" type="text" style="width:70;" name="s_trd_party_val" id="s_trd_party_val" maxlength="8" !readonly><!-- 
					 --><button type="button" id="btn_3rdParty" name="btn_3rdParty" class="input_seach_btn"></button><!-- 
					   --><input class="input1" type="text" style="width:710;" name="s_trd_party_nm" id="s_trd_party_nm" readonly></td> 
				</tr>
				<tr>
					<td></td>
					<th>Remarks</th>
					<td><textarea name="s_if_rmk" id="s_trd_party_val" class="input" style="width:100%; height:70px;resize:none;" maxlength="1000"></textarea></td> 
				</tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>
		
<div class="wrap_result">
	<div class="opus_design_grid">
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_add" id="btn_add">Row Add</button>
		</div>
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>
</form>