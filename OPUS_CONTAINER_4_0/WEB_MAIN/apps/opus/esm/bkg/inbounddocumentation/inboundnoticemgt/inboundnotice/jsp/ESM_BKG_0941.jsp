<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0941.jsp
*@FileTitle  : Consignee Code Error Report
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/18
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.bcm.sup.valuemanage.util.ConstantMgr"%>
<%@ page import="com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event.EsmBkg0941Event"%>
<%@ page import="org.apache.log4j.Logger" %> 

<%
    EsmBkg0941Event  event = null;          //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;     //error from server
    String strErrMsg = "";            		//error message
    int rowCount   = 0;            			//DB ResultSet List count

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id    = "";
    String strUsr_nm    = "";
    Logger log = Logger.getLogger("com.clt.apps.InboundBLMgt.ArrivalNotice");

    String code = "";  // Evaluation Result Code
    String value = "";
    String custCode = ""; // Customer Type Code
    String custValue = "";

    String userOfcCd = "";
    String userRhqOfcCd = "";

    boolean isHeadOfficeCode = false;
    // Temp
    StringBuffer tempData = new StringBuffer();

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);

        strUsr_id =  account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
        userOfcCd = account.getOfc_cd();
        userRhqOfcCd = account.getRhq_ofc_cd();
        isHeadOfficeCode = ConstantMgr.isHeadOfficeCode(userRhqOfcCd);

        //Temp

        tempData.append("UserId[").append(strUsr_id).append("] ");
        tempData.append("CntCd[").append(account.getCnt_cd()).append("] ");
        tempData.append("userRhqOfcCd[").append(account.getRhq_ofc_cd()).append("] ");
        tempData.append("userAuthTpCd[").append(account.getUsr_auth_tp_cd()).append("] ");
        tempData.append("userAuth[");
        String[] userAuth  = account.getUserAuth();
        if (userAuth != null && userAuth.length > 0) {
        	for (int i = 0; i < userAuth.length ; i ++ ) {
        		tempData.append(userAuth[i]);
        		if (i != userAuth.length - 1) {
        			tempData.append(",");
        		}
        	}
        	tempData.append("]");
        }

        event = (EsmBkg0941Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        // getting data from server when load the initial screen
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        code = eventResponse.getETCData("code");
        value = eventResponse.getETCData("value");

        custCode = eventResponse.getETCData("cust_code");
        custValue = eventResponse.getETCData("cust_value");

    }catch(Exception e) {
        out.println(e.toString());
    }
%>

<script type="text/javascript">

    var evtCode = " |<%=code %>";
    var evtValue = " |<%=value %>";
    var gCustCode = "<%=custCode %>";
    var gCustValue = "<%=custValue %>"
	var gUsrOfcCd = "<%=userOfcCd %>";
	var gUserRhqOfcCd = "<%=userRhqOfcCd %>";
	var isHeadOfficeCode = "<%=isHeadOfficeCode %>";

    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            showErrMessage(errMessage);
        } // end if

        $('<button type="button" class="btn_accent" name="btn_retrieve"			id="btn_retrieve">Retrieve</button>').appendTo("#btnArea");
        $('<button type="button" class="btn_normal" name="btn_Save"  			id="btn_Save">Save</button>').appendTo("#btnArea");
        $('<button type="button" class="btn_normal" name="btn_DownExcel"  		id="btn_DownExcel">Down Excel</button>').appendTo("#btnArea");
        $('#btn_DownExcel').after($('#btn_Close'));
        loadPage();
    }
</script>

<form name="form" >
<input name="f_cmd" type="hidden" id="f_cmd" />
<input type="hidden" name="pagerows" value="<%=pageRows %>" id="pagerows" />


<%@include file="../../../../bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_TOP.jsp"%>

<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry">
		<table>
			<colgroup>
				<col width="210">
				<col width="220">
				<col width="324">
				<col width="203">
				<col width="100">
				<col width="*">				
			</colgroup> 
			<tbody>
				<tr>
					<th class="sm pad_left_4">
						<input type="radio" name="dt_option" value="B" checked="" class="trans" id="dt_option1" /><label for="dt_option1">BKG Period</label>
		                <input type="radio" name="dt_option" value="R" class="trans" id="dt_option2" /><label for="dt_option2">Report Period</label>
					</th>
					<td>
					<span name="bkg_dt" id="bkg_dt" >
					<!-- 
					 --><input type="text" style="width:74px;" class="input1" value="" dataformat="ymd" maxlength="10" caption="BKG Period Start Date" required name="bkg_cre_dt_s" cofield="bkg_cre_dt_e" style="ime-mode:disabled" /><span class="dash">~</span><!--
	                  --><input type="text" style="width:74px;" class="input1" value="" dataformat="ymd" maxlength="10" caption="BKG Period End Date" required name="bkg_cre_dt_e" cofield="bkg_cre_dt_s" style="ime-mode:disabled" /><!--
	                  --><button type="button" id="btn_bkg_cre_dt" name="btn_bkg_cre_dt" class="calendar ir"></button><!-- 
	                 -->
					</span><span  name="rpt_dt" id="rpt_dt" style="display:none;">
					<!-- 
		             --><input type="text" style="width:74px;" class="input1" value="" dataformat="ymd" maxlength="10" caption="Report Period Start Date" name="val_dt_s" cofield="val_dt_e" style="ime-mode:disabled" /><span class="dash">~</span><!--
		              --><input type="text" style="width:74px;" class="input1" value="" dataformat="ymd" maxlength="10" caption="Report Period End Date" name="val_dt_e" cofield="val_dt_s"  style="ime-mode:disabled" /><!--
	                  --><button type="button" id="btn_val_dt" name="btn_val_dt" class="calendar ir"></button><!-- 
		             -->
		             </span>
		             </td>
	                <th class="sm pad_left_8"><input type="radio" name="mtch_flg" id="mtch_flg1" value="N" checked="true" class="trans"><label for="mtch_flg1">Evaluation</label><!--
	                --><select style="width:100px;" name="val_cd" id="val_cd" caption="Evaluation Result" ></select> &nbsp; <!--
	                --><input type="radio" name="mtch_flg" id="mtch_flg2" value="Y" class="trans"><label for="mtch_flg2">Auto Matched</label></th>
	                <th style="width:150px">Inputter</th>
	                <td>
	                	<input type="text" style="width:70px;" class="input" name="doc_usr_id" id="doc_usr_id" caption="Inputter ID" maxlength="20" style="ime-mode:disabled" /><!--
	                	--><button type="button" id="doc_usr_id_inq" name="doc_usr_id_inq" class="input_seach_btn"></button>
	                </td>
	                <td></td>
				</tr>
			</tbody>
		</table>
		<table>
			<colgroup>
				<col width="100">
				<col width="115">
				<col width="100">  
				<col width="100">
				<col width="112">
				<col width="100">
				<col width="150">
				<col width="110">
				<col width="74">
				<col width="100">
				<col width="*">	
			</colgroup>
			<tbody>
				<tr>
					<th>BKG OFC</th>
		            <td>
		                <input type="text" style="width:62px;" class="input1" required name="bkg_ofc_cd" id="bkg_ofc_cd" dataformat="enguponly" caption="Booking OFC" minlength="5" maxlength="6" style="ime-mode:disabled"/><!--
	                	--><button type="button" id="bkg_ofc_cd_inq" name="bkg_ofc_cd_inq" class="input_seach_btn"></button>
		            </td>
		            <th>Code Input OFC</th>
		            <td>
		            	<input type="text" style="width:62px;" class="input" name="code_ofc_cd" id="code_ofc_cd" dataformat="enguponly" caption="Code Input OFC" minlength="5" maxlength="6" style="ime-mode:disabled" /><!--
		                --><button type="button" id="code_ofc_cd_inq" name="code_ofc_cd_inq" class="input_seach_btn"></button>
		            </td>
		            <th class="pad_left_8">Report OFC</th>
		            <td>
		            	<input type="text" style="width:60px;" class="input" name="val_ofc_cd" id="val_ofc_cd" dataformat="enguponly" caption="Report OFC" minlength="5" maxlength="6" style="ime-mode:disabled" /><!--
		                --><button type="button" id="val_ofc_cd_inq" name="val_ofc_cd_inq" class="input_seach_btn"></button>
		            </td>
					<th>Error Customer Code</th>
					<td>
						<input type="text" style="width:70px;" class="input"  name="cust_cd" id="cust_cd" dataformat="engup" caption="Error Customer Code" minlength="8" maxlength="8" fullfill="true" style="ime-mode:disabled" /><!--
		                --><button type="button" id="cust_cd_inq" name="cust_cd_inq" class="input_seach_btn"></button>
		            </td>
					<th class="pad_left_8"> Reporter</th>
					<td>
						<input type="text" style="width:70px;" class="input"  name="val_usr_id" id="val_usr_id" caption="Reporter ID" maxlength="20" style="ime-mode:disabled" /><!--
		                --><button type="button" id="val_usr_id_inq" name="val_usr_id_inq" class="input_seach_btn"></button>
		            </td>
		            <td></td>
				</tr>
			</tbody>
		</table>
		<table>
			<colgroup>
				<col width="100">
				<col width="115">
				<col width="100">
				<col width="120">
				<col width="200">
				<col width="*">				
			</colgroup>
			<tbody>
				<tr>
					<th>Customer Type</th>
					<td>
						<select style="width:90px;" name="cust_tp_cd" id="cust_tp_cd" caption="Customer Type" ></select>
					</td>
					<th class="pad_left_8">B/L No.</th>
					<td>
						<input type="text" style="width:90px;" class="input" name="bl_no" id="bl_no" dataformat="engup" caption="B/L No." maxlength="12" style="ime-mode:disabled" />
					</td>
					<th class="sm pad_left_8">
						<input type="checkbox" name="ob_ev_cd" value="1" class="trans" id="ob_ev_cd" /><label for="ob_ev_cd">Wrong Evaluation</label>
                		<input type="checkbox" name="ib_ev_cd" value="1" class="trans" id="ib_ev_cd" /><label for="ib_ev_cd">I/B Confirm</label>
                		<input type="checkbox" name="hq_ev_cd" value="1" class="trans" id="hq_ev_cd" /><label for="hq_ev_cd">H/Q Confirm </label>
					</th>
					<td></td>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">	
		<script type="text/javascript">ComSheetObject('sheet1');</script>
        <script type="text/javascript">ComSheetObject('sheet2');</script>		
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>