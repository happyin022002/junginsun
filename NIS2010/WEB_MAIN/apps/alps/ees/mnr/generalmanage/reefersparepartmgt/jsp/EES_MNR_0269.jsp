<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MNR_0269.jsp
*@FileTitle : Reefer Spare Part Inquiry_Pop Up
*Open Issues :
*Change history : 1. 2015.03.12, CHM-201534633, 신규 개발 Module 수정 요청 - Spare Part VSL Inventory, 이율규
*@LastModifyDate : 2009.09.01
*@LastModifier : 권영법
*@LastVersion : 1.0
* 2009.09.01 권영법
* 1.0 Creation
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.mnr.generalmanage.reefersparepartmgt.event.EesMnr0269Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesMnr0269Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String rhqOfcCd         = "";
	String currOfcCd       = "";
	String currOfcEngNm     = "";
	
	//부모창에서 파라메터 받아오기
	String sprPrtInvtNo	= "";
    String sprPrtInvtVerSeq	= "";
    if(request.getParameter("spr_prt_invt_no")!=null) {
    	sprPrtInvtNo 	= JSPUtil.getParameter(request, "spr_prt_invt_no");
    	sprPrtInvtVerSeq= JSPUtil.getParameter(request, "spr_prt_invt_ver_seq");
    }
    
	Logger log = Logger.getLogger("com.hanjin.apps.alps.ees.mnr.generalmanage.reefersparepartmgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id         =	account.getUsr_id();
		strUsr_nm       = account.getUsr_nm(); 
		rhqOfcCd        = account.getRhq_ofc_cd();
		currOfcCd       = account.getOfc_cd();
		currOfcEngNm = account.getOfc_eng_nm();
		
		event = (EesMnr0269Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Reefer Spare Part Inquiry</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
    var currOfcCd = '<%=currOfcCd %>';
    var rhqOfcCd  = '<%=rhqOfcCd %>';
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<body class="popup_bg"  onLoad="setupPage();">

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="f_gubuns">
<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">   Spare Part VSL Inventory Inquiry</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!--biz page (S)-->
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">
			
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="80">Invenory No.</td>
					<td width="150"><input type="text" style="width:150;" class="input1" name="spr_prt_invt_no" id="spr_prt_invt_no" value="<%=sprPrtInvtNo %>"></td>
					<td width="100"></td>
					
					<td width="90">Code Ver</td>
					<td width="60"><input type="text" style="width:30;" class="input2" value="" readonly name="spr_prt_ver_seq" id="spr_prt_ver_seq"></td>
					
					<td width="100">Creation Date</td>
					<td width="120"><input type="text" style="width:90;" class="input2" value="" readonly name="cre_dt" id="cre_dt"></td>
					<td width="100">Created By</td>
					<td width="120"><input type="text" style="width:90;" class="input2" value="" readonly name="cre_usr_nm" id="cre_usr_nm"></td>
					
				</tr> 
				</table>
				<!--  biz_1   (E) -->
			
		</td></tr></table>
		
		<!-- : ( Search Options ) (S) -->
 			
			<table class="search"> 
       		<tr><td class="bg">
						
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
				
				<!-- : ( Grid ) (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet2');</script>
						</td>
					</tr>
				</table>
				<!-- : ( Grid ) (E) -->
			</td></tr>
			</table>
	    	
			
			<table class="height_5"><tr><td></td></tr></table>
			</td></tr>
		</table>
<!-- : ( Search Options ) (E) -->

	
	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<!-- 
				
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_retrieve">Retrieve</td>
					<td class="btn1_right"></td>
				</tr></table></td>
												
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_ok">OK</td>
					<td class="btn1_right"></td>
				</tr></table></td>
				 -->
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_close">Close</td>
					<td class="btn1_right"></td>
				</tr></table></td>
				<td class="btn1_line"></td>
				<!-- 1. 2015.03.12, CHM-201534633, 신규 개발 Module 수정 요청 - Spare Part VSL Inventory, 이율규, start -->
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_downexcel">Down Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<!-- 1. 2015.03.12, CHM-201534633, 신규 개발 Module 수정 요청 - Spare Part VSL Inventory, 이율규, finish -->
			</tr>
		</table>
</td></tr>
</table> 
    <!--Button (E) -->
	
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->

</form>
</body>
</html>
<%@include file="/bizcommon/include/common_alps.jsp" %>
