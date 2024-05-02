<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0142.jsp
*@FileTitle  : Customer Code Entry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.canada.event.EsmBkg0142Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0142Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	
	Logger log = Logger.getLogger("com.clt.apps.CustomsDeclaration.ManifestListDownload");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg0142Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// getting data from server when load the initial screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
	
%>

<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>


<form name="form" method="post" id="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows" value="<%=pageRows %>">
<input type="hidden" name="subcmd">

	
	<!-- page_title_area(S) -->
	<div class="page_title_area clear ">
		<!-- page_title(S) -->
		<h2 class="page_title">
			<button type="button">
				<span id="title">ACI Report</span>
			</button>
		</h2>
		<!-- page_title(E) -->
	
		    <!-- opus_design_btn(S) -->
		    <div class="opus_design_btn">
				<button type="button" class="btn_accent" 	name="btn_retrieve" 	id="btn_retrieve">Retrieve</button><!--
				--><button type="button" class="btn_normal" name="btn_new"   		id="btn_new">New</button><!-- 
				--><button type="button" class="btn_normal" name="btn_downexcel"   	id="btn_downexcel">Down Excel</button><!-- 
				--><button type="button" class="btn_normal" name="btn_print"  	 	id="btn_print">Print</button><!-- 
				--><button type="button" class="btn_normal" name="btn_37"   		id="btn_37">37/01</button><!-- 
				--><button type="button" class="btn_normal" name="btn_21"   		id="btn_21">21/01</button>
		    </div>
		    <!-- opus_design_btn(E) -->
		    
		<!-- page_location(S) -->
		<div class="location">
			<span id="navigation"></span>
		</div>
		<!-- page_location(E) -->
	
	</div>
	<!-- page_title_area(E) -->

<div class="wrap_search">
	<!-- layout_wrap(S) -->
	<div class="layout_wrap wFit">
	    <div class="layout_vertical_2" style="width: 10%">
	        <!-- opus_design_inquiry (S) -->
	        <div class="opus_design_inquiry">
			    <table>
			        <tbody>
						<tr><td class="sm pad_left_12"><input type="radio" class="trans" checked id="A6A" name="rpt_flag" value="F"><label for="A6A"><strong>Full (A6A)</strong></label></td></tr>
						<tr><td class="sm pad_left_12"><input type="radio" class="trans" id="E10" name="rpt_flag" value="M"><label for="E10"><strong>Empty (E10)</strong></label></td></tr>
						<tr><td class="sm pad_left_12"><input type="radio" class="trans" id="A6"name="rpt_flag" value="V"><label for="A6"><strong>Vessel (A6)</strong></label></td></tr>
					</tbody>
				</table>
			</div>
	        <!-- opus_design_inquiry (E) -->
	    </div>
	    <div class="layout_vertical_2 pad_left_8" style="width: 90%">
	        <!-- opus_design_inquiry(S) -->
			<div class="opus_design_inquiry mar_top_4	">
				<table>
					<colgroup>
						<col width="50" />
						<col width="90" />
						<col width="40" />
						<col width="60" />
						<col width="40" />
						<col width="60" />
						<col width="100" />
						<col width="200" />
						<col width="80" />
						<col width="*" />
					</colgroup>
					<tbody>
						<tr>
							<th title="Vessel Voyage Direction">VVD</th>
							<td><input type="text" style="width:80px;ime-mode:disabled" class="input" name="vvd_cd" dataformat="engup" maxlength="9" caption="VVD" fullfill /></td> 
							<th title="Port of Loading">POL</th>
							<td><input type="text" style="width:50px;ime-mode:disabled" class="input" name="pol_cd" dataformat="engup" maxlength="5" caption="POL" fullfill /></td> 
							<th title="Port of Discharging">POD</th>
							<td><input type="text" style="width:50px;ime-mode:disabled" class="input" name="pod_cd" dataformat="engup" maxlength="5" caption="POD" fullfill /></td>
							<th>Send Date</th>
							<td><!--
							--><input type="text" style="width:85px;ime-mode:disabled" name="s_snd_dt" class="input" dataformat="ymd" caption="Send Date" cofield="e_snd_dt" maxlength="10">~&nbsp;<!--
							--><input type="text" style="width:85px;ime-mode:disabled" name="e_snd_dt" class="input" dataformat="ymd" caption="Send Date" cofield="s_snd_dt" ><!--
							--><button type="button" class="calendar" name="btn_snd_calendar"></button>
							</td>
							<th>A6A(B/L)</th>
							<td>
								<select style="width:130;" name="cstms_trsm_sts_cd">
									<option value="">All</option>
									<option value="SentByA6A">Original</option>
									<option value="AddedByAi">Update</option>
									<option value="UnManifested">Un-Manifested</option>
									<option value="Manifested">Manifested</option>
								</select></td>						
							</tr>
					</tbody>
				</table>
				<table class="mar_top_4">
					<colgroup>
						<col width="50" />
						<col width="290" />
						<col width="100" />
						<col width="200" />
						<col width="80" />
						<col width="*" />
					</colgroup>
					<tbody>
						<tr>
							<th>B/L No.</th>
							<td><!--
							--><input type="text" style="width:125px;ime-mode:disabled" class="input" name="bl_no" dataformat="engup" maxlength="12" />
							</td>
							<th>Receive Date</th>
							<td><!--
							--><input type="text" style="width:85px;ime-mode:disabled" name="s_rcv_dt" class="input" dataformat="ymd" caption="Receive Date" cofield="e_rcv_dt" maxlength="10" /><!--
							-->~&nbsp;<!--
							--><input type="text" style="width:85px;ime-mode:disabled" name="e_rcv_dt" class="input" dataformat="ymd" caption="Receive Date" cofield="s_rcv_dt" /><!--
							--><button type="button" class="calendar" name="btn_rcv_calendar"></button>
							</td> 
							<th>Status</th>
							<td><!--
							--><script type="text/javascript">ComComboObject('cstms_ack_proc_rslt_cd', 2, 112, 1, 0, 0);</script><!--
							--><button type="button" class="multiple_inq" name="btn_M1" id="btn_M1"></button>
							</td> 
						</tr>
					</tbody>
				</table>
			</div>
			<!-- opus_design_inquiry(E) -->
	    </div>
	</div>
	<!-- layout_wrap(E) -->
</div>

<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" id="mainTable">
		<div class="opus_design_btn"><!--
		--><button type="button" class="btn_normal" name="btn_blInquiry"   id="btn_blInquiry">Manifest(B/L)</button><!--
		--><button type="button" class="btn_normal" name="btn_history"   	id="btn_history">Receive History</button><!--
		--><!-- <button type="button" class="btn_normal" name="btn_viewMsg"   	id="btn_viewMsg">View MSG</button> -->
		</div>
	    <script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<!-- opus_design_grid(E) -->
	
	<!-- opus_design_inquiry(S) -->
	<div class=" pad_8">
	<div class="opus_design_inquiry wFit">
		<table> 
			<colgroup>
				<col width="80" />
				<col width="80" />
				<col width="10" />
				<col width="70" />
				<col width="90" />
				<col width="10" />
				<col width="80" />
				<col width="*" />
			</colgroup>
			<tr>
				<th>Manifest TTL</th>
				<td><input type="text" style="width:50px; text-align:center;" class="input" name="frm_manifest_ttl" readonly="ReadOnly"></td> 
				<td>=</td>
				<th>Original</th>
				<td><input type="text" style="width:50px; text-align:center;" class="input" name="frm_sent_by_a6a" readonly="ReadOnly"></td> 
				<td>+</td>
				<th>Update</th>
				<td><input type="text" style="width:50px; text-align:center;" class="input" name="frm_sent_by_al" readonly="ReadOnly"></td>
			</tr>
			<tr>
				<th>Target TTL</th>
				<td><input type="text" style="width:50px; text-align:center;" class="input2" name="frm_target_ttl" readonly="ReadOnly"></td> 
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<th>Unmanifested</th>
				<td><input type="text" style="width:50px; text-align:center;" class="input" name="frm_unmanifest" readonly="ReadOnly"></td>
			</tr>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
	<table class="line_bluedot"><tr><td></td></tr></table>
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry">
		<table> 
			<colgroup>
				<col width="80" />
				<col width="80" />
				<col width="80" />
				<col width="70" />
				<col width="115" />
				<col width="*" />
			</colgroup>
			<tr>
				<th>Total</th>
				<td><input type="text" style="width:50px; text-align:right;" class="input2" name="frm_total" readonly="ReadOnly"></td> 
				<th>Processed</th>
				<td><input type="text" style="width:50px; text-align:right;" class="input2" name="frm_processed" readonly="ReadOnly"></td> 
				<th>Error</th>
				<td><input type="text" style="width:50px; text-align:right;" class="input2" name="frm_error" readonly="ReadOnly"></td>
			</tr>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
	</div>
</div>
</form>