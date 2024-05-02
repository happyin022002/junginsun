<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_scg_0060.jsp
*@FileTitle : Packing Instructions/Provisions (Inquiry)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.28
*@LastModifier : 김현욱
*@LastVersion : 1.0
* 2009.05.25 김현욱
* 1.0 Creation
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.component.util.StringUtil" %>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.event.VopScg0042Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopScg0042Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String pop_yn      		= "";
	String imdg_pck_instr_cd  = "";
	String imdg_pck_instr_seq  = "";
	Logger log = Logger.getLogger("com.hanjin.apps.SpecialCargoMasterDataMgt.SpecialCargoMasterDataMgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (VopScg0042Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		pop_yn      		= StringUtil.xssFilter(request.getParameter("pop_mode"))==null?"N":"Y";
		imdg_pck_instr_cd  	= StringUtil.xssFilter(request.getParameter("imdg_pck_instr_cd"))==null?"":StringUtil.xssFilter(request.getParameter("imdg_pck_instr_cd"));	
		imdg_pck_instr_seq  = StringUtil.xssFilter(request.getParameter("imdg_pck_instr_seq"))==null?"":StringUtil.xssFilter(request.getParameter("imdg_pck_instr_seq"));	


	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Packing Instructions/Provisions (Creation)</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">

	//팝업호출 및 초기조회조건
	var preConds = {
		pop_yn       		: "<%=pop_yn%>",
		imdg_pck_instr_cd   : "<%=imdg_pck_instr_cd%>",
		imdg_pck_instr_seq  : "<%=imdg_pck_instr_seq%>"
	}
	
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		
		if('Y' == preConds.pop_yn) {					
			//닫기버튼 보이기
			document.all.popLayer.style.display = "";
			
			//Set title of page
			var titleStr = "Packing Instructions/Provisions - Inquiry";
			try {
				var appName = navigator.appName;
			 	if (appName.indexOf("Netscape") == -1) {
			  		document.all.pophistory.innerHTML = "";
			  		document.all.title.innerHTML = '&nbsp; '+titleStr;
			  		document.title = titleStr;
			 	} else {
			  		document.getElementById("pophistory").innerHTML = "";
		  		document.getElementById("title").innerHTML = '&nbsp; '+titleStr;
			  		document.title = titleStr;
			 	}
			}catch(err) {
			 	ComShowMessage(err);
			}
		}
	
		loadPage();
	}
</script>
</head>
<!-- 개발자 작업	-->
<% if (pop_yn=="Y") { %>
<body class="popup_bg" onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="rowNo">
<table width="100%" class="popup" cellpadding="10" border="0"> 
	<tr>
		<td class="top"></td>
	</tr>
<% }else{ %>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="rowNo">

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
<% } %>
	<tr>
		<td valign="top">
			<!--top menu (S)-->
			<!--Page Title, Historical (S)-->
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
				<tr><td class="history" id="pophistory"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
				<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
			</table>
			<!--Page Title, Historical (E)-->	
			
			<!--biz page-1 (S)-->
			<table class="search"> 
	       		<tr>
	       			<td class="bg">
						<!--  biz_1  (S) -->
						<table class="search" border="0" style="width:979;"> 
							<tr class="h23">
								<td width="210">Packing Instructions/Provisions</td>
								<td width=""><input type="text" name="imdg_pck_instr_cd" style="width:70;" class="input" value="" maxlength="10" dataformat="engup"  style="ime-mode:disabled">
								             <input type="hidden" name="imdg_pck_instr_seq"  value="">
								</td>
							</tr>
						</table>
					<!--  biz_1   (E) -->				
					</td>
				</tr>
			</table>			
			<!--biz page-1 (E)-->
	
			<!-- 2 (S) -->		
			<table class="height_8"><tr><td></td></tr></table>	
			<table class="search" id="mainTable"> 
       			<tr>
       				<td class="bg" style="height:465;" valign="top">
		
						<!-- Grid - 1 (S) -->
						<table width="100%"  id="mainTable"> 
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('sheet1');</script>
								</td>
							</tr>
						</table>
						<!-- Grid - 1 (E) -->	
			
					</td>
				</tr>
			</table>
			<!--Button (S) -->
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;"> 
		       	<tr>
		       		<td class="btn1_bg">
					    <table border="0" cellpadding="0" cellspacing="0">
						    <tr>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn1_left"></td>
											<td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>	
															
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_down_excel">Down Excel</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
    		<!--Button (E) -->
		
			<!--biz page (E)-->
	
		</td>
	</tr>
</table>

<div id="popLayer" style="display:none">
<table class="height_5"><tr><td></td></tr></table>	
	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
	<tr>
		<td height="71" class="popup">
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       			<tr>
       				<td class="btn3_bg">
		    			<table border="0" cellpadding="0" cellspacing="0">
		    				<tr>
		    					<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_OK">OK</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td class="btn1_line"></td>
								<td>
									<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_Close">Close</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
    					<!--Button (E) -->
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
<!-- : ( Button : pop ) (E) -->
</div>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>
<%@include file="/bizcommon/include/common_nis2010.jsp"%>