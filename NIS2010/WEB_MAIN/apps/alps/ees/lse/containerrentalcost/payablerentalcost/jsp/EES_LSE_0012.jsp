<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_LSE_0012.jsp
*@FileTitle : Rental payable invoice inquiry and Cancel
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.08
*@LastModifier : 진준성
*@LastVersion : 1.0
* 2009.10.08 진준성
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
<%@ page import="com.hanjin.apps.alps.ees.lse.containerrentalcost.payablerentalcost.event.EesLse0012Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
	EesLse0012Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.ContainerRentalCost.PayableRentalCost");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EesLse0012Event)request.getAttribute("Event");
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
<title>Rental payable invoice inquiry and Cancel</title>
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
				<td class="btn1_line"></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				
		</td></tr>
		</table>
   
	</td></tr>
		</table>
		 <!--Button (E) -->
		<!--biz page (S)-->
		<table class="search" id="mainTable"> 
       		<tr>
       		    <td class="bg">			
				 <table class="search" border="0" bordercolor="red" style="width:979;"> 
				  <tr class="h23">
					<td width="90"> Search Type</td>
					<td width="113" >
					   <select style="width:110;" name="search_tp" class="input1">
						<option value="01" selected>Cost Month</option>
						<option value="02" >Invoice Month</option>						
						<option value="03" >Invoice No</option>
						<option value="04" >Register No</option>						
					  </select>
					</td>					
					<td  valign='Top' colspan="2">					   
					   <div id="fixLayer1" style="position:absolute; visibility:visible;">
                       <table><tr><td>
					   <input type="text" name="cost_st_month" style="width:60;ime-mode:disabled" value="" class="input1"  maxlength="6" dataformat="ym" >&nbsp;
					   <img class="cursor" src="img/btns_calendar.gif" name="btns_calendar1" width="19" height="20" border="0" align="absmiddle">
					   &nbsp;~&nbsp;
					   <input type="text" name="cost_ed_month" style="width:60;ime-mode:disabled" value="" class="input1" maxlength="6" dataformat="ym" >&nbsp;
					   <img class="cursor" src="img/btns_calendar.gif" name="btns_calendar2" width="19" height="20" border="0" align="absmiddle">
					   </td></tr></table>
					   </div>
					   
					   <div id="fixLayer2" style="position:absolute; visibility:hidden;">
                       <table><tr><td>
					   <input type="text" name="invoice_st_month" style="width:60;ime-mode:disabled" value="" class="input1"  maxlength="6" dataformat="ym" >&nbsp;
					   <img class="cursor" src="img/btns_calendar.gif" name="btns_calendar3" width="19" height="20" border="0" align="absmiddle">
					   &nbsp;~&nbsp;
					   <input type="text" name="invoice_ed_month" style="width:60;ime-mode:disabled" value="" class="input1" maxlength="6" dataformat="ym" >&nbsp;
					   <img class="cursor" src="img/btns_calendar.gif" name="btns_calendar4" width="19" height="20" border="0" align="absmiddle">
					   </td></tr></table>
					   </div>
					   
					   <div id="fixLayer3" style="position:absolute; visibility:hidden;">
                       <table><tr><td>
					   <input type="text" name="invoice_no" style="width:100" value="" class="input1"  maxlength="20" >
					   </td></tr></table>
					   </div>					   
					   <div id="fixLayer4" style="position:absolute; visibility:hidden;">
                       <table><tr><td>
					    <input type="text" name="register_no" style="width:100" value="" class="input1"  maxlength="20" >					    
					   </td></tr></table>
					   </div>					   
					</td>		
					
				</tr>			
				</table>
				
				<table class="line_bluedot"><tr><td></td></tr></table>	
				
				 <table class="search" border="0" bordercolor="red" style="width:979;"> 
			
					<tr class="h23">
					    <td width="90">
					       Lessor
					    </td>
					    <td width="420">
						    <input type="text" style="width:70" name="vndr_seq"  value="" class="input"  dataformat="int" maxlength="6" >
					        <img class="cursor" name="btns_search2" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle">				    
					        <!-- input type="text" name="abbr_nm" style="width:59" class="input2" readonly-->
					        <input type="text" name="vndr_nm" style="width:270" class="input2" readonly>	
					    </td>
					    <td width="70">
					        Lease Term
					     </td>
					    <td  width="240" style="padding-left:2;">
						    <script language="javascript" >ComComboObject('combo1', 1, 190, 1 );</script>&nbsp
					        <input type="hidden" name="lstm_cd" value="" >
						    
					    </td>
					     <td width="80">
					        Invoice User
					     </td>
					    <td style="padding-left:2;">
						    <input type="text" name="invoice_user" style="width:80" maxlenght="20" class="input" >					        						    
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
			       <!--table width="100%" class="button"> 
	       	           <tr>
	       	               <td class="btn2_bg">
		                       <table border="0" cellpadding="0" cellspacing="0">
		                          <tr>
		                              <td>
		                              </td>
				                      <td>
				                          <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						                      <tr>
						                          <td class="btn2_left"></td>
						                          <td class="btn2" name="btn_print">Print</td>
						                          <td class="btn2_right"></td>
						                      </tr>
						                  </table>
				                      </td>
				                  </tr>
			                   </table>
			               </td>
			           </tr>
			       </table>-->
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