<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_SCG_0021.jsp
*@FileTitle  : Restrictions
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/11
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
<%@ page import="com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.event.VopScg0021Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopScg0021Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.CargoLoadingApproval.OwnDangerousCargoApproval");
	
	String imdg_un_no     = "";
	String imdg_un_no_seq = "";
	String imdg_clss_cd   = "";
	String pol_port_cd    = "";
	String pod_port_cd    = "";
	String slan_cd        = "";
	
	String bkg_no        = "";
	String vsl_cd        = "";
	String skd_voy_no    = "";
	String skd_dir_cd    = "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (VopScg0021Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// add logic data extracting from server when loading initial screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		imdg_un_no     = request.getParameter("imdg_un_no")==null?"":request.getParameter("imdg_un_no");
		imdg_un_no_seq = request.getParameter("imdg_un_no_seq")==null?"":request.getParameter("imdg_un_no_seq");
		imdg_clss_cd   = request.getParameter("imdg_clss_cd")==null?"":request.getParameter("imdg_clss_cd");
		pol_port_cd    = request.getParameter("pol_cd")==null?"":request.getParameter("pol_cd");
		pod_port_cd    = request.getParameter("pod_cd")==null?"":request.getParameter("pod_cd");
		slan_cd        = request.getParameter("slan_cd")==null?"":request.getParameter("slan_cd");
		
		bkg_no         = request.getParameter("bkg_ref_no")==null?(request.getParameter("bkg_no")==null?"":request.getParameter("bkg_no")):request.getParameter("bkg_ref_no");
		vsl_cd         = request.getParameter("vsl_cd")==null?"":request.getParameter("vsl_cd");
		skd_voy_no     = request.getParameter("skd_voy_no")==null?"":request.getParameter("skd_voy_no");
		skd_dir_cd     = request.getParameter("skd_dir_cd")==null?"":request.getParameter("skd_dir_cd");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<script language="javascript">
	//초기조회조건
	var preConds = {
		imdg_un_no         : "<%=StringUtil.xssFilter(imdg_un_no)%>",
		imdg_un_no_seq     : "<%=StringUtil.xssFilter(imdg_un_no_seq)%>",
		imdg_clss_cd       : "<%=StringUtil.xssFilter(imdg_clss_cd)%>",
		pol_port_cd        : "<%=StringUtil.xssFilter(pol_port_cd)%>",
		pod_port_cd        : "<%=StringUtil.xssFilter(pod_port_cd)%>",
		slan_cd            : "<%=StringUtil.xssFilter(slan_cd)%>",
		bkg_no             : "<%=StringUtil.xssFilter(bkg_no)%>",
		vsl_cd             : "<%=StringUtil.xssFilter(vsl_cd)%>",
		skd_voy_no         : "<%=StringUtil.xssFilter(skd_voy_no)%>",
		skd_dir_cd         : "<%=StringUtil.xssFilter(skd_dir_cd)%>"
	}

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
<input type="hidden" name="pagerows">

<input type="hidden" name="bkg_no" id="bkg_no">
<input type="hidden" name="vsl_cd" id="vsl_cd">
<input type="hidden" name="skd_voy_no" id="skd_voy_no">
<input type="hidden" name="skd_dir_cd" id="skd_dir_cd">

<input type="hidden" name="pol_port_cd" id="pol_port_cd">
<input type="hidden" name="pod_port_cd" id="pod_port_cd">
<input type="hidden" name="slan_cd" id="slan_cd">

<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>Restrictions</span></h2>
		
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--
			--><button type="button" class="btn_normal" name="btn_New" id="btn_New">New</button><!--
			--><button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button>
		</div>
	</div>
</div>

<div class="layer_popup_contents">
	<div class="wrap_search">
		<div class="opus_design_inquiry wFit">
			<table> 
				<tbody>
					 <tr>
	                    <th width="80">UN No./Seq.</th>
		                    <td><input type="text" style="width:60px;" id ="imdg_un_no" name="imdg_un_no" fullfill required class="input1" maxlength='4' style="ime-mode:disabled" caption='UN No.' value="" dataformat="num"><!-- 
		                     --><input type="text" style="width:50px;"  id ="imdg_un_no_seq" name="imdg_un_no_seq" class="input1" caption='UN No./Seq.' maxlength='4' minlength='1' required value="" dataformat="num"><!-- 
		                     --><button type="button" class="input_seach_btn" id="srch_imdg_un_no" name="srch_imdg_un_no" ></button><!-- 
		                     --><input type="text" style="width:750px;" readonly class="input2" id="prp_shp_nm" name="prp_shp_nm" value="">
		                   </td>
	                </tr>
	                <tr>
	                    <th>Class</th>
	                    <td>
	                    	<input type="text" style="width:60px;" class="input2"  readonly name="imdg_clss_cd" value=""><!-- 
	                     --><input type="text" style="width:833px;" class="input2"  name="imdg_clss_cd_desc"  readonly value="">
	                    </td>
	                </tr>
				</tbody>
			</table>
		</div>
	</div>

	<div class="wrap_result">
		<div class="opus_design_grid">
			<h3 class="title_design grid_heading_clear">Vessel Operator’s Restrictions on Class/UN No.</h3>
			<script language="javascript">ComSheetObject('sheet1');</script>
		</div>
		
		<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
		
		<div class="grid_option_left">
			<table>
				<tr>
					<td>
						<button type="button" class="btn_etc" name="srch_irregulars_list" id="srch_irregulars_list">Irregulars List</button>
					</td>
				</tr>
			</table>
		</div>

		<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
		
		<div class="opus_design_grid">
			<h3 class="title_design">Port Restrictions En-route</h3>
			<script language="javascript">ComSheetObject('sheet2');</script>
		</div>
	</div>
</div>
<!-- popup_contens_area(E) -->

</form>