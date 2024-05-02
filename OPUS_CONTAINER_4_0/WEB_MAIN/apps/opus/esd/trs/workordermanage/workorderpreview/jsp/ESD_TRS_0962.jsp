<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ESD_TRS_0962.jsp
*@FileTitle : W/O issue
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/12
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.trs.workordermanage.workorderpreview.event.EsdTrs0024Event"%>


<%
	EsdTrs0024Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	DBRowSet rowSet	  = null;					//DB ResultSet
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSet list

	SignOnUserAccount account = null;
	try {

		account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);

		event = (EsdTrs0024Event)request.getAttribute("Event");

		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		} // end else
	}catch(Exception e) {
		out.println(e.toString());
	}
	String today = DateTime.getFormatString("yyyyMMdd");
	String beforeOneMonth = DateTime.addMonths(today, -1);
	String trsp_wo_ofc_cty_cd = JSPUtil.getNull(request.getParameter("trsp_wo_ofc_cty_cd"));
	String wo_iss_knt = JSPUtil.getNull(request.getParameter("wo_iss_knt"));
	String wo_vndr_seq = JSPUtil.getNull(request.getParameter("wo_vndr_seq"));
	String wo_vndr_nm = JSPUtil.getNull(request.getParameter("wo_vndr_nm"));
	String wo_iss_sts_cd = JSPUtil.getNull(request.getParameter("wo_iss_sts_cd"));

	String trsp_crr_mod_cd = JSPUtil.getNull(request.getParameter("trsp_crr_mod_cd"));
	String trsp_cost_dtl_mod_cd = JSPUtil.getNull(request.getParameter("trsp_cost_dtl_mod_cd"));
	//String ets_sts_flg = JSPUtil.getNull(request.getParameter("ets_sts_flg"));
%>

<script language="javascript" src="/opuscntr/rpt/script/common_rd.js"></script>
<script language="javascript">
	var beforeOneMonth = '<%=beforeOneMonth%>';
	var today = '<%=today%>';

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form method="post" name="form" onSubmit="return false;">
<input	type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="FORM_CRE_USR_ID" value="<%=account.getUsr_id()%>">
<input type="hidden" name="FORM_USR_OFC_CD" value="<%=account.getOfc_cd()%>">
<input type="hidden" name="trsp_wo_ofc_cty_cd" value="<%=trsp_wo_ofc_cty_cd%>">
<input type="hidden" name="edi_trsp_wo_ofc_cty_cd">
<input type="hidden" name="edi_trsp_wo_seq">
<input type="hidden" name="edi_loc">
<input type="hidden" name="trsp_crr_mod_cd" value='<%=trsp_crr_mod_cd%>'>
<input type="hidden" name="trsp_cost_dtl_mod_cd" value='<%=trsp_cost_dtl_mod_cd%>'>
<input type="hidden" name="wo_edi_use_flg" value="EDI">
<input type="hidden" name="edi_wo_iss_sts_cd" value='<%=wo_iss_sts_cd%>'>
<input type="hidden" name="edi_wo_iss_knt" value="<%=wo_iss_knt%>">
<input type="hidden" name="edi_vndr_seq" value="<%=wo_vndr_seq%>">

<!-- OUTER - POPUP (S)tart -->
<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>EDI Status Inquiry</span></h2>
		
		<div class="opus_design_btn">
			  <button type="button" class="btn_normal" name="btng_edisend" id="btng_edisend">EDI Send</button><!--  -->
			  <button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
		</div>
	</div>
</div>

<div class="layer_popup_contents">
	<div class="wrap_search">
		<div class="opus_design_inquiry wFit">
			<table class="search" border="0">
				<tr class="h23">
					<th width="13%">Work Order No.</th>
					<td width="20%">
						<input name="wo_no" type="text" style="width:120px;" value="<%=trsp_wo_ofc_cty_cd%>" readonly class="input2"></td>
					<th width="14%">Service Provider</th>
					<td><input name="vndr_seq" type="text" style="width:100px;" value="<%=wo_vndr_seq%>" readonly class="input2"><!-- 
						 --><input name="vndr_nm" type="text" style="width:290px;" value="<%=wo_vndr_nm%>" readonly class="input2"></td>
				</tr>
			</table>
		</div>
	</div>
	<div class="wrap_result">
		<div class="opus_design_grid" >
			<table width="100%" id="mainTable">
                     <tr><td>
                          <script language="javascript">ComSheetObject('sheet1');</script>
                     </td></tr>
           </table>
           <table width="100%" id="hiddenTable">
               <tr><td>
                    <script language="javascript">ComSheetObject('sheet2');</script>
               </td></tr>
           </table>
		</div>
	</div>
</div>

</form>
