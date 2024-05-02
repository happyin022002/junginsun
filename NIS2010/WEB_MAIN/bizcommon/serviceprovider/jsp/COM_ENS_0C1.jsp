<%--=========================================================
*	Copyright(c) 2006 CyberLogitec
*	@FileName 			: COM_ENS_0C1.jsp
*	@FileTitle 			: ServiceProvider정보조회(공통 Popup)
*	Open Issues 		:
*	Change history 		:
*	@LastModifyDate 	: 2006-08-07
*	@LastModifier 		: sungseok, choi
*	@LastVersion 		: 1.0
* 	2006-08-07 sungseok, choi
* 	1.0 최초 생성
=========================================================--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.bizcommon.serviceprovider.event.ComEns0C1Event"%>
<%@ page import="com.hanjin.bizcommon.serviceprovider.vo.SpListVO"%>
<%
	ComEns0C1Event  event = null;                //PDTO(Data Transfer Object including Parameters)
	SpListVO	spListVO = new SpListVO(); 
    Exception serverException   = null;            //서버에서 발생한 에러
    String strErrMsg = "";                                 //에러메세지
    int rowCount     = 0;                                  //DB ResultSet 리스트의 건수
    
    String usr_ofc_cd = "";
    String main_page = "";
    try {
    	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        //userId=account.getSawonNo();
        //userAuth=account.getAuth(); 
        usr_ofc_cd = account.getOfc_cd();
    	
        event = (ComEns0C1Event)request.getAttribute("Event");
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
<title>Service Provider</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            showErrMessage(errMessage);
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
		<table width="580" border="0">
		<tr><td height="79" class="title"><img src="img/icon_title_dot.gif" align="absmiddle"> Service Provider Inquiry</td></tr>
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
					<td width="140">Country</td>
					<td width="70">
						<input type="text" name="cnt_cd" maxlength=2 style="width:50;ime-mode:disabled" dataformat="engup">
					</td>
					<td width="140">Control Office</td>
					<td width="100">
					<input type="text" name="ofc_cd" style="width:50;ime-mode:disabled" maxlength=6 dataformat="engup">
					</td>
					<td>
						<table class="search_sm2" border="0" style="width:90%;"> 
							<tr class="h23">
								<td>S/P Type</td>
								<td class="stm"><input type="radio" name="p_sp_type" value="Y" class="trans" >Logistics&nbsp;&nbsp;&nbsp;<input type="radio" name="p_sp_type" value="" class="trans" checked="checked">All</td>
							</tr>
						</table>
					</td>
					
					</tr>
				</table>
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="140">Service Provider Code</td>
					<td width="70">
						<input type="text" name="vndr_cd" style="width:50;ime-mode:disabled" maxlength="6"></td>
					<td width="140">Service Provider Name</td>
					<td width="100">
						<input type="text" name="vndr_nm_eng" style="width:80;ime-mode:disabled"></td>
					<td>Parent Code&nbsp;
						<input type="text" name="pts_vndr_cd" style="width:50;ime-mode:disabled" maxlength="6" dataformat="number"></td></tr>
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
			<!-- : ( Grid ) (E) -->
			
				</td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Tab BG Box ) (E) -->
		<table class="height_5"><tr><td></td></tr></table>
		
</td></tr>
</table> 
<!-- OUTER - POPUP (E)nd -->

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
<form name = "form1">
<input type = "hidden" name="iPage">
</body>
</html>  
<%@include file="../../include/common_alps.jsp"%>