<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_4106.jsp
*@FileTitle : Invoice Cancel Reason Entry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.12
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2009.10.12 김태균
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
<%@ page import="com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.event.EesDmt4106Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
	EesDmt4106Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	String strUsr_ofc = "";
	String strCnt_cd = "";
	Logger log = Logger.getLogger("com.hanjin.apps.InvoiceMgt.InvoiceIssueCollectionMgt");
	
	String invoiceNo    = "";
	String dmdtTrfCd    = "";
	String multi        = "";
	String creOfcCd     = "";
	String creCntCd     = "";
	String idaTaxApplTm = "";
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_ofc = account.getOfc_cd();
		strCnt_cd = account.getCnt_cd();

		event = (EesDmt4106Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		invoiceNo	 = JSPUtil.getParameter(request,"dmdt_inv_no");
		creOfcCd     = JSPUtil.getParameter(request,"cre_ofc_cd");
		creCntCd     = JSPUtil.getParameter(request,"cre_cnt_cd");
		dmdtTrfCd	 = JSPUtil.getParameter(request,"dmdt_trf_cd");
		multi	     = JSPUtil.getParameter(request,"multi");
		idaTaxApplTm = JSPUtil.getParameter(request,"ida_tax_appl_tm");
		
	}
	catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Invoice Cancel Reason Entry</title>
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
<body class="popup_bg" onLoad="setupPage();"> 
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!--  개발자 작업 -->
<input type="hidden" name="dmdt_inv_no" value=<%=invoiceNo %>>
<input type="hidden" name="cre_ofc_cd"  value=<%=creOfcCd %>>
<input type="hidden" name="cre_cnt_cd"  value=<%=creCntCd %>>
<input type="hidden" name="dmdt_trf_cd" value=<%=dmdtTrfCd %>>
<input type="hidden" name="success_yn" ><!-- 성공,실패 FLAG -->
<input type="hidden" name="multi"       value=<%=multi %>><!-- 멀티 캔슬인지 확인 -->
<!-- 인도 TAX RATIO 변경 후 필드 ( 2017.07.26 ) -->
<input type="hidden" name="ida_tax_appl_tm" value=<%=idaTaxApplTm%>>

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
	<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Invoice Cancel Reason Entry
			</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- : ( Search Options ) (S) -->
 
			<table class="search"> 
       		<tr><td class="bg">
				<!-- : ( Grid ) (S) -->
				
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>				
			<table width="100%" class="grid">			
				<tr>
					<td width="67" class="tr_head2">Remark(s)</td>
					<td width=""><textarea name="cxl_rmk" cols="" rows="5"  style="width:100%;"></textarea></td>
					</tr>
				</table> 
				<!-- : ( Grid ) (E) -->	
				<!-- : ( Button : Grid ) (S) -->
			
			<table width="100%" class="serch"> 
	      	 <tr class="h23">
			 <td width="40">Office<td>
			<td width="100"><input type="text" style="width:70;" class="input2" value="<%=strUsr_ofc %>"><td>
			<td width="33">Name<td>
			<td width=""><input type="text" style="width:100%;" class="input2" value="<%=strUsr_nm %>"><td>
			</tr>
			</table>
				<!--  Button_Sub (S) -->
	    	<!-- Button_Sub (E) -->
		    <!-- : ( Button : Grid ) (E) -->	
			
			</td></tr>
		</table>
		<table class="height_5"><tr><td></td></tr></table>
<!-- : ( Search Options ) (E) -->
</td></tr>
</table> 


	
	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td width="72"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_save">Save</td>
					<td class="btn1_right"></td>
			</tr>
			</table></td>
			<td class="btn1_line"></td>
			<td width="72"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_close">Close</td>
					<td class="btn1_right"></td>
			</tr>
			</table>
		</td></tr>
		</table></td></tr>
		</table>
    <!--Button (E) -->
	
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->
			
</form>			
</body>
</html>