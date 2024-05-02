<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TPB_0122.jsp
*@FileTitle  : JO TPB Candidate Confirmation
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
<%@ page import="com.clt.apps.opus.esd.tpb.jocasemanage.jocandidateconfirm.event.EsdTpb0122Event"%>
<%@ page import="com.clt.apps.opus.esd.tpb.common.TPBUtils"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsdTpb0122Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Server Exception
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

		event = (EsdTpb0122Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		//Add logic information data from the server when loading the initial screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
	
	String[] officeInfo = TPBUtils.getHandleOfficeLevel( ofc_cd, true ); // 0:Office Level / 1:Office Code / 2:RHQ Code / 3:HO Code
	String ofc_top_lvl = JSPUtil.getNull( TPBUtils.getOfficeTopLevel( ofc_cd ) );
	String ofc_lvl = JSPUtil.getNull( officeInfo[0] ); // Office Level
	rhq_cd  = JSPUtil.getNull( officeInfo[2] ); // RHQ Code
%>

<script language="javascript">
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
</head>

<form name="form">
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="s_ofc_top_lvl" value="<%=ofc_top_lvl%>" id="s_ofc_top_lvl" />
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="iPage" id="iPage" />
<input type="hidden" name="s_bkg_no" id="s_bkg_no" />
<input type="hidden" name="s_bkg_no_split" id="s_bkg_no_split" />
<input type="hidden" name="s_bl_no_chk" id="s_bl_no_chk" />
<input type="hidden" name="s_bl_no" id="s_bl_no" />
<input type="hidden" name="s_bl_no_tp" id="s_bl_no_tp" />
<input type="hidden" name="s_vsl_cd" id="s_vsl_cd" />
<input type="hidden" name="s_skd_voy_no" id="s_skd_voy_no" />
<input type="hidden" name="s_skd_dir_cd" id="s_skd_dir_cd" />
<input type="hidden" name="s_office_level" value="<%=ofc_lvl%>" id="s_office_level" />
<input type="hidden" name="s_rhq_cd_for_rhq" value="<%=rhq_cd%>" id="s_rhq_cd_for_rhq" />
<input type="hidden" name="s_ofc_cd_for_rhq" value="<%=ofc_cd%>" id="s_ofc_cd_for_rhq" />
<input type="hidden" name="s_trd_party_val" id="s_trd_party_val" />
<input type="hidden" name="s_vndr_cust_div_cd" id="s_vndr_cust_div_cd" />
<input type="hidden" name="s_n3pty_no_strs_link" id="s_n3pty_no_strs_link" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_inv" id="btn_inv" type="button" style="display:none">Invoice</button><!--
		--><button class="btn_normal" name="btn_retrieve" id="btn_retrieve" type="button">Retrieve</button><!--
		--><button class="btn_normal" name="btn_new" id="btn_new" type="button">New</button><!--
		--><button class="btn_normal" name="btn_save" id="btn_save" type="button">Save</button><!--
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
		<table class="search_in" border="0">
			<colgroup>
				<col width="70"/>			
				<col width="*" />				
			</colgroup> 
			<tr>
				<th>Period</th>
				<td><input class="input1" type="text" name="s_sdate" id="s_sdate" style="width:75px" value="<%=DateTime.addDays(currentDay, -7, "yyyy-MM-dd")%>" required caption="Date" dataformat="ymd">~ <input class="input1" type="text" name="s_edate" style="width:75px;" value="<%=currentDay%>" required="" caption="Date" dataformat="ymd" id="s_edate" /><button type="button" id="btns_calendar2" name="btns_calendar2" class="calendar ir"></button></td>
			</tr>
		</table>
		<table>
			<colgroup>
				<col width="70"/>			
				<col width="230"/>			
				<col width="100"/>			
				<col width="320"/>			
				<col width="70"/>			
				<col width="*" />				
			</colgroup> 
			<tr>
				<th>RHQ</th>
				<td><select class="input1" style="width:130px;" name="s_if_rhq_cd" id="s_if_rhq_cd" caption="RHQ"><option value="" selected>&lt;Select&gt;</option></select></td>
				<th>Control Office</th>
				<td><% if ( ofc_lvl.equals("C") ) { %><select class="input1" style="width:160px;" name="s_if_ctrl_cd" id="s_if_ctrl_cd" caption="Control Office"><option value="<%=ofc_cd%>" selected><%=ofc_cd%></option></select>	<% } else { %><select class="input1" style="width:160px;" name="s_if_ctrl_cd" id="s_if_ctrl_cd" caption="Control Office" disabled><option value="" selected>&lt;Select&gt;</option></select><% } %></td>
				<th>Office</th>
				<td><select class="input1" style="width:100px;" name="s_if_ofc_cd" id="s_if_ofc_cd" required caption="Office"><option value="" selected>&lt;Select&gt;</option></select></td>
			</tr>
		</table>
		<table>
			<colgroup>
				<col width="70"/>			
				<col width="230"/>			
				<col width="100"/>			
				<col width="*" />				
			</colgroup> 
			<tr>
				<th>Candidate</th>
				<td><select name="s_nr" id="s_nr" style="width:130px;"><option value='IR'>New & Reviewed</option><option value='I'>New</option><option value='R'>Reviewed</option><option value='C'>Cancelled</option><% if(ofc_lvl.equals("R")||ofc_lvl.equals("S")||ofc_lvl.equals("H")){ %><option value='N' selected>Non-TPB</option><% } %></select></td>
				<th>Exp. Type</th>
				<td><%=JSPUtil.getCodeCombo("s_n3pty_src_sub_sys_cd", "", "style='width:160px'", "CD00580", 0, "001: :ALL|")%><select name="s_n3pty_bil_tp_cd" id="s_n3pty_bil_tp_cd" style="width:160px;"><option value=''>&lt;&lt;Select&gt;&gt;</option></select></td>
			</tr>
		</table>
		<table>
			<colgroup>
				<col width="70"/>			
				<col width="230"/>			
				<col width="100"/>			
				<col width="320"/>			
				<col width="70"/>			
				<col width="*" />				
			</colgroup> 
			<tr>
				<th title="Vessel Voyage Direction">VVD</th>
				<td><input type="text" style="width:100px;" dataformat="engup" name="s_vvd" maxlength="9" id="s_vvd" /><button type="button" id="btn_vvd" name="btn_vvd" class="input_seach_btn"></button></td>
				<th>Booking No.</th>
				<td><input type="text" style="width:160px;" dataformat="engup" name="s_bkg_no_all" maxlength="13" onblur="getBLNo(this.form,this,'s_')" id="s_bkg_no_all" /> </td>
				<th>B/L No.</th>
				<td><input type="text" style="width:100px;" dataformat="engup" name="s_bl_no_all" maxlength="12" id="s_bl_no_all" /></td>
			</tr>
		</table>
		<table>
			<colgroup>
				<col width="70"/>			
				<col width="230"/>			
				<col width="100"/>			
				<col width="*" />				
			</colgroup> 
			<tr>
				<th>CSR No.</th>
				<td><input type="text" style="width:129px;" name="s_csr_no" dataformat="engup" maxlength="20" id="s_csr_no" /> </td>
				<th>S/P Inv. No.</th>
				<td><input type="text" style="width:160px;" name="s_n3pty_src_no" maxlength="30" id="s_n3pty_src_no" onKeyUp='isApNum2(this);' />
					  <input type="text" style="width:108px;visibility:hidden;width:0" name="s_eq_no" maxlength="11" id="s_eq_no" />
					  <%=JSPUtil.getCodeCombo("s_eq_knd_cd", "", "style='width:100;visibility:hidden;width:0'", "CD01132", 0, "001: :&lt;&lt;Select&gt;&gt;|")%></td>
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
