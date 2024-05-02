<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_6046.jsp
*@FileTitle : RFA Quotation Copy to Proposal
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.20
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.10.20 이승준
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
<%@ page import="com.hanjin.apps.alps.esm.pri.rfaquotation.rfaquotationmain.event.EsmPri6046Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EsmPri6046Event  event = null;                  //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //서버에서 발생한 에러
    String strErrMsg = "";                      //에러메세지
    int rowCount     = 0;                       //DB ResultSet 리스트의 건수

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    Logger log = Logger.getLogger("com.hanjin.apps.RFAQuotation.RFAQuotationMain");
    
    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();

        event = (EsmPri6046Event)request.getAttribute("Event");
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
<title>RFA Quotation Copy to Proposal</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
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

<input type="hidden" name="qttn_no" value="<%=request.getParameter("qttn_no")%>">
<input type="hidden" name="qttn_ver_no" value="<%=request.getParameter("qttn_ver_no")%>">
<input type="hidden" name="prop_no" value="">

<!-- 개발자 작업 -->
<!-- code 조회용 -->
<input name="cd" type="hidden" value="">

<!-- OUTER - POPUP (S)tart -->
<table width="600" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;  RFA Quotation Copy to Proposal</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- : ( Search Options ) (S) -->
 
			<table class="search"> 
       		<tr><td class="bg">
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="90">Quotation No.</td>
					<td width="100"><input type="text" name="qttn_no_from" style="width:80;text-align:center;" class="input2" value="<%=request.getParameter("qttn_no")%>" readonly></td>
					<td width="50">Ver. No.</td>
					<td width="60"><input type="text" name="qttn_ver_no_from" style="width:40;text-align:center;" class="input2" value="<%=request.getParameter("qttn_ver_no")%>" readonly></td> 
					<td width="50">Duration</td>
					<td width=""><input type="text" name="eff_dt" style="width:80;text-align:center;" class="input2" value="<%=request.getParameter("before_eff_dt")%>" readonly>
					&nbsp;~&nbsp;
					<input type="text" name="exp_dt" style="width:80;text-align:center;" class="input2" value="<%=request.getParameter("before_exp_dt")%>" readonly></td>
				</tr>
				</table>
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="90">Service Scope</td>
					<td width="278">
					<input type="text" name="svc_scp_cd" style="width:60;text-align:center;" class="input2" value="<%=request.getParameter("svc_scp_cd")%>" readonly>  
					<input type="text" name="svc_scp_nm" style="width:185;" class="input2" value="<%=request.getParameter("svc_scp_nm")%>" readonly></td>
					<td width="92">Creation Date</td>
					<td width=""><input type="text" name="cre_dt" style="width:80;text-align:center;" class="input2" value="<%=request.getParameter("cre_dt")%>" readonly></td>
				</tr>
				</table>
				
				<table class="height_5"><tr><td></td></tr></table>
				
				<table border="0" style="width:100%;" class="search_sm2"> 
					<tr class="h23">
						<td width="65">Free Time</td>
						<td width=""><script language="javascript">ComComboObject('dmdt_ft_tp_cd', 1, 80, 0, 1, 0, false);</script></td>
					</tr>	
				</table>
				
				<table border="0" style="width:100%;" class="search_sm2"> 
					<tr class="h23">
						<td width="100%">
						<input type="checkbox" name="frm_grp_loc_cnt" value="Y" class="trans">&nbsp;Location Group&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="checkbox" name="frm_grp_cmdt_cnt" value="Y" class="trans">&nbsp;Commodity Group&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="checkbox" name="frm_rate_g_cnt" value="Y" class="trans">&nbsp;Rate&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					</tr>
					<tr>
						<td align="right" style="padding-top:10">
							<table border="0" cellpadding="0" cellspacing="0"><tr>
						
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn2_CheckAll">Check All</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn2_UncheckAll">Uncheck All</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
					</tr></table>
						
						</td>
					</tr>
				</table>
				
				
			</td></tr>
		</table>
<!-- : ( Search Options ) (E) -->
</td></tr>
</table> 

<table class="height_5"><tr><td></td></tr></table>


<table width="100%" style="display:inline;">
                <tr>
                    <td width="100%">
                        <script language="javascript">ComSheetObject('sheet1');</script>
                    </td>
                </tr>
            </table>
<table class="height_5"><tr><td></td></tr></table>
	
	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td width="72"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn1_OK">OK</td>
					<td class="btn1_right"></td>					
			</tr>
			</table>
			<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn1_Close">Close</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
		</td></tr>
		</table>
    <!--Button (E) -->
	
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->
			
			
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>