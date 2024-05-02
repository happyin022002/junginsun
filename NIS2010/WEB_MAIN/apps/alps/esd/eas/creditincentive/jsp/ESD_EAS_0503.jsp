<%--=========================================================
*	Copyright(c) 2006 CyberLogitec
*	@FileName 	 	: ESD_EAS_0503.jsp
*	@FileTitle 		: Part Credit Total by Maker (Popup)
*	Open Issues 	:
*	Change history 	:
*	@LastModifyDate : 2016-04-26
*	@LastModifier 	: 
*	@LastVersion 	: 1.0
* 	2016-04-26
* 	1.0 최초 생성
=========================================================--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.eas.creditincentive.creditincentivestatus.event.EsdEas0501Event"%>
<%@ page import="com.hanjin.framework.component.util.StringUtil" %>
<%
	EsdEas0501Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	SignOnUserAccount account = null;
	String strErrMsg = ""; //에러메세지

	String s_fm_dt 			= 	StringUtil.xssFilter(request.getParameter("s_fm_dt"));
	String s_to_dt			=  StringUtil.xssFilter(request.getParameter("s_to_dt"));
	String s_mkr_cd 		=  StringUtil.xssFilter(request.getParameter("s_mkr_cd"));
	String s_cr_usd_ofc_cd 	=  StringUtil.xssFilter(request.getParameter("s_cr_usd_ofc_cd"));

	try {
		account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		event = (EsdEas0501Event) request.getAttribute("Event");
		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	} catch (Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Part Credit Total by Maker</title>
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
<!-- OUTER - POPUP (S)tart -->
<body onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
	<input type="hidden" name="f_cmd"> 
	<input type="hidden" name="s_fm_dt" 			value="<%=s_fm_dt%>"> 
	<input type="hidden" name="s_to_dt" 			value="<%=s_to_dt%>">
	<input type="hidden" name="s_mkr_cd" 			value="<%=s_mkr_cd%>">
	<input type="hidden" name="s_cr_usd_ofc_cd" 	value="<%=s_cr_usd_ofc_cd%>">
	
	<table class="popup" width="100%" cellpadding="10">
		<tr>
	    	<td class="top"></td>
	   </tr>
		<tr>
			<td valign="top">
				<!--Page Title, Historical (S)-->
				<table width="100%" border="0">
					<tr>
						<td height="79" class="title"><img src="img/icon_title_dot.gif" align="absmiddle"> Part Credit Total by Maker</td>
					</tr>
				</table>
				<table width="100%" border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td width="100%">
							<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top: 5; , padding-bottom: 10;">
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
													</table>
												</td>
												<td>
													<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
														<tr>
															<td class="btn1_left"></td>
															<td class="btn1" name="btn_downexcel" id="btn_downexcel">Down Excel</td>
															<td class="btn1_right"></td>
													</table>
												</td>
											</tr>
										</table>
									</td>
								</tr>
							</table>
						</td>
					</tr>
					<tr>
						<td style="text-align: Right;font-size:12;font-weight:bold" >(Curr:USD)</td>
					</tr>
					<tr>
						<td>
							<table class="search">
								<tr>
									<td class="bg">
										<!-- Grid 1 (S) -->
										<table width="100%" id="mainTable">
											<tr>
												<td width="100%">
													<script language="javascript">ComSheetObject('sheet1');</script>
												</td>
											</tr>
										</table>
									</td>
								</tr>
							</table>
						</td>
					</tr>
					<tr>
						<td>
							<table class="height_5"><tr><td></td></tr></table>
						</td>
					</tr>
					<tr>
						<td>	
							<table width="100%" class="sbutton">
								<tr>
									<td height="71" class="popup">
										<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top: 5; , padding-bottom: 10;">
											<tr>
												<td class="btn3_bg">
													<table border="0" cellpadding="0" cellspacing="0">
														<tr>
															<td>
																<table width="100%" border="0" cellpadding="0"  cellspacing="0" class="button">																	
																	<tr>
																		<td class="btn1_left"></td>
																		<td class="btn1" name="btn_close">Close</td>
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
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</form>
</body>
</html>