<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_PRD_0001.jsp
*@FileTitle  : Geographical Hierarchy Inquiry 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse" %>
<%@ page import="com.clt.apps.opus.esd.prd.common.prdcommon.vo.ContinentVO" %>
<%@ page import="java.util.List" %>
<%
    GeneralEventResponse eventResponse = null;  //RDTO(Data Transfer Object including DB ResultSet)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	List<ContinentVO> list = null;
	try {
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		} else {
			eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
			if (eventResponse != null) {
				list = eventResponse.getRsVoList();
			}
		} 
	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		}
		loadPage();
	}
</script>

<form name="form" action="">
<input	type="hidden" name="f_cmd">
<input type="hidden" name="iPage">

<!-- page(S) -->
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	
	<!-- page_title(S) -->
    <!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->

	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--  
		--><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button>
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
<div class="wrap_search">
<div class="opus_design_inquiry wFit">
    <!-- 조회영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
    <table>
    	<colgroup>
            <col width="70" />
            <col width="90" />
            <col width="100" />
            <col width="100" />
            <col width="60" />
            <col width="120" />
            <col width="60" />
            <col width="90" />
            <col width="60" />
            <col width="" />
        </colgroup>
        <tbody>
			<tr>
				<th>Continent</th>
				<td style="padding-left:3"><input type="hidden" name="conti_code" id="conti_code" value=""><!--
				--><select name="select1" id="select1" style="width:70px;"  tabIndex="1" onChange="changeContinent()">
						<option value="0" >All</option>
						<%
						if(list != null) {
							for(int i=0; i< list.size(); i++){
								ContinentVO vo = (ContinentVO)list.get(i);
								if(vo != null) {
									out.println("<option value='"+ vo.getContiCode() +"' >" + vo.getContiCode() + "</option>");
								}
							}
						}
						%>
					</select>
				</td>
				<th>Sub-Continent</th>
				<td><input type="hidden" name="subconti_code" value=""><!--
				--><select name="select2" style="width:70px"  tabIndex="2" onChange="changeSubContinent()">
						<option value="0" selected>All</option>
					</select>
				</td>
				<th>Country</th>
				<td><input name="country_code" id="country_code" type="text"  maxlength="2" style="width:60px;text-align:center" value="" tabIndex="3" dataformat="engup" style="text-align:center" onkeypress="PrdComKeyEnter()"><!--
				--><button type="button" class="input_seach_btn" name="btn_country" id="btn_country"></button></td>
				<th>Region</th>
				<td>
					<input name="region_code" id="region_code" type="text"  maxlength="3" style="width:60px;text-align:center" value="" tabIndex="4" dataformat="engup" style="text-align:center" onkeypress="PrdComKeyEnter()"></td>
				<th>Location</th>
				<td><input name="location_code" id="location_code" type="text"  maxlength="5" style="width:70px;text-align:center" value="" tabIndex="5" dataformat="engup" style="text-align:center" onkeypress="PrdComKeyEnter()"><!--
				--><button type="button" class="input_seach_btn" name="btn_location" id="btn_location"></button></td>
			</tr>
		</tbody>
	</table>
	<!-- 조회영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
</div>
</div>
<!-- opus_design_inquiry(E) -->



<!-- wrap_result(S) -->
<div class="wrap_result">

	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid mar_btm_4">
		<!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    <script type="text/javascript">ComSheetObject('sheet1');</script>
	    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	</div>
	<table class="line_bluedot mar_btm_4"><tr><td></td></tr></table>
	<!-- opus_design_grid(E) -->


	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry" style="width:900px;">
	
			<!-- 1ST (S) -->
			<div class="opus_design_inquiry sm">
				<h3 class="title_design">Geo. Hierarchy</h3>
				<table>
					<colgroup>
						<col width="120"/>		
						<col width="280"/>	
						<col width="100"/>	
						<col />				
					</colgroup> 
					<tbody>
						<tr>
							<th>Continent</th>
							<td><input name="g_cnti_cd" class="noinput1" readonly type="text" style="width:40px;text-align:center;" value="" id="g_cnti_cd" /><!--
							--><input name="g_cnti_nm" class="noinput1" readonly type="text" style="width:150px;text-align:center;" value="" id="g_cnti_nm" /></td>
							<th>State / Province</th>
							<td><input name="g_ste_cd" class="noinput1" readonly type="text" style="width:60px;text-align:center;" value="" id="g_ste_cd" /><!--
							--><input name="g_ste_nm" class="noinput1" readonly type="text" style="width:150px;text-align:center;" value="" id="g_ste_nm" />
							</td>
						</tr>
						<tr>
							<th>Sub-continent</th>
							<td><input name="g_subcnti_cd" class="noinput1" readonly type="text" style="width:40px;text-align:center;" value="" id="g_subcnti_cd" /><input name="g_subcnti_nm" class="noinput1" readonly type="text" style="width:150px;text-align:center;" value="" id="g_subcnti_nm" /></td>
							<th>Location</th>
							<td><input name="g_loc_cd" class="noinput1" readonly type="text" style="width:60px;text-align:center;" value="" id="g_loc_cd" /><input name="g_loc_nm" class="noinput1" readonly type="text" style="width:150px;text-align:center;" value="" id="g_loc_nm" />
							</td>
						</tr>
						<tr>
							<th>Country</th>
							<td><input name="g_cntr_cd" class="noinput1" readonly type="text" style="width:40px;text-align:center;" value="" id="g_cntr_cd" /><input name="g_cntr_nm" class="noinput1" readonly type="text" style="width:150px;text-align:center;" value="" id="g_cntr_nm" /></td>
							<th>UN Code</th>
							<td><input name="g_un_flag" class="noinput1" readonly type="text" style="width:60px;text-align:center;" value="" id="g_un_flag" /><input name="g_un_cd" class="noinput1" readonly type="text" style="width:150px;text-align:center;" value="" id="g_un_cd" /></td>
						</tr>
						<tr>
							<th>Region</th>
							<td><input name="g_rgn_cd" class="noinput1" readonly type="text" style="width:40px;text-align:center;" value="" id="g_rgn_cd" /><input name="g_rgn_nm" class="noinput1" readonly type="text" style="width:150px;text-align:center;" value="" id="g_rgn_nm" /></td>
							<th>Location Grid</th>
							<td><input name="loc_grid" class="noinput1" readonly type="text" style="width:213px;text-align:center;" value="" id="loc_grid" /></td>
						</tr>
					</tbody>
				</table>
			</div>
			<!-- 1ST (E) -->
	
			<!-- 2ND (S) -->
			<!-- layout_wrap(S) -->
			<div class="layout_wrap">
	
				<div class="layout_vertical_3 pad_rgt_8" style="width:25%">
					<div class="opus_design_inquiry sm" style="height:179px;">
			
						<h3 class="title_design">Office Info.</h3>
						<table>
							<colgroup>
								<col width="120"/>		
								<col />				
							</colgroup> 
							<tbody>
								<tr>
									<th>Sales OFC</th>
									<td><input name="sls_ofc" class="noinput1" readonly type="text" style="width:60px;text-align:center;" value="" id="sls_ofc" /></td>
								</tr>
								<tr>
									<th>EQ OFC</th>
									<td><input name="eq_ofc" class="noinput1" readonly type="text" style="width:60px;text-align:center;" value="" id="eq_ofc" /> </td>
								</tr>
								<tr>
									<th>Finance OFC</th>
									<td><input name="fin_ofc" class="noinput1" readonly type="text" style="width:60px;text-align:center;" value="" id="fin_ofc" /> </td>
								</tr>	
							</tbody>		
						</table>
					
					</div>
				</div>
				<div class="layout_vertical_3 pad_rgt_8" style="width:20%">
					<div class="opus_design_inquiry sm" style="height:179px;">
			
						<h3 class="title_design">EQ Loc. Info.</h3>
						<table>
							<colgroup>
								<col width="70"/>		
								<col />				
							</colgroup> 
							<tbody>
								<tr>
									<th>RCC</th>
									<td><input name="rcc_cd" class="noinput1" readonly type="text" style="width:60px;text-align:center;" value="" id="rcc_cd" /> </td>
								</tr>
								<tr>
									<th>LCC</th>
									<td><input name="lcc_cd" class="noinput1" readonly type="text" style="width:60px;text-align:center;" value="" id="lcc_cd" /> </td>
								</tr>
								<tr>
									<th>ECC</th>
									<td><input name="ecc_cd" class="noinput1" readonly type="text" style="width:60px;text-align:center;" value="" id="ecc_cd" /> </td>
								</tr>
								<tr>
									<th>SCC</th>
									<td><input name="scc_cd" class="noinput1" readonly type="text" style="width:60px;text-align:center;" value="" id="scc_cd" /> </td>
								</tr>	
							</tbody>					
						</table>
					
					</div>
				</div>
				<div class="layout_vertical_3" style="width:55%">
					<div class="opus_design_inquiry sm">
	
						<h3 class="title_design">Others</h3>
						<table>
							<colgroup>
								<col width="100"/>	
								<col width="120"/>
								<col width="120"/>	
								<col />				
							</colgroup> 
							<tbody>
								<tr>
									<th>B/L Prefix</th>
									<td><input name="bl_frefix" class="noinput1" readonly type="text" style="width:60px;text-align:center;" value="" id="bl_frefix" /> </td>
									<th>Commercial Zone</th>
									<td><input name="cms_zone" class="noinput1" readonly type="text" style="width:70px;text-align:center;" value="" id="cms_zone" /> </td>
								</tr>
								<tr>
									<th>Canada Customs</th>
									<td><input name="custms" class="noinput1" readonly type="text" style="width:60px;text-align:center;" value="" id="custms" /> </td>
									<th>Rep. Zone</th>
									<td><input name="rep_zn_cd" class="noinput1" readonly type="text" style="width:70px;text-align:center;" value="" id="rep_zn_cd" /> </td>
								</tr>
								<tr>
									<th>Loc. Char.</th>
									<td><input name="loc_char" class="noinput1" readonly type="text" style="width:60px;text-align:center;" value="" id="loc_char" /> </td>
									<th>Rep.MTY PKUP YD</th>
									<td><input name="mty_pkup_yd_cd" class="noinput1" readonly type="text" style="width:70px;text-align:center;" value="" id="mty_pkup_yd_cd" /> </td>
								</tr>
								<tr>
									<th>GMT</th>
									<td><input name="gmt" class="noinput1" readonly type="text" style="width:60px;text-align:center;" value="" id="gmt" /> </td>
									<th>Rep.EQ RTN YD</th>
									<td><input name="refre_cy" class="noinput1" readonly type="text" style="width:70px;text-align:center;" value="" id="refre_cy" /> </td>
								</tr>
								<tr>
									<td colspan="2"></td>
									<th>US AMS Code</th>
									<td><input name="ams_cd" class="noinput1" readonly type="text" style="width:70px;text-align:center;" value="" id="ams_cd" /> </td>
								</tr>
							</tbody>					
						</table>
	
					</div>
				</div>
				
			</div>
			<!-- layout_wrap(E) -->
			<!-- 2ND (E) -->
			<!-- 3RD (S) -->
			<div class="opus_design_inquiry sm">
				<h3 class="title_design">Port Info.</h3>
				<table>
					<colgroup>
						<col width="70"/>
						<col width="100"/>
						<col width="100"/>		
						<col />				
					</colgroup> 
					<tbody>
						<tr>
							<th>Port</th>
							<td><input name="port_cd" class="noinput1" readonly type="text" style="width:60px;text-align:center;" value="" id="port_cd" /></td>
							<th>Calling Port</th>
							<td><input name="coll_port" class="noinput1" readonly type="text" style="width:60px;text-align:center;" value="" id="coll_port" /></td>
						</tr>
					</tbody>
				</table>
			</div>
			<!-- 3RD (E) -->		
		
		
	</div>
	<!-- opus_design_inquiry(E) -->
	
    
</div>
<!-- wrap_result(E) -->
<!-- page(E) -->



</form>
<!-- TABLE '#B' : 'Left + Right Body' Table (E)nd -->
<iframe name="HiddenFrame" id="HiddenFrame" frameborder="0" marginheight="0" marginwidth="0" width="0" height="0"></iframe>
