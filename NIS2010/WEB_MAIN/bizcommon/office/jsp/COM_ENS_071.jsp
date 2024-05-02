<!--=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : COM_ENS_071.jsp
*@FileTitle : Office 조회(공통 Popup)
*Open Issues :
*Change history :
*@LastModifyDate : 2006-08-02
*@LastModifier : Hyunsu, Ryu
*@LastVersion : 1.0
* 2006-08-02 Hyunsu, Ryu
* 1.0 최초 생성
=========================================================-->
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.bizcommon.office.event.ComEns071Event"%>
<%@ page import="com.hanjin.syscommon.common.util.OrganizationUtil"%>
<%
	ComEns071Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	
	String strErrMsg = ""; //에러메세지
	String main_page = "";
	String usr_ofc_cd = "";

	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	//	usr_ofc_cd = account.getOfc_cd();
		usr_ofc_cd = (new OrganizationUtil()).getParentOffice(account.getUsr_id());
		event = (ComEns071Event) request.getAttribute("Event");

		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		main_page = JSPUtil.getParameter(request, "main_page".trim(), "");
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	} catch (Exception e) {
		out.println(e.toString());
	}
%>
<%
	/*
	  아래의 내용은 업무 공통에 필요한 값을 prefix한다. 
	 */
	String classId = JSPUtil.getParameter(request, "ClassId".trim(), "");
	String paramDisplay = JSPUtil.getParameter(request, "Display".trim(), "");
	String selectType = JSPUtil.getParameter(request, "SelectType".trim(), "");
	String callType = JSPUtil.getParameter(request, "CallType".trim(),"");
	String formNames = JSPUtil.getParameter(request,"FormNames".trim(), "");
	/*
		아래는 메인 화면에서 선택한 내용을 조회 조건으로 설정하기 위한 파라메터 값을 받는다. 
	 */
	/*String ofc_cd = JSPUtil.getParameter(request, "ofc_cd".trim(), "");
	String ofc_nm = JSPUtil.getParameter(request, "ofc_nm".trim(), "");
	String ofc_spc_level = JSPUtil.getParameter(request, "ofc_spc_level".trim(), "");
	String loc_cd = JSPUtil.getParameter(request, "loc_cd".trim(), "");
	String ofc_pts_cd = JSPUtil.getParameter(request, "ofc_pts_cd".trim(), ""); */
	
%>
<html>
<head>
<title>Office</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	function setupPage(){
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
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
<form name="form" onkeyup="ComKeyEnter('lengthnextfocus');">
<input    type="hidden" name="f_cmd">
	<tr><td valign="top">
	
		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!--Page Title, Historical (E)-->
		
<%} else { %>
<body class="popup_bg" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<table width="100%" class="popup" cellpadding="10"> 
<form name="form" onkeyup="ComKeyEnter('lengthnextfocus');">
<input    type="hidden" name="f_cmd">


<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td height="79" class="title"><img src="img/icon_title_dot.gif" align="absmiddle"> Office Inquiry</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
	<%} %>	
		
		
		<!-- TABLE '#D' : ( Search Options : Scenario ID ) (S) -->
		<table class="search"> 
			<tr>
				<td class="bg">



				<!-- : ( Scenario ID ) (S) -->
				<table class="search" border="0" style="width:100%"> 
				<tr class="h23">
					<td width="90">Location Code</td>
					<td width="100"><input type="text" name=loc_cd style="width:50;ime-mode:disabled" maxlength="5" dataformat="engup"></td>
					<td width="80">Office Level</td>
					<td width="130"><select name=ofc_lev style="width:60;">
									<option value="" selected>ALL</option>
									<option value="1">SHQ</option>
									<option value="2">RHQ</option>
									<option value="3">GOF</option>
									<option value="4">SOF</option>
									<option value="5">LOF</option>
									<option value="6">AGT</option>
						</select></td>
					<td width="90">Parent Office</td>
					<td width=""><input type="text" name=ofc_pts_cd style="width:50;ime-mode:disabled" maxlength="6" dataformat="engup"></td>
					
				</tr></table>
				<table class="search" border="0" style="width:100%"> 
				<tr class="h23">
					<td width="90">Office Code</td>
					<td width="100"><input type="text" name=ofc_cd style="width:50;ime-mode:disabled" maxlength="6" dataformat="engup"></td>
					<td width="80">Office Name</td>
					<td width=""><input type="text" name=ofc_nm style="width:270"></td>
					<!--  공통  Hidden  -->
					<input type="hidden" name=ClassId value='<%=classId%>'> 
					<input type="hidden" name=Display value='<%=paramDisplay%>'> 
					<input type="hidden" name=SelectType value='<%=selectType%>'> 
					<input type="hidden" name=CallType value='<%=callType%>'> 
					<input type="hidden" name=FormNames value='<%=formNames%>'> 
					
				</tr>
				</table>
				<!-- : ( Scenario ID ) (E) -->
				
			
		<!-- TABLE '#D' : ( Search Options : Scenario ID ) (E) --> 	

	

		<!-- TABLE '#D' : ( Tab BG Box ) (S) -->
		
			
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
<table class="height_5"><tr><td></td></tr></table>

</td></tr>
</table>
<!-- OUTER - POPUP (E)nd -->

				</td>
			</tr>
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
        <%if (event != null) {
				String loc_cd = event.getLoc_cd();
				String ofc_lev = event.getOfc_lev();

				String ofc_cd = event.getOfc_cd();
				//String ofc_nm = event.getOfc_nm();

				// Parent Office Default 세팅
       
      		if(JSPUtil.getParameter(request, "ofc_pts_cd".trim(), "").equals("ALL") ){
%>      		
      			eval("ofc_pts_cd").value     = "";
<%      		
      		}else if(!JSPUtil.getParameter(request, "ofc_pts_cd".trim(), "").equals("") ){
%>      		
      			eval("ofc_pts_cd").value     = "<%=JSPUtil.getParameter(request, "ofc_pts_cd".trim(), "")%>";
<%      		
      		}else{
%>      		
      			eval("ofc_pts_cd").value     = "<%=usr_ofc_cd%>";
<%      		
      		}
%>      		

	        eval("loc_cd").value     = "<%=loc_cd%>";
	        eval("ofc_lev").value     = "<%=ofc_lev%>";

	        eval("ofc_cd").value     = "<%=ofc_cd%>";
	        
        <%}%>
       }
-->
</SCRIPT>
 <%@include file="../../include/common_alps.jsp"%>