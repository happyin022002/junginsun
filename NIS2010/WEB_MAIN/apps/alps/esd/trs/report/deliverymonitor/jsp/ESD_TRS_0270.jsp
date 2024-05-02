<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TRS_0270.jsp
*@FileTitle : Delivery Monitor Detail
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
===============================================================================
 History
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.bizcommon.util.BizComUtil"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.trs.report.deliverymonitor.event.EsdTrs0270Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsdTrs0270Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id	= "";
	String strUsr_nm	= "";
	String strRhq_ofc_cd= "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strRhq_ofc_cd  = account.getRhq_ofc_cd();

		event = (EsdTrs0270Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
	
	String selBOUND  = JSPUtil.getCodeCombo("s_bnd_cd", "01", "style='width:80'", "CD00591", 0, "000010:ALL:ALL");
	String selSTATUS = JSPUtil.getCodeCombo("s_sts_cd", "01", "style='width:80'", "CD00591", 0, "000010:ALL:ALL");
%>
<html>
<head>
<title>Delivery Monitor Detail</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">

	<%=JSPUtil.getIBCodeCombo("f_rhq_cd" , "", "CD00961", 0, "")%>
	<%=BizComUtil.getIBCodeCombo("po_local_curr_cd", "01", "CURR", 2, "")%>
	
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
<form  name="form">
<input type="hidden" name="f_cmd">

<!-- 개발자 작업	-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;padding-right:5;">
	<tr>
		<td valign="top">
			<!--Page Title, Historical (S)-->
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
				<tr><td class="history"></td></tr>
				<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"> Delivery Monitoring Detail</td></tr>
			</table>
			<!--Page Title, Historical (E)-->
	
	    	<!--Button (S) -->
	        <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:2;"> 
		        <tr>
			        <td class="btn1_bg">
			            <table border="0" cellpadding="0" cellspacing="0">
				            <tr>
				                <td>
				                	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					                    <tr>
						                    <td class="btn1_left"></td>
						                    <td class="btn1" name="btn_retrieve">Retrieve</td>
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
    	
			<!--biz page (S)-->			
			<table class="height_8"><tr><td></td></tr></table>
			
			<table class="search"> 
				<tr>
					<td class="bg" style="height:315" valign="top">
						<div id="sheetLayer" style="display:inline">
							<!-- Grid  (S) -->
							<table width="100%"  id="mainTable">
								<tr>
									<td width="100%">
										<script language="javascript">ComSheetObject('sheet1');</script>
									</td>
								</tr>
							</table>
							<!-- Grid (E) -->
						</div>

						<!--  Button_Sub (S) -->
						<table width="100%" class="button"> 
					       	<tr>
						       	<td class="btn2_bg">
									<table border="0" cellpadding="0" cellspacing="0">
										<tr>
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" name="btng_socreation">S/O Creation</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" name="btng_soinquiry">S/O Inquiry</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" name="btng_woissue">W/O Issue</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" name="btng_wopreview">W/O Preview</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" name="btng_downxcel">Down Excel</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
				    	<!-- Button_Sub (E) -->		

					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>

<!-- 개발자 작업  끝 -->
</form>

<form name="soForm">
	<input type="hidden" name="s_cop_no">
	<input type="hidden" name="s_cost_act_grp_seq">
	<input type="hidden" name="s_so_ofc_cd">
	<input type="hidden" name="s_so_tp_cd">
	<input type="hidden" name="s_bkg_no">
	<input type="hidden" name="s_cntr_no">
	<input type="hidden" name="sowonumber">
	<input type="hidden" name="s_rail_cd">
	<input type="hidden" name="trsp_so_ofc_cty_cd">
	<input type="hidden" name="trsp_so_seq">

	<input type="hidden" name="pgmNo">
</form>

</body>
</html>