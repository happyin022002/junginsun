<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_LSE_0039.jsp
*@FileTitle : Off Hire Result by Location / AGMT No(Contract No.)-Option
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.15
*@LastModifier : 진준성
*@LastVersion : 1.0
* 2009.07.15 진준성
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
<%@ page import="com.hanjin.apps.alps.ees.lse.containerleasemgt.leasereport.event.EesLse0039Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesLse0039Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strPopYn         = "";
	Logger log = Logger.getLogger("com.hanjin.apps.ContainerLeaseMgt.ILeaseReport");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strPopYn = JSPUtil.getNull(request.getParameter("pop_yn"));

		event = (EesLse0039Event)request.getAttribute("Event");
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
<title>Off Hire Result by Location / AGMT No(Contract No.)-Option</title>
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
<input type="hidden" name="detail_rcc">
<input type="hidden" name="detail_agmt_cty_cd">
<input type="hidden" name="detail_agmt_seq">
<input type="hidden" name="detail_cntr_tp_sz">
<input type="hidden" name="tysz">
<table width="100%" 
<% if ( strPopYn.equals("Y") ) { %>
	class="popup" cellpadding="10" border="0"
<% } else {%>
	border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;"
<% } %>
>
	<tr><td valign="top">
		<!--Page Title, Historical (S)-->
<% if ( strPopYn.equals("Y") ) { %>
			<table width="100%" border="0">
				<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Off-Hire Result by Location and Agreement</td></tr>
			</table>
<% } else {%>
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
				<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
				<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
			</table>
<% } %>
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
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="85">Period</td>
					<td width="460">
					   <input type="text" name="period_stdt" style="width:70;ime-mode:disabled" value="" class="input1"  maxlength="8" dataformat="ymd" >&nbsp;~&nbsp;<input type="text" name="period_eddt" style="width:70;ime-mode:disabled" value="" class="input1" maxlength="8" dataformat="ymd" >&nbsp;<img class="cursor" src="img/btns_calendar.gif" name="btns_calendar2" width="19" height="20" border="0" align="absmiddle">
					</td>
					<td width="72">Company</td>
					<td style="padding-left:2;">
					  <select style="width:90;" name="company" class="input">
						<option value="" selected>ALL</option>
						<option value="H">SML</option>
						<option value="D">SEN</option>
						</select></td>
					</tr>
				</table>
			<table class="line_bluedot"><tr><td></td></tr></table>	
			<!--  biz  (S) -->
				<table class="search" border="0" bordercolor="red" style="width:979;"> 
				  <tr class="h23">
					    <td width="85">Location</td>
					    <td width="" colspan="3">
						    <select name="loc_tp"  dataformat="engup" style="width:102">
						        <option value="">ALL(by RCC)</option>
						        <option value="R">RCC(by LCC)</option>						        			
						        <option value="L">LCC(by SCC)</option>		
						        <option value="S">SCC(by Yard)</option>	
						        </select>&nbsp;<input type="text" style="width:52" name="loc_cd"  value="" class="input"  dataformat="engup" maxlength="7" fullfill>&nbsp;<img class="cursor" name="btns_search1" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle">	
					    </td>					   
					</tr>	
					<tr class="h23">
					    <td width="85">AGMT No.</td>
					    <td width="460">
						   <input type="text" style="width:72;text-align:center;" name="agmt_cty_cd" class="input2" value="HHO" maxlength="3" readonly>
					        <input type="text" style="width:82;text-align:right" name="agmt_seq"    class="input"  value="" maxlength="6" dataformat="int">
					        <img class="cursor" name="btns_search3" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle">
					        <input type="text" name="contract_no" style="width:253" class="input2" readonly>
					    </td>
					    <td width="75">Lease Term</td>
					    <td width="" style="padding-left:2">
					        <script language="javascript" >ComComboObject('combo1', 1, 190, 1 );</script>&nbsp;
					        <input type="hidden" name="lstm_cd" value="" >
						    
					    </td>
					</tr>	
					<tr class="h23">
					    <td width="85">Lessor</td>
					    <td width="460">
						    <input type="text" style="width:72" name="vndr_seq"  value="" class="input"  dataformat="int" maxlength="6" >
					        <img class="cursor" name="btns_search2" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle">				    
					        <input type="text" name="abbr_nm" style="width:59" class="input2" readonly>
					        <input type="text" name="vndr_nm" style="width:276" class="input2" readonly>	
					    </td>
					    <td width="75">TP/SZ</td>
					    <td width="" style="padding-left:2">
						    <script language="javascript" >ComComboObject('combo2', 1, 190, 1 );</script>&nbsp;
						    <input type="hidden" name="cntr_tpsz_cd" value="" >
					    </td>
					</tr>		
					<tr class="h23">
					    <td width="85">Term Change</td>
					    <td width="460">
						    <select name="term_change" style="width:102">
						       <option value="">Including</option>
						       <option value="N" selected >Excluding</option>
						       <option value="Y">Only</option>
						    </select>
					       	
					    </td>
					    <td width="75">DIO</td>
					    <td width=""><select name="dii" style="width:90">
						       <option value="" selected>Including</option>
						       <option value="N">Excluding</option>
						       <option value="Y">Only</option>
						    </select></td></tr>						
				</table>		
			
		</td></tr></table>	
			<!--  biz  1 (E) -->
		<!--biz 2 (S)-->
		<table class="height_8"><tr><td></td></tr></table>	
		<table class="search" id="mainTable"> 
       	   <tr>
       	       <td class="bg">			
		           <table class="search" border="0">
				   		
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