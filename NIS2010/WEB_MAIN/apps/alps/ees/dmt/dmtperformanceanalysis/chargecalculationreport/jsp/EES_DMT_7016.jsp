<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_7016.jsp
*@FileTitle : Summary Report by Customer
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.29
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2009.09.29 황효근
* 1.0 Creation
* 2011.03.31 김태균 [CHM-201109290-01] Split 12-ALPS의 Location 조회불가건 수정 보완 요청.
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.chargecalculationreport.event.EesDmt7016Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesDmt7016Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_ofc		= "";
	String strRhq_ofc_cd	= "";
	Logger log = Logger.getLogger("com.hanjin.apps.DMTPerformanceAnalysis.ChargeCalculationReport");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id		= account.getUsr_id();
		strUsr_nm		= account.getUsr_nm();
		strUsr_ofc		= account.getOfc_cd();
		strRhq_ofc_cd	= account.getRhq_ofc_cd();


		event = (EesDmt7016Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
	
	}catch(Exception e) {
		out.println(e.toString());
	}

	// Duration 종료일 (request가 없다면 오늘날짜)
    String pDate2 = JSPUtil.getKST("yyyy-MM-dd");
    // Duration 시작일 (request가 없다면 하루 전)
    String pDate1 = DateTime.addDays(pDate2, -1, "yyyy-MM-dd");
%>
<html>
<head>
<title>US LFD EDI Audidt</title>
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


<!-- 개발자 작업	-->
<input type="hidden" name="usr_ofc_cd"			value="<%=strUsr_ofc%>">
<input type="hidden" name="usr_rhq_ofc_cd"		value="<%=strRhq_ofc_cd%>">
<input type="hidden" name="yd_cd1"				value="">
<input type="hidden" name="latest"				value="">

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
	<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
	<!--Page Title, Historical (E)-->
	
	<table class="search"> 
       		<tr><td class="bg">
       		
				<!--  biz_1  (S) -->
				
				<table class="search" border="0" style="width:979;">
	
	              <tr class="h23">
	                <td width="150" rowspan="4">
	                  <table class="grid2" border="0" style="width:140;">
	                    <tr class="tr2_head">
	                      <td colspan="2"><input type="radio" name="event_receive" value="LFD" class="trans" checked disabletype="no">LFD
	                        <input type="radio" name="event_receive" value="RECEIVE" class="trans" disabletype="no">Receiving</td>
	                    </tr>
	                    <tr>
	                      <td class="tr2_head2" width="40">From</td>
	                      <td><input type="text" style="width:75" class="input1" value="<%=pDate1%>" name="fm_dt" maxlength="8" dataformat="ymd" ></td>
	                    </tr>
	                    <tr>
	                      <td class="tr2_head2">To</td>
	                      <td><input type="text" style="width:75" class="input1" value="<%=pDate2%>" name="to_dt" maxlength="8" dataformat="ymd" >&nbsp;<img src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" style="cursor:hand;" name="btn_Calendar" disabletype="no">
	                        </td>
	                    </tr>
	                  </table>
	                </td>
	              </tr>
	              
	              <tr class="h23">
	              	<td width="80">BKG No.</td>
					<td width="240"><input type="text" name="bkg_no" dataformat="engup2" style="width:177" class="input" value="">&nbsp;<img src="img/btns_multisearch.gif"
							name="btns_multisearch1" width="19"height="20"alt=""border="0"align="absmiddle"class="cursor" onClick="openPopup('bkg_no')"></td>		
					<td width="80">DMT tariff :</td>
					<td width="">DMIF, CTIC</td>
	              </tr>
	              
	              <tr class="h23">
	              	<td width="80">CNTR No.</td>
					<td width="240"><input type="text" name="cntr_no" dataformat="engup2" style="width:177" class="input" value="">&nbsp;<img src="img/btns_multisearch.gif"
							name="btns_multisearch1" width="19"height="20"alt=""border="0"align="absmiddle"class="cursor" onClick="openPopup('cntr_no')"></td>		
					<td width="80">TP/SZ&nbsp;</td>
                    <td width=""><script language="javascript">ComComboObject("cntr_tpsz_cd", 1, 80, 1, 0, 0, 0, 11);</script>
	              </tr>
	              
	              <tr class="h23">
	              	<td width="80">Yard Code</td>
					<td width="240" ><input type="text" name="loce_cd" dataformat="engup2" style="width:100" class="input" maxlength="5" value="" OnKeyUp="checkYard1_sub2(this)">&nbsp;&nbsp;
					<script language="javascript">ComComboObject('yd_cd', 2, 60 , 0, 0, 0, true);</script></td>
					<td width="80">Result&nbsp;</td>
                    <td width="120"><script language="javascript">ComComboObject("result", 1, 80, 1, 0, 0, 0, 11);</script>
                    <td width="">Latest&nbsp;<input type="checkbox" name="chk_latest" value="Y" class="trans"></td>
	              </tr>
           		</table>
			<!--  biz_1  (E) -->
			
			
				<!-- Grid  (S) -->
					<table width="100%"  id="mainTable"> 
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet1');</script>
							</td>
						</tr>
					</table>
				<!-- Grid  (e) -->
					
			</td></tr>
		</table>
		            
		   <table width="100%" class="button">
              <tr>
                <td>
                  <!-- biz_3  (S) -->
                  <table class="search">
                  <tr class="h23">
                    <td width="45">ROW/Total</td>
                    <td width="70"><input type="text" style="width:60;text-align:right;font-weight:bold;" class="input2" readonly="true" name="rtv_total"></td>
                    <td width="45">EDI/Total</td>
                    <td width=""><input type="text" style="width:60;text-align:right;font-weight:bold;" class="input2" readonly="true" name="gnd_total"></td>
                    </tr>
                  </table>
                  <!-- biz_3   (E) -->
                </td>
              </tr>
            </table>
<!-- : ( Search Options ) (E) -->
	<!-- Tab BG Box  (S) -->
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
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_DownExcel">Down Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			</table>
		</td></tr>
		</table>
    <!--Button (E) -->
	</td></tr>
</table>


<!-- 개발자 작업  끝 -->
</form>
</body>
</html>