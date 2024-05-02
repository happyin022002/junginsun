<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_scg_1015.jsp
*@FileTitle : Application Request & Approval Status - DG
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.26
*@LastModifier : 이도형
*@LastVersion : 1.0
* 2009.06.26 이도형
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
<%@ page import="com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.event.VopScg1015Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopScg1015Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strScgFlg = StringUtil.xssFilter(request.getParameter("scg_flg"));
	String strBkgNo = StringUtil.xssFilter(request.getParameter("bkg_no"));
	String strVslCd = StringUtil.xssFilter(request.getParameter("vsl_cd"));
	String strSkdVoyNo = StringUtil.xssFilter(request.getParameter("skd_voy_no"));
	String strSkdDirCd = StringUtil.xssFilter(request.getParameter("skd_dir_cd"));
	
	Logger log = Logger.getLogger("com.hanjin.apps.CargoLoadingApproval.OwnDangerousCargoApproval");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (VopScg1015Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Application Request & Approval Status - DG</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<body class="popup_bg" onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="scg_flg" value="<%=strScgFlg %>">
<input type="hidden" name="vsl_cd" value="<%=strVslCd %>">
<input type="hidden" name="skd_voy_no" value="<%=strSkdVoyNo %>">
<input type="hidden" name="skd_dir_cd" value="<%=strSkdDirCd %>">
<!-- 개발자 작업	-->

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
	<tr><td class="top"></td></tr>
	<tr>
		<td valign="top">
			<!-- : ( Title ) (S) -->
			<table width="100%" border="0">
				<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Application Request & Approval Status </td></tr>
			</table>
			<!-- : ( Title ) (E) -->
		
			<!--biz page (S)-->
			<table class="search" id="mainTable"> 
	       		<tr>
	       			<td class="bg">
			
						<!--  biz_1  (S) -->
						<table class="search" border="0" style="width:100%;"> 
							<tr class="h23">
								<td width="60">BKG No.</td>
								<td width="790"><input type="text" name="booking_no" style="width:100;" class="input2" readonly value="<%=strBkgNo %>"></td>
								<td id="bkgStsDesc"></td>
							</tr>
						</table>				
						<!--  biz_1   (E) -->
				
						<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
				
						<!-- Grid - 1 (S) -->
						<table width="100%" class="search"  id="mainTable"> 
							<tr>
								<td width="100%">
								<script language="javascript">ComSheetObject('sheet1');</script>
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
						<!-- Grid - 1 (E) -->	
					</td>
				</tr>
			</table>
			<!--biz page (E)--> 
			<!--Button (S) -->
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;">
		     	<tr>
		     		<td class="btn1_bg">
					    <table border="0" cellpadding="0" cellspacing="0">
						    <tr>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td class="btn1_line"></td>
								<td>
									<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_Save">Save</td>
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

			<table class="height_5"><tr><td></td></tr></table>
	
		</td>
	</tr>
</table>
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
	<tr>
		<td height="71" class="popup">
	    	<!--Button (S) -->	
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
		       	<tr>
		       		<td class="btn3_bg">
				    	<table border="0" cellpadding="0" cellspacing="0">
				    		<tr>
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
					</td>
				</tr>
			</table>
	    	<!--Button (E) -->	
		</td>
	</tr>
</table>
<!-- : ( Button : pop ) (E) -->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>