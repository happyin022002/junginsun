<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0426.jsp
*@FileTitle : RDN Issuance by Auditor
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.19
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.05.19 이승준
* 1.0 Creation
* 2013.02.12 김진주 [CHM-201322816] [BKG/DOC - Revenue Audit System] RDN Status 추가
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.revenueaudit.revenuedebitnote.event.EsmBkg0426Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.util.code.CodeInfo"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.revenueauditcommon.rascommon.rascommon.vo.RsltCdListVO"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.revenueauditcommon.common.RASUtil"%>
<%@ page import="com.hanjin.framework.component.common.AbstractValueObject"%>
<%@ page import="java.util.List"%>

<%
	EsmBkg0426Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_office_cd = "";
	//String strUsr_office_nm = "";
	String rissFlg = "";
	
    String[] rhqs = null;
    String[] resp = null;
    String[] discrepancyKinds = null;
    String[] rdnIssRsnCds = null;
    String[] auditTools = null;
    String[] rdnKinds = null;
	
	Logger log = Logger.getLogger("com.hanjin.apps.RevenueAudit.RevenueDebitNote");
	
	String rdn_no_pop = JSPUtil.getNull(request.getParameter("rdn_no"));
	String blNo = JSPUtil.getNull(request.getParameter("bl_no"));
	String rctRhqCdPop = JSPUtil.getNull(request.getParameter("rct_rhq_cd"));
	String rctOfcCdPop = JSPUtil.getNull(request.getParameter("rct_ofc_cd"));
	String isPop = JSPUtil.getNull(request.getParameter("isPop"));

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		strUsr_office_cd =	account.getOfc_cd();
		//strUsr_office_nm =  account.getOfc_eng_nm();

		event = (EsmBkg0426Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
        // rhq
        rhqs = RASUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("rhq"));
        //resp
        resp = RASUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("resp"));
        // Discrepancy Kind 1
        discrepancyKinds = RASUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("discrepancyKind"), false);
        // Discrepancy Kind 3
        rdnIssRsnCds = RASUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("rdnIssRsnCd"), false , "|", "\t", "getCode", "getName");
        // Audit Tool 
        auditTools = RASUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("auditTool"), false , "|", "\t", "getCode", "getName");
        // RDN Kind
        rdnKinds = RASUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("rdnKind"), false , "|", "\t", "getCode", "getName");
		//usr id가 Author인지 확인
        rissFlg = eventResponse.getETCData("riss_flg");
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>RDN Issuance by Auditor</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">

    var gStrUsr_office_cd = "<%=strUsr_office_cd%>";

    var rhqComboValue = "<%=rhqs[0]%>";
    var respComboValue = "<%=resp[0]%>";

    var discrepancyKindComboValue = "<%=discrepancyKinds[0]%>";
    var discrepancyKindComboText = "<%=discrepancyKinds[1]%>";

    var rdnIssRsnCdComboValue = "<%=rdnIssRsnCds[0]%>";
    var rdnIssRsnCdComboText = "<%=rdnIssRsnCds[1]%>";
    
    var auditToolComboValue = "<%=auditTools[0]%>";
    var auditToolComboText = "<%=auditTools[1]%>";
    
    var rdnKindComboValue = "<%=rdnKinds[0]%>";
    var rdnKindComboText = "<%=rdnKinds[1]%>";

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
<input type="hidden" name="riss_flg" value="<%=rissFlg%>" >
<!-- rdn_no -->
<input type="hidden" name="rdn_no" value="">
<!-- revise_seq -->
<input type="hidden" name="rvis_seq" value="">
<!-- PROG_SEQ -->
<input type="hidden" name="prog_seq" value="">
<!-- rdn status cd -->
<input type="hidden" name="rdn_sts_cd" value="">
<!--  FILE ATTACH -->
<input type="hidden" name="atch_file_lnk_id" value="">
<input type="hidden" name="file_cnt" value="">

<input type="hidden" name="input_text" value="">
<!-- combo -->
<input type="hidden" name="cd"   value=""> 
<input type="hidden" name="etc1" value="">
<input type="hidden" name="etc2" value="">
<input type="hidden" name="etc3" value="">

<input type="hidden" name="rct_ofc_cd_hidden"     value=""> 
<input type="hidden" name="respb_ofc_cd_hidden"   value="">
<input type="hidden" name="umch_sub_tp_cd_hidden" value="">

<!-- BOOKING -->
<input type="hidden" name="bkg_no"   	 value=""> 
<input type="hidden" name="bkg_no_split" value="">
<input type="hidden" name="cntBlno"  value="0">

<!-- pop으로 호출시 rdn_no	-->
<input type="hidden" name="isPop" value="<%=isPop%>" >
<input type="hidden" name="rdn_no_pop" value="<%=rdn_no_pop%>" >
<input type="hidden" name="rct_rhq_cd_pop" value="<%=rctRhqCdPop%>" >
<input type="hidden" name="rct_ofc_cd_pop" value="<%=rctOfcCdPop%>" >

<!-- CTRT_TP_CD -->
<input type="hidden" name="ctrt_tp_cd" value=""> 
<input type="hidden" name="rdn_iss_dt_wk" value=""> 

<!-- Groupware Popup -->
<input type="hidden" name="gw_subject"> 
<input type="hidden" name="gw_contents"> 
<input type="hidden" name="gw_template">
<input type="hidden" name="gw_args"> 

<!-- 개발자 작업	-->

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	
	<tr><td valign="top">
	<!--Page Title, Historical (S)-->
	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
<%	if("Y".equals(isPop)) {		%>	
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;&nbsp;RDN Issuance by Auditor</td></tr>
		<tr>&nbsp;</tr>
<%	} else { %>		
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
<%	}	%>		
	</table>
	<!--Page Title, Historical (E)-->

	<!-- Hidden sheet for Transaction (S) -->
		<script language="javascript">ComSheetObject('sheet0');</script>
	<!-- Hidden sheet for Transaction (E) -->
	
	<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">
				<!--  biz_1  (S) -->				
				
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="518" valign="top">
						<table class="search" border="0" style="width:100%;"> 
						<tr class="h23">
						<td width="105">RDN No. </td>				   
						<td width="150" style="padding-left:2"><script language="javascript"> ComComboObject('rdn_no_cd', 1, 125, 0, 1, 0, true);</script></td>
						<td width="105">RDN Kind </td>
						<td width="" style="padding-left:2"><script language="javascript">ComComboObject('rdn_knd_cd', 1, 125, 0, 1, 0, false);</script>
						</td> 
						</tr>
						
						<tr class="h23">
						<td width="">B/L No.</td>	
						<td width=""><input type="text" class="input" style="width:125;text-align:center;ime-mode:disabled" name="bl_no" value="<%=blNo%>" caption="B/L No" dataformat="uppernum" maxLength="12"></td>
						<td width="">INV No.</td>
						<td width=""><input type="text" class="input" style="width:125;text-align:center;ime-mode:disabled" name="inv_no" value="" caption="Invoice No" dataformat="uppernum" maxLength="20"></td> 
						</tr>
						
						<tr class="h23">
						<td width="">Issue Office</td>
						<td width=""><input type="text" name="iss_ofc_cd" style="width:125;text-align:center;" class="input2" value="<%=strUsr_office_cd %>" readonly></td>
						<td width="">Status</td>
						<td width=""><input type="text" name="rdn_sts_nm" style="width:125;text-align:center;" class="input2" value="" readonly ></td> 
						</tr>
						
						<tr class="h23">
						<td width="">Receipt RHQ</td>	
						<td style="padding-left:2"><script language="javascript"> ComComboObject('rct_rhq_cd', 1, 125, 0, 1, 0, false);</script></td>
						<td>Receipt Office </td>	
						<td style="padding-left:2"><script language="javascript"> ComComboObject('rct_ofc_cd', 1, 125, 0, 1, 0, false);</script></td>
						</tr>
						</table>
					</td>
					
					<td width="10"></td>
					
					<td width="">
						<table class="search" border="0" style="width:100%;">
						<tr class="h23">
						<td colspan="4"></td>
						</tr>
						
						<tr class="h23">
						<td width="85">VVD Code</td>
						<td width="140" style="padding-left:1"><input type="text" class="input" style="width:120;text-align:center;ime-mode:disabled" name="vvd_cd" value="" caption="VVD" dataformat="uppernum" maxLength="9"></td>
						<td width="90"></td>
						<td></td>
						</tr>
						
						<tr class="h23">
						<td width="">Issue Date </td>
						<td width="" STYLE="	padding-left:1"><input type="text" name="rdn_iss_dt" style="width:120;text-align:center;" class="input2" value="" readonly></td> 
						<td width="">Update Date</td>
						<td width="" style="padding-left:2"><input type="text" name="sts_upd_dt" maxlength="10" style="width:120;text-align:center;" class="input2" value="" readonly></td> 
						</tr>
						
						<tr class="h23">
						<td width="">Resp. RHQ</td>
						<td style="padding-left:3"><script language="javascript"> ComComboObject('respb_rhq_cd', 1, 120, 0, 1, 0, false);</script></td>
						<td>Resp. Office</td>
						<td style="padding-left:4"><script language="javascript"> ComComboObject('respb_ofc_cd', 1, 120, 0, 1, 0, false);</script></td>
						</tr>
						</table>
					</td>
				</table>
				
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="518" valign="top">
						<table class="search" border="0" style="width:100%;"> 
						<tr class="h23">
						<td width="105">Error Kind</td>
						<td width="" style="padding-left:2"><script language="javascript"> ComComboObject('umch_tp_cd', 1, 125, 0, 1, 0, false);</script>
						&nbsp;
						<script language="javascript"> ComComboObject('umch_sub_tp_cd', 1, 125, 0, 1, 0, false);</script>
						&nbsp;
						<script language="javascript"> ComComboObject('rdn_iss_rsn_cd', 1, 125, 0, 1, 0, false);</script></td>		
						</tr>
						<tr class="h23">
						<td>Error Remarks</td>
						<td width=""><input type="text" name="umch_rmk" style="width:383;ime-mode:disabled" class="input" value=""></td>	
						</tr>
						<tr class="h23">
						<td>Audit Tool</td>
						<td width="" style="padding-left:2"><script language="javascript"> ComComboObject('rev_aud_tool_cd', 1, 200, 0, 1, 0, false);</script></td>		
						</tr>
						</table>
					</td>
					<td width="10"></td>
					<td width="">
						<table class="search" border="0" style="width:100%;"> 
						<tr class="h23">
						<td width="19%">Contract No.</td>
						<td width=""><input type="text" name="sc_rfa_no" style="width:120;text-align:center" class="input2" value="" readonly></td>		
						</tr>
						
						<tr class="h23">
						<td width="437" colspan="4">
							<!-- Grid  (S) -->
							<table width="100%"  id="mainTable"> 
								<tr>
									<td width="100%">
										<script language="javascript">ComSheetObject('sheet1');</script>
									</td>
								</tr>
							</table>
							<!-- Grid (E) -->
						<!--  Button_Sub (S) -->
							<table width="100%" class="button"> 
					       		<tr>
					       		<td class="btn2_bg">
									<table border="0" cellpadding="0" cellspacing="0">
										<td>
											<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr><td class="btn2_left"></td>
											<td class="btn2" name="btn_RowAdd">Row Add</td>
											<td class="btn2_right"></td>
											</tr>
											</table>
										</td>
										<td>
											<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr><td class="btn2_left"></td>
											<td class="btn2" name="btn_Delete">Row Delete</td>
											<td class="btn2_right"></td>
											</tr>
											</table>
										</td>
									</table>
								</td>
								</tr>
							</table>
							<table class="height_10"><tr><td colspan="8"></td></tr></table>
							<table class="height_10"><tr><td colspan="8"></td></tr></table>
	    	<!-- Button_Sub (E) -->
						</td>
						</tr>
						
						<tr class="h23">
						<td width="10%">C/A No. </td>
						<td width="130" STYLE="	padding-left:1"><input type="text" name="bkg_corr_no" style="width:120;text-align:center;" class="input2" value="" readonly></td> 
						<td width="100">TPB Number</td>
						<td width="" style="padding-left:2"><input type="text" name="n3pty_no" maxlength="10" style="width:120;text-align:center;" class="input2" value="" readonly></td> 
						</tr>
													
						<tr>
						<td></td>
						</tr>						
						
						</table>
						
					</td>
						
				</tr>
				</table>
				
				<!--  biz_1   (E) -->
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
					<td width="510">
						<table border="0" style="width:100%; background-color:white;" class="grid2">
							<tr><td width="40%" class="tr2_head">Remarks (Auditor)</td>
								<td style="background-color:#F3F2F8; border:0px;"></td>
							</tr>								
							<tr><td colspan="2"><textarea name="rdn_rmk" cols="" rows="4" style="width:100%;ime-mode:disabled"></textarea></td>
							</tr>
						</table>
						</td>
					
					<td width="18"></td>
					<td width="">
						<table class="search" border="0" style="width:100%;"> 
							<tr class="h23"><table class="grid2" border="0" style="width:100%; background-color:white;"> 
							<tr><td width="47%" class="tr2_head">Remarks (Office)</td>
								<td style="background-color:#F3F2F8; border:0px;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								</td>
							</tr>								
								<tr><td colspan="2"><textarea class="textarea2" name="receiver_rmk" cols="" rows="4" style="width:100%" readonly> </textarea></td></tr></table></tr>
							</table>
					</td>
					</tr>
				</table>
			
			
			
				
					<!--  biz_2_1  (E) -->

					
					<!--Grid (S)-->
					
					<!--Grid (E)-->
					
					<!--  biz_2_2  (E) -->
					
				<!--  biz_2   (E) -->
				
		<!-- Tab ) (S) -->
     	
		<!-- Tab ) (E) -->
		
		<!-- Grid BG Box  (S) -->
     	
					<!--Grid (E)-->
				
				
				
				
				
				
			</td></tr>
		</table>
	<!-- Grid BG Box  (S) -->
	<!--biz page (E)-->
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5; padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve" id="btn_retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_New">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Issue">Issue</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_ReIssue">Re-Issue</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td> 

				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Revise">Revise</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Vcancel">Cancel(Valid)</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Cancel">Cancel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Settle">Settle</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Copy">Copy</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>


                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button"  style="display:none">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_mail">Mail</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>

				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Attachment" id="btn_Attachment">Attachment</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<!-- td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Print">Print</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td-->
			<%	if("Y".equals(isPop)) {		%>	
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Close">Close</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			<%	} %>				
			</tr>
			</table>
		</td></tr>
		</table>
    <!--Button (E) -->
	
	</td></tr>
		</table>

<div style="display: none">
<table>
<tr>
<td>
<script language="javascript">ComSheetObject('sheet2');</script>
</td>
</tr>
</table>
</div>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>