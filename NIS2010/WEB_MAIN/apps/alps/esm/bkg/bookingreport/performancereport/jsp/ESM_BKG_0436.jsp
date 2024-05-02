<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0436.jsp
*@FileTitle : Doc. user 를  조회합니다.
*Open Issues :
*Change history :
*@LastModifyDate : 2011.11.28
*@LastModifier : 금병주
*@LastVersion : 1.0
* 2011.11.28 금병주
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event.EsmBkg0436Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<% 
	EsmBkg0436Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag 	= "";
	String codeList  	= "";
	String pageRows  	= "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String dpcs_wrk_grp_cd	= "";
	String rgn_ofc_cd		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.BookingReport.PerformanceReport");

	try {
		SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg0436Event)request.getAttribute("Event");
		dpcs_wrk_grp_cd = event.getDpcsWrkGrpCd();
		rgn_ofc_cd = event.getRgnOfcCd();
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
<title>Search Doc. User</title>
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
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="strUsr_id" value="<%=strUsr_id%>">
<input type="hidden" name="ui_grp_cd" value="<%=dpcs_wrk_grp_cd %>">
<input type="hidden" name="ui_rgn_ofc_cd" value="<%=rgn_ofc_cd%>">
	

<!-- 개발자 작업	-->
<table width="100%" class="popup" cellpadding="10" border="0"> 
	<tr><td class="top"></td></tr>
	<tr>
		<td valign="top">
		<!--Page Title, Historical (S)-->
		<table width="100%" border="0">
		<tr><td class="title"><img src="./img/icon_title_dot.gif" align="absmiddle">&nbsp;Doc. User Search</td></tr>
		</table>
		<!--Page Title, Historical (E)--> <!-- : ( Search Options ) (S) -->

			<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">

				<table class="search" border="0" style="width: 100%;">
					<tr class="h23">
						<td>
						<table class="search" border="0" style="width: 100%;"> 
							<tr class="h23">
								<td width="100">Doc User ID</td>
								<td colspan="3" style="padding-left:5px">
									<input type="text" name="usr_id" style="width:130;" class="input" value="" style="ime-mode:disabled" dataformat="uppernum" caption="Doc User ID" maxlength="20" >
								</td>
							</tr>
							<tr class="h23"> 
								<td width="100" align="left">Doc User Group</td>
								<td width="150" style="padding-left:8px">
									<script language="javascript">ComComboObject('dpcs_wrk_grp_cd', 1, 130, 0,0,1);</script>
								</td>
								<td width="60" align="left">Doc Part</td>						
								<td >
									<script language="javascript">ComComboObject('rgn_ofc_cd', 1, 130, 0,0,1);</script>
								</td>
							</tr>
							</table>
						</td>
					</tr>
				</table>
				<br>

				<!-- Grid  (S) -->
					<table width="100%"  id="mainTable">
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet1');</script>
							</td>
						</tr>
					</table>
					<!-- Grid (E) -->
			
				</td>
			</tr>
		</table>
	
<table class="height_5"><tr><td></td></tr></table>
		</td>
	</tr>
</table>
	
	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

					<table width="100%" class="button" border="0" cellpadding="0"
						cellspacing="0" style="padding-top: 5; , padding-bottom: 10;">
						<tr>
							<td class="btn3_bg">
									<table border="0" cellpadding="0" cellspacing="0">
										<tr>
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0"
													class="button">
													<tr>
														<td class="btn1_left"></td>
														<td class="btn1" name="btn_retrieve">Retrieve</td>
														<td class="btn1_right"></td>
													</tr>
												</table>
											</td>
											<td class="btn1_line"></td>
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0"
													class="button">
													<tr>
														<td class="btn1_left"></td>
														<td class="btn1" name="btn_select">Select</td>
														<td class="btn1_right"></td>
													</tr>
												</table>
											</td>
											<td class="btn1_line"></td>
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0"
													class="button">
													<tr>
														<td class="btn1_left"></td>
														<td class="btn1" name="btn_close">Close</td>
														<td class="btn1_right"></td>
													</tr>
												</table>
											</td>
										</tr>
									</table>
							<!--Button (E) --></td>
						</tr>
					</table>
			</td>
		</tr>
	</table>					
		<!-- : ( Button : pop ) (E) -->


<!-- 개발자 작업  끝 -->
</form>
</body>
</html>
