<%  
/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName   : esm_bkg_0272.jsp
 *@FileTitle  :  Full CNTR Release Order
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/05/06
 =========================================================*/
%>

<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%
  String bl_no = JSPUtil.getNull(request.getParameter("bl_no"));
  String cntr_no = JSPUtil.getNull(request.getParameter("cntr_no"));
  
  String code = "";
  String value = "";
  String mainpage = "";
  mainpage = JSPUtil.getNull(request.getParameter("mainPage"));
  //getting data from server when load the initial screen
  GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
  code = eventResponse.getETCData("code");
  value = eventResponse.getETCData("value");
  
%>
<script type="text/javascript">

var evtCode = "<%=code %>|";
var evtValue = "<%=value %>|";

function setupPage()
{  
 
	$('<button type="button" class="btn_accent" name="btn_Retrieve"	id="btn_Retrieve">Retrieve</button>').appendTo("#btnArea");
	$('<button type="button" class="btn_normal" name="btn_Save"	        id="btn_Save">Pin no Save</button>').appendTo("#btnArea");
    $('<button type="button" class="btn_normal" name="btn_DownExcel"  	id="btn_DownExcel">Down Excel</button>').appendTo("#btnArea");
    $('<button type="button" class="btn_normal" name="btn_CNTRMvmt" 	id="btn_CNTRMvmt">CNTR MVMT</button>').appendTo("#btnArea");
    $('<button type="button" class="btn_normal" name="btn_Remark"		id="btn_Remark">Remark(s)</button>').appendTo("#btnArea");
    $('<button type="button" class="btn_normal" name="btn_EMail"   id="btn_EMail">E-Mail</button>').appendTo("#btnArea");
    $('<button type="button" class="btn_normal" name="btn_EDI"   id="btn_EDI">EDI</button>').appendTo("#btnArea");
    $('<button type="button" class="btn_normal" name="btn_CargoRelease"   id="btn_CargoRelease">Cargo Release</button>').appendTo("#btnArea");
    $('<button type="button" class="btn_normal" name="btn_Print"   id="btn_Print">Print</button>').appendTo("#btnArea");
    
    $('#btn_Print').after($('#btn_Close'));
    
    document.getElementById("title").innerHTML = "EU Full Container Release";
	
	loadPage();
}

</script>
<form name="form">
<input type="hidden" name="f_cmd" value="">
<input type="hidden" name="in_option" value="VVD">
<input type="hidden" name="pre_bl_no" value="<%=bl_no%>">
<input type="hidden" name="in_checktype" value="">

<input type="hidden" name="p_row" value="">
<input type="hidden" name="p_diff_rmk" value="">
<input type="hidden" name="p_err" value="">
<input type="hidden" name="p_bl_no" value="">
<input type="hidden" name="p_bkg_no" value="">
<input type="hidden" name="p_cntr_no" value="">
<input type="hidden" name="p_cntr_tpsz_cd" value="">
<input type="hidden" name="p_cust_nm" value="">
<input type="hidden" name="p_yd_cd" value="">
<input type="hidden" name="p_vvd" value="">
<input type="hidden" name="p_pol_cd" value="">
<input type="hidden" name="p_pod_cd" value="">
<input type="hidden" name="p_do_no_yn" value="">
<input type="hidden" name="p_do_no" value="">
<input type="hidden" name="p_do_iss_dt" value="">
<input type="hidden" name="p_fax_no" value="">
<input type="hidden" name="p_bkg_trsp_mod_cd" value="">
<input type="hidden" name="p_cgo_pkup_dt" value="">
<input type="hidden" name="p_cxl_flg" value="">
<input type="hidden" name="p_de_term_cd" value="">
<input type="hidden" name="p_sent_flg" value="">
<input type="hidden" name="p_send_date" value="">
<input type="hidden" name="mailcontent" value="">

<input type="hidden" name="p_yd_nm" value="">
<input type="hidden" name="p_yd_eml" value="">
<input type="hidden" name="p_phn_no" value="">
<input type="hidden" name="p_vsl_nm" value="">
<input type="hidden" name="p_loc_nm" value="">
<input type="hidden" name="p_pin_no" value="">

<input type="hidden" name="mailXml" value="">
<input type="hidden" name="mailSendYn" value="">
<%@include file="../../../../bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_TOP.jsp"%>

<%if(!mainPage.equals("true")){%><div class="layer_popup_contents"><%}%>
	<div class="wrap_search">
		<div class="opus_design_inquiry">
			 <table>
			 <colgroup>
			 	<col width="40"/>
			 	<col width="110"/>
			 	<col width="30"/>
			 	<col width="90"/>
			 	<col width="60"/>
			 	<col width="130"/>
			 	<col width="40"/>
			 	<col width="110"/>
			 	<col width="40"/>
			 	<col width="*"/>
			 </colgroup>
			 <tbody>
                  <tr>                  		                  	
                  	<th><input type="radio" value="" class="trans" name="rad_vvd" id="rad_vvd"><!----><label for="rad_vvd">VVD</label></th>                    		                    	                    	                      
                    <td><input type="text" style="width:90px;ime-mode:disabled;" caption="VVD" class="input1" value="" name='in_vvd' dataformat="engup"  required maxlength="9" fullfill="fullfill"></td>
                    <th title="Port of Discharging">POD</th>
                    <td><input type="text" style="width:60px;ime-mode:disabled;" caption="POD" class="input1" value="" name="in_pod" dataformat="engup"  required maxlength="5" fullfill="fullfill"></td>	                    
                    <th><input type="radio" value=""class="trans" name="rad_bl"><!----><label for="rad_vvd">B/L No</label></th>
                    <td><input type="text" class="input11" style="width:105px;ime-mode:disabled;" caption="B/L No" class="" value="<%=bl_no%>" name="in_bl_no" id="in_bl_no" dataformat="engup"  maxlength="13" required="" /></td>
                    <th>CNTR</th>
	                <td><input type="text" style="width:90px;ime-mode:disabled;" class="input" value="<%=cntr_no %>" name="in_cntr_no" dataformat="engup"  maxlength="14"></td>
		                <th>D/O</th>
		                <td>
		                  <select style="width:70px;" name="in_do_no">
		                    <option value="" selected>All</option>
		                    <option value="Y" >Y</option>
		                    <option value="N" >N</option>
		                  </select>
		                </td>
                    </tr>
              </tbody>
            </table>
		</div>		
	</div>
	
	<div class="wrap_result">
		<div class="opus_design_grid">
			<script type="text/javascript">ComSheetObject('sheet1');</script>
			<script type="text/javascript">ComSheetObject('sheet2');</script>
		</div>
	</div>
<%if(!mainPage.equals("true")){	%></div><%}%>
</form>

 