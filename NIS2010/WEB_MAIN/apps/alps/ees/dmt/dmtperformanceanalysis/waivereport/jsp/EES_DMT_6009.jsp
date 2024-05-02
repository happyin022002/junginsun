<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_6009.jsp
*@FileTitle : Waive Report by Office
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.19
*@LastModifier : mun jung cheol
*@LastVersion : 1.0
* 2009.10.19 mun jung cheol
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
<%@ page import="com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.waivereport.event.EesDmt6009Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EesDmt6009Event  event = null;                  //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //서버에서 발생한 에러
    String strErrMsg = "";                      //에러메세지
    int rowCount     = 0;                       //DB ResultSet 리스트의 건수

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    String strUsr_ofc       = "";
    String strRhq_ofc_cd    = "";
    Logger log = Logger.getLogger("com.hanjin.apps.DMTPerformanceAnalysis.waivereport");

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
        strUsr_ofc  = account.getOfc_cd();
        strRhq_ofc_cd = account.getRhq_ofc_cd();


        event = (EesDmt6009Event)request.getAttribute("Event");
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
<title>Waive Report by Office</title>
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

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<!-- 개발자 작업 -->
<input type="hidden" name="usr_ofc_cd"          value="<%=strUsr_ofc%>">
<input type="hidden" name="usr_rhq_ofc_cd"      value="<%=strRhq_ofc_cd%>">
<input type="hidden" name="ofc_cd2">
<input type="hidden" name="ofc_cd">
<input type="hidden" name="tmp_ofc_cd">
<input type="hidden" name="dmdt_cntr_tp_cd">
<input type="hidden" name="dmdt_trf_cd">
<input type="hidden" name="start_dt">
<input type="hidden" name="end_dt">
<input type="hidden" name="slctofccd">
<input type="hidden" name="slcttrfcd">
<input type="hidden" name="slctscno">
<input type="hidden" name="slctrfano">
<input type="hidden" name="tempuser">
<input type="hidden" name="curr_flg2">


<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
    <tr><td valign="top">
    <!--Page Title, Historical (S)-->
        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
            <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
            <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
        </table>
    <!--Page Title, Historical (E)-->
    
        <!--biz page (S)-->
        <table class="search" id="mainTable"> 
            <tr><td class="bg">
            <div id="sch_cond_div" style=display:block;>

                <!--  biz_1  (S) -->
                <table class="search" border="0" style="width:979;"> 
                <tr class="h23">
                    <td width="730" style="height:32;">
                
                        <table border="0" style="width:650;" class="search_sm2"> 
                        <tr class="h23">
                            <td width="120">&nbsp;&nbsp;To MVMT Date</td>
                            <td class="stm">
                                <input type="radio" name="dt_flg" value="M" class="trans" checked>&nbsp;Month&nbsp;&nbsp;<input type="text" name="to_mvmt_mon" maxlength="6" dataformat="ym" style="width:65" class="input1" value="">&nbsp;&nbsp;
                                <input type="radio" name="dt_flg" value="P" class="trans">&nbsp;Period&nbsp;&nbsp;
                                <input type="text" name="fm_dt" maxlength="8" dataformat="ymd" style="width:80" class="input1">&nbsp;~
                                <input type="text" name="to_dt" maxlength="8" dataformat="ymd" style="width:80" class="input1">
                                <img class="cursor" src="img/btns_calendar.gif" name="btns_calendar" width="19" height="20" border="0" align="absmiddle"></td>
                        </tr>
                        </table>
                    
                    </td>
                    <td width="90">Tariff Type</td>
                    <td align="">
                    <script language="javascript">ComComboObject('tariff_type',1,130,1,1,0,false);</script>&nbsp;<img src="img/btns_multisearch.gif" width="19" height="20" alt="" border="0" align="absmiddle">
                    </td>
                </tr> 
                <tr class="h23">
                    <td style="height:32;">
                
                        <table border="0" style="width:650;" class="search_sm2"> 
                        <tr class="h23">
                            <td width="120">&nbsp;&nbsp;Waive Office</td>
                            <td class="stm" width="210">
                                <select style="width:75;" class="input1" name="reqapp">
                                    <option value="R" selected>Request </option>
                                    <option value="A"         >Approval</option>
                                </select>&nbsp;
                                <input type="radio" name="ofc_flg2" value="R" class="trans" >&nbsp;RHQ&nbsp;&nbsp;
                                <input type="radio" name="ofc_flg2" value="O" class="trans" checked>&nbsp;Office&nbsp;&nbsp;
                            </td>
                            <td width="84">
                                <div id = "div_ofc2_txt" style = "display:''" >
                                <input type="text" style="width:78;" class="input" name="location" value=""  dataformat="engup" style="ime-mode:disabled"  maxlength="5">
                                </div>
                                <div id = "div_ofc2_com" style = "display:'none'" >
                                <script language="javascript">ComComboObject('office2',1,80,0,1,0,true);</script>&nbsp;
                                </div>
                            </td>
                            <td>
                                <img src="img/btns_search.gif" name="btns_ctrt_ofc" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
                            </td>
                        </tr>
                        </table>
                    
                    </td>
                    <td width="90">Group by</td>
                    <td align="">
                        <select name="grp_flg" style="width:127;">
                        <option value="O" selected>Office</option>
                        <option value="R">RHQ</option>
                        </select>
                    </td>
                </tr> 
                <tr class="h23">
                    <td style="height:32;">
                
                        <table border="0" style="width:650;" class="search_sm2"> 
                        <tr class="h23">
                            <td width="120">&nbsp;&nbsp;Coverage</td>
                            <td class="stm">DEM/DET OFC&nbsp;
                                <input type="radio" name="ofc_flg" value="R" class="trans" checked>&nbsp;RHQ&nbsp;&nbsp;
                                <input type="radio" name="ofc_flg" value="O" class="trans">&nbsp;Office&nbsp;&nbsp;
                                <script language="javascript">ComComboObject('office',1,80,0,1,0,true);</script>&nbsp;<img src="img/btns_multisearch.gif" width="19" height="20" alt="" border="0" align="absmiddle">
                                <input type="checkbox" name="chk_sub_ofc" value="Y" onClick="doInclSubOfc()" class="trans">&nbsp;Incl. Sub Office
                            </td>
                        </tr>
                        </table>
                    
                    </td>
                </tr> 
                <tr class="h23">
                    <td style="height:32;">
                
                        <table border="0" style="width:650;" class="search_sm2"> 
                        <tr class="h23">
                            <td width="120">&nbsp;&nbsp;Currency</td>
                            <td class="stm">
                                <input type="radio" name="curr_flg" value="U" class="trans" checked>&nbsp;USD&nbsp;&nbsp;
                                <input type="radio" name="curr_flg" value="L" class="trans">&nbsp;Local
                            </td>
                        </tr>
                        </table>
                    
                    </td>
                    <td width="90">CNTR Type</td>
                    <td align="">
                        <script language="javascript">ComComboObject('cntr_type',1,130,1,0,0,false);</script>
                    </td>
                </tr> 
                </table>                
                <!--  biz_1   (E) -->

        </td></tr></table>  
        <table class="height_8"><tr><td></td></tr></table>  
        </div>
        
        <table class="search" id="mainTable"> 
            <tr><td class="bg"> 
            
            <!-- Grid (S) -->
                <table width="100%"  id="mainTable"> 
                    <tr>
                        <td width="100%">
                            <script language="javascript">ComSheetObject('sheet1');</script>
                        </td>
                    </tr>
                </table>
            <!-- Grid (E) -->   
                        
            </td></tr>
        </table>
        <!--biz page (E)-->

        <!--Button (S) -->
        <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
        <tr><td class="btn1_bg">
        
            <table border="0" cellpadding="0" cellspacing="0">
            <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_retrieve">Retrieve</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
                <td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_new">New</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
                <td class="btn1_line"></td>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_minimize">Minimize</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
                
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_detail">Detail</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_downexcel">Down Excel</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
                </tr>
            </table>
        </td></tr>
        </table>
        <!--Button (E) -->  
        
        
    </td></tr>
        </table>
    <div id="topdeck" style="position:absolute;visibility:hidden;z-index:200;"></div>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>