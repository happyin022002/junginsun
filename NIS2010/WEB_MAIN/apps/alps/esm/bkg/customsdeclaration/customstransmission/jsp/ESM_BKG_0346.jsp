<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ui_bkg_0346.jsp
*@FileTitle : Trans Cancellation To Korea Customs
*Open Issues :
*Change history :
*@LastModifyDate : 2011.11.10
*@LastModifier : 이인영
*@LastVersion : 1.0
* 2011.11.10 이인영
* 1.0 Creation
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.korea.event.EsmBkg0346Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0346Event  event = null;				//PDTO(Data Transfer Object including Parameters)
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

		event = (EsmBkg0346Event)request.getAttribute("Event");
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
<title>Welcome to Alps!</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>


<script language="javascript">
    function setupPage()
    {  
	    loadPage();
    }
</script>

<body  onLoad="setupPage();"> 
<form name="form" method="post">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<input type="hidden" name="vsl_nm" value="<%= request.getParameter("vsl_nm")%>">
<input type="hidden" name="io_bnd_cd" value="<%= request.getParameter("io_bnd_cd")%>">
<input type="hidden" name="snd_date" value="<%= request.getParameter("snd_date")%>">

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
	
		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span> Trans Cancellation To Korea Customs</span></td></tr>
		</table>
		<!--Page Title, Historical (E)-->
	
	
		<!--Button (S) -->
		
    	<!--Button (E) -->
		
		<!--biz page (S)-->
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">
				
			<!--  biz_1 (S) -->
				
				<table class="search" border="0" style="width:990;"> 
					<tr class="h23">
						<td width="40" align='left'>VVD</td>
						<td width="110"><input type="text" style="width:100%; text-align:center;" class="input2" value="<%= request.getParameter("vvd") %>" name='vvd' dataformat="eng" readonly="true"></td>
						<td width="80" align='left'>MRN No.</td>
						<td width="100"><input type="text" style="width:100%; text-align:center;" class="input2" value="<%= request.getParameter("mrn_no") %>" name='mrn_no' dataformat="eng" readonly="true"></td>
						<td width="120" align='left'>POL</td>
						<td width="200"><input type="text" style="width:60; text-align:center;" value="<%= request.getParameter("pol_cd") %>" class="input2" name='pol_cd' dataformat="eng" readonly="true">
						</td>
					</tr>
					
					<tr class="h23">
						<td width="40" align='left'>ETD</td>
						<td width="110"><input type="text" style="width:100%; text-align:center;" class="input2" value="<%= request.getParameter("etd_dt") %>" name='etd_dt' dataformat="eng" readonly="true"></td>
						<td width="80" align='left'>RQST DATE</td>
						<td width="100"><input type="text" style="width:100%; text-align:center;" class="input2" value="" name='rqst_dt' dataformat="eng" readonly="true"></td>
						<td width="120" align='left'>Local Customs</td>
						<td width="200">
							<input type="text" style="width:60;" value="<%= request.getParameter("locl_cstms_cd") %>" class="input2" name='locl_cstms_cd' dataformat="eng" readonly="true">&nbsp;
							<input type="text" style="width:35;" class="input2" value="<%= request.getParameter("locl_cstms_prt_cd") %>" name="locl_cstms_prt_cd" readonly="true">
						</td>
					</tr>
				</table>
				</td></tr></table>
				
			<!--  biz_1 (E) -->
		
		<table class="height_8"><tr><td></td></tr></table>	
		
		<!--biz 2 (S)-->
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">
				<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">Vessel Information</td></tr>
				<tr><td class="height_5"></td></tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<!-- Vessel B/L Total Info-->
						<td width="220">
							<table class="search" border="0" style="width:400;">
							<tr class="h23">
								<td width="110">Master B/L Total</td>
								<td width="230"><input type="text" style="width:70;" class="input2" name="mst_bl_knt" value="<%= request.getParameter("mst_bl_knt") %>" readonly="true"></td>
							</tr>
							<tr class="h23">
								<td width="110">Empty B/L Total</td>
								<td width="230"><input type="text" style="width:70;" class="input2" name="mty_bl_knt" value="<%= request.getParameter("mty_bl_knt") %>" readonly="true"></td>
							</tr>
							<tr class="h23">
								<td width="110">Consol B/L Total</td>
								<td width="230"><input type="text" style="width:70;" class="input2" name="cnsl_bl_knt" value="<%= request.getParameter("cnsl_bl_knt") %>" readonly="true"></td>
							</tr>
							<tr class="h23">
								<td width="110">Simple B/L Total</td>
								<td width="230"><input type="text" style="width:70;" class="input2" name="smp_bl_knt" value="<%= request.getParameter("smp_bl_knt") %>" readonly="true"></td>
							</tr>
							</table>
						</td>
						<td>
							<table class="search" border="0" style="width:480;">
							<tr class="h23">
								<td width="80">신청구분</td>
								<td width="230">
									<select name="trsm_cxl_tp_cd" style="width:100" class="input">
										<option value="3">해상수입</option>
										<option value="4">해상수출</option>
									</select>
								</td>
							</tr>
							<tr class="h23">
								<td width="80">취하구분</td>
								<td width="230">
									<select name="trsm_cxl_rsn_cd" style="width:200" class="input">
										<option value="1">기상악화</option>
										<option value="2">선박(항공기)사고</option>
										<option value="3">선박(항공기)스케줄 변경</option>
										<option value="4">적하목록 관리번호(MRN) 오전송</option>
										<option value="5">기타</option>
									</select>
								</td>
							</tr>
							</table>
						</td>
					</tr>
				</table>
				<table class="search" border="0" style="width:979;padding-top:10;"> 
					<tr class="h23">
						<td width="129">취하사유</td>
						<td width="750"><input type="text" style="width:500;" class="input" maxlength="50" name="trsm_cxl_desc"></td>
						<!--Button (S) -->
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr><td class="btn1_left"></td>
											<td class="btn1" name="btn_transmit">SEND</td>
											<td class="btn1_right"></td>
											</tr>
										</table></td>
					    <!--Button (E) -->
					</tr>
				</table>
				
				
				<!--  biz_2   (E) -->		
				<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
				</td></tr></table>

	            <!-- Grid  (S) -->
	       		<table width="100%"  id="mainTable" style="display:none;">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
	            <!-- Grid  (E) -->
						

		<!--biz page (E)-->

</td></tr></table>	

</form>
</body>
</html>