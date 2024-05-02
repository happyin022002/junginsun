<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TPB_0808.jsp
*@FileTitle : Pending
*Open Issues :
*Change history :
*@LastModifyDate : 2009-09-16
*@LastModifier : 변종건
*@LastVersion : 1.1
* 2009-03-16 O Wan-Ki 			1.0 	최초 생성
* 2009-09-16 Jong-Geon Byeon	1.1 	ALPS Migration
* ------------------------------------------
* History
* 2013.06.04 신자영 [CHM-201325084][TPB] DXBBB 및 산하 점소들 전체의 Long pending TPB 현황 팝업 관련
* 2015.08.05 Kim Hyun Hwa[CHM-201537151]그룹사 표준 코드 시행 프로그램 수정. DXBBB -->DXBSC
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.tpb.statusinquiry.statusinquiry.event.EsdTpb0808Event"%>
<%@ page import="com.hanjin.apps.alps.esd.tpb.common.TPBUtils"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsdTpb0808Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.StatusInquiry.StatusInquiry");
	
	String ofc_cd = "";
	String rhq_cd = "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		ofc_cd = account.getOfc_cd();
	
		event = (EsdTpb0808Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
	

	String[] officeInfo = TPBUtils.getHandleOfficeLevel( ofc_cd, true ); // 0:Office Level / 1:Office Code / 2:R.HQ Code / 3:HO Code
	String ofc_lvl = JSPUtil.getNull( officeInfo[0] ); // Office Level
	rhq_cd = JSPUtil.getNull( officeInfo[2] );  // R.HQ Code
%>
<html>
<head>
<title>Information on Pending TPB</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<body  onLoad="setupPage();">
	<form method="post" name="form" onSubmit="return false;">
	
	<input type="hidden" name="user_ofc_cd" value=<%=ofc_cd%>>
	<input type="hidden" name="user_id" value=<%=strUsr_id%>>
	
	<!-- ______________________________________________ Start Hidden Value -->
		<input type="hidden" name="f_cmd"> 
		<input type="hidden" name="iPage">
	<!-- ______________________________________________ End Hidden Value -->
	
<table width="100%" class="popup" cellpadding="10" border="0">
<tr>
	<td class="top"></td>
</tr>
<tr>
	<td valign="top">
	
	<table width="350" height="10" border="0" cellpadding="0" cellspacing="0" align="center">
		<tr>
			<td valign="top" class="bodyright">
			
			<!-- ______________________________________________ Start Page Navigation & Title -->
				<table border="0" height="10">
					<tr>
						<td></td>
					</tr>
				</table>
				<table width="100%" class="title">
			  	<tr>
			  		<td class="title">
			        	<img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">
			        	<%if (strUsr_id.equals("gcc003")|| strUsr_id.equals("gcc014")){%>
						Pending TPB of DXBSC
						<%} else{%>
						Pending TPB of <%=ofc_cd%>
						<%}%> 
			      	</td>
			    	</tr>
				</table>
			<!-- ______________________________________________ End Page Navigation & Title -->
		
		
			<!-- ______________________________________________ Start Main Button -->
			<!-- | -->
			<!-- |______________________________________________ End Main Button -->

				<table border=0 height="10" width="100%">
					<tr>
						<td></td>
					</tr>
				</table>
	
			<!-- ______________________________________________ Start Search Option -->	
				<table class="search" width="100%" align=center>
					<tr>
						<td class="bg_a">
							<table border="0" cellspacing="10">
								<tr class="h25">
									<td><font size="2" color="red">Following data requires of your immediate actions for further process !!!</font></td>
								</tr>
							</table>
						</td>
					</tr>
					<tr>
						<td class="bg">
							<table width="100%" id="mainTable">
						        <tr>
						        	<td><script language="javascript">ComSheetObject('sheet1');</script></td>
						        </tr>
							</table>
						</td>
					</tr>
				</table>
			<!-- |______________________________________________ End Search Option -->	
	
			</td>
		</tr>
	</table>
	
	</td>
</tr>
</table>
	
	<!-- : ( Button : Sub ) (S) -->

	<table width="100%" class="sbutton" align=center>
		<tr>
			<td height="10" class="popup">
				<table class="sbutton" align=center>
					<tr>
						<td>
							<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr>
									<td class="btn1_left"></td>
									<td class="btn1" name="btn_close" id="btn_close">Close</td>
									<td class="btn1_right"></td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
	<!-- : ( Button : Sub ) (E) -->
				
	</form>
</body>
</html>
