<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_opf_0019.jsp
*@FileTitle : CBF for Own Booking (Creation)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.18
*@LastModifier : 우지석
*@LastVersion : 1.0
* 2009.05.18 우지석
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
<%@ page import="com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.event.VopOpf0019Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopOpf0019Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList    = "";
	String pageRows    = "100";

	String strUsr_id   = "";
	String strUsr_nm   = "";
	Logger log = Logger.getLogger("com.hanjin.apps.CargoLoadingPlanMgt.OwnContainerBookingForecastMgt");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (VopOpf0019Event)request.getAttribute("Event");
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
<title>CBF for Own Booking (Creation)</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	var userId = '<%=strUsr_id%>';
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

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<input type="hidden" name="bk_st">
<input type="hidden" name="bkg_shpr_ownr_flg" value="Y">
<input type="hidden" name="crr_cd"            value="SML">
<input type="hidden" name="cre_dt">

<input type="hidden" name="gubun">

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
											<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_New" id="btn_New">New</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td class="btn1_line"></td>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_Delete">Delete</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_Save">Save</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_SaveAsXML">Save As XML</td>
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
			<table class="search"> 
       			<tr>
       				<td class="bg">
						<!-- biz_1  (S) -->
						<table class="search" border="0" style="width:979;"> 
							<tr class="h23">
								<td width="50">VVD CD</td>
								<td width="280">
									<input name="vsl_cd" type="text" style="width:40;" class="input1" value="" caption="VVD CD" required fullfill maxlength="4" dataformat="engup" style="ime-mode:disabled">&nbsp;<input name="skd_voy_no" type="text" style="width:40;" class="input1" value="" caption="VVD CD" required fullfill maxlength="4" dataformat="engup" style="ime-mode:disabled">&nbsp;<input name="skd_dir_cd" type="text" style="width:20;" class="input1" value="" caption="VVD CD" fullfill required maxlength="1" dataformat="engup" style="ime-mode:disabled">&nbsp;<img src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor" name="btn_vvd">&nbsp;<input name="vsl_eng_nm" type="text" style="width:130;" class="input2" value="" readonly><input type="text" style="width:0;" name="noname" readOnly>
								</td>
								<td width="28">POL</td>
								<td width="330">
									<script language="javascript">ComComboObject('yd_cd', 1, 80, 0);</script>&nbsp;<input type="text" style="width:80;" class="input2" name="loc_nm" readOnly>&nbsp;<input type="text" style="width:150;" class="input2" name="yd_nm" readOnly>
								</td> 
								<td width="25">ETA</td>
								<td width="120"><input type="text" style="width:110;" class="input2" name="eta" readOnly></td>
								<td width="" align="center">
									<table class="search" border="0" style="width:140;background-color: #E9E9E9;padding:2 2 2 2">
										<tr class="h23">
											<td width="30">&nbsp;&nbsp;&nbsp;CBF</td> 
											<td width="" class="stm">
												<input type="radio" value="P" name="cbf_ind_flg" class="trans">Pre&nbsp;
												<input type="radio" value="F" name="cbf_ind_flg" class="trans">Final
											</td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
						<table class="search" border="0" style="width:979;"> 
							<tr class="h23">
								<td width="50">Lane</td>
								<td width="280"><input name="slan_cd" type="text" style="width:40;" class="input2" value="" readOnly>&nbsp;<input name="slan_nm" type="text" style="width:221;" class="input2" value="" readOnly></td>
								<td width="" align="">Last Created&nbsp;<input type="text" style="width:65;text-align:center;" class="input2" name="upd_usr_id" readOnly>&nbsp;<input type="text" style="width:110;text-align:center;" class="input2" name="upd_dt" readOnly></td>
								<td width="" colspan="2">
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
			
						<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
						<!-- biz_1  (S) -->
						<table class="search" border="0" style="width:979;"> 
							<tr class="h23">
								<td width="560" colspan=""><!-- 800 -->
									<table class="search" border="0" style="width:520;background-color: #E9E9E9;padding:2 2 2 2">
										<tr class="h23">
											<td width="103">&nbsp;Booking Status</td> 
											<td width="130" class="stm">
												<input type="radio" value="" class="trans" name="cbf_bkg_sts_cd">&nbsp;All&nbsp;&nbsp;&nbsp;
												<input type="radio" value="F" class="trans" name="cbf_bkg_sts_cd">&nbsp;Firm&nbsp;&nbsp;&nbsp;</td>
											<td width="110">&nbsp;Actual Cntr only</td> 
											<td width="30" class="stm">
												<input type="checkbox" value="C" class="trans" name="ac_cntr_flg"></td>
											<td width="" align="right">
												<!--  Button_Sub (S) -->
												<table width="130" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" name="btn_Display">Import BKG Data</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
									    	<!-- Button_Sub (E) -->
											</td> 
											<td width="5"></td>
										</tr>
									</table>
								</td>
								
								<td width="240" align="">CNTR No.&nbsp;<input type="text" name="dup_cntr_no" caption="CNTR_NO" maxlength="12" dataformat="engup" style="width:100;text-align:center;ime-mode:disabled;" class="input" value=""></td>
								
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
																	<td class="btn2" name="btn_SummaryPreview">Summary Preview</td>
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
						<!-- biz_1  (E) -->		
				
					</td>
				</tr>
			</table>		
			
   			<table class="height_8"><tr><td></td></tr></table>
			<!-- Tab (S) -->
    			<table class="tab" border="0" cellpadding="0" cellspacing="0" width=100%>
				<tr>
					<td width="100%">
						<script language="javascript">ComTabObject('tab1')</script>
					</td>
				</tr>
			</table>
			<!-- Tab (E) -->
			<table class="search"> 
   				<tr>
   					<td class="bg">
						<!--  Tab_1 (S) -->
						<div id="tabLayer" style="display:inline">
       					<table class="search">
           					<tr>
           						<td>		
									<!-- Grid  (S) -->
									<table width="100%"  id="mainTable"> 
										<tr>
											<td width="100%">
												<script language="javascript">ComSheetObject('t1sheet1');</script>
											</td>					
										</tr>
									</table>
									<!-- Grid (E) -->
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
																	<td class="btn2" name="t1btn_Delete">Row Delete</td>
																	<td class="btn2_right"></td>
																</tr>
															</table>
														</td>
														<td>
															<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
																<tr>
																	<td class="btn2_left"></td>
																	<td class="btn2" name="t1btn_DupCntr">Duplicated CNTR</td>
																	<td class="btn2_right"></td>
																</tr>
															</table>
														</td>
														<td>
															<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
																<tr>
																	<td class="btn2_left"></td>
																	<td class="btn2" name="btn_DownExcel">Down Excel</td>
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
   						</div>
						<!--  Tab_1 (E) -->			
						<!--  Tab_2 (S) -->
						<div id="tabLayer" style="display:none">
					        <table class="search">
					            <tr>
					            	<td>
										<table width="100%"  id="mainTable"> 
											<tr>
												<td width="100%">
													<script language="javascript">ComSheetObject('t2sheet1');</script>
												</td>
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
																		<td class="btn2" name="btn_DownExcel">Down Excel</td>
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
					    </div>						
						<!--  Tab_2 (E) -->

					</td>
				</tr>
			</table>
			<!-- Tab BG Box(E) -->
			<!--biz page (E)-->
			<table class="height_10"><tr><td></td></tr></table>
		</td>
	</tr>
</table>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>