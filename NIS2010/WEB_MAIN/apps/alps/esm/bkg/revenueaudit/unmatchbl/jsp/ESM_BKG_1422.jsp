<%
/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ESM_BKG_1422.jsp
*@FileTitle : WSC BKG List for Audit
*Open Issues :
*Change history : 
*@LastModifyDate : 2016.04.15
*@LastModifier : 조정민
*@LastVersion : 1.0
* 2011.07.25 조정민 
* 1.0 Creation
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.component.util.io.HttpUtil"%> 
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.event.EsmBkg1422Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.util.code.CodeInfo"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.revenueauditcommon.rascommon.rascommon.vo.RsltCdListVO"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.revenueauditcommon.common.RASUtil"%>
<%@ page import="com.hanjin.framework.component.common.AbstractValueObject"%>
<%@ page import="java.util.List"%>

<%
    EsmBkg1422Event  event = null;              //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //서버에서 발생한 에러
    String strErrMsg = "";                      //에러메세지
    int rowCount     = 0;                       //DB ResultSet 리스트의 건수
    
    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    String strRhq_ofc_cd    = "";
    String strOfc_cd        = "";
    
    //String blNo = "";
    
    //String[] rhqs = null;
    //String[] offices = null;
    String[] svcScpCds = null;
    String[] rTerms = null;
    String[] dTerms = null;
    
    //String[] contractTypes = null;  

    
    Logger log = Logger.getLogger("com.hanjin.apps.RevenueAudit.UnmatchBL");
    
    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
        strRhq_ofc_cd = account.getRhq_ofc_cd();
        strOfc_cd = account.getOfc_cd();

        //blNo = request.getParameter("bl_no");
        
        event = (EsmBkg1422Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
        
        // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        
        // Scope
        svcScpCds = RASUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("svcScpCd"));
        // r term Combo Data 생성
        rTerms = RASUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("rTerm"), false , "|", "\t", "getCode", "getName");
        // d term Combo Data 생성
        dTerms = RASUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("dTerm"), false , "|", "\t", "getCode", "getName");
        
        
    }catch(Exception e) {
        out.println(e.toString());
    }
    
%>
<html>
<head>
<title>WSC BKG List for Audit</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
   
    var svcScpCdComboValue = "|<%=svcScpCds[0]%>";
    var svcScpCdComboText = "|<%=svcScpCds[1]%>";
    
    var rTermComboValue = "|<%=rTerms[0]%>";
    var rTermComboText = "|<%=rTerms[1]%>";

    var dTermComboValue = "|<%=dTerms[0]%>";
    var dTermComboText = "|<%=dTerms[1]%>";
   
    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            showErrMessage(errMessage);
        } // end if
        loadPage();
    }
</script>
</head>

<script language="javascript">

    function setupPage(){  

	    loadPage();
    }

</script>

<body  onLoad="setupPage();"> 

<form name="form">

<!--  Office Code Validation 체크를 위한 정의 -->
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="cd">
<!--  Office Code Validation 체크를 위한 정의 -->
<input type="hidden" name ="ofc_cd" value="">
<!-- Form Hidden -->
<input type="hidden" name="strRhq_ofc_cd" value="<%=strRhq_ofc_cd%>">
<input type="hidden" name="strOfc_cd" value="<%=strOfc_cd%>">

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2; padding-left:5;">

	<tr><td valign="top">
	
		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!--Page Title, Historical (E)-->
	
		<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0; padding-bottom:2;"> 
       	<tr><td class="btn1_bg">
		
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
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
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
				   <tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_downexcel">Down Excel</td>
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
				<table class="search" border="0" style="width:980;"> 
					<tr class="h23">
						<td width="980">
							<table class="search_sm2" border="0" style="width:980;"> 
							<tr class="h23">
								<td width="50" >Date</td>
								<td width="180" class="stm"><input type="radio" class="trans" name="search_option" value="A" checked>Application&nbsp;&nbsp;<input type="radio" class="trans" name="search_option" value="W">W/O Issue&nbsp;</td>
								<td width="230">
								    <input type="text" style="width:75;text-align:center;" class="input1" value="" caption="From Date" name="from_dt" dataformat="ymd" maxLength="10" minlength="8">&nbsp;<img class="cursor" src="img/btns_calendar.gif" name="btns_calendar1" width="19" height="20" border="0" align="absmiddle">&nbsp;~&nbsp;<input type="text" style="width:75;text-align:center;" class="input1" value="" caption="To Date" name="to_dt" dataformat="ymd" maxLength="10" minlength="8">&nbsp;<img class="cursor" src="img/btns_calendar.gif" name="btns_calendar2" width="19" height="20" border="0" align="absmiddle">
								</td>
								<td width="45">Scope</td>
								<td width="110"><script language="javascript">ComComboObject('svc_scp_cd', 2, 90, 0, 0, 0, false);</script></td>
								<td width="62">R/D Term</td>
								<td width="65"><script language="javascript">ComComboObject('rcv_term_cd', 1, 60, 0, 0, 0, false);</script></td>      
								<td width=""><script language="javascript">ComComboObject('de_term_cd', 1, 60, 0, 0, 0, false);</script></td> 

							</tr>
							</table>
						</td>
					</tr>
				</table>
			</td>					
			</tr>
		</table>

				<!--  biz_1   (E) -->	
		<table class="height_10"><tr><td colspan="8"></td></tr></table>
		
		<!-- Grid BG Box  (S) -->
     	<table class="search" id="mainTable"> 
       	<tr><td class="bg">
       	<!--  Button_Sub (S) -->
	    	<!-- Button_Sub (E) -->
			<!-- Grid  (S) -->
			<table width="100%"> 
	       		<tr><td class="btn2_bg" align="right">
					<table border="0" cellpadding="0" cellspacing="0"><tr>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="search">
						<tr class="h23"><td>BKG Count&nbsp;&nbsp;</td></tr>
						</table></td>
						<td><input type="text" style="width:60;text-align:right" class="input" value="" name="bkg_cnt" readonly></td>
					</tr></table>
				</td></tr>
			</table>
			<table width="100%"  id="mainTable">
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet1');</script>
					</td>
				</tr>
			</table>
			<!-- Grid (E) -->	
			</td></tr>
		</table>
	<!-- Grid BG Box  (E) -->

	
	
	</td></tr>
		</table>
	
</form>
</body>
</html>
