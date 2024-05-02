<%
/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EES_DMT_7019.jsp
*@FileTitle : Charge Deletion Attached File List
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.05
*@LastModifier : Lee Sung Hoon
*@LastVersion : 1.0
* 2015.02.05 Lee Sung Hoon
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
<%@ page import="com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.event.EesDmt7019Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesDmt7019Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String sysAreaGrpId     = "";
	String cntrNo			= "";
	String cntrCycNo        = "";
	String dmdtTrfCd        = "";
	String dmdtChgLocDivCd  = "";
	String chgSeq           = "";
	String chgOfcCd         = "";
	String deltSeq          = "";
	
	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	String strRhq_ofc_cd	= "";
	Logger log = Logger.getLogger("com.hanjin.apps.DMTMasterDataMgt.DemDetTariffMgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
        strRhq_ofc_cd = account.getRhq_ofc_cd();

		event = (EesDmt7019Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		sysAreaGrpId     = JSPUtil.getParameter(request, "sys_area_grp_id");
		cntrNo			 = JSPUtil.getParameter(request, "cntr_no");
		cntrCycNo        = JSPUtil.getParameter(request, "cntr_cyc_no");
		dmdtTrfCd        = JSPUtil.getParameter(request, "dmdt_trf_cd");
		dmdtChgLocDivCd  = JSPUtil.getParameter(request, "dmdt_chg_loc_div_cd");
		chgSeq           = JSPUtil.getParameter(request, "chg_seq");
		chgOfcCd         = JSPUtil.getParameter(request, "chg_ofc_cd");
		deltSeq          = JSPUtil.getParameter(request, "delt_seq");	
	}
	catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Charge Deletion Attached File List</title>
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
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<!-- 개발자 작업	-->
<input type="hidden" name="sys_area_grp_id" value="<%=sysAreaGrpId%>"/>
<input type="hidden" name="cntr_no" value="<%=cntrNo%>"/>
<input type="hidden" name="cntr_cyc_no" value="<%=cntrCycNo%>"/>
<input type="hidden" name="dmdt_trf_cd" value="<%=dmdtTrfCd%>"/>
<input type="hidden" name="dmdt_chg_loc_div_cd" value="<%=dmdtChgLocDivCd%>"/>
<input type="hidden" name="chg_seq" value="<%=chgSeq%>"/>
<input type="hidden" name="chg_ofc_cd" value="<%=chgOfcCd%>"/>
<input type="hidden" name="delt_seq" value="<%=deltSeq%>"/>

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
	<!--biz page (S)-->
	<table class="search" id="mainTable"> 
      	<tr><td class="bg">
	
		<!-- Grid_1 (S) -->
		<table class="search" border="0">
			<tr>
				<td class="title_h"></td>
				<td class="title_s">Charge Deletion Attached File</td>
			</tr>
		</table>				
		<table width="100%"  id="mainTable"> 
			<tr>
				<td width="100%">
					<script language="javascript">ComSheetObject("sheet1");</script>
				</td>
			</tr>
		</table>				
		<!-- Grid_1 (E) -->		

	</td></tr>
	</table>
	<!--biz page (E)--> 
		
	<table class="height_5"><tr><td></td></tr></table>

</td></tr>
</table>
	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

    	<!--Button (S) -->	
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
    	<!--Button (E) -->
</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->

<script language="javascript">ComUploadObject("upload1", '<%=session.getId()%>');</script>
<!-- 개발자 작업  끝 -->
</form>
<iframe name="hiddenFrame" style="visibility:hiddden" height="0" width="0"></iframe>
</body>
</html>