<%--
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_DMT_2103.jsp
*@FileTitle  : S/C Exception Tariff History 
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
<%@ page import="com.clt.apps.opus.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.event.EesDmt2103Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesDmt2103Event  event 		= null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			    //error from server
	String strErrMsg 			= "";				//error message
	int rowCount	 			= 0;				//count of DB ResultSet list

	String successFlag 			= "";
	String codeList  			= "";
	String pageRows  			= "100";

	String strUsr_id			= "";
	String strUsr_nm			= "";
	String strUsr_ofc			= "";
	Logger log 					= Logger.getLogger("com.clt.apps.opus.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt");

	String sCNo 				= request.getParameter("sc_no") 	!= null ? request.getParameter("sc_no") 	: "" ;
	String propNo 				= request.getParameter("prop_no") 	!= null ? request.getParameter("prop_no") 	: "" ;
	String verSeq				= request.getParameter("ver_seq") 	!= null ? request.getParameter("ver_seq") 	: "" ;
	String custCd 				= request.getParameter("cust_cd") 	!= null ? request.getParameter("cust_cd") 	: "" ;
	String custNm 				= request.getParameter("cust_nm") 	!= null ? request.getParameter("cust_nm") 	: "" ;
	String status 				= request.getParameter("status") 	!= null ? request.getParameter("status") 	: "" ;
	String rowcount 			= request.getParameter("rowcount") 	!= null ? request.getParameter("rowcount") 	: "" ;
	String isCopy				= request.getParameter("is_copy") 	!= null ? request.getParameter("is_copy") 	: "" ;

	try {
	   	SignOnUserAccount account = (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);

		strUsr_id 			= account.getUsr_id();
		strUsr_nm 			= account.getUsr_nm();
		strUsr_ofc 			= account.getOfc_cd();

		event 				= (EesDmt2103Event)request.getAttribute("Event");
		serverException 	= (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

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
<input type="hidden" name="sc_no" id="sc_no" />
<input type="hidden" name="prop_no" value="<%= propNo %>" id="prop_no" />
<input type="hidden" name="ver_seq" value="<%= verSeq %>" id="ver_seq" />
<input type="hidden" name="status" value="<%= status %>" id="status" />
<input type="hidden" name="rowcount" value="<%= rowcount %>" id="rowcount" />
<input type="hidden" name="is_copy" value="<%= isCopy %>" id="is_copy" />
<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title"><span>S/C Exception Tariff History</span></h2>
		<!-- page_title(E) -->

		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_Copy" id="btn_Copy">Copy</button><!--
			--><button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button>
		</div>
		<!-- opus_design_btn(E) -->	
	</div>
	<!-- page_title_area(E) -->
	<!-- inquiry_area(S) -->
	<div class="wrap_search">
		<div class="opus_design_inquiry wFit">  <!-- no TAB  -->
			<table> 
				<colgroup>
					<col width="200" />
					<col width="80" />
					<col width="110" />
					<col width="50" />
					<col width="*" />
				</colgroup>
				<tbody>
					<tr>
						<td class="sm" style="padding-left:8px">
							<b>S/C Exception History</b>  <input name="searchType" type="radio" class="trans" checked onclick="doActionRetrieve()" id="searchType" /><label for="searchType"> S/C  </label><input name="searchType" type="radio" class="trans" onclick="doActionRetrieve()" id="searchType" /> <label for="searchType">Customer</label>
						</td>
						<th class="pad_left_12">S/C No.</th>
						<td><input type="text" name="sCNo" style="width:80px;" class="input2" value="<%= sCNo %>" id="sCNo" /> </td>
						<th>Customer</th>
						<td><input type="text" name="custCd" style="width:80px;" class="input2" value="<%= custCd %>" id="custCd" /><!-- 
						--><input type="text" name="custNm" style="width:200px;" class="input2" value="<%= custNm %>" id="custNm" /> </td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	<!-- inquiry_area(E) -->
	<div class="wrap_result">	
	<!-- opus_design_grid(S) -->
		<div class="opus_design_grid" id="mainTable" >
			<!-- opus_grid_design_btn(S) -->
	
			<script type="text/javascript">ComSheetObject('sheet1');</script>
	
			<!-- opus_grid_design_btn(E) -->
		</div>
	<!-- opus_design_grid(E) -->
	</div>			
</form>