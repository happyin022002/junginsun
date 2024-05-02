<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0890.jsp
*@FileTitle  : Cargo Detail Information
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
<%@ page import="com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.event.EsmBkg0890Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0890Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			// error from server
	String strErrMsg = "";						// error message
	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.GeneralBookingConduct.GeneralBookingReceipt");
	String bkgNo = "";
	String calllFunc = "";
	String caFlg = "";
	String callSheetIdx1 = "";	
	String callSheetIdx2 = "";
	String callTp = "";
	String dgFlg = "";
	String rcFlg = "";
	String awkCgoFlg = "";
	String bbCgoFlg = "";
	String hngrFlg = "";
	String eqSubstFlg = "";
	String socFlg = "";
	String mixedFlg = "";
	String autoFlg = "";	
	String rcvTermCd = "";
	String deTermCd = "";
	String bdrFlg="";
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		event = (EsmBkg0890Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		bkgNo  = JSPUtil.getParameter(request, "bkg_no");
		caFlg  = JSPUtil.getParameter(request, "ca_flg");
		calllFunc  = JSPUtil.getParameter(request, "func");
		callSheetIdx1  = JSPUtil.getParameter(request, "callSheetIdx1");
		callSheetIdx2  = JSPUtil.getParameter(request, "callSheetIdx2");
		callTp  = JSPUtil.getParameter(request, "callTp");
		dgFlg  = JSPUtil.getParameter(request, "dcgo_flg");		
		rcFlg  = JSPUtil.getParameter(request, "rc_flg");		
		awkCgoFlg  = JSPUtil.getParameter(request, "awk_cgo_flg");		
		bbCgoFlg  = JSPUtil.getParameter(request, "bb_cgo_flg");		
		hngrFlg  = JSPUtil.getParameter(request, "hngr_flg");		
		eqSubstFlg  = JSPUtil.getParameter(request, "eq_subst_flg");		
		socFlg  = JSPUtil.getParameter(request, "soc_flg");		
		mixedFlg  = JSPUtil.getParameter(request, "mixed_flg");
		autoFlg  = JSPUtil.getParameter(request, "auto_flg");
		rcvTermCd  = JSPUtil.getParameter(request, "rcv_term_cd");	
		deTermCd  = JSPUtil.getParameter(request, "de_term_cd");	
	 	bdrFlg  = JSPUtil.getParameter(request, "bdr_flg");	
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

<form name="form">
<input id="f_cmd" name="f_cmd" type="hidden" />
<input id="pagerows" name="pagerows" type="hidden" />
<input id="bkg_no" name="bkg_no" value="<%= bkgNo%>" type="hidden" />
<input id="ca_flg" name="ca_flg" value="<%= caFlg%>" type="hidden" />
<input id="bdr_flg" name="bdr_flg" value="<%= bdrFlg%>" type="hidden" />
<input id="func" name="func" value="<%=calllFunc%>" type="hidden" />
<input id="callSheetIdx1" name="callSheetIdx1" value="<%=callSheetIdx1%>" type="hidden" />
<input id="callSheetIdx2" name="callSheetIdx2" value="<%=callSheetIdx2%>" type="hidden" />
<input id="callTp" name="callTp" value="<%=callTp%>" type="hidden" />
<input id="dcgo_flg" name="dcgo_flg" value="<%=dgFlg%>" type="hidden" />
<input id="rc_flg" name="rc_flg" value="<%=rcFlg%>" type="hidden" />
<input id="awk_cgo_flg" name="awk_cgo_flg" value="<%=awkCgoFlg%>" type="hidden" />
<input id="bb_cgo_flg" name="bb_cgo_flg" value="<%=bbCgoFlg%>" type="hidden" />
<input id="hngr_flg" name="hngr_flg" value="<%=hngrFlg%>" type="hidden" />
<input id="eq_subst_flg" name="eq_subst_flg" value="<%=eqSubstFlg%>" type="hidden" />
<input id="soc_flg" name="soc_flg" value="<%=socFlg%>" type="hidden" />
<input id="mixed_flg" name="mixed_flg" value="<%=mixedFlg%>" type="hidden" />
<input id="auto_flg" name="auto_flg" value="<%=autoFlg%>" type="hidden" />
<input id="rcv_term_cd" name="rcv_term_cd" value="<%=rcvTermCd%>" type="hidden" />
<input id="de_term_cd" name="de_term_cd" value="<%=deTermCd%>" type="hidden" />

<!-- popup_title_area(S) -->
<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title"><span>EQ detail of Special Cargo Container</span></h2>
		<!-- page_title(E) -->
			
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_Add" id="btn_Add">Add</button><!--  
            --><button type="button" class="btn_normal" name="btn_Delete" id="btn_Delete">Delete</button><!--  
            --><button type="button" class="btn_normal" name="btn_Save" id="btn_Save">Ok</button><!--  
            --><button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button>
		</div>
		<!-- opus_design_btn(E) -->	
	</div>
	<!-- page_title_area(E) -->
</div>
<!-- popup_title_area(E) -->

<!-- popup_contens_area(S) -->
<div class="">
	<div class="wrap_result">
		<div class="opus_design_grid" >
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
		<div class="grid2 noinput2">
			<table> 
				<colgroup>
					<col width="70" />
					<col width="*" />
				</colgroup>
				<tbody>
					<tr>
						<th>Total Vol.</th>
						<td><input type="text" name="total_vol" id="total_vol"  value="" readonly ></td>
					</tr>
					<tr>
						<th>BKG Vol.</th>
						<td><input type="text" name="bkg_vol" id="bkg_vol"  value="" readonly ></td>
					</tr>							
			    </tbody>
			</table> 
		</div>
	</div>	
	
		<div class="opus_design_grid" style="display:none">
			<script type="text/javascript">ComSheetObject('sheet2');</script>
		</div>
</div>

<!-- popup_contens_area(E) -->
</form>