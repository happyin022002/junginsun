<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0496.jsp
*@FileTitle : T/S Remain Status by Location
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.26
*@LastModifier : 최영희
*@LastVersion : 1.0
* 2009.05.26 최영희
* 1.0 Creation
2011.03.30 정선용 [CHM-201109338-01] Split 18-ALPS의 Location 조회불가건 수정 보완 요청.
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.event.EsmBkg0496Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0496Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.TransshipmentMgt.TransshipmentMgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg0496Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>T/S Remain Status by Location</title>
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

<body  onLoad="setupPage();">
<form name="form" onkeyup="ComKeyEnter('lengthnextfocus');">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="cnmv_sts_cds">
<input type="hidden" name="cntr_tpsz_cds">
<input type="hidden" name="frmr_vvds">
<!-- 개발자 작업	-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
    <tr><td valign="top">
	<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
				<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
				<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
			</table>
	<!--Page Title, Historical (E)-->
	
	
	<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="70">&nbsp;&nbsp;&nbsp;Location</td>
					<td width="178"><input type="text" style="width:50;" class="input" value="" name="loc_cd" dataformat="engupnum" onKeyPress="ComKeyOnlyAlphabet('uppernum')" maxlength="5">&nbsp;<input type="text" style="width:30;" class="input" value="" name="loc_yd_cd" dataformat="engup" maxlength="7">&nbsp;<img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_loc_cd"></td>
					<td width="85">ETB Duration</td>
					<td width="313"><input type="text" style="width:75" class="input" dataformat="ymd" name="vps_etb_dt">&nbsp;&nbsp;~&nbsp;&nbsp;<input type="text" style="width:75" dataformat="ymd" class="input" name="vps_etd_dt">&nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle"  name="btns_calendar"></td> 
					<td width="95">Staying Day(s)</td>
					<td width="134" class="stm"><input type="text" style="width:60;text-align:right;" class="input" value="" name="vps_eta_dt" dataformat="num" maxlength="3"> or over</td> 
					<td><table width="120" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_yard_sum"> Yard Summary</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
				</tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
				<tr><td height="3"></td></tr>
				<tr class="h23">
					<td width="381">
					
						<table class="search_sm2" border="0" width="365">
						<tr class="h23">
							<td width="90">&nbsp;&nbsp;Next VVD</td>
							<td class="stm"><input type="radio" value="Y" class="trans" name="next_vvd">Assigned&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" value="N" class="trans" name="next_vvd">Not Assigned&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" value="A" class="trans" checked name="next_vvd" >All</td></tr>
						</table>
						</td>
					
					<td width="64">Movement</td>
					<td width="130"><input type="text" style="width:30;text-align:center;" class="input" value="TS" dataformat="engup" maxlength="2" name="cnmv_sts_cd1">&nbsp;<input type="text" style="width:30;text-align:center;" class="input" dataformat="engup" value="TN" maxlength="2" name="cnmv_sts_cd2">&nbsp;<input type="text" style="width:30;text-align:center;" class="input" dataformat="engup" value="EN" maxlength="2" name="cnmv_sts_cd3"></td>
					<td width="67">Type/Size</td>
					<td><input type="text" style="width:30;text-align:center;" class="input" value="" dataformat="engup" maxlength="4" name="cntr_tpsz_cd1">&nbsp;<input type="text" style="width:30;text-align:center;" class="input" value="" dataformat="engup" maxlength="4" name="cntr_tpsz_cd2">&nbsp;<input type="text" style="width:30;text-align:center;" class="input" value="" dataformat="engup" maxlength="4" name="cntr_tpsz_cd3">&nbsp;<input type="text" style="width:30;text-align:center;" class="input" value="" dataformat="engup" maxlength="4" name="cntr_tpsz_cd4">&nbsp;<input type="text" style="width:30;text-align:center;" class="input" value="" dataformat="engup" maxlength="4" name="cntr_tpsz_cd5"></td>
				
						
				<table class="line_bluedot"><tr><td></td></tr></table>
				
				<!--Grid (S)-->
					<table width="100%"  id="mainTable">
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet1');</script>
							</td>
						</tr>
					</table>
					<!--Grid (E)-->
<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="67">CNTR Q'ty</td>
					<td ><input type="text" style="width:80;text-align:right;" class="input2"  dataformat="int" value="" name="cntr_qty" maxlength="6" readOnly></td>
				</tr>
				</table>
				<!--  biz_1   (E) -->
				</td></tr>
			</table>
			
			
			
	<!--biz page (E)-->
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_downExcel">Down&nbsp;Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_VVDAssign">Go to Next VVD Assign</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			</tr>
			</table>
		</td></tr>
		</table>
    <!--Button (E) -->
	
	</td></tr>
		</table>
</td></tr>
		</table>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>