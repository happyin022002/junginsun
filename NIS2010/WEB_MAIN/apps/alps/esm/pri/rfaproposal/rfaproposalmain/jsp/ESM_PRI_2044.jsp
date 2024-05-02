<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_2044.jsp
*@FileTitle : RFA Proposal Creation [Copy]
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.28
*@LastModifier : 문동규
*@LastVersion : 1.0
* 2009.09.28 문동규
* 1.0 Creation
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.event.EsmPri2044Event"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RsltRfaPropCopyVO"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
 
    EsmPri2044Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.RFAProposal.RFAProposalMain");
	
	String propNo = null;
	String amdtSeq = null;
    String rfaNo = null;
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (EsmPri2044Event)request.getAttribute("Event");
        
	    propNo = JSPUtil.getNull(request.getParameter("prop_no")).trim().equals("")?"":JSPUtil.getNull(request.getParameter("prop_no"));
	    amdtSeq = JSPUtil.getNull(request.getParameter("amdt_seq")).trim().equals("")?"":JSPUtil.getNull(request.getParameter("amdt_seq"));
	    rfaNo = JSPUtil.getNull(request.getParameter("rfa_no")).trim().equals("")?"":JSPUtil.getNull(request.getParameter("rfa_no"));
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
<title>RFA Proposal Creation [Copy]</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="apps/alps/esm/pri/rfaproposal/rfaproposalmain/script/ESM_PRI_2044.js?v=10"></script>

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
<!-- 개발자 작업	-->
<!-- input type="hidden" name="cd" -->
<!-- input type="hidden" name="cd" -->
<input type="hidden" name="ctrt_eff_dt" value="<%= JSPUtil.getParameter(request, "ctrt_eff_dt")%>">
<input type="hidden" name="endExpDt" value="<%= JSPUtil.getParameter(request, "endExpDt")%>">
<input type="hidden" name="addOnEndExpDt" value="<%= JSPUtil.getParameter(request, "addOnEndExpDt")%>">


<!-- OUTER - POPUP (S)tart -->
<table width="650" class="popup" cellpadding="10" border="0"> 
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
					<td width="60">&nbsp;&nbsp;RFA No.</td>
					<td width="130">
						<!-- <input type="text" name="rfa_no_fst" style="width:45;" value="<%=(rfaNo.length() > 3)?rfaNo.substring(0,3):rfaNo %>" class="input2" readonly="readonly">&nbsp;
						<input type="text" name="rfa_no_lst" style="width:60;" value="<%=(rfaNo.length() > 3)?rfaNo.substring(3):"" %>" class="input2" readonly="readonly"> -->
                        <input type="text" name="rfa_no" style="width:90;text-align:center;" value="<%=rfaNo %>" class="input2" readonly="readonly">
					</td>
					<td width="60">AMD No.</td>
					<td width="80">
					<input type="text" name="amdt_seq" style="width:45;text-align:center;" value="<%=amdtSeq%>" class="input2" readonly="readonly"></td>
					<td width="80">Proposal No.</td>
					<td width="">
					<input type="text" name="prop_no" style="width:90;text-align:center;"  value="<%=propNo%>"  class="input2" readonly="readonly"></td>
				</tr>	
				
			</table>
			<table class="search" border="0" style="width:200;"> 
				<tr class="h23">
					<td width="">
					<input type="checkbox" name="afil_chk_frm" class="trans" >Affiliate</td>
				</tr>	
				
			</table>	
				
            <table width="100%" style="display:inline;">
                <tr>
                    <td width="100%">
                        <script language="javascript">ComSheetObject('sheet1');</script>
                        <script language="javascript">ComSheetObject('sheet2');</script>
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