<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_scg_0002.jsp
*@FileTitle : UN Number (Inquiry)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.14
*@LastModifier : 이도형
*@LastVersion : 1.0
* 2009.05.14 이도형
* 1.0 Creation
----------------------------------------------------------
* DATE       AUTHOR     CSR NO      CONTENTS
----------------------------------------------------------
  2010.07.15 원종규                                              Tec. Name 항목 제거
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
<%@ page import="com.hanjin.apps.alps.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.event.VopScg0002Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@page import="com.hanjin.framework.component.util.io.HttpUtil"%>

<%
	VopScg0002Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag 	= "";
	String codeList  	= "";
	String pageRows  	= "100";

	String strUsr_id	= "";
	String strUsr_nm	= "";
	Logger log = Logger.getLogger("com.hanjin.apps.DangerousCargoInformationMgt.IMDGCodeMgt");
	
	String pop_yn      = "";
	String imdg_un_no  = "";
	String imdg_tec_nm = "";
	
	String xml = HttpUtil.makeXML(request,response);
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
		event = (VopScg0002Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		//pop_yn      = StringUtil.xssFilter(request.getParameter("pop_mode"))==null?"N":"Y";
		pop_yn      = StringUtil.xssFilter(request.getParameter("pop_mode"))==""?"N":"Y";
		imdg_un_no  = StringUtil.xssFilter(request.getParameter("imdg_un_no"))==null?"":StringUtil.xssFilter(request.getParameter("imdg_un_no"));		
		imdg_tec_nm = StringUtil.xssFilter(request.getParameter("imdg_tec_nm"))==null?"":StringUtil.xssFilter(request.getParameter("imdg_tec_nm"));
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>UN Number (Inquiry)</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	
	//팝업호출 및 초기조회조건
	var preConds = {
		pop_yn       : "<%=pop_yn%>",
		imdg_un_no   : "<%=imdg_un_no%>",
		imdg_tec_nm  : "<%=imdg_tec_nm%>"
	}
	
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		
		if('Y' == preConds.pop_yn) {		
			//닫기버튼 보이기
			document.all.popLayer.style.display = "";

			try {
				var appName = navigator.appName;
			 	if (appName.indexOf("Netscape") == -1) {
			  		document.all.pophistory.innerHTML = "";
			 	} else {
			  		document.getElementById("pophistory").innerHTML = "";
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
<input type="hidden" name="pagerows" value="100">
<input type="hidden" name="page_no" value="1">
<input type="hidden" name="sXml" value="<%=xml%>">
<table width="100%" class="popup" cellpadding="10" border="0"> 
	<tr>
		<td class="top"></td>
	</tr>
<% }else{ %>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows" value="100">
<input type="hidden" name="page_no" value="1">
<input type="hidden" name="sXml" value="<%=xml%>">
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
<% } %>
	<tr>
		<td valign="top">
			<!--Page Title, Historical (S)-->
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
				<tr><td class="history" id="pophistory"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
				<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
			</table>
			<!--Page Title, Historical (E)-->
	 
			<!--biz page (S)-->
			<table class="search"> 
		       	<tr>
		       		<td class="bg">
						<!--  biz_1  (S) -->
						<table class="search" border="0" style="width:100%;"> 
							<tr class="h23">
								<td width="50">UN No.</td>
								<td width="95"><input type="text" name="imdg_un_no" caption="UN No." maxlength="4" style="width:50;ime-mode:disabled;" class="input" value=""></td>
								<td width="100">Class or division</td>
								<td width="150">
							   		<script language="javascript">ComComboObject('imdg_clss_cd', 1, 60, 0, 0);</script>&nbsp;
							   		<script language="javascript">ComComboObject('imdg_comp_grp_cd', 1, 40, 0);</script>
								</td>
								<td width="80">Restrictions</td> 
								<td width="">
									<select name="imdg_crr_rstr_expt_cd" style="width:216;" class="input">
										<option value="">All</option>
										<option value="N">None</option>
										<option value="P">Prohibited</option>
										<option value="R">Restricted</option>
										<option value="C">Excepted fm Class Prohibition</option>
										<option value="T">T/S Prohibited</option>
										<option value="L">Prohibited on Lane</option>
									</select>
								</td>
							</tr> 
							<tr class="h23">
								<td colspan="2">Proper Shipping Name</td>
								<td colspan="4"><input type="text" name="imdg_tec_nm" caption="Proper Shipping Name" style="width:100%;ime-mode:disabled;" class="input" value=""></td>
							</tr>
						</table>
						<!--  biz_1   (E) -->				
					</td>
				</tr>
			</table>
			
			<table class="height_8"><tr><td></td></tr></table>

			<table class="search" id="mainTable"> 
	     		<tr>
	     			<td class="bg"  style="height:442;" valign="top">			
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
			
<table class="height_5"><tr><td></td></tr></table>
			<!--Button (S) -->
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;"> 
	       		<tr>
	       			<td class="btn1_bg">
					    <table border="0" cellpadding="0" cellspacing="0">
						    <tr>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td>
									<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_New">New</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td class="btn1_line"></td>
								<td>
									<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_Detail">Detail</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_DownExcel">Down Excel</td>
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
									<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
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