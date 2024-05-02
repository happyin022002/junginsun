<%
/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MST_0016.jsp
*@FileTitle  : Own Container Creation (New Van) 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/03
=========================================================
*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.vop.pso.portchargebudget.laneexpenseratiomgt.event.VopPso0006Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopPso0006Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.PortChargeBudget.LaneExpenseRatioMgt");
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		event = (VopPso0006Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
	} catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form">
<input id="f_cmd" name="f_cmd" type="hidden" />
<input id="pagerows" name="pagerows" type="hidden" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title">
		<button type="button"><span id="title"></span></button>
	</h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button>
		<button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button>
	</div>
	<!-- opus_design_btn(E) -->
	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->


<div class="wrap_result">
<!-- layout_wrap (S) -->
	<div class="layout_wrap">
	    <div class="layout_vertical_2" style="width: 25%">
	        <!-- opus_design_grid(S) -->
	         <div class="opus_design_grid">
	            <div class="opus_design_btn">
						<button type="button" class="btn_accent" name="btn_add" id="btn_add">Row Add</button>
						<button type="button" class="btn_normal" name="btn_del" id="btn_del">Row Delete</button>
				</div>
				<script type="text/javascript">ComSheetObject('sheet1');</script>
	        </div>
	    </div>
	    <div class="layout_vertical_2" style="width: 2%">
	       <table>
	       		<tr>
	       			<td>&nbsp;</td>
	       		</tr>
	       </table>
	    </div>
	    <div class="layout_vertical_2" style="width: 73%">
	        <!-- opus_design_grid(S) -->
	         <div class="opus_design_grid">
	            <div class="opus_design_btn">
						<button type="button" class="btn_accent" name="btn_add2" id="btn_add2">Row Add</button>
						<button type="button" class="btn_normal" name="btn_insert2" id="btn_insert2">Row Insert</button>
						<button type="button" class="btn_normal" name="btn_del2" id="btn_del2">Row Delete</button>
				</div>
				<script type="text/javascript">ComSheetObject('sheet2');</script>
	        </div>
	        <!-- opus_design_grid(E) -->
	    </div>
	</div>
</div>
<!-- layout_wrap (E) -->
</form>