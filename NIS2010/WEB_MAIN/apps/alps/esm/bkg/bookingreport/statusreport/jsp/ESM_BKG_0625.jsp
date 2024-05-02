
<%
	/*=========================================================
	 *Copyright(c) 2009 CyberLogitec
	 *@FileName : ESM_BKG_0625.jsp
	 *@FileTitle : VIP Customer Report
	 *Open Issues :
	 *Change history :
	 *@LastModifyDate : 2009.05.13
	 *@LastModifier : 김경섭
	 *@LastVersion : 1.0
	 * 2009.05.13 김경섭
	 * 1.0 Creation
	 *----------------------------------------------------------
	 * History
	 * 2010.09.10 김영철 [ ] VIP REPORT 부분 오류 수정 ( 반영일 : 2010.09.24 )
	 * 2011.06.20 변종건 [CHM-201111601-01] VIP Report -조회조건추가 (RFA#컬럼 )
	 * 2012.01.09 변종건 [CHM-201215496-01] VIP Report 항목 추가(Actual Code, Actual Name 항목 추가 & 검색조건에 Actual Code 추가)
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
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.event.EsmBkg0625Event"%>	
<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmBkg0625Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지
	int rowCount = 0; //DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList = "";
	String pageRows = "50";

	String strUsr_id = "";
	String strUsr_nm = "";
	String rpt_nm = JSPUtil.getNull(request.getParameter("rpt_nm")); ;
	
	boolean bBtn_Disabled = true;
	Logger log = Logger.getLogger("com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport");

	try {
		SignOnUserAccount account = (SignOnUserAccount) session
				.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg0625Event) request.getAttribute("Event");
		serverException = (Exception) request
				.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException)
					.loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request
				.getAttribute("EventResponse");

	} catch (Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Welcome to alps!</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
	var paramReportName="<%=rpt_nm%>";
</script>
</head>

<body onLoad="setupPage();">
<div id="debug"></div>
<!-- 개발자 작업	-->

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top: 2; padding-left: 5;">
	<tr>
		<td valign="top">

	<!--Page Title, Historical (S)-->
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
		<!--Page Title, Historical (E)--> <!-- : ( Search Options ) (S) -->


			<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">

							<table class="search" border="0" style="width:979;"> 
									<tr><td>
									<!--  biz_1  (S) -->
											<table class="search" border="0" style="width:979;">
											<form method="post" name="tempform" onSubmit="return false;"> 
											<tr class="h23">
												<td width="90">&nbsp;&nbsp;Report Type</td>
												<td width="250"><script language="javascript">ComComboObject('report_type', 1, 240, '');</script></td>
												<td width=""><table width="140" border="0" cellpadding="0" cellspacing="0"></table> 
												<table width="140" border="0" cellpadding="0" cellspacing="0" class="button">
															<tr><td class="btn2_left"></td>
															<td class="btn2" name="btn_ReportTemplate">Report&nbsp;Template</td>
															<td class="btn2_right"></td> 
															</tr>
															</table>
												</td>
												</tr>
												</form>
											</table>
									<!--  biz_1   (E) -->
											
									</td></tr>
								</table>
								
								<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>				
					
					<!-- ********************************************* Form Start  ********************************************* -->	
										<form method="post" name="form" onSubmit="return false;" style="margin-top:-1">
										<input type="hidden" name="f_cmd">
										<input type="hidden" name="select_list">
										<input type="hidden" name="p_bkg_rpt_knd_cd" value="V">		
										<input type="hidden" name="p_grid_type" value="G">		
										<input type="hidden" name="curr_page"      value="1">				
										<input type="hidden" name="rows_per_page"      value="50">
										<input type="hidden" name="vis_flg"      value="Y">
							
											<table class="search" border="0" style="width:979;"> 
												<tr class="h23">
													<td width="110">
														<table class="search_sm2" border="0" style="width:100;"> 
															<tr class="h23">
																<td width=""><input type="radio" name="in_out_cd" name="in_out_cd" value="IN" class="trans" checked>&nbsp;Inbound </td>
															</tr>
															<tr class="h23">
																<td width=""><input type="radio" name="in_out_cd" name="in_out_cd" value="OUT" class="trans">&nbsp;Outbound</td>
															</tr>
														</table>
													</td>
													<td>
														<table class="search" border="0" style="width:869;"> 
												    		<tr class="h23">
																<td width="29" id="eta_id">ETA</td>
																<td width="250"><input type="text" style="width:70;" class="input1" maxlength='10' dataformat="ymd" name="vps_eta_dt" value="">&nbsp;-&nbsp;<input type="text" style="width:70;" class="input1" maxlength='10' dataformat="ymd" name="vps_etd_dt" value="">&nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btn_eta_date"></td>
																<td width="30">VVD</td>
																<td width="100"><input type="text" style="width:75;" class="input1" name="vvd_cd" value=""  maxlength='9'  required fullfill  dataformat='engupnum' style="ime-mode:disabled"></td>
																<td width="30">POL</td>
																<td width="100"><input type="text" style="width:45" class="input"  name="pol_cd" value="" maxlength='5' dataformat='engupnum' style="ime-mode:disabled">&nbsp;<input type="text" style="width:25" value="" class="input" name="pol_yard_cd" maxlength='2' dataformat='engupnum' style="ime-mode:disabled"></td>
																<td width="30">POD</td>
																<td width="100"><input type="text" style="width:50" value="" name="pod_cd" maxlength='5' dataformat='engupnum' style="ime-mode:disabled" class="input">&nbsp;<input type="text" style="width:25" value="" class="input" name="pod_yard_cd" maxlength='2' dataformat='engupnum' style="ime-mode:disabled"></td>
																<td width="30">POR</td>
																<td width="60"><input type="text" style="width:45;" class="input" name="por_cd" maxlength='5' dataformat='engupnum' style="ime-mode:disabled"  value=""></td>
																<td width="30">DEL</td>
																<td width="60"><input type="text" style="width:45;" class="input" name="del_cd" maxlength='5' dataformat='engupnum' style="ime-mode:disabled"  value=""></td>
																<td width="80">EQ Office</td>
																<td width="60"><input type="text" style="width:45;" class="input" name="eq_ofc_cd" maxlength='6' dataformat='engup' style="ime-mode:disabled"  value=""></td>
																<td width=""></td>
															</tr>
														</table>

														<table class="search" border="0" style="width:869;"> 
															<tr class="h23">
																<td width="30">S/C</td>
																<td width="100"><input type="text" style="width:90;" class="input1" name="sc_no" value=""  maxlength='20'  dataformat='engupnum' style="ime-mode:disabled"></td>
																<td width="30">RFA</td>
																<td width="95"><input type="text" style="width:85;" class="input1" name="rfa_no" value=""  maxlength=11 dataformat="engupnum" style="ime-mode:disabled"></td>
																<td width="30">TAA</td>
																<td width="95"><input type="text" style="width:85;" class="input1" name="taa_no" value=""  maxlength=10 dataformat="engupnum" style="ime-mode:disabled"></td>
																<td width="100">Group Customer</td>
																<td width="100"><input type="text" style="width:90;" class="input1" name="gcust" value=""  maxlength='10' dataformat='gcust' style="ime-mode:disabled">&nbsp;</td>
																<td width="65">A/Customer</td>
																<td width=""><input type="text" name="agmt_act_cnt_cd" style="width:23;" class="input" value=""  maxlength=2 dataformat="engup">&nbsp;<input type="text" name="agmt_act_cust_seq" style="width:50;" class="input" value="" maxlength=6 dataformat="num"></td>
															</tr>

														</table>
													</td>
												</tr>
											</table>
											
											<table class="search" border="0" style="width:979;"> 
												<tr class="h23">
													<td width="110">&nbsp;</td>
													<td width="63">Customer</td>
													<td width="300"><script language="javascript">ComComboObject('cust_tp_cd', 2, 50, true, '');</script>
													&nbsp;<input type="text" style="width:25;" class="input1" name="cust_cnt_cd" value=""  maxlength='2'  dataformat='engup' style="ime-mode:disabled">&nbsp;<input type="text" style="width:50;" class="input1" maxlength='6' dataformat='num' name="cust_seq" style="ime-mode:disabled"  value="">&nbsp;<input type="text" style="width:118;" class="input" maxlength='50' dataformat='gcust' name="cust_nm" value="" >
													<img src="./img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor" name="btn_customer_pop">
													</td>
													<td width="40">EDI ID</td>
													<td width=""><input type="text" style="width:68;" class="input1"  name="edi_id" value=""  maxlength='9' dataformat='engupnum' style="ime-mode:disabled">&nbsp;<input type="text" style="width:87;" class="input2" maxlength='50' dataformat='engup' name="edi_gr_cd" value="" readonly>&nbsp;<input type="text" style="width:96;" class="input2"  maxlength='50' dataformat='engup' name="edi_gr_nm" value="" readonly>&nbsp;<img class="cursor" src="./img/btns_search.gif" name="btn_Edi_Id" width="19" height="20" border="0" align="absmiddle"></td>
												</tr>
											</table>
											
											<table class="search" border="0" style="width:979;"> 
											<tr class="h23">
												<td width="110"></td>
												
												<td width="85">Special Cargo</td>
												<td width="200">
												   <input type="checkbox" class="trans" name="sp_cargo_rf" value="RF">RF
													<input type="checkbox" class="trans" name="sp_cargo_dg" value="DG">DG
													<input type="checkbox" class="trans" name="sp_cargo_ak" value="AK">AK
													<input type="checkbox" class="trans" name="sp_cargo_bb" value="BB">BB
												</td>
												<td width="120">Assign Credit Term</td>
												<td width="50"><input type="text" style="width:20;" class="input"  name="credit" value=""  maxlength='2' dataformat='num' style="ime-mode:disabled"></td>
												<td width="90">WMS Multi PO</td>
												<td width="50"><input type="checkbox" class="trans" name="wms_multi_po" value="Y"></td>
												<td width="40">SCAC</td>
												<td width="50"><input type="checkbox" class="trans" name="scac_flg" value="Y"></td>
												<td>&nbsp;</td>
											</tr>
											</table>	
																										
											<!-- table class="search_sm2" border="0"> 
												<tr class="h23">
													<td width=""><input type="radio" name="init_pol_pod_cd" id="init_pol_pod_cd" value="A" class="trans" checked>&nbsp;Init POL ETA </td>
													<td width=""><input type="radio" name="init_pol_pod_cd" id="init_pol_pod_cd" value="B" class="trans">&nbsp;Init POL ETD </td>
													<td width=""><input type="radio" name="init_pol_pod_cd" id="init_pol_pod_cd" value="C" class="trans">&nbsp;Init POD ETA </td>
													<td width="250"><input type="text" style="width:70;" class="input1" maxlength='10' dataformat="ymd" name="init_dt_fm" value="">&nbsp;-&nbsp;<input type="text" style="width:70;" class="input1" maxlength='10' dataformat="ymd" name="init_dt_to" value="">&nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btn_init_date"></td>
																
												</tr>
											</table-->															
										<!-- Cargo Type (E) -->
									</td></tr></form>
									<!-- ********************************************* Form End  ********************************************* -->	
								</table>


				<!--  biz_1   (E) -->
				

			<table class="height_8"><tr><td></td></tr></table>
			
			
			
			<!-- Grid BG Box  (S) -->
     	<table class="search" id="mainTable">
       	<tr>
      	 	<td class="bg" height='370'>
							<!-- Grid  (S) -->
							<table width="100%"  id="mainTable"> 
								<tr>
									<td width="100%" id="id_sheet1">
										<script language="javascript">ComSheetObject('sheet1');</script>
									</td>
								</tr>
							</table> 			
						<!-- Grid (E) -->
				
					</td>
				</tr>
			</table>
		<!--biz page (E)-->
		
	<!--Button (S) -->
				<table width="100%" class="button" border="0" cellpadding="0"
					cellspacing="0" style="padding-top: 5; , padding-bottom: 10;">
					<tr>
						<td class="btn1_bg">
						
							<table border="0" cellpadding="0" cellspacing="0">
								<tr>
									<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0"
										class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
									</td>
							<td>
							<table width="72" border="0" cellpadding="0" cellspacing="0"
								class="button">
								<tr>
									<td class="btn1_left"></td>
									<td class="btn1" name="btn_New">New</td>
									<td class="btn1_right"></td>
								</tr>
							</table>
							</td>
							<td class="btn1_line"></td>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0"
										class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_DownExcel">Down Excel</td>
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

		
		</td>
	</tr>
</table>
<!-- 개발자 작업  끝 -->
</body>
</html>
