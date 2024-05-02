<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CGM_1153.jsp
*@FileTitle : Asset inquiry by Year
*Open Issues :
*Change history :
*@LastModifyDate : 2011.05.24
*@LastModifier : NK Jin-Ho
*@LastVersion : 1.0
* 2011.05.242 NK Jin-Ho
* 1.0 Creation
*--------------------------------------------------
* History
* 2015.04.28 Chang Young Kim [CHM-201534113] 2015년 1월 소스 보안 결함 건 조치 요청
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.event.EesCgm1154Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.util.StringUtil"%>

<%
	EesCgm1154Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.EquipmentOperationPlan.ContainerSupplyDemandPlan");

	String mnfrYr 		=  "";
	String fm_prd		=  "";
	String to_prd		=  "";	
	String cntrTpszCd 	=  "";
	String lstmCd 		=  "";
	String cntrPfxCd 	=  "";
	String fmSerNo 		=  "";
	String toSerNo 		=  "";
	String mftrVndrSeq 	=  "";
	String locTpCd 		=  "";
	String locCd 		=  "";
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EesCgm1154Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		mnfrYr 		= (StringUtil.xssFilter(request.getParameter("mnfr_yr")) == null)		? "": StringUtil.xssFilter(request.getParameter("mnfr_yr"));
		fm_prd 		= (StringUtil.xssFilter(request.getParameter("fm_prd")) == null)		? "": StringUtil.xssFilter(request.getParameter("fm_prd"));
		to_prd 		= (StringUtil.xssFilter(request.getParameter("to_prd")) == null)		? "": StringUtil.xssFilter(request.getParameter("to_prd"));		
		cntrTpszCd 	= (StringUtil.xssFilter(request.getParameter("cntr_tpsz_cd")) == null)	? "": StringUtil.xssFilter(request.getParameter("cntr_tpsz_cd"));
		lstmCd 		= (StringUtil.xssFilter(request.getParameter("lstm_cd")) == null)		? "": StringUtil.xssFilter(request.getParameter("lstm_cd"));
		cntrPfxCd 	= (StringUtil.xssFilter(request.getParameter("cntr_pfx_cd")) == null)	? "": StringUtil.xssFilter(request.getParameter("cntr_pfx_cd"));		
		fmSerNo 	= (StringUtil.xssFilter(request.getParameter("fm_ser_no")) == null)		? "": StringUtil.xssFilter(request.getParameter("fm_ser_no"));
		toSerNo 	= (StringUtil.xssFilter(request.getParameter("to_ser_no")) == null)		? "": StringUtil.xssFilter(request.getParameter("to_ser_no"));
		mftrVndrSeq = (StringUtil.xssFilter(request.getParameter("mftr_vndr_seq"))== null)	? "": StringUtil.xssFilter(request.getParameter("mftr_vndr_seq"));		
		locTpCd 	= (StringUtil.xssFilter(request.getParameter("loc_tp_cd")) == null)		? "": StringUtil.xssFilter(request.getParameter("loc_tp_cd"));
		locCd 		= (StringUtil.xssFilter(request.getParameter("loc_cd")) == null)		? "": StringUtil.xssFilter(request.getParameter("loc_cd"));
		
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Asset inquiry by Year</title>
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

<body class="popup_bg" onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->
<input type="hidden" name="mnfr_yr" value="<%=mnfrYr%>">
<input type="hidden" name="fm_prd" value="<%=fm_prd%>">
<input type="hidden" name="to_prd" value="<%=to_prd%>">
<input type="hidden" name="cntr_tpsz_cd" value="<%=cntrTpszCd%>">
<input type="hidden" name="lstm_cd" value="<%=lstmCd%>">
<input type="hidden" name="cntr_pfx_cd" value="<%=cntrPfxCd%>">
<input type="hidden" name="fm_ser_no" value="<%=fmSerNo%>">
<input type="hidden" name="to_ser_no" value="<%=toSerNo%>">
<input type="hidden" name="mftr_vndr_seq" value="<%=mftrVndrSeq%>">
<input type="hidden" name="loc_tp_cd" value="<%=locTpCd%>">
<input type="hidden" name="loc_cd" value="<%=locCd%>">
<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp; Asset inquiry by Year-Detail </td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- : ( Search Options ) (S) -->
 
			
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
		    <tr>
				<td width="">
					<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_close">Close</td>
						<td class="btn1_right"></td>
					</tr>
					</table>
				</td>
			</tr>
		</table>
		</td></tr>
</table>
    <!--Button (E) -->
	
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>