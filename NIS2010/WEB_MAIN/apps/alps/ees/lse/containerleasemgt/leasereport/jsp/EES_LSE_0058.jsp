<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_LSE_0058.jsp
*@FileTitle : New container Receiving Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.12
*@LastModifier : 진준성
*@LastVersion : 1.0
* 2009.08.12 진준성
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
<%@ page import="com.hanjin.apps.alps.ees.lse.containerleasemgt.leasereport.event.EesLse0058Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesLse0058Event  event = null;					//PDTO(Data Transfer Object including Parameters)
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


		event = (EesLse0058Event)request.getAttribute("Event");
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
<title>New container Receiving Inquiry</title>
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
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
    <tr>
	    <td valign="top">	
	    <!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!--Page Title, Historical (E)-->	
		<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:;,padding-bottom:2;"> 
       	<tr>
       	<td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td>
				<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
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
				</table>
				</td>
	        </tr>
		    </table>
        <!--Button (E) -->
	    </td>
        </tr>
        </table>
	    </td>
	</tr>
	<tr>
	    <td valign="top">	       
	        <!-- : ( Search Options ) (S) -->
            <table class="search"> 
       		<tr>
       		    <td class="bg">
			    <table class="search" border="0" bordercolor="red" style="width:779;"> 
				    <tr class="h23">
					    <td width="80">S/N Range</td>
					    <td width="300">
					        <input type="text" name="sn_eng_range1" style="width:40;ime-mode:disabled" value="" class="input1" maxlength="4" dataformat="engup">
					        <input type="text" name="sn_num_range1" style="width:56;ime-mode:disabled" value="" class="input1" maxlength="6" dataformat="int">
					        &nbsp;-&nbsp;
					        <input type="text" name="sn_eng_range2" style="width:40;ime-mode:disabled" value="" class="input1" maxlength="4" dataformat="engup" readonly>
					        <input type="text" name="sn_num_range2" style="width:56;ime-mode:disabled" value="" class="input1" maxlength="6" dataformat="int">&nbsp;<input type="text" name="sn_num" class="input2" style="width:50;ime-mode:disabled" readonly>
					    </td>
					    <td width="107">&nbsp;&nbsp;TP/SZ</td>
					    <td>
					        <script language="javascript" >ComComboObject('combo2', 1, 189, 1 );</script>&nbsp;
					        <input type="hidden" name="cntr_tpsz_cd" value="">
				        </td>					
				    </tr>
			    </table>
			    <table class="line_bluedot"><tr><td></td></tr></table>
			    <table class="search" border="0" bordercolor="red" style="width:779;"> 
				    <tr class="h23">
					    <td width="80">Report Type</td>
					    <td width="300">
					        <select name="report_type">
					            <option value="N">Received</option>
					            <option value="Y">Not Receiving</option>
					        </select>
					    </td>					
					    <td width="105">&nbsp;&nbsp;Receiving Date</td>
					    <td>
						    <input type="text" name="period_stdt" style="width:73" value="" class="input"  maxlength="8" dataformat="ymd" >
					        ~&nbsp;<input type="text" name="period_eddt" style="width:73" value="" class="input" maxlength="8" dataformat="ymd" >&nbsp;<img class="cursor" src="img/btns_calendar.gif" name="btns_calendar2" width="19" height="20" border="0" align="absmiddle">
                        </td>										
				    </tr>
			    </table>	
			    <!-- : ( Search Options ) (E) -->
 
			    </td>
      	    </tr>
		</table>		
	    <table class="height_8"><tr><td></td></tr></table>
	    <table class="search" id="mainTable"> 
       	   <tr>
       	       <td class="bg">			
		           <table class="search" bordercolor="red" border="0">
				       <tr>				      
				       <td class="title_h"></td> 
					   <td class="title_s"  width="200">Received Container</td>
					   <td align="right">&nbsp;<span id="Detail_text"></span>&nbsp;&nbsp;&nbsp;</td>
					   </tr>
				   </table>				
				   <!--  biz   (E) -->
				   <!-- Grid  (S) -->
				   <table width="100%"  id="mainTable">
				       <tr>
					       <td width="100%">
					           <script language="javascript">ComSheetObject('sheet1');</script>
					           <div style="display:none">
						       <script language="javascript">ComSheetObject('sheet2');</script>
					           </div>
					       </td>
				       </tr>
				   </table>
				   <!-- Grid  (e) -->		
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
						                          <td class="btn2" name="btn_DownExcel">Down Excel</td>
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
        </td>
    </tr>
</table>
	    <!--biz page (E)-->
	    
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>