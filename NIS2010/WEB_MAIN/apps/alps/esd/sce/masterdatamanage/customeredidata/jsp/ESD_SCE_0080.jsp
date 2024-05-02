<%
/*=========================================================
*Copyright(c) 2008 CyberLogitec
*@FileName : ESD_SCE_0080.jsp
*@FileTitle : Vessel Estimation Accunt
*Open Issues :
*@LastVersion : 1.0
* 2008-04-07 kim sang hyun
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
<%@ page import="com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.event.EsdSce0080Event"%>
<%@ page import="com.hanjin.apps.alps.esd.sce.common.util.basic.CodeUtilBC" %>
<%@ page import="com.hanjin.apps.alps.esd.sce.common.util.basic.CodeUtilBCImpl" %>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%
		CodeUtilBC codeUtil = new CodeUtilBCImpl() ;


		EsdSce0080Event  event = null;					//PDTO(Data Transfer Object including Parameters)
		Exception serverException   = null;			//서버에서 발생한 에러
		String strErrMsg = "";						//에러메세지
		int rowCount	 = 0;						//DB ResultSet 리스트의 건수
		
		String successFlag = "";
		String codeList  = "";
		String pageRows  = "100";
		
		String strUsr_id		= "";
		String strUsr_nm		= "";
		Logger log = Logger.getLogger("com.hanjin.apps.alps.esd.sce.copreport");
		int rowSize = 3000 ;
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
    	String userId=account.getUsr_id();
		
		try {

		
			event = (EsdSce0080Event)request.getAttribute("Event");
			serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		
			if (serverException != null) {
				strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
			}
		
			// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
			GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
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
        var formObject = document.form ;
	}
</script>

</head>

<body onLoad="setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd">
<input type="hidden" name="edi_sts">

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
					<table class="search" border="0">
						<tr class="h23">
							<td width="100"><img class="nostar">Customer</td>
							<td width="">
							<input class="input1" name="cs_grp_id" type="text"  class="input" style="width:80; text-transform:uppercase;" value="" onfocusout="javascript:onObjectFocusout(this.form)">
							<input class="input1" name="tp_id" type="text"  class="input" style="width:80; text-transform:uppercase;" value="" onfocusout="javascript:onObjectTpId(this.form)">
							<input class="input1" name="grp_nm" type="text"  class="input" style="width:650; text-transform:uppercase;" value="" >
							<img onClick="openCustomer()" class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle">
							</td>
						</tr>
					</table>
					<table class="search" border="0">
						<tr class="h23">
							<td width="100"><img class="nostar">My Customer</td> 
							<td width="">
								<%=codeUtil.searchCodeCombo("mycust"," ( select edi_grp_cd a, cust_trd_prnr_id b, edi_grp_desc c from edi_usr_cust where cre_usr_id = '"+userId+"' and edi_sts_seq = '1')   "
							        ," a||'%'||b||'%'||c  "
							        ," a ||' | '||b||' | '|| c temp ","a"," onChange=javascript:onValueChange('mycust',this.form) style=\"width:839;\"","1:: ")%>
							</td>
						</tr>
					</table>
					<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
					<table class="search" border="0">
						<tr class="h23">
							<td width="100"><img class="nostar">Event Select</td>

<!-- 							<td>&nbsp;
								<select name="eve_Sel" class="input" style="width:70;">
 									<option value="" selected>&lt;&lt; select &gt;&gt;</option>    -
										<option value="" selected></option>
								</select>
							</td>
-->
							<td width="235"><select name="eve_sel" class="input" style="width:70;">
										<option value="VDL">VDL</option>
										<option value="VDT">VDT</option>
										<option value="VAT">VAT</option>
										<option value="VAD">VAD</option>
									</select>
								</td>

 							<td width="70">Event Port</td>
							<td>
								<input name="eve_loc" Onkeydown="onEnterKey()" type="text" class="input" style="width:70; text-transform:uppercase;"  value="">
								<img onClick="openLocPop(false,'eve_loc')" class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle">
							</td>
							<TD></TD>
						</tr>
					</table>
					<table class="search" border="0">
						<tr class="h23">
							<td width = "100"><img class="nostar">VVD</td>
							<td width="235"><input name="vvd" type="text" Onkeydown="onEnterKey()" class="input" style="width:70; text-transform:uppercase;"  value="" >&nbsp;<img onClick="openVVDList()" class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle">
								<img onClick="openAddPaste('vvd')" class="cursor" src="/hanjin/img/button/btng_plus.gif" width="19" height="20" border="0" align="absmiddle">
							</td>
							<td width = "70">T.VVD ETD</td>
							<td width="280">
								<input name="fmd_dt" type="text" class="input" style="width:70; text-transform:uppercase;" onKeyUp="chkField(this, 'date', false, null, null, '-')" onBlur="chkField(this, 'date', false, null, null, '-')" >
								&nbsp;~&nbsp;<input name = "tod_dt" type="text" class="input" style="width:70; text-transform:uppercase;" onKeyUp="chkField(this, 'date', false, null, null, '-')" onBlur="chkField(this, 'date', false, null, null, '-')" >
								<img name="btn_etd_calendar" class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle">
							</td>
							<td width = "70">T.VVD ETA</td>
							<td>
								<input name="fma_dt" type="text" class="input" style="width:70; text-transform:uppercase;" onKeyUp="chkField(this, 'date', false, null, null, '-')" onBlur="chkField(this, 'date', false, null, null, '-')" >
								&nbsp;~&nbsp;<input name = "toa_dt" type="text" class="input" style="width:70; text-transform:uppercase;" onKeyUp="chkField(this, 'date', false, null, null, '-')" onBlur="chkField(this, 'date', false, null, null, '-')" >
								<img name="btn_eta_calendar" class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle">
							</td>
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
                             <script language="javascript">ComSheetObject('sheet');</script>
                        </td></tr>
                    </table>

				<!-- : ( grid ) (E) -->
			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Tab BG Box ) (E) -->
		<!-- ####### TABLE '#D' ::: 'RIGHT' FRAME (END) ####### -->
		<table class="height_10"><tr><td></td></tr></table>

    </td></tr>
</table>
<!-- Outer Table (E)-->
</form>
</body>
</html>

