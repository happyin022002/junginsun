<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_scg_0014.jsp
*@FileTitle : SPCL CGO APVL for Own BKG
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.06
*@LastModifier : 조경완
*@LastVersion : 1.0
* 2009.06.04 이도형
* 1.0 Creation

*history
*2012.07.06 조경완 [CHM-201218537-01] [VOP-SCG] SPCL CGO APVL for Own BKG lane code 입력 방식 변경
*2012.07.31 조경완 [CHM-201219311-01] [SCG] SPCL CGO APVL for Own BKG( 소스 수정)
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.event.VopScg0014Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopScg0014Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag 	= "";
	String codeList  	= "";
	String pageRows 	= "100";

	String strUsr_id	= "";
	String strUsr_nm	= "";
	Logger log = Logger.getLogger("com.hanjin.apps.CargoLoadingApproval.OwnDangerousCargoApproval");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (VopScg0014Event)request.getAttribute("Event");
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
<title>SPCL CGO APVL for Own BKG</title>
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
<!-- 개발자 작업	-->
<input type="hidden" name="tabSelectedIdx" value="0">
<input type="hidden" name="retrieve_flg" value="N">
<input type="hidden" name="t0retrieve_flg" value="N">
<input type="hidden" name="t1retrieve_flg" value="N">
<input type="hidden" name="t2retrieve_flg" value="N">
<input type="hidden" name="t3retrieve_flg" value="N">
<input type="hidden" name="t4retrieve_flg" value="N">
<input type="hidden" name="t5retrieve_flg" value="N">
<input type="hidden" name="to_eta_dt" value="<%=DateTime.getFormatDate(new java.util.Date(),"yyyyMMdd")%>">
<input type="hidden" name="vsl_slan_cd">
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr>
		<td valign="top">
			<!--Page Title, Historical (S)-->
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
				<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
				<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
			</table>
			<!--Page Title, Historical (E)-->
			
			<!--biz page (S)-->
			<table class="search">
		       	<tr>
		       		<td class="bg">
						<!--  biz_1  (S) -->
						<table class="search" border="0" style="width:979;">
							<tr class="h23">
								<td width="37">RSO</td>
								<td width="90" style="padding-left:3">
							   		<script language="javascript">ComComboObject('rgn_shp_opr_cd', 3, 74, 1, 1);</script>
								</td>
								
								<td width="700">
									<script language="javascript">ComSheetObject1('laneSheet');</script>
								</td>
								<td>&nbsp;RQST DT Range</td>
								<td width="">(-)&nbsp;<input type="text" name="rqst_dt_range" style="width:30;ime-mode:disabled;" class="input" value="50" dataformat="int" maxlength="3" ></td>	
<!--								<td width="32">Lane</td>-->
<!--								<td width="">-->
<!--									<input type="text" name="slan_cd1" caption="Lane Code 1" maxlength="3" dataformat="uppernum" style="width:50;ime-mode:disabled;" class="input" value="">&nbsp;<img class="cursor" name="btn_SlanCd1" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle">-->
<!--									<input type="text" name="slan_cd2" caption="Lane Code 2" maxlength="3" dataformat="uppernum" style="width:40;ime-mode:disabled;" class="input" value="">&nbsp;<img class="cursor" name="btn_SlanCd2" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle">-->
<!--									<input type="text" name="slan_cd3" caption="Lane Code 3" maxlength="3" dataformat="uppernum" style="width:45;ime-mode:disabled;" class="input" value="">&nbsp;<img class="cursor" name="btn_SlanCd3" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle">-->
<!--									<input type="text" name="slan_cd4" caption="Lane Code 4" maxlength="3" dataformat="uppernum" style="width:45;ime-mode:disabled;" class="input" value="">&nbsp;<img class="cursor" name="btn_SlanCd4" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle">-->
<!--									<input type="text" name="slan_cd5" caption="Lane Code 5" maxlength="3" dataformat="uppernum" style="width:45;ime-mode:disabled;" class="input" value="">&nbsp;<img class="cursor" name="btn_SlanCd5" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle">-->
<!--									<input type="text" name="slan_cd6" caption="Lane Code 6" maxlength="3" dataformat="uppernum" style="width:45;ime-mode:disabled;" class="input" value="">&nbsp;<img class="cursor" name="btn_SlanCd6" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle">-->
<!--									<input type="text" name="slan_cd7" caption="Lane Code 7" maxlength="3" dataformat="uppernum" style="width:45;ime-mode:disabled;" class="input" value="">&nbsp;<img class="cursor" name="btn_SlanCd7" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle">-->
<!--									<input type="text" name="slan_cd8" caption="Lane Code 8" maxlength="3" dataformat="uppernum" style="width:50;ime-mode:disabled;" class="input" value="">&nbsp;<img class="cursor" name="btn_SlanCd8" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle">-->
<!--									<input type="text" name="slan_cd9" caption="Lane Code 9" maxlength="3" dataformat="uppernum" style="width:45;ime-mode:disabled;" class="input" value="">&nbsp;<img class="cursor" name="btn_SlanCd9" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle">-->
<!--									<input type="text" name="slan_cd10" caption="Lane Code 10" maxlength="3" dataformat="uppernum" style="width:45;ime-mode:disabled;" class="input" value="">&nbsp;<img class="cursor" name="btn_SlanCd10" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle">-->
<!--									<input type="text" name="slan_cd11" caption="Lane Code 11" maxlength="3" dataformat="uppernum" style="width:40;ime-mode:disabled;" class="input" value="">&nbsp;<img class="cursor" name="btn_SlanCd11" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle">-->
<!--								</td>-->
							</tr>
						</table>
						<table class="search" border="0" style="width:979;">
							<tr class="h23">
								<td width="37">Vessel</td>
								<td width="96" style="padding-left:3">
									<input type="text" name="vsl_cd" style="width:52;ime-mode:disabled;" caption="Vessel Code" maxlength="4" dataformat="uppernum" class="input" value="">&nbsp;<img class="cursor" name="btn_Vessel" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle">
								</td>
								<td width="255">
									<table  class="search_sm2" border="0" style="width:240;" >
										<tr class="h23">
											<td width="57">VSL OPR</td>
											<td class="stm">
												<input type="radio" name="val_opr_tp_cd" value="" class="trans" checked>&nbsp;All&nbsp;&nbsp;
												<input type="radio" name="val_opr_tp_cd" value="H" class="trans">&nbsp;SML&nbsp;&nbsp;
												<input type="radio" name="val_opr_tp_cd" value="O" class="trans">&nbsp;Others
											</td>
										</tr>
									</table>
								</td>
								<td width="340">
									<table  class="search_sm2" border="0" style="width:330;" >
										<tr class="h23">
											<td width="110">Approval Status</td>
											<td class="stm">
												<input type="radio" name="auth_flg" value="A" class="trans" checked>&nbsp;All&nbsp;&nbsp;
												<input type="radio" name="auth_flg" value="R" class="trans">&nbsp;Request&nbsp;&nbsp;
												<input type="radio" name="auth_flg" value="P" class="trans">&nbsp;Pending
											</td>
										</tr>
									</table>
								</td>
								<!--  
								<td width="85"><input type="checkbox" name="from_eta_flg" value="Y" class="trans" checked>Post VVD</td>
								<td width=""><input type="text" name="from_eta_dt" style="width:25;ime-mode:disabled;" class="input1" value="10" dataformat="int" maxlength="3" > days before ETA</td>
								-->
								<td width="97">&nbsp;</td>
								<td width="">Passed ETA Date(-)&nbsp;<input type="text" name="vps_eta_dt" style="width:30;ime-mode:disabled;" class="input" value="50" dataformat="int" maxlength="3" ></td>	
							</tr>
						</table>
						<!--  biz_1   (E) -->
					</td>
				</tr>
			</table>
			<table class="height_7"><tr><td></td></tr></table>
			
			<!-- Tab ) (S) -->
     		<table class="tab" border="0" cellpadding="0" cellspacing="0" style="width:100%;">
       			<tr>
       				<td width="100%">
						<script language="javascript">ComTabObject('tab1')</script>
					</td>
				</tr>
			</table>
			<!-- Tab ) (E) -->

			<!--  Tab) DG - Part I (S) -->
			<div id="tabLayer" style="display:inline;">
	     	<table class="search">
		       	<tr>
		       		<td class="bg" style="height:408;" valign="top">
						<!--  biz_2  (S) -->
						<table class="search" border="0" style="width:100%;">
							<tr class="h23">
								<td width="100%" align="right"><input type="checkbox" name="t1HjsBox" value="" class="trans">&nbsp;&nbsp;Box for SML VSL</td>
							</tr>
						</table>

						<!-- Grid  (S) -->
						<table width="100%" class="search"  id="mainTable">
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('t1sheet1');</script>
								</td>
							</tr>
						</table>
						<!-- Grid (E) -->

						<table class="search" border="0" style="width:100%;">
							<tr class="h23">
								<td width="50%" align="left" class="stm">* DG - Part I  :  CL 1, 2, 5.2, 7 & PSA 1</td>
								<td width="50%" align="right">
									<table width="100%" class="button">
						       			<tr>
						       				<td class="btn2_bg">
												<table border="0" cellpadding="0" cellspacing="0">
													<tr>
														<td width="">
															<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
																<tr>
																	<td class="btn2_left"></td>
																	<td class="btn2" name="btn_t1ApplDetails">Application Details</td>
																	<td class="btn2_right"></td>
																</tr>
															</table>
														</td>
													</tr>
												</table>
											</td>
										</tr>
									</table>
								</td>
							</tr>
							<tr class="h23">
								<td width="50%" align="left" class="stm">* DG - Part II : Except CL 1, 2, 5.2, 7 & PSA 1</td>
								<td width="50%" align="right">
									<table width="100%" class="button">
						       			<tr>
						       				<td class="btn2_bg">&nbsp;</td>
					       				</tr>
									</table>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			</div>	
			<!--  Tab) DG - Part I (E) -->

			<!--  Tab) DG - Part II (S) -->
			<div id="tabLayer" style="display:none">
	     	<table class="search">
		       	<tr>
		       		<td class="bg" style="height:408;" valign="top">
						<!--  biz_2  (S) -->
						<table class="search" border="0" style="width:100%;">
							<tr class="h23">
								<td width="100%" align="right"><input type="checkbox" name="t2HjsBox" value=""class="trans">&nbsp;&nbsp;Box for SML VSL</td>
							</tr>
						</table>
						<!-- Grid  (S) -->
						<table width="100%" class="search"  id="mainTable">
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('t2sheet1');</script>
								</td>
							</tr>
						</table>
						<!-- Grid (E) -->
						<table class="search" border="0" style="width:100%;">
							<tr class="h23">
								<td width="50%" align="left" class="stm">* DG - Part I  :  CL 1, 2, 5.2, 7 & PSA 1</td>
								<td width="50%" align="right">
									<table width="100%" class="button">
						     			<tr>
						     				<td class="btn2_bg">
												<table border="0" cellpadding="0" cellspacing="0">
													<tr>
														<td width="">
															<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
																<tr>
																	<td class="btn2_left"></td>
																	<td class="btn2" name="btn_t2ApplDetails">Application Details</td>
																	<td class="btn2_right"></td>
																</tr>
															</table>
														</td>
													</tr>	
												</table>
											</td>
										</tr>
									</table>
								</td>
							</tr>
							<tr class="h23">
								<td width="50%" align="left" class="stm">* DG - Part II : Except CL 1, 2, 5.2, 7 & PSA 1</td>
								<td width="50%" align="right">
									<table width="100%" class="button">
						      			<tr>
						      				<td class="btn2_bg">&nbsp;</td>
						   				</tr>
									</table>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			</div>
			<!--  Tab)  DG - Part II (E) -->

			<!--  Tab) Awkwark (S) -->
			<div id="tabLayer" style="display:none">
			<table class="search">
				<tr>
					<td class="bg" style="height:408;" valign="top">
						<!--  biz_2  (S) -->
						<table class="search" border="0" style="width:100%;">
							<tr class="h23">
								<td width="100%" align="right"><input type="checkbox" name="t3HjsBox" value=""class="trans">&nbsp;&nbsp;Box for SML VSL</td>
							</tr>
						</table>
						<!-- Grid  (S) -->
						<table width="100%" class="search"  id="mainTable">
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('t3sheet1');</script>
								</td>
							</tr>
						</table>
						<!-- Grid (E) -->
						<table class="search" border="0" style="width:100%;">
							<tr class="h23">
								<td width="50%" align="left" class="stm">* DG - Part I  :  CL 1, 2, 5.2, 7 & PSA 1</td>
								<td width="50%" align="right">
									<table width="100%" class="button">
										<tr>
											<td class="btn2_bg">
												<table border="0" cellpadding="0" cellspacing="0">
													<td width="">
														<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
															<tr>
																<td class="btn2_left"></td>
																<td class="btn2" name="btn_t3ApplDetails">Application Details</td>
																<td class="btn2_right"></td>
															</tr>
														</table>
													</td>
												</table>
											</td>
										</tr>
									</table>
								</td>
							</tr>
							<tr class="h23">
								<td width="50%" align="left" class="stm">* DG - Part II : Except CL 1, 2, 5.2, 7 & PSA 1</td>
								<td width="50%" align="right">
									<table width="100%" class="button">
										<tr>
											<td class="btn2_bg">&nbsp;</td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			</div>
			<!--  Tab) Awkwark (E) -->

			<!--  Tab) Break-Bulk (S) -->
			<div id="tabLayer" style="display:none">
    	 	<table class="search">
       			<tr>
       				<td class="bg" style="height:408;" valign="top">
						<!--  biz_2  (S) -->
						<table class="search" border="0" style="width:100%;">
							<tr class="h23">
								<td width="100%" align="right"><input type="checkbox" name="t4HjsBox" value=""class="trans">&nbsp;&nbsp;Box for SML VSL</td>
							</tr>
						</table>
						<!-- Grid  (S) -->
						<table width="100%" class="search"  id="mainTable">
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('t4sheet1');</script>
								</td>
							</tr>
						</table>
						<!-- Grid (E) -->

						<table class="search" border="0" style="width:100%;">
							<tr class="h23">
								<td width="50%" align="left" class="stm">* DG - Part I  :  CL 1, 2, 5.2, 7 & PSA 1</td>
								<td width="50%" align="right">
									<table width="100%" class="button">
						       			<tr>
						       				<td class="btn2_bg">
												<table border="0" cellpadding="0" cellspacing="0">
													<td width="">
														<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
															<tr>
																<td class="btn2_left"></td>
																<td class="btn2" name="btn_t4ApplDetails">Application Details</td>
																<td class="btn2_right"></td>
															</tr>
														</table>
													</td>
												</table>
											</td>
										</tr>
									</table>
								</td>
							</tr>
							<tr class="h23">
								<td width="50%" align="left" class="stm">* DG - Part II : Except CL 1, 2, 5.2, 7 & PSA 1</td>
								<td width="50%" align="right">
									<table width="100%" class="button">
										<tr>
											<td class="btn2_bg">&nbsp;</td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			</div>
			<!--  Tab) Break-Bulk (E) -->
	
			<!--  Tab) 45 (S) -->
			<div id="tabLayer" style="display:none">
	     	<table class="search">
		       	<tr>
		       		<td class="bg" style="height:408;" valign="top">
						<!--  biz_2  (S) -->
						<table class="search" border="0" style="width:100%;">
							<tr class="h23">
								<td width="100%" align="right"><input type="checkbox" name="t5HjsBox" value="" class="trans">&nbsp;&nbsp;Box for SML VSL</td>
							</tr>
						</table>
						<!-- Grid  (S) -->
						<table width="100%" class="search"  id="mainTable">
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('t5sheet1');</script>
								</td>
							</tr>
						</table>
						<!-- Grid (E) -->
						<table class="search" border="0" style="width:100%;">
							<tr class="h23">
								<td width="50%" align="left" class="stm">* DG - Part I  :  CL 1, 2, 5.2, 7 & PSA 1</td>
								<td width="50%" align="right">
									<table width="100%" class="button">
						       			<tr>
						       				<td class="btn2_bg">
												<table border="0" cellpadding="0" cellspacing="0">
													<td width="">
														<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
															<tr>
																<td class="btn2_left"></td>
																<td class="btn2" name="btn_t5ApplDetails">Application Details</td>
																<td class="btn2_right"></td>
															</tr>
														</table>
													</td>
												</table>
											</td>
										</tr>
									</table>
								</td>
							</tr>
							<tr class="h23">
								<td width="50%" align="left" class="stm">* DG - Part II : Except CL 1, 2, 5.2, 7 & PSA 1</td>
								<td width="50%" align="right">
									<table width="100%" class="button">
										<tr>
											<td class="btn2_bg">&nbsp;</td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			</div>
			<!--  Tab) 45 (E) -->

			<!--  Tab) Reefer (S) -->
			<div id="tabLayer" style="display:none">
			<table class="search">
			 	<tr>
			 		<td class="bg" style="height:408;" valign="top">
						<!--  biz_2  (S) -->
						<table class="search" border="0" style="width:100%;">
							<tr class="h23">
								<td width="100%" align="right"><input type="checkbox" name="t6HjsBox" value="" class="trans">&nbsp;&nbsp;Box for SML VSL</td>
							</tr>
						</table>
						<!-- Grid  (S) -->
						<table width="100%" class="search"  id="mainTable">
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('t6sheet1');</script>
								</td>
							</tr>
						</table>
						<!-- Grid (E) -->
						<table class="search" border="0" style="width:100%;">
							<tr class="h23">
								<td width="50%" align="left" class="stm">* DG - Part I  :  CL 1, 2, 5.2, 7 & PSA 1</td>
								<td width="50%" align="right">
									<table width="100%" class="button">
						       			<tr>
						       				<td class="btn2_bg">
												<table border="0" cellpadding="0" cellspacing="0">
													<tr>
														<td width="">
															<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
																<tr>
																	<td class="btn2_left"></td>
																	<td class="btn2" name="btn_t6ApplDetails">Application Details</td>
																	<td class="btn2_right"></td>
																</tr>
															</table>
														</td>
													</tr>
												</table>
											</td>
										</tr>
									</table>
								</td>
							</tr>
							<tr class="h23">
								<td width="50%" align="left" class="stm">* DG - Part II : Except CL 1, 2, 5.2, 7 & PSA 1</td>
								<td width="50%" align="right">
									<table width="100%" class="button">
						       			<tr>
						       				<td class="btn2_bg">&nbsp;</td>
					       				</tr>
									</table>
								</td>
							</tr>
						</table>						
					</td>
				</tr>
			</table>
			</div>	
			<!--  Tab) Reefer (E) -->

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
											<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td>
									<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_New">New</td>
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
		</td>
	</tr>
</table>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>