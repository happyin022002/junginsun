<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_2002.jsp
*@FileTitle : Guideline Creation [Copy]
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.09
*@LastModifier : 문동규
*@LastVersion : 1.0
* 2009.09.09 문동규
* 1.0 Creation
=========================================================
* History
* 2015.05.12 전지예 [CHM-201534517] 1월 소스 보안 결함 건 조치 요청
=========================================================*/
%>
 
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.rfaguideline.rfaguidelinemain.event.EsmPri2002Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.common.PRIUtil"%>
<%@ page import="java.util.List"%>
<%@ page import="com.hanjin.framework.component.util.StringUtil" %>

<%
	EsmPri2002Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
    String[] svcScpCds = null;

	Logger log = Logger.getLogger("com.hanjin.apps.RFAGuideline.RFAGuidelineMain");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmPri2002Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        // Service Scope Combo Data 생성
        svcScpCds = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("svcScpCd"));

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Guideline Creation [Copy]</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
    var svcScpComboValue = "<%=svcScpCds[0]%>";
    var svcScpComboText = "<%=svcScpCds[1]%>";

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
<input type="hidden" name="svc_scp_cd" value="<%=StringUtil.xssFilter(request.getParameter("svc_scp_cd")) %>">
<input type="hidden" name="gline_seq"  value="<%=StringUtil.xssFilter(request.getParameter("gline_seq")) %>">
<input type="hidden" name="usr_id"  value="<%=strUsr_id %>">


<!-- 개발자 작업	-->

<!-- OUTER - POPUP (S)tart -->
<table width="700" class="popup" cellpadding="10" border="0">
<tr><td class="top"></td></tr>
<tr><td valign="top">

        <!-- : ( Title ) (S) -->
        <table width="100%" border="0">
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Guideline Creation [Copy]</td></tr>
        </table>
        <!-- : ( Title ) (E) -->

        <!-- : ( Search Options ) (S) -->

            <table class="search">
            <tr><td class="bg">

                <!-- : ( grid ) (S) -->
                <table width="100%"  id="mainTable">
                    <tr>
                        <td width="100%">
                            <script language="javascript">ComSheetObject('sheet1');</script>
                        </td>
                    </tr>
                </table>
                <div style="display:none;">
                    <script language="javascript">ComSheetObject('sheet2');</script>
                </div>
                <!-- : ( grid) (E) -->
                <table class="height_5"><tr><td></td></tr></table>
                <table class="search" border="0">
                            <tr><td class="title_h"></td>
                            <td class="title_s">Copy To</td></tr>
                        </table>
                <table class="search" border="0" style="width:100%;">
                <tr class="h23">
                    <td width="90">Service Scope</td>
                    <td width="300"><script language="javascript">ComComboObject('trgt_svc_scp_cd', 2, 55, 0, 1, 0, false);</script>
                    &nbsp;<input name="trgt_svc_scp_nm" type="text" style="width:200;"  value="" class="input2" readonly="readonly" caption="Service Scope"></td>
                    <td width="60">Duration</td>
                    <td><input type="text" style="width:75;text-align:center;" name="trgt_eff_dt" cofield="trgt_exp_dt" value="" class="input1" caption="Effective Date" maxlength="10" dataformat="ymd" required>&nbsp;<img class="cursor" src="img/btns_calendar.gif" name="btns_calendar1" width="19" height="20" border="0" align="absmiddle">&nbsp;~&nbsp;<input type="text" style="width:75;text-align:center;" name="trgt_exp_dt" cofield="trgt_eff_dt" value="" class="input1" caption="Expire Date" maxlength="10" dataformat="ymd" required>&nbsp;<img class="cursor" src="img/btns_calendar.gif" name="btns_calendar2" width="19" height="20" border="0" align="absmiddle"></td></tr>
                </table>

            </td></tr>
        </table>
<!-- : ( Search Options ) (E) -->

    </td></tr>
        </table>
<!-- : ( Button : pop ) (S) -->


<table class="height_5"><tr><td></td></tr></table>

<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

        <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
        <tr><td class="btn3_bg">
            <table border="0" cellpadding="0" cellspacing="0">
                <tr>
                <td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                        <td class="btn1" name="btn_OK">OK</td>
                        <td class="btn1_right"></td></tr></table></td>


                       <td class="btn1_line"></td>
                       <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                        <tr><td class="btn1_left"></td>
                        <td class="btn1" name="btn_Close">Close</td>
                        <td class="btn1_right"></td>
                    </tr></table></td>
                    </tr>
                </table></td>
        </tr>
        </table>
    <!--Button (E) -->

    </td></tr>
</table>
<!-- : ( Button : pop ) (E) -->
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>