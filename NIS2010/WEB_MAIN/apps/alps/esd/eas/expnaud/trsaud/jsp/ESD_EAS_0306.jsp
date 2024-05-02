<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ESD_EAS_0306.jsp
*@FileTitle : Tariff Comparison by TRS Agreement
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.11
*@LastModifier : KIM HYUN JOO
*@LastVersion : 1.0
* 2015.02.11 KIM HYUN JOO
* 1.0 Creation
=========================================================*/
%>


<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.eas.expnaud.trsaud.event.EsdEas0306Event"%>
<%@ page import="com.hanjin.framework.component.util.StringUtil"%>

<%
	EsdEas0306Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//Error Message

	String pageRows  = "100";  
	
	// SignOnUserAccount Info
	String usr_id 					= "";
	String strUsr_nm				= "";
	String ofc_cd					= "";
	
	String sel_rhq_ofc_cd = "";
	String sel_wo_ofc_cd = "";
	String wo_iss_pre_mon = "";
	String sel_trsp_so_tp_cd = "";
	String sel_trsp_cost_dtl_mod_cd = "";
	String sel_trsp_crr_mod_cd = "";
	String sel_trsp_bnd_cd = "";
	String sel_fm_nod_cd = "";
	String sel_to_nod_cd = "";
	String sel_via_nod_cd = "";
	String sel_dor_nod_cd = "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_nm 		= account.getUsr_nm();
		usr_id       		= account.getUsr_id();      
		ofc_cd      		= account.getOfc_cd();      

		sel_rhq_ofc_cd = (StringUtil.xssFilter(request.getParameter("sel_rhq_ofc_cd"))==null)?"":StringUtil.xssFilter(request.getParameter("sel_rhq_ofc_cd"));
		sel_wo_ofc_cd = ((StringUtil.xssFilter(request.getParameter("sel_wo_ofc_cd"))==null)?"":StringUtil.xssFilter(request.getParameter("sel_wo_ofc_cd")));
		wo_iss_pre_mon = ((StringUtil.xssFilter(request.getParameter("wo_iss_pre_mon"))==null)?"":StringUtil.xssFilter(request.getParameter("wo_iss_pre_mon")));
		sel_trsp_so_tp_cd = ((StringUtil.xssFilter(request.getParameter("sel_trsp_so_tp_cd"))==null)?"":StringUtil.xssFilter(request.getParameter("sel_trsp_so_tp_cd")));
		sel_trsp_cost_dtl_mod_cd = ((StringUtil.xssFilter(request.getParameter("sel_trsp_cost_dtl_mod_cd"))==null)?"":StringUtil.xssFilter(request.getParameter("sel_trsp_cost_dtl_mod_cd")));
		sel_trsp_crr_mod_cd = ((StringUtil.xssFilter(request.getParameter("sel_trsp_crr_mod_cd"))==null)?"":StringUtil.xssFilter(request.getParameter("sel_trsp_crr_mod_cd")));
		sel_trsp_bnd_cd = ((StringUtil.xssFilter(request.getParameter("sel_trsp_bnd_cd"))==null)?"":StringUtil.xssFilter(request.getParameter("sel_trsp_bnd_cd")));
		sel_fm_nod_cd = ((StringUtil.xssFilter(request.getParameter("sel_fm_nod_cd"))==null)?"":StringUtil.xssFilter(request.getParameter("sel_fm_nod_cd")));
		sel_to_nod_cd = ((StringUtil.xssFilter(request.getParameter("sel_to_nod_cd"))==null)?"":StringUtil.xssFilter(request.getParameter("sel_to_nod_cd")));
		sel_via_nod_cd = ((StringUtil.xssFilter(request.getParameter("sel_via_nod_cd"))==null)?"":StringUtil.xssFilter(request.getParameter("sel_via_nod_cd")));
		sel_dor_nod_cd = ((StringUtil.xssFilter(request.getParameter("sel_dor_nod_cd"))==null)?"":StringUtil.xssFilter(request.getParameter("sel_dor_nod_cd")));

		event = (EsdEas0306Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
	
%>
<html>
<head>
<title>Surcharge Report</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
	<%= JSPUtil.getIBCodeCombo("s_so_tp_cd", "", "CD00279", 0, "")%>
	<%= JSPUtil.getIBCodeCombo("s_trsp_cost_dtl_mod_cd", "", "CD00594", 0, "")%>
	<%= JSPUtil.getIBCodeCombo("s_trsp_crr_mod_cd", "", "CD00794", 0, "")%>
	<%= JSPUtil.getIBCodeCombo("s_trsp_bnd_cd", "", "CD00591", 0, "")%>
</script>
</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="session_usr_nm" value="<%=strUsr_nm%>">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="code_key">
<input type="hidden" name="usr_id" 		value="<%=usr_id%>" >
<input type="hidden" name="ofc_cd" 		value="<%=ofc_cd%>" >

<input type="hidden" name="sel_rhq_ofc_cd" 		value="<%=sel_rhq_ofc_cd%>" >
<input type="hidden" name="sel_wo_ofc_cd" 		value="<%=sel_wo_ofc_cd%>" >
<input type="hidden" name="wo_iss_pre_mon" 		value="<%=wo_iss_pre_mon%>" >
<input type="hidden" name="sel_trsp_so_tp_cd" 		value="<%=sel_trsp_so_tp_cd%>" >
<input type="hidden" name="sel_trsp_cost_dtl_mod_cd" 		value="<%=sel_trsp_cost_dtl_mod_cd%>" >
<input type="hidden" name="sel_trsp_crr_mod_cd" 		value="<%=sel_trsp_crr_mod_cd%>" >
<input type="hidden" name="sel_trsp_bnd_cd" 		value="<%=sel_trsp_bnd_cd%>" >
<input type="hidden" name="sel_fm_nod_cd" 		value="<%=sel_fm_nod_cd%>" >
<input type="hidden" name="sel_to_nod_cd" 		value="<%=sel_to_nod_cd%>" >
<input type="hidden" name="sel_via_nod_cd" 		value="<%=sel_via_nod_cd%>" >
<input type="hidden" name="sel_dor_nod_cd" 		value="<%=sel_dor_nod_cd%>" >

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
<tr>
	<td valign="top">	
	
		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!--Page Title, Historical (E)-->

			
		<!--Button (S) -->
	    <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top: 0; padding-bottom: 2;">
		<tr>
			<td class="btn1_bg">
				<table border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
							<td class="btn1_left"></td>
							<td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
							<td class="btn1_right"></td>
						</tr>
						</table>
					</td>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
							<td class="btn1_left"></td>
							<td class="btn1" name="btn_new" >New</td>
							<td class="btn1_right"></td>
						</tr>
						</table>
					</td>
					<td> 
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
							<td class="btn1_left"></td>
							<td class="btn1" name="btn_downexcel">Down Excel</td>
							<td class="btn1_right"></td>
						</tr>
						</table>
					</td>
				</tr>
				</table>
			</td>
		</tr>
		</table>
		<!--Button (E) -->
		 
		<!--biz page (S)-->
 		<table class="search" > 
       	<tr><td class="bg">
			<table class="search" border="0" style="width: 979;">
				<tr class="h23">
					<td width="10"></td>
					<td width="70">RHQ</td>
					<td width="164">
						<script language="javascript">ComComboObject('s_rhq_ofc_cd',1,100,0,1,0);</script>
					</td>
					
					<td width="10"></td>
					<td width="81">W/O Office</td>
					<td width="153" style="padding-left:0;">
						<script language="javascript">ComComboObject('s_wo_ofc_cd',1,100,0,0,0);</script>
					</td>
					
					<td width="10"></td>
					<td width="120">W/O Issued Month</td>
					<td width="358" style="padding-left:1;">
						<input type="text" name="s_fm_yrmon" dataformat="ym" maxlength="6" size="10" style="width:70;text-align:center;" class="input1">&nbsp;<img name="btns_calendar_s" src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
						&nbsp;~&nbsp;
						<input type="text" name="s_to_yrmon" dataformat="ym" maxlength="6" size="10" style="width:70;text-align:center;" class="input1" value="">&nbsp;<img name="btns_calendar_e" src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
					</td>
					<td width="3"></td>
				</tr>
			</table>
			
			<table ><tr><td></td></tr></table>
			
			<table class="search" border="0" style="width: 979;">		
 				<tr class="h23">
 					<td width="10"></td>
 					<td width="70">S/O Type</td>
					<td width="164">
						<script language="javascript">ComComboObject('s_so_tp_cd',1,100,1,0,0);</script>
					</td>
					
					<td width="10"></td>
	                <td width="80">Cost Mode</td>
					<td width="154">
						<script language="javascript">ComComboObject('s_trsp_cost_dtl_mod_cd',1,100,1,0,0);</script>
					</td>
					
					<td width="10"></td>
					<td width="84">Trans Mode</td>
					<td width="150">
						<script language="javascript">ComComboObject('s_trsp_crr_mod_cd',1,100,1,0,0);</script>
					</td>
					
					<td width="10"></td> 
					<td width="60">Bound</td>
					<td width="174">
						<script language="javascript">ComComboObject('s_trsp_bnd_cd',1,100,1,0,0);</script>
					</td>
					<td width="3"></td>
				</tr>
			</table>
			
			<table ><tr><td></td></tr></table>
			
			<table class="search" border="0" style="width: 979;">		
 				<tr class="h23">
 				
 					<td width="10"></td>
 					<td width="68">From</td>
					<td width="164">
						<input type="text" dataformat="uppernum"  maxlength="7"  style="width: 100; text-align:center;" class="input" name="s_fm_nod_cd" > 
					</td>
					
					<td width="10"></td>
	                <td width="79">Via</td>
					<td width="155">
						<input type="text" dataformat="uppernum"  maxlength="7"  style="width: 100; text-align:center;" class="input" name="s_via_nod_cd" > 
					</td>
					
					<td width="10"></td>
					<td width="83">To</td>
					<td width="151">
						<input type="text" dataformat="uppernum"  maxlength="7"  style="width: 100; text-align:center;" class="input" name="s_to_nod_cd" > 
					</td>
					
					<td width="10"></td>
					<td width="58">Door</td>
					<td width="176">
						<input type="text" dataformat="uppernum"  maxlength="7"  style="width: 100; text-align:center;" class="input" name="s_dor_nod_cd" > 
					</td>
					<td width="3"></td>
				</tr>
			</table>
		</td></tr>
		</table>

	<table class="height_5"><tr><td></td></tr></table>
	<!-- Grid BG Box  (S) -->
	<table class="search" id="mainTable">
	 	<tr><td class="bg" valign="top">
		<!-- Grid  (S) -->
 		<table width="100%"  id="mainTable"> 
			<tr>
				<td width="100%">
					<script language="javascript">ComSheetObject('sheet1');</script>
				</td>
			</tr>
		</table> 
		</td></tr>
	</table> 
	<!-- Button_Sub (E) -->		
			</td>
		</tr>
	</table>
</form>
</body>
</html>
