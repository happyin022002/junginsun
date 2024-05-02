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
	int rowCount	 = 0;

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String xml = "";   
	String ldd ="";
	String pc_ldd ="";
	String mt_pu_dt ="";
	String m_rt ="";
	String calllFunc  = "";
	String est_arr_dt  = "";
	String map_seq  = "";
	String cnst_flg  = "";
	String pod_cd  = "";
	String ttl_expn_amt  = "";
	String sum_bkg_qty  = "";
	String sum_ctp_sz  = "";
	
	String pre_n1st_pol_dc = "";
	String post_n1st_pol_dc = "";
	String pre_n1st_pod_dc = "";
	String post_n1st_pod_dc = "";
	String pre_n2nd_pol_dc = "";
	String post_n2nd_pol_dc = "";
	String pre_n2nd_pod_dc = "";
	String post_n2nd_pod_dc = "";
	String pre_n3rd_pol_dc = "";
	String post_n3rd_pol_dc = "";
	String pre_n3rd_pod_dc = "";
	String post_n3rd_pod_dc = "";
	String pre_n4th_pol_dc = "";
	String post_n4th_pol_dc = "";
	String pre_n4th_pod_dc = "";
	String post_n4th_pod_dc = "";

	String n1st_pol_dc_seq = "";
	String n1st_pod_dc_seq = "";
	String n2nd_pol_dc_seq = "";
	String n2nd_pod_dc_seq = "";
	String n3rd_pol_dc_seq = "";
	String n3rd_pod_dc_seq = "";
	String n4th_pol_dc_seq = "";
	String n4th_pod_dc_seq = "";
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsdPrd0080Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage().replaceAll("\n", "").replaceAll("\r", "<||>");
		} else {
			GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
			
			calllFunc  = JSPUtil.getParameter(request, "func");
			
			DefaultViewAdapter adapter = new DefaultViewAdapter();   
			xml = adapter.makeXML(request, response).replaceAll("\"", "&quot;");

			ldd = JSPUtil.getNull(eventResponse.getETCData("ldd")); // 
			est_arr_dt = JSPUtil.getNull(eventResponse.getETCData("arr_dt"));
			pod_cd = JSPUtil.getNull(eventResponse.getETCData("pod_cd"));
			ttl_expn_amt = JSPUtil.getNull(eventResponse.getETCData("ttl_expn_amt"));

			pc_ldd = JSPUtil.getNull(eventResponse.getETCData("pc_ldd")); //loadding due date of pc dtl
			mt_pu_dt = JSPUtil.getNull(eventResponse.getETCData("mt_pu_dt"));
			map_seq = JSPUtil.getNull(eventResponse.getETCData("map_seq"));
			cnst_flg = JSPUtil.getNull(eventResponse.getETCData("cnst_flg"));
			sum_bkg_qty = JSPUtil.getNull(eventResponse.getETCData("sum_bkg_qty"));
			sum_ctp_sz = JSPUtil.getNull(eventResponse.getETCData("sum_ctp_sz"));
	 
			m_rt = JSPUtil.getParameter(request, "m_rt") ;
			
			if(!m_rt.equals("")) {
				mt_pu_dt = m_rt;
			}
		} 
	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
	function setupPage(){
		var errMessage = '<%=strErrMsg%>';
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		}
		loadPage();
	}
</script>
</head>

<form name="form" id="form">
<input type="hidden" name="sXml" id="sXml" value="">
<input type="hidden" name="f_cmd" id="f_cmd" value="<%=JSPUtil.getParameter(request, "f_cmd") %>">
<input type="hidden" name="pagerows" id="pagerows">
<input type="hidden" name="calllFunc" id="calllFunc" value="<%=calllFunc%>">
<input type="hidden" name="valChk" id="valChk" value="">


<!-- maininfoVo -->
<input type="hidden" id="pc_mode" 	name="pc_mode" value="<%=JSPUtil.getParameter(request, "pc_mode") %>">   
<input type="hidden" id="cnst_del_flg" 	name="cnst_del_flg" value="Y"> 
<input type="hidden" id="rcv_t" 	name="rcv_t" value="<%=JSPUtil.getParameter(request, "rcv_t") %>">
<input type="hidden" id="por" 		name="por"   value="<%=JSPUtil.getParameter(request, "por") %>">
<input type="hidden" id="del_t" 	name="del_t" value="<%=JSPUtil.getParameter(request, "del_t") %>">
<input type="hidden" id="por_n" 	name="por_n" value="<%=JSPUtil.getParameter(request, "por_n") %>">
<input type="hidden" id="pol" 		name="pol"   value="<%=JSPUtil.getParameter(request, "pol") %>">
<input type="hidden" id="pol_n" 	name="pol_n" value="<%=JSPUtil.getParameter(request, "pol_n") %>">
<input type="hidden" id="pod" 		name="pod" value="<%=JSPUtil.getParameter(request, "pod") %>">
<input type="hidden" id="pod_n" 	name="pod_n" value="<%=JSPUtil.getParameter(request, "pod_n") %>">
<input type="hidden" id="del" 		name="del" value="<%=JSPUtil.getParameter(request, "del") %>">
<input type="hidden" id="del_n" 	name="del_n" value="<%=JSPUtil.getParameter(request, "del_n") %>">
<input type="hidden" id="t_vvd" 	name="t_vvd" value="<%=JSPUtil.getParameter(request, "t_vvd") %>">
<input type="hidden" id="pod1" 		name="pod1" value="<%=JSPUtil.getParameter(request, "pod1") %>">
<input type="hidden" id="pod1_n" 	name="pod1_n" value="<%=JSPUtil.getParameter(request, "pod1_n") %>">
<input type="hidden" id="pol1" 		name="pol1" value="<%=JSPUtil.getParameter(request, "pol1") %>">
<input type="hidden" id="pol1_n" 	name="pol1_n" value="<%=JSPUtil.getParameter(request, "pol1_n") %>">
<input type="hidden" id="vvd1" 		name="vvd1" value="<%=JSPUtil.getParameter(request, "vvd1") %>">
<input type="hidden" id="lane1" 	name="lane1" value="<%=JSPUtil.getParameter(request, "lane1") %>">
<input type="hidden" id="pod2" 		name="pod2" value="<%=JSPUtil.getParameter(request, "pod2") %>">
<input type="hidden" id="pod2_n" 	name="pod2_n" value="<%=JSPUtil.getParameter(request, "pod2_n") %>">
<input type="hidden" id="pol2" 		name="pol2" value="<%=JSPUtil.getParameter(request, "pol2") %>">
<input type="hidden" id="pol2_n" 	name="pol2_n" value="<%=JSPUtil.getParameter(request, "pol2_n") %>">
<input type="hidden" id="vvd2"		name="vvd2" value="<%=JSPUtil.getParameter(request, "vvd2") %>">
<input type="hidden" id="lane2"	 	name="lane2" value="<%=JSPUtil.getParameter(request, "lane2") %>">
<input type="hidden" id="pod3" 		name="pod3" value="<%=JSPUtil.getParameter(request, "pod3") %>">
<input type="hidden" id="pod3_n"	name="pod3_n" value="<%=JSPUtil.getParameter(request, "pod3_n") %>">
<input type="hidden" id="pol3" 		name="pol3" value="<%=JSPUtil.getParameter(request, "pol3") %>">
<input type="hidden" id="pol3_n" 	name="pol3_n" value="<%=JSPUtil.getParameter(request, "pol3_n") %>">
<input type="hidden" id="vvd3" 		name="vvd3" value="<%=JSPUtil.getParameter(request, "vvd3") %>">
<input type="hidden" id="lane3"	 	name="lane3" value="<%=JSPUtil.getParameter(request, "lane3") %>">
<input type="hidden" id="pod4" 		name="pod4" value="<%=JSPUtil.getParameter(request, "pod4") %>">
<input type="hidden" id="pod4_n" 	name="pod4_n" value="<%=JSPUtil.getParameter(request, "pod4_n") %>">
<input type="hidden" id="pol4" 		name="pol4" value="<%=JSPUtil.getParameter(request, "pol4") %>">
<input type="hidden" id="pol4_n" 	name="pol4_n" value="<%=JSPUtil.getParameter(request, "pol4_n") %>">
<input type="hidden" id="vvd4" 		name="vvd4" value="<%=JSPUtil.getParameter(request, "vvd4") %>">
<input type="hidden" id="lane4" 	name="lane4" value="<%=JSPUtil.getParameter(request, "lane4") %>">
<input type="hidden" id="ld_dt" 	name="ld_dt" value="<%=JSPUtil.getParameter(request, "ld_dt") %>">

<input type="hidden" id="dr_dt" 	name="dr_dt" value="<%=JSPUtil.getParameter(request, "dr_dt") %>">
<input type="hidden" id="m_pu" 		name="m_pu" value="<%=JSPUtil.getParameter(request, "m_pu").toUpperCase() %>">
<input type="hidden" id="f_rt" 		name="f_rt" value="<%=JSPUtil.getParameter(request, "f_rt") %>">
<input type="hidden" id="cgo_tp" 	name="cgo_tp" value="<%=JSPUtil.getParameter(request, "cgo_tp") %>">
<input type="hidden" id="pm_f" 		name="pm_f" value="<%=JSPUtil.getParameter(request, "pm_f") %>">
<input type="hidden" id="dg_f" 		name="dg_f" value="<%=JSPUtil.getParameter(request, "dg_f") %>">
<input type="hidden" id="rf_f"  	name="rf_f" value="<%=JSPUtil.getParameter(request, "rf_f") %>">
<input type="hidden" id="ak_f" 		name="ak_f" value="<%=JSPUtil.getParameter(request, "ak_f") %>">
<input type="hidden" id="bb_f" 		name="bb_f" value="<%=JSPUtil.getParameter(request, "bb_f") %>">
<input type="hidden" id="rd_f" 		name="rd_f" value="<%=JSPUtil.getParameter(request, "rd_f") %>">
<input type="hidden" id="soc_f" 	name="soc_f" value="<%=JSPUtil.getParameter(request, "soc_f") %>">
<input type="hidden" id="com" 		name="com" value="<%=JSPUtil.getParameter(request, "com") %>">
<input type="hidden" id="rep_com" 	name="rep_com" value="<%=JSPUtil.getParameter(request, "rep_com") %>">
<input type="hidden" id="bkg_ofc" 	name="bkg_ofc" value="<%=JSPUtil.getParameter(request, "bkg_ofc") %>">
<input type="hidden" id="org_sal_ofc" name="org_sal_ofc" value="<%=JSPUtil.getParameter(request, "org_sal_ofc") %>">
<input type="hidden" id="rfa" 		name="rfa" value="<%=JSPUtil.getParameter(request, "rfa") %>">
<input type="hidden" id="sc" 		name="sc" value="<%=JSPUtil.getParameter(request, "sc") %>">
<input type="hidden" id="rfa_ofc" 	name="rfa_ofc" value="<%=JSPUtil.getParameter(request, "rfa_ofc") %>">
<input type="hidden" id="sc_ofc" 	name="sc_ofc" value="<%=JSPUtil.getParameter(request, "sc_ofc") %>">
<input type="hidden" id="shpr" 		name="shpr" value="<%=JSPUtil.getParameter(request, "shpr") %>">
<input type="hidden" id="cngn" 		name="cngn" value="<%=JSPUtil.getParameter(request, "cngn") %>">
<input type="hidden" id="wgt" 		name="wgt" value="<%=JSPUtil.getParameter(request, "wgt") %>">
<input type="hidden" id="wgt_un" 	name="wgt_un" value="<%=JSPUtil.getParameter(request, "wgt_un") %>">
<input type="hidden" id="hg_f" 		name="hg_f" value="<%=JSPUtil.getParameter(request, "hg_f") %>">
<input type="hidden" id="sub_f" 	name="sub_f" value="<%=JSPUtil.getParameter(request, "sub_f") %>">
<input type="hidden" id="bkg_no" 	name="bkg_no" value="<%=JSPUtil.getParameter(request, "bkg_no") %>">
<input type="hidden" id="imdg" 		name="imdg" value="<%=JSPUtil.getParameter(request, "imdg") %>">
<input type="hidden" id="hitchment" name="hitchment" value="<%=JSPUtil.getParameter(request, "hitchment") %>">
<input type="hidden" id="com_bkg_no" name="com_bkg_no" value="<%=JSPUtil.getParameter(request, "com_bkg_no") %>">
<input type="hidden" id="copy_cnt" name="copy_cnt" value="<%=JSPUtil.getParameter(request, "copy_cnt") %>">
<input type="hidden" id="no_cost"	name="no_cost" value="<%=JSPUtil.getParameter(request, "no_cost") %>">
<input type="hidden" id="flex_hgt_flg" name="flex_hgt_flg" value="<%=JSPUtil.getParameter(request, "flex_hgt_flg") %>">
<input type="hidden" id="chk_yd" 	name="chk_yd" value="">
<!-- maininfoVo end-->
<!-- QuantityVO start-->
<%

PrdQuantityVO[] prdQuantityVO = event.getPrdQuantityVOs();
for (int i = 0; i < prdQuantityVO.length; i++) {

%>
<input type="hidden" id="c_tpsz" 	name="c_tpsz" value="<%=prdQuantityVO[i].getCTpsz() %>">
<input type="hidden" id="c_qty" 	name="c_qty" value="<%=prdQuantityVO[i].getCQty() %>">
<!-- QuantityVO end-->
<% 
}
%>
<input type="hidden" name="pctl_no" >
<input type="hidden"  name="m_pu_dt" >
<input type="hidden" name="map_seq" value="<%=map_seq %>">
<input type="hidden"  name="mt_pkup_dt" value="<%=JSPUtil.getParameter(request, "mt_pkup_dt") %>">
<input type="hidden" name="cnst_flg" value="<%=cnst_flg %>">

<input type="hidden" name="return_str" >
<input type="hidden" name="sum_bkg_qty" value="<%=sum_bkg_qty %>">
<input type="hidden" name="sum_ctp_sz" value="<%=sum_ctp_sz %>">
<input type="hidden" name="bkg_rcv_t" value="<%=event.getPrdCreateParamVO().getBkgRcvT() %>">
<input type="hidden" name="bkg_del_t" value="<%=event.getPrdCreateParamVO().getBkgDelT() %>">

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

<input type="hidden" name="n1st_pol_dc_seq" value="<%=JSPUtil.getParameter(request, "pol1_c") %>">
<input type="hidden" name="n1st_pod_dc_seq" value="<%=JSPUtil.getParameter(request, "pod1_c") %>">
<input type="hidden" name="n2nd_pol_dc_seq" value="<%=JSPUtil.getParameter(request, "pol2_c") %>">
<input type="hidden" name="n2nd_pod_dc_seq" value="<%=JSPUtil.getParameter(request, "pod2_c") %>">
<input type="hidden" name="n3rd_pol_dc_seq" value="<%=JSPUtil.getParameter(request, "pol3_c") %>">
<input type="hidden" name="n3rd_pod_dc_seq" value="<%=JSPUtil.getParameter(request, "pod3_c") %>">
<input type="hidden" name="n4th_pol_dc_seq" value="<%=JSPUtil.getParameter(request, "pol4_c") %>">
<input type="hidden" name="n4th_pod_dc_seq" value="<%=JSPUtil.getParameter(request, "pod4_c") %>">


<input type="hidden" name="n1st_pol_clpt_ind_seq" value="">
<input type="hidden" name="n1st_pod_clpt_ind_seq" value="">
<input type="hidden" name="n2nd_pol_clpt_ind_seq" value="">
<input type="hidden" name="n2nd_pod_clpt_ind_seq" value="">
<input type="hidden" name="n3rd_pol_clpt_ind_seq" value="">
<input type="hidden" name="n3rd_pod_clpt_ind_seq" value="">
<input type="hidden" name="n4th_pol_clpt_ind_seq" value="">
<input type="hidden" name="n4th_pod_clpt_ind_seq" value="">
<input type="hidden" name="more_cnt" id="more_cnt" value="">
					
<div class="layer_popup_title">
    <!-- page_title_area(S) -->
    <div class="page_title_area clear">
        <!-- page_title(S) -->
        <h2 class="page_title">
            <span> Product Catalog</span>
        </h2>
        <!-- page_title(E) -->

        <!-- opus_design_btn(S) -->
        <div class="opus_design_btn">
            <button type="button" class="btn_normal" name="btn_select" id="btn_select">Select</button><!--
            --><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
        </div>
        <!-- opus_design_btn(E) --> 

        <!-- page_location(S) -->
        <div class="location">
            <span id="navigation"></span>
        </div>
        <!-- page_location(E) -->
    </div>
<!-- page_title_area(E) -->
</div>

<div class="layer_popup_contents">
<div class="wrap_result">
	<div class="opus_design_inquiry"  style="width:1000px;">
		<table>
       		<tr>
       			<th style="text-align:left; width:100px">Ocean Route : POL</th>
				<td>
					<input type="" name="" class="input2" value="<%=JSPUtil.getParameter(request, "pol")%>" style="width:60px" readonly>
				</td>
				<th class="align_center">
					* Yellow box is trunk lane &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;* Sorted by Cost -> Flag -> Priority
				</th>
                <th class="align_center">
                	Sailing Due Date
                </th>
                <td>
                	<input name="fm_ld_dt" id="fm_ld_dt" type="text" maxlength="8" style="width:80px;" value="<%=ldd %>" dataformat="ymd"><!-- 
                	 --><button type="button" class="calendar ir" name="btns_LddCalendar" id="btns_LddCalendar"></button>  
				</td>
		  </tr>
		</table>
	</div>
	<div class="opus_design_btn">
    	<button type="button" class="btn_normal" name="btn_more" id="btn_more">More</button>
	</div>	
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	
	<table class="height_10"><tr><td></td></tr></table>

	<div class="opus_design_inquiry"  style="width:1000px;">
		<table>
			<tr class="h23">
             	<th>
             		Empty Pick Up Date
             	</th>
                <td>
                	<input name="fm_empty_dt" type="text" maxlength="8" style="width:80px;" value="" dataformat="ymd" ><!--
                	--><button type="button" class="calendar ir" name="btns_EmptyCalendar" id="btns_EmptyCalendar"></button>  
				</td>
		 		<th class="align_left">
		 			*EQ Inventory information is subject to local situation. For accurate information<BR>&nbsp;&nbsp;Please contact your local operation department directly
		 		</th>
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
	<div class="opus_design_inquiry"  style="width:1000px;">
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
                        <input type="radio" name='ob_trsp_mode' id="rdi07" value="PR" class="trans" onClick="javascript:chk_ob_trsp_mode(this);"><label for="rdi07">Priority</label>
                         <input type="text" name='ob_prio_seq' id="ob_prio_seq" class="trans" onChange="javascript:chk_ob_trsp_mode(this);">
                 </td>
			</tr>
	   		<tr>
				<th>
					Destination Inland Route (POD ~ DEL):
				</th>
				<td>
					<input  type="hidden" id="d_por_cd" class="input2" value="" style="width:60px" readonly>
					<input  name="d_pod_cd" id="d_pod_cd" class="input2" value="<%=pod_cd %>" style="width:60px" readonly> ~<!-- 
					 --> <input  id="d_del_cd" class="input2" value="<%=JSPUtil.getParameter(request, "del") %>" style="width:60px" readonly>
		       	</td>
			 	<th>
			 		Estimated Arrival Date
			 	</th>
	            <td>
	            	<input name="arr_dt" id="arr_dt" type="text" maxlength="8" style="width:70px;" class="input2" value="<%=est_arr_dt %>" dataformat="ymd" readonly>  
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
                         <input type="radio" name='ib_trsp_mode' id="rdi17" value="PR" class="trans" onClick="javascript:chk_ib_trsp_mode(this);"><label for="rdi17">Priority</label>
                         <input type="text" name='ib_prio_seq' id="ib_prio_seq" class="trans" onChange="javascript:chk_ib_trsp_mode(this);">
                 </td>
			</tr>
			<tr>
				<th>Total Cost(USD)</th>
				<td><input name="ttl_expn_amt" id="ttl_expn_amt" value="<%=ttl_expn_amt %>" class="input2" type="text" style="width:70;" readonly ></td>
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
		<div id="sheet4Title" style="display:none">&nbsp;</div>
			<script type="text/javascript">ComSheetObject('sheet4');</script>
		</div>
		</div>
	</div>
</div>
</form>