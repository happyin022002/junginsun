<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : STM_SAP_0064.jsp
*@FileTitle  : Pay Invoice Information Popup
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/12
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.event.StmSap0064Event"%>  

<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.component.util.StringUtil" %>

<%
    StmSap0064Event event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	
	String inv_no    = "";                      //PARAMETER
	String curr_cd		= "";
	String vndr_no		= "";
	String pay_mzd_lu_cd	= "";
	
	String strUsr_id = "";
	String strUsr_nm = "";
	Logger log = Logger.getLogger("com.clt.apps.opus.stm.sap.accountpayablecommon.AccountpayablecommonSC"); // 에러메세지 위치
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
		event = (StmSap0064Event)request.getAttribute("Event");  
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		inv_no = StringUtil.xssFilter(request.getParameter("inv_no"));  
		inv_no = inv_no==null?"" : inv_no;          
		
		curr_cd = StringUtil.xssFilter(request.getParameter("curr_cd"));  
		curr_cd = curr_cd==null?"" : curr_cd;          

		vndr_no = StringUtil.xssFilter(request.getParameter("vndr_no"));  
		vndr_no = vndr_no==null?"" : vndr_no;          

		pay_mzd_lu_cd = StringUtil.xssFilter(request.getParameter("pay_mzd_lu_cd"));  
		pay_mzd_lu_cd = pay_mzd_lu_cd==null?"" : pay_mzd_lu_cd;          
		
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
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="inv_curr_cd" value="<%=curr_cd%>" id="inv_curr_cd" />
<input type="hidden" name="vndr_no" value="<%=vndr_no%>" id="vndr_no" />
<input type="hidden" name="pay_mzd_lu_cd" value="<%=pay_mzd_lu_cd%>" id="pay_mzd_lu_cd" />
<!-- layer_popup_title(S) -->
<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title"><span>Pay Invoice Information</span>
		</h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn">
			    <button class="btn_accent"  type="button"   name="btn_retrieve" id="btn_retrieve">Retrieve</button><!-- 
			 --><button class="btn_normal"  type="button" name="btn_OK" id="btn_OK">OK</button><!--
			 --><button class="btn_normal"  type="button" name="btn_Close" id="btn_Close">Close</button>
		</div>
		<!-- opus_design_btn (E) -->
	</div>
</div>
<!-- layer_popup_contents(S) -->
<div class="layer_popup_contents">
	<div class="wrap_result">
		<!-- opus_design_inquiry (S) -->
		<div class="opus_design_inquiry wFit">
			<table>
				<colgroup>
					<col width="40">
					<col width="*">
				</colgroup>
				<tbody>
					<tr>
						<th>CSR No</th>
	                    <td><input type="text" name="inv_no" id="inv_no" class="input" value="<%=inv_no%>" maxlength="30" dataformat="engup" style="ime-mode:disabled;width:150;"></td>
					</tr> 
				</tbody>
			</table>
		</div>
		<div class="opus_design_inquiry"><table class="line_bluedot"><tr><td></td></tr></table></div>
		<!-- opus_design_inquiry (E) -->
		<div class="opus_design_grid"  id="mainTable">
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
	</div>
</div>
</form>
<%@include file="/bizcommon/include/common_opus.jsp"%>