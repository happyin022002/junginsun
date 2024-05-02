
<%
	/*=========================================================
	 *Copyright(c) 2009 CyberLogitec
	 *@FileName : ui_booking_util.jsp
	 *@FileTitle : Booking Page
	 *Open Issues :
	 *Change history :
	 *@LastModifyDate : 2009.04.23
	 *@LastModifier : 김기종
	 *@LastVersion : 1.0
	 * 2009.04.23 김기종
	 * 1.0 Creation
	 =========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page
	import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page
	import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page
	import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page
	import="com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.event.EsmBookingUtilEvent"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmBookingUtilEvent event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지

	String strUsr_id = "";
	String strUsr_nm = "";

	try {
		SignOnUserAccount account = (SignOnUserAccount) session
				.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBookingUtilEvent) request.getAttribute("Event");
		serverException = (Exception) request
				.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException)
					.loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		//GeneralEventResponse eventResponse = (GeneralEventResponse) request
		//		.getAttribute("EventResponse");

	} catch (Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Booking Page</title>
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
<form name="form"><input type="hidden" name="f_cmd"> <input
	type="hidden" name="pagerows"> <!-- 개발자 작업	-->
<table width="747" class="popup" cellpadding="10" border="0">
	<tr>
		<td class="top"></td>
	</tr>
	<tr>
		<td valign="top"><!-- : ( Title ) (S) -->
		<table width="100%" border="0">
			<tr>
				<td class="title"><img src="img/icon_title_dot.gif"
					align="absmiddle">&nbsp; BKG UTIL SAMPLE</td>
			</tr>
		</table>
		<!-- : ( Title ) (E) --> <!-- Tab (S) -->
		<table class="tab" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td><script language="javascript">ComTabObject('tab1')</script></td>
			</tr>
		</table>
		

		<!--TAB Export (S) -->
		<div id="tabLayer" style="display: inline">
		<table class="search">
			<tr>
				<td class="bg">
				<table border="0" cellpadding="0" cellspacing="0" id="tb0_1">
					<tr>

						<td width="100">[UI_BKG-0080]</td>
						<td width="350">Booking Creation 1_Container Type/Size</td>
						<td >
						<table width="100%" border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td class="btn2_left"></td>
								<td><input type="text"
									style="width: 80; text-align: center;" class="input1"
									maxlength="4" name="cntr_tpsz_cd" required fullfill
									caption="ctn_cd" style="ime-mode:disabled">&nbsp; <img
									class="cursor" src="img/btns_search.gif" name="btn_0080pop"
									width="19" height="20" alt="" border="0" align="absmiddle">&nbsp;
								<input type="text" style="width: 122;" class="input2"
									name="cntr_tpsz_desc" readonly></td>
						</table>
						</td>


					</tr>
				</table>
				<table class="line_bluedot">
					<tr>
						<td></td>
					</tr>
				</table>
				<table border="0" cellpadding="0" cellspacing="0" id="tb0_1">
					<tr>

						<td width="100">[UI_BKG-0082]</td>
						<td width="350">Booking Creation 1_MT P/UP CY inquiry[UI_BKG_0079.jsp]</td>
						<td >
						<table width="100%" border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td class="btn2_left"></td>
								<td><input type="text" value=""
									style="width: 80; text-align: center;" class="input1"
									maxlength="4" name="yd_cd" required fullfill
									caption="ctn_cd" style="ime-mode:disabled">&nbsp; <img
									class="cursor" src="img/btns_search.gif" name="btn_0082pop"
									width="19" height="20" alt="" border="0" align="absmiddle">&nbsp;
								</td>
							</tr>	
						</table>
						
						</td>

					</tr>
				</table>
				<!-- : ( Grid ) (S) -->
				<table width="92%" class="search"  id="mainTable"> 
                     <tr>
                         <td width="250">
                         <script language="javascript">ComSheetObject('sheet1');</script>
                         </td>
                     </tr>
                </table>
				<table class="line_bluedot">
					<tr>
						<td></td>
					</tr>
				</table>
				<table border="0" cellpadding="0" cellspacing="0" id="tb0_1">
					<tr>

						<td width="100">[UI_BKG-0154]</td>
						<td width="350">Client Default for Booking</td>
						<td >
						<table width="100%" border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td class="btn2_left"></td>
								<a href='#' onclick="javascript:window.open('ESM_BKG_0154.do')">ESM_BKG_0154.do</a>
						</table>
						</td>
					</tr>
				</table>
				<table class="line_bluedot">
					<tr>
						<td></td>
					</tr>
				</table>
				<table border="0" cellpadding="0" cellspacing="0" id="tb0_1" >
					<tr>

						<td width="100">[UI_BKG-0607]</td>
						<td width="350">Harmonized Tariff Code</td>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td class="btn2_left"></td>
								<td><input type="text" value=""
									style="width: 30; text-align: center;" class="input1"
									maxlength="1" name="hamo_tp_cd" required fullfill
									caption="hamo_tp_cd" style="ime-mode:disabled">&nbsp;
									<input type="text" value=""
									style="width: 80; text-align: center;" class="input1"
									maxlength="4" name="hamo_trf_cd" required fullfill
									caption="hamo_trf_cd" style="ime-mode:disabled">&nbsp; <img
									class="cursor" src="img/btns_search.gif" name="btn_0607pop"
									width="19" height="20" alt="" border="0" align="absmiddle">&nbsp;
								</td>
							</tr>	
						</table><!--
						
						<table width="120" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name=""><a href="javascript:esm_bkg_0607pop();">HT Code 조회 </a></td>
							<td class="btn2_right"></td>
							</tr>
						</table>
						
						--></td>
					</tr>
				</table>
				<table class="line_bluedot">
					<tr>
						<td></td>
					</tr>
				</table>
				<table border="0" cellpadding="0" cellspacing="0" id="tb0_1" >
					<tr>

						<td width="100">[UI_BKG-0019]</td>
						<td width="350">Vessel SKD & Code Inquiry</td>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td class="btn2_left"></td>
								<td><input type="text" value=""
									style="width: 80; text-align: center;" class="input1"
									maxlength="9" name="vvd" required fullfill
									caption="vvd" style="ime-mode:disabled">&nbsp; <img
									class="cursor" src="img/btns_search.gif" name="btn_0019pop"
									width="19" height="20" alt="" border="0" align="absmiddle">&nbsp;
									<input type="text" value=""
									style="width: 30; text-align: center;" class="input1"
									maxlength="5" name="pol_cd" required fullfill
									caption="pol_cd" style="ime-mode:disabled">
									<input type="text" value=""
									style="width: 30; text-align: center;" class="input1"
									maxlength="5" name="pod_cd" required fullfill
									caption="pod_cd" style="ime-mode:disabled">
								</td>
							</tr>	
						</table><!--
						
						<table width="120" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name=""><a href="javascript:esm_bkg_0607pop();">HT Code 조회 </a></td>
							<td class="btn2_right"></td>
							</tr>
						</table>
						
						--></td>
					</tr>
				</table>
				
				<table class="line_bluedot">
					<tr>
						<td></td>
					</tr>
				</table>
				<table border="0" cellpadding="0" cellspacing="0" id="tb0_1" >
					<tr>

						<td width="100">[UI_BKG-0088]</td>
						<td width="350">Return CY Inquiry</td>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td class="btn2_left"></td>
								<td><input type="text" value=""
									style="width: 80; text-align: center;" class="input1"
									maxlength="4" name="yd_cd2" required fullfill
									caption="yd_cd2" style="ime-mode:disabled">&nbsp; <img
									class="cursor" src="img/btns_search.gif" name="btn_0088pop"
									width="19" height="20" alt="" border="0" align="absmiddle">&nbsp;
								</td>
							</tr>	
						</table></td>
					</tr>
				</table>
				
				<table class="line_bluedot">
					<tr>
						<td></td>
					</tr>
				</table>
				<table border="0" cellpadding="0" cellspacing="0" id="tb0_1" >
					<tr>

						<td width="100">[UI_BKG-0696]</td>
						<td width="350">Package Code & Description Inquiry </td>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td class="btn2_left"></td>
								<td><input type="text" value=""
									style="width: 80; text-align: center;" class="input1"
									maxlength="50" name="pck_no" required fullfill
									caption="pck_no" style="ime-mode:disabled">&nbsp; <img
									class="cursor" src="img/btns_search.gif" name="btn_0696pop"
									width="19" height="20" alt="" border="0" align="absmiddle">&nbsp;
								</td>
							</tr>	
						</table></td>
					</tr>
				</table>
				<table class="line_bluedot">
					<tr>
						<td></td>
					</tr>
				</table>
				<table border="0" cellpadding="0" cellspacing="0" id="tb0_1">
					<tr>

						<td width="100">[UI_BKG-0554]</td>
						<td width="350">Warehouse (Bonded Area) Creation</td>
						<td >
						<table width="100%" border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td class="btn2_left"></td>
								<a href='#' onclick="javascript:window.open('ESM_BKG_0554.do')">ESM_BKG_0554.do</a>
						</table>
						</td>
					</tr>
				</table>
				<table class="line_bluedot">
					<tr>
						<td></td>
					</tr>
				</table>
				<table border="0" cellpadding="0" cellspacing="0" id="tb0_1" >
					<tr>

						<td width="100">[UI_BKG-0653]</td>
						<td width="350">Commodity Code Inquiry </td>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td class="btn2_left"></td>
								<td><input type="text" value=""
									style="width: 60; text-align: center;" class="input1"
									maxlength="50" name="cmdt_cd" required fullfill
									caption="cmdt_cd" style="ime-mode:disabled">
									
									<input type="text" value=""
									style="width: 35; text-align: center;" class="input1"
									maxlength="4" name="rep_cmdt_cd" required fullfill
									caption="rep_cmdt_cd" style="ime-mode:disabled">
									
									
									<img class="cursor" src="img/btns_search.gif" name="btn_0653pop"
									width="19" height="20" alt="" border="0" align="absmiddle">&nbsp;
									
									<input type="text" style="width: 122;" class="input2"
									name="cmdt_nm" readonly>
								</td>
							</tr>	
						</table></td>
					</tr>
				</table>
				
				<table class="line_bluedot">
					<tr>
						<td></td>
					</tr>
				</table>
				<table border="0" cellpadding="0" cellspacing="0" id="tb0_1">
					<tr>

						<td width="100">[UI_BKG-0596]</td>
						<td width="350">Manual BDR</td>
						<td >
						<table width="100%" border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td class="btn2_left"></td>
								<a href='#' onclick="javascript:window.open('ESM_BKG_0596.do')">ESM_BKG_0596.do</a>
							</tr>	
						</table>
						</td>
					</tr>
				</table>
				
				<table class="line_bluedot">
					<tr>
						<td></td>
					</tr>
				</table>
				<table border="0" cellpadding="0" cellspacing="0" id="tb0_1">
					<tr>

						<td width="100">[UI_BKG-0592]</td>
						<td width="350">User Group Creation</td>
						<td >
						<table width="100%" border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td class="btn2_left"></td>
								<a href='#' onclick="javascript:window.open('ESM_BKG_0592.do')">ESM_BKG_0592.do</a>
							</tr>	
						</table>
						</td>
					</tr>
				</table>
				
				<table class="line_bluedot">
					<tr>
						<td></td>
					</tr>
				</table>
				<table border="0" cellpadding="0" cellspacing="0" id="tb0_1">
					<tr>

						<td width="100">[UI_BKG-0073]</td>
						<td width="350">BDR Time Table</td>
						<td >
						<table width="100%" border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td class="btn2_left"></td>
								<a href='#' onclick="javascript:window.open('ESM_BKG_0073.do')">ESM_BKG_0073.do</a>
							</tr>	
						</table>
						</td>
					</tr>
				</table>
				
				<table class="line_bluedot">
					<tr>
						<td></td>
					</tr>
				</table>
				<table border="0" cellpadding="0" cellspacing="0" id="tb0_1">
					<tr>

						<td width="100">[UI_BKG-0253]</td>
						<td width="350">Equalization Port</td>
						<td >
						<table width="100%" border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td class="btn2_left"></td>
								<a href='#' onclick="javascript:window.open('ESM_BKG_0253.do')">ESM_BKG_0253.do</a>
							</tr>	
						</table>
						</td>
					</tr>
				</table>
				
				<table class="line_bluedot">
					<tr>
						<td></td>
					</tr>
				</table>
				<table border="0" cellpadding="0" cellspacing="0" id="tb0_1">
					<tr>

						<td width="100">[UI_BKG-0153]</td>
						<td width="350">Chinese Booking Agent </td>
						<td >
						<table width="100%" border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td class="btn2_left"></td>
								<a href='#' onclick="javascript:window.open('ESM_BKG_0153.do')">ESM_BKG_0153.do</a>
							</tr>	
						</table>
						</td>
					</tr>
				</table>
				
				<table class="line_bluedot">
					<tr>
						<td></td>
					</tr>
				</table>
				<table border="0" cellpadding="0" cellspacing="0" id="tb0_1">
					<tr>

						<td width="100">[UI_BKG-0417]</td>
						<td width="350">Port Closing Report (for Branch Office)</td>
						<td >
						<table width="100%" border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td class="btn2_left"></td>
								<a href='#' onclick="javascript:window.open('ESM_BKG_0417.do')">ESM_BKG_0417.do</a>
							</tr>	
						</table>
						</td>
					</tr>
				</table>
				
				<table class="line_bluedot">
					<tr>
						<td></td>
					</tr>
				</table>
				<table border="0" cellpadding="0" cellspacing="0" id="tb0_1">
					<tr>

						<td width="100">[UI_BKG-0162]</td>
						<td width="350">Container List on Stowage & B/L</td>
						<td >
						<table width="100%" border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td class="btn2_left"></td>
								<a href='#' onclick="javascript:window.open('ESM_BKG_0162.do')">ESM_BKG_0162.do</a>
							</tr>	
						</table>
						</td>
					</tr>
				</table>
				
				<table class="line_bluedot">
					<tr>
						<td></td>
					</tr>
				</table>
				<table border="0" cellpadding="0" cellspacing="0" id="tb0_1">
					<tr>

						<td width="100">[UI_BKG-0595]</td>
						<td width="350">Freight & Charge Summary Report</td>
						<td >
						<table width="100%" border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td class="btn2_left"></td>
								<a href='#' onclick="javascript:window.open('ESM_BKG_0595.do')">ESM_BKG_0595.do</a>
							</tr>	
						</table>
						</td>
					</tr>
				</table>
				
				<table class="line_bluedot">
					<tr>
						<td></td>
					</tr>
				</table>
				<table border="0" cellpadding="0" cellspacing="0" id="tb0_1">
					<tr>

						<td width="100">[UI_BKG-0618]</td>
						<td width="350">Loading Confirmation by Shipper (Fax / E-Mail)</td>
						<td >
						<table width="100%" border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td class="btn2_left"></td>
								<a href='#' onclick="javascript:window.open('ESM_BKG_0618.do')">ESM_BKG_0618.do</a>
							</tr>	
						</table>
						</td>
					</tr>
				</table>
				
				<table class="line_bluedot">
					<tr>
						<td></td>
					</tr>
				</table>
				<table border="0" cellpadding="0" cellspacing="0" id="tb0_1">
					<tr>

						<td width="100">[UI_BKG-0619]</td>
						<td width="350">Outbound Container Movement Status</td>
						<td >
						<table width="100%" border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td class="btn2_left"></td>
								<a href='#' onclick="javascript:window.open('ESM_BKG_0619.do')">ESM_BKG_0619.do</a>
							</tr>	
						</table>
						</td>
					</tr>
				</table>
				
				<table class="line_bluedot">
					<tr>
						<td></td>
					</tr>
				</table>
				<table border="0" cellpadding="0" cellspacing="0" id="tb0_1">
					<tr>

						<td width="100">[UI_BKG-0409]</td>
						<td width="350">Performance Report by Error</td>
						<td >
						<table width="100%" border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td class="btn2_left"></td>
								<a href='#' onclick="javascript:window.open('ESM_BKG_0409.do')">ESM_BKG_0409.do</a>
							</tr>	
						</table>
						</td>
					</tr>
				</table>
				
				<table class="line_bluedot">
					<tr>
						<td></td>
					</tr>
				</table>
				<table border="0" cellpadding="0" cellspacing="0" id="tb0_1">
					<tr>

						<td width="100">[UI_BKG-0620]</td>
						<td width="350">TRO Status List</td>
						<td >
						<table width="100%" border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td class="btn2_left"></td>
								<a href='#' onclick="javascript:window.open('ESM_BKG_0620.do')">ESM_BKG_0620.do</a>
							</tr>	
						</table>
						</td>
					</tr>
				</table>
				
				<table class="line_bluedot">
					<tr>
						<td></td>
					</tr>
				</table>
				<table border="0" cellpadding="0" cellspacing="0" id="tb0_1">
					<tr>

						<td width="100">[UI_BKG-0226]</td>
						<td width="350">e-BKG & S/I Upload Status Report</td>
						<td >
						<table width="100%" border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td class="btn2_left"></td>
								<a href='#' onclick="javascript:window.open('ESM_BKG_0226.do')">ESM_BKG_0226.do</a>
							</tr>	
						</table>
						</td>
					</tr>
				</table>
				
				<table class="line_bluedot">
					<tr>
						<td></td>
					</tr>
				</table>
				<table border="0" cellpadding="0" cellspacing="0" id="tb0_1">
					<tr>

						<td width="100">[UI_BKG-0227]</td>
						<td width="350">e-Booking & S/I Performance Report</td>
						<td >
						<table width="100%" border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td class="btn2_left"></td>
								<a href='#' onclick="javascript:window.open('ESM_BKG_0227.do')">ESM_BKG_0227.do</a>
							</tr>	
						</table>
						</td>
					</tr>
				</table>
				
				<table class="line_bluedot">
					<tr>
						<td></td>
					</tr>
				</table>
				<table border="0" cellpadding="0" cellspacing="0" id="tb0_1">
					<tr>

						<td width="100">[UI_BKG-0192]</td>
						<td width="350">Reoport Template</td>
						<td >
						<table width="100% border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td class="btn2_left"></td>
								<td class="btn2_left">
								<script LANGUAGE="javascript">
								function setConfirm(val){
									alert(val);
								}
								function setConfirm0192(val1,val2){
									alert("0192 \nval1::"+val1+"\nval2::"+val2);
								}
								
								</script>
									<a href="#" onclick="ComOpenPopup('/opuscntr/ESM_BKG_0192.do?cust_cnt_cd=KR&cust_seq=1&bco_type=', 970, 580, 'setConfirm0192', '0,0,1,1,1,1,1,1,1,1', false,false, 0, 0, 0,'fra_pop')">ESM_BKG_0192_comPop.do</a><br>
								</td>
							</tr>
						</table>
						</td>
					</tr>
				</table>
				<table class="line_bluedot">
					<tr>
						<td></td>
					</tr>
				</table>
				<table border="0" cellpadding="0" cellspacing="0" id="tb0_1">
					<tr>

						<td width="100">[UI_BKG-0922]</td>
						<td width="350">Reoport Template</td>
						<td >
						<table width="100% border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td class="btn2_left"></td>
								<td class="btn2_left">
								<script LANGUAGE="javascript">
								function setConfirm0922(val1){
									alert("0922 \nval1::"+val1);
								}
								
								</script>
									<a href="#" onclick="ComOpenPopup('/opuscntr/ESM_BKG_0922.do?ofc_cd=MEXBA', 500, 265, 'setConfirm0922', '0,0,1,1,1,1,1,1,1,1', false,false, 0, 0, 0,'fra_pop')">ESM_BKG_0922_comPop.do</a><br>
								</td>
							</tr>
						</table>
						</td>
					</tr>
				</table>
				
				<table class="line_bluedot">
					<tr>
						<td></td>
					</tr>
				</table>
				<table border="0" cellpadding="0" cellspacing="0" id="tb0_1">
					<tr>

						<td width="100">[UI_BKG-0588]</td>
						<td width="350">Special cargo summary information</td>
						<td >
						<table width="100%" border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td class="btn2_left"></td>
								<a href='#' onclick="javascript:window.open('ESM_BKG_0588.do')">ESM_BKG_0588.do</a>
							</tr>	
						</table>
						</td>
					</tr>
				</table>
				
				<table class="line_bluedot">
					<tr>
						<td></td>
					</tr>
				</table>
				<table border="0" cellpadding="0" cellspacing="0" id="tb0_1" >
					<tr>

						<td width="100">[UI_BKG-0727]</td>
						<td width="350">BDR Booking No Status - Inquiry => ESM_BKG_0071</td>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td class="btn2_left"></td>
								<td>
								
									vvd_cd,&nbsp;pol_cd,&nbsp;pod_cd&nbsp;&nbsp;&nbsp; &nbsp;    <BR>    
									
									<input type="text" value=""
									style="width: 80; text-align: center;" class="input1"
									maxlength="9" name="vvd_cd_0727" required fullfill
									caption="vvd_cd" style="ime-mode:disabled">
									
									<input type="text" value=""
									style="width: 50; text-align: center;" class="input1"
									maxlength="5" name="pol_cd_0727" required fullfill
									caption="pol_cd" style="ime-mode:disabled">
									
									<input type="text" value=""
									style="width: 50; text-align: center;" class="input1"
									maxlength="5" name="pod_cd_0727" required fullfill
									caption="pod_cd" style="ime-mode:disabled">
									
									<img class="cursor" src="img/btns_search.gif" name="btn_0727pop"
									width="19" height="20" alt="" border="0" align="absmiddle">&nbsp;
									
									
								</td>
							</tr>	
						</table></td>
					</tr>
				</table>
				
				<table class="line_bluedot">
					<tr>
						<td></td>
					</tr>
				</table>
				<table border="0" cellpadding="0" cellspacing="0" id="tb0_1">
					<tr>

						<td width="100">[UI_BKG-0914]</td>
						<td width="350">Port Closing Inquiry</td>
						<td >
						<table width="100%" border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td class="btn2_left"></td>
								<a href='#' onclick="javascript:window.open('ESM_BKG_0914.do')">ESM_BKG_0914.do</a>
							</tr>	
						</table>
						</td>
					</tr>
				</table>
				<table class="line_bluedot">
					<tr>
						<td></td>
					</tr>
				</table>
				<table border="0" cellpadding="0" cellspacing="0" id="tb0_1">
					<tr>

						<td width="100">[UI_BKG-0214]</td>
						<td width="350">Doc Performance Report</td>
						<td >
						<table width="100%" border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td class="btn2_left"></td>
								<a href='#' onclick="javascript:window.open('ESM_BKG_0214.do')">ESM_BKG_0214.do</a>
							</tr>	
						</table>
						</td>
					</tr>
				</table>
				
				<table class="line_bluedot">
					<tr>
						<td></td>
					</tr>
				</table>
				<table border="0" cellpadding="0" cellspacing="0" id="tb0_1" >
					<tr>

						<td width="100">[UI_BKG-0384]</td>
						<td width="350">Booking Notice Remark</td>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td class="btn2_left"></td>
								<td><input type="text" value=""
									style="width: 80; text-align: center;" class="input1"
									maxlength="4" name=tmplt_hdr_nm  fullfill
									caption="Title" style="ime-mode:disabled">&nbsp; 
									<input type="text" value=""
									style="width: 80; text-align: center;" class="input1"
									maxlength="4" name=tmplt_ctnt  fullfill
									caption="Remark(s)" style="ime-mode:disabled">&nbsp;
									<img
									class="cursor" src="img/btns_search.gif" name="btn_0384pop"
									width="19" height="20" alt="" border="0" align="absmiddle">&nbsp;
								</td>
							</tr>	
						</table></td>
					</tr>
				</table>
				
				<table class="line_bluedot">
					<tr>
						<td></td>
					</tr>
				</table>
				<table border="0" cellpadding="0" cellspacing="0" id="tb0_1">
					<tr>

						<td width="100">[UI_BKG-0488]</td>
						<td width="350">SR Receiving List</td>
						<td >
						<table width="100%" border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td class="btn2_left"></td>
								<a href='#' onclick="javascript:window.open('ESM_BKG_0488.do?pgmNo=ESM_BKG_0488')">ESM_BKG_0488.do</a>
							</tr>	
						</table>
						</td>
					</tr>
				</table>
				
				<table class="line_bluedot">
					<tr>
						<td></td>
					</tr>
				</table>
				<table border="0" cellpadding="0" cellspacing="0" id="tb0_1">
					<tr>

						<td width="100">[UI_BKG-1081]</td>
						<td width="350">Autorating Accuracy Monitoring Report</td>
						<td >
						<table width="100%" border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td class="btn2_left"></td>
								<a href='#' onclick="javascript:window.open('ESM_BKG_1081.do?pgmNo=ESM_BKG_1081')">ESM_BKG_1081.do</a>
							</tr>	
						</table>
						</td>
					</tr>
				</table>
				</td>
			</tr>
		</table>
		</div>
		<!--TAB Export (E) --> <!-- : ( Search Options ) (E) --></td>
	</tr>
</table>

<table class="height_5">
	<tr>
		<td></td>
	</tr>
</table>



<!-- 개발자 작업  끝 --></form>
</body>
</html>