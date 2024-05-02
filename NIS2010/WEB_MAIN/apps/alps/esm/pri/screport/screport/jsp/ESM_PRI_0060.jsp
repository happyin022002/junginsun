<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_0060.jsp
*@FileTitle : Rate Search
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.09
*@LastModifier : 김대호
*@LastVersion : 1.0
* 2009.09.09 김대호
* 1.0 Creation
=========================================================
* History
* 2011.03.15 이행지 [CHM-201109281-01] ALPS의 Location 조회불가건 수정 보완 요청 - Location Code 중 숫자를 포함한 Code 를 조회, 입력 등 모든 부분에서 가능하도록 수정
* 2011.11.02 이석준 [CHM-201114235-01] OFT,BUC,PSC SURCHARGE에 대한 컬럼 추가
* 2011.11.18 서미진 [CHM-201114462] SC No. 를 한칸으로 변경하여 copy & paste 기능 이용 할 수 있도록 정정요청
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.screport.screport.event.EsmPri0060Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.util.code.CodeInfo"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.common.PRIUtil"%>
<%@ page import="com.hanjin.framework.component.common.AbstractValueObject"%>
<%@ page import="java.util.List"%>

<%
    EsmPri0060Event  event = null;              //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //서버에서 발생한 에러
    String strErrMsg = "";                      //에러메세지
    int rowCount     = 0;                       //DB ResultSet 리스트의 건수
    
    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    
    String[] charges = null;
    String[] customerTypes = null;
    String[] tpSzs = null;
    String[] cargoTypes = null;
    String[] rates = null;
    String[] svcScpCds = null;
    String[] rateTypes = null;
    
    Logger log = Logger.getLogger("com.hanjin.apps.SCReport.SCReport");
    
    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
       
       
        event = (EsmPri0060Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
        
        // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        
        // charges Combo Data 생성
        charges = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("charge"), false , "|", "\t", "getCode", "getName");
        // customer type Combo Data 생성
        customerTypes = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("customerType"), true , "|", "\t", "getCode", "getName");
        // tp sz Combo Data 생성
        tpSzs = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("tpSz"), false);
        // cargo type Combo Data 생성
        cargoTypes = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("cargoType"), true , "|", "\t", "getCode", "getName");
        // rate, mqc Combo Data 생성
        rates = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("rate"), false , "|", "\t", "getCode", "getName");
        // scope Combo Data 생성
        svcScpCds = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("svcScpCd"));
        // rate type Combo Data 생성
        rateTypes = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("rateType"), true , "|", "\t", "getCode", "getName");
        
    }catch(Exception e) {
        out.println(e.toString());
    }
%>
<html>
<head>
<title>Rate Search</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">

    var chargeComboValue = "<%=charges[0]%>";
    var chargeComboText = "<%=charges[1]%>";

    var customerTypeComboValue = "|<%=customerTypes[0]%>";
    var customerTypeComboText = "|<%=customerTypes[1]%>";

    var tpSzComboValue = "<%=tpSzs[0]%>";
    var tpSzComboText = "<%=tpSzs[1]%>";

    var cargoTypeComboValue = "<%=cargoTypes[0]%>";
    var cargoTypeComboText = "<%=cargoTypes[1]%>";

    var rateComboValue = "|<%=rates[0]%>";

    var svcScpCdComboValue = "|<%=svcScpCds[0]%>";
    var svcScpCdComboText = "|<%=svcScpCds[1]%>";

    var  rateTypeComboValue = "<%=rateTypes[0]%>";
    var  rateTypeComboText = "<%=rateTypes[1]%>";

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
<input type="hidden" name="cd">
<input type="hidden" name="backendjob_key">
<input type="hidden" name="job_status">
<!--  Office Code Validation 체크를 위한 정의 -->
<input type="hidden" name ="ofc_cd" value="">
 <!--Form Hidden -->
<input type="hidden" name ="etc1" value="">
<input type="hidden" id="searchParam" name="cmdt_nm">
<input type="hidden" id="searchParam" name="act_cust_nm">
<!--<input type="hidden" id="searchParam" name="chg_cd_txt">-->

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">

    <tr><td valign="top">
    
        <!--Page Title, Historical (S)-->
        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
            <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
            <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
        </table>
        <!--Page Title, Historical (E)--> 
        <!--Button (S) -->
        <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0; padding-bottom:2;"> 
        <tr><td class="btn1_bg">
            <table border="0" cellpadding="0" cellspacing="0">
            <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
                <td class="btn1_line"></td>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_downexcel">Down Excel</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_gotosc">Go to S/C</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
            </tr>
            </table>
        </td></tr>
        </table>
        <!--Button (E) -->
        <!-- 1 (S) -->
        <table class="search" id="mainTable"> 
            <tr><td class="bg">
                <!--  biz_1  (S) -->
                <table class="search" border="0" style="width:979;"> 
                <tr class="h23">
                    <td width="50">Charge</td>
                    <td width="130"><script language="javascript">ComComboObject('chg_cd', 1, 120, 0, 1, 0, false);</script></td>
                    <td width="82">S/C EFF Date</td>
                    <td width="245">
                       <input type="text" style="width:75;text-align:center;" class="input1" name="eff_dt" caption="S/C EFF Date From" cofield="exp_dt" dataformat="ymd" maxLength="10" minlength="8">
                       <img class="cursor" src="img/btns_calendar.gif" name="btns_calendar1" width="19" height="20" border="0" align="absmiddle">&nbsp;~&nbsp;
                       <input type="text" style="width:75;text-align:center;" class="input" name="exp_dt" caption="S/C EFF Date To" cofield="eff_dt" dataformat="ymd" maxLength="10" minlength="8">
                       <img class="cursor" src="img/btns_calendar.gif" name="btns_calendar2" width="19" height="20" border="0" align="absmiddle">
                    </td>
                    <td width="35"><nobr>Origin</nobr></td>
                    <td width="60"><input type="text" name="rout_pnt_loc_def_cd_ori" style="width:50;text-align:center;ime-mode:disabled" class="input1" dataformat="uppernum" maxLength="5"></td>
                    <td width="70"><nobr>Destination</nobr></td>
                    <td width="60"><input type="text" name="rout_pnt_loc_def_cd_dest" style="width:45;text-align:center;ime-mode:disabled" class="input1" dataformat="uppernum" maxLength="5"></td>
                    <td width="72"><nobr>Origin Via</nobr></td>
                    <td width="66"><input type="text" name="rout_via_port_def_cd_ori" style="width:52;text-align:center;ime-mode:disabled" class="input" dataformat="uppernum" maxLength="5"></td>
                    <td width="55"><nobr>Dest Via</nobr></td>
                    <td width=""><input type="text" name="rout_via_port_def_cd_dest" style="width:50;text-align:center;ime-mode:disabled" class="input" dataformat="uppernum" maxLength="5"></td>
                </tr> 
                </table>    
                
                <table class="search" border="0" style="width:979;"> 
                <tr class="h23">
                    <td width="109">Customer Type</td>
                    <td width="71"><script language="javascript">ComComboObject('prc_ctrt_cust_tp_cd', 2, 37, 0, 0, 0, false);</script></td>
                    <td width="82">Commodity</td>
                    <td width="122"><input type="text" style="width:75;text-align:center;ime-mode:disabled" class="input" name="prc_cmdt_def_cd" dataformat="number" maxLength="6">&nbsp;<img class="cursor" src="img/btns_search.gif" name="btn_commodity" width="19" height="20" border="0" align="absmiddle"></td>
                    
                    <td width="48">TP/SZ</td>
                    <td width="75"><script language="javascript">ComComboObject('rat_ut_cd', 2, 50, 0, 0, 0, false);</script></td>
                    <td width="70">Cargo Type</td>
                    <td width="157"><script language="javascript">ComComboObject('prc_cgo_tp_cd', 2, 47, 0, 0, 0, false);</script></td>
                    <td width="30">Rate</td>
                    <td width="">
                       <script language="javascript">ComComboObject('fnl_frt_rt', 1, 40, 0, 0, 0, false);</script>&nbsp;<input type="text" style="width:52;text-align:right;ime-mode:disabled" class="input" name="fnl_frt_rt_amt" dataformat="int" maxLength="6">
                    </td>
                </tr> 
                </table>
                    
                <table class="search" border="0" style="width:979;"> 
                <tr class="h23">
                    <td width="50">S/C No.</td>
                    <td width="130"><input type="text" style="width:117; text-align: center;" name="sc_no" maxlength="9" class="input" dataformat="uppernum"></td>
                    <td width="84">SVC Scope</td>
                    <td width="100"><script language="javascript">ComComboObject('svc_scp_cd', 2, 50, 0, 0, 0, false);</script></td>
                    <td width="68">Rate Type</td>
                    <td width="75"><script language="javascript">ComComboObject('gen_spcl_rt_tp_cd', 2, 50, 0, 0, 0, false);</script></td>
                    <td width="115">Commodity Group</td>
                    <td width="113"><script language="javascript">ComComboObject('cmdt_hdr_seq', 1, 100, 0, 0, 0, false);</script></td>
                    <td width="105"><nobr>Actual Customer</nobr></td>
                    <td width=""><script language="javascript">ComComboObject('act_cust_cd', 1, 138, 0, 0, 0, false);</script></td>
                </tr> 
                </table>        
                <table class="search" border="0" style="width:979;"> 
                <tr class="h23">
                    <td width="50">MQC</td>
                    <td width="130">
                        <script language="javascript">ComComboObject('fnl_mqc', 1, 40, 0, 0, 0, false);</script>&nbsp;<input type="text" style="width:74;text-align:right;ime-mode:disabled" class="input" name="fnl_mqc_qty" dataformat="int" maxLength="6">
                    </td>
                    <td width="82">Request OFC</td>
                    <td width="102"><input type="text" style="width:65;text-align:center;ime-mode:disabled" class="input" name="prop_scp_ofc_cd" dataformat="engup" maxLength="6">&nbsp;<img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" id="btn_popup1" name="ComOpenPopupWithTarget"></td>
                    <td width="40">S. Rep</td>
                    <td width="" style="padding-left:2"><script language="javascript">ComComboObject('prop_scp_srep_cd', 2, 76, 0, 0, 0, false);</script>&nbsp;<input type="text" name="prop_scp_srep_nm" style="width:236;" class="input2" readonly></td>
                </tr> 
                </table>                        
                <!--  biz_1   (E) -->
            
                <table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
                
                <!-- Grid (S) -->
                <table width="100%"  id="mainTable"> 
                    <tr>
                        <td width="100%">
                            <script language="javascript">ComSheetObject('sheet1');</script>
                        </td>
                    </tr>
                </table>        
                <!-- Grid (E) -->           
            
            
            
        </td></tr></table>
        <!-- 1 (E) -->  
        
        <!--biz page (E)-->
            
    <table class="height_10"><tr><td></td></tr></table>
    
</td></tr>
</table>

<div style="display: none">
<script language="javascript">ComSheetObject('sheet2');</script>
<script language="javascript">ComSheetObject('sheet3');</script>
</div>

</form>
</body>
</html>