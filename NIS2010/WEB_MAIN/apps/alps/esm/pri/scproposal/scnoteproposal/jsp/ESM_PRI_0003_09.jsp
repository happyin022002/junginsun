<%/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_PRI_0003_09.jsp
 *@FileTitle : S/C Proposal Standard Note Creation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.04
 *@LastModifier : 최성민
 *@LastVersion : 1.0
 * 2009.06.04 최성민
 * 1.0 Creation
 =========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.scproposal.scnoteproposal.event.EsmPri000309Event"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.common.PRIUtil"%>
<%@ page import="java.util.List"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmPri000309Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지
	int rowCount = 0; //DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";

	String[] srcInfoCd = null;		//Source
	String[] prcProgStsCd = null;	//Status
	
	Logger log = Logger.getLogger("com.hanjin.apps.SCProposal.SCNoteProposal");

	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmPri000309Event) request.getAttribute("Event");
		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request
				.getAttribute("EventResponse");

		//COMMBO LIST
		srcInfoCd 		= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("SRC_INFO_CD"), false);
		prcProgStsCd 	= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("PRC_PROG_STS_CD"), false);
	} catch (Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>S/C Proposal Standard Note Creation</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	var srcInfoCdComboValue = "<%=srcInfoCd[0]%>";
    var srcInfoCdComboText = "<%=srcInfoCd[1]%>";
    
    var prcProgStsCdComboValue = "<%=prcProgStsCd[0]%>";
    var prcProgStsCdComboText = "<%=prcProgStsCd[1]%>";

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<body onLoad="setupPage();">
<form name="form"><input type="hidden" name="f_cmd"> 
<input type="hidden" name="pagerows"> 
<!-- 개발자 작업	--> 
<input type="hidden" name="prop_no"> 
<input type="hidden" name="amdt_seq"> 
<input type="hidden" name="svc_scp_cd">
<input type="hidden" name="pre_amdt_seq"> 
<input type="hidden" name="prop_sts_cd"> 
<input type="hidden" name="eff_dt">
<input type="hidden" name="exp_dt"> 
<input type="hidden" name="pre_exp_dt"> 
<input type="hidden" name="cd"> 
<input type="hidden" name="req_usr_flg"> 
<input type="hidden" name="apro_usr_flg"> 
<input type="hidden" name="dur_dup_flg">
<input type="hidden" name="note_seq"> 
<input type="hidden" name="note_tp_cd" value="T">
<input type="hidden" name="lgcy_if_flg">

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
								<td class="btn1" name="btn_delete">Delete</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>						
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_deletecancel">Delete Cancel</td>
								<td class="btn1_right"></td>
							</tr>
						</table>						
						</td>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_glinecopy">G/L Copy</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<!--<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_t6acceptall">Accept All</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>-->
					</tr>
				</table>
				</td>
			</tr>
		</table>
		<!--Button (E) -->


		<table class="search">
			<tr>
				<td class=""><!--  biz_2  (S) -->
				<table border="0" style="width: 100%;" class="search">
					<tr class="h23">
						<td width="30">Year</td>
						<td width="80"><input type="text" style="width: 50;" name="note_ref_yr" class="input2" readonly="true"></td>
						<td width="90">Standard Note</td>
						<td width="230"><input type="text" style="width: 200;" name="note_nm" class="input2" readonly="true"></td>
						<td width="65">Cust Type</td>
						<td width=""><input type="text" style="width: 200;" name="cust_tp_desc" class="input2" readonly="true"></td>
					</tr>
				</table>

				<table width="100%" id="mainTable">
					<tr>
						<td width="100%"><script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
				<table class="height_8">
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
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>