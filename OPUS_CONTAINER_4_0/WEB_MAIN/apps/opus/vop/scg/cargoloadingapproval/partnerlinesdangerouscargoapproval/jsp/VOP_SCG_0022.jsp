<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : vop_scg_0022.jsp
*@FileTitle  : SPCL CGO APVL for Partner Lines (Creation)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/04
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.event.VopScg0022Event"%>
<%@ page import="org.apache.log4j.Logger" %>
 
<%
	VopScg0022Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.CargoLoadingApproval.PartnerLinesDangerousCargoApproval");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (VopScg0022Event)request.getAttribute("Event");
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
<input type="hidden" name="user_id" value="<%=strUsr_id%>" id="user_id" />
<input type="hidden" name="pol_cd" id="pol_cd" />
<input type="hidden" name="pod_cd" id="pod_cd" />
<input type="hidden" name="tabSelectedIdx" value="0" id="tabSelectedIdx" />

<!-- Mail Parameter -->

<!-- Mail Parameter -->

<div class="layer_popup_title">

<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
		<div class="opus_design_btn">
				<button type="button" class="btn_accent" name="btn_retrieve" 		id="btn_retrieve">Retrieve</button><!-- 
				 --><button type="button" class="btn_normal" name="btn_new" 			id="btn_new">New</button><!--	
				--><button type="button" class="btn_normal" name="btn_save" 			id="btn_save">Save</button>			
		</div>
	<!-- page_location(S) -->
	<div class="location">
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->
</div>
<!-- opus_design_inquiry(S) -->
<div class= "wrap_search_tab">
	<div class= "opus_design_inquiry wFit">
		<table>
			<tbody>
				<colgroup>
				    <col width="150" />
					<col width="80" />
					<col width="150" />
					<col width="80" />
					<col width="380" />
					<col width="80" />
					<col width="*" />
				</colgroup>
				<tr>
				    <td valign="middle"><input type="radio" name="func_flg" class="trans" value="MNL" id="func_flg" checked/>&nbsp;<b>Manual</b></td>
					<th>RSO</th>
					<td>
						<script type="text/javascript">ComComboObject('rgn_shp_opr_cd', 2, 50, 1, 1);</script>
					</td>
					<th>VVD CD</th>
					<td><input name="vsl_cd" required type="text" style="width:55px;" class="input1" value="" caption="VVD CD" maxlength="4" dataformat="engup" id="vsl_cd" /><!--  
					--><input name="skd_voy_no" required type="text" style="width:40px;" class="input1" value="" caption="VVD CD" maxlength="4" dataformat="engup" id="skd_voy_no" /><!--    
					--><input name="skd_dir_cd" required="" type="text" style="width:20px;" class="input1" value="" caption="VVD CD" maxlength="1" dataformat="engup" id="skd_dir_cd" /><!--  
					  --><button type="button" id="btn_VVDpop" name="btn_VVDpop" class="input_seach_btn"></button><!--
					  --><input name="vsl_eng_nm" type="text" style="width:200px;" class="input2" value="" readonly="readonly" id="vsl_eng_nm" /><!--  
					 --><input type="hidden" name="crr_cd" id="crr_cd" /></td>
					<th>Lane</th>
					<td><input name="slan_cd" type="text" style="width:40px;" class="input2" value="" readonly id="slan_cd" /><!--  
					--><input name="slan_nm" type="text" style="width:233px;" class="input2" value="" readonly="" id="slan_nm" /></td>
				</tr>
				<tr>
				    <td valign="middle"><input type="radio" name="func_flg" class="trans" value="EDI" id="func_flg"/>&nbsp;<b>Unmapped EDI</b></td>
					<th>BKG Ref No.</th>
					<td><input type="text" name="booking_no" style="width:120px;" class="input1" value="" caption="BKG Ref No." maxlength="30"  id="booking_no" /> </td>
					<th>BKG Company</th>
					<td><input id="cgo_opr_cd" type="text" name="cgo_opr_cd" style="width:40px;" class="input" value="" caption="BKG Company" minlength="3" maxlength="4" dataformat="engup" /><button type="button" id="btn_Carrier" name="btn_Carrier" class="input_seach_btn"></button></td>
					<th>Request Date</th>
					<td><input type="text" name="from_req_dt" style="width:81px;" class="input" value="" dataformat="ymd" maxlength="8" id="from_req_dt" />~&nbsp;<!-- 
					--><input type="text" name="to_req_dt" style="width:85px;" class="input" value="" dataformat="ymd" maxlength="8" id="to_req_dt" /><!-- 
					--><button type="button" id="btn_Calendar" name="btn_Calendar" class="calendar ir" ></button></td>
				</tr> 
			</tbody>
		</table>
	</div>
</div>
<!-- opus_design_inquiry(E) -->

<div class= "wrap_result">
	<div class="opus_design_tab">
		<script type="text/javascript">ComTabObject('tab1')</script>
	</div>
	<div name="tabLayer" id="tabLayer"  style="display:inline;">
		<div class="opus_design_grid">
			<span id="comment" style="background-color: #FFD8D8;text-align: center;padding: 5px 5px;"> Unmapped EDI Item </span>
			<!-- opus_design_btn(S) -->
			<div class="opus_design_btn">
				<button type="button" class="btn_accent" name="btn_details" 		id="btn_details">Application Details</button><!-- 
				 --><button type="button" class="btn_normal" name="btn_t1add" 			id="btn_t1add">Row Add</button><!--	
				--><button type="button" class="btn_normal" name="btn_t1copy" 			id="btn_t1copy">Row Copy</button><!--	
				--><button type="button" class="btn_normal" name="btn_t1delete" 			id="btn_t1delete">Row Delete</button><!--	
				--><button type="button" class="btn_normal" name="btn_t1downExcel" 			id="btn_t1downExcel">Down Excel</button>			
			</div> 
			<!-- opus_design_btn(E) -->
			<script type="text/javascript">ComSheetObject('t1sheet1');</script>
		</div>
	</div>
	<div name="tabLayer" id="tabLayer"  style="display:none;">
		<div class="opus_design_grid">
		    <!-- opus_design_btn(S) -->
			<div class="opus_design_btn">
				<button type="button" class="btn_accent" name="btn_t2insert" 		id="btn_t2insert">Row Insert</button><!-- 
				 --><button type="button" class="btn_normal" name="btn_t2add" 			id="btn_t2add">Row Add</button><!--	
				--><button type="button" class="btn_normal" name="btn_t2copy" 			id="btn_t2copy">Row Copy</button><!--	
				--><button type="button" class="btn_normal" name="btn_t2delete" 			id="btn_t2delete">Row Delete</button><!--	
				--><button type="button" class="btn_normal" name="btn_mail" 			id="btn_mail">Mail</button><!--	
				--><button type="button" class="btn_normal" name="btn_t2downExcel" 			id="btn_t2downExcel">Down Excel</button>			
			</div>
			<!-- opus_design_btn(E) -->
			<script type="text/javascript">ComSheetObject('t2sheet1');</script>
		</div>
	</div>
</div>


<div class="wrap_result">
	<div class="opus_design_grid">
	<script type="text/javascript">ComSheetObject('t0sheet1');</script>
	</div>
</div>
</form>