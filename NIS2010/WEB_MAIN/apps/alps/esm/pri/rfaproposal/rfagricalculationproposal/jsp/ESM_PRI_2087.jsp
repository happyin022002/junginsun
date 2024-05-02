<%  
/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_PRI_2087.jsp
 *@FileTitle : GRI Calculation Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.09.23
 *@LastModifier : 박성수
 *@LastVersion : 1.0
 * 2009.09.23 박성수
 * 1.0 Creation
 =========================================================
 * History
 * [CHM-201534517] 1월 소스 보안 결함 건 조치 요청
 =========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.rfaproposal.rfagricalculationproposal.event.EsmPri2087Event"%>
<%@ page import="org.apache.log4j.Logger"%>
<%@ page import="com.hanjin.framework.component.util.StringUtil" %>

<%
    EsmPri2087Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지
	int rowCount = 0; //DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	Logger log = Logger.getLogger("com.hanjin.apps.RFAProposal.RFAGRICalcualtionProposal");
	
	java.util.ArrayList<com.hanjin.framework.component.util.code.CodeInfo> applyTypeList = null;

	try {
		SignOnUserAccount account = (SignOnUserAccount) session
				.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmPri2087Event) request.getAttribute("Event");
		serverException = (Exception) request
				.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		applyTypeList = (java.util.ArrayList<com.hanjin.framework.component.util.code.CodeInfo>)com.hanjin.framework.component.util.code.CodeUtil.getInstance().getCodeSelect("CD01728", 0);

	} catch (Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>GRI Calculation Inquiry</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
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
<input type="hidden" name="prop_no" value="<%=StringUtil.xssFilter(request.getParameter("prop_no"))%>">
<input type="hidden" name="amdt_seq" value="<%=StringUtil.xssFilter(request.getParameter("amdt_seq"))%>">
<input type="hidden" name="svc_scp_cd" value="<%=StringUtil.xssFilter(request.getParameter("svc_scp_cd"))%>">
<input type="hidden" name="gri_grp_seq">
<input type="hidden" name="gri_appl_flg">

<!-- OUTER - POPUP (S)tart -->
<table width="1000" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
    
        <!-- : ( Title ) (S) -->
        <table width="100%" border="0">
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;GRI Calculation Inquiry</td></tr>
        </table>
        <!-- : ( Title ) (E) -->
        
        <!-- : ( Search Options ) (S) -->
 
            <table class="search"> 
            <tr><td class="bg">
            
            
            <!-- : ( Grid ) (S) -->
            <table width="100%"  id="mainTable">
            <tr>
                <td width="100%">
                <script language="javascript">ComSheetObject('sheet1');</script>
                </td>
            </tr>
            </table>
            <!-- : ( Grid ) (E) --> 
            <table style="height:5"><tr><td colspan="8"></td></tr></table>
            <table class="grid2" border="0" style="width:100%;"> 
            <tr class="tr2_head">
                <td width="17%">CMDT Group</td>
                <td width="17%">Actual Customer</td>
                <td width="17%">Origin</td>
                <td width="17%">Origin Via</td>
                <td width="17%">Destination Via</td>
                <td width="17%">Destination</td>
            </tr>
            <tr>
                <td><textarea style="width:100%; height:40; overflow-x:visible;" readonly id="cmdt_desc" name="cmdt_desc" class="textarea2"></textarea></td>
                <td><textarea style="width:100%; height:40; overflow-x:visible" readonly id="actcust_desc" name="actcust_desc" class="textarea2"></textarea></td>
                <td><textarea style="width:100%; height:40; overflow-x:visible" readonly id="origin_desc" name="org_desc" class="textarea2"></textarea></td>
                <td><textarea style="width:100%; height:40; overflow-x:visible" readonly id="ovia_desc" name="ovia_desc" class="textarea2"></textarea></td>
                <td><textarea style="width:100%; height:40; overflow-x:visible" readonly id="dvia_desc" name="dvia_desc" class="textarea2"></textarea></td>
                <td><textarea style="width:100%; height:40; overflow-x:visible" readonly id="dest_desc" name="dest_desc" class="textarea2"></textarea></td>
            </tr>
            </table>
                
                <table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
                
                <table border="0" style="width:400;" class="search_sm2"> 
                <tr class="h23">
                    <td width="110" align="center">Applying Option&nbsp;&nbsp;</td>
                    <td width="" class="stm">
                    <%
                    if (applyTypeList != null && applyTypeList.size() > 0) {
                        for (int i = 0; i < applyTypeList.size(); i++) {
                            com.hanjin.framework.component.util.code.CodeInfo row = applyTypeList.get(i);
                            out.print("<input name=\"flt_pct_tp_cd\" value=\"" + row.getCode() + "\" type=\"radio\" class=\"trans\" disabled>&nbsp;" + row.getName() + "&nbsp;&nbsp;");
                        }
                    }
                    %>
                    </td>
                </tr>
                </table>
                <!-- : ( Grid ) (S) -->
                <table width="100%"  id="mainTable">
                <tr>
                        <td width="100%">
                        <script language="javascript">ComSheetObject('sheet2');</script>
                        </td>
                </tr>
                </table>
                <!-- : ( Grid ) (E) --> 
            
            </td></tr>
        </table>
<!-- : ( Search Options ) (E) -->

    </td></tr>
        </table>
<!-- : ( Button : pop ) (S) -->


<table class="height_5"><tr><td></td></tr></table>

<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
    
        <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
        <tr><td class="btn3_bg">
            <table border="0" cellpadding="0" cellspacing="0">
            <tr>
                    <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_close">Close</td>
                    <td class="btn1_right"></td>
                    </table>
            </td>
        </tr>
        </table></td>
        </tr>
        </table>
    <!--Button (E) -->
    
    </td></tr>
</table>
<!-- : ( Button : pop ) (E) -->

<div id="hiddenSheetLayer" style="display: none">
<script language="javascript">ComSheetObject('sheet3');</script>
<script language="javascript">ComSheetObject('sheet4');</script>
<script language="javascript">ComSheetObject('sheet5');</script>
<script language="javascript">ComSheetObject('sheet6');</script>
<script language="javascript">ComSheetObject('sheet7');</script>
<script language="javascript">ComSheetObject('sheet8');</script>
</div>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>