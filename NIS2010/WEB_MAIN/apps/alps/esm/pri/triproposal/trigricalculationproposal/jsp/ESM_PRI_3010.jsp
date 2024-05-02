<%  
/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_PRI_3010.jsp
 *@FileTitle : TRI GRI Calculation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.12.10
 *@LastModifier : 박성수
 *@LastVersion : 1.0
 * 2009.12.10 박성수
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
<%@ page import="com.hanjin.apps.alps.esm.pri.triproposal.trigricalculationproposal.event.EsmPri3010Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
    EsmPri3010Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지
	int rowCount = 0; //DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	Logger log = Logger.getLogger("com.hanjin.apps.TRIProposal.TRIGRICalcualtionProposal");
	
	java.util.ArrayList<com.hanjin.framework.component.util.code.CodeInfo> applyTypeList = null;

	try {
		SignOnUserAccount account = (SignOnUserAccount) session
				.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmPri3010Event) request.getAttribute("Event");
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
<title>TRI GRI Calculation</title>
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
<input type="hidden" name="trf_pfx_cd" value="<%=request.getParameter("trf_pfx_cd")%>">
<input type="hidden" name="trf_no" value="<%=request.getParameter("trf_no")%>">
<input type="hidden" name="gri_grp_seq">
<input type="hidden" name="gri_appl_flg">

<!-- OUTER - POPUP (S)tart -->
<table width="900" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
    
        <!-- : ( Title ) (S) -->
        <table width="100%" border="0">
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp; TRI GRI Calculation</td></tr>
        </table>
        <!-- : ( Title ) (E) -->
        
        <!-- : ( Search Options ) (S) -->
 
            <table class="search"> 
            <tr><td class="bg">
            
			<table class="search" border="0" style="width:100%;"> 
			<tr class="h23">
				<td width="75">Tariff Code</td>
				<td width="82"><script language="javascript">ComComboObject("trf_cd", 2, 80, 0, 1, 0, false);</script></td>
				<td  width="300" style="padding-bottom:1"><input type="text" name="trf_nm" style="width:270;text-align:center;" class="input2"  readonly caption="Tariff Code"></td>
				
				<td width="120">GRI Effective Date</td>
				<td width=""><input type="text" name="gri_eff_dt" style="width:80;text-align:center;" class="input1" caption="GRI Effective Date" maxlength="10" dataformat="ymd">&nbsp;<img name="btn_grieffdt" src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
				
			</tr></table>
			<table class="line_bluedot"><tr><td></td></tr></table>
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
                <td width="17%">Origin</td>
                <td width="17%">Origin Via</td>
                <td width="17%">Destination Via</td>
                <td width="17%">Destination</td>
            </tr>
            <tr>
                <td><textarea style="width:100%; height:40; overflow-x:visible;" readonly id="cmdt_desc" name="cmdt_desc" class="textarea2"></textarea></td>
                <td><textarea style="width:100%; height:40; overflow-x:visible" readonly id="origin_desc" name="org_desc" class="textarea2"></textarea></td>
                <td><textarea style="width:100%; height:40; overflow-x:visible" readonly id="ovia_desc" name="ovia_desc" class="textarea2"></textarea></td>
                <td><textarea style="width:100%; height:40; overflow-x:visible" readonly id="dvia_desc" name="dvia_desc" class="textarea2"></textarea></td>
                <td><textarea style="width:100%; height:40; overflow-x:visible" readonly id="dest_desc" name="dest_desc" class="textarea2"></textarea></td>
            </tr>
            </table>
                <!--  Button_Sub (S) -->
                <table width="100%" class="button"> 
                    <tr><td class="btn2_bg">
                        <table border="0" cellpadding="0" cellspacing="0"><tr>
                            <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                            <tr><td class="btn2_left"></td>
                            <td class="btn2" name="btn_rowadd1">Row Add</td>
                            <td class="btn2_right"></td>
                            </tr>
                            </table></td>
                            <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                            <tr><td class="btn2_left"></td>
                            <td class="btn2" name="btn_rowcopy1">Row Copy</td>
                            <td class="btn2_right"></td>
                            </tr>
                            </table></td>
                            <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                            <tr><td class="btn2_left"></td>
                            <td class="btn2" name="btn_delete1">Delete</td>
                            <td class="btn2_right"></td>
                            </tr>
                            </table></td>
                        </tr></table>
                    </td></tr>
                </table>
                <!-- Button_Sub (E) -->
                    
                
                <table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
                
                <table border="0" style="width:400;" class="search_sm2"> 
                <tr class="h23">
                    <td width="110" align="center">Applying Option&nbsp;&nbsp;</td>
                    <td width="" class="stm">
                    <%
                    if (applyTypeList != null && applyTypeList.size() > 0) {
                        for (int i = 0; i < applyTypeList.size(); i++) {
                            com.hanjin.framework.component.util.code.CodeInfo row = applyTypeList.get(i);
                            out.print("<input name=\"flt_pct_tp_cd\" value=\"" + row.getCode() + "\" type=\"radio\" class=\"trans\">&nbsp;" + row.getName() + "&nbsp;&nbsp;");
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
                
                <!--  Button_Sub (S) -->
                <table width="100%" class="button"> 
                    <tr><td class="btn2_bg">
                        <table border="0" cellpadding="0" cellspacing="0"><tr>
                            <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                            <tr><td class="btn2_left"></td>
                            <td class="btn2" name="btn_rowadd2">Row Add</td>
                            <td class="btn2_right"></td>
                            </tr>
                            </table></td>
                            <!--td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                            <tr><td class="btn2_left"></td>
                            <td class="btn2" name="btn_rowcopy2">Row Copy</td>
                            <td class="btn2_right"></td>
                            </tr>
                            </table></td-->
                            <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                            <tr><td class="btn2_left"></td>
                            <td class="btn2" name="btn_delete2">Delete</td>
                            <td class="btn2_right"></td>
                            </tr>
                            </table></td>
                            <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                            <tr><td class="btn2_left"></td>
                            <td class="btn2" name="btn_save2">Save</td>
                            <td class="btn2_right"></td>
                            </tr>
                            </table></td>
                        </tr></table>
                    </td></tr>
                </table>
                <!-- Button_Sub (E) -->
                    
                
                
            
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
                <td width="72"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_new">New</td>
                    <td class="btn1_right"></td></tr></table></td>
                <td width="72"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_ok">OK</td>
                    <td class="btn1_right"></td></tr></table></td>
                <td width="72"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_cancel">Cancel</td>
                    <td class="btn1_right"></td></tr></table></td>
                    <td class="btn1_line"></td>
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
</div>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>