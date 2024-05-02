<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : EES_MNR_0226.jsp
*@FileTitle  : M&R Simple W/O Inquiry Pop Up
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
<%@ page import="com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.event.EesMnr0226Event" %>
<%@ page import="org.apache.log4j.Logger" %>

<%

	EesMnr0226Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//Error message
	int rowCount	 = 0;						//count of DB resultSet list
	 
	String strUsr_id		= "";
	String strUsr_nm		= "";
	String rhqOfcCd         = "";
	String currOfcCd        = "";
	String currOfcEngNm     = "";
	Logger log = Logger.getLogger("com.clt.apps.OperationManage.RepairMgt");
	//data for popup			 	
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
		
		event = (EesMnr0226Event)request.getAttribute("Event"); 
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
 
		if (serverException != null) {   
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();  
		}       
		
		// adding logic to get data from sever when first loading
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
<input type="hidden" name="mnr_wo_tp_cd" value="SPL" id="mnr_wo_tp_cd" />
<input type="hidden" name="agmt_ofc_cty_cd" value="<%=mnrOrdOfcCtyCd%>" id="agmt_ofc_cty_cd" />
<input type="hidden" name="agmt_seq" value="" id="agmt_seq" />
<input type="hidden" name="agmt_ver_no" value="" id="agmt_ver_no" />
<div class="layer_popup_title">
		<!-- page_title_area(S) -->
		<div class="page_title_area clear">
		   <!-- page_title(S) -->
			<h2 class="page_title"><span>Simple W/O Inquiry</span></h2>
			<!-- page_title(E) -->
			<!-- opus_design_btn(S) -->
			<div class="opus_design_btn">
				<button type="button" class="btn_accent" name="btn_Close"  		id="btn_Close">Close</button>	
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
	<!-- opus_design_inquiry(S) -->
	<div class= "wrap_search">
		<div class= "opus_design_inquiry wFit">
			<table>
					<colgroup>
						<col width="80"/>
						<col width="200"/>
						<col width="80"/>
						<col width="200"/>
						<col width="80"/>
						<col width="*"/>
				    </colgroup>
				    <tbody>
					<tr>
						<th>W/O No.</th>
						<td colspan="3"><input type="text" name="mnr_ord_seq" style="width:140px;" class="input2" value="<%=mnrOrdOfcCtyCd+mnrOrdSeq%>" readonly id="mnr_ord_seq" /></td>
						<th>Date</th>
						<td><input type="text" name="showDate" style="width:80px;text-align:center;" class="input2" value="" id="showDate" /></td>
					</tr>
					<tr class="line_bluedot"><td colspan="6"></td></tr>	
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
						<td><input type="text" name="pic_eng_nm" style="width:250px;text-align:left;" class="input2" value="" readonly id="pic_eng_nm" /></td>
						<th>Effective</th>
						<td><input type="text" name="eff_dt" style="width:80px;text-align:center;" class="input2" value="" readonly id="eff_dt" />~&nbsp;<input type="text" name="exp_dt" style="width:80px;text-align:center;" class="input2" value="" readonly id="exp_dt" /> </td>
						<th>Currency</th>
						<td><input type="text" name="curr_cd" style="width:80px;text-align:center;" class="input2" value="" readonly id="curr_cd" /> </td>
					</tr>
					<tr class="line_bluedot"><td colspan="6"></td></tr>
					<tr style="display:none;">
						<td colspan="6"><script type="text/javascript">ComComboObject('combo_vndr_seq',9, 0, 1, 1,2,false,1);</script><!-- 
						 --><script type="text/javascript">ComComboObject('combo_eq_knd_cd',6, 80, 1, 1,1,false,1);</script><!-- 
						 --><script type="text/javascript">ComComboObject('combo_cost_cd',3, 250 , 1, 1,2,false,1);</script>
						 </td>
				    </tr>
					<tr>
						<th>Cost Type</th>
						<td colspan="5"><input type="text" name="cost_cd" style="width:140px;" class="input2" value="" readonly id="cost_cd" /><!-- 
						 --><label for="rpr_offh_flg"><b>Off-hire</b></label><!--
						   --><input name="rpr_offh_flg" type="checkbox" class="trans" disabled="true" readonly id="rpr_offh_flg" /> </td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	<!-- opus_design_inquiry(E) -->
	<!-- opus_design_grid(S) -->
	<div class="wrap_result">
		<div class="opus_design_grid clear" >
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
		<div class="opus_design_grid clear" >
			<div class="opus_design_inquiry"><table><tr><td><h3 class="title_design">Summary Information</h3></td></tr></table></div>
			<script type="text/javascript">ComSheetObject('sheet2');</script>
		</div>
		<div class="opus_design_inquiry" >
			<table class="grid_2">
				<colgroup>
						<col width="80"/>
						<col width="*"/>
				</colgroup>
				<tr>
					<th><b>Remark(s)</b></th>
					<td><textarea name="ord_hdr_rmk" id="ord_hdr_rmk" style="width:100%;height:40px;resize:none" readonly></textarea><!-- 
					--><textarea name="ord_hdr_rmk_org" id="ord_hdr_rmk_org" style="display:none"></textarea></td>
				</tr>
			</table>
		</div>
		<div class="opus_design_grid clear" >
			<script type="text/javascript">ComSheetObject('sheet3');</script>
		</div>
		<div class="opus_design_grid clear" >
			<script type="text/javascript">ComSheetObject('sheet4');</script>
		</div>
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>