<!--
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_PRI_6101.jsp
*@FileTitle  : Find Contract
*@author     : CLT
*@version    : 1.0
*@since      : 2014/12/10
=========================================================*/
-->

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.pri.prisimulation.prisimulation.event.EsmPri6101Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.component.util.code.CodeInfo"%>
<%@ page import="com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>
<%@ page import="com.clt.apps.opus.esm.pri.common.PRIUtil"%>
<%@ page import="com.clt.framework.component.common.AbstractValueObject"%>
<%@ page import="java.util.List"%>

<%
	EsmPri6101Event  event 		= null;			//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg 			= "";			//에러메세지 
	int rowCount	 			= 0;			//DB ResultSet 리스트의 건수
	
	String successFlag 			= "";
	String codeList  			= "";
	String pageRows  			= "100";
	
	String strUsr_id 			= "";
	String strUsr_nm 			= "";
	String strUsr_ofc 			= "";
	String strUsrSrepCd 		= "";
	
	String[] svcScpCds = null;
    String[] cargoTypes = null;
    String[] customerTypes = null;
	
	Logger log = Logger.getLogger("com.clt.apps.opus.esm.pri.prisimulation.prisimulation");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   	strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_ofc = account.getOfc_cd();
		strUsrSrepCd = account.getSrep_cd();
	
		event = (EsmPri6101Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
	
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
	
		// scope Combo Data 
        svcScpCds = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("svcScpCd"));
        // cargo type Combo Data 
        cargoTypes = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("cargoType"), true , "|", "\t", "getCode", "getName");
        // customer type Combo Data 
        customerTypes = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("customerType"), false , "|", "\t", "getCode", "getName");
	
	}catch(Exception e) {
		out.println(e.toString());
	}
	
	String v_eff_dt = JSPUtil.getNull(request.getParameter("peff_dt"));
	
%>

<script language="javascript">

	var svcScpCdComboValue = "|<%=svcScpCds[0]%>";
	var svcScpCdComboText = "|<%=svcScpCds[1]%>";

	var cargoTypeComboValue = "|<%=cargoTypes[0]%>";
	var cargoTypeComboText = "|<%=cargoTypes[1]%>";
	
	var customerTypeComboValue = "|<%=customerTypes[0]%>";
	var customerTypeComboText = "|<%=customerTypes[1]%>"; 

    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            showErrMessage(errMessage);
        } // end if
        
        loadPage();
    }

</script>

<form id="form" name="form">
<input type="hidden" id="f_cmd" name="f_cmd">
<input type="hidden" id="pagerows" name="pagerows">
<input type="hidden" id="strusr_id" name="strusr_id" value="<%=strUsr_id %>">

<!-- OUTER - POPUP (S)tart -->
<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title"><span>Find Contract</span></h2>
		<!-- page_title(E) -->
		
		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!-- 
			  --><button type="button" class="btn_normal" name="btn_New" id="btn_New">New</button><!-- 
			  --><button type="button" class="btn_normal" name="btn_Ok" id="btn_Ok">OK</button><!-- 
			  --><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
		</div>
		<!-- opus_design_btn (E) -->
	
	</div>
	<!-- page_title_area(E) -->
</div>


<div class="layer_popup_contents">

	<!-- opus_design_inquiry(S) -->
    <div class="wrap_search">
  		<div class="opus_design_inquiry wFit">
    		<table>
                <colgroup>
                    <col width="120" />
                    <col width="120" />
                    <col width="120" />
                    <col width="120" />
                    <col width="100" />
                    <col width="120" />
                    <col width="100" />
                    <col width="90" />
                </colgroup>
                <tbody>
                    <tr>
                        <th>SVC Scope</th>
                        <td colspan="3"><script type="text/javascript">ComComboObject('ssvc_scp_cd', 2, 85, 0, 1, 0, false);</script><!--
                        --><input type="text" id="ssvc_scp_nm" name="ssvc_scp_nm" style="width:355px" class="input2"  value="" readonly/></td>
                        <th>Access Date</th>
                        <td><input type="text" style="width: 85px;text-align:center;" class="input1" name="seff_dt" id="seff_dt" maxlength="10" dataformat="ymd" value="<%=v_eff_dt %>" /><button type="button" class="calendar ir"  name="btns_calendar1"  id="btns_calendar1"></button></td>
                        <th>Contract No.</th>
                        <td><input type="text" style="width: 85px;" class="input" name="scontract_no" id="scontract_no" dataformat="engup" value="" maxlength="10" /></td>
                    </tr>

					
                    <tr>
                        <th>Origin</th>
                        <td><input type="text" name="srout_pnt_loc_def_cd_ori" style="width:85px;text-align:center;ime-mode:disabled" class="input" dataformat="engup" maxlength="5" id="srout_pnt_loc_def_cd_ori" /></td>
                        <th>Origin Via</th>
                        <td><input type="text" name="srout_via_port_def_cd_ori" style="width:85px;text-align:center;ime-mode:disabled" class="input" dataformat="engup" maxlength="5" id="srout_via_port_def_cd_ori" /></td>
                        <th>Dest Via</th>
                        <td><input type="text" name="srout_via_port_def_cd_dest" style="width:85px;text-align:center;ime-mode:disabled" class="input" dataformat="engup" maxlength="5" id="srout_via_port_def_cd_dest" /></td>
                        <th>Destination</th>
                        <td><input type="text" name="srout_pnt_loc_def_cd_dest" style="width:85px;text-align:center;ime-mode:disabled" class="input" dataformat="engup" maxlength="5" id="srout_pnt_loc_def_cd_dest" /></td>
                    </tr>

                    <tr>
                        <th>Customer</th>
                        <td><input type="text" name="sctrt_cust" id="sctrt_cust" style="width:32px;ime-mode:disabled;text-align:center" class="input1" dataformat="enguponly" maxlength="2" minlength="2" /><!-- 
                	 --><input type="text" name="sctrt_cust_seq" id="sctrt_cust_seq" style="width:50px;ime-mode:disabled;text-align:center" class="input1" dataformat="num" maxlength="6"><!-- 
                	 --><button type="button" class="input_seach_btn" name="btn_sctrt_cust" id="btn_sctrt_cust"></button></td>
                        <th>Actual Customer</th>
                        <td><input type="text" name="scust" id="scust" style="width:32px;ime-mode:disabled;text-align:center" class="input" dataformat="enguponly" maxlength="2" minlength="2" /><!-- 
                	 --><input type="text" name="scust_seq" id="scust_seq" style="width:50px;ime-mode:disabled;text-align:center" class="input" dataformat="num" maxlength="6"><!-- 
                	 --><button type="button" class="input_seach_btn" name="btn_scust" id="btn_scust"></button></td>
                        <th>Cargo Type</th>
                        <td><script type="text/javascript">ComComboObject('sprc_cgo_tp_cd', 2, 85, 0, 0, 0, false);</script></td>
                        <th>Sales Rep</th>
                        <td><input type="text" name="sprop_scp_srep_cd" id="sprop_scp_srep_cd" style="width:85px;text-align:center;ime-mode:disabled" class="input" dataformat="engup" maxLength="5" /></td>
                    </tr>

                    <tr>
                        <th>Contract Request Office</th>
                        <td><input type="text" style="width:85px;text-align:center;ime-mode:disabled" class="input" id="sprop_scp_ofc_cd" name="sprop_scp_ofc_cd" dataformat="engup" maxLength="6" /><!-- 
                	 --><button type="button" class="input_seach_btn" name="btn_sprop_scp_ofc" id="btn_sprop_scp_ofc"></button></td>
                        <th>Customer Type</th>
                        <td colspan="5"><script type="text/javascript">ComComboObject('sprc_ctrt_cust_tp_cd', 1, 85, 0, 0, 0, false);</script></td>
                    </tr>

                    <tr>
                        <td></td>
                        <td  class="sm" >
                        	<input type="radio" name="s_contract_type" id="s_contract_type1" value="1" class="trans" checked="true" /><label for="s_contract_type1">S/C</label><!--
	                            --><input type="radio" name="s_contract_type" id="s_contract_type1" value="2" class="trans" /><label for="s_contract_type2">RFA</label><!--
	                            --><input type="radio" name="s_contract_type" id="s_contract_type1" value="3" class="trans" /><label for="s_contract_type3">TAA</label>
                        </td>
                        <td colspan="6"></td>
                    </tr>
                </tbody>
             </table>
    	</div>
   
    </div>
	<!-- opus_design_inquiry(E) -->
	
	<!-- opus_design_grid(S) -->
	<div class="wrap_result">
		<div class="opus_design_grid">
			 <script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
    </div> 
    <!-- opus_design_grid(E) -->
      
</div>

</form>