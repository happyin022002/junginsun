<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_2103_02.jsp
*@FileTitle : Spot Guide RFA Creation  - Location
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.10
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2009.08.10 최성민
* 1.0 Creation
=========================================================
* History
* 2014.09.15 최성환  [CHM-201431899] Guideline RFA 생성 요청
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.rfaproposal.rfagrouplocationproposal.event.EsmPri200302Event"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.common.PRIUtil"%>
<%@ page import="java.util.List"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmPri200302Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	
	String[] orgDestTpCd = null;	//ORI/DST
	String[] srcInfoCd = null;		//SOURCE
	String[] prcProgStsCd = null;	//STATUS
	
	Logger log = Logger.getLogger("com.hanjin.apps.SCProposal.SCGroupLocationProposal");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (EsmPri200302Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		//COMMBO LIST
		orgDestTpCd 	= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("ORG_DEST_TP_CD"), false);
		srcInfoCd 		= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("SRC_INFO_CD"), false);
		prcProgStsCd 	= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("PRC_PROG_STS_CD"), false);
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>RFA Proposal Creation - Location</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	var srcInfoCdComboValue = "<%=srcInfoCd[0]%>";
    var srcInfoCdComboText = "<%=srcInfoCd[1]%>";
    
    var prcProgStsCdComboValue = "<%=prcProgStsCd[0]%>";
    var prcProgStsCdComboText = "<%=prcProgStsCd[1]%>";

	var orgDestTpCdComboValue = "<%=orgDestTpCd[0]%>";
    var orgDestTpCdComboText = "<%=orgDestTpCd[1]%>";
    
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
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
<input type="hidden" name="prop_no">
<input type="hidden" name="amdt_seq">
<input type="hidden" name="svc_scp_cd">
<input type="hidden" name="pre_amdt_seq">
<input type="hidden" name="prop_sts_cd">
<input type="hidden" name="eff_dt">
<input type="hidden" name="exp_dt">
<input type="hidden" name="pre_exp_dt">

<input type="hidden" name="grp_loc_seq">
<input type="hidden" name="req_usr_flg">
<input type="hidden" name="apro_usr_flg">
<input type="hidden" name="dur_dup_flg">

<table class="search">
	<tr>
		<td class="bg"><!--Button (S) -->
		<table width="100%" border="0" class="button" cellpadding="0"
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
								<td class="btn1" name="btn_retrieve">Retrieve</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td class="btn1_line"></td>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_save">Save</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td class="btn1_line"></td>						
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" id="btn_acceptall" 
							class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_acceptall">Accept&nbsp;All</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" id="btn_cancelall"
							class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_cancelall">Accept Cancel</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td>
<!-- 						<table width="100%" border="0" cellpadding="0" cellspacing="0" id="btn_glinecopy"
							class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_glinecopy">G/L&nbsp;Copy</td>
								<td class="btn1_right"></td>
							</tr>
						</table> -->
						</td>												
					</tr>
				</table>
				</td>
			</tr>
		</table>
		
		
		<table class="search">
			<tr>
				<td width="40%" valign="top"><!--grid (s)-->
				<table width="100%" id="mainTable">
					<tr>
						<td width="100%"><script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
				<!--grid button (S)-->
				<table width="100%" class="button">
					<tr>
						<td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0"
									class="button">
									<tr>
										<td class="btn2_left"></td>
										<td class="btn2" name="btn_rowadd1">Row&nbsp;Add</td>
										<td class="btn2_right"></td>
									</tr>
								</table>
								</td>
								<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0"
									class="button">
									<tr>
										<td class="btn2_left"></td>
										<td class="btn2" name="btn_delete1">Delete</td>
										<td class="btn2_right"></td>
									</tr>
								</table>
								</td>
							</tr>
						</table>
						</td>
					</tr>
				</table>
				<!--grid button (E)--></td>
				<td width="5%" align="center"><img src="img/btn_add.gif"
					width="26" height="26" alt="" border="0" align="absmiddle">&nbsp;</td>
				<td width="55%" valign="top"><!--grid (s)-->
				<table width="100%" id="mainTable">
					<tr>
						<td width="100%"><script language="javascript">ComSheetObject('sheet2');</script>
						</td>
					</tr>
				</table>
				<!--grid(E)--> <!--grid button (S)-->
				<table width="100%" class="button">
					<tr>
						<td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0"
									class="button">
									<tr>
										<td class="btn2_left"></td>
										<td class="btn2" name="btn_rowadd2">Row&nbsp;Add</td>
										<td class="btn2_right"></td>
									</tr>
								</table>
								</td>
								<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0"
									class="button">
									<tr>
										<td class="btn2_left"></td>
										<td class="btn2" name="btn_delete2">Delete</td>
										<td class="btn2_right"></td>
									</tr>
								</table>
								</td>
								<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0" id="btn_amend" 
									class="button">
									<tr>
										<td class="btn2_left"></td>
										<td class="btn2" name="btn_amend">Amend</td>
										<td class="btn2_right"></td>
									</tr>
								</table>
								</td>
								<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0" id="btn_amendcancel"
									class="button">
									<tr>
										<td class="btn2_left"></td>
										<td class="btn2" name="btn_amendcancel">Amend&nbsp;Cancel</td>
										<td class="btn2_right"></td>
									</tr>
								</table>
								</td>
								<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0" id="btn_accept"
									class="button">
									<tr>
										<td class="btn2_left"></td>
										<td class="btn2" name="btn_accept">Accept</td>
										<td class="btn2_right"></td>
									</tr>
								</table>
								</td>
								<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0" id="btn_acceptcancel"
									class="button">
									<tr>
										<td class="btn2_left"></td>
										<td class="btn2" name="btn_acceptcancel">Accept&nbsp;Cancel</td>
										<td class="btn2_right"></td>
									</tr>
								</table>
								</td>										
							</tr>
						</table>
						</td>
					</tr>
				</table>
				<!--grid button (E)--></td>
			</tr>
		</table>
		</td>
	</tr>
</table>
<table class="height_10">
	<tr><td colspan="8"></td></tr>
</table>
<div id="hiddenSheetLayer" style="display:none">
<script language="javascript">ComSheetObject('sheet3');</script>
</div>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>