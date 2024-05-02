<%--
 - Copyright(c) 2016 CyberLogitec
 - @FileName : ESM_ACM_0039.jsp
 - @FileTitle : VIP Agreement Creation
 - Open Issues :
 - Change history :
 - @LastModifyDate :
 - @LastModifier :
 - @LastVersion :
 - 2016.05.18 김상현 1.0 Creation.
--%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="com.hanjin.framework.component.util.JSPUtil" %>
<%@ page import="com.hanjin.framework.component.util.DateTime" %>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler" %>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse" %>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys" %>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount" %>
<%@ page import="com.hanjin.apps.alps.esm.acm.acmagreement.vipdeductagreement.event.EsmAcm0039Event" %>
<%@ page import="com.hanjin.bizcommon.util.BizComUtil" %>
<%@ page import="org.apache.log4j.Logger" %>
<%
	EsmAcm0039Event event = null;     // PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; // 서버에서 발생한 에러
	String strErrMsg = "";            // 에러메세지

	String usrId = "";
	String trdCdStr = "";

	try {
		SignOnUserAccount account = (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		usrId = account.getUsr_id();

		event = (EsmAcm0039Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse)request.getAttribute("EventResponse");
		trdCdStr = eventResponse.getETCData("trdCdStr");
	} catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>

	<head>
		<title>VIP Agreement Creation</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<script type="text/javascript">
			var trdCdStr = "*|<%=trdCdStr %>";
			<%=JSPUtil.getIBCodeCombo("proTp", "", "CD00888", 0, "") %>

			function setupPage() {
				var errMessage = "<%=strErrMsg %>";
				if (errMessage.length >= 1) {
					ComShowMessage(errMessage);
				}
	
				loadPage();
			}
		</script>
	</head>

	<body onLoad="setupPage();">
		<form name="form">
		<input type="hidden" name="f_cmd" />
		<input type="hidden" name="pagerows" />
		<input type="hidden" name="upd_usr_id" value="<%=usrId %>" />

		<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding:2px 0px 0px 5px; border:0px #ff0000 solid; width:1002px;">
			<tr>
				<td valign="top">

					<!-- Page Title, Historical (S) -->
					<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
						<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
						<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
					</table>
					<!-- Page Title, Historical (E) -->

					<!-- 상단 button 영역 -->
					<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding:5px 0px 10px 0px;">
						<tr>
							<td class="btn1_bg">
								<table border="0" cellpadding="0" cellspacing="0">
									<tr>
										<td>
											<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr>
													<td class="btn1_left"></td>
													<td class="btn1" name="btn_retrieve">Retrieve</td>
													<td class="btn1_right"></td>
												</tr>
											</table>
										</td>
										<td class="btn1_line"></td>
										<td>
											<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr>
													<td class="btn1_left"></td>
													<td class="btn1" name="btn_save">Save</td>
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

					<!-- 상단 조회 조건 영역 -->
					<table class="search">
						<tr>
							<td class="bg" valign="top">
								<table width="100%" align="left" border="0" cellpadding="0" cellspacing="0">
									<tr class="h23">
										<td width="50%">
											Group Customer Inquiry
											<input type="text" name="p_cust_grp_id" size="20" maxlength="20" />
											<img class="cursor" name="btn_popup_cust" src="img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle">
										</td>
										<td>
											EQ Type
											<input type="text" name="p_cntr_tpsz_grp_nm" size="20" maxlength="200" />
											<img class="cursor" name="btn_popup_type" src="img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle">
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>

					<table class="line_bluedot"><tr><td></td></tr></table>

					<!-- Grid 및 하단 button 영역 -->
					<table class="search">
						<tr>
							<td class="bg" valign="top">
	            				<table width="100%" id="mainTable">
	              					<tr><td width="100%"><script language="javascript">ComSheetObject("sheet1");</script></td></tr>
								</table>

								<table width="100%" class="button">
									<tr><td class="btn2_bg">
										<table border="0" cellpadding="0" cellspacing="0">
											<tr>
												<td>
													<table border="0" cellpadding="0" cellspacing="0" class="button">
														<tr>
															<td class="btn2_left"></td>
															<td class="btn2" name="btn_add">Row Add</td>
															<td class="btn2_right"></td>
														</tr>
													</table>
												</td>
												<td>
													<table border="0" cellpadding="0" cellspacing="0" class="button">
														<tr>
															<td class="btn2_left"></td>
															<td class="btn2" name="btn_copy">Row Copy</td>
															<td class="btn2_right"></td>
														</tr>
													</table>
												</td>
											</tr>
										</table>
									</td></tr>
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
