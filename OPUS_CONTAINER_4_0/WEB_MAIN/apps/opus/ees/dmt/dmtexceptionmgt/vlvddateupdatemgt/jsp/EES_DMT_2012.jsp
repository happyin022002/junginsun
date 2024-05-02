<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   EES_DMT_2012.jsp
*@FileTitle  : VL/VD Date Update by VVD 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/20
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.dmt.dmtexceptionmgt.vlvddateupdatemgt.event.EesDmt2012Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesDmt2012Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= ""; 
	String strUsr_nm		= "";
    String strRhq_of = "";
	Logger log = Logger.getLogger("com.clt.apps.DMTExceptionMgt.VLVDDateUpdateMgt");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	    strRhq_of = account.getRhq_ofc_cd();
	   
		event = (EesDmt2012Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// Retrieving the parameter values ​​for calls to pop-up page ..
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

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="loc_cd" id="loc_cd" />
<input type="hidden" name="pastDayR" id="pastDayR" />
<input type="hidden" name="pastVvdR" id="pastVvdR" />
<input type="hidden" name="h_rhq_off" value="<%=strRhq_of%>">
	
	<!-- page(S) -->
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
		 --><button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button>		
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
	<!--Page Title, Historical (E)-->
	
	<div class="wrap_search">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit">
			<!--  MiniLayer (S) -->
			<table>
				<colgroup>
		            <col width="115" />
		            <col width="85" />
		            <col width="70" />
		            <col width="250" />
		            <col width="100" />
		            <col width="80" />	            
		            <col width="*" />
				</colgroup>
				<tbody>
					<tr>
						<th>Movement Status</th>
						<td>
							<select style="width:55px;" class="input1" name="mvmt" id="mvmt" onKeyPress="form_keyup()">
		                        <option value="VL" selected>VL</option>
	                            <option value="VD"         >VD</option>
							</select>
						</td>
						<th>Tariff type</th>
						<td colspan="3">
							<input type="text" style="width:90px;" class="input2" value="DMOF, CTOC" name="type" readonly>
						</td>					
						<td></td>
					</tr>
					<tr>
						<th>Port</th>
						<td>
							<input type="text" style="width:55px;" class="input1" value="" name="port" id="port" dataformat="engup" maxlength="5" onblur="obj_keyup()">
						</td>
						<th class="sm">
							<input type="radio" name="dayVvdR" value="" class="trans" checked OnClick="dayVvdR_click()"> Period
						</th>
						<td class="sm">
							<input type="text" style="width:75px;text-align:center" class="input1" value="" id="frdt" name="frdt" dataformat="ymd" maxlength="8">~&nbsp;<!-- 
							--><input type="text" style="width:75px;text-align:center" class="input1" value="" id="todt" name="todt" dataformat="ymd" maxlength="8"><button type="button" class="calendar ir" name="btns_calendarto" id="btns_calendarfm"></button>
						</td>
						<th class="sm">
							<input type="radio" name="dayVvdR" value="" class="trans" OnClick="dayVvdR_click()"> VVD Code
						</th>
						<td class="sm">
							<input type="text" style="width:80px;" class="input2" value="" id="vvdc" name="vvdc" dataformat="engup" maxlength="9" readonly>
						</td>
						<td></td>
					</tr>				
				</tbody>
			</table>
		</div>
	</div>
	
	<div class="wrap_result">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">
			<!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
		    <script type="text/javascript">ComSheetObject('sheet1');</script>
		    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
		</div>
		<!-- opus_design_grid(E) -->
	</div>

</form>
