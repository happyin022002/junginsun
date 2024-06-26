<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_0003_10.jsp
*@FileTitle : S/C Proposal Special Note Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.09
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2009.06.09 최성민
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
<%@ page import="com.hanjin.apps.alps.esm.pri.scproposal.scnoteproposal.event.EsmPri000310Event"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.common.PRIUtil"%>
<%@ page import="java.util.List"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmPri000310Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	
	String[] noteClssCd = null;		//NOTE CLASSIFICATION CODE
	String[] srcInfoCd = null;		//Source
	String[] prcProgStsCd = null;	//Status
	//String[] chargeCd = null;   	//SCOPE CHARGE CODE LIST
				
	Logger log = Logger.getLogger("com.hanjin.apps.SCProposal.SCNoteProposal");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmPri000310Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
	
		//COMMBO LIST
		noteClssCd 		= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("NOTE_CLSS_CD"), false);
		srcInfoCd 		= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("SRC_INFO_CD"), false);
		prcProgStsCd 	= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("PRC_PROG_STS_CD"), false);
       	//chargeCd 		= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("CHARGE_CD"), false);
        
        
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>S/C Proposal Special Note Creation</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	var srcInfoCdComboValue = "<%=srcInfoCd[0]%>";
    var srcInfoCdComboText = "<%=srcInfoCd[1]%>";
    
    var prcProgStsCdComboValue = "<%=prcProgStsCd[0]%>";
    var prcProgStsCdComboText = "<%=prcProgStsCd[1]%>";

	var noteClssCdComboValue = " |<%=noteClssCd[0]%>";
    var noteClssCdComboText = " |<%=noteClssCd[1]%>";

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
<input type="hidden" name="note_tp_cd" value="P">
<input type="hidden" name="lgcy_if_flg">

<input type="hidden" name="master_del_chk" value="N">
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
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_acceptall">Accept All</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_cancelall">Accept Cancel</td>
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




		<table class="search">
			<tr>
				<td class=""><!--  biz_2  (S) -->
				<table width="100%" id="mainTable">
					<tr>
						<td width="100%"><script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>

				<table width="100%" class="button" border="0">
					<tr>
						<td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
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
						</table>
						</td>
					</tr>
				</table>
				<table class="height_10">
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
							<table width="100%" border="0" cellpadding="0" cellspacing="0"
								class="button">
								<tr>
									<td class="btn2_left"></td>
									<td class="btn2" name="btn_amend">Amend</td>
									<td class="btn2_right"></td>
								</tr>
							</table>
							</td>
							<td>
							<table width="100%" border="0" cellpadding="0" cellspacing="0"
								class="button">
								<tr>
									<td class="btn2_left"></td>
									<td class="btn2" name="btn_amendcancel">Amend Cancel</td>
									<td class="btn2_right"></td>
								</tr>
							</table>
							</td>
							<td>
							<table width="100%" border="0" cellpadding="0" cellspacing="0"
								class="button">
								<tr>
									<td class="btn2_left"></td>
									<td class="btn2" name="btn_accept">Accept</td>
									<td class="btn2_right"></td>
								</tr>
							</table>
							</td>
							<td>
							<table width="100%" border="0" cellpadding="0" cellspacing="0"
								class="button">
								<tr>
									<td class="btn2_left"></td>
									<td class="btn2" name="btn_acceptcancel">Accept Cancel</td>
									<td class="btn2_right"></td>
								</tr>
							</table>
							</td>
							</tr>
						</table>
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