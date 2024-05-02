<%
/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ESD_TRS_3018.jsp
*@FileTitle : Inland Cost Management – Location Group
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
===============================================================================
 History
 2012.05.29 변종건 [CHM-201217633] Inland Cost Management – Location Group 생성
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.trs.costmanage.inlandcostmanage.event.EsdTrs3018Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsdTrs3018Event  event 		= null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;				//서버에서 발생한 에러
	String strErrMsg 			= "";				//에러메세지
	int rowCount	 			= 0;				//DB ResultSet 리스트의 건수

	String successFlag 			= "";
	String codeList  			= "";
	String pageRows  			= "100";

	String strUsr_id			= "";
	String strUsr_nm			= "";

	String cntCd				= "";
	String costTrfNo			= "";
	String stsNm				= "";
	String ioBndNm				= "";
	String currCd				= "";
	String effFmDt				= "";
	String updDt				= "";
	String updUsrId				= "";


	try {
		cntCd					= JSPUtil.getNull(request.getParameter("cnt_cd"));
		costTrfNo				= JSPUtil.getNull(request.getParameter("cost_trf_no"));
		ioBndNm					= JSPUtil.getNull(request.getParameter("io_bnd_nm"));
		stsNm					= JSPUtil.getNull(request.getParameter("sts_nm"));
		currCd					= JSPUtil.getNull(request.getParameter("curr_cd"));
		effFmDt					= JSPUtil.getNull(request.getParameter("eff_fm_dt"));
		updDt					= JSPUtil.getNull(request.getParameter("upd_dt"));
		updUsrId				= JSPUtil.getNull(request.getParameter("upd_usr_id"));
		
		
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsdTrs3018Event)request.getAttribute("Event");
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
<title>Inland Cost Management – Location Group</title>
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
					<td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Inland Cost Management – Location Group</td>
				</tr>
			</table>
			<!-- : ( Title ) (E) -->


			<!-- TABLE '#D' : ( Search Options ) (S) -->
			<table width="100%" class="search">
				<tr>
					<td width="100%" class="bg">
						<table width="100%" border="0">
							<tr class="h23">
								<td width="80">Country</td>
								<td width="190"><input name="cnt_cd" type="text" style="width:100;text-align:center;" class="input2" value="<%=cntCd%>" readOnly></td>
								<td width="100">Cost Tariff No</td>
								<td width="100"><input name="cost_trf_no" type="text" style="width:100;text-align:center;" class="input2" value="<%=costTrfNo%>" readOnly></td>
							</tr>
							<tr class="h23">
								<td width="80">Bound</td>
								<td width="190"><input name="io_bnd_nm" type="text" style="width:100;text-align:center;" class="input2" value="<%=ioBndNm%>" readOnly></td>
								<td width="100">Status</td>
								<td width="100"><input name="sts_nm" type="text" style="width:100;text-align:center;" class="input2" value="<%=stsNm%>" readOnly></td>
							</tr>
							<tr class="h23">
								<td width="80">Currency</td>
								<td width="190"><input name="curr_cd" type="text" style="width:100;text-align:center;" class="input2" value="<%=currCd%>" readOnly></td>
								<td width="100">Effective From</td>
								<td width="100"><input name="eff_fm_dt" type="text" style="width:100;text-align:center;" class="input2" value="<%=effFmDt%>" readOnly></td>
							</tr>
							<tr class="h23">
								<td width="80">Update Date</td>
								<td width="190"><input name="upd_cd" type="text" style="width:100;text-align:center;" class="input2" value="<%=updDt%>" readOnly></td>
								<td width="100">User</td>
								<td width="100"><input name="upd_usr_id" type="text" style="width:100;text-align:center;" class="input2" value="<%=updUsrId%>" readOnly></td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			
			<table class="height_10"><tr><td></td></tr></table>
			
			<table width="100%" class="search">
				<tr>
					<td width="100%" class="bg">
						<table width="100%" border="0">
							<tr class="h23">
								<td width="190"><input name="grp_radio" type="radio" value="I" class="trans" Onclick="change_grp_radio('I');" checked>&nbsp;Group by Interval</td>
								<td width="30">From</td>
								<td width="50"><input name="from_amt" type="text" dataformat="num" style="width:40;text-align:right;" class="input" value="0" maxlength="4"></td>
								<td width="50">Amount</td>
								<td width="50"><input name="itval_amt" type="text" dataformat="num" style="width:40;text-align:right;" class="input" value="" maxlength="4"></td>
								<td width="100">
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" id="btn_apply1" name="btn_apply1">Apply</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			<!-- TABLE '#D' : ( Search Options ) (E) -->

			<table class="height_10"><tr><td></td></tr></table>

			<!-- TABLE '#D' : ( Gird BG Box ) (S) -->
			<table width="100%" class="search" border="0">
				<tr>
					<td class="bg">
						<!-- : ( Grid ) (S) -->
						<table width="100%" id="mainTable">
							<tr>
								<td>
									<table width="100%" border="0">
										<tr class="h23">
											<td width="370"><input name="grp_radio" type="radio" value="A" class="trans" Onclick="change_grp_radio('A');">&nbsp;Group by Amount Tier</td>
											<td width="100">
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn1_left"></td>
														<td class="btn1" id="btn_apply2" name="btn_apply2">Apply</td>
														<td class="btn1_right"></td>
													</tr>
												</table>
											</td>
										</tr>
									</table>
								</td>
							</tr>
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