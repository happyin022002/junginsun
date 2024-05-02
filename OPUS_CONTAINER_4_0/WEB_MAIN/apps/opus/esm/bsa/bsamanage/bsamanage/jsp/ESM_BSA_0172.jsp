<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BSA_0172.jsp
*@FileTitle  : Carrier's Register
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/11
=========================================================
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.util.io.HttpUtil"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bsa.bsamanage.bsamanage.event.EsmBsa0172Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBsa0172Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.BSAManage.BSAManage");

	String	headSet = null;
    String xml = "";
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBsa0172Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// Extracting the data gotten from serve while initial loading ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		headSet = eventResponse.getCustomData("headSet").toString();

        xml = HttpUtil.makeXML(request,response); 
        xml = xml.replaceAll("\"", "'");
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage("<%=headSet%>");
		document.form.txtSDate.focus();
	}
</script>
<!-- 2014.11.20 김용습 - iframe을 div로 감싸서 div의 display를 none으로 설정하지 않으면 타이틀 아래 불필요한 하얀 여백이 생겨서, 해당 작업합니다 -->
<div style="display:none">
	<iframe height="0" width="0" name="frmHidden" id="frmHidden"></iframe>
</div>

<!-- <form method="post" name="form" id="form" onSubmit="return false;" onKeyDown="ComKeyEnter();"> -->
<form method="post" name="form" id="form" onSubmit="return false;">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="iPage" id="iPage" />
<input type="hidden" name="param1" id="param1" />
<input type="hidden" name="param2" id="param2" />
<input type="hidden" name="param3" id="param3" />
<input type="hidden" name="param4" id="param4" />
<input type="hidden" name="param5" id="param5" />
<input type="hidden" name="param6" id="param6" />
<input type="hidden" name="param7" id="param7" />
<input type="hidden" name="param8" id="param8" />
<input type="hidden" name="header2" id="header2"      value="<%=headSet%>">
<input type="hidden" name="sXml" id="sXml"         value="<%=xml%>"> 
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title">
		<button type="button"><span id="title"></span></button>
	</h2>
<!-- page_title(E) -->
<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		 <button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--  
	  --><button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button><!-- 
	  --><button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button>
	</div>
<!-- opus_design_btn(E) -->
<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<!-- page_location(E) -->
<!-- opus_design_inquiry(S) -->
<div class= "wrap_search">
	<div class= "opus_design_inquiry wFit">
	<table>
		<tbody>
		<colgroup>
			<col width="60">
			<col width="100">
			<col width="60">
			<col width="70">
			<col width="60">
			<col width="70">
			<col width="70">
			<col width="60">
			<col width="*">
		</colgroup>
		<tr>
			<th>Period</th>
			<td><input class="input1" type="text" dataformat="ymd" name="txtSDate" id="txtSDate" style="width:75px;text-align:center;ime-mode:disabled;" autocomplete="off" maxlength="8" onKeyPress="ComKeyOnlyNumber(this, '-');"   onKeyUp="ComKeyEnter('LengthNextFocus');" OnBeforeDeactivate="ComAddSeparator(this);"  OnBeforeActivate="ComClearSeparator(this);"><!-- 
				 --><button type="button" class="calendar ir" name="btns_calendar1" id="btns_calendar1"></button>~&nbsp;<!-- 
				 --><input class="" type="text" dataformat="ymd"  name="txtEDate" id="txtEDate" style="width:75px;text-align:center;ime-mode:disabled;" autocomplete="off" maxlength="8" onKeyPress="ComKeyOnlyNumber(this, '-');"   onKeyUp="ComKeyEnter('LengthNextFocus');"OnBeforeDeactivate="ComAddSeparator(this);"OnBeforeActivate="ComClearSeparator(this);"><!-- 
				 --><button type="button" class="calendar ir" name="btns_calendar2" id="btns_calendar2"></button></td><!-- 
			 --><th>(ETD of 1st Port)</th>
			<th>Trade</th>
			<td><script type="text/javascript">ComComboObject('cobTrade', 1, 70 , 0 )</script></td>
			<th>Lane</th>
			<td><div id="div_rLane"><script type="text/javascript">ComComboObject('cobLane', 1, 70 , 0 )</script></div></td>
			<th>Dir</th>
			<td><script type="text/javascript">ComComboObject('cobDir', 1, 70 , 0 )</script></td>
		</tr>
		</tbody>
	</table>
	</div>
	<table><tr><td class="line_bluedot"></td></tr></table>
	<div class= "opus_design_inquiry wFit">	
	<table>
	   <tbody>
		<colgroup>
			<col width="19">
			<col width="200">
			<col width="80">
			<col width="*">				
	   </colgroup>
		<tr>
			<td></td>
			<td><div id="div_bsaHighCubic" style = "display: inline"></div></td>
			<th>Carriers with BSA only</th>
			<td><input type="checkbox" name="isExcludZero" id="isExcludZero" value="1" class="trans"></td>
		</tr>
	</tbody>
</table>
</div>
</div>
<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" style="display:inline">
		<div id="div_opjob" style="float:left; font-weight: bold"></div>
		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn">
		<table><tr><td>
			    <button type="button" class="btn_normal" name="btng_rowadd" id="btng_rowadd">Row Add</button><!-- 
			    --><button type="button" class="btn_normal" name="btng_rowcopy" id="btng_rowcopy">Row Copy</button></td><!-- 
		    	--><td><div id="div_zoom_in" name="div_zoom_in" style="display:none;">
			    		<button type="button" class="btn_up" id="bu_zoom_in" name="bu_zoom_in" title="Zoom In (+)" style="margin-left:5px;margin-bottom:4px"></button>
			 	   </div></td> 
			 	<td><div id="div_zoom_out" name="div_zoom_out">
		          		<button type="button" class="btn_down"  id="bu_zoom_out" name="bu_zoom_out" title="Zoom out(-)" style="margin-left:5px;margin-bottom:4px"></button>
		           </div></td></tr></table>
		           <!-- 2014.11.20 김용습 - 줌버튼 수정 -->
<!-- 		    	<span id="div_zoom_in" style="display:none" >
			    		<button type="button" class="btn_toggle_hide mar_left_4" id="bu_zoom_in" name="bu_zoom_in" title="Zoom In (+)"></button>
			 	   </span>
			 	<span id="div_zoom_out">
		          		<button type="button" class="btn_toggle_show mar_left_4"  id="bu_zoom_out" name="bu_zoom_out" title="Zoom out(-)"></button>
		           </span> -->
		           
		           
		<!-- opus_design_btn (E) -->
		</div>
		<div id="d3_opt">
			<script type="text/javascript">ComSheetObject('sheet1');</script>	
		</div>
			
	</div>
	<!-- opus_design_grid(E) -->
	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" id="d5_opt" style="display:none">
		<div id="div_opjob2" style="float:left; font-weight: bold"></div>
		<script type="text/javascript">ComSheetObject('sheet2');</script>
	</div>
	<!-- opus_design_grid(E) -->
	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" id="d7_opt" style="display:none">
		<div id="div_opjob2" style="float:left; font-weight: bold"></div>
		<script type="text/javascript">ComSheetObject('sheet3');</script>
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>
