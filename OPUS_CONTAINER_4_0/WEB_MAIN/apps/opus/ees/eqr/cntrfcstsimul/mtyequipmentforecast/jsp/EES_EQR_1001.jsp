<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : EES_EQR_1001.jsp
*@FileTitle : OP/MG Forecast Input
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/19
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";

	String optionStr = "";	
	String locSelectBox = JSPUtil.getCodeCombo("loc_grp_cd","L","","CD03052",0,optionStr);		

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}

	String optionStr2 = "000000: :ALL";
    String cntrTpsz  = JSPUtil.getCodeCombo("cntrTpsz","","style='width:70;'","CD00263",0,optionStr2);
    String locSelectBox2 = JSPUtil.getCodeCombo("loc_tp_cd_second","L","","CD03052",0,"");   
%>

<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="init_flag" id="init_flag" />
<input type="hidden" name="search_flag" id="search_flag" />

<input type="hidden" name="inquiryLevel" value="" id="inquiryLevel" />
<input type="hidden" name="location" value="" id="location" />
<!-- 개발자 작업	-->

<!-- 제목 -->
<div class="page_title_area clear">
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
		<!-- page_title(E) -->

		<!-- btn_div -->
	<div class="opus_design_btn">
	    <button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--
	    --><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!--
	    --><button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button><!--
	    --><button type="button" class="btn_normal" name="btn_downExcel" id="btn_downExcel">Down Excel</button>
	</div>

   <!-- page_location(S) -->
   <div class="location">
		<span id="navigation"></span>
   </div>
</div>
<!-- 제목 -->

<div class="wrap_search">
	<div class="opus_design_inquiry wFit">
	<table>
		<colgroup>
			<col width="250" />
			<col width="70" />
			<col width="150" />
			<col width="70" />
			<col width="70" />
			<col width="*" />
		</colgroup>
		<tbody>
		<tr>
			<td><%= locSelectBox %><input type="text" class="input" name="loc_cd" required style="ime-mode:inactive" dataformat="engup" size="5" maxlength="5" fulfill="" value="" onblur="obj_blur();" id="loc_cd" /><button type="button" class="input_seach_btn" name="btn_loc_cd" id="btn_loc_cd"></button></td>
			<th>Balance Report ID</th>
			<td><input type="text" name="fcast_yrwk" required maxlength="7" style="width:60px;" dataformat="yw" class="input1" value="" id="fcast_yrwk" /><label for = "fcast_yrwk">(YYYY-WW)</label></td>
            <th>TP/SZ</th>
            <th><%= cntrTpsz %><script type="text/javascript">ComComboObject('tpsztype' , 1, 280, 1 )</script></th>
            <td></td>
  		</tr> 
  		</tbody>
		</table>
	</div>	
</div>
<div class="wrap_result">
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
<div class="layout_wrap">
	 <div class="layout_vertical_2" style ="width: 34%;">
	 	<h3 style="margin-bottom:0" class="title_design">Reference 1</h3>
		<div class="opus_design_grid">
			<script type="text/javascript">ComSheetObject('sheet2');</script>
		</div>	
	 </div>
	 <div class="layout_vertical_2" align="center" style = "width: 1%">
	<div style="width: 150px;">&nbsp;</div>
	</div>
	 <div class="layout_vertical_2" style ="width: 65%;">
	 	<h3 style="margin-bottom:0" class="title_design">Reference 2</h3>
		<div class="opus_design_grid">
			<script type="text/javascript">ComSheetObject('sheet3');</script>
		</div>	
	 </div>
</div>
</div>
</form>