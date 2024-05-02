<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_DMT_4107.jsp
*@FileTitle  : DEM/DET Fax Send(Fax / Email sent when mailed to the ability to select the target(pop-up))
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/30
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.event.EesDmt4104Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesDmt4104Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	String strUsr_ofc = "";
	Logger log = Logger.getLogger("com.clt.apps.InvoiceMgt.InvoiceIssueCollectionMgt");

	//Parameter
	String s_ofc_cd = "";
	String s_cust_cd = "";
	String s_bkg_no = "";
	String s_pod_cd = "";
	String s_cust_gubun = "";
	String jspno = "";
	String s_attn = "";
	String s_telno = "";
	String s_faxno = "";
	String s_email = "";
	String s_cust_seq = "";
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_ofc = account.getOfc_cd();
		
		event = (EesDmt4104Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// Retrieving the parameter values ​​for calls to pop-up page ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		s_ofc_cd		= JSPUtil.getParameter(request,"s_ofc_cd");
		s_cust_cd		= JSPUtil.getParameter(request,"s_cust_cd");
		s_bkg_no		= JSPUtil.getParameter(request,"s_bkg_no");
		s_pod_cd		= JSPUtil.getParameter(request,"s_pod_cd");
		jspno			= JSPUtil.getParameter(request,"jspno");
		s_attn			= JSPUtil.getParameter(request,"attn");
		s_telno			= JSPUtil.getParameter(request,"telno");
		s_faxno			= JSPUtil.getParameter(request,"faxno");
		s_email			= JSPUtil.getParameter(request,"email");
		s_cust_seq		= JSPUtil.getParameter(request,"cntc_seq");
		
		//VENDOR
		if(s_cust_cd.length() == 6) {
			s_cust_cd	= "00" + s_cust_cd;
			s_cust_gubun = "1";
		}else{
			s_cust_gubun = "2";
		}
		
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
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
<!-- Developer's task	-->
<input type="hidden" name="s_ofc_cd" value="<%=s_ofc_cd %>" id="s_ofc_cd" />
<input type="hidden" name="s_cust_cd" value="<%=s_cust_cd %>" id="s_cust_cd" />
<input type="hidden" name="s_bkg_no" value="<%=s_bkg_no %>" id="s_bkg_no" />
<input type="hidden" name="s_pod_cd" value="<%=s_pod_cd %>" id="s_pod_cd" />
<input type="hidden" name="ofc_cd" id="ofc_cd" />
<input type="hidden" name="s_cust_gubun" value="<%=s_cust_gubun %>" id="s_cust_gubun" />
<input type="hidden" name="jspno" value="<%=jspno %>" id="jspno" />
<input type="hidden" name="s_attn" value="<%=s_attn %>" id="s_attn" />
<input type="hidden" name="s_telno" value="<%=s_telno %>" id="s_telno" />
<input type="hidden" name="s_faxno" value="<%=s_faxno %>" id="s_faxno" />
<input type="hidden" name="s_email" value="<%=s_email %>" id="s_email" />
<input type="hidden" name="s_cust_seq" value="<%=s_cust_seq %>" id="s_cust_seq" />
<input type="hidden" name="dmdt_payr_cntc_pnt_nm" id="dmdt_payr_cntc_pnt_nm" />
<input type="hidden" name="dmdt_payr_phn_no" id="dmdt_payr_phn_no" />
<input type="hidden" name="dmdt_payr_fax_no" id="dmdt_payr_fax_no" />
<input type="hidden" name="dmdt_payr_n1st_eml" id="dmdt_payr_n1st_eml" />

<!-- EMAIL, FAX SENDING -->
<input type="hidden" name="rd_fxeml_sys_cd" id="rd_fxeml_sys_cd" />
<input type="hidden" name="rd_fxeml_file_name" id="rd_fxeml_file_name" />
<input type="hidden" name="rd_fxeml_bat_flg" id="rd_fxeml_bat_flg" />
<input type="hidden" name="rd_fxeml_title" id="rd_fxeml_title" />
<input type="hidden" name="rd_fxeml_rd_param" id="rd_fxeml_rd_param" />
<input type="hidden" name="rd_fxeml_fax_no" id="rd_fxeml_fax_no" />
<input type="hidden" name="rd_fxeml_fax_sndr_id" id="rd_fxeml_fax_sndr_id" />
<input type="hidden" name="rd_fxeml_eml_sndr_nm" id="rd_fxeml_eml_sndr_nm" />
<input type="hidden" name="rd_fxeml_eml_sndr_add" id="rd_fxeml_eml_sndr_add" />
<input type="hidden" name="rd_fxeml_eml_rcvr_add" id="rd_fxeml_eml_rcvr_add" />
<input type="hidden" name="rd_fxeml_eml_atch_file" id="rd_fxeml_eml_atch_file" />
<input type="hidden" name="rd_fxeml_eml_templt" id="rd_fxeml_eml_templt" />
<input type="hidden" name="rd_fxeml_eml_tmplt_param" id="rd_fxeml_eml_tmplt_param" />
<input type="hidden" name="rd_fxeml_doc_tp" id="rd_fxeml_doc_tp" />
<input type="hidden" name="invno" id="invno" />
<input type="hidden" name="payc" id="payc" />

<div class="layer_popup_title"> 
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
			<h2 class="page_title"><span>Fax Send</span></h2>
		<!-- page_title(E) -->
		
		<!-- btn_div -->
	   <div class="opus_design_btn"><!-- 
	     --><button type="button" class="btn_accent" name="btn_fax" id="btn_fax">Fax Send</button><!--
	     --><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
	   </div>
	   <!-- btn_div -->
	</div>
	<!-- page_title_area(E) -->
</div>

<div class="layer_popup_contents">
	<div class="wrap_result">
		<div class="opus_design_grid" id="mainTable">
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div> 
	</div>
	
<!-- grid_area(E) -->	
<!-- <div id="topdeck" style="position:absolute;display:none; visibility:hidden;z-index:200;"></div>	 -->
<!-- <table id="mainTable">  -->
<!--    <tr> -->
<!--         <td width="100%"> -->
<!--         </td> -->
<!--     </tr> -->
<!-- </table> -->
</div>

</form>			