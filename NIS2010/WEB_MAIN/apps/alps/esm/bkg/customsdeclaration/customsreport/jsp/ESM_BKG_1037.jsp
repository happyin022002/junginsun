<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_1037.jsp
*@FileTitle : Rail AMS History
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.01
*@LastModifier : 김도완
*@LastVersion : 1.0
* 2009.09.01 김도완
* 1.0 Creation
* --------------------------------------------------------
* History
* 2010.10.04 최도순 [CHM-201004946] C-flag update 로직 보완 요청
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<%@ page import="com.hanjin.framework.component.util.StringUtil" %>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.usa.event.EsmBkg1037Event"%>
<%@ page import="org.apache.log4j.Logger"%>
<%
	EsmBkg1037Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지

	String strUsr_id = "";
	String strUsr_nm = "";
	String cntr_no = "";
	String vvd = "";
	String blNo = "";

	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg1037Event) request.getAttribute("Event");
		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		cntr_no = StringUtil.xssFilter(request.getParameter("cntr_no"));
		vvd = StringUtil.xssFilter(request.getParameter("vvd"));
		blNo = StringUtil.xssFilter(request.getParameter("bl_no"))==null?"":StringUtil.xssFilter(request.getParameter("bl_no"));
		
	} catch (Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>US AMS : Rail AMS History</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			//showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<body class="popup_bg" onLoad="setupPage();">
<form name="form"><input type="hidden" name="f_cmd"> 
<input type="hidden" name="pagerows">
<input type="hidden" name="pageno" value="ESM_BKG_1037">
<input type="hidden" name="p_bl_no" value="<%=blNo%>">
<!-- 개발자 작업	-->
<table width="100%" class="popup" cellpadding="10" border="0"> 
	<tr><td class="top"></td></tr>
	<tr>
		<td valign="top">
			<table width="100%" border="0">
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp; US AMS : Rail AMS History</td></tr>
			</table>

			<!--biz page (S)-->
			<table class="search" id="mainTable"> 
	       		<tr>
	       			<td class="bg">
					<table class="search" border="0" style="width:100%;"> 
					<tr class="h23">
						<td width="90">Container No.</td>
						<td width="135"><input type="text" name="cntr_no" style="width:88;ime-mode:disabled;" class="input1" maxlength="14" value="<%=cntr_no %>" required readonly></td> 
						<td width="50">B/L No.</td>
						<td width="151"><script language="javascript">ComComboObject('bl_no', 1, 130, 0, 0);</script></td>
						<td width="15">F</td>
						<td width="40"><input type="text" name="f" style="width:20;" class="input2" value="" readonly></td>
						<td width="15">O</td>
						<td width="40"><input type="text" name="o" style="width:20;" class="input2" value="" readonly></td>
						<td width="15">C</td>
						<td><input type="text" name="c" style="width:20;" class="input2" value="" readonly title=""></td>					
					</tr>
					</table>
				
					<table class="search" border="0" style="width:880;">
					<tr class="h23">
						<td width="25">VVD</td>
						<td width="200"><input type="text" name="vvd" style="width:72;" class="input2" value="<%=vvd %>" readonly> <input type="text" name="vsl_nm" style="width:109;" class="input2" value="" readonly></td>
						<td width="25">POL</td>
						<td width="70"><input type="text" name="pol" style="width:50;" class="input2" value="" readonly></td>
						<td width="25">POD</td>
						<td width="70"><input type="text" name="pod" style="width:50;" class="input2" value="" readonly></td>
						<td width="25">ETA</td>
						<td width="100"><input type="text" name="eta" style="width:80;" class="input2" value="" readonly></td>
						<td width="25">DEL</td>
						<td width="80"><input type="text" name="del" style="width:50;" class="input2" value="" readonly></td>
						<td width="25">HUB</td>
						<td width="70"><input type="text" name="hub" style="width:50;" class="input2" value="" readonly></td>
						<td width="65">R/D Term</td>
						<td width=""><input type="text" name="r" style="width:20;" class="input2" value="" readonly> <input type="text" name="d" style="width:20;" class="input2" value="" readonly></td>
					</tr>
					</table>
		
					<table class="search" border="0" style="width:880;">
					<tr class="h23">
						<td width="25">Q'ty</td>
						<td width="198"><input type="text" name="qty" style="width:72;text-align:right;" class="input2" value="" readonly>&nbsp;<input type="text" name="qty_tp" style="width:35;" class="input2" value="" readonly></td>
						<td width="25">WGT</td>
						<td width=""><input type="text" name="wgt" style="width:72;text-align:right;" class="input2" value=""readonly>&nbsp;<input type="text" name="wgt_up" style="width:35;" class="input2" value="" readonly></td>
					</tr>
					</table>
					
					<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
	
					<table width="100%"  id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
					</table></td>
				</tr>
			</table>
			
			
		</td>
	</tr>
</table>

<table width="100%" class="sbutton">
	<tr>
		<td height="71" class="popup">
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
				<tr>
					<td class="btn3_bg">
						<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_Print">Print</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td class="btn1_line"></td>
								<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn1_left"></td>
										<td class="btn1" name="btn_close" onclick="window.close()">Close</td>
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