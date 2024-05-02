<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_0505.jsp
*@FileTitle : Refrigerator Parts Credit Status.
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier :
*@LastVersion : 
* 1.0 최초 생성 2016.04.26
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.lea.common.CodeComboUtil"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.util.StringUtil"%>
<%@ page import="com.hanjin.bizcommon.util.BizComUtil"%>

<%@ page import="com.hanjin.apps.alps.esd.eas.creditincentive.creditincentivestatus.event.EsdEas0501Event"%>

<%
	EsdEas0501Event  event = null;				    //PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			    //서버에서 발생한 에러
	String strErrMsg = "";							//에러메세지
	String strUsr_ofc_cd = "";
	String strUsr_rhq_ofc_cd = "";
	int rowCount	 = 0;							//DB ResultSet 리스트의 건수

	String today = DateTime.getFormatString("yyyy");

	SignOnUserAccount account= null;

	try {
		account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_ofc_cd = account.getOfc_cd();
		strUsr_rhq_ofc_cd = account.getRhq_ofc_cd();

		event = (EsdEas0501Event)request.getAttribute("Event");
		
		

		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	}catch(Exception e) {
		out.println(e.toString());
	}
	
	String s_mkr_cd  = JSPUtil.getCodeCombo("s_mkr_cd", "01", "style='width:100' ", "CD03516", 0, "000010::");
%>

<script language="javascript">
	<%=JSPUtil.getIBCodeCombo("mkr_cd", "01", "CD03516", 0, "")%>
	<%=BizComUtil.getIBCodeCombo("curr_cd", "01", "CURR", 1, "")%>
</script>
<html>
<head>
	<title>Refrigerator Parts Credit Status</title>
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
	<input type="hidden" name="f_cmd">
	<input type="hidden" name="usr_ofc_cd"		value="<%=strUsr_ofc_cd%>">
    <input type="hidden" name="usr_rhq_ofc_cd"	value="<%=strUsr_rhq_ofc_cd%>">
    <input type="hidden" name="atch_file_lnk_flg">
    <input type="hidden" name="atch_file_lnk_id">
<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding" >
	<tr>
		<td>
			<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
				<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
				<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
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
											<td class="btn1" id="btn_maker" name="btn_maker">Total Status by Maker</td>
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
			<table class="search" border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td class="bg">
						<table border="0" cellpadding="0" cellspacing="0">
							<tr class="h23">
								<td width="100%">
									<table border="0" cellpadding="0" cellspacing="0">
										<tr class="h23">
											<td width="70">Issue Date</td>
											<td width="235">
												<input type="text" name="s_fm_dt" dataformat="ymd" maxlength="8" size="10" style="width:80; text-align: center;" class="input"	onKeyPress="ComKeyOnlyNumber(this)">
												<img name="btns_calendar_s" src="img/btns_calendar.gif" width="19" height="20" alt=""border="0" align="absmiddle" class="cursor"> ~ 
												<input type="text" name="s_to_dt" dataformat="ymd" maxlength="8" size="10" style="width:80; text-align: center;" class="input" onKeyPress="ComKeyOnlyNumber(this)">
												<img name="btns_calendar_e" src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
											</td>
											<td width="40">Maker</td>
											<td width="110"><%=s_mkr_cd%></td>
											<td width="120">Credit Used Office</td>
											<td width="100">
												<input name="s_cr_usd_ofc_cd" type="text" style="width:80;" class="input" maxlength="6"  dataformat="engup">
											</td>
											
										</tr>
									</table>	
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			<!-- TABLE '#D' : ( Search Options ) (E) -->
			<table class="height_10"><tr><td></td></tr></table>
			<!-- TABLE '#D' : ( Tab ) (S) -->
	        <table class="search" id="mainTable1"> 
	        	<tr>
	          		<td class="bg">			
							<table class="search" border="0" id="gridTable1">
								<tr>
									<td class="bg">
					                    <table width="100%" >
					                        <tr>
					                        	<td>
			 		                            	 <script language="javascript">ComSheetObject('sheet1');</script>
					                        	</td>
					                        </tr>
					                    </table>
									</td>
								</tr>
							</table>
							<table width=100% class="button">
								<tr>
									<td class="btn2_bg">
										<table border="0" cellpadding="0" cellspacing="0">
											<tr>
												<td>
													<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
														<tr>
															<td class="btn2_left"></td>
															<td class="btn2" name="btng_row_add1">Row Add</td>
															<td class="btn2_right"></td>
														</tr>
													</table>
												</td>
												<td>
													<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
														<tr>
															<td class="btn2_left"></td>
															<td class="btn2" name="btng_del_row1">Delete Row</td>
															<td class="btn2_right"></td>
														</tr>
													</table>
												</td>
												<td>
													<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
														<tr>
															<td class="btn2_left"></td>
															<td class="btn2" name="btng_save1">Save</td>
															<td class="btn2_right"></td>
														</tr>
													</table>
												</td>
												<td>
													<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
														<tr>
															<td class="btn2_left"></td>
															<td class="btn2" name="btng_downexcel1">Down Excel</td>
															<td class="btn2_right"></td>
														</tr>
													</table>
												</td>												
											</tr>
										</table>
									</td>
								</tr>
							</table>
							<table class="height_10"><tr><td></td></tr></table>
							<table class="search" border="0" id="gridTable2">
								<tr>
									<td class="bg">
					                    <table width="100%" >
					                        <tr>
					                        	<td>
			 		                            	 <script language="javascript">ComSheetObject('sheet2');</script>
					                        	</td>
					                        </tr>
					                    </table>
									</td>
								</tr>
							</table>
							<table width=100% class="button">
								<tr>
									<td class="btn2_bg">
										<table border="0" cellpadding="0" cellspacing="0">
											<tr>
												<td>
													<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
														<tr>
															<td class="btn2_left"></td>
															<td class="btn2" name="btng_row_add2">Row Add</td>
															<td class="btn2_right"></td>
														</tr>
													</table>
												</td>
												<td>
													<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
														<tr>
															<td class="btn2_left"></td>
															<td class="btn2" name="btng_del_row2">Delete Row</td>
															<td class="btn2_right"></td>
														</tr>
													</table>
												</td>
												<td>
													<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
														<tr>
															<td class="btn2_left"></td>
															<td class="btn2" name="btng_save2">Save</td>
															<td class="btn2_right"></td>
														</tr>
													</table>
												</td>
												<td>
													<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
														<tr>
															<td class="btn2_left"></td>
															<td class="btn2" name="btng_downexcel2">Down Excel</td>
															<td class="btn2_right"></td>
														</tr>
													</table>
												</td>
											</tr>
										</table>
									</td>
								</tr>
							</table>
					   </td>
					</tr>
				</table>
			</td>
		</tr>
</table>
<!-- Outer Table (E)-->

</form>
</body>
</html>
