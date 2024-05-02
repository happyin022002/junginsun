<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : ESM_BKG_1014.jsp
*@FileTitle : ESM_BKG_1014
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/13
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.util.StringUtil" %>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.event.EsmBkg0930Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0930Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String inCllType ="";
	Logger log = Logger.getLogger("com.clt.apps.TerminalDocumentation.CLLCDLManifest");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   	inCllType = StringUtil.xssFilter(request.getParameter("inCllType"))==null?"":StringUtil.xssFilter(request.getParameter("inCllType"));
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg0930Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

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
</head>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="inCllType" value="<%=inCllType%>">

<!-- popup_title_area(S) -->
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title"><span> (Korea)Container Loading List</span></h2>
		<!-- page_title(E) -->
			
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_Ok" id="btn_Ok">OK</button>
    		<button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button>
		</div>
		<!-- opus_design_btn(E) -->	
	</div>
	<!-- page_title_area(E) -->
<!-- popup_title_area(E) -->

<!-- popup_contens_area(S) -->
<div class="layer_popup_contents">
	<div class="opus_design_inquiry wFit">   <!-- no TAB  -->
		<table> 
			<colgroup>
				<col width="80px" />
				<col width="100px" />
				<col width="45px" />
				<col width="" />
			</colgroup>
			<tbody>
				<tr>
					<th>Rows</th>
					<td>
						<input type="text" style="width:90px;" dataformat="num" name="start_index" class="input1" value="" style="ime-mode:disabled">
					</td>
					<th>~ &nbsp; &nbsp; </th>
					<td>
						<input type="text" style="width:90px;" dataformat="num" name="end_index"  class="input1" value="" style="ime-mode:disabled">
					</td>					
				</tr>
				<tr>
					<th>TS &nbsp; &nbsp;</th>
					<td>
						<select name="ts" style="width:90px">
							<option value=""></option>
							<option value="TT">TT</option>
							<option value="TS">TS</option>
						</select>
					</td>
					<th>POD &nbsp; </th>
					<td>
						<input type="text" style="width:90px;" name="pod" dataformat="engup" maxlength="5" class="input" value="" style="ime-mode:disabled">
					</td>					
				</tr>
				<tr>
					<th>MLB&nbsp;</th>
					<td>
						<input type="text" style="width:90px;" name="mlb" dataformat="engup" maxlength="3" class="input" value="" style="ime-mode:disabled">
					</td>
					<th>YD &nbsp; &nbsp;</th>
					<td>
						<input type="text" style="width:90px;" name="yd" dataformat="engup" maxlength="2" class="input" value="" style="ime-mode:disabled">
					</td>					
				</tr>
			</tbody>
		</table>
	</div>

</div>

				
</form>			

