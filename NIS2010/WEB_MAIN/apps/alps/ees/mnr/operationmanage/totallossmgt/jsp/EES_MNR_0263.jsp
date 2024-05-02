<%/*=========================================================
*Copyright(c) 2012 CyberLogitec 
*@FileName : EES_MNR_0263.jsp
*@FileTitle : Write off Approval
*Open Issues :
*Change history :
*@LastModifyDate : 2012.12.10	 
*@LastModifier : 조경완	 
*@LastVersion : 1.0 
* 2012.12.10 조경완 
* 1.0 Creation
=========================================================*/%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.mnr.operationmanage.totallossmgt.event.EesMnr0263Event"%>
<%@ page import="org.apache.log4j.Logger" %> 
					   
<% 					
	EesMnr0263Event  event = null;				//PDTO(Data Transfer Object including Parameters)
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
	Logger log = Logger.getLogger("com.hanjin.apps.operationmanage.totallossmgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id    =	account.getUsr_id();
		strUsr_nm    = 	account.getUsr_nm(); 
		rhqOfcCd     = 	account.getRhq_ofc_cd();
		currOfcCd    = 	account.getOfc_cd();
		currOfcEngNm = 	account.getOfc_eng_nm();
		
		event = (EesMnr0263Event)request.getAttribute("Event");
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
<title><span id="title"></span></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	var currOfcCd = "<%=currOfcCd.trim() %>";
	var usrId     = "<%=strUsr_id.trim()%>";
	var currOfcUS = "";
	
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
<input type="hidden" name="ttl_lss_sts_cd">
<input type="hidden" name="pagerows">
<input type="hidden" name="work_type" value="management">  


<!-- 기존로직용  --> 
<input type="hidden" name="self_ofc" value="<%=currOfcCd%>"> 
<input type="hidden" name="apro_usr_id" value="<%=strUsr_id.trim()%>"> 
<input type="hidden" name="ttl_lss_no" value="">  
<input type="hidden" name="search_ttl_lss_no" value="">    
<input type="hidden" name="rqst_ofc_cd" value="">  
<input type="hidden" name="rqst_dt" value=""> 

<input type="hidden" name="ttl_lss_sts_cd_flg" value="">   
<input type="hidden" name="ttl_lss_rsn_cd" value="">   
<input type="hidden" name="ttl_lss_dtl_rsn_cd" value="">   
<!-- input type="text" name="ttl_lss_dt" value="" -->   
<input type="hidden" name="apro_ofc_cd" value="">   
<input type="hidden" name="file_seq">   
<input type="hidden" name="sub_file_seq">
<input type="hidden" name="wrtf_no">  
<input type="hidden" name="user_ofc_cd">
<input type="hidden" name="mnr_sts_ref_no">
<input type="hidden" name="respb_ofc_nm" value=""><!-- 참조로만 저장시 VO 필요없음 -->

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
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_New">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Reject">Reject</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Confirm">Confirm</td>
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
			
				<!--  biz_1  (S) -->	
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="30%" valign="top">
						<table class="search_" border="0" style="width:295;">
							<tr class="h23">  
								<td width="95">RQST Date</td>	     
								<td width="200">	 	
									<input type="text" name="in_st_dt" dataformat="ymd"    caption="from date"        maxlength="8"  size="10"  cofield="in_end_dt" value="" class="input">      
      									~ <input type="text" name="in_end_dt" dataformat="ymd"    caption="to date"        maxlength="8"  size="10"  cofield="in_st_dt" class="input">&nbsp;<img name="btn_period" class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle">
								</td>   	 		
							</tr>    	
							<tr class="h23">   
								<td width="95">TLL No.</td>  
								<td width=""><input type="text" name="in_ttl_lss_no" style="width:162;text-align:Left" class="input" dataformat="engup" maxlength="400">&nbsp;
								</td>
								
							</tr>	  	   
							<tr class="h23">
								<td width="95" style="text-align:left">EQ Type</td>	
								<td width="" style="padding-left:2"> 
								<script language="javascript">ComComboObject('eq_knd_cd', 1, 100, 1, 0);</script>
								</td>
							</tr>
							<tr class="h23">
								<td width="70">EQ No.</td>
								<td width="150"><input id="in_rqst_eq_no" name="in_rqst_eq_no" type="text" style="width: 162px" class="input" dataformat="engup" value="" >&nbsp;<!--<img src="img/btns_multisearch.gif" name="eq_no_multi1"width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"> -->
								</td>
							</tr>
							<tr class="h23"> 
								<td width="95">RESP OFC</td>   
								<td width=""><input type="text" name="respb_ofc_cd" style="width:100" value="<%=currOfcCd%>" class="input2" dataformat="engup" readOnly></td>
							</tr>		 
						</table>	
					</td>
					<td width="70%">  
					<!-- Grid  1(S) -->
						<table width="100%"  id="mainTable"> 
							<tr>
								<td width="100%"> 
									<script language="javascript">ComSheetObject('sheet1');</script>
								</td>
							</tr>
						</table>
						<!-- Grid  1(E) -->
					</td>
					</tr> 
				</table>				
				<!--  biz_1   (E) -->
		</td></tr></table>
		
		<!-- 1 (E) -->
		<!-- 3 (S) -->
		<table class="height_8"><tr><td></td></tr>	
		<table class="search" id="mainTable">
       		<tr><td class="bg">

			<!-- Grid - 2 (S) -->
				<table width="100%"  id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('h1sheet1');</script>
						</td>
					</tr>
				</table>
			<!-- Grid - 2 (E) -->



			<!--  Button_Sub (S) -->
			<table width="100%" class="button">
	       	<tr><td class="btn2_bg">
	       	
				<table border="0" cellpadding="0" cellspacing="0">
				<tr>
				<td>
					<!--  Total  (S) -->
					<table border="0" width="100%"> 
						<tr>
							<td width="150" align="right"><b>D/V Amount TTL</b>&nbsp;</td>
							<td><input type="text" name="dvAmtTtl" style="width:120;text-align:right;" class="input2" dataformat="float" maxlength="13" pointcount="2" caption="실수(최대최소)" readOnly="true"></td>
							<td width="150" align="right"><b>Recovery AMT TTL</b>&nbsp;</td>
							<td><input type="text" name="recveryAmtTtl" style="width:120;text-align:right;" class="input2" dataformat="float" maxlength="13" pointcount="2" caption="실수(최대최소)" readOnly="true"></td>
							<td width="110" align="right"><b>Loss AMT TTL</b>&nbsp;</td>
							<td><input type="text" name="lossAmtTtl" style="width:120;text-align:right;" class="input2" dataformat="float" maxlength="13" pointcount="2" caption="실수(최대최소)" readOnly="true"></td>
							<td width="20" align="center"></td>
						</tr> 
					</table>				
					<!--  Total  (E) -->	
				</td>
			</tr>
			</table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->

			</td></tr>
		</table>
		
	<table class="tab" border="0" cellpadding="0" cellspacing="0" width=100%>
     	<tr><td width="100%">
			<script language="javascript">ComTabObject('tab1')</script>
				<!-- img src="img/sub_tab.gif" alt="" width="998" height="23" border="0" -->
		</td></tr>
	</table>

	<div id="tabLayer" style="display:inline">

		<table class="search" id="mainTable">
       		<tr><td class="bg">

			<!-- Grid - 2 (S) -->
				<table width="100%"  id="mainTable">
					<tr>
					<td width="45%" style="padding-right:20" valign="top">
						<table border="0" style="width:100%; background-color:white;" class="grid2"> 
						<tr><td class="tr2_head" width="155" >Detail Reason of <br/> Total Loss</td>  
							<td>     
							<textarea name="ttl_lss_dtl_rsn_rmk" style="width:100%;height:50;" readOnly="true"></textarea>
							</td>  
						</tr>
						<tr><td class="tr2_head" width="155">Reason of Collection <br/>Failure/DV Discount</td>  
							<td>     
							<textarea name="dpc_clt_fald_rsn_rmk" style="width:100%;height:50;" readOnly="true"></textarea>
							</td>  
						</tr>
						<tr><td class="tr2_head" width="155">Recovery Action History/<br/>Counter Measure</td>  
							<td>     
							<textarea name="rcvr_act_his_rmk" style="width:100%;height:50;" readOnly="true"></textarea>
							</td>  
						</tr> 
						</table>
					</td>
				<td width="20%" valign="top">
					
					<!-- Grid - 4 - Evidence Attached (S) -->
				<table width="100%"  id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('t1sheet1');</script>
						</td>
					</tr>
				</table>
				
				<!--  Button_Sub (S) -->
			    	
				</td>
				<td width="1%" valign="top"></td>
				<td width="34%" valign="top">
					<table width="100%"  id="mainTable">
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('t1sheet2');</script>
							</td>
						</tr>
					</table>
				</td>
				
				</tr>
				</table>
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
						<td width="75%" valign="top">
							<table width="100%"  id="mainTable">
								<tr>
									<td width="100%">
										<script language="javascript">ComSheetObject('t2sheet1');</script>
									</td>
								</tr>
							</table>
							
						</td>
						<td width="1%" valign="top"></td>
						<td width="24%" valign="top">
							<table width="100%"  id="mainTable">
								<tr>
									<td width="100%">
										<script language="javascript">ComSheetObject('t2sheet2');</script>
									</td>
								</tr>
							</table>
							
						</td>
					</tr>
				</table>
			<!-- Grid - 2 (E) -->				
			</td></tr>
		</table>
		<!-- 3 (E) -->

</div>

	<table class="height_10"><tr><td colspan="8"></td></tr></table>
<script language="javascript">ComUploadObject('upload1', '<%=session.getId()%>');</script>

</form>
</body>
</html>