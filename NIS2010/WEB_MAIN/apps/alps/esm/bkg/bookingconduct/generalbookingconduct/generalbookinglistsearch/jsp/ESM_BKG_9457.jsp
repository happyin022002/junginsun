<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_9457.jsp
*@FileTitle : Booking Receipt Draft BL EDI
*Open Issues :
*Change history :
*@LastModifyDate : 2013.04.05
*@LastModifier : 
*@LastVersion : 1.0

* 1.0 Creation
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger" %>

<%

	
    String bkg_no = JSPUtil.getNull(request.getParameter("bkg_no"));
  
	
%>
<html>
<head>
<title>Multi B/L No</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">

    function setupPage(){
        var formObject = document.form;
       	var multi_value = formObject.bkg_no.value.replaceStr(",","\n");
            formObject.multi_value.value = multi_value;
    }

</script>
</head>
<body onLoad="setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd">
<input type="hidden" name="bkg_no" value='<%=bkg_no%>'>


<!-- OUTER - POPUP (S)tart -->
<table width="400" class="popup" cellpadding="10">
<tr><td class="top"></td></tr>
<tr><td valign="top">

		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
		<table width="100%" border="0">
		<tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp;Search Key Input</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (S) -->
		<table class="search">
			<tr>
				<td class="bg">
					<table class="search" border="0" >
						<tr class="h23">
							<td width="25%">Multi Value </td>
						</tr>

					</table>

				</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->


		<table class="height_10"><tr><td></td></tr></table>

		<!-- TABLE '#D' : ( Tab ) (E) -->

		<div id="tabLayer" style="display:inline">
		<!-- TABLE '#D' : ( Tab BG Box ) (S) -->
     	<table class="search" border="0">
			<tr>
				<td class="bg">
					<table class="height_10"><tr><td></td></tr></table>

                    <table width="100%" id="mainTable">
                        <tr>
                        	<td>
                             	<textarea name="multi_value" style="width:350; height:200; text-transform:uppercase;"  value=""></textarea>
                             	<br>
                             	Please insert 'enter' after each value
                        	</td>
                        </tr>
                    </table>
				<!-- : ( Speed ) (E) -->

			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Tab BG Box ) (E) -->
        </div>
		<!-- ####### TABLE '#D' ::: 'RIGHT' FRAME (END) ####### -->


	</td></tr>
</table>
<!-- TABLE '#B' : 'Left + Right Body' Table (E)nd -->
<!-- ################# TABLE '#B' ::: 'LEFT + RIGHT' FRAME (END) ################## -->

</td></tr>

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

</form>
</body>

</html>

