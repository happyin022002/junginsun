<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_2042.js
*@FileTitle  : RFA Rate Search 
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
<%@ page import="com.clt.apps.opus.esm.pri.rfareport.rfareport.event.EsmPri2042Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.component.util.code.CodeInfo"%>
<%@ page import="com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>
<%@ page import="com.clt.apps.opus.esm.pri.common.PRIUtil"%>
<%@ page import="com.clt.framework.component.common.AbstractValueObject"%>
<%@ page import="java.util.List"%>
<%
    EsmPri2042Event  event = null;              //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //error from server
    String strErrMsg = "";                      //error message
    int rowCount     = 0;                       //count of DB resultSET list

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";

    String[] svcScpCds = null;
    String[] charges = null;
    String[] tpSzs = null;
    String[] cargoTypes = null;
    String[] customerTypes = null;
    String[] rates = null;

    Logger log = Logger.getLogger("com.clt.apps.RFAReport.RFAReport");

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();

        event = (EsmPri2042Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        // adding logic to get data from server when first loading
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

        // scope Combo Data 
        svcScpCds = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("svcScpCd"));
        // charges Combo Data 
        charges = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("charge"), false , "|", "\t", "getCode", "getName");
        // tp sz Combo Data 
        tpSzs = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("tpSz"), false);
        // cargo type Combo Data 
        cargoTypes = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("cargoType"), true , "|", "\t", "getCode", "getName");
        // customer type Combo Data 
        customerTypes = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("customerType"), false , "|", "\t", "getCode", "getName");
        // rate, mqc Combo Data 
        rates = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("rate"), false , "|", "\t", "getCode", "getName");

    }catch(Exception e) {
        out.println(e.toString());
    }
%>

<script type="text/javascript">

    var svcScpCdComboValue = "|<%=svcScpCds[0]%>";
    var svcScpCdComboText = "|<%=svcScpCds[1]%>";

    var chargeComboValue = "|<%=charges[0]%>";
    var chargeComboText = "|<%=charges[1]%>";

    var tpSzComboValue = "|<%=tpSzs[0]%>";
    var tpSzComboText = "|<%=tpSzs[1]%>";

    var cargoTypeComboValue = "|<%=cargoTypes[0]%>";
    var cargoTypeComboText = "|<%=cargoTypes[1]%>";

    var customerTypeComboValue = "|<%=customerTypes[0]%>";
    var customerTypeComboText = "|<%=customerTypes[1]%>";

    var rateComboValue = "|<%=rates[0]%>";

    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            showErrMessage(errMessage);
        } // end if
        loadPage();
    }
</script>


<form name="form" id="form">
<!--  Office Code Validation check -->
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="cd" id="cd" />
<input type="hidden" name="backendjob_key" id="backendjob_key" />
<!--  Office Code Validation check -->
<input type="hidden" name="ofc_cd" value="" id="ofc_cd" />
<!-- Form Hidden -->
<input type="hidden" name="etc1" value="" id="etc1" />
<input type="hidden" id="eff_dt" name="eff_dt" />
<input type="hidden" id="exp_dt" name="exp_dt" />

<!-- page(S) -->
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	
	<!-- page_title(S) -->
    <!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->

	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
		--><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!--
		--><button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button><!--
		--><button type="button" class="btn_normal" name="btn_viewrfa" id="btn_viewrfa">View RFA</button>
	</div>
	<!-- opus_design_btn(E) -->

   	<!-- page_location(S) -->
   	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
        <span id="navigation"></span>
   	</div>
   	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->

<!-- opus_design_inquiry(S) -->
<div class="wrap_search">
<div class="opus_design_inquiry wFit">
	<!--  MiniLayer (S) -->
	<table>
		<colgroup>
            <col width="110" />
            <col width="350" />
            <col width="90" />
            <col width="248" />
            <col width="100" />
            <col width="*" />
		</colgroup>
		<tbody>
			<tr>
				<th>SVC Scope</th>
                <td><script type="text/javascript">ComComboObject('svc_scp_cd', 2, 55, 0, 1, 0, false);</script><input type="text" name="svc_scp_nm" id="svc_scp_nm" style="width:261px;" class="input2" readonly></td>
                <th><input type="radio" name="rdoDate" id="rdoDate" value="2" class="trans"><label for="rdoDate1">RFA EFF Date</label></th>
                <td><input type="text" style="width:75px;text-align:center;" class="input" caption="RFA EFF Date From" name="eff_date_from" id="eff_date_from" dataformat="ymd" maxLength="10" minlength="8"><!-- 
                    --><button type="button" class="calendar ir" name="btns_calendar1" id="btns_calendar1"></button>~&nbsp;<!-- 
                    --><input type="text" style="width:75px;text-align:center;" class="input" caption="RFA EFF Date To" name="eff_date_to" id="eff_date_to" dataformat="ymd" maxLength="10" minlength="8"><!-- 
                    --><button type="button" class="calendar ir" name="btns_calendar2" id="btns_calendar2"></button> </td>
                <th><input type="radio" name="rdoDate" id="rdoDate" value="1" class="trans" checked><label for="rdoDate2">Access Date</label></th>
                <td><input type="text" style="width:76px;text-align:center;" name="access_date" id="access_date" class="input1" dataformat="ymd" maxLength="10" minlength="8" caption="Access Date"><!-- 
                 --><button type="button" class="calendar ir" name="btns_calendar3" id="btns_calendar3"></button></td>
	      
			</tr>
		</tbody>
	</table>
	<table>
		<colgroup>
            <col width="110" />
            <col width="70" />
            <col width="70" />
            <col width="70" />
            <col width="62" />
            <col width="57" />
            <col width="87" />
            <col width="80" />
            <col width="70" />
            <col width="70" />
            <col width="70" />
            <col width="80" />
            <col width="74" />
            <col width="*" />
		</colgroup>	
		<tbody>
			<tr>
				<th>Origin</th>
                <td><input type="text" name="rout_pnt_loc_def_cd_ori" style="width:55px;text-align:center;ime-mode:disabled" class="input" dataformat="engup" maxlength="5" id="rout_pnt_loc_def_cd_ori" /> </td>
                <th>Origin Via</th>
                <td><input type="text" name="rout_via_port_def_cd_ori" style="width:55px;text-align:center;ime-mode:disabled" class="input" dataformat="engup" maxlength="5" id="rout_via_port_def_cd_ori" /> </td>
                <th>Dest Via</th>
                <td><input type="text" name="rout_via_port_def_cd_dest" style="width:55px;text-align:center;ime-mode:disabled" class="input" dataformat="engup" maxlength="5" id="rout_via_port_def_cd_dest" /> </td>
                <th>Destination</th>
                <td><input type="text" name="rout_pnt_loc_def_cd_dest" style="width:55px;text-align:center;ime-mode:disabled" class="input" dataformat="engup" maxlength="5" id="rout_pnt_loc_def_cd_dest" /> </td>
                <th>Charge</th>
                <td><script type="text/javascript">ComComboObject('chg_cd', 1, 60, 0, 0, 0, false);</script></td>
                <th>TP/SZ</th>
                <td><script type="text/javascript">ComComboObject('rat_ut_cd', 2, 60, 0, 0, 0, false);</script></td>
                <th>Cargo Type</th>
                <td><script type="text/javascript">ComComboObject('prc_cgo_tp_cd', 2, 62, 0, 0, 0, false);</script></td>
            </tr>
     	</tbody>
	</table>
	<table>
		<colgroup>
            <col width="110" />
            <col width="100" />
            <col width="100" />
            <col width="120" />
            <col width="60" />
            <col width="150" />
            <col width="90" />
            <col width="79" />
            <col width="70" />
            <col width="*" />
		</colgroup>	
		<tbody>    
            <tr>
            	<th>RFA No.</th>
                <td><input type="text" name="rfa_no" style="width:96px;text-align:center;ime-mode:disabled" class="input" dataformat="engup" maxLength="11"></td>
                <th>Actual Customer</th>
                <td><input type="text" name="cust_cnt_cd" style="width:32px;ime-mode:disabled;text-align:center" class="input" dataformat="enguponly" maxlength="2" minlength="2"><!-- 
                	 --><input type="text" name="cust_seq" style="width:50px;ime-mode:disabled;text-align:center" class="input" dataformat="num" maxlength="6"><!-- 
                	 --><button type="button" class="input_seach_btn" name="btn_cust" id="btn_cust"></button>
                </td>
                <th>Customer</th>
                <td><input type="text" name="ctrt_cust_cnt_cd" id="ctrt_cust_cnt_cd" style="width:30px;ime-mode:disabled;text-align:center" class="input" dataformat="enguponly" maxlength="2" minlength="2"><!-- 
                	 --><input type="text" name="ctrt_cust_seq" id="ctrt_cust_seq"  style="width:50px;ime-mode:disabled;text-align:center" class="input" dataformat="num" maxlength="6"><!-- 
                	 --><button type="button" class="input_seach_btn" name="btn_ctrt_cust" id="btn_ctrt_cust"></button>
                <th>Customer Type</th>
                <td><script type="text/javascript">ComComboObject('prc_ctrt_cust_tp_cd', 1, 70, 0, 0, 0, false);</script></td>
                <th>Commodity</th>
                <td><input type="text" style="width:82px;text-align:center;ime-mode:disabled" class="input" name="prc_cmdt_def_cd" dataformat="num" maxLength="6"><!-- 
                	 --><button type="button" class="input_seach_btn" name="btn_commodity" id="btn_commodity"></button>
                </td>
            </tr>
     
            <tr>
            	<th>Rate</th>
                <td><script type="text/javascript">ComComboObject('fnl_frt_rt', 1, 40, 0, 0, 0, false);</script><!-- 
                	 --><input type="text" style="width:52px;text-align:right;ime-mode:disabled" class="input" name="fnl_frt_rt_amt" id="fnl_frt_rt_amt" dataformat="num" maxLength="6"></td>
                <th>Target MVC</th>
                <td><script type="text/javascript">ComComboObject('fnl_mqc', 1, 40, 0, 0, 0, false);</script><!-- 
                	 --><input type="text" style="width:71px;text-align:right;ime-mode:disabled" class="input" name="fnl_mqc_qty" id="fnl_mqc_qty" dataformat="num" maxLength="6"></td>
                <th>Request Office</th>
                <td><input type="text" style="width:84px;text-align:center;ime-mode:disabled" class="input" id="prop_scp_ofc_cd" name="prop_scp_ofc_cd" dataformat="engup" maxLength="6"><!-- 
                	 --><button type="button" class="input_seach_btn" name="ComOpenPopupWithTarget" id="btn_popup1"></button>
                </td>
                <th>Sales Rep</th>
                <td colspan="3"><input type="text" name="prop_scp_srep_cd" id="prop_scp_srep_cd" style="width:70px;text-align:center;ime-mode:disabled" class="input" dataformat="engup" maxLength="5"></td>
            </tr>
         </tbody>
	</table>
	<table>
		<colgroup>
            <col width="110" />
            <col width="280" />
            <col width="*" />
		</colgroup>	
		<tbody>    
            <tr style="heignt:30px">
               	<th>Additional Option</th>
                <td class="sm"><input type="checkbox" class="trans" name="chkDisplay" id="chkDisplay" value="rcv_de_term_cd">&nbsp;<lable for="chkDisplay">Receiving/Delivering Term&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</lable><!-- 
                     --><input type="checkbox" name="previous_rate" id="previous_rate" value="N" class="trans">&nbsp;<lable for="previous_rate">Previous Rate</lable>
                </td>
                <td></td>
            </tr>
		</tbody>
	</table>
	<!-- 조회영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
</div>
</div>
<!-- opus_design_inquiry(E) -->

<!-- opus_design_grid(S) -->
<div class="wrap_result">
<div class="opus_design_grid">
	<!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
    <script type="text/javascript">ComSheetObject('sheet1');</script>
    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
</div>
</div>
<!-- opus_design_grid(E) -->

<div style="display: none">
	<script type="text/javascript">ComSheetObject('sheet2');</script>
</div>
<!-- page(E) -->

</form>