<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_0906.jsp
*@FileTitle : Multiple Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-13
*@LastModifier : juhyun
*@LastVersion : 1.0
* 2006-10-13 juhyun
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
<%
	Exception serverException   = null;			//서버에서 발생한 에러
	DBRowSet rowSet	  = null;							   //DB ResultSet
	String strErrMsg = "";								 //에러메세지
	int rowCount	 = 0;								  //DB ResultSet 리스트의 건수
	String returnval = ((request.getParameter("returnval")==null )?"":request.getParameter("returnval"));
	String returntitle = ((request.getParameter("returntitle")==null )?"":request.getParameter("returntitle"));
	returntitle ="("+returntitle+")";
	
	String returnrow = ((request.getParameter("returnrow")==null )?"":request.getParameter("returnrow"));
	String openerval = ((request.getParameter("openerval")==null )?"":request.getParameter("openerval"));
	String token = ((request.getParameter("token")==null )?"":request.getParameter("token"));

	try {
	   //SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   //userId=account.getUsr_id();
	   //userAuth=account.getAuth();

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
<title>Multiple Inquiry <%=returntitle%></title>
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
<input	type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="returnval" value="<%=returnval%>">
<input type="hidden" name="returnrow" value="<%=returnrow%>">
<input type="hidden" name="openerval" value="<%=openerval%>">
<input type="hidden" name="token" value="<%=token%>">

<!-- OUTER - POPUP (S)tart -->
<table width="400" class="popup" cellpadding="10" border="0">
<tr><td class="top"></td></tr>
<tr><td valign="top">

		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp; Multiple Inquiry <%=returntitle%></td></tr>
		</table>
		<!-- : ( Title ) (E) -->




		<!-- : ( Search Options ) (S) -->
		<table class="search" align="center">
			<tr><td class="bg">

					<!-- : ( Level Group ) (S) -->
					<!-- : ( From Location ) (S) -->
					<table width="100%" id="mainTable">
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet1');</script>
                        </td></tr>
		            </table>
					<!-- : ( From Location ) (E) -->
					<!-- : ( Level Group ) (E) -->


							<!-- : ( Button : Sub ) (S) -->
							<table width="100%" class="button">
						       	<tr><td class="btn2_bg">
								<table border="0" cellpadding="0" cellspacing="0">
								<tr>

									<!-- Repeat Pattern -->
									<td class="sm"><b>Row Count&nbsp;:&nbsp;</b><input name="row_count" type="text" style="width:30; height:19; text-align:right" value="1" maxlength="3" onFocus="javascript:select()">&nbsp;&nbsp;</td>

									<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn2_left"></td><td class="btn2" id="btng_rowadd" name="btng_rowadd">Row Add</td><td class="btn2_right"></td></tr></table></td>

									<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn2_left"></td><td class="btn2" id="btng_apply" name="btng_apply">Apply</td><td class="btn2_right"></td></tr></table></td>
									<!-- Repeat Pattern -->

								</tr></table>
							</td></tr>
							</table>
							<!-- : ( Button : Sub ) (E) -->

			</td></tr>
		</table>
		<!-- : ( Search Options ) (E) -->

</td>
</tr>
</table>
<!-- OUTER - POPUP (E)nd -->


<table class="height_5"><tr><td></td></tr></table>

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
