<%
/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ESD_TRS_3019.jsp
*@FileTitle : Ocean Feeder Cost Management – Cost Detail
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
===============================================================================
 History
 2012.05.29 변종건 [CHM-201217633] Ocean Feeder Cost Management – Cost Detail 생성
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.trs.costmanage.oceanfeedercostmanage.event.EsdTrs3019Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsdTrs3019Event  event 		= null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;				//서버에서 발생한 에러
	String strErrMsg 			= "";				//에러메세지
	int rowCount	 			= 0;				//DB ResultSet 리스트의 건수

	String successFlag 			= "";
	String codeList  			= "";
	String pageRows  			= "100";

	String strUsr_id			= "";
	String strUsr_nm			= "";

	String costTrfNo			= "";
	String costTrfRoutSeq		= "";
	String fmNodCd				= "";
	String toNodCd				= "";
	String ioBndNm				= "";
	String currCd				= "";
	String ttl_amt20			= "";
	String ttl_amt40			= "";
	String acctTblDiv			= "";

	try {
		costTrfNo			= request.getParameter("cost_trf_no");
		costTrfRoutSeq		= request.getParameter("cost_trf_rout_seq");
		fmNodCd				= JSPUtil.getNull(request.getParameter("fm_nod_cd"));
		toNodCd				= JSPUtil.getNull(request.getParameter("to_nod_cd"));
		ioBndNm				= JSPUtil.getNull(request.getParameter("io_bnd_nm"));
		currCd				= JSPUtil.getNull(request.getParameter("curr_cd"));
		ttl_amt20			= JSPUtil.getNull(request.getParameter("ttlAmt20"));
		ttl_amt40			= JSPUtil.getNull(request.getParameter("ttlAmt40"));
		acctTblDiv			= JSPUtil.getNull(request.getParameter("acct_tbl_div"));
		
		
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsdTrs3019Event)request.getAttribute("Event");
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
<title>Ocean Feeder Cost Management – Cost Detail</title>
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
<input type="hidden" name="trf_no" value="<%=costTrfNo%>">
<input type="hidden" name="trf_rout_seq" value="<%=costTrfRoutSeq%>">
<input type="hidden" name="acct_tbl_div" value="<%=acctTblDiv%>">

<!-- 개발자 작업	-->
<!-- <!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
	<tr>
		<td class="top"></td>
	</tr>
	<tr>
		<td valign="top">
			<!-- : ( Title ) (S) -->
			<table width="100%" border="0">
				<tr>
					<td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Ocean Feeder Cost Management – Cost Detail</td>
				</tr>
			</table>
			<!-- : ( Title ) (E) -->


			<!-- TABLE '#D' : ( Search Options ) (S) -->
			<table class="search">
				<tr>
					<td class="bg">
						<table class="search_in" border="0">
							<tr class="h23">
								<td width="40">From</td>
								<td width="100"><input name="io_bnd_nm" type="text" style="width:70;text-align:center;" class="input2" value="<%=fmNodCd%>" readOnly></td>
								<td width="20">To</td>
								<td width="100"><input name="rd_term" type="text" style="width:70;text-align:center;" class="input2" value="<%=toNodCd%>" readOnly></td>
								<td width="60">Pre/Post</td>
								<td width="100"><input name="rd_term" type="text" style="width:70;text-align:center;" class="input2" value="<%=ioBndNm%>" readOnly></td>
								<td width="60">Currency</td>
								<td width="100"><input name="curr_cd" type="text" style="width:70;text-align:center;" class="input2" value="<%=currCd%>" readOnly></td>
								<td width="120">Total Amount 20'</td>
								<td width="80"><input name="amt20" type="text" style="width:70;text-align:right;" class="input2" value="<%=ttl_amt20%>" readOnly></td>
								<td width="30">40'</td>
								<td width=""><input name="amt40" type="text" style="width:70;text-align:right;" class="input2" value="<%=ttl_amt40%>" readOnly></td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			<!-- TABLE '#D' : ( Search Options ) (E) -->

			<table class="height_10"><tr><td></td></tr></table>

			<!-- TABLE '#D' : ( Gird BG Box ) (S) -->
			<table class="search" border="0">
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
						<!-- : ( Grid ) (E) -->
	
					</td>
				</tr>
			</table>
			<!-- TABLE '#D' : ( Grid BG Box ) (E) -->

			<!-- TABLE '#D' : ( Button : pop ) (S) -->
			<table width="100%" class="sbutton">
		       	<tr>
		       		<td height="71" class="popup">
		       			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
		       				<tr>
		       					<td class="btn3_bg"> 
									<table border="0" cellpadding="0" cellspacing="0">
										<tr>
											<!-- Repeat Pattern -->
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn1_left"></td>
														<td class="btn1" id="btn_downexcel" name="btn_downexcel">Down Excel</td>
														<td class="btn1_right"></td>
													</tr>
												</table>
											</td>
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn1_left"></td>
														<td class="btn1" id="btn_close" name="btn_close">Close</td>
														<td class="btn1_right"></td>
													</tr>
												</table>
											</td>
											<!-- Repeat Pattern -->
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			<!-- TABLE '#D' : ( Button : pop ) (E) -->
		</td>
	</tr>
</table>
<!-- <!-- OUTER - POPUP (E)-->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>