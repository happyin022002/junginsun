<%--
/*=========================================================
*CyberLogitec. All Rights Reserved.
*@FileName 	 : ESD_TRS_0053.js
*@FileTitle  :  Chassis & Genset ( ESD_TRS_0053 ) 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/05
=========================================================*/
--%>

<%@page import="com.clt.bizcommon.util.BizComUtil"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%
	Exception serverException   = null;
	String strErrMsg = "";
	SignOnUserAccount account = null;
	try {
	   	account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	}catch(Exception e) {
		out.println(e.toString());
	}

	String today = DateTime.getFormatString("yyyyMMdd");
	String beforeOneMonth = DateTime.addDays(today, -30);
	String transTypeCd  = JSPUtil.getCodeCombo("trs_tp_cd", "01", "style='width:74'", "CD00595", 0, "000010:ALL:ALL");
	String transModeCd  = JSPUtil.getCodeCombo("trs_md_cd", "01", "style='width:85'", "CD00283", 0, "000010:ALL:ALL");
%>

<script language="javascript">
var today = '<%=today%>';
var beforeOneMonth = '<%=beforeOneMonth%>';
	<%= BizComUtil.getIBCodeCombo("chss_eq_tpsz_cd", "01", "CHASSIS", 1, "")%>
	<%= BizComUtil.getIBCodeCombo("gen_eq_tpsz_cd", "01", "GENSET", 1, "")%>
	<%= JSPUtil.getIBCodeCombo("trsp_crr_mod_cd", "", "CD00283", 0, "")%>
	<%= JSPUtil.getIBCodeCombo("chss_mgst_trsp_tp_cd", "", "CD00595", 0, "")%>
	<%= JSPUtil.getIBCodeCombo("trsp_so_cmb_tp_cd", "", "CD00762", 0, "")%>
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		}
		loadPage();
	}
</script>

<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="iPage" id="iPage" />
<input type="hidden" name="TRSP_SO_TP_CD" id="TRSP_SO_TP_CD" />
<input type="hidden" name="TRSP_SO_STS_CD" id="TRSP_SO_STS_CD" />
<input type="hidden" name="TRSP_SO_VNDR_NO" id="TRSP_SO_VNDR_NO" />
<input type="hidden" name="TRSP_SO_FM_NODE" id="TRSP_SO_FM_NODE" />
<input type="hidden" name="TRSP_SO_TO_NODE" id="TRSP_SO_TO_NODE" />
<input type="hidden" name="IS_CORR" value="T" id="IS_CORR" />
<input type="hidden" name="TRSP_SO_EQ_KIND" id="TRSP_SO_EQ_KIND" />
<input type="hidden" name="EQ_TPSZ_CD" id="EQ_TPSZ_CD" />
<input type="hidden" name="TRSP_SO_CMB_TP_CD" value="BD" id="TRSP_SO_CMB_TP_CD" />
<input type="hidden" name="FORM_CRE_USR_ID" value="<%=account.getUsr_id()%>" id="FORM_CRE_USR_ID" />
<input type="hidden" name="FORM_USR_OFC_CD" value="<%=account.getOfc_cd()%>" id="FORM_USR_OFC_CD" />
<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" 	id="btn_retrieve">Retrieve</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_reset" 	id="btn_reset">Reset</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_minimize" id="btn_minimize">Minimize</button>	
	</div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->


<div id="MiniLayer" style="display:inline">
<!-- opus_design_inquiry(S) -->
<div class= "wrap_search">
	<div class= "opus_design_inquiry">
		<table>
			<tbody>
					<colgroup>
						<col width="170px"/>
						<col width="115px"/>
						<col width="50px"/>
						<col width="40px"/>
						<col width="114px"/>
						<col width="*"/>
				    </colgroup>
					<tr>
						<th>Service Order Creation Date</th>
						<td><input name="fmdate" type="text" style="width:100px;" value="<%=beforeOneMonth%>" id="fmdate" onfocus="javascript:delHypen(this);" onblur="javascript:delHypen(this); getDateBetween(this);"  dataformat="ymd"  maxlength="8"/> <!-- 
						 --> ~ <!-- 
						 --><input name="todate" type="text" style="width:102px;" value="<%=today%>" id="todate" maxlength="8" onFocus="javascript:delHypen(this);" onBlur="javascript:delHypen(this);"  dataformat="ymd" /><!-- 
						 --><button type="button" id="btns_calendar" name="btns_calendar" class="calendar ir"></button></td>
						<th>Kind</th>
						<td class="sm"><input type="radio" name="kind_chassis" class="trans" value="Z" id="kind_chassis" onClick="setKindEnabled()" checked/> Chassis   <input type="radio" name="kind_chassis" value="G" class="trans" id="kind_chassis" onClick="setKindEnabled()"/> Genset     <%=transTypeCd%></td>
						<th>Equipment No.</th>
						<td><input type="text" style="width:122px;" name="form_eq_no" id="form_eq_no" dataformat="engup"  otherchar=","/><!-- 
					 --><button type="button" id="btn_eq_no" name="btn_eq_no" class="multiple_inq ir"></button></td>
						
					</tr>
					<tr>
						<th>From </th>
						<td><input type="text" style="width:100px;" name="search_fm_loc" onfocus="fun_Focus(this)" onchange="getComboList(this)" onkeyup="enterCheck(this)" maxlength="5" id="search_fm_loc" dataformat="engup" /><script type="text/javascript">ComComboObject('search_fm_yard', 1, 120, 1);</script><button type="button" name='btn_fm_node' id='btn_fm_node' class="input_seach_btn"></button></td>
						<th>To</th>
						<td><input type="text" style="width:110px;" name="search_to_loc" onfocus="fun_Focus(this)" onchange="getComboList(this)" onkeyup="enterCheck(this)" maxlength="5" id="search_to_loc" dataformat="engup" /><script type="text/javascript">ComComboObject('search_to_yard', 1, 120, 1);</script><button type="button" name='btn_to_node' id='btn_to_node' class="input_seach_btn"></button></td>
						<th>Trans Mode</th>
						<td><%=transModeCd%></td>						
				    </tr>
				 
				    <tr>
					<!-- <th>Equipment No.</th>
					<td class="sm"><input type="radio" name="kind_chassis" class="trans" value="Z" checked="" id="kind_chassis" /> Chassis   <input type="radio" name="kind_chassis" value="G" class="trans" id="kind_chassis" /> Genset <input type="text" style="width:122px;" name="form_eq_no" id="form_eq_no" dataformat="engup"  otherchar=","/>
					<button type="button" id="btn_eq_no" name="btn_eq_no" class="multiple_inq ir"></button></td> 
					<td colspan="4"></td> -->           
					</tr>
			</tbody>
		</table>
	</div>
</div>
<!-- opus_design_inquiry(E) -->
</div>

<!-- opus_design_grid(S) -->
<div class="wrap_result">
	<div class="opus_design_grid clear" >
	<div class="opus_design_btn">
		<table>
			<tbody>
				<tr>
					<td><button type="button" class="btn_normal" name="btng_sodelete" 	id="btng_sodelete">S/O Delete</button></td>
					<td><button type="button" class="btn_normal" name="btng_fillineq" 	id=btng_fillineq>File in EQ No.</button></td>
					<td><button type="button" class="btn_normal" name="btng_rateapply" 	id="btng_rateapply">Multiple Apply.</button></td>
					<th style="padding-left:3px"> Bundle Unit / Kind
									<select name="bundle_kind" style="width:70px;">
										<option value='BS'>Stack</option>
										<option value='BF'>Flatbed</option>
									</select>
									<select name="bundle_unit" style="width:50px;">
										<option value='2'>2</option>
										<option value='3'>3</option>
										<option value='4'>4</option>
										<option value='5'>5</option>
										<option value='6'>6</option>
										<option value='7'>7</option>
										<option value='8'>8</option>
										<option value='9'>9</option>
									</select>
						</th>
						<td><button type="button" class="btn_normal" name="btng_bundling" 	id=btng_bundling>Bundling</button></td>
						<td><button type="button" class="btn_normal" name="btng_unbundling" 	id="btng_unbundling">Unbundling</button></td>
						<td><button type="button" class="btn_normal" name="btng_downexcel" 	id=btng_downexcel>Down Excel</button></td>
						<td><button type="button" class="btn_normal" name="btng_socreation" 	id="btng_socreation">S/O Correction</button></td>
						<td><button type="button" class="btn_normal" name="btng_woissue" 	id=btng_woissue>W/O Issue</button></td>
					</tr>
				</tbody>
		</table>		
	</div>
	<script type="text/javascript">ComSheetObject('sheet');</script>
	<script type="text/javascript">ComSheetObject('sheet_hidden');</script>
	<script type="text/javascript">ComSheetObject('sheet_copy');</script>
	<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>
<!-- opus_design_grid(E) -->
</form>
<form name='woForm' method='POST' action='ESD_TRS_0023.screen?parentPgmNo=ESD_TRS_M001'>
<input type="hidden" name="trsp_so_ofc_cty_cd" id="trsp_so_ofc_cty_cd" />
<input type="hidden" name="trsp_so_seq" id="trsp_so_seq" />
<input type="hidden" name="eq_mode" value="CG" id="eq_mode" />
<input type="hidden" name="sysCommUiTitle" value="Issue" id="sysCommUiTitle" />
<input type="hidden" name="pgmNo" value="ESD_TRS_0023" id="pgmNo" />
<input type="hidden" name="sysCommUiNavigation" value="Trans S/O > Work Order" id="sysCommUiNavigation" />
</form>
