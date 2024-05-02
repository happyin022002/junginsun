<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ui_bkg_0433.jsp
*@FileTitle : ACI_Vessel Information
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.24
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2009.04.24 김민정
* 1.0 Creation
=========================================================*/%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.StringUtil" %>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>

<html>
<head>
<title>Canada ACI: View MSG</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	function open_rcv_file(){
		ComOpenWindowCenter("/hanjin/ESM_BKG_0434.do" 
		+ "?pgmNo=ESM_BKG_0434&cnt_cd=CA&io_bnd_cd=I&rcv_dt=" 
		+ <%=StringUtil.xssFilter(request.getParameter("rcv_dt"))%> 
		+ "&rcv_seq=" + <%=StringUtil.xssFilter(request.getParameter("rcv_seq"))%>, "0434", 500, 380, true);
	}
</script>
</head>
<body class="popup_bg">
<form name="form" method="post">
<table width="100%" class="popup" cellpadding="10" border="0"> 
	<tr><td class="top"></td></tr>
	<tr>
		<td valign="top">
			<table width="100%" border="0">
				<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">
				Canada ACI: View MSG</td></tr>
			</table>
			<table class="search">
				<tr>
					<td class="bg">
						<table class="search" border="0" style="width: 480;">
							<tr class="h23">
								<td width="85">997</td>
								<td width="" style="padding-left: 1">
									<input type="text" style="width: 25" value="<%=StringUtil.xssFilter(request.getParameter("p1"))%>" class="input">
									<input type="text" style="width: 360" value="<%=StringUtil.xssFilter(request.getParameter("p2"))%>" class="input"></td>
							</tr>
							<tr class="h23">
								<td width="">824</td>
								<td width="" style="padding-left: 1">
									<input type="text" style="width: 25" value="<%=StringUtil.xssFilter(request.getParameter("p3"))%>" class="input">
									<input type="text" style="width: 360" value="<%=StringUtil.xssFilter(request.getParameter("p4"))%>" class="input">
								</td>
							</tr>
							<tr class="h23">
								<td width="85">BAPLIE</td>
								<td width="" style="padding-left: 1">
									<input type="text" style="width: 25" value="<%=StringUtil.xssFilter(request.getParameter("p9"))%>" class="input">
									<input type="text" style="width: 360" value="<%=StringUtil.xssFilter(request.getParameter("p10"))%>" class="input"></td>
							</tr>
							<tr class="h23">
								<td width="" valign="top">Error Note</td>
								<td width=""><textarea style="width: 100%; height: 70"><%=StringUtil.xssFilter(request.getParameter("p5"))%></textarea>
							</td>
							</tr>
							<tr class="h23">
								<td width="">Reject Code</td>
								<td width="" style="padding-left: 1">
									<input type="text" style="width: 50" value="<%=StringUtil.xssFilter(request.getParameter("p6"))%>" class="input">
								</td>
							</tr>
							<tr class="h23">
								<td width="" valign="top">Field Desc.</td>
								<td width=""><textarea style="width: 100%; height: 70"><%=StringUtil.xssFilter(request.getParameter("p7"))%></textarea></td>
							</tr>
							<tr class="h23">
								<td width="" valign="top">Message Text</td>
								<td width=""><textarea style="width: 100%; height: 70"><%=StringUtil.xssFilter(request.getParameter("p8"))%></textarea></td>
							</tr>
						</table>
					</td>
				</tr>
			</table>

<table class="height_5"><tr><td></td></tr></table>
		</td>
	</tr>
</table>

<table width="100%" class="sbutton">
	<tr>
		<td height="71" class="popup">
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top: 5; , padding-bottom: 10;">
				<tr>
					<td class="btn3_bg">
						<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_view" onclick="open_rcv_file()">View Received File</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td class="btn1_line"></td>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_Close" onClick="window.close()">Close</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
</form>
</body>
</html>