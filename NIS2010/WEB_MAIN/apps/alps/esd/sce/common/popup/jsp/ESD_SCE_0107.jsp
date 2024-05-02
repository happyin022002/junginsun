<%--
/*=========================================================
*Copyright(c) 2008 CyberLogitec
*@FileName : ESD_SCE_0107.jsp
*@FileTitle : RailETA - History Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2008-06-30
*@LastModifier : JSAN
*@LastVersion : 1.0
* 1.0
=========================================================*/
--%>
<%@ page contentType="text/xml; charset=UTF-8"%>
<%@ page autoFlush="true" buffer="1kb" %>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.framework.support.controller.html.FormCommand"%>
<%@ page import="com.hanjin.apps.alps.esd.sce.common.popup.event.CommonPopUpManageEvent"%>
<%@ page import="com.hanjin.apps.alps.esd.sce.common.util.basic.CodeUtilBC" %>
<%@ page import="com.hanjin.apps.alps.esd.sce.common.util.basic.CodeUtilBCImpl" %>
<%

	SignOnUserAccount account = null; 						//Session 정보
	Exception serverException = null;					 	//서버에서 발생한 에러
	//DBRowSet rowSet = null;	&&&소스품질주석처리							   		//DB ResultSet
	String strErrMsg = "";									//에러메세지
	//int rowCount	 = 0;	&&&소스품질주석처리								  	//DB ResultSet 리스트의 건수
    //String strUsrNm = "";&&&소스품질주석처리

	String cntr_no = request.getParameter("cntr_no") == null ? "" : request.getParameter("cntr_no");
	String eta_tp = request.getParameter("eta_tp") == null ? "" : request.getParameter("eta_tp");
	String eta_yr = request.getParameter("eta_yr") == null ? "" : request.getParameter("eta_yr");

	try {
		account = (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
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
<input    type="hidden" name="cntr_id">
<input    type="hidden" name="cnmv_yr" value="<%=eta_yr%>">


<!-- OUTER - POPUP (S)tart -->
<table width="500" class="popup" cellpadding="10">
<tr><td class="top"></td></tr>
<tr><td valign="top">

		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
			<tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp;Rail ETA</td></tr>
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
              <tr class="h23">

                <td width="90" align="left">Container No.</td>

                <td><input name="cntr_no" value="<%=cntr_no%>" readonly border="0">

			  </tr>
			</table>

            <table class="search" border="0" style="width:100%">
              <tr class="h23">

                <td width="90" align="left">ETA Type.</td>

                <td><input name="eta_tp" value="<%=eta_tp%>" readonly border="0"></td>

			  </tr>
			</table>



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


</body>
</html>
<%@include file="../../../common/commonpopup/include/common.jsp"%>