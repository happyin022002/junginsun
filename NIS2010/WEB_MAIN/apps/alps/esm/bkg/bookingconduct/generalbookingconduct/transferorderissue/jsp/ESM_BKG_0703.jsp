<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0703.jsp
*@FileTitle : TRO-TRO-Cancel/Frustrate
*Open Issues : ESM_BKG_0079_02C 화면의 TRO-Cancel/Frusrate 팝업 
*Change history :
*@LastModifyDate : 2009.06.30
*@LastModifier : 이남경
*@LastVersion : 1.0
* 2009.06.30 이남경
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.event.EsmBkg0703Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0703Event  event = null;			    //PDTO(Data Transfer Object including Parameters)
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
	
		event = (EsmBkg0703Event)request.getAttribute("Event");		
	   
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
<title>TRO-Cancel/Frusrate</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		}
		loadPage();
	}
</script>
</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->
<input type="hidden" name="io_bnd_cd" value=""><!-- hidden -->


<!-- OUTER - POPUP (S)tart -->
<table width="700" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;TRO - Multi Cancel/Frustrate</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- : ( Search Options ) (S) -->
 			
			<table class="search"> 
       		<tr><td class="bg">
			<table class="search" border="0">
				<tr class="h23">
					<td width="80">Booking No.</td>
					<td width=""><input type="text" name="bkg_no" style="width:100;" class="input2" value="" readonly></td>
				</tr>
				</table>
				<table class="height_2"><tr><td></td></tr></table>	
				<!-- : ( Grid ) (S) -->
				<table width="100%"  id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
				<!-- : ( Grid ) (E) -->
	    	<!-- : ( Grid ) (E) -->	<!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0">
				    <tr>
				    	<td><table width="480" border="0" cellpadding="0" cellspacing="0">
				    	<tr><td>* TRO can be canceled, when S/O status is "No"</td></tr>
				    	<tr><td>* TRO can be frustrated, when W/O Status is "Fr"</td></tr>
				    	</table></td>				    	
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_CancelAll">Cancel All</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_FrustrateAll">Frustrate All</td>
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
<!-- : ( Search Options ) (E) -->
</td></tr>
</table> 

<table class="height_5"><tr><td></td></tr></table>

	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

    	<!--Button (S) -->	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	    <tr><td class="btn3_bg">
		            <table border="0" cellpadding="0" cellspacing="0">
		              <tr>
		                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					          <tr><td class="btn1_left"></td>
					             <td class="btn1" name="btn_ok">Ok</td>
					             <td class="btn1_right"></td>
				              </tr>
				            </table>
				        </td>	
			            <td class="btn1_line"></td>		
			            <td class="btn3_bg">
		                   <table border="0" cellpadding="0" cellspacing="0">
		                      <tr><td>
		                             <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					                    <tr><td class="btn1_left"></td>
					                        <td class="btn1" name="btn_close">Close</td>
					                        <td class="btn1_right"></td>
				                        </tr>
				                     </table>
				                  </td>	
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


<!-- 개발자 작업  끝 -->
</form>
</body>
</html>

<SCRIPT LANGUAGE="javascript">
<!--
      /* 
       * 유저가 입력한 정보를 event를 통해서 다시 넘겨받아 화면에 뿌려주는 부분
       */
      with(document.form)
      {
        <%
        if(event != null){ 
            String bkgNo   = event.getBkgNo();
            String ioBndCd = event.getIoBndCd();
        %>    
            eval("bkg_no").value    = "<%=bkgNo%>";
            eval("io_bnd_cd").value = "<%=ioBndCd%>";
        <% } %>
       }
-->
</SCRIPT>
<%@include file="/bizcommon/include/common_alps.jsp"%>
