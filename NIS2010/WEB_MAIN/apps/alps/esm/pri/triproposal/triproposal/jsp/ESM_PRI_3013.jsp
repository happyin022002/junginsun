<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_3013.jsp
*@FileTitle : TRI Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.04
*@LastModifier : 김재연
*@LastVersion : 1.0
* 2009.12.04 김재연
* 1.0 Creation
=========================================================
* History
* 2011.03.15 이행지 [CHM-201109281-01] ALPS의 Location 조회불가건 수정 보완 요청 - Location Code 중 숫자를 포함한 Code 를 조회, 입력 등 모든 부분에서 가능하도록 수정
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.triproposal.triproposal.event.EsmPri3013Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>
<%@ page import="com.hanjin.framework.component.util.code.CodeInfo"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.common.PRIUtil"%>
<%@ page import="com.hanjin.framework.component.common.AbstractValueObject"%>
<%@ page import="java.util.List"%>

<%
	EsmPri3013Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id	= "";
	String strUsr_nm	= "";
	String[] srchTrfCd	= null;
	String[] srchRatUtCd= null;
	String[] ratUtCd	= null;
	
	Logger log = Logger.getLogger("com.hanjin.apps.TRIProposal.TRIProposal");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmPri3013Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		srchTrfCd = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("trfCd"),true);
		srchRatUtCd = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("ratUtCd"),true);
		ratUtCd = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("ratUtCd"),false,"|","\t");
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>TRI Inquiry</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	var srchTrfComboValue = " |<%=srchTrfCd[0]%>";
	var srchTrfComboText = " |<%=srchTrfCd[1]%>";
	var srchRatUtComboValue = " |<%=srchRatUtCd[0]%>";
	var srchRatUtComboText = " |<%=srchRatUtCd[1]%>";
	var ratUtCdValue = " |<%=ratUtCd[0]%>";
	var ratUtCdText = " |<%=ratUtCd[1]%>";
		
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
<input type="hidden" name="srch_trf_pfx_cd">
<input type="hidden" name="srch_trf_no">
<input type="hidden" name="trf_pfx_cd">
<input type="hidden" name="trf_no">
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
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:0;">
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left">
					<td class="btn1" name="btn_Retrieve" ID="btn_Retrieve">Retrieve</td>
					<td class="btn1_right">
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left">
					<td class="btn1" name="btn_New">New</td>
					<td class="btn1_right">
					</tr>
				</table></td>
			</tr>
			</table>
		</td>
		</tr>
		</table>
    <!--Button (E) -->
	<table class="height_2"><tr><td colspan="8"></td></tr></table>
	<!--biz page (S)-->
	<table class="search">
       	<tr><td class="bg">
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="90">Tariff Code</td>
					<td width="420" style="padding-left:2px;"><script language="javascript">ComComboObject("srch_trf_cd", 2, 80, 0, 1, 0, false);</script>
					&nbsp;<input name="srch_trf_nm" type="text" style="width:298;" class="input2" value="" readonly caption="Tariff Code"></td>
					<td width="90">Access Date</td>
					<td width="120"><input type="text" name="srch_acs_dt" style="width:80;text-align:center;" class="input1" caption="Access Date" dataformat="ymd" maxLength="10" minlength="8" required>&nbsp;<img src="img/btns_calendar.gif" name="btns_calendar" width="19" height="20" alt="Access Date" border="0" align="absmiddle" class="cursor"></td>
					<td width="75">Commodity </td>
					<td width=""><input type="text" name="srch_cmdt_cd" style="width:70;text-align:center;" class="input" dataformat="int" maxlength="6" fullfill caption="Commodity Code">&nbsp;
						<img name="srch_btn_srch_cmdt" src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">&nbsp;<input name="srch_cmdt_nm" type="text" style="width:150;" class="input2" value=""></td>
				</tr></table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="35">Origin</td> <!-- //2011.03.15 이행지 [CHM-201109281-01] ALPS의 Location 조회불가건 수정 보완 요청 - Location Code 영문대문자,숫자 입력가능하도록 수정    ComKeyOnlyAlphabet('engup') -> uppernum  -->
					<td width="65"><input type="text" name="srch_org_rout_pnt_loc_nm" style="width:50;text-align:center;" class="input" dataformat="uppernum" maxlength="5" fullfill caption="Origin"></td>
					<td width="60">Origin Via</td>
					<td width="65"><input type="text" name="srch_org_rout_via_port_nm" style="width:50;text-align:center;" class="input" dataformat="uppernum" maxlength="5" fullfill caption="Origin Via."></td>
					<td width="55">Dest. Via</td>
					<td width="65"><input type="text" name="srch_dest_rout_via_port_nm" style="width:50;text-align:center;" class="input" dataformat="uppernum" maxlength="5" fullfill caption="Dest Via."></td>
					<td width="66">Destinaion</td>
					<td width="70"><input type="text" name="srch_dest_rout_pnt_loc_nm" style="width:50;text-align:center;" class="input" dataformat="uppernum" maxlength="5" fullfill caption="Destination"></td>
					<td width="140">Tariff Rate Item(TRI)</td>
					<td width="130"><input type="text" name="srch_tri_no" style="width:110;text-align:center;" class="input" dataformat="int" maxlength="15" caption="Tariff Rate Item"></td>
					<td width="55">TAA No.</td>
					<td width="110"><input type="text" name="srch_taa_no" style="width:80;text-align:center;" class="input" dataformat="engup" maxlength="10" caption="TAA Number"></td>
					<td width="25">Per</td>
					<td width=""><script language="javascript">ComComboObject('srch_rat_ut_cd', 2, 50, 1, 0);</script></td>
				</tr></table>
				<table class="line_bluedot"><tr><td></td></tr></table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="120">Additional Option</td>
					<td width="" class="stm"><input type="checkbox" name="srch_chk_taa_no" value="Y" class="trans">TAA Number</td>
				</tr></table>
				<table class="line_bluedot"><tr><td></td></tr></table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
				<td><table width="150" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_conversion">Tariff Formula Rule</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
				</tr></table>
				<!-- : ( Grid ) (S) -->
				<table width="100%"  id="mainTable"> 
				<tr>
					<td width="100%">
					<script language="javascript">ComSheetObject('sheet1');</script>
					</td>
				</tr>
				</table>
				<!-- : ( Grid ) (E) -->
				
								<!--  Button_Sub (S) -->
				<table width="100%" class="button"> 
		       	<tr>
		       		<td class="btn2_bg">
					<table border="0" cellpadding="0" cellspacing="0" align="right">
						<tr>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_downexcel">Down Excel</td>
							<td class="btn2_right"></td>
							</tr>
							</table></td>
						</tr>
					</table>
				</td>
				</tr>
				</table>
		    	<!-- Button_Sub (E) -->
				
				
				<table width="100%"  id="tempTable" style="display:none"> 
				<tr>
					<td width="100%">
					<script language="javascript">ComSheetObject('sheet2');</script>
					</td>
				</tr>
				</table>	
			</td>	
			</tr></table>
				
<!-- : ( Search Options ) (E) -->



		
</td></tr>
</table> 
	
   <table class="height_10"><tr><td colspan="8"></td></tr></table> 	
		
</td></tr>
</table> 

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>