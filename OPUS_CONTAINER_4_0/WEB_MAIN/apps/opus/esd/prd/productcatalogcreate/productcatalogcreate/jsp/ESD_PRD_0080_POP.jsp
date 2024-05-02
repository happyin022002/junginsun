<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_PRD_0080.jsp
*@FileTitle  : Product Catalog
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/15
=========================================================
--%>
<%@page import="org.apache.commons.lang.time.DateUtils"%>
<%@page import="com.clt.framework.utility.CheckUtilities"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.event.EsdPrd0080Event"%>
<%@ page import="com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.vo.PrdCreateParamVO"%>
<%@ page import="com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.vo.PrdQuantityVO"%>
<%@ page import="com.clt.framework.core.controller.DefaultViewAdapter"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsdPrd0080Event  event = null;	
	Exception serverException   = null;
	String strErrMsg = "";
	String pctlNo = "";
	String ldd = "";
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		event = (EsdPrd0080Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage().replaceAll("\n", "").replaceAll("\r", "<||>");
		}  else  {
			pctlNo = JSPUtil.getParameter(request, "pctl_no") ;
			ldd = JSPUtil.getParameter(request, "ldd");  
			if(!CheckUtilities.isInBlank(ldd)) {
				ldd = DateTime.getFormatDate(ldd, "yyyyMMdd", "yyyy-MM-dd");
			}
		}
	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		}
		loadPage();
	}
</script>
</head>

<form name="form" id="form">
<input type="hidden" name="sXml" id="sXml" value="">
<input type="hidden" name="f_cmd" id="f_cmd" value="">
<input type="hidden" name="m_pu_dt" >
<input type="hidden" name="pctl_no" id="pctl_no" value="<%= pctlNo %>">
<input type="hidden" name="hd_pctl_no" id="hd_pctl_no" value="<%= pctlNo %>">
<input type="hidden" name="por" 	id="por" 	value="<%=JSPUtil.getParameter(request, "por") %>">
<input type="hidden" name="pol" 	id="pol" 	value="<%=JSPUtil.getParameter(request, "pol") %>">
<input type="hidden" name="pol_n" 	id="pol_n"	value="<%=JSPUtil.getParameter(request, "pol_n") %>">
<input type="hidden" name="m_pu" id="m_pu" value="">
<input type="hidden"  name="mt_pkup_dt" value="">
<input type="hidden" name="sum_bkg_qty" value="">
<input type="hidden" name="sum_ctp_sz" value="">
<input type="hidden" name="return_str" value="">
<input type="hidden" name="cnst_flg" value="">
<input type="hidden" name="pre_n1st_pol_dc" >
<input type="hidden" name="post_n1st_pol_dc" >
<input type="hidden" name="pre_n1st_pod_dc" >
<input type="hidden" name="post_n1st_pod_dc" >
<input type="hidden" name="pre_n2nd_pol_dc" >
<input type="hidden" name="post_n2nd_pol_dc" >
<input type="hidden" name="pre_n2nd_pod_dc" >
<input type="hidden" name="post_n2nd_pod_dc" >
<input type="hidden" name="pre_n3rd_pol_dc" >
<input type="hidden" name="post_n3rd_pol_dc" >
<input type="hidden" name="pre_n3rd_pod_dc" >
<input type="hidden" name="post_n3rd_pod_dc" >
<input type="hidden" name="pre_n4th_pol_dc" >
<input type="hidden" name="post_n4th_pol_dc" >
<input type="hidden" name="pre_n4th_pod_dc" >
<input type="hidden" name="post_n4th_pod_dc" >
<div class="layer_popup_title">
    <div class="page_title_area clear">
        <!-- page_title(S) -->
        <h2 class="page_title"><span> Product Catalog</span></h2>
        <div class="opus_design_btn">
            <button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
        </div>
    </div>
</div>
<div class="layer_popup_contents"  style="overflow:hidden;">
	<div class="wrap_result">
		<div class="opus_design_inquiry">
			<table>
	       		<tr class="h23">
	       			<th style="text-align:left;">Ocean Route : POL</th>
					<td><input type="" name="" class="input2" value="<%=JSPUtil.getParameter(request, "pol")%>" style="width:60px" readonly></td>
					<th class="align_center">
						* Yellow box is trunk lane &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;* Sorted by Cost -> Flag -> Priority
					</th>
	                <th class="align_center">Sailing Due Date</th>
	                <td><input name="fm_ld_dt" id="fm_ld_dt" type="text" maxlength="8" style="width:80px;" value="<%= ldd %>" dataformat="ymd" readonly="readonly"></td>
			  </tr>
			</table>
		</div>	
		<div class="opus_design_grid">
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
		<div class="opus_design_inquiry">
			<table>
				<tr class="h23">
	             	<th>Empty Pick Up Date</th>
	                <td><input name="fm_empty_dt" type="text" maxlength="8" style="width:80px;" value="" dataformat="ymd" ></td>
			 		<th class="align_left">*EQ Inventory information is subject to local situation. For accurate information<BR>&nbsp;&nbsp;Please contact your local operation department directly</th>
				</tr>
			</table>
		</div>
		 <div class="layout_vertical_2"  style="width:49%;">
			<div class="opus_design_inquiry" style="margin-top:12px;">
				<script type="text/javascript">ComSheetObject('sheet2');</script>
			</div>
		</div>
	<div class="layout_vertical_2"  style="width:50%; float:right;">
	<div class="opus_design_inquiry">
	<div id="sheet3Title" style="color:#3333ff; font-size: 11px;">&nbsp;</div>
		<script type="text/javascript">ComSheetObject('sheet3');</script>
	</div>
	</div>
	<table class="height_5"><tr><td></td></tr></table>
	<div class="opus_design_inquiry">
		<table>
			<colgroup>
				<col width="225" />
				<col width="150" />
				<col width="200" />
				<col width="" />
				<col/>
			</colgroup>
			<tbody>
			<tr class="h23">
				<th>
					Trans Mode
				</th>
				<td class="stm" colspan="3"> 
					<input type="radio" name='ob_trsp_mode' id="rdi01" value="" class="trans" checked onClick="javascript:chk_ob_trsp_mode(this);" ><label for="rdi01">Standard mode</label> <!-- 
					 --><input type="radio" name='ob_trsp_mode' id="rdi02" value="WD" class="trans" onClick="javascript:chk_ob_trsp_mode(this);"><label for="rdi02">Water Direct</label><!--
                     --><input type="radio" name='ob_trsp_mode' id="rdi03" value="RD" class="trans" onClick="javascript:chk_ob_trsp_mode(this);"><label for="rdi03">Rail Direct</label><!--
                     --><input type="radio" name='ob_trsp_mode' id="rdi04" value="TD" class="trans" onClick="javascript:chk_ob_trsp_mode(this);"><label for="rdi04">Truck Direct</label><!--
                     --><input type="radio" name='ob_trsp_mode' id="rdi05" value="TR" class="trans" onClick="javascript:chk_ob_trsp_mode(this);"><label for="rdi05">Truck + Rail</label><!--
                     --><input type="radio" name='ob_trsp_mode' id="rdi06" value="TW" class="trans" onClick="javascript:chk_ob_trsp_mode(this);"><label for="rdi06">Truck + Water</label>
                 </td>
			</tr>
	   		<tr>
				<th>
					Destination Inland Route (POD ~ DEL):
				</th>
				<td>
					<input  name="d_pod_cd" id="d_pod_cd" class="input2" value="" style="width:60px" readonly> ~<!-- 
					 --> <input  name="d_del_cd" class="input2" value="" style="width:60px" readonly>
		       	</td>
			 	<th>
			 		Estimated Arrival Date
			 	</th>
	            <td>
	            	<input name="arr_dt" id="arr_dt" type="text" maxlength="8" style="width:70px;" class="input2" value="" dataformat="ymd" readonly>  
				</td>
			</tr>
			<tr class="h23">
				<th>
					Trans Mode
				</th>
				<td class="stm"  colspan="3"> 
					<input type="radio" name='ib_trsp_mode' id="rdi11" value="" class="trans" checked onClick="javascript:chk_ib_trsp_mode(this);" ><label for="rdi11">Standard mode</label> <!-- 
					 --><input type="radio" name='ib_trsp_mode' id="rdi12" value="WD" class="trans" onClick="javascript:chk_ib_trsp_mode(this);"><label for="rdi12">Water Direct</label><!--
                     --><input type="radio" name='ib_trsp_mode' id="rdi13" value="RD" class="trans" onClick="javascript:chk_ib_trsp_mode(this);"><label for="rdi13">Rail Direct</label><!--
                     --><input type="radio" name='ib_trsp_mode' id="rdi14" value="TD" class="trans" onClick="javascript:chk_ib_trsp_mode(this);"><label for="rdi14">Truck Direct</label><!--
                     --><input type="radio" name='ib_trsp_mode' id="rdi15" value="TR" class="trans" onClick="javascript:chk_ib_trsp_mode(this);"><label for="rdi15">Truck + Rail</label><!--
                     --><input type="radio" name='ib_trsp_mode' id="rdi16" value="TW" class="trans" onClick="javascript:chk_ib_trsp_mode(this);"><label for="rdi16">Truck + Water</label>
                 </td>
			</tr>
			<tr>
				<th>Total Cost(USD)</th>
				<td><input name="ttl_expn_amt" id="ttl_expn_amt" value="" class="input2" type="text" style="width:70;" readonly ></td>
				<th>Total Transit(Day)</th>
				<td>
					<input name="transit_dt" class="input2" type="text" style="width:70;" readonly ><!-- 
					 --><button type="button" class="btn_etc" name="btng_fullroute" id="btng_fullroute"  >Full Route</button><!-- 
					 --><button type="button" class="btn_etc" name="btng_constraints" id="btng_constraints"  >Constraints</button>				
				</td>
			</tr>
			<tr>
				<th></th>
				<td></td>
				<th>eComm T/T (Day)</th>
				<td><input name="cml_tztm_day" id="cml_tztm_day" class="input2" type="text" style="width:70;" readonly ></td>
			</tr>
			</tbody>
		</table>
		</div>
	</div>
</div>
</form>