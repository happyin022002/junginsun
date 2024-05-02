<%
/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : VOP_SCG_0009.jsp
 *@FileTitle : Vessel Operator's Restriction on DG - Creation
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/06/17
 =========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.apps.opus.bcm.sup.valuemanage.util.ConstantMgr"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.vop.scg.dangerouscargorestriction.carrierrestriction.event.VopScg0009Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopScg0009Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.DangerousCargoRestriction.CarrierRestriction");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (VopScg0009Event)request.getAttribute("Event");
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
<%=ConstantMgr.getCompanyCodeToJS()%>
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
 <!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Retrieve" 		id="btn_Retrieve">Retrieve</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_New" 			id="btn_New">New</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_DownExcel" 			id="btn_DownExcel">Down Excel</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_Save" 			id="btn_Save">Save</button>		
	</div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">	
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
	
</div>
<!-- page_title_area(E) -->
<!-- wrap_search(S) -->
<div class="wrap_search">
<!-- opus_design_inquiry(S) -->
<div class="opus_design_inquiry wFit">
	<table>
		<tbody>
			<colgroup>
				<col width="98" />
				<col width="100" />
				<col width="10" />
				<col width="10" />
				<col width="*" />
			</colgroup>
			<tr class="h23">
				<th>Vessel Operator</th>
				<td><input type="text" style="width:60px;" name='crr_cd' id='crr_cd' dataformat='engup' style="ime-mode:disabled" caption='Vessel Operator' required  maxlength=3 minlength=3  class="input1" value=""><button type="button" id="srch_crr_cd" onclick="img_click()" name="srch_crr_cd" class="input_seach_btn"></button><input type="text" style="width:250px;" name='crr_nm' id='crr_nm' readonly class="input2" value=""></td>			
				<th>Option</th>
				<td class="wrap_search_tab"><input type="radio" value='class' name='optclass' class="trans" checked>&nbsp;Class&nbsp;&nbsp;<input type="radio"  name='optclass'  value='unno' class="trans">&nbsp;UN No.</td>
				<td></td>
			</tr>		
		</tbody>
	</table>
	<table>
		<tbody>
			<colgroup>
				<col width="98" />
				<col width="*" />
			</colgroup>
			<tr class="h23">
				<th>Class</th>
				<td><script type="text/javascript">ComComboObject('combo_imdg_clss_cd', 2, 60, 0, 0);</script><input type="text" style="width:800px;" class="input2" readonly  name='imdg_clss_cd_desc' id='imdg_clss_cd_desc' value="">
			    </td>
			</tr>
			<tr class="h23">
				<th>UN No./Seq.</th>
				<td><input type="text" style="width:60px;" name='imdg_un_no'  class="input2" maxlength=4  dataformat='engup' caption='UN No.'    fullfill  style="ime-mode:disabled" onKeyPress="ComKeyOnlyNumber(this)"  value="" readonly><input type="text" style="width:40px;" name='imdg_un_no_seq' value=""  dataformat='engup' minlength=1 onKeyPress="ComKeyOnlyNumber(this)" readOnly><button type="button" id="srch_imdg_un_no" name="srch_imdg_un_no" class="input_seach_btn"></button><input type="text" style="width:727px;" class="input2" name='prp_shp_nm' value="" readonly></td>
			</tr>
		</tbody>
	</table>
</div>
<!-- opus_design_inquiry(E) -->
</div>
<!-- wrap_search(E) -->

<!-- wrap_result(S) -->
<div class="wrap_result">
<div id='div_s1'>

<!-- opus_design_grid(S) -->
<div class="opus_design_grid">
	<!-- opus_design_btn(S) -->
	<h3 class="title_design">Restrictions on Class</h3>	
	<div class="opus_design_btn">
		<button type="button" class="btn_normal" name="btn_add" 		id="btn_add">Row Add</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_insert" 			id="btn_insert">Row Insert</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_copy" 			id="btn_copy">Row Copy</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_row_delete" 			id="btn_row_delete">Row Delete</button>		
	</div>
	<!-- opus_design_btn(E) -->
	<script type="text/javascript">ComSheetObject('sheet1');</script>
</div>
<!-- opus_design_grid(E) -->
<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry ">
	<table style="width:100%">
		<tbody>
			<tr>
			<td><textarea style="height:70px; "  name='crr_regu_desc_class'></textarea></td>
			<td></td>
			</tr>		
		</tbody>
	</table>
</div>
<!-- opus_design_inquiry(E) -->
</div>
<div id='div_s2' style='display:none'>
<div class="opus_design_grid">
<h3 class="title_design">Restrictions on UN No.</h3>	
<!-- opus_design_grid(S) -->
<div class="opus_design_grid">
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_normal" name="btn_add2" 		id="btn_add2">Row Add</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_insert2" 			id="btn_insert2">Row Insert</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_copy2" 			id="btn_copy2">Row Copy</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_row_delete2" 			id="btn_row_delete2">Row Delete</button>		
	</div>
	<!-- opus_design_btn(E) -->
	<script type="text/javascript">ComSheetObject('sheet2');</script>
</div>
<!-- opus_design_grid(E) -->
<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry">
	<table style="width:100%">
		<tbody>		
			<tr>
			<td><textarea style="height:70px; "  name='crr_regu_desc_unno'></textarea></td>
			</tr>		
		</tbody>
	</table>
</div>
<!-- opus_design_inquiry(E) -->
</div>
</div>
</div>
<!-- wrap_result(E) -->
				
</form>
