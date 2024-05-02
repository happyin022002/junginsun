<%
/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ESM_PRI_0040.jsp
*@FileTitle : Real Customer Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2011.09.23
*@LastModifier : 서미진
*@LastVersion : 1.0
* 2011.09.23 
* 1.0 Creation
=========================================================
* History
* 2011.11.10 서미진 [CHM-201114405] Location 정보 추가로 입력할 수 있도록 처리
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.scproposal.screalcustomerproposal.event.EsmPri0040Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.List"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.common.PRIUtil"%>
<%@ page import="com.hanjin.framework.component.util.code.CodeInfo"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>

<%
	EsmPri0040Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String propNo = "";	
	String amdtSeq = "";	
	String scNo1 = "";
	String scNo2 = "";
	String custTp = "";
	
	String[] custTpCd = null;	
	String[] scpStsCd = null;
	
	String strUsr_id		= "";
	String strUsr_nm		= "";
	String svcScpCd 		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.SCProposal.SCRealCustomerPoposal");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmPri0040Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
			
		custTpCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("custTypeList"), true ,"|","\t","getCode","getName");		       

		propNo = request.getParameter("prop_no");
		custTp = request.getParameter("cust_tp");
		amdtSeq = request.getParameter("amdt_seq");	
		scNo1 = request.getParameter("Sc_No1");
		scNo2 = request.getParameter("Sc_No2");
		svcScpCd = request.getParameter("svc_scp_cd");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Real Customer Creation</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">

	var custTpCdValue = "<%=custTpCd[0]%>";
	var custTpCdText = "<%=custTpCd[1]%>";
	var svcScpCd = "<%=svcScpCd%>";

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
<input type="hidden" name="cust_tp" value="<%=custTp %>">
<!-- 개발자 작업	-->

<input type="hidden" name="cd">

<!-- OUTER - POPUP (S)tart -->
<table width="980" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Real Customer Creation</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- : ( Search Options ) (S) -->
 
		<table class="search"> 
       		<tr><td class="bg">
				<table class="search" border="0" style="width:500;"> 
				<tr class="h23">
					<td width="50">S/C No.</td>
					<td width="100">
						<input type="text" name="sc_no1" style="width:30;text-align:center;" readonly class="input2" value="<%=scNo1%>">
						<input type="text" name="sc_no2" style="width:55;text-align:center;" readonly class="input2" value="<%=scNo2%>"></td>		
					<td width="55">AMD No.</td>
					<td width="60"><input type="text" name="amdt_seq" style="width:40;text-align:center;" readonly class="input2" value="<%=amdtSeq%>"></td>
					<td width="80">Proposal No.</td>
					<td width="105"><input type="text" name="prop_no" style="width:85;text-align:center;" readonly class="input2" value="<%=propNo%>"></td>
				</table>
		
				<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>

		<!-- : ( Grid ) (S) -->
		<table class="search">
			<tr>
				<td class="bg">
					<!-- : ( Grid ) (S) -->
						<table width="100%" id="mainTable">
							<tr>
								<td width="100%"><script language="javascript">ComSheetObject('sheet1');</script>
								</td>
							</tr>
						</table>
					<!-- : ( Grid ) (E) --> 

				<!-- Hidden sheet for Transaction (S) -->
					<div style="display:none">
						<table>
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('sheet2');</script>
								</td>
							</tr>
						</table>
					</div>					
				<!-- Hidden sheet for Transaction (E) -->	
			
					<!--  Button_Sub (S) -->
					<table width="100%" class="button">
						<tr>
							<td class="btn2_bg">
							<table border="0" cellpadding="0" cellspacing="0">
								<tr>
									<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn2_left"></td>
											<td class="btn2" name="btn_rowadd">Row Add</td>
											<td class="btn2_right"></td>
										</tr>
									</table>
									</td>
	
									<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn2_left"></td>
											<td class="btn2" name="btn_rowdelete">Delete</td>
											<td class="btn2_right"></td>
										</tr>
									</table>
									</td>									
								</tr>
							</table>
							</td>
						</tr>
					</table>
					<!-- Button_Sub (E) -->
				</td>
			</tr>
		</table>
				<!-- : ( Grid ) (E) -->	

			</td></tr>
		</table>
<!-- : ( Search Options ) (E) -->

<table class="height_5"><tr><td></td></tr></table>
		
</td></tr>
</table> 

<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
	<tr>
		<td height="71" class="popup">		
		<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top: 5; , padding-bottom: 10;">
			<tr>
				<td class="btn3_bg">
				<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_retrieve">Retrieve</td>
								<td class="btn1_right">
							</tr>
						</table>
						</td>
						
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_save">Save</td>
								<td class="btn1_right">
							</tr>
						</table>
						</td>

						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_close">Close</td>
								<td class="btn1_right">
							</tr>
						</table>
						</td>
					</tr>
				</table>
				</td>
			</tr>
		</table>
		<!--Button (E) --></td>
	</tr>
</table>
<!-- : ( Button : pop ) (E) -->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>