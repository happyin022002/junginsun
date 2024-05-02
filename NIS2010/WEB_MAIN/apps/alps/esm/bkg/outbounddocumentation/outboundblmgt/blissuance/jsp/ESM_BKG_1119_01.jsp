<%
/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ESM_BKG_1119_01.jsp
*@FileTitle : Korea B/L Application Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2011.12.01
*@LastModifier : 김종호
*@LastVersion : 1.0
* 2011.12.01 김종호
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.event.EsmBkg1119Event"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.BlIssRqstVO"%>
<%@ page import="org.apache.log4j.Logger" %>

<%@ page import="java.util.List" %>
<%@ page import="com.hanjin.apps.alps.esm.bkg.common.*" %>

<%
	EsmBkg1119Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	//int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	//String successFlag = "";
	//String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.OutboundBLMgt.BLIssuance");
	String sXml = "";

	// search Init
	//String bkgNo      = "";
	String scrnAuth   = "";

	BlIssRqstVO blIssRqstVO = null;
	String xterRqstNo = "";
	String xterRqstSeq = "";
	String blNo = "";
	String blIssueRqstDt = "";
	String blIssueActualDt = "";
	String blIssueRjctDt = "";
	String rqstRctLocCode = "";
	String bii_vsl_nm = "";
	String locName = ""; //접수지2 ex>접수지1:KRPUS, 접수지2:BUSAN
	String blIssRqstCd = "";
	String rqstBlTpCd = ""; // B/L Type code
	String blType = ""; // B/L Type description
	String blIssStsCd = "";
	/* 신청업체 */
	String rqstCoName = "";
	String rqstUsrEml = "";
	String rqstAtndName = "";
	String rqstPhnNo = "";
	String blRqstRmk = "";

	/* 세금계산서 공급받는자 */
	String taxInvRcvrCoName = "";
	String taxInvRcvrRgstNo = "";
	
	/* 송급업체 */
	String remitCoName = "";
	String remitKndCd = "";
		
	/* 선사계좌 */
	String crrBankName = "";
	String crrBankAcctNo = "";
	String crrRemitAmt = "";
	String crrAcctCurrCode = "";
	String crrRemitDt = "";
	
	/* USA 선사관련 계좌 */
	String crrUsaBankName = "";
	String crrUsaBankAcctNo = "";
	String crrUsaRemitAmt = "";
	String crrUsaRemitDt = "";
	String crrUsaAcctCurrCode = "";
	
	
	String blIssRmk = ""; //Remark
	
	/* 요청사항 */
	String blRcvTpCd = "";
	String mnlBlObrdDt = "";
	String mnlBlIssDt = "";
	String certiExistFlg = "";
	String frtDpFlg = "";
	
	//bl on board dt
	String blObrdDt = "";
	
	try {

	   	SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		if (eventResponse != null) {
			blIssRqstVO = (BlIssRqstVO)eventResponse.getCustomData("blIssRqstVO");
		}
		if (blIssRqstVO != null){
			xterRqstNo = blIssRqstVO.getXterRqstNo();
			xterRqstSeq = blIssRqstVO.getXterRqstSeq();
		    blNo = blIssRqstVO.getBlNo();
		    blIssueRqstDt = blIssRqstVO.getBlIssRqstDt();
			blIssueActualDt = blIssRqstVO.getBlIssueActualDt();
			blIssueRjctDt = blIssRqstVO.getBlIssueRjctDt();
			rqstRctLocCode = blIssRqstVO.getRqstRctLocCd();
			bii_vsl_nm = blIssRqstVO.getBiiVslNm();

			locName = blIssRqstVO.getLocNm(); //접수지2 ex>접수지1:KRPUS, 접수지2:BUSAN
			blIssRqstCd = blIssRqstVO.getBlIssRqstCd(); // Request Code
			rqstBlTpCd = blIssRqstVO.getRqstBlTpCd(); // B/L Type 
			// B/L Type description setting
			 
			if(rqstBlTpCd == "O"){ blType = "Original B/L"; 
			} else if( rqstBlTpCd == "W"){ blType = "Sea Waybill";
			} else if( rqstBlTpCd == "S"){ blType = "Surrender";
			} else { blType = "Unknown"; }

			blIssStsCd = blIssRqstVO.getBlIssStsCd(); //Handling Status
			
			/* 신청업체 */
			rqstCoName = blIssRqstVO.getRqstCoNm();
			rqstUsrEml = blIssRqstVO.getRqstUsrEml();
			rqstAtndName = blIssRqstVO.getRqstAtndNm();
			rqstPhnNo = blIssRqstVO.getRqstPhnNo();
			blRqstRmk = blIssRqstVO.getBlRqstRmk();

			/* 세금계산서 공급받는자 */
			taxInvRcvrCoName = blIssRqstVO.getTaxInvRcvrCoNm();
			taxInvRcvrRgstNo = blIssRqstVO.getTaxInvRcvrRgstNo();
			/* 송급업체 */
			remitCoName = blIssRqstVO.getRemitCoNm();
			remitKndCd = blIssRqstVO.getRemitKndCd();
			/* 선사계좌 */
			crrBankName = blIssRqstVO.getCrrBankNm();
			crrBankAcctNo = blIssRqstVO.getCrrBankAcctNo();
			crrRemitAmt = blIssRqstVO.getCrrRemitAmt();
			crrAcctCurrCode = blIssRqstVO.getCrrAcctCurrCd();
			crrRemitDt = blIssRqstVO.getCrrRemitDt();
			/* USA 선사관련 계좌 */
			crrUsaBankName = blIssRqstVO.getCrrUsaBankNm();;
			crrUsaBankAcctNo = blIssRqstVO.getCrrUsaBankAcctNo();
			crrUsaRemitAmt = blIssRqstVO.getCrrUsaRemitAmt();
			crrUsaRemitDt = blIssRqstVO.getCrrUsaRemitDt();
			crrUsaAcctCurrCode =blIssRqstVO.getCrrUsaAcctCurrCd();
			
			blIssRmk = blIssRqstVO.getBlIssRmk();
			
			/*요청사항*/
			blRcvTpCd = blIssRqstVO.getBlRcvTpCd();
	    	mnlBlObrdDt = blIssRqstVO.getMnlBlObrdDt();
			mnlBlIssDt = blIssRqstVO.getMnlBlIssDt();
		 	certiExistFlg = blIssRqstVO.getCertiExistFlg();
			frtDpFlg = blIssRqstVO.getFrtDpFlg();
			
			//bl onboard dt
			blObrdDt = blIssRqstVO.getBlObrdDt();
			
		    //blIssueUsrId = blIssRqstVO.getBlIssueUsrId();
		//} else {
			//blIssRqstVO = new BlIssRqstVO();
		}
  
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Korea B/L Application Inquiry</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		// 글로벌 변수
		cur_usr_id = "<%=strUsr_id%>";
		scrnAuth = "<%=scrnAuth%>";

		// 화면 초기화
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<body onLoad="setupPage();" onbeforeunload="closePage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="sXml" value="<%=JSPUtil.replace(sXml, "\"", "&quot;")%>">
<input type="hidden" name="form1_bl_iss_sts_cd" value="<%=blIssStsCd %>">
<input type="hidden" name="xter_rqst_no" value="<%=xterRqstNo %>">
<input type="hidden" name="xter_rqst_seq" value="<%=xterRqstSeq %>">
<input type="hidden" name="page_save_yn" value="N">
<input type="hidden" name="rqst_bl_tp_cd" value="<%=rqstBlTpCd %>">
<input type="hidden" name="bl_no" value="<%=blNo %>">
<input type="hidden" name="bl_obrd_dt" value="<%=blObrdDt %>">


<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
<tr>
	<td valign="top">
		<!--Page Title, Historical (S)--> 
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title"> 
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr> 
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Korea B/L Application Inquiry</td></tr> 
			<tr><td>&nbsp;</td></tr>
		</table> 
		<!--Page Title, Historical (E)-->
		
		<!--biz page (S)-->
		<table class="search" style="width:979;"> 
   		<tr><td class="bg">	   		
   		
		<!--  biz_1  (S) -->
		<table class="search" border="0" style="width:979;">
		<tr class="h23">

		<td width="10">&nbsp;</td>
		<td>
				<table border="0" style="width:100%;height:80;background-color:white;" class="grid2">
				<tr class="tr2_head2">
						<td width="5%" class="tr2_head">Master B/L No</td>
						<td align="left" width="12%"><input type="text" id="bl_no" name="form1_bl_no" style="ime-mode:disabled;width:280px;" class="input2" value="<%=blNo %>" readOnly></td>
						<td width="5%">신청일시</td>
						<td align="left" width="12%"><input type="text" id="bl_iss_rqst_dt" name="form1_bl_iss_rqst_dt" style="ime-mode:disabled;width:280px;" class="input2" value="<%=blIssueRqstDt %>" readOnly></td>
				</tr>

				<tr class="tr2_head2">
					<td width="5%">접수지</td>
					<td align="left" width="12%"><input type="text" id="rqst_rct_loc_cd" name="form1_rqst_rct_loc_cd" style="ime-mode:disabled;width:100px;" class="input2" value="<%=rqstRctLocCode %>" readOnly>
					<input type="text" id="loc_nm" name="form1_loc_nm" style="ime-mode:disabled;width:124px;" class="input2" value="<%=locName %>" readOnly>
					<input type="text" id="bl_iss_rqst_cd" name="form1_bl_iss_rqst_cd" style="ime-mode:disabled;width:50px;" class="input2" value="<%=blIssRqstCd %>" readOnly>
					</td>
					<td width="5%">B/L Type</td>
					<td align="left" width="12%"><input type="text" id="bl_type" name="bl_type" style="ime-mode:disabled;width:280px;" class="input2" readOnly></td>
				</tr>
				</table>
		</td>
		<td width="10">&nbsp;</td>
		</tr>
		</table>

		<table class="line_bluedot"><tr><td></td></tr></table>
	
		<table class="search" border="0">
			<tr>
				<td width="10">&nbsp;</td>
				<td class="title_h"></td>
				<td class="title_s">신청업체</td>
			</tr>
		</table>
	
		<table class="search" border="0" style="width:979;">
		<tr class="h23">
		

		<td width="10">&nbsp;</td>
		<td>
				<table border="0" style="width:100%;height:100%;background-color:white;" class="grid2">
					<tr class="tr2_head2">
						<td width="5%">상호</td>
						<td align="left" width="12%"><input type="text" id="rqst_co_nm" name="form1_rqst_co_nm" style="ime-mode:disabled;width:280px;" class="input2" value="<%=rqstCoName %>" readOnly></td>
						<td width="5%" class="tr2_head">E-mail</td>
						<td align="left" width="12%"><input type="text" id="rqst_usr_eml" name="form1_rqst_usr_eml" style="ime-mode:disabled;width:280px;" class="input2" value="<%=rqstUsrEml %>" readOnly></td>
				</tr>
				<tr class="tr2_head2">
					<td width="5%">담당자명</td>
					<td align="left" width="12%"><input type="text" id="rqst_atnd_nm" name="form1_rqst_atnd_nm" style="ime-mode:disabled;width:280px;" class="input2" value="<%=rqstAtndName %>" readOnly></td>
					<td width="5%">전화번호</td>
					<td align="left" width="12%"><input type="text" id="rqst_phn_no" name="form1_rqst_phn_no" style="ime-mode:disabled;width:280px;" class="input2" value="<%=rqstPhnNo %>" readOnly></td>
				</tr>
				<!-- tr class="tr2_head2">
					<td width="5%">요청사항</td>
					<td align="left" width="12%" colspan=3><textarea style="width:94%;overflow-y:auto;background-color:E8E7EC" rows="2" id="bl_rqst_rmk" name="form1_bl_rqst_rmk" readOnly><%=blRqstRmk %></textarea></td>
				</tr-->
				</table>
		</td>
		<td width="10">&nbsp;</td>
		</tr>
		</table>

		<table class="height_5"><tr><td></td></tr></table>

		<table class="search" border="0">
			<tr>
				<td width="10">&nbsp;</td>
				<td class="title_h"></td>
				<td class="title_s">세금계산서 공급 받는자</td>
			</tr>
		</table>

		<table class="search" border="0" style="width:979;">
		<tr class="h23">

		<td width="10">&nbsp;</td>
		<td>
				<table border="0" style="width:100%;height:100%;background-color:white;" class="grid2">
					<tr class="tr2_head2">
						<td width="5%">상호</td>
						<td align="left" width="12%"><input type="text" id="tax_inv_rcvr_co_nm" name="form1_tax_inv_rcvr_co_nm" style="ime-mode:disabled;width:280px;" class="input2" value="<%=taxInvRcvrCoName %>" readOnly></td>
						<td width="5%">사업자번호</td>
						<td align="left" width="12%"><input type="text" id="tax_inv_rcvr_rgst_no" name="form1_tax_inv_rcvr_rgst_no" style="ime-mode:disabled;width:280px;" class="input2" value="<%=taxInvRcvrRgstNo %>" readOnly></td>
					</tr>
				</table>
		</td>
		<td width="10">&nbsp;</td>
		</tr>
		</table>

		<!-- 송금업체 Start-->
		<table class="height_5"><tr><td colspan="8"></td></tr></table>

		<table class="search" border="0">
			<tr>
				<td width="10">&nbsp;</td>
				<td class="title_h"></td>
				<td class="title_s">송금업체</td>
			</tr>
		</table>

		<table class="search" border="0" style="width:979;">
		<tr class="h23">

		<td width="10">&nbsp;</td>
		<td>
				<table border="0" style="width:100%;height:100%;background-color:white;" class="grid2">
					<tr class="tr2_head2">
						<td width="5%">상호</td>
						<td align="left" width="12%"><input type="text" id="remit_co_nm" name="form1_remit_co_nm" style="ime-mode:disabled;width:280px;" class="input2" value="<%=remitCoName %>" readOnly></td>
						<td width="5%">송금방법</td>
						<td align="left" width="12%"><input type="text" id="remit_knd_cd" name="form1_remit_knd_cd" style="ime-mode:disabled;width:280px;" class="input2" value="<%=remitKndCd %>" readOnly>
					</tr>
				</table>
		</td>
		<td width="10">&nbsp;</td>
		</tr>
		</table>
		<!-- 송금업체 End-->
		
		<!-- 선사계좌 Start-->
		<table class="height_5"><tr><td colspan="8"></td></tr></table>

		<table class="search" border="0">
			<tr>
				<td width="10">&nbsp;</td>
				<td class="title_h"></td>
				<td class="title_s">선사계좌 (KRW)</td>
			</tr>
		</table>

		<table class="search" border="0" style="width:979;">
		<tr class="h23">

		<td width="10">&nbsp;</td>
		<td>
				<table border="0" style="width:100%;height:100%;background-color:white;" class="grid2">
					<tr class="tr2_head2">
						<td width="5%">입금은행</td>
						<td align="left" width="12%"><input type="text" id="crr_bank_nm" name="form1_crr_bank_nm" style="ime-mode:disabled;width:280px;" class="input2" value="<%=crrBankName %>" readOnly></td>
						<td width="5%">계좌번호</td>
						<td align="left" width="12%"><input type="text" id="crr_bank_acct_no" name="form1_crr_bank_acct_no" style="ime-mode:disabled;width:280px;" class="input2" value="<%=crrBankAcctNo %>" readOnly></td>
					</tr>
					<tr class="tr2_head2">
						<td width="5%">송금금액</td>
						<td align="left" width="12%"><input type="text" id="crr_remit_amt" name="form1_crr_remit_amt" style="ime-mode:disabled;width:280px;" class="input2" value="<%=crrRemitAmt %>" readOnly>
						<input type="text" id="crr_acct_curr_cd" name="form1_crr_acct_curr_cd" style="ime-mode:disabled;width:40px;" class="input2" value="<%=crrAcctCurrCode %>" readOnly></td>
						<td width="5%">송금일자</td>
						<td align="left" width="12%"><input type="text" id="crr_remit_dt" name="form1_crr_remit_dt" style="ime-mode:disabled;width:280px;" class="input2" value="<%=crrRemitDt %>" readOnly></td>
					</tr>
				</table>
		</td>
		<td width="10">&nbsp;</td>
		</tr>
		</table>
		
		<!-- 선사계좌 End-->
		
		<!-- USA선사계좌 Start-->
		<table class="height_5"><tr><td colspan="8"></td></tr></table>

		<table class="search" border="0">
			<tr>
				<td width="10">&nbsp;</td>
				<td class="title_h"></td>
				<td class="title_s">선사계좌 (USD)</td>
			</tr>
		</table>

		<table class="search" border="0" style="width:979;">
		<tr class="h23">

		<td width="10">&nbsp;</td>
		<td>
				<table border="0" style="width:100%;height:100%;background-color:white;" class="grid2">
					<tr class="tr2_head2">
						<td width="5%">입금은행</td>
						<td align="left" width="12%"><input type="text" id="crr_usa_bank_nm" name="form1_crr_usa_bank_nm" style="ime-mode:disabled;width:280px;" class="input2" value="<%=crrUsaBankName %>" readOnly></td>
						<td width="5%">계좌번호</td>
						<td align="left" width="12%"><input type="text" id="crr_usa_bank_acct_no" name="form1_crr_usa_bank_acct_no" style="ime-mode:disabled;width:280px;" class="input2" value="<%=crrUsaBankAcctNo %>" readOnly></td>
					</tr>
					<tr class="tr2_head2">
						<td width="5%">송금금액</td>
						<td align="left" width="12%"><input type="text" id="crr_usa_remit_amt" name="form1_crr_usa_remit_amt" style="ime-mode:disabled;width:280px;" class="input2" value="<%=crrUsaRemitAmt %>" readOnly>
						<input type="text" id="crr_acct_curr_cd" name="form1_crr_acct_curr_cd" style="ime-mode:disabled;width:40px;" class="input2" value="<%=crrUsaAcctCurrCode %>" readOnly></td>
						<td width="5%">송금일자</td>
						<td align="left" width="12%"><input type="text" id="crr_usa_remit_dt" name="form1_crr_usa_remit_dt" style="ime-mode:disabled;width:280px;" class="input2" value="<%=crrUsaRemitDt %>" readOnly></td>
					</tr>
				</table>
		</td>
		<td width="10">&nbsp;</td>
		</tr>
		</table>
		
		<!-- USA선사계좌 End-->
		
		
		
		<!-- 요청사항 Start-->
		<table class="height_5"><tr><td colspan="8"></td></tr></table>

		<table class="search" border="0">
			<tr>
				<td width="10">&nbsp;</td>
				<td class="title_h"></td>
				<td class="title_s">요청사항</td>
			</tr>
		</table>
		<table class="search" border="0" style="width:979;">
		<tr class="h23">

		<td width="10">&nbsp;</td>
		<td>
				<table border="0" style="width:100%;height:100%;background-color:white;" class="grid2">
					<tr class="tr2_head2">
						<td width="147">OBL 수령 방법</td>
						<td align="center" width="350">
							<input type="hidden" name = "bl_rcv_tp_cd" value="<%=blRcvTpCd%>">
							<input type="radio" name="radio_bl_rcv_tp_cd"  value="D" class="trans" checked style="ime-mode:disabled;width:35px;" class="input2" disabled checked>직원 내방&nbsp;&nbsp;/
                            <input type="radio" name="radio_bl_rcv_tp_cd"  value="Q" class="trans" style="ime-mode:disabled;width:35px;" class="input2" disabled>QUICK RIDER
                        </td>
                        <td width="148">B/L ONBOARD DATE</td>
						<td align="center" width="119"><input type="text" id="mnl_bl_obrd_dt" name="mnl_bl_obrd_dt" style="ime-mode:disabled;width:119;" class="input2" value="<%=mnlBlObrdDt %>" onblur="javascript:chkValidDt(this);" disabled>
                        <!-- img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="img_mnl_bl_obrd_dt"></td-->
                        <td width="87">B/L ISSUE DATE</td>
						<td align="center" width="119"><input type="text" id="mnl_bl_iss_dt" name="mnl_bl_iss_dt" style="ime-mode:disabled;width:119;" class="input2" value="<%=mnlBlIssDt %>" onblur="javascript:chkValidDt(this);" disabled>
						<!-- img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="img_mnl_bl_iss_dt"></td-->
					</tr>
				</table>
		</td>
		<td width="10">&nbsp;</td>
		</tr>
		</table>
		<table class="search" border="0" style="width:979;">
		<tr class="h23">

		<td width="10">&nbsp;</td>
		<td>
				<table border="0" style="width:100%;height:100%;background-color:white;" class="grid2">
					<tr class="tr2_head2">
						<td width="5%">CERTIFICATE</td>
						<td align="center" width="12%">
							<input type="hidden" name="certi_exist_flg" value="<%=certiExistFlg %>">
							<input type="radio" name="radio_certi_exist_flg" value="N" class="trans" checked style="ime-mode:disabled;width:35px;" class="input2" checked disabled>무&nbsp;&nbsp;/
                            <input type="radio" name="radio_certi_exist_flg" value="Y" class="trans" style="ime-mode:disabled;width:35px;" class="input2" disabled>유
                        </td>
						<td width="5%">운임표기여부</td>
						<td align="center" width="12%">
							<input type="hidden" name="frt_dp_flg" value="<%=frtDpFlg %>">
							<input type="radio" name="radio_frt_dp_flg" value="N" class="trans" checked style="ime-mode:disabled;width:35px;" class="input2" checked disabled>미표기&nbsp;&nbsp;/
                            <input type="radio" name="radio_frt_dp_flg" value="Y" class="trans" style="ime-mode:disabled;width:35px;" class="input2" disabled>표기
                        </td>
					</tr>
				</table>
		</td>
		<td width="10">&nbsp;</td>
		</tr>
		</table>
		<!-- 요청사항 End-->
		
		<!-- Remark Start-->
		<table class="search" border="0" style="width:979;">
		<tr class="h23">

		<td width="10">&nbsp;</td>
		<td>
			<table border="0" style="width:100%;height:80;background-color:white;" class="grid2">
				<tr class="tr2_head2">
					<td width="100%" align="center"><textarea placeholder= "기타 필요 사항 표기 해주시기 바랍니다. (화주가 직접 작성한 rider가 있을 경우 필히 표기 바랍니다)" title="" style="width:100%;height:100;overflow-y:auto;" rows="8" id="bl_rqst_rmk" name="form1_bl_rqst_rmk" class="input2" readOnly><%=blRqstRmk %></textarea></td>
				</tr>
				<tr>
					<td style="color: red;font-size: 10; font: bold;"> * 기타 필요 사항 표기 해주시기 바랍니다. (화주가 직접 작성한 rider가 있을 경우 필히 표기 바랍니다)</td>
				</tr>
			</table>
		</td>
		<td width="10">&nbsp;</td>
		</tr>
		</table>
		<!-- Remark End-->

		<!-- Remark Start-->
		<table class="height_5"><tr><td colspan="8"></td></tr></table>

		<table class="search" border="0">
			<tr>
				<td width="10">&nbsp;</td>
				<td class="title_h"></td>
				<td class="title_s">Remark</td>
			</tr>
		</table>

		<table class="search" border="0" style="width:979;">
		<tr class="h23">

		<td width="10">&nbsp;</td>
		<td>
			<table border="0" style="width:100%;height:15;background-color:white;" class="grid2">
				<tr class="tr2_head2">
					<td width="100%" align="center"><textarea style="width:100%;overflow-y:auto;" rows="4" name="bl_iss_rmk" maxlength="300" onblur="maxLimit(this)"><%=blIssRmk %></textarea></td>
				</tr>
			</table>
		</td>
		<td width="10">&nbsp;</td>
		</tr>
		</table>
		<!-- Remark End-->
		</td></tr>
	</table>
<!--biz page (E)-->

	</td>
</tr>
</table>
<!--Button (S) -->
	<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top: 5; , padding-bottom: 10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
		    	<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Print" id="btn_Print">Print</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				
				<td class="btn1_line"></td>
				
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_approval" id="btn_approval">Approval</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>

				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_reject">Reject</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td width="15">&nbsp;</td>
			</tr>
			</table>
		</td></tr>
	</table>
<!--Button (E) -->
<!--Button (S) -->
<table width="100%" class="sbutton">
	<tr><td height="71" class="popup">
	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_close">Close</td>
					<td class="btn1_right"></td>
					</tr></table>
				</td>
			</tr>
			</table>
		<!-- Grid  (S) -->
			<table width="100%" id="mainTable" style="display:none"> 
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet1');</script>
					</td>
				</tr>
			</table> 
		<!-- Grid (E) -->	
			</td>
		</tr>
		</table>
	</td></tr>
</table>
<!--Button (E) -->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>