<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_0062.jsp
*@FileTitle : S/C List Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.31
*@LastModifier : 김대호
*@LastVersion : 1.0
* 2009.08.31 김대호
* 1.0 Creation
=========================================================
* History
* 2012.03.30 서미진 [CHM-201216990] Contract Sub-Office, Contract Office, Contract Area-Office의 base Office를 S/C의 Req.OFC로 변경
* 2015.06.16 최성환 [CHM-201536349] S/C 다운로드 보안 강화 (다운로드 버튼 접근 제한)
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.screport.screport.event.EsmPri0062Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.util.code.CodeInfo"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.common.PRIUtil"%>
<%@ page import="com.hanjin.framework.component.common.AbstractValueObject"%>
<%@ page import="java.util.List"%>

<%
    EsmPri0062Event  event = null;              //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //서버에서 발생한 에러
    String strErrMsg = "";                      //에러메세지
    int rowCount     = 0;                       //DB ResultSet 리스트의 건수
    
    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    
    String[] svcScpCds = null;
    String[] scNoPrefixs = null;
    String[] custTpCds = null;
    String[] aproOfcCds = null;
    
    Logger log = Logger.getLogger("com.hanjin.apps.SCReport.SCReport");
    
    try {
    	
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
       
        event = (EsmPri0062Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
        
        // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        
        // Service Scope Combo Data 생성
        svcScpCds = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("svcScpCd"));
        // S/C No Combo Data 생성
        scNoPrefixs = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("scNoPrefix"));
        // Customer Type Combo Data 생성
        custTpCds = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("custTpCd"), true , "|", "\t", "getCode", "getName");
        // Approval Office Combo Data 생성 => 0003 참조
        aproOfcCds = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("aproOfcCd"));
        
    }catch(Exception e) {
        out.println(e.toString());
    }
%>
<html>
<head>
<title>S/C List Inquiry</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">

    var svcScpComboValue = "|<%=svcScpCds[0]%>";
    var svcScpComboText = "|<%=svcScpCds[1]%>";

    var scNoPrefixComboValue = "|<%=scNoPrefixs[0]%>";
    var scNoPrefixComboText = "|<%=scNoPrefixs[1]%>";

    var custTpCdComboValue = "|<%=custTpCds[0]%>";
    var custTpCdComboText = "|<%=custTpCds[1]%>";

    var aproOfcCdComboValue = "|<%=aproOfcCds[0]%>";
    var aproOfcCdComboText = "|<%=aproOfcCds[1]%>";
    
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
<!--  Office Code Validation 체크를 위한 정의 -->
<input type="hidden" name ="ofc_cd" value="">
<input type="hidden" name="in_usr_id" value="<%=strUsr_id%>">
<!-- Form Hidden -->

<input type="hidden" id="searchParam" name="rf_flg"   value="">
<input type="hidden" id="searchParam" name="gamt_flg" value="">
<input type="hidden" id="searchParam" name="eff_dt"   value="">
<input type="hidden" id="searchParam" name="exp_dt"   value="">

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
                    <td class="btn1" name="btn_opensc">Open S/C</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_viewsc">View S/C</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_amdhistory">AMD History</td>
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
					<td width="75">SVC Scope</td>
					<td width="185"><script language="javascript">ComComboObject('svc_scp_cd', 2, 60, 0, 0, 0, false);</script>&nbsp;<input type="text" name="svc_scp_nm" style="width:110;" class="input2" readonly></td>
					<td width="90" >S/C No.</td>
					<td width="90"><input type="text" style="width: 80; text-align: center;" name="sc_no" maxlength="9" class="input" dataformat="engup"></td>
					<td width="" valign="top">
						<table class="search_sm2" border="0" style="width:100%;"> 
							<tr class="h23">
								<td width=""><nobr><input type="radio" name="rdoDate" value="2" class="trans" checked>S/C Effective Date</nobr></td>
								<td width="">
								    <nobr>
								    <input type="text" class="input1" style="width:70;text-align:center" caption="S/C Effective From Date" name="eff_date_from" cofield="eff_date_to" dataformat="ymd" maxLength="10" minlength="8"> <img class="cursor" name="btns_calendar1" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle">
								    ~
								    <input type="text" class="input1" style="width:70;text-align:center" caption="S/C Effective To Date" name="eff_date_to" cofield="eff_date_from" dataformat="ymd" maxLength="10" minlength="8"> <img class="cursor" name="btns_calendar2" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle">
								    </nobr>
								</td>
								<td width=""><input type="radio" name="rdoDate" value="1" class="trans">Access Date</td>
								<td width="">
								    <nobr>
								    <input type="text" style="width:70;text-align:center" name="access_date" class="input" dataformat="ymd" maxLength="10" minlength="8" caption="Access Date"> <img src="img/btns_calendar.gif" class="cursor" name="btns_calendar3" width="19" height="20" border="0" align="absmiddle">
								    </nobr>
								</td>
							</tr> 
						</table>
					</td>
				</tr>
				</table>	
				
				
				<table class="search" border="0" style="width:979;">
				<tr class="h23">
					<td width="100">Customer Type</td>
					<td width="80">
					<script language="javascript">ComComboObject('prc_ctrt_cust_tp_cd', 2, 60, 0, 0, 0, false);</script></td>
                    <td width="100">Approval Office</td>
                    <td width="80">
                    <script language="javascript">ComComboObject('prop_apro_ofc_cd', 2, 60, 0, 0, 0, false);</script></td>
					<td width="100">Request Office</td>
					<td width="120"> <input type="text" name="prop_ofc_cd" style="width:84;text-align:center;ime-mode:disabled" class="input" dataformat="engup" maxLength="6"> <img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="ComOpenPopupWithTarget"></td>
					<td width="">S/C Type&nbsp;<script language="javascript">ComComboObject('sc_type', 1, 60, 0, 0, 0, false);</script></td>
					<td width="60">Affiliate</td>
					<td width=""><input type="text" name="afil_nm" style="width:100;text-align:left;" class="input" maxlength="100" dataformat="engup"></td>
					<td width="40">Fixed</td>
					<td width="60" class="stm"><input type="checkbox" name="fx_rt_flg" value="N" class="trans" checked></td>
				</tr> 
				</table>	
				
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="65">Total MQC</td>
					<td width="195"><input type="text" name="total_mqc" style="width:90;text-align:right;" class="input2" readonly>&nbsp;<input type="text" value="FEU" style="width:40;text-align:center;" class="input2" readonly></td>
					<td width="80">No. of S/C</td>
					<td width=""><input type="text" name="noof_sc" style="width:90;text-align:center;" class="input2" readonly></td>
					<td width="20"></td>
					<td width="100">Customer Name</td>
					<td width=""><input type="text" name="cust_nm" style="width:120;text-align:left;" class="input" maxlength="100" dataformat="engup"></td>
					<td width="20"></td>
					<td width="110">Actual Customer</td>
					<td width=""><input type="text" name="act_cust_nm" style="width:120;text-align:left;" class="input" maxlength="100" dataformat="engup"></td>
					<td width="20"></td>
					<td width="110">Real Customer</td>
					<td width=""><input type="text" name="real_cust_nm" style="width:120;text-align:left;" class="input" maxlength="100" dataformat="engup"></td>
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
	
</td></tr></table>

</form>
</body>
</html>
