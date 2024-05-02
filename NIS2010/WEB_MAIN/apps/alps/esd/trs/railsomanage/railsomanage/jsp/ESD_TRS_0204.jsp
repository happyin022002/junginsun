<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_0204.jsp
*@FileTitle : USA Rail Billing Correction를 생성
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-23
*@LastModifier : kim_sang_geun
*@LastVersion : 1.0
* 2006-11-23 kim_sang_geun
* 1.0 최초 생성
* N200907030100 2009-07-03 TRS Railbilling Correction 수정
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.trs.railsomanage.railsomanage.event.EsdTrs0201Event"%>
<%
	SignOnUserAccount account = null; //Session 정보
	EsdTrs0201Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";								 //에러메세지

	String today = DateTime.getFormatString("yyyyMMdd");
	String beforeOneMonth = DateTime.addDays(today, -14);

	String selFulEmty  = ""; //Full/Empty
	String selBnd      = ""; //BND
	String selLimtInq  = ""; //Limit of Inquiry
	String selRailRoad = ""; //Rail Road
	String optionStr = "000020:ALL:ALL";
	String selThrough = ""; //Through

	try {
		account = (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);

		selFulEmty  = JSPUtil.getCodeCombo("sel_edikind", "01", "style=width:'135'", "CD00136", 0, optionStr);
		selBnd  = JSPUtil.getCodeCombo("sel_bnd", "01", "style=width:'47'", "CD00592", 0, optionStr);
		selLimtInq = JSPUtil.getCodeCombo("sel_limtinq", "01", "style=width:'160'", "CD00922", 0, optionStr);
		selRailRoad = JSPUtil.getCodeCombo("sel_railroad", "01", "style=width:517", "CD00930", 0, optionStr);
		selThrough = JSPUtil.getCodeCombo("sel_through", "01", "style=width:79", "CD00934", 0, optionStr);

		event = (EsdTrs0201Event)request.getAttribute("Event");
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
<title>USA Rail Billing S/O Creation</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		// InitTab();
		loadPage();
	}
</script>
<script language="javascript">
	<%=JSPUtil.getIBCodeCombo("ibd_ipi_locl_ind_cd", "01", "CD00932", 0, "")%>
</script>
</head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input	type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="hid_frmdate" value="">
<input type="hidden" name="hid_todate" value="">
<input type="hidden" name="ctrl_ofc_cd" value="<%=account.getOfc_cd()%>">
<input type="hidden" name="ctrl_user_id" value="<%=account.getUsr_id()%>">
<input type="hidden" name="hid_trsp_cost_mod_cd">
<input type="hidden" name="hid_ref_id">
<input type="hidden" name="hid_fm_nod_cd">
<input type="hidden" name="hid_to_nod_cd">
<input type="hidden" name="hid_eq_tpsz_cd">

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

						<td class="btn1_line"></td>

						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td><td class="btn1" id="btn_reset" name="btn_reset">New</td><td class="btn1_right"></td></tr></table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td><td class="btn1" id="btn_minimize" name="btn_minimize">Minimize</td><td class="btn1_right"></td></tr></table></td>
						<!-- Repeat Pattern -->

					</tr></table>

				</td></tr>
			</table>
		<!-- TABLE '#D' : ( Button : Main ) (E) -->


		<div id="MiniLayer" style="display:inline">
		<!-- TABLE '#D' : ( Search Options ) (S) -->
		<table class="search">
			<tr>
				<td class="bg">
					<table class="search_in" border="0">
						<tr class="h23">
							<td width="100">Date</td>
							<td>
								<table border="0" style="height:15; width:570;background-color: #E9E9E9;">
                                	<tr>
                                		<td class="sm" style="padding-left:10;" width="359">
                                			<input type="radio" name="date_sep" value="SC" class="trans" checked>Service Order Created&nbsp;&nbsp;
											<input type="radio" name="date_sep" value="BU" class="trans">Booking Updated&nbsp;&nbsp;
											<input type="radio" name="date_sep" value="CR" class="trans">Cancel Request&nbsp;&nbsp;
										</td>
										<td><input name="frm_plandate" type="text" style="width:75;" value="<%=beforeOneMonth%>" maxlength="8" onFocus="javascript:delHypen(this);" onBlur="javascript:getHypen(this); getDateBetween(this);">&nbsp;~&nbsp;<input name="to_plandate" type="text" style="width:75;" value="<%=today%>" maxlength="8" onFocus="javascript:delHypen(this);" onBlur="javascript:getHypen(this);" onKeyup="javascript:doSearchEnter();"><img src="" width="2" height="1" border="0"><img class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar"></td>
                                	</tr>
                                </table>
                            </td>
						</tr>
					</table>
					<!--  N200907030100 2009-07-03 TRS Railbilling Correction 수정 -->
					<table class="search_in" border="0">
						<tr class="h23">
							<td width="100">Status</td>
							<td width="165" style="padding-left:0">
								<select name="sel_status" style="width:105;">
									<option value="ALL" selected>ALL</option>
									<option value="C">S/O Created</option>
									<option value="R">S/O Updateed</option>
									<option value="I">EDI Sent</option>
								</select>
							</td>
							<td width="70">Full/Empty</td>
							<td width="176"><%=selFulEmty%></td>
							<td width="50">Bound</td>
							<td width="83"><%=selBnd%></td>
							<td width="57">Through</td>
							<td width="80"><%=selThrough%></td>
							<td width="125">VVD/POD Unmatch</td>
							<td align="right">
									<select name="sel_unmatch" style="width:70;">
									<option value="ALL" selected>ALL</option>
									<option value="Y">Y</option>
									<option value="N">N</option>
								</select></td>
						</tr>
					</table>

					<table class="search_in" border="0">
						<tr class="h23">
							<td width="100">Rail Origin</td>
							<td width="51"><input name="frm_node" type="text" style="width:47;" maxlength="5" onChange="getComboList(this, document.frm_yard, 'F');"></td>
							<td width="114"><script language="javascript">ComComboObject('frm_yard', 1, 56, 0)</script><img src="" width="2" height="2"><img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btns_frmnode"></td>
							<td width="100">Rail Destination</td>
							<td width="51"><input name="to_node" type="text" style="width:47;" maxlength="5" onChange="getComboList(this, document.to_yard, 'T');"></td>
							<td width="95"><script language="javascript">ComComboObject('to_yard', 1, 56, 0)</script><img src="" width="2" height="2"><img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btns_tonode"></td>
							<td width="96">Limit of Inquiry</td>
							<td><%=selLimtInq%></td>
						</tr>
					</table>
					<table class="search_in" border="0">
						<tr class="h23">
							<td width="100">Service Provider</td>
							<td style="padding-left:2;">
								<table border="0" style="height:15; width:695;background-color: #E9E9E9;">
                                	<tr>
                                		<td class="sm" width="138" style="padding-left:10;">
                                			<input type="radio" class="trans" name="rad_vendor" value="V1" checked onClick="javascript:do_railroad('W');">Rail Road&nbsp;
											<input type="radio" class="trans" name="rad_vendor" value="V2" onClick="javascript:do_railroad('R');">WRS</td>
									    <td>
									    	<div id="SV" style="display:none">
											<table class="search" border="0">
												<tr><td  width="115"><input name="combo_svc_provider" type="text" style="width:113;" value="" maxlength="6" onBlur="vender_blur();"><td>
													<td><input type="text" name="trsp_so_vndr_no" readonly class="input2" style="width:402;" value=""><img src="" width="2" height="1" border="0"><img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btns_vender"></td>
												</tr>
											</table>
										</div>
										<div id="SV" style="display:inline">
											<table class="search" border="0">
												<tr><td><%=selRailRoad%></td></tr>
											</table>
										</div>
									    </td>
                                	</tr>
                               	</table>
							</td>
						</tr>
					</table>


					<table class="search_in" border="0">
						<tr class="h23">
							<td width="100">T.VVD</td>
							<td width="165"><input name="trunk_vvd" type="text" style="width:105;" value="" onKeyup="javascript:doSearchEnter();"><img src="" width="2" height="1" border="0"><img class="cursor" src="/hanjin/img/button/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle" name="btns_multivvd"><img src="" width="2" height="1" border="0"><img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btns_tvvd"></td>
							<td width="100">Booking No.</td>
							<td width="147"><input name="bkg_no" type="text" style="width:105;" onKeyup="javascript:doSearchEnter();"><img src="" width="2" height="1" border="0"><img class="cursor" src="/hanjin/img/button/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle" name="btns_multibkg"></td>
							<td width="50">B/L No.</td>
							<td width="219"><input name="bill_no" type="text" style="width:100;" onKeyup="javascript:doSearchEnter();"><img src="" width="2" height="1" border="0"><img class="cursor" src="/hanjin/img/button/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle" name="btns_multibl"></td>
							<td width="85">Container No.</td>
							<td align="left"><input name="cntr_no" type="text" style="width:90;" onKeyup="javascript:doSearchEnter();" onChange="javascript:this.value=cntrCheckDigit(this.value);"><img src="" width="2" height="1" border="0"><img class="cursor" src="/hanjin/img/button/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle" name="btns_multicntr"></td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->
		</div>

		<table class="height_10"><tr><td></td></tr></table>

		<!-- TABLE '#D' : ( Gird BG Box ) (S) -->
		<table class="search" border="0">
			<tr>
				<td class="bg">


					<table width="100%" id="mainTable">
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet');</script>
                        </td></tr>
		            </table>
					<!-- : ( Grid ) (E) -->
					<!-- : ( Button_ Sub ) (S) -->
					<table width="100%" class="button">
				       	<tr><td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
						<tr>

							<!-- Repeat Pattern -->
							<%
								if( "PHXSA".equals(account.getOfc_cd()) ){
							%>							
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_cancelreqreject" name="btng_cancelreqreject">Cancel REQ Reject</td><td class="btn2_right"></td></tr></table></td>
							<%
								}
							%>

							<%
								if( "PHXSA".equals(account.getOfc_cd()) ){
							%>	
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_sodelete" name="btng_sodelete">S/O Delete</td><td class="btn2_right"></td></tr></table></td>
							<%
								}
							%>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btg_irgadjust" name="btng_irgadjust">IRG Adjust</td><td class="btn2_right"></td></tr></table></td>

							<%
								if( "PHXSA".equals(account.getOfc_cd()) ){
							%>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_ediresend_tti" name="btng_ediresend_tti">EDI Re-sending to TTI</td><td class="btn2_right"></td></tr></table></td>
							<%
								}
							%>

							<%
								if( "PHXSA".equals(account.getOfc_cd()) ){
							%>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_socorrection" name="btng_socorrection">S/O Correction</td><td class="btn2_right"></td></tr></table></td>
							<%
								}
							%>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_downexcel" name="btng_downexcel">Down Excel</td><td class="btn2_right"></td></tr></table></td>

							<!-- Repeat Pattern -->

						</tr></table>
					</td></tr>
					</table>
					<!-- : ( Button_ Sub ) (E) -->
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
<script language="javascript">
	document.form.combo_svc_provider.style.visibility = "hidden";
	document.form.trsp_so_vndr_no.style.visibility = "hidden";
	document.form.btns_vender.style.visibility = "hidden";
	document.form.sel_railroad.style.visibility = "visible";
</script>