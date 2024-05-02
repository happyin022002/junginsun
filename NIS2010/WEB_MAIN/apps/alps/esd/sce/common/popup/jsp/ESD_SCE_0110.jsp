<%--=========================================================
*Copyright(c) 2008 CyberLogitec
*@FileName : CESD_SCE_0110.jsp
*@FileTitle : (RCC/LCC/ECC/SCC) 팝업 오픈
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
* 2008-07-21 Hun-Il Jung
* 1.0 최초 생성
=========================================================--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.sce.common.popup.event.EqYardOrzEvent"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EqYardOrzEvent  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.common.popup");
	
	String dist  = JSPUtil.getNull(request.getParameter("dist"));
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EqYardOrzEvent)request.getAttribute("Event");
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
<title>Office</title>
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

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input    type="hidden" name="f_cmd">
<input    type="hidden" name="f_slt_idx" value="0">
<input    type="hidden" name="dist" value="<%=dist%>">


<!-- OUTER - POPUP (S)tart -->
<table width="800" class="popup" cellpadding="10">
<tr><td class="top"></td></tr>
<tr><td valign="top">

		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
			<%if (dist.equals("rcc")){ %>
			<tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp;RCC Inquiry</td></tr>
			<%}else if (dist.equals("lcc")){ %>
			<tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp;LCC Inquiry</td></tr>
			<%}else if (dist.equals("ecc")){ %>
			<tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp;ECC Inquiry</td></tr>
			<%}else if (dist.equals("scc")){ %>
			<tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp;SCC Inquiry</td></tr>
			<% }%>
		</table>
		<!-- : ( Title ) (E) -->

		<!-- TABLE '#D' : ( Button : Main ) (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
				<tr><td class="btn1_bg">

						<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<!-- Repeat Pattern -->
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_new" id="btn_new">New</td><td class="btn1_right"></td></tr></table></td>
							<!-- Repeat Pattern -->

						</tr></table>

				</td></tr>
		</table>
		<!-- TABLE '#D' : ( Button : Main ) (E) -->


		<!-- TABLE '#D' : ( Search Options : Speed ) (S) -->
     	<table class="search">
       	<tr><td class="bg">
				<%if (dist.equals("rcc")){ %>
					<table class="search" border="0" style="width:100%">
						<tr class="h23">
						<td width="30"></td>
						<td width="110"></td>
						<td width="30"></td>
						<td width="110"></td>
						<td width="30"></td>
						<td width="110"></td>
						<td width="30"></td>
						<td width="110"></td>
					</table>
				<%}else if (dist.equals("lcc")){ %>
					<table class="search" border="0" style="width:100%">
						<tr class="h23">
						<td width="30">RCC</td>
						<td width="60">&nbsp;<input name="rcc_txt" type="text" style="width:53; text-transform:uppercase;" value="" onKeyUp="ComChkObjValid(this); this.value.toUpperCase()" ></td>
						<td width="30">Country</td>
						<td width="60"><input name="cnt_txt" type="text" style="width:53; text-transform:uppercase;"  value="" onKeyUp="ComChkObjValid(this);" onBlur="ComChkObjValid(this); " ></td>
						<td width="30"></td>
						<td width="60"></td>
						<td width="30"></td>
						<td width="60"></td>
					</table>
				<%}else if (dist.equals("ecc")){ %>
					<table class="search" border="0" style="width:100%">
						<tr class="h23">
						<td width="30">RCC</td>
						<td width="60">&nbsp;<input name="rcc_txt" type="text" style="width:53" value="" onKeyUp="ComChkObjValid(this); this.value.toUpperCase()" ></td>
						<td width="30">LCC</td>
						<td width="60"><input name="lcc_txt" type="text" style="width:53" value="" onKeyUp="ComChkObjValid(this); this.value.toUpperCase()"></td>
						<td width="30">Country</td>
						<td width="60"><input name="cnt_txt" type="text" style="width:53; text-transform:uppercase;"  value="" onKeyUp="ComChkObjValid(this);" onBlur="ComChkObjValid(this); " ></td>
						<td width="30"></td>
						<td width="60"></td>
					</table>
				<%}else if (dist.equals("scc")){ %>
					<table class="search" border="0" style="width:100%">
						<tr class="h23">
						<td width="30">RCC</td>
						<td width="60">&nbsp;<input name="rcc_txt" type="text" style="width:53" value="" onKeyUp="ComChkObjValid(this); this.value.toUpperCase()" ></td>
						<td width="30">LCC</td>
						<td width="60"><input name="lcc_txt" type="text" style="width:53" value="" onKeyUp="ComChkObjValid(this); this.value.toUpperCase()"></td>
						<td width="30">ECC</td>
						<td width="60"><input name="ecc_txt" type="text" style="width:53" value="" onKeyUp="ComChkObjValid(this); this.value.toUpperCase()" ></td>
						<td width="30">Country</td>
						<td width="60"><input name="cnt_txt" type="text" style="width:53; text-transform:uppercase;"  value="" onKeyUp="ComChkObjValid(this);" onBlur="ComChkObjValid(this); " ></td>
					</table>
				<% } %>
					<table class="height_10"><tr><td></td></tr></table>

				<!-- : ( Speed ) (S) -->
				<table border="0" style="width:100%; background-color:white;" class="grid2"  id="mainTable">
				<tr>
					<td>
                      <script language="javascript">ComSheetObject('sheet');</script>
                    </td>
                 </tr>
				 </table>
				<!-- : ( Speed ) (E) -->

			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options : Speed ) (E) -->




</td></tr>
</table>
<!-- OUTER - POPUP (E)nd -->



<table class="height_10"><tr><td></td></tr></table>


<!-- : ( Button : Sub ) (S) -->
<table width="100%" class="sbutton">
		<tr><td height="71" class="popup">

			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
	       		<tr><td class="btn3_bg">
			    <table border="0" cellpadding="0" cellspacing="0">
			    <tr>

					<!-- Repeat Pattern -->
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" name="btn_ok" id="btn_ok">Ok</td><td class="btn1_right"></td></tr></table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" name="btn_close" id="btn_close">Close</td><td class="btn1_right"></td></tr></table></td>
					<!-- Repeat Pattern -->

				</tr>
			</table>

		</td></tr>
</table>
<!-- : ( Button : Sub ) (E) -->

</form>
</body>
</html>