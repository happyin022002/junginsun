<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_0933.jsp
*@FileTitle : Multi-stop Location Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-10
*@LastModifier : juhyun
*@LastVersion : 1.0
* 2006-11-10 juhyun
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
<%@ page import="com.hanjin.apps.alps.esd.trs.common.multistoplocationinquiry.event.EsdTrs0933Event"%>
<%
	EsdTrs0933Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	DBRowSet rowSet	  = null;							   //DB ResultSet
	String strErrMsg = "";								 //에러메세지
	int rowCount	 = 0;								  //DB ResultSet 리스트의 건수
	//String successFlag = "";
	//String codeList  = "";
	//String pageRows  = "100";

	String bkgnumber  = "";
	String blnumber   = "";
	String cntrnumber = "";
	String tpsznumber = "";
	String troseqnumber = "";
	
	bkgnumber = ((request.getParameter("bkgnumber")==null )?"":request.getParameter("bkgnumber"));
	blnumber = ((request.getParameter("blnumber")==null )?"":request.getParameter("blnumber"));
	cntrnumber = ((request.getParameter("cntrnumber")==null )?"":request.getParameter("cntrnumber"));
	tpsznumber = ((request.getParameter("tpsznumber")==null )?"":request.getParameter("tpsznumber"));
	troseqnumber = ((request.getParameter("troseqnumber")==null )?"":request.getParameter("troseqnumber"));

	try {

	   //SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   //userId=account.getUsr_id();
	   //userAuth=account.getAuth();

		event = (EsdTrs0933Event)request.getAttribute("Event");

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
<title>Multi-stop Location Inquiry</title>
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

<!-- OUTER - POPUP (S)tart -->
<table width="800" class="popup" cellpadding="10" border="0">
<tr><td class="top"></td></tr>
<tr><td valign="top">

		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp; Multi-stop Location Inquiry</td></tr>
		</table>
		<!-- : ( Title ) (E) -->


		<!-- : ( Search Options ) (S) -->
     	<table class="search">
       	<tr><td class="bg">

			<table class="search" border="0">
			<tr class="h23">
				<td width="10%">Booking No.</td>
				<td width="18%"><input name="bkgnumber" type="text" style="width:100" value="<%=bkgnumber%>" readonly  class="input2"  title="This inputbox cant't write"></td>
				<td width="7%">B/L No.</td>
				<td width="18%"><input name="blnumber" type="text" style="width:100" value="<%=blnumber%>" readonly  class="input2"  title="This inputbox cant't write"></td>
				<td width="12%">Container No.</td>
				<td width="17%"><input name="cntrnumber" type="text" style="width:100" value="<%=cntrnumber%>" readonly  class="input2"  title="This inputbox cant't write"></td>
				<td width="9%">Type/Size</td>
				<td><input name="tpsznumber" type="text" style="width:60" value="<%=tpsznumber%>" readonly  class="input2"  title="This inputbox cant't write"></td>
				<input name="troseqnumber" type="hidden" style="width:60" value="<%=troseqnumber%>" readonly  class="input2"  title="This inputbox cant't write">
			</tr>
			</table>

		</td></tr>
		</table>
		<!-- : ( Search Options ) (E) -->


		<table class="height_10"><tr><td></td></tr></table>


		<!-- : ( Search Options ) (S) -->
     	<table class="search">
       	<tr><td class="bg">

				<!-- : ( Node / Link ) (S) -->
				<table width="100%" id="mainTable">
		              <tr><td>
		                     <script language="javascript">ComSheetObject('sheet1');</script>
		              </td></tr>
			    </table>
				<!-- : ( Node / Link ) (E) -->


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
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td><td class="btn1" name="btn_close" id="btn_close">Close</td><td class="btn1_right"></td></tr></table></td>
				<!-- Repeat Pattern -->

			</tr>
		</table>

	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->


</form>

</body>
</html>
