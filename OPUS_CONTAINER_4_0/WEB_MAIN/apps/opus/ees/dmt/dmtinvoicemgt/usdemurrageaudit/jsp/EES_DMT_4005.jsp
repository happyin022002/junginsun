<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_DMT_4005.jsp
*@FileTitle  : 3rd Party DEM/DET Collection Audit
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/31
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.dmt.dmtinvoicemgt.usdemurrageaudit.event.EesDmt4005Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesDmt4005Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_ofc		= "";
	Logger log = Logger.getLogger("com.clt.apps.DMTInvoiceMgt.usdemurrageaudit");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_ofc = account.getOfc_cd();


		event = (EesDmt4005Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// Retrieving the parameter values ​​for calls to pop-up page ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="button_mode" id="button_mode" />
<input type="hidden" name="usr_ofc_cd" value="<%=strUsr_ofc%>" id="usr_ofc_cd" />
<input type="hidden" name="load_opt_input" value="1" id="load_opt_input" />
<input type="hidden" name="ofc_cd" id="ofc_cd" />
<input type="hidden" name="dmdt_trf_cd" id="dmdt_trf_cd" />
<input type="hidden" name="fm_mvmt_yd_cd" id="fm_mvmt_yd_cd" />
<input type="hidden" name="yd_cd1" id="yd_cd1" />
<input type="hidden" name="cntr_nos" id="cntr_nos" />
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title"><span id="title"></span></h2>
		<!-- page_title(E) -->
	    <!-- opus_design_btn(S) -->
	    <div class="opus_design_btn">
	        <!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
			<button type="button" class="btn_accent" name="btn_new" id="btn_new">New</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_loadexcel" id="btn_loadexcel">Load Excel</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_audit" id="btn_audit">Audit</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_ofc" id="btn_ofc">by OFC</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_bkg" id="btn_bkg">by BKG</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_cntr" id="btn_cntr">by CNTR</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_mvmt" id="btn_mvmt">MVMT INQ</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button>						
	    </div>
	    <!-- opus_design_btn(E) -->
		<!-- page_location(S) -->
		<div class="location">
			<span id="navigation"></span>
		</div>
		<!-- page_location(E) -->
	</div>
	<!-- page_title_area(E) -->
	
	<div class="wrap_search" >
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit">
	        <table> 
	            <colgroup>
	                <col width="40" />
	                <col width="110" />
	                <col width="70" />
	                <col width="110" />	                
	                <col width="80" />
	                <col width="110" />
	                <col width="70" />
	                <col width="150" />
	                <col width="88" />
	                <col width="100" />
	                <col width="" />
	            </colgroup>
	            <tbody>
	                <tr>
	                    <th>Office</th>
		                <td>
		                	<script type="text/javascript">ComComboObject('combo1', 2, 70 , 0, 1)</script>
		                </td>
		                <th>Tariff Type</th>
		                <td>
		                	<script type="text/javascript">ComComboObject('combo2', 2, 70 , 0, 1)</script>
		                </td>
		                <th>Load Option</th>
		                <td>
		                	<select style="width:70px;" class="input1" name="load_opt" id="load_opt" onchange="load_opt_change();"> 
								<option value="1" selected>VVD CD</option>
								<option value="2">B/L No</option>
								<option value="3">BKG No</option>
							</select>
		                </td>
		                <th>From Yard</th>
		                <td>
		                	<input type="text" style="width:60px;" class="input1" name="yd_cd" id="yd_cd" style="ime-mode:disabled;" dataformat="engup" maxlength="5" OnKeyUp="obj_keyup()"><!--
							--><script type="text/javascript">ComComboObject('combo3', 2, 60 , 0, 0);</script>
		                </td>
		                <th>Result Option</th>
		                <td>
		                	<select style="width:100px;" class="input" name="result_opt" id="result_opt" onchange="result_opt_change();"> 
								<option value="All" selected>All</option>
								<option value="Coincidence">Coincidence</option>
								<option value="Discrepancy">Discrepancy</option>
							</select>
		                </td>
		                <td></td>
					</tr>
				</tbody>
			</table>
		</div>
		<!-- opus_design_inquiry(E) -->
	</div>
	
	<div class="wrap_result">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid" id="mainTable" >										
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
		
			<div class="opus_design_inquiry wFit">
				<table> 
					<colgroup>
		                <col width="30">
		                <col width="20">
		                <col width="100">
		                <col width="160">
		                <col width="70">	                
		                <col width="10">
		                <col width="100">
		                <col width="160">
		                <col width="70">
		                <col width="10">
		                <col width="100">
		                <col width="*">
		            </colgroup>
		            <tbody>
						<tr>
							<th>Total </th>
							<td></td>
							<td>CNTR&nbsp;<input type="text" name="tot_cntr" id="tot_cntr" style="width:50px;text-align:right;" class="input2" value=""></td>
							<td>AMT&nbsp;<input type="text" name="tot_amt" id="tot_amt" style="width:100px;text-align:right;" class="input2" value=""></td>
							<th>Coincidence</th>
							<td></td>
							<td>CNTR&nbsp;<input type="text" name="c_cntr" id="c_cntr" style="width:50px;text-align:right;" class="input2" value=""></td>
							<td>AMT&nbsp;<input type="text" name="c_amt" id="c_amt" style="width:100px;text-align:right;" class="input2" value=""></td>
							<th>Discrepancy</th>
							<td></td>
							<td>CNTR&nbsp;<input type="text" name="d_cntr" id="d_cntr" style="width:50px;text-align:right;" class="input2" value=""></td>
							<td>AMT&nbsp;<input type="text" name="d_amt" id="d_amt" style="width:100px;text-align:right;" class="input2" value=""></td>
						</tr>
				</table>
	   		 </div>
	   </div>
	<!-- opus_design_grid(E) -->
<!-- Developer's task end -->
<!--Button area  -->
<div class="" id="btnArea" style=" padding:10px 10px">
	   <div style=" float:right;"><button type="button" class="btn_normal" name="btn_EMail" id="btn_EMail">E-Mail</button>
	   <button type="button" class="btn_normal" name="btn_EDI" id="btn_EDI">EDI</button></div>
	   <div><button type="button" class="btn_normal" name="btn_CargoRelease" id="btn_CargoRelease">Cargo Release</button>
	   <button type="button" class="btn_normal" name="btn_Print" id="btn_Print">Print</button></div>
</div>
<!--// Button area  -->
</form>