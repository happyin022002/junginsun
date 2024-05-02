<%
/*=========================================================
*Copyright(c) 2008 CyberLogitec
*@FileName : ESD_SCE_0072.jsp
*@FileTitle : EDI Performance Report
*Open Issues :
*Change history :
* 2008-03-28 sanghyun kim
* 1.0 최초 생성
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.event.EsdSce0072Event"%>
<%//@ page import="com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.event.EsdSce0072EventResponse"%>
<%@ page import="com.hanjin.apps.alps.esd.sce.common.util.basic.CodeUtilBC" %>
<%@ page import="com.hanjin.apps.alps.esd.sce.common.util.basic.CodeUtilBCImpl" %>
<%@ page import="com.hanjin.framework.core.layer.event.EventResponse"%>

<%
	CodeUtilBC codeUtil = new CodeUtilBCImpl() ;
    EsdSce0072Event  event = null;                		//PDTO(Data Transfer Object including Parameters)
    //EsdSce0072EventResponse eventResponse = null;    	//RDTO(Data Transfer Object including DB ResultSet)
    EventResponse eventResponse = null;    	//RDTO(Data Transfer Object including DB ResultSet)
	Exception serverException   = null;            			//서버에서 발생한 에러

	String strErrMsg = "";                                  //에러메세지

	DBRowSet rowSet      = null;                            //DB ResultSet
	int rowCount     = 0;                                   //DB ResultSet 리스트의 건수
	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	String userId=account.getUsr_id();
	String officeId = account.getOfc_cd();
	String userIdSub = userId.substring(0,3);

	int ofcKndCd = codeUtil.searchOfcInfo(officeId);
	
	try{
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if(serverException != null){
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		} else {
			event = (EsdSce0072Event)request.getAttribute("Event");
            eventResponse = (EventResponse)request.getAttribute("EventResponse");
            if (eventResponse != null) {
                //rowSet = eventResponse.getRowSet();
                rowSet = eventResponse.getRs();
                if(rowSet != null){
                     rowCount = rowSet.getRowCount();
                } // end if
            } // end if
		}
	} catch(Exception e) {
        out.println(e.toString());
    }
%>
<html>
<head>
<title>Welcome to enis!</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">

	function setupPage(){
		loadPage();
		var formObject = document.form ;
	}

</script>
</head>

<body onLoad="setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd">
<input type="hidden" name="cust_cd">
<input type="hidden" name="edi_sts">
<input type="hidden" name="bzc_col">
<input type="hidden" name="user_id" value=<%=userId%>>
<input type='hidden' name="podetadate1_hidden">
<input type='hidden' name="podetadate2_hidden">
<input type='hidden' name="poletddate1_hidden">
<input type='hidden' name="poletddate2_hidden">
<input type='hidden' name="fm_dt">
<input type='hidden' name="to_dt">
<input type="hidden" name="office_id" value=<%=officeId%>>
<input type="hidden" name="cre_usr_id" value=<%=userId%>>
<input type="hidden" name="ofc_knd_cd" value=<%=ofcKndCd%>>


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
											<td class="btn1_line"></td>
											<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr><td class="btn1_left"></td><td class="btn1" name="btn_saveas" id="btn_saveas">Save As</td><td class="btn1_right"></td></tr></table></td>
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
							<td width="115"><img class="nostar">Customer</td>
							<td width="">
							<input type ='hidden' name=cs value="test">
							<input class="input1" name="cs_grp_id" type="text"  class="input" style="width:80; text-transform:uppercase;" value="" onfocusout="javascript:onObjectFocusout(this.form)">
							<input class="input1" name="tp_id" type="text"  class="input" style="width:80; text-transform:uppercase;" value="" onfocusout="javascript:onObjectTpId(this.form)">
							<input class="input1" name="grp_nm" type="text"  class="input" style="width:650; text-transform:uppercase;" value="" >
							<img onClick="openCustomer()" class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle">
							</td>
						</tr>
					</table>
					<table class="search_in" border="0">
						<tr class="h23">
							<td width="113"><img class="nostar">EDI Status</td>
							<td width=""><!--   -->
							<input name="edi_sts_con" type="text"  class="input" style="width:164; text-transform:uppercase;" value="" onchange="javascript:searchEdiGrpCgoSts(this.form)" readonly >
							<img onClick="openEDIsts()" class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle">
							</td>
						</tr>
					</table>
					<table class="search_in" border="0">
						<tr class="h23">
							<td width="116"><img class="nostar">My Performance</td>
							<td width="170">
								<script language="javascript">ComComboObject("mycust", 5, 164, 0, 0, 0, false);</script>
							</td>
							<td>
							<table width="100%">
								<tr><td class="btn2_bg">
									<table border="0" cellpadding="0" cellspacing="0">
										<tr>
											<!-- Repeat Pattern -->
											<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr><td class="btn2_left"></td><td onClick="openMyReport()" class="btn2" name="btn_addedit" id="btn_addedit">Add / Edit</td>
											<td class="btn2_right"></td></tr></table></td>
											<!-- Repeat Pattern -->
										</tr></table>
								</td></tr>
							</table>
							</td>
						</tr>
					</table>


        <table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
					<table class="search_in" border="0">
						<tr class="h23">
						<%if(officeId.equals("SELCOS") || officeId.equals("SELCOT") || officeId.equals("SELCON") || officeId.equals("SELCOL") || userId.equals("2007803") || userId.equals("2007819") || userId.equals("2007818") || userId.equals("2000320") || userIdSub.equals("TES") || ofcKndCd == 1){ %>
						    <td width="115"><img class="nostar">Event Date</td>
							<td width="210"><input class="input" type="text" style="width:70 ; text-transform:uppercase;" name="fm_dt1" onKeyUp="chkField(this, 'date', false, null, null, '-')" onBlur="chkField(this, 'date', false, null, null, '-')">&nbsp;~&nbsp;<input class="input" type="text" style="width:70" name="to_dt1" onKeyUp="chkField(this, 'date', false, null, null, '-')" onBlur="chkField(this, 'date', false, null, null, '-')"> <img onClick="openCalendar('3')" class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle"></td>
							<td width="80">T.VVD ETD</td>
							<%} else { %>
							<td width="115"><img class="nostar">T.VVD ETD</td>
							<%} %>
							<td width="220"><input name = "poletddate1" type="text" class="input" style="width:70; text-transform:uppercase;" maxlength="10"  dataformat="ymd" OnBeforeDeactivate="ComAddSeparator(this)" OnBeforeActivate="ComClearSeparator(this)"  >
								&nbsp;~&nbsp;
								<input name = "poletddate2" type="text" class="input" style="width:70; text-transform:uppercase;" maxlength="10"  dataformat="ymd" OnBeforeDeactivate="ComAddSeparator(this)" OnBeforeActivate="ComClearSeparator(this)"  >
								<img onClick="openCalendar('1')" class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle">
							</td>
							<td width="80">T.VVD ETA</td>
							<td><input name ="podetadate1" type"text" class="input" style="width:70; text-transform:uppercase;" maxlength="10"  dataformat="ymd" OnBeforeDeactivate="ComAddSeparator(this)" OnBeforeActivate="ComClearSeparator(this)" >
								&nbsp;~&nbsp;
								<input name = "podetadate2" type="text" class="input" style="width:70; text-transform:uppercase;" maxlength="10"  dataformat="ymd" OnBeforeDeactivate="ComAddSeparator(this)" OnBeforeActivate="ComClearSeparator(this)" >
								<img onClick="openCalendar('2')" class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle">
							</td>
						</tr>
					</table>
					<table class="search_in" border="0">
						<tr class="h23">
							<td width="115"><img class="nostar">Booking NO.</td>
							<td width="210"><input name="bkg_no" Onkeydown="onEnterKey()" type="text" class="input" style="width:120; text-transform:uppercase;"  value="">
							<img onClick="openAddPaste('bkg_no')" class="cursor" src="/hanjin/img/button/btng_plus.gif" width="19" height="20" border="0" align="absmiddle"></td>
							<td width="80">B/L NO.</td>
							<td width="220">
							<input name="bl_no" Onkeydown="onEnterKey()" type="text" class="input" style="width:120; text-transform:uppercase;"  value="">
							<img onClick="openAddPaste('bl_no')" class="cursor" src="/hanjin/img/button/btng_plus.gif" width="19" height="20" border="0" align="absmiddle"></td>
							<td width="80">CNTR NO.</td>
							 <input name ="cntr_no" id ="cntr_no" type = "hidden" value ="">
							<td><input name="cntr_no_nonbit" type="text" style="width:100px ; text-transform:uppercase;" Onkeydown="onEnterKey(this)"   onBlur='javascript:this.value=this.value.toUpperCase();'  onChange="CheckDigitSplit(this,'cntr_no_split', 'cntr_no')"  onKeyUp="CheckDigitSplit(this, 'cntr_no_split', 'cntr_no')"> <input id ="cntr_no_split" name="cntr_no_split" type="text" style="width:22" maxlength="2" readonly>
							<img onClick="openAddPaste('cntr_no')" class="cursor" src="/hanjin/img/button/btng_plus.gif" width="19" height="20" border="0" align="absmiddle"></td>

						</tr>
					</table>
		<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>

					<table class="search_in" border="0">
						<tr class="h23">
							<td width="115"><img class="nostar">Trans Mode</td>
							<td width="180">
							<select name="trs_mode_" class="input" style="width:113;">
								<option value="A">ALL</option>
								<option value="Y">RAIL</option>
								<option value="N">NONRAIL</option>
							</select>
							</td>
							<td width="80">COP Status.</td>
							<td>
							<select name="cop_status" class="input" style="width:100;">
								<option value="A">ALL</option>
								<option value="C">Closed</option>
								<option value="I">In-Transit</option>
							</select>
							</td>


						</tr>
					</table>
					<table class="search_in" border="0">

						<tr class="h23">
							<td width="115"><img class="nostar">VVD</td>
							<td width="180"><input name="vvd" type="text" Onkeydown="onEnterKey()" class="input" style="width:70; text-transform:uppercase;"  value="" >&nbsp;<img onClick="openVVDList()" class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle">
							<img onClick="openAddPaste('vvd')" class="cursor" src="/hanjin/img/button/btng_plus.gif" width="19" height="20" border="0" align="absmiddle"></td>
							<td width="30">POR</td>
							<td width="150"><input name="por"  Onkeydown="onEnterKey()" type="text" class="input" style="width:70; text-transform:uppercase;"  value="">&nbsp;<img onClick="openLocPop(false,'por')" class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
							<td width="30">POL</td>
							<td width="150"><input name="pol" Onkeydown="onEnterKey()" type="text" class="input" style="width:70; text-transform:uppercase;"  value="">&nbsp;<img onClick="openLocPop(false,'pol')" class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
							<td width="30">POD</td>
							<td width="150"><input name="pod" Onkeydown="onEnterKey()" type="text" class="input" style="width:70; text-transform:uppercase;"  value="">&nbsp;<img onClick="openLocPop(false,'pod')" class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
							<td width="30">DEL</td>
							<td><input name="del" Onkeydown="onEnterKey()" type="text" class="input" style="width:70; text-transform:uppercase;"  value="">&nbsp;<img onClick="openLocPop(false,'del')" class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
							</td>
						</tr>
					</table>
            <table class="line_bluedot"><tr><td colspan="6"></td></tr></table>

					<table class="search_in" border="0">
						<tr class="h23">
					<!-- 		<td colspan="2"></td>     -->
							<td>
								<input type = "radio" name = "missOntime" value = "M" class="trans" Checked>Missing Performance
								<input type = "radio" name = "missOntime" value = "O" class="trans">On-Time Performance
							</td>
							<td colspan="7"></td>
						</tr>
					</table>

				</td>
			</tr>
		</table>

		<!-- TABLE '#D' : ( Search Options ) (E) -->

		<table class="height_10"><tr><td></td></tr></table>

		<!-- TABLE '#D' : ( Tab ) (S) -->
       
		<table class="search" border="0">
			<tr>
				<td class="bg">
					<table class="height_10"><tr><td></td></tr></table>


					<!-- : ( grid ) (S) -->
                    <table width="100%" id="mainTable">
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet');</script>
                        </td></tr>
                    </table>

				<!-- : ( grid ) (E) -->
			</td></tr>
		</table>
		 <div id="tabLayer" style="display:none">
		<table class="search" border="0">
            <tr>
                <td class="bg">
                    <table class="height_10"><tr><td></td></tr></table>
                    <!-- : ( grid ) (S) -->
                    <table width="100%" id="hiddenTable">
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet2');</script>
                        </td></tr>
                    </table>

                <!-- : ( grid ) (E) -->
            </td></tr>
        </table>
        <table class="search" border="0">
            <tr>
                <td class="bg">
                    <table class="height_10"><tr><td></td></tr></table>
                    <!-- : ( grid ) (S) -->
                    <table width="100%" id="hiddenTable2">
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet3');</script>
                        </td></tr>
                    </table>

                <!-- : ( grid ) (E) -->
            </td></tr>
        </table>
        <table class="search" border="0">
            <tr>
                <td class="bg">
                    <table class="height_10"><tr><td></td></tr></table>
                    <!-- : ( grid ) (S) -->
                    <table width="100%" id="hiddenTable3">
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet4');</script>
                        </td></tr>
                    </table>

                <!-- : ( grid ) (E) -->
            </td></tr>
        </table>
        </div>
		<!-- TABLE '#D' : ( Tab BG Box ) (E) -->
		<!-- ####### TABLE '#D' ::: 'RIGHT' FRAME (END) ####### -->
		<table class="height_10"><tr><td></td></tr></table>

    </td></tr>
</table>
<!-- Outer Table (E)-->
</body>
</html>
