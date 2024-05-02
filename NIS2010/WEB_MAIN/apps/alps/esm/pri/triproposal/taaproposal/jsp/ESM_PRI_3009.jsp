<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_3009.jsp
*@FileTitle : TRI Creation & Amendment - TRI Select
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.03
*@LastModifier : 문동규
*@LastVersion : 1.0
* 2009.12.03 문동규
* 1.0 Creation
=========================================================
* History
* 2011.03.15 이행지 [CHM-201109281-01] ALPS의 Location 조회불가건 수정 보완 요청 - Location Code 중 숫자를 포함한 Code 를 조회, 입력 등 모든 부분에서 가능하도록 수정
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.triproposal.taaproposal.event.EsmPri3009Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EsmPri3009Event  event = null;                  //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //서버에서 발생한 에러
    String strErrMsg = "";                      //에러메세지
    int rowCount     = 0;                       //DB ResultSet 리스트의 건수

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    String trfCd = null;
    String trfNm = null;
    String trfPfxCd = null;
    String trfNo = null;
    Logger log = Logger.getLogger("com.hanjin.apps.TRIProposal.TAAProposal");

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();


        event = (EsmPri3009Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        trfCd    = JSPUtil.getNull((String)eventResponse.getCustomData("trfCd"));
        trfNm    = JSPUtil.getNull((String)eventResponse.getCustomData("trfNm"));
        trfPfxCd = JSPUtil.getNull((String)eventResponse.getCustomData("trfPfxCd"));
        trfNo    = JSPUtil.getNull((String)eventResponse.getCustomData("trfNo"));
    }catch(Exception e) {
        out.println(e.toString());
    }
%>
<html>
<head>
<title>TRI Creation &amp; Amendment - TRI Select</title>
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

<body onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="frm_trf_pfx_cd" value="<%=trfPfxCd %>">
<input type="hidden" name="frm_trf_no" value="<%=trfNo %>">
<!-- 개발자 작업 -->

<!-- OUTER - POPUP (S)tart -->
<table width="1015" class="popup" cellpadding="10" border="0">
<tr><td class="top"></td></tr>
<tr><td valign="top">

        <!-- : ( Title ) (S) -->
        <table width="100%" border="0">
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;TAA Creation &amp; Amendment - TRI Select </td></tr>
        </table>
        <!-- : ( Title ) (E) -->

        <!--biz page (S)-->
        <table class="search" id="mainTable">
            <tr><td class="bg">

                <table class="search" border="0" style="width:100%;">
                <tr class="h23">
                    <td width="67">Tariff Code</td>
                    <td width="310"><input type="text" name="frm_trf_no" style="width:80;text-align:center;" class="input2" value="<%=trfCd %>" readonly="readonly">&nbsp;<input type="text" name="frm_trf_nm" style="width:195;text-align:left;" class="input2" value="<%=trfNm %>" readonly="readonly"></td>
                    <td width="110">Commodity Code</td>
                    <td width="70"><input type="text" name="frm_cmdt_cd" style="width:70;text-align:center;" class="input">&nbsp;</td>
                    <td width="20"><table>
                            <tr>
                                <td><img src="img/btns_search.gif" width="19" height="20"
                                    alt="" border="0" align="absmiddle" name="btn_cmdt"
                                    class="cursor"></td>
                            </tr>
                        </table></td>

                    <td width=""><input type="text" name="frm_cmdt_nm" style="width:208;" class="input2" value=""></td>

                </tr></table>
                <table class="search" border="0" style="width:100%;">
                <tr class="h23"> <!-- //2011.03.15 이행지 [CHM-201109281-01] ALPS의 Location 조회불가건 수정 보완 요청 - Location Code 영문대문자,숫자 입력가능하도록 수정    ComKeyOnlyAlphabet('upper') -> uppernum              -->
                    <td width="35">Origin</td>
                    <td width="65"><input type="text" name="frm_org_pnt_loc_cd" style="width:50;text-align:center;ime-mode:disabled;" onKeyPress="ComKeyOnlyAlphabet('uppernum');" maxlength="5" class="input"></td>
                    <td width="60">Origin Via</td>
                    <td width="65"><input type="text" name="frm_org_via_port_cd" style="width:50;text-align:center;ime-mode:disabled;" onKeyPress="ComKeyOnlyAlphabet('uppernum');" maxlength="5" class="input"></td>
                    <td width="70">Dest. Via</td>
                    <td width="80"><input type="text" name="frm_dest_via_port_cd" style="width:50;text-align:center;ime-mode:disabled;" onKeyPress="ComKeyOnlyAlphabet('uppernum');" maxlength="5" class="input"></td>
                    <td width="66">Destinaion</td>
                    <td width="110"><input type="text" name="frm_dest_pnt_loc_cd" style="width:50;text-align:center;ime-mode:disabled;" onKeyPress="ComKeyOnlyAlphabet('uppernum');" maxlength="5" class="input"></td>
                    <td width="130">Tariff Rate Item(TRI)</td>
                    <td width=""><input type="text" name="frm_tri_no" style="width:110;text-align:center;" class="input"></td>

                </tr></table>

                <table class="line_bluedot"><tr><td></td></tr></table>
                <!-- : ( Grid ) (S) -->
                <table width="100%"  id="mainTable">
                    <tr>
                        <td width="100%">
                            <script language="javascript">ComSheetObject('sheet1');</script>
                        </td>
                    </tr>
                </table>
                <table width="100%"  id="mainTable" style="display:none;">
                    <tr>
                        <td width="100%">
                            <script language="javascript">ComSheetObject('sheet2');</script>
                        </td>
                    </tr>
                </table>
                <!-- : ( Grid ) (E) -->
                <table width="100%" class="button">
                    <tr><td class="btn2_bg">
                            <table border="0" cellpadding="0" cellspacing="0"><tr>
                                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                <tr><td class="btn2_left"></td>
                                <td class="btn2" name="btn_Retrieve">Retrieve</td>
                                <td class="btn2_right"></td></tr>
                                </table></td>
                            </tr></table>
                        </td></tr>
                </table>

                <table class="height_8"><tr><td></td></tr></table>
                <table class="grid2" border="0" style="width:100%;">
                <tr class="tr2_head">
                    <td width="25%">Origi</td>
                    <td width="25%">Origin Via</td>
                    <td width="25%">Desination Via</td>
                    <td width="25%">Desination</td>
                </tr>
                <tr class="input2">
                    <td><textarea name="frm_org_pnt_loc_nm" style="width:100%; height:80;" class="textarea2" readonly="readonly"></textarea></td>
                    <td><textarea name="frm_org_via_port_nm" style="width:100%; height:80;" class="textarea2" readonly="readonly"></textarea></td>
                    <td><textarea name="frm_dest_via_port_nm" style="width:100%; height:80;" class="textarea2" readonly="readonly"></textarea></td>
                    <td><textarea name="frm_dest_pnt_loc_nm" style="width:100%; height:80;" class="textarea2" readonly="readonly"></textarea></td>

                </tr></table>

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
            <tr>
                    <td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
                        <tr><td class="btn1_left"></td>
                            <td class="btn1" name="btn_OK">OK</td>
                            <td class="btn1_right"></td></tr></table></td>
                    <td class="btn1_line"></td>
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