<!-- =========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : COM_ENS_061.jsp
*@FileTitle : Node 조회(공통 Popup)
*Open Issues :
*Change history :
*@LastModifyDate : 2006-08-17
*@LastModifier : Hyung Choon
*@LastVersion : 1.0
* 2006-08-17 Hyung Choon
* 1.0 최초 생성
=========================================================-->
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.bizcommon.node.event.ComEns061Event"%>
<%
	ComEns061Event  event = null;                //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;            //서버에서 발생한 에러
    DBRowSet rowSet      = null;                               //DB ResultSet
    String strErrMsg = "";                                 //에러메세지
    int rowCount     = 0;                                  //DB ResultSet 리스트의 건수
    String main_page = "";
    String usr_ofc_cd = "";
    
    try {
    	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        //userId=account.getSawonNo();
        //userAuth=account.getAuth(); 
        usr_ofc_cd = account.getOfc_cd();
       
       
       
        event = (ComEns061Event)request.getAttribute("Event");
        main_page = JSPUtil.getParameter(request, "main_page".trim(), "");
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
<title>Node</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
    function setupPage(ck){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
        	ComShowMessage(errMessage);
        } // end if
        // InitTab();
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
<input type="hidden" name="modeVal" value="<%=event.getMode()%>">
<input type="hidden" name="mode_only" value="<%=event.getMode_only()%>">

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
<input type="hidden" name="modeVal" value="<%=event.getMode()%>">
<input type="hidden" name="mode_only" value="<%=event.getMode_only()%>">

<table width="100%" class="popup" cellpadding="10">
<tr><td class="top"></td></tr>
<tr><td valign="top">

		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td height="79" class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Node Inquiry</td></tr>
		</table>
<%} %>
	

		<!-- TABLE '#D' : ( Search Options : Scenario ID ) (S) -->
		<table class="search">
			<tr>
				<td class="bg">


				<!-- : ( Scenario ID ) (S) -->
				<table class="search" border="0" style="width:735;">
				<tr class="h23">
			<td width="5%">Node</td>
					<td width="13%"><input type="text" name="node_cd" style="width:60;ime-mode:disabled" dataformat="engup"  maxlength="7"></td>
					<td width="10%">Node Name</td>
					<td><input type="text" name="node_nm" style="width:274;ime-mode:disabled"  dataformat="engup">&nbsp;</td>
					<td width="12%">Control Office</td>
					<td><input type="text" name="ofc_cd" style="width:68" maxlength="7" dataformat="engup" style="ime-mode:disabled"></td>		
				</tr></table>
				<table class="search" border="0" style="width:735;">
				<tr class="h23">
				<td width="5%">SCC</td>
					<td width="13%"><input type="text" name="scc_cd" style="width:60" dataformat="engup" style="ime-mode:disabled"></td>
					<td width="10%">Country</td>
					<td width="18%"><input type="text" name="cnt_cd" style="width:60" maxlength="2" dataformat="engup" style="ime-mode:disabled"></td>
					<td width="9%">Location</td>
					<td width="21%"><input type="text" name="loc_cd" style="width:75" maxlength="5" dataformat="engup" style="ime-mode:disabled"></td>
					<td>
						<table class="search_sm2" width="130" 
						<%
							if(event.getMode_only() != null && event.getMode_only().equals("Y")) {
						%>
						style="display:none"
						<%
							}
						%>
						>	<tr>
								<td>
									<input type="radio" name="mode" value="yard" class="trans" onClick="javascript:setupPage(modeVal.value=this.value)"><strong>Yard</strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="mode" value="zone" class="trans" onClick="javascript:setupPage(modeVal.value=this.value)" ><strong>Zone</strong></td>
							</tr>
						</table>
						<% 
							if(event.getMode_only() != null && event.getMode_only().equals("Y")) {
						%>
							<table width="130"><tr><td></td></tr></table>
						<%
							}
						%>
					</td>
				</tr>
				</table>
				<!-- : ( Scenario ID ) (E) -->

			
		<!-- TABLE '#D' : ( Search Options : Scenario ID ) (E) -->

		
		<!-- TABLE '#D' : ( Tab BG Box ) (S) -->
		
			<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
			<!-- : ( Grid ) (S) -->
			<table width="100%" id="mainTable" border="0">
			<tr>
				<td><script language="javascript">ComSheetObject('sheet');</script>
				</td>
			</tr>
		</table>
					
<!-- : ( Grid ) (E) -->
<!--  Button_Sub (S) -->
			<table width="100%" class="button" border="0"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0"><tr>
						<td width="100"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn2_Down_Excel">Down Excel</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td></tr>
				</table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
			
		

				</td>
			</tr>

		</table>
		<!-- TABLE '#D' : ( Tab BG Box ) (E) -->
		

<table class="height_5"><tr><td></td></tr></table>


<!-- OUTER - POPUP (E)nd -->
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
        	
        	String cnt_cd       = event.getCnt_cd();
        	String loc_cd   	= event.getLoc_cd();
        	String ofc_cd       = event.getOfc_cd();
        	String node_cd      = event.getNode_cd();
        	String node_nm      = event.getNode_nm();
        	String mode			= event.getMode();
        	
			// Office Default 세팅
        	if(!"N".equals(ofc_cd)) {
        %>
        		eval("ofc_cd").value = "<%//=usr_ofc_cd%>";
        <%
        	}
        %>
        	eval("cnt_cd").value     	= "<%=cnt_cd%>";
	        eval("loc_cd").value 		= "<%=loc_cd%>";    
	        eval("ofc_cd").value     	= "<%//=ofc_cd%>";
	        eval("node_cd").value     	= "<%=node_cd%>";
	        eval("node_nm").value     	= "<%= node_nm == null? "" :  node_nm %>";
	        
	        if("<%=mode%>" == "yard") {
	        	eval("mode")[0].checked = true;
	        } else {
	        	eval("mode")[1].checked = true;
	        }
	        
        <% } %>
       }
-->
</SCRIPT>
 <%@include file="../../include/common_alps.jsp"%>