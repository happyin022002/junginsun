<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : stm_sar_5003.jsp // 수정
*@FileTitle  : Agent Statement of Account Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/05
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.stm.sar.accountreceivableagent.accountreceivableagent.event.StmSar5003Event"%> <!-- user:kien.tran temp -->
<%@ page import="org.apache.log4j.Logger" %>


<%
    StmSar5003Event event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지

	String asa_no  = "";

	String strUsr_id = "";
	String strUsr_nm = "";
	String strUsr_ofc = "";
	Logger log = Logger.getLogger("com.clt.apps.opus.stm.sar.accountreceivableagent.AccountreceivableagentSC"); //수정

	String glmonFm = JSPUtil.getKST("yyyy-MM-dd");
	String glmonTo = JSPUtil.getKST("yyyy-MM-dd");

	String bil_cre_prd_fm_dt = JSPUtil.getKST("yyyy-MM");
	String bil_cre_prd_to_dt = JSPUtil.getKST("yyyy-MM");



	try {
		/*
		꼭 유저의 정보를 받을 필요는 없습니다. 화면에서 유저의 이름이나 
		권한같은 정보를 이용할 필요가 있을 경우에만 사용하면 됩니다.
		덧붙여 USER 정보에 대해서 한마디로 정리하면 user 의 정보를 이용할수 있는 곳은 jsp 와 command 입니다.
		jsp에서는 유저의 정보를 가지고 권한에 따른 버튼 처리등을 할수가 있는 것이고 (enable/disable)
		command에서는 역시 유저의 정보로 예를 들어 update 권한등이 있는지를 확인할 수가 있는 것입니다.

		주의> 사용자 테이블이 변경됨에 따라 변경 될 것입니다.
			SignOnUserAccount 의 메서드를 확인 하십시오.
			getAuth 메서드는 현재 미정이지만 권한 관련 value를 가져올 메서드가 있겠죠? 
	     */
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_ofc = account.getOfc_cd();
		/* 
		일단 화면에서 USER가 입력한 정보를 다시 화면에서 사용해야 하는 경우 
		request에 담아 서버로 전송시켰다가 다시 그 request에서 받아야 한다고 했습니다.
		이때 유저가 작성한 자료는 event 에 서버로부터 전송된 자료는 eventResponse에 담기게 됩니다.
		이렇게 받은 정보는 jsp 맨 하단에 있는 java script로부터 폼의 value로 값을 전달하게 됩니다.
		본 jsp소스 맨 하단을 참조하십시오.
		*/
		/* 
		ErrorHandler를 통해서 받는 에러는 CO_ERRMESSAGE 테이블에 입력되어있는 
		개발자가 정의했거나 공통팀에서 결정한 정의가 되어진 에러메세지입니다 
		Command 에서 EventException으로 throw를 했거나 DAO에서 DAOException을 통해 
		jsp 까지 전달이 되게 됩니다. 해당 파일을 참조하십시오.
		jsp에서 최후에 에러가 display될때 onload시에 실행되는 ShowErrMessage 를 통해 showErrMessage();가 뜨게 됩니다.
		(주의) 이 에러메세지와 자바스크립트 에러를 혼동하지는 마십시오. 
			자바스크립트 에러는 서버로 전송하기전에 "주민등록번호가 잘못되었습니다" 라는 메세지이고 
			throw되는 메세지는 update 를 하려고 권한을 확인해보니까 없어서 
			"해당 권한이 없습니다" 라고 뿌리는 메세지입니다.
	   */
		event = (StmSar5003Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		asa_no = request.getParameter("asa_no");
		asa_no = asa_no==null?"":asa_no;

		/* 
		아래부분은 꼭 지켜주셔야 에러메세지가 정상적으로 전달이 됩니다. 
		보시다시피 먼저 에러를 받고 에러가 아닐시에 EventResponse로 값을 전달하셔야 합니다. 
		*/

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

	} catch(Exception ex) {
		log.error("err " + ex.toString(), ex);
		//out.println(e.toString());
	}

	/**
	<td><input name="ar_ofc_cd" type="text" style="width:70px;" class="input1" value="SHABB" id="ar_ofc_cd" /> </td>
	                            <button type="button" id="btn_pop_ofc_cd" name="btn_pop_ofc_cd" class="input_seach_btn"></button>
	            */
%>
<script type="text/javascript">

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();  // .js 호출
	}

</script>
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="ar_ofc_cd" id="ar_ofc_cd" />
<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_retrieve" id="btn_retrieve" type="button">Retrieve</button><!--
		--><button class="btn_normal" name="btn_new" id="btn_new" type="button">New</button><!--
		--><button class="btn_normal" name="btn_downexcel" id="btn_downexcel" type="button">Down Excel</button><!--
		--></div>
	<!-- opus_design_btn (E) -->

	<!-- page_location(S) -->
	<div class="location">	
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->
<!-- wrap_search(S) -->
<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="50">				
				<col width="100">				
				<col width="80">				
				<col width="230">				
				<col width="100">				
				<col width="60">				
				<col width="*">				
		   </colgroup> 
		   <tbody>
		   		<tr>
					<th>Agent</th>
                    <td><script type="text/javascript">ComComboObject('agn_ofc_cd', 1, 80, 1, 1);</script></td>                    
                    <th>Effective Month</th>
                    <td><input name="bil_cre_prd_fm_dt" type="text" style="width:70px;" class="input" value="<%=bil_cre_prd_fm_dt%>" dataformat="ym" maxlength="6" id="bil_cre_prd_fm_dt" /><button type="button" id="btnCalduedtFm" name="btnCalduedtFm" class="calendar ir"></button>- <input name="bil_cre_prd_to_dt" type="text" style="width:70px;" class="input" value="<%=bil_cre_prd_to_dt%>" dataformat="ym" maxlength="6" id="bil_cre_prd_to_dt" /><button type="button" id="btnCalduedtTo" name="btnCalduedtTo" class="calendar ir"></button></td>
                    <td><input type="radio" name="appro" id="appro" value="N" 	class="trans" checked  ><label for="appro">Not Approved</label><br/><!--
                    --><input type="radio" name="appro" id="appro_1" value="A" 	class="trans"><label for="appro_1">Approved</label><br/><!--
                    --><span><input type="radio" name="appro" id="appro_2" value="ALL" 	class="trans"><label for="appro_2">All</label></span></td>
                    <th>ASA No3</th>
                    <td><input name="asa_no3_fm" type="text" class="input" style="width:50px;" value="" id="asa_no3_fm" maxlength="4" dataformat="num" />~ <input name="asa_no3_to" type="text" class="input" style="width:50px;" value="" id="asa_no3_to" maxlength="4" dataformat="num" /> </td>
		   		</tr>
		   </tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>
<!-- wrap_search(E) -->
<!-- wrap_result(S) -->
<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet1');</script>		
	</div>
	<!-- opus_design_grid(E) -->
</div>
<!-- wrap_result(E) -->
</form>
<%@include file="/bizcommon/include/common_alps.jsp"%>
