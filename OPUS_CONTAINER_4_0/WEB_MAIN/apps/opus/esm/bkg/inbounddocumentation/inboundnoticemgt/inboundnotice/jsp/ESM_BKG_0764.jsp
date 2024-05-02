<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_0764.jsp
*@FileTitle  : Customer Data Management Update History
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/06
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event.EsmBkg0764Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EsmBkg0764Event  event = null;          //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;      //error from server
	String strErrMsg = "";				//error message
	int rowCount	 = 0;				//count of DB resultSET list

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id    = "";
    String strUsr_nm    = "";
    Logger log = Logger.getLogger("com.clt.apps.InboundBLMgt.ArrivalNotice");

    /* user define variable */
    String strOfc_cd = "";

    String custCntCd = "";
    String custSeq = "";
    String custNm = "";

    String code = "";
    String value = "";

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id =  account.getUsr_id();
        strUsr_nm = account.getUsr_nm();

        strOfc_cd = account.getOfc_cd();


        event = (EsmBkg0764Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

     // getting data from server when load the initial screen
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        code = eventResponse.getETCData("code");
        value = eventResponse.getETCData("value");

        custCntCd = JSPUtil.getParameter(request, "cust_cnt_cd");
        custSeq = JSPUtil.getParameter(request, "cust_seq");
        String ofcCd = JSPUtil.getParameter(request, "ofc_cd");
        custNm = JSPUtil.getParameter(request, "cust_nm");
        if (!ofcCd.equals("")) {
            strOfc_cd = ofcCd;
        }

        // if Country code of customer is not included in Param, it would be used by login user.
        if (custCntCd == null || custCntCd.trim().equals("") ) {
        	custCntCd = account.getCnt_cd();
        }

    }catch(Exception e) {
      out.println(e.toString());
    }
%>

<script type="text/javascript">
    var podCdArr = new Array();
    var strOfc_cd = "<%=strOfc_cd%>";
    var parCustCntCd = "<%=custCntCd %>";
    var parCustSeq = "<%=custSeq %>";
	var evtCode = "<%=code %>|";
	var evtValue = "<%=value %>|";

    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            showErrMessage(errMessage);
        } // end if


        var formObject = document.form;
        formObject.ofc_cd.value =strOfc_cd;
        loadPage();
    }
</script>

<form name="form">
<input name="f_cmd" type="hidden" id="f_cmd" />
<input name="pagerows" type="hidden" id="pagerows" />
<div class="layer_popup_title">
<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title"><span>Customer Data Management Update History</span></h2>
		<!-- page_title(E) -->
		
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_Retrieve" 		id="btn_Retrieve">Retrieve</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_Close" 			id="btn_Close">Close</button>		
		</div>
		<!-- opus_design_btn(E) -->
	</div>
<!-- page_title_area(E) -->
</div>
<div class="layer_popup_contents">
	<div class="wrap_search">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit">
			<table>
				<colgroup>
					<col width="70">
					<col width="280">
					<col width="124">
					<col width="200">
					<col width="100">
					<col width="*">				
				</colgroup>
				<tbody>
					<tr class="h23">
		                <th>Customer</th>
		                <td>
		                  <input type="text" name="cust_cnt_cd" id="cust_cnt_cd" caption="Customer" minlength="2" maxlength="2" 
		                         required="true" fullfill="true" style="ime-mode:disabled; width:30px" class="input1" tabindex="1" /><!-- 
		                   --><input type="text" name="cust_seq" id="cust_seq" required="true" caption="Customer" maxlength="6" 
		                         style="ime-mode:disabled ;width:55px;" class="input1" tabindex="2" onchange="obj_change()" dataformat="num"/><!-- 
		                   --><input type="text" name="cust_nm" readonly="true" style="width:207px;" class="input2" tabindex="false" value="<%=custNm %>" id="cust_nm" />
		                </td>
		                <th>Update Date</th>
		                <td>
		                  <input type="text" name="cng_dt_s" caption="Update Date Start" dataformat="ymd" maxlength="10" 
		                         required="true" style="width:75px;ime-mode:disabled" cofield="cng_dt_e" class="input1" tabindex="3" />~ <input type="text" name="cng_dt_e" caption="Update Date End" dataformat="ymd" maxlength="10"
		                         required="true" style="width:75px;ime-mode:disabled" value="" cofield="cng_dt_s" class="input1" tabindex="4" /><!-- 
		                   --><button type="button" id="btn_cng_dt" name="btn_cng_dt" class="calendar ir"></button>
		                </td>
		                <th>Office</th>
		                <td><input type="text" name="ofc_cd" readonly="true" style="width:50px;" value="" class="input2" tabindex="-1" id="ofc_cd" /> </td>
	              </tr>
				</tbody>
			</table>
			<table>
				<colgroup>				
					<col width="70">
					<col width="150">
					<col width="79">
					<col width="124">
					<col width="70">
					<col width="*">				
				</colgroup>
				<tbody>
					<tr class="h23">
		                <th>Concerned</th>
		                <td>
		                  <select name="cust_cntc_tp_cd" caption="Concerned" style="width:140px;" class="input1" tabindex="5">
		                  </select>
		                </td>
		                <th>Update Type</th>
		                <td >
		                  <select name="auto_mnl_flg" caption="Update Type" style="width:70px;" class="input1" tabindex="6">
		                    <option value="" selected="true">All</option>
		                    <option value="Y">Auto</option>
		                    <option value="N">Manual</option>
		                  </select>
		                </td>
		                <th>Do not Send</th>
		                <td >
		                  <select name="snd_sel_flg" caption="Do Not Send" style="width:76px;" class="input1" tabindex="8">
		                    <option value="" selected="true">All</option>
		                    <option value="Y">Select</option>
		                    <option value="N">Deselect</option>
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
		<div class="opus_design_grid clear" name="tabLayer" id="tabLayer">
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
		<!-- opus_design_grid(E) -->
		
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid clear" name="tabLayer" id="tabLayer">
			<script type="text/javascript">ComSheetObject('sheet2');</script>
		</div>
		<!-- opus_design_grid(E) -->
	
	</div>
</div>
</form>