<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : BCM_CCD_0020.jsp
*@FileTitle  : Yard
*@author     : CLT
*@version    : 1.0
*@since      : 2014/
=========================================================*/
%>
   
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.bcm.ccd.commoncode.location.event.BcmCcd0020Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    BcmCcd0020Event  event = null;              //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //Error from server
    String strErrMsg = "";                      //Error message
    int rowCount     = 0;                       //Count of DB resultSet list
    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";
    String strUsr_id        = "";
    String strUsr_nm        = "";
    Logger log = Logger.getLogger("com.hanjin.apps.commoncode.location");
    String mainPage 		= "";
    mainPage = request.getParameter("main_page");
    // 승인처리용 정보
    String rqstNo       = JSPUtil.getParameter(request, "rqst_no");
    String procTpCd     = JSPUtil.getParameter(request, "proc_tp_cd");
    String rqstUsrChk   = JSPUtil.getParameter(request, "rqst_usr_chk");
    String rqstOfcCd    = JSPUtil.getParameter(request, "rqst_ofc_cd");
    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
        event = (BcmCcd0020Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
        // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
    } catch(Exception e) {
        out.println(e.toString());
    }
%>

<html>
<head>
<title>Yard</title>
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
<input type="hidden" name="mdm_yn" id="mdm_yn" value="y" />
<input type="hidden" name="creflag" id="creflag" value="Y" />
<input type="hidden" name="mst_dat_subj_cd" id="mst_dat_subj_cd" value="YARD" />
<input type="hidden" name="rqst_no" id="rqst_no" value="<%=rqstNo%>" />
<input type="hidden" name="proc_tp_cd" id="proc_tp_cd" value="<%=procTpCd%>" />
<input type="hidden" name="rqst_usr_chk" id="rqst_usr_chk" value="<%=rqstUsrChk%>" />
<input type="hidden" name="rqst_ofc_cd" id="rqst_ofc_cd" value="<%=rqstOfcCd%>" />
<input type="hidden" name="old_modi_yd_cd" id="old_modi_yd_cd" value="" />
<input type="hidden" name="edi_if_flg" id="edi_if_flg" />
<input type="hidden" name="onchange_flag" id="onchange_flag" />
<!-- 개발자 작업 -->

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
							&nbsp; Yard
						</span>
					</td>
				</tr>
			</table>
			<!-- Page Title, Historical (E) -->

		    <!-- opus_design_btn(S) -->
			<!--     <div class="opus_design_btn">
		        <button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve" style="display: none">Retrieve</button>
		       <button type="button" class="btn_normal" name="btn_Save" id="btn_Save" style="display: none">Save</button>
		       <button type="button" class="btn_normal" name="btn_Request" id="btn_Request" style="display: none">Request</button>
		       <button type="button" class="btn_normal" name="btn_New" id="btn_New" style="display: none">New</button>
		       <button type="button" class="btn_normal" name="btn_Close" id="btn_Close" style="display: none">Close</button>
		    </div> -->    
		    <!-- opus_design_btn(E) -->		
		    
		    <table width="100%" class="search" id="leftTable">
		    	<tr>
		    		<td width="120">
		    		</td>
		    	</tr>
		    </table>
		    
	    <!-- biz page (S) -->
	    
			<!-- biz_1 (S) -->
			<table class="search" id="mainTable">
				<tr>
					<td class="bg">
						<table class="search" style="width:979;">
							<tr class="h23">
								<td width="155" align="right" style="padding-right: 4px;">Yard Code</td>
			                    <td width="150">
			                    	<input id="yd_cd" style="width: 120px; ime-mode:disabled; text-align:center" class="input1" name="yd_cd" dataformat="engupnum" maxlength="7" type="text" onBlur="obj_change();" />
									<img src="img/btns_search.gif" name="btns_search7" id="btns_search7" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
			                    </td>
			                    <td width="275" align="right" style="padding-right: 4px;">Legacy Code</td>
			                    <td><input type="text" style="width:150px;text-align:center;" class="input" dataformat="engupnum" id="modi_yd_cd" name="modi_yd_cd" maxlength="7"></td>
							</tr>
						</table>
						<table class="line_bluedot">
							<tr>
								<td></td>
							</tr>
						</table>
						<table class="search" style="width:979;">
							<tr class="h23">
			                    <td width="155" align="right" style="padding-right: 4px;">English Name</td>
			                    <td><input id="yd_nm" style="width: 747px; ime-mode:disabled;" class="input1" name="yd_nm" dataformat="etc" otherchar="()_\-,. " maxlength="50" type="text" /></td>
							</tr>
						</table>
						<table class="search" style="width:979;">
							<tr class="h23">
			                    <td width="155" align="right" style="padding-right: 4px;">Local Name</td>
			                    <td><input id="yd_locl_lang_nm" style="width: 747px;" class="input" name="yd_locl_lang_nm" maxlength="50" type="text" /> </td>
							</tr>
						</table>					
						<table class="search" style="width:979;">
							<tr class="h23">
			                    <td width="155" align="right" style="padding-right: 4px;">Yard Character</td>
			                    <td><script type="text/javascript">ComComboObject('yd_chr_cd', 2, 120, 1, 1, 1);</script></td>
			                    <td width="100" align="right" style="padding-right: 4px;">Yard Ownership</td>
			                    <td><script type="text/javascript">ComComboObject('yd_oshp_cd', 2, 88, 1, 1, 1);</script></td>
			                    <td class="sm">
			                    	<table class="search_sm2">
			                    		<tr><td>
											<input id="yd_fcty_tp_mrn_tml_flg" value="Y" class="trans" name="yd_fcty_tp_mrn_tml_flg" type="checkbox" onclick="javascript:obj_change();"/><label for="yd_fcty_tp_mrn_tml_flg">Marine Terminal</label><!--
					                        --><input id="yd_fcty_tp_cy_flg" value="Y" class="trans" name="yd_fcty_tp_cy_flg" type="checkbox" onclick="javascript:obj_change();"/><label for="yd_fcty_tp_cy_flg">CY</label><!--
					                        --><input id="yd_fcty_tp_cfs_flg" value="Y" class="trans" name="yd_fcty_tp_cfs_flg" type="checkbox" onclick="javascript:obj_change();"/><label for="yd_fcty_tp_cfs_flg">CFS</label><!--
					                        --><input id="yd_fcty_tp_rail_rmp_flg" value="Y" class="trans" name="yd_fcty_tp_rail_rmp_flg" type="checkbox" onclick="javascript:obj_change();"/><label for="yd_fcty_tp_rail_rmp_flg">Rail Ramp</label><!--
					                        --><input id="yd_fcty_tp_brg_rmp_flg" value="Y" class="trans" name="yd_fcty_tp_brg_rmp_flg" type="checkbox" onclick="javascript:obj_change();"/><label for="yd_fcty_tp_brg_rmp_flg">Barge Ramp</label><!--
					                        --><input id="yd_fcty_tp_psdo_yd_flg" value="Y" class="trans" name="yd_fcty_tp_psdo_yd_flg" type="checkbox" onclick="javascript:obj_change();"/><label for="yd_fcty_tp_psdo_yd_flg">Pseudo</label>								                    		
			                    		</td></tr>
			                    	</table>
			                        
			                    </td>
							</tr>
						</table>	
						<table class="line_bluedot">
							<tr>
								<td></td>
							</tr>
						</table>
						<table class="search">
							<tr>
								<td class="title_h"></td>
								<td class="title_s">Vendor Info</td>
							</tr>
						</table>
						<table class="search" style="width:979;">
							<tr class="h23">
			                    <td width="155" align="right" style="padding-right: 4px;">Handling Vendor</td>
			                    <td>
			                    	<input id="n1st_vndr_seq" style="width: 60px; ime-mode:disabled; text-align:center" class="input1" name="n1st_vndr_seq" dataformat="int" maxlength="6" type="text" onBlur="obj_change();"/>
									<img src="img/btns_search.gif" name="btns_search1" id="btns_search1" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
			                    	<input id="n1st_vndr_nm" style="width: 500px; ime-mode:disabled; text-align:left" class="input2" name="n1st_vndr_nm" readonly type="text" />
			                    </td>
							</tr>
						</table>
						<table class="search" style="width:979;">
							<tr class="h23">
			                    <td width="155" align="right" style="padding-right: 4px;">Stevedoring Vendor</td>
			                    <td>
			                    	<input id="n2nd_vndr_seq" style="width: 60px; ime-mode:disabled; text-align:center" class="input" name="n2nd_vndr_seq" dataformat="int" maxlength="6" type="text" onBlur="obj_change();"/>
									<img src="img/btns_search.gif" name="btns_search2" id="btns_search2" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
			                    	<input id="n2nd_vndr_nm" style="width:500px; ime-mode:disabled; text-align:left" class="input2" name="n2nd_vndr_nm" readonly type="text" />
			                    </td>
							</tr>
						</table>
						<table class="search" style="width:979;">
							<tr class="h23">
			                    <td width="155" align="right" style="padding-right: 4px;">Security Vendor</td>
			                    <td>
			                    	<input id="n3rd_vndr_seq" style="width: 60px; ime-mode:disabled; text-align:center" class="input" name="n3rd_vndr_seq" dataformat="int" maxlength="6" type="text" onBlur="obj_change();"/>
			                    	<img src="img/btns_search.gif" name="btns_search3" id="btns_search3" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
			                    	<input id="n3rd_vndr_nm" style="width:500px; ime-mode:disabled; text-align:left" class="input2" name="n3rd_vndr_nm" readonly type="text" /> </td>
							</tr>
						</table>
						<table class="line_bluedot">
							<tr>
								<td></td>
							</tr>
						</table>
						<table class="search">
							<tr>
								<td class="title_h"></td>
								<td class="title_s">Key Info</td>
							</tr>
						</table>
						<table class="search" style="width:979;">
							<tr class="h23">
			                    <td width="155" align="right" style="padding-right: 4px;">Control Office</td>
			                    <td>
			                    	<input id="ofc_cd" style="width: 60px; ime-mode:disabled; text-align:center" class="input1" name="ofc_cd" dataformat="engup" maxlength="6" type="text" onBlur="obj_change();"/>
									<img src="img/btns_search.gif" name="btns_search4" id="btns_search4" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
			                    </td>
			                    <td align="right" style="padding-right: 4px;">DEM/DET Office</td>
			                    <td>
			                    	<input id="dmdt_ofc_cd" style="width: 60px; ime-mode:disabled; text-align:center" class="input1" name="dmdt_ofc_cd" dataformat="engup" maxlength="6" type="text" onBlur="obj_change();"/>
									<img src="img/btns_search.gif" name="btns_search5" id="btns_search5" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
			                    </td>
			                    <td align="right" style="padding-right: 4px;">DEM I/B Collect</td>
			                    <td><select style="width: 60px;" class="input1" name="dem_ib_clt_flg"><option value="N" selected>N</option><option value="Y">Y</option></select></td>
			                    <td align="right" style="padding-right: 4px;">DEM O/B Collect</td>
			                    <td><select style="width: 60px;" class="input1" name="dem_ob_clt_flg"><option value="N" selected>N</option><option value="Y">Y</option></select></td>
			                    <td align="right" style="padding-right: 4px;">Rep. Zone</td>
			                    <td>
			                    	<input id="rep_zn_cd" style="width: 60px;ime-mode:disabled;text-align:center" class="input" name="rep_zn_cd" dataformat="engupnum" maxlength="7" type="text" onBlur="obj_change();"/>
									<img src="img/btns_search.gif" name="btns_search6" id="btns_search6" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
			                    </td>
							</tr>
						</table>
						<table class="search" style="width:979;">
							<tr class="h23">
			                    <td width="155" align="right" style="padding-right: 4px;">Bonded</td>
			                    <td width="95"><select style="width: 60px;" class="input1" name="bd_yd_flg" id="bd_yd_flg"><option value="N" selected>N</option><option value="Y">Y</option></select></td>
			                    <td width="106" align="right" style="padding-right: 4px;">M&R Shop</td>
			                    <td width="93"><select style="width: 60px;" class="input1" name="mnr_shop_flg" id="mnr_shop_flg"><option value="N" selected>N</option><option value="Y">Y</option></select></td>
			                    <td width="105" align="right" style="padding-right: 4px;">E.I.R Service</td>
			                    <td width="95"><select style="width: 60px;" class="input1" name="eir_svc_flg" id="eir_svc_flg"><option value="N" selected>N</option><option value="Y">Y</option></select></td>
			                    <td width="83" align="right" style="padding-right: 4px;">Hub Yard</td>
			                    <td><select style="width: 60px;" class="input1" name="hub_yd_flg" id="hub_yd_flg"><option value="N" selected>N</option><option value="Y">Y</option></select></td>
			<!--                     <th>BKG Yard</th> -->
			<!--                     <td><select style="width: 60px;" class="input" name="bkg_pod_yd_flg" id="bkg_pod_yd_flg"><option value="" selected></option><option value="N">N</option><option value="Y">Y</option></select></td> -->
			                	<td style="width: 120px;"></td>
			                	<td align="right" style="padding-right: 4px; display:none;">Arrival Notification</td>
			                    <td style="display:none;"><select style="width: 60px;" class="input" name="rail_arr_ntfc_flg" id="rail_arr_ntfc_flg"><option value="N" selected>N</option><option value="Y">Y</option></select></td>
							</tr>
						</table>
						<table class="line_bluedot">
							<tr>
								<td></td>
							</tr>
						</table>
						<table class="search">
							<tr>
								<td class="title_h"></td>
								<td class="title_s">General Info</td>
							</tr>
						</table>						
						<table class="search" style="width:979;">
							<tr class="h23">
			                    <td width="155" align="right" style="padding-right: 4px;">English Address</td>
			                    <td><input id="yd_addr" style="width: 747px; ime-mode: disabled;" class="input1" name="yd_addr" maxlength="200" type="text" /> </td>
							</tr>
						</table>						
						<table class="search" style="width:979;">
							<tr class="h23">
			                    <td width="155" align="right" style="padding-right: 4px;">Local Address</td>
			                    <td><input id="yd_locl_lang_addr" style="width: 747px;" class="input" name="yd_locl_lang_addr" maxlength="66" type="text" /> </td>
							</tr>
						</table>						
						<table class="search" style="width:979;">
							<tr class="h23">
			                    <td width="155" align="right" style="padding-right: 4px;">Customs No</td>
			                    <td width="60"><input id="yd_cstms_no" style="width: 60px; ime-mode: disabled;" class="input" name="yd_cstms_no" dataformat="engupnum" maxlength="10" type="text" /> </td>
			                    <td width="136" align="right" style="padding-right: 4px;">C.E.O</td>
			                    <td width="60"><input id="yd_ceo_nm" style="width: 60px; ime-mode:disabled;" class="input" name="yd_ceo_nm" maxlength="50" type="text" /> </td>
			                    <td width="135" align="right" style="padding-right: 4px;">P.I.C</td>
			                    <td width="120"><input id="yd_pic_nm" style="width: 120px;" class="input" name="yd_pic_nm" maxlength="16" type="text" /> </td>
			                    <td width="105" align="right" style="padding-right: 4px;">E-Mail</td>
			                    <td><input id="yd_eml" style="width: 100px; ime-mode: disabled;" class="input" name="yd_eml" maxlength="50" type="text" /> </td>
							</tr>
						</table>						
						<table class="search" style="width:979;">
							<tr class="h23">
			                    <td width="155" align="right" style="padding-right: 4px;">Postal Code</th>
			                    <td width="63"><input id="zip_cd" style="width: 60px; ime-mode:disabled; text-align:center" class="input" name="zip_cd" maxlength="10" type="text" /> </td>
			                    <td width="136" align="right" style="padding-right: 3px;">International Tel No</td>
			                    <td width="63"><script type="text/javascript">ComComboObject('intl_phn_no', 2, 60, 0, 1, 0);</script></td>
			                    <td width="136" align="right" style="padding-right: 3px;">Tel No</td>
			                    <td width="93"><input id="phn_no" style="width: 90px; ime-mode:disabled; text-align:right" class="input1" name="phn_no" dataformat="saupja" maxlength="20" type="text" /> </td>
			                    <td width="136" align="right" style="padding-right: 3px;">Fax No</td>
			                    <td width="185"><input id="fax_no" style="width:90px; ime-mode:disabled; text-align:right" class="input1" name="fax_no" dataformat="saupja" maxlength="20" type="text" /> </td>
			                    <td align="right" style="padding-right: 3px; display:none;">Latitude</td>
			                    <td style="display:none;"><input id="yd_lat" style="width:60px;ime-mode:disabled;text-align:right" class="input" name="yd_lat" otherchar="." dataformat="singledFloat" maxlength="10"  pointcount="6" type="text" /> </td>
			                    <td align="right" style="padding-right: 3px; display:none;">Longitude</td>
			                    <td style="display:none;"><input id="yd_lon" style="width: 60px; ime-mode:disabled; text-align:right" class="input" name="yd_lon" dataformat="singledFloat" maxlength="10" otherchar="." pointcount="6" type="text" /> </td>
							</tr>
						</table>						
						<table class="line_bluedot">
							<tr>
								<td></td>
							</tr>
						</table>
						<table class="search">
							<tr>
								<td class="title_h"></td>
								<td class="title_s">Service & Facility</td>
							</tr>
						</table>						
						<table class="search" style="width:979; display:none;">
							<tr class="h23">
			                    <td width="155" align="right" style="padding-right: 4px;">Dry AVG Dwell Hours</td>
			                    <td width="60"><input id="dry_avg_dwll_hrs" style="width: 60px; ime-mode:disabled; text-align:right" class="input1" name="dry_avg_dwll_hrs" dataformat="int" maxlength="4" type="text" /> </td>
			                    <td width="150" align="right" style="padding-right: 3px;">Dry MIN Dwell Hours</td>
			                    <td width="60"><input id="dry_min_dwll_hrs" style="width: 60px; ime-mode:disabled; text-align:right" class="input1" name="dry_min_dwll_hrs" dataformat="int" maxlength="4" type="text" /> </td>
			                    <td width="170" align="right" style="padding-right: 3px;">Reefer AVG Dwell Hours</td>
			                    <td width="60"><input id="rf_avg_dwll_hrs" style="width: 60px; ime-mode:disabled; text-align:right" class="input1" name="rf_avg_dwll_hrs" dataformat="int" maxlength="4" type="text" /> </td>
			                    <td width="170" align="right" style="padding-right: 3px;">Reefer MIN Dwell Hours</td>
			                    <td><input id="rf_min_dwll_hrs" style="width:60px; ime-mode:disabled; text-align:right" class="input1" name="rf_min_dwll_hrs" dataformat="int" maxlength="4" type="text" /> </td>
							</tr>
						</table>						
						<table class="search" style="width:979;">
							<tr>
			                    <td class="h23" width="155" align="right" style="padding-right: 4px; font-weight:bold; color:#313131;">Gate Open(HH:MM)</td>
			                    <td></td>
			                    <td width="71" align="right" style="padding-right: 4px;">Week</td>
			                    <td width="180"><input id="gate_opn_hrmnt" style="width: 80px; ime-mode:disabled; text-align:center" class="input1" name="gate_opn_hrmnt" dataformat="hm" maxlength="5" type="text" onBlur="timeCheck();" />~ <input id="gate_clz_hrmnt" style="width:80px;ime-mode:disabled;text-align:center" class="input1" name="gate_clz_hrmnt" dataformat="hm" maxlength="5" type="text" onBlur="timeCheck();"/> </td>
			                    <td width="75" align="right" style="padding-right: 4px;">Saturday</td>
			                    <td><input id="sat_gate_opn_hrmnt" style="width: 80px; ime-mode:disabled; text-align:center" class="input1" name="sat_gate_opn_hrmnt" dataformat="hm" maxlength="5" type="text" onBlur="timeCheck();"/>~ <input id="sat_gate_clz_hrmnt" style="width:80px;ime-mode:disabled;text-align:center" class="input1" name="sat_gate_clz_hrmnt" dataformat="hm" maxlength="5" type="text" onBlur="timeCheck();"/> </td>
							</tr>
						</table>						
						<table class="search" style="width:979;">
							<tr>
								<td class="h23" width="155" align="right" style="padding-right: 4px; font-weight:bold; color:#313131;">(00:00 ~ 24:00)</td>
			                    <td width="71" align="right" style="padding-right: 4px;">Sunday</td>
			                    <td width="180"><input id="sun_gate_opn_hrmnt" style="width: 80px; ime-mode:disabled; text-align:center" class="input1" name="sun_gate_opn_hrmnt" dataformat="hm" maxlength="5" type="text" onBlur="timeCheck();"/>~ <input id="sun_gate_clz_hrmnt" style="width:80px;ime-mode:disabled;text-align:center" class="input1" name="sun_gate_clz_hrmnt" dataformat="hm" maxlength="5" type="text" onBlur="timeCheck();"/> </td>
			                    <td width="75" align="right" style="padding-right: 4px;">Holiday</td>
			                    <td><input id="hol_gate_opn_hrmnt" style="width: 80px; ime-mode:disabled; text-align:center" class="input1" name="hol_gate_opn_hrmnt" dataformat="hm" maxlength="5" type="text" onBlur="timeCheck();"/>~ <input id="hol_gate_clz_hrmnt" style="width:80px;ime-mode:disabled;text-align:center" class="input1" name="hol_gate_clz_hrmnt" dataformat="hm" maxlength="5" type="text" onBlur="timeCheck();"/> </td>
							</tr>
						</table>						
						<table class="search" style="width:979;">
							<tr class="h23">
			                    <td width="155" align="right" style="padding-right: 4px;">
			                    	<input id="yd_inrl_flg" value="Y" class="trans" name="yd_inrl_flg" type="checkbox" />
			                    	<label for="yd_inrl_flg">
			                    		<strong>Inner Rail</strong>
			                    	</label>
			                    </td>
			                    <td width="150" align="right" style="padding-right: 4px;">Cargo Closing Time</td>
			                    <td>
			                    	<input id="yd_cgo_clz_hrmnt_msg" style="width:603px; ime-mode: disabled;" class="input" name="yd_cgo_clz_hrmnt_msg" dataformat="etc" maxlength="100" type="text" /> 
			                    </td>
							</tr>
						</table>		
						<table class="search" style="width:979;">
							<tr>
			                    <td width="155" align="right" style="padding-right: 4px; font-weight:bold; color:#313131;">Berth</td>
			                    <td width="60" align="right">Qty</td>
			                    <td width="75"><input id="brth_no" style="width: 75px; ime-mode:disabled;text-align:right" class="input" name="brth_no" dataformat="int" maxlength="2" type="text" /> </td>
			                    <td width="94" align="right">Length(m)</td>
			                    <td width="75"><input id="yd_brth_len" style="width: 75px; ime-mode:disabled;text-align:right" class="input" name="yd_brth_len" dataformat="int" maxlength="5" type="text" /> </td>
			                    <td width="95" align="right">Depth(m)</td>
			                    <td width="75"><input id="yd_brth_alng_sd_desc" style="width: 75px; ime-mode:disabled;text-align:right" class="input" name="yd_brth_alng_sd_desc" dataformat="float" maxlength="100" type="text" /> </td>
			                    <td width="100" align="right">Channel(m)</td>
			                    <td width="160"><input id="yd_brth_dpth_chnl_knt" style="width: 75px; ime-mode:disabled;text-align:right" class="input" name="yd_brth_dpth_chnl_knt" dataformat="float" maxlength="13" size="18" pointcount="5" type="text" /> </td>
							</tr>
						</table>											
						<table class="search" style="width:979;">
							<tr>
			                    <td width="155" align="right" style="padding-right: 4px; font-weight:bold; color:#313131;">Space(m2)</td>
			                    <td width="60" align="right">TTL</td>
			                    <td width="75"><input id="yd_ttl_spc" style="width: 75px; ime-mode:disabled;text-align:right" class="input" name="yd_ttl_spc" dataformat="int" maxlength="7" type="text" /> </td>
			                    <td width="94" align="right">Actual</td>
			                    <td width="75"><input id="yd_act_spc" style="width: 75px; ime-mode:disabled;text-align:right" class="input" name="yd_act_spc" dataformat="int" maxlength="7" type="text" /> </td>
			                    <td width="95" align="right">CFS</td>
			                    <td width="75"><input id="yd_cfs_spc" style="width: 75px; ime-mode:disabled;text-align:right" class="input" name="yd_cfs_spc" dataformat="int" maxlength="7" type="text" /> </td>
   			                    <td width="100" align="right">SML</td>
								<td width="160"><input id="yd_hjs_spc" style="width: 75px; ime-mode:disabled;text-align:right" class="input" name="yd_hjs_spc" dataformat="int" maxlength="7" type="text" /> </td>
							</tr>
						</table>											
						<table class="line_bluedot">
							<tr>
								<td></td>
							</tr>
						</table>
						<table class="search">
							<tr>
								<td class="title_h"></td>
								<td class="title_s">Equipment</td>
							</tr>
						</table>
						<table class="search" style="width:979;">
							<tr class="h23">
			                    <td width="155" align="right" style="padding-right: 4px;">Reefer Receptacle 440(V)</td>
			                    <td width="50"><input id="yd_rf_rcpt_440v_knt" style="width: 50px; ime-mode:disabled;text-align:right" class="input" name="yd_rf_rcpt_440v_knt" dataformat="int" maxlength="5" type="text" /> </td>
			                    <td width="175" align="right" style="padding-right: 4px;">Reefer Receptacle 220(V)</td>
			                    <td width="60"><input id="yd_rf_rcpt_220v_knt" style="width: 60px; ime-mode:disabled;text-align:right" class="input" name="yd_rf_rcpt_220v_knt" dataformat="int" maxlength="5" type="text" /> </td>
			                    <td width="175" align="right" style="padding-right: 4px;">Reefer Receptacle Dual</td>
			                    <td width="60"><input id="yd_rf_rcpt_dul_knt" style="width: 60px; ime-mode:disabled;text-align:right" class="input" name="yd_rf_rcpt_dul_knt" dataformat="int" maxlength="5" type="text" /> </td>
			                    <td width="135" align="right" style="padding-right: 4px;">Operation System</td>
			                    <td><script type="text/javascript">ComComboObject('yd_op_sys_cd', 2, 128, 1, 0, 1);</script></td>
							</tr>
						</table>			
						<table class="search" style="width:979;">
							<tr class="h23">
			                    <td width="155" align="right" style="padding-right: 4px;">Post Panamax G/Crane</td>
			                    <td width="50"><input id="yd_pst_pgc_knt" style="width: 50px; ime-mode:disabled;text-align:right" class="input" name="yd_pst_pgc_knt" dataformat="int" maxlength="5" type="text" /> </td>
			                    <td width="175" align="right" style="padding-right: 4px;">Panamax G/Crane</td>
			                    <td width="60"><input id="yd_pgc_knt" style="width: 60px; ime-mode:disabled;text-align:right" class="input" name="yd_pgc_knt" dataformat="int" maxlength="5" type="text" /> </td>
			                    <td width="175" align="right" style="padding-right: 4px;">Transtrainer</td>
			                    <td width="60"><input id="trstr_knt" style="width: 60px; ime-mode:disabled;text-align:right" class="input" name="trstr_knt" dataformat="int" maxlength="5" type="text" /> </td>
			                    <td width="134" align="right" style="padding-right: 4px;">Fork Lift</td>
			                    <td><input id="frk_knt" style="width: 128px; ime-mode:disabled;text-align:right" class="input" name="frk_knt" dataformat="int" maxlength="5" type="text" /> </td>
							</tr>
						</table>											
						<table class="search" style="width:979;">
							<tr class="h23">
			                    <td width="155" align="right" style="padding-right: 4px;">Straddle Carrier</td>
			                    <td width="50"><input id="yd_strdl_crr_knt" style="width: 50px; ime-mode:disabled;text-align:right" class="input" name="yd_strdl_crr_knt" dataformat="int" maxlength="5" type="text" /> </td>
			                    <td width="175" align="right" style="padding-right: 4px;">Tractor</td>
			                    <td width="60"><input id="yd_trct_knt" style="width: 60px; ime-mode:disabled;text-align:right" class="input" name="yd_trct_knt" dataformat="int" maxlength="5" type="text" /> </td>
			                    <td width="175" align="right" style="padding-right: 4px;">Top Lift</td>
			                    <td width="60"><input id="yd_top_lft_knt" style="width: 60px; ime-mode:disabled;text-align:right" class="input" name="yd_top_lft_knt" dataformat="int" maxlength="5" type="text" /> </td>
			                    <td width="134" align="right" style="padding-right: 4px;">Terminal Chassis</td>
			                    <td><input id="tml_chss_knt" style="width: 128px; ime-mode:disabled;text-align:right" class="input" name="tml_chss_knt" dataformat="int" maxlength="5" type="text" /> </td>
							</tr>
						</table>											
						<table class="line_bluedot">
							<tr>
								<td></td>
							</tr>
						</table>
						<table class="search">
							<tr>
								<td class="title_h"></td>
								<td class="title_s">Others</td>
							</tr>
						</table>						
						<table class="search" style="width:979;">
							<tr class="h23">
			                    <td width="155" align="right" style="padding-right: 4px;">Handling Year</td>
			                    <td width="75"><input id="yd_hndl_yr" style="width: 75px; ime-mode:disabled; text-align:right" class="input" name="yd_hndl_yr" dataformat="int" maxlength="4" type="text" /> </td>
			                    <td width="150" align="right" style="padding-right: 4px;">H/D CAPA(/YR)</td>
			                    <td width="75"><input id="yd_hndl_capa" style="width: 75px; ime-mode:disabled; text-align:right" class="input" name="yd_hndl_capa" dataformat="float" maxlength="15" size="18" pointcount="3" type="text" /> </td>
			                    <td width="160" align="right" style="padding-right: 4px;">G/C G. Product(/HR)</td>
			                    <td><input id="tml_prod_knt" style="width: 75px; ime-mode:disabled; text-align:right" class="input" name="tml_prod_knt" dataformat="int" maxlength="5" type="text" /> </td>
							</tr>
						</table>											
						<table class="search" style="width:979;">
							<tr class="h23">
			                    <td width="155" align="right" style="padding-right: 4px;">H/D VOL TTL TEU</td>
			                    <td width="75"><input id="yd_ttl_vol_teu_knt" style="width: 75px; ime-mode:disabled; text-align:right" class="input" name="yd_ttl_vol_teu_knt" dataformat="int" maxlength="15" type="text" /> </td>
			                    <td width="150" align="right" style="padding-right: 4px;">H/D VOL TTL BOX</td>
			                    <td width="75"><input id="yd_ttl_vol_bx_knt" style="width: 75px; ime-mode:disabled; text-align:right" class="input" name="yd_ttl_vol_bx_knt" dataformat="int" maxlength="15" type="text" /> </td>
 			                    <td width="160" align="right" style="padding-right: 4px;">H/D VOL TTL SML TEU</td>
			                    <td width="75"><input id="yd_hjs_vol_teu_knt" style="width: 75px; ime-mode:disabled; text-align:right" class="input" name="yd_hjs_vol_teu_knt" dataformat="int" maxlength="15" type="text" /> </td>
			                    <td width="165" align="right" style="padding-right: 4px;">H/D VOL TTL SML BOX</td>
			                    <td colspan="3"><input id="yd_hjs_vol_bx_knt" style="width: 75px; ime-mode:disabled; text-align:right" class="input" name="yd_hjs_vol_bx_knt" dataformat="int" maxlength="15" type="text" /> </td>
							</tr>
						</table>											
						<table class="search" style="width:979;">
							<tr class="h23">
			                    <td width="155" align="right" style="padding-right: 4px;">Remarks</td>
			                    <td><input id="yd_rmk" style="width: 793px; ime-mode: disabled;" class="input" name="yd_rmk" maxlength="1000" type="text" /> </td>
							</tr>
						</table>	
						<table class="line_bluedot">
							<tr>
								<td></td>
							</tr>
						</table>																
						<table class="search" style="width:979;">
							<tr class="h23">
			                    <td width="75" align="right" style="padding-right: 4px;">Delete Flag</td>
			                    <td>
			                        <select style="width:40px;" name="delt_flg" class="input" id="delt_flg" onChange="obj_change();">
			                            <option value="N" selected>N</option>
			                            <option value="Y">Y</option>
			                        </select>
			                    </td>
			                    <td align="right" style="padding-right: 4px;">Create User</td>
					            <td><input type="text" style="width:80px;text-align:center;" class="input" name="cre_usr_id" id="cre_usr_id" readOnly/>
					            </td>
					            <td align="right" style="padding-right: 4px;">Create Date/Time</td>
					            <td><input type="text" style="width:102px;text-align:center;" class="input" name="cre_dt" id="cre_dt" readOnly/>
					            </td>
					            <td align="right" style="padding-right: 4px;">Last Update User</td>
					            <td><input type="text" style="width:80px;text-align:center;" class="input" name="upd_usr_id" id="upd_usr_id" readOnly/>
					            </td>
					            <td align="right" style="padding-right: 4px;">Last Update Date/Time</td>
					            <td><input type="text" style="width:102px;text-align:center;" class="input" name="upd_dt" id="upd_dt" readOnly/>
					            </td>
							</tr>
						</table>						
					</td>
				</tr>
			</table>	    
			<!-- biz_1 (E) -->
			
	    <!-- biz page (E) -->

		<!--Button (S) -->
			<table width="100%" class="button" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
	       		<tr>
	       			<td class="btn1_bg">
			    		<table border="0" cellpadding="0" cellspacing="0">
			    <tr>
			    	<td id="btn_History"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_History">History</td>
						<td class="btn1_right"></td>
						</tr>
					</table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
						<td class="btn1_right"></td>
						</tr>
					</table></td>
					<td id="btn_Save1"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_Save" id="btn_Save">Save</td>
						<td class="btn1_right"></td>
						</tr>
					</table></td>
					<td id="btn_Create1"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_Create">Create</td>
						<td class="btn1_right"></td>
						</tr>
					</table></td>
					<!-- <td id="btn_Request1"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_Request">MDM Request</td>
						<td class="btn1_right"></td>
						</tr>
					</table></td> -->
					<td width="20" id="bottom_space"></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_New">New</td>
						<td class="btn1_right"></td>
						</tr>
					</table></td>
					<!-- <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_Close">Close</td>
						<td class="btn1_right"></td>
						</tr>
					</table>
					</td> -->
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
    <!-- opus_design_grid(S) -->
    <div class="opus_design_grid wFit">
        <script type="text/javascript">ComSheetObject('sheet1');</script>
    </div>
</div>

</form>
</body>
</html>