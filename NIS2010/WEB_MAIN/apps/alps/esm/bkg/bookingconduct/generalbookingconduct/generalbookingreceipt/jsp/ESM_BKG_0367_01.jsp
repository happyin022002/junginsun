<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0367_01.jsp
*@FileTitle : esm_bkg_0367_01
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.01
*@LastModifier : 최 선
*@LastVersion : 1.1
* 2009.06.09 이진서
* 1.0 Creation
*----------------------------------------------------------
* History
* 2010.12.01 최 선     1.1 [CHM-201007417] PO & Other No (General) Incoterms Column Add, Validation 
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.event.EsmBkg036701Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg036701Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.GeneralBookingConduct.GeneralBookingReceipt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg036701Event)request.getAttribute("Event");
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
<title>P/O & Other No.</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
 .r{color:#cf0fff;font-weight:bold}
 .c{color:black;font-weight:normal}
</style>
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

<body class="popup_bg" onLoad="setupPage();">
<div id=divDebug style="font:9pt " style="display:none;">&nbsp;</div>
<form name="form" onKeyUp="ComKeyEnter('LengthNextFocus')">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="bkg_no" value='<%=JSPUtil.getParameter(request, "bkg_no")%>'>
<input type="hidden" name="ca_flg" value='<%=JSPUtil.getParameter(request, "ca_flg")%>'>
<input type="hidden" name="popuptpcd" value='<%=JSPUtil.getParameter(request, "popUpTpCd")%>'>
<input type="hidden" name="xter_sndr_id" value='<%=JSPUtil.getParameter(request, "xter_sndr_id")%>'>
<input type="hidden" name="xter_rqst_no" value='<%=JSPUtil.getParameter(request, "xter_rqst_no")%>'>
<input type="hidden" name="xter_rqst_seq" value='<%=JSPUtil.getParameter(request, "xter_rqst_seq")%>'>
<input type="hidden" name="callback_func" value='<%=JSPUtil.getParameter(request, "func")%>'>
<input type="hidden" name="cntr_no" value=''>
<!-- 개발자 작업	-->

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;  P/O & Other No.


</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- : ( Search Options ) (S) -->
		<!--biz page (S)-->
		
	<!--  biz page    (E) -->

			<table class="search"> 
       		<tr><td class="bg">
				<!--biz page (S)-->
				
			
				<table class="search" border="0">
				<tr class="h23">
					<td width="">Booking No.</td>	
					<td width="" colspan="2"><input type="text" style="width:100;" class="input2" name="vbkg_no" value="" readonly></td>						
					<td width="">B/L No.</td>	
					<td width="" colspan="3"><input type="text" style="width:100;" class="input2" name="vbl_no" value="" readonly></td>						
				
				</tr>
				<tr class="h23">
					<td width="100">P/O No.</td>	
					<td width="90"><input type="text" style="width:100;" class="input" name="bkpo" maxlength="10" value=""></td>		
					<td class="stm" width="150"><input type="checkbox" value="" name='check_bkpo' class="trans" onClick="javascript:copyToDesc(this);">&nbsp;Copy to Description </td>						
					<td width="100">L/C No.</td>	
					<td width="90"><input type="text" style="width:100;" class="input" name="lcno" maxlength="50" value=""></td>	
					<td width=""></td>		
					<td class="stm"><input type="checkbox" value="" name='check_lcno' class="trans" onClick="javascript:copyToDesc(this);">&nbsp;Copy to Description </td>						
				
				</tr>
				<tr class="h23">
					<td width="">Invoice No.</td>	
					<td width=""><input type="text" style="width:100;" class="input" name="hinv" maxlength="50" value=""></td>		
					<td class="stm"><input type="checkbox" value="" name='check_hinv' class="trans" onClick="javascript:copyToDesc(this);">&nbsp;Copy to Description </td>						
					<td width="">L/C Date</td>	
					<td width=""><input type="text" style="width:100;" class="input" name="lcdt" value="" maxlength="10" dataformat="ymd" style="ime-mode:disabled" caption="L/C Date"  ></td>
					<td width="">&nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" name="btn_Calendar"></td>		
					<td class="stm"><input type="checkbox" value="" name='check_lcdt' class="trans" onClick="javascript:copyToDesc(this);">&nbsp;Copy to Description </td>						
				
				</tr>
				<tr class="h23">
					<td width="">Department No.</td>	
					<td width=""><input type="text" style="width:100;" class="input" name="hpdp" maxlength="50" value=""></td>		
					<td class="stm"><input type="checkbox" value="" name='check_hpdp' class="trans" onClick="javascript:copyToDesc(this);">&nbsp;Copy to Description </td>						
					<td width="">Other Ref. No.</td>	
					<td width=""><input type="text" style="width:100;" class="input" name="othr" maxlength="50" value=""></td>		
					<td width=""></td>	
					<td class="stm"><input type="checkbox" value="" name='check_othr' class="trans" onClick="javascript:copyToDesc(this);">&nbsp;Copy to Description </td>						
				
				</tr> 
				<tr class="h23">
					<td width="">Incoterms</td>	
					<td width=""><input type="text" style="width:100;" class="input" name="inco" maxlength="50" value=""></td>		
					<td class="stm"><input type="checkbox" value="" name='check_inco' class="trans" onClick="javascript:copyToDesc(this);">&nbsp;Copy to Description </td>						
					<td width=""></td>	
					<td width=""></td>		
					<td width=""></td>	
					<td class="stm"></td>						
				
				</tr> 
				</table>
				<!--biz page (S)-->
				
			</td></tr>
			</table> 
	<table class="height_8"><tr><td></td></tr></table>		
		<!-- Tab (S) -->
     	<table class="tab" border="0" cellpadding="0" cellspacing="0" width="100%">
			<tr>
				<td width="100%">
					<script language="javascript">ComTabObject('tab1')</script>
				</td>
			</tr>
		</table>
		<!-- Tab (E) -->

<div id="tabLayer" style="display:inline">
	<table class="search"> 
       	<tr><td class="bg">
       	
       	<table class="search" border="0">
		<tr class="h23">
		<td width="220" valign="top">
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
       		<td width="10"></td>
       		<td width="" valign="top">
       		<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet2');</script>
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
						<td class="btn2" name="btn1_Row_Add">Row&nbsp;Add</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn1_Row_Delete">Row Delete</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn2_Copy_from">Copy from C/M</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
					</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
	    	<table class="height_8"><tr><td></td></tr></table>	
			<table class="search" border="0">
				<tr class="h23">
					<td width="130"></td>	
					<td width="">Total</td>	
					<td width="">
						<input type="text" style="width:90;text-align:right" class="input2"  name="t_pck_qty" value="" readonly >&nbsp;
						<input type="text" style="width:90;text-align:right" class="input2" name="t_cntr_mf_wgt" value="" readonly>&nbsp;
						<input type="text" style="width:90;text-align:right" class="input2" name="t_meas_qty" value="" readonly>
					</td>						
				</tr>   	
				<tr class="h23">
					<td width="130"></td>	
					<td width="">Container Total</td>	
					<td width="">
						<input type="text" style="width:90;text-align:right" class="input2"  name="pck_qty" value="" readonly >&nbsp;
						<input type="text" style="width:90;text-align:right" class="input2" name="cntr_mf_wgt" value="" readonly>&nbsp;
						<input type="text" style="width:90;text-align:right" class="input2" name="meas_qty" value="" readonly>
					</td>						
				</tr>
			</table>
<!-- : ( Search Options ) (E) -->
	</td></tr>
</table>
	</td></tr>
</table>
</div>

<!-- Tab2 (S) -->
<div id="tabLayer" style="display:none">
	<table class="search"> 
       	<tr><td class="bg">
       	
       	<table class="search" border="0">
		<tr class="h23">
		<td width="100%" valign="top">
		<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet3');</script>
						</td>
					</tr>
				</table>			
			<!-- Grid (E) -->
		</td></tr>
	</table>
<!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0"><tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn2_Row_Add">Row&nbsp;Add</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn2_Row_Delete">Row Delete</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn2_Copy_Desc">Copy&nbsp;to&nbsp;Description</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
					</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
	    	

		</td></tr>
</table>
			</td>
		</tr>
</table>

</div>
<!-- Tab2 (E) -->




<!-- Tab3 (S) -->
<div id="tabLayer" style="display:none">
	<table class="search"> 
       	<tr><td class="bg">
       	
       	<table class="search" border="0">
		<tr class="h23">
		<td width="100%" valign="top">
		<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet4');</script>
						</td>
					</tr>
				</table>			
			<!-- Grid (E) -->
		</td></tr>
	</table>

			</td>
		</tr>
</table>

</div>
<!-- Tab3 (E) -->



<table class="height_5"><tr><td></td></tr></table>	
</td></tr>
</table>	

<!-- Mandatory (S)   class="height_5" width="100%" border="0">-->
<div id="manItmLayer" style="display:none">
	<table width="100%" class="popup" border="0">
		<tr class="h23">
		    <td width="6"></td>
			<td class="bg">
				<input type="text" style="width:100%;background-color:yellow;font-weight:bold;" class="input2" name="vManItm" value="" readonly>
			</td>
			<td width="6"></td>
		</tr>
	</table>
</div>
<!-- Mandatory (E) -->
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Save">Save</td>
					<td class="btn1_right"></td>
				</tr></table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Close">Close</td>
					<td class="btn1_right"></td>
				</tr></table></td>
				
			</tr>
		</table></td>
				
			</tr>
		</table>
    <!--Button (E) -->
	
	</td></tr>
</table>

<!-- : ( Button : pop ) (E) -->
	<div id="Layer1" style="display:none;">
	<script language="javascript">ComSheetObject('sheet5');</script>
	</div>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>