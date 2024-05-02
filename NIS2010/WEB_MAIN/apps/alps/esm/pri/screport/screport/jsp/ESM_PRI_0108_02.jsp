<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_0108_02.jsp
*@FileTitle : S/C Performance Summary
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.31
*@LastModifier : 김대호
*@LastVersion : 1.0
* 2009.08.31 김대호
* 1.0 Creation
=========================================================
* History
* 2011.03.15 이행지 [CHM-201109281-01] ALPS의 Location 조회불가건 수정 보완 요청 - Location Code 중 숫자를 포함한 Code 를 조회, 입력 등 모든 부분에서 가능하도록 수정
* 2011.11.18 서미진 [CHM-201114462] SC No. 를 한칸으로 변경하여 copy & paste 기능 이용 할 수 있도록 정정요청
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.screport.screport.event.EsmPri010802Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.util.code.CodeInfo"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.common.PRIUtil"%>
<%@ page import="com.hanjin.framework.component.common.AbstractValueObject"%>
<%@ page import="java.util.List"%>

<%
    EsmPri010802Event  event = null;              //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //서버에서 발생한 에러
    String strErrMsg = "";                      //에러메세지
    int rowCount     = 0;                       //DB ResultSet 리스트의 건수
    
    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
      
    String[] svcScpCds = null;        
    String[] skdDirCds = null;        
    String[] rtTpCds = null;        
    String[] usModCds = null;        
    
    Logger log = Logger.getLogger("com.hanjin.apps.SCReport.SCReport");
    
    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
       
        event = (EsmPri010802Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
        
        // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        
        // Scope Combo Data 생성
        svcScpCds = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("svcScpCd"));
        // Direction Combo Data 생성
        skdDirCds = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("skdDirCd"), true , "|", "\t", "getCode", "getName");
        // Rate Type Combo Data 생성
        rtTpCds = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("rtTpCd"), true , "|", "\t", "getCode", "getName");
        // US Mode
        usModCds = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("usModCd"), true , "|", "\t", "getCode", "getName");
        
    }catch(Exception e) {
        out.println(e.toString());
    }
%>
<html>
<head>
<title>S/C Performance Summary</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">

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
</head>

<body  onLoad="setupPage();"> 

<form name="form"> 
<!--  Office Code Validation 체크를 위한 정의 -->
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="cd">
<input type="hidden" name="backendjob_key">
<!--  Office Code Validation 체크를 위한 정의 -->
<input type="hidden" name ="ofc_cd" value="">
<!-- Form Hidden -->
<input type="hidden" id="searchParam" name="sc_no">

    <!--Button (S) 엔터이벤트 발생용 -->
        <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0; padding-bottom:2; display:none"> 
        <tr><td class="btn1_bg">
            <table border="0" cellpadding="0" cellspacing="0">
            <tr>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
            </tr>
            </table>
        </td></tr>
        </table>
    <!--Button (E) -->


		<table class="search"> 
       	<tr><td class="bg">
			<!--  biz_1  (S) -->
			<table class="search" border="0" style="width:979;"> 
			<tr class="h23">
				<td width="60"><nobr>S/C No</nobr></td>
				<td width="200">
					<input type="text" class="input1" style="width:110;text-align:center;ime-mode:disabled" name="sc_no_input" dataformat="uppernum" maxLength="9">
				</td>
				<td width="60">Customer</td>
				<td width="">
				   <nobr>
				   <input type="text" style="width:30; text-align:center" class="input2" id="scInfomation" name="cust_cnt_cd" readonly>&nbsp;
				   <input type="text" style="width:50; text-align:center"  class="input2" id="scInfomation" name="cust_seq" readonly>&nbsp;
				   <input type="text" style="width:220" class="input2" id="scInfomation" name="ctrt_pty_nm" readonly>&nbsp;
				   <input type="text" style="width:20"  class="input2" id="scInfomation" name="prc_ctrt_cust_tp_cd" readonly>&nbsp;
				   <input type="text" style="width:45; text-align:center"  class="input2" id="scInfomation" name="ctrt_cust_sls_ofc_cd" readonly>&nbsp;
				   <input type="text" style="width:45; text-align:center"  class="input2" id="scInfomation" name="ctrt_cust_srep_cd" readonly>&nbsp;
				   <input type="text" style="width:80"  class="input2" id="scInfomation" name="srep_nm" readonly>&nbsp;
				   <input type="text" style="width:75; text-align:center"  class="input2" id="scInfomation" name="ctrt_eff_dt" readonly>&nbsp;~&nbsp;
				   <input type="text" style="width:75; text-align:center"  class="input2" id="scInfomation" name="ctrt_exp_dt" readonly>
				   </nobr>
				</td>
			</tr>
			</table>
			<table class="search" border="0" style="width:979;"> 
			<tr class="h23">
				<td width="150"><nobr>Period (B/L Onboard DT)</nobr></td>
				<td width="200">
				    <nobr>
					<input type="text" style="width:70;text-align:center;" class="input" name="bl_obrd_dt_from" caption="Period (B/L Onboard DT)" dataformat="ymd" maxLength="10" minlength="8"><img class="cursor" src="img/btns_calendar.gif" name="btns_calendar1" width="19" height="20" border="0" align="absmiddle">~
					<input type="text" style="width:70;text-align:center;" class="input" name="bl_obrd_dt_to" caption="Period (B/L Onboard DT)" dataformat="ymd" maxLength="10" minlength="8"><img class="cursor" src="img/btns_calendar.gif" name="btns_calendar2" width="19" height="20" border="0" align="absmiddle">
					</nobr>
				</td>
				<td width="40"><nobr>Trade</nobr></td>
				<td width="75"><script language="javascript">ComComboObject('trd_cd', 2, 65, 0, 0, 0, false);</script></td>
				<td width="60"><nobr>Direction</nobr></td>
				<td width="50"><script language="javascript">ComComboObject('skd_dir_cd', 1, 35, 0, 0, 0, false);</script></td>
				<td width="70"><nobr>Sub Trade</nobr></td>
				<td width="70"><script language="javascript">ComComboObject('sub_trd_cd', 2, 60, 0, 0, 0, false);</script></td>
				<td width="35"><nobr>Lane</nobr></td>
				<td width="60"><script language="javascript">ComComboObject('vsl_slan_cd', 2, 55, 0, 0, 0, false);</script></td>
				<td width="30"><nobr>VVD</nobr></td>
				<td width="">
                    <td width="135"><nobr>
                        <input type="text" name="vsl_cd" class="input" style="width:40;text-align:center;ime-mode:disabled" dataformat="engup" caption="VVD" maxLength="4">
                        <input type="text" name="skd_voy_no" class="input" style="width:40;text-align:center;ime-mode:disabled" dataformat="uppernum" caption="VVD" maxLength="4">
                        <input type="text" name="skd_dir_cd_txt" class="input" style="width:20;text-align:center;ime-mode:disabled" dataformat="engup" caption="VVD" maxLength="1">
                        <!-- input type="text" name="vvd" style="width:77;" class="input" style="text-align:center;ime-mode:disabled" dataformat=uppernum caption="VVD" maxlength="9" fullfill--><img class="cursor"  src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" name="btn_com_ens_ob2">
                        </nobr>
                    </td>
			    </td>
			</tr>
			</table>
			<table class="search" border="0" style="width:979;"> 
			<tr class="h23">
                <td width="70"><nobr>SVC Scope</nobr></td>
                <td width="50"><script language="javascript">ComComboObject('svc_scp_cd', 2, 50, 0, 0, 0, false);</script></td>
				<td width="65"><nobr>Rate Type</nobr></td>
				<td width="40"><script language="javascript">ComComboObject('gen_spcl_rt_tp_cd', 2, 40, 0, 0, 0, false);</script></td>
				<td width="140" title="Commodity Group(Bullet)"><nobr>C.Group(Bul.)</nobr></td>
				<td width="75"><script language="javascript">ComComboObject('cmdt_hdr_seq', 1, 60, 0, 0, 0, false);</script></td>
				<td width="105" title="Actual Customer"><nobr>A.Customer</nobr></td>
				<td width="60"><script language="javascript">ComComboObject('act_cust_cd', 1, 50, 0, 0, 0, false);</script></td>
				<td width="60"><nobr>US Mode</nobr></td>
				<td width="60"><script language="javascript">ComComboObject('usa_svc_mod_cd', 2, 60, 0, 0, 0, false);</script></td>
                <td width="30">POR</td>
                <td width="60"><nobr><input type="text" name="por_cd" maxlength="5" dataformat="uppernum" style="width:50;text-align:center;ime-mode:disabled;"><img class="cursor"  src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_por_cd"></nobr></td>
                <td width="20">POL</td>
                <td width="60"><nobr><input type="text" name="pol_cd" maxlength="5" dataformat="uppernum" style="width:50;text-align:center;ime-mode:disabled;"><img class="cursor"  src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_pol_cd"></nobr></td>
                <td width="30">POD</td>
                <td width="60"><nobr><input type="text" name="pod_cd" maxlength="5" dataformat="uppernum" style="width:50;text-align:center;ime-mode:disabled;"><img class="cursor"  src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_pod_cd"></nobr></td>
                <td width="20">DEL</td>
                <td width=""><nobr><input type="text" name="del_cd" maxlength="5" dataformat="uppernum" style="width:50;text-align:center;ime-mode:disabled;"><img class="cursor"  src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_del_cd"></nobr></td>
			</tr>
			</table>
			<table class="search_sm" border="0" style="width:979;"> 
			<tr class="h23">
				<td width="50">Display</td>
				<td class="sm">
				    <nobr>
				   <!-- input type="checkbox" class="trans" checked id="chkDisplay" name="chk_trd_cd"            value="trd_cd">&nbsp;Trade&nbsp;&nbsp;
				   <input type="checkbox" class="trans" checked id="chkDisplay" name="chk_sub_trd_cd"        value="sub_trd_cd">&nbsp;Sub Trade&nbsp;&nbsp;
				   <input type="checkbox" class="trans" checked id="chkDisplay" name="chk_skd_dir_cd"        value="skd_dir_cd">&nbsp;Direction&nbsp;&nbsp;-->
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
			</tr>
			</table>
			<!--  biz_1   (E) -->
			
			<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
			
			<table class="search" border="0" style="width:979;"> 
			<tr class="h23">
				<td width="80">S/C TOTAL</td>
				<td width="30" class="stm">MQC</td>
				<td width="145">
				   <input type="text" name="fnl_mqc_qty" style="width:80;text-align:right;" class="input2" readonly>&nbsp;
				   <input type="text" style="width:40;text-align:center;" class="input2" value="FEU" readonly>
				</td>
				<td width="105" class="stm">Performance (FEU) </td>
				<td width="145">
				   <input type="text" name="op_cntr_qty" style="width:80;text-align:right;" class="input2" readonly>&nbsp;
				   <input type="text" style="width:40;text-align:center;" class="input2" value="FEU" readonly>
				</td>
				<td width="145" class="stm">MQC Attain.(%, Straight)</td>
				<td width="100"><input type="text" name="mqc_perf" style="width:80;text-align:right;" class="input2" readonly></td>
				<td width="150" class="stm">MQC Attain.(%, Pro-rated)</td>
				<td width=""><input type="text" name="pro_rt_mqc_perf" style="width:80;text-align:right;" class="input2" readonly></td>
				</tr>
				
			</table>
				
		<!-- Grid  (S) -->
			<table width="100%"  id="mainTable"> 
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet1');</script>
					</td>
				</tr>
			</table>
		<!-- Grid (E) -->	
						
				
			</td></tr>
			
		</table>

<div style="display: none">
<script language="javascript">ComSheetObject('sheet2');</script>
<script language="javascript">ComSheetObject('sheet3');</script>
<script language="javascript">ComSheetObject('sheet4');</script>
<script language="javascript">ComSheetObject('sheet5');</script>
</div>
<div !style="display: none">
</div>

</form>
</body>
</html>