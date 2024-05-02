
<%
	/*=========================================================
	 *Copyright(c) 2013 CyberLogitec
	 *@FileName : esm_bkg_1201.jsp
	 *@FileTitle : BKG Dashboard (by Office)
	 *Open Issues :
	 *Change history :
	 *@LastModifyDate : 2013.10.16
	 *@LastModifier : Poong-Yeon Cho
	 *@LastVersion : 1.0
	 * 2013.10.16 Poong-Yeon Cho
	 * 1.0 Creation
	 =========================================================*/ 
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page
    import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page
    import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingreport.dashboard.event.EsmBkg1201Event"%>  
<%@ page import="org.apache.log4j.Logger"%>

<%
    EsmBkg1201Event event = null; //PDTO(Data Transfer Object including Parameters)
    Exception serverException = null; //서버에서 발생한 에러
    String strErrMsg = ""; //에러메세지
    int rowCount = 0; //DB ResultSet 리스트의 건수

    String successFlag = "";
    String codeList = "";
    String pageRows = "100";

    String strUsr_id = "";
    String strUsr_nm = "";
    boolean bBtn_Disabled = true;

    try {
        SignOnUserAccount account = (SignOnUserAccount) session
                .getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();

        event = (EsmBkg1201Event) request.getAttribute("Event");
        serverException = (Exception) request
                .getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException)
                    .loadPopupMessage();
        }

        // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
        GeneralEventResponse eventResponse = (GeneralEventResponse) request
                .getAttribute("EventResponse");

    } catch (Exception e) {
        out.println(e.toString());
    }
%>
<html>
<head>
<title>Welcome to alps!</title>
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

<body class="popup_bg" onLoad="setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd">
<input type="hidden" name="f_rhq_cd" value='<%=JSPUtil.getNull(request.getParameter("f_rhq_cd"))%>'>
<input type="hidden" name="s_kind" value='<%=JSPUtil.getNull(request.getParameter("s_kind"))%>'>
<input type="hidden" name="f_bkg_ofc_cd" value='<%=JSPUtil.getNull(request.getParameter("f_bkg_ofc_cd"))%>'>
<input type="hidden" name="f_sub_bkg_ofc_cd" value='<%=JSPUtil.getNull(request.getParameter("f_sub_bkg_ofc_cd"))%>'>
<input type="hidden" name="f_bkg_no" value='<%=JSPUtil.getNull(request.getParameter("f_bkg_no"))%>'>
<input type="hidden" name="f_vvd" value='<%=JSPUtil.getNull(request.getParameter("f_vvd"))%>'>
<input type="hidden" name="f_pol_nod_cd" value='<%=JSPUtil.getNull(request.getParameter("f_pol_nod_cd"))%>'>
<input type="hidden" name="f_pod_nod_cd" value='<%=JSPUtil.getNull(request.getParameter("f_pod_nod_cd"))%>'>
<input type="hidden" name="f_staff_id" value='<%=JSPUtil.getNull(request.getParameter("f_staff_id"))%>'>
<input type="hidden" name="f_rep_id" value='<%=JSPUtil.getNull(request.getParameter("f_rep_id"))%>'>
<input type="hidden" name="c_kind" value='<%=JSPUtil.getNull(request.getParameter("c_kind"))%>'>
<input type="hidden" name="combo_cust" value='<%=JSPUtil.getNull(request.getParameter("combo_cust"))%>'>
<input type="hidden" name="combo_gcust" value='<%=JSPUtil.getNull(request.getParameter("combo_gcust"))%>'>
<input type="hidden" name="combo_ctrt" value='<%=JSPUtil.getNull(request.getParameter("combo_ctrt"))%>'>
<input type="hidden" name="f_ctrt_no" value='<%=JSPUtil.getNull(request.getParameter("f_ctrt_no"))%>'>
<input type="hidden" name="f_gcust_cd" value='<%=JSPUtil.getNull(request.getParameter("f_gcust_cd"))%>'>
<input type="hidden" name="f_cust_cd" value='<%=JSPUtil.getNull(request.getParameter("f_cust_cd"))%>'>
<input type="hidden" name="f_dbd_cre_dt" value='<%=JSPUtil.getNull(request.getParameter("f_dbd_cre_dt"))%>'>
<input type="hidden" name="f_dbd_cre_seq" value='<%=JSPUtil.getNull(request.getParameter("f_dbd_cre_seq"))%>'>
<input type="hidden" name="f_dest_cnt_cd" value='<%=JSPUtil.getNull(request.getParameter("f_dest_cnt_cd"))%>'>
<input type="hidden" name="f_irr_tp_cd" value='<%=JSPUtil.getNull(request.getParameter("f_irr_tp_cd"))%>'>
<input type="hidden" name="s_bkg_ofc_cd" value='<%=JSPUtil.getNull(request.getParameter("s_bkg_ofc_cd"))%>'>

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
    
        <!-- : ( Title ) (S) -->
        <table width="100%" border="0">
        <tr><td class="title"><img src="./img/icon_title_dot.gif" align="absmiddle">&nbsp;Dashboard Detail - <%=JSPUtil.getNull(request.getParameter("f_irr_tp_nm"))%></td></tr>
        </table>
        <!-- : ( Title ) (E) -->

        <!-- : ( Search Options ) (S) -->
            <!--biz page-1 (S)-->
        <table class="search"> 
        <tr><td class="bg">
                <table class="height_2"><tr><td></td></tr></table>
                <!-- : ( Grid ) (S) -->
                    <table width="100%"  id="mainTable"> 
                        <tr>
                            <td width="100%">
                                <script language="javascript">ComSheetObject('sheet1');</script>
                            </td>
                        </tr>
                    </table> 
                <!-- : ( Grid ) (E) --> 
<!-- : ( Search Options ) (E) -->
</td></tr>
</table> 

<table class="height_5"><tr><td></td></tr></table>
    
    </td></tr>
</table> 
    <!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

        <!--Button (S) -->  
        <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
            <tr><td class="btn3_bg">
                    <table border="0" cellpadding="0" cellspacing="0">
                      <tr>  
                        <td class="btn3_bg">
                           <table border="0" cellpadding="0" cellspacing="0">
                              <tr><td>
                                     <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                        <tr>
                                            <td class="btn1_left"></td><td class="btn1" name="btn_downexcel" id="btn_downexcel">DownExcel</td><td class="btn1_right"></td>
                                            <td class="btn1_left"></td>
                                            <td class="btn1" name="btn_close">Close</td>
                                            <td class="btn1_right"></td>
                                        </tr>
                                     </table>
                                  </td> 
                              </tr>
                           </table>
                        </td>
                      </tr>
                    </table>
            </td></tr>
        </table>
        <!--Button (E) -->
    
    </td></tr>
</table>
<!-- : ( Button : pop ) (E) -->

            
</form>
</body>
</html>
<%@include file="../../../../../../../bizcommon/include/common_alps.jsp"%>