<!-- =========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : VOP_FCM_0003.jsp
*@FileTitle : Departure Report PK Error Cleansing
*Open Issues :
*Change history :
*@LastModifyDate : 2016-05-18
*@LastVersion : 1.0
* 2016-05-18 1.0 최초 생성
========================================================= -->
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.event.VopFcm0003Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
	VopFcm0003Event  event 				= null; 	//PDTO(Data Transfer Object including Parameters)
	Exception serverException   			= null;     //서버에서 발생한 에러
	DBRowSet rowSet      					= null; 	//DB ResultSet
	String strErrMsg 						= "";		//에러메세지
	
	//부모창의 파라미터
	String pUiId = "";
	String pfFmDt = "";
	String pfToDt = "";
	String pfVslCd = "";

	String pVslSlanCd = "";
	String pVVD = "";
	String pClptIndSeq = "";
	String pDepPortCd = "";
	String pNxtPortCd = "";
	String pRupDt = "";
	String pDepRptErrSeq = "";
	String prcvDt = "";
	String prcvSeq = "";
	String pSbEngDt = "";
	
	try {
		//SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		//userId=account.getSawonNo();
		//userAuth=account.getAuth(); 
		
		event = (VopFcm0003Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		
		if (serverException != null) {
		strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		pUiId 			=   JSPUtil.getParameter(request, "pUiId"		, "");
		//검색창에서
		pfFmDt 			=   JSPUtil.getParameter(request, "pfFmDt"		, "");
		pfToDt 			=   JSPUtil.getParameter(request, "pfToDt"		, "");
		pfVslCd 		=   JSPUtil.getParameter(request, "pfVslCd"		, "");
		//시트에서
		pVslSlanCd 		=   JSPUtil.getParameter(request, "pVslSlanCd"	, "");
		pVVD 			=   JSPUtil.getParameter(request, "pVVD"		, "");
		pClptIndSeq 	=   JSPUtil.getParameter(request, "pClptIndSeq"	, "");
		pDepPortCd 		=   JSPUtil.getParameter(request, "pDepPortCd"	, "");
		pNxtPortCd 		=   JSPUtil.getParameter(request, "pNxtPortCd"	, "");
		pRupDt			=   JSPUtil.getParameter(request, "pRupDt"		, "");
		pDepRptErrSeq	=   JSPUtil.getParameter(request, "pDepRptErrSeq", "");
		prcvDt			=   JSPUtil.getParameter(request, "prcvDt"		, "");
		prcvSeq			=   JSPUtil.getParameter(request, "prcvSeq"		, "");
		pSbEngDt			=   JSPUtil.getParameter(request, "pSbEngDt"		, "");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Lane</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        var uiId = "<%=pUiId%>";
        if (errMessage.length >= 1) {
        	ComShowMessage(errMessage);
        } // end if
        loadPage();
		if(uiId == 'VOP_FCM_0001') {
			setInitVal4Search('<%= pfFmDt %>', '<%= pfToDt %>', '<%= pfVslCd %>', '<%= pVslSlanCd %>', '<%= pVVD %>', '<%= pClptIndSeq %>'
					, '<%= pDepPortCd %>', '<%= pNxtPortCd %>', '<%= pRupDt %>', '<%= pDepRptErrSeq %>', '<%= prcvDt %>', '<%= prcvSeq %>', '<%= pSbEngDt %>');
		}
    }
</script>
</head>

<!-- OUTER - POPUP (S)tart -->
<body class="popup_bg" onload="javascript:setupPage();">
<form name="form">
<!-- 기본 필수 hidden -->
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<table width="100%" class="popup" cellpadding="10">
<tr><td class="top"></td></tr>
<tr><td valign="top">

		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td height="79" class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;
		Departure Report PK Error Cleansing
		</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
	
		
		<!-- TABLE '#D' : ( Search Options : Scenario ID ) (S) -->
		<table class="search"> 
			<tr>
				<td class="bg">
				
				<table width="100%" id="mainTable">
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet1');</script>
                        </td></tr>
		        </table>
				<table class="line_bluedot"><tr><td></td></tr></table>
				
				<!-- : ( Scenario ID ) (S) -->
				<table class="search" border="0" style="width:100%;">
					<tr class="h23">
						<td width="40">Period</td>
						<td width="230">
							<input type="text" name="fm_dt" style="width:70;" class="input1" caption="Period FM" dataformat="ymd" size="10" maxlength="8" fulfill required>
							<img class="cursor" name="btn_calendarfm" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle">
							~
							<input type="text" name="to_dt" style="width:70;" class="input1" caption="Period To" dataformat="ymd" size="10" maxlength="8" fulfill required>
							<img class="cursor" name="btn_calendarto" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle">
						</td>
						<td width="40">Lane</td>
						<td width="75">
							<script language="javascript">ComComboObject('vsl_slan_cd',1,60,0,0);</script>
						</td>
						<td width="45">Vessel</td>
						<td width="65" class="stm"><script language="javascript">ComComboObject('vsl_cd',1,60,0,0);</script></td>
						<td width="35">Port</td>
						<td width="90">
							<script language="javascript">ComComboObject('vps_port_cd',1,70,0,0);</script>
						</td>
						<td width="65">Direction</td>  
						<td width="40"><script language="javascript">ComComboObject('skd_dir_cd',1,40,0,0);</script></td>
					
					</tr>
				</table>
				<!-- : ( Scenario ID ) (E) -->
				
		
		<!-- TABLE '#D' : ( Search Options : Scenario ID ) (E) --> 	

		<table class="line_bluedot"><tr><td></td></tr></table>


		<!-- TABLE '#D' : ( Tab BG Box ) (S) -->
		
			
			<!-- : ( Grid ) (S) -->
			<!-- 'HEAD1-BGCOLOR : 203 240 169' , 'HEAD2-BGCOLOR : 222 251 248' , 'BORDER 1-outside : 88 152 164' , 
				 'BORDER 2-inside : 202 226 233' , 'HEAD-FONT : 39 95 101' , 'SELETED ROW BG : 252 255 233' -->
				<table width="100%" id="mainTable">
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet2');</script>
                        </td></tr>
		       </table>

				<table width="100%" class="button"> 
		       		<tr><td class="btn2_bg">
					<table border="0" cellpadding="0" cellspacing="0">
							<td width="80"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_Retrieve">Retrieve</td>
							<td class="btn2_right"></td>
							</tr>
							</table></td>
				</table>
				
			<!-- : ( Grid ) (E) -->	
		<!-- TABLE '#D' : ( Tab BG Box ) (E) -->
</td></tr>
</table> 
<!-- OUTER - POPUP (E)nd -->
</td></tr>
</table> 
<table class="height_5"><tr><td></td></tr></table> 
</td></tr>
</table> 	
<!-- : ( Button : Sub ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
								<td class="btn1" name="btn_Save" id="btn_Save">Save</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
					</td>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
								<td class="btn1" name="btn_Close">Close</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
					</td>
				</tr>
				</table>
			</td>
			</tr>
		</table>

	</td></tr>
</table>
<!-- : ( Button : Sub ) (E) -->

</form>
</body>
</html>
 <%@include file="/bizcommon/include/common_alps.jsp"%>