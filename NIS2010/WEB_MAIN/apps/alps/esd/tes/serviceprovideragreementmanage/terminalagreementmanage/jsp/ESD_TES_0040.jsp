<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TES_0040.jsp
*@FileTitle : TerminalAgreement 조회화면 -Detail(Terminal Rate)
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-07
*@LastModifier : kimjinjoo
*@LastVersion : 1.0
* 2006-11-07 kimjinjoo
* 1.0 최초 생성

*@LastModifyDate : 2009-08-13
*@LastModifier : yOng hO lEE
*@LastVersion : 1.0
* 2009.08.13 yOng hO lEE
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.framework.core.config.SubSystemConfigFactory"%>
<%@ page import="com.hanjin.apps.alps.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.event.EsdTes0040Event"%>
<%
	EsdTes0040Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";								 //에러메세지
	int rowCount	 = 0;								  //DB ResultSet 리스트의 건수

	// 비용지급 전표 결재 기능 - 3차 GW LINK (4347-10-06)
	String csrGwUrl				= "";


	//Agreement Summary화면에서 Detail Button을 통해 들어왔다면 AGMT No., AGMT Version No.를 받아온다.
	//String agmt_no = (request.getParameter("agmt_no")== null&&!request.getParameter("agmt_no").trim().equals("") ? "": request.getParameter("agmt_no"));
	//String agmt_ver_no = (request.getParameter("agmt_ver_no") == null&&!request.getParameter("agmt_ver_no").trim().equals("") ? "": request.getParameter("agmt_ver_no"));

	String cre_ofc_cd 	= "";
	String agmt_no 		= "";
	String agmt_ver_no 	= "";
	String eas_flag	= "";
	agmt_no 	= JSPUtil.getNull(request.getParameter("agmt_no"));
	agmt_ver_no = JSPUtil.getNull(request.getParameter("agmt_ver_no"));
	eas_flag = JSPUtil.getNull(request.getParameter("s_eas_flg"));
	
	/** 2015-03-04 : [CHM-201533697]detail화면에서 to Summary 버튼 클릭시 이전 화면 검색 결과 유지되도록 설정   **/
	String pre_cond_yd_cd 				= request.getParameter("pre_cond_yd_cd")!=null&&!request.getParameter("pre_cond_yd_cd").trim().equals("")?request.getParameter("pre_cond_yd_cd"):"";
	String pre_cond_vndr_seq 			= request.getParameter("pre_cond_vndr_seq")!=null&&!request.getParameter("pre_cond_vndr_seq").trim().equals("")?request.getParameter("pre_cond_vndr_seq"):"";
	String pre_cond_eff_agmt 			= request.getParameter("pre_cond_eff_agmt")!=null&&!request.getParameter("pre_cond_eff_agmt").trim().equals("")?request.getParameter("pre_cond_eff_agmt"):"";
	String pre_cond_eff_on 				= request.getParameter("pre_cond_eff_on")!=null&&!request.getParameter("pre_cond_eff_on").trim().equals("")?request.getParameter("pre_cond_eff_on"):"";
	String pre_cond_ctrt_ofc_cd 		= request.getParameter("pre_cond_ctrt_ofc_cd")!=null&&!request.getParameter("pre_cond_ctrt_ofc_cd").trim().equals("")?request.getParameter("pre_cond_ctrt_ofc_cd"):"";
	String pre_cond_delt_flg 			= request.getParameter("pre_cond_delt_flg")!=null&&!request.getParameter("pre_cond_delt_flg").trim().equals("")?request.getParameter("pre_cond_delt_flg"):"";	
	String pre_cond_tml_agmt_sts_cd 	= request.getParameter("pre_cond_tml_agmt_sts_cd")!=null&&!request.getParameter("pre_cond_tml_agmt_sts_cd").trim().equals("")?request.getParameter("pre_cond_tml_agmt_sts_cd"):"";
	String pre_cond_cre_ofc_cd2 		= request.getParameter("pre_cond_cre_ofc_cd2")!=null&&!request.getParameter("pre_cond_cre_ofc_cd2").trim().equals("")?request.getParameter("pre_cond_cre_ofc_cd2"):"";

	try {
	    SignOnUserAccount account	= (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	    cre_ofc_cd 		= account.getOfc_cd();
		
		event = (EsdTes0040Event)request.getAttribute("Event");

		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		// 비용지급 전표 결재 기능 - 3차 GW LINK (4347-10-06)
		csrGwUrl = SubSystemConfigFactory.get("CSR.GW.URL");

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}else{
		} // end else
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>TerminalAgreement 조회화면 -Detail(Terminal Rate)</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript" src="rpt/script/rdviewer50.js"></script>
<script language="javascript">
	var agmt_no = '<%=JSPUtil.getNull(agmt_no)%>';
	var agmt_ver_no = '<%=JSPUtil.getNull(agmt_ver_no)%>';
	var eas_flag = '<%=JSPUtil.getNull(eas_flag)%>';
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		
		
		// EAS에서 넘어온 경우 Button Display Hidden처리. (2015-06-15)
		if ( eas_flag == "Y") {
			objectDisplaySet('tblbtn', 'true');
		}
		
//### =========================================================================
//### 탭을 사용하는 화면인 경우 추가한다.
		// InitTab();
//### =========================================================================
		loadPage();
	}
	
</script>
<SCRIPT LANGUAGE="javascript" FOR="document" EVENT="onkeydown">

</SCRIPT>

</head>
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input	type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="yd_nm">
<!-- ofc_cd 별로 권한제어시 추가 -->
<input type="hidden" name="no_ofc_cd" value="">
<input type="hidden" name="act_tp" value="AGMT">
<input type="hidden" name="no_yd_cd" value="">
<input type="hidden" name="auth_ofc_cd" value="">
<input type="hidden" name="cre_ofc_cd" value="<%=cre_ofc_cd %>">

<!-- interface용.. 변수.. 테스트 후 삭제할것 :: lgs_cost_cd-->
<input type="hidden" name="lgs_cost_cd" value="TMNDTS">
<input type="hidden" name="pop_cost_cd">
<input type="hidden" name="pop_sheetObj">
<input type="hidden" name="pop_row">
<input type="hidden" name="pop_agmt_rmk">
<input type="hidden" name="pop_mode">

<!-- // 비용지급 전표 결재 기능 - 3차 GW LINK - (4347-10-06) -->
<input type="hidden" name="csr_gw_url" value="<%=csrGwUrl%>">

<!-- 2015-03-04 : [CHM-201533697]detail화면에서 to Summary 버튼 클릭시 이전 화면 검색 결과 유지되도록 설정   -->
<input name="pre_cond_yd_cd" type="hidden" value="<%=JSPUtil.getNull(pre_cond_yd_cd)%>">
<input name="pre_cond_vndr_seq" type="hidden" value="<%=JSPUtil.getNull(pre_cond_vndr_seq)%>">
<input name="pre_cond_eff_agmt" type="hidden" value="<%=JSPUtil.getNull(pre_cond_eff_agmt)%>">
<input name="pre_cond_eff_on" type="hidden" value="<%=JSPUtil.getNull(pre_cond_eff_on)%>">
<input name="pre_cond_ctrt_ofc_cd" type="hidden" value="<%=JSPUtil.getNull(pre_cond_ctrt_ofc_cd)%>">
<input name="pre_cond_delt_flg" type="hidden" value="<%=JSPUtil.getNull(pre_cond_delt_flg)%>">
<input name="pre_cond_tml_agmt_sts_cd" type="hidden" value="<%=JSPUtil.getNull(pre_cond_tml_agmt_sts_cd)%>">
<input name="pre_cond_cre_ofc_cd2" type="hidden" value="<%=JSPUtil.getNull(pre_cond_cre_ofc_cd2)%>">

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
		<table id="tblbtn" name="tblbtn" width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
				<tr><td class="btn1_bg">

						<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<!-- Repeat Pattern -->
							
							<td>
								<div id="PreInquiryCondLayer01" style="display:none">
								<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_pre_inquiry_cond" id="btn_pre_inquiry_cond">To Agmt. Summary</td><td class="btn1_right"></td></tr></table>
								</div>
							</td>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_new" id="btn_new">New</td><td class="btn1_right"></td></tr></table></td>
							<!-- Repeat Pattern -->

						</tr></table>

				</td></tr>
		</table>
    	<!-- TABLE '#D' : ( Button : Main ) (E) -->




		<!-- TABLE '#D' : ( Search Options :  ) (S) -->
     	<table class="search">
       	<tr><td class="bg">
				<!-- : ( Week ) (S) -->
				<table class="search_in" border="0">

					<tr class="h23">
						<td width="110"><img class="nostar">Agreement No.</td>
						<td width="140">&nbsp;
						<input class="input1" type="text" style="width:100" value="" name="tml_agmt_ofc_cty_cd" maxlength=8 onKeyUp='isApNum(this);upper(this)'></td>
						<td width="140"><img class="nostar">Agreement Version</td>
						<td width="120">
						<input class="input1" type="text" style="width:78" value="" name="tml_agmt_ver_no" maxlength=5 onKeyUp ='isAlpha(this);isNumPod(this);addPeriod(this);' onKeyDown='isNumPod(this);' ></td>
						<td width="140"><img class="nostar">GW Contract Link</td>
						<td width=""><input type="text" id="agmt_doc_desc" name="agmt_doc_desc" style="width:230" class="input1" readOnly OnClick="ContractView()">
						<input type="hidden" id="agmt_doc_no" name="agmt_doc_no" style="width:200">
						</td>
					</tr>
				</table>
				<!-- : ( Week ) (E) -->


			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options : ) (E) -->

		<table class="height_10"><tr><td></td></tr></table>
		<!-- TABLE '#D' : ( Search Options : Related COP Information  ) (S) -->
		<table class="search">
        	<tr><td class="bg">

        			<table border="0" class="grid2" background-color:white;>
        				<tr>
        					<td width="155" class="tr2_head" colspan="2">Yard Code</td>
        					<td width="107"><input name="yd_cd" value="" type="text" class="noinput" style="width:75" readonly></td>
        					<td width="125" class="tr2_head">Contract Office</td>
						<td width="102"><input name="ctrt_ofc_cd" type="text" class="noinput" style="width:80" readonly></td>
        					<td width="117" class="tr2_head">S/P Code</td>
        					<td width="112"><input name="vndr_seq" type="text" class="noinput" style="width:80" readonly></td>
						<td width="136" class="tr2_head">S/P Name(Abbr.)</td>
        					<td width="103"><input name="vndr_abbr_nm" type="text" class="noinput" style="width:70" readonly></td>
        				</tr>
						<tr>
        					<td class="tr2_head" rowspan="2">Effective<br>Date</td>
							<td class="tr2_head">From</td>
        					<td><input name="eff_fm_dt" type="text" class="noinput" style="width:75" readonly></td>
        					<td class="tr2_head">Creation Date</td>
							<td><input name="cre_dt" type="text" class="noinput" style="width:80" readonly></td>
        					<td class="tr2_head">Update Date</td>
        					<td><input name="upd_dt" type="text" class="noinput" style="width:80" readonly></td>
							<td class="tr2_head">AGMT Approval Date</td>
        					<td><input name="agmt_apro_dt" type="text" class="noinput" style="width:70" readonly></td>
        				</tr>
						<tr>
							<td class="tr2_head">To</td>
        					<td><input name="eff_to_dt" type="text" class="noinput" style="width:75" readonly></td>
        					<td class="tr2_head">Creation User ID</td>
							<td><input name="cre_usr_id" type="text" class="noinput" style="width:90" readonly></td>
        					<td class="tr2_head">Update User ID</td>
        					<td><input name="upd_usr_id" type="text" class="noinput" style="width:90" readonly></td>
        					
        					<td colspan=2>
        					<table border=0 cellpadding=0 cellspacing=0>
        					<tr>
								<td class="tr2_head">Creation Office</td>
	        					<td><input name="no_cre_ofc_cd" type="text" class="noinput" style="width:70" value="" readonly></td>        					
								<td class="tr2_head">Auto Extension YN</td>
	        					<td><input name="auto_xtd_flg" type="text" class="noinput" style="width:70" readonly></td>        					
        					</tr>
        					</table>
        					</td>

        				</tr>
        		</table>
			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options : Related COP Information) (E) -->



		<table class="height_10"><tr><td></td></tr></table>


		<!-- TABLE '#D' : ( Tab ) (S) Coincidence / Discrepancy / Cost Calculation-->
		<table class="tab">
           	<tr><td><script language="javascript">ComTabObject('tab1')</script></td></tr>
		</table>
		<!-- TABLE '#D' : ( Tab ) (E) -->


<!-- UI_ESD_TES_040 : THIS IS 1st TAB -->
<div id="tabLayer" style="display:inline">

		<!-- TABLE '#D' : ( Tab BG Box ) (S) -->
     	<table class="search" border="0">
       	<tr><td class="bg">




			<table class="height_10"><tr><td></td></tr></table>




			<!-- : ( Grid : Week ) (S) -->
			<!-- 'HEAD1-BGCOLOR : 203 240 169' , 'HEAD2-BGCOLOR : 222 251 248' , 'BORDER 1-outside : 88 152 164' ,
				 'BORDER 2-inside : 202 226 233' , 'HEAD-FONT : 39 95 101' , 'SELETED ROW BG : 252 255 233' -->
			<table width="100%" id="mainTable">
                        	<tr><td><script language="javascript">ComSheetObject('t1sheet1');</script></td></tr>
		         </table>
			<!-- : ( Speed ) (E) -->
			<!-- : ( Button : Sub ) (S) -->
			<table id="tblbtn" name="tblbtn" class="button" border="0" width="100%">
						<tr><td class="btn2_bg" class="align">
							<table border="0" cellpadding="0" cellspacing="0">
								<tr>
									<!-- Repeat Pattern -->
									<td><div id="CostCodeDescShow01" style="display:none">
										<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr><td class="btn2_left"></td><td class="btn2" name="btng_costcodedescshow" id="btng_costcodedescshow">Cost Code Desc. Show</td>
											<td class="btn2_right"></td></tr></table>
										</div>
									</td>
									<td><div id="CostCodeDescHide01" style="display:none">
										<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr><td class="btn2_left"></td><td class="btn2" name="btng_costcodedeschide" id="btng_costcodedeschide">Cost Code Desc. Hide</td>
											<td class="btn2_right"></td></tr></table>
										</div>
									</td>
									<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn2_left"></td><td class="btn2" name="btng_adjustmentscreen" id="btng_adjustmentscreen">Adjustment Screen</td>
									<td class="btn2_right"></td></tr></table></td>
									<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn2_left"></td><td class="btn2" name="btng_downexcel" id="btng_downexcel">Down Excel</td>
									<td class="btn2_right"></td></tr></table></td>
									<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn2_left"></td><td class="btn2" name="btng_print" id="btng_print">Print</td>
									<td class="btn2_right"></td></tr></table></td>
									<!-- Repeat Pattern -->
								</tr>
							</table>
						</td></tr>
					</table>
	    		<!-- : ( Button : Sub ) (E) -->



			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Tab BG Box ) (E) -->
</div>


<!-- UI_ESD_TES_041 : THIS IS 2st TAB -->
<div id="tabLayer" style="display:none">

		<!-- TABLE '#D' : ( Tab BG Box ) (S) -->
     	<table class="search" border="0">
       	<tr><td class="bg">




			<table class="height_10"><tr><td></td></tr></table>




			<!-- : ( Grid : Week ) (S) -->
			<!-- 'HEAD1-BGCOLOR : 203 240 169' , 'HEAD2-BGCOLOR : 222 251 248' , 'BORDER 1-outside : 88 152 164' ,
				 'BORDER 2-inside : 202 226 233' , 'HEAD-FONT : 39 95 101' , 'SELETED ROW BG : 252 255 233' -->

			<table width="100%" id="mainTable">
                        <tr><td><script language="javascript">ComSheetObject('t2sheet1');</script></td></tr>
		        </table>

		        <!-- : ( Button : Sub ) (S) -->
				<table id="tblbtn" name="tblbtn" class="button" border="0" width="100%">
						<tr><td class="btn2_bg" class="align">
							<table border="0" cellpadding="0" cellspacing="0">
								<tr>
									<!-- Repeat Pattern -->
									<td><div id="CostCodeDescShow02" style="display:none">
										<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr><td class="btn2_left"></td><td class="btn2" name="btng_costcodedescshow" id="btng_costcodedescshow">Cost Code Desc. Show</td>
											<td class="btn2_right"></td></tr></table>
										</div>
									</td>
									<td><div id="CostCodeDescHide02" style="display:none">
										<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr><td class="btn2_left"></td><td class="btn2" name="btng_costcodedeschide" id="btng_costcodedeschide">Cost Code Desc. Hide</td>
											<td class="btn2_right"></td></tr></table>
										</div>
									</td>
									<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn2_left"></td><td class="btn2" name="btng_adjustmentscreen" id="btng_adjustmentscreen">Adjustment Screen</td>
									<td class="btn2_right"></td></tr></table></td>
									<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn2_left"></td><td class="btn2" name="btng_downexcel" id="btng_downexcel">Down Excel</td>
									<td class="btn2_right"></td></tr></table></td>
									<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn2_left"></td><td class="btn2" name="btng_print" id="btng_print">Print</td>
									<td class="btn2_right"></td></tr></table></td>
									<!-- Repeat Pattern -->
								</tr>
							</table>
						</td></tr>
					</table>
	    		<!-- : ( Button : Sub ) (E) -->
			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Tab BG Box ) (E) -->
</div>

<div id="main_hidden_sheets" style="display:none">
<!--// HIDDEN SHEET : header 정보 임시 보관용 	//-->
<script language="javascript">ComSheetObject('main_hidden');</script>
</div>

</td></tr>
</table>
<!-- Outer Table (E)-->

</form>
</body>
</html>
<%@ include file="/bizcommon/include/common_auth.jsp"%>