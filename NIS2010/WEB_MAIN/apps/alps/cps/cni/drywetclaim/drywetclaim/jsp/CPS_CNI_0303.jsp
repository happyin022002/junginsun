<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CPS_CNI_0303.jsp
*@FileTitle : Handling Costs
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.08
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.10.12 윤세영
* 1.0 Creation 
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.cps.cni.drywetclaim.drywetclaim.event.CpsCni0303Event"%>
<%@ page import="com.hanjin.apps.alps.cps.cni.common.CniUtil"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	CpsCni0303Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.DryWetClaim.DryWetClaim");
	String dwClmNo          = JSPUtil.getNull(request.getParameter("dw_clm_no"));
	String popup			= JSPUtil.getNull(request.getParameter("popup"));
	
	SignOnUserAccount account = null;

	try {
	   	account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
		if (dwClmNo.equals("")) {
			dwClmNo   = CniUtil.getDwClaimNo(account);
		}

		event = (CpsCni0303Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		//GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		 
	}catch(Exception e) {
		out.println(e.toString());
	}
	   String popupYn = JSPUtil.getParameter(request , "popupYn" , "N");
	    
	    // claim party no    
	    String clmPtyNo = JSPUtil.getParameter(request , "clm_pty_no" , "");
	    
	    // 사용자 roles
	    String roles = CniUtil.getRoles(account);
	    String area =  CniUtil.getAreaInfo(account);
	    String ofcCd = account.getOfc_cd(); 
	    
	    //roles = "CNI39";
	    //strUsr_id = "2000362";	    
	    
%>
<html>
<head>
<title>Handling Costs</title>
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

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->
<input type="hidden" name="usr_id"				value="<%=strUsr_id			%>" >
<input type="hidden" name="dw_clm_tp_cd">
<input type="hidden" name="dw_clm_sts_cd">
<input type="hidden" name="inci_plc_tp_cd">
<input type="hidden" name="dw_co_cd">
<input type="hidden" name="dw_clm_att_def_tp_cd">
<input type="hidden" name="date_type">

<input type="hidden" name="usr_roles" value="<%=roles%>">
<input type="hidden" name="usr_area" value="<%=area%>">
<input type="hidden" name="usr_office" value="<%=ofcCd%>">
<input type="hidden" name="hdlr_usr_id">

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
	
		<!--Page Title, Historical (S)-->
        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
<%if (popup.equals("yes")) { %>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"> Handling Costs</td></tr>
<% } else { %>
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
<% } %>
        </table>
		<!--Page Title, Historical (E)-->
	
	
		<!--Button (S) -->
		
    	<!--Button (E) -->
		
		<!--biz page (S)-->
		
<table class="search" id="mainTable"> 
			
    <tr><td class="bg">	
			<table class="search" border="0" style="width:979;"> 
			<tr class="h23">
				<td width="61">Case No.</td>
				<td width="120"><input type="text" name="dw_clm_no" style="width:90;" class="input1" maxlength="11" required dataformat="eng" fullfill caption="Case No." style="ime-mode:disabled" value="<%=dwClmNo%>"></td>
				<td width="31" title="Type of Case">TOC</td>
				<td width="140"><input type="text" name="dw_clm_tp_nm" readonly class="input2" style="width:113;" ></td>
				<td width="66">Company</td>
				<td width="140"><input type="text" name="dw_co_nm" readonly class="input2" style="width:113;" ></td>
				<td width="47">Vessel</td>
				<td width="160"><input type="text" name="vsl_eng_nm" style="width:150;" value="" readonly class="input2"></td>
				<td width="25" title="Date of Incident">DOI</td>
				<td width=""><input type="text" name="inci_occr_dt" style="width:90;" value="" readonly class="input2"></td>
				</tr>
				<tr class="h23">
				<td width="">R. Office</td>
				<td width=""><input type="text" name="cre_ofc_cd" style="width:90;" value="" readonly class="input2"></td>
				<td width="">R. Handler</td>
				<td width=""><input type="text" name="r_handler" style="width:113;" value="" readonly class="input2"></td>
				<td width="">Handler</td>
				<td width=""><input type="text" name="hdlr_usr_nm" style="width:113;" value="" readonly class="input2"></td>
				<td width="" title="Time Barred Date">T/B Date</td>
				<td width=""><input type="text" name="tm_bar_dt" style="width:90;" value="" readonly class="input2"></td>
				<td width="" title="Date of Case Closed">DOC</td>
				<td width=""><input type="text" name="cs_clz_dt" style="width:90;" value="" readonly class="input2"></td>
				</tr>
				<tr class="h23">
				<td width="">Status </td>
				<td width=""><input type="text" name="dw_clm_sts_nm" style="width:90;" value="" readonly class="input2"></td>
				<td width="">Updated</td>
				<td width=""><input type="text" name="upd_dt" style="width:113;" value="" readonly class="input2"></td>
				<td width="" title="Type of Handling">TOH</td>
				<td width=""><input type="text" name="dw_clm_att_def_tp_nm" style="width:113;" value="" readonly class="input2"></td>
				<td width="">LP T/B Date</td>
				<td width="" colspan="3"><input type="text" name="labl_pty_tm_bar_dt" style="width:90;"  value="" readonly class="input2"></td>
				</tr>
			</table> 
			
			<table class="line_bluedot"><tr><td></td></tr></table>
			<!-- Grid  (S) -->
			<table width="100%" class="search"  id="mainTable"> 
						<tr>
							<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
							</td>
						</tr>
					</table> 
					
			<!-- Grid (E) -->
		
		<!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0"><tr>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_Row_Add">Row&nbsp;Add</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_Row_Insert">Row Insert</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_Row_Copy">Row Copy</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_Row_Delete">Row&nbsp;Delete</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_DownExcel">Down Excel</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_LoadExcel">Load Excel</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
					</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
	</td>
	</tr></table> 
		
		
	
	</td></tr>
		</table>

<% if ("Y".equals(popupYn)) {%>
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
<% } %>

		<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
       	<tr><% if ("Y".equals(popupYn)) {%><td class="btn3_bg"><% }else{ %><td class="btn1_bg"><%}%>
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn1_Retrieve">Retrieve</td>
					<td class="btn1_right">
				</tr></table></td>
			<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn1_New">New</td>
					<td class="btn1_right">
				</tr></table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
                 <% if ("Y".equals(popupYn)) {%>
                 
				<td class="btn1_line"></td>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn1_close">Close</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
                <% } %>
			</tr>
			</table>
		</td></tr>
		</table>
    <!--Button (E) -->

<% if ("Y".equals(popupYn)) {%>
</tr>
</table>
<% } %>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>