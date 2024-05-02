<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_1601.jsp
*@FileTitle : Audit by CNTR Qty Discrepancy
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.19
*@LastModifier : 김대호
*@LastVersion : 1.0
* 2009.10.07 김대호
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.event.EsmBkg1601Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.util.code.CodeInfo"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO" %>
<%@ page import="com.hanjin.framework.component.common.AbstractValueObject"%>
<%@ page import="java.util.List"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.common.*" %>
<%@ page import="com.hanjin.framework.core.controller.DefaultViewAdapter"%>

<%
    EsmBkg1601Event  event = null;              //PDTO(Data Transfer Object including Parameters)
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
	String sXml				= "";
    
    List<BkgComboVO> chg_amd_rqst_sts_cd = null;
    String auth_usr_flg = "";
    
    Logger log = Logger.getLogger("com.hanjin.apps.BlRating.BlRating");
    
    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
        strRhq_ofc_cd = account.getRhq_ofc_cd();
        strOfc_cd = account.getOfc_cd();

        //blNo = request.getParameter("bl_no");
        
        event = (EsmBkg1601Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
        
        // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        
        chg_amd_rqst_sts_cd = (List<BkgComboVO>) eventResponse.getCustomData("chg_amd_rqst_sts_cd");
        auth_usr_flg = eventResponse.getETCData("auth_usr_flg");
        
        DefaultViewAdapter adapter = new DefaultViewAdapter();
		sXml = adapter.makeXML(request, response);
        
    }catch(Exception e) {
        out.println(e.toString());
    }
    
%>
<html>
<head>
<title>Charge Amend Request Status</title>
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

<!--  Office Code Validation 체크를 위한 정의 -->
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="sXml" value="<%=sXml %>">
<!--  Office Code Validation 체크를 위한 정의 -->
<input type="hidden" name="usrId" value="<%=strUsr_id %>">
<!-- Form Hidden -->
<input type="hidden" name="auth_usr_flg" value="<%=auth_usr_flg %>">
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
				<td class="btn1_line"></td>
				
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_approve">Approve</td>
					<td class="btn1_right"></td>
					</tr>
				   </table>
				</td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
				   <tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_reject">Reject</td>
					<td class="btn1_right"></td>
					</tr>
				    </table>
				</td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
				   <tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_downexcel">Down Excel</td>
					<td class="btn1_right"></td>
					</tr>
				    </table>
				</td>
			</tr>
			</table>
		</td></tr>
		</table>
    	<!--Button (E) -->
		
		<!--biz page (S)-->
		<table class="search" id="mainTable"> 
       		<tr>
       			<td class="bg">
					<!--  biz_1 (S) -->
					<table class="search" border="0" style="width:979;"> 
						<tr class="h23">
							<td width="100">Duration</td>
							<td width="290">
							    <input type="text" style="width:90;text-align:center;" class="input1" value="<%=JSPUtil.getKST("yyyy-MM-dd") %>" caption="From Date" name="fm_dt" dataformat="ymd" maxLength="10" >&nbsp;<img class="cursor" src="img/btns_calendar.gif" name="btns_calendar1" width="19" height="20" border="0" align="absmiddle">
							    &nbsp;~&nbsp;
							    <input type="text" style="width:90;text-align:center;" class="input1" value="<%=JSPUtil.getKST("yyyy-MM-dd") %>" caption="To Date" name="to_dt" dataformat="ymd" maxLength="10">&nbsp;<img class="cursor" src="img/btns_calendar.gif" name="btns_calendar2" width="19" height="20" border="0" align="absmiddle">
							</td>
							<td>Status</td>
							<td><%=HTMLUtil.getComboString("chg_amd_rqst_sts_cd", "width:90;", "", "","","All", chg_amd_rqst_sts_cd)%></td>
							<td>Booking No</td>
							<td><nobr><input type="text" class="input" style="width:110;text-align:center;ime-mode:disabled" name="in_bkg_no" dataformat="uppernum" caption="Booking Number" maxlength="13"> </nobr></td>
						</tr>
						<tr class="h23">
							<td>Request Office</td>
							<td><nobr><input type="text" class="input" style="width:90;text-align:center;ime-mode:disabled" name="rqst_ofc_cd" dataformat="engup" caption="Request Office" maxlength="6"> </nobr></td>
							<td>Approval Office</td>
							<td><nobr><input type="text" class="input" style="width:90;text-align:center;ime-mode:disabled" name="apro_ofc_cd" dataformat="engup" caption="Approval Office" maxlength="6"> </nobr></td>
							
							<td>Approval User</td>
							<td><nobr><input type="text" class="input" style="width:110;text-align:center;ime-mode:disabled" value="<%=strUsr_id%>" name="apro_usr_id" caption="Approval User" maxlength="20"> </nobr></td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
		
		<!--  biz_1   (E) -->
		<table class="height_10"><tr><td colspan="8"></td></tr></table>
		
		<!-- Grid BG Box  (S) -->
    	<table class="search" id="mainTable"> 
      		<tr>
      			<td class="bg">
			      	<!--  Button_Sub (S) -->
			    	<!-- Button_Sub (E) -->
					<!-- Grid  (S) -->
					<table width="100%"  id="mainTable">
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet1');</script>
							</td>
						</tr>
					</table>
					<!-- Grid (E) -->
				</td>
			</tr>
		</table>
		<!-- Grid BG Box  (E) -->

	
	
	
</form>
</body>
</html>
