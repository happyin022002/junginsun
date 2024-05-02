<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_lse_0029.jsp
*@FileTitle : On Hire Approval creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.09
*@LastModifier : 진준성
*@LastVersion : 1.0
* 2009.06.09 진준성
* 1.0 Creation
* **************************************************
* 2013.08.13 채창호 [CHM-201325598]Split 02-EQR T/F 관련 LEGACY 연계 방안 및 일정
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.lse.containerleasemgt.onhireapproval.event.EesLse0029Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesLse0029Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.ContainerLeaseMgt.OnhireApproval");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EesLse0029Event)request.getAttribute("Event");
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
<title>On Hire Approval creation</title>
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
<input type="hidden" name="term">
<input type="hidden" name="titlelist">
<input type="hidden" name="totalqty1">
<input type="hidden" name="ord_yr">
<!-- 개발자 작업	-->
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
		    <tr>
		         <td><table width="90" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn1_reqList">Req List</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
		       <td><table width="120" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn1_liftOnCharge">Lift On Charge</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="New">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="Save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
		</tr>
		</table></td>
		</tr>
		</table>
    <!--Button (E) -->
	<table class="search" > 
       		<tr><td class="bg" style="height:516" valign="top">
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;" > 
				<tr class="h23">
					<td width="33">&nbsp;LCC</td>
					<td width="170"><input type="text" name="loc_cd" style="width:50;ime-mode:disabled"  value="" class="input1" dataformat="engup" maxlength="5" fullfill><input type="hidden" name="loc_tp" value="LCC" class="trans">&nbsp;<img class="cursor" src="img/btns_search.gif" name="btns_search1" width="19" height="20" border="0" align="absmiddle"></td>
					<td width="77">Lease Term</td>
					<td width="120">&nbsp;<script language="javascript" >ComComboObject('combo1', 1, 50, 1 ,1);</script></td>
					<td width="116">Pick Up Due Date</td>
					<td width="170"><input type="text" name="pkup_due_dt" style="width:80" value="" class="input1"  maxlength="8" dataformat="ymd" !cofield="exp_dt">&nbsp;<img class="cursor" src="img/btns_calendar.gif" name="btns_calendar1" width="19" height="20" border="0" align="absmiddle"></td>
					<td width="57">Auth No.</td>
					<td width=""><input type="text" style="width:160" name="cntr_onh_auth_no" value="" class="input2" readonly><input type="hidden" name="agmt_cty_cd" value="" ><input type="hidden" name="agmt_seq" value="" ></td>
				</tr> 
				</table>
				<!--  biz_1  (E) -->				
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
				<table class="height_8"><tr><td></td></tr></table>
                <table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">Term & Condition</td></tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="44">TP/SZ</td>
					<td width="355">&nbsp;<script language="javascript" >ComComboObject('combo2', 1, 98, 1 ,1);</script>&nbsp;<input type="text" name="tpsz_cd" style="width:182" value="" class="input" readonly></td>
					<td width="50">Req No.</td>
					<td width="100"><input type="text" style="width:150" name="reqno" value="" class="input2" readonly></td>
					<td width="50"></td>
					<td width=""><input type="text" style="width:250" name="totalqty" value="" class="input2" readonly></td>
				</tr> 
				</table>
				<!-- Tab Detail (S) -->
 				 <div id="tabLayer" style="display:none"> 				              
 				          <!-- Grid  (S) -->
  				          <table width="100%" class="search" id="mainTable" > 
  				           <tr>
  				            <td width="100%">
  				            <script language="javascript">ComSheetObject1('sheet1');</script>
  				            </td>
  				           </tr>
  				          </table>    
  				        <!-- Grid (E) -->
  				        <!--  Grid_button (S) -->  				  
 				<!-- Tab BG Box  (S) -->
 				 </div>
  				<!-- Tab Detail (E) -->							
				
		
<!-- : ( Search Options ) (E) -->
 <!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0"><tr>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="Row_Add">Row Add</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="Delete">Row Delete</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td></tr>			
				</table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
	    	<table class="height_8"><tr><td></td></tr></table>				
				<table class="grid2" border="0" style="width:100%;"> 
				<tr>
					<td class="tr2_head" width="95">Remark(s)</td>
					<td><textarea style="width:100%;height:80;" name="apro_rmk" ></textarea></td>	
				</tr> 
				</table>
			</td></tr>
		</table>
	<!-- Tab BG Box  (S) -->
	<!--biz page (E)-->
	
	</td></tr>
</table>
	</td></tr>
</table>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>