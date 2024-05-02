<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : VOP_VSK_0520.js
*@FileTitle : Vessel Summary
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.13
*@LastModifier : 임예지
*@LastVersion : 1.0
* 2014.10.13 임예지
* 1.0 Creation
* 
* History
* 2014.10.13 임예지 CHM-201430615 Vessel Particular Summary 화면 개발 - View option Popup 화면
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.vesselinformationmgt.event.VopVsk0519Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.Date" %>


<%
	VopVsk0519Event  	event 				= null;		//PDTO(Data Transfer Object including Parameters)
	Exception 			serverException   	= null;		//서버에서 발생한 에러
	String 				strErrMsg 			= "";		//에러메세지
	int 				rowCount	 		= 0;		//DB ResultSet 리스트의 건수

	String 				successFlag 		= "";
	String 				codeList  			= "";
	String 				pageRows  			= "100";

	String 				strUsr_id			= "";
	String 				strUsr_nm			= "";
	Logger 				log 				= Logger.getLogger("com.hanjin.apps.VesselOperationSupportMgt.vesselinformationmgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (VopVsk0519Event)request.getAttribute("Event");
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
<title>View Option</title>
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

<body  class="popup_bg" onLoad="setupPage();">
<form  name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->
<table width="100%" class="popup" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;padding-right:5;">
	<tr>
		<td class="top"></td>
	</tr>
	<tr>
		<td valign="top">
			<!-- : ( Title ) (S) -->
			<table width="100%" border="0">
				<tr>
					<td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;View Option</td>
				</tr>
			</table>
			<!-- : ( Title ) (E) -->
		
		
		<!--biz page (S)-->
		<table class="search" id="mainTable"> 
       		    <tr><td class="bg" style="height:405" valign="top">	
			
				<!--  <table class="search" border="0" style="width:600;"> 
				<tr class="h23">
					<td width="50">Row</td>
					<td width="120"><script language="javascript">ComComboObject('vsl_type', 1, 80, 1);</script></td>
					<td width="60">Columns</td>
					<td width="120" class="stm"><input type="text" style="width:50;text-align:center;ime-mode:disabled;" name="vsl_cd" maxlength="4" tabindex="2" ></td>
				</tr> 
				</table> -->	
				<!--  biz_1   (E) -->
				
			<table class="line_bluedot"><tr><td></td></tr></table>	
			
			
			
			<!-- Grid  (S) -->
				<table width="100%"  id="mainTable">
					<tr class="h23"> 
						<td>
							<table id="Table1" border="0" style="width:850;">
								<tr class="h23" style="height:25;">
									<td width="300"><input name="chk[]" id="sel_all"  		       			value="all" 					style="border:none;" type="checkbox" onclick="SelectCheckBox(this, 'Table1', 'sel');">&nbsp;ALL</td>
								</tr>                                                                                                           
								<tr style="height:25;">                                                                                         
									<td width="300"><input name="chk[]" id="sel1_capacity"  		       	value="capacity"  		       	   style="border:none;" type="checkbox" onclick="SelectCheckBox(this, 'Table1', 'sel1_');"><b>&nbsp;Capacity</b></td>
									<td width="100"><input name="chk[]" id="sel1_cntr_vsl_clss_capa"	    value="cntr_vsl_clss_capa"	       style="border:none;" type="checkbox" >&nbsp;Vessel Class</td>
									<td width="150"><input name="chk[]" id="sel1_cntr_dzn_capa"		    value="cntr_dzn_capa"		       style="border:none;" type="checkbox" >&nbsp;Design TEU</td>
									<td width="150"><input name="chk[]" id="sel1_cntr_pnm_capa"		    value="cntr_pnm_capa"		       style="border:none;" type="checkbox" >&nbsp;Panama</td>
								</tr>                                                                                                    
								                                                                                                         
								<tr style="height:25;">                                                                                  
									<td width="300"><input name="chk[]" id="sel2_identification"           value="identification"              style="border:none;" type="checkbox" onclick="SelectCheckBox(this, 'Table1', 'sel2_');"><b>&nbsp;Identification</b></td>
									<td width="100"><input name="chk[]" id="sel2_lloyd_no"				    value="lloyd_no"				       style="border:none;" type="checkbox" >&nbsp;IMO No.</td>
									<td width="100"><input name="chk[]" id="sel2_call_sgn_no"			    value="call_sgn_no"			       style="border:none;" type="checkbox" >&nbsp;Call Sign</td>
									<td width="100"><input name="chk[]" id="sel2_rgst_no"			        value="rgst_no"			           style="border:none;" type="checkbox" >&nbsp;Office No</td>
								</tr>                                                                                                    
								                                                                                                         
								<tr style="height:25;">	                                                                                 
									<td width="300"><input name="chk[]" id="sel3_clss"                    value="clss"                       style="border:none;" type="checkbox" onclick="SelectCheckBox(this, 'Table1', 'sel3_');"><b>&nbsp;Class</b></td>
									<td width="100"><input name="chk[]" id="sel3_clss_no_rgst_area_nm"	    value="clss_no_rgst_area_nm"	       style="border:none;" type="checkbox" >&nbsp;Class</td>
									<td width="100"><input name="chk[]" id="sel3_vsl_clss_no"			    value="vsl_clss_no"			       style="border:none;" type="checkbox" >&nbsp;Class No.</td>    
								</tr>                                                                                                    
								<tr style="height:25;">	                                                                                 
									<td width="300"><input name="chk[]" id="sel4_registry"                 value="registry"                    style="border:none;" type="checkbox" onclick="SelectCheckBox(this, 'Table1', 'sel4_');"><b>&nbsp;Registry</b></td>
									<td width="100"><input name="chk[]" id="sel4_cnt_cd"				    value="cnt_cd"				       style="border:none;" type="checkbox" >&nbsp;Flag</td>
									<td width="200"><input name="chk[]" id="sel4_cnt_nm"				    value="cnt_nm"				       style="border:none;" type="checkbox" >&nbsp;Port of Registry</td>
									<td width="100"><input name="chk[]" id="sel4_piclb_desc"			    value="piclb_desc"			       style="border:none;" type="checkbox" >&nbsp;P&I Club</td>                
								</tr>	                                                                                                 
								<tr style="height:25;">	                                                                                 
									<td width="300"><input name="chk[]" id="sel5_built_delivery_dt"        value="built_delivery_dt"           style="border:none;" type="checkbox" onclick="SelectCheckBox(this, 'Table1', 'sel5_');"><b>&nbsp;Built & Delivery date</b></td>
									<td width="200"><input name="chk[]" id="sel5_vsl_dldr_nm"			    value="vsl_dldr_nm"			       style="border:none;" type="checkbox" >&nbsp;Heavy Industry</td>
									<td width="100"><input name="chk[]" id="sel5_vsl_hl_no" 			    value="vsl_hl_no" 			       style="border:none;" type="checkbox" >&nbsp;Hull No.</td>
									<td width="150"><input name="chk[]" id="sel5_vsl_kel_ly_dt" 		    value="vsl_kel_ly_dt" 		       style="border:none;" type="checkbox" >&nbsp;Keel Laid DT</td>
								</tr>                                                                                                    
								<tr>                                                                                                      
									<td width="300"></td>	                                                                             
									<td width="150"><input name="chk[]" id="sel5_vsl_inch_dt" 			    value="vsl_lnch_dt" 			       style="border:none;" type="checkbox" >&nbsp;Launched DT</td>
									<td width="150"><input name="chk[]" id="sel5_vsl_de_dt" 			    value="vsl_de_dt" 			       style="border:none;" type="checkbox" >&nbsp;Delivered DT</td>
									<td width="150"><input name="chk[]" id="sel5_rgst_dt" 				    value="rgst_dt" 				       style="border:none;" type="checkbox" >&nbsp;Registered DT</td>        		
								</tr>	                                                                                                 
								<tr style="height:25;">	                                                                                 
									<td width="300"><input name="chk[]" id="sel6_communication"   		    value="communication"   		       style="border:none;" type="checkbox" onclick="SelectCheckBox(this, 'Table1', 'sel6_');"><b>&nbsp;Communication</b></td>
									<td width="100"><input name="chk[]" id="sel6_phn_no" 				    value="phn_no" 				       style="border:none;" type="checkbox" >&nbsp;TEL No.</td>
									<td width="100"><input name="chk[]" id="sel6_fax_no" 				    value="fax_no" 				       style="border:none;" type="checkbox" >&nbsp;Fax No.</td>
									<td width="100"><input name="chk[]" id="sel6_tlx_no" 				    value="tlx_no" 				       style="border:none;" type="checkbox" >&nbsp;TLX No.</td>
									<td width="100"><input name="chk[]" id="sel6_vsl_eml" 				    value="vsl_eml" 				       style="border:none;" type="checkbox" >&nbsp;E-Mail</td>   
								</tr>	                                                                                                 
								<tr style="height:25;">	                                                                                 
									<td width="300"><input name="chk[]" id="sel7_reefer"                   value="reefer"                      style="border:none;" type="checkbox" onclick="SelectCheckBox(this, 'Table1', 'sel7_');"><b>&nbsp;Reefer</b></td>
									<td width="100"><input name="chk[]" id="sel7_rf_rcpt_knt" 			    value="rf_rcpt_knt" 			       style="border:none;" type="checkbox" >&nbsp;Operation</td>
									<td width="100"><input name="chk[]" id="sel7_rf_rcpt_max_knt" 		    value="rf_rcpt_max_knt" 		       style="border:none;" type="checkbox" >&nbsp;Max.</td>  
								</tr>                                                                                                   
								<tr style="height:25;">	                                                                                
									<td width="300"><input name="chk[]" id="sel8_speed"                    value="speed"                       style="border:none;" type="checkbox" onclick="SelectCheckBox(this, 'Table1', 'sel8_');"><b>&nbsp;Speed</b></td>
									<td width="100"><input name="chk[]" id="sel8_ecn_spd" 				    value="ecn_spd" 				       style="border:none;" type="checkbox" >&nbsp;MIN.</td>
									<td width="100"><input name="chk[]" id="sel8_vsl_svc_spd" 			    value="vsl_svc_spd" 			       style="border:none;" type="checkbox" >&nbsp;Service</td>
									<td width="100"><input name="chk[]" id="sel8_max_spd" 				    value="max_spd" 				       style="border:none;" type="checkbox" >&nbsp;MAX.</td>   
								</tr>	                                                                                                 
								<tr style="height:25;">	     		                                                                     
									<td width="300"><input name="chk[]" id="sel9_dimension"       		    value="dimension"       		       style="border:none;" type="checkbox" onclick="SelectCheckBox(this, 'Table1', 'sel9_');"><b>&nbsp;Dimension</b></td>
									<td width="100"><input name="chk[]" id="sel9_loa_len" 				    value="loa_len" 				       style="border:none;" type="checkbox" >&nbsp;L.O.A</td>
									<td width="100"><input name="chk[]" id="sel9_lbp_len" 				    value="lbp_len" 				       style="border:none;" type="checkbox" >&nbsp;L.B.P</td>
									<td width="100"><input name="chk[]" id="sel9_vsl_wdt" 				    value="vsl_wdt" 				       style="border:none;" type="checkbox" >&nbsp;Breadth</td>
									<td width="100"><input name="chk[]" id="sel9_vsl_dpth" 			    value="vsl_dpth" 			      	style="border:none;" type="checkbox" >&nbsp;Depth</td>
								</tr>                                                                                                    
								<tr>                                                                                                     
									<td width="300"></td>	                                                                             
									<td width="100"><input name="chk[]" id="sel9_vsl_hgt" 				    value="vsl_hgt" 				       style="border:none;" type="checkbox" >&nbsp;Height</td>
									<td width="200"><input name="chk[]" id="sel9_smr_drft_hgt" 		    value="smr_drft_hgt" 		       style="border:none;" type="checkbox" >&nbsp;Summer Draft</td>
									<td width="100"><input name="chk[]" id="sel9_fbd_capa" 			    value="fbd_capa" 			       style="border:none;" type="checkbox" >&nbsp;Freeboard</td>
								</tr>                                                                                                    
								<tr style="height:25;">	                                                                                 
									<td width="300"><input name="chk[]" id="sel10_tonnage"                 value="tonnage"                    style="border:none;" type="checkbox" onclick="SelectCheckBox(this, 'Table1', 'sel10_');"><b>&nbsp;Tonnage</b></td>
									<td width="100"><input name="chk[]" id="sel10_dpl_capa" 			    value="dpl_capa" 			       style="border:none;" type="checkbox" >&nbsp;Displacement</td>
									<td width="100"><input name="chk[]" id="sel10_dwt_wgt" 				value="dwt_wgt" 				   style="border:none;" type="checkbox" >&nbsp;Dead Weight</td>
									<td width="100"><input name="chk[]" id="sel10_lgt_shp_tong_wgt" 	    value="lgt_shp_tong_wgt" 	       style="border:none;" type="checkbox" >&nbsp;Light Ship</td>
								</tr>	                                                                                                
								<tr style="height:25;">	                                                                                
									<td width="300"><input name="chk[]" id="sel11_gross_tons"              value="gross_tons"                 style="border:none;" type="checkbox" onclick="SelectCheckBox(this, 'Table1', 'sel11_');"><b>&nbsp;Gross Tons</b></td>              
									<td width="100"><input name="chk[]" id="sel11_grs_rgst_tong_wgt" 	    value="grs_rgst_tong_wgt" 	       style="border:none;" type="checkbox" >&nbsp;International</td>
									<td width="100"><input name="chk[]" id="sel11_pnm_gt_wgt" 			    value="pnm_gt_wgt" 			       style="border:none;" type="checkbox" >&nbsp;Panama</td>
									<td width="100"><input name="chk[]" id="sel11_suz_gt_wgt" 			    value="suz_gt_wgt" 			       style="border:none;" type="checkbox" >&nbsp;Suez</td>
								</tr>                                                                                                   
								<tr style="height:25;">	                                                                                
									<td width="300"><input name="chk[]" id="sel12_net_tons"                value="net_tons"                   style="border:none;" type="checkbox" onclick="SelectCheckBox(this, 'Table1', 'sel12_');"><b>&nbsp;Net Tons</b></td>
									<td width="100"><input name="chk[]" id="sel12_net_rgst_tong_wgt" 	    value="net_rgst_tong_wgt" 	       style="border:none;" type="checkbox" >&nbsp;International</td>
									<td width="100"><input name="chk[]" id="sel12_pnm_net_tong_wgt" 	    value="pnm_net_tong_wgt" 	       style="border:none;" type="checkbox" >&nbsp;Panama</td>
									<td width="100"><input name="chk[]" id="sel12_suz_net_tong_wgt" 	    value="suz_net_tong_wgt" 	       style="border:none;" type="checkbox" >&nbsp;Suez(KR)</td>
									<td width="150"><input name="chk[]" id="sel12_madn_voy_suz_net_tong_wgt" value="madn_voy_suz_net_tong_wgt"    style="border:none;" type="checkbox" >&nbsp;Suez(Maiden)</td>
									<td width="100"><input name="chk[]" id="sel12_intl_tong_certi_flg" 	value="intl_tong_certi_flg" 	   style="border:none;" type="checkbox" >&nbsp;ITC</td>  
								</tr>                                                                                                  
								<tr style="height:25;">	                                                                               
									<td width="300"><input name="chk[]" id="sel13_tank_capacity"           value="tank_capacity"              style="border:none;" type="checkbox" onclick="SelectCheckBox(this, 'Table1', 'sel13_');"><b>&nbsp;Tank Capacity</b></td>
									<td width="100"><input name="chk[]" id="sel13_foil_capa" 			    value="foil_capa" 			       style="border:none;" type="checkbox" >&nbsp;F.O(85%)</td>
									<td width="100"><input name="chk[]" id="sel13_doil_capa" 			    value="doil_capa" 			       style="border:none;" type="checkbox" >&nbsp;D.O(85%)</td>
									<td width="150"><input name="chk[]" id="sel13_frsh_wtr_capa" 		    value="frsh_wtr_capa" 		       style="border:none;" type="checkbox" >&nbsp;F.W(100%)</td>
									<td width="150"><input name="chk[]" id="sel13_blst_tnk_capa" 		    value="blst_tnk_capa" 		       style="border:none;" type="checkbox" >&nbsp;Ballast(100%)</td>  
								</tr>                                                                                                   
								<tr style="height:25;">	      	                                                                        
									<td width="300"><input name="chk[]" id="sel14_consumption"        	    value="consumption"        	       style="border:none;" type="checkbox" onclick="SelectCheckBox(this, 'Table1', 'sel14_');"><b>&nbsp;Consumption</b></td>
									<td width="100"><input name="chk[]" id="sel14_foil_csm" 			    value="foil_csm" 			       style="border:none;" type="checkbox" >&nbsp;F.O</td>
									<td width="100"><input name="chk[]" id="sel14_doil_csm" 			    value="doil_csm" 			       style="border:none;" type="checkbox" >&nbsp;D.O</td>
									<td width="100"><input name="chk[]" id="sel14_frsh_wtr_csm" 		    value="frsh_wtr_csm" 		       style="border:none;" type="checkbox" >&nbsp;F.W</td> 
								</tr>                                                                                                   
								<tr style="height:25;">	                                                                                
									<td width="300"><input name="chk[]" id="sel15_main_engine"             value="main_engine"                style="border:none;" type="checkbox" onclick="SelectCheckBox(this, 'Table1', 'sel15_');"><b>&nbsp;Maine Engine</b></td>
									<td width="100"><input name="chk[]" id="sel15_mn_eng_mkr_nm" 		    value="mn_eng_mkr_nm" 		       style="border:none;" type="checkbox" >&nbsp;Maker</td>  
									<td width="100"><input name="chk[]" id="sel15_mn_eng_tp_desc" 		    value="mn_eng_tp_desc" 		       style="border:none;" type="checkbox" >&nbsp;Type</td>   
									<td width="100"><input name="chk[]" id="sel15_mn_eng_bhp_pwr" 		    value="mn_eng_bhp_pwr" 		       style="border:none;" type="checkbox" >&nbsp;BHP/KW</td> 
									<td width="100"><input name="chk[]" id="sel15_mn_eng_rpm_pwr" 		    value="mn_eng_rpm_pwr" 		       style="border:none;" type="checkbox" >&nbsp;RPM</td>
								</tr>                                                                                                  
								<tr style="height:25;">	                                                                               
									<td width="300"><input name="chk[]" id="sel16_generator_engine"        value="generator_engine"           style="border:none;" type="checkbox" onclick="SelectCheckBox(this, 'Table1', 'sel16_');"><b>&nbsp;Generator Engine</b></td>
									<td width="100"><input name="chk[]" id="sel16_gnr_mkr_nm" 			    value="gnr_mkr_nm" 			       style="border:none;" type="checkbox" >&nbsp;Maker</td> 
									<td width="100"><input name="chk[]" id="sel16_gnr_tp_desc" 			value="gnr_tp_desc" 			   style="border:none;" type="checkbox" >&nbsp;Type</td>  
									<td width="100"><input name="chk[]" id="sel16_gnr_bhp_pwr" 			value="gnr_bhp_pwr" 			   style="border:none;" type="checkbox" >&nbsp;BHP/KW</td>
									<td width="100"><input name="chk[]" id="sel16_gnr_rpm_pwr" 			value="gnr_rpm_pwr" 			   style="border:none;" type="checkbox" >&nbsp;RPM</td>
								</tr>                                                                                                   
								<tr style="height:25;">	              	                                                                
									<td width="300"><input name="chk[]" id="sel17_bow_thrust"          	value="bow_thrust"          	   style="border:none;" type="checkbox" onclick="SelectCheckBox(this, 'Table1', 'sel17_');"><b>&nbsp;Bow Thrust</b></td>
									<td width="100"><input name="chk[]" id="sel17_bwthst_mkr_nm" 		    value="bwthst_mkr_nm" 		       style="border:none;" type="checkbox" >&nbsp;Maker</td> 
									<td width="100"><input name="chk[]" id="sel17_bwthst_tp_desc" 		    value="bwthst_tp_desc" 		       style="border:none;" type="checkbox" >&nbsp;Type</td>  
									<td width="100"><input name="chk[]" id="sel17_bwthst_bhp_pwr" 		    value="bwthst_bhp_pwr" 		       style="border:none;" type="checkbox" >&nbsp;BHP/KW</td>
									<td width="100"><input name="chk[]" id="sel17_bwthst_rmp_pwr" 		    value="bwthst_rmp_pwr" 		       style="border:none;" type="checkbox" >&nbsp;RPM</td>
								</tr>                                                                                                  
								<tr style="height:25;">	               	                                                               
									<td width="300"><input name="chk[]" id="sel18_rpm_slow_steaming"   	value="rpm_slow_steaming"   	   style="border:none;" type="checkbox" onclick="SelectCheckBox(this, 'Table1', 'sel18_');"><b>&nbsp;RPM & Slow Steaming</b></td>
									<td width="250"><input name="chk[]" id="sel18_ctcl_rpm_no" 			value="ctcl_rpm_no" 			   style="border:none;" type="checkbox" >&nbsp;Critical RPM Zone(From)</td>
									<td width="250"><input name="chk[]" id="sel18_ctcl_to_rpm_no" 		    value="ctcl_to_rpm_no" 		       style="border:none;" type="checkbox" >&nbsp;Critical RPM Zone(To)</td>
									<td width="150"><input name="chk[]" id="sel18_op_min_rpm_no" 		    value="op_min_rpm_no" 		       style="border:none;" type="checkbox" >&nbsp;OPS MIN. RPM</td>
									<td width="200"><input name="chk[]" id="sel18_op_min_spd" 			    value="op_min_spd" 			       style="border:none;" type="checkbox" >&nbsp;OPS MIN. Speed</td>
								</tr>                                                                                                   
								<tr>                                                                                                    
								    <td width="300"></td>	                                                                            
									<td width="150"><input name="chk[]" id="sel18_slow_stmng_flg" 		    value="slw_stmng_flg" 		       style="border:none;" type="checkbox" >&nbsp;Slow Steaming</td>
									<td width="250"><input name="chk[]" id="sel18_spr_slw_stmng_flg" 	    value="spr_slw_stmng_flg" 	       style="border:none;" type="checkbox" >&nbsp;Super Slow Steaming</td>
									<td width="200"><input name="chk[]" id="sel18_fuel_sav_eq_flg" 		value="fuel_sav_eq_flg" 		   style="border:none;" type="checkbox" >&nbsp;Fuel Saving Equip</td>
									<td width="100"><input name="chk[]" id="sel18_vsl_lod_rto" 			value="vsl_lod_rto" 			   style="border:none;" type="checkbox" >&nbsp;Load(%)</td>
								</tr>                                                                                                         
								<tr style="height:25;">	                                                                                      
									<td width="300"><input name="chk[]" id="sel19_design_max_load_holddeck" value="design_max_load_holddeck"   style="border:none;" type="checkbox" onclick="SelectCheckBox(this, 'Table1', 'sel19_');"><b>&nbsp;Design Max Load Hold/Deck</b></td>
									<td width="150"><input name="chk[]" id="sel19_in_hld_per_tr_knt" 	    value="in_hld_per_tr_knt" 	       style="border:none;" type="checkbox" >&nbsp;In Hold by Tier</td>
									<td width="150"><input name="chk[]" id="sel19_in_hld_per_row_knt" 	    value="in_hld_per_row_knt" 	       style="border:none;" type="checkbox" >&nbsp;In Hold by Row</td>
									<td width="100"><input name="chk[]" id="sel19_htch_cvr_in_hld_knt" 	value="htch_cvr_in_hld_knt" 	   style="border:none;" type="checkbox" >&nbsp;H/C in Hold</td>
								</tr>                                                                                                   
								<tr>                                                                                                    
									<td width="300"></td>                                                                               
									<td width="150"><input name="chk[]" id="sel19_on_deck_per_tr_knt" 	    value="on_deck_per_tr_knt" 	       style="border:none;" type="checkbox" >&nbsp;O/Deck by Tier</td>
									<td width="150"><input name="chk[]" id="sel19_on_deck_per_row_knt" 	value="on_deck_per_row_knt" 	   style="border:none;" type="checkbox" >&nbsp;O/Deck by Row</td>
								</tr>                                                                                                   
								<tr style="height:25;">	                                                                                
									<td width="300"><input name="chk[]" id="sel20_other"                   value="other"                       style="border:none;" type="checkbox" onclick="SelectCheckBox(this, 'Table1', 'sel20_');"><b>&nbsp;Other</b></td>
									<td width="100"><input name="chk[]" id="sel20_crw_knt" 				value="crw_knt" 				    style="border:none;" type="checkbox" >&nbsp;Max. Crew</td>
									<td width="100"><input name="chk[]" id="sel20_amp_tp_cd" 				value="amp_tp_cd" 				    style="border:none;" type="checkbox" >&nbsp;AMP Type</td>
								</tr>                                                                                                           
							</table>
						</td>
					</tr>
				</table>
			</td></tr>
		</table>
		<!--biz page (E)-->


		<table class="height_10"><tr><td></td></tr></table>
		</td></tr>
		</table> 


			
		<table width="100%" class="sbutton">
			<tr><td height="71" class="popup">
			<!-- Button (S) -->
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
	       	<tr><td class="btn3_bg">
			    <table border="0" cellpadding="0" cellspacing="0">
			    <tr>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left">
						<td class="btn1" name="btn_ok" value="btn_ok" >OK</td>
						<td class="btn1_right">
						</tr>
					</table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_close">Close</td>
						<td class="btn1_right"></td>
						</tr>
					</table></td>
				</tr>
				</table></td>
			</tr>
			</table></td>
			<!-- Button (E) -->
					
		</tr>
		</table>
			

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>