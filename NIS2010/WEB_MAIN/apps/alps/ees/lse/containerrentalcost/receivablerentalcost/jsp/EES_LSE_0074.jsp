<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_LSE_0074.jsp
*@FileTitle : EQ Receivable Charge Summary By Charge Type
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.17
*@LastModifier : 진준성
*@LastVersion : 1.0
* 2009.08.17 진준성
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
<%@ page import="com.hanjin.apps.alps.ees.lse.containerrentalcost.receivablerentalcost.event.EesLse0074Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesLse0074Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.ContainerRentalCost.ReceivableRentalCost");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EesLse0074Event)request.getAttribute("Event");
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
<title>EQ Receivable Charge Summary By Charge Type</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="/hanjin/rpt/script/rdviewer50.js"></script>
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
	<tr><td valign="top">
		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!--Page Title, Historical (E)-->
<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:;,padding-bottom:2;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="85" border="0" cellpadding="0" cellspacing="0" class="button">
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
		<!--  /td--></tr>
		</table>
    <!--Button (E) -->
	</td></tr>
</table>
		<!--biz page (S)-->
		<table class="search" id="mainTable"> 
       		<tr>
       		    <td class="bg">			
				<!--  biz  1(S) -->
				<table class="search" border="0" bordercolor="red" style="width:979;"> 
				<tr class="h23">
					<td width="100">Kind of Report</td>
					<td width="485">
					   <select style="width:178;" name="report_type" class="input1">
						<option value="rp_0074" selected>By Charge Type</option>
						<option value="rp_0075" >By TP/SZ & Month</option>						
						<option value="rp_0076" >By Charge Type & TP/SZ</option>
						<option value="rp_0077" >By Lease Term & Month</option>
						<option value="rp_0078" >By Lessee & Month</option>
						<option value="rp_0079" >Summary Receivable Charge</option>
					  </select>
					</td>	
					<td width="120">Period</td>					
					<td style="padding-left:2;" valign='Top'>	
					   <input type="text" name="temp_text1" style="width:0;" value="" >
					   <div id="fixLayer1" style="position:absolute; visibility:hidden;">
                       <table><tr><td>
					   <input type="text" name="period_stdt" style="width:54;ime-mode:disabled" value="" class="input1"  maxlength="6" dataformat="ym" >
					   <img class="cursor" src="img/btns_calendar.gif" name="btns_calendar2" width="19" height="20" border="0" align="absmiddle">
					   &nbsp;~&nbsp;
					   <input type="text" name="period_eddt" style="width:54;ime-mode:disabled" value="" class="input1" maxlength="6" dataformat="ym" >
					   <img class="cursor" src="img/btns_calendar.gif" name="btns_calendar3" width="19" height="20" border="0" align="absmiddle">
					   </td></tr></table>
					   </div>
					   <div id="fixLayer2" style="position:absolute; visibility:hidden;">
                       <table><tr><td>
					   <input type="text" name="period_year" style="width:40" value="" class="input1"  maxlength="4" dataformat="y" >
					   <img class="cursor" src="img/btns_calendar.gif" name="btns_calendar1" width="19" height="20" border="0" align="absmiddle">
					   </td></tr></table>
					   </div>				
					   <input type="text" name="temp_text2" style="width:0;" value="" >		
				    </td>
						
				</tr>				
				<tr class="h23">
					<td width="">Company</td>
					<td width="" valign='Top'>
					   <select style="width:71;" name="company" class="input">
						<option value="" >ALL</option>
						<option value="H" selected>SML</option>
						<option value="D">SEN</option>
					  </select>
					</td>
					<td width="">Receivable Amount</td>
					<td style="padding-left:8;">
					   <select style="width:110;" name="receivable" class="input">
					    <option value="T" selected>Total Amount</option>		
						<option value="A" >Actual Amount</option>										
					  </select>
				    </td>
				</tr>				
				<tr class="h23">
					<td width="">Status</td>
					<td width="" colspan="3">
					   <select style="width:71;" name="status" class="input">
						<option value="" selected>ALL</option>
						<option value="SBO">SBO</option>
						<option value="MUO">MUO</option>
					  </select>
					</td>				
				</tr>
				
				</table>
				<!--  biz  1(E) -->

		<table class="line_bluedot"><tr><td></td></tr></table>	
		<!--  biz  (E) -->
	
				<table class="search" border="0" bordercolor="red" style="width:979;"> 
				  
					<tr class="h23">
					    <td width="100">
					      AGMT No.
					    </td>
					    <td width="485">
						   <input type="text" style="width:70;text-align:center" name="agmt_cty_cd" class="input2" value="HHO" maxlength="3" readonly>
					        <input type="text" style="width:82;text-align:right" name="agmt_seq"    class="input"  value="" maxlength="6" dataformat="int">
					        <img class="cursor" name="btns_search3" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle">
					        <input type="text" name="contract_no" style="width:243" class="input2" readonly>
					    </td>
					    <td width="120">
					        Lease Term
					     </td>
					    <td style="padding-left:12;">
						    <script language="javascript" >ComComboObject('combo1', 1, 190, 1 );</script>&nbsp
					        <input type="hidden" name="lstm_cd" value="" >
						    
					    </td>
					</tr>	
					<tr class="h23">
					    <td width="100">
					       Lessee
					    </td>
					    <td width="435">
						    <input type="text" style="width:70" name="vndr_seq"  value="" class="input"  dataformat="int" maxlength="6" >
					        <img class="cursor" name="btns_search2" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle">				    
					        <input type="text" name="abbr_nm" style="width:59" class="input2" readonly>
					        <input type="text" name="vndr_nm" style="width:266" class="input2" readonly>	
					    </td>
					    <td width="120">
					        TP/SZ
					     </td>
					    <td style="padding-left:12;">
						    <script language="javascript" >ComComboObject('combo2', 1, 190, 1 );</script>&nbsp;
					        <input type="hidden" name="cntr_tpsz_cd" value="" >
					    </td>
					</tr>					
					<tr class="h23">
					    <td width="100">
					       Location
					    </td>
					    <td width="485">
						    <select name="loc_tp" dataformat="engup" style="width:72">		
						        <option value="" selected>ALL</option>					        
						        <option value="R" >RCC</option>						        			
						        <option value="L">LCC</option>		
						        <option value="S">SCC</option>								        							 
						        <option value="C">Country</option>
					        </select>
						    <input type="text" style="width:59" name="loc_cd"  value="" class="input"  dataformat="engup" maxlength="5" fullfill>
					        <img class="cursor" name="btns_search1" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle">	
					    </td>			
					   
					    <td width="120">
					        Charge Type
					     </td>
					    <td style="padding-left:12;">
						  <script language="javascript" >ComComboObject('combo3', 1, 190, 1 );</script>&nbsp;
						  <input type="hidden" name="charge_type_cd" value="" >
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
	       	           <tr>
	       	               <td class="btn2_bg">
		                       <table border="0" cellpadding="0" cellspacing="0">
		                          <tr>
		                              <td>
		                              <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						                      <tr>
						                          <td class="btn2_left"></td>
						                           <td class="btn2" name="btn_DownExcel">Down Excel</td>
						                          <td class="btn2_right"></td>
						                      </tr>
						                  </table>
		                              </td>
				                      <td>
				                          <table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
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
			       </table>
	    	       <!-- Button_Sub (E) -->
			   </td>
			</tr>
		</table>
		<!--biz page (E)-->
		
		
	
	
	
</td></tr>
		</table>


<!-- 개발자 작업  끝 -->
</form>
</body>
</html>