<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_1054.jsp
*@FileTitle  : Arrival Notice Customer Code Validate Open
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/19
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event.EsmBkg1054Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EsmBkg1054Event  event = null;        //PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//serverException
	String strErrMsg = "";						//error massage
	int rowCount	 = 0;						//DB ResultSet list count
    
    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";
    
    String strUsr_id    = "";
    String strUsr_nm    = "";
    String strUsr_email      = "";
    String strOfc_cd    = "";
    
    Logger log = Logger.getLogger("com.clt.apps.InboundBLMgt.ArrivalNotice");
    // Login user addition variable
    String strCntCd = "";
    
    // when differ screen request, hanling variable list(start)
    String parAutoSearchFlg = JSPUtil.getParameter(request, "autoSearchFlg");
    String parVvd   = JSPUtil.getParameter(request, "vvd");
    String parVpsEtaDtStart = JSPUtil.getParameter(request, "vps_eta_dt_start");
    String parVpsEtaDtEnd   = JSPUtil.getParameter(request, "vps_eta_dt_end");
    String parPodCd = JSPUtil.getParameter(request, "pod_cd");
    String parPolCd = JSPUtil.getParameter(request, "pol_cd");
    String parDelCd = JSPUtil.getParameter(request, "del_cd");
    String parBlNo  = JSPUtil.getParameter(request, "bl_no");
    String parOfcCd = JSPUtil.getParameter(request, "ofc_cd");
    String parSchTp = JSPUtil.getParameter(request, "sch_tp");
    String parTsFlg = JSPUtil.getParameter(request, "ts_flg");
 // when differ screen request, hanling variable list(end)
    
    String code = "";
    String value = "";
    
    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id =  account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
        strUsr_email = account.getUsr_eml();
        strOfc_cd = account.getOfc_cd();
        strCntCd = account.getCnt_cd();
          
         
        event = (EsmBkg1054Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
      
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
        
		//when open screen, get data in server..
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        code = eventResponse.getETCData("code");
        value = eventResponse.getETCData("value");
    }catch(Exception e) {
        out.println(e.toString());
    }
%>

<script type="text/javascript">
    var strUsr_id    = "<%=strUsr_id %>";
    var strUsr_nm    = "<%=strUsr_nm %>";
    var strUsr_email = "<%=strUsr_email %>";
    var strOfc_cd    = "<%=strOfc_cd %>";
    var strCntCd     = "<%=strCntCd %>"; 
    
    // when differ screen request, hanling variable list(start)
    var parAutoSearchFlg = "<%=parAutoSearchFlg %>";
    var parVvd           = "<%=parVvd %>";
    var parVpsEtaDtStart = "<%=parVpsEtaDtStart %>";
    var parVpsEtaDtEnd   = "<%=parVpsEtaDtEnd %>";
    var parPodCd         = "<%=parPodCd %>";
    var parPolCd         = "<%=parPolCd %>";
    var parDelCd         = "<%=parDelCd %>";
    var parBlNo          = "<%=parBlNo %>";
    var parOfcCd         = "<%=parOfcCd %>";
    var parSchTp         = "<%=parSchTp %>";
    var parTsFlg         = "<%=parTsFlg %>";
    // when differ screen request, hanling variable list(end)
    
    var evtCode = "-|<%=code %>";
    var evtValue = " |<%=value %>";
    
    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            showErrMessage(errMessage);
        } // end if
        
        $('<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button>').appendTo("#btnArea");
        $('<button type="button" class="btn_normal" name="btn_excel" id="btn_excel">Down Excel</button>').appendTo("#btnArea"); 
        $('<button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button>').appendTo("#btnArea");
    	$('<button type="button" class="btn_normal" name="btn_ANSetup" id="btn_ANSetup">A/NSetup</button>').appendTo("#btnArea");		
		$('<button type="button" class="btn_normal" name="btn_ANSend" id="btn_ANSend">A/N Send</button>').appendTo("#btnArea");
        
		$('#btn_ANSend').after($('#btn_Close'));
		document.getElementById("title").innerHTML = "Arrival Notice:Code Validate";
        
        loadPage();
    }
</script>

<form name="form">
<input name="f_cmd" type="hidden" />
<input type="hidden" name="pagerows" id="pagerows" value="<%=pageRows %>">
<!-- Developer Work	-->
<input type="hidden" name="an_seq" id="an_seq" value="" />
<input type="hidden" name="strUsr_nm" id="strUsr_nm" value="" />
<input type="hidden" name="strUsr_email" id="strUsr_email" value="" />
<input type="hidden" name="strOfc_cd" id="strOfc_cd" value="" />
<input type="hidden" name="gw_subject" id="gw_subject"value="" />
<input type="hidden" name="gw_contents" id="gw_contents" value="" />
<input type="hidden" name="gw_template" id="gw_template" value="ESM_BKG_1054_01T.html" />
<input type="hidden" name="gw_args" id="gw_args" value="" />
<input type="hidden" name="gw_args" id="gw_args" value="" />                
<input type="hidden" name="gw_args"id="gw_args" value="" />                
<input type="hidden" name="gw_args"id="gw_args" value="" />                
<input type="hidden" name="gw_args"id="gw_args" value="" />                
<input type="hidden" name="gw_args"id="gw_args" value="" />
<%@include file="../../../../bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_TOP.jsp" %>  
<!-- ======================================================================== -->

<%if(!mainPage.equals("true")){%><div class="layer_popup_contents"><%}%>
<div class= "wrap_search_tab">		
<!-- opus_design_inquiry(S) -->
<div class= "opus_design_inquiry wFit">
	<table>
		</tbody>
	  	<colgroup>	
	  	<col width="13px"/>
	    <col width="1px"/>
	    <col width="1px"/>
		<col width="95px"/>
		<col width="1px"/>
		<col width="1px"/>
		<col width="1px"/>
		<col width="60px"/>
		<col width="1px"/>
		<col width="1px"/>
		<col width="1px"/>
		<col width="1px"/>
		<col width="1px"/>
		<col width="1px"/>
		<col width="1px"/>
		<col width="70px"/>
		<col width="1px"/>
		<col width="1px"/>			
	 	<col width="*"/>	 		
	  </colgroup>	
	  	<tr class="h23">
	  	<td></td>
         	<td><input type="radio" value="V" class="trans" name="sch_tp" id="sch_tp" ></td>
           	<th title="Vessel Voyage Direction">VVD</th>
           	<td><input type="text" style="width:80px;" class="input1" name="vvd" id="vvd" caption="VVD" maxlength="9" dataformat="engup" size="9" style="ime-mode:disabled" fullfill="true"/></td>
         	<td><input type="radio" value="D" name="sch_tp" id="sch_tp" class="trans" checked="true" ></td>
         	<th>POD ETA</th>
         	<td>	
           		<input type="text" style="width:75px" dataformat="ymd" maxlength="10" value="" class="input1" 
                  caption="POD ETA Start Date" required="true" name="vps_eta_dt_start"  id="vps_eta_dt_start" 
                  cofield="vps_eta_dt_end" style="width:100px;ime-mode:disabled" />&nbsp;&nbsp;~&nbsp;
           		<input type="text" style="width:75px" dataformat="ymd" maxlength="10" value="" class="input1" 
                  name="vps_eta_dt_end" id="vps_eta_dt_end" cofield="vps_eta_dt_start" caption="POD ETA End Date" 
                  required="true" style="ime-mode:disabled" />
          		<button type="button" class="calendar ir" name="btn_vps_eta_dt" id="btn_vps_eta_dt"></button>
        	</td>
            <th title="Port of Discharging">POD</th>
            <td><input type="text" style="width:50px;" class="input1" name="pod_cd" id="pod_cd" caption="POD" maxlength="5" dataformat="engup" style="ime-mode:disabled" fullfill="true" /></td>
            <th>T/S</th>
            <td><input type="checkbox" value="Y" name="ts_flg" id="ts_flg" caption="T/S" class="trans" />&nbsp;</td>
            <th title="Place of Delivery">DEL</th>
            <td><input type="text" style="width:60px;" class="input" name="del_cd" id="del_cd" caption="DEL" minlength="2" maxlength="5" dataformat="engup" style="ime-mode:disabled" /></td>
            <th title="Port of Loading">POL</th>
            <td></td>
            <td><input type="text" style="width:60px;" class="input" name="pol_cd" id="pol_cd" caption="POL" minlength="5" maxlength="5" dataformat="engup" style="ime-mode:disabled" /></td>
            <td><input type="radio" value="B" class="trans" name="sch_tp" ></td>
        
            <th>B/L No.</th>
            <td><input type="text" style="width:115px;" class="input1" value="" name="bl_no" id="bl_no" caption="B/L No." maxlength="12" dataformat="engup" style="ime-mode:disabled" /></td>
         </tr>
	  		  		  			
	</tbody>
</table>	
</div>
</div>
<div class="wrap_result">
<!-- opus_tab_btn(S) -->
<div class="opus_design_tab">
	<script type="text/javascript">ComTabObject('tab1')</script>
</div>
<!-- opus_tab_btn(E) -->
<!-- opus_design_grid(S) -->
<div class="opus_design_grid clear" style="width:98%" name="tabLayer" id="tabLayer">
	<script type="text/javascript">ComSheetObject('t1sheet1');</script>
</div>
<!-- opus_design_grid(E) -->
<!-- opus_design_grid(S) -->
<div class="opus_design_grid clear" style="width:98%" name="tabLayer" id="tabLayer">
	<script type="text/javascript">ComSheetObject('t2sheet1');</script>
</div>
<!-- opus_design_grid(E) -->
 <script type="text/javascript">ComSheetObject('t1excel');</script>
<script type="text/javascript">ComSheetObject('t2excel');</script>
<!-- Developer Work End -->
</div>

<%if(!mainPage.equals("true")){	%></div><%}%>
</form>
