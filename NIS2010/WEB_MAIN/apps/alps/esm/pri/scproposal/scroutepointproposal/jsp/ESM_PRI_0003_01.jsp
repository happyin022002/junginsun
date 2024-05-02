<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_0003_01.jsp
*@FileTitle : S/C Proposal Org/Dst Location Information - Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.21
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2009.05.21 최성민
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
<%@ page import="com.hanjin.apps.alps.esm.pri.scproposal.scroutepointproposal.event.EsmPri000301Event"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.common.PRIUtil"%>
<%@ page import="java.util.List"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmPri000301Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	
	String[] srcInfoCd = null;		//Source
	String[] prcProgStsCd = null;	//Status
	
	Logger log = Logger.getLogger("com.hanjin.apps.SCProposal.SCRoutePointProposal");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmPri000301Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		//COMMBO LIST
		srcInfoCd 		= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("SRC_INFO_CD"), false);
		prcProgStsCd 	= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("PRC_PROG_STS_CD"), false);
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	var srcInfoCdComboValue = "<%=srcInfoCd[0]%>";
    var srcInfoCdComboText = "<%=srcInfoCd[1]%>";
    
    var prcProgStsCdComboValue = "<%=prcProgStsCd[0]%>";
    var prcProgStsCdComboText = "<%=prcProgStsCd[1]%>";

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
<input type="hidden" name="req_usr_flg">
<input type="hidden" name="apro_usr_flg">
<input type="hidden" name="dur_dup_flg">
<input type="hidden" name="cd">
<input type="hidden" name="lgcy_if_flg">
    			
		<table class="search">
       	<tr><td class="bg">

			<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:;,padding-bottom:10;">
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_acceptall">Accept All</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_cancelall">Accept Cancel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			</tr></table>
		</td></tr>
		</table>
    <!--Button (E) -->



				
					<table border="0" style="width:200;" class="search_sm2">
					<tr class="h23">
						<td width="10%">Route</td>
						<td class="stm" width="">
						<input type="radio" class="trans" name="org_dest_tp_cd"  value="O"  checked="true">&nbsp;<span id="org_dest_tp_cd1">Origin</span>&nbsp;
						<input type="radio" class="trans" name="org_dest_tp_cd" value="D" >&nbsp;<span id="org_dest_tp_cd2">Destination</span>&nbsp;

						</td>
					</tr>
					</table>
				<!-- Grid  (S) -->
							<table width="100%"  id="mainTable">
								<tr>
									<td width="100%">
										<script language="javascript">ComSheetObject('sheet1');</script>
									</td>
								</tr>
							</table>
							
				<!-- Grid (E) -->
							
						<table width="100%" class="button">
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0">
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_rowadd">Row&nbsp;Add</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_delete">Delete</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_amend">Amend</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_amendcancel">Amend Cancel</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_accept">Accept</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_acceptcancel">Accept Cancel</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>

				</table>
			</td></tr>
			</table>

				<!--  biz_2   (E) -->


				</td></tr>
			</table>
			
			<div style="disply:block;">
			<table>
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet2');</script>
					</td>
				</tr>
			</table>
			</div>
							

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>