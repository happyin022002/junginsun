<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_JOO_0074.jsp
*@FileTitle : Estimate Performance Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.16
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2009.09.16 박희동
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
<%@ page import="com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.event.FnsJoo0074Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	FnsJoo0074Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd        = "";
	Logger log = Logger.getLogger("com.hanjin.apps.JointOperationAgreementSettlement.JointOperationAccrualCreation");
	String yyyyMM = JSPUtil.getKST("yyyy-MM");
	
	String joCrrCd = "";
	String trdCd   = "";
	String rlaneCd = "";
	String bsaTpCd = "";
	String bsaTpNm = "";
	String exeYrmon   = "";
	String revYrmonFr = "";
	String revYrmonTo = "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();


		event = (FnsJoo0074Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		joCrrCd    = eventResponse.getETCData("JO_CRR_CD");
		trdCd      = eventResponse.getETCData("TRD_CD");
		rlaneCd    = eventResponse.getETCData("RLANE_CD");
		bsaTpCd    = eventResponse.getETCData("STL_JB_COMBO");
		bsaTpNm    = eventResponse.getETCData("STL_JB_COMNM");
		exeYrmon   = eventResponse.getETCData("EXE_YRMON");
		revYrmonFr = eventResponse.getETCData("REV_YRMON_FR");
		revYrmonTo = eventResponse.getETCData("REV_YRMON_TO");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Estimate Performance Inquiry</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
var gJoCrrCd = "<%=joCrrCd%>";
var gTrdCd   = "<%=trdCd%>";
var gRlaneCd = "<%=rlaneCd%>";
var gBsaTpCd = "<%=bsaTpCd%>";
var gBsaTpNm = "<%=bsaTpNm%>";
var gYyyyMM  = "<%=yyyyMM%>";
var gExeYrmon = "<%=exeYrmon%>";
var gRevYrmonFr = "<%=revYrmonFr%>";
var gRevYrmonTo = "<%=revYrmonTo%>";

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
<input type="hidden" name="ofc_cd" value="<%=strOfc_cd%>">
<input type="hidden" name="code">
<input type="hidden" name="name">
<input type="hidden" name="super_cd1">
<input type="hidden" name="super_cd2">
<input type="hidden" name="estm_cond_flg">

<!-- 개발자 작업	-->
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
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="65">&nbsp;Month</td>
					<td width="165"><input type="text" style="width:60" class="input1" dataformat='ym' maxlength="6" name='exe_yrmon' value="<%=exeYrmon.substring(0,4)+"-"+exeYrmon.substring(4)%>">&nbsp;<img class="cursor" src="img/btns_back.gif" width="19" height="20" border="0" align="absmiddle" name="btn_exe_back">&nbsp;<img class="cursor" src="img/btns_next.gif" width="19" height="20" border="0" align="absmiddle" name="btn_exe_next"></td>
				<td width="90">Inquiry Period</td>
					<td width=""><input type="text" style="width:60" class="input1" dataformat='ym' maxlength='6' caption='Target VVD Period Start DateFormat' name='rev_yrmon_fr' value="<%=revYrmonFr.substring(0,4)+"-"+revYrmonFr.substring(4)%>" cofield="btn_vvd_from_back">&nbsp;<img class="cursor" src="img/btns_back.gif" name='btn_vvd_from_back' width="19" height="20" border="0" align="absmiddle">&nbsp;<img class="cursor" src="img/btns_next.gif"  name='btn_vvd_from_next' width="19" height="20" border="0" align="absmiddle">&nbsp;~&nbsp;<input type="text" style="width:60" class="input1"   maxlength='6'  caption='Target VVD Period End DateFormat' dataformat='ym' name='rev_yrmon_to' value="<%=revYrmonTo.substring(0,4)+"-"+revYrmonTo.substring(4)%>" cofield="btn_vvd_to_next">&nbsp;<img class="cursor" src="img/btns_back.gif"  name='btn_vvd_to_back'  width="19" height="20" border="0" align="absmiddle">&nbsp;<img class="cursor" src="img/btns_next.gif"  name='btn_vvd_to_next' width="19" height="20" border="0" align="absmiddle"></td>
				</tr></table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
						<td width="340">
							<table class="search_sm2" border="0" style="width:310;">
							<tr class="h23">
								<td width="67">Rev./Exp.</td>
								<td width=""class="noinput1">&nbsp;<input type="radio" name='re_divr_cd' value="" class="trans" checked>&nbsp;&nbsp;ALL&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" value="R" name='re_divr_cd' class="trans" >&nbsp;&nbsp;Revenue&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio"  value="E" name='re_divr_cd'  class="trans">Expense</td>
							</tr>
							</table>
					</td>
					<td width="39">Trade</td>
					<td width="90"><script language="javascript">ComComboObject('trd_cd', 1, 60, 0, 0);</script></td>
					<td width="39">Lane</td>
					<td width="90"><script language="javascript">ComComboObject('rlane_cd', 1, 70, 0, 0);</script></td>
					<td width="44">Carrier</td>
					<td width=""><script language="javascript">ComComboObject('jo_crr_cd', 1, 60, 0, 0);</script></td>
					</tr> 
				</table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="67">&nbsp;BSA Type</td>
					<td width="270"><script language="javascript">ComComboObject('jo_stl_jb_cd', 2,244, 1, 0);</script></td>
					<td width="375">
							<table class="search_sm2" border="0" style="width:330;">
							<tr>
								<td width="30"><strong>Option</strong></td>
								<td width="">&nbsp;<input type="radio" value="0" name="diff_option" class="trans" checked>ALL&nbsp;&nbsp;<input type="radio" name="diff_option" value="1" class="trans" >More Than 0&nbsp;<input type="radio" name="diff_option" value="2" class="trans" >Less or More Than 0</td>
							</tr>
							</table>
					</td>
					<td width="25">VVD</td>
					<td width=""><input type="text" style="width:100" class="input" name="vvd" maxlength="10"></td>
				</tr> 
				</table>
				
				<!--  biz_1   (E) -->
				
				</td></tr>
			</table>
			<table class="height_10"><tr><td colspan="8"></td></tr></table>
		
		<!-- Tab BG Box  (S) -->
     	<table class="search"> 
       	<tr><td class="bg">
			
			<!-- Grid  (S) -->
			<table width="100%"  id="mainTable" border="0" cellpadding="0" cellspacing="0"> 
				<tr>
					<td width="100%">
					<!--시트-->
						<script language="javascript">ComSheetObject('sheet1');</script>
					</td>
				</tr>
			</table>
			<!-- Grid (E) -->

			<!-- Grid  (S) -->
			<table width="100%"  id="mainTable" border="0" cellpadding="0" cellspacing="0"> 
				<tr>
					<td width="100%">
					<!--시트-->
						<script language="javascript">ComSheetObject('sheet2');</script>
					</td>
				</tr>
			</table>
			<!-- Grid (E) -->
			
			</td></tr>
		</table>
	<!-- Tab BG Box  (S) -->
	<!--biz page (E)-->
	
	
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_new">New</td>
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
				
			
		</td></tr>
		</table>
    <!--Button (E) -->
	</td></tr>
</table>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>