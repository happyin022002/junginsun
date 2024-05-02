<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TES_9160.jsp
*@FileTitle : Agreement Terminal Rate List Excel Load
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.22
*@LastModifier : yOng hO lEE
*@LastVersion : 1.0
* 2009.09.22 yOng hO lEE
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
<%@ page import="com.hanjin.apps.alps.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.event.EsdTes9160Event"%>
<html>
<head>
<title>Excel Upload</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	<%= JSPUtil.getIBCodeCombo("vol_ut_cd", "01", "CD00177", 0, "")%>
	<%= JSPUtil.getIBCodeCombo("io_bnd_code", "01", "CD00890", 0, "1::")%>
	<%= JSPUtil.getIBCodeCombo("ioc_code", "01", "CD00887", 0, "1::")%>
	<%= JSPUtil.getIBCodeCombo("thc_tp_code", "01", "CD00161", 0, "1::")%>
	<%= JSPUtil.getIBCodeCombo("tml_ovt_shft_code", "01", "CD00170", 0, "1::")%>

    function setupPage(){
        loadPage();
    }
</script>

</head>


<body onLoad="setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd">
<input type="hidden" name="iPage">


<!-- OUTER - POPUP (S)tart -->
<table width="700" class="popup" cellpadding="10">
<tr><td class="top"></td></tr>
<tr><td valign="top">

		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp;Terminal Rate Excel Upload</td></tr>
		</table>
		<!-- : ( Title ) (E) -->



		<!-- TABLE '#D' : ( Button : Main ) (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
				<tr><td class="btn1_bg">

						<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<!-- Repeat Pattern -->
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_loadexcel" id="btn_loadexcel">Load Excel</td><td class="btn1_right"></td></tr></table></td>
							<!-- Repeat Pattern -->

						</tr></table>

				</td></tr>
				</table>
		<!-- TABLE '#D' : ( Button : Main ) (E) -->



		<table class="search">
		<tr><td class="bg">
				<!-- : ( Gird ) (S) -->
                    <table width="100%" id="mainTable">
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet');</script>
                        </td></tr>
                    </table>
				<!-- : ( Grid ) (E) -->
				</td>
		</tr>
		</table>




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
						<tr><td class="btn1_left"></td><td class="btn1" name="btn_verify" id="btn_verify">Verify</td><td class="btn1_right"></td></tr></table></td>
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

<DIV style="display:none">
	<table class="search">
	<tr><td class="bg">
		<!-- : ( Gird ) (S) -->
		<table width="100%" id="mainTable">
		    <tr><td>
		         <script language="javascript">ComSheetObject('sheet1');</script>
		    </td></tr>
		</table>
		<!-- : ( Grid ) (E) -->
		</td>
	</tr>
	</table>
</DIV>