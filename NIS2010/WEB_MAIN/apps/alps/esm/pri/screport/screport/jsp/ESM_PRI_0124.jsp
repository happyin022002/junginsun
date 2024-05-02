<%
/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ESM_PRI_0124.jsp
*@FileTitle : Timely Rate Creation Report
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.27
*@LastModifier : 조정민
*@LastVersion : 1.0
* 2012.03.27 조정민
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
<%@ page import="com.hanjin.apps.alps.esm.pri.screport.screport.event.EsmPri0124Event"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.common.PRIUtil"%>
<%@ page import="com.hanjin.framework.component.common.AbstractValueObject"%>
<%@ page import="java.util.List"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmPri0124Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

    String[] rhqs = null;
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.SCReport.SCReport");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmPri0124Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        // rhq Combo Data 생성
        rhqs = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("rhq"));
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>MOT Filing Inquiry</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">

    var rhqComboValue = "|<%=rhqs[0]%>";
    var rhqComboText = "|<%=rhqs[1]%>";

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
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	
	<tr><td valign="top">
	<!--Page Title, Historical (S)-->
	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
	</table>
	
	<!--Page Title, Historical (E)-->
	
	    <!--Button (S) -->
        <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top: 5; , padding-bottom: 10;">
            <tr>
                <td class="btn1_bg">
            <table border="0" cellpadding="0" cellspacing="0">
            <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
                    <td class="btn1_right"></td>
                </tr></table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_new">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
                <td class="btn1_line"></td>
            <td><table border="0" cellpadding="0" cellspacing="0">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_downexcel">Down Excel</td>
                    <td class="btn1_right"></td>
                </tr></table></td>
            </tr>
        </table></td>
            </tr>
        </table>
        <!--Button (E) -->
		<table class="search"> 
       	<tr><td class="bg">
			
			<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="120">Port Closing Date</td>
					<td width="240">
						<input type="text" class="input1" style="width:80;text-align:center;" name="bkg_from_dt" dataformat="ymd" maxLength="10" minlength="8"> <img class="cursor" src="img/btns_calendar.gif" name="btns_calendar1" width="19" height="20" border="0" align="absmiddle"> &nbsp;~&nbsp; 
						<input type="text" class="input1" style="width:80;text-align:center;" name="bkg_to_dt" dataformat="ymd" maxLength="10" minlength="8"> <img class="cursor" src="img/btns_calendar.gif" name="btns_calendar2" width="19" height="20" border="0" align="absmiddle"></td>
                    <td width="50">T/VVD</td>
                    <td width="160">
                        <input type="text" name="vsl_cd" class="input1" style="width:50;text-align:center;" dataformat="engup"  maxLength="4">
                        <input type="text" name="skd_voy_no" class="input1" style="width:50;text-align:center;" dataformat="int"  maxLength="4">
                        <input type="text" name="skd_dir_cd" class="input1" style="width:20;text-align:center;" dataformat="engup"  maxLength="1">
                        <img class="cursor"  src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" name="btn_com_ens_ob2">
                    </td>


				<td width="40">RHQ</td>
				<td width="100"><script language="javascript">ComComboObject('region', 1, 80, 0, 0, 0, false);</script></td>
				<td width="50">C.Office</td>
				<td width="100"><input type="text" name="ctrt_ofc_cd" style="width:60;text-align:center;" class="input" dataformat="engup" maxLength="6"> <img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="ComOpenPopupWithTarget"></td>
				<td width="40">C.Rep</td>
				<td width="80"><input type="text" name="ctrt_srep_cd" style="width:60;text-align:center;" class="input" dataformat="uppernum" maxLength="6"></td>
				</tr>
			</table>
			<!--  biz_1   (E) -->
				
			<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>			
				
		<!-- Grid  (S) -->
			<table width="100%"  id="mainTable"> 
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet1');</script>
					</td>
				</tr>
			</table>
		<!-- Grid (E) -->	
						
				
		</td></tr>
		</table>

	
	<!--biz page (S)-->
		
   
	</td></tr>
</table>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>