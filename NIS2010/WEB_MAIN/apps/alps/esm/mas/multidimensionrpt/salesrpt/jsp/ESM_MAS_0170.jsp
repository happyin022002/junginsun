<%--
/*=========================================================
*Copyright(c) 2008 CyberLogitec
*@FileName : ESM_MAS_0170.jsp
*@FileTitle : RMK 팝업
*Open Issues :
*@LastModifyDate : 2009.09.07
*@LastModifier : Park eun ju
*@LastVersion : 1.0
* 2009-03-10 김태윤
*
*Change history :
* 1.0 최초 생성 CSR No.N200903040144
* 2009.03.20 김태윤 N200903190090 MAS Cost Detail 화면 해당 route의 비용만 표시 [170]
* 2009.09.07 박은주  Alps 전환작업
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%
	Exception serverException = null;
	String strErrMsg = "";
	
	String f_bkg_no = "";
	String f_pro_vw = "";
	String f_pro_lvl = "";
	String f_cost_yrmon = "";
	String f_rout_no = "";
	
	Logger log = Logger.getLogger("com.hanjin.apps.alps.esm.mas.multidimensionrpt.sales.jsp.ESM_MAS_0170");
	try {
		f_bkg_no = JSPUtil.getNull(request.getParameter("f_bkg_no"));
		f_pro_vw =  JSPUtil.getNull(request.getParameter("f_pro_vw"));
		f_pro_lvl =  JSPUtil.getNull(request.getParameter("f_pro_lvl"));
		f_cost_yrmon =  JSPUtil.getNull(request.getParameter("f_cost_yrmon"));
		f_rout_no =  JSPUtil.getNull(request.getParameter("f_rout_no"));
		
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		} //end of if
	} catch(Exception e) {
		log.error("JSP Exception : " + e.toString());
	}
%>
<html>
<head>
<iframe height="0" width="0" name="frmHidden"></iframe>
<title>Inquiry by BKG Remark</title>
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
<iframe height="0" width="0" name="frmHidden"></iframe>
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();" onresize="changeSheetRows();">
<form method="post" name="form" onKeyDown="ComKeyEnter();">
<input type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="param1">
<!--  부모창으로부터 전송된 폼값 -->
<input type="hidden" name="f_pro_vw" value="<%=f_pro_vw%>">
<input type="hidden" name="f_pro_lvl" value="<%=f_pro_lvl%>">
<input type="hidden" name="f_cost_yrmon" value="<%=f_cost_yrmon%>">
<input type="hidden" name="f_rout_no" value="<%=f_rout_no%>">

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0">
    <tr><td class="top"></td></tr>
    <tr>
        <td valign="top">
            <!-- : ( Title ) (S) -->
            <table width="100%" border="0">
                <tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp; Inquiry by BKG Remark</td></tr>
            </table>
            <!-- : ( Title ) (E) -->
        
            <!-- : ( Search Options ) (S) -->
            <table class="search">
                <tr>
                    <td class="bg">
                        <table class="search" border="0">
                            <tr>
                                <td class="title_h"></td>
                                <td class="title_s">Cost Detail Inquiry</td>
                                <td style="width:50;">BKG No.</td>
                                <td><input name="f_bkg_no" type="text" class="input2" style="width:90;ime-mode:disabled;"  value="<%=f_bkg_no%>" ReadOnly></td>
                                <td style="width:30;">POR</td>
                                <td><input name="por_cd" type="text" class="input2" style="width:45;ime-mode:disabled;" value="<%=JSPUtil.getNull(request.getParameter("sheet1_por"))%>" ReadOnly></td>
                                <td style="width:30;">POL</td>
                                <td><input name="pol_cd" type="text" class="input2" style="width:45;ime-mode:disabled;" value="<%=JSPUtil.getNull(request.getParameter("sheet1_pol"))%>" ReadOnly></td>
                                <td style="width:30;">POD</td>
                                <td><input name="pod_cd" type="text" class="input2" style="width:45;ime-mode:disabled;" value="<%=JSPUtil.getNull(request.getParameter("sheet1_pod"))%>" ReadOnly></td>
                                <td style="width:30;">DEL</td>
                                <td><input name="del_cd" type="text" class="input2" style="width:45;ime-mode:disabled;" value="<%=JSPUtil.getNull(request.getParameter("sheet1_del"))%>" ReadOnly></td>
                                <td align="right" valign="bottom">
                                    <div id="div_zoom_in1" style="display:inline">
                                    <img class="cursor" src="/hanjin/img/bu_prev01.gif" height="11" border="0" name="bu_zoom_in1" alt="Zoom in(+)">
                                    </div>
                                    <div id="div_zoom_out1" style="display:none">
                                    <img class="cursor" src="/hanjin/img/bu_next01.gif" height="11" border="0" name="bu_zoom_out1" alt="Zoom out(-)">
                                    </div>
                                </td>
                            </tr>    
                            <tr>
                                <td colspan="13">
                                    <!-- : ( Grid ) (S) -->
                                    <table width="100%" id="mainTable">
                                    <tr><td><script language="javascript">ComSheetObject('sheet1');</script></td></tr>
                                    </table>
                                    <!-- : ( Grid ) (E) -->
                                </td>
                            </tr>
                            <tr><td colspan="3" class="height_5"></td></tr>
                        </table>
                    </td>
                </tr>
            </table>
            <!-- : ( Search Options ) (E) -->
        </td>
    </tr>
</table>
<!-- OUTER - POPUP (E)nd -->
<table class="height_5"><tr><td></td></tr></table>
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
    <tr>
        <td height="71" class="popup">
            <!-- : ( Button : pop ) (S) -->
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
                                            <td class="btn1" name="btng_Downexcel" id="btng_Downexcel">Down Excel</td>
                                            <td class="btn1_right"></td>
                                        </tr>
                                    </table>
                                </td>
                                <td class="btn1_line"></td>
                                <td>
                                    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                        <tr>
                                            <td class="btn1_left"></td>
                                            <td class="btn1" name="btng_Close" id="btng_Close">Close</td>
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
            <!-- : ( Button : pop ) (E) -->
        </td>
    </tr>
</table>
</form>
</body>
</html>
