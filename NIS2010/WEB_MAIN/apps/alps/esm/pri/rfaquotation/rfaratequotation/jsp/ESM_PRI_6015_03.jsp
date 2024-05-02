<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_6015_03.jsp
*@FileTitle : RFA Quotation Rate Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.24
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.08.12 이승준
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
<%@ page import="com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.event.EsmPri601503Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmPri601503Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.SCQuotation.SCRateQuotation");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmPri601503Event)request.getAttribute("Event");
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
<title>S/C Quotation Rate Creation</title>
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

<body  onLoad="setupPage();" onResize="sheetColResize();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->

<input type="hidden" name="qttn_no" value="">
<input type="hidden" name="qttn_ver_no" value="">
<input type="hidden" name="svc_scp_cd" value="">
<input type="hidden" name="cmdt_hdr_seq" value="">
<input type="hidden" name="rout_seq" value="">
<input type="hidden" name="gen_spcl_rt_tp_cd" value="G">
<input type="hidden" name="eff_dt" value="">
<input type="hidden" name="exp_dt" value="">
<!-- gline exist -->
<input type="hidden" name="rate_cnt" value="0">
<input type="hidden" name="loc_chk" value="0">
<input type="hidden" name="cmdt_chk" value="0">
<input type="hidden" name="cmdt_tpw_chk" value="0">
<input type="hidden" name="rate_chk" value="0">
<!-- 조회시 cmdt seq(cmdt_hdr_seq와 다름) -->
<input type="hidden" name="src_info_cd" value="">
<input name="etc5" type="hidden" value="">

	<table class="search"> 
       	<tr><td class="bg">	
			
	<!--Button (S) -->
		<table width="100%" border="0" class="button" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<!-- 
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_All">View All</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				 -->
			</tr>
			</table></td>
			</tr>
			</table>
    <!--Button (E) -->
			
			
				<table class="search">
					<tr>
						<td width="400" valign="top">
						<table class="search" border="0">
							<tr><td class="title_h"></td>
							<td class="title_s">Commodity Group</td></tr>
						</table>
				
						<!--grid (s)-->
							<table width="100%"  id="mainTable"> 
								<tr>
									<td width="100%">
										<script language="javascript">ComSheetObject('sheet1');</script>
									</td>
								</tr>
							</table> 
						<!--grid(E)-->
				
						</td>
						<td width="49" align="center"><img src="img/btn_add.gif" width="26" height="26" alt="" border="0" align="absmiddle" >&nbsp;</td>	
						<td width="" valign="top">
						<table class="search" border="0">
							<tr><td class="title_h"></td>
							<td class="title_s">Route Detail</td></tr>
						</table>
				
						<!--grid (s)-->
						<table width="100%"  id="mainTable"> 
								<tr>
									<td width="100%">
										<script language="javascript">ComSheetObject('sheet2');</script>
									</td>
								</tr>
							</table> 
						<!--grid(E)-->
					
						</td>
					</tr>
				</table>
				
				<!-- <table class="line_bluedot"><tr><td></td></tr></table> -->
				<br>
				
			<!--grid (s)-->
			<table width="100%"  id="mainTable" > 
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet3');</script>
					</td>
				</tr>
			</table>
			<!--grid(E)-->
			
			<table class="line_bluedot"><tr><td></td></tr></table>
			
			<table class="search" border="0">
				<tr><td class="title_h"></td>
				<td class="title_s">Rate</td></tr>
			</table>

				<!--grid (s)-->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet4');</script>
						</td>
					</tr>
				</table> 
				<!--grid(E)-->
				
		</td>
	</tr>
</table>

<div id="hiddenSheetLayer" style="display: none">
<script language="javascript">ComSheetObject('sheet5');</script>
<script language="javascript">ComSheetObject('sheet6');</script>
<script language="javascript">ComSheetObject('sheet7');</script>
<script language="javascript">ComSheetObject('sheet8');</script>
<script language="javascript">ComSheetObject('sheet9');</script>
</div>

<table class="height_10">
	<tr>
		<td colspan="8"></td>
	</tr>
</table>



<!-- 개발자 작업  끝 -->
</form>
</body>
</html>