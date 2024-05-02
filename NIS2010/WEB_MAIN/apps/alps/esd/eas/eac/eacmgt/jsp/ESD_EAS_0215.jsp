<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ESD_EAS_0211.jsp
*@FileTitle : Expense Audit Case
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.29
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2014.10.29 백형인
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
<%@ page import="com.hanjin.apps.alps.esd.eas.eac.eacmgt.event.EsdEas0211Event"%>
<%@ page import="com.hanjin.framework.component.util.StringUtil" %>

<%
	EsdEas0211Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지

	String pageRows  = "100";

	// SignOnUserAccount Info
	String usr_id 					= "";
	String strUsr_nm				= "";
	String ofc_cd					= "";
	String eac_no				= StringUtil.xssFilter(request.getParameter("EAC_NO"))!=null&&!StringUtil.xssFilter(request.getParameter("EAC_NO")).equals("")?StringUtil.xssFilter(request.getParameter("EAC_NO")):""; 
// 	String eac_eml_use_flg		    = request.getParameter("EAC_EML_USE_FLG")!=null&&!request.getParameter("EAC_EML_USE_FLG").equals("")?request.getParameter("EAC_EML_USE_FLG"):""; 
// 	String eac_fax_use_flg		    = request.getParameter("EAC_FAX_USE_FLG")!=null&&!request.getParameter("EAC_FAX_USE_FLG").equals("")?request.getParameter("EAC_FAX_USE_FLG"):""; 
// 	String eml_subj_ctnt		    = request.getParameter("EML_SUBJ_CTNT")!=null&&!request.getParameter("EML_SUBJ_CTNT").equals("")?request.getParameter("EML_SUBJ_CTNT"):""; 
// 	String eml_ctnt				    = request.getParameter("EML_CTNT")!=null&&!request.getParameter("EML_CTNT").equals("")?request.getParameter("EML_CTNT"):""; 
// 	String ntc_cc_rcv_eml		    = request.getParameter("NTC_CC_RCV_EML")!=null&&!request.getParameter("NTC_CC_RCV_EML").equals("")?request.getParameter("NTC_CC_RCV_EML"):""; 
// 	String vndr_eml		   		    = request.getParameter("VNDR_EML")!=null&&!request.getParameter("VNDR_EML").equals("")?request.getParameter("VNDR_EML"):""; 
// 	String phn_no		 		    = request.getParameter("PHN_NO")!=null&&!request.getParameter("PHN_NO").equals("")?request.getParameter("PHN_NO"):""; 
// 	String fax_no		  		    = request.getParameter("FAX_NO")!=null&&!request.getParameter("FAX_NO").equals("")?request.getParameter("FAX_NO"):""; 
// 	String vndr_lgl_eng_nm		  		    = request.getParameter("VNDR_LGL_ENG_NM")!=null&&!request.getParameter("VNDR_LGL_ENG_NM").equals("")?request.getParameter("VNDR_LGL_ENG_NM"):""; 
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_nm 			= account.getUsr_nm();
		usr_id       		= account.getUsr_id();      
		ofc_cd      		= account.getOfc_cd();    

		event = (EsdEas0211Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
	
%>
<html>
<head>
<title>Expense Audit Case</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="/hanjin/rpt/script/rdviewer50.js"></script>
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
<input type="hidden" name="rd_param">
<input type="hidden" name="rd_path">
<input type="hidden" name="rd_name">
<input type="hidden" name="eac_no" 		    value = "<%=eac_no%>">
<input type="hidden" name="usr_id" 		    value = "<%=usr_id%>">
<input type="hidden" name="ofc_cd" 		    value = "<%=ofc_cd%>">
<%-- <input type="hidden" name="eml_use_flg"	    value = "<%=eac_eml_use_flg%>"> --%>
<%-- <input type="hidden" name="fax_use_flg"	    value = "<%=eac_fax_use_flg%>"> --%>
<%-- <input type="hidden" name="rcvr_eml" 		value = "<%=vndr_eml%>"> --%>
<%-- <input type="hidden" name="rcvr_fax_no"		value = "<%=fax_no%>"> --%>
<%-- <input type="hidden" name="rcvr_name" 		value = "<%=vndr_lgl_eng_nm%>"> --%>
<%-- <input type="hidden" name="rcvr_phn_no"		value = "<%=phn_no%>"> --%>
<%-- <input type="hidden" name="eml_subj_ctnt"   value = "<%=eml_subj_ctnt%>"> --%>
<%-- <input type="hidden" name="eml_ctnt"	    value = "<%=eml_ctnt%>"> --%>

<!-- 개발자 작업	-->
<table width="100%" class="popup" cellpadding="10">
	<tr><td class="top"></td></tr>
	<tr><td valign="top">
		<!--Page Title, Historical (S)-->
		<table width="100%" border="0">
		<tr><td height="79" class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Expense Audit Case</td></tr>
		</table>
		<!--Page Title, Historical (E)-->

		<!--Button (S) -->
	    <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top: 0; padding-bottom: 2;">
		<tr>
			<td class="btn1_bg">
				<table border="0" cellpadding="0" cellspacing="0">
				<tr>
<!-- 					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
							<td class="btn1_left"></td>
							<td class="btn1" name="btng_send" id="btn_retrieve">Send</td>
							<td class="btn1_right"></td>
						</tr>
						</table>
					</td> -->
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
							<td class="btn1_left"></td>
							<td class="btn1" name="btng_print" >Print</td>
							<td class="btn1_right"></td>
						</tr>
						</table>
					</td>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
							<td class="btn1_left"></td>
							<td class="btn1" name="btng_close">Close</td>
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
		 
		<!--biz page (S)-->
		<!-- <table class="search" > 
       	<tr><td class="bg">		
			<table class="search" border="0" style="width: 979;">
				<tr class="h23">
					
					<td width="74">Issue Type</td>
					<td width="70">
						<input type="checkbox" class="trans" name="eac_eml_use_flg" onclick="emlUseFlgChk()">e-Mail
					</td>
					<td width="770">
						<Label><input type="text" class="noinput3" name="eac_eml" style="width: 770; text-align:left;" readonly="readonly"></Label>
					</td>
					<td width="65"></td>
				</tr>
				<tr class="h23">
					
					<td width="74"></td>
					<td width="70">
						<input type="checkbox" class="trans" name="eac_fax_use_flg" onclick="emlFaxFlgChk()">FAX
					</td>
					<td width="770">
						<label><input type="text" class="noinput3" name="eac_fax" style="width: 770; text-align:left;" readonly="readonly"></label>
					</td>
					<td width="65"></td>
				</tr>
			</table>
			<table class="search" border="0" style="width: 979;">
				<tr class="h23">
					
					<td width="100">e-Mail CC</td>
					<td width="300" >
						<input type="text"  style="width:500; text-align:left;" class="input" name="ntc_cc_rcv_eml">
					</td>
					
	              
					<td width="579"></td>
				</tr>
			</table>
			</td>
		</tr>
	</table>  -->

	<!-- TABLE '#D' : ( Search Options ) (S) -->
			<table class="search"><tr><td class="height_10"></td></tr></table>
    	<table class="search">
      	<tr><td class="bg">

			<!-- : ( Seq. ) (S) -->
             <table width="100%" id="mainTable">
                <tr><td>
                     <script language="javascript">ComSheetObject('sheet1');</script>
                </td></tr>
             </table>
			<!-- : ( Seq. ) (E) -->


			<!-- TABLE '#E' : ( Graph BG ) (S) -->
	     	<table border="1" style="width:100%;text-align:center;" height="580" class="grid" >
	       	<tr><td>
				<script language='javascript'>comRdObject('report1');</script>
				</td></tr>
			</table>
			<!-- TABLE '#E' : ( Graph BG ) (E) -->

		</td></tr>
	</table>
	<!-- TABLE '#D' : ( Search Options ) (E) -->

<!-- 개발자 작업  끝 -->
			</td>
		</tr>
	</table>
</form>
</body>
</html>