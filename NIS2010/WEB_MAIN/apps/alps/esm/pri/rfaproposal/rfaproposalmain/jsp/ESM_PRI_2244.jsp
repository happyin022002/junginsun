<%@page import="com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.event.EsmPri2244Event"%>
<%@page import="java.util.List"%>
<%@page import="com.hanjin.apps.alps.esm.pri.common.PRIUtil"%>
<%/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ESM_PRI_2244.jsp
*@FileTitle : RFA Proposal Creation [Copy]
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.04
*@LastModifier : 이민경
*@LastVersion : 1.0
* 2016.04.04 이민경
* 1.0 Creation
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RsltRfaPropCopyVO"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
 
    EsmPri2244Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
    String strSrepCd = "";
	Logger log = Logger.getLogger("com.hanjin.apps.RFAProposal.RFAProposalMain");
	
	String propNo = null;
	String amdtSeq = null;
    String rfaNo = null;
    String cmdt = null;
    String svc_scp_cd = null;
    String cmdt_hdr_seq = null;
    String copyFlg = null;
    String eff_dt = null;
    String exp_dt = null;
    
	String[] termOrgCdList = null;
	String[] termDestCdList = null;
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strSrepCd = account.getSrep_cd();
	   
		 event = (EsmPri2244Event)request.getAttribute("Event"); 
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        
	    propNo = JSPUtil.getNull(request.getParameter("prop_no")).trim().equals("")?"":JSPUtil.getNull(request.getParameter("prop_no"));
	    amdtSeq = JSPUtil.getNull(request.getParameter("amdt_seq")).trim().equals("")?"":JSPUtil.getNull(request.getParameter("amdt_seq"));
	    cmdt = JSPUtil.getNull(request.getParameter("cmdt")).trim().equals("")?"":JSPUtil.getNull(request.getParameter("cmdt"));
	    rfaNo = JSPUtil.getNull(request.getParameter("rfa_no")).trim().equals("")?"":JSPUtil.getNull(request.getParameter("rfa_no"));
	    copyFlg = JSPUtil.getNull(request.getParameter("copyFlg")).trim().equals("")?"":JSPUtil.getNull(request.getParameter("copyFlg"));
	    svc_scp_cd = JSPUtil.getNull(request.getParameter("svc_scp_cd")).trim().equals("")?"":JSPUtil.getNull(request.getParameter("svc_scp_cd"));
	    cmdt_hdr_seq = JSPUtil.getNull(request.getParameter("cmdt_hdr_seq")).trim().equals("")?"":JSPUtil.getNull(request.getParameter("cmdt_hdr_seq"));
 		eff_dt =  JSPUtil.getNull(request.getParameter("eff_dt")).trim().equals("")?"":JSPUtil.getNull(request.getParameter("eff_dt"));
 		exp_dt =  JSPUtil.getNull(request.getParameter("exp_dt")).trim().equals("")?"":JSPUtil.getNull(request.getParameter("exp_dt"));
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		termOrgCdList = PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("termOrgCdList"), false);
		termDestCdList = PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("termDestCdList"), false);
	 	
		/*hard Coading*/
		cmdt = "FAK OR CARGO, NOS";
		
		
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>RFA Proposal Creation [Copy]</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="apps/alps/esm/pri/rfaproposal/rfaproposalmain/script/ESM_PRI_2244.js?v=10"></script>

<script language="javascript">
 var termOrgCdValue = "<%=termOrgCdList[0]%>";
var termOrgCdText = "<%=termOrgCdList[1]%>";

var termDestCdValue = "<%=termDestCdList[0]%>";
var termDestCdText = "<%=termDestCdList[1]%>"; 
var copyFlg = "<%=copyFlg%>";
var p_eff_dt = "<%=eff_dt%>";
var p_exp_dt = "<%=exp_dt%>";
    function setupPage(){
    <%--     var errMessage = "<%=strErrMsg%>"; --%>
        var errMessage = "";
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
<input type="hidden" name="svc_scp_cd" value="<%=svc_scp_cd %>">
<input type="hidden" name="prop_no" value="<%=propNo %>">
<input type="hidden" name="cmdt_hdr_seq" value="<%=cmdt_hdr_seq%>">
<!-- 개발자 작업	-->
<input type="hidden" name="prop_srep_cd" value="<%=strSrepCd%>">
<input type="hidden" name="eff_dt">
<input type="hidden" name="exp_dt">
<%if(copyFlg!=null && copyFlg.equals("spot")){ %>
	<input type="hidden" name="rfa_type" value="B" >
<%} else {%>
	<input type="hidden" name="rfa_type" value="M" >
<%} %>

<!-- OUTER - POPUP (S)tart -->
<table width="1100" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp; RFA Proposal Creation [Copy]</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- 1 (S) -->
		<table class="search" id="mainTable"> 
       	<tr><td class="bg">	
				
				
			<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="80">&nbsp;&nbsp;RFA No.&nbsp;&nbsp;</td>
					<td width="130">
						<!-- <input type="text" name="rfa_no_fst" style="width:45;" value="<%=(rfaNo.length() > 3)?rfaNo.substring(0,3):rfaNo %>" class="input2" readonly="readonly">&nbsp;
						<input type="text" name="rfa_no_lst" style="width:60;" value="<%=(rfaNo.length() > 3)?rfaNo.substring(3):"" %>" class="input2" readonly="readonly"> -->
                        <input type="text" name="rfa_no" style="width:90;text-align:center;" value="<%=rfaNo %>" class="input2" readonly="readonly">
					</td>
					<td width="60">AMD No.</td>
					<td width="80">
					<input type="text" name="amdt_seq" style="width:45;text-align:center;" value="<%=amdtSeq%>" class="input2" readonly="readonly"></td>
					<td width="80">Commodity</td>
					<td width="">
					<input type="text" name="cmdt" style="width:140;text-align:center;"  value="<%=cmdt%>"  class="input2" readonly="readonly"></td>
					
					<td width="100">&nbsp;&nbsp;Duration :</td>
					<td width="120">
					EFF&nbsp;<input type="text" style="width:80;text-align:center;" class="input1" caption="Effective date" name="ctrt_eff_dt" cofield="ctrt_exp_dt" maxlength="10" dataformat="ymd"  required>
					&nbsp;
					</td>
					<td width="120">
					EXP&nbsp;<input type="text" style="width:80;text-align:center;" class="input1" caption="Expiration date" name="ctrt_exp_dt" cofield="ctrt_eff_dt" maxlength="10" dataformat="ymd" required>
					</td>
					<td>
					<img src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor" name="btns_calendar" >
					</td>
					<td>
					<table class="search" border="0" style="width:150; display:inline;">
				<tr class="h23">
				<td width="70">
				</td>
				</tr>
			</table>
					</td>
				</tr>	
			</table>
			<%if(copyFlg!=null && copyFlg.equals("spot")){ %>
			<table class="search" border="0" style="width:952; display:inline;"> 
				<tr class="h23">
					<td width="80">&nbsp;&nbsp;Customer</td>
					<td width="57" style="padding-left:0"><input type="text" style="width:55;text-align:center;" class="input1" dataformat="engup" maxlength="2" minlength="2" name="ctrt_cust_cnt_cd" caption="Customer Code" required> 
					</td>
					<td width="59"><input type="text" style="width:55;text-align:center;" class="input1" dataformat="int" name="ctrt_cust_seq" maxlength="6" caption="Customer Code" >
					</td>
					<td width="22"><table><tr><td>
						<img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_ctrt_cust">
					</td></tr></table></td>
					<td width="274"><input type="text" style="width:272;text-align:left;" class="input2"  name="ctrt_pty_nm" readonly>
					</td>
					<td width="69"><input type="text" style="width:67;text-align:center;" class="input2" name="prc_ctrt_cust_tp_nm" readonly>
					<input type="hidden" name="prc_ctrt_cust_tp_cd">
					</td>
					<td width="54">
					<input type="text" style="width:52;text-align:center;" class="input2" name="ctrt_cust_val_sgm" readonly> 
					<input type="hidden" style="width:52;text-align:center;" class="input2" name="ctrt_cust_val_sgm_cd" readonly> 
					</td>
					<td width="71"><input type="text" style="width:67;text-align:center;" class="input2" name="respb_sls_ofc_cd" readonly caption="Customer Code"> 
					</td>
					<td width="93">
					<script language="javascript">ComComboObject('respb_srep_cd', 3, 92, 0,1);</script>
					</td>
					<td><input type="text" style="width:177;" class="input2" name="ctrt_cust_srep_nm" readonly>
					</td>
				</tr>
			</table>
			<%} %>
			
	
				
            <table width="100%" style="display:inline;">
                <tr>
                    <td width="100%">
                        <script language="javascript">ComSheetObject('sheet1');</script>
                    </td>
                </tr>
            </table>                
                </td></tr>
            </table>			<!-- Grid - 2 (S) -->

			<!-- Grid - 2 (E) -->	

			<!-- grid box (E) -->
			
			
		</td></tr>
		</table>			
		<!-- 1 (E) -->
		
<table class="height_5"><tr><td></td></tr></table>
	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

    	<!--Button (S) -->	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Ok">OK</td>
					<td class="btn1_right"></td>
				</tr></table></td>	
			<td class="btn1_line"></td>		
			
			<td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="72 border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Close">Close</td>
					<td class="btn1_right"></td>
				</tr></table></td>
				
			</tr>
		</table>
    	<!--Button (E) -->
	
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->
			

</td></tr></table>
</td></tr></table>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>