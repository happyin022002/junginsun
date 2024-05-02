<%
/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : VOP_SCG_0006.js
 *@FileTitle : DG Restriction by Port - Inquiry
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/06/17
 =========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.vop.scg.dangerouscargorestriction.portrestriction.event.VopScg0006Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopScg0006Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						////count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.DangerousCargoRestriction.PortRestriction");
    String pPort_cd = "";
 
    String pImdg_clss_cd  = "";
    String pImdg_clss_cd_desc  = "";
    String pImdg_un_no  = "";
    String pImdg_un_no_seq  = "";    
    String pPrp_shp_nm = "";    
    
    String pop_yn       = "";
    
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		event = (VopScg0006Event)request.getAttribute("Event");
		
		pPort_cd           = event.getPPortCd(); 
		pImdg_clss_cd      = event.getPImdgClssCd(); 
		pImdg_clss_cd_desc = event.getPImdgClssCdDesc(); 
		pImdg_un_no        = event.getPImdgUnNo(); 
		pImdg_un_no_seq    = event.getPImdgUnNoSeq(); 		
		pPrp_shp_nm        = event.getPPrpShpNm();

		pop_yn      = request.getParameter("pop_mode")==null?"N":"Y";
		
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// add logic data extracting from server when loading initial screen
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
 
		if(document.form.pPort_cd.value != ""){
		     ComScgMainToMakePopup();
		     //document.all.closeBtnLayer.style.display = "";
		     //document.getElementById('closeBtnLayer').style.display = "";
		}
				
		loadPage();
	}
</script>

<form name="form">

<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="pPort_cd" value="<%=pPort_cd %>" id="pPort_cd" />
<input type="hidden" name="imdg_port_rstr_seq" id="imdg_port_rstr_seq" />
<input type="hidden" name="load_imdg_cmptn_auth_cd" id="load_imdg_cmptn_auth_cd" />
<input type="hidden" name="dis_imdg_cmptn_auth_cd" id="dis_imdg_cmptn_auth_cd" />
<input type="hidden" name="ts_imdg_cmptn_auth_cd" id="ts_imdg_cmptn_auth_cd" />
<input type="hidden" name="pass_imdg_cmptn_auth_cd" id="pass_imdg_cmptn_auth_cd" />

<input type="hidden" name="pImdg_clss_cd" value="<%=pImdg_clss_cd %>" id="pImdg_clss_cd" />
<input type="hidden" name="pImdg_clss_cd_desc" value="<%=pImdg_clss_cd_desc %>" id="pImdg_clss_cd_desc" />
<input type="hidden" name="pImdg_un_no" value="<%=pImdg_un_no %>" id="pImdg_un_no" />
<input type="hidden" name="pImdg_un_no_seq" value="<%=pImdg_un_no_seq %>" id="pImdg_un_no_seq" />
<input type="hidden" name="pPrp_shp_nm" value="<%=pPrp_shp_nm %>" id="pPrp_shp_nm" />

<input type="hidden" name="popupYN" id="popupYN" value="<%=pop_yn %>">

<% if (pop_yn=="Y") { %>
<div class="layer_popup_title">
	<div class="page_title_area clear">
	<h2 class="page_title"><span>DG Restriction by Port - Inquiry</span></h2>
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" 		id="btn_retrieve">Retrieve</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_new" 			id="btn_new">New</button><!-- 
		 --><!-- button type="button" class="btn_normal" name="btn_DownExcel" 			id="btn_DownExcel">Down Excel</button --><!-- 
		 --><button type="button" class="btn_normal" name="btn_Close" style="display:yes"			id="btn_Close">Close</button>			
	</div>
	<!-- opus_design_btn(E) -->
	</div>
</div>
<%}else{%>
 <!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button>
	</div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">	
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
	
</div>
<!-- page_title_area(E) -->
<%}%>

<% if (pop_yn=="Y") { %><div class="layer_popup_contents"><%}%>
<!-- wrap_search(S) -->
<div class="wrap_search">
<!-- opus_design_inquiry(S) -->
<div class="opus_design_inquiry wFit">
	<table>
		<tbody>
			<colgroup>
				<col width="81" />
				<col width="10" />
				<col width="100" />
				<col width="10" />
				<col width="175" />
				<col width="*" />
			</colgroup>
			<tr>
				<th>Port Code</th>
				<td><input type="text" style="width:60px;ime-mode:disabled" class="input1" name='port_cd' id='port_cd' required dataformat='engup' maxLength=5 fullfill caption='Port Code' value=""><button type="button" id="srch_port_cd" name="srch_port_cd" class="input_seach_btn"></button><input type="text" style="width:200px;"  readonly class="input2" name='port_cd_nm' value=""></td>
				<th>Option</th>
				<td class="wrap_search_tab"><input type="radio" value='class' name='optClass' class="trans" checked   >Class&nbsp;&nbsp;<input type="radio"  name='optClass'  value='unno' class="trans">UN No.</td>
				<th>Update By</th>
				<td><input type="text" style="width:100px;" class="input2" name='upd_usr_id' value=""><input type="text" style="width:109px;" class="input2" name='upd_dt' value=""></td>
			</tr>
		</tbody>
	</table>
	<table>
		<tbody>
			<colgroup>
				<col width="81" />
				<col width="*" />
			</colgroup>
			<tr>
				<th>Class</th>
				<td><script type="text/javascript">ComComboObject('imdg_clss_cd', 2, 60, 1, 1);</script><input type="text" style="width:836px;" class="input2" readonly  name='imdg_clss_cd_desc' id="imdg_clss_cd_desc" value="">
			    </td>
			</tr>
			<tr>
				<th>UN No./Seq.</th>
				<td>
				<input type="text" style="width:60px;ime-mode:disabled" id="imdg_un_no" readOnly name='imdg_un_no'  maxlength=4 dataformat='num' caption='UN No.' fullfill  onKeyPress="ComKeyOnlyNumber(this)"  value=""><input type="text" style="width:40px;" name='imdg_un_no_seq' value=""  dataformat='engup' minlength=1 onKeyPress="ComKeyOnlyNumber(this)" readOnly><button type="button" id="srch_imdg_un_no" name="srch_imdg_un_no" class="input_seach_btn"></button><input type="text" style="width:763px;" class="input2" name='prp_shp_nm' value="" readonly></td>
			</tr>
		</tbody>
	</table>
</div>
<!-- opus_design_inquiry(E) -->
</div>
<!-- wrap_search(E) -->

<!-- wrap_result(S) -->
<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<!-- opus_design_grid(E) -->
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet2');</script>
	</div>
	<!-- opus_design_grid(E) -->
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet3');</script>
	</div>
	<!-- opus_design_grid(E) -->
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet4');</script>
	</div>
	<!-- opus_design_grid(E) -->
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet5');</script>
	</div>
	<!-- opus_design_grid(E) -->
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" style="display:none">
		<script type="text/javascript">ComSheetObject('sheet6');</script>
	</div>
	<!-- opus_design_grid(E) -->
	<div class="opus_design_inquiry">
		<table class="grid_2">
			<tr>
				<th style="text-align: center;">Remark(s)</th>
			</tr>
			<tr>
				<td><textarea cols="190" rows="6" name='rstr_rmk' maxlength='4000' style="resize:none"></textarea></td>
			</tr>
		</table>
	</div>
</div>
<!-- wrap_result(E) -->

<% if (pop_yn=="Y") { %></div><%}%>

</form>
