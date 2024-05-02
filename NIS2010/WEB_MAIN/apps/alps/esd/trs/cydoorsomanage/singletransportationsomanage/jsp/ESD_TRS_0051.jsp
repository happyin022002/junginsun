<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_0051.jsp
*@FileTitle : CY & Door
*Open Issues :
*Change history :
*@LastModifyDate : 2011.06.27
*@LastModifier : 최 선
*@LastVersion : 1.3
* 2006.10.27 조풍연
* 1.0 최초 생성 
*----------------------------------------------------------
* History
* 2010.10.08 최 선     1.1 [CHM-201006411] S/O DOOR NODE 팝업창의 RETURN VALUE 오류 수정
* 2011.04.13 김영철 1.2 [CHM-201109654-01] Container Select 부분을 공통으로 사용으로 인하여 conti_cd 추가함.
* 2011.06.27 최 선     1.3 [CHM-201111857] [TRS] S/O Inquiry  화면에서의 조회조건 오류 수정 + Correction 화면에서의 S/P name 조회오류 수정요청
* 2012.01.09 김보배 [CHM-201215479] [TRS] Dup. S/O 사전 보완기능 요청
=========================================================*/
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.trs.cydoorsomanage.singletransportationsomanage.event.EsdTrs0002Event"%>
<%
	SignOnUserAccount account = null; //Session 정보
	EsdTrs0002Event  event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null; //서버에서 발생한 에러
	DBRowSet rowSet	  = null; //DB ResultSet
	String strErrMsg = ""; //에러메세지
	int rowCount	 = 0; //DB ResultSet 리스트의 건수

	String selBOUND = ""; //Bound
	String selCOSTMODE = ""; //Cost Mode
	String selTRANSMODE = ""; //Transportation Mode
	String optionStr = "000020:ALL:ALL";

//	String today = DateTime.getFormatString("yyyyMMdd");
//	String beforeOneMonth = DateTime.addDays(today, -14);
	String strCnt_cd = ""; //Country code
	String strUser_id = ""; //User ID checks Auth

	try {
		account = (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strCnt_cd = account.getCnt_cd(); //20121031
		strUser_id = account.getUsr_id(); //20121031
		selBOUND  = JSPUtil.getCodeCombo("sel_bound", "01", "style='width:70'", "CD00591", 0, optionStr);
		selCOSTMODE  = JSPUtil.getCodeCombo("sel_costmode", "01", "style='width:140'", "CD00594", 0, optionStr);
		selTRANSMODE  = JSPUtil.getCodeCombo("sel_transmode", "01", "style='width:70'", "CD00283", 0, optionStr);

		event = (EsdTrs0002Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<script language="javascript">
	<%=JSPUtil.getIBCodeCombo("trsp_crr_mod_cd", "01", "CD00283", 0, "")%>
	<%=JSPUtil.getIBCodeCombo("dor_svc_tp_cd", "01", "CD00284", 0, "")%>
</script>
<html>
<head>
<title>Service Order Creation</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		v_cnt_cd = "<%=strCnt_cd%>";
		v_user_id = "<%=strUser_id%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		//InitTab();
		loadPage();
	}
</script>
</head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input	type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="hid_frmdate" value="">
<input type="hidden" name="hid_todate" value="">
<input type="hidden" name="hid_bkg" value="">
<input type="hidden" name="cbstatus" value="">
<input type="hidden" name="FORM_CRE_USR_ID" value="<%=account.getUsr_id()%>">
<input type="hidden" name="FORM_USR_OFC_CD" value="<%=account.getOfc_cd()%>">


<input type="hidden" name="FM_LOC_CONTI_CD"		value="">
<input type="hidden" name="BOUND_CD" 			value="">
<input type="hidden" name="CNEE_CUST_CNT_CD" 	value="">
<input type="hidden" name="CNEE_CUST_SEQ" 		value="">
<input type="hidden" name="SHPR_CUST_CNT_CD" 	value="">
<input type="hidden" name="SHPR_CUST_SEQ" 		value="">
<input type="hidden" name="DOOR_NOD_CD" 		value="">
<input type="hidden" name="TRSP_SO_EQ_KIND" 	value="">

<input type="hidden" name="conti_cd"  value="">
<input type="hidden" name="msg_flag" 			value="N">
<input type="hidden" name="pop_flag" 			value="N">

<input type="hidden" name="dist_div_cd" 		value="G"> <!-- Grid OnChange Event : G, Multi Apply팝업화면에서 Apply일때는 "F"  )-->
<input type="hidden" name="pgmId" value="ESD_TRS_0051">
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
						<tr><td class="btn1_left"></td><td class="btn1" id="btn_retrieve" name="btn_retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" id="btn_new" name="btn_new">New</td><td class="btn1_right"></td></tr></table></td>

					<td class="btn1_line"></td>

					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" id="btn_minimize" name="btn_minimize">Minimize</td><td class="btn1_right"></td></tr></table></td>
					<!-- Repeat Pattern -->

				</tr></table>

			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Button : Main ) (E) -->


        <div id="MiniLayer" style="display:inline">

		<!-- TABLE '#D' : ( Header Information ) (S) -->
		<table class="search">
			<tr>
				<td class="bg">

					<table class="search_in" border="0">
						<tr class="h23">
							<td width="120">Work Order Issued</td>
							<td width="167">
								<table border="0" style="height:15; width:100; background-color: #E9E9E9;">
								<tr><td style="padding-left:10" class="sm"><input type="radio" name="rad_wo_issued" class="trans" value="NO" onClick="fun_wosoChange('NO')" checked>No&nbsp;<input type="radio" name="rad_wo_issued" value="YES" class="trans" onClick="fun_wosoChange('YES')">Yes</td></tr>
								</table>
							</td>
							<td width="100">Service Provider</td>
							<td align="right">
								<input name="combo_svc_provider" type="text" style="width:85;" value="" maxlength="6" onChange='getTextVendorSeq(sheetObjects[0], document.form, this.value)' onKeyup='enterCheck(this)'>
								<input type="text" name="svc_provider" style="width:474;" class="input2" value="" readonly><img src="/hanjin/img/blank.gif" width="4" height="2"><img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btns_vender"></td>
						</tr>
					</table>
					<table height="2"><tr><td></td></tr></table>
					<table class="search_in" border="0">
						<tr class="h23">
							<td width="120">Date</td>
							<td>
								<table border="0" style="height:15; width:720; background-color: #E9E9E9;">
									<tr><td class="sm" style="padding-left:10" width="520">
											<input type="radio" name="rad_dateSep" class="trans" value="P" checked onClick="javascript:fun_datesep('P');">Planned Departure&nbsp;
											<input type="radio" name="rad_dateSep" value="D" class="trans" onClick="javascript:fun_datesep('D');">Door Arrival&nbsp;
											<input type="radio" name="rad_dateSep" value="S" class="trans" onClick="javascript:fun_datesep('S');">Service Order Created&nbsp;
											<input type="radio" name="rad_dateSep" value="W" class="trans" disabled onClick="javascript:fun_datesep('W');">Work Order Issue
											<input type="radio" name="rad_dateSep" value="B" class="trans" onClick="javascript:fun_datesep('B');">Due Date
										</td>
										<td><input name="frm_plandate" type="text" style="width:70;" value="" maxlength="8" onFocus="javascript:delHypen(this);" onBlur="javascript:getHypen(this); getDateBetween(this);">&nbsp;~&nbsp;<input name="to_plandate" type="text" style="width:70;" value="" maxlength="8"  onFocus="javascript:delHypen(this);" onBlur="javascript:getHypen(this);" onKeyup="javascript:doSearchEnter();">
											<img class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar"></td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
					<table height="2"><tr><td></td></tr></table>
					<table class="search_in" border="0">
						<tr class="h23">
							<td width="118">Bound</td>
							<td width="160"><%=selBOUND%></td>
							<td width="77">Cost Mode</td>
							<td width="164"><%=selCOSTMODE%></td>
							<td width="81">Trans Mode</td>
							<td width="125"><%=selTRANSMODE%></td>
							<td width="40">Bid.</td>
							<td width="75">
								<SELECT name = "spot_bid_flg" >	
								   <OPTION  value="">ALL</OPTION>
		                           <OPTION  value="Y">Y</OPTION>
		                           <OPTION  value="N">N</OPTION>
	                             </SELECT>
	                        </td>
	                        <td width="125"></td>
						</tr>
					</table>

					<table class="search_in" border="0">
						<tr class="h23">
							<td width="118">From</td>
							<td width="76"><input name="search_fm_loc" type="text" style="width:70;" maxlength="5" onChange="getComboList(this, document.form.search_fm_yard, 'F');" onBlur="setgetUpper(this);"></td>
							<td width="91"><script language="javascript">ComComboObject('search_fm_yard', 1, 43, 0)</script><img src="/hanjin/img/blank.gif" width="4" height="2"><img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btns_frmnode"></td>
							<td width="75">Via</td>
							<td width="79"><input name="search_via_loc" type="text" style="width:73;" maxlength="5" onChange="getComboList(this, document.form.search_via_yard, 'V');" onBlur="setgetUpper(this);"></td>
							<td width="86"><script language="javascript">ComComboObject('search_via_yard', 1, 40, 0)</script><img src="/hanjin/img/blank.gif" width="4" height="2"><img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btns_vianode"></td>
							<td width="29">To</td>
							<td width="83"><input name="search_to_loc" type="text" style="width:77;" maxlength="5" onChange="getComboList(this, document.form.search_to_yard, 'T');" onBlur="setgetUpper(this);"></td>
							<td width="96"><script language="javascript">ComComboObject('search_to_yard', 1, 40, 0)</script><img src="/hanjin/img/blank.gif" width="4" height="2"><img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btns_tonode"></td>
							<td width="40">Door</td>
							<td width="63"><input name="search_door_loc" type="text" style="width:57;" maxlength="5" onChange="getComboList(this, document.form.search_door_yard, 'D');" onBlur="setgetUpper(this);"></td>
							<td width="66"><script language="javascript">ComComboObject('search_door_yard', 1, 40, 0)</script><img src="/hanjin/img/blank.gif" width="4" height="2"><img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btns_dorloc"></td>
							<td align="right"><input name="zip_code" type="text" style="width:52;" onChange="" onBlur=""><img src="/hanjin/img/blank.gif" width="4" height="1" border="0"><img class="cursor" src="/hanjin/img/button/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle" name="btns_multizipcode"></td>
						</tr>
					</table>

					<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>

					<table class="search_in" border="0">
						<tr class="h23">
							<td width="118">T.VVD</td>
							<td width="142"><input name="trunk_vvd" type="text" style="width:71;" value="" onKeyup="javascript:doSearchEnter();" onBlur="setgetUpper(this);">
								<img class="cursor" src="/hanjin/img/button/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle" name="btns_multivvd"> <img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btns_tvvd"></td>
							<td width="100">Booking No.</td>
							<td width="135"><input name="bkg_no" type="text" style="width:92;" onKeyup="javascript:doSearchEnter();" onBlur="setgetUpper(this);">
								<img class="cursor" src="/hanjin/img/button/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle" name="btns_multibkg"></td>

							<td width="110">Bill Of Lading No.</td>
							<td width="154"><input name="bill_no" type="text" style="width:94;" onKeyup="javascript:doSearchEnter();" onBlur="setgetUpper(this);">
								<img class="cursor" src="/hanjin/img/button/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle" name="btns_multibl"></td>
							<td width="90">Container No.</td>
							<td align="right">
								<input name="cntr_no" type="text" style="width:105;" onKeyup="javascript:doSearchEnter();" onChange="javascript:this.value=multiCntrChkDgt(this.value);" onBlur="setgetUpper(this);">
								<img class="cursor" src="/hanjin/img/button/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle" name="btns_multicntr"></td>
						</tr>
					</table>

					<table class="search_in" border="0">
						<tr class="h23">
							<td width="118">Service Order No.</td>
							<td width="142">
								<input name="so_no" type="text" style="width:94;" value="" onKeyup="javascript:doSearchEnter();" onBlur="setgetUpper(this);">
								<img class="cursor" src="/hanjin/img/button/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle" name="btns_multisono">
							</td>
							<td width="100">Work Order No.</td>
							<td width="135">
								<input name="wo_no" type="text" style="width:92;" onKeyup="javascript:doSearchEnter();" disabled class="input2" onBlur="setgetUpper(this);">
								<img class="cursor" src="/hanjin/img/button/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle" name="btns_multiwono">
							</td>
							<td width="45">Bid No.</td>
							<td>
								<input name="spot_bid_no" type="text" style="width:160;" value="" onKeyup="javascript:doSearchEnter();" onBlur="setgetUpper(this);" maxlength=15>
							</td>
						</tr>
					</table>
				</td></tr>
		</table>
		<!-- TABLE '#D' : ( Header Information ) (E) -->
		</div>

		<table class="height_10"><tr><td></td></tr></table>

		<!-- TABLE '#D' : ( Tab ) (S) -->
		 	<table class="tab">
			<tr><td><script language="javascript">ComTabObject('tab1')</script>
				<!--tr>
				<td><img src="/hanjin/img/sub_tab.gif" alt="" width="755" height="23" border="0"-->
			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Tab ) (E) -->

        <div id="tabLayer" style="display:inline">
		<!-- TABLE '#D' : ( Tab BG Box ) (S) -->
		<table class="search" border="0">
			<tr>
				<td class="bg">


					<table width="100%" id="mainTable">
            		      <tr><td>
            		          <script language="javascript">ComSheetObject('t1sheet1');</script>
            		      </td></tr>
            		</table>
					<!-- TABLE '#D' : ( Grid ) (E) -->


					<!-- : ( Button_ Sub ) (S) -->
					<span id="id_woissue" style="display:inline">
					<table width="100%" class="button">
				       	<tr><td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
						<tr>

							<!-- Repeat Pattern -->
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_offhireverify" name="btng_offhireverify">Off Hire Verify</td><td class="btn2_right"></td></tr></table></td>
							
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_sodelete" name="btng_sodelete">S/O Delete</td><td class="btn2_right"></td></tr></table></td>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_containerselect" name="btng_containerselect">Container Select</td><td class="btn2_right"></td></tr></table></td>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_multipleapply" name="btng_multipleapply">Multiple Apply</td><td class="btn2_right"></td></tr></table></td>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_downexcel1" name="btng_downexcel1">Down Excel</td><td class="btn2_right"></td></tr></table></td>
							<!-- Repeat Pattern -->

						</tr></table>
					</td></tr>
					</table>

					<table width="100%" class="button">
				       	<tr><td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
						<tr>

							<!-- Repeat Pattern -->
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_separate0" name="btng_separate0">Separate</td><td class="btn2_right"></td></tr></table></td>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_matchmaking1" name="btng_matchmaking1">Matchmaking for Combined Case 1</td><td class="btn2_right"></td></tr></table></td>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_matchmaking2" name="btng_matchmaking2">Matchmaking for Combined Case 2</td><td class="btn2_right"></td></tr></table></td>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_socreation1" name="btng_socreation1">S/O Correction</td><td class="btn2_right"></td></tr></table></td>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_woissue1" name="btng_woissue1">W/O Issue</td><td class="btn2_right"></td></tr></table></td>
							<!-- Repeat Pattern -->

						</tr></table>
					</td></tr>
					</table>
					</span>


					<span id="id_woissueno" style="display:none">
					<table width="100%" class="button">
				       	<tr><td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
						<tr>

							<!-- Repeat Pattern -->
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_containerselect" name="btng_containerselect">Container Select</td><td class="btn2_right"></td></tr></table></td>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_downexcel1" name="btng_downexcel1">Down Excel</td><td class="btn2_right"></td></tr></table></td>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_socreation1" name="btng_socreation1">S/O Correction</td><td class="btn2_right"></td></tr></table></td>
							<!-- Repeat Pattern -->

						</tr></table>
					</td></tr>
					</table>
					</span>
					<!-- : ( Button_ Sub ) (E) -->

				</td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Tab BG Box ) (E) -->
		<!-- ####### TABLE '#D' ::: 'RIGHT' FRAME (END) ####### -->
        </div>


        <div id="tabLayer" style="display:none">
		<!-- TABLE '#D' : ( Tab BG Box ) (S) -->
		<table class="search" border="0">
			<tr>
				<td class="bg">

					<table width="100%" id="mainTable">
            		      <tr><td>
            		          <script language="javascript">ComSheetObject('t2sheet1');</script>
            		      </td></tr>
            		</table>
					<!-- TABLE '#D' : ( Grid ) (E) -->


					<!-- : ( Button_ Sub ) (S) -->
					<table width="100%" class="button">
				       	<tr><td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
						<tr>

							<!-- Repeat Pattern -->
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_downexcel2" name="btng_downexcel2">Down Excel</td><td class="btn2_right"></td></tr></table></td>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_separate1" name="btng_separate1">Separate</td><td class="btn2_right"></td></tr></table></td>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_socreation2" name="btng_socreation2">S/O Correction</td><td class="btn2_right"></td></tr></table></td>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_woissue2" name="btng_woissue2">W/O Issue</td><td class="btn2_right"></td></tr></table></td>
							<!-- Repeat Pattern -->

						</tr></table>
					</td></tr>
					</table>
					<!-- : ( Button_ Sub ) (E) --></td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Tab BG Box ) (E) -->
		<!-- ####### TABLE '#D' ::: 'RIGHT' FRAME (END) ####### -->
        </div>
        <div id="tabLayer" style="display:none">
		<!-- TABLE '#D' : ( Tab BG Box ) (S) -->
		<table class="search" border="0">
			<tr>
				<td class="bg">

					<!-- TABLE '#D' : ( Grid ) (S) -->

					<table width="100%" id="mainTable">
            		      <tr><td>
            		          <script language="javascript">ComSheetObject('t3sheet1');</script>
            		      </td></tr>
            		</table>
					<!-- TABLE '#D' : ( Grid ) (E) -->
					<!-- : ( Button_ Sub ) (S) -->
					<table width="100%" class="button">
				       	<tr><td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
						<tr>

							<!-- Repeat Pattern -->
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_downexcel3" name="btng_downexcel3">Down Excel</td><td class="btn2_right"></td></tr></table></td>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_separate2" name="btng_separate2">Separate</td><td class="btn2_right"></td></tr></table></td>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_socreation3" name="btng_socreation3">S/O Correction</td><td class="btn2_right"></td></tr></table></td>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_woissue3" name="btng_woissue3">W/O Issue</td><td class="btn2_right"></td></tr></table></td>
							<!-- Repeat Pattern -->

						</tr></table>
					</td></tr>
					</table>
					<!-- : ( Button_ Sub ) (E) --></td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Tab BG Box ) (E) -->
		<!-- ####### TABLE '#D' ::: 'RIGHT' FRAME (END) ####### -->
        </div>


<script language="javascript">ComSheetObject('sheet2');</script><!--W/O Issue-->

<script language="javascript">ComSheetObject('t4sheet1');</script>

<script language="javascript">ComSheetObject('rtnsheet');</script>

</td></tr>
</table>
<!-- Outer Table (E)-->

</form>


<form name='woForm' method='POST'>
	<input type='hidden' name='trsp_so_ofc_cty_cd'>
	<input type='hidden' name='trsp_so_seq'>
	<input type='hidden' name='eq_mode'>
	<input	type="hidden" name="sysCommUiTitle" value="Issue">
	<input	type="hidden" name="sysCommUiNavigation" value="Trans S/O > Work Order">
	<input type="hidden" name="pgmNo" value="">
</form>
</body>
</html>