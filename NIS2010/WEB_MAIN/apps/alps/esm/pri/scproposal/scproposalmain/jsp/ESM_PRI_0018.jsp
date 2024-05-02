<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_0018.jsp
*@FileTitle : S/C Proposal Creation - G/L Copy Option
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.19
*@LastModifier : 문동규
*@LastVersion : 1.0
* 2009.06.19 문동규
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
<%@ page import="com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.event.EsmPri0018Event"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.SpScpGlineCopyVO"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EsmPri0018Event  event = null;                  //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //서버에서 발생한 에러
    String strErrMsg = "";                      //에러메세지
    int rowCount     = 0;                       //DB ResultSet 리스트의 건수

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    Logger log = Logger.getLogger("com.hanjin.apps.SCProposal.SCProposalMain");
    
    String propNo = null;
    String amdtSeq = null;
    String scNo = null;
    String prcCustTpCd = null;
    String svcScpCd = null;
    String effDt = null;
    String expDt = null;
    String svcScpNm = null;

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();

        event = (EsmPri0018Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        SpScpGlineCopyVO vo = event.getSpScpGlineCopyVO();
        
        if (vo != null) {
            propNo = vo.getPropNo();
            amdtSeq = vo.getAmdtSeq();
            scNo = vo.getScNo();
            prcCustTpCd = vo.getPrcCustTpCd();
            svcScpCd = vo.getSvcScpCd();
            effDt = vo.getEffDt();
            expDt = vo.getExpDt();
        } else {
            propNo = "";
            amdtSeq = "";
            scNo = "";
            prcCustTpCd = "";
            svcScpCd = "";
            effDt = "";
            expDt = "";
        }

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

        svcScpNm = (String)eventResponse.getCustomData("svcScpNm");
    }catch(Exception e) {
        out.println(e.toString());
    }
%>
<html>
<head>
<title>S/C Proposal Creation - G/L Copy Option</title>
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
<input type="hidden" name="sc_no" value="<%=scNo %>">
<input type="hidden" name="prc_cust_tp_cd" value="<%=prcCustTpCd %>">
<input type="hidden" name="eff_dt" value="<%=effDt %>">
<input type="hidden" name="exp_dt" value="<%=expDt %>">
<input type="hidden" name="cmdt_tpw_mst">
<input type="hidden" name="cmdt_tpw_dtl">
<!-- 개발자 작업 -->

<!-- OUTER - POPUP (S)tart -->
<table width="500" class="popup" cellpadding="10" border="0">
<tr><td class="top"></td></tr>
<tr><td valign="top">

        <!-- : ( Title ) (S) -->
        <table width="100%" border="0">
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Guideline Copy </td></tr>
        </table>
        <!-- : ( Title ) (E) -->

        <!-- : ( Search Options ) (S) -->

            <table class="search" id="mainTable">
            <tr><td class="bg">
                <!--  biz_1  (S) -->

                <table class="search" border="0" style="width:484;">
                <tr class="h23">
                    <td width="80">Proposal No.</td>
                    <td width="" colspan="4"><input type="text" name="prop_no" style="width:96;" class="input2" value="<%=propNo %>" readonly></td></tr>
                <tr class="h23">
                    <td width="80">S/C No.</td>
                    <td width="105"><input type="text" name="sc_no_f" style="width:40;" class="input2" value="<%=(scNo.length() == 9)?scNo.substring(0,3):"" %>" readonly>&nbsp;<input type="text" name="sc_no_e" style="width:52;" class="input2" value="<%=(scNo.length() == 9)?scNo.substring(3):"" %>" readonly></td>
                    <td width="62">AMD No.</td>
                    <td width="237"><input type="text" name="amdt_seq" style="width:90;text-align:right;" class="input2" value="<%=amdtSeq %>" readonly></td>
                </tr>
                <tr class="h23">
                    <td width="80">SVC Scope</td>
                    <td width="404" colspan="6"><input type="text" name="svc_scp_cd" style="width:96;text-align:center" class="input2" value="<%=svcScpCd %>" readonly>&nbsp;<input type="text" name="svc_scp_nm" style="width:157;" class="input2" value="<%=svcScpNm %>"></td>
                </tr>
                </table>
                <table class="height_5"><tr><td></td></tr></table>
                <!--  biz_1   (E) -->

<table border="0" style="width:484;" class="search_sm2">
                <tr class="h23">
                    <td width="50%" class="sm" style="font-size:12;"><input type="checkbox" name="frm_loc_chk" value="Y" class="trans">Location Group</td>
                    <td width="50%" class="sm" style="font-size:12;"><input type="checkbox" name="frm_goh_chk" value="Y" class="trans">GOH</td>
                </tr>
                <tr class="h23">
                    <td width="50%" class="sm" style="font-size:12;"><input type="checkbox" name="frm_cmdt_chk" value="Y" class="trans">Commodity Group</td>
                    <td width="50%" class="sm" style="font-size:12;"><input type="checkbox" name="frm_rate_chk" value="Y" class="trans">Rate</td>
                </tr>
                <tr class="h23">
                    <td width="50%" class="sm" style="font-size:12;"><input type="checkbox" name="frm_cmdt_tpw_chk" value="Y" class="trans">Commodity(TPW) Group</td>
                    <td width="50%" class="sm" style="font-size:12;"><input type="checkbox" name="frm_note_chk" value="Y" class="trans">Standard Note</td>
                </tr>
                <tr class="h23">
                    <td width="50%" class="sm" style="font-size:12;"><input type="checkbox" name="frm_arb_org_chk" value="Y" class="trans">Origin Arbitrary</td>
                    <td width="50%" class="sm" style="font-size:12;">&nbsp;</td>
                </tr>
                <tr class="h23">
                    <td width="50%" class="sm" style="font-size:12;"><input type="checkbox" name="frm_arb_des_chk" value="Y" class="trans">Destination Arbitrary</td>
                    <td width="50%" class="sm" style="font-size:12;">

            <table width="100%" class="button">
                    <tr><td class="btn2_bg">
                        <table border="0" cellpadding="0" cellspacing="0"><tr>
                        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                            <tr><td class="btn2_left"></td>
                            <td class="btn2" name="btn_CheckAll">Check&nbsp;All</td>
                            <td class="btn2_right"></td>
                        <td>
                            <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                            <tr><td class="btn2_left"></td>
                            <td class="btn2" name="btn_UnCheckAll">UnCheck&nbsp;All</td>
                            <td class="btn2_right"></td>
                            </tr>
                            </table>

                        </td></tr>
                        </table>
            </td>
                </tr>
                </table>


            </td></tr>
        </table>

                <!-- : ( Grid ) (S) -->

                <!-- : ( Grid ) (E) -->
            <!-- : ( Button : Grid ) (E) -->

            </td></tr>
        </table>
<!-- : ( Search Options ) (E) -->
</td></tr>
</table>
            <table width="100%" style="display:inline;">
                <tr>
                    <td width="100%">
                        <script language="javascript">ComSheetObject('sheet1');</script>
                    </td>
                </tr>
            </table>
<table class="height_5"><tr><td></td></tr></table>

    </td></tr>
</table>
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

        <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
        <tr><td class="btn3_bg">
            <table border="0" cellpadding="0" cellspacing="0">
            <tr>
                <td width="72"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_OK">OK</td>
                    <td class="btn1_right"></td>
                    </tr></table>
                </td>
                <td width="72"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_Close">Close</td>
                    <td class="btn1_right"></td>
                    </tr></table>
                </td></tr>
        </table></td></tr>
        </table>

    </td></tr>
</table>
<!-- : ( Button : pop ) (E) -->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>