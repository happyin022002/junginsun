<%/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : STM_SAR_0001.jsp
*@FileTitle  : Office Code Popup
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/05
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.event.StmSar0001Event"%>
<%@ page import="com.clt.framework.component.util.StringUtil" %>
<%@ page import="org.apache.log4j.Logger" %>


<%
    StmSar0001Event event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	
	String ofc_cd    = "";                      //PARAMETER
	
	String strUsr_id = "";
	String strUsr_nm = "";
	Logger log = Logger.getLogger("com.clt.apps.opus.stm.sar.accountreceivablecommon.AccountReceivableCommonSC"); // 에러메세지 위치
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
		event = (StmSar0001Event)request.getAttribute("Event");  // 전성운 수정
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		ofc_cd = StringUtil.xssFilter(request.getParameter("ofc_cd"));  //PARAMETER
		ofc_cd = ofc_cd==null?"":ofc_cd;          //PARAMETER
		
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
				
	} catch(Exception ex) {
		log.error("err " + ex.toString(), ex);
		//out.println(e.toString());
	}
%>
<script  type="text/javascript">

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage(); // .js 호출
	}
</script>
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd"> 
<input type="hidden" name="pagerows" id="pagerows">
<div class="layer_popup_contents">
	<div class="layer_popup_title">
		<!-- page_title_area(S) -->
		<div class="page_title_area clear">
		   <!-- page_title(S) -->
			<h2 class="page_title"><span>AP Office Code</span></h2>
			<!-- page_title(E) -->
			<!-- opus_design_btn(S) -->
			<div class="opus_design_btn">
				<button type="button" class="btn_accent" name="btn_retrieve" 	id="btn_retrieve">Retrieve</button><!--
				--><button type="button" class="btn_normal" name="btn_OK" 		id="btn_OK">OK</button><!--
				--><button type="button" class="btn_normal" name="btn_Close"  		id="btn_Close">Close</button>	
			</div>
			<!-- opus_design_btn(E) -->
			<!-- page_location(S) -->
			<!-- ><div class="location">
				<span id="navigation"></span>
			</div> -->
			<!-- page_location(E) -->
		</div>
		<!-- page_title_area(E) -->
	</div>
	<!-- opus_design_inquiry(S) -->
	<div class= "wrap_search">
		<div class= "opus_design_inquiry wFit">
			<table>
					<colgroup>
						<col width="80"/>
						<col width="*"/>
				    </colgroup>
				    <tbody>
					<tr>
						<th>Office Code</th>
						<td><input type="text" name="ofc_cd" id="ofc_cd" style="width:120px;" class="input" value="<%=ofc_cd%>" maxlength="6" dataformat="engup" style="ime-mode:disabled"></td>
					</tr>
					<!-- <tr class="line_bluedot"><td colspan="2"></td></tr> -->	
				</tbody>
			</table>
		</div>
	</div>
	<!-- opus_design_inquiry(E) -->
	<!-- opus_design_grid(S) -->
	<div class="wrap_result">
		<div class="opus_design_grid clear" >
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
	</div>
	<!-- opus_design_grid(E) -->
</div> 
</form>
<%@include file="/bizcommon/include/common_opus.jsp"%>