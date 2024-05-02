<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TRS_0251.jsp
*@FileTitle : AWK Cargo Shuttle Tariff Management - History
*Open Issues :
*Change history :
*@LastModifyDate : 2013.04.05
*@LastModifier : 이혜민
*@LastVersion : 1.0
* 2013.04.05 이혜민
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
<%@ page import="com.hanjin.apps.alps.esd.trs.specialcargoquotationmanage.awkwardcargomanage.event.EsdTrs0251Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsdTrs0251Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_ofc		= "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_ofc = account.getOfc_cd();

		event = (EsdTrs0251Event)request.getAttribute("Event");
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

<% String fm_loc_cd = (request.getParameter("fm_loc_cd"));	
	String fm_nod_yd_no = (request.getParameter("fm_nod_yd_no"));	
	String to_loc_cd = (request.getParameter("to_loc_cd"));	
	String to_nod_yd_no = (request.getParameter("to_nod_yd_no"));	
	String trsp_crr_mod_cd = (request.getParameter("trsp_crr_mod_cd"));	
	String io_ga_cd = (request.getParameter("io_ga_cd"));	
	String cond_no = (request.getParameter("cond_no"));
	String trsp_awk_cgo_trf_tp_cd = (request.getParameter("trsp_awk_cgo_trf_tp_cd"));
%>
<html>
<head>
<title>AWK Cargo Shuttle Tariff Management - History</title>
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

<body onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="fm_loc_cd" value="<%= fm_loc_cd%>">
<input type="hidden" name="fm_nod_yd_no" value="<%= fm_nod_yd_no%>">
<input type="hidden" name="to_loc_cd" value="<%= to_loc_cd%>">
<input type="hidden" name="to_nod_yd_no" value="<%= to_nod_yd_no%>">
<input type="hidden" name="trsp_crr_mod_cd" value="<%= trsp_crr_mod_cd%>">
<input type="hidden" name="trsp_awk_cgo_trf_tp_cd" value="<%= trsp_awk_cgo_trf_tp_cd%>">
<input type="hidden" name="io_ga_cd" value="<%= io_ga_cd%>">
<input type="hidden" name="cond_no" value="<%= cond_no%>">

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
					<td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;AWK Cargo Shuttle Tariff Management - History</td>
				</tr>
			</table>
			<!-- : ( Title ) (E) -->
			<table class="search" id="mainTable"> 
	       		<tr>
	       			<td class="bg">	
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
		</td>
	</tr>
</table>
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
											<td class="btn1" name="btn_Close">Close</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</td>
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