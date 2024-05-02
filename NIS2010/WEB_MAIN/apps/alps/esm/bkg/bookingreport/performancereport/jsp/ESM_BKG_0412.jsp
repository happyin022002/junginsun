
<%
	/*=========================================================
	 *Copyright(c) 2009 CyberLogitec
	 *@FileName : esm_bkg_0412.jsp
	 *@FileTitle : Queue Detail
	 *Open Issues :
	 *Change history :
	 *@LastModifyDate : 2009.05.13
	 *@LastModifier : 김경섭
	 *@LastVersion : 1.0
	 * 2009.05.13 김경섭
	 * 1.0 Creation
	 =========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event.EsmBkg0412Event"%>	
<%@ page import="org.apache.log4j.Logger"%>
<%@ page import="java.util.List" %>
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO" %>
<%@ page import="com.hanjin.apps.alps.esm.bkg.common.*" %>
<%
	EsmBkg0412Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지
	int rowCount = 0; //DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";
	String isPop     = "";
	
	String strUsr_id = "";
	String strUsr_nm = "";
	boolean bBtn_Disabled = true;
	List<BkgComboVO> doc_group = null;
	List<BkgComboVO> sr_kind = null;
	List<BkgComboVO> src = null;
	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		isPop     = JSPUtil.getParameter(request, "isPop");
		event = (EsmBkg0412Event) request.getAttribute("Event");
		serverException = (Exception) request
				.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException)
					.loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request
				.getAttribute("EventResponse");
		doc_group = (List<BkgComboVO>) eventResponse.getCustomData("doc_group");
		sr_kind = (List<BkgComboVO>) eventResponse.getCustomData("sr_kind");
		src = (List<BkgComboVO>) eventResponse.getCustomData("src");

	} catch (Exception e) {
		out.println(e.toString());
	}

%>
<html>
<head>
<title>Weight Value for DPCS B/L perf.</title>
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

<body  onLoad="setupPage();">
<div id="debug"></div>
<form name="form">
	<input type="hidden" name="f_cmd"> 
	<input type="hidden" name="pagerows"> 

	<input type="hidden" name="usr_id"      		value="<%=strUsr_id%>">
	<input type="hidden" name="usr_nm"      		value="<%=strUsr_nm%>">
    <input type="hidden" name="isPop"  value="<%=isPop%>">
	
<!-- 개발자 작업	-->
<!--table width="100%"  class="popup" cellpadding="10" border="0"-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
<tr><td class="top">
	<!--Page Title, Historical (S)-->
	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
	</table>
	<!--Page Title, Historical (E)-->

    </td></tr>
	<tr>
		<td valign="top">
		<!--Page Title, Historical (S)-->
		<!-- table width="100%" border="0">
		<tr><td class="title"><img src="./img/icon_title_dot.gif" align="absmiddle">&nbsp;Weight Value for DPCS Evaluation(BL Perf.)</td></tr>
		</table-->
		<!--Page Title, Historical (E)--> <!-- : ( Search Options ) (S) -->

			<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">

					<!--  biz_1  (S) -->
					<table class="search" border="0" style="width:540;"> 
					<tr class="h23">
						<td width="90">Doc Group</td>
						<!-- td width=""><input type="text" style="width:100" value="" class="input"  name="doc_group"></td-->
						<td width="90" align="left"><%=HTMLUtil.getComboString("doc_group", "", "", "","","All", doc_group)%></td>
						<td width="70">SR Kind</td>						
						<!-- td width=""><input type="text" style="width:100" value="" class="input"  name="sr_kind"></td-->
						<td width="90" align="left"><%=HTMLUtil.getComboString("sr_kind", "", "", "","","All", sr_kind)%></td>
						<td width="40">SRC</td>
						<!-- td width=""><input type="text" style="width:66" value="" class="input"  name="src"></td-->
						<td width="90" align="left"><%=HTMLUtil.getComboString("src", "", "", "","L","", src)%></td>
						<!-- td width="">Border</td>
						<td width=""><input type="text" style="width:66" value="" class="input"  name="border"></td-->
						<td width="400" ></td>
					</tr>

					</table>


				<!--  biz_1   (E) -->
				
					<!-- table class="search" border="0">
						<tr><td class="title_h"></td>
						<td class="title_s">DPCS Point</td></tr>
						<tr><td class="height_5"></td></tr>
					</table-->
				    <table class="line_bluedot"><tr><td colspan="8"></td></tr></table>									
					
					<!-- Grid  (S) -->
					
					<table width="100%"  id="mainTable">
						<tr>
							(*Points can be awarded when this counted no exceeds.)
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet1');</script>
							</td>
						</tr>
					</table>
					<!-- Grid (E) -->
						<!--  Button_Sub (S) -->
					<table width="100%" class="button"> 
			       	<tr><td class="btn2_bg">
						<!--table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_RowAdd">Row Add</td>
							<td class="btn2_right"></td>
							</tr>
							</table></td>
							
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_Delete">Row Delete</td>
							<td class="btn2_right"></td>
							</tr>
							</table></td>
		
							</tr></table-->
					</td></tr>
					</table>
			    	<!-- Button_Sub (E) -->			
				</td>
			</tr>
		</table>

<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0"	cellspacing="0" style="padding-top: 5; ">
			<tr>
				<td class="btn1_bg">
				
					<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td>
							<table width="100%" border="0" cellpadding="0" cellspacing="0"
								class="button">
								<tr>
									<td class="btn1_left"></td>
									<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
									<td class="btn1_right"></td>
								</tr>
							</table>
							</td>
							<td>
							<%  if(!"Y".equals(isPop) ) { %>
							<table width="100%" border="0" cellpadding="0" cellspacing="0"
								class="button">
								<tr>
									<td class="btn1_left"></td>
									<td class="btn1" name="btn_Save" id="btn_Save">Save</td>
									<td class="btn1_right"></td>
								</tr>
							</table>
							<% } %>
							</td>							
							<td>
							<%  if("Y".equals(isPop) ) { %>
							<table width="100%" border="0" cellpadding="0" cellspacing="0"
								class="button">
								<tr>
									<td class="btn1_left"></td>
									<td class="btn1" name="btn_Close" id="btn_Close">Close</td>
									<td class="btn1_right"></td>
								</tr>
							</table>
							<% } %>
							</td>							
					</tr>
				</table>
	
			</td>
		</tr>
	</table>

		</td>
	</tr>
</table>
<!--Button (E) --> 

<!-- 개발자 작업  끝 -->
</form>
<form name="form2" method="POST">
	<input type="hidden" name="message"> 
</form>	
</body>
</html>
<%@include file="../../../../../../../bizcommon/include/common_alps.jsp"%>