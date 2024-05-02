<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MNR_0222.jsp
*@FileTitle  : FQA Result Inquiry 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.mnr.generalmanage.fqaresultmgt.event.EesMnr0222Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesMnr0222Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Occurred error from server
	String strErrMsg = "";						//Error message
	int rowCount	 = 0;						//Row count of retrieved database data

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd        = "";
	String rhqOfcCd         = "";
	
	Logger log = Logger.getLogger("com.clt.apps.test.test");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
		rhqOfcCd  = account.getRhq_ofc_cd();
		
		event = (EesMnr0222Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		//Extracting retrieved data from server on load screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<!--Use a common at MNR  -->       
<script type="text/javascript">   
	var currOfcCd = '<%=strOfc_cd %>';
	var rhqOfcCd  = '<%=rhqOfcCd %>';
	
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
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="key_value" id="key_value" />
<input type="hidden" name="ofc_cd" value="<%=strOfc_cd %>" id="ofc_cd" />
<input type="hidden" name="usr" value="<%=strUsr_id %>" id="usr" />
<input type="hidden" name="ar_hd_qtr_cd" id="ar_hd_qtr_cd" />
 
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
		<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!-- 
		--><button type="button" class="btn_normal" name="btn_New"   id="btn_New">New</button>		
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
<!-- opus_design_inquiry(S) -->
<div class="wrap_search">
<div class="opus_design_inquiry wFit">
	<table>
		 <colgroup>
			<col width="80" />
			<col width="120" />
			<col width="100" />
			<col width="100" />
			<col width="100"/>
			<col width="*"/>
		</colgroup> 
		<tbody>
			<tr>				 
				<th>Regional HQ</th>
				<td><script type="text/javascript">ComComboObject('combo1',2, 90 , 0);</script></td>
				<th>Operation Office</th>
				<td><script type="text/javascript">ComComboObject('combo2',2, 80 , 0,'','',0,'');</script></td>
				<th>Service Provider</th>
				<td><input  name="vndr_seq" id="vndr_seq" type="text" style="width:60px;" class="input" maxlength="6" dataformat="num"><button type="button" class="input_seach_btn" name="sProvider" id="sProvider"></button><input name="vndr_lgl_eng_nm" id="vndr_lgl_eng_nm" type="text" style="width:200px;"  class="input2" readOnly="true"></td>
			</tr>
		</tbody>
	</table>
</div>
</div>
<!-- opus_design_inquiry(E) -->
<!-- opus_design_grid(S) -->
<div class="wrap_result">
<div class="opus_design_grid">
	<!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
		<div class="opus_design_btn">
		<button type="button" class="btn_normal" name="btn_Detail"   id="btn_Detail">Detail(s)</button><!-- 
		--><button type="button" class="btn_normal" name="btn_DownExcel"   id="btn_DownExcel">Down Excel</button>
	</div>
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	<!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
</div>
</div>
<!-- opus_design_grid(E) -->
</form>