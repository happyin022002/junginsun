<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   EES_DMT_4016.jsp
*@FileTitle  : SZPBB DEM Calculation &amp; Issue
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/10 
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.event.EesDmt4016Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesDmt4016Event  event = null;			    //PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//DB ResultSet Count of list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_ofc		= "";
	String strUsr_Cnt_cd	= "";
	String strUsr_eml		= "";
	
	Logger log = Logger.getLogger("com.clt.apps.DMTClosing.ChargeCalculation");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id		= account.getUsr_id();
		strUsr_nm 		= account.getUsr_nm();
		strUsr_ofc		= account.getOfc_cd();
		strUsr_Cnt_cd	= account.getCnt_cd();
		strUsr_eml		= account.getUsr_eml();

		event = (EesDmt4016Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// in loading page, Get data from server
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

<form name="form" id="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />


<input type="hidden" name="dmdt_trf_cd" id="dmdt_trf_cd" />
<input type="hidden" name="dmdt_chg_sts_cd" id="dmdt_chg_sts_cd" />
<input type="hidden" name="fm_mvmt_yd_cd" id="fm_mvmt_yd_cd" />
<input type="hidden" name="to_mvmt_yd_cd" id="to_mvmt_yd_cd" />
<input type="hidden" name="pol_cd" id="pol_cd" />
<input type="hidden" name="pod_cd" id="pod_cd" />
<input type="hidden" name="fm_mvmt_dt" id="fm_mvmt_dt" />
<input type="hidden" name="to_mvmt_dt" id="to_mvmt_dt" />
<input type="hidden" name="yd_cd1" id="yd_cd1" />
<input type="hidden" name="loc_cd" id="loc_cd" />
<input type="hidden" name="chk_yd_cd" value="Y" id="chk_yd_cd" />
<input type="hidden" name="chk_loc_cd" value="Y" id="chk_loc_cd" />
<input type="hidden" name="backendjob_key" id="backendjob_key" />
<input type="hidden" name="backendjob_id" id="backendjob_id" />

	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	    <!-- page_title(S) -->
		<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
		<!-- page_title(E) -->
		
		<!-- page_location(S) -->
		<div class="location">
			<!-- location 내용 동적생성 (별도 코딩 불필요) -->
			<span id="navigation"></span>
		</div>
		<!-- page_location(E)-->
	</div>
	<!-- page_title_area(E) -->
	<!-- wrap_result(S) -->
	<div class="wrap_result sm" >
		<!-- opus_tab_btn(E) -->
		<!-- opus_design_tab(S) -->
		<div class="opus_design_tab">
			<script type="text/javascript">ComTabObject('tab1')</script>
		</div>
		<!-- opus_design_tab(E) -->
		
		<!-- ********************* 	Tab-1 (S) 	********************** -->
		<div name="tabLayer" id="tabLayer" style="display:inline">
			<!-- opus_design_btn (S) -->
			<div class="opus_design_btn">
				<button class="btn_accent" name="btn_Retrieve" id="btn_Retrieve" type="button">Retrieve</button><!--
				--><button class="btn_normal" name="btn_New" id="btn_New" type="button">New</button><!--
				--><button class="btn_normal" name="btn_Minimize" id="btn_Minimize" type="button">Minimize</button><!--
				--><button class="btn_normal" name="btn_GetToMVMT" id="btn_GetToMVMT" type="button">Get To MVMT</button><!--
				--><button class="btn_normal" name="btn_Calculate" id="btn_Calculate" type="button">Calculate</button><!--
				--><button class="btn_normal" name="btn_Confirm" id="btn_Confirm" type="button">Confirm</button><!--
				--><button class="btn_normal" name="btn_MBilling" id="btn_MBilling" type="button">Manual Billing</button><!--
				--></div>
			<div class="opus_design_btn">
				<button class="btn_normal" name="btn_MVMTInq" id="btn_MVMTInq" type="button">MVMT Inq.</button><!--
				--><button class="btn_normal" name="btn_ExptInq" id="btn_ExptInq" type="button">Exception Inq.</button><!--
				--><button class="btn_normal" name="btn_DownExcel" id="btn_DownExcel" type="button">Down Excel</button><!--
				--></div>
			<!-- opus_design_btn (E) -->
			
			<!-- opus_design_inquiry(S) -->
			<div class="opus_design_inquiry wFit" id="sch_cond_div" style="display:inline;">
				<table>
					<tbody>
						<colgroup>
							<col width="50">
							<col width="120">
							<col width="85">
							<col width="145">
							<col width="50">
							<col width="*">
					    </colgroup>
						<tr>
							<th>Office </th>
							<td><input type="text" name="ofc_cd" id="ofc_cd" style="width:60px;text-align:center;" value="SZPBB" readonly class="input2"></td>
							<th>Tariff Type</th>
							<td><script type="text/javascript">ComComboObject('tariff_type',2,80,1,1);</script></td>
							<th>Status</th>
							<td class="stm"><input type="checkbox" name="incl_inv" id="incl_inv" value="Y"  class="trans">&nbsp;Incl. Invoiced</td>
						</tr>
					</tbody>
				</table>
				<table class="sm">
					<tbody>
						<colgroup>
							<col width="70">
							<col width="75">
							<col width="235">
							<col width="70">
							<col width="260">
							<col width="*">
					    </colgroup>
					    <tr><td height="3"></td></tr>
						<tr>
							<td class="pad_left_8"><input type="radio" name="cond_type"  id="cond_type" value="date" class="trans" onclick="condType_click()">&nbsp;<b>Date</b></td>
							<th>Period</th>
							<td><input type="text" name="fm_mvmt_dt1" id="fm_mvmt_dt1" dataformat="ymd" style="width:80px;" class="input1">~&nbsp;<!-- 
							 --><input type="text" name="to_mvmt_dt1" id="to_mvmt_dt1" dataformat="ymd" style="width:80px;" class="input1"><!-- 
							 --><button type="button" class="calendar" name="btns_calendar" id="btns_calendar"></button>
							</td>
							<th>Yard</th>
							<td><input type="radio" name="yard_fmto" id="yard_fmto" value="yard_fm"  checked class="trans" checked>&nbsp;<b>From</b>&nbsp;&nbsp;&nbsp;<!-- 
								 --><input type="radio" name="yard_fmto" id="yard_fmto" value="yard_to" class="trans">&nbsp;<b>To</b>&nbsp;&nbsp;&nbsp;<!-- 
								 --><input type="text" name="yd_cd" id="yd_cd" dataformat="engup" maxlength="5" OnKeyUp="obj_keyup()" style="width:79px;" class="input"><!-- 
								 --><script type="text/javascript">ComComboObject('yd_cd2', 2, 60, 0);</script>
							</td>
							<td></td>
						</tr>
					</tbody>
				</table>
				<table class="sm">
					<tbody>
						<colgroup>
							<col width="70">
							<col width="75">
							<col width="235">
							<col width="65">
							<col width="*">
					    </colgroup>
						<tr>
							<td class="pad_left_8"><input type="radio" name="cond_type" id="cond_type" value="vvd_cd" checked class="trans" onclick="condType_click()">&nbsp;<b>VVD CD</b></td>
							<th>VVD CD</th>
							<td><input type="text" name="vvd_cd" id="vvd_cd" dataformat="engup"  maxlength="9"  style="width:100px;" class="input"></td>
							<th>Port</th>
							<td><input type="text" name="tmnl_cd" id="tmnl_cd" dataformat="engup" maxlength="5" OnKeyUp="obj_keyup()" style="width:50px;" class="input"></td>
						</tr>
					</tbody>
				</table>
				<table class="sm">
					<tbody>
						<colgroup>
							<col width="70">
							<col width="75">
							<col width="235">
							<col width="65">
							<col width="140">
							<col width="75">
							<col width="*">
					    </colgroup>
						<tr>
							<td class="pad_left_8"><input type="radio" name="cond_type" id="cond_type"  value="cntr" class="trans" onclick="condType_click()">&nbsp;<b>CNTR</b></td>
							<th>BKG No.</th>
							<td><input type="text" name="bkg_no" id="bkg_no" dataformat="engup" style="width:100px;" class="input"><!-- 
							 --><button type="button" class="multiple_inq" name="btns_multisearch1" id="btns_multisearch1" onClick="doProcessPopup('m_bkg_no')"></button>
							 <!-- <img src="img/btns_multisearch.gif" name="btns_multisearch1" onClick="doProcessPopup('m_bkg_no')" width="19"height="20"alt=""border="0"align="absmiddle"class="cursor"> -->
										  
							</td>
							<th>B/L No.</th>
							<td><input type="text" name="bl_no" id="bl_no" dataformat="engup" style="width:100px;" class="input"><!-- 
							 --><button type="button" class="multiple_inq" name="btns_multisearch2" id="btns_multisearch2" onClick="doProcessPopup('m_bl_no')"></button>
								<!-- <img src="img/btns_multisearch.gif" name="btns_multisearch2" onClick="doProcessPopup('m_bl_no')" width="19"height="20"alt=""border="0"align="absmiddle"class="cursor"> -->
											
							</td>
							<th>CNTR No.</th>
							<td><input type="text" name="cntr_no" id="cntr_no" dataformat="engup"  style="width:100px;" class="input"><!-- 
							 --><button type="button" class="multiple_inq" name="btns_multisearch3" id="btns_multisearch3" onClick="doProcessPopup('m_cntr_no')"></button>
											<!-- <img src="img/btns_multisearch.gif" name="btns_multisearch3" onClick="doProcessPopup('m_cntr_no')" width="19"height="20"alt=""border="0"align="absmiddle"class="cursor"> -->
											
							</td>
						</tr>
						<tr><td height="3"></td></tr>
					</tbody>
				</table>
				<table>
					<tbody>
						<colgroup>
							<col width="70">
							<col width="252">
							<col width="123">
							<col width="150">
							<col width="65">
							<col width="135">
							<col width="60">
							<col width="*">
					    </colgroup>
						<tr>
							<th>Customer</th>
							<td><select name="cust_type" id="cust_type" style="width:70px;" class="input"><!-- 
								--><option value="" selected>ALL</option><!-- 
							    --><option value="P">Payer</option><!-- 
							    --><option value="S">SHPR</option><!-- 
							    --><option value="C">CNEE</option><!-- 
							    --><option value="N">NTFY</option><!-- 
							    --><option value="A">A/R</option></select><!-- 
							    --><input type="text" name="cust_cd" id="cust_cd"  dataformat="engup"  maxlength=8 style="width:100px;" class="input" value=""><!-- 
							    --><button type="button" class="input_seach_btn"  name="btns_cust_cd" id="btns_cust_cd"></button>
								<!-- <img src="img/btns_search.gif" name="btns_cust_cd" width="19"height="20"alt=""border="0"align="absmiddle"class="cursor"> -->
								
							</td>
							<th>Service Provider</th>
							<td class="stm"><input type="text" name="svc_provdr" id="svc_provdr" maxlength="6"  dataformat="num" fulfill  style="width:100px;" class="input" value=""><!-- 
							 			--><button type="button" class="input_seach_btn" name="btns_svc_provdr" id="btns_svc_provdr"></button>
											<!-- <img src="img/btns_search.gif" name="btns_svc_provdr" width="19"height="20"alt=""border="0"align="absmiddle"class="cursor"> -->											
							</td>
							<th>S/C No.</th>
							<td class="stm"><input type="text" name="sc_no" id="sc_no" dataformat="engup" maxlength=20 style="width:100px;" class="input" value=""></td>
							<th>RFA No.</th>
							<td class="stm"><input type="text" name="rfa_no" id="rfa_no"  dataformat="engup" maxlength=11 style="width:100px;" class="input" value=""></td>
						</tr>
					</tbody>
				</table>
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
			</div>
			<!-- opus_design_inquiry(E) -->
			
			<!-- opus_design_grid(S) -->	
			<div class="opus_design_grid" id="mainTable">
				<script type="text/javascript">ComSheetObject('t1sheet1');</script>
			</div>
			
			<div class="opus_design_grid" id="mainTable2" style="display:none;">
				<script type="text/javascript">ComSheetObject('t1sheet2');</script>
			</div>
			
			<div class="opus_design_grid" id="mainTable3" style="display:none;">
				<script type="text/javascript">ComSheetObject('t1sheet3');</script>
			</div>
			<!-- opus_design_grid(E) -->
		</div>
		<!-- ********************* 	Tab-1 (E) 	********************** -->
		
		<!-- ********************* 	Tab-2 (S) 	********************** -->
		<div name="tabLayer" id="tabLayer" style="display:none;">
			<form name="form2" id="form2">
		
				<!-- opus_design_btn (S) -->
				<div class="opus_design_btn">
					<button class="btn_accent" name="btn_SheetSet" id="btn_SheetSet" type="button">Sheet Set</button><!--
					--><button class="btn_normal" name="btn_SheetOpt" id="btn_SheetOpt" type="button">Sheet Option</button><!--
					--><button class="btn_normal" name="btn_SendingHistory" id="btn_SendingHistory" type="button">Sending History</button><!--
					--><button class="btn_normal" name="btn_CRemark" id="btn_CRemark" type="button" onmouseover="obj_mouseover()" onmouseout="obj_mouseout()s">C. Remark</button><!--
					--></div>
					<div class="opus_design_btn">
					<button class="btn_accent" name="btn_New2" id="btn_New2" type="button">New</button><!--
					--><button class="btn_normal" name="btn_Minimize2" id="btn_Minimize2" type="button">Minimize</button><!--
					--><button class="btn_normal" name="btn_Save" id="btn_Save" type="button">Save</button><!--
					--><button class="btn_normal" name="btn_Cancel" id="btn_Cancel" type="button">Cancel</button><!--
					--><button class="btn_normal" name="btn_Preview" id="btn_Preview" type="button">Preview</button><!--
					--><button class="btn_normal" name="btn_InvPrint" id="btn_InvPrint" type="button">INV Print</button><!--
					--><button class="btn_normal" name="btn_FaxSend" id="btn_FaxSend" type="button">Fax Send</button><!--
					--><button class="btn_normal" name="btn_EmailSend" id="btn_EmailSend" type="button">E-mail Send</button><!--
					--><button class="btn_normal" name="btn_PayerInfo" id="btn_PayerInfo" type="button">Payer Info</button><!--
					--><button class="btn_normal" name="btn_ARIF" id="btn_ARIF" type="button">A/R I/F</button><!--
					--></div>	
				<!-- opus_design_btn (E) -->
				
				<!-- opus_design_inquiry(S) -->
				<div class="opus_design_inquiry" id="conditionLayer" style="display:inline;">
					<table>
						<tbody>
							<colgroup>
								<col width="70">
								<col width="130">
								<col width="150">
								<col width="370">
								<col width="55">
								<col width="*">
						    </colgroup>
							<tr>
								<th>Invoice No.</th>
								<td><input type="text" name="dmdt_inv_no" id="dmdt_inv_no" style="width:105px;" class="input2" readonly></td>
								<th>Issue Date/OFC/Name</th>
								<td><input type="text"	name="cre_dt" id="cre_dt" style="width:80px;" class="input2" readonly><!-- 
								 --><input type="text" name="cre_ofc_cd" id="cre_ofc_cd" style="width:50px;" class="input2" readonly><!-- 
								 --><input type="text"	name="cre_usr_nm" id="cre_usr_nm" 	style="width:180px;" class="input2" readonly></td>
								<th>Status</th>
								<td><input type="text" name="dmdt_inv_sts_nm" id="dmdt_inv_sts_nm" style="width:184px;" class="input2" readonly><!-- 
								 --><input type="hidden" name="dmdt_inv_sts_cd" id="dmdt_inv_sts_cd"></td>
							</tr>
						</tbody>
					</table>
					<table>
						<tbody>
							<colgroup>
								<col width="70">
								<col width="130">
								<col width="150">
								<col width="370">
								<col width="80">
								<col width="*">
						    </colgroup>
							<tr>
								<th>A/R I/F</th>
								<td><input type="text" name="dmdt_ar_if_cd" id="dmdt_ar_if_cd" style="width:105px;" class="input2" readonly></td>
								<th>A/R I/F Date/OFC/Name</th>
								<td><input type="text" name="ar_if_dt" id="ar_if_dt" style="width:80px;" class="input2" readonly><!-- 
								 --><input type="text" name="ar_if_ofc_cd" id="ar_if_ofc_cd" style="width:50px;" class="input2" readonly><!-- 
								 --><input type="hidden" name="ar_if_usr_id" id="ar_if_usr_id"><input type="text" name="ar_if_usr_nm" id="ar_if_usr_nm" style="width:180px;" class="input2" readonly></td>
								<th><span id="cr_nm">Credit Note</span></th>
								<td><input type="text" name="cr_inv_no" id="cr_inv_no" style="width:95px;" class="input2" readonly><!-- 
								 --><input type="text" name="cr_ar_yn" id="cr_ar_yn" style="width:60px;" class="input2" readonly></td>
							</tr>
						</tbody>
					</table>
					<table>
						<tbody>
							<colgroup>
								<col width="70">
								<col width="130">
								<col width="50">
								<col width="140">
								<col width="70">
								<col width="80">
								<col width="120">
								<col width="*">
						    </colgroup>
							<tr>
								<th>BKG No.</th>
								<td><input type="text" name="s_bkg_no" id="s_bkg_no" readonly style="width:105px;" class="input2"></td>
								<th>B/L No.</th>
								<td><input type="text" name="bl_no" id="bl_no" readonly style="width:100px;" class="input2" value=""></td>
								<th>Tariff Type</th>
								<td><input type="text" name="dmdt_trf_cd" id="dmdt_trf_cd" readonly style="width:50px;" class="input2" value=""></td>
								<th>Incl. CNTR Detail</th>
								<td>
									<select name="incCntrDtail" id="incCntrDtail" disabled style="width:60px;" class="input2"><!-- 
									 --><option value="Y" selected>Yes </option><!-- 
									 --><option value="N">No</option><!-- 
									 --></select>
								</td>
							</tr>
						</tbody>
					</table>
					<table>
						<tbody>
							<colgroup>
								<col width="70">
								<col width="130">
								<col width="50">
								<col width="80">
								<col width="30">
								<col width="70">
								<col width="30">
								<col width="70">
								<col width="30">
								<col width="70">
								<col width="30">
								<col width="*">
						    </colgroup>
							<tr>
								<th>VVD CD</th>
								<td><input type="text" name="vvd_cd" id="vvd_cd" readonly style="width:105px;" class="input2" value=""></td>
								<th title="Place of Receipt">POR</th>
								<td><input type="text" name="por_cd" id="por_cd" readonly style="width:50px;" class="input2" value=""></td>
								<th title="Port of Loading">POL</th>
								<td><input type="text" name="pol_cd" id="pol_cd" readonly style="width:50px;" class="input2" value=""></td>
								<th title="Port of Discharging">POD</th>
								<td><input type="text" name="pod_cd" id="pod_cd" readonly style="width:50px;" class="input2" value=""></td>
								<th title="Place of Delivery">DEL</th>
								<td><input type="text" name="del_cd" id="del_cd" readonly style="width:50px;" class="input2" value=""></td>
								<th>R/D</th>
								<td><input type="text" name="rd" id="rd" readonly style="width:33px;" class="input2" value=""></td>
							</tr>
						</tbody>
					</table>
					<table>
						<tbody>
							<colgroup>
								<col width="70">
								<col width="*">
						    </colgroup>
							<tr>
								<th>BKG Cust.</th>
								<td><input type="text" name="bkg_cust_cd" id="bkg_cust_cd" style="width:105px;" class="input2" readonly><!-- 
								 --><input type="text" name="bkg_cust_nm" id="bkg_cust_nm" style="width:433px;" class="input2" readonly></td>					
							</tr>
							<tr>
								<th>A/R Cust.</th>
								<td width=""><input type="text" name="act_cust_cd" id="act_cust_cd" style="width:105px;" class="input2" readonly><!-- 
								 --><input type="text" name="act_cust_nm" id="act_cust_nm" style="width:433px;" class="input2" readonly></td>					
							</tr>
						</tbody>
					</table>
					<table>
						<tbody>
							<colgroup>
								<col width="70">
								<col width="*">
						    </colgroup>
							<tr>
								<th>Payer</th>
								<td><input type="text" name="payer_cd" id="payer_cd" dataformat="engup" style="width:77px;" class="input1" maxlength="8" style="ime-mode:disabled"><!-- 
								 --><button type="button" class="input_seach_btn" name="btns_payer_cd" id="btns_payer_cd"></button><!-- 
								 --><input type="text" name="payer_nm" id="payer_nm" style="width:433px;" class="input2" readonly>
									<!-- <img src="img/btns_search.gif" name="btns_payer_cd" width="19"height="20"alt=""border="0"align="absmiddle"class="cursor"> -->
									
								</td>
							</tr>
						</tbody>
					</table>
					<table>
						<tbody>
							<colgroup>
								<col width="70">
								<col width="185">
								<col width="30">
								<col width="195">
								<col width="30">
								<col width="160">
								<col width="72">
								<col width="220"/>
								<col width="*">
						    </colgroup>
							<tr>
								<th>Attention</th>
								<td><script type="text/javascript">ComComboObject('attention', 4, 155, 1, 0, 0, true)</script></td>
								<th>Tel.</th>
								<td><input type="text" name="payr_cntc_pnt_phn_no" id="payr_cntc_pnt_phn_no" style="width:160px;" class="input2" readonly></td>
								<th>Fax</th>
								<td><input type="text" name="payr_cntc_pnt_fax_no" id="payr_cntc_pnt_fax_no" style="width:160px;" class="input2" readonly></td>
								<th>E-mail</th>
								<td><input type="text" name="payr_cntc_pnt_eml" id="payr_cntc_pnt_eml" style="width:100%;" class="input2" readonly></td>
								<td></td>
							</tr>
						</tbody>
					</table>
					<table>
						<tbody>
							<colgroup>
								<col width="70">
								<col width="610">
								<col width="70">
								<col width="90">
								<col width="70">
								<col width="*">
						    </colgroup>
							<tr>
								<th>Trucker</th>
								<td><input type="text" name="trucker_cd" id="trucker_cd" dataformat="engup" maxlength="6" style="ime-mode:disabled" style="width:77px;" class="input" value=""><!-- 
								 --><button type="button" class="input_seach_btn" name="btns_trucker_cd" id="btns_trucker_cd"></button><!-- 
								 --><input type="text" name="trucker_nm" id="trucker_nm" readonly style="width:430px;" class="input2" value="">
									<!-- <img src="img/btns_search.gif" name="btns_trucker_cd" width="19"height="20"alt=""border="0"align="absmiddle"class="cursor">&nbsp; -->								
								</td>
								<th>Due Date</th>
								<td><input type="text" name="due_date" id="due_date" style="width:80px;" class="input2" readOnly></td>
								<th> Credit Term</th>
								<td><input type="text" name="cr_term_dys" id="cr_term_dys" style="width:30px;" class="input2" readOnly>&nbsp;<b>day</b></td>
							</tr>
						</tbody>
					</table>
					<table>
						<tbody>
							<colgroup>
								<col width="70"/>
								<col width="606"/>
								<col width="74"/>
								<col width="80"/>
								<col width="85"/>
								<col width="55"/>
								<col width="*"/>
						    </colgroup>
							<tr>
								<td valign="top" name="txt_remark" id="txt_remark" rowspan="2" onmouseover="obj_mouseover()" onmouseout="obj_mouseout()"><b>Invoice<br>Remark(s)</b></td>
								<td><input type="text" name="inv_rmk1" id="inv_rmk1" maxlength="85" style="width:100%;" class="noinput" value=""></td>
								<th>Notice</th>
								<td><select name="ntc_knt_cd" style="width:70px;"><!-- 
									 --><option value=""></option><!-- 
									 --><option value="1">1st</option><!-- 
									 --><option value="2">2nd</option><!-- 
									 --><option value="3">3rd</option><!-- 
									 --><option value="9">Final</option>
									</select></td>
								<th>INV Over Day</th>
								<td><input type="text" name="over_day" id="over_day" readOnly style="width:30px;" class="input2" value="">&nbsp;<b>day</b></td>
								<td></td>
							</tr>
							<tr>
								<td><input type="text" name="inv_rmk2" id="inv_rmk2" maxlength="85" style="width:100%;" class="noinput" value=""></td>
								<th>Cust. Ref</th>
								<td colspan="3"><input type="text" name="inv_ref_no" id="inv_ref_no" maxlength="20" style="width:100%;" class="input" value=""></td>
								<td></td>
							</tr>
						</tbody>
					</table>
				</div>
				<!-- opus_design_inquiry(E) -->
				
				<!-- layout_wrap(S) -->
				<div class="layout_wrap" style="width:990px;">
				    <div class="layout_vertical_2">
				        <!-- opus_design_grid(S) -->
				        <div class="opus_design_grid">
				            <div class="opus_design_data" style="width:520px;">	
				            	<table><tr><td height="3" colspan="6"></td></tr></table>		            	
				            	<table style="width:520px;">
				            		<tbody>
				            			<colgroup>
											<col width="110"/>
											<col width="70"/>
											<col width="80"/>
											<col width="85"/>
											<col width="145"/>
											<col width="*"/>
									    </colgroup>
										<tr>
											<td><h3 class="title_design">Charge</h3></td>
											<td style="text-align:right;"><b>Charge Cur.&nbsp;</b></td>
											<td><input type="text" name="chg_curr_cd" id="chg_curr_cd" style="width:70px;" class="input" readOnly></td>
											<td class="sm" style="text-align:right;"><b>Billable AMT&nbsp;</b></td>
											<td><input type="text" name="mn_bil_amt" id="mn_bil_amt" readOnly style="width:100%;text-align:right"" class="noinput"/></td>
											<td>&nbsp;</td>
										</tr>
									</tbody>
								</table>
								<table><tr><td height="3" colspan="6"></td></tr></table>	
				            </div>
				            <script type="text/javascript">ComSheetObject('t2sheet1');</script>
				            <table><tr><td height="10"></td></tr></table>
				           	<h3 class="title_design">Rate Detail</h3>
				           	<table><tr><td height="3"></td></tr></table>
				            <script type="text/javascript">ComSheetObject('t2sheet2');</script>
				        </div>
				        <!-- opus_design_grid(E) -->
				    </div>
				    
				    <div class="layout_vertical_2">
				        <!-- opus_design_grid(S) -->
				        <div class="opus_design_grid" style="padding-left:20px;">
				            <div class="opus_design_data">
				            	<div class="layout_wrap">
								    <div class="layout_vertical_2" style="width:170px;">
								    	<table><tr><td height="3"></td></tr></table>
							           	<h3 class="title_design">Invoice</h3>
							           	<table><tr><td height="3"></td></tr></table>
							           	<div class="opus_design_inquiry">  
									        <table>
												<colgroup>
													<col width="70">
													<col width="*">
												 </colgroup>
												<tbody>											
													<tr>
														<th>INV Cur.</th>
														<td><input type="text" name="inv_curr_cd" id="inv_curr_cd" style="width:80px;text-align:left" class="input2" value="" readOnly></td>
													</tr>
													<tr>
														<th>Ex. Rate</th>
														<td><input type="text" name="inv_xch_rt" id="inv_xch_rt" readOnly style="width:80px;text-align:right" class="input2" value=""></td>
													</tr>
													<tr>
														<th>CNTR Q’ty</th>
														<td><input type="text" name="cntr_cnt" id="cntr_cnt" readOnly style="width:80px;text-align:right" class="input2" value=""></td>
													</tr>
												</tbody>
											</table>
										</div>
								    </div>
								    <div class="layout_vertical_2"style="width:300px;">
								      	<div class="opus_design_data" style="width:290px;">
										     <table class="grid_2">
												<tbody>
													<colgroup>
														<col width="100">
														<col width="60">
														<col width="70">
														<col width="*">
												    </colgroup>
													<tr>
														<th> Total AMT</th>
														<td colspan="2" class="input2"><input type="text" name="tot_amt" id="tot_amt" style="width:120px;text-align:right" class="noinput2" readOnly></td>
													</tr>
													<tr>
														<th> D/C by AMT or %</th>
														<td colspan="2" class="input2" align="right"><input type="text" name="dc_amt" id="dc_amt"  style="width:120px;text-align:right" class="noinput2" readOnly></td>
													</tr>
													<tr>
														<th> Billing AMT </th>
														<td colspan="2" class="input2"><input type="text" name="inv_chg_amt" id="inv_chg_amt" style="width:120px;text-align:right" class="noinput2" readOnly></td>
													</tr>
													<tr>
														<th> Tax Rate/ AMT </th>
														<td class="input2"><input type="checkbox" name="chk_tax" id="chk_tax"  checked value="" onclick="setTax()" class="trans">&nbsp;<!-- 
														 --><input type="text" name="tax_rto_dis" id="tax_rto_dis" readOnly style="width:30px;text-align:right" class="noinput2" readOnly>&nbsp;%</td>
														<td class="input2"><input type="text" name="tax_amt" id="tax_amt" readOnly style="width:60px;text-align:right" class="noinput2" value=""></td>
													</tr>
													<tr >
														<th> Payable AMT </th>
														<td colspan="2" class="input2"><input type="text" name="inv_amt" id="inv_amt" readOnly style="width:120px;text-align:right" class="noinput2" value=""></td>
													</tr>
												</tbody>
											</table>
										</div>
								    </div>
								</div>	
								<table><tr><td height="10"></td></tr></table>
					           	<h3 class="title_design">Manual Invoice Reason</h3>
					           	<table><tr><td height="3"></td></tr></table>							            	
				           		<table class="grid_2" style="width:465px;">
									<tbody>
										<colgroup>
											<col width="100"/>
											<col width="*"/>
									    </colgroup>	
										<tr>
											<th style="text-align:center;">Reason</th>
											<td><input type="text" name="reason" id="reason" value="SZPBB DEM Billing" style="width:100%;" class="input2" readonly></td>
																				</tr>
										<tr>
											<th style="text-align:center;">Remark(s)</th>
											<td><textarea name="mnl_inv_rmk" id="mnl_inv_rmk" style="width:100%;height:55px;resize:none;"></textarea></td>
										</tr>
									</tbody>
								</table>
				            </div>
				        </div>
				        <!-- opus_design_grid(E) -->
				    </div>
				</div>
				<!-- layout_wrap(E) -->
			</form>
		</div>
		
		
		<!-- hidden (S)--> 
		<div id="mainTable6" style=display:none;> 
			<script type="text/javascript">ComSheetObject('t2sheet3');</script>
		</div>
		<!-- hidden (E)-->
		
		<div id="topdeck" style="position:absolute;visibility:hidden;z-index:200px;"></div>
		
		<!-- RD OBJECT -->		
		<div id="mainTable7"> 
		</div>
		<input type="hidden" name="f_cmd" id="f_cmd" />
		<input type="hidden" name="pagerows" id="pagerows" />
		
		<input type="hidden" name="dmdt_chg_sts_cd" id="dmdt_chg_sts_cd" />
		<input type="hidden" name="chg_dc_amt" id="chg_dc_amt" />
		<input type="hidden" name="reason" value="SCM" id="reason" />
		<input type="hidden" name="success_yn" id="success_yn" />
		
		<!--  select condition -->
		<input type="hidden" name="s_ofc_cd" value="SZPBB" id="s_ofc_cd" />
		<input type="hidden" name="s_chg_type" id="s_chg_type" />
		<input type="hidden" name="s_dmdt_trf_cd" id="s_dmdt_trf_cd" />
		<input type="hidden" name="s_cntr_no" id="s_cntr_no" />
		<input type="hidden" name="s_cust_gubun" id="s_cust_gubun" />
		<input type="hidden" name="s_cust_cd" id="s_cust_cd" />
		<input type="hidden" name="invoice_issue" id="invoice_issue" />
		<input type="hidden" name="s_invoice_no" id="s_invoice_no" />
		<input type="hidden" name="dmdt_payr_cntc_pnt_nm" id="dmdt_payr_cntc_pnt_nm" />
		<input type="hidden" name="cust_cntc_pnt_seq" id="cust_cntc_pnt_seq" />
		<input type="hidden" name="vndr_cd" id="vndr_cd" />
		<input type="hidden" name="curr_cd" id="curr_cd" />
		<input type="hidden" name="rfa_no" id="rfa_no" />
		<input type="hidden" name="chg_type" id="chg_type" />
		<input type="hidden" name="ofc_cd" id="ofc_cd" />
		<input type="hidden" name="svr_id" id="svr_id" />
		<input type="hidden" name="cust_cnt_cd" id="cust_cnt_cd" />
		<input type="hidden" name="cust_seq" id="cust_seq" />
		<input type="hidden" name="tax_rto" id="tax_rto" />
		<input type="hidden" name="session_cnt_cd" value="<%=strUsr_Cnt_cd%>" id="session_cnt_cd" />
		<input type="hidden" name="bil_to_loc_div_cd" id="bil_to_loc_div_cd" />
		<input type="hidden" name="dmdt_chg_sts_cds" value="" id="dmdt_chg_sts_cds" />
		<input type="hidden" name="session_ofc_cd" value="<%=strUsr_ofc%>" id="session_ofc_cd" />
		<input type="hidden" name="session_email" value="<%=strUsr_eml %>" id="session_email" />
		<input type="hidden" name="session_usr_nm" value="<%=strUsr_nm %>" id="session_usr_nm" />
		<input type="hidden" name="session_usr_id" value="<%=strUsr_id%>" id="session_usr_id" />
		<input type="hidden" name="cre_cnt_cd" id="cre_cnt_cd" />
		<input type="hidden" name="cre_usr_id" id="cre_usr_id" />
		<input type="hidden" name="vndr_seq" id="vndr_seq" />
		<input type="hidden" name="vndr_nm" id="vndr_nm" />
		
		<!-- for searching Charge Cur list -->
		<input type="hidden" name="cnt_cd" value="<%=strUsr_Cnt_cd%>" id="cnt_cd" />
		<!-- for searching Reason list -->
		<input type="hidden" name="intg_cd_id" value="CD01975" id="intg_cd_id" />
		
		<!-- for saving  -->
		<input type="hidden" name="bkg_no" id="bkg_no" />
		<input type="hidden" name="caller" id="caller" />
		<input type="hidden" name="ofc_curr_date" id="ofc_curr_date" />
		
		<!-- C.REMARK, H.REMARK -->
		<input type="hidden" name="dmdt_cxl_rsn_cd" id="dmdt_cxl_rsn_cd" />
		<input type="hidden" name="dmdt_cxl_rsn_nm" id="dmdt_cxl_rsn_nm" />
		<input type="hidden" name="cxl_rmk" id="cxl_rmk" />
		<input type="hidden" name="inv_hld_rsn_cd" id="inv_hld_rsn_cd" />
		<input type="hidden" name="inv_hld_rsn_nm" id="inv_hld_rsn_nm" />
		<input type="hidden" name="inv_hld_rmk" id="inv_hld_rmk" />
		<input type="hidden" name="upd_dt" id="upd_dt" />
		<input type="hidden" name="upd_ofc_cd" id="upd_ofc_cd" />
		<input type="hidden" name="upd_usr_id" id="upd_usr_id" />
		<input type="hidden" name="upd_usr_nm" id="upd_usr_nm" />
		
		<!-- INVOICE TAX_RTO -->
		<input type="hidden" name="inv_tax_rto" id="inv_tax_rto" />
		
		<!-- PAYER INFO FAX,EMAIL SETTING -->
		<input type="hidden" name="payr_faxnos" id="payr_faxnos" />
		<input type="hidden" name="payr_emailnos" id="payr_emailnos" />
		<!-- EMAIL, FAX SENDING -->
		<input type="hidden" name="rd_fxeml_sys_cd" id="rd_fxeml_sys_cd" />
		<input type="hidden" name="rd_fxeml_file_name" id="rd_fxeml_file_name" />
		<input type="hidden" name="rd_fxeml_bat_flg" id="rd_fxeml_bat_flg" />
		<input type="hidden" name="rd_fxeml_title" id="rd_fxeml_title" />
		<input type="hidden" name="rd_fxeml_rd_param" id="rd_fxeml_rd_param" />
		<input type="hidden" name="rd_fxeml_fax_no" id="rd_fxeml_fax_no" />
		<input type="hidden" name="rd_fxeml_fax_sndr_id" id="rd_fxeml_fax_sndr_id" />
		<input type="hidden" name="rd_fxeml_eml_sndr_nm" id="rd_fxeml_eml_sndr_nm" />
		<input type="hidden" name="rd_fxeml_eml_sndr_add" id="rd_fxeml_eml_sndr_add" />
        <input type="hidden" name="rd_fxeml_eml_sndr_fixed" id="rd_fxeml_eml_sndr_fixed" />
		<input type="hidden" name="rd_fxeml_eml_rcvr_add" id="rd_fxeml_eml_rcvr_add" />
		<input type="hidden" name="rd_fxeml_eml_atch_file" id="rd_fxeml_eml_atch_file" />
		<input type="hidden" name="rd_fxeml_eml_templt" id="rd_fxeml_eml_templt" />
		<input type="hidden" name="rd_fxeml_eml_tmplt_param" id="rd_fxeml_eml_tmplt_param" />
		<input type="hidden" name="rd_fxeml_doc_tp" id="rd_fxeml_doc_tp" />
		<input type="hidden" name="payc" id="payc" />
		<input type="hidden" name="invno" id="invno" />
		
		
		<!-- parameters for existing SHEET SET -->
		<input type="hidden" name="has_sheetset" id="has_sheetset" />
		<input type="hidden" name="dmdt_sh_tp_cd" id="dmdt_sh_tp_cd" />
		
		<!-- preview -->
		<input type="hidden" name="org_dmdt_payr_cntc_pnt_nm" id="org_dmdt_payr_cntc_pnt_nm" />
		<input type="hidden" name="org_payr_cntc_pnt_phn_no" id="org_payr_cntc_pnt_phn_no" />
		<input type="hidden" name="org_payr_cntc_pnt_fax_no" id="org_payr_cntc_pnt_fax_no" />
		<input type="hidden" name="org_payr_cntc_pnt_eml" id="org_payr_cntc_pnt_eml" />
		
		<!-- Master RD -->
		<input type="hidden" name="rd_sh_addr1" id="rd_sh_addr1" />
		<input type="hidden" name="rd_sh_addr2" id="rd_sh_addr2" />
		<input type="hidden" name="rd_sh_addr3" id="rd_sh_addr3" />
		<input type="hidden" name="rd_invoice_title" id="rd_invoice_title" />
		<input type="hidden" name="rd_cancel_note" id="rd_cancel_note" />
		<input type="hidden" name="rd_cust_nm" id="rd_cust_nm" />
		<input type="hidden" name="rd_payr_addr" id="rd_payr_addr" />
		<input type="hidden" name="rd_attn_nm" id="rd_attn_nm" />
		<input type="hidden" name="rd_phn_no" id="rd_phn_no" />
		<input type="hidden" name="rd_fax_no" id="rd_fax_no" />
		<input type="hidden" name="rd_dmdt_inv_no" id="rd_dmdt_inv_no" />
		<input type="hidden" name="rd_issue_day" id="rd_issue_day" />
		<input type="hidden" name="rd_due_date" id="rd_due_date" />
		<input type="hidden" name="rd_due_day" id="rd_due_day" />
		<input type="hidden" name="rd_ntc_knt_cd" id="rd_ntc_knt_cd" />
		<input type="hidden" name="rd_cre_usr_nm" id="rd_cre_usr_nm" />
		<input type="hidden" name="rd_cust_cd" id="rd_cust_cd" />
		<input type="hidden" name="rd_inv_ref_no" id="rd_inv_ref_no" />
		<input type="hidden" name="rd_cust_vat_no" id="rd_cust_vat_no" />
		<input type="hidden" name="rd_sh_hd_n1st_msg" id="rd_sh_hd_n1st_msg" />
		<input type="hidden" name="rd_sh_hd_n2nd_msg" id="rd_sh_hd_n2nd_msg" />
		<input type="hidden" name="rd_sh_hd_n3rd_msg" id="rd_sh_hd_n3rd_msg" />
		<input type="hidden" name="rd_sh_hd_n4th_msg" id="rd_sh_hd_n4th_msg" />
		<input type="hidden" name="rd_sh_hd_n5th_msg" id="rd_sh_hd_n5th_msg" />
		<input type="hidden" name="rd_vvd_cd" id="rd_vvd_cd" />
		<input type="hidden" name="rd_vsl_eng_nm" id="rd_vsl_eng_nm" />
		<input type="hidden" name="rd_arr" id="rd_arr" />
		<input type="hidden" name="rd_dep" id="rd_dep" />
		<input type="hidden" name="rd_bl_no" id="rd_bl_no" />
		<input type="hidden" name="rd_bkg_no" id="rd_bkg_no" />
		<input type="hidden" name="rd_cmdt_nm" id="rd_cmdt_nm" />
		<input type="hidden" name="rd_dmdt_trf_cd" id="rd_dmdt_trf_cd" />
		<input type="hidden" name="rd_dmdt_trf_nm" id="rd_dmdt_trf_nm" />
		<input type="hidden" name="rd_bkg_rcv_term_nm" id="rd_bkg_rcv_term_nm" />
		<input type="hidden" name="rd_bkg_del_term_nm" id="rd_bkg_del_term_nm" />
		<input type="hidden" name="rd_pod" id="rd_pod" />
		<input type="hidden" name="rd_pod_nm" id="rd_pod_nm" />
		<input type="hidden" name="rd_del" id="rd_del" />
		<input type="hidden" name="rd_del_nm" id="rd_del_nm" />
		<input type="hidden" name="rd_trucker_nm" id="rd_trucker_nm" />
		<input type="hidden" name="rd_org_chg_amt" id="rd_org_chg_amt" />
		<input type="hidden" name="rd_org_curr_cd" id="rd_org_curr_cd" />
		<input type="hidden" name="rd_inv_xch_rt" id="rd_inv_xch_rt" />
		<input type="hidden" name="rd_tot_amt" id="rd_tot_amt" />
		<input type="hidden" name="rd_inv_curr_cd" id="rd_inv_curr_cd" />
		<input type="hidden" name="rd_dc_amt" id="rd_dc_amt" />
		<input type="hidden" name="rd_inv_chg_amt" id="rd_inv_chg_amt" />
		<input type="hidden" name="rd_tax_rto" id="rd_tax_rto" />
		<input type="hidden" name="rd_tax_amt" id="rd_tax_amt" />
		<input type="hidden" name="rd_inv_amt" id="rd_inv_amt" />
		<input type="hidden" name="rd_inv_rmk1" id="rd_inv_rmk1" />
		<input type="hidden" name="rd_inv_rmk2" id="rd_inv_rmk2" />
		<input type="hidden" name="rd_sh_rmk1" id="rd_sh_rmk1" />
		<input type="hidden" name="rd_sh_rmk2" id="rd_sh_rmk2" />
		<input type="hidden" name="rd_sh_rmk3" id="rd_sh_rmk3" />
		<input type="hidden" name="rd_sh_rmk4" id="rd_sh_rmk4" />
		<input type="hidden" name="rd_sh_rmk5" id="rd_sh_rmk5" />
		<input type="hidden" name="rd_sh_rmk6" id="rd_sh_rmk6" />
		<input type="hidden" name="rd_sh_rmk7" id="rd_sh_rmk7" />
		<input type="hidden" name="rd_sh_rmk8" id="rd_sh_rmk8" />
		<input type="hidden" name="rd_sh_rmk9" id="rd_sh_rmk9" />
		<input type="hidden" name="rd_sh_rmk10" id="rd_sh_rmk10" />
		<input type="hidden" name="rd_sh_rmk11" id="rd_sh_rmk11" />
		<input type="hidden" name="rd_sh_rmk12" id="rd_sh_rmk12" />
		<input type="hidden" name="rd_sh_rmk13" id="rd_sh_rmk13" />
		<input type="hidden" name="rd_sh_rmk14" id="rd_sh_rmk14" />
		<input type="hidden" name="rd_tax_amt_prn_flg" id="rd_tax_amt_prn_flg" />
		<input type="hidden" name="rd_phn_fax_prn_flg" id="rd_phn_fax_prn_flg" />
		<input type="hidden" name="rd_cust_vat_prn_flg" id="rd_cust_vat_prn_flg" />
		<input type="hidden" name="rd_dc_amt_flg" id="rd_dc_amt_flg" />
		<input type="hidden" name="rd_cust_ref_prn_flg" id="rd_cust_ref_prn_flg" />
		<input type="hidden" name="rd_days_disp" id="rd_days_disp" />
		<input type="hidden" name="rd_dmdt_inv_sts_cd" id="rd_dmdt_inv_sts_cd" />
		<input type="hidden" name="rd_cre_cnt_cd" id="rd_cre_cnt_cd" />
	</div>
</form>