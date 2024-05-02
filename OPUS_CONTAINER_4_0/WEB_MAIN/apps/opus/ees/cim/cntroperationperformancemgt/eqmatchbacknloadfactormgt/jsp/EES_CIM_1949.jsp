<%--
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CIM_1949.jsp
*@FileTitle : Load Factor by Trade-RD
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion :
=========================================================*/ 
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.event.EES_CIM_1049HTMLAction"%>
<%@ page import="com.clt.apps.opus.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.event.EesCim1049Event"%>

<html>
<head>
<title>Load Factor by Trade</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="/opuscntr/rpt/script/common_rd.js"></script>
<script language="javascript">
	function setupPage(){
		loadPage();		
	}
</script>
</head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input	type="hidden" name="f_cmd"> 
<input type="hidden" name="iPage"> 

<!-- OUTER - POPUP (S)tart -->
<table width="755" class="popup" cellpadding="10" border="0">
	<tr><td class="top"></td></tr>
	<tr><td valign="top">

	<!-- : ( Title ) (S) -->
	<table width="580" border="0">
	<tr><td class="title"><img src="/opuscntr/img/opus/ico_t1.gif" width="20" height="12">Load Factor by Trade</td></tr>
	</table>
	<!-- : ( Title ) (E) -->

	<!-- TABLE '#D' : ( Search Options : Speed ) (S) -->
    	<table class="search">
      	<tr><td class="bg_b1">

			<table class="height_10"><tr><td></td></tr></table>

			<!-- : ( Seq. ) (S) -->
			<table border="1" style="width:737;" height="545" class="grid" >
			<tr><td><script language='javascript'>rdViewerObject();</script></td></tr>
			<!-- : ( Seq. ) (E) -->

			<!-- : ( Button : Sub ) (S) -->
			<table width="100%" class="sbutton">
	       	<tr><td class="align">

			    <table class="sbutton">
			    <tr><td class="bt"><img class="cursor" src="/opuscntr/img/opus/button/btng_print.gif" width="65" height="19" border="0" name="btng_print"></td>
				</table>

			</td></tr>
			</table>
	    	<!-- : ( Button : Sub ) (E) -->
		</td></tr>
	</table>
	<!-- TABLE '#D' : ( Search Options : Speed ) (E) -->
</td></tr>
</table>
<!-- OUTER - POPUP (E)nd -->
<table class="height_10"><tr><td></td></tr></table>

<!-- : ( Button : Sub ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

		<table class="sbutton">
		<tr><td class="p_bt"><img class="cursor" src="/opuscntr/img/opus/button/btn_close.gif" width="66" height="20" border="0" name="btn_close"></td></tr>
		</table>

	</td></tr>
</table>
<!-- : ( Button : Sub ) (E) -->

</form>
</body>
</html>

