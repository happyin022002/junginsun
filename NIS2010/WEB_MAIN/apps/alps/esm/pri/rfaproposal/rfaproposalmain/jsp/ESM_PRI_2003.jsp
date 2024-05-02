<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_2003.jsp
*@FileTitle : Proposal & Amendment Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.08
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.05.08 공백진
* 1.0 Creation
=========================================================
* History
* 2011.12.26 이석준 [CHM-201115205] RFA or Proposal 조회시 HAMRU 산하의 BA만 자신의 office만 조회 가능할 수 있도록 validation및 logic 수정
* 2013.12.20 서미진 [CHM-201328281] RFA에 계약 구분인자 추가 (C : Contract, S : Spot)
* 2014.03.11 서미진 [CHM-201429293] Route 중에 term이 빠진 Location check
* [CHM-201534517] 1월 소스 보안 결함 건 조치 요청
* 2016.05.03 RFA 효율화를 위한 요청 (1차) (CHM-201640671)   
* 2016.07.20 [CHM-201642287] Master RFA Cancel시 Basic RFA 점검 로직 개발 요청
=========================================================*/
%>
 
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.event.EsmPri2003Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.List"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.common.PRIUtil"%>
<%@ page import="com.hanjin.framework.component.util.code.CodeInfo"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>
<%@ page import="com.hanjin.framework.component.util.StringUtil" %>
<%
	EsmPri2003Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String rfaNo = "";
    String condPropNo = null;

    String mstPropNo = ""; // Master RFA에서 복사해서 넘어온 proposal No.
    
	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_ofc		= "";
	String strRhq_ofc       = "";
	String strUsrSrepCd     = "";
	Logger log = Logger.getLogger("com.hanjin.apps.RFAProposal.RFAProposalMain");

	String[] scopeCd = null;
	String[] dmdtCd = null;	
	String[] lodUtCd = null;
	String[] scpStsCd = null;
	String[] rfaCtrtTpCd = null;
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_ofc = account.getOfc_cd();
	    strUsrSrepCd = account.getSrep_cd();
	    strRhq_ofc   = account.getRhq_ofc_cd();
	    
		event = (EsmPri2003Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		rfaNo = StringUtil.xssFilter(request.getParameter("rfa_no_2043"));
        condPropNo = JSPUtil.getNull(request.getParameter("cond_prop_no"));
        
      //RFA 효율화를 위한 요청 (1차) (CHM-201640671)
      //mstRfaNo = "NYC16M0008" ; //임시사용
      mstPropNo = StringUtil.xssFilter(request.getParameter("mst_prop_no"));
		

        scopeCd = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("scopeList"), true);
        dmdtCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("dmdtList"), true ,"|","\t","getCode","getName");		
        lodUtCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("lodUtList"), false ,"|","\t","getCode","getName");	
        scpStsCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("scpStsList"), false ,"|","\t","getCode","getName");	        
        rfaCtrtTpCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("rfaCtrtTpList"), false ,"|","\t","getCode","getName");   
        
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Proposal & Amendment Creation</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 
<script language="javascript">
    var scopeCdValue = " |<%=scopeCd[0]%>";
    var scopeCdText = " |<%=scopeCd[1]%>";
    var dmdtCdValue = "<%=dmdtCd[0]%>";
    var dmdtCdText = "<%=dmdtCd[1]%>";
    var lodUtCdValue = "<%=lodUtCd[0]%>";
    var lodUtCdText = "<%=lodUtCd[1]%>";    
    var scpStsCdValue = "<%=scpStsCd[0]%>";
    var scpStsCdText = "<%=scpStsCd[1]%>";  
    var rfaCtrtTpCdValue = "<%=rfaCtrtTpCd[0]%>";
    var rfaCtrtTpCdText = "<%=rfaCtrtTpCd[1]%>"; 
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
<input type="hidden" name="in_usr_ofc_cd" value="<%=strUsr_ofc%>">
<input type="hidden" name="in_rhq_ofc_cd" value="<%=strRhq_ofc%>">
<input type="hidden" name="in_usr_srep_cd" value="<%=strUsrSrepCd%>">
<input type="hidden" name="in_usr_nm" value="<%=strUsr_nm%>">
<!--  2043 에서 팝업 호출시 사용-->
<input type="hidden" name="rfa_no_2043" value="<%=rfaNo%>">
<!--  2049 에서 호출시 사용-->
<input type="hidden" name="cond_prop_no" value="<%=condPropNo%>">

<!--  Master 에서 팝업 호출시 사용-->
<input type="hidden" name="mst_prop_no" value="<%=mstPropNo%>">

<input type="hidden" name="ori_rfa_no" >
<input type="hidden" name="ori_prop_no" >
<input type="hidden" name="sale_lead_ori" >
<!-- 개발자 작업	-->

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">

	<tr><td valign="top">
	<!--Page Title, Historical (S)-->
	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
	</table>
	<!--Page Title, Historical (E)-->

		<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:2;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_new">New</td>
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
					<td class="btn1" name="btn_request">Request</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_amend">Amend</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<!-- Basic RFA Only : Start -->
				<td id="auto_amend"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_auto_amend">Auto Amend</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<!-- Basic RFA Only : End -->
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_coffer">C/offer</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_approve">Approve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_cancel" id="btn_cancel_txt">Cancel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_copy">Copy</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_print">Print</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				
			</tr>
			</table>
		</td></tr>
		</table>
    <!--Button (E) -->
		<!--biz page (S)-->
	<!-- Hidden sheet for Transaction (S) -->
	<script language="javascript">ComSheetObject('sheet1');</script>	
	<!-- Hidden sheet for Transaction (E) -->			
		<table class="search"> 
       	<tr><td class="bg">
				<!--  biz_1  (S) -->
				<table class="Search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="53">RFA No.</td>
					<td width="110"><input type="text" style="width:102;text-align:center;" class="input" name="rfa_no" maxlength="11" dataformat="engup"></td>
					<td width="64">AMD No.</td>
					<td width="48"><input type="text" style="width:35;text-align:center;" class="input2" name="amdt_seq" readonly ></td>
					<td width="80">Proposal No.</td>
					<td width="110"><input type="text" style="width:102;text-align:center;" class="input" name ="prop_no" maxlength="11" dataformat="engup"></td>
					<td width="105"><table width="100" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr>
					
					<td class="btn2_left"></td>
					<td class="btn2">
						<table><tr><td>
						<img src="img/tab_icon1.gif" width="16" height="16" border="0" align="absmiddle"  id="img_dur">
						</td></tr></table>
					</td>					
					<td class="btn2"  name="btn_dur_pop" id="btn_dur">Duration</td>										
					<td class="btn2_right"></td>
					
					</tr>
				</table></td></td>
					<td width="185">
					<input type="text" style="width:80;text-align:center;" class="input1" caption="Effective date" name="ctrt_eff_dt" cofield="ctrt_exp_dt" maxlength="10" dataformat="ymd" readonly required>&nbsp;~&nbsp;<input type="text" style="width:80;text-align:center;" class="input1" caption="Expiration date" name="ctrt_exp_dt" cofield="ctrt_eff_dt" maxlength="10" dataformat="ymd" readonly required>&nbsp;
					</td>
					<td width="20">
					<table><tr><td>
					<img src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor" name="btns_calendar1" >
					</td></tr></table>
					</td>
					<td width="21"></td>
					<td width="37">Status&nbsp;</td>
					<td><input type="text" style="width:84;text-align:center;" class="input2" name="prop_sts" readonly></td>
					<td width="8">
						<table border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_bg">
								<table border="0" cellpadding="0" cellspacing="0" class="button">
									<tr>
										<td class="btn1_line"></td>
									</tr>
								</table>
								</td>
							</tr>
						</table>
						</td>
					<td width="20"><img src="img/btns_inquiry.gif" width="19" height="20" alt="" border="0" align="absmiddle" name="btn_hidden" class="cursor"></td>
					</tr>
				</table>				
				
				<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
				
				<!-----div---->			
				<div id="subterms" >	
				
				<table class="Search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="99">Request Office</td>
					<td width="90"><input type="text" style="width:55;text-align:center;" class="input1" name="prop_ofc_cd"  dataformat="engup" readonly caption="Request Office Code" required></td>
					<td width="67">Sales Rep.</td>
					<td width="322"><script language="javascript">ComComboObject('prop_srep_cd', 2, 67, 0, 1);</script>&nbsp;<input type="text" style="width:184;text-align:left;" class="input2" name="prop_srep_nm" readonly></td>
					<td width="90">Creation Date</td>
					<td width="130"><input type="text" style="width:80;text-align:center;" class="input2" maxlength="10" dataformat="ymd" name="cre_dt" readonly></td>
					<td width="70">RFA Type</td>
					<td width=""><script language="javascript">ComComboObject('rfa_ctrt_tp_cd', 1, 110, 0, 1);</script></td>
				</tr>
				</table>
								
				<table class="Search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="99">Approval Office</td>
					<td width="90"><input type="text" style="width:55;text-align:center;" class="input2" name="prop_apro_ofc_cd" readonly></td>
					<td width="97">Approval Staff</td>
					<td width="292"><input type="text" style="width:223;text-align:left;" class="input2" name="prop_apro_staff" readonly></td>
					<td width="90">Approval Date</td>
					<td width=""><input type="text" style="width:80;text-align:center;" class="input2" maxlength="10" dataformat="ymd" name="prop_apro_dt" readonly></td>				
				</tr>
				</table>				
				
				
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="99">Customer</td>
					<td width="57" style="padding-left:0"><input type="text" style="width:55;text-align:center;" class="input1" dataformat="engup" maxlength="2" minlength="2" name="ctrt_cust_cnt_cd" readonly caption="Customer Code" required> 
					</td>
					<td width="59"><input type="text" style="width:55;text-align:center;" class="input1" dataformat="int" name="ctrt_cust_seq" maxlength="6" readonly caption="Customer Code" required>
					</td>
					<td width="22"><table><tr><td>
						<img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_ctrt_cust">
					</td></tr></table></td>
					<td width="274"><input type="text" style="width:272;text-align:left;" class="input2"  name="ctrt_pty_nm"  readonly>
					</td>
					<td width="69"><input type="text" style="width:67;text-align:center;" class="input2" name="prc_ctrt_cust_tp_nm" readonly> 
					</td>
					<td width="54"><input type="text" style="width:52;text-align:center;" class="input2" name="ctrt_cust_val_sgm" readonly> 
					</td>
					<td width="71"><input type="text" style="width:67;text-align:center;" class="input2" name="respb_sls_ofc_cd" readonly caption="Customer Code"> 
					</td>
					<td width="93"><script language="javascript">ComComboObject('respb_srep_cd', 3, 92, 0,1);</script>
					</td>
					<td><input type="text" style="width:177;" class="input2" name="ctrt_cust_srep_nm" readonly>
					</td>
				</tr>
				</table>					
										
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="100">Target MVC</td>
					<td width="59" style="padding-left:1;"><input type="text" style="width:55;text-align:right;" class="input" name="tgt_mvc_qty" dataformat="int" readonly caption="Target MVC" maxlength="6" ></td>
					<td width="83"><script language="javascript">ComComboObject('cntr_lod_ut_cd', 1, 57, 0);</script></td>
					<td width="75">Weekly MVC</td>
					<td width="136"><input type="text" style="width:50;text-align:right;" class="input2" name="prop_mvc" dataformat="int" maxlength="6" readonly > 
					<input type="text" style="width:40;text-align:center;" class="input2"  name="prop_mvc_tp" readonly></td>
					<td width="70">Sales Lead</td>
					<td width="91"><script language="javascript">ComComboObject('sls_ld_no', 2, 68, 0);</script></td>
					<td width="102"><table width="101" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2">
						<img class="cursor" src="img/tab_icon1.gif" width="16" height="16" border="0" align="absmiddle" id="img_dmdt"></td>					
					<td class="btn2" name="btn_free_pop" id="btn_free">Free Time</td>					
					<td class="btn2_right"></td>
					</tr>
				</table></td>
					<td width="94"><script language="javascript">ComComboObject('dmdt_ft_tp_cd', 1, 92, 0, 1);</script></td>
					<td width="85"><table width="84" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td>
					<table><tr>
					<td class="btn2" name="btn_dem_pop" id="btn_dem"> DEM/DET</td>					
					<td class="btn2_right"></td>
					</tr></table>
					</td>
					</tr>
				</table></td>
					<td width="">
					<table width="95" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2"><img class="cursor" src="img/tab_icon1.gif" width="16" height="16" border="0" align="absmiddle" name="img_affil"></td>
					<td class="btn2" name="btn_afil_pop" id="btn_afil">Affiliate</td>
					<td class="btn2_right"></td>
					</tr>
					</table>
					</td></tr>
				</table>					
								
				<table class="search_sm2" border="0" style="width:978;"> 
				<tr class="h23">
					<td width="39">PRS</td>
					<td width="252" class="stm">Actual CM <input type="text" style="width:120;text-align:right;" class="input2" readonly dataformat="int" name="prs_crnt_cm_amt"> <input type="text" style="width:35;text-align:center;" class="input2" value="USD" readonly></td>
					<td width="251" class="stm">Estimate CM <input type="text" style="width:120;text-align:right;" class="input2" readonly dataformat="int" name="prs_estm_cm_amt"> <input type="text" style="width:35;text-align:center;" class="input2" value="USD" readonly></td>
					<td width="250" class="stm">CM (SUM) <input type="text" style="width:120;text-align:right;" class="input2" readonly dataformat="int" name="prs_sum_cm_amt"> <input type="text" style="width:35;text-align:center;" class="input2" value="USD" readonly></td>
					<td  width="" class="stm">Target MVC estimate(PRS)&nbsp;<img src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" name="btn_mqc_estimate" id="btn_mqc_estimate" class="cursor"></td>
				</tr>
				</table>
				
				
				<!-- Grid  (S) -->
				<table width="979"  id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet2');</script>
						</td>
					</tr>
				</table>
				<!-- Grid (E) -->
				<table width="979" class="button">
		       	<tr><td class="btn2_bg">
					<table border="0" cellpadding="0" cellspacing="0">
							<tr>
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
					</tr>
					</table>
				</td></tr>
				</table>				
				<!--  biz_2   (E) -->
				</div>
				<!-----div end---->	
				</td></tr>
			</table>	
	<!--biz page (E)-->		

	<!-- Hidden sheet for Transaction (S) -->
	<script language="javascript">ComSheetObject('sheet3');</script>	
	<!-- Hidden sheet for Transaction (E) -->
	
			<table class="height_8"><tr><td></td></tr></table>
			
			<!-- Tab ) (S) -->
     		<table class="tab" border="0" cellpadding="0" cellspacing="0" width="100%"> 
       		<tr><td width="100%">
						<script language="javascript">ComTabObject('tab1')</script>
						<!-- img src="img/sub_tab.gif" alt="" width="998" height="23" border="0" -->
					</td></tr>
				</table>
			<!-- Tab ) (E) -->
		
			<!-- iFrame (S) -->
			<div id="tabLayer1"   style="display:none">
			<iframe name="t1frame" id="t1frame" frameborder="0" scrolling="no" width="100%" height="380" src="about:blank"></iframe>
			</div>
            <div id="tabLayer2" style="display:none">
            <iframe name="t2frame" id="t1frame" frameborder="0" scrolling="no" width="100%" height="380" src="about:blank"></iframe>
            </div>
            <div id="tabLayer3" style="display:none">
            <iframe name="t3frame" id="t1frame" frameborder="0" scrolling="no" width="100%" height="380" src="about:blank"></iframe>
            </div>
            <div id="tabLayer4" style="display:none">
            <iframe name="t4frame" id="t1frame" frameborder="0" scrolling="no" width="100%" height="380" src="about:blank"></iframe>
            </div>
            <div id="tabLayer5" style="display:none">
            <iframe name="t5frame" id="t1frame" frameborder="0" scrolling="no" width="100%" height="778" src="about:blank"></iframe>
            </div>
            <div id="tabLayer6" style="display:none">
             <iframe name="t6frame" id="t1frame" frameborder="0" scrolling="no" width="100%" height="778" src="about:blank"></iframe>
            </div>
            <div id="tabLayer7" style="display:none">
            <iframe name="t7frame" id="t1frame" frameborder="0" scrolling="no" width="100%" height="600" src="about:blank"></iframe>
            </div>
            <div id="tabLayer8" style="display:none">
            <iframe name="t8frame" id="t1frame" frameborder="0" scrolling="no" width="100%" height="380" src="about:blank"></iframe>
            </div>
            <div id="tabLayer9" style="display:none">
             <iframe name="t9frame" id="t1frame" frameborder="0" scrolling="no" width="100%" height="785" src="about:blank"></iframe>
            </div>
                                
			<!-- iFrame (E) -->				
	<!--biz page (E)-->
	 <table class="height_8"><tr><td></td></tr></table>      
	</td></tr>
</table>
 <!-- 개발자 작업  끝 -->
</form>
</body>
</html>