<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ui_pri_0053.jsp
*@FileTitle : Guideline MQC
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.24
*@LastModifier : 김재연
*@LastVersion : 1.0
* 2009.07.24 김재연
* 1.0 Creation
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.scguideline.scrateguideline.event.EsmPri0053Event"%>
<%@ page import="com.hanjin.syscommon.common.table.PriSgRtMqcRngVO"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmPri0053Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.SCGuideline.SCRateGuideline");
	
	String svcScpCd = null;
	String svcScpNm = null;
	String glineSeq = null;
	String prcCustTpCd = null;
	String prcCustTpNm = null;
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (EsmPri0053Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
        	strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		PriSgRtMqcRngVO vo = event.getPriSgRtMqcRngVO();
		
		if (vo != null) {
        	svcScpCd = vo.getSvcScpCd();
        	glineSeq = vo.getGlineSeq();
        	prcCustTpCd = vo.getPrcCustTpCd();
		} else {
        	svcScpCd = "";
        	glineSeq = "";
        	prcCustTpCd = "";
		}
		
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		svcScpNm = (String)eventResponse.getCustomData("SvcScpNm");
		prcCustTpNm = (String)eventResponse.getCustomData("PrcCustTpNm");
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Guideline MQC</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
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
<input type="hidden" name="svc_scp_cd"     value="<%=svcScpCd %>">
<input type="hidden" name="gline_seq"      value="<%=glineSeq %>">
<input type="hidden" name="prc_cust_tp_cd" value="<%=prcCustTpCd %>">
<!-- OUTER - POPUP (S)tart -->
<table width="400" class="popup" cellpadding="10" border="0">
<tr><td class="top"></td></tr>
<tr><td valign="top">

        <!-- : ( Title ) (S) -->
        <table width="100%" border="0">
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Guideline MQC Inquiry</td></tr>
        </table>
        <!-- : ( Title ) (E) -->

        <!--biz page (S)-->
        <table class="search" id="mainTable">
            <tr><td class="bg">

                <!--  biz_1  (S) -->
                <table class="search" border="0" style="width:400;">
                <tr class="h23">
                    <td width="25%">Service Scope</td>
                    <td width=""><input type="text" name="svc_scp_cd" style="width:35;" class="input2" value="<%=svcScpCd %>" readonly="readonly">&nbsp;<input type="text" name="svc_scp_nm" style="width:250;" class="input2" value="<%=svcScpNm %>" readonly="readonly"></td>
                </tr>
                <tr class="h23">
                    <td>Customer Type </td>
                    <td><input type="text" name="prc_cust_tp_nm" style="width:200;" class="input2" value="<%=prcCustTpNm %>" readonly></td>
                </tr>
                </table>
                <!--  biz_1   (E) -->

                <table class="line_bluedot"><tr><td colspan="8"></td></tr></table>

                <!-- : ( Grid ) (S) -->
                <table width="100%"  id="mainTable">
                    <tr>
                        <td width="100%">
                            <script language="javascript">ComSheetObject('sheet1');</script>
                        </td>
                    </tr>
                </table>
                <!-- : ( Grid ) (E) -->
        </td></tr></table>

        <!--biz page (E)-->

</td></tr></table>

<table class="height_5"><tr><td></td></tr></table>

<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

        <!--Button (S) -->
        <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
        <tr><td class="btn3_bg">
            <table border="0" cellpadding="0" cellspacing="0">
            <tr><td><table width="s" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_Retrieve">Retrieve</td>
                    <td class="btn1_right"></td>
                </tr></table></td>
            <td class="btn1_line"></td>
            <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_Close">Close</td>
                    <td class="btn1_right"></td>
                </tr></table></td>

            </tr>
        	</table>
        	</td></tr>
        </table>
        <!--Button (E) -->

    </td></tr>
</table>
<!-- : ( Button : pop ) (E) -->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>