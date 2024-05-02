<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MNR_0061.jsp
*@FileTitle : ACEP(Approved continuous Exam Program) Check List
*Open Issues :     
*Change history :  
*@LastModifyDate : 2018.01.02
*@LastModifier : 변종건
*@LastVersion : 1.0
* 2018.01.02 변종건		   		
* 1.0 Creation	 	   
* History
* 2018.01.02 변종건 신규 개발	
=========================================================*/
%>
	
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.event.EesMnr0061Event"%>
<%@ page import="com.hanjin.framework.core.controller.DefaultViewAdapter"%>
<%@ page import="org.apache.log4j.Logger" %>
 
<%
	EesMnr0061Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
		 
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100"; 
	
	String sXml = null;
 		 
	String strUsr_id		= ""; 
	String strUsr_nm		= "";  
	String strOfc_cd		= "";  
	Logger log = Logger.getLogger("com.hanjin.apps.OperationManage.RepairMgt");
	
	//팝업용 데이타
	String paramRqstEqNo = JSPUtil.getNull(request.getParameter("rqst_eq_no")).trim();
	String paramRprRqstSeq = JSPUtil.getNull(request.getParameter("rpr_rqst_seq")).trim();
	String paramMnrOrdOfcCtyCd = JSPUtil.getNull(request.getParameter("mnr_ord_ofc_cty_cd")).trim();
	String paramMnrOrdSeq = JSPUtil.getNull(request.getParameter("mnr_ord_seq")).trim();
	String paramOrdDtlSeq = JSPUtil.getNull(request.getParameter("ord_dtl_seq")).trim();
	String paramMnrWoTpCd = JSPUtil.getNull(request.getParameter("mnr_wo_tp_cd")).trim();
	
	try {     
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	    strOfc_cd = account.getOfc_cd();
			
		event = (EesMnr0061Event)request.getAttribute("Event"); 
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
 
		if (serverException != null) {   
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();  
		}       
		
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		DefaultViewAdapter adapter = new DefaultViewAdapter();
		sXml = adapter.makeXML(request, response);
	 	   	   	
	}catch(Exception e) {    
		out.println(e.toString());
	}
%>
<html>
<head>
<title>ACEP Check List</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 

<!--MNR 공용 사용  -->                
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
<input type="hidden" name="acep_seq" value="">
<input type="hidden" name="rpr_rqst_seq" value="<%=paramRprRqstSeq%>">
<input type="hidden" name="mnr_ord_ofc_cty_cd" value="<%=paramMnrOrdOfcCtyCd%>">
<input type="hidden" name="mnr_ord_seq" value="<%=paramMnrOrdSeq%>">
<input type="hidden" name="ord_dtl_seq" value="<%=paramOrdDtlSeq%>">
<input type="hidden" name="mnr_wo_tp_cd" value="<%=paramMnrWoTpCd%>">


<!-- 개발자 작업	-->   
<!-- OUTER - POPUP (S)tart -->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr>
		<td valign="top">
			<!--Page Title, Historical (S)-->
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			    <tr>
			    	<td height="40" class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;ACEP Check List</td>
			    </tr>
			</table>
			<!--Page Title, Historical (E)-->   
	  
			<!--Button (S) -->
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:2;"> 
		       	<tr>
		       		<td class="btn1_bg">
					    <table border="0" cellpadding="0" cellspacing="0">
						    <tr>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>						
											<td class="btn1" name="btn_Save">Save</td>	
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
	    	<!--Button (E) -->
	
	
			<!--biz page (S)-->
			<table class="search" id="mainTable">
	       		<tr>
	       			<td class="bg">
						<table class="search" border="0" style="width:979;">
							<tr class="h23">
								<td width="60">CNTR No.</td>
								<td width="140"><input required maxlength="14" style="width:120;" type="text" name="eq_no" value='<%=paramRqstEqNo%>' dataformat="engup" caption="EQ No" class="input2" readonly></td> 
								<td width="65">Type</td>
								<td width="130"><input required maxlength="20" style="width:120;" type="text" name="cntr_tpsz_cd" value='' dataformat="engup" caption="Estimate No" class="input2" readonly></td>
								<td width="120">Manufactured Year</td>
								<td width="100"><input style="width:83;" type="text" name="mft_dt" value='' dataformat="ymd" caption="yard cd" class="input2" readonly></td>
								<td width="75"></td>
								<td width=""></td>
							</tr>
							<tr class="h23">
								<td width="">Inspection Location</td>
								<td width=""><input style="width:120;" type="text" name="insp_yd_cd" value='' dataformat="engup" maxlength="7" caption="yard cd" class="input2" readonly></td>	
								<td width="">Inspector</td>
								<td width=""><input type="text" style="width:120;" name="cre_usr_nm" dataformat="engup" maxlength="50"  class="input2" size="10"  value="" readonly></td>		
								<td width="">Last Inspection Date</td>
								<td width=""><input type="text" style="width:83;" name="lst_insp_dt" dataformat="ymd" maxlength="8"  class="input2" size="10"  value="" readonly></td>
								<td width="">Inspection Date</td>
								<td width=""><input type="text" style="width:83;" name="insp_dt" dataformat="ymd" maxlength="8"  class="input2" size="10"  value="" readonly></td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			<!-- 3 (E) -->
			<table class="height_8"><tr><td></td></tr></table>
			
			<table class="search" id="mainTable">
	       		<tr>
	       			<td class="bg" width="100%" valign="top">
	       			
						<!-- : ( Grid ) (S) -->
						<table width="100%"  id="mainTable">
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('sheet1');</script>
								</td>
							</tr>
						</table>
						
				 		<table class="height_8"><tr><td></td></tr></table>
					</td>
				</tr>
			</table>
		
		</td>
	</tr>
</table>
<table width="100%" class="sbutton">
	<tr>
		<td height="71" class="popup">
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:0;">
				<tr>
					<td class="btn3_bg">
						<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_Close">Close</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>
