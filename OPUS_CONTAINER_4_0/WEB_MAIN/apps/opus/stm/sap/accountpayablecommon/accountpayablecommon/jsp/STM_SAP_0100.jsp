<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : STM_SAP_0100.jsp
*@FileTitle  : Bank Account Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/08
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.event.StmSap0100Event"%>
<%@ page import="org.apache.log4j.Logger"%>
<%@ page import="com.clt.bizcommon.util.BizComUtil"%>
<%@ page import="com.clt.framework.component.util.StringUtil" %>

<%
    StmSap0100Event event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException = null;			//서버에서 발생한 에러
	String strErrMsg    = "";   				//에러메세지
	int rowCount	    = 0;					//DB ResultSet Count of list

	String strUsr_id    = "";
	String strUsr_nm    = "";
	String strUsr_ofc   = "";

	Logger log = Logger.getLogger("com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_ofc = account.getOfc_cd();

		event = (StmSap0100Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// in loading page, Get data from server
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	} catch(Exception e) {
		out.println(e.toString());
	}
	// popOfcCd
	String popOfcCd = (StringUtil.xssFilter(request.getParameter("ofc_cd")).equals(""))? "" : StringUtil.xssFilter(request.getParameter("ofc_cd"));
	// pop_mode
	String popMode  = (StringUtil.xssFilter(request.getParameter("pop_mode")).equals(""))? "N" : "Y";

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
<input type="hidden" name="popOfcCd" value="<%=popOfcCd%>" id="popOfcCd" />
	<% if (popMode.equals("Y")) { %>
	<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	   <!-- page_title(S) -->
		<h2 class="page_title"><span>Bank Account Inquiry</span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_retrieve" 	id="btn_retrieve">Retrieve</button><!--
			--><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!--
			--><button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button><!--
			--><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button><!--
		--></div>
		<!-- opus_design_btn(E) -->
		<div class="location">
			<span id="navigation"></span>
		</div>
		<!-- page_location(E) -->
	</div>
	<!-- page_title_area(E) -->
	</div>
	<% } else { %>
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	   <!-- page_title(S) -->
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_retrieve" 	id="btn_retrieve">Retrieve</button><!--
			--><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!--
			--><button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button><!--
		--></div>
		<!-- opus_design_btn(E) -->
		<!-- page_location(S) -->
		<div class="location">
			<span id="navigation"></span>
		</div>
		<!-- page_location(E) -->
	</div>
	<!-- page_title_area(E) -->
		<% } %>	
<% if (popMode.equals("Y")) { %>
	<!--  <div class="layer_popup_contents"> -->
<%} %>
	<div class= "wrap_search">
		<div class= "opus_design_inquiry wFit">
			<table>
				<colgroup>
					<col width="150" />
					<col width="150" />
					<col width="90" />
					<col width="190" />
					<col width="130" />
					<col width="*" />
				</colgroup>
				<tbody>
					<tr>
                        <th>Open Office</th>
                        <td><input type="text" style="width:80px;" class="input1" name="ofc_cd" dataformat="engup" maxlength="6" id="ofc_cd" /><button type="button" id="btns_search_ofc" name="btns_search_ofc" class="input_seach_btn"></button></td>
                        <th>Bank Name</th>
                        <td><input type="text" style="width:160px;" class="input" name="bank_nm" maxlength="50" id="bank_nm" /><button type="button" id="btns_search_bank" name="btns_search_bank" class="input_seach_btn"></button></td>
                        <th>Account Type(L)</th>
                        <td><script type="text/javascript">ComComboObject('bank_acct_tp', 2, 50, 0, 0, 0, false, 1);</script><!-- 
                            --><input type="text" style="width:100px;" class="input2" name="bank_acct_tp_desc" readonly id="bank_acct_tp_desc" /></td>
                    </tr>
                    <tr>
                        <th>Account Control Office</th>
                        <td><input type="text" style="width:80px;" class="input" name="ctrl_ofc_cd" dataformat="engup" maxlength="6" id="ctrl_ofc_cd" /><button type="button" id="btns_search_ctrl_ofc" name="btns_search_ctrl_ofc" class="input_seach_btn"></button></td>
                        <th class="sm">In/Active On</th>
                        <td class="sm">
	                        <input type="radio" name="inact_flag" value="A" class="trans" id="inact_flag1" /><label for="inact_flag1">Active</label><!-- 
				             --><input type="radio" name="inact_flag" value="O" class="trans" id="inact_flag2" /><label for="inact_flag2">Inactive</label><!-- 
				             --><input type="radio" name="inact_flag" value="L" class="trans" checked id="inact_flag3" /><label for="inact_flag3">All</label>
			            </td>
                   		<th  colspan="2"></th>
                   	</tr>
				</tbody>
			</table>
		</div>
	</div>		
	<!-- opus_design_grid(S) -->	
	
	<% if (popMode.equals("Y")) { %>
	<div height="470" style="padding:12px">
	<% } else { %>
	<div class="wrap_result" >
	<% } %>	
		<div class="opus_design_grid clear" id="mainTable" >
				<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
	</div>
	<!-- opus_design_grid(E) -->
<% if (popMode.equals("Y")) { %>
	<!--  </div>-->
<%} %>	
</form>

<%@ include file="/bizcommon/include/common_opus.jsp"%>