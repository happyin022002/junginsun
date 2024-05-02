<%
/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_PSO_0004.jsp
*@FileTitle  : Tariff List 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/05
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
<%@ page import="com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.event.VopPso0004Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopPso0004Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg 		= "";						//error message
	int rowCount	 		= 0;						//count of DB resultSET list
	String successFlag 		= "";
	String codeList  		= "";
	String pageRows  		= "100";
	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_Ofc_cd    = "";
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
		event = (VopPso0004Event)request.getAttribute("Event");
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
// 			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form" id="form">
<input id="f_cmd" name="f_cmd" type="hidden" />
<input id="pagerows" name="pagerows" type="hidden" />
<input id="sXml" name="sXml" type="hidden" />
<input id="csearch" name="csearch" value="" type="hidden" />
<input id="acct_cd" name="acct_cd" value="" type="hidden" />
<input id="yd_chg_no" name="yd_chg_no" value="" type="hidden" />
<input id="yd_chg_ver_seq" name="yd_chg_ver_seq" value="" type="hidden" />
<input id="year" name="year" value="" type="hidden" />
<input id="copy_condition" name="copy_condition" value="" type="hidden" />
<input id="moved_from" name="moved_from" value="<%=movedFrom%>" type="hidden" />
<input id="moved_params" name="moved_params" value="<%=movedParams%>" type="hidden" />

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
<!-- page_title_area(E) -->

<div class="wrap_search">
<!-- opus_design_inquiry(S) -->
<div class="opus_design_inquiry">
	<table>
		<tbody>
			<colgroup>
				<col width="10" />
				<col width="30" />
				<col width="170" />
				<col width="70" />
				<col width="370" />
				<col width="70" />
				<col width="300" />
				<col width="*" />
			</colgroup>
			<tr>
				<td></td>
				<th>Port</th>
				<td><input name="port_cd" id="port_cd" dataformat="engup" style="width: 60px;" class="input1" value="" size="5" maxlength="5" type="text"/><button class="input_seach_btn" name="btn_port_cd" id="btn_port_cd" type="button"></button><script type="text/javascript">ComComboObject('combo1',2, 50, 0, 1);</script></td>
				<th>Account CD</th>
				<td><script type="text/javascript">ComComboObject('combo2',2, 104, 0, 1);</script><input id="account_nm" name="account_nm" style="width: 225px; text-align:left" class="input2" value="" readonly type="text" /></td>
				<th>Cost  CD</th>
				<td><script type="text/javascript">ComComboObject('combo3',2, 90, 0, 1);</script><input id="lgs_cost_nm" name="lgs_cost_nm" style="width: 400px;text-align:left" class="input2" value="" readonly type="text" /></td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<th></th>
				<td></td>
				<th>Service Provider</th>
				<td><input id="vndr_seq" name="vndr_seq" style="width: 75px; text-align:center" class="input1" value="" dataformat="num" maxLength="6" type="text" /><button class="input_seach_btn" name="btns_VendorSeq" id="btns_VendorSeq" type="button"></button><input id="vndr_lgl_eng_nm" name="vndr_lgl_eng_nm" style="width: 225px; text-align:left" class="input2" value="" readonly type="text" /></td>
				<th>Remarks</th>
				<td><input id="org_vndr_nm" name="org_vndr_nm" style="width: 495px; text-align:left" class="input" value="" type="text" maxLength="500"/></td>
				<td style="text-align:left;"><span id="info_byte" style="color: #005CB9;padding-left: 5px;"></span></td>
			</tr>
			<tr>
				<td></td>
				<th></th>
				<td></td>
				<th>Effective Date</th>
				<td><input id="from_date" name="from_date" dataformat="ymd" maxlength="8" style="width: 75px; ime-mode:disabled" class="input1" value="" type="text" /><button class="calendar ir" name="btns_Calendar1" id="btns_Calendar1" type="button"></button>~ <input id="to_date" name="to_date" dataformat="ymd" style="width: 75px; ime-mode:disabled" class="input1" value="" type="text"/><button class="calendar ir" name="btns_Calendar2" id="btns_Calendar2" type="button"></button><!-- 
				 --><label style="font-weight: bold;">Ver.</label><script type="text/javascript">ComComboObject('combo4',3, 69, 0, 1);</script></td>
				<th>Currency</th>
				<td><script type="text/javascript">ComComboObject('combo5',2, 90, 0, 1);</script></td>
				<td></td>
			</tr>
		</tbody>
	</table>
	<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
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
<!-- opus_design_inquiry(E) -->

</div>

<div class="wrap_result">
<!-- layout_wrap (S) -->
<div class="layout_wrap">
    <div class="layout_vertical_2 sm" style="width: 40%">
        <!-- opus_design_grid(S) -->
         <div class="opus_design_grid">
         <span class="title_s" style="color: #005CB9; font-weight: bold; padding-left: 20px;">*Base</span>
            <div class="opus_design_btn">
					<button type="button" class="btn_accent" name="btn_RowAdd" id="btn_RowAdd">Row Add</button>
					<button type="button" class="btn_normal" name="btn_Delete" id="btn_Delete">Row Delete</button>
			</div>
			<script type="text/javascript">ComSheetObject('sheet1');</script>
        </div>
        <!-- opus_design_grid(E) -->
        <span class="title_s" style="color: #005CB9; font-weight: bold; padding-left: 20px;">*Formula</span>
        <div id="foml_desc" style="width: 99%; height: 100px; border: double 1px; overflow-y: auto; overflow-x: hidden; padding: 2px; border-color: #000000; background-color:#FFFFFF;"></div>
        
        <span class="title_s" style="color: #005CB9; font-weight: bold; padding-left: 20px;">*Condition</span>
        <div id="cond_desc" style="width: 99%; height: 100px; border: double 1px; overflow-y: auto; overflow-x: hidden; padding: 2px; border-color: #005CB9; background-color:#FFFFFF;"></div>
        
    </div>
    
    <div class="layout_vertical_2" style="width: 2%;">
       <table>
       		<tr>
       			<td>&nbsp;</td>
       		</tr>
       </table>
    </div>
    
    <div class="layout_vertical_2" style="width: 58%">
        <!-- opus_design_grid(S) -->
        <div class="opus_design_grid">
            <div class="opus_design_btn">
					<button type="button" class="btn_accent" name="btn_RowAdd2" id="btn_RowAdd2">Row Add</button>
					<button type="button" class="btn_normal" name="btn_Delete2" id="btn_Delete2">Row Delete</button>
					<button type="button" class="btn_normal" name="btn_GridCopy" id="btn_GridCopy">Grid Copy</button>
			</div>
			<script type="text/javascript">ComSheetObject('sheet2');</script>
        </div>
        <div class="opus_design_grid">
			<script type="text/javascript">ComSheetObject('sheet3');</script>
        </div>
        <!-- opus_design_grid(E) -->
    </div>
    <!-- opus_design_grid(S) -->
	<div class="opus_design_grid" id="div_surcharge" style="display: none;" >
		<div class="opus_design_grid">
			<h3 class="title_design mar_btm_8">Surcharge</h3>
			<div class="opus_design_btn">
				<button type="button" class="btn_accent" name="btn_RowAdd4" id="btn_RowAdd4">Row Add</button>
				<button type="button" class="btn_normal" name="btn_Delete4" id="btn_Delete4">Row Delete</button>
			</div>
			<script type="text/javascript">ComSheetObject('sheet4');</script>
		</div>
	</div>
	<!-- opus_design_grid(E) -->
			 
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" id="div_discount" style="display: none;" >
		<div class="opus_design_grid">
			<h3 class="title_design mar_btm_8">Discount</h3>
			<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_RowAdd5" id="btn_RowAdd5">Row Add</button>
			<button type="button" class="btn_normal" name="btn_Delete5" id="btn_Delete5">Row Delete</button>
			</div>
		</div>
		<script type="text/javascript">ComSheetObject('sheet5');</script>
	</div>
	<!-- opus_design_grid(E) -->
	<!-- opus_design_grid(S) -->
     <div class="opus_design_grid" id="div_base_dummy" style="display: none;" >
		<script type="text/javascript">ComSheetObject('sheet6');</script>
     </div>
	<!-- opus_design_grid(E) -->
	
	<!-- opus_design_grid(S) -->
      <div class="opus_design_grid" id="div_dummy" style="display: none;"  >
		<script type="text/javascript">ComSheetObject('sheet7');</script>
      </div>
	<!-- opus_design_grid(E) -->
</div>
<!-- layout_wrap (E) -->
</div>
</form>
