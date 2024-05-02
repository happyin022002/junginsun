<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   ESM_BKG_0939
*@FileTitle  : India Cargo Release Performance
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
<%@ page import="com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event.EsmBkg0939Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EsmBkg0939Event  event = null;          //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;      //error from server
	String strErrMsg = "";				//error message
	int rowCount	 = 0;				//count of DB resultSET list
    
    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";
    
    String strUsr_id    = "";
    String strUsr_nm    = "";
    String strOfcCd     = "";
    Logger log = Logger.getLogger("com.clt.apps.InboundBLMgtSC.FullReleaseOrderBC");
    
    String dmdtCode = "";
    String dmdtValue = "";

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id =  account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
        strOfcCd  = account.getOfc_cd();
       
       
        event = (EsmBkg0939Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
    
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
      
     // getting data from server when load the initial screen
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        dmdtCode = eventResponse.getETCData("dmdt_code");
        dmdtValue = eventResponse.getETCData("dmdt_value");
      
    }catch(Exception e) {
        out.println(e.toString());
    }
%>

<script type="text/javascript">
    var strOfcCd = "<%=strOfcCd %>";
    var gDmdtCode = "<%=dmdtCode %>|";
    var gDmdtValue = "<%=dmdtValue %>|";

    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            showErrMessage(errMessage);
        } // end if
        loadPage();
    }
</script>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows" value="<%=pageRows %>">


<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button>
		<button type="button" class="btn_normal" name="btn_CargoRelease"  	id="btn_CargoRelease">Cargo Release</button>
	</div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->

<!-- opus_design_inquiry(S) -->
<div class= "wrap_search">
	<div class="opus_design_inquiry">
		<table>
			<tbody>
				<colgroup>
				     <col width="90" />
				     <col width="70" />
				     <col width="170" />
				     <col width="150" />
				     <col width="340" />
				     <col width="180" />
				     <col width="*" />
				</colgroup>
				<tr>
					<th>Release Office</th>
			        <td>
			              <input type="text" style="width:60px;" class="input1" value="" name="evnt_ofc_cd" dataformat="engup" caption="Release Office" minlength="5" maxlength="6" required="true" style="ime-mode:disabled" >
			        </td>
			        <th>DMDT Payment Type</th>
			        <td><select style="width:90px;" class="input1" name="dmdt_pay_tp_cd" id="dmdt_pay_tp_cd"></select></td>
			        <td class="sm pad_left_8">
			                    <input type="radio" value="F" class="trans" name="rd_flag" checked="true" />Release Date&nbsp<!-- 
			                     --><input type="text"  class="input1" value="" name="evnt_dt_fm" id="evnt_dt_fm" dataformat="ymd" maxlength="10" caption="Release Date From" cofield="evnt_dt_to" required="true" style="width:100px;ime-mode:disabled" /><!-- 
			                      -->~&nbsp;<!-- 
			                     --><input type="text"  class="input1" value="" name="evnt_dt_to" dataformat="ymd" maxlength="10" caption="Release Date To" cofield="evnt_dt_fm" required="true" style="width:100px;ime-mode:disabled" /><!-- 
			                     --><button type="button" class="calendar ir" name="btn_evnt_dt" id="btn_evnt_dt"></button></td>
			        <td class="sm">
	                    <input type="radio" value="S" class="trans" name="rd_flag" />Year&nbsp;Month<!-- 
	                     --><input type="text" style="width:60px;ime-mode:disabled" class="input1" value="" name="evnt_dt_ym" dataformat="ym" maxlength="7" caption="(Release) Year Month"  /><!-- 
	                     --><button type="button" class="calendar ir" name="btn_evnt_dt_ym" id="btn_evnt_dt_ym"></button></td>
                  	<td></td>
				</tr>
			</tbody>
		</table>

		<table>
			<colgroup>
				     <col width="90" />
				     <col width="150" />
				     <col width="90"/>
				     <col width="*" />
				</colgroup>
			<tbody>	
				<tr>
					<th >B/L No.</th>
		            <td ><input type="text" style="width:100px;ime-mode:disabled" dataformat="engup" class="input" name="bl_no" caption="B/L No." maxlength="12" /></td>
		            <th >Container</th>
		            <td ><input type="text" style="width:89px;ime-mode:disabled" dataformat="engup" class="input" name="cntr_no" caption="Container" maxlength="11" /> </td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
<!-- opus_design_inquiry(E) -->


<!-- opus_design_grid(S) -->
<div class="wrap_result">
	<div class="opus_design_grid">
	<!-- opus_design_btn(S) -->
	    <div class="opus_design_btn">
	        <button type="button" class="btn_normal" name="btn_DownExcelDoRlseList0" id="btn_DownExcelDoRlseList0">Down Excel</button>
	    </div> 
	<!-- opus_design_btn(E) -->
			<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
<!-- opus_design_grid(S) -->

<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
	<!-- opus_design_btn(S) -->
	    <div class="opus_design_btn">
	        <button type="button" class="btn_normal" name="btn_DownExcelDoRlseList1" id="btn_DownExcelDoRlseList1">Down Excel</button>
	    </div> 
	    <!-- opus_design_btn(E) -->
			<script type="text/javascript">ComSheetObject('sheet2');</script>
	</div>
</div>
<!-- opus_design_grid(S) -->

</form> 