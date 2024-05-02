<%  
/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_PRI_2141_05.jsp
 *@FileTitle : RFA Search - Amendment History - Rate
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.09.21
 *@LastModifier : 박성수
 *@LastVersion : 1.0
 * 2009.09.21 박성수
 * 1.0 Creation
 =========================================================
 * History
 * 2014.09.15 최성환  [CHM-201431899] Guideline RFA 생성 요청
 =========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.event.EsmPri204105Event"%>
<%@ page import="org.apache.log4j.Logger"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.common.PRIUtil"%>
<%@ page import="com.hanjin.framework.component.util.code.CodeInfo"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>

<%
    EsmPri204105Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지
	int rowCount = 0; //DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	Logger log = Logger.getLogger("com.hanjin.apps.RFAProposal.RFARateProposal");
	
	String[] ratUtCdList = null;
	String[] prcCgoTpCdList = null;
	String[] currCdList = null;
	
	ArrayList<CodeInfo> termOrgCdList = null;
	ArrayList<CodeInfo> termDestCdList = null;
	ArrayList<CodeInfo> transModeCdList = null;

	try {
		SignOnUserAccount account = (SignOnUserAccount) session
				.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmPri204105Event) request.getAttribute("Event");
		serverException = (Exception) request
				.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		ratUtCdList = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("ratUtCdList"), false, "|", "\t");
		prcCgoTpCdList = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("prcCgoTpCdList"), true, "|", "\t", "getCode", "getName");
		currCdList = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("currCdList"), false, "|", "\t");
		
		termOrgCdList = (ArrayList<CodeInfo>)eventResponse.getCustomData("termOrgCdList");
		termDestCdList = (ArrayList<CodeInfo>)eventResponse.getCustomData("termDestCdList");
		transModeCdList = (ArrayList<CodeInfo>)eventResponse.getCustomData("transModeCdList");

	} catch (Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>RFA Search - Amendment History - Rate</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
    var ratUtCdValue = "<%=ratUtCdList[0]%>";
    var ratUtCdText = "<%=ratUtCdList[1]%>";
    var prcCgoTpCddValue = "<%=prcCgoTpCdList[0]%>";
    var prcCgoTpCdText = "<%=prcCgoTpCdList[1]%>";
    var currCdValue = "<%=currCdList[0]%>";
    var currCdText = "<%=currCdList[1]%>";
    
    var arrTermOrg = new Array();
    var arrTermDest = new Array();
    var arrTransMode = new Array();
    
    <%
    for (int i = 0; termOrgCdList != null && i < termOrgCdList.size(); i++) {
    	CodeInfo row = termOrgCdList.get(i);
    	out.println("arrTermOrg[\"" + row.getCode()  + "\"] = \"" + row.getName() + "\";");
    }
    for (int i = 0; termDestCdList != null && i < termDestCdList.size(); i++) {
    	CodeInfo row = termDestCdList.get(i);
    	out.println("arrTermDest[\"" + row.getCode()  + "\"] = \"" + row.getName() + "\";");
    }
    for (int i = 0; transModeCdList != null && i < transModeCdList.size(); i++) {
    	CodeInfo row = transModeCdList.get(i);
    	out.println("arrTransMode[\"" + row.getCode()  + "\"] = \"" + row.getName() + "\";");
    }
    %>
    
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		
		loadPage();
	}

</script>
</head>

<body onLoad="setupPage();">
<form name="form"><input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->
<input type="hidden" name="prop_no">
<input type="hidden" name="amdt_seq">
<input type="hidden" name="svc_scp_cd">
<input type="hidden" name="conv_chk">
<input type="hidden" name="cmdt_hdr_seq">
<input type="hidden" name="rout_seq">

        <table class="search" id="mainTable">
            <tr><td class="bg">

                <!--Button (S) -->
                <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:2;">
                <tr>

                    <td class="btn1_bg">

                    <table border="0" cellpadding="0" cellspacing="0">
                    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                            <tr><td class="btn1_left"></td>
                            <td class="btn1" name="btn_retrieve">Retrieve</td>
                            <td class="btn1_right"></td>
                            </tr>
                        </table></td>
<!--                         <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                            <tr><td class="btn1_left"></td>
                            <td class="btn1" name="btn_gricalc">GRI</td>
                            <td class="btn1_right"></td>
                            </tr>
                        </table></td> -->
                        </tr>
                    </table>
                </td></tr>
                </table>
                <!--Button (E) -->

                <!-- 1 (S) -->
                <!-- Title (S) -->
                <table class="search" border="0">
                <tr><td class="title_h"></td>
                    <td class="title_s">Commodity Group</td></tr>
                <tr><td class="height_5"></td></tr>
                </table>
                <!-- Title (E) -->

                <!-- Grid  (S) -->
                <table width="100%"  id="mainTable">
                    <tr>
                        <td width="100%">
                            <script language="javascript">ComSheetObject('sheet1');</script>
                        </td>
                    </tr>
                </table>
                <!-- Grid (E) -->

                <!-- 1 (E) -->

                <!-- 3 (S) -->
                <!-- Title (S) -->
                <table class="line_bluedot"><tr><td colspan="6"></td></tr></table>

            <table class="search" border="0">
            <tr><td class="title_h"></td>
                <td class="title_s">Route Detail</td></tr>
            </table>

            <!-- Grid  (S) -->
                <table width="100%"  id="mainTable">
                    <tr>
                        <td width="100%">
                            <script language="javascript">ComSheetObject('sheet2');</script>
                        </td>
                    </tr>
                </table>
            <!-- Grid (E) -->


	        <table class="height_5"><tr><td></td></tr></table>      
	        <table border="0" style="width:100%; background-color:white;" class="grid2"> 
	            <tr class="tr2_head">
	                <td width="25%">Origin</td>
	                <td width="25%">Origin Via</td> 
	                <td width="25%">Destination Via</td>    
	                <td width="25%">Destination</td>          
	            </tr>
	            <tr>
	                <td class="input2"><div style="width:100%; height:45; word-wrap:break-word; overflow-x:hidden; overflow-y:scroll;"><table width="100%" height="100%"><tr><td style="border:0px; padding:2px; text-indent:0px;" valign="top" id="origin_desc"></td></tr></table></div></td>
	                <td class="input2"><div style="width:100%; height:45; word-wrap:break-word; overflow-x:hidden; overflow-y:scroll;"><table width="100%" height="100%"><tr><td style="border:0px; padding:2px; text-indent:0px;" valign="top" id="ovia_desc"></td></tr></table></div></td>
	                <td class="input2"><div style="width:100%; height:45; word-wrap:break-word; overflow-x:hidden; overflow-y:scroll;"><table width="100%" height="100%"><tr><td style="border:0px; padding:2px; text-indent:0px;" valign="top" id="dvia_desc"></td></tr></table></div></td>
	                <td class="input2"><div style="width:100%; height:45; word-wrap:break-word; overflow-x:hidden; overflow-y:scroll;"><table width="100%" height="100%"><tr><td style="border:0px; padding:2px; text-indent:0px;" valign="top" id="dest_desc"></td></tr></table></div></td>
	            </tr>
	        </table>

            <table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
            
            <table class="search" border="0">
            <tr class="h23"><td class="title_h"></td>
                <td class="title_s">Rate</td>
                </tr>
            </table>

            <!-- Grid  (S) -->
                <table width="100%"  id="mainTable">
                    <tr>
                        <td width="100%">
                            <script language="javascript">ComSheetObject('sheet3');</script>
                        </td>
                    </tr>
                </table>
            <!-- Grid (E) -->

                <!--  Button_Sub (S) -->
                <table width="100%" class="button">
                <tr><td class="btn2_bg">
<!--                     <table border="0" cellpadding="0" cellspacing="0">
                    <tr>
                        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                        <tr><td class="btn2_left"></td>
                        <td class="btn2" name="btn_specification">Specification</td>
                        <td class="btn2_right"></td>
                        </tr>
                        </table></td>

                        </tr></table> -->
                </td></tr>
                </table>
                <!-- Button_Sub (E) -->
                
                <!-- 4 (E) -->

        </td></tr></table>
        <!--biz page (E)-->

<div id="hiddenSheetLayer" style="display: none">
<script language="javascript">ComSheetObject('sheet4');</script>
<script language="javascript">ComSheetObject('sheet5');</script>
<script language="javascript">ComSheetObject('sheet6');</script>
<script language="javascript">ComSheetObject('sheet7');</script>
<script language="javascript">ComSheetObject('sheet8');</script>
<script language="javascript">ComSheetObject('sheet9');</script>
<script language="javascript">ComSheetObject('sheet10');</script>
<script language="javascript">ComSheetObject('sheet11');</script>
<script language="javascript">ComSheetObject('sheet12');</script>
<script language="javascript">ComSheetObject('sheet13');</script>
<script language="javascript">ComSheetObject('sheet14');</script>
<script language="javascript">ComSheetObject('sheet15');</script>
<script language="javascript">ComSheetObject('sheet16');</script>
</div>

<script language="javascript">
function showStatus() {
    var sStr = "";
    sStr += "******************** Form Value ********************\n";
    sStr += "Proposal NO.\t: " + document.form.prop_no.value + "\n";
    sStr += "Amend Seq.\t: " + document.form.amdt_seq.value + "\n";
    sStr += "SVC Scope\t: " + document.form.svc_scp_cd.value + "\n";
    sStr += "Prev. Amend Seq.\t: " + document.form.pre_amdt_seq.value + "\n";
    sStr += "Proposal Status\t: " + document.form.prc_prop_sts_cd.value + "\n";
    sStr += "EFF Date\t\t: " + document.form.eff_dt.value + "\n";
    sStr += "EXP Date\t\t: " + document.form.exp_dt.value + "\n";
    sStr += "Prev. EXP Date\t: " + document.form.pre_exp_dt.value + "\n";
    sStr += "Is Sales Rep.\t: " + document.form.is_req_usr.value + "\n";
    sStr += "Has Appr. Auth.\t: " + document.form.is_apro_usr.value + "\n";
    sStr += "Comodity Seq.\t: " + document.form.cmdt_hdr_seq.value + "\n";
    sStr += "Route Seq.\t: " + document.form.rout_seq.value + "\n";
    
    alert(sStr);
}
</script>
<a href="javascript:showStatus();" onFocus="this.blur();"><font color="white" size="1">상태값확인</font></a>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>