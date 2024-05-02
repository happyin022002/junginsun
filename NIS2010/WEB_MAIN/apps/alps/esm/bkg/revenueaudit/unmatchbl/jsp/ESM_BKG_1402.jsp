<%
/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ESM_BKG_1402.jsp
*@FileTitle : Audit by CNTR Qty Discrepancy
*Open Issues :
*Change history : 
*@LastModifyDate : 2011.07.25
*@LastModifier : 이인영
*@LastVersion : 1.0
* 2011.07.25 이인영
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.event.EsmBkg1402Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.util.code.CodeInfo"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.revenueauditcommon.rascommon.rascommon.vo.RsltCdListVO"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.revenueauditcommon.common.RASUtil"%>
<%@ page import="com.hanjin.framework.component.common.AbstractValueObject"%>
<%@ page import="java.util.List"%>

<%
    EsmBkg1402Event  event = null;              //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //서버에서 발생한 에러
    String strErrMsg = "";                      //에러메세지
    int rowCount     = 0;                       //DB ResultSet 리스트의 건수
    
    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    String strRhq_ofc_cd    = "";
    String strOfc_cd        = "";
    
    //String blNo = "";
    
    String[] rhqs = null;
    String[] offices = null;
    String[] svcScpCds = null;
    String[] contractTypes = null;  
    String[] officeTypes = null;

    
    Logger log = Logger.getLogger("com.hanjin.apps.RevenueAudit.UnmatchBL");
    
    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
        strRhq_ofc_cd = account.getRhq_ofc_cd();
        strOfc_cd = account.getOfc_cd();

        //blNo = request.getParameter("bl_no");
        
        event = (EsmBkg1402Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
        
        // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        
        // rhq
       rhqs = RASUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("rhq"));
        // office
       offices = RASUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("office"));
       if(null == offices){
           offices = new String[] {"", ""};
       }
        // Scope
        svcScpCds = RASUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("svcScpCd"));
        // Contract Type => 0256 참조
        contractTypes = RASUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("contractType"), false , "|", "\t", "getCode", "getName");
        // Office Type 
        officeTypes = RASUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("officeType"), false , "|", "\t", "getCode", "getName");
        
        
    }catch(Exception e) {
        out.println(e.toString());
    }
    
%>
<html>
<head>
<title>Retroactive B/L Filtering</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">

    var rhqComboValue = "|<%=rhqs[0]%>";

    var officeComboValue = "|<%=offices[0]%>";
    
    if(officeComboValue == "|"){
        officeComboValue = "";
    }
    
    var svcScpCdComboValue = "|<%=svcScpCds[0]%>";
    var svcScpCdComboText = "|<%=svcScpCds[1]%>";
    
    var contractTypeComboValue = "|<%=contractTypes[0]%>";
    var contractTypeComboText = "|<%=contractTypes[1]%>";

    var officeTypeComboValue = "<%=officeTypes[0]%>";
    var officeTypeComboText = "<%=officeTypes[1]%>";

    
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
<!-- Form Hidden -->
<input type="hidden" name="strRhq_ofc_cd" value="<%=strRhq_ofc_cd%>">
<input type="hidden" name="strOfc_cd" value="<%=strOfc_cd%>">
<input type="hidden" name="bkg_ofc_cd_sub" value="N">

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2; padding-left:5;">

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
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_new">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
				   <tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_downexcel">Down Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			</tr>
			</table>
		</td></tr>
		</table>
    	<!--Button (E) -->
		
		<!--biz page (S)-->
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">
			

				<!--  biz_1 (S) -->
				<table class="search" border="0" style="width:980;"> 
					<tr class="h23">
						<td width="80">Office Type</td>
						<td width="80"><script language="javascript"> ComComboObject('ofc_tp_cd', 1, 70, 0, 1, 0, false);</script></td>
						<td width="40">RHQ</td>
						<td width="80"><script language="javascript">ComComboObject('bkg_rhq_cd', 1, 70, 0, 1, 0, false);</script></td>
						<td width="45">Office</td>
						<td width="120" class="sm"><script language="javascript">ComComboObject('bkg_ofc_cd', 1, 75, 0, 0, 0, false);</script>
						        &nbsp;Sub<input type="checkbox" class="trans" name="sub" value="N" onClick="javascript:changeOfcCdSubManual(this)"></td>
						<td width="50">
							<table class="search_sm2" border="0" style="width:350;"> 
							<tr class="h23">
								<td>Date</td>
								<!--<td width="160" class="stm"><input type="radio" value="BKG" class="trans" name="r_date">BKG&nbsp;&nbsp;&nbsp;<input type="radio" value="APPL" class="trans" name="r_date">Appl.&nbsp;&nbsp;&nbsp;<input type="radio" value="ETD" class="trans" name="r_date" checked>ETD</td>-->
								<td width="" class="stm"><input type="radio" class="trans" name="search_date" value="BOOKING" >BKG&nbsp;&nbsp;<input type="radio" class="trans" name="search_date" value="APPL" checked>Appl.&nbsp;&nbsp;<input type="radio" name="search_date" value="ETD" class="trans" >ETD&nbsp;</td>
								<td width="">
								    <nobr>
								    <input type="text" style="width:70;text-align:center;" class="input1" value="" caption="From Date" name="from_dt" dataformat="ymd" maxLength="10" minlength="8">&nbsp;<img class="cursor" src="img/btns_calendar.gif" name="btns_calendar1" width="19" height="20" border="0" align="absmiddle">
								    &nbsp;~&nbsp;
								    <input type="text" style="width:70;text-align:center;" class="input1" value="" caption="To Date" name="to_dt" dataformat="ymd" maxLength="10" minlength="8">&nbsp;<img class="cursor" src="img/btns_calendar.gif" name="btns_calendar2" width="19" height="20" border="0" align="absmiddle">
								    </nobr>
								</td>
							</tr>
							</table>
						</td>
						<td></td>
						<td width="40">&nbsp;&nbsp;&nbsp;Day</td>
						<td><select style="width: 70;" class="input1" name="retroact_day">
						    <option value="W0" >ALL</option>
							<option value="W1" selected>1~7</option>
							<option value="W2">8~14</option>
							<option value="W3">15~21</option>
							<option value="W4">22~28</option>
							<option value="W5">29~35</option>
							<option value="W6">36~</option>
						</select></td>
					</tr>
				</table>
				<table class="line_bluedot"><tr><td></td></tr></table>
				<table class="search" border="0" style="width:978;"> 
					<tr class="h23">
						<td width="95">Approval Office</td>
					    <td width="66"><input type="text" style="width:52;text-align:center;ime-mode:disabled;" class="input" name="apro_ofc_cd" dataformat="uppernum" maxlength="6"></td>
					    <td width="90" stype="width: 90px;">Request Office</td>
					    <td width="60"><input type="text" style="width:52;text-align:center;ime-mode:disabled;" class="input" name="req_ofc_cd" dataformat="uppernum" maxlength="6"></td>
					    <td width="95">Sales Rep Code</td>
					    <td width="66"><input type="text" style="width:58;text-align:center;ime-mode:disabled;" class="input" name="srep_cd" dataformat="uppernum" maxlength="5"></td>
					    <td width="28">POR</td>
						<td width="66"><input type="text" style="width:52;text-align:center;ime-mode:disabled;" class="input" name="por_cd" dataformat="uppernum" maxlength="5"></td>
						<td width="25">POL</td>
						<td width="66"><input type="text" style="width:52;text-align:center;ime-mode:disabled;" class="input" name="pol_cd" dataformat="uppernum" maxlength="5"></td>
						<td width="25">POD</td>
						<td width="66"><input type="text" style="width:52;text-align:center;ime-mode:disabled;" class="input" name="pod_cd" dataformat="uppernum" maxlength="5"></td>
						<td width="25">DEL</td>
						<td width="66"><input type="text" style="width:50;text-align:center;ime-mode:disabled;" class="input" name="del_cd" dataformat="uppernum" maxlength="5"></td>
					</tr>
				</table>
				<table class="search" border="0" style="width:980;"> 
					<tr class="h23">
						<td width="65" >BKG No.</td>
						<td width="125"><input type="text" style="width:98;text-align:center;ime-mode:disabled" class="input" name="bkg_no" dataformat=uppernum maxlength="13"></td>				
						<td width="45">Scope</td>
						<td width="125"><script language="javascript">ComComboObject('svc_scp_cd', 2, 90, 0, 0, 0, false);</script></td>
						<td width="45"><nobr style="width:115;" >Contract Type</nobr></td>
						<td width="75"><script language="javascript"> ComComboObject('bkg_ctrt_tp_cd', 1, 50, 0, 0, 0, false);</script></td>
						<td width="45"><nobr>Contract No.</nobr></td>
						<td width="113"><input input type="text" class="input" value="" style="width:105;text-align:center;ime-mode:disabled" name="ctrt_no" dataformat=uppernum caption="Contract No" maxlength="12"></td>
						<td width="58">Customer</td>
						<td width="">
							<select style="width:70;" class="input" name="bkg_cust_tp_cd">
							<option value="" ></option>
							<option value="S" >Shipper</option>
							<option value="C">Consignee</option>
							<option value="N">Notify</option>
							</select>
							<input type="text" style="width:25;text-align:center;ime-mode:disabled;" class="input" name="cust_cnt_cd" dataformat="engup" maxlength="2">
							<input type="text" style="width:50;text-align:center;ime-mode:disabled;" class="input" name="cust_seq" dataformat="uppernum" maxlength="6">
							<!-- <input type="text" style="width:88;text-align:left;ime-mode:disabled;" class="input" name="cust_nm" dataformat="uppernum" maxlength="20">  -->
						</td>					
					</tr>
				</table>
			</td>					
			</tr>
		</table>
							
				<!--  biz_1   (E) -->	
		<table class="height_10"><tr><td colspan="8"></td></tr></table>
		
		<!-- Grid BG Box  (S) -->
     	<table class="search" id="mainTable"> 
       	<tr><td class="bg">
       	<!--  Button_Sub (S) -->
	    	<!-- Button_Sub (E) -->
			<!-- Grid  (S) -->
			<table width="100%"> 
	       		<tr><td class="btn2_bg" align="right">
				<table border="0" cellpadding="0" cellspacing="0">
				    <tr>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="search">
						<tr class="h23"><td>BKG Count&nbsp;&nbsp;</td></tr>
						</table></td>
						<td><input type="text" style="width:60;text-align:right" class="input" value="" name="bkg_cnt" readonly></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="search">
						<tr class="h23"><td style="width: 130px; text-align:right">Contract Count</td></tr>
						</table></td>
						<td><input type="text" style="width:60;text-align:right" class="input" value="" name="ctrt_cnt" readonly></td>
					</tr>
				</table>
				</td></tr>
			</table>
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
	<!-- Grid BG Box  (E) -->

	
	
	</td></tr>
		</table>
	
</form>
</body>
</html>
