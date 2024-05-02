<%
/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : VOP_OPF_0401_01.jsp
*@FileTitle : Port Time Performance Dashboard Chart Report
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.08
*@LastModifier : 
*@LastVersion : 1.0
* 2012.06.08
* 1.0 Creation
* 2012.06.08 허철용 [CHM-201217512-01] PTRP 화면에 Dashboard 기능 추가
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.vop.opf.porttimeperformancemgt.porttimeperformancemgt.event.VopOpf9401Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopOpf9401Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지

	Logger log = Logger.getLogger("com.hanjin.apps.PortTimePerformanceMgt.PortTimePerformanceMgt");

	String s_fr_dt = "";
	String s_to_dt = "";
	String s_kpi_tgt_yr = "";
	String s_kpi_ver_seq = "";
	String s_rhq_ofc_cd = "";
	String s_port_cd = "";
	String s_slan_cd = "";

	String v_rhq = "";
	String v_vps_port_cd = "";
	String v_slan_cd = "";
	String v_port_kpi_dir_cd = "";
	String v_clpt_ind_seq = "";
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);

		//VOP_OPF_0401 화면에서 parameter로 넘겨주는 데이터 수신 처리
		s_fr_dt = JSPUtil.getNull(request.getParameter("s_fr_dt"));
		s_to_dt = JSPUtil.getNull(request.getParameter("s_to_dt"));
		s_kpi_tgt_yr = JSPUtil.getNull(request.getParameter("s_kpi_tgt_yr"));
		s_kpi_ver_seq = JSPUtil.getNull(request.getParameter("s_kpi_ver_seq"));
		s_rhq_ofc_cd = JSPUtil.getNull(request.getParameter("s_rhq_ofc_cd"));
		s_port_cd = JSPUtil.getNull(request.getParameter("s_port_cd"));
		s_slan_cd = JSPUtil.getNull(request.getParameter("s_slan_cd"));
		
		v_rhq = JSPUtil.getNull(request.getParameter("v_rhq"));
		v_vps_port_cd = JSPUtil.getNull(request.getParameter("v_vps_port_cd"));
		v_slan_cd = JSPUtil.getNull(request.getParameter("v_slan_cd"));
		v_port_kpi_dir_cd = JSPUtil.getNull(request.getParameter("v_port_kpi_dir_cd"));
		v_clpt_ind_seq = JSPUtil.getNull(request.getParameter("v_clpt_ind_seq"));
		
		event = (VopOpf9401Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Port Time Performance Report</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	var s_fr_dt = "<%=s_fr_dt%>";
	var s_to_dt = "<%=s_to_dt%>";
	var s_kpi_tgt_yr = "<%=s_kpi_tgt_yr%>";
	var s_kpi_ver_seq = "<%=s_kpi_ver_seq%>";
	var s_rhq_ofc_cd = "<%=s_rhq_ofc_cd%>";
	var s_port_cd = "<%=s_port_cd%>";
	var s_slan_cd = "<%=s_slan_cd%>";

	var v_rhq = "<%=v_rhq%>";
	var v_vps_port_cd = "<%=v_vps_port_cd%>";
	var v_slan_cd = "<%=v_slan_cd%>";
	var v_port_kpi_dir_cd = "<%=v_port_kpi_dir_cd%>";
	var v_clpt_ind_seq = "<%=v_clpt_ind_seq%>";
	
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
<script language="javascript" src="rpt/script/rdviewer50.js"></script>
</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
	<!--Page Title, Historical (S)-->
	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"></td></tr>
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Port Time Performance Dashboard Report</td></tr>
	</table>
	<!--Page Title, Historical (E)-->
	
	<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">
				<!--  biz_1  (S) -->
				
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="60">Duration</td>
					<td width="210"><input type="text" name="fr_dt" style="width:80; text-align:center;" class="input2" dataformat="ymd" readonly>&nbsp;~&nbsp;<input type="text" name="to_dt" style="width:80;ime-mode:disabled; text-align:center;" class="input2" dataformat="ymd" readonly></td>
					<td width="55">KPI Year</td>
					<td width="110"><input type="text" name="kpi_tgt_yr" style="width:40; text-align:center;" class="input2" readonly>&nbsp;<input type="text" name="kpi_ver_seq" style="width:20;ime-mode:disabled; text-align:center;" class="input2" readonly>
					<td width="30">RHQ</td>
					<td width="75"><input type="text" name="rhq_ofc_cd" style="width:60; text-align:center;" class="input2" readonly></td>
					<td width="30">Port</td>
					<td width="80"><input type="text" name="port_cd" style="width:48; text-align:center;" class="input2" dataformat="engup" maxlength="5" caption="Port" readonly></td>
					<td width="30">Lane</td>
					<td width="80"><input type="text" name="slan_cd" style="width:40; text-align:center;" class="input2" dataformat="engup" maxlength="3" caption="Lane" readonly></td>
					<td width="200"></td>
					<td>
						<input type="hidden" name="port_kpi_dir_cd">
						<input type="hidden" name="clpt_ind_seq">
					</td>
				</tr>	
				</table>
	<!--  biz_1   (E) -->			
			</td>
			</tr>	
			</table>
		
		<table class="height_5"><tr><td colspan="8"></td></tr></table>
		
		<OBJECT id=rdViewer
	            classid="clsid:5A7B56B3-603D-4953-9909-1247D41967F8"
	            codebase="/hanjin/rpt/cab/rdviewer50u.cab#version=5,0,0,273"
	            width="100%" height="700">
	    </OBJECT>

		<table class="height_5"><tr><td colspan="8"></td></tr></table>
		
		<!-- Grid BG Box  (S) -->
     	<table width="100%"  class="search"> 
       	<tr><td class="bg">
				<!-- Grid (S) -->
				<table width="100%" id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
				<!-- Grid (E) -->	
	</td></tr>
	</table>
	<!-- Grid BG Box  (S) -->
	
	<!--Button (S) -->
	<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn2_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" id="btn_retrieve" name="btn_save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
		    	<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" id="btn_print" name="btn_print">Print</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" id="btn_close" name="btn_close">Close</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			</tr>
			</table>
		</td></tr>
	</table>
    <!--Button (E) -->
	<!--biz page (E)-->
	
	</td></tr>
	</table>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>