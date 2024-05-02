<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : ESD_TES_2001.jsp
*@FileTitle : Guarantee Creation & Adjustment
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/02
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.tes.guaranteemanage.guaranteemanage.event.EsdTes2001Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsdTes2001Event  event = null;				//PDTO(Data Transfer Object including Parameters)
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

	String		gnte_no		= JSPUtil.getParameter(request, "gnte_no		".trim(), "");
	String		irr_flg		= JSPUtil.getNull(JSPUtil.getParameter(request, "irr_flg".trim(), ""), "N");
	String		inq_flg		= JSPUtil.getNull(JSPUtil.getParameter(request, "inq_flg".trim(), ""), "N");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();

		event = (EsdTes2001Event)request.getAttribute("Event");
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
<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">
<!-- Container No. 로 Booking No. 입력위한 RowId -->
<input type="hidden" name="rowId" id="rowId">	
<input type="hidden" name="is_valid_gnte_cust_cd" id="is_valid_gnte_cust_cd">
<input type="hidden" name="gnte_cust_cd_hidden" id="gnte_cust_cd_hidden">
<input type="hidden" name="is_valid_vndr_seq" id="is_valid_vndr_seq">
<input type="hidden" name="vndr_seq_hidden" id="vndr_seq_hidden">
<input type="hidden" name="DB_DATE" id="DB_DATE">
<input type="hidden" name="regflag"	id="regflag"	value="Y">
<input type="hidden" name="inq_flg"	id="inq_flg"	value="<%=inq_flg%>">
<input type="hidden" name="irr_flg"	id="irr_flg"	value="<%=irr_flg%>">
<input type="hidden" name="cre_ofc_cd" id="cre_ofc_cd"	value="<%=strOfc_cd%>">
<input type="hidden" name="is_valid_TPB" id="is_valid_TPB">

<!-- DEPART Validation Check Use -->
<input type="hidden" name="is_valid_dept_no" id="is_valid_dept_no">

<!--  Add ofc_cd permission -->
<!--<input type="hidden" name="yd_cd" id="yd_cd" value='___'>-->

<!-- Container Info Select Use	-->
<input type="hidden" name="bkg_no_tmp" id="bkg_no_tmp">
<input type="hidden" name="cntr_no_tmp" id="cntr_no_tmp">
<input type="hidden" name="is_valid_cntr_info" id="is_valid_cntr_info">

<input type="hidden" name="retrieveFlg"	id="retrieveFlg"		value='N'>

<!-- TPB I/F TPB Use BillingCase Code Get Temp ( 2009-09-18 )	-->
<input type="hidden" name="n3pty_bil_tp_cd_tmp"	id="n3pty_bil_tp_cd_tmp"	value="">

<!-- 제목 -->
<div class="page_title_area clear">
		<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
		<!-- page_title(E) -->

		<!-- btn_div -->
	<div class="opus_design_btn">
	    <button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--  
	    --><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!-- 
	    --><button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button><!-- 
	    --><button type="button" class="btn_normal" name="btn_irregular" id="btn_irregular">Irregular</button><!-- 
	    --><button type="button" class="btn_normal" name="btn_tpbif" id="btn_tpbif">TPB I/F</button><!-- 
	    --><button type="button" class="btn_normal" name="btn_delete" id="btn_delete">Delete</button><!-- 
	    --><button type="button" class="btn_normal" name="btn_print" id="btn_print">Print</button>
	</div>

   <!-- page_location(S) -->
   <div class="location">
		<span id="navigation"></span>
   </div>
</div>
<!-- 제목 -->

<div class="wrap_search">
	<div class="opus_design_inquiry wFit">
		<!-- : ( Year ) (S) -->
		<table>
			<tr>
				<th width="105px">Reference Number</th>
				<td width="180px"><input type="text" style="width:100px" name="gnte_no" id="gnte_no" value="<%=gnte_no %>" maxlength="12" OnKeyUp="isApNum2(this)"><!-- 
				 &nbsp;<img class="cursor" src="/opuscntr/img/button/btns_search.gif" width="19px" height="20px" border="0" align="absmiddle" name="btn_refno"> 
				--><button type="button" class="input_seach_btn" name="btn_refno" id="btn_refno"></button>
				</td>
				<th width="100px">Office Code</th>
				<td width="110px"><input type="text" style="width:70px" name="ofc_cd" id="ofc_cd" value="<%=strOfc_cd%>" class="input2" readonly></td>
				<th width="100px">USER ID</th>
				<td width="120px"><input type="text" style="width:75px" name="cre_usr_id" id="cre_usr_id" value="<%=strUsr_id%>" class="input2" readonly></td>
				<th width="110px">Creation Date</th>
				<td width="*"><input type="text" style="width:78px" name="cre_dt" id="cre_dt" class="input2" readonly></td>
			</tr>
		
			<tr>
				<th width="">Type</th>
				<td width="">
					<select name="gnte_tp_cd" id="gnte_tp_cd" OnChange="JavaScript:setTypeCntrDt();">
						<option value="ST">Storage</option>
						<option value="FL">Flip</option>
						<option value="CY">Other</option>
					</select>
				</td>
				<th width="" >Currency Code</th>
				<td width="">
					<select name="curr_cd" id="curr_cd">
						<option value="USD">USD</option>
						<option value="CAD">CAD</option>
					</select>
				</td>
				<th width="" >Booking Status</th>
				<td width="">
					<select name="bkg_sts_cd" id="bkg_sts_cd">
						<option value="F">Firm</option>
						<option value="C">Canceled</option>
					</select>
				</td>
				<th width="">Delete</th>
				<td width=""><input type="text" style="width:30px" name="delt_flg" id="delt_flg" class="input2" readonly></td>
			</tr>
		
			<tr>
				<th width="">CUST CD</th>
				<td width="" colspan="5"><input type="text" style="width:80px" name="gnte_cust_cd" id="gnte_cust_cd" value="" maxlength="8" class='input1' OnKeyUp="isApNum2(this);" !OnKeyDown="isApNum2(this); tes_chkInput(this);" OnBlur="gnte_validatCustomerCode();"><!-- 
				&nbsp;<img class="cursor" src="/opuscntr/img/button/btns_search.gif" width="19px" height="20px" border="0" align="absmiddle" name="btn_custcd"> 
				--><button type="button" class="input_seach_btn" name="btn_custcd" id="btn_custcd"></button><!-- 
				 --><input type="text" style="width:520px" name="gnte_cust_cd_name" id="gnte_cust_cd_name" readonly></td>
				<th width="">Yard Code</th>
				<td width=""><input class="input1" type="text" style="width:68px" name="yd_cd" id="yd_cd" valid="1" title= "Yard Code"  maxlength=7  onKeyUp='tes_isApNum(this);upper(this);' onBlur='gnte_validateYardCode();'><!-- 
					 --><button type="button" name="btn_yard" id="btn_yard" class="input_seach_btn"></button><!-- 
					  --><input type="text" style="width:300px" name="yd_nm" id="yd_nm" class="input2"  readOnly ><!--
					  --><input type="hidden" name="yd_cd_hidden"  id="yd_cd_hidden" value=''><!-- 
					  --><input type="hidden" name="is_valid_yd_cd" id="is_valid_yd_cd" value=''><!-- 
					  --><input type="hidden" name="yd_chr_cd" id="yd_chr_cd" value=''><!-- 
					  --><input type="hidden" name="yd_fcty_tp_mrn_tml_flg" id="yd_fcty_tp_mrn_tml_flg" value=''><!-- 
					  --><input type="hidden" name="yd_fcty_tp_cy_flg" id="yd_fcty_tp_cy_flg" value=''><!-- 
					  --><input type="hidden" name="yd_fcty_tp_cfs_flg" id="yd_fcty_tp_cfs_flg" value=''><!-- 
					  --><input type="hidden" name="yd_fcty_tp_rail_rmp_flg" id="yd_fcty_tp_rail_rmp_flg" value=''><!-- 
					  --><input type="hidden" name="yd_oshp_cd" id="yd_oshp_cd" value=''></td>
			</tr>
			<tr>
				<th width="">S/P</th>
				<td width="" colspan="5"><input type="text" style="width:80px" name="vndr_seq" id="vndr_seq" value="" maxlength="6" class='input1' OnKeyUp="isApNum2(this)" OnKeyDown='tes_chkInput(this);' OnBlur="gnte_validateVndrSeq();"><!--
					 &nbsp;<img class="cursor" src="/opuscntr/img/button/btns_search.gif" width="19px" height="20px" border="0" align="absmiddle" name="btn_vndr">
					 --><button type="button" class="input_seach_btn" name="btn_vndr" id="btn_vndr"></button><!-- 
				 --><input type="text" style="width:520px" name="vndr_seq_name" id="vndr_seq_name" readonly></td>
				<th width="" >Amount</th>
				<td width=""><input type="text" style="width:100px" name="ttl_amt" id="ttl_amt" maxlength="13" class="input2" readonly></td>
			</tr>
			<tr>
				<th width="">Remark</th>
				<td !width="" colspan="7"><textarea name="gnte_rmk" id="gnte_rmk" style="width:858px; height:70px;resize:none;"></textarea></td>
			</tr>
			</table>
			<table>
			<tr>
				<th width="105px" >Container Information</th>
				<td width="" style="text-align:right" >Phone</th>
				<td width=""><input type="text" style="width:100px" name="pic_phn_no" id="pic_phn_no" maxlength="17" OnKeyDown="tes_isNumD(this, '', '-');" OnKeyUp="tes_isNumD(this, '', '-');"></td>
				<td width="">Fax</th>
				<td width=""><input type="text" style="width:100px" name="pic_fax_no" id="pic_fax_no" maxlength="17" OnKeyDown="tes_isNumD(this, '', '-');" OnKeyUp="tes_isNumD(this, '', '-');"></td>
				<td width="">Dept</th>
				<td width=""><input type="text" style="width:250px" name="dept_no" id="dept_no" maxlength="6" OnKeyUp='tes_isApNum(this);upper(this);' OnBlur='gnte_validateOfficeCode();'></td>
			</tr>
		</table>

	</div>
</div>

<div class="wrap_result">
	<div class="opus_design_grid">
	<div class="opus_design_btn">
	   <button type="button" class="btn_normal" name="btng_rowadd" id="btng_rowadd">Row Add</button>
	   <button type="button" class="btn_normal" name="btng_rowdelete" id="btng_rowdelete">Row Delete</button>
	</div>
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<div style='display:none'>
			<script type="text/javascript">ComSheetObject('sheet2');</script>
	</div>	
</div>
<div class="header_fixed"></div>
</form>
