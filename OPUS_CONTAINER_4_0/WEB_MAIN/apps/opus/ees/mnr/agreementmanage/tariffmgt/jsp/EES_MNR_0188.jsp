<!-- 
/*========================================================= 
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : EES_MNR_0188.jsp
*@FileTitle : MNR Tariff No Inquiry_Pop Up
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/21
=========================================================*/
 -->

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.mnr.agreementmanage.tariffmgt.event.EesMnr0188Event"%>
<%@ page import="com.clt.framework.component.util.StringUtil" %>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesMnr0188Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Occurred error from server
	String strErrMsg = "";						//Error message
	int rowCount	 = 0;						//Row count of retrieved database data

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	String eq_knd_cd		= "";
	String mnr_trf_sts_cd	= "";
	String vndr_seq			= "";
	if(request.getParameter("ofc_cd")!=null && !request.getParameter("ofc_cd").equals("")) {
		strOfc_cd = StringUtil.xssFilter(request.getParameter("ofc_cd"));
	}
	if(request.getParameter("eq_knd_cd")!=null && !request.getParameter("eq_knd_cd").equals("")) {
		eq_knd_cd = StringUtil.xssFilter(request.getParameter("eq_knd_cd"));
	}
	if(request.getParameter("mnr_trf_sts_cd")!=null && !request.getParameter("mnr_trf_sts_cd").equals("")) {
		mnr_trf_sts_cd = StringUtil.xssFilter(request.getParameter("mnr_trf_sts_cd"));
	}
	String mnr_trf_knd_cd 	= StringUtil.xssFilter(request.getParameter("mnr_trf_knd_cd"));
	if(request.getParameter("vndr_seq")!=null && !request.getParameter("vndr_seq").equals("")) {
		vndr_seq = StringUtil.xssFilter(request.getParameter("vndr_seq"));
	}

	Logger log = Logger.getLogger("com.clt.apps.AgreementManage.TariffMgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		if(strOfc_cd.equals("")||strOfc_cd==null) {
			strOfc_cd = account.getOfc_cd();
		}

		event = (EesMnr0188Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		//Extracting retrieved data from server on load screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

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
<input type="hidden" name="f_cmd">
<input type="hidden" name="mnr_trf_knd_cd" value="<%=mnr_trf_knd_cd %>">
<input type="hidden" name="eq_knd_cd" value="<%=eq_knd_cd %>">
<input type="hidden" name="mnr_trf_sts_cd" value="<%=mnr_trf_sts_cd %>">
<input type="hidden" name="vndr_seq" value="<%=vndr_seq %>">
<input type="hidden" name="pagerows">
<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>M&R Tariff No Inquiry</span></h2>
		
		<div class="opus_design_btn"><!-- 
			 --><button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_New" id="btn_New">New</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_Ok" id="btn_Ok">OK</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button>
		</div>
	</div>
</div>

<div class="layer_popup_contents">
	<div class="wrap_search">
		<div class="opus_design_inquiry wFit">
 			<table> 
 				<colgroup> 
 					<col width="60"> 
 					<col width="140"> 
 					<col width="50"> 
 					<col width="90"> 
 					<col width="70"> 
 					<col width="*"> 
 				</colgroup>  
				<tbody> 
 					<tr> 
 						<th>Tariff Type</th> 
 						<td><script type="text/javascript">ComComboObject('combo1', 1, 110, 1, 1);</script></td>
 						<th>Office</th> 
 						<td><input type="text" name="ofc_cd" id="ofc_cd" style="width:60px;" value="<%= strOfc_cd%>" class="input2" readonly="readonly"></td>
 						<th>Creation Period</th> 
 						<td><input type="text" name="cre_dt_fr" id="cre_dt_fr" style="width:75px;" class="input1" caption="from date" requred dataformat="ymd" maxlength="10" cofield="cre_dt_to">
 						    <input type="text" name="cre_dt_to" id="cre_dt_to" style="width:75px;" class="input1" caption="to date" requred dataformat="ymd" maxlength="10" cofield="cre_dt_fr"> 
 						    <button type="button" class="calendar" name="cre_dt_cal" id="cre_dt_cal"></button>
 			          	</td> 
 					</tr> 
 				</tbody> 
 			</table>
		</div>
	</div>
	<div class="wrap_result">
		<div class="opus_design_grid" >
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
	</div>
</div>
</form>