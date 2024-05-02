<%--
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TRS_0101.jsp
*@FileTitle : Carrier's Haulage Analysis Report
*Open Issues :
*Change history :
*@LastModifyDate : 2009-10-01
*@LastModifier : kimjin
*@LastVersion : 1.0
* 2009-10-01 kimjin
* 1.0 최초 생성
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.trs.report.chanalysis.event.EsdTrs0101Event"%>
<%
	EsdTrs0101Event  event 		= null;			//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg 			= "";			 //에러메세지
	
	String today 		= DateTime.getFormatString("yyyyMMdd");
	String beforeday 	= DateTime.addDays(today, -7);
	beforeday = beforeday.substring(0,4) + "-" + beforeday.substring(4,6)+ "-" + beforeday.substring(6,8);  //월 저장
	String selRHQMODE = ""; //RHQ Mode

	String optionStr = "000020:ALL:ALL";
	String userId="";
	String ofc_cd="";

	selRHQMODE  = JSPUtil.getCodeCombo("sel_rhqmode", "01", "", "CD00738", 0, optionStr);

	try {

	   SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   userId=account.getUsr_id();
	   ofc_cd=account.getOfc_cd();

		event = (EsdTrs0101Event)request.getAttribute("Event");

		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>C/H Anaysis Report</title>
<script language="javascript" src="/hanjin/rpt/script/rdviewer50.js"></script>

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

<!--body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();fn_combo();"-->
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">

<form name='reportRD' method='POST' action='ESD_TRS_0206.screen'>
<input type='hidden' name='trsp_so_ofc_cty_cd'>
<input type='hidden' name='trsp_so_seq'>
<input type='hidden' name='wo_cancel_flag'>
<input type='hidden' name='dtn_use_flg'>
<input type='hidden' name='wo_bl_no_iss_flg'>
<input type='hidden' name='vndr_seq'>
<input type='hidden' name='po_local_curr_cd'>
<input type='hidden' name='po_basic_rt'>
<input type='hidden' name='nego_amt'>
<input type='hidden' name='etc_add_amt'>
<input type='hidden' name='po_fuel_scg_rt'>
<input type='hidden' name='po_usd_curr_tot_amt'>
<input type='hidden' name='n3pty_bil_flg'>
<input type='hidden' name='eq_mode' value='IS'>
<input type='hidden' name='issued'>
<input type='hidden' name='scg_grp_seq'>
<input type='hidden' name='cust_cnt_cd'>
<input type='hidden' name='cust_seq'>
<input type='hidden' name='cust_nomi_trkr_flg'>
<input type='hidden' name='trsp_agmt_rt_tp_cd'>
<input type='hidden' name='trsp_agmt_wy_tp_cd'>
<input type='hidden' name='trsp_frst_flg'>
<input type='hidden' name='trsp_rjct_rsn_cd'>
<input type='hidden' name='trsp_dflt_vndr_flg'>

<input type='hidden' name='n1st_nod_pln_dt'>
<input type='hidden' name='lst_nod_pln_dt'>
<input type='hidden' name='dor_nod_pln_dt'>
<input type='hidden' name='inter_rmk'>
<input type='hidden' name='spcl_instr_rmk'>

<input	type="hidden" name="sysCommUiTitle" value="Preview">
<input	type="hidden" name="sysCommUiNavigation" value="Trans S/O > Work Order">
</form>


<form method="post" name="form" onSubmit="return false;">
<input	type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="stsval" value="Y">
<input type="hidden" name="hid_cargo" value="ALL">
<input type="hidden" name="hid_period" value="D">
<input type="hidden" name="hid_boundmode" value="ALL">
<input type="hidden" name="hid_bkgterm" value="ALL">
<input type="hidden" name="hid_onlycy" value="">
<input type="hidden" name="hid_trosts" value="ALL">
<input type="hidden" name="hid_inclmty" value="ALL">
<input type="hidden" name="hid_fmdt" value="ALL">
<input type="hidden" name="hid_todt" value="ALL">
<input type="hidden" name="hid_week" value="ALL">
<input type="hidden" name="csr_no">
<input type="hidden" name="hid_cost" value="ALL">
<input type="hidden" name="hid_to_date" value="">
<input type="hidden" name="hid_from_date" value="">
<input type="hidden" name="hid_rhq" value="ALL">
<input type="hidden" name="ofc_cd" value="<%=ofc_cd%>">
<input type="hidden" name="old_ofc_cd" value="<%=ofc_cd%>">
<input type="hidden" name="chkflg" value="ALL">


<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>

		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->

			<!--Button_L (S) -->
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
    			<!--Button_L (E) -->

        <div id="showMin" style="display:inline">

		<!-- TABLE '#D' : ( Search Options ) (S) -->
     	<table class="search">
       	<tr><td class="bg" >

				<!-- : ( Service Order Issue Date ) (S) -->
				<table class="search_in" border="0">
				<TR class="h23"	>
					<TD "width=100%">

							<table border="0" style="height:15; width:100%; background-color: #E9E9E9;">
                            <tr class="h23"	>
                            	<td width="180" style="padding-left:10;"><input name="radio_period" type="radio" class="trans" checked  Onclick="change_period();" >	 Service Order Issue Date</td>
                            	<td class="stm" width="220"><input name = "so_fmdt" type="text" style="width:80;"  maxlength="8" onFocus="focusDate(this);javascript:delHypen(this);" onBlur="BlurDate(this);" value = "YYYYMMDD" >&nbsp;~&nbsp;<input name = "so_todt" type="text" style="width:80;"  maxlength="8" onFocus="focusDate(this);javascript:delHypen(this);" onBlur="BlurDate(this);" value = "YYYYMMDD"></td>
                            	<td width="190"><input name="radio_period" type="radio" class="trans"   Onclick="change_period();" >Week&nbsp;&nbsp;<input name = "week" type="text" maxlength="6" style="width:80;" onBlur="Blurweek(this);" onFocus="focusWeek(this);dateAppointed('W');" value="YYYYWW"></td>
                            	<td width="190"><input name="radio_period" type="radio" class="trans"   Onclick="change_period();" >Month&nbsp;&nbsp;<input name = "month" type="text" maxlength="6" style="width:80;" onBlur="Blurmonth(this); " onFocus="focusMonth(this);dateAppointed('M');" value="YYYYMM"></td>
                            	<td ><input name="radio_period" type="radio" class="trans"   Onclick="change_period();" >Year&nbsp;&nbsp;<input name = "year" type="text" maxlength="4" style="width:80;" onBlur="Bluryear(this);" onFocus="focusYear(this);dateAppointed('Y');" value="YYYY"></td>

                          	</tr>
                          	</table>

					</td>
				</tr>
				<tr height="3"><td></td></tr>
				</table>
				<!-- : ( Service Order Issue Date ) (S) -->


				<!-- ROUTE , Profit Type (S) -->
				<table class="search_in" border="0">
				<TR class="h23"	>
					<td width = 415>


						<!-- ROUTE(S) -->
						<table class="search" border=0>
							<tr  class="h23">
								<td width="50" style="padding-left:36;">Route</td>
								<td width="64"><input name="frm_node" type="text" style="width:60;" maxlength="5" onChange="getComboList(this, document.frm_yard, 'F');" onBlur="setgetUpper(this);"></td>
								<td width="90"><script language="javascript">ComComboObject('frm_yard', 1, 64, 0);</script><img src="/hanjin/img/blank.gif" width="2" height="1" border="0"><img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btns_frmnode"></td>
								<td width="11" class="stm">~</td>
								<td width="54"><input name="to_node" type="text" style="width:50;" maxlength="5" onChange="getComboList(this, document.to_yard, 'T');" onBlur="setgetUpper(this);"></td>
						        <td><script language="javascript">ComComboObject('to_yard', 1, 64, 0);</script><img src="/hanjin/img/blank.gif" width="2" height="1" border="0"><img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0"  align="absmiddle"  name="btns_tonode"></td>
						    </tr>
						</table>
						<table class="search" border=0>
						    <tr class="h23">
						        <td width="50" style="padding-left:36;">Offices</td>
						        <td width="90"><input name = "input_office" type="text" style="width:60;" onkeyup="upper(this)" value="<%=ofc_cd%>"><img src="/hanjin/img/blank.gif" width="2" height="1" border="0"><img  class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btns_office"></td>
						        <td class="sm"><input type="checkbox" name="chk_office" value="Y" class="trans" onClick="javascript:fun_chkOffice();">Incl. Sub Ofcs</td>
					        </tr>
						  </table>
						  <!-- ROUTE(E) -->

					</td>
					<td>
									<!-- Profit Type(S) -->
									<table class="search" border="0">
									<tr><td style="padding:7,7,7,17; background-color: #E9E9E9;">

												<table border="0" style=" width:100%;">
													<TR class="h23">
														<td width=70>Profit Type</td>
														<td width="106">
															<SELECT style = "width:70" name = "sel_profit"  onChange='bound_OnChange_4(this);'>
															<OPTION  value="ALL"> ALL</OPTION>
															<OPTION  value="I"> INV</OPTION>
															<OPTION  value="W"> W/O</OPTION>
															</SELECT>
														<td width=50>Bound</td>
														<td width="112">
															<SELECT style = "width:70" name = "sel_boundmode"  onChange='bound_OnChange_1(this);'>
															<OPTION  value="ALL"> ALL</OPTION>
															<OPTION  value="I"> IN</OPTION>
															<OPTION  value="O"> OUT</OPTION>
															</SELECT></td>
														<td  width=95>Container Type</td>
														<td class="sm">
															<input name="radio_cntp" type="radio" class="trans" Onclick="change_cntp();" >Show&nbsp;
															<input name="radio_cntp" type="radio" class="trans" checked Onclick="change_cntp();" >Hide</td></tr>

													<TR class="h23">
														<td colspan="6">CY Booking Term Only<input type="checkbox" name="chk_cyterm" value="Y" class="trans" onClick="javascript:fun_chekcbox(1);">&nbsp;&nbsp;&nbsp;&nbsp;
																<!--	<input type="checkbox" name="chk_onlycy" value="Y" class="trans" onClick="javascript:fun_chekcbox(1);">  -->
																		TRO Frustrated Only<input type="checkbox" name="chk_fr" value="Y" class="trans" onClick="javascript:fun_chekcbox(1);">&nbsp;&nbsp;&nbsp;&nbsp;
																		Include MTY<input type="checkbox" name="chk_mty" value="Y" class="trans" onClick="javascript:fun_chekcbox(1);">
														</td>
													</tr>
												</table>

										</td></tr>
									</table>
									<!-- Profit Type(E) -->


							</TD>
						</TR>
					</table>
					<!-- ROUTE , Profit Type (S) -->



			</td></tr>
		</form>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->
        </div>

		<table class="height_10"><tr><td></td></tr></table>

		<!-- TABLE '#D' : ( Gird BG Box ) (S) -->
		<table class="search" border="0">
			<tr>
				<td class="bg">

					<!-- 'HEAD1-BGCOLOR : 203 240 169' , 'HEAD2-BGCOLOR : 222 251 248' , 'BORDER 1-outside : 88 152 164' ,'BORDER 2-inside : 202 226 233' , 'HEAD-FONT : 39 95 101' , 'SELETED ROW BG : 252 255 233' -->
					<table width="100%" id="mainTable">
            		      <tr><td>
            		          <script language="javascript">ComSheetObject('sheet1');</script>
            		      </td></tr>
            		</table>
					<!-- : ( Grid ) (E) -->

					<!--  Button_Sub (S) -->
					<table width="100%" class="button">
				       	<tr><td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
						<tr>

							<!-- Repeat Pattern -->
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_sodetail" name="btng_sodetail">S/O Detail</td><td class="btn2_right"></td></tr></table></td>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_downexcel" name="btng_downexcel">Down Excel</td><td class="btn2_right"></td></tr></table></td>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_print" name="btng_print">Print</td><td class="btn2_right"></td></tr></table></td>
							<!-- Repeat Pattern -->


						</tr></table>
					</td></tr>
					</table>
			    		<!-- Button_Sub (E) -->


				</td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Grid BG Box ) (E) -->

<br>


</td></tr>
</table>
<!-- Outer Table (E)-->

</body>
</html>