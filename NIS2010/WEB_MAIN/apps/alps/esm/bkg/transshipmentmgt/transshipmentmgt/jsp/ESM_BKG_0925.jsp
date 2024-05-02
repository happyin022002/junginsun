<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ems_bkg_0925.jsp
*@FileTitle : T/S List by 1st VSL & 2nd VSL T/S Summary
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.04
*@LastModifier : 최영희
*@LastVersion : 1.0
* 2009.06.04 최영희
* 1.0 Creation
* -------------------------------------------------------
* History
* 2011.05.27 이일민 [CHM-201110190] * 전배 모선 표시 사항
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.event.EsmBkg0925Event"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.vo.TSListBy1st2ndVVDListInputVO"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0925Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strLoc_cd ="";
	String strLoc_yd_cd ="";
	String strSearch_kind_cd ="";
	String strDisc_load_cd ="";
	String strVps_etd_dt = "";
	String strVvd ="";
	String strPol_cd ="";
	String strPod_cd ="";
	String strDur_from ="";
	String strDur_to ="";
	String strOp_cd ="";
	String strSpecial ="";

	TSListBy1st2ndVVDListInputVO tSListBy1st2ndVVDListInputVO = null;
	Logger log = Logger.getLogger("com.hanjin.apps.TransshipmentMgt.TransshipmentMgt");
   
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg0925Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		tSListBy1st2ndVVDListInputVO = event.getTSListBy1st2ndVVDListInputVO();
		strLoc_cd = tSListBy1st2ndVVDListInputVO.getLocCd();
		strLoc_yd_cd =tSListBy1st2ndVVDListInputVO.getLocYdCd();
		strSearch_kind_cd =tSListBy1st2ndVVDListInputVO.getSearchKindCd();
		strDisc_load_cd = tSListBy1st2ndVVDListInputVO.getDiscLoadCd();
		strVps_etd_dt = tSListBy1st2ndVVDListInputVO.getVpsEtdDt();
		strVvd = tSListBy1st2ndVVDListInputVO.getVvd();
		strPol_cd = tSListBy1st2ndVVDListInputVO.getPolCd();
		strPod_cd = tSListBy1st2ndVVDListInputVO.getPodCd();
		strDur_from = tSListBy1st2ndVVDListInputVO.getDurFrom();
		strDur_to = tSListBy1st2ndVVDListInputVO.getDurTo();
		strOp_cd = tSListBy1st2ndVVDListInputVO.getOpCd();
		strSpecial = tSListBy1st2ndVVDListInputVO.getSpecial();

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>T/S List by 1st VSL & 2nd VSL T/S Summary</title>
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
<input type="hidden" name="loc_cd" value="<%=strLoc_cd%>">
<input type="hidden" name="loc_yd_cd" value="<%=strLoc_yd_cd%>">
<input type="hidden" name="search_kind_cd" value="<%=strSearch_kind_cd%>">
<input type="hidden" name="disc_load_cd" value="<%=strDisc_load_cd%>">
<input type="hidden" name="vps_etd_dt" value="<%=strVps_etd_dt%>">
<input type="hidden" name="vvd" value="<%=strVvd%>">
<input type="hidden" name="pol_cd" value="<%=strPol_cd%>">
<input type="hidden" name="pod_cd" value="<%=strPod_cd%>">
<input type="hidden" name="dur_from" value="<%=strDur_from%>">
<input type="hidden" name="dur_to" value="<%=strDur_to%>">
<input type="hidden" name="op_cd" value="<%=strOp_cd%>">
<input type="hidden" name="special" value="<%=strSpecial%>">  
<!-- 개발자 작업	-->
<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;T/S List by 1st VSL & 2nd VSL - T/S Summary</td></tr>
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
				
				<!-- : ( Button : Grid ) (S) -->
				<!--  Button_Sub (S) -->
			
	    	<!-- Button_Sub (E) -->
		    <!-- : ( Button : Grid ) (E) -->	
			
			</td></tr>
		</table>
<!-- : ( Search Options ) (E) -->

<table class="height_5"><tr><td></td></tr></table>
Remark :  If terminal code changes, it will be shown in red color.
</td></tr>
</table> 
	
	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td width=""><select style="width:80;" name="selSort">
						<option value="0" selected>Sort</option>
						<option value="1">T/S VVD</option>
						<option value="2">TMNL</option>
						<option value="3">ETA</option>
						</select></td>
					<td class="btn1_line"></td>	
		    	<td width=""><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_DownExcel">Down Excel</td>
					<td class="btn1_right"></td>
				</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td width=""><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Close">Close</td>
					<td class="btn1_right"></td>
				</tr>
				</table></td>
		</tr>
		</table>
    <!--Button (E) -->
	</td></tr>
</table>
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>