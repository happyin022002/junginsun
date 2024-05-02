<%
/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ESD_SPE_1022.jsp
*@FileTitle : S/P Help
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.11
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.02.11 백형인
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
<%@ page import="com.hanjin.apps.alps.esd.spe.common.popup.event.EsdSpe1022Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.util.StringUtil" %>

<%
	EsdSpe1022Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.Common.Popup");
	String ev_yr               = StringUtil.xssFilter(request.getParameter("EV_YR"))         !=null&&!StringUtil.xssFilter(request.getParameter("EV_YR")).equals("")         ?StringUtil.xssFilter(request.getParameter("EV_YR")):"";
	String eg_rhq_cd           = StringUtil.xssFilter(request.getParameter("EG_RHQ_CD"))     !=null&&!StringUtil.xssFilter(request.getParameter("EG_RHQ_CD")).equals("")     ?StringUtil.xssFilter(request.getParameter("EG_RHQ_CD")):"";
	String eg_ofc_cd           = StringUtil.xssFilter(request.getParameter("EG_OFC_CD"))     !=null&&!StringUtil.xssFilter(request.getParameter("EG_OFC_CD")).equals("")     ?StringUtil.xssFilter(request.getParameter("EG_OFC_CD")):"";		
	String ev_svc_cate_cd      = StringUtil.xssFilter(request.getParameter("EV_SVC_CATE_CD"))!=null&&!StringUtil.xssFilter(request.getParameter("EV_SVC_CATE_CD")).equals("")?StringUtil.xssFilter(request.getParameter("EV_SVC_CATE_CD")):"";
	String ev_svc_cate_nm      = StringUtil.xssFilter(request.getParameter("EV_SVC_CATE_NM"))!=null&&!StringUtil.xssFilter(request.getParameter("EV_SVC_CATE_NM")).equals("")?StringUtil.xssFilter(request.getParameter("EV_SVC_CATE_NM")):""; 
	String eg_id               = StringUtil.xssFilter(request.getParameter("EG_ID"))         !=null&&!StringUtil.xssFilter(request.getParameter("EG_ID")).equals("")         ?StringUtil.xssFilter(request.getParameter("EG_ID")):"";
	String eg_nm               = StringUtil.xssFilter(request.getParameter("EG_NM"))         !=null&&!StringUtil.xssFilter(request.getParameter("EG_NM")).equals("")         ?StringUtil.xssFilter(request.getParameter("EG_NM")):"";
	String search_type         = StringUtil.xssFilter(request.getParameter("SEARCH_TYPE"))   !=null&&!StringUtil.xssFilter(request.getParameter("SEARCH_TYPE")).equals("")   ?StringUtil.xssFilter(request.getParameter("SEARCH_TYPE")):"";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsdSpe1022Event)request.getAttribute("Event");
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
<title>Evaluation Group Mapping & Basic Evaluation</title>
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
<input type="hidden" name="code_key">
<input type="hidden" name="pagerows">
<input type="hidden" name="sp_seq">
<input type="hidden" name="s_ev_yr"      value="<%=ev_yr%>">
<input type="hidden" name="eg_rhq_cd"      value="<%=eg_rhq_cd%>">
<input type="hidden" name="eg_ofc_cd"      value="<%=eg_ofc_cd%>">
<input type="hidden" name="s_ev_svc_cate_cd" value="<%=ev_svc_cate_cd%>">
<input type="hidden" name="eg_id"          value="<%=eg_id%>">
<input type="hidden" name="search_type"    value="<%=search_type%>">
<!-- 개발자 작업	-->
<table width="100%" class="popup" cellpadding="10"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="580" border="0">
		<tr><td height="79" class="title"><img src="img/icon_title_dot.gif" align="absmiddle"> Service Provider Inquiry</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		
		<!-- TABLE '#D' : ( Search Options : Scenario ID ) (S) -->
		<table class="search"> 
			<tr>
				<td class="bg">

				<!-- : ( Scenario ID ) (S) -->
				<table class="search" border="0" style="width:699;"> 
				<tr class="h23">
                 <% if(search_type.equals("A")){%>
					<td width="71">Level 1</td>
					<td width="50">
						<input type="text" name="s_eg_rhq_cd" style="width:50;ime-mode:disabled" value="<%=eg_rhq_cd%>" readonly="readonly" class="input2"></td>
					<td width="19"></td>
					<td width="62">Level 2</td>
					<td width="88">
						<input type="text" name="s_eg_ofc_cd" style="width:88;ime-mode:disabled" value="<%=eg_ofc_cd%>" readonly="readonly" class="input2"></td>
					<td width="18"></td>
					<td width="62">Level 3</td>
					<td width="206">
						<input type="text" name="ev_svc_cate_cd" style="width:206;ime-mode:disabled" value="<%=ev_svc_cate_nm%>" readonly="readonly" class="input2"></td>
					<td width="123"></td>
				<%}else{%>
					<td width="100">SVC Category</td>
					<td width="200">
						<input type="text" name="ev_svc_cate_cd" style="width:200;ime-mode:disabled" value="<%=ev_svc_cate_nm%>" readonly="readonly" class="input2"></td>
					<td width="399"></td>
					
			    <%}%>
				</tr>
				</table>
								
				<table class="search" border="0" style="width:699;"> 
				<tr class="h23">
					<td width="70">Country</td>
					<td width="70">
						<input type="text" name="cnt_cd" maxlength=2 style="width:50;ime-mode:disabled" dataformat="engup">
					</td>
					<td width="100">Control Office</td>
					<td width="70">
					<input type="text" name="ofc_cd" style="width:50;ime-mode:disabled" maxlength=6 dataformat="engup">
					</td>
					<td width="300">
						<table class="search_sm2" border="0" style="width:90%;"> 
							<tr class="h23">
								<td>S/P Type</td>
								<td class="stm"><input type="radio" name="p_sp_type" value="Y" class="trans" >Logistics&nbsp;&nbsp;&nbsp;<input type="radio" name="p_sp_type" value="" class="trans" checked="checked">All</td>
							</tr>
						</table>
					</td>
					<td width="89"></td>
					</tr>
				</table>
				
				<table class="search" border="0" style="width:699;"> 
				<tr class="h23">
					<td width="70">S/P Code</td>
					<td width="70">
						<input type="text" name="vndr_cd" style="width:50;ime-mode:disabled" maxlength="6"></td>
					<td width="70">S/P Name</td>
					<td width="100">
						<input type="text" name="vndr_nm_eng" style="width:80;ime-mode:disabled"></td>
					<td width="80">Parent Code&nbsp;</td>
					<td width="60">
						<input type="text" name="pts_vndr_cd" style="width:50;ime-mode:disabled" maxlength="6" dataformat="number">
					</td>
					<td width="249"></td>
				</tr>
				</table>
				
				<!-- : ( Scenario ID ) (E) -->
				
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
			
			<!-- : ( Grid ) (S) -->
			<!-- 'HEAD1-BGCOLOR : 203 240 169' , 'HEAD2-BGCOLOR : 222 251 248' , 'BORDER 1-outside : 88 152 164' , 
				 'BORDER 2-inside : 202 226 233' , 'HEAD-FONT : 39 95 101' , 'SELETED ROW BG : 252 255 233' -->
	
					<table width="96%" id="mainTable">
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet1');</script>
                        </td></tr>
		            </table>
			<!-- : ( Grid ) (E) -->
			
				</td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Tab BG Box ) (E) -->
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
								<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
					</td>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
								<td class="btn1" name="btn_New">New</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
					</td>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
								<td class="btn1" name="btn_OK">OK</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
					</td>
					<td class="btn1_line"></td>
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

		
<!-- 개발자 작업  끝 -->

</form>

</body>
</html>
<%@include file="/bizcommon/include/common_alps.jsp"%>