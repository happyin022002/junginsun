<%/*=========================================================
*Copyright(c) 2009 CyberLogitec 
*@FileName : EES_MNR_0234.jsp
*@FileTitle : Total Loss Detail Pop Up
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.11 
*@LastModifier : 권영법	 
*@LastVersion : 1.0 
* 2010.01.11 권영법 
* 1.0 Creation
=========================================================*/%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.mnr.operationmanage.totallossmgt.event.EesMnr0234Event"%>
<%@ page import="org.apache.log4j.Logger" %> 
					   
<% 					
	EesMnr0234Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= ""; 
	String strUsr_nm		= "";   
	String rhqOfcCd         = ""; 
	String currOfcCd       = "";
	String currOfcEngNm     = ""; 
	String ttlLssNo= JSPUtil.getParameter(request, "ttl_lss_no");
	String rqstOfcCd= JSPUtil.getParameter(request, "rqst_ofc_cd");
	
	String aproOfcCd= JSPUtil.getParameter(request, "apro_ofc_cd");
	String respbOfcCd= JSPUtil.getParameter(request, "respb_ofc_cd");
	String ttlLssDt= JSPUtil.getParameter(request, "ttl_lss_dt");
	String rqstDt= JSPUtil.getParameter(request, "rqst_dt");
	String ttlLssStsNm= JSPUtil.getParameter(request, "ttl_lss_sts_nm");
	String ttlLssRsnNm= JSPUtil.getParameter(request, "ttl_lss_rsn_nm");
	String ttlLssDtlRsnNm= JSPUtil.getParameter(request, "ttl_lss_dtl_rsn_nm");

	
	Logger log = Logger.getLogger("com.hanjin.apps.operationmanage.totallossmgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id    =	account.getUsr_id();
		strUsr_nm    = 	account.getUsr_nm(); 
		rhqOfcCd     = 	account.getRhq_ofc_cd();
		currOfcCd    = 	account.getOfc_cd();
		currOfcEngNm = 	account.getOfc_eng_nm();
		
		event = (EesMnr0234Event)request.getAttribute("Event");
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
<title>Total Loss Detail Pop UP</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	var currOfcCd = "<%=currOfcCd.trim() %>";
	var usrId     = "<%=strUsr_id.trim()%>";
	
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
<script language="javascript">ComSheetObject('sheet1');</script>
</head>

<body class="popup_bg"  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">   
<input type="hidden" name="pagerows">
<input type="hidden" name="work_type" value="collection">  


<!-- 기존로직용  --> 
<input type="hidden" name="self_ofc" value="<%=currOfcCd%>">  
<input type="hidden" name="ttl_lss_no" value="<%=ttlLssNo%>">  
<input type="hidden" name="search_ttl_lss_no" value="<%=ttlLssNo%>">    
<input type="hidden" name="in_rqst_ofc_cd" value="<%=rqstOfcCd%>">  
<input type="hidden" name="rqst_ofc_cd" value="<%=rqstOfcCd%>">  
<input type="hidden" name="rqst_dt" value=""> 
<input type="hidden" name="ttl_lss_sts_cd" value="">   
<input type="hidden" name="ttl_lss_rsn_cd" value="">   
<input type="hidden" name="ttl_lss_dtl_rsn_cd" value="">   
<input type="hidden" name="ttl_lss_dt" value="">   
<input type="hidden" name="apro_ofc_cd" value="">   
<input type="hidden" name="file_seq">    
<input type="hidden" name="mnr_sts_ref_no">
<input type="hidden" name="respb_ofc_nm" value=""><!-- 참조로만 저장시 VO 필요없음 -->
<input type="hidden" name="com_mrdArguments">
<input type="hidden" name="com_mrdPath">
<input type="hidden" name="com_mrdBodyTitle">

<table width="100%" cellpadding="0" cellspacing=0 border="0"> 
<tr><td class="top">
	
				<!-- OUTER - POPUP (S)tart -->
				<table width="100%" class="popup" cellpadding="10" border="0"> 
				<tr><td class="top"></td></tr>
				<tr><td valign="top">
		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">Total Loss Detail Pop UP</td></tr>
		</table>
		<!--Page Title, Historical (E)-->
		
		<table class="height_8"><tr><td></td></tr></table>	
		<!-- 1 (S) -->
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">
			<script language="javascript">ComSheetObject('sheet2');</script>
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="80">TLL No.</td>
					<td width="140"><input type="text" name="ttl_lss_no_text" style="width:125;text-align:center" class="input2" maxlength="20" value="<%=ttlLssNo%>" readonly></td>
					<td width="110">Responsible OFC</td>
					<td width="120"><input type="text" name="respb_ofc_cd" style="width:100;" class="input"  maxlength="6" dataformat="engup" value="<%=respbOfcCd%>"></td>
					<td width="60">REQ OFC</td>
					<td width="100"><input type="text" name="rqst_ofc_cd_nm" style="width:80;" class="input2" value="<%=rqstOfcCd%>" readOnly="true"></td>
					<td width="50">REQ DT</td>
					<td width="100"><input type="text" name="rqst_dt_text" style="width:80;text-align:center" class="input2" value="<%=rqstDt%>" dataformat="ymd" value="" readOnly="true"></td>
					<td width="60">Status</td>
					<td width=""><input type="text" name="ttl_lss_sts_cd_nm" style="width:120;" class="input2" value="<%=ttlLssStsNm%>" readOnly="true"></td>
				</tr> 
				</table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="80">Main Reason</td>
					<td width="140"><input type="text" name="ttl_lss_rsn_cd_nm" style="width:70;" class="input2" value="<%=ttlLssRsnNm%>" readOnly="true"></td>
					<td width="110">Sub Reason</td>
					<td width="280"><input type="text" name="ttl_lss_dtl_rsn_cd_nm" style="width:260;" class="input2" value="<%=ttlLssDtlRsnNm%>" readOnly="true"></td>					
					<td width="50">TLL DT</td>
					<td width="100"><input type="text" name="ttl_lss_dt_text" style="width:80;text-align:center" class="input2" value="<%=ttlLssDt%>" readOnly="true">&nbsp;</td>
					<td width="60">APP OFC</td>
					<td width=""><input type="text" name="apro_ofc_cd_nm" style="width:60;text-align:center" class="input2" value="<%=aproOfcCd%>" readOnly="true"></td>					
				</tr> 
				</table>				
				<!--  biz_1   (E) -->
			
		</td></tr></table>
		<!-- 1 (E) -->
		
		<!-- 3 (S) -->
		<table class="height_8"><tr><td></td></tr></table>	
		
		<table class="search" border="0" style="width:100%;"> 
		<tr class="h23">
		<td width="50%" valign="top">
	
		<!-- Tab (S) -->
   		<table class="tab" border="0" cellpadding="0" cellspacing="0" width=100%>
     		<tr><td width="100%">
					<script language="javascript">ComTabObject('tab1')</script>
					<!-- img src="img/sub_tab.gif" alt="" width="998" height="23" border="0" -->
				</td></tr>
		</table>
		<!-- Tab (E) -->

		<!--TAB D.V Expense (S) -->
		<div id="tabLayer" style="display:inline">
		
				<table class="search" id="mainTable">
		       		<tr><td class="bg">
		
					<!-- Grid - 2 (S) -->
						<table width="100%"  id="mainTable">
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('t1sheet1');</script>
								</td>
							</tr>
						</table>
					<!-- Grid - 2 (E) -->
		
					
		
					<!--  Button_Sub (S) -->
					<table width="100%" class="button">
			       	<tr><td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_t1InvoicePreview">Invoice Preview</td>
							<td class="btn2_right"></td>
							</tr>
							</table></td>						
							
							</tr></table>
					</td></tr>
					</table>
			    	<!-- Button_Sub (E) -->
		
					</td></tr>
				</table>
				<!-- 3 (E) -->
		
		</div>
		<!--TAB D.V Expense (E) -->
		
		
		<!--TAB 3rd Party (S) -->
		<div id="tabLayer" style="display:none">
		
				<table class="search" id="mainTable"> 
		       		<tr><td class="bg">	
		
					<!-- Grid - 2 (S) -->
						<table width="100%"  id="mainTable">
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('t2sheet1');</script>
								</td>
							</tr>
						</table>
					<!-- Grid - 2 (E) -->	
		
							
					
					<!--  Button_Sub (S) -->
					<table width="100%" class="button"> 
			       	<tr><td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_t2InvoicePreview">Invoice Preview</td>
							<td class="btn2_right"></td>
							</tr>
							</table></td>
						
							</tr></table>
					</td></tr>
					</table>
			    	<!-- Button_Sub (E) -->
					
					</td></tr>
				</table>
				<!-- 3 (E) -->
		
		</div>
		<!--TAB 3rd Party (E) -->
		
		
		<!--TAB Disposal (S) -->
		<div id="tabLayer" style="display:none">
		
				<table class="search" id="mainTable"> 
		       		<tr><td class="bg">	
		
					<!-- Grid - 2 (S) -->
						<table width="100%"  id="mainTable">
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('t3sheet1');</script>
								</td>
							</tr>
						</table>
					<!-- Grid - 2 (E) -->	
		
				
					<!--  Button_Sub (S) -->
					<table width="100%" class="button"> 
			       	<tr><td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_t3InvoicePreview">Invoice Preview</td>
							<td class="btn2_right"></td>
							</tr>
							</table></td>
							
							</tr></table>
					</td></tr>
					</table>
			    	<!-- Button_Sub (E) -->
					
					</td></tr>
				</table>
				<!-- 3 (E) -->
		
		</div>
		<!--TAB Disposal (E) -->
		
		
		<!--TAB Scrapping (S) -->
		<div id="tabLayer" style="display:none">
		
				<table class="search" id="mainTable"> 
		       		<tr><td class="bg">	
		
					<!-- Grid - 2 (S) -->
						<table width="100%"  id="mainTable">
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('t4sheet1');</script>
								</td>
							</tr>
						</table>
					<!-- Grid - 2 (E) -->	
		
				
					
					<!--  Button_Sub (S) -->
					<table width="100%" class="button"> 
			       	<tr><td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_t4InvoicePreview">Invoice Preview</td>
							<td class="btn2_right"></td>
							</tr>
							</table></td>							
							
							</tr></table>
					</td></tr>
					</table>
			    	<!-- Button_Sub (E) -->
					
					</td></tr>
				</table>
				<!-- 3 (E) -->
		
		</div>
		<!--TAB Scrapping (E) -->
		
		
		<!--TAB Insurance(TT Club) (S) -->
		<div id="tabLayer" style="display:none">
		
				<table class="search" id="mainTable"> 
		       		<tr><td class="bg">	
		
					<!-- Grid - 2 (S) -->
						<table width="100%"  id="mainTable">
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('t5sheet1');</script>
								</td>
							</tr>
						</table>
					<!-- Grid - 2 (E) -->	
		
					
					
					<!--  Button_Sub (S) -->
					<table width="100%" class="button"> 
			       	<tr><td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
						<tr> 
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_t5InvoicePreview">Invoice Preview</td>
							<td class="btn2_right"></td>
							</tr>
							</table></td>							
							
							</tr></table>
					</td></tr>
					</table> 
			    	<!-- Button_Sub (E) -->
					
					</td></tr>
				</table>
				<!-- 3 (E) -->
		
		</div>
		<!--TAB Insurance(TT Club) (E) -->
		</td>  
		 	
		<td width="2%">&nbsp;</td>
		<td width="48%">   
		<table class="search" id="mainTable">
       	<tr><td class="bg" width="100%" valign="top" style="padding-top:15;"> 
		<table class="search" border="0">
			<tr><td class="title_h"></td>
				<td class="title_s"> Total Loss Collection &amp; Adjustment</td></tr>
		</table>
		<!-- Grid 4 (S) -->
		 <table width="100%"  id="mainTable"> 
			<tr>
				<td width="100%">
					<script language="javascript">ComSheetObject('sheet3');</script>
				</td>
			</tr>
		</table>
		<!-- Grid 4(E) -->		
		
		<!--  Button_Sub (S) -->
		<table width="100%" class="button" border=0>  
       	<tr><td class="btn2_bg">
			<table border="0" cellpadding="0" cellspacing="0"><tr class="h23">
					<td><table border="0"> 
						<tr>
							<td  align="right"><nobr><b>Collection Total</b>&nbsp; </nobr></td>
							<td><input type="text" name="tCollectionTotal" style="width:120;text-align:right;" class="input2" dataformat="float" maxlength="13" pointcount="2" caption="실수(최대최소)" readOnly="true"></td>
							<td width=20></td>
						</tr> 
					</table></td>
				</tr></table>
		</td></tr>
		</table>
		</td>	
		</tr></table>
		</td>	
		</tr></table>
		<table class="height_8"><tr><td></td></tr></table>	
		<!-- 1 (S) -->
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">
				<!--  Total  (S) -->
				<table border="0" width="100%"> 
					<tr>
						<td width="150" align="right"><b>Recovery Plan Total</b>&nbsp;</td>
						<td><input type="text" name="t1RecPlnTotal" style="width:120;text-align:right;" class="input2" dataformat="float" maxlength="13" pointcount="2" caption="실수(최대최소)" readOnly="true"></td>
						<td width="120" align="right"><b>Loss Total</b>&nbsp;</td>
						<td><input type="text" name="t1LossTotal" style="width:120;text-align:right;" class="input2" dataformat="float" maxlength="13" pointcount="2" caption="실수(최대최소)" readOnly="true"></td>
						<td width="110" align="right"><b>Balance Total</b>&nbsp;</td>
						<td><input type="text" name="t1BalanceTotal" style="width:120;text-align:right;" class="input2" dataformat="float" maxlength="13" pointcount="2" caption="실수(최대최소)" readOnly="true"></td>
						<td width="20" align="center"></td>
					</tr> 
				</table>				
				<!--  Total  (E) -->	
		</td></tr></table>
		<!-- 1 (E) -->
		<!-- 4 (S) -->
		<table class="height_8"><tr><td></td></tr></table>	
		<table class="search" id="mainTable">
       	<tr><td class="bg" width="100%" valign="top">
			<table class="search" border="0">
			<tr><td class="title_h"></td>
				<td class="title_s"> Total Loss History</td></tr>
			</table>
			
			
			<!-- Grid - 3,4 (S) -->
			<table class="search" width="100%">
			<tr><td width="75%" style="padding-right:20" valign="top">
			

					<!-- Grid - 3  (S) -->
				<table width="100%"  id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet4');</script>
						</td>
					</tr>
				</table>
					<!-- Grid - 3 (E) -->	


				</td>
				<td width="25%" valign="top">
					
					<!-- Grid - 4 - Evidence Attached (S) -->
				<table width="100%"  id="mainTable">
					<tr> 
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet5');</script>
						</td> 
					</tr>
				</table>
					<!-- Grid - 4 - Evidence Attached (E) -->
				
				</td></tr>
			</table>	
			<!-- Grid - 3,4 (E) -->

		
		</td></tr>
		</table>		
		<!-- 4 (E) -->		
			
		
		<!--biz page (E)-->

<table class="height_5"><tr><td></td></tr></table>
	
	
	</td></tr>
		</table>
	
	
	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Close">Close</td>
					<td class="btn1_right"></td>
				</tr></table></td>
			</tr>
		</table>
	</td></tr>
</table>
    <!--Button (E) -->
	
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->

	<table class="height_10"><tr><td colspan="8"></td></tr></table>
<script language="javascript">ComUploadObject('upload1', '<%=session.getId()%>',0,0);</script>

</form>
</body>
</html>