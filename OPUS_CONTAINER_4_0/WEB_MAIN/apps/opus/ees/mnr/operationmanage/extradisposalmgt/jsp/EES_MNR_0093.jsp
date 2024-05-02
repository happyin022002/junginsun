<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   :EES_MNR_0093.jsp
*@FileTitle  : Scrapping/Donation Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/14
=========================================================
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.mnr.operationmanage.extradisposalmgt.event.EesMnr0093Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesMnr0093Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//Error message
	int rowCount	 = 0;						//count of DB resultSet list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String rhqOfcCd         = "";
	String currOfcCd       = "";
	String currOfcEngNm     = "";
	Logger log = Logger.getLogger("com.clt.apps.PlanManage.PlanMgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id    =	account.getUsr_id();
		strUsr_nm    = 	account.getUsr_nm();
		rhqOfcCd     = 	account.getRhq_ofc_cd();
		currOfcCd    = 	account.getOfc_cd();
		currOfcEngNm = 	account.getOfc_eng_nm();

		event = (EesMnr0093Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
	strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		//adding logic to get data from sever when first loading
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
	var currOfcCd = "<%=currOfcCd.trim() %>";
	var usrId     = "<%=strUsr_id.trim()%>";

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}

</script>
<script type="text/javascript">ComSheetObject('sheet1');</script>

<form name="form" id="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="eq_tpsz_cd" id="eq_tpsz_cd" />
<input type="hidden" name="pagerows" id="pagerows" />
	<!-- page_title_area(S) -->
	<div class="page_title_area clear ">
		<!-- page_title(S) -->
		<h2 class="page_title">
			<button type="button">
				<span id="title">Scrapping & Donation Creation</span>
			</button>
		</h2>
		<!-- page_title(E) -->
	
		    <!-- opus_design_btn(S) -->
		    <div class="opus_design_btn">
		        <!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
				<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!-- 
				 --><button type="button" class="btn_normal" name="btn_New"   id="btn_New">New</button><!-- 
				 --><button type="button" class="btn_normal" name="btn_Save"   id="btn_Save">Save</button><!-- 
				 --><button type="button" class="btn_normal" name="btn_Confirm"   id="btn_Confirm">Confirm</button><!-- 
				 --><button type="button" class="btn_normal" name="btn_Cancel"   id="btn_Cancel">Cancel</button>
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
<div class= "wrap_search">
<!-- opus_design_inquiry(S) -->
	<div class= "opus_design_inquiry wFit">
	    <table>
	         <colgroup>
	            <col width="1" />
	            <col width="130" />
	            <col width="100" />
	            <col width="100" />
	            <col width="100" />
	            <col width="100" />
	            <col width="100" />
	            <col width="100" />
	            <col width="100" />
	            <col width="" />
	        </colgroup> 
	        <tbody>
				<tr>
					<th>EQ Type</th>
					<td><script type="text/javascript">ComComboObject('eq_knd_cd', 1, 100, 1, 1);</script></td>
					<th>EQ No.</th>
					<td><input type="text" name="eq_no" style="width:90px;" class="input1" dataformat="engup" maxlength="14" required="" id="eq_no" /> </td>
					<th>EQ Status</th>
					<td><script type="text/javascript">ComComboObject('xtra_disp_sts_cd', 1, 150, 1, 0);</script></td>
					<th>Creation Office</th>
					<td><input type="text" name="ofc_cd" style="width:50px;" class="input2" readonly="true" value="<%=currOfcCd.trim()%>" id="ofc_cd" /> </td>
					<th>Creation User</th>
					<td><input type="text" name="cre_usr_id" style="width:80px;" class="input2" readonly="true" value="<%=strUsr_id.trim()%>" id="cre_usr_id" /> </td>
				</tr>
		</tbody>
	</table>
	</div>
</div>

<div class="wrap_result" style="background-color:#fff;">

<div class="layout_wrap">
	<div class="layout_flex_fixed" style="width:500px; height:200px">
	<h3 class="title_design">Creation</h3>	
   	<table>
    <tbody>
        <colgroup>
           <col width="60"/>
           <col width="80"/>
           <col width="200"/>
           <col width="">
       </colgroup> 
			<tr>
				<th>Type</th>
				<td><script type="text/javascript">ComComboObject('mnr_xtra_disp_tp_cd', 1, 100, 1, 1);</script></td>
				<th>Issue Date</th>
				<td><input type="text" name="iss_dt" style="width:75px;text-align:center" class="input1" dataformat="ymd" maxlength="10" id="iss_dt" /><button type="button" id="iss_dt_cal" name="iss_dt_cal" class="calendar ir"></button></td>
			</tr>
			<tr>
				<th>Request Office</th>
				<td><script type="text/javascript">ComComboObject('iss_ofc_cd', 1, 100, 0, 1);</script></td>
				<th>Issue Yard</th>
				<td><input type="text" name="iss_yd_cd" style="width:100px;" class="input1" dataformat="engup" maxlength="7" id="iss_yd_cd" /><button type="button" id="btn_yard_popup" name="btn_yard_popup" class="input_seach_btn"></button></td>
			</tr>
			<tr>
				<th>Currency</th>
				<td><script type="text/javascript">ComComboObject('curr_cd', 1, 100, 0, 1);</script></td>
			</tr>
			<tr>
				<th>Income Total</th>
				<td><input type="text" name="xtra_disp_incm_amt" style="width:100px;text-align:right" class="input" dataformat="float" maxlength="14" pointcount="2" caption="Float(Maximum Minimum)" id="xtra_disp_incm_amt" /> </td>
				<th>Expense Total</th>
				<td><input type="text" name="xtra_disp_expn_amt" style="width:100px;text-align:right" class="input" dataformat="float" maxlength="14" pointcount="2" caption="Float(Maximum Minimum)" id="xtra_disp_expn_amt" /> </td>
			</tr>
		</tbody>
	</table>
</div>

<div class="layout_flex_flex" style="padding-left:512px">
<!-- opus_design_grid(S) -->
<div class="opus_design_grid"  id="mainTable">
    <!-- opus_design_btn(S) -->
   <div class="opus_design_btn">
       <button type="button" class="btn_normal" name="btn_FileAdd" id="btn_FileAdd">Row Add</button><!-- 
        --><button type="button" class="btn_normal" name="btn_FileDel" id="btn_FileDel">Row Delete</button>
   </div>
   <!-- opus_design_btn(E) -->
   <script type="text/javascript">ComSheetObject('sheet2');</script>
</div>
</div>
</div>

	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry">
	    <table class="grid2">
	         <colgroup>
	            <col width="60" />
	            <col width="" />
	        </colgroup> 
	        <tbody>
				<tr>
					<th>Donation Information<br>(Given to)</th>
					<td><textarea name="xtra_disp_desc" id="xtra_disp_desc" style="resize:none;width:100%;" rows="5" maxLength="4000"></textarea></td>
				</tr>
				<tr>
					<th>Remark(s)</th>
					<td><textarea name="xtra_disp_rmk" id="xtra_disp_rmk" style="resize:none;width:100%;" rows="2" maxLength="4000"></textarea></td>
				</tr>
			</tbody>
		</table>
	</div>

</div>
	<!-- opus_design_inquiry(E) -->
<div style="display:none">
	<script type="text/javascript">ComUploadObject('upload1', '<%=session.getId()%>');</script>
</div>
</form>


