<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : vop_vsk_0010.jsp
*@FileTitle  : Lane Information Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/17
=========================================================
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.laneinformationmgt.event.VopVsk0702Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopVsk0702Event  event = null;					
	Exception serverException   = null;			
	int rowCount	 = 0;						//DB ResultSet 
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strErrMsg = "";						
	Logger log = Logger.getLogger("com.clt.apps.VesselOperationSupportMgt.LaneInformationMgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (VopVsk0702Event)request.getAttribute("Event");
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
<input type="hidden" name="vskd_flet_grp_cd" id="vskd_flet_grp_cd" />
<!-- page_title_area(S) -->
<div class="layer_popup_title">
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><span>Lane Group Setting</span></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn"><!-- 
		 --><button type="button" class="btn_normal" name="btn_ok" id="btn_ok">Ok</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button><!-- 
	 --></div>
	<!-- opus_design_btn(E) -->
</div>
</div>
<!-- page_title_area(E) -->
<div class= "wrap_search">
<!-- opus_design_inquiry(S) -->
<div class="opus_design_inquiry wFit">
	<table id="searchHelp">
		<colgroup>
			<col width="40"/>
			<col width="*" />
		</colgroup>
			<tbody>
				<tr>
					<th>Target LRS Lane Select</th>
					<td class="stm"><input type="radio" class="trans" name="vsl_svc_tp_cd" id="vsl_svc_tp_cd" value="" checked><label for ="vsl_svc_tp_cd">All</label><input type="radio" class="trans" name="vsl_svc_tp_cd" id="vsl_svc_tp_cd" value="1"><label for ="vsl_svc_tp_cd">Trunk</label><input type="radio" class="trans" name="vsl_svc_tp_cd" id="vsl_svc_tp_cd" value="2"><label for ="vsl_svc_tp_cd">Feeder</label></td>
				</tr>
			</tbody>
	</table>
</div>
</div>

<div class="wrap_result">
	<div class="layout_wrap">
		<div class="layout_vertical_3" style ="width: 45%;">
			<div class="opus_design_grid clear" id="sheetHelp">
				<script type="text/javascript">ComSheetObject('sheet1');</script>
			</div>
		</div>
		<div class="layout_vertical_3" style ="width: 5%;">	
		<table style="position: relative;top:190px">
		<tr><td style = "text-align: center;">
		<table>
		<tr><td align="center"><button type="button" class="btn_right" name="btns_add" id="btns_add"></button></td></tr>
		<tr><td style="height:10px"></td></tr>
		<tr><td align="center"><button type="button" class="btn_left" name="btns_del" id="btns_del"></button></td></tr></table>
		</td></tr></table>		
		</div>			
		<div class="layout_vertical_3" style ="width: 50%;">	
		<div class="opus_design_grid ">				
		<h3 style="margin-bottom:0" class="title_design">Main Lane</h3>				
			<div id="sheetHelp1">				
			<script type="text/javascript">ComSheetObject('sheet2');</script>
			</div>
		<h3 style="margin-bottom:0" class="title_design">Slot Charter Only Lane</h3>			
			<div  id="sheetHelp2">				
			<script type="text/javascript">ComSheetObject('sheet3');</script>
			</div>		
		<h3 style="margin-bottom:0" class="title_design">Other Lane</h3>			
			<div id="sheetHelp3">				
			<script type="text/javascript">ComSheetObject('sheet4');</script>
			</div>			
		<h3 style="margin-bottom:0" class="title_design">Intra Asia Lane</h3>			
			<div id="sheetHelp4">				
			<script type="text/javascript">ComSheetObject('sheet5');</script>
			</div>					
			<div id="sheetHelp5" style="display:none">				
			<script type="text/javascript">ComSheetObject('dummy');</script>
			</div>	
		</div>
		</div>
	</div>
</div>
</form>