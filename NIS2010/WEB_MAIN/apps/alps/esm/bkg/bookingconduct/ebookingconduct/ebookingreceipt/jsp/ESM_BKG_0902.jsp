<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0902.jsp
*@FileTitle : e-Booking & S/I Reject
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.06
*@LastModifier : 전용진
*@LastVersion : 1.0
* 2009.07.06 전용진
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.event.EsmBkg0902Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.List" %>
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.*" %>
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO" %>
<%@ page import="com.hanjin.apps.alps.esm.bkg.common.*" %>

<%
	EsmBkg0902Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_eml		= "";
	String bkgUpldStsCd     = "";
	String docTpCd		 	= "";
	Logger log = Logger.getLogger("com.hanjin.apps.EBookingConduct.EBookingReceipt");

	XterRqstNoVO xterRqstNoVO = null;
	List<BkgComboVO> reject_reason_cd = null;
	String cntcEml = null;

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_eml = account.getUsr_eml();

		event = (EsmBkg0902Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		xterRqstNoVO = (XterRqstNoVO) eventResponse.getCustomData("xterRqstNoVO");
		reject_reason_cd = (List<BkgComboVO>) eventResponse.getCustomData("reject_reason_cd");
		cntcEml = (String) eventResponse.getCustomData("cntc_eml");
		bkgUpldStsCd = JSPUtil.getParameter(request, "bkg_upld_sts_cd");
		docTpCd = JSPUtil.getParameter(request, "doc_tp_cd");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<%
	if(bkgUpldStsCd.equals("R")){ 
%>
<title>e-Booking & S/I Reject</title>
<%
	} else if(bkgUpldStsCd.equals("P")){
%>
<title>e-Booking & S/I Pending</title>
<%
	}
%>
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
<input type="hidden" name="sender_id" value="<%=xterRqstNoVO.getSenderId()%>">
<input type="hidden" name="usr_eml" value="<%=strUsr_eml%>">
<input type="hidden" name="bkg_upld_sts_cd" value="<%=bkgUpldStsCd%>">
<input type="hidden" name="doc_tp_cd" value="<%=docTpCd%>">
<!-- 개발자 작업	-->

<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">
<%
	if(bkgUpldStsCd.equals("R") || bkgUpldStsCd.equals("M")){ 
%>
&nbsp;e-Booking & SI Reject
<%
	} else if(bkgUpldStsCd.equals("P")){
%>
&nbsp;e-Booking & SI Pending
<%
	}
%>
		</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- : ( Search Options ) (S) -->
 
			<table class="search"> 
       		<tr><td class="bg">
			
			<table class="search" border="0" style="width:100%;"> 
<%
	if(bkgUpldStsCd.equals("P") || bkgUpldStsCd.equals("R")){
%>			
				<tr class="h23">
					<td width="110">Request No.</td> 
					<td width="120"><input type="text" name="rqst_no" style="width:100" class="input2" value="<%=xterRqstNoVO.getRqstNo()%>" readOnly></td>
					<td width="30">Seq.</td> 
					<td width="40"><input type="text" name="rqst_seq" style="width:20;text-align:center" class="input2" value="<%=xterRqstNoVO.getRqstSeq()%>" readOnly></td>
					<td width="80">Booking No.</td> 
					<td width="100"><input type="text" name="bkg_no" style="width:100%" class="input2" value="<%=xterRqstNoVO.getBkgNo()%>" readOnly></td>
				</tr>
<%
	}
%>				
				<tr class="h23">
					<td width="">
<%
	if(bkgUpldStsCd.equals("R") || bkgUpldStsCd.equals("M")){ 
%>
Reject Reason
<%
	} else if(bkgUpldStsCd.equals("P")){
%>
Pending Reason
<%
	}
%>					
					</td> 
					<td width="350" colspan="5">
						<%=HTMLUtil.getComboString("reject_reason_cd", "width:99%;", "","changeReason","","", reject_reason_cd)%>
				  </td>
				</tr>
<%
	if(bkgUpldStsCd.equals("P") || bkgUpldStsCd.equals("R")){
%>				
				<tr class="h23">
					<td width="">Email Address</td> 
					<td colspan="5" style="padding-left:"><input type="text" name="cntc_eml" style="width:100%" class="input" value="<%=cntcEml%>"></td>
				</tr>
<%
	}
%>				
				<tr class="h23">
					<td colspan="6" style="padding-left:">
<%
	if(bkgUpldStsCd.equals("R")){ 
%>					
					  <textarea name="reject_reason" style="width:100%;height:250"> Dear Customer

 Your e-Booking & SI request is declined due to below reason

 Reason for Decline : 
 Request No : {?rqst_no}
 Booking No : {?bkg_no}
 Vessel / Voyage / Direction ; {?v1} {?v2}
 Place of Receipt : {?por1}, {?por2} 
 Port of Loading : {?pol1}, {?pol2}
 Port of Discharging : {?pod1}, {?pod2}
 Place of Delivery : {?del1}, {?del2}

 For more detailed information, please email at <%=strUsr_eml%>

 Thank you
 SM Line</textarea>
 <%
	} else if(bkgUpldStsCd.equals("P")){
%>
					  <textarea name="reject_reason" style="width:100%;height:250"> Dear Customer

 Your e-Booking & SI request is pending due to below reason

 Reason for Pending : 
 Request No : {?rqst_no}
 Booking No : {?bkg_no}
 Vessel / Voyage / Direction ; {?v1} {?v2}
 Place of Receipt : {?por1}, {?por2} 
 Port of Loading : {?pol1}, {?pol2}
 Port of Discharging : {?pod1}, {?pod2}
 Place of Delivery : {?del1}, {?del2}

 For more detailed information, please email at <%=strUsr_eml%>

 Thank you
SM Line</textarea>
<%
	} else if(bkgUpldStsCd.equals("M")){
%>		
		<textarea name="reject_reason" style="width:100%;height:250">
 Reason for Decline :
	 </textarea>


<%
	}
%>			
          </td>
				</tr>
				<tr>
				<%
	if(bkgUpldStsCd.equals("R")){ 
%>
					<td colspan="6" style="padding-left:6">Will you send reject notification to your customer?&nbsp;
<%
	} else if(bkgUpldStsCd.equals("P")){
%>
					<td colspan="6" style="padding-left:6">Will you send pending notification to your customer?&nbsp;
<%
	}
%>		
<%
	if(bkgUpldStsCd.equals("P") || bkgUpldStsCd.equals("R")){
%>
					<input type="radio" name="eml_snd_yn" value="Y" class="trans" checked>Yes&nbsp;<input type="radio" name="eml_snd_yn" value="N" class="trans">No
</td>
<%
	}
%>
				</tr>
			</table>
			
			
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
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_OK">OK</td>
					<td class="btn1_right"></td>
				</tr></table></td>
				<td class="btn1_line"></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="bt_Close" onclick="self.close()">Close</td>
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
	
	<table width="98%"  id="mainTable">
		<tr>
			<td width="98%">
				<script language="javascript">ComSheetObject('sheet1');</script>
			</td>
		</tr>
	</table>

</form>
</body>
</html>