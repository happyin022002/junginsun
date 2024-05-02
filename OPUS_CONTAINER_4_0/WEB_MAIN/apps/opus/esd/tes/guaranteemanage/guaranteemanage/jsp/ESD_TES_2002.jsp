<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : ESD_TES_2002.jsp
*@FileTitle : Guarantee Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/30
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.tes.guaranteemanage.guaranteemanage.event.EsdTes2002Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsdTes2002Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Server Exception 
	String strErrMsg = "";						//Error Message
	int rowCount	 = 0;						//DB ResultSet Count

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	
	Logger log = Logger.getLogger("com.clt.apps.GuaranteeManage.GuaranteeManage");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();

		event = (EsdTes2002Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// To initialize the imported data extracted from the server loading
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="DB_DATE">
<input type="hidden" name="is_valid_gnte_cust_cd" id="is_valid_gnte_cust_cd">
<input type="hidden" name="gnte_cust_cd_hidden" id="gnte_cust_cd_hidden">
<input type="hidden" name="is_valid_vndr_seq" id="is_valid_vndr_seq">
<input type="hidden" name="vndr_seq_hidden" id="vndr_seq_hidden">
<input type="hidden" name="cre_ofc_cd" id="cre_ofc_cd"	value="<%=strOfc_cd%>">
<input type="hidden" name="usr_id" 		value="<%=strUsr_id%>">

<!-- DEPART Validation Check Use -->
<input type="hidden" name="is_valid_ofc_cd" id="is_valid_ofc_cd">
<input type="hidden" name="ofc_cd" id="ofc_cd">

<!-- 제목 -->
<div class="page_title_area clear">
		<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
		<!-- page_title(E) -->

		<!-- btn_div -->
	<div class="opus_design_btn">
	    <button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--  
	    --><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!-- 
	    --><button type="button" class="btn_normal" name="btn_guarantee" id="btn_guarantee">Guarantee</button><!-- 
	    --><button type="button" class="btn_normal" name="btn_irregular" id="btn_irregular">Irregular</button><!-- 
	    --><button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button>
	</div>

   <!-- page_location(S) -->
   <div class="location">
		<span id="navigation"></span>
   </div>
</div>
<!-- 제목 -->

<div class="wrap_search">
	<div class="opus_design_inquiry">
		<table >
			<tbody>
				<colgroup>
					<col width="115"/> 
					<col width="150"/>
					<col width="70"/>
					<col width="80"/>
					<col width="60"/>
					<col width="80"/>
					<col width="40"/>
					<col width="70"/>
					<col width="80"/>
					<col width="*"/>
				</colgroup>
				<tr>
					<th>Reference Number</th>
					<td ><input type="text" style="width:100px" name="gnte_no" id="gnte_no" maxlength="12" dataformat="engup"><!-- 
						 --><button type="button" class="input_seach_btn" name="btn_refno"></button>
					</td>
					<th>Office Code</th>
					<td><input type="text" style="width:70px" name="cost_ofc_cd" value="<%=strOfc_cd%>" maxlength="6" OnKeyUp='tes_isApNum(this);upper(this);' OnBlur='validateDeptNo();'></td>
					<th>USER ID</th>
					<td><input type="text" style="width:75px" name="cre_usr_id" id="cre_usr_id" maxlength="20"></td>
					<th>Type</th>
					<td><select name="gnte_tp_cd" id="gnte_tp_cd">
							<option value=""></option>
							<option value="ST">Storage</option>
							<option value="FL">Flip</option>
							<option value="CY">Other</option>
						</select>
					</td>
					<th>Creation Date</th>
					<td><input type="text" style="width:75px" name="fm_cre_dt" maxlength="10" class="input1" onKeyUp='tes_isNumD(this,"Y"); tes_moveFocus(this,this.form.to_cre_dt,10);' onKeyDown='tes_chkInput(this); tes_isNumD(this,"Y");' OnBlur='this.value=ComGetMaskedValue(this.value, "ymd");'><button type="button" class="calendar" name="btns_calendar1"></button>~&nbsp;<!--  
						 --><input type="text" style="width:75px" name="to_cre_dt" maxlength="10" class="input1" onKeyUp='tes_isNumD(this,"Y"); tes_moveFocus(this,this.form.gnte_cust_cd,10);' onKeyDown='tes_chkInput(this); tes_isNumD(this,"Y");' OnBlur='this.value=ComGetMaskedValue(this.value, "ymd");'><button type="button" class="calendar" name="btns_calendar2"></button>
					</td>
				</tr>
			</tbody>
		</table>


		<table>
			<tbody>
				<colgroup>
					<col width="115"/> 
					<col width="700"/>
					<col width="90"/>
					<col width="*"/>
				</colgroup>
				<tr>
					<th>CUST CD</th>
					<td><input type="text" style="width:120px" name="gnte_cust_cd" id="gnte_cust_cd" value="" maxlength="8"  OnKeyUp="isApNum2(this);" !OnKeyDown="isApNum2(this); tes_chkInput(this);" OnBlur="gnte_validatCustomerCode();"><!-- 
						 --><button type="button" class="input_seach_btn" name="btn_custcd"></button><!-- 
						  --><input type="text" style="width:542px" name="gnte_cust_cd_name" id="gnte_cust_cd_name" readonly></td>
					<th width="">Yard Code</th>
					<td width=""><input type="text" style="width:68px" name="yd_cd" id="yd_cd" valid="1" title= "Yard Code"  maxlength=7  onKeyUp='tes_isApNum(this);upper(this);' onBlur='gnte_validateYardCode();'><!-- 
					 --><button type="button" name="btn_yard" id="btn_yard" class="input_seach_btn"></button><!-- 
					 --><input type="text" style="width:200px" name="yd_nm" id="yd_nm" class="input2"  readOnly ><!--
					 --><input type="hidden" name="yd_cd_hidden"  id="yd_cd_hidden" value=''><!-- 
					  --><input type="hidden" name="is_valid_yd_cd" id="is_valid_yd_cd" value=''>
				</tr>
			</tbody>
		</table>

		<table>
			<tbody>
				<colgroup>
					<col width="115"/> 
					<col width="700"/>
					<col width="90"/>
					<col width="*"/>
				</colgroup>
				<tr>
					<th>S/P</th>
					<td><input type="text" style="width:120px" name="vndr_seq" id="vndr_seq" value="" maxlength="6"  OnKeyUp="isApNum2(this)" OnKeyDown='tes_chkInput(this);' OnBlur="gnte_validateVndrSeq();"><!-- 
						 --><button type="button" class="input_seach_btn" name="btn_vndr"></button><!-- 
						  --><input type="text" style="width:542px" name="vndr_seq_name" id="vndr_seq_name" readonly></td>
					<th>Delete</th>
					<td><select name="delt_flg" id="delt_flg" style="width:50px">
							<option value=""></option>
							<option value="N">N</option>
							<option value="Y">Y</option>
						</select>
					</td>
				</tr>
			</tbody>
		</table>		
	</div>
</div>

<div class="wrap_result">
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>	
	<div class="opus_design_inquiry">
		<table>
			<tbody>
				<colgroup>
					<col width="1"/> 
					<col width="150"/>
					<col width="110"/>
					<col width="150"/>
					<col width="*"/>
				</colgroup>
				<tr>
					<th>Total Count</th>
					<td ><input type="text" style="width:100px" name="ttl_cnt" id="ttl_cnt" class="input2" readonly></td>
					<th >Total Amount</th>
					<td ><input type="text" style="width:100px" name="ttl_amt" id="ttl_amt" class="input2" readonly></td>
					<td> </td>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- <div style='display:'>
	Header Info Grid  (S)
		<script type="text/javascript">ComSheetObject('sheet2');</script>
	Header Info Grid (E)
	</div> -->	
</div>
</form>
