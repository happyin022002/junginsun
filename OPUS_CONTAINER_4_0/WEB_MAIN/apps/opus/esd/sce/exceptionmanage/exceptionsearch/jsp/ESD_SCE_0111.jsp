<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_SCE_111.jsp
*@FileTitle : Exception Inquiry II
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier :
*@LastVersion :
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.sce.exceptionmanage.exceptionsearch.event.EsdSce0111Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsdSce0111Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Error On Server Side
	String strErrMsg = "";						//Error Message
	int rowCount	 = 0;						//DB ResultSet List Count

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.ExceptionManage.ExceptionSearch");
	int rowSize = 3000 ;

	//selected value in exception combo box 
	String expt_tp_idx = JSPUtil.getNull(request.getParameter("expt_tp_selected_idx"));

	//non-selected in EDI STS Combo box.
	//JS20081113		if (expt_tp_idx.equals("")) expt_tp_idx = "0";

	//EXCEPTION TYPE DETAIL COLUMN VALUE: Default
	String exptQryOPT = "";
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsdSce0111Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// The data obtained from the server side on load.
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Exception Inquiry II</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}

</script>

</head>
<!--  Multi Select at check box.&&& -->

<body onLoad="setupPage();">
<form name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd">
<input type="hidden" name="row_size" value="<%=rowSize%>">
<input type="hidden" name="expt_tp_opt" value = "<%= exptQryOPT %>">
<input type="hidden" name="expt_tp_selected_idx" value = "<%= expt_tp_idx %>">
<input type="hidden" name="coldesc0" value="SEQ,Exception No.,BKG No.,BKG No.,Container No.,B/L No.,COP No.,Exception Type,Exception Type,Exception Type Detail,Exception Type Detail,Exception Status,Exception Reason,Shipper,Consignee,Notify,VVD,POR,POL,POD,DEL,Occurred Date/Time,Occurred Office,Occurred Node,Resolved Date,Delay Time,From,From,From,From,To,To,To,To,Confirm,Confirm ID,Confirm Date,Remark">
<input type="hidden" name="coldesc1" value="SEQ,Exception No.,BKG No,BKG No,Container No.,B/L No.,COP No.,Exception Type,Exception Type,Exception Type Detail,Exception Type Detail,Exception Status,Exception Reason,Shipper,Consignee,Notify,VVD,POR,POL,POD,DEL,Occurred Date/Time,Occurred Office,Occurred Node,Resolved Date,Delay Time,Activity,Estimated Date/Time,Actual Date/Time,Updated Date/Time,Activity,Estimated Date/Time,Actual Date/Time,Updated Date/Time,Confirm,Confirm ID,Confirm Date,Remark">
<input type="hidden" name="iCheckRow" value="1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|">
<input type="hidden" name="chkcnt" value="111">
<input type="hidden" name="row_size" value="<%=rowSize%>">
<input type="hidden" name="totcnt" value="1" >
<input type="hidden" name="expt_rsn_inq_cd">
<input type="hidden" name="expt_rsn_cd">
<input type="hidden" name="expt_type" value="2">
<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>


		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
				<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
				<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
			</table>
		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->

<script language="javascript">

function screenReload(){

form.action = 'ESD_SCE_0111.do';
form.submit();

}
</script>
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
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_downexcel" id="btn_downexcel">Down Excel</td><td class="btn1_right"></td></tr></table></td>
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
						<td width="107">VVD</td>
						<td width="160"><input name="vvd" type="text" style="width:70; text-transform:uppercase;" onBlur="ComChkObjValid(this)">&nbsp;<img onClick="openVVDPopUp(true)" class="cursor" src="/opuscntr/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
						<td width="30">POR</td>
						<!--  POR Multi Check Box &&&-->
						<td width="160"><input name="por_cd" type="text" class="input" style="width:60; text-transform:uppercase;" onKeyUp="ComChkObjValid(this, 'eng_num', true, 1000)">&nbsp;<img onClick="openLocPopUp(true,'por_cd')" class="cursor" src="/opuscntr/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
						<td width="30">POL</td>
						<!--  POL Multi Check Box &&& -->
						<td width="160"><input name="pol_cd" type="text" class="input" style="width:60; text-transform:uppercase;" onKeyUp="ComChkObjValid(this, 'eng_num', true, 1000)">&nbsp;<img onClick="openLocPopUp(true,'pol_cd')" class="cursor" src="/opuscntr/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
						<td width="30">POD</td>
						<!--  POD Multi Check Box &&& -->
						<td width="160"><input name="pod_cd" type="text" class="input" style="width:60; text-transform:uppercase;" onKeyUp="ComChkObjValid(this, 'eng_num', true, 1000)">&nbsp;<img onClick="openLocPopUp(true,'pod_cd')" class="cursor" src="/opuscntr/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
						<td width="30">DEL</td>
						<!--  DEL Multi Check Box &&& -->
						<td width=""><input name="del_cd" type="text" class="input" style="width:60; text-transform:uppercase;" onKeyUp="ComChkObjValid(this, 'eng_num', true, 1000)">&nbsp;<img onClick="openLocPopUp(true,'del_cd')" class="cursor" src="/opuscntr/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>

					</tr>
					</table>

					<table class="search_in" border="0">
						<tr class="h23">
							<td width="107">Booking Date</td>
							<td width="89" ><input name="bkg_fm_dt" type="text" class="input" style="width:70; text-transform:uppercase;" dataformat="ymd" OnBeforeDeactivate="ComAddSeparator(this)" OnBeforeActivate="ComClearSeparator(this)">&nbsp;~&nbsp;</td>
							<td width="75" ><input name="bkg_to_dt" type="text" class="input" style="width:70; text-transform:uppercase;" dataformat="ymd" OnBeforeDeactivate="ComAddSeparator(this)" OnBeforeActivate="ComClearSeparator(this)"></td>
							<td width="135" ><img name="btn_bkg_calendar" class="cursor" src="/opuscntr/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle"></td>

							<td width="80">Booking No.</td>
							<td width="230" ><input name="bkg_no" type="text" style="width:100 ; text-transform:uppercase;" value="" Onkeydown="onEnterKey(this)" >
							<!-- &nbsp;<input name="bkg_no_split" type="text" style="width:22" maxlength="2" Onkeydown="onEnterKey(this)" onKeyUp="ComChkObjValid(this, 'eng_num', true, 2)" onBlur="ComChkObjValid(this, 'eng_num', true, 2)"> -->
							<img onClick="openAddPaste('bkg_no')" class="cursor" src="/opuscntr/img/button/btng_plus.gif" width="19" height="20" border="0" align="absmiddle"></td>

							<td width="110"  >Bill Of Lading No.</td>
							<td width="" ><input name="bl_no" type="text" style="width:100; text-transform:uppercase;" value="" Onkeydown="onEnterKey(this)" >
							<img onClick="openAddPaste('bl_no')" class="cursor" src="/opuscntr/img/button/btng_plus.gif" width="19" height="20" border="0" align="absmiddle"></td>

						</tr>
					</table>






					<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>


					<table class="search_in" border="0">

						<tr class="h23">
							<td width="107">Customer</td>
							<td width=""><!-- <input name="ofc_cd" type="text" style="width:50" value="">&nbsp; --><input name="cust_cnt_seq" type="text" style="width:70; text-transform:uppercase;" value="">
							<img onclick="openCustPop(false,'cust_cnt_seq','cust_nm', '')" class="cursor" src="/opuscntr/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle">
							<input name="cust_nm" type="text" style="width:745;" value="" readonly>&nbsp;</td>
						</tr>
					</table>

					<table class="search_in" border="0">

						<tr class="h23">
							<td width="107">S/C No.</td>
							<td><input id="sc_no" name="sc_no" type="text" style="width:123; text-transform:uppercase;" value="">&nbsp;<img name="btn_scpopup" class="cursor" src="/opuscntr/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
						</tr>
					</table>

					<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>

					<table class="search_in" border="0">
						<tr class="h23">
							<td width="150">Exception Type Detail</td>
							<td width="">
							    <DIV id="ExptDTLTPDiv" >
							      <select style="width:140;" name='i_exptdtl_type' disabled>&nbsp;
							        <option value="" selected>ALL</option>
							      </select>
							    </DIV>
							</td>
							<td width="100" align="right"></td>
							<td width="">

							</td>

						</tr>
					</table>

					<table class="search_in" border="0">
						<tr class="h23">
							<td width="150">Exception Location</td>
							<td width="147"><input id = "occr_loc_cd" name="occr_loc_cd" type="text" style="width:79; text-transform:uppercase;" >
								<img name="btn_occu_loc" class="cursor" src="/opuscntr/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>

							<td width="80">Control Ofc.</td>
							<td width=""><input name="cre_ofc_cd" type="text" style="width:97; text-transform:uppercase;" value="">
							<img name="btn_occr_ofc" class="cursor" src="/opuscntr/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"> <input type="checkbox" name="chk_office" value="Y" class="trans" onClick="javascript:fun_chkOffice();">Incl. Sub OFC.</td>

						</tr>
					</table>
					<table class="search_in" border="0">
						<tr class="h23">
							<td width="107" border="0" >Exception Date</td>
							<td width ="240"><input name="occur_fm_dt" type="text" style="width:70" value="" dataformat="ymd" OnBeforeDeactivate="ComAddSeparator(this)" OnBeforeActivate="ComClearSeparator(this)">&nbsp;~&nbsp;
								<input name="occur_to_dt" type="occur_to_dt" style="width:70" value="" dataformat="ymd" OnBeforeDeactivate="ComAddSeparator(this)" OnBeforeActivate="ComClearSeparator(this)">
								<img name="btn_occur_calendar" class="cursor" src="/opuscntr/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle"></td>
							<!-- Added RCC  &&& -->
							<td width="30">RCC</td>
							<td width="130"><input name="rcc_cd" type="text" class="input" style="width:60; text-transform:uppercase;" onKeyUp="ComChkObjValid(this, 'eng_num', true, 10000)">
							<img onClick="openRccPopUp(true,'rcc')" class="cursor" src="/opuscntr/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
							<!-- Added LCC Popup&&& -->
							<td width="30">LCC</td>
							<td width="130"><input name="lcc_cd" type="text" class="input" style="width:60; text-transform:uppercase;" onKeyUp="ComChkObjValid(this, 'eng_num', true, 10000)">
							<img onClick="openRccPopUp(true,'lcc')" class="cursor" src="/opuscntr/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
							<!-- Added ECC Popup &&& -->
							<td width="30">ECC</td>
							<td width="130"><input name="ecc_cd" type="text" class="input" style="width:60; text-transform:uppercase;" onKeyUp="ComChkObjValid(this, 'eng_num', true, 10000)">
							<img onClick="openRccPopUp(true,'ecc')" class="cursor" src="/opuscntr/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
							<!-- Added SCC Popup &&& -->
							<td width="30">SCC</td>
							<td width=""><input name="scc_cd" type="text" class="input" style="width:60; text-transform:uppercase;" onKeyUp="ComChkObjValid(this, 'eng_num', true, 10000)">
							<img onClick="openRccPopUp(true,'scc')" class="cursor" src="/opuscntr/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>

						</tr>
					</table>

<!--
					<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>

					<table class="search" border="0" style="width:820;">
						<tr class="h23">
							<td width="107">Exception Reason</td>
							<td width="230">
							<input name="expt_rsn_inq" type="text" class="input" style="width:229; background-color=#E7E7E7; " readonly>&nbsp;
							</td>
							<td width="20">
							<img onClick="openexptrsnPopUp('expt_rsn_inq')" class="cursor" src="/opuscntr/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle">&nbsp;
							</td>
							<td width="85" align="right">Confirm&nbsp;</td>
							<td width="50">
							   <select name="expt_cfm"  style='width:49'; >
								    <option value="N">N</option>
								    <option value="Y">Y</option>
								    <option value="">ALL</option>
								</select>
							</td>
							<td width="38">&nbsp;</td>
							<td width="40">Delay</td>
							<td width="158">
							   <select name="Delay_time"  style='width:157'; >
							   	   <option value="999">ALL</option>
								   <option value="10">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;~10D 00H</option>
								   <option value="20">10D 01H ~ 20D 00H</option>
								   <option value="30">20D 01H ~ 30D 00H</option>
								   <option value="40">30D 01H ~ 40D 00H</option>
								   <option value="50">40D 01H ~ 50D 00H</option>
								   <option value="60">50D 01H ~ Over</option>
							   </select>
							</td>
							<td width="92">&nbsp;</td>
						</tr>
					</table>
-->
				</td></tr>
		</table>



		<table class="height_10"><tr><td></td></tr></table>
		<!-- TABLE '#D' : ( Search Options : Speed ) (S) -->
     	<table class="search">
       	<tr><td class="bg">

		<table style="width:100%; class="search">
		 		<tr>
			      <td width="30%">
				  <table width="40%" class="search">
						<tr>
						<!-- <td class="title_h"></td> -->
							<td width="150"></td>
						</tr>
						<tr><td class="height_"></td></tr>
				  </table>
				  <td width="70%" align="left">


			    </td></tr>
		</table>

				<!-- : ( Speed ) (S) -->
				<table width="100%" id="mainTable">
					<tr><td>
					   <script language="javascript">ComSheetObject('sheet1');</script>
					</td></tr>
				</table>
				<!-- : ( Speed ) (E) -->

				<!-- : ( Button : Sub ) (S) -->
					<table width="100%" class="sbutton">
	       				<tr><td class="align">

			    		<table class="sbutton">
			    			<!-- btn_confirm.gif를  btn_ExceptionConfirm.gif로 &&&-->
			    			<tr><!-- <td class="bt"><img class="cursor" src="/opuscntr/img/button/btn_ExceptionConfirm.gif" width="125" height="20" border="0" name="btn_confirm"></td> -->
								</tr>
						</table>

						</td></tr>
					</table>
	    		<!-- : ( Button : Sub ) (E) -->

			</td></tr>

		</table>
		<!-- TABLE '#D' : ( Search Options : Speed ) (E) -->

		<!-- ####### TABLE '#D' ::: 'RIGHT' FRAME (END) ####### -->




    </td></tr>
</table>
<!-- Outer Table (E)-->
</form>
<span id="new_form"></span>
</body>
</html>
<%@include file="/bizcommon/include/common_opus.jsp"%>