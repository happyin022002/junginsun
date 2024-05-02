<%
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_SCE_0035.jsp
*@FileTitle : EDI Search
*Open Issues :
*Change history :
*   - 2006-10-12 : UI 변경으로 인한 수정
*   - 2009-09-14 : 프로그램 포팅으로 인한 수정
*   - 2012.04.12 채창호 CHM-201217464-01:SCEM(Customer EDI) upgrade project 관련 화면 수정 요청(1)
*@LastModifyDate : 2009-09-14
*@LastModifier : Jun Byoung Suk
*@LastVersion : 2.1
* 2006-08-29 yong cheon shin
* 1.0 최초 생성
* 2009-09-14 Jun Byoung Suk
* 2.1 버전 생성 
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.event.EsdSce0035Event"%>
<%//@ page import="com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.event.EsdSce0035EventResponse"%>
<%@ page import="com.hanjin.framework.core.layer.event.EventResponse"%>
<%@ page import="com.hanjin.apps.alps.esd.sce.common.util.basic.CodeUtilBC" %>
<%@ page import="com.hanjin.apps.alps.esd.sce.common.util.basic.CodeUtilBCImpl" %>

<%
			CodeUtilBC codeUtil = new CodeUtilBCImpl() ;
            EsdSce0035Event  event = null;                		//PDTO(Data Transfer Object including Parameters)
            //EsdSce0035EventResponse eventResponse = null;    	//RDTO(Data Transfer Object including DB ResultSet)
            EventResponse eventResponse = null;
			Exception serverException   = null;            			//서버에서 발생한 에러

			String strErrMsg = "";                                  //에러메세지
	    	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	    	String userId=account.getUsr_id();
            String officeId = account.getOfc_cd();
            String userIdSub = userId.substring(0,3);
			DBRowSet rowSet      = null;                            //DB ResultSet

			int rowCount     = 0;                                   //DB ResultSet 리스트의 건수

    try {

//		userAuth=account.getAuth();

		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }else{
            event = (EsdSce0035Event)request.getAttribute("Event");
            //eventResponse = (EsdSce0035EventResponse)request.getAttribute("EventResponse");
            eventResponse = (EventResponse)request.getAttribute("EventResponse");
            if (eventResponse != null) {
                //rowSet = eventResponse.getRowSet();
                rowSet = eventResponse.getRs();
                if(rowSet != null){
                     rowCount = rowSet.getRowCount();
                } // end if
            } // end if
        } // end else
    }catch(Exception e) {
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
    }

</script>
</head>

<body onLoad="setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd">
<input type='hidden' name='dist1' value=''>
<input type='hidden' name='dist2' value=''>
<input type='hidden' name='tabno' value=''>

<input type='hidden' name='cop_no' value=''>
<input type='hidden' name='bkg_no' value=''>
<input type='hidden' name='bkg_no_split' value=''>
<input type='hidden' name='cntr_no' value=''>
<input type='hidden' name='pgmNo' value=''>
<input type='hidden' name='search'>

<!--  
/*=========================================================
Hidden Parameters Added By Jun Byoung Suk
=========================================================*/
-->
<input type='hidden' name="podetadate1_hidden">
<input type='hidden' name="podetadate2_hidden">
<input type='hidden' name="poletddate1_hidden">
<input type='hidden' name="poletddate2_hidden">
<input type='hidden' name="podetaDate1">
<input type='hidden' name="podetaDate2">
<input type='hidden' name="fm_dt">
<input type='hidden' name="to_dt">
<input type='hidden' name="tab1_position" value='1'>
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
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_cop" id="btn_cop">COP</td><td class="btn1_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_save" id="btn_save">Save</td><td class="btn1_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btng_send" id="btng_send">Send</td><td class="btn1_right"></td></tr></table></td>
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
							<td width="95"><img class="nostar">Customer</td>
							<td width="" colspan="10">
							<input class="input1" name="cs_grp_id" type="text"  class="input" style="width:80; text-transform:uppercase;" value="" onfocusin="javascrpt:onbuttondisable()"  onblur="javascript:onObjectFocusout1(this.form)">
							<input class="input1" name="tp_id" type="text"  class="input" style="width:80; text-transform:uppercase;" value="" onfocusout="javascript:onObjectTpId(this.form)">
							<input class="input1" name="grp_nm" type="text"  class="input" style="width:671; text-transform:uppercase;" value="" >
							<img onClick="openCustomer()" class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle">
							</td>
						</tr>
					</table>
					<table class="search_in" border="0">
						<tr class="h23">
							<td width="95"><img class="nostar">My Customer</td>
							<td width="">
								<%=codeUtil.searchCodeCombo("mycust"," ( select edi_grp_cd a, cust_trd_prnr_id b, edi_grp_desc c from edi_usr_cust where cre_usr_id = '"+userId+"' and edi_sts_seq = '1')   "
							        ," a||'%'||b||'%'||c  "
							        ," a ||' | '||b||' | '|| c temp ","a"," onChange=javascript:onValueChange('mycust',this.form) style=\"width:839;\"","1:: ")%>
							</td>
						</tr>
					</table>
					<table class="search_in" border="0">
						<tr class="h23">
							<td width="95"><img class="nostar">Booking NO.</td>
							<td width="323"><input name="bkg_no_" Onkeydown="onEnterKey()" type="text" class="input" style="width:102; text-transform:uppercase;"  value="">
							<img onClick="openAddPaste('bkg_no_')" class="cursor" src="/hanjin/img/button/btng_plus.gif" width="19" height="20" border="0" align="absmiddle"></td>

							<td width="55">B/L NO.</td>
							<td width="260">
							<input name="bl_no_" Onkeydown="onEnterKey()" type="text" class="input" style="width:102; text-transform:uppercase;"  value="">
							<img onClick="openAddPaste('bl_no_')" class="cursor" src="/hanjin/img/button/btng_plus.gif" width="19" height="20" border="0" align="absmiddle"></td>

							<td  width="80">CNTR NO.</td>
						  	<input name ="cntr_no_" id ="cntr_no_" type = "hidden" value ="">
							<td><input name="cntr_no_nonbit" type="text" style="width:100px ; text-transform:uppercase;" Onkeydown="onEnterKey(this)"   onBlur='javascript:this.value=this.value.toUpperCase();'  onChange="CheckDigitSplit(this,'cntr_no_split', 'cntr_no_')"  onKeyUp="CheckDigitSplit(this, 'cntr_no_split', 'cntr_no_')"> <input id ="cntr_no_split" name="cntr_no_split" type="text" style="width:22" maxlength="2" readonly>
							<img onClick="openAddPaste('cntr_no_')" class="cursor" src="/hanjin/img/button/btng_plus.gif" width="19" height="20" border="0" align="absmiddle"></td>
						<!--   	<td><input name="cntr_no_" Onkeydown="onEnterKey()" type="text" class="input" style="width:102; text-transform:uppercase;"  value=""> <input id ="cntr_no_split" type="text" style="width:22" maxlength="2" readonly>
							<img onClick="openAddPaste('cntr_no_')" class="cursor" src="/hanjin/img/button/btng_plus.gif" width="19" height="20" border="0" align="absmiddle"></td> -->

						</tr>
					</table>
					<table class="search_in" border="0">
						<tr class="h23">
							<td width="95"><img class="nostar">TRANS Mode.</td>
							<td width="150">
							<select name="trs_mode_" class="input" style="width:102;">
								<option value="A">ALL</option>
								<option value="Y">RAIL</option>
								<option value="N">NONRAIL</option>
							</select>
							</td>

							<td width="55">EDI STS</td>
							<td width="150"><input name="edi_sts" Onkeydown="onEnterKey()" type="text" class="input" style="width:102; text-transform:uppercase;"  value="">
								<img onClick="openEdiStsList()" class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle">
							</td>
							<td width="80">COP Status.</td>
							<td>
							<select name="cop_status" class="input" style="width:102;">
								<option value="A">ALL</option>
								<option value="C">Closed</option>
								<option value="I">In-Transit</option>
							</select>
							</td>
							<td width="100">Missing Type</td>
							<td>
							<script language="javascript">ComComboObject("missing_type", 2, 150, 0, 0, 0, false); </script>
							<!-- 
							<select name="cop_status" class="input" style="width:102;">
								<option value="A">ALL</option>
								<option value="C">Closed</option>
								<option value="I">In-Transit</option>
							</select>
							-->
							</td>
						</tr>
					</table>
					<table class="search_in" border="0">
						<tr class="h23">
							<td width="95"><img class="nostar">VVD</td>
							<td width="200"><input name="vvd" type="text" Onkeydown="onEnterKey()" class="input" style="width:70; text-transform:uppercase;"  value="" > <img onClick="openVVDList()" class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle">
							<img onClick="openAddPaste('vvd')" class="cursor" src="/hanjin/img/button/btng_plus.gif" width="19" height="20" border="0" align="absmiddle"></td>
							<td width="30">POR</td>
							<td width="150"><input name="por" Onkeydown="onEnterKey()" type="text" class="input" style="width:70; text-transform:uppercase;"  value=""> <img onClick="openLocPop(false,'por')" class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
							<td width="30">POL</td>
							<td width="150"><input name="pol" Onkeydown="onEnterKey()" type="text" class="input" style="width:70; text-transform:uppercase;"  value=""> <img onClick="openLocPop(false,'pol')" class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
							<td width="30">POD</td>
							<td width="149"><input name="pod" Onkeydown="onEnterKey()" type="text" class="input" style="width:70; text-transform:uppercase;"  value=""> <img onClick="openLocPop(false,'pod')" class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
							<td width="30">DEL</td>
							<td><input name="del" Onkeydown="onEnterKey()" type="text" class="input" style="width:70; text-transform:uppercase;"  value=""> <img onClick="openLocPop(false,'del')" class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle">
							</td>
						</tr>
					</table>
					<table class="search_in" border="0">
						<tr class="h23">
						<%if(officeId.equals("SELCOS") || userId.equals("2007803") || userId.equals("2007819") || userId.equals("2007818") || userId.equals("2000320") || userIdSub.equals("TES") ) { %>
						    <td width="95"><img class="nostar">Event Date</td>
							<td width="200"><input class="input" type="text" style="width:70 ; text-transform:uppercase;" name="fm_dt1" onKeyUp="chkField(this, 'date', false, null, null, '-')" onBlur="chkField(this, 'date', false, null, null, '-')">&nbsp;~&nbsp;<input class="input" type="text" style="width:70" name="to_dt1" onKeyUp="chkField(this, 'date', false, null, null, '-')" onBlur="chkField(this, 'date', false, null, null, '-')"> <img onClick="openCalendar('3')" class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle"></td>
						<%} %>
						<td width="10"><img class="nostar"></td>
							<td width="50">
							<select name="etd_eta" class="input" style="width:102;">
								<option value="F_ETD">First POL ETD</option>
								<option value="ETD">T.VVD ETD</option>
								<option value="ETA">T.VVD ETA</option>
							</select>
							</td>
							<td width="750"><input name ="poletdDate1" type="text" class="input" style="width:70; text-transform:uppercase;" onKeyUp="chkField(this, 'date', false, null, null, '-')" onBlur="chkField(this, 'date', false, null, null, '-')">
								&nbsp;~&nbsp;
								<input name = "poletdDate2" type="text" class="input" style="width:70; text-transform:uppercase;" onKeyUp="chkField(this, 'date', false, null, null, '-')" onBlur="chkField(this, 'date', false, null, null, '-')">
								<img onClick="openCalendar('1')" class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle">
							</td>
<!--							
							<td width="95"><img class="nostar">T.VVD ETD</td>
							<td width="210"><input name ="poletdDate1" type="text" class="input" style="width:70; text-transform:uppercase;" onKeyUp="chkField(this, 'date', false, null, null, '-')" onBlur="chkField(this, 'date', false, null, null, '-')">
								&nbsp;~&nbsp;
								<input name = "poletdDate2" type="text" class="input" style="width:70; text-transform:uppercase;" onKeyUp="chkField(this, 'date', false, null, null, '-')" onBlur="chkField(this, 'date', false, null, null, '-')">
								<img onClick="openCalendar('1')" class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle">
							</td>
							<td width="70">T.VVD ETA</td>
							<td><input name = "podetaDate1" type="text" class="input" style="width:70; text-transform:uppercase;" onKeyUp="chkField(this, 'date', false, null, null, '-')" onBlur="chkField(this, 'date', false, null, null, '-')">
								&nbsp;~&nbsp;
								<input name = "podetaDate2" type="text" class="input" style="width:70; text-transform:uppercase;" onKeyUp="chkField(this, 'date', false, null, null, '-')" onBlur="chkField(this, 'date', false, null, null, '-')">
								<img onClick="openCalendar('2')" class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle">
							</td>
-->							
						</tr>
					</table>
<!-- 						<tr class="h23">
							<td width = "12%"><img class="nostar">Booking Date</td>
							<td colspan=10>
								<input name = "bookingDate1" type="text" class="input" style="width:70; text-transform:uppercase;" onKeyUp="chkField(this, 'date', false, null, null, '-')" onBlur="chkField(this, 'date', false, null, null, '-')">
								&nbsp;~&nbsp;
								<input name = "bookingDate2" type="text" class="input" style="width:70; text-transform:uppercase;" onKeyUp="chkField(this, 'date', false, null, null, '-')" onBlur="chkField(this, 'date', false, null, null, '-')">
								&nbsp;<img onClick="openCalendar('1')" class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle">

								&nbsp;&nbsp;&nbsp;POL ETD
								&nbsp;<input name ="poletdDate1" type"text" class="input" style="width:70; text-transform:uppercase;" onKeyUp="chkField(this, 'date', false, null, null, '-')" onBlur="chkField(this, 'date', false, null, null, '-')">
								&nbsp;~&nbsp;
								<input name = "poletdDate2" type="text" class="input" style="width:70; text-transform:uppercase;" onKeyUp="chkField(this, 'date', false, null, null, '-')" onBlur="chkField(this, 'date', false, null, null, '-')">
								&nbsp;<img onClick="openCalendar('2')" class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle"></td>
						</tr>
						<tr class="h23">
							<td width = "12%"><img class="nostar">POD ETA</td>
							<td colspan=10>
								<input name = "podetaDate1" type="text" class="input" style="width:70; text-transform:uppercase;" onKeyUp="chkField(this, 'date', false, null, null, '-')" onBlur="chkField(this, 'date', false, null, null, '-')">
								&nbsp;~&nbsp;
								<input name = "podetaDate2" type="text" class="input" style="width:70; text-transform:uppercase;" onKeyUp="chkField(this, 'date', false, null, null, '-')" onBlur="chkField(this, 'date', false, null, null, '-')">
								&nbsp;<img onClick="openCalendar('3')" class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle">

								&nbsp;&nbsp;&nbsp;DEL ETD
								&nbsp;&nbsp;<input name ="deletdDate1" type"text" class="input" style="width:70; text-transform:uppercase;" onKeyUp="chkField(this, 'date', false, null, null, '-')" onBlur="chkField(this, 'date', false, null, null, '-')">
								&nbsp;~&nbsp;
								<input name = "deletdDate2" type="text" class="input" style="width:70; text-transform:uppercase;" onKeyUp="chkField(this, 'date', false, null, null, '-')" onBlur="chkField(this, 'date', false, null, null, '-')">
								&nbsp;<img onClick="openCalendar('4')" class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle"></td>
						</tr>
 -->

					</table>

				</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->


		<table class="height_10"><tr><td></td></tr></table>

		<!-- TABLE '#D' : ( Tab ) (S) -->
     	<table class="tab">
       	<tr><td><script language="javascript">ComTabObject('tab1' )</script>
		</table>
		<!-- TABLE '#D' : ( Tab ) (E) -->

		<div id="tabLayer" style="display:inline">
		<!-- TABLE '#D' : ( Tab BG Box ) (S) -->
     	<table class="search" border="0">
			<tr>
				<td class="bg">
					<table class="height_10"><tr><td></td></tr></table>

                    <table width="100%" id="mainTable">

                        <tr><td>
                             <script language="javascript">ComSheetObject('t0sheet');</script>
                        </td></tr>
                    </table>
				<!-- : ( Speed ) (E) -->

			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Tab BG Box ) (E) -->
        </div>

        <div id="tabLayer" style="display:inline">
		<!-- TABLE '#D' : ( Tab BG Box ) (S) -->
     	<table class="search" border="0">
			<tr>
				<td class="bg">
					<table class="height_10"><tr><td></td></tr></table>

                    <table width="100%" id="mainTable">
                    	<tr>
                    		<td align="right">
                    			<input name="ckCount" type="text" class="noinput1" style="width:30;" readonly > rows selected
                    		</td>
                    	</tr>
                        <tr><td>
                             <script language="javascript">ComSheetObject('t1sheet');</script>
                        </td></tr>
                    </table>
				<!-- : ( Speed ) (E) -->

			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Tab BG Box ) (E) -->
        </div>

<!-- 
 <div id="tabLayer" style="display:none">
     	<table class="search" border="0">
			<tr>
				<td class="bg">
					<table class="height_10"><tr><td></td></tr></table>

                    <table width="100%" id="mainTable">
                        <tr><td>
                             <script language="javascript">ComSheetObject('t2sheet');</script>
                        </td></tr>
                    </table>

			</td></tr>
		</table>


        </div>

 -->
       
<table class="height_10"><tr><td></td></tr></table>

    </td></tr>
</table>
<!-- Outer Table (E)-->

</body>

</html>

