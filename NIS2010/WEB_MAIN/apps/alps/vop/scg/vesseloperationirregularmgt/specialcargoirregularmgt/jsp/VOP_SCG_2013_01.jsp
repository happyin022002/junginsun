<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_scg_2013_01.jsp
*@FileTitle : Supporting Documents or Pictures
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.08
*@LastModifier : 김현욱
*@LastVersion : 1.0
* 2009.06.08 김현욱
* 1.0 Creation
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.component.util.StringUtil" %>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.vop.scg.vesseloperationirregularmgt.specialcargoirregularmgt.event.VopScg201301Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopScg201301Event  event = null;			//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.VesselOperationIrregularMgt.SpecialCargoIrregularMgt");
	
	String file_pop_kind = "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (VopScg201301Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		file_pop_kind = StringUtil.xssFilter(request.getParameter("file_pop_kind"));

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Supporting Documents or Pictures</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		
		//Change title of page
		var titleStr = "Supporting Documents or Pictures";
		if('approval' == '<%=file_pop_kind%>') {
		    var titleStr = "Attach File";
		}
		try {
			var appName = navigator.appName;
		 	if (appName.indexOf("Netscape") == -1) {
		  		document.all.title.innerHTML = '&nbsp; '+titleStr;
		  		document.title = titleStr;
		 	} else {
		  		document.getElementById("title").innerHTML = '&nbsp; '+titleStr;
		  		document.title = titleStr;
		 	}
		}catch(err) {
		 	ComShowMessage(err);
		}
		
		loadPage("<%=file_pop_kind%>");
	}
</script>
</head>

<body class="popup_bg" onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<input type="hidden" name="vsl_cd" value="<%=StringUtil.xssFilter(request.getParameter("vsl_cd"))%>">
<input type="hidden" name="skd_voy_no" value="<%=StringUtil.xssFilter(request.getParameter("skd_voy_no"))%>">
<input type="hidden" name="skd_dir_cd" value="<%=StringUtil.xssFilter(request.getParameter("skd_dir_cd"))%>">
<input type="hidden" name="spcl_cgo_irr_seq" value="<%=StringUtil.xssFilter(request.getParameter("spcl_cgo_irr_seq"))%>">

<!-- 개발자 작업	-->

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
	<tr><td class="top"></td></tr>
	<tr>
		<td valign="top">
	
			<!-- : ( Title ) (S) -->
			<table width="100%" border="0">
				<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title">Supporting Documents or Pictures</span></td></tr>
			</table>
			<!-- : ( Title ) (E) -->
			
			<!-- : ( Search Options ) (S) --> 
			<table class="search"> 
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
						<table width="100%" class="button" id="btnLayer"> 
				       		<tr>
				       			<td class="btn2_bg">
									<table border="0" cellpadding="0" cellspacing="0">
										<tr>
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" name="btn_FileAdd">File&nbsp;Add</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" name="btn_Delete">File Delete</td>
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
			<!-- : ( Search Options ) (E) -->

<table class="height_5"><tr><td></td></tr></table>	
		</td>
	</tr>
</table> 
	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
	<tr>
		<td height="71" class="popup">
	
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       			<tr>
       				<td class="btn3_bg">
		    			<table border="0" cellpadding="0" cellspacing="0">
		    				<tr>
		    				<td>
								<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr>
									<td class="btn1_left"></td>
									<td class="btn1" name="btn_OK">OK</td>
									<td class="btn1_right"></td>
									</tr>
								</table>
								</td>	
								<td class="btn1_line"></td>			
								<td>
									<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_Close">Close</td>
											<td class="btn1_right">
										</tr>
									</table>
								</td>
							</tr>
						</table>
    					<!--Button (E) -->
	
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
<!-- : ( Button : pop ) (E) -->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>
<%@include file="/bizcommon/include/common_nis2010.jsp"%>