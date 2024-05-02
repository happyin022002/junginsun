<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_SCE_0120.jsp
*@FileTitle  : EDI Route Master 
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
<%@ page import="com.clt.apps.opus.esd.sce.customerscheduleedi.portpairroute.event.EsdSce0120Event"%>

<%
	EsdSce0120Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//setting error at server side.
	String strErrMsg = "";						//Error message
	String strUsr_id		= "";
	try {
		SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		event = (EsdSce0120Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
	} catch(Exception e) {
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
<input	type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="usr_id" value = "<%= strUsr_id %>">

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
    <!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->

	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--  
		--><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!-- 
		--><button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button><!-- 
		--><button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button><!-- 
		--><button type="button" class="btn_normal" name="btn_add" id="btn_add">Add</button>
	</div>
	<!-- opus_design_btn(E) -->
   	<!-- page_location(S) -->
   	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
        <span id="navigation"></span>
   	</div>
   	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->

<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
	    <!-- 조회영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    <table>
	    	<colgroup>
	            <col width="50" />
	            <col width="180" />
	            <col width="30" />
	            <col width="180" />
	            <col width="30" />
	            <col width="180" />
	            <col width="35" />
	            <col width="" />
	        </colgroup>
	        <tbody>
				<tr class="h23">
					<th>TP ID</th>
					<td colspan="5"><input class="input1" type="text" id="partner_id" name="partner_id" value="" style="width:120px; text-transform:uppercase;" onfocusout="javascript:getPartnerName()"><input class="input1" type="text" id="partner_name" name="partner_name" value="" style="width:416px"><button type="button" class="btn_etc" name="btn_save_partner" id="btn_save_partner">Save</button></td>
				</tr>
				<tr class="h23">
					<th title="Place of Receipt">POR</th>
					<td><input type="text" name="por_port_cd" value="" style="width:60px; text-transform:uppercase;" dataformat="engup" id="por_port_cd" /><button name="_por_port_cd" id="_por_port_cd" type="button" class="input_seach_btn" onClick="openLocPopUp2(true,'por_port_cd');"></button></td>
					<th title="Port of Loading">POL</th>
					<td><input type="text" name="pol_port_cd" value="" style="width:60px; text-transform:uppercase;" dataformat="engup" id="pol_port_cd" /><button name="_pol_port_cd" id="_pol_port_cd" type="button" class="input_seach_btn" onClick="openLocPopUp2(true,'pol_port_cd');"></button></td>
					<th title="Port of Discharging">POD</th>
					<td><input type="text" name="pod_port_cd" value="" style="width:60px; text-transform:uppercase;" dataformat="engup" id="pod_port_cd" /><button name="_pod_port_cd" id="_pod_port_cd" type="button" class="input_seach_btn" onClick="openLocPopUp2(true,'pod_port_cd');"></button></td>
					<th title="Place of Delivery">DEL</th>
					<td><input type="text" name="del_port_cd" value="" style="width:60px; text-transform:uppercase;" dataformat="engup" id="del_port_cd" /><button name="_del_port_cd" id="_del_port_cd" type="button" class="input_seach_btn" onClick="openLocPopUp2(true,'del_port_cd');"></button></td>
				</tr>
			</tbody>
		</table>
		<!-- 조회영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	</div>
	<!-- opus_design_inquiry(E) -->
</div>
	<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    <script type="text/javascript">ComSheetObject('sheet1');</script>
	    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	</div>
	<!-- opus_design_grid(E) -->
	<!-- page(E) -->
</div>
</form>
<%@include file="/bizcommon/include/common_opus.jsp"%>