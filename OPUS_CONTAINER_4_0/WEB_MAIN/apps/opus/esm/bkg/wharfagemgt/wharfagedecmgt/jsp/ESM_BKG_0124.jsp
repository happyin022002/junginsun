<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0124.jsp
*@FileTitle  : Wharfage Cargo Classification-Inquiry Wharfage Rate
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/07
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.event.EsmBkg0124Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0124Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from the server	
	String strErrMsg = "";						//error messege
	int rowCount	 = 0;						//the number of DB ResultSet List

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.wharfagemgt.wharfagedecmgt");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg0124Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// extract additional data obtained from the server during Initial loading ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
	
%>


<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form" method="post">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="frm_attr_ctnt2">


<%
	String vvd       = (request.getParameter("vvd") == null)? "":request.getParameter("vvd");
	String blNo      = (request.getParameter("bl_no") == null)? "":request.getParameter("bl_no");
	String whfBndCd  = (request.getParameter("whf_bnd_cd") == null)? "":request.getParameter("whf_bnd_cd");
%>

<!-- OUTER - POPUP (S)tart -->
<input type="hidden" name="whfBndCd" value="<%=whfBndCd %>">
	<!-- page(S) -->

<!-- popup_title_area(S) -->
 <div class="layer_popup_title">	
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title"><span></span>Wharfage Cargo Classification-Inquiry Wharfage Rate</h2>
		<!-- page_title(E) -->
	   
	    <!-- opus_design_btn(S) -->
	    <div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button>
			<button type="button" class="btn_normal" name="btn_new"   id="btn_new">New</button>
			<button type="button" class="btn_normal" name="btn_close"   id="btn_close">Close</button>
		 </div>
	    <!-- opus_design_btn(E) -->
	    
	</div>
	<!-- page_title_area(E) -->
</div>
			
	<!-- opus_design_inquiry(S) -->
	<div class="layer_popup_contents">
	    <!-- opus_design_inquiry(S) -->
	<div class="wrap_search">
		<div class="opus_design_inquiry">
	    <table>
	         <colgroup>
	            <col width="60px" />
	            <col width="130px" />
	            <col width="50px" />
	            <col width="130px" />
	            <col width="50px" />
	            <col width="130px" />
	            <col width="55px" />	            
	            <col width="" />
	        </colgroup> 
	        <tbody>
				<tr class="h23">
					<th title="Vessel Voyage Direction">VVD</th>
					<td>
						<input type="text" style="width:80px;" class="input1" name="vvd" dataformat="engup" maxlength="9" value="<%=vvd %>" >
					</td>
					<th>B/L No</th>
					<td>
						<input type="text" style="width:90px;" class="input1" name="bl_no" dataformat="engup" maxlength="12" value="<%=blNo %>">
					</td>
					<th>Bound</th>
				    <td>
				    	<select style="width:50px;" class="input1" name="whf_bnd_cd">&nbsp;
							<option value="IN" selected="selected">IN</option>
							<option value="II">II</option>
							<option value="IT">IT</option>
							<option value="OO">OO</option>
							<option value="OT">OT</option>
							<option value="AL">ALL</option>
						</select></td> 
					
					<th>WHF Dec</th>
					<td>
						<input type="text" style="width:80px;" class="input1" name="whf_decl_no" dataformat="engup" maxlength="12">
					</td>
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
		    <script language="javascript">ComSheetObject('sheet1');</script>
		    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
		</div>
	</div>
	<!-- opus_design_grid(E) -->
</div>

</form>