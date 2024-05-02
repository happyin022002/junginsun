<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CIM_1049.jsp
*@FileTitle : Load Factor by Trade
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.11
*@LastModifier : 박광석
*@LastVersion : 1.0
* 2009.06.11 박광석
* 1.0 Creation
* ---------------------------------------------------------
* History
* 2010.10.18 최윤성 [CHM-201006559-01] "EMS" Trade 추가
* 2011.10.26 신자영 [CHM-201113916-01] [CIM] Load factor by cy의 sub-trade 검색 기능 추가
* 2013.01.10 신자영 [CHM-201322311-01] LOAD FACTOR BY TRADE - Bound 검색 옵션 추가
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.event.EesCim1049Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesCim1049Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strCnt_cd		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.CNTROperatioNPerformanceMgt.EQMatchBackNLoadFactorMgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strCnt_cd = account.getCnt_cd();


		event = (EesCim1049Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Load Factor by Trade</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
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
<input type="hidden" name="backendjob_key">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- print 조회용 파리미터 -->
<input type='hidden' name='prt_fromdate'>
<input type='hidden' name='prt_todate'>
<input type='hidden' name='prt_trade'>
<input type='hidden' name='prt_subtrade'>
<input type='hidden' name='prt_lane'>
<input type='hidden' name='prt_vvd'>
<input type='hidden' name='prt_company'>
<input type='hidden' name='prt_period'>
<input type="hidden" name="rpt_cnt_cd"  value="<%=strCnt_cd%>" >

<!-- 개발자 작업	-->
<input type="hidden" name="period" value="M">

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
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve" ID="btn_Retrieve">Retrieve</td>
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
					<td class="btn1" name="btn_DownExcel">Down Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Print">Print</td>
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
					<td width="55">&nbsp;Period</td>
					<td width="240">&nbsp;<input type="text" style="width:80;" class="input1" value="" name="fromdate" required dataformat="ymd" maxlength="8">&nbsp;~&nbsp;
					<input type="text" style="width:80;" class="input1" value="" name="todate" required dataformat="ymd"  maxlength="8">&nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendarto"  id="btns_calendarfm" ></td>
					<td width="40">Trade </td>
					<td width="90"><select style="width:60;" class="input" name="trade" onChange="tradeChange(this)">
						<option value="AL" selected></option>
						<option value="AA" >A</option>
						<option value="MM" >M</option>
						<option value="EE" >E</option>
						<option value="TP" >TPS</option>
						<option value="TA" >TAS</option>
						<option value="TE" >AES</option>
						<option value="EM" >EMS</option>
						</select></td>
					<td width="80">Sub Trade </td>
					<td width="90">
						<script language="javascript" >ComComboObject('subtrade', 3, 50, 0,0,1,true);</script>
						<input type="text" style="width:0" name="subtradenext">
					</td>
					<td width="45">Bound</td>
					<td width="90"><select style="width:40;" name="bound">
						<option value="" selected>All</option>
						<option value="E">E</option>
						<option value="W">W</option>
						<option value="N">N</option>
						<option value="S">S</option>
					</select></td>
					<td width="35">Lane</td>	
					<td width="90"><input type="text" style="width:40;" class="input" value="" name="lane" dataformat="engup" style="ime-mode:disabled" maxLength ="3">&nbsp;<img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_lane"></td>
					<td width="30">VVD</td>	
					<td width=""><input type="text" style="width:90;" class="input" value="" name="vvd" dataformat="engup" style="ime-mode:disabled" maxLength ="9"><!--  <input type="text" style="width:22;" class="input" value=" ">-->&nbsp;<img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_vvd"></td>
					</tr> 
				</table>
				<table class="search_sm2" border="0" style="width:502;" > 
				<tr class="h23">
					<td width="66">Company</td>
					<td width="" class="stm">&nbsp;&nbsp;<input type="radio" value="TTL" class="trans" name="company">&nbsp;&nbsp;Total&nbsp;&nbsp;&nbsp;
					<input type="radio" value="SML" class="trans" checked  name="company">&nbsp;&nbsp;SML&nbsp;&nbsp;&nbsp;
					<input type="radio" value="COS" class="trans" name="company">&nbsp;&nbsp;COS&nbsp;&nbsp;&nbsp;
					<input type="radio" value="KKL" class="trans" name="company">&nbsp;&nbsp;KKL&nbsp;&nbsp;&nbsp;
					<input type="radio" value="YML" class="trans" name="company">&nbsp;&nbsp;YML&nbsp;&nbsp;&nbsp;
					<input type="radio" value="UAC" class="trans" name="company">&nbsp;&nbsp;UASC</td>
					</tr> 
				</table>
				<!--  biz_1   (E) -->
				
				</td></tr>
			</table>
			
			<table class="height_10"><tr><td colspan="8"></td></tr></table>
		<!-- Tab (S) -->
     	
		<!-- Tab (E) -->
		<!-- Tab BG Box  (S) -->
     	<table class="search"> 
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
					
			

			<!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0"><tr>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_Rdr">RDR</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_LRange">L/Range</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
					</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
			<!--  Grid_button (S) -->
			</td></tr>
		</table>
	<!-- Tab BG Box  (S) -->
	<!--biz page (E)-->
	<!--  Button_Sub (S) -->
			
	    	<!-- Button_Sub (E) -->
<table class="height_10"><tr><td colspan="8"></td></tr></table>
	</td></tr>
</table>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>