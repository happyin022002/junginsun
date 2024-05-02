<%--
/*=========================================================
*Copyright(c) 2009 CyberLogitec 
*@FileName : EES_DOD_0010.jsp
*@FileTitle : DOD Collection Summary by Office Detail
*Open Issues :
*Change history :
*@LastModifyDate : 2016-06-14
*@LastModifier : Lee Young du
*@LastVersion : 1.0
* 1.0 최초 생성 
-------------------------------------------------------------------
* History

=========================================================*/
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.util.StringUtil"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.dod.dodreport.collectionsummary.event.EesDod0009Event"%>

<%
	String loginOfcCd = "";
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		loginOfcCd = account.getOfc_cd();
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>DOD Collection Summary by Office Detail</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">

	var loginOfcCd = "<%=loginOfcCd%>";
	function setupPage(){
		loadPage();
	}
</script>
</head>
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">

<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd">
<input type="hidden" name="item_list" value="">
<input type="hidden" name="ar_if" value="">
<input type="hidden" name="cust_cd" value="">
<input type="hidden" name="s_from" value="">
<input type="hidden" name="s_to" value="">
<input type="hidden" name="period" value="">
  
<!-- Outer Table (S)-->
<table width="100%" cellpadding="10" class="popup">
<tr><td>
			<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
				<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
				<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title">&nbsp; DOD Collection Summary Detail</span></td></tr>
				</table>
			<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->

			

			<!-- TABLE '#D' : ( Grid ) (S) -->
	     	<table class="search">
	       		<tr><td class="bg">
					<!-- <table class="height_10"><tr><td></td></tr></table> -->
					<!-- : ( POR ) (S) -->
					<table width="100%" id="mainTable">
			              <tr><td>
			                     <script language="javascript">ComSheetObject('sheet1');</script>
			              </td></tr>
					</table>
					<!-- : ( POR ) (E) -->
					


			<table class="height_10"><tr><td></td></tr></table>
					
					<!-- : ( Button : Grid ) (S) -->
					<table width="100%" class="button" >
						<tr><td class="btn3_bg">
							<table border="0" cellpadding="0" cellspacing="0">
								<tr>
								<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button" >
								<tr>
								
								<!-- Repeat Pattern -->
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_downexcel" id="btn_downexcel">Down Excel</td>
								<td class="btn1_right"></td>
								<!-- Repeat Pattern -->
								
									<td class="btn1_left"></td>
									<td class="btn1" name="btn_close" id="btn_close">Close</td>
									<td class="btn1_right"></td>
								</tr>
								</table></td>
								&nbsp;&nbsp;&nbsp;
								<!-- Repeat Pattern -->

								</tr>
							</table>
						</td></tr>
					</table>
			    	<!-- : ( Button : Grid ) (E) -->

				</td></tr>
			</table>
			<!-- TABLE '#D' : ( Grid ) (E) -->

    </td></tr>
</table>
<table width="100%" style="display:none"> 
	<tr>
		<td width="100%">
			<script language="javascript">ComSheetObject('sheet2');</script>
		</td>
	</tr>
</table> 
<!-- Outer Table (E)-->

</form>
</body>
</html>