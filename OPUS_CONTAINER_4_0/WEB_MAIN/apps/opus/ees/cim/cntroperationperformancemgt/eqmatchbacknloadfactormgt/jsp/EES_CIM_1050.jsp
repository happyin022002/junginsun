<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_cim_1050.jsp
*@FileTitle : Match-back by Vessel
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion :
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.event.EesCim1050Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EesCim1050Event  event = null;                  //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //error from server
    String strErrMsg = "";                      //error message
    int rowCount     = 0;                       //count of DB resultSET list

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
	String strCnt_cd		= "";
    Logger log = Logger.getLogger("com.clt.apps.CNTROperatioNPerformanceMgt.EQMatchBackNLoadFactorMgt");

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
		strCnt_cd = account.getCnt_cd();


        event = (EesCim1050Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

     	// adding logic to get data from server when first loading
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

    }catch(Exception e) {
        out.println(e.toString());
    }
%>
<html>
<head>
<title>Load Factor by Trade</title>
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
<input type="hidden" name="backendjob_key">

<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- developer job -->
<input type="hidden" name="period" value="M">

<!-- Report Start -->
<input type="hidden" name="rpt_fromdate">
<input type="hidden" name="rpt_todate"  >
<input type="hidden" name="rpt_trade"   >
<input type="hidden" name="rpt_lane"    >
<input type="hidden" name="rpt_vvd"     >
<input type="hidden" name="rpt_company" >
<input type="hidden" name="rpt_lfinfo" >
<input type="hidden" name="rpt_cnt_cd"  value="<%=strCnt_cd%>" >
<!-- Report End -->

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
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
                    <td class="btn1" name="btn_Retrieve"  id="btn_Retrieve">Retrieve</td>
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
                    <td class="btn1" name="btn_downexcel">Down Excel</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
                <td class="btn1_line"></td>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_Print">Print</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
            </tr>
            </table>
        </td></tr>
        </table>
        <!--Button (E) -->
    
        <!--biz page (S)-->
        <table class="search" id="mainTable"> 
            <tr><td class="bg">
                <!--  biz_1  (S) -->
                <table class="search" border="0" style="width:979;"> 
                <tr class="h23">
                    <td width="55">&nbsp;Period</td>
                    <td width="240">&nbsp;
                        <input type="text" style="width:70;" class="input1" value="" name="fromdate" required dataformat="ymd" maxlength="8">&nbsp;~&nbsp;
                        <input type="text" style="width:70;" class="input1" value="" name="todate"   required dataformat="ymd" maxlength="8">&nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendarto"  id="btns_calendarfm" >
                    </td>
                    <td width="40">Trade <input type="text" style="width:0" name="prepolnext"></td>
                    <td width="70"><script language="javascript" >ComComboObject('trade', 2, 50, 0,0,0,true);</script><input type="text" style="width:0" name="polnext">
                    <!-- 
                    <select style="width:60;" class="input" name="trade">
                        <option value="AL" selected>   </option>
                        <option value="MM"         >M  </option>
                        <option value="EE"         >E  </option>
                        <option value="TP"         >TPS</option>
                        <option value="TE"         >AES</option>
                        <option value="TA"         >TAS</option>
                    </select>
                    //-->
                    </td>
                    <td width="35">Lane</td>    
                    <td width="70">
                    <script language="javascript" >ComComboObject('lane', 2, 50, 0,0,0,true);</script><input type="text" style="width:0" name="lanenext">
                    <!--
                    <input type="text" style="width:40;" class="input" value="" name="lane" dataformat="engup" style="ime-mode:disabled" maxLength ="3">&nbsp;
                    <img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_lane">
                    //-->
                    </td>
                    <td width="30">VVD</td> 
                    <td width="">
                    <script language="javascript">ComComboObject('vvd', 1, 100, 0,0,0,true);</script>
                    <input type="text" style="width:0;height:0;" class="input" value="" name="chgFocus01" dataformat="ymd">
                    <input type="text" style="width:0;height:0;" class="input" value="" name="chgFocus02" dataformat="ymd">                    
                    <!-- <input type="text" style="width:85;" class="input" value="" name="vvd" dataformat="engup" style="ime-mode:disabled" maxLength ="9">&nbsp; //-->
                    <!-- <input type="text" style="width:22;" class="input" value=" "> //-->
                    <!-- &nbsp;<img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_vvd"> //-->
                    </td>
                    </tr> 
                </table>
                <table border="0" style="width:73%;"> 
                <TR>
                	<td>
		                <table class="search_sm2" border="0" style="width:490;"> 
		                <tr class="h23">
		                    <td width="66">Company</td>
		                    <td width="" class="stm">
		                    <div id="div_company"></div>
		                    </td>
		                </tr>
						</table>
					</td>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td>
		                <table class="search_sm2" border="0" style="width:230;"> 
		                <tr class="h23">
		                    <td width="60">L/F Info</td>
		                    <td width="" class="stm">
		                    <input type="radio" value="E" class="trans"  checked name="lfinfo">&nbsp;Exclude&nbsp;&nbsp;&nbsp;
		                    <input type="radio" value="I" class="trans" name="lfinfo">&nbsp;&nbsp;Include</td>
		                </tr>
						</table>
						
					</td>
				</TR>
                 </table>    
                
                <!--  biz_1   (E) -->
        </td></tr></table>
        <table class="height_8"><tr><td></td></tr></table>  
        
        <!-- Tab (S) -->
        
        <!-- Tab (E) -->
        
        <table class="search" id="mainTable"> 
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
            
                        
            </td></tr>
        </table>
        <!--biz page (E)-->

    
    
    </td></tr>
        </table>
</form>
</body>
</html>
