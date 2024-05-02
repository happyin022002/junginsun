<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_2043.jsp
*@FileTitle :  RFA List Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.20
*@LastVersion : 1.0
* 1.0 Creation
=========================================================
* History
* 2011.12.05 이석준 [CHM-201114806-01] Login Office가 XXXBA일경우 RFA No or Proposal No가 해당 BA것 일경우만 S/C Viewing이 가능하거나 조회 가능토록 수정  
* 2011.12.26 이석준 [CHM-201115205] RFA or Proposal 조회시 HAMRU 산하의 BA만 자신의 office만 조회 가능할 수 있도록 validation및 logic 수정
* 2013.12.20 서미진 [CHM-201328281] RFA에 계약 구분인자 추가 (C : Contract, S : Spot)
* 2014.01.22 서미진 [CHM-201428589] A/Customer 추가
* 2014.01.27 서미진 [CHM-201428677] Customer Name 조회 기능 추가
* 2016.05.03 RFA 효율화를 위한 요청 (1차) (CHM-201640671)
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.rfareport.rfareport.event.EsmPri2043Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.util.code.CodeInfo"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.common.PRIUtil"%>
<%@ page import="com.hanjin.framework.component.common.AbstractValueObject"%>
<%@ page import="java.util.List"%>

<%
    EsmPri2043Event  event = null;              //PDTO(Data Transfer Object including Parameters)
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
    String[] customerCodes = null;
    String[] customerTypes = null;
    String[] rfaCtrtTpCd = null;
    Logger log = Logger.getLogger("com.hanjin.apps.RFAReport.RFAReport");

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
        strUsr_ofc = account.getOfc_cd();
        strRhq_ofc = account.getRhq_ofc_cd();


        event = (EsmPri2043Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

        // Scope Combo Data 생성
        svcScpCds = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("svcScpCd"));
        // customerCode Combo Data 생성
        // customerCodes = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("customerCode"), true , "|", "\t", "getCode", "getName");
        // customerType Combo Data 생성
        customerTypes = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("customerType"), false , "|", "\t", "getCode", "getName");
        rfaCtrtTpCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("rfaCtrtTpList"), false ,"|","\t","getCode","getName");
    }catch(Exception e) {
        out.println(e.toString());
    }
%>
<html>
<head>
<title> RFA List Inquiry</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">

    var svcScpCdComboValue = "|<%=svcScpCds[0]%>";
    var svcScpCdComboText = "|<%=svcScpCds[1]%>";

    var customerTypeComboValue = "|<%=customerTypes[0]%>";
    var customerTypeComboText = "|<%=customerTypes[1]%>";

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

        <!--Button (S) -->
        <table width="100%" class="button" border="0" cellpadding="0"
            cellspacing="0" style="padding-top: 5;">
            <tr>
                <td class="btn1_bg">
            <table border="0" cellpadding="0" cellspacing="0">
            <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
                    <td class="btn1_right">
                </tr></table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_new">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
                <td class="btn1_line"></td>
            <td><table border="0" cellpadding="0" cellspacing="0">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_downexcel">Down Excel</td>
                    <td class="btn1_right">
                </tr></table></td>
            <td><table border="0" cellpadding="0" cellspacing="0">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_viewrfa">View RFA</td>
                    <td class="btn1_right">
                </tr></table></td>
            <td><table border="0" cellpadding="0" cellspacing="0">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_viewamdhistory">View AMD History</td>
                    <td class="btn1_right">
                </tr></table></td>
            </tr>
        </table></td>
            </tr>
        </table>
        <!--Button (E) -->

        <!--biz page - 1 (S)-->
        <table class="search" id="mainTable">
            <tr><td class="bg">

                <!--  biz  (S) -->
                <table class="search" border="0" style="width:100%;">
                <tr class="h23">
                    <td width="77">SVC Scope</td>
                    <td width="360"><script language="javascript">ComComboObject('svc_scp_cd', 2, 99, 0, 1, 0, false);</script>&nbsp;<input type="text" name="svc_scp_nm" style="width:224" class="input2" readonly></td>
                    <td class="search_sm2">
                        <table class="search_sm2" border="0" style="width:550;">
                        <tr class="h23">
                            <td width="110"><input type="radio" name="rdoDate" value="2" class="trans" checked>&nbsp;RFA EFF Date</td>
                            <td width="220">
                                <input type="text" class="input1" style="width:70;text-align:center;" caption="RFA Effective Date From" name="eff_date_from" cofield="eff_date_to" dataformat="ymd" maxLength="10" minlength="8"> <img class="cursor" name="btns_calendar1" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle">
                                ~
                                <input type="text" class="input1" style="width:70;text-align:center;" caption="RFA Effective Date To" name="eff_date_to" cofield="eff_date_from" dataformat="ymd" maxLength="10" minlength="8"> <img class="cursor" name="btns_calendar2" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle">
                            </td>
                            <td width="110"><input type="radio" name="rdoDate" value="1" class="trans">&nbsp;Access Date</td>
                            <td width=""><input type="text" style="width:70;text-align:center;" name="access_date" class="input" dataformat="ymd" maxLength="10" minlength="8" caption="Access Date"> <img src="img/btns_calendar.gif" class="cursor" name="btns_calendar3" width="19" height="20" border="0" align="absmiddle"></td>
                        </tr>
                        </table>

                    </td>
                </tr>
                </table>
                <table class="search" border="0" style="width:100%;">
                <tr class="h23">
                    <!-- td width="90">
                       <script language="javascript">ComComboObject('customer_code', 2, 85, 0, 0, 0, false);</script>
                    </td-->
                    <td width="75">Customer<input type="hidden" value="C" name="customer_code"></td>
                    <td width="360">
                       <input type="text" class="input" style="width:40;text-align:center;ime-mode:disabled;" dataformat="engup" maxlength="2" minlength="2" name="ctrt_cust_cnt_cd" caption="Customer Code"> <input type="text" class="input" style="width:55;text-align:center;ime-mode:disabled;" dataformat="int" name="ctrt_cust_seq" maxlength="6" caption="Customer Code">
                       <img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_ctrt_cust">
                       <input type="text" style="width:200;text-align:left;" class="input2"  name="ctrt_pty_nm"  readonly=true>
                    </td>
                   <td width="120">Customer Name</td>
                   <td width="160"><input type="text" name="cust_nm" style="width:140;text-align:left;ime-mode:disabled" class="input" dataformat="uppernum" maxLength="30"></td>  
                   <td width="125">Actual Customer</td>
                   <td><input type="text" name="act_cust_nm" style="width:140;text-align:left;ime-mode:disabled" class="input" dataformat="uppernum" maxLength="30"></td>    
                </tr>
                </table>
                
                <table class="search" border="0" style="width:100%;">
                <tr class="h23">
                	<td width="78">RFA No.</td>
                    <td width="110"><input type="text" class="input" style="width:95;text-align:center;ime-mode:disabled" name="rfa_no" dataformat="uppernum" maxLength="11"></td>
                   	<td width="100">Req. Office</td>
                   	<td width="100">
                       <nobr>
                       <input type="text" name="prop_scp_ofc_cd" style="width:70;text-align:center;ime-mode:disabled" class="input" dataformat="engup" maxLength="6"> <img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="ComOpenPopupWithTarget">
                       </nobr>
                   	</td>
                   	
                   	<!-- //RFA 효율화를 위한 요청 (1차) (CHM-201640671) -->
                   	<td width="90">Req. Staff</td>
                   	<td width="95"><script language="javascript">ComComboObject('prop_scp_ofc_srep_cd', 1, 90, 0, 0, 1);</script>
                   	<td width="2"></td>
                   	
                   	<td width="90">Sales Rep.</td>
                   	<td width="73"><input type="text" name="prop_scp_srep_cd" style="width:50;text-align:center;ime-mode:disabled" class="input" dataformat="uppernum" maxLength="5"></td>
                    <td width="115">Customer Type</td>
                    <td width="100"><script language="javascript">ComComboObject('prc_ctrt_cust_tp_cd', 1, 80, 0, 0, 1, false);</script></td>
                    <td width="75">RFA Type</td>
                    <td><script language="javascript">ComComboObject('rfa_ctrt_tp_cd', 1, 80, 0, 0, 1, false);</script></td>               
                </tr>
                </table>
                <!--  biz   (E) -->

            <table class="line_bluedot"><tr><td colspan="6"></td></tr></table>

            <!-- Grid  (S) -->
                <table width="100%" class="search"  id="mainTable">
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

<div style="display: none">
<script language="javascript">ComSheetObject('sheet2');</script>
</div>

</form>
</body>
</html>