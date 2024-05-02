<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_scg_0022.jsp
*@FileTitle : SPCL CGO APVL for Partner Lines (Creation)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.24
*@LastModifier : 김현욱
*@LastVersion : 1.0
* 2009.06.24 김현욱
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
<%@ page import="com.hanjin.apps.alps.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.event.VopScg0022Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopScg0022Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String rso              = "";
	Logger log = Logger.getLogger("com.hanjin.apps.CargoLoadingApproval.PartnerLinesDangerousCargoApproval");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (VopScg0022Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		rso = eventResponse.getETCData("rso");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>SPCL CGO APVL for Partner Lines (Creation)</title>
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
<input type="hidden" name="user_id" value="<%=strUsr_id%>">
<input type="hidden" name="u_rso" value="<%=rso%>">
<input type="hidden" name="tabSelectedIdx" value="0">

<!-- Mail Parameter -->

<!-- Mail Parameter -->

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
	
			<!--biz page (S)-->
			<!-- 1 (S) -->
			<table class="search" id="mainTable"> 
	       		<tr>
	       			<td class="bg">
						<!--  biz_1  (S) -->
						<table class="search" border="0" style="width:979;"> 
							<tr class="h23">
								<td width="50">RSO</td>
								<td width="180"style="padding-left:2" >
									<script language="javascript">ComComboObject('rgn_shp_opr_cd', 2, 50, 1, 1);</script>
								</td>
								<td width="95" align="right" >BKG Company &nbsp;</td>
								<td width="150"><input id="cgo_opr_cd" type="text" name="cgo_opr_cd" style="width:40" class="input" value="" caption="BKG Company" minlength="3" maxlength="4" dataformat="engup" style="ime-mode:disabled">&nbsp;<img src="img/btns_search.gif" name="btn_Carrier" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
								<td width="80" align="left">&nbsp;POL &nbsp;</td>
								
								<td width="100"><input type="text" name="pol_cd" style="width:60;text-align:center;ime-mode:disabled;text-transform:uppercase;" class="input" value="" dataformat="engup" maxlength="5" >&nbsp;<img src="img/btns_search.gif" width="19" height="20" name="btn_Pol" border="0" align="absmiddle" class="cursor"></td>
								
								<td width="87" align="right"  > APVL Type &nbsp;</td>
								<td colspan="3">
								<input type="radio" class="trans" name="auth_sts_cd"  value="Y" >&nbsp;<span id="auth_sts_cd1">Accepted</span>&nbsp;
								<input type="radio" class="trans" name="auth_sts_cd"  value="R" >&nbsp;<span id="auth_sts_cd2">Request</span>&nbsp;
								<input type="radio" class="trans" name="auth_sts_cd"  value="A" checked="true">&nbsp;<span id="auth_sts_cd3">All</span>&nbsp;
								</td>
							</tr>
						</table>
						<table class="search" border="0" style="width:979;"> 
							<tr class="h23">
								<td width="50">VVD CD</td>
								<td  width="180">
								<input name="vsl_cd" required fullfill type="text" style="width:50;" class="input1" value="" caption="VVD CD" maxlength="4" dataformat="engup"  style="ime-mode:disabled"><!-- &nbsp; -->
								<input name="skd_voy_no" required fullfill type="text" style="width:50;" class="input1" value="" caption="VVD CD" maxlength="4" dataformat="engup" style="ime-mode:disabled"><!--&nbsp; -->
								<input name="skd_dir_cd" required fullfill type="text" style="width:25;" class="input1" value="" caption="VVD CD" maxlength="1" dataformat="engup" style="ime-mode:disabled"><!--&nbsp; -->
								<img name="btn_VVDpop" class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"><!-- &nbsp; -->
							    
							    <input name="vsl_eng_nm" type="hidden" style="width:200;" class="input2" value="" readonly="readonly">
								<input type="hidden" name="crr_cd"></td>
								
								<td width="95" align="left" >&nbsp;BKG Ref.NO &nbsp;</td>
								<td width="150" align="left" >&nbsp;<input type="text" name="bkg_ref_no" style="width:130;text-align:center;ime-mode:disabled;text-transform:uppercase;" class="input" maxlength="30" value=""  ></td>
								<td width="80" align="left" >&nbsp;RQST D/T </td>
								<td width="">&nbsp;<input type="text" name="from_eta_dt" style="width:81" class="input" value="" dataformat="ymd" maxlength="8" caption="FM DT">&nbsp;~&nbsp;<input type="text" name="to_eta_dt" style="width:85" class="input" value="" dataformat="ymd" maxlength="8" caption="TO DT">&nbsp;<img src="img/btns_calendar.gif" name="btn_Calendar" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
								<td width="50" align="right" >Lane &nbsp;</td>
								<td width="105">&nbsp;<input name="slan_cd" type="text" style="width:60;" class="input2" value="" readOnly>
								                <input name="slan_nm" type="hidden" style="width:233;" class="input2" value="" readOnly></td>
								<!-- td width="87">BKG Company</td>
								<td><input id="cgo_opr_cd" type="text" name="cgo_opr_cd" style="width:40" class="input" value="" caption="BKG Company" minlength="3" maxlength="4" dataformat="engup" style="ime-mode:disabled">&nbsp;<img src="img/btns_search.gif" name="btn_Carrier" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td -->
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
				<tr>
					<td width="100%">
						<script language="javascript">ComTabObject('tab1')</script>
					</td>
				</tr>
			</table>
			<!-- Tab (E) -->

			<table class="search" id="mainTable"> 
	       		<tr>
	       			<td class="bg" style="height:415;" valign="top">	
	
						<!-- Tab DG (S) -->
						<div id="tabLayer" style="display:inline">
		
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
							<table width="100%" class="button"> 
						       	<tr>
						       		<td class="btn2_bg">
										<table border="0" cellpadding="0" cellspacing="0">
											<tr>
												<td>
													<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
														<tr>
															<td class="btn2_left"></td>
															<td class="btn2" name="btn_details">Application Details</td>
															<td class="btn2_right"></td>
														</tr>
													</table>
												</td>
												<td>
													<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
														<tr>
															<td class="btn2_left"></td>
															<td class="btn2" name="btn_t1add">Row Add</td>
															<td class="btn2_right"></td>
														</tr>
													</table>
												</td>										
												<td>
													<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
														<tr>
															<td class="btn2_left"></td>
															<td class="btn2" name="btn_t1copy">Row Copy</td>
															<td class="btn2_right"></td>
														</tr>
													</table>
												</td>										
												<td>
													<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
														<tr>
															<td class="btn2_left"></td>
															<td class="btn2" name="btn_t1delete">Row Delete</td>
															<td class="btn2_right"></td>
														</tr>
													</table>
												</td>										
												<td>
													<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
														<tr>
															<td class="btn2_left"></td>
															<td class="btn2" name="btn_t1downExcel">Down Excel</td>
															<td class="btn2_right"></td>
														</tr>
													</table>
												</td>										
												<td>
													<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
														<tr>
															<td class="btn2_left"></td>
															<td class="btn2" name="btn_t1loadExcel">Load Excel</td>
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
					    	
						</div>
						<!-- Tab DG (E) -->
		
						<!-- Tab Awkward (S) -->
						<div id="tabLayer" style="display:none">
		
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
							<table width="100%" class="button"> 
			       				<tr>
			       					<td class="btn2_bg">
										<table border="0" cellpadding="0" cellspacing="0">
											<tr>
												<td>
													<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
														<tr>
															<td class="btn2_left"></td>
															<td class="btn2" name="btn_t2insert">Row Insert</td>
															<td class="btn2_right"></td>
														</tr>
													</table>
												</td>	
												<td>
													<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
														<tr>
															<td class="btn2_left"></td>
															<td class="btn2" name="btn_t2add">Row Add</td>
															<td class="btn2_right"></td>
														</tr>
													</table>
												</td>									
												<td>
													<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
														<tr>
															<td class="btn2_left"></td>
															<td class="btn2" name="btn_t2copy">Row Copy</td>
															<td class="btn2_right"></td>
														</tr>
													</table>
												</td>										
												<td>
													<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
														<tr>
															<td class="btn2_left"></td>
															<td class="btn2" name="btn_t2delete">Row Delete</td>
															<td class="btn2_right"></td>
														</tr>
													</table>
												</td>										
												<td>
													<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
														<tr>
															<td class="btn2_left"></td>
															<td class="btn2" name="btn_mail">Mail </td>
															<td class="btn2_right"></td>
														</tr>
													</table>
												</td>
												<td>
													<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
														<tr>
															<td class="btn2_left"></td>
															<td class="btn2" name="btn_t2downExcel">Down Excel</td>
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
		
						</div>
						<!-- Tab Awkward (E) -->
				
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
											<td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
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
											<td class="btn1" name="btn_save">Save</td>
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
<!--Booking Information Component (S) -->
<script language="javascript">ComSheetObject('t0sheet1');</script>
<script language="javascript">ComSheetObject('t3sheet1');</script>
<!--Booking Information Component (E) -->
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>