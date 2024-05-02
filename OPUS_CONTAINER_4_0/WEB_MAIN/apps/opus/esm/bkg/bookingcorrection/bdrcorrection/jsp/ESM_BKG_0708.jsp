<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0708.jsp
*@FileTitle  :   C/A Issue Reason Selection
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingcorrection.bdrcorrection.event.EsmBkg0708Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0708Event  event           = null;	//PDTO(Data Transfer Object including Parameters)
	Exception        serverException = null;	//error from the server	
	String strErrMsg = "";						//error messege

	Logger log = Logger.getLogger("com.clt.apps.BookingCorrection.BdrCorrection");
	
	try {	
		event = (EsmBkg0708Event)request.getAttribute("Event");		
		GeneralEventResponse eventResponse = (GeneralEventResponse)request.getAttribute("EventResponse");

		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
	        strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		}
		loadPage();
	}
</script>


<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="bkg_no" value="" id="bkg_no" />
<input type="hidden" name="mode_cd" value="" id="mode_cd" />
<input type="hidden" name="ca_rsn_cd" value="" id="ca_rsn_cd" />
<input type="hidden" name="rvis_seq" value="" id="rvis_seq" />
<input type="hidden" name="rdn_sts_cd" value="" id="rdn_sts_cd" />

<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>C/A Issue Reason Selection</span></h2>
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_select" id="btn_select">Save</button><!--
			--><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
		</div>
	</div>
</div>

<div class="layer_popup_contents">
<div class="wrap_result">
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	
	<div class="opus_design_inquiry">
		<table class="grid_2">
			<colgroup>
				<col width="350" />
				<col width="400" />
				<col width="*" />
			</colgroup>
			<tbody>
				<tr>
					<th colspan="3" class="align_center"><b>RDN</b></th>
				</tr>
				<tr>
					<td><input type="text" name="intg_cd_val_dp_desc" id="intg_cd_val_dp_desc" style="width:100%;text-align:center;color:red"  value="" readonly></td>
				    <td><input type="text" name="rdn_no" id="rdn_no" style="width:100%;text-align:center;color:red"  value="" readonly></td>
				    <td><script type="text/javascript">ComComboObject('rdn_acpt_flg', 1, 120, 1);</script></td>
				</tr>
			</tbody>
		</table>
		<table class="grid_2">
			<tbody>
				<tr>
					<th class="align_center"><b>Remark(s)</b></th>
					<td><textarea name="bkg_corr_rmk" id="bkg_corr_rmk" cols="40" rows="5" style="resize:none;font-family:Courier New; font-size:12px; text-indent:0px;overflow-y:scroll;overflow-x:hidden" class="textarea_img5" wrap="physical" dataformat="excepthan" onBlur="javascript:validateCols('5','40',this);" wrap="hard" maxlength="1000" Caption="Remark"></textarea></td>
				</tr>
			</tbody>
		</table>
	</div>

	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('h1sheet1');</script>
	</div>
	
</div>

</div>
</form>

<SCRIPT  type="text/javascript">
<!--
      /* 
       * The information entered by user is received through event and show it on the screen
       */
      with(document.form)
      {
        <%
        if(event != null){ 
            String bkgNo  = event.getBkgBlNoVO().getBkgNo();
            String modeCd = event.getModeCd();
        %>
            eval("bkg_no").value  = "<%=bkgNo%>"; 
            eval("mode_cd").value = "<%=modeCd%>"; 
        <% } %>
     }
-->
</SCRIPT>
<%@include file="/bizcommon/include/common_opus.jsp"%>
