<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0079_02a.jsp
*@FileTitle : TRO(Transportation Request Order) for Inland Haulage
*Open Issues : ESM_BKG_0079 화면의 TRO-A tab 화면
*Change history :
*@LastModifyDate : 2009.05.19
*@LastModifier : 이남경
*@LastVersion : 1.0
* 2009.04.30 이남경
* 1.0 Creation
===============================================================================
 History
 2010.09.13 이일민 [CHM-201005276-01] ALPS-[BKG/DOC]주요UI버턴-단축키 기능개발
 2010.09.29 이일민 스크립트오류수정
 2011.03.30 정선용 [CHM-201109338-01] Split 18-ALPS의 Location 조회불가건 수정 보완 요청.
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.framework.core.view.template.Screen"%>
<%@ page import="com.hanjin.framework.core.controller.util.WebKeys"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.event.EsmBkg007902aEvent"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg007902aEvent  event = null;			//PDTO(Data Transfer Object including Parameters)
	Exception serverException = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	
    String bkgNo = "";
    String StrRhq_ofc_cd= "";
	String strUsr_ofc   = "";
	Logger log = Logger.getLogger("com.hanjin.apps.GeneralBookingConduct.TransferOrderIssue");
	String isInquiry = "N";	
	Screen screen = (Screen) request.getAttribute(WebKeys.CURRENT_SCREEN);
	
	//inquiry mode
	if (screen.getName().indexOf("Q") >= 0){
		isInquiry = "Y";
	} else {
		isInquiry = "N";			
	}
	try {

		event = (EsmBkg007902aEvent)request.getAttribute("Event");	
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_ofc = account.getOfc_cd();
		StrRhq_ofc_cd = account.getRhq_ofc_cd();
		
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		if (event != null) {
		    bkgNo = event.getBkgNo();
		}
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>TRO(Transportation Request Order) for Inland Haulage</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
.input2_2		{  height: 20px; border: #7896B1 1px solid; font-family: Tahoma,Arial,dotum,gulim; font-size: 12px; color: #606060; text-indent: 2px;  background-color:#E8E7EC; font-weight:bold;}
</style>

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

<body onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->
<input type="hidden" name="io_bnd_cd"         value="O"><!-- 화면별 고정 hidden parmam -->
<input type="hidden" name="rtn_tro_flg"       value="N"><!-- 화면별 고정 hidden parmam -->
<input type="hidden" name="conti_cd"          value=""><!-- 대륙코드 : Booking정보 -->
<input type="hidden" name="oldBkgNo"          value=""><!-- 조회된 bkg_no : 체크/저장용 -->
<input type="hidden" name="oldBlNo"           value=""><!-- 조회된 bl_no : 체크/저장용 -->
<input type="hidden" name="pcInqFlag"         value="N">
<input type="hidden" name="routeModifyFlag"   value="N">
<input type="hidden" name="curr_tro_seq"      value="">
<input type="hidden" name="ca_flg"            value=""><!-- C/A Flag --> 
<input type="hidden" name="f_del_flg"          value="">
<input type="hidden" name="cfm_flg_old"        value="N"><!-- hidden : mst_cofirm상태 check용 -->
<input type="hidden" name="cxl_flg_old"        value="N"><!-- hidden : mst_cancel상태 check용 -->
<input type="hidden" name="max_tro_seq_old"    value="0"><!-- SeqSeq버튼사용구분 화면제어용 -->
<input type="hidden" name="so_no_flg"          value="N"><!-- so_no exist check용 : Flag --> 
<input type="hidden" name="cfm_sys_date"       value=""><!-- 서버시간(system date) : cfm_dt용 --> 

<!-- Booking Header : hidden 정보 -->
<input type="hidden" name="por_nod_cd"         value="">
<input type="hidden" name="pickup_cy1"         value="">
<input type="hidden" name="pickup_cy2"         value="">
<input type="hidden" name="dor_arr_dt"         value="">
<input type="hidden" name="dor_arr_dt_hhmi"    value="">
<input type="hidden" name="cmdt_nm"            value=""><!-- hidden : commdity명 -->
<input type="hidden" name="etb_dt"             value="">
<input type="hidden" name="fd_grd_flg"         value="">
<input type="hidden" name="spcl_hide_flg"      value="">
<!-- 02B와 수정시 동기화 : hidden 정보 -->
<input type="hidden" name="so_flg"         value="">
<input type="hidden" name="ownr_trk_flg"   value="">
<input type="hidden" name="biz_rgst_no"    value="">
<input type="hidden" name="cntc_mphn_no"   value="">
<input type="hidden" name="ack_sts_cd"     value="">
<!-- <input type="hidden" name="aloc_sts_cd"     value=""> -->
<input type="hidden" class="noinput" name="modify_flag" value="N">
<input type="hidden" name="isInquiry" value="<%=isInquiry%>">

<input type="hidden" name="rhq_ofc_cd" value = "<%=StrRhq_ofc_cd%>">
<input type="hidden" name="usr_ofc_cd" value="<%=strUsr_ofc%>">
		<!--biz page (S)-->
		<table class="search" id="mainTable"  style="width:979;"> 
   		<tr><td class="bg">	   		

			<!--  biz_1 (S) -->
			<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="50">Bkg No.</td>
					<!--td width="145"><input type="text" name="bkg_no" style="width:104;" value="" class="input" fullfill maxlength="13" style="ime-mode:disabled" dataformat="uppernum"></td-->
                    <td width="140"><input type="text" name="bkg_no" style="width:115;" value="<%=bkgNo%>" class="input" fullfill maxlength="13" style="ime-mode:disabled" dataformat="uppernum" tabindex=2>
								    <img name="btn_splitPop" class="cursor" src="img/btns_inquiry.gif" width="19" height="20" border="0" align="absmiddle" tabindex=-1>
					</td>					
					<td width="50">B/L No.</td>
					<td width="145"><input type="text" name="bl_no" style="width:115;" value="" class="input" maxlength="13" style="ime-mode:disabled" dataformat="uppernum" tabindex=4>
					</td>
					<td width="">Status</td>
					
					<td width="">&nbsp;<input type="text" name="bkg_sts_cd" style="width:25;" class="input2" value="" readonly tabindex=-1>&nbsp;
					                   <input type="text" name="non_rt_sts_cd" style="width:25;" class="input2" value="" readonly>&nbsp;
					                   <input type="text" name="aloc_sts_cd" style="width:25;" class="input2" value="" readonly></td>
					<td width="100">Commodity</td>
					<td width="120"><input type="text" name="cmdt_cd" id="cmdt_cd" style="width:60;" value="" class="input2" readonly 
					                        onMouseOver="drs(document.form.cmdt_nm.value); return true;" onMouseOut="nd(); return true;" tabindex=-1>
					</td>
					<td rowspan="4" valign="top">
					
						<!-- Total Volume (S) -->						
						<table class="search" border="0">
						<tr><td class="title_h"></td>
							<td class="title_s">Total Volume</td></tr>
						<tr><td class="height_5"></td></tr>
						</table>
					
						<table border="0" style="width:100%; height:65;"> 
							<tr class="tr2_head">
								<td width="200">
									<script language="javascript">ComSheetObject('t2asheet5');</script>
								</td>
							</tr>
						</table>
						<!-- Total Volume (E) -->
					
					</td>
				</tr>
				<tr class="h23">
					<td>T/VVD</td>
					<td><input type="text" name="vsl_cd"     style="width:50;" value="" class="input2" readonly tabindex=-1>
					    <input type="text" name="skd_voy_no" style="width:50;" value="" class="input2" readonly tabindex=-1>
					    <input type="text" name="skd_dir_cd" style="width:30;" value="" class="input2" readonly tabindex=-1></td>
					<td>Route</td>
					<td colspan="3"><input type="text" name="por_cd" style="width:50;" value="" class="input2" readonly tabindex=-1>
					                <input type="text" name="pol_code" style="width:50;" value="" class="input2" readonly tabindex=-1>
					                <input type="text" name="pod_cd" style="width:50;" value="" class="input2" readonly tabindex=-1>
					                <input type="text" name="del_cd" style="width:50;" value="" class="input2" readonly tabindex=-1></td>
					<td>Return CY</td>
					<td><input type="text" name="return_cy1" style="width:60;" value="" class="input2" readonly tabindex=-1>
					    <input type="text" name="return_cy2" style="width:30;" value="" class="input2" readonly tabindex=-1></td>
				</tr>
				<tr class="h23">
					<td colspan="6">
						<table class="search" border="0">
							<tr class="h23">
								<td width="20">
								    <input type="checkbox" name="dcgo_flg" class="trans" disabled tabindex=-1>
								</td>
								<td width="85">
								    <table width="80" border="0" cellpadding="0" cellspacing="0" class="button">
						                <tr>
						                    <td class="btn2_left"></td>
						                    <td class="btn2" name="btn_Danger" id="btn_Danger">Danger</td>
						                    <td class="btn2_right"></td>
						                </tr>
						            </table>
						        </td>
								<td width="20">
								    <input type="checkbox" name="rc_flag" class="trans" disabled tabindex=-1>
								</td>
								<td width="85">
								    <table width="80" border="0" cellpadding="0" cellspacing="0" class="button">
						                <tr>
						                    <td class="btn2_left"></td>
						                    <td class="btn2" name="btn_Reefer" id="btn_Reefer">Reefer</td>
						                    <td class="btn2_right"></td>
						                </tr>
						            </table>
						        </td>
								<td width="20">
								    <input type="checkbox" name="awk_cgo_flg" class="trans" disabled tabindex=-1>
								</td>
								<td width="85">
								    <table width="80" border="0" cellpadding="0" cellspacing="0" class="button">
						                <tr>
						                    <td class="btn2_left"></td>
						                    <td class="btn2" name="btn_Awkward" id="btn_Awkward">Awkward</td>
						                    <td class="btn2_right"></td>
						                </tr>
						            </table>
						        </td>
								<td width="20">
								    <input type="checkbox" name="bb_cgo_flg" class="trans" disabled tabindex=-1>
								</td>
								<td width="95">
								    <table width="90" border="0" cellpadding="0" cellspacing="0" class="button">
						                <tr>
						                    <td class="btn2_left"></td>
						                    <td class="btn2" name="btn_Bulk" id="btn_Bulk">Break Bulk</td>
						                    <td class="btn2_right"></td>
						                </tr>
						            </table>
						        </td>
								<td width="20">
								    <input type="checkbox" name="rd_cgo_flg" class="trans" disabled tabindex=-1>
								</td>
								<td width="95">
								    <table width="90" border="0" cellpadding="0" cellspacing="0" class="button">
						                <tr>
						                    <td class="btn2_left"></td>
						                    <td class="btn2" name="btn_RDry">Reefer/Dry</td>
						                    <td class="btn2_right"></td>
						                </tr>
						            </table>
						        </td>
								<td width="30"></td>
							</tr>
						</table>
					</td>
					<td>Receiving Term</td>
					<td><input type="text" name="term" style="width:20;" class="input2" readonly></td>
				</tr>
				<tr class="h23">
					<td>Shipper</td>
					<td colspan="7"><input type="text" name="cust_cnt_cd" style="width:30;"  value="" class="input2" readonly tabindex=-1>
					                <input type="text" name="cust_seq"    style="width:70;"  value="" class="input2" readonly tabindex=-1>
					                <input type="text" name="cust_nm"     style="width:480;" value="" class="input2" readonly tabindex=-1></td>
				</tr>
			</table>
			<!--  biz_1   (E) -->	
			
			<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
			
			<!--  biz_2 (S) -->
			<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="82">Seq.</td>
					<td width="115">
					
					    <!-- TRO seq : 콤보출력 Start ----------->
						<!--select name="tro_seq" id="tro_seq" style="width:46;"></select-->
						<script language="javascript">ComComboObject('tro_seq', 1, 46, 1);</script>
						<!-- TRO seq : 콤보출력 End-------------->
						
						<input type="text" name="tro_seq_maxcnt" style="width:30;" class="input2" readonly tabindex=-1></td>
					<td width="70">RCV Term</td>
					<td width="75"><input type="text" name="rcv_term_cd" style="width:30;" class="input2" readonly tabindex=-1></td>
					<td width="90">Request Date</td>
					<td width="145"><input type="text" name="rqst_dt" style="width:120;" class="input2" readonly tabindex=-1></td>
					
					<td width="60">D/G Seq.</td>
					<td width="80">
					    <!-- D/G seq : 콤보출력 Start ----------->
						<script language="javascript">ComComboObject('dcgo_seq', 2, 70, 1);</script>
						<!-- D/G seq : 콤보출력 End-------------->					    
					</td>
					<td width="60">R/F Seq.</td>
					<td width="80">
					    <!-- R/F seq : 콤보출력 Start ----------->
						<script language="javascript">ComComboObject('rc_seq', 2, 70, 1);</script>
						<!-- R/F seq : 콤보출력 End-------------->
					</td>
					<td width="60">A/K Seq.</td>
					<td width="" align="right">
					    <!-- A/K Seq : 콤보출력 Start ----------->
						<script language="javascript">ComComboObject('awk_cgo_seq', 1, 70, 1);</script>
						<!-- A/K Seq  : 콤보출력 End--------------> 
					</td>
				</tr>
				</table>

				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="115">Actual Customer</td>
					<td><input type="text" name="act_shpr_cnt_cd" style="width:40;"  class="input" maxlength="2"   dataformat="engup" tabindex=10>
					    <input type="text" name="act_shpr_seq"    style="width:60;"  class="input" maxlength="6"   dataformat="int" tabindex=12>
					    <input type="text" name="act_shpr_nm"     style="width:313;" class="input1" maxlength="50" dataformat="uppernum" tabindex=14>
					    <img src="img/btns_search.gif" name="btns_popActCust" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor" tabindex=-1></td>
				</tr>
				</table>
					
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="82">Location</td>
					<td width="205"><input type="text" name="dor_loc_cd" caption="Locaction Code" style="width:98;" class="input1" maxlength="5" dataformat="engupnum" fullfill tabindex=16>
					                <input type="text" name="zn_cd"      style="width:30;" class="input1" maxlength="2" tabindex=18>
					                <img src="img/btns_search.gif" name="btns_popLocation" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor" tabindex=-1></td>
					<td width="20">Zip</td>
					<td width="125"><input type="text" name="dor_pst_no" style="width:60;" class="input" caption="Zip" maxlength="12" dataformat="engupspecial" style="ime-mode:disabled" tabindex=20></td>
					<td width="50">Confirm</td>
					<td width="70"><input type="checkbox" name="cfm_flg" class="trans" tabindex=22></td>
					<td width="90">Confirm Date</td>
					<td width="170"><input type="text" name="cfm_dt" style="width:120;" class="input2" readonly tabindex=-1></td>
					<!--td colspan="2"></td-->
					<td width="90">Cancel</td>
					<td><input type="checkbox" name="cxl_flg" class="trans" disabled=true tabindex=-1></td><!-- 취소여부 출력추가함!! -->
				</tr>
				<tr class="h23">
					<td>Address</td>
					<td colspan="7"><input type="text" name="act_shpr_addr" style="width:680;" class="input" maxlength="500" tabindex=24></td>
					<td>Contact</td>
					<td align="right"><input type="text" name="cntc_pson_nm" style="width:104;" class="input" maxlength="50" dataformat="engupspecial" tabindex=26></td>
				</tr>
				<tr class="h23">
					<td rowspan="2" valign="top">Remark(s)</td>
					<td colspan="7" rowspan="2"><textarea name="diff_rmk" style="width:678; height:46;" maxlength="1000" tabindex=28></textarea></td>
					<td>Tel.</td>
					<td align="right"><input type="text" name="cntc_phn_no" style="width:104;" class="input" maxlength="10" dataformat="int" tabindex=30></td>
				</tr>
				<tr class="h23">
					<td>Fax</td>
					<td align="right"><input type="text" name="cntc_fax_no" style="width:104;" value=" " class="input" maxlength="20" dataformat="tel" tabindex=32></td>
				</tr>
			</table>
			<!--  biz_2   (E) -->
										
			<table class="height_8"><tr><td></td></tr></table>
			
			<!-- Grid (S) -->
			<table width="100%"  id="mainTable">
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('t2asheet1');</script>
					</td>
				</tr>
			</table>
			<!-- Grid (E) -->		
			
			
			<!--  Button_Sub (S) -->
			<table width="979" class="button"table border="0"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_t2aAdd" id="btn_t2aAdd">Row Add</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_t2aDelete" id="btn_t2aDelete">Row Delete</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>

					<td width="30" align="center">
					   <input type="text" name="tro_copy_cnt" style="width:20; height:18; font-size:8pt; text-align:center;" class="input" maxlength="2" dataformat="int">
					</td>							
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_t2aCopy" id="btn_t2aCopy">Row Copy</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
				</tr>
				</table>
				
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
			
			
			</td></tr>
		</table>
		<!--biz page (E)-->
		
	
				
					<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_t2aRetrieve" id="btn_t2aRetrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_t2aSave" id="btn_t2aSave">Save All</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_t2aSaveSeq" id="btn_t2aSaveSeq">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td> 	
				<!--  
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_t2aSaveConfirm" id="btn_t2aSaveConfirm">Save + Confirm</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>				
				 -->
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_t2aCancelAll" id="btn_t2aCancelAll">Cancel All</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_t2aTROCopy" id="btn_t2aTROCopy">TRO Copy</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_t2aAddSeq" id="btn_t2aAddSeq">Add Seq.</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_t2aCopySeq" id="btn_t2aCopySeq">Copy Seq.</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_t2aCancelSeq" id="btn_t2aCancelSeq">Cancel Seq.</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				</tr>
			</table>
		</td></tr>
		</table>
    	<!--Button (E) -->
	


<!-- hidden grid : Start ---------------------->
<!-- booking header / master all : hidden -->
<table id="mainTable" width="100%">
	<tr>
		<td>
			<script language="javascript">ComSheetObject('t2asheet2');</script>
		</td>
	</tr>
</table>
<!-- detail all : hidden -->
<table id="mainTable">
	<tr>
		<td>
			<script language="javascript">ComSheetObject('t2asheet3');</script>
		</td>
	</tr>
</table>
<!-- tro_dg_seq all : hidden -->
<table id="mainTable">
	<tr>
		<td>
			<script language="javascript">ComSheetObject('t2asheet4');</script>
		</td>
	</tr>
</table>
<table id="mainTable" width="1">
	<tr>
		<td>
			<script language="javascript">ComSheetObject('t2amsgsheet1');</script>
		</td>
	</tr>
</table>
<!-- hidden grid : End ------------------------>	

<div id="layList" name="layList" style="position:absolute;z-index:999;display:none" CELLPADDING=5 CELLSPACING=0 BORDER=0/>
<IFRAME id="ifrm" name="ifrm" src="apps/alps/esm/bkg/bookingcommon/bookingutil/jsp/esm_booking_split_no.html"  frameborder=0 marginHeight=0 marginWidth=0 width=115 height=82  style="position:absolute;border:1 #e9e9e9 solid" CELLSPACING=0 scrolling="no"></IFRAME>
	
<!--20090526 도움말용------------->
<DIV ID='overDiv' STYLE='position:absolute; z-index:90; width:350; visibility:hidden' tabindex=-1>
</DIV>
<!------------------------------->

<script language="javascript">
	//도움말 시작---------------------------->
	  var x = 0;
	  var y = 0;
	  var snow = 0;
	  var sw = 0;
	  var cnt = 0;
	  var dir = 1;
	  var offsetx = -150; //3;
	  var offsety = 10; //-20;
	  var width  = 50;
	  var height = 70;
	
	  over = overDiv.style;
	  document.onmousemove = mouseMove;
	
	  function drs(text, title) { dts(1,text); }
	
	  function nd() {
	    if ( cnt >= 1 ) { sw = 0 };
	    if ( sw == 0 ) { snow = 0; hideObject(over); }
	    else { cnt++; }
	  }
	
	  function dts(d,text) {
		if (text=="")
		{
	        return false;
		}
	    txt = "<TABLE WIDTH=200 STYLE=\"border:1 #e9e9e9 solid\" CELLPADDING=5 CELLSPACING=0 BORDER=0><TR><TD BGCOLOR=#ffffff><font STYLE=\"font-size:11px;color:#333399\">"+text+"</font></TD></TR></TABLE>"; 
	    layerWrite(txt);
	    dir = d;
	    disp();
	  }
	
	  function disp() {
	    if (snow == 0) {
	      if (dir == 2) { moveTo(over,x+offsetx-(width/2),y+offsety); } // Center
	      if (dir == 1) { moveTo(over,x+offsetx,y+offsety); }           // Right
	      if (dir == 0) { moveTo(over,x-offsetx-width,y+offsety); }     // Left
	      showObject(over);
	      snow = 1;
	    }
	  }
	
	  function mouseMove(e) {
	    x=event.x + document.body.scrollLeft+10
	    y=event.y + document.body.scrollTop
	    if (x+width-document.body.scrollLeft > document.body.clientWidth)  x=x-width-25;
	    if (y+height-document.body.scrollTop > document.body.clientHeight) y=y-height;
	
	    if (snow) {
	      if (dir == 2) { moveTo(over,x+offsetx-(width/2),y+offsety); } // Center
	      if (dir == 1) { moveTo(over,x+offsetx,y+offsety); }           // Right
	      if (dir == 0) { moveTo(over,x-offsetx-width,y+offsety); }     // Left
	    }
	  }
	
	  function cClick() { hideObject(over); sw=0; }
	  function layerWrite(txt) { document.all["overDiv"].innerHTML = txt }
	  function showObject(obj) { obj.visibility = "visible" }
	  function hideObject(obj) { obj.visibility = "hidden" }
	  function moveTo(obj,xL,yL) { obj.left = xL; obj.top = yL; }
	//<-------------------------------도움말 끝
</script>		
	

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>

<SCRIPT LANGUAGE="javascript">
<!--
      /* 
       * 유저가 입력한 정보를 event를 통해서 다시 넘겨받아 화면에 뿌려주는 부분
       */
      with(document.form)
      {
        <%
          if(event != null) 
          {
              String currTroSeq = event.getCurrTroSeq();
              if (bkgNo.length() > 0) {
        %>
                  eval("curr_tro_seq").value = nullToBlank("<%=currTroSeq%>");
        <% 
              } 
          } 
        %>
      }
-->
</SCRIPT>