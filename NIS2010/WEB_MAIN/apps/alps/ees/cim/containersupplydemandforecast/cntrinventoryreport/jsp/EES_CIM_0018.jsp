﻿<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_cim_0018.jsp
*@FileTitle : Container List by Location
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.08
*@LastModifier : 김종준
*@LastVersion : 1.0
* 2009.06.08 김종준
* 1.0 Creation
* --------------------------------------------------------
* History 
* 20110513 NKJH[CHM-201110740-01]M/Date 조회조건 추가
* 2012.02.08 신자영 [CHM-201216058-01] [CIM] Land Inventory with cntr list 기능 보완
* 2012.02.27 신자영 [CHM-201216476-01] LAND INVENTORY / LANDINVENTORY WITH CNTR LIST 기능 수정
* 2012.04.17 신자영 [CHM-201217350-01] [CIM] SPEED 기능 삭제
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.cim.containersupplydemandforecast.cntrinventoryreport.event.EesCim0018Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesCim0018Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	
    String cnmv_sts_cd = "";
    String cnmv_sts_nm = "";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (EesCim0018Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		//MVMT Status 멀티콤보 
	    String temp_cnmv_sts_cd = JSPUtil.getIBCodeCombo("", "", "CD02086", 0, "");
	    if(temp_cnmv_sts_cd != null && temp_cnmv_sts_cd.length() > 8) {
	    	cnmv_sts_cd = temp_cnmv_sts_cd.substring(temp_cnmv_sts_cd.indexOf("Code = \"")+8, temp_cnmv_sts_cd.lastIndexOf("\""));
	    	cnmv_sts_nm = temp_cnmv_sts_cd.substring(temp_cnmv_sts_cd.indexOf("Text = \"")+8, temp_cnmv_sts_cd.indexOf("\";")); 
	    }						
	    
		
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Welcome to alps!</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>

<script language="javascript">

    function setupPage(){  

	    loadPage("<%=cnmv_sts_cd%>", "<%=cnmv_sts_nm%>");
    }

</script>


<body  onLoad="setupPage();"> 

<form name="form"> 
<input type="hidden" name="f_cmd">
<input type="hidden" name="head_cntr_tpsz_cd" value=""> 
<input type="hidden" name="cnt_cd" value=""> 
<input type="hidden" name="inquiryLevel" value=""> 
<input type="hidden" name="location" value=""> 

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!--Page Title, Historical (E)-->
	</td></tr>
	
	<tr><td valign="top">
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:2;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_new">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_downexcel">Down&nbsp;Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			</tr>
			</table>
		</td></tr>
		</table>
    <!--Button (E) -->
	
	<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="83">Location</td>
					<td width="186">
						<select style="width:54;" name="loc_type_code" class="input" ><!-- LOC_TYPE_CODE -->
							<option value="1"> RCC</option>
							<option value="2"> LCC</option>
							<option value="3"> ECC</option>
							<option value="4"> SCC</option>
							<option value="5"> Yard</option>
						</select> <input type="text" class="input1" name="loc_cd" style="ime-mode:inactive" dataformat="engup" size="7" maxlength="7" fulfill  style="width:65;" class="input" value=""> <img class="cursor" src="img/btns_search.gif" name="btn_loc_cd" width="19" height="20" border="0" align="absmiddle">
					</td>
					<td width="75">Cargo type</td>
					<td width="100">
						<select name="full_flg" style="width:80;" class="input">
							<option value="" selected></option>
							<option value="Y">Full</option>
							<option value="N">MTY</option>
						</select>
					</td>
					
					<td width="100">IMM. Exit<input type="checkbox" name="imdt_ext_flg" value="Y" class="trans"></td>
					<td width="123">Plastic Floor<input type="checkbox" name="plst_flr_flg" value="Y" class="trans"></td>
					<td width="52">&nbsp;DMG</td> 
					<td width="130">
						<select name="dmg_flg" style="width:75;" class="input">
							<option value="" selected>Include</option>
							<option value="N">Exclude</option>
							<option value="Y">Only</option>
						</select>
					</td>
					
					<td width="60">Company</td>
					<td width="">
						<input type="text" class="input" name="tem_cntr_use_co_cd" readOnly=true style="width:30;" class="input" value="SML">
						<input type="hidden" name="cntr_use_co_cd" value="H">
					</td>
					
					</tr> 
					<tr><td style="height:1"></td></tr>
				</table>
				
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="85">TP/SZ</td>
					<td width="180">
						<script language="javascript">ComComboObject('cntr_tpsz_cd', 1, 147, 1);</script>
						<!-- <input type="checkbox" class="input2" name="chk_cntr_tpsz_cd" class="input" value=""> -->					
					</td>
					<td width="406">
						<table class="search_sm2" border="0" style="width:372;"> 
						<tr class="h23">
							<td width="60">Reefer</td>
							<td width="" class="stm">
								<input type="checkbox" name="rf_tp_cd_c" value="C" class="trans">CA&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<input type="checkbox" name="rf_tp_cd_h" value="H" class="trans">HU&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<input type="checkbox" name="rf_tp_cd_m" value="M" class="trans">MG&nbsp;&nbsp;&nbsp; 
								<input type="checkbox" name="rf_cntr" value="N" class="trans">Reefer
								<input type="checkbox" name="rd_cgo_flg" value="Y" class="trans">R/D								
							</td>
						</tr>
					</table>
					</td>
					<td width="48">S.O.C</td> 
					<td width="131">
						<select name="soc_cd" style="width:75;" class="input">
							<option value="1">Exclude</option>
							<option value=""selected>Include</option>
							<option value="2">Only</option>
						</select>
					</td>
					<td width="58">Unclaim</td> 
					<td><select name="uclm_ls_div_cd" style="width:70;" class="input">
						<option value="E">Exclude</option>	
						<option value="I" selected>Include</option> 
						<option value="O">Only</option>
						</select></td>

					</tr> 
					<tr><td style="height:1"></td></tr>
				</table>
				
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="85">MVMT Status</td>
					<td width="180">
						<script language="javascript">ComComboObject('cnmv_sts_cd', 1, 147, 1);</script>
						<!-- <input type="checkbox" class="input2" name="chk_cnmv_sts_cd" readOnly=true  class="input" value=""> -->
					</td>
					<td width="406">
						<table class="search_sm2" border="0" style="width:372;"> 
						<tr class="h23">
							<td width="60">EQ MGMT</td>
							<td width="" class="stm">
								<input type="checkbox" name="cntr_hngr_rck_cd" value="Y" class="trans">Hanger Rack/Bar
								<input type="checkbox" name="disp_flg" value="Y" class="trans">DPSL&nbsp;&nbsp;
								<input type="checkbox" name="d2_payld_flg" value="Y" class="trans">D2-LP
								<input type="checkbox" name="off_hire_flg" value="Y" class="trans">Off-hire
								<input type="checkbox" name="dg_flg" value="Y" class="trans">DG
								<input type="checkbox" name="psa_no" value="Y" class="trans">PSA Group
							</td>
						</tr>
						</table>
					</td>
					<td width="80">Staying Day</td>
					<td width="100" class="stm">
						<input type="text" name="over_stay_days" style="width:40; text-align:right;" dataformat="int" class="input" value="">&nbsp;or over
					</td>
					<td width="58">Prefix</td>
					<td width=""><input type="text" name="cntr_no" style="width:40;" dataformat="engup" size="4" maxlength="4" fulfill class="input" value=""></td>
					
				</tr> 
				<tr><td style="height:1"></td></tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="85">Lease Term</td>
						<td width="180">
							<script language="javascript">ComComboObject('lstm_cd', 1, 147, 1);</script>
							<!-- <input type="checkbox" class="input2" name="chk_lstm_cd" readOnly=true  class="input" value=""> -->
						</td>
						<td width="162">
							<table class="search_sm2" border="0" style="width:97%;"> 
								<tr class="h23">
									<td width="55">View</td>
									<td width="150" class="stm"><input type="radio" name="view_flg" value="eq" checked class="trans">EQ&nbsp;&nbsp;<input type="radio" name="view_flg" value="bkg" class="trans">BKG</td>
								</tr>
							</table>
						</td>
						<td width="290">
						<div id = "div_eq" style = "display:''" >
							<table class="search" border="0" style="width:250;"> 
								<tr class="h23">
									<td width="55">M/Date</td>
									<td width="190">
									<input type="text" style="width:50;text-align:center;" class="input" value="" name="froms" caption="M/Date FM"  dataformat="yyyy" maxlength="4">&nbsp;&nbsp;~&nbsp;&nbsp;
									<input type="text" style="width:50;text-align:center;" class="input" value="" name="tos" caption="M/Date TO"  dataformat="yyyy"  maxlength="4"></td>
								</tr>
							</table>
						</div>
						<div id = "div_bkg" style = "display:'none'" >
							<input type="checkbox" name="ts_cntr_behind" disabled=true class="trans" value="Y">T/S Behind ATD of Load VVD <input type="text" name="next_vvd" disabled=true style="ime-mode:inactive" dataformat="engup" size="9" maxlength="9" fulfill style="width:80;" class="input2" value="" >
						</div>
						</td>
						<td width="">
							<table class="search_sm2" border="0" style="width:100%;"> 
								<tr class="h23">
									<td width="80">Add Info</td>
									<td width="175" class="stm">
										<input type="checkbox" name="view_customer" value="Y" class="trans">Customer
										<input type="checkbox" name="view_commodity" value="Y" class="trans">CMDT
									</td>
								</tr>
							</table>
						</td>
						<td width="">&nbsp;&nbsp;Speed</td>
						<td width=""><input type="checkbox" name="speed" value="Y"></td>



					</tr> 
				</table>
				<!--  biz_1   (E) -->
				
				<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
				
				
			<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table> 			
			<!-- Grid (E) -->

					
			

			<!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0"><tr>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_movement">Movement</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_master">&nbsp;&nbsp;&nbsp;Master&nbsp;&nbsp;&nbsp;</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
					</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
			</td></tr>
		</table>
	<!-- Tab BG Box  (S) -->
	<!--biz page (E)-->
	
	
	<table class="height_10"><tr><td colspan="8"></td></tr></table>
		</td></tr>
	</table>
</form>
</body>
</html>