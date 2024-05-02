<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_PSO_0205.jsp
*@FileTitle  : Service Provider Help 
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
<%@ page import="com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.event.VopPso0205Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopPso0205Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_Ofc_cd      = "";

	Logger log = Logger.getLogger("com.clt.apps.PortSOMasterDataMgt.PortTariffMgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_Ofc_cd = account.getOfc_cd();
	   
		event = (VopPso0205Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
	strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
	usrOfcCd = "<%=strUsr_Ofc_cd%>";//UserOfcCD
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form" >
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">

	<div class="page_title_area clear">
		<h2 class="page_title"><span>Service Provider Help</span></h2>
		
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--
			--><button type="button" class="btn_normal" name="btn_OK" id="btn_OK">OK</button><!-- 
			--><button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button>
		</div>
	</div>

<!-- opus_design_inquiry(S) -->
<div class="wrap_search">
	<div class="opus_design_inquiry wFit">
		<!--  MiniLayer (S) -->
		<table>
			<colgroup>
	            <col width="70" />
	            <col width="130" />
	            <col width="60" />
	            <col width="*" />
			</colgroup>
			<tbody>
				<tr>
	                <th>INV. Office</th>
					<td><input name="ofc_cd" dataformat="engup" maxlength="6" type="text" style="ime-mode:disabled;width:70px;text-align: center;" class="input" value="" id="ofc_cd" /> </td>
					<th>Country</th>
					<td><input name="vndr_cnt_cd" dataformat="engup" maxlength="2" type="text" style="ime-mode:disabled;width:35px;text-align: center;" class="input" value="" id="vndr_cnt_cd" /><!-- 
						 --><button type="button" class="input_seach_btn" name="btns_search" id="btns_search"></button>
					</td>
	            </tr>
	            <tr>
	            	<th>Service Provider Name</th>
					<td colspan="3"><input name="vndr_lgl_eng_nm" dataformat="engupetc" maxlength="50" type="text" style="ime-mode:disabled;width:320px;" class="input" value="" id="vndr_lgl_eng_nm" /></td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
<!-- opus_design_inquiry(E) -->

<!-- opus_design_grid(S) -->
<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
	    <script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<!-- opus_design_grid(E) -->
</div>
<!-- opus_design_grid(E) -->
</form>