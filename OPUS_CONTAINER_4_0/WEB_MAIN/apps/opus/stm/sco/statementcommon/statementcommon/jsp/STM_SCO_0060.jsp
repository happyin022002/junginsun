<%
/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : STM_SCO_0060.jsp
*@FileTitle : Register Lane & Revenue port
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.stm.sco.statementcommon.statementcommon.event.StmSco0060Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%	StmSco0060Event event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException = null;			//Error from server
	String strErrMsg = "";						//Error message

	String strUsr_id = "";
	String strUsr_nm = "";
	Logger log = Logger.getLogger("com.clt.apps.opus.bcm.fin.financemanagement.financecreation");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
		event = (StmSco0060Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
	} catch(Exception ex) {
		log.error("err " + ex.toString(), ex);
		//out.println(e.toString());
	}
%>

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script> 

<form name="form">
<input type="hidden" name="f_cmd">

<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->


	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
		<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
		--><button type="button" class="btn_normal" name="btn_new"   id="btn_new">New</button><!--
		--><button type="button" class="btn_normal" name="btn_save"   id="btn_save">Save</button>
	</div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->

<!-- opus_design_inquiry(S) -->
<div class= "wrap_search">
<!-- opus_design_inquiry(S) -->
	<div class= "opus_design_inquiry">
		<table>
			<colgroup>
				<col width="90"/>
				<col width="150"/>
				<col width="80"/>
				<col width="*" />
			</colgroup>
			<tbody>
		 		<tr>
					<th>Service Lane</th>
					<td>
						<input type="text" style="width:100px;text-align:center;" class="input" id="s_slan_cd" name="s_slan_cd" maxlength="3" caption="Service Lane" dataformat="engup"><!--
						--><button type="button" id="pop_slan" name="pop_slan" class="input_seach_btn"></button>
					</td>
					<th>Revenue Lane</th>
					<td>
						<input type="text" style="width:50;text-align:center;ime-mode:disabled" class="input" id="s_rlane_cd" name="s_rlane_cd" maxlength="5" dataformat="engup"><button type="button" class="input_seach_btn" name="btn_rlane_search" id="btn_rlane_search"></button>
					</td>
		   		</tr>
	   		</tbody>           
	    </table>
 	</div>
</div>                   
<!-- opus_design_inquiry(E) -->

<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<!-- opus_design_grid(S) -->
</div>

</form>