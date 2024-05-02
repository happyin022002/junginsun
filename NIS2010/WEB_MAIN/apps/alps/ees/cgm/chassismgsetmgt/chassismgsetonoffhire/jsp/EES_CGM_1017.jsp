<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_cgm_1017.jsp
*@FileTitle : 분실 또는 되찾은 Chassis Status를 Creation 하는 화면
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.04
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2009.06.04 최민회
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
<%@ page import="com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.event.EesCgm1017Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesCgm1017Event  event = null;					//PDTO(Data Transfer Object including Parameters)
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
		
		event = (EesCgm1017Event)request.getAttribute("Event");
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
<title>Lost/Found Chassis Creation</title>
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
<form name="form"  >
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="yd_cd">
<input type="hidden" name="aciac_div_cd">
<input type="hidden" name="loc_cd">
<input type="hidden" name="form_day" value="<%=form_day %>">
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
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">
				<!--  biz_1  (S)  -->
			
			
			<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="100">Chassis No.</td>
					<td width="190"><input name="eq_no" type="text" dataformat="engup2"  onkeypress="keychk();" style="width:100;ime-mode:disabled" class="input1" value="" maxlength="10"></td>
					<td width="80">Office</td>
					<td width=""><input name="ofc_cd" type="text" style="width:60;text-align:center;"class="input2"   readonly="readonly" value="<%=strOfc_cd%>"></td></tr>	
			</table>
			<table class="line_bluedot" border="0"><tr><td colspan="6" ></td></tr></table>	
			<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="100">Type/Size</td>
					<td width="190"><input type="text" name="eq_tpsz_cd" style="width:60;text-align:center;"class="input2" value="" readonly="readonly"></td>
					<td width="80">Lease Term</td>
					<td width="220"><input type="text" name="agmt_lstm_cd" style="width:60;text-align:center;"class="input2" value="" readonly="readonly"></td>
					<td width="45">Lessor</td>
					<td width="" colspan="3">
						<input type="text"style="width:60;text-align:center;" name="vndr_seq" class="input2" value="" readonly="readonly">&nbsp;
					    <input type="text" style="width:250;" name=vndr_lgl_eng_nm class="input2"value="" readonly="readonly"></td>
				</tr>
			</table>
			<table class="search" border="0" style="width:979;"> 
				
				<tr class="h23">
					<td width="100">Current Status</td>
					<td width="190"><input type="text" name="eq_aset_sts_cd" style="width:60;text-align:center;"class="input2" value="" readonly="readonly">
					 <input type="text" name="sts_evnt_dt"  style="width:120;text-align:center;;text-align:center;"class="input2"  readonly="readonly" size='10'>
					</td>
					<td width="170">Current Movement Status</td>
					<td width=""><input type="text" name="chss_mvmt_sts_cd" style="width:40;text-align:center;;text-align:center;"class="input2" value="" readonly="readonly">
					            <input type="text" name="mvmt_dt" style="width:120;text-align:center;;text-align:center;"class="input2"  readonly="readonly" size='10'>
					</td></tr>
			</table>
			<table class="line_bluedot" border="0"><tr><td colspan="6" ></td></tr></table>	
			<table class="search_sm2" border="0" style="width:550;"> 
				<tr class="h23">
					<td width="100"><input type="radio" value="L" name="yardChk" onclick="javascript:yard_Chk()" disabled class="trans" readonly="readonly" checked>Lost</td>
					<td width="80" class="stm">Lost Date</td>
					<td width="240">
					  <input type="text" name="l_evnt_dt"   maxlength='8' style="width:80;text-align:center;ime-mode:disabled" dataformat="ymd" class="input1"  >
					  <img name="btns_Calendar1"  class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle">
					  <input type="text" style="width:60;text-align:center;ime-mode:disabled" class="input1"  dataformat="hm" name="l_evnt_dt_hm" maxlength="4" >
					  </td>
					                
					<td width="100" class="stm">Lost Yard</td>
					<td width=""><input type="text" dataformat="eng" maxlength="7" style="width:75;text-align:center;ime-mode:disabled"  class="input1" readonly="readonly" name="l_evnt_yd_cd" value="">&nbsp;<img class="cursor"  name="ComOpenPopupWithTargetYard1" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
				</tr>
				<tr class="h23">
					<td><input type="radio" value="F" class="trans" onclick="javascript:yard_Chk()" disabled name="yardChk">Found</td>
					<td class="stm">Found Date</td>
					<td><input type="text" style="width:80;text-align:center;ime-mode:disabled" dataformat="ymd" maxlength='8' name="f_evnt_dt" class="input1"value="">
					<img name="btns_Calendar2"  class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle">
					<input type="text" style="width:60;text-align:center;ime-mode:disabled" class="input1"  dataformat="hm" name="f_evnt_dt_hm" maxlength="4" >
					</td>
					<td class="stm">Found Yard</td>
					<td><input type="text" dataformat="engup" maxlength="7" style="width:75;text-align:center;ime-mode:disabled" class="input1"value="" readonly="readonly" name="f_evnt_yd_cd">&nbsp;<img class="cursor"    name="ComOpenPopupWithTargetYard2" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
				</tr>
			</table>
			
			
			
			
				<!-- Grid  (S) -->
			
			<!-- Grid (E) -->
			<!--  Button_Sub (S) -->
			
	    	<!-- Button_Sub (E) -->
				<!--  biz_1  (E)  -->
			</td></tr>
		</table>
				
		
						
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
		
			
	<!--biz page (E)-->
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:0;"> 
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
				</tr></table>
		</td></tr>
		</table>
    <!--Button (E) -->
	</td></tr>
		</table>

 

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>