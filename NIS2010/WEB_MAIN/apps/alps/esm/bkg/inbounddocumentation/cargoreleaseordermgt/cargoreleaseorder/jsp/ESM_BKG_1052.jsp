<%	
	/*=========================================================
	 *Copyright(c) 2009 CyberLogitec
	 *@FileName : esm_bkg_1018.jsp
	 *@FileTitle : CndManifestListDownload
	 *Open Issues :
	 *Change history :
	 *@LastModifyDate : 2009.07.02
	 *@LastModifier : 손윤석
	 *@LastVersion : 1.0
	 * 2009.07.02 손윤석
	 * 1.0 Creation
	 =========================================================*/
%>

<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%
	String do_no_t = JSPUtil.getNull(request.getParameter("do_no"));
%>


<html>
<head>
<title>Full CNTR Release Order Remark Pop-up</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">



<script language="javascript">
    function setupPage()
    {  
	    loadPage();
    }
</script>

</head>
<body class="popup_bg" onLoad="setupPage();"> 

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="p_row" value="<%=JSPUtil.getNull(request.getParameter("p_row"))%>">
<input type="hidden" name="old_rmk" value="">

<input type="hidden" name="diff_rmk" value="">
<input type="hidden" name="cntr_no" value="">
<input type="hidden" name="bkg_no" value="">

 <table width="100%" class="popup" cellpadding="10" border="0"> 
			<tr><td class="top"></td></tr>
			<tr>
				<td valign="top">
					<table width="100%" border="0">
					<tr><td height="79" class="title"><img src="img/icon_title_dot.gif" align="absmiddle">Full CNTR Release Order Remark Pop-up</td></tr>
					</table>
		
		<table>
			<tr height="5"><td>
			</td></tr>
		</table>
		
		<table class="search">
			<tr><td class="bg">
				<table border="0" style="width:100%; background-color:white;" class="grid2"> 
					<tr><td width="" class="tr2_head">Remark(s)</td></tr>
					<tr><td>
						<textarea style="width:100%;overflow-y:hidden;text-indent:0px"  rows="5" name="p_remark"><%=JSPUtil.getNull(request.getParameter("p_diff_rmk"))%></textarea>
					</td></tr>
				</table>
			</td></tr>
		</table>
		

<table width="100%"  id="mainTable"> 
	<tr><td width="100%">
		<script language="javascript">ComSheetObject('sheet1');</script>
	</td></tr>
</table> 	
<table class="height_5"><tr><td></td></tr></table>
</td></tr>
</table> 
	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
		    	<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Save">Setup</td>
					<td class="btn1_right"></td>
				</tr></table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Close">Close</td>
					<td class="btn1_right"></td>
				</tr></table></td>
			</tr>
		</table>
    <!--Button (E) -->
	
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->
</td>
</tr>
</table>
</form>
</body>
</html>
