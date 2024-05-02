<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_0108_01.jsp
*@FileTitle : S/C Performance Summary
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.31
*@LastModifier : 김대호
*@LastVersion : 1.0
* 2009.08.31 김대호
* 1.0 Creation
*=========================================================
* History :
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
<%@ page import="com.hanjin.apps.alps.esm.pri.screport.screport.event.EsmPri010801Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.util.code.CodeInfo"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.common.PRIUtil"%>
<%@ page import="com.hanjin.framework.component.common.AbstractValueObject"%>
<%@ page import="java.util.List"%>

<%
    EsmPri010801Event  event = null;              //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //서버에서 발생한 에러
    String strErrMsg = "";                      //에러메세지
    int rowCount     = 0;                       //DB ResultSet 리스트의 건수
    
    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    
    String[] rhqs = null;
    String[] aproOfcCds = null;    
    String[] svcScpCds = null;    
    String[] custTpCds = null;    
    
    Logger log = Logger.getLogger("com.hanjin.apps.SCReport.SCReport");
    
    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
       
        event = (EsmPri010801Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
        
        // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        
        // rhq Combo Data 생성
        rhqs = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("rhq"));
        // Approval Office Combo Data 생성 => 0003 참조
        aproOfcCds = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("aproOfcCd"));
        // Scope Combo Data 생성
        svcScpCds = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("svcScpCd"));
        // Customer Type Combo Data 생성
        custTpCds = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("custTpCd"), true , "|", "\t", "getCode", "getName");
        
    }catch(Exception e) {
        out.println(e.toString());
    }
%>
<html>
<head>
<title>S/C Performance Summary</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">

    var rhqComboValue = "|<%=rhqs[0]%>";
    var rhqComboText = "|<%=rhqs[1]%>";

    var aproOfcCdComboValue = "|<%=aproOfcCds[0]%>";
    var aproOfcCdComboText = "|<%=aproOfcCds[1]%>";

    var svcScpCdComboValue = "|<%=svcScpCds[0]%>";
    var svcScpCdComboText = "|<%=svcScpCds[1]%>";
    
    var custTpCdComboValue = "|<%=custTpCds[0]%>";
    var custTpCdComboText = "|<%=custTpCds[1]%>";

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
<input type="hidden" name="backendjob_key">
<!--  Office Code Validation 체크를 위한 정의 -->
<input type="hidden" name ="ofc_cd" value="">
<!-- Form Hidden -->
<input type="hidden" id="searchParam" name="sc_no">
<input type="hidden" id="searchParam" name="rf_flg">
<input type="hidden" id="searchParam" name="gamt_flg">
 
    <!--Button (S) -->
        <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0; padding-bottom:2; display:none"> 
        <tr><td class="btn1_bg">
            <table border="0" cellpadding="0" cellspacing="0">
            <tr>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
            </tr>
            </table>
        </td></tr>
        </table>
    <!--Button (E) -->
	
		<table class="search"> 
       	<tr><td class="bg">
			
			<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="120"><nobr>S/C Effective Date</nobr></td>
					<td width="258"><input type="text" class="input1" style="width:80;text-align:center;" caption="S/C Effective From Date" name="eff_dt" cofield="exp_dt" dataformat="ymd" maxLength="10" minlength="8"> <img class="cursor" src="img/btns_calendar.gif" name="btns_calendar3" width="19" height="20" border="0" align="absmiddle"> &nbsp;~&nbsp; <input type="text" class="input1" style="width:80;text-align:center;" caption="S/C Effective To Date" name="exp_dt" cofield="eff_dt" dataformat="ymd" maxLength="10" minlength="8"> <img class="cursor" src="img/btns_calendar.gif" name="btns_calendar4" width="19" height="20" border="0" align="absmiddle"></td>
                    <td width="50">Period</td>
                    <td width="246"><input type="text" class="input" style="width:80;text-align:center;" caption="Period From Date" name="bl_obrd_dt_from" !cofield="bl_obrd_dt_to" dataformat="ymd" maxLength="10" minlength="8"> <img class="cursor" src="img/btns_calendar.gif" name="btns_calendar1" width="19" height="20" border="0" align="absmiddle">&nbsp;~&nbsp;<input type="text" class="input" style="width:80;text-align:center;" caption="Period To Date" name="bl_obrd_dt_to" !cofield="bl_obrd_dt_from" dataformat="ymd" maxLength="10" minlength="8"> <img class="cursor" src="img/btns_calendar.gif" name="btns_calendar2"  width="19" height="20" border="0" align="absmiddle"></td>
				    <td width="100"><input type="checkbox" name="by_scope" value="Y" class="trans" checked><nobr>By Scope</nobr></td>
				    <td width="10">&nbsp;</td>
					<td width="60">Key A/C</td>
				    <td width=""><script language="javascript">ComComboObject('key_acct_flg', 1, 65, 0, 0, 0, false);</script></td>
					</tr>
			</table>
			<table class="search" border="0" style="width:979;"> 
			<tr class="h23">
				<td width="35">RHQ</td>
				<td width="70"><script language="javascript">ComComboObject('rhq', 1, 65, 0, 0, 0, false);</script></td>
                <td width="45" title="Approval Office">A.OFC</td>
                <td width="75"><script language="javascript">ComComboObject('prop_apro_ofc_cd', 2, 70, 0, 0, 0, false);</script></td>
				<td width="45" title="Contract Office">C.OFC</td>
				<td width="109"><input type="text" name="ctrt_cust_sls_ofc_cd" style="width:60;text-align:center;ime-mode:disabled" class="input" dataformat="engup" maxLength="6"> <img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="ComOpenPopupWithTarget"></td>
				<td width="50">S/C  No.</td>
				<td width="100"><input type="text" class="input" style="width:90;text-align:center;ime-mode:disabled" name="sc_no_input" dataformat="uppernum" maxLength="9"></td>
				<td width="80">SVC Scope</td>
				<td width="80"><script language="javascript">ComComboObject('svc_scp_cd', 2, 70, 0, 0, 0, false);</script></td>
				<td width="100">Customer Type</td>
				<td width="50"><script language="javascript">ComComboObject('prc_ctrt_cust_tp_cd', 2, 40, 0, 0, 0, false);</script></td>
				<td width="60">S/C Type</td>
				<td width=""><script language="javascript">ComComboObject('sc_type', 1, 60, 0, 0, 0, false);</script></td>
				</tr>
				
			</table>
			<!--  biz_1   (E) -->
				
			<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
			
			<table class="search" border="0" style="width:979;"> 
			<tr class="h23">
				<td width="70">Total MQC</td>
				<td width="162"><input type="text" class="input2" name="total_mqc" style="width:80;text-align:right;" readonly>&nbsp;<input type="text" class="input2" style="width:50;text-align:center;" value="FEU" readonly></td>
				<td width="68">No. of S/C</td>
				<td width="120"><input type="text" class="input2" name="noof_sc" style="width:65;text-align:center;" readonly></td>
				<td width="120">Total Performance</td>
				<td width=""><input type="text" class="input2" name="total_performance" style="width:80;text-align:right;" readonly>&nbsp;<input type="text" class="input2" style="width:50;text-align:center;" value="FEU" readonly></td>
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
						
				
		</td></tr>
		</table>


<div style="display: none">
<script language="javascript">ComSheetObject('sheet2');</script>
</div>

</form>
</body>
</html>