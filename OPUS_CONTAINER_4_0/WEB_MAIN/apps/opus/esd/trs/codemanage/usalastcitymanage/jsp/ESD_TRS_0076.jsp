<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TRS_0076.jsp
*@FileTitle  : USA Last City for T&E Cargo
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.trs.codemanage.usalastcitymanage.event.EsdTrs0076Event"%>
<%
	EsdTrs0076Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Error occurred on the server
	String strErrMsg = "";								 //Error message
	String userId  = "";
	String userOfcCd  = "";
	String today = DateTime.getFormatString("yyyyMMdd");

	try {

	   SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   userId=account.getUsr_id();
	   userOfcCd  = account.getOfc_cd();

		event = (EsdTrs0076Event)request.getAttribute("Event");

		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<script language="javascript">
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
<input type="hidden" name="stsval" value="Y">
<input type="hidden" name="hid_row">
<input type="hidden" name="hid_col">
<input type="hidden" name="userid1" value="<%=userId%>">
<input type="hidden" name="today1" value="<%=today%>">
<input type="hidden" name="userid2" value="<%=userId%>">
<input type="hidden" name="today2" value="<%=today%>">
<input type="hidden" name="hid_check" value="<%=today%>">
<input type="hidden" name="userOfcCd" value="<%=userOfcCd%>">

<input type="hidden"  name="change_title" value="Del.|STS|Seq.|Origin Location|Destination Location|Last USA City|Created User ID|Created Office" >


<!-- page_title_area(S) -->
<div class="page_title_area clear">
    
    <!-- page_title(S) -->
    <!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
    <h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
    <!-- page_title(E) -->
    
    <!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
		<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button>
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
	
	
<!-- opus_design_inquiry(S) -->
<div class="wrap_search">
	<div class="opus_design_inquiry wFit" id="MiniLayer">
	    <!-- 조회영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    <table>
	        <colgroup>
	            <col width="100px" />
	            <col width="210px" />
	            <col width="" />
	        </colgroup>
	        <tbody>
				<tr style="height:30px">
					<th>Live / Deleted</th>
					<td>
						<input id="live" name="delt_flg" value="N" type="radio" class="trans"  Onclick="change_val();" checked><label for="live">Live</label>
						<input id="deleted" name="delt_flg" value="Y" type="radio" class="trans"  Onclick="change_val();"><label for="deleted">Deleted</label>
					</td>
					<td></td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
	
<div class="wrap_result">	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" >
		
		<!-- opus_grid_btn(S) -->
			<div class="opus_design_btn">
				<button type="button" class="btn_normal" name="btng_rowadd" id="btng_rowadd">Row Add</button>
				<button type="button" class="btn_normal" name="btng_save" id="btng_save">Save</button>
			</div>
			<!-- opus_grid_btn(E) -->
			
		<script language="javascript">ComSheetObject('sheet1');</script>
		
		<!-- opus_grid_design_btn(E) -->
	</div>
	<!-- opus_design_grid(E) -->
</div>
<div class="header_fixed"></div>
</form>
