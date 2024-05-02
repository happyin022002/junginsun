<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TES_0026.jsp
*@FileTitle  : Terminal invoice CSR Creation - Detail
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/18
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.event.EsdTes0024Event"%>
<%
//	ESD_TES_024Event  event = null;					//PDTO(Data Transfer Object including Parameters)
//	ESD_TES_024EventResponse eventResponse = null;	//RDTO(Data Transfer Object including DB ResultSet)
	Exception serverException   = null;				//Server Exception
	DBRowSet rowSet	  	= null;						//DB ResultSet
	String strErrMsg 	= "";						//Error Message
	int rowCount	 	= 0;						//DB ResultSet Count
	String userId  		= "";
	//String ofc_cd  = "";
	String usr_eml 		= "";
	String usr_nm  		= "";
	String cnt_cd  		= "";

	String csr_no 		= "";
	csr_no 				= JSPUtil.getParameter(request, "csr_no".trim(), "");

	try {

	   SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   userId=account.getUsr_id();
	   //userAuth=account.getAuth();
	   //ofc_cd=account.getOfc_cd();
	   usr_nm	= account.getUsr_nm();
	   usr_eml	= account.getUsr_eml();
	   cnt_cd 	= account.getCnt_cd();

	   // ofc_cd  = "CHIBB";

//		event = (ESD_TES_024Event)request.getAttribute("Event");

		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}else{

		} // end else
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
	var cnt_cd = "<%=cnt_cd%>";


</script>
<form  name="form" >
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="iPage" id="iPage" />

<!-- layer_popup_contents(S) -->
<div class="layer_popup_contents">
    <!-- wrap_search(S) -->
    <div class="wrap_search">
        <!-- opus_design_inquiry(S) -->
        <div class="opus_design_inquiry wFit">
				<table> 
		            <colgroup>
		                <col width="100">
		                <col width="100">
		                <col width="100">
		                <col width="100">
		                <col width="120">
		                <col width="*">
		            </colgroup>
		            <tbody>
		             <tr>
							<th>Cost Office</th>
							<td><input name="cost_ofc_cd" type="text" style="width:60px;" value="" readonly id="cost_ofc_cd" /></td>
							<th>Confirmed Date</th>
							<td><input name="inv_cfm_dt" type="text" style="width:75px;" value="" readonly id="inv_cfm_dt" /></td>
							<th>Payment Vender</th>
							<td> 
								<input name="vndr_seq" type="text" style="width:70px;" value="" readonly id="vndr_seq" /><!-- 
								 --><input name="vndr_seq_name" type="text" style="width:150px;" value="" readonly id="vndr_seq_name" />
							 </td>
						</tr>
					</tbody>
				</table>
				<table>
					<colgroup>
		                <col width="100">
		                <col width="70">
		                <col width="130">
		                <col width="90">
		                <col width="135">
		                <col width="*">
	            	</colgroup>
	          		<tbody>
						<tr>
							<th>No Of INV</th>
							<td><input name="cnt_inv" type="text" style="width:60px;" value="" readonly id="cnt_inv" /></td>
							<th>INV Currency</th>
							<td><input name="curr_cd" type="text" style="width:75px;" value="" readonly id="curr_cd" /></td>
							<th>Total Amount</th>
							<td><input name="total_amt" type="text" style="width:93px;" value="" readonly id="total_amt" /></td>
						</tr>
					</tbody>
				</table>
				<table>
					<colgroup>
		                <col width="100">
		                <col width="*">
	            	</colgroup>
	          		<tbody>
						<tr>
							<th>Payment Due DT</th>
							<td colspan="3">
								<input name="payment_due_dt" id="payment_due_dt" type="text" style="width:75px" maxlength="10" value="" onKeyUp='isNum1(this);;tes_isNumD(this,"Y");' onKeyDown='tes_chkInput(this);;tes_isNumD(this,"Y");' onBlur='isDate1(this);' readonly><!-- 
								 --><button type="button" name="btns_calendar2" id="btns_calendar2" class="calendar ir"></button>
							</td>
							<td colspan="2">
								<div id="srLayer" style="display:none">
									<span><strong>ASA No</strong></span>
									<span><script type="text/javascript">ComComboObject('asa_no',1, 100 , 0 )</script></span>
								</div>
								<div id="srLayer" style="display:none">
									<span><strong>증 빙 구 분</strong></span>
									<span>
										<select style="width:93px;" name="evi_gb1" id="evi_gb1" onChange="eviGbSelect(1)"><option value=""></option>
											<option value="1">세금계산서</option>
											<option value="2">계산서</option>
											<option value="3">기타</option>
										</select>
									</span>
								</div>
								<div id="srLayer" style="display:none">
									<span><strong>증 빙 구 분</strong></span>
									<select style="width:93px;" name="evi_gb2" id="evi_gb2" onChange="eviGbSelect(2)"><option value=""></option>
										<option value="1">세금계산서</option>
										<option value="2">계산서</option>
										<option value="3">기타</option>
									</select>
									<span><strong>ASA No</strong></span>
									<span><script type="text/javascript">ComComboObject('asa_no',1, 100 , 0 )</script></span>
								</div>
							</td>
						</tr>
				</tbody>
			</table>
			<table> 
	            <colgroup>
	                <col width="100">
	                <col width="*">
	            </colgroup>
	            <tbody>
		             <tr>
						<th>CSR No.</th>
						<td><input name="csr_no" type="text" style="width:260px;" value="<%=csr_no%>" id="csr_no" /></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	<div class="wrap_result">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid" id="mainTable" >	
			<!-- opus_design_btn (S) -->
			<div class="opus_design_btn">
				<button class="btn_normal" type="button" name="btng_preview" id="btng_preview">Preview</button><!-- 
				 --><button class="btn_normal" type="button" name="btng_detail" id="btng_detail">Detail</button>
			</div>
			<!-- opus_design_btn (E) -->	
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		<!-- opus_design_grid(E) -->
		</div>
		<div style="display:none" id="mainTable">
             <script type="text/javascript">ComSheetObject('sheet2');</script>
             <script type="text/javascript">ComSheetObject('sheet3');</script>
		</div>
	</div>
</div>
</form>