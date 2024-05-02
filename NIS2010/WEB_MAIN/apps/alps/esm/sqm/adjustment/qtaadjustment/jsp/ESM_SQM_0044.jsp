<%
/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : ESM_SQM_0044.jsp
*@FileTitle      : Portion Adjusted Figure Inquiry_RHQ
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.10.21
*@LastModifier   :
*@LastVersion    : 1.0
* 2013.10.21 SQM USER
* 1.0 Creation
* 2013.10.21 PEJ [CHM-201327263] Figure Inquiry  조회 팝업 추가
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.sqm.adjustment.qtaadjustment.event.EsmSqm0043Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EsmSqm0043Event  event = null;                  //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //서버에서 발생한 에러
    String strErrMsg = "";                      //에러메세지
    int rowCount     = 0;//DB ResultSet 리스트의 건수

    String successFlag = "";
    String codeList    = "";
    String pageRows    = "100";
    String trdCd       = "";
    String rlaneCd     = "";
    String dirCd       = "";
    String ofcCd       = "";
    String bseYr       = "";
    String bseQtrCd    = "";
    String bound       = "";
    String ofcVwCd     = "";
    String ofcVwNm     = "";
    String bseTpCd     = "";
    String divPeriod   = "";
    String trdDir      = "";
    String trdDirNm    = "";
    String f_click     = "";
    String obDivCd     = "";
    String obDivNm     = "";

    String strUsr_id   = "";
    String strUsr_nm   = "";
    Logger log = Logger.getLogger("com.hanjin.apps.datamanage.basicdata");

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();


        event = (EsmSqm0043Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        trdCd     = JSPUtil.getNull(request.getParameter("f_trd_cd"));
        rlaneCd   = JSPUtil.getNull(request.getParameter("f_rlane_cd"));
        dirCd     = JSPUtil.getNull(request.getParameter("f_conv_dir_cd"));
        ofcCd     = JSPUtil.getNull(request.getParameter("f_rgn_ofc_cd"));
        bseYr     = JSPUtil.getNull(request.getParameter("f_bse_yr"));
        bseQtrCd  = JSPUtil.getNull(request.getParameter("f_bse_qtr_cd"));
        divPeriod = JSPUtil.getNull(request.getParameter("div_period"));
        bseTpCd   = JSPUtil.getNull(request.getParameter("f_bse_tp_cd"));
        ofcVwCd   = JSPUtil.getNull(request.getParameter("f_ofc_vw_cd"));
        trdDir    = JSPUtil.getNull(request.getParameter("f_trd_dir"));
        obDivCd   = JSPUtil.getNull(request.getParameter("f_ob_div_cd"));
        f_click   = JSPUtil.getNull(request.getParameter("f_click"));

        if (ofcVwCd.equals("L")) {
            ofcVwNm = "Loading";
        } else if (ofcVwCd.equals("C")) {
            ofcVwNm = "Contract";
        }
        if (trdDir.equals("BH") || trdDir.equals("HH")){
            trdDirNm = trdDir.substring(0,1) +"/"+ trdDir.substring(1);
        } else {
            trdDirNm = trdDir;
        }
        if (obDivCd.equals("O")) {
            obDivNm = "O/B";
        } else if (obDivCd.equals("N")) {
            obDivNm = "N.O/B";
        } else {
            obDivNm = obDivCd;
        }
    }catch(Exception e) {
        out.println(e.toString());
    }
%>
<html>
<head>
<title>Portion Adjusted Figure Inquiry</title>
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

<body class="popup_bg" onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="f_bse_tp_cd" value="<%=bseTpCd%>">
<input type="hidden" name="f_ofc_vw_cd" value="<%=ofcVwCd%>">
<input type="hidden" name="f_ob_div_cd" value="<%=obDivCd%>">
<input type="hidden" name="f_trd_dir" value="<%=trdDir%>">
<input type="hidden" name="f_gubun" value="RHQ">

<!-- 개발자 작업 -->

<!-- Outer Table (S)-->
<table width="100%" class="popup" cellpadding="10" border="0">
<tr><td class="top"></td></tr>
    <tr>
        <td valign="top">
            <!-- : ( Title ) (S) -->
            <table width="100%" border="0">
                <tr>
                    <td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Portion Adjusted Figure Inquiry</td>
                </tr>
            </table>
            <!-- : ( Title ) (E) -->

           <!-- TABLE '#D' : ( Search Options ) (S) -->
            <table class="search" >
                <tr>
                    <td class="bg">
                        <table class="search">
                            <tr>
                                <td>
                                    <table class="search" border="0">
                                        <tr class="h23">
                                            <td width="50">Year</td>
                                            <td width="75"><input type="text" style="width:50;text-align:center;ime-mode: ime-mode:disabled" name="f_bse_yr" class="input2" maxlength="20" readOnly value="<%=bseYr%>"></td>
                                            <td width="65">Quarter</td>
                                            <td width="85"><input type="text" style="width:50;text-align:center;ime-mode: ime-mode:disabled" name="f_bse_qtr_cd" class="input2" maxlength="20" readOnly value="<%=bseQtrCd%>"></td>
                                            <td width="175" class='sm'><div id="div_period"><%=divPeriod%></div></td>
                                            <td width="80">Office View</td>
                                            <td width="95"><input type="text" style="width:70;text-align:center;ime-mode: ime-mode:disabled" name="f_ofc_vw_nm" class="input2" maxlength="20" readOnly value="<%=ofcVwNm%>"></td>
                                            <td width="65">N.OB/OB</td>
                                            <td><input type="text" style="width:50;text-align:center;ime-mode: ime-mode:disabled" name="f_ob_div_nm" class="input2" maxlength="20" readOnly value="<%=obDivNm%>"></td>
                                        </tr>
                                    </table>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <table class="search" border="0">
                                        <tr class="h23">
                                            <td width="50">Trade</td>
                                            <td width="75"><input type="text" style="width:50;text-align:center;ime-mode: ime-mode:disabled" name="f_trd_cd" class="input2" maxlength="20" readOnly value="<%=trdCd%>"></td>
                                            <td width="65">R/Lane</td>
                                            <td width="85"><input type="text" style="width:50;text-align:center;ime-mode: ime-mode:disabled" name="f_rlane_cd" class="input2" maxlength="20" readOnly value="<%=rlaneCd%>"></td>
                                            <td width="90"><div id="div_dir">Trade Bound</div></td>
                                            <td width="80"><div id="dir_cd"><input type="text" style="width:55;text-align:center;ime-mode: ime-mode:disabled" name="f_conv_dir_cd" class="input2" maxlength="20" readOnly value="<%=dirCd%>"></div>
                                            <div id="trd_dir" style="display:none;"><input type="text" style="width:55;text-align:center;ime-mode: ime-mode:disabled" name="f_trd_dir_nm" class="input2" maxlength="20" readOnly value="<%=trdDirNm%>"></div></td>
                                            <td width="20"><input type="checkbox" name="f_click" class="trans" <%=f_click.equals("on")? "checked":"" %>></td>
                                            <td>Trade Dir.</td>
                                        </tr>
                                    </table>
                                </td>
                            </tr>
                        </table>
                    </td>
                </tr>
            </table>
            <!-- TABLE '#D' : ( Search Options ) (E) -->
            <table class="height_10"><tr><td></td></tr></table>

            <!-- TABLE '#D' : ( Search Options ) (S) -->
            <table class="search" border="0">
                <tr>
                    <td class="bg_b1">
                        <table class="height_10"><tr><td></td></tr></table>
                        <table width="100%" class="search">
                        <tr><td class="gray" height="19" id="sheet_unit">[Unit: TEU, $]</td></tr>
                        </table>
                        <!-- : ( POR ) (S) -->
                        <table width="100%" id="mainTable">
                            <tr>
                                <td><script language="javascript">ComSheetObject('sheet1');</script></td>
                            </tr>
                        </table>
                        <!-- : ( POR ) (E) -->
                    </td>
                </tr>
            </table>
            <!-- TABLE '#D' : ( Search Options ) (E) -->
            <table class="height_5"><tr><td></td></tr></table>

            <!-- TABLE '#D' : ( Button : pop ) (S) -->
            <table width="100%" class="sbutton">
                <tr>
                    <td height="71" class="popup">
                        <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
                            <tr>
                                <td class="btn3_bg">
                                    <table border="0" cellpadding="0" cellspacing="0">
                                        <tr>
                                            <td>
                                                <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                                    <tr>
                                                        <td class="btn1_left"></td>
                                                        <td class="btn1" id="btn_DownExcel" name="btn_DownExcel">Down Excel</td>
                                                        <td class="btn1_right"></td>
                                                    </tr>
                                                </table>
                                            </td>
                                            <td>
                                                <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                                    <tr>
                                                        <td class="btn1_left"></td>
                                                        <td class="btn1" id="btn_close" name="btn_close">Close</td>
                                                        <td class="btn1_right"></td>
                                                    </tr>
                                                </table>
                                            </td>
                                            <!-- Repeat Pattern -->
                                        </tr>
                                    </table>
                                </td>
                            </tr>
                        </table>
                    </td>
                </tr>
            </table>
            <!-- TABLE '#D' : ( Button : pop ) (E) -->
        </td>
    </tr>
</table>
<!-- Outer Table (E)-->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>