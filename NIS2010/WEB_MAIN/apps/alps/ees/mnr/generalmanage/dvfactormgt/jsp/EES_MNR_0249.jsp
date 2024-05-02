<%/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ESS_MNR_0249.jsp
*@FileTitle : DV - Leased Unit
*Open Issues :	ALPS MNR-Total-DV 화면에서 E-Mail 및 Domain관리를 통하여 직접 DV를 문의
*Change history :
*@LastModifyDate : 2011.03.29
*@LastModifier : 김영오
*@LastVersion : 1.0
* History
* 2011.04.28 김영오 [CHM-201108634-01] 메일 전송버튼 텍스트 변경
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.mnr.generalmanage.dvfactormgt.event.EesMnr0249Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
EesMnr0249Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	
	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_eml		= "";
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_eml = account.getUsr_eml();
		
		event = (EesMnr0249Event)request.getAttribute("Event");
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
<title><span id="title"></span></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">       

<script language="javascript">
    var usrId 		= "<%=strUsr_id%>"; 
	
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
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="eq_type">
<input type="hidden" name="pagerows">
<input type="hidden" name="vndr_seq">
<input type="hidden" name="mnr_cntc_prnr_nm">
     
<!-- 개발자 작업	-->
<input type="hidden" name="subject" value="">
<input type="hidden" name="fileKey" value="">
<input type="hidden" name="template" value="EES_MNR_0050_01T.html">
<input type="hidden" name="argument">
<input type="hidden" name="com_recipient" value="">
<input type="hidden" name="com_subject">
<input type="hidden" name="com_content">
<input type="hidden" name="curr_dt">
<input type="hidden" name="com_from" value="<%=strUsr_eml%>">

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr>
		<td valign="top">
			<!--Page Title, Historical (S)-->
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
				<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
	            <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
			</table>
			<!--Page Title, Historical (E)-->
		
			<!--Button (S) -->
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:2;"> 
		       	<tr>
			       	<td class="btn1_bg">
					    <table border="0" cellpadding="0" cellspacing="0">
						    <tr>
						    	<td>   
							    	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn1_left"></td>
										<td class="btn1" name="btn_Retrieve">Retrieve</td>
										<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn1_left"></td>
										<td class="btn1" name="btn_New">New</td>
										<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn1_left"></td>
										<td class="btn1" name="btn_Save">Save</td>
										<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn1_left"></td>
										<td class="btn1" name="btn_Send">Mail Send</td>
										<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
	    	<!--Button (E) -->
		
			<!--biz page (S)-->
			<!--table class="search" id="mainTable"> 
	       		<tr>
		       		<td class="bg">
						<table class="search" border="0" style="width:979;"> 
							<tr class="h23">
								<td width="55">EQ Type</td>
								<td width="100"><script language="javascript">ComComboObject('combo1', 1, 80, 1, 1);</script></td>
								<td width="40">EQ No.</td>
								<td width="215"><input type="text" name="eq_no" style="width:170;" class="input1" required dataformat="engup">&nbsp;<img src="img/btns_multisearch.gif" name="eq_no_multi"width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
								<td width="100">Total Loss Date</td>
								<td><input type="text" name="total_loss_date" style="width:80;text-align:center" class="input1" required dataformat="ymd" maxlength="8">&nbsp;<img src="img/btns_calendar.gif" class="cursor" name="total_loss_date_cal" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
							</tr>
						</table>
					</td>
				</tr>
			</table-->
			
			<table class="height_8"><tr><td></td></tr></table>	
			<table class="search" id="mainTable"> 
	       		<tr>
		       		<td class="bg">	
		
					<!-- Grid  (S) -->
						<table width="100%"  id="mainTable"> 
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('sheet1');</script>
								</td>
							</tr>
						</table>
					<!-- Grid (E) -->	
		
					<!--  Button_Sub (S) -->
					<table width="100%" class="button"> 
				       	<tr>
					       	<td class="btn2_bg">
								<table border="0" cellpadding="0" cellspacing="0">
									<tr>
										<td>
											<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr>
													<td class="btn2_left"></td>
													<td class="btn2" name="btn_RowAdd">Row Add</td>
													<td class="btn2_right"></td>
												</tr>
											</table>
										</td>
										<td>
											<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr>
													<td class="btn2_left"></td>
													<td class="btn2" name="btn_delete">Row Delete</td>
													<td class="btn2_right"></td>
												</tr>
											</table>
										</td>
										<td>
											<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr>
													<td class="btn2_left"></td>
													<td class="btn2" name="btn_DownExcel">Down Excel</td>
													<td class="btn2_right"></td>
												</tr>
											</table>
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
			    	<!-- Button_Sub (E) -->
					</td>
				</tr>
			</table>
			
			<!-- 4 (S) -->
			<table class="height_8"><tr><td></td></tr></table>	
			<table class="search" id="mainTable">
		       	<tr>
			       	<td class="bg" width="100%" valign="top">
						<table class="search" border="0">
							<tr>
								<!--td class="title_h"></td>
								<td class="title_s">..</td-->
							</tr>
							<tr>
								<td class="height_5"></td>
							</tr>
						</table>
						<!-- Grid - 1 (S) -->
						<table class="search" width="100%">
							<tr>
									<!-- Grid - 1  (S) -->
								<table width="100%" id="mainTable">
									<tr>
										<td width="100%">
											<script language="javascript">ComSheetObject('sheet2');</script>
										</td>
									</tr>
								</table>
									<!-- Grid - 1 (E) -->	
									<!--  Button_Sub (S) -->
									<table width="100%" class="button"> 
								       	<tr>
								       		<td class="btn2_bg">
												<table border="0" cellpadding="0" cellspacing="0">
													<tr>
														<td>
															<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
																<tr>
																<td class="btn2_left"></td>
																<td class="btn2" name="btn_RowAdd2">Row Add</td>
																<td class="btn2_right"></td>
																</tr>
															</table>
														</td>
														<td>
															<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
																<tr>
																	<td class="btn2_left"></td>
																	<td class="btn2" name="btn_RowDel2">Row Delete</td>
																	<td class="btn2_right"></td>
																</tr>
															</table>
														</td>
														<td>
															<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
																<tr>
																	<td class="btn2_left"></td>
																	<td class="btn2" name="btn_DownExce2l">Down Excel</td>
																	<td class="btn2_right"></td>
																</tr>
															</table>
														</td>
													</tr>
												</table>
											</td>
										</tr>
									</table>
							    	<!-- Button_Sub (E) -->
							</tr>
						</table>	
						<!-- Grid - 2 (E) -->
					</td>
				</tr>
			</table>		
			<!-- 2 (E) -->	
			<!--biz page (E)-->
		</td>
	</tr>
</table>
	<table class="height_10"><tr><td colspan="8"></td></tr></table>
</form>
</body>
</html>