<%
/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MST_0017.jsp
*@FileTitle  : ERP Interface - OW Master / Term Change
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/22
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
<%@ page import="com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.event.EesMst0017Event"%>
<%@ page import="org.apache.log4j.Logger" %>


<%
	EesMst0017Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.EquipmentManagement.ContainerOnOffHire");
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		event = (EesMst0017Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
	} catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
	<%= JSPUtil.getIBCodeCombo("acct_qty_mzd_cd", "", "CD20098", 0, "")%>

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form" id="form">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="hid_type" id="hid_type">
<input type="hidden" name="lot_no" id="lot_no" />
<input type="hidden" name="term_cng_seq" id="term_cng_seq" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title">
		<button type="button"><span id="title"></span></button>
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

<div class="wrap_search_tab">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry">
		<table>
			<tbody>
				<tr>
					<th width="60">Delivery Month</th>
					<td width="130">
						<input type="text" style="width: 70px; text-align:center;" dataformat="ym" maxlength="7" class="input1" value="" name="de_yrmon" id="de_yrmon"><!--
						--><button type="button" class="calendar ir" name="btn_Calendar" id="btn_Calendar"></button>
					</td>
					<td width="400">
						<div class="sm">
							<table>
								<tr>
									<th width="40">Type</th>
									<td width="180">
										<input type="radio" name="type" id="ow" checked><label for="ow">Ow</label><!--
										 --><input type="radio" name="type" id="term_change"><label for="term_change">Term Change</label>
									</td>
									<th width="60">Option</th>
									<td>
										<select style="width: 120px;" class="input" name="if_cd" id="if_cd">
											<option value="0" selected>All</option>
											<option value="1">Not Interface</option>
											<option value="2">Interface</option>
										</select>
									</td>
							</table>
						</div>
					</td>
					<td></td>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">

<!-- opus_tab_btn(S) -->
<div class="opus_design_tab">
	<script type="text/javascript">ComTabObject('tab1')</script>
</div>
<!-- opus_tab_btn(E) -->	

<div class="opus_design_grid clear" name="tabLayer" id="tabLayer">
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_t1cntrlist" id="btn_t1cntrlist">CNTR List</button>
		<button type="button" class="btn_accent" name="btn_t1downexcel" id="btn_t1downexcel">Down Excel</button>
	</div>
	<script type="text/javascript">ComSheetObject('t1sheet1');</script>
</div>


<div class="opus_design_grid clear" name="tabLayer" id="tabLayer">
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_t2cntrlist"  id="btn_t2cntrlist">CNTR List</button>
		<button type="button" class="btn_accent" name="btn_t2downexcel" id="btn_t2downexcel">Down Excel</button>
	</div>
		<script language="javascript">ComSheetObject('t2sheet1');</script>
		<div style="display: none;"><script type="text/javascript">ComSheetObject('t1sheet2');</script></div>
		<div style="display: none;"><script type="text/javascript">ComSheetObject('t2sheet2');</script></div>
</div>
</div>
</form>