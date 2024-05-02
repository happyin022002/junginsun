<%
/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : esm_bkg_1405.jsp
*@FileTitle : Stop Off BKG List for Audit
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.05
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.05 
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event.EsmBkg1054Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg1054Event  event = null;              //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //서버에서 발생한 에러
    String strErrMsg = "";                      //에러메세지
    int rowCount     = 0;                       //DB ResultSet 리스트의 건수

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    Logger log = Logger.getLogger("com.hanjin.apps.InboundBLMgtSC.FullReleaseOrderBC");

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();


        event = (EsmBkg1054Event)request.getAttribute("Event");
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
<title>Stop Off BKG List for Audit</title>
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

<input type='hidden' name ='frm_sch_tp' value = "">


<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	
	<tr><td valign="top">
	
		<!--Page Title, Historical (S)-->   
	    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">   
	        <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>   
	        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>   
	    </table>   
		<!--Page Title, Historical (E)-->
	
	
		<!--Button (S) -->
		
    	<!--Button (E) -->

<!-- 개발자 작업    -->
		<table class="search" id="mainTable">
		    <tr><td class="bg">
		            <table class="search" border="0">
		            <tr class="h23">
		                <td width="120">Application Date :</td>
		                <td width="">
		                	<input type="text" name="fm_dt" style="width:80;" class="input1" value="" caption="Application Date(From)" maxlength="8" dataformat="ymd">
		                		&nbsp;~&nbsp;
		                	<input type="text" name="to_dt" style="width:80;" class="input1" value="" caption="Application Date(To)" maxlength="8" dataformat="ymd">&nbsp;
		                		<img class="cursor" src="img/btns_calendar.gif" name="btns_calendar2" width="19" height="20" border="0" align="absmiddle"></td>
		                
		            </tr>
		            </table>
		    </td></tr>
		</table>

	    <table class="height_8"><tr><td></td></tr></table>
	
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
	    		<table class="height_5"><tr><td></td></tr></table>
	    	</td></tr>
	    </table>
	    <!--biz page (E)-->

    	<table width="100%" class="button" border="0" cellpadding="0" cellspcing="0" style="padding-top:5;,padding-bottom:2;"> 
      		<tr>
          		<td class="btn1_bg">
            		<table border="0" cellpadding="0" cellspacing="0">
              			<tr>
                			<td>
                  				<table width="100%" border="0" cellpadding="0"sa cellspacing="0" class="button">
                    			<tr>
                       				<td class="btn1_left"></td>
                       				<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
                       				<td class="btn1_right"></td>
                      			</tr>
                  				</table>
                			</td>
                			<td>
                  				<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
                    			<tr>
                       				<td class="btn1_left"></td>
                       				<td class="btn1" name="btn_new">New</td>
                       				<td class="btn1_right"></td>
                    			</tr>
                  				</table>
                			</td>
                			
                              <td>
                                  <table width="100%" border="0" cellpadding="0" cellspacing="0"
                                         class="button">
                                      <tr>
                                          <td class="btn1_left"></td>
                                          <td class="btn1" name="btn_downexcel">Down Excel</td>
                                          <td class="btn1_right"></td>
                                      </tr>
                                  </table>
                              </td>
                			
              			</tr>
            		</table>
          		</td>
        	</tr>
    	</table>
<!--Button (E) -->
	</td></tr>
</table>
	</td></tr>
</table>
	
<iframe name="hiddenFrame" style="visibility:hiddden" height="0" width="0"></iframe>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>