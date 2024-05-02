<%--
=========================================================
*Copyright(c) 2016 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0171.jsp
*@FileTitle  : VGM EDI (Others)
*@author     : CLT
*@version    : 1.0
*@since      : 2016/06/13
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
<%@ page import="com.clt.apps.opus.esm.bkg.bookingreport.statusreport.event.EsmBkg0171Event"%>
<%@ page import="com.clt.framework.core.controller.DefaultViewAdapter" %>
<%@ page import="org.apache.log4j.Logger" %>
<%
	EsmBkg0171Event event = null;			//PDTO(Data Transfer Object including Parameters)
	Exception serverException = null;		//error from the server	
	String strErrMsg = "";					//error messege
	int rowCount = 0;						//the number of DB ResultSet List

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";
    String bkgNo = "";
    String cntrNos = "";
	String polCd = "";
	String docType = "";
	String signFlag = "";
	String strUsr_id = "";
	String strUsr_nm = "";
	Logger log = Logger.getLogger("com.clt.apps.bookingreport.statusreport");
	String receiptType = null;
	String sXml = "";
	StringBuffer fileDir = new StringBuffer();
	String home = System.getProperty("user.home");
	String CFG_FILEOPEN_LOGURL_BASE = SubSystemConfigFactory.get("COM.CLT.FILEOPEN.DOMAIN") + "/"; 
	if (home != null){
	 	fileDir.append(home);
	}
	String separator = System.getProperty("file.separator");
	if (separator != null){
	 	fileDir.append(separator);
	}
	
	if (home !=null) fileDir.append(home);
	if (separator !=null) fileDir.append(separator);

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		
		event = (EsmBkg0171Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		//  extract additional data obtained from the server during Initial loading ..
		bkgNo         = JSPUtil.getParameter(request,"bkg_no"        ,"" );
		cntrNos         = JSPUtil.getParameter(request,"cntrNos"        ,"" );
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		DefaultViewAdapter adapter = new DefaultViewAdapter();
		sXml = adapter.makeXML(request, response);
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
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="usr_id" value="<%=strUsr_id%>">
<input type="hidden" name="receipt_type" value="<%=receiptType%>">
<input type="hidden" name="pol_cd" value="<%=polCd%>">
<input type="hidden" name="docType" value="<%=docType%>">
<input type="hidden" name="signFlag" value="<%=signFlag%>">
<input type="hidden" name="sXml" value="<%=JSPUtil.replace(sXml, "\"", "&quot;")%>">
<input type="hidden" name="edt_ntc_knd_cd">
<input type="hidden" name="slct_flg">
<input type="hidden" name="ref_code">
<input type="hidden" name="edi_receive_id">
<input type="hidden" name="ntc_knd_cd">
<input type="hidden" name="edi_snd_id">
<input type="hidden" name="cntr_nos" value="<%=cntrNos%>">
<input type="hidden" name="rd_domain" id="rd_domain" value="<%=CFG_FILEOPEN_LOGURL_BASE%>"/>
	<div class="page_title_area clear">
		<h2 class="page_title"><span>VGM EDI</span></h2>
		<div class="opus_design_btn">
            <button type="button" class="btn_normal" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!-- 
            --><button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button>
		</div>
	</div>
<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="60"/>
				<col width="60"/>
				<col width="40"/>
				<col width="60"/>
				<col width="100"/>
				<col width="100"/>
				<col width="100"/>
				<col width="*" />				
			</colgroup> 
			 <tr>
                  <th>BKG No.</th>
                  <td><input name='bkg_no' id='bkg_no' type="text" style="width:110px;" class="input2" maxlength='12' readonly value="<%=bkgNo%>"></td>
                  <th>Code</th>
                  <td><input name='in_yd_cd' id='in_yd_cd' type="text" style="width:60px;" class="input1" dataformat='engup' maxlength='7' value=""></td>
                  <th>Receiver(TP ID)</th>
                  <td><input name='in_rcvr_id' id='in_rcvr_id' type="text" style="width:110px;" class="input1" dataformat='engup' maxlength='50' value=""></td>
                  <th>EDI Sender ID</th>
                  <td><input name='in_sndr_id' id='in_sndr_id' type="text" style="width:110px;" class="input1" dataformat='engup' maxlength='50' value=""></td>
            </tr>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>
	<div class="wrap_result">
		<div class="opus_design_grid">
			<div class="opus_design_btn">
			    <%if (polCd.equals("SGSIN")) {%><!--
			    --><button type="button" class="btn_normal" name="btn_Yard" id="btn_Yard">Yard Assign by CNTR</button>
			    <%}%><!--
			    --><button type="button" class="btn_normal" name="btn_EDITransmission" id="btn_EDITransmission">EDI Transmission</button>
			</div>
			<script type="text/javascript">ComSheetObject('sheet1');</script>
			<!-- <script type="text/javascript">ComSheetObject('sheet2');</script> -->
		</div>
	</div>
</form>