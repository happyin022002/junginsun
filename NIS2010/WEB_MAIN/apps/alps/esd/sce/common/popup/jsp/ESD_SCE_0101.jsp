<%--
/*=========================================================
*Copyright(c) 2007 CyberLogitec
*@FileName : ESD_SCE_0101.jsp
*@FileTitle : Notified Subscriber - Search Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2008-04-21
*@LastModifier : YuJin
*@LastVersion : 1.0
* 1.0
=========================================================*/
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.sce.common.popup.event.CommonPopUpManageEvent"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	CommonPopUpManageEvent  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지

	Logger log = Logger.getLogger("com.hanjin.apps.common.popup");
	String cop_no = request.getParameter("cop_no") == null ? "" : request.getParameter("cop_no");
//out.println(cop_no);
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);


		event = (CommonPopUpManageEvent)request.getAttribute("Event");
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
<title>Welcome to NMS!</title>
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



<table width="800" class="popup" cellpadding="10">
<tr><td class="top"></td></tr>
<tr><td valign="top">

		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp;COP Summary</td></tr>
		</table>
		<!-- : ( Title ) (E) -->

		<!-- TABLE '#D' : ( Button : Main ) (S) -->
		<table width="100%" class="button">

		</table>
		<!-- TABLE '#D' : ( Button : Main ) (E) -->



		<!-- TABLE '#D' : ( Search Options : Speed ) (S) -->
     	<table class="search">
       	<tr><td class="bg">

            <table class="search" border="0" style="width:100%">
              <tr>

                <td width="60">BKG No. :</td>

                <td id="bkg_no" width="88"></td>

                <td width="60">B/L No. :</td>

                <td id="bl_no" width="90"></td>

                <td width="90">Container No. :</td>

                <td id="cntr_no" width="90"></td>

                <td width="65">COP No. :</td>

                <td id="cop_no1" width="100"><input name="cop_no" value="<%=cop_no%>" type="hidden"  readonly></td>

                <td width="65">R/D Term : </td>

                <td id="rdterm" style="width:30" width=""></td>
							</tr>
				</table>

            <table class="search" border="0" style="width:100%">
              <tr>

                <td width="56" align="right">VVD : </td>

                <td id="vvd" width="68"></td>

                <td width="78" align="right">POR : </td>

                <td id="por" width="75"></td>

                <td width="98" align="right">POL : </td>
                <td id="pol" width="75"></td>

                <td width="60" align="right">POD : </td>

                <td id="pod" width="119"></td>

                <td width="">DEL : </td>

                <td id="del" width=""></td>

			</tr>

					</table>

					<table class="height_10"><tr><td></td></tr></table>

				<!-- : ( Speed ) (S) -->
					<table width="100%" id="mainTable">
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet');</script>
                        </td></tr>
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
<%@include file="/bizcommon/include/common_alps.jsp"%>