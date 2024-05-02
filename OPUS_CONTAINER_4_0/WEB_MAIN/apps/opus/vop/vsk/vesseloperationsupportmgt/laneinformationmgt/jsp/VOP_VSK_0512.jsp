<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_VSK_0512.jsp
*@FileTitle  : Lane Information Creation 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/09
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.laneinformationmgt.event.VopVsk0512Event"%>
<%@ page import="com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.VskComboVO"%>
<%@ page import="com.clt.syscommon.common.table.MdmVslSvcLaneVO"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.apps.opus.bcm.sup.valuemanage.util.ConstantMgr"%>

<%
	VopVsk0512Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB ResultSet list
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.VesselOperationSupportMgt.LaneInformationMgt");
	StringBuffer bunkerPort = new StringBuffer("");
	StringBuffer laneCd = new StringBuffer("");
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		event = (VopVsk0512Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		List<VskComboVO> list = (List<VskComboVO>)eventResponse.getCustomData("BunkerPort");
		List<MdmVslSvcLaneVO> list2 = (List<MdmVslSvcLaneVO>)eventResponse.getCustomData("LaneCd");
		if(list != null){
			for(int cnt = 0; cnt < list.size(); cnt++){
				VskComboVO combo = list.get(cnt);

				bunkerPort.append("|" + combo.getVal());
			}
		}
		if(list2 != null){
			for(int cnt = 0; cnt < list2.size(); cnt++){
				MdmVslSvcLaneVO combo = list2.get(cnt);

				laneCd.append("|" + combo.getVslSlanCd());
			}
		}
	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
<%=ConstantMgr.getCompanyCodeToJS()%>
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form" id="form">
<input id="f_cmd" name="f_cmd" type="hidden" />
<input id="comboCd" name="comboCd" type="hidden" />
<input id="pagerows" name="pagerows" type="hidden" />
<input id="bunkerPort" name="bunkerPort" value="<%=bunkerPort%>" type="hidden" />
<input id="laneCd" name="laneCd" value="<%=laneCd%>" type="hidden" />
<input id="vskd_flet_grp_cd" name="vskd_flet_grp_cd" value="%" type="hidden" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title">
		<button type="button"><span id="title"></h3></button>
	</h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--
		--><button type="button" class="btn_normal" name="btn_New" id="btn_New">New</button>
		<div id="divExcell">
			<button type="button" class="btn_normal" name="btn_DownExcel" id="btn_DownExcel">Down Excel</button>
		</div>
	</div>
	<!-- opus_design_btn(E) -->
	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></h3>
	</div>
</div>
<!-- page_title_area(E) -->


<div class="wrap_search_tab">
<!-- opus_design_inquiry(S) -->
<div class="opus_design_inquiry">
	<table>
		<tbody>
			<colgroup>
				<col width="20px"/>
				<col width="60px"/>
				<col width="120px"/>
				<col width="70px"/>
				<col width="150px"/>
				<col width="*" />
			</colgroup>
			<tr class="h23" align="left">
				<td></td>
				<th>Lane Code</th>
				<td><input id="slan_cd" style="width: 40px; text-align:center;" class="input" value="" name="slan_cd" maxlength="3" caption="Lane Code" type="text" dataformat="engup" /><button class="input_seach_btn" name="ComOpenPopupWithTarget" id="ComOpenPopupWithTarget" type="button"></button></td>
				<th>Updated Date</th>
				<td><input id="upd_dt_view" name="upd_dt_view" style="width: 115px; text-align:center;" class="input2" readonly type="text" /><input id="upd_id_view" name="upd_id_view" style="width: 70px;" class="input2" readonly type="text" /></td>
				<td></td>
			</tr>
		</tbody>
	</table>
</div>
<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
	<!-- opus_tab_btn(S) -->
	<div class="opus_design_tab">
		<script type="text/javascript">ComTabObject('tabLane')</script>
	</div>
	<!-- opus_tab_btn(E) -->
	
	<div  name="tabLayer" id="tabLayer">
		<!-- layout_wrap (S) -->
		<div class="layout_wrap">
		    <div class="layout_vertical_2" style="width: 49%">
		         <!-- opus_design_grid(S) -->
		        <div class="opus_design_grid">
					<h3 class="title_design mar_btm_8">Main SVC Including Operation</h3>
					<script type="text/javascript">ComSheetObject('t1sheet1');</script>
		        </div>
		        <!-- opus_design_grid(E) -->
		    </div>
	    
		    <div class="layout_vertical_2" style="width: 2%;">
		       <table>
		       		<tr>
		       			<td>&nbsp;</td>
		       		</tr>
		       </table>
		    </div>
	     
		    <div class="layout_vertical_2" style="width: 49%">
		    	 <!-- opus_design_grid(S) -->
		        <div class="opus_design_grid">
					<h3 class="title_design mar_btm_8">Main SVC Including Slot Charter Only</h3>
					<script type="text/javascript">ComSheetObject('t1sheet2');</script>
		        </div>
		        <!-- opus_design_grid(E) -->
		    </div>
		</div>
		<!-- layout_wrap (E) -->
		
		<div class="layout_wrap">
		    <div class="layout_vertical_2" style="width: 49%">
		         <!-- opus_design_grid(S) -->
		        <div class="opus_design_grid">
					<h3 class="title_design mar_btm_8">Other Alliance SVC</h3>
					<script type="text/javascript">ComSheetObject('t1sheet3');</script>
		        </div>
		        <!-- opus_design_grid(E) -->
		    </div>
	    
		    <div class="layout_vertical_2" style="width: 2%;">
		       <table>
		       		<tr>
		       			<td>&nbsp;</td>
		       		</tr>
		       </table>
		    </div>
	    
		    <div class="layout_vertical_2" style="width: 49%">
		    	 <!-- opus_design_grid(S) -->
		        <div class="opus_design_grid">
					<h3 class="title_design mar_btm_8">Intra Asia SVC (Including Alliance)</h3>
					<script type="text/javascript">ComSheetObject('t1sheet4');</script>
		        </div>
		        <!-- opus_design_grid(E) -->
		    </div>
		</div>
		<!-- layout_wrap (E) -->
	</div>
	
	<div  name="tabLayer" id="tabLayer">
		<!-- layout_wrap (S) -->
		<div class="layout_wrap">
		    <div class="layout_vertical_2 sm" style="width:24%; height:240px;">
		         <table class="grid2"> 
					<tr><td align="center" width="15%">M :</td>
						<th>Main Service Including Operation</th>
					<tr><td align="center">C :</td>
						<th>Main Service Including Slot Charter Only</th>
					<tr><td align="center">O :</td>
						<th>Other Alliance Service</th>
					<tr><td align="center">I :</td>
						<th>Intra Asia Service Including Alliance</th>
				</table> 
		    </div>
	    
		    <div class="layout_vertical_2" style="width: 2%;">
		       <table>
		       		<tr>
		       			<td>&nbsp;</td>
		       		</tr>
		       </table>
		    </div>
	    
		    <div class="layout_vertical_2" style="width: 36%">
		    	 <!-- opus_design_grid(S) -->
		        <div class="opus_design_grid">
					<script type="text/javascript">ComSheetObject('t2sheet1');</script>
		        </div>
		        <!-- opus_design_grid(E) -->
		    </div>
		    
		    <div class="layout_vertical_2" style="width: 2%;">
		       <table>
		       		<tr>
		       			<td>&nbsp;</td>
		       		</tr>
		       </table>
		    </div>
		    
		     <div class="layout_vertical_2" style="width: 36%">
		         <!-- opus_design_grid(S) -->
		        <div class="opus_design_grid">
					<script type="text/javascript">ComSheetObject('t2sheet2');</script>
		        </div>
		        <!-- opus_design_grid(E) -->
		    </div>
		</div>
		<!-- layout_wrap (E) -->
		
		  <!-- opus_design_grid(S) -->
		        <div class="opus_design_grid">
					<h3 class="title_design mar_btm_8"> Vessel SVC - Service Including Vessel</h3>
					<script type="text/javascript">ComSheetObject('t2sheet3');</script>
		        </div>
          <!-- opus_design_grid(E) -->
	</div>
	
	<div id="tabLayer">
         <!-- opus_design_grid(S) -->
        <div class="opus_design_grid">
			<h3 class="title_design mar_btm_8">Own Vessel Operator</h3>
			<script type="text/javascript">ComSheetObject('t3sheet1');</script>
        </div>
        <!-- opus_design_grid(E) -->
        
         <!-- opus_design_grid(S) -->
        <div class="opus_design_grid">
			<h3 class="title_design mar_btm_8">Partner's Vessel Operator</h3>
			<script type="text/javascript">ComSheetObject('t3sheet2');</script>
        </div>
        <!-- opus_design_grid(E) -->
        
         <!-- opus_design_grid(S) -->
        <div class="opus_design_grid">
			<h3 class="title_design mar_btm_8">Special Cargo Authorization Part</h3>
			<script type="text/javascript">ComSheetObject('t3sheet3');</script>
        </div>
        <!-- opus_design_grid(E) -->
        
        <!-- opus_design_grid(S) -->
        <div class="opus_design_grid Fit" style="display: none;">
			<script type="text/javascript">ComSheetObject('t3sheet4');</script>
        </div>
        <!-- opus_design_grid(E) -->
	</div>
	
	<div name="tabLayer" id="tabLayer">
         <!-- opus_design_grid(S) -->
        <div class="opus_design_grid">
			<h3 class="title_design mar_btm_8">Unit of Measure(%)</h3>
			<script type="text/javascript">ComSheetObject('t4sheet1');</script>
        </div>
        <!-- opus_design_grid(E) -->
	</div>
</div>



<div id="divSheet1" style="display:none;"><script type="text/javascript">ComSheetObject('sheet1');</script></div>
<div id="divSheet2" style="display:none;"><script type="text/javascript">ComSheetObject('sheet2');</script></div>
<!--  -->
</form>