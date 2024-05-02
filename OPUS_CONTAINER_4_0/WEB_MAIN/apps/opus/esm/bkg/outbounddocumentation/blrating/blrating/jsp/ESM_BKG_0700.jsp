<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0700.jsp
*@FileTitle  : CAF Adjustment
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/29
=========================================================*/
%>


<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.event.EsmBkg0700Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmBkg0700Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지
	int rowCount = 0; //DB ResultSet 리스트의 건수
	String successFlag = "";
	String codeList = "";
	String pageRows = "100";
	String strUsr_id = "";
	String strUsr_nm = "";
	Logger log = Logger.getLogger("com.clt.apps.BlRating.BlRating");
	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		event = (EsmBkg0700Event) request.getAttribute("Event");
		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
	} catch (Exception e) {
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
<input id="f_cmd" name="f_cmd" type="hidden" />
<input id="pagerows" name="pagerows" type="hidden" />
<input id="caf_sum" name="caf_sum" type="hidden" />
<!-- 개발자 작업	-->

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title">
		<span>CAF Adjustment</span>
	</h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button type="button" id="btn_calc" name="btn_calc" class="btn_accent">Calc</button><!--
		--><button type="button" id="btn_new" name="btn_new" class="btn_normal">New</button><!--
		--><button type="button" id="btn_apply" name="btn_apply" class="btn_normal">Apply</button><!--
		--><button type="button" id="btn_close" name="btn_close" class="btn_normal">Close</button><!--
		--></div>
	<!-- opus_design_btn (E) -->
</div>
<!-- page_title_area(E) -->

<div class="wrap_result">
	<div class="layout_wrap">
		 <div class="layout_vertical_2" style="width: 32%">
	        <!-- opus_design_grid(S) -->
	        <div class="opus_design_grid">
	        	<div class="opus_design_btn">
	        		<button type="button" class="btn_normal" id="btn_add" name="btn_add">Row Add</button><!--  
	        		--><button type="button" class="btn_normal" id="btn_del" name="btn_del">Row Delete</button>
	        	</div>
	            <script type="text/javascript">ComSheetObject('sheet1');</script>
	        </div>
	        <!-- opus_design_grid(E) -->
	    </div>
	    
	     <div class="layout_vertical_2" style="width: 2%">
	        <table>
	        	<tr>
	        		<td>&nbsp;</td>
	        	</tr>
	        </table>
	    </div>
	    
	    <div class="layout_vertical_2" style="width: 32%">
	        <table class="grid_2">
				<tr>
					<th>CAF Percentage</th>
				</tr>
				<tr>
					<td><input id="caf_percentage" style="width: 272px;%; text-align: right" class="noinput" name="caf_percentage" dataformat="float" maxlength="5" value="" type="text" /> </td>
				</tr>
			</table>
	    </div>	
	    
	    <div class="layout_vertical_2" style="width: 2%">
	        <table>
	        	<tr>
	        		<td>&nbsp;</td>
	        	</tr>
	        </table>
	    </div>
	    
	    <div class="layout_vertical_2" style="width: 32%">
	       <table class="grid_2">
				<tr>
					<th colspan="2">CAF Amount</th>
				</tr>
				<tr>
					<td>
						<input type="text" style="width: 100%; text-align: center" class="noinput2" name="caf_currency" id="caf_currency" value='' readonly>
					</td>
					<td>
						<input type="text" style="width: 100%; text-align: center" class="noinput2" name="caf_amount" id="caf_amount" value='' readonly>
					</td>
				</tr>
			</table>
	    </div>		
	</div>
</div>
<!-- : ( Button : pop ) (E) --> <!-- 개발자 작업  끝 -->
</form>