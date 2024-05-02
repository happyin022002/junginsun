<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TES_0058.jsp
*@FileTitle : Select Cost for Break Bulk
*Open Issues :
*Change history :
*@LastModifyDate : 2013.02.13
*@LastModifier : 이혜민
*@LastVersion : 1.0
* 2013.02.13 이혜민
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
<%@ page import="com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.awkwardcargomanage.event.EsdTes0058Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsdTes0058Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsdTes0058Event)request.getAttribute("Event");
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

<% String vvd = JSPUtil.getNull(request.getParameter("vvd"));	
	String yd_cd = JSPUtil.getNull(request.getParameter("yd_cd"));	
	String tml_so_ofc_cty_cd = JSPUtil.getNull(request.getParameter("tml_so_ofc_cty_cd"));	
	String tml_so_seq = JSPUtil.getNull(request.getParameter("tml_so_seq"));	
	String bkg_no = JSPUtil.getNull(request.getParameter("bkg_no"));	
	String io_bnd_cd = JSPUtil.getNull(request.getParameter("io_bnd_cd"));	
	String atb_dt = JSPUtil.getNull(request.getParameter("atb_dt"));	
%>
<html>
<head>
<title>Select Cost for Break Bulk</title>
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
<input type="hidden" name="tmp_bkg_no" value="<%= bkg_no%>">
<input type="hidden" name="bkg_no" value="<%= bkg_no%>">
<input type="hidden" name="vvd" value="<%= vvd%>">
<input type="hidden" name="yd_cd" value="<%= yd_cd%>">
<input type="hidden" name="tml_so_ofc_cty_cd" value="<%= tml_so_ofc_cty_cd%>" >
<input type="hidden" name="tml_so_seq" value="<%= tml_so_seq%>" >
<input type="hidden" name="io_bnd_cd" value="<%= io_bnd_cd%>" >
<input type="hidden" name="atb_dt" value="<%= atb_dt%>" >

<!-- 개발자 작업	-->
<table width="100%" class="popup" cellpadding="10" border="0">
	<tr>
		<td class="top"></td>
	</tr>
	<tr>
		<td valign="top">
			<!-- : ( Title ) (S) -->
			<table width="100%" border="0">
				<tr>
					<td class="title"><img src="img/icon_title_dot.gif">&nbsp;Select Cost for Break Bulk</td>
				</tr>
			</table>
			<!-- : ( Title ) (E) -->
			<!--biz page (S)-->
			<table class="search"> 
	       		<tr>
	       			<td class="bg">
						<!--  biz_1  (S) -->
						<table style="width:979;">
							<tr>
								<td>
									<table class="search" border="0" style="width:550;">
										<tr>
											<td class="title_h"></td>
											<td width="" class="title_s">Booking Information</td>
										</tr>
									</table>
									<table class="search" border="0" style="width:550;">
										<tr class="h23">
											<td width = "10"></td>
											<td width="170" rowspan="4" valign="top">
												<!-- Grid  (S) -->
												<table width="100%"  id="mainTable">
													<tr>
														<td width="179">
															<script language="javascript">ComSheetObject('sheet1');</script>
														</td>
													</tr>
												</table>
												<!-- Grid (E) -->
											</td>
											<td width = "20"></td>
											<td width="400" valign="top">
												<!-- Grid  (S) -->
												<table class="search_sm2" border="0" width="390" >
													<tr class="h23">
														<td width="70">Shipper</td>
														<td width="310">
															<input type="text" name="s_cust_cnt_cd" style="width:35;" class="input2" value="" maxlength="2" style="ime-mode:disabled" >
															<input type="text" name="s_cust_seq" style="width:65;" class="input2" value="" maxlength="6" style="ime-mode:disabled"  >
															<input type="text" name="s_cust_nm" style="width:200;" class="input2" value="" >
														</td>
													</tr>
													<tr class="h23">
														<td width="70">Consignee</td>
														<td width="310">
															<input type="text"  name="c_cust_cnt_cd" style="width:35;" class="input2" value="" maxlength="2" style="ime-mode:disabled"  >
															<input type="text"  name="c_cust_seq" style="width:65;" class="input2" value="" maxlength="6" style="ime-mode:disabled"  >
															<input type="text" name="c_cust_nm" style="width:200;" class="input2" value="" >
														</td>
													</tr>
													<tr class="h23">
														<td width="70">Notify</td>
														<td width="310">
															<input type="text" name="n_cust_cnt_cd" style="width:35;" class="input2" value="" maxlength="2" style="ime-mode:disabled" >
															<input type="text" name="n_cust_seq" style="width:65;" class="input2" value="" maxlength="6" >
															<input type="text" name="n_cust_nm" style="width:200;" class="input2" value="" >
														</td>
													</tr>
													<tr class="h23">
														<td width="70">Cntr Total</td>
														<td width="310">
															<input type="text" name="cntr_total" style="width:309;" class="input2" value="" maxlength="2" style="ime-mode:disabled" >
														</td>
													</tr>
													<tr><td><table class="height_5"><tr><td colspan="8"></td></tr></table></td></tr>								
													<tr class="h23">
														<td width="72">Cntr Info</td>
														<td width="310">
															<script language="javascript">ComSheetObject('sheet2');</script>
														</td>
													</tr>
													<tr><td><table class="height_5"><tr><td colspan="8"></td></tr></table></td></tr>
													<tr><td><table class="height_10"><tr><td colspan="8"></td></tr></table></td></tr>
													<tr class="h23">
														<td width="380" colspan="2">
															<script language="javascript">ComSheetObject('sheet3');</script>
														</td>
													</tr>							
												</table>
												<table>
													<tr class="h23">
														<td width="380" colspan="2">
															<script language="javascript">ComSheetObject('sheet4');</script>
														</td>
													</tr>							
												</table>
												<!-- Grid (E) -->
											</td>
										</tr>
									</table>
								</td>
								<!--  biz_1  (E) -->
								<!--  biz_2  (S) -->
								<td>
									<table class="search" border="0" style="width:470;">
										<tr>
											<td class="title_h"></td>
											<td width="" class="title_s">Cost Information</td>
										</tr>
									</table>
									<table style="width:470;" border="0" id="mainTable">
										<tr>
											<td width = "10"></td>
											<td width="455">
												<script language="javascript">ComSheetObject('sheet5');</script>
											</td>
											<td width=""></td>
										</tr>
									</table>
									<table>
										<tr class="h23">
											<td width="455" colspan="">
												<script language="javascript">ComSheetObject('sheet6');</script>
											</td>
										</tr>							
									</table>
								</td>
							</tr>
						</table>
						<!--  biz_2   (E) -->
					</td>
				</tr>
			</table>
			<!--biz page (E)-->
	
			<!--Button (S) -->
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
	       		<tr>
	       			<td class="btn3_bg">
					    <table border="0" cellpadding="0" cellspacing="0">
					    	<tr>
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn1_left"></td>
									<td class="btn1" name="btn_Confirm">Confirm</td>
									<td class="btn1_right"></td>
									</tr>
								</table></td>
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn1_left"></td>
									<td class="btn1" name="btn_Close">Close</td>
									<td class="btn1_right"></td>
									</tr>
								</table></td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			<!--Button (E) -->
		</td>
	</tr>
</table>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>
