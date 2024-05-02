<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_lse_0047.jsp
*@FileTitle : Pick-up Status by Auth No
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.30
*@LastModifier : 진준성
*@LastVersion : 1.0
* 2009.06.30 진준성
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
<%@ page import="com.hanjin.apps.alps.ees.lse.containerleasemgt.onhireapproval.event.EesLse0047Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesLse0047Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.ContainerLeaseMgt.OnhireApproval");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EesLse0047Event)request.getAttribute("Event");
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
<title>Pick-up Status by Auth No</title>
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
<!-- 개발자 작업	-->
   <input type="hidden" name="detail_auth_no">
   <input type="hidden" name="detail_agmt_cty_cd">
   <input type="hidden" name="detail_agmt_seq">
   <input type="hidden" name="detail_cntr_tpsz_cd">
   <input type="hidden" name="detail_divsion">
   <input type="hidden" name="tysz">
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
	<!--Page Title, Historical (S)-->
	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
	</table>
	<!--Page Title, Historical (E)-->
		<!--  Button_Sub (S) -->
			<table width="100%" class="button" style="padding-top:0;padding-bottom:2;"> 
	       	<tr><td class="btn1_bg">
				<table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_New">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>			
				</tr>
			</table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
		<!--biz page (S)-->
		<table class="search" border="0" bordercolor="blue" id="mainTable"> 
       		<tr><td class="bg">			
				<!--  biz  (S) -->
				<table class="search" border="0" bordercolor="red" style="width:979;"> 
				    <tr class="h23">
					<td width="85">&nbsp;&nbsp;On-hire LOC</td>
					<td width="170">
					  <select name="loc_tp" >
						<option value="R" >RCC</option>
						<option value="L">LCC</option>								 
					  </select>&nbsp;<input type="text" style="width:76;ime-mode:disabled" name="loc_cd"  value="" class="input"  dataformat="engup" maxlength="5" fullfill>
					  <img class="cursor" name="btns_search1" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle">&nbsp;
					  
					</td>
					<td width="75">&nbsp;Balance</td>	
					<td width="250">
					  <select name="bal_tp">
						<option value="A">&nbsp;&nbsp;&nbsp;ALL&nbsp;&nbsp;&nbsp;</option>
						<option value="0">&nbsp;&nbsp;&nbsp;0</option>								 
						<option value="1">&nbsp;&nbsp;&nbsp;exist</option>								 
					  </select>
					
					</td>
					<td width="75">&nbsp;Period</td>				
					<td align="left">
					   <input type="text" name="period_stdt" style="width:80;ime-mode:disabled" value="" class="input1"  maxlength="8" dataformat="ymd" >
					   &nbsp;~&nbsp;
					   <input type="text" name="period_eddt" style="width:80;ime-mode:disabled" value="" class="input1" maxlength="8" dataformat="ymd" >
					   <img class="cursor" src="img/btns_calendar.gif" name="btns_calendar2" width="19" height="20" border="0" align="absmiddle">
					</td>
				  </tr>				
				</table>		
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>	
				<table class="search" border="0" bordercolor="red" style="width:979;"> 
				  <tr class="h23">
					<td width="85">&nbsp;&nbsp;Auth No.</td>
					<td width="170"><input type="text" style="width:150" name="auth_no" class="input" value="" dataformat="engup" ></td>					
					<td width="75">&nbsp;Lease Term</td>				
					<td width="250">
					    <script language="javascript" >ComComboObject('combo1', 1, 230, 1 );</script>&nbsp;<input type="hidden" name="lstm_cd" value="" >					
					</td>
					<td width="75">&nbsp;TP/SZ</td>
					<td style="padding-left:2;">					
					    <script language="javascript" >ComComboObject('combo2', 1, 190, 1 );</script>
					    &nbsp;<input type="hidden" name="cntr_tpsz_cd" value="" >					  
					</td>
				</tr>				
				</table>
				  <table class="search" border="0" bordercolor="red" style="width:979;"> 
				  <tr class="h23">
					<td width="85">&nbsp;&nbsp;AGMT No.</td>
					<td width="155">
					  <input type="text" style="width:45;text-align:center" name="agmt_cty_cd" class="input2" value="HHO" maxlength="3" readonly>
					  <input type="text" style="width:78;text-align:right" name="agmt_seq"    class="input"  value="" maxlength="6" dataformat="int">
					  <img class="cursor" src="img/btns_search.gif" name="btns_search2" width="19" height="20" border="0" align="absmiddle">
					</td>
					<td width="341">		
					   <input type="text" style="width:50"  name="vndr_seq"  class="input2" value="" readonly >
					   <input type="text" style="width:50"  name="vndr_abbr_nm"  class="input2" value="" readonly >
					   <input type="text" style="width:209" name="vndr_nm"  class="input2" value="" readonly >
					</td>
					<td width="74">&nbsp;Due Date</td>				
					<td align="left">
					   <input type="text" name="pkup_due_dt" style="width:80" value="" class="input" maxlength="8" dataformat="ymd" !cofield="exp_dt">
					   <img class="cursor" src="img/btns_calendar.gif" name="btns_calendar3" width="19" height="20" border="0" align="absmiddle">
					</td>
				  </tr>
				  <tr class="h23">
					
					<td width="" colspan="5" style="padding-left:2">
					    <table border="0" style="width:236;" class="search_sm2"> 
						    <tr class="h23">
						        <td width="65">&nbsp;Division</td>
							    <td width="" class="stm">
					                <input type="radio" name="new_van_tp_cd" value="" class="trans" checked>&nbsp;All&nbsp;&nbsp;
					                <input type="radio" name="new_van_tp_cd" value="N" class="trans" >&nbsp;New&nbsp;&nbsp;
					                <input type="radio" name="new_van_tp_cd" value="O" class="trans" >&nbsp;Old&nbsp;&nbsp;
					            </td>
					        </tr>
						</table>
					</td>
				   </tr>
				</table>				
				<!--  biz   (E) -->
		</td></tr></table>	
		
		<table class="height_8"><tr><td></td></tr></table>	
		<table class="search" border="0" bordercolor="red" id="mainTable"> 
       		<tr><td class="bg">	
				<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">Summary</td></tr>
				<tr><td class="height_5"></td></tr>
				</table>
			<!-- Grid  (S) -->
				<table width="100%" border="0" id="mainTable"> 
					<tr>
						<td width="100%" >
							<script language="javascript">ComSheetObject1('sheet1');</script>
						</td>
					</tr>
				</table>			
			<!-- Grid (E) -->	
			
			<!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0">
				<tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_downexcel_summary">Down Excel</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
					
					
					</tr></table>
			</td></tr>
			</table>
	    
		<!--biz page (E)-->
	

    <table class="height_8"><tr><td></td></tr></table>	

	    	<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">CNTR Detail</td></tr>
				<tr><td class="height_5"></td></tr>
				</table>								

			<!-- Grid  (S) -->
			<!-- div style="display:none;" -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet2');</script>
						</td>
					</tr>
				</table>	
			<!-- /div -->				
				<!-- Grid  (E) -->


				<!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0"><tr>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_downexcel_detail">Down Excel</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						
					</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
	    	
</td></tr>
		</table>
	
</td></tr>
</table>
 <table class="height_10"><tr><td></td></tr></table>	
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>
