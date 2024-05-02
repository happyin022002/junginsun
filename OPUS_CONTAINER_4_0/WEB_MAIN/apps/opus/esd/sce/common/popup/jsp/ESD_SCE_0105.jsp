<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_SCE_0105.js
*@FileTitle  : Notified Subscriber - Search Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/31
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.sce.common.popup.event.CommonPopUpManageEvent"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	CommonPopUpManageEvent  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message

	Logger log = Logger.getLogger("com.clt.apps.common.popup");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		event = (CommonPopUpManageEvent)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}


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

<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="cur_page" value="1" id="cur_page" />
<input type="hidden" name="row_size" value="1000" id="row_size" />
<!-- page_title_area(S) -->

	<div class="page_title_area clear">
	   <!-- page_title(S) -->
		<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title"><span>S/C No. Inquiry</span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn"><!-- 
			 --><button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_new"  	id="btn_new">New</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_ok" 	id="btn_ok">OK</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_close" 	id="btn_close">Close</button>
		</div>
		<!-- opus_design_btn(E) -->
	</div>

<!-- page_title_area(E) -->

	<div class="wrap_search">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry">
			<table>
				<colgroup>
					<col width="90">
					<col width="*">
				</colgroup>
				<tbody>
					<tr>
						<th>Customer Code</th>
		                <td><input name="cust_cnt_seq" type="text" dataformat="enguponly" value="" id="cust_cnt_seq" /><button type="button" name="btns_search1" id="btns_search1" class="input_seach_btn" onClick="openCustPop(true,'cust_cnt_seq','cust_nm')"></button></td>
					</tr>
		          	<tr>
		                <th>Customer Name</th>
		                <td><input name="cust_nm" type="text" style="width:320px;" value="" readonly id="cust_nm" /></td>
		              </tr>
				</tbody>
			</table>
		</div>
		<!-- opus_design_inquiry(E) -->
	</div>
	
	<div class="wrap_result">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid" id="mainTable">
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
		<!-- opus_design_grid(S) -->
	</div>


</form>


<%@include file="/bizcommon/include/common_opus.jsp"%>