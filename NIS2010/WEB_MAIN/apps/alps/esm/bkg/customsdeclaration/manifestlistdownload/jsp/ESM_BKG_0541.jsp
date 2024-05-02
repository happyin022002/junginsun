<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0541.jsp
*@FileTitle : US AMS: Main Menu
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.18
*@LastModifier : 이수빈
*@LastVersion : 1.0
* 2009.08.18 이수빈
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
<%@ page import="org.apache.log4j.Logger" %>

<%
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
    String strOfc_cd        = "";
    String strPgmNo         = "";
    String strOfcType       = "";
	Logger log = Logger.getLogger("com.hanjin.apps.CustomsDeclaration.ManifestListDownload");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
        strOfc_cd = account.getOfc_cd();

		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		strPgmNo = request.getParameter("pgmNo");
		if("ESM_BKG_0541".equals(strPgmNo)) strOfcType = "Origin";
        if("ESM_BKG_0541_2".equals(strPgmNo)) strOfcType = "US";
        
	}catch(Exception e) {
		out.println(e.toString());
	}
	
%>
<html>
<head>
<title>US AMS: Main Menu</title>
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

<body  onLoad="setupPage();">
<form name="form" method="post">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="ofcType" value="<%=strOfcType%>">
<!-- 개발자 작업	-->
<!--  -->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;padding-right:5;">
	<tr>
		<td valign="top">

		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!--Page Title, Historical (E)-->

		<!-- : ( Search Options ) (S) -->
 
		<table class="search"> 
       	<tr><td class="bg">

			<table class="search" border="0" style="width:400;">
				<tr class="h23">
					<td width="30">VVD</td>
					<td width="110"><input type="text" name="vvd_cd" style="width:80;" value="" dataformat="engupnum" maxlength="9"></td>
					<td width="30">POL</td>
					<td width="90"><input type="text" name="pol_cd" style="width:50;" value="" dataformat="engup" maxlength="5"></td>
					<td width="30">POD</td>
					<td width="90"><input type="text" name="pod_cd" style="width:50;" value="" dataformat="engup" maxlength="5"></td>
			   </tr>
			</table>   
			<table class="search" border="0" style="width:979;">			   
			<tr class="h23">
				<td width="450" valign="top">
						<table class="search" border="0">
							<tr><td class="title_h"></td>
								<td class="title_s">Origin Office</td></tr>
						</table>
						<table class="search_sm" border="0">
							<tr>
								<td>
									<table class="search" border="0">
										<tr class="h23"><td>Preparation</td></tr>
									</table>
									<table class="search" border="0" style="width:390;"> 
									<tr class="h23">
										<td width=""><table width="350" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr><td class="btn2_left"></td>
											<td class="btn2" name="btn_1_1" style="text-align:left;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
												<span id="btn_1_1" onmouseover="obj_MouseOver('btn_1_1')" onmouseout="obj_MouseOut('btn_1_1')">1. Manifest Data Input Cross-Check</span></td>
											<td class="btn2_right"></td>
											</tr>
											</table></td>
									</tr>
									<tr class="h23">
										<td width=""><table width="350" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr><td class="btn2_left"></td>
											<td class="btn2" name="btn_1_2" style="text-align:left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
												<span id="btn_1_2" onmouseover="obj_MouseOver('btn_1_2')" onmouseout="obj_MouseOut('btn_1_2')">2. House B/L Data Input Cross-Check</span></td>
											<td class="btn2_right"></td>
											</tr>
											</table></td>
									</tr>
									</table>
									<table class="height_10"><tr><td colspan="8"></td></tr></table>	
									<table class="search" border="0">
									<tr class="h23"><td>Manifest Transmit</td></tr>
									</table>
									<table class="search" border="0" style="width:390;"> 
									<tr class="h23">
										<td width=""><table width="350" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr><td class="btn2_left"></td>
											<td class="btn2" name="btn_2_1" style="text-align:left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
												<span id="btn_2_1" onmouseover="obj_MouseOver('btn_2_1')" onmouseout="obj_MouseOut('btn_2_1')">1. Customs Data Download (D/L)</span></td>
											<td class="btn2_right"></td>
											</tr>
											</table></td>
									</tr>
									<tr class="h23">
										<td width=""><table width="350" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr><td class="btn2_left"></td>
											<td class="btn2" name="btn_2_2" style="text-align:left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
												<span id="btn_2_2" onmouseover="obj_MouseOver('btn_2_2')" onmouseout="obj_MouseOut('btn_2_2')">2.  Manifest Transmit (MI)</span></td>
											<td class="btn2_right"></td>
											</tr>
											</table></td>
									</tr>
									<tr class="h23">
										<td width=""><table width="350" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr><td class="btn2_left"></td>
											<td class="btn2" name="btn_2_3" style="text-align:left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
												<span id="btn_2_3" onmouseover="obj_MouseOver('btn_2_3')" onmouseout="obj_MouseOut('btn_2_3')">3. Vessel Departure Transmit (HI)</span></td>
											<td class="btn2_right"></td>
											</tr>
											</table></td>
									</tr>
									
									</table>
									
									<table class="height_10"><tr><td colspan="8"></td></tr></table>	
									<table class="search" border="0">
									<tr class="h23"><td>Manifest Amend</td></tr>
									</table>
									
									<table class="search" border="0" style="width:390;"> 
									<tr class="h23">
										<td width=""><table width="350" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr><td class="btn2_left"></td>
											<td class="btn2" name="btn_3_1" style="text-align:left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
												<span id="btn_3_1" onmouseover="obj_MouseOver('btn_3_1')" onmouseout="obj_MouseOut('btn_3_1')">1. Amendment Transmit (AI)</span></td>
											<td class="btn2_right"></td>
											</tr>
											</table></td>
									</tr>
									<tr class="h23">
										<td width=""><table width="350" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr><td class="btn2_left"></td>
											<td class="btn2" name="btn_3_2" style="text-align:left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
												<span id="btn_3_2" onmouseover="obj_MouseOver('btn_3_2')" onmouseout="obj_MouseOut('btn_3_2')">2. B/L Inquiry</span></td>
											<td class="btn2_right"></td>
											</tr>
											</table></td>
									</tr>
									</table>
									<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
									<table class="search" border="0">
									<tr class="h23"><td>Stowage Plan</td></tr>
									</table>
									
									<table class="search" border="0" style="width:390;"> 
									<tr class="h23">
										<td width=""><table width="350" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr><td class="btn2_left"></td>
											<td class="btn2" name="btn_4_1" style="text-align:left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
												<span id="btn_4_1" onmouseover="obj_MouseOver('btn_4_1')" onmouseout="obj_MouseOut('btn_4_1')">1. Vessel Stowage Plan Transmit (BAPLIE)</span></td>
											<td class="btn2_right"></td>
											</tr>
											</table></td>
									</tr>
									</table>
									
									<table class="height_10"><tr><td colspan="8"></td></tr></table>	
									<table class="search" border="0">
									<tr class="h23"><td>Report</td></tr>
									</table>
									<table class="search" border="0" style="width:390;"> 
									<tr class="h23">
										<td width=""><table width="350" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr><td class="btn2_left"></td>
											<td class="btn2" name="btn_AMS_1" style="text-align:left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
												<span id="btn_AMS_1" onmouseover="obj_MouseOver('btn_AMS_1')" onmouseout="obj_MouseOut('btn_AMS_1')">1. Transmission History</span></td>
											<td class="btn2_right"></td>
											</tr>
											</table></td>
									</tr>
									<tr class="h23">
										<td width=""><table width="350" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr><td class="btn2_left"></td>
											<td class="btn2" name="btn_AMS_2" style="text-align:left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
												<span id="btn_AMS_2" onmouseover="obj_MouseOver('btn_AMS_2')" onmouseout="obj_MouseOut('btn_AMS_2')">2. Receiving History</span></td>
											<td class="btn2_right"></td>
											</tr>
											</table></td>
									</tr>
									<tr class="h23">
										<td width=""><table width="350" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr><td class="btn2_left"></td>
											<td class="btn2" name="btn_AMS_3" style="text-align:left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
												<span id="btn_AMS_3" onmouseover="obj_MouseOver('btn_AMS_3')" onmouseout="obj_MouseOut('btn_AMS_3')">3. Transmission Status Cross-Check</span></td>
											<td class="btn2_right"></td>
											</tr>
											</table></td>
									</tr>
									<tr class="h23">
										<td width=""><table width="350" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr><td class="btn2_left"></td>
											<td class="btn2" name="btn_AMS_4" style="text-align:left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
												<span id="btn_AMS_4" onmouseover="obj_MouseOver('btn_AMS_4')" onmouseout="obj_MouseOut('btn_AMS_4')">4. AMS Report</span></td>
											<td class="btn2_right"></td>
											</tr>
											</table></td>
									</tr>
									<tr class="h23">
										<td width=""><table width="350" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr><td class="btn2_left"></td>
											<td class="btn2" name="btn_AMS_5" style="text-align:left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
												<span id="btn_AMS_5" onmouseover="obj_MouseOver('btn_AMS_5')" onmouseout="obj_MouseOut('btn_AMS_5')">5. Auto Filing NVOCC Transmission Status</span></td>
											<td class="btn2_right"></td>
											</tr>
											</table></td>
									</tr>
									</table>
								</td>
							</tr>
						</table>
					</td>
					<td width="" valign="top">
						<table class="search" border="0">
						<tr><td class="title_h"></td>
							<td class="title_s">U.S. Office</td></tr>
						</table>
						<table class="search_sm" border="0">
							<tr>
								<td>	
									<table class="search" border="0">
									<tr class="h23"><td>I/B Documentation</td></tr>
									</table>
									<table class="search" border="0" style="width:390;"> 
									<tr class="h23">
										<td width=""><table width="350" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr><td class="btn2_left"></td>
											<td class="btn2" name="btn_IB_1" style="text-align:left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
												<span id="btn_IB_1" onmouseover="obj_MouseOver('btn_IB_1')" onmouseout="obj_MouseOut('btn_IB_1')">1. Customs Data Download (D/L)</span></td>
											<td class="btn2_right"></td>
											</tr>
											</table></td>
									</tr>
									<tr class="h23">
										<td width=""><table width="350" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr><td class="btn2_left"></td>
											<td class="btn2" name="btn_IB_2" style="text-align:left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
												<span id="btn_IB_2" onmouseover="obj_MouseOver('btn_IB_2')" onmouseout="obj_MouseOut('btn_IB_2')">2. Manifest Transmit (MI)</span></td>
											<td class="btn2_right"></td>
											</tr>
											</table></td>
									</tr>
									<tr class="h23">
										<td width=""><table width="350" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr><td class="btn2_left"></td>
											<td class="btn2" name="btn_IB_3" style="text-align:left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
												<span id="btn_IB_3" onmouseover="obj_MouseOver('btn_IB_3')" onmouseout="obj_MouseOut('btn_IB_3')">3. EDA Adjust</span> </td>
											<td class="btn2_right"></td>
											</tr>
											</table></td>
									</tr>
									<tr class="h23">
										<td width=""><table width="350" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr><td class="btn2_left"></td>
											<td class="btn2" name="btn_IB_4" style="text-align:left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
												<span id="btn_IB_4" onmouseover="obj_MouseOver('btn_IB_4')" onmouseout="obj_MouseOut('btn_IB_4')">4. Vessel Arrival Transmit (HI)</span></td>
											<td class="btn2_right"></td>
											</tr>
											</table></td>
									</tr>
									<tr class="h23">
										<td width=""><table width="350" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr><td class="btn2_left"></td>
											<td class="btn2" name="btn_IB_5" style="text-align:left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
												<span id="btn_IB_5" onmouseover="obj_MouseOver('btn_IB_5')" onmouseout="obj_MouseOut('btn_IB_5')">5. C/A Report (I/B)</span></td>
											<td class="btn2_right"></td>
											</tr>
											</table></td>
									</tr>
									<tr class="h23">
										<td width=""><table width="350" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr><td class="btn2_left"></td>
											<td class="btn2" name="btn_IB_6" style="text-align:left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
												<span id="btn_IB_6" onmouseover="obj_MouseOver('btn_IB_6')" onmouseout="obj_MouseOut('btn_IB_6')">6. Amendment Transmit (AI)</span> </td>
											<td class="btn2_right"></td>
											</tr>
											</table></td>
									</tr>
									<tr class="h23">
										<td width=""><table width="350" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr><td class="btn2_left"></td>
											<td class="btn2" name="btn_IB_7" style="text-align:left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
												<span id="btn_IB_7" onmouseover="obj_MouseOver('btn_IB_7')" onmouseout="obj_MouseOut('btn_IB_7')">7. B/L Inquiry </span></td>
											<td class="btn2_right"></td>
											</tr>
											</table></td>
									</tr>
									<tr class="h23">
										<td width=""><table width="350" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr><td class="btn2_left"></td>
											<td class="btn2" name="btn_IB_8" style="text-align:left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
												<span id="btn_IB_8" onmouseover="obj_MouseOver('btn_IB_8')" onmouseout="obj_MouseOut('btn_IB_8')">8. B/L Inquiry by Container</span></td>
											<td class="btn2_right"></td>
											</tr>
											</table></td>
									</tr>
									<tr class="h23">
										<td width=""><table width="350" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr><td class="btn2_left"></td>
											<td class="btn2" name="btn_IB_9" style="text-align:left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
												<span id="btn_IB_9" onmouseover="obj_MouseOver('btn_IB_9')" onmouseout="obj_MouseOut('btn_IB_9')">9. Hold Notice Send</span></td>
											<td class="btn2_right"></td>
											</tr>
											</table></td>
									</tr>
									</table>
									
									
									<table class="height_10"><tr><td colspan="8"></td></tr></table>	
									<table class="search" border="0">
									<tr class="h23"><td>In-Bond Trans.</td></tr>
									</table>
									<table class="search" border="0" style="width:390;"> 
									<tr class="h23">
										<td width=""><table width="350" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr><td class="btn2_left"></td>
											<td class="btn2" name="btn_IT_1" style="text-align:left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
												<span id="btn_IT_1" onmouseover="obj_MouseOver('btn_IT_1')" onmouseout="obj_MouseOut('btn_IT_1')">1. P/MIB Generate</span></td>
											<td class="btn2_right"></td>
											</tr>
											</table></td></tr>
									<tr class="h23">
										<td width=""><table width="350" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr><td class="btn2_left"></td>
											<td class="btn2" name="btn_IT_2" style="text-align:left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
												<span id="btn_IT_2" onmouseover="obj_MouseOver('btn_IT_2')" onmouseout="obj_MouseOut('btn_IT_2')">2. P/MIB Arrival & Export Transmit</span></td>
											<td class="btn2_right"></td>
											</tr>
											</table></td></tr>
									<!-- tr class="h23">
										<td width=""><table width="350" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr><td class="btn2_left"></td>
											<td class="btn2" name="btn_IT_3" style="text-align:left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
												<span id="btn_IT_3" onmouseover="obj_MouseOver('btn_IT_3')" onmouseout="obj_MouseOut('btn_IT_3')">3. In-Transit Goods Manifest (SED Form 7513)</span></td>
											<td class="btn2_right"></td>
											</tr>
											</table></td>
									</tr -->
									</table>	
									<table class="height_10"><tr><td colspan="8"></td></tr></table>	
										<table class="search" border="0">
									<tr class="h23"><td>Code / Setup</td></tr>
									</table>
									<table class="search" border="0" style="width:390;"> 
									<tr class="h23">
										<td width=""><table width="350" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr><td class="btn2_left"></td>
											<td class="btn2" name="btn_CS_1" style="text-align:left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
												<span id="btn_CS_1" onmouseover="obj_MouseOver('btn_CS_1')" onmouseout="obj_MouseOut('btn_CS_1')">1. Entry Type Setup</span></td>
											<td class="btn2_right"></td>
											</tr>
											</table></td></tr>
									</table>
									<table style="height:71"><tr><td colspan="8"></td></tr></table>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			</td>	
		</tr>
		</table>
				
		
			
		<table class="height_10"><tr><td colspan="8"></td></tr></table>	
		<!--Button (S) -->
			
<!-- : ( Search Options ) (E) -->
</td></tr>
</table> 

</form>
</body>
</html>
