<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_scg_0023.jsp
*@FileTitle : SPCL CGO Approved Details
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.26
*@LastModifier : 김현욱
*@LastVersion : 1.0
* 2009.06.26 김현욱
* 1.0 Creation
* 2009.11.04 김현욱
* 2.0 MPA1 Tab 삭제하고 DG에 기능 포함시킴
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.event.VopScg0023Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopScg0023Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.CargoLoadingApproval.OwnDangerousCargoApproval");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (VopScg0023Event)request.getAttribute("Event");
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
<title>SPCL CGO Approved Details</title>
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

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<input type="hidden" name="scg_flg">
<input type="hidden" name="user_id" value="<%=strUsr_id%>">

<!-- 개발자 작업	-->

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr>
		<td valign="top">
			<!--top menu (S)-->
			<!--Page Title, Historical (S)-->
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
				<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
				<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
			</table>
			<!--Page Title, Historical (E)-->	
			<!--biz page (S)-->
			<!-- 1 (S) -->
			<table class="search" id="mainTable"> 
       			<tr>
       				<td class="bg">
						<!--  biz_1  (S) -->
						<table class="search" border="0" style="width:979;"> 
							<tr class="h23">
								<td width="35">RSO</td>
								<td width="110">
									<script language="javascript">ComComboObject('rgn_shp_opr_cd', 2, 77, 0, 1);</script>
								</td>
								<td width="375">								
									<table class="search_sm2" style="width:330;">
										<tr class="h23">
											<td width="70">&nbsp;APVL Type</td>
											<td class="stm">
												<input type="radio" name="auth_flg" value="Y" class="trans" checked>&nbsp;Accepted&nbsp;&nbsp;
												<input type="radio" name="auth_flg" value="N" class="trans">&nbsp;Rejected&nbsp;&nbsp;&nbsp;
												<input type="radio" name="auth_flg" value="YN" class="trans">&nbsp;All
											</td>
										</tr>
									</table>									
								</td>
								<td width="30">Lane</td>
								<td width="100"><input type="text" name="slan_cd1" style="width:53" class="input" value="" fullfill caption="Lane" maxlength="3" dataformat="engup" style="ime-mode:disabled">&nbsp;<img src="img/btns_search.gif" name="btn_SlanCd" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
								<td width="55">VVD CD</td>
								<td><input type="text" name="vsl_cd" style="width:40" class="input1" value="" fullfill caption="VVD CD" maxlength="4" dataformat="engup" style="ime-mode:disabled">&nbsp;<input type="text" name="skd_voy_no" style="width:40" class="input1" value="" fullfill caption="VVD CD" maxlength="4" dataformat="engup" style="ime-mode:disabled">&nbsp;<input type="text" name="skd_dir_cd" style="width:25" class="input1" value="" fullfill caption="VVD CD" maxlength="1" dataformat="engup" style="ime-mode:disabled">&nbsp;<img src="img/btns_search.gif" name="btn_VVDpop" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">&nbsp;<input type="text" name="vsl_eng_nm" style="width:120" class="input2" value="" readOnly></td>
							</tr>
						</table>
						<table class="search" border="0" style="width:979;"> 
							<tr class="h23">
								<td width="33">POL</td>
								<td width="130"><input type="text" name="pol_cd" style="width:53" class="input" value="" caption="POL" maxlength="5" dataformat="engup" style="ime-mode:disabled">&nbsp;<img src="img/btns_search.gif" name="btn_Pol" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
								<td width="25">POD</td>
								<td width="110"><input type="text" name="pod_cd" style="width:50" class="input" value="" caption="POD" maxlength="5" dataformat="engup" style="ime-mode:disabled">&nbsp;<img src="img/btns_search.gif" name="btn_Pod" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
								<td width="87">BKG Company</td>
								<td width=135><input type="text" name="cgo_opr_cd" style="width:40" class="input" value="" caption="BKG Company" maxlength="4" dataformat="engup" style="ime-mode:disabled">&nbsp;<img src="img/btns_search.gif" name="btn_Carrier" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
								<td width="75">BKG Ref No.</td>
								<td width="170"><input type="text" name="booking_no" style="width:120" class="input" value="" caption="BKG Ref No." maxlength="30" dataformat="engup" style="ime-mode:disabled"></td>
								<td width="79">Approval No.</td>
								<td width=""><input type="text" name="apro_ref_no" style="width:120" class="input" value="" caption="Approval No." maxlength="30" dataformat="engup" style="ime-mode:disabled"></td>
							</tr> 
						</table>				
						<table class="search" border="0" style="width:979;"> 
							<tr class="h23">
								<td width="80">UN No./Seq.</td>
								<td width="160"><input type="text" name="imdg_un_no" fullfill style="width:55" class="input" value="" caption="UN No." maxlength="4" dataformat="engup" style="ime-mode:disabled">&nbsp;<input type="text" name="imdg_un_no_seq" style="width:30" class="input" value="" caption="Seq." maxlength="4" dataformat="engup" style="ime-mode:disabled"> <img src="img/btns_search.gif" name="btn_UNNo" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
								<td width="34">Class</td>
								<td width="110">
									<script language="javascript">ComComboObject('imdg_clss_cd', 1, 52, 0, 0);</script>
								</td>
								<td width="45">SHPR</td>
								<td width="275"><input type="text" name="prp_shp_nm" style="width:220" class="input" value="" dataformat="engup" style="ime-mode:disabled"></td>									
								<td width="55">POL ETA</td>
								<td width=""><input type="text" name="from_eta_dt" style="width:81" class="input1" value="" dataformat="ymd" maxlength="8" caption="POL ETA">&nbsp;~&nbsp;<input type="text" name="to_eta_dt" style="width:85" class="input1" value="" dataformat="ymd" maxlength="8" caption="POL ETA">&nbsp;<img src="img/btns_calendar.gif" name="btn_Calendar" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
							</tr> 
						</table>			
						<!--  biz_1   (E) -->
					</td>
				</tr>
			</table>	
			<!-- 1 (E) -->
		
			<!-- 2 (S) -->		
			<table class="height_8"><tr><td></td></tr></table>	

			<!-- Tab (S) -->
			<table class="tab" border="0" cellpadding="0" cellspacing="0" width=100%> 
				<tr><td width="100%">
					<script language="javascript">ComTabObject('tab1')</script>
				</td></tr>
			</table>
			<!-- Tab (E) -->	

			<table class="search" id="mainTable"> 
      			<tr>
      				<td class="bg" style="height:385;" valign="top">	

						<!-- Tab DG (S) -->
						<div id="tabLayer" style="display:inline">
						
							<!--  biz_2  (S) -->
							<table class="search" border="0" style="width:100%;">
								<tr class="h23">
									<td width="100%" align="right"><input type="checkbox" name="t1Mpa1" value="" class="trans">&nbsp;&nbsp;MPA 1</td>
								</tr>
							</table>

							<!-- Grid - 1 (S) -->
							<table width="100%" class="search"  id="mainTable"> 
								<tr>
									<td width="100%">
										<script language="javascript">ComSheetObject('t1sheet1');</script>
									</td>
								</tr>
							</table> 			
							<!-- Grid - 1 (E) -->	
		
							<!--  Button_Sub (S) -->
							<table class="search" border="0" style="width:100%;"> 
								<tr class="h23">
									<td width="138">
										<!--  But(S) -->
										<table width="100%" class="button"> 
					       					<tr>
					       						<td class="btn2_bg">
													<table border="0" cellpadding="0" cellspacing="0">
														<tr>
															<td>
																<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
																	<tr>
																		<td class="btn2_left"></td>
																		<td class="btn2" name="btn_t1appl0">Application Details</td>
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
					    			<td>
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
																		<td class="btn2" name="btn_t1downExcel0">Down Excel</td>
																		<td class="btn2_right"></td>
																	</tr>
																</table>
															</td>										
														</tr>
													</table>
												</td>
											</tr>
										</table>
					    				<!-- But (E) -->
					    			</td>
								</tr>
							</table>
							<!-- Button_Sub (E) -->
							<table><tr><td style="height:5"></td></tr></table>	
						</div>
						<!-- Tab DG (E) -->

						<!-- Tab Awkard (S) -->
						<div id="tabLayer" style="display:inline">

							<!-- Grid - 1 (S) -->
							<table width="100%" class="search"  id="mainTable"> 
								<tr>
									<td width="100%">
										<script language="javascript">ComSheetObject('t2sheet1');</script>
									</td>
								</tr>
							</table> 			
							<!-- Grid - 1 (E) -->				
				
							<!--  Button_Sub (S) -->
							<table class="search" border="0" style="width:100%;"> 
								<tr class="h23">
									<td width="138">
										<!--  But(S) -->
										<table width="100%" class="button"> 
							       			<tr>
							       				<td class="btn2_bg">
													<table border="0" cellpadding="0" cellspacing="0">
														<tr>
															<td>
																<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
																	<tr>
																		<td class="btn2_left"></td>
																		<td class="btn2" name="btn_t1appl1">Application Details</td>
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
					    			<td>
										<!--  Button_Sub (S) -->
										<table width="100%" class="button"> 
							       			<tr>
							       				<td class="btn2_bg">
													<table border="0" cellpadding="0" cellspacing="0">
														<tr>
															<td>
																<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
																	<tr>
																		<td class="btn2_left"></td>
																		<td class="btn2" name="btn_t1mail1">Mail </td>
																		<td class="btn2_right"></td>
																	</tr>
																</table>
															</td>
															<td>
																<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
																	<tr>
																		<td class="btn2_left"></td>
																		<td class="btn2" name="btn_t1downExcel1">Down Excel</td>
																		<td class="btn2_right"></td>
																	</tr>
																</table>
															</td>											
														</tr>
													</table>
												</td>
											</tr>
										</table>
					    				<!-- But (E) -->
					    			</td>
								</tr>
							</table>
							<!-- Button_Sub (E) -->

						</div>
						<!-- Tab Awkard (E) -->

						<!-- Tab Break-Bulk (S) -->
						<div id="tabLayer" style="display:inline">

							<!-- Grid - 1 (S) -->
							<table width="100%" class="search"  id="mainTable"> 
								<tr>
									<td width="100%">
										<script language="javascript">ComSheetObject('t3sheet1');</script>
									</td>
								</tr>
							</table> 
							<!-- Grid - 1 (E) -->	

							<!--  Button_Sub (S) -->
							<table class="search" border="0" style="width:100%;"> 
								<tr class="h23">
									<td width="138">
										<!--  But(S) -->
										<table width="100%" class="button"> 
							       			<tr>
							       				<td class="btn2_bg">
													<table border="0" cellpadding="0" cellspacing="0">
														<tr>
															<td>
																<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
																	<tr>
																		<td class="btn2_left"></td>
																		<td class="btn2" name="btn_t1appl2">Application Details</td>
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
									<td>
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
																		<td class="btn2" name="btn_t1downExcel2">Down Excel</td>
																		<td class="btn2_right"></td>
																	</tr>
																</table>
															</td>														
														</tr>
													</table>
												</td>
											</tr>
										</table>
										<!-- But (E) -->
									</td>
								</tr>
							</table>
							<!-- Button_Sub (E) -->

						</div>
						<!-- Tab Break-Bulk (E) -->

						<!-- Tab 45' (S) -->
						<div id="tabLayer" style="display:inline">

							<!-- Grid - 1 (S) -->
							<table width="100%" class="search"  id="mainTable"> 
								<tr>
									<td width="100%">
										<script language="javascript">ComSheetObject('t4sheet1');</script>
									</td>
								</tr>
							</table> 			
							<!-- Grid - 1 (E) -->	

							<!--  Button_Sub (S) -->
							<table class="search" border="0" style="width:100%;"> 
								<tr class="h23">
									<td width="138">
										<!--  But(S) -->
										<table width="100%" class="button"> 
							       			<tr>
							       				<td class="btn2_bg">
													<table border="0" cellpadding="0" cellspacing="0">
														<tr>
															<td>
																<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
																	<tr>
																		<td class="btn2_left"></td>
																		<td class="btn2" name="btn_t1appl3">Application Details</td>
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
					    			<td>
										<!--  Button_Sub (S) -->
										<table width="100%" class="button"> 
							       			<tr>
							       				<td class="btn2_bg">
													<table border="0" cellpadding="0" cellspacing="0">
														<tr>
															<td>
																<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
																	<tr>
																		<td class="btn2_left"></td>
																		<td class="btn2" name="btn_t1mail3">Mail </td>
																		<td class="btn2_right"></td>
																	</tr>
																</table>
															</td>
															<td>
																<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
																	<tr>
																		<td class="btn2_left"></td>
																		<td class="btn2" name="btn_t1downExcel3">Down Excel</td>
																		<td class="btn2_right"></td>
																	</tr>
																</table>
															</td>												
														</tr>
													</table>
												</td>
											</tr>
										</table>
					    				<!-- But (E) -->
					    			</td>
								</tr>
							</table>
							<!-- Button_Sub (E) -->

						</div>
						<!-- Tab 45' (E) -->

						<!-- Tab Reefer (S) -->
						<div id="tabLayer" style="display:inline">
			
							<!-- Grid - 1 (S) -->
							<table width="100%" class="search"  id="mainTable"> 
								<tr>
									<td width="100%">
										<script language="javascript">ComSheetObject('t5sheet1');</script>
									</td>
								</tr>
							</table> 			
							<!-- Grid - 1 (E) -->	

							<!--  Button_Sub (S) -->
							<table class="search" border="0" style="width:100%;"> 
								<tr class="h23">
									<td width="138">
										<!--  But(S) -->
										<table width="100%" class="button"> 
							       			<tr>
							       				<td class="btn2_bg">
													<table border="0" cellpadding="0" cellspacing="0">
														<tr>
															<td>
																<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
																	<tr>
																		<td class="btn2_left"></td>
																		<td class="btn2" name="btn_t1appl4">Application Details</td>
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
						    		<td>
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
																		<td class="btn2" name="btn_t1downExcel4">Down Excel</td>
																		<td class="btn2_right"></td>
																	</tr>
																</table>
															</td>													
														</tr>
													</table>
												</td>
											</tr>
										</table>
						    			<!-- But (E) -->
						    		</td>
								</tr>
							</table>
							<!-- Button_Sub (E) -->

						</div>
						<!-- Tab Reefer (E) -->
			
					</td>
				</tr>
			</table>
			<!-- 2 (E) -->		
			
			<!--Button (S) -->
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;"> 
       			<tr>
       				<td class="btn1_bg">		
					    <table border="0" cellpadding="0" cellspacing="0">
					    	<tr>
					    		<td>
					    			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_retrive" id="btn_Retrieve">Retrieve</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td>
									<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_new">New</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td class="btn1_line"></td>
								<td>
									<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_Save">Save</td>
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
		
			<!--biz page (E)-->

		</td>
	</tr>
</table>	

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>