
<%
	/*=========================================================
	 *Copyright(c) 2009 CyberLogitec
	 *@FileName : esm_bkg_0984.jsp
	 *@FileTitle :  Queue Detail_Return to Return Message
	 *Open Issues :
	 *Change history :
	 *@LastModifyDate : 
	 *@LastModifier :
	 *@LastVersion : 1.0
	 * 1.0 Creation
	 =========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page
	import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page
	import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
	String strErrMsg = ""; //error massage
	int rowCount = 0; //DB ResultSet list count

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	boolean bBtn_Disabled = true;
	try {
		SignOnUserAccount account = (SignOnUserAccount) session
				.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

	} catch (Exception e) {
		out.println(e.toString());
	}
  String bkg_no   = JSPUtil.getParameter(request,"bkg_no"); 
  String sr_kind  = JSPUtil.getParameter(request,"sr_kind"); 
  String sr_no    = JSPUtil.getParameter(request,"sr_no"); 
  String pnd_flg  = JSPUtil.getParameter(request,"pnd_flg"); 
  String src_cd   = JSPUtil.getParameter(request,"src_cd"); 
  String sr_crnt_info_cd = JSPUtil.getParameter(request,"sr_crnt_info_cd"); 
  String sr_crnt_sts_cd  = JSPUtil.getParameter(request,"sr_crnt_sts_cd"); 
  String ui_id           = JSPUtil.getParameter(request,"ui_id"); 
  String grp_cd           = JSPUtil.getParameter(request,"grp_cd"); 
  String message = JSPUtil.getParameter(request, "message");
%>	
<html>
<head>
<title> DPCS : Return to Return Message </title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<body class="popup_bg" onLoad="setupPage();">
<div id="debug"></div>
<form name="form">
	<input type="hidden" name="f_cmd"> 
	<input type="hidden" name="pagerows"> 
	<input type="hidden" name="sr_knd_cd"      value="<%=sr_kind%>">
	<input type="hidden" name="sr_no"      value="<%=sr_no%>">
	<input type="hidden" name="bkg_no"      value="<%=bkg_no%>">
	<input type="hidden" name="pnd_flg"      value="<%=pnd_flg%>">
	<input type="hidden" name="usr_id"      value="<%=strUsr_id%>">
	<input type="hidden" name="src_cd"      value="<%=src_cd%>">
	<input type="hidden" name="grp_cd"      value="<%=grp_cd%>">	
<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0">
	<tr>
		<td class="top"></td>
	</tr>
	<tr>
		<td valign="top"><!-- : ( Title ) (S) -->
		<table width="100%" border="0">
			<tr>
				<td class="title"><img src="./img/icon_title_dot.gif"
					align="absmiddle">&nbsp;DPCS : Return to Return Message</td>
				</tr>
		</table>
		
	<!-- : ( Search Options ) (S) -->
 
			<table class="search"> 
       		<tr><td class="bg">
				<!-- : ( Grid ) (S) -->
				<table width="100%" class="grid2"> 
				<tr>
					<td class="tr2_head" width="60">Message</td>
					<td align="center"><textarea rows="4" style="width:100%" name="message"></textarea></td>
					</tr>
				</table> 
				<!-- : ( Grid ) (E) -->	
		    <!-- : ( Button : Grid ) (E) -->	
			
			</td></tr>
		</table>
	<!-- : ( Search Options ) (E) -->

<table class="height_5"><tr><td></td></tr></table>
		</td>
	</tr>
</table>
	
	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

					<table width="100%" class="button" border="0" cellpadding="0"
						cellspacing="0" style="padding-top: 5; , padding-bottom: 10;">
						<tr>
							<td class="btn3_bg">
									<table border="0" cellpadding="0" cellspacing="0">
										<tr>
											<td id="div_return">
											<table width="100%" border="0" cellpadding="0" cellspacing="0"
												class="button">
												<tr>
													<td class="btn1_left" id="btn_return_to_return_l"></td>
													<td class="btn1" id="btn_return_to_return_c" name="btn_return_to_return">Return to Return</td>
													<td class="btn1_right" id="btn_return_to_return_r"></td>
												</tr>												
											</table>
											</td>										
											<td>
													<table width="72" border="0" cellpadding="0" cellspacing="0"
														class="button">
														<tr>
															<td class="btn1_left"></td>
															<td class="btn1" name="btn_Close">Close</td>
															<td class="btn1_right"></td>
														</tr>
													</table>
											</td>
										</tr>
									</table>
							<!--Button (E) --></td>
						</tr>
					</table>
			</td>
		</tr>
	</table>					
		<!-- : ( Button : pop ) (E) -->

<!-- Developer work end -->
</form>
<div style="display:none">
	<!-- Grid  (S) -->
	<table width="100%"  id="mainTable">
		<tr>
			<td width="100%">
				<script language="javascript">ComSheetObject('sheet1');</script>
			</td>
		</tr>
	</table>
	<!-- Grid (E) -->
</div>
</body>
</html>
