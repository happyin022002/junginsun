<%/*=========================================================
     *Copyright(c) 2009 CyberLogitec
     *@FileName : cps_gem_0009.jsp
     *@FileTitle : [CPS_GEM-0009] Foreign Exchange Rate Maintenance
     *Open Issues :
     *Change history :
     *@LastModifyDate : 2009.04.21
     *@LastModifier : 진윤오
     *@LastVersion : 1.0
     * 2009.04.17 진윤오
     * 1.0 Creation
     =========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@page import="com.hanjin.apps.alps.cps.gem.gemcommon.gemmastercodemgt.event.CpsGem0009Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
	CpsGem0009Event event = null; //PDTO(Data Transfer Object including Parameters)
    Exception serverException = null; //서버에서 발생한 에러
    String strErrMsg = ""; //에러메세지
    int rowCount = 0; //DB ResultSet 리스트의 건수

    String successFlag = "";
    String codeList = "";
    String pageRows = "100";

    String strUsr_id = "";
    String strUsr_nm = "";
    Logger log = Logger.getLogger("com.hanjin.apps.GEMCommon.GEMMasterCodeMgt");

    try
    {
        SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();

        event = (CpsGem0009Event) request.getAttribute("Event");
        serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null)
        {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

    }
    catch (Exception e)
    {
        out.println(e.toString());
    }
%>

<html>
<head>
<title>Foreign Exchange Rate Maintenance</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(year){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		
		loadPage(year);
	}
</script>
</head>

<body onLoad="setupPage('<%=DateTime.getYear()%>');">
<form name="form">
<input type="hidden" name="f_cmd"> 
<input type="hidden" name="pagerows"> 
<!-- 개발자 작업 -->

<input type="hidden" name="inCurrCd">
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
                
                
                <table class="search" border="0">
                    <tr class="h23">
                        <td width="485" valign="top">
                            <table class="search" border="0">
                                    <tr><td class="title_h"></td>
                                        <td class="title_s">Initial Exchange Rate</td></tr>
                                </table>
                            <table class="search_sm" width="485" height="490" border="0">
                                <tr class="h23"><td vlaign="top">
                                
                                
                                <table class="search" border="0">
                                    <tr class="h23">
                                    <td width="60">This Year</td>
                                    <td width=""><input type="text" name="acct_xch_rt_yrmon" style="width:50;text-align:center;ime-mode:disabled" class="input1"  value=""  maxlength="4"  fulfill required minnum="1900" maxnum="2050" caption="This Year">&nbsp;<img class="cursor" src="img/btns_calendar.gif" name="btns_calendar" width="19" height="20" border="0" align="absmiddle"></td>
                                    </tr>
                                </table>
                                <table class="search" border="0">
                                    <tr class="h23">
                                    <td width="110">USD : KRW &ndash;&gt; 1 : </td>
                                    <td width="250"><input type="text" name="usd_krw_xch_rt" style="width:80;" style="text-align:right;ime-mode:disabled"  dataformat="float" maxlength="11" minnum="0"  maxnum="999999.9999"  required pointcount="4" caption="USD : KRW" class="input1" value=""></td>                    
                                    <td width="">Deleted  Data<input name="delt_flg" type="checkbox" value="Y" class="trans"></td>
                                    </tr>
                                </table>
                                
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
                        <td class="btn2" name="btn2_Row">Row&nbsp;Add</td>
                        <td class="btn2_right"></td>
                        </tr>
                        </table></td>
                        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                        <tr><td class="btn2_left"></td>
                        <td class="btn2" name="btn2_Delete">Row&nbsp;Delete</td>
                        <td class="btn2_right"></td>
                        </tr>
                        </table></td>
                        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                        <tr><td class="btn2_left"></td>
                        <td class="btn2" name="btn2_Excel">Excel Upload</td>
                        <td class="btn2_right"></td>
                        </tr>
                        </table></td>
                    </tr></table>
            </td></tr>
            </table>
            <!-- Button_Sub (E) -->
                                </td>
                            </tr>
                        </table> 
                        
                        </td>
                        <td width="9">&nbsp;</td>
                        <td width="485" valign="top">
                            <table class="search" border="0">
                                    <tr><td class="title_h"></td>
                                        <td class="title_s">Monthly Exchange Rate</td></tr>
                                </table>
                            <table width="485" border="0" class="search_sm" height="490">
                                <tr class="h23"><td vlaign="top">
                                
                               
                                
                                <table class="search" border="0">
                                    <tr class="h23">
                                    <td width="55">Currency</td>
                                    <td width="100"><input type="text" name="month_curr_cd" readonly="readonly" style="width:50;text-align:center;" class="input"></td>
                                    <td align="right">Monthly Exchange Rate I/F&nbsp;<img src="img/btns_search.gif" name="btns_popup" width="19" height="20" alt="" border="0" align="absmiddle" style="cursor:pointer;cursor:hand"></td>
                                    </tr>
                                </table>
                        <!-- Grid  (S) -->
                            <table width="100%"  id="mainTable"> 
                                <tr>
                                    <td width="100%">
                                        <script language="javascript">ComSheetObject('sheet2');</script>
                                    </td>
                                </tr>
                            </table>
                            <!-- Grid (E) -->
                            </td>
                            </tr>
                        </table> 
                            
                        </td>
                    </tr>
                </table>
                
                
                
                
            <!--  biz_1   (E) -->
            
            
            
            
            
            </td></tr>
        </table>
    <!-- Grid BG Box  (S) -->
    <!--Button (S) -->
        <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
        <tr><td class="btn1_bg">
            <table border="0" cellpadding="0" cellspacing="0">
            <tr>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn1_Retrieve">Retrieve</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
                <td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn1_New">New</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
                <td class="btn1_line"></td>
                <td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn1_Save">Save</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn1_Excel">Down Excel</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
            </tr>
            </table>
        </td></tr>
        </table>
    <!--Button (E) -->
    <!--biz page (E)-->
    
    </td>
    
    </tr>
    </table>

 
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>