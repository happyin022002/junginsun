<%
/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TPB_0109.jsp
*@FileTitle  : Invoice Setting 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/24
=========================================================
*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.bcm.sup.valuemanage.util.ConstantMgr"%>
<%@ page import="com.clt.apps.opus.esd.tpb.processmanage.invoicemanage.event.EsdTpb0109Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsdTpb0109Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Server Exception
	String strErrMsg = "";						//Error message
	int rowCount	 = 0;						//DB ResultSet list count
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String strUsr_id		= "";
	String strUsr_nm		= "";
	String ofc_cd = null;
	Logger log = Logger.getLogger("com.clt.apps.ProcessManage.InvoiceManage");
	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	ofc_cd = account.getOfc_cd();
	String readOnlyYn = "";
	String s_state = "";
	readOnlyYn = JSPUtil.getNull( request.getParameter("ReadOnlyYn") );
	s_state = JSPUtil.getNull( request.getParameter("s_state") );
	//out.println(s_state);
	if ( !readOnlyYn.equals("N") ) {
		ofc_cd = account.getOfc_cd();
	} else {
		ofc_cd = JSPUtil.getNull( request.getParameter("s_sheet_set_ofc_cd") );
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
<input id="f_cmd" name="f_cmd" type="hidden" />
<input id="pagerows" name="pagerows" type="hidden" />
<input id="iPage" name="iPage" type="hidden" />
<input id="ReadOnlyYn" name="ReadOnlyYn" value="<%=readOnlyYn%>" type="hidden" />
<input id="s_state" name="s_state" value="<%=s_state%>" type="hidden" />


<% if (s_state.equals("Y")){ %>
	<!-- OUTER - POPUP (S)tart -->
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title"><span>TPB Invoice Setting</span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn"><!-- 
			 --><button type="button" name="btn_retrieve" id="btn_retrieve" class="btn_accent">Retrieve</button><!-- 
			 --><button type="button" name="btn_new" id="btn_new" class="btn_normal">New</button><!--
			<!-- Repeat Pattern --><!-- 
					 --><% if ( !readOnlyYn.equals("N") ) { %><!-- 
						 --><button type="button" name="btn_save" id="btn_save" class="btn_normal">Save</button><!-- 
					 --><% } %><!-- 
					 --><% if (s_state.equals("Y")){ %><!-- 
						 --><button type="button" name="btn_close" id="btn_close" class="btn_normal">Close</button><!-- 
					 --><% } %><!-- 
			Repeat Pattern
		 --></div>
		<!-- opus_design_btn (E) -->
	</div>
	<!-- page_title_area(E) -->
	
	<div class="wrap_search ">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry">
			<table class="sm">
				<tbody>
					<colgroup>
						<col width="20" />
						<col width="50" />
						<col width="500" />
						<col width="*" />
					</colgroup>
					<tr >
						<td></td>
						<th>Office</th>
						<td><input id="s_inv_iss_ofc_cd" style="width: 55px;" name="s_inv_iss_ofc_cd" readonly value="<%=ofc_cd%>" type="text" /></td>
						<td></td> 
					</tr>
					<tr >
						<td></td>
						<th>Company Name</th>
						<td><input id="s_co_nm" style="width: 250px;" value="<%=ConstantMgr.getCompanyName()%> CO., LTD" onblur="ComChkLenByByte(this,50,'Company Name')" name="s_co_nm" maxlength="50" type="text" /> </td>
						<td></td> 
					</tr>
				</tbody>
			</table>
			<table>
				<tbody>
					<colgroup>
						<col width="10" />
						<col width="50" />
						<col width="150" />
						<col width="*" />
					</colgroup>
					<tr >
						<td></td>
						<th>Office Address</th>
						<td><input id="s_ofc_addr" style="width: 484px;" onblur="ComChkLenByByte(this,200,'Office Address')" name="s_ofc_addr" maxlength="200" type="text" /> </td>
						<td></td> 
					</tr>
					<tr >
						<td></td>
						<th>Tel No.</th>
						<td><input id="s_ofc_phn_no" style="width: 484px;" name="s_ofc_phn_no" maxlength="20" type="text" /> </td>
						<td></td> 
					</tr>
					<tr >
						<td></td>
						<th>Fax No.</th>
						<td><input id="s_ofc_fax_no" style="width: 484px;" name="s_ofc_fax_no" maxlength="20" type="text" /> </td>
						<td></td> 
					</tr>
				</tbody>
			</table>
			
			
			
			<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
			
			
			<table>
				<tbody>
					<colgroup>
						<col width="2" />
						<col width="50" />
						<col width="500" />
						<col width="*" />
					</colgroup>
					<tr >
						<td></td>
						<th>VAT Rate</th>
						<td><input id="s_vat_xch_rt" style="width: 55px; ime-mode:disabled;" name="s_vat_xch_rt" maxlength="15" dir="rtl" type="text" /> %</td>
						<td></td> 
					</tr>
					<tr >
						<td></td>
						<th>"Bill To" Location</th>
						<td><%=JSPUtil.getCodeCombo("s_bil_to_loc_div_cd", "", "style='width:71'", "CD00871", 0, "001: :&lt;&lt;Select&gt;&gt;")%></td>
						<td></td> 
					</tr>
				</tbody>
			</table>
			
						
			
			<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
			
			<table>
				<tbody>
					<colgroup>
						<col width="10" />
						<col width="50" />
						<col width="150" />
						<col width="*" />
					</colgroup>
					<tr >
						<td></td>
						<th>Remark 1</th>
						<td><textarea type="text" style="width: 484px" rows="5" name="s_inv_rmk1" onblur="ComChkLenByByte(this,4000,'Remark 1')"></textarea></td>
						<td></td> 
					</tr>
					<tr >
						<td></td>
						<th>Remark 2</th>
						<td><textarea type="text" style="width: 484px" rows="10" name="s_inv_rmk2" onblur="ComChkLenByByte(this,4000,'Remark 2')"></textarea></td>
						<td></td> 
					</tr>
				</tbody>
			</table>
		</div>
	<!-- opus_design_inquiry(E) -->
	</div>
<%} else{ %>
<!-- Outer Table (S)-->
<!-- OUTER - POPUP (S)tart -->
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title"><span id="title"></span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn">
			<button type="button" name="btn_retrieve" id="btn_retrieve" class="btn_accent">Retrieve</button><!-- 
			 --><button type="button" name="btn_new" id="btn_new" class="btn_normal">New</button><!-- 
			Repeat Pattern
					 --><% if ( !readOnlyYn.equals("N") ) { %><!-- 
						 --><button type="button" name="btn_save" id="btn_save" class="btn_normal">Save</button><!-- 
					 --><% } %><!-- 
					 --><% if (s_state.equals("Y")){ %><!-- 
						 --><button type="button" name="btn_close" id="btn_close" class="btn_normal">Close</button><!-- 
					 --><% } %><!-- 
			Repeat Pattern
		 --></div>
		<!-- opus_design_btn (E) -->
		<!-- page_location(S) -->
		<div class="location">
			<!-- location 내용 동적생성 (별도 코딩 불필요) -->
			<span id="navigation"></span>
		</div>
	</div>
	<!-- page_title_area(E) -->
	
	<div class="wrap_search ">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry">
			<table>
				<tbody>
					<colgroup>
						<col width="10" />
						<col width="50" />
						<col width="480" />
						<col width="*" />
					</colgroup>
					<tr >
						<td></td>
						<th>Office</th>
						<td><input id="s_inv_iss_ofc_cd" style="width: 70px;" name="s_inv_iss_ofc_cd" readonly value="<%=ofc_cd%>" type="text" /></td>
						<td></td> 
					</tr>
					<tr >
						<td></td>
						<th>Company Name</th>
						<td><input id="s_co_nm" style="width:250px;" value="<%=ConstantMgr.getCompanyName()%> CO., LTD" onblur="ComChkLenByByte(this,50,'Company Name')" name="s_co_nm" maxlength="50" type="text" /> </td>
						<td></td> 
					</tr>
				</tbody>
			</table>
			<table>
				<tbody>
					<colgroup>
						<col width="14" />
						<col width="50" />
						<col width="150" />
						<col width="*" />
					</colgroup>
					<tr >
						<td></td>
						<th>Office Address</th>
						<td><input id="s_ofc_addr" style="width: 484px;" onblur="ComChkLenByByte(this,200,'Office Address')" name="s_ofc_addr" maxlength="200" type="text" /></td>
						<td></td> 
					</tr>
					<tr >
						<td></td>
						<th>Tel No.</th>
						<td><input id="s_ofc_phn_no" style="width: 484px;" name="s_ofc_phn_no" maxlength="20" type="text" /> </td>
						<td></td> 
					</tr>
					<tr >
						<td></td>
						<th>Fax No.</th>
						<td><input id="s_ofc_fax_no" style="width: 484px;" name="s_ofc_fax_no" maxlength="20" type="text" /> </td>
						<td></td> 
					</tr>
				</tbody>
			</table>
			
			<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
			
			<table>
				<tbody>
					<colgroup>
						<col width="2" />
						<col width="50" />
						<col width="150" />
						<col width="*" />
					</colgroup>
					<tr >
						<td></td>
						<th>VAT Rate</th>
						<td><input id="s_vat_xch_rt" style="width: 55px; ime-mode:disabled;" name="s_vat_xch_rt" maxlength="15" dir="rtl" type="text" />  %</td>
						<td></td> 
					</tr>
					<tr >
						<td></td>
						<th>"Bill To" Location</th>
						<td><%=JSPUtil.getCodeCombo("s_bil_to_loc_div_cd", "", "style='width:71'", "CD00871", 0, "001: :&lt;&lt;Select&gt;&gt;")%></td>
						<td></td> 
					</tr>

				</tbody>
			</table>			
			
			<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
			
			<table>
				<tbody>
					<colgroup>
						<col width="42" />
						<col width="50" />
						<col width="150" />
						<col width="*" />
					</colgroup>
					<tr >
						<td></td>
						<th>Remark 1</th>
						<td><textarea style="width: 484px;resize:none;" rows="5" name="s_inv_rmk1" id="s_inv_rmk1" onblur="ComChkLenByByte(this,4000,'Remark 1')"></textarea></td>
						<td></td> 
					</tr>
					<tr >
						<td></td>
						<th>Remark 2</th>
						<td><textarea style="width: 484px;resize:none;" rows="10" name="s_inv_rmk2" id="s_inv_rmk2" onblur="ComChkLenByByte(this,4000,'Remark 2')"></textarea></td>
						<td></td> 
					</tr>
				</tbody>
			</table>
		</div>
	<!-- opus_design_inquiry(E) -->
	</div>
<%}%>

<div class="wrap_result">
	<div class="opus_design_grid" style="display: none;">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>	
</form>