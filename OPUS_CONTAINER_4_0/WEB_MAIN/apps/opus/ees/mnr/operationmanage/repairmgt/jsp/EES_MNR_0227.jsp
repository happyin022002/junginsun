<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MNR_0227.jsp
*@FileTitle  : M&R Extra W/O Inquiry Pop Up
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/22
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.event.EesMnr0227Event" %>
<%@ page import="org.apache.log4j.Logger" %>

<%

	EesMnr0227Event  event = null;				//PDTO(Data Transfer Object including Parameters)
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

		event = (EesMnr0227Event)request.getAttribute("Event");
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
<input type="hidden" name="mnr_wo_tp_cd" value="EXT" id="mnr_wo_tp_cd" />

<input type="hidden" name="agmt_ofc_cty_cd" value="<%=mnrOrdOfcCtyCd%>" id="agmt_ofc_cty_cd" />
<input type="hidden" name="agmt_seq" value="" id="agmt_seq" />
<input type="hidden" name="agmt_ver_no" value="" id="agmt_ver_no" />
<input type="hidden" name="file_seq" value="" id="file_seq" />
<!-- page_title_area(S) -->
<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>Extra W/O Inquiry</span></h2>
		<div class="opus_design_btn">
			<button class="btn_accent" name="btn_close" id="btn_close" type="button">Close</button>
		</div>
	</div>
</div>
<!-- page_title_area(E) -->
<!-- wrap_search(S) -->
<div class="wrap_search">
<!-- opus_design_inquiry(S) -->
<div class="opus_design_inquiry wFit">
	<table>
		<tbody>
			<colgroup>
				<col width="100" />
				<col width="10" />
				<col width="10" />
				<col width="*" />
			</colgroup>
			<tr class="h23">
				<th>W/O No.</th>
				<td><input type="text" name="mnr_ord_seq" style="width:140px;" class="input2" value="<%=mnrOrdOfcCtyCd+mnrOrdSeq%>" readonly id="mnr_ord_seq" /></td>
				<th>Date</th>
				<td><input type="text" name="showDate" style="width:80px;text-align:center;" class="input2" value="" readonly id="showDate" /></td>
			</tr>
		</tbody>
	</table>
	<table>
		<tbody>
			<colgroup>
				<col width="100" />
				<col width="10" />
				<col width="10" />
				<col width="10" />
				<col width="10" />
				<col width="*" />
			</colgroup>
			<tr class="h23">
				<th>Agreement No.</th>
				<td><input type="text" name="vndr_seq" style="width:140px;" class="input2" value="" dataformat="num" readonly id="vndr_seq" /></td>
				<th>EQ Type</th>
				<td><input type="text" name="eq_knd_cd" style="width:80px;text-align:center;" class="input2" value="" readonly id="eq_knd_cd" /></td>
				<th>Cost Control OFC</th>
				<td><input type="text" name="cost_ofc_cd" style="width:80px;text-align:center;" class="input2" value="<%=costOfcCd%>" readonly id="cost_ofc_cd" /></td>
			</tr>
			<tr class="h23">
				<th>Service Provider</th>
				<td><input type="text" name="pic_eng_nm" style="width:250px;text-align:left;" class="input2" value="" readonly id="pic_eng_nm" /></td>
				<th>Effective</th>
				<td><input type="text" name="eff_dt" style="width:80px;text-align:center;" class="input2" value="" readonly id="eff_dt" />~ <input type="text" name="exp_dt" style="width:80px;text-align:center;" class="input2" value="" readonly id="exp_dt" /></td>
				<th>Currency</th>
				<td><input type="text" name="curr_cd" style="width:80px;text-align:center;" class="input2" value="" readonly id="curr_cd" /></td>
			</tr>
		</tbody>
	</table>
	<table>
		<tbody>
			<colgroup>
				<col width="100" />
				<col width="*" />
			</colgroup>
			<tr class="h23">
				<th>Cost Type</th>
				<td><input type="text" name="cost_cd" style="width:140px;" class="input2" value="" readonly id="cost_cd" /></td>
			</tr>
		</tbody>
	</table>
</div>
<!-- opus_design_grid(S) -->
<div class="opus_design_grid" style="width: 100%;">
	<script type="text/javascript">ComSheetObject('sheet1');</script>
	<table style="display:none">
		<tbody>
			<colgroup>
				<col width="100" />
				<col width="*" />
			</colgroup>
			<tr>
				<td></td>
				<td>
				 <script type="text/javascript">ComComboObject('combo_vndr_seq',9, 0, 1, 1,2,false,1);</script>
				 <script type="text/javascript">ComComboObject('combo_eq_knd_cd',6, 80, 1, 1,1,false,1);</script>
				 <script type="text/javascript">ComComboObject('combo_cost_cd',3, 250 , 1, 1,2,false,1);</script>
			 	</td>
			 </tr>
		</tbody>
	</table>
</div>
<!-- opus_design_grid(E) -->
<!-- <div class="opus_design_inquiry wFit"> -->
	
	
	
<!-- </div> -->
<!-- opus_design_inquiry(E) -->
<!-- layout_wrap(S) -->
<div class="layout_wrap">
	   <!-- layout_vertical_2(S) -->
	   <div class="layout_vertical_2 pad_rgt_8" style="width:70%">
	       <!-- opus_design_grid(S) -->
	       <div class="opus_design_grid">
	           <table class="grid2">
	               <tbody>
	                   <tr>
	                       <th style="font-weight: bold">Expense For</th>
	                   </tr>
	                   <tr>
	                       <td>
	                          <textarea name="ord_hdr_rmk" id="ord_hdr_rmk" style="ime-mode:disabled;resize:none;width:100%; height:88px;" maxlength="4000"></textarea>
	                       </td>
	                   </tr>
	               </tbody>
	           </table>
	       </div>
	   </div>
	   <div class="layout_vertical_2" style="width:30%;">
	   		<div class="opus_design_grid">
<!-- 				<div class="opus_design_btn"> -->
<!-- 			        그리드 버튼 영역(데이터 그리드 상단에 위치) -->
<!-- 			        버튼 name / ID정의되어 있음. 별도 지정 금지 -->
<!-- 			        <button type="button" class="btn_normal" name="btn_File_Add" id="btn_File_Add">Row Add</button> -->
<!-- 			        <button type="button" class="btn_normal" name="btn_File_Del" id="btn_File_Del">Row Delete</button> -->
<!-- 			    </div> -->
			    <script type="text/javascript">ComSheetObject('sheet2');</script>
			</div>
		</div>
	</div>
<!-- layout_wrap(E) -->
</div>
<!-- wrap_search(E) -->

<!-- wrap_result(S) -->
<div class="wrap_result" style="display:none">
<script type="text/javascript">ComSheetObject('sheet3');</script>
<script type="text/javascript">ComUploadObject('upload1', '<=session.getId()%>');</script>
</div>
<!-- wrap_result(E) -->

</form>

