<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_LSE_0066.jsp
*@FileTitle : EQ Payable Charge Summary
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.25
*@LastModifier : 진준성
*@LastVersion : 1.0
* 2009.08.25 진준성
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
<%@ page import="com.hanjin.apps.alps.ees.lse.containerrentalcost.payablerentalcost.event.EesLse0066Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
%>
<html>
<head>
<title>Total Inventory</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="/hanjin/rpt/script/rdviewer50.js"></script>
<script language="javascript">
	function setupPage(){
		loadPage();		
	}
</script>
</head>

<body class="popup_bg" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input	type="hidden" name="f_cmd"> 
<input type="hidden" name="iPage"> 

<!-- OUTER - POPUP (S)tart -->

<table width="100%" class="popup" cellpadding="10" border="0"> 
	<tr><td class="top"></td></tr>
	<tr>
		<td valign="top">

			<!-- : ( Title ) (S) -->
			<table width="100%" border="0">
				<tr>
					<td class="title">
						<img src="img/icon_title_dot.gif" align="absmiddle">&nbsp; EQ Payable Charge Summary 
					</td>
				</tr>
			</table>
			<!-- : ( Title ) (E) -->


	<!-- TABLE '#D' : ( Search Options : Speed ) (S) -->
    	<table class="search">
				<tr>
					<td class="bg">
			<!-- : ( Seq. ) (S) -->
			<table border="1" style="width:737;" height="545" class="grid" >
			<tr><td><script language='javascript'>comRdObject('csrPrevie');</script></td></tr>
			<!-- : ( Seq. ) (E) -->
	<!--  Button_Sub (S) -->
						<table width="100%" class="button"> 
			       			<tr>
			       				<td class="btn2_bg">
									<table border="0" cellpadding="0" cellspacing="0">
										<tr>

					    					
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" name="btng_print">print</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
						<!-- Button_Sub (E) -->
		
		</td></tr>
	</table>
	<!-- TABLE '#D' : ( Search Options : Speed ) (E) -->
	<table class="height_10"><tr><td></td></tr></table>
</td></tr>
</table>
<!-- OUTER - POPUP (E)nd -->
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
	<tr>
		<td height="71" class="popup">
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       			<tr>
       				<td class="btn3_bg">
		    			<table border="0" cellpadding="0" cellspacing="0">
		    				<tr>

								<td width="">
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_close">Close</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
<!-- : ( Button : pop ) (E) -->



</form>
</body>
</html>