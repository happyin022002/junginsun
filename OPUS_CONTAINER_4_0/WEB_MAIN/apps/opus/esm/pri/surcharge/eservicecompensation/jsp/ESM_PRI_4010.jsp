<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_4010.jsp
*@FileTitle : E-Service Compensation Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.10
*@LastModifier : 
*@LastVersion : 1.0
* 2009.08.10 
* 1.0 Creation
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.pri.surcharge.eservicecompensation.event.EsmPri4010Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.component.util.code.CodeInfo"%>
<%@ page import="com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>
<%@ page import="com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCompensationChargeComboListVO"%>
<%@ page import="com.clt.apps.opus.esm.pri.common.PRIUtil"%>
<%@ page import="com.clt.framework.component.common.AbstractValueObject"%>
<%@ page import="java.util.List"%>

<%
    EsmPri4010Event  event = null;              //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //error from server
    String strErrMsg = "";                      //error message
    int rowCount     = 0;                       //count of DB resultSET list
    
    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    
    String[] svcScpCds = null;
    String[] charges = null;
    String[] ctrtTypeArr = null;
    
    Logger log = Logger.getLogger("com.clt.apps.Surcharge.Eservicecompensation");
    
    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
       
        event = (EsmPri4010Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
        
         
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        
        // scope Combo Data creation
        svcScpCds = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("svcScpCd"));
        // charge Combo Data creation
        charges = PRIUtil.getValueObject2StringArray((List<RsltCompensationChargeComboListVO>)eventResponse.getCustomData("charge"), true , "|", "\t", "getChgCd", "getChgNm");
        // Contract Type Combo Data creation
        ctrtTypeArr = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("contract"),true ,"|","\t","getCode","getName");

    }catch(Exception e) {
        out.println(e.toString());
    }
%>
<html>
<head>
<title>E-Service Compensation Inquiry</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">

    var svcScpCdComboValue = "|<%=svcScpCds[0]%>";
    var svcScpCdComboText = "|<%=svcScpCds[1]%>";
    
    var chargeComboValue = " |<%=charges[0]%>";
    var chargeComboText = " |<%=charges[1]%>";

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
	
    <!--Button (S) -->
        <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0; padding-bottom:2;" !style="padding-top:5; padding-bottom:10;"> 
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
            </tr>
            </table>
            </td>
        </tr>
        </table>
    <!--Button (E) -->
	   
	<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">
		<!-- biz_1  (S) -->
        	<table class="search" border="0" style="width:979;"> 
<%--
				<tr class="h23">
					<td width="90">RFA & S/C No.</td>
					<td width="120"><input type="text" name="sc_no" style="width:80;text-align:center;" class="input" dataformat="uppernum" maxLength="10" minlength="9" caption="RFA & S/C No"></td>
					<td width="90">Service Scope</td>
					<td width="230"><nobr><script language="javascript">ComComboObject('svc_scp_cd', 2, 60, 0, 0, 0, false);</script>&nbsp;<input type="text" name="svc_scp_nm" style="width:240;" class="input2" caption="Service Scope" readonly></nobr></td> 
					<td width="90">Access Date</td>
					<td width=""><input type="text" name="eff_dt" style="width:80;text-align:center;" class="input" dataformat="ymd" maxLength="10" minlength="8" caption="Effective Date">
					<img src="img/btns_calendar.gif" class="cursor" name="btns_calendar" width="19" height="20" alt="" border="0" align="absmiddle"></td>
 				</tr>
				<tr class="h23">
					<td width="75">Charge</td>
					<td width="120" style="padding-left:2"><script language="javascript">ComComboObject('chg_cd', 2, 82, 0, 0, 0, false);</script></td>
					<td width="90">Origin</td>
					<td width="230"><script language="javascript">ComComboObject('org_rgn_cd', 2, 60, 0, 0, 0, false);</script></td>
					<td width="90">Dest.</td>
					<td width="82" style="padding-left:2"><script language="javascript">ComComboObject('dest_rgn_cd', 2, 82, 0, 0, 0, false);</script></td>
 				</tr>
--%>


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
		<!-- biz_1  (E) -->
		</td></tr>
		</table>
	<!--biz page (E)-->

	</td></tr>
</table>
        
</form>
</body>
</html>
