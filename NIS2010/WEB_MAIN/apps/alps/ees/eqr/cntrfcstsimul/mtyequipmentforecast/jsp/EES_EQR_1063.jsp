<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EES_EQR_1063.jsp
*@FileTitle : Sales Forecast History
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.30
*@LastModifier : 전지예
*@LastVersion : 1.0
* 2014.11.30 전지예
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
<%@ page import="com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.mtyequipmentforecast.event.EesEqr1063Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	String strErrMsg = "";						//에러메세지
	
	String optionStr = "000000: :ALL";
	String cntrTpsz  = JSPUtil.getCodeCombo("cntrTpsz","","style='width:70;'","CD00263",0,optionStr);
	String locSelectBox = JSPUtil.getCodeCombo("loc_tp_cd_second","L","","CD03052",0,"");
%>

<html>
<head>
<title>SALES FORECAST HISTORY</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script type="text/javascript">
	// Type Size
	<%= JSPUtil.getIBCodeCombo("tpszall", "01", "CD00830", 0, "")%> // ALL TYPE SIZE CD00244
	<%= JSPUtil.getIBCodeCombo("tpszdry", "01", "CD00751", 0, "")%> // DRY TYPE SIZE
	
	// ------- type 변수선언 -------------- START
	var consTpszDry   = replaceAll(tpszdryText, "|", ",");
	// ------- type 변수선언 -------------- END
	
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>
<body  onLoad="setupPage();"> 
<form name="form">
<input type="hidden" name="f_cmd" />
<input type="hidden" name="inquiryLevel" value="" />
<input type="hidden" name="location" value="" />
<input type="hidden" name="backendjob_key" />

	<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
		<tr><td valign="top">
		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!--Page Title, Historical (E)-->
		
		</td></tr>
		<tr><td valign="top">
		
		<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:2;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_retrieve" id="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_new">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_downexcel">Down Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				</tr>
			</table>
		</td></tr>
		</table>
    	<!--Button (E) -->
		
		<!--biz page (S)-->
		<!-- 1 (S) -->
		<table class="search" id="mainTable">
       		<tr><td class="bg">
				<!--  biz_1  (S) -->
				<table class="search" style="width:979; border: 0;">
				<tr class="h23">
					
					<td width="20">
						<input type="radio" name="div_flag" value="1" class="trans" OnClick="ChangeInputStatus(1);" checked>
					</td>
					<td width="80">Location By</td>
					<td width="72">
						<select style="width:100;" name="loc_tp_cd" class="input">
							<option value="E" selected>ECC(by SCC)</option>
							<option value="L">LCC(by ECC)</option>
							<option value="S">LCC(by SCC)</option>
							<option value="R">RCC(by LCC)</option>
						</select>
					</td>
					<td width="100">
						<input type="text" dataformat="engup" size="5" maxlength="5" caption="Location By CD"  style="width:50;" class="input1" name="loc_cd" value="">&nbsp;<img src="img/btns_search.gif" name="btn_loc_cd" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
					</td>
					
					<td width="20">
						<input type="radio" name="div_flag" value="2" class="trans" OnClick="ChangeInputStatus(2);">
					</td>
					<td width="60">Location</td>
					<td width="50"><%= locSelectBox %></td> <!-- loc_tp_cd_second -->
					<td width="100">
						<input type="text" dataformat="engup" size="5" maxlength="5" caption="Location CD" style="width:50;" class="input1" name="loc_cd_second" value="">&nbsp;<img src="img/btns_search.gif" name="btn_loc_cd_second" width="19" height="20" border="0" align="absmiddle" class="cursor">
					</td>
					<td width="35">Week</td>
					<td width="180"><input type="text" style="width:60"  required maxlength="7" caption="Week From" dataformat="yw" class="input1" name="fm_week" value="">&nbsp;~&nbsp;<input type="text" style="width:60" caption="Week To" required maxlength="7" dataformat="yw"  class="input1" name="to_week" value="">&nbsp;</td>
					<td width="250"></td>
				</tr>
				<tr class="h23">
				    <td></td>
					<td>TP/SZ</td>
					<td width="70">
						<select name="cntrTpsz" style="width:70px;">
							<option value="D">DRY</option>
						</select>
					</td>
					<td colspan=8>&nbsp;<script type="text/javascript">ComComboObject('tpsztype', 1, 280, 1)</script></td><!--  -->
				</tr>
				</table>
				<!--  biz_1   (E) -->
			</td></tr>
		</table>
		<!-- 1 (E) -->
		<table class="height_8"><tr><td></td></tr></table>
		
		<!-- grid box (S) -->
		<table class="search" style="width:100%; border:0;">
	        <tr><td valign="top" align=left>
	        <!-- Grid - 1 (S) -->
	        <table id="mainTable" style="width:100%; border:0;">
                <tr>
                	<td style="width:100%;" align=left><script type="text/javascript">ComSheetObject('sheet1');</script></td>
                </tr>
	        </table>
	        <!-- Grid - 1 (E) -->
	        </td></tr>
        </table>
		<!-- grid box (E) -->
		
	    <div id="tabLayer" style="display:none">
			<!-- Tab BG Box  (S) -->
 		   	<table class="search">
	  	    	<tr><td class="bg">
				<!--  Grid_button (S) -->
				</td></tr>
			</table>
		</div>
		
	<!--biz page (E)-->
	</td></tr>
	</table>
	<table class="height_10"><tr><td colspan="8"></td></tr></table>
</form>
</body>
</html>