<%--=========================================================
* Copyright(c) 2006 CyberLogitec
* @FileName : ESM_MAS_0192.jsp
* @FileTitle : P&L by Lane (After Adjustment)
* Open Issues :
* Change history :
* @LastModifyDate : 2015-05-19
* @LastModifier : Young-Heon Lee
* @LastVersion : 1.0
*  2015-05-19 Young-Heon Lee
*  1.0 최초 생성   
=========================================================--%> 
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.component.util.io.HttpUtil"%> 
<%
	GeneralEventResponse eventResponse = null;
	Exception serverException = null;
	String strErrMsg = "";
	Logger log = Logger.getLogger("com.hanjin.apps.alps.esm.mas.multidimensionrpt.multidimensionrpt.ESM_MAS_0192");
	String userId = "";
	String ofc_cd = "";
	String ofc_lvl = "";
	String headCode1 = ""; //sheet2 가변
	String headName1 = "";
	String headCode2 = ""; //sheet3 가변
	String headName2 = "";
	String xml = "";
	try {
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		} else {
			SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
			userId = account.getUsr_id();
	        ofc_cd = account.getOfc_cd(); //getUserOffice2();
	        ofc_lvl = account.getUsr_auth_tp_cd(); //getUserLevel();
	        xml = HttpUtil.makeXML(request,response); 
	        xml = xml.replaceAll("\"", "'");
	        
	        headCode1 = eventResponse.getETCData("headCode1");
	        headName1 = eventResponse.getETCData("headName1");
	        headCode2 = eventResponse.getETCData("headCode2");
	        headName2 = eventResponse.getETCData("headName2");
	        
		} //end of if
//		N200903120100 처리를 위해 ofc_cd, ofc_lvl을 무조껀 SELHO.  1로 바꿔준다
		ofc_cd = !"SELHO".equals(ofc_cd)?"SELHO":ofc_cd;
		ofc_lvl = !"1".equals(ofc_cd)?"1":ofc_lvl;
		
	} catch(Exception e) {
		log.error("JSP Exception : " + e.toString());
	}

%>

<html>
<head>
<title>P&L by Lane</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage() {
		var formObj = document.form;
		var errMessage = '<%=strErrMsg%>';
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if

		loadPage("<%=headCode1%>","<%=headName1%>","<%=headCode2%>","<%=headName2%>");
	}
</script>
</head>

<body onload="javascript:setupPage();">
<form method="post" name="form" onKeyDown="ComKeyEnter();">
<input type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="f_wk_flg">
<input type="hidden" name="headCode1" value="<%=headCode1.toString()%>">
<input type="hidden" name="headCode1" value="<%=headName1.toString()%>">
<input type="hidden" name="headCode2" value="<%=headCode2.toString()%>">
<input type="hidden" name="headName2" value="<%=headName2.toString()%>">

<input type="hidden" name="v_ofc_cd"  value="<%=ofc_cd%>">
<input type="hidden" name="v_ofc_lvl" value="<%=ofc_lvl%>">
<input type="hidden" name="sXml" value="<%=xml%>"> 


<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>


		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->


		<!--Button_L (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
	       	<tr><td class="btn1_bg">

				<table border="0" cellpadding="0" cellspacing="0">
				<tr>
					<!-- Repeat Pattern -->
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" id="btn_retrieve" name="btn_retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>

					<td class="btn1_line"></td>
                    <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" id="btn_create" name="btn_create">Create</td><td class="btn1_right"></td></tr></table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" id="btn_downexcel" name="btn_downexcel">Down Excel</td><td class="btn1_right"></td></tr></table></td>
					<!-- Repeat Pattern -->

				</tr></table>

			</td></tr>
		</table>
		<!--Button_L (E) -->


<!-- TABLE '#D' : ( Search Options ) (S) -->
<table class="search">
<tr>
	<td class="bg">

		<table class="search_in" border="0">
		<tr class="h23">
			<td colspan="10"><script language="javascript">masPeriod3_ofc();</script></td>
		</tr>
		</table>

		<table class="search_in" border="0">
		<tr><td class="line_bluedot" style="height:15;"></td></tr>
		</table>

		<table class="search_in" border="0">
		<tr class="h23">
			<td width="8%">&nbsp;&nbsp;Trade</td>
			<td width="13%">
				<script language="javascript">ComComboObject('f_trd_cd',1, 80 , 0 )</script>
			</td>
			<td width="8%">Sub Trade</td>
			<td width="13%">
				<script language="javascript">ComComboObject('f_sub_trd_cd',1, 80 , 0 )</script>
			</td>
		</tr>
		<tr class="h23">
			<td width="8%">&nbsp;&nbsp;Lane</td>
			<td width="13%">
				<script language="javascript">ComComboObject('f_rlane_cd',1, 80 , 0 )</script>
			</td>
			<td width="8%">Bound</td>
			<td width="13%">
				<script language="javascript">ComComboObject('f_dir_cd',1, 80 , 0 )</script>
			</td>
			<td width="8%">Trade Dir.</td>
			<td width="13%">
				<script language="javascript">ComComboObject('f_trd_dir_cd',1, 100 , 0 )</script>
			</td>
			<td width="5%">VVD</td>
			<td width="40%">
				<input type="text" size="4" name="f_vsl_cd"     maxlength="4" onKeyPress="ComKeyOnlyAlphabet('uppernum')" onKeyUp="ComKeyEnter('LengthNextFocus');" style="ime-mode:disabled; width:55;" >
				<input type="text" size="4" name="f_skd_voy_no" maxlength="4" onKeyPress="ComKeyOnlyNumber(this);" onKeyUp="ComKeyEnter('LengthNextFocus');" style="ime-mode:disabled; width:55;">
				<input type="text" size="1" name="f_skd_dir_cd" maxlength="1" onKeyPress="ComKeyOnlyAlphabet('upper')" style="ime-mode:disabled; width:37;" >
			</td>
		</tr>
		</table>

	</td>
</tr>
</table>

<!-- TABLE '#D' : ( Search Options ) (E) -->
<table class="height_10"><tr><td></td></tr></table>

<!-- TABLE '#D' : ( Search Options ) (S) -->
<table class="search">
<tr><td class="bg">


		<table class="search" border="0">
		<tr><td class="title_h"></td>
			<td class="title_s">Report Form</td></tr>
		</table>

		<!-- P&L Report -->
	
		<!-- : ( Report Form ) (S) -->
		<table class="search" border="0" style="width:100%;">
		<tr class="h23">
			<td width="330" class="sm">
				<input type="radio" name="f_rdotype" class="trans" value="1" checked>&nbsp;P&L (Total) &nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" name="f_rdotype" class="trans" value="2" >&nbsp;P&L (Trade) &nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" name="f_rdotype" class="trans" value="3" >&nbsp;P&L (VVD)</td>
		</tr>
		</table>
		<!-- : ( Report Form ) (E) -->
	
		<table width="100%">
		<tr>
			<td width="100%">
				<div id="tabLayer1" style="display:inline">
				<table width="100%" id="mainTable1">
				<tr><td><script language="javascript">ComSheetObject('sheet1');</script></td></tr>
				</table>
				</div>
				<div id="tabLayer2" style="display:none">
				<table width="100%" id="mainTable2">
				<tr><td><script language="javascript">ComSheetObject('sheet2');</script></td></tr>
				</table>
				</div>
				<div id="tabLayer3" style="display:none">
				<table width="100%" id="mainTable3">
				<tr><td><script language="javascript">ComSheetObject('sheet3');</script></td></tr>
				</table>
				</div>
			</td>
		</tr>
		</table>
			</td>
		</tr>
	</table>
	<!-- TABLE '#D' : ( Search Options ) (E) -->


</td></tr>
</table>
<!-- Outer Table (E)-->


</form>
</body>
</html>

