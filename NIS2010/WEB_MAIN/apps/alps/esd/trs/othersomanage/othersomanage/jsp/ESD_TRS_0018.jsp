<%--
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TRS_0018.jsp
*@FileTitle : Other SO 생성화면
*Open Issues :
*Change history :
*@LastModifyDate :2012.01.20
*@LastModifier : 금병주
*@LastVersion : 1.4
* 2009.10.01 kimjin
* 1.0 최초 생성
*----------------------------------------------------------
* History
* 2011.08.31 유선오   1.1 [CHM-201112874] [TRS] OTHER S/O Creation 화면상 오류 수정 요청
* 2011.10.19 유선오   1.2 [CHM-201112874] [TRS] OTHER S/O Creation 화면상 오류 수정 요청
* 2011.10.25 유선오   1.3 [CHM-201112874][TRS] OTHER/SO Creation 화면 상 오류 수정요청 
* 2012.01.20 금병주  1.4  [CHM-201215842] [TRS] Other S/O 상 Cost month 입력 Validation 추가
* 2012.08.03 김종호 [CHM-201219248] [TRS] W/O preview 화면에서 최종 confirm 시 로그인ofc와 S/O지역코드를 비교하기 위한 로직 추가
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.bizcommon.util.BizComUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.trs.othersomanage.othersomanage.event.EsdTrs0018Event"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@page import="java.util.Calendar,java.util.Date,java.text.SimpleDateFormat"%>
<%
	EsdTrs0018Event  event 		= null;			//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg 			= "";			//에러메세지
	SignOnUserAccount account = null;

	try {

		event = (EsdTrs0018Event)request.getAttribute("Event");

		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		account = (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);

	}catch(Exception e) {
		out.println(e.toString());
	}
	String costModeCd   = JSPUtil.getCodeCombo("trs_cost_md_cd", "01", "style='width:140' OnChange='resetSearchCondition(this)'", "CD00744", 0, "000020::");
	String transModeCd  = JSPUtil.getCodeCombo("trs_md_cd", "01", "style='width:74' OnChange='resetSearchCondition(this)'", "CD00283", 0, "000010::");
	String cagoTpCd  = JSPUtil.getCodeCombo("trs_cago_tp_cd", "01", "style='width:70' disabled", "CD00748", 0, "000010::");
	String wgtCd  = JSPUtil.getCodeCombo("trs_wgt_cd", "01", "style='width:62' ", "CD00775", 0, "000010::");
	String bndCd  = JSPUtil.getCodeCombo("trs_bnd_cd", "01", "style='width:125' ", "CD00591", 0, "000010::");
	String cntCd  = JSPUtil.getCodeCombo("trs_cnt_cd", "01", "style='width:70' ", "CD00919", 0, "000010::");
	
	//2012.01.20 chkYM 추가 kbj
	Calendar c = Calendar.getInstance();
	c.add(Calendar.MONTH,1); 
	Date d = c.getTime();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
	String chkYM = sdf.format(d);
%>

<html>
<head>
<title>Other SO Creation</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">

	<%=BizComUtil.getIBCodeCombo("default_curr", "01", "CURR", 1, "")%>

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
		setKindEnabled();
	}
</script>
</head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input	type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="TRSP_SO_VNDR_NO">
<input type="hidden" name="TRSP_SO_TP_CD">
<input type="hidden" name="TRSP_SO_STS_CD">
<input type="hidden" name="TRSP_EQ_KND_CD">
<input type="hidden" name="TRSP_SO_EQ_KIND">
<input type="hidden" name="EQ_TPSZ_CD">
<input type="hidden" name="INPUT_CUST_CD">
<input type="hidden" name="INPUT_CUST_NM">
<input type="hidden" name="TRSP_SO_COST_MONTH">
<input type="hidden" name="FORM_CRE_USR_ID" value="<%=account.getUsr_id()%>">
<input type="hidden" name="FORM_USR_OFC_CD" value="<%=account.getOfc_cd()%>">
<input type="hidden" name="SURCHARGE_WO_GRS_WGT_MEAS_UT_CD">
<input type="hidden" name="trsp_so_no">

<!-- cost month validate를 위한 ckeck용 yyyymm -->
<input type="hidden" name="chkYM" value="<%=chkYM%>">

<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>
 

		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->


		<!-- TABLE '#D' : ( Button : Main ) (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
	       	<tr><td class="btn1_bg">

				<table border="0" cellpadding="0" cellspacing="0">
				<tr>
					<!-- Repeat Pattern -->
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" id="btn_add" name="btn_add">Add</td><td class="btn1_right"></td></tr></table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" id="btn_reset" name="btn_reset">Reset</td><td class="btn1_right"></td></tr></table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" id="btn_minimize" name="btn_minimize">Minimize</td><td class="btn1_right"></td></tr></table></td>
					<!-- Repeat Pattern -->

				</tr></table>

			</td></tr>
		</table>
    	<!-- TABLE '#D' : ( Button : Main ) (E) -->



        <div id="MiniLayer" style="display:inline">




	<!-- TABLE '#D' : ( Search Options ) (S) -->
  	<table class="search">
       	<tr><td class="bg">

				<!-- : ( Year ) (S) -->
				<table class="search_in" border="0">
				<tr class="h23">

					<td width="110">Quantity</td>
					<td width="160"><input type="text" style="width:70; " name='otherso_qty' onChange='checkNumber(this, true);'maxlength=4></td>
					<td width="100">Cost Mode</td>
					<td width="168"><%=costModeCd%></td>
					<td width="112">Trans Mode</td>
					<td width="102"><%=transModeCd%></td>
					<td width="76">Bound</td>
					<td><%=bndCd%></td>
				</tr>
				</table>

				<table class="search_in" border="0">
				<tr class="h23">
					<td width="110">Cargo Type</td>
					<td width="160"><%=cagoTpCd%></td>
					<td width="100">Weight</td>
					<td width="78"><input type="text" style="width:74" name='cntr_wgt'></td>
					<td width="90"><%=wgtCd%></td>
					<td width="112">Commodity Code</td>
					<td><input type="text" name='commodity_cd'  style="width:74" onChange='getTextCmdtCd(sheetObjects[0], document.form, this.value)' onKeyup='enterCheck(this)'>
						<input type="text" style="width:226;" name='commodity_nm' readOnly class="input2">
						<img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name='btng_commodity'></td>
				</tr>
				</table>

				<table class="search_in" border="0">
				<tr class="h23">
					<td width="110">SML / CNT</td>
					<td width="160"><%=cntCd%></td>
					<td width="100">Customer Code</td>
					<td width="381"><input type="text" style="width:74" name="input_cust_cd" onChange='getTextCustCd(sheetObjects[0], document.form, this.value)' onBlur='value_upper(this)'  onKeyup='enterCheck(this)'>
									<input type="text" style="width:252;" name="input_cust_nm"  readOnly class="input2"><img src="/hanjin/img/blank.gif" width="4" height="1" border="0"><img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name='btng_customer'></td>
					<td width="77">Cost Month</td>
					<td class="sm"><input type="text" style="width:90" name='trsp_otr_cost_mon_dt' onBlur="BlurDate(this)"maxlength=6>&nbsp;<font color="red"><strong>(YYYYMM)</strong></font></td></tr>
				</table>

				<table class="search_in" border="0">
						<tr class="h23">
							<td width="110">From</td>
							<td width="76"><input name="search_fm_loc" type="text" style="width:70;" maxlength="5" onFocus='fun_Focus(this)' onChange="getComboList(this, document.search_fm_yard, 'F');" onBlur=""  ></td>
							<td width="84"><script language="javascript">ComComboObject('search_fm_yard', 1, 45, 0);</script><img src="/hanjin/img/blank.gif" width="4" height="1" border="0"><img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name='btn_fm_node'></td>
							<td width="100">Via</td>
							<td width="80"><input name="search_via_loc" type="text" style="width:74;" maxlength="5" onFocus='fun_Focus(this)' onChange="getComboList(this, document.form.search_via_yard, 'V');" onBlur=""></td>
							<td width="90"><script language="javascript">ComComboObject('search_via_yard', 1, 45, 0);</script><img src="/hanjin/img/blank.gif" width="4" height="1" border="0"><img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name='btn_via_node'></td>
							<td width="36">To</td>
							<td width="76"><input name="search_to_loc" type="text" style="width:70;" maxlength="5" onFocus='fun_Focus(this)' onChange="getComboList(this, document.form.search_to_yard, 'T');"  onBlur=""></td>
							<td width="99"><script language="javascript">ComComboObject('search_to_yard', 1, 50, 0);</script><img src="/hanjin/img/blank.gif" width="4" height="1" border="0"><img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name='btn_to_node'></td>
							<td width="77">Door</td>
							<td width="73"><input name="search_dr_loc" type="text" style="width:69;" maxlength="5" onFocus='fun_Focus(this)' onChange="getComboList(this, document.form.search_door_yard, 'D');"  onBlur=""></td>
							<td align="right"><script language="javascript">ComComboObject('search_dr_yard', 1, 52, 0);</script><img src="/hanjin/img/blank.gif" width="4" height="1" border="0"><img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name='btn_dr_node'></td>
						</tr>
				</table>

			<table class="search_in" border="0">
				<tr class="h23">
					<td width="110">Actual Customer</td>
					<td width="430">
						<input type="text" style="width:70;" name='act_cust_cd' onBlur='getActualCustomerName();' onKeyup='value_upper(this)'>
						<input type="text" style="width:260;" name='search_act_cust' readOnly class="input2"><img src="/hanjin/img/blank.gif" width="4" height="1" border="0"><img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name='btn_act_cus'></td>
					<td width="140">Door Delivery Address</td>
					<td><input type="text" style="width:100%;" name='door_delv_addr'>
						<input type="hidden" name='act_cust_addr_seq'>
						<input type="hidden" name='fctry_nm'>
						<input type="hidden" name='cntc_pson_nm'>
						<input type="hidden" name='cntc_pson_phn_no'>
						<input type="hidden" name='cntc_pson_fax_no'>
					</td>
				</tr>
			</table>
			<table class="search_in" border="0">
				<tr class="h23">
					<td width="110">Service Provider</td>
					<td width="430">
						<input type='text' name='combo_svc_provider'  style="width:70;" onChange='getTextVendorSeq(sheetObjects[0], document.form, this.value)' onKeyup='enterCheck(this)'>
						<input type="text" style="width:260;" name='svc_provider' readOnly class="input2"><img src="/hanjin/img/blank.gif" width="4" height="1" border="0"><img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name='btng_provider'></td>
					<td width="140">Reason</td>
					<td><input type="text" style="width:100%;" name='otherso_reason'></td>
				</tr>
			</table>




				<!-- : ( Year ) (E) -->


			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->
	   </div>


		<table class="height_10"><tr><td></td></tr></table>


		<!-- TABLE '#D' : ( Search Options ) (S) -->
     	<table class="search">
       	<tr><td class="bg">

				<!-- : ( Seq. ) (S) -->
                    <table width="100%" id="mainTable">
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet');</script>
                        </td></tr>
                    </table>
					<table id="soCreationTable">
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet1');</script>
                        </td></tr>
                    </table>
					<table id="hiddenTable">
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet2');</script>
                        </td></tr>
                   </table>
					<table id="hiddenTable2">
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet3');</script>
                        </td></tr>
                    </table>
					<table id="hiddenTable3">
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet4');</script>
                        </td></tr>
                    </table>
					<table id="hiddenTable4">
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet5');</script>
                        </td></tr>
                    </table>
                    <table id="hiddenTable5">
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet6');</script>
                        </td></tr>
                    </table>
				<!-- : ( Seq. ) (E) -->

				<!-- : ( Button : Grid ) (S) -->
				<table width="100%" class="button">
			       	<tr><td class="btn2_bg">
					<table border="0" cellpadding="0" cellspacing="0">
					<tr>

						<!-- Repeat Pattern -->
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td><td class="btn2" id="btng_fillineq" name="btng_fillineq">Fill In EQ No.</td><td class="btn2_right"></td></tr></table></td>

						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td><td class="btn2" id="btng_rateapply" name="btng_rateapply">Rate Apply</td><td class="btn2_right"></td></tr></table></td>

						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td><td class="btn2" id="btng_downexcel" name="btng_downexcel">Down Excel</td><td class="btn2_right"></td></tr></table></td>

						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td><td class="btn2" id="btng_socreation" name="btng_socreation">S/O Creation</td><td class="btn2_right"></td></tr></table></td>

						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td><td class="btn2" id="btng_wopreview" name="btng_wopreview">W/O Preview</td><td class="btn2_right"></td></tr></table></td>
						<!-- Repeat Pattern -->


					</tr></table>
				</td></tr>
				</table>
		    	<!-- : ( Button : Grid ) (E) -->

			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->



     	<!-- ####### TABLE '#D' ::: 'RIGHT' FRAME (END) ####### -->


	</td></tr>
</table>
<!-- TABLE '#B' : 'Left + Right Body' Table (E)nd -->
<!-- ################# TABLE '#B' ::: 'LEFT + RIGHT' FRAME (END) ################## -->


</td>
</tr>
</table>
<!-- OUTER FRAME : "to make sum of components' HEIGHTS 100%" (E)nd -->

</form>

<form name='woForm' method='POST' action='ESD_TRS_0024.screen'>
<input type='hidden' name='trsp_so_ofc_cty_cd'>
<input type='hidden' name='trsp_so_seq'>
<input type='hidden' name='vndr_seq'>
<input type='hidden' name='eq_mode' value='OT'>
<input	type="hidden" name="sysCommUiTitle" value="Preview">
<input	type="hidden" name="sysCommUiNavigation" value="Trans S/O > Work Order">
<input type="hidden" name="trsp_so_no">
</form>

</body>
</html>
