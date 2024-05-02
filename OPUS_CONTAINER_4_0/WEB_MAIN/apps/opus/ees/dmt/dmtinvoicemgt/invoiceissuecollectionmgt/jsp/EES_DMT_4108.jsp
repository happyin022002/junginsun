<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : EES_DMT_4108.jsp
*@FileTitle : DEM/DET Email Send( selected sending target of Fax/Email (pop-up))
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
	EesDmt4104Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB ResultSet list

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

		// in loading page, Get data from server.
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

<head>
<title>DEM/DET E-mail Send</title>

<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>


<body class="popup_bg" onLoad="setupPage();"> 
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />

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
<input type="hidden" name="rd_fxeml_eml_sndr_fixed" id="rd_fxeml_eml_sndr_fixed" />
<input type="hidden" name="rd_fxeml_eml_sndr_add" id="rd_fxeml_eml_sndr_add" />
<input type="hidden" name="rd_fxeml_eml_rcvr_add" id="rd_fxeml_eml_rcvr_add" />
<input type="hidden" name="rd_fxeml_eml_atch_file" id="rd_fxeml_eml_atch_file" />
<input type="hidden" name="rd_fxeml_eml_templt" id="rd_fxeml_eml_templt" />
<input type="hidden" name="rd_fxeml_eml_tmplt_param" id="rd_fxeml_eml_tmplt_param" />
<input type="hidden" name="rd_fxeml_doc_tp" id="rd_fxeml_doc_tp" />
<input type="hidden" name="invno" id="invno" />
<input type="hidden" name="payc" id="payc" />
<input type="hidden" name="creof" id="creof" />

<div class="layer_popup_title"> 
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	   <!-- page_title(S) -->
		<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title"><span id="titles">E-mail Send</span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			     <button type="button" class="btn_accent" name="btn_email" id="btn_email">E-mail Send</button><!-- 
			  --><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
		</div>
		<!-- opus_design_btn(E) -->
	</div>
</div>

<div class="layer_popup_contents">
	<div class="wrap_result">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">
			<script type="text/javascript">ComSheetObject('sheet1');</script>		
		</div>
		<!-- opus_design_grid(E) -->
	
		<div id="topdeck" style="position:absolute;visibility:hidden;z-index:200;"></div>	
		<!-- RD OBJECT -->		
	    <table width="100%" height="1" id="mainTable"> 
	    	<tr>
	    		<td width="100%"  style="display:none;">
	            </td>
	        </tr>
	    </table>
	</div>
</div>
	
</form>			