<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_SAM_0005.jsp
*@FileTitle  : Sales Rep List
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/22
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
<%@ page import="com.clt.apps.opus.esm.sam.generalinfomanage.salesrepinfomanage.event.EsmSam0005Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmSam0005Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag      = "";
	String codeList         = "";
	String pageRows         = "100";
	String strOfc_cd		= "";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String opn				= "";
	String reqOfcCd         = "";
	Logger log = Logger.getLogger("com.clt.apps.GeneralInfoManage.SalesRepInfoManage");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
		opn = request.getParameter("opn");

		reqOfcCd = request.getParameter("ofc_cd")==null?"":request.getParameter("ofc_cd");

		strOfc_cd = "".equals(reqOfcCd)?strOfc_cd:reqOfcCd;	//부모창에서 sales office를 가져온 경우, sales office로 셋팅, 아니면 login office로 셋팅

		event = (EsmSam0005Event)request.getAttribute("Event");
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

<head>
<title>Sales Rep List</title>


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
<input type="hidden" name="open_page" value="<%=StringUtil.xssFilter(opn)%>" id="open_page" />

<% if("2".equals(opn)){%>
<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>Sales Rep List</span></h2>
		
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
			--><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!--
			--><button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button>
		</div>
	</div>
</div>
<%}else{%>
<div class="page_title_area clear">
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_retrieve" id="btn_retrieve" type="button">Retrieve</button><!--
		--><button class="btn_normal" name="btn_new" id="btn_new" type="button">New</button>
	</div>

	<div class="location">	
		<span id="navigation"></span>
	</div>
</div>
<%}%>
<% if("2".equals(opn)){%><div class="layer_popup_contents"><%}%>
<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="40" />				
				<col width="120" />				
				<col width="100" />				
				<col width="140" />				
				<col width="80" />				
				<col width="*" />				
		   </colgroup> 
		   <tbody>
		   		<tr>
		   			<th>Office</th>
					<%	if("2".equals(opn)){ %>
					<td><input type="text" name="cust_office" style="width:80px;text-align:center;ime-mode:disabled" onkeyup="javascript:searchOfficeCodeName(this);" class="input1" value="<%=strOfc_cd%>" dataformat="engup" maxlength="6" id="cust_office" /><button type="button" id="btn_office_code" name="btn_office_code" class="input_seach_btn"></button></td>
					<%} else{ %>
					<td><input type="text" name="cust_office" style="width:80px;text-align:center;ime-mode:disabled" onkeyup="javascript:searchOfficeCodeName(this);" class="input1" value="<%=strOfc_cd%>" dataformat="engup" maxlength="6" id="cust_office" /><button type="button" id="btn_office_code" name="btn_office_code" class="input_seach_btn"></button></td>
					<%} %>			  
			  		<th>Customer Code</th>
					<td><input type="text" name="cust_cd" id="cust_cd" style="width:80;text-align:center;ime-mode:disabled" onkeyup="javascript:searchOfficeCodeName(this);" class="input" value="" dataformat="engup" maxLength="8"><button type="button" id="btn_cust_cd" name="btn_cust_cd" class="input_seach_btn"></button></td>
					<th>Delete Flag</th>
					<td><script type="text/javascript">ComComboObject("cust_status", 1, 50, 1, 0, 0, false); </script></td>	
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
<% if("2".equals(opn)){%></div><%}%>
</form>