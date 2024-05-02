<%
/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_PRD_0014.jsp
*@FileTitle  : Ocean Route management 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/
=========================================================
*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.prd.networklinkmanage.oceanroutemanage.event.EsdPrd0014Event"%>
<%
	EsdPrd0014Event  event = null;
	Exception serverException   = null;
	DBRowSet rowSet	  = null;
	String strErrMsg = "";
	int rowCount	 = 0;
	String ocnFlg = "";
	try {
		event = (EsdPrd0014Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
	} catch(Exception e) {
		out.println(e.toString());
	}
%>
<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} 
		OCN_FLG = 'S';
		loadPage();
	}
</script>

<form method="post" name="form" id="form">
<input id="f_cmd" name="f_cmd" type="hidden" />
<input id="iPage" name="iPage" type="hidden" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title">
		<button type="button"><span id="title"></span></button>
	</h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn"><!-- 
		--><button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!-- 
		--><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!-- 
		--><button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button><!-- 
		--><button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button><!-- 
		--><button type="button" class="btn_normal" name="btn_multi" id="btn_multi">Multi Creation</button><!-- 
		--><button type="button" class="btn_normal" name="btn_auto" id="btn_auto">Auto Creation</button><!-- 
		--><button type="button" class="btn_normal" name="btn_manu" id="btn_manu">Manual Creation</button>
	</div>
	<!-- opus_design_btn(E) -->
	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->


<!-- opus_design_inquiry(S) -->
<div class="wrap_search">
	<div class="opus_design_inquiry wFit">
		<table>
			<tbody>
				<colgroup>
					<col width="10px" />
					<col width="30px" />
					<col width="120px" />
					<col width="30px" />
					<col width="120px" />
					<col width="50px" />
					<col width="120px" />
					<col width="30px" />
					<col width="170px" />
					<col width="30px" />
					<col width="120px" />
					<col width="50px" />
					<col width="30px" />
					<col width="*" />
				</colgroup>
				<tr>
					<td></td>
					<th title="Port of Loading">POL</th>
					<td><input id="pol_port_cd" class="input1" caption="POL" name="pol_port_cd" maxlength="5" style="width: 60px;text-align:center" value="" dataformat="engup" tabindex="1" type="text" /><button class="input_seach_btn" name="btn_pol_port_cd" id="btn_pol_port_cd" type="button"></button></td>
					<th title="Port of Discharging">POD</th>
					<td><input id="pod_port_cd" class="input" name="pod_port_cd" maxlength="5" style="width: 60px;text-align:center" value="" dataformat="engup" tabindex="2" type="text" /><button class="input_seach_btn" name="btn_pod_port_cd" id="btn_pod_port_cd" type="button"></button></td>
					<th>T/S Port</th>
					<td><input id="ts_port_cd" name="ts_port_cd" maxlength="5" style="width: 80px;text-align:center" dataformat="engup" tabindex="3" type="text" /></td>
					<th>Lane</th>
					<td><input id="tnk_lane_cd" name="tnk_lane_cd" caption="Lane" maxlength="3" style="width: 100px;text-align:center" dataformat="engup" tabindex="4" type="text" /><button class="input_seach_btn" name="btn_tnk_lane_cd" id="btn_tnk_lane_cd" type="button"></button></td>
					<th>Type</th>
					<td><input id="ts_type" name="ts_type" value="A" type="hidden" /><select name="select1" style="width: 60px" onChange="changeSelect('T')"  tabIndex="5" ><option value="A" >All</option><option value="D" >Direct</option><option value="T" >T/S</option></select></td>
					<th>Ocean Flag</th>
					<td><script language="javascript">ComComboObject('s_route_flg', 1, 100, 1, 0, 0, 0, 0)</script></td>
					<th>Del Flag</th>
					<td><input id="i_del_flag" name="i_del_flag" class="trans" value="Y" unchecked="" tabindex="6" type="checkbox" /></td>
					<td></td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
<!-- opus_design_inquiry(E) -->

<!-- opus_design_grid(S) -->
<div class="wrap_result">
      <div class="opus_design_grid">
          	<div class="opus_design_btn">
				<button type="button" class="btn_accent" name="btng_pcgeneral" id="btng_pcgeneral">P/C General</button>
		  	</div>
			<script type="text/javascript">ComSheetObject('sheet1');</script>
			<div><strong>This menu will show the vessel schedule that is marked in Guide, Standard and Add call Flag.</strong></div>
      </div>
</div>
<!-- opus_design_grid(E) -->
</form>