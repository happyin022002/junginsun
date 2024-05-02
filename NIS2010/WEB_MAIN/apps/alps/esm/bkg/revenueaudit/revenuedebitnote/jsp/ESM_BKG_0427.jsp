<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0427.jsp
*@FileTitle : RDN Status Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.05
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.05.19 이승준
* 1.0 Creation
* 2013.02.12 김진주 [CHM-201322816] [BKG/DOC - Revenue Audit System] RDN Status 추가
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.revenueaudit.revenuedebitnote.event.EsmBkg0427Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.util.code.CodeInfo"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.revenueauditcommon.rascommon.rascommon.vo.RsltCdListVO"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.revenueauditcommon.common.RASUtil"%>
<%@ page import="com.hanjin.framework.component.common.AbstractValueObject"%>
<%@ page import="java.util.List"%>

<%
	EsmBkg0427Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_office_cd = "";
	//String strUsr_office_nm = "";
	
    String[] rhqs = null;
    String[] resp = null;
    String[] auditTools = null;
    String[] contractTypes = null;
    
    String[] discrepancyKinds = null;
    //String[] unmatchTypes = null;
    String[] rdnKinds = null;
	
	Logger log = Logger.getLogger("com.hanjin.apps.RevenueAudit.RevenueDebitNote");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		strUsr_office_cd =	account.getOfc_cd();
		//strUsr_office_nm =  account.getOfc_eng_nm();

		event = (EsmBkg0427Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
        // rhq
        rhqs = RASUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("rhq"));
        //resp
        resp = RASUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("resp"));
        // Audit Tool 
        auditTools = RASUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("auditTool"), false , "|", "\t", "getCode", "getName");
        // Contract Type
        contractTypes = RASUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("contractType"), false , "|", "\t", "getCode", "getName");
        // Unmatch Type
        //unmatchTypes = RASUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("unmatchType"), false , "|", "\t", "getCode", "getName");
        // Discrepancy Kind 1
        discrepancyKinds = RASUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("discrepancyKind"), false);
        // RDN Kind
        rdnKinds = RASUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("rdnKind"), false , "|", "\t", "getCode", "getName");
	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<html>
<head>
<title>RDN Status Inquiry</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">

    var rhqComboValue = "|<%=rhqs[0]%>";
    var respComboValue = "<%=resp[0]%>";

    var auditToolComboValue = "|<%=auditTools[0]%>";
    var auditToolComboText = "|<%=auditTools[1]%>";
    
    var contractTypeComboValue = "|<%=contractTypes[0]%>";
    var contractTypeComboText = "|<%=contractTypes[1]%>";
    
  
   
  
    
    var discrepancyKindComboValue = "<%=discrepancyKinds[0]%>";
    var discrepancyKindComboText = "<%=discrepancyKinds[1]%>";

    var rdnKindComboValue = "<%=rdnKinds[0]%>";
    var rdnKindComboText = "<%=rdnKinds[1]%>";

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
<!-- combo -->
<input type="hidden" name="cd"   value=""> 
<input type="hidden" name="etc1" value="">
<input type="hidden" name="etc2" value="">
<input type="hidden" name="etc3" value="">
<!-- rdn status cd -->
<input type="hidden" name="rdn_sts_cd" value="">

<!-- 개발자 작업	-->



<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	
	<tr><td valign="top">
	<!--Page Title, Historical (S)-->
	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
	</table>
	<!--Page Title, Historical (E)-->
	
	<!-- Hidden sheet for Transaction (S) -->
		<script language="javascript">ComSheetObject('sheet0');</script>
	<!-- Hidden sheet for Transaction (E) -->	
	
	<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">

				<!--  biz_1  (S) -->
				
							
				<table class="search" border="0"  style="width:979;"> 
				<tr class="h23">
					<td width="90">Receipt RHQ</td>
					<td width="90" style="padding-left:2"><script language="javascript"> ComComboObject('rct_rhq_cd', 1, 76, 0, 0, 0, false);</script></td>
					<td width="100">Receipt Office</td>
					<td width="90" style="padding-left:2"><script language="javascript"> ComComboObject('rct_ofc_cd', 1, 76, 0, 0, 0, false);</script></td>
					<td width="35">GSO</td>
					<td width="80"><input type="text" name="gso" style="width:65;text-align:center;ime-mode:disabled" value="" dataformat="uppernum" caption="GSO" maxLength="6"></td>
					<td width="80">Resp. RHQ</td>
					<td width="90"><script language="javascript"> ComComboObject('respb_rhq_cd', 1, 76, 0, 0, 0, false);</script></td>
					<td width="80">Resp. Office</td>
					<td width="90">&nbsp;<script language="javascript"> ComComboObject('respb_ofc_cd', 1, 76, 0, 0, 0, false);</script></td>
					<td width="80">Issue Office</td>
					<td width=""><input type="text" name="iss_ofc_cd" style="width:65;text-align:center;ime-mode:disabled" value="" dataformat="uppernum" caption="Issue Office" maxLength="6"></td>
				</tr>
				</table>	
				
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="90">Issue Date</td>
					<td width="252"><input name="rdn_iss_dt_from" type="text" style="width:75;text-align:center;"  value="" class="input1" caption="From Date" maxlength="10" dataformat="ymd">
					   <img class="cursor" src="img/btns_calendar.gif" name="btns_calendar1" width="19" height="20" border="0" align="absmiddle">&nbsp;~&nbsp;
					   <input name="rdn_iss_dt_to" type="text" style="width:75;text-align:center;"  value="" class="input1" caption="To Date" maxlength="10" dataformat="ymd">
					   <img class="cursor" src="img/btns_calendar.gif" name="btns_calendar2" width="19" height="20" border="0" align="absmiddle">
					</td>
					<td width="50">B/L No</td>
					<td width=""><input type="text" class="input" style="width:85;text-align:center;ime-mode:disabled" name="bl_no" value="" caption="B/L No" dataformat="uppernum" maxLength="12"></td>
					
					<td width="78">Audit Tool</td>
					<td width="140"><script language="javascript"> ComComboObject('rev_aud_tool_cd', 1, 130, 0, 0, 0, false);</script></td>
					<td width="80">&nbsp;Error Kind&nbsp;</td>
					<td style="padding-left:2"><script language="javascript">ComComboObject('umch_tp_cd',2, 185, '');</script></td>
				</tr>
				</table>
				
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="90">RDN Kind</td>
					<td width="" style="padding-left:2"><script language="javascript"> ComComboObject('rdn_knd_cd', 1, 90, '');</script></td>
					<td width="65" align="center">RDN No</td>
					<td width=""><input type="text" class="input" style="width:80;text-align:center;ime-mode:disabled" name="rdn_no" value="" caption="RDN No" dataformat="uppernum" maxLength="10"></td>
					<td width="60" align="center">C. Type</td>
					<td width="75"><script language="javascript"> ComComboObject('bkg_ctrt_tp_cd', 1, 65, 0, 0, 0, false);</script></td>
					<td width="90" align="center">Contract No</td>
					<td width=""><input type="text" class="input" style="width:85;text-align:center;ime-mode:disabled" name="ctrt_no" value="" caption="Contract No" dataformat="uppernum" maxLength="20"></td>
					<td width="77" align="center">Invoice No</td>
					<td width=""><input type="text" class="input" style="width:85;text-align:center;ime-mode:disabled" name="inv_no" value="" caption="Invoice No" dataformat="uppernum" maxLength="20"></td>
					<td width="75" align="center">VVD Code</td>
					<td width=""><input type="text" class="input" style="width:85;text-align:center;ime-mode:disabled" name="vvd_cd" value="" caption="VVD" dataformat="uppernum" maxLength="9"></td>
					
				</tr>
				</table>
				<table class="line_bluedot"><tr><td></td></tr></table>
				
				<table class="search_sm2" border="0" style="width:979"> 
					<tr class="h23">
					<td width="70">Status</td>
					<td width="80" class="stm">
					<input name="all" 		  	 type="checkbox" value="ALL" class="trans" checked onClick="checkAll();">ALL
					</td>
					<td width="100" class="stm">
					<input name="rdn_sts_check"  type="checkbox" value="IS"  class="trans" checked>Issued
					</td>
					<td width="130" class="stm">
					<input name="rdn_sts_check"  type="checkbox" value="AC"  class="trans" checked>Accepted
					</td>
					<td width="140" class="stm">
					<input name="rdn_sts_check"  type="checkbox" value="RR"  class="trans" checked>Revise Requested
					</td>
					<td width="100" class="stm">
					<input name="rdn_sts_check"  type="checkbox" value="RV"  class="trans" checked>Revised
					</td>
					<td width="160" class="stm">
					<input name="rdn_sts_check"  type="checkbox" value="CR"  class="trans" checked>Cancel Requested
					<td width="75"></td>
					<td width="110"><table width="99%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_UnsettledAll">Unsettled All</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
					<td width="20"></td>
					</tr> 
					
					<tr class="h23">
					<td width="70"></td>
					<td width="80"></td>
					<td width="100" class="stm">
					<input name="rdn_sts_check"  type="checkbox" value="ST"  class="trans" checked>Settled
					</td>
					<td width="130" class="stm">
					<input name="rdn_sts_check"  type="checkbox" value="CV"  class="trans" checked>Canceled(Valid)
					</td>
					<td width="140" class="stm">
					<input name="rdn_sts_check"  type="checkbox" value="CL"  class="trans" checked>Canceled</td>
					<td width="100" class="stm"></td>
					<td width="160" class="stm"></td>
					<td width="75"></td>
					<td width="110"><table width="99%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_SettledAll">Settled All</td>
						<td class="btn2_right"></td>
					</tr>
						</table></td>
					<td width="5"></td>
					<td width="20"></td>
					</tr> 
				</table>
					
				
				<!--  biz_1   (E) -->
				</td></tr>
			</table>
			<table class="height_8"><tr><td></td></tr></table>
			
			
		
		
		<!-- Grid BG Box  (S) -->
     	<table class="search" id="mainTable">
       	<tr><td class="bg">
			
				<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
			<!-- Grid (E) -->
			
			<table class="height_5"><tr><td></td></tr></table>
			
			<table width="100%" class="search" border="0">
				<tr class="h23" style="width:979">
				    <td style="width:720">
			             <table border="0" style="width:720; background-color:white;" class="grid2"> 
		    				<tr class="tr2_head">
    							<td style="width:70;" rowspan="2">Total</td>
		   						<td>RDN Count</td> 
								<td>RDN Amount (USD)</td>
								<td>Within 10 Days</td>
								<td>Within 20 Days</td>
								<td>Over 20 Days</td>
								<td>Over 20 Days(%)</td>
								
							<tr  align="center">
								<td><input type="text" name="ttl_cnt"   style="width:100; text-align: center" class="noinput" value="" readonly></td>
								<td><input type="text" name="ttl_usd_amt"   style="width:100; text-align: center" class="noinput" value="" readonly></td> 
								<td><input type="text" name="within_10_dys"   style="width:100; text-align: center" class="noinput" value="" readonly></td> 
								<td><input type="text" name="within_20_dys"   style="width:100; text-align: center" class="noinput" value="" readonly></td> 
								<td><input type="text" name="over_20_dys"   style="width:100; text-align: center" class="noinput" value="" readonly></td> 
								<td><input type="text" name="over_20_dys_rto"   style="width:100; text-align: center" class="noinput" value="" readonly></td> 
								
							</tr>
        				</table>
					</td>

                    <td style="width:19"></td>
                    <script language="javascript">ComSheetObject('sheet2');</script>
				
			</td></tr>
		</table>
	<!-- Grid BG Box  (S) -->
	<!--biz page (E)-->
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5; padding-bottom:10;"> 
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
					<td class="btn1" name="btn_DownExcel">Down&nbsp;Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<!-- td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Print">Print</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td-->
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