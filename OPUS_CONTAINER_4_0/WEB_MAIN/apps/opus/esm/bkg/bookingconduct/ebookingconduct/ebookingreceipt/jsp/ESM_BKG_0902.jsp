<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0902.jsp
*@FileTitle  : e-Booking & S/I Reject
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/29
=========================================================*/
%>


<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.event.EsmBkg0902Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.List" %>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.*" %>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO" %>
<%@ page import="com.clt.apps.opus.esm.bkg.common.*" %>

<%
	EsmBkg0902Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//occurring error in server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//list count of DB resultSet 

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_eml		= "";
	String docTpCd			= "";
	String xterBkgRqstStsCd = "";
	Logger log = Logger.getLogger("com.clt.apps.EBookingConduct.EBookingReceipt");

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

		//When initial screen loading, adding logic extrat data obtained from the server.
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		xterRqstNoVO = (XterRqstNoVO) eventResponse.getCustomData("xterRqstNoVO");
		reject_reason_cd = (List<BkgComboVO>) eventResponse.getCustomData("reject_reason_cd");
		cntcEml = (String) eventResponse.getCustomData("cntc_eml");
		docTpCd = (String) eventResponse.getCustomData("docTpCd");
		
		xterBkgRqstStsCd = (String) eventResponse.getCustomData("xterBkgRqstStsCd");
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form">
	<input type="hidden" name="f_cmd" id="f_cmd">
	<input type="hidden" name="pagerows" id="pagerows">
	<input type="hidden" name="sender_id" id="sender_id" value="<%=xterRqstNoVO.getSenderId()%>">
	<input type="hidden" name="usr_eml" id="usr_eml" value="<%=strUsr_eml%>">
	<input type="hidden" name="bl_prf_shpr_flg" id="bl_prf_shpr_flg" value="<%=xterRqstNoVO.getBlPrfShprFlg()%>">
	<input type="hidden" name="doc_tp_cd" id="doc_tp_cd" value="<%=docTpCd%>">
	<input type="hidden" name="xter_bkg_rqst_sts_cd" id="xter_bkg_rqst_sts_cd" value="<%=xterBkgRqstStsCd%>">
<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	
		<!-- page_title(S) -->
		<h2 class="page_title"><span>e-Booking & SI Reject</span></h2>
		<!-- page_title(E) -->
		
		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn">
			<button type="button" id="btn_OK" name="btn_OK" class="btn_accent">OK</button><!--
			--><button type="button" id="bt_Close" name="bt_Close" class="btn_normal">Close</button><!--
			--></div>
		<!-- opus_design_btn (E) -->
		
	</div>
	<!-- page_title_area(E) -->
</div>
<div class="layer_popup_contents">
	<div class="wrap_search">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit">
			<table>
				<colgroup>
					<col width="100"/>
					<col width="100"/>
					<col width="30"/>
					<col width="20"/>
					<col width="70"/>
					<col width="*" />				
				</colgroup> 
				<tr>
					<th>Request No.</th>
					<td><input id="rqst_no" name="rqst_no" style="width:100px;" class="input2" value="<%=xterRqstNoVO.getRqstNo()%>" readonly type="text" /> </td>
					<th>Seq.</th>
					<td><input id="rqst_seq" name="rqst_seq" style="width:20px;text-align:center" class="input2" value="<%=xterRqstNoVO.getRqstSeq()%>" readonly type="text" /> </td>
					<th>Booking No.</th>
					<td><input id="bkg_no" name="bkg_no" style="width:100px;" class="input2" value="<%=xterRqstNoVO.getBkgNo()%>" readonly type="text" /> </td>
				</tr>
			</table>
			<table>
				<colgroup>
					<col width="100"/>
					<col width="*" />				
				</colgroup> 
				<tr>
					<th>E-Mail</th>
					<td><input type="text" id="cntc_eml" name="cntc_eml" style="width: 100%;" value="<%=cntcEml%>" ></td>
				</tr>
				<tr>
					<th>Reject Reason</th>
					<td><%=HTMLUtil.getComboString("reject_reason_cd", "width:99%;", "","changeReason","","", reject_reason_cd)%></td>
				</tr>
			</table>
			<table>
				<colgroup>
					<col width="*" />				
				</colgroup> 
				<tr>
					<td>
				  		<textarea name="reject_reason" style="width:100%;height:250px">
Thank you for shipping with NYK Line!	
<% if(docTpCd.equals("S")){ %><% if(xterRqstNoVO.getRqstSeq().equals("1")){ %>
Your new shipping instruction for the following shipment has been rejected

Request Number : {?rqst_no}
NYK Booking Number : {?bkg_no}
NYK Comments to Customer : 
Rejection Reason : 

<% }else{ %>
Your shipping instruction change request for the following shipment has been rejected

Request Number : {?rqst_no}
NYK Booking Number : {?bkg_no}
NYK Comments to Customer : 
Rejection Reason : 

<% } %>
<%} else if(docTpCd.equals("U")){ %>
Your Bill if Lading change request for the following shipment has been rejected.

Request Number : {?rqst_no}
NYK Booking Number : {?bkg_no}
NYK Comments to Customer : 
Rejection Reason : 

<%} else{ %><% if(xterBkgRqstStsCd.equals("X")){ %>
Your booking cancellation request for the following shipment has been rejected.

Request Number : {?rqst_no}
NYK Booking Number : {?bkg_no}
NYK Comments to Customer : 
Rejection Reason : 

	<% }else{ %><% if(xterRqstNoVO.getRqstSeq().equals("1")){ %>
Your booking request for the following shipment has been rejected.

Request Number : {?rqst_no}
NYK Booking Number : {?bkg_no}
NYK Comments to Customer : 
Rejection Reason : 

	<% }else{ %>
Your booking change request for the following shipment has been rejected.

Request Number : {?rqst_no}
NYK Booking Number : {?bkg_no}
NYK Comments to Customer : 
Rejection Reason : 

	<% } %>
<% } %>
<%} %>
To access NYK Group on-line, please go to http://www.nykline.com 
Please contact your local NYK Line office if you need any assistance.

Thank you for shipping with NYK Line. 

*** NOTE - Please do not respond to this email.***
						</textarea>
	          		</td>
				</tr>
			</table>
			Will you send reject notification to you customer? <input type="radio" name="eml_snd_yn" value="Y" checked="checked">Yes     <input type="radio" name="eml_snd_yn" value="N" >No
		</div>
		<!-- opus_design_inquiry(E) -->
		
		
	</div>

	<div class="wrap_result" style="display:none">
	
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
		<!-- opus_design_grid(E) -->
		
	</div>
</div>
</form>
