<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_2007.jsp
*@FileTitle : RFA Proposal Creation [Request]
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.01
*@LastModifier : 문동규
*@LastVersion : 1.0
* 2009.10.01 문동규
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
<%@ page import="com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.event.EsmPri2007Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmPri2007Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
    String propNo = null;
    String amdtSeq = null;
	Logger log = Logger.getLogger("com.hanjin.apps.RFAProposal.RFAProposalMain");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmPri2007Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

        propNo = JSPUtil.getNull(request.getParameter("prop_no"));
        amdtSeq = JSPUtil.getNull(request.getParameter("amdt_seq"));
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>RFA Proposal Creation [Request]</title>
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
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<input type="hidden" name="prop_no" value="<%=propNo %>">
<input type="hidden" name="amdt_seq" value="<%=amdtSeq %>">
<!-- 개발자 작업	-->

<!-- OUTER - POPUP (S)tart -->
<table width="800" class="popup" cellpadding="10" border="0">
<tr><td class="top"></td></tr>
<tr><td valign="top">

        <!-- : ( Title ) (S) -->
        <table width="100%" border="0">
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;RFA Proposal Creation [Request]</td></tr>
        </table>
        <!-- : ( Title ) (E) -->

        <!--biz page (S)-->
        <table class="search">
            <tr><td class="bg">

            <table>
                <tr>
                    <td>

                        <table class="search" border="0" style="width:690;">
                            <tr class="h23">
                                <td width="77">&nbsp;Office Code</td>
                                <td width="70"><input type="text" name="ofc_cd" maxlength="6" style="width:60;ime-mode:disabled;" onKeyPress="ComKeyOnlyAlphabet('upper');" maxlength="6" class="input"></td>
                                <td width="60" align="right">User ID&nbsp;</td>
                                <td width="160" style=""><input type="text" name="usr_id" style="width:150;ime-mode:disabled;" class="input"></td>
                                <td width="80" align="right">User Name&nbsp;</td>
                                <td width="" style=""><input type="text" name="usr_nm" style="width:150;ime-mode:disabled;" class="input"></td>
                            </tr>
                        </table>
                    </td>
                    <td>
                        <!--Button (S) -->
                        <!-- <table width="330" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> -->
                        <table width="95" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
                            <tr>
                                <td class="btn1_bg">
                                    <table border="0" cellpadding="0" cellspacing="0">
                                        <tr>
                                            <td>
                                                <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                                    <tr>
                                                        <td class="btn1_left"></td>
                                                        <td class="btn1" name="btn_Search">Search</td>
                                                        <td class="btn1_right"></td>
                                                    </tr>
                                                </table>
                                            </td>
                                        </tr>
                                    </table>
                                </td>
                            </tr>
                        </table>
                        
                    </td>
                </tr>
            </table>
            
            <!--Button (E) -->
            <table class="line_bluedot"><tr><td colspan="6"></td></tr></table>

            <!--  biz_1  (S) -->
            <table class="search" border="0" style="width:784;">
            <tr class="h23">
                <td width="327" valign="top">
                    <table width="100%" class="search"  id="mainTable">
                        <tr>
                            <td width="100%">
                            <script language="javascript">ComSheetObject('sheet1');</script>
                            <!-- <div id="treeView" style="overflow: auto; width: 320px; height: 250px; border-width: 1px; border-style: solid; border-color: #7F9DB9;"></div> -->
                            </td>
                        </tr>
                    </table>
                </td>

                <td width="457">
                <table border="0">
                    <tr><td width="100" align="center">
                        <table border="0">
                        <tr><td><img src="img/btns_add.gif" width="26" height="26" alt="" border="0" align="absmiddle"class="cursor" name="btn_AddTo"></td></tr>
                        <tr><td style="padding-top:5"><img src="img/btns_del.gif" width="26" height="26" alt="" border="0" align="absmiddle" class="cursor" name="btn_DeleteTo"></td></tr>
                        <tr><td style="height:60">&nbsp;</td></tr>
                        <tr><td><img src="img/btns_add.gif" width="26" height="26" alt="" border="0" align="absmiddle"class="cursor" name="btn_AddCC"></td></tr>
                        <tr><td style="padding-top:5"><img src="img/btns_del.gif" width="26" height="26" alt="" border="0" align="absmiddle" class="cursor" name="btn_DeleteCC"></td></tr></table></td>
                        <td width="373">
                        <table width="100%" class="search"  id="subTable1">
                            <tr>
                                <td width="100%">
                                <script language="javascript">ComSheetObject('sheet2');</script>
                                </td>
                            </tr>
                        </table>
                        <table class="height_10"><tr><td></td></tr></table>
                        <table width="100%" class="search"  id="subTable2">
                            <tr>
                                <td width="100%">
                                <script language="javascript">ComSheetObject('sheet3');</script>
                                </td>
                            </tr>
                        </table>
                </td></tr></table>
                </td>
            </tr></table>   <!--  biz_1   (E) -->


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
            <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_Send">Send</td>
                    <td class="btn1_right">
                </tr></table></td>
            <td class="btn1_line"></td>
            <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_Close">Close</td>
                    <td class="btn1_right">
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