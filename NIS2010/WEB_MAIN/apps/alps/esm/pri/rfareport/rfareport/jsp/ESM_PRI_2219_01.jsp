<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_2219_01.jsp
*@FileTitle : Master RFA Inquiry (& Copied RFA List) - Master RFA Only
*Open Issues :
*Change history :
*@LastModifyDate : 2016-04-01
*@LastModifier : Jong-Ock KIM
*@LastVersion : 1.0
* 2016-04-01 Jong-Ock KIM
* 1.0 Creation
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.rfareport.rfareport.event.EsmPri221901Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.util.code.CodeInfo"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.common.PRIUtil"%>
<%@ page import="com.hanjin.framework.component.common.AbstractValueObject"%>
<%@ page import="java.util.List"%>

<%
    EsmPri221901Event  event = null;              //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //서버에서 발생한 에러
    String strErrMsg = "";                      //에러메세지
    int rowCount     = 0;                       //DB ResultSet 리스트의 건수
    
    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    String strRhq_ofc_cd    = "";
    String strOfc_cd        = "";

    String[] svcScpCds = null;
    String[] rhqs = null;

	String[] termOrgCdList = null;
	String[] termDestCdList = null;
	
	String[] propStsCd = null;		//STATUS
	
    
    Logger log = Logger.getLogger("com.hanjin.apps.SCReport.SCReport");
    
    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
        strRhq_ofc_cd = account.getRhq_ofc_cd();
        strOfc_cd = account.getOfc_cd();
       
        event = (EsmPri221901Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
        
        // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

        // Scope Combo Data 생성
        svcScpCds = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("scopeList"));
        // R.Term Combo Date 생성
        termOrgCdList = PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("termOrgCdList"), false);
        // D.Term Combo Data 생성
        termDestCdList = PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("termDestCdList"), false);
        // rhq Combo Data 생성
		rhqs = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("rhq"));
		//Proposal Status Combo Data 생성
        propStsCd 	= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("propStsCd"), false);

    }catch(Exception e) {
        out.println(e.toString());
    }
%>
<html>
<head>
<title>Master RFA Inquiry (& Copied RFA List)</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">

var rhqComboValue = "|<%=rhqs[0]%>";
var rhqComboText = "|<%=rhqs[1]%>";

var svcScpCdComboValue = "|<%=svcScpCds[0]%>";
var svcScpCdComboText = "|<%=svcScpCds[1]%>";



var termOrgCdValue = "|<%=termOrgCdList[0]%>";
var termOrgCdText = "|<%=termOrgCdList[1]%>";

var termDestCdValue = "|<%=termDestCdList[0]%>";
var termDestCdText = "|<%=termDestCdList[1]%>";

var propStsCdComboValue = "|<%=propStsCd[0]%>";
var propStsCdComboText = "|<%=propStsCd[1]%>";

var sRepOfcCd = "<%=strOfc_cd%>";

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
<input type="hidden" name ="login_rhq_ofc_cd" value="<%=strRhq_ofc_cd%>">
 	    <!--Button (S) -->
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
			<table class="search" border="0" style="width:979;"> 
			<tr class="h23">
				<td width="70"><nobr>M.RFA No.</nobr></td>
				<td width="130"><input type="text" class="input" style="width:110;text-align:center;ime-mode:disabled" name="f_m_rfa_no" dataformat="uppernum" maxLength="10" value=""></td>
				<td width="50">Scope</td>
				<td width="90">
				<script language="javascript">ComComboObject('f_scp', 2, 70, 0, 0, 0, false);
				</script></td>
				<td width="95">Request RHQ</td>
				<td width="80"><script language="javascript">ComComboObject('f_req_rhq', 1, 65, 0, 0, 0, false);</script></td>
				<td width="100">Request Office</td>
				<td width="95"><input type="text" style="width:50;text-align:center;ime-mode:disabled" class="input" name="f_req_ofc" dataformat="engup" maxLength="6" value="<%=strOfc_cd%>"> <img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" id="btn_popup1" name="ComOpenPopupWithTarget"></td>
				<td width="65"><nobr>EFF Date</nobr></td>
				<td width="258"><input type="text" class="input1" style="width:80;text-align:center;" caption="From Date" name="f_eff_dt" cofield="f_exp_dt" dataformat="ymd" maxLength="10" minlength="8"> &nbsp;~&nbsp; <input type="text" class="input1" style="width:80;text-align:center;" caption="To Date" name="f_exp_dt" cofield="f_eff_dt" dataformat="ymd" maxLength="10" minlength="8"> <img src="img/btns_calendar.gif" class="cursor" name="btns_calendar" width="19" height="20" border="0" align="absmiddle"></td>
			</tr>
			</table>
			<table class="search" border="0" style="width:979;">
			<tr class="h23">
				<td width="69">Origin</td> <!-- 2011.03.15 이행지 [CHM-201109281-01] ALPS의 Location 조회불가건 수정 보완 요청 - Location Code 영문대문자,숫자 입력가능하도록 수정  dataformat ( engup -> uppernum )-->
				<td width="75"><input type="text" name="f_org" style="width:50;text-align:center;ime-mode:disabled" class="input" dataformat="uppernum" maxLength="5"></td>
				<td width="40">O. Via</td>
				<td width="70"><input type="text" name="f_o_via" style="width:47;text-align:center;ime-mode:disabled" class="input" dataformat="uppernum" maxLength="5"></td>
				<td width="40">D. Via</td>
				<td width="83"><input type="text" name="f_d_via" style="width:50;text-align:center;ime-mode:disabled" class="input" dataformat="uppernum" maxLength="5"></td>
				<td width="70">Destinaion</td>
				<td width="80"><input type="text" name="f_dest" style="width:50;text-align:center;ime-mode:disabled" class="input" dataformat="uppernum" maxLength="5"></td>
                <td width="75">Commodity</td>
                <td width=""><input type="text" style="width:140;text-align:center;ime-mode:disabled" class="input2" name="f_cmdt" dataformat="number" maxLength="6" readonly value="FAK OR CARGO, NOS"> <img class="cursor" src="img/btns_search.gif" name="btn_commodity" width="19" height="20" border="0" align="absmiddle"></td>
			</tr>
			</table>
			<table class="search_sm" border="0" style="width:979;"> 
			<tr class="h23">
				<td width="50">Display</td>
				<td width="420" class="sm">
				   <nobr>
				   <input type="checkbox" class="trans" checked id="chkDisplay" name="f_curr_rt_dsp">&nbsp;Current Rate&nbsp;&nbsp;
				   <input type="checkbox" class="trans" checked id="chkDisplay" name="f_chg_dsp">&nbsp;Charge Term.&nbsp;&nbsp;
				   <input type="checkbox" class="trans" checked id="chkDisplay" name="f_cmdt_dsp">&nbsp;Commodity&nbsp;&nbsp;
				   <input type="checkbox" class="trans"  id="chkDisplay" name="f_t_s_dsp">&nbsp;Direct Call&nbsp;&nbsp;
				   <input type="checkbox" class="trans"  id="chkDisplay" name="f_t_s_port_dsp">&nbsp;T/S Port&nbsp;&nbsp;
				   </nobr>
			    </td>
				<td width="60">Status</td>
				<td width="80"><script language="javascript">ComComboObject('f_sts', 1, 93, 0, 0);</script></td>
				<td width="">&nbsp;</td>
			</tr>
			</table>
			<!--  biz_1   (E) -->
			<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
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
<!-- 	<script language="javascript">ComSheetObject('sheet2');</script> -->
	</div>
</form>
</body>
</html>