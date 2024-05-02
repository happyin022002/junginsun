<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.eas.transportmanage.event.EsdEas0007Event"%>

<%
	SignOnUserAccount account = null; //Session 
	EsdEas0007Event  event = null; //
	Exception serverException   = null; //error from server
	String strErrMsg = ""; //error message

	try {
		account = (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		event = (EsdEas0007Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	}catch(Exception e) {
		out.println(e.toString());
	}
	String loc_cd 		= JSPUtil.getNull(request.getParameter("s_loc_cd"));
	String cust_info 	= JSPUtil.getNull(request.getParameter("s_cust_info"));
	String cntr_tp_cd 	= JSPUtil.getNull(request.getParameter("s_cntr_tp_cd"));
	String curr_cd 		= JSPUtil.getNull(request.getParameter("s_curr_cd"));
	String conti_cd 	= JSPUtil.getNull(request.getParameter("s_conti_cd"));
%>

<html>
<head>
<title>Drop Off Charge Tariff List</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">

	var loc_cd 		= "<%=loc_cd%>";
	var cust_info 	= "<%=cust_info%>";
	var cntr_tp_cd 	= "<%=cntr_tp_cd%>";
	var curr_cd 	= "<%=curr_cd%>";
	var conti_cd 	= "<%=conti_cd%>";

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
<input type='hidden' name='s_cntr_tp_cd' value='<%=cntr_tp_cd%>'>
<input type='hidden' name='s_loc_cd' value='<%=loc_cd%>'>
<input type='hidden' name='s_curr_cd' value='<%=curr_cd%>'>
<input type='hidden' name='s_cust_info' value='<%=cust_info%>'>

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
										<tr><td class="btn1_left"></td><td class="btn1" name="btn_new" id="btn_save">New</td><td class="btn1_right"></td></tr></table></td>

									<td class="btn1_line"></td>

									<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn1_left"></td><td class="btn1" name="bttn_save" id="bttn_save">Save</td><td class="btn1_right"></td></tr></table></td>
									<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn1_left"></td><td class="btn1" name="btn_downexcel" id="btn_downexcel">Down Excel</td><td class="btn1_right"></td></tr></table></td>
									<!-- Repeat Pattern -->

								</tr></table>

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
						<input type="radio"  name="search_choice" value="recntcd" class="trans" onClick="selectWhere();" >&nbsp;Region/Country</td>
						<td width="350">
						<input type="text" name="sel_cnt_cd" style="width:25;ime-mode:disabled;" onKeyUp="fun_CntEffData(); chkField(this, 'eng', true, 13);"  onClick="selectText(this);" maxlength="2">
						<input name="sel_cnt_nm" type="text" style="width:197" value=""  onClick="selectText(this);">
						<img class="cursor" src="/opuscntr/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="cnt_btn">
						</td>
						<td width="110"><%//<img class="nostar">%>Effective Date</td>
						<td width="">
							<DIV id="ScriptDiv" >
							<select style="width:100;" name='s_type' disabled>&nbsp;
							<option value="null" selected></option>
							</select>
							</DIV>
						</td>
					</tr>

				<tr class="h23">
					<td width=""><input type="radio"  name="search_choice" value="custcd" class="trans" onClick="selectWhere();">&nbsp;Customer</td>
					<td width=""><input name="cust_cnt_seq" type="text" style="width:75 ; text-transform:uppercase;" onKeyUp="chkField(this, 'eng_num', true); fun_CustEffData()"  onClick="selectText(this);" value="">
						<input name="cust_nm" type="text" style="width:147" value="" onClick="selectText(this);">
						<img class="cursor" src="/opuscntr/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"  name='btn_customer' >
					</td>
					<td width=""><%//<img class="nostar">%>New Eff.Date</td>
					<td width=""><input type="text" style="width:100" value="" name="newEffDate" maxlength="8" onBlur="addBar();"></td>
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
								<tr><td class="btn2_left"></td><td class="btn2" name="bttn_addloc" id="bttn_addloc">Add Loc</td>
								<td class="btn2_right"></td></tr></table></td>
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2" name="bttn_addts" id="bttn_addts">Add T/C</td>
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
