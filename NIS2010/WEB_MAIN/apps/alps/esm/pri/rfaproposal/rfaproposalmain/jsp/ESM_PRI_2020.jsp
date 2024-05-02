<%
/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ESM_PRI_2020.jsp
*@FileTitle : Proposal & Amendment Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2011.08.05
*@LastModifier : 이관샨
*@LastVersion : 1.0
* 2011.08.05 이관샨
* 1.0 Creation
=========================================================
* History
* 2012.06.25 서미진 [CHM-201217633] 구주 Hinterland Operation 개선 Project : Rate (For AEE/AEW), Arbitrary (For AEE/AEW) 화면 추가 
* 2013.02.06 이은섭 [CHM-201322936] Add On Tariff 개선 프로젝트 : Rate, Arbitrary 탭 추가
* 2013.09.05 전윤주 [CHM-201326372] Autorating 결과 계약 조회시 편의 기능 구현
                                  -BKG으로부터 parameter 넘겨받아 하위 탭으로 넘겨줌
* 2014.05.26 최성환 [CHM-201430277] 표시 정보 추가 요청 at RFA View screen 화면 추가                                     
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.event.EsmPri2020Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.List"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.common.PRIUtil"%>
<%@ page import="com.hanjin.framework.component.util.code.CodeInfo"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>
<%
	EsmPri2020Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String sRfaNo = "";
	String sAmdtSeq = "";
	
	 //BKG 0079_08 에서 넘겨주는 파라미터
	String sCmdtHdrSeqClr  = "";
	String sRoutSeqClr     = "";
	String sSvcScpCdClr   = "";
	
	String condPropNo = null;
	String sPropNo = "";
	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_ofc		= "";
	String strUsrSrepCd     = "";
	
	Logger log = Logger.getLogger("com.hanjin.apps.RFAProposal.RFAProposalMain");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_ofc = account.getOfc_cd();
	    strUsrSrepCd = account.getSrep_cd();
		event = (EsmPri2020Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		sRfaNo = JSPUtil.getNull(request.getParameter("s_rfa_no")); //ems_bkg_0427 에서 pop 호출
		sPropNo = JSPUtil.getNull(request.getParameter("s_prop_no"));
		sAmdtSeq = JSPUtil.getNull(request.getParameter("s_amdt_seq"));
		
		//BKG 0079_08 에서 넘겨주는 파라미터
	    sCmdtHdrSeqClr = JSPUtil.getNull(request.getParameter("s_cmdt_hdr_seq"));
	    sRoutSeqClr = JSPUtil.getNull(request.getParameter("s_rout_seq"));	 
	    sSvcScpCdClr = JSPUtil.getNull(request.getParameter("s_svc_scp_cd"));	 
		
        condPropNo = JSPUtil.getNull(request.getParameter("cond_prop_no"));
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Proposal & Amendment Inquiry</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
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
<!-- BKG 0079_08 에서 넘겨주는 값-->
<input type="hidden" name="s_svc_scp_cd_clr" value="<%=sSvcScpCdClr%>">
<input type="hidden" name="s_cmdt_hdr_seq_clr" value="<%=sCmdtHdrSeqClr%>">
<input type="hidden" name="s_rout_seq_clr" value="<%=sRoutSeqClr%>">
<!--  2043 에서 팝업 호출시 사용-->
<!--  2049 에서 호출시 사용-->
<input type="hidden" name="cond_prop_no" value="<%=condPropNo%>">

<!-- 개발자 작업	-->

<table width="95%" border="0" class="popup" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
	<!--Page Title, Historical (S)-->
	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;RFA Proposal & Amendment View</td></tr>
	</table>
	<!--Page Title, Historical (E)-->
	
		<!--biz page (S)-->		
		<table class="search"> 
       	<tr><td class="bg">
				<!--  biz_2  (S) -->
	<!-- Hidden sheet for Transaction (S) -->
	<script language="javascript">ComSheetObject('sheet1');</script>	
	<!-- Hidden sheet for Transaction (E) -->	
				<!--  biz_1  (S) -->
				<table class="Search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="55">RFA No.</td>
					<td width="112"><input type="text" style="width:98;text-align:center;" class="input2" name="rfa_no" dataformat="engup" value="<%=sRfaNo%>" readonly></td>
					<td width="67">AMD No.</td>
					<td width="65"><input type="text" style="width:35;text-align:center;" class="input2" name="amdt_seq" value="<%=sAmdtSeq%>"  readonly></td>
					<td width="85">Proposal No.</td>
					<td width="164"><input type="text" style="width:100;text-align:center;" class="input2" name="prop_no" dataformat="engup" value="<%=sPropNo%>" readonly></td>
					<td width="60">Duration</td>
					<td width="235"><input type="text" style="width:80;text-align:center;" class="input2" name="ctrt_eff_dt" maxlength="10" dataformat="ymd" readonly>&nbsp;~&nbsp;<input type="text" style="width:80;text-align:center;" class="input2" name="ctrt_exp_dt" cofield="ctrt_eff_dt" maxlength="10" dataformat="ymd" readonly></td>
					<td width="45">Status</td>
					<td><input type="text" style="width:84;text-align:center;" class="input2" name="prop_sts" readonly></td>		
					</tr>
				</table>
				
				<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
				<!-----div---->			
				<!-- div id="subterms" -->
				
				<table class="Search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="95">Request Office</td>
					<td width="70"><input type="text" style="width:55;text-align:center;" class="input2" name="prop_ofc_cd"  dataformat="engup" readonly></td>
					<td width="67">Sales Rep.</td>
					<td width="363"><input type="text" style="width:65;text-align:center;" class="input2" name="prop_srep_cd" dataformat="engup" readonly>&nbsp;<input type="text" style="width:182;text-align:left;" class="input2" name="prop_srep_nm" readonly></td>
					<td width="90">Creation Date</td>
					<td width=""><input type="text" style="width:80;text-align:center;" class="input2" maxlength="10" dataformat="ymd" name="cre_dt" readonly></td>
					<!-- CHM-201430277 -->
					<td width="65">RFA Type</td>
					<td width=""><input type="text" style="width:115;text-align:center;" class="input2" name="rfa_ctrt_tp_cd"  dataformat="engup" readonly></td>				
					</tr>
				</table>
				
				<table class="Search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="95">Approval Office</td>
					<td width="70"><input type="text" style="width:55;text-align:center;" class="input2" name="prop_apro_ofc_cd" readonly></td>
					<td width="97">Approval Staff</td>
					<td width="333"><input type="text" style="width:221;text-align:left;" class="input2" name="prop_apro_staff" readonly></td>
					<td width="90">Approval Date</td>
					<td width=""><input type="text" style="width:80;text-align:center;" class="input2" maxlength="10" dataformat="ymd" name="prop_apro_dt" readonly></td>
					</tr>
				</table>
				
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="95">Customer</td>
					<td><input type="text" style="width:55;text-align:center;" class="input2" dataformat="engup" maxlength="2" minlength="2" name="ctrt_cust_cnt_cd" readonly> 
						<input type="text" style="width:77;text-align:center;" class="input2" dataformat="int" name="ctrt_cust_seq" maxlength="6" readonly> 
						<input type="text" style="width:248;text-align:left;" class="input2" name="ctrt_pty_nm" readonly> 
						<input type="text" style="width:67;text-align:center;" class="input2" name="prc_ctrt_cust_tp_nm" readonly> 
						<input type="text" style="width:52;text-align:center;" class="input2" name="ctrt_cust_val_sgm" readonly> 
						<input type="text" style="width:67;text-align:center;" class="input2" name="respb_sls_ofc_cd" readonly>  
						<input type="text" style="width:80;text-align:center;" class="input2" name="respb_srep_cd" readonly> 
						<input type="text" style="width:187;" class="input2" name="ctrt_cust_srep_nm" readonly></td></tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="95">Target MVC</td>
					<td width="150">
						<input type="text" style="width:55;text-align:right;" class="input2" name="tgt_mvc_qty" dataformat="int" readonly caption="Target MVC" maxlength="6"> 
						<input type="text" style="width:77;text-align:center;" class="input2" name="cntr_lod_ut_cd" readonly></td>
					<td width="75">Weekly MVC</td>
					<td width="103">
						<input type="text" style="width:50;text-align:right;" class="input2" name="prop_mvc" dataformat="int" maxlength="6" readonly> 
						<input type="text" style="width:30;" class="input2" name="prop_mvc_tp" readonly></td>
					<td width="65">Sales Lead</td>
					<td width="137"><input type="text" style="width:67;text-align:center;" class="input2" name="sls_ld_no" readonly></td>
					<td width="60">Free Time</td>
					<td width="90"><input type="text" style="width:80;text-align:center;" class="input2" name="dmdt_ft_tp_cd" readonly></td>
					<td width="83">
						<table width="80" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_dem_pop" id="btn_dem">DEM/DET</td>
						<td class="btn2_right"></td>
						</tr>
						</table>
					</td>
					<td width="">
						<table width="101" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2"><img class="cursor" src="img/tab_icon1.gif" width="16" height="16" border="0" align="absmiddle" name="img_affil"></td>
						<td class="btn2" name="btn_afil_pop" id="btn_afil">Affiliate</td>
						<td class="btn2_right"></td>
						</tr>
						</table>
					</td>
				</tr>
				</table>
				<table class="search_sm2" border="0" style="width:800;"> 
				<tr class="h23">
					<td width="66">PRS</td>
					<td width="245" class="stm">Actual CM&nbsp;&nbsp;<input type="text" style="width:100;text-align:right;" class="input2" readonly dataformat="int" name="prs_crnt_cm_amt">&nbsp;<input type="text" style="width:35;text-align:center;" class="input2" value="USD" readonly></td>
					<td width="249" class="stm">Estimate CM&nbsp;&nbsp;<input type="text" style="width:100;text-align:right;" class="input2" readonly dataformat="int" name="prs_estm_cm_amt">&nbsp;<input type="text" style="width:35;text-align:center;" class="input2" value="USD" readonly></td>
					<td width="" class="stm">CM (SUM)&nbsp;&nbsp;<input type="text" style="width:100;text-align:right;" class="input2" readonly dataformat="int" name="prs_sum_cm_amt">&nbsp;<input type="text" style="width:35;text-align:center;" class="input2" value="USD" readonly></td>
				</tr>
				</table>
				<!--  biz_2   (E) -->
				
				<!-- Grid  (S) -->
				<table width="979"  id="mainTable">
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
<!-- /div -->
<!-----div end---->	
	
			<table class="height_8"><tr><td></td></tr></table>
			<!-- Tab ) (S) -->
     		<table class="tab" border="0" cellpadding="0" cellspacing="0" width=100%> 
       		<tr><td width="100%">
						<script language="javascript">ComTabObject('tab1')</script>
						<!-- img src="img/sub_tab.gif" alt="" width="998" height="23" border="0" -->
					</td></tr>
				</table>
			<!-- Tab ) (E) -->
			<!-- iFrame (S) -->
			<div id="tabLayer1" style="display:none">
				<iframe name="t1frame" id="t1frame" frameborder="0" scrolling="no" width="100%" height="700" src="about:blank"></iframe>
			</div>
			<div id="tabLayer2" style="display:none">
				<iframe name="t2frame" id="t2frame" frameborder="0" scrolling="no" width="100%" height="700" src="about:blank"></iframe>
			</div>
			<div id="tabLayer3" style="display:none">
				<iframe name="t3frame" id="t3frame" frameborder="0" scrolling="no" width="100%" height="700" src="about:blank"></iframe>
			</div>
			<div id="tabLayer4" style="display:none">
				<iframe name="t4frame" id="t4frame" frameborder="0" scrolling="no" width="100%" height="380" src="about:blank"></iframe>
			</div>
			<div id="tabLayer5" style="display:none">
				<iframe name="t5frame" id="t5frame" frameborder="0" scrolling="no" width="100%" height="380" src="about:blank"></iframe>
			</div> 
			<div id="tabLayer6" style="display:none">
				<iframe name="t6frame" id="t6frame" frameborder="0" scrolling="no" width="100%" height="380" src="about:blank"></iframe>
			</div>   
			<div id="tabLayer7" style="display:none">
				<iframe name="t7frame" id="t7frame" frameborder="0" scrolling="no" width="100%" height="380" src="about:blank"></iframe>
			</div>   
			<div id="tabLayer8" style="display:none">
				<iframe name="t8frame" id="t8frame" frameborder="0" scrolling="no" width="100%" height="380" src="about:blank"></iframe>
			</div>  
			<div id="tabLayer9" style="display:none">
				<iframe name="t9frame" id="t9frame" frameborder="0" scrolling="no" width="100%" height="530" src="about:blank"></iframe>
			</div>               
			<!-- iFrame (E) -->				
	<!--biz page (E)-->
        
	</td></tr>
	
		<!-- : ( Button : pop ) (S) -->
			<table width="95%" class="sbutton">
			<tr><td height="71" class="popup">
				
					<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
			       	<tr><td class="btn3_bg">
					    <table border="0" cellpadding="0" cellspacing="0">
					    <tr>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td>
								<td class="btn1" name="btn_close">Close</td>
								<td class="btn1_right"></td>
								</tr>
							</table></td>
						</tr>
					</table></td>
						</tr>
					</table>
			    <!--Button (E) -->
	
</table>

 <!-- 개발자 작업  끝 -->
</form>
</body>
</html>