<%--
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CIM_0070.jsp
*@FileTitle : UC-VOL_DTL
*Open Issues :
*Change history :
*@LastModifyDate : 2014.07.04
*@LastModifier : DO-HYUN KIM
*@LastVersion : 1.0
* 1.0 최초 생성 
-------------------------------------------------------------------
* History

=========================================================*/
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	String vol_dtl_gb = JSPUtil.getNull(request.getParameter("vol_dtl_gb"));
	String uc_cs_no = JSPUtil.getNull(request.getParameter("uc_cs_no"));
	String bl_no = JSPUtil.getNull(request.getParameter("bl_no"));
	String ctrt_ttl_vol_ctnt = JSPUtil.getNull(request.getParameter("ctrt_ttl_vol_ctnt"));
	String cntr_list = JSPUtil.getNull(request.getParameter("cntr_list"));
	String is_read_only = JSPUtil.getNull(request.getParameter("is_read_only")).trim();
%>
<html>
<head>
<title>UC VOL_DTL</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		/*
		var errMessage = "<%//=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		*/
		loadPage();
	}
</script>
</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->

<input type="hidden" name="iPage">
<input type="hidden" name="vol_dtl_gb" value="<%=vol_dtl_gb%>">
<input type="hidden" name="uc_cs_no" value="<%=uc_cs_no%>">
<input type="hidden" name="bl_no" value="<%=bl_no%>">
<input type="hidden" name="ctrt_ttl_vol_ctnt" value="<%=ctrt_ttl_vol_ctnt%>">
<input type="hidden" name="cntr_list" value="<%=cntr_list%>">
<input type="hidden" name="s_readonly" value="<%=is_read_only %>">
<!-- OUTER - POPUP (S)tart -->
<table width="300" class="popup" cellpadding="10" border="0">
<tr><td class="top"></td></tr>
<tr><td valign="top">

		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp;UC VOL_DTL</td></tr>
		</table>
		<!-- : ( Title ) (E) -->

        <div id="tabLayer" style="display:inline">
		<!-- TABLE '#D' : ( Tab BG Box ) (S) -->
     	<table class="search" border="0">
       	<tr><td class="bg">

			<table class="height_10"><tr><td></td></tr></table>

			<!-- : ( Grid : Week ) (S) -->

            <table width="100%" height="100%" id="mainTable" border="0">
                <tr><td>
                     <script language="javascript">ComSheetObject('sheet1');</script>
                </td></tr>
            </table>
			<!-- : ( Grid : Week ) (E) -->

			<!-- : ( Button : Sub ) (S) -->
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
				<tr><td class="btn1_bg">

						<table border="0" cellpadding="0" cellspacing="0" align="center">
						<tr>
							<!-- Repeat Pattern -->
							<% if(!"".equals(bl_no)){ // %>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_ok" id="btn_ok">OK</td><td class="btn1_right"></td></tr></table></td>
							<% } %>	
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_close" id="btn_close">Close</td><td class="btn1_right"></td></tr></table></td>
							<!-- Repeat Pattern -->

						</tr>
						</table>

				</td></tr>
			</table>
	    	<!-- : ( Button : Sub ) (E) -->

			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Tab BG Box ) (E) -->
        </div>

</td></tr>
</table>
<!-- OUTER - POPUP (E)nd -->

<table class="height_10"><tr><td></td></tr></table>

</form>
</body>
</html>