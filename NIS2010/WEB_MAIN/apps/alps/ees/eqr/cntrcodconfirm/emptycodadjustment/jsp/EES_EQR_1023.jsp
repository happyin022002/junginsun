<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_EQR_1023.jsp
*@FileTitle : MTY Repo Inquiry by Period
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.12
*@LastModifier : 문중철
*@LastVersion : 1.0
* 2009.08.12 문중철
* 1.0 Creation
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.eqr.cntrcodconfirm.emptycodadjustment.event.EesEqr1023Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesEqr1023Event  event = null;                  //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //서버에서 발생한 에러
    String strErrMsg = "";                      //에러메세지
    int rowCount     = 0;                       //DB ResultSet 리스트의 건수

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
	String strCnt_cd		= "";
//emptycodadjustment    Logger log = Logger.getLogger("com.hanjin.apps.cntrcodconfirm.emptycodadjustment");

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
		strCnt_cd = account.getCnt_cd();


        event = (EesEqr1023Event)request.getAttribute("Event");
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
<title>MTY Repo Inquiry by Period</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            showErrMessage(errMessage);
        } // end if
        loadPage();
        //document.form.froms.focus();      
    }
</script>
</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="period" value="M">
<input type="hidden" name="inquiryLevel">
<input type="hidden" name="rpt_fromdate">
<input type="hidden" name="rpt_enddate">
<input type="hidden" name="rpt_location">
<input type="hidden" name="rpt_inpuirylevel">
<input type="hidden" name="rpt_div">
<input type="hidden" name="rpt_tpsz">
<input type="hidden" name="rpt_tpszlist">
<input type="hidden" name="prelocation">
<input type="hidden" name="rpt_cnt_cd"  value="<%=strCnt_cd%>" >
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
                    <td class="btn1" name="btn_downExcel">Down Excel</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
                <td class="btn1_line"></td>
                
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_print">Print</td>
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
        <tr><td class="bg">
                <!--  biz_1  (S) -->
                <table class="search" border="0" style="width:979;"> 
                <tr class="h23">
                    <td width="55">&nbsp;&nbsp;Period</td>
                    <td width="235" class="stm">
                        <input type="text" style="width:75;" class="input1" value="" name="fromdate" required dataformat="ymd" maxlength="8">
                        &nbsp;~&nbsp;
                        <input type="text" style="width:75;" class="input1" value="" name="enddate"  required dataformat="ymd" maxlength="8">&nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendarto"  id="btns_calendarfm" >
                    </td>
                     <td width="250">
                        <table class="search_sm2" border="0" style="width:230;"> 
                            <tr class="h23">
                                <td width="" class="stm">
                                    <input type="radio" value="R" name="inquirylevel" class="trans" checked>&nbsp;RCC&nbsp;
                                    <input type="radio" value="L" name="inquirylevel" class="trans"        >&nbsp;LCC&nbsp;
                                    <input type="radio" value="E" name="inquirylevel" class="trans"        >&nbsp;ECC&nbsp;
                                    <input type="radio" value="S" name="inquirylevel" class="trans"        >&nbsp;SCC
                                </td>
                            </tr>
                        </table>
                    </td>
                    <td width="54">Location</td>
                    <td width="80">
                        <input type="text" style="width:50;" class="input1" value="" dataformat="engup" style="ime-mode:disabled" name="location" maxlength="5">
                    </td>
                   
                    <td width="60">Company</td>
                    <td><input type="text" style="width:35" class="input" value="SML" readonly></td>
                 </tr> 
                 </table>
                 <table class="search" border="0" style="width:979;"> 
                 <tr class="h23">
                    <td width="290" >
                        <table class="search_sm2" border="0" style="width:260;"> 
                            <tr class="h23">
                                <td width="45">&nbsp;Option</td>
                                <td width="" class="stm">
                                    <input type="radio" value="A" name="div" class="trans"        >&nbsp;ALL&nbsp;
                                    <input type="radio" value="L" name="div" class="trans"        >&nbsp;Loading&nbsp;
                                    <input type="radio" value="D" name="div" class="trans" checked>&nbsp;Discharging
                                </td>
                            </tr>
                        </table>
                    </td>
                    <td width="50">TP/SZ</td>
                    <td width="" style="padding-left:2">
                        <select style="width:65;" class="input" name="tpsz">
                            <option value="A" selected>ALL   </option>
                            <option value="D"         >DRY   </option>
                            <option value="S"         >SPCL  </option>
                            <option value="R"         >Reefer</option>
                        </select>&nbsp;<input type="text" style="width:233;" class="input" value="" name="tpszlist" readonly>
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
            
            <!-- Button_Sub (E) -->
            
            
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



<!-- 개발자 작업  끝 -->
</form>
</body>
</html>