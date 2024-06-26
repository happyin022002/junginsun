﻿<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_0209.jsp
*@FileTitle :  Expense Summary by Office (Detail Inquiry)
*Open Issues :
*Change history :
*@LastModifyDate : 2009-01-16
*@LastModifier : ayhan
*@LastVersion : 1.0
* 2009-01-16 ayhan
* 1.0 최초 생성
* N200901080024  2009-02-27 'Report(Expense Summary by Office) 메뉴 개발 요청 '
* 2009-09-04 김진 : ALPS Naming change
* 2011.07.20 민정호 [CHM-201112196] Expense Summary Report에 Invoice 상태코드를 조회조건에 추가
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>

<%
    String period = JSPUtil.getParameter(request, "sel_period".trim(), "");
    String from_date = JSPUtil.getParameter(request, "hid_from_date".trim(), "");
    String to_date = JSPUtil.getParameter(request, "hid_to_date".trim(), "");
    String radio_office = JSPUtil.getParameter(request, "radio_office".trim(), "");
    String wo_ofc_cd = JSPUtil.getParameter(request, "row_wo_ofc_cd".trim(), "");
    String sp_tp = JSPUtil.getParameter(request, "sp_tp".trim(), "");
    String inv_ofc_cd = JSPUtil.getParameter(request, "row_inv_ofc_cd".trim(), "");
    String costmode = JSPUtil.getParameter(request, "row_costmode".trim(), "");
    String transmode = JSPUtil.getParameter(request, "row_transmode".trim(), "");
    String sotype = JSPUtil.getParameter(request, "row_sotype".trim(), "");
    String sotype_nm = JSPUtil.getParameter(request, "row_sotype_nm".trim(), "");
    String node_div     = JSPUtil.getParameter(request, "node_div".trim(), "");
    String fm_loc       = JSPUtil.getParameter(request, "row_fm_loc".trim(), "");
    String via_loc      = JSPUtil.getParameter(request, "row_via_loc".trim(), "");
    String to_loc       = JSPUtil.getParameter(request, "row_to_loc".trim(), "");
    String door_loc     = JSPUtil.getParameter(request, "row_door_loc".trim(), "");
    String bkg_term = JSPUtil.getParameter(request, "row_bkg_term_cd".trim(), "");
    String bkg_term_nm = JSPUtil.getParameter(request, "row_bkg_term_nm".trim(), "");
    String search_fm_loc = JSPUtil.getParameter(request, "search_fm_loc".trim(), "")+JSPUtil.getParameter(request, "search_fm_yard".trim(), "");
    String search_via_loc = JSPUtil.getParameter(request, "search_via_loc".trim(), "")+JSPUtil.getParameter(request, "search_via_yard".trim(), "");
    String search_to_loc = JSPUtil.getParameter(request, "search_to_loc".trim(), "")+JSPUtil.getParameter(request, "search_to_yard".trim(), "");
    String search_door_loc = JSPUtil.getParameter(request, "search_door_loc".trim(), "")+JSPUtil.getParameter(request, "search_door_yard".trim(), "");
    String status_cd     = JSPUtil.getParameter(request, "row_status_cd".trim(), "");
    String io_bnd       = JSPUtil.getParameter(request, "hid_io_bnd".trim(), "");
    String inv_curr = JSPUtil.getParameter(request, "row_inv_curr".trim(), "");
%>

<html>
<head>
<title>Expense Summary by Office (Detail Inquiry)</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="/hanjin/rpt/script/rdviewer50.js"></script>
<script language="javascript">
	function setupPage(){
		loadPage();
	}
</script>
</head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input	type="hidden" name="period" value="<%=period%>">
<input	type="hidden" name="from_date" value="<%=from_date%>">
<input	type="hidden" name="to_date" value="<%=to_date%>">
<input	type="hidden" name="radio_office" value="<%=radio_office%>">
<input	type="hidden" name="wo_ofc_cd" value="<%=wo_ofc_cd%>">
<input	type="hidden" name="inv_ofc_cd" value="<%=inv_ofc_cd%>">
<input	type="hidden" name="sp_tp" value="<%=sp_tp%>">
<input	type="hidden" name="costmode" value="<%=costmode%>">
<input	type="hidden" name="transmode" value="<%=transmode%>">
<input	type="hidden" name="sotype" value="<%=sotype%>">
<input	type="hidden" name="sotype_nm" value="<%=sotype_nm%>">
<input	type="hidden" name="bkg_term" value="<%=bkg_term%>">
<input	type="hidden" name="bkg_term_nm" value="<%=bkg_term_nm%>">
<input	type="hidden" name="node_div" value="<%=node_div%>">
<input	type="hidden" name="fm_loc" value="<%=fm_loc%>">
<input	type="hidden" name="via_loc" value="<%=via_loc%>">
<input	type="hidden" name="to_loc" value="<%=to_loc%>">
<input	type="hidden" name="door_loc" value="<%=door_loc%>">
<input	type="hidden" name="search_fm_loc" value="<%=search_fm_loc%>">
<input	type="hidden" name="search_via_loc" value="<%=search_via_loc%>">
<input	type="hidden" name="search_to_loc" value="<%=search_to_loc%>">
<input	type="hidden" name="search_door_loc" value="<%=search_door_loc%>">
<input	type="hidden" name="status_cd" value="<%=status_cd%>">
<input	type="hidden" name="io_bnd" value="<%=io_bnd%>">
<input	type="hidden" name="inv_curr" value="<%=inv_curr%>">


<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0">
  <tr>
  	<td class="top" width="100%"></td>
  </tr>
  <tr>
  	<td valign="top">

		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp; Expense Summary by Office (Detail Inquiry)</td></tr>
		</table>
		<!-- : ( Title ) (E) -->



		<!-- TABLE '#D' : ( Search Options : Speed ) (S) -->
     	<table class="search">
       	<tr>
       		<td class="bg">
				    <table class="height_10">
				    	<tr>
				    		<td></td>
				    	</tr>
				    </table>

				    <!-- : ( Seq. ) (S) -->
				    <table border="1" style="width:100%;" height="408" class="grid" >
				      <tr>
				      	<td>
				      		<script language='javascript'>comRdObject('csrPrevie');</script>
				      	</td>
				      </tr>
				    </table>
				    <!-- : ( Seq. ) (E) -->

				    <!-- : ( Button : Sub ) (S) -->
					<table width="100%" class="button">
				       	<tr><td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
						<tr>

							<!-- Repeat Pattern -->
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_print" name="btng_print">Print</td><td class="btn2_right"></td></tr></table></td>
							<!-- Repeat Pattern -->

						</tr></table>
					</td></tr>
					</table>
		    	  <!-- : ( Button : Sub ) (E) -->


			    </td>
			  </tr>
		  </table>
		  <!-- TABLE '#D' : ( Search Options : Speed ) (E) -->
    </td>
  </tr>
</table>
<!-- OUTER - POPUP (E)nd -->


<table class="height_5"><tr><td></td></tr></table>


<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
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

