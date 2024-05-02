<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_0004.jsp
*@FileTitle : Proposal & Amendment Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.25
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.09.25 공백진
* 1.0 Creation
===============================================================================================
* History
* 2011.10.18 서미진 [CHM-201113907] S/C 화면에서 복수의 Real customer 입력 가능토록 시스템 보완개발요청 [Inquiry 화면] (ESM_PRI_0041)
* 2011.11.18 서미진 [CHM-201114462] SC No. 를 한칸으로 변경하여 copy & paste 기능 이용 할 수 있도록 정정요청
* 2014.09.17 송호진 [CHM-201430558] FMC Auto-filing 개발 요청
===============================================================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.event.EsmPri0004Event"%>
<%@ page import="com.hanjin.syscommon.common.table.PriSpMnVO"%>
<%@ page import="com.hanjin.framework.component.util.code.CodeInfo"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.common.PRIUtil"%>
<%@ page import="java.util.List"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.List"%>

<%
	EsmPri0004Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_ofc		= "";
	String strUsrSrepCd     = "";
    String propNo = null;
    String searchFlg = null;
	Logger log = Logger.getLogger("com.hanjin.apps.SCProposal.SCProposalMain");
	String[] appList = null;
	String[] preList = null;
	String[] mqcSignList = null;
	String[] scTypeList = null;
	String[] stsTypeList = null;
	String[] saleRepList = null;
	String[] custTpCd = null;
    // 0060 넘겨주는 파라미터	
    String scNoP = "";
    String scNoS = "";
    String sPropNo = "";
    String expDt = "";
    String effDt = "";
    
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_ofc = account.getOfc_cd();
		strUsrSrepCd = account.getSrep_cd();
		event = (EsmPri0004Event)request.getAttribute("Event");
        
		PriSpMnVO vo = event.getPriSpMnVO();
        
        if (vo != null) {
            propNo = vo.getPropNo();
        } else {
            propNo = "";
        }
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		

		
	    // esm_bkg_0427 에서 넘겨주는 파라미터  
	    scNoP = JSPUtil.getNull(request.getParameter("sc_no_p"));
	    scNoS = JSPUtil.getNull(request.getParameter("sc_no_s"));
	    sPropNo = JSPUtil.getNull(request.getParameter("sprop_no"));
	    expDt = JSPUtil.getNull(request.getParameter("exp_dt"));
	    effDt = JSPUtil.getNull(request.getParameter("eff_dt"));
	    
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		appList = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("appList"), true);
		preList = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("preList"), true);
		mqcSignList = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("mqcSignList"), true ,"|","\t","getCode","getName");		
		scTypeList = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("scTypeList"), false ,"|","\t","getCode","getName");	
		stsTypeList = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("stsTypeList"), false ,"|","\t","getCode","getName");	
       
		custTpCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("custTypeList"), true ,"|","\t","getCode","getName");	
		saleRepList = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("saleRepList"), true);          
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Proposal & Amendment Inquiry</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
    var appListValue = " |<%=appList[0]%>";
    var appListText = " |<%=appList[1]%>";
    var preListValue = " |<%=preList[0]%>";
    var preListText = " |<%=preList[1]%>";
    var mqcSignListValue = " |<%=mqcSignList[0]%>";
    var mqcSignListText = " |<%=mqcSignList[1]%>";
    var scTypeListValue = " |<%=scTypeList[0]%>";
    var scTypeListText = " |<%=scTypeList[1]%>";    
    var stsTypeListValue = " |<%=stsTypeList[0]%>";
    var stsTypeListText = " |<%=stsTypeList[1]%>";    
     
    var saleListValue = " |<%=saleRepList[0]%>";
    var saleListText = " |<%=saleRepList[1]%>";        
    var custTpCdValue = "<%=custTpCd[0]%>";
    var custTpCdText = "<%=custTpCd[1]%>";
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
<input type="hidden" name="in_usr_srep_cd" value="<%=strUsrSrepCd%>">
<input type="hidden" name="in_usr_nm" value="<%=strUsr_nm%>">
<input type="hidden" name="oti_eff_dt" >
<input type="hidden" name="oti_exp_dt" >
<input type="hidden" name="oti_amt" >
<input type="hidden" name="mst_prop_no" value="<%=propNo %>">
<input type="hidden" name="send_usr_nm" value="<%=strUsr_nm%>">
<input type="hidden" name="gw_subject">
<input type="hidden" name="gw_contents">
<input type="hidden" name="gw_template">
<input type="hidden" name="gw_args">
<input type="hidden" name="ssc_no">
<input type="hidden" name="smqc_sign_nm">
<!-- 0060 에서 넘겨주는 값 -->
<input type="hidden" name="sc_no_p" value="<%=scNoP%>">
<input type="hidden" name="sc_no_s" value="<%=scNoS%>">
<input type="hidden" name="exp_dt" value="<%=expDt%>">
<input type="hidden" name="eff_dt" value="<%=effDt%>">

<input type="hidden" name="backendjob_key">
<input type="hidden" name="job_status">
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
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:0;">
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
					<td class="btn1" name="btn_proposal">Open Proposal</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>				
				
				<td class="btn1_line"></td>

				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_history">AMD History</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>					
				
				</tr>
			</table></td>
			</tr>
			</table>
    <!--Button (E) -->
	<table class="height_2"><tr><td colspan="8"></td></tr></table>
	
	
	<!--biz page (S)-->
		<table class="search">
       	<tr><td class="bg">
       	<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="93">S/C No.</td>
					<td width="120">
						<input type="text" style="width:110; text-align: center;" name="sc_no_input" maxlength="9" class="input" dataformat="engup"></td>
					<td width="82">Proposal No.</td>
					<td width="158"><input type="text" style="width:126;text-align:center;" class="input" name="sprop_no" dataformat="engup" maxlength="10" value="<%=sPropNo%>"></td>
					<td width="83">S/C EFF Date</td>
					<td width="262">
						<input type="text" style="width:75;text-align:center;" class="input" name="seff_dt1" maxlength="10" dataformat="ymd">&nbsp;<img src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor" name="btns_calendar1">&nbsp;~&nbsp;
						<input type="text" style="width:75;text-align:center;" class="input" name="seff_dt2" maxlength="10" dataformat="ymd">&nbsp;<img src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor" name="btns_calendar2"></td>
					<td width="62">Status</td>
					<td>
					<script language="javascript">ComComboObject('sprop_sts_cd', 1, 88, 0, 0);</script>
					</td></tr>
				</table>
				
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="92">Request Office</td>
					<td width="71"><input type="text" style="width:55;text-align:center;" class="input" name="sprop_ofc_cd" dataformat="engup"></td>
					<td width="65">Sales Rep.</td>
					<td width="236">
						<script language="javascript">ComComboObject('sprop_srep_cd', 2, 93, 0, 0);</script>&nbsp;<input type="text" style="width:126;" class="input2" name="sprop_srep_nm" readonly></td>
					<td width="102">Approval Office</td>
					<td width="87">
						<script language="javascript">ComComboObject('sprop_apro_ofc_cd', 2, 75, 0, 0);</script>&nbsp;
						</td>
					<td width="33">MQC</td>
					<td width="140">
						<script language="javascript">ComComboObject('smqc_sign_cd', 1, 47, 0, 0);</script>&nbsp;<input type="text" style="width:80;text-align:right;" class="input" name="sprop_mqc_qty" dataformat="int"></td>
					<td width="62">S/C Type</td>
					<td><script language="javascript">ComComboObject('ssc_type_cd', 1, 88, 0, 0);</script></td>
					</tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="92">Customer</td>
					<td width="370"><input type="text" style="width:25;" class="input" name="scust_cnt_cd" dataformat="engup" maxlength="2" minlength="2">&nbsp;<input type="text" style="width:55;" class="input" name="scust_seq" dataformat="int" maxlength="6">&nbsp;<img src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" name="btn_ctrt_cust" class="cursor">&nbsp;<input type="text" style="width:246;" class="input2" name="sctrt_pty_nm" readonly></td>
					<td width="104">Customer Type</td>
					<td width=""><script language="javascript">ComComboObject('sprc_ctrt_cust_tp_cd', 2, 75, 0, 0);</script> </td>
				</tr>			
				</table>
				<!--  biz_1  (E) -->
				
				<!-- Grid  (S) -->
				<table width="100%"  id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet0');</script>
						</td>
					</tr>
				</table>
				<!-- Grid (E) -->
			
		</td></tr>
			</table>	
	
	
	<table class="height_8"><tr><td></td></tr></table>
	
	
	
	<!-- Hidden sheet for Transaction (S) -->
	<script language="javascript">ComSheetObject('sheet1');</script>	
	<!-- Hidden sheet for Transaction (E) -->	
	
		<table class="search">
       	<tr><td class="bg">
				<!--  biz_2  (S) -->
				<table class="search" border="0" style="width:979;">
				<tr class="h23">
					<td width="48">S/C  No.</td>
					<td width="100">
						<input type="text" style="width:90;text-align:center;" class="input2" name="sc_no" readonly>&nbsp;</td>
					<td width="58">&nbsp;AMD No.</td>
					<td width="45"><input type="text" style="width:30;text-align:center;" class="input2" name="amdt_seq" readonly></td>
					<td width="80">Proposal No.</td>
					<td width="100"><input type="text" style="width:85;text-align:center;" class="input2" name="prop_no" readonly></td>
					<td width="55">Duration</td>
					<td width="178">
						<input type="text" style="width:75;text-align:center;" class="input2" name="ctrt_eff_dt" readonly>&nbsp;~&nbsp;<input type="text" style="width:75;text-align:center;" class="input2" name="ctrt_exp_dt" readonly></td>
					<td width="70"><input type="checkbox" value="" class="trans" name="rf_flg" >&nbsp;Reefer</td>
					<td width="85"><input type="checkbox" value="" class="trans" name="gamt_flg" >&nbsp;Garment</td>
					<td width="45">Status</td>
					<td width="75"><input type="text" style="width:65;" class="input2" name="prop_sts" readonly></td>
					<td width="8">
		   				 <table border="0" cellpadding="0" cellspacing="0" class="button">
		    				<tr><td class="btn1_bg"><table border="0" cellpadding="0" cellspacing="0" class="button">
		    				<tr><td class="btn1_line"></td></tr></table></td></tr></table>
		    		</td>
					<td width="25"><img src="img/btns_inquiry.gif" width="19" height="20" alt="" border="0" align="absmiddle" name="btn_hidden" class="cursor"></td>
					</tr>
				</table>
				<!--  biz_2   (E) -->

				<table class="line_bluedot" style="width:979;"><tr><td colspan="8"></td></tr></table>

				<!-----div---->			
				<div id="subterms" >	

				<!--  biz_3  (S) -->

				<table class="search" border="0" style="width:979;">
				<tr class="h23">
					<td width="57">Req. OFC</td>
					<td width="87"><input type="text" style="width:72;" class="input2" name="prop_ofc_cd" readonly></td>
					<td width="45">S. Rep.</td>
					<td width="158"><input type="text" style="width:61;" class="input2" name="prop_srep_cd" readonly>
								<input type="text" style="width:80;" class="input2" name="prop_srep_nm" readonly></td>
					<td width="67">APVL OFC</td>
					<td width="73"><input type="text" style="width:67;" class="input2" name="prop_apro_ofc_cd" readonly></td>
					<td width="60">APVL STF</td>
					<td width="153"><input type="text" style="width:137;" class="input2" name="prop_apro_staff" readonly></td>
					<td width="75">Creation DT</td>
					<td width="85"><input type="text" style="width:75;" class="input2" name="cre_dt" readonly></td>
					<td width="50">Eff. DT</td>
					<td align=""><input type="text" style="width:75;" class="input2" name="file_dt" readonly></td>
					</tr>
				</table>
				<table class="search" border="0" style="width:979;">
				<tr class="h23">
					<td width="100">
					<table width="100" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2"><img class="cursor" src="img/tab_icon1.gif" width="16" height="16" border="0" align="absmiddle" name="img_ctrt"></td>
					<td class="btn2" name="btn_ctrt_pty_pop" id="btn_ctrt_pty">Customer</td>
					<td class="btn2_right"></td>
					</tr></table>
					
					</td>
					
					<td width="383"><input type="text" style="width:25;" class="input2" name="cust_cnt_cd" readonly>
					<input type="text" style="width:55;" class="input2" name="cust_seq" readonly>
					<input type="text" style="width:254;" class="input2" name="ctrt_pty_nm" readonly>
					<input type="text" style="width:30;text-align: center;" class="input2" name="prc_ctrt_cust_tp_cd" readonly></td>
					<td width="110">
						<input type="text" style="width:55;" class="input2" name="ctrt_cust_val_sgm" readonly>
						<input type="text" style="width:45;" class="input2" name="ctrt_cust_sls_ofc_cd" readonly></td>
					<td width="60"><input type="text" style="width:60;" class="input2" name="ctrt_cust_srep_cd" readonly></td>
					<td width="197"><input type="text" style="width:188;" class="input2" name="ctrt_cust_srep_nm" readonly></td>
					<td width="50">OTI No.</td>
					<td><input type="text" style="width:75;" class="input2" name="oti_no" dataformat="" readonly></td>
				</tr>
				</table>
				<table class="search" border="0" style="width:979;">
				<tr class="h23">
				
					<td width="100">
					<table width="100" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class=btn2_left></td>			
					<td class="btn2" name="btn_real_cust_pop" id="btn_real_cust_pop"i>Real Cust.</td>
					<td class="btn2_right"></td>
					</tr></table>					
					</td>

					<td width="383">
						<input type="text" style="width:25;" class="input2" name="real_cust_cnt_cd" readonly>
						<input type="text" style="width:55;" class="input2" name="real_cust_seq" readonly>
						<input type="text" style="width:254;" class="input2" name="real_cust_nm" readonly>
						<input type="text" style="width:30;text-align: center;" class="input2" name="real_cust_tp_cd" readonly></td>
					<td width="110">
						<input type="text" style="width:55;" class="input2" name="real_cust_val_sgm" readonly>
						<input type="text" style="width:45;" class="input2" name="real_cust_sls_ofc_cd" readonly></td>
					<td width="60"><input type="text" style="width:60;" class="input2" name="real_cust_srep_cd" readonly></td>
					<td width=""><input type="text" style="width:188;" class="input2" name="real_cust_srep_nm" readonly></td>
				</tr>
				</table>
				
				<table class="search" border="0" style="width:979;">
				<tr class="h23">
					<td width="25">MQC</td>
					<td width="131">
						<input type="text" style="width:40;text-align:right;" class="input2" name="prop_mqc_qty" readonly dataformat="int">
						<input type="text" style="width:53;text-align:center;" class="input2" name="cntr_lod_ut_cd" readonly></td>
					
					<td width="30">MVC</td>
					<td width="80">
						<input type="text" style="width:30;text-align:right;" class="input2" name="prop_mvc" readonly dataformat="int">
						<input type="text" style="width:30;" class="input2" name="prop_mvc_tp" readonly> </td>
					<td width="35">PFMC</td>
					<td width="110">
						<input type="text" style="width:40;text-align:right;" class="input2" name="prop_pfmc" readonly dataformat="int">
						<input type="text" style="width:30;" class="input2" name="prop_pfmc_tp" readonly value="FEU">&nbsp;<img src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" name="btn_prop_pfmc_pop" class="cursor" ></td>
					<td width="52">Attainment</td>
					<td width="117"><input type="text" style="width:42;text-align:right;"  name="prop_atmt" class="input2"  readonly>&nbsp;<input type="text" style="width:33;" class="input2" value=" %" readonly></td>
					<td width="66">Sales Lead</td>
					<td width="110"><input type="text" style="width:95;" class="input2" name="sls_ld_no" readonly></td>
					<td><!--  Button_Sub (S) -->
			
			
					<table border="0" cellpadding="0" cellspacing="0"><tr>
							<td>							
							<table width="120" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2"><img class="cursor" src="img/tab_icon1.gif" width="16" height="16" border="0" align="absmiddle" name="img_blpl"></td>
							<td class="btn2" name="btn_blpl_pop" id="btn_blpl">Boiler Plate</td>
							<td class="btn2_right"></td>
							</tr>
							</table>							
							</td>
							<td>							
							<table width="85" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2"><img class="cursor" src="img/tab_icon1.gif" width="16" height="16" border="0" align="absmiddle" name="img_affil"></td>
							<td class="btn2" name="btn_afil_pop" id="btn_afil">Affiliate</td>
							<td class="btn2_right"></td>
							</tr>
							</table>							
							</td>
						</tr></table>
			
	    	<!-- Button_Sub (E) --></td>
					
				</tr>
				</table>
				<table class="search_sm2" border="0" style="width:765;">
				<tr class="h23">
					<td width="65">PRS</td>
					<td width="58" class="stm">Actual CM</td>
					<td width="172"><input type="text" style="width:110;text-align:right;" class="input2" readonly dataformat="int" name="prs_crnt_cm_amt">&nbsp;<input type="text" style="width:30;" class="input2" value=" USD" readonly></td>
					<td width="68" class="stm">Estimate CM</td>
					<td width="184"><input type="text" style="width:110;text-align:right;" class="input2" readonly dataformat="int" name="prs_estm_cm_amt">&nbsp;<input type="text" style="width:30;" class="input2" value=" USD" readonly></td>
					<td width="55" class="stm">CM (SUM)</td>
					<td width=""><input type="text" style="width:110;text-align:right;" class="input2" readonly dataformat="int" name="prs_sum_cm_amt">&nbsp;<input type="text" style="width:30;" class="input2" value=" USD" readonly></td>
					
					
				</tr>
				</table>
				
				
				
				
				<!-- Grid  (S) -->
				<table width="100%"  id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet2');</script>
						</td>
					</tr>
				</table>
				<!-- Grid (E) -->
				
				<!--  biz_2   (E) -->

				</td></tr>
			</table>

		<!--biz page (E)-->
		
			</div>
<!-----div end---->	
				
			<table class="height_8"><tr><td></td></tr></table>
			
			<!-- Tab ) (S) -->
     		<table class="tab" border="0" cellpadding="0" cellspacing="0" width="100%"> 
       		<tr><td width="100%">
						<script language="javascript">ComTabObject('tab1')</script>

					</td></tr>
				</table>
			<!-- Tab ) (E) -->
		
			<!-- iFrame (S) -->
			<div id="tabLayer" style="display:none">
			<iframe name="t1frame" id="t1frame" frameborder="0" scrolling="no" width="100%" height="380" src="about:blank"></iframe>
			</div>
            <div id="tabLayer" style="display:none">
            <iframe name="t2frame" id="t1frame" frameborder="0" scrolling="no" width="100%" height="380" src="about:blank"></iframe>
            </div>
            <div id="tabLayer" style="display:none">
            <iframe name="t3frame" id="t1frame" frameborder="0" scrolling="no" width="100%" height="380" src="about:blank"></iframe>
            </div>
            <div id="tabLayer" style="display:none">
            <iframe name="t4frame" id="t1frame" frameborder="0" scrolling="no" width="100%" height="380" src="about:blank"></iframe>
            </div>
            <div id="tabLayer" style="display:none">
            <iframe name="t5frame" id="t1frame" frameborder="0" scrolling="no" width="100%" height="700" src="about:blank"></iframe>
            </div>
            <div id="tabLayer" style="display:none">
            <iframe name="t6frame" id="t1frame" frameborder="0" scrolling="no" width="100%" height="380" src="about:blank"></iframe>
            </div>
            <div id="tabLayer" style="display:none">
            <iframe name="t7frame" id="t1frame" frameborder="0" scrolling="no" width="100%" height="380" src="about:blank"></iframe>
            </div>
            <div id="tabLayer" style="display:none">
            <iframe name="t8frame" id="t1frame" frameborder="0" scrolling="no" width="100%" height="380" src="about:blank"></iframe>
            </div>
            <div id="tabLayer" style="display:none">
            <iframe name="t9frame" id="t1frame" frameborder="0" scrolling="no" width="100%" height="380" src="about:blank"></iframe>
            </div>
            <div id="tabLayer" style="display:none">
            <iframe name="t10frame" id="t1frame" frameborder="0" scrolling="no" width="100%" height="380" src="about:blank"></iframe>
            </div>                                    
			<!-- iFrame (E) -->
			
		<table class="height_10"><tr><td colspan="8"></td></tr></table>
			
	</td></tr>
</table>
 <!-- 개발자 작업  끝 -->
</form>
</body>
</html>