<% /*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : UI_ESD_TES_031.jsp
*@FileTitle : Carrier Code 생성/조회
*Open Issues :
*Change history :
*@LastModifyDate : 2006-09-05
*@LastModifier : Jin_seung_Kim
*@LastVersion : 1.0
* 2006-09-05 Jin_seung_Kim
* 1.0 최초 생성
=========================================================*/ %>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.tes.codemanage.codemanage.event.EsdTes0031Event"%>
<%
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";								 //에러메세지
	
	try {
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
	
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	} catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Carrier Code 생성/조회</title>
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
<input type="hidden" name="f_cmd">
<input type="hidden" name="iPage">

<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>


		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->



		<!-- TABLE '#D' : ( Button : Main ) (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
				<tr><td class="btn1_bg">

						<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<!-- Repeat Pattern -->
							<td>
							</td>

							<!-- Repeat Pattern -->

						</tr></table>

				</td></tr>
		</table>
		<!-- TABLE '#D' : ( Button : Main ) (E) -->





		<!-- TABLE '#D' : ( Search Options : Detail Explanation ) (S) -->
     	<table class="search">
       		<tr><td class="bg">


			<!-- : ( From Location ) (S) -->
					<table width="100%" id="mainTable">
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet1');</script>
                        </td></tr>
		            </table>
				<!-- : ( From Location ) (E) -->


		<!-- TABLE '#D' : ( Search Options : Detail Explanation) (E) -->



</td></tr>
</table>
<!-- Outer Table (E)-->


</form>
</body>
</html>