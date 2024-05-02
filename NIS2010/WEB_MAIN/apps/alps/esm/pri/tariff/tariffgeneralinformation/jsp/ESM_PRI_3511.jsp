<%
/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ESM_PRI_3511.jsp
*@FileTitle : Tariff General Information Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.27
*@LastModifier : 김민아
*@LastVersion : 1.0
* 2010.10.27 김민아
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
<%@ page import="com.hanjin.apps.alps.esm.pri.tariff.tariffgeneralinformation.event.EsmPri3511Event"%>
<%@ page import="com.hanjin.framework.component.util.code.CodeInfo"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.common.PRIUtil"%>
<%@ page import="java.util.List"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmPri3511Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	
	String[] tariffCd         = null;				//Tariff Code
	String[] trfBzcStsCd	  = null;		    	//Status
	
	Logger log = Logger.getLogger("com.hanjin.apps.Tariff.TariffGeneralInformation");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);

		event = (EsmPri3511Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		//COMMBO LIST
		tariffCd         = PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("TARIFF_CD"));
		trfBzcStsCd		 = PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("TRF_BZC_STS_CD"), false);

		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Tariff General Information Creation &amp; Amendment</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
   
	var tariffCdValue			= " |<%=tariffCd[0]%>";
	var tariffCdText			= " |<%=tariffCd[1]%>";
	var trfBzcStsCdComboValue	= " |<%=trfBzcStsCd[0]%>".replace("|R", ""); //Returned 항목 제외
	var trfBzcStsCdComboText	= " |<%=trfBzcStsCd[1]%>".replace("|Returned",""); //Returned 항목 제외

	
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
<input type="hidden" name="trf_pfx_cd" value="">
<input type="hidden" name="trf_no" value="">

<!-- 개발자 작업	-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
	<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
	<!--Page Title, Historical (E)-->
	
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:2;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>		
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_new">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_creation">Open Creation</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_history">History</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_print">Print</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				
			</tr>
			</table>
		</td></tr>
		</table>
    <!--Button (E) -->
	
	<!--biz page (S)-->
	
		<!-- Hidden sheet for Transaction (S) -->
		<script language="javascript">ComSheetObject('sheet1');</script> 
		<!-- Hidden sheet for Transaction (E) -->
	
		<table class="search"> 
       	<tr><td class="bg">

			<table class="search" border="0" style="width:979;"> 
			<tr class="h23">
				<td width="85">Tariff Code</td>
				<td width="130" style="text-align:left;"><script language="javascript">ComComboObject("tariff_cd", 2, 100, 0, 0, 0, false);</script></td>
				<td width="60">Status</td>
				<td width="" style="text-align:left;"><script language="javascript">ComComboObject("trf_bzc_sts_cd", 1, 100, 0, 0, 0, false);</script></td>
				</tr>	
				</table>
			<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
		  	<!-- Grid  (S) -->
			<table width="100%"  id="mainTable"> 
				<tr>
					<td width="100%">
					<script language="javascript">ComSheetObject('sheet2');</script>
					</td>
				</tr>
			</table>
			<!-- Grid (E) -->
			<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
			<!--  biz_1  (S) -->
				
			<table class="search" border="0">
			       <tr><td class="title_h"></td>
				   <td class="title_s">Publishing Information / Tariff Type / Measurement / Currency Information </td></tr>
			</table>
			<table class="search" border="0" style="width:979;"> 
			<tr class="h23">
				<td width="100">Tariff Code</td>
				<td width="150" colspan="2"><input type="text" name="sh_trf_cd" style="width:122; text-align:center;" class="input2" value="" readonly></td>
				<td width="100">Tariff Name</td>
				<td width="" colspan="7"><input type="text" name="trf_nm" style="width:626;" class="input2" value="" readonly></td>
				</tr>

			<tr class="h23">
				<td width="100">Request Office</td>
				<td width="150" colspan="2"><input type="text" name="rqst_ofc_cd" style="width:122; text-align:center;" class="input2" readonly></td>
				<td width="100">Creation Staff</td>
				<td width="150" colspan="2"><input type="text" name="cre_usr_id" style="width:122; text-align:center;" class="input2" readonly></td>
				<td width="100">Approval Office</td>
				<td width="150" colspan="2"><input type="text" name="apro_ofc_cd" style="width:122; text-align:center;" class="input2" readonly></td>
				<td width="100">Amend No.</td>
				<td width=""><input type="text" name="amdt_seq" style="width:122; text-align:center;" class="input2" value="" readonly></td>
				</tr>

			<tr class="h23">
				<td width="100">Effective Date</td>
				<td width="150" colspan="2"><input type="text" name="eff_dt" maxlength="10" dataformat="ymd" style="width:122; text-align:center;" class="input2" value="" readonly></td>
				<td width="100">Expiration Date</td>
				<td width="150" colspan="2"><input type="text" name="exp_dt" maxlength="10" dataformat="ymd" style="width:122; text-align:center;" class="input2" value="" readonly></td>
				<td width="100">Publish Date</td>
				<td width="150" colspan="2"><input type="text" name="pub_dt" maxlength="10" dataformat="ymd" style="width:122; text-align:center;" class="input2" value="" readonly></td>
				<td width="100">Creation Date</td>
				<td width=""><input type="text" name="cre_dt" maxlength="10" dataformat="ymd" style="width:122; text-align:center;" class="input2" readonly></td>
				</tr>
				
			<tr class="h23">
				<td width="100">Tariff Type</td>
				<td width="150" colspan="2"><input type="text" name="trf_bzc_tp_cd" style="width:122; text-align:center;" class="input2" value="" readonly></td></td>
				<td width="100">Weight Ton</td>
				<td width="90"><input type="text" name="trf_bzc_wgt" dataformat="float" style="width:90; text-align:right;" class="input2" value="" readonly></td>
				<td width="60"><input type="text" name="trf_bzc_wgt_ut_cd" style="width:30; text-align:center;" class="input2" value="" readonly></td>
				<td width="100">Volume Ton</td>
				<td width="90"><input type="text" name="trf_bzc_vol_qty" dataformat="float" style="width:90; text-align:right;" class="input2" value="" readonly></td>
				<td width="60"><input type="text" name="trf_bzc_vol_ut_cd" style="width:30; text-align:center;" class="input2" value="" readonly></td>
				<td width="100">Currency</td>
				<td width=""><input type="text" name="curr_cd" style="width:122; text-align:center;" class="input2" value="" readonly></td>
				</tr>
	
			</table>
			
			<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
			
			<table class="search" border="0">
			       <tr><td class="title_h"></td>
				   <td class="title_s">Publishing Office  </td></tr>
			 </table>
			<table class="search" border="0" style="width:979;"> 
			<tr class="h23">	
				<td width="100">Contact</td>
				<td width="150"><input type="text" name="pub_cntc_pson_nm" maxlength="50" style="width:122;" class="input2" value="" readonly></td>
				<td width="100">Address</td>
				<td width="405" colspan="5"><input type="text" name="pub_ofc_addr" maxlength="10" style="width:375;" class="input2" value="" readonly></td>
				<td width="97">Phone</td>
				<td width=""><input type="text" name="pub_ofc_phn_no" maxlength="20" dataformat="tel" style="width:122; text-align:center;" class="input2" value="" readonly></td>
				</tr>	

				<tr class="h23">
				<td width="100">City</td>
				<td width="150"><input type="text" name="pub_ofc_cty_nm" maxlength="20" style="width:122;" class="input2" value="" readonly></td>
				<td width="100">State</td>
				<td width="90"><input type="text" name="pub_ofc_ste_cd" maxlength="3" style="width:85;" class="input2" value="" readonly></td>
				<td width="55">Zip Code</td>
				<td width="90"><input type="text" name="pub_ofc_zip_cd" maxlength="10" dataformat="int" style="width:85;" class="input2" value="" readonly></td>
				<td width="55">Country</td>
				<td width="115"><input type="text" name="pub_ofc_cnt_nm" maxlength="20" style="width:85;" class="input2" value="" readonly></td>
				<td width="97">Fax</td>
				<td width=""><input type="text" name="pub_ofc_fax_no" maxlength="20" dataformat="tel" style="width:122; text-align:center;" class="input2" value="" readonly></td>
				</tr>	

			</table>

			<!--  biz_1   (E) -->
			<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>

			<!--  biz_2  (S) -->
			<table class="search" border="0">
				       <tr><td class="title_h"></td>
					   <td class="title_s">Tariff Scope</td></tr>
				      </table>
			<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
				<td width="485">
		  	
			  	<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
						<script language="javascript">ComSheetObject('sheet3');</script>
						</td>
					</tr>
				</table>
				<!-- Grid (E) -->
			
				</td>
				<td width="9"></td>
				<td width="485">
				
			  	<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
						<script language="javascript">ComSheetObject('sheet4');</script>
						</td>
					</tr>
				</table>
				<!-- Grid (E) -->
				
				</td>
				</tr>	
			</table>
			<!--  biz_2  (E) -->
			</td></tr>
		</table>
	<!--biz page (E)-->
	</td></tr>
</table>
		
	<table class="height_10"><tr><td colspan="8"></td></tr></table>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>