<%
/*=========================================================
* Copyright(c) 2006 CyberLogitec
* @FileName : ESM_BSA_0122.jsp
* @FileTitle : Other Carrier's Slot Swap Information
* Open Issues :
* Change history :
* @LastModifyDate : 2006.10.26
* @LastModifier : Park Eun Ju
* @LastVersion : 1.0
*  2007-01-18 Kim Jong Beom
*  1.0 최초 생성
=========================================================
' History :
' 2008.05.07 PEJ R200804296325 css 파일 참조 확인 및 수정 요청
* 2009.10.14 남궁진호 ALPS 전환  1.0 Creation
* 2010.10.04 이행지 [CHM-201005758-01] BSA  Architecture 위배사항 수정 (CommonSC)
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.event.EsmBsa0024Event"%>
<%@ page import="com.hanjin.apps.alps.esm.bsa.common.vo.CommonBsaRsVO"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBsa0024Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	
	String cobCrr		= "";
	String sXml = "";
	
	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.BSAManage.BSAManage");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBsa0024Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		CommonBsaRsVO retVo = (CommonBsaRsVO)eventResponse.getCustomData("retVo");
		if (eventResponse != null) {
			cobCrr = "|"+JSPUtil.getNull(retVo.getStrTemp());
		} // end if
		//sXml 	     = JSPUtil.getNull(request.getParameter("sXml"))== null?"": JSPUtil.getNull(request.getParameter("sXml"));
		

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Other Carrier's Slot Swap Information</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage("<%=cobCrr%>");
	}
</script>
</head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd">
<input type="hidden" name="iPage">

<input type="hidden" name = "pBsa_seq">
<input type="hidden" name = "pBsa_fm_dt">
<input type="hidden" name = "pBsa_to_dt">
<input type="hidden" name = "pVsl_capa">
<input type="hidden" name = "pBsa_op_cd">
<input type="hidden" name = "pBsa_op_jb_cd">
<input type="hidden" name = "sRow">
<!--  input type="hidden" name = "chgValueRowNo" -->
<input type="hidden" name = "sXml" value="<%= sXml %>">
<!-- 개발자 작업	-->
<!-- OUTER - POPUP (S)tart -->
<table width="600" class="popup" cellpadding="10">
<tr><td class="top"></td></tr>
<tr><td valign="top">
			<!-- : ( Title ) (S) -->
			<table width="100%" border="0">
			<tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp;Other Carrier's Slot Swap Information</td></tr>
			</table>
			<!-- : ( Title ) (E) -->
			<table class="search">
				<tr>
					<td class="bg">
						<!-- : ( Viewer ) (S) -->
						<table class="search" border="0" style="width:570;">
							<tr class="h23">
								<td width="50">Period</td>
								<td width="190"><input type="text" dataformat="ymd"  style="width:75;text-align:center" name="fm_dt" readOnly> ~
												<input type="text" dataformat="ymd"  style="width:75;text-align:center" name="to_dt" readOnly>
								</td>
								<td width="40">Trade</td>
								<td width="50"><input type="text" style="width:35;text-align:center" name="pTrd_cd" readOnly></td>
								<td width="40">RLane</td>
								<td width="60"><input type="text" style="width:45;text-align:center" name="pRlane_cd" readOnly></td>
								<td width="25">Dir</td>
								<td width="40"><input type="text" style="width:20;text-align:center" name="pDir_cd" readOnly></td>
								<td width="30">OPR</td>
								<td width=""><input type="text" style="width:30;text-align:center" name="pVop_cd" readOnly></td>
							</tr>
						</table>
						<!-- : ( Viewer ) (E) -->
					</td>
				</tr>
			</table>
			<table class="height_10"><tr><td></td></tr></table>
			<!-- : ( Grid BG Box ) (S) -->
			<table class="search">
				<tr>
					<td class="bg">
						<!-- : ( Grid ) (S) -->
						<table width="100%" id="mainTable">
							<tr>
								<td>
									<script language="javascript">ComSheetObject('sheet1');</script>
								</td>
							</tr>
						</table>
						<!-- : ( c ) (E) -->
						<!-- : ( Button : Sub ) (S) -->
						<table width="100%" class="button">
							<tr><td class="btn2_bg">
								<table border="0" cellpadding="0" cellspacing="0">
									<tr>

									<!-- Repeat Pattern -->
									<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn2_left"></td><td class="btn2" name="btng_rowadd" id="btng_rowadd">Row Add</td>
									<td class="btn2_right"></td></tr></table></td>
									<!-- Repeat Pattern -->

									</tr>
								</table>
							</td></tr>
						</table>
						<!-- : ( Button : Sub ) (E) -->
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
<!-- OUTER - POPUP (E)nd -->
<!-- : ( Button : Sub ) (S) -->
<table width="100%" class="sbutton">
		<tr><td height="71" class="popup">

			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
	       		<tr><td class="btn3_bg">
			    <table border="0" cellpadding="0" cellspacing="0">
			    <tr>

					<!-- Repeat Pattern -->
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" name="btn_save" id="btn_save">Save</td><td class="btn1_right"></td></tr></table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" name="btn_close" id="btn_close">Close</td><td class="btn1_right"></td></tr></table></td>
					<!-- Repeat Pattern -->

				</tr>
				</table>
				</td></tr></table>
		</td></tr>
</table>
<!-- : ( Button : Sub ) (E) -->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>
<script language="javascript">
<!--
	with(document.form) {
	<%
	if(event != null){
	%> 
	document.form.pBsa_seq.value	 = "<%= JSPUtil.getNull(request.getParameter("pBsa_seq"))     == null? "": JSPUtil.getNull(request.getParameter("pBsa_seq")     )%>";
	document.form.pTrd_cd.value		 = "<%= JSPUtil.getNull(request.getParameter("pTrd_cd"))      == null? "": JSPUtil.getNull(request.getParameter("pTrd_cd")      )%>";
	document.form.pRlane_cd.value	 = "<%= JSPUtil.getNull(request.getParameter("pRlane_cd"))    == null? "": JSPUtil.getNull(request.getParameter("pRlane_cd")    )%>";
	document.form.pDir_cd.value		 = "<%= JSPUtil.getNull(request.getParameter("pDir_cd"))      == null? "": JSPUtil.getNull(request.getParameter("pDir_cd")      )%>";
	document.form.pVop_cd.value		 = "<%= JSPUtil.getNull(request.getParameter("pVop_cd"))      == null? "": JSPUtil.getNull(request.getParameter("pVop_cd")      )%>";
	document.form.pVsl_capa.value	 = "<%= JSPUtil.getNull(request.getParameter("pVsl_capa"))    == null? "": JSPUtil.getNull(request.getParameter("pVsl_capa")    )%>";
	document.form.pBsa_op_cd.value	 = "<%= JSPUtil.getNull(request.getParameter("pBsa_op_cd"))   == null? "": JSPUtil.getNull(request.getParameter("pBsa_op_cd")   )%>";
	document.form.pBsa_op_jb_cd.value= "<%= JSPUtil.getNull(request.getParameter("pBsa_op_jb_cd"))== null? "": JSPUtil.getNull(request.getParameter("pBsa_op_jb_cd"))%>";
	document.form.pBsa_fm_dt.value	 = "<%= JSPUtil.getNull(request.getParameter("pBsa_fm_dt"))   == null? "": JSPUtil.getNull(request.getParameter("pBsa_fm_dt")   )%>";
	document.form.pBsa_to_dt.value 	 = "<%= JSPUtil.getNull(request.getParameter("pBsa_to_dt"))   == null? "": JSPUtil.getNull(request.getParameter("pBsa_to_dt")   )%>";
	document.form.fm_dt.value	 	 = "<%= JSPUtil.getNull(request.getParameter("pBsa_fm_dt"))   == null? "": JSPUtil.getNull(request.getParameter("pBsa_fm_dt")   )%>";
	document.form.to_dt.value 	     = "<%= JSPUtil.getNull(request.getParameter("pBsa_to_dt"))   == null || JSPUtil.getNull(request.getParameter("pBsa_to_dt")).equals("99991231")?"": JSPUtil.getNull(request.getParameter("pBsa_to_dt"))%>";
	document.form.sRow.value 	     = "<%= JSPUtil.getNull(request.getParameter("sRow"))         == null? "": JSPUtil.getNull(request.getParameter("sRow")         )%>";
	<%
	}
	%>
	ComAddSeparator (document.form.fm_dt);
	ComAddSeparator (document.form.to_dt);
	}

-->
</script>