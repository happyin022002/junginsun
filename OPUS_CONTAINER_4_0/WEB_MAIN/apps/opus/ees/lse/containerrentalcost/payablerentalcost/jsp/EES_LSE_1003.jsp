<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_LSE_0007_01.jsp
*@FileTitle  : Container Rental Charge Creation Audit & Result
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
<%@ page import="com.clt.apps.opus.ees.lse.containerrentalcost.payablerentalcost.event.EesLse0007PopEvent"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesLse0007PopEvent  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String sType         = "";
	String strUsr_id	= "";
	String strUsr_nm	= "";
	
	Logger log = Logger.getLogger("com.clt.apps.ContainerRentalCost.PayableRentalCost");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		sType         = JSPUtil.getNull(request.getParameter("sType"));
		

		//getting data from server when load the initial screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

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

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />

<input type="hidden" name="sType" value="<%= sType %>" id="sType" />

<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	
		<!-- page_title(S) -->
		<h2 class="page_title"><span>Tax Input (
		<% if("vaTax".equals(sType) || "vaTaxOperation".equals(sType)) {%>
		V.A.Tax
		<% }else{ %>
		W.H.Tax
		<% } %>
		)
		</span></h2>
		<!-- page_title(E) -->
		
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			 <button type="button" class="btn_accent" name="btn_Apply" 				id="btn_Apply">Apply</button><!-- 	
			 --><button type="button" class="btn_normal" name="btn_Close" 	id="btn_Close">Close</button>		
		</div>
		<!-- opus_design_btn(E) -->
	
	</div>
	<!-- page_title_area(E) -->
</div>


<div class="layer_popup_contents">
	<div class="wrap_search">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit">
			<table>
				<colgroup>				
					<col width="450"/>
					<col width="50"/>
					<col width="*" />				
				</colgroup> 
				<tbody>
					<tr align="right">
						<th align="center">Tax</th>
						<td>
						<input type="text" class="input1" value="0.00" style="width:60px;text-align:right;" id="dft_tax" name="dft_tax" dataformat="float" pointcount="2"  />%
						<button type="button" style="height:25px;width:80px;text-align:center;background-color: #27415d;color:#ffffff"  name="btn_tax" id="btn_tax">Calculate</button>
						</td>
						
					</tr>
				</tbody>
			</table>
		</div>
		<!-- opus_design_inquiry(E) -->
	</div>
	
	
		<!-- opus_design_grid(E) -->
	<div class="wrap_result">
	    <div class="opus_design_grid">
	        <script type="text/javascript">ComSheetObject('sheet1');</script>
	    </div>
	    <span>
			<table align="right">
					<tr>
						<td width="320px"></td>
						<th align="right" width="70px">Total</th>
						<td align="right"><input type="text" class="input2" value="0" style="width:120px;text-align:right;" id="total_amount" name="total_amount" dataformat="float" /></td>
						<td align="right"><input type="text" class="input2" value="0" style="width:120px;text-align:right;" id="total_tax" name="total_tax" dataformat="float" />
					</tr>
			</table>
		</span>
	</div>
</div>
</form>