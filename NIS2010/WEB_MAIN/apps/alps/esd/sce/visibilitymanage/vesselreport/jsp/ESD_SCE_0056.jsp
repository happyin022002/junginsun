<%
/*=========================================================
*Copyright(c) 2007 CyberLogitec
*@FileName : ESD_SCE_0056.jsp
*@FileTitle : Vessel Report
*Open Issues :
*Change history :
*@LastModifyDate : 2007-07-23
*@LastModifier : Jeong-Seon An , Yoon-Jung Lee
*@LastVersion : 1.0
* 2007-07-23 Jeong-Seon An , Yoon-Jung Lee
* 1.0 
=========================================================*/
%>

<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.sce.visibilitymanage.vesselreport.event.EsdSce0056Event"%>
<%@ page import="com.hanjin.apps.alps.esd.trs.codemanage.commoditygroupcodemanage.event.EsdTrs0075Event %>
<%@ page import="com.hanjin.apps.alps.esd.sce.common.util.basic.CodeUtilBC" %>
<%@ page import="com.hanjin.apps.alps.esd.sce.common.util.basic.CodeUtilBCImpl" %>


<%
		CodeUtilBC codeUtil = new CodeUtilBCImpl() ;
		EsdSce0056Event  event = null;                		//PDTO(Data Transfer Object including Parameters)
		Exception serverException   = null;            			//

		// Pickup Notice Pop-up call		
		String eqOfcCd = JSPUtil.getNull(request.getParameter("eq_ofc_cd"));
		String selRailRoad = ""; //Rail Road
		String optionStr = "000020:All:All";
		
		String strErrMsg = "";                                  //
		DBRowSet rowSet      = null;                            //DB ResultSet
		int rowCount     = 0;                                   //DB ResultSet 
		SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
    	String userId=account.getUsr_id();

    	try{
	    	serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
	    	if (serverException != null) {
	            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
	        }else{
	        	event = (EsdSce0056Event)request.getAttribute("Event");
	        }
		} catch(Exception e) {
	        out.println(e.toString());
	    }
		
		String aa = request.getParameter("aa");
		selRailRoad = JSPUtil.getCodeCombo("sel_railroad", "01", "style=width:350 ", "CD00930", 0, optionStr);
		String transModeCd  = JSPUtil.getCodeCombo("f_trsp_crr_mod_cd" , "01", "style='width:120'", "CD03172", 0, "000010:ALL:ALL");
		
%>

<%
	int rowSize = 3000 ;
%>

<html>
<head>
<title>Welcome to enis!</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	<%= JSPUtil.getIBCodeCombo("f_trsp_crr_mod_cd" , "", "CD03172", 0, "")%>
	
    function setupPage(){
        loadPage();
    }

</script>
</head>
<body onLoad="setupPage();">
<form method="post" name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="row_size" value="<%=rowSize%>">
<input type="hidden" name="pgm_no" value="ESD_SCE_0057" >
<input type="hidden" name="eqmt_ofc" value="" >
<input type="hidden" name="port_cd" value="" >

<input type="hidden" name="totcnt" >
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
											<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr><td class="btn1_left"></td><td class="btn1" name="btn_send" id="btn_send">324 EDI Send</td><td class="btn1_right"></td></tr></table></td>
											<td class="btn1_line"></td>
											<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr><td class="btn1_left"></td><td class="btn1" name="btn_clm" id="btn_clm">CLM</td><td class="btn1_right"></td></tr></table></td>
											<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr><td class="btn1_left"></td><td class="btn1" name="btn_downexcel" id="btn_downexcel">Down Excel</td><td class="btn1_right"></td></tr></table></td>
											<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr><td class="btn1_left"></td><td class="btn1" name="btn_downcsv" id="btn_downcsv">Down TXT</td><td class="btn1_right"></td></tr></table></td>
											<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr><td class="btn1_left"></td><td class="btn1" name="btn_downonly" id="btn_downonly">Down Only</td><td class="btn1_right"></td></tr></table></td>
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
						    <td width="40">Date</td>
							<td width="55"><select name="dateselect" style="width:70;">
								<option value="E">ETA</option>
								<option value="R">Rail ETA</option>
								<option value="S">EDI Send</option>
								</select></td>
							
							<td width="210"><input class="input1" type="text" style="width:78 ; text-transform:uppercase;" name="fm_dt" onKeyUp="chkField(this, 'date', false, null, null, '-')" onBlur="chkField(this, 'date', false, null, null, '-')">&nbsp;~&nbsp;<input class="input1" type="text" style="width:78" name="to_dt" onKeyUp="chkField(this, 'date', false, null, null, '-')" onBlur="chkField(this, 'date', false, null, null, '-')"> <img name="btn_calendar" class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle"></td>
							<td width="110">Equipment Office</td>
							<!--  <td><input class="input1" type="text" style="width:90; text-transform:uppercase;" name="s_neweq_office" value=<%=eqOfcCd%>>
							<img onClick="openAddPaste('s_neweq_office')" class="cursor" src="/hanjin/img/button/btng_plus.gif" width="19" height="20" border="0" align="absmiddle"></td>-->
							<td width="120">
							<script language="javascript">ComComboObject('s_neweq_office', 1, 100, 1);</script></td>
							<td width="95">&nbsp;Truck Status</td>
							<td width="90"><select name="t_truck_sts" style="width:70;">
								<option value="" selected>All</option>
								<option value="Y">Issued</option>
								<option value="N">NotIssued</option>
								</select>
							</td>
							<td width="85">EDI Status</td>
							<td width="90"><select name="t_edi_sts" style="width:70;">
							    <option value="ALL" selected>All</option>
								<option value="Y">Y</option>
								<option value="N">N</option>
								</select>
							</td>
						</tr>
					</table>
					<!-- <table class="search" border="0" style="width:750;">
						<tr class="h23">
							<td width="170"><img class="cursor" src="/hanjin/img/enis/ico_newwin.gif" width="11" height="12" align="absmiddle" hspace="5"><a href="javascript:openColumnList();" class="purple">Customized Report Form</a></td>
							<td><input name="col_items" Onkeydown="onEnterKey()" type="text" class="input" style="width:365; text-transform:uppercase;"  value="">
							</td>
							<td width="18"></td>
							<td>EQ Office</td>
							<td><input type="text" style="width:100" name="s_neweq_office" onKeyUp="chkField(this, 'eng_num', true, 5)"></td>
						</tr>
					</table> -->
					<table class="search_in" border="0">
						<tr class="h23">
							<td width="115">Rail Billing Status</td>
							<td width="100"><select name="t_rail_billing_sts" style="width:90;">
								<option value="" selected>All</option>
								<option value="Y">Issued</option>
								<option value="N">NotIssued</option>
								</select>
							</td>
							<td width="102">Service Provider</td>
							<td>

								<table border="0" style="height:15; width:100%; background-color: #E9E9E9;">
                                	<tr>
                                		<td class="sm" width="148" style="padding-left:10;">
                                			<input type="radio" class="trans" name="rad_vendor" value="V1" checked onClick="javascript:do_railroad('W');">Rail Road&nbsp;&nbsp;&nbsp;
											<input type="radio" class="trans" name="rad_vendor" value="V2" onClick="javascript:do_railroad('R');">WRS</td>

			                             <td>
											<div id="SV" style="display:none">
												<table class="search" border="0">
													<tr><td width="100"><input name="combo_svc_provider" type="text" style="width:80;" value="" maxlength="6" onBlur="vender_blur();"></td>
													<td><input type="text" name="trsp_so_vndr_no" style="width:250;" readonly value="" class="input2"><img src="" width="2" height="2"><img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btns_vender"></td></tr>
												</table>
											</div>
											<div id="SV" style="display:inline">
												<table class="search" border="0" >
													<tr><td"><%=selRailRoad%></td></tr>
												</table>
											</div>

									    </td>
									</tr>
                               	</table>

                            </td>
							<td width="75">Cost Mode</td>
							<td width="80"><select name="t_cost_mode" style="width:80;">
								<option value="" selected>All</option>
								<option value="R">Rail</option>
								<option value="D">Door</option>
								<option value="S">Shuttle</option>
								<option value="A">Additional(CY)</option>
								<!--  <option value="W">WATER</option>-->
								</select>
							</td>
						<!-- 	<td width="65"></td>
							<td width="110"></td>
							
							<td width="65">SO Office</td>
							<td ><input type="text" style="width:100" name="s_eq_office" onKeyUp="chkField(this, 'eng_num', true, 5)"></td>
							-->
						</tr>
					</table>
					<table class="search_in" border="0">
						<tr class="h23">
							<td width="65">S/C No</td>
							<td width=120><input type="text" style="width:100" name="s_sc_no" onKeyUp="chkField(this, 'eng_num', true, 9)"></td>
							<!-- <td>POL/POD</td> -->							
							<td width="100">Control Office</td>
							<td width="80">							
								<select name="cost_div" style="width:80;" onChange="changeCostDiv(this.value)">
									<option value="ALL" selected>All</option>
									<option value="PHXSA">PHXSA</option>
									<option value="TORSC">TORSC</option>
								</select>
							</td><td width="3"></td>
							<td width="120">
							<script language="javascript">ComComboObject('s_pol_pod', 1, 100, 1);</script></td>
							<!-- <input type="text" style="width:100" name="s_pol_pod" onKeyUp="chkField(this, 'eng_num', true, 5)"></td> -->
							<td width="35">DEL</td>
							<td width="120"><input type="text" style="width:100" class="input" name="s_del" onKeyUp="chkField(this, 'eng_num', true, 5)"></td>
							<td width="75">Rail DEST</td>
							<td width="145"><input type="text" style="width:100; text-transform:uppercase;" name="s_rail_dest" >
							<img onClick="openAddPaste('s_rail_dest')" class="cursor" src="/hanjin/img/button/btng_plus.gif" width="19" height="20" border="0" align="absmiddle"></td>
							<td width="85">End Status</td>
							<td><select name="t_end_sts" style="width:100;">
							<option value="" selected>All</option>
							<option value="Y">Finished</option>
							<option value="N">Progress</option>
							</select></td>
						</tr>
					</table>
					<table class="search_in" border="0">
						<tr class="h23">
							<td width="65">Location</td>
							<td width="120"><select name="s_c_loc" style="width:100;">
							<option value="I" selected>Inland</option>
							<option value="L">Local</option>
							<option value="">ALL</option>
							</select></td>
							<td width="35">VVD</td>
							<td width=90><input type="text" style="width:80" name="s_vvd" onKeyUp="chkField(this, 'eng_num', true, 9)"></td>
							<td width="35">Lane</td>
							<td width="80"><input type="text" style="width:60" name="s_lane" onKeyUp="chkField(this, 'eng_num', true, 3)"></td>
							
							<td width="35">P.No</td>
							<td width="120"><select name="t_p_no" style="width:100;">
							<option value="" selected>All</option>
							<option value="Y">Updated</option>
							<option value="N">NotUpdated</option>
							</select></td>
							<td width="75">P/UP Office</td>
							<td width="145"><input type="text" style="width:100" name="s_pup_office" onKeyUp="chkField(this, 'eng_num', true, 5)"></td>
							<td width="85">P/UP Status</td>
							<td><select name="t_pup_sts" style="width:100;">
							<option value="" selected>All</option>
							<!--  <option value="E">End</option>-->
							<option value="I">Issued</option>
							<option value="N">NotIssued</option>
							</select></td>
						</tr>

					</table>
					
					<table class="search_in" border="0">
						<tr class="h23">
							<td width="80">Booking No</td>
							<td width=145><input type="text" style="width:100" name="s_bkg_no" onKeyUp="chkField(this, 'eng_num', true)">
							<img onClick="openAddPaste('s_bkg_no')" class="cursor" src="/hanjin/img/button/btng_plus.gif" width="19" height="20" border="0" align="absmiddle"></td>
							<td width="90">Container No</td>
							<td width="145"><input type="text" style="width:100" name="s_cntr_no" onKeyUp="chkField(this, 'eng_num', true)">
							<img onClick="openAddPaste('s_cntr_no')" class="cursor" src="/hanjin/img/button/btng_plus.gif" width="19" height="20" border="0" align="absmiddle"></td>
							
							<td width="85">Master BKG</td>
							<td><select name="mst_bkg_sts" style="width:70;">
							<option value="" selected>All</option>
							<option value="Y">Y</option>
							<option value="N">N</option>
							</select></td>
                            <td width="85">MVMT</td>
                            <td><script language="javascript">ComComboObject("s_mvmt_cd", 1, 100, 1, 0, 0, 0, 11);</script>
                            </td>
							
						</tr>

					</table>

				</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->


		<table class="height_10"><tr><td></td></tr></table>


		<!-- TABLE '#D' : ( Tab BG Box ) (S) -->
     	<table class="search" border="0">
			<tr>
				<td class="bg">

					<table class="height_6" border="0">
						<tr>
							<td width="15%" class="gray" style="text-align:left;"><img class="cursor" src="/hanjin/img/alps/ico_newwin.gif" width="11" align="left" hspace="5"><a href="javascript:openColumnList();" class="purple">Customized Report Form</a></td>
							<td width="85%" class="gray" style="text-align:left;">When failed to get a data with ALPS warning message, optimize inquiry conditions, adjusting duration, adding options and removing unnecessary items like Shpr, Shpr address etc from "Customized Report Form".</td>
							<!-- <td width="7%"  class="gray" style="text-align:right;" >TotalCount</td>
							<td class="gray" style="text-align:right;"><input type="text" name="totcnt"  style="width:60" readonly style="text-align:right;border: 0px solid;background-color:#F3F2F8; " class="purple" ></td>
							 -->
						</tr>
					</table>
					<!-- : ( grid ) (S) -->
                    <table width="100%" id="mainTable">
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet1');</script>
                        </td></tr>
                        <tr style="display:none;"><td>
                             <script language="javascript">ComSheetObject('sheet2');</script>
                        </td></tr>
                    </table>

					<!-- : ( grid ) (E) -->


			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Tab BG Box ) (E) -->
		<!-- ####### TABLE '#D' ::: 'RIGHT' FRAME (END) ####### -->
		<table class="height_10"><tr><td></td></tr></table>

    </td></tr>
</table>
<!-- Outer Table (E)-->
</form>
<span id="new_form"></span>
</body>
</html>
