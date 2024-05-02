<%--
/***************************************************************************************
 * =========================================================
 * Copyright(c) 2014 CyberLogitec
 * @FileName : ESD_TES_0015GS.jsp
 * @FileTitle : Invoice Processing Audit Inquiry
 * Open Issues :
 * Change history :
 *@LastModifyDate : 2014-06-19
 *@LastModifier : yOng hO lEE
 *@LastVersion : 1.0
 * 2014-06-19 yOng hO lEE
 * 1.0 최초 생성
 * =========================================================
 ***************************************************************************************/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.invoiceprocessingauditmanage.event.EsdTes0015Event"%>
<%!
String tesMakeCode(String code, String splitKey) {
    if (code==null) 		code = "";
    if (splitKey==null) 	splitKey = ""; 

	String [] 	tempArr 	= code.split(splitKey);
	String 		tempStr 	= "";

	if (tempArr!=null && tempArr.length>1) {
		if (tempArr[0].lastIndexOf("<OPTION")!=-1) {
			tempArr[0] = tempArr[0].substring(0,tempArr[0].lastIndexOf("<OPTION"));		
		}
		if (tempArr[1].indexOf("<OPTION")!=-1) {	
			tempArr[1] = tempArr[1].substring(tempArr[1].indexOf("<OPTION"), tempArr[1].length());
		}
		tempStr = tempArr[0]+ tempArr[1];
	}

	if (tempStr.indexOf("<SELECT")==-1) {
		tempStr="<SELECT name = 'tml_inv_sts_cd' width='150'> <OPTION  value=''> </OPTION>"+tempStr;
	}
	if (tempStr.indexOf("</SELECT>")==-1) {
		tempStr=tempStr+"</SELECT>";
	}
	
	return tempStr;
}
%>
<%

	EsdTes0015Event  event		= null;			// PDTO(Data Transfer Object including Parameters)
	Exception serverException		= null;			// 서버에서 발생한 에러
	DBRowSet rowSet				= null;			// DB ResultSet
	String strErrMsg					= "";				// 에러메세지
	int rowCount					= 0;				// DB ResultSet 리스트의 건수

	String inv_no						= JSPUtil.getNull(request.getParameter("inv_no"));
	String vndr_seq					= JSPUtil.getNull(request.getParameter("vndr_seq"));
	String flag						= JSPUtil.getNull(request.getParameter("flag"));

	//ofc_cd 별로 권한제어시 추가
	String cre_ofc_cd				= "";
	String ofcCd						= "";

	try {

		SignOnUserAccount account	= (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		cre_ofc_cd		= account.getOfc_cd();
		ofcCd				= account.getOfc_cd() != null && !"".equals(account.getOfc_cd()) ? account.getOfc_cd() : "";

		event				= (EsdTes0015Event)request.getAttribute("Event");
		serverException	= (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		} else {
		} // end else
	} catch(Exception e) {
		out.println(e.toString());
	}
	
	//3번째 파라메터가 "width='500'"TML_INV_RJCT_STS_CD
	String addRowBound = "10: ";
	String actionInvDateBox   = JSPUtil.getCodeCombo("inv_date_type", "01", "width='100'", "CD01364", 0, addRowBound);
	String actionInvStatusBox = JSPUtil.getCodeCombo("tml_inv_sts_cd","01", "width='150'", "CD00172", 0, addRowBound);
	
	actionInvStatusBox = tesMakeCode(actionInvStatusBox, "EDI Received");
%>
<html>
<head>
<title>Invoice Processing Audit Inquiry</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	var ofc_cd		= '<%=JSPUtil.getNull(ofcCd)%>';
	var inv_no		= '<%=JSPUtil.getNull(inv_no)%>';
	var vndr_seq		= '<%=JSPUtil.getNull(vndr_seq)%>';
	var flag			= '<%=JSPUtil.getNull(flag)%>';
	
	function setupPage() {
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if

		// InitTab();
		loadPage();
	}
</script>
</head>
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="iPageTm"					value="">
<input type="hidden" name="iPageOn"					value="">
<input type="hidden" name="iPageOf"					value="">
<input type="hidden" name="iPageSt"					value="">
<input type="hidden" name="tml_so_ofc_cty_cd">
<input type="hidden" name="tml_so_seq">
<input type="hidden" name="DB_DATE"				value="">
<input type="hidden" name="cost_code"				value="">
<input type="hidden" name="cntr_sty_code"			value="">

<input type="hidden" name="is_valid_yd_cd"			value="">
<input type="hidden" name="yd_cd_hidden"			value="">
<input type="hidden" name="yd_cd_deltflg"			value="">
<input type="hidden" name="yd_cd"					value="">

<input type="hidden" name="is_valid_cost_ofc_cd"	value="">
<input type="hidden" name="cost_ofc_cd_hidden"	value="">
<input type="hidden" name="cost_ofc_cd_deltflg"		value="">

<input type="hidden" name="is_valid_inv_ofc_cd"		value="">
<input type="hidden" name="inv_ofc_cd_hidden"		value="">
<input type="hidden" name="inv_ofc_cd_deltflg"		value="">


<input type="hidden" name="flag" value="<%=JSPUtil.getNull(flag)%>">

<!-- ofc_cd 별로 권한제어시 추가 -->
<input type="hidden" name="no_ofc_cd" value="">
<input type="hidden" name="act_tp" value="INV">
<input type="hidden" name="auth_ofc_cd" value="">
<input type="hidden" name="cre_ofc_cd" value="<%=cre_ofc_cd %>">

<input type="hidden" name="sub_ofc_cd1" value="">
<input type="hidden" name="sub_ofc_cd2" value="">
<input type="hidden" name="ofc_cd" value="">


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
				
					<tr>
						<td  width="">
						<table border="0">
							<tr class="h23">
								<td width="100"><img class="nostar">INVOICE</td>
								<td width=""  class="stm">MR Invoice				<input type="radio" value="TM" desc="TM" id="tml_inv_tp_cd" name="tml_inv_tp_cd" onclick="invoiceOnclick(0)" checked>&nbsp;&nbsp;&nbsp;
																 On Dock Rail Charge	<input type="radio" value="ON" desc="ON" id="tml_inv_tp_cd" name="tml_inv_tp_cd" onclick="invoiceOnclick(1)">&nbsp;&nbsp;&nbsp;
																 Off Dock CY				<input type="radio" value="OF" desc="OF" id="tml_inv_tp_cd" name="tml_inv_tp_cd" onclick="invoiceOnclick(2)">&nbsp;&nbsp;&nbsp;
																 MR Storage				<input type="radio" value="ST" desc="ST" id="tml_inv_tp_cd" name="tml_inv_tp_cd" onclick="invoiceOnclick(3)">&nbsp;&nbsp;&nbsp;
								</td>
							</tr>
						</table>
						</td>
					</tr>
				
					<tr>
						<td width="">
						<table border="0">
							<tr class="h23">
								<td width="100"><img class="nostar">Invoice DT</td>
								<td width=""><%=actionInvDateBox%></td>
								<td width="">&nbsp;<input type="text" style="width:75" value="" name="fm_prd_dt" maxlength=10 onKeyUp='isNum1(this);tes_isNumD(this,"Y");tes_moveFocus(this, to_prd_dt, 10);' onKeyDown='chkInput(this);' OnBlur='this.value=ComGetMaskedValue(this.value, "ymd");'>&nbsp;<img class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar1">&nbsp;~</td>
								<td width="" colspan="3"><input type="text" style="width:75" value="" name="to_prd_dt" maxlength=10 onKeyUp='isNum1(this);tes_isNumD(this,"Y");' onKeyDown='chkInput(this);' OnBlur='this.value=ComGetMaskedValue(this.value, "ymd");'>
								<img class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar2"></td>
							</tr>
						</table>
						</td>
					</tr>

					<tr>
						<td width="">
						<table border="0">
							<tr class="h23">
								<td width="100"><img class="nostar">Yard Code</td>
								<td width="48"><input type="text" style="width:42" name="loc_cd" maxlength=5 onKeyUp='upper(this);getNodeCodeCombo(this);' OnBlur="validateYardCode();"></td>
								<td width="49"><script language="javascript">ComComboObject('nod_cd', 1, 45, 0)</script></td>
								<td width="138"><img class="cursor" src="/hanjin/img/button/btns_search.gif"  name="btn_yard" width="19" height="20" border="0" align="absmiddle"></td>
								<td width="100"><img class="nostar">S/P Code</td>
								<td  width=""><input type="text" name="vndr_seq" style="width:115" value="" maxlength="6" onKeyUp='chkInput(this);isNum(this);' onBlur='validateVNDRCode();'>&nbsp;<img class="cursor" src="/hanjin/img/button/btns_search.gif" name="btn_vndr" width="19" height="20" border="0" align="absmiddle"></td>
								<td  width="">&nbsp;<input type="text" style="width:300" name="vndr_seq_name" value=""><input type="hidden" name="vndr_seq_hidden" value=''><input type="hidden" name="is_valid_vndr_seq" value=''><input type="hidden" name="vndr_seq_deltflg" value=''>
								</td>
							</tr>
						</table>
						</td>
					</tr>

					<tr>
						<td width="">
						<table border="0">
							<tr class="h23">
								<td width="100"><img class="nostar">Cost Office</td>
								<td><input type="text" name="cost_ofc_cd" style="width:91" onKeyUp='chkInput(this);upper(this);isAlpha(this);' onBlur='validateCostOFCCode();'>
								</td>
								<td width="142" class="stm">&nbsp;<img class="cursor" src="/hanjin/img/button/btns_search.gif" name="btn_cost_ofc_cd" width="19" height="20" border="0" align="absmiddle">&nbsp;<input name="sub_office1" type="checkbox" value="" class="trans" onClick="javascript:getSubOffice1();">&nbsp;Incl. Sub OFC
								</td>
								<td width="100"><img class="nostar">Invoice Office</td>
								<td  width="270" class="stm"><input type="text" name="inv_ofc_cd" onKeyUp='isAlpha(this);chkInput(this);upper(this);' onBlur='validateInvOFCCode();' style="width:115"> <img class="cursor" src="/hanjin/img/button/btns_search.gif" name="btn_inv_ofc_cd" width="19" height="20" border="0" align="absmiddle">&nbsp;<input name="sub_office2" type="checkbox" value="" class="trans" onClick="javascript:getSubOffice2();">&nbsp;Incl. Sub OFC</td>
								<td width="100"><img class="nostar">Invoice STS</td>
							    <td><%=actionInvStatusBox%></td>
							</tr>
						</table>
						</td>
					</tr>

					<tr>
						<td width="">
						<table border="0">
							<tr class="h23">
								<td width="100"><img class="nostar">Invoice NO</td>
								<td width="235"><input type="text" style="width:115" name="inv_no" id="inv_no" maxlength="30"></td>
								<td width="100"><img class="nostar">BKG NO</td>
								<td width="270"><input type="text" style='width:138' name="bkg_no" id="bkg_no" maxlength="13" onKeyUp='upper(this);' ></td>
								<td width="100"><img class="nostar">Container NO</td>
								<td><input type="text" style="width:122" name="cntr_no" id="cntr_no" maxlength="14" onKeyUp='upper(this);' ></td>
							</tr>
						</table>
						</td>
					</tr>

					<tr>
						<td  width="">
						<table border="0">
							<tr class="h23">
								<td width="100"><img class="nostar">Cost Type</td>
								<td width="385"  class="stm">ALL<input type="checkbox" value="" desc="ALL" class="trans" name="cost_tp" onclick="initCheckBox()">&nbsp;&nbsp;&nbsp;
																 TP<input type="checkbox" value="" desc="TP" class="trans" name="cost_tp" onclick="cost_tpOnclick()">&nbsp;&nbsp;&nbsp;
																 SV<input type="checkbox" value="" desc="SV" class="trans" name="cost_tp" onclick="cost_tpOnclick()">&nbsp;&nbsp;&nbsp;
																 TM<input type="checkbox" value="" desc="TM" class="trans" name="cost_tp" onclick="cost_tpOnclick()">&nbsp;&nbsp;&nbsp;
																 SR<input type="checkbox" value="" desc="SR" class="trans" name="cost_tp" onclick="cost_tpOnclick()">&nbsp;&nbsp;&nbsp;
																 CG<input type="checkbox" value="" desc="CG" class="trans" name="cost_tp" onclick="cost_tpOnclick()">&nbsp;&nbsp;&nbsp;
																 ET<input type="checkbox" value="" desc="ET" class="trans" name="cost_tp" onclick="cost_tpOnclick()">
								</td>
								<td width="100"><img class="nostar">Cost Code</td>
								<td width="120">&nbsp;<script language="javascript">ComComboObject('lgs_cost_cd', 1, 100, 1, 1)</script></td>
								<td width="100"><img class="nostar">VVD</td>
								<td><input type="text" style="width:122" name="vvd" id="vvd" maxlength="30" ></td>
							</tr>
						</table>
						</td>
					</tr>

					<tr>
						<td width="">
							<table border="0">
								<tr class="h23">
									<td width="100"><img class="nostar">Full/Empty</td>
									<td width="236"  class="stm">&nbsp;&nbsp;FL<input type="checkbox" value="" desc="F" class="trans" name="cntr_tp">&nbsp;&nbsp;&nbsp;
										MT<input type="checkbox" value="" desc="M" class="trans" name="cntr_tp">
									</td>
								</tr>
							</table>
						</td>
					</tr>
					
				</table>
				<!-- : ( Week ) (E) -->

				</td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Search Options : ) (E) -->

		<table class="height_10"><tr><td></td></tr></table>

		
	<!-- Marine Terminal Invoice div -->
	<div id="invoiceLayer" name="invoiceLayer" style="display:inline">
		<!-- TABLE '#D' : ( Tab ) (S) Coincidence / Discrepancy / Cost Calculation-->
     	<table class="tab">
           	<tr><td><script language="javascript">ComTabObject('tmtab1')</script>
		</table>
		<!-- TABLE '#D' : ( Tab ) (E) -->

		<!-- UI_ESD_TES_0015 : THIS IS 1st TAB -->
		<div id="tmtabLayer" style="display:inline">

			<!-- TABLE '#D' : ( Tab BG Box ) (S) -->
	     	<table class="search" border="0">
	       		<tr><td class="bg">

			<!-- : ( Grid : Week ) (S) -->
					<table width="100%" id="mainTable">
						<tr><td>
							 <script language="javascript">ComSheetObject('t1sheet1');</script>
						</td></tr>
					</table>
					
					
					</td>
				</tr>
			</table>
			<!-- : ( Grid : Week ) (E) -->

			<!-- : ( Button : Sub ) (S) -->
			<table class="button" border="0" width="100%">
				<tr><td class="btn2_bg" class="align">
					<table border="0" cellpadding="0" cellspacing="0">
						<tr>


							<!-- Repeat Pattern -->
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2" name="btn_moretm1" id="btn_moretm1">More</td>
									<td class="btn2_right"></td></tr></table>
							</td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2" name="btn_downexceltm1" id="btn_downexceltm1">Down Excel</td>
									<td class="btn2_right"></td></tr></table>
							</td>

							<!-- Repeat Pattern -->
		
						</tr></table>
					</td></tr>
			</table>
			<!-- : ( Button : Sub ) (E) -->

		</div>


		<!-- UI_ESD_TES_0015 : THIS IS 2st TAB -->
		<div id="tmtabLayer" style="display:none">

		<!-- TABLE '#D' : ( Tab BG Box ) (S) -->
			<!-- TABLE '#D' : ( Tab BG Box ) (S) -->
	     	<table class="search" border="0">
	       		<tr><td class="bg">


					<!-- : ( Grid : Week ) (S) -->
					<!-- 'HEAD1-BGCOLOR : 203 240 169' , 'HEAD2-BGCOLOR : 222 251 248' , 'BORDER 1-outside : 88 152 164' ,
						 'BORDER 2-inside : 202 226 233' , 'HEAD-FONT : 39 95 101' , 'SELETED ROW BG : 252 255 233' -->
		
					<table width="100%" id="mainTable">
						<tr><td>
							 <script language="javascript">ComSheetObject('t2sheet1');</script>
						</td></tr>
					</table>

					</td>
				</tr>
			</table>
			<!-- : ( Grid : Week ) (E) -->

			<!-- : ( Button : Sub ) (S) -->
			<table class="button" border="0" width="100%">
				<tr><td class="btn2_bg" class="align">
					<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							
							<!-- Repeat Pattern -->
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2" name="btn_downexceltm2" id="btn_downexceltm2">Down Excel</td>
									<td class="btn2_right"></td></tr></table>
							</td>

							<!-- Repeat Pattern -->
		
						</tr></table>
					</td></tr>
			</table>
			<!-- : ( Button : Sub ) (E) -->

		</div>


		<!-- UI_ESD_TES_0015 : THIS IS 3st TAB -->
		<div id="tmtabLayer" style="display:none">


		<!-- TABLE '#D' : ( Tab BG Box ) (S) -->
			<!-- TABLE '#D' : ( Tab BG Box ) (S) -->
	     	<table class="search" border="0">
	       		<tr><td class="bg">


					<!-- : ( Grid : Week ) (S) -->
					<!-- 'HEAD1-BGCOLOR : 203 240 169' , 'HEAD2-BGCOLOR : 222 251 248' , 'BORDER 1-outside : 88 152 164' ,
						 'BORDER 2-inside : 202 226 233' , 'HEAD-FONT : 39 95 101' , 'SELETED ROW BG : 252 255 233' -->
		
					<table width="100%" id="mainTable">
						<tr><td>
							 <script language="javascript">ComSheetObject('t3sheet1');</script>
						</td></tr>
					</table>

					</td>
				</tr>
			</table>
			<!-- : ( Grid : Week ) (E) -->
			
			
			<!-- : ( Button : Sub ) (S) -->
			<table class="button" border="0" width="100%">
				<tr><td class="btn2_bg" class="align">
					<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							
							<!-- Repeat Pattern -->
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2" name="btn_downexceltm3" id="btn_downexceltm3">Down Excel</td>
									<td class="btn2_right"></td></tr></table>
							</td>

							<!-- Repeat Pattern -->
		
						</tr></table>
					</td></tr>
			</table>
			<!-- : ( Button : Sub ) (E) -->
		</div>

	</div> <!-- end of invoiceLayer[0] (MT) -->

	<!-- On-dock Rail Charge Invoice div -->
	<div id="invoiceLayer" name="invoiceLayer" style="display:none">
		<!-- TABLE '#D' : ( Tab ) (S) Coincidence / Discrepancy / Cost Calculation-->
		<table class="tab">
			<tr><td><script language="javascript">ComTabObject('ontab1')</script>
		</table>
		<!-- TABLE '#D' : ( Tab ) (E) -->

		<div id="ontabLayer" style="display:inline">
			<!-- TABLE '#D' : ( Tab BG Box ) (S) -->
			<table class="search" border="0">
				<tr><td class="bg">
	
				<!-- : ( Grid : Week ) (S) -->
				<table width="100%" id="mainTable">
					<tr><td>
						<script language="javascript">ComSheetObject('ondockt1sheet1');</script>
					</td></tr>
				</table>
				<!-- : ( Grid : Week ) (E) -->
	
	
				</td></tr>
			</table>
			<!-- TABLE '#D' : ( Tab BG Box ) (E) -->


			<!-- : ( Button : Sub ) (S) -->
			<table class="button" border="0" width="100%">
				<tr><td class="btn2_bg" class="align">
					<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							
							<!-- Repeat Pattern -->
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2" name="btn_moreon1" id="btn_moreon1">More</td>
									<td class="btn2_right"></td></tr></table>
							</td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2" name="btn_downexcelon1" id="btn_downexcelon1">Down Excel</td>
									<td class="btn2_right"></td></tr></table>
							</td>

							<!-- Repeat Pattern -->
		
						</tr></table>
					</td></tr>
			</table>
			<!-- : ( Button : Sub ) (E) -->
		</div>

		<div id="ontabLayer" style="display:none">
			<!-- TABLE '#D' : ( Tab BG Box ) (S) -->
			<table class="search" border="0">
				<tr><td class="bg">
	
				<!-- : ( Grid : Week ) (S) -->
				<!-- 'HEAD1-BGCOLOR : 203 240 169' , 'HEAD2-BGCOLOR : 222 251 248' , 'BORDER 1-outside : 88 152 164' ,
					 'BORDER 2-inside : 202 226 233' , 'HEAD-FONT : 39 95 101' , 'SELETED ROW BG : 252 255 233' -->
				<table width="100%" id="mainTable">
					<tr>
						<td><script language="javascript">ComSheetObject('ondockt2sheet1');</script></td>
					</tr>
				</table>
				<!-- : ( Grid : Week ) (E) -->
	
				</td></tr>
			</table>
			<!-- TABLE '#D' : ( Tab BG Box ) (E) -->
			
			<!-- : ( Button : Sub ) (S) -->
			<table class="button" border="0" width="100%">
				<tr><td class="btn2_bg" class="align">
					<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							
							<!-- Repeat Pattern -->
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2" name="btn_downexcelon2" id="btn_downexcelon2">Down Excel</td>
									<td class="btn2_right"></td></tr></table>
							</td>

							<!-- Repeat Pattern -->
		
						</tr></table>
					</td></tr>
			</table>
			<!-- : ( Button : Sub ) (E) -->
		</div>

		<div id="ontabLayer" style="display:none">
			<!-- TABLE '#D' : ( Tab BG Box ) (S) -->
			<table class="search" border="0">
				<tr><td class="bg">
			
					<!-- : ( Grid : Week ) (S) -->
					<!-- 'HEAD1-BGCOLOR : 203 240 169' , 'HEAD2-BGCOLOR : 222 251 248' , 'BORDER 1-outside : 88 152 164' ,
						'BORDER 2-inside : 202 226 233' , 'HEAD-FONT : 39 95 101' , 'SELETED ROW BG : 252 255 233' -->
					<table width="100%" id="mainTable">
						<tr>
							<td><script language="javascript">ComSheetObject('ondockt3sheet1');</script></td>
						</tr>
					</table>
					<!-- : ( Grid : Week ) (E) -->
			
				</td></tr>
			</table>
			<!-- TABLE '#D' : ( Tab BG Box ) (E) -->
			
			<!-- : ( Button : Sub ) (S) -->
			<table class="button" border="0" width="100%">
				<tr><td class="btn2_bg" class="align">
					<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							
							<!-- Repeat Pattern -->
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2" name="btn_downexcelon3" id="btn_downexcelon3">Down Excel</td>
									<td class="btn2_right"></td></tr></table>
							</td>

							<!-- Repeat Pattern -->
		
						</tr></table>
					</td></tr>
			</table>
			<!-- : ( Button : Sub ) (E) -->
		</div>
	</div> <!-- end of invoiceLayer[1] (ON) -->
	
	
	<!-- Off-dock CY Invoice -->
	<div id="invoiceLayer" name="invoiceLayer" style="display:none">
		<!-- TABLE '#D' : ( Tab ) (S) Coincidence / Discrepancy / Cost Calc.(TMNL) / Cost Calc.(SR by FD) / Cost Calc.(SR by FP) / -->
		<table class="tab">
           	<tr><td><script language="javascript">ComTabObject('offtab1')</script>
		</table>
		<!-- TABLE '#D' : ( Tab ) (E) -->

		<!-- UI_ESD_TES_004 : THIS IS 1st TAB -->
		<div id="offtabLayer" style="display:inline">
	
			<!-- TABLE '#D' : ( Tab BG Box ) (S) -->
	     	<table class="search" border="0">
	       	<tr><td class="bg">
	
	
				<!-- : ( Grid : Week ) (S) -->
				<!-- 'HEAD1-BGCOLOR : 203 240 169' , 'HEAD2-BGCOLOR : 222 251 248' , 'BORDER 1-outside : 88 152 164' ,
					 'BORDER 2-inside : 202 226 233' , 'HEAD-FONT : 39 95 101' , 'SELETED ROW BG : 252 255 233' -->
	
				<table width="100%" id="mainTable">
					<tr><td><script language="javascript">ComSheetObject('offdockt1sheet1');</script></td></tr>
				</table>
	
				<!-- : ( Grid : Week ) (E) -->
				</td></tr>
			</table>
			<!-- TABLE '#D' : ( Tab BG Box ) (E) -->

			<!-- : ( Button : Sub ) (S) -->
			<table class="button" border="0" width="100%">
				<tr><td class="btn2_bg" class="align">
					<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							
							<!-- Repeat Pattern -->
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2" name="btn_moreof1" id="btn_moreof1">More</td>
									<td class="btn2_right"></td></tr></table>
							</td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2" name="btn_downexcelof1" id="btn_downexcelof1">Down Excel</td>
									<td class="btn2_right"></td></tr></table>
							</td>

							<!-- Repeat Pattern -->
		
						</tr></table>
					</td></tr>
			</table>
			<!-- : ( Button : Sub ) (E) -->
	
		</div>
	
		<!-- UI_ESD_TES_005 : THIS IS 2st TAB -->
		<div id="offtabLayer" style="display:none">
	
			<!-- TABLE '#D' : ( Tab BG Box ) (S) -->
	     	<table class="search" border="0">
	       	<tr><td class="bg">
	
				<!-- : ( Grid : Week ) (S) -->
				<!-- 'HEAD1-BGCOLOR : 203 240 169' , 'HEAD2-BGCOLOR : 222 251 248' , 'BORDER 1-outside : 88 152 164' ,
					 'BORDER 2-inside : 202 226 233' , 'HEAD-FONT : 39 95 101' , 'SELETED ROW BG : 252 255 233' -->
				<table width="100%" id="mainTable">
                      <tr><td>
                           <script language="javascript">ComSheetObject('offdockt2sheet1');</script>
                      </td></tr>
	            </table>
	
				<!-- : ( Grid : Week ) (E) -->
	
				</td></tr>
			</table>
			<!-- TABLE '#D' : ( Tab BG Box ) (E) -->
			
			<!-- : ( Button : Sub ) (S) -->
			<table class="button" border="0" width="100%">
				<tr><td class="btn2_bg" class="align">
					<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							
							<!-- Repeat Pattern -->
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2" name="btn_downexcelof2" id="btn_downexcelof2">Down Excel</td>
									<td class="btn2_right"></td></tr></table>
							</td>

							<!-- Repeat Pattern -->
		
						</tr></table>
					</td></tr>
			</table>
			<!-- : ( Button : Sub ) (E) -->
	
		</div>
	
		<!-- UI_ESD_TES_006 : THIS IS 3st TAB -->
		<div id="offtabLayer" style="display:none">
	
			<!-- TABLE '#D' : ( Tab BG Box ) (S) -->
	     	<table class="search" border="0">
	       	<tr><td class="bg">
	
	
				<!-- : ( Grid : Week ) (S) -->
				<!-- 'HEAD1-BGCOLOR : 203 240 169' , 'HEAD2-BGCOLOR : 222 251 248' , 'BORDER 1-outside : 88 152 164' ,
					 'BORDER 2-inside : 202 226 233' , 'HEAD-FONT : 39 95 101' , 'SELETED ROW BG : 252 255 233' -->
				<table width="100%" id="mainTable">
					<tr><td><script language="javascript">ComSheetObject('offdockt3sheet1');</script></td></tr>
	            </table>
				<!-- : ( Grid : Week ) (E) -->
	
				</td></tr>
			</table>
			<!-- TABLE '#D' : ( Tab BG Box ) (E) -->
			
			<!-- : ( Button : Sub ) (S) -->
			<table class="button" border="0" width="100%">
				<tr><td class="btn2_bg" class="align">
					<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							
							<!-- Repeat Pattern -->
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2" name="btn_downexcelof3" id="btn_downexcelof3">Down Excel</td>
									<td class="btn2_right"></td></tr></table>
							</td>

							<!-- Repeat Pattern -->
		
						</tr></table>
					</td></tr>
			</table>
			<!-- : ( Button : Sub ) (E) -->
		</div>
	
		<!-- UI_ESD_TES_007 : THIS IS 4st TAB -->
		<div id="offtabLayer" style="display:none">
	
			<!-- TABLE '#D' : ( Tab BG Box ) (S) -->
	     	<table class="search" border="0">
	       	<tr><td class="bg">
	
				<!-- : ( Grid : Week ) (S) -->
				<!-- 'HEAD1-BGCOLOR : 203 240 169' , 'HEAD2-BGCOLOR : 222 251 248' , 'BORDER 1-outside : 88 152 164' ,
					 'BORDER 2-inside : 202 226 233' , 'HEAD-FONT : 39 95 101' , 'SELETED ROW BG : 252 255 233' -->
				<table width="100%" id="mainTable">
					<tr><td><script language="javascript">ComSheetObject('offdockt4sheet1');</script></td></tr>
	            </table>
				<!-- : ( Grid : Week ) (E) -->
	
				</td></tr>
			</table>
			<!-- TABLE '#D' : ( Tab BG Box ) (E) -->
			
			<!-- : ( Button : Sub ) (S) -->
			<table class="button" border="0" width="100%">
				<tr><td class="btn2_bg" class="align">
					<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							
							<!-- Repeat Pattern -->
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2" name="btn_downexcelof4" id="btn_downexcelof4">Down Excel</td>
									<td class="btn2_right"></td></tr></table>
							</td>

							<!-- Repeat Pattern -->
		
						</tr></table>
					</td></tr>
			</table>
			<!-- : ( Button : Sub ) (E) -->
		</div>
	
		<!-- UI_ESD_TES_008 : THIS IS 5st TAB -->
		<div id="offtabLayer" style="display:none">
	
			<!-- TABLE '#D' : ( Tab BG Box ) (S) -->
	     	<table class="search" border="0">
	       	<tr><td class="bg">
	
				<!-- : ( Grid : Week ) (S) -->
				<!-- 'HEAD1-BGCOLOR : 203 240 169' , 'HEAD2-BGCOLOR : 222 251 248' , 'BORDER 1-outside : 88 152 164' ,
				 'BORDER 2-inside : 202 226 233' , 'HEAD-FONT : 39 95 101' , 'SELETED ROW BG : 252 255 233' -->
				<table width="100%" id="mainTable">
					<tr><td><script language="javascript">ComSheetObject('offdockt5sheet1');</script></td></tr>
	            </table>
				<!-- : ( Grid : Week ) (E) -->
	
	
				</td></tr>
			</table>
			<!-- TABLE '#D' : ( Tab BG Box ) (E) -->
		
			
			<!-- : ( Button : Sub ) (S) -->
			<table class="button" border="0" width="100%">
				<tr><td class="btn2_bg" class="align">
					<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							
							<!-- Repeat Pattern -->
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2" name="btn_downexcelof5" id="btn_downexcelof5">Down Excel</td>
									<td class="btn2_right"></td></tr></table>
							</td>

							<!-- Repeat Pattern -->
		
						</tr></table>
					</td></tr>
			</table>
			<!-- : ( Button : Sub ) (E) -->
		</div>
	</div> <!-- end of invoiceLayer[2] (OF) -->

	<!-- Marine Terminal Strorage Invoice -->
	<div id="invoiceLayer" name="invoiceLayer" style="display:none">

		<!-- TABLE '#D' : ( Tab ) (S) Coincidence / Discrepancy / Cost Calc.(TMNL) / Cost Calc.(SR by FD) / Cost Calc.(SR by FP) / -->
		<table class="tab">
           	<tr><td><script language="javascript">ComTabObject('sttab1')</script>
		</table>
		<!-- TABLE '#D' : ( Tab ) (E) -->
		<!-- UI_ESD_TES_009 : THIS IS 1st TAB -->
		<div id="sttabLayer" style="display:inline">
		
			<!-- TABLE '#D' : ( Tab BG Box ) (S) -->
	     	<table class="search" border="0">
	       	<tr><td class="bg">
	
				<!-- : ( Grid : Week ) (S) -->
				<!-- 'HEAD1-BGCOLOR : 203 240 169' , 'HEAD2-BGCOLOR : 222 251 248' , 'BORDER 1-outside : 88 152 164' ,
					 'BORDER 2-inside : 202 226 233' , 'HEAD-FONT : 39 95 101' , 'SELETED ROW BG : 252 255 233' -->
				<table width="100%" id="mainTable">
                       <tr><td>
                            <script language="javascript">ComSheetObject('storaget1sheet1');</script>
                       </td></tr>
	            </table>
				<!-- : ( Grid : Week ) (E) -->

	
				</td></tr>
			</table>
			<!-- TABLE '#D' : ( Tab BG Box ) (E) -->

			<!-- : ( Button : Sub ) (S) -->
			<table class="button" border="0" width="100%">
				<tr><td class="btn2_bg" class="align">
					<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							
							<!-- Repeat Pattern -->
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2" name="btn_morest1" id="btn_morest1">More</td>
									<td class="btn2_right"></td></tr></table>
							</td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2" name="btn_downexcelst1" id="btn_downexcelst1">Down Excel</td>
									<td class="btn2_right"></td></tr></table>
							</td>

							<!-- Repeat Pattern -->
		
						</tr></table>
					</td></tr>
			</table>
			<!-- : ( Button : Sub ) (E) -->
		
		</div>
		
		<!-- UI_ESD_TES_010 : THIS IS 2st TAB -->
		<div id="sttabLayer" style="display:none">
		
			<!-- TABLE '#D' : ( Tab BG Box ) (S) -->
	     	<table class="search" border="0">
	       	<tr><td class="bg">
	
	
				<!-- : ( Grid : Week ) (S) -->
				<!-- 'HEAD1-BGCOLOR : 203 240 169' , 'HEAD2-BGCOLOR : 222 251 248' , 'BORDER 1-outside : 88 152 164' ,
					 'BORDER 2-inside : 202 226 233' , 'HEAD-FONT : 39 95 101' , 'SELETED ROW BG : 252 255 233' -->
	
						<table width="100%" id="mainTable">
	                        <tr><td>
	                             <script language="javascript">ComSheetObject('storaget2sheet1');</script>
	                        </td></tr>
			            </table>
	
	
				<!-- : ( Grid : Week ) (E) -->
	
				</td></tr>
			</table>
			<!-- TABLE '#D' : ( Tab BG Box ) (E) -->
			
			<!-- : ( Button : Sub ) (S) -->
			<table class="button" border="0" width="100%">
				<tr><td class="btn2_bg" class="align">
					<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							
							<!-- Repeat Pattern -->
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2" name="btn_downexcelst2" id="btn_downexcelst2">Down Excel</td>
									<td class="btn2_right"></td></tr></table>
							</td>

							<!-- Repeat Pattern -->
		
						</tr></table>
					</td></tr>
			</table>
			<!-- : ( Button : Sub ) (E) -->
		
		</div>
		
		<!-- UI_ESD_TES_011 : THIS IS 3st TAB -->
		<div id="sttabLayer" style="display:none">
		
			<!-- TABLE '#D' : ( Tab BG Box ) (S) -->
	     	<table class="search" border="0">
	       	<tr><td class="bg">
	
	
				<!-- : ( Grid : Week ) (S) -->
				<!-- 'HEAD1-BGCOLOR : 203 240 169' , 'HEAD2-BGCOLOR : 222 251 248' , 'BORDER 1-outside : 88 152 164' ,
					 'BORDER 2-inside : 202 226 233' , 'HEAD-FONT : 39 95 101' , 'SELETED ROW BG : 252 255 233' -->
	
						<table width="100%" id="mainTable">
	                        <tr><td>
	                             <script language="javascript">ComSheetObject('storaget3sheet1');</script>
	                        </td></tr>
			            </table>
	
				<!-- : ( Grid : Week ) (E) -->
	
				</td></tr>
			</table>
			<!-- TABLE '#D' : ( Tab BG Box ) (E) -->
			
			<!-- : ( Button : Sub ) (S) -->
			<table class="button" border="0" width="100%">
				<tr><td class="btn2_bg" class="align">
					<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							
							<!-- Repeat Pattern -->
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2" name="btn_downexcelst3" id="btn_downexcelst3">Down Excel</td>
									<td class="btn2_right"></td></tr></table>
							</td>

							<!-- Repeat Pattern -->
		
						</tr></table>
					</td></tr>
			</table>
			<!-- : ( Button : Sub ) (E) -->
		
		</div>
		
		<!-- UI_ESD_TES_012 : THIS IS 4st TAB -->
		<div id="sttabLayer" style="display:none">
		
			<!-- TABLE '#D' : ( Tab BG Box ) (S) -->
	     	<table class="search" border="0">
	       	<tr><td class="bg">
	
				<table width="100%" id="mainTable">
					<tr><td>
						<script language="javascript">ComSheetObject('storaget4sheet1');</script>
					</td></tr>
				</table>
	
				<!-- : ( Grid : Week ) (E) -->
				</td></tr>
			</table>
			<!-- TABLE '#D' : ( Tab BG Box ) (E) -->
			
			<!-- : ( Button : Sub ) (S) -->
			<table class="button" border="0" width="100%">
				<tr><td class="btn2_bg" class="align">
					<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							
							<!-- Repeat Pattern -->
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2" name="btn_downexcelst4" id="btn_downexcelst4">Down Excel</td>
									<td class="btn2_right"></td></tr></table>
							</td>

							<!-- Repeat Pattern -->
		
						</tr></table>
					</td></tr>
			</table>
			<!-- : ( Button : Sub ) (E) -->
		
		</div>
		
	</div> <!-- end of invoiceLayer[3] (ST) -->


</td></tr>
</table>
<!-- Outer Table (E)-->

</form>

</html>
<DIV style="display:none">
	<!-- : ( From Location ) (S) -->
		<table width="100%" id="mainTable">
			<tr><td>
				<script language="javascript">ComSheetObject('sheet2');</script>
			</td></tr>
		</table>
	<!-- : ( From Location ) (E) -->
</DIV>