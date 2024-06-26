<%
/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ESM_PRI_4100.jsp
*@FileTitle : Surcharge Authority Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.18
*@LastModifier : 이민경
*@LastVersion : 1.0
* 2016.04.18 이민경
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
<%@ page import="com.hanjin.apps.alps.esm.pri.primasterdata.authorizationassignment.event.EsmPri4100Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.common.PRIUtil"%>
<%@ page import="java.util.List"%>

<%
    EsmPri4100Event  event = null;                  //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //서버에서 발생한 에러
    String strErrMsg = "";                      //에러메세지
    int rowCount     = 0;                       //DB ResultSet 리스트의 건수

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    String strOfc_cd        = "";
    String[] trdList = null;
    Logger log = Logger.getLogger("com.hanjin.apps.PRIMasterData.AuthorizationAssignment");

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
        strOfc_cd = account.getOfc_cd();


        event = (EsmPri4100Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        // Service Scope Combo Data 생성
        trdList = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("trdList"));

    }catch(Exception e) {
        out.println(e.toString());
    }
%>
<html>
<head>
<title>S/C &amp; TRI Authority Creation</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
    var trdComboValue = "<%=trdList[0]%>";
    var trdComboText = "<%=trdList[1]%>";

    var trdValue = svcScpCdComboValue.split("|");
    var trdText = svcScpCdComboText.split("|");

    trdComboValue="";
    trdCdComboText="";

    for(var i = 0; i<svcValue.length; i++){
    	if(trdValue[i]!='COM'){
    		trdCdComboValue+="|"+trdValue[i];
    		trdCdComboText+="|"+trdText[i];
    	}
    }

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
<!-- 개발자 작업 -->

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">

    <tr><td valign="top">
    <!--Page Title, Historical (S)-->
        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
            <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
            <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
        </table>
    <!--Page Title, Historical (E)-->


    <!--biz page (S)-->

                <!--  biz_1   (E) -->
                <table class="height_8"><tr><td></td></tr></table>

    <table class="search">
        <tr><td class="bg">

                <!--  biz_2  (S) -->
        <table border="0" style="width:979;" class="search">
                <tr class="h23">
                    <td width="95">Control Office</td>
                    <td width="90"><input type="text" name="cntr_ofc_cd" style="width:55;"  value="<%=strOfc_cd %>" class="input2" readonly="readonly"></td>
                    <td width="110">Authority Holder</td>
                    <td width=""><input type="text" name="cntr_usr_id" style="width:154;"  value="<%=strUsr_nm %>" class="input2" readonly="readonly"></td>
                </tr>
        </table>
        <table border="0" style="width:979;" class="search">
                <tr class="h23">
                    <td width="95">Trade</td>
                    <td width="57" style="padding-left:2;"><script language="javascript">ComComboObject('trd_cd', 2, 55, 0, 1, 0, false);</script></td>
                    <td width="343"><input name="trd_nm" type="text" style="width:295;"  value="" class="input2" readonly="readonly" caption="Tradef">
                    </td>

                    <td width="70">User Office</td>
                    <td width="90"><input type="text" name="ofc_cd" style="width:55;ime-mode:disabled;" value="" class="input1" onKeyPress="ComKeyOnlyAlphabet('upper');" maxlength="6" required caption="User Office"></td>
                    <td width="50">User ID</td>
                    <td width=""><script language="javascript">ComComboObject('usr_id', 2, 100, 0, 0, 0, false);</script>
                    &nbsp;<input name="usr_nm" type="text" style="width:160;"  value="" class="input2" readonly="readonly" caption="User Name">
                    </td>
                    </tr>
                </table>

                <table class="line_bluedot"><tr><td colspan="8"></td></tr></table>

    <table class="search" border="0" style="width:100%;">
        <tr class="h23">
        <td width="40%" valign="top">
            <table width="100%"  id="mainTable">
                <tr>
                    <td width="100%" height="10px">
                        &nbsp;
                    </td>
                </tr>
                <tr>
                    <td width="100%">
                        <script language="javascript">ComSheetObject('sheet1');</script>
                    </td>
                </tr>
            </table>
        </td>
        <td width="3%" valign=""></td>
        <td width="57%" valign="">

        <!-- Grid  (S) -->

            <table width="100%"  id="mainTable">
                <tr>
                    <td width="100%">
                        <script language="javascript">ComSheetObject('sheet2');</script>
                    </td>
                </tr>
            </table>

        <!-- Grid (E) -->

        <!-- Hidden sheet for Transaction (S) -->
        <span style="display:none;"><script language="javascript">ComSheetObject('sheet3');</script></span>
        <!-- Hidden sheet for Transaction (E) -->

        </td>
        </tr>
        </table>

            <!--  biz_2   (E) -->

            </td></tr>
            </table>
                <!--Button (S) -->
        <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
        <tr><td class="btn1_bg">
            <table border="0" cellpadding="0" cellspacing="0">
            <tr>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_Retrieve" id="btn_retrieve">Retrieve</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_New">New</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
                <td class="btn1_line"></td>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_Save">Save</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table>
            </td>
            </tr>
            </table>
        </td></tr>
        </table>
    <!--Button (E) -->

            </td>
            </tr>
        </table>


    <!--biz page (E)-->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>