<%
/*=========================================================
**Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_FMS_0022.js
*@FileTitle  : Vessel Code
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/19
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.fms.fmscommon.externalfinder.event.EsmFms0022Event"%>
<%@ page import="org.apache.log4j.Logger" %>


<%
	EsmFms0022Event event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException = null;			//Error from Server
	String strErrMsg = "";						//Error Message

	String strUsr_id = "";
	String strUsr_nm = "";
	Logger log = Logger.getLogger("com.clt.apps.Fmscommon.Externalfinder");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (EsmFms0022Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		
	}catch(Exception ex) {
		log.error("err " + ex.toString(), ex);
		//out.println(e.toString());
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
<input type="hidden" name="ibflag" id="ibflag" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="eff_dt" id="eff_dt" />
<input type="hidden" name="exp_dt" id="exp_dt" />
<input type="hidden" name="vndr_seq" id="vndr_seq" />

<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title"><span>Vessel Code</span></h2>
		<!-- page_title(E) -->
		
		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn">
			<button class="btn_accent" name="btn_Retrieve" id="btn_Retrieve" type="button">Retrieve</button><!--
			--><button class="btn_normal" name="btn_confirm" id="btn_confirm" type="button">Confirm</button><!--
			--><button class="btn_normal" name="btn_close" id="btn_close" type="button">Close</button>
		</div>
		<!-- opus_design_btn (E) -->
	</div>
	<!-- page_title_area(E) -->
</div>

<div class="layer_popup_contents">
	<div class="wrap_search">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit">
			<table class="search">
				<tbody>
					<colgroup>
						<col width="80">
						<col width="150">
						<col width="75">
						<col width="*">
					</colgroup>
					<tr>
	                    <th>Vessel Code</th>
	                    <td><input type="text" style="width:70px;text-align:center;" class="input"  name="vsl_cd" id="vsl_cd" maxlength="4" style="ime-mode:disabled" dataformat="engup" ></td>
	                    <th>Vessel Name</th>
	                    <td><input type="text" style="width:150px;" class="input" name="vsl_eng_nm" id="vsl_eng_nm" maxlength="50"  style="ime-mode:disabled"></td> 
	                </tr>
	                <tr>
	                    <th>Carrier Code</th>
	                    <td><input type="text" style="width:70px;text-align:center;" class="input"  name="crr_cd" id="crr_cd" maxlength="4" dataformat="enguponly"><!--  
	                    	 --><button type="button" class="input_seach_btn" name="btn_crr_cd" id="btn_crr_cd"></button></td>
	                    <th>Trunk / Off</th>
	                    <td><select style="width:100px;" name="fdr_div_cd" id="fdr_div_cd">
		                        <option value=" " selected>All</option>
		                        <option value="T">Trunk</option>
		                        <option value="O">Off</option>
	                        </select>
	                    </td>
	                </tr>
				</tbody>
			</table>
		</div>
		<!-- opus_design_inquiry(E) -->
	</div>
	
	<div class="wrap_result">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_grid">
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
		<!-- opus_design_inquiry(E) -->
	</div>
</div>
</form>         
<%@include file="/bizcommon/include/common_opus.jsp"%>