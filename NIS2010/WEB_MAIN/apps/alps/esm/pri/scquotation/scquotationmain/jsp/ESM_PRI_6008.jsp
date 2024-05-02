<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_6008.jsp
*@FileTitle : S/C Quotation - G/L Copy Option
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.21
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.06.19 이승준
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
<%@ page import="com.hanjin.apps.alps.esm.pri.scquotation.scquotationmain.event.EsmPri6008Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EsmPri6008Event  event = null;                  //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //서버에서 발생한 에러
    String strErrMsg = "";                      //에러메세지
    int rowCount     = 0;                       //DB ResultSet 리스트의 건수

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    Logger log = Logger.getLogger("com.hanjin.apps.SCQuotation.SCQuotationMain");
    
    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();

        event = (EsmPri6008Event)request.getAttribute("Event");
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
<title>S/C Quotation Creation - G/L Copy Option</title>
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

<input type="hidden" name="eff_dt" value="<%=request.getParameter("eff_dt")%>">
<input type="hidden" name="exp_dt" value="<%=request.getParameter("exp_dt")%>">
<input type="hidden" name="prc_cust_tp_cd" value="<%=request.getParameter("prc_cust_tp_cd")%>">
<!-- TPW 용 -->
<input type="hidden" name="cmdt_tpw_mst" value="">
<input type="hidden" name="cmdt_tpw_dtl" value="">
<input type="hidden" name="prop_no" value="<%=request.getParameter("qttn_no")%>">
<input type="hidden" name="amdt_seq" value="<%=request.getParameter("qttn_ver_no")%>">
<input type="hidden" name="estm_mqc_qty" value="<%=request.getParameter("estm_mqc_qty")%>">
<!-- 개발자 작업 -->

<!-- OUTER - POPUP (S)tart -->
<table width="500" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;S/C Quotation- Guideline Copy</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- : ( Search Options ) (S) -->
 
			<table class="search"> 
       		<tr><td class="bg">
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="90">Quotation No.</td>
					<td width="100"><input type="text" name="qttn_no" style="width:80;text-align:center;" class="input2" value="<%=request.getParameter("qttn_no")%>" readonly></td>
					<td width="50">Ver. No.</td>
					<td width="50"><input type="text" name="qttn_ver_no" style="width:30;text-align:center;" class="input2" value="<%=request.getParameter("qttn_ver_no")%>" readonly></td> 
					<td width="90">Creation Date</td>
					<td width=""><input type="text" name="cre_dt" style="width:80;text-align:center;" class="input2" value="<%=request.getParameter("cre_dt")%>" readonly></td>
				</tr>
				</table>
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="90">Service Scope</td>
					<td width=""><input type="text" name="svc_scp_cd" style="width:80;text-align:center;" class="input2" value="<%=request.getParameter("svc_scp_cd")%>" readonly>&nbsp;<input type="text" name="svc_scp_nm" style="width:286;" class="input2" value="<%=request.getParameter("svc_scp_nm")%>" readonly></td>
				</tr>
				</table>
				<table class="height_5"><tr><td></td></tr></table>
				
				<table border="0" style="width:100%;" class="search_sm2"> 
					<tr class="h23">
						<td width="50%"><input type="checkbox"  name="frm_loc_chk" value="Y">&nbsp;Location Group</td>
						<td width="50%"><input type="checkbox"  name="frm_rate_chk" value="Y" class="trans">&nbsp;Rate</td>
					</tr>
					<tr class="h23">
						<td width="50%"><input type="checkbox" name="frm_cmdt_chk" value="Y" class="trans">&nbsp;Commodity Group</td>
						<td width="50%"><input type="checkbox" name="frm_cmdt_tpw_chk" value="Y" class="trans">&nbsp;Commodity Group (TPW)</td>
					</tr>
					<tr>
						<td colspan="2" align="right" style="padding-top:10">
							<table border="0" cellpadding="0" cellspacing="0"><tr>
						
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_CheckAll">Check All</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_UnCheckAll">Uncheck All</td>
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
					<td class="btn1" name="btn_OK">OK</td>
					<td class="btn1_right"></td>					
			</tr>
			</table>
			<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Close">Close</td>
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
