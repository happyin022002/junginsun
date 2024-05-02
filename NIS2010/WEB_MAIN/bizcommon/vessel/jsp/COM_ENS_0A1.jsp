<%--=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : COM_ENS_0A1.jsp
*@FileTitle : Vessel조회(공통 Popup)
*Open Issues :
*Change history :
*@LastModifyDate : 2006-08-02
*@LastModifier : sangyool pak
*@LastVersion : 1.0
* 2006-08-02 sangyool pak
* 1.0 최초 생성
=========================================================--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.controller.DefaultViewAdapter"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.bizcommon.vessel.event.ComEns0A1Event"%>
<%@ page import="com.hanjin.framework.component.util.io.HttpUtil"%>
<%
	ComEns0A1Event  event = null;                        //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;                    //서버에서 발생한 에러
    DBRowSet rowSet      = null;                           //DB ResultSet
    String strErrMsg = "";                                 //에러메세지
    int rowCount     = 0;                                  //DB ResultSet 리스트의 건수
    String xml = "";
    xml = HttpUtil.makeXML(request,response);
    String main_page = "";
    try {
       	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
       	event = (ComEns0A1Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);					//	?
		main_page = JSPUtil.getParameter(request, "main_page".trim(), "");
		if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
    }catch(Exception e) {
        out.println(e.toString());
    }
    
%>
<head>
<title>Vessel</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            ComShowMessage(errMessage);
        }
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
<input type="hidden" name="sXml" value="<%=xml%>">  

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
<input type="hidden" name="sXml" value="<%=xml%>">  

<table width="100%" class="popup" cellpadding="10">
<tr><td class="top"></td></tr>
<tr><td valign="top">

		<!-- : ( Title ) (S) -->
		<table width="580" border="0">
		<tr><td height="79" class="title"><img src="img/icon_title_dot.gif" align="absmiddle"> Vessel Inquiry</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
<%} %>
		


		<!-- TABLE '#D' : ( Search Options : Scenario ID ) (S) -->
		<table class="search">
			<tr>
				<td class="bg">


				<!-- : ( Scenario ID ) (S) -->
				<table class="search" border="0" style="width:580;">
				<tr class="h23">
					<td width="14%">Vessel Name</td>
					<td width="22%"><input type="text" name="vsl_eng_nm" style="width:100;ime-mode:disabled" dataformat="engup"></td>
					
					<td width="13%">Vessel Code</td>
					<td width="14%"><input type="text" name="vsl_cd" maxlength="4" style="width:50;ime-mode:disabled" dataformat="engup"></td>
					
					<td width="8%">Carrier</td>
					<td><input type="text" name="car_cd" style="width:60;ime-mode:disabled" dataformat="engup"></td>

				</tr>
				<tr class="h23">
					<td width="14%">Call Sign</td>
					<td width="22%"><input type="text" name="call_sgn_no" style="width:80;ime-mode:disabled" dataformat="engup"></td>
					
					<td width="13%">Lloyd No.</td>
					<td width="13%"><input type="text" name="lloyd_no" style="width:80;ime-mode:disabled" dataformat="engup"></td>
					
					<td ></td>

				</tr>
				</table>
				<!-- : ( Scenario ID ) (E) -->

				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>

			<!-- : ( Grid ) (S) -->
			<!-- 'HEAD1-BGCOLOR : 203 240 169' , 'HEAD2-BGCOLOR : 222 251 248' , 'BORDER 1-outside : 88 152 164' ,
				 'BORDER 2-inside : 202 226 233' , 'HEAD-FONT : 39 95 101' , 'SELETED ROW BG : 252 255 233' -->

					<table width="100%" id="mainTable">
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet1');</script>
                        </td></tr>
		            </table>
				
					<table width="100%" class="button"> 
		       		<tr><td class="btn2_bg">
					<table border="0" cellpadding="0" cellspacing="0">
							<td width="100"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn2_Down_Excel">Down Excel</td>
							<td class="btn2_right"></td>
							</tr>
							</table></td>
				</table>

		<!-- TABLE '#D' : ( Tab BG Box ) (E) -->




</td></tr>
</table>
<!-- OUTER - POPUP (E)nd -->
</td></tr>
</table>


<table class="height_5"><tr><td></td></tr></table>
</td></tr>
</table>
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
          String vsl_cd     = event.getVsl_cd();
          String vsl_eng_nm = event.getVsl_eng_nm();
          String car_cd = event.getCar_cd();
          String call_sgn_no = event.getCall_sgn_no();
          String lloyd_no = event.getLloyd_no();
        %>
                
	        eval("vsl_cd").value     = "<%=vsl_cd%>";
	        eval("vsl_eng_nm").value = "<%=vsl_eng_nm%>";
	        eval("car_cd").value = "<%=car_cd%>";
	        eval("call_sgn_no").value = "<%=call_sgn_no%>";
	        eval("lloyd_no").value = "<%=lloyd_no%>";
        
        <% } %>
       }
-->
</SCRIPT>
 <%@include file="../../include/common_alps.jsp"%>

