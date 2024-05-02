<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0095.jsp
*@FileTitle  : Booking Fax & EDI
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
<%@ page import="com.clt.framework.core.config.SubSystemConfigFactory" %>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.event.EsmBkg0095Event"%>
<%@ page import="com.clt.framework.core.controller.DefaultViewAdapter" %>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0095Event event = null;			//PDTO(Data Transfer Object including Parameters)
	Exception serverException = null;		//error from the server	
	String strErrMsg = "";					//error messege
	int rowCount = 0;						//the number of DB ResultSet List

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";
    String bkgNo = "";
	String polCd = "";
	String docType = "";
	String signFlag = "";
	String strUsr_id = "";
	String strUsr_nm = "";
	Logger log = Logger.getLogger("com.clt.apps.GeneralBookingConduct.GeneralBookingSearch");
	String receiptType = null;
	String blPrnChgTpCd = null;
	String sXml = "";
	StringBuffer fileDir = new StringBuffer();
	String home = System.getProperty("user.home");
	if (home != null){
	 	fileDir.append(home);
	}
	String separator = System.getProperty("file.separator");
	if (separator != null){
	 	fileDir.append(separator);
	}
	
	if (home !=null) fileDir.append(home);
	if (separator !=null) fileDir.append(separator);
	
	String CFG_FILEOPEN_LOGURL_BASE = SubSystemConfigFactory.get("COM.CLT.FILEOPEN.DOMAIN") + "/"; 

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		
		event = (EsmBkg0095Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		//  extract additional data obtained from the server during Initial loading ..
		bkgNo = event.getBkgBlNoVO().getBkgNo();
		polCd = event.getPolCd();
		docType = event.getDocType();
		signFlag = event.getSignFlag();
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		receiptType = (String) eventResponse.getCustomData("receipt_type");
		blPrnChgTpCd = (String) eventResponse.getCustomData("bl_prn_chg_tp_cd");
		DefaultViewAdapter adapter = new DefaultViewAdapter();
		sXml = adapter.makeXML(request, response);
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<script type="text/javascript" src="/opuscntr/rpt/script/common_rd.js"></script>
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
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="bkg_no" value="<%=bkgNo%>">
<input type="hidden" name="usr_id" value="<%=strUsr_id%>">
<input type="hidden" name="receipt_type" value="<%=receiptType%>">
<input type="hidden" name="bl_prn_chg_tp_cd" value="<%=blPrnChgTpCd%>">
<input type="hidden" name="pol_cd" value="<%=polCd%>">
<input type="hidden" name="docType" value="<%=docType%>">
<input type="hidden" name="signFlag" value="<%=signFlag%>">
<input type="hidden" name="inter_rmk">
<input type="hidden" name="sXml" value="<%=JSPUtil.replace(sXml, "\"", "&quot;")%>">
<input type="hidden" name="com_mrdPath">
<input type="hidden" name="com_mrdArguments">
<input type="hidden" name="com_mrdSaveDialogDir" value="<%=fileDir.toString()%>">
<input type="hidden" name="com_mrdSaveDialogFileName">
<input type="hidden" name="com_mrdSaveDialogFileExt" value="pdf">
<input type="hidden" name="com_mrdSaveDialogFileExtLimit" value="xls@pdf@bmp@tif">
<input type="hidden" name="com_mrdTitle">
<input type="hidden" name="com_mrdDisableToolbar" value="3">
<input type="hidden" name="com_mrdBodyTitle">
<input type="hidden" name="com_mrdPrintPaperSize">
<input type="hidden" name="com_zoomIn" value="3">
<input type="hidden" name="com_isBatch" value="N">
<input type="hidden" name="edt_ntc_knd_cd">
<input type="hidden" name="edt_bkg_no_list">
<input type="hidden" name="edt_to_eml">
<input type="hidden" name="edt_cc_eml">
<input type="hidden" name="edt_from_eml">
<input type="hidden" name="edt_subject">
<input type="hidden" name="edt_contents">
<input type="hidden" name="rd_domain" id="rd_domain" value="<%=CFG_FILEOPEN_LOGURL_BASE%>"/>

<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>Fax/EDI</span></h2>
			
		<div class="opus_design_btn">
            <button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--
            --><button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button>
		</div>
	</div>
</div>

<div class="layer_popup_contents">
	<div class="wrap_result">
		<div class="opus_design_grid">
			<div class="ops_design_inquiry"><h3 class="title_design">Fax / E-mail</h3></div>
			<div class="opus_design_btn"><!--
			    --><button type="button" class="btn_normal" name="btn_RemarkTemplate" id="btn_RemarkTemplate">Remark Template</button><!--
			    --><button type="button" class="btn_normal" name="btn_Remark" id="btn_Remark">Remark(s)</button><!--
			    --><button type="button" class="btn_normal" name="btn_Preview" id="btn_Preview">Preview</button><!--
			    --><button type="button" class="btn_normal" name="btn_FaxSend" id="btn_FaxSend">Fax</button><!--
			    --><button type="button" class="btn_normal" name="btn_Email" id="btn_Email">E-mail</button><!--
			    --><button type="button" class="btn_normal" name="btn_EmailEdit" id="btn_EmailEdit">E-mail (Edit)</button>
			</div>
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
		
		<div class="opus_design_grid">
			<div class="opus_design_inquiry"><h3 class="title_design">EDI</h3></div>
			<div class="opus_design_btn">
			    <%if (polCd.equals("SGSIN")) {%><!--
			    --><button type="button" class="btn_normal" name="btn_Yard" id="btn_Yard">Yard Assign by CNTR</button>
			    <%}%><!--
			    --><button type="button" class="btn_normal" name="btn_EDITransmission" id="btn_EDITransmission">EDI Transmission</button>
			</div>
			<script type="text/javascript">ComSheetObject('sheet2');</script>
			<script type="text/javascript">ComSheetObject('sheet3');</script>
		</div>
	
		<div class="opus_design_inquiry">
		    <table style="font:15px;"> 
		        <tr><td>If you want to receive email copy, please go to “Setup -> Client Default” and select “Receiving mail copy option”</td></tr>
	        </table>
		</div>
	</div>
</div>
</form>