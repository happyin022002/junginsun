<!-- =========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : COM_ENS_081.jsp
*@FileTitle : Lane 조회(공통 Popup)
*Open Issues :
*Change history :
*@LastModifyDate : 2006-08-09
*@LastModifier : Hyung Choon
*@LastVersion : 1.0
* 2006-08-09 Hyung Choon
* 1.0 최초 생성
========================================================= -->
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.bizcommon.lane.event.ComEns081Event"%>
<%
	ComEns081Event  event 				= null; 	//PDTO(Data Transfer Object including Parameters)
    Exception serverException   			= null;     //서버에서 발생한 에러
    DBRowSet rowSet      					= null; 	//DB ResultSet
    String strErrMsg 						= "";		//에러메세지
    int rowCount     						= 0;		//DB ResultSet 리스트의 건수
    String main_page = "";
    String mode								= "svc";	// Lane 구분 ( Service / Revenue) -> Default는  Service Lane

    try {
        //SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        //userId=account.getSawonNo();
        //userAuth=account.getAuth(); 
        
        
         event = (ComEns081Event)request.getAttribute("Event");
         //serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);					//	?
        		
         mode = event.getMode();
         main_page = JSPUtil.getParameter(request, "main_page".trim(), "");
         if (serverException != null) {
             strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
         }
     }catch(Exception e) {
         out.println(e.toString());
     }
%>
<html>
<head>
<title>Lane</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
        	ComShowMessage(errMessage);
        } // end if

        // InitTab();
        loadPage();
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
<input    type="hidden" name="f_cmd">
<input type="hidden" name="mode" value="<%=mode%>">
	
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
<input    type="hidden" name="f_cmd">
<input type="hidden" name="mode" value="<%=mode%>">
	
<table width="100%" class="popup" cellpadding="10">
<tr><td class="top"></td></tr>
<tr><td valign="top">

		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td height="79" class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;
<% if(mode != null && mode.equals("rev")) { %>				
				Revenue Lane Inquiry
<% } else { %>	
				Service Lane Inquiry
<% } %>
		</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
<%} %>

	
		
		<!-- TABLE '#D' : ( Search Options : Scenario ID ) (S) -->
		<table class="search"> 
			<tr>
				<td class="bg">


				<!-- : ( Scenario ID ) (S) -->
<% if(mode != null && mode.equals("rev")) { %>				
				<table class="search" border="0" style="width:735;"> 
				<tr class="h23">
					<td width="7%">Trade</td>
					<td width="12%"><input type="text" style="width:60" name="trade_cd" onKeyUp="javascript:ComKeyOnlyAlphabet('upper');"></td><!-- TPS -->
					<td width="7%">Sub Trade</td>
					<td width="14%"><input type="text" style="width:60" name="sub_trade_cd" onKeyUp="javascript:ComKeyOnlyAlphabet('upper');"></td><!-- PS -->
					<td width="6%">SVC Type</td>
					<td width="21%"><select style="width:130;" name="svc_tp">&nbsp;
						<option selected value="">ALL</option>
						<option value="I">Indepedent Join</option>
						<option value="J">Joint Operation</option>
						<option value="S">Space Charter</option>
						<option value="O">Off Lane</option>
						</select></td>
					<!-- td width="29%">
						<table class="grid2" width="160">
							<tr><td class="stm"><input type="radio" class="trans" name="lane_tp"><strong>Off Lane</strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" class="trans" name="lane_tp" checked><strong>Lane</strong></td></tr>
						</table>
					</td-->
				</tr> 
					
				<tr class="h23">
					<td >Lane Code</td>
					<td><input type="text"name="lane_cd" dataformat="engup" style="width:60;ime-mode:disabled"></td>
					<td>Lane Name</td>
					<td colspan="3"><input type="text" name="lane_nm" dataformat="engup" style="width:130;ime-mode:disabled"></td>
				</tr>				
				</table>
<% } else { %>
				<table class="search" border="0" style="width:735;"> 
				<tr class="h23">
					<td width="9%">Lane Code</td>
					<td width="12%"><input type="text" name="lane_cd" dataformat="engup" style="width:60;ime-mode:disabled"></td>
					<td width="9%">Lane Name</td>
					<td width="22%"><input type="text" name="lane_nm" dataformat="engup" style="width:130;ime-mode:disabled"></td> 
					<td width="8%">SVC Type</td>
					<td width="18%"><select style="width:120;" name="svc_tp">&nbsp;
						<option selected value="">ALL</option>
						<option value="I">Indepedent Join</option>
						<option value="J">Joint Operation</option>
						<option value="S">Space Charter</option>
						<option value="O">Off Lane</option>
						</select></td>
					<!--td width="22%">
						<table class="grid2" width="150">
							<tr><td class="stm"><input type="radio" class="trans" name="lane_tp"><strong>Off Lane</strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" class="trans" name="lane_tp" checked><strong>Lane</strong></td></tr>
						</table>
					</td-->
				</tr>
				</table>
<% } %>				
				<!-- : ( Scenario ID ) (E) -->
				
		
		<!-- TABLE '#D' : ( Search Options : Scenario ID ) (E) --> 	

		<table class="line_bluedot"><tr><td></td></tr></table>


		<!-- TABLE '#D' : ( Tab BG Box ) (S) -->
		
			
			<!-- : ( Grid ) (S) -->
			<!-- 'HEAD1-BGCOLOR : 203 240 169' , 'HEAD2-BGCOLOR : 222 251 248' , 'BORDER 1-outside : 88 152 164' , 
				 'BORDER 2-inside : 202 226 233' , 'HEAD-FONT : 39 95 101' , 'SELETED ROW BG : 252 255 233' -->
				<table width="100%" id="mainTable">
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet');</script>
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
				
			<!-- : ( Grid ) (E) -->	
		<!-- TABLE '#D' : ( Tab BG Box ) (E) -->
</td></tr>
</table> 
<!-- OUTER - POPUP (E)nd -->
</td></tr>
</table> 
<table class="height_5"><tr><td></td></tr></table> 
</td></tr>
</table> 	
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
					<%if(!main_page.equals("true")){ %>
					<td class="btn1_line"></td>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
								<td class="btn1" name="btn_Close">Close</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
					</td>
					<%} %>
				</tr>
				</table>
			</td>
			</tr>
		</table>

	</td></tr>
</table>
<!-- : ( Button : Sub ) (E) -->

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
        	
        	String trade_cd     = event.getTrade_cd();
         	String sub_trade_cd = event.getSub_tradeCd();
          	String svc_tp     	= event.getSvc_tp();
          	String lane_cd     	= event.getLane_cd();
          	String lane_nm     	= event.getLane_nm();
        %>
                
	        if(document.all.mode.value == "rev") {
	        	eval("trade_cd").value     	= "<%=trade_cd%>";
		        eval("sub_trade_cd").value 	= "<%=sub_trade_cd%>";
	        }
	        
	        eval("svc_tp").value     	= "<%=svc_tp%>";
	        eval("lane_cd").value     	= "<%=lane_cd%>";
	        eval("lane_nm").value     	= "<%=lane_nm%>";
	        
	        eval("mode").value     		= "<%=mode%>";
        <% } %>
       }
-->
</SCRIPT>
 <%@include file="../../include/common_alps.jsp"%>