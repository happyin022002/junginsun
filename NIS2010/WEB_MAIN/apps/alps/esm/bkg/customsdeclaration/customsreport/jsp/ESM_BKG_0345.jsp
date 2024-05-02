<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%
	String cntCd = request.getParameter("cnt_cd");
	String locCd = request.getParameter("loc_cd");
	String cstmsCd = request.getParameter("cstms_cd")==null ? "":request.getParameter("cstms_cd");
	SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	if (cntCd==null) cntCd = account.getCnt_cd();
	if (locCd==null) locCd = "";
%>
<html>
<head>
<title>Welcome to Alps!</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">

    function setupPage(){  

	    loadPage();
    }

</script>
</head>
<body  onLoad="setupPage();"> 

<form name="form">
<input type="hidden" name="f_cmd">

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
	<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
	<!--Page Title, Historical (E)-->

	<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">

				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="170">Country Code</td>
					<td width="140"><input type="text" style="width:40; text-align:center;" class="input1" value="<%=cntCd%>" name="cnt_cd" maxlength="2" style="ime-mode:disabled" dataformat="engup"></td>
					<td width="70">Location</td>
					<td width="140"><input type="text" style="width:84;" class="input" value="<%=locCd%>" name="loc_cd" maxlength="5" style="ime-mode:disabled" dataformat="engupnum" ></td>
					<td width="146">Warehouse Abbr, Code</td>
					<td width=""><input type="text" style="width:80;" class="input" name="wh_cd" maxlength="5" style="ime-mode:disabled" dataformat="engupnum"></td>
				</tr>
				<tr class="h23">
					<td width="">Warehouse Customs Code</td>
					<td width="" colspan="3"><input type="text" style="width:80;" class="input" name="cstms_cd" maxlength="10" style="ime-mode:disabled" dataformat="engupnum" value="<%=cstmsCd%>"></td>
					<td width="">Warehouse Name</td>
					<td width=""><input type="text" style="width:174;" class="input" name="wh_nm" dataformat="engupspace"></td>
				</tr>
				</table>
				<!--  biz_1   (E) -->
				</td></tr>
			</table>
			<table class="height_8"><tr><td></td></tr></table>
		
		<!-- Grid BG Box  (S) -->
     	<table class="search" id="mainTable">
       	<tr><td class="bg">
			
				<!-- Grid  (S) -->
					<table width="100%"  id="mainTable">
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet1');</script>
							</td>
						</tr>
					</table>
			<!-- Grid (E) -->
			<!--  Button_Sub (S) -->
			
	    	<!-- Button_Sub (E) -->	
				
			</td></tr>
		</table>
	<!-- Grid BG Box  (S) -->
	<!--biz page (E)-->
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" id="btn_retrieve" name="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Select">Select</td>
					<td class="btn1_right"></td>
				<td><table width="" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_downexcel">Down Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
					</tr>
				</table></td>
			</tr>
			</table>
		</td></tr>
		</table>
    <!--Button (E) -->
	</td></tr>
		</table>
</form>
</body>
</html>