<%--=========================================================
*	Copyright(c) 2006 CyberLogitec
*	@FileName 			: COM_ENS_021.jsp
*	@FileTitle 			: Contract No 조회
*	Open Issues 		:
*	Change history 		:
*	@LastModifyDate 	: 2006-08-18
*	@LastModifier 		: sungseok choi
*	@LastVersion 		: 1.0
* 	2006-08-11 sangyool pak
* 	1.0 최초 생성
=========================================================--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.bizcommon.contractno.event.ComEns021Event"%>

<%
    ComEns021Event  event = null;                //PDTO(Data Transfer Object including Parameters)
    GeneralEventResponse eventResponse = null;    //RDTO(Data Transfer Object including DB ResultSet)
    Exception serverException   = null;            //서버에서 발생한 에러
    DBRowSet rowSet      = null;                               //DB ResultSet
    String strErrMsg = "";                                 //에러메세지
    int rowCount     = 0;                                  //DB ResultSet 리스트의 건수
    String main_page = "";
    try {
       //SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
       //userId=account.getSawonNo();
       //userAuth=account.getAuth(); 
       
        event = (ComEns021Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        main_page = JSPUtil.getParameter(request, "main_page".trim(), "");
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }else{
        	eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
            if (eventResponse != null) {
                rowSet = eventResponse.getRs();
                if(rowSet != null){
                     rowCount = rowSet.getRowCount();
                } // end if
            } // end if
        } // end else
    }catch(Exception e) {
        out.println(e.toString());
    }
%>
<html>
<head>
<title>Contract No. Inquiry</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="/hanjin/css/alps_contents.css" type="text/css" rel="stylesheet"/>

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
<table width="100%" class="popup" cellpadding="10">
<form name="form" onkeyup="ComKeyEnter('lengthnextfocus');">
<input type="hidden" name="f_cmd">
<tr><td class="top"></td></tr>
<tr><td valign="top">

		<!-- : ( Title ) (S) -->
		<table width="735" border="0">
		<tr><td height="79" class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Contract No. Inquiry</td></tr>
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
					<td width="14%">Contract No.</td>
					<td width="38%">
						<input type="text" name="cont_tp" dataformat="engup" maxlength="3" size="3" style="width:35">&nbsp;
						<input type="text" name="cont_no" dataformat="number" maxlength="6" size="6"  style="width:65;ime-mode:disabled">
					</td>
					<td width="8%">Period</td>
					<td>
						<input type="text" style="width:75" name="sdate" maxlength="8" dataformat="ymd" caption="start년월일">
                      ~ <input type="text" style="width:75" name="edate" maxlength="8" dataformat="ymd" caption="end년월일">
                      	<img class="cursor" src="img/alps/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar1">
                    </td>
   
				</tr>
				</table>
				<table class="search" border="0" style="width:735;">
				<tr class="h23">
				<tr class="h23">
					<td width="14%">Customer Name</td>
					<td width="38%"><input type="text" name="cust_nm" dataformat="engup" maxlength="200" style="width:200"></td>
					
					<td width="8%">S Office</td>  
                    <td width="16%"><input type="text" style="width:75" name="ofc_cd" dataformat="engup"></td>
                    <td width="7%">C Office</td>  
                    <td><input type="text" style="width:75" name="ctrt_cust_sls_ofc_cd" dataformat="engup"></td>
                     
					</tr>
				</table>
				<!-- : ( Scenario ID ) (E) -->

			
		<!-- TABLE '#D' : ( Search Options : Scenario ID ) (E) -->

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
        	
        	String contTp = event.getContTp();
          	String contNo = event.getContNo();
          	String sdate   = event.getSdate();
          	String edate   = event.getEdate();
          	String custNm = event.getCustNm();
        %>
                
	        eval("cont_tp").value = "<%=contTp%>";
	        eval("cont_no").value = "<%=contNo%>";
	        eval("sdate").value   = "<%=sdate%>";
	        eval("edate").value   = "<%=edate%>";
	   
	        eval("cust_nm").value = "<%=custNm%>";
        
        <% } %>
       }
-->
</SCRIPT>
 <%@include file="../../include/common_alps.jsp"%>