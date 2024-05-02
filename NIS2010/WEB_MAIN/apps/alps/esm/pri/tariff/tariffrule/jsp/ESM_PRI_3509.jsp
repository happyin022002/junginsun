<%
/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ESM_PRI_3509.jsp
*@FileTitle : Tariff Rule History
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.25
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2010.10.25 최성민
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
<%@ page import="com.hanjin.apps.alps.esm.pri.tariff.tariffrule.event.EsmPri3509Event"%>
<%@ page import="com.hanjin.framework.component.util.code.CodeInfo"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.common.PRIUtil"%>
<%@ page import="java.util.List"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmPri3509Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";

	//String[] trfRuleChgCd = null;		    //Charge Code
	//String[] trfRuleAmdtTpCd = null;		//Amend Type
	String[] trfRuleStsCd = null;		    //Status
	//String[] aproOfcCd = null;		    	//Approval Office
	String[] tariffCd = null;		    	//Tariff Code
	String trfPfxCd = "";
	String trfNo = "";
	String trfRuleNo = "";
	
	Logger log = Logger.getLogger("com.hanjin.apps.Tariff.TariffRule");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmPri3509Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		//COMMBO LIST		
		//trfRuleChgCd 	= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("TRF_RULE_CHG_CD"));
		//trfRuleAmdtTpCd = PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("TRF_RULE_AMDT_TP_CD"));
		trfRuleStsCd 	= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("TRF_RULE_STS_CD"), false);
		//aproOfcCd 		= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("APRO_OFC_CD"), false);
		tariffCd 		= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("TARIFF_CD"));
		
		trfPfxCd 		= JSPUtil.getNull(request.getParameter("trf_pfx_cd"));
		trfNo 			= JSPUtil.getNull(request.getParameter("trf_no"));
		trfRuleNo		= JSPUtil.getNull(request.getParameter("trf_rule_no"));
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Tariff Rule History</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	var trfRuleStsCdComboValue = "<%=trfRuleStsCd[0]%>";
	var trfRuleStsCdComboText = "<%=trfRuleStsCd[1]%>";
	
	var tariffCdComboValue = "<%=tariffCd[0]%>";
	var tariffCdComboText = "<%=tariffCd[1]%>";

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="trf_pfx_cd" value="<%=trfPfxCd%>">
<input type="hidden" name="trf_no" value="<%=trfNo%>">
<input type="hidden" name="trf_rule_no" value="<%=trfRuleNo%>">

<!-- 개발자 작업	-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
	<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
	<!--Page Title, Historical (E)-->
	
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:2;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><!--
		    	<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_new">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				--><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_print">Print</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				
			</tr>
			</table>
		</td></tr>
		</table>
    <!--Button (E) -->
	
	<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">
			<!--  biz_1  (S) -->
			<table class="search" border="0" style="width:979;"> 
			<tr class="h23">
				<td width="75">Tariff Code</td>
				<td width="120"><script language="javascript">ComComboObject("tariff_cd", 2, 100, 0, 1, 0, false);</script></td>
				<td width="55">Rule No.</td>
				<td width="110"><input type="text" name="rule_no" maxlength="10" style="width:90;text-align: center;" class="input" dataformat="engup" value=""></td>
				<td width="80">Search Word</td>
				<td width="160"><input type="text" name="rule_nm" maxlength="50" style="width:140;ime-mode:disabled;" class="input" dataformat="" value=""></td>
				<td width="75">Access Date</td>
				<td width="110"><input type="text" name="access_dt" style="width:80;text-align:center;" class="" value="" caption="Access Date" maxlength="10" dataformat="ymd" >
					<img src="img/btns_calendar.gif" name="btns_calendar" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
				<td width="">&nbsp;</td>
			</tr>
			</table>
			
			<!--  biz_1   (E) -->
			<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
	
			<!-- Grid  (S) -->
			<table width="100%"  id="mainTable"> 
				<tr>
					<td width="100%">
					<script language="javascript">ComSheetObject('sheet1');</script>
					</td>
				</tr>
				<tr>
					<td width="100%">
					<script language="javascript">ComSheetObject('sheet2');</script>
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
						<td class="btn2" name="btn_amendcompare">Amend Compare</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
												
				</table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->					
	    	<!-- Button_Sub (E) -->
			<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
			<!--  biz_2  (S) -->
			<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
				<td width="100%">
					  <table class="search" border="0">
				       <tr><td class="title_h"></td>
					   <td class="title_s">Rule Detail</td></tr>
				      </table>
					  <table class="search" border="0">
				       <tr><td><textarea name="rule_ctnt" id="rule_ctnt" class="" style="text-indent:0px; width:100%; height:190; font-family:Lucida Console; padding-right:500px; overflow-y:scroll;" readonly></textarea></td>
					  </tr>
				      </table>
				</td>
				</tr>	
					</table>
			</td></tr>
		</table>
	
	
	<!--  biz_1   (E) -->
	
	</td></tr>
		</table>
		
		
	<table class="height_10"><tr><td colspan="8"></td></tr></table>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>