<%
/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ESM_FMS_0090.jsp
*@FileTitle : Off-Hire Expenses
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.13
*@LastModifier : 차상영
*@LastVersion : 1.0
* 2014.11.01 차상영
* 1.0 Creation
* History 
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.event.EsmFms0090Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmFms0090Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";	// Office Code 삭제시 Delete 버튼 활성화 여부 확인.

	Logger log = Logger.getLogger("com.hanjin.apps.TimeCharterInOutAccounting.TCharterIOInvoice");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();

		event = (EsmFms0090Event)request.getAttribute("Event");
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
<title>Off-Hire Expenses</title>
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
<!-- 기본 필수 hidden -->
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="vnor_itm_proc_cd" value="C">
<input type="hidden" name="vnor_offh_ind" value="">
<!-- 업무용 hidden -->


<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;padding-right:5;">
	<tr><td valign="top">
	
	<!-- Title, Navigation 고정 -->
	<!--Page Title, Historical (S)-->
	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
	</table>
	<!--Page Title, Historical (E)-->
		
	<!-- 메인 화면 : biz page (S)-->

			<table class="height_8"><tr><td colspan="8"></td></tr></table>	

		<!-- Tab ) (S) -->
     		<table class="tab" border="0" cellpadding="0" cellspacing="0" width=100%> 
       			<tr><td width="100%">
						<script language="javascript">ComTabObject('tab1')</script>
					</td>
				</tr>
			</table>
		<!-- Tab ) (E) --> 

<!--TAB CNFM (S) -->
<div id="tabLayer" style="display:inline">
		
		<table class="search"> 
       	<tr><td class="bg">
       	       	
					<!-- Grid  (S) -->
					<table width="100%" id="mainTable"> 
						<tr>
							<td>
								<table width="100%"  id="mainTable2">
									<tr>
										<td width="100%" id="sheet1" >
											<script language="javascript">ComSheetObject('t1sheet1');</script>
										</td>
									</tr>
								</table>																																															
							</td>
						</tr>
					</table> 
					<!-- Grid (E) -->
				
				
					<!--  Button_Sub (S) -->
					<table width="100%" class="button"> 
	       			<tr><td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_Detail1">Detail</td>
							<td class="btn2_right"></td></tr>
							</table></td>
							
							<td><table  width="170" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_ToNonConfirm1">Move to Non Confirm</td>
							<td class="btn2_right"></td></tr>
							</table></td>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_RowAdd">Row Add</td>
							<td class="btn2_right"></td></tr>
							</table></td>
							
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_Delete">Row Delete</td>
							<td class="btn2_right"></td></tr>
							</table></td>
							
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_Save">Save</td>
							<td class="btn2_right"></td></tr>
							</table></td>
														
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_ExcelDown1">Excel Down</td>
							<td class="btn2_right"></td></tr>
							</table></td>

														
					</tr></table>
					</td></tr>
					</table>
					<!-- Button_Sub (E) -->
		
				
			</td></tr>
		</table>	
	<!--biz page (E)-->
	
</div>
<!--TAB CNFM (E) -->


<!--TAB Non Off-Hire (S) -->
<div id="tabLayer" style="display:none">
		
		<table class="search"> 
       	<tr><td class="bg">
       	    	
					<!-- Grid  (S) -->
					<table width="100%" id="mainTable"> 
						<tr>
							<td>
								<table width="100%"  id="mainTable2">
									<tr>
										<td width="100%" id="sheet1" >
											<script language="javascript">ComSheetObject('t2sheet1');</script>
										</td>
									</tr>
								</table>																
							</td>
						</tr>
					</table> 
					<!-- Grid (E) -->
				
					<!--  Button_Sub (S) -->
					<table width="100%" class="button"> 
	       			<tr><td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_Cnfm">Move to CNFM</td>
							<td class="btn2_right"></td></tr>
							</table></td>
							
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_Complete">Compulsory Complete</td>
							<td class="btn2_right"></td></tr>
							</table></td>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_ExcelDown2">Excel Down</td>
							<td class="btn2_right"></td></tr>
							</table></td>

					</tr></table>
					</td></tr>
					</table>
					<!-- Button_Sub (E) -->				
				
			</td></tr>
		</table>					
	<!--biz page (E)-->
	
</div>
<!--TAB Non Off-Hire (E) -->


<!--TAB Completed (S) -->
<div id="tabLayer" style="display:none">
		
		<table class="search"> 
       	<tr><td class="bg">
       	    	
					<!-- 조회조건 -->       	    	
					<table width="100%" border="0">
					<tr>
					<td width="100%">
					<table class="search">
					<tr class="h23">
						<td width="65" align="center">Period</td>
						<td width="230" align="left">
							<input type="text" style="width:75;text-align:center;" class="input" name="vnor_offh_fm_dt" maxlength="8" dataformat="ymd">&nbsp;<img src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor" name="btn_OffhFmDt">&nbsp;~&nbsp;
							<input type="text" style="width:75;text-align:center;" class="input" name="vnor_offh_to_dt" maxlength="8" dataformat="ymd">&nbsp;<img src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor" name="btn_OffhToDt">&nbsp;																				
						</td>

						<td width="10"> </td>
						<td width="65" align="center">Vessel</td>
						<td width="280" align="left">
							<input type="text" name="vsl_cd" style="width:75;ime-mode:disabled" class="input" dataformat="engup" maxlength="8">
							<img src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor" name="btn_VslCd">
							<input type="text" style="width:162;" class="input2" name="vsl_eng_nm" readonly>
						</td>							
						
						<td width="10"> </td>
						<td width="75" align="center">IND</td>
						<td width="*" align="left">
							<script language="javascript">ComComboObject('dmdt_ctrt_expt_tp_cd', 1, 100 , 0, 0, 0, true)</script>								
						</td>	
																								
					</tr>
					</table>
					</td>
					</tr>
					</table>        	    	
       	    		<!-- 조회조건 -->
       	    	
					<!-- Grid  (S) -->
					<table width="100%" id="mainTable"> 
						<tr>
							<td>
								<table width="100%"  id="mainTable2">
									<tr>
										<td width="100%" id="sheet1" >
											<script language="javascript">ComSheetObject('t3sheet1');</script>
										</td>
									</tr>
								</table>																
							</td>
						</tr>
					</table> 
					<!-- Grid (E) -->
						
					<!--  Button_Sub (S) -->
					<table width="100%" class="button"> 
	       			<tr><td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_Detail3">Detail</td>
							<td class="btn2_right"></td></tr>
							</table></td>
							
							<td><table width="170" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_ToNonConfirm3">Move to Non Confirm</td>
							<td class="btn2_right"></td></tr>
							</table></td>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_ToConfirm">Move to Confirm</td>
							<td class="btn2_right"></td></tr>
							</table></td>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_Retrieve">Retrieve</td>
							<td class="btn2_right"></td></tr>
							</table></td>
							
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_New">New</td>
							<td class="btn2_right"></td></tr>
							</table></td>
														
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_Save3">Save</td>
							<td class="btn2_right"></td></tr>
							</table></td>
							
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_ExcelDown3">Excel Down</td>
							<td class="btn2_right"></td></tr>
							</table></td>														
					</tr></table>
					</td></tr>
					</table>
					<!-- Button_Sub (E) -->								
				
			</td></tr>
		</table>					
	<!--biz page (E)-->
	
</div>
<!--TAB Completed (E) -->
    
    
</td></tr>
</table>
 
</form>
			
</body>
</html>