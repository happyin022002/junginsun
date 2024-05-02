<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ui_bkg_0122.jsp
*@FileTitle : ACI_Vessel Information
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.25
*@LastModifier : 정재엽
*@LastVersion : 1.0
* 2009.04.24 정재엽
* 1.0 Creation
* 2013.04.19 김진주 [CHM-201323704] [Charge Adjustment] 팝업 개발 및 오토레이팅 연계 요청
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.event.EsmBkg0699Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0699Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.wharfagemgt.wharfagedecmgt");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg0699Event)request.getAttribute("Event");
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
<title>Wharfage Cargo Classification</title>
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

<body onLoad="setupPage();">
<form name="form" method="post">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="frm_attr_ctnt2">

<!-- 개발자 작업	-->
<%
	String bkgNo     = (request.getParameter("bkg_no") == null)? "":request.getParameter("bkg_no");
	bkgNo = ( bkgNo == "" )? "KORZ1025363":bkgNo;
%>
<!-- OUTER - POPUP (S)tart -->
<input type="hidden" name="bkg_no" value="<%=bkgNo %>">
		
		<!--biz page (S)-->
		<table class="search" id="mainTable">
			<tr><td class="bg">
				<!-- Grid frame (S) -->
				<table width="100%" class="search">
					<tr><td colspan="2">
						<!--  biz_1  (S) -->
					<table class="search" border="0" style="width:100%;"> 
					<tr class="h23">
						<td>Shipper</td>
						<td colspan="3"><input type="text" style="width:395;" class="input" name="shipper_name" readonly="readonly"></td>								
					</tr> 
					<tr class="h23">
						<td>Export Reference</td>
						<td colspan="3"><input type="text" style="width:395;" class="input" name="export_ref" readonly="readonly"></td>								
					</tr> 
					<tr class="h23">
						<td width="110">Rep. Commodity</td>
						<td width="290"><input type="text" style="width:270;" class="input" name="cstms_desc" readonly="readonly"></td>	
						<td width="75">Cargo Type</td>
						<td width=""><input type="text" style="width:30;" class="input" name="bkg_cgo_tp_cd" readonly="readonly"></td>			
					</tr> 
					</table>				
					<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
					<!--  biz_1   (E) -->
					</td></tr>
					
					<tr>
						<td width="50%">
							<!-- Title (S) -->
							<table class="search" border="0">
							<tr><td class="title_h"></td>
								<td class="title_s">Exempt Condition</td></tr>
							<tr><td class="height_5"></td></tr>
							</table>
							<!-- Title (S) -->
							<!-- Grid-1  (S) -->
							<table width="100%"  id="mainTable"> 
								<tr>
									<td width="100%">
										<script language="javascript">ComSheetObject('sheet1');</script>
									</td>
								</tr>
							</table> 
							<!-- Grid-1 (E) -->	
						</td>
						<td width="50%" style="padding-left:10;" valign="top">
					
							<!-- Title (S) -->
							<table class="search" border="0">
							<tr><td class="title_h"></td>
								<td class="title_s">T/S 대상 Container</td></tr>
							<tr><td class="height_5"></td></tr>
							</table>
							<!-- Title (S) -->		
						
							<!-- Grid-2  (S) -->
							<table width="100%"  id="mainTable"> 
								<tr>
									<td width="100%">
										<script language="javascript">ComSheetObject('sheet2');</script>
									</td>
								</tr>
							</table>
							<!-- Grid-2 (E) -->		
							
						</td>
					</tr>
				</table>
				<!-- Grid frame (S) -->
				
			</td></tr>
		</table>
		
		
		
<table width="100%" >
	<tr><td height="46" >
		<!--Button (S) -->	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
			<tr><td class="btn3_bg">
				<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td>
							<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr>
									<td class="btn1_left"></td>
									<td class="btn1" name="btn_save">Save</td>
									<td class="btn1_right"></td>
								</tr>
							</table>
						</td>
						<td>
							<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr>
									<td class="btn1_left"></td>
									<td class="btn1" name="btn_new">New</td>
									<td class="btn1_right"></td>
								</tr>
							</table>
						</td>
						<td>
							<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td>
									<td class="btn1" name="btn_close">Close</td>
									<td class="btn1_right"></td>
								</tr>
							</table>
						</td>
					</tr>				
				</table>
			</td></tr>
		</table>
		<!--Button (E) -->
	</td></tr>
</table>
		<!--biz page (E)--> 
<!-- : ( Button : pop ) (S) -->
<!-- : ( Button : pop ) (E) -->
</form>
</body>
</html>