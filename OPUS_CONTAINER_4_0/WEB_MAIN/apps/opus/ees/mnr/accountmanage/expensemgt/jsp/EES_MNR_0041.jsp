<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MNR_0041.jsp
*@FileTitle  : MNR Invoice Creation & Correction
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/19
=========================================================
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.mnr.accountmanage.expensemgt.event.EesMnr0041Event" %>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesMnr0041Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Occurred error from server
	String strErrMsg = "";						//Error message
	int rowCount	 = 0;						//Row count of retrieved database data

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd        = "";
	String strRhq_ofc_cd         = "";
	Logger log = Logger.getLogger("com.clt.apps.test.test");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
		strRhq_ofc_cd  = account.getRhq_ofc_cd();

		event = (EesMnr0041Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		//Extracting retrieved data from server on load screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

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
<input type="hidden" name="usr" id="usr" value="<%=strUsr_id %>"  />
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
<input type="hidden" name="iss_ofc_cd" id="iss_ofc_cd" value="<%=strOfc_cd%>"  />
<input type="hidden" name="mnr_grp_tp_cd" id="mnr_grp_tp_cd" />
<input type="hidden" name="inv_rgst_no" id="inv_rgst_no" />
<input type="hidden" name="conv_dp_prcs_knt" id="conv_dp_prcs_knt" />
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title">
		<button type="button"><span id="title"></span></button>
	</h2>
<!-- page_title(E) -->
<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		 <button type="button" class="btn_accent" name="btn_AllNew"   id="btn_AllNew">New</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_Save" 	 id="btn_Save">Save</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_Delete"   id="btn_Delete">Delete</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_Confirm"  id="btn_Confirm">Confirm</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_Return"   id="btn_Return">Reject</button><!-- 
		 -->
		 <button type="button" class="btn_normal" name="btn_LoadExcel_popup"   id="btn_LoadExcel_popup">Load Excel</button>
	</div>
<!-- opus_design_btn(E) -->
<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<!-- page_location(E) -->

<div class="wrap_search">
    <!-- layout_wrap(S) -->
	<div class="layout_wrap">
	
        <!-- vertical LEFT(S) --> 
        <div class="layout_vertical_2 pad_rgt" style="width:50%">
            
            <!-- heading(S) -->
			<div class="clear">
				<h3 class="title_design floatL">Invoice List</h3>
				<div class="opus_design_btn floatR">
					<button type="button" class="btn_etc" name="btn_New" id="btn_New">New</button><!-- 
					--><button type="button" class="btn_etc" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button>
				</div>
			</div>
            <!-- heading(E) -->
            
            
            <!-- ////////////// INQUIRY AREA(S) ////////////// -->
            <div class="opus_design_inquiry clear sm mar_btm_12">
                <!-- kind table(S): FIXED -->
			    <table style="width:180px" class="floatL mar_rgt_8">
			        <tbody>
			        	<tr>
							<th width="95">KIND</th>
							<td><script type="text/javascript">ComComboObject('combo1', 1, 100 , 1, 1);</script></td>
						</tr>
						<!-- show/hide contents(S) -->
						<tr class="selectComboLayer">
							<th>W/O Office</th>
							<td><script type="text/javascript">ComComboObject('wo_ofc_cd', 2, 100 , 0, 1);</script></td>
						</tr>
						<!-- show/hide contents(E) -->
					</tbody>
				</table>
                <!-- kind table(E): FIXED -->
				
				<!-- show/hide table(S) -->
				<table class="floatL" style="width:250px">
				    <colgroup>
	                    <col width="55" />
				    </colgroup>
				    <!-- hideShow_0(S) -->
				    <tbody class="hideShow">
	                    <tr>
	                        <th>Req. Date</th>
	                        <td><input id="t1_from_dt" name="t1_from_dt" type="text" style="width:75px" dataformat="ymd" cofield="t1_to_dt" class="align_center" /><!-- 
	                          --><span class="dash">~</span><!-- 
	                          --><input id="t1_to_dt" name="t1_to_dt" type="text" style="width:75px" dataformat="ymd" cofield="t1_from_dt" class="align_center" /><!-- 
	                          --><button type="button" class="calendar" id="btn_t1_calendar" name="btn_t1_calendar" ></button>
	                        </td>
	                    </tr>
				        <tr>
	                        <th>INV No.</th>
	                        <td><input id="t1_mnr_ord_seq" name="t1_mnr_ord_seq" type="text" style="width:197px;" dataformat="engup" /><!--
		                     --><button type="button" class="multiple_inq" id="btn_t1_req_multy" name="btn_t1_req_multy"></button> 
	                        </td>
	                    </tr>
	                    <tr>
	                        <th>S/Provider</th>
	                        <td><input type="text" id="t1_vndr_seq" name="t1_vndr_seq" class="align_center" style="width:57px" maxlength="6" dataformat="num" /><!-- 
		                     --><button type="button" id="btn_t1_provider_popup" name="btn_t1_provider_popup" class="input_seach_btn"></button><!-- 
		                     --><input type="text" name="t1_vndr_lgl_eng_nm" style="width:160" readonly="readonly" />
	                        </td>
	                    </tr>
				    </tbody>
				    <!-- hideShow_0(E) -->
			    
				    <!-- hideShow_1(S) -->
	                <tbody class="hideShow" style="display:none">
	                   <tr>
	                       <th>W/O Date</th>
	                       <td><input name="t2_from_dt" type="text" style="width:75px" dataformat="ymd" class="align_center" /><!-- 
	                        --><span class="dash">~</span><!-- 
	                        --><input name="t2_to_dt" type="text" style="width:75px" dataformat="ymd" class="align_center" /><!-- 
	                        --><button type="button" class="calendar" id="btn_t2_calendar" name="btn_t2_calendar"></button>
	                       </td>
	                   </tr>
	                   <tr>
	                       <th>W/O No.</th>
	                       <td><input id="t2_mnr_ord_seq" name="t2_mnr_ord_seq" type="text" style="width:197px;" dataformat="engup" /><!-- 
	                           --><button type="button" class="multiple_inq" id="btn_t2_req_multy" name="btn_t2_req_multy"></button>
	                       </td>
	                   </tr>
	                   <tr>
	                       <th>S/Provider</th>
	                       <td><input type="text" id="t2_vndr_seq" name="t2_vndr_seq" style="width:57px" class="align_center" maxlength="6" dataformat="num" /><!--
	                        --><button type="button" id="btn_t2_provider_popup" name="btn_t2_provider_popup" class="input_seach_btn"></button><!-- 
	                        --><input type="text" name="t2_vndr_lgl_eng_nm" style="width:160" class="input2" readonly="readonly" />
	                       </td>
	                   </tr>
	                </tbody>
	                <!-- hideShow_1(E) -->
                   
                    <!-- hideShow_2(S) -->
                    <tbody class="hideShow" style="display:none">
	                    <tr>
		                    <th>INV Create Date</th>
		                    <td><input id="t3_from_dt" name="t3_from_dt" type="text" style="width:75px" dataformat="ymd" class="align_center" /><!-- 
			                 --><span class="dash">~</span><!-- 
			                 --><input id="t3_to_dt" name="t3_to_dt" type="text" style="width:75px" dataformat="ymd" class="align_center" /><!-- 
			                 --><button type="button" class="calendar" id="btn_t3_calendar" name="btn_t3_calendar"></button>
		                    </td>
	                    </tr>
	                    <tr>
		                    <th>INV No.</th>
		                    <td><input id="t3_mnr_ord_seq" name="t3_mnr_ord_seq" type="text" style="width:197px;" dataformat="engupetc" /><!-- 
			                 --><button type="button" class="multiple_inq" id="btn_t3_req_multy" name="btn_t3_req_multy"></button>
		                    </td>
	                    </tr>
	                    <tr>
		                    <th>S/Provider</th>
		                    <td><input type="text" id="t3_vndr_seq" name="t3_vndr_seq" style="width:57px" class="align_center" maxlength="6"  dataformat="num" /><!--
			                 --><button type="button" id="btn_t3_provider_popup" name="btn_t3_provider_popup" class="input_seach_btn"></button><!--
			                 --><input type="text" id="t3_vndr_lgl_eng_nm" name="t3_vndr_lgl_eng_nm" style="width:160" class="input2" readonly="readonly" />
		                    </td>
	                    </tr>
                    </tbody>
                    <!-- hideShow_2(E) -->
                </table>
                <!-- show/hide table(E) -->
            </div>
			<!-- ////////////// INQUIRY AREA(E) ////////////// -->
			
			
			<!-- ////////////// SHEET AREA(S) ////////////// -->
			<div class="opus_design_grid">
				<!-- hideShow_0_sheet(S) : [Web Import] -->
				<div class="hideShow_0_sheet">
					<div class="opus_design_btn">
						<button type="button" class="btn_normal" name="btn_t1_Clear" id="btn_t1_Clear">New</button><!-- 
						 --><button type="button" class="btn_normal" name="btn_t1_DetailRetrieve" id="btn_t1_DetailRetrieve">Detail Search</button>
					</div>
					<script>ComSheetObject('t1sheet1');</script>
				</div>
				<!-- hideShow_0_sheet(E) : [Web Import] -->
				
				
			    <!-- hideShow_1_sheet(S) : [Work Order] -->
				<div class="hideShow_1_sheet" style="display:none">
					<div class="opus_design_btn">
						<button type="button" class="btn_normal" name="btn_t2_Clear" id="btn_t2_Clear">New</button><!-- 
						 --><button type="button" class="btn_normal" name="btn_t2_DetailRetrieve" id="btn_t1_DetailRetrieve">Detail Search</button>
					</div>
					<script>ComSheetObject('t2sheet1');</script>
				</div>
				<!-- hideShow_1_sheet(E) : [Work Order] -->
				
				<!-- hideShow_2_sheet(S) : [Invoice Correction] -->
				<div class="hideShow_2_sheet" style="display:none">
					<div class="opus_design_btn">
						<button type="button" class="btn_normal" name="btn_t3_Clear" id="btn_t3_Clear">New</button><!-- 
						 --><button type="button" class="btn_normal" name="btn_t3_DetailRetrieve" id="btn_t3_DetailRetrieve">Detail Search</button>
					</div>
					<script>ComSheetObject('t3sheet1');</script>
				</div>
				<!-- hideShow_3_sheet(S) : [Invoice Correction] -->
			</div>
			<!-- ////////////// SHEET AREA(E) ////////////// -->
		</div>
        <!-- vertical LEFT(E) -->
        
		<!-- Invoice Information table(S) -->
		<div class="layout_vertical_2">
			<h3 class="title_design">Invoice Information</h3>
			<div class="opus_design_inquiry">
				<table style="width:600px">
<!-- 				    <colgroup> -->
<!-- 				        <col width="100" /> -->
<!-- 				        <col width="1" /> -->
<!-- 				        <col width="100" /> -->
<!-- 				        <col width="1" /> -->
<!-- 				        <col width="60" /> -->
<!-- 				    </colgroup> -->
					<tbody>
						<tr>
							<th>Invoice No.</th>
							<td colspan="3"><input name="inv_no" type="text" size="30" maxlength="20" class="input1" dataformat="engupetc" id="inv_no" /> </td>
							<th>Invoice Status</th>
							<td colspan="3"><input name="inv_status" type="text" style="width:92px;" class="input2" readonly="readonly" id="inv_status" /><!--
							 --><div style = "display: none"><script type="text/javascript">ComComboObject('combo2',1, 0 , 1,3);</script></div>
							</td>
						</tr>
						<tr >
							<th>Receive DT</th>
							<td colspan="3"><input name="rcv_dt" type="text" style="width:70px;" class="input1" dataformat="ymd" id="rcv_dt" /><button type="button" id="btn_rcv_dt" name="btn_rcv_dt" class="calendar ir"></button></td>
							<th>Issue DT</th>
							<td><input name="iss_dt" type="text" style="width:70px;" class="input1 align_center" dataformat="ymd" id="iss_dt" /><!-- 
                             --><button type="button" id="btn_isu_dt" name="btn_isu_dt" class="calendar ir"></button>
                            </td>
						</tr>
						<tr >
							<th>W/O S/P</th>
							<td colspan="3"><input name="ord_vndr_seq" type="text" style="width:70px;" class="input2" dataformat="num" readonly="readonly" id="ord_vndr_seq" /><!-- 
							 --><input name="ord_vndr_seq_nm" type="text" style="width:161px;" class="input2" readonly="readonly" id="ord_vndr_seq_nm" />
                            </td>
							<th>INV Office</th>
							<td><input name="agmt_ofc_cd" type="text" style="width:92px;" class="input2" readonly="readonly" id="agmt_ofc_cd" /></td>
						</tr>
						<tr >
							<th>Pay S/P</th>
							<td colspan="3"><input required  type="text" name="mnr_prnr_seq" caption="Service Provider" style="width:55px;text-align:left;" class="input1" value="" dataformat="num" maxlength="6" id="mnr_prnr_seq" /><button type="button" id="btn_vndr" name="btn_vndr" class="input_seach_btn"></button><input type="text" name="vndr_nm" caption="Service Provider" style="width:147px;" class="input2" value="" readonly id="vndr_nm" /> </td>
							<th>Pay Term</th>
							<td><input name="gen_pay_term_cd" type="text" style="width:51px;" class="input2 align_right" readonly="readonly" id="gen_pay_term_cd" /></td>
				
						</tr>
						<tr>
							<th>INV Curr</th>
							<td><input name="curr_cd" type="text" style="width:84px;" class="input2" readonly="readonly" id="curr_cd" /></td>
							<th>Conv Curr</th>
							<td><script type="text/javascript">ComComboObject('target_curr_cd',2, 50 , 1,0);</script></td>
							<th>EX.Rate</th>
							<td><input name="curr_rt" type="text" style="width:70px; text-align:right;" class="input" dataformat="float" id="curr_rt" pointcount="2"/><button type="button" class="btn_etc" name="btn_Convert" id="btn_Convert" >Conv</button></td>
						</tr>
						<tr>
							<th>Invoice Total</th>
							<td colspan="5"><input name="ttl_amt" type="text" style="width:100%; text-align:right;" class="input1" dataformat="singledFloat" id="ttl_amt" readonly="readonly"/></td>
						</tr>
						<tr >
							<th> Amount</th>
							<td colspan="5"><input name="bzc_amt" type="text" style="width:100%; text-align:right;" class="input2" dataformat="singledFloat" readonly="readonly" id="bzc_amt" /></td>
						</tr>
						<tr >
							<th>V.A.Tax</th>
							<td><input name="vat_amt" type="text" style="width:70px; text-align:right;" class="input" dataformat="float" id="vat_amt" /></td>
							<th>Sales Tax</th>
							<td><input name="sls_tax_amt" type="text" style="width:80px; text-align:right;" class="input" dataformat="float" id="sls_tax_amt" /></td>
							<th>W.H.Tax</th>
							<td><input name="whld_tax_amt" type="text" style="width:86px; text-align:right;" class="mar_rgt_none w100" dataformat="float" id="whld_tax_amt" /></td>
						</tr>
						<tr >
							<th>Remark</th>
							<td colspan="5"><input name="mnr_inv_rmk" type="text" style="width:100%;" class="input" maxlength="4000" id="mnr_inv_rmk" /></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		<!-- Invoice Information table(E) -->
	</div>
    <!-- layout_wrap(E) -->
</div>



<div class="wrap_result">
	<!-- opus_tab_btn(S) -->
	<div class="opus_design_tab">
		<script type="text/javascript">ComTabObject('tab1')</script>
	</div>
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid clear"  name="tabLayer" id="tabLayer" style="display:inline">
		<div class="opus_design_btn">
				<button type="button" class="btn_normal" name="btn_Store" id="btn_Store">Verify</button><!-- 
				 --><button type="button" class="btn_normal" name="btn_Del" id="btn_Del">Row Delete</button><!-- 
				 --><button type="button" class="btn_normal" name="btn_RepairDetail" id="btn_RepairDetail">Repair Detail</button><!-- 
				 --><button type="button" class="btn_normal" name="btn_DownExcel" id="btn_DownExcel">Down Excel</button><!-- 
				 --><button type="button" class="btn_normal" name="btn_LoadExcel" id="btn_LoadExcel">LoadExcel</button>
		</div>
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<!-- opus_design_grid(E) -->
	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid clear"  name="tabLayer" id="tabLayer" style="display:none">
	<div class="opus_design_btn">
				<button type="button" class="btn_normal" name="btn_Store" id="btn_Store">Verify</button><!-- 
				 --><button type="button" class="btn_normal" name="btn_Del" id="btn_Del">Row Delete</button><!-- 
				 --><button type="button" class="btn_normal" name="btn_RepairDetail" id="btn_RepairDetail">Repair Detail</button><!-- 
				 --><button type="button" class="btn_normal" name="btn_DownExcel" id="btn_DownExcel">Down Excel</button><!-- 
				 --><button type="button" class="btn_normal" name="btn_LoadExcel" id="btn_LoadExcel">LoadExcel</button>
		</div>
		<script type="text/javascript">ComSheetObject('sheet2');</script>
		<script type="text/javascript">ComSheetObject('sheet3');</script>
		<script type="text/javascript">ComSheetObject('sheet4');</script>
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>