
<%
	/*=========================================================
	 *Copyright(c) 2009 CyberLogitec
	 *@FileName : ESD_TRS_0300.jsp
	 *@FileTitle : Bidding Candidate Registration
	 *Open Issues :
	 *Change history :
	 *@LastModifyDate : 2013.08.21
	 *@LastModifier : 전윤주
	 *@LastVersion : 1.0
	 * 2013.08.21 전윤주
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
<%@ page import="com.hanjin.apps.alps.esd.trs.biddingmanage.biddingcandidateregistration.event.EsdTrs0300Event"%>
<%@ page import="org.apache.log4j.Logger"%>
<%@ page import="com.hanjin.framework.component.util.code.CodeInfo"%>
<%@ page import="java.util.List"%>

<%
	SignOnUserAccount account = null;
	EsdTrs0300Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지
	int rowCount = 0; //DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";

	String[] ctrtTpCd = null;
	
	String selTRANSMODE = ""; //Transportation Mode
	String optionStr = "000020:ALL:ALL";

	try {
		account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		
		selTRANSMODE  = JSPUtil.getCodeCombo("trsp_crr_mod_cd", "01", "style='width:48'", "CD00283", 0, optionStr);

		event = (EsdTrs0300Event) request.getAttribute("Event");
		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
	} catch (Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Bidding Candidate Registration</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">

	<%=JSPUtil.getIBCodeCombo("trsp_crr_mod_cd", "01", "CD00283", 0, " |")%>

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
		<input type="hidden" name=note_conv_grp_loc_cd value="">
		<input type="hidden" name="cd" value="">
		<input type="hidden" name="etc1" value="">
		<input type="hidden" name="spot_bid_cnddt_term_seq" value="">
		<input type="hidden" name="spot_bid_ofc_cd_tmp" value="">
		<input type="hidden" name="old_ofc_cd" value="<%=account.getOfc_cd()%>">
		<input type="hidden" name="FORM_CRE_USR_ID" value="<%=account.getUsr_id()%>">
		<input type="hidden" name="FORM_USR_OFC_CD" value="<%=account.getOfc_cd()%>">
		<input type="hidden" name="combo_svc_provider" value="">
		
		<!-- 개발자 작업	-->

		<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top: 2; padding-left: 5;">
			<tr>
				<td valign="top">
					<!--Page Title, Historical (S)-->
					<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
						<tr>
							<td class="history">
								<img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span>
							</td>
						</tr>
						<tr>
							<td class="title">
								<img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span>
							</td>
						</tr>
					</table>
					<!--Page Title, Historical (E)-->
					<!--biz page (S)-->
					<table width="100%" border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td width="48%">
								<!--Button (S) -->
								<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top: 5; , padding-bottom: 10;">
									<tr>
										<td class="btn1_bg">
											<table border="0" cellpadding="0" cellspacing="0">
												<tr>
													<td>
														<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
															<tr>
																<td class="btn1_left"></td>
																<td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
																<td class="btn1_right"></td>
														</table>
													</td>
													<td>
														<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
															<tr>
																<td class="btn1_left"></td>
																<td class="btn1" name="btn_reset">Reset</td>
																<td class="btn1_right"></td>
														</table>
													</td>
													<!-- <td class="btn1_line"></td>
										<td><table width="98%" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr>
													<td class="btn1_left"></td>
													<td class="btn1" name="btn_save">Save</td>
													<td class="btn1_right"></td>
											</table></td> -->
												</tr>
											</table>
										</td>
									</tr>
								</table>
								<!--Button (E) -->
								<table width="100%" class="search">
									<tr>
										<td class="bg">
											<!--  biz_1  (S) -->
											<table class="search" border="0" style="width: 100%">
												<tr class="h23">
													<td width="83">Trans Mode</td>
													<td width="80"><%=selTRANSMODE%></td>
													<td width="100">S/O Office</td>
													<td class="sm"><input name="spot_bid_ofc_cd" type="text" style="width: 79;" value="<%=account.getOfc_cd()%>" onChange="javascript:fun_officeText();"><img src="/hanjin/img/blank.gif" width="4" height="1" border="0"><img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btns_office">&nbsp;<input type="checkbox" name="chk_office" value="Y" class="trans" onClick="javascript:fun_chkOffice();">Incl. Sub OFC</td>
												</tr>
											</table>

											<table class="height_10">
												<tr>
													<td></td>
												</tr>
											</table>
											<!-- Grid 1 (S) -->
											<table width="100%" id="mainTable">
												<tr>
													<td width="100%">
														<script language="javascript">
															ComSheetObject('sheet1');
														</script>
													</td>
												</tr>
											</table>
											<!-- Grid 1 (E) -->
											<!--Button (S) -->
											<table width="100%" class="button">
												<tr>
													<td class="btn2_bg">
														<table border="0" cellpadding="0" cellspacing="0">
															<tr>
																<td>
																	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
																		<tr>
																			<td class="btn2_left"></td>
																			<td class="btn2" name="btn_add">Row&nbsp;Add</td>
																			<td class="btn2_right"></td>
																		</tr>
																	</table>
																</td>
																<td>
																	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
																		<tr>
																			<td class="btn2_left"></td>
																			<td class="btn2" name="btn_del">Row Delete</td>
																			<td class="btn2_right"></td>
																		</tr>
																	</table>
																</td>
																<td>
																	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
																		<tr>
																			<td class="btn2_left"></td>
																			<td class="btn2" name="btn_save">Save</td>
																			<td class="btn2_right"></td>
																		</tr>
																	</table>
																</td>
															</tr>
														</table>
													</td>
												</tr>
											</table>
											<!--Button (S) -->
										</td>
									</tr>
								</table>
							</td>
							<td class="" width="4%"></td>
							<td width="48%">
								<!--Button (S) -->
								<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top: 5; , padding-bottom: 10;">
									<tr>
										<td class="btn1_bg">
											<table border="0" cellpadding="0" cellspacing="0">
												<tr>
													<td>
														<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
															<tr>
																<td class="btn1_left"></td>
																<td class="btn1" name="btn_retrieve2" id="btn_retrieve2">Retrieve</td>
																<td class="btn1_right"></td>
														</table>
													</td>
													<td>
														<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
															<tr>
																<td class="btn1_left"></td>
																<td class="btn1" name="btn_reset2">Reset</td>
																<td class="btn1_right"></td>
														</table>
													</td>
													<!-- <td class="btn1_line"></td>
											<td><table width="98%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn1_left"></td>
														<td class="btn1" name="btn_save">Save</td>
														<td class="btn1_right"></td>
												</table></td> -->
												</tr>
											</table>
										</td>
									</tr>
								</table>
								<!--Button (E) -->
								<table width="100%" class="search">
									<tr>
										<td class="bg">
											<table class="search" border="0" style="width: 100%">
												<tr class="h23">
													<!-- <td width="140">Service Provider</td>
													<td>
														<input name="vndr_seq" type="text" style="width: 25%;" class="input1" onBlur="vndr_check(this);" onFocus='fun_Focus(this)' maxlength="9">
														<img src="/hanjin/img/blank.gif" width="2" height="1" border="0">
														<input name="vndr_nm" type="text" style="width: 67%;" class="input1" onBlur="vndr_nm_check(this);" onFocus='fun_Focus(this)' maxlength="100">
														<img src="/hanjin/img/blank.gif" width="2" height="1" border="0"><img class="cursor" img src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" onClick="vndr_OnPopupClick();">
													</td> -->
													<td width="110">Service Provider</td>
						                            <td><input type='text' name='vndr_seq' style="width:100;" onChange='getTextVendorSeq(sheetObjects[0], document.form, this.value)' onKeyup='enterCheck(this)'>
						                                <input type="text" name='svc_provider' readOnly style="width:60%;" class="input2"><img src="/hanjin/img/blank.gif" width="2" height="1" border="0"><img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name='btng_provider'></td>
												</tr>
											</table>

											<table class="height_10">
												<tr>
													<td></td>
												</tr>
											</table>
											<!-- Grid 2 (S) -->
											<table width="100%" id="mainTable">
												<tr>
													<td width="100%">
														<script language="javascript">
															ComSheetObject('sheet2');
														</script>
													</td>
												</tr>
											</table>
											<!-- Grid 2 (E) -->
											<!--Button (S) -->
											<table width="100%" class="button">
												<tr>
													<td class="btn2_bg">
														<table border="0" cellpadding="0" cellspacing="0">
															<tr>
																<td>
																	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
																		<tr>
																			<td class="btn2_left"></td>
																			<td class="btn2" name="btn_add2">Row&nbsp;Add</td>
																			<td class="btn2_right"></td>
																		</tr>
																	</table>
																</td>
																<td>
																	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
																		<tr>
																			<td class="btn2_left"></td>
																			<td class="btn2" name="btn_del2">Row Delete</td>
																			<td class="btn2_right"></td>
																		</tr>
																	</table>
																</td>
																<td>
																	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
																		<tr>
																			<td class="btn2_left"></td>
																			<td class="btn2" name="btn_save2">Save</td>
																			<td class="btn2_right"></td>
																		</tr>
																	</table>
																</td>
															</tr>
														</table>
													</td>
												</tr>
											</table>
											<!--Button (S) -->
											<!-- Grid (E) -->
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
					<!--  biz_2   (E) -->
				</td>
			</tr>
		</table>

		<!--biz page (E)-->


		<!--Button (S) -->
		<!-- <table width="100%" class="button" border="0" cellpadding="0"
			cellspacing="0" style="padding-top: 5; , padding-bottom: 10;">
			<tr>
				<td class="btn1_bg">
					<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td><table width="100%" border="0" cellpadding="0"
									cellspacing="0" class="button">
									<tr>
										<td class="btn1_left"></td>
										<td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
										<td class="btn1_right"></td>
								</table></td>
							<td><table width="100%" border="0" cellpadding="0"
									cellspacing="0" class="button">
									<tr>
										<td class="btn1_left"></td>
										<td class="btn1" name="btn_new">New</td>
										<td class="btn1_right"></td>
								</table></td>
							<td class="btn1_line"></td>
							<td><table width="98%" border="0" cellpadding="0"
									cellspacing="0" class="button">
									<tr>
										<td class="btn1_left"></td>
										<td class="btn1" name="btn_save">Save</td>
										<td class="btn1_right"></td>
								</table></td>
						</tr>
					</table>
				</td>
			</tr>
		</table> -->
		<!--Button (E) -->

		<!-- 개발자 작업  끝 -->
	</form>
</body>
</html>