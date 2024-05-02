<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_lse_0055.jsp
*@FileTitle : On off Hire Audit
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.19
*@LastModifier : 진준성
*@LastVersion : 1.0
* 2009.06.19 진준성
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
<%@ page import="com.hanjin.apps.alps.ees.lse.containercostanalysis.onoffhireaudit.event.EesLse0055Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesLse0055Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.ContainerCostAnalysis.IOnOffHireAudit");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EesLse0055Event)request.getAttribute("Event");
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
<title>On off Hire Audit</title>
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
<!-- 개발자 작업	-->
<input type="hidden" name="ref_no">
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
					<td class="btn1" name="btn_retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width=72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_new">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>											
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_file">File Import</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_audit">Audit & Result</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				</tr>
			</table>
		</td></tr>
	</table>
    <!--Button (E) -->
	<table class="search"> 
       	<tr><td class="bg">
				<!--  biz_1  (S) -->
			<table class="search" border="0" style="width:979;"> 
				<tr class="h23">					
					<td width="65">&nbsp;Lessor</td>
					<td width="380">
					    <input type="text" name="vndr_seq" style="width:50;ime-mode:disabled" value="" class="input1" maxlength="6" dataformat="int">					   
					    <img class="cursor" src="img/btns_search.gif" name="btns_search1" width="19" height="20" border="0" align="absmiddle">
					    <input type="text" name="vndr_nm" style="width:250" value="" class="input2">
					</td>
					<td width="70">&nbsp;Version</td>
					<td width="130">
					    <script language="javascript">ComComboObject('aud_ver_seq', 1, 50, 1 ,1);</script>					    
					</td>			
					<td width="60">&nbsp;&nbsp;Period</td>
					<td>
					   <input type="text" name="search_stdt" style="width:80;ime-mode:disabled" value="" class="input1"  maxlength="8" dataformat="ymd" >&nbsp;
					   &nbsp;~&nbsp;
					   <input type="text" name="search_endt" style="width:80;ime-mode:disabled" value="" class="input1" maxlength="8" dataformat="ymd" >
					   <img class="cursor" src="img/btns_calendar.gif" name="btns_calendar1" width="19" height="20" border="0" align="absmiddle">
					</td>		
					
					<!--td>
					   <input type="text" name="search_month" style="width:60" value="" class="input1" maxlength="6" dataformat="ym" >
					    <img class="cursor" name="btns_calendar1" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle">
					    <input type="text" name="search_date" style="width:160" value="" class="input2" maxlength="8" dataformat="ymd" readonly >
					    <input type="hidden" name="search_stdt" value="" >
					    <input type="hidden" name="search_endt" value="" >
					</td -->		
				</tr> 
				</table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">	
					<td width="65">&nbsp;AGMT No</td>
					<td width="270" >
					   <input type="text" name="agmt_cty_cd" style="width:50;text-align:center" value="HHO" maxlength="3" class="input2" readonly >
					   <input type="text" name="agmt_seq"    style="width:55" value="" maxlength="6" class="input" dataformat="int">
					   <img class="cursor" src="img/btns_search.gif" name="btns_search2" width="19" height="20" border="0" align="absmiddle"></td>
					 <td width="110" >Term&nbsp;<input type="text" name="lstm_cd" style="width:25" value="" class="input2" readonly></td>
					</td>
					
					<td>
                        <table class="search_sm2" border="0" style=""> 
							<tr class="h23">	
								<td width="70">Audit Type</td>							
								<td class="stm">
								   <input type="radio" name="audit_tp" value="A" style="visibility:hidden" class="trans" >&nbsp;&nbsp;&nbsp;
								   <input type="radio" name="audit_tp" value="N" class="trans" checked>&nbsp; On Hire&nbsp;&nbsp;
								   <input type="radio" name="audit_tp" value="F" class="trans">&nbsp;Off Hire</td>
							</tr> 
						</table>
					</td>												
				</tr> 
				</table>
				
			
				<!--  biz_1  (E) -->
				
				<table class="height_8"><tr><td></td></tr></table>
				
				<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>				
				<!-- Grid  (E) -->

				<!--  Button_Sub (S) -->
			<!-- table width="100%" class="button"> 
	       	    <tr>
	       	        <td class="btn2_bg">			
				        <table border="0" cellpadding="0" cellspacing="0">
				            <tr>
						        <td>
						        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						            <tr>
						                <td class="btn2_left"></td>
						                <td class="btn2" name="btn_save">Save</td>
						                <td class="btn2_right"></td>
						            </tr>
					            </table>
					            </td>						
					        </tr>
					    </table>
			        </td>
			    </tr>
		    </table-->
	    	<!-- Button_Sub (E) -->				
            <!-- : ( Search Options ) (E) --> 
				</td></tr>
		</table>
	<!-- Tab BG Box  (S) -->
		<table class="height_10"><tr><td></td></tr></table>
	<!-- \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\  -->
			<!-- Tab ) (S) -->
     		<table class="tab" border="0" cellpadding="0" cellspacing="0" width="100%"> 
       		<tr><td width="100%">
						<script language="javascript">ComTabObject('tab1')</script>
						<!-- img src="img/sub_tab.gif" alt="" width="998" height="23" border="0" -->
					</td></tr>
				</table>
		<!-- Tab ) (E) --> 
			
			


<!--TAB  (S) -->
<div id="tabLayer" style="display:inline">
			
			<table class="search" id="mainTable"> 
       		<tr><td class="bg">									

			<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('t1sheet1');</script>
						</td>
					</tr>
				</table>			
			<!-- Grid (E) -->	
			
			
			<!--  Button_Sub (S) -->
				<table width="100%" class="button"> 
					<tr><td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<!-- 20090728 삭제 <td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn2_left"></td>
												<td class="btn2" name="btn_fListFixDisplayList">FList fix << Display List</td>
												<td class="btn2_right"></td>
										</tr>
									</table>
								</td>-->
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn2_left"></td>
												<td class="btn2" name="btn_rowInsertCoincidence">Insert Row</td>
												<td class="btn2_right"></td>
										</tr>
									</table>
								</td>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn2_left"></td>
												<td class="btn2" name="btn_rowDeleteCoincidence">Delete Row</td>
												<td class="btn2_right"></td>
										</tr>
									</table>
								</td>		
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn2_left"></td>
												 <td class="btn2" name="btn_DownExcel1">Down Excel</td>
												<td class="btn2_right"></td>
										</tr>
									</table>
								</td>						
							</tr>
						</table>
					</td></tr>
				</table>
	    	<!-- Button_Sub (E) -->
	
	</td></tr>
		</table>
		
</div>
<!--TAB  (E) --> 		
		
		
		
<!--TAB  (S) -->
<div id="tabLayer" style="display:none">
			<table class="search" id="mainTable"> 
       		<tr><td class="bg">									

			<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('t2sheet1');</script>
						</td>
					</tr>
				</table>			
			<!-- Grid (E) -->	
			<!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0">
						<tr>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						   <tr>
						      <td class="btn2_left"></td>
						      <td class="btn2" name="btn_coincidenceDiscrepancy">Coincidence<< Discrepancy  </td>
						      <td class="btn2_right"></td>
						   </tr>
						</table>						
						</td>	
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						   <tr>
						      <td class="btn2_left"></td>
						      <td class="btn2" name="btn_DownExcel2">Down Excel</td>
						      <td class="btn2_right"></td>
						   </tr>
						</table>						
						</td>						
					</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
	
	</td></tr>
		</table>
</div>
<!--TAB  (E) --> 



<!--TAB  (S) -->
<div id="tabLayer" style="display:none">
			<table class="search" id="mainTable"> 
       		<tr><td class="bg">									

			<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('t3sheet1');</script>
						</td>
					</tr>
				</table>			
			<!-- Grid (E) -->	
			<!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0"><tr>
						
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_coincidenceSML">Coincidence<< SML only  </td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						   <tr>
						      <td class="btn2_left"></td>
						      <td class="btn2" name="btn_DownExcel3">Down Excel</td>
						      <td class="btn2_right"></td>
						   </tr>
						</table>						
						</td>	
					</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
	
	</td></tr>
		</table>
</div>
<!--TAB  (E) --> 




<!--TAB  (S) -->
<div id="tabLayer" style="display:none">
			<table class="search" id="mainTable"> 
       		<tr><td class="bg">									

			<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('t4sheet1');</script>
						</td>
					</tr>
				</table>			
			<!-- Grid (E) -->	
			<!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0"><tr>
						
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_coincidenceLessor">Coincidence<< Lessor Only   </td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						   <tr>
						      <td class="btn2_left"></td>
						      <td class="btn2" name="btn_DownExcel4">Down Excel</td>
						      <td class="btn2_right"></td>
						   </tr>
						</table>						
						</td>	
					</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
	
	</td></tr>
		</table>
</div>
<!--TAB  (E) --> 		
	<!-- \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\  -->	
<!--TAB  (S) -->
<div id="tabLayer" style="display:none">
			<table class="search" id="mainTable"> 
       		<tr><td class="bg">									

			<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject1('t5sheet1');</script>
						</td>
					</tr>
				</table>			
			<!-- Grid (E) -->	
	</td></tr>
		</table>
</div>
<!--TAB  (E) --> 			
		</td></tr>
</table>
	<!--biz page (E)-->
	<table class="height_10"><tr><td></td></tr></table>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>