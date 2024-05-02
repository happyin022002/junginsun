<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0708.jsp
*@FileTitle : C/A Issue Reason Selection
*Open Issues : ESM_BKG_0708 화면
*Change history :
*@LastModifyDate : 2009.08.31
*@LastModifier : 이남경
*@LastVersion : 1.0
* 2009.08.31 이남경
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingcorrection.bdrcorrection.event.EsmBkg0708Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0708Event  event           = null;	//PDTO(Data Transfer Object including Parameters)
	Exception        serverException = null;	//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지

	Logger log = Logger.getLogger("com.hanjin.apps.BookingCorrection.BdrCorrection");
	
	try {	
		event = (EsmBkg0708Event)request.getAttribute("Event");		
		GeneralEventResponse eventResponse = (GeneralEventResponse)request.getAttribute("EventResponse");

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
<title>C/A Issue Reason Selection</title>
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

<body class="popup_bg" onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<!-- 개발자 작업	-->
<input type="hidden" name="bkg_no"      value="">
<input type="hidden" name="mode_cd"     value="">
<input type="hidden" name="ca_rsn_cd"   value="">
<input type="hidden" name="rvis_seq"    value="">
<input type="hidden" name="rdn_sts_cd"  value="">
<input type="hidden" name="etc1"        value="">
<input type="hidden" name="umch_sub_tp_cd_hid"  value="">

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		    <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp; C/A Issue Reason Selection</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- : ( Search Options ) (S) -->
		<table class="search">
		   <tr><td class="bg">
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table> 
				<table width="70%" class="button"> 
		       		<tr><tr>
							<td class="btn2_left"></td>
							<td class="btn2" name="btn2_CA_Desc">Tips for correct selection of C/A Reason</td>
							<td class="btn2_right"></td>
							</tr>
							</table>
					</td>
					</tr>
				</table>
				 
			    <!-- : ( Button : Grid ) (E) -->
			    
				<table class="height_5"><tr><td></td></tr></table>
				
				<table border="0" style="width:100%; background-color:white;" class="grid2"> 
					<tr class="tr2_head"><td colspan="3">RDN</td>
					</tr>
					<tr><td width="130"><input type="text" name="intg_cd_val_dp_desc" style="width:100%;text-align:center;color:red" class="noinput" value="" readonly></td>
					    <td width="100"><input type="text" name="rdn_no" style="width:100%;text-align:center;color:red" class="noinput" value="" readonly></td>
					    <td width="">
					        <!-- TransMode : 콤보출력 Start ----------->
						    <script language="javascript">ComComboObject('rdn_acpt_flg', 1, 120, 1);</script>
						    <!-- TransMode  : 콤보출력 End--------------> 
					    </td>
					</tr>
					<tr>
						<td><input type="text" name="umch_tp_cd" style="width:100%;text-align:center;" class="noinput" value="" readonly></td>
						<td colspan="2"><script language="javascript"> ComComboObject('umch_sub_tp_cd', 1, 224, 0, 0, 0, false);</script></td>
					</tr>
				</table>
			    
			    	
				<table class="height_5"><tr><td></td></tr></table>
				
				<table border="0" style="width:390;height:75;background-color:white" class="grid2"> 
					<tr><td width="80" class="tr2_head">Remark(s)</td>
						<td><textarea name="bkg_corr_rmk" cols="40" rows="5" style="font-family:Courier New; font-size:12px; text-indent:0px;overflow-y:scroll;overflow-x:hidden" class="textarea_img5" wrap="physical" dataformat="etc" onBlur="javascript:validateCols('5','40',this);" wrap="hard" maxlength="1000" Caption="Remark"></textarea></td>
					</tr>
				</table>
			</td></tr>
		</table>
<!-- : ( Search Options ) (E) -->

<table class="height_5"><tr><td></td></tr></table>
</td></tr>
</table> 
	
	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="65" class="popup">
	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					    <tr><td class="btn1_left"></td>
					        <td class="btn1" name="btn_select">Save</td>
					        <td class="btn1_right"></td>
				        </tr></table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_close">Close</td>
						<td class="btn1_right"></td>
					</tr></table>
			</td></tr>
			</table>
			</td></tr>
		</table>
    <!--Button (E) -->
	
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->

<!-- Grid  (S) -->
<table width="50%" id="mainTable"> 
	<tr>
		<td width="100%">
			<script language="javascript">ComSheetObject('h1sheet1');</script>
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
       * 유저가 입력한 정보를 event를 통해서 다시 넘겨받아 화면에 뿌려주는 부분
       */
      with(document.form)
      {
        <%
        if(event != null){ 
            String bkgNo  = event.getBkgBlNoVO().getBkgNo();
            String modeCd = event.getModeCd();
        %>
            eval("bkg_no").value  = "<%=bkgNo%>"; 
            eval("mode_cd").value = "<%=modeCd%>"; 
        <% } %>
     }
-->
</SCRIPT>
<%@include file="/bizcommon/include/common_alps.jsp"%>
