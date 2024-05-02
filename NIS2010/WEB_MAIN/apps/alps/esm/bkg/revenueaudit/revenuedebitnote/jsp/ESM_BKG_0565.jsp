<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0427.jsp
*@FileTitle : RDN Performance Report
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.05
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.05.19 이승준
* 1.0 Creation
* 2013.04.24 김진주 [CHM-201324159] [BKG/DOC - Revenue Audit Systme] 수입심사 시스템 보완 요청 (김진주 수석님)
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.revenueaudit.revenuedebitnote.event.EsmBkg0565Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.util.code.CodeInfo"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.revenueauditcommon.rascommon.rascommon.vo.RsltCdListVO"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.revenueauditcommon.common.RASUtil"%>
<%@ page import="com.hanjin.framework.component.common.AbstractValueObject"%>
<%@ page import="java.util.List"%>

<%
	EsmBkg0565Event  event = null;					//PDTO(Data Transfer Object including Parameters)
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
    
	Logger log = Logger.getLogger("com.hanjin.apps.RevenueAudit.RevenueDebitNote");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		strUsr_office_cd =	account.getOfc_cd();
		//strUsr_office_nm =  account.getOfc_eng_nm();

		event = (EsmBkg0565Event)request.getAttribute("Event");
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

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>RDN Performance Report</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">

    var rhqComboValue = "|<%=rhqs[0]%>";
    var respComboValue = "<%=resp[0]%>";
    
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
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="80"><nobr>Receipt RHQ</nobr></td>
					<td width="75"><script language="javascript"> ComComboObject('rct_rhq_cd', 1, 70, 0, 0, 0, false);</script></td>
					<td width="85"><nobr>Receipt Office</nobr></td>
					<td width="75"><script language="javascript"> ComComboObject('rct_ofc_cd', 1, 70, 0, 0, 0, false);</script></td>
					<td width="105"><nobr>Responsible RHQ</nobr></td>
					<td width="75"><script language="javascript"> ComComboObject('respb_rhq_cd', 1, 70, 0, 0, 0, false);</script></td>
					<td width="110"><nobr>Responsible Office</nobr></td>
					<td width="75"><script language="javascript"> ComComboObject('respb_ofc_cd', 1, 70, 0, 0, 0, false);</script></td>
					<td width="95"><nobr>RDN Issue Date</nobr></td>
					<td width="*%">
					<nobr>
					<input name="rdn_iss_dt_from" type="text" style="width:75;text-align:center;"  value="" class="input1" caption="From Date" maxlength="10" dataformat="ymd">
					<img class="cursor" src="img/btns_calendar.gif" name="btns_calendar1" width="19" height="20" border="0" align="absmiddle"> ~
					<input name="rdn_iss_dt_to" type="text" style="width:75;text-align:center;"  value="" class="input1" caption="To Date" maxlength="10" dataformat="ymd">
					<img class="cursor" src="img/btns_calendar.gif" name="btns_calendar2" width="19" height="20" border="0" align="absmiddle">
					</nobr>
					</td></tr> 
				</table>
				
				<table class="line_bluedot"><tr><td></td></tr></table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="600">
						<table class="search_sm2" border="0" style="width:780;">
							<tr class="h23">
								<td width="40">Status</td>
								<td width="" class="stm">
									<input name="all" 			type="checkbox" value="ALL" class="trans" checked onClick="checkAll();">ALL
									<input name="rdn_sts_check" type="checkbox" value="IS" class="trans" checked>Issued
									<input name="rdn_sts_check" type="checkbox" value="AC" class="trans" checked>Accepted
									<input name="rdn_sts_check" type="checkbox" value="RR" class="trans" checked>Revise Requested
									<input name="rdn_sts_check" type="checkbox" value="RV" class="trans" checked>Revised
									<input name="rdn_sts_check" type="checkbox" value="CR" class="trans" checked>Cancel Requested
									<input name="rdn_sts_check" type="checkbox" value="ST" class="trans" checked>Settled
									<input name="rdn_sts_check" type="checkbox" value="CV" class="trans" checked>Canceled(Valid)
									<input name="rdn_sts_check" type="checkbox" value="CL" class="trans" checked>Canceled</td>
							</tr>
						</table>
					</td>
					<!-- 
					<td align="right">
					
						<table class="search_sm" border="0" style="width:290;">
							<tr class="h23">
								<td class="stm"><input name="dff_rdn_check" type="checkbox" class="trans">Including B/L Correction Amount without RDN</td>
							</tr>
						</table>
						
					</td>
					 -->
				</tr>
				</table>
				<!--  biz_1   (E) -->
				
				
				</td></tr>
			</table>
			<table class="height_8"><tr><td></td></tr></table>
			
			
	
		<!-- Grid BG Box  (S) -->
     	<table class="search" id="mainTable">
       	<tr><td class="bg">
		
				<!--  biz_2  (S) -->
				<table class="search" border="0"> 
				<tr class="h23">
					<td width="100%" class="sm">&nbsp;&nbsp;&nbsp;Currency : USD</td></tr>
				</table>
				<!--  biz_2  (E) -->
			
			
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