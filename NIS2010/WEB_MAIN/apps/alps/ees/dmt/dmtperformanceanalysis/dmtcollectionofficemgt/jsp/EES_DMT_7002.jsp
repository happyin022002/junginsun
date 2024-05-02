<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_7002.jsp
*@FileTitle : DEM/DET Office Inquiry by Yard
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.13
*@LastModifier : mun jung cheol
*@LastVersion : 1.0
* 2009.10.13 mun jung cheol
* 1.0 Creation
* 2011.03.31 김태균 [CHM-201109290-01] Split 12-ALPS의 Location 조회불가건 수정 보완 요청.
=========================================================*/%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.dmtcollectionofficemgt.event.EesDmt7002Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
    EesDmt7002Event  event = null;                  //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //서버에서 발생한 에러
    String strErrMsg = "";                      //에러메세지
    int rowCount     = 0;                       //DB ResultSet 리스트의 건수

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    String strUsr_of        = "";
    String strUsr_lc        = "";
    Logger log = Logger.getLogger("com.hanjin.apps.DMTPerformanceAnalysis.DMTCollectionOfficeMgt");

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
        strUsr_of = account.getOfc_cd();
        strUsr_lc = account.getCnt_cd();


        event = (EesDmt7002Event)request.getAttribute("Event");
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
<title>DEM/DET Office Inquiry by Yard</title>
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
<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="conti_cd">
<input type="hidden" name="cnt_cd">
<input type="hidden" name="rgn_cd">
<input type="hidden" name="ste_cd">
<input type="hidden" name="loc_cd">
<input type="hidden" name="yd_cd">

<input type="hidden" name="dmdt_trf_cd">
<input type="hidden" name="cvrg_conti_cd">
<input type="hidden" name="cvrg_cnt_cd">
<input type="hidden" name="cvrg_rgn_cd">
<input type="hidden" name="cvrg_ste_cd">
<input type="hidden" name="cvrg_loc_cd">
<input type="hidden" name="cvrg_yd_cd">
<input type="hidden" name="org_dest_conti_cd">
<input type="hidden" name="org_dest_cnt_cd">
<input type="hidden" name="org_dest_rgn_cd">
<input type="hidden" name="org_dest_ste_cd">
<input type="hidden" name="org_dest_loc_cd">

<input type="hidden" name="svr_id">
<input type="hidden" name="trf_seq">
<input type="hidden" name="trf_grp_seq">

<input type="hidden" name="wknd1" value="SAT">
<input type="hidden" name="wknd2" value="SUN">

<input type="hidden" name="demdetoff">
<input type="hidden" name="countrycd">
<input type="hidden" name="yardlocat">
<input type="hidden" name="yardnodee">
<input type="hidden" name="h_user_office"  value="<%= strUsr_of %>"  >
<input type="hidden" name="usr_ofc_cd" value="<%= strUsr_of %>">
<input type="hidden" name="ofc_cd">
<input type="hidden" name="tmp_ofc_cd">
<input type="hidden" name="usr_cnt_cd" value="<%= strUsr_lc %>">

<!-- 개발자 작업 -->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
    <tr><td valign="top">
    <!--top menu (S)-->
        <!--top menu (E)-->
    </td></tr>
    
    
    
    
    
    
    
    
    <tr><td valign="top">
    <!--Page Title, Historical (S)-->
        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
            <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
            <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
        </table>
    <!--Page Title, Historical (E)-->
     <!--Button (S) -->
        <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:2;"> 
        <tr><td class="btn1_bg">
            <table border="0" cellpadding="0" cellspacing="0">
            <tr>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_retrieve">Retrieve</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_new">New</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
                <td class="btn1_line"></td>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_downExcel">Down Excel</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
        </td></tr>
        </table>
        </td></tr>
        </table>
    <!--Button (E) -->
    
    <table class="search"> 
            <tr><td class="bg">
                <!--  biz_1  (S) -->
                <table class="search" border="0" style="width:979;"> 
                    <tr class="h23"> 
                    
                        <td width="105">DEM/DET Office </td>
                        <td width="245" class="sm">
                            <script language="javascript">ComComboObject('office',1,80,0,0,0,true);</script>&nbsp;
                            <img src="img/btns_multisearch.gif" width="19" height="20" alt="" border="0" align="absmiddle">
                            <input type="checkbox" name="chk_sub_ofc" value="Y" onClick="doInclSubOfc()"  class="trans">&nbsp;Incl. Sub Office                        
                        </td>
                        <td width="70">Collection </td>
                        <td class="stm" width="100">I/B 
                            <select style="width:60;" class="input" name="collectib">
                                <option value="A" selected>All</option>
                                <option value="Y"         >Yes</option>
                                <option value="N"         >No </option>
                            </select>
                        </td>
                        <td class="stm" width="">O/B 
                            <select style="width:60;" class="input" name="collectob">
                                <option value="A" selected>All</option>
                                <option value="Y"         >Yes</option>
                                <option value="N"         >No </option>
                            </select>
                        </td>
                    </tr>
                
                </table>
                
                <table class="search" border="0" style="width:979;"> 
                    <tr class="h23"> 
                    
                        <td width="57">Country </td>
                        <td width="100" class="sm">
                            <script language="javascript">ComComboObject('combo3', 2, 50 , 0, 0, 0, true)</script>
                        </td>
                        
                        <td width="30">Yard </td>
                        <td  width="162">
                            <input type="text" id="yd_cd1" name="yd_cd1" style="width:60;" class="input" value="" dataformat="engnum" maxlength="5" style="ime-mode:disabled" onKeyPress="ComKeyOnlyAlphabet('upper')" OnKeyUp="checkYard1(this)" >&nbsp;
                            <script language="javascript">ComComboObject('combo5', 2, 50 , 0, 0, 0, true)</script>                        
                        </td>
                        
                        <td width="89">Yard Status </td>
                        <td class="stm" width="">
                            <select style="width:60;" class="input" name="yarddelyn">
                                <option value="A"         >All   </option>
                                <option value="N" selected>Live  </option>
                                <option value="Y"         >Deleted</option>
                            </select>
                        </td>
                        
                    </tr>
                </table>
                
                
                
                
                
                
                
                <!--  biz_1  (E) -->
                
                <table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
                
                <!-- Grid  (S) -->
                <table width="100%"  id="mainTable"> 
                    <tr>
                        <td width="100%">
                            <script language="javascript">ComSheetObject('sheet1');</script>
                        </td>
                    </tr>
                </table>
                <!-- Grid  (e) -->
                
                
                    
            </td></tr>
        </table>
        
<!-- : ( Search Options ) (E) -->
 
            
            
                    
                    
            
            
    <!-- Tab BG Box  (S) -->
    <!--biz page (E)-->
   
    </td></tr>
</table>
    </td></tr>
</table>
<!-- Copyright (S) -->
<!-- Copyright(E)-->
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>