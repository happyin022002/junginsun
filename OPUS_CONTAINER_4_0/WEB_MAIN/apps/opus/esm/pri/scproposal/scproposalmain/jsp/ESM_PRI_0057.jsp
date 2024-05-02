<%
/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName   : ESM_PRI_0057.jsp
 *@FileTitle  : Amendment History Inquiry
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/05/27
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.util.StringUtil" %>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.pri.scproposal.scproposalmain.event.EsmPri0057Event"%>
<%@ page import="com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>
<%@ page import="com.clt.apps.opus.esm.pri.common.PRIUtil"%>
<%@ page import="java.util.List"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.component.util.code.CodeInfo"%>
<%@ page import="com.clt.framework.component.common.AbstractValueObject"%>
<%@ page import="org.apache.log4j.Logger" %>


<%
	EsmPri0057Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_ofc		= "";
	String strUsrSrepCd     = "";
	Logger log = Logger.getLogger("com.clt.apps.SCProposal.SCProposalMain");
	String[] termType = null;
	String scNo0062 = "";
	
	//		account.getSrep_cd()
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_ofc = account.getOfc_cd();
	    strUsrSrepCd = account.getSrep_cd();
		event = (EsmPri0057Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
        // adding logic to get data from server when first loading
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		termType = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("termType"), false);
		//call from 0004,0062	
		scNo0062 = request.getParameter("sc_no_0062");
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
    var termTypeComboValue = " |<%=termType[0]%>";
    var termTypeComboText = " |<%=termType[1]%>";
    
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd" 			id="f_cmd">
<input type="hidden" name="pagerows" 		id="pagerows">
<input type="hidden" name="in_usr_ofc_cd" 	id="in_usr_ofc_cd" value="<%=strUsr_ofc%>">
<input type="hidden" name="in_usr_srep_cd" 	id="in_usr_srep_cd" value="<%=strUsrSrepCd%>">
<input type="hidden" name="in_usr_nm" 		id="in_usr_nm" value="<%=strUsr_nm%>">
<input type="hidden" name="prop_no" 		id="prop_no">
<input type="hidden" name="lgcy_if_flg" 	id="lgcy_if_flg">
<!--  from 0062 popup call -->
<input type="hidden" name="sc_no_0062" 		id="sc_no_0062" value="<%=StringUtil.xssFilter(scNo0062)%>">

<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" 	id="btn_retrieve">Retrieve</button><!--
		 --><button type="button" class="btn_normal" name="btn_new"  		id="btn_new">New</button>
	</div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->

<div class="wrap_search">
<!-- opus_design_inquiry(S) -->
<div class="opus_design_inquiry wFit">
	<table>
		<tbody>
			<colgroup>
				<col width="70px"/>
				<col width="120px"/>
				<col width="85px"/>
				<col width="60px"/>
				<col width="70px"/>
				<col width="220px" />
				<col width="70px" />
				<col width="170px" />
			</colgroup>
			<tr class="h23">
				<th>S/C No.</th>
				<td>
					<input type="text" name="sc_no2" 		id="sc_no2" 		style="width:80px;text-align:center;" class="input1" dataformat="engup" maxlength="9" onKeyDown="ComKeyEnter('NextFocus')">
				</td>
				<th>AMD No.</th>
				<td>
					<input type="text" name="amdt_seq" 		id="amdt_seq" 		style="width:40px;text-align:center;" class="input2" readonly>
				</td>
				<th>Customer</th>
				<td>
					<input type="text" name="ctrt_pty_nm" 	id="ctrt_pty_nm" 	style="width:230px;" class="input2" readonly>
				</td>
				<th>Duration</th>
				<td>
					<input type="text" name="ctrt_eff_dt" 	id="ctrt_eff_dt" 	style="width:80px;text-align:center;" class="input2" readonly maxlength="10" dataformat="ymd">&nbsp;&nbsp;~&nbsp;&nbsp;
					<input type="text" name="ctrt_exp_dt" 	id="ctrt_exp_dt" 	style="width:80px;text-align:center;" class="input2" readonly maxlength="10" dataformat="ymd">
				</td>
			</tr>
			<tr class="h23">
				<th>SVC Scope</th>
				<td colspan="5">
					<script type="text/javascript">ComComboObject('svc_scp_cd', 2, 80, 0, 0, 0, false);</script>
					<input type="text" name="svc_scp_nm" id="svc_scp_nm" style="width:502px;" class="input2" readonly caption="Service Scope Name">
				</td>
				<th>By Item</th>
				<td>
					<script type="text/javascript">ComComboObject('term_type_cd', 1, 188, 0, 0, 0, false);</script>
				</td>
				<td>
					<input type="hidden" id="con_flg" name="con_flg" value=""><label for="con_flg" style="display:none;">Conversion</label>
				</td> 
			</tr>
   		</tbody>
	</table>
</div>
<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
<!-- opus_design_grid(S) -->	
<div class="opus_design_grid" name="mainTable" id="mainTable">
	<script type="text/javascript">ComSheetObject('sheet1');</script>
</div>
<!-- opus_design_grid(E) -->

<!-- opus_tab_btn(S) -->
<div class="opus_design_tab">
	<script type="text/javascript">ComTabObject('tab1')</script>
</div>
<!-- opus_tab_btn(E) -->

<!-- iFrame (S) -->
<div id="tabLayer" name="tabLayer" style="display:none">
	<iframe name="t1frame" id="t1frame" frameborder="0" scrolling="no" width="100%" height="390" src="about:blank"></iframe>
</div>
<div id="tabLayer" name="tabLayer" style="display:none">
	<iframe name="t2frame" id="t2frame" frameborder="0" scrolling="no" width="100%" height="390" src="about:blank"></iframe>
</div>
<div id="tabLayer" name="tabLayer" style="display:none">
	<iframe name="t3frame" id="t3frame" frameborder="0" scrolling="no" width="100%" height="390" src="about:blank"></iframe>
</div>
<div id="tabLayer" name="tabLayer" style="display:none">
	<iframe name="t4frame" id="t4frame" frameborder="0" scrolling="no" width="100%" height="390" src="about:blank"></iframe>
</div>
<div id="tabLayer" name="tabLayer" style="display:none">
	<iframe name="t5frame" id="t5frame" frameborder="0" scrolling="no" width="100%" height="390" src="about:blank"></iframe>
</div>               
<div id="tabLayer" name="tabLayer" style="display:none">
	<iframe name="t6frame" id="t6frame" frameborder="0" scrolling="no" width="100%" height="390" src="about:blank"></iframe>
</div>         
<div id="tabLayer" name="tabLayer" style="display:none">
	<iframe name="t7frame" id="t7frame" frameborder="0" scrolling="no" width="100%" height="390" src="about:blank"></iframe>
</div>     
<div id="tabLayer" name="tabLayer" style="display:none">
	<iframe name="t8frame" id="t8frame" frameborder="0" scrolling="no" width="100%" height="390" src="about:blank"></iframe>
</div>               
<div id="tabLayer" name="tabLayer" style="display:none">
	<iframe name="t9frame" id="t9frame" frameborder="0" scrolling="no" width="100%" height="690" src="about:blank"></iframe>
</div>         
<div id="tabLayer" name="tabLayer" style="display:none">
	<iframe name="t10frame" id="t10frame" frameborder="0" scrolling="no" width="100%" height="390" src="about:blank"></iframe>
</div>  
<div id="tabLayer" name="tabLayer" style="display:none">
	<iframe name="t11frame" id="t11frame" frameborder="0" scrolling="no" width="100%" height="390" src="about:blank"></iframe>
</div>               
<div id="tabLayer" name="tabLayer" style="display:none">
	<iframe name="t12frame" id="t12frame" frameborder="0" scrolling="no" width="100%" height="390" src="about:blank"></iframe>
</div>         
<div id="tabLayer" name="tabLayer" style="display:none">
	<iframe name="t13frame" id="t13frame" frameborder="0" scrolling="no" width="100%" height="390" src="about:blank"></iframe>
</div>  
<div id="tabLayer" name="tabLayer" style="display:none">
	<iframe name="t14frame" id="t14frame" frameborder="0" scrolling="no" width="100%" height="390" src="about:blank"></iframe>
</div>               
<div id="tabLayer" name="tabLayer" style="display:none">
	<iframe name="t15frame" id="t15frame" frameborder="0" scrolling="no" width="100%" height="390" src="about:blank"></iframe>
</div>                                                            
<!-- iFrame (E) -->
</div>
</form>