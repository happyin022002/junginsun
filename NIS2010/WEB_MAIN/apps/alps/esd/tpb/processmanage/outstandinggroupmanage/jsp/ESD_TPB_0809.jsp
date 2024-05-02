<%
/*=========================================================
*Copyright(c) Since 2009 CyberLogitec
*@FileName : ESD_TPB_0809.jsp
*@FileTitle : 3rd Party Target Selection
*Open Issues :
*Change history :
*@LastModifyDate : 2009-09-08
*@LastModifier : Sun, Choi
*@LastVersion : 1.1
* 2009-08-12 O Wan-Ki  1.0 최초 생성
* 2009-09-08 Sun, CHOI 1.1 ALPS Migration
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.tpb.processmanage.outstandinggroupmanage.event.EsdTpb0809Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsdTpb0809Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.ProcessManage.OutstandingGroupmanage");
	
	String currentDay = DateTime.getFormatString("yyyy-MM-dd");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsdTpb0809Event)request.getAttribute("Event");
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
<title>3rd Party Target Selection</title>
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
<!-- 개발자 작업	-->

<input type="hidden" name="s_vndr_cnt_cd">
<input type="hidden" name="s_vndr_seq">
<input type="hidden" name="s_cust_cnt_cd">
<input type="hidden" name="s_cust_seq">
<input type="hidden" name="s_n3pty_ofc_cd">
<input type="hidden" name="s_src_vndr_cnt_cd">
<input type="hidden" name="s_src_vndr_seq">
<input type="hidden" name="sdate" value="<%=DateTime.addDays(currentDay, -7, "yyyy-MM-dd")%>">
<input type="hidden" name="edate" value="<%=currentDay%>">
<div id="wait_img" style="position:absolute; visibility:hidden;">
<img src="/hanjin/img/alps/processing.gif" width="343" height="121" border="0">
</div>

<!-- OUTER FRAME : "to make sum of components' HEIGHTS 100%" (S)tart -->
<table width="100%" class="popup" cellpadding="10"> 
	<tr>
		<td class="top"></td>
	</tr>
	<tr>
		<td valign="top">
	
			<!-- : ( Title ) (S) -->
			<table width="100%" border="0">
				<tr>
					<td height="79" class="title"><img src="img/icon_title_dot.gif" align="absmiddle"> 3rd Party Target Selection</td>
				</tr>
			</table>
			<!-- : ( Title ) (E) -->
				
			<table height="10"><tr><td></td></tr></table>
					 
			<table class="search" border="0" style="width:300;">
				<tr class="h23">
					<td class="bg_a">
					
						<table class="search" border="0" style="width:300;" cellpadding="5" cellspacing="5">
							<tr class="h23">
								<td>
									<%//=JSPUtil.getCodeCombo("s_vndr_cust_div_cd", "", "style='width:100'", "CD00583", 0, "001: :&lt;&lt;Select&gt;&gt;|")%>
									<%=JSPUtil.getCodeCombo("s_vndr_cust_div_cd", "", "style='width:100' required caption='3rd Party'", "CD00583", 0, "001: :&lt;&lt;Select&gt;&gt;|")%>
									<input type="text" style="width:100;" name="s_trd_party_val" maxlength="8" !readonly>&nbsp;<img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_3rdParty"> 
								</td>
							</tr>
							<tr class="h23">					
								<td>
									&nbsp;<input type="text" style="width:300; display:none" name="s_trd_party_nm" readonly>
								</td>
							</tr>
						</table>
					
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>

<!-- : ( Button : Sub ) (S) -->
<table width="100%" class="sbutton">
	<tr>
		<td height="71" class="popup">

			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       			<tr>
       				<td class="btn3_bg">
					    <table border="0" cellpadding="0" cellspacing="0">
					    	<tr>
					    		<td>       								
									<table border="0" cellpadding="0" cellspacing="0">
										<tr>
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn1_left"></td>
														<td class="btn1" name="btn_ok">OK</td>
														<td class="btn1_right"></td>
													</tr>
												</table>
											</td>
											<td width="10"></td>
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
					</td>
				</tr>
			</table>

		</td>
	</tr>
</table>

</form>
</body>
</html>