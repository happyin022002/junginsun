<%/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : ESM_BKG_1015.jsp
*@FileTitle : Relay Vessel Group Assign by relay Port_VVD Assign
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/10
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.event.EsmBkg1015Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg1015Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strFormerTrnkFlg = "";
	String strNextTrnkFlg = "";

	Logger log = Logger.getLogger("com.clt.apps.TransshipmentMgt.TransshipmentMgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg1015Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		strFormerTrnkFlg = event.getFormerTrnkFlg();
		strNextTrnkFlg = event.getNextTrnkFlg();

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
<input type="hidden" name="assignTpCd">
<input type="hidden" name="formerTrnkFlg" value="<%=strFormerTrnkFlg%>">
<input type="hidden" name="nextTrnkFlg" value="<%=strNextTrnkFlg%>">

<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>VVD Assign</span></h2>
		
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button><!-- 
			--><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button> 
		</div>
	</div>
</div>

<div class="layer_popup_contents">

	<div class="wrap_result">
		<div class="opus_design_inquiry" >
			<table>
				<tbody>
					<tr>
						<th colspan="2" class="align_left">What VVD will you assign?</th>
					</tr>
					<tr>
						<td width="100"><input type="checkbox" value="F" name="formerVvdChk" id="formerVvdChk"><label for="formerVvdChk">Former VVD</label></td> 
						<td><input type="text" style="width:100%;" class="input" name="formerVvd"  maxlength="9" dataformat="engup" onBlur="bkg1015_Blur(this);"></td>
					</tr>
					<tr>
						<td><input type="checkbox" value="N" name="nextVvdChk" id="nextVvdChk"><label for="nextVvdChk">Next VVD</label></td>
						<td><input type="text" style="width:100%;" class="input" name="nextVvd"  maxlength="9" dataformat="engup" onBlur="bkg1015_Blur(this);"></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
		
</div>	
</form>