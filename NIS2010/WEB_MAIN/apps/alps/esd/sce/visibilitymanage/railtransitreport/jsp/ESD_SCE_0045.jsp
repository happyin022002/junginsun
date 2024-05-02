<%
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_SCE_0045.jsp
*@FileTitle : Rail Transit Report
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-22
*@LastModifier : Seong-mun Kang
*@LastVersion : 1.0
* 2006-11-28 Seong-mun Kang
* 1.0 최초생성
* 2011.07.25 손은주 [CHM-201112118-01]	Rail Transit Report의 Remark Column 이원화 및 활성화 요청.
* 2011.08.30 김영철 [] [SCE] RTR상에 36 OVER OPTION 추가요청
* 2012.03.12 채창호 [CHM-201216647-01] Rail Transit Report 상에, Empty Cargo 조회 보완요청
* 2012.03.29 박찬민 [CHM-201216948] 개발-Rail Transit Report상의 일부항목 변경 및 보완
==========================================================*/
%> 
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.sce.visibilitymanage.railtransitreport.event.EsdSce0045Event"%>
<%@ page import="com.hanjin.apps.alps.esd.sce.common.util.basic.CodeUtilBC" %>
<%@ page import="com.hanjin.apps.alps.esd.sce.common.util.basic.CodeUtilBCImpl" %>
<%@ page import="com.hanjin.framework.component.util.StringUtil" %>
<%
		CodeUtilBC codeUtil = new CodeUtilBCImpl() ;
		EsdSce0045Event  event = null;                		//PDTO(Data Transfer Object including Parameters)
		Exception serverException   = null;            			//???밿?????? 뮿?????? ??????

		String strErrMsg = "";                                  //?????￢???¸꽿
		DBRowSet rowSet      = null;                            //DB ResultSet
		int rowCount     = 0;                                   //DB ResultSet 리꿤뿸꽿 건꽿
		SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
    	String userId=account.getUsr_id();
        String openMode = StringUtil.xssFilter(request.getParameter("openMode"));
        String parentScNo = StringUtil.xssFilter(request.getParameter("parentScNo"));
    	
    	try{
	    	serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
	    	if (serverException != null) {
	            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
	        }else{
	        	event = (EsdSce0045Event)request.getAttribute("Event");
	        }
		} catch(Exception e) {
	        out.println(e.toString());
	    }
%>

<%
	int rowSize = 6000 ;
%>

<html>
<head>
<title>Welcome to enis!</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">

    function setupPage(){
        loadPage();
    }

    <%=JSPUtil.getIBCodeCombo("s_cntr_tp_sz", "01", "CD03552", 0, "")%>
</script>

</head>

<body onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="row_size" value="<%=rowSize%>">
<input type="hidden" name="rBkgNo">
<input type="hidden" name="toDt">
<input type="hidden" name="cgoTpCd">
<input type="hidden" name="custCntSeq">
<input type="hidden" name="customerLoc">
<input type="hidden" name="toNodCd">
<input type="hidden" name="bkgNo">
<input type="hidden" name="rCntrNo">
<input type="hidden" name="blNo">
<input type="hidden" name="rVvdCd">
<input type="hidden" name="vvdCd">
<input type="hidden" name="bkgOfcCd">
<input type="hidden" name="eqNo">
<input type="hidden" name="rBlNo">
<input type="hidden" name="cstmsAcptFlg">
<input type="hidden" name="podPol">
<input type="hidden" name="trspBndCd">
<input type="hidden" name="rCustCntCd">
<input type="hidden" name="fmNodCd">
<input type="hidden" name="rOrigin">
<input type="hidden" name="rPolpod">
<input type="hidden" name="scNo">
<input type="hidden" name="rDest">
<input type="hidden" name="fmDt">
<input type="hidden" name="railcompVal">
<input type="hidden" name="rCustSeq">
<input type="hidden" name="dateKind">
<input type="hidden" name="searchtypeStr">
<input type="hidden" name="dwellKind">
<input type="hidden" name="dwellTime">
<input type="hidden" name="tDep">
<input type="hidden" name="oDep">
<input type="hidden" name="loc">
<input type="hidden" name="openMode" value="<%=openMode%>">
<input type="hidden" name="parentScNo" value="<%=parentScNo%>">

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
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_save" id="btn_save">Save</td><td class="btn1_right"></td></tr></table></td>	
											<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr><td class="btn1_left"></td><td class="btn1" name="btn_new" id="btn_new">New</td><td class="btn1_right"></td></tr></table></td>
											<td class="btn1_line"></td>
											<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr><td class="btn1_left"></td><td class="btn1" name="btn_bkginfo" id="btn_bkginfo">Booking Info</td><td class="btn1_right"></td></tr></table></td>
											<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr><td class="btn1_left"></td><td class="btn1" name="btn_clm" id="btn_clm">CLM</td><td class="btn1_right"></td></tr></table></td>
											<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr><td class="btn1_left"></td><td class="btn1" name="btn_downexcel" id="btn_downexcel">Down Excel</td><td class="btn1_right"></td></tr></table></td>
											<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr><td class="btn1_left"></td><td class="btn1" name="btn_uploadexcel" id="btn_uploadexcel">Upload Excel</td><td class="btn1_right"></td></tr></table></td>	
											<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr><td class="btn1_left"></td><td class="btn1" name="btn_downcsv" id="btn_downcsv">Down TXT</td><td class="btn1_right"></td></tr></table></td>
											<!-- Repeat Pattern -->

										</tr></table>

								</td></tr>
						</table>
		<!-- TABLE '#D' : ( Button : Main ) (E) -->

		<!-- TABLE '#D' : ( Search Options ) (S) -->
		<table class="search">
			<tr>
				<td class="bg">
					<table class="search_in" border="0">
						<tr class="h23">
							<td width="340">
								<select name="date_kind" style="width:140;" onChange="chgDateKind(this.value)">
								<!--<option value="S" selected="selected"></option>-->
								<option value="" selected="selected"></option>
								<option value="S">S/O Creation DT.</option>
								<option value="A">DEST. Available DT.</option>
								<option value="O">DEST. Out-Gate DT.</option>
								<option value="I">Origin In-Gate DT.</option>
								<option value="D">Vessel Discharge DT.</option>
								<option value="P">Origin Departure</option>
								</select>
								<input name="fm_dt" type="text" class="input" style="width:70; text-transform:uppercase;" maxlength="8" minlength="8" dataformat="ymd" required  >&nbsp;~&nbsp;<input maxlength="8" minlength="8" dataformat="ymd" required cofield="fm_dt" name="to_dt" type="text" class="input" style="width:70; text-transform:uppercase;" >&nbsp;<img name="btn_calendar" class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle"></td>
							<td width="40">Origin</td>
							<td width="140"><input onKeyUp="ComChkObjValid(this)" onBlur="ComChkObjValid(this)" name="fm_nod_cd" type="text" class="input" dataformat="engup" style="width:60; text-transform:uppercase;"> <img onClick="openNodePop(false,'fm_nod_cd')" class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
							<td width="35">DEST</td>
							<td width="140"><input onKeyUp="ComChkObjValid(this)" onBlur="ComChkObjValid(this)" name="to_nod_cd" type="text" class="input" dataformat="engup" style="width:60; text-transform:uppercase;"> <img onClick="openNodePop(false,'to_nod_cd')" class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
							<td width="60">Full / MT</td>
							<!-- <td width="65"><select name="full_mty_cd" style="width:48;"> -->
							<td width="100"><select name="cgo_tp_cd"  onChange="chgBound(this.value)" style="width:48;">
							<option value="">ALL</option>
							<option value="F" selected>Full</option>
							<option value="M">MT</option>
							</select></td>
							<td width="45">Bound</td>
							<td width=""><select name="trsp_bnd_cd" style="width:51;">
							<option value="" selected>ALL</option>
							<option value="I" selected>In</option>
							<option value="O">Out</option>
							</select></td>

						</tr>
					</table>
					<table class="search_in" border="0">
						<tr class="h23">
							<td width="115">
							<table width="100%">
								<tr><td class="btn2_bg">
									<table border="0" cellpadding="0" cellspacing="0">
									<tr>
										<!-- Repeat Pattern -->
										<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn2_left"></td><td class="btn2" name="btns_multiinput" id="btns_multiinput">Multi Input</td>
										<td class="btn2_right"></td></tr></table></td>
										<!-- Repeat Pattern -->
									</tr></table>
								</td></tr>
							</table>

							<td width="57">Booking</td>
							<Td width="168"><input onKeyUp="ComChkObjValid(this)" onBlur="ComChkObjValid(this)" name="bkg_no" type="text" class="input" dataformat="engup" style="width:120; text-transform:uppercase;" value="">
							<img onClick="openAddPaste('bkg_no')" class="cursor" src="/hanjin/img/button/btng_plus.gif" width="19" height="20" border="0" align="absmiddle"></td>
							<td width="40">B/L</td>
							<td width="140"><input onKeyUp="ComChkObjValid(this)" onBlur="ComChkObjValid(this)" name="bl_no" type="text" class="input" dataformat="engup" style="width:110; text-transform:uppercase;">
							<img onClick="openAddPaste('bl_no')" class="cursor" src="/hanjin/img/button/btng_plus.gif" width="19" height="20" border="0" align="absmiddle"></td>

							<td width="35">CNTR</td>
							<!-- <td width="140">&nbsp;<input onKeyUp="ComChkObjValid(this, 'eng_num', true, 11)" onBlur="ComChkObjValid(this, 'eng_num', true, 11)" name="eq_no" type="text" class="input" style="width:112; text-transform:uppercase;"></td> -->
							<td width="140"><input name="eq_no" type="text" class="input" style="width:112; text-transform:uppercase;"  onBlur='javascript:this.value=this.value.toUpperCase();'  onChange="CheckDigit(this)"  onKeyUp="CheckDigit(this)" >
							<img onClick="openAddPaste('eq_no')" class="cursor" src="/hanjin/img/button/btng_plus.gif" width="19" height="20" border="0" align="absmiddle"></td>
							<td width="60">VVD</td>
							<td width="84"><input onKeyUp="ComChkObjValid(this)" onBlur="ComChkObjValid(this)" name="vvd" type="text" class="input" dataformat="engup" style="width:78; text-transform:uppercase;"></td>
							<td width="" colspan="2"><img class="cursor" onClick="openVVDPop(false,'vvd')" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
						</tr>
					</table>
					<table class="search_in" border="0">
						<tr class="h23">
							<td width="75">Dwell</td>
							<td width="185">
								<select name="dwell_kind" style="width:75;" onChange="chgDwell(this.value)">
								<option value=""></option>
								<option value="T">TMNL</option>
								<option value="O">ORG</option>
								<option value="I1">INI I</option>
								<option value="I2">INI II</option>
								<option value="D1">DEST I</option>
								<option value="D2">DEST II</option>
								<option value="C">CURR</option>
								</select>&nbsp;<select name="dwell_time" style="width:70;" disabled>
								<option value=""></option>
								<option value="1">0~24</option>
								<option value="2">25~48</option>
								<option value="3">49~72</option>
								<option value="4">73~96</option>
								<option value="5">24Over</option>
								<option value="9">36Over</option>
								<option value="6">48Over</option>
								<option value="7">72Over</option>
								<option value="8">96Over</option>
								</select>
							</td>
							<td width="120">TMNL Departure</td>
							<td width="80">
								<select name="t_dep" style="width:44;">
								<option value="" selected>All</option>
								<option value="Y">Y</option>
								<option value="N">N</option>
								</select>
							</td>
							
							<td width="120">ORG Departure</td>
							<td width="80">
								<select name="o_dep" style="width:44;">
								<option value="" selected>All</option>
								<option value="Y">Y</option>
								<option value="N">N</option>
								</select>
							</td>
							
							<td width="100">Rail Company</td>
							<td>
								<!-- <select name="railcomp" style="width:345;"> -->
								<select name="railcomp" style="width:190;">
								<option value="" selected>ALL</option>
								<option value="105475">CANADIAN NATIONAL</option>
								<option value="105480">CANADIAN PACIFIC RAIL</option>
								<option value="105484">FLORIDA EAST COAST RAILWAY</option>
								<option value="105490">UNION PACIFIC RAILROAD</option>
								<option value="108299">NORFOLK SOUTHERN RAILWAY CO.</option>
								<option value="108386">KCS RAILWAY (KC)</option>
								<option value="108623">CSX INTERMODAL INC.</option>
								<option value="108829">CSX TRANSPORTATION (CHI-PIT)</option>
								<option value="119993">BURLINGTON NORTHERN AND SANTA FE RAILROAD</option>
								<option value="152645">INNOVATIVE RAIL GROUP</option>
								<option value="123592">NORTHWEST CONTAINER SERVICES (PDX-SML)</option>
							</select></td>
						</tr>
					</table>
					<table class="search_in" border="0">
						<tr class="h23">
							<td width="75" >BKG Office</td>
							<td width="265"><input name="bkg_ofc_cd" type="text" onKeyUp="ComChkObjValid(this)" onBlur="ComChkObjValid(this)" dataformat="engup" style="width:97; text-transform:uppercase;" value="">
								<img name="btn_bkg_ofc" class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle">&nbsp;
								<input type="checkbox" name="chk_office" value="Y" class="trans" onClick="javascript:fun_chkOffice();">Incl. Sub OFC.
							</td>
							<td width="42" >TP/SZ</td>
							<td width="139" ><script language="javascript">ComComboObject('cntr_tpsz',1,99,0,0,0);</script></td>
							<td width="85">Customer</td>
							<td width="" ><input name="cust_cnt_seq" type="text" style="width:70; text-transform:uppercase;" value="">
								<img onclick="openCustPop(false,'cust_cnt_seq','cust_nm', '')" class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle">
								<input name="cust_nm" type="text" style="width:248" value="" readonly>
							</td>
						</tr>
					</table>
					<table class="search_in" border="0">
						<tr class="h23">
							<td width="75">POL/POD</td>
							<!-- <td width="105">&nbsp;<input name="pod_pol" onKeyUp="ComChkObjValid(this, 'eng_num', true, 7)" onBlur="ComChkObjValid(this, 'eng_num', true, 7)" type="text" class="input" style="width:60; text-transform:uppercase;" onKeyUp="" onBure="">&nbsp;<img onClick="openLocPop(false,'pod_pol')" class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td> -->
							<td width="135"><input name="pod_pol" onKeyUp="ComChkObjValid(this)" onBlur="ComChkObjValid(this)" type="text" class="input" dataformat="engup" style="width:60; text-transform:uppercase;" onKeyUp="" onBure="">&nbsp;<img onClick="openNodePop(false,'pod_pol')" class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
							<td width="55">S/C No.</td>
							<td width="135"><input onKeyUp="ComChkObjValid(this)" onBlur="ComChkObjValid(this)" name="sc_no" type="text" class="input" dataformat="engup" style="width:95; text-transform:uppercase;"></td>
							<td width="60">Customs</td>
							<td width="168"><select name="cstms_acpt_flg" style="width:112;">
								<option value="" >ALL</option>
								<option value="Y" >Cleared</option>
							<!-- <option value="N" >Not Cleared</option> -->
								<option value="J" >Not Cleared</option>
								</select>
							</td>
							<td width="75">C/Location</td>
							<td width="105"><select name="customer_loc" style="width:65;">
								<option value="" >ALL</option>
								<option value="L" >Local</option>
								<option value="I" >IPI</option>
								</select></td>

							<td width="75" style="color:blue;">TotalCount</td>
							<td><input type="text" style="width:68" name="totcnt" readonly style="color:blue;"></td>

							<!-- <td width="40">Hold</td>
							<td >&nbsp;<select name="hold" style="width:50;">
							<option value="" >ALL</option>
							<option value="Y" >Y</option>
							<option value="N" >N</option>
							</select></td> -->
						</tr>

					</table>

				</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->


		<table class="height_10"><tr><td></td></tr></table>


		<!-- TABLE '#D' : ( Tab BG Box ) (S) -->
     	<table class="search" border="0">
			<tr>
				<td class="bg">
					<table class="height_10"><tr><td></td></tr></table>

					<!-- : ( grid ) (S) -->
                    <table width="100%" id="mainTable">
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet1');</script>
                        </td></tr>
                        <tr><td>
                             <div id="tabLayer" style="display:none"> <!-- 조회 조건 삽입  -->
								<script language="javascript">ComSheetObject('sheet2');</script>
							</div>
                        </td></tr>
                    </table>

					<!-- : ( grid ) (E) -->


			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Tab BG Box ) (E) -->
		<!-- ####### TABLE '#D' ::: 'RIGHT' FRAME (END) ####### -->


	</td></tr>
</table>
</form>
<!-- TABLE '#B' : 'Left + Right Body' Table (E)nd -->
    </td></tr>
</table>
<!-- Outer Table (E)-->


<span id="new_form"></span>
</body>
</html>


  
