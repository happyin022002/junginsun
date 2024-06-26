<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_4009.jsp
*@FileTitle : E-Service Compensation Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.03
*@LastModifier : 김대호
*@LastVersion : 1.0
* 2009.08.03 김대호
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
<%@ page import="com.hanjin.apps.alps.esm.pri.surcharge.eservicecompensation.event.EsmPri4009Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.util.code.CodeInfo"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCompensationChargeComboListVO"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.common.PRIUtil"%>
<%@ page import="com.hanjin.framework.component.common.AbstractValueObject"%>
<%@ page import="java.util.List"%>

<%
    EsmPri4009Event  event = null;              //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //서버에서 발생한 에러
    String strErrMsg = "";                      //에러메세지
    int rowCount     = 0;                       //DB ResultSet 리스트의 건수
    
    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    
    String[] svcScpCds = null;
    String[] origins = null;
    String[] dests = null;
    String[] charges = null;
    String[] curs = null;
    String[] ctrtTypeArr = null;
    
    Logger log = Logger.getLogger("com.hanjin.apps.Surcharge.Eservicecompensation");
    
    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
       
        event = (EsmPri4009Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
        
        // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        
        // scope Combo Data 생성
        svcScpCds = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("svcScpCd"));
        // orign Combo Data 생성
        origins = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("origin"));
        // dest Combo Data 생성
        dests = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("dest"));
        // charge Combo Data 생성
        charges = PRIUtil.getValueObject2StringArray((List<RsltCompensationChargeComboListVO>)eventResponse.getCustomData("charge"), true , "|", "\t", "getChgCd", "getChgNm");
        // cur Combo Data 생성
        curs = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("cur"));
        // Contract Type Combo Data 생성
        ctrtTypeArr = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("contract"),true ,"|","\t","getCode","getName");
        
    }catch(Exception e) {
        out.println(e.toString());
    }
%>
<html>
<head>
<title>E-Service Compensation Creation</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">

    var svcScpCdComboValue = " |<%=svcScpCds[0]%>";
    var svcScpCdComboText = " |<%=svcScpCds[1]%>";

    var originComboValue = " |<%=origins[0]%>";
    var originComboText = " |<%=origins[1]%>";

    var destComboValue = " |<%=dests[0]%>";
    var destComboText = " |<%=dests[1]%>";

    var chargeComboValue = " |<%=charges[0]%>";
    var chargeComboText = " |<%=charges[1]%>";

    var curComboValue = " |<%=curs[0]%>";
    var curComboText = " |<%=curs[1]%>";

    var ctrtTypeCode = "|<%=ctrtTypeArr[0]%>";
    var ctrtTypeText = "|<%=ctrtTypeArr[1]%>";
    
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

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">

    <tr><td valign="top">
    <!--Page Title, Historical (S)-->
        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
            <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
            <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
        </table>
    <!--Page Title, Historical (E)-->
    
    <!--biz page (S)-->
        <table class="search"> 
        <tr><td class="bg">

            <table class="search" border="0" style="width:979;"> 
                <tr class="h23">
                    <td width="90">RFA No.</td>
                    <td width="140"><input type="text" name="sc_no" style="width:90;text-align:center;" class="input" dataformat="uppernum" maxLength="11" minlength="9" caption="RFA No"></td>

                    <td width="90">Contract Type</td>
                    <td width="140"><script language="javascript">ComComboObject('prc_ctrt_tp_cd', 2, 82, 0, 0, 1, false);</script></td>


                    <td width="90">Service Scope</td>
                    <td width="" colspan="3"><script language="javascript">ComComboObject('svc_scp_cd', 2, 82, 0, 0, 0, false);</script>&nbsp;<input type="text" name="svc_scp_nm" style="width:240;" class="input2" caption="Service Scope" readonly></td> 
                </tr>
                <tr class="h23">
                    <td width="90">Charge</td>
                    <td width="140" style="padding-left:2"><script language="javascript">ComComboObject('chg_cd', 2, 90, 0, 0, 0, false);</script></td>
                    <td width="90">Origin</td>
                    <td width="140"><script language="javascript">ComComboObject('org_rgn_cd', 2, 82, 0, 0, 0, false);</script></td>
                    <td width="90">Dest.</td>
                    <td width="140"><script language="javascript">ComComboObject('dest_rgn_cd', 2, 82, 0, 0, 0, false);</script></td>

                    <td width="90">Access Date</td>
                    <td width=""><input type="text" name="eff_dt" style="width:80;text-align:center;" class="input" dataformat="ymd" maxLength="10" minlength="8" caption="Effective Date">
                    <img src="img/btns_calendar.gif" class="cursor" name="btns_calendar" width="19" height="20" alt="" border="0" align="absmiddle"></td>

                </tr>
            </table>

        <!-- Grid  (S) -->
            <table width="100%"  id="mainTable"> 
                <tr>
                    <td width="100%">
                        <script language="javascript">ComSheetObject('sheet1');</script>
                    </td>
                </tr>
            </table>
        <!-- Grid (E) -->

            <!--  Button_Sub (S) -->
            <table width="100%" class="button"> 
            <tr><td class="btn2_bg">
                <table border="0" cellpadding="0" cellspacing="0"><tr>
                    <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn2_left"></td>
                    <td class="btn2" name="btn_add">Row&nbsp;Add</td>
                    <td class="btn2_right"></td>
                    </tr>
                    </table></td>
                    <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn2_left"></td>
                    <td class="btn2" name="btn_del">Delete</td>
                    <td class="btn2_right"></td>
                    </tr>
                    </table></td></tr>
                </table>
            </td></tr>
            </table>
            <!-- Button_Sub (E) -->
        
        </td></tr>
        </table>
    <!--biz page (E)-->

    <!--Button (S) -->
        <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;padding-bottom:10;"> 
        <tr><td class="btn1_bg">
            <table border="0" cellpadding="0" cellspacing="0">
            <tr>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>

                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_new">New</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>

                <td class="btn1_line"></td>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_save">Save</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
                
            </tr>
            </table></td>
                
            </tr>
            </table>
    <!--Button (E) -->
    
    </td></tr>
    
</table>

</form>
</body>
</html>