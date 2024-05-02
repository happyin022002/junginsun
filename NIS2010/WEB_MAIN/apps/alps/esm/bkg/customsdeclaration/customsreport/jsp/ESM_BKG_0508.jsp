<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0508.jsp
*@FileTitle : US AMS: Sent File
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.01
*@LastModifier : 이수빈
*@LastVersion : 1.0
* 2009.06.01 이수빈
* 1.0 Creation
*
* 2011.08.08 민정호 [CHM-201111822] Split 05-R4J Rule Upgrade 관련 소스품질 향상을 위한 조치 건
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>

<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>

<%@ page import="com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.usa.event.EsmBkg0508Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.Date" %>
<%
    EsmBkg0508Event  event 		= null;	//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;	//서버에서 발생한 에러
	String strErrMsg 			= "";	//에러메세지
	int rowCount	 			= 0;	//DB ResultSet 리스트의 건수

	String successFlag 	= "";
	String codeList  	= "";
	String pageRows  	= "100";
	String strUsr_id	= "";
	String strUsr_nm	= "";
    String strCnt_cd    = "";
	
    String trsmMsgTpId = "";
    String vvd   	   = "";
    String polCd 	   = "";
    String podCd 	   = "";
    String ofcCd 	   = "";
    String usrId 	   = "";
    String sndDt       = "";
    String ofm         = "";

    String cntCd       = "";
    String ioBndCd     = "";
    String hisSeq      = "";
    String stwgSndId   = "";
    String sndDate     = "";
    

	Logger log = Logger.getLogger("com.hanjin.apps.CustomsDeclaration.CustomsReport");
	String date = DateTime.getFormatDate(new Date(), "yyyyMMdd") + DateTime.getShortTimeString();
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
        strCnt_cd = account.getCnt_cd();

		event = (EsmBkg0508Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		trsmMsgTpId = JSPUtil.getParameter(request, "trsm_msg_tp_id");
		vvd   = JSPUtil.getParameter(request, "vvd2");
		polCd = JSPUtil.getParameter(request, "pol");
		podCd = JSPUtil.getParameter(request, "pod");
		ofcCd = JSPUtil.getParameter(request, "ofc");
		usrId = JSPUtil.getParameter(request, "usr");
        ofm   = JSPUtil.getParameter(request, "ofm");

		cntCd     = JSPUtil.getParameter(request, "cnt_cd");
		ioBndCd   = JSPUtil.getParameter(request, "io_bnd_cd");
		hisSeq    = JSPUtil.getParameter(request, "his_seq");
		stwgSndId = JSPUtil.getParameter(request, "stwg_snd_id");
        sndDt     = JSPUtil.getParameter(request, "snd_date");
		if(!"".equals(sndDt)){
			sndDate  = sndDt.substring(0,4)+"-"+sndDt.substring(4,6)+"-"+sndDt.substring(6,8)+" "+
						sndDt.substring(8,10)+":"+sndDt.substring(10,12)+":"+sndDt.substring(12);
		}

	}catch(Exception e) {
		out.println(e.toString());
	}
	
%>
<html>
<head>
<title>US AMS: Sent File</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="/hanjin/rpt/script/rdviewer50.js"></script>
<script language="javascript">
    var strCntCd = "<%=strCnt_cd%>";
    var ofmFlg;
    function setupPage(){
        ofmFlg = "<%=ofm %>";
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
<input type="hidden" name="download">
<input type="hidden" name="ofm_flg" value="<%=ofm%>">
<input type="hidden" name="trsm_msg_tp_id" value="<%=trsmMsgTpId%>">
<input type="hidden" name="vvd" value="<%=vvd%>">
<input type="hidden" name="pol_cd" value="<%=polCd%>">
<input type="hidden" name="pod_cd" value="<%=podCd%>">
<input type="hidden" name="ofc_cd" value="<%=ofcCd%>">
<input type="hidden" name="usr_id" value="<%=usrId%>">
<input type="hidden" name="snd_dt" value="<%=sndDt%>">

<input type="hidden" name="cnt_cd" value="<%=cntCd%>">
<input type="hidden" name="io_bnd_cd" value="<%=ioBndCd%>">
<input type="hidden" name="his_seq" value="<%=hisSeq%>">
<input type="hidden" name="snd_date" value="<%=sndDate%>">
<input type="hidden" name="stwg_snd_id" value="<%=stwgSndId%>">
<input type="hidden" name="date" value="<%=date%>">

<!-- 개발자 작업	-->

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
    
        <!-- : ( Title ) (S) -->
        <table width="100%" border="0">
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;US AMS: Sent File</td></tr>
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
<iframe name="download" id="download" style="display:none;width:1px;height:1px;"></iframe>
</body>
</html>
