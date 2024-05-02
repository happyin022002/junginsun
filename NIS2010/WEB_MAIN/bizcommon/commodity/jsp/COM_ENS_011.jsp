<%--========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : COM_ENS_011.jsp
*@FileTitle : Commodity정보조회(공통 Popup)
*Open Issues :
*Change history :
*@LastModifyDate : 2006-08-03
*@LastModifier : Kildong_hong
*@LastVersion : 1.0
* 2006-08-03 Kildong_hong
* 1.0 최초 생성
=========================================================--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.bizcommon.commodity.event.ComEns011Event"%>
<%
    ComEns011Event  event = null;                //PDTO(Data Transfer Object including Parameters)
    String main_page = "";
    Exception serverException   = null;            //서버에서 발생한 에러
    DBRowSet rowSet      = null;                               //DB ResultSet
    String strErrMsg = "";                                 //에러메세지
    int rowCount     = 0;                                  //DB ResultSet 리스트의 건수
    
    try {
        event = (ComEns011Event)request.getAttribute("Event");
        main_page = JSPUtil.getParameter(request, "main_page".trim(), "");
 //       serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT); ?
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
    }catch(Exception e) {
        out.println(e.toString());
    }
%>
<html>
<head>
<title>Commodity inquiry</title>
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

<table width="100%" class="popup" cellpadding="10">
<tr><td class="top"></td></tr>
<tr><td valign="top">

		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td height="79" class="title"><img src="img/icon_title_dot.gif" align="absmiddle">	Commodity inquiry</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
<%} %>
		<!-- TABLE '#D' : ( Button : Main ) (S) -->
		
		
		
    	<!-- TABLE '#D' : ( Button : Main ) (E) -->

		<!-- TABLE '#D' : ( Search Options : Scenario ID ) (S) -->
		<table class="search">
			<tr>
				<td class="bg">


				<!-- : ( Scenario ID ) (S) -->
				<table class="search" border="0" style="width:100%;">
				<tr class="h23">
					<td width="110">Commodity Code</td>
					<td width="100"><input type="text" name="cmdt_cd" style="width:57px" dataformat="number" maxlength="6" style="ime-mode:disabled"></td>
					<td width="100">REP Commodity</td>
					<td width="80"><input type="text" name="rep_cmdt_cd" style="width:40" dataformat="number" maxlength="4" style="ime-mode:disabled"></td>
					<td width="70">IMDG Class</td>
					<td width=""><select style="width:50;" name="rep_imdg_lvl_cd">&nbsp;
						<option value="" selected>ALL</option>
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
						<option value="6">6</option>
						<option value="7">7</option>
						<option value="8">8</option>
						<option value="9">9</option>
						<option value="P">P</option>
						</select></td>
				</tr>
				</table>
				<table class="search" border="0" style="width:100%;">		
				<tr class="h23">
					<td width="65">Key Word</td>
					<td colspan="5" class="sm"><input type="text" name="cmdt_nm" style="width:445" dataformat="engup" maxlength="50" style="ime-mode:disabled"><!--input type="checkbox" value="" class="trans">Direct Search--></td></tr>
				</table>
				<!-- : ( Scenario ID ) (E) -->

			<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>

			<!-- : ( Grid ) (S) -->
				<table width="100%" id="mainTable">
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet1');</script>
                        </td></tr>
		            </table>


			<!-- : ( Grid ) (E) -->
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
		<!-- TABLE '#D' : ( Tab BG Box ) (E) -->
</td></tr>
</table> 

<table class="height_5"><tr><td></td></tr></table>

</td></tr>
</table> 

<%if(!main_page.equals("true")){ %>
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
 
  <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
        <tr><td class="btn3_bg">
      <table border="0" cellpadding="0" cellspacing="0">
      <tr>
      	<td>
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
  </table>	</td>
   		</tr>
  </table>
    <!--Button (E) -->
 
 </td></tr>
</table>
<!-- : ( Button : pop ) (E) -->
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
        	
        	String cmdtCd = event.getCmdtCd();
        	String repCmdtCd = event.getRepCmdtCd();
        	String repImdgLvlCd = event.getRepImdgLvlCd();
        	String cmdtNm = event.getCmdtNm();
        %>
	        eval("cmdt_cd").value     = "<%=cmdtCd%>";
	        eval("rep_cmdt_cd").value = "<%=repCmdtCd%>";
	        eval("rep_imdg_lvl_cd").value = "<%=repImdgLvlCd%>";
	        eval("cmdt_nm").value     = "<%=cmdtNm%>";
        
        <% } %>
       }
-->
</SCRIPT>
 <%@include file="../../include/common_alps.jsp"%>