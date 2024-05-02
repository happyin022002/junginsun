<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.apps.alps.esd.sce.common.util.basic.CodeUtilBCImpl" %>
<%@ page import="com.hanjin.apps.alps.esd.sce.common.util.basic.CodeUtilBC" %>
<%--=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_SCE_0022.jsp
*@FileTitle : tivity Attribute Management
*Open Issues :
*Change history :
*	- 2006-11-13 : 요건변경으로 인한 재개발
*@LastModifyDate : 2006-11-14
*@LastModifier : Seong-mun Kang
*@LastVersion : 1.0
* 2006-08-29 Se-Hoon PARK
* 1.0 최초생성
* 2009-10-06  : hyun-kyoung oh NIS2010 construction
=========================================================--%>
<%
	CodeUtilBC codeUtil = new CodeUtilBCImpl() ;
%>


<html>
<head>
<title>Welcome to NMS!</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>

<script language="javascript">
	<%=codeUtil.searchCodeComboSheet("skdLgc", "sce_cop_skd_lgc", "cop_skd_lgc_no a", "cop_skd_lgc_no b",
							   null, "a")%> ;

    function setupPage(){
	    loadPage();
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH) ;
       /*****************************************************************/
    }

</script>

<body onLoad="setupPage()">
<form name="form">
<input type="hidden" name="f_cmd">
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
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_save" id="btn_save">Save</td><td class="btn1_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_downexcel" id="btn_downexcel">Down Excel</td><td class="btn1_right"></td></tr></table></td>
							<!-- Repeat Pattern -->

						</tr></table>

				</td></tr>
		</table>
		<!-- TABLE '#D' : ( Button : Main ) (E) -->









		<!-- TABLE '#D' : ( Search Options ) (S)
		<table class="search">
			<tr>
				<td class="bg">
					<table class="search_in" border="0">
						<tr class="h23">
							<td width="11%">Activity Group</td>
							<td width="24%"><select style="width:150;">&nbsp;
							<option value="0" selected></option>
							<option value="1">OTR</option>
							<option value="1">ITR</option>
							<option value="1">OTT</option>
							</select></td>
							<td width="2%"><input type="radio" name="radio" value="" class="trans"></td>
							<td>&nbsp;All</td>
						</tr>
					</table>

				</td></tr>
		</table>-->
		<!-- TABLE '#D' : ( Search Options ) (E) -->


		<!-- TABLE '#D' : ( Search Options : Speed ) (S) -->
     	<table class="search">
       	<tr><td class="bg">

				<!-- : ( Speed ) (S) -->
				<table width="100%" id="mainTable">
					<tr><td>
					   <script language="javascript">ComSheetObject('sheet1');</script>
					</td></tr>
				</table>
				<!-- : ( Speed ) (E) -->
			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options : Speed ) (E) -->
    </td></tr>
</table>
<!-- Outer Table (E)-->
</form>
</body>
</html>

