<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_AGT_033.jsp
*@FileTitle : FAC Commission Maintenance
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.agt.agtaudit.facaudit.event.EsmAgt0033Event"%>
<%@ page import="com.clt.apps.opus.esm.agt.common.CodeUtil" %>
<%@ page import="com.clt.apps.opus.esm.agt.common.ComboUtil" %>

<%

EsmAgt0033Event event = null; //PDTO(Data Transfer Object including Parameters)
Exception serverException = null; //error from server
DBRowSet rowSet = null; //DB ResultSet
String strErrMsg = ""; //error message
int rowCount = 0; //count of DB resultSET list
//String successFlag = "";
//String codeList  = "";
//String pageRows  = "100";

String userId = "";
String ofcCd = "";
String arOfcCd = "";
String ar_ofc_cd = "";
String agn_cd = "";

try {
	SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	userId = account.getUsr_id();
	ofcCd = account.getOfc_cd();

	event = (EsmAgt0033Event) request.getAttribute("Event");
	serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

	if (serverException != null) {
		strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
	}
	// adding logic to get data from server when first loading ..
	GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
} catch (Exception e) {
	out.println(e.toString());
}

//Retrieving A/R Office Code of Login User's division.

arOfcCd = CodeUtil.getInstance().getCodeInfo("arOfcCd", ofcCd);

//Combo Data : getCodeCombo('Tag Name','Init Value', 'Additional Properties', 'Biz name', 'Condition Code', 'Whole check', 'Additional Option')facArOfcCd
//ar_ofc_cd = ComboUtil.getCodeCombo("ar_ofc_cd", arOfcCd, " style='width:85'", "arOfcCd", ofcCd, "&lt;&lt;select&gt;&gt;", "");
ar_ofc_cd = ComboUtil.getCodeCombo("ar_ofc_cd", arOfcCd, " style='width:85'", "facArOfcCd", ofcCd, "&lt;&lt;select&gt;&gt;", "");
//agn_cd = ComboUtil.getCodeCombo("agn_cd", ofcCd, " style='width:100'", "sbOfcCd", arOfcCd, "&lt;&lt;select&gt;&gt;", "");
agn_cd = ComboUtil.getCodeCombo("agn_cd",arOfcCd, " style='width:85'", "facSubOfcCd", arOfcCd, "&lt;&lt;select&gt;&gt;", "");

%>

<html>
<head>
<title>FAC Commission Maintenance</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
        function setupPage(){
                var errMessage = "<%=strErrMsg%>";
                if (errMessage.length >= 1) {
                        ComShowMessage(errMessage);
                } // end if
                loadPage();
        }
</script>
</head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<iframe height="0" width="0" name="frmHidden"></iframe>

<form name = "hiddenF" mehhod="post">
<input type="hidden" name="sheetId">
<input type="hidden" name="f_cmd">
<input type="hidden" name="cust_cd">
<input type="hidden" name="row">
<input type="hidden" name="colNm1">
<input type="hidden" name="colNm2">
</form>

<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="selOfcCd">
<input type="hidden" name="arOfcCd" value="<%=arOfcCd %>">


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
                                                        <tr><td class="btn1_left"></td><td class="btn1" name="btn_retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>

                                                <td class="btn1_line"></td>

                                                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                                        <tr><td class="btn1_left"></td><td class="btn1" name="btn_new">New</td><td class="btn1_right"></td></tr></table></td>

                                                <!--
                                                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                                        <tr><td class="btn1_left"></td><td class="btn1" name="btn_save">Save</td><td class="btn1_right"></td></tr></table></td>
                                                  -->

                                                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                                        <tr><td class="btn1_left"></td><td class="btn1" name="btn_recalculate">Re-calculate</td><td class="btn1_right"></td></tr></table></td>
                                                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                                        <tr><td class="btn1_left"></td><td class="btn1" name="btn_downexcel">Down Excel</td><td class="btn1_right"></td></tr></table></td>
                                                <!-- Repeat Pattern -->

                                        </tr></table>

                                </td></tr>
                        </table>
                <!-- TABLE '#D' : ( Button : Main ) (E) -->

                <!-- TABLE '#D' : ( Search Options ) (S) -->
                <table class="search">
                <tr><td class="bg">

                                <table class="search_in" border="0">
                                        <tr class="h23">
                                                <td width="45%">
                                                        <table border="0" style="height:15; width:350;">
														<tr>
															<td width="230" class="stm" style="padding-left:10;">
																<input type="radio" name="ofc_option" value="A" class="trans" onclick="rdoOfficeOpt_onClick(this);" checked>AR Office&nbsp;&nbsp;&nbsp;
																<input type="radio" name="ofc_option" class="trans" value="S" onclick="rdoOfficeOpt_onClick(this);">Sales Office</td>
															<td width=""><div id="div_ar_ofc" style="display:block;"><%=ar_ofc_cd %></div><div id="div_sub_ofc" style="display:none;"><%=agn_cd %></div></td></tr>
                                                        </table>
                                                </td>
                                                <td width="45%">
                                                        <table border="0" style="height:15; width:92%;">
                                                        <tr><td class="stm" width="173" style="padding-left:10;">
                                                        		<input type="radio" name="date_option" value="C" class="trans" checked>Creation&nbsp;&nbsp;&nbsp;
                                                        		<input type="radio" name="date_option" class="trans" value="E">ETD</td>
                                                        	<td><input type="text" name="search_dt_fr" style="width:75;"  dataformat="ymd" OnBeforeDeactivate="ComAddSeparator(this)" OnBeforeActivate="ComClearSeparator(this)" maxlength="10">&nbsp;
                                                        	<img class="cursor" src="/opuscntr/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar1" >&nbsp;~&nbsp;
                                                        	<input type="text" name="search_dt_to" style="width:75"  dataformat="ymd" OnBeforeDeactivate="ComAddSeparator(this)" OnBeforeActivate="ComClearSeparator(this)" maxlength="10">&nbsp;<img class="cursor" src="/opuscntr/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar2"></td></tr>
                                                        </table>
                                                </td>
                                                <td align="right">Cur &nbsp;
                                                    <select name="s_curr_cd" style="width:50;">
                                                                <option value="" selected>All</option>
                                                                <option value="USD">USD</option>
                                                                <option value="EUR">EUR</option>
                                                        </select>
                                                </td>
                                        </tr>
                                </table>
                                <table class="search_in" border="0">
                                        <tr class="h23">
                                                <td width="3%">VVD</td>
                                                <td width="13%"><input name="vvd" type="text" style="width:85;ime-mode:disabled;" onkeypress="ComKeyOnlyAlphabet('uppernum')" maxlength="10"></td>
                                                <td width="8%">F/Forwarder</td>
                                                <td width="21%" style="padding-left:5;"><input type="text" name="ff_cnt_cd" style="width:85;ime-mode:disabled;" onkeypress="ComKeyOnlyAlphabet('uppernum')" maxlength="8">&nbsp;<a href="javascript:openWindowCustomer(document.form);" class="purple"><img class="cursor" src="/opuscntr/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></a></td>
                                                <td width="9%">Bill Of Lading</td>
                                                <td><input type="text" name="bl_no" style="width:90;ime-mode:disabled;" onkeypress="ComKeyOnlyAlphabet('uppernum');" onKeyUp="ComKeyOnlyAlphabet('uppernum');setBlNo(this);" maxlength="12">&nbsp;<input type="text" name="bl_nos" style="width:354; ime-mode:disabled;" onkeypress="setBlNos(this);" onKeyUp="setBlNos(this);"></td>
                                        </tr>
                                </table>

                        </td></tr>
                </table>
                <!-- TABLE '#D' : ( Search Options : BKG Information ) (E) -->

                <table class="height_10"><tr><td></td></tr></table>

                <!-- TABLE '#D' : ( Search Options ) (S) -->
                <table class="search">
                <tr><td class="bg">

                <!-- : ( BKG Information ) (S) -->

                <!-- : ( grid ) (S) -->
                                                <table width="100%" id="mainTable">
                                                          <tr><td>
                                                         <script language="javascript">ComSheetObject('sheet1');</script>
                                                          </td></tr>
                                                </table>
                <!-- : ( grid ) (E) -->

                        </td></tr>
                </table>
                <!-- TABLE '#D' : ( Search Options ) (E) -->


</td></tr>
</table>
<!-- Outer Table (E)-->


</form>
</body>
</html>