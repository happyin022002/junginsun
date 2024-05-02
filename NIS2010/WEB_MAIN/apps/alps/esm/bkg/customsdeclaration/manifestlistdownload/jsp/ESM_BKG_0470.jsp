
<%
	/*=========================================================
	 *Copyright(c) 2009 CyberLogitec
	 *@FileName : esm_bkg_0470.jsp
	 *@FileTitle : ESM_BKG-0470
	 *Open Issues :
	 *Change history :
	 *@LastModifyDate : 2009.06.03
	 *@LastModifier : 김승민
	 *@LastVersion : 1.0
	 * 2009.06.03 김승민
	 * 1.0 Creation
	 =========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page
	import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page
	import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page
	import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page
	import="com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.japan.event.EsmBkg0470Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmBkg0470Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지
	//int rowCount = 0; //DB ResultSet 리스트의 건수

	//String successFlag = "";
	//String codeList = "";
	//String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	String bl_no= "";
	String vvd_cd= "";
	String pod_cd= "";
	//Logger log = Logger.getLogger("com.hanjin.apps.CustomsDeclaration.ManifestListDownload");

	try {
		bl_no= request.getParameter("bl_no")==null?"":request.getParameter("bl_no");
		vvd_cd= request.getParameter("vvd_cd")==null?"":request.getParameter("vvd_cd");
		pod_cd= request.getParameter("pod_cd")==null?"":request.getParameter("pod_cd");
		
		SignOnUserAccount account = (SignOnUserAccount) session
				.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg0470Event) request.getAttribute("Event");
		serverException = (Exception) request
				.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException)
					.loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		//GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	} catch (Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>ESM_BKG-0470</title>
<meta http-eqEsmv="Content-Type" content="text/html; charset=UTF-8">
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
<form name="form">
<input type="hidden" name="f_cmd"> 
<input type="hidden" name="pagerows"> 
<input type="hidden" name="in_vvd_cd">
<input type="hidden" name="in_pod_cd">
<input type="hidden" name="in_pod_cd_split">
<input type="hidden" name="form1_eta_dt2" value="">
<input type="hidden" name="form1_etb_dt1" value="">
<input type="hidden" name="form1_etb_dt2" value="">
<input type="hidden" name="form1_arr_yd_cd" value="">
<input type="hidden" name="form1_lodg_wgt" value="">
<input type="hidden" name="form1_cstms_mf_cd" value="">
<!-- 개발자 작업	-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
	<!--top menu (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0"
			class="title">
			<tr>
				<td class="history"><img src="img/icon_history_dot.gif"
					align="absmiddle"><span id="navigation"></span></td>
			</tr>
			<tr>
				<td class="title"><img src="img/icon_title_dot.gif"
					align="absmiddle"><span id="title"></span></td>
			</tr>
		</table>
		<!--top menu (E)-->
	</td></tr>
	
	
	
	
	
	
	
	
	<tr><td valign="top" width="100%">

	
	<!--Button (S) -->
		
    <!--Button (E) -->
	<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">
			<table class="search" border="0" style="width:600;"> 
				<tr class="h23">
					<td width="65">VVD</td>
					<td width="336"><input type="text" style="width:100;" value="" name="form1_in_vvd_cd" dataformat="uppernum" maxlength="9" class="input1" style="ime-mode:disabled"></td>
					<td width="30">POD</td>
					<td><input type="text" style="width:60;" value="" name="form1_in_pod_cd" class="input1" dataformat="upper" maxlength="5" style="ime-mode:disabled">&nbsp;<input type="text" style="width:30;" name="form1_in_pod_cd_split" value="" maxlength="2" dataformat="uppernum" class="input1" style="ime-mode:disabled"></td>
				</tr>
		</table> 
		<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
		<table class="search" border="0" style="width:600;"> 
				<tr class="h23">
					<td width="65">ETA</td>
					<td width=""><input type="text" style="width:100;" value="" name="form1_eta_dt1" dataformat="ymd" class="input" maxlength="8"></td>
				</tr>
		</table> 
		<table class="search" border="0" style="width:600;"> 
				<tr class="h23">
					<td width="65">Remark(s)</td>
					<td width=""><input type="text" style="width:500;" value="" name="form1_mf_rmk" dataformat="uppernum2" class="input" style="ime-mode:disabled" maxlength="4000"></td>
				</tr>
		</table> 
		
			</td></tr>
		</table>
			<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" id="btn_retrieve" name="btn_retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				
				<td class="btn1_line"></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_transmit">Transmit</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			</tr>
			</table>
		</td></tr>
		</table>
    <!--Button (E) -->
			</td></tr>
		</table>
	<!-- Grid BG Box  (S) -->
	<!--biz page (E)-->
	<table class="height_10"><tr><td colspan="8"></td></tr></table>
	
	    <table width="100%" id="mainTable" style="display:none">
	        <tr>
	            <td width="100%"><script language="javascript">ComSheetObject('sheet1');</script></td>
	        </tr>
	    </table>		

</form>
</body>
</html>