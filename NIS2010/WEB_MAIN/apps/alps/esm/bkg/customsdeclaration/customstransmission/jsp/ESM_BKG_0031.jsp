<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<% 
	// InBound, OutBound 구분
	String ioBndCd = request.getParameter("io_bnd_cd")==null?"I":request.getParameter("io_bnd_cd");
	// B/L NO
	String blNo    = request.getParameter("bl_no")==null?"":request.getParameter("bl_no");
	// BKG NO
	String bkgNo = request.getParameter("bkg_no")==null?"":request.getParameter("bkg_no");
	// MODE 구분 (ADD / EDIT)
	String mode    = request.getParameter("mode")==null?"ADD":request.getParameter("mode");
	// IN TYPE
	String inType    = request.getParameter("in_type")==null?"ADD":request.getParameter("in_type");
	// VVD
	String vvd    = request.getParameter("vvd")==null?"":request.getParameter("vvd");
	// PORT_CD
	String polCd = request.getParameter("pol_cd")==null?"":request.getParameter("pol_cd");
	String podCd = request.getParameter("pod_cd")==null?"":request.getParameter("pod_cd");
	String portCd = request.getParameter("port_cd")==null?"":request.getParameter("port_cd");
	// Cargo Spec 처리
	String cgoSpecClear = request.getParameter("cgo_spec_clear")==null?"":request.getParameter("cgo_spec_clear");
	// CSTMS_DECL_TP_CD
	String cstmsDeclTpCd = request.getParameter("cstms_decl_tp_cd")==null?"":request.getParameter("cstms_decl_tp_cd");
	String cTrnsSeq = request.getParameter("c_trns_seq")==null?"":request.getParameter("c_trns_seq");
	String dmstPortCd = request.getParameter("dmst_port_cd")==null?"":request.getParameter("dmst_port_cd");
	if (cstmsDeclTpCd.equals("")) {
		if (ioBndCd.equals("I")) cstmsDeclTpCd = "I"; else cstmsDeclTpCd="E";
	}
%>
<html>
<head>
<title>Welcome to Alps!</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">

    function setupPage(){  

	    loadPage();
    }

</script>
</head>
<body  onLoad="setupPage();"> 

<form name="form">
<input type="hidden" name="f_cmd" value="">
<input type="hidden" name="amdt_rcvr_flg" value="A">
<input type="hidden" name="kr_cstms_corr_id" value="">
<input type="hidden" name="cgo_spec" value="">
<input type="hidden" name="cmdt_cd" value="">
<input type="hidden" name="kr_cstms_wh_tp_cd" value="">
<input type="hidden" name="biz_no" value="">
<input type="hidden" name="pck_tp_cd" value="">
<input type="hidden" name="biz_rgst_no" value="">
<input type="hidden" name="kr_meas_ut_cd" value="">
<input type="hidden" name="mode" value="<%=mode%>">
<input type="hidden" name="cstms_decl_tp_cd" value="<%=cstmsDeclTpCd%>">
<input type="hidden" name="old_cstms_decl_tp_cd" value="<%=cstmsDeclTpCd%>">
<input type="hidden" name="io_bnd_cd" value="<%=ioBndCd%>">
<input type="hidden" name="in_type" value="<%=inType%>">
<input type="hidden" name="pol_loc" value="<%=polCd%>">
<input type="hidden" name="pod_loc" value="<%=podCd%>">
<input type="hidden" name="port_cd" value="<%=portCd%>">
<input type="hidden" name="c_trns_seq" value="<%=cTrnsSeq%>">
<input type="hidden" name="dmst_port_cd" value="<%=dmstPortCd%>">
<input type="hidden" name="por_cd">
<input type="hidden" name="del_cd">
<input type="hidden" name="frt_fwrd_cd">
<input type="hidden" name="trns_seq">
<input type="hidden" name="trans_chk">
<input type="hidden" name="org_bl_no">
<input type="hidden" name="cgo_spec_clear" value="<%=cgoSpecClear%>">
<input type="hidden" name="s_cust_cnt_cd">
<input type="hidden" name="s_cust_seq">
<input type="hidden" name="c_cust_cnt_cd">
<input type="hidden" name="c_cust_seq">
<input type="hidden" name="n_cust_cnt_cd">
<input type="hidden" name="n_cust_seq">

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
	<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle">&nbsp;Service Management &gt; Booking/Documentation &gt; manifest &gt; Korea &gt; Manifest Amend</td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Korea : BL Amendment (Add and Edit)</td></tr>
		</table>
	<!--Page Title, Historical (E)-->
	
	<!--Button (S) -->
		
    <!--Button (E) -->
	<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">

				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="66">Receiver</td>
					<td width="140"><script language="javascript">ComComboObject('cboReceiver', 2, 40, 1, 1);</script></td>
					<td width="55">Sub No.</td>
					<td width="180"><input type="text" style="width:150; text-align:center;" class="input2" name="smt_amd_no" readOnly></td>
					<td width="66">B/L No.</td>
					<td width="150"><input type="text" style="width:100; text-align:center;" class="input1" value="<%=blNo%>" name="bl_no" dataformat="eng" maxlength="12"></td>
					<td width="55">Trans</td>
					<td width=""><script language="javascript">ComComboObject('cboTrans', 2, 90, 1, 1);</script></td>
				</tr>
				<tr class="h23">
					<td width="66">Correction</td>
					<td width="140"><script language="javascript">ComComboObject('cboCorrection', 2, 40, 1, 1);</script></td>
					<td width="55">Reason</td>
					<td width="" colspan="5"><input type="text" style="width:346" class="input" name="corr_rsn"></td>
					
				</tr>
				</table>
				
				<table class="line_bluedot"><tr><td></td></tr></table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="34">MRN</td>
					<td width="90"><input type="text" style="width:80; text-align:center;" class="input" name="mrn_no" maxlength="11" dataformat="eng"></td>
					<td width="30">MSN</td>
					<td width="100"><input type="text" style="width:80; text-align:center;" class="input" name="msn_no" maxlength="4" dataformat="int"></td>
					<td width="55">BKG No.</td>
					<td width="130"><input type="text" style="width:108" class="input" name="bkg_no" maxlength="13" dataformat="eng"  value="<%=bkgNo%>"></td>
					<td width="77">Cargo Type</td>
					<td width="140" style="padding-left:2">
						<select style="width:125;" class="input" name="bkg_cgo_tp_cd">
						<option value="F" selected>Full Cargo</option>
						<option value="P">Empty Reposition</option>
						<option value="R">Revenue Empty</option>
						<option value="B">Break Bulk</option>
						</select></td>
					<td width="58">B/L Type</td>
					<td width="" colspan="3" style="padding-left:2">
						<select style="width:80;" class="input" name="kr_cstms_bl_tp_cd" onFocus="setOldData(this.value)" onChange="krCstmsBlTpCd_onChange()">
						<option value="S" selected>Simple</option>
						<option value="C">Consol</option>
						<option value="E">Empty</option>
						</select>
						<input type="text" style="display:inline; width:50; text-align:center;" name="cstms_fwrd_id" id="cstms_fwrd_id" class="input" maxlength="4" dataformat="eng" onChange="cstmsFwrdId_OnChange();" onFocus="cstmsFwrdId_OnFocus();">
					</td>
				</tr> 
				<tr class="h23">
					<td width="">VVD</td>
					<td width=""><input type="text" style="width:80; text-align:center;" class="input" name="vvd" value="<%=vvd%>" dataformat="eng" maxlength="9" onFocus="setOldData(this.value)" onChange="vvd_onChange()"></td>
					<td width="">POL</td>
					<td width=""><input type="text" style="width:80; text-align:center;" class="input" name="pol_cd" value="<%=polCd%>" maxlength="5" dataformat="eng" onFocus="setOldData(this.value)" onChange="pol_onChange()"></td>
					<td width="">POD</td>
					<td width=""><input type="text" style="width:109; text-align:center;" class="input" name="pod_cd" value="<%=podCd%>" maxlength="5" dataformat="eng" onFocus="setOldData(this.value)" onChange="pod_onChange()"></td>
					<td width="">Call Sign</td>
					<td width=""><input type="text" style="width:124; text-align:center;" class="input" name="vsl_call_sgn_cd" dataformat="eng" maxlength="5" onFocus="setOldData(this.value)" onChange="vslCallSgnCd_onChange()"></td>
					<td width="">Year</td>
					<td width=""><input type="text" style="width:44" class="input" name="eta_dt">&nbsp;<input type="text" style="width:30" class="input" name="call_knt"></td>
					<td width="">Cargo Spec.</td>
					<td width="" style="padding-left:4"><script language="javascript">ComComboObject('cboCargoSpec', 1, 100, 1);</script></td>
				</tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="66">VSL Name</td>
					<td width="188"><input type="text" style="width:169" class="input" name="vsl_nm" onFocus="setOldData(this.value)" onChange="vslNm_onChange()"></td>
					<td width="56">Flag</td>
					<td width="130"><input type="text" style="width:109; text-align:center;" class="input" name="vsl_cnt_cd" dataformat="eng" onFocus="setOldData(this.value)" onChange="vslCntCd_onChange()"></td>
					<td width="77">IMDG Code</td>
					<td width="288"><input type="text" style="width:60; text-align:center;" class="input" name="imdg_clss_cd" onFocus="setOldData(this.value)" onChange="imdgClssCd_onChange()">&nbsp;<input type="text" style="width:60; text-align:center;" class="input" name="n2nd_imdg_clss_cd" onFocus="setOldData(this.value)" onChange="n2ndImdgClssCd_onChange()">&nbsp;<input type="text" style="width:56; text-align:center;" class="input" name="n3rd_imdg_clss_cd" onFocus="setOldData(this.value)" onChange="n3rdImdgClssCd_onChange()"></td>
					<td width="82">HS Code</td>
					<td width=""style="padding-left:4"><script language="javascript">ComComboObject('cboGoods', 2, 100, 1);</script></td>
				</tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="66">Package</td>
					<td width="188"><input type="text" style="width:60;text-align:right" class="input" name="pck_qty" id="pck_qty" value="0" dataformat="int" maxlength="10" onFocus="setPckOldData(this.value)" onChange="pckQty_onChange()" >&nbsp;<script language="javascript">ComComboObject('cboPackage', 2, 104, 1);</script></td>
					<td width="56">Weight</td>
					<td width="131"><input type="text" style="width:46;text-align:right" class="input" name="cntr_ttl_wgt" value="0.000" dataformat="float" maxlength="19" onFocus="setOldData(this.value)" onChange="cntrTtlWgt_onChange()">&nbsp;<select style="width:60;"class="input" name="wgt_ut_cd">
						<option value="KGS" selected>KGS</option>
						<option value="LBS">LBS</option>
						</select></td>
					<td width="76">Measure</td>
					<td width="207"><input type="text" style="width:124;text-align:right" class="input" name="meas_qty" value="0.000" dataformat="float" maxlength="13" onFocus="setOldData(this.value)" onChange="measQty_onChange()">&nbsp;<select style="width:58;"class="input" name="meas_ut_cd" onfocus="setOldData(this.value)" onChange="measUtCd_onChange()">						<option value="CBM" selected>CBM</option>
						<option value="CBF">CBF</option>
						</select></td>
					<td width="42">Biz No.</td>
					<td width="" style="padding-left:2">
					<script language="javascript">ComComboObject('cboBizNo', 2, 203, 0,0,0,true);</script>
					</td>
				</tr>
				</table> 
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="110">Bond Area Code</td>
					<td width="143"><input type="text" style="width:123;text-align:center" class="input" name="bd_area_cd" dataformat="eng" maxlength="10" onFocus="setOldData(this.value)" onChange="bdAreaCd_onChange()"></td>
					<td width="107">Warehouse Info.</td>
					<td width="225" style="padding-left:1"><script language="javascript">ComComboObject('cboWhTpCd', 2, 60, 1);</script>
					&nbsp;<input type="text" style="width:92;text-align:center" class="input" name="kr_wh_cd"></td>
					<td width="57">Customs</td>
					<td width="210" colspan="2"><input type="text" style="width:63;text-align:center" maxlength="3" class="input" dataformat="int" name="cstms_ofc_cty_cd" value="000">&nbsp;<input type="text" style="width:56;text-align:center" maxlength="2" dataformat="int" class="input" name="kr_cstms_dept_cd" value="00"></td>
					<td width="21">PA</td>
					<td width="">
						<input type="text" style="width:70;text-align:center" maxlength="3" dataformat="int" class="input" name="kr_port_auth_cd"></td>
				</tr>
				<tr class="h23">
					<td width="110">Discharging CY</td>
					<td width="143"><input type="text" style="width:123;text-align:center" class="input" name="cstms_crr_in_loc_wh_cd" dataformat="eng" maxlength="8"></td>
					
					<td width="">MEA Unit &nbsp;&nbsp;
					<script language="javascript">ComComboObject('cboMeaUnit', 2, 40, 1);</script>
					</td>
					<td width="">Bulk WGT &nbsp;<input type="text" style="width:58;text-align:right" class="input" dataformat="float" name="bb_cgo_wgt" value="0.0" onFocus="setOldData(this.value)" onChange="bbCgoWgt_onChange()"></td>
					<td width="">Bulk MEA</td>
					<td width=""><input type="text" style="width:63;text-align:right" class="input" dataformat="float" name="bb_cgo_meas_qty" value="0.00" onFocus="setOldData(this.value)" onChange="bbCgoMeasQty_onChange()" ></td>
					<td width="">Quay&nbsp;&nbsp;&nbsp;<input type="text" style="width:60;text-align:center;" class="input" name="io_tml_loc_cd" dataformat="eng" maxlength="5" onFocus="setOldData(this.value)" onChange="ioTmlLocCd_onChange()"></td>
					<td width="">하역</td>
					<td width=""><input type="text" style="width:70;text-align:center;" class="input" name="dchg_mzd_cd" maxlength="1" dataformat="int" onFocus="setOldData(this.value)" onChange="dchgMzdCd_onChange()"></td>
				</tr>
				</table> 
				
				<table border="0" style="width:972; background-color:white;" class="grid2"> 
				<tr><td width="15%" class="tr2_head">Cargo Desc. 1</td>
					<td><input type="text" style="width:100%;" class="noinput" name="cgo_desc1"></td>
					</tr>
				</table> 
		<table class="height_5"><tr><td></td></tr></table>
					<table border="0" style="width:972; background-color:white;" class="grid2"> 
				<tr><td width="15%" class="tr2_head">Cargo Desc. 2</td>
					<td><textarea cols="" rows="4" style="width:100%;" name="cgo_desc2" class="input"></textarea></td>
					</tr>
				</table> 
				<!--  biz_1   (E) -->
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


<!--TAB Container Info (S) -->
<div id="tabLayer" style="display:inline">
		<!-- Grid BG Box  (S) -->
     	<table class="search" id="mainTable">
       	<tr><td class="bg">
		
				<!--  biz_2  (S) -->
				
				<!--  biz_2  (E) -->
			
			
				<!-- Grid  (S) -->
					<table width="100%"  id="mainTable">
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('t1sheet1');</script>
							</td>
						</tr>
					</table>			
				<!-- Grid (E) -->
				
				<!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0"><tr>
						
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_t1RowAdd">Row Add</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_t1SelectAll" id="btn_t1SelectAll">Select All</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_t1Delete">Row Delete</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_t1LoadExcel">Load Excel</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
					</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
	    	
				
			</td></tr>
		</table>
	<!-- Grid BG Box  (S) -->

</div>
<!--TAB Container Info (E) -->


<!--TAB Customer Info (S) -->
<div id="tabLayer" style="display:none">

		<!-- Grid BG Box  (S) -->
     	<table class="search" id="mainTable">
       	<tr><td class="bg">
		
				<!--  biz_2  (S) -->
				<table border="0" style="width:979; background-color:white;" class="grid2"> 
				<tr><td width="15%" class="tr2_head">shipper Name</td>
					<td><input type="text" style="width:100%;" class="noinput" name="s_cust_nm" onFocus="setOldData(this.value)" onChange="sCustNm_onChange()" value="SM LINE CORPORATION"></td>
					</tr>
				</table>  
				<table class="height_2"><tr><td></td></tr></table>
				<table border="0" style="width:979; background-color:white;" class="grid2"> 
				<tr><td width="15%" class="tr2_head">Shipper Address</td>
					<td><input type="text" style="width:100%;" class="noinput" name="s_cust_addr" onFocus="setOldData(this.value)" onChange="sCustAddr_onChange()" value="KRPUS"></td>
					</tr>
				</table>  
				<table class="height_10"><tr><td></td></tr></table>
				<table border="0" style="width:979; background-color:white;" class="grid2"> 
				<tr><td width="15%" class="tr2_head">Consignee Name</td>
					<td><input type="text" style="width:100%;" class="noinput" name="c_cust_nm" onFocus="setOldData(this.value)" onChange="cCustNm_onChange()" value="SM LINE CORPORATION"></td>
					</tr>
				</table>  
				<table class="height_2"><tr><td></td></tr></table>
				<table border="0" style="width:979; background-color:white;" class="grid2"> 
				<tr><td width="15%" class="tr2_head">Consignee Address</td>
					<td><input type="text" style="width:100%;" class="noinput" name="c_cust_addr" onFocus="setOldData(this.value)" onChange="cCustAddr_onChange()"></td>
					</tr>
				</table>  
				<table class="height_10"><tr><td></td></tr></table>
				<table border="0" style="width:979; background-color:white;" class="grid2"> 
				<tr><td width="15%" class="tr2_head">Notify Name</td>
					<td><input type="text" style="width:100%;" class="noinput" name="n_cust_nm" onFocus="setOldData(this.value)" onChange="nCustNm_onChange()" value="SM LINE CORPORATION"></td>
					</tr>
				</table>  
				<table class="height_2"><tr><td></td></tr></table>
				<table border="0" style="width:979; background-color:white;" class="grid2"> 
				<tr><td width="15%" class="tr2_head">Notify Address</td>
					<td><input type="text" style="width:100%;" class="noinput" name="n_cust_addr" onFocus="setOldData(this.value)" onChange="nCustAddr_onChange()"></td>
					</tr>
				</table>  
				<!--  biz_2  (E) -->
	    	<!-- Button_Sub (E) -->
				
			</td></tr>
		</table>
	<!-- Grid BG Box  (S) -->

</div>
<!--TAB Customer Info (E) -->


<!--TAB Export No (S) -->
<div id="tabLayer" style="display:none">

		<!-- Grid BG Box  (S) -->
     	<table class="search" id="mainTable">
       	<tr><td class="bg">
		
				<!--  biz_2  (S) -->
				
				<!--  biz_2  (E) -->
			
			
				<!-- Grid  (S) -->
					<table width="100%"  id="mainTable">
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('t3sheet1');</script>
							</td>
						</tr>
					</table>
				<!-- Grid (E) -->
				
				<!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0"><tr>
						
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_t3RowAdd">Row Add</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_t3SelectAll" id="btn_t3SelectAll">Select All</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_t3Delete">Row Delete</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_t3LoadExcel">Load Excel</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
					</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
			
				
			</td></tr>
		</table>
	<!-- Grid BG Box  (E) -->

</div>
<!--TAB Export No (E) -->


<!--TAB VVD-B/L Cor List (S) -->
<div id="tabLayer" style="display:none">

		<!-- Grid BG Box  (S) -->
     	<table class="search" id="mainTable">
       	<tr><td class="bg">
		
				<!-- Grid  (S) -->
					<table width="100%"  id="mainTable">
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('t4sheet1');</script>
							</td>
						</tr>
					</table>
				<!-- Grid (E) -->
				
				<!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0"><tr>
						
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_t4RowAdd">Row Add</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_t4SelectAll" id="btn_t4SelectAll">Select All</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_t4Delete">Row Delete</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_t4LoadExcel">Load Excel</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
					</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
			<script language="javascript">ComSheetObject('t4sheet2');</script>
				
			</td></tr>
		</table>
	<!-- Grid BG Box  (E) -->

</div>
<!--TAB VVD-B/L Cor List (E) -->
				
	
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" id="btn_retrieve" name="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_New">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_CorrectionListClear">Correction List Clear</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_TransAmendment">Trans Amendment</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_TransDischAmend">Trans Disch Amend</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			</tr>
			</table>
		</td></tr>
		</table>
    <!--Button (E) -->
				
			</td></tr>
		</table>
	<!-- Grid BG Box  (S) -->
	<!--biz page (E)-->
	<table class="height_10"><tr><td colspan="8"></td></tr></table>

</form>
</body>
</html>
