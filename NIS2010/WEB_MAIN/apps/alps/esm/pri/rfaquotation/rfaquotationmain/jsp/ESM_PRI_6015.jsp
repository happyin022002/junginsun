<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_6015.jsp
*@FileTitle : RFA Quotation Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.23
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.08.06 이승준
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
<%@ page import="com.hanjin.apps.alps.esm.pri.rfaquotation.rfaquotationmain.event.EsmPri6015Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmPri6015Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_office_cd = "";
	
	Logger log = Logger.getLogger("com.hanjin.apps.RFAQuotation.RFAQuotationMain");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_office_cd =	account.getOfc_cd();

		event = (EsmPri6015Event)request.getAttribute("Event");
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
<title>S/C Quotation Creation</title>
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
<!-- 조회된 키값 -->
<input type="hidden" name="qttn_no_hidden" value="">
<input type="hidden" name="qttn_ver_no_hidden" value="">
<!-- code 조회용 -->
<input name="cd" type="hidden" value="">
<input name="etc1" type="hidden" value="<%=strUsr_office_cd %>">
<input name="etc2" type="hidden" value="">
<input name="etc3" type="hidden" value="">
<input name="etc4" type="hidden" value="">
<input name="etc5" type="hidden" value="">
<!-- 상태코드 -->
<!-- <input name="qttn_sts_cd" type="hidden" value=""> -->
<!-- 소속 오피스 -->
<input name="qttn_ofc_cd_hidden" type="hidden" value="<%=strUsr_office_cd %>">
<!-- gline 존재 여부 체크용 -->
<input name="gline_cnt" type="hidden" value="0">
<!-- add version 용  max qttn_ver_no -->
<input name="max_qttn_ver_no" type="hidden" value="">

<!-- 각 탭별 건수 존재 여부 체크용 -->
<input name="grp_loc_cnt" type="hidden" value="0">
<input name="grp_cmdt_cnt" type="hidden" value="0">
<input name="rate_cnt" type="hidden" value="0">
<input name="rate_g_cnt" type="hidden" value="0">
<input name="rate_s_cnt" type="hidden" value="0">
<input name="rate_ihc_cnt" type="hidden" value="0">
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
	<!--Page Title, Historical (S)-->
	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
	</table>
	<!--Page Title, Historical (E)-->
	
	
	<table width="100%" style="display:inline;">
        <tr>
            <td width="100%">
                <script language="javascript">ComSheetObject('sheet0');</script>
            </td>
        </tr>
    </table>
			<!--Button (S) -->
		<table width="100%" border="0" class="button" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:2;"> 
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
					<td class="btn1" name="btn_New">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
		    	<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Quotation">Copy to Quotation</td>
					<td class="btn1_right"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_OpenQuotation">Open Quotation</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
		    
			</tr>
			</table></td>
			</tr>
			</table>
    <!--Button (E) -->
	
		
		<table class="search"> 
       		<tr><td class="bg">	
			
			<!-- biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="88">Quotation No.</td>
					<td width="90" >
					<input type="text" name="qttn_no" style="width:80;text-align:center;" class="input" value="" maxlength="10" 
						onkeyup="javascript:searchQttnVerNo();" dataformat="engup"></td>
					<td width="50">Ver. No.</td>
					<td width="50"><script language="javascript">ComComboObject('qttn_ver_no', 1, 40, 0, 0, 0, false);</script></td> 
					<td width="95">Request Office</td>
					<td width="80" ><input type="text" dataformat="engup" name="qttn_ofc_cd" style="width:70;text-align:center;" class="input" value="" required ></td>
					<td width="65">Sales Rep.</td>
					<td width="170" style="padding-left:4"><script language="javascript">ComComboObject('qttn_srep_cd', 2, 70, 0, 0, 0, false);</script>
					&nbsp;<input type="text" name="qttn_srep_nm" style="width:85;" class="input2" value="" readonly></td>
					<td width="90">Creation Date</td>   
					<td width="75">
					<input name="cre_dt_from" type="text" style="width:75;text-align:center;"  value="" class="input" caption="Creation Date" maxlength="10" dataformat="ymd" required>
					</td>
					<td width="95">
					&nbsp;~&nbsp;<input name="cre_dt_to" type="text" style="width:75;text-align:center;"  value="" class="input" caption="Creation Date" maxlength="10" dataformat="ymd" required></td>
					<td width=""><img src="img/btns_calendar.gif" class="cursor" name="btns_calendar" valign="bottom">
					</td></tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">	
					<td width="88">SVC Scope</td>
					<td width="188" style="padding-left:2"><script language="javascript"> ComComboObject('svc_scp_cd', 2, 60, 0, 0, 0, false);</script>
					&nbsp;<input name="svc_scp_nm" type="text" style="width:114;" value="" class="input2" readonly></td>
					
					<td width="95">Customer Type</td>
					<td width="80" style="padding-left:2"><script language="javascript">ComComboObject('prc_cust_tp_cd', 1, 70, 0, 0, 0, false);</script></td>
					
					<td width="65">Customer</td>
					<td width="320"><input type="text" style="width:30;text-align:center;" dataformat="engup" maxlength="2" minlength="2" name="cust_cnt_cd" class="input" caption="Customer Code" required>
					<input type="text" style="width:60;text-align:center;" dataformat="int" name="cust_seq" maxlength="6" class="input" caption="Customer Code" required>
					<a href="javascript:popupCustomer();">
					<img src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></a>
					<input type="text" name="cust_nm" style="width:182;" class="input2" value="" readonly>
					</td>
					
					<td colspan="2">Status
					&nbsp;<script language="javascript">ComComboObject('qttn_status', 1, 84, 0, 0, 0, false);</script></td>
				</tr>
				</table>
				
				<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
				<table class="search" border="0" style="width:100%;"> 
					<tr class="h23"><td class="stm" align="right">[Unit:TEU/USD]</td></tr>
				</table>
				
				
				<!--grid (s)-->
				<table width="100%" id="mainTable">
					<tr>
						<td width="100%"><script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
				<!--grid(E)-->
						
				<!--<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>-->
				
				
				<!-- biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="170">Quotation No.</td>
					<td width="120"><input type="text" name="qttn_no_read" style="width:80;text-align:center;" class="input2" value="" maxlength="10" readonly></td>
					<td width="80">Ver. No.</td>
					<td width="80"><input type="text" name="qttn_ver_no_read" style="width:40;text-align:center;" class="input2" value="" readonly></td> 
					<td width="220">Request Office</td>
					<td width="90"><input type="text" name="qttn_ofc_cd_read" style="width:50;text-align:center;" class="input2" value="" readonly></td>
					<td width="130">Sales Rep.</td>
					<td width="290"><input type="text" name="qttn_srep_cd_read" style="width:55;text-align:center;" class="input2" value="" readonly>
					&nbsp;<input type="text" name="qttn_srep_nm_read" style="width:102;" class="input2" value="" readonly></td>
					<td width="220" style="padding-left:5">Duration</td>   
					<td width="75">
					<input name="eff_dt_read" type="text" style="width:80;text-align:center;"  value="" class="input2" maxlength="10" readonly>
					</td>
					<td width="125">
					&nbsp;&nbsp;~&nbsp;&nbsp;<input name="exp_dt_read" type="text" style="width:81;text-align:center;"  value="" class="input2" maxlength="10" readonly>
					</td>
				</tr>
				
				<tr class="h23">
				 	<td>Proposal No.</td>
					<td><input type="text" name="prop_no_read" style="width:80;text-align:center;" class="input2" value="" readonly></td>
					<td>Copied</td>
					<td><input type="text" name="iscopy_read" style="width:40;text-align:center;" class="input2" value="" readonly></td> 
					<td>Service Scope</td>
					<td colspan='3'><input type="text" name="svc_scp_cd_read" style="width:50;text-align:center;" class="input2" value="" readonly>
					&nbsp;<input name="svc_scp_nm_read" type="text" style="width:242;"  value="" class="input2" readonly></td>
					<td style="padding-left:5">Creation Date</td>
					<td><input type="text" name="cre_dt_read" style="width:80;text-align:center;" class="input2" value="" readonly></td>
					<td colspan='2'>&nbsp;Status
					<input type="text" name="qttn_sts_nm_read" style="width:58;text-align:center;" class="input2" value="" readonly></td>
				</tr>
				</table>
				
				<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
				
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="92">Customer</td>
					<td width="620">
					<input type="text" style="width:30;text-align:center;" name="cust_cnt_cd_read" class="input2" readonly>
					<input type="text" style="width:60;text-align:center;" name="cust_seq_read" class="input2" readonly>&nbsp;<input type="text" name="cust_nm_read" style="width:402;" class="input2" value="" readonly>
					&nbsp;<input type="text" style="width:78;text-align:center;" name="prc_cust_tp_cd_read" class="input2" readonly>
					</td> 
					<td width="98">Est.Target MVC</td>
					<td width="200"><input type="text" name="estm_mqc_qty_read" style="width:118;text-align:right;" class="input2" value="" readonly>
					&nbsp;<input type="text" name="cntr_lod_ut_cd_read" style="width:60;text-align:center;" class="input2" value="" readonly>
					</td>
				</tr>
				<tr class="h23">
					<td colspan="2"></td> 
					<td>Estimate CM</td>
					<td><input type="text" name="estm_cm_amt_read" style="width:118;text-align:right;" class="input2" value="" readonly>
					&nbsp;<input type="text" style="width:60;text-align:center;" class="input2" value="USD" readonly></td>
				</tr>
				</table>
			<!-- biz_1  (E) -->
				
			</td></tr>
		</table>
		<table class="height_8"><tr><td></td></tr></table>
			<!-- Tab ) (S) -->
     		<table class="tab" border="0" cellpadding="0" cellspacing="0" width="100%"> 
       		<tr><td width="100%">
						<script language="javascript">ComTabObject('tab1')</script>
					</td></tr>
				</table>
			<!-- Tab ) (E) -->
			<!-- iFrame (S) -->
           <div id="tabLayer1" style="display:none">
           <iframe name="t1frame" id="t1frame" frameborder="0" scrolling="no" width="100%" height="350" src="about:blank"></iframe>
           </div>
           <div id="tabLayer2" style="display:none">
           <iframe name="t2frame" id="t2frame" frameborder="0" scrolling="no" width="100%" height="350" src="about:blank"></iframe>
           </div>
           <div id="tabLayer3" style="display:none">
           <iframe name="t3frame" id="t3frame" frameborder="0" scrolling="no" width="100%" height="685" src="about:blank"></iframe>
           </div>
           <div id="tabLayer4" style="display:none">
           <iframe name="t4frame" id="t4frame" frameborder="0" scrolling="no" width="100%" height="720" src="about:blank"></iframe>
           </div>
            <div id="tabLayer5" style="display:none">
           <iframe name="t5frame" id="t5frame" frameborder="0" scrolling="no" width="100%" height="720" src="about:blank"></iframe>
           </div>
           <!-- iFrame (E) -->
			
			<!-- Hidden sheet for Transaction (S) -->
			<script language="javascript">ComSheetObject('sheet2');</script>
			<!-- Hidden sheet for Transaction (E) -->
		<table class="height_10"><tr><td colspan="8"></td></tr></table>
	</td></tr>
</table>
	<!--  Tab_3 (E) -->
<table class="height_10"><tr><td colspan="8"></td></tr></table>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>