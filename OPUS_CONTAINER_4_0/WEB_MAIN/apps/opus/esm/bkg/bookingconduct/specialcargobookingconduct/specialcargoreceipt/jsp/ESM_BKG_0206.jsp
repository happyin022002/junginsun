<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0206.jsp
*@FileTitle  :  DG Package Q'ty & Type
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/08
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.event.EsmBkg0206Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0206Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//serverException
	String strErrMsg = "";						//error massage
	int rowCount	 = 0;						//DB ResultSet list count

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";

	String in_imdg_pck_cd1 = ""; 
	String in_imdg_pck_cd2 = "";  
	String intmd_imdg_pck_cd1 = ""; 
	String intmd_imdg_pck_cd2 = "";  
	String out_imdg_pck_cd1 = "";  
	String out_imdg_pck_cd2 = "";  
	String in_imdg_pck_desc1 = "";  
	String in_imdg_pck_desc2 = "";  
	String intmd_imdg_pck_desc1 = "";  
	String intmd_imdg_pck_desc2 = "";  
	String out_imdg_pck_desc1 = "";  
	String out_imdg_pck_desc2 = "";  
	String in_imdg_pck_qty1 = "";  
	String in_imdg_pck_qty2 = ""; 
	String intmd_imdg_pck_qty1 = "";  
	String intmd_imdg_pck_qty2 = ""; 
	String out_imdg_pck_qty1 = "";  
	String out_imdg_pck_qty2 = "";   
	String max_in_pck_qty = "";   
	String max_in_pck_tp_cd = "";   
	String hcdg_intmd_bc_rstr_desc = "";   
	String hcdg_pck_rstr_desc = "";   
	String hcdg_tnk_rstr_desc = "";   
	String ltd_qty = "";  
	String imdg_lmt_qty_desc = "";
	String imdg_expt_qty_cd = "";
	String imdg_expt_qty_desc = "";

	Logger log = Logger.getLogger("com.clt.apps.SpecialCargoBookingConduct.SpecialCargoReceipt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg0206Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		in_imdg_pck_cd1 = JSPUtil.getParameter(request, "in_imdg_pck_cd1"); 
		in_imdg_pck_cd2 = JSPUtil.getParameter(request, "in_imdg_pck_cd2"); 
		intmd_imdg_pck_cd1 = JSPUtil.getParameter(request, "intmd_imdg_pck_cd1"); 
		intmd_imdg_pck_cd2 = JSPUtil.getParameter(request, "intmd_imdg_pck_cd2"); 
		out_imdg_pck_cd1 = JSPUtil.getParameter(request, "out_imdg_pck_cd1"); 
		out_imdg_pck_cd2 = JSPUtil.getParameter(request, "out_imdg_pck_cd2"); 
		in_imdg_pck_desc1 = JSPUtil.getParameter(request, "in_imdg_pck_desc1"); 
		in_imdg_pck_desc2 = JSPUtil.getParameter(request, "in_imdg_pck_desc2");
		intmd_imdg_pck_desc1 = JSPUtil.getParameter(request, "intmd_imdg_pck_desc1"); 
		intmd_imdg_pck_desc2 = JSPUtil.getParameter(request, "intmd_imdg_pck_desc2"); 
		out_imdg_pck_desc1 = JSPUtil.getParameter(request, "out_imdg_pck_desc1"); 
		out_imdg_pck_desc2 = JSPUtil.getParameter(request, "out_imdg_pck_desc2"); 
		in_imdg_pck_qty1 = JSPUtil.getParameter(request, "in_imdg_pck_qty1"); 
		in_imdg_pck_qty2 = JSPUtil.getParameter(request, "in_imdg_pck_qty2");	
		intmd_imdg_pck_qty1 = JSPUtil.getParameter(request, "intmd_imdg_pck_qty1"); 
		intmd_imdg_pck_qty2 = JSPUtil.getParameter(request, "intmd_imdg_pck_qty2");	
		out_imdg_pck_qty1 = JSPUtil.getParameter(request, "out_imdg_pck_qty1"); 
		out_imdg_pck_qty2 = JSPUtil.getParameter(request, "out_imdg_pck_qty2");		
		hcdg_intmd_bc_rstr_desc = JSPUtil.getParameter(request, "hcdg_intmd_bc_rstr_desc");  
		hcdg_pck_rstr_desc = JSPUtil.getParameter(request, "hcdg_pck_rstr_desc");  
		hcdg_tnk_rstr_desc = JSPUtil.getParameter(request, "hcdg_tnk_rstr_desc");  
		ltd_qty = JSPUtil.getParameter(request, "ltd_qty"); 
		imdg_lmt_qty_desc = JSPUtil.getParameter(request, "imdg_lmt_qty_desc");
		imdg_expt_qty_cd = JSPUtil.getParameter(request, "imdg_expt_qty_cd"); 
		imdg_expt_qty_desc = JSPUtil.getParameter(request, "imdg_expt_qty_desc");

		//when open screen, get data in server..
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
<input type="hidden" name="imdg_pck_tp_cd" id="imdg_pck_tp_cd" />
<input type="hidden" name="temp_pck_tp_cd" id="temp_pck_tp_cd" />
<input type="hidden" name="temp_imdg_pck_desc" id="temp_imdg_pck_desc" />
<input type="hidden" name="pck_tp_seq" id="pck_tp_seq" />
<input type="hidden" name="imdg_pck_cd" id="imdg_pck_cd" />

<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	   <!-- page_title(S) -->
		<h2 class="page_title"><span> DG Package Q'ty & Type</span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_ok" 	id="btn_ok">Ok</button><!--
			--><button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button><!--
		--></div>
		<!-- opus_design_btn(E) -->
		<!-- page_location(S) -->
		<div class="location">
			<span id="navigation"></span>
		</div>
		<!-- page_location(E) -->
	</div>
	<!-- page_title_area(E) -->
</div>
<div class="layer_popup_contents">
	<div class="wrap_search">
		<div class= "opus_design_inquiry wFit">
			<table>
				<colgroup>
					<col width="60" />
					<col width="100" />
					<col width="40" />
					<col width="*" />
				</colgroup>
				<tbody>
						<tr><td colspan="4"><h3 class="title_design">Outer Package</h3></td></tr>
						<tr>
							<th>1st Q'TY</th>
							<td><input type="text" name="out_imdg_pck_qty1" style="width:60px;text-align:right" class="input1" value="<%=out_imdg_pck_qty1%>" maxlength="5" id="out_imdg_pck_qty1" dataformat="num"  /> </td>
							<th>Type</th>
							<td><input type="text" name="out_imdg_pck_cd1" style="width:45px;" class="input1" value="<%=out_imdg_pck_cd1%>" maxlength="5" id="out_imdg_pck_cd1" /><input type="text" name="out_imdg_pck_desc1" style="width:401px;" class="input" value="<%=out_imdg_pck_desc1%>" readonly id="out_imdg_pck_desc1" /><button type="button" id="out_btn1" name="out_btn1" class="input_seach_btn"></button></td>
						</tr>
						<tr>
							<th>2nd Q'TY</th>
							<td><input type="text" name="out_imdg_pck_qty2" style="width:60px;text-align:right" class="input" value="<%=out_imdg_pck_qty2%>" maxlength="5" id="out_imdg_pck_qty2" dataformat="num"  /></td>
							<th>Type</th>
							<td><input type="text" name="out_imdg_pck_cd2" style="width:45px;" class="input" value="<%=out_imdg_pck_cd2%>" maxlength="5" id="out_imdg_pck_cd2" /><input type="text" name="out_imdg_pck_desc2" style="width:401px;" class="input" value="<%=out_imdg_pck_desc2%>" readonly id="out_imdg_pck_desc2" /><button type="button" id="out_btn2" name="out_btn2" class="input_seach_btn"></button></td>
						</tr>
						<tr><td colspan="4"><h3 class="title_design">Intermediate Package</h3></td></tr>
						<tr>
							<th>1st Q'TY</th>
							<td><input type="text" name="intmd_imdg_pck_qty1" style="width:60px;text-align:right" class="input" value="<%=intmd_imdg_pck_qty1%>" maxlength="6" id="intmd_imdg_pck_qty1" dataformat="num"  /> </td>
							<th>Type</th>
							<td><input type="text" name="intmd_imdg_pck_cd1" style="width:45px;" class="input" value="<%=intmd_imdg_pck_cd1%>" maxlength="5" id="intmd_imdg_pck_cd1" /><input type="text" name="intmd_imdg_pck_desc1" style="width:401px;" class="input" value="<%=intmd_imdg_pck_desc1%>" readonly id="intmd_imdg_pck_desc1" /><button type="button" id="intmd_btn1" name="intmd_btn1" class="input_seach_btn"></button></td>
						</tr>
						<tr>
							<th>2nd Q'TY</th>
							<td><input type="text" name="intmd_imdg_pck_qty2" style="width:60px;text-align:right" class="input" value="<%=intmd_imdg_pck_qty2%>" maxlength="6" id="intmd_imdg_pck_qty2" dataformat="num"  /> </td>
							<th>Type</th>
							<td><input type="text" name="intmd_imdg_pck_cd2" style="width:45px;" class="input" value="<%=intmd_imdg_pck_cd2%>" maxlength="5" id="intmd_imdg_pck_cd2" /><input type="text" name="intmd_imdg_pck_desc2" style="width:401px;" class="input" value="<%=intmd_imdg_pck_desc2%>" readonly id="intmd_imdg_pck_desc2" /><button type="button" id="intmd_btn2" name="intmd_btn2" class="input_seach_btn"></button></td>
						</tr>
						<tr><td colspan="4"><h3 class="title_design">Inner Package</h3></td></tr>
						<tr>
							<th>1st Q'TY</th>
							<td><input type="text" name="in_imdg_pck_qty1" style="width:60px;text-align:right" class="input" value="<%=in_imdg_pck_qty1%>" maxlength="6" id="in_imdg_pck_qty1" dataformat="num"  /> </td>
							<th>Type</th>
							<td><input type="text" name="in_imdg_pck_cd1" style="width:45px;" class="input" value="<%=in_imdg_pck_cd1%>" maxlength="5" id="in_imdg_pck_cd1" /><input type="text" name="in_imdg_pck_desc1" style="width:401px;" class="input" value="<%=in_imdg_pck_desc1%>" readonly id="in_imdg_pck_desc1" /><button type="button" id="in_btn1" name="in_btn1" class="input_seach_btn"></button></td>
						</tr>
						<tr>
							<th>2nd Q'TY</th>
							<td><input type="text" name="in_imdg_pck_qty2" style="width:60px;text-align:right" class="input" value="<%=in_imdg_pck_qty2%>" maxlength="6" id="in_imdg_pck_qty2" dataformat="num"  /> </td>
							<th>Type</th>
							<td><input type="text" name="in_imdg_pck_cd2" style="width:45px;" class="input" value="<%=in_imdg_pck_cd2%>" maxlength="5" id="in_imdg_pck_cd2" /><input type="text" name="in_imdg_pck_desc2" style="width:401px;" class="input" value="<%=in_imdg_pck_desc2%>" readonly id="in_imdg_pck_desc2" /><button type="button" id="in_btn2" name="in_btn2" class="input_seach_btn"></button></td>
						</tr>
				</tbody>
			</table>
			<table><tr><td colspan="2"><h3 class="title_design">Restrictions</h3></td></tr></table>
			<table class="grid_2 wAuto">
				<colgroup>
					<col width="150" />
					<col width="250" />
					<col width="250" />
				</colgroup>
				<tbody>
<!-- by kimtk. 2015.06.10. 요청으로 인한 컬럼삭제 깡통 변수 -->
<input type="hidden" name="hcdg_pck_rstr_desc" id="hcdg_pck_rstr_desc" />
<input type="hidden" name="hcdg_intmd_bc_rstr_desc" id="hcdg_intmd_bc_rstr_desc" />
<input type="hidden" name="hcdg_tnk_rstr_desc" id="hcdg_tnk_rstr_desc" />
					<tr>
						<th><b>LTD QTY / DESC</b></th>
						<td><input type="text" name="ltd_qty"  class="noinput2" style="width:100%" value="<%=ltd_qty%>" readonly id="ltd_qty" /> </td>
						<td><input type="text" name="imdg_lmt_qty_desc"  class="noinput2" style="width:100%" value="<%=imdg_lmt_qty_desc%>" readonly id="imdg_lmt_qty_desc" /> </td>
					</tr>
					<tr>
						<th><b>Excepted QTY / DESC</b></th>
						<td><input type="text" name="imdg_expt_qty_cd"  class="noinput2" style="width:100%" value="<%=imdg_expt_qty_cd%>" readonly id="imdg_expt_qty_cd" /> </td>
						<td><input type="text" name="imdg_expt_qty_desc"  class="noinput2" style="width:100%" value="<%=imdg_expt_qty_desc%>" readonly id="imdg_expt_qty_desc" /> </td>
					</tr>
				</tbody>
			</table>
			
			
				<table width="0"  id="mainTable">
						<tr>
							<td width="0">
								<script language="javascript">ComSheetObject('sheet1');</script>
							</td>
						</tr>
				</table>
			
		</div>
	</div>		
	
</form>



<SCRIPT type="text/javascript">


<%
	// Popup mode (1: function call, 2: target set)
	String pop_mode = request.getParameter("pop_mode");	
	if(pop_mode == null || pop_mode.equals(""))
		pop_mode = "1";

	String func  = request.getParameter("func");

	String targetObjList = request.getParameter("targetObjList");

	String sheet = request.getParameter("sheet");	

	String sheetIdx = request.getParameter("sheetIdx");

	String row = request.getParameter("row");
	String col = request.getParameter("col");	

	String strDisplay = request.getParameter("display");
	String strPopOpt  = null;
	String popKind	  = null;
%>

	// parent function call
	function comPopupOK() {
		<%
			
			if(func == null || func.equals("")) {
		%>
				window.close();
				return;
		<%
			}
		%>

		var item = document.getElementsByTagName("input");		

		var i_len = item.length;



		var rArray =  new Array(1); //array 
		rArray[0] = new Array(i_len);

		for (var i=0; i < i_len; i++) {

			if ( item[i].type == "text" || item[i].type == "hidden" ) {

				rArray[0][i] = item[i].value;
			}		
		}		

		if(!opener)
			opener = window.dialogArguments;

		try {
			<%
				if(func != null && !func.equals("")) {					
					if(row != null && col != null) {
						if(sheetIdx != null && sheetIdx != "") {
			%>
							opener.<%= func %>(rArray, <%=row%>, "<%=col%>", <%=sheetIdx%>);
							window.close();
			<%
						} else {
			%>
							opener.<%= func %>(rArray, <%=row%>, "<%=col%>");
							window.close();
			<%
						}
					} else {
			%>
						opener.<%= func %>(rArray);
						window.close();
			<%
					}
				}
			%>
		}
		catch(e) {


		}
	}


</SCRIPT>