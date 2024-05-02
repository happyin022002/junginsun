<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_0015.jsp
*@FileTitle : S/C Master Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.07
*@LastModifier : 문동규
*@LastVersion : 1.0
* 2009.07.07 문동규
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
<%@ page import="com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.event.EsmPri0015Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.util.code.CodeInfo"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.common.PRIUtil"%>
<%@ page import="com.hanjin.framework.component.common.AbstractValueObject"%>
<%@ page import="java.util.List"%>

<%
    EsmPri0015Event  event = null;                  //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //서버에서 발생한 에러
    String strErrMsg = "";                      //에러메세지
    int rowCount     = 0;                       //DB ResultSet 리스트의 건수

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    String strUsr_ofc       = "";
    String[] svcScpCds = null;
    String[] appOfcCds = null;
    String[] custTpCds = null;
    String[] lodUtCds = null;
    Logger log = Logger.getLogger("com.hanjin.apps.SCProposal.SCProposalMain");

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
        strUsr_ofc = account.getOfc_cd();

        event = (EsmPri0015Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        // Service Scope Combo Data 생성
        svcScpCds = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("svcScpCd"));
        // Approval Office Combo Data 생성
        appOfcCds = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("appOfcCd"));
        // Customer Type Combo Data 생성
        custTpCds = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("custTpCd"),true ,"|","\t","getCode","getName");
        // Container Load Unit Combo Data 생성
        lodUtCds = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("lodUtCd"), false,"|","\t","getCode","getName");

    }catch(Exception e) {
        out.println(e.toString());
    }
%>
<html>
<head>
<title>S/C Master Creation</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
    var svcScpComboValue = " |<%=svcScpCds[0]%>";
    var svcScpComboText = " |<%=svcScpCds[1]%>";

    var appOfcComboValue = "<%=appOfcCds[0]%>";
    var appOfcComboText = "<%=appOfcCds[1]%>";
        
    var custTpComboValue = "<%=custTpCds[0]%>";   
    var custTpComboText = "<%=custTpCds[1]%>";

    var lodUtComboValue = "<%=lodUtCds[0]%>";   
    var lodUtComboText = "<%=lodUtCds[1]%>";
    
    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            showErrMessage(errMessage);
        } // end if
        loadPage();
    }
</script>
</head>

<body onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="prop_no">
<input type="hidden" name="amdt_seq">
<input type="hidden" name="in_usr_ofc_cd" value="<%=strUsr_ofc%>">
<input type="hidden" name="in_usr_srep_cd" value="<%=strUsr_id%>">
<input type="hidden" name="in_usr_nm" value="<%=strUsr_nm%>">
<input type="hidden" name="is_goto_prop">
<!-- 개발자 작업    -->
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
    <!-- Hidden sheet for Transaction (S) -->
    <script language="javascript">ComSheetObject('sheet1');</script>
    <!-- Hidden sheet for Transaction (E) -->
        <table class="search">
        <tr><td class="bg">
                <!--  biz_1  (S) -->
                <table class="search" border="0" style="width:979;">
                <tr class="h23">
                    <td width="97">S/C  No.</td>
                    <td width="150"><input type="text" caption="S/C Number" style="width:104;ime-mode:disabled;" name="sc_no" dataformat="engup" maxlength="20" class="input1" required></td>

                    <td width="65">Duration</td>
                    <td width="400"><input type="text" caption="Duration" name="ctrt_eff_dt" cofield="ctrt_exp_dt" maxlength="10" dataformat="ymd" style="width:70;" readonly="readonly" class="input1" required>&nbsp;<img src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" name="btns_calendar1" class="cursor">&nbsp;&nbsp;~&nbsp;&nbsp;<input type="text" caption="Duration" name="ctrt_exp_dt" cofield="ctrt_eff_dt" maxlength="10" dataformat="ymd" style="width:70;" readonly="readonly" class="input1" required>&nbsp;<img src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" name="btns_calendar2" class="cursor"></td>
                    <td width="97">Status</td>
                    <td width=""><input type="text" style="width:68;" name="prc_mst_prop_tp_nm" value="" readonly="readonly" class="input2" >&nbsp;<input type="text" style="width:73;display:none;" name="prop_sts" readonly="readonly" class="input2" ></td>
                </tr>
				</table>
				<table class="search" border="0" style="width:979;">
                <tr class="h23">
                    <td width="97">Request Office</td>
                    <td width="150"><input type="text" style="width:104;" name="prop_ofc_cd"  dataformat="engup" readonly="readonly" class="input1" caption="Request Office Code" required></td>
                    <td width="65">Sales Rep.</td>
                    <td width="400" style="padding-left:2;"><script language="javascript">ComComboObject('prop_srep_cd', 2, 92, 0, 1);</script>&nbsp;<input type="text" style="width:115;" name="prop_srep_nm" readonly="readonly" class="input2" ></td>
                  	<td width="97">Approval Office</td>
                    <td style="padding-left:0;"><script language="javascript">ComComboObject('prop_apro_ofc_cd', 2, 68, 0, 1);</script></td>
                    
                    
                </tr>
                </table>
                <table class="search" border="0" style="width:979;">
                <tr class="h23">
                    <td width="97">Customer</td>
                    <td width="106"><input type="text" style="width:25;" dataformat="engup" maxlength="2" minlength="2" name="cust_cnt_cd" readonly="readonly" class="input1" caption="Customer Code" required/>&nbsp;<input type="text" style="width:50;" dataformat="int" name="cust_seq" maxlength="6" readonly="readonly" class="input1" caption="Customer Code" required/>&nbsp;<img src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" name="btn_ctrt_cust" class="cursor"/></td>
                    <td width="280"><input type="text" style="width:279;" name="ctrt_pty_nm"  readonly="readonly" class="input2"/></td>
                    <td width="">&nbsp;<script language="javascript">ComComboObject('prc_ctrt_cust_tp_cd', 2, 37, 0, 1);
                    </script>&nbsp;<input type="text" style="width:56;" name="ctrt_cust_val_sgm" readonly="readonly" class="input2"/>&nbsp;<input type="text" style="width:56;" name="ctrt_cust_sls_ofc_cd" readonly="readonly" class="input2" caption="Customer Code"/>&nbsp;<script language="javascript">ComComboObject('ctrt_cust_srep_cd', 2, 94, 0, 1);
                    </script>&nbsp;<input type="text" style="width:230;" name="ctrt_cust_srep_nm" readonly="readonly" class="input2"/></td>
                </tr>
                <tr class="h23">
                    <td>Real Customer</td>
                    <td><input type="text" style="width:25;" name="real_cust_cnt_cd" maxlength="2" dataformat="engup" readonly="readonly" class="input2">&nbsp;<input type="text" style="width:72;" name="real_cust_seq"  dataformat="int" maxlength="6" readonly="readonly" class="input2"></td>
                    <td><input type="text" style="width:279;" name="real_cust_nm" readonly="readonly" class="input2"></td>
                    <td>&nbsp;<input type="text" style="width:37;text-align:center;" name="real_cust_tp_cd" readonly="readonly" class="input2">&nbsp;<input type="text" style="width:56;" name="real_cust_val_sgm" readonly="readonly" class="input2">&nbsp;<input type="text" style="width:56;" name="real_cust_sls_ofc_cd" readonly="readonly" class="input2">&nbsp;<input type="text" style="width:94;" name="real_cust_srep_cd" readonly="readonly" class="input2">&nbsp;<input type="text" style="width:230;" name="real_cust_srep_nm" readonly="readonly" class="input2"></td>
                </tr>
                <tr class="h23">
                    <td width="">MQC</td>
                    <td width="" colspan="2"><input type="text" style="width:102;text-align:right;" name="prop_mqc_qty" class="input1" caption="MQC" dataformat="int" required>&nbsp;<script language="javascript">ComComboObject('cntr_lod_ut_cd', 1, 92, 0, 1);</script></td>
                    <td width="" colspan="4"><img src="img/blank.gif" style="width:14px;height:10px;">MVC<img src="img/blank.gif" style="width:4px;height:10px;"><input type="text" style="width:56;text-align:right;" name="prop_mvc" readonly="readonly" class="input2"></td>
                </tr>
                </table>
				 <table class="line_bluedot"><tr><td></td></tr></table>
                <!-- Grid  (S) -->
                <table width="100%"  id="mainTable">
                    <tr>
                        <td width="100%">
                            <script language="javascript">ComSheetObject('sheet2');</script>
                        </td>
                    </tr>
                </table>
                <!-- Grid (E) -->
                <table width="100%" class="button">
            <tr><td class="btn2_bg">
                <table border="0" cellpadding="0" cellspacing="0">
                        <tr>
                        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                        <tr><td class="btn2_left"></td>
                        <td class="btn2" name="btn_RowAdd">Row&nbsp;Add</td>
                        <td class="btn2_right"></td>
                        </tr>
                        </table></td>
                        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                        <tr><td class="btn2_left"></td>
                        <td class="btn2" name="btn_DeleteRow">Delete</td>
                        <td class="btn2_right"></td>
                        </tr>
                        </table></td>
                </tr>
                </table>
            </td></tr>
            </table>
                <!--  biz_2   (E) -->

                </td></tr>
            </table>
            <table width="100%">
                <tr>
                    <td width="100%">
                        <script language="javascript">ComSheetObject('sheet3');</script>
                    </td>
                </tr>
            </table>
    <!--biz page (E)-->
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
                </table></td>
                <td class="btn1_line"></td>

                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_Delete">Delete</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_GoToProposal">Go To Proposal</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>

            </tr>
            </table>
        </td></tr>
        </table>
    <!--Button (E) -->


    </td></tr>
</table>
 <!-- 개발자 작업  끝 -->
</form>
</body>
</html>