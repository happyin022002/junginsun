<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_2103_01.jsp
*@FileTitle : Spot Guide RFA Creation - Special Note
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.09
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2009.08.09 최성민
* 1.0 Creation
=========================================================
* History
* 2014.03.31 서미진 [CHM-201429599] RFA Conversion 상 S/I Column 추가
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
<%@ page import="com.hanjin.apps.alps.esm.pri.rfaproposal.rfanoteproposal.event.EsmPri200301Event"%>

<%@ page import="com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.common.PRIUtil"%>
<%@ page import="java.util.List"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmPri200301Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	
	String[] srcInfoCd = null;		    //SOURCE
	String[] prcProgStsCd = null;		//STATUS
	String[] rtApplTpCd = null;		    //APLICATION
	String[] bkgPrcCgoTpCd = null;    	//CARGO TYPE
	String[] rtOpCd = null;    			//CAL.
	String[] payTermCd = null;    		//PAY TERM
	String[] bkgHngrBarTpCd = null;    	//US SVC MODE
	String[] bkgRatUtCd = null;			//PER TYPE
	String[] currCd = null;				//CURRENCY
	String[] bkgEsvcTpCd = null;		//S/I
	//String[] ruleCd = null;				//NOTE CONVERSION RULE CODE 
	//String[] chargeCd = null;    		//SCOPE CHARGE CODE LIST
	
	
	Logger log = Logger.getLogger("com.hanjin.apps.SCProposal.SCNoteProposal");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmPri200301Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		//COMMBO LIST
		srcInfoCd 		= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("SRC_INFO_CD"), false);
		prcProgStsCd 	= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("PRC_PROG_STS_CD"), false);
        rtApplTpCd 		= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("RT_APPL_TP_CD"), false);
        bkgPrcCgoTpCd 	= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("BKG_PRC_CGO_TP_CD"), false);       
        rtOpCd 			= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("RT_OP_CD"));      
        payTermCd 		= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("PAY_TERM_CD"), false);      
        bkgHngrBarTpCd 	= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("BKG_HNGR_BAR_TP_CD"), false);       
        bkgRatUtCd 		= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("BKG_RAT_UT_CD"), false);      
        currCd 			= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("CURR_CD"), false);     
        bkgEsvcTpCd     = PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("BKG_ESVC_TP_CD"), false);     
        //ruleCd 			= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("RULE_CD"));       
        //chargeCd 		= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("CHARGE_CD"));
        
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

	var rtApplTpCdComboValue = " |<%=rtApplTpCd[0]%>";
    var rtApplTpCdComboText = " |<%=rtApplTpCd[1]%>";

    var bkgPrcCgoTpCdComboValue = " |<%=bkgPrcCgoTpCd[0]%>";
    var bkgPrcCgoTpCdComboText = " |<%=bkgPrcCgoTpCd[1]%>";
        
    var rtOpCdComboValue = "<%=rtOpCd[0]%>";   
    var rtOpCdComboText = "<%=rtOpCd[1]%>";

    var payTermCdComboValue = " |<%=payTermCd[0]%>";   
    var payTermCdComboText = " |<%=payTermCd[1]%>";
    
    var bkgHngrBarTpCdComboValue = " |<%=bkgHngrBarTpCd[0]%>";   
    var bkgHngrBarTpCdComboText = " |<%=bkgHngrBarTpCd[1]%>";
    
    var bkgRatUtCdComboValue = " |<%=bkgRatUtCd[0]%>";   
    var bkgRatUtCdComboText = " |<%=bkgRatUtCd[1]%>";
    
    var currCdComboValue = "<%=currCd[0]%>";   
    var currCdComboText = "<%=currCd[1]%>";
    
    var bkgEsvcTpCdComboValue = " |<%=bkgEsvcTpCd[0]%>";   
    var bkgEsvcTpCdComboText = " |<%=bkgEsvcTpCd[1]%>";
<%--       
    var chargeRuleCdComboValue = " |<%=(chargeCd[0].length()>0)? ruleCd[0]+"|"+chargeCd[0]:ruleCd[0]%>";   
    var chargeRuleCdComboText = " |<%=(chargeCd[0].length()>0)? ruleCd[1]+"|"+chargeCd[1]:ruleCd[1]%>";  
--%>    
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
<input type="hidden" name="master_del_chk">
<input type="hidden" name="amend_func"> <!-- 버튼기능 -->

<input type="hidden" name="note_ctnt_seq">
<input type="hidden" name="note_conv_mapg_id">

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
		<!--
		<table class="height_8">
			<tr>
				<td></td>
			</tr>
		</table>
		-->
		<!--Button (E) --> <!--Grid (s)-->
		<table width="100%" id="mainTable">
			<tr>
				<td width="100%"><script language="javascript">ComSheetObject('sheet1');</script>
				</td>
			</tr>
		</table>
		<!--Grid (E)-->
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
				
		<!--Grid (s)-->
		<table width="100%" id="mainTable">
			<tr>
				<td width="100%"><script language="javascript">ComSheetObject('sheet2');</script>
				</td>
			</tr>
		</table>
		<!--Grid (E)-->
		<!--

		<table class="search" border="0">
			<tr>
				<td><textarea class="textarea2"
					style="width: 100%; height: 40;">Rates apply to all goods transported by Carrier under the Agreement, whether in a mixed or straight load, including but not limited to Goods transported at the request of, for the benefit of, or paid for by any affiliate or member.</textarea></td>
			</tr>
		</table>
		
		--><!--  Button_Sub (S) -->
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
		<!-- Button_Sub (E) -->



		<table class="line_bluedot">
			<tr>
				<td colspan="6"></td>
			</tr>
		</table>

		<table class="search" border="0">
			<tr>
				<td class="title_h"></td>
				<td class="title_s">Conversion</td>
			</tr>
		</table>
		<!--Grid (s)-->
		<table width="100%" id="mainTable">
			<tr>
				<td width="100%"><script language="javascript">ComSheetObject('sheet3');</script>
				</td>
			</tr>
		</table>
		<!--Grid (E)--> <!--  Button_Sub (S) -->
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
								<td class="btn2" name="btn_copy">Copy</td>
								<td class="btn2_right"></td>
							</tr>
						</table>
						</td>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn2_left"></td>
								<td class="btn2" name="btn_paste">Paste</td>
								<td class="btn2_right"></td>
							</tr>
						</table>
						</td>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn2_left"></td>
								<td class="btn2" name="btn_rowadd3">Row&nbsp;Add</td>
								<td class="btn2_right"></td>
							</tr>
						</table>
						</td>

						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn2_left"></td>
								<td class="btn2" name="btn_rowcopy">Row&nbsp;Copy</td>
								<td class="btn2_right"></td>
							</tr>
						</table>
						</td>

						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn2_left"></td>
								<td class="btn2" name="btn_delete3">Delete</td>
								<td class="btn2_right"></td>
							</tr>
						</table>
						</td>

					</tr>
				</table>
				</td>
			</tr>
		</table>
		<!-- Button_Sub (E) --></td>
	</tr>
</table>
<!-- Grid BG Box  (S) -->

<table class="height_8">
	<tr>
		<td></td>
	</tr>
</table>





<!-- 개발자 작업  끝 --></form>
</body>
</html>