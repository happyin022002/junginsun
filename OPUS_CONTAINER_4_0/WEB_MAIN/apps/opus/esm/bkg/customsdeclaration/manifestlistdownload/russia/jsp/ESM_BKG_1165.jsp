<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_1165.jsp
*@FileTitle : Edit Customer Information
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.19
*@LastModifier : 이병규
*@LastVersion : 1.0
* 2009.06.19 이병규
* 1.0 Creation
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>

<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.russia.event.EsmBkg1165Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg1165Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	Logger log = Logger.getLogger("com.clt.opus.Outboundblmgt.Blissuance");
	
    String bkg_no         = "";
    String bl_no          = "";
    String ok_hidden      = "";
    String send_hidden    = "";
    String form_type      = "";
    String form_dataOnly  = "";
    String form_manifest  = "";
    String form_hiddeData = "";
    String form_mainOnly  = "";
    String form_level     = "";
    String form_remark    = "";
    String form_Cntr      = "";
    String form_CorrNo    = "";
    String form_his_cntr  = "";
    String form_his_bkg   = "";
    String form_his_mkd   = "";
    String form_his_xpt   = "";
    String form_his_bl    = "";
    String rp             = "";
    String ui_id          = "";
    String ntc_knd_cd     = "";
    String func           = "";  // 호출할 부모창의 스크립트 메소드 (pop_mode가 1(function 호출형) 인 경우)
    String pop_mode       = "";  // Popup 모드 (1: function 호출형, 2: target 세팅형)
    String sheetIdx       = "";  // Multi Sheet인 경우, Sheet의 Index 정보
    String row            = "";  // Sheet에서 팝업 호출시, Target이 되는 Cell의 row 정보
    String col            = "";  // Sheet에서 팝업 호출시, Target이 되는 Cell의 col 정보
    String fax_no         = "";  // 팩스번호
    String email          = "";  // 이메일주소
    String fax_email      = "";  // fax or email 구분
    String sh_cust_nm     = "";
    String sh_cust_addr   = "";
    String cn_cust_nm     = "";
    String cn_cust_addr   = "";
    String nf_cust_nm   = "";
    String nf_cust_addr   = "";
    String ex_cust_nm   = "";
    

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg1165Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		//bkg_no = "KORZ1025122|KORY6085393|HKGZ1020073";
        bkg_no         = JSPUtil.getParameter(request, "bkg_no"                             );
        bl_no          = JSPUtil.getParameter(request, "bl_no"                              );
        ok_hidden      = JSPUtil.getParameter(request, "ok_hidden"       , "N"              );
        send_hidden    = JSPUtil.getParameter(request, "send_hidden"     , "N"              );
        form_type      = JSPUtil.getParameter(request, "form_type"       , "2"              );
        form_dataOnly  = JSPUtil.getParameter(request, "form_dataOnly"   , "N"              );
        form_manifest  = JSPUtil.getParameter(request, "form_manifest"   , "N"              );
        form_hiddeData = JSPUtil.getParameter(request, "form_hiddeData"  , "N"              );
        form_mainOnly  = JSPUtil.getParameter(request, "form_mainOnly"   , "N"              );
        form_level     = JSPUtil.getParameter(request, "form_level"      , "1"              );
        form_remark    = JSPUtil.getParameter(request, "form_remark"     , ""               );
        form_Cntr      = JSPUtil.getParameter(request, "form_Cntr"       , "1"              );
        form_CorrNo    = JSPUtil.getParameter(request, "form_CorrNo"     , ""               );
        form_his_cntr  = JSPUtil.getParameter(request, "form_his_cntr"   , "BKG_CONTAINER"  );
        form_his_bkg   = JSPUtil.getParameter(request, "form_his_bkg"    , "BKG_BOOKING"    );
        form_his_mkd   = JSPUtil.getParameter(request, "form_his_mkd"    , "BKG_BL_MK_DESC" );
        form_his_xpt   = JSPUtil.getParameter(request, "form_his_xpt"    , "BKG_XPT_IMP_LIC");
        form_his_bl    = JSPUtil.getParameter(request, "form_his_bl"     , "BKG_BL_DOC"     );
        rp             = JSPUtil.getParameter(request, "rp"              , ""               );
        ui_id          = JSPUtil.getParameter(request, "ui_id"                              );
        ntc_knd_cd     = JSPUtil.getParameter(request, "ntc_knd_cd"                         );
        func           = JSPUtil.getParameter(request, "func"                               );
        pop_mode       = JSPUtil.getParameter(request, "pop_mode"        , "1"              );
        sheetIdx       = JSPUtil.getParameter(request, "sheetIdx"                           );
        row            = JSPUtil.getParameter(request, "row"                                );
        col            = JSPUtil.getParameter(request, "col"                                );
        fax_no         = JSPUtil.getParameter(request, "fax_no"          , ""               );
        email          = JSPUtil.getParameter(request, "email"           , ""               );
        fax_email      = JSPUtil.getParameter(request, "fax_email"                          );
        sh_cust_nm		   = JSPUtil.getParameter(request, "sh_cust_nm" );
        sh_cust_addr	   = JSPUtil.getParameter(request, "sh_cust_addr" );
        cn_cust_nm		   = JSPUtil.getParameter(request, "cn_cust_nm" );
        cn_cust_addr	   = JSPUtil.getParameter(request, "cn_cust_addr" );
        nf_cust_nm		   = JSPUtil.getParameter(request, "nf_cust_nm" );
        nf_cust_addr	   = JSPUtil.getParameter(request, "nf_cust_addr" );
        ex_cust_nm	   = JSPUtil.getParameter(request, "ex_cust_nm" );
        
        
	} catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Edit Customer Information</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="/opuscntr/css/nis2010_contents.css" type="text/css" rel="stylesheet"/>

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

<body CLASS="POPUP_BG" onLoad="setupPage()">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="bkg_no"         value="<%=bkg_no        %>">




    
    <!--  <input type="hidden" name="bl_no"          value="<%=bl_no         %>">
<input type="hidden" name="form_type"      value="<%=form_type     %>">
<input type="hidden" name="form_dataOnly"  value="<%=form_dataOnly %>">
<input type="hidden" name="form_manifest"  value="<%=form_manifest %>">
<input type="hidden" name="form_hiddeData" value="<%=form_hiddeData%>">
<input type="hidden" name="form_mainOnly"  value="<%=form_mainOnly %>">
<input type="hidden" name="form_level"     value="<%=form_level    %>">
<input type="hidden" name="form_remark"    value="<%=form_remark   %>">
<input type="hidden" name="form_Cntr"      value="<%=form_Cntr     %>">
<input type="hidden" name="form_CorrNo"    value="<%=form_CorrNo   %>">
<input type="hidden" name="form_his_cntr"  value="<%=form_his_cntr %>">
<input type="hidden" name="form_his_bkg"   value="<%=form_his_bkg  %>">
<input type="hidden" name="form_his_mkd"   value="<%=form_his_mkd  %>">
<input type="hidden" name="form_his_xpt"   value="<%=form_his_xpt  %>">
<input type="hidden" name="form_his_bl"    value="<%=form_his_bl   %>">
<input type="hidden" name="rp"             value="<%=rp            %>">
<input type="hidden" name="ui_id"          value="<%=ui_id         %>">
<input type="hidden" name="ntc_knd_cd"     value="<%=ntc_knd_cd    %>">-->
<%-- fax,email element 전에 input 을 추가하지 말것 : element 순서로 return하는 함수가 있음 --%>
<!-- 개발자 작업	-->

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
	<!-- : ( Title ) (S) -->
	<table width="100%" border="0">
	<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Edit Customer Information</td></tr>
	</table>
	<!-- : ( Title ) (E) -->
	
	<!-- : ( Search Options ) (S) -->
	<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="480">
						<table class="search" border="0" style="width:480;">
							
						</table>
						<table class="search_sm2" border="0" style="width:480;"> 
							<tr class="h23">
								<td>		
									<table class="search_sm2" border="0" style="width:460;"> 
									<tr class="h23" width="100%">
				 				   <td width="73">Shipper</td>
								    <!--<td><input type="text" name="sh_cust_cnt_cd" style="width:25;" class="input1" value="" maxlength=2 style="ime-mode:disabled"  dataformat="engup" tabindex=11>&nbsp;<img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_t7Sh0192" id="btn_t7Sh0192">&nbsp;<input type="text" name="sh_cust_seq" style="width:58;" class="input1" value="" maxlength=6 style="ime-mode:disabled"  dataformat="int" tabindex=12>&nbsp;<img class="cursor" src="img/btns_inquiry.gif" width="19" height="20" border="0" align="absmiddle" name="btn_t7ShMdmCustNm" id="btn_t7ShMdmCustNm">&nbsp;<input type="text" name="sh_cust_lgl_eng_nm" style="width:120;" class="input2" value="" readonly>&nbsp;<input type="text" style="width:25;" class="input2" value="" readonly name="sh_cust_tp">&nbsp;<script language="javascript" >ComComboObject('kr_cstms_cust_tp_cd', 2, 90, 1, 0, 2)</script></td>-->
							        </tr>
										<tr class="h23">
											<td width="68" class="stm">Name</td>
											<td><textarea  cols="35" rows="2" style="font-family:Courier New; font-size:15px; text-indent:0px;overflow-y:scroll;overflow-x:hidden" class="textarea_img2" wrap="physical" dataformat="exceptengdn" onBlur="javascript:validateCols('2','35',this, 'Shipper');" class="textarea1" name="sh_cust_nm" tabindex=13><%=sh_cust_nm%></textarea></td>
										</tr>
										<tr class="h23">
											<td width="" class="stm">Address</td>
											<td width=""colspan="6"><textarea cols="35" rows="3" style="font-family:Courier New; font-size:15px; text-indent:0px;overflow-y:scroll;overflow-x:hidden" class="textarea_img3" wrap="physical" dataformat="exceptengdn" onBlur="javascript:validateCols('3','35',this, 'Shipper');" wrap="hard"  class="textarea1" name="sh_cust_addr" tabindex=14><%=sh_cust_addr%></textarea></td>
										</tr>
									</table>
								</td>
							</tr>
						</table>									
						
						<table class="height_8"><tr><td></td></tr></table>
						
						<table class="search" border="0" style="width:480;">
							
						</table>						
						<table class="search_sm2" border="0" style="width:480;"> 
							<tr class="h23">
								<td>								
									<table class="search" border="0" style="width:460;"> 
									<tr class="h23"width="100%">
					 				<td width="73">Consignee</td>
									<!--<td class="stm"><input type="text" name="cn_cust_cnt_cd" style="width:25;" class="input1" value="" maxlength=2 style="ime-mode:disabled"  dataformat="engup" tabindex=21>&nbsp;<img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_t7Cn0192" id="btn_t7Cn0192">&nbsp;<input type="text"  name="cn_cust_seq" style="width:58;" class="input1" value="" maxlength=6 style="ime-mode:disabled"  dataformat="int" tabindex=22>&nbsp;<img class="cursor" src="img/btns_inquiry.gif" width="19" height="20" border="0" align="absmiddle" name="btn_t7CnMdmCustNm" id="btn_t7CnMdmCustNm">&nbsp;<input type="text" name="cn_cust_lgl_eng_nm" style="width:120;" class="input2" value="" readonly>&nbsp;<input type="text" style="width:25;" class="input2" value="" readonly name="cn_cust_tp">&nbsp;B/L Type&nbsp;<select style="width:60;" class="input" name="cust_to_ord_flg"><option value="Y">Order</option><option value="N">Straight</option></select></td>-->
									</tr>
										<tr class="h23">
											<td width="68" class="stm">Name</td>
											<td ><textarea  cols="35" rows="2" style="font-family:Courier New; font-size:15px; text-indent:0px;overflow-y:scroll;overflow-x:hidden" class="textarea_img2" wrap="physical" dataformat="exceptengdn" onBlur="javascript:validateCols('2','35',this, 'Consignee');" wrap="hard"  name="cn_cust_nm" tabindex=23><%=cn_cust_nm%></textarea></td>
										</tr>
										<tr class="h23">
											<td width="" class="stm">Address</td>
											<td width=""><textarea cols="35" rows="3" style="font-family:Courier New; font-size:15px; text-indent:0px;overflow-y:scroll;overflow-x:hidden" class="textarea_img3" wrap="physical" dataformat="exceptengdn" onBlur="javascript:validateCols('3','35',this, 'Consignee');" wrap="hard"  name="cn_cust_addr" tabindex=24><%=cn_cust_addr%></textarea></td>
										</tr>
									</table>							
								</td>
							</tr>
						</table>
						
						
						<table class="height_8"><tr><td></td></tr></table>
						
						<table class="search" border="0" style="width:480;">
							
						</table>
						
						<table class="search_sm2" border="0" style="width:480;"> 
							<tr class="h23">
								<td>								
									<table class="search" border="0" style="width:460;"> 
									<tr class="h23"width="100%">
					 					<td width="73">Notify</td>  
										<!--<td><input type="text" style="width:25;" class="input" value="" name="nf_cust_cnt_cd" maxlength=2 style="ime-mode:disabled"  dataformat="engup" tabindex=41>&nbsp;<img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_t7Nf0192" id="btn_t7Nf0192">&nbsp;<input type="text" style="width:58;" class="input" value="" name="nf_cust_seq"  maxlength=6 style="ime-mode:disabled"  dataformat="int" tabindex=42>&nbsp;<img class="cursor" src="img/btns_inquiry.gif" width="19" height="20" border="0" align="absmiddle" name="btn_t7NfMdmCustNm" id="btn_t7NfMdmCustNm">&nbsp;<input type="text" style="width:120;" class="input2" value="" name="nf_cust_lgl_eng_nm"  readonly>&nbsp;<input type="text" style="width:25;" class="input2" value="" readonly name="nf_cust_tp"></td>-->
									</tr>
										<tr class="h23">
											<td width="68" class="stm">Name</td>
											<td ><textarea  cols="35" rows="2" style="font-family:Courier New; font-size:15px; text-indent:0px;overflow-y:scroll;overflow-x:hidden" class="textarea_img2" wrap="physical" dataformat="exceptengdn" onBlur="javascript:validateCols('2','35',this, 'Notify');" wrap="hard"  name="nf_cust_nm" tabindex=43><%=nf_cust_nm%></textarea></td>
										</tr>
										<tr class="h23">
											<td width="" class="stm">Address</td>
											<td width=""><textarea cols="35" rows="3" style="font-family:Courier New; font-size:15px; text-indent:0px;overflow-y:scroll;overflow-x:hidden" class="textarea_img3" wrap="physical" dataformat="exceptengdn" onBlur="javascript:validateCols('3','35',this, 'Notify');" wrap="hard"  name="nf_cust_addr" tabindex=44><%=nf_cust_addr%></textarea></td>
										</tr>
									</table>
														
								</td>
							</tr>
						</table>	
						
						
						<table class="height_8"><tr><td></td></tr></table>
						
						<table class="search" border="0" style="width:480;">
							
						</table>						
						<table class="search_sm2" border="0" style="width:480;"> 
							<tr class="h23">
								<td>								
									<table class="search" border="0" style="width:460;"> 
									<tr class="h23"width="100%">
					 				
									<!--<td class="stm"><input type="text" name="cn_cust_cnt_cd" style="width:25;" class="input1" value="" maxlength=2 style="ime-mode:disabled"  dataformat="engup" tabindex=21>&nbsp;<img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_t7Cn0192" id="btn_t7Cn0192">&nbsp;<input type="text"  name="cn_cust_seq" style="width:58;" class="input1" value="" maxlength=6 style="ime-mode:disabled"  dataformat="int" tabindex=22>&nbsp;<img class="cursor" src="img/btns_inquiry.gif" width="19" height="20" border="0" align="absmiddle" name="btn_t7CnMdmCustNm" id="btn_t7CnMdmCustNm">&nbsp;<input type="text" name="cn_cust_lgl_eng_nm" style="width:120;" class="input2" value="" readonly>&nbsp;<input type="text" style="width:25;" class="input2" value="" readonly name="cn_cust_tp">&nbsp;B/L Type&nbsp;<select style="width:60;" class="input" name="cust_to_ord_flg"><option value="Y">Order</option><option value="N">Straight</option></select></td>-->
									</tr>
										<tr class="h23">
										<td width="68">Export Reference No.&nbsp;&nbsp;&nbsp;&nbsp;</td>
											<td><textarea  cols="35" rows="3" style="font-family:Courier New; font-size:15px; text-indent:0px;overflow-y:scroll;overflow-x:hidden" class="textarea_img3" wrap="physical" dataformat="exceptengdn" onBlur="javascript:validateCols('3','35',this, 'Export Ref.');" wrap="hard"  name="ex_cust_nm" tabindex=23><%=ex_cust_nm%></textarea></td>
										</tr>
									</table>							
								</td>
							</tr>
						</table>
					</td>
					</tr>
					</table>
	<!-- : ( Search Options ) (E) -->
<table class="height_5"><tr><td></td></tr></table>
</td></tr></table> 

<!--Grid (S)-->
<table width="0"  id="mainTable"> 
	<tr>
		<td width="0">
			<script language="javascript">ComSheetObject('sheet1');</script>
		</td>
	</tr>
</table> 
<!--Grid (E)-->
	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0" align="center">
		    <tr>
				<% if (!"Y".equalsIgnoreCase(ok_hidden)) { %>
				<td width="71"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_ok">Ok</td>
					<td class="btn1_right"></td>
				</tr></table></td>
				<% } %>
				
				<td class="btn1_line"></td>
				<td width="71"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_close">Close</td>
					<td class="btn1_right"></td>
				</tr></table></td>
			</tr></table></td>
		</tr></table>
			
    <!--Button (E) -->
	
</td></tr></table>

<!-- : ( Button : pop ) (E) -->

<!-- 개발자 작업  끝 -->
<!--<input type="hidden" name="strUsr_id" value="<%=strUsr_id %>"> -->
</form>

<form name="form2">
    <input type="hidden" name="func"        value="<%=func       %>">
    <input type="hidden" name="pop_mode"    value="<%=pop_mode   %>">
    <input type="hidden" name="sheetIdx"    value="<%=sheetIdx   %>">
    <input type="hidden" name="row"         value="<%=row        %>">
    <input type="hidden" name="col"         value="<%=col        %>">
    <input type="hidden" name="fax_email"   value="<%=fax_email  %>">
    
    <input type="hidden" name="sh_cust_nm"        value="<%=sh_cust_nm%>">
    <input type="hidden" name="sh_cust_addr"    value="<%=sh_cust_addr%>">
    <input type="hidden" name="cn_cust_nm"    value="<%=cn_cust_nm%>">
    <input type="hidden" name="cn_cust_addr"         value="<%=cn_cust_addr%>">
    <input type="hidden" name="nf_cust_nm"         value="<%=nf_cust_nm%>">
    <input type="hidden" name="nf_cust_addr"   value="<%=nf_cust_addr%>">
     <input type="hidden" name="ex_cust_nm"   value="<%=ex_cust_nm%>">
</form>

</body>
</html>
