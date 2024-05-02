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
<%@ page import="com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.editransmithistory.event.VopScg5011Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopScg5011Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg   = "";					//error message
	int rowCount	   = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList    = "";
	String pageRows    = "100";

	String strUsr_id   = "";
	String strUsr_nm   = "";
	Logger log = Logger.getLogger("com.clt.apps.specialcargoutilitymanagement.editransmithistory");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (VopScg5011Event)request.getAttribute("Event");
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
<input type="hidden" name="edi_unmap_flg" value="Y" id="edi_unmap_flg" />

<!-- Mail Parameter -->

<!-- Mail Parameter -->

<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
		<div class="opus_design_btn">
				<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!-- 
				 --><button type="button" class="btn_normal" name="btn_new"  id="btn_new">New</button>		
		</div>
	<!-- page_location(S) -->
	<div class="location">
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->

<!-- opus_design_inquiry(S) -->
<div class= "wrap_search_tab">
	<div class= "opus_design_inquiry wFit">
		<table>
		<colgroup>
			<col width="20px" />	
			<col width="50px" />	
			<col width="70px" />				
			<col width="122px"/>
			<col width="70px" />				
			<col width="130px"/>
			<col width="47px" />
			<col width="106px"/>
			<col width="84px" />
			<col width="102px"/>
			<col width="70px" />
			<col width="100px"/>
			<col width="70px" />
			<col width="*"    />
		</colgroup> 
		<tbody>
		<tr>
			<td valign="middle"><input type="radio" value="O" name="trsm_bnd_cd" id="rdo_send" class="trans" checked></td>
			<td align="left"><b>Send</b></td>
			<th align="left">RSO</th>
			<td><script type="text/javascript">ComComboObject('rgn_shp_opr_cd', 3, 85, 1, 0);</script></td>			
			<th align="left">Lane</th>
			<td>
				<input type="text" name="slan_cd" caption="Lane Code" maxlength="3" dataformat="engup" style="width:55px;ime-mode:disabled;" class="input" value="" id="slan_cd" /><!--
				--><button type="button" name="btn_SlanCd" id="btn_SlanCd" class="input_seach_btn" ></button>
			</td>
			<th title="Port of Loading">POL</th>
			<td>
				<input type="text" name="pol_cd" style="width:55px;" class="input" value="" caption="POL" maxlength="5" dataformat="engup" id="pol_cd" /><!--
				--><button type="button" id="btn_Pol" name="btn_Pol" class="input_seach_btn"></button></td>
			<th title="Port of Discharging">POD</th>
			<td>
				<input type="text" name="pod_cd" style="width:55px;" class="input" value="" caption="POD" maxlength="5" dataformat="engup" id="pod_cd" /><!--
				--><button type="button" id="btn_Pod" name="btn_Pod" class="input_seach_btn"></button></td>
			<th>BKG Company</th>
			<td>
				<input type="text" name="cgo_opr_cd" style="width:55px;" class="input" value="" caption="BKG Company" maxlength="4" dataformat="engup" id="cgo_opr_cd" /><!--
				--><button type="button" id="btn_Carrier" name="btn_Carrier" class="input_seach_btn"></button></td>
			<th>BKG Ref No.</th>
			<td>
				<input type="text" name="bkg_ref_no" style="width:120px;" class="input" value="" caption="BKG Ref No." maxlength="30" otherchar="excepthan" id="bkg_ref_no" /></td>
			</tr>
		</tbody>
		</table>
				<table>
				<colgroup>
					<col width="20px" />		
					<col width="50px" />
					<col width="70px"  />
					<col width="250px" />
					<col width="80px"  />
					<col width="100px" />
					<col width="90px"  />
					<col width="90px"  />
					<col width="98px"  />
					<col width="234px"  />			
					<col width="20px"  />		
					<col width="*"     />		
			   </colgroup> 
			   <tbody>
		   		<tr>
					<td valign="middle"><input type="radio" value="I" name="trsm_bnd_cd" id="rdo_received" class="trans"></td><td align="left"><b>Receive</b></td>
					<th>VVD CD</th>
						<td><input type="text" name="vsl_cd" style="width:55px;" class="input" value="" fullfill="" caption="VVD CD" maxlength="4" dataformat="engup" id="vsl_cd" /><!-- 
						 --><input type="text" name="skd_voy_no" style="width:40px;" class="input" value="" fullfill="" caption="VVD CD" maxlength="4" dataformat="engup" id="skd_voy_no" /><!-- 
						 --><input type="text" name="skd_dir_cd" style="width:20px;" class="input" value="" fullfill="" caption="VVD CD" maxlength="1" dataformat="engup" id="skd_dir_cd" /><!-- 
						 --><button type="button" id="btn_VVDpop" name="btn_VVDpop" class="input_seach_btn"></button><!-- 
						 --><input type="text" name="vsl_eng_nm" style="width:120px;" class="input2" value="" readonly id="vsl_eng_nm" /> </td>
					<th>EDI Msg Type</th>
					<td><script type="text/javascript">ComComboObject('edi_msg_sts_cd', 1, 85, 0, 0);</script></td>
					<th>EDI Status</th>
					<td><script type="text/javascript">ComComboObject('err_knd_cd', 1, 85, 0, 0);</script></td>
					<th>Message Date</th>
					<td><input type="text" name="trsm_from_dt" style="width:85px;" class="input1" value="" dataformat="ymd" maxlength="8" caption="Message Date" id="trsm_from_dt" />~&nbsp;<!-- 
						 --><input type="text" name="trsm_to_dt" style="width:85px;" class="input1" value="" dataformat="ymd" maxlength="8" caption="Message Date" id="trsm_to_dt" /><!-- 
						 --><button type="button" id="btn_Calendar" name="btn_Calendar" class="calendar ir"></button></td>
					<td><input type="checkbox" name="expand" id="expand" value="T" class="trans"></td>
					<td align="left"><b>Expand</b></td>						 
				</tr>
		   </tbody>
		   </table>
		<table class="height_8"><tr><td></td></tr></table>		
	</div>
</div>
<!-- opus_design_inquiry(E) -->

<div class= "wrap_result">
	<div class="opus_design_grid">
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_details" 		id="btn_details">DG EDI Booking History</button>			
		</div>
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>
</form>