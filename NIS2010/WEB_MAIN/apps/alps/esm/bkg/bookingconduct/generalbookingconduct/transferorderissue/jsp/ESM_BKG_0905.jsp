<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0905.jsp
*@FileTitle : TRO-Actual Customer
*Open Issues : ESM_BKG_0079_02A/B 화면의, Actual Customer 항목에서 팝업됨
*Change history :
*@LastModifyDate : 2009.04.30
*@LastModifier : 이남경
*@LastVersion : 1.0
* 2009.04.30 이남경
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.event.EsmBkg0905Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0905Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
/* 	
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
*/	
	Logger log = Logger.getLogger("com.hanjin.apps.GeneralBookingConduct.TransferOrderIssue");
	
	try {
/* 		
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
*/

		event = (EsmBkg0905Event)request.getAttribute("Event");
		
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>TRO-Actual Customer</title>
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
<!-- 개발자 작업	-->
<input type="hidden" name="tro_act_cust_knd_cd">
<input type="hidden" name="conti_cd">
<input type="hidden" name="cnt_cd">
<input type="hidden" name="bkg_no">
<input type="hidden" name="act_shpr_cnt_cd">
<input type="hidden" name="act_shpr_seq">
<input type="hidden" name="act_shpr_nm">


<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;TRO Actual Customer</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- Tab ) (S) -->
   		<table class="tab" border="0" cellpadding="0" cellspacing="0" style="width:998;" > 
     		<tr><td width="100%">
					<script language="javascript">ComTabObject('tab1')</script>
				</td></tr>
		</table>
		<!-- Tab ) (E) -->
				
		
<!--TAB E/Q Creation (S) -->
<div id="tabLayer" style="display:inline">

    <!--biz page (S)--> 
   	<table class="search"  style="width:998">
    	<tr><td class="bg">

				<!--  biz_1 (S) -->
				<table class="grid2" border="0" style="width:490;"> 
					<tr class="h23">
						<td width="70" class="tr2_head">Customer</td>
						<td width="33" class="input1"><input type="text" name="cust_cnt_cd"     caption="Country Code"  class="noinput1" style="width:100%;" value="" fullfill style="ime-mode:disabled" maxlength="2"></td>
						<td width="83" class="input"> <input type="text" name="cust_seq"        caption="Customer Code" class="noinput"  style="width:100%;" value="" maxlength="6" dataformat="intchar"></td>
						<td width="" class="input">   <input type="text" name="cust_lgl_eng_nm" caption="Customer Name" class="noinput"  style="width:100%;" value=""></td>
					</tr>
				</table>
				<!--  biz_1   (E) -->	
				<table class="height_5"><tr><td></td></tr></table>
				
				<!-- Grid  (S) -->
				<table width="490"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('t1sheet1');</script>
						</td>
					</tr>
				</table>
				<!-- Grid  (E) -->				
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
								
						
				<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('t1sheet2');</script>
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
									<tr><td class="btn2_left"></td>
										<td class="btn2" name="btn_RowAdd">Row Add</td>
										<td class="btn2_right"></td>
									</tr>
									</table>
								</td>
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn2_left"></td>
										<td class="btn2" name="btn_RowDelete">Row Delete</td>
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
		<!--biz page (E)--> 		
</div>
<!--TAB E/Q Creation (E) -->
		
		
		
<!--TAB Customer Creation (S) -->
<div id="tabLayer" style="display:none">

	<!--biz page (S)-->
   <table class="search" id="mainTable"> 
   <tr><td class="bg">	

				<!--  biz_1 (S) -->
				<table class="grid2" border="0" style="width:650;"> 
					<tr class="h23">
					    <td width="90" class="tr2_head">Door Location</td>
						<td width="50" class="input2"><input type="text" name="dor_loc_cd"     maxlength="5" class="noinput2" style="width:50" value="" readonly></td>
						<td width="60" class="tr2_head">EQ Office</td>
						<td width="60" class="input1"><input type="text" name="ofc_cd"         caption="EQ Office" maxlength="5" class="noinput1" style="width:60" dataformat="engup" value=""></td>
						<td width="100" class="tr2_head">Customer Name</td>
						<td width="240" class="input1"><input type="text" name="tro_act_rep_nm" caption="Customer Name" class="noinput1" style="width:240;" value=""></td>
					</tr>
				</table>
				<!--  biz_1   (E) -->	
				<table class="height_5"><tr><td></td></tr></table>

				<!-- Grid  (S) -->
				<table width="650"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('t2sheet1');</script>
						</td>
					</tr>
				</table>
				<!-- Grid  (E) -->
						
				<!--  Button_Sub (S) -->
				<table width="650" class="button"> 
  					<tr><td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
							<tr>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td>
									<td class="btn2" name="btn_t2RowAdd1">Row Add</td>
									<td class="btn2_right"></td>
								</tr>
								</table>
						    </td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td>
									<td class="btn2" name="btn_t2RowDelete1">Row Delete</td>
									<td class="btn2_right"></td>
								</tr>
								</table>
							</td>						
							</tr>
						</table>
				</td></tr></table>
				
				<!-- Button_Sub (E) -->
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>						
						
				<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('t2sheet2');</script>
						</td>
					</tr>
				</table>
				<!-- Grid (E) -->			
				
				<!--  Button_Sub (S) -->
				<table width="100%" class="button"> 
					<tr><td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn2_left"></td>
										<td class="btn2" name="btn_t2RowAdd2">Row Add</td>
										<td class="btn2_right"></td>
									</tr>
									</table></td>
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn2_left"></td>
										<td class="btn2" name="btn_t2RowDelete2">Row Delete</td>
										<td class="btn2_right"></td>
									</tr>
									</table></td>				
							</tr>
						</table>
					</td></tr>
				</table>
				<!-- Button_Sub (E) -->	

			</td></tr>
		</table>
		<!--biz page (E)--> 	
</div>
<!--TAB Customer Creation (E) -->



				<table class="height_5"><tr><td></td></tr></table>
		</td></tr>
		</table>				
				<!-- : ( Button : pop ) (S) -->
				<table width="100%" class="sbutton">
				<tr><td height="40" class="popup">
				
				    	<!--Button (S) -->	
						<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
				       	<tr><td class="btn3_bg">
						    <table border="0" cellpadding="0" cellspacing="0">
						    	<tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn1_left"></td>
									<td class="btn1" name="btn_Retrieve">Retrieve</td>
									<td class="btn1_right"></td>
									</tr></table></td>
						    		<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn1_left"></td>
									<td class="btn1" name="btn_Save">Save</td>
									<td class="btn1_right">
									</tr></table></td>
						   			<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn1_left"></td>
									<td class="btn1" name="btn_Select">Select</td>
									<td class="btn1_right"></td>
									</tr>
									</table></td>
									<td class="btn1_line"></td>		
									<td>
							   			<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_Close">Close</td>
											<td class="btn1_right"></td>
										</tr>
										</table>
									</td>								
								</tr>
							</table>
						</td></tr>
						</table>	
				    	<!--Button (E) -->
					
					</td></tr>
				</table>
				<!-- : ( Button : pop ) (E) -->		


<!-- Grid  (S) -->
<table width="100%"  id="mainTable"> 
	<tr>
		<td width="100%">
			<script language="javascript">ComSheetObject('h1sheet1');</script>
		</td>
	</tr>
	<tr>
		<td width="100%">
			<script language="javascript">ComSheetObject('h1sheet2');</script><!-- 마지막grid 이어야함 -->
		</td>
	</tr>	
</table>
<!-- Grid (E) -->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>

<SCRIPT LANGUAGE="javascript">
<!--
      /* 
        ibSheet 를 제외한 폼 입력값(?) 유저가 입력한 정보를 event를 통해서 다시 넘겨받아 화면에 뿌려주는 부분입니다. 
      */
      with(document.form)
      {
        <%
        if(event != null){         	
        	String contiCd      = event.getContiCd();
            String cntCd        = event.getCntCd();
            String bkgNo        = event.getBkgNo();
            String dorLocCd     = event.getDorLocCd();
            String actShprCntCd = event.getActShprCntCd();
            String actShprSeq   = event.getActShprSeq();
            String actShprNm    = event.getActShprNm();
        %>    
	        eval("conti_cd").value        = "<%=contiCd%>";
	        eval("cnt_cd").value          = "<%=cntCd%>";
            eval("bkg_no").value          = "<%=bkgNo%>";
            eval("dor_loc_cd").value      = "<%=dorLocCd%>";
            eval("act_shpr_cnt_cd").value = "<%=actShprCntCd%>";
            eval("act_shpr_seq").value    = "<%=actShprSeq%>";
            eval("act_shpr_nm").value     = "<%=actShprNm%>";
        <% } %>
       }
-->
</SCRIPT>
<%@include file="/bizcommon/include/common_alps.jsp"%>
