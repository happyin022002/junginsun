<%--
/*=========================================================
*copyright(c) 2006 cyberlogitec
*@filename : ESD_PRD_0002.jsp
*@filetitle : yardmanage
*open issues :
*change history :
*@lastmodifydate : 2006-10-24
*@lastmodifier : kimyoungchul
*@lastversion : 1.0
* 2006-10-24 kimyoungchul
* 1.0 최초 생성
* 2009-07-13 alps framework 구조 변경 noh seung bae
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse" %>
<%@ page import="com.hanjin.apps.alps.esd.prd.common.prdcommon.vo.ContinentVO"%>
<%@ page import="java.util.List" %>
<%
	GeneralEventResponse eventResponse = null;	//RDTO(Data Transfer Object including DB ResultSet)
	Exception serverException   = null;				//서버에서 발생한 에러
	List list = null;
	String strErrMsg = "";							//에러메세지
	//String successFlag = "";
	//String codeList  = "";
	//String pageRows  = "100";
	String nodeCd = "";
	try {

	   //SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   //userId=account.getUsr_id();
	   //userAuth=account.getAuth();

		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}else{
			eventResponse = (GeneralEventResponse)request.getAttribute("EventResponse");
			if (eventResponse != null) {
				list = eventResponse.getRsVoList();
			} // end if
		} // end else
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<!--%@include file="/apps/alps/esd/prd/common/prdcommon/jsp/ESD_PRD_0AUTH.jsp"%-->
<html>
<head>
<title>YardManage</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		nodeCd = "<%=nodeCd%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		//InitTab();
		loadPage();
	}
</script>
<!-- CSS for 'RIGHT' frame -->

</head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">

<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>
<form method="post" name="form">
<input	type="hidden" name="f_cmd">
<input type="hidden" name="iPage">



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

							<!-- Repeat Pattern -->

						</tr></table>

				</td></tr>
		</table>
		<!-- TABLE '#D' : ( Button : Main ) (E) -->



		<!-- TABLE '#D' : ( Search Options ) (S) -->
		<table class="search">
			<tr>
				<td class="bg">
					<table class="search_in" border="0">
						<tr class="h23">
							<td width="80"><img class="nostar">Continent</td>
							<td width="170" style="padding-left:2">
							<input class="input1" type="hidden" name="conti_code" value=""  >
								<select class="input1" name="select1" style="width:60;" onChange="changeContinent()" tabIndex="1">
									<option value="0" >All</option>
									<%
									for(int i=0; i< list.size(); i++){
										ContinentVO vo = (ContinentVO)list.get(i);
										out.println("<option value='"+ vo.getContiCode() +"' >" + vo.getContiCode() + "</option>");
									}
									%>
								</select>
							</td>
							<td width="110"><img class="nostar">Sub-Continent</td>
						<td width="150" style="padding-left:2">
								<input class="input1" type="hidden" name="subconti_code" value=""   >
								<select class="input1" name="select2" style="width:70" onChange="changeSubContinent()" tabIndex="2">
									<option value="0" selected>All</option>
								</select>
							</td>
							<td>
								<table class="sm" style="height:20; width:186; background-color: #E9E9E9;">
									<tr>
										<td width="" align="center">
											<input type="hidden" name="node_type_div" value="" >
											<input type="radio" name="radio1" class="trans" value="" checked="checked"  tabIndex="3" >
											Both&nbsp;&nbsp;
											<input type="radio" name="radio1" class="trans" value="Y" >
											Yard
											<input type="radio" name="radio1" class="trans" value="Z" >
											Zone</td>
									</tr>
								</table> </td>
						</tr>
						</table>
						<table class="search_in" border="0">
						<tr class="h23">
							<td width="80"><img class="nostar">Country</td>
							<td width="172">
								<input class="input1" type="text" maxlength="2" name="country_code" value="" style="width:37"  tabIndex="4" dataformat="engup" >
								<img class="cursor" src="img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_cnt" >
							</td>
							<td width="110"><img class="nostar">Region</td>
							<td width="170"><input type="text" name="region_code" maxlength="3"  value="" style="width:38"  tabIndex="5"  dataformat="engup"></td>
							<td width="60">Location</td>
							<td width="220">
								<input type="text" maxlength="5" name="location_code_top" value="" style="width:70" tabIndex="6" ondeactivate="chkCountry(this);" dataformat="engup" >
								<img class="cursor" src="img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="loc_btn">
							</td>
							<td width="40">Node</td>
							<td>
								<input type="text" name="node_code_top" maxlength="7" value="" style="width:70"  tabIndex="7" ondeactivate="chkCountry(this);" dataformat="engup" >
								<img class="cursor" src="img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="node_btn">
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->

		<table class="height_10"><tr><td></td></tr></table>

		<!-- TABLE '#D' : ( Grid BG Box ) (S) -->
		<table class="search" border="0">
			<tr>
				<td class="bg">


					<!-- Grid : Week (S) -->
					<!-- 'HEAD1-BGCOLOR : 192 235 163' , 'HEAD2-BGCOLOR : 231 250 249' , 'BORDER : 90 138 158' , 'HEAD1-FONT : 0 83 116' , 'DATA GRID BG (2 colors) : 255 255 255, 249 249 249 ' -->

					<table width="100%" id="mainTable">
				              <tr><td>
				                     <script type="text/javascript">ComSheetObject('sheet1');</script>
				              </td></tr>
					</table>
					<!-- Grid : Week (E) --></td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Grid BG Box ) (E) -->

		<table class="height_10"><tr><td></td></tr></table>

		<!-- TABLE '#D' : ( Tab ) (S) -->
		<table class="tab">
		        <tr><td><script type="text/javascript">ComTabObject('tab1')</script>
			<!--tr>
				<td><img src="img/alps/sub_tab.gif" alt="" width="755" height="23" border="0"--></td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Tab ) (E) -->

		<!-- Tab1 - YARD //////////////////////////////////////////////////////////////////////////////////////////////////-->
        <div id="tabLayer" style="display:inline">
		<!-- TABLE '#D' : ( Tab BG Box ) (S) -->
		<table class="search" border="0">
			<tr>
				<td class="bg">


					<!-- TABLE '#D' : ( Table :Basic Information ) (S) -->
					<table class="search_in" border="0">
					<tr>
							<td valign="top">
								<table class="search" border="0" style="width:610;">
									<tr><td colspan="5" height="23"></td></tr>
									<tr class="h23">
										<td width="110" rowspan="6">Basic Info.</td>

										<td width="80" class="stm">Yard Code </td>
										<td width="287"><input name="yard_code"  class="input1" readonly type="text" style="width:150" value=""></td>
										<td width="65" class="stm">Loc. Code </td>
										<td width=""><input name="location_code"  class="input1" readonly type="text" style="width:60" value=""></td>
									</tr>
									<tr class="h23">
										<td class="stm">Yard Name </td>
										<td colspan="3"><input name="yard_name"  class="input1" readonly type="text" style="width:150" value=""></td>
										<!-- td class="stm">Representative Hub Loc.</td>
										<td><input name="yd_rep_hub_loc_cd" type="text" style="width:60" value=""></td -->
									</tr>
									<tr class="h23">
										<td class="stm">Node Type </td>
										<td><input name="node_type"  class="input1" readonly type="text" style="width:150" value=""></td>
										<td class="stm">Hub Node</td>
										<td><input name="hub_node"  class="input1" readonly type="text" style="width:60" value=""></td>
									</tr>
									<tr class="h23">
										<td class="stm">Service Type </td>
										<td colspan="3" class="stm">
											<table class="sm" border="0" style="height:20; width:100%; background-color: #E9E9E9;">
												<tr>
													<td>
														<input type="checkbox"  class="noinput1" disabled name="service_type_marinet" value="" class="trans">Marine.T&nbsp;&nbsp;
														<input type="checkbox"  class="noinput1" disabled name="service_type_barget" value="" class="trans">Barge.T&nbsp;&nbsp;
														<input type="checkbox"  class="noinput1" disabled name="service_type_cy" value="" class="trans">CY&nbsp;&nbsp;
														<input type="checkbox"  class="noinput1" disabled name="service_type_cfs" value="" class="trans">CFS&nbsp;&nbsp;
														<input type="checkbox"  class="noinput1" disabled name="service_type_railramp" value="" class="trans">Rail Ramp&nbsp;&nbsp;
														<input type="checkbox"  class="noinput1" disabled name="service_type_pseudoy" value="" class="trans">Pseudo.Y
													</td>
												</tr>
											</table>

										</td>
									</tr>
									<tr><td colspan="5" height="23"></td></tr>
								</table>

								<table class="line_bluedot"><tr><td colspan="5"></td></tr></table>

								<table class="search" border="0" style="width:610;">
									<tr class="h23">
										<td width="110" rowspan="5">Contact Point</td>
										<td width="80" class="stm">Person</td>
										<td width="217"><input name="person"  class="input1" readonly type="text" style="width:145" value=""></td>
										<td width="65" class="stm">E-mail</td>
										<td width=""><input name="email"  class="input1" readonly type="text" style="width:130" value=""></td>
									</tr>
									<tr class="h23">
										<td width="80" class="stm">Tel.</td>
										<td colspan="3"><input name="tel"  class="input1" readonly type="text" style="width:145" value=""></td>
										<!-- td class="stm">Web Site</td>
										<td><input name="yd_web_site" type="text" style="width:130" value=""></td -->
									</tr>
									<tr class="h23">
										<td width="80" class="stm">Fax.</td>
										<td><input name="fax"  class="input1" readonly type="text" style="width:145" value=""></td>
										<td class="stm" colspan="2">Postal Code&nbsp;<input name="postal_code"  class="input1" readonly type="text" style="width:130" value=""></td>
									</tr>
									<tr class="h23">
										<td width="" class="stm">Yard Address</td>
										<td colspan="3"><input name="yard_address"  class="input1" readonly type="text" style="width:413" value=""></td>
									</tr>
								</table>

								<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>

								<table class="search" border="0" style="width:630;">
									<tr class="h23">
										<td width="110" rowspan="5">Service Info.</td>
										<td width="100" rowspan="5" class="stm">Gate Open Time</td>
										<td width="165">
											<input name="yd_gate_open_week"  class="input1" readonly type="text" style="width:50" value="Week">
											<input name="gate_week_open"  class="input1" readonly type="text" style="width:40" value=""> ~
											<input name="gate_week_close"  class="input1" readonly type="text" style="width:40" value="">
										</td>
										<td width="155" class="stm">O/B Average Dwell Time(R)</td>
										<td width=""><input name="ob_average_dwell_r"  class="input1" readonly type="text" style="width:40" value=""></td>
										<td width="20" class="stm">(D)</td>
										<td width=""><input name="ob_average_dwell_d"  class="input1" readonly type="text" style="width:40" value=""></td>
									</tr>
									<tr class="h23">
										<td>
											<input name="yd_gate_open_sat"  class="input1" readonly type="text" style="width:50" value="Sat">
											<input name="gate_sat_open"  class="input1" readonly type="text" style="width:40" value=""> ~
											<input name="gate_sat_close"  class="input1" readonly type="text" style="width:40" value="">
										</td>
										<td class="stm">I/B Average Dwell Time(R)</td>
										<td><input name="ib_average_dwell_r"  class="input1" readonly type="text" style="width:40" value=""></td>
										<td class="stm">(D)</td>
										<td><input name="ib_average_dwell_d"  class="input1" readonly type="text" style="width:40" value=""></td>
										</tr>
									<tr class="h23">
										<td>
											<input name="yd_gate_open_sun"  class="input1" readonly type="text" style="width:50" value="Sun">
											<input name="gate_sun_open"  class="input1" readonly type="text" style="width:40" value=""> ~
											<input name="gate_sun_close"  class="input1" readonly type="text" style="width:40" value="">
										</td>
										<td class="stm">COP O/B Dwell Time(R)</td>
										<!-- td><input name="ob_minimum_dwell_r"  class="input1" readonly type="text" style="width:40" value=""></td-->
										<td><input name="cop_ob_rf_avg_dwll_hrs"  class="input1" readonly type="text" style="width:40" value=""></td>
										<td class="stm">(D)</td>
										<!--td><input name="ob_minimum_dwell_d"  class="input1" readonly type="text" style="width:40" value=""></td-->
										<td><input name="cop_ob_dry_avg_dwll_hrs"  class="input1" readonly type="text" style="width:40" value=""></td>
								
									</tr>
									<tr class="h23">
										<td>
											<input name="yd_gate_open_hol"  class="input1" readonly type="text" style="width:50" value="Holiday">
											<input name="gate_holiday_open"  class="input1" readonly type="text" style="width:40" value=""> ~
											<input name="gate_holiday_close"  class="input1" readonly type="text" style="width:40" value="">
										</td>
										<td class="stm">COP I/B Dwell Time(R)</td>
										<!--td><input name="ib_minimum_dwell_r"  class="input1" readonly type="text" style="width:40" value=""></td-->
										<td><input name="cop_ib_rf_avg_dwll_hrs"  class="input1" readonly type="text" style="width:40" value=""></td>
										<td class="stm">(D)</td>
										<!--td><input name="ib_minimum_dwell_d"  class="input1" readonly type="text" style="width:40" value=""></td-->
										<td><input name="cop_ib_dry_avg_dwll_hrs"  class="input1" readonly type="text" style="width:40" value=""></td>
								
									</tr>

									<tr class="h23">
										<td>&nbsp;&nbsp;</td>
										<td class="stm">Free Time</td>
										<td><input name="free_time"  class="input1" readonly type="text" style="width:40" value=""></td>
									</tr>
								</table>
							</td>
							<td width="15"></td>
							<td valign="top">
								<table class="search" border="0" style="width:330;">
									<tr class="h23">
										<td width="110" rowspan="6">Yard Operator</td>
										<td width="115" class="stm">CY Handling Vendor</td>
										<td width=""><input name="yard_operator1"  class="input1" readonly type="text" style="width:100" value=""></td>
									</tr>
									<tr class="h23">
										<td class="stm">Name</td>
										<td><input name="operator1_name"  class="input1" readonly type="text" style="width:100" value=""></td>
									</tr>
									<tr class="h23">
										<td class="stm">Stevedoring Vendor</td>
										<td><input name="yard_operator2"  class="input1" readonly type="text" style="width:100" value=""></td>
									</tr>
									<tr class="h23">
										<td class="stm">Name</td>
										<td><input name="operator2_name"  class="input1" readonly type="text" style="width:100" value=""></td>
									</tr>
									<tr class="h23">
										<td class="stm">Security Vendor</td>
										<td><input name="yard_operator3"  class="input1" readonly type="text" style="width:100" value=""></td>
									</tr>
									<tr class="h23">
										<td class="stm">Name</td>
										<td><input name="operator3_name"  class="input1" readonly type="text" style="width:100" value=""></td>
									</tr>
								</table>

								<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>

								<table class="search" border="0" style="width:330;">
									<tr class="h23">
										<td width="110" rowspan="7">Additional Info.</td>
										<td width="115" class="stm">Office Code  </td>
										<td width=""><input name="office_code"  class="input1" readonly type="text" style="width:70" value=""></td>
									</tr>
									<tr class="h23">
										<td class="stm">DEM I/B Collection</td>
										<td><input name="dem_ib_collection"  class="input1" readonly type="text" style="width:70" value=""></td>
									</tr>
									<tr class="h23">
										<td class="stm">DEM O/B Collection</td>
										<td><input name="dem_ob_collection"  class="input1" readonly type="text" style="width:70" value=""></td>
									</tr>
									<tr class="h23">
										<td class="stm">Yard Ownership</td>
										<td><input name="yard_ownership"  class="input1" readonly type="text" style="width:70" value=""></td>
									</tr>
									<tr class="h23">
										<td class="stm">Bonded Yard</td>
										<td><input name="bonded_yard"  class="input1" readonly type="text" style="width:70" value=""></td>
									</tr>
									<tr class="h23">
										<td class="stm">C-TPAT</td>
										<td><input name="c_tpat"  class="input1" readonly type="text" style="width:70" value=""></td>
									</tr>
									<tr class="h23">
										<td class="stm">Yard On / Off-hire</td>
										<td><input name="yard_on_off"  class="input1" readonly type="text" style="width:70" value=""></td>
									</tr>
								</table>

							</td>
						</tr>

					</table>

					<!-- : ( Button : Sub ) (S) -->
					<table width="100%" class="button">
				       	<tr><td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
						<tr>

							<!-- Repeat Pattern -->
							<!-- 
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" name="btng_tmnlmatrix" id="btng_tmnlmatrix">TMNL Matrix</td><td class="btn2_right"></td></tr></table></td>
							-->
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" name="btng_dwell" id="btng_constraint">Dwell history</td><td class="btn2_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" name="btng_constraint" id="btng_constraint">Constraint</td><td class="btn2_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" name="btng_yardcct" id="btng_yardcct">Yard CCT</td><td class="btn2_right"></td></tr></table></td>
							<!-- Repeat Pattern -->


						</tr></table>
					</td></tr>
					</table>
	    				<!-- : ( Button : Sub ) (E) -->
					<!-- TABLE '#D' : ( Table :Service Information ) (E) --></td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Tab BG Box ) (E) -->
		</div>



		<!-- Tab2 - ZONE ////////////////////////////////////////////////////////////////////////////////////////////// -->
        <div id="tabLayer" style="display:none">
		<!-- TABLE '#D' : ( Grid BG Box ) (S) -->
		<table class="search" border="0">
			<tr>
				<td class="bg">

					<table class="height_10"><tr><td></td></tr></table>

					<table class="search_in" border="0">
						<tr class="h23">
							<td width="" valign="top">
								<table class="search" border="0" style="width:450;">
									<tr class="h23">
										<td width="90" rowspan="2">Location</td>
										<td width="130" class="stm">Location  Code </td>
										<td width=""><input name="location_code"  class="input1" readonly type="text" style="width:150" value=""></td>
									</tr>
									<tr class="h23">
										<td class="stm">Location  Name </td>
										<td width=""><input name="location_name"  class="input1" readonly type="text" style="width:150" value=""></td>
									</tr>
								</table>

								<table class="line_bluedot"><tr><td colspan=3"></td></tr></table>

								<table class="search" border="0" style="width:450;">
									<tr class="h23">
										<td width="90" rowspan="4">Zone</td>
										<td width="130" class="stm">Zone  Code </td>
										<td width=""><input name="zone_code"  class="input1" readonly type="text" style="width:150" value=""></td>
									</tr>
									<tr class="h23">
										<td class="stm">Zone  Name </td>
										<td width=""><input name="zone_name"  class="input1" readonly type="text" style="width:150" value=""></td>
									</tr>
									<tr class="h23">
										<td class="stm">Control Office</td>
										<td width=""><input name="control_office"  class="input1" readonly type="text" style="width:150" value=""></td>
									</tr>
									<tr class="h23">
										<td class="stm">Cargo Handling Time</td>
										<td width=""><input name="cargo_handling_time"  class="input1" readonly type="text" style="width:150" value=""></td>
									</tr>
								</table>
							</td>
							<td width="17" valign="top"></td>
							<td width="" valign="top">
								<table class="search" border="0" style="width:470;">
									<tr class="h23">
										<td width="140" rowspan="4">Representative CY</td>
										<td width="170" class="stm">Representative CY Code</td>
										<td width=""><input name="representative_code"  class="input1" readonly type="text" style="width:151" value=""></td>
									</tr>
									<tr class="h23">
										<td class="stm">Representative CY Name</td>
										<td><input name="representative_name"  class="input1" readonly type="text" style="width:151" value=""></td>
									</tr>
									<tr class="h23">
										<td class="stm">Distance(Zone to Rep. CY)</td>
										<td>
											<input name="distance"  class="input1" readonly type="text" style="width:74" value="">
											<input name="zn_dist_unit"  class="input1" readonly type="text" style="width:73" value="Mile"></td>
									</tr>
									<tr class="h23">
										<td class="stm">T/T(Zone to Rep. CY)</td>
										<td><input name="tt"  class="input1" readonly type="text" style="width:151" value=""></td>
									</tr>
								</table>

								<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>

								<table class="search" border="0" style="width:470;">
									<tr class="h23">
										<td width="140" rowspan="3">Zone Type Detail</td>
										<td width="330">

											<!--grid (s)-->
											<table width="100%" id="mainTable">
										              <tr><td>
										                     <script type="text/javascript">ComSheetObject('t2sheet1');</script>
										              </td></tr>
											</table>
											<!--grid (E)-->

										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>

			</tr>
		</table>
		<!-- TABLE '#D' : ( Grid BG Box ) (E) -->
        </div>

</form>
    </td></tr>
</table>
<!-- Outer Table (E)-->

<iframe name="HiddenFrame" id="HiddenFrame" frameborder="0" marginheight="0" marginwidth="0" width="0" height="0"></iframe>
</body>
</html>
