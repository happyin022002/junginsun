<%
/*=========================================================
* 1.0 Creation
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_0015.jsp
*@FileTitle  :  S/C Master Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.pri.scproposal.scproposalmain.event.EsmPri0015Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.component.util.code.CodeInfo"%>
<%@ page import="com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>
<%@ page import="com.clt.apps.opus.esm.pri.common.PRIUtil"%>
<%@ page import="com.clt.framework.component.common.AbstractValueObject"%>
<%@ page import="java.util.List"%>

<%
    EsmPri0015Event  event = null;                  //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //error from server
    String strErrMsg = "";                      //error message
    int rowCount     = 0;                       //count of DB resultSET list

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    String strUsr_ofc       = "";
    String[] svcScpCds = null;
    String[] appOfcCds = null;
    String[] custTpCds = null;
    String[] lodUtCds = null;
    Logger log = Logger.getLogger("com.clt.apps.SCProposal.SCProposalMain");

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
        strUsr_ofc = account.getOfc_cd();

        event = (EsmPri0015Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

         
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        // Service Scope Combo Data 
        svcScpCds = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("svcScpCd"));
        // Approval Office Combo Data creation
        appOfcCds = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("appOfcCd"));
        // Customer Type Combo Data creation
        custTpCds = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("custTpCd"),true ,"|","\t","getCode","getName");
        // Container Load Unit Combo Data creation
        lodUtCds = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("lodUtCd"), false,"|","\t","getCode","getName");

    }catch(Exception e) {
        out.println(e.toString());
    }
%>
<script type="text/javascript">
    var svcScpComboValue = " |<%=svcScpCds[0]%>";
    var svcScpComboText = " |<%=svcScpCds[1]%>";

    var appOfcComboValue = "<%=appOfcCds[0]%>";
    var appOfcComboText = "<%=appOfcCds[1]%>";
        
    var custTpComboValue = "<%=custTpCds[0]%>";   
    var custTpComboText = "<%=custTpCds[1]%>";

    var lodUtComboValue = "<%=lodUtCds[0]%>";   
    var lodUtComboText = "<%=lodUtCds[1]%>";
    
    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            showErrMessage(errMessage);
        } // end if
        loadPage();
    }
</script>
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">
<input type="hidden" name="prop_no" id="prop_no">
<input type="hidden" name="amdt_seq" id="amdt_seq">
<input type="hidden" name="in_usr_ofc_cd" id="in_usr_ofc_cd" value="<%=strUsr_ofc%>">
<input type="hidden" name="in_usr_srep_cd" id="in_usr_srep_cd" value="<%=strUsr_id%>">
<input type="hidden" name="in_usr_nm" id="in_usr_nm" value="<%=strUsr_nm%>">
<input type="hidden" name="is_goto_prop" id="is_goto_prop">

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!-- 
	 --><button type="button" class="btn_normal" name="btn_New" id="btn_New">New</button><!-- 
	 --><button type="button" class="btn_normal" name="btn_Save" id="btn_Save">Save</button><!-- 
     --><button type="button" class="btn_normal" name="btn_Delete" id="btn_Delete">Delete</button><!-- 
     --><button type="button" class="btn_normal" name="btn_GoToProposal" id="btn_GoToProposal">Go To Proposal</button>				
	</div>
	<!-- opus_design_btn(E) -->
	
	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>



<div class="wrap_search">
	<!-- opus_design_inquiry (S) -->
	<div class="opus_design_inquiry wFit">
		<table>
	        <tr>
	        	<th width="97">S/C  No.</th>
	        	<td width="150"><input type="text" caption="S/C Number" style="width:108px;ime-mode:disabled;" name="sc_no"  id="sc_no" dataformat="engup" maxlength="20" class="input1" required></td>
	          	<th width="65">Duration</th>
	          	<td width="315">                                        
	          		<span class="inquiry_calendar">
				 		<input type="text" caption="Duration" name="ctrt_eff_dt" id="ctrt_eff_dt" cofield="ctrt_exp_dt" maxlength="10" dataformat="ymd" style="width:70px;" readonly="readonly" class="input1" required>
				 		<span class="dash">-</span>
				 		<input type="text" caption="Duration" name="ctrt_exp_dt" id="ctrt_exp_dt" cofield="ctrt_eff_dt" maxlength="10" dataformat="ymd" style="width:70px;" readonly="readonly" class="input1" required><!-- 
				 		 --><button type="button" name="btns_calendar" id="btns_calendar"  class="calendar ir"></button>
					</span>
	          	</td>
	          	<th width="97">Status</th>
	          	<td width=""><input type="text" style="width:68;" name="prc_mst_prop_tp_nm" id="prc_mst_prop_tp_nm" value="" readonly="readonly" class="input2" >&nbsp;<input type="text" style="width:73;display:none;" name="prop_sts" readonly="readonly" class="input2" ></td>
	         </tr>
		</table>
		<table>
            <tr>
                <th width="97">Request Office</th>
                <td width="150"><input type="text" style="width:108px;" name="prop_ofc_cd" id="prop_ofc_cd" dataformat="engup" readonly="readonly" class="input1" caption="Request Office Code" required></td>
          		<th width="65">Sales Rep.</th>
          		<td width="315"> <script type="text/javascript">ComComboObject('prop_srep_cd', 2, 92, 0, 1);</script>
          			<input type="text" style="width:125px;" name="prop_srep_nm" id="prop_srep_nm" readonly="readonly" class="input2" />
          		</td>
        		<th width="97">Approval Office</th>
          		<td style="padding-left:0;"><script type="text/javascript">ComComboObject('prop_apro_ofc_cd', 2, 68, 0, 1);</script></td>                    
      		</tr>
      	</table>
	    <table>
	    	<tr>
	        	<th width="97">Customer</th>
	          	<td width="106"><input type="text" style="width:25px;" dataformat="enguponly" maxlength="2" minlength="2" name="cust_cnt_cd" id="cust_cnt_cd" readonly="readonly" class="input2" caption="Customer Code" /><!-- 
	          		 --><input type="text" style="width:50px;" dataformat="num" name="cust_seq" id="cust_seq" maxlength="6" readonly="readonly" class="input1" caption="Customer Code" required/><!--           
	          		 --><button type="button" name="btn_ctrt_cust" id="btn_ctrt_cust"  class="input_seach_btn"></button>          
	          	</td>
	          	<td width="280"><input type="text" style="width:357px;" name="ctrt_pty_nm" id="ctrt_pty_nm"  readonly="readonly" class="input2"/></td>
	          	<td style="padding-left:3px;"><script type="text/javascript">ComComboObject('prc_ctrt_cust_tp_cd', 2, 37, 0, 1);</script><!-- 
	           		--><input type="text" style="width:56px;" name="ctrt_cust_val_sgm" id="ctrt_cust_val_sgm"  readonly="readonly" class="input2"/><!-- 
					--><input type="text" style="width:56px;" name="ctrt_cust_sls_ofc_cd" id="ctrt_cust_sls_ofc_cd" readonly="readonly" class="input2" caption="Customer Code"/><!-- 
					--><script type="text/javascript">ComComboObject('ctrt_cust_srep_cd', 2, 94, 0, 1);</script><!-- 
	           		--><input type="text" style="width:230px;" name="ctrt_cust_srep_nm" id="ctrt_cust_srep_nm" readonly="readonly" class="input2"/>
	          	</td>
	      	</tr>
	      	<tr>
	        	<th>Real Customer</th>
	          	<td><input type="text" style="width:25px;" name="real_cust_cnt_cd" id="real_cust_cnt_cd" maxlength="2" dataformat="engup" readonly="readonly" class="input2"><!-- 
	          		--><input type="text" style="width:78px;" name="real_cust_seq" id="real_cust_seq" dataformat="num" maxlength="6" readonly="readonly" class="input2"></td>
	          	<td><input type="text" style="width:357px;" name="real_cust_nm" id="real_cust_nm" readonly="readonly" class="input2"></td>
	          	<td style="padding-left:3px;"><input type="text" style="width:37px;text-align:center;" name="real_cust_tp_cd" id="real_cust_tp_cd" readonly="readonly" class="input2"><!-- 
	          		--><input type="text" style="width:56px;" name="real_cust_val_sgm" id="real_cust_val_sgm" readonly="readonly" class="input2"><!-- 
	          		--><input type="text" style="width:56px;" name="real_cust_sls_ofc_cd" id="real_cust_sls_ofc_cd" readonly="readonly" class="input2"><!-- 
	          		--><input type="text" style="width:94px;" name="real_cust_srep_cd" id="real_cust_srep_cd" readonly="readonly" class="input2"><!-- 
	          		--><input type="text" style="width:230px;" name="real_cust_srep_nm" id="real_cust_srep_nm" readonly="readonly" class="input2">
	          	</td>
	      	</tr>
	      	<tr>
	        	<th width="">MQC</th>
	          	<td width="" colspan="2">
	          		<input type="text" style="width:107px;text-align:right;" name="prop_mqc_qty" id="prop_mqc_qty" class="input1" caption="MQC" dataformat="num" required>
	          		<script type="text/javascript">ComComboObject('cntr_lod_ut_cd', 1, 92, 0, 1);</script>
	          	</td>
	          	<td><img src="img/blank.gif" style="width:7px;height:10px;">
	          	<span style="font-weight:bold">MVC</span><img src="img/blank.gif" style="width:4px;height:10px;">
	          	<input type="text" style="width:56px;text-align:right;" name="prop_mvc" id="prop_mvc" readonly="readonly" class="input2"></td>
	      	</tr>
		</table>
	</div>
	<!-- opus_design_inquiry (E) -->
</div>


<!-- page_title_area(E) -->

<div class="wrap_result">

	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" style="display:none">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<!-- opus_design_grid(E) -->

	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<!-- Content -->
			<button type="button" class="btn_normal" name="btn_RowAdd" id="btn_RowAdd">Row Add</button>
			<button type="button" class="btn_normal" name="btn_DeleteRow" id="btn_DeleteRow">Delete</button>
		</div>
		<!-- opus_design_btn(e) -->	
	<script type="text/javascript">ComSheetObject('sheet2');</script>
	</div>
	<!-- opus_design_grid(E) -->

	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet3');</script>
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>
