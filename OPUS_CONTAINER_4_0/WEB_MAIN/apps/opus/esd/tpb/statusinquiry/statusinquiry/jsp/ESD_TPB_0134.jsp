<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TPB_0134.jsp
*@FileTitle : TPB Status by Booking(B/L)
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.tpb.statusinquiry.statusinquiry.event.EsdTpb0134Event"%>
<%@ page import="com.clt.apps.opus.esd.tpb.common.TPBUtils" %>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsdTpb0134Event  event = null;				//PDTO(Data Transfer Object including Parameters)
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

		event = (EsdTpb0134Event)request.getAttribute("Event");
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
	String p_ots_sts_cd = "";
	String p_bkg_no_all = "";
	String p_bl_no_all = "";

	if (s_state.equals("BKG")){
		p_ots_sts_cd = JSPUtil.getNull(request.getParameter("s_ots_sts_cd"));
		p_bkg_no_all = JSPUtil.getNull(request.getParameter("s_bkg_no_all"));
		p_bl_no_all = JSPUtil.getNull(request.getParameter("s_bl_no_all"));
	} else {
		p_bkg_no_all = "";
		p_bl_no_all = "";
		//p_n3pty_src_sub_sys_cd = "001: :ALL|";
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
		<% if ( ofc_lvl.equals("R") ) { %>
			getTPBGenCombo('s_if_ctrl_cd','searchCtrlOffice','F','','2', new Array("s_if_rhq_cd","s_office_level"));
		<% } %>
		loadPage();
		_text_ChangeUpperCase(); // automatic change to uppercase
	}
</script>
</head>

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
<input type="hidden" name="s_ots_sts_cd" value="<%=p_ots_sts_cd%>" id="s_ots_sts_cd">
<input type="hidden" name="s_trd_party_code" id="s_trd_party_code" />
<input type="hidden" name="s_h_vndr_cust_div_cd" id="s_h_vndr_cust_div_cd" />
<input type="hidden" name="s_h_n3pty_inv_no" id="s_h_n3pty_inv_no" />
<input type="hidden" name="s_cfm_dt" id="s_cfm_dt" />
<input type="hidden" name="s_cfm_dt_prev" id="s_cfm_dt_prev" />
<input type="hidden" name="s_cfm_dt_last" id="s_cfm_dt_last" />
<input type="hidden" name="s_user_ofc_cd" value="<%=ofc_cd%>" id="s_user_ofc_cd">
<input type="hidden" name="s_office_level" value="<%=ofc_lvl%>" id="s_office_level">
<input type="hidden" name="s_rhq_cd_for_rhq" value="<%=rhq_cd%>" id="s_rhq_cd_for_rhq">
<input type="hidden" name="s_ofc_cd_for_rhq" value="<%=ofc_cd%>" id="s_ofc_cd_for_rhq">
<input type="hidden" name="s_state" value="<%=s_state%>" id="s_state">


<input type="hidden" name="priv_cd" value="<%=priv_cd%>" id="priv_cd">

<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span>TPB Status by Booking(B/L)</span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn" style="display:none">
		<button class="btn_accent" type="button">Retrieve</button><!--
		--><button class="btn_normal" type="button">New</button><!--
		--><button class="btn_normal" type="button">Settlement</button><!--
		--><button class="btn_normal" type="button">Invoice Creation</button><!--
		--><button class="btn_normal" type="button">Down Excel</button><!--
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
				<col width="70" />				
				<col width="100" />				
				<col width="70" />				
				<col width="*" />				
		   </colgroup> 
		   <tbody>
		   		<tr>
		   			<th>Booking No.</th>
					<td><input type="text" style="width:120px;" name="s_bkg_no_all" value="<%=p_bkg_no_all%>" maxlength="13" readonly onblur="getBLNo(this.form,this,'s_')" id="s_bkg_no_all" /></td>
					<th>B/L No.</th>
					<td><input type="text" style="width:120px;" name="s_bl_no_all" value="<%=p_bl_no_all%>" maxlength="12" readonly id="s_bl_no_all" /></td>
		   		</tr>
		   </tbody>
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