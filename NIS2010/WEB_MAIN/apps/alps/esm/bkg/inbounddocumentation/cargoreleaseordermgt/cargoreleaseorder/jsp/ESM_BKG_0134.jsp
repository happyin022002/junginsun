<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0134.jsp
*@FileTitle : Cargo Release Order_E-D/O inquiry _Main
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.16
*@LastModifier : 안진응
*@LastVersion : 1.0
* 2009.05.19 안진응
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event.EsmBkg0134Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EsmBkg0134Event  event = null;              //PDTO(Data Transfer Object including Parameters)
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


        event = (EsmBkg0134Event)request.getAttribute("Event");
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
<title>D/O EDI Transmit log List Inquiry</title>
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

<body  onLoad="setupPage();" onKeyDown="enterKeySearch();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<input type='hidden' name='autoSearchFlg' value ="<%=JSPUtil.getNull(request.getParameter("autoSearchFlg"))%>">
<input type='hidden' name ='frm_edo_rqst_dt_s' value = "<%=JSPUtil.getNull(request.getParameter("edo_rqst_dt_s"))%>">
<input type='hidden' name ='frm_edo_rqst_dt_e' value = "<%=JSPUtil.getNull(request.getParameter("edo_rqst_dt_e"))%>">
<input type='hidden' name ='frm_bl_no' value = "<%=JSPUtil.getNull(request.getParameter("bl_no"))%>">
<input type='hidden' name ='frm_sch_tp' value = "">


<!-- 개발자 작업    -->

<%@include file="../../../../bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_TOP.jsp"%>


		<table class="search" id="mainTable">
		    <tr><td class="bg">
		            <table class="search" border="0" style="width:100%;">
		            <tr class="h23">
		                <td width="75">
		                	<input type="radio" value="B" class="trans" name="sch_tp" checked ="true"> &nbsp;B/L No</td>
		                <td width="310">
		                	<input type="text" name="bl_no" style="width:100;" class="input" value="<%=JSPUtil.getNull(request.getParameter("bl_no"))%>" maxlength="12" dataformat="eng" style="ime-mode:disabled" onFocus="form.sch_tp[0].checked=true;"></td>
		                <td width="220">
		                	<input type="radio" value="A" class="trans" name="sch_tp"> &nbsp;Error Message Received Date</td>
		                <td width="">
		                	<input type="text" name="rcv_fm_dt" style="width:80;" class="input1" value="" caption="Error Message Received Date(From)" maxlength="8" dataformat="ymd" onFocus="form.sch_tp[1].checked=true;">
		                		&nbsp;~&nbsp;
		                	<input type="text" name="rcv_to_dt" style="width:80;" class="input1" value="" caption="Error Message Received Date(To)" maxlength="8" dataformat="ymd">&nbsp;
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
                       				<td class="btn1" name="btn_Retrieve">Retrieve</td>
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
              			</tr>
            		</table>
          		</td>
        	</tr>
    	</table>
<!--Button (E) -->
	</td></tr>
</table>

<%@include file="../../../../bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_CLOSE.jsp"%>		
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>