<%--
/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ESD_TRS_0291.jsp
*@FileTitle : D/O notification Report
*Open Issues :
*Change history :
*@LastModifyDate : 2016-06-03
*@LastModifier : 
*@LastVersion : 1.0
* 2016-06-03 
* History
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.trs.codemanage.donotificationreport.event.EsdTrs0291Event"%>
<%
	EsdTrs0291Event  event = null;				    //PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			    //서버에서 발생한 에러
	DBRowSet rowSet	  = null;						//DB ResultSet
	String strErrMsg = "";							//에러메세지
	String usrOfcCd="";
	String usrId="";
	String usrNm="";

	SignOnUserAccount account= null;

	try {

	    account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	    usrId = account.getUsr_id();
	    usrOfcCd = account.getOfc_cd();
        usrNm = account.getUsr_nm();
	    event = (EsdTrs0291Event)request.getAttribute("Event");

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
<title>US D/O Notification Sent Report</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">

	function setupPage(){

		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		}  // end if
		loadPage();
	}

</script>
</head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="pgmId" value="ESD_TRS_0291">
<input type="hidden" name="f_cmd">
<input type="hidden" name="usr_ofc_cd" value="<%=usrOfcCd%>">
<input type="hidden" name="usr_id" value="<%=usrId%>">
<input type="hidden" name="usr_nm" value="<%=usrNm%>">
<input type="hidden" name="old_ofc_cd" >
<input type="hidden" name="f_fm_node" >
<input type="hidden" name="f_to_node" >
<input type="hidden" name="f_door" >


	<!-- Outer Table (S)-->
	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
		<tr>
			<td>
				<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
				<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
					<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
					<tr><td class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
				</table>
				<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->
	
	
				<!-- TABLE '#D' : ( Button : Main ) (S) -->
				<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
					<tr>
						<td class="btn1_bg">
							<table border="0" cellpadding="0" cellspacing="0">
								<tr>
									<!-- Repeat Pattern -->
									<td>
										<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr>
												<td class="btn1_left"></td>
												<td class="btn1" id="btn_retrieve" name="btn_retrieve">Retrieve</td>
												<td class="btn1_right"></td>
											</tr>
										</table>
									</td>
									<td>
										<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr>
												<td class="btn1_left"></td>
												<td class="btn1" id="btn_new" name="btn_new">New</td>
												<td class="btn1_right"></td>
											</tr>
										</table>
									</td>
									<!-- Repeat Pattern -->
								</tr>
							</table>
						</td>
					</tr>
				</table>
				<!-- TABLE '#D' : ( Button : Main ) (E) -->
		
				<!-- TABLE '#D' : ( Search Options ) (S) -->
				<table class="search">
					<tr>
						<td class="bg">
							<table class="search_in" border="0">
								<tr class="h23">
									<td width="70px">Sent Date</td>
									<td width="250px">
										<input type="text" style="width:90" name='f_sent_fm_dt' maxlength=10 onFocus="javascript:delHypen(this);" onBlur="javascript:getHypen(this);"> ~
										<input type="text" style="width:90" name='f_sent_to_dt' maxlength=10 onFocus="javascript:delHypen(this);" onBlur="javascript:getHypen(this);">
										<img src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" name="btns_calendar">
									</td>
									<td width="70px">S/O Office</td>
									<td width="240px">
									<table boder="0">
										<tr><td class="sm">
										<input type="text" style="width:100" name='f_ctrl_ofc_cd' onkeyup="upper(this);">
										<img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btns_office">&nbsp;
										<input type="checkbox" name="chk_office" value="" class="trans" onClick="javascript:fun_chkOffice();">&nbsp;Incl. Sub OFC
										</td></tr>
									</table>
									</td>									
									<td width="40px">Latest</td>
									<td align="left"><input type="checkbox" name="f_latest" class="trans"></td>	
								</tr>
							</table>
							<table class="search_in" border="0">
								<tr class="h23">
									<td width="70px">From</td>
									<td width="250px">
										<input type="text" style="width:80" name='search_fm_node' onChange='getComboList(this)' onFocus='fun_Focus(this)' onKeyup='enterCheck(this)' maxlength="5">&nbsp;
										<script language="javascript">ComComboObject('search_fm_yard', 1, 49, 0);</script><img src="" width="4" height="1" border="0"><img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btns_fmnode">
									</td>
									<td width="70px">To</td>
									<td width="240px">
										<input type="text" style="width:80" name='search_to_node' onChange='getComboList(this)' onFocus='fun_Focus(this)' onKeyup='enterCheck(this)' maxlength="5">&nbsp;
										<script language="javascript">ComComboObject('search_to_yard', 1, 50, 0);</script><img src="" width="4" height="1" border="0"><img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btns_tonode">
									</td>									
									<td width="70px">Door</td>
									<td>
										<input type="text" style="width:80" name='search_door' onChange='getComboList(this)' onFocus='fun_Focus(this)' onKeyup='enterCheck(this)' maxlength="5">&nbsp;
										<script language="javascript">ComComboObject('search_door_yard', 1, 50, 0);</script><img src="" width="4" height="1" border="0"><img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btns_dorloc">
									</td>	
								</tr>
							</table>
							<table class="search_in" border="0">
								<tr class="h23">
									<td width="70px">T.VVD</td>
									<td width="180px">
										<input type="text" style="width:80" name='f_trnk_vvd' onkeyup="upper(this); doSearchEnter();">
										<img class="cursor" src="/hanjin/img/button/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle"  onClick="do_OnPopupClick('T.VVD');">
										<img src="" width="4" height="1" border="0"><img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btns_tvvd">										
									</td>
									<td width="70px">BKG No</td>
									<td width="180px">
										<input type="text" style="width:100" name='f_bkg_no' onkeyup="upper(this); doSearchEnter();">
										<img class="cursor" src="/hanjin/img/button/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle"  onClick="do_OnPopupClick('Booking No');">
									</td>									
									<td width="70px">CNTR No</td>
									<td width="180px">
										<input type="text" style="width:90" name='f_cntr_no' onkeyup="upper(this); doSearchEnter();">
										<img class="cursor" src="/hanjin/img/button/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle"  onClick="do_OnPopupClick('Container No');">
									</td>	
									<td width="90px">Contract No</td>
									<td>
										<input type="text" style="width:90" name='f_sc_no'onkeyup="upper(this); doSearchEnter();"><img src="" width="4" height="1" border="0"><img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btns_contract">
										<img class="cursor" src="/hanjin/img/button/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle"  onClick="do_OnPopupClick('Contract No');">
									</td>	
								</tr>
							</table>
						</td>
					</tr>
				</table>
				<!-- TABLE '#D' : ( Search Options ) (E) -->
		
				<table class="height_10"><tr><td></td></tr></table>
		
				<!-- TABLE '#D' : ( Gird BG Box ) (S) -->
				<table class="search" border="0">
					<tr>
						<td class="bg">
							<table width="100%" id="mainTable1">
		                        <tr>
		                        	<td>
		                             	<script language="javascript">ComSheetObject('sheet1');</script>
			                        </td>
			                   </tr>
		                    </table>
		
							<!-- : ( Grid ) (E) -->
							<!-- : ( Button_ Sub ) (S) -->
							<table width="100%" class="button">
						       	<tr>
						       		<td class="btn2_bg">
										<table border="0" cellpadding="0" cellspacing="0">
											<tr>
												<!-- Repeat Pattern -->
												<td>
													<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
														<tr>
															<td class="btn2_left"></td>
															<td class="btn2"  id="btng_exceldown" name="btng_exceldown">Down Excel</td>
															<td class="btn2_right"></td>
														</tr>
													</table>
												</td>
												<!-- Repeat Pattern -->
											</tr>
										</table>
									</td>
								</tr>
							</table>
							<!-- : ( Button_ Sub ) (E) -->
						</td>
					</tr>
				</table>
				<!-- TABLE '#D' : ( Grid BG Box ) (E) -->
			</td>
		</tr>
	</table>
	<!-- Outer Table (E)-->
<div id="hidden_sheet" style="display:none">
<!--etc_hidden-->
<script language="javascript">ComSheetObject('hidden');</script>
</div>
</form>
</body>
</html>