<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ESM_BKG_0995.jsp
*@FileTitle : Pick up Notice Receiver Setup Pop-up
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/15
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

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->


<!-- OUTER - POPUP (S)tart -->
<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>Pick up Notice Receiver Setup</span></h2>
		
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_DownExcel" id="btn_DownExcel">Down Excel</button><!--  -->
			<button type="button" class="btn_normal" name="btn_LoadExcel" id="btn_LoadExcel">Upload Excel</button><!--  -->
			<button type="button" class="btn_normal" name="btn_Setup" id="btn_Setup">Setup</button><!--  -->
			<button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
		</div>
	</div>
	
	   	<!-- page_location(S) -->
	    <div class="location">
	        <!-- location ë´ì© ëì ìì± (ë³ë ì½ë© ë¶íì) -->
	        <span id="navigation"></span>
	    </div>
	    	
</div>

<div class="layer_popup_contents">
	<div class="wrap_search">
		<div class="opus_design_inquiry wFit">
			<table class="search" border="0" style="width:100%;"> 
                <tr class="h23">
                    <th width="70px">Form  Type</th>
                    <td width="">
                        <select style="width:100px;" name="fom_cd">
                            <option value="EV1" selected="selected">Event#1</option>
                            <option value="EV2">Event#2</option>
                            <option value="EV3">Event#3</option>
                        </select>
                    </td>                                                  
                </tr> 
            </table> 
		</div>
		<script language="javascript">ComSheetObject('sheet1');</script>
		<script language="javascript">ComSheetObject('sheet2');</script>
	</div>
</div>

</form>

<%@include file="/bizcommon/include/common_opus.jsp"%>