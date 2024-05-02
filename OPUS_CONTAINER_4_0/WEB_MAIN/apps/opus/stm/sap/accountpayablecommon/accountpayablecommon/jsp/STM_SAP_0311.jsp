<%
/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : STM_SAP_0311.jsp
*@FileTitle  : Credit Card Search Popup 
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
	Exception serverException = null;			//서버에서 발생한 에러
	String strErrMsg  = "";						//에러메세지

	// PARAMETER START
    String crd_no     = "";                     //Card Number
	// PARAMETER END

	String strUsr_id  = "";
	String strUsr_nm  = "";
	String strUsr_ofc = "";

	Logger log = Logger.getLogger("com.clt.apps.opus.stm.sap.accountpayablecommon.AccountpayablecommonSC"); // 에러메세지 위치

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id  = account.getUsr_id();
		strUsr_nm  = account.getUsr_nm();
		strUsr_ofc = account.getOfc_cd();

		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		// PARAMETER START
		crd_no = StringUtil.xssFilter(request.getParameter("crd_no"));                     //Card Number
		crd_no = crd_no==null?"":crd_no;
		// PARAMETER END
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
			<span>Credit Card Search Popup</span>
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
					<colgroup>
						<col width="130" />
						<col width="100" />
						<col width="30" />
						<col width="130" />
						<col width="90" />
						<col width="30" />
						<col width="130" />
						<col width="*" />
					</colgroup>
					<tbody>
						<tr>
							<th>Card Number</th>
		                    <td><input type="text" name="crd_no" maxlength="16" style="width:150px;" class="input" value="<%=crd_no%>" id="crd_no" /></td>
		                    <td></td>
							<th>Card Program Name</th>
		                    <td><input type="text" name="crd_pgm_nm" maxlength="50" style="width:150px;" class="input" id="crd_pgm_nm" /></td> 
		                    <td></td>  
							<th>Card Company Code</th>
		                    <td><script type="text/javascript">ComComboObject('crd_pgm_cd', 2, 80, 1, 0, 0,false ,1);</script></td> 
						</tr> 
						<tr>
							<th>Card Member Name</th>
		                    <td><input type="text" name="crd_mbr_nm" maxlength="50" style="width:150px;" class="input" id="crd_mbr_nm" /></td>
		                    <td></td>
							<th>Card Receipt Team</th>
		                    <td><input type="text" name="crd_dtrb_ofc_cd" maxlength="6" style="width:105px;" class="input" id="crd_dtrb_ofc_cd" /><button type="button" id="btns_search_ctrl_ofc" name="btns_search_ctrl_ofc" class="input_seach_btn"></button></td>
		                    <td></td>
		                    <td></td>
		                    <td></td>   					                                    
						</tr> 			
				</tbody>
			</table>
		</div>
	 </div>		
		<!-- opus_design_inquiry(E) -->
	 <div class="wrap_result" style="overflow:hidden; padding-bottom:30px !important;">
		<div class="opus_design_grid">
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
      </div>
</div>	
</form>
<%@include file="/bizcommon/include/common_opus.jsp"%>  <!----------PARAMETER------------------>