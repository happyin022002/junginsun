<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0709.jsp
*@FileTitle : DG Split
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.15
*@LastModifier : 최영희
*@LastVersion : 1.0
* 2009.06.15 최영희
* 1.0 Creation
* -------------------------------------------------------
* HISTORY
* 2012.10.22 조정민 [CHM-201220706] Special Appliatoin Split시 호출방식 변경
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.event.EsmBkg0709Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO" %>
<%@ page import="com.hanjin.apps.alps.esm.bkg.common.*" %>

<%
	EsmBkg0709Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strBkg_no		= "";
	String strSplit_Reason  = "";
	String strSplitCntrSplitNo		= "";
	String strLastSplitNo = "";
	String strOrgSplit="";
	String strValidateSplitNo="";
	String strBkgSplitNo ="";
	String strcntrExists ="";
	String strcntrPopExists ="";
  
	int iSplitCount =0;

	Logger log = Logger.getLogger("com.hanjin.apps.GeneralBookingConduct.GeneralBookingSplitCombine");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
        

		event = (EsmBkg0709Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

//		strBkg_no = event.getBkgBlNoVO().getBkgNo(); 
//		strSplit_Reason = event.getSplitReason();  //M:Memo C:Customer
//		iSplitCount = (event.getSplitCnt().length()<1)? 0:Integer.parseInt(event.getSplitCnt())+Integer.parseInt(event.getLastSplitNo());
//		strSplitCntrSplitNo = event.getSplitCntrSplitNo();
//		strLastSplitNo =event.getLastSplitNo();
//		strOrgSplit = event.getOrgSplit();
//		strValidateSplitNo =  event.getValidateSplitNo();
//		strBkgSplitNo = event.getBkgSplitNo();
//		strcntrExists = event.getCntrExists();
//		strcntrPopExists = event.getCntrPopExists();
	     
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>DG Split</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		var formObj = document.form;
		var opener = window.dialogArguments;
		formObj.bkg_no.value = opener.document.form.bkg_no.value;
		formObj.splitCnt.value = ComParseInt(opener.document.form.splitcount)-1+ComParseInt(opener.document.form.lastSplitNo.value);
		formObj.splitReason.value = ComGetObjValue(opener.document.form.splitreason);
		formObj.splitCntrSplitNo.value = opener.document.form.dgCntrSplitNo.value;
		formObj.lastSplitNo.value = opener.document.form.lastSplitNo.value;
		formObj.orgSplit.value = opener.document.form.orgSplit.value;
		formObj.validateSplitNo.value = opener.document.form.validateSplitNo.value;
		formObj.bkgsplitno.value = opener.document.form.bkgsplitno.value;
	    formObj.cntrExists.value = opener.document.form.cntrExists.value;
		formObj.cntrPopExists.value = opener.document.form.cntrPopExists.value;
		loadPage();
	}
</script>
</head>

<body class="popup_bg" onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows"> 
<input type="hidden" name="splitCnt" value=""> 
<input type="hidden" name="splitReason" value="">
<input type="hidden" name="splitCntrSplitNo" value="">
<input type="hidden" name="lastSplitNo" value="">
<input type="hidden" name="orgSplit" value="">
<input type="hidden" name="validateSplitNo" value="">
<input type="hidden" name="bkgsplitno" value=""> 
<input type="hidden" name="cntrExists" value=""> 
<input type="hidden" name="cntrPopExists" value=""> 
<!-- 개발자 작업	-->
<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp; DG Application Split
</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		<table class="search"> 
       		<tr><td class="bg">
				<table class="search" border="0" style="width:366;"> 
				<tr class="h23">
					<td width="50">BKG No.</td>					
					<td><input type="text" style="width:100;" class="input" name="bkg_no" disabled>&nbsp;
					<td></tr>
				</table>
		<!-- : ( Search Options ) (S) -->
 
			<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject1('sheet1');</script>
						</td>
					</tr>
				</table> 
				<!-- Grid  (E) -->
			
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
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_new">New</td>
					<td class="btn1_right"></td>
				</tr></table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_save">Save</td>
					<td class="btn1_right"></td>
				</tr></table></td>
					<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_close">Close</td>
					<td class="btn1_right"></td>
				</tr></table></td>
			</tr>
		</table></td>
			</tr>
		</table>
    <!--Button (E) -->
	
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>
