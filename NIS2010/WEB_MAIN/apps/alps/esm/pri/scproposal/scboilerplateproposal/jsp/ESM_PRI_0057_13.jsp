<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_0057_13.jsp
*@FileTitle : Amend History Inquiry - Boiler Plate
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.28
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.05.28 공백진
* 1.0 Creation

2012.02.23 이석준[CHM-201216153-01] S/C Amendment History 화면 기능 개선 요청
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.scproposal.scboilerplateproposal.event.EsmPri005713Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmPri005713Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100"; 

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.SCProposal.SCBoilerPlateProposal");
	
	String propNo = "";
	String amdtSeq = "";
	String preAmdtSeq = "";
	String propStsCd = "";
	String effDt = "";
	String expDt = "";
	String preExpDt = "";
	String sc_no = "";
	String scNo1 = "";
	String scNo2 = "";
		
	String ctrtExpDt = "";
	String ctrtEffDt = "";
	String blplHdrSeq = "";
	String durDupFlg = "";
	//sBlplHdrSeq
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmPri005713Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		propNo = request.getParameter("sPropNo");
		amdtSeq = request.getParameter("sAmdtSeq");	
		preAmdtSeq = request.getParameter("sPreAmdtSeq");
		propStsCd = request.getParameter("sPropStsCd");
		effDt = request.getParameter("sEffDt");
		expDt = request.getParameter("sExpDt"); 
		preExpDt = request.getParameter("sPreExpDt");
		sc_no = request.getParameter("sSc_No");
		ctrtExpDt = request.getParameter("sCtrtExpDt");
		ctrtEffDt = request.getParameter("sCtrtEffDt");
		//sc_no = "TES090001";
		if (sc_no != null && sc_no !="" && sc_no.length() == 9){
			scNo1 = sc_no.substring(0,3);
			scNo2 = sc_no.substring(3,9);
		}
		
	
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title></title>
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
<input type="hidden" name="pre_amdt_seq" value="<%=preAmdtSeq %>">
<input type="hidden" name="prop_sts_cd" value="<%=propStsCd %>">
<input type="hidden" name="pre_exp_dt" value="<%=preExpDt %>">
<input type="hidden" name="eff_dt" value="<%=effDt %>">
<input type="hidden" name="exp_dt" value="<%=expDt %>">
<input type="hidden" name="blpl_seq" >
<input type="hidden" name="blpl_hdr_seq" value="<%=blplHdrSeq %>" >
<input type="hidden" name="prop_no"> 
<input type="hidden" name="amdt_seq"> 
<input type="hidden" name="svc_scp_cd">
<input type="hidden" name="cd">
<input type="hidden" name="sts_cd">
<input type="hidden" name="lgcy_if_flg">
<input type="hidden" name="con_flg">
<!-- OUTER - POPUP (S)tart -->
<table class="search">
	<tr>
		<td class="bg"><!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0"
			cellspacing="0" style="padding-top: 5; , padding-bottom: 10;">
			<tr>
				<td class="btn1_bg">
				<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_Retrieve">Retrieve</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
					</tr>
				</table>
				</td>
			</tr>
		</table>
		<!--Button (E) --> <!--  biz_2  (S) -->


<table class="height_10">
					<tr>
						<td></td>
					</tr>
				</table>

		<table class="search">
			<tr>
				<td class=""><!--  biz_2  (S) -->
				<table width="100%" id="mainTable">
					<tr>
						<td width="100%"><script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>

				
				<table class="line_bluedot">
					<tr>
						<td></td>
					</tr>
				</table>

				<table width="100%" id="mainTable">
					<tr>
						<td width="100%"><script language="javascript">ComSheetObject('sheet2');</script>
						</td>
					</tr>
				</table>

				<!-- Grid (E) --></td>
			</tr>
		</table>

		<!--  biz_2   (E) --></td>
	</tr>
</table>


<!-- 개발자 작업  끝 --></form>
</body>
</html>