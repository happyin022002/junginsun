<%
/*=========================================================
*Copyright(c) 2018 SM Lines
*@FileName : ESM_SPC_0090.js
*@FileTitle : SPACE MANAGEMENT PLAN (NEW)
*Open Issues :
*Change history :
*@LastModifyDate : 2018.03.19
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2018.03.19 송민석
* 1.0 Creation
* 
* History
* 2018.03.19 송민석 [CSR #3462] 기존 H/O, RHQ, L/OFC 3단계로 진행 되던 업무를 H/O에서 통합 관리하도록 수정함 이에 ESM_SPC_0090을 copy해서 새로운 화면으로 만듬
* 
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.event.EsmSpc0090Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EsmSpc0090Event  event = null;                  //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //서버에서 발생한 에러
    String strErrMsg = "";                      //에러메세지
    int rowCount     = 0;                       //DB ResultSet 리스트의 건수

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    String strOfc_cd        = "";
//  String admFlg = "";
    Logger log = Logger.getLogger("com.hanjin.apps.ModelManage.ModelManage");

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
        strOfc_cd = account.getOfc_cd();

        event = (EsmSpc0090Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        if (serverException == null) {
            // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
            GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
//          admFlg = eventResponse.getETCData("adm");
//          admFlg = admFlg==null?"N":admFlg;
        }

    }catch(Exception e) {
        out.println(e.toString());
    }

    
%>
<html>
<head>
<title>Modelship by HO</title>
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
<form name="form" onsubmit="return false;" onKeyDown="enter();">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="perf_st_yrwk">
<input type="hidden" name="perf_end_yrwk">
<input type="hidden" name="cfm_ver_prd_from">
<input type="hidden" name="cfm_ver_prd_to">
<input type="hidden" name="duration">
<input type="hidden" name="backendjob_key">
<input type="hidden" name="login_ofc_cd" value="<%=strOfc_cd%>">
<input type="hidden" name="ctrl_grp_xml">
<!-- <input type="hidden" name="adm_flg" value="admFlg"> -->
<!-- 개발자 작업 -->

<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>

        <!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
            <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
            <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
            
        </table>
        <!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->
        
        <!-- TABLE '#D' : ( Button : Main ) (S) -->
        <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
            <tr><td class="btn1_bg">
                
                    <table border="0" cellpadding="0" cellspacing="0">
                        <tr>
                            <!-- Repeat Pattern -->
                                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                    <tr><td class="btn1_left"></td><td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>
                                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                    <tr><td class="btn1_left"></td><td class="btn1" name="btn_save" id="btn_save">Save</td><td class="btn1_right"></td></tr></table></td>
                                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                    <tr><td class="btn1_left"></td><td class="btn1" name="btn_downexcel" id="btn_downexcel">Down Excel</td><td class="btn1_right"></td></tr></table></td>
                                <td width="5"></td>
                                <td class="btn1_line"></td>
                                <td width="5"></td>
                                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                    <tr><td class="btn1_left"></td><td class="btn1" name="btn_creation" id="btn_creation">Creation</td><td class="btn1_right"></td></tr></table></td>
                                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                    <tr><td class="btn1_left"></td><td class="btn1" name="btn_copy" id="btn_copy">Copy</td><td class="btn1_right"></td></tr></table></td>   
                                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                    <tr><td class="btn1_left"></td><td class="btn1" name="btn_regeneration" id="btn_regeneration">Regeneration</td><td class="btn1_right"></td></tr></table></td>
                                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                    <tr><td class="btn1_left"></td><td class="btn1" name="btn_import" id="">Import</td><td class="btn1_right"></td></tr></table></td>
                                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                    <tr><td class="btn1_left"></td><td class="btn1" name="btn_amend" id="btn_amend">Amend</td><td class="btn1_right"></td></tr></table></td>
                                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                    <tr><td class="btn1_left"></td><td class="btn1" name="btn_season_grp" id="btn_season_grp">Yield Group</td><td class="btn1_right"></td></tr></table></td>
                                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                    <tr><td class="btn1_left"></td><td class="btn1" name="btn_confirm" id="btn_confirm">Confirm</td><td class="btn1_right"></td></tr></table></td>
                            <!-- Repeat Pattern -->
                        </tr>
                    </table>
                    
            </td></tr>
        </table>
        <!-- TABLE '#D' : ( Button : Main ) (E) -->
        
        <!-- TABLE '#D' : ( Search Options ) (S) -->
        <table class="search">
        <tr><td class="bg">
        
                <!-- : ( Year ) (S) -->
                <table class="search_in" border="0">
                    <tr class="h23">
                        <td width="80"><img class="nostar">Trade</td>
                        <td width="120" style="padding-left:2" >
                            <script language="JavaScript">ComComboObject("trade", 2, 85, 0, 1);</script>
                        </td>
                        <td width="80"><img class="nostar">Season</td>
                        <td width="150" style="padding-left:2" >
                            <script language="JavaScript">ComComboObject("season", 2, 105, 0, 1);</script>
                        </td>
                        <td width="80"><img class="nostar">Version</td>
                        <td width="180" style="padding-left:2" >
                            <script language="JavaScript">ComComboObject("version", 5, 105, 0, 1);</script>
                        </td>
                        <td width="75"><img class="nostar">Status</td>
                        <td width="170">
                            <input type="text" id="sts" name="sts" value="" style="font-Weight:Bold" disabled></input>
                        </td>
                        <td width="44"></td>
                    </tr>
                    <tr class="h23">
                    <!--  
                        <td width="80"><img class="nostar">ACCT Class</td>
                        <td width="120" style="padding-left:2" >
                            <select name="acct_clss" style="width:47;"></select>
                        </td>
-->
                        <td width="80"><img class="nostar">ACCOUNT</td>
                        <td width="150" style="padding-left:2">
                            <script language="JavaScript">ComComboObject("acct_cd", 4, 105, 0, 0);</script>
                        </td>
                        <!--  
                        <td width="80"><img class="nostar">Type</td>
                        <td width="425" colspan="3">
                            <input type="radio" class="trans" name="view_type" value="H" checked> H/O
                            <input type="radio" class="trans" name="view_type" value="R"> RHQ
                            <input type="radio" class="trans" name="view_type" value="L"> L.OFC
                        </td>
                        -->
                                                  <input type="hidden"  name="view_type" value="R">  
                        
                        <td width="44"></td>
                    </tr>
                </table>
                <!-- : ( Year ) (E) -->
                
            </td></tr>
        </table>
        <!-- TABLE '#D' : ( Search Options ) (E) -->
        
        <table class="height_10"><tr><td></td></tr></table>
        
        <!-- TABLE '#D' : ( Search Options ) (S) -->
        <table class="search">
        <tr><td class="bg">
        
                <table width="100%" border="0">
                    <tr>
                        <td width="65%">
                            <table cellpadding="0" cellspacing="0">
                                <tr>
                                    <td>
                                        <table border='0'>
                                            <tr class="h23">
                                                <td width="230">
                                                    <table cellpadding="0" cellspacing="0">
                                                    <tr class="h23">
                                                        <td width="40">Unit</td>
                                                        <td width="60">
                                                            <select name="unit" style="width:50;"></select>
                                                        </td>
                                                        <td width="130">
                                                            <input type="checkbox" class="trans" name="incl_del" value="Y"> Delete Include
                                                        </td>
                                                    </tr>
                                                    </table>
                                                </td>
                                                <td width="500">
                                                <table border='0' cellpadding="0" cellspacing="0">
                                                    <!-- <tr><td width="230" align="left"><b>* A : Control &nbsp;, &nbsp;B : Protection &nbsp;</b></td></tr> -->
                                                    <tr><td width="100%"><div align="left"><b><label for="" id="ctrl_cd_desc"></label></b></div></td></tr>
                                                    <tr><td width="100%" align="left"><b>* PFMC/Load Guide &nbsp; : Weekly &nbsp;</b></td></tr>
                                                </table>
                                                </td>
                                            </tr>
                                        </table>
                                    </td>
                                </tr>
                            </table>
                        </td>
                        <td width="35%">
                            <table border="0" width="100%">
                                <tr><td class="btn2_bg" align="right">
                                        <div id="addDel" style="display:inline" >
                                        <table border="0" cellpadding="0" cellspacing="0">
                                            <tr>
                                                <!-- Repeat Pattern -->
                                                <td width="25%">
                                                <div id="subTrdAdd" style="display:inline" >
                                                <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                                <tr>
                                                    <td class="btn2_left"></td>
                                                    <td class="btn2" name="btn_sub_trd_add" id="btn_sub_trd_add">Sub Trade Add</td>
                                                    <td class="btn2_right"></td>
                                                </tr></table></div></td>
                                                <td width="35%"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                                <tr>
                                                    <td class="btn2_left"></td>
                                                    <td class="btn2" name="btn_ofc_lane_add" id="btn_ofc_lane_add">RHQ/OFC Add</td>
                                                    <td class="btn2_right"></td>
                                                </tr></table></td>
                                                <td width="40%">
                                                <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                                <tr>
                                                    <td class="btn2_left"></td>
                                                    <td class="btn2" name="btn_ofc_lane_del" id="btn_ofc_lane_del">Sub Trade/RHQ/OFC Delete</td>
                                                    <td class="btn2_right"></td>
                                                </tr></table>
                                                </td>
 
                                                <!-- Repeat Pattern -->
                                            </tr>
                                        </table>
                                        </div>
                                        <div id="reuse" style="display:none">
                                        <table border="0" cellpadding="0" cellspacing="0">
                                            <tr>
                                                <td width="50%"></td>
                                                <td width="50%"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                                <tr>
                                                    <td class="btn2_left"></td>
                                                    <td class="btn2" name="btn_reuse" id="btn_reuse">OFC/Lane Reuse</td>
                                                    <td class="btn2_right"></td>
                                                </tr></table></td>
                                            </tr>
                                        </table>
                                        </div>
                                </td></tr>
                                <tr><td class="btn2_bg" align="right">
                                        <div id="addDel2" style="display:inline" >
                                        <table border="0" cellpadding="0" cellspacing="0">
                                            <tr>
                                                <!-- Repeat Pattern -->
                                                 
 
                                                <td width="35%"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                                <tr>
                                                    <td class="btn2_left"></td>
                                                    <td class="btn2" name="btn_ofc_lane_add2" id="btn_ofc_lane_add2">Lane Add</td>
                                                    <td class="btn2_right"></td>
                                                </tr></table></td>
                                                <td width="40%">
                                                <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                                <tr>
                                                    <td class="btn2_left"></td>
                                                    <td class="btn2" name="btn_ofc_lane_del2" id="btn_ofc_lane_del2">Lane Delete</td>
                                                    <td class="btn2_right"></td>
                                                </tr></table>
                                                </td>
                                                <!-- Repeat Pattern -->
                                            </tr>
                                        </table>
                                        </div>                              
                                </td></tr>
                            </table>
                        </td>
                        <td align="right" id="sheetControlDiv" width="2%">
                            <img name="maxi" class="cursor" src="/hanjin/img/bu_next01.gif" sheetId="sheet1" type="N" onclick="toggleSheetSize();">
                        </td>
                    </tr>
                </table>
                
                <!-- : ( SHEET ) (S) -->
                <table width="100%" id="mainTable">
                    <tr><td>
                        <script language="javascript">ComSheetObject('sheet1');</script>
                    </td></tr>
                </table>
                <!-- : ( SHEET ) (E) -->
                
        </td></tr>
    </table>
    <!-- TABLE '#D' : ( Search Options ) (E) -->

</td></tr>
</table>
<!-- Outer Table (E)-->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>