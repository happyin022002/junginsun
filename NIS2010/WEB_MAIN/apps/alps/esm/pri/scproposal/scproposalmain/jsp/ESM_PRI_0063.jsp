<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_0063.jsp
*@FileTitle : TPW Group Commodity Guideline Select
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.22
*@LastModifier : 문동규
*@LastVersion : 1.0
* 2009.05.22 문동규
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
<%@ page import="com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.event.EsmPri0063Event"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RsltPriSgGrpCmdtVO"%>
<%@ page import="com.hanjin.syscommon.common.table.PriSpScpMnVO" %>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EsmPri0063Event  event = null;                  //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //서버에서 발생한 에러
    String strErrMsg = "";                      //에러메세지
    int rowCount     = 0;                       //DB ResultSet 리스트의 건수

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    
    String propNo = null;
    String amdtSeq = null;
    String svcScpCd = null;
    
    String svcScpNm = null;
    String effDt = null;
    String expDt = null;
    String prcCustTpCd = null;
    PriSpScpMnVO spVo = null;
    
    Logger log = Logger.getLogger("com.hanjin.apps.SCProposal.SCProposalMain");

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();


        event = (EsmPri0063Event)request.getAttribute("Event");
        
        RsltPriSgGrpCmdtVO vo = event.getRsltPriSgGrpCmdtVO();
        
        if (vo != null) {
            propNo   = vo.getPropNo();
            amdtSeq  = vo.getAmdtSeq();
            svcScpCd = vo.getSvcScpCd();
            prcCustTpCd = vo.getPrcCustTpCd();
            
            effDt = DateTime.getFormatDate(vo.getEffDt().replaceAll("-",""), "yyyyMMdd", "yyyy-MM-dd");
            expDt = DateTime.getFormatDate(vo.getExpDt().replaceAll("-",""), "yyyyMMdd", "yyyy-MM-dd");
        } else {
            propNo   = "";
            amdtSeq  = "";
            svcScpCd = "";
            prcCustTpCd = "";
            effDt = "";
            expDt = "";
        }
            
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        
        svcScpNm = (String)eventResponse.getCustomData("svcScpNm");
        //spVo = (PriSpScpMnVO)eventResponse.getCustomData("effDt");
        //prcCustTpCd = (String)eventResponse.getCustomData("prcCustTpCd");
        
        /*if (spVo != null) {
            effDt = DateTime.getFormatDate(spVo.getEffDt(), "yyyyMMdd", "yyyy-MM-dd");
            expDt = DateTime.getFormatDate(spVo.getExpDt(), "yyyyMMdd", "yyyy-MM-dd");
        } else {
            effDt = "";
            expDt = "";
        }*/

    }catch(Exception e) {
        out.println(e.toString());
    }
%>
<html>
<head>
<title>TPW Group Commodity Guideline Select</title>
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

<input type="hidden" name="prop_no"    value="<%=propNo   %>">
<input type="hidden" name="amdt_seq"   value="<%=amdtSeq  %>">
<input type="hidden" name="svc_scp_cd" value="<%=svcScpCd %>">

<input type="hidden" name="gline_seq">
<input type="hidden" name="grp_cmdt_seq">

<!--  20090821 이승준 추가-->
<input type="hidden" name="eff_dt" value="<%=request.getParameter("eff_dt")%>">
<!--<input type="hidden" name="prc_cust_tp_cd" value="<%=request.getParameter("prc_cust_tp_cd")%>">-->


<!-- 개발자 작업 -->

<!-- OUTER - POPUP (S)tart -->
<table width="400" class="popup" cellpadding="10" border="0">
<tr><td class="top"></td></tr>
<tr><td valign="top">

        <!-- : ( Title ) (S) -->
        <table width="100%" border="0">
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp; TPW Group Commodity Guideline Select </td></tr>
        </table>
        <!-- : ( Title ) (E) -->

        <!-- : ( Search Options ) (S) -->

            <table class="search">
            <tr><td class="bg">
                <table class="search" border="0" style="width:750;">
                <tr class="h23">
                    <td width="11%">SVC Scope.</td>
                    <!-- <td width="30%"><input type="text" style="width:170;" class="input2" value="<%=svcScpNm %>" readonly="readonly"></td> -->
                    <td width="31%"><input type="text" style="width:200;" class="input2" value="<%=svcScpNm %>" readonly="readonly"></td>
                    <td width="13%">Effective Date </td>
                    <td width="27%"><input type="text" style="width:70;" class="input2" value="<%=effDt %>" readonly="readonly">&nbsp;~&nbsp;<input type="text" style="width:70;" class="input2" value="<%=expDt %>" readonly="readonly"></td>
                    <td width="14%">Customer Type </td>
                    <td width=""><input type="text" name="prc_cust_tp_cd" style="width:20;text-align:center;" class="input2" value="<%=prcCustTpCd %>" readonly="readonly" ></td>
                </tr>
                </table>

<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
    <table class="search"  border="0" >
            <td width="350">
                <table width="100%"  id="mainTable">
                    <tr>
                        <td width="100%">
                            <script language="javascript">ComSheetObject('sheet1');</script>
                        </td>
                    </tr>
                </table>

                <table width="100%" class="button">
                    <tr><td class="btn2_bg">
                    <table border="0" cellpadding="0" cellspacing="0">
                        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                        <tr><td class="btn2_left"></td>
                        <td class="btn2" name="btn_Retrieve">Retrieve</td>
                        <td class="btn2_right"></td>
                        </tr>
                        </table></td>
                </table>
        </td></tr>
        </table>
        </td>

        <td width="" align="center"><img src="img/btn_add.gif" width="26" height="26" alt="" border="0" align="absmiddle">&nbsp;</td>

        <td width="350" >
                <table width="100%"  id="mainTable">
                    <tr>
                        <td width="100%">
                            <script language="javascript">ComSheetObject('sheet2');</script>
                        </td>
                    </tr>
                </table>

            <table width="100%" class="button">
            <tr><td class="btn2_bg">
                <table border="0" cellpadding="0" cellspacing="0">
                        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                        <tr><td class="btn2_left"></td>
                        <td class="btn2" name="btn_CheckAll">Check All</td>
                        <td class="btn2_right"></td>
                        </tr>
                        </table></td>
                        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                        <tr><td class="btn2_left"></td>
                        <td class="btn2" name="btn_UncheckAll">Uncheck All</td>
                        <td class="btn2_right"></td>
                        </tr>
                        </table></td>

                        <!-- <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                        <tr><td class="btn2_left"></td>
                        <td class="btn2" name="btn_Map"><a href="javascript:viewHashMap();">View Map</a></td>
                        <td class="btn2_right"></td>
                        </tr>
                        </table></td> -->


                </table>
            </td></tr>
            </table>

            </td>





                        <!-- Grid (E) -->
            </table>
            </td></tr>
            </table>
                <!-- : ( Button : Grid ) (S) -->
                <!--  Button_Sub (S) -->

            <!-- Button_Sub (E) -->
            <!-- : ( Button : Grid ) (E) -->

            </td></tr>
        </table>
<!-- : ( Search Options ) (E) -->

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
                    <td class="btn1" name="btn_OK">OK</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
                <td class="btn1_line"></td>
                <td width="72"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_Close">Close</td>
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
<!-- : ( Button : pop ) (E) -->


<!-- 개발자 작업  끝 -->
</form>
</body>
</html>