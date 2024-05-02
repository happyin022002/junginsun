<%--=========================================================================
=========================================================================
' History
' 2010.01.12 윤진영 최초작성
' 2010.06.14 CHM-200901719 윤진영 UI표준처리 오픈시 년도에 포커싱
' 2010.12.01 김기종 Ticket ID:CHM-201006305-01 COA Architecture 위배사항 수정
=========================================================================--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%
    Exception serverException   = null; 
    String strErrMsg    = "";           
    Logger log = Logger.getLogger("com.hanjin.apps.alps.esm.coa.lanesimulation.ESM_COA_0164");
    
	String f_cost_yrmon = JSPUtil.getNullNoTrim(request.getParameter("f_cost_yrmon"));
    try {
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        } // end else
    }catch(Exception e) {
        log.error("ESM_COA_0164 Exception : "+e.toString());
        out.println(e.toString());
    }

%>
<html>
<head>
<title>Non Operating Expense</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
<!--
    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            ComShowMessage(errMessage);
        } // end if
        loadPage();
        document.form.f_cost_yrmon.focus();
    }

-->
</script>
</head>


<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;" onKeyDown="ComKeyEnter();">
<input type="hidden" name="f_cmd">
<input type="hidden" name="iPage">

<!-- OUTER - POPUP (S)tart -->

<table width="400" class="popup" cellpadding="10" border="0">
	<tr><td class="top"></td></tr>
	<tr>
		<td valign="top">


		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp; Non Operating Expense</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		<!--Button_L (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
	       	<tr><td class="btn1_bg">

				<table border="0" cellpadding="0" cellspacing="0">
				<tr>
					<!-- Repeat Pattern -->
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" id="btn_retrieve" name="btn_retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" id="btn_rowadd" name="btn_rowadd">RowAdd</td><td class="btn1_right"></td></tr></table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" id="btn_save" name="btn_save">Save</td><td class="btn1_right"></td></tr></table></td>
					<!-- Repeat Pattern -->

				</tr></table>

			</td></tr>
		</table>
		<!--Button_L (E) -->		
        <!-- TABLE '#D' : ( Search Options ) (S) -->
			<table class="search" width="100%" >
				<tr>
				    <td class="bg">
						<!-- : ( Viewer ) (S) -->
						<table class="search" border="0">
							<tr class="h23">
                               <td width="45%">YYYY-MM &nbsp;<input type="text" name="f_cost_yrmon" class="input1" style="width:70" value="" maxlength="7"  onKeyPress="ComKeyOnlyNumber(window)" onFocus="this.value=ComReplaceStr(this.value, '-', '');" onBlur="addDash(this , 4);"></td>
                               <td width="45%">[Unit : USD 1]&nbsp;&nbsp;[CUR : USD]</td>
                            </tr>
                        </table>
                        <!-- : ( Viewer ) (E) -->
                        <table class="line_bluedot"><tr><td></td></tr></table>
						<!-- : ( Grid ) (S) -->
						<table width="100%" id="mainTable">
							<tr>
								<td>
									<script language="javascript">ComSheetObject('sheet1');</script>
								</td>
							</tr>
						</table>
 						<!-- : ( Grid ) (E) -->
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
<!-- OUTER - POPUP (E)nd -->


<table class="height_5"><tr><td></td></tr></table>


<!-- : ( Button : pop ) (S) -->
<table width="400" class="sbutton">
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

