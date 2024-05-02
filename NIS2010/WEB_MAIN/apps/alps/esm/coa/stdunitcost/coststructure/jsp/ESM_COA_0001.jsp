<%--/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_COA_0001.jsp
*@FileTitle : 항목별 조건목록 등록
*Open Issues :
*@LastModifyDate : 2009.07.10
*@LastModifier : Park eun ju
*@LastVersion : 1.0
* 2006-10-26 IM OKYOUNG
* 1.0 최초 생성
* =========================================================
*Change history :
* 2008.05.02 임옥영 R200804296327 CSS파일 경로 변경
* 2009.07.10 박은주 New Framework 적용
* 2015.07.07 이윤정 [CHM-201536740] COA 내 화면의 조회 기능 (Retrieve, Down Excel)을 뺀 나머지 버튼들을 비활성화 요청 CSR
=========================================================*/--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
	Exception serverException	= null;								//서버에서 발생한 에러
	String strErrMsg = "";													//에러메세지
	Logger log = Logger.getLogger("com.hanjin.apps.alps.esm.coa.stdunitcost.coststructure.CoaSpclRepoCntrRgst");

	try {
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		} // end else
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Set List Box To Set Key Business Rule</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            ComShowMessage(errMessage);
        } // end if
        loadPage();
        setRetrieveAction();
    }
</script>
</head>
<body onload="javascript:setupPage();">
<form method="post" name="form" onKeyDown="ComKeyEnter();">
<input	type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<!-- design start -->
<!-- OUTER - POPUP (S)tart -->
<table width="400" class="popup" cellpadding="10" border="0">
    <tr><td class="top"></td></tr>
    <tr>
        <td valign="top">
            <!-- : ( Title ) (S) -->
            <table width="100%" border="0">
                <tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp; Set List Box To Set Key Business Rule</td></tr>
            </table>
            <!-- : ( Title ) (E) -->
            
            <!--1 Start-->
            <!-- : ( Search Options ) (S) -->
            <table class="search" align="center">
                <tr>
                    <td class="bg">
                        <table class="search" align="center">
                            <tr>
                                <td>
                                    <select style="width:99%;" name="select" OnChange="ChangSheet(this.value)">
                                        <!--<option value="0" selected>How to Make Unit Costs</option> -->
                                        <!--<option value="1">Term for ACtivity-based Cositing</option> -->
                                        <option value="1">Sp Group / EQ Repo. Contribution</option>
                                        <!--<option value="2">Setting MT Cycled Route</option> -->
                                    </select>
                                </td>
                            </tr>
                        </table>
                        <table class="height_5"><tr><td></td></tr></table>
                        <!-- UI_ESS_EQR_010 : THIS IS 1st TAB -->
                        <!-- : ( Level Group ) (E) -->
                        <table width="100%" id="mainTable">
                            <tr><td><script language="javascript">ComSheetObject('sheet');</script></td></tr>
                        </table>
                        <!-- : ( Level Group ) (E) -->
                        <!-- : ( Button : Sub ) (S) -->
                        <table width="100%" class="button">
                            <tr>
                                <td class="btn2_bg">
                                    <table border="0" cellpadding="0" cellspacing="0">
                                        <tr>
                                        
                                            <!-- Repeat Pattern -->
                                            <!--
                                            <td>
                                                <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                                    <tr>
                                                        <td class="btn2_left"></td>
                                                        <td class="btn2" id="btng_RowAdd" name="btng_RowAdd">Row Add</td>
                                                        <td class="btn2_right"></td>
                                                    </tr>
                                                </table>
                                            </td>
                                            <td>
                                                <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                                    <tr>
                                                        <td class="btn2_left"></td>
                                                        <td class="btn2" id="btng_Save" name="btng_Save">Save</td>
                                                        <td class="btn2_right"></td>
                                                    </tr>
                                                </table>
                                            </td>
                                        	-->
                                            <!-- Repeat Pattern -->
                                            
                                        </tr>
                                    </table>
                                </td>
                            </tr>
                        </table>
                        <!-- : ( Button : Sub ) (E) -->
                    </td>
                </tr>
            </table>
            <!-- : ( Search Options ) (E) -->
            <!--1 End-->
        
        </td>
    </tr>
</table>
<!-- OUTER - POPUP (E)nd -->

<table class="height_5"><tr><td></td></tr></table>


<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
    <tr>
        <td height="71" class="popup">
            <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
                <tr>
                    <td class="btn3_bg">
                        <table border="0" cellpadding="0" cellspacing="0">
                            <tr>
                                <!-- Repeat Pattern -->
                                <td>
                                    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                        <tr>
                                            <td class="btn1_left"></td>
                                            <td class="btn1" name="btn_Close" id="btn_Close">Close</td>
                                            <td class="btn1_right"></td>
                                        </tr>
                                    </table>
                                </td>
                                <!-- Repeat Pattern -->
                            </tr>
                        </table>
                    </td>
                </tr>
            </table>
        </td>
    </tr>
</table>
<!-- : ( Button : pop ) (E) -->
</form>
</body>
</html>