<%--
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_DMT_2105.jsp
*@FileTitle  : DAR History
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/30
=========================================================*/
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.event.EesDmt2105Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesDmt2105Event  event 		= null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			    //error from server
	String strErrMsg 			= "";			    //error message
	int rowCount	 			= 0;				//count of DB ResultSet list

	String successFlag 			= "";
	String codeList  			= "";
	String pageRows  			= "100";

	String strUsr_id			= "";
	String strUsr_nm			= "";
	String strUsr_ofc			= "";
	Logger log 					= Logger.getLogger("com.clt.apps.opus.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt");

	String rFANo 				= request.getParameter("rfa_no") 	!= null ? request.getParameter("rfa_no") 	: "" ;
	String propNo 				= request.getParameter("prop_no") 	!= null ? request.getParameter("prop_no") 	: "" ;
	String darNo 				= request.getParameter("dar_no") 	!= null ? request.getParameter("dar_no") 	: "" ;
	String verSeq 				= request.getParameter("ver_seq") 	!= null ? request.getParameter("ver_seq") 	: "" ;
	String custCd 				= request.getParameter("cust_cd") 	!= null ? request.getParameter("cust_cd") 	: "" ;
	String custNm 				= request.getParameter("cust_nm") 	!= null ? request.getParameter("cust_nm") 	: "" ;
	String status 				= request.getParameter("status") 	!= null ? request.getParameter("status") 	: "" ;
	String rowcount 			= request.getParameter("rowcount") 	!= null ? request.getParameter("rowcount") 	: "" ;
	String isCopy				= request.getParameter("is_copy") 	!= null ? request.getParameter("is_copy") 	: "" ;

	try {
	   	SignOnUserAccount account = (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id 				= account.getUsr_id();
		strUsr_nm 				= account.getUsr_nm();
		strUsr_ofc 				= account.getOfc_cd();

		event 					= (EesDmt2105Event)request.getAttribute("Event");
		serverException 		= (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// in loading page, Get data from server.
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
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
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="cust_cd" id="cust_cd" />
<input type="hidden" name="rfa_no" id="rfa_no" />
<input type="hidden" name="prop_no" value="<%= propNo %>" id="prop_no" />
<input type="hidden" name="dar_no" value="<%= darNo %>" id="dar_no" />
<input type="hidden" name="ver_seq" value="<%= verSeq %>" id="ver_seq" />
<input type="hidden" name="status" value="<%= status %>" id="status" />
<input type="hidden" name="rowcount" value="<%= rowcount %>" id="rowcount" />
<input type="hidden" name="is_copy" value="<%= isCopy %>" id="is_copy" />


<!-- popup_title_area(S) -->

	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title"><span>DAR History</span></h2>
		<!-- page_title(E) -->

		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_Copy" id="btn_Copy">Copy</button><!--
			--><button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button>
		</div>
		<!-- opus_design_btn(E) -->	
	</div>
	<!-- page_title_area(E) -->

<!-- popup_title_area(E) -->



<!-- popup_contens_area(S) -->
	<!-- inquiry_area(S) -->
	<div class="wrap_search">
	<div class="opus_design_inquiry wFit">  <!-- no TAB  -->
		<table> 
			<colgroup>
				<col width="200" />
				<col width="50" />
				<col width="100" />
				<col width="50" />
				<col width="380" />
				<col width="*" />
			</colgroup>
			<tbody>
				<tr>
					
					<td class="sm" style="padding-left:8px">
						<b>DAR History</b>  <input type="radio" name="searchType" class="trans" checked onclick="doActionRetrieve()" id="searchType" /> RFA   <input type="radio" name="searchType" class="trans" onclick="doActionRetrieve()" id="searchType" /> Customer &nbsp;
					</td>
					<th class="pad_left_12">RFA No.</th>
					<td><input type="text" name="rFANo" style="width:85px;" class="input2" value="<%= rFANo %>" id="rFANo" /></td>
					<th>Customer</th>
					<td><input type="text" name="custCd" style="width:70px;" class="input2" value="<%= custCd %>" id="custCd" /><input type="text" name="custNm" style="width:290px;" class="input2" value="<%= custNm %>" id="custNm" /> </td>
					<td></td>
				</tr>
			</tbody>
		</table>
	</div>
	</div>
	<!-- inquiry_area(E) -->

	<div class="wrap_result">	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" >
		<!-- opus_grid_design_btn(S) -->

		<script type="text/javascript">ComSheetObject('sheet1');</script>

		<!-- opus_grid_design_btn(E) -->
	</div>
	<!-- opus_design_grid(E) -->
	</div>
<!-- popup_contens_area(E) -->

</form>