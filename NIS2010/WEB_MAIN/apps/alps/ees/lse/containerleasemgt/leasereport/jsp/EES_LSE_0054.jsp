<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_LSE_0054.jsp
*@FileTitle : Off Hire Result Vs DOL
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.05
*@LastModifier : 진준성
*@LastVersion : 1.0
* 2009.08.05 진준성
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
<%@ page import="com.hanjin.apps.alps.ees.lse.containerleasemgt.leasereport.event.EesLse0054Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesLse0054Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.ContainerLeaseMgt.LeaseReport");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EesLse0054Event)request.getAttribute("Event");
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
<title>Off Hire Result Vs DOL</title>
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
<input type="hidden" name="detail_cntr_tp_sz">
<input type="hidden" name="period_stdt" value="">
<input type="hidden" name="period_eddt" value="">
<input type="hidden" name="detail_rcc">
<input type="hidden" name="detail_scc_cd">
<input type="hidden" name="detail_agmt_seq">
<input type="hidden" name="rect_top">
<input type="hidden" name="rect_left">
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
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
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
				</tr>
			</table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
		<!--biz page (S)-->
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">			
				<!--  biz  1(S) -->
				<table class="search" border="0" bordercolor="red" style="width:979;"> 
				<tr class="h23">
					<td width="80">Year/Month</td>
					<td width="475">
					   <input type="text" name="year_month" style="width:60;ime-mode:disabled" value="" class="input1"  maxlength="6" dataformat="ym">&nbsp;<img class="cursor" src="img/btns_calendar.gif" name="btns_calendar1" width="19" height="20" border="0" align="absmiddle">					
					</td>
					<td width="80">Report Type</td>
					<td style="padding-left:2;">
					  <select name="report_type" class="input1">
					     <option value="L" selected>By Location</option>
					     <option value="A">By Agreement</option>
					  </select>
					  
					  
					   <!-- table class="search_sm2" border="0" style=""> 
							<tr class="h23">								
								<td class="stm">
								   <input type="radio" name="report_type" value="L" class="trans" checked>&nbsp;By Location&nbsp;&nbsp;
								   <input type="radio" name="report_type" value="A" class="trans">&nbsp;By Agreement&nbsp;&nbsp;
							</tr> 
						</table-->   	
					</td>
					</tr>
				</table>
			<table class="line_bluedot"><tr><td></td></tr></table>
			<!--  biz  (S) -->
				<table class="search" border="0" bordercolor="red" style="width:979;">				
					<tr class="h23">
					    <td width="80">Location</td>
					    <td width="" colspan="3">
						    <select name="loc_tp"  dataformat="engup" style="width:102">
						        <option value="R">RCC(by SCC)</option>						        			
						        <option value="S">SCC</option>	
						        </select>&nbsp;<input type="text" style="width:52" name="loc_cd"  value="" class="input"  dataformat="engup" maxlength="5" fullfill>&nbsp;<img class="cursor" name="btns_search1" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle">	
					    </td>	
					    <!--td colspan="3">
						   <input type="text" name="loc_cd" style="width:60;ime-mode:disabled"  value="" class="input" dataformat="engup" maxlength="5" fullfill>                           
                           <img class="cursor" src="img/btns_search.gif" name="btns_search1" width="19" height="20" border="0" align="absmiddle">
                           <input type="hidden" name="loc_tp" value="SCC" class="trans">
					    </td-->					  
					</tr>	
					<tr class="h23">
					    <td width="80">AGMT No.</td>
					    <td width="475">
					        <!--
					        <input type="text" style="width:60;text-align:center;" name="agmt_cty_cd" class="input2" value="HHO" maxlength="3" readonly>
					        <input type="text" style="width:82;text-align:right" name="agmt_seq"    class="input1"  value="" maxlength="6" dataformat="int">
					        <img class="cursor" name="btns_search3" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle">
					        <input type="text" name="contract_no" style="width:253" class="input2" readonly>
				            -->
					    	<table border="0">
						    <tr class="h23">
					    		<td>
						    		<input type="text" style="width:60;text-align:center;" name="agmt_cty_cd" class="input2" value="HHO" maxlength="3" readonly>
						    	</td>
								<td valign="top" id="td_agmt_seq" width="123">
					        		<div id="agmt_input" style="display:block"> 
                                    	<input type="text" name="agmt_seq" style="width:121;" class="input1" value="" readonly>
                                    </div>
                                    <div id="agmt_sheet" style="display:none;width:123px;height:8px;position:absolute;left:0px;top:0px;">
                                    	<script language="javascript">ComSheetObject('sheet3');</script>
                                    </div>
                                 </td>
                                 <td style="width:2"></td>
                                 <td width="">
                                 	<table width="125" border="0" cellpadding="0" cellspacing="0" class="button">
                                		<tr>
                                			<td class="btn2_left"></td>
                               				<td class="btn2" id="btn_agmt_seq" name="btn_agmt_seq" >Multi AGMT No.</td>
                               				<td class="btn2_right"></td>
                                		</tr>
                                	</table>
                                </td>
							</tr>        
					        </table>
					    </td>
					    <td width="80">Lease Term</td>
					    <td width="" style="padding-left:2">
						    <script language="javascript" >ComComboObject('combo1', 1, 190, 1 );</script>&nbsp;
						    <input type="hidden" name="lstm_cd" value="" >
						    
					    </td>
					</tr>	
					<tr class="h23">
					    <td width="">Lessor</td>
					    <td width="">
						    <input type="text" style="width:60" name="vndr_seq"  value="" class="input"  dataformat="int" maxlength="6" >
					        <img class="cursor" name="btns_search2" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle">				    
					        <input type="text" name="abbr_nm" style="width:59" class="input2" readonly>
					        <input type="text" name="vndr_nm" style="width:276" class="input2" readonly>	
					    </td>
					    <td width="">TP/SZ</td>
					    <td width="" style="padding-left:2">
						    <script language="javascript" >ComComboObject('combo2', 1, 190, 1 );</script>&nbsp;
						    <input type="text" name="cntr_tpsz_cd" value="" >
					    </td>
					</tr>
					<tr class="h23">
					    <td width="80">Term Change</td>
					    <td width="">
						    <select name="term_change" style="width:85">
						       <option value="">Including</option>
						       <option value="N" selected >Excluding</option>
						       <option value="Y">Only</option>
						    </select>
					       	
					    </td>
					    <td width="">DI0</td>
					    <td width="">
						    <select name="dii" style="width:85">
						       <option value="" selected>Including</option>
						       <option value="N">Excluding</option>
						       <option value="Y">Only</option>
						    </select>
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
		          	
				   <!--  biz   (E) -->
				   <!-- Grid  (S) -->
				   <table width="100%"  id="mainTable">
				       <tr>
					       <td width="100%"><script language="javascript">ComSheetObject1('sheet1');</script></td>
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
		                              </td>
				                      <td>
				                          <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						                      <tr>
						                          <td class="btn2_left"></td>
						                          <td class="btn2" name="btn_DownExcel1">Down Excel</td>
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
			   
		<!--biz page (E)-->
		<table class="height_8"><tr><td></td></tr></table>	
		<table class="line_bluedot"><tr><td></td></tr></table>
		          		
				   <!--  biz   (E) -->
				   <!-- Grid  (S) -->
				   <table width="100%"  id="mainTable">
				       <tr>
					       <td width="100%"><script language="javascript">ComSheetObject('sheet2');</script></td>
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
		                              </td>
				                      <td>
				                          <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						                      <tr>
						                          <td class="btn2_left"></td>
						                          <td class="btn2" name="btn_DownExcel2">Down Excel</td>
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
	

</td></tr>
		</table>
		<table class="height_10"><tr><td></td></tr></table>	
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>