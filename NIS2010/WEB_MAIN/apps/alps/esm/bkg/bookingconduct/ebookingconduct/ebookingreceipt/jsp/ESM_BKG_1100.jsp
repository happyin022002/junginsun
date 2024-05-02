<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_1100.jsp
*@FileTitle : e-Booking n SI Process
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.21
*@LastModifier : 전용진
*@LastVersion : 1.0
* 2009.05.21 전용진
* 1.0 Creation
2011.03.30 정선용 [CHM-201109338-01] Split 18-ALPS의 Location 조회불가건 수정 보완 요청.
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.event.EsmBkg1100Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.List" %>
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO" %>
<%@ page import="com.hanjin.apps.alps.esm.bkg.common.*" %>
<%@ page import="com.hanjin.framework.core.controller.DefaultViewAdapter"%>
<%
	EsmBkg1100Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	String strOfc_cd = "";
	String sXml = "";
	Logger log = Logger.getLogger("com.hanjin.apps.EBookingConduct.EBookingReceipt");
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strOfc_cd = account.getOfc_cd();	   
		event = (EsmBkg1100Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		DefaultViewAdapter adapter = new DefaultViewAdapter();
		sXml = adapter.makeXML(request, response);	
				
	} catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>e-Booking &amp; SI Process</title>
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

<body onload="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="sXml" value="<%=JSPUtil.replace(sXml, "\"", "&quot;")%>">


<!-- 개발자 작업	-->

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top: 2; padding-left: 5;">
	<tr><td valign="top">

	<!--Page Title, Historical (S)-->
	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
	</table>
	<!--Page Title, Historical (E)-->
	
	<!--biz page (S)-->
		<table class="search"> 
       		<tr><td class="bg">
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width: 979;">
					<tr class="h23">
					    <td width="25"><input type="radio" class="trans" name="rdo_srch_mandatory" value="rqst_dt" checked></td>
						<td width="95">Request Date&nbsp;</td>
						<td width="200"><input type="text" style="width:75"  class="input1" name="rqst_from_dt" caption="Request DT" dataformat="ymd">&nbsp;~&nbsp;<input type="text" style="width:75"  class="input1" name="rqst_to_dt" caption="Request DT" dataformat="ymd">&nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar"></td>
						<td>POL&nbsp;</td>
						<td><input type="text" style="width:60" class="input" dataformat="engupnum" name="pol_cd" maxlength="5" value=""></td>
						<td>Handling Office&nbsp;</td>
						<td><input type="text" style="width:75" class="input" dataformat="engup" name="hndl_ofc_cd" maxlength="5" value="<%=strOfc_cd%>"></td>
						<td>Booking Agent Code&nbsp;</td>
						<td><input type="text" style="width:25" maxlength="2" dataformat="engup" class="input" name="chn_agn_cd" value=""></td>
					</tr>
					<tr class="h23">
					    <td><input type="radio" class="trans" name="rdo_srch_mandatory" value="vvd"></td>
						<td>VVD&nbsp;</td>
						<td><input type="text" style="width:92" maxlength="9" dataformat="eng" class="input" name="vvd" value=""></td>
						<td>T/S Port&nbsp;</td>
						<td><input type="text" style="width:60" class="input" dataformat="engupnum" name="pod_cd" maxlength="5" value=""></td>
						<td>Delivery&nbsp;</td>
						<td style="padding-left:2"><script language="javascript">ComComboObject('delivery',2, 100, '');</script></td>
						<td>Upload Status&nbsp;</td>
						<td style="padding-left:2"><script language="javascript">ComComboObject('bkg_upld_sts_cd',2, 73, '');</script></td>
					</tr>
					<tr class="h23">
						<td colspan="3"></td>
						<td>POD&nbsp;</td>
						<td><input type="text" style="width:60" class="input" dataformat="engupnum" name="bkg_pod_cd" maxlength="5" value=""></td>
						<td>Doc Type&nbsp;</td>
						<td style="padding-left:2"><script language="javascript">ComComboObject('doc_tp_cd',2, 90, '');</script></td>
						<td>Request Status&nbsp;</td>
						<td style="padding-left:2"><script language="javascript">ComComboObject('xter_bkg_rqst_sts_cd',2, 120, '');</script></td>
					</tr>
				</table>
				<!--  biz_1   (E) -->
			</td></tr>
		</table>

		<table class="height_8"><tr><td></td></tr></table>

		<!-- Grid BG Box  (S) -->
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

			<table class="height_8"><tr><td></td></tr></table>
			<table class="search" border="0">
				<tr class="h23">
					<td align="right">TEU&nbsp;</td>
					<td align="left"><input name="tot_teu" type="text" style="width:70; text-align:right" class="input2" readOnly value="0" dataformat="float" pointcount="2"></td>
					<td align="right">FEU&nbsp;</td>
					<td align="left"><input name="tot_feu" type="text" style="width:70; text-align:right" class="input2" readOnly value="0" dataformat="float" pointcount="2"></td>
					<td align="right">TTL(TEU)&nbsp;</td>
					<td align="left"><input name="tot_ttl" type="text" style="width:80; text-align:right" class="input2" readOnly value="0" dataformat="float" pointcount="2"></td>
					<td align="right">WGT&nbsp;</td>
					<td align="left"><input name="tot_wgt" type="text" style="width:100; text-align:right" class="input2" readOnly value="0" dataformat="float" pointcount="2">&nbsp;Ton</td>
					<td align="right">Uploaded Vol.(TEU)&nbsp;</td>
					<td align="left"><input name="tot_uld" type="text" style="width:80; text-align:right" class="input2" readOnly value="0" dataformat="int"></td>
					<td align="right">Un-uploaded Vol.(TEU)&nbsp;</td>
					<td align="left"><input name="tot_unu" type="text" style="width:80; text-align:right" class="input2" readOnly value="0" dataformat="int"></td>
				</tr>
			</table>

			<table class="height_8"><tr><td></td></tr></table>

			<!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       	<tr>
	       	<td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0">
					<tr>						
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_save_remark">Save Remark(s)]</td>
						<td class="btn2_right"></td>
						</tr></table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_confirm">Confirm</td>
						<td class="btn2_right"></td>
						</tr></table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_reject">Reject</td>
						<td class="btn2_right"></td>
						</tr></table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_undo">Undo</td>
						<td class="btn2_right"></td>
						</tr></table></td>
  					</tr>			
				</table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
			</td></tr>
		</table>
	<!-- Grid BG Box  (S) -->
	<!--biz page (E)-->
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top: 5; , padding-bottom: 10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_retrieve">Retrieve</td>
					<td class="btn1_right"></td></tr></table></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_new">New</td>
					<td class="btn1_right"></td></tr></table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_exceldown">Down Excel</td>
					<td class="btn1_right"></td></tr></table></td>
			</tr>
			</table>
		</td></tr>
		</table>
    <!--Button (E) -->
	</td></tr>
</table>
</form>
</body>
</html>
