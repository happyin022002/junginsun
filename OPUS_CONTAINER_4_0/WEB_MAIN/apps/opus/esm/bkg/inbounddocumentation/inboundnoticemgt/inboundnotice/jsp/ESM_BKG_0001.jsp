<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0001.jsp
*@FileTitle  : Arrival Notice Notice Sent History
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
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event.EsmBkg0001Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EsmBkg0001Event  event = null;                    //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;            //error from server
	String strErrMsg = "";				//error message
	int rowCount	 = 0;				//count of DB resultSET list
    
    String successFlag = "";
    String codeList  = "";
    String pageRows  = "200";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    Logger log = Logger.getLogger("com.clt.apps.InboundBLMgt.ArrivalNotice");
    
    /* page constant */
    String agentKndCd = "6";
    
    /* user define variable */
    String strOfc_cd = "";
    String strCnt_cd = "";
    
    /* Param Argument */
    String parAutoSearchFlg = JSPUtil.getParameter(request, "autoSearchFlg");
    String parSchTp = JSPUtil.getParameter(request, "sch_tp");
    String parBlNo  = JSPUtil.getParameter(request, "bl_no");
    String parVvd   = JSPUtil.getParameter(request, "vvd");
    String parPodCd = JSPUtil.getParameter(request, "pod_cd");
    String parNtcKndCd = JSPUtil.getParameter(request, "ntc_knd_cd");
    
    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id =    account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
       
        strOfc_cd = account.getOfc_cd();
        strCnt_cd = account.getCnt_cd();
        
        event = (EsmBkg0001Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
        
     // getting data from server when load the initial screen
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        
    }catch(Exception e) {
        out.println(e.toString());
    }
%>
<script language="javascript">
    var podCdArr = new Array();
    var strOfc_cd = "<%=strOfc_cd%>";
    var strCnt_cd = "<%=strCnt_cd%>";
    
    var parAutoSearchFlg = "<%=parAutoSearchFlg %>";
    var parSchTp = "<%=parSchTp %>";
    var parBlNo  = "<%=parBlNo %>";
    var parVvd   = "<%=parVvd %>";
    var parPodCd = "<%=parPodCd %>";
    var parNtcKndCd = "<%=parNtcKndCd %>";

    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            showErrMessage(errMessage);
        } // end if

        $('<button type="button" class="btn_accent" name="btn_retrieve"	id="btn_retrieve">Retrieve</button>').appendTo("#btnArea");
        $('<button type="button" class="btn_normal" name="btn_ANSend"  	id="btn_ANSend">A/N Send</button>').appendTo("#btnArea");
        $('<button type="button" class="btn_normal" name="btn_PrePickup" 	id="btn_PrePickup">Pickup</button>').appendTo("#btnArea");
        $('<button type="button" class="btn_normal" name="btn_PreHold"		id="btn_PreHold">Hold</button>').appendTo("#btnArea");
        $('<button type="button" class="btn_normal" name="btn_InboundCS"   id="btn_InboundCS">Inbound C/S</button>').appendTo("#btnArea");
        $('<button type="button" class="btn_normal" name="btn_DownExcel"   id="btn_DownExcel">Down&nbsp;Excel</button>').appendTo("#btnArea");
        
        $('#btn_DownExcel').after($('#btn_Close'));
        
        document.getElementById("title").innerHTML = "Notice Sent History";

        loadPage();
    }
</script>

<form name="form" >
<input name="f_cmd" value="" type="hidden" />
<input name="pagerows" type="hidden" value="<%=pageRows %>"/>
<input name="login_ofc_cd" type="hidden" value="<%=strOfc_cd%>"/>
<%@include file="../../../../bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_TOP.jsp"%>

	<%if(!mainPage.equals("true")){%><div class="layer_popup_contents"><%}%>
	<div class="wrap_search">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit">
		    <table>
		        <tbody>
					<tr>
						<th class="sm" width="50px"><input type="radio" value="V" class="trans" name="sch_tp"  dataformat="engup" />&nbsp;VVD</th>
						<td class="sm" width="100px"><input type="text" name="vvd" caption="VVD" style="width:90px;text-align:center" class="input1" maxlength="9" size="9px" style="ime-mode:disabled"  dataformat="engup" fullfill="true" /></td>
						<th class="sm" width="100px"><input type="radio" value="D" class="trans" name="sch_tp" checked="true" />&nbsp;Sent Date</th>
		              	<td class="sm" width="230px">
							<span class="inquiry_calendar">
								<input type="text" style="width:80px;text-align:center;ime-mode:disabled" dataformat="ymd" maxlength='8' class="input1" name="snd_dt_fm" value="">
								<span class="dash">-</span>
								<input type="text" style="width:80px;text-align:center;ime-mode:disabled"  maxlength='8' dataformat="ymd" class="input1" value="" name="snd_dt_to"><!-- 
								 --><button type="button" class="calendar ir" name="btn_snd_dt" id="btn_snd_dt"></button>
				           	</span>
	                   	</td>						
						<th class="sm" width="30px">POD</th>
	                    <td class="sm" width="80px"><input type="text" class="input1" name="pod_cd" caption="POD" minlength="5" maxlength="5" style="ime-mode:disabled;width:50px;text-align:center" dataformat="engup" fullfill="true" required="true" /></td>
	                    <th class="sm" width="80px">Sent Office</th>
	                    <td class="sm" width="58px"><input type="text" style="width:65px;text-align:center" class="input1" name="ofc_cd" caption="Sent Office" minlength="5" maxlength="6" style="ime-mode:disabled"  dataformat="engup"  required="true" /></td>  
						<td width="20px"></td>
						<th width="30px">T/S</th>
		                <td width="80px"><input type="checkbox" value="Y" name="ts_flg" caption="T/S" class="trans" />&nbsp;</td>
	           		 	<th class="sm" width="80px"><input type="radio" value="B" class="trans" name="sch_tp" />&nbsp;B/L No.</th>
	                    <td class="sm" width="110px"><input type="text" style="width:108px;text-align:center" class="input1" name="bl_no" caption="B/L No."  dataformat="engup"  maxlength="12" style="ime-mode:disabled" /></td>
						<td>&nbsp;</td>
					</tr>
					</table>
					<table>
					<tr>
						<th width="50px">P/O No.</th>
						<td width="100px"><input type="text" style="width:90px;" class="input" value="" name="cust_ref_no" caption="P/O No." maxlength="500" style="ime-mode:disabled"  dataformat="engup"  /></td>
		                <th width="100px">User ID</th>
		                <td width="115px"><input type="text" style="width:80px;" class="input" value="" name="snd_usr_id" caption="User ID" maxlength="20"  dataformat="eng"  style="ime-mode:disabled" /></td>
		                <th width="30px">Sent Result</th>
		                <td width="80px">
							<select style="width:62px;" class="input1" name="bkg_ntc_snd_rslt_cd" id="bkg_ntc_snd_rslt_cd">
							  <option value="" >All</option>
							  <option value="S">Success</option>
							  <option value="F">Fail</option>
							</select>
		                </td>
		                <th width="80px">Notice Type</th>
		                <td>
							<select style="width:100px;" class="input1" name="ntc_knd_cd" id="ntc_knd_cd" ><!--  	//SetBackColor("#D4F4FA"); -->
							  <option value="" >All</option>
							  <option value="AN">A/N</option>
							  <option value="AV">Advice Note</option>
							  <option value="HN">Hold</option>
							  <option value="DO">Delivery Order</option>
							  <option value="BL">Draft B/L</option>
							</select>
		                </td>
					</tr>
				</tbody>
			</table>
			
		</div>
		<!-- opus_design_inquiry(E) -->
	</div>
	
	<div class="wrap_result">	
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid"> 
		    <script language="javascript">ComSheetObject('sheet1');</script>
	    </div>
		<!-- opus_design_grid(E) -->
	</div>
	<div style="display:none">
		<script language="javascript">ComSheetObject('sheet2');</script>
	</div>
	<%if(!mainPage.equals("true")){	%></div><%}%>

</form> 