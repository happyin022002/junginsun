<%
/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName : VOP_SCG_0014.jsp
 *@FileTitle: SPCL CGO APVL for Own BKG
 *@author   : CLT
 *@version  : 1.0
 *@since    : 2014/06/23
 =========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.apps.opus.bcm.sup.valuemanage.util.ConstantMgr"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.event.VopScg0014Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopScg0014Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						////count of DB resultSET list

	String successFlag 	= "";
	String codeList  	= "";
	String pageRows 	= "100";

	String strUsr_id	= "";
	String strUsr_nm	= "";
	Logger log = Logger.getLogger("com.clt.apps.CargoLoadingApproval.OwnDangerousCargoApproval");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (VopScg0014Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// add logic data extracting from server when loading initial screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
<%=ConstantMgr.getCompanyCodeToJS()%>
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form" id="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />

<input type="hidden" name="tabSelectedIdx" value="0" id="tabSelectedIdx" />
<input type="hidden" name="retrieve_flg" value="N" id="retrieve_flg" />
<input type="hidden" name="t0retrieve_flg" value="N" id="t0retrieve_flg" />
<input type="hidden" name="t1retrieve_flg" value="N" id="t1retrieve_flg" />
<input type="hidden" name="t2retrieve_flg" value="N" id="t2retrieve_flg" />
<input type="hidden" name="t3retrieve_flg" value="N" id="t3retrieve_flg" />
<input type="hidden" name="t4retrieve_flg" value="N" id="t4retrieve_flg" />
<input type="hidden" name="t5retrieve_flg" value="N" id="t5retrieve_flg" />
<input type="hidden" name="t6retrieve_flg" value="N" id="t6retrieve_flg" />
<input type="hidden" name="to_eta_dt" value="<%=DateTime.getFormatDate(new java.util.Date()," yyyymmdd") %>" id="to_eta_dt" />
<input type="hidden" name="user_id" value="<%=strUsr_id%>" id="user_id" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_Retrieve" id="btn_Retrieve" type="button">Retrieve</button><!--
		--><button class="btn_normal" name="btn_New" id="btn_New" type="button">New</button><!--
		--><button class="btn_normal" name="btn_Save" id="btn_Save" type="button">Save</button><!--
		--></div>
	<!-- opus_design_btn (E) -->
	<!-- page_location(S) -->
	<div class="location">
		<span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->

<div class="wrap_search_tab">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="77" />
				<col width="96" />
				<col width="70" />
				<col width="840" />
				<col width="96" />
				<col width="*" />
		   </colgroup>
		   <tbody>
		   		<tr>
					<th>RSO</th>
					<td style="padding-left:4"><script type="text/javascript">ComComboObject('rgn_shp_opr_cd', 3, 81, 1, 1);</script></td>
					<th>Lane</th>
					<td><!--
						 --><input type="text" name="slan_cd1" caption="Lane Code 1" maxlength="3" dataformat="engup" style="width:50px;ime-mode:disabled;" class="input" value="" id="slan_cd1" /><button type="button" name="btn_SlanCd1" id="btn_SlanCd1" class="input_seach_btn" ></button><!--
						 --><input type="text" name="slan_cd2" caption="Lane Code 2" maxlength="3" dataformat="engup" style="width:40px;ime-mode:disabled;" class="input" value="" id="slan_cd2" /><button type="button" name="btn_SlanCd2" id="btn_SlanCd2" class="input_seach_btn" ></button><!--
						 --><input type="text" name="slan_cd3" caption="Lane Code 3" maxlength="3" dataformat="engup" style="width:45px;ime-mode:disabled;" class="input" value="" id="slan_cd3" /><button type="button" name="btn_SlanCd3" id="btn_SlanCd3" class="input_seach_btn" ></button><!--
						 --><input type="text" name="slan_cd4" caption="Lane Code 4" maxlength="3" dataformat="engup" style="width:45px;ime-mode:disabled;" class="input" value="" id="slan_cd4" /><button type="button" name="btn_SlanCd4" id="btn_SlanCd4" class="input_seach_btn" ></button><!--
						 --><input type="text" name="slan_cd5" caption="Lane Code 5" maxlength="3" dataformat="engup" style="width:45px;ime-mode:disabled;" class="input" value="" id="slan_cd5" /><button type="button" name="btn_SlanCd5" id="btn_SlanCd5" class="input_seach_btn" ></button><!--
						 --><input type="text" name="slan_cd6" caption="Lane Code 6" maxlength="3" dataformat="engup" style="width:45px;ime-mode:disabled;" class="input" value="" id="slan_cd6" /><button type="button" name="btn_SlanCd6" id=btn_SlanCd6 class="input_seach_btn" ></button><!--
						 --><input type="text" name="slan_cd7" caption="Lane Code 7" maxlength="3" dataformat="engup" style="width:45px;ime-mode:disabled;" class="input" value="" id="slan_cd7" /><button type="button" name="btn_SlanCd7" id="btn_SlanCd7" class="input_seach_btn" ></button><!--
						 --><input type="text" name="slan_cd8" caption="Lane Code 8" maxlength="3" dataformat="engup" style="width:50px;ime-mode:disabled;" class="input" value="" id="slan_cd8" /><button type="button" name="btn_SlanCd8" id="btn_SlanCd8" class="input_seach_btn" ></button><!--
						 --><input type="text" name="slan_cd9" caption="Lane Code 9" maxlength="3" dataformat="engup" style="width:45px;ime-mode:disabled;" class="input" value="" id="slan_cd9" /><button type="button" name="btn_SlanCd9" id="btn_SlanCd9" class="input_seach_btn" ></button><!--
						 --><input type="text" name="slan_cd10" caption="Lane Code 10" maxlength="3" dataformat="engup" style="width:45px;ime-mode:disabled;" class="input" value="" id="slan_cd10" /><button type="button" name="btn_SlanCd10" id="btn_SlanCd10" class="input_seach_btn" ></button><!--
						 --><input type="text" name="slan_cd11" caption="Lane Code 11" maxlength="3" dataformat="engup" style="width:40px;ime-mode:disabled;" class="input" value="" id="slan_cd11" /><button type="button" name="btn_SlanCd11" id="btn_SlanCd11" class="input_seach_btn" ></button>
					</td>
				 
				 <th>BKG No.</th>
				 <td><input type="text" name="booking_no" style="width:120px;" class="input" value="" caption="BKG No." maxlength="30" id="booking_no" /> </td>
				  
				 
				</tr>
		   </tbody>
		</table>
		<table>
			<colgroup>
				<col width="30" />
				<col width="87" />
				<col width="70" />
				<col width="180" />
				<col width="10"/>
				<col width="100" />
				<col width="220" />
				<col width="10"/>
				<col width="80" />
				<col width="10"/>
				<col width="90" />
				<col width="*" />
		   </colgroup>
		   <tbody>
		   		<tr>
					<th>Vessel</th>
					<td><input type="text" name="vsl_cd" style="width:52px;ime-mode:disabled;" caption="Vessel Code" maxlength="4" dataformat="engup" class="input" value="" id="vsl_cd" /><!--
						 --><button type="button" name="btn_Vessel" id="btn_Vessel" class="input_seach_btn" ></button></td>
					<th class="wrap_search_tab">VSL OPR</th>
					<td class="wrap_search_tab"><!--
						 --><input type="radio" name="val_opr_tp_cd" value="" class="trans" checked="" id="val_opr_tp_cd" />&nbsp;&nbsp;All&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<!--
						 --><input type="radio" name="val_opr_tp_cd" value="H" class="trans" id="val_opr_tp_cd" />&nbsp;&nbsp;Own&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<!--
					     --><input type="radio" name="val_opr_tp_cd" value="O" class="trans" id="val_opr_tp_cd" />&nbsp;&nbsp;Others
					</td>
					<td></td>
					<th class="wrap_search_tab">Approval Status</th>
					<td class="wrap_search_tab" ><!--
						 --><input type="radio" name="auth_flg" value="A" class="trans" checked="" id="auth_flg" />&nbsp;&nbsp;All&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<!--
						 --><input type="radio" name="auth_flg" value="R" class="trans" id="auth_flg" />&nbsp;&nbsp;Request&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<!--
					     --><input type="radio" name="auth_flg" value="P" class="trans" id="auth_flg" />&nbsp;&nbsp;Pending
					</td>
					<td></td>
					<td><input type="checkbox" name="from_eta_flg" value="Y" class="trans" checked="" id="from_eta_flg" />&nbsp;&nbsp;<b>ETA next</b></td>
					<td><input type="text" name="from_eta_dt" style="width:25px;ime-mode:disabled;" class="input1" value="10" dataformat="num" maxlength="3" id="from_eta_dt" />&nbsp;&nbsp;<b>days for Post VVD</b></td>
					<td></td>
					<th>DG Ref No.</th>
					<td><input type="text" name="dcgo_ref_no" style="width:120px;" class="input" value="" caption="DG Ref No." maxlength="30" dataformat="eng" id="dcgo_ref_no" /> </td>
					
				</tr>
				</tr>
		   </tbody>
		</table>
		<table class="height_8"><tr><td></td></tr></table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">

	<!-- opus_design_tab(S) -->
	<div class="opus_design_tab sm">
		<script type="text/javascript">ComTabObject('tab1')</script>
	</div>
	<!-- opus_design_tab(E) -->
	<!--  Tab) DG - Part (S) -->
	<div id="tabLayer" style="display:none"  style="position:relative;">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">
			<div class="clear">
				  <h2 class="title_design pad_left_none floatL">
				    <input type="checkbox" name="t2OwnBox" id="t2OwnBox">
				    <label for="t2OwnBox"><b>Box for <%=ConstantMgr.getCompanyCode()%> VSL</b></label>
				  </h2>

				  <th >
				    <input type="checkbox" name="dg_cancel" id="dg_cancel" value= "Y">
				    <label for="dg_cancel"><b>DG Cancel</b></label>
				  </th>

				  <th ><b>Request Date</b></th>
						<td><input type="text" name="rqst_from_dt" style="width:81px;" class="input1" value="" dataformat="ymd" maxlength="8" caption="Request Date" id="rqst_from_dt" />~&nbsp;<!--
						 --><input type="text" name="rqst_to_dt" style="width:85px;" class="input1" value="" dataformat="ymd" maxlength="8" caption="Request Date" id="rqst_to_dt" /><!--
						 --><button type="button" id="btn_Calendar" name="btn_Calendar" class="calendar ir"></button></td>
			
				    <span style="background-color: yellow;text-align: center;padding: 5px 5px;"> Updated Item</span>
				    <span style="background-color: lightgreen;text-align: center;padding: 5px 5px;">New Item</span>
				

				<!-- opus_design_btn (S) -->
				<div class="opus_design_btn">
					<button class="btn_normal" name="btn_t2SendDgEdiRequest" id="btn_t2SendDgEdiRequest" type="button">Send DG EDI</button>
					<button class="btn_normal" name="btn_t2SendDgEmlRequest" id="btn_t2SendDgEmlRequest" type="button">Send DG Email</button>
					<button class="btn_normal" name="btn_t2ApplDetails"      id="btn_t2ApplDetails"      type="button">Application Details</button></div>
				<!-- opus_design_btn (E) -->
				</div>
			<script type="text/javascript">ComSheetObject('t2sheet1');</script>
			<!-- 2014 12.08 TITLE HIDDEN
			<table class="height_8"><tr><td></td></tr></table>

			<table>
				<tr>
					<td><b>* DG - Part I  :  CL 1, 2, 5.2, 7 & PSA 1</b></td>
				</tr>
				<tr>
					<td><b>* DG - Part II : Except CL 1, 2, 5.2, 7 & PSA 1</b></td>
				</tr>
			</table>
			 -->
		</div>
		<!-- opus_design_grid(E) -->
	</div>
	<!--  Tab) DG - Part II (E) -->

	<!--  Tab) Awkwark (S) -->
	<div id="tabLayer" style="display:none" style="position:relative;">
			<!-- opus_design_grid(S) -->
			<div class="opus_design_grid">
				<div class="clear">
				  <h2 class="title_design pad_left_none floatL">
				    <input type="checkbox" name="t3OwnBox" id="t3OwnBox">
				    <label for="t3OwnBox"><b>Box for <%=ConstantMgr.getCompanyCode()%> VSL</b></label>
				  </h2>
				<!-- opus_design_btn (S) -->
				<div class="opus_design_btn">
					<button class="btn_normal" name="btn_t3ApplDetails" id="btn_t3ApplDetails" type="button">Application Details</button><!--
				--></div>
				</div>
				<!-- opus_design_btn (E) -->
				<script type="text/javascript">ComSheetObject('t3sheet1');</script>
				<table class="height_8"><tr><td></td></tr></table>
			<!-- 
			<table>
				<tr>
					<td><b>* DG - Part I  :  CL 1, 2, 5.2, 7 & PSA 1</b></td>
				</tr>
				<tr>
					<td><b>* DG - Part II : Except CL 1, 2, 5.2, 7 & PSA 1</b></td>
				</tr>
			</table>
			-->
			</div>
			<!-- opus_design_grid(E) -->
	</div>
	<!--  Tab) Awkwark (E) -->

	<!--  Tab) Break-Bulk (S) -->
	<div id="tabLayer" style="display:none" style="position:relative;">

			<!-- opus_design_grid(S) -->
			<div class="opus_design_grid">
			<div class="clear">
				  <h2 class="title_design pad_left_none floatL">
				    <input type="checkbox" name="t4OwnBox" id="t4OwnBox">
				    <label for="t4OwnBox"><b>Box for <%=ConstantMgr.getCompanyCode()%> VSL</b></label>
				  </h2>
				<!-- opus_design_btn (S) -->
				<div class="opus_design_btn">
					<button class="btn_normal" name="btn_t4ApplDetails" id="btn_t4ApplDetails" type="button">Application Details</button><!--
				--></div>
				<!-- opus_design_btn (E) -->
				</div>
				<script type="text/javascript">ComSheetObject('t4sheet1');</script>
				<table class="height_8"><tr><td></td></tr></table>
			<!-- 
			<table>
				<tr>
					<td><b>* DG - Part I  :  CL 1, 2, 5.2, 7 & PSA 1</b></td>
				</tr>
				<tr>
					<td><b>* DG - Part II : Except CL 1, 2, 5.2, 7 & PSA 1</b></td>
				</tr>
			</table>
			-->
			</div>
			<!-- opus_design_grid(E) -->
	</div>
	<!--  Tab) Break-Bulk (E) -->

	<!--  Tab) 45 (S) -->
	<div id="tabLayer" style="display:none" style="position:relative;">
			<!-- opus_design_grid(S) -->
			<div class="opus_design_grid">
			<div class="clear">
				  <h2 class="title_design pad_left_none floatL">
				    <input type="checkbox" name="t5OwnBox" id="t5OwnBox">
				    <label for="t5OwnBox"><b>Box for <%=ConstantMgr.getCompanyCode()%> VSL</b></label>
				  </h2>
				<!-- opus_design_btn (S) -->
				<div class="opus_design_btn">
					<button class="btn_normal" name="btn_t5ApplDetails" id="btn_t5ApplDetails" type="button">Application Details</button><!--
				--></div>
				</div>
				<!-- opus_design_btn (E) -->
				<script type="text/javascript">ComSheetObject('t5sheet1');</script>
				<table class="height_8"><tr><td></td></tr></table>
			<!-- 
			<table>
				<tr>
					<td><b>* DG - Part I  :  CL 1, 2, 5.2, 7 & PSA 1</b></td>
				</tr>
				<tr>
					<td><b>* DG - Part II : Except CL 1, 2, 5.2, 7 & PSA 1</b></td>
				</tr>
			</table>
			-->
			</div>
			<!-- opus_design_grid(E) -->
	</div>
	<!--  Tab) 45 (E) -->


	<div id="tabLayer" style="display:none" style="position:relative;">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">
			<div class="clear">
				  <h2 class="title_design pad_left_none floatL">
				    <input type="checkbox" name="t6OwnBox" id="t6OwnBox">
				    <label for="t6OwnBox"><b>Box for <%=ConstantMgr.getCompanyCode()%> VSL</b></label>
				  </h2>
			<!-- opus_design_btn (S) -->
			<div class="opus_design_btn">
				<button class="btn_normal" name="btn_t6ApplDetails" id="btn_t6ApplDetails" type="button">Application Details</button><!--
			--></div>
			</div>
			<!-- opus_design_btn (E) -->
			<script type="text/javascript">ComSheetObject('t6sheet1');</script>
			<table class="height_8"><tr><td></td></tr></table>
			<!-- 
			<table>
				<tr>
					<td><b>* DG - Part I  :  CL 1, 2, 5.2, 7 & PSA 1</b></td>
				</tr>
				<tr>
					<td><b>* DG - Part II : Except CL 1, 2, 5.2, 7 & PSA 1</b></td>
				</tr>
			</table>
			-->
		</div>
		<!-- opus_design_grid(E) -->
	</div>
	<!--  Tab) Reefer (E) -->

	<div id="tabLayer" style="display:none" style="position:relative;">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">
			<div class="clear">
				  <h2 class="title_design pad_left_none floatL">
				    <input type="checkbox" name="t7OwnBox" id="t7OwnBox">
				    <label for="t7OwnBox"><b>Box for <%=ConstantMgr.getCompanyCode()%> VSL</b></label>
				  </h2>
			<%--<!-- opus_design_btn (S) -->
			<div class="opus_design_btn">
				<button class="btn_normal" name="btn_t7ApplDetails" id="btn_t7ApplDetails" type="button">Application Details</button><!--
			--></div>
			</div>--%>
			<!-- opus_design_btn (S) -->
			<div class="opus_design_btn">
				<button class="btn_normal" name="btn_t7SendDgEmlRequest" id="btn_t7SendDgEmlRequest" type="button">Send SS Email Request</button>
			<!-- opus_design_btn (E) -->
			</div>
			<!-- opus_design_btn (E) -->
			<script type="text/javascript">ComSheetObject('t7sheet1');</script>
			<table class="height_8"><tr><td></td></tr></table>
			<!--
			<table>
				<tr>
					<td><b>* DG - Part I  :  CL 1, 2, 5.2, 7 & PSA 1</b></td>
				</tr>
				<tr>
					<td><b>* DG - Part II : Except CL 1, 2, 5.2, 7 & PSA 1</b></td>
				</tr>
			</table>
			-->
		</div>
		<!-- opus_design_grid(E) -->
	</div>
	<!--  Tab) Special Stow (E) -->

</div>
</form>
