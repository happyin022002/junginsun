<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0648.jsp
*@FileTitle : BL Copy
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.20
*@LastModifier : 이일민
*@LastVersion : 1.0
* 2009.08.20 이일민
* 1.0 Creation
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.event.EsmBkg0648Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0648Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList    = "";
	String pageRows    = "100";
	String strUsr_id   = "";
	String strUsr_nm   = "";
	String isPop       = "";

	Logger log = Logger.getLogger("com.hanjin.apps.OutboundBLMgt.BLDocumentation");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		isPop     = JSPUtil.getParameter(request, "isPop");


		event = (EsmBkg0648Event)request.getAttribute("Event");
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
<title>B/L Copy</title>
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

<body onLoad="setupPage()">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<!-- 개발자 작업	-->
<input type="hidden" name="bkg_no">
<input type="hidden" name="bkgStatus">
<input type="hidden" name="bdrFlg">
<input type="hidden" name="shprCd">
<input type="hidden" name="isPop" value="<%=isPop%>">

<%@include file="/apps/alps/esm/bkg/bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_TOP.jsp" %>
    <!--Page Title, Historical (E)-->
   
		<!--biz page (S)-->
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">
				<!--  biz_1  (S) -->
                <table class="search" border="0" style="width:100%"> 
                <tr class="h23">
                    <td width="125">Original Booking No.</td>
                    <td><input type="text" name="s_bkg_no" value="" style="width:124" class="input1" minlength="11" maxLength="13" dataformat="engupnum" required caption="Original Booking No"></td>
                </tr></table>
                <table class="search" border="0" style="width:100%"> 
                <tr class="h23">
                    <td width="122">Shipper</td>
                    <td><input type="text" name="cust_cnt_cd" value="" style="width:60" class="input2" readonly
                        >&nbsp;<input type="text" name="cust_seq" value="" style="width:60" class="input2" readonly
                        >&nbsp;<input type="text" name="cust_nm" value="" style="width:240" class="input2" readonly></td>
                </tr>
                <tr class="h23">
                    <td width="122">Commodity</td>
                    <td><input type="text" name="cmdt_cd" value="" style="width:60" class="input2" readonly>&nbsp;<input type="text" name="rep_cmdt_cd" value="" style="width:60" class="input2" readonly>&nbsp;<input type="text" name="cmdt_nm" value="" style="width:240" class="input2" readonly></td>
                </tr>
                </table>  
    			<table class="height_5"><tr><td></td></tr></table>
    			<table class="search" border="0">
    				<tr><td class="title_h"></td>
    				<td class="title_s">Copy Item</td></tr>
    			</table>
				<table class="search" border="0" style="width:100%"> 
				<tr class="h23">
					<td><table border="0" style="width:100%" class="search_sm"> 
						<tr class="h23">
						    <td class="stm"><label for="cust_flg">Customer</label>&nbsp;<input type="checkbox" name="cust_flg" id="cust_flg" value="Y" class="trans" checked>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											<label for="mark_flg">Marks & Nos</label>&nbsp;<input type="checkbox" name="mark_flg" id="mark_flg" value="Y" class="trans">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											<label for="desc_flg">Description of Goods</label>&nbsp;<input type="checkbox" name="desc_flg" id="desc_flg" value="Y" class="trans"></td>
						</tr>
						</table>
					</td>
				</tr>
				</table>
				<!--  biz_1   (E) -->
				<table class="height_5"><tr><td></td></tr></table>
				<table class="search" border="0">
				<tr><td class="title_h"></td>
				<td class="title_s">Copy To</td></tr>
				</table>
				<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr><td width="100%"><script language="javascript">ComSheetObject('sheet1');</script></td></tr>
				</table> 				
				<!-- Grid (E) -->
				<!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0">
                    <tr>
    					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
    					<tr><td class="btn2_left"></td>
    					<td class="btn2" name="btn_add">Row Add</td>
    					<td class="btn2_right"></td>
    					</tr>
    					</table></td>
    					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
    					<tr><td class="btn2_left"></td>
    					<td class="btn2" name="btn_delete">Row Delete</td>
    					<td class="btn2_right"></td>
    					</tr>
    					</table></td>
					</tr>
                </table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->	
	</td></tr></table>
		<!--biz page (E)--> 
<!--Button (S) -->
<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:0;">
    <tr><td class="btn1_bg">
    <table border="0" cellpadding="0" cellspacing="0">
    <tr>
    <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
      <tr><td class="btn1_left"></td>
      <td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
      <td class="btn1_right"></td>
      </tr>
    </table></td>
    <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
      <tr><td class="btn1_left"></td>
      <td class="btn1" name="btn_new">New</td>
      <td class="btn1_right"></td>
      </tr>
    </table></td>
    <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
      <tr><td class="btn1_left"></td>
      <td class="btn1" name="btn_copy">Copy</td>
      <td class="btn1_right"></td>
      </tr>
    </table></td>
    </tr>
    </table>
    </td>
    </tr>
</table>


	</td></tr></table>
<%@include file="/apps/alps/esm/bkg/bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_CLOSE.jsp" %>
<!--Button (E) -->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>
