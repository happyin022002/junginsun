<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TES_2008.jsp
*@FileTitle : Guarantee TPB I/F
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.11
*@LastModifier : yOng hO lEE
*@LastVersion : 1.0
* 2009.11.11 yOng hO lEE
* 1.0 Creation
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.tes.guaranteemanage.tpbinterfacemanage.event.EsdTes2008Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsdTes2008Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	
	Logger log = Logger.getLogger("com.hanjin.apps.GuaranteeManage.TPBInterfaceManage");
	
	String		gnte_no			= JSPUtil.getParameter(request, "gnte_no		".trim(), "");
	String		curr_cd			= JSPUtil.getParameter(request, "curr_cd		".trim(), "");
	String		cntr_seq		= JSPUtil.getParameter(request, "cntr_seq		".trim(), "");
	String		irr_no_if_flg	= JSPUtil.getParameter(request, "irr_no_if_flg	".trim(), "");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		
		event = (EsdTes2008Event)request.getAttribute("Event");
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
<title>Guarantee TPB I/F</title>
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
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="gnte_no"			value="<%=gnte_no %>">
<input type="hidden" name="gnte_curr_cd"	value="<%=curr_cd %>">
<input type="hidden" name="cntr_seq"		value="<%=cntr_seq %>">
<input type="hidden" name="irr_no_if_flg"	value="<%=irr_no_if_flg %>">
<!-- 개발자 작업	-->

<!-- OUTER - POPUP (S)tart -->
<table width="500" class="popup" cellpadding="10" border="0">
	<tr><td class="top"></td></tr>
	<tr><td valign="top">

		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp;3rd Party Interface</td></tr>
		</table>
		<!-- : ( Title ) (E) -->

		<!-- : ( Search Options ) (S) -->

		<table class="search">
      		<tr><td class="bg">
			<table class="search" border="0" style="width:464;">
				<tr class="h23" align="right">
					<td>Currency</td>
					<td width="65">
						<select name="curr_cd">
							<option value="USD">USD</option>
							<option value="CAD">CAD</option>
						</select>
					</td>
				</tr>
			</table>

			<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>


		<!-- Grid  (S) -->
			
		<table width="100%"  id="mainTable"> 
			<tr>
				<td width="100%">
					<script language="javascript">ComSheetObject('sheet1');</script>
				</td>
			</tr>
		</table> 
			<!-- Grid (E) -->
				<!-- : ( Button : Grid ) (S) -->
				<!--  Button_Sub (S) -->
			<table width="100%" class="button">
	       		<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0">
						<td width="72"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_save">Save</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
				</table>
				</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
		    <!-- : ( Button : Grid ) (E) -->

			</td></tr>
		</table>
<!-- : ( Search Options ) (E) -->

</td></tr>
</table>
<!-- OUTER - POPUP (E)nd -->

<table class="height_5"><tr><td></td></tr></table>

<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
	<tr><td height="71" class="popup">

		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>

				<!-- Repeat Pattern -->
				<td width="72">
					<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td><td class="btn1" name="btn_ok">OK</td><td class="btn1_right"></td></tr>
					</table>
				</td>

				<td class="btn1_line"></td>

				<td width="72">
					<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td><td class="btn1" name="btn_close">Close</td><td class="btn1_right"></td></tr>
					</table>
				</td>
				<!-- Repeat Pattern -->


			</tr>
		</table>

		</td></tr>
	</table>
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>