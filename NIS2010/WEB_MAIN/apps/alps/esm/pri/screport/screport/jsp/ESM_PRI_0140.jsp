<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ESM_PRI_0140.jsp
*@FileTitle : MOT/SSE Filing Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.24
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2014.04.24 송호진
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
<%@ page import="com.hanjin.apps.alps.esm.pri.screport.screport.event.EsmPri0140Event"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.common.PRIUtil"%>
<%@ page import="com.hanjin.framework.component.util.code.CodeInfo"%>
<%@ page import="java.util.List"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmPri0140Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.SCReport.SCReport");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmPri0140Event)request.getAttribute("Event");
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
<title>MOT/SSE Filing Inquiry</title>
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
<input type="hidden" name="lane_list">
<input type="hidden" name="inq_tp_cd">

<!-- 개발자 작업	-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	
	<tr><td valign="top">
	<!--Page Title, Historical (S)-->
	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
	</table>
	
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:2;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Downexcel">Down Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			</tr>
			</table>
		</td></tr>
		</table>
    <!--Button (E) -->
	<!--Page Title, Historical (E)-->
	
	<table class="search" border="0"> 
       	<tr><td class="bg">
				<!--  biz_1  (S) -->
				
				<table class="search_sm" border="0" > 
				<tr class="h23">
					<td width="80">Filing Date</td>
					<!-- td><input type="text" caption="Filing Date" style="width:75;text-align:center;" class="input1" name="exec_dt" dataformat="ymd" maxLength="10" minlength="8">
					<img class="cursor" src="img/btns_calendar.gif" name="btns_calendar" width="19" height="20" border="0" align="absmiddle"></td -->
					<td><input type="text" caption="Filing From Date" style="width:75;text-align:center;" class="input1" name="fr_file_dt" cofield="to_file_dt" dataformat="ymd" maxLength="10" minlength="8">
					<!-- img class="cursor" src="img/btns_calendar.gif" name="btns_calendar1" width="19" height="20" border="0" align="absmiddle" -->&nbsp;~&nbsp;
					<input type="text" caption="Filing To Date" style="width:75;text-align:center;" class="input1" name="to_file_dt" cofield="fr_file_dt" dataformat="ymd" maxLength="10" minlength="8">
					<img class="cursor" src="img/btns_calendar.gif" name="btns_calendar" width="19" height="20" border="0" align="absmiddle"></td>
					<td width="20">&nbsp;</td>
					<td width="100">Inquiry Type</td>
					<td width="500" class="stm" style="font-size:12;" id="rdoTpCd">
						<input type="radio" name="inq_tp_rdo" value="1" class="trans" checked>&nbsp;<span id="inq_tp_cd1">Log</span>&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="radio" name="inq_tp_rdo" value="2" class="trans">&nbsp;<span id="inq_tp_cd1">Log4Bkg</span>&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="radio" name="inq_tp_rdo" value="3" class="trans">&nbsp;<span id="inq_tp_cd2">File</span>&nbsp;&nbsp;&nbsp;&nbsp;</td>
				</tr>
				<!-- 
				<tr class="h23">                                                                                                                                                                                                                              
	                                                                                                                                                                                                                                                      
					<td width="90">By Lane Code</td>                                                                                                                                                                                                        
					<td width="" class="stm" style="font-size:12;" colspan="4" >
						<table>
						<tr>
							<td><input type="checkbox" name="lane_chk" value="02" class="trans">&nbsp;02(JP)&nbsp;&nbsp;&nbsp;</td>
							<td><input type="checkbox" name="lane_chk" value="04" class="trans">&nbsp;04(KR)&nbsp;&nbsp;&nbsp;</td>
							<td><input type="checkbox" name="lane_chk" value="05" class="trans">&nbsp;05(DSA)&nbsp;&nbsp;&nbsp;</td>
							<td><input type="checkbox" name="lane_chk" value="06" class="trans">&nbsp;06(M.E&amp;RedSea)&nbsp;&nbsp;&nbsp;</td>
							<td><input type="checkbox" name="lane_chk" value="07" class="trans">&nbsp;07(MED)&nbsp;&nbsp;&nbsp;</td>
						</tr>
						<tr>
							<td><input type="checkbox" name="lane_chk" value="08" class="trans">&nbsp;08(N.E.)&nbsp;&nbsp;&nbsp;</td>
							<td><input type="checkbox" name="lane_chk" value="09" class="trans">&nbsp;09(USWC)&nbsp;&nbsp;&nbsp;</td>
							<td><input type="checkbox" name="lane_chk" value="10" class="trans">&nbsp;10(USEC)&nbsp;&nbsp;&nbsp;</td>
							<td><input type="checkbox" name="lane_chk" value="11" class="trans">&nbsp;11(S.AF/LATAM)&nbsp;&nbsp;&nbsp;</td>
							<td><input type="checkbox" name="lane_chk" value="14" class="trans">&nbsp;14(AU)&nbsp;&nbsp;&nbsp;</td>
						</tr>
						</table>                                                                                                                                                                                       
					</td>                                                                                                                                                                                                                                                         
				</tr>                                                                                                                                                                                                                                         
				<tr class="h23">                                                                                                                                                                                                                              
	                                                                                                                                                                                                                                                      
					<td width="90">By Date Type</td>                                                                                                                                                                                                        
					<td width="" class="stm" style="font-size:12;" colspan="4" >
						<table>
						<tr>
            				<td><script language="javascript">ComComboObject('mot_file_dt_tp_combo', 2, 93, 1, 1, 0, false);</script></td>
						</tr>
						</table>                                                                                                                                                                                       
					</td>                                                                                                                                                                                                                                                         
				</tr>
				-->                                                                                                                                                                                                                                         
				</table>
				
				<!--  biz_1   (E) -->
			
			</td>
		</tr>
	</table>
	
 	<table class="height_8"><tr><td colspan="8"></td></tr></table>
 	
	<table class="search"> 
       	<tr><td class="bg">	
				
			<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
			<!-- Grid (E) -->	
						
				
			</td></tr>
		</table>
	
		<!--Button (S) -->
		
		
		
    <!--Button (E) -->
	
	<!--biz page (S)-->
		
   
	</td></tr>
</table>
<div style="display:none">
<script language="javascript">ComSheetObject('sheet2');</script>
</div>
 <table class="height_10"><tr><td colspan="8"></td></tr></table>
				
		</td>				
			</tr>
			</table>



<!-- 개발자 작업  끝 -->
</form>
</body>
</html>