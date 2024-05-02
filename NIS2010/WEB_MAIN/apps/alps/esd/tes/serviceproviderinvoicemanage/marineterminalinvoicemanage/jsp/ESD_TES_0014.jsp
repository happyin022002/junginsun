<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TES_0014.jsp
*@FileTitle : Terminal Invoice 상세내역 조회
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-30
*@LastModifier : kimjinjoo
*@LastVersion : 1.0
* 2007-10-12 kimjinjoo
* 1.0 최초 생성
* 2011.06.10 [CHM-201111056-01] Split 03-Split 07-ALPS Error 처리 요청
=========================================================*/
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.event.EsdTes0014Event"%>
<%!
	 String tesMakeCode(String code, String splitKey){
	    if(code==null) 		code = "";
	    if(splitKey==null) 	splitKey = ""; 
	
		String [] 	tempArr 	= code.split(splitKey);
		String 		tempStr 	= "";
	
		if(tempArr!=null && tempArr.length>1){
			if(tempArr[0].lastIndexOf("<OPTION")!=-1){
				tempArr[0] = tempArr[0].substring(0,tempArr[0].lastIndexOf("<OPTION"));		
			}
			if(tempArr[1].indexOf("<OPTION")!=-1){	
				tempArr[1] = tempArr[1].substring(tempArr[1].indexOf("<OPTION"), tempArr[1].length());
			}
	
			tempStr = tempArr[0]+ tempArr[1];
		}
	
		if(tempStr.indexOf("<SELECT")==-1){
			tempStr="<SELECT name = 'tml_inv_sts_cd' width='150'> <OPTION  value=''> </OPTION>"+tempStr;
		}
		if(tempStr.indexOf("</SELECT>")==-1){
			tempStr=tempStr+"</SELECT>";
		}
		
		return tempStr;
}
%>
<%
	EsdTes0014Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	//ESD_TES_0014EventResponse eventResponse = null;	//RDTO(Data Transfer Object including DB ResultSet)
	Exception serverException   = null;			//서버에서 발생한 에러
	DBRowSet rowSet	  = null;							   //DB ResultSet
	String strErrMsg = "";								 //에러메세지
	int rowCount	 = 0;								  //DB ResultSet 리스트의 건수
	String ofcCd = "";


	try {

	   SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   //userId=account.getUsr_id();
	   //userAuth=account.getAuth();
	   ofcCd = account.getOfc_cd()!=null&&!account.getOfc_cd().equals("")?account.getOfc_cd():"";

		event = (EsdTes0014Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
	strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}else{
	/*
	eventResponse = (ESD_TES_0014EventResponse)request.getAttribute("EventResponse");
	if (eventResponse != null) {
		rowSet = eventResponse.getRs();
		if(rowSet != null){
			 rowCount = rowSet.getRowCount();
		} // end if
	} // end if
	*/
		} // end else
	}catch(Exception e) {
		out.println(e.toString());
	}


	//3번째 파라메터가 "width='500'"TML_INV_RJCT_STS_CD
	String addRowBound = "10: ";
	String actionInvDateBox   = JSPUtil.getCodeCombo("inv_date_type", "01", "width='100'", "CD01364", 0, addRowBound);
	String actionInvStatusBox = JSPUtil.getCodeCombo("tml_inv_sts_cd","01", "width='150'", "CD00172", 0, addRowBound);
	
	actionInvStatusBox = tesMakeCode(actionInvStatusBox, "EDI Received");
//64", 0, addRowBound);
%>
<html>
<head>
<title>Terminal Expense Inquiry</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript" src="/hanjin/rpt/script/rdviewer50.js"></script>
<script language="javascript">
	var ofc_cd = '<%=JSPUtil.getNull(ofcCd)%>';
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";

        var actionInvStatusBox	= '';
        
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
//### =========================================================================
//### 탭을 사용하는 화면인 경우 추가한다.
		// InitTab();
//### =========================================================================
		loadPage();
	}
</script>

</head>
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input	type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="DB_DATE"					value="">
<input type="hidden" name="tml_inv_tp_cd"			value="">
<input type="hidden" name="is_valid_yd_cd"			value="">
<input type="hidden" name="yd_cd_hidden"			value="">
<input type="hidden" name="yd_cd_deltflg"			value="">
<input type="hidden" name="yd_cd_name"				value="">
<input type="hidden" name="yd_cd"					value="">

<input type="hidden" name="is_valid_cost_ofc_cd"	value="">
<input type="hidden" name="cost_ofc_cd_hidden"		value="">
<input type="hidden" name="cost_ofc_cd_deltflg"		value="">
<input type="hidden" name="is_valid_inv_ofc_cd"		value="">
<input type="hidden" name="inv_ofc_cd_hidden"		value="">
<input type="hidden" name="inv_ofc_cd_deltflg"		value="">
<input type="hidden" name="cost_code"				value="">
<input type="hidden" name="cntr_sty_code"			value="">
<input type="hidden" name="cre_ofc_cd" 				value="<%=JSPUtil.getNull(ofcCd)%>">

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
					<td width="">
						<table border="0">
							<tr class="h23">
								<td width="2"></td>
								<td width="90"><img class="nostar">Invoice DT</td>
								<td width=""><%=actionInvDateBox%></td>
								<td width="">&nbsp;<input type="text" style="width:75" value="" name= "fm_prd_dt" maxlength=10 onKeyUp='isNum1(this);tes_isNumD(this,"Y");tes_moveFocus(this, to_prd_dt, 10);' onKeyDown='chkInput(this);' OnBlur='this.value=ComGetMaskedValue(this.value, "ymd");'>&nbsp;<img class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar1">&nbsp;~</td>
								<td width="" colspan="3"><input type="text" style="width:75" value="" name ="to_prd_dt" maxlength=10   onKeyUp='isNum1(this);tes_isNumD(this,"Y");' onKeyDown='chkInput(this);' OnBlur='this.value=ComGetMaskedValue(this.value, "ymd");'>
								<img class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar2"></td>
							</tr>
						</table>
					</td>
				</tr>

				<tr>
					<td width="">
						<table border="0">
							<tr class="h23">
								<td width="92"><img class="nostar">Yard Code</td>
								<td width="48"><input type="text" style="width:42" name="loc_cd" maxlength=5 onKeyUp='upper(this);getNodeCodeCombo(this);'></td>
								<td width="49"><script language="javascript">ComComboObject('nod_cd', 1, 45, 0)</script></td>
								<td width="138"><img class="cursor" src="/hanjin/img/button/btns_search.gif"  name="btn_yard" width="19" height="20" border="0" align="absmiddle"></td>
								<!--
								<td>&nbsp;<input type="text" style="width:50" name="loc_cd" maxlength=5 onKeyUp='upper(this);getNodeCodeCombo(this);'>&nbsp;<script language="javascript">ComComboObject('nod_cd', 1, 45, 0)</script>
								&nbsp;<img class="cursor" src="/hanjin/img/button/btns_search.gif"  name="btn_yard" width="19" height="20" border="0" align="absmiddle">
								</td>
								-->
								<td width="105">S/P Code</td>
								<td  width=""><input type="text" name="vndr_seq" style="width:115" value="" maxlength=6 onKeyUp='chkInput(this);isNum(this);' onBlur='validateVNDRCode();'>&nbsp;<img class="cursor" src="/hanjin/img/button/btns_search.gif" name="btn_vndr" width="19" height="20" border="0" align="absmiddle"></td>
								<td  width="">&nbsp;<input type="text" style="width:320" name="vndr_seq_name" value=""><input type="hidden" name="vndr_seq_hidden" value=''><input type="hidden" name="is_valid_vndr_seq" value=''><input type="hidden" name="vndr_seq_deltflg" value=''>
								</td>
							</tr>
						</table>
					</td>

				</tr>

				<tr>
					<td width="">
						<table border="0">
							<tr class="h23">
								<td width="92"><img class="nostar">Cost Office</td>
								<td><input type="text" name="cost_ofc_cd" style="width:91" onKeyUp='chkInput(this);upper(this);isAlpha(this);' onBlur='validateCostOFCCode();'>
								</td>
								<td width="142" class="stm">&nbsp;<img class="cursor" src="/hanjin/img/button/btns_search.gif" name="btn_cost_ofc_cd" width="19" height="20" border="0" align="absmiddle">&nbsp;<input name="sub_office1" type="checkbox" value="" class="trans" onClick="javascript:getSubOffice1();">&nbsp;Incl. Sub OFC
								</td>
								<td width="105">Invoice Office</td>
								<td width="250" class="stm"><input type="text" name="inv_ofc_cd" onKeyUp='isAlpha(this);chkInput(this);upper(this);' onBlur='validateInvOFCCode();' style="width:115"> <img class="cursor" src="/hanjin/img/button/btns_search.gif" name="btn_inv_ofc_cd" width="19" height="20" border="0" align="absmiddle">&nbsp;<input name="sub_office2" type="checkbox" value="" class="trans" onClick="javascript:getSubOffice2();">&nbsp;Incl. Sub OFC</td>
								<td width="50"><img class="nostar">VVD</td>
								<td><input typ="text" style="width:162" name="vvd" onKeyUp='ComIsAlphabet(this);upper(this);'  maxlength=9 onKeyDown='ComIsAlphabet(this);upper(this);'></td>
							</tr>
						</table>
					</td>
				</tr>

				<tr>
					<td  width="">
						<table border="0">
							<tr class="h23">
								<td width="92"><img class="nostar">Cost Type</td>
								<td width=""  class="stm">ALL<input type="checkbox" value="" desc="ALL" class="trans" name="cost_tp" onclick="initCheckBox()">&nbsp;&nbsp;&nbsp;
																					TP<input type="checkbox" value="" desc="TP" class="trans" name="cost_tp" onclick="cost_tpOnclick()">&nbsp;&nbsp;&nbsp;
																					SV<input type="checkbox" value="" desc="SV" class="trans" name="cost_tp" onclick="cost_tpOnclick()">&nbsp;&nbsp;&nbsp;
																					TM<input type="checkbox" value="" desc="TM" class="trans" name="cost_tp" onclick="cost_tpOnclick()">&nbsp;&nbsp;&nbsp;
																					SR<input type="checkbox" value="" desc="SR" class="trans" name="cost_tp" onclick="cost_tpOnclick()">&nbsp;&nbsp;&nbsp;
																					CG<input type="checkbox" value="" desc="CG" class="trans" name="cost_tp" onclick="cost_tpOnclick()">&nbsp;&nbsp;&nbsp;
																					ET<input type="checkbox" value="" desc="ET" class="trans" name="cost_tp" onclick="cost_tpOnclick()"><!--&nbsp;&nbsp;&nbsp;
																					FL<input type="checkbox" value="" desc="F" class="trans" name="cntr_tp" >&nbsp;&nbsp;&nbsp;
																					MT<input type="checkbox" value="" desc="M" class="trans" name="cntr_tp" >
																					</td>-->
									</td>
									<td width="270"><td width="80"><img class="nostar">Invoice STS</td>
								    <td><%=actionInvStatusBox%></td>
									<!--<td width="450"  class="stm">&nbsp;&nbsp;&nbsp;ALL<input type="checkbox" value="" desc="'ALL'" class="trans" name="cost_tp">&nbsp;&nbsp;&nbsp;
																					TP<input type="checkbox" value="" desc="'TP'" class="trans" name="cost_tp">&nbsp;&nbsp;&nbsp;
																				SV<input type="checkbox" value="" desc="'SV'" class="trans" name="cost_tp">&nbsp;&nbsp;&nbsp;
																					TM<input type="checkbox" value="" desc="'TM'" class="trans" name="cost_tp">&nbsp;&nbsp;&nbsp;
																					SR<input type="checkbox" value="" desc="'SR'" class="trans" name="cost_tp">&nbsp;&nbsp;&nbsp;
																					CG<input type="checkbox" value="" desc="'CG'" class="trans" name="cost_tp">&nbsp;&nbsp;&nbsp;
																					ET<input type="checkbox" value="" desc="'ET'" class="trans" name="cost_tp">&nbsp;&nbsp;&nbsp;
																					FL<input type="checkbox" value="" desc="'F'" class="trans" name="cntr_tp">&nbsp;&nbsp;&nbsp;
																					MT<input type="checkbox" value="" desc="'M'" class="trans" name="cntr_tp"></td>
									</td>
									-->
									<!--<td width="66">Volume</td>
									<td width="138" class="stm">Show&nbsp;<input type="radio" name="vol_show_mode" value="Y" class="trans" onclick="vol_show_mode_sts()">&nbsp;
																Hide<input type="radio" name="vol_show_mode" value="N" class="trans" onclick="vol_show_mode_sts()"></td>
									-->

							</tr>
						</table>
					</td>
				</tr>

				<tr>
					<td width="">
						<table border="0">
							<tr class="h23">
								<td width="92"><img class="nostar">Full/Empty</td>
								<td width="375"  class="stm">&nbsp;&nbsp;FL<input type="checkbox" value="" desc="F" class="trans" name="cntr_tp">&nbsp;&nbsp;&nbsp;
									MT<input type="checkbox" value="" desc="M" class="trans" name="cntr_tp">
								</td>
								<td width="70"><img class="nostar">Volume</td>
								<td width="" class="stm">Show&nbsp;<input type="radio" name="vol_show_mode" value="Y" class="trans" onclick="vol_show_mode_sts()">&nbsp;
								Hide<input type="radio" name="vol_show_mode" value="N" class="trans" onclick="vol_show_mode_sts()"></td>
							</tr>
						</table>
					</td>
				</tr>

				</table>
				<!-- : ( Week ) (E) -->


			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options : ) (E) -->


		<table class="height_10"><tr><td></td></tr></table>

		<!-- TABLE '#D' : ( Tab BG Box ) (S) -->
     	<table class="search" border="0">
       	<tr><td class="bg">

			<!-- : ( Grid : Week ) (S) -->
			<!-- 'HEAD1-BGCOLOR : 203 240 169' , 'HEAD2-BGCOLOR : 222 251 248' , 'BORDER 1-outside : 88 152 164' ,
				 'BORDER 2-inside : 202 226 233' , 'HEAD-FONT : 39 95 101' , 'SELETED ROW BG : 252 255 233' -->

					<table width="100%" id="mainTable">
                        <tr><td>
                        	<div id="SearchLayer1" style="display:none">
                             <script language="javascript">ComSheetObject('sheet1');</script>
                            </div>
                        	<div id="SearchLayer2" style="display:inline">
                             <script language="javascript">ComSheetObject('sheet2');</script>
                            </div>
                        </td></tr>
		            </table>


			<!-- : ( Grid : Week ) (E) -->


			<!-- : ( Button : Sub ) (S) -->
			<table class="button" border="0" width="100%">
							       	<tr><td class="btn2_bg" class="align">
									<table border="0" cellpadding="0" cellspacing="0">
									<tr>

										<!-- Repeat Pattern -->
										<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr><td class="btn2_left"></td><td class="btn2" name="btn_more" id="btn_more">More</td>
												<td class="btn2_right"></td></tr></table>
										</td>
										<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr><td class="btn2_left"></td><td class="btn2" name="btng_downexcel" id="btng_downexcel">Down Excel</td>
												<td class="btn2_right"></td></tr></table>
										</td>

										<!-- Repeat Pattern -->


									</tr></table>
								</td></tr>
					</table>
	    	<!-- : ( Button : Sub ) (E) -->


			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Tab BG Box ) (E) -->
</td></tr>
</table>
<!-- Outer Table (E)-->

</form>
</body>
</html>