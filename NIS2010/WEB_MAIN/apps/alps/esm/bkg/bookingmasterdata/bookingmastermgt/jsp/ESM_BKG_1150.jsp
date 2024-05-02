<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ui_bkg_1150.jsp
*@FileTitle : Edit VVD
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.20
*@LastModifier : 조정민
*@LastVersion : 1.0
* 2012.07.20 조정민
* 1.0 Creation
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.event.EsmBkg1150Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg1150Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String vslCd = "";
	String skdVoyNo = "";
	String skdDirCd = "";
	
	String fileUpTitle = "";
	Logger log = Logger.getLogger("com.hanjin.apps.bookingmasterdata.bookingmastermgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		fileUpTitle = JSPUtil.getParameter(request, "file_up_title");
		if(fileUpTitle != ""){
			if(fileUpTitle.length() >= 63){
				fileUpTitle = fileUpTitle.substring(0, 63) + "...";
			}
		}

		event = (EsmBkg1150Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		vslCd = JSPUtil.getNull(request.getParameter("vslCd"));
		skdVoyNo = JSPUtil.getNull(request.getParameter("skdVoyNo"));
		skdDirCd = JSPUtil.getNull(request.getParameter("skdDirCd"));

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Edit VVD</title>
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
<body  onLoad="setupPage();"> 
<form name="form">
<input type="hidden" name="f_cmd" value="">
<input type="hidden" name="str_vsl_cd"  value="<%=vslCd%>">
<input type="hidden" name="str_skd_voy_no"  value="<%=skdVoyNo%>">
<input type="hidden" name="str_skd_dir_cd"  value="<%=skdDirCd%>">

	<!-- OUTER - POPUP (S)tart -->
	<table width="100%" class="popup" cellpadding="10" border="0"> 
	<tr><td class="top"></td></tr>	
	<tr><td valign="top">
	<!-- : ( Title ) (S) -->
	<table width="100%" border="0">
	<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp; Edit VVD</td></tr>
	</table>
	<!-- : ( Title ) (E) -->
	<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">

				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:100%;" > 
				<tr class="h23">
					<td width="30">VVD </td>
					<td width="120"><input type="text" style="width:40; text-align:left;" name="vsl_cd" class="input1" maxlength="4" dataformat="engupnum" value="<%=vslCd%>">&nbsp;
									<input type="text" style="width:40; text-align:left" name="skd_voy_no" class="input" maxlength="4" dataformat="int" value="<%=skdVoyNo%>">&nbsp;
									<input type="text" style="width:20; text-align:left" name="skd_dir_cd" class="input" maxlength="1" dataformat="engup" value="<%=skdDirCd%>"></td>
					<td width="200" align="left"><input type="text" style="width:200;" name="vsl_nm" class="input2" maxlength="1" dataformat="engup" value="" readonly></td>
				</tr>
				</table>
				<!--  biz_1 (E) -->
												
				
				<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>	
				
				<!-- Grid  (S) -->
				<table width="460"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
			<!-- Grid (E) -->
			<!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0"><tr>				
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_RowAdd">Row&nbsp;Add</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_Delete">Row Delete</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
					</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
				
				
				</td></tr>
			</table>
			
			<!-- Grid (E) -->
			<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" id="btn_retrieve" name="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
						
	
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Close">Close</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>		
					</tr>
				</table></td>
			</tr>
			</table>
		</td></tr>
		</table>
    <!--Button (E) -->
	<!-- Grid BG Box  (S) -->

</form>
</body>
</html>