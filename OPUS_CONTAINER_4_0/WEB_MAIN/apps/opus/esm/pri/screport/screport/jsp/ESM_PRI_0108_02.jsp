<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_0108_02.jsp
*@FileTitle  : S/C Performance Summary 
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
<%@ page import="com.clt.apps.opus.esm.pri.screport.screport.event.EsmPri010802Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.component.util.code.CodeInfo"%>
<%@ page import="com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>
<%@ page import="com.clt.apps.opus.esm.pri.common.PRIUtil"%>
<%@ page import="com.clt.framework.component.common.AbstractValueObject"%>
<%@ page import="java.util.List"%>

<%
    EsmPri010802Event  event = null;              //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //error from server
    String strErrMsg = "";                      //error message
    int rowCount     = 0;                       //count of DB resultSET list
    
    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    
    String[] scNoPrefixs = null;    
    String[] svcScpCds = null;        
    String[] skdDirCds = null;        
    String[] rtTpCds = null;        
    String[] usModCds = null;        
    
    Logger log = Logger.getLogger("com.clt.apps.SCReport.SCReport");
    
    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
       
        event = (EsmPri010802Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
                
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        
        // S/C No Combo Data creation
        scNoPrefixs = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("scNoPrefix"));
        // Scope Combo Data creation
        svcScpCds = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("svcScpCd"));
        // Direction Combo Data creation
        skdDirCds = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("skdDirCd"), true , "|", "\t", "getCode", "getName");
        // Rate Type Combo Data creation
        rtTpCds = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("rtTpCd"), true , "|", "\t", "getCode", "getName");
        // US Mode
        usModCds = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("usModCd"), true , "|", "\t", "getCode", "getName");
        
    }catch(Exception e) {
        out.println(e.toString());
    }
%>

<script language="javascript">

    var scNoPrefixComboValue = "|<%=scNoPrefixs[0]%>";
    var scNoPrefixComboText = "|<%=scNoPrefixs[1]%>";

    var svcScpCdComboValue = "|<%=svcScpCds[0]%>";
    var svcScpCdComboText = "|<%=svcScpCds[1]%>";

    var skdDirCdComboValue = "|<%=skdDirCds[0]%>";
    var skdDirCdComboText = "|<%=skdDirCds[1]%>";

    var rtTpCdComboValue = "|<%=rtTpCds[0]%>";
    var rtTpCdComboText = "|<%=rtTpCds[1]%>";

    var usModCdComboValue = "|<%=usModCds[0]%>";
    var usModCdComboText = "|<%=usModCds[1]%>";

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
<input type="hidden" name="pagerows">
<input type="hidden" name="cd">
<input type="hidden" name="backendjob_key">
<input type="hidden" name ="ofc_cd" value="">
<input type="hidden" id="searchParam" name="sc_no">
<!-- Form Hidden -->

<!-- page(S) -->
<!-- opus_design_inquiry(S) -->
<div class="wrap_result">
<div class="opus_design_inquiry wFit">
	<!--  MiniLayer (S) -->
	<table>
			<tr>
				<th width="150px"><nobr>S/C No</nobr></th>
				<td>
				   <script language="javascript">ComComboObject('sc_no_prefix', 2, 55, 0, 1, 0, false);</script><!-- 
				    --><input type="text" class="input1" style="width:60px;text-align:center;ime-mode:disabled" name="sc_no_suffix" id="sc_no_suffix"  dataformat="num" maxLength="6">
				</td>
				<th>Customer</th>
				<td colspan="7">
				   <nobr>
				   <input type="text" style="width:30px; text-align:center" class="input2" id="scInfomation" name="cust_cnt_cd" readonly><!-- 
				    --><input type="text" style="width:50px; text-align:center"  class="input2" id="scInfomation" name="cust_seq" readonly><!-- 
				    --><input type="text" style="width:220px" class="input2" id="scInfomation" name="ctrt_pty_nm" readonly><!-- 
				    --><input type="text" style="width:20px"  class="input2" id="scInfomation" name="prc_ctrt_cust_tp_cd" readonly><!-- 
				    --><input type="text" style="width:50px; text-align:center"  class="input2" id="scInfomation" name="ctrt_cust_sls_ofc_cd" readonly><!-- 
				    --><input type="text" style="width:50px; text-align:center"  class="input2" id="scInfomation" name="ctrt_cust_srep_cd" readonly><!-- 
				    --><input type="text" style="width:80px"  class="input2" id="scInfomation" name="srep_nm" readonly><!-- 
				    --><input type="text" style="width:75px; text-align:center"  class="input2" id="scInfomation" name="ctrt_eff_dt" readonly>&nbsp;~&nbsp;
				   <input type="text" style="width:75px; text-align:center"  class="input2" id="scInfomation" name="ctrt_exp_dt" readonly>
				   </nobr>
				</td>
			</tr>
			<tr>
				<th><nobr>Period (B/L Onboard DT)</nobr></th>
				<td colspan="2">
				    <nobr>
					<input type="text" style="width:70px;text-align:center;" class="input" name="bl_obrd_dt_from" id="bl_obrd_dt_from" caption="Period (B/L Onboard DT)" dataformat="ymd" maxLength="10" minlength="8"><!-- 
					 --><button type="button" class="calendar ir" name="btns_calendar1" id="btns_calendar1"></button>~
					<input type="text" style="width:70px;text-align:center;" class="input" name="bl_obrd_dt_to" id="bl_obrd_dt_to" caption="Period (B/L Onboard DT)" dataformat="ymd" maxLength="10" minlength="8"><!-- 
					 --><button type="button" class="calendar ir" name="btns_calendar2" id="btns_calendar2"></button>
					</nobr>
				</td>
				<th><nobr>Trade</nobr>
					<script language="javascript">ComComboObject('trd_cd', 2, 65, 0, 0, 0, false);</script>
				</th>
				<th><nobr>Direction</nobr>
					<script language="javascript">ComComboObject('skd_dir_cd', 1, 35, 0, 0, 0, false);</script>
				</th>
				<th><nobr>Sub Trade</nobr>
					<script language="javascript">ComComboObject('sub_trd_cd', 2, 60, 0, 0, 0, false);</script>
				</th>
				<th><nobr>Lane</nobr>
					<script language="javascript">ComComboObject('vsl_slan_cd', 2, 55, 0, 0, 0, false);</script>
				</th>
				<th colspan="2"><nobr>VVD</nobr>
                	<nobr>
                    	  <input type="text" id="vsl_cd" name="vsl_cd" class="input" style="width:40px;text-align:center;ime-mode:disabled" dataformat="engup" caption="VVD" maxLength="4"><!-- 
                     --><input type="text" id="skd_voy_no" name="skd_voy_no" class="input" style="width:40px;text-align:center;ime-mode:disabled" dataformat="uppernum" caption="VVD" maxLength="4"><!-- 
                     --><input type="text" id="skd_dir_cd_txt" name="skd_dir_cd_txt" class="input" style="width:20px;text-align:center;ime-mode:disabled" dataformat="engup" caption="VVD" maxLength="1"><!-- 
                     --><button type="button" class="input_seach_btn" name="btn_com_ens_ob2" id="btn_com_ens_ob2"></button>
                    </nobr>
                </th>
			</tr>
			<tr>
				<th><nobr>SVC Scope</nobr></th>
                <th><script language="javascript">ComComboObject('svc_scp_cd', 2, 50, 0, 0, 0, false);</script>
				<nobr>Rate Type</nobr>
					<script language="javascript">ComComboObject('gen_spcl_rt_tp_cd', 2, 40, 0, 0, 0, false);</script>
				</th>
				<th title="Commodity Group(Bullet)"><nobr>C.Group(Bul.)</nobr>
					<script language="javascript">ComComboObject('cmdt_hdr_seq', 1, 60, 0, 0, 0, false);</script>
				</th>
				<th title="Actual Customer"><nobr>A.Customer</nobr>
					<script language="javascript">ComComboObject('act_cust_cd', 1, 50, 0, 0, 0, false);</script>
				</th>
				<th><nobr>US Mode</nobr>
					<script language="javascript">ComComboObject('usa_svc_mod_cd', 2, 60, 0, 0, 0, false);</script>
				</th>
                <th>POR
                	<nobr><input type="text" id="por_cd" name="por_cd" maxlength="5" dataformat="engup" style="width:50px;text-align:center;ime-mode:disabled;"><!-- 
                	 --><button type="button" class="input_seach_btn" name="btn_por_cd" id="btn_por_cd"></button></nobr>
                </th>
                <th>POL
                	<nobr><input type="text" id="pol_cd" name="pol_cd" maxlength="5" dataformat="engup" style="width:50px;text-align:center;ime-mode:disabled;"><!--             	
                	 --><button type="button" class="input_seach_btn" name="btn_pol_cd" id="btn_pol_cd"></button></nobr>
                </th>
                <th>POD
                	<nobr><input type="text" id="pod_cd"  name="pod_cd" maxlength="5" dataformat="engup" style="width:50px;text-align:center;ime-mode:disabled;"><!-- 
                	 --><button type="button" class="input_seach_btn" name="btn_pod_cd" id="btn_pod_cd"></button></nobr>
                </th>
                <th>DEL
                	<nobr><input type="text" id="del_cd"  name="del_cd" maxlength="5" dataformat="engup" style="width:50px;text-align:center;ime-mode:disabled;"><!-- 
                	 --><button type="button" class="input_seach_btn" name="btn_del_cd" id="btn_del_cd"></button></nobr>
               	</th>
			</tr>
			<tr style="height:30px;">
				<th>Display</th>
				<td class="sm" colspan="5">
				   <nobr>
				   <input type="checkbox" class="trans" checked id="chkDisplay" name="chk_slan_cd"           value="slan_cd">&nbsp;Lane&nbsp;&nbsp;
				   <input type="checkbox" class="trans" checked id="chkDisplay" name="chk_vvd"               value="vvd">&nbsp;VVD&nbsp;&nbsp;
				   <input type="checkbox" class="trans" checked id="chkDisplay" name="chk_gen_spcl_rt_tp_cd" value="gen_spcl_rt_tp_cd">&nbsp;Rate Type&nbsp;&nbsp;
				   <input type="checkbox" class="trans" checked id="chkDisplay" name="chk_cmdt_nm"           value="cmdt_nm">&nbsp;Commodity Group&nbsp;&nbsp;
				   <input type="checkbox" class="trans" checked id="chkDisplay" name="chk_act_cust_nm"       value="act_cust_nm">&nbsp;Actual Customer&nbsp;&nbsp;
				   <input type="checkbox" class="trans" checked id="chkDisplay" name="chk_usa_svc_mod_cd"    value="usa_svc_mod_cd">&nbsp;US Mode&nbsp;&nbsp;
				   <input type="checkbox" class="trans" checked id="chkDisplay" name="chk_por_cd"            value="por_cd">&nbsp;POR&nbsp;&nbsp;
				   <input type="checkbox" class="trans" checked id="chkDisplay" name="chk_pol_cd"            value="pol_cd">&nbsp;POL&nbsp;&nbsp;
				   <input type="checkbox" class="trans" checked id="chkDisplay" name="chk_pod_cd"            value="pod_cd">&nbsp;POD&nbsp;&nbsp;
				   <input type="checkbox" class="trans" checked id="chkDisplay" name="chk_del_cd"            value="del_cd">&nbsp;DEL
				   </nobr>
			    </td>
			    <td></td>
			    <td></td>
			</tr>
			<tr>
				<th>S/C TOTAL</th>
				<td class="stm" align="right">MQC
				   <input type="text" id="fnl_mqc_qty" name="fnl_mqc_qty" style="width:80px;text-align:right;" class="input2" readonly><!-- 
				    --><input type="text" style="width:40px;text-align:center;" class="input2" value="FEU" readonly>
				</td>
				<td class="stm">Performance (FEU) </td>
				<td>
				   <input type="text" id="op_cntr_qty" name="op_cntr_qty" style="width:80px;text-align:right;" class="input2" readonly><!-- 
				    --><input type="text" style="width:40px;text-align:center;" class="input2" value="FEU" readonly>
				</td>
				<td class="stm">MQC Attain.(%, Straight)</td>
				<td><input type="text" id="mqc_perf" name="mqc_perf" style="width:80px;text-align:right;" class="input2" readonly></td>
				<td class="stm">MQC Attain.(%, Pro-rated)</td>
				<td><input type="text" id="pro_rt_mqc_perf" name="pro_rt_mqc_perf" style="width:80px;text-align:right;" class="input2" readonly></td>
			</tr>
	</table>
	<!-- 조회영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
</div>
<div class="opus_design_grid">
	<!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
    <script language="javascript">ComSheetObject('sheet1');</script>
    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
</div>
</div>
<!-- opus_design_inquiry(E) -->

<!-- opus_design_grid(S) -->

<!-- opus_design_grid(E) -->

<div style="display: none">
<script language="javascript">ComSheetObject('sheet2');</script>
<script language="javascript">ComSheetObject('sheet3');</script>
<script language="javascript">ComSheetObject('sheet4');</script>
<script language="javascript">ComSheetObject('sheet5');</script>
</div>
<!-- page(E) -->

</form>