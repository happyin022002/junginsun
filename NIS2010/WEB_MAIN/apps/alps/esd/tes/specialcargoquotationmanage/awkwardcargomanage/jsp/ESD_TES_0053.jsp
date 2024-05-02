<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TES_0053.jsp
*@FileTitle :AWK Cargo Tariff History-T/S
*Open Issues :
*Change history :
*@LastModifyDate : 2013.02.07
*@LastModifier : 이혜민
*@LastVersion : 1.0
* 2013.02.07 이혜민
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
<%@ page import="com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.awkwardcargomanage.event.EsdTes0053Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsdTes0053Event  event = null;					//PDTO(Data Transfer Object including Parameters)
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

		event = (EsdTes0053Event)request.getAttribute("Event");
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

<% String tml_awk_cgo_trf_tp_cd = JSPUtil.getNull(request.getParameter("tml_awk_cgo_trf_tp_cd"));	
	String port_cd = JSPUtil.getNull(request.getParameter("port_cd"));	
	String tml_cd = JSPUtil.getNull(request.getParameter("tml_cd"));	
	String tml_awk_ts_cd = JSPUtil.getNull(request.getParameter("tml_awk_ts_cd"));	
	String io_bnd_cd = JSPUtil.getNull(request.getParameter("io_bnd_cd"));	
	String io_ga_cd = JSPUtil.getNull(request.getParameter("io_ga_cd"));	
	String cond_no = JSPUtil.getNull(request.getParameter("cond_no"));
%>
<html>
<head>
<title>AWK Cargo Tariff History-T/S</title>
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
<input type="hidden" name="tml_awk_cgo_trf_tp_cd" value="<%= tml_awk_cgo_trf_tp_cd%>">
<input type="hidden" name="tml_awk_ts_cd" value="<%= tml_awk_ts_cd%>">
<input type="hidden" name="yd_cd" >
<input type="hidden" name="port_cd" value="<%= port_cd%>">
<input type="hidden" name="tml_cd" value="<%= tml_cd%>">
<input type="hidden" name="io_bnd_cd" value="<%= io_bnd_cd%>">
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
					<td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;AWK Cargo Tariff History - T/S</td>
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