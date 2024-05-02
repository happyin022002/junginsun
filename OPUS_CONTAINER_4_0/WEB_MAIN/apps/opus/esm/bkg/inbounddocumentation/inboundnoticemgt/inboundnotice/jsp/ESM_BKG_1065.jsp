<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1065
*@FileTitle  : Rail Data Setup Pop-up
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/12
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.InboundBlMgt.PickUpNotice");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
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
</head>

<form name="form">
<input id="f_cmd" name="f_cmd" type="hidden" />
<input id="pagerows" name="pagerows" type="hidden" />

<div class="layer_popup_title">

	<!-- page_title_area(S) -->
	<div class="page_title_area clear">

		<!-- page_title(S) -->
		<h2 class="page_title"><span>Rail Data Setup</span></h2>
		<!-- page_title(E) -->
		
		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn">
			<button type="button" id="btn_Setup" name="btn_Setup" class="btn_accent">Setup</button><!--
			--><button type="button" id="btn_Close" name="btn_Close" class="btn_normal">Close</button><!--
			--></div>
		<!-- opus_design_btn (E) -->

		<!-- page_location(S) -->
		<div class="location">	
			<span id="navigation"></span>
		</div>
		<!-- page_location(E) -->
		
	</div>
	<!-- page_title_area(E) -->

</div>

<div class="layer_popup_contents">

	<div class="wrap_search">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit">
			<table>
				<colgroup>
					<col width="50" />				
					<col width="*" />				
				</colgroup> 
				<tr>
                 	<th>AVL DT</th>
                    <td><input type="text" style="width:80px;text-align:center;" class="input" dataformat="ymd" maxlength="10"   caption="AVL DT" name="avl_dt" id="avl_dt" /><button class="calendar ir" name="img_avl_dt" id="img_avl_dt" type="button"></button></td>
                </tr>
                <tr>
                    <th>FRE  DT</th>
                    <td><input type="text" style="width:80px;text-align:center;" class="input" dataformat="ymd" maxlength="10" caption="FRE DT" name="fre_dt"  id="fre_dt"/><button class="calendar ir" name="img_fre_dt" id="img_fre_dt" type="button"></button></td>
                </tr>
                <tr>
                    <th>PICK YD</th>
                    <td><input type="text" style="width:80px;text-align:center;ime-mode:disabled;" class="input" name="pkup_yd_cd" id="pkup_yd_cd" caption="PICK YD" dataformat="engup" /></td>
                </tr>
                <tr>
                    <th>RTN YD</th>
                    <td><input type="text" style="width:80px;text-align:center;ime-mode:disabled;" class="input" name="rtn_yd_cd" id="rtn_yd_cd" caption="RTN YD"  dataformat="engup"  /></td>
                </tr>
			</table>
		</div>
		<!-- opus_design_inquiry(E) -->
	</div>
</div>
</form>
<%@include file="/bizcommon/include/common_opus.jsp"%>