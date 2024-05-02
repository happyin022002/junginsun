<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : fns_inv_0033.jsp
*@FileTitle : Invoice Split After Invoice Issue
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.22
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2009.09.22 최도순
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
<%@ page import="com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.event.FnsInv0033Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	FnsInv0033Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String loginOfcCd = "";
	Logger log = Logger.getLogger("com.hanjin.apps.AccountReceivableInvoiceMgt.ARInvoiceCorrection");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		loginOfcCd = account.getOfc_cd();	
	   
	   
		event = (FnsInv0033Event)request.getAttribute("Event");
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
<title>Invoice Split After Invoice Issue</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="/hanjin/rpt/script/rdviewer50.js"></script>
<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="pagetype" value = "">
<input type="hidden" name="ofc">
<input type="hidden" name="ofc_cd">
<input type="hidden" name="cust_cnt_cd">
<input type="hidden" name="cust_seq">
<input type="hidden" name="svr_id">
<input type="hidden" name="ar_ofc_cd2">
<input type="hidden" name="inv_nos">
<input type="hidden" name="bl_nos">
<input type="hidden" name="user_nm" value="<%=strUsr_nm%>">
<input type="hidden" name="bnd" value="A">
<input type="hidden" name="max_seq">
<input type="hidden" name="frm_sail_dt">
<input type="hidden" name="if_no">
<input type="hidden" name="cancel_if_no">

<input type="hidden" name="user_id" value="<%=strUsr_id%>">
<input type="hidden" name="if_user_id" >
<input type="hidden" name="invs_email">
<input type="hidden" name="state">
<input type="hidden" name="ots_smry_cd">
<input type="hidden" name="inv_dup_flg">
<input type="hidden" name="inv_mlt_bl_iss_flg">
<input type="hidden" name="backendjob_key">
<input type="hidden" name="email_flag" value="N">
<input type="hidden" name="login_ofc_cd" value="<%=loginOfcCd%>">
<input type="hidden" name="print_nm">
<!-- 개발자 작업	-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
	<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
	<!--Page Title, Historical (E)-->
<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">
				<!-- biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="80">Invoice No.</td>
					<td width="130"><input type="text" style="width:120;" class="input1" name="inv_no" dataformat="uppernum" maxlength="17"></td> 					
					<td width="55">B/L No.</td>
					<td width="120"><input type="text" style="width:100;" class="input2" name="frm_bl_src_no" readOnly></td> 
					<td width="60">BKG No.</td>
					<td width="140"><input type="text" style="width:100;" class="input2" name="frm_bkg_no" readOnly></td>
					<td width="70">No. of Split</td>
					<td width="50"><input type="text" style="width:25;" class="input1" name="split_cnt" dataformat="num" maxlength="2"></td> 
					<td width="50">Office</td>   
					<td><script language="javascript">ComComboObject('ar_ofc_cd', 1, 100, 1, 1);</script></td></tr>
				</tr>
					<tr class="h23">
						<td width="">Issue Date</td>
						<td width=""><input type="text" class="input2" style="width:120;" name="frm_iss_dt" readOnly dataformat="ymd"></td>
						<td width="">VVD</td>
						<td width=""><input type="text" class="input2" style="width:100;" name="frm_local_vvd" readOnly></td>
						<td width="">Port CD</td>
						<td width=""><input type="text" class="input2" style="width:100;" name="frm_port_cd" readOnly></td>
						<td width="">S/A Date</td>
						<td width=""><input type="text" class="input2" style="width:100;" name="frm_sail_arr_dt" readOnly dataformat="ymd"></td>
						<td width="">Bound</td>
						<td width=""><input type="text" class="input2" style="width:100;" name="frm_io_bnd_cd" readOnly></td>
					</tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="80">Actual Cust.</td>
					<td width="385"><input type="text" style="width:30;" class="input2" name="frm_act_cust_cnt_cd" readOnly>&nbsp;<input type="text" style="width:65;" class="input2" name="frm_act_cust_seq" readOnly>&nbsp;<img src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor" name="btn_frmactcust">&nbsp;<input type="text" style="width:223;" class="input2" name="frm_cust_nm" readOnly></td> 
					<td width="70">INV Cust.</td>
					<td width="150"><input type="text" style="width:30;" class="input2" name="frm_inv_cust_cnt_cd" readOnly>&nbsp;<input type="text" style="width:65;" class="input2" name="frm_inv_cust_seq"></td> 
					<td width="78">TEU/FEU</td> 
					<td><input type="text" style="width:47;" class="input2" name="frm_bkg_teu_qty" readonly>&nbsp;<input type="text" style="width:47;" class="input2" name="frm_bkg_feu_qty" value="" readonly>&nbsp;<img src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor" name="btn_container"></td></tr>
				</table>	
				
				 
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="665">
						<!--grid (S)-->
							<table width="100%" class="search"  id="mainTable"> 
								<tr>
									<td width="100%">
										<script language="javascript">ComSheetObject('sheet1');</script>
										<script language="javascript">ComSheetObject('sheet2');</script>
										<script language="javascript">ComSheetObject('sheet3');</script>
										<script language="javascript">ComSheetObject('sheet4');</script>
									</td>
								</tr>
							</table> 
						<!--grid (E)-->
	
						</td>
						<td width="19"></td>
						<td width="" valign="top">
							<table class="search" border="0" style="width:;"> 
								<tr class="h23">
									<td width="60">RFA No.</td>
									<td width=""><input type="text" style="width:97;" class="input2" name="frm_rfa_no" readOnly>&nbsp;<img src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor" name="btn_rfano"></td> </tr>
								<tr class="h23">
									<td width="">S/C No.</td>
									<td width=""><input type="text" style="width:97;" class="input2" name="frm_sc_no" readOnly>&nbsp;<img src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor" name="btn_scno"></td> 
								</tr>
								<tr class="h23">
									<td height="20"></td>
								</tr>
								<tr class="h23">
									<td width="80" valign="top">Master Total</td>
									<td valign="top">
										<div id="mst_sum"></div>
									</td>
								</tr>
							</table>
						
						</td>
					</tr>
				</table>
				
		</td></tr>
		</table>
		<table class="height_8"><tr><td></td></tr></table>
		
		
		<!-- Tab ) (S) -->
     	<table class="tab" border="0" cellpadding="0" cellspacing="0" width=100%> 
       			<tr><td width="100%">
				<script language="javascript">ComTabObject('tab1')</script>
			</td></tr>
		</table>
		<!-- Tab ) (E) --> 	

		<table class="search"> 
       	<tr><td class="bg">


		<div id="tabLayer" style="display:none">

		<!-- TAB General (s) -->	

		<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
						<td width="480"> 
						  	<table class="search" border="0" style="width:480;"> 
								<tr class="h23">
									<td width="80">Actual Cust.</td>
									<td width=""><input type="text" style="width:30;" class="input1" name="act_cust_cnt_cd" onblur="fn_act_cust_chg();" style="ime-mode:disabled" onKeyPress="ComKeyOnlyAlphabet('upper')" maxlength="2"  onKeyUp = "javascript:checkCustLeng(this.value)">&nbsp;<input type="text" style="width:65;" class="input1" name="act_cust_seq" onblur="fn_act_cust_chg();" value="" maxlength="6" dataformat="num">&nbsp;<img src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor" name="btn_actcust">&nbsp;<input type="text" style="width:242;" class="input2" name="cust_lgl_eng_nm" readOnly>&nbsp;<img src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"  name="btn_custNm"></td> 
						  		</tr>	
							</table>
							<table class="search" border="0" style="width:480;"> 
								<tr class="h23">
									<td width="80">TEU/FEU</td>
									<td width=""><input type="text" style="width:48;" class="input2" name="bkg_teu_qty" readOnly>&nbsp;<input type="text" style="width:47;" class="input2" name="bkg_feu_qty" readOnly>&nbsp;<img src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor" name="btn_container_e"></td> 
						  		</tr>	
							</table>
							<table class="search" border="0" style="width:480;"> 
								<tr class="h23">
									<td width="80">INV Ref. No.</td>
									<td width="200"><input type="text" style="width:123;" class="input" name="inv_ref_no"></td> 
									<td width="60">SML Ref. </td>
									<td width=""><input type="text" style="width:130;" class="input" name="hjs_stf_ctnt"></td> 
						  		</tr>	
							</table>
							<table class="search" border="0" style="width:480;"> 
								<tr class="h23">
									<td width="80">Description</td>
									<td width=""><input type="text" style="width:390;" class="input" name="inv_rmk"></td> 
						  		</tr>	
							</table>
						  
						</td>
						<td width="19"> </td>
						<td width="480">
						
					<!--grid (S)-->
					<table width="100%" class="search"  id="mainTable"> 
						<tr>
							<td width="100%">
							<script language="javascript">ComSheetObject('t0sheet1');</script>
							</td>
						</tr>
					</table> 					
					<!--grid (E)-->
						
						
						
						 </td>
						</tr>	
				</table>
			
		<!-- Tab BG Box(E) -->

		</div>

		<div id="tabLayer" style="display:none">
		<!-- TAB General (s) -->	

		<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
						<td width="480"> 
						  	<table class="search" border="0" style="width:480;"> 
								<tr class="h23">
									<td width="80">Actual Cust.</td>
									<td width=""><input type="text" style="width:30;" class="input1" name="act_cust_cnt_cd" onblur="fn_act_cust_chg();" style="ime-mode:disabled" onKeyPress="ComKeyOnlyAlphabet('upper')" maxlength="2"  onKeyUp = "javascript:checkCustLeng(this.value)">&nbsp;<input type="text" style="width:65;" class="input1" name="act_cust_seq" onblur="fn_act_cust_chg();" value="" maxlength="6" dataformat="num">&nbsp;<img src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor" name="btn_actcust">&nbsp;<input type="text" style="width:242;" class="input2" name="cust_lgl_eng_nm" readOnly>&nbsp;<img src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"  name="btn_custNm"></td> 
						  		</tr>	
							</table>
							<table class="search" border="0" style="width:480;"> 
								<tr class="h23">
									<td width="80">TEU/FEU</td>
									<td width=""><input type="text" style="width:48;" class="input2" name="bkg_teu_qty" readOnly>&nbsp;<input type="text" style="width:47;" class="input2" name="bkg_feu_qty" readOnly>&nbsp;<img src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor" name="btn_container_e"></td> 
						  		</tr>	
							</table>
							<table class="search" border="0" style="width:480;"> 
								<tr class="h23">
									<td width="80">INV Ref. No.</td>
									<td width="200"><input type="text" style="width:123;" class="input" name="inv_ref_no"></td> 
									<td width="60">SML Ref. </td>
									<td width=""><input type="text" style="width:130;" class="input" name="hjs_stf_ctnt"></td> 
						  		</tr>	
							</table>
							<table class="search" border="0" style="width:480;"> 
								<tr class="h23">
									<td width="80">Description</td>
									<td width=""><input type="text" style="width:390;" class="input" name="inv_rmk"></td> 
						  		</tr>	
							</table>
						  
						</td>
						<td width="19"> </td>
						<td width="480">
						
					<!--grid (S)-->
					<table width="100%" class="search"  id="mainTable"> 
						<tr>
							<td width="100%">
							<script language="javascript">ComSheetObject('t1sheet1');</script>
							</td>
						</tr>
					</table> 					
					<!--grid (E)-->
						
						
						
						 </td>
						</tr>	
				</table>
			
		<!-- Tab BG Box(E) -->
		</div>
		<div id="tabLayer" style="display:none">
		<!-- TAB General (s) -->	

		<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
						<td width="480"> 
						  	<table class="search" border="0" style="width:480;"> 
								<tr class="h23">
									<td width="80">Actual Cust.</td>
									<td width=""><input type="text" style="width:30;" class="input1" name="act_cust_cnt_cd" onblur="fn_act_cust_chg();" style="ime-mode:disabled" onKeyPress="ComKeyOnlyAlphabet('upper')" maxlength="2"  onKeyUp = "javascript:checkCustLeng(this.value)">&nbsp;<input type="text" style="width:65;" class="input1" name="act_cust_seq" onblur="fn_act_cust_chg();" value="" maxlength="6" dataformat="num">&nbsp;<img src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor" name="btn_actcust">&nbsp;<input type="text" style="width:242;" class="input2" name="cust_lgl_eng_nm" readOnly>&nbsp;<img src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"  name="btn_custNm"></td> 
						  		</tr>	
							</table>
							<table class="search" border="0" style="width:480;"> 
								<tr class="h23">
									<td width="80">TEU/FEU</td>
									<td width=""><input type="text" style="width:48;" class="input2" name="bkg_teu_qty" readOnly>&nbsp;<input type="text" style="width:47;" class="input2" name="bkg_feu_qty" readOnly>&nbsp;<img src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor" name="btn_container_e"></td> 
						  		</tr>	
							</table>
							<table class="search" border="0" style="width:480;"> 
								<tr class="h23">
									<td width="80">INV Ref. No.</td>
									<td width="200"><input type="text" style="width:123;" class="input" name="inv_ref_no"></td> 
									<td width="60">SML Ref. </td>
									<td width=""><input type="text" style="width:130;" class="input" name="hjs_stf_ctnt"></td> 
						  		</tr>	
							</table>
							<table class="search" border="0" style="width:480;"> 
								<tr class="h23">
									<td width="80">Description</td>
									<td width=""><input type="text" style="width:390;" class="input" name="inv_rmk"></td> 
						  		</tr>	
							</table>
						  
						</td>
						<td width="19"> </td>
						<td width="480">
						
					<!--grid (S)-->
					<table width="100%" class="search"  id="mainTable"> 
						<tr>
							<td width="100%">
							<script language="javascript">ComSheetObject('t2sheet1');</script>
							</td>
						</tr>
					</table> 					
					<!--grid (E)-->
						
						
						
						 </td>
						</tr>	
				</table>
			
		<!-- Tab BG Box(E) -->
		</div>
		<div id="tabLayer" style="display:none">
		<!-- TAB General (s) -->	

		<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
						<td width="480"> 
						  	<table class="search" border="0" style="width:480;"> 
								<tr class="h23">
									<td width="80">Actual Cust.</td>
									<td width=""><input type="text" style="width:30;" class="input1" name="act_cust_cnt_cd" onblur="fn_act_cust_chg();" style="ime-mode:disabled" onKeyPress="ComKeyOnlyAlphabet('upper')" maxlength="2"  onKeyUp = "javascript:checkCustLeng(this.value)">&nbsp;<input type="text" style="width:65;" class="input1" name="act_cust_seq" onblur="fn_act_cust_chg();" value="" maxlength="6" dataformat="num">&nbsp;<img src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor" name="btn_actcust">&nbsp;<input type="text" style="width:242;" class="input2" name="cust_lgl_eng_nm" readOnly>&nbsp;<img src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"  name="btn_custNm"></td> 
						  		</tr>	
							</table>
							<table class="search" border="0" style="width:480;"> 
								<tr class="h23">
									<td width="80">TEU/FEU</td>
									<td width=""><input type="text" style="width:48;" class="input2" name="bkg_teu_qty" readOnly>&nbsp;<input type="text" style="width:47;" class="input2" name="bkg_feu_qty" readOnly>&nbsp;<img src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor" name="btn_container_e"></td> 
						  		</tr>	
							</table>
							<table class="search" border="0" style="width:480;"> 
								<tr class="h23">
									<td width="80">INV Ref. No.</td>
									<td width="200"><input type="text" style="width:123;" class="input" name="inv_ref_no"></td> 
									<td width="60">SML Ref. </td>
									<td width=""><input type="text" style="width:130;" class="input" name="hjs_stf_ctnt"></td> 
						  		</tr>	
							</table>
							<table class="search" border="0" style="width:480;"> 
								<tr class="h23">
									<td width="80">Description</td>
									<td width=""><input type="text" style="width:390;" class="input" name="inv_rmk"></td> 
						  		</tr>	
							</table>
						  
						</td>
						<td width="19"> </td>
						<td width="480">
						
					<!--grid (S)-->
					<table width="100%" class="search"  id="mainTable"> 
						<tr>
							<td width="100%">
							<script language="javascript">ComSheetObject('t3sheet1');</script>
							</td>
						</tr>
					</table> 					
					<!--grid (E)-->
						
						
						
						 </td>
						</tr>	
				</table>
			
		<!-- Tab BG Box(E) -->
		</div>
		<div id="tabLayer" style="display:none">
		<!-- TAB General (s) -->	

		<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
						<td width="480"> 
						  	<table class="search" border="0" style="width:480;"> 
								<tr class="h23">
									<td width="80">Actual Cust.</td>
									<td width=""><input type="text" style="width:30;" class="input1" name="act_cust_cnt_cd" onblur="fn_act_cust_chg();" style="ime-mode:disabled" onKeyPress="ComKeyOnlyAlphabet('upper')" maxlength="2"  onKeyUp = "javascript:checkCustLeng(this.value)">&nbsp;<input type="text" style="width:65;" class="input1" name="act_cust_seq" onblur="fn_act_cust_chg();" value="" maxlength="6" dataformat="num">&nbsp;<img src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor" name="btn_actcust">&nbsp;<input type="text" style="width:242;" class="input2" name="cust_lgl_eng_nm" readOnly>&nbsp;<img src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"  name="btn_custNm"></td> 
						  		</tr>	
							</table>
							<table class="search" border="0" style="width:480;"> 
								<tr class="h23">
									<td width="80">TEU/FEU</td>
									<td width=""><input type="text" style="width:48;" class="input2" name="bkg_teu_qty" readOnly>&nbsp;<input type="text" style="width:47;" class="input2" name="bkg_feu_qty" readOnly>&nbsp;<img src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor" name="btn_container_e"></td> 
						  		</tr>	
							</table>
							<table class="search" border="0" style="width:480;"> 
								<tr class="h23">
									<td width="80">INV Ref. No.</td>
									<td width="200"><input type="text" style="width:123;" class="input" name="inv_ref_no"></td> 
									<td width="60">SML Ref. </td>
									<td width=""><input type="text" style="width:130;" class="input" name="hjs_stf_ctnt"></td> 
						  		</tr>	
							</table>
							<table class="search" border="0" style="width:480;"> 
								<tr class="h23">
									<td width="80">Description</td>
									<td width=""><input type="text" style="width:390;" class="input" name="inv_rmk"></td> 
						  		</tr>	
							</table>
						  
						</td>
						<td width="19"> </td>
						<td width="480">
						
					<!--grid (S)-->
					<table width="100%" class="search"  id="mainTable"> 
						<tr>
							<td width="100%">
							<script language="javascript">ComSheetObject('t4sheet1');</script>
							</td>
						</tr>
					</table> 					
					<!--grid (E)-->
						
						
						
						 </td>
						</tr>	
				</table>
			
		<!-- Tab BG Box(E) -->
		</div>
		
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
				
				<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">BKG Customer Info.</td></tr>
				</table>
				
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="70">Shpr/Cnee</td>
						<td width="710"><input type="text" style="width:30;" class="input2" name="frm_shpr_cust_cnt_cd" readOnly>&nbsp;<input type="text" style="width:65;" class="input2" name="frm_shpr_cust_seq" readOnly>&nbsp;<input type="text" style="width:400;" class="input2" name="frm_shpr_cust_nm" readOnly>&nbsp;<img src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor" name="btn_shprcust"></td> 
						
						<td width="70" valign="top">Split Total</td>
						<td width="" rowspan="2" valign="top" >
							<div id="split_sum"></div>
						</td>
					</tr>	
					<tr class="h23">
						<td width="">Fwdr/Ntfy</td>
						<td width=""><input type="text" style="width:30;" class="input2" name="frm_fwdr_cust_cnt_cd" readOnly>&nbsp;<input type="text" style="width:65;" class="input2" name="frm_fwdr_cust_seq" readOnly>&nbsp;<input type="text" style="width:400;" class="input2" name="frm_fwdr_cust_nm" readOnly>&nbsp;<img src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor" name="btn_fwdrcust"></td> 
						
						</tr>	
				</table>
				
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="80">Invoice No.</td>
						<td width="300"><input type="text" style="width:100;" class="input2" name="f_inv">&nbsp;~&nbsp;<input type="text" style="width:100;" class="input2" name="t_inv"></td> 
						<td width="130">Total Invoice Count</td>
						<td width="150"><input type="text" style="width:100;" class="input2" name="tot_inv_cnt"></td> 
						<td width="150">Number of copy invoice</td>
						<td width=""><input type="text" style="width:100;" class="input" name="copy_cnt"></td> 
						 </tr>	
				</table>
		</td></tr>
		</table>
			<script language="javascript">ComSheetObject('s0sheet1');</script>	
			<script language="javascript">ComSheetObject('s0sheet2');</script>	
			<script language="javascript">ComSheetObject('s0sheet3');</script>	
			<script language="javascript">ComSheetObject('s0sheet4');</script>	
			<script language="javascript">ComSheetObject('s0sheet5');</script>			
	<!--biz page (E)-->

			</td></tr>
		</table>
	
	
	
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_retrive">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_new">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_paper">Paper Issue</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_go">Go to Send</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			</tr>
			</table>
		
    <!--Button (E) -->
	</td></tr>
</table>

<!------- Print용 Hidden RD Object Start -------->
<table width="100%"  id="rdTable"> 
	<tr>
		<td width="100%">
		<script language="javascript">comRdObject('Rd');</script>
		</td>
	</tr>
</table>
<!------- Print용 Hidden RD Object End -------->
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>