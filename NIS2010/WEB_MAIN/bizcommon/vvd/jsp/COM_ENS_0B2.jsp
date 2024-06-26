<%-- =========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : COM_ENS_0B2.jsp
*@FileTitle : Vessel SKD조회(공통 Popup)
*Open Issues :
*Change history :
*@LastModifyDate : 2006-08-11
*@LastModifier : Hyunsu, Ryu
*@LastVersion : 1.0
* 2006-08-11 Hyunsu, Ryu
* 1.0 최초 생성
=========================================================
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.bizcommon.vvd.event.ComEns0B2Event"%>
<%
	ComEns0B2Event  event = null;                //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;            //서버에서 발생한 에러
    DBRowSet rowSet      = null;                               //DB ResultSet
    String strErrMsg = "";                                 //에러메세지
    int rowCount     = 0;  
    String main_page = "";
    //DB ResultSet 리스트의 건수
    
    try {
       /*
        꼭 유저의 정보를 받을 필요는 없습니다. 화면에서 유저의 이름이나 
        권한같은 정보를 이용할 필요가 있을 경우에만 사용하면 됩니다.
        덧붙여 USER 정보에 대해서 한마디로 정리하면 user 의 정보를 이용할수 있는 곳은 jsp 와 command 입니다.
        jsp에서는 유저의 정보를 가지고 권한에 따른 버튼 처리등을 할수가 있는 것이고 (enable/disable)
        command에서는 역시 유저의 정보로 예를 들어 update 권한등이 있는지를 확인할 수가 있는 것입니다.
             
        주의> 사용자 테이블이 변경됨에 따라 변경 될 것입니다.
             SignOnUserAccount 의 메서드를 확인 하십시오.
             getAuth 메서드는 현재 미정이지만 권한 관련 value를 가져올 메서드가 있겠죠?   
       */ 
       //SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
       //userId=account.getSawonNo();
       //userAuth=account.getAuth(); 
       
       
       /* 
        일단 화면에서 USER가 입력한 정보를 다시 화면에서 사용해야 하는 경우 
        request에 담아 서버로 전송시켰다가 다시 그 request에서 받아야 한다고 했습니다.
        이때 유저가 작성한 자료는 event 에 서버로부터 전송된 자료는 eventResponse에 담기게 됩니다.
        이렇게 받은 정보는 jsp 맨 하단에 있는 java script로부터 폼의 value로 값을 전달하게 됩니다.
        본 jsp소스 맨 하단을 참조하십시오.
       */
        event = (ComEns0B2Event)request.getAttribute("Event");
       /* 
         ErrorHandler를 통해서 받는 에러는 CO_ERRMESSAGE 테이블에 입력되어있는 
          개발자가 정의했거나 공통팀에서 결정한 정의가 되어진 에러메세지입니다 
          Command 에서 EventException으로 throw를 했거나 DAO에서 DAOException을 통해 
          jsp 까지 전달이 되게 됩니다. 해당 파일을 참조하십시오.
          jsp에서 최후에 에러가 display될때 onload시에 실행되는 ShowErrMessage 를 통해 showErrMessage();가 뜨게 됩니다.
          (주의) 이 에러메세지와 자바스크립트 에러를 혼동하지는 마십시오. 
                 자바스크립트 에러는 서버로 전송하기전에 "주민등록번호가 잘못되었습니다" 라는 메세지이고 
                 throw되는 메세지는 update 를 하려고 권한을 확인해보니까 없어서 
                 "해당 권한이 없습니다" 라고 뿌리는 메세지입니다.
       */
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        main_page = JSPUtil.getParameter(request, "main_page".trim(), "");
       /* 
        아래부분은 꼭 지켜주셔야 에러메세지가 정상적으로 전달이 됩니다. 
        보시다시피 먼저 에러를 받고 에러가 아닐시에 EventResponse로 값을 전달하셔야 합니다. 
       */
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
    }catch(Exception e) {
        out.println(e.toString());
    }
%>
<html>
<head>
<title>VVD</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
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



<!-- OUTER - POPUP (S)tart -->
<%if(main_page.equals("true")){ %>
<body onload="javascript:setupPage();">
<form name="form" onkeyup="ComKeyEnter('lengthnextfocus');">
<input    type="hidden" name="f_cmd">

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

<table width="100%" class="popup" cellpadding="10">
<tr><td class="top"></td></tr>
<tr><td valign="top">

		<!-- : ( Title ) (S) -->
		<table width="735" border="0">
	<tr><td height="79" class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;VVD Inquiry</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
<%} %>
		

		<!-- TABLE '#D' : ( Search Options : Scenario ID ) (S) -->
		<table class="search">
			<tr>
				<td class="bg">


				<!-- : ( Scenario ID ) (S) -->
				<table class="search" border="0" style="width:735;">
				<tr class="h23">
					<td width="8%">Lane</td>
					<td width="21%">&nbsp;<input type="text" style="width:100;ime-mode:disabled" name="lane_cd" maxlength="3" dataformat="engup"></td>
					<td width="4%">VVD</td>
					<td width="20%" style="padding-left:3"><input type="text" style="width:100;ime-mode:disabled" name="vvd_cd" maxlength="9" dataformat="engup"></td>
					<td width="5%">&nbsp;Port</td>
					<td><input type="text" style="width:100;ime-mode:disabled" name="loc_cd" maxlength="5" dataformat="engup"></td>
				</tr>
				<tr class="h23">
					<td width="8%">ETA/ETD</td>
					<td colspan=5  style="padding-left:2"><select name="etdeta" style="width:60;">
						<option value="A">ETA</option>
						<option value="D">ETD</option>
						</select>&nbsp;
						<input type="text" style="width:75" name="sdate" maxlength="8">
						 ~ 
						<input type="text" style="width:75" name="edate" maxlength="8">
						<img class="cursor" src="img/alps/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar2">
					</td>
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

			<!-- : ( Grid ) (E) -->

				</td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Tab BG Box ) (E) -->




</td></tr>
</table>
<!-- OUTER - POPUP (E)nd -->



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
        	
        	String etdeta			= event.getEtdeta();
        	String sdate 			= event.getSdate();
        	String edate			= event.getEdate();
        	String lane_cd		= event.getLane_cd();
        	String vvd_cd     = event.getVvd_cd();
        	String loc_cd			= event.getLoc_cd();

        %>
            if("<%=etdeta%>" != "") {
		        eval("etdeta").value     	= "<%=etdeta%>";
		    }
	        eval("sdate").value     	= "<%=sdate%>";
	        eval("edate").value     	= "<%=edate%>";
	        eval("lane_cd").value     = "<%=lane_cd%>";
	        eval("vvd_cd").value     	= "<%=vvd_cd%>";
	        eval("loc_cd").value     	= "<%=loc_cd%>";
        <% } %>
       }
-->
</SCRIPT>
 <%@include file="../../include/common_alps.jsp"%>