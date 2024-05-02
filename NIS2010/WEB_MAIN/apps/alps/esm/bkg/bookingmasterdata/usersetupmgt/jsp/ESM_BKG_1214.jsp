<%
/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ESM_BKG_1214.jsp
*@FileTitle : BKG ALLOCATION Multi POL/POD
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
===============================================================================
 ========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	Exception serverException   = null;				//서버에서 발생한 에러
	String strErrMsg 			= "";				//에러메세지
	int rowCount	 			= 0;				//DB ResultSet 리스트의 건수

	String successFlag 			= "";
	String codeList  			= "";
	String pageRows  			= "100";

	String strUsr_id			= "";
	String strUsr_nm			= "";

	String trunkLaneCd			= "";
	String trunkDirCd			= "";
	String locMultiCd			= "";
	String locCdTp  			= "";
	String orgSheet				= "";
	String orgRow				= "";
	String orgUiId				= "";

	try {
		trunkLaneCd				= JSPUtil.getNull(request.getParameter("trnk_slan_cd"));
		trunkDirCd				= JSPUtil.getNull(request.getParameter("trnk_dir_cd"));
		locCdTp					= JSPUtil.getNull(request.getParameter("loc_cd_tp"));
		locMultiCd				= JSPUtil.getNull(request.getParameter("loc_multi_cd"));
		orgSheet				= JSPUtil.getNull(request.getParameter("org_sheet"));
		orgRow					= JSPUtil.getNull(request.getParameter("org_row"));
		orgUiId					= JSPUtil.getNull(request.getParameter("org_ui_id"));
		
		
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


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
<title>Multi POL/POD Input</title>
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
<input type="hidden" name="trunk_lane_cd" value="<%=trunkLaneCd%>">
<input type="hidden" name="loc_multi_cd" value="<%=locMultiCd%>">
<input type="hidden" name="loc_cd_tp" value="<%=locCdTp%>">
<input type="hidden" name="org_sheet" value="<%=orgSheet%>">
<input type="hidden" name="org_row" value="<%=orgRow%>">
<input type="hidden" name="org_ui_id" value="<%=orgUiId%>">


<!-- 개발자 작업	-->
<!-- <!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
	<tr>
		<td class="top"></td>
	</tr>
	<tr>
		<td valign="top">
			<!-- : ( Title ) (S) -->
			<table width="100%" border="0">
				<tr>
					<td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Multi POL/POD Input</td>
				</tr>
			</table>
			<!-- : ( Title ) (E) -->


			<!-- TABLE '#D' : ( Search Options ) (S) -->
			<table width="100%" class="search">
				<tr>
					<td width="100%" class="bg">
						<table width="100%" border="0">
							<tr class="h23">
								<td width="100" id="aloc_type_lane">Trunk Lane</td>
								<td width=""><input name="trunk_lane_cd" type="text" style="width:120;text-align:center;" class="input2" value="<%=trunkLaneCd%>" readOnly></td>
							</tr>
							<tr class="h23">
								<td width="100" id="aloc_type_bd">Trunk BD</td>
								<td width=""><input name="trunk_dir_cd" type="text" style="width:120;text-align:center;" class="input2" value="<%=trunkDirCd%>" readOnly></td>
							</tr>
						</table>
					</td>
				</tr>
			</table>

			<table class="height_10"><tr><td></td></tr></table>

			<!-- TABLE '#D' : ( Gird BG Box ) (S) -->
			<table width="100%" class="search" border="0">
				<tr>
					<td class="bg">
						<!-- : ( Grid ) (S) -->
						<table width="100%" id="mainTable">
	                        <tr>
	                        	<td>
	                            	<script language="javascript">ComSheetObject('sheet1');</script>
	                        	</td>
	                        </tr>
	                    </table>
						<!-- : ( Grid ) (E) -->
	
					</td>
				</tr>
			</table>
			<!-- TABLE '#D' : ( Grid BG Box ) (E) -->

			<!-- TABLE '#D' : ( Button : pop ) (S) -->
			<table width="100%" class="sbutton">
		       	<tr>
		       		<td height="71" class="popup">
		       			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
		       				<tr>
		       					<td class="btn3_bg"> 
									<table border="0" cellpadding="0" cellspacing="0">
										<tr>
											<!-- Repeat Pattern -->
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn1_left"></td>
														<td class="btn1" id="btn_add" name="btn_add">Add</td>
														<td class="btn1_right"></td>
													</tr>
												</table>
											</td>
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn1_left"></td>
														<td class="btn1" id="btn_delete" name="btn_delete">Delete</td>
														<td class="btn1_right"></td>
													</tr>
												</table>
											</td>
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn1_left"></td>
														<td class="btn1" id="btn_apply" name="btn_apply">Apply</td>
														<td class="btn1_right"></td>
													</tr>
												</table>
											</td>
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn1_left"></td>
														<td class="btn1" id="btn_close" name="btn_close">Close</td>
														<td class="btn1_right"></td>
													</tr>
												</table>
											</td>
											<!-- Repeat Pattern -->
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			<!-- TABLE '#D' : ( Button : pop ) (E) -->
		</td>
	</tr>
</table>
<!-- <!-- OUTER - POPUP (E)-->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>