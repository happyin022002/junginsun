<%--
/*=========================================================
*Copyright(c) 2009 CyberLogitec 
*@FileName : ESD_EAS_0366.jsp
*@FileTitle : Cleaning Container Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2015-04-14
*@LastModifier : Jeong-Min Park
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
<%@ page import="com.hanjin.apps.alps.esd.eas.mnradvanceaudit.event.EsdEas0365Event"%>
<%
	String inv_no = StringUtil.xssFilter(request.getParameter("s_inv_no"));
	String vndr_seq = StringUtil.xssFilter(request.getParameter("s_vndr_seq"));
	String eq_knd_cd = StringUtil.xssFilter(request.getParameter("s_eq_knd_cd"));
%>
<html>
<head>
<title>Multiple Repair CNTR by Period</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	<%=JSPUtil.getIBCodeCombo("s_eq_tpsz_cd", "01", "CD01860", 0, "")%>

	function setupPage(){
		loadPage();
	}
</script>
</head>
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd">
<input type="hidden" name="s_eq_no" value="">
<input type="hidden" name="s_param_loc_cd" value="">
<input type="hidden" name="backendjob_key" />
<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>
			<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
				<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
				<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
				<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
				</table>
			<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->

			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
				<tr><td class="btn1_bg">
						<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<!-- Repeat Pattern -->
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_new" id="btn_save">New</td><td class="btn1_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_downexcel" id="btn_downexcel">Down Excel</td><td class="btn1_right"></td></tr></table></td>
							<!-- Repeat Pattern -->
						</tr></table>
				</td></tr>
			</table>

			<!-- TABLE '#D' : ( Search Options ) (S) -->
	     	<table width="100%" class="search" border="0">
		       	<tr>
		       		<td class="bg">
						<!-- : ( Week ) (S) -->
							<!-- [1]--------------------------------------------------------- -->
						<table class="search_in" border="0">
							<tr class="h23">
								<td width="90">Country Code</td>
								<td width="60" style="padding-left:2"><input type="text" name="s_cnt_cd" dataformat="engup" maxlength="2" style="width:40px;text-align:center;ime-mode:disabled;" class="input" value="">
								</td>
								<td width="95">Location/Yard</td>
								<td width="130" style="padding-left:2">
									<input type="text" style="width:50;" class="input" value="" name="s_loc_cd" dataformat="uppernum" maxlength="5">
									<input type="text" style="width:30;" class="input" value="" name="s_yd_cd" dataformat="uppernum" maxlength="2">
									<img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_loc_cd">
								</td>
								<td width="70">S/P Code</td>
								<td width="210" style="padding-left:2">
									<input type="text" name="s_vndr_seq" dataformat="num" maxlength="6" style="width:70px;text-align:center;ime-mode:disabled;" class="input" value="">&nbsp;<img class="cursor" src="img/btns_search.gif" name="btn_sp_cd" width="19" height="20" alt="" border="0" align="absmiddle">
									<input type="text" name="s_vndr_nm" style="width:100px;text-align:left;" class="input2" value="" readonly>
								</td>
								<td width="70">Period</td>
								<td>
									<input type="text" style="width:80; text-align:Center" name="s_start_dt" value="" dataformat="ymd" maxlength="10" class="input1">
									<img name="btn_start_dt" src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
									&nbsp;~&nbsp;
									<input type="text" style="width:80; text-align:Center" name="s_end_dt" value="" dataformat="ymd" maxlength="10" class="input1">
									<img name="btn_end_dt" src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
								</td>
							</tr>								
							<tr class="h23">
								<td>Type / Size</td>
								<td style="padding-left:4"><script language="javascript">ComComboObject('s_eq_tpsz_cd',1,60,0,0);</script></td>
								<td>Cleaning Type</td>
								<td style="padding-left:4"><script language="javascript">ComComboObject('s_cost_dtl_cd',2,120,0,0);</script></td>
								<td>No of Repairs</td>
								<td style="padding-left:2"><input type="text" name="s_rpr_cnt" dataformat="int" maxlength="2" style="width:50px;text-align:center;ime-mode:disabled;" class="input" value="2"> Over 
								</td>
								<td>Amount<br/>(USD)</td>
								<td><input type="text" name="s_rpr_amt" dataformat="int" maxlength="8" style="width:50px;text-align:center;ime-mode:disabled;" class="input" value=""> Over</td>
							</tr>
						</table>
						<!-- : ( Week ) (E) -->
					</td>
				</tr>
			</table>
			<!-- TABLE '#D' : ( Search Options ) (E) -->

			<table class="height_10"><tr><td></td></tr></table>
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
				</td></tr>
			</table>
			<table class="height_10"><tr><td></td></tr></table>
	     	<table class="search">
	       		<tr><td class="bg">
					<!-- <table class="height_10"><tr><td></td></tr></table> -->
					<!-- : ( POR ) (S) -->
					<table width="100%" id="mainTable">
			              <tr><td>
			                     <script language="javascript">ComSheetObject('sheet2');</script>
			              </td></tr>
					</table>
					<!-- : ( POR ) (E) -->
				</td></tr>
			</table>
			<!-- TABLE '#D' : ( Grid ) (E) -->

    </td></tr>
</table>
<table width="100%" style="display:none"> 
	<tr>
		<td width="100%">
			<script language="javascript">ComSheetObject('sheet3');</script>
		</td>
	</tr>
</table> 
<!-- Outer Table (E)-->

</form>
</body>
</html>