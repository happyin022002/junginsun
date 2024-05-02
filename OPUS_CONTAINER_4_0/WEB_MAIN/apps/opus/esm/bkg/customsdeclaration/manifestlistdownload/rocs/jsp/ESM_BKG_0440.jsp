<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ui_bkg_0440.jsp
*@FileTitle : ROCS Main Menu
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.event.EsmBkg0440Event"%><%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0440Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from the server
	String strErrMsg = "";						//error messege
	int rowCount	 = 0;						//the number of DB ResultSet List

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

		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}						 

	}catch(Exception e) {
		out.println(e.toString());
	}
	
%>
<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form" method="post">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="frm_attr_ctnt2">
<input type="hidden" name="vsl_cd"> 
<input type="hidden" name="skd_voy_no"> 
<input type="hidden" name="skd_dir_cd">
<input type="hidden" name="vvd_nm">

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	    
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_new" id="btn_new">New</button>
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
	<div class="opus_design_inquiry wFit">
	    <table>
	        <colgroup>
	            <col width="100" />
	            <col width="250" />
	            <col width="" />
	        </colgroup>
	        <tbody>
				<tr>
					<th>CRN Number</th>
					<td><input name="frm_crn_number"  style="ime-mode: disabled; width:200px" id="frm_crn_number" maxlength="13"  dataformat="engup" type="text" value="" class="input" ></td>
					<td></td>
				</tr>
				<tr>
					<th title="Vessel Voyage Direction">VVD</th>
					<td><input name="frm_vvd_number"   style="ime-mode: disabled; width:200px" id="frm_vvd_number" maxlength="9" dataformat="engup" type="text" value="" class="input"></td>
					<td></td>
				</tr>
				<tr>
					<th title="Port of Discharging">POD</th>
					<td><input name="pod_cd" type="text"  style="ime-mode: disabled; width:200px" dataformat="engup" value=" NLRTM" readonly class="input2"></td>
					<td></td>
				</tr>
				<tr>
					<th>Call Date (ETA)</th>
					<td><input name="frm_vvd_eta_dt" type="text" style="ime-mode: disabled; width:200px" value="" class="input2" readonly></td>
					<td></td>
				</tr>
			</tbody>
		</table>
		<table>
	    	<tr><td height="20px"></td></tr>
	    </table>
		<table style="width:330px;"> 
			<tr>
				<td>Stage 1 : Manifest Transmission</td>
			</tr>
			<tr>
				<td width="300px" border="0" cellpadding="0" cellspacing="0" class="button">
				    <button type="button" class="btn_etc" style="width:250px;text-align:left"  name="btn_1"   id="btn_1" >1. CRN Creation</button>
				</td>
			</tr>
			<tr>
				<td width="300px" border="0" cellpadding="0" cellspacing="0" class="button">
				<button type="button" class="btn_etc" name="btn_2" style="width:250px;text-align:left"  id="btn_2"  >2. CRN List</button>
				</td>
			</tr>
			<tr>
				<td width="300px" border="0" cellpadding="0" cellspacing="0" class="button">
				<button type="button" class="btn_etc" name="btn_3" style="width:250px;text-align:left"  id="btn_3"  >3. Manifest Transmit</button>
				</td>
			</tr>
			<tr>
				<td width="300px" border="0" cellpadding="0" cellspacing="0" class="button">
				<button type="button" class="btn_etc" name="btn_4" style="width:250px;text-align:left"   id="btn_4"  >4. Manifest Details by B/L</button>
		    	</td>
		    </tr>
		</table>
		
		<table border="0">
	    	<tr><td height="20px"></td></tr>
	    </table>							
		
		<table style="width:330px;"> 
			<tr>
				<td>Stage 2 : ROCS Closing</td>
			</tr>
			<tr>
				<td width="300px" border="0" cellpadding="0" cellspacing="0" class="button">
					<button type="button" class="btn_etc" name="btn_5_1" style="width:250px;text-align:left"  id="btn_5_1">5. Transmit History</button>
				</td>
			</tr>
			<tr>
				<td width="300px" border="0" cellpadding="0" cellspacing="0" class="button">
					<button type="button" class="btn_etc" name="btn_6_1"  style="width:250px;text-align:left" id="btn_6_1">6. Received History</button>
				</td>
			</tr>
		</table>
		
		<table border="0">
	    	<tr><td height="20px"></td></tr>
	    </table>							
		
		<table style="width:330px;"> 
			<tr>
				<td>Stage 3 : Report<td>
			</tr>
			<tr>
				<td width="300px" border="0" cellpadding="0" cellspacing="0" class="button">
					<button type="button" class="btn_etc" name="btn_7" style="width:250px;text-align:left"  id="btn_7">7. Notify Letter Send</button>
				</td>
			</tr>
			<tr>
				<td width="300px" border="0" cellpadding="0" cellspacing="0" class="button">
					<button type="button" class="btn_etc" name="btn_8" style="width:250px;text-align:left"  id="btn_8">8. Integrated Customer Data Management</button>
				</td>
			</tr>
			<tr>
				<td width="300px" border="0" cellpadding="0" cellspacing="0" class="button">
					<button type="button" class="btn_etc" name="btn_9" style="width:250px;text-align:left"  id="btn_9">9. I/B B/L File</button>
				</td>
			</tr>
			<tr>
				<td width="300px" border="0" cellpadding="0" cellspacing="0" class="button">
					<button type="button" class="btn_etc" name="btn_10" style="width:250px;text-align:left"  id="btn_10">10. Maintain Address</button>
				</td>
			</tr>
			<tr>
				<td width="300px" border="0" cellpadding="0" cellspacing="0" class="button">
					<button type="button" class="btn_etc" name="btn_11" style="width:250px;text-align:left"  id="btn_11">11. Notice Sent History</button>
				</td>
			</tr>
		</table>		
	</div>
	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" style="display:none">
	   <script type="text/javascript">ComSheetObject('sheet1');</script>
	   </div>
	<!-- opus_design_grid(E) -->
</div>	
	
<!-- Copyright(E)-->
</form>