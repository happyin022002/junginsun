<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MNR_S041.jsp
*@FileTitle  : MNR Invoice Creation & Correction
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/11
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.mnr.accountmanage.expensemgt.event.EesMnrS041Event" %>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesMnrS041Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd        = "";
	String strRhq_ofc_cd         = "";
	Logger log = Logger.getLogger("com.clt.apps.test.test");
	String strVndr_seq		= "";
	String strVndr_nm		= "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
		strRhq_ofc_cd  = account.getRhq_ofc_cd();
		strVndr_seq = account.getOfc_eng_nm();
		strVndr_nm 	= account.getOfc_krn_nm();
		
		
	event = (EesMnrS041Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
	GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<script type="text/javascript">   
	var currOfcCd = '<%=strOfc_cd %>';
	var rhqOfcCd  = '<%=strRhq_ofc_cd %>';
	
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
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="key_value" id="key_value" />
<input type="hidden" name="usr" value="<%=strUsr_id %>" id="usr" />
<input type="hidden" name="ar_hd_qtr_cd" id="ar_hd_qtr_cd" />
<input type="hidden" name="ofc_cd" id="ofc_cd" />
<input type="hidden" name="inv_search_tp" id="inv_search_tp" />
<input type="hidden" name="from_dt" id="from_dt" />
<input type="hidden" name="to_dt" id="to_dt" />
<input type="hidden" name="mnr_ord_seq" id="mnr_ord_seq" />
<input type="hidden" name="vndr_seq" id="vndr_seq" />
<input type="hidden" name="inv_sch_type_code" id="inv_sch_type_code" />
<input type="hidden" name="mnr_inv_sts_cd" id="mnr_inv_sts_cd" />
<input type="hidden" name="pay_inv_seq" id="pay_inv_seq" />
<input type="hidden" name="mnr_grp_tp_cd" id="mnr_grp_tp_cd" />
<input type="hidden" name="iss_ofc_cd" value="<%=strOfc_cd%>" id="iss_ofc_cd" />
<input type="hidden" name="inv_rgst_no" id="inv_rgst_no" />
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		    <button class="btn_accent"  type="button" name="btn_AllNew" id="btn_AllNew">New</button><!-- 
		 --><button class="btn_normal"  type="button" name="btn_Save" id="btn_Save">Save</button><!-- 
		 --><button class="btn_normal"  type="button" name="btn_Delete" id="btn_Delete">Delete</button><!-- 
		 --><button class="btn_normal"  type="button" name="btn_Request" id="btn_Request">Request</button>
	</div>
	<!-- opus_design_btn (E) -->
	<!-- page_location(S) -->
	<div class="location">
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->
<div class="wrap_search_tab">
	<!-- layout_wrap(S) -->
	<div class="layout_wrap">
  		 <!-- layout_vertical_2(S) -->
 	 	 <div class="layout_vertical_2 pad_rgt_12">
			<!-- opus_design_inquiry(S) -->
			<div class="opus_design_inquiry">
				<h3 class="title_design">Invoice List</h3>
				<table>
					<colgroup>
						<col width="40">
						<col width="200">
						<col width="*">
					</colgroup>
						<tr>
							<th>KIND</th>
							<td><script type="text/javascript">ComComboObject('combo1',1, 120 , 1,1);</script></td>
							<td>
								<button class="btn_etc"  type="button" name="btn_New" id="btn_New">New</button><!--  
							--><button class="btn_etc"  type="button" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button>
							</td>
						</tr>
					</tbody>
				</table>
				<div id="selectLayer" style="display:none">
					<table>
						<colgroup>
							<col width="240">
							<col width="*">
						</colgroup>
						<tbody>
							<tr>
								<th>Req. Date</th>
								<td>
									<input name="t1_from_dt" type="text" style="width:99px;" class="input" dataformat="ymd" id="t1_from_dt" /><!--  
									--><input name="t1_to_dt" type="text" style="width:99px;" class="input" dataformat="ymd" id="t1_to_dt" />
								</td>
							</tr>
						</tbody>
					</table>
					<table> 
						<colgroup>
							<col width="240">
							<col width="*">
						</colgroup>
						<tbody>
							<tr>
								<th>INV No.</th>
								<td>
									<input name="t1_mnr_ord_seq" type="text" style="width:221px;" dataformat="engup" id="t1_mnr_ord_seq" /><!--  
									--><button type="button" id="btn_t1_req_multy" name="btn_t1_req_multy" class="multiple_inq ir"></button>
								</td>
							</tr>
							<tr>
								<th>S/Provider</th>
								<td>
									<input type="text" name="t1_vndr_seq" style="width:57px;text-align:center" class="input2" dataformat="num" readonly="true" value="<%=strVndr_seq %>" id="t1_vndr_seq" /><!--  
									--><input type="text" name="t1_vndr_lgl_eng_nm" style="width:152px;" class="input2" readonly="true" value="<%=strVndr_nm %>" id="t1_vndr_lgl_eng_nm" />
								</td>
							</tr>
						</tbody>
					</table>	
					<div class="opus_design_grid"  id="mainTable">
						<div class="opus_design_btn">			
							<button class="btn_etc"  type="button" name="btn_t1_Clear" id="btn_t1_Clear">New</button><!--  
						 --><button class="btn_etc"  type="button" name="btn_t1_DetailRetrieve" id="btn_t1_DetailRetrieve">Detail Search</button>
						</div>
						<script type="text/javascript">ComSheetObject('t1sheet1');</script>
					</div>
				</div>
				<div id="selectLayer" style="display:inline">
					<table>
						<colgroup>
							<col width="240">
							<col width="*">
						</colgroup>
						<tbody>
							<tr>
								<th>W/O Date</th>
								<td>
									    <input name="t2_from_dt" id="t2_from_dt" type="text" style="width:80px" class="input" dataformat="ymd">~ <!-- 
									 --><input name="t2_to_dt" id="t2_to_dt" type="text" style="width:80px" class="input" dataformat="ymd"><!-- 
									 --><button type="button" name="btn_t2_calendar" id="btn_t2_calendar"  class="calendar ir"></button>
								</td>
							</tr>
						</tbody>
					</table>
					<table> 
						<colgroup>
							<col width="240">
							<col width="*">
						</colgroup>
						<tbody>
							<tr>
								<th>W/O No.</th>
								<td>
									<input name="t2_mnr_ord_seq" type="text" style="width:182px;" dataformat="engup" id="t2_mnr_ord_seq" /><!-- 
									--><button type="button" id="btn_t2_req_multy" name="btn_t2_req_multy" class="multiple_inq ir"></button>
								</td>
							</tr>
							<tr>
								<th>S/Provider</th>
								<td>
									<input type="text" name="t2_vndr_seq" style="width:50px;text-align:center" class="input2" dataformat="num" value="<%=strVndr_seq %>" readonly="true" id="t2_vndr_seq" /><!-- 
									--><input type="text" name="t2_vndr_lgl_eng_nm" style="width:150px;" class="input2" readonly="true" value="<%=strVndr_nm %>" id="t2_vndr_lgl_eng_nm" />
								</td>
							</tr>
						</tbody>
					</table>			
					<div class="opus_design_grid"  id="mainTable">
						<div class="opus_design_btn">	
							<button class="btn_normal"  type="button" name="btn_t2_Clear" id="btn_t2_Clear">New</button><!--  
						 --><button class="btn_normal"  type="button" name="btn_t2_DetailRetrieve">Detail Search</button>		
						</div>
						<script type="text/javascript">ComSheetObject('t2sheet1');</script>
					</div>
				</div>
				<div id="selectLayer" style="display:none">
					<table> 
						<colgroup>
							<col width="240">
							<col width="*">
						</colgroup>
						<tbody>
							<tr>
								<th>INV Date</th>
								<td>
									   <input name="t3_from_dt"  id="t3_from_dt" type="text" style="width:80px" class="input" dataformat="ymd"><span class="dash">~</span><!--
									--><input name="t3_to_dt" id="t3_to_dt" type="text" style="width:80px" class="input" dataformat="ymd"><!--
									--><button type="button" id="btn_t3_calendar" name="btn_t3_calendar" class="calendar ir"></button>
								</td>
							</tr>
						</tbody>
					</table>
					<table>	
						<colgroup>
							<col width="240">
							<col width="*">
						</colgroup>
						<tbody>				
							<tr>
								<th>INV No.</th>
								<td>
									<input name="t3_mnr_ord_seq" id="t3_mnr_ord_seq" type="text" style="width:182px;" dataformat="engup" ><!--
									--><button type="button" class="input_seach_btn"   name="btn_t3_req_multy" id="btn_t3_req_multy"></button>
								</td>
							</tr>
							<tr>
								<th>S/Provider</th>
								<td>
									<input type="text" name="t3_vndr_seq" id="t3_vndr_seq" style="width:50px;text-align:center" class="input2" dataformat="num" value="<%=strVndr_seq %>" readOnly="true"><!--
									--><input type="text" name="t3_vndr_lgl_eng_nm" id="t3_vndr_lgl_eng_nm" style="width:150px" class="input2" readOnly="true" value="<%=strVndr_nm %>">
								</td>
							</tr>
						</table>		
						<div class="opus_design_grid"  id="mainTable">
							<div class="opus_design_btn">	
								<button class="btn_normal"  type="button" name="btn_t3_Clear" id="btn_t3_Clear">New</button><!--  
						 	 --><button class="btn_normal"  type="button" name="btn_t3_DetailRetrieve" id="btn_t3_DetailRetrieve">Detail Search</button>
							</div>
							<script type="text/javascript">ComSheetObject('t3sheet1');</script>
						</div>				
				</div>
			</div>
		</div>
		<!-- layout_vertical_2(E) -->
 	    <!-- layout_vertical_2(S) -->
 	    <div class="layout_vertical_2">
     		<!-- opus_design_inquiry(S) -->
     		<div class="opus_design_inquiry">
				<h3 class="title_design">Invoice Information</h3>
			    <table> 
			    	<colgroup>
						<col width="90">
						<col width="120">
						<col width="100">
						<col width="*">
					</colgroup>
					<tbody>				
						<tr>
							<th>Inv. No.</th>
							<td><input name="inv_no" type="text" style="width:110px;" maxlength="20" class="input1" dataformat="engupetc" id="inv_no" /></td>
							<th>Inv. Status</th>
							<td colspan="3"><input name="inv_status" type="text" style="width:92px;" class="input2" readonly="true" id="inv_status" /><!--
							 --><div style = "display: none"><script type="text/javascript">ComComboObject('combo2',1, 0 , 1,3);</script></div>
							</td>
						</tr>
						<tr>
							<th>Issue DT</th>
							<td>
								<input name="iss_dt" id="iss_dt" type="text" style="width:85px;" class="input1" dataformat="ymd"  /><!-- 
								 --><button type="button" id="btn_isu_dt" name="btn_isu_dt" class="calendar ir"></button>
							<th>Request DT</th>
							<td>
								<input name="rcv_dt" type="text" style="width:90px;" class="input1" dataformat="ymd"><!-- 
								 --><button type="button" id="btn_rcv_dt" name="btn_rcv_dt"  class="calendar ir"></button>
							</td>
						</tr>
						<tr>
							<th>W/O S/P</th>
							<td>
								<input name="ord_vndr_seq" type="text" style="width:80px;" class="input2" dataformat="num" readonly="true" id="ord_vndr_seq" /><!-- 
								 --><input name="ord_vndr_seq_nm" type="text" style="width:140px;" class="input2" readonly="true" id="ord_vndr_seq_nm" />
							</td>
							<th>INV Office</th>
							<td><input name="agmt_ofc_cd" id="agmt_ofc_cd" type="text" style="width:80px;" class="input2" readonly="true" /></td>
						</tr>
					</tbody>
				</table>	
				<table> 
					<colgroup>
						<col width="90">
						<col width="*">
					</colgroup>
					<tbody>			
						<tr>
							<th>Pay S/P</th>
							<td>
								<input required  type="text" name="mnr_prnr_seq" id="mnr_prnr_seq" caption="Service Provider" style="width:55px;text-align:left;" class="input1" value="" dataformat="engup" maxlength="6"><!-- 
								 --><button type="button" class="input_seach_btn" name="btn_vndr" id="btn_vndr"></button><!-- 
								 --><input name="vndr_nm" id="vndr_nm" class="input2" style="width: 147px;" type="text" readOnly="" caption="Service Provider"/>
							</td>
						</tr>
					</tbody>
				</table>
				<table> 
					<colgroup>
						<col width="90">
						<col width="120">
						<col width="210">
						<col width="*">
					</colgroup>
					<tbody>			
						<tr>
							<th>Currency</th>
							<td><input name="curr_cd" type="text" style="width:80px;" class="input2" readonly="true" id="curr_cd" /> </td>
							<th>Pay Term</th>
							<td><input name="gen_pay_term_cd" type="text" style="width:80px; text-align:right;" class="input2" readonly="true" id="gen_pay_term_cd" /> </td>
						</tr>
					</tbody>
				</table>
				<table> 
					<colgroup>
						<col width="90">
						<col width="*">
					</colgroup>
					<tbody>			
						<tr>		
							<th>Invoice Total</th>
							<td><input name="ttl_amt" type="text" style="width:100%; text-align:right;" class="input1" dataformat="float" id="ttl_amt" /></td>
						</tr>	
						<tr>				
							<th>TTL Amount</th>
							<td><input name="bzc_amt" type="text" style="width:100%; text-align:right;" class="input2" dataformat="float" readonly="true" id="bzc_amt" /></td>
						</tr>
					</tbody>
				</table>
				<table>
					<colgroup>
						<col width="90">
						<col width="70">
						<col width="140">
						<col width="70">
						<col width="130">
						<col width="*">
					</colgroup>
					<tbody>		
						<tr>						
							<th>V.A.Tax</th>
							<td><input name="vat_amt" type="text" style="width:70px; text-align:right;" class="input" dataformat="float" id="vat_amt" /></td>
							<th>Sales Tax</th>
							<td><input name="sls_tax_amt" type="text" style="width:80px; text-align:right;" class="input" dataformat="float" id="sls_tax_amt" /></td>
							<th>W.H.Tax</th>
							<td><input name="whld_tax_amt" type="text" style="width:86px; text-align:right;" class="input" dataformat="float" id="whld_tax_amt" /></td>
						</tr>	
					</tbody>
				</table>
				<table>
					<colgroup>
						<col width="90">
						<col width="*">
					</colgroup>
					<tbody>		
						<tr>					
							<th>Remark</th>	
							<td><input name="mnr_inv_rmk" type="text" style="width:100%;" class="input" maxlength="4000" id="mnr_inv_rmk" /> </td>
						</tr>	
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>
<div class="wrap_result">
		<div class="opus_design_tab">
			<script type="text/javascript">ComTabObject('tab1')</script>
		</div>
		<div id="tabLayer">
			<div class="opus_design_grid"  id="mainTable">
				<div class="opus_design_btn">
				   <button type="button" class="btn_accent"  name="btn_Store" id="btn_Store">Verify</button><!--
				--><button type="button" class="btn_normal" name="btn_Del" id="btn_Del">Row Del</button><!--
				--><button type="button" class="btn_normal" name="btn_RepairDetail" id="btn_RepairDetail">Repair Detail</button><!--
				--><button type="button" class="btn_normal" name="btn_DownExcel" id="btn_DownExcel">Down Excel</button><!--
				--><button type="button" class="btn_normal" name="btn_LoadExcel" id="btn_LoadExcel">Load  Excel</button>
			</div>
				<script type="text/javascript">ComSheetObject('sheet1');</script>
			</div>
		</div>
		<div id="tabLayer" style="display:none">
			<div class="opus_design_grid"  id="mainTable">
				<div class="opus_design_btn">
				   <button type="button" class="btn_normal"  name="btn_Store" id="btn_Store">Verify</button><!--
				--><button type="button" class="btn_normal" name="btn_Del" id="btn_Del">Row Del</button><!--
				--><button type="button" class="btn_normal" name="btn_RepairDetail" id="btn_RepairDetail">Repair Detail</button><!--
				--><button type="button" class="btn_normal" name="btn_DownExcel" id="btn_DownExcel">Down Excel</button><!--
				--><button type="button" class="btn_normal" name="btn_LoadExcel" id="btn_LoadExcel">Load  Excel</button>
				</div>
				<script type="text/javascript">ComSheetObject('sheet2');</script>	
			</div>
			<div class="opus_design_grid"  id="mainTable">
				<script type="text/javascript">ComSheetObject('sheet3');</script>	
			</div>
		</div>
</div>			
</form>