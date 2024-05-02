<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.eas.transportmanage.event.EsdEas0011Event"%>
<%@ page import="com.hanjin.framework.component.util.StringUtil" %>

<%
	SignOnUserAccount account = null; //Session 정보
	EsdEas0011Event  event = null; //
	Exception serverException   = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지

	try {
		account = (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		event = (EsdEas0011Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	}catch(Exception e) {
		out.println(e.toString());
	}
	String loc_cd 		= JSPUtil.getNull(StringUtil.xssFilter(request.getParameter("s_loc_cd")));
	String cust_info 	= JSPUtil.getNull(StringUtil.xssFilter(request.getParameter("s_cust_info")));
	String cntr_tp_cd 	= JSPUtil.getNull(StringUtil.xssFilter(request.getParameter("s_cntr_tp_cd")));
	String curr_cd 		= JSPUtil.getNull(StringUtil.xssFilter(request.getParameter("s_curr_cd")));
	String conti_cd 	= JSPUtil.getNull(StringUtil.xssFilter(request.getParameter("s_conti_cd")));
	String conti_cd_old	= JSPUtil.getNull(StringUtil.xssFilter(request.getParameter("s_conti_cd_old")));
%>

<html>
<head>
<title>Drop Off Charge Tariff List 조회</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">

	var loc_cd 		 = "<%=loc_cd%>";
	var cust_info 	 = "<%=cust_info%>";
	var cntr_tp_cd 	 = "<%=cntr_tp_cd%>";
	var curr_cd 	 = "<%=curr_cd%>";
	var conti_cd 	 = "<%=conti_cd%>";
	var conti_cd_old = "<%=conti_cd_old%>";

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		}
		loadPage();
	}

</script>
</head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="ctrl_user_id" value="<%=account.getUsr_id()%>">
<input type="hidden" name="ctrl_ofc_cd" value="<%=account.getOfc_cd()%>">
<input type="hidden" name="ctrl_Cnt_cd" value="<%=account.getCnt_cd()%>">
<input type='hidden' name='s_conti_cd' value='<%=conti_cd%>'>
<input type='hidden' name='s_conti_cd_old' value='<%=conti_cd_old%>'>
<input type='hidden' name='s_cntr_tp_cd' value='<%=cntr_tp_cd%>'>
<input type='hidden' name='s_loc_cd' value='<%=loc_cd%>'>
<input type='hidden' name='s_curr_cd' value='<%=curr_cd%>'>
<input type='hidden' name='s_cust_info' value='<%=cust_info%>'>
<input type='hidden' name='is_save' value=''>
<input type='hidden' name='drff_chg_trf_seq' value=''>
<input type='hidden' name='drff_chg_trf_ver_no' value=''>
<input type='hidden' name='fm_eff_dt' value=''>
<input type='hidden' name='to_eff_dt' value=''>
<input type='hidden' name='cre_ofc_cd' value='<%=account.getOfc_cd()%>'>
<input type='hidden' name='scc_cd2' value=''>
<input type='hidden' name='is_upload' value='N'>

<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>


		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
			</table>
		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->


		<!-- TABLE '#D' : ( Button : Main ) (S) -->
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
					<tr><td class="btn1_bg">

							<table border="0" cellpadding="0" cellspacing="0">
								<tr>
									<!-- Repeat Pattern -->
									<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn1_left"></td><td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>
									<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn1_left"></td><td class="btn1" name="btn_new" id="btn_new">New</td><td class="btn1_right"></td></tr></table></td>
								</tr>
							</table>
					</td></tr>
				</table>
    	<!-- TABLE '#D' : ( Button : Main ) (E) -->

		<!-- TABLE '#D' : ( Search Options ) (S) -->
     	<table class="search">
       	<tr><td class="bg">

				<!-- : ( Week ) (S) -->
				<table class="search_in" border="0">

					<tr class="h23">
						<td width="140">
						<input type="radio"  name="search_choice" value="recntcd" class="trans" onClick="selectWhere();" >&nbsp;Country</td>
						<td width="350" colspan="3">
						<input type="text" name="cnt_cd" style="width:25;ime-mode:disabled;" chkField(this, 'eng', true, 13);" dataformat="engup"  onClick="selectText(this);" maxlength="2">
						<input name="sel_cnt_nm" type="text" style="width:197" value=""  onClick="selectText(this);">
						<img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="cnt_btn">
						</td>
					</tr>

				<tr class="h23">
					<td width=""><input type="radio"  name="search_choice" value="custcd" class="trans" onClick="selectWhere();">&nbsp;RFA</td>
					<td width=""><input name="rfa_no" type="text" style="width:95 ; text-transform:uppercase;" maxlength="11" value="" onBlur="checkRfadata();" onClick="selectText(this);"></td>
					<td width=""></td>
					<td width=""></td>
				</tr>

				</table>
				<!-- : ( Week ) (E) -->

			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->



		<table class="height_10"><tr><td></td></tr></table>


		<!-- TABLE '#D' : ( Tab ) (S) Coincidence / Discrepancy / Cost Calc.(TMNL) / Cost Calc.(SR by FD) / Cost Calc.(SR by FP) / -->

		<!-- TABLE '#D' : ( Tab ) (E) -->

		<!-- TABLE '#D' : ( Tab BG Box ) (S) -->
     	<table class="search" border="0">
       	<tr><td class="bg">




			<table class="height_10"><tr><td></td></tr></table>


					<table width="100%" id="mainTable">
					<tr>
						<td>
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
						<td aling="right">
							<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
								<tr>
									<td class="btn1_bg">
										<table border="0" cellpadding="0" cellspacing="0">
											<tr>
												<!-- Repeat Pattern -->
												<td>
													<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
														<tr>
															<td class="btn2_left"></td><td class="btn2" name="btn_NewVersion" id="btn_NewVersion">New Version</td>
															<td class="btn2_right"></td>
														</tr>
													</table>
												</td>
											</tr>
											<td height="10"></td>
											<tr>
												<td>
													<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
														<tr>
															<td class="btn2_left"></td><td class="btn2" name="btn_Revise" id="btn_Revise">Revise</td>
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
					</table>
					<table width="100%" id="mainTable1">
					<tr>
						<td>
							<script language="javascript">ComSheetObject('sheet2');</script>
						</td>
					</tr>
					</table>
					
					<table width="100%" id="mainTable1">
					<tr>
						<td>							
							<div style="display: none"> 
							<script language="javascript">ComSheetObject('sheet3');</script>
							</div>					
						</td>
					</tr>
					</table>										
										
			<!-- : ( Grid : Week ) (S) -->
			<!-- 'HEAD1-BGCOLOR : 203 240 169' , 'HEAD2-BGCOLOR : 222 251 248' , 'BORDER 1-outside : 88 152 164' ,
				 'BORDER 2-inside : 202 226 233' , 'HEAD-FONT : 39 95 101' , 'SELETED ROW BG : 252 255 233' -->

			<!-- : ( Grid : Week ) (E) -->

			<!-- : ( Button : Sub ) (S) -->
				<table width="100%" class="button">
						<tr><td class="btn2_bg">
							<table border="0" cellpadding="0" cellspacing="0">
								<tr>

								<!-- Repeat Pattern -->
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2" name="btn_DownExcel" id="btn_DownExcel">Down Excel</td>
								<td class="btn2_right"></td></tr></table></td>
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2" name="btn_UploadExcel" id="btn_UploadExcel">Upload Excel</td>
								<td class="btn2_right"></td></tr></table></td>
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2" name="btn_RowAdd" id="btn_RowAdd">Row Add</td>
								<td class="btn2_right"></td></tr></table></td>
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2" name=btn_RowDelete id="btn_RowDelete">Row Delete</td>
								<td class="btn2_right"></td></tr></table></td>
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2" name="btn_Save" id="btn_Save">Save</td>
								<td class="btn2_right"></td></tr></table></td>
								<!-- Repeat Pattern -->

								</tr>
							</table>
						</td></tr>
					</table>
	    	<!-- : ( Button : Sub ) (E) -->


			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Tab BG Box ) (E) -->

    </td></tr>
</table>
<!-- Outer Table (E)-->

</form>
</body>
</html>
