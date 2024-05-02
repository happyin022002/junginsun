<%
/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EES_LSE_0110.jsp
*@FileTitle : EQ interchange Request
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.28
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2015.05.28 채창호
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
<%@ page import="com.hanjin.apps.alps.ees.lse.containerleasemgt.eqinterchangemgt.event.EesLse0110Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
	EesLse0110Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.alps.ees.lse.containerleasemgt.eqinterchangemgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EesLse0110Event)request.getAttribute("Event");
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
<title>EQ interchange Request</title>
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
<input type="hidden" name="tysz">
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
<script language="javascript" src="/hanjin/rpt/script/rdviewer50.js"></script>
	<tr><td valign="top">
		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!--Page Title, Historical (E)-->
<!--  Button_Sub (S) -->
				<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:;,padding-bottom:2;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_New">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>	
				</td>
				
		</td></tr>
		</table>
   
	</td></tr>
		</table>
		 <!--Button (E) -->
		<!--biz page (S)-->
		<table class="search" id="mainTable"> 
       		<tr>
       		    <td class="bg">			
				 <table class="search" border="0" bordercolor="red" style="width:700;"> 
				  <tr class="h23">
					<td width="70"> Offer Case</td>
					<td width="170" >
					   <select style="width:100;" name="lstm_cd" class="input1">
						<option value="OF" selected>(User)OF</option>
						<option value="SO" >(Supplier)SO</option>											
					  </select>
					</td>						
					<td width="60">Period</td>
					<td width="460">
					   <input type="text" name="period_stdt" style="width:70;ime-mode:disabled" value="" class="input1"  maxlength="8" dataformat="ymd" >&nbsp;~&nbsp;<input type="text" name="period_eddt" style="width:70;ime-mode:disabled" value="" class="input1" maxlength="8" dataformat="ymd" >&nbsp;<img class="cursor" src="img/btns_calendar.gif" name="btns_calendar2" width="19" height="20" border="0" align="absmiddle">
					</td>
					 <!--    <td width="70">AHTH. No</td>
					    <td style="padding-left:2;">
					        <script language="javascript">ComComboObject('auth_no', 1, 150, 1 ,1);</script>  
					    </td> -->
					</tr>	
				</tr>			
				</table>
				
				<table class="line_bluedot"><tr><td></td></tr></table>	
				
				 <table class="search" border="0" bordercolor="red" style="width:960;"> 
			
					<tr class="h23">
						<td width="30">From</td>
						<td width="185">
						    <select name="loc_fm_tp" style="width:53;">
						        <option value="">ALL</option>
								<option value="RCC">RCC</option>
								<option value="LCC" selected>LCC</option>
					    </select>
							<input type="text" caption="From" name="loc_fm" style="width:78;text-align:center;" class="input" value="" maxlength="5" dataformat="engup">
							<img class="cursor" name="btns_search3" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle">
						</td>
						<td width="30">To</td>
						<td width="180">
						  	<select name="loc_tp" style="width:53;">
						  	    <option value="" selected>ALL</option>
								<option value="RCC">RCC</option>
								<option value="LCC">LCC</option>
								<option value="ECC" selected>ECC</option>
								<option value="SCC">SCC</option>
								<option value="CN">CN</option>
					        </select> 
							<input type="text" caption="Location to" name="loc_to" style="width:80;text-align:center;" class="input" value="" maxlength="5" dataformat="engup">
							<img class="cursor" name="btns_search4" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle">
						</td>
    <td width="30">T/Size</td>
					    <td  width="120" style="padding-left:2;">
						    <script language="javascript" >ComComboObject('combo1', 1, 100, 1 );</script>&nbsp
					        <input type="hidden" name="tpsz_cd" value="" >
					    </td>
					    <td width="60">S/P Code</td>
					    <td width="280">
					    <input type="text" style="width:70" name="vndr_seq"  value="" class="input"  dataformat="int" maxlength="6" >
					    <img class="cursor" name="btns_search2" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle">				    
					    <!-- input type="text" name="abbr_nm" style="width:59" class="input2" readonly-->
					    <input type="text" name="vndr_nm" style="width:170" class="input2" readonly>	
					</td>
					</tr>					
				
				</table>		
			
		</td></tr></table>	
			<!--  biz  1 (E) -->
		<!--biz 2 (S)-->
		<table class="height_8"><tr><td></td></tr></table>	
		<table class="search" id="mainTable"> 
       	   <tr>
       	       <td class="bg">			
		           <!-- table class="search" bordercolor="red" border="0">
				       <tr>				       
				       <td class="title_h"></td>
					   <td class="title_s"  width="62">Total</td>
					   <td>&nbsp;<span id="Detail_text"></span></td>
					   </tr>
				   </table	-->			
				   <!--  biz   (E) -->
				   <!-- Grid  (S) -->
				   <table width="100%"  id="mainTable">
				       <tr>
					       <td width="100%"><script language="javascript">ComSheetObject('sheet1');</script></td>
						</tr>
				   </table>
			       <!-- Grid (E) -->	

				<!--  Button_Sub (S) -->
					<table width="100%" class="button">
		       		<tr><td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
						<tr>
						  	<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_downexcel">Down Excel</td>
							<td class="btn2_right"></td>
							</tr>
							</table></td>
							<!--<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_Delete">Row Delete</td>
							<td class="btn2_right"></td>
							</tr>
							</table>
							</td> -->
						</tr>			
						</table>
					</td></tr>
					</table>
		    	<!-- Button_Sub (E) -->
		    	</td>
			</tr>
		</table>
		<!--biz page (E)-->
		
		
	</td></tr>
		</table>
	
</td></tr>
		</table>
<table class="height_10"><tr><td></td></tr></table>	
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>