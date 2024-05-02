<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : COM_ENS_0S1.jsp
*@FileTitle : country
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-03
*@LastModifier : Hyung Choon_Roh
*@LastVersion : 1.0
* 2006-11-03 Hyung Choon_Roh
* 1.0 최초 생성
=========================================================*/  
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.bizcommon.approval.event.ComEns0Y1Event"%>
<%
	ComEns0Y1Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	DBRowSet rowSet	  = null;							   //DB ResultSet
	String strErrMsg = "";								 //에러메세지
	int rowCount	 = 0;								  //DB ResultSet 리스트의 건수	

	try {		
	   //SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   //userId=account.getUsr_id();
	   //userAuth=account.getAuth();
		
		event = (ComEns0Y1Event)request.getAttribute("Event");
		
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Approval Inquiry</title>
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
<!-- 
showErrMessage를 써주지 않으면 에러 발생시 처리가 불가합니다.
그리고 지금은 showErrMessage()으로 되어있지만 추후에 고객님이 변덕을 일으켜서 웹페이지를 호출하라고 할경우를 
대비해서 직접 showErrMessage() 하지 마시고 꼭 showErrMessage를 써주십시오. 한방에 바꾸게요. 표준을 안따르면 나중에 후회합니다.  
-->

<body onload="javascript:setupPage();">
<form name="form">
<input type="hidden" name="f_cmd"> 
<input type="hidden" name="iPage">
<!-- BackEndJob을 위한 Field -->
<input type="hidden" name="key">

<!-- OUTER FRAME : "to make sum of components' HEIGHTS 100%" (S)tart -->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">

<!-- ################# TABLE '#A' ::: 'TOP' FRAME (START) ################## -->

<!-- Put your 'STYLESHEET' into the <HEAD> tag on the corresponding page if you make 'FRAMESET's -->


<!-- ################# TABLE '#B' ::: 'LEFT + RIGHT' FRAME (START) ################## -->
<!-- TABLE '#B' : 'Left + Right Body' Table (S)tart -->


		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!--Page Title, Historical (E)-->

	

		<!-- TABLE '#D' : ( Search Options : Scenario ID ) (S) -->
		<table class="search">
			<tr>
				<td class="bg">

				<!-- : ( Scenario ID ) (S) -->
				<table class="search" border="0" style="width:979;">
				<tr class="h23">
					<td width="50">RHQ</td>
					<td width="130"><script language="javascript">ComComboObject('ar_hd_qtr_ofc_cd', 2, 100, 0);</script></td>
					<td width="80">Office Code</td>
					<td width="140">
						<script language="javascript">ComComboObject('ofc_cd', 1, 120, 1);</script>
					</td>
					<td width="100">Effective Date</td>
					<td width="" class="stm">
						<input type="text" style="width:80;text-align:center;ime-mode:disabled" dataformat="ymd" maxlength='8' class="input"  name="inv_eff_dt" value="">&nbsp;<img class="cursor" name="btns_Calendar2" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle"></td>
					</td>
				</tr>
				<tr class="h23">
					<td width="50">Module</td>
					<td width="130"><%= com.hanjin.bizcommon.util.BizComUtil.getCodeCombo("sub_sys_cd", "", "", "SUBSYS", 1, "0: :") %></td>
					<td width="80">CSR No.</td>
					<td colspan=3 width="335"><input name="csr_no" type="text" maxlength=20 style="width:100%" value="" onBlur='this.value=this.value.trim();'></td>				
				</tr>
				</table>
				<!-- : ( Scenario ID ) (E) -->

			</tr>
		</table>
		<!-- TABLE '#D' : ( Search Options : Scenario ID ) (E) -->

		<table class="height_10"><tr><td></td></tr></table>



			<!-- Grid  (S) -->
			<table width="100%" class="search"  id="mainTable" >
				<tr>
					<td width="100%">
					<script language="javascript">ComSheetObject('sheet1');</script>
					</td>
				</tr>
			</table>
			<!-- Grid (E) -->


		<!-- ####### TABLE '#D' ::: 'RIGHT' FRAME (END) ####### -->


	</td>
</tr>
</table>
<!-- TABLE '#B' : 'Left + Right Body' Table (E)nd -->
<!-- ################# TABLE '#B' ::: 'LEFT + RIGHT' FRAME (END) ################## -->
<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>	    	
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Files" id="btn_Files">AGMT Files</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_New">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_DownExcel">Down Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				
			</tr>
			</table>
		</td></tr>
		</table>
    <!--Button (E) -->




</td></tr>


</table>
<!-- OUTER FRAME : "to make sum of components' HEIGHTS 100%" (E)nd -->
</form>
</body>
</html>
<SCRIPT LANGUAGE="javascript">
<!--
	  
	  /* 
		ibSheet 를 제외한 폼 입력값(?) 유저가 입력한 정보를 event를 통해서 다시 넘겨받아 화면에 뿌려주는 부분입니다. 
	  */
	  with(document.form)
	  {
	  	<%
		if(event != null){ 
			String frDate   = "";
			   String toDate   = "";
			   
			   java.util.Calendar calendar = java.util.Calendar.getInstance();
			   
			   String toMonth = "" + (calendar.get(java.util.Calendar.MONTH) + 1);
			   if(Integer.parseInt(toMonth) < 10)
				   toMonth = "0" + toMonth;
			   
			   String toDay = "" + calendar.get(java.util.Calendar.DATE);
			   if(Integer.parseInt(toDay) < 10)
				   toDay = "0" + toDay;
			   
			   toDate = calendar.get(java.util.Calendar.YEAR) + "-"
			   		+ toMonth + "-"
			   		+ toDay;
			   
			   calendar.add(java.util.Calendar.MONTH, -1);
			   
			   String frMonth = "" + (calendar.get(java.util.Calendar.MONTH) + 1);
			   if(Integer.parseInt(frMonth) < 10)
				   frMonth = "0" + frMonth;
			   
			   String frDay = "" + calendar.get(java.util.Calendar.DATE);
			   if(Integer.parseInt(frDay) < 10)
				   frDay = "0" + frDay;
			   
			   frDate = calendar.get(java.util.Calendar.YEAR) + "-"
		   			+ frMonth + "-"
		   			+ frDay;
		%>
		
		eval("inv_eff_dt" ).value = "<%= toDate	 %>";
		<% } %>
	   }
-->
</SCRIPT>