<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : esm_bkg_0946.jsp
*@FileTitle  : Integrated Customer Data Management
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/01
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page
	import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page
	import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page
	import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page
	import="com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event.EsmBkg0946Event"%>
<%@ page import="org.apache.log4j.Logger"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%
	EsmBkg0946Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //error from server
	String strErrMsg = ""; //error message
	int rowCount = 0; //count of DB resultSET list

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	String strUsr_email = "";
	String strOfc_cd = "";

	Logger log = Logger
			.getLogger("com.clt.apps.InboundBLMgt.ArrivalNotice");

	try {
		SignOnUserAccount account = (SignOnUserAccount) session
				.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_email = account.getUsr_eml();
		strOfc_cd = account.getOfc_cd();

		event = (EsmBkg0946Event) request.getAttribute("Event");
		serverException = (Exception) request
				.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException)
					.loadPopupMessage();
		}

		// getting data from server when load the initial screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request
				.getAttribute("EventResponse");

	} catch (Exception e) {
		out.println(e.toString());
	}
%>
  <script language="javascript">
            var strUsr_id    = "<%=strUsr_id%>";
            var strUsr_nm    = "<%=strUsr_nm%>";
            var strUsr_email = "<%=strUsr_email%>";
            var strOfc_cd    = "<%=strOfc_cd%>";
            var strCustCntCd = "<%=JSPUtil.getNull(request.getParameter("cust_cnt_cd"))%>";
            var strCustSeq = "<%=JSPUtil.getNull(request.getParameter("cust_seq"))%>";
            var strCustNm = "<%=JSPUtil.getNull(request.getParameter("cust_nm")) %>";
            var strScNo = "<%=JSPUtil.getNull(request.getParameter("sc_no"))%>";
            var strGubun = "<%=JSPUtil.getNull(request.getParameter("gubun"))%>";
            var strVpsEtaDtStart = "<%=JSPUtil.getNull(request.getParameter("vps_eta_dt_start"))%>";
            var strVpsEtaDtEnd = "<%=JSPUtil.getNull(request.getParameter("vps_eta_dt_end"))%>";
            var strBkgNo = "<%=JSPUtil.getNull(request.getParameter("bkg_no"))%>";

            var strRvisFlg = "<%=JSPUtil.getNull(request.getParameter("rvis_flg"))%>";

            var strFaxNo = "<%=JSPUtil.getNull(request.getParameter("fax_no"))%>";
            var strEmail = "<%=JSPUtil.getNull(request.getParameter("email"))%>";

            var strChgDpFlg = "<%=JSPUtil.getNull(request.getParameter("chg_dp_flg"))%>";


            function setupPage(){
                //var errMessage = "<%=strErrMsg%>";
                //if (errMessage.length >= 1) {
                //	showErrMessage(errMessage);
                //} // end if
                loadPage();
            }


  </script>

        <form name="form"><input name="f_cmd" type="hidden" />
            <input type="hidden" name="pagerows" value="<%=pageRows%>"/>
            <input type="hidden" name="bkg_no" value="<%=JSPUtil.getNull(request.getParameter("bkg_no"))%>"/>

                   <input type="hidden" name="sch_tp" value=""></input>
            <input type="hidden" name="vvd" value=""></input>
            <input type="hidden" name="vps_eta_dt_start" value=""></input>
            <input type="hidden" name="vps_eta_dt_end" value=""></input>
            <input type="hidden" name="pod_cd" value=""></input>
            <input type="hidden" name="pol_cd" value=""></input>
            <input type="hidden" name="del_cd" value=""></input>
            <input type="hidden" name="bl_no" value=""></input>
            <input type="hidden" name="cust_ref_no" value=""></input>
            <input type="hidden" name="cust_nm" value=""></input>
            <input type="hidden" name="diff_rmk" value=""></input>
            <input type="hidden" name="rvis_flg" value=""></input>
            <input type="hidden" name="ts_flg" value=""></input>

            <input type="hidden" name="fax_no" value=""></input>
            <input type="hidden" name="email" value=""></input>

            <input type="hidden" name="com_mrdPath" value="">
            <input type="hidden" name="com_mrdArguments" value="">

            <input type="hidden" size="200" name="com_mrdSaveDialogDir" value="">
            <input type="hidden" size="200" name="com_mrdSaveDialogFileName" value="">
            <input type="hidden" size="200" name="com_mrdSaveDialogFileExt" value="pdf">
            <input type="hidden" size="200" name="com_mrdSaveDialogFileExtLimit" value="">

            <input type="hidden" name="com_mrdTitle" value="">
            <input type="hidden" name="com_mrdDisableToolbar" value="">
            <input type="hidden" name="com_mrdBodyTitle" value="">
            <input type="hidden" name="com_mrdPrintPaperSize" value="">
            
            <input type="hidden" size="200" name="com_zoomIn">


<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>Group A/N Merge Popup</span></h2>
		
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
		</div>
	</div>
</div>

<div class="layer_popup_contents">
	<div class="wrap_search">
		<div class="opus_design_inquiry wFit">
			<table class="search_sm2" border="0" style="width: 500;">
				 <tr class="h23">
          			<td width="125"><input type="radio" value="C" class="trans" name="gubun" disabled >&nbsp;Customer
						Code</td>
                    <td width="123"><input type="text" style="width:30;" class="input2" readOnly value="" name="cust_cnt_cd" caption="Customer Code" fullfill style="ime-mode:disabled" onclick="form.gubun[0].checked=true;" onKeyPress="ComKeyOnlyAlphabet('upper');"  onKeyUp="fncNextFocusByMax(this,2,cust_seq);" size="2" maxlength="2" />&nbsp;<input type="text" style="width:50;" class="input2" value="" name="cust_seq" caption="Customer Code"  readOnly maxlength="6" style="ime-mode:disabled" onclick="form.gubun[0].checked=true;" onKeyPress="ComKeyOnlyNumber(this);" onBlur="fncCustSeqBlur(this)"/>
                    </td>
                    <td width="75"><input type="radio" value="S" class="trans" name="gubun" disabled >&nbsp;S/C
						No.</td>
                    <td width=""><input type="text" style="width:72;" class="input2" readOnly  value="" name="sc_no" caption="S/C No." maxlength="17" style="ime-mode:disabled" onKeyPress="ComKeyOnlyAlphabet('uppernum');"  onclick="form.gubun[1].checked=true;"/></td>
                                        </tr>
             </table>
             <table class="search" border="0">
                  <tr class="h23">
                    <td width="105">&nbsp;Customer Name</td>
                    <td width=""><input type="text" style="width:380;" class="input2" name="cust_nm_view" value="" caption="Customer Name" maxlength="500"  readOnly/></td>
                    <td align="right"><input type="radio" name="div_cd" value="C" class="trans" checked>Combine <input type="radio" name="div_cd" value="S" class="trans">Separate</td>
                  </tr>
            </table>
		</div>
	</div>
	
	<div class="wrap_result">
		<div class="opus_design_grid" >
			<div class="opus_design_grid">				
				<!-- opus_grid_btn(S) -->
				<div class="opus_design_btn">
					<button type="button" class="btn_normal" name="btn_form_setup" id="btn_form_setup">Form Setup</button><!--  -->
					<button type="button" class="btn_normal" name="btn_preview" id="btn_preview">Preview</button><!--  -->
					<button type="button" class="btn_normal" name="btn_down_excel" id="btn_down_excel">Down Excel</button>
				</div>
				<!-- opus_grid_btn(E) -->
			</div>
			
			<script language="javascript">ComSheetObject('sheet1');</script>
		</div>
	
	<div class="opus_design_tab">
		<script language="javascript">ComTabObject('tab1')</script>
	</div>
	
		<div class="opus_design_grid" >
			<div class="opus_design_grid">				
				<!-- opus_grid_btn(S) -->
				<div class="opus_design_btn">
					<button type="button" class="btn_normal" name="btn_fax" id="btn_fax">Fax</button><!--  -->
					<button type="button" class="btn_normal" name="btn_email" id="btn_email">E-mail</button>
				</div>
				<!-- opus_grid_btn(E) -->
			</div>
			
			<script language="javascript">ComSheetObject('t1sheet1');</script>
		</div>
	</div>
</div>
</form>
