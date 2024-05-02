<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   ESM_BKG_0595.jsp
*@FileTitle  : Cancel Issue Release
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/06
 =========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.event.EsmBkg0649Event"%>

<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmBkg0649Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; // error from server
	String strErrMsg = ""; // error message
	int rowCount = 0; // count of DB resultSET list

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	String strOfc_cd = "";
	Logger log = Logger.getLogger("com.clt.apps.OutboundBLMgt.BLIssuance");
	boolean isPopUp = ("Y".equals(JSPUtil.getParameter(request, "isPopUp")) )?true:false;;
	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
		event = (EsmBkg0649Event) request.getAttribute("Event");
		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	} catch (Exception e) {
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
<input type="hidden" name="f_cmd" 						id="f_cmd"> 
<input type="hidden" name="pagerows" 					id="pagerows">
<input type="hidden" name="strUsr_id" 					id="strUsr_id" 						value="<%=strUsr_id%>">
<input type="hidden" name="strOfc_cd" 					id="strOfc_cd" 						value="<%=strOfc_cd%>">

<input type="hidden" name="bkg_no" 						id="bkg_no" 						value='<%=JSPUtil.getParameter(request, "bkg_no")%>'> 
<input type="hidden" name="bl_no" 						id="bl_no" 							value='<%=JSPUtil.getParameter(request, "bl_no")%>'>
<input type="hidden" name="isPopUp" 					id="isPopUp" 						value='<%=JSPUtil.getParameter(request, "isPopUp")%>'>
<input type="hidden" name="frm_sheet1_bl_tp_cd" 		id="frm_sheet1_bl_tp_cd">
<input type="hidden" name="frm_sheet1_obl_iss_knt" 		id="frm_sheet1_obl_iss_knt">
<input type="hidden" name="frm_sheet2_his_seq" 			id="frm_sheet2_his_seq">
<input type="hidden" name="frm_sheet2_riss_flg" 		id="frm_sheet2_his_seq">

<input type="hidden" name="frm_sheet1_do_yn" 			id="frm_sheet1_do_yn"				value='<%=JSPUtil.getParameter(request, "frm_t11sheet1_flg_do")%>'> 
<input type="hidden" name="frm_sheet1_bl_issue_no" 		id="frm_sheet1_bl_issue_no" 		value='<%=JSPUtil.getParameter(request, "frm_t11sheet1_bl_issue_no")%>'>
<input type="hidden" name="frm_sheet1_obl_released_flg" id="frm_sheet1_obl_released_flg" 	value='<%=JSPUtil.getParameter(request, "frm_t11sheet1_released")%>'> 
<input type="hidden" name="frm_sheet1_obl_iss_flg" 		id="frm_sheet1_obl_iss_flg"			value='<%=JSPUtil.getParameter(request, "frm_t11sheet1_issued")%>'> 
<input type="hidden" name="frm_sheet1_obl_srnd_flg" 	id="frm_sheet1_obl_srnd_flg"		value='<%=JSPUtil.getParameter(request, "frm_t11sheet1_surrender")%>'>
<input type="hidden" name="setupfocoblflag" 			id="setupfocoblflag" 				value="N">

<%if(isPopUp){%>
<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>Issue & Release Cancel</span></h2>
	
		<div class="opus_design_btn">
			   <button type="button" 		class="btn_accent" name="btn_Retrieve" 	id="btn_Retrieve">Retrieve</button><!-- 
			--><button type="button" 		class="btn_normal" name="btn_Save"  	id="btn_Save">Save</button><!-- 
			--><button type="button" 		class="btn_normal" name="btn_Confirm" 	id="btn_Confirm">Confirm</button><!-- 
			--><button type="button" 		class="btn_normal" name="btn_Close" 	id="btn_Close">Close</button> 
		</div>
	</div>
</div>
<%}else{%>	
<div class="page_title_area clear ">
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>

	<div class="opus_design_btn"> 
		   <button type="button" 		class="btn_accent" name="btn_Retrieve" 	id="btn_Retrieve">Retrieve</button><!-- 
		--><button type="button" 		class="btn_normal" name="btn_Save"  	id="btn_Save">Save</button><!-- 
		--><button type="button" 		class="btn_normal" name="btn_Confirm" 	id="btn_Confirm">Confirm</button> 
	</div>

	<div class="location">
		<span id="navigation"></span>
	</div>
</div>
<%}%>	

<%if(isPopUp){%><div class="layer_popup_contents"><%}%>
<div class= "wrap_search">
	<div class="opus_design_inquiry">
		<table>
			<tbody>
				<colgroup>
					<col width="90px"/>
					<col width="125px"/>
					<col width="81px"/>
					<col width="140px"/>
					<col width="*" />
			    </colgroup>
				<tr>
					<th>BKG No.</th>
					<td><input type="text" style="width: 130px;" 	name="frm_sheet1_bkg_no" 		id="frm_sheet1_bkg_no" 		value="<%=JSPUtil.getParameter(request, "bkg_no")%>" class="input1" maxlength="13"  dataformat="engup"></td>
					<th>B/L No.</th>
					<td><input type="text" style="width: 130px;" 	name="frm_sheet1_bl_no" 		id="frm_sheet1_bl_no" 		value="<%=JSPUtil.getParameter(request, "bl_no")%>" class="input" maxlength="13"  dataformat="engup"></td>
					<td></td>
				</tr>
				<tr>
					<th>Shipper</th>
					<td colspan="3"><!-- 
						--><input type="text" style="width: 70px;" 	name="frm_sheet1_shipper_code" 	id="frm_sheet1_shipper_code" value="" class="input2" readonly><!-- 
						--><input type="text" style="width: 274px;" 	name="frm_sheet1_shipper_name" 	id="frm_sheet1_shipper_name" value="" class="input2" readonly><!-- 
					--></td>
					<td></td>
				</tr>
				<tr>
					<th>Reason</th>
					<td colspan="3"><!-- 
						--><script type="text/javascript">ComComboObject('bl_riss_rsn_cd', 1, 348, 1);</script><!-- 
						--><input type="hidden" name="frm_sheet2_bl_riss_rsn_cd" id="frm_sheet2_bl_riss_rsn_cd"><!-- 
					--></td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<th></th>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<th>B/L Collection</th>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
			</tbody>
		</table>
	</div>
</div>

<div class="wrap_result">
		<script type="text/javascript">ComSheetObject('sheet1');</script>		
		<script type="text/javascript">ComSheetObject('sheet2');</script>		
<div class="opus_design_inquiry" style="width:447px;">
		<script type="text/javascript">ComSheetObject('sheet3');</script>
	
			<table class="grid_2" id="mainTable" style="width:447px;">
				<tr>
					<th style="width:60px;">Remark(s)</td>
					<td class="noinput"><textarea style="resize:none;width:98%;" rows="3" name="frm_sheet2_riss_rsn" id="frm_sheet2_riss_rsn"></textarea></td>
				</tr>
			</table>

	</div>
</div>
<%if(isPopUp){%></div><%}%>
</form> 