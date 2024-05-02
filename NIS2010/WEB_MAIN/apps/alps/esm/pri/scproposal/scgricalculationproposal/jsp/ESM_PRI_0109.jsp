<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_0109.jsp
*@FileTitle : GRI Calculation - Arbitrary
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.10
*@LastModifier : 서호열
*@LastVersion : 1.0
* 2009.07.10 서호열
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
<%@ page import="com.hanjin.apps.alps.esm.pri.scproposal.scgricalculationproposal.event.EsmPri0109Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.util.code.CodeInfo"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.common.PRIUtil"%>
<%@ page import="com.hanjin.framework.component.common.AbstractValueObject"%>
<%@ page import="java.util.List"%>

<%
    EsmPri0109Event  event = null;                  //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //서버에서 발생한 에러
    String strErrMsg = "";                      //에러메세지
    int rowCount     = 0;                       //DB ResultSet 리스트의 건수

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    Logger log = Logger.getLogger("com.hanjin.apps.SCProposal.SCGRICalculationProposal");

    //부모창에서 넘어온 파라미터
    String sPropNo      = "";
    String sAmdtSeq     = "";
    String sSvcScpCd    = "";
    String sAddChgTpCd  = "";
    String sOrgDestTpCd = "";
    String sEffDt   = "";
    String sApplFlg = "";
    String sPropStsCd = "";
    
    String[] pers = null;
    String[] cargos = null;

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();

        event = (EsmPri0109Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

        sPropNo      = JSPUtil.getNullNoTrim(request.getParameter("sPropNo"));
        sAmdtSeq     = JSPUtil.getNullNoTrim(request.getParameter("sAmdtSeq"));
        sSvcScpCd    = JSPUtil.getNullNoTrim(request.getParameter("sSvcScpCd"));
        sAddChgTpCd  = JSPUtil.getNullNoTrim(request.getParameter("sAddChgTpCd"));
        sOrgDestTpCd = JSPUtil.getNullNoTrim(request.getParameter("sOrgDestTpCd"));
        sEffDt       = JSPUtil.getNullNoTrim(request.getParameter("sEffDt"));
        sApplFlg     = JSPUtil.getNullNoTrim(request.getParameter("sApplFlg"));
        sPropStsCd   = JSPUtil.getNullNoTrim(request.getParameter("sPropStsCd"));
        
        // per Data 생성
        pers = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("per"), false);
        // cargo type Data 생성
        cargos = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("cargo"), true , "|", "\t", "getCode", "getName");

    }catch(Exception e) {
        out.println(e.toString());
    }

%>
<html>
<head>
<title>GRI Calculation - Arbitrary</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">

    var perComboValue = " |<%=pers[0]%>";
    var perComboText = " |<%=pers[1]%>";

    var cargoComboValue = " |<%=cargos[0]%>";
    var cargoComboText = " |<%=cargos[1]%>";

    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            ComShowMessage(errMessage);
        } // end if
        loadPage();
    }
</script>
</head>

<body onLoad="setupPage();" style="overflow:hidden">

<form name="form">

<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="cd">

<input type="hidden" name="prop_no" value="<%=sPropNo%>">
<input type="hidden" name="amdt_seq" value="<%=sAmdtSeq%>">
<input type="hidden" name="svc_scp_cd" value="<%=sSvcScpCd%>">
<input type="hidden" name="add_chg_tp_cd" value="<%=sAddChgTpCd%>">
<input type="hidden" name="org_dest_tp_cd" value="<%=sOrgDestTpCd%>">
<input type="hidden" name="n1st_cmnc_dt" value="<%=sEffDt%>">
<input type="hidden" name="n1st_cmnc_amdt_seq" value="<%=sAmdtSeq%>">
<input type="hidden" name="gri_appl_tp_cd" value="<%=sApplFlg%>">
<input type="hidden" name="prop_sts_cd" value="<%=sPropStsCd%>">

<table width="600" class="popup" cellpadding="5" border="0">
    <tr><td class="top"></td></tr>
    <tr valign="top">
        <td valign="top">
            <table width="100%" border="0"><tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;GRI Calculation</td></tr></table>
            <table class="search">
                <tr>
                    <td class="bg">
                        <table width="100%" id="mainTable"><tr><td width="100%"><script language="javascript">ComSheetObject('sheet1');</script></td></tr></table>
                        <table width="100%" class="button">
                            <tr>
                                <td class="btn2_bg">
                                    <table border="0" cellpadding="0" cellspacing="0">
                                        <tr>
                                            <td>
                                                <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                                    <tr>
                                                        <td class="btn2_left"></td>
                                                        <td class="btn2" name="btn_RowAdd">Row Add</td>
                                                        <td class="btn2_right"></td>
                                                    </tr>
                                                </table>
                                            </td>
                                            <td>
                                                <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                                    <tr>
                                                        <td class="btn2_left"></td>
                                                        <td class="btn2" name="btn_RowCopy">Row Copy</td>
                                                        <td class="btn2_right"></td>
                                                    </tr>
                                                </table>
                                            </td>
                                            <td>
                                                <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                                    <tr>
                                                        <td class="btn2_left"></td>
                                                        <td class="btn2" name="btn_Delete">Delete</td>
                                                        <td class="btn2_right"></td>
                                                    </tr>
                                                </table>
                                            </td>
                                        </tr>
                                    </table>
                                </td>
                            </tr>
                        </table>
                        
                        <table class="line_bluedot"><tr><td></td></tr></table>
                        
                        <table border="0" style="width:400;" class="search_sm2">
                            <tr class="h23">
                                <td width="">Applying Option</td>
                                <td width="" class="stm">
                                    <input type="radio" class="trans" name="rdo_appl_option" value="F" checked>&nbsp;Amount&nbsp;&nbsp;
                                    <input type="radio" class="trans" name="rdo_appl_option" value="P">&nbsp;Percentage (%)
                                </td>
                            </tr>
                        </table>
                        <table width="100%" id="mainTable"><tr><td width="100%"><script language="javascript">ComSheetObject('sheet2');</script></td></tr></table>
                        <table width="100%" class="button">
                            <tr>
                                <td class="btn2_bg">
                                    <table border="0" cellpadding="0" cellspacing="0">
                                        <tr>
                                            <td>
                                                <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                                    <tr>
                                                        <td class="btn2_left"></td>
                                                        <td class="btn2" name="btn_RowAdd2">Row Add</td>
                                                        <td class="btn2_right"></td>
                                                    </tr>
                                                </table>
                                            </td>
                                            <td>
                                                <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                                    <tr>
                                                        <td class="btn2_left"></td>
                                                        <td class="btn2" name="btn_RowCopy2">Row Copy</td>
                                                        <td class="btn2_right"></td>
                                                    </tr>
                                                </table>
                                            </td>
                                            <td>
                                                <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                                    <tr>
                                                        <td class="btn2_left"></td>
                                                        <td class="btn2" name="btn_Delete2">Delete</td>
                                                        <td class="btn2_right"></td>
                                                    </tr>
                                                </table>
                                            </td>
                                            <td>
                                                <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                                    <tr>
                                                        <td class="btn2_left"></td>
                                                        <td class="btn2" name="btn_Save2">Save</td>
                                                        <td class="btn2_right"></td>
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

        </td>
    </tr>
    
</table>

<div style="display:none">
    <script language="javascript">ComSheetObject('sheet3');</script>
    <script language="javascript">ComSheetObject('sheet4');</script>
    <script language="javascript">ComSheetObject('sheet5');</script>
    <script language="javascript">ComSheetObject('sheet6');</script>
</div>

<table width="100%" class="sbutton">
    <tr>
        <td height="71" class="popup">

            <table width="100%" class="sbutton" border="0">
                <tr>
                    <td height="71" class="popup">
                        <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" !style="padding-top:5; padding-bottom:10;">
                            <tr>
                                <td class="btn3_bg">
                                    <table border="0" cellpadding="0" cellspacing="0">
                                        <tr>
                                            <td width="72">
                                                <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                                    <tr>
                                                        <td class="btn1_left"></td>
                                                        <td class="btn1" name="btn_OK">OK</td>
                                                        <td class="btn1_right"></td>
                                                    </tr>
                                                </table>
                                            </td>
                                            <td width="72">
                                                <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                                    <tr>
                                                        <td class="btn1_left"></td>
                                                        <td class="btn1" name="btn_Cancle">Cancel</td>
                                                        <td class="btn1_right"></td>
                                                    </tr>
                                                </table>
                                            </td>
                                            <td class="btn1_line"></td>
                                            <td>
                                                <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                                    <tr>
                                                        <td class="btn1_left"></td>
                                                        <td class="btn1" name="btn_Close">Close</td>
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
            
        </td>
    </tr>
</table>
            
</form>
</body>
</html>
