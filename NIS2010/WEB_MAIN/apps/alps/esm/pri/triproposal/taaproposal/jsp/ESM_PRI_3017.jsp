<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_3017.jsp
*@FileTitle : TAA Creation & Amendment [Amend]
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.01
*@LastModifier : 문동규
*@LastVersion : 1.0
* 2009.12.01 문동규
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
<%@ page import="com.hanjin.apps.alps.esm.pri.triproposal.taaproposal.event.EsmPri3017Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmPri3017Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
    String taaNo = null;
    String amdtSeq = null;
    String effDt = null;
    String expDt = null;
    int iAmdtSeq = 0;
    
	Logger log = Logger.getLogger("com.hanjin.apps.TRIProposal.TAAProposal");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmPri3017Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	    taaNo   = JSPUtil.getNull(request.getParameter("taa_no"));
	    amdtSeq = JSPUtil.getNull(request.getParameter("amdt_seq"));
	    effDt   = JSPUtil.getNull(request.getParameter("eff_dt"));
	    expDt   = JSPUtil.getNull(request.getParameter("exp_dt"));
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>TAA Creation & Amendment [Amend]</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
    var amdtSeq = "<%=amdtSeq%>";
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
<input type="hidden" name="amdt_seq">
<input type="hidden" name="old_eff_dt" value="<%=effDt %>">
<input type="hidden" name="old_exp_dt" value="<%=expDt %>">
<!-- 개발자 작업	-->

<!-- OUTER - POPUP (S)tart -->
<table width="400" class="popup" cellpadding="10" border="0">
<tr><td class="top"></td></tr>
<tr><td valign="top">

        <!-- : ( Title ) (S) -->
        <table width="100%" border="0">
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;TAA Creation & Amendment [Amend] </td></tr>
        </table>
        <!-- : ( Title ) (E) -->

        <!--biz page (S)-->
        <table class="search" id="mainTable">
            <tr><td class="bg">
                <table class="search" border="0" width="100%">
                <tr class="h23">
                    <td width="55">TAA  No.</td>
                    <td class="100"><input type="text" name="taa_no" style="width:80;text-align:center;" class="input2" readonly="readonly" value="<%=taaNo %>"></td>
                    <td width="55">AMD  No.</td>
                    <td class=""><input type="text" name="old_amdt_seq" style="width:35;text-align:center;" class="input2" readonly="readonly" value="<%=amdtSeq %>"></td>
                </tr>
                </table>
                <table class="search" border="0" width="100%">
                <tr class="h23">
                    <td width="95">AMD Duration</td>
                    <td class=""><input type="text" caption="Effective date" name="eff_dt" cofield="exp_dt" maxlength="10" 
                        dataformat="ymd" style="width:80;text-align:center;" class="input1" required>&nbsp;<img src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" name="btns_calendar1" class="cursor"> ~ <input type="text" caption="Expiration date" name="exp_dt" cofield="eff_dt" maxlength="10" 
                        dataformat="ymd" style="width:80;text-align:center;" class="input1" required>&nbsp;<img src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" name="btns_calendar2" class="cursor"></td>
                </tr>
                </table>

        <!--biz page (E)-->

        </td></tr></table>


</td></tr></table>
<table class="height_5"><tr><td></td></tr></table>
<table width="100%"  id="mainTable" style="display:none;">
<tr>
    <td width="100%">
    <script language="javascript">ComSheetObject('sheet1');</script>
    </td>
</tr>
</table>
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

        <!--Button (S) -->
        <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
        <tr><td class="btn3_bg">
            <table border="0" cellpadding="0" cellspacing="0">
            <tr>
                      <td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_OK">OK</td>
                    <td class="btn1_right"></td></tr></table></td>
                <td class="btn1_line">
                   <td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_Close">Close</td>
                    <td class="btn1_right"></td></tr></table></td>
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