<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_0005.jsp
*@FileTitle : Asia CY & DOOR S/O Creation
*Change history :
*@LastModifyDate : 2006.09.25
*@LastModifier : 최 선
*@LastVersion : 1.1
* 2006.09.25 조풍연
* 1.0 최초 생성
*----------------------------------------------------------
* History
* 2010.10.08 최 선     1.1 [CHM-201006411] S/O DOOR NODE 팝업창의 RETURN VALUE 오류 수정
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
	
    String s_cop_no = request.getParameter("s_cop_no")==null?"":request.getParameter("s_cop_no");
    String s_cost_act_grp_seq = request.getParameter("s_cost_act_grp_seq")==null?"":request.getParameter("s_cost_act_grp_seq");
    String s_so_ofc_cd = request.getParameter("s_so_ofc_cd")==null?"":request.getParameter("s_so_ofc_cd");
    String s_so_tp_cd = request.getParameter("s_so_tp_cd")==null?"":request.getParameter("s_so_tp_cd");
    if (s_so_tp_cd.equals("C")) {
    	s_so_tp_cd = "CY";
	}else if (s_so_tp_cd.equals("Z")) {
		s_so_tp_cd = "DR";
	}

//	String today = DateTime.getFormatString("yyyyMMdd");
//	String beforeOneMonth = DateTime.addDays(today, -14);

	try {
		account = (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		selBOUND  = JSPUtil.getCodeCombo("sel_bound", "01", "style='width:60'", "CD00591", 0, optionStr);
		selCOSTMODE  = JSPUtil.getCodeCombo("sel_costmode", "01", "style='width:130'", "CD00594", 0, optionStr);
		selTRANSMODE  = JSPUtil.getCodeCombo("sel_transmode", "01", "style='width:48'", "CD00283", 0, optionStr);

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
	
	var s_cop_no = '<%=s_cop_no.toString()%>';
	var s_cost_act_grp_seq = '<%=s_cost_act_grp_seq.toString()%>';
	var s_so_ofc_cd = '<%=s_so_ofc_cd.toString()%>';
	var s_so_tp_cd = '<%=s_so_tp_cd.toString()%>';
</script>
<html>
<head>
<title>Service Order Creation</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
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
<input type="hidden" name="f_cmd"						>
<input type="hidden" name="iPage"						>
<input type="hidden" name="hid_frmdate" 		value="">
<input type="hidden" name="hid_todate" 			value="">
<input type="hidden" name="cbstatus" 			value="">
<input type="hidden" name="old_ofc_cd" 			value="<%=account.getOfc_cd()%>">
<input type="hidden" name="FORM_CRE_USR_ID"		value="<%=account.getUsr_id()%>">
<input type="hidden" name="FORM_USR_OFC_CD"		value="<%=account.getOfc_cd()%>">

<input type="hidden" name="FM_LOC_CONTI_CD"		value="">
<input type="hidden" name="BOUND_CD" 			value="">
<input type="hidden" name="CNEE_CUST_CNT_CD" 	value="">
<input type="hidden" name="CNEE_CUST_SEQ" 		value="">
<input type="hidden" name="SHPR_CUST_CNT_CD" 	value="">
<input type="hidden" name="SHPR_CUST_SEQ" 		value="">
<input type="hidden" name="DOOR_NOD_CD" 		value="">
<input type="hidden" name="TRSP_SO_EQ_KIND" 	value="">
<input type="hidden" name="prnt_ofc_cd" 		value="">
<input type="hidden" name="msg_flag" 			value="N">
<input type="hidden" name="pop_flag" 			value="N">
<input type="hidden" name="dist_div_cd" 		value="G"> <!-- Grid OnChange Event : G, Multi Apply팝업화면에서 Apply일때는 "F"  )-->
<input type="hidden" name="pgmId" value="ESD_TRS_0005">

<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>

		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		<tr><td class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->


		<!-- TABLE '#D' : ( Button : Main ) (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
	       	<tr><td class="btn1_bg">

				<table border="0" cellpadding="0" cellspacing="0">
				<tr>
					<!-- Repeat Pattern -->
					<input name="ui_conti_cd" type="hidden" value="A">
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
							<td width="80">Date</td>
							<td width="644">
								<table border="0" style="height:25; width:520;background-color: #E9E9E9;">
								<tr><td width="300" class="sm" style="padding-left:10;"><input type="radio" name="rad_dateSep" class="trans" value="P" checked>Planned Departure&nbsp;<input type="radio" name="rad_dateSep" value="D" class="trans">Door Arrival&nbsp;<input type="radio" name="rad_dateSep" value="R" class="trans">Rail Creation</td>
									<td class="sm">
										<input name="frm_plandate" type="text" class="input1" style="width:75;" value="" maxlength="8" onFocus="javascript:delHypen(this);" onBlur="javascript:getHypen(this); getDateBetween(this);">&nbsp;~&nbsp;<input name="to_plandate" type="text" class="input1" style="width:75;" value="" maxlength="8" onFocus="javascript:delHypen(this);" onBlur="javascript:getHypen(this);" onKeyup="javascript:doSearchEnter();">
										<img class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar"></td>
								</tr>
								</table>
							</td>
						    <td width=153>CY/Door</td>
						    <td width="163">
                            <SELECT name = "cydoor_div" style='width:60' onChange="getCostModeCombo(document.sel_costmode);" ><OPTION  value="CY">CY</OPTION><OPTION  value="DR">DOOR</OPTION></SELECT>
                            </td>
							<td>
								<input type="checkbox" name="unplan_shuttle" value="" class="trans" onClick="javascript:fun_chekcbox('01');">&nbsp;Unplanned&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<!--input type="checkbox" name="incl_usa_rail" value="" class="trans" onClick="javascript:fun_chekcbox('02');" disabled--><!--USA Rail Only&nbsp; 20070619 d¿��僻-->
								<input type="checkbox" name="tro_unconfirm_dr" value="" class="trans" onClick="javascript:fun_chekcbox('03');">&nbsp;Provision
							</td>
						</tr>
					</table>


					<table class="search_in" border="0">
				    <tr class="h23">
					<td width="80">Bound</td>
					<td width="147"><%=selBOUND%></td>
					<td width="76">Cost Mode</td>
					<!-- td width="163"><%=selCOSTMODE%></td-->
					<td width="163"><script language="javascript">ComComboObject('sel_costmode', 1, 130, 1)</script></td>
					<td width="83">Trans Mode</td>
					<td width="92"><%=selTRANSMODE%></td>
					<td width="129">Service Order Office </td>
					<td class="sm"><input name="ctrl_so_office" type="text" style="width:79;" value="<%=account.getOfc_cd()%>" onChange="javascript:fun_officeText();"><img src="/hanjin/img/blank.gif" width="4" height="1" border="0"><img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btns_office">&nbsp;<input type="checkbox" name="chk_office" value="Y" class="trans" onClick="javascript:fun_chkOffice();">Incl. Sub OFC</td>
					</tr>
					</table>


					<table class="search_in" border="0">
						<tr class="h23">
						<td width="80">From </td>
						<td width="64"><input name="search_fm_loc" type="text" style="width:60;" maxlength="5" onChange="getComboList(this, document.form.search_fm_yard, 'F');" onBlur="setgetUpper(this);"></td>
						<td width="85"><script language="javascript">ComComboObject('search_fm_yard', 1, 45, 0)</script><img src="/hanjin/img/blank.gif" width="4" height="1" border="0"><img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btns_frmnode"></td>

						<td width="72">Via </td>
						<td width="64"><input name="search_via_loc" type="text" style="width:60;" maxlength="5" onChange="getComboList(this, document.form.search_via_yard, 'V');" onBlur="setgetUpper(this);"></td>
						<td width="100"><script language="javascript">ComComboObject('search_via_yard', 1, 45, 0);</script><img src="/hanjin/img/blank.gif" width="4" height="1" border="0"><img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btns_vianode"></td>

						<td width="20">To </td>
						<td width="64"><input name="search_to_loc" type="text" style="width:60;" maxlength="5" onChange="getComboList(this, document.form.search_to_yard, 'T');" onBlur="setgetUpper(this);"></td>
						<td width="92"><script language="javascript">ComComboObject('search_to_yard', 1, 48, 0);</script><img src="/hanjin/img/blank.gif" width="4" height="1" border="0"><img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btns_tonode"></td>

						<td width="45">Door </td>
						<td width="84"><input name="search_door_loc" type="text" style="width:80;" maxlength="5" onChange="getComboList(this, document.form.search_door_yard, 'D');" onBlur="setgetUpper(this);"></td>
						<td width="70"><script language="javascript">ComComboObject('search_door_yard', 1, 45, 0)</script><img src="/hanjin/img/blank.gif" width="4" height="1" border="0"><img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btns_dorloc"></td>
						<td align="right"><input name="zip_code" type="text" style="width:107;" onChange="" onBlur=""><img src="/hanjin/img/blank.gif" width="4" height="1" border="0"><img class="cursor" src="/hanjin/img/button/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle" name="btns_multizipcode"></td>
						</tr>
					</table>


					<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>

					<table class="search_in" border="0">
						<tr class="h23">
							<td width="80">T.VVD</td>
							<td width="148"><input name="trunk_vvd" type="text" style="width:84;" value="" onKeyup="javascript:doSearchEnter();" onBlur="setgetUpper(this);"><img src="/hanjin/img/blank.gif" width="4" height="1" border="0"><img class="cursor" src="/hanjin/img/button/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle" name="btns_multivvd"><img src="/hanjin/img/blank.gif" width="4" height="1" border="0"><img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btns_tvvd"></td>
							<td width="55">F.VVD</td>
							<td>
								<table border="0" style="height:20; width:364; background-color: #E9E9E9;">
								<tr><td class="sm" width="233" style="padding-left:10;"><input type="radio" name="feeder_vvd" class="trans" value="A" checked>&nbsp;All&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="feeder_vvd" class="trans" value="I">&nbsp;In VVD&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="feeder_vvd" class="trans" value="O">&nbsp;Out VVD&nbsp;&nbsp;&nbsp;&nbsp;</td>
									<td><input name="txt_feeder_vvd" type="text" style="width:70;" value="" onKeyup="javascript:doSearchEnter();" onBlur="setgetUpper(this);"><img src="/hanjin/img/blank.gif" width="4" height="1" border="0"><img class="cursor" src="/hanjin/img/button/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle" name="btns_multifvvd"><img src="/hanjin/img/blank.gif" width="4" height="1" border="0"><img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btns_fvvd"></td>
								</tr>
								</table>
							</td>
						</tr>
					</table>

					<table class="search_in" border="0">
						<tr class="h23">
							<td width="80">Booking No.</td>
							<td width="148"><input name="bkg_no" type="text" value="" style="width:107;" onKeyup="javascript:doSearchEnter();" onBlur="setgetUpper(this);"><img src="/hanjin/img/blank.gif" width="4" height="1" border="0"><img class="cursor" src="/hanjin/img/button/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle" name="btns_multibkg"></td>
							<td width="55">B/L No. </td>
							<td width="153"><input name="bill_no" type="text" style="width:94;" onKeyup="javascript:doSearchEnter();" onBlur="setgetUpper(this);"><img src="/hanjin/img/blank.gif" width="4" height="1" border="0"><img class="cursor" src="/hanjin/img/button/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle" name="btns_multibl"></td>
							<td width="90">Container No.</td>
							<td width="138"><input name="cntr_no" type="text" style="width:93;" onKeyup="javascript:doSearchEnter();" onChange="javascript:this.value=multiCntrChkDgt(this.value);" onBlur="setgetUpper(this);"><img src="/hanjin/img/blank.gif" width="4" height="1" border="0"><img class="cursor" src="/hanjin/img/button/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle" name="btns_multicntr"></td>
							<td width="82">Contract No.<td>
							<td>
								<table border="0" style="height:25; width:100%;background-color: #E9E9E9;">
									<tr><td class="sm">&nbsp;&nbsp;<input type="radio" name="contract_tp_cd" class="trans" value="S" checked>&nbsp;S/C&nbsp;<input type="radio" name="contract_tp_cd" class="trans" value="R">&nbsp;RFA&nbsp;</td>
										<td align="right"><input name="contract_no" type="text" style="width:107;" onKeyup="javascript:doSearchEnter();" onBlur="setgetUpper(this);"><img src="/hanjin/img/blank.gif" width="4" height="1" border="0"><img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btns_contract"></td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Header Information ) (E) -->
	    </div>


		<table class="height_10"><tr><td></td></tr></table>

		<!-- TABLE '#D' : ( Tab ) (S) -->
     	<table class="tab">
       	<tr><td><script language="javascript">ComTabObject('tab1' )</script></td></tr>
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
					<table width="100%" class="button">
				       	<tr><td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<!-- Repeat Pattern -->
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_candidatedelete" name="btng_candidatedelete">Candidate Delete</td><td class="btn2_right"></td></tr></table></td>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_officetransfer" name="btng_officetransfer">Office Transfer</td><td class="btn2_right"></td></tr></table></td>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_multipleapply" name="btng_multipleapply">Multiple Apply</td><td class="btn2_right"></td></tr></table></td>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_downexcel1" name="btng_downexcel1">Down Excel</td><td class="btn2_right"></td></tr></table></td>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_matchmaking1" name="btng_matchmaking1">Matchmaking for Combined Case 1</td><td class="btn2_right"></td></tr></table></td>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_matchmaking2" name="btng_matchmaking2">Matchmaking for Combined Case 2</td><td class="btn2_right"></td></tr></table></td>
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
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_offhireverify" name="btng_offhireverify">Off Hire Verify</td><td class="btn2_right"></td></tr></table></td>

							
					<!--  	<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_candidatedelete" name="btng_candidatedelete">Candidate Delete</td><td class="btn2_right"></td></tr></table></td>
                    -->	
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_socreation1" name="btng_socreation1">S/O Creation</td><td class="btn2_right"></td></tr></table></td>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_woissue1" name="btng_woissue1">W/O Issue</td><td class="btn2_right"></td></tr></table></td>
							<!-- Repeat Pattern -->


						</tr></table>
					</td></tr>
					</table>
					<!-- : ( Button_ Sub ) (E) --></td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Tab BG Box ) (E) -->
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
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_separate1" name="btng_separate1">Separate</td><td class="btn2_right"></td></tr></table></td>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_downexcel2" name="btng_downexcel2">Down Excel</td><td class="btn2_right"></td></tr></table></td>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_socreation2" name="btng_socreation2">S/O Creation</td><td class="btn2_right"></td></tr></table></td>

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
	   </div>

       <div id="tabLayer" style="display:none">
		<!-- TABLE '#D' : ( Tab BG Box ) (S) -->
		<table class="search" border="0">
			<tr>
				<td class="bg">

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
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_separate2" name="btng_separate2">Separate</td><td class="btn2_right"></td></tr></table></td>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_downexcel3" name="btng_downexcel3">Down Excel</td><td class="btn2_right"></td></tr></table></td>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_socreation3" name="btng_socreation3">S/O Creation</td><td class="btn2_right"></td></tr></table></td>

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

<form name='soForm' method='POST'>
	<input type='hidden' name='f_cmd'>
    <input type="hidden" name="old_ofc_cd" 			value="<%=account.getOfc_cd()%>">
    <input type="hidden" name="FORM_CRE_USR_ID"		value="<%=account.getUsr_id()%>">
    <input type="hidden" name="FORM_USR_OFC_CD"		value="<%=account.getOfc_cd()%>">
    <input type="hidden" name="sel_bound" value="ALL">
    <input type="hidden" name="sel_transmode" value="ALL">

    <input type="hidden" name="pgmId" value="ESD_TRS_0005">	
    <input type="hidden" name="ui_conti_cd" value="A">
	<input type='hidden' name='s_cop_no' value="<%=s_cop_no%>">
	<input type='hidden' name='s_cost_act_grp_seq' value="<%=s_cost_act_grp_seq%>">
    <input type='hidden' name='ctrl_so_office' value="<%=s_so_ofc_cd%>">
    <input type="hidden" name="prnt_ofc_cd" value="<%=s_so_ofc_cd%>">
    <input type="hidden" name="old_ofc_cd" value="<%=s_so_ofc_cd%>">
    <input type="hidden" name="cydoor_div" value="<%=s_so_tp_cd%>">
</form>

</body>
</html>