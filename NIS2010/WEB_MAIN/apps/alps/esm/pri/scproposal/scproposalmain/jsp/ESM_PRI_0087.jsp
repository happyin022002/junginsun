<%
/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ESM_PRI_0087.jsp
*@FileTitle : S/C Proposal & Amendment View
*Open Issues :
*Change history :
*@LastModifyDate : 2011.08.09
*@LastModifier : 김민아
*@LastVersion : 1.0
* 2011.08.09 김민아
* 1.0 Creation
===========================================================
* History
* 2011.08.09 김민아 [CHM-201112688-01] Contract별 Inquiry 화면을 요청 : 특정 S/C 한건에 대한 조회  View Popup 신규 개발
* 2012.04.18 [CHM-201216522-01] BKG 화면에서 S/C 조회시 REAL CUSTOMER POPUP 추가
* 2013.09.05 전윤주 [CHM-201326372] Autorating 결과 계약 조회시 편의 기능 구현
                                - Autorating 에서 사용된 commodity, Route 일 경우 색 변경해줌
===========================================================*/
%>
 
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.event.EsmPri0087Event"%>
<%@ page import="com.hanjin.syscommon.common.table.PriSpMnVO"%>
<%@ page import="com.hanjin.framework.component.util.code.CodeInfo"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.common.PRIUtil"%>
<%@ page import="java.util.List"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.List"%>

<%
	EsmPri0087Event  event = null;					//PDTO(Data Transfer Object including Parameters)
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
    // 0427 넘겨주는 파라미터	
    String inScNo = "";
    String inPropNo = "";
    String inAmdtSeq = "";
    //BKG 0079_08 에서 넘겨주는 파라미터
	String sCmdtHdrSeqClr  = "";
	String sRoutSeqClr     = "";
	String sSvcScpCdClr    = "";
	String sGenSpclRtTpCdClr  = "";
    
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_ofc = account.getOfc_cd();
		strUsrSrepCd = account.getSrep_cd();
		event = (EsmPri0087Event)request.getAttribute("Event");
        
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
	    inScNo = JSPUtil.getNull(request.getParameter("sc_no"));
	    inPropNo = JSPUtil.getNull(request.getParameter("prop_no"));
	    inAmdtSeq = JSPUtil.getNull(request.getParameter("amdt_seq"));
	    //BKG 0079_08 에서 넘겨주는 파라미터
	    sCmdtHdrSeqClr = JSPUtil.getNull(request.getParameter("s_cmdt_hdr_seq"));
	    sRoutSeqClr = JSPUtil.getNull(request.getParameter("s_rout_seq"));	 
	    sSvcScpCdClr = JSPUtil.getNull(request.getParameter("s_svc_scp_cd"));	
	    sGenSpclRtTpCdClr = JSPUtil.getNull(request.getParameter("s_gen_spcl_rt_tp_cd"));	
	    
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>S/C Proposal & Amendment View</title>
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
<!-- 0427 에서 넘겨주는 값-->
<input type="hidden" name="in_sc_no" value="<%=inScNo%>">
<input type="hidden" name="in_prop_no" value="<%=inPropNo%>">
<input type="hidden" name="in_amdt_seq" value="<%=inAmdtSeq%>">
<!-- BKG 0079_08 에서 넘겨주는 값-->
<input type="hidden" name="s_svc_scp_cd_clr" value="<%=sSvcScpCdClr%>">
<input type="hidden" name="s_cmdt_hdr_seq_clr" value="<%=sCmdtHdrSeqClr%>">
<input type="hidden" name="s_rout_seq_clr" value="<%=sRoutSeqClr%>">
<input type="hidden" name="s_gen_spcl_rt_tp_cd_clr" value="<%=sGenSpclRtTpCdClr%>">

<input type="hidden" name="backendjob_key">
<input type="hidden" name="job_status">
<!-- 개발자 작업	-->

<table width="100%" class="popup" cellpadding="10" border="0">
	<tr><td class="top"></td></tr>
	<tr><td valign="top">
		
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;S/C Proposal & Amendment View</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
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
					<td width="50">Filed DT</td>
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
		
			<!-- : ( Button : pop ) (S) -->
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
								</tr>
							</table></td>
						</tr>
					</table></td>
						</tr>
					</table>
			    <!--Button (E) -->
				
				</td></tr>
			</table>
			<!-- : ( Button : pop ) (E) -->
			
	</td></tr>
</table>
 <!-- 개발자 작업  끝 -->
</form>
</body>
</html>