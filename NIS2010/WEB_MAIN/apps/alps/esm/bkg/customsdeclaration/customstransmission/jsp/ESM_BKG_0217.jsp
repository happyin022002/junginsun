<%/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : esm_bkg_0217.jsp
 *@FileTitle : B/L Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2011.06.03
 *@LastModifier : 민정호
 *@LastVersion : 1.1
 * 2009.08.25 이수빈
 * 1.0 Creation
 *
 * 1.1 2011.06.03 민정호 [CHM-201111214] B/L Inquiry On Board Date 추가
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.util.io.HttpUtil"%> 
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.china.event.EsmBkg0217Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0217Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList    = "";
	String pageRows    = "100";

	String strUsr_id   = "";
	String strUsr_nm   = "";
	String strCnt_cd   = "";
    String strOfc_cd   = "";
	
	String strPgmNo     = "";
	String strBlNo      = "";
	String strTransMode = "";       
	Logger log = Logger.getLogger("com.hanjin.apps.CustomsDeclaration.Customstransmission");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strCnt_cd = account.getCnt_cd();
        strOfc_cd = account.getOfc_cd();

		event = (EsmBkg0217Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        strBlNo = JSPUtil.getNull(request.getParameter("bl_no"));
        strPgmNo = JSPUtil.getNull(request.getParameter("pgmNo"));
        strTransMode = event.getTransMode();
        strTransMode = strTransMode == null ? JSPUtil.getNull(request.getParameter("trans_mode")) : strTransMode;
        codeList = HttpUtil.makeXML(request,response);

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>B/L Inquiry</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<body  onLoad="setupPage();">
<form name="form" method="post">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="trans_mode" value="<%=strTransMode%>">
<input type="hidden" name="bl_mk_desc">
<input type="hidden" name="vvd">
<input type="hidden" name="loc_cd">
<input type="hidden" name="bkg_pol_cd">
<input type="hidden" name="bkg_pod_cd">
<input type="hidden" name="chn_mf_snd_ind_cd">
<input type="hidden" name="code_list" value="<%=codeList%>">
<input type="hidden" name="sav_flg" id="sav_flg">
<input type="hidden" name="str_pgm_no" value="<%=strPgmNo %>">

<!-- 개발자 작업	-->

<%@include file="/apps/alps/esm/bkg/bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_TOP.jsp" %> 

			<!--biz page (S)-->

			<table class="search">
       		<tr><td class="bg">

				<table class="search" border="0" style="width:880;">
				<tr class="h23">
					<td width="55">B/L No.</td>
					<td width="150"><input type="text" name="bl_no" style="width:110; ime-mode: disabled;" class="<%="".equals(strBlNo) ? "input1" : "input2"%>" value="<%=strBlNo%>"
                                        dataformat="eng" maxlength="12" <%="".equals(strBlNo) ? "required" : "readonly"%> caption="B/L No."></td>
                    <td width="55">BKG No.</td>
					<td width="150"><input type="text" name="bkg_no" style="width:110;" class="input2" <%=!"".equals(strBlNo) ? "readonly" : ""%>
					                   dataformat="eng" maxlength="13" fullfill caption="BKG No."></td>
					<td width="75">MSG STS</td>
					<td width=""><input type="text" name="trsm_msg_tp_id" style="width:100;" class="input2" readonly>
					             <input type="text" name="mf_snd_dt" style="width:150;" class="input2" readonly></td>
					
				</tr>
				</table>
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
				<table class="search" border="0" style="width:980;">
				<tr class="h23">
					<td width="55">POR</td>
					<td width="150"><input type="text" name="por_cd" style="width:60;" class="input" maxlength="5"></td>
					<td width="75">VVD</td>
					<td width="200"><input type="text" name="vsl_nm" style="width:180;" class="input2" readonly></td>
					<td width="105">On Board Date</td>
					<td width="120"><input type="text" name="bl_obrd_dt" style="width:80;" class="input2" readonly></td>
					<td width="95">B/L Issue Date</td>
					<td width=""><input type="text" name="bl_iss_dt" style="width:80;" class="input"></td>
				</tr>
				</table>
				<table class="search" border="0" style="width:980;">
				<tr class="h23">
					<td width="55">POL</td>
					<td width="150"><input type="text" name="pol_cd" style="width:60;" class="input" maxlength="5"></td>
					<td width="75">Trans Port</td>
					<td width="200"><input type="text" name="port_cd" style="width:60;" class="input2" readonly></td>
					<td width="105">R/D Term</td>
					<td width="120"><input type="text" name="rcv_term_cd" style="width:25;" class="input2" readonly> /
					                <input type="text" name="de_term_cd" style="width:25;" class="input2" readonly></td>
					<td width="97">Trans IND</td>
					<td width="">
					   <script language="javascript">ComComboObject('trsp_mod_id', 1, 158, 1, 0);</script>
                       <script language="javascript">ComComboObject('seal_pty_tp_cd', 1, 0, 1, 0);</script>
					</td>
				</tr>
				</table>
				<table class="search" border="0" style="width:980;">
				<tr class="h23">
					<td width="55">V.POD</td>
					<td width="150"><input type="text" name="vvd_pod_cd" style="width:60;" class="input2" maxlength="5" readonly></td>
					<td width="75">Freight</td>
					<td width="200"><input type="text" name="frt_term_cd" style="width:30;" class="input2" readonly></td>
					<td width="55">Temp.</td>
					<td width=""><input type="text" name="temp" style="width:86;text-align:right;" class="input" dataformat="float" maxlength="9">
					               <input type="text" name="temp_unit" style="width:25;" class="input2" readonly></td>	
					<td width="80"></td>
					<td width="150" style="display:none;"><input type="text" name="bkg_cgo_tp_cd" style="width:60;" class="input2" maxlength="5" readonly></td>
				</tr>
				</table>
				<table class="search" border="0" style="width:980;">
				<tr class="h23">
					<td width="55">POD</td>
					<td width="150"><input type="text" name="pod_cd" style="width:60;" class="input" maxlength="5"></td>
					<td width="75">Package</td>
					<td width="169"><input type="text" name="pck_qty" style="width:105; text-align:right;" class="input" 
                                       dataformat="float" maxlength="15" caption="Package">
					                <input type="text" name="pck_tp_cd" style="width:35;" class="input2" readonly></td>
					<td width="56">Weight</td>
					<td width="235"><input type="text" name="act_wgt" style="width:155; text-align:right;" class="input" 
					                   dataformat="float" maxlength="23" caption="Weight">&nbsp;
                       <script language="javascript">ComComboObject('wgt_ut_cd', 1, 55, 1, 0);</script></td>
					<td width="60">Measure</td>
					<td width=""><input type="text" name="meas_qty" style="width:100; text-align:right;" class="input" 
                                       dataformat="float" maxlength="15" caption="Measure">&nbsp;
					   <script language="javascript">ComComboObject('meas_ut_cd', 1, 55, 1, 0);</script></td>	
				</tr>
				</table>
				
				
				<table class="search" border="0" style="width:980;">
				<tr class="h23">
					<td width="55">DEL</td>
					<td width="150"><input type="text" name="del_cd" style="width:60;" class="input" maxlength="5"></td>
					<td width="75">Cargo Desc.</td>
					<td width=""><input type="text" name="cstms_desc" style="width:380;" class="input"></td>	
				</tr>
				</table>
			</td></tr>
		</table>
		<table class="height_8"><tr><td></td></tr></table>

		<!-- Tab (S) -->
   		<table class="tab" border="0" cellpadding="0" cellspacing="0" width="100%">
     		<tr><td width="100%">
			<script language="javascript">ComTabObject('tab1')</script>
		</td></tr>
		</table>
		<!-- Tab (E) -->

	<!-- (TAB) Container Info (S) -->
	<div id="tabLayer" style="display:inline">

		<table class="search">
       	<tr><td class="bg">

			<!-- Grid  (S) -->
			<table width="100%"  id="mainTable">
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('t1sheet1');</script>
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
						<td class="btn2" name="btn_RowAdd">Row&nbsp;Add</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_RowDel">Row&nbsp;Delete</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
					</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->

		</td></tr>
		</table>

	</div>
	<!-- (TAB) Container Info (E) -->


	<!-- (TAB) Customer Info(S) -->
	<div id="tabLayer" style="display:none">
		<div style="overflow:auto; height:303px;">
		<table class="search"">
       	<tr><td class="bg" height="298" valign="top">
			
			<table width="100%" class="grid2">
			<tr>
				<td class="tr2_head" width="18%">Shipper Name</td>
				<td><input type="text" name="shpr_nm" style="width:100%;" class="noinput"></td>
			</tr>
			<tr>
				<td class="tr2_head">Shipper Address</td>
				<td><input type="text" name="shpr_addr" style="width:100%;" class="noinput"></td>
			</tr>
<%if(strPgmNo.equals("ESM_BKG_0217-1")) { %>
			<tr>
<% }else{ %>
			<tr style="display:none;">
<% }%>						
			
				<td class="tr2_head">Shipper Country</td>
				<td><input type="text" name="shpr_cnt" style="width:100%;" class="noinput"></td>
			</tr>
<%if(strPgmNo.equals("ESM_BKG_0217-1")) { %>
			<tr>
<% }else{ %>
			<tr style="display:none;">			
<% }%>						
			
				<td class="tr2_head">Shipper Street / P.O.Box</td>
				<td><input type="text" name="shpr_st_po" style="width:100%;" class="noinput"></td>
			</tr>
<%if(strPgmNo.equals("ESM_BKG_0217-1")) { %>
			<tr>
<% }else{ %>
			<tr style="display:none;">
<% }%>									
				<td class="tr2_head">Enterprise Code</td>
				<td><input type="text" name="shpr_rgst_no" style="width:100%;" class="noinput"></td>
			</tr>
<%if(strPgmNo.equals("ESM_BKG_0217-1")) { %>
			<tr>
<% }else{ %>
			<tr style="display:none;">
<% }%>						
				<td class="tr2_head">Shipper Fax</td>
				<td><input type="text" name="shpr_fax" style="width:100%;" class="noinput"></td>
			</tr>
<%if(strPgmNo.equals("ESM_BKG_0217-1")) { %>
			<tr>
<% }else{ %>
			<tr style="display:none;">
<% }%>						
				<td class="tr2_head">Shipper E-mail</td>
				<td><input type="text" name="shpr_eml" style="width:100%;" class="noinput"></td>
			</tr>
<%if(strPgmNo.equals("ESM_BKG_0217-1")) { %>
			<tr>
<% }else{ %>
			<tr style="display:none;">
<% }%>									
				<td class="tr2_head">Shipper Phone</td>
				<td><input type="text" name="shpr_phn" style="width:100%;" class="noinput"></td>
			</tr>			
			<tr>
				<td class="tr2_head">Consignee Name</td>
				<td><input type="text" name="cnee_nm" style="width:100%;" class="noinput"></td>
			</tr>
			<tr>
				<td class="tr2_head">Consignee Address</td>
				<td><input type="text" name="cnee_addr" style="width:100%;" class="noinput"></td>
			</tr>
<%if(strPgmNo.equals("ESM_BKG_0217-1")) { %>
			<tr>
<% }else{ %>
			<tr style="display:none;">
<% }%>	
				<td class="tr2_head">Consignee Country</td>
				<td><input type="text" name="cnee_cnt" style="width:100%;" class="noinput"></td>
			</tr>
<%if(strPgmNo.equals("ESM_BKG_0217-1")) { %>
			<tr>
<% }else{ %>
			<tr style="display:none;">
<% }%>	
				<td class="tr2_head">Consignee Street / P.O.Box</td>
				<td><input type="text" name="cnee_st_po" style="width:100%;" class="noinput"></td>
			</tr>			
<%if(strPgmNo.equals("ESM_BKG_0217-1")) { %>
			<tr>
<% }else{ %>
			<tr style="display:none;">
<% }%>	
<!-- 				<td class="tr2_head">USCI/ORG/B.Lic/EC</td> -->
				<td class="tr2_head" style="align:center;">
					<select name="cnee_co_chn_tp_cd" style="width:70%;" class="input1" onChange="form_OnChange();">
						<option value="">Enterprise Code</option>
						<option value="U">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;USCI No.</option>
						<option value="O">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ORG No.</option>
						<option value="B">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;B.Lic No.</option>
					</select>
				</td>
				<td>	
					<input type="text" name="cnee_rgst_no" style="width:83%;" class="noinput">
				</td>
			</tr>		
<%if(strPgmNo.equals("ESM_BKG_0217-1")) { %>
			<tr>
<% }else{ %>
			<tr style="display:none;">
<% }%>	
				<td class="tr2_head">Consignee Fax</td>
				<td><input type="text" name="cnee_fax" style="width:100%;" class="noinput"></td>
			</tr>
<%if(strPgmNo.equals("ESM_BKG_0217-1")) { %>
			<tr>
<% }else{ %>
			<tr style="display:none;">
<% }%>	
				<td class="tr2_head">Consignee E-mail</td>
				<td><input type="text" name="cnee_eml" style="width:100%;" class="noinput"></td>
			</tr>			
<%if(strPgmNo.equals("ESM_BKG_0217-1")) { %>
			<tr>
<% }else{ %>
			<tr style="display:none;">
<% }%>	
				<td class="tr2_head">Consignee Phone</td>
				<td><input type="text" name="cnee_phn" style="width:100%;" class="noinput"></td>
			</tr>				
			<tr>
				<td class="tr2_head">Notify Name</td>
				<td><input type="text" name="ntfy_nm" style="width:100%;" class="noinput"></td>
			</tr>
			<tr>
				<td class="tr2_head">Notify Address</td>
				<td><input type="text" name="ntfy_addr" style="width:100%;" class="noinput"></td>
			</tr>
<%if(strPgmNo.equals("ESM_BKG_0217-1")) { %>
			<tr>
<% }else{ %>
			<tr style="display:none;">
<% }%>	
				<td class="tr2_head">Notify Country</td>
				<td><input type="text" name="ntfy_cnt" style="width:100%;" class="noinput"></td>
			</tr>
<%if(strPgmNo.equals("ESM_BKG_0217-1")) { %>
			<tr>
<% }else{ %>
			<tr style="display:none;">
<% }%>	
				<td class="tr2_head">Notify Street / P.O.Box</td>
				<td><input type="text" name="ntfy_st_po" style="width:100%;" class="noinput"></td>
			</tr>
<%if(strPgmNo.equals("ESM_BKG_0217-1")) { %>
			<tr>
<% }else{ %>
			<tr style="display:none;">
<% }%>	
				<td class="tr2_head" style="align:center;">
					<select name="ntfy_co_chn_tp_cd" style="width:70%;" class="input1" onChange="form_OnChange();">
						<option value="" style="align:center;">Enterprise Code</option>
						<option value="U">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;USCI No.</option>
						<option value="O">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ORG No.</option>
						<option value="B">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;B.Lic No.</option>
					</select>
				</td>
				<td>	
					<input type="text" name="ntfy_rgst_no" style="width:83%;" class="noinput">
				</td>
			</tr>	
<%if(strPgmNo.equals("ESM_BKG_0217-1")) { %>
			<tr>
<% }else{ %>
			<tr style="display:none;">
<% }%>	
				<td class="tr2_head">Notify Fax</td>
				<td><input type="text" name="ntfy_fax" style="width:100%;" class="noinput"></td>
			</tr>
<%if(strPgmNo.equals("ESM_BKG_0217-1")) { %>
			<tr>
<% }else{ %>
			<tr style="display:none;">
<% }%>	
				<td class="tr2_head">Notify E-mail</td>
				<td><input type="text" name="ntfy_eml" style="width:100%;" class="noinput"></td>
			</tr>			
<%if(strPgmNo.equals("ESM_BKG_0217-1")) { %>
			<tr>
<% }else{ %>
			<tr style="display:none;">
<% }%>	
				<td class="tr2_head">Notify Phone</td>
				<td><input type="text" name="ntfy_phn" style="width:100%;" class="noinput"></td>
			</tr>										
			</table>
            <!-- Grid  (S) -->
            <table width="100%"  id="mainTable">
                <tr>
                    <td width="100%">
                        <script language="javascript">ComSheetObject('t2sheet1');</script>
                    </td>
                </tr>
            </table>
            <!-- Grid (E) -->

		</td></tr>
		</table>
 		</div>
	</div>
	<!-- (TAB) Customer Info (E) -->


	<!-- (TAB) Danger Info.(S) -->
	<div id="tabLayer" style="display:none">

		<table class="search">
       	<tr><td class="bg">

			<!-- Grid  (S) -->
			<table width="100%"  id="mainTable">
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('t3sheet1');</script>
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
						<td class="btn2" name="btn_RowAdd_3">Row&nbsp;Add</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_RowDel_3">Row&nbsp;Delete</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
					</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->

			</td></tr>
		</table>

	</div>
	<!-- (TAB) Danger Info. (E) -->

<!-- : ( Button : pop ) (S) -->
<table width="100%" border="0">
<tr><td align="center">

    <table width="998" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:13;"> 
      	<tr><td class="btn1_bg">
	    <table border="0" cellpadding="0" cellspacing="0">
	    <tr>
			<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
				<tr><td class="btn1_left"></td>
				<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
				<td class="btn1_right"></td>
				</tr>
			</table></td>
			<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
				<tr><td class="btn1_left"></td>
				<td class="btn1" name="btn_New">New</td>
				<td class="btn1_right"></td>
				</tr>
			</table></td>
			 <td class="btn1_line"></td>
			<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
				<tr><td class="btn1_left"></td>
				<td class="btn1" name="btn_Save">Save</td>
				<td class="btn1_right"></td>
				</tr>
			</table></td>
            <td class="btn1_line"></td>
			<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
				<tr><td class="btn1_left"></td>
				<td class="btn1" name="btn_Transmit">Transmit Manifest</td>
				<td class="btn1_right"></td>
				</tr>
			</table></td>
			<td width="106">
	            <% if( "D".equals(strTransMode)) { %>
	            <script language="javascript">ComComboObject('msg_type', 1, 155, 1, 1);</script>
	            <% }else{ %>
	            <script language="javascript">ComComboObject('msg_type', 1, 120, 1, 1);</script>
	            <% } %>
			</td>
			<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
				<tr><td class="btn1_left"></td>
				<td class="btn1" name="btn_Mark">Remark(s)</td>
				<td class="btn1_right"></td>
				</tr>
			</table></td>
		</tr>
		</table>
	
	</td></tr>
	</table>
	<!-- : ( Button : pop ) (E) -->

</td></tr>
</table>
  
</td></tr>
</table>  
<!-- 본문끝 -->

<%@include file="/apps/alps/esm/bkg/bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_CLOSE.jsp" %> 

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>