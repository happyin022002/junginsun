<%  
/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_PRI_2081.jsp
 *@FileTitle : GRI Calculation - Commodity/Actual Customer Select
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.08.26
 *@LastModifier : 박성수
 *@LastVersion : 1.0
 * 2009.08.26 박성수
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
<%@ page import="com.hanjin.apps.alps.esm.pri.rfaproposal.rfagricalculationproposal.event.EsmPri2081Event"%>
<%@ page import="org.apache.log4j.Logger"%>
<%@ page import="com.hanjin.framework.component.util.StringUtil" %>

<%
    EsmPri2081Event event = null; //PDTO(Data Transfer Object including Parameters)
    Exception serverException = null; //서버에서 발생한 에러
    String strErrMsg = ""; //에러메세지
    int rowCount = 0; //DB ResultSet 리스트의 건수

    String successFlag = "";
    String codeList = "";
    String pageRows = "100";

    String strUsr_id = "";
    String strUsr_nm = "";
    Logger log = Logger.getLogger("com.hanjin.apps.RFAProposal.RFAGRICalculationProposal");

    try {
        SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();

        event = (EsmPri2081Event) request.getAttribute("Event");
        serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        

    } catch (Exception e) {
        out.println(e.toString());
    }
%>
<html>
<head>
<title>GRI Calculation - Commodity/Actual Customer Select</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            //showErrMessage(errMessage);
        } // end if
        
        loadPage();
    }

</script>
</head>

<body onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업 -->
<input type="hidden" name="prop_no" value="<%=StringUtil.xssFilter(request.getParameter("prop_no"))%>">
<input type="hidden" name="amdt_seq" value="<%=StringUtil.xssFilter(request.getParameter("amdt_seq"))%>">
<input type="hidden" name="svc_scp_cd" value="<%=StringUtil.xssFilter(request.getParameter("svc_scp_cd"))%>">
<input type="hidden" name="gri_grp_seq" value="<%=StringUtil.xssFilter(request.getParameter("gri_grp_seq"))%>">
<input type="hidden" name="gri_appl_flg" value="<%=StringUtil.xssFilter(request.getParameter("gri_appl_flg"))%>">
<input type="hidden" name="is_req_usr" value="<%=StringUtil.xssFilter(request.getParameter("is_req_usr"))%>">
<input type="hidden" name="is_apro_usr" value="<%=StringUtil.xssFilter(request.getParameter("is_apro_usr"))%>">
<input type="hidden" name="cmdt_actcust_tp_cd" value="<%=StringUtil.xssFilter(request.getParameter("cmdt_actcust_tp_cd"))%>">
<input type="hidden" name="gen_spcl_rt_tp_cd" value="<%=JSPUtil.getParameter(request, "gen_spcl_rt_tp_cd")%>">

<!-- OUTER - POPUP (S)tart -->
<table width="600" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
    
        <!-- : ( Title ) (S) -->
        <table width="100%" border="0">
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp; GRI Calculation Commodity/Actual Customer Select</td></tr>
        </table>
        <!-- : ( Title ) (E) -->
        
        <!-- : ( Search Options ) (S) -->
 
            <table class="search"> 
            <tr><td class="bg">
            
                <table border="0" style="width:500;" class="search_sm"> 
                <tr class="h23">
                    <td width="70">Select</td>
                    <td width="350" class="stm" style="font-size:12;">
                        <input type="radio" id="cmdtActcustTp" name="cmdtActcustTp" value="0" class="trans">&nbsp;Commodity&nbsp;&nbsp;&nbsp;&nbsp;
                        <input type="radio" id="cmdtActcustTp" name="cmdtActcustTp" value="1" class="trans">&nbsp;Actual Customer</td>
                        </tr>
                </table>
                
                  <!-- : ( Grid ) (S) -->
                  <table width="100%"  id="mainTable">
                      <tr>
                          <td width="100%">
                            <div id="sheetLayer" style="display:none">
                            <script language="javascript">ComSheetObject('sheet1');</script>
                            </div>
                            <div id="sheetLayer" style="display:none">
                            <script language="javascript">ComSheetObject('sheet2');</script>
                            </div>
                          </td>
                      </tr>
                  </table>
                  <!-- : ( Grid ) (E) --> 
            
                <!--  Button_Sub (S) -->
                <table width="100%" class="button"> 
                <tr><td class="btn2_bg">
                    <table border="0" cellpadding="0" cellspacing="0">
                    <tr>
                    
                    <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn2_left"></td>
                    <td class="btn2" name="btn_add" suppressWait="Y">Row Add</td>
                    <td class="btn2_right"></td>
                    </tr>
                    </table></td>
                    
                    <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn2_left"></td>
                    <td class="btn2" name="btn_delete" suppressWait="Y">Delete</td>
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
                    <td class="btn1" name="btn_ok">OK</td>
                    <td class="btn1_right"></td></tr></table></td>
                    <td class="btn1_line"></td>
                    <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_close">Close</td>
                    <td class="btn1_right"></td>
                </tr></table>
            </td>
        </tr>
        </table>
        </tr>
        </table>
    <!--Button (E) -->
    
    </td></tr>
</table>
<!-- : ( Button : pop ) (E) -->

</form>
</body>
</html>

