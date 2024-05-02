<%
/*=========================================================
 ** **Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   ESM_BKG_0926.jsp
*@FileTitle  : C/M Data Check Set-up
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.controller.util.WebKeys"%>
<%@ page import="com.clt.framework.core.view.template.Screen"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.event.EsmBkg0926Event"%>
<%@ page import="com.clt.syscommon.common.table.MdmCountryVO" %>
<%@ page import="com.clt.syscommon.common.table.MdmPortVO" %>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.List" %>

<%
    EsmBkg0926Event  event = null;                    //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;            //error from server
    String strErrMsg = "";                        //error message
    int rowCount     = 0;                        //count of DB resultSET list
    
    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    String strOfc_cd        = "";
    String strPgmNo         = "";
    String screenName       = "";
    Logger log = Logger.getLogger("com.clt.apps.CustomsDeclaration.ManifestListDownload");

    StringBuffer countryComboText = new StringBuffer();
    StringBuffer portComboText = new StringBuffer();
    
    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
        strOfc_cd = account.getOfc_cd().substring(0,4);
       
       
        event = (EsmBkg0926Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
        
        // get data from server when load page ..
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        strPgmNo = request.getParameter("pgmNo");
        
        Screen screen = (Screen) request.getAttribute(WebKeys.CURRENT_SCREEN);
        screenName = screen.getName();
 
    }catch(Exception e) {
        out.println(e.toString());
    }
%>
<style>
	<!--Checkbox design-->
	p {
		display:inline;
		padding:0px 10px 0px 15px;
		width:60px;
	}
	plabel w{
		width:80px;
	}
</style>
<script type="text/javascript">
    var userOfficeCode = "<%=strOfc_cd%>";
    var countryComboText = "<%=countryComboText.toString()%>";
    var portComboText = "<%=portComboText.toString()%>";
    ComOpenWait(true);
    function setupPage(){    	
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            showErrMessage(errMessage);
        } // end if
        ComSetObjValue(document.form.screenName,"<%=screenName%>");
        loadPage();
        ComOpenWait(false);
    }
</script>

<form name="form">
<input type="hidden" name="f_cmd" 			id="f_cmd">
<input type="hidden" name="pagerows" 		id="pagerows">
<input type="hidden" name="screenName" 		id="screenName">
<input type="hidden" name="comboName" 		id="comboName">
<input type="hidden" name="cntCd" 			id="cntCd">
<input type="hidden" name="cstms_div_id" 	id="cstms_div_id" 	value="CTM">
<input type="hidden" name="menuCode" 		id="menuCode" 		value="<%="ESM_BKG_0926-01".equals(strPgmNo) ? "C" : "R" %>">

<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>

	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	
	<div class="opus_design_btn">
		<button type="button" 		class="btn_accent" name="btn_Retrieve" 		id="btn_Retrieve">Retrieve</button>
		 <% if (screenName.indexOf("Q") < 0){ %>
		<button type="button" 		class="btn_normal" name="btn_New" 			id="btn_New">New</button>
		<button type="button" 		class="btn_normal" name="btn_Save"  		id="btn_Save">Save</button>
		<button type="button" 		class="btn_normal" name="btn_Delete" 		id="btn_Delete">Delete</button>    
		<%} %>
	</div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->

<div class="wrap_search_tab">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<tbody>
				<colgroup>
					<col width="5%"/>
					<col width="5%"/>
					<col width="5%"/>
					<col width="5%"/>
					<col width="5%"/>
					<col width="12%"/>
					<col width="5%"/>
					<col width="5%"/>
					<col width="*" />
			    </colgroup>
				<tr>
		            <th>Country</th>
		            <td><script type="text/javascript">ComComboObject('cnt_cd', 3, 50, 0);</script></td>
		            <th>Port</th>
		            <td><script type="text/javascript">ComComboObject('loc_cd', 3, 80, 0);</script></td>
		            <td></td>
		            <td class="sm" align="center"><strong>Including FROB</strong></td>
		            <td class="sm">
		            	<input type="radio" class="trans" name="frob_flg" value="Y" onclick="OnClickRadioButton(document.form)" checked>Yes
		            </td>
		            <td class="sm">
		            	<input type="radio" class="trans" name="frob_flg" value="N" onclick="OnClickRadioButton(document.form)">No
	            	</td>
	            	<td></td>
	           </tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>


<div class="wrap_result">
 
	<!-- opus_tab_btn(S) -->
	<div class="opus_design_tab">
		<script type="text/javascript">ComTabObject('tab1')</script>
	</div>
	<!-- opus_tab_btn(e) -->
<!-- opus_design_grid(S) -->	
<div class="opus_design_grid clear" name="tabLayer" id="tabLayer">
    <table class="grid2">
	    <tr>
		    <th  width:150px;">
		    	<input type="hidden" id="hide" name="expMst_xpt_imp_cd" 	id="expMst_xpt_imp_cd" value="E" />
			    <input type="hidden" id="hide" name="expMst_bl_tp_cd" 		id="expMst_bl_tp_cd" value="M" />
			    <!-- <input type="hidden" id="hide" name="expMst_cnt_cd" 		id="expMst_cnt_cd" value="" />
			    <input type="hidden" id="hide" name="expMst_loc_cd" 		id="expMst_loc_cd" value="" /> -->
			    <input type="hidden" id="hide" name="expMst_frob_flg" 		id="expMst_frob_flg" value="" />
			    <input type="hidden" id="hide" name="expMst_cstms_div_id" 	id="expMst_cstms_div_id" value="" />
			    
			    <input type="hidden" id="hide" name="expHus_xpt_imp_cd" 	id="expHus_xpt_imp_cd" value="E" />
			    <input type="hidden" id="hide" name="expHus_bl_tp_cd" 		id="expHus_bl_tp_cd" value="H" />
			    <!-- <input type="hidden" id="hide" name="expHus_cnt_cd" 		id="expHus_cnt_cd" value="" />
			    <input type="hidden" id="hide" name="expHus_loc_cd" 		id="expHus_loc_cd" value="" /> -->
			    <input type="hidden" id="hide" name="expHus_frob_flg" 		id="expHus_frob_flg" value="" />
			    <input type="hidden" id="hide" name="expHus_cstms_div_id" 	id="expHus_cstms_div_id" value="" />
		    </th>
		    <th  width:44%; height:25px;">Master B/L</th>
		    <th width:44%; height:25px;">House B/L</th>
		</tr>
		<tr style="text-align:center;">
            <th class="tr2_head2" ">Shipper</th>
            <td style="text-align:left; ">
	            <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="expMst_shpr_nm_flg" value="" class="trans"> Name</div>
	            <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="expMst_shpr_addr_flg" value="" class="trans"> Address</div>
	            <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="expMst_shpr_cty_flg" value="" class="trans"> City</div>
	            <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="expMst_shpr_ste_flg" value="" class="trans"> State</div>
	            <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="expMst_shpr_cnt_flg" value="" class="trans"> Country</div>
	            <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="expMst_shpr_zip_flg" value="" class="trans"> ZIP</div> 
	            <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="expMst_shpr_st_nm_flg" value="" class="trans"> Street</div> 
	            <br>
	            <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="expMst_shpr_eori_no_flg" value="" class="trans"> EORI</div>
	            <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="expMst_shpr_phn_flg" value="" class="trans"> Tel</div>
	            <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="expMst_shpr_fax_flg" value="" class="trans"> Fax</div>
	            <div style="display:inline; padding:0px 10px 0px 15px; width:200px;"><input type="checkbox" id="chk" name="expMst_shpr_co_rgst_flg" value="" class="trans"> Company Registration No.</div>
	        </td>             
            <td style="text-align:left; ">
	            <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="expHus_shpr_nm_flg" value="" class="trans"> Name</div>
	            <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="expHus_shpr_addr_flg" value="" class="trans"> Address</div>
	            <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="expHus_shpr_cty_flg" value="" class="trans"> City</div>
	            <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="expHus_shpr_ste_flg" value="" class="trans"> State</div>
	            <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="expHus_shpr_cnt_flg" value="" class="trans"> Country</div>
	            <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="expHus_shpr_zip_flg" value="" class="trans"> ZIP</div>
	            <br>
	            <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="expHus_shpr_co_rgst_flg" value="" class="trans"> Company Registration No.</div>
            </td>
        </tr>
        <tr style="text-align:center;">
            <th class="tr2_head2" ">Consignee</th>
            <td style="text-align:left; ">
	            <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="expMst_cnee_nm_flg" value="" class="trans"> Name</div>
	            <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="expMst_cnee_addr_flg" value="" class="trans"> Address</div>
	            <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="expMst_cnee_cty_flg" value="" class="trans"> City</div>
	            <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="expMst_cnee_ste_flg" value="" class="trans"> State</div>
	            <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="expMst_cnee_cnt_flg" value="" class="trans"> Country</div>
	            <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="expMst_cnee_zip_flg" value="" class="trans"> ZIP</div>
	            <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="expMst_cnee_st_nm_flg" value="" class="trans"> Street</div>
	            <br>
	            <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="expMst_cnee_eori_no_flg" value="" class="trans"> EORI</div>
	            <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="expMst_cnee_phn_flg" value="" class="trans"> Tel</div>
	            <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="expMst_cnee_fax_flg" value="" class="trans"> Fax</div>
	            <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="expMst_cnee_co_rgst_flg" value="" class="trans"> Company Registration No.</div>
	        </td>           
            <td style="text-align:left; ">
	            <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="expHus_cnee_nm_flg" value="" class="trans"> Name</div>
	            <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="expHus_cnee_addr_flg" value="" class="trans"> Address</div>
	            <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="expHus_cnee_cty_flg" value="" class="trans"> City</div>
	            <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="expHus_cnee_ste_flg" value="" class="trans"> State</div>
	            <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="expHus_cnee_cnt_flg" value="" class="trans"> Country</div>
	            <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="expHus_cnee_zip_flg" value="" class="trans"> ZIP</div>
	            <br>
	            <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="expHus_cnee_co_rgst_flg" value="" class="trans"> Company Registration No.</div>
	       </td>
        </tr>
        <tr style="text-align:center;">
           <th class="tr2_head2" ">Notify</th>
           <td style="text-align:left; ">
	           <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="expMst_ntfy_nm_flg" value="" class="trans"> Name</div>
	           <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="expMst_ntfy_addr_flg" value="" class="trans"> Address</div>
	           <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="expMst_ntfy_cty_flg" value="" class="trans"> City</div>
	           <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="expMst_ntfy_ste_flg" value="" class="trans"> State</div>
	           <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="expMst_ntfy_cnt_flg" value="" class="trans"> Country</div>
	           <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="expMst_ntfy_zip_flg" value="" class="trans"> ZIP</div>
	           <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="expMst_ntfy_st_nm_flg" value="" class="trans"> Street</div>
	           <br>
	           <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="expMst_ntfy_eori_no_flg" value="" class="trans"> EORI</div>
	           <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="expMst_ntfy_phn_flg" value="" class="trans"> Tel</div>
	           <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="expMst_ntfy_fax_flg" value="" class="trans"> Fax</div>
	           <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="expMst_ntfy_co_rgst_flg" value="" class="trans"> Company Registration No.</div>
	       </td>	           
	       <td style="text-align:left; ">
	           <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="expHus_ntfy_nm_flg" value="" class="trans"> Name</div>
	           <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="expHus_ntfy_addr_flg" value="" class="trans"> Address</div>
	           <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="expHus_ntfy_cty_flg" value="" class="trans"> City</div>
	           <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="expHus_ntfy_ste_flg" value="" class="trans"> State</div>
	           <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="expHus_ntfy_cnt_flg" value="" class="trans"> Country</div>
	           <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="expHus_ntfy_zip_flg" value="" class="trans"> ZIP</div>
	           <br>
	           <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="expHus_ntfy_co_rgst_flg" value="" class="trans"> Company Registration No.</div>
	      </td>
       </tr>
       <tr style="text-align:center;">
            <th class="tr2_head2" ">B/L Main</th>
            <td style="text-align:left; ">
	            <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="expMst_pck_flg" value="" class="trans"> Package</div>
	            <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="expMst_wgt_flg" value="" class="trans"> Weight</div>
	            <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="expMst_meas_flg" value="" class="trans"> Measure</div>
	            <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="expMst_bl_desc_flg" value="" class="trans"> Description</div>
	            <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="expMst_bl_mk_flg" value="" class="trans"> Mark</div>
	        </td>	            
	        <td style="text-align:left; ">
	            <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="expHus_pck_flg" value="" class="trans"> Package</div>
	            <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="expHus_wgt_flg" value="" class="trans"> Weight</div>
	            <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="expHus_meas_flg" value="" class="trans"> Measure</div>
	            <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="expHus_bl_desc_flg" value="" class="trans"> Description</div>
	            <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="expHus_bl_mk_flg" value="" class="trans"> Mark</div>
	       </td>
        </tr>
        <tr style="text-align:center;">
           <th class="tr2_head2" ">Container</th>
           <td style="text-align:left; ">
	           <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="expMst_cntr_no_flg" value="" class="trans"> Container No</div>
	           <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="expMst_seal_no_flg" value="" class="trans"> Seal No</div>
	           <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="expMst_cntr_pck_flg" value="" class="trans"> Package</div>
	           <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="expMst_cntr_wgt_flg" value="" class="trans"> Weight</div>
	           <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="expMst_cntr_meas_flg" value="" class="trans"> Measure</div>
	       </td>           
           <td style="text-align:left; ">
	           <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="expHus_cntr_no_flg" value="" class="trans"> Container No</div>
	           <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="expHus_seal_no_flg" value="" class="trans"> Seal No</div>
	           <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="expHus_cntr_pck_flg" value="" class="trans"> Package</div>
	           <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="expHus_cntr_wgt_flg" value="" class="trans"> Weight</div>
	           <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="expHus_cntr_meas_flg" value="" class="trans"> Measure</div>
	      </td>
       </tr>
       <tr style="text-align:center;">
            <th class="tr2_head2" ">C/M</th>
            <td style="text-align:left; ">
	            <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="expMst_cntr_mf_pck_flg" value="" class="trans"> Package</div>
	            <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="expMst_cntr_mf_wgt_flg" value="" class="trans"> Weight</div>
	            <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="expMst_cntr_mf_meas_flg" value="" class="trans"> Measure</div>
	            <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="expMst_cntr_mf_desc_flg" value="" class="trans"> Description</div>
	            <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="expMst_cntr_mf_mk_flg" value="" class="trans"> Mark</div>
	            <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="expMst_cntr_mf_cmdt_flg" value="" class="trans"> HTS</div>
	            <br>
	            <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="expMst_cmdt_hs_cd_flg" value="" class="trans"> HS</div>
	            <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="expMst_cntr_mf_ncm_flg" value="" class="trans"> NCM</div>
	        </td> 
            <td style="text-align:left; ">
	            <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="expHus_cntr_mf_pck_flg" value="" class="trans"> Package</div>
	            <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="expHus_cntr_mf_wgt_flg" value="" class="trans"> Weight</div>
	            <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="expHus_cntr_mf_meas_flg" value="" class="trans"> Measure</div>
	            <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="expHus_cntr_mf_desc_flg" value="" class="trans"> Description</div>
	            <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="expHus_cntr_mf_mk_flg" value="" class="trans"> Mark</div>
	            <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="expHus_cntr_mf_cmdt_flg" value="" class="trans"> HTS</div>
	            <br>
	            <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="expHus_cntr_mf_ncm_flg" value="" class="trans"> NCM</div>
	       </td> 
        </tr>
        <tr style="text-align:center;">
            <th class="tr2_head2" ">Export/Import Ref #</th>           
            <td style="text-align:left; ">
	            <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="expMst_xpt_imp_ref_flg1" value="" class="trans"> AES</div>
	            <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="expMst_xpt_imp_ref_flg2" value="" class="trans"> CAED</div>
	            <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="expMst_xpt_imp_ref_flg3" value="" class="trans"> E/L</div>
	            <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="expMst_xpt_imp_ref_flg4" value="" class="trans"> DDE/SD</div>
	            <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="expMst_xpt_imp_ref_flg5" value="" class="trans"> PEB</div>
	            <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="expMst_xpt_imp_ref_flg6" value="" class="trans"> Tax ID</div>
	        </td> 
            <td style="text-align:left; ">
            	<div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="expHus_xpt_imp_ref_flg1" value="" class="trans"> Manifest File No.</div>
            </td>
        </tr>
	</table>
</div>
	
<div class="opus_design_grid clear" style="width:98%; display: none;" name="tabLayer" id="tabLayer" >
	<table class="grid2">
		<tr>
           <th  width:150px;">
              <input type="hidden" id="hide" name="impMst_xpt_imp_cd" 	id="impMst_xpt_imp_cd" value="I" />
		      <input type="hidden" id="hide" name="impMst_bl_tp_cd" 	id="impMst_bl_tp_cd" value="M" />
		      <!-- <input type="hidden" id="hide" name="impMst_cnt_cd" 		id="impMst_cnt_cd" value="" />
		      <input type="hidden" id="hide" name="impMst_loc_cd" 		id="impMst_loc_cd" value="" /> -->
		      <input type="hidden" id="hide" name="impMst_frob_flg" 	id="impMst_frob_flg" value="" />
		      <input type="hidden" id="hide" name="impMst_cstms_div_id" id="impMst_cstms_div_id" value="" />
		      
		      <input type="hidden" id="hide" name="impHus_xpt_imp_cd" 	id="impHus_xpt_imp_cd" value="I" />
		      <input type="hidden" id="hide" name="impHus_bl_tp_cd" 	id="impHus_bl_tp_cd" value="H" />
		      <!-- <input type="hidden" id="hide" name="impHus_cnt_cd" 		id="impHus_cnt_cd" value="" />
		      <input type="hidden" id="hide" name="impHus_loc_cd" 		id="impHus_loc_cd" value="" /> -->
		      <input type="hidden" id="hide" name="impHus_frob_flg" 	id="impHus_frob_flg" value="" />
		      <input type="hidden" id="hide" name="impHus_cstms_div_id" id="impHus_cstms_div_id" value="" />
           </th>
           <th  width:44%; height:25px;">Master B/L</th>
           <th  width:44%; height:25px;">House B/L</th>
       </tr>
       <tr style="text-align:center;">
           <th class="tr2_head2" ">Shipper</th>
           <td style="text-align:left; ">
	           <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="impMst_shpr_nm_flg" value="" class="trans"> Name</div>
	           <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="impMst_shpr_addr_flg" value="" class="trans"> Address</div>
	           <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="impMst_shpr_cty_flg" value="" class="trans"> City</div>
	           <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="impMst_shpr_ste_flg" value="" class="trans"> State</div>
	           <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="impMst_shpr_cnt_flg" value="" class="trans"> Country</div>
	           <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="impMst_shpr_zip_flg" value="" class="trans"> ZIP</div>
	           <br>
	           <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="impMst_shpr_phn_flg" value="" class="trans"> Tel</div>
	           <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="impMst_shpr_fax_flg" value="" class="trans"> Fax</div>
	           <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="impMst_shpr_co_rgst_flg" value="" class="trans"> Company Registration No.</div>
	       </td>           
           <td style="text-align:left; ">
	           <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="impHus_shpr_nm_flg" value="" class="trans"> Name</div>
	           <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="impHus_shpr_addr_flg" value="" class="trans"> Address</div>
	           <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="impHus_shpr_cty_flg" value="" class="trans"> City</div>
	           <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="impHus_shpr_ste_flg" value="" class="trans"> State</div>
	           <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="impHus_shpr_cnt_flg" value="" class="trans"> Country</div>
	           <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="impHus_shpr_zip_flg" value="" class="trans"> ZIP</div>
	           <br>
	           <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="impHus_shpr_co_rgst_flg" value="" class="trans"> Company Registration No.</div>
	      </td>
       </tr>
       <tr style="text-align:center;">
           <th class="tr2_head2" ">Consignee</th>
           <td style="text-align:left; ">
	           <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="impMst_cnee_nm_flg" value="" class="trans"> Name</div>
	           <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="impMst_cnee_addr_flg" value="" class="trans"> Address</div>
	           <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="impMst_cnee_cty_flg" value="" class="trans"> City</div>
	           <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="impMst_cnee_ste_flg" value="" class="trans"> State</div>
	           <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="impMst_cnee_cnt_flg" value="" class="trans"> Country</div>
	           <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="impMst_cnee_zip_flg" value="" class="trans"> ZIP</div>
	           <br>
	           <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="impMst_cnee_phn_flg" value="" class="trans"> Tel</div>
	           <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="impMst_cnee_fax_flg" value="" class="trans"> Fax</div>
	           <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="impMst_cnee_co_rgst_flg" value="" class="trans"> Company Registration No.</div>
	       </td>           
           <td style="text-align:left; ">
	           <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="impHus_cnee_nm_flg" value="" class="trans"> Name</div>
	           <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="impHus_cnee_addr_flg" value="" class="trans"> Address</div>
	           <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="impHus_cnee_cty_flg" value="" class="trans"> City</div>
	           <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="impHus_cnee_ste_flg" value="" class="trans"> State</div>
	           <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="impHus_cnee_cnt_flg" value="" class="trans"> Country</div>
	           <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="impHus_cnee_zip_flg" value="" class="trans"> ZIP</div>
	           <br>
	           <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="impHus_cnee_co_rgst_flg" value="" class="trans"> Company Registration No.</div>
	      </td>
       </tr>
       <tr style="text-align:center;">
          <th class="tr2_head2" ">Notify</th>
          <td style="text-align:left; ">
	          <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="impMst_ntfy_nm_flg" value="" class="trans"> Name</div>
	          <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="impMst_ntfy_addr_flg" value="" class="trans"> Address</div>
	          <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="impMst_ntfy_cty_flg" value="" class="trans"> City</div>
	          <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="impMst_ntfy_ste_flg" value="" class="trans"> State</div>
	          <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="impMst_ntfy_cnt_flg" value="" class="trans"> Country</div>
	          <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="impMst_ntfy_zip_flg" value="" class="trans"> ZIP</div>
	          <br>
	          <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="impMst_ntfy_phn_flg" value="" class="trans"> Tel</div>
	          <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="impMst_ntfy_fax_flg" value="" class="trans"> Fax</div>
	          <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="impMst_ntfy_co_rgst_flg" value="" class="trans"> Company Registration No.</div>
	      </td>          
          <td style="text-align:left; ">
	          <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="impHus_ntfy_nm_flg" value="" class="trans"> Name</div>
	          <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="impHus_ntfy_addr_flg" value="" class="trans"> Address</div>
	          <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="impHus_ntfy_cty_flg" value="" class="trans"> City</div>
	          <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="impHus_ntfy_ste_flg" value="" class="trans"> State</div>
	          <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="impHus_ntfy_cnt_flg" value="" class="trans"> Country</div>
	          <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="impHus_ntfy_zip_flg" value="" class="trans"> ZIP</div>
	          <br>
	          <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="impHus_ntfy_co_rgst_flg" value="" class="trans"> Company Registration No.</div>
	     </td>
      </tr>
      <tr style="text-align:center;">
           <th class="tr2_head2" ">B/L Main</th>
           <td style="text-align:left; ">
	           <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="impMst_pck_flg" value="" class="trans"> Package</div>
	           <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="impMst_wgt_flg" value="" class="trans"> Weight</div>
	           <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="impMst_meas_flg" value="" class="trans"> Measure</div>
	           <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="impMst_bl_desc_flg" value="" class="trans"> Description</div>
	           <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="impMst_bl_mk_flg" value="" class="trans"> Mark</div>
	       </td>           
           <td style="text-align:left; ">
	           <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="impHus_pck_flg" value="" class="trans"> Package</div>
	           <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="impHus_wgt_flg" value="" class="trans"> Weight</div>
	           <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="impHus_meas_flg" value="" class="trans"> Measure</div>
	           <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="impHus_bl_desc_flg" value="" class="trans"> Description</div>
	           <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="impHus_bl_mk_flg" value="" class="trans"> Mark</div>
	      </td>
       </tr>
       <tr style="text-align:center;">
          <th class="tr2_head2" ">Container</th>
          <td style="text-align:left; ">
	          <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="impMst_cntr_no_flg" value="" class="trans"> Container No</div>
	          <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="impMst_seal_no_flg" value="" class="trans"> Seal No</div>
	          <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="impMst_cntr_pck_flg" value="" class="trans"> Package</div>
	          <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="impMst_cntr_wgt_flg" value="" class="trans"> Weight</div>
	          <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="impMst_cntr_meas_flg" value="" class="trans"> Measure</div>
	      </td>          
          <td style="text-align:left; ">
	          <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="impHus_cntr_no_flg" value="" class="trans"> Container No</div>
	          <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="impHus_seal_no_flg" value="" class="trans"> Seal No</div>
	          <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="impHus_cntr_pck_flg" value="" class="trans"> Package</div>
	          <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="impHus_cntr_wgt_flg" value="" class="trans"> Weight</div>
	          <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="impHus_cntr_meas_flg" value="" class="trans"> Measure</div>
	     </td>
      </tr>
      <tr style="text-align:center;">  
          <th class="tr2_head2" ">C/M</th>
          <td style="text-align:left; ">
	          <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="impMst_cntr_mf_pck_flg" value="" class="trans"> Package</div>
	          <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="impMst_cntr_mf_wgt_flg" value="" class="trans"> Weight</div>
	          <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="impMst_cntr_mf_meas_flg" value="" class="trans"> Measure</div>
	          <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="impMst_cntr_mf_desc_flg" value="" class="trans"> Description</div>
	          <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="impMst_cntr_mf_mk_flg" value="" class="trans"> Mark</div>
	          <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="impMst_cntr_mf_cmdt_flg" value="" class="trans"> HTS</div>
	          <br>
	          <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="impMst_cmdt_hs_cd_flg" value="" class="trans"> HS</div>
	          <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="impMst_cntr_mf_ncm_flg" value="" class="trans"> NCM</div>
	      </td> 
          <td style="text-align:left; ">
	          <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="impHus_cntr_mf_pck_flg" value="" class="trans"> Package</div>
	          <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="impHus_cntr_mf_wgt_flg" value="" class="trans"> Weight</div>
	          <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="impHus_cntr_mf_meas_flg" value="" class="trans"> Measure</div>
	          <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="impHus_cntr_mf_desc_flg" value="" class="trans"> Description</div>
	          <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="impHus_cntr_mf_mk_flg" value="" class="trans"> Mark</div>
	          <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="impHus_cntr_mf_cmdt_flg" value="" class="trans"> HTS</div>
	          <br>
	          <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="impHus_cntr_mf_ncm_flg" value="" class="trans"> NCM</div>
	     </td> 
      </tr>
      <tr style="text-align:center;">
          <th class="tr2_head2" ">Export/Import Ref #</th>
          <td style="text-align:left; ">
          	  <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="impMst_xpt_imp_ref_flg7" value="" class="trans"> IEC</div> 
          	  <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="impMst_xpt_imp_ref_flg6" value="" class="trans"> Tax ID</div>
          </td> 
          <td style="text-align:left; ">
              <div style="display:inline; padding:0px 10px 0px 15px; width:60px;"><input type="checkbox" id="chk" name="impHus_xpt_imp_ref_flg1" value="" class="trans"> Manifest File No.</div>
          </td>
      </tr>
	</table>
</div>	
<div class="opus_design_grid" style="width:98%; display:none;">
	<script type="text/javascript">ComSheetObject('sheet1');</script>
</div>
<!-- opus_design_grid(E) -->
</div>
</form>