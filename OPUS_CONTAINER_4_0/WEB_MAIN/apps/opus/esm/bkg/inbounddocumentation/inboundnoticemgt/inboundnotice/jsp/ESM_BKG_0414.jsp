﻿<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_BKG_0414.jsp
*@FileTitle  : Pick-Up Notice Sent History
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/29
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event.EsmBkg0414Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EsmBkg0414Event  event = null;                    //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;            //error from server
    String strErrMsg = "";                        //error message
    int rowCount     = 0;                        //count of DB resultSET list
    String successFlag = "";
    String codeList  = "";
    String pageRows  = "200";
    String strUsr_id        = "";
    String strUsr_nm        = "";
    Logger log = Logger.getLogger("com.clt.apps.InboundBLMgt.PickUpNotice");
    /* page constant */
    String agentKndCd = "6";
    
    /* user define variable */
    String strOfc_cd = "";
    String strCnt_cd = "";
    String strPodCds = "";
    String strOfcKndCd = "";
    
    /* user parameter variable */
    String parAutoSearchFlg = JSPUtil.getParameter(request, "autoSearchFlg");
    String parSchTp         = JSPUtil.getParameter(request, "sch_tp");
    String parBlNo          = JSPUtil.getParameter(request, "bl_no");
    String code = "";
    String value = "";
    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id =    account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
        strOfc_cd = account.getOfc_cd();
        strCnt_cd = account.getCnt_cd();
        
        event = (EsmBkg0414Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
        
        // getting data from server when load the initial screen
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        code = eventResponse.getETCData("code");
        value = eventResponse.getETCData("value");
        
    }catch(Exception e) {
        out.println(e.toString());
    }

	String mainPage = JSPUtil.getNull(request.getParameter("mainPage"));
	if("".equals(mainPage)) {
		mainPage = "true";
	}    
%>

<script type="text/javascript">
    var podCdArr = new Array();
    var strOfc_cd = "<%=strOfc_cd%>";
    var strCnt_cd = "<%=strCnt_cd%>";
    var parSchTp = "<%=parSchTp %>";
    var parAutoSearchFlg = "<%=parAutoSearchFlg %>";
    var parBlNo = "<%=parBlNo %>";
	var evtCode = "<%= code%>|";
	var evtValue = "<%= code%>|";

    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            showErrMessage(errMessage);
        } // end if
        $('<button type="button" class="btn_accent" name="btn_Retrieve"	id="btn_Retrieve">Retrieve</button>').appendTo("#btnArea");
        $('<button type="button" class="btn_normal" name="btn_DownExcel" id="btn_DownExcel">Down Excel</button>').appendTo("#btnArea");
        $('<button type="button" class="btn_normal" name="btn_UsIor" id="btn_UsIor">US IOR</button>').appendTo("#btnArea");
        $('<button type="button" class="btn_normal" name="btn_MasterData" id="btn_MasterData">Master Data</button>').appendTo("#btnArea");
        $('<button type="button" class="btn_normal" name="btn_PkupSend" id="btn_PkupSend">Pickup Send</button>').appendTo("#btnArea");
        $('#btn_PkupSend').after($('#btn_Close'));
        document.getElementById("title").innerHTML = "Pick-Up Notice Sent History";
        loadPage();
    }
</script>

<form name="form" >
<input name="f_cmd" type="hidden" />
<input name="pagerows" type="hidden" value="<%=pageRows %>"/>
<input type="hidden" name="usr_ofc_cd" value="<%=strOfc_cd%>" />

<%  if(mainPage.equals("true")){ %>
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	    
	    <!-- page_title(S) -->
	   	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	    <!-- page_title(E) -->

    	<!-- opus_design_btn(S) -->
	    <div class="opus_design_btn" id="btnArea"></div>
	    <!-- opus_design_btn(E) -->

	   	<!-- page_location(S) -->
	    <div class="location">
	        <!-- location ë´ì© ëì ìì± (ë³ë ì½ë© ë¶íì) -->
	        <span id="navigation"></span>
	    </div>
	    <!-- page_location(E) -->
	</div>
	<!-- page_title_area(E) -->	
	
<% } else { %>
<div class="layer_popup_title">	
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	    
	    <!-- page_title(S) -->
	   	<h2 class="page_title"><span id="title"></span></h2>
	    <!-- page_title(E) -->

    	<!-- opus_design_btn(S) -->
	    <div class="opus_design_btn" id="btnArea">
			<button type="button" class="btn_normal" name="btn_Close"	id="btn_Close" onclick="ComClosePopup()">Close</button> 
	    </div>
	    <!-- opus_design_btn(E) -->
	    
	   	<!-- page_location(S) -->
	    <div class="location">
	        <!-- location ë´ì© ëì ìì± (ë³ë ì½ë© ë¶íì) -->
	        <span id="navigation"></span>
	    </div>
	    	    
	  </div>
	<!-- page_title_area(E) -->
</div>

	<div class="layer_popup_contents" style="margin-bottom:-100px;">
	
<%
}
%>

	<div class="wrap_search">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit ">
			<!-- layout_wrap(S) -->
			<div>
			    <div class="layout_vertical_2" style="width:57%">
			        <table>
						<tbody>
							<colgroup>
								<col width="100">
								<col width="200">
								<col width="80">
								<col width="140">
								<col width="120">
								<col width="140">
								<col width="120">
								<col width="100">
							</colgroup>
							<tr class="sm">
				                <td><input type="radio" class="trans" checked="true" name="sch_tp" value="D" >&nbsp;<strong>Sent Date</strong></td>
				                <td><input type="text" style="width:80px;" class="input1" name="snd_dt_fm" id="snd_dt_fm" caption="Sent Date From" cofield="snd_dt_to" dataformat="ymd" />&nbsp;~&nbsp;&nbsp;<input type="text" style="width:80px;" class="input1" name="snd_dt_to" id="snd_dt_to" caption="Sent Date To" cofield="snd_dt_fm" dataformat="ymd" />
				                  <!-- <img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btn_snd_dt" /> -->
				                  <button type="button" class="calendar" name="btn_snd_dt" id="btn_snd_dt"></button>
				                </td>
				                <td><input type="radio" class="trans" name="sch_tp" value="B" >&nbsp;<strong>B/L No.</strong></td>
				                <td>
				                	<input type="text" style="width:100px;" class="input1" caption="B/L No." name="bl_no" id="bl_no" maxlength="13" dataformat="engup"/>
			                 	</td>
				                <td><input type="radio" class="trans" name="sch_tp" value="C">&nbsp;<strong>Container No.</strong></td>
				                <td>
			                  		<input type="text" style="width:100px;" class="input1" maxlength="11" caption="Container No." fullfill="true" name="cntr_no" id="cntr_no" dataformat="engup"/>
				                </td>
			               </tr>
						</tbody>
					</table>
			    </div>
			    <div class="layout_vertical_2" style="width:43%">
			        <table>
						<tbody>
							<colgroup>
								<col width="115">
							</colgroup>
							<tr>
				                <th>Sent Type</th>
		              			<td>
		                  			<select style="width:70px;" class="input1" name="pkup_ntc_tp_cd" id="pkup_ntc_tp_cd">
		                    			<option value="">All</option>
		                    			<option value="PP">Time</option>
		                    			<option value="FC">F/O/C</option>
		                   				<option value="TO">Truck</option>
		                    			<option value="MA">Manual</option>
		                  			</select>
		                		</td>
			               </tr>
						</tbody>
					</table>
			    </div>
			</div>
			<!-- layout_wrap(E) -->
		
		<table>
			<tbody>
				<colgroup>
					<col width="77">
					<col width="196">
					<col width="95">
					<col width="152">
					<col width="55">
					<col width="119">
					<col width="120">
					<col width="*">
				</colgroup>
				<tr>
	                <th>MVMT</th>                                            
	                <td>
	                    <select style="width:95px;" class="input1" name="mvmt_cd" id="mvmt_cd">
		                    <option value="" >All</option>
			                <option value=""></option>
			                <option value=""></option>
			                <option value=""></option>
			                <option value=""></option>
	                    </select>
	                </td>                                            
	                <th>Sent Result</th>
	                <td>
	               		<select style="width:82px;" class="input1" name="bkg_ntc_snd_rslt_cd" id="bkg_ntc_snd_rslt_cd">
	                    	<option value="" >All</option>
	                    	<option value="S">Success</option>
	                    	<option value="F">Failure</option>
	               		</select>
	                </td>
	               <th>User ID</th>
	               <td><input type="text" style="width:77px;" class="input" name="snd_usr_id" id="snd_usr_id" caption="User ID"  maxlength="20" style="ime-mode:disabled" /></td>
	               <th>Sent EQ Office</th>
	               <td><input type="text" style="width:69px;" class="input1" name="ofc_cd" id="ofc_cd" caption="Sent Office" minlength="5" maxlength="6" dataformat="engup" required="true" /></td>   
	           </tr>
			</tbody>
		</table>
		<!-- opus_design_inquiry(E) -->
		</div>
	</div> 
	<div class="wrap_result">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid" id="mainTable">
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
		<div class="opus_design_grid" id="excelTable" display='none'>
            <script type="text/javascript">ComSheetObject('sheet2');</script>
        </div>
		<!-- opus_design_grid(E) -->
	</div>
<%	if(!mainPage.equals("true")) { %></div><% } %>	
</form>