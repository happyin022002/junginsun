<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_0367_01.jsp
*@FileTitle  : P/O & Other No.
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.event.EsmBkg036701Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg036701Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.GeneralBookingConduct.GeneralBookingReceipt");
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		event = (EsmBkg036701Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
	} catch(Exception e) {
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


<form name="form" onKeyUp="ComKeyEnter('LengthNextFocus')">
<input id="f_cmd" name="f_cmd" type="hidden" />
<input id="pagerows" name="pagerows" type="hidden" />
<input id="bkg_no" name="bkg_no" value="<%=JSPUtil.getParameter(request, "bkg_no")%>" type="hidden" />
<input id="popuptpcd" name="popuptpcd" value="<%=JSPUtil.getParameter(request, "popUpTpCd")%>" type="hidden" />
<input id="xter_sndr_id" name="xter_sndr_id" value="<%=JSPUtil.getParameter(request, "xter_sndr_id")%>" type="hidden" />
<input id="xter_rqst_no" name="xter_rqst_no" value="<%=JSPUtil.getParameter(request, "xter_rqst_no")%>" type="hidden" />
<input id="xter_rqst_seq" name="xter_rqst_seq" value="<%=JSPUtil.getParameter(request, "xter_rqst_seq")%>" type="hidden" />
<input id="callback_func" name="callback_func" value="<%=JSPUtil.getParameter(request, "func")%>" type="hidden" />
<input id="cntr_no" name="cntr_no" value="" type="hidden" />
<input id="cb_cntr_no" name="cb_cntr_no" value="" type="hidden" />

<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>P/O & Other No.</span></h2>
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_Save" id="btn_Save">Save</button><!--  
			--><button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button>
		</div>
	</div>

</div>

<div class="layer_popup_contents">
	<div class="wrap_search_tab">
		<div class="opus_design_inquiry">
				<table>
					<colgroup>
						<col width="50"/>
						<col width="120"/>
						<col width="150"/>
						<col width="155"/>
						<col width="50"/>
						<col width="20"/>
						<col width="50"/>
						<col width="150"/>
						<col width="*"/>
					</colgroup>
					<tbody>
					<tr>
						<th>Booking No.</th>	
						<td><input type="text" style="width:100px;" class="input2" name="vbkg_no" value="" readonly></td>
						<td></td>
						<td></td>						
						<th>B/L No.</th>	
						<td><input type="text" style="width:100px;" class="input2" name="vbl_no" value="" readonly></td>
						<td></td>
						<td></td>
						<td></td>				
					</tr>
					<tr>
						<th>P/O No.</th>	
						<td><input type="text" style="width:100px;" class="input" name="bkpo" maxlength="50" value=""></td>		
						<td class="sm"><input type="checkbox" value="" name='check_bkpo' id="CHK01" class="trans" onClick="javascript:copyToDesc(this);"><label id="CHK01">Copy to Description</label> </td>
						<td></td>						
						<th>L/C No.</th>	
						<td><input type="text" style="width:100px;" class="input" name="lcno" maxlength="50" value=""></td>	
						<td></td>		
						<td class="sm"><input type="checkbox" value="" name='check_lcno' id="CHK02" class="trans" onClick="javascript:copyToDesc(this);"><label id="CHK02">Copy to Description</label> </td>
						<td></td>						
					</tr>
					<tr>
						<th>Invoice No.</th>	
						<td><input type="text" style="width:100px;" class="input" name="hinv" maxlength="50" value=""></td>		
						<td class="sm"><input type="checkbox" value="" name='check_hinv' id="CHK03" class="trans" onClick="javascript:copyToDesc(this);"><label id="CHK03">Copy to Description</label> </td>
						<td></td>						
						<th>L/C Date</th>	
						<td><input type="text" style="width:100px;" class="input" name="lcdt" value="" maxlength="10" dataformat="ymd" style="ime-mode:disabled" caption="L/C Date"><button type="button" class="calendar ir" name="btn_Calendar" id="btn_Calendar"></button></td>
						<td></td>		
						<td class="sm"><input type="checkbox" value="" name='check_lcdt' id="CHK04" class="trans" onClick="javascript:copyToDesc(this);"><label id="CHK04">Copy to Description</label></td>
						<td></td>						
					</tr>
					<tr>
						<th>Department No.</th>	
						<td><input type="text" style="width:100px;" class="input" name="hpdp" maxlength="50" value=""></td>		
						<td class="sm"><input type="checkbox" value="" name='check_hpdp' id="CHK05" class="trans" onClick="javascript:copyToDesc(this);"><label id="CHK05">Copy to Description</label></td>
						<td></td>						
						<th>Other Ref. No.</th>	
						<td><input type="text" style="width:100px;" class="input" name="othr" maxlength="50" value=""></td>		
						<td width=""></td>	
						<td class="sm"><input type="checkbox" value="" name='check_othr' id="CHK06" class="trans" onClick="javascript:copyToDesc(this);"><label id="CHK06">Copy to Description</label></td>
						<td></td>						
					</tr> 
					<tr>
						<th>Incoterms</th>	
						<td><input type="text" style="width:100px;" class="input" name="inco" maxlength="50" value=""></td>		
						<td class="sm"><input type="checkbox" value="" name='check_inco' id="CHK07" class="trans" onClick="javascript:copyToDesc(this);"><label id="CHK07">Copy to Description</label> </td>
						<td></td>
						<td width=""></td>	
						<td width=""></td>		
						<td width=""></td>	
						<td class="sm"></td>
						<td></td>						
					</tr> 
					</tbody>
				</table>
		</div>
	</div>
	
	<div class="wrap_result">
		<div class="opus_design_tab" > 
			<script >ComTabObject('tab1')</script>
		</div>
		
		<div id="tabLayer" style="display: inline">
			<div class="opus_design_grid">
			
			<div class="layout_wrap">
			    <div class="layout_vertical_2 pad_rgt_4" style="width:35%">
					<div class="opus_design_btn" id="div_Cntr_Del" style="visibility:hidden">
						<button type="button" class="btn_normal" name="btn1_Cntr_Delete" id="btn1_Cntr_Delete">CNTR Delete</button>
					</div>
			        <div class="opus_design_grid">
			        	<script type="text/javascript">ComSheetObject('sheet1');</script>
			        </div>
			    </div>
			    <div class="layout_vertical_2" style="width:65%">
					<div class="opus_design_btn">
						<button type="button" class="btn_normal" name="btn1_Row_Add" id="btn1_Row_Add">Row Add</button>
						<button type="button" class="btn_normal" name="btn1_Row_Delete" id="btn1_Row_Delete">Row Delete</button>
						<button type="button" class="btn_normal" name="btn2_Copy_from" id="btn2_Copy_from">Copy from C/M</button>
					</div>
			        <div class="opus_design_grid">
			        	<script type="text/javascript">ComSheetObject('sheet2');</script>
			        </div>
			    </div>
			</div>
			</div>
		
		</div>
		
		<div id="tabLayer" style="display:none">
			 <div class="opus_design_grid">
				<div class="opus_design_btn">
					<button type="button" class="btn_normal" name="btn2_Row_Add" id="btn2_Row_Add">Row Add</button>
					<button type="button" class="btn_normal" name="btn2_Row_Delete" id="btn2_Row_Delete">Row Delete</button>
					<button type="button" class="btn_normal" name="btn2_Copy_Desc" id="btn2_Copy_Desc">Copy&nbsp;to&nbsp;Description</button>
				</div>
				<script type="text/javascript">ComSheetObject('sheet3');</script>
	        </div>
		</div>
		<div id="tabLayer" style="display:none">
			 <div class="opus_design_grid">
				<div class="opus_design_btn">
					<button type="button" class="btn_normal" name="btn3_Row_Add" id="btn3_Row_Add">Row Add</button>
					<button type="button" class="btn_normal" name="btn3_Row_Delete" id="btn3_Row_Delete">Row Delete</button>
				</div>
				<script type="text/javascript">ComSheetObject('sheet4');</script>
	        </div>
		</div>
	
		<div class="opus_design_inquiry" style="margin-top:30px">
			<table>
				<colgroup>
				
					<col width="55%"/>
					<col width="50"/>
					<col width="500"/>
					<col width="*"/>
				</colgroup>
				<tbody>
					<tr>
						<td></td>	
						<th>Total</th>	
						<td>
							<input type="text" style="width:90px;text-align:right" class="input2"  name="t_pck_qty" value="" readonly><!--  
							--><input type="text" style="width:90px;text-align:right" class="input2" name="t_cntr_mf_wgt" value="" readonly><!--
							--><input type="text" style="width:90px;text-align:right" class="input2" name="t_meas_qty" value="" readonly>
						</td>
						<td></td>			
					</tr>   	
					<tr>
						<td></td>	
						<th>Container Total</th>	
						<td>
							<input type="text" style="width:90px;text-align:right" class="input2"  name="pck_qty" value="" readonly><!--
							--><input type="text" style="width:90px;text-align:right" class="input2" name="cntr_mf_wgt" value="" readonly><!--
							--><input type="text" style="width:90px;text-align:right" class="input2" name="meas_qty" value="" readonly>
						</td>
						<td></td>						
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	
	<div id="manItmLayer" style="display:none">
		<div class="opus_design_inquiry">
			<table>
				<tbody>
					<tr>
					    <td width="6"></td>
						<td class="bg">
							<input type="text" style="width:90%;background-color:yellow;font-weight:bold;" class="input2" name="vManItm" value="" readonly>
						</td>
						<td width="6"></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	<!-- Mandatory (E) -->
	<div class="opus_design_grid" id="Layer1" style="display:none;">
	    <script type="text/javascript">ComSheetObject('sheet5');</script>
	    <script type="text/javascript">ComSheetObject('sheet6');</script>
	</div>
</div>
</form>