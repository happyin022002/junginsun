<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_SCE_0104.jsp
*@FileTitle  : Common Popup
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/31
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.sce.common.popup.event.CommonPopUpManageEvent"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	CommonPopUpManageEvent  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Error on Server Side.
	String strErrMsg = "";						//Error Message
	int rowCount	 = 0;						//DB ResultSet List Count

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.common.popup");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (CommonPopUpManageEvent)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// The data obtained from the server side on load.
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

<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="modeVal" value="" id="modeVal" />
<input type="hidden" name="mode_only" value="" id="mode_only" />
<input type="hidden" name="cnt_cd" value="" id="cnt_cd" />
<input type="hidden" name="loc_cd" value="" id="loc_cd" />
<input type="hidden" name="lcc_cd" value="" id="lcc_cd" />
<div class="layer_poup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	   <!-- page_title(S) -->
		<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title"><span>Location / Node Inquiry</span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn"><!-- 
			 --><button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_new"  	id="btn_new">New</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_ok" 	id="btn_ok">OK</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_close" 	id="btn_close">Close</button>
		</div>
		<!-- opus_design_btn(E) -->
	</div>
	<!-- page_title_area(E) -->
</div>

	<div class="wrap_search">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit">
			<table>
				<colgroup>
					<col width="70">
					<col width="60">
					<col width="*">
				</colgroup>
				<tbody>
					<tr>
						<th><input type="radio" name="selection" value="location" class="trans" checked id="selection" />&nbsp;Location</th>
						<th><input type="radio" name="selection" value="node" class="trans" id="selection" />&nbsp;Node</th>
						<td></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	<div class="wrap_result">
		<div id="location">
			<div class="opus_design_inquiry wFit">
				<table>
					<colgroup>
						<col width="90">
						<col width="100">
						<col width="80">
						<col width="100">
						<col width="80">
						<col width="100">
						<col width="40">
						<col width="*">
					</colgroup>
					<tbody>
						<tr>
							<th>Conti</th>
		                    <td><input name="conti_cd" type="text" style="width:75px;" onkeyup="javascript:upper(this);" id="conti_cd" /></td>
		                    <th>Sub Conti</th>
		                    <td><input name="sconti_cd" type="text" style="width:75px;" onkeyup="javascript:upper(this);" id="sconti_cd" /></td>
		                    <th>Country</th>
		                    <td><input name="cnt_cd_1" type="text" style="width:75px;" onkeyup="javascript:upper(this);" id="cnt_cd_1" /></td>
		                    <th>State</th>
		                    <td><input name="loc_state" type="text" style="width:61px;" onkeyup="javascript:upper(this);" id="loc_state" /></td>
		                    <th>&nbsp;</th>
	                  	</tr>
	             	</tbody>
	            </table>
	            <table>
	            	<colgroup>
						<col width="90">
						<col width="100">
						<col width="80">
						<col width="100">
						<col width="80">
						<col width="100">
						<col width="80">
						<col width="*">
					</colgroup>
	            	<tbody>
	                  	<tr>
		                    <th>Control Office</th>
		                    <td><input name="loc_eq_ofc" type="text" style="width:75px;" onkeyup="javascript:upper(this);" id="loc_eq_ofc" /></td>
		                    <th>LOC Code</th>
		                    <td><input name="loc_cd_1" type="text" style="width:75px;" onkeyup="javascript:upper(this);" id="loc_cd_1" /></td>
		                    <th>LOC Name</th>
		                    <td><input name="loc_nm" type="text" style="width:202px;" id="loc_nm" /></td>
		                    <th><input name="chk_port_ind" type="checkbox" value="Y" class="trans" id="chk_port_ind" />&nbsp;Port Only</th>
		                    <td></td>
						</tr>
					</tbody>
				</table>
			</div>
			<!-- opus_design_grid(S) -->
			<div class="opus_design_grid">
				<script type="text/javascript">ComSheetObject('sheet1');</script>
			</div>
			<!-- opus_design_grid(S) -->
		</div>
		<div id="node" style="display: none;">
			<div class="opus_design_inquiry wFit">
				<table>
					<colgroup>
						<col width="50">
						<col width="100">
						<col width="80">
						<col width="150">
						<col width="80">
						<col width="*">
					</colgroup>
					<tbody>
						<tr>
			               	<th>Country</th>
		                    <td><input type="text" name="cnt_cd_2" style="width:75px;" onkeyup="javascript:upper(this);" id="cnt_cd_2" /></td>
		                    <th>Location</th>
		                    <td><input type="text" name="loc_cd_2" style="width:75px;" onkeyup="javascript:upper(this);" id="loc_cd_2" /></td>
		                    <th>Control Office</th>
		                    <td><input type="text" name="ofc_cd" style="width:75px;" onkeyup="javascript:upper(this);" id="ofc_cd" /></td>
	                  	</tr>
	             	</tbody>
	            </table>
	            <table>
	            	<colgroup>
						<col width="50">
						<col width="100">
						<col width="80">
						<col width="100">
						<col width="60">
						<col width="60">
						<col width="*">
					</colgroup>
	            	<tbody>
	                  	<tr>
		                    <th>Node</th>
		                    <td><input type="text" name="node_cd" style="width:75px;" onkeyup="javascript:upper(this);" id="node_cd" /></td>
		                    <th>Node Name</th>
		                    <td><input type="text" name="node_nm" style="width:307px;" id="node_nm" /></td>
		                    <th><input type="radio" name="mode" value="yard" class="trans" onclick="javascript:modeVal.value=this.value;initSheet(sheetObjects[1],2);" checked id="mode" />&nbsp;Yar</th>
		                    <th><input type="radio" name="mode" value="zone" class="trans" onclick="javascript:modeVal.value=this.value;initSheet(sheetObjects[1],2);" id="mode" />&nbsp;Zone</th>
		                    <td></td>
		                    <td></td>
						</tr>
					</tbody>
				</table>
			</div>
			<!-- opus_design_inquiry(E) -->
			<!-- opus_design_grid(S) -->
			<div class="opus_design_grid">
				<script type="text/javascript">ComSheetObject('sheet2');</script>
			</div>
			<!-- opus_design_grid(S) -->
		</div>
		</div>
	
</form>
<%@include file="../../../common/commonpopup/include/common.jsp"%>