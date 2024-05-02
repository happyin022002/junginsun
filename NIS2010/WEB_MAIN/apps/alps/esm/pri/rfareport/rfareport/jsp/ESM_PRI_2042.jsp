<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_2042.jsp
*@FileTitle : RFA Rate Search
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.22
*@LastModifier : 김대호
*@LastVersion : 1.0
* 2009.09.22 김대호
* 1.0 Creation
=========================================================
* History
* 2011.03.15 이행지 [CHM-201109281-01] ALPS의 Location 조회불가건 수정 보완 요청 - Location Code 중 숫자를 포함한 Code 를 조회, 입력 등 모든 부분에서 가능하도록 수정
* 2011.12.05 이석준 [CHM-201114806-01] Login Office가 XXXBA일경우 RFA No or Proposal No가 해당 BA것 일경우만 S/C Viewing이 가능하거나 조회 가능토록 수정  
* 2011.12.26 이석준 [CHM-201115205] RFA or Proposal 조회시 HAMRU 산하의 BA만 자신의 office만 조회 가능할 수 있도록 validation및 logic 수정
* 2013.12.20 서미진 [CHM-201328281] RFA에 계약 구분인자 추가 (C : Contract, S : Spot)
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.rfareport.rfareport.event.EsmPri2042Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.util.code.CodeInfo"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.common.PRIUtil"%>
<%@ page import="com.hanjin.framework.component.common.AbstractValueObject"%>
<%@ page import="java.util.List"%>

<%
    EsmPri2042Event  event = null;              //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //서버에서 발생한 에러
    String strErrMsg = "";                      //에러메세지
    int rowCount     = 0;                       //DB ResultSet 리스트의 건수

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    String strUsr_ofc       = "";
    String strRhq_ofc       = "";

    String[] svcScpCds = null;
    String[] charges = null;
    String[] tpSzs = null;
    String[] cargoTypes = null;
    String[] customerTypes = null;
    String[] rates = null;
    String[] rfaCtrtTpCd = null;

    Logger log = Logger.getLogger("com.hanjin.apps.RFAReport.RFAReport");

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
        strUsr_ofc = account.getOfc_cd();
        strRhq_ofc = account.getRhq_ofc_cd();


        event = (EsmPri2042Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

        // scope Combo Data 생성
        svcScpCds = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("svcScpCd"));
        // charges Combo Data 생성
        charges = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("charge"), false , "|", "\t", "getCode", "getName");
        // tp sz Combo Data 생성
        tpSzs = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("tpSz"), false);
        // cargo type Combo Data 생성
        cargoTypes = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("cargoType"), true , "|", "\t", "getCode", "getName");
        // customer type Combo Data 생성
        customerTypes = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("customerType"), false , "|", "\t", "getCode", "getName");
        // rate, mqc Combo Data 생성
        rates = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("rate"), false , "|", "\t", "getCode", "getName");
	    // RFA Type
        rfaCtrtTpCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("rfaCtrtTpList"), false ,"|","\t","getCode","getName");
    }catch(Exception e) {
        out.println(e.toString());
    }
%>
<html>
<head>
<title>RFA Rate Search</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">

    var svcScpCdComboValue = "|<%=svcScpCds[0]%>";
    var svcScpCdComboText = "|<%=svcScpCds[1]%>";

    var chargeComboValue = "|<%=charges[0]%>";
    var chargeComboText = "|<%=charges[1]%>";

    var tpSzComboValue = "|<%=tpSzs[0]%>";
    var tpSzComboText = "|<%=tpSzs[1]%>";

    var cargoTypeComboValue = "|<%=cargoTypes[0]%>";
    var cargoTypeComboText = "|<%=cargoTypes[1]%>";

    var customerTypeComboValue = "|<%=customerTypes[0]%>";
    var customerTypeComboText = "|<%=customerTypes[1]%>";

    var rateComboValue = "|<%=rates[0]%>";

    var rfaCtrtTpCdValue = "|<%=rfaCtrtTpCd[0]%>";
    var rfaCtrtTpCdText = "|<%=rfaCtrtTpCd[1]%>"; 

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
<!--  Office Code Validation 체크를 위한 정의 -->
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="cd">
<input type="hidden" name="in_usr_ofc_cd" value="<%=strUsr_ofc%>">
<input type="hidden" name="in_rhq_ofc_cd" value="<%=strRhq_ofc%>">
<input type="hidden" name="backendjob_key">
<!--  Office Code Validation 체크를 위한 정의 -->
<input type="hidden" name ="ofc_cd" value="">
<!-- Form Hidden -->
<input type="hidden" name ="etc1" value="">
<input type="hidden" id="searchParam" name="eff_dt">
<input type="hidden" id="searchParam" name="exp_dt">


<!-- OUTER - POPUP (S)tart -->
<table width="100%" border="0" cellpadding="0" cellspacing="0"
    style="padding-top: 2; padding-left: 5;">
    <tr>
        <td valign="top"><!--Page Title, Historical (S)-->
        <table width="100%" border="0" cellpadding="0" cellspacing="0"
            class="title">
            <tr>
                <td class="history"><img src="img/icon_history_dot.gif"
                    align="absmiddle"><span id="navigation"></span></td>
            </tr>
            <tr>
                <td class="title"><img src="img/icon_title_dot.gif"
                    align="absmiddle"><span id="title"></span></td>
            </tr>
        </table>
        <!--Page Title, Historical (E)-->

        <!--biz page - 1 (S)-->
        <table class="search" id="mainTable">
            <tr><td class="bg">

                <!--  biz  (S) -->
                <table class="search" border="0" style="width:979;">
                <tr class="h23">
                    <td width="70">SVC Scope</td>
                    <td width="320"><script language="javascript">ComComboObject('svc_scp_cd', 2, 96, 0, 1, 0, false);</script>&nbsp;<input type="text" name="svc_scp_nm" style="width:206;" class="input2" readonly></td>
                    <td width="">

                    <table class="search_sm2" border="0" style="width:100%;">
                    <tr class="h23">
                    <td width="110"><input type="radio" name="rdoDate" value="2" class="trans" checked>&nbsp;RFA EFF Date</td>
                    <td width="250">
                       <input type="text" style="width:75;text-align:center;" class="input1" caption="RFA EFF Date From" name="eff_date_from" cofield="eff_date_to" dataformat="ymd" maxLength="10" minlength="8"> <img class="cursor" name="btns_calendar1" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle">
                       ~
                       <input type="text" style="width:75;text-align:center;" class="input1" caption="RFA EFF Date To" name="eff_date_to" cofield="eff_date_from" dataformat="ymd" maxLength="10" minlength="8"> <img class="cursor" name="btns_calendar2" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle">
                    </td>
                    <td width="105"><input type="radio" name="rdoDate" value="1" class="trans">&nbsp;Access Date</td>
                    <td width=""><input type="text" style="width:70;text-align:center;" name="access_date" class="input" dataformat="ymd" maxLength="10" minlength="8" caption="Access Date"> <img src="img/btns_calendar.gif" class="cursor" name="btns_calendar3" width="19" height="20" border="0" align="absmiddle"></td>
                    </tr>
                    </table>

                </td></tr>
                </table>
                <table class="search" border="0" style="width:979;">
                <tr class="h23">
                    <td width="68">Origin</td> <!-- 2011.03.15 이행지 [CHM-201109281-01] ALPS의 Location 조회불가건 수정 보완 요청 - Location Code 영문대문자,숫자 입력가능하도록 수정  dataformat ( engup -> uppernum )-->
                    <td width="75"><input type="text" name="rout_pnt_loc_def_cd_ori" style="width:50;text-align:center;ime-mode:disabled" class="input" dataformat="uppernum" maxLength="5"></td>
                    <td width="60">Origin Via</td>
                    <td width="70"><input type="text" name="rout_via_port_def_cd_ori" style="width:47;text-align:center;ime-mode:disabled" class="input" dataformat="uppernum" maxLength="5"></td>
                    <td width="51">Dest Via</td>
                    <td width="83"><input type="text" name="rout_via_port_def_cd_dest" style="width:50;text-align:center;ime-mode:disabled" class="input" dataformat="uppernum" maxLength="5"></td>
                    <td width="60">Destinaion</td>
                    <td width="119"><input type="text" name="rout_pnt_loc_def_cd_dest" style="width:50;text-align:center;ime-mode:disabled" class="input" dataformat="uppernum" maxLength="5"></td>
                    <td width="45">Charge</td>
                    <td width="80"><script language="javascript">ComComboObject('chg_cd', 1, 60, 0, 0, 0, false);</script></td>
                    <td width="40">TP/SZ</td>
                    <td width="80"><script language="javascript">ComComboObject('rat_ut_cd', 2, 60, 0, 0, 0, false);</script></td>
                    <td width="70">Cargo Type</td>
                    <td width=""><script language="javascript">ComComboObject('prc_cgo_tp_cd', 2, 53, 0, 0, 0, false);</script></td>
                </tr>
                </table>
                <table class="search" border="0" style="width:979;">
                <tr class="h23">
                    <td width="68">RFA No.</td>
                    <td width="108"><input type="text" name="rfa_no" style="width:96;text-align:center;ime-mode:disabled" class="input" dataformat="uppernum" maxLength="11"></td>
                    <td width="105">Actual Customer</td>
                    <td width="126"><input type="text" name="cust_cnt_cd" style="width:30;ime-mode:disabled;text-align:center" class="input" dataformat="engup" maxlength="2" minlength="2"><input type="text" name="cust_seq" style="width:50;ime-mode:disabled;text-align:center" class="input" dataformat="number" maxlength="6"><img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_cust"></td>
                    <td width="65">Customer</td>
                    <td width="119"><input type="text" name="ctrt_cust_cnt_cd" style="width:30;ime-mode:disabled;text-align:center" class="input" dataformat="engup" maxlength="2" minlength="2"><input type="text" name="ctrt_cust_seq" style="width:50;ime-mode:disabled;text-align:center" class="input" dataformat="number" maxlength="6"><img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_ctrt_cust"></td>
                    <td width="94">Customer Type</td>
                    <td width="97"><script language="javascript">ComComboObject('prc_ctrt_cust_tp_cd', 1, 70, 0, 0, 1, false);</script></td>
                    <td width="75">Commodity</td>
                    <td width=""><input type="text" style="width:75;text-align:center;ime-mode:disabled" class="input" name="prc_cmdt_def_cd" dataformat="number" maxLength="6"> <img class="cursor" src="img/btns_search.gif" name="btn_commodity" width="19" height="20" border="0" align="absmiddle"></td>
                </tr>
                </table>
                <table class="search" border="0" style="width:979;">
                <tr class="h23">
                    <td width="70">Rate</td>
                    <td width="106"><script language="javascript">ComComboObject('fnl_frt_rt', 1, 40, 0, 0, 0, false);</script>&nbsp;<input type="text" style="width:52;text-align:right;ime-mode:disabled" class="input" name="fnl_frt_rt_amt" dataformat="int" maxLength="6"></td>
                    <td width="107">Target MVC</td>
                    <td width="123"><script language="javascript">ComComboObject('fnl_mqc', 1, 40, 0, 0, 0, false);</script>&nbsp;<input type="text" style="width:50;text-align:right;ime-mode:disabled" class="input" name="fnl_mqc_qty" dataformat="int" maxLength="6"></td>
                    <td width="90">Request Office</td>
                    <td width="95"><input type="text" style="width:50;text-align:center;ime-mode:disabled" class="input" name="prop_scp_ofc_cd" dataformat="engup" maxLength="6"> <img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" id="btn_popup1" name="ComOpenPopupWithTarget"></td>
                    <td width="92">Sales Rep</td>
                    <!-- td width=""><script language="javascript">ComComboObject('prop_scp_srep_cd', 2, 71, 0, 0, 0, false);</script>&nbsp;<input type="text" name="prop_scp_srep_nm" style="width:250;" class="input2" readonly></td-->
                    <td width="99"><input type="text" name="prop_scp_srep_cd" style="width:70;text-align:center;ime-mode:disabled" class="input" dataformat="uppernum" maxLength="5"></td>
                    <td width="77">RFA Type</td>
                    <td width=""><script language="javascript">ComComboObject('rfa_ctrt_tp_cd', 1, 97, 0, 0, 1, false);</script></td>
                </tr>
                </table>
                <table class="search" border="0" style="width:100%;">
                <tr class="h23">
                    <td width="100%" style="padding-top:5">
                        <table border="0" style="width:580;" class="search_sm2">
                        <tr class="h23">
                            <td width="120">Additional Option</td>
                            <td class="stm">
                                <!-- input type="checkbox" class="trans" name="chkDisplay" value="_tri" checked>Tariff Rate Item (TRI)&nbsp;&nbsp;-->
                                <input type="checkbox" class="trans" name="chkDisplay" value="rcv_de_term_cd">Receiving/Delivering Term
                                <input type="checkbox" name="previous_rate" value="N" class="trans">Previous Rate</td></tr>
                        </table>
                    </td>
                </tr>
                </table>
                <!--  biz   (E) -->

            <table class="line_bluedot"><tr><td colspan="6"></td></tr></table>

            <!-- Grid  (S) -->

                <table width="100%"  id="mainTable">
                    <tr>
                        <td width="100%">
                            <script language="javascript">ComSheetObject('sheet1');</script>
                        </td>
                    </tr>
                </table>

            <!-- Grid (E) -->

            </td></tr>
        </table>
        <!--biz page - 2 (E)-->

</td></tr></table>

<!-- : ( Button : pop ) (S) -->

        <!--Button (S) -->
        <table width="100%" class="button" border="0" cellpadding="0"
            cellspacing="0" style="padding-top: 5; , padding-bottom: 10;">
            <tr>
                <td class="btn1_bg">
            <table border="0" cellpadding="0" cellspacing="0">
            <tr>
            <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
                    <td class="btn1_right">
                </tr></table></td>
            <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_new">New</td>
                    <td class="btn1_right"></td>
                </tr></table></td>
            <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_downexcel">Down Excel</td>
                    <td class="btn1_right">
                </tr></table></td>
            <td class="btn1_line"></td>
            <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_viewrfa">View RFA</td>
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

<div style="display: none">
<script language="javascript">ComSheetObject('sheet2');</script>
</div>

</form>
</body>
</html>