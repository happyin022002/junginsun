<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0904.jsp
*@FileTitle  : Container Export EDI
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/25
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.util.io.HttpUtil"%> 
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.event.EsmBkg0904Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0904Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//DB ResultSet List count

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	String mainpage = "";
    String bkgNo = "";
    String polCd = "";
    String prefix = "form_";
    String rcvId = "";
	Logger log = Logger.getLogger("com.clt.apps.TerminalDocumentation.CLLCDLManifest");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		bkgNo = JSPUtil.getNullNoTrim(request.getParameter("bkg_no"));
        polCd = JSPUtil.getNullNoTrim(request.getParameter("pol_cd"));
        rcvId = JSPUtil.getNullNoTrim(request.getParameter("rcv_Id"));
        mainpage = request.getParameter("main_page");
		event = (EsmBkg0904Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// getting data from server when load the initial screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        codeList = HttpUtil.makeXML(request,response);

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
<input type="hidden" id="f_cmd" name="f_cmd">
<input type="hidden" id="pagerows" name="pagerows">
<input type="hidden" id="bkg_no" name="bkg_no" value="<%=bkgNo%>">
<input type="hidden" id="pol_cd" name="pol_cd" value="<%=polCd%>">
<input type="hidden" id="code_list" name="code_list" value="<%=codeList%>">
<input type="hidden" id="rcv_id" name="rcv_id" value="<%=rcvId%>">
<input type="hidden" id="<%=prefix%>cntr_type" name="<%=prefix%>cntr_type" value="">
<input type="hidden" id="<%=prefix%>grs_wgt" name="<%=prefix%>grs_wgt" value="">

<div class="layer_popup_title">
<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button">Container Export EDI</button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">		
		<button type="button" class="btn_accent" name="btn_EDI" id="btn_EDI">EDI</button><!--
		<%if(!"true".equals(mainpage)){%>
		   --><button type="button" class="btn_normal" name="btn_Close" onclick="self.close()"id="btn_Close">Close</button>
	  <%}%>
								
	</div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->
</div>
<div class="layer_popup_contents">
<!-- opus_design_inquiry(S) -->
	<div style="margin: auto 14px;">	
		<div class="opus_design_inquiry">
			<table style="border:1px solid #ccc; border-collapse:collapse;"> 
                <tr>
                    <th style="border: 1px solid #B8D6F6" width="100px" class="tr2_head">Booking No.</th> 
                    <td style="border: 1px solid #B8D6F6" width="130px" class="noinput2" colspan="2">
                    <input type="text" name="<%=prefix%>bkg_no" style="width:100%" class="noinput2" value="<%=bkgNo%>" readonly></td>
                    <th style="border: 1px solid #B8D6F6" width="110px" class="tr2_head">Code Operation</th> 
                    <td style="border: 1px solid #B8D6F6" width="100px" class="input1">
                        <script type="text/javascript">ComComboObject('form_code_opr', 1, 100, 1, 1);</script>
                    </td>
                </tr>
                <tr>
                    <th style="border: 1px solid #B8D6F6" width="100px" class="tr2_head">Terminal VVD</th> 
                    <td style="border: 1px solid #B8D6F6" width="130px" class="noinput1" colspan="2">
                    <input type="text" name="<%=prefix%>term_vvd" style="width:100%;ime-mode:disabled;" class="" dataformat="engup" maxlength="20" required caption="Terminal VVD"></td>
                                                                    
                    <th style="border: 1px solid #B8D6F6" width="110px" class="tr2_head">NYK VVD</th>   
                    <td style="border: 1px solid #B8D6F6" width="" class="noinput2">
                    <input type="text" name="<%=prefix%>nyk_vvd" style="width:100" class="noinput2" readonly></td>
                </tr>
                <tr>
                    <th style="border: 1px solid #B8D6F6" width="100px" >Terminal POL</th> 
                    <td style="border: 1px solid #B8D6F6 ;" width="130px" class="input1" colspan="2">
                    <input type="text" name="<%=prefix%>term_pol" style="width:100%;ime-mode:disabled" dataformat="enguponly" class="input1" maxlength="5" caption="Terminal POL"></td>
                                                                    
                    <th style="border: 1px solid #B8D6F6" width="110px" class="tr2_head">NYK POL</th>   
                    <td style="border: 1px solid #B8D6F6" width="" class="noinput2">
                    <input type="text" name="<%=prefix%>nyk_pol" style="width:100" class="noinput2" readonly></td>
                </tr>
                <tr>
                    <th style="border: 1px solid #B8D6F6" width="100px" class="tr2_head">Terminal POD   </th> 
                    <td style="border: 1px solid #B8D6F6"  width="130px"; class="noinput1" colspan="2">
                    <input type="text" name="<%=prefix%>term_pod" style="width:100%;ime-mode:disabled;" class="noinput" dataformat="enguponly" maxlength="5" caption="Terminal POD"></td>
                                                                    
                    <th style="border: 1px solid #B8D6F6" width="110px" class="tr2_head">NYK POD    </th>   
                    <td style="border: 1px solid #B8D6F6" width="" class="noinput2">
                    <input type="text" name="<%=prefix%>nyk_pod" style="width:100" class="noinput2" readonly></td>
                </tr>
                <tr>
                    <th style="border: 1px solid #B8D6F6"  class="tr2_head">Fw Agent Code</th> 
                    <td  class="input1" style="width:40px"><input type="text" name="<%=prefix%>fwrd_agn_cd1" style="width:40px;ime-mode:disabled" class="input1" value="230" readonly></td>
                    <td  class="input1" ><input type="text" name="<%=prefix%>fwrd_agn_cd" style="width:100%;ime-mode:disabled" class="input1" maxlength="8" required caption="Fw Agent Code"></td>
                    
                    <th style="border: 1px solid #B8D6F6">TMNL Berth CD</th> 
                    <td style="border: 1px solid #B8D6F6"  class="input1">
                    	<select name="<%=prefix%>tmnl_brth_cd" style="width:100%;" class="input1">
						<option value="TNONOR">TNONOR</option>
						<option value="TNOOCE">TNOOCE</option>
						<option value="EUR">EUR</option>
						<option value="TAW">TAW</option>
						<option value="TPO">TPO</option>
						<option value="TDF">TDF</option>
						</select></td>
                     </td>
                </tr>
                <tr>
                    <th style="border: 1px solid #B8D6F6"  class="tr2_head">Haulage Mode</th> 
                    <td style="border: 1px solid #B8D6F6"  class="input1" colspan="2">
                        <script type="text/javascript">ComComboObject('form_haul_mode', 1, 147, 1, 1);</script>
                    </td>
                    <th style="border: 1px solid #B8D6F6"  class="tr2_head">Mode of Transport</th>     
                    <td width="" class="input1">                    	
						<select name="<%=prefix%>tran_mode" style="width:100%;" class="input1">
						<option value="B">Barge</option>
						<option value="R">Rail</option>
						<option value="T">Truck</option>
						</select>                 	
                    </td>
                </tr>
                </table>
		</div>		
<!-- opus_design_inquiry(E) -->
</div>
<div class="wrap_result">
<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">
			<script type="text/javascript">ComSheetObject('sheet2');</script>
		</div>
<!-- opus_design_grid(E) -->

<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
<!-- opus_design_grid(E) -->	
</div>
</div>
</form>