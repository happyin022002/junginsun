<%--=========================================================
*Copyright(c) 2018 SMLine
*@FileName : BCM_CCD_0053.jsp
*@FileTitle : MDM Vendor Request List
*Open Issues :
*Change history :
*@LastModifyDate : 2018-02-22
*@LastModifier : HA DAE SUNG 
*@LastVersion : 1.0
* 2018-02-22 HA DAE SUNG
* 1.0 최초 생성
=========================================================--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.core.controller.util.WebKeys"%>
<%@ page import="com.hanjin.framework.core.view.template.Screen"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.bcm.ccd.commoncode.partner.event.BcmCcd0053Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.core.view.template.Screen" %>
<%@ page import="com.hanjin.framework.core.controller.util.WebKeys" %>
<%
    BcmCcd0053Event  event = null;                //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;            //서버에서 발생한 에러
    String strErrMsg = "";                                 //에러메세지
    int rowCount     = 0;                                  //DB ResultSet 리스트의 건수
    
	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	String screenName		= "";
	
	String isApprove		= "N";
	
	Logger log = Logger.getLogger("com.hanjin.apps.custmanage.custrequest");
    String main_page = "";
    try {
    	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
		
		event = (BcmCcd0053Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		
		Screen screen = (Screen)request.getAttribute(WebKeys.CURRENT_SCREEN);
		if (screen.getName().indexOf("P") >= 0) {
			isApprove = "Y";
		} else {
			isApprove = "N";
		}
		
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		log.debug("====================================");
		screenName = screen.getName();
		log.debug("====================================");
    	

    }catch(Exception e) {
        out.println(e.toString());
    }
%>
<html>
<head>
<title>MDM Vendor Request List</title>
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
<!-- 
showErrMessage를 써주지 않으면 에러 발생시 처리가 불가합니다.
그리고 지금은 showErrMessage()으로 되어있지만 추후에 고객님이 변덕을 일으켜서 웹페이지를 호출하라고 할경우를 
대비해서 직접 showErrMessage() 하지 마시고 꼭 showErrMessage를 써주십시오. 한방에 바꾸게요. 표준을 안따르면 나중에 후회합니다.  
-->



<body onload="javascript:setupPage();">
<form name="form" onkeyup="ComKeyEnter('lengthnextfocus');">
<input type="hidden" name="f_cmd">
<input type="hidden" name="isApprove" value="<%=isApprove%>">

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
	
		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!--Page Title, Historical (E)-->
		
		<!-- TABLE '#D' : ( Search Options : Scenario ID ) (S) -->
		<table class="search">
			<tr>
				<td class="bg">
				<!-- : ( Scenario ID ) (S) -->
				<table class="search" border="0" style="width:500;">
					<tr class="h23">					
						<td width="90">Create Date</td>
									<td width="" >
								    	<input type="text" style="width:80" value="" class="input"  name="rqst_fm_dt"  maxlength='10' dataformat="ymd" >
												 &nbsp;~&nbsp;
												  <input type="text" style="width:80" value="" class="input"  name="rqst_to_dt"  maxlength='10' dataformat="ymd" >
												  <img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="rqst_date">
									</td>
					</tr>
				</table>
				<table class="search" border="0" style="width:900;">
				<tr class="h23">
					<td width="90">Request No</td>
					<td width="140"><input type="text" name="rqst_no" dataformat="uppernum" maxlength="8" tabindex=1 style="width:100;text-align: center;ime-mode:disabled">&nbsp;</td>
					<td width="90">Vendor Name</td>
					<td width="230"><input type="text" name="vndr_nm" dataformat="uppernum" maxlength="50" tabindex=2 size="60" style="width:200;ime-mode:disabled"></td>
					<td width="90">Control Office</td>
					<td width="120"><input type="text" name="ofc_cd" maxlength="6" dataformat="engup" style="width:60" style="">
					<img src="img/btns_search.gif" name="btn_com_ens_071" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
					<td width="50">Status</td>
					<td>
					<select name="delt_flg" style="width:90px;">
<%if(isApprove.equals("Y")) {%>
						<option value="ALL">ALL</option>
						<option value="N">Saved</option>
						<option value="P" selected>Requested</option>
						<option value="A">Approved</option>
						<option value="R">Rejected</option>
<%} else {%>
						<option value="ALL" selected>ALL</option>
						<option value="N">Saved</option>
						<option value="P">Requested</option>
						<option value="A">Approved</option>
						<option value="R">Rejected</option>
<%} %>					
					</select>
				</tr>
				</table>
				<!-- : ( Scenario ID ) (E) -->
		<!-- TABLE '#D' : ( Search Options : Scenario ID ) (E) -->

			<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>

			<!-- : ( Grid ) (S) -->
			<!-- 'HEAD1-BGCOLOR : 203 240 169' , 'HEAD2-BGCOLOR : 222 251 248' , 'BORDER 1-outside : 88 152 164' ,
				 'BORDER 2-inside : 202 226 233' , 'HEAD-FONT : 39 95 101' , 'SELETED ROW BG : 252 255 233' -->

					<table width="100%" id="mainTable">
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet1');</script>
                        </td></tr>
		            </table>
		            
		            <table width="100%" class="button"> 
		       		<tr><td class="btn2_bg">
					<table border="0" cellpadding="0" cellspacing="0"><TR>
							<td width="100"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn2_Down_Excel">Down Excel</td>
							<td class="btn2_right"></td>
							</tr>
							</table></td></TR>
					</table>
					</td></tr>
				</table>

			<!-- : ( Grid ) (E) -->

				</td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Tab BG Box ) (E) -->

<table class="height_5"><tr><td></td></tr></table>


<!-- OUTER - POPUP (E)nd -->
</td></tr></table>

   	    <table class="search" id="rjct_area" border="0" style="width:900px"> 
			<tr class="h23" >
				<td width="60"></td>
				<td width="200">Reject Reason Comment</td>
				<td width="400">
					<input id="rjct_rsn_rmk" style="width: 380px; text-align: left; ime-mode:disabled;" class="input" name="rjct_rsn_rmk" maxlength="1000" dataformat="uppernum" type="text" >
					</td>
				<td width="160">Reject Reason Code</td>
				<td width="135">
			    			<select id="rjct_rsn_cd" class="input" style="width:100;" name="rjct_rsn_cd" >
		                    	<option value="" selected></option>
		                      	<option value="D">Duplicated</option>
		                      	<option value="R">Reject</option>
		                    </select>
		        </td>
		        <td width="100"><div style="display:none;width:450;color:red;" id="user_mdm_auth"></div></td>
			</tr> 
			
		</table>	

<!--Button (S) -->
		<table width="100%" class="button"  border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       		<tr>
       			<td class="btn1_bg">
		    		<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td>
								<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       								<tr>
       									<td class="btn2_bg">
		    								<table border="0" cellpadding="0" cellspacing="0">
					    						<tr>
		    										<td>
														<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
															<tr><td class="btn1_left"></td>
																<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
																<td class="btn1_right"></td>
															</tr>
														</table>
													</td>
													<td>
														<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
															<tr><td class="btn1_left"></td>
																<td class="btn1" name="btn_New">New</td>
																<td class="btn1_right"></td>
															</tr>
														</table>
													</td>
													<td>
														<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
															<tr id="btn_Approve1" name="btn_Approve1"><td class="btn1_left"></td>
																<td class="btn1" name="btn_Approve">Approve</td>
																<td class="btn1_right"></td>
															</tr>
														</table>
													</td>
													<td>
														<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
															<tr id="btn_Reject1" name="btn_Reject1"><td class="btn1_left"></td>
																<td class="btn1" name="btn_Reject">Reject</td>
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
				</td>
			</tr>
		</table>
<!-- : ( Button : Sub ) (E) -->


</form>
</body>
</html>

  <%@include file="/bizcommon/include/common_alps.jsp"%>