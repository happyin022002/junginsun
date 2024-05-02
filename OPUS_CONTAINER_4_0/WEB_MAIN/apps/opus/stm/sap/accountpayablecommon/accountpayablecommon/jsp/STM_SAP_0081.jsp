<%
/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : STM_SAP_0081.jsp
*@FileTitle  : Bank Branch Popup 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/
=========================================================
*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.component.util.StringUtil" %>

<%
//     StmSap0081Event event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지

	String bank_brnc_nm     = "";                      //PARAMETER

	String strUsr_id = "";
	String strUsr_nm = "";
	Logger log = Logger.getLogger("com.clt.apps.opus.stm.sap.accountpayablecommon.AccountpayablecommonSC"); // 에러메세지 위치

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		bank_brnc_nm = StringUtil.xssFilter(request.getParameter("bank_brnc_nm"));  //PARAMETER
		bank_brnc_nm = bank_brnc_nm==null?"":bank_brnc_nm;           //PARAMETER

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

	} catch(Exception ex) {
		log.error("err " + ex.toString(), ex);
		//out.println(e.toString());
	}
%>

<script type="text/javascript">

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage(); // .js 호출
	}

</script>

</head>
<link href="../css/opus_contents.css" rel="stylesheet" type="text/css">
<link href="../css/opus_menu.css" rel="stylesheet" type="text/css">

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<div class="layer_popup_title">
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title">
		<span>Bank Branch Popup</span>
	</h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_retrieve" id="btn_retrieve" type="button">Retrieve</button><!--
		--><button class="btn_normal" name="btn_new" id="btn_new" type="button">New</button><!--
		--><button class="btn_normal" name="btn_OK" id="btn_OK" type="button">OK</button><!--
		--><button class="btn_normal" name="btn_Close" id="btn_Close" type="button">Close</button><!--
		--></div>
	<!-- opus_design_btn (E) -->
</div>
<!-- page_title_area(E) -->
</div>
 <div class="layer_popup_contents">
<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<tbody>
				<colgroup>
					<col width="100" />
					<col width="250" />
					<col width="70" />
					<col width="250" />
					<col width="50" />
					<col width="70" />
					<col width="250" />
					<col width="*" />
				</colgroup>
				<tr>
					<th>Bank Branch Name</th>
                    <td><input type="text" name="bank_brnc_nm" maxlength="50" style="width:180px;" class="input" value="<%=bank_brnc_nm%>" id="bank_brnc_nm" /></td>
					<th>Bank Name</th>
                    <td><input type="text" name="bank_nm" maxlength="50" style="width:180px;" class="input" id="bank_nm" /></td>   
					<th>Country Code</th>
                    <td><input type="text" name="brnc_cnt_cd" maxlength="25" style="width:60px;" class="input" id="brnc_cnt_cd" /><button type="button" id="btn_cnt" name="btn_cnt" class="input_seach_btn"></button></td>     
                    <td></td>                                   
				</tr> 
				<tr>
					<th>Bank Branch Number</th>
                    <td><input type="text" name="brnc_no" maxlength="25" style="width:180px;" class="input" id="brnc_no" /></td>
					<th>Bank Number</th>
                    <td><input type="text" name="bank_no" maxlength="25" style="width:180px;" class="input" id="bank_no" /></td>
                    <td></td>
                    <td></td>
                    <td></td>   					                                    
				</tr> 			
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>


<div class="wrap_result" style="overflow:hidden; padding-bottom:30px !important;">
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>	
</div>
</form>
<%@include file="/bizcommon/include/common_opus.jsp"%>