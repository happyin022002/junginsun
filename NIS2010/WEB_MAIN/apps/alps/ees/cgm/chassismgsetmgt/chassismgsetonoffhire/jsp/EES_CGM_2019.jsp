<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_cgm_2019.jsp
*@FileTitle : M.G.Set Sstus Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.08
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2009.06.08 최민회
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
<%@ page import="com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.event.EesCgm2019Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesCgm2019Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd        = "";
	String form_day         = "";
	Logger log = Logger.getLogger("com.hanjin.apps.ChassisMgsetMgt.ChassisMgsetOnOffhire");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
		form_day  = DateTime.getDateString().replace(".","");  


		event = (EesCgm2019Event)request.getAttribute("Event");
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
<title>;Lost/Found M.G.Set Creation</title>
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
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="yd_cd">
<input type="hidden" name="aciac_div_cd">
<input type="hidden" name="loc_cd">
<input type="hidden" name="form_day" value="<%=form_day %>">
<input type="hidden" name="sts_evnt_dt"  style="width:80;text-align:center;;text-align:center;"class="input2"  readonly="readonly" size='10'>

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
		
		<!-- Tab (S) Hire,  Other Exp,  Payment Term,  Redelivery,  CP file up, Certi File up,-->
     		
		<!-- Tab  (E) -->
		<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="88">M.G.Set No.</td>
					<td width="270"><input type="text" dataformat="engup2" name="eq_no" style="width:100;ime-mode:disabled" onkeypress="keychk();" class="input1" value="" maxlength="10"></td>
					<td width="88">Office</td>
					<td width=""><input name="ofc_cd" dataformat="engup3" type="text"  style="width:70;ime-mode:disabled;text-align:center" class="input" maxlength="6" value="<%=strOfc_cd%>">
					<img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" id="btn_popup"  name="ComOpenPopupWithTarget2"></td>
					</tr> 
				<tr class="h23">
					<td width="">Type</td>
					<td width=""><input type="text" name="eq_tpsz_cd" style="width:100;text-align:center"class="input2" value="" readonly="readonly"></td>
					<td width="">Lease Term</td>
					<td width=""><input type="text" name="agmt_lstm_cd" style="width:70;;text-align:center"class="input2" value="" readonly="readonly"></td>
					</tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="88">Lessor</td>
					<td width="">
					    <input type="text"style="width:100;;text-align:center" name="vndr_seq" class="input2" value="" readonly="readonly">&nbsp;
					    <input type="text" style="width:320;" name="vndr_lgl_eng_nm" class="input2"value="" readonly="readonly"></td>
					</tr> 	
				</table>
		
		<!-- Tab BG Box  (S) -->

		
				<!-- Grid  1(S) -->
			
			<!-- Grid 1(E) -->
			<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
			
			<table class="search_sm" border="0" style="width:520;"> 
				<tr class="h23">
					<td width="80"><input type="radio" value="L" name="yardChk" onclick="javascript:yard_Chk()" disabled class="trans" readonly="readonly" checked>Lost</td>
					<td width="80" class="stm">Lost Date</td>
					<td width="140">
					  <input type="text" name="l_evnt_dt"   maxlength='8' style="width:80;ime-mode:disabled" dataformat="ymd" class="input1"  >&nbsp;<img name="btns_Calendar1"  class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle"></td>
					                
					<td width="80" class="stm">Lost Yard</td>
					<td width=""><input type="text" dataformat="eng" maxlength="7" style="width:70;ime-mode:disabled"  class="input1" readonly="readonly" name="l_evnt_yd_cd" value="">&nbsp;<img class="cursor"  name="ComOpenPopupWithTargetYard1" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
				</tr>
				<tr class="h23">
					<td><input type="radio" value="F" class="trans" onclick="javascript:yard_Chk()" disabled name="yardChk">Found</td>
					<td class="stm">Found Date</td>
					<td><input type="text" style="width:80;ime-mode:disabled" dataformat="ymd" maxlength='8' name="f_evnt_dt" class="input1"value="">&nbsp;<img name="btns_Calendar2"  class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle"></td>
					<td class="stm">Found Yard</td>
					<td><input type="text" dataformat="engup" maxlength="7" style="width:70;ime-mode:disabled" class="input1"value="" readonly="readonly" name="f_evnt_yd_cd">&nbsp;<img class="cursor"    name="ComOpenPopupWithTargetYard2" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
				</tr>
				</table>
					
				
		

			
			<!--  Button_Sub (S) -->
			
	    	<!-- Button_Sub (E) -->
				</td>
				</tr>
			</table>
	<!-- Tab BG Box  (S) -->
	<!--biz page (E)-->
	<div id="tabLayer" style="display:none">
	
				<!-- Tab BG Box  (S) -->
				<table class="search"> 
				<tr><td class="bg">
																			
					<!-- Grid  (S) -->
						<table width="100%" class="search"  id="mainTable"> 
							<tr>
								<td width="100%">
								<script language="javascript">ComSheetObject('sheet1');</script>
								</td>
							</tr>
						</table> 				
					<!-- Grid (E) -->
	
					<!--  Grid_button (S) -->
					</td></tr>
				</table>
			<!-- Tab BG Box  (S) -->
	
			</div>
		
	
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_new">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				
	   			
		</tr>
		</table>
    <!--Button (E) -->
	</td></tr>
</table>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>