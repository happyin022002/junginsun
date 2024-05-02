<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : STM_SAP_0063.jsp
*@FileTitle  : Bank Account Information Popup
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/04
=========================================================
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.event.StmSap0063Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.component.util.StringUtil" %>

<%
    StmSap0063Event event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	
	String strUsr_id = "";
	String strUsr_nm = "";
	Logger log = Logger.getLogger("com.clt.apps.opus.stm.sap.accountpayablecommon.AccountPayableCommonSC");
	
	String bank_acct_nm = StringUtil.xssFilter(request.getParameter("bank_acct_nm")) != null ? StringUtil.xssFilter(request.getParameter("bank_acct_nm")) : "";
	String bank_acct_no = StringUtil.xssFilter(request.getParameter("bank_acct_no")) != null ? StringUtil.xssFilter(request.getParameter("bank_acct_no")) : "";
	String ofc_cd = StringUtil.xssFilter(request.getParameter("ofc_cd")) != null ? StringUtil.xssFilter(request.getParameter("ofc_cd")) : "";
	String bank_acct_tp_nm = StringUtil.xssFilter(request.getParameter("bank_acct_tp_nm")) != null ? StringUtil.xssFilter(request.getParameter("bank_acct_tp_nm")) : "";
	String acct_tp_cd = StringUtil.xssFilter(request.getParameter("acct_tp_cd")) != null ? StringUtil.xssFilter(request.getParameter("acct_tp_cd")) : "";
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
		event = (StmSap0063Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
				
	} catch(Exception ex) {
		log.error("err " + ex.toString(), ex);
		//out.println(e.toString());
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
<input type="hidden" name="ofc_cd" value="<%=ofc_cd%>" id="ofc_cd" />
<input type="hidden" name="bank_acct_tp_nm" value="<%=bank_acct_tp_nm%>" id="bank_acct_tp_nm" />
<input type="hidden" name="acct_tp_cd" value="<%=acct_tp_cd%>">

<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear ">
	    <!-- page_title(S) -->
	    <h2 class="page_title"><span>Bank Account Information</span></h2>
	    <!-- page_title(E) -->
	    <!-- opus_design_btn(S) -->
	    <div class="opus_design_btn">
	        <!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
	        <button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!-- 
	         --><button type="button" class="btn_normal" name="btn_ok"   id="btn_ok">OK</button><!-- 
	         --><button type="button" class="btn_normal" name="btn_close"   id="btn_close">Close</button>
	    </div>
	    <!-- opus_design_btn(E) -->
	</div>
	<!-- page_title_area(E) -->
</div>

<div class="layer_popup_contents">
	<!-- opus_design_grid(S) -->
	<div class="wrap_search">
	    <!-- wrap_search(S) -->
	    <div class="opus_design_inquiry wFit">
	        <!-- 조회영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
	        <table>
	             <colgroup>
	                <col width="80"  />
	                <col width="100" />
	                <col width="180" />
	                <col width="*" />
	            </colgroup>
	            <tbody>
	                  <tr>
	                      <th>Bank Account Name</th>
	                      <td><input type="text" name="bank_acct_nm" style="width:150px;" class="input" value="<%=bank_acct_nm%>" id="bank_acct_nm" /> </td>
	                      <th>Bank Account Number</th>
	                      <td><input type="text" name="bank_acct_no" style="width:150px;" class="input" value="<%=bank_acct_no%>" id="bank_acct_no" /> </td>
	                  </tr>
	               </tbody>
	           	</table>
	     </div>
	     <!-- wrap_search(E) -->
	</div>
	<!-- wrap_result(S) -->
	<div class="wrap_result">
	    <!-- opus_design_grid(S) -->
	    <div class="opus_design_grid">
	        <script type="text/javascript">ComSheetObject('sheet1');</script>
	    </div>
	    <!-- opus_design_grid(E) -->
	</div>
	<!-- wrap_result(E) -->
	<!-- opus_design_grid(E) -->
</div>

</form>         	
<%@ include file="/bizcommon/include/common_opus.jsp"%>
