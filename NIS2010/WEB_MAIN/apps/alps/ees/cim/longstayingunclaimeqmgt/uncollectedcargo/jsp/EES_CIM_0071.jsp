<%--
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CIM_0071.jsp
*@FileTitle : Help Exchange
*Open Issues :
*Change history :
*@LastModifyDate : 2014.07.04
*@LastModifier : DO-HYUN KIM
*@LastVersion : 1.0
* 1.0 최초 생성 
-------------------------------------------------------------------
* History

=========================================================*/
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.uncollectedcargo.event.EesCim0071Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	String str_acct_xch_rt_yrmon = DateTime.getFormatString("yyyy-MM");
	String exch_pop_gb = JSPUtil.getNull(request.getParameter("exch_pop_gb"));
	String is_read_only = JSPUtil.getNull(request.getParameter("is_read_only")).trim();
%>
<html>
<head>
<title>Help Exchange</title>
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
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->

<input type="hidden" name="iPage">
<input type="hidden" name="acct_xch_rt_yrmon" value="">
<input type="hidden" name="exch_pop_gb" value="<%=exch_pop_gb%>">
<input type="hidden" name="is_read_only" value="<%=is_read_only%>">
<input type="hidden" name="s_readonly" value="N">
<!-- OUTER - POPUP (S)tart -->
<table width="100" class="popup" cellpadding="10" border="0">
<tr><td class="top"></td></tr>
<tr><td valign="top">

		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp;Help Exchange</td></tr>
		</table>
		<!-- : ( Title ) (E) -->

        <div id="tabLayer" style="display:inline">
		<!-- TABLE '#D' : ( Tab BG Box ) (S) -->
     	<table class="search" border="0">
       	<tr><td class="bg">

		<!-- TABLE '#D' : ( Search Options ) (S) -->
       	<!-- TABLE '#D' : ( Search ) (S) -->
       	<table class="search" style="width:295;">
		<tr>
             <td class="bg">
                 <table class="search_in" border="0" style="width:295;">
                 		<table>
							<tr class="h23" border="0">
								<td width="100">Exchange Date</td>
								<td>
									<input name="s_acct_xch_rt_yrmon" type="text" style="width:55; text-align:center;" class="input" value="<%=str_acct_xch_rt_yrmon%>" maxlength="7" onFocus="acct_xch_rt_yrmon_change();"  onBlur="" onChange="acct_xch_rt_yrmon_change();">
									<img src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" name="btns_onecalendar">
								</td>					
							</tr>
						</table>
						<table>
							<tr class="h23">
								<td width="100">
									<script language="javascript">ComComboObject('frCurrCdCombo', 1, 80, 1)</script>
									<input type="hidden" name="s_fr_curr_cd" value="" onChange="fr_curr_cd_change(this);">
									<input type="hidden" name="s_fr_curr_nm" value="">
								</td>
				                <td width="100">
				                	<!--  <input name="s_fr_curr_amt" type="text" style="width:150;"  onKeyPress="form_keypress(this);" onChange="fr_curr_amt_change(this);">-->
				                	<input name="s_fr_curr_amt" type="text" style="width:150;" value="0.00" onKeyUp='isMon(this,"Y");' onKeyDown='isMon(this,"Y");' onChange="fr_curr_amt_change(this);" style="text-align:center">
				                </td>
				                <td width="10">&nbsp;<b>=</b>&nbsp;</td>
								<td width="100">
									<script language="javascript">ComComboObject('toCurrCdCombo', 1, 80, 1)</script>
					  				<input type="hidden" name="s_to_curr_cd" value="" onChange="to_curr_cd_change(this);">
									<input type="hidden" name="s_to_curr_rt" value="">
								</td>					
				                <td width="200">
				                	<input name="s_to_curr_amt" type="text" style="width:150;"  value="" onBlur="" class="input2" readonly style="text-align:center">
				                </td>
							</tr>
						</table>
                 </table>
             </td>
        </tr>
       	</table>
      	<!-- TABLE '#D' : ( Search ) (E) -->
		<!-- TABLE '#D' : ( Search Options ) (E) -->

			<!-- : ( Grid : Week ) (S) -->
            <table width="100%" height="100%" id="mainTable" border="0">
                <tr><td>
                     <script language="javascript">ComSheetObject('sheet1');</script>
                </td></tr>
            </table>
			<!-- : ( Grid : Week ) (E) -->

			<!-- : ( Button : Sub ) (S) -->
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
				<tr><td class="btn1_bg">

						<table border="0" cellpadding="0" cellspacing="0" align="center">
						<tr>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_cal" id="btn_cal">CAL</td><td class="btn1_right"></td></tr></table></td>
							<%if(is_read_only.equals("N")){%>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_ok" id="btn_ok">OK</td><td class="btn1_right"></td></tr></table></td>
							<%} %>
							<!-- Repeat Pattern -->

						</tr>
						</table>

				</td></tr>
			</table>
	    	<!-- : ( Button : Sub ) (E) -->

			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Tab BG Box ) (E) -->
        </div>

</td></tr>
</table>
<!-- OUTER - POPUP (E)nd -->

<table class="height_10"><tr><td></td></tr></table>

<table class="height_10"><tr><td colspan="8"></td></tr></table>
<script language="javascript">ComSheetObject('sheet_mutistatus');</script>

</form>
</body>
</html>