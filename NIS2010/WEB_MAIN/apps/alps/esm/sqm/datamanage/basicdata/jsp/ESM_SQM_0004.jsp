<%
/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : ESM_SQM_0004.jsp
*@FileTitle      : Basic Data Creation Popup
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.05.15
*@LastModifier   : SQM USER
*@LastVersion    : 1.0
* 2013.05.15 SQM USER
* 1.0 Creation
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	String p_bse_tp_cd  = JSPUtil.getParameter(request, "f_bse_tp_cd", "");
	String p_bse_yr     = JSPUtil.getParameter(request, "f_bse_yr", "");
	String p_bse_qtr_cd = JSPUtil.getParameter(request, "f_bse_qtr_cd", "");
	
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	
	Logger log = Logger.getLogger("com.hanjin.apps.datamanage.basicdata");
	
	try {
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
<title>Basic Data Creation</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<script language="javascript">
	
	var curTitle = "Basic Data Creation";
	var curDescription = "Basic Data Creation";
	var p_bse_tp_cd = "<%=p_bse_tp_cd%>";
	
    function setupPage(){
		var errMessage = "";
		
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		
		loadPage();
	}
</script>
<body onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="f_fm_wk">
<input type="hidden" name="f_to_wk">
<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0">
	<tr><td class="top"></td></tr>
	<tr>
		<td valign="top">
			<!-- : ( Title ) (S) -->
			<table width="100%" border="0">
				<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
			</table>
			<!-- : ( Title ) (E) -->
			
			<!-- : ( Search Options ) (S) -->
			<table class="search">
				<tr>
					<td class="bg">
						<table class="search">
							<tr class="h23">
								<td class="gray_tit" colspan="2"><img src="/hanjin/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0">Establishing Target</td>
							</tr>
							<tr>
								<td width="170">
									<table class="search_sm2" width="160">
										<tr class="h23">
											<td width="65"><input type="radio" class="trans" name="f_bse_tp_cd" value="Y" disabled><label style="padding-left:2;">Yearly</label></td>
											<td><input type="radio" class="trans" name="f_bse_tp_cd" value="Q" disabled><label style="padding-left:2;">Quarterly</label></td>
										</tr>
									</table>
								</td>
								<td>
									<table class="search2" border="0">
										<tr class="h23">
											<td width="40">Year</td>
											<td width="60"><input type="text" style="text-align:center;" class="input2" size="4" name="f_bse_yr" value="<%=p_bse_yr%>" readOnly></td>
											<td width="60"><div id="div_qtr">Quarter</div></td>
											<td width="60"><input type="text" style="text-align:center;" class="input2" size="3" name="f_bse_qtr_cd" value="<%=p_bse_qtr_cd%>" readOnly></td>
											<td class="sm"><div id="div_period"></div></td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
						<table class="search"><tr><td class="line_bluedot" style="height:11;"></td></tr></table>
						<table class="search">
							<tr class="h23">
								<td class="gray_tit" colspan="2"><img src="/hanjin/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0">End Week</td>
							</tr>
							<tr>
								<td>
									<table class="search" border="0">
										<tr class="h23">
											<td width="40">Year</td>
											<td width="60"><input type="text" style="text-align:center;" class="input1" size="4" maxlength="4" name="f_year" onchange="period_OnChange();"></td>
											<td width="50">Week</td>
											<td width="50"><input type="text" style="text-align:center;" class="input1" size="2" maxlength="2" name="f_week" onchange="period_OnChange();"></td>
											<td width="70">Duration</td>
											<td width="50"><input type="text" style="text-align:center;" class="input1" size="2" maxlength="2" name="f_duration" onchange="period_OnChange();"></td>
											<td class="sm"><div id="div_period2">&nbsp;</div></td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			<!-- : ( Search Options ) (E) -->
		</td>
	</tr>
</table>
<!-- OUTER - POPUP (E) -->

<table class="height_5"><tr><td></td></tr></table>

<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
	<tr>
		<td height="71" class="popup">
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
				<tr>
					<td class="btn3_bg">
						<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<!-- Repeat Pattern -->
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_Creation" id="btn_Creation">Creation</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td class="btn1_line"></td>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_Close" id="btn_Close">Close</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<!-- Repeat Pattern -->
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
<!-- : ( Button : pop ) (E) -->
</form>
</body>
</html>