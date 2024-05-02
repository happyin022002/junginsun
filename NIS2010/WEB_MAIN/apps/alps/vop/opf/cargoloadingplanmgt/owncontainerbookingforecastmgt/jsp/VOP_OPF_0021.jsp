<%
/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : VOP_OPF_0021.jsp
 *@FileTitle : Own Container Booking Forecast Management
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.07
 *@LastModifier : 우지석
 *@LastVersion : 1.0
 * 2009.07.07 우지석
 * 1.0 Creation
 -----------------------------------------------------------
 * History
 * 2011.11.24 [CHM-201114488-01] 이준범
 * 제목 : CBF내 Block Stowage 칼럼추가 요청 건
 * 내용 : 1. CBF화면 내 MLB->Block Stowage로 명 변경
 *       2. Block Stowage 데이터가 Booking Main내 Service 
 *          Mode & Route data 에서 I/F 되는지 확인
 *       3. 첨부 UI설계와 같이 Block Stowage 칼럼 추가
 =========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.event.VopOpf0021Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%@ page import="java.util.List"%>
<%@ page import="com.hanjin.syscommon.common.table.VskCarrierVO"%>

<%
	VopOpf0021Event event = null; 		//PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; 	//서버에서 발생한 에러
	String strErrMsg = ""; 				//에러메세지
	int rowCount = 0; 					//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList    = "";
	String pageRows    = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	Logger log = Logger.getLogger("com.hanjin.apps.CargoLoadingPlanMgt.OwnContainerBookingForecastMgt");

	//Combo String
	StringBuffer vslOprComboItem = new StringBuffer();

	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (VopOpf0021Event) request.getAttribute("Event");
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
<title>CBF – Volume/Weight/Special Cargo (Inquiry)</title>
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
<input type="hidden" name="head_opr_list" value=""> 
<input type="hidden" name="st_1"> 
<input type="hidden" name="st_2"> 
<input type="hidden" name="st_3">
<input type="hidden" name="st_4"> 
<input type="hidden" name="st_5"> 
<input type="hidden" name="st_6"> 
<input type="hidden" name="st_7"> 
<input type="hidden" name="st_8">
<input type="hidden" name="st_9"> 
<input type="hidden" name="st_10"> 
<input type="hidden" name="st_11"> 
<input type="hidden" name="st_12"> 
<input type="hidden" name="st_13">
<input type="hidden" name="st_14"> 
<input type="hidden" name="st_15">

<!-- 개발자 작업	-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">	
	<tr>
		<td valign="top">
			<!--Page Title, Historical (S)-->
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
				<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
				<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
			</table>
			<!--Page Title, Historical (E)-->
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top: 0; , padding-bottom: 2;">
				<tr>	
					<td class="btn1_bg">
						<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_Retrieve"  id="btn_Retrieve">Retrieve</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_New">New</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td class="btn1_line"></td>
								<td>
									<table width="180" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_WeightGroup">Weight Group(Inquiry)</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td class="btn1_line"></td>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_Print">Print</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			<!--Button (E) --> <!--biz page (S)-->
			<table class="search">
				<tr>
					<td class="bg">
					<!-- biz_1  (S) -->
						<table class="search" border="0" style="width: 979;">
							<tr class="h23">
								<td width="50">VVD CD</td>
								<td width="282"><input name="vsl_cd" required fullfill type="text" style="width: 40;" class="input1" value="" caption="VVD CD" maxlength="4" dataformat="engup"	style="ime-mode:disabled">&nbsp;<input name="skd_voy_no" required fullfill type="text" style="width: 40;" class="input1" value="" caption="VVD CD" maxlength="4" dataformat="engup" style="ime-mode:disabled">&nbsp;<input name="skd_dir_cd" required fullfill type="text" style="width: 20;" class="input1" value="" caption="VVD CD" maxlength="1" dataformat="engup" style="ime-mode:disabled">&nbsp;<img src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor" name="btn_vvd">&nbsp;<input name="vsl_eng_nm" type="text" style="width: 130;" class="input2" value="" readOnly><input type="text" style="width: 0;" name="noname" readOnly></td>
								<td width="26">POL</td>
								<td width="340"><script language="javascript">ComComboObject('yd_cd', 1, 80, 1, 1);</script>&nbsp;<input type="text" style="width: 80;" class="input2" name="loc_nm" readOnly>&nbsp;<input type="text" style="width: 150;"	class="input2" name="yd_nm" readOnly></td>
								<td width="23">ETA</td>
								<td width="130"><input type="text" style="width: 110;" class="input2" name="eta" readOnly></td>
								<td width="23">CBF</td>
								<td width=""><input type="text" style="width: 100;"	class="input2" name="cbf_ind_flg" readOnly></td>
							</tr>
						</table>
						<table class="search" border="0" style="width: 979;">
							<tr class="h23">
								<td width="50">Lane</td>
								<td width="282"><input name="slan_cd" type="text" style="width: 40;" class="input2" value="" readOnly>&nbsp;<input name="slan_nm" type="text" style="width: 221;" class="input2" value="" readOnly></td>
								<td width="108">Booking Status</td>
								<td width="87"><input type="text" style="width: 70;" class="input2" name="cbf_bkg_sts_cd" readOnly></td>
								<td width="80">Last Created</td>
								<td width="190"><input type="text" style="width: 67;text-align:center;" class="input2" name="upd_usr_id" readOnly>&nbsp;<input type="text" style="width: 117;text-align:center;" class="input2" name="upd_dt" readOnly></td>
		
								<td width="">
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
																	<td class="btn2" name="btn_BookingClosingStatus">Booking Closing Status</td>
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
	
						<table class="line_bluedot">
							<tr>
								<td></td>
							</tr>
						</table>
						<table class="search" border="0" style="width: 979;">
							<tr class="h23">
								<td width="30">OPR</td>
								<td width="80"><script language="javascript">ComComboObject('crr_cd', 1, 70, 1, 0, 0, false);</script></td>
								<td width="30">POD</td>
								<td width="80"><script language="javascript">ComComboObject('pod_cd', 1, 70, 1);</script></td>
								<td width="30">MLB</td>
								<td width="400"><script language="javascript">ComComboObject('mlb_cd', 1, 70, 1);</script></td>
								<td width="">
									<table class="search" border="0" style="width: 350; background-color: #E9E9E9; padding: 2 2 2 2">
										<tr class="h23">
											<td width="" class="">
												<input type="checkbox" value="Y" class="trans" name="all_flg" checked>&nbsp;ALL&nbsp;&nbsp;&nbsp;
												<input type="checkbox" value="Y" class="trans" name="dcgo_flg">&nbsp;DG&nbsp;&nbsp;&nbsp;
												<input type="checkbox" value="Y" class="trans" name="rc_flg">&nbsp;RF&nbsp;&nbsp;&nbsp;
												<input type="checkbox" value="Y" class="trans" name="awk_cgo_flg">&nbsp;AK&nbsp;&nbsp;&nbsp;
												<input type="checkbox" value="Y" class="trans" name="bb_cgo_flg">&nbsp;BB&nbsp;&nbsp;&nbsp;
												<input type="checkbox" value="Y" class="trans" name="stwg_cgo_flg">&nbsp;STWG&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											</td>
										</tr>
									</table>																	
								</td>								
							</tr>
						</table>
						<!-- biz_1  (E) -->
					</td>
				</tr>
			</table>

			<table class="height_8">
				<tr>
					<td></td>
				</tr>
			</table>

			<!-- Tab (S) -->
			<table class="tab" border="0" cellpadding="0" cellspacing="0" width=100%>
				<tr>
					<td width="100%">
						<script language="javascript">ComTabObject('tab1')</script>
					</td>
				</tr>
			</table>
			<!-- Tab (E) --> 
			<!--  Tab_2 (S) -->
			<div id="tabLayer" style="display: none">
			<table class="search">
				<tr>
					<td class="bg">
						<table class="search" border="0">
							<tr>
								<td class="title_h"></td>
								<td class="title_s">Volume/Weight</td>
								<td align="right"><input type="checkbox" value="Y" class="trans" name="t1sheet1_sum_flg" ><b>Incl. sub summary</b></td>
							</tr>
						</table>
						<table width="100%" id="mainTable">
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('t1sheet1');</script>
								</td>
							</tr>
						</table>
						<table class="height_2">
							<tr>
								<td></td>
							</tr>
						</table>
	
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
														<td class="btn2" name="btn_DownExcel1">Down Excel</td>
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
	
						<table class="height_2">
							<tr>
								<td></td>
							</tr>
						</table>
						<!-- Button_Sub (E) -->
					</td>
				</tr>
			</table>
			</div>
		
			<!--  Tab_2 (E) --> <!--  Tab_3 (S) -->
			<div id="tabLayer" style="display: none">
			<table class="search">
				<tr>
					<td class="bg">
						<table class="search" border="0">
							<tr>
								<td class="title_h"></td>
								<td class="title_s">Special Cargo</td>
								<td align="right"><input type="checkbox" value="Y" class="trans" name="t2sheet1_sum_flg" ><b>Incl. sub summary</b></td>
							</tr>
						</table>
						<table width="100%" id="mainTable2">
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('t2sheet1');</script>
								</td>
							</tr>
						</table>	
	
						<table class="height_2">
							<tr>
								<td></td>
							</tr>
						</table>
	
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
													<td class="btn2" name="btn_DownExcel2">Down Excel</td>
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
						<table class="line_bluedot">
							<tr>
								<td></td>
							</tr>
						</table>
						<table class="search" border="0">
							<tr>
								<td class="title_h"></td>
								<td class="title_s">Stowage Request</td>
								<td align="right"><input type="checkbox" value="Y" class="trans" name="t2sheet2_sum_flg" ><b>Incl. sub summary</b></td>
							</tr>
						</table>
	
						<table class="search">
							<tr>
								<td>
									<table width="100%" id="subTable">
										<tr>
											<td width="100%"><script language="javascript">ComSheetObject('t2sheet2');</script>
											</td>
										</tr>
									</table>
									<table class="height_2">
										<tr>
											<td></td>
										</tr>
									</table>				
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
																	<td class="btn2" name="btn_DownExcel3">Down Excel</td>
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
						
					<table class="search" border="0" style="width: 979;">
					<tr class="stm">
						<td width="300">AB - Away from boiler</td>
						<td width="300">AF - Away from foodstuffs</td>
						<td width="">AL - Away from living quarters</td>
					</tr>
					<tr class="stm">
						<td width="300">BC - Block stowage</td>
						<td width="300">OD - On Deck stowage</td>
						<td width="">ODAB - On deck away from boiler</td>
					</tr>
					<tr class="stm">						
						<td width="300">OBSS - One bay STWG(ONLY SAMSUNG)</td>
						<td width="300">OBSG - One bay STWG(ONLY Glovis)</td>						
						<td width="">ODAL - On deck away from living quarters</td>
					</tr>
					<tr class="stm">
						<td width="300">ODBC - On deck block stowage</td>
						<td width="300">ODET - On Deck Except Top Stowage</td>
						<td width="">ODFT - On Deck For Flectank</td>
					</tr>
					<tr class="stm">
						<td width="300">ODHD - On deck for Hide</td>
						<td width="300">OP - On deck protected</td>
						<td width="">OT - On deck top</td>
					</tr>
					<tr class="stm">
						<td width="300">OTNO - On deck Top not overstow</td>
						<td width="300">PC - Pre caution</td>
						<td width="">PCOD - Pre caution on deck</td>
					</tr>
					<tr class="stm">
						<td width="300">TS - Top stowage</td>
						<td width="300">TSBC - Top stowage block stowage</td>
						<td width="">UD - Under Deck</td>
					</tr>	
					<tr class="stm">
						<td width="300">UT - Under deck top</td>
						<td width="300">UDAB - Under Deck away from heating source</td>
						<td width="">UW - Under waterline</td>
						
					</tr>	
					<tr class="stm">
						<td width="300">UTAB - Under deck top away from boiler</td>
						<td width="350">MUPG - Marble UP(Under deck protected) by general cargoes</td>
						<td width=""></td>
					</tr>																	

					</table>
				
						<table class="line_bluedot">
							<tr>
								<td></td>
							</tr>
						</table>
						<table class="search" border="0">
							<tr>
								<td class="title_h"></td>
								<td class="title_s">Detail</td>
							</tr>
						</table>
	
						<table class="search">
							<tr>
								<td>
									<table width="100%" id="mainTable3">
										<tr>
											<td width="100%">
												<script language="javascript">ComSheetObject('t2sheet3');</script>
											</td>
										</tr>
									</table>				
									<table class="height_2">
										<tr>
											<td></td>
										</tr>
									</table>				
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
																	<td class="btn2" name="btn_DownExcel4">Down Excel</td>
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
			</div>
			<!--  Tab_3 (E) --> <!-- Tab BG Box(E) --> <!--biz page (E)-->
			<table class="height_10">
				<tr>
					<td></td>
				</tr>
			</table>
		</td>
	</tr>
</table>

<!-- 개발자 작업  끝 --></form>
</body>
</html>