<%
/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1070.jsp
*@FileTitle  : China: Manifest Transmission(CNYIT)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/08
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
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.event.EsmBkg1070Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg1070Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//occurring error in server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//list count of DB ResultSet 
	
	String successFlag = "";
	String codeList    = "";
	String pageRows    = "100";
	
	String strUsr_id   = "";
	String strUsr_nm   = "";
    String strCnt_cd   = "";
    String strOff_cd   = "";
    
	String strPgmNo    = "";
	String strTransMode = "";
    String strLocNm    = "";
    
    boolean saveCsvFlg  = false; //whether Save CSV button activation or not
	Logger log = Logger.getLogger("com.clt.apps.CustomsDeclaration.Customstransmission");
    
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strCnt_cd = account.getCnt_cd();
		strOff_cd = account.getOfc_cd();
		event = (EsmBkg1070Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        strPgmNo = JSPUtil.getNull(request.getParameter("pgmNo"));
	} catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<body  onLoad="setupPage();">
<form name="form" method="post">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="cnt_cd" value="<%=strCnt_cd.substring(0,2)%>" id="cnt_cd" />
<input type="hidden" name="eta_flg" id="eta_flg" />
<input type="hidden" name="etd_flg" id="etd_flg" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_retrieve" id="btn_retrieve" type="button">Retrieve</button><!--
		--><button class="btn_normal" name="btn_new" id="btn_new" type="button">New</button><!--
		--><button class="btn_normal" name="btn_excel" id="btn_excel" type="button">Down Excel</button><!--
		--><button class="btn_normal" name="btn_Transmit" id="btn_Transmit" type="button">Transmit</button><!--
		--></div>
	<!-- opus_design_btn (E) -->

	<!-- page_location(S) -->
	<div class="location">	
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
	
</div>
<!-- page_title_area(E) -->

<div class="wrap_search">
	<div class="opus_design_inquiry">
		<table style="margin-top:4px !important;">
			<colgroup>	
				<col width="70">
				<col width="215">
				<col width="60">
				<col width="225">
				<col width="76">
				<col width="250">
				<col width="50">
				<col width="150">
				<col width="*">
			</colgroup>
            <tr>
                <th title="Vessel Voyage Direction">VVD</th>
                <td><input type="text" name="vvd" id="vvd" style="width: 90px; ime-mode: disabled;" class="input1" dataformat="engup" maxlength="9" required fullfill caption="VVD"></td>
                <th title="Port of Loading">POL</th>
                <td><input type="text" name="loc_cd" id="loc_cd" style="width: 60px; ime-mode: disabled;" class="input1" value="CNYIT" dataformat="engup" maxlength="5" required fullfill caption="POL"></td>
                <th>B/L TYPE</th>
                <td>
                	<select style="width: 70px;" name="bl_type" class="input1">
	                    <option value="A" selected>All</option>
	                    <option value="N">Original</option>
	                    <option value="S">Replace</option>
	                    <option value="C">Cancel</option>
                    </select>
                </td>
                <th>ZONE</th>
                <td>
                	<select style="width: 70px;" name="zone" class="input1">
	                    <option value="A" selected>All</option>
	                    <option value="I">IPT</option>
	                    <option value="O">OCN</option>
                    </select>
                </td>
                <td></td>
            </tr>
         </table>
         
         <table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
         
         <table>
         	<colgroup>	
				<col width="70"/>
				<col width="220"/>
				<col width="50"/>
				<col width="220"/>
				<col width="50"/>
				<col width="220"/>
				<col width="50"/>
				<col width="350"/>
				<col width="*"/>
			</colgroup>
            <tr>
                 <th>Call Sign</th>
                 <td><input type="text" name="call_sgn_no" id="call_sgn_no" style="width: 150px;" class="input" disabled></td>
                 <th>Pre. Port</th>
                 <td><input type="text" name="pre_port" id="pre_port" style="width: 60px;" class="input" disabled></td>
                 <th>Next Port</th>
                 <td><input type="text" name="nxt_port" id="nxt_port" style="width: 60px;" class="input" disabled></td>
                 <th>Send Date</th>
                 <td><input type="text" name="snd_date" id="snd_date" style="width: 120px;" class="input" disabled></td>
                 <td></td>
             </tr>
             <tr>
                <th>ETA</th>
                <td><input type="text" name="vps_eta_dt" id="vps_eta_dt" style="width: 150px;" class="input" disabled></td>
                <th>ETD</th>
                <td><input type="text" name="vps_etd_dt" id="vps_etd_dt" style="width: 150px;" class="input" disabled></td>
                <th>Vessel Name</th>
                <td><input type="text" name="vsl_eng_nm" id="vsl_eng_nm" style="width: 230px;" class="input" disabled></td>
                <td></td>
                <td></td>
                <td></td>
            </tr>
         </table>
         
         <table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
         
         <table>
         	<tr>
         		<td>* Beijing Standard Time (GMT +08:00)</td>
         		<td></td>
         	</tr>
         </table>
	</div>
</div>

<div class="wrap_result">
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
		<script type="text/javascript">ComSheetObject('sheet2');</script>
	</div>
	
	
<div class="opus_design_data">
	<table style="align:left; width:500px;">
		<colgroup>
      		<col width="70">
      		<col width="70">
      		<col width="100">
      		<col width="85">
      		<col width="*">
      	</colgroup>
    	   <tr>

            <th>B/L Count</th>
            <td><input type="text" name="bl_cnt" style="width:80px;text-align:right;" class="input2" readonly id="bl_cnt" /> </td>
            <th>CNTR Count</th>
            <td><input type="text" name="cntr_cnt" style="width:80px;text-align:right;" class="input2" readonly id="cntr_cnt" /> </td>
            <td>&nbsp;</td>
    	   </tr>
       </table>
</div>
</div>

</form>