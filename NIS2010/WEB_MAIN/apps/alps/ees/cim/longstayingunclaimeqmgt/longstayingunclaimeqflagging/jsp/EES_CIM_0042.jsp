<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_cim_0034.jsp
*@FileTitle : EQ Availability
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.24
*@LastModifier : 김종준
*@LastVersion : 1.0
* 2009.06.24 김종준
* 1.0 Creation
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.event.EesCim0042Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesCim0042Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.LongstayingUnclaimEQMgt.LongstayingUnclaimEQFlagging");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EesCim0042Event)request.getAttribute("Event");
		
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Total S/Days (Detail)</title>
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

<script language="javascript">

    function setupPage(){  

	    loadPage();
    }

</script>



<body class="popup_bg" onLoad="setupPage();">

<form name="form"> 
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="loc_type_code" value="<%=event.getFlaggingSDaysOptionVO().getLocTypeCode() %>">
<input type="hidden" name="loc_cd" value="<%=event.getFlaggingSDaysOptionVO().getLocCd() %>">
<input type="hidden" name="loc_cd" value="<%=event.getFlaggingSDaysOptionVO().getCntrTpszCd() %>">
<input type="hidden" name="dmg_flg" value="<%=event.getFlaggingSDaysOptionVO().getDmgFlg() %>">
<input type="hidden" name="cntr_use_co_cd" value="<%=event.getFlaggingSDaysOptionVO().getCntrUseCoCd() %>">
<input type="hidden" name="over_stay_days" value="<%=event.getFlaggingSDaysOptionVO().getOverStayDays() %>">
<input type="hidden" name="cnmv_sts_cd" value="<%=event.getFlaggingSDaysOptionVO().getCnmvStsCd() %>">
<input type="hidden" name="uclm_ls_div_cd" value="<%=event.getFlaggingSDaysOptionVO().getUclmLsDivCd() %>">
<input type="hidden" name="full_flg" value="<%=event.getFlaggingSDaysOptionVO().getFullFlg() %>">
<input type="hidden" name="lstm_cd" value="<%=event.getFlaggingSDaysOptionVO().getLstmCd() %>">
<input type="hidden" name="soc_cd" value="<%=event.getFlaggingSDaysOptionVO().getSocCd() %>">
<input type="hidden" name="sub_cntr_tpsz_cd" value="<%=event.getFlaggingSDaysOptionVO().getSubCntrTpszCd() %>">
<input type="hidden" name="sub_loc_cd" value="<%=event.getFlaggingSDaysOptionVO().getSubLocCd() %>">
<input type="hidden" name="sub_cnmv_sts_cd" value="<%=event.getFlaggingSDaysOptionVO().getSubCnmvStsCd() %>">

<table width="100%" class="popup" cellpadding="10">
<tr><td class="top"></td></tr>
<tr><td valign="top">

		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td height="79" class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Total S/Days (Detail)</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
	
			<!-- Tab BG Box  (S) -->
	     	<table class="search"> 
	       	<tr><td class="bg">
				
				
				<!-- Grid - 1 (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>				
				<!-- Grid - 1 (E) -->
				</td></tr>
			</table>
		<!-- Tab BG Box  (S) -->
	<!--biz page (E)-->
	
<table class="height_5"><tr><td colspan="8"></td></tr></table>
	</td></tr>
</table>

<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

    	<!--Button (S) -->	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       		<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
		    	<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_downexcel">Down&nbsp;Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
		    	<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Close">Close</td>
					<td class="btn1_right">
				</tr></table></td>
			</tr>
		</table></td>
			</tr>
		</table>
    	<!--Button (E) -->
	
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->
</form>
</body>
</html>
