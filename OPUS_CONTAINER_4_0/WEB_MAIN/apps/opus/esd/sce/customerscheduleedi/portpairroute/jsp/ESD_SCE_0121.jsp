<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_SCE_0121.jsp
*@FileTitle : edi route Information Management 
*Open Issues :
*Change history :
*@LastModifyDate : 	
*@LastModifier : 	
*@LastVersion : 	1.0
=========================================================*/
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.sce.customerscheduleedi.portpairroute.event.EsdSce0121Event"%>

<%
	EsdSce0121Event  event = null;
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	String strUsr_id		= "";
	try {
		SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		event = (EsdSce0121Event)request.getAttribute("Event");
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

<form method="post" name="form" onSubmit="return false;" id="form">
<input	type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="iPage" id="iPage">
<input type="hidden" name="usr_id" id="usr_id" value = "<%= strUsr_id %>">


	<!-- page_title_area(S) -->
	<div class="page_title_area clear ">
		<!-- page_title(S) -->
		<h2 class="page_title">
			<button type="button"><span id="title">Route Detail</span></button>
		</h2>
		<!-- page_title(E) -->
	
		    <!-- opus_design_btn(S) -->
		    <div class="opus_design_btn">
		        <!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
				<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--  
				--><button type="button" class="btn_normal" name="btn_new"   id="btn_new">New</button><!-- 
				--><button type="button" class="btn_normal" name="btn_save"   id="btn_save">Save</button><!-- 
				--><button type="button" class="btn_normal" name="btn_downexcel"   id="btn_downexcel">Down Excel</button><!-- 
				--><button type="button" class="btn_normal" name="btn_add"   id="btn_add">Add</button>
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
	        <tbody>
				<tr class="h23">
					<th>TP ID</th>
					<td colspan="7">
						<input class="input1" type="text" name="partner_id" id="partner_id" value="" style="width:120px; text-transform:uppercase;" onfocusout="javascript:getPartnerName()"><input class="input1" type="text" name="partner_name" id="partner_name" value="" style="width:416px">
					</td>
				</tr>
				<tr class="h23">
					<th title="Place of Receipt">POR</th>
					<td>
						<input type="text" name="por_port_cd" id="por_port_cd" value="" style="width:60px; text-transform:uppercase;"dataformat="engup"><button type="button" class="input_seach_btn" onClick="openLocPopUp2(true,'por_port_cd')"></button> 
					</td>
					<th title="Port of Loading">POL</th>
					<td>
						<input type="text" name="pol_port_cd" id="pol_port_cd" value="" style="width:60px; text-transform:uppercase;"dataformat="engup"><button type="button" class="input_seach_btn" onClick="openLocPopUp2(true,'pol_port_cd')"></button> 
					</td>
					<th title="Port of Discharging">POD</th>
					<td>
						<input type="text" name="pod_port_cd" id="pod_port_cd" value="" style="width:60px; text-transform:uppercase;"dataformat="engup"><button type="button" class="input_seach_btn" onClick="openLocPopUp2(true,'pod_port_cd')"></button> 
					</td>
					<th title="Place of Delivery">DEL</th>
					<td>
						<input type="text" name="del_port_cd" id="del_port_cd" value="" style="width:60px; text-transform:uppercase;"dataformat="engup"><button type="button" class="input_seach_btn" onClick="openLocPopUp2(true,'del_port_cd')"></button> 
					</td>
					<th>Type</th>
					<td>
						<input type="hidden" name="ts_type" id="ts_type" value="A">
						<select name="select1" id="select1" style="width:70px;" onChange="changeSelect('T')" >
							<option value="A" >All</option>
							<option value="D" >Direct</option>
							<option value="T" >T/S</option>
						</select>
					</td>
					<th>No Use Flag</th>
					<td>
						<input name="no_use_flag" id="no_use_flag" type="checkbox" class="trans"  value="N" unchecked>
					</td>
				</tr>
			</tbody>
		</table>
	    <!-- 조회영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	</div>
	<!-- opus_design_inquiry(E) -->
	</div>
	
	<div class="wrap_result">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid" id="mainTable">
		    <!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
		    <script type="text/javascript">ComSheetObject('sheet1');</script>
		    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
		</div>
		<!-- opus_design_grid(E) -->
	</div>
</form>
<%@include file="/bizcommon/include/common_opus.jsp"%>