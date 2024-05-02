<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0317.jsp
*@FileTitle : TRO-T1 and Revenue Information
*Open Issues : ESM_BKG_0079_02C 화면의 TRO - T1 and Revenue Information 팝업 
*Change history :
*@LastModifyDate : 2009.06.29
*@LastModifier : 이남경
*@LastVersion : 1.0
* 2009.06.29 이남경
* 1.0 Creation 
===============================================================================
* History
* 2012.06.25 전성진 [CHM-201217633] 구주 Hinterland Operation 개선 Project - T1&Revenue Guideline 적용
* 2012.09.12 조정민 [CHM-201219535] [BKG] EUR TRO 화면 로직추가 (Optimum status 표기)
* 2012.10.04 조정민 [CHM-201220238] [BKG] [EUR TRO] ADD,Copy CNTR에 Optimum조회추가 & 금액읽어오는 로직 & 버튼색깔 보완
* 2012.10.29 조정민 [CHM-201220788] [EUR TRO] Manifested Amount Hiding, Speical Instruction 공간확대
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.event.EsmBkg0317Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0317Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
/*	
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
*/

	Logger log = Logger.getLogger("com.hanjin.apps.GeneralBookingConduct.TransferOrderIssue");
	
	try {	
/* 		
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   */ 
	
		event = (EsmBkg0317Event)request.getAttribute("Event");		
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>TRO-T1 and Revenue Information</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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

<body CLASS="POPUP_BG" onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->
<input type="hidden" name="term"      			value="">
<input type="hidden" name="hlg_tp_cd" 			value="">
<input type="hidden" name="io_bnd_cd" 			value="">
<input type="hidden" name="cfm_flg"   			value="">
<input type="hidden" name="cntr_tpsz_cd"   		value="">
<input type="hidden" name="bse_port_loc_cd"   	value="">
<input type="hidden" name="pnt_loc_cd"   		value="">
<input type="hidden" name="trsp_mode_cd"   		value="">
<input type="hidden" name="rf_flag"   			value="">
<input type="hidden" name="dg_flag"   			value="">
<input type="hidden" name="awk_flag"   			value="">
<input type="hidden" name="cfm_dt"   			value="">
<input type="hidden" name="h_add_rev_chg_cd" 	value="">
<input type="hidden" name="h_add_rev_rmk" 		value="">
<input type="hidden" name="h_add_rev_amt" 		value="">
<input type="hidden" name="h_add_rev_chg_cd2" 	value="">
<input type="hidden" name="h_add_rev_amt2" 		value="">
<input type="hidden" name="h_add_rev_chg_cd3" 	value="">
<input type="hidden" name="h_add_rev_amt3" 		value="">
<input type="hidden" name="h_all_in_rt_cd" 		value="">
<input type="hidden" name="h_arb_curr_cd" 		value="">
<input type="hidden" name="h_arb_rev_amt" 		value="">
<input type="hidden" name="optm_sts_cd" 		value="">
<input type="hidden" name="manifest_flag" 		value="">
<input type="hidden" name="cntr_no" 			value="">
<input type="hidden" name="dih_amt" 			value="">
<input type="hidden" name="cgo_wgt" 			value="">
<input type="hidden" name="agmt_wgt">
<input type="hidden" name="ihc_trf_no">
<input type="hidden" name="org_dest_tp_cd">
<input type="hidden" name="svc_scp_cd">


<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;TRO - T1 and Revenue Information</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!--biz page (S)-->
		<table class="search" id="mainTable" > 
       		<tr><td class="bg">
			
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:100%;"> 
					<tr class="h23">
						<td width="39%">Booking No.</td>
						<td width=""><input type="text" name="bkg_no" style="width:100;" class="input2" value="" readonly></td></tr> 
					<tr class="h23">
						<td>T1 Document</td>
						<td class="stm"><input type="radio" name="t1_doc_flg" class="trans" value="Y">&nbsp;Yes&nbsp;&nbsp;&nbsp;&nbsp;
						    <input type="radio" name="t1_doc_flg" class="trans" value="N">&nbsp;No</td></tr> 
					<tr class="h23">
						<td>Customs CLR No.</td>
						<td><input type="text" name="cstms_clr_no" style="width:144;" class="input" value="" maxlength="35" dataformat=""></td></tr> 
				</table>	
				
				<table class="search" border="0" style="width:100%;"> 
					<tr class="h23">
						<td colspan="5" valign="top" style="padding-top:4px;">&nbsp;</td></tr>
					<tr class="h23">
						<td colspan="5" valign="top" style="padding-top:4px;">Manifest Rate (Included in pricing quotation)</td></tr>
					<tr class="h23">
						<td colspan="2" valign="top" style="padding-top:4px;">&nbsp;</td>
						<td valign="top" align="center" style="padding-top:4px">Currency</td>
						<td valign="top" align="center" style="padding-top:4px">Revenue</td>
						<td valign="top" align="center" style="padding-top:4px">Diff. with Tariff</td></tr>
					<tr class="h23">
						<td class="stm"><input type="checkbox" name="all_in_rt_cd" class="trans" value="Y"></td>
						<td valign="top" style="padding-top:4px">Manifested</td>
						<td rowspan="2"><input type="text" name="curr_cd" style="width:35;" class="input1" value="" maxlength="3" dataformat="engup" style="ime-mode:disabled"></td>
						<td width="">
							<input type="text"  style="width:100; text-align:center" class="input1" name="trns_rev_amt" caption="Manifested" value="" maxlength="14" pointcount="2" dataformat="float" >
							<input type="hidden"  style="width:100; text-align:center" class="input1" name="calc_trns_rev_amt" caption="Manifested" value="" maxlength="14" pointcount="2" dataformat="float" >
						</td>
					</tr>
						<!-- td width=""><input type="hidden"  style="width:100; text-align:right" class="input2" name="diff_trns_rev_amt" caption="Manifested" value="" maxlength="14" pointcount="2" dataformat="float" readOnly></td></tr -->
					<tr class="h23">
						<td class="stm"><input type="checkbox" name="all_in_rt_cd" class="trans" value="N"></td>
						<td width="39%" valign="top" style="padding-top:4px">Non-Manifested</td>
						<td width=""><input type="text"  style="width:100; text-align:right" class="input1" name="non_trns_rev_amt" caption="Non-Manifested" value="" maxlength="14" pointcount="2" dataformat="float" ></td>
						<td width=""><input type="text"  style="width:100; text-align:right" class="input2" name="diff_non_trns_rev_amt" caption="Non-Manifested" value="" maxlength="14" pointcount="2" dataformat="float" readOnly></td></tr>
					<tr class="h23">
						<td>&nbsp;</td>
						<td valign="top" style="padding-top:4px">IHC Tariff</td>
						<td><input type="text" name="gline_curr_cd" style="width:35;" class="input2" value="" maxlength="3" dataformat="engup" style="ime-mode:disabled" readonly></td>
						<td width=""><input type="text"  style="width:100; text-align:right" class="input2" name="gline_rev_amt" caption="Guideline" value="" maxlength="14" pointcount="2" dataformat="float" readOnly></td>
						<td width=""><div id="DIV_btn_ihc" style="display:none;"><img class="cursor" name="btns_popOverIhc" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" tabindex=-1></div></td></tr>
					<tr class="h23">
						<td class="stm"><input type="checkbox" name="all_in_rt_cd" class="trans" value="R"></td>
						<td valign="top" style="padding-top:4px">Arbitrary</td>
						<td><input type="text" name="arb_curr_cd" style="width:35;" class="input2" value="" maxlength="3" dataformat="engup" style="ime-mode:disabled" readonly></td>
						<td width=""><input type="text"  style="width:100; text-align:right" class="input2" name="arb_rev_amt" caption="Aribitrary" value="" maxlength="14" pointcount="2" dataformat="float" readOnly></td>
						<td width=""></td></tr>						
					<tr class="h23">
						<td colspan="4"></td>
						<td valign="top" align="center" style="padding-top:4px">Charge Code</td></tr>
					<tr class="h23">
						<td class="stm"><input type="checkbox" name="all_in_rt_cd" class="trans" value="A"></td>
						<td width="50%">Additional</td>
						<td><input type="text" name="add_trns_curr_cd" style="width:35;" class="input2" value="" maxlength="3" dataformat="engup" style="ime-mode:disabled" readOnly></input></td>
						<td width=""><input type="text" style="width:100; text-align:right" class="input2" name="add_rev_amt" caption="Additional Revenue" value="" maxlength="14" pointcount="2" dataformat="float" ></td>
						<td width="">&nbsp;<script language="javascript">ComComboObject('add_rev_chg_cd', 2, 70, 1);</script></td></tr>
					<tr class="h23">
						<td class="stm">&nbsp;</td>
						<td width="50%">&nbsp;</td>
						<td><input type="text" name="add_trns_curr_cd2" style="width:35;" class="input2" value="" maxlength="3" dataformat="engup" style="ime-mode:disabled" readOnly></input></td>
						<td width=""><input type="text" style="width:100; text-align:right" class="input2" name="add_rev_amt2" caption="Additional Revenue" value="" maxlength="14" pointcount="2" dataformat="float" ></td>
						<td width="">&nbsp;<script language="javascript">ComComboObject('add_rev_chg_cd2', 2, 70, 1);</script></td></tr>
					<tr class="h23">
						<td class="stm">&nbsp;</td>
						<td width="50%">&nbsp;</td>
						<td><input type="text" name="add_trns_curr_cd3" style="width:35;" class="input2" value="" maxlength="3" dataformat="engup" style="ime-mode:disabled" readOnly></input></td>
						<td width=""><input type="text" style="width:100; text-align:right" class="input2" name="add_rev_amt3" caption="Additional Revenue" value="" maxlength="14" pointcount="2" dataformat="float" ></td>
						<td width="">&nbsp;<script language="javascript">ComComboObject('add_rev_chg_cd3', 2, 70, 1);</script></td></tr>

					<tr class="h23">
						<td>&nbsp;</td>
						<td valign="top" style="padding-top:4px">Remark</td>
						<td colspan="3" width=""><input type="text" style="width:100%;" class="input2" name="add_rev_rmk" caption="Remark" value="" maxlength="1000" dataformat="etc"></td>
						</tr>
					<tr class="h23">
						<td colspan="5" valign="top" style="padding-top:4px;">&nbsp;</td></tr>
				</table>	
		
				<table class="search" border="0" style="width:100%;"> 
				<!-- 
					<tr class="h23">
						<td rowspan="3" valign="top" style="padding-top:4px">Manifested Rate</td>
						<td class="stm"><input type="radio" name="all_in_rt_cd" class="trans" value="Y">&nbsp;Yes&nbsp;</td></tr> 
					<tr class="h23">
						<td class="stm"><input type="radio" name="all_in_rt_cd" class="trans" value="N">&nbsp;No&nbsp;</td></tr>
	                <tr class="h23">
						<td class="stm"><input type="checkbox" name="all_in_rt_cd" class="trans" value="A">&nbsp;Additional</td></tr> 
					<tr class="h23">
						<td>Currency</td>
						<td><input type="text" name="curr_cd" style="width:35;" class="input1" value="" maxlength="3" dataformat="engup" style="ime-mode:disabled"></td></tr> 
					<tr class="h23">
						<td width="50%">Manifested Revenue</td>
						<td width=""><input type="text"  style="width:144; text-align:right" class="input1" name="trns_rev_amt" caption="Manifested Revenue" value="" maxlength="14" pointcount="2" dataformat="float" ></td></tr>
					<tr class="h23">
						<td width="50%">&nbsp;Non-Manifested Revenue</td>
						<td width=""><input type="text" style="width:144; text-align:right" class="input1" name="non_trns_rev_amt" caption="Non-Manifested Revenue" value="" maxlength="14" pointcount="2" dataformat="float" ></td></tr> 
					<tr class="h23">
						<td width="50%">&nbsp;Additional Revenue</td>
						<td width=""><input type="text" style="width:144; text-align:right" class="input1" name="add_rev_amt" caption="Additional Revenue" value="" maxlength="14" pointcount="2" dataformat="float" ></td></tr>				
					<tr class="h23">
						<td width="50%">&nbsp;Additional Charge Code</td>
						<td width=""><input type="text" style="width:35;" class="input1" name="add_rev_chg_cd" value="" maxlength="3" dataformat="engup" style="ime-mode:disabled" ></td></tr>
				 	-->						
					<tr class="h23">
						<td>VAT</td>
						<td CLASS="STM"><input type="radio" name="vat_flg" class="trans" value="Y">&nbsp;Yes&nbsp;&nbsp;&nbsp;&nbsp;
						    <input type="radio" name="vat_flg" class="trans" value="N">&nbsp;No</td></tr>
					<tr class="h23">
						<td>Canceled</td>
						<td><input type="checkbox" name="cxl_flg" class="trans" value="" disabled=true></td></tr> 
				</table>		
				<!--  biz_1   (E) -->
			
		</td></tr></table>
		<!--biz page (E)--> 
<table class="height_5"><tr><td></td></tr></table>
</td></tr></table>

<!-- Grid  (S) -->
<table width="100%"> 
	<tr>
		<td width="100%">
			<script language="javascript">ComSheetObject('h1sheet1');</script>
		</td>
	</tr>
</table>
<table width="100%" id="mainTable"> 
	<tr>
		<td width="100%">
			<script language="javascript">ComSheetObject('h1sheet2');</script>
		</td>
	</tr>
</table>
<!-- Grid (E) -->
	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

    	<!--Button (S) -->	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	    <tr><td class="btn3_bg">
		            <table border="0" cellpadding="0" cellspacing="0">
		              <tr>
		                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					          <tr><td class="btn1_left"></td>
					             <td class="btn1" name="btn_save">Save</td>
					             <td class="btn1_right"></td>
				              </tr>
				            </table>
				        </td>	
			            <td class="btn1_line"></td>		
			           <td>
		                             <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					                    <tr><td class="btn1_left"></td>
					                        <td class="btn1" name="btn_close">Close</td>
					                        <td class="btn1_right"></td>
				                        </tr>
				                     </table>
				                  </td>	
			                  </tr>
		                   </table>
		    </td></tr>
		</table>
    	<!--Button (E) -->
	
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->

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
        if(event != null){ 
            String bkgNo      		= event.getBkgNo();
            String t1DocFlg   		= event.getT1DocFlg();
            String cstmsClrNo 		= event.getCstmsClrNo();
            String allInRtFlg 		= event.getAllInRtFlg();
            String currCd     		= event.getCurrCd();
            String trnsRevAmt 		= event.getTrnsRevAmt();  //.00
            String cxlFlg     		= event.getCxlFlg();
            String vatFlg     		= event.getVatFlg();
            String term       		= event.getTerm();
            String hlgTpCd    		= event.getHlgTpCd();
            String boundCd    		= event.getIoBndCd();
            String cfmFlg     		= event.getCfmFlg();
            String nonTrnsRevAmt  	= event.getNonTrnsRevAmt();
            String addRevAmt     	= event.getAddRevAmt();
            String addRevChgCd     	= event.getAddRevChgCd();
            String addRevAmt2     	= event.getAddRevAmt2(); 
            String addRevChgCd2     = event.getAddRevChgCd2();
            String addRevAmt3     	= event.getAddRevAmt3();
            String addRevChgCd3     = event.getAddRevChgCd3(); 
            String addRevRmk		= event.getAddRevRmk();
            String cntrTpszCd     	= event.getCntrTpszCd();
            String bsePortLocCd     = event.getBsePortLocCd();
            String pntLocCd     	= event.getPntLocCd();
            String trspModeCd     	= event.getTrspModeCd();
            String rfFlag     		= event.getRfFlag();
            String dgFlag     		= event.getDgFlag();
            String awkFlag     		= event.getAwkFlag();
            String cfmDt     		= event.getCfmDt();
            String optmStsCd     	= event.getOptmStsCd();
            String cntrNo     		= event.getCntrNo();
            String arbCurrCd   		= event.getArbCurrCd();
            String arbRevAmt     	= event.getArbRevAmt();
            String cgoWgt        	= event.getCgoWgt();  
        %>    
            eval("bkg_no").value        = "<%=bkgNo%>";
            if ("<%=t1DocFlg%>" == "Y") {  
                eval("t1_doc_flg")[0].checked = true;
            } else {
                eval("t1_doc_flg")[1].checked = true;
            }  
            eval("cstms_clr_no").value  = "<%=cstmsClrNo%>";  
          
            eval("curr_cd").value       	= "<%=currCd%>";  
            eval("h_add_rev_chg_cd").value  = "<%=addRevChgCd%>"; 
            eval("h_add_rev_rmk").value		= "<%=addRevRmk%>";  
            eval("h_add_rev_amt").value  	= changeComma_loc("<%=addRevAmt%>", 0, 9, 2);
            eval("h_add_rev_chg_cd2").value  = "<%=addRevChgCd2%>"; 
            eval("h_add_rev_amt2").value  	= changeComma_loc("<%=addRevAmt2%>", 0, 9, 2);
            eval("h_add_rev_chg_cd3").value  = "<%=addRevChgCd3%>"; 
            eval("h_add_rev_amt3").value  	= changeComma_loc("<%=addRevAmt3%>", 0, 9, 2);
            eval("h_all_in_rt_cd").value	= "<%=allInRtFlg%>";
            eval("h_arb_curr_cd").value		= "<%=arbCurrCd%>";  
            eval("h_arb_rev_amt").value		= "<%=arbRevAmt%>";  

            if ("<%=trnsRevAmt%>".trim() == ".00") {
            	eval("trns_rev_amt").value  = changeComma_loc("", 0, 9, 2);
            } else {
            	eval("trns_rev_amt").value  = changeComma_loc("<%=trnsRevAmt%>", 0, 9, 2);
            }
            
            if ("<%=nonTrnsRevAmt%>".trim() == ".00") {
            	eval("non_trns_rev_amt").value  = changeComma_loc("", 0, 9, 2);
            } else {
            	eval("non_trns_rev_amt").value  = changeComma_loc("<%=nonTrnsRevAmt%>", 0, 9, 2);
            }
            
            if ("<%=vatFlg%>" == "Y") {  
                eval("vat_flg")[0].checked = true;
            } else {
                eval("vat_flg")[1].checked = true;
            }
            
            if ("<%=cxlFlg%>" == "Y") {  
                eval("cxl_flg").checked = true;
            } else {
                eval("cxl_flg").checked = false;
            }  

            eval("term").value				= "<%=term%>";  
            eval("hlg_tp_cd").value  		= "<%=hlgTpCd%>";
            eval("io_bnd_cd").value  		= "<%=boundCd%>";    
            eval("cfm_flg").value    		= "<%=cfmFlg%>";     
            eval("cntr_tpsz_cd").value		= "<%=cntrTpszCd%>";     
            eval("bse_port_loc_cd").value	= "<%=bsePortLocCd%>";     
            eval("pnt_loc_cd").value		= "<%=pntLocCd%>";     
            eval("trsp_mode_cd").value		= "<%=trspModeCd%>";     
            eval("rf_flag").value			= "<%=rfFlag%>";     
            eval("dg_flag").value			= "<%=dgFlag%>";      
            eval("awk_flag").value			= "<%=awkFlag%>";     
            eval("cfm_dt").value			= "<%=cfmDt%>";     
            eval("optm_sts_cd").value		= "<%=optmStsCd%>";     
            eval("cntr_no").value			= "<%=cntrNo%>";   
            eval("cgo_wgt").value			= "<%=cgoWgt%>";   
        <% } %>
       }
-->
</SCRIPT>
<%@include file="/bizcommon/include/common_alps.jsp"%>
