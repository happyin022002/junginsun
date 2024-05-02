<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CGM_2079.js
*@FileTitle  : Inventory by Creation Office
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/10
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.event.EesCgm2079Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.component.util.io.HttpUtil"%>

<%
	EesCgm2079Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.ChassisMgsetMgt.ChassisMgsetInventory");

	String xml = HttpUtil.makeXML(request,response);

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EesCgm2079Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// adding logic to get data from server when first loading
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

<form name="form2">
<input type="hidden" name="sXml" value="<%=xml.replace(" \"","'") %>" id="sXml" />
</form>
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="ofc_cd" id="ofc_cd" />
<!-- developer working -->
<input type="hidden" name="eq_knd_cd" id="eq_knd_cd" />
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn"><!--  
	--><button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--  
	--><button type="button" class="btn_normal" name="btn_new"  	id="btn_new">New</button><!--  
	--><button type="button" class="btn_normal" name="btn_downexcel" 	id="btn_downexcel">Down Excel</button><!--  
	--></div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<div class="wrap_search">
	<div class="opus_design_inquiry">
		<table>
			<colgroup>
				<col width="70px">
				<col width="*">
			</colgroup> 
			<tr>
				<th>On-hire Period</th>
				<td><input type="text" name="inq_fm_dys" style="width:89px;ime-mode:disabled;text-align:center" dataformat="ymd" class="input1" maxlength="10" value="" id="inq_fm_dys" />~ <!--  
				--><input type="text" name="inq_to_dys" style="width:89px;ime-mode:disabled;text-align:center" dataformat="ymd" class="input1" maxlength="10" value="" id="inq_to_dys" /><!--  
				--><button type="button" class="calendar ir" name="btns_Calendar2" id="btns_Calendar2"></button></td>
			</tr> 
				<tr>
				<th>Creation Office</th>
                  <td><input type="text" style="width:196px;ime-mode:disabled" dataformat="engup" otherchar="," name="crnt_ofc_cd" value="" id="crnt_ofc_cd" /><!--  
                  --><button type="button" id="ComOpenPopupWithTargetOffice" name="ComOpenPopupWithTargetOffice" class="input_seach_btn"></button></td>
				</tr> 
		</table>
	</div>
</div>
<div class="wrap_result">
	<div class="opus_design_grid" id="mainTable">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>
</form>