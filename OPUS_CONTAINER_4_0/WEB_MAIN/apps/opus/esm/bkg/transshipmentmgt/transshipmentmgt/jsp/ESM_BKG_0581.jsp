<%
/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0581.js
*@FileTitle  : OOP Code Match with Vessel 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/29
=========================================================
*/
%>


<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.event.EsmBkg0581Event"%>
<%@ page import="org.apache.log4j.Logger" %>


<%
	EsmBkg0581Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//DB ResultSet List count
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.TransshipmentMgt.TransshipmentMgt");
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		event = (EsmBkg0581Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		// getting data from server when load the initial screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>


<form name="form" id="form" onkeyup="ComKeyEnter('lengthnextfocus');">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">

<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title">
			<button type="button">
				<span id="title"></span>
			</button>
		</h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
			--><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!--
			--><button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button>
		</div>
		<!-- opus_design_btn(E) -->

		<!-- page_location(S) -->
		<div class="location">
			<!-- location 내용 동적생성 (별도 코딩 불필요) -->
			<span id="navigation"></span>
		</div>
	</div>
<!-- page_title_area(E) -->
<div class= "wrap_search">
<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<tbody>
			<colgroup>
					<col width="30"/>
					<col width="80"/>
					<col width="30"/>
					<col width="80"/>
					<col width="50"/>
					<col width="*" />
				</colgroup>
				<tr>
					<th>Carrier</th>
					<td>
						<input name="crr_cd" id="crr_cd" type="text" size="10" dataformat="engup" maxlength="4"><!--
						--><button type="button" id="btn_carrier_cd" name="btn_carrier_cd" class="input_seach_btn"></button>
					</td>
					<th>Vessel</th>
					<td>
						<input type="text" style="width:88px;" class="input" value="" name="vsl_cd" id="vsl_cd" dataformat="engup" maxlength="4">
					</td>
					<th>VSL Name</th>
					<td>
						<input type="text" style="width:250px; text-transform:uppercase" class="input" value="" name="vsl_eng_nm" id="vsl_eng_nm" maxlength="50" >
					</td>
				</tr>
			</tbody>
		</table>
	</div>
<!-- opus_design_inquiry(E) -->
</div>
<div class="wrap_result">
<!-- layout_wrap (S) -->
<div class="layout_wrap">
    <div class="layout_vertical_2 pad_rgt_8">
        <!-- opus_design_grid(S) -->
        <div class="opus_design_grid" style="margin-top: 29px">
            <script type="text/javascript">ComSheetObject('sheet1');</script>
        </div>
        <!-- opus_design_grid(E) -->
    </div>
    <div class="layout_vertical_2" >
        <!-- opus_design_grid(S) -->
        <div class="opus_design_grid">
            <div class="opus_design_btn">
					<button type="button" class="btn_accent" name="btn_rowAdd" id="btn_retrieve">Row Add</button><!--
					--><button type="button" class="btn_normal" name="btn_delete" id="btn_delete">Delete</button><!--
					--><button type="button" class="btn_normal" name="btn_save2" id="btn_save">Save</button>
			</div>
			<script type="text/javascript">ComSheetObject('sheet2');</script>
        </div>
        <!-- opus_design_grid(E) -->
    </div>
</div>
</div>
<!-- layout_wrap (E) -->
</form>