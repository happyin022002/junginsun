<%
/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ESM_PRI_2017.jsp
*@FileTitle : Basic RFA Auto Amendment Request
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.20
*@LastModifier : 
*@LastVersion : 1.0
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
<%@ page import="com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.event.EsmPri2017Event"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>
<%@ page import="com.hanjin.framework.component.util.code.CodeInfo"%>
<%@ page import="com.hanjin.framework.component.util.StringUtil" %>
<%@ page import="com.hanjin.apps.alps.esm.pri.common.PRIUtil"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.List"%>

<%

	EsmPri2017Event  event = null;              //PDTO(Data Transfer Object including Parameters)
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

	Logger log = Logger.getLogger("com.hanjin.apps.RFAProposal.RFAProposalMain");
	
	String rfaNo = null;
	String propNo = null;
	String amdtSeq = null;
    String mstRfaNo = null;
    String effDt = null;
    String expDt = null;
    
	String[] termOrgCdList = null;
	String[] termDestCdList = null;

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
        strRhq_ofc_cd = account.getRhq_ofc_cd();
        strOfc_cd = account.getOfc_cd();

        event = (EsmPri2017Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        
        rfaNo = JSPUtil.getNull(request.getParameter("rfa_no")).trim().equals("")?"":JSPUtil.getNull(request.getParameter("rfa_no"));
	    propNo = JSPUtil.getNull(request.getParameter("prop_no")).trim().equals("")?"":JSPUtil.getNull(request.getParameter("prop_no"));
	    amdtSeq = JSPUtil.getNull(request.getParameter("amdt_seq")).trim().equals("")?"":JSPUtil.getNull(request.getParameter("amdt_seq"));
	    mstRfaNo = JSPUtil.getNull(request.getParameter("mst_rfa_no")).trim().equals("")?"":JSPUtil.getNull(request.getParameter("mst_rfa_no"));
	    effDt =  JSPUtil.getNull(request.getParameter("eff_dt")).trim().equals("")?"":JSPUtil.getNull(request.getParameter("eff_dt"));
 		expDt =  JSPUtil.getNull(request.getParameter("exp_dt")).trim().equals("")?"":JSPUtil.getNull(request.getParameter("exp_dt"));
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		termOrgCdList = PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("termOrgCdList"), false);
		termDestCdList = PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("termDestCdList"), false);
        
    }catch(Exception e) {
        out.println(e.toString());
    }
%>

<html>
<head>
<title>Basic RFA Auto Amend</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script type="text/javascript">

var termOrgCdValue = "<%=termOrgCdList[0]%>";
var termOrgCdText = "<%=termOrgCdList[1]%>";

var termDestCdValue = "<%=termDestCdList[0]%>";
var termDestCdText = "<%=termDestCdList[1]%>"; 

    function setupPage() {
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
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<input type="hidden" name="rfa_no" value="<%=rfaNo %>">
<input type="hidden" name="prop_no" value="<%=propNo %>">
<input type="hidden" name="amdt_seq" value="<%=amdtSeq %>">
<input type="hidden" name="svc_scp_cd">

<!-- 개발자 작업	-->
<input type="hidden" name="eff_dt">
<input type="hidden" name="exp_dt">

<input type="hidden" name="pos_eff_dt">
<input type="hidden" name="pos_exp_dt" value="<%=expDt %>">

<!-- OUTER - POPUP (S)tart -->
	<table width="1100" class="popup" cellpadding="10" border="0">
	<tr><td class="top"></td></tr>
	<tr><td valign="top">

		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp; Basic RFA Auto Amend</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- 1 (S) -->
		<table class="search" id="mainTable"> 
       	<tr><td class="bg">
       		
       		
			<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="115">Master RFA No.</td>
					<td width="100"><input type="text" name="mst_rfa_no" style="width:90;text-align:center;" value="<%=mstRfaNo %>" class="input2" readonly="readonly"></td>
					
					<td width="60">AMD No.</td>
					<td width="60"><input type="text" name="mst_amdt_seq" style="width:45;text-align:center;" value="" class="input2" readonly="readonly"></td>
					
					<td width="140">&nbsp;&nbsp;Master RFA Duration </td>
					<td width="200">
						&nbsp;<input type="text" style="width:80;text-align:center;" class="input2" caption="Effective date" name="mst_eff_dt" maxlength="10" dataformat="ymd"  readonly="readonly">&nbsp;~&nbsp;
						<input type="text" style="width:80;text-align:center;" class="input2" caption="Expiration date" name="mst_exp_dt" maxlength="10" dataformat="ymd" readonly="readonly">
					</td>
										
					<td width="120">Amend Duration </td>
					<td width="220">
						&nbsp;<input type="text" style="width:80;text-align:center;" class="input2" caption="Effective date" name="ctrt_eff_dt" cofield="ctrt_exp_dt" maxlength="10" dataformat="ymd"  readonly="readonly">&nbsp;~&nbsp;
						<input type="text" style="width:80;text-align:center;" class="input2" caption="Expiration date" name="ctrt_exp_dt" cofield="ctrt_eff_dt" maxlength="10" dataformat="ymd" readonly="readonly">
					</td>
				</tr>
			</table>
			
            <!-- Grid - 1 (S) -->
            <table width="100%" style="display:inline;">
                <tr>
                    <td width="100%">
                        <script type="text/javascript">ComSheetObject('sheet1');</script>
                        <script type="text/javascript">ComSheetObject('sheet2');</script>
                    </td>
                </tr>
            </table>
			<!-- Grid - 1 (E) -->
            
		    </td></tr>
		</table>
		
	</td></tr>
	</table>
	<!-- 1 (E) -->
	
<table class="height_5"><tr><td></td></tr></table>

<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_OK">OK</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				
				<td class="btn1_line"></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Close">Close</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td></tr>
		</table></td></tr>
		</table>
    <!--Button (E) -->
	
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>