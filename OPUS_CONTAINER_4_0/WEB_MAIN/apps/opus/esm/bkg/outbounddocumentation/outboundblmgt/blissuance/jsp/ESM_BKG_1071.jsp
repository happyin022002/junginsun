<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1071.jsp
*@FileTitle  : Multi Fax / E-Mail / EDI Result
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>


<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.event.EsmBkg1071Event"%>
<%@ page import="org.apache.log4j.Logger" %>



<%
    EsmBkg1071Event  event = null;              //PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//occurring error in server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//list count of DB resultSet 

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    Logger log = Logger.getLogger("com.clt.apps.OutboundBLMgt.BLDocumentation");
    String bkgNo = null;
    String ntcKndCd= null;
    String ntcViaCd = null;

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();

        event = (EsmBkg1071Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        //When initial screen loading, adding logic extrat data obtained from the server.
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

        bkgNo = JSPUtil.getParameter(request, "bkg_no", "");
        ntcKndCd = JSPUtil.getParameter(request, "ntc_knd_cd", "");
        ntcViaCd = JSPUtil.getParameter(request, "ntc_via_cd", "");
    } catch(Exception e) {
        out.println(e.toString());
    }
%>
<script type="text/javascript">

    function setupPage(){  

	    loadPage();
    }

</script>

<form name="form"> 
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="strUsr_id" value="<%=strUsr_id%>" id="strUsr_id" />
<input type="hidden" name="bkg_no" value="<%=bkgNo%>" id="bkg_no" />
<input type="hidden" name="ntc_knd_cd" value="<%=ntcKndCd%>" id="ntc_knd_cd" />
<input type="hidden" name="ntc_via_cd" value="<%=ntcViaCd%>" id="ntc_via_cd" />

<!-- popup_title_area(S) -->
 <div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title"><span>Multi Fax / E-Mail / EDI Result</span></h2>
		<!-- page_title(E) -->
			
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn"><!--
		--><button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--
		--><button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button>
		</div>
		<!-- opus_design_btn(E) -->	
	</div>
	<!-- page_title_area(E) -->
</div>
<!-- popup_title_area(E) -->


<!-- popup_contens_area(S) -->
<div class="layer_popup_contents">
	<!-- wrap_search(S) -->
	<div class="wrap_search">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit">
			<table> 
				<colgroup>
					<col width="70" />
					<col width="120" />
					<col width="70" />
					<col width="120" />
					<col width="70" />
					<col width="120" />
					<col width="70" />
					<col width="*" />
				</colgroup>
				<tbody>
					<tr>
						<th>Booking No.</th>
						<td><input type="text" name="txt_bkg_no" style="width:100px;text-align:left;" class="input2" value="" readonly id="txt_bkg_no" /> </td>
						<th>B/L No.</th>
						<td><input type="text" name="txt_bl_no" style="width:100px;text-align:left;" class="input2" value="" readonly id="txt_bl_no" /> </td>
						<th>Kind</th>
						<td><input type="text" name="txt_ntc_knd_cd" style="width:200px;text-align:left;" class="input2" value="" readonly id="txt_ntc_knd_cd" /> </td>
						<th>Mode</th>
						<td><input type="text" name="txt_ntc_via_cd" style="width:40px;text-align:left;" class="input2" value="" readonly id="txt_ntc_via_cd" /> </td>
					</tr> 
				</tbody>
			</table>
		</div>
		<!-- inquiry_area(E) -->
	</div>
	<!-- wrap_result(S) -->
	<div class="wrap_result">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid" >
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
		<!-- opus_design_grid(E) -->
	</div>
</div>
<!-- popup_contens_area(E) -->
			
</form>