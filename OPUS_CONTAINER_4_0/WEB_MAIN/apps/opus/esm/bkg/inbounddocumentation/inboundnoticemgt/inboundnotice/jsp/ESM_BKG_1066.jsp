<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ESM_BKG_1066.jsp
*@FileTitle : Pick up No Notice Manual Send
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/09
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event.EsmBkg1066Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EsmBkg1066Event  event = null;                  //PDTO(Data Transfer Object including Parameters)
    Exception serverException = null;         //error from server
	String strErrMsg = "";				//error message
	int rowCount	 = 0;				//count of DB resultSET list
    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";
    String strUsr_id        = "";
    String strUsr_nm        = "";
    String strOfc_cd        = "";
    String strPre_Bl_No     = "";
    String code = "";
    String value = "";
    String typeCode = "";
    String typeValue = "";
    String eventCode = "";
    String eventValue = "";
    String mainPage   = "";
    Logger log = Logger.getLogger("com.clt.apps.InboundBLMgtSC.PickUpNoticeBC");
    try {
    	mainPage = JSPUtil.getNull(request.getParameter("mainPage"));
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
        strOfc_cd = account.getOfc_cd();
        strPre_Bl_No = JSPUtil.getParameter(request, "bl_no");
        event = (EsmBkg1066Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        code = eventResponse.getETCData("code");
        value = eventResponse.getETCData("value");
        typeCode = eventResponse.getETCData("type_code");
        typeValue = eventResponse.getETCData("type_value");
        eventCode = eventResponse.getETCData("event_code");
        eventValue = eventResponse.getETCData("event_value");
    } catch(Exception e) {
        out.println(e.toString());
    }
%>

<script  type="text/javascript">
	var evtCode = "<%=code %>|";
	var evtValue = "<%=value %>|";
	var evtTypeCode = "<%= typeCode %>";
	var evtTypeValue = "<%= typeValue %>";
	var evtEventCode = "<%= eventCode %>";
	var evtEventValue = "<%= eventValue %>";
    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            ComShowMessage(errMessage);
        } // end if
        document.form.bl_no.value = "<%=strPre_Bl_No%>";
        loadPage();
    }
</script>

<form name="form">
<input type="hidden" name="f_cmd"                	id="f_cmd">
<input type="hidden" name="pagerows"             	id="pagerows">
<input type="hidden" name="usr_id"           		id="usr_id"           		value="<%=strUsr_id%>" />
<input type="hidden" name="usr_ofc_cd"       		id="usr_ofc_cd"       		value="<%=strOfc_cd%>" />
<input type="hidden" name="com_mrdPath"      		id="com_mrdPath"      		value="" />
<input type="hidden" name="com_mrdArguments" 		id="com_mrdArguments" 		value="" />
<input type="hidden" name="com_mrdTitle" 			id="com_mrdTitle" 			value="">
<input type="hidden" name="com_mrdDisableToolbar" 	id="com_mrdDisableToolbar" 	value=""> 
<input type="hidden" name="com_mrdBodyTitle" 		id="com_mrdBodyTitle" 		value="">

 <!-- page_title_area(S) -->
<div class="page_title_area clear">

	<%if(mainPage.equals("true")){%>
		<!-- page_title(S) -->
		   	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
		<!-- page_title(E) -->
	<%} else { %>
		<!-- page_title(S) -->
		<h2 class="page_title"><span id="title">Pick-Up Notice Send</span></h2>
		<!-- page_title(E) -->    
	<%}%>
	
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Retrieve" 			id="btn_Retrieve">Retrieve</button><!-- 
		--><button type="button" class="btn_normal" name="btn_New"				id="btn_New" >New</button><!-- 
		--><button type="button" class="btn_normal" name="btn_History"	        id="btn_History">Pickup Upload History</button><!-- 
		--><button type="button" class="btn_normal" name="btn_PickUpNoUpload"   id="btn_StopSend">Pick-Up No Upload</button><!-- 
		--><button type="button" class="btn_normal" name="btn_StopSend"			id="btn_StopSend">Stop Send</button><!-- 
		--><button type="button" class="btn_normal" name="btn_ResumeSend"		id="btn_ResumeSend">Resume Send</button><!-- 
		--><button type="button" class="btn_normal" name="btn_Save"				id="btn_Save">Save</button><!-- 
		--><button type="button" class="btn_normal" name="btn_Preview"			id="btn_Preview">Preview</button><!-- 
		--><button type="button" class="btn_normal" name="btn_ManualSetup"		id="btn_ManualSetup">Manual Setup</button><!-- 
		--><%if (!"true".equals(mainPage)){%><!--
	    --><button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button>
	 	<%}%>
			
	</div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">	
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
	
</div>
<!-- page_title_area(E) -->

<div class="wrap_search_tab">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<tbody>
				<colgroup>
					<col width="160"/>
					<col width="210"/>
					<col width="65"/>
					<col width="80"/>
					<col width="300"/>
					<col width="55"/>
					<col width="65"/>
					<col width="*"/>				
			   </colgroup>
				<tr>
				    <td class="sm pad_left_12">
				        <input type="radio" class="trans" name="sch_tp_cd" id="sch_tp_cd_date" value="DATE" />
				        <select style="width:120px;" name="dt_tp_cd" id="dt_tp_cd" class="input1">
				            <option value="SENT">(Exp)Send Date</option>
				            <option value="UPLOAD">P/U Upload Date</option>
				            <option value="ATA">POD ATA</option>
				        </select></td>
				    <td class="sm"><!--
				    --><input type="text" style="width:75px;" class="input1" dataformat="ymd" maxlength="10" caption="ATA POD Start Date" cofield="dt_s" name="dt_s" id="dt_s" />~ <!--
				    --><input type="text" style="width:75px;" class="input1" dataformat="ymd" maxlength="10" caption="ATA POD End Date" cofield="dt_e" name="dt_e" id="dt_e" /><!--
				    --><button type="button" class="calendar ir" name="img_dt" id="img_dt"></button></td>
				    <td class="sm"><input type="radio" class="trans" name="sch_tp_cd" id="sch_tp_cd_mvmt" value="MVMT" /><label for="sch_tp_cd_mvmt"><strong>MVMT</strong></label>                                </td>                                            
				    <td class="sm"><select style="width:70px;" class="input1" name="mvmt_cd" id="mvmt_cd" ></select></td>
				    <td class="sm"><!--
					    --><input type="text" style="width:75px" class="input1" dataformat="ymd" maxlength="10" caption="MVMT Start Date" cofield="dt_mvmt_s" name="dt_mvmt_s" id="dt_mvmt_s" /><!--
					    --><input type="text" style="width:44px" class="input1" dataformat="hm" maxlength="5" caption="MVMT Start Time" name="tm_mvmt_s" id="tm_mvmt_s" />~ <!--
					    --><input type="text" style="width:75px" class="input1" dataformat="ymd" maxlength="10" caption="MVMT End Date" cofield="dt_mvmt_e" name="dt_mvmt_e" id="dt_mvmt_e" /><!--
					    --><input type="text" style="width:44px" class="input1" dataformat="hm" maxlength="5" caption="MVMT End Time" name="tm_mvmt_e" id="tm_mvmt_e" /><!--
					    --><button type="button" class="calendar ir" name="img_mvmt_dt" id="img_mvmt_dt"></button></td> 
				    <th>EQ OFC</th>
	                <td><input type="text" style="width:50px;ime-mode:disabled;" class="input" name="eq_ofc_cd" id="eq_ofc_cd" caption="EQ Office" maxlength="5" minlength="5" dataformat="engup" fullfill="true" /></td>
	                <td><input type="checkbox" class="trans" name="ow_flag" id="ow_flag1" ><label for="ow_flag1"><strong>O.W.</strong></label></td>
				</tr> 			
			</tbody>
		</table>
		<table>
			<tbody>
				<colgroup>			
					<col width="90"/>
					<col width="120"/>
					<col width="50"/>
					<col width="70"/>
					<col width="35"/>	
					<col width="90"/>
					<col width="65"/>	
					<col width="75"/>
					<col width="30"/>	
					<col width="85"/>
					<col width="50"/>
					<col width="90"/>
					<col width="75"/>
					<col width="*"/>		
			   </colgroup>
				 <tr>
				   <td class="sm pad_left_12"><input type="radio" class="trans" name="sch_tp_cd" id="sch_tp_cd_blno" value="BL" onclick="obj_click();" /><label for="sch_tp_cd_blno"><strong>B/L No.</strong></label></td>
	               <td class="sm"><input type="text" style="width:110px;ime-mode:disabled;" class="input1" dataformat="engup" maxlength="13" caption="B/L No." name="bl_no" id="bl_no"/></td>
	               <th>Rail Co.</th>
		           <td>
		           		<select style="width:60px" class="input1" name="rail_co_cd" id="rail_co_cd">
		                    <option value="">ALL</option>
		                    <option value="B">CP,CN</option>
		                </select>
		           </td>
		           <th>Sent</th>
		           <td><select style="width:80px" class="input1" name="snd_sts_cd" id="snd_sts_cd">
		                    <option value="">All</option>
		                    <option value="N">Un-Sent</option>
		                    <option value="F">Fail</option>
		                    <option value="S">Success</option>
		                    <option value="P">Processing</option>
		                    <option value="Y">Sent</option>
		                </select></td>
		           <th>Sent Type</th>
		           <td><select style="width:68px" class="input1" name="ntc_tp_cd" id="ntc_tp_cd"></select></td>
		           <th>FOC</th>
		           <td><select style="width:78px" class="input1" name="foc_tp_cd" id="foc_tp_cd">
		                    <option value="">All</option>
		                    <option value="C">Clear</option>
		                    <option value="N">Not Clear</option>
		                </select></td>	
		           <th>Update ID</th>
		            <td><input type="text" style="width:80px;ime-mode:disabled;" class="input" name="upd_usr_id" id="upd_usr_id" caption="Update ID" maxlength="20" /></td>	            
		            <td><input type="checkbox" class="trans" name="contact_flag" id="contact_flag">	
					    <label for="contact_flag"><strong>Pending</strong></label></td>
		            <td><input type="checkbox" class="trans" name="stop_flag" id="stop_flag">
		                <label for="stop_flag"><strong>Stop</strong></label></td>
		        </tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">

<!-- opus_tab_btn(S) -->
<div class="opus_design_tab">
	<script type="text/javascript">ComTabObject('tab1')</script>
</div>
<!-- opus_tab_btn(E) -->
            
 <!-- opus_design_grid(S) -->
<div class="opus_design_grid clear" name="tabLayer" id="tabLayer">
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_CustomerInfo" 	id="btn_CustomerInfo">Customer Info</button>
		<button type="button" class="btn_normal" name="btn_MasterData"		id="btn_MasterData" >Master Data</button>
		<button type="button" class="btn_normal" name="btn_MultiContact"	id="btn_MultiContact">Multi-Contact</button>
		<button type="button" class="btn_normal" name="btn_RailAMSHistory"	id="btn_RailAMSHistory">Rail AMS History</button>
		<button type="button" class="btn_normal" name="btn_UsIor"			id="btn_UsIor">US IOR</button>
		<button type="button" class="btn_normal" name="btn_ReceiverSetup"	id="btn_ReceiverSetup">Receiver Setup</button>
		<button type="button" class="btn_normal" name="btn_FormSetup"		id="btn_FormSetup">Form Setup</button>
		<button type="button" class="btn_normal" name="btn_DownExcel"		id="btn_DownExcel">Down Excel</button>
		<button type="button" class="btn_normal" name="btn_SendHistory"		id="btn_SendHistory">Send History</button>		
		<button type="button" class="btn_normal" name="btn_Fax"				id="btn_Fax">Fax</button>
		<button type="button" class="btn_normal" name="btn_Email"			id="btn_Email">E-Mail</button> 
	</div>
	<script type="text/javascript">ComSheetObject('sheet1');</script>	
</div>
<!-- opus_design_grid(E) -->
</div>
	
</form>
