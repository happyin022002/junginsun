<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0701.jsp
*@FileTitle : Mismatch B/L Inquiry by Office
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.22
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.06.22 이승준
* 1.0 Creation
* 2012.04.26 김진주 [CHM-201216859] [BKG/DOC - Revenue Audit System] 미주발 S/C B/L OFT 자동심사
* 2012.10.23 조정민 [CHM-201220701] [BKG/DOC - Revenue Audit System] Error B/L Inqjuiry, RDN Status Inquiry 기능에 GSO 검색조건 추가
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.event.EsmBkg0701Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.util.code.CodeInfo"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.revenueauditcommon.rascommon.rascommon.vo.RsltCdListVO"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.revenueauditcommon.rascommon.rascommon.vo.RsltContiListVO"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.revenueauditcommon.common.RASUtil"%>
<%@ page import="com.hanjin.framework.component.common.AbstractValueObject"%>
<%@ page import="java.util.List"%>

<%
	EsmBkg0701Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strRhq_ofc_cd    = "";
	String strOfc_cd        = "";
	
    String[] rhqs = null;
	String[] scps = null;
    String[] contiCd = null;
    String[] contractTypes = null;
    String[] errorTypes = null;
    String[] ratingTypes = null;
    String[] status1s = null;
    String[] status2s = null;
    String[] records = null;
    String[] chargeCodes = null;
	
	Logger log = Logger.getLogger("com.hanjin.apps.RevenueAudit.UnmatchBL");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strRhq_ofc_cd = account.getRhq_ofc_cd();
		strOfc_cd = account.getOfc_cd();

		event = (EsmBkg0701Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
        // rhq
        rhqs = RASUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("rhq"));
		// service scope
		scps = RASUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("scp"));
     	// contiCd
        contiCd = RASUtil.getValueObject2StringArray((List<RsltContiListVO>)eventResponse.getCustomData("contiCd"), false, "|", "\t", "getContiCd", "getContiNm");
        // Contract Type
        contractTypes = RASUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("contractType"), false , "|", "\t", "getCode", "getName");
        // Error Type 
        errorTypes = RASUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("errorType"), false , "|", "\t", "getCode", "getName");
        // Rating Type 
        ratingTypes = RASUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("ratingType"), false , "|", "\t", "getCode", "getName");
        // status1
        status1s = RASUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("status1"), false , "|", "\t", "getCode", "getName");
        // status2 
        status2s = RASUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("status2"), false , "|", "\t", "getCode", "getName");
        // record 
        records = RASUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("record"), false , "|", "\t", "getCode", "getName");
        // charge
        chargeCodes = RASUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("charge"));

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Mismatch B/L Inquiry by Office</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">

    var rhqComboValue = "|<%=rhqs[0]%>";
    var scpComboValue = "|<%=scps[0]%>";
    
    var contiCdComboValue = "|<%=contiCd[0]%>";
    var contiCdComboText = "|<%=contiCd[1]%>";

    var contractTypeComboValue = "|<%=contractTypes[0]%>";
    var contractTypeComboText = "|<%=contractTypes[1]%>";
    
    var errorTypeComboValue = "|<%=errorTypes[0]%>";
    var errorTypeComboText = "|<%=errorTypes[1]%>";
    
    var ratingTypeComboValue = "|<%=ratingTypes[0]%>";
    var ratingTypeComboText = "|<%=ratingTypes[1]%>";

    var status1ComboValue = "|<%=status1s[0]%>";
    var status1ComboText = "|<%=status1s[1]%>";

    var status2ComboValue = "|<%=status2s[0]%>";
    var status2ComboText = "|<%=status2s[1]%>";

    var recordComboValue = "<%=records[0]%>";
    var recordComboText = "<%=records[1]%>";
    
    var chargeCodeComboValue = "|<%=chargeCodes[0]%>";
    var chargeCodeComboText = "|<%=chargeCodes[1]%>";

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
<!-- combo -->
<input type="hidden" name="cd"   value=""> 
<input type="hidden" name="etc1" value="">
<input type="hidden" name="etc2" value="">
<input type="hidden" name="etc3" value="">
<input type="hidden" name="rdn_no_pop" value="">
<input type="hidden" name="strRhq_ofc_cd" value="<%=strRhq_ofc_cd%>">
<input type="hidden" name="strOfc_cd" value="<%=strOfc_cd%>">
<input type="hidden" name="bkg_no_arr" value="">

<input type="hidden" name="backendjob_key" value="">
<!-- Error Seq -->
<input type="hidden" name="audit_seq_cd" value="">

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	
	<tr><td valign="top">
	
		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!--Page Title, Historical (E)-->

		<!-- Hidden sheet for Transaction (S) -->
		<script language="javascript">ComSheetObject('sheet0');</script>
		<!-- Hidden sheet for Transaction (E) -->
	
		<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0; padding-bottom:2;"> 
       	<tr><td class="btn1_bg">
		
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
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
					<td class="btn1" name="btn_DownExcel">Down Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
            </tr>
			</table>
		</td></tr>
		</table>
    	<!--Button (E) -->
		
		<!--biz page (S)-->
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">
			

				<!--  biz_1 (S) -->
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="33">RHQ</td>
						<td width="70"><script language="javascript"> ComComboObject('rct_rhq_cd', 1, 65, 0, 0, 0, false);</script></td>
						<td width="43">Office</td>
						<td width="70"><script language="javascript"> ComComboObject('rct_ofc_cd', 1, 65, 0, 0, 0, false);</script></td>
						<td width="35">GSO</td>
						<td width=""><input type="text" name="gso" style="width:70;text-align:center;ime-mode:disabled" value="" dataformat="uppernum" caption="GSO" maxLength="6"></td>
						<td width="295"><input type="radio" name="dt_type" value="AUD" class="trans" checked> Audit Initial Date
						<input type="radio" name="dt_type" value="APL" class="trans" > Appl. Date
						<input type="radio" name="dt_type" value="PCT" class="trans" > PCT</td>
						<td width="245"><input name="rt_aply_dt_from" type="text" style="width:80;text-align:center;" class="input1" caption="From Date" dataformat="ymd" maxLength="10" minlength="8">
						<img class="cursor" src="img/btns_calendar.gif" name="btns_calendar1" width="19" height="20" border="0" align="absmiddle">
						~
						<input name="rt_aply_dt_to" type="text" style="width:80;text-align:center;"  class="input1" caption="To Date" dataformat="ymd" maxLength="10" minlength="8">
						<img class="cursor" src="img/btns_calendar.gif" name="btns_calendar2" width="19" height="20" border="0" align="absmiddle">
						<td width="41">T/VVD  </td>
						<td width="90"><input type="text" name="vvd_cd" style="width:83;text-align:center;ime-mode:disabled" value="" caption="T/VVD" dataformat="uppernum" maxLength="9"></td>

					</tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="33">BDR</td>
						<td width="70"><script language="javascript"> ComComboObject('bdr_status_cd', 1, 65, 0, 0, 0, false);</script></td>
						
						<td width="43">Scope</td>
						<td width="70"><script language="javascript" >ComComboObject('svc_scp_cd', 1, 65, 0,0)</script></td>  
						
						<td width="100">POR/DEL Cont.</td>
                        <td width="65"><script language="javascript">ComComboObject('conti_cd', 1, 60, 0, 0, 0, false);</script></td>      
                        <td width="65"><script language="javascript">ComComboObject('conti_cd2', 1, 60, 0, 0, 0, false);</script></td> 
					    	
						<td width="60">Contract</td>
						<td width="50"><script language="javascript"> ComComboObject('bkg_ctrt_tp_cd', 1, 50, 0, 0, 0, false);</script></td>
						<td width="100"><input type="text" name="contract_no" style="width:95;text-align:center;ime-mode:disabled" value="" caption="Contract No" dataformat="uppernum" maxLength="12"></td>
						<td width="80">Rating Type</td>
						<td width=""><script language="javascript"> ComComboObject('auto_rat_flg', 1, 100, 0, 0, 0, false);</script></td>
						<td width="43">B/L No</td>
						<td width="90"><input type="text" name="bl_no" style="width:83;text-align:center;ime-mode:disabled" value="" caption="B/L No" dataformat="uppernum" maxLength="12"></td>
						
						</tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">	
					    <td width="75">Error Type</td>
						<td width="115"><script language="javascript"> ComComboObject('umch_tp_cd', 1, 95, 0, 0, 0, false);</script></td>
						<td width="50">Charge</td>
                    	<td width="70"><script language="javascript">ComComboObject('chg_cd', 2, 55, 0, 0, 0, false);</script></td>
						<td width="85">Error Status </td>
						<td width="210">
						<script language="javascript"> ComComboObject('rev_aud_sts_cd', 1, 80, 0, 0, 0, false);</script>&nbsp;
						<script language="javascript"> ComComboObject('rev_aud_stl_knd_cd', 1, 110, 0, 0, 0, false);</script>
						</td>
						<td width="60">Rater ID</td>
						<td width=""><input type="text" name="rater_id" style="width:103;text-align:center;ime-mode:disabled;" value="" maxLength="20"></td>	
				
						<td width="">
							<table class="search_sm2" border="0" style="width:100%;"> 
								<tr class="h23">
									<td width="">&nbsp;Error Seq.</td>
									<td class="stm"><input type="radio" class="trans" name="audit_seq_radio" value="P" checked>Present&nbsp;<input type="radio" class="trans" name="audit_seq_radio" value="H">History</td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">	
					    <td width="75">Error Kind</td>
						<td width="70"><script language="javascript"> ComComboObject('err_umch_tp_cd', 3, 55, 0, 0, 0, false);</script></td>
						
						<td width="125">Manual Settle Kind</td>
						<td width="70"><script language="javascript"> ComComboObject('mnl_stl_tp_cd', 3, 55, 0, 0, 0, false);</script></td>	
					    
					    <td width="28">POR</td>
						<td width="66"><input type="text" style="width:52;text-align:center;ime-mode:disabled;" class="input" name="por_cd" dataformat="engup" maxlength="5"></td>
						<td width="28">POL</td>
						<td width="66"><input type="text" style="width:52;text-align:center;ime-mode:disabled;" class="input" name="pol_cd" dataformat="engup" maxlength="5"></td>
						<td width="28">POD</td>
						<td width="66"><input type="text" style="width:52;text-align:center;ime-mode:disabled;" class="input" name="pod_cd" dataformat="engup" maxlength="5"></td>
						<td width="28">DEL</td>
						<td width="66"><input type="text" style="width:50;text-align:center;ime-mode:disabled;" class="input" name="del_cd" dataformat="engup" maxlength="5"></td>
						
						<td width="268"></td>
					</tr>
				</table>
							
				<!--  biz_1   (E) -->		
			
		</td></tr></table>
		<table class="height_8"><tr><td></td></tr></table>	
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">	
			
			
			<!-- Grid  (S) -->
			<table width="100%"  id="mainTable">
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet1');</script>
					</td>
				</tr>
			</table>
			<!-- Grid (E) -->	
			
			<table class="height_5"><tr><td></td></tr></table>
			
			<table width="100%" class="search" border="0">
				<tr class="h23" style="width:979">
				    <td style="width:380">
			             <table border="0" style="width:380; background-color:white;" class="grid2"> 
		    				<tr class="tr2_head">
    							<td style="width:80;" rowspan="2">Total</td>
		   						<td>B/L Count</td> 
								<td>Error B/L</td>
								<td>Error Case</td></tr>
							<tr  align="center">
								<td><input type="text" name="filtered_bkg_count"   style="width:100; text-align: center" class="noinput" value="" readonly></td>
								<td><input type="text" name="unmatched_bl_count"   style="width:100; text-align: center" class="noinput" value="" readonly></td> 
								<td><input type="text" name="unmatched_case_count" style="width:100; text-align: center" class="noinput" value="" readonly></td>
							</tr>
        				</table>
					</td>

                    <td style="width:19"></td>
					
					<td style="width:580">
						<table border="0" style="width:580; background-color:white;" class="grid2"> 
							<tr class="tr2_head">
								<td>Error Kind</td>
								<td width="55">A1</td>
								<td width="55">A2</td>  
								<td width="55">B</td>
								<td width="55">C</td>
								<td width="55">D</td>
								<td width="55">E</td>
								<td width="55">F</td>
								<td width="55">G</td>
								</tr>
							<tr align="center">
							    <td class="tr2_head">Total</td>
								<td><input type="text" name="unmatch_al" style="width:52; text-align: center"  class="noinput" value="" readonly></td>
								<td><input type="text" name="unmatch_all" style="width:52; text-align: center"  class="noinput" value="" readonly></td> 
								<td><input type="text" name="unmatch_b" style="width:52; text-align: center"  class="noinput" value="" readonly></td>
								<td><input type="text" name="unmatch_c" style="width:52; text-align: center"  class="noinput" value="" readonly></td> 
								<td><input type="text" name="unmatch_d" style="width:52; text-align: center"  class="noinput" value="" readonly></td> 
								<td><input type="text" name="unmatch_e" style="width:52; text-align: center"  class="noinput" value="" readonly></td>
								<td><input type="text" name="unmatch_f" style="width:52; text-align: center"  class="noinput" value="" readonly></td>
								<td><input type="text" name="unmatch_g" style="width:52; text-align: center"  class="noinput" value="" readonly></td>
							</tr>
						</table>
					</td>
					
                    <td width="*"></td>
					
				</tr>
			</table>	
			
			
			<!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0"><tr>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_Filtered_Bl">B/L Count</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_ReAudit">Re-Audit</td>
						<td class="btn2_right"></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_Settle">Manual Settle(Office)</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						</tr>
						</table></td>
					</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->		
			
			</td></tr>
		</table>
		<!--biz page (E)-->


	
	
	</td></tr>
		</table>
	

	<table class="height_10"><tr><td colspan="8"></td></tr></table>
	
<div style="display: none">
<script language="javascript">ComSheetObject('sheet3');</script>
<script language="javascript">ComSheetObject('sheet2');</script>
<script language="javascript">ComSheetObject('sheet4');</script>
</div>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>