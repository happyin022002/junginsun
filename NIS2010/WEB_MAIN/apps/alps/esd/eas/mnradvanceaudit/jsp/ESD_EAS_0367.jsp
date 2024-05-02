<%--
/*=========================================================
*Copyright(c) 2009 CyberLogitec 
*@FileName : ESD_EAS_0367.jsp
*@FileTitle : Multiple Repair CNTR by Period
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
<%@ page import="com.hanjin.apps.alps.esd.eas.mnradvanceaudit.event.EsdEas0367Event"%>
<html>
<head>
<title>Multiple Repair CNTR by Period</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	<%=JSPUtil.getIBCodeCombo("s_eq_tpsz_cd", "01", "CD01860", 0, "")%>
	<%=JSPUtil.getIBCodeCombo("s_rcc_cd", "01", "CD00255", 0, "")%>
	<%=JSPUtil.getIBCodeCombo("s_ownership", "01", "CD01047", 0, "")%>
	<%=JSPUtil.getIBCodeCombo("s_cargo_type", "01", "CD02202", 0, "")%>

	function setupPage(){
		loadPage();
	}
</script>
</head>
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd">
<input type="hidden" name="page_no" value="1">
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
								<td width="95">Country Code</td>
								<td width="120" style="padding-left:2"><input type="text" name="s_cnt_cd" dataformat="engup" maxlength="2" style="width:40px;text-align:center;ime-mode:disabled;" class="input1" value="">
								</td>
								<td width="95">Location/Yard</td>
								<td width="120" style="padding-left:2">
									<input type="text" style="width:50;" class="input" value="" name="s_loc_cd" dataformat="uppernum" maxlength="5">
									<input type="text" style="width:30;" class="input" value="" name="s_yd_cd" dataformat="uppernum" maxlength="2">
									<img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_loc_cd">
								</td>
								<td width="75">Period</td>
								<td colspan="3">
									<input type="text" style="width:80; text-align:Center" name="s_start_dt" value="" dataformat="ymd" maxlength="10" class="input1">
									<img name="btn_start_dt" src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
									&nbsp;~&nbsp;
									<input type="text" style="width:80; text-align:Center" name="s_end_dt" value="" dataformat="ymd" maxlength="10" class="input1">
									<img name="btn_end_dt" src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
								</td>
							</tr>								
							<tr class="h23">
								<td>Cleaning Type</td>
								<td style="padding-left:4"><script language="javascript">ComComboObject('s_cost_dtl_cd',2,110,0,0);</script></td>
								<td>CNTR No.</td>
								<td style="padding-left:2"><input id="s_eq_no" name="s_eq_no" type="text" style="width:150px" class="input1" dataformat="uppernum" value="" >&nbsp;<img src="img/btns_multisearch.gif" name="eq_no_multi1"width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
								<td width="70">Type / Size</td>
								<td width="120" style="padding-left:2"><script language="javascript">ComComboObject('s_eq_tpsz_cd',1,60,0,0);</script></td>
								<td width="80">Cargo Type</td>
								<td style="padding-left:2"><script language="javascript">ComComboObject('s_cargo_type',1,120,0,0);</script></td>
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