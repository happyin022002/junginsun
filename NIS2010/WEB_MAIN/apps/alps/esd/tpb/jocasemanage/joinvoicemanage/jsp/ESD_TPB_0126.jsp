<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TPB_0126.jsp
*@FileTitle : JO TPB Invoice Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2010-01-19
*@LastModifier : Sun, CHOI
*@LastVersion : 1.5
* 2008-09-11 O Wan-Ki 1.0 최초 생성
* 2009-03-10 O Wan-Ki 1.1 According to CSR-N200903090210, JO - s_rcv_due_dt +60
* 2009-03-20 O Wan-Ki 1.2 According to CSR-N200903090210, JO - s_rcv_due_dt +30
* 2009-03-23 O Wan-Ki 1.3 N200903090210, JO Inv 의 Due Date 는 화면에서는 Sysdate + 30 로, EPR 에서는 Sysdate + 60 으로 확정. 
* 2009-11-16 Park Sung-Jin 1.4 ALPS Migration 작업
* 2010-01-19 Sun, CHOI 1.5 Administration Charge, Deducted Amount 비활성화 처리
* 2010-10-22 손은주 [CHM-201006504-01] [TPB] Currency Change Validation 보완 -  currency combo 사이즈 변경 
* 2015.07.30 Kim Hyun Hwa[CHM-201537151]그룹사 표준 코드 시행 프로그램 수정
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.Map"%>
<%@ page import="com.hanjin.bizcommon.util.BizComUtil"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.tpb.jocasemanage.joinvoicemanage.event.EsdTpb0126Event"%>
<%@ page import="com.hanjin.apps.alps.esd.tpb.common.TPBUtils"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.apps.alps.esd.tpb.common.combo.basic.CommonCodeBCImpl"%>

<%
	EsdTpb0126Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	Map<String,String> rowSet = null;
	Map<String,String> rowSetOtsGrpInfo = null;
	Map<String,String> rowSetIndiaTaxInfo = null;

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String ofc_cd = "";
	String rhq_cd = "";
	String cnt_cd = "";
	
	
	String s_length_n3pty_bil_tp_cd = JSPUtil.getNull(request.getParameter("s_length_n3pty_bil_tp_cd")).trim();
	int s_length_n3pty_bil_tp_cd_int = 1;    //Sheet Maxinum 갯수
	try {
		s_length_n3pty_bil_tp_cd_int = Integer.parseInt(s_length_n3pty_bil_tp_cd);
	}catch(Exception e) {
		s_length_n3pty_bil_tp_cd_int = 1;
		out.println(e.toString());
	}
	String s_dao_n3pty_no = JSPUtil.getNull(request.getParameter("s_dao_n3pty_no"));
	String s_trd_party_code = JSPUtil.getNull(request.getParameter("s_trd_party_code")); 
	String s_h_vndr_cust_div_cd = JSPUtil.getNull(request.getParameter("s_h_vndr_cust_div_cd")); 
	String currentDay = DateTime.getFormatString("yyyy-MM-dd");

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.Jocasemanage.Joinvoicemanage");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   	ofc_cd = account.getOfc_cd();
	   	//cnt_cd = account.getCnt_cd();
		cnt_cd = JSPUtil.getNull(new CommonCodeBCImpl().getMDMCntCd(ofc_cd)); //2009-05-08 : Office change기능 추가로 인해 cnt_cd는 session이 아닌  TPB 자체적으로 가져오도록 변경한다.

		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsdTpb0126Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		if (eventResponse != null) {
			rowSet = eventResponse.getETCData();
			if(rowSet != null){
				 rowCount = eventResponse.getDataCntList().size();
			} // end if
			rowSetOtsGrpInfo = eventResponse.getETCData();
			if(eventResponse.getETCData() != null && eventResponse.getETCData().size()>0) {
				s_length_n3pty_bil_tp_cd_int = Integer.parseInt(rowSetOtsGrpInfo.get("length_n3pty_bil_tp_cd"));
			}
		} // end if
	}catch(Exception e) {
		out.println(e.toString());
	}
	if(event != null){
		if(event.getAttribute("s_dao_n3pty_no") != null){
			s_dao_n3pty_no = event.getAttribute("s_dao_n3pty_no").toString();
		}
	}

	String[] officeInfo = TPBUtils.getHandleOfficeLevel( ofc_cd ); // 0:Office Level / 1:Office Code / 2:R.HQ Code / 3:HO Code
	// String ofc_lvl = JSPUtil.getNull( officeInfo[0] ); // Office Level 
	rhq_cd  = JSPUtil.getNull( officeInfo[2] ); // RHQ Code  

%>
<html>
<head>
<title>JO TPB Invoice Creation</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<script language="javascript">
<%= JSPUtil.getIBCodeCombo("combo01", "01", "CD00582", 0, "")%>
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
		_text_ChangeUpperCase(); // automatic change to uppercase 
	}
</script>
</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="iPage">
<input type="hidden" name="load_num" value="0">
<input type="hidden" name="s_dao_n3pty_no" value="<%=s_dao_n3pty_no%>">
<input type="hidden" name="s_dao_n3pty_bil_tp_cd">
<input type="hidden" name="s_trd_party_code" value="<%=s_trd_party_code%>">
<input type="hidden" name="s_h_vndr_cust_div_cd" value="<%=s_h_vndr_cust_div_cd%>">
<input type="hidden" name="sdate" value="<%=DateTime.addDays(currentDay, -7, "yyyy-MM-dd")%>">
<input type="hidden" name="edate" value="<%=currentDay%>">
<input type="hidden" name="s_length_n3pty_bil_tp_cd" value="<%=s_length_n3pty_bil_tp_cd%>">
<input type="hidden" name="s_vndr_cnt_cd">
<input type="hidden" name="s_vndr_seq">
<input type="hidden" name="s_cust_cnt_cd">
<input type="hidden" name="s_cust_seq">
<input type="hidden" name="s_sum_inv_amt">
<input type="hidden" name="s_phn_no">
<!-- <input type="hidden" name="s_vndr_cust_addr"> -->
<!-- <input type="hidden" name="s_vndr_cust_nm"> -->
<input type="hidden" name="s_inv_rmk1">
<input type="hidden" name="s_inv_rmk2">
<!-- <input type="hidden" name="s_n3pty_inv_no"> -->
<input type="hidden" name="s_sheet_set_count">
<input type="hidden" name="s_bil_loc">
<input type="hidden" name="s_his_seq">
<input type="hidden" name="s_vndr_cust_eml">
<input type="hidden" name="s_vat_xch_rt">
<input type="hidden" name="s_from_curr_cd">

<input type="hidden" name="s_n3pty_inv_his_seq" value="">

<input type="hidden" name="s_ofc_cd" value="<%=ofc_cd%>">
<input type="hidden" name="s_rhq_cd" value="<%=rhq_cd%>">
<input type="hidden" name="s_cnt_cd" value="<%=cnt_cd%>">

<input type="hidden" name="prcs_cnt">

<input type="hidden" name="s_ida_tax_seq">

<%=JSPUtil.getIncludeString(request) %>

<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>


		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"> Service Management > 3rd Party Billing > JO TPB > JO Invoice Creation</td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;&nbsp;JO Invoice Creation</td></tr>
		</table>
		<%//@include file="/sys/common/menu/jsp/commonHeader.jsp"%>
		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->


		<!-- TABLE '#D' : ( Button : Main ) (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
				<tr><td class="btn1_bg">

						<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<!-- Repeat Pattern -->


							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button" id="btn_confirm_t">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_confirm" id="btn_confirm">Confirm</td><td class="btn1_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button" id="btn_erpInterface_t" style="display:none;">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_erpInterface" id="btn_erpInterface">ERP Interface</td><td class="btn1_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button" id="btn_revisiondetail_t" style="display:none;">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_revisiondetail" id="btn_revisiondetail">Revision Detail</td><td class="btn1_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button" id="btn_preview_t">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_preview" id="btn_preview">Preview</td><td class="btn1_right"></td></tr></table></td>
							<!-- Repeat Pattern -->

						</tr></table>

				</td></tr>
		</table>
    	<!-- TABLE '#D' : ( Button : Main ) (E) -->


		<!-- TABLE '#D' : ( Search Options ) (S) -->
     	<table class="search">
       	<tr><td class="bg">

				<!-- : ( Year ) (S) -->
				<table class="search_in" border="0" bordercolor="red">
				<tr class="h23">
					<td width="75">Invoice No.</td>
					<td width="190"><input name="s_n3pty_inv_no" type="text" class="input2" style="width:95;.background-color:#EEEEEE;" value="" readonly> <input type="text" class="input" style="width:33;.background-color:#EEEEEE;" name="s_n3pty_inv_rmd_cd" value="" readonly></td>
					<td width="70"><img class="nostar">Currency</td>
					<td width="140">
						<select class="input1" style="width:95;" name="s_curr_cd" caption="Currency" onchange='changeCurrency(this.value)'>
						</select>
					</td>
					<td width="190"></td>
					<td width="80">Fax Number</td>
					<td width="180"><input class="input2" type="text" style="width:117;" name="s_fax_no" maxlength="20" readonly></td>
					<!-- <td width="25">VAT</td>  -->
					<td width=""><input type="checkbox" name="s_vat_xch_rt_chk" class="trans" onclick="amtReCalculate();" style="display:none" value="Y"></td>
				</tr>
				</table>
				<!-- : ( Year ) (E) -->
			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->

		<table class="height_10"><tr><td></td></tr></table>


		<!-- TABLE '#D' : ( Search Options ) (S) -->
     	<table class="search">
       	<tr><td class="bg">

				<!-- : ( Year ) (S) -->
				<table border="0" class="grid2">
      				<tr class="tr2_head">
	      				<td width="450">Bill To</td>
	      				<td width="130">Code</td>
	      				<td width="130"><!-- Customer / Service Provider<br> -->Reference</td>
					<td width="132">Due Date</td>
	      				<td width="113">VAT No.</td>
	      			</tr>

      			<tr><!-- <td class="stm" width="170"><textarea name="s_addr" class="noinput"  style="width:100%;height=100;overflow-y:hidden;overflow-x:hidden" readonly></textarea></td> -->
      				<td class="stm" align='right'>
      					<input name="s_usr_inp_ctnt1" type="text" class="" style="width:447"><!-- 1 --><br>
      					<input name="s_vndr_cust_nm" type="text" class="noinput" style="width:447" readonly><!-- vendor / customer name --><br>
      					<input name="s_vndr_cust_addr" type="text" class="" style="width:447" maxlength='100'><br>
      					City : <input name="s_cty_nm" type="text" class="" style="width:120" maxlength='50'><!-- city name 50 -->
      					&nbsp; State : <input name="s_ste_cd" type="text" class="" style="width:45" maxlength='3'><!-- state code 3 -->
      					&nbsp; Zip : <input name="s_zip_cd" type="text" class="" style="width:80" maxlength='10'><!-- zip code 10 --><br>
      					<input name="s_usr_inp_ctnt2" type="text" class="" style="width:447" maxlength='100'><!-- 2 -->
					</td>
      				<td><input name="s_trd_party_code_detail" type="text" class="noinput" style="width:95" readonly></td>
      				<td><!-- <input name="s_vndr_cust_ref_rmk" type="text" class="noinput" style="width:180">
      				 --><textarea name="s_vndr_cust_ref_rmk" class=""  style="width:100%;height=100;overflow-y:auto;overflow-x:auto" onblur="tpb_chkLenByByte(this,50,'Reference')"></textarea></td>
					<!-- * 2009-03-10 O Wan-Ki 1.1 According to CSR-N200903090210, JO - s_rcv_due_dt +60 -->
					<!-- * 2009-03-20 O Wan-Ki 1.2 According to CSR-N200903170220, JO - s_rcv_due_dt +30 -->
					<td><input name="s_rcv_due_dt" type="text" class="noinput" style="width:70" maxlength="10" value="<%=DateTime.addDays(currentDay, 30, "yyyy-MM-dd")%>" data_format="ymd" OnKeyDown="tpb_isNumD(this, 'Y');" onBlur="tpb_validateDateObj(this);"> <img class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar"></td>
      				<td><!-- <input name="s_rgst_no" type="text" class="noinput" style="width:90" maxlength="20">
      				 --><textarea name="s_rgst_no" class=""  style="width:100%;height=100;overflow-y:auto;overflow-x:auto" onblur="tpb_chkLenByByte(this,20,'VAT No.')"></textarea></td></tr>

       			</table>
				<!-- : ( Year ) (E) -->

			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->

<% for(int i=0;i<s_length_n3pty_bil_tp_cd_int;i++){ %>

		<!-- TABLE '#D' : ( Tab ) (S) -->
     	<table><tr><td height="10"></td></tr></table>

       <!-- TABLE '#D' : ( Tab ) (S) Coincidence / Discrepancy / Cost Calculation-->
				
		<table class="tab">
           	<tr><td><script language="javascript">ComTabObject('tab<%=i+1%>')</script></td></tr>
		</table>
		
		<!-- TABLE '#D' : ( Tab ) (E) -->

		<!-- TABLE '#D' : ( Grid ) (S) -->
     	<table class="search">
       	<tr><td class="bg">

				<table class="height_10"><tr><td></td></tr></table>

				<!-- : ( POR ) (S) -->
				<table width="100%" id="mainTable">
		              <tr><td>
		                     <script language="javascript">ComSheetObject('sheet<%=i+1%>');</script>
		              </td></tr>
				</table>
				<!-- : ( POR ) (E) -->




			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Grid ) (E) -->
		<table class="height_10"><tr><td></td></tr></table>

<% } %>
		<!-- TABLE '#D' : ( Search Options ) (S) -->
		<br>
     	<table class="search" style="width: 300">
       	<tr><td class="bg">
				<table border="0" class="grid2" style="width:450">
				<tr><td width="35%" class="tr2_head" align="left"><img class="nostar">Net Amount</td>
					<td class="stm">&nbsp;<input name="s_net_amt" type="text" class="noinput" style="width:95%;text-align:right" readonly></td></tr>
				<tr><td class="tr2_head" align="left"><img class="nostar">Administration Charge</td>
					<td class="stm">&nbsp;<input name="s_add_amt" type="text"  class="noinput" style="width:95%;text-align:right" readonly></td>
				</tr>
				<tr><td class="tr2_head" align="left"><img class="nostar">Deducted Amount</td>
					<td class="stm">&nbsp;<input name="s_ddct_amt" type="text" class="noinput" style="width:95%;text-align:right" readonly></td>
				</tr>
				<tr><td class="tr2_head" align="left"><img class="nostar">VAT Amount</td>
					<td class="stm">&nbsp;<input name="s_vat_amt" type="text" class="noinput" style="width:95%;text-align:right" onclick="this.select()" onblur="amtReCalculate()" readonly></td></tr>
				<tr><td class="tr2_head" align="left"><img class="nostar">Total Amount</td>
					<td class="stm">&nbsp;<input name="s_total_amt" type="text" class="noinput" style="width:95%;text-align:right" readonly></td></tr>
				</table>
			</td></tr>
		</table>
		<br>

     	<table class="search">
       	<tr><td class="bg">

				<!-- : ( Year ) (S) -->
				<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">Descriptions</td></tr>
				<tr><td class="height_5"></td></tr>
				</table>
				<table border="0" class="search" style="width:737";>

      			<tr><td><!-- <input name="s_inv_desc" type="text" class="input" style="width:720;background-color:F3F2F8; border: #F3F2F8"> -->
				<textarea name="s_inv_desc" class="input3"  style="width:977;height=35;overflow-y:auto;overflow-x:auto"
					<%if(cnt_cd.equals("FR")){ %>
					onblur="tpb_chkLenByByte(this,500,'Descriptions')"
					<%} else{ %>
					onblur="tpb_chkLenByByte(this,1000,'Descriptions')"
					<%} %>>
				</textarea>
				</td></tr>

       			</table>
				<!-- : ( Year ) (E) -->
			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->

    </td></tr>
</table>
<!-- Outer Table (E)-->

<div style="display: none">
				<table width="100%" id="mainTable">
		              <tr><td>
		                     <script language="javascript">ComSheetObject('sheet0');</script>
		              </td></tr>
				</table>
</div>


<div id='div_processing' name='div_processing' style='position:absolute; left:0;top:0;z-index:100;display:none;width:100%;height:100%'>
	<table border='0' bordercolor='red' cellpadding='0' cellspacing='0' width='100%' height='100%'>
		<!-- <tr><td align='center'><img src="/hanjin/img/enis/processing.gif"></td></tr>  -->
		<tr><td align='center' height='10'>&nbsp;</td></tr>
		<tr><td align='center' height='100'><img src="/hanjin/img/alps/processing.gif"></td></tr>
		<tr><td align='center' height='*'>&nbsp;</td></tr>
	</table>
</div>

</form>

</body>
</html>

<SCRIPT LANGUAGE="javascript">
<!--
	  /*
		ibSheet 를 제외한 폼 입력값(?) 유저가 입력한 정보를 event를 통해서 다시 넘겨받아 화면에 뿌려주는 부분입니다.
	  */
<% for(int i=0;i<s_length_n3pty_bil_tp_cd_int;i++){ %>
	function sheet<%=i+1%>_OnPopupClick(sheetObj,Row,Col,Value){
		var colName = sheetObj.ColSaveName(Col);
		if(colName == "occr_dt" || colName == "damage_dt"
			|| colName == "lst_free_dt" || colName == "pkup_dt"){
			 var cal = new ComCalendarGrid();
			 cal.select(sheetObj, Row,Col,'yyyy-MM-dd');
		}
		if(colName == "new_vsl_cd"){
			var param = '?sdate='+form.sdate.value+'&edate='+form.edate.value;
			comPopupInSheet('/hanjin/COM_ENS_0B2.do'+ param, 770, 470, 'getVVD_sheet', '1,0,1,1,1,1,1,1',Row,Col);
		}
	}

	function sheet<%=i+1%>_OnChange(sheetObj,Row,Col,Value){
		_sheet_onchange( sheetObj,Row,Col,Value );
		var colName = sheetObj.ColSaveName(Col);
		
		if( colName == "inv_dtl_amt" || colName == "vat_dtl_amt" || colName == "vat_dtl_chk" )
		{
			var prcsCnt = document.all.prcs_cnt.value;
  			var amtPrcs = 1;
  			if( prcsCnt >= 3 ) prcsCnt = 2;
  			for(var j=0;j<prcsCnt;j++)
  			{
  				amtPrcs = amtPrcs * 10;
  			}
  			
	  			
			if(colName == "inv_dtl_amt"){
	
				//Currency Code에 따른 소수점 자리수 반올림 구하기
				var invAmt = sheetObj.CellValue(Row, "inv_dtl_amt");
	  			
	  			var fltAmt = Math.round(invAmt * amtPrcs) / amtPrcs;
	  			sheetObj.CellValue2(Row, "inv_dtl_amt") = fltAmt;
			
			
				//Auto Update 아닐 경우 금액 비교
				if( sheetObj.CellValue(Row, "so_if_seq") == 0 ){
					if(parseFloat(sheetObj.CellValue(Row, "ots_amt")) < parseFloat(sheetObj.CellValue(Row, colName))){
						/** 2009-06-07 O Wan-Ki 1.2 [TPB Restructuring 2단계 (Invoice 부분) 보완/개발]
						 *  Invoice 의 증액가능을 위한 주석처리.  
						ComShowCodeMessage("TPB90032","Invoice AMT","Original AMT"); // 이하
						sheetObj.CellValue2(Row, colName) = sheetObj.CellValue(Row, "original_inv_dtl_amt");
						return;
						 */
					} else if ( parseFloat(sheetObj.CellValue(Row, colName)) <= 0 ) { // 초과
						ComShowCodeMessage("TPB90035","Invoice AMT","0.00");
						sheetObj.CellValue2(Row, colName) = sheetObj.CellValue(Row, "original_inv_dtl_amt");
						return;
					}
				}
				
				var vatXchRt = document.all.s_vat_xch_rt.value;
				var vatChk = sheetObj.CellValue(Row, "vat_dtl_chk");
			
				if( vatChk == 1 )
				{
					sheetObj.CellValue2(Row, "vat_dtl_amt") = Math.round((invAmt * (vatXchRt / 100)) * amtPrcs) / amtPrcs;
				}
			}
			
			if(colName == "vat_dtl_amt")
			{
				var vatAmt = sheetObj.CellValue(Row, "vat_dtl_amt");
	  			var fltAmt = Math.round(vatAmt * amtPrcs) / amtPrcs;
	  			sheetObj.CellValue2(Row, "vat_dtl_amt") = fltAmt;
	  		}
	  		
	  		//Detail VAT 적용 ( 2010-06-04  SELCOL 장병용 부장 요청으로 VAT 적용 로직 변경 )
			if( colName == "vat_dtl_chk" )
			{
				var vatXchRt = document.all.s_vat_xch_rt.value;
				var inv_amt = sheetObj.CellValue(Row, "inv_dtl_amt")
			
				if( Value == 1 )
				{
					sheetObj.CellValue2(Row, "vat_dtl_amt") = Math.round((inv_amt * (vatXchRt / 100)) * amtPrcs) / amtPrcs;
					sheetObj.CellEditable(Row, "vat_dtl_amt") = true;
				}
				else
				{
					sheetObj.CellValue2(Row, "vat_dtl_amt") = 0;
					sheetObj.CellEditable(Row, "vat_dtl_amt") = false;
				}
			}
			
			amtReCalculate();
		}
		//Outstanding Amount 의 Auto Upate check
		tpb_chgColor_ots_amt(sheetObj, 44, 27, Row);
	}
	
	function sheet<%=i+1%>_OnMouseDown(Button, Shift, X, Y){
		var curCol = sheetObjects[<%=i%>].MouseCol;
		var curRow = sheetObjects[<%=i%>].MouseRow;

		if ( curCol == 55 && curRow == 0 && sheetObjects[<%=i%>].CheckAll(55) == 1 )
		{
			sheetObjects[<%=i%>].CheckAll("vat_dtl_chk") == 0;
			
			for ( var idx = 1; idx <= sheetObjects[<%=i%>].RowCount; idx++ )
			{
				sheetObjects[<%=i%>].CellValue(idx, "vat_dtl_chk") = 0;
				sheetObjects[<%=i%>].CellEditable(idx, "vat_dtl_chk") = true;
				sheetObjects[<%=i%>].CellValue(idx, "vat_dtl_chk") = 0;
			}
		}
		else if ( curCol == 55 && curRow == 0 && sheetObjects[<%=i%>].CheckAll(55) == 0 )
		{
			for ( var idx = 1; idx <= sheetObjects[<%=i%>].RowCount; idx++ )
			{
				sheetObjects[<%=i%>].CellValue(idx, "vat_dtl_chk") = 1;
				sheetObjects[<%=i%>].CellEditable(idx, "vat_dtl_chk") = false;
			}
			
			sheetObjects[<%=i%>].CheckAll("vat_dtl_chk") == 1;
		}
	}
	function sheet<%=i+1%>_OnSearchEnd(sheetObj,errMsg){


		if(document.form.s_ofc_cd.value == "ATLSC"      //"ATLBB"
  			|| document.form.s_ofc_cd.value == "ATLSA"  //"ATLSC"
  			|| document.form.s_ofc_cd.value == "CHISC"  //"CHIBB"
  			|| document.form.s_ofc_cd.value == "HOUSC"  //"HOUBB"
  			|| document.form.s_ofc_cd.value == "ILMBS"
  			|| document.form.s_ofc_cd.value == "LGBSC" //"LGBBB"
  			|| document.form.s_ofc_cd.value == "NYCSC" //"NYCBB"
  			|| document.form.s_ofc_cd.value == "ORFSO" //"ORFBS"
  			|| document.form.s_ofc_cd.value == "PDXSO" //"PDXBS"
  			|| document.form.s_ofc_cd.value == "PHXSA" //"PHXSC"
  			|| document.form.s_ofc_cd.value == "SAVSO" //"SAVBS"
  			|| document.form.s_ofc_cd.value == "SEASC" //"SEABB"
  			){
  			for(var i=1;i<sheetObj.Rows;i++){

  				sheetObj.CellEditable(i,"vat_dtl_chk") = false;
  			}
  		}
	}
<% } %>
-->
</SCRIPT>