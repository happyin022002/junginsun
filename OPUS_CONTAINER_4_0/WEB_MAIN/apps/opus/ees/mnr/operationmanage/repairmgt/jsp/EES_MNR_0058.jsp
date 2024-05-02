<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MNR_0058.jsp
*@FileTitle : M&R Extra Expense W/O Creation
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.event.EesMnr0058Event" %>
<%@ page import="org.apache.log4j.Logger" %>

<%

	EesMnr0058Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Occurred error from server
	String strErrMsg = "";						//Error message
	int rowCount	 = 0;						//Row count of retrieved database data

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

		event = (EesMnr0058Event)request.getAttribute("Event");
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

<form name="form" id="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="f_gubuns">
<input type="hidden" name="mnr_grp_tp_cd" value="RPR">
<input type="hidden" name="mnr_wo_tp_cd" value="EXT">
<input type="hidden" name="agmt_ofc_cty_cd" value="">
<input type="hidden" name="agmt_seq" value="">
<input type="hidden" name="agmt_ver_no" value="">
<input type="hidden" name="file_seq" value="">



	<!-- page_title_area(S) -->
	<div class="page_title_area clear ">
		<!-- page_title(S) -->
		<h2 class="page_title">
			<button type="button">
				<span id="title">Extra W/O Creation </span>
			</button>
		</h2>
		<!-- page_title(E) -->
	
		    <!-- opus_design_btn(S) -->
		    <div class="opus_design_btn">
		        <!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
				<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--  
				--><button type="button" class="btn_normal" name="btn_New"   id="btn_New">New</button><!--
				--><button type="button" class="btn_normal" name="btn_W/O_Creation"   id="btn_W/O_Creation">W/O Creation</button><!--
				--><button type="button" class="btn_normal" name="btn_W/O_Send"   id="btn_W/O_Send">W/O Send</button><!--
				--><button type="button" class="btn_normal" name="btn_delete"   id="btn_delete">Delete</button>
		    </div>
		    <!-- opus_design_btn(E) -->
	    
		<!-- page_location(S) -->
		<div class="location">
			<!-- location 내용 동적생성 (별도 코딩 불필요) -->
			<span id="navigation"></span>
		</div>
		<!-- page_location(E) -->
	
	</div>
	<!-- page_title_area(E) -->
	
	
	<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry">
	    <!-- 조회영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    <table>
	       
	        	<colgroup>
		            <col width="50">
		            <col width="320">
		            <col width="50">
		            <col width="250">
		            <col width="50">
		            <col width="120">
		            <col width="*">
		        </colgroup>
		         <tbody>
				<tr>
					<th>W/O No.</th>
					<td><input required type="text" style="width:90px;" class="input1" value="" name="mnr_ord_seq" id="mnr_ord_seq" dataformat="engup"><button type="button" class="input_seach_btn" name="btn_WONo" id="btn_WONo"></button></td>
					<th></th>
					<td></td>
					<th>Date</th>
					<td><input type="text" style="width:75px;" class="input2" value="" name="showDate" id="showDate" readonly></td>
					<td></td>
				</tr>
				<tr>
					<th>Agreement No.</th>
					<td><script type="text/javascript">ComComboObject('combo_vndr_seq',12, 250, 1, 1,2,false,1);</script><input type="hidden" name="vndr_seq" id="vndr_seq"></td>
					<th>EQ Type</th>
					<td><script type="text/javascript">ComComboObject('combo_eq_knd_cd',6, 80, 1, 1,1,false,1);</script><input type="hidden" name="eq_knd_cd" id="eq_knd_cd"></td>
					<th>Cost CTRL Office</th>
					<td><input type="text" style="width:75px;text-align:center;" class="input2" value="" name="cost_ofc_cd" id="cost_ofc_cd"></td>
					<td></td>
				</tr>
				<tr>
					<th>Service Provider</th>
					<td><input type="text" style="width:250px;" class="input2" value="" name="pic_eng_nm" id="pic_eng_nm" readonly></td>
					<th>Effective</th>
					<td><input type="text" style="width:80px;" class="input2" value="" name="eff_dt" id="eff_dt" readonly>~ <input type="text" style="width:80px;" class="input2" value="" name="exp_dt"  id="exp_dt" readonly></td>
					<th>Currency</th>
					<td><input type="text" style="width:75px;text-align:center;" class="input2" value="" name="curr_cd" id="curr_cd"></td>
					<td></td>
				</tr>
			</tbody>
		</table>
	    <!-- 조회영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	</div>
	<!-- opus_design_inquiry(E) -->
	</div>

	<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" id="mainTable">
		<table style="width:400px">
			<colgroup>
				<col width="60"/>
				<col width="300"/>
				<col width="*"/>
			</colgroup>
			<tbody>
			<tr>
				<th>Cost Type</th>
				<td><script type="text/javascript">ComComboObject('combo_cost_cd',4, 250 , 1, 1,2,false,1);</script><input type="hidden" name="cost_cd" id="cost_cd"></td>
				<td></td>
			</tr>
			</tbody>
		</table>
				
	    <!-- opus_design_btn(S) -->
	    <div class="opus_design_btn" style="margin-top:-25px;">
	        <!-- 그리드 버튼 영역(데이터 그리드 상단에 위치) -->
	        <!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
	        <button type="button" class="btn_normal" name="btn_RowAdd" id="btn_RowAdd">Row Add</button>
	        <button type="button" class="btn_normal" name="btn_RowDel" id="btn_RowDel">Row Delete</button>
	        <button type="button" class="btn_normal" name="btn_excelDown" id="btn_excelDown">Down Excel</button>
	    </div>
	    <!-- opus_design_btn(E) -->
	    
	    <!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    <script type="text/javascript">ComSheetObject('sheet1');</script>
	    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    
	</div>
	<!-- opus_design_grid(E) -->
	
	

<!-- opus_design_grid(S) -->
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
	                          <textarea name="ord_hdr_rmk" id="ord_hdr_rmk"  rows="8" style="ime-mode:disabled;resize:none" style="width:100%; height:106px;" maxlength="4000">Pls supply the parts to the vsl today.</textarea>
	                       </td>
	                   </tr>
	               </tbody>
	           </table>
	       </div>
	   </div>
	   <div class="layout_vertical_2" style="width:30%">
	   		<div class="opus_design_grid">
				<div class="opus_design_btn">
			        <!-- 그리드 버튼 영역(데이터 그리드 상단에 위치) -->
			        <!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
			        <button type="button" class="btn_normal" name="btn_File_Add" id="btn_File_Add">Row Add</button>
			        <button type="button" class="btn_normal" name="btn_File_Del" id="btn_File_Del">Row Delete</button>
			    </div>
			    <script type="text/javascript">ComSheetObject('sheet2');</script>
			</div>
		</div>
	</div>
		

	<div style="display:none">
		<script type="text/javascript">ComSheetObject('sheet3');</script>
		<script type="text/javascript">ComUploadObject('upload1', '<=session.getId()%>');</script>
	</div>
	</div>
</form>