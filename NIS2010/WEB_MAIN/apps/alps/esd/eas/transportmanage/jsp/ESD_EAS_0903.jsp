<%--
/*=========================================================
*Copyright(c) 2008 CyberLogitec
*@FileName : ESD_EAS_0903.jsp
*@FileTitle : Remark Detail 조회/추가/수정
*Open Issues :
*Change history :
*@LastModifyDate : 2008-11-24
*@LastModifier : Yaini
*@LastVersion : 1.0
* 2008-11-24 Yaini
* 1.0 최초 생성
=========================================================*/
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.eas.transportmanage.event.EsdEas0903Event"%>
<%@ page import="com.hanjin.framework.component.util.StringUtil" %>


<%
    EsdEas0903Event event           = null;     //PDTO(Data Transfer Object including Parameters)
    Exception       serverException = null;     //서버에서 발생한 에러
    DBRowSet        rowSet      = null;                         //DB ResultSet

    String          strErrMsg   = "";                           //에러메세지

    int             rowCount    = 0;                            //DB ResultSet 리스트의 건수
    SignOnUserAccount account = null;

	String bkg_no = StringUtil.xssFilter(request.getParameter("bkg_no"));
	String so_ofc_cd = StringUtil.xssFilter(request.getParameter("so_ofc_cd"));
    
	try {
        account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);

        event = (EsdEas0903Event)request.getAttribute("Event");
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
<title>Route UnMatch List Detail 조회</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            showErrMessage(errMessage);
        } // end if

        loadPage();
        //_text_ChangeUpperCase(); // automatic change to uppercase;
    }
</script>
</head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input	type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="bkg_no" value="<%=bkg_no%>">
<input type="hidden" name="so_ofc_cd" value="<%=so_ofc_cd%>">

<!-- OUTER - POPUP (S)tart -->
<table width="800" class="popup" cellpadding="10">
<tr><td class="top"></td></tr>
<tr><td valign="top">

					<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
						<table width="100%" border="0">
						<tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp;Route Unmatch - B/L vs. S/O Detail</td></tr>
						</table>
					<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->

					<!-- TABLE '#D' : ( Grid ) (S) -->
					<!-- Detail Top Start -->
			     		<table class="search">
				       		<tr><td class="bg">

							<table class="height_10"><tr><td></td></tr></table>

							<!-- : ( POR ) (S) -->
							<table width="750" id="mainTable">
				              <tr><td>
				                     <script language="javascript">ComSheetObject('sheet1');</script>
				              </td></tr>
							</table>
							<!-- : ( POR ) (E) -->

						</td></tr>
					</table>
					<!-- TABLE '#D' : ( Grid ) (E) -->
					<!-- Detail Top End -->


					<!-- TABLE '#D' : ( Grid ) (S) -->
					<!-- Detail Down Start -->
			     		<table class="search">
			       			<tr><td class="bg">

							<table class="height_10"><tr><td></td></tr></table>

							<!-- : ( POR ) (S) -->
							<table width="100%" id="mainTable">
					              <tr><td>
					                     <script language="javascript">ComSheetObject('sheet2');</script>
					              </td></tr>
							</table>
							<!-- : ( POR ) (E) -->

						</td></tr>
					</table>
					<!-- TABLE '#D' : ( Grid ) (E) -->
					<!-- Detail Down End -->

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
