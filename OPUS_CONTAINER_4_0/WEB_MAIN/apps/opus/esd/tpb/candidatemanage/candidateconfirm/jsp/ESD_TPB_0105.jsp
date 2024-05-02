<%
/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TPB_0105.jsp
*@FileTitle  : TPB Candidate Confirmation 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/27
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
<%@ page import="com.clt.apps.opus.esd.tpb.candidatemanage.candidateconfirm.event.EsdTpb0105Event"%>
<%@ page import="com.clt.apps.opus.esd.tpb.common.TPBUtils"%>
<%@ page import="org.apache.log4j.Logger" %>

<% 
	EsdTpb0105Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Server exception
	String strErrMsg = "";						//Error message
	int rowCount	 = 0;						//DB ResultSet list count
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.StatusInquiry.PerformanceInquiry");
	String ofc_cd = "";
	String rhq_cd = "";
	String cnt_cd = "";
	String currentDay = DateTime.getFormatString("yyyy-MM-dd");
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		ofc_cd = account.getOfc_cd();
		cnt_cd = account.getCnt_cd();
		event = (EsdTpb0105Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		//Add logic information data from the server when loading the initial screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
	} catch(Exception e) {
		out.println(e.toString());
	}
	String[] officeInfo = TPBUtils.getHandleOfficeLevel( ofc_cd, true ); // 0:Office Level / 1:Office Code / 2:RHQ Code / 3:HO Code
	String ofc_top_lvl = JSPUtil.getNull( TPBUtils.getOfficeTopLevel( ofc_cd ) );
	String ofc_lvl = JSPUtil.getNull( officeInfo[0] ); // Office Level
	rhq_cd  = JSPUtil.getNull( officeInfo[2] ); // RHQ Code
%>

<script type="text/javascript">
	<%= JSPUtil.getIBCodeCombo("combo01", "01", "CD00583", 0, "")%>
	<%= JSPUtil.getIBCodeCombo("combo02", "02", "CD00902", 0, "")%>

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
		_text_ChangeUpperCase(); // automatic change to uppercase
	}
</script>

<form method="post" name="form">
<input id="pagerows" name="pagerows" type="hidden" />
<input id="s_ofc_top_lvl" name="s_ofc_top_lvl" value="<%=ofc_top_lvl%>" type="hidden" />
<input id="f_cmd" name="f_cmd" type="hidden" />
<input id="iPage" name="iPage" type="hidden" />
<input id="s_bkg_no" name="s_bkg_no" type="hidden" />
<input id="s_bl_no" name="s_bl_no" type="hidden" />
<input id="s_vsl_cd" name="s_vsl_cd" type="hidden" />
<input id="s_skd_voy_no" name="s_skd_voy_no" type="hidden" />
<input id="s_skd_dir_cd" name="s_skd_dir_cd" type="hidden" />
<input id="s_office_level" name="s_office_level" value="<%=ofc_lvl%>" type="hidden" />
<input id="s_rhq_cd_for_rhq" name="s_rhq_cd_for_rhq" value="<%=rhq_cd%>" type="hidden" />
<input id="s_ofc_cd_for_rhq" name="s_ofc_cd_for_rhq" value="<%=ofc_cd%>" type="hidden" />
<input id="s_trd_party_val" name="s_trd_party_val" type="hidden" />
<input id="s_vndr_cust_div_cd" name="s_vndr_cust_div_cd" type="hidden" />
<input id="s_n3pty_no_strs_link" name="s_n3pty_no_strs_link" type="hidden" />

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
		<div style="display: none">
			<button type="button" id="btn_inv" name="btn_inv" id="btn_inv">Invoice</button>
		</div>
		<div style="display: none">
			<!--
			--><button type="button" id="btn_roc" name="btn_roc" id="btn_roc">ROC</button>
		</div>
		<div style="display: none">
			<!--
			--><button type="button" id="btn_wo" name="btn_wo" id="btn_wo">Write-Off</button>
		</div><!--		
		--><button type="button" name="btn_retrieve" id="btn_retrieve" class="btn_accent">Retrieve</button><!--
		--><button type="button" name="btn_new" id="btn_new" class="btn_normal">New</button><!--
		--><button type="button" id="btn_save" name="btn_save" class="btn_normal">Save</button><!--
		--><button type="button" name="btn_downexcel" id="btn_downexcel" class="btn_normal">Down Excel</button><!--
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
	<div class="opus_design_inquiry wFit">
		<table>
			<tbody>
				<colgroup>
					<col width="10" />
					<col width="50" />
					<col width="150" />
					<col width="50" />
					<col width="150" />
					<col width="50" />
					<col width="150" />
					<col width="*" />
				</colgroup>
				<tr>
					<td></td>
					<th>Period</th>
					<td>
						<input class="input1" type="text" name="s_sdate" id="s_sdate" style="width:75px" value="<%=DateTime.addDays(currentDay, -7, "yyyy-MM-dd")%>" required caption="Date" dataformat="ymd">~&nbsp;<!-- 
						--><input class="input1" type="text" name="s_edate" id="s_edate" style="width:75px" value="<%=currentDay%>" required caption="Date" dataformat="ymd"><!--
						--><button class="calendar ir" name="btns_calendar2" id="btns_calendar2" type="button"></button>
					</td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>					
					<td></td> 
				</tr>
				<tr>
					<td></td>
					<th>RHQ</th>
					<td><select class="input1" style="width: 110px;" name="s_if_rhq_cd" id="s_if_rhq_cd" caption="RHQ"><option value="" selected>&lt;Select&gt;</option></select></td>
					<th>Control Office</th>
					<td>
						<% if ( ofc_lvl.equals("C") ) { %>
							<select class="input1" style="width: 100px;" name="s_if_ctrl_cd" id="s_if_ctrl_cd" caption="Control Office">
								<option value="<%=ofc_cd%>" selected><%=ofc_cd%></option>
							</select>
						<% } else { %>
							<select class="input1" style="width: 100px;" name="s_if_ctrl_cd" id="s_if_ctrl_cd" caption="Control Office" disabled>
								<option value="" selected>&lt;Select&gt;</option>
							</select>
						<% } %>
					</td>
					<th>Office</th>
					<td>
					<select class="input1" style="width: 120px;" name="s_if_ofc_cd" id="s_if_ofc_cd" required caption="Office">
						<option value="" selected>&lt;Select&gt;</option>
					</select>
					</td>		
					<td></td> 
				</tr>
				<tr>
					<td></td>
					<th>Candidate</th>
					<td>
						<select class="input1" name="s_nr" id="s_nr" style="width:110px;">
							<option value='IR'>New & Reviewed</option>
							<option value='I'>New</option>
							<option value='R'>Reviewed</option>
							<% if(ofc_lvl.equals("R")||ofc_lvl.equals("S")||ofc_lvl.equals("H")){ %><option value='N' selected>Non-TPB</option><% } %>
						</select>
					</td>
					<th>Expiration Type</th>
					<td>
						<%=JSPUtil.getCodeCombo("s_n3pty_src_sub_sys_cd", "", "style='width:160'", "CD00580", 0, "001: :ALL|")%>
						
						<select name="s_n3pty_bil_tp_cd" id="s_n3pty_bil_tp_cd" style="width: 120px;">
							<option value=''>&lt;Select&gt;</option>
						</select>
					</td>
					<td></td> 
				</tr>
				<tr>
					<td></td>
					<th title="Vessel Voyage Direction">VVD</th>
					<td><input id="s_vvd" style="width:81px;" name="s_vvd" maxlength="9" type="text" dataformat="engup"/><button class="input_seach_btn" name="btn_vvd" id="btn_vvd" type="button"></button></td>
					<th>Booking No.</th>
					<td><input id="s_bkg_no_all" style="width:100px;" name="s_bkg_no_all" maxlength="13" onblur="getBLNo(this.form,this,'s_')" type="text"  dataformat="engup"/> </td>
					<th>B/L No.</th>
					<td><input id="s_bl_no_all" style="width:120px;" name="s_bl_no_all" maxlength="12" type="text" /> </td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<th>CSR No.</th>
					<td><input id="s_csr_no" style="width:163px;" name="s_csr_no" maxlength="20" type="text"  dataformat="engup"/> </td>
					<th>S/P Inv. No.</th>
					<td>
						<input id="s_n3pty_src_no" style="width:160px;" name="s_n3pty_src_no" maxlength="30" type="text" /><!-- 
						 --><input id="s_eq_no" style="width:108px; visibility:hidden; width:0" name="s_eq_no" maxlength="11" type="text" />
						<%=JSPUtil.getCodeCombo("s_eq_knd_cd", "", "style='width:100;visibility:hidden;width:0'", "CD01132", 0, "001: :Select|")%>
					</td>
					<td></td>
					<td></td>
					<td></td>
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