<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_EQR_1024.jsp
*@FileTitle : MTY COD Confirmation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.01
*@LastModifier : 문중철
*@LastVersion : 1.0
* 2009.07.01 문중철
* 1.0 Creation
* History
* 2011.05.03 나상보 [CHM-201110558-01] [EQR] MTY COD Confirmation의 Created by 컬럼 수정 요청
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.eqr.cntrcodconfirm.emptycodadjustment.event.EesEqr1024Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesEqr1024Event  event = null;                  //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //서버에서 발생한 에러
    String strErrMsg = "";                      //에러메세지
    int rowCount     = 0;                       //DB ResultSet 리스트의 건수

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
//    Logger log = Logger.getLogger("com.hanjin.apps.cntrcodconfirm.emptycodadjustment");

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();


        event = (EesEqr1024Event)request.getAttribute("Event");
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
<title>MTY COD Confirmation</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            ComShowMessage(errMessage);
        } // end if
        loadPage();
    }
    
    function test(){
        alert("33");
    }
</script>

</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="editRow">
<input type="hidden" name="editPort">
<input type="hidden" name="editIbFlag">
<input type="hidden" name="sh2RC">
<input type="hidden" name="n1stEtb">
<input type="hidden" name="yardcode">
<input type="hidden" name="session_user_id" value="<%= strUsr_id %>">
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
            <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
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
                    <td class="btn1" name="btn_save">Save</td>
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
    <!--biz page (S)-->
        <table class="search"> 
        <tr><td style="padding:5px; background-color:#F3F2F8; border:1px solid #A3A4C7;">
                <!--  biz_1  (S) -->
                <table class="search" border="0" style="width:979;"> 
                <tr class="h23">
                    <td width="35">VVD</td>
                    <td width="160">
                        <input type="text" name="vvd" style="width:80;ime-mode:disabled" class="input1" value="" dataformat="engup" maxlength="9">&nbsp;<img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_vvd">
                    </td>
                    <td width="35">Lane</td>
                    <td width="100">
                        <input type="text" name="lane" style="width:35;" class="input2" value=""  readonly>
                    </td>
                    <td width="25">Bay</td>
                    <td width="100">
                        <input type="text" name="bay" style="width:45;" class="input2" value="" readonly>
                    </td>
                    <td width="55">Version</td>
                    <td width="60">
                        <input type="text" name="version" style="width:25;" class="input2" value="" readonly>
                    </td>
                    <td width="260">&nbsp;</td>
                    <td width="12%">Update By / DT</td>
                    <td width="18%">
                        <input type="text" style="width:84" name="userid" value="<%= strUsr_id %>" class="input2" readOnly> / <input type="text" name="date" class="input2" style="width:70" value="" readOnly>
                    </td>
                    </tr> 
                
                </table>
                <!--  biz_1   (E) -->
                
                </td></tr>
            </table>
            
            <table class="height_10"><tr><td colspan="8"></td></tr></table>
        <!-- Tab (S) -->
        
        <!-- Tab (E) -->
        <!-- Tab BG Box  (S) -->
        <table class="search"> 
        <tr><td class="bg">
                                                                    
                <!-- Grid  (S) -->
                <table width="100%"  id="mainTable"> 
                    <tr>
                        <td width="100%">
                            <script language="javascript">ComSheetObject('sheet1');</script>
                        </td>
                    </tr>
                </table> 
            <!-- Grid (E) -->
            <!--  Button_Sub (S) -->
            <table width="100%" class="button"> 
            <tr><td class="btn2_bg">
                <table border="0" cellpadding="0" cellspacing="0"><tr>
                        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                        <tr><td class="btn2_left"></td>
                        <td class="btn2" name="btn_remove">Confirmation Delete </td>
                        <td class="btn2_right"></td>
                        </tr>
                        </table></td>
                        
                    </tr></table>
            </td></tr>
            </table>

            <!-- Button_Sub (E) -->
                <table class="height_10"><tr><td colspan="8"></td></tr></table>
            <!-- Grid  (S) -->
                <table width="100%"  id="mainTable"> 
                    <tr>
                        <td width="100%">
                            <script language="javascript">ComSheetObject('sheet2');</script>
                        </td>
                    </tr>
                </table> 
                
            <!-- Grid (E) -->
            <!--  Button_Sub (S) -->
            <table width="100%" class="button"> 
            <tr><td class="btn2_bg">
                <table border="0" cellpadding="0" cellspacing="0"><tr>
                        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                        <tr><td class="btn2_left"></td>
                        <td class="btn2" name="btn_rowadd"> Row Add</td>
                        <td class="btn2_right"></td>
                        </tr>
                        </table></td>
                        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                        <tr><td class="btn2_left"></td>
                        <td class="btn2" name="btn_delete">Row Delete</td>
                        <td class="btn2_right"></td>
                        </tr>
                        </table></td>
                    </tr></table>
            </td></tr>
            </table>

            <!-- Button_Sub (E) -->
            
            <table class="height_10"><tr><td colspan="8"></td></tr></table>
            <!-- Grid  (S) -->
                <table width="100%"  id="mainTable"> 
                    <tr>
                        <td width="100%">
                            <script language="javascript">ComSheetObject('sheet3');</script>
                        </td>
                    </tr>
                    
                </table> 
            <!-- Grid (E) -->
            <!--  Button_Sub (S) -->
            <table width="100%" class="button"> 
            <tr><td class="btn2_bg">
                <table border="0" cellpadding="0" cellspacing="0"><tr>
                        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                        <tr><td class="btn2_left"></td>
                        <td class="btn2" name="btn_rowadd2"> Row Add</td>
                        <td class="btn2_right"></td>
                        </tr>
                        </table></td>
                        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                        <tr><td class="btn2_left"></td>
                        <td class="btn2" name="btn_delete2">Row Delete</td>
                        <td class="btn2_right"></td>
                        </tr>
                        </table></td>
                    </tr></table>
            </td></tr>
            </table>

            <!-- Button_Sub (E) -->
            <table class="height_10"><tr><td colspan="8"></td></tr></table>
            <table width="100%" class="grid2"> 
            <tr class="tr2_head">
                <td width="15%">Remark(s)</td>         
                <td width=""><textarea  rows="2" name="remark" style="width:100%">
</textarea></td></tr>
                </table> 
            <!--  Button_Sub (S) -->
            <table width="100%" class="button"> 
            <tr><td class="btn2_bg">
                <table border="0" cellpadding="0" cellspacing="0"><tr>
                        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                        <tr><td class="btn2_left"></td>
                        <td class="btn2" name="HRBTN"><span id="HRTEXT" style="CURSOR: hand;width:60px;text-align:left" onclick="javascript:popHRBTN();"></span></td>
                        <td class="btn2_right"></td>
                        </tr>
                        </table></td>
                        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                        <tr><td class="btn2_left"></td>
                        <td class="btn2" name="RMBTN"><span id="RMTEXT" style="CURSOR: hand;width:100px;text-align:left" onclick="javascript:popRMBTN();"></span></td>
                        <td class="btn2_right"></td>
                        </tr>
                        </table></td>
                        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                        <tr><td class="btn2_left"></td>
                        <td class="btn2" name="DMBTN"><span id="DMTEXT" style="CURSOR: hand;width:70px;text-align:left" onclick="javascript:popDMBTN();"></span></td>
                        <td class="btn2_right"></td>
                        </tr>
                        </table></td>
                    </tr></table>
            
</td></tr>
            </table>
            <!-- Button_Sub (E) -->
            </td></tr>
            </table>
            
            </td></tr>
            </table>
            <!--  Grid_button (S) -->
            </td></tr>
        </table>
    <!-- Tab BG Box  (S) -->
    <!--biz page (E)-->
    <!--Button (S) -->
        
    <!--Button (E) -->
    
<table class="height_10"><tr><td colspan="8"></td></tr></table>
    </td></tr>
</table>

<!-- Copyright (S) -->
<!-- Copyright(E)-->

</form>
</body>
</html>