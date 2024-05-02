<%
	/*=========================================================
	 *Copyright(c) 2009 CyberLogitec
	 *@FileName : esm_bkg_0543.jsp
	 *@FileTitle : ESM_BKG-0543
	 *Open Issues :
	 *Change history : 
	 *@LastModifyDate : 2009.06.18
	 *@LastModifier : 김도완
	 *@LastVersion : 1.0
	 * 2009.06.09 김도완
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
	import="com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.event.EsmBkg0543Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmBkg0543Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지
	//int rowCount = 0; //DB ResultSet 리스트의 건수

	//String successFlag = "";
	//String codeList = "";
	//String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	String vvdCd = "";
	String polCd = "";
	String podCd = "";
	//Logger log = Logger.getLogger("com.hanjin.apps.CustomsDeclaration.ManifestListDownload");

	try {
		
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg0543Event) request.getAttribute("Event");
		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		vvdCd	= JSPUtil.getParameter(request, "vvd_cd");
		polCd  = JSPUtil.getParameter(request, "pol_cd");
		podCd  = JSPUtil.getParameter(request, "pod_cd");
		
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		//GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	} catch (Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title></title>
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
<form name="form">
<input type="hidden" name="f_cmd"> 
<input type="hidden" name="pagerows"> 
<input type="hidden" name="form1_vvd_cd" value="<%=vvdCd%>">
<input type="hidden" name="form1_pod_cd" value="<%=podCd%>">
<input type="hidden" name="transmit_cd" value="HI"> 
<!-- 개발자 작업	-->

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
<tr><td valign="top">
	<!--Page Title, Historical (S)-->
	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
	</table>
	<!--Page Title, Historical (E)-->
		
	<!-- : ( Search Options ) (S) -->
 
	<table class="search" id="mainTable">  
     	<tr><td class="bg">
			<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="35">VVD</td>
					<td width="110"><input type="text" name="vvd" style="width:80;" class="input1" value="<%=vvdCd%>" dataformat="eng" maxlength="9" required></td>
					<td width="30">POL</td>
					<td width="110"><input type="text" name="pol_cd" style="width:60;" class="input1" value="<%=polCd%>" dataformat="engupnum" maxlength="5" required></td> 
					<td width="30">POD</td>
					<td width="170"><input type="text" name="pod_cd" style="width:60;" class="input1" value="<%=podCd%>"  dataformat="engupnum" maxlength="5" required></td> 
					<td width="85">M.B/L Count</td>
					<td width=""><input type="text" name="bl_count" style="width:60;" class="input" value="" dataformat="int"></td> 
				</tr>
			</table>
				
			<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
				
			<table class="search" border="0" style="width:680;"> 
				<tr class="h23">
					<td width="35">Name</td>
					<td width="250"><input type="text" name="name" style="width:175;" class="input2" value=""  readonly></td>
					<td width="60">ATD/ETD</td>
					<td width="180"><input type="text" name="atd" style="width:80;" class="input2" value=""  readonly>&nbsp;<input type="text" name="atd_time" style="width:45;" class="input2" value=""  readonly></td>
					<td width="30">ETA</td>
					<td width=""><input type="text" name="eta" style="width:80;" class="input2" value=""  readonly>&nbsp;<input type="text" name="eta_time" style="width:45;" class="input2" value=""  readonly></td>
				</tr>
			</table>
				
			<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
				
			<table class="search" border="0" style="width:680;"> 
				<tr class="h23">
					<td width="80">MI Transmit</td>
					<td width="203"><input type="text" name="mi_transmit" style="width:80;" class="input2"  value=""  readonly>&nbsp;<input type="text" name="mi_transmit_time" style="width:45;" class="input2" value=""  readonly></td>
					<td width="80">HI Transmit</td>
					<td width=""><input type="text" name="hi_transmit" style="width:80;" class="input2"  value=""  readonly>&nbsp;<input type="text" name="hi_transmit_time" style="width:45;" class="input2" value=""  readonly>
						<input type="text" name="snd_usr_id" style="width:80;" class="input2"  value=""  readonly>
					</td>
					
				</tr>
			</table>
			
		</td></tr>
	</table>
<!-- : ( Search Options ) (E) -->
</td></tr>
</table> 

	


<!--Button (S) -->
<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
	<tr><td class="btn1_bg">
		<table border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td>
					<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
						<td class="btn1_right"></td>
						</tr>
					</table>
				</td>
				<td class="btn1_line"></td>
				<td>
					<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_Transmit" id="btn_Transmit">Transmit</td>
						<td class="btn1_right"></td>
					</tr>
					</table>
				</td>
			</tr>
		</table>
	</td></tr>
</table>
<!--Button (E) -->
<br>
<table width="100%" height="200" id="mainTable" style="display:none">
	<tr>
		<td width="100%" height="200"><script language="javascript">ComSheetObject('sheet1');</script></td>
	</tr>
</table>

<!-임시 (S)-->
<!-- 
<table style="width:979;height:100">
	<tr><td>result : </td></tr>
	<tr>
		<td><textarea name="output" cols="100" rows="20"></textarea></td>
	</tr>
</table>
 -->
</form>	    
</body>
</html>