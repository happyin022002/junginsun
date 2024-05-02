<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_opf_0054.jsp
*@FileTitle : Stevedore Damage History
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.22
*@LastModifier : 이선영
*@LastVersion : 1.0
* 2009.06.22 이선영
* 1.0 Creation
* 2012.02.03 김민아 [CHM-201215702-01] [VOP-OPF] SDMS No. 정의 및 칼럼 정리 : SDMS No. 보완 및 Report No. 제거
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.vop.opf.stevedoredamagemgt.stevedoredamagemgt.event.VopOpf0054Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.util.StringUtil" %>
<%
	VopOpf0054Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.StevedoreDamageMgt.StevedoreDamageMgt");
	
	String stvDmgNo = "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (VopOpf0054Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		stvDmgNo = StringUtil.xssFilter(request.getParameter("stv_dmg_no"));

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Stevedore Damage History</title>
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

<body class="popup_bg" onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- Report Designer 에 필요한 Input Box -->
<input type="hidden" name="com_mrdPath">
<input type="hidden" name="com_mrdArguments">
<input type="hidden" name="com_mrdSaveDialogDir" value="c:\\MyFolder\\">
<input type="hidden" name="com_mrdSaveDialogFileName" value="StevedoreDamageHistory">
<input type="hidden" name="com_mrdSaveDialogFileExt" value="pdf">
<input type="hidden" name="com_mrdSaveDialogFileExtLimit" value="xls@pdf@bmp@tif">
<input type="hidden" name="com_mrdDisableToolbar">
<input type="hidden" name="com_mrdTitle" value="Stevedore Damage History">
<input type="hidden" name="com_mrdBodyTitle" value="Stevedore Damage History">
<input type="hidden" name="stv_dmg_no" value="<%=stvDmgNo %>">


<!-- 개발자 작업	-->

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;   Stevedore Damage History</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!--biz page (S)-->
		<!-- 1 (S) -->
		<table class="search" id="mainTable">
       		<tr><td class="bg">
			
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:100%;">
				<tr class="h23">
					<td width="70">VVD CD</td>
					<td width="140"><input type="text" name="vsl_cd" style="width:40;" class="input2" readonly>&nbsp;<input type="text" name="skd_voy_no" style="width:40;" class="input2" readonly>&nbsp;<input type="text" name="skd_dir_cd" style="width:25;" class="input2" readonly></td>
					<td width="70">Port</td>
					<td width="120"><input type="text" name="vps_port_cd" style="width:100;" class="input2" readonly></td>
					<td width="90">Damage Date</td>
					<td width="130"><input type="text" name="stv_dmg_evnt_dt" style="width:80;" class="input2" readonly></td>
					<td width="35">Lane</td>
					<td width=""><input type="text" name="slan_cd" style="width:40;" class="input2" readonly></td>
					</tr>
				</table>
				<table class="search" border="0" style="width:100%;">
				<tr class="h23">
					<td width="70">SDMS No.</td>
					<td width="330"><input type="text" name="stv_dmg_no_temp" style="width:113;" class="input2" value="<%=stvDmgNo.substring(0, 4)+'-'+stvDmgNo.substring(4)%>" readonly></td>
					<td width="140">Claim Handling Office</td>
					<td><input type="text" name="clm_hndl_ofc_cd" style="width:155;" class="input2" readonly></td>
				</tr>
				</table>				
				<!--  biz_1   (E) -->
			
		</td></tr></table>
		<!-- 1 (E) -->
		
		<table class="height_8"><tr><td></td></tr></table>

		<!-- 2 (S) -->
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">
			
					<!-- : Grid - 1 (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
					<!-- : Grid - 1 (E) -->			
					
								
		</td></tr>
		</table>
		<!-- 2 (E) -->
		<!--biz page (E)--> 
<table class="height_5"><tr><td></td></tr></table>
		

</td></tr></table>
	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
	<tr><td height="71" class="popup">

    	<!--Button (S) -->	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr>
       	<td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
		    <td>
		    	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
				<tr>
					<td class="btn1_left"></td>
					<td class="btn1" name="btn_Print">Print</td>
					<td class="btn1_right"></td>
				</tr>
				</table>
			</td>
			<td class="btn1_line"></td>		
			<td>
				<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
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
    	<!--Button (E) -->
	
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>