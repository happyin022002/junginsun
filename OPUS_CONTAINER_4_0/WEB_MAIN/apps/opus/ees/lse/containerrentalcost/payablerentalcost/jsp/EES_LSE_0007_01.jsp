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

	String func         = "";
	String strUsr_id	= "";
	String strUsr_nm	= "";
	String strVndrSeq   = "";
	String strVndrNm    = "";
	String strCostYrmon	= "";
	String strInvNo     = "";
	String strChgSeq    = "";
	String strAgmtCtyCd = "";
	String strAgmtSeq   = "";
	String strInvYn     = ""; 
	Logger log = Logger.getLogger("com.clt.apps.ContainerRentalCost.PayableRentalCost");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		func         = JSPUtil.getNull(request.getParameter("func"));
		strVndrSeq   = JSPUtil.getNull(request.getParameter("vndr_seq"));
		strVndrNm    = JSPUtil.getNull(request.getParameter("vndr_nm"));
		strCostYrmon = JSPUtil.getNull(request.getParameter("chg_cost_yrmon"));
		strInvNo     = JSPUtil.getNull(request.getParameter("inv_no"));
		strChgSeq    = JSPUtil.getNull(request.getParameter("chg_seq"));
		strAgmtCtyCd = JSPUtil.getNull(request.getParameter("agmt_cty_cd"));
		strAgmtSeq   = JSPUtil.getNull(request.getParameter("agmt_seq"));
		strInvYn     = JSPUtil.getNull(request.getParameter("inv_yn"));
		if ( strInvYn.equals("") ) {
			strInvYn = "N";
		}

		event = (EesLse0007PopEvent)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

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

<input type="hidden" name="backendjob_key" id="backendjob_key" />
<input type="hidden" name="func" value="<%= func %>" id="func" />
<input type="hidden" name="inv_no" value="<%= strInvNo %>" id="inv_no" />
<input type="hidden" name="chg_seq" value="<%= strChgSeq %>" id="chg_seq" />
<input type="hidden" name="agmt_cty_cd" value="<%= strAgmtCtyCd %>" id="agmt_cty_cd" />
<input type="hidden" name="agmt_seq" value="<%= strAgmtSeq %>" id="agmt_seq" />

<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	
		<!-- page_title(S) -->
		<h2 class="page_title"><span>Payable Charge Audit Result & Payable Amount Confirm</span></h2>
		<!-- page_title(E) -->
		
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<% if ( !strInvYn.equals("Y") ) { %>
			 <button type="button" class="btn_accent" name="btn_Reject" 				id="btn_Reject">Reject</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_Confirm" 		id="btn_Confirm">Confirm</button><!-- 		
			 --><% } %><button type="button" class="btn_normal" name="btn_Close" 	id="btn_Close">Close</button>		
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
					<col width="30"/>
					<col width="450"/>
					<col width="50"/>
					<col width="*" />				
				</colgroup> 
				<tbody>
					<tr class="h23">
						<th>Lessor</th>
						<td><input type="text" class="input2" value="<%= strVndrSeq %>" readonly="" style="width:60px;text-align:center;" dataformat="num" /><!-- 
							 --><input type="text" class="input2" value="<%= strVndrNm %>" readonly="" style="width:350px;" />
						</td>
						<th>Cost Month</th>
						<td><input type="text" name="chg_cost_yrmon" class="input2" value="<%= strCostYrmon %>" readonly="" style="width:80px;text-align:center;" dataformat="ym" id="chg_cost_yrmon" /></td>
					</tr>
				</tbody>
			</table>
		</div>
		<!-- opus_design_inquiry(E) -->
	</div>
	
	<div class="wrap_result">
		<!-- opus_tab_btn(S) -->
		<div class="opus_design_tab">
			<script type="text/javascript">ComTabObject('tab1')</script>
		</div>
		<!-- opus_tab_btn(E) -->
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid clear" name="tabLayer" id="tabLayer" style="display:inline;">
			
			<!-- opus_design_btn(S) -->
			
			<div class="opus_design_btn">
			<% if ( !strInvYn.equals("Y") ) { %>
				<button type="button" class="btn_accent" name="btn_t1RowAdd" 			id="btn_t1RowAdd">Row Add</button><!-- 
				 --><button type="button" class="btn_normal" name="btn_t1RowDelete" 	id="btn_t1RowDelete">Row Delete</button><% } %><button type="button" class="btn_normal" name="btn_t1DownExcel" 	id="btn_t1DownExcel">Down Excel</button>		
			</div>		
			<!-- opus_design_btn(E) -->		
			<script type="text/javascript">ComSheetObject('t1sheet1');</script>			
			<!-- opus_design_grid(E) -->
			
			<div class="opus_design_inquiry">
				<table>
					<colgroup>
						<col width="80"/>
						<col width="100"/>				
						<col width="80"/>
						<col width="100"/>
						<col width="80"/>
						<col width="*" />				
					</colgroup> 
					<tbody>
						<tr class="h23">
							<th>Payable AMT</th>
							<td>
								<input type="text" name="t1pAmt" style="width:100px;text-align:right" value="" class="input2" id="t1pAmt" readonly />
							</td>
							<th>AMT</th>
							<td>
								<input type="text" name="t1Amt" style="width:100px;text-align:right" value="" class="input2" id="t1Amt" readonly />
							</td>
							<th>Credit AMT</th>
							<td>
								<input type="text" name="t1cAmt" style="width:100px;text-align:right" value="" class="input2" id="t1cAmt" readonly />
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		<!-- opus_design_grid(E) -->
		
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid clear" name="tabLayer" id="tabLayer" style="display:none;">
			
			<!-- opus_design_btn(S) -->
			<div class="opus_design_btn">
				<% if ( !strInvYn.equals("Y") ) { %>
				<button type="button" class="btn_accent" name="btn_t2Move" 				id="btn_t2Move">Move Coincidence</button><!--				 
				 --><% } %><button type="button" class="btn_normal" name="btn_t2DownExcel" 	id="btn_t2DownExcel">Down Excel</button>		
			</div>
			<!-- opus_design_btn(E) -->		
			<script type="text/javascript">ComSheetObject('t2sheet1');</script>		
			<!-- opus_design_grid(E) -->
			<div class="opus_design_inquiry">
				<table>
					<colgroup>
						<col width="80"/>
						<col width="100"/>				
						<col width="80"/>
						<col width="100"/>
						<col width="80"/>
						<col width="*" />				
					</colgroup> 
					<tbody>
						<tr class="h23">
							<th>Payable AMT</th>
							<td>
								<input type="text" name="t2pAmt" style="width:100px;text-align:right" value="" class="input2" id="t2pAmt" readonly/>
							</td>
							<th>AMT</th>
							<td>
								<input type="text" name="t2Amt" style="width:100px;text-align:right" value="" class="input2" id="t2Amt" readonly/>
							</td>
							<th>Credit AMT</th>
							<td>
								<input type="text" name="t2cAmt" style="width:100px;text-align:right" value="" class="input2" id="t2cAmt" readonly/>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		<!-- opus_design_grid(E) -->
		
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid clear" name="tabLayer" id="tabLayer" style="display:none;">
			
			<!-- opus_design_btn(S) -->
			<div class="opus_design_btn">
				<% if ( !strInvYn.equals("Y") ) { %>
				<button type="button" class="btn_accent" name="btn_t3Move" 					id="btn_t3Move">Move Coincidence</button><!-- 
				 --><% } %><button type="button" class="btn_normal" name="btn_t3DownExcel" 	id="btn_t3DownExcel">Down Excel</button>		
			</div>
			<!-- opus_design_btn(E) -->		
			<script type="text/javascript">ComSheetObject('t3sheet1');</script>		
			<!-- opus_design_grid(E) -->
			<div class="opus_design_inquiry">
				<table>
					<colgroup>
						<col width="80"/>
						<col width="100"/>				
						<col width="80"/>
						<col width="100"/>
						<col width="80"/>
						<col width="*" />				
					</colgroup> 
					<tbody>
						<tr class="h23">
							<th>Payable AMT</th>
							<td>
								<input type="text" name="t3pAmt" style="width:100px;text-align:right" value="" class="input2" id="t3pAmt" readonly/>
							</td>
							<th>AMT</th>
							<td>
								<input type="text" name="t3Amt" style="width:100px;text-align:right" value="" class="input2" id="t3Amt" readonly/>
							</td>
							<th>Credit AMT</th>
							<td>
								<input type="text" name="t3cAmt" style="width:100px;text-align:right" value="" class="input2" id="t3cAmt" readonly/>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		<!-- opus_design_grid(E) -->
		
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid clear" name="tabLayer" id="tabLayer" style="display:none;">
			<!-- opus_design_grid(S) -->
			<div class="opus_design_btn">
				<% if ( !strInvYn.equals("Y") ) { %>
				<button type="button" class="btn_accent" name="btn_t4Move" 					id="btn_t4Move">Move Coincidence</button><!-- 
				 --><% } %><button type="button" class="btn_normal" name="btn_t4DownExcel" 	id="btn_t4DownExcel">Down Excel</button>		
			</div>
			<!-- opus_design_btn(E) -->		
			<script type="text/javascript">ComSheetObject('t4sheet1');</script>	
				
			<div class="opus_design_inquiry">
				<table>
					<colgroup>
						<col width="80"/>
						<col width="100"/>				
						<col width="80"/>
						<col width="100"/>
						<col width="80"/>
						<col width="*" />				
					</colgroup> 
					<tbody>
						<tr>
							<th>Payable AMT</th>
							<td><input type="text" name="t4pAmt" style="width:100px;text-align:right" value="" class="input2" id="t4pAmt" readonly/></td>
							<th>AMT</th>
							<td><input type="text" name="t4Amt" style="width:100px;text-align:right" value="" class="input2" id="t4Amt" readonly/></td>
							<th>Credit AMT</th>
							<td><input type="text" name="t4cAmt" style="width:100px;text-align:right" value="" class="input2" id="t4cAmt" readonly/></td>
						</tr>
					</tbody>
				</table>
				</div>
		</div>
		<!-- opus_design_grid(E) -->
	</div>
</div>
</form>