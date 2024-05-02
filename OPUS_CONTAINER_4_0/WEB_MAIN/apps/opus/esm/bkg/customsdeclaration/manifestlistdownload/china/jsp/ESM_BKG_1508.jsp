<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1508.jsp
*@FileTitle  : JMS Report
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/12
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.china.event.EsmBkg1508Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg1508Event event = null;		//PDTO(Data Transfer Object including Parameters)
	Exception serverException = null;	//서버에서 발생한 에러
	String strErrMsg = "";				//에러메세지
	int rowCount = 0;					//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList	= "";
	String pageRows	= "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	Logger log = Logger.getLogger("com.clt.apps.esm.bkg.CustomsDeclaration");

	try {
		SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		event = (EsmBkg1508Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	} catch(Exception e) {
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

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<!-- 개발자 작업 -->

<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn"><!--
		 --><button type="button" class="btn_normal" name="btn_new"  	id="btn_new">New</button><!--  
		 --><button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_save" 	id="btn_save">Save</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_down_excel" 	id="btn_down_excel">Down Excel</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_upload_excel" 	id="btn_upload_excel">Upload Excel</button>
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
	<div class="opus_design_inquiry">
		<table>
			<tbody>
				<tr>
					<td class="sm"><input type="radio" name="search_div" value="PORT" class="trans" checked id="search_div" /><label for="search_div">Port SKD</label><!-- 
					 --><input type="radio" name="search_div" value="PUBLIC" class="trans" id="search_div_1" /><label for="search_div_1">Public SKD</label></td>
					<td>PORT <input type="text" name="port_cd" maxlength="5" style="ime-mode:disabled; width:60px;" class="input1" required caption="PORT" fullfill="" dataformat="engup" id="port_cd" /></td>
					<td><input type="radio" name="date_vvd_div" value="DATE" class="trans" checked id="date_vvd_div" /><label for="date_vvd_div">ETB</label><!-- 
					 --><input type="text" name="date_fm" maxlength="10" style="ime-mode:disabled; width:75px;" class="input1" required="" caption="From Date" cofield="date_to" dataformat="ymd" id="date_fm" /><!-- 
					 --><input type="text" name="date_to" maxlength="10" style="ime-mode:disabled; width:75px;" class="input1" required="" caption="To Date" cofield="date_fm" dataformat="ymd" id="date_to" /><!-- 
					 --><button type="button" id="btn_calendar" name="btn_calendar" class="calendar ir"></button><!-- 
					 --><input type="radio" name="date_vvd_div" value="VVD" class="trans" id="date_vvd_div" /><!-- 
					 --><input type="text" name="vvd" maxlength="9" style="ime-mode:disabled; width:90px;" class="input" dataformat="engup" id="vvd" /></td>
					<td>Lane <input type="text" name="slan_cd" maxlength="9" style="ime-mode:disabled; width:40px;" class="input" dataformat="engup" id="slan_cd" /></td>
					<td>OPR <input type="text" name="crr_cd" maxlength="9" style="ime-mode:disabled; width:40px;" class="input" dataformat="engup" id="crr_cd" /></td>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn" id="mainTable"><!--
			 --><button type="button" class="btn_normal" name="btn2_selectall"  	id="btn2_selectall">Select All</button><!--  
			 --><button type="button" class="btn_accent" name="btn2_rowadd" id="btn2_rowadd">Row Add</button><!-- 
			 --><button type="button" class="btn_normal" name="btn2_delete" 	id="btn2_delete">Row Delete</button>
		</div>
		<!-- opus_design_btn(E) -->
		<script type="text/javascript">ComSheetObject('sheet1');</script>
		<script type="text/javascript">ComSheetObject('sheet2');</script>
	</div>
	<!-- opus_design_grid(S) -->
</div>
<!-- 개발자 작업 끝 -->
</form>