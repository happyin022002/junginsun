<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0132.jsp
*@FileTitle : Cargo Release Order_E-D/O inquiry _Main
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.16
*@LastModifier : 안진응
*@LastVersion : 1.0
* 2009.05.19 안진응
* 1.0 Creation
* ------------------------------------------------------
* History
* 2012.01.31 박성호 [BKG] DEM/DET 과 E-DO 연동 관련 해서 확인 요청
* 2012.02.27 김보배 [CHM-201216190] [BKG] e-Do 신청서상에 D/O 신청자 이메일 항목 출력건
* 2012.08.06 김보배 [CHM-201219299] [BKG] KOREA E-D/O 조회 기능 보완 요청
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event.EsmBkg0133Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0133Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.InboundBLMgtSC.FullReleaseOrderBC");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (EsmBkg0133Event)request.getAttribute("Event");
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
<title>eDO Issue Application Inquiry</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
	function endPage() {
		closePage();
	}
</script>
</head>

<body class="popup_bg" onLoad="setupPage();" onbeforeunload="endPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->
  
<table width="100%" class="popup" cellpadding="10" border="0"> 
	<tr><td class="top"></td></tr>
	
	<tr><td valign="top">
	
<!-- : ( Title ) (S) -->
            <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
                <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;eDO Issue Application Inquiry</span></td></tr>
            </table>
            <!-- : ( Title ) (E) -->	
	
		
		<!-- Grid BG Box  (S) -->
		
     		<table class="search"> 
       		<tr><td class="bg">
			<!--  biz_1  (S) -->
				
					<table class="search" border="0" style="width:100%;"> 
					<tr class="h23">
					<td width="60">MRN No.</td>
					<td width="200"><input type="text" style="width:120" class="input2" value="<%=JSPUtil.getNull(request.getParameter("edo_rqst_no").substring(0, 11))%>" readonly></td>
					<td width="30">MSN</td>
					<td width="200"><input type="text" style="width:100" class="input2" value="<%=JSPUtil.getNull(request.getParameter("edo_rqst_no").substring(11))%>" readonly></td> 
					<td width="60">승인 선사</td>
					<td width=""><input type="text" style="width:100;" class="input2" value="SMLM" readonly></td>			
					</tr> 
				</table>				
				
		</td> </tr> 
		</table>	
				<!--  biz_1   (E) -->
			
				<table class="height_8"><tr><td></td></tr></table>
				<!-- Tab (S) -->
     	
		<!-- Tab (E) -->
				
	<table class="search"> 
       <tr><td class="bg">
			
		
				<!--biz (s)-->
						<table border="0" style="width:900; background-color:white;" class="grid2"> 
							<tr>
								<td class="tr2_head" width="150">Master B/L No</td> 
								<td width="300" class="input2" colspan="2"><input type="text" name = "bl_no" style="width:100%;" class="noinput2" value="" readonly></td> 
								<td class="tr2_head" width="150">신청 일시</td> 
								<td class="input2" colspan="2"><input type="text" name = "edo_rct_dt" style="width:100%;" class="noinput2" value="" readonly></td> 
								</tr>
								
							<tr>
								<td class="tr2_head" width="">신청자</td> 
								<td width="" class="input2" colspan="2"><input type="text" name = "ms_pty_rgst_no" style="width:100%;" class="noinput2" value="" readonly></td> 
								<td class="tr2_head" width="">승인 일시</td> 
								<td class="input2" colspan="2"><input type="text" name = "edo_ack_dt_a" style="width:100%;" class="noinput2" value="" readonly></td> 
								</tr>
								
							<tr>
								<td class="tr2_head" width="">항차</td> 
								<td width="300" class="input2" colspan="2"><input type="text" name = "skd_nm" style="width:100%;" class="noinput2" value="" readonly></td> 
								<td class="tr2_head" width="">거부 일시</td> 
								<td class="input2" colspan="2" width="300"><input type="text" name = "edo_ack_dt_r" style="width:100%;" class="noinput2" value="" readonly></td> 
							</tr>
								
							<tr>
								<td class="tr2_head" width="">입항일자</td> 
								<td class="input2" colspan="2"><input type="text" name = "vsl_arr_dt" style="width:100%;" class="noinput2" value="" readonly></td> 
								<td class="tr2_head" width="">USER ID </td> 
								<td class="input2" colspan="2"><input type="text" name = "edo_ack_usr_id" style="width:100%;" class="noinput2" value="" readonly></td> 
							</tr>
								
							<tr>
								<td class="tr2_head" width="">접수지</td> 
								<td width="100" class="input2"><input type="text" name = "edo_rct_loc_cd" style="width:100%;" class="noinput2" value="" readonly></td> 
								<td width="200" class="input2"><input type="text" name = "edo_rct_loc_nm" style="width:100%;" class="noinput2" value="" readonly></td> 
								<td class="tr2_head" width="">선박 명 </td> 
								<td class="input2" colspan="2"><input type="text" name = "edo_vsl_nm" style="width:100%;" class="noinput2" value="" readonly></td> 
							</tr>
							<tr>
								<td width="" class="input2" colspan="3"><input type="text" style="width:100%;" class="noinput2" value=""></td> 
								<td class="tr2_head" width="">발급희망일 </td> 
								<td  colspan="2" class="input2"><input type="text" name = "rqst_edo_iss_dt" style="width:100%;" class="noinput2" value="" readonly></td> 
								</tr>
							
						</table> 
					<!--biz(E)-->
			
			<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
				
			
		
				<!--biz (s)-->
							<table class="search" border="0">
							<tr><td class="title_h"></td>
								<td class="title_s">신청업체</td></tr>
							</table>
						<table border="0" style="width:900; background-color:white;" class="grid2"> 
							<tr>
								<td class="tr2_head" width="150">상호</td> 
								<td width="300" class="input2"><input type="text" name = "ms_pty_nm" style="width:100%;" class="noinput2" value="" readonly></td> 
								<td class="tr2_head" width="150">담당자명</td> 
								<td width="300" class="input2"><input type="text" name = "ms_pty_cntc_pson_nm" style="width:100%;" class="noinput2" value="" readonly></td> 
							</tr>
							<tr>
								<td class="tr2_head" width="150">전화번호</td> 
								<td width="300" class="input2"><input type="text" name = "ms_phn_no" style="width:100%;" class="noinput2" value="" readonly></td>
								<td class="tr2_head" width="150">e-Mail</td>
								<td width="300" class="input2"><input type="text" name = "ms_pty_eml" style="width:100%;" class="noinput2" value="" readonly></td>
								 
							</tr>
							<tr>
								<td class="tr2_head" width="150">요청사항 </td> 
								<td width="300" class="input2"><input type="text" name = "diff_rmk" style="width:100%;" class="noinput2" value="" readonly></td> 
								<td class="input2" colspan="2" rowspan="2"></td> 
							</tr>
						</table> 
				<!--biz(E)-->
			
			<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
				
			
		
				<!--biz (s)-->
							<table class="search" border="0">
							<tr><td class="title_h"></td>
								<td class="title_s">실화주</td></tr>
							</table>
						<table border="0" style="width:900; background-color:white;" class="grid2"> 
							<tr>
								<td class="tr2_head" width="150">상호</td> 
								<td width="300" class="input2"><input type="text" name = "as_pty_nm" style="width:100%;" class="noinput2" value="" readonly></td> 
								<td class="tr2_head" width="150">사업자번호</td> 
								<td width="300" class="input2"><input type="text" name = "as_pty_rgst_no" style="width:100%;" class="noinput2" value="" readonly></td> 
							</tr>
						</table> 
				<!--biz(E)-->
			
			<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
				
			
		
				<!--biz (s)-->
							<table class="search" border="0">
							<tr><td class="title_h"></td>
								<td class="title_s">세금계산서 공급 받는자</td></tr>
							</table>
						<table border="0" style="width:900; background-color:white;" class="grid2"> 
							<tr>
								<td class="tr2_head" width="150">상호</td> 
								<td width="300" class="input2"><input type="text" name = "pr_pty_nm" style="width:100%;" class="noinput2" value="" readonly></td> 
								<td class="tr2_head" width="150">사업자번호</td> 
								<td width="300" class="input2"><input type="text" name = "pr_pty_rgst_no" style="width:100%;" class="noinput2" value="" readonly></td> 
							</tr>
							<tr>
								<td class="tr2_head" width="150">e-Mail</td> 
								<td width="300" class="input2"><input type="text" name = "pr_pty_eml" style="width:100%;" class="noinput2" value="" readonly></td> 
								<td class="input2" colspan="2" rowspan="2"></td> 
							</tr>
						</table> 
				<!--biz(E)-->
				
			
			<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
				
			
		
				<!--biz (s)-->
							<table class="search" border="0">
							<tr><td class="title_h"></td>
								<td class="title_s">송금업체</td></tr>
							</table>
						<table border="0" style="width:900; background-color:white;" class="grid2"> 
							<tr>
								<td class="tr2_head" width="150"> 상호 </td> 
								<td width="300" class="input2"><input type="text" name = "payr_nm" style="width:100%;" class="noinput2" value="" readonly></td> 
								<td class="tr2_head" width="150">송금금액</td> 
								<td width="100" class="input2"><input type="text" name = "pay_amt_ctnt" style="width:100%;text-align:right" class="noinput2" value="" readonly dataformat = "float" pointcount=”2”></td> 
								<td width="200" class="input2"><input type="text" name = "pay_curr_cd" style="width:100%;" class="noinput2" value="" readonly></td> 
							</tr>
							<tr>
								<td class="tr2_head" width="150">입금은행</td> 
								<td width="300" class="input2"><input type="text" name = "payr_bank_nm" style="width:100%;" class="noinput2" value="" readonly></td> 
								<td class="tr2_head" width="150">계좌번호	</td> 
								<td width="300" class="input2" colspan="2"><input name = "payr_bank_acct_no" type="text" style="width:100%;" class="noinput2" value="" readonly></td> 
							</tr>
							<tr>
								<td class="tr2_head" width="150">송금일</td> 
								<td width="300" class="input2"><input type="text" name = "payr_remit_dt" style="width:100%;" class="noinput2" value="" readonly></td> 
								<td class="input2" colspan="3" rowspan="2"></td> 
							</tr>
						</table> 
			</td></tr>
			</table>
								
	<!-- Grid BG Box  (S) -->
		<table class="height_5"><tr><td></td></tr></table>	
		</td></tr></table>
				
	
	<!--biz page (E)-->
	<!--Button (S) -->
		
    <!--Button (E) -->
	
		
<!-- Copyright (S) -->

<input type='hidden' name ='frm_edo_rqst_no' value = "<%=JSPUtil.getNull(request.getParameter("edo_rqst_no"))%>">
<input type='hidden' name ='frm_edo_tp_cd' value = "<%=JSPUtil.getNull(request.getParameter("edo_tp_cd"))%>">
<input type='hidden' name ='frm_edo_rqst_seq_5jn' value = "<%=JSPUtil.getNull(request.getParameter("edo_rqst_seq_5jn"))%>">
<input type='hidden' name ='frm_edo_rqst_seq_5jm' value = "<%=JSPUtil.getNull(request.getParameter("edo_rqst_seq_5jm"))%>">
<input type='hidden' name ='frm_edo_rqst_seq_5jk' value = "<%=JSPUtil.getNull(request.getParameter("edo_rqst_seq_5jk"))%>">
<input type='hidden' name ='frm_edo_rvw_flg' value = "<%=JSPUtil.getNull(request.getParameter("rvwFlg"))%>">

<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
    <tr>
        <td height="71" class="popup">        
            <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
                <tr>
                    <td class="btn3_bg">
                        <table border="0" cellpadding="0" cellspacing="0">
                            <tr>
                                <td>
                                    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                        <tr>
                                            <td class="btn1_left"></td>
                                            <td class="btn1" name="btn_close">Close</td>
                                            <td class="btn1_right"></td>
                                        </tr>
                                    </table>
                                </td>
                            </tr>
                        </table>
                    </td>
                </tr>
            </table>
        </td>
    </tr>
</table>       
<!-- : ( Button : pop ) (E) -->

<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
							<script language="javascript">ComSheetObject('sheet2');</script>
							<script language="javascript">ComSheetObject('sheet3');</script>
						</td>
					</tr>
				</table>			
			<!-- Grid (E) -->	
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>
<%@include file="/bizcommon/include/common_nis2010.jsp"%>