<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_ACM_0003.jsp
*@FileTitle  : Charge Deduction User Setting
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/19
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.acm.acmsetup.acmsetup.event.EsmAcm0003Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
  EsmAcm0003Event event = null;        //PDTO(Data Transfer Object including Parameters)
  Exception serverException = null;    //서버에서 발생한 에러
  String strErrMsg = "";               //에러메세지
  int rowCount = 0;                    //DB ResultSet 리스트의 건수

  String successFlag = "";
  String codeList  = "";
  String pageRows  = "100";

  String strUsr_id = "";
  String strUsr_nm = "";
  Logger log = Logger.getLogger("com.clt.apps.ACMSetup.ACMSetup");

  try {
    SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
    strUsr_id = account.getUsr_id();
    strUsr_nm = account.getUsr_nm();
    event = (EsmAcm0003Event)request.getAttribute("Event");
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

<head>
<title>Charge Deduction User Setting</title>


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

<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_normal" name="btn_save" id="btn_save" type="button">Save</button><!--
		--></div>
	<!-- opus_design_btn (E) -->

	<!-- page_location(S) -->
	<div class="location">	
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->


<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid ">
		<!-- opus_design_btn (S) -->
		<h3 class="title_design">User Set List</h3>
		<div class="opus_design_btn">
			<button class="btn_accent" name="btn_add" id="btn_add" type="button">Row Add</button><!--
			--><button class="btn_normal" name="btn_delete" id="btn_delete" type="button">Delete</button><!--
			--></div>
		<!-- opus_design_btn (E) -->
		<script type="text/javascript">ComSheetObject('sheet1');</script>		
	</div>
	<!-- opus_design_grid(E) -->
	
	<h3 class="title_design">Charge Code Selection</h3>

	<!-- layout_wrap(S) -->
	<div class="layout_wrap ">
	    <div class="layout_vertical_2 pad_rgt_12">
	        <!-- opus_design_grid(S) -->
	        <div class="opus_design_grid">
		        <h3 class="mar_btm_8">Selected Rep.Charge</h3>
				<table>
					<tbody>
						<tr>
		                	<td><textarea name="slct_rep_chg" id="slct_rep_chg" style="width:100%; height:34px" class="input2" readonly></textarea></td>
		              	</tr>
					</tbody>
				</table>
				<h3 class="mar_btm_8">Rep.Charge</h3>
	            <script type="text/javascript">ComSheetObject('sheet2');</script>
	        </div>
	        <!-- opus_design_grid(E) -->
	    </div>
	    <div class="layout_vertical_2 pad_left_12">
	        <!-- opus_design_grid(S) -->
	        <div class="opus_design_grid">
	        	<h3 class="mar_btm_8">Selected Charge Code</h3>
				<table>
					<tbody>
						<tr>
		                	<td><textarea name="slct_charge" id="slct_charge" style="width:100%; height:34px" class="input2" readonly></textarea></td>
		              	</tr>
					</tbody>
				</table>
				<h3 class="mar_btm_8">Charge Code</h3>
	            <script type="text/javascript">ComSheetObject('sheet3');</script>
	        </div>
	        <!-- opus_design_grid(E) -->
	    </div>
	</div>
	<!-- layout_wrap(E) -->
	<h3>※ Charge   under the selected Rep. Charge will not be displayed on [User Set List].</h3>
</div>

</form>