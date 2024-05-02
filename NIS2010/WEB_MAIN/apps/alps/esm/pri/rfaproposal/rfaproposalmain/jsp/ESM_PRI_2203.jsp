<%
/*=========================================================
 *Copyright(c) 2016 CyberLogitec
 *@FileName : ESM_PRI_2203.js
 *@FileTitle : Master RFA Creation & Amendment
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2016.04.26
 *@LastModifier : 
 *@LastVersion : 1.0
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
<%@ page import="com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.event.EsmPri2203Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.common.PRIUtil"%>
<%@ page import="com.hanjin.framework.component.util.code.CodeInfo"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>
<%@ page import="com.hanjin.framework.component.util.StringUtil" %>
<%
	EsmPri2203Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String rfaNo = "";
    String condPropNo = null;

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_ofc		= "";
	String strRhq_ofc       = "";
	String strUsrSrepCd     = "";
	Logger log = Logger.getLogger("com.hanjin.apps.RFAProposal.RFAProposalMain");

	String[] scopeList = null;	//	Service Scope
	String[] ratUtCdList = null;
	String[] prcCgoTpCdList = null;
	String[] currCdList = null;
	
	String[] termOrgCdList = null;
	String[] termDestCdList = null;
	
	// Conversion
	String[] rtApplTpCd = null;		    //APLICATION
	String[] bkgPrcCgoTpCd = null;    	//CARGO TYPE
	String[] rtOpCd = null;    			//CAL.
	String[] payTermCd = null;    		//PAY TERM
	String[] bkgRatUtCd = null;			//PER TYPE
	String[] currCd = null;				//CURRENCY
	String[] srcInfoCd = null;		    //SOURCE
	String[] prcProgStsCd = null;		//STATUS
    String[] dmdtCd = null; 

	// Master RFA Auth
	String[] mstRfaAuth = null;
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_ofc = account.getOfc_cd();
	    strUsrSrepCd = account.getSrep_cd();
	    strRhq_ofc   = account.getRhq_ofc_cd();
	    
		event = (EsmPri2203Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		rfaNo = StringUtil.xssFilter(request.getParameter("rfa_no_2043"));
        condPropNo = JSPUtil.getNull(request.getParameter("cond_prop_no"));
		
        scopeList = PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("scopeList"));
		ratUtCdList = PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("ratUtCdList"));
		prcCgoTpCdList = PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("prcCgoTpCdList"));	// Dry Only -> 모든 type으로 변경
		//prcCgoTpCdList = PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("prcCgoTpCdList"),true ,"|","\t","getCode","getName");
		 
		currCdList = PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("currCdList"), false, "|", "\t");
		
		termOrgCdList = PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("termOrgCdList"), false);
		termDestCdList = PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("termDestCdList"), false);
		
		// Conversion
		rtApplTpCd 		= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("RT_APPL_TP_CD"), false);
		bkgPrcCgoTpCd 	= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("BKG_PRC_CGO_TP_CD"));
		payTermCd 		= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("PAY_TERM_CD"), false);
		bkgRatUtCd 		= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("BKG_RAT_UT_CD"));
		currCd 			= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("CURR_CD"), false);
		rtOpCd 			= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("RT_OP_CD"));

		srcInfoCd 		= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("src_info_cd"), false);
		prcProgStsCd 	= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("prc_prog_sts_cd"), false);
		mstRfaAuth = PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("MST_RFA_AUTH"), false);
		
        dmdtCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("dmdtList"), true ,"|","\t","getCode","getName");     
 
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Master RFA Proposal & Amendment Creation</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 
<script type="text/javascript">
    var scopeCdValue = " |<%=scopeList[0]%>";
    var scopeCdText = " |<%=scopeList[1]%>";
    
    var prcCgoTpCdValue = "<%=prcCgoTpCdList[0]%>";
    var prcCgoTpCdText = "<%=prcCgoTpCdList[1]%>";
    
    var ratUtCdValue = "<%=ratUtCdList[0]%>";
    var ratUtCdText = "<%=ratUtCdList[1]%>";
    
    var currCdValue = "<%=currCdList[0]%>";
    var currCdText = "<%=currCdList[1]%>";
    
	var srcInfoCdComboValue = "<%=srcInfoCd[0]%>";
	var srcInfoCdComboText = "<%=srcInfoCd[1]%>";
	
	var prcProgStsCdComboValue = "<%=prcProgStsCd[0]%>";
	var prcProgStsCdComboText = "<%=prcProgStsCd[1]%>";
    
	var termOrgCdValue = "<%=termOrgCdList[0]%>";
	var termOrgCdText = "<%=termOrgCdList[1]%>";
	
	var termDestCdValue = "<%=termDestCdList[0]%>";
	var termDestCdText = "<%=termDestCdList[1]%>";
	
    // Conversion
	var rtApplTpCdComboValue = " |<%=rtApplTpCd[0]%>";
	var rtApplTpCdComboText = " |<%=rtApplTpCd[1]%>";
	
	var bkgPrcCgoTpCdComboValue = " |<%=bkgPrcCgoTpCd[0]%>";
	var bkgPrcCgoTpCdComboText = " |<%=bkgPrcCgoTpCd[1]%>";
	
	var payTermCdComboValue = " |<%=payTermCd[0]%>";
	var payTermCdComboText = " |<%=payTermCd[1]%>";
	
	var bkgRatUtCdComboValue = " |<%=bkgRatUtCd[0]%>";
	var bkgRatUtCdComboText = " |<%=bkgRatUtCd[1]%>";
	
	var currCdComboValue = "<%=currCd[0]%>";
	var currCdComboText = "<%=currCd[1]%>";
	
	var rtOpCdComboValue = "<%=rtOpCd[0]%>";
	var rtOpCdComboText = "<%=rtOpCd[1]%>";
    var dmdtCdValue = "<%=dmdtCd[0]%>";
    var dmdtCdText = "<%=dmdtCd[1]%>";
    
	var auth02N17 =  "<%=mstRfaAuth[0]%>"; // PRI02 + PRI17
	
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
<input type="hidden" name="prop_srep_cd" value="<%=strUsr_id %>">
<input type="hidden" name="str_usr_id" value="<%=strUsr_id %>">
<!--  2043 에서 팝업 호출시 사용-->
<input type="hidden" name="rfa_no_2043" value="<%=rfaNo%>">
<!--  2049 에서 호출시 사용-->
<input type="hidden" name="cond_prop_no" value="<%=condPropNo%>">

<!-- RFA Type - Master Only -->
<input type="hidden" name="rfa_ctrt_tp_cd" value="M">

<input type="hidden" name="ori_rfa_no" >
<input type="hidden" name="ori_prop_no" >
<input type="hidden" name="svc_scp_cd" >
<input type="hidden" name="etc1" value="<%=strUsr_ofc%>">
<!-- 개발자 작업	-->
<!-- Rate -->
<input type="hidden" name="pre_amdt_seq">
<input type="hidden" name="prc_prop_sts_cd" >
<!-- Rate Type Code - G : CY Only, A : IHC-->
<input type="hidden" name="fic_rt_tp_cd" value="G">
<input type="hidden" name="req_usr_id">

<input type="hidden" name="exp_dt">
<input type="hidden" name="is_req_usr" >
<input type="hidden" name="is_apro_usr">
<input type="hidden" name="cmdt_hdr_seq" value="1">
<input type="hidden" name="rout_seq">

<!-- Route Note Conversion -->
<input type="hidden" name="ta_note_ctnt" value=".">
<input type="hidden" name="note_conv_mapg_id">
<input type="hidden" name="cd">

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
					<td class="btn1" name="btn_amend">Amend</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
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
					<td class="btn1" name="btn_cancel" id="btn_cancel_txt">Cancel</td>
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
					<td class="btn1" name="btn_copy">Copy</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_copy_to_rfa">Copy to RFA</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				
				<%-- 2차 개발
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_History">History</td>
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
				 --%>
				
			</tr>
			</table>
		</td></tr>
		</table>
    <!--Button (E) -->
		<!--biz page (S)-->
		<!-- Hidden sheet for Transaction (S) -->
		<script type="text/javascript">ComSheetObject('sheet1');</script>
		<!-- Hidden sheet for Transaction (E) -->
		<table class="search">
       	<tr><td class="bg">
			<!-- biz_1  (S) -->
				<table class="search" border="0" style="width:979;">
				<tr class="h23">
					<td width="53">RFA No.</td>
					<td width="88"><input type="text" style="width:80;text-align:center;" class="input" name="rfa_no" maxlength="11" dataformat="engup"></td>
					<td width="60">AMD No.</td>
					<td width="48" style="padding-left:2"><input type="text" style="width:35;text-align:center;" class="input2" name="amdt_seq" readonly ></td>
					<td width="80" style="padding-left:2">Proposal No.</td>
					<td width="85"><input type="text" style="width:80;text-align:center;" class="input" name="prop_no" maxlength="11" dataformat="engup"></td>
					<td width="70">Duration</td>
					<td width="75">
					<input name="ctrt_eff_dt" type="text" style="width:70;text-align:center;"  value="" class="input1" caption="Effective Date" maxlength="10" dataformat="ymd" required>
					</td>
					<td width="95">
					&nbsp;~&nbsp;<input name="ctrt_exp_dt" type="text" style="width:70;text-align:center;"  value="" class="input1" caption="Expire Date" maxlength="10" dataformat="ymd" required>
					</td>
					<td width="30">
					<table><tr><td>
					<img src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor" name="btns_calendar1"  id="btns_calendar1">
					</td></tr></table>
					</td>
					<td width="100">Service Scope&nbsp;</td>
					<td width="70"><script type="text/javascript">ComComboObject('ssvc_scp_cd', 2, 62, 0, 1, 0, false);</script></td>
					<td width="37">Status&nbsp;</td>
					<td><input type="text" name="prop_sts" style="width:50;text-align:center;" class="input2" value="" readonly></td>
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
				<table class="search" border="0" style="width:979;">
				<tr class="h23">
					<td width="95">Request Office</td>
					<td width="70"><input type="text" style="width:55;text-align:center;" class="input1" name="prop_ofc_cd"  dataformat="engup" readonly caption="Request Office Code" required></td>
					<td width="97">Request Staff</td>
					<td width="235"><script language="javascript">ComComboObject('req_usr_nm', 1, 215, 0, 1, 0);</script></td>
					<td width="90">Creation Date</td>
					<td width="95"><input type="text" style="width:80;text-align:center;" class="input2" maxlength="10" dataformat="ymd" name="cre_dt" readonly></td>
					<td width="102">Effective Date</td>
					<td width=""><input type="text" style="width:70;text-align:center;" class="input2" maxlength="10" dataformat="ymd" name="eff_dt" readonly></td>
				</tr>
				</table>
				
				<table class="search" border="0" style="width:979;">
				<tr class="h23">
					<td width="95">Approval Office</td>
					<td width="70"><input type="text" style="width:55;text-align:center;" class="input2" name="prop_apro_ofc_cd" readonly></td>
					<td width="97">Approval Staff</td>
					<td width="235"><input type="text" style="width:215;text-align:left;" class="input2" name="prop_apro_staff" readonly></td>
					<td width="90">Approval Date</td>
					<td width="95"><input type="text" style="width:80;text-align:center;" class="input2" maxlength="10" dataformat="ymd" name="prop_apro_dt" readonly></td>				

                    <td width="102">
                        <table width="101" border="0" cellpadding="0" cellspacing="0" class="button">
                        <tr><td class="btn2_left"></td>
                        <td class="btn2">
                            <img class="cursor" src="img/tab_icon1.gif" width="16" height="16" border="0" align="absmiddle" id="img_dmdt"></td>                 
                        <td class="btn2" name="btn_free_pop" id="btn_free">Free Time</td>                   
                        <td class="btn2_right"></td>
                        </tr>
                        </table>
                    </td>
                    <td width="94"><script language="javascript">ComComboObject('dmdt_ft_tp_cd', 1, 92, 0, 1);</script></td>
                    <td width="">
                        <table width="84" border="0" cellpadding="0" cellspacing="0" class="button">
                        <tr><td class="btn2_left"></td>
                        <td>
                            <table>
                            <tr>
                            <td class="btn2" name="btn_dem_pop" id="btn_dem"> DEM/DET</td>                  
                            <td class="btn2_right"></td>
                            </tr>
                            </table>
                        </td>
                        </tr>
                        </table>
                    </td>
                    </tr>
                </table>    				
				
				<!--  biz_2   (E) -->
				</div>
				
				
				<!-- Grid  (S) -->
				<table width="979"  id="mainTable">
					<tr>
						<td width="100%">
							<script type="text/javascript">ComSheetObject('sheet2');</script>
						</td>
					</tr>
				</table>
				<!-- Grid (E) -->
				
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>

                <!--Button (S) -->
                <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:2;">
                <tr>

                    <td class="btn1_bg">

                    <table border="0" cellpadding="0" cellspacing="0">
                    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                            <tr><td class="btn1_left"></td>
                            <td class="btn1" name="btn_acceptall">Accept All</td>
                            <td class="btn1_right"></td>
                            </tr>
                        </table></td>
                        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                            <tr><td class="btn1_left"></td>
                            <td class="btn1" name="btn_acceptcancel">Accept Cancel</td>
                            <td class="btn1_right"></td>
                            </tr>
                        </table></td>
                        <!-- 
                        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                            <tr><td class="btn1_left"></td>
                            <td class="btn1" name="btn_glcopy">G/L Copy</td>
                            <td class="btn1_right"></td>
                            </tr>
                        </table></td>
                         -->
                        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                            <tr><td class="btn1_left"></td>
                            <td class="btn1" name="btn_gricalc">General Update</td>
                            <td class="btn1_right"></td>
                            </tr>
                        </table></td>
                        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                            <tr><td class="btn1_left"></td>
                            <td class="btn1" name="btn_downexcel">Down Excel</td>
                            <td class="btn1_right"></td>
                            </tr>
                        </table></td>
                        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                            <tr><td class="btn1_left"></td>
                            <td class="btn1" name="btn_loadexcel">Load Excel</td>
                            <td class="btn1_right"></td>
                            </tr>
                        </table></td>
                        </tr>
                    </table>
                </td></tr>
                </table>
                <!--Button (E) -->
                <table class="height_2"><tr><td></td></tr></table>
                
	            <table class="search" border="0">
	            <tr><td class="title_h"></td>
	                <td class="title_s">Route & Summary</td></tr>
	            </table>
	
	            <!-- Grid  (S) -->
	            <table width="100%" id="mainTable">
	                <tr>
	                    <td width="100%">
	                        <script type="text/javascript">ComSheetObject('sheet3');</script>
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
							<td class="btn2" name="btn_rowadd1">Row&nbsp;Add</td>
							<td class="btn2_right"></td>
							</tr>
							</table></td>
							<!-- 
	                        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
	                        <tr><td class="btn2_left"></td>
	                        <td class="btn2" name="btn_rowcopy" suppressWait="Y">Row Copy</td>
	                        <td class="btn2_right"></td>
	                        </tr>
	                        </table></td>
							 -->
	                        
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_delete1">Delete</td>
							<td class="btn2_right"></td>
							</tr>
							</table></td>
							
	                        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
	                        <tr><td class="btn2_left"></td>
	                        <td class="btn2" name="btn_save1">Save</td>
	                        <td class="btn2_right"></td>
	                        </tr>
	                        </table></td>
	                        
	                        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
	                        <tr><td class="btn2_left"></td>
	                        <td class="btn2" name="btn_accept1">Accept</td>
	                        <td class="btn2_right"></td>
	                        </tr>
	                        </table></td>
	                        
	                        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
	                        <tr><td class="btn2_left"></td>
	                        <td class="btn2" name="btn_acceptcancel1">Accept Cancel</td>
	                        <td class="btn2_right"></td>
	                        </tr>
	                        </table></td>
						</tr>
					</table>
				</td></tr>
				</table>
				
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
				
	            <table class="search" border="0">
	            <tr><td class="title_h"></td>
	                <td class="title_s">Rate</td></tr>
	            </table>
	
	            <!-- Grid  (S) -->
	            <table width="100%" id="mainTable">
	                <tr>
	                    <td width="100%">
	                        <script type="text/javascript">ComSheetObject('sheet4');</script>
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
							<td class="btn2" name="btn_rowadd2">Row&nbsp;Add</td>
							<td class="btn2_right"></td>
							</tr>
							</table></td>
							
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_delete2">Delete</td>
							<td class="btn2_right"></td>
							</tr>
							</table></td>
							
	                        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
	                        <tr><td class="btn2_left"></td>
	                        <td class="btn2" name="btn_save2">Save</td>
	                        <td class="btn2_right"></td>
	                        </tr>
	                        </table></td>
	                        
	                        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
	                        <tr><td class="btn2_left"></td>
	                        <td class="btn2" name="btn_amend2" suppressWait="Y">Amend</td>
	                        <td class="btn2_right"></td>
	                        </tr>
	                        </table></td>
	                        
	                        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
	                        <tr><td class="btn2_left"></td>
	                        <td class="btn2" name="btn_amendcancel2" suppressWait="Y">Amend Cancel</td>
	                        <td class="btn2_right"></td>
	                        </tr>
	                        </table></td>
	                        
	                        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
	                        <tr><td class="btn2_left"></td>
	                        <td class="btn2" name="btn_accept2">Accept</td>
	                        <td class="btn2_right"></td>
	                        </tr>
	                        </table></td>
	                        
	                        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
	                        <tr><td class="btn2_left"></td>
	                        <td class="btn2" name="btn_acceptcancel2">Accept Cancel</td>
	                        <td class="btn2_right"></td>
	                        </tr>
	                        </table></td>
						</tr>
					</table>
				</td></tr>
				</table>
	            
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
				
	            <table class="search" border="0">
	            <tr><td class="title_h"></td>
	                <td class="title_s">Charge Term (Conversion)</td></tr>
	            </table>
	
	            <!-- Grid  (S) -->
	            <table width="100%" id="mainTable">
	                <tr>
	                    <td width="100%">
	                        <script type="text/javascript">ComSheetObject('sheet5');</script>
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
							<td class="btn2" name="btn_rowadd3">Row&nbsp;Add</td>
							<td class="btn2_right"></td>
							</tr>
							</table></td>
							
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_delete3">Delete</td>
							<td class="btn2_right"></td>
							</tr>
							</table></td>
							
	                        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
	                        <tr><td class="btn2_left"></td>
	                        <td class="btn2" name="btn_save3">Save</td>
	                        <td class="btn2_right"></td>
	                        </tr>
	                        </table></td>
	                        
	                        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
	                        <tr><td class="btn2_left"></td>
	                        <td class="btn2" name="btn_amend3" suppressWait="Y">Amend</td>
	                        <td class="btn2_right"></td>
	                        </tr>
	                        </table></td>
	                        
	                        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
	                        <tr><td class="btn2_left"></td>
	                        <td class="btn2" name="btn_amendcancel3" suppressWait="Y">Amend Cancel</td>
	                        <td class="btn2_right"></td>
	                        </tr>
	                        </table></td>
	                        
	                        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
	                        <tr><td class="btn2_left"></td>
	                        <td class="btn2" name="btn_accept3">Accept</td>
	                        <td class="btn2_right"></td>
	                        </tr>
	                        </table></td>
	                        
	                        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
	                        <tr><td class="btn2_left"></td>
	                        <td class="btn2" name="btn_acceptcancel3">Accept Cancel</td>
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

	 <table class="height_8"><tr><td></td></tr></table>
	</td></tr>
</table>

<div id="hiddenSheetLayer" style="display:none;">
<script type="text/javascript">ComSheetObject('sheet6');</script><!-- Service Scope -->
<script type="text/javascript">ComSheetObject('sheet7');</script><!-- sheet3의 Origin Point(Hidden) -->
<script type="text/javascript">ComSheetObject('sheet8');</script><!-- sheet3의 Origin Via.(Hidden) -->
<script type="text/javascript">ComSheetObject('sheet9');</script><!-- sheet3의 Destination Via.(Hidden) -->
<script type="text/javascript">ComSheetObject('sheet10');</script><!-- sheet3의 Destination Point(Hidden) -->
<script type="text/javascript">ComSheetObject('sheet11');</script><!-- sheet3의 Direct Call(Hidden) -->
<script type="text/javascript">ComSheetObject('sheet12');</script><!-- sheet3의 Rnote(Hidden) -->
<script type="text/javascript">ComSheetObject('sheet13');</script><!-- Request 클릭시, Route 중에 term이 빠진 Location check -->
</div>
 <!-- 개발자 작업  끝 -->
</form>
</body>
</html>