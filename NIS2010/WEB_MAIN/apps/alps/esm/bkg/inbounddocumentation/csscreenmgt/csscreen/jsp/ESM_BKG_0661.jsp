<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESK_BKG_0661.jsp
*@FileTitle : Awkward Dimension Detail(s) Pop-up
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.28
*@LastModifier : 박미옥
*@LastVersion : 1.0
* 2009.04.28 박미옥
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.event.EsmBkg0661Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0661Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

    // Param : bl_no, bl_tp_cd, bkg_no, bkg_split_no, cntr_no  
	String blNo       = "";
    String blTpCd     = "";
	String bkgNo      = "";
	String cntrNo     = "";
    String blTpCdClass = "input2";
	
	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.CsScreenMgt.CsScreen");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();	   
	   
		event = (EsmBkg0661Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
        if(event != null) {       		
            blNo       = event.getBlNo();
            blTpCd     = event.getBlTpCd();
            bkgNo      = event.getBkgNo();
            cntrNo     = event.getCntrNo();

		    if ("W".equals(blTpCd) || "S".equals(blTpCd)) {
		        blTpCdClass = "input2_1";
		    }
        }
		
	} catch(Exception e) {
		out.println(e.toString());
	}	
%>
<html>
<head>
<title>Awkward Dimension Detail(s) Pop-up</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            showErrMessage(errMessage);
        } // end if
            
        with(document.form){
            eval("bl_no").value        = "<%=blNo%>";
            eval("bl_tp_cd").value     = "<%=blTpCd%>";
            eval("bkg_no").value       = "<%=bkgNo%>";
            eval("cntr_no").value      = "<%=cntrNo%>";
            
            eval("bl_tp_cd").className = "<%=blTpCdClass%>";
        }
            
        loadPage();
    }
</script>
</head>

<body class="popup_bg" onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->

<input type="hidden" name="bkg_no"       required="" caption="Booking No." />
<input type="hidden" name="cntr_no"      caption="Container No."/>

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
    <tr><td class="top"></td></tr>
    <tr>
        <td valign="top">
        
            <!-- : ( Title ) (S) -->
            <table width="100%" border="0">
                <tr>
                    <td class="title">
                        <img src="img/icon_title_dot.gif" align="absmiddle" />&nbsp;Awkward Dimension&nbsp;Detail(s)
                    </td>
                </tr>
            </table>
            <!-- : ( Title ) (E) -->
            
            <!-- : ( Search Options ) (S) -->                
            <table class="search"> 
                <tr>
                    <td class="bg">
                        <table class="search" border="0">
                            <tr class="h23">
                                <td width="60">B/L No.</td>
                                <td>
                                    <input type="text" style="width:98;" class="input2" name="bl_no"    required="" caption="B/L No."  readonly="readonly" />&nbsp;
                                    <input type="text" style="width:18;" class="input2" name="bl_tp_cd" caption="B/L Type" readonly="readonly" />
                                </td>
                            </tr>
                        </table>
                                
                        <!-- : ( Grid ) (S) -->
                        <table width="100%"  id="mainTable"> 
                            <tr>
                                <td width="100%">
                                    <script language="javascript">ComSheetObject('sheet1');</script>
                                </td>
                            </tr>
                        </table> 
                        <!-- : ( Grid ) (E) --> 
                        
                    </td>
                </tr>
            </table>
            <!-- : ( Search Options ) (E) -->
            <table class="height_5"><tr><td></td></tr></table>
        </td>
    </tr>
</table> 


        
        
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
    <tr>
        <td height="71" class="popup">        
            <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
                <tr>
                    <td class="btn3_bg">
                        <table border="0" cellpadding="0" cellspacing="0">
                            <tr>
                                <td>
                                    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                        <tr>
                                            <td class="btn1_left"></td>
                                            <td class="btn1" name="btn_close">Close</td>
                                            <td class="btn1_right"></td>
                                        </tr>
                                    </table>
                                </td>
                            </tr>
                        </table>
                    </td>
                </tr>
            </table>
        </td>
    </tr>
</table>       
<!-- : ( Button : pop ) (E) -->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>
<%@include file="/bizcommon/include/common_nis2010.jsp"%>