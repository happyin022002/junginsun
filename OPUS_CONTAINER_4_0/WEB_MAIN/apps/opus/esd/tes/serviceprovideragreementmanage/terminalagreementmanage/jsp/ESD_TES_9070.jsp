<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESD_TES_9070.jsp
*@FileTitle  : Agreement Rate List Copy
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/07
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.event.EsdTes9070Event"%>
<%
	EsdTes9070Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Server Exception
	String strErrMsg = "";						//Error Message
	int rowCount	 = 0;						//DB ResultSet Count
	String ofc_cd = "";
	
	try {

	    SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	    ofc_cd = account.getOfc_cd();
	    
		event = (EsdTes9070Event)request.getAttribute("Event");

		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
	
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}else{
		} // end else
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<script language="javascript">

    function setupPage(){
        loadPage();
    }

</script>
<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="iPage" id="iPage" />
<input type="hidden" name="command_h" id="command_h" />
<input type="hidden" name="is_valid_yd_cd" id="is_valid_yd_cd" />
<input type="hidden" name="yd_cd_hidden" id="yd_cd_hidden" />
<input type="hidden" name="is_valid_vndr_seq" id="is_valid_vndr_seq" />
<input type="hidden" name="vndr_seq_hidden" id="vndr_seq_hidden" />
<input type="hidden" name="auth_ofc_cd" id="auth_ofc_cd" />
<input type="hidden" name="cre_ofc_cd" id="cre_ofc_cd" value="<%=ofc_cd%>">
<input type="hidden" name="no_ofc_cd" id="no_ofc_cd" value=""  />
<input type="hidden" name="no_yd_cd" id="no_yd_cd" value="" />
<input type="hidden" name="act_tp" id="act_tp" value="AGMT">

<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	   <!-- page_title(S) -->
		<h2 class="page_title"><span>Agreement Copy</span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_retrieve" 	id="btn_retrieve">Retrieve</button>
		<!-- opus_design_btn(E) -->
		</div>
	</div>
	<!-- page_title_area(E) -->
</div>
<!-- opus_design_inquiry(S) -->
<div class="layer_popup_contents">
	<div class= "wrap_search">
		<div class= "opus_design_inquiry wFit">
			<table>
					<colgroup>
						<col width="80"/>
						<col width="*"/>
				    </colgroup>
				    <tbody>
					<tr>
						<th>Yard</th>
						<td><input type="text" name="yd_cd" maxlength="7" style="width:110px;" value="" onkeyup="isApNum2(this);" onkeydown="chkInput(this);" !onblur="validateYardCode();" id="yd_cd" /><button type="button" id="btn_yard" name="btn_yard" class="input_seach_btn"></button></td>
					</tr>
					<tr>
						<th>S/P</th>
						<td><input type="text" name="vndr_seq" maxlength="6" style="width:110px;" value="" onkeyup="isNum(this);" onkeydown="chkInput(this);" !onblur="validateVendorCode();" id="vndr_seq" /><button type="button" id="btn_vndr" name="btn_vndr" class="input_seach_btn"></button></td>
					</tr>	
					<tr>
						<th>Location Code</th>
						<td><input type="text" name="loc_cd" maxlength="5" style="width:140px;" value="" onkeyup="isApNum2(this);" onkeydown="chkInput(this);" id="loc_cd" /> </td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	<!-- opus_design_inquiry(E) -->
	<!-- opus_design_grid(S) -->
	<div class="wrap_result">
		<div class="opus_design_grid clear" >
			<div class="opus_design_btn">
				<button type="button" class="btn_normal" name="btng_select" 	id="btng_select">Select</button>
			</div>
			<script type="text/javascript">ComSheetObject('sheet');</script>
		</div>
	</div>
	<!-- opus_design_grid(E) -->
</div>

</form>
