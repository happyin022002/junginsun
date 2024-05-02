<%--
/*=========================================================
*Copyright(c) 2008 CyberLogitec
*@FileName : ESD_EAS_0902.jsp
*@FileTitle : Remark Detail 조회/추가/수정
*Open Issues :
*Change history :
*@LastModifyDate : 2008-05-22
*@LastModifier : JeongHo_Lee
*@LastVersion : 1.0
* 2008-05-22 JeongHo_Lee
* 1.0 최초 생성
=========================================================*/
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.eas.transportmanage.event.EsdEas0902Event"%>
<%@ page import="com.hanjin.apps.alps.esd.eas.transportmanage.event.EsdEas0902EventResponse"%>
<%@ page import="com.hanjin.framework.component.util.StringUtil" %>

<%
	EsdEas0902Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	EsdEas0902EventResponse eventResponse = null;	//RDTO(Data Transfer Object including DB ResultSet)
	Exception serverException   = null;			//서버에서 발생한 에러
	DBRowSet rowSet	  = null;							   //DB ResultSet
	String strErrMsg = "";								 //에러메세지
	int rowCount	 = 0;								  //DB ResultSet 리스트의 건수

	String bkg_no = StringUtil.xssFilter(request.getParameter("bkg_no"));
	String bkg_no_split = JSPUtil.getNull(StringUtil.xssFilter(request.getParameter("bkg_no_split")));
	String bl_no = JSPUtil.getNull(StringUtil.xssFilter(request.getParameter("bl_no")));
	String eas_expn_tp_cd = JSPUtil.getNull(StringUtil.xssFilter(request.getParameter("eas_expn_tp_cd")));
	String rmk_ctnt = JSPUtil.getNull(StringUtil.xssFilter(request.getParameter("rmk_ctnt")));
	String rmk_ctnt_seq = JSPUtil.getNull(StringUtil.xssFilter(request.getParameter("rmk_ctnt_seq")));
	String is_read_only = JSPUtil.getNull(StringUtil.xssFilter(request.getParameter("is_read_only"))).trim();

	SignOnUserAccount account = null;
	try {
		account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);

		event = (EsdEas0902Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
	strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}else{
	eventResponse = (EsdEas0902EventResponse)request.getAttribute("EventResponse");
	if (eventResponse != null) {
		rowSet = eventResponse.getRowSet();
		if(rowSet != null){
	 rowCount = rowSet.getRowCount();
		} // end if
	} // end if
		} // end else
	}catch(Exception e) {
		out.println(e.toString());
	}
	boolean isReadOnly = false;

	if ( is_read_only.trim().equals("Y") ) { //
		isReadOnly = true;
	}
%>


<html>
<head>
<title>Remark Detail</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if

		InitTab();

		loadPage();
		_text_ChangeUpperCase(); // automatic change to uppercase;
	}
</script>
</head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input	type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="s_bkg_no" value="<%=bkg_no%>">
<input type="hidden" name="s_bkg_no_split" value="<%=bkg_no_split%>">
<input type="hidden" name="s_bl_no" value="<%=bl_no%>">
<input type="hidden" name="s_eas_expn_tp_cd" value="<%=eas_expn_tp_cd%>">
<input type="hidden" name="s_rmk_ctnt" value="<%=rmk_ctnt%>">
<input type="hidden" name="s_rmk_ctnt_seq" value="<%=rmk_ctnt_seq%>">
<input type="hidden" name="s_user_id" value="<%=account.getUsr_id()%>">
<input type="hidden" name="s_cre_ofc_cd" value="<%=account.getOfc_cd()%>">
<input type="hidden" name="s_readonly" value="<%=is_read_only%>">

<!-- OUTER FRAME : "to make sum of components' HEIGHTS 100%" (S)tart -->
<table width="700" class="popup" cellpadding="10">
<tr><td class="top"></td></tr>
<tr><td valign="top">


					<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
						<table width="100%" border="0">
						<tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp;Expense Audit Remark Detail</td></tr>
						</table>
					<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->


			<!-- ################# TABLE '#A' ::: 'TOP' FRAME (START) ################## -->


					<!-- TABLE '#D' : ( Grid ) (S) -->
					<!-- Detail Top Start -->
			     		<table class="search">
				       		<tr><td class="bg">

							<table class="height_10"><tr><td></td></tr></table>

							<!-- : ( POR ) (S) -->
							<table width="660" id="mainTable">
				              <tr><td>
				                     <script language="javascript">comSheetObject('sheet1');</script>
				              </td></tr>
							</table>
							<!-- : ( POR ) (E) -->
							<% if(!isReadOnly){ // %>
							<!-- : ( Button : Sub ) (S) -->
							<table width="100%" class="button">
								<tr><td class="btn2_bg">
									<table border="0" cellpadding="0" cellspacing="0">
										<tr>

										<!-- Repeat Pattern -->
										<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn2_left"></td><td class="btn2" name="btn_add" id="btn_add">Row Add</td>
										<td class="btn2_right"></td></tr></table></td>
										<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn2_left"></td><td class="btn2" name="btn_save" id="btn_save">Save</td>
										<td class="btn2_right"></td></tr></table></td>
										<!-- Repeat Pattern -->

										</tr>
									</table>
								</td></tr>
							</table>
					    	<!-- : ( Button : Sub ) (E) -->
							<% } %>
						</td></tr>
					</table>
					<!-- TABLE '#D' : ( Grid ) (E) -->
					<!-- Detail Top End -->
</td></tr>
</table>
<!-- OUTER - POPUP (E)nd -->
<table class="height_10"><tr><td></td></tr></table>
<!-- : ( Button : Sub ) (S) -->
<table width="100%" class="sbutton">
		<tr><td height="71" class="popup">

			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
	       		<tr><td class="btn3_bg">
			    <table border="0" cellpadding="0" cellspacing="0">
			    <tr>

					<!-- Repeat Pattern -->
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" name="btn_close" id="btn_close">Close</td><td class="btn1_right"></td></tr></table></td>
					<!-- Repeat Pattern -->

				</tr>
			</table>

		</td></tr>
</table>
<!-- : ( Button : Sub ) (E) -->

</form>
</body>
</html>
