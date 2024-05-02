<%--=========================================================
*	Copyright(c) 2006 CyberLogitec
*	@FileName 	 	: ESD_TRS_0940.jsp
*	@FileTitle 		: Bidding Candidate 정보조회 (Popup)
*	Open Issues 	:
*	Change history 	:
*	@LastModifyDate : 2015-05-28
*	@LastModifier 	: SHIN DONG IL
*	@LastVersion 	: 1.0
* 	2015-05-28
* 	1.0 최초 생성
=========================================================--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.trs.biddingmanage.biddingcandidate.event.EsdTrs0940Event"%>
<%@ page import="com.hanjin.framework.component.util.StringUtil" %>
<%
	EsdTrs0940Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	SignOnUserAccount account = null;
	String strErrMsg = ""; //에러메세지
	String usr_id = "";
	String usr_ofc_cd = "";
	String so_no = "";
	String spot_bid_flg = "";
	String spot_bid_due_dt = "";

	try {
		account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		usr_id = account.getUsr_id();
		usr_ofc_cd = account.getOfc_cd();

		event = (EsdTrs0940Event) request.getAttribute("Event");
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
<title>Bidding Candidate</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
<%=JSPUtil.getIBCodeCombo("trsp_crr_mod_cd", "01", "CD00283", 0, " |")%>
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
	<input type="hidden" name="usr_id" value="<%=usr_id%>">
	<table class="popup" width="100%" cellpadding="10">
		<tr>
	    <td class="top"></td>
	  </tr>
		<tr>
			<td valign="top">
				<!--Page Title, Historical (S)-->
				<table width="100%" border="0">
					<tr>
						<td height="79" class="title"><img src="img/icon_title_dot.gif" align="absmiddle"> Bid Candidate</td>
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
											</tr>
										</table>
									</td>
								</tr>
							</table>
						</td>
					</tr>
					<tr>
						<td>		
							<table width="100%" class="search">
								<tr>
									<td class="bg">
										<!--  biz_1  (S) -->
										<table class="search" border="0" style="width: 100%">
											<tr class="h23">
												<td width="80px">Office</td>
												<td width="80px"><input name="usr_ofc_cd" type="text" style="width: 79;" value="<%=usr_ofc_cd%>" class="input2" readOnly></td>
												<td width ="75%"></td>
											</tr>
										</table>
									</td>
								</tr>
							</table>
						</td>
					</tr>
					<tr>
						<td>	
							<table class="height_10"><tr><td></td></tr></table>
						</td>
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
													<script language="javascript">ComSheetObject('sheet2');</script>
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
																<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
																	<tr>
																		<td class="btn1_left"></td>
																		<td class="btn1" name="btn_rowadd">Row Add</td>
																		<td class="btn1_right"></td>
																	</tr>
																</table>
															</td>
															<td>
																<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
																	<tr>
																		<td class="btn1_left"></td>
																		<td class="btn1" name="btn_rowdel">Row Delete</td>
																		<td class="btn1_right"></td>
																	</tr>
																</table>
															</td>
															<td>
																<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
																	<tr>
																		<td class="btn1_left"></td>
																		<td class="btn1" name="btn_ok">OK</td>
																		<td class="btn1_right"></td>
																	</tr>
																</table>
															</td>
															<td>
																<table width="100%" border="0" cellpadding="0"  cellspacing="0" class="button">																	
																	<tr>
																		<td class="btn1_left"></td>
																		<td class="btn1" name="btn_close">Cancel</td>
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