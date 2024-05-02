<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MNR_0160.jsp
*@FileTitle  : Disposal Sold Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/21
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.mnr.operationmanage.disposalmgt.event.EesMnr0160Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesMnr0160Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Occurred error from server
	String strErrMsg = "";						//Error message
	int rowCount	 = 0;						//Row count of retrieved database data

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

		event = (EesMnr0160Event)request.getAttribute("Event");
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
	var usrId     = "<%=strUsr_id.trim()%>";

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
<input type="hidden" name="selected_disp_no" id="selected_disp_no">
<input type="hidden" name="selected_mnr_prnr_cnt_cd" id="selected_mnr_prnr_cnt_cd">
<input type="hidden" name="selected_mnr_prnr_seq" id="selected_mnr_prnr_seq">
<input type="hidden" name="status" id="status">
<input type="hidden" name="pagerows" id="pagerows">
<!-- RD용  -->
<input type="hidden" name="com_mrdPath" id="com_mrdPath" value="">
<input type="hidden" name="com_mrdArguments" id="com_mrdArguments" value="">
<input type="hidden" name="com_mrdBodyTitle" id="com_mrdBodyTitle" value="Disposal Sold Creation">
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn"><!-- 
	 --><button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!-- 
	  --><button type="button" class="btn_normal" name="btn_New"  id="btn_New">New</button><!-- 
	   --><button type="button" class="btn_normal" name="btn_Save" id="btn_Save">Save</button><!-- 
	    --><div id="iBtn_DocSend" style="display: none"><button type="button" class="btn_normal" name="btn_DocSend" id="btn_DocSend">Doc Send</button></div>	
	</div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
	<!-- page_title_area(E) -->
<div class="wrap_search">
		<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<tbody>
				<tr>
					<th width="40">Status</th>
					<td width="120"><script type="text/javascript">ComComboObject('comboStt', 1, 90, 1, 1);</script></td>
					<th width="40">EQ Type</th>
					<td width="120"><script type="text/javascript">ComComboObject('eq_knd_cd', 1, 100, 1, 1);</script></td>
					<th width="40">Approval Period</th>
					<td><!-- 
					 --><input type="text" name="apro_dt_fr" id="apro_dt_fr" style="width:80px;" class="input1" dataformat="ymd"  caption="From Date">~&nbsp;<!-- 
					  --><input type="text" name="apro_dt_to" id="apro_dt_to" style="width:80px;" class="input1" dataformat="ymd"  caption="To Date" ><!-- 
					   --><button type="button" class="calendar ir" name="apro_dt_cal" id="apro_dt_cal"></button>
					</td>
				</tr>
				<tr>
					<th>Disposal No.</td>
					<td><!-- 
					 --><input type="text" name="disp_no" id="disp_no" style="width:140px;" class="input" dataformat="engup" otherchar="-"><!-- 
					  --><button type="button" class="multiple_inq ir" name="disp_no_multi" id="disp_no_multi"></button>
					</td>
					<th>EQ No.</th>
					<td><!-- 
					 --><input type="text" name="eq_no" id="eq_no" style="width:140px;" class="input" dataformat="engup"><!-- 
					  --><button type="button" class="multiple_inq ir" name="eq_no_multi" id="eq_no_multi"></button>
					</td>
					<th>Buyer</th>
					<td><!-- 
					 --><input type="text" name="buyer_code" id="buyer_code" style="width:65px;text-align:center" class="input" dataformat="engup"><!-- 
					  --><button type="button" class="input_seach_btn" name="buyer_no_popup" id="buyer_no_popup"></button><!-- 
					   --><input type="text" name="buyer_name" id="buyer_name" style="width:200px;" class="input2"><!-- 
					    --><input type="hidden" name="mnr_prnr_cnt_cd" id="mnr_prnr_cnt_cd"><!-- 
					     --><input type="hidden" name="mnr_prnr_seq" id="mnr_prnr_seq">
					</td>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
	<div class="layout_wrap">
		<div class="layout_vertical_2">
			<div class="opus_design_grid" id="mainTable"">
				<div class="grid_option_left" style="height:29px;"><h3 class="title_design">Disposal List</h3></div>
				<script type="text/javascript">ComSheetObject('sheet1');</script>
			</div>
		</div>
		
		<div class="layout_vertical_2 pad_left_8">
			<div class="opus_design_grid" id="mainTable">	
				<div class="grid_option_left"><h3 class="title_design">Disposal Detail List</h3></div>
					<!-- opus_design_btn(S) -->
					<div class="opus_design_btn">
						<button type="button" class="btn_accent" name="btn_LoadExcel" id="btn_LoadExcel">Load Excel</button>
						<button type="button" class="btn_normal" name="btn_DownExcel"  	id="btn_DownExcel">Down Excel</button>							
					</div>
					<!-- opus_design_btn(E) -->
					<script type="text/javascript">ComSheetObject('sheet2');</script>
			</div>	
		</div>
     </div>	
</div>	
	<!-- layout_wrap(E) -->		
</form>