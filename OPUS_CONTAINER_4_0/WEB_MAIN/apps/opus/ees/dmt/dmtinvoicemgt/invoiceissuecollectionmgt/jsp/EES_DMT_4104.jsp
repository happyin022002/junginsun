<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_DMT_4104.jsp
*@FileTitle  : DEM/DET Payer Info & Fax/E-mail
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

	String[] arrUsrAuth = null;
	String sec_invoice	= "Y";	//Save, Cancel, A/R I/F Button authorization
	int i_cnt = 0;

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

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_ofc = account.getOfc_cd();
		arrUsrAuth	= account.getUserAuth();	//COM_USR_ROLE_MTCH의 USR_ROLE_CD
		StringBuffer sb = new StringBuffer();

		//Additional authorization check(2010.04.08)-- if role of login User is not DMT01, DMT02, DMT03, DMT04
		//							   "You have no authority to XXXX!" Preventing alert window showing
		if(arrUsrAuth == null){
			log.debug("[USER_AUTH] null");
			sec_invoice = "N";
		}else{
			log.debug("[USER_AUTH] "+arrUsrAuth.length);
			for(int i = 0; i < arrUsrAuth.length; i++) {
				//test
				sb.append(arrUsrAuth[i]).append("===");

				if(arrUsrAuth[i].equals("DMT01") 
						|| arrUsrAuth[i].equals("DMT02") 
						|| arrUsrAuth[i].equals("DMT03")
						|| arrUsrAuth[i].equals("DMT04"))
				{
					i_cnt++;
				}
			}
			if(i_cnt == 0 ){
				sec_invoice = "N";
			}
		}

		log.debug("[USER_AUTH]"+sb.toString());

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
<input type="hidden" name="dmdt_payr_nm" id="dmdt_payr_nm" />
<input type="hidden" name="svr_id" id="svr_id" />
<input type="hidden" name="s_ofc_cd" id="s_ofc_cd" value="<%=s_ofc_cd %>" />
<input type="hidden" name="s_cust_cd" id="s_cust_cd" value="<%=s_cust_cd %>" />
<input type="hidden" name="s_bkg_no" id="s_bkg_no" value="<%=s_bkg_no %>" />
<input type="hidden" name="s_pod_cd" id="s_pod_cd" value="<%=s_pod_cd %>" />
<input type="hidden" name="ofc_cd" id="ofc_cd" />
<input type="hidden" name="s_cust_gubun" id="s_cust_gubun" value="<%=s_cust_gubun %>" />
<input type="hidden" name="success_yn" id="success_yn" />
<input type="hidden" name="jspno" id="jspno" value="<%=jspno %>" />
<input type="hidden" name="s_attn" id="s_attn" value="<%=s_attn %>" />
<input type="hidden" name="s_telno" id="s_telno" value="<%=s_telno %>" />
<input type="hidden" name="s_faxno" id="s_faxno" value="<%=s_faxno %>" />
<input type="hidden" name="s_email" id="s_email" value="<%=s_email %>" />
<input type="hidden" name="sec_invoice" id="sec_invoice" value="<%=sec_invoice %>" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><span id="titles">DEM/DET Payer Info & Fax/E-mail</span></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		     <button type="button" class="btn_accent" name="btn2_save" id="btn2_save">Save</button><!-- 
		  --><button type="button" class="btn_normal" name="btn2_new" id="btn2_new">New</button><!-- 
		  --><button type="button" class="btn_normal" name="btn2_close" id="btn2_close">Close</button>
	</div>
	<!-- opus_design_btn(E) -->
</div>
<!-- page_title_area(E) -->

<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<h3 class="title_design" id="titleLayer">Invoice Sheet</h3>
	<div class="opus_design_data">
		<table class="grid_2 wAuto"> 
			<tr>
				<th width="20%"><b>Customer Code</b></th>
				<td><input type="text" name="cust_cd" id="cust_cd" style="width:100%" value="" readonly /> </td>
				<th width="15%"><b>VAT No.</b></th>
				<td><input type="text" name="cust_rgst_no" id="cust_rgst_no" style="width:100%" value="" readonly /> </td>
				<th width="15%"><b>TAX INV Issue</b></th>
				<td><input type="text" name="iss_div_nm" id="iss_div_nm" style="width:100%" value="" readonly /> </td>
			</tr>
			<tr><th width="15%"><b>Name</b></th>
				<td colspan="5">
					<script type="text/javascript">ComComboObject('payer_name',3,377,0,0,2,true);</script>
				</td>
			</tr>
			<tr><th width="15%" rowspan="2"><b>Address</b></th>
				<td class="input" colspan="5"><script type="text/javascript">ComComboObject('payer_addr',3,377,1,0,0,false);</script>
				</td>
			</tr>	
			<tr>
				<td colspan="5"><textarea name="dmdt_payr_addr" id="dmdt_payr_addr" cols="" rows="4" style="width:100%; resize:none"></textarea>
				</td>
			</tr>		
			<tr><th width="15%"><b>ATTN</b></th>
				<td colspan="5"><input name="dmdt_payr_cntc_pnt_nm" id="dmdt_payr_cntc_pnt_nm" type="text" style="width:100%" value="" readonly /> </td>
			</tr>
			<tr><th width="15%"><b>Tel.</b></th>
				<td colspan="5"><input name="dmdt_payr_phn_no" id="dmdt_payr_phn_no" type="text" style="width:100%" value=" " readonly /> </td>
			</tr>
			<tr><th width="15%"><b>Fax</b></th>
				<td colspan="5"><input name="dmdt_payr_fax_no" id="dmdt_payr_fax_no" type="text" style="width:100%" value=" " readonly /> </td>
			</tr>
			<tr><th width="15%"><b>E-mail</b></th>
				<td colspan="5"><input name="dmdt_payr_n1st_eml" id="dmdt_payr_n1st_eml" type="text" style="width:100%" value=" " readonly /> </td>
			</tr>
		</table>
	</div>
</div>
<div class="wrap_result">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">
			<h3 class="title_design" id="titleLayer">Fax/E-mail</h3>
				<div class="opus_design_btn"> 
					<button class="btn_normal" type="button"  name="btn_rowadd" id="btn_rowadd">Row Add</button><!-- 
					 --><button class="btn_normal" type="button"  name="btn_rowdel" id="btn_rowdel">Row Delete</button>
				</div>
				<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
		<!-- opus_design_grid(E) -->
		<div class="opus_design_grid" id="mainTable2" style=display:none;>
				<script type="text/javascript">ComSheetObject('sheet2');</script>
		</div>
</div>
</form>			