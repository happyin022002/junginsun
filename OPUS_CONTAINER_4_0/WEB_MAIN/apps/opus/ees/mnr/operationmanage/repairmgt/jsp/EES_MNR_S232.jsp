<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EXP_SPP_S139.jsp
*@FileTitle  : SPP Damage Flagging/Unflagging Pop Up
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
<%@ page import="com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.event.EesMnrS232Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesMnrS232Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	//기존소스용    
 	String eqType = ((request.getParameter("eq_type")==null )?"":request.getParameter("eq_type"));
	//String dmgFlag = ((request.getParameter("dmg_flag")==null )?"":request.getParameter("returntitle"));

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strVndr_seq 		= "";
	String strVndr_nm		= "";
	String currOfcCd		= "";
	Logger log = Logger.getLogger("com.clt.apps.opus.ees.mnr.operationmanage.eqflagmgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id(); 
		strUsr_nm = account.getUsr_nm(); 
		currOfcCd       = account.getOfc_cd();
		strVndr_seq = account.getOfc_eng_nm();
		strVndr_nm 	= account.getOfc_krn_nm();

		event = (EesMnrS232Event)request.getAttribute("Event");
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


<script type="text/javascript">   
	function setupPage(){ 
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="eq_type" value="<%=eqType%>" id="eq_type" />
<input type="hidden" name="vndr_seq" value="<%=strVndr_seq %>" id="vndr_seq" />
<input type="hidden" name="cost_ofc_cd" value="<%=currOfcCd %>" id="cost_ofc_cd" />
<div class="layer_popup_contents">
	<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	   <!-- page_title(S) -->
		<h2 class="page_title"><span>Repair Completion Creation File Import_Pop Up</span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_new" 	id="btn_new">New</button><!--
			--><button type="button" class="btn_normal" name="btn_loadExcel" id="btn_loadExcel">Load Excel</button><!--
			--><button type="button" class="btn_normal" name="btn_ok" id="btn_ok">Ok</button><!--
			--><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button><!--
		--></div>
		<!-- opus_design_btn(E) -->
		<!-- page_location(S) -->
		<div class="location">
			<span id="navigation"></span>
		</div>
		<!-- page_location(E) -->
	</div>
	<!-- page_title_area(E) -->
	</div>
	
	<div class= "wrap_search">
		<div class= "opus_design_inquiry wFit">
			<table>
				<colgroup>
					<col width="60" />
					<col width="*" />
				</colgroup>
				<tbody>
					<tr>      
						<th>EQ Type</th>
						<td><script type="text/javascript">ComComboObject('combo1',1, 100 ,1,1)</script></td>     
					</tr>
				</tbody>
			</table>
		</div>
	</div>		
	<!-- opus_design_grid(S) -->	
	<div class="wrap_result">
		<div class="opus_design_grid clear" id="mainTable" >
			<div class="opus_design_btn">
				<button type="button" class="btn_accent" name="btn_Save" 	id="btn_Save">Verify</button><!--
				--><button type="button" class="btn_normal" name="btn_RowAdd" id="btn_RowAdd">Row Add</button><!--
				--><button type="button" class="btn_normal" name="btn_RowDel" id="btn_RowDel">Row Del</button><!--
			--></div>
				<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
		<div class= "opus_design_inquiry wFit">
			<h3 class="title_design">Repair Creation File Format</h3>
			<table class="grid_2 wAuto">
				<colgroup>
					<col width="100" />
					<col width="*" />
					<col width="*" />
				</colgroup>
				<tbody>
					<tr>
						<th>EQ No.</th>
						<th>Yard</th>
						<th>Date</th>
					</tr>  
					<tr> 
						<th>HJCU1234567</th>
						<th>KRPUSR1</th>
						<td><script type="text/javascript">document.writeln(ComGetNowInfo());</script></td>
					</tr> 
				</tbody>
			</table>
		</div>
	</div>
	<!-- opus_design_grid(E) -->
</div> 
</form>  

 