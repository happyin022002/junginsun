<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_0105.jsp
*@FileTitle : Rate Guideline Inquiry - Route Note
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.30
*@LastModifier : 박성수
*@LastVersion : 1.0
* 2009.09.30 박성수
* 1.0 Creation
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.scguideline.scrateguideline.event.EsmPri0105Event"%>
<%@ page import="com.hanjin.framework.component.util.code.CodeInfo"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>
<%@ page import="com.hanjin.syscommon.common.table.PriSgRtCmdtRnoteVO"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EsmPri0105Event  event = null;                  //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //서버에서 발생한 에러
    String strErrMsg = "";                      //에러메세지
    int rowCount     = 0;                       //DB ResultSet 리스트의 건수

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";

    String svcScpCd    = null;
    String glineSeq    = null;
    String prcCustTpCd = null;
    String cmdtHdrSeq  = null;
    String routSeq     = null;

    StringBuffer itemComboText = new StringBuffer();
    StringBuffer itemComboValue = new StringBuffer();
    StringBuffer scgComboText = new StringBuffer();
    StringBuffer scgComboValue = new StringBuffer();
    Logger log = Logger.getLogger("com.hanjin.apps.SCGuideline.SCRateGuideline");

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();

        event = (EsmPri0105Event)request.getAttribute("Event");

        PriSgRtCmdtRnoteVO vo = event.getPriSgRtCmdtRnoteVO();

        if (vo != null) {
            svcScpCd    = vo.getSvcScpCd();
            glineSeq    = vo.getGlineSeq();
            prcCustTpCd = vo.getPrcCustTpCd();
            cmdtHdrSeq  = vo.getCmdtHdrSeq();
            routSeq     = vo.getRoutSeq();
        } else {
            svcScpCd    = "";
            glineSeq    = "";
            prcCustTpCd = "";
            cmdtHdrSeq  = "";
            routSeq     = "";
        }

        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

        List<CodeInfo> item = (List<CodeInfo>)eventResponse.getCustomData("item");

        // Item Combo Data 생성
        if (item != null && item.size() > 0) {
            int dataCount = item.size();
            CodeInfo[] vos = new CodeInfo[dataCount];
            item.toArray(vos);
            itemComboText.append(" |");
            itemComboValue.append(" |");
            for (int i = 0; i < dataCount; i++) {
                if (i != 0) {
                    itemComboText.append("|");
                    itemComboValue.append("|");
                }
                //itemComboText.append(vos[i].getCode()).append("\t").append(vos[i].getName());
                itemComboText.append(vos[i].getName());
                itemComboValue.append(vos[i].getCode());
            }
        }

        List<RsltCdListVO> surcharge = (List<RsltCdListVO>)eventResponse.getCustomData("surcharge");

        // Surcharge Combo Data 생성
        if (surcharge != null && surcharge.size() > 0) {
            int dataCount = surcharge.size();
            RsltCdListVO[] vos = new RsltCdListVO[dataCount];
            surcharge.toArray(vos);
            scgComboText.append(" \t |");
            scgComboValue.append(" |");
            for (int i = 0; i < dataCount; i++) {
                if (i != 0) {
                    scgComboText.append("|");
                    scgComboValue.append("|");
                }
                scgComboText.append(vos[i].getNm());
                scgComboValue.append(vos[i].getCd());
            }
        }
    }catch(Exception e) {
        out.println(e.toString());
    }
%>
<html>
<head>
<title>Rate Guideline Inquiry - Route Note</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
    var itemComboText = "<%=itemComboText.toString()%>";
    var itemComboValue = "<%=itemComboValue.toString()%>";
    var scgComboText = "<%=scgComboText.toString()%>";
    var scgComboValue = "<%=scgComboValue.toString()%>";

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

<input type="hidden" name="svc_scp_cd"     value="<%=svcScpCd    %>">
<input type="hidden" name="gline_seq"      value="<%=glineSeq    %>">
<input type="hidden" name="prc_cust_tp_cd" value="<%=prcCustTpCd %>">
<input type="hidden" name="cmdt_hdr_seq"   value="<%=cmdtHdrSeq  %>">
<input type="hidden" name="rout_seq"       value="<%=routSeq     %>">

<!-- 개발자 작업 -->

<!-- OUTER - POPUP (S)tart -->
<table width="600" class="popup" cellpadding="10" border="0">
<tr><td class="top"></td></tr>
<tr><td valign="top">

        <!-- : ( Title ) (S) -->
        <table width="100%" border="0">
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Rate Guideline Inquiry - Route Note</td></tr>
        </table>
        <!-- : ( Title ) (E) -->

        <!-- 1 (S) -->
        <table class="search" id="mainTable">
        <tr><td class="bg">

            <!-- Grid -  (S) -->
                            <table width="100%"  id="mainTable">
                                <tr>
                                    <td width="100%">
                                        <script language="javascript">ComSheetObject('sheet1');</script>
                                    </td>
                                </tr>
                            </table>
            <!-- Grid - (E) -->

        </td></tr>
        </table>
        <!-- 1 (E) -->

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
                <td><table width="72 border="0" cellpadding="0" cellspacing="0" class="button">
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