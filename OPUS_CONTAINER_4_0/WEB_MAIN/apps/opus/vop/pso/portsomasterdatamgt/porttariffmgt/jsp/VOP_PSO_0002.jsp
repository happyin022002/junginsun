<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_PSO_0002.jsp
*@FileTitle  : Service Provider Help
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
<%@ page import="com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.event.VopPso0002Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopPso0002Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_Ofc_cd      = "";

	Logger log = Logger.getLogger("com.clt.apps.PortSOMasterDataMgt.PortTariffMgt"); 
	
	String sType = request.getParameter("type") == null ? "B" : request.getParameter("type");
	
	//from VOP_PSO_0036 
	String movedFrom = request.getParameter("moved_from") == null ? "" : request.getParameter("moved_from");
	String movedParams = request.getParameter("moved_params") == null ? "" : request.getParameter("moved_params");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_Ofc_cd = account.getOfc_cd();
	   
		event = (VopPso0002Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
	strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		
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

<form name="form" id="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="sXml" id="sXml" />
<input type="hidden" name="csearch" value="" id="csearch" />
<input type="hidden" name="acct_cd" value="" id="acct_cd" />
<input type="hidden" name="yd_chg_no" value="" id="yd_chg_no" />
<input id="year" name="year" value="" type="hidden" />
<input type="hidden" name="yd_chg_ver_seq" value="" id="yd_chg_ver_seq" />
<input type="hidden" name="copy_condition" value="" id="copy_condition" />

<input type="hidden" name="moved_from" value="<%=movedFrom%>" id="moved_from" />
<input type="hidden" name="moved_params" value="<%=movedParams%>" id="moved_params" />
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
			<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_New" id="btn_New">New</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_DataDelete" id="btn_DataDelete">Delete</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_Save" id="btn_Save">Save</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_Copy" id="btn_Copy">Copy</button><!--
		--><button type="button" class="btn_normal" name="btn1_Tariff_Inquiry" id="btn1_Tariff_Inquiry">Tariff Inquiry</button>
	</div>
	<!-- opus_design_btn(E) -->
	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<div class= "wrap_search">
<!-- opus_design_inquiry(S) -->
	<div class= "opus_design_inquiry">
		<table>
			<colgroup>
				<col width="40px">
				<col width="100px">
				<col width="90px">
				<col width="350px">
				<col width="52px">	
				<col width="300px" />		
				<col width="*">
			</colgroup>
			<tbody>
			<tr>
				<th>Port</th>
				<td><input name="port_cd" id="port_cd" dataformat="engup" style="width: 60px;" class="input1" value="" size="5" maxlength="5" type="text"/><!-- 
				 --><button type="button" id="btn_port_cd" name="btn_port_cd" class="input_seach_btn"></button><script type="text/javascript">ComComboObject('combo1',2, 50, 0, 1);</script></td>
				<th>Account CD</th>
				<td><script type="text/javascript">ComComboObject('combo2',2, 102, 0, 1,0);</script><input type="text" name="account_nm" style="width: 222px; text-align: left" class="input2" value="" readonly id="account_nm" /> </td>
				<th>Cost CD</th>
				<td><script type="text/javascript">ComComboObject('combo3',2, 90, 0, 1);</script><input type="text" name="lgs_cost_nm" style="width: 400px; text-align: left" class="input2" value="" readonly id="lgs_cost_nm" /> </td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<th>Service Provider</th>
				<td><input type="text" name="vndr_seq" style="width: 73px; text-align: center" class="input1" value="" dataformat="num" maxLength="6" id="vndr_seq" /><button type="button" id="btns_VendorSeq" name="btns_VendorSeq" class="input_seach_btn"></button><input type="text" name="vndr_lgl_eng_nm" style="width: 223px; text-align: left" class="input2" value="" readonly id="vndr_lgl_eng_nm" /> </td>
				<th>Remarks</th>
				<td><input type="text" name="org_vndr_nm" style="width: 494px; text-align: left" class="input" value="" id="org_vndr_nm" maxLength="500"/> </td>
				<td style="text-align:left;"><span id="info_byte" style="color: #005CB9;padding-left: 5px;"></span></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<th>Effective Date</th>
				<td><input name="from_date" type="text" dataformat="ymd" maxlength="8" style="width: 73px; ime-mode: disabled" class="input1" value="" id="from_date" /><!-- 
				 --><button type="button" id="btns_Calendar1" name="btns_Calendar1" class="calendar ir"></button>~<!-- 
				 --> <input type="text" name="to_date" dataformat="ymd" style="width: 73px; ime-mode: disabled" class="input1" value="" id="to_date" /><!-- 
				 --><button type="button" id="btns_Calendar2" name="btns_Calendar2" class="calendar ir"></button><!-- 
				 --><label style="font-weight: bold;">Ver.</label> <script type="text/javascript">ComComboObject('combo4',3, 69, 0, 1);</script></td>
				<th>Currency</th>
				<td><script type="text/javascript">ComComboObject('combo5',2, 90, 0, 1);</script></td>
				<td></td>
			</tr>
		</tbody>
		</table>
		<table class="line_bluedot"><tr><td colspan="6"></td></tr> </table>
		<table>
			<colgroup>
				<col width="40px">
				<col width="*">	
			</colgroup>
			<tbody>
			<tr>
				<td></td>
				<td style="text-align:left;"><input type="checkbox" name="cSur" id="cSur" value="" class="trans" ><label for= "cSur"><b>Surcharge</b></label><!-- 
				 --><input type="checkbox" name="cDis" id ="cDis" value="" class="trans" ><label for= "cDis"><b>Discount</b></label><!-- 
				 --><input type="checkbox" name="cpls_flg" id="cpls_flg" value="Y" class="trans" disabled><label for= "cpls_flg"><b>Compulsory</b></label></td>
			</tr>
			</tbody>
		</table>
</div>
</div>
<div class="wrap_result">
<div id="div_base">
	<!-- opus_design_grid(S) -->
	<div>	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid clear">
	<h3 style="margin-bottom:0" class="title_design">Base</h3>
		<div class="opus_design_btn">
				<button type="button" class="btn_normal" name="btn_RowAdd" id="btn_RowAdd">Row Add</button>
				<button type="button" class="btn_normal" name="btn_Delete" id="btn_Delete">Row Delete</button>			
		</div>
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	</div>
</div>
	
	

<div id="div_surcharge" style="display: none;"><!-- Surcharge (S) -->
	<!-- opus_design_grid(S) -->
	<div>	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid clear">
	<h3 style="margin-bottom:0" class="title_design">Surcharge</h3>
		<div class="opus_design_btn">
				<button type="button" class="btn_normal" name="btn_RowAdd2" id="btn_RowAdd2">Row Add</button><!-- 
				 --><button type="button" class="btn_normal" name="btn_Delete2" id="btn_Delete2">Row Delete</button>			
		</div>
		<script type="text/javascript">ComSheetObject('sheet2');</script>
	</div>
	</div>
</div>
<div id="div_discount" style="display: none;">
<!-- opus_design_grid(S) -->
	<div>	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid clear" >
	<h3 style="margin-bottom:0" class="title_design">Discount</h3>
		<div class="opus_design_btn">
				<button type="button" class="btn_normal" name="btn_RowAdd3" id="btn_RowAdd3">Row Add</button><!-- 
				 --><button type="button" class="btn_normal" name="btn_Delete3" id="btn_Delete3">Row Delete</button>			
		</div>
		<script type="text/javascript">ComSheetObject('sheet3');</script>
	</div>
	</div>
</div>

<div class="opus_design_grid clear" id="mainTable" style="display: none">
			<script type="text/javascript">ComSheetObject('sheet4');</script>
</div>
</div>
</form>
