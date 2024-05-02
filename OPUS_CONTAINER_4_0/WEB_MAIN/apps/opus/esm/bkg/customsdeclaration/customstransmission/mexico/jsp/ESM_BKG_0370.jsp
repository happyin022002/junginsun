<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0370.jsp
*@FileTitle  : Mexico Customs Transmit 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/28
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.mexico.event.EsmBkg0370Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmBkg0370Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //error from server
	String strErrMsg = ""; //error message

	String strUsr_id = "";
	String strUsr_nm = "";
	String search_flg1 = "";
	String search_flg3 = "";

	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		String ofcCd = account.getOfc_cd();
			
		if(ofcCd != null){
			if(ofcCd.substring(0, 3).equals("MEX")){
				search_flg1 = "checked";
			}
		}
		if( search_flg1.equals("")){
			search_flg3 = "checked";
		}
		
		event = (EsmBkg0370Event) request.getAttribute("Event");
		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	} catch (Exception e) {
		out.println(e.toString());
	}
%>

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			//showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form"><input type="hidden" name="f_cmd"> 
<input type="hidden" name="pagerows">
<input type="hidden" name="pageno" value="ESM_BKG_0370">

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	
	<!-- page_title(S) -->
    <!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->

	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button>
		<button type="button" class="btn_normal" name="btn_Transmit" id="btn_Transmit">Transmit</button>
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
	<!--  MiniLayer (S) -->
	<table>
		<colgroup>
            <col width="100" />
            <col width="30" />
            <col width="100" />
            <col width="150" />
            <col width="70" />
            <col width="100" />
            <col width="100" />
            <col width="100" />
            <col width="100" />
            <col width="*" />
        </colgroup>
		<tbody>
			<tr>
				<th class='sm'>O/B(Trunk)</th><td class='sm'><input type="radio" name="search_flg" value="O" class="trans" <%=search_flg1%>></td>
				<th title="Vessel Voyage Direction">VVD</th> 
				<td><input type="text" style="width: 80px; ime-mode:disabled;" class="input1" maxlength="9" value="" name="vvd" dataformat="engup" required caption="VVD"></td>
				<th title="Port of Loading">POL</th>
				<td><input type="text" name="pol_cd" maxlength="5" style="width:60px;ime-mode:disabled;" value="" class="input" dataformat="engup" caption="POL"></td>
				<th title="Port of Discharging">POD</th>
				<td><script type="text/javascript">ComComboObject('pod_cd', 1, 78, 1, 1, 0, false);</script></td>
				<th>Total B/L</th>
				<td><input type="text" name="total_bl" class="input2" style="width:80px;ime-mode:disabled;text-align:right" class="input2" value="" readonly ></td>
			</tr>
			<tr>
				<th class='sm'>T/S(Feeder)</th><td class='sm'><input type="radio" name="search_flg" value="T" class="trans"></td>
				<th>Vessel Name</th>
				<td><input type="text" name="vsl_eng_nm" style="width:110px;" class="input2" value="" readonly></td>
				<th>Call Sign</th>
				<td><input type="text" name="call_sgn_no" style="width:60px;" class="input2" value="" readonly></td>
				<th>ETD</th>
				<td><input type="text" name="etd" style="width:80px;" class="input2" value="" readonly></td>
				<th>ETA</th>
				<td><input type="text" name="eta" style="width:80px;" class="input2" value="" readonly></td>
			</tr>
			<tr>
				<th class='sm'>I/B(Trunk)</th><td class='sm'><input type="radio" name="search_flg" value="I" class="trans" <%=search_flg3%>></td><td colspan="8"></td>
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
    <script language="javascript">ComSheetObject('sheet1');</script>
    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
</div>
<!-- opus_design_grid(E) -->
</div>
</form>