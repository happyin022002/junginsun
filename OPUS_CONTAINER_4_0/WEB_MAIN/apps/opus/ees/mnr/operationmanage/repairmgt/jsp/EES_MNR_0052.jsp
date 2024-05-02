<%
/*=========================================================  
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : EES_MNR_0052.jsp
*@FileTitle  :Simple Expense W/O Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/20
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.event.EesMnr0052Event" %>
<%@ page import="org.apache.log4j.Logger" %>

<%

	EesMnr0052Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//Error message
	int rowCount	 = 0;						//count of DB resultSet list
	 
	String strUsr_id		= "";
	String strUsr_nm		= "";
	String rhqOfcCd         = "";
	String currOfcCd        = "";
	String currOfcEngNm     = "";
	Logger log = Logger.getLogger("com.clt.apps.OperationManage.RepairMgt");
	        
	try {     
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id       = account.getUsr_id();
		strUsr_nm       = account.getUsr_nm(); 
		rhqOfcCd        = account.getRhq_ofc_cd();
		currOfcCd       = account.getOfc_cd();
		currOfcEngNm    = account.getOfc_eng_nm();
		
		event = (EesMnr0052Event)request.getAttribute("Event"); 
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
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">
<input type="hidden" name="f_gubuns" id="f_gubuns">
<input type="hidden" name="mnr_grp_tp_cd" id="mnr_grp_tp_cd" value="RPR">
<input type="hidden" name="mnr_wo_tp_cd" id="mnr_wo_tp_cd" value="SPL">

<input type="hidden" name="agmt_ofc_cty_cd" id="agmt_ofc_cty_cd" value="">
<input type="hidden" name="agmt_seq" id="agmt_seq" value="">
<input type="hidden" name="agmt_ver_no" id="agmt_ver_no" value="">

<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrive" id="btn_retrive">Retrieve</button>
		<button type="button" class="btn_normal" name="btn_new"  	id="btn_new">New</button>
		<button type="button" class="btn_normal" name="btn_W/O_Creation" 	id="btn_W/O_Creation">W/O Creation</button>
		<button type="button" class="btn_normal" name="btn_W/O_Send" 	id="btn_W/O_Send">W/O Send</button>
		<button type="button" class="btn_normal" name="btn_save" 	id="btn_save">Delete</button>	
	</div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->

<!-- opus_design_inquiry(S) -->
<div class= "wrap_search">
	<div class="opus_design_inquiry">
		<table>
		<colgroup>
          <col width="90" />
          <col width="50" />
          <col width="90" />
          <col width="50" />
          <col width="90" />
          <col width="50" />
          <col width="*" />
         </colgroup>		
			<tbody>
				<tr>
					<th>W/O No.</th>
					<td><input type="text" style="width:90px;" class="input1" value="" name="mnr_ord_seq" id="mnr_ord_seq"  required dataformat="engup">
						<button type="button" name="btn_WONo" id="btn_WONo" class="input_seach_btn"></button>
					</td>
					<th>Date</th>
					<td style="padding-left:2px;"><input type="text" style="width:80px;" class="input2" value="" name="showDate" id="showDate" readonly></td>
					<td colspan="3"></td>
				</tr> 
				<tr class="line_bluedot" ><td colspan="7" style="heigth:25px;">&nbsp;</td></tr>
				<tr>
					<th>Agreement No.</th>
					<td><script type="text/javascript">ComComboObject('combo_vndr_seq',9, 250, 1, 1,2,false,1);</script>
					<input type="hidden" name="vndr_seq"></td>
					<th>EQ Type</th>
					<td><script type="text/javascript">ComComboObject('combo_eq_knd_cd',6, 80, 1, 1,1,false,1);</script>
					<input type="hidden" name="eq_knd_cd"  id="eq_knd_cd"></td>
					<th>Cost CTRL Office</th>
					<td><input type="text" style="width:50px;" class="input2" value="" name="cost_ofc_cd" id="cost_ofc_cd" readonly></td>
					<td></td>
				</tr> 
				<tr>
					<th>Service Provider</th>
					<td><input type="text" style="width:250px;" class="input2" value="" name="pic_eng_nm" id="pic_eng_nm" readonly></td>
					<th>Effective</th>
					<td><input type="text" style="width:80px;" class="input2" value="" name="eff_dt" id="eff_dt"  readonly> ~ 
					<input type="text" style="width:80px;" class="input2" value="" name="exp_dt" id="exp_dt"  readonly></td>
					<th>Currency</th>
					<td><input type="text" style="width:50px;" class="input2" value="" name="curr_cd" id="curr_cd" readonly></td>
					<td></td>
				</tr>
				
			</tbody>
		</table>
	</div>
</div>
<!-- opus_design_inquiry(E) -->

<!-- opus_design_grid(S) -->
<div class="wrap_result">
	<div class="opus_design_grid clear" id="mainTable" name="mainTable">
		<table style="width:500px">
		<colgroup>
          <col width="70" />
          <col width="160" />
          <col width="60" />
          <col width="*" />
        </colgroup>		
			<tbody>
				<tr>
					<th>Cost Type </th>
					<td><script type="text/javascript">ComComboObject('combo_cost_cd',4, 250 , 1, 1,2,false,1);</script>
					<input type="hidden" name="cost_cd" id="cost_cd"></td>
					<th><input type="checkbox" class="trans" name="rpr_offh_flg" id="rpr_offh_flg">Off-hire</th>
					<td> &nbsp;</td>
				</tr> 
			</tbody>
		</table>
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_calc" id="btn_calc">Calculation</button>
			<button type="button" class="btn_normal" name="btn_add" 	id="btn_add">Row Add</button>
			<button type="button" class="btn_normal" name="btn_delete"  id="btn_delete">Row Delete</button>
			<button type="button" class="btn_normal" name="btn_downExcel" 	id="btn_downExcel">Down Excel</button>
			<button type="button" class="btn_normal" name="btn_loadExcel"  id="btn_loadExcel">Load Excel</button>
		</div>
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
<!-- opus_design_grid(E) -->


<!-- opus_design_grid(S) -->
	<div class="opus_design_grid clear">
			<script type="text/javascript">ComSheetObject('sheet2');</script>
	</div>

<!-- opus_design_grid(E) -->

<!-- opus_design_data(S) -->
	<div class="opus_design_data">
	<table class="grid2 wFit">
		<tbody>
			<tr>
				<th style="width:80px; text-align:left;padding-left:15px;" class="tr2_head">Remark(s)</th>
				<td style="width:*"><textarea name="ord_hdr_rmk" id="ord_hdr_rmk" style="ime-mode:disabled" style="width:100%;height:40px;" maxlength="4000"></textarea>
					<textarea name="ord_hdr_rmk_org" id="ord_hdr_rmk_org" style="display:none" style="width:0;height:0" maxlength="4000"></textarea></td>
				<td style="width:20px;"></td>
			</tr>
		</tbody>
	</table>
	</div>
<!-- opus_design_data(E) -->
<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" id="hideTable" name="hideTable" style="display:none;">
			<script type="text/javascript">ComSheetObject('sheet3');</script>
	</div>
<!-- opus_design_grid(E) -->
<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" id="hideTable" name="hideTable" style="display:none;">
			<script type="text/javascript">ComSheetObject('sheet4');</script>
	</div>
<!-- opus_design_grid(E) -->
</div>
</form>			
<%@include file="/bizcommon/include/common_opus.jsp" %>
