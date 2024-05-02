<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_SAM_0900.jsp
*@FileTitle  : Change Sales Rep
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/22
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.sam.generalinfomanage.salesrepinfomanage.event.EsmSam0900Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
String srep_cd = "";
String ofc_cd = "";
String srep_nm = "";
String srep_prmry_flg = "";
String cust_cnt_cd = "";
String cust_seq = "";




	EsmSam0900Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.GeneralInfoManage.SalesRepInfoManage");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmSam0900Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		//ESM_SAM_0006 화면에서 넘어온 파라미터를 받는다.

		srep_cd  = JSPUtil.getParameter(request, "srepCd");
		ofc_cd  = JSPUtil.getParameter(request, "ofcCd");
		srep_nm  = JSPUtil.getParameter(request, "srepNm");
		srep_prmry_flg  = JSPUtil.getParameter(request, "srepPrmryFlg");
		cust_cnt_cd  = JSPUtil.getParameter(request, "custCntCd");
		cust_seq  = JSPUtil.getParameter(request, "cust_seq");



	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<head>
<title>Change Sales Rep</title>


<script type="text/javascript">
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
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="cust_cnt_cd" value="<%=cust_cnt_cd%>" id="cust_cnt_cd" />
<input type="hidden" name="cust_seq" value="<%=cust_seq%>" id="cust_seq" />
<input type="hidden" name="org_flg" value="<%=srep_prmry_flg%>" id="org_flg" />
<input type="hidden" name="usr_id" value="<%=strUsr_id%>" id="usr_id" />
<input type="hidden" name="key" id="key" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_save" id="btn_save" type="button">Save</button><!--
		--><button class="btn_normal" name="btn_close" id="btn_close" type="button">Close</button><!--
		--></div>
	<!-- opus_design_btn (E) -->

	<!-- page_location(S) -->
	<div class="location">	
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->

<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="80" />				
				<col width="*" />				
		   </colgroup> 
		   <tbody>
		   		<tr>
		   			<th>S. Rep Code</th>
					<td><!-- 
					--><input type="text" style="width:140px;ime-mode:disabled;text-align:center" class="input1" name="srep_cd" dataformat="engup" maxlength="5" value="<%= srep_cd %>" id="srep_cd" /><!-- 
					--><input type="text" style="width:100px;text-align:center" readonly class="input2" name="ofc_cd" maxlength="100" value="<%= ofc_cd %>" id="ofc_cd" /><!-- 
					--><input type="text" style="width:140px;text-align:center" readonly class="input2" name="srep_nm" maxlength="100" value="<%= srep_nm %>" id="srep_nm" /><!-- 
					--></td>
		   		</tr>
		   		<tr>
		   			<td>Primary</td>
					<td><!-- 
					--><select name="srep_prmry_flg" id="srep_prmry_flg" style="width:50px;ime-mode:disabled;text-align:center" ><!-- 
						--><option value="N">N</option><!-- 
						--><option value="Y">Y</option><!-- 
					--></select><!-- 
					--></td>
		   		</tr>
		   </tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet1');</script>		
	</div>
	<!-- opus_design_grid(E) -->
</div>

</form>