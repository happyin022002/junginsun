<%--=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : COM_ENS_051.jsp
*@FileTitle : Location조회(공통 Popup)
*Open Issues :
*Change history :
*@LastModifyDate : 2006-08-03
*@LastModifier : HyungChoonRoh
*@LastVersion : 1.0
* 2006-08-03 HyungChoonRoh
* 1.0 최초 생성
=========================================================--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.bizcommon.location.event.ComEns051Event"%>
<%
	ComEns051Event  event = null;                        //PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;                    //서버에서 발생한 에러
	String strErrMsg = "";                                 //에러메세지
	String main_page = "";
	String usr_ofc_cd = "";
	String lcc_cd = JSPUtil.getParameter(request, "lcc_cd".trim(), "");
	main_page = JSPUtil.getParameter(request, "main_page".trim(), "");
	try {
		SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
   usr_ofc_cd = account.getOfc_cd();
   event = (ComEns051Event)request.getAttribute("Event");
	
   if (serverException != null) {
      strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
	    }
	}catch(Exception e) {
		out.println(e.toString());
	} 
%>
<html>
<head>
<title>Location</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
        	ComShowMessage(errMessage);
        } // end if
        loadPage(<%=main_page%>);
    }
</script>
</head>
<!-- 
showErrMessage를 써주지 않으면 에러 발생시 처리가 불가합니다.
그리고 지금은 showErrMessage()으로 되어있지만 추후에 고객님이 변덕을 일으켜서 웹페이지를 호출하라고 할경우를 
대비해서 직접 showErrMessage() 하지 마시고 꼭 showErrMessage를 써주십시오. 한방에 바꾸게요. 표준을 안따르면 나중에 후회합니다.  
-->


<!-- OUTER - POPUP (S)tart -->
<%if(main_page.equals("true")){ %>
<body onload="javascript:setupPage();">
<form name="form" onkeyup="ComKeyEnter('lengthnextfocus');">
<input type="hidden" name="f_cmd"> 
<input type="hidden" name="lcc_cd" value="<%=lcc_cd %>"> 
<input type="hidden" name="loc_port_ind">
<input type="hidden" name="sysCode">

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
	
		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!--Page Title, Historical (E)-->
		
<%} else { %>
<body class="popup_bg" onload="javascript:setupPage();">
<form name="form" onkeyup="ComKeyEnter('lengthnextfocus');">
<input type="hidden" name="f_cmd"> 
<input type="hidden" name="lcc_cd" value="<%=lcc_cd %>"> 
<input type="hidden" name="loc_port_ind">
<input type="hidden" name="sysCode">

<table width="100%" class="popup" cellpadding="10">
<tr><td class="top"></td></tr>
<tr><td valign="top">

		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td height="79" class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Location / Port Code Inquiry</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
<%} %>
		

		<!-- TABLE '#D' : ( Search Options : Scenario ID ) (S) -->
		<table class="search">
			<tr>
				<td class="bg">
					<!-- : ( Scenario ID ) (S) -->
					<table class="search" border="0" style="width:100%;">
						<tr class="h23">
							<td width="100">Location Code</td>
						    <td width="150"><input name="loc_cd" type="text" style="width:100;ime-mode:disabled" dataformat="engup" maxlength="5"></td>
							<td width="90">RCC</td>
							<td width="100"><select name="rcc_cd">
								<option value="">All</option>
								<option value="CNSHA">CNSHA</option>
								<option value="SGSIN">SGSIN</option>
								<option value="USNYC">USNYC</option>
								<option value="JPTYO">JPTYO</option>
								<option value="KRSEL">KRSEL</option>
								<option value="DEHAM">DEHAM</option>
								<option value="TWTPE">TWTPE</option>
								<option value="CNHKG">CNHKG</option>
								</select>
							</td>
							<td width="50">Country</td>
							<td width="40"><input name="cnt_cd" type="text" style="width:30;ime-mode:disabled" dataformat="engup" maxlength="2"></td>
							<td width="60">UN Code</td>
							<td width="30"><input name="un_loc_ind_cd" type="text" style="width:20;ime-mode:disabled" dataformat="engup" maxlength="1"></td>
							<td width="50">State</td>
							<td width=""><input name="loc_state" type="text" style="width:100%;ime-mode:disabled" dataformat="engup"></td>
						</tr>
					</table>
					<table class="search" border="0" style="width:100%;">
						<tr class="h23">
							<td width="100">Location Name</td>
							<td width="150"><input name="loc_nm" type="text" style="width:100;ime-mode:disabled" dataformat="engup"></td>
							<td width="90">Control Office</td>
							<td width="100"><select name="select">
								<option value=" ">All</option>
								<option value="S">Sales</option>
								<option value="F">Finance</option>
								<option value="E">EQ-Logistics</option>
								</select>
							</td>
							<td><input name="loc_eq_ofc" type="text" style="width:100%;ime-mode:disabled" dataformat="engup" maxlength="5"></td>
						</tr>
					</table>
				
		<!-- TABLE '#D' : ( Search Options : Scenario ID ) (E) -->

	


		<!-- TABLE '#D' : ( Tab BG Box ) (S) -->
		
			<!-- : ( Grid ) (S) -->
			<!-- 'HEAD1-BGCOLOR : 203 240 169' , 'HEAD2-BGCOLOR : 222 251 248' , 'BORDER 1-outside : 88 152 164' ,
				 'BORDER 2-inside : 202 226 233' , 'HEAD-FONT : 39 95 101' , 'SELETED ROW BG : 252 255 233' -->

		<table width="100%" id="mainTable">
			<tr>
				<td><script language="javascript">ComSheetObject('sheet1');</script>
				</td>
			</tr>
		</table>

				<table width="100%" class="button"> 
		       		<tr><td class="btn2_bg">
					<table border="0" cellpadding="0" cellspacing="0"><TR>
							<td width="100"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn2_Down_Excel">Down Excel</td>
							<td class="btn2_right"></td>
							</tr>
							</table></td></TR>
					</table>
					</td></tr>
				</table>

		<!-- : ( Grid ) (E) -->
	</td></tr>
				</table>
		<!-- TABLE '#D' : ( Tab BG Box ) (E) -->
		
<table class="height_5"><tr><td></td></tr></table>
		
</td></tr>
</table>
<!-- OUTER - POPUP (E)nd -->


<%if(!main_page.equals("true")){ %>
<!-- : ( Button : Sub ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
								<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
					</td>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
								<td class="btn1" name="Code_Detall">Code Detail</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
					</td>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
								<td class="btn1" name="btn_New">New</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
					</td>
					
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
								<td class="btn1" name="btn_OK">OK</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
					</td>
					
					<td class="btn1_line"></td>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
								<td class="btn1" name="btn_Close">Close</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
					</td>
					
				</tr>
				</table>
			</td>
			</tr>
		</table>

	</td></tr>
</table>
<!-- : ( Button : Sub ) (E) -->
<%}else{ %>
<!--Button (S) -->
<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
     	<tr><td class="btn1_bg">

    <table border="0" cellpadding="0" cellspacing="0">
    <tr><td>
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
			<tr><td class="btn1_left"></td>
				<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
				<td class="btn1_right"></td>
			</tr>
		</table>
		</td>
		<td>
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
				<tr><td class="btn1_left"></td>
					<td class="btn1" name="Code_Detall">Code Detail</td>
					<td class="btn1_right"></td>
				</tr>
			</table>
		</td>
		<td>
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
			<tr><td class="btn1_left"></td>
				<td class="btn1" name="btn_New">New</td>
				<td class="btn1_right"></td>
			</tr>
		</table>
		</td>
		</tr>
	</table>
</td></tr>
</table>
<%} %>

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
        	String loc_cd     = event.getLocCd();
        	
        	String rcc_cd     = event.getRccCd();
            String cnt_cd = event.getCntCd();
            String un_loc_ind_cd     = event.getUnLocIndCd();
            String loc_nm     = event.getLocNm();
           
            String select     = event.getSelect();
            String loc_eq_ofc     = event.getLocEqOfc();
            
			// Office Default 세팅
     
        %>
            eval("loc_cd").value = "<%=loc_cd%>";
            eval("cnt_cd").value = "<%=cnt_cd%>";
            eval("un_loc_ind_cd").value = "<%=un_loc_ind_cd%>";
            eval("loc_nm").value = "<%=loc_nm%>";
            eval("select").value = "<%=select%>";
            eval("loc_eq_ofc").value = "<%=loc_eq_ofc%>";

        <% } %>
       }
-->
</SCRIPT>
 <%@include file="../../include/common_alps.jsp"%>
