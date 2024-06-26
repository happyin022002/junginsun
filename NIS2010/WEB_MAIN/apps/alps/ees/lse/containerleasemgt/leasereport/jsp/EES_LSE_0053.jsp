<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_LSE_0053.jsp
*@FileTitle : On-Hire Result by Lease Term/Lessor-Option
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.03
*@LastModifier : 진준성
*@LastVersion : 1.0
* 2009.08.03 진준성
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
<%@ page import="com.hanjin.apps.alps.ees.lse.containerleasemgt.leasereport.event.EesLse0053Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesLse0053Event  event = null;					//PDTO(Data Transfer Object including Parameters)
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


		event = (EesLse0053Event)request.getAttribute("Event");
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
<title>On-Hire Result by Lease Term/Lessor-Option</title>
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
<input type="hidden" name="detail_lstm_cd">
<input type="hidden" name="detail_vndr_seq">
<input type="hidden" name="detail_cntr_tpsz_cd">	
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
					<td width="80">Period</td>
					<td width="330"><input type="text" name="period_stdt" style="width:70;ime-mode:disabled" value="" class="input1"  maxlength="8" dataformat="ymd" >&nbsp;~&nbsp;<input type="text" name="period_eddt" style="width:70;ime-mode:disabled" value="" class="input1" maxlength="8" dataformat="ymd" >&nbsp;<img class="cursor" src="img/btns_calendar.gif" name="btns_calendar2" width="19" height="20" border="0" align="absmiddle">
					</td>
					<td width="80">Company</td>
					<td style="padding-left:2;">	
					 <select name="company">
					     <option value="" selected>ALL</option>
					     <option value="H">SML</option>
					     <option value="D">SEN</option>
					  </select>					 
					</td>
					</tr>
				</table>
			<table class="line_bluedot"><tr><td></td></tr></table>	
			<!--  biz  (S) -->
				<table class="search" border="0" bordercolor="red" style="width:979;">
					<tr class="h23">
					    <td width="80">Lessor</td>
					    <td width=""><input type="text" style="width:70" name="vndr_seq"  value="" class="input"  dataformat="int" maxlength="6">&nbsp;<img class="cursor" name="btns_search2" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle">&nbsp;<input type="text" name="abbr_nm" style="width:110" class="input2" readonly>&nbsp;<input type="text" name="vndr_nm" style="width:350" class="input2" readonly>	
					    </td>
					</tr></table>
					<table class="search" border="0" bordercolor="red" style="width:979;">
					<tr class="h23">
					    <td width="80">Lease Term</td>
					    <td width="330" style="padding-left:2">
						    <script language="javascript" >ComComboObject('combo1', 1, 209, 1 );</script>	
						    <input type="hidden" name="lstm_cd" value="" >				        	
					    </td>
					    <td width="80">TP/SZ</td>
					    <td width="" style="padding-left:2">
						    <script language="javascript" >ComComboObject('combo2', 1, 270, 1 );</script>
						    <input type="hidden" name="cntr_tpsz_cd" value="" >
					    </td>
					</tr>				
					<tr class="h23">
					    <td width="80">Term Change</td>
					    <td width="">
						    <select name="term_change">
						       <option value="">Including</option>
						       <option value="N" selected >Excluding</option>
						       <option value="Y">Only</option>
						    </select>
					       	
					    </td>
					    <td width="80">DIO</td>
					    <td width="">
						    <select name="dii">
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