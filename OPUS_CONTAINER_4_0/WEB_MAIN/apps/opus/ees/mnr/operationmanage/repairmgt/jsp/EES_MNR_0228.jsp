<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MNR_0228.jsp
*@FileTitle  : M&R Reefer Spare Parts W/O Inquiry Pop Up
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/13
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.event.EesMnr0228Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%

	EesMnr0228Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Occurred error from server
	String strErrMsg = "";						//Error message
	int rowCount	 = 0;						//Row count of retrieved database data

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String rhqOfcCd         = "";
	String currOfcCd        = "";
	String currOfcEngNm     = "";
	Logger log = Logger.getLogger("com.clt.apps.OperationManage.RepairMgt");
	//Data for pop-up
	String mnrOrdOfcCtyCd = ((request.getParameter("mnr_ord_ofc_cty_cd")==null )?"":request.getParameter("mnr_ord_ofc_cty_cd"));
	String mnrOrdSeq = ((request.getParameter("mnr_ord_seq")==null )?"":request.getParameter("mnr_ord_seq"));
	String costOfcCd = ((request.getParameter("cost_ofc_cd")==null )?"":request.getParameter("cost_ofc_cd"));
	try {



	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id       = account.getUsr_id();
		strUsr_nm       = account.getUsr_nm();
		rhqOfcCd        = account.getRhq_ofc_cd();
		currOfcCd       = account.getOfc_cd();
		currOfcEngNm    = account.getOfc_eng_nm();


		event = (EesMnr0228Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		//Extracting retrieved data from server on load screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>


<script type="text/javascript">
    var currOfcCd = "<%=currOfcCd.trim() %>";
    var selectOfc  = "<% out.print(currOfcCd + "|" + currOfcEngNm); %>";
    var rhqOfcCd  = "<%=rhqOfcCd.trim() %>";
    var HOOfc     = "";
    var self_usr_nm = "<%=strUsr_nm%>";
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}

</script>

<form name="form">

<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="f_gubuns" id="f_gubuns" />
<input type="hidden" name="mnr_grp_tp_cd" value="RPR" id="mnr_grp_tp_cd" />
<input type="hidden" name="mnr_wo_tp_cd" value="RFS" id="mnr_wo_tp_cd" />
<input type="hidden" name="spr_prt_no" value="" id="spr_prt_no" />
<input type="hidden" name="agmt_ofc_cty_cd" value="<%=mnrOrdOfcCtyCd%>" id="agmt_ofc_cty_cd" />
<input type="hidden" name="agmt_seq" value="" id="agmt_seq" />
<input type="hidden" name="agmt_ver_no" value="" id="agmt_ver_no" />
<input type="hidden" name="sel_type" value="S" id="sel_type" />
<input type="hidden" name="cost_cd" value="MRRURC" id="cost_cd" />
<input type="hidden" name="vsl_cd" id="vsl_cd" />
<input type="hidden" name="skd_voy_no" id="skd_voy_no" />
<input type="hidden" name="skd_dir_cd" id="skd_dir_cd" />
<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><span>Reefer Spare Parts W/O Inquiry</span></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_close" id="btn_close" type="button">Close</button><!--
		--></div>
	<!-- opus_design_btn (E) -->

	<!-- page_location(S) -->
	<div class="location">	
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->
<div class="layer_popup_contents">
<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="100" />				
				<col width="100" />				
				<col width="*" />				
		   </colgroup> 
		   <tbody>
		   		<tr>
					<th>W/O No.</th>
					<td><input type="text" name="mnr_ord_seq" style="width:140px;" class="input2" value="<%=mnrOrdOfcCtyCd+mnrOrdSeq%>" readonly id="mnr_ord_seq" /> </td>
					<td align="right">Date <input type="text" name="showDate" style="width:80px;text-align:center;" class="input2" value="" readonly id="showDate" /> </td>
				</tr>
		   </tbody>
		</table>
		</div>
		<table class="line_bluedot"><tr><td></td></tr></table>
		<div class="opus_design_inquiry">
		<table>
			<colgroup>
				<col width="100" />				
				<col width="260" />		
				<col width="70" />				
				<col width="100" />		
				<col width="70" />				
				<col width="*" />				
		   </colgroup> 
		   <tbody>
		   		<tr>
					<th>Agreement No.</th>
					<td><input type="text" name="vndr_seq" style="width:140px;" class="input2" value="" dataformat="num" readonly id="vndr_seq" /> </td>
					<th>EQ Type</th>
					<td><input type="text" name="eq_knd_cd" style="width:80px;text-align:center;" class="input2" value="" readonly id="eq_knd_cd" /> </td>
					<th>Cost Control OFC</th>
					<td><input type="text" name="cost_ofc_cd" style="width:80px;text-align:center;" class="input2" value="<%=costOfcCd%>" readonly id="cost_ofc_cd" /> </td>
				</tr>
				<tr>
					<th>Service Provider</th>
					<td><input type="text" name="pic_eng_nm" style="width:250px;text-align:left;" class="input2" value="" readonly id="pic_eng_nm" /> </td>
					<th>Effective</th>
					<td><input type="text" name="eff_dt" style="width:80px;text-align:center;" class="input2" value="" readonly id="eff_dt" />~&nbsp;<input type="text" name="exp_dt" style="width:80px;text-align:center;" class="input2" value="" readonly id="exp_dt" /> </td>
					<th>Currency</th>
					<td><input type="text" name="curr_cd" style="width:80px;text-align:center;" class="input2" value="" readonly id="curr_cd" /> </td>
				</tr>
		   </tbody>
		</table>
		</div>
		<table class="line_bluedot"><tr><td></td></tr></table>
		<div class="opus_design_inquiry">
		<table>
			<colgroup>
				<col width="80" />				
				<col width="80" />		
				<col width="70" />				
				<col width="100" />		
				<col width="60" />	
				<col width="80" />		
				<col width="80" />				
				<col width="*" />				
		   </colgroup> 
		   <tbody>
		   		<tr>
					<th>Supply To</th>
					<td><input type="text" name="spr_prt_spl_tp_cd" style="width:70px;text-align:center;" class="input2" value="" readonly id="spr_prt_spl_tp_cd" /> </td>
					<th>VVD Code</th>
					<td><input type="text" name="vsl_vvd" style="width:90px;text-align:center;" class="input2" value="" readonly id="vsl_vvd" /> </td>
					<th>Yard</th>
					<td><input type="text" name="spr_prt_spl_yd_cd" style="width:70px;text-align:center;" class="input2" value="" readonly id="spr_prt_spl_yd_cd" /> </td>
					<th>Supply Date</th>
					<td><input type="text" name="spr_prt_spl_dt" style="width:80px;text-align:center;" class="input2" value="" readonly id="spr_prt_spl_dt" /> </td>
				</tr>
		   </tbody>
		</table>
			</div>
		<table class="line_bluedot"><tr><td></td></tr></table>
		<div class="wrap_result">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">
			<script type="text/javascript">ComSheetObject('sheet1');</script>		
		</div>
		<div class="opus_design_grid clear" >
			<script type="text/javascript">ComSheetObject('sheet2');</script>
		</div>
		<!-- opus_design_grid(E) -->
		</div>
		<table class="line_bluedot"><tr><td></td></tr></table>
		<div class="opus_design_inquiry">
		<table style="display:none;">
		   <tbody>
				<tr>
				<td>
				 <script type="text/javascript">ComComboObject('combo_vndr_seq',9, 0, 1, 1,2,false,1);</script><!-- 
				  --><script type="text/javascript">ComComboObject('combo_eq_knd_cd',6, 80, 1, 1,1,false,1);</script><!-- 
				  --><script type="text/javascript">ComComboObject('combo_spr_prt_spl_tp_cd',2, 60 , 1, 0,2,false,1);</script>
				 </td>
				 </tr>
		   </tbody>
		</table>
		
		 <!-- layout_wrap(S) -->
		<div class="layout_wrap" style="padding-bottom:10px">
		  <div class="layout_flex_flex" style="padding-right:208px;">
		    	<!-- opus_design_inquiry(S) -->
				<div class="opus_design_inquiry" >
					<h3 class="title_design mar_top_12">Recent Supply  Information</h3>
					<table>
						<colgroup>
							<col width="80" />				
							<col width="90" />	
							<col width="80" />				
							<col width="*" />				
					   </colgroup> 
					   <tbody>
							<tr>
								<th>Vessel Code</th>
								<td><input type="text" name="vsl_cd2" style="width:80px;text-align:center;" class="input2" value="" readonly id="vsl_cd2" /> </td>
								<th>Supply Yard</th>
								<td><input type="text" name="spr_prt_spl_yd_cd2" style="width:80px;text-align:center;" class="input2" value="" readonly id="spr_prt_spl_yd_cd2" /> </td>
							</tr>
							<tr>
								<th>Supply Date</th>
								<td><input type="text" name="spr_prt_spl_dt2" style="width:80px;text-align:center;" class="input2" value="" readonly id="spr_prt_spl_dt2" /> </td>
								<th>Supply S/P</th>
								<td><input type="text" name="pic_eng_nm2" style="width:300px;text-align:left;" class="input2" value="" readonly id="pic_eng_nm2" /> </td>
							</tr>
					   </tbody>
					</table>
				</div>
				<!-- opus_design_inquiry(E) -->
		    </div>
  			<div class="layout_flex_fixed floatR" style="width:200px">
				<!-- opus_design_inquiry(S) -->
				<div class="opus_design_inquiry">
					<table class="grid_2">
						<tr>
							<th>Remark(s)</th>
						</tr>
						<tr>
							<td class="input2"><textarea  name="ord_hdr_rmk" id="ord_hdr_rmk" style="width:100%;height:45px;resize:none;"  class="textarea2" readonly></textarea></td>
						</tr>
						</table>
				</div>
				<!-- opus_design_inquiry(E) -->
		    </div>
		</div>
		<!-- layout_wrap(e) -->
		
	</div>
	<!-- opus_design_inquiry(E) -->
</div>
</div>

</form>

