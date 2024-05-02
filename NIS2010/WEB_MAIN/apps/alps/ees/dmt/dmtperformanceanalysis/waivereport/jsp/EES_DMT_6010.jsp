<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_6010.jsp
*@FileTitle : Waive Report by Office Detail(s)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.21
*@LastModifier : mun jung cheol
*@LastVersion : 1.0
* 2009.10.21 mun jung cheol
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
<%@ page import="com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.waivereport.event.EesDmt6010Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EesDmt6010Event  event = null;                  //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //서버에서 발생한 에러
    String strErrMsg = "";                      //에러메세지
    int rowCount     = 0;                       //DB ResultSet 리스트의 건수

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id = "";
    String strUsr_nm = "";
    
    String tFmDt      = "";
    String tToDt      = "";
    String tReqApp    = "";
    String tSlctOfcCd = "";
    String tSlctTrfCd = "";
    String tSlctScNo  = "";
    String tSlctRfaNo = "";
    String tOfc_flg2 = "";
    String dmdt_cntr_tp_cd = "";
    String curr_flg = "";
    String ofc_cd2 = "";
    String strRhq_of = "";

    Logger log = Logger.getLogger("com.hanjin.apps.DMTPerformanceAnalysis.waivereport");

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
        strRhq_of = account.getRhq_ofc_cd();

        event      = (EesDmt6010Event)request.getAttribute("Event");
        tFmDt      = (String)request.getParameter("fm_dt"    );
        tToDt      = (String)request.getParameter("to_dt"    );
        tReqApp    = (String)request.getParameter("reqapp"   );
        tSlctOfcCd = (String)request.getParameter("slctofccd");
        tSlctTrfCd = (String)request.getParameter("slctTrfCd");
        tSlctScNo  = (String)request.getParameter("slctScNo" );
        tSlctRfaNo = (String)request.getParameter("slctRfaNo");
        tOfc_flg2  = (String)request.getParameter("ofc_flg2" );
        dmdt_cntr_tp_cd  = (String)request.getParameter("dmdt_cntr_tp_cd");
        curr_flg  = (String)request.getParameter("curr_flg");
        ofc_cd2  = (String)request.getParameter("ofc_cd2");
        
        
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

    }catch(Exception e) {
        out.println(e.toString());
    }
%>
<html>
<head>
<title>Waive Report by Office - Detail(s)</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            ComShowMessage(errMessage);
        } // end if
        loadPage();
    }
</script>

</head>

<body class="popup_bg" onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<input type="hidden" name="fm_dt"     value="<%= tFmDt      %>">
<input type="hidden" name="to_dt"     value="<%= tToDt      %>">
<input type="hidden" name="reqapp"    value="<%= tReqApp    %>">
<input type="hidden" name="ofc_flg2"  value="<%= tOfc_flg2  %>">
<input type="hidden" name="slctofccd" value="<%= tSlctOfcCd %>">
<input type="hidden" name="slcttrfcd" value="<%= tSlctTrfCd %>">
<input type="hidden" name="slctscno"  value="<%= tSlctScNo  %>">
<input type="hidden" name="slctrfano" value="<%= tSlctRfaNo %>">
<input type="hidden" name="curr_flg"  value="<%= curr_flg   %>">
<input type="hidden" name="dmdt_cntr_tp_cd" value="<%= dmdt_cntr_tp_cd %>">
<input type="hidden" name="ofc_cd2"   value="<%= ofc_cd2    %>">

<input type="hidden" name="bkg_no"             >
<input type="hidden" name="cntr_no"            >
<input type="hidden" name="bl_no"              >
<input type="hidden" name="dmdt_trf_cd"        >
<input type="hidden" name="svr_id"             >
<input type="hidden" name="cntr_cyc_no"        >
<input type="hidden" name="dmdt_chg_loc_div_cd">
<input type="hidden" name="chg_seq"            >
<input type="hidden" name="h_rhq_off" value="<%=strRhq_of%>">
<!-- 지정 화면 Access 권한 정보 조회용  -->
<input type="hidden" name="role_permit">
<input type="hidden" name="role_auth">

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
    
        <!-- : ( Title ) (S) -->
        <table width="100%" border="0">
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Waive Report by Office - Detail</td></tr>
        </table>
        <!-- : ( Title ) (E) -->
    <!--Page Title, Historical (E)-->
    
    
    <table class="search"> 
            <tr><td class="bg"  border="0">
                <!-- Grid  (S) -->
                
                <table width="100%"  id="mainTable"> 
                    <tr>
                        <td width="100%">
                            <script language="javascript">ComSheetObject('sheet1');</script>
                        </td>
                    </tr>
                </table>                

                <!-- Grid  (E) -->
                <table class="search" border="0" style="width:100%;"> 
                <tr class="h23">
                    <td width="70">CNTR Q'ty</td>
                    <td width="160"><input type="text" style="width:50;text-align:right;" class="input" value="" name="cntrqtybox" readOnly></td>
                    <td width="">&nbsp;</td>
                    </tr>
                </table>
                
                
                    </td></tr>
                    </table>
        
<!-- : ( Search Options ) (E) -->
 
            
        <table class="height_5"><tr><td></td></tr></table>    
                    
                    
            
            </td></tr>
        </table>
    <!-- Tab BG Box  (S) -->
    <!--biz page (E)-->
    
    
    
    
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
    
        <!--Button (S) -->  
        <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
        <tr><td class="btn3_bg">
            <table border="0" cellpadding="0" cellspacing="0">
            <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_bkg">by BKG</td>
                    <td class="btn1_right">
                </tr></table></td>  
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_cntr">by CNTR</td>
                    <td class="btn1_right">
                </tr></table></td>      
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_down">Down Excel</td>
                    <td class="btn1_right">
                </tr></table></td>
                <td class="btn1_line"></td>     
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_close">Close</td>
                    <td class="btn1_right">
                </tr></table></td>
            </tr>
        </table></td>
            </tr>
        </table>
        <!--Button (E) -->
    
    </td></tr>
</table>
<!-- : ( Button : pop ) (E) -->
</form>         
</body>
</html>