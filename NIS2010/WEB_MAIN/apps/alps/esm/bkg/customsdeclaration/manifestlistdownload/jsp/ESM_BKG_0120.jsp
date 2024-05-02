<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ui_bkg_0120.jsp
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
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strMenuType 		= "Origin";
	Logger log = Logger.getLogger("com.hanjin.apps.CustomsDeclaration.ManifestListDownload");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		if ("ESM_BKG_0120_2".equals(request.getParameter("pgmNo")))
		{
			strMenuType = "Canada";
		}	
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
<title>CANADA ACI (Advance Commercial Information) Main Menu</title>
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

<body  onLoad="setupPage();">
<form name="form" method="post">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="menu_type" value="<%=strMenuType%>">
<!-- 개발자 작업	-->

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr>
		<td valign="top">

<!--Page Title, Historical (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
</table>
<!--Page Title, Historical (E)-->

<!--biz page (S)-->

<table class="search">
	<tr>
		<td class="bg">
			<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="450" valign="top">
						<table class="search" border="0">
							<tr><td class="title_h"></td>
								<td class="title_s">Origin Office</td></tr>
						</table>
						<table class="search_sm" border="0">
							<tr>
								<td>
									<table class="search" border="0">
										<tr class="h23"><td>Preparation</td></tr>
									</table>
									<table class="search" border="0" style="width:390;">
										<tr class="h23">
											<td width="">
												<table width="350" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" style="text-align:left;" name="btn_1_1">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
															<span id="btn_1_1" onmouseover="obj_MouseOver('btn_1_1')" onmouseout="obj_MouseOut('btn_1_1')">1. ETL & CRN Inquiry</span></td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
										</tr>
										<tr class="h23">
											<td width="">
												<table width="350" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr><td class="btn2_left"></td>
													<td class="btn2" style="text-align:left" name="btn_1_2">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
														<span id="btn_1_2" onmouseover="obj_MouseOver('btn_1_2')" onmouseout="obj_MouseOut('btn_1_2')">2. Manifest Data Input Cross-Check</span></td>
													<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
										</tr>
										<tr class="h23">
											<td width="">
												<table width="350" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr><td class="btn2_left"></td>
													<td class="btn2" style="text-align:left" name="btn_1_3">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
														<span id="btn_1_3" onmouseover="obj_MouseOver('btn_1_3')" onmouseout="obj_MouseOut('btn_1_3')">3. House B/L Data Input Cross-Check</span></td>
													<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
										</tr>
									</table>
									<table class="height_10"><tr><td colspan="8"></td></tr></table>
									<table class="search" border="0">
										<tr class="h23">
											<td>Manifest Transmit</td></tr>
									</table>
									<table class="search" border="0" style="width:390;">
										<tr class="h23">
											<td width="">
												<table width="350" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2"  style="text-align:left" name="btn_1_4">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
															<span id="btn_1_4" onmouseover="obj_MouseOver('btn_1_4')" onmouseout="obj_MouseOut('btn_1_4')">1. Customs Data Download (D/L)</span></td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
										</tr>
										<tr class="h23">
											<td width="">
												<table width="350" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr><td class="btn2_left"></td>
													<td class="btn2"  style="text-align:left" name="btn_1_5">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
														<span id="btn_1_5" onmouseover="obj_MouseOver('btn_1_5')" onmouseout="obj_MouseOut('btn_1_5')">2. Manifest Transmit(A6A)</span></td>
													<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
										</tr>
									</table>
									<table class="height_10"><tr><td colspan="8"></td></tr></table>
									<table class="search" border="0">
										<tr class="h23">
											<td>Manifest  Amend</td>
										</tr>
									</table>
									<table class="search" border="0" style="width:390;"> 
										<tr class="h23">
											<td width="">
												<table width="350" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr><td class="btn2_left"></td>
													<td class="btn2"  style="text-align:left" name="btn_1_6">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
														<span id="btn_1_6" onmouseover="obj_MouseOver('btn_1_6')" onmouseout="obj_MouseOut('btn_1_6')">1. Amendment Transmit</span></td>
													<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
										</tr>
										<tr class="h23">
											<td width=""><table width="350" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr><td class="btn2_left"></td>
												<td class="btn2"  style="text-align:left" name="btn_1_7">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
														<span id="btn_1_7" onmouseover="obj_MouseOver('btn_1_7')" onmouseout="obj_MouseOut('btn_1_7')">2. B/L Inquiry</span></td>
												<td class="btn2_right"></td>
												</tr>
												</table></td>
										</tr>
									</table>
										
									<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
									<table class="search" border="0">
										<tr class="h23">
											<td>Report</td>
										</tr>
									</table>
									<table class="search" border="0" style="width:390;"> 
										<tr class="h23">
											<td width="">
												<table width="350" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2"  style="text-align:left" name="btn_1_8">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
															<span id="btn_1_8" onmouseover="obj_MouseOver('btn_1_8')" onmouseout="obj_MouseOut('btn_1_8')">1. Transmission History</span></td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
										</tr>
										<tr class="h23">
											<td width="">
												<table width="350" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2"  style="text-align:left" name="btn_1_9">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
															<span id="btn_1_9" onmouseover="obj_MouseOver('btn_1_9')" onmouseout="obj_MouseOut('btn_1_9')">2. Receiving History</span></td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
										</tr>
										<tr class="h23">
											<td width="">
												<table width="350" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" style="text-align:left" name="btn_1_10">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
															<span id="btn_1_10" onmouseover="obj_MouseOver('btn_1_10')" onmouseout="obj_MouseOut('btn_1_10')">3. ACI Report</span></td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</td>
					<td width="" valign="top">
						<table class="search" border="0">
						<tr><td class="title_h"></td>
							<td class="title_s">Canada Office</td></tr>
						</table>
						<table class="search_sm" border="0">
							<tr>
								<td>
									<table class="search" border="0">
										<tr class="h23">
											<td>I/B Documentation</td></tr>
									</table>
									<table class="search" border="0" style="width:390;"> 
										<tr class="h23">
											<td width="">
												<table width="350" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" style="text-align:left" name="btn_2_1">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
															<span id="btn_2_1" onmouseover="obj_MouseOver('btn_2_1')" onmouseout="obj_MouseOut('btn_2_1')">1. ETL & CRN Inquiry</span></td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
										</tr>
										<tr class="h23">
											<td width="">
												<table width="350" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" style="text-align:left" name="btn_2_2">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
															<span id="btn_2_2" onmouseover="obj_MouseOver('btn_2_2')" onmouseout="obj_MouseOut('btn_2_2')">2. Customs Data Download (D/L)</span></td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
										</tr>
										<tr class="h23">
											<td width="">
												<table width="350" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" style="text-align:left" name="btn_2_3">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
															<span id="btn_2_3" onmouseover="obj_MouseOver('btn_2_3')" onmouseout="obj_MouseOut('btn_2_3')">3. Manifest Transmit(A6A)</span></td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
										</tr>
										<tr class="h23">
											<td width="">
												<table width="350" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" style="text-align:left" name="btn_2_4">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
															<span id="btn_2_4" onmouseover="obj_MouseOver('btn_2_4')" onmouseout="obj_MouseOut('btn_2_4')">4. Vessel Arrival Transmit (A6)</span></td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
										</tr>
										<tr class="h23">
											<td width="">
												<table width="350" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" style="text-align:left" name="btn_2_5">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
															<span id="btn_2_5" onmouseover="obj_MouseOver('btn_2_5')" onmouseout="obj_MouseOut('btn_2_5')">5. C/A Report (I/B)</span></td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
										</tr>
										<tr class="h23">
											<td width="">
												<table width="350" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" style="text-align:left" name="btn_2_6">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
															<span id="btn_2_6" onmouseover="obj_MouseOver('btn_2_6')" onmouseout="obj_MouseOut('btn_2_6')">6. Amendment Transmit</span></td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
										</tr>
										<tr class="h23">
											<td width="">
												<table width="350" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" style="text-align:left" name="btn_2_7">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
															<span id="btn_2_7" onmouseover="obj_MouseOver('btn_2_7')" onmouseout="obj_MouseOut('btn_2_7')">7. B/L Inquiry</span></td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
										</tr>
									</table>
									<table class="height_10"><tr><td colspan="8"></td></tr></table>	
									<table class="search" border="0">
										<tr class="h23">
											<td>Notice</td>
										</tr>
									</table>
									<table class="search" border="0" style="width:390;"> 
										<tr class="h23">
											<td width="">
												<table width="350" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" style="text-align:left" name="btn_2_8">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
															<span id="btn_2_8" onmouseover="obj_MouseOver('btn_2_8')" onmouseout="obj_MouseOut('btn_2_8')">1. Advice Notes</span></td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
										</tr>
									</table>
									<table class="height_10"><tr><td colspan="8"></td></tr></table>	
									<table class="search" border="0">
										<tr class="h23">
											<td>Code / Set-up</td>
										</tr>
									</table>
											
									<table class="search" border="0" style="width:390;"> 
										<tr class="h23">
											<td width="">
												<table width="350" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" style="text-align:left" name="btn_2_9">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
															<span id="btn_2_9" onmouseover="obj_MouseOver('btn_2_9')" onmouseout="obj_MouseOut('btn_2_9')">1. CRN (Conveyance Ref. No.) Create</span></td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
										</tr>
										<tr class="h23">
											<td width="">
												<table width="350" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" style="text-align:left" name="btn_2_10">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
															<span id="btn_2_10" onmouseover="obj_MouseOver('btn_2_10')" onmouseout="obj_MouseOut('btn_2_10')">2. Vessel Information Setup</span></td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
										</tr>
										<tr class="h23">
											<td width="">
												<table width="350" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" style="text-align:left" name="btn_2_11">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
															<span id="btn_2_11" onmouseover="obj_MouseOver('btn_2_11')" onmouseout="obj_MouseOut('btn_2_11')">3. Location of Goods Setup</span></td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
										</tr>
									</table>
									<table style="height:15"><tr><td colspan="8"></td></tr></table>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
<table class="height_10"><tr><td colspan="8"></td></tr></table>
	
<!-- 본문끝 -->
		</td>
	</tr>
</table>
<!-- 본문끝 -->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>