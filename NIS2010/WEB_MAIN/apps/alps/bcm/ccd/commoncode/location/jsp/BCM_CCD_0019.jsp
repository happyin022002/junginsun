<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : BCM_CCD_0019.jsp
*@FileTitle  : Location 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/10
=========================================================*/
%> 
  
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.bcm.ccd.commoncode.location.event.BcmCcd0019Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    BcmCcd0019Event  event = null;              //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //Error from server
    String strErrMsg = "";                      //Error message
    int rowCount     = 0;                       //Count of DB resultSet list
    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";
    String strUsr_id        = "";
    String strUsr_nm        = "";
    Logger log = Logger.getLogger("com.hanjin.apps.commoncode.location");
    // 승인처리용 정보
    String rqstNo       = JSPUtil.getParameter(request, "rqst_no");
    String procTpCd     = JSPUtil.getParameter(request, "proc_tp_cd");
    String rqstUsrChk   = JSPUtil.getParameter(request, "rqst_usr_chk");
    String rqstOfcCd    = JSPUtil.getParameter(request, "rqst_ofc_cd");
    String mainPage 		= "";
    mainPage = request.getParameter("main_page");
    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
        event = (BcmCcd0019Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
    } catch(Exception e) {
        out.println(e.toString());
    }
%>

<html>
<head>
<title>Location</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
    var G_MDAA_CHK;
    var G_AHTU_TP_CD;
    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            ComShowMessage(errMessage);
        } // end if
        loadPage();
    }
</script>
</head>

<body onLoad="setupPage();">
<form name="form" id="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="ibflag" id="ibflag" />
<input type="hidden" name="creflag" id="creflag" value="Y" />
<input type="hidden" name="mst_dat_subj_cd" id="mst_dat_subj_cd" value="LOCA" />
<input type="hidden" name="rqst_no" id="rqst_no" value="<%=rqstNo%>" />
<input type="hidden" name="proc_tp_cd" id="proc_tp_cd" value="<%=procTpCd%>" />
<input type="hidden" name="rqst_usr_chk" id="rqst_usr_chk" value="<%=rqstUsrChk%>" />
<input type="hidden" name="rqst_ofc_cd" id="rqst_ofc_cd" value="<%=rqstOfcCd%>" />
<input type="hidden" name="mdm_yn" id="mdm_yn" value="Y" />
<input type="hidden" name="old_un_loc_cd" id="old_un_loc_cd" value="" />
<input type="hidden" name="edi_if_flg" id="edi_if_flg" />
<input type="hidden" name="onchange_flag">

<table width="100%" cellpadding="0" cellspacing="0" style="padding-top:2; padding-left:5;">
	<tr>
		<td class="top"></td>
	</tr>
	<tr>
		<td valign="top">
		
			<!-- Page Title, Historical (S) -->
			<table width="100%" cellpadding="0" cellspacing="0" class="title">
				<tr>
					<td class="history">
						<img src="img/icon_history_dot.gif" align="absmiddle">
						<span id="navigation"></span>
					</td>
				</tr>
				<tr>
					<td class="title">
						<img src="img/icon_title_dot.gif" align="absmiddle">
						<span id="title">
							&nbsp; Location						
						</span>
					</td>
				</tr>
			</table>
			<!-- Page Title, Historical (E) -->

		    	<!-- opus_design_btn(S) -->
				<!-- <div class="opus_design_btn">
		        <button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve" style="display: none">Retrieve</button>
		        <button type="button" class="btn_normal" name="btn_Save" id="btn_Save" style="display: none">Save</button>
		        <button type="button" class="btn_normal" name="btn_Request" id="btn_Request" style="display: none">Request</button>
		        <button type="button" class="btn_normal" name="btn_New" id="btn_New" style="display: none">New</button>
		        <button type="button" class="btn_normal" name="btn_Close" id="btn_Close" style="display: none">Close</button>
		        </div> -->    
			
			<table width="100%" class="search" id="leftTable">
				<tr>
					<td width="120">
					</td>
				</tr>
			</table>
			
		<!-- biz Page (S) -->
			
			<!-- biz_1 (S) -->	
			<table class="search" id="mainTable">
				<tr>
					<td class="bg">
						<table class="search" style="width:979;">
							<tr class="h23">
			                    <td width="130" align="right" style="padding-right:4px;">Location Code</td>
			                    <td>
			                    	<input id="loc_cd" style="width: 120px; ime-mode:disabled;text-align:center" class="input1" name="loc_cd" dataformat="engup" maxlength="5" type="text" onBlur="obj_change();"/>
									<img src="img/btns_search.gif" name="btns_search1" id="btns_search1" width="19" height="20" alt="0" border="0" align="absmiddle" class="cursor"> 
			                    </td>
<!-- 			                
								<td>VIP Code</td>
			                    <td><input type="text" style="width:150px;text-align:center;" class="input1" dataformat="engup" id="modi_loc_cd" name="modi_loc_cd" maxlength="30"></td>
			                    <td>Legacy UUID</td>
			                    <td><input type="text" style="width:150px;text-align:center;" class="input" dataformat="engup" id="modi_loc_cd2" name="modi_loc_cd2" maxlength="30" ReadOnly></td>
 -->							
 							</tr>
						</table>
						<table class="line_bluedot">
							<tr>
								<td></td>
							</tr>
						</table>	
						<table class="search" style="width:979;">
							<tr class="h23">
								<td width="130" align="right" style="padding-right:4px;">English Name</td>
			                    <td><input id="loc_nm" style="width: 350px; ime-mode: disabled;" class="input1" name="loc_nm" dataformat="etc"  otherchar="()_\-,. " maxlength="50" type="text" /></td>
			                    <td align="right" style="padding-right:4px;">Local Name</td>
			                    <td><input id="loc_locl_lang_nm" style="width: 350px;" class="input" name="loc_locl_lang_nm" maxlength="200" type="text" onBlur="obj_change();"/></td>
							</tr>
						</table>
						<table class="search" style="width:979;">
							<tr class="h23">
								<td width="130" align="right" style="padding-right:6px;">Character</td>
			                    <td width="205"><script type="text/javascript">ComComboObject('loc_chr_cd', 1, 200, 1, 1, 0);</script></td>
			                    <td width="211">
			                    	<table>
			                    		<tr><td>
					                    	<input type="checkbox" id="call_port_flg" name="call_port_flg" class="trans" value="Y" />
					                    	<lable for="call_port_flg">Calling Port</lable>
			                    		</td></tr>
			                    	</table>
			                    </td>
			                    <td align="right" style="padding-right:4px;">Port</td>
			                    <td>
			                    	<select style="width: 45px;" class="input1" name="port_inlnd_flg">
				                    	<option value="N" selected>N</option>
				                    	<option value="Y">Y</option>
			                    	</select>
			                    </td>
			                    <td align="right" style="padding-right:4px;">Type</td>
			                    <td><script type="text/javascript">ComComboObject('loc_tp_cd', 1, 170, 1, 1, 0);</script></td>
							</tr>
						</table>
						<table class="line_bluedot">
							<tr>
								<td></td>
							</tr>
						</table>						
						<table class="search" style="width:979;">
							<tr class="h23">
								<td width="130" align="right" style="padding-right:4px;">Region</td>
			                    <td>
			                    	<input id="rgn_cd" style="width: 120px; ime-mode:disabled; text-align:center" class="input1" name="rgn_cd" dataformat="engup" maxlength="3" type="text" onBlur="obj_change();"/>
									<img src="img/btns_search.gif" name="btns_search4" id="btns_search4" width="19" height="20" style="margin-right:5px;" alt="0" border="0" align="absmiddle" class="cursor"> 
			                    	<button class="btn_etc" name="btns_set_country" id="btns_set_country" type="button">Set Country</button>
			                    </td>
							</tr>
						</table>
						<table class="search" style="width:979;">
							<tr class="h23">
			                    <td width="130" align="right" style="padding-right:6px;">Continent</td>
			                    <td width="169"><script type="text/javascript">ComComboObject('conti_cd', 1, 105, 1, 1, 0);</script></td>
			                    <td width="90" align="left" style="padding-right:4px;">Sub Continent</td>
			                    <td width="150">
			                    	<input id="sconti_cd" style="width: 120px; ime-mode:disabled; text-align:center" class="input1" name="sconti_cd" dataformat="engup" maxlength="2" type="text" onBlur="obj_change();"/>
									<img src="img/btns_search.gif" name="btns_search2" id="btns_search2" width="19" height="20" alt="0" border="0" align="absmiddle" class="cursor"> 
			                    </td>
			                    <td width="86" align="right" style="padding-right: 4px;">Country</td>
			                    <td>
			                    	<input id="cnt_cd" style="width: 40px; ime-mode:disabled; text-align:center" class="input1" name="cnt_cd" dataformat="engup" maxlength="2" type="text" onBlur="obj_change();"/>
									<img src="img/btns_search.gif" name="btns_search3" id="btns_search3" width="19" height="20" alt="0" border="0" align="absmiddle" class="cursor"> 
			                    </td>
			                    <td width="70" align="right" style="padding-right:4px;">State</td>
			                    <td width="115">
			                    	<input id="ste_cd" style="width: 90px; ime-mode:disabled; text-align:center" class="input" name="ste_cd" dataformat="engup" maxlength="3" type="text" onBlur="obj_change();"/>
									<img src="img/btns_search.gif" name="btns_search5" id="btns_search5" width="19" height="20" alt="0" border="0" align="absmiddle" class="cursor"> 
			                    </td>
							</tr>
						</table>
						<table class="search" style="width:979;">
							<tr class="h23">
			                    <td width="130" align="right" style="padding-right:4px;">EQ SCC</td>
			                    <td width="150">
			                    	<input id="scc_cd" style="width: 120px; ime-mode:disabled;text-align:center" class="input" name="scc_cd" dataformat="engup" maxlength="5" type="text" onBlur="obj_change();"/>
									<img src="img/btns_search.gif" name="btns_search6" id="btns_search6" width="19" height="20" alt="0" border="0" align="absmiddle" class="cursor"> 
			                    </td>
			                    <td width="111" align="right" style="padding-right:4px;">EQ ECC</td>
			                    <td width="160">
			                    	<input id="ecc_cd" name="ecc_cd" style="width: 120px; ime-mode:disabled; text-align:center" class="input" type="text" readonly/>
			                    </td>
			                    <td width="76" align="right" style="padding-right:4px;">EQ LCC</td>
			                    <td width="132">
									<input id="lcc_cd" name="lcc_cd" style="width: 110px; ime-mode:disabled; text-align:center" class="input" type="text" readonly/>					                    
								</td>
			                    <td width="90" align="right" style="padding-right: 4px">EQ RCC</td>
			                    <td>
			                    	<input id="rcc_cd" name="rcc_cd" style="width: 110px; ime-mode:disabled; text-align:center" class="input" type="text" readonly/> 
			                    </td>
							</tr>
						</table>
						<table class="search" style="width:979;">
							<tr class="h23">
			                    <td width="130" align="right" style="padding-right:4px;">Rep. Zone</td>
			                    <td width="185">
			                    	<input id="rep_zn_cd" style="width: 120px; ime-mode:disabled; text-align:center" class="input" name="rep_zn_cd" dataformat="eng" maxlength="7" type="text" onBlur="obj_change();"/>
									<img src="img/btns_search.gif" name="btns_search7" id="btns_search7" width="19" height="20" alt="0" border="0" align="absmiddle" class="cursor"> 
			                    </td>
			                    <td width="76" align="right" style="padding-right:4px;">UN LOC Flag</td>
			                    <td width="68">
			                    	<select style="width: 60px;" class="input1" name="un_loc_ind_cd" onChange="obj_change();">
			                    		<option value="" selected></option>
			                    		<option value="N">N</option>
			                    		<option value="Y">Y</option>
			                    	</select>
			                    </td>
			                    <td width="168" align="right" style="padding-right: 4px">UN LOC Code</td>
			                    <td><input id="un_loc_cd" style="width: 75px; ime-mode:disabled;text-align:center" class="input" name="un_loc_cd" dataformat="engup" maxlength="5" type="text" /> </td>
								<td width="100" align="right" style="padding-right:4px;"></td>
			                    <td width="150"></td>
							</tr>
						</table>
						<table class="search" style="width:979;">
							<tr class="h23">
								<td width="130" align="right" style="padding-right:4px;">Sales Office</td>
			                    <td width="150">
			                    	<input id="sls_ofc_cd" style="width: 120px; ime-mode:disabled; text-align:center" class="input1" name="sls_ofc_cd" dataformat="eng" maxlength="6" type="text" onBlur="obj_change();"/>
									<img src="img/btns_search.gif" name="btns_search8" id="btns_search8" width="19" height="20" alt="0" border="0" align="absmiddle" class="cursor"> 
			                    </td>
			                    <td width="111" align="right" style="padding-right:4px;">EQ Ctrl Office</td>
			                    <td width="170">
			                    	<input id="eq_ctrl_ofc_cd" style="width: 120px; ime-mode:disabled; text-align:center" class="input1" name="eq_ctrl_ofc_cd" dataformat="eng" maxlength="6" type="text" onBlur="obj_change();"/>
									<img src="img/btns_search.gif" name="btns_search9" id="btns_search9" width="19" height="20" alt="0" border="0" align="absmiddle" class="cursor"> 
			                    </td>
			                    <td width="120" align="right" style="padding-right:4px;">Finance Ctrl Office</td>
			                    <td>
			                    	<input id="finc_ctrl_ofc_cd" style="width: 60px; ime-mode:disabled; text-align:center" class="input1" name="finc_ctrl_ofc_cd" dataformat="eng" maxlength="6" type="text" onBlur="obj_change();"/>
									<img src="img/btns_search.gif" name="btns_search10" id="btns_search10" width="19" height="20" alt="0" border="0" align="absmiddle" class="cursor"> 
			                    </td>
                    		</tr>							
						</table>
						<table class="search" style="width:979;">
							<tr class="h23">
			                    <td width="130" align="right" style="padding-right:4px;">Rep. Empty P/Up CY</td>
			                    <td width="150">
			                    	<input id="mty_pkup_yd_cd" style="width: 120px; ime-mode:disabled; text-align:center" class="input" name="mty_pkup_yd_cd" dataformat="eng" maxlength="7" type="text" onBlur="obj_change();"/>
									<img src="img/btns_search.gif" name="btns_search11" id="btns_search11" width="19" height="20" alt="0" border="0" align="absmiddle" class="cursor"> 
			                    </td>
			                    <td width="111" align="right" style="padding-right:4px;">EQ Return CY</td>
			                    <td>
			                    	<input id="eq_rtn_yd_cd" style="width: 120px; ime-mode:disabled; text-align:center" class="input" name="eq_rtn_yd_cd" dataformat="eng" maxlength="7" type="text" onBlur="obj_change();"/>
									<img src="img/btns_search.gif" name="btns_search12" id="btns_search12" width="19" height="20" alt="0" border="0" align="absmiddle" class="cursor"> 
			                    </td>
							</tr>
						</table>
						<table class="line_bluedot">
							<tr>
								<td></td>
							</tr>
						</table>		
						<table class="search" style="width:979;">
							<tr class="h23">
								<td width="130" align="right">Latitude</td>
			                    <td width="170"><input id="loc_lat" style="width:60px;ime-mode:disabled;text-align:right" class="input" name="loc_lat" otherchar="." dataformat="float" maxlength="6" type="text" /> 
			                    				<select style="width: 40px;" class="input" name="lat_ut_cd" id="lat_ut_cd"><option value="" selected></option><option value="N">N</option><option value="S">S</option></select>
			                    </td>
			                    <td width="84" align="right" style="padding-right:4px;">Longitude</td>
			                    <td width="141"><input id="loc_lon" style="width: 60px; ime-mode:disabled; text-align:right" class="input" name="loc_lon" dataformat="float" maxlength="6" otherchar="." type="text" /> 
			                    	<select style="width: 40px;" class="input" name="lon_ut_cd" id="lon_ut_cd"><option value="" selected></option><option value="E">E</option><option value="W">W</option></select>
			                    </td>
			                    <td width="141" align="right" style="padding-right:4px;">B/L Prefix</td>
								<td width="89"><input name="bkg_bl_pfx_cd" id="bkg_bl_pfx_cd" style="width:60px; ime-mode:disabled; text-align:center;" class="input" dataformat="engup" maxlength="3" type="text"></td>
								<td width="75" align="right" style="padding-right:4px;">Bulk Port</td>
								<td width="110"><select style="width: 70px;" class="input" name="blk_port_flg" id="blk_port_flg"><option value="" selected></option><option value="Y">Yes</option><option value="N">No</option></select></td>
							</tr>	
						</table>
						<table class="search" style="width:979;">
							<tr class="h23">
			                    <td width="130" align="right" style="padding-right:4px;">Hub Loc</td>
			                    <td width="150">
			                    	<input id="hub_loc_cd" style="width: 100px; ime-mode:disabled; text-align:center" class="input" name="hub_loc_cd" dataformat="engup" maxlength="5" type="text" onBlur="obj_change();"/>
									<img src="img/btns_search.gif" name="btns_search13" id="btns_search13" width="19" height="20" alt="0" border="0" align="absmiddle" class="cursor"> 
			                    </td>
			                    <td width="170" align="right" style="padding-right:4px;">Zip Code</td>
			                    <td width="160"><input id="zip_cd" style="width: 100px; ime-mode:disabled; text-align:center" class="input" name="zip_cd" dataformat="saupja" maxlength="10" type="text" /> </td>
			                    <td width="130" align="right" style="padding-right:4px;">UTC Gap(Minutes)</td>
			                    <td><input id="gmt_hrs" style="width:60px;ime-mode:disabled;text-align:right" class="input1" name="gmt_hrs" dataformat="int" maxlength="3" type="text" /><input id="utc_gap_hr_ctnt" name="utc_gap_hr_ctnt" type="hidden" /></td>
							</tr>
						</table>
						<table class="search" style="width:979">
							<tr class="h23">
								<td width="130" align="right" style="padding-right:4px;">US AMS Code</td>
			                    <td width="140"><input id="loc_ams_port_cd" style="width: 100px; ime-mode:disabled; text-align:center" class="input" name="loc_ams_port_cd" dataformat="int" maxlength="5" type="text" /> </td>
			                    <td width="180" align="right" style="padding-right: 4px;">Canada Customs Code</td>
			                    <td width="110"><input id="cstms_cd" style="width: 80px; ime-mode:disabled; text-align:center" class="input" name="cstms_cd" dataformat="engnum" maxlength="10" type="text" /> </td>
			                    <td width="180" align="right" style="padding-right: 4px;">Commercial Zone</td>
			                    <td><select style="width: 60px;" class="input" name="cml_zn_flg"><option value="" selected></option><option value="N">N</option><option value="Y">Y</option></select></td>
							</tr>
						</table>
						<table class="line_bluedot">
							<tr>
								<td></td>
							</tr>
						</table>
						<table class="search" style="width:979">
							<tr class="h23">
			                    <td width="80" align="right" style="padding-right:4px;">Delete Flag</th>
			                    <td>
			                        <select style="width:40px;" name="delt_flg" class="input" id="delt_flg" onChange="obj_change();">
			                            <option value="N" selected>N</option>
			                            <option value="Y">Y</option>
			                        </select>
			                    </td>
			                    <td width="80" align="right" style="padding-right:4px;">Create User</th>
					            <td>
					            	<input type="text" style="width:60px;text-align:center;" class="input" name="cre_usr_id" id="cre_usr_id" readOnly/>
					            </td>
					            <td width="120" align="right" style="padding-right:4px;">Create Date/Time</td>
					            <td>
					            	<input type="text" style="width:102px;text-align:center;" class="input" name="cre_dt" idk="cre_dt" readOnly/>
					            </td>
					            <td width="110" align="right" style="padding-right:4px;">Last Update User</td>
					            <td>
					            	<input type="text" style="width:60px;text-align:center;" class="input" name="upd_usr_id" id="upd_usr_id" readOnly/>
					            </td>
					            <td width="150" align="right" style="padding-right:4px;">Last Update Date/Time</td>
					            <td><input type="text" style="width:102px;text-align:center;" class="input" name="upd_dt" id="upd_dt" readOnly/>
					            </td>											
							</tr>													
						</table>
					</td>		
				</tr>
			</table>
			<!-- biz_1 (E) -->
			
		<!-- biz Page (E) -->

		<!--Button (S) -->
			<table width="100%" class="button" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
	       		<tr>
	       			<td class="btn1_bg">
			    		<table border="0" cellpadding="0" cellspacing="0">
			    			<tr>
			    				<td id="btn_History">
			    					<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_History">History</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td id="btn_Save1">
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_Save" id="btn_Save">Save</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td id="btn_Create1">
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_Create">Create</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td width="20" id="bottom_space"></td>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_New">New</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
	    <!--Button (E) -->		
		</td>
	</tr>	
</table>	
 <div class="wrap_result" style="display:none;">
    <div class="opus_design_grid">
        <script type="text/javascript">ComSheetObject('sheet1');</script>
    </div>
</div>    
</form>
</body>
</html>