<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_mst_0014.jsp
*@FileTitle : Leased Container
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.07
*@LastModifier : 이호선
*@LastVersion : 1.0
* 2009.07.07 이호선
* 1.0 Creation
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.event.EesMst0014Event"%>
<%@ page import="org.apache.log4j.Logger" %>


<%
	EesMst0014Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.EquipmentManagement.ContainerOnOffHire");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EesMst0014Event)request.getAttribute("Event");
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
<title>::</title>
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
<input type="hidden" name="hidden_curdate">
<input type="hidden" name="hid_old_new">
<input type="hidden" name="hid_tp_sz">
<input type="hidden" name="hid_app_vol">
<input type="hidden" name="hid_pick_vol">
<input type="hidden" name="hid_pick_date">
<input type="hidden" name="hid_min_onh_dys">
<input type="hidden" name="hid_pkup_chg_cr_amt">
<input type="hidden" name="hid_pkup_chg_amt">
<input type="hidden" name="hid_lift_on_chrg">
<input type="hidden" name="hid_free_dys">
<input type="hidden" name="hid_cntr_spec_no">
<input type="hidden" name="approval_no_h">

<!-- 개발자 작업	-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
	<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
	<!--Page Title, Historical (E)-->
	<table class="search"> 
       		<tr><td class="bg">
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="90">Creation Type</td>
					<td width="150"><select style="width:118;" class="input1" name="ctype">
						<option value="0" selected>General</option>
						<option value="1">W/O Check Digit</option>
						<option value="2">Serial Range</option>
						</select></td>
					<td width="80">On-hire Date</td>
					<td width="110"><input type="text" style="width:75" dataformat="ymd" class="input1" value="" name="hire_date" style="text-align:center">&nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="cal_img" style="cursor:hand" onClick="func_calendar('calendarPopup1')"></td>
					<td width="80">On-hire Yard</td>
					<td><input type="text" style="width:75" class="input1" value="" dataformat="engup" name="sts_evnt_yd_cd" maxlength="7" style="ime-mode:disabled;text-align:center">&nbsp;<img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="ComOpenPopupWithTargetYard">&nbsp;<input type="text" style="width:225" class="input2" ReadOnly value="" name="yd_cd_nm" style="ime-mode:disabled"></td>
				</tr> 
				</table>
				
				<table class="height_2"><tr><td></td></tr></table>
				
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="60">AGMT No.</td>
					<td width="180">&nbsp;<input type="text" style="width:35" class="input1" dataformat="engup" name="agmt_cty_cd" maxlength="3" value="HHO">&nbsp;<input type="text" style="width:84" class="input1" dataformat="engup" name="agmt_seq" style="ime-mode:disabled;text-align:center" maxlength="6">&nbsp;<img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="ComOpenPopupWithTargetAgmtNo"></td>
					<td width="80">Lease Term</td>
					<td width="110"><input type="text" style="width:47" class="input2" dataformat="engup" value="" ReadOnly name="lstm_cd" maxlength="2" style="text-align:CENTER"></td>
					<td width="80">Contract No.</td>
					<td width="180"><input type="text" style="width:152" class="input2" dataformat="engup" value="" ReadOnly name="ref_no" maxlength="12" style="text-align:LEFT"></td>
					<td width="50"></td>
					<td align=""></td>
		
				</tr> 
				<tr class="h23">
					<td width="">Lessor</td>
					<td colspan="7">&nbsp;<input type="text" style="width:60" class="input2"  value="" name="vndr_seq" dataformat="engup" ReadOnly maxlength="6" caption="Lessor">&nbsp;<!--<img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="ComOpenPopupWithTargetLessor">--><input type="text" style="width:241" class="input2" value="" name="vndr_nm" readonly caption="Lessor" style="text-align:LEFT"></td>
					
				</tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="60">Auth No.</td>
					<td width="180">&nbsp;<script language="javascript">ComComboObject('approval_no', 16, 145, 1);</script></td>
					<td width="80">Auth Vol.</td>
					<td width="110"><input type="text" style="width:47" class="input2" dataformat="engup" value="" ReadOnly name="approval_vol" style="text-align:RIGHT"></td>
					<td width="80">Pick up Vol.</td>
					<td width="80"><input type="text" style="width:45" class="input2" dataformat="engup" value="" ReadOnly name="pick_up_vol" style="text-align:RIGHT"></td>
					<td width="135">Pick up Due Date</td>
					<td><input type="text" style="width:110" class="input2" dataformat="engup" value="" ReadOnly name="pick_up_due_date" style="text-align:CENTER"></td>
					<!--
					<td>Pick up Due Date</td>
					<td colspan="5"><input type="text" style="width:100" class="input2" dataformat="engup" value="" ReadOnly name="pick_up_due_date" style="text-align:CENTER"></td>
					-->
				</tr> 
				</table>
				
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="120">CNTR Serial Range</td>
					<td colspan="10"><input type="text" style="width:40" class="input2" dataformat="engup" maxlength="4" name="cntr_no0"> <input type="text" style="width:65" class="input2" dataformat="engup" maxlength="6" name="cntr_no1">&nbsp;<input type="text" style="width:65" class="input2" dataformat="engup" maxlength = "6" name="cntr_no2">&nbsp;<input type="text" style="width:65" class="input2" ReadOnly name="cntr_no3"></td>
				</tr> 
				</table>
			<!-- : ( Search Options ) (E) -->
			</td></tr>
		</table>
	<!--biz page (E)-->
	<table class="height_8"><tr><td></td></tr></table>
		
		<table class="search"> 
       		<tr><td class="bg" style="height:370;" valign="top">

           <div id="tabLayer" style="display:inline">	
        			<!-- Grid  (S) -->
        			<table width="100%"  id="mainTable"> 
        				<tr>
        					<td width="100%">
        						<script language="javascript">ComSheetObject('sheet1');</script>
							    <div style="display: none;"><script language="javascript">ComSheetObject('sheet2');</script></div>       						
							    <!--<script language="javascript">ComSheetObject('sheet2');</script>--> 							    
													
								<!--  Button_Sub (S) -->
								<table width="100%" class="button"> 
						       	<tr><td class="btn2_bg">
									<table border="0" cellpadding="0" cellspacing="0">
											<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr><td class="btn2_left"></td>
											<td class="btn2" name="btn_master">&nbsp;&nbsp;&nbsp;Master&nbsp;&nbsp;&nbsp;</td>
											<td class="btn2_right"></td>
											</tr>
											</table></td>									
											<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr><td class="btn2_left"></td>
											<td class="btn2" name="btn_add">Row Add</td>
											<td class="btn2_right"></td>
											</tr>
											</table></td>									
											<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr><td class="btn2_left"></td>
											<td class="btn2" name="btn_loadexcel">Load Excel</td>
											<td class="btn2_right"></td>
											</tr>
											</table></td>
											<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr><td class="btn2_left"></td>
											<td class="btn2" name="btn_delete">Delete</td>
											<td class="btn2_right"></td>
											</tr>
											</table></td>
											
									</table>
								</td></tr>
								</table>
						    	<!-- Button_Sub (E) -->
			
        					</td>
        				</tr>
        			</table>
        			<!-- Grid (E) -->		
           </div>			

    			<!--  biz_2 (S) -->
			
			</TD></tr>
		</table>
		
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;padding-bottom:0;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_new">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
		</td></tr>
		</table>
    <!--Button (E) -->
	</td></tr>
</table>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>
