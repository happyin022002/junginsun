<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_0019.jsp
*@FileTitle : SO Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.22
*@LastModifier : 최 선
*@LastVersion : 1.3
* 2006.11.10 조풍연
* 1.0 최초 생성
*----------------------------------------------------------
* History
* 2010.09.30 이재위   1.1 [CHM-201006169] [TRS] 특수문자를 포함한 INV No. 조회 가능토록 
* 2010.10.08 최 선     1.2 [CHM-201006411] S/O DOOR NODE 팝업창의 RETURN VALUE 오류 수정
* 2010.11.22 최 선     1.3 [CHM-201007296] S/P 입력 후 조회시 오류 수정
* 2011.01.03 이윤정   1.4 [CHM-201007768] DMDT 관련 컬럼 추가
* 2011.06.28 손은주 [CHM-201111573-01]	[TRS] S/O history function 추가 요청
* 2015.06.23 9014787 [CHM-201535923] W/O Inquiry 개선2
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.trs.soinquiry.soinquiry.event.EsdTrs0019Event"%>

<%
	EsdTrs0019Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	DBRowSet rowSet	  = null;							   //DB ResultSet
	String strErrMsg = "";								 //에러메세지
	int rowCount	 = 0;								  //DB ResultSet 리스트의 건수
	String today = DateTime.getFormatString("yyyyMMdd");
	String userId  = "";
	String selCOSTMODE = ""; //Cost Mode
	String selTRANSMODE = ""; //Transportation Mode
	String selBOUND = ""; //RHQ Mode
	String selSOMODE = ""; //SO Mode
	String selWOMODE = ""; //WO Mode
	String selINVOICEMODE = ""; //INVOICE Mode
	String selCARGOMODE = ""; //CARGO Mode
	String selSOTYPE = ""; //CARGO Mode
	String optionStr = "000020:ALL:ALL";
	String selAMOUNT = "";

	String eq_ctrl ="";
	String eq_ctrl_1 ="";

	//selBOUND  = JSPUtil.getCodeCombo("sel_boundmode", "01"		," onChange='bound_OnChange_1(this);'","CD00591", 0, optionStr);
	//selCOSTMODE  = JSPUtil.getCodeCombo("sel_costmode", "01"	," onChange='bound_OnChange_2(this);'", "CD00958", 0, optionStr);

	selBOUND  = JSPUtil.getCodeCombo("sel_boundmode", "01"		," onChange='bound_OnChange_1(this);' style='width:101;'", "CD00591", 0, optionStr);
	selCOSTMODE  = JSPUtil.getCodeCombo("sel_costmode", "01"	," onChange='bound_OnChange_2(this);' style='width:150;'", "CD00958", 0, optionStr);
	selTRANSMODE  = JSPUtil.getCodeCombo("sel_transmode", "01"	," onChange='bound_OnChange_3(this);' style='width:91;'", "CD00283", 0, optionStr);
	selSOMODE  = JSPUtil.getCodeCombo("sel_somode", "01"	," onChange='bound_OnChange_4(this);', style='width:101'", "CD00826", 0, optionStr);
	selWOMODE  = JSPUtil.getCodeCombo("sel_womode", "01"	," onChange='bound_OnChange_5(this);', style='width:150'", "CD00827", 0, optionStr);
	selINVOICEMODE  = JSPUtil.getCodeCombo("sel_invoicemode", "01"	," onChange='bound_OnChange_6(this);'", "CD01249", 0, optionStr);
	selCARGOMODE  = JSPUtil.getCodeCombo("sel_cargomode", "01"	," onChange='bound_OnChange_7(this);'", "CD00748", 0, optionStr);
	selSOTYPE  = JSPUtil.getCodeCombo("sel_sotype", "01"	," onChange='bound_OnChange_8(this);', style='width:130'", "CD03543", 0, optionStr);
	selAMOUNT = JSPUtil.getCodeCombo("sel_amount", "01", "  onChange='bound_OnChange_9(this);'   ", "CD00927", 0, optionStr);

	String sowonumber = request.getParameter("sowonumber")== null ? "" : request.getParameter("sowonumber");

	String opener		= request.getParameter("opener")==null?"":request.getParameter("opener");
	String invar_sofmdt = request.getParameter("invar_sofmdt")==null?"":request.getParameter("invar_sofmdt");
	String invar_sotodt = request.getParameter("invar_sotodt")==null?"":request.getParameter("invar_sotodt");
	String invar_ofc    = request.getParameter("invar_ofc")==null?"":request.getParameter("invar_ofc");
	String invar_bnd    = request.getParameter("invar_bnd")==null?"":request.getParameter("invar_bnd");
	String invar_term   = request.getParameter("invar_term")==null?"":request.getParameter("invar_term");
	String invar_onlycy   = request.getParameter("invar_onlycy")==null?"":request.getParameter("invar_onlycy");
	String invar_trosts = request.getParameter("invar_trosts")==null?"":request.getParameter("invar_trosts");
	String invar_colhd  = request.getParameter("invar_colhd")==null?"":request.getParameter("invar_colhd");
	String invar_sotype  = request.getParameter("invar_sotype")==null?"":request.getParameter("invar_sotype");
	String invar_from_node  = request.getParameter("invar_from_node")==null?"":request.getParameter("invar_from_node");
	String invar_to_node  = request.getParameter("invar_to_node")==null?"":request.getParameter("invar_to_node");

	String s_so_ofc_cd = request.getParameter("s_so_ofc_cd")==null?"":request.getParameter("s_so_ofc_cd");
	String s_rail_cd = request.getParameter("s_rail_cd")==null?"":request.getParameter("s_rail_cd");
	String s_eq_no = request.getParameter("s_eq_no")==null?"":request.getParameter("s_eq_no");
	try {

	   SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);

	   userId=account.getUsr_id();
	   eq_ctrl=account.getOfc_cd();
	   eq_ctrl_1=eq_ctrl.substring(0, 3);

	   event = (EsdTrs0019Event)request.getAttribute("Event");

		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		} // end else
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>SO Inquiry</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	function setupPage(){
		var formObject = document.form;
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();

//		getVendorComboList();
//		initVendorCombo(document.combo_svc_provider);

		if ( "<%=sowonumber%>" != "")
		{
			document.form.input_office.value="";
			retriveSo();
		}else{
		    document.form.input_office.value="<%=eq_ctrl%>"; 
		}

		formObject.eqnumber.value= "<%=s_eq_no%>";
		
        //Delivery Monitoring에서 오픈시
		if ( "<%=s_so_ofc_cd%>" != "") {
// 			var formObject = document.form;
// 			formObject.input_office.value="";

			if ( "<%=s_rail_cd%>" == "R") {
				formObject.chk_usrail.checked = true;
				usrailOnly(formObject.chk_usrail);
			}else{
				formObject.chk_usrail.checked = false;
				formObject.input_office.value= "<%=s_so_ofc_cd%>";
			}
// 			usrailOnly(formObject.chk_usrail);
			retriveSo();
		}
        
		/* CH REPORT 에서 팝업 오픈시..*/
		if ( "<%=opener%>" == "chreport")
		{
			openAspopup();
		}
	}
</script>
</head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<!-- <iframe height="0" width="0" name="frmHidden" id="frmHidden"></iframe>
-->

<form method="post" name="form" onSubmit="return false;">


<input type="hidden" name="opener" value = "<%=opener%>">

<input type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="cre_ofc_cd" value="<%=eq_ctrl%>">
<input type="hidden" name="cre_ofc_cd_1" value="<%=eq_ctrl_1%>">
<input type="hidden" name="FORM_CRE_USR_ID" value="<%=userId%>">
<input type="hidden" name="FORM_USR_OFC_CD" value="<%=eq_ctrl%>">
<input type="hidden" name="cre_dt_val" value="<%=today%>">
<input type="hidden" name="upd_usr_id" value="<%=userId%>">
<input type="hidden" name="upd_dt" value="<%=today%>">

<input type="hidden" name="hid_boundmode">
<input type="hidden" name="hid_costmode">
<input type="hidden" name="hid_transmode">
<input type="hidden" name="hid_sotype">
<input type="hidden" name="hid_usrail" value = "N">
<input type="hidden" name="hid_dom_usrail" value = "N">
<input type="hidden" name="hid_usdropnpull" value = "N">

<input type="hidden" name="hid_somode">
<input type="hidden" name="hid_womode">
<input type="hidden" name="hid_invoicemode">
<input type="hidden" name="hid_cargomode">


<input type="hidden" name="hid_wrkofc">   <!-- 20071206lyt 추가.  ch report 팝업호출요건.  -->
<input type="hidden" name="hid_bkgterm">   <!-- 20071206lyt 추가.  ch report 팝업호출요건.  -->
<input type="hidden" name="hid_onlycy">   <!-- 20071206lyt 추가.  ch report 팝업호출요건.  -->
<input type="hidden" name="hid_trosts">    <!-- 20071206lyt 추가.  ch report 팝업호출요건.  -->
<input type="hidden" name="hid_tpsz">    <!-- 20071206lyt 추가.  ch report 팝업호출요건.  -->



<input type="hidden" name="hid_period" value="S">
<input type="hidden" name="hid_radio_office" value="S">
<input type="hidden" name="hid_radio_user" value="S">
<input type="hidden" name="hid_radio_number" value="S">
<input type="hidden" name="hid_radio_eq" value="CNTR">
<input type="hidden" name="hid_from_node">
<input type="hidden" name="hid_via_node">
<input type="hidden" name="hid_to_node">
<input type="hidden" name="hid_door_node">

<input type="hidden" name="hid_from_date">
<input type="hidden" name="hid_to_date">

<input type="hidden" name="hid_provider">
<input type="hidden" name="hid_provider_type">


<input type="hidden" name="chk_from_node">
<input type="hidden" name="chk_via_node">
<input type="hidden" name="chk_to_node">
<input type="hidden" name="chk_door_node">
<input type="hidden" name="hid_unplanned">
<input type="hidden" name="hid_cnt_flg">

<input type="hidden" name="hid_amount" value ="ALL">
<input type="hidden" name="old_ofc_cd" value="<%=eq_ctrl%>">

<input type="hidden" name="hid_grid_flg">

<input type="hidden" name="invar_sofmdt" value = "<%=invar_sofmdt%>" >
<input type="hidden" name="invar_sotodt" value = "<%=invar_sotodt%>" >
<input type="hidden" name="invar_ofc" value = "<%=invar_ofc%>" >
<input type="hidden" name="invar_bnd" value = "<%=invar_bnd%>" >
<input type="hidden" name="invar_term" value = "<%=invar_term%>" >
<input type="hidden" name="invar_onlycy" value = "<%=invar_onlycy%>" >
<input type="hidden" name="invar_trosts" value = "<%=invar_trosts%>" >
<input type="hidden" name="invar_colhd" value = "<%=invar_colhd%>" >
<input type="hidden" name="invar_sotype" value = "<%=invar_sotype%>" >
<input type="hidden" name="invar_from_node" value = "<%=invar_from_node%>" >
<input type="hidden" name="invar_to_node" value = "<%=invar_to_node%>" >

<input type="hidden" name="hid_prepull" value="">
<input type="hidden" name="TRSP_SO_EQ_KIND" value="">

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

<% if (opener.trim().equals("chreport") ) { %>
		<div id="ButtLayer1" style="display:none">
<% } else { %>
		<div id="ButtLayer1" style="display:inline">
<% } %>


			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
		       	<tr><td class="btn1_bg">

					<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<!-- Repeat Pattern -->
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td><td class="btn1" id="btn_retrieve" name="btn_retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>

						<td class="btn1_line"></td>

						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td><td class="btn1" id="btng_rtv_downxls" name="btng_rtv_downxls">Down Excel</td><td class="btn1_right"></td></tr></table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td><td class="btn1" id="btn_reset" name="btn_reset">Reset</td><td class="btn1_right"></td></tr></table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td><td class="btn1" id="btn_minimize" name="btn_minimize">Minimize</td><td class="btn1_right"></td></tr></table></td>
						<!-- Repeat Pattern -->

					</tr></table>

				</td></tr>
			</table>
		<!-- TABLE '#D' : ( Button : Main ) (E) -->
		</div>




<% if (opener.trim().equals("chreport") ) { %>
		<div id="MiniLayer" style="display:none">
<% } else { %>
		<div id="MiniLayer" style="display:inline">
<% } %>

		<!-- TABLE '#D' : ( Search Options ) (S) -->
		<table class="search">
			<tr>
				<td class="bg">
					<table class="search_in" border="0">
						<tr class="h23">
							<td width="118">Date</td>
<!--
										<td><input name="radio_period" type="radio" class="trans" checked  Onclick="change_period();" >
											S/O Cre.&nbsp;&nbsp;
											<input name="radio_period"  type="radio" class="trans"  Onclick="change_period();" >
											W/O Iss.&nbsp;&nbsp;
											<input name="radio_period"  type="radio" class="trans"  Onclick="change_period();" >
											Inv Cfm. &nbsp;
											<input name="radio_period"  type="radio" class="trans"  Onclick="change_period();" >
											Dep.&nbsp;&nbsp;
											<input name="radio_period"  type="radio" class="trans"  Onclick="change_period();" >
											Arr.&nbsp;&nbsp;
											<input name="radio_period"  type="radio" class="trans"  Onclick="change_period();" >
											Door.&nbsp;&nbsp;
											</td>
-->
										<td width="134">
											<SELECT style = "width:130" name = "sel_period"  onChange='change_period();;'>
											<OPTION  value="S"> S/O Creation</OPTION>
											<OPTION  value="W"> W/O Issue</OPTION>
											<OPTION  value="I"> Invoice Confirm</OPTION>
											<OPTION  value="O"> From Departure</OPTION>
											<OPTION  value="L"> To Arrival</OPTION>
											<OPTION  value="D"> Door Arrival</OPTION>

											<OPTION  value="B"> Due date</OPTION>

											</SELECT>
										</td>
										<td width="257" class="sm">
											<input name="from_date" type="text" style="width:75;"  value=""  onFocus='fun_Focus_del(this)'  onBlur='BlurDate(this);addBar_from(this);' >&nbsp;~&nbsp;<input name="to_date" type="text" style="width:75;"  value=""     onFocus='fun_Focus_del(this)'  onBlur='BlurDate(this);addBar_to(this);'  >
											<img class="cursor" img src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle"  name="btns_calendar">
										</td>

										<td><input type="checkbox" name="chk_usrail" value="N" class="trans" onClick="usrailOnly(this);"> USA Rail Only</td>
										<td><input type="checkbox" name="chk_dom_rail" value="N" class="trans" onClick="usDomRailOnly(this);"> Domestic Rail Only</td>
										<td><input type="checkbox" name="chk_usdropnpull" value="Y" class="trans" onClick="usdropnpullOnly(this);"> US Drop & Pull</td>
										<td><input type="checkbox" name="chk_prepull" value="" class="trans" onClick="usPrePull(this);"> US pre-pull</td>



						</tr>
					</table>
					<table height="2"><tr><td></td></tr></table>

					<table class="search_in" border="0">
						<tr class="h23">
							<td width="120">Office Code</td>
							<td width="415">
								<table border="0" style="height:25; width:82%;background-color: #E9E9E9;">
                                	<tr>
                                		<td width="132" class="sm" align="center">
                                			<input name="radio_office"  type="radio" class="trans" checked Onclick="change_office();" >Issue&nbsp;&nbsp;
											<input name="radio_office"  type="radio" class="trans"  Onclick="change_office();" >Invoice</td>
										<td class="sm">
											<input name="input_office" type="text" style="width:75;" onBlur="setgetUpper(this);">
											<img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btns_office">
											&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="chk_office" value="Y" class="trans" onClick="javascript:fun_chkOffice();">Incl. Sub OFC</td>

									</tr>
                                </table></td>


							<td width="75">User Name </td>
							<td>
								<table border="0" style="height:25; width:100%;background-color: #E9E9E9;">
                                	<tr>
                                		<td width="130" class="sm" align="center">
                                			<input name="radio_user" type="radio" class="trans" checked  Onclick="change_user();" >Issue&nbsp;&nbsp;
											<input name="radio_user" type="radio" class="trans" Onclick="change_user();" >Invoice</td>
										<td><input name="user_id" type="text" style="width:30%;" readonly class="input2">
											<input name="user_nm" type="text" style="width:57%;" maxlength="120" onChange="searchUserId(sheetObjects[2]);">
											<img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btns_user_nm"></td>
                                		</tr>
                               	</table></td>

						</tr>
					</table>
					<table height="2"><tr><td></td></tr></table>
					<table class="search_in" border="0">
						<tr class="h23">
							<td width="118">Service Order Type</td>
							<td width="185"><%=selSOTYPE%></td>
							<td width="90">Service Order</td>
							<td width="140"><%=selSOMODE%></td>
							<td width="75">Work Order</td>
							<td width="175"><%=selWOMODE%></td>
							<td width="40">Invoice</td>
							<td align="right"><%=selINVOICEMODE%></td>
						</tr>
					</table>


					<table class="search_in" border="0">
						<tr class="h23">
							<td width="118">Unplanned</td>
							<td width="151">
							  <SELECT name = "sel_unplanned"   onChange='bound_OnChange_10(this);' >	
							    <OPTION  value="ALL"> ALL</OPTION>
	                            <OPTION  value="Y"> Y</OPTION>
	                            <OPTION  value="N"> N</OPTION>
                              </SELECT>
                            </td>
							<td width="100">Bound</td>
							<td width="171"><%=selBOUND%></td>
							<td width="90">Cost Mode</td>
							<td width="194"><%=selCOSTMODE%></td>
							<td width="100">Trans Mode</td>
							<td width="194" align="right"><%=selTRANSMODE%></td>
							<td width="75" align="right">CNT&nbsp;</td>
						    <td width="">
                            	<SELECT name="cnt_flg" style="width:40;" onChange='cnt_flg_OnChange(this);'>
	                            	<OPTION  value=""></OPTION>
                            		<OPTION  value="Y">Y</OPTION>
                            		<OPTION  value="N">N</OPTION>
                            	</SELECT>
                            </td>
						</tr>
					</table>

					<table class="search_in" border="0">
						<tr class="h23">
							<td width="58">From</td>
							<td width="62"><input name="search_fm_loc" type="text" style="width:56;" maxlength="5" onChange="getComboList(this, document.form.search_fm_yard, 'F');" onBlur=""  ></td>
							<td width="91"><script language="javascript">ComComboObject('search_fm_yard', 1, 48, 0)</script><img src="/hanjin/img/blank.gif" width="2" hight="1"><img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btns_frmnode"></td>

							<td width="22">Via</td>
							<td width="56"><input name="search_via_loc" type="text" style="width:50;" maxlength="5" onChange="getComboList(this, document.form.search_via_yard, 'V');" onBlur=""></td>
							<td width="84"><script language="javascript">ComComboObject('search_via_yard', 1, 45, 0)</script><img src="/hanjin/img/blank.gif" width="2" hight="1"><img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"  name="btns_vianode"></td>

							<td width="20">To</td>
							<td width="58"><input name="search_to_loc" type="text" style="width:52;" maxlength="5" onChange="getComboList(this, document.form.search_to_yard, 'T');"  onBlur=""></td>
							<td width="83"><script language="javascript">ComComboObject('search_to_yard', 1, 45, 0)</script><img src="/hanjin/img/blank.gif" width="2" hight="1"><img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"  name="btns_tonode"></td>

							<td width="74">Door</td>
							<td width="56"><input name="search_door_loc" type="text" style="width:50;" maxlength="5" onChange="getComboList(this, document.form.search_door_yard, 'D');"  onBlur=""></td>
							<td width="139"><script language="javascript">ComComboObject('search_door_yard', 1, 45, 0)</script><img src="/hanjin/img/blank.gif" width="2" hight="1"><img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"  name="btns_dorloc"></td>

							<td width="71">Zip Code</td>
							<td align="right"><input name="zip_code"  type="text" style="width:70;"  onBlur="val_check(this,'ZIPCD');">
											<img class="cursor" img src="/hanjin/img/button/btns_multisearch.gif" width="17" height="19" border="0" align="absmiddle"  onClick="so_OnPopupClick('ZIP Code');"></td>
						</tr>

					</table>

					<table height="2"><tr><td></td></tr></table>
					<table class="search_in" border="0">
						<tr class="h23">
							<td width="120">Service Provider</td>

							<td width="597">

								<table border="0" style="height:25; width:95%;background-color: #E9E9E9;">
								<tr>
									  <td width="25%" class="sm">
									  		<input type="radio" class="trans" name='sp_tp' value='WO' checked>Work Order&nbsp;&nbsp;
											<input type="radio" class="trans" name='sp_tp' value='PA'  >Parent&nbsp;&nbsp;
											<input type="radio" class="trans" name='sp_tp' value='IV'  >Invoice &nbsp;&nbsp;

										<input name="combo_svc_provider" type="text"  style="width:57;" maxlength="6" onChange='getTextVendorSeq(sheetObjects[0], document.form, this.value)' onKeyup='enterCheck(this)'>
										<input name="svc_provider" type="text" style="width:265;" value="" readonly  class="input2"  title="This inputbox cant't write"> <img class="cursor" img src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name='btng_provider'></td>
								</tr>
								</table>
							</td>

							<td width="48">Amount</td>
							<td align="right"><%=selAMOUNT%></td>
							<td></td>
						</tr>
					</table>
					<table height="2"><tr><td></td></tr></table>


					<table class="search_in" border="0">
						<tr class="h23">
							<td width="58">T.VVD</td>
							<td width="195"><input  name="trunk_vvd"  type="text" style="width:85;" onBlur="setgetUpper(this);vvd_check(this)" maxlength="10">
								<img class="cursor" src="/hanjin/img/button/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle"  onClick="so_OnPopupClick('T.VVD');">
								<img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"  onClick="vvd_OnPopupClick();"></td>
							<td width="80">Booking No.</td>
							<td width="167">
								<input name="bkgnumber"  type="text" style="width:112;" onBlur="setgetUpper(this);val_check(this,'BKG NUMBER');">
								<img class="cursor" img src="/hanjin/img/button/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle"  onClick="so_OnPopupClick('Booking No.');"></td>
							<td width="108">Bill Of Lading No.</td>
							<td width="181"><input name="blnumber"  type="text" style="width:100;" onBlur="setgetUpper(this);val_check(this,'BL NUMBER');">
								<img class="cursor" img src="/hanjin/img/button/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle"  onClick="so_OnPopupClick('B/L No.');"></td>
							<td width="49">COP No.</td>
							<td align="right"><input name="copnumber"  type="text" style="width:110;" onBlur="setgetUpper(this);val_check(this,'COP NUMBER');">
								<img class="cursor" img src="/hanjin/img/button/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle"  onClick="so_OnPopupClick('COP No.');"></td>

						</tr>
					</table>

					<table height="2"><tr><td></td></tr></table>
					<table class="search_in" border="0">
						<tr class="h23">
							<td style="width: 80px; ">Contract No.</td>
							<td class="stm" border =0 style="width: 250px; ">
								<table border="0" style="height:15; width:250px;background-color: #E9E9E9;">
                                	<tr>
                                		<td class="sm" style="width: 250px; ">
                                			<input name="radio_number" type="radio" class="trans" checked  Onclick="change_number();" >S/C&nbsp;&nbsp;
						    				<input name="radio_number" type="radio" class="trans" Onclick="change_number();" >RFA &nbsp;&nbsp;&nbsp;
						    				<input name="sc_rfa_cd" type="text" style="width:115;"  value="" maxlength="20" onBlur="setgetUpper(this);number_check(this);" >
						    				<img class="cursor" img src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" onClick="fn_popup();";>
										</td>
                                	</tr>
                               	</table>
                            </td>
							<td style="width: 25px; ">Bid.</td>
							<td style="width: 60px; ">
								<SELECT name = "spot_bid_flg" >	
							    <OPTION  value=""> ALL</OPTION>
	                            <OPTION  value="Y"> Y</OPTION>
	                            <OPTION  value="N"> N</OPTION>
                              </SELECT>
                            </td>
							<td style="width: 45px;">Bid No.</td>
							<td style="width: 90px;">
								<input name="spot_bid_no" type="text" style="width:80;" value="" onBlur="setgetUpper(this);" maxlength=15>
							</td>
							<td style="width: 90px;">Equipment No.</td>
							<td>
								<table border="0" style="height:15; background-color: #E9E9E9;">
                                	<tr>
                                		<td class="sm" align="center" style="width: 210px; ">
                                				<input name="radio_eq"  type="radio" class="trans" checked  Onclick="change_eqno();" >Container&nbsp;
											  	<input name="radio_eq"  type="radio" class="trans" Onclick="change_eqno();" >Chassis&nbsp;
											  	<input name="radio_eq"  type="radio" class="trans" Onclick="change_eqno();" >Genset&nbsp;
										</td>
										<td align="right"  style="width: 130px;">
											<input name="eqnumber"  type="text" onBlur="javascript:this.value=this.value.toUpperCase(); " onChange="checkDigit(this)"  style="width:100px;">
	                            			<img class="cursor" img src="/hanjin/img/button/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle"  onClick="so_OnPopupClick('EQ No.');"></td>
                                		</tr>
                               	</table>
                            </td>
                          </tr>
					</table>
					<table height="2"><tr><td></td></tr></table>

					<table class="search_in" border="0">
						<tr class="h23">
							<td width="118">Service Order No.</td>
							<td width="140"><input name="sonumber" type="text" style="width:101;" value="<%=sowonumber %>" onChange="setgetUpper(this);" onBlur="val_check(this,'SO NUMBER');" > <img class="cursor" img src="/hanjin/img/button/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle"  onClick="so_OnPopupClick('SO No.');"></td>
							<td width="95">Work Order No.</td>
							<td width="147"><input name="wonumber" type="text" style="width:92;" onChange="setgetUpper(this);"  onBlur="val_check(this,'WO NUMBER');" > <img class="cursor" img src="/hanjin/img/button/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle"  onClick="so_OnPopupClick('WO No.');"></td>
							<td width="94">Invoice No.</td>
							<td width="131"><input name="invoicenumber" type="text" style="width:90;"> <img class="cursor" img src="/hanjin/img/button/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle"  onClick="so_OnPopupClick('Invoice No.');"></td>
 							<td width="115">MTY Reference No.</td>
							<td align="right"><input name="mtyrefnumber" type="text" style="width:110;" onBlur="val_check(this,'MTY Ref No.');"> <img class="cursor" img src="/hanjin/img/button/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle"  onClick="so_OnPopupClick('MTY REF No.');"></td>
						</tr>
					</table>

				</td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->
		</div>

		<table class="height_10"><tr><td></td></tr></table>



<% if (opener.trim().equals("chreport") ) { %>
					<!-- : ( Button_ Sub ) (S) -->
					<table width="100%" class="button">
				       	<tr><td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
						<tr>

							<!-- Repeat Pattern -->
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_rtv_downxls" name="btng_rtv_downxls">Down Excel</td><td class="btn2_right"></td></tr></table></td>
							<!-- Repeat Pattern -->


						</tr></table>
					</td></tr>
					</table>
					<!-- : ( Button_ Sub ) (E) -->
<% }  %>




		<!-- TABLE '#D' : ( Gird BG Box ) (S) -->
		<table class="search" border="0">
			<tr>
				<td class="bg">

					<table class="height_10"><tr><td></td></tr></table>

					<!-- 'HEAD1-BGCOLOR : 203 240 169' , 'HEAD2-BGCOLOR : 222 251 248' , 'BORDER 1-outside : 88 152 164' ,'BORDER 2-inside : 202 226 233' , 'HEAD-FONT : 39 95 101' , 'SELETED ROW BG : 252 255 233' -->
					<table width="100%" id="mainTable">
            		      <tr><td>
            		          <script language="javascript">ComSheetObject('sheet1');</script>
            		      </td></tr>
            		      <tr><td>
            		          <script language="javascript">ComSheetObject('sheet2');</script>
            		      </td></tr>
            		      <tr><td>
            		          <script language="javascript">ComSheetObject('sheet3');</script>
            		      </td></tr>
            		</table>
					<!-- : ( Grid ) (E) -->


<% if (opener.trim().equals("chreport") ) { %>
					<!-- : ( Button_ Sub ) (S) -->
					<table width="100%" class="button">
				       	<tr><td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
						<tr>

							<!-- Repeat Pattern -->
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_popup_downexcel" name="btng_popup_downexcel">Down Excel</td><td class="btn2_right"></td></tr></table></td>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btn_close" name="btn_close">Close</td><td class="btn2_right"></td></tr></table></td>
							<!-- Repeat Pattern -->


						</tr></table>
					</td></tr>
					</table>
					<!-- : ( Button_ Sub ) (E) -->
<% }  %>


<% if (opener.trim().equals("chreport") ) { %>
		<div id="ButtLayer2" style="display:none">
<% } else { %>
		<div id="ButtLayer2" style="display:inline">
<% } %>

					<!-- : ( Button_ Sub ) (S) -->
					<table width="100%" class="button">
				       	<tr><td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
						<tr>

							<!-- Repeat Pattern -->
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_downexcel" name="btng_downexcel">Down Excel</td><td class="btn2_right"></td></tr></table></td>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_frustrate" name="btng_frustrate">Frustrate</td><td class="btn2_right"></td></tr></table></td>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_sohistory" name="btng_sohistory">S/O History</td><td class="btn2_right"></td></tr></table></td>
							
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_woissuehistory" name="btng_woissuehistory">W/O Issue History</td><td class="btn2_right"></td></tr></table></td>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_wopreview" name="btng_wopreview">W/O Preview</td><td class="btn2_right"></td></tr></table></td>
							<!-- Repeat Pattern -->


						</tr></table>
					</td></tr>
					</table>
					<!-- : ( Button_ Sub ) (E) -->
		</div>

				</td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Grid BG Box ) (E) -->


</td></tr>
</table>
<!-- Outer Table (E)-->


</form>
</body>
</html>