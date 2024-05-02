<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_4008.jsp
*@FileTitle : Surcharge Commodity Group Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.08
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.05.08 이승준
* 1.0 Creation
=========================================================
* History
* 2015.06.19 전지예 [CHM-201536236] Non-Cargo NOS 체크박스 삽입
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.surcharge.surchargegroupcommodity.event.EsmPri4008Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EsmPri4008Event  event = null;                  //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //서버에서 발생한 에러
    String strErrMsg = "";                      //에러메세지
    int rowCount     = 0;                       //DB ResultSet 리스트의 건수

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    Logger log = Logger.getLogger("com.hanjin.apps.Surcharge.CommonGroupCommodity");

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();

        event = (EsmPri4008Event)request.getAttribute("Event");
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
<title>Surcharge Commodity Group Creation</title>
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
<input type="hidden" name="scg_grp_cmdt_seq" value="">
<input name="cd" type="hidden" value="">
<input type="hidden" name="max_seq" value="0">
<input type="hidden" name="chg_cd" value="GRI" />
<!-- 개발자 작업    -->

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">

    <tr><td valign="top">
    <!--Page Title, Historical (S)-->
    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
        <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
    </table>
    <!--Page Title, Historical (E)-->

    <!--biz page (S)-->
        <table class="search">
        <tr><td class="bg">
                <!--  biz_1  (S) -->
                <table class="search" border="0" style="width:979;">
                <tr class="h23">
                    <td width="90">Service Scope</td>
                    <td width=""><script language="javascript">ComComboObject('svc_scp_cd', 2, 50, 0, 1, 0, true);</script>
                        &nbsp;<input name="svc_scp_nm" type="text" style="width:200;"  value="" class="input2" readonly></td>
                </tr>
                </table>
                <!--  biz_1   (E) -->

                <!-- Hidden sheet for Transaction (S) -->
                <script language="javascript">ComSheetObject('sheet0');</script>
                <!-- Hidden sheet for Transaction (E) -->

                <!--  biz_2  (S) -->
        <table class="search">
        <tr><td class="" width="35%">
                <!-- Grid  (S) -->
                            <table width="100%"  id="mainTable">
                                <tr>
                                    <td width="100%">
                                        <script language="javascript">ComSheetObject('sheet1');</script>
                                    </td>
                                </tr>
                            </table>

                            <!--Button (S) -->
                <table width="100%" class="button">
            <tr><td class="btn2_bg">
                <table border="0" cellpadding="0" cellspacing="0">
                <tr>
                        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                        <tr><td class="btn2_left"></td>
                        <td class="btn2" name="btn_add">Row&nbsp;Add</td>
                        <td class="btn2_right"></td>
                        </tr>
                        </table></td>
                        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                        <tr><td class="btn2_left"></td>
                        <td class="btn2" name="btn_del">Delete</td>
                        <td class="btn2_right"></td>
                        </tr>
                        </table></td>
                </tr>
                </table>
            </td></tr>
            </table>
            <!--Button (S) -->

            </td>
            <td class="" width="2%"></td>
            <td class="" width="60%">
                            <table width="100%"  id="mainTable">
                                <tr>
                                    <td width="100%">
                                        <script language="javascript">ComSheetObject('sheet2');</script>
                                    </td>
                                </tr>
                            </table>

                <!--Button (S) -->
                <table width="100%" class="button">
            <tr><td class="btn2_bg">
                <table border="0" cellpadding="0" cellspacing="0">
                <tr>
                        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                        <tr><td class="btn2_left"></td>
                        <td class="btn2" name="btn_add2">Row&nbsp;Add</td>
                        <td class="btn2_right"></td>
                        </tr>
                        </table></td>
                        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                        <tr><td class="btn2_left"></td>
                        <td class="btn2" name="btn_del2">Delete</td>
                        <td class="btn2_right"></td>
                        </tr>
                        </table></td>
                        <td width=""><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                        <tr><td class="btn2_left"></td>
                        <td class="btn2" name="btn_downexcel">Down Excel</td>
                        <td class="btn2_right"></td>
                        </tr>
                        </table></td>
                </tr>
                </table>
            </td></tr>
            </table>
            <!--Button (S) -->

                        <!-- Grid (E) -->
                        </td>
                    </tr>
                </table>

                <!--  biz_2   (E) -->
                </td></tr>
            </table>

    <!--biz page (E)-->

    <!--Button (S) -->
        <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
        <tr><td class="btn1_bg">
            <table border="0" cellpadding="0" cellspacing="0">
            <tr>
            	<td><table width="100%" class="search" style="width:789; border: 0;" id="notice">
	            	<tr class="h23"><td style="color: blue;">Notice: If you want to amend Non-Cargo NOS checkbox in TPW and ACW, <br>please submit SR to use above [IT Support].</td>
	            	</tr>
	            </table></td>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
                    <td class="btn1_right"></td></tr>
                </table></td>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_new">New</td>
                    <td class="btn1_right"></td></tr>
                </table></td>
                <td class="btn1_line"></td>
                <td><table width="99%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_save">Save</td>
                    <td class="btn1_right"></td></tr>
                </table></td>
                </tr>
            </table>

    <!--Button (E) -->
</td></tr>
        </table>

</td></tr>
        </table>
<div id="hiddenSheetLayer" style="display:none">
<script language="javascript">ComSheetObject('sheet3');</script>
</div>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>