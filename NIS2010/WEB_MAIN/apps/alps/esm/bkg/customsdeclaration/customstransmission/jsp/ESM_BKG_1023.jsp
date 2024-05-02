<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_1023.jsp
*@FileTitle : Vessel Stowage Plan Transmit
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.12 
*@LastModifier : 김도완
*@LastVersion : 1.0
* 2009.08.12 김도완
* 1.0 Creation
*-------------------------------------------------------
* History
* 2011.10.13 김봉균 [CHM-201112452-01] 미세관 RECEIVE 데이터 중 CUSRES 반영 요청
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page
	import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page
	import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page
	import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page
	import="com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.event.EsmBkg1023Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmBkg1023Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지

	String strUsr_id = "";
	String strUsr_nm = "";
	String vvdCd = "";
	String polCd = "";
	String podCd = "";
	String strPgmNo = "";
	String strCustoms = "";
	
	try{
		SignOnUserAccount account = (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg1023Event) request.getAttribute("Event");
		serverException = (Exception) request
				.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null){
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		vvdCd  = JSPUtil.getParameter(request, "vvd_cd");
		polCd  = JSPUtil.getParameter(request, "pol_cd");
		podCd  = JSPUtil.getParameter(request, "pod_cd");		
		strPgmNo = request.getParameter("pgmNo");
		
		if ( "ESM_BKG_1122".equals(strPgmNo) || "ESM_BKG_1023".equals(strPgmNo) ) {
			strCustoms = "US";
		} else { 
			strCustoms = "CA";
		}
		
	}catch (Exception e){
		out.println(e.toString());
	}
%>
<html>
<head>
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1){
			//showErrMessage(errMessage);
		}// end if
		loadPage();
	}
</script>
</head>

<body onLoad="setupPage();">
<form name="form"><input type="hidden" name="f_cmd"> 
<input type="hidden" name="pagerows">
<input type="hidden" name="pageno" value="<%=strPgmNo%>">
<input type="hidden" name="customs" value="<%=strCustoms%>">

<!-- 개발자 작업	-->
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	style="padding-top: 2; padding-left: 5;">

	<tr>
		<td valign="top"><!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" 
			class="title">
			<tr>
				<td class="history"><img src="img/icon_history_dot.gif"
					align="absmiddle"><span id="navigation"></span></td>
			</tr>
			<tr>
				<td class="title"><img src="img/icon_title_dot.gif"
					align="absmiddle"><span id="title"></span></td>
			</tr>
		</table>
		<!--Page Title, Historical (E)--> 

		<!--biz page (S)-->
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">
			
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="90" rowspan="2">
					
						<table class="search_sm2" border="0" width="80">
							<tr class="h23">
								<td><input type="radio" name="allerror" value="ALL" class="trans" checked>&nbsp;All</td></tr>
							<tr class="h23">
								<td><input type="radio" name="allerror" value="ERR" class="trans">&nbsp;Error</td></tr>
						</table>
					
					</td>
					<td width="30">VVD</td>
					<td width="100"><input type="text" style="width: 80; ime-mode:disabled;"
							class="input1" maxlength="9" value="<%=vvdCd%>" name="vvd" dataformat="uppernum" required ></td> 
					<td width="110">Last Foreign POL</td>
					<td width="70"><input type="text" name="lastpol" maxlength="5" style="width:50;ime-mode:disabled;" value="" class="input1" dataformat="uppernum" required></td>
					<td width="40">POL</td>
					<td width="70"><input type="text" name="pol" maxlength="5" style="width:50;ime-mode:disabled;" value="<%=polCd%>" class="input" dataformat="uppernum" ></td> 
					<td width="30">POD</td>
					<td width="70"><input type="text" name="pod" maxlength="5" style="width:50;ime-mode:disabled;" value="<%=podCd%>" class="input" dataformat="uppernum" ></td>
					<td width="120">Container Operator</td>
					<td width="70"><input type="text" name="cntropr" maxlength="3" style="width:30;ime-mode:disabled;" value="" class="input" dataformat="uppernum" ></td> 
					<td width=""><span id="excludeca_text">Exclude Canada Import</span><input type="checkbox" name="excludeca" value="EXCLUDECA" class="trans"></td> 
				</tr>
				<tr class="h23">
					<td colspan="4">Vessel Name <input type="text" name="vsl_eng_nm" style="width:215;" class="input2" value="" readonly></td> 
					<td width="30">Voyage</td>
					<td width="70"><input type="text" name="vsl_voy" style="width:50;;text-align:center" class="input2" value="" readonly></td> 
					<td colspan="5">Vessel Operator <input type="text" name="crr_cd" style="width:40;text-align:center" class="input2" value="" readonly></td> 
						</tr>
				</table>
				<!--  biz_1   (E) -->

				</td></tr>
			</table>
			<table class="height_8"><tr><td></td></tr></table>
			

		<!-- Grid BG Box  (S) -->
     	<table class="search" id="mainTable">
       	<tr><td class="bg">

				<!--Grid (S)-->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>				
				<!--Grid (E)-->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="40">SML</td>
					<td width="80"><input type="text" name="sml" style="width:50;text-align:right;" class="input2" value="" readonly></td> 
					<td width="30">COS</td>
					<td width="80"><input type="text" name="cos" style="width:50;text-align:right;" class="input2" value="" readonly></td> 
					<td width="30">KKL</td>
					<td width="80"><input type="text" name="kkl" style="width:50;text-align:right;" class="input2" value="" readonly></td> 
					<td width="30">YML</td>
					<td width="80"><input type="text" name="yml" style="width:50;text-align:right;" class="input2" value="" readonly></td> 
					<td width="40">Others</td>
					<td width=""><input type="text" name="other" style="width:50;text-align:right;" class="input2" value="" readonly></td>  
				</tr>
				<tr class="h23">
					<td>Total</td>
					<td><input type="text" name="tot" style="width:50;text-align:right;" class="tr_head3" value="" readonly></td> 
				</tr>
				</table>
				
			</td></tr>
		</table>
	<!-- Grid BG Box  (S) -->
	<!--biz page (E)-->
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_New">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_DownExcel">Down Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Transmit">Transmit</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				
				<td id="td_AmsReport"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_AmsReport">Go to AMS Report</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>				
			</tr>
			</table>
		</td></tr>
		</table>
    <!--Button (E) -->

    	</td>
	</tr>
</table>
<!-- 
<br>
	    <table style="width:979;height:100">
	    	<tr><td>result : </td></tr>
	        <tr>
	            <td><textarea name="output" cols="100" rows="20"></textarea></td>
	        </tr>
	    </table>
-->	    
<!-- Copyright(E)--> <!-- 개발자 작업  끝 -->
</form>
</body>
</html>