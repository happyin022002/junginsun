<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0429.jsp
*@FileTitle : US AMS: Received File
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.01
*@LastModifier : 이수빈
*@LastVersion : 1.0
* 2009.06.01 이수빈
* 1.0 Creation
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>

<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>

<%@ page import="com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.usa.event.EsmBkg0429Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EsmBkg0429Event  event 		= null;	//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;	//서버에서 발생한 에러
	String strErrMsg 			= "";	//에러메세지
	int rowCount	 			= 0;	//DB ResultSet 리스트의 건수

	String successFlag 	= "";
	String codeList  	= "";
	String pageRows  	= "100";
	String strUsr_id	= "";
	String strUsr_nm	= "";
    String strCnt_cd    = "";
	
    String msgTpId 	   = "";
    String vvd   	   = "";
    String polCd 	   = "";
    String podCd 	   = "";
    String blNo 	   = "";
    String batchNo 	   = "";

    String cntCd       = "";
    String ioBndCd     = "";
    String rcvDate     = "";
    String rcvSeq      = "";
    String rcvDt	   = "";

	Logger log = Logger.getLogger("com.hanjin.apps.CustomsDeclaration.CustomsReport");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
        strCnt_cd = account.getCnt_cd();

		event = (EsmBkg0429Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		msgTpId = JSPUtil.getParameter(request, "msg_tp_id");
		vvd   = JSPUtil.getParameter(request, "vvd2");
		polCd = JSPUtil.getParameter(request, "pol");
		podCd = JSPUtil.getParameter(request, "pod");
		blNo = JSPUtil.getParameter(request, "blNo");
		batchNo = JSPUtil.getParameter(request, "batchNo");

		cntCd    = JSPUtil.getParameter(request, "cnt_cd");
		ioBndCd  = JSPUtil.getParameter(request, "io_bnd_cd");
        rcvSeq   = JSPUtil.getParameter(request, "rcv_seq");
		rcvDate  = JSPUtil.getParameter(request, "rcv_date");
		if(!"".equals(rcvDate)){
			  rcvDate  = rcvDate.replace("-","").replace(":","").substring(0);
			  rcvDt    = rcvDate.substring(0,4)+"-"+rcvDate.substring(4,6)+"-"+rcvDate.substring(6,8)+" "+
				 		 rcvDate.substring(8,10)+":"+rcvDate.substring(10,12)+":"+rcvDate.substring(12);
		}

	}catch(Exception e) {
		out.println(e.toString());
	}
	
%>
<html>
<head>
<title>US AMS: Received File</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="/hanjin/rpt/script/rdviewer50.js"></script>
<script language="javascript">
    var strCntCd = "<%=strCnt_cd%>";
    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            showErrMessage(errMessage);
        } // end if
		loadPage();
	}
</script>
</head>

<body class="popup_bg" onLoad="javascript:setupPage();">
<form name="form" method="post">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="rcv_msg_tp_id" value="<%=msgTpId%>">
<input type="hidden" name="vvd" value="<%=vvd%>">
<input type="hidden" name="pol_cd" value="<%=polCd%>">
<input type="hidden" name="pod_cd" value="<%=podCd%>">
<input type="hidden" name="bl_no" value="<%=blNo%>">
<input type="hidden" name="batch_no" value="<%=batchNo%>">
<input type="hidden" name="rcv_dt" value="<%=rcvDt%>">
<input type="hidden" name="cnt_cd" value="<%=cntCd%>">
<input type="hidden" name="io_bnd_cd" value="<%=ioBndCd%>">
<input type="hidden" name="rcv_date" value="<%=rcvDate%>">
<input type="hidden" name="rcv_seq" value="<%=rcvSeq%>">

<!-- 개발자 작업	-->

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
    
        <!-- : ( Title ) (S) -->
        <table width="100%" border="0">
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;US AMS: Received File</td></tr>
        </table>
        <!-- : ( Title ) (E) -->
        
        <!-- : ( Search Options ) (S) -->
 
            <table class="search"> 
            <tr><td class="bg">
                <!-- : ( Grid ) (S) -->
                <table width="100%"  id="mainTable">
                    <tr>
                        <td width="100%">
                            <script language="javascript">ComSheetObject('sheet1');</script>
                        </td>
                    </tr>
                </table>
                <!-- : ( Grid ) (E) --> 

			    <!--biz page 2 (S)-->
			    <table border="0" width="100%" height="0" style="display:inline">
			        <tr>
			            <td><script language="javascript">comRdObject('report1');</script></td>
			        </tr>
			    </table>
			    <!--biz page 2 (E)-->
            <!-- : ( Button : Grid ) (E) -->    
            
            </td></tr>
        </table>
<!-- : ( Search Options ) (E) -->

<table class="height_5"><tr><td></td></tr></table>
</td></tr>
</table> 
    
    
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
    
        <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
        <tr><td class="btn3_bg">
            <table border="0" cellpadding="0" cellspacing="0">
            <tr><td>
                <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_downexcel">Down Excel</td>
                    <td class="btn1_right"></td>
                </tr></table></td>
                
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_print">Print</td>
                    <td class="btn1_right"></td>
                </tr></table></td>
                <td class="btn1_line"></td>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_close">Close</td>
                    <td class="btn1_right"></td>
                </tr></table>
            </td></tr>
            </table>
    </td></tr>
</table>
    </td></tr>
</table>
<!-- : ( Button : pop ) (E) -->
	
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>
