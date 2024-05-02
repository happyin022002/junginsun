<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : vop_scg_0012.jsp
*@FileTitle  : SPCL CGO Irregular List
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/01
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
<%@ page import="com.clt.apps.opus.vop.scg.vesseloperationirregularmgt.specialcargoirregularmgt.event.VopScg0012Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%@page import="java.util.List"%>
<%@page import="com.clt.syscommon.common.table.MdmVslSvcLaneVO"%>
<%@page import="com.clt.syscommon.common.table.MdmCarrierVO"%>
<%@page import="com.clt.syscommon.common.table.MdmVslCntrVO"%>
<%@page import="com.clt.syscommon.common.table.ScgImdgClssCdVO"%>
<%@page import="com.clt.syscommon.common.table.ScgImdgCompGrpVO"%>
<%@page import="com.clt.syscommon.common.table.ScgImdgUnNoVO"%>
<%@page import="com.clt.syscommon.common.table.MdmLocationVO"%>

<%
	VopScg0012Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String pImdg_un_no     = "";
	Logger log = Logger.getLogger("com.clt.apps.VesselOperationIrregularMgt.SpecialCargoIrregularMgt");

	//Combo String
	StringBuffer laneComboItem    = new StringBuffer();
	StringBuffer vslComboItem     = new StringBuffer();
	StringBuffer vslOprComboItem  = new StringBuffer();
	StringBuffer cgoOprComboItem  = new StringBuffer();
	StringBuffer classComboItem   = new StringBuffer();
	StringBuffer clsCompComboItem = new StringBuffer();
	StringBuffer unNoComboItem    = new StringBuffer();
	StringBuffer porComboItem     = new StringBuffer();
	StringBuffer polComboItem     = new StringBuffer();
	StringBuffer podComboItem     = new StringBuffer();
	StringBuffer delComboItem     = new StringBuffer();

	//Pre Condition
	String pop_mode     = "";
	String imdg_un_no   = "";
	String imdg_clss_cd = "";
	String pol_cd       = "";
	String pod_cd       = "";
	String slan_cd      = "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (VopScg0012Event)request.getAttribute("Event");
		pImdg_un_no = event.getAttribute("pImdg_un_no")==null?"":(String)event.getAttribute("pImdg_un_no");		
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// add logic data extracting from server when loading initial screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		//0. Lane Combo
		List<MdmVslSvcLaneVO> laneCombo = (List<MdmVslSvcLaneVO>)eventResponse.getCustomData("laneCombo");
		if (laneCombo.size() > 0) {
        	int dataCount = laneCombo.size();
        	MdmVslSvcLaneVO[] vos = new MdmVslSvcLaneVO[dataCount];
        	laneCombo.toArray(vos);

        	for (int i = 0; i < dataCount; i++) {
        		if (i != 0) {
        			laneComboItem.append("|");
        		}
        		laneComboItem.append(vos[i].getVslSlanCd());
        	}
		}

		//1. Vessel Combo
		List<MdmVslCntrVO> vslCombo = (List<MdmVslCntrVO>)eventResponse.getCustomData("vslCombo");
		if (vslCombo.size() > 0) {
        	int dataCount = vslCombo.size();
        	MdmVslCntrVO[] vos = new MdmVslCntrVO[dataCount];
        	vslCombo.toArray(vos);

        	for (int i = 0; i < dataCount; i++) {
        		if (i != 0) {
        			vslComboItem.append("|");
        		}
        		vslComboItem.append(vos[i].getVslCd());
        	}
		}

		//2. VSL OPR Combo
		List<MdmCarrierVO> vslOprCombo = (List<MdmCarrierVO>)eventResponse.getCustomData("vslOprCombo");
		if (vslOprCombo.size() > 0) {
        	int dataCount = vslOprCombo.size();
        	MdmCarrierVO[] vos = new MdmCarrierVO[dataCount];
        	vslOprCombo.toArray(vos);

        	for (int i = 0; i < dataCount; i++) {
        		if (i != 0) {
        			vslOprComboItem.append("|");
        		}
        		vslOprComboItem.append(vos[i].getCrrCd());
        	}
		}

		//3. CGO OPR Combo
		List<MdmCarrierVO> cgoOprCombo = (List<MdmCarrierVO>)eventResponse.getCustomData("cgoOprCombo");
		if (cgoOprCombo.size() > 0) {
        	int dataCount = cgoOprCombo.size();
        	MdmCarrierVO[] vos = new MdmCarrierVO[dataCount];
        	cgoOprCombo.toArray(vos);

        	for (int i = 0; i < dataCount; i++) {
        		if (i != 0) {
        			cgoOprComboItem.append("|");
        		}
        		cgoOprComboItem.append(vos[i].getCrrCd());
        	}
		}

		//4. Class Combo
		List<ScgImdgClssCdVO> classCombo = (List<ScgImdgClssCdVO>)eventResponse.getCustomData("classCombo");
		if (classCombo.size() > 0) {
        	int dataCount = classCombo.size();
        	ScgImdgClssCdVO[] vos = new ScgImdgClssCdVO[dataCount];
        	classCombo.toArray(vos);

        	for (int i = 0; i < dataCount; i++) {
        		if (i != 0) {
        			classComboItem.append("|");
        		}
        		classComboItem.append(vos[i].getImdgClssCd());
        	}
		}

		//5. Class Comp Combo
		List<ScgImdgCompGrpVO> clsCompCombo = (List<ScgImdgCompGrpVO>)eventResponse.getCustomData("clsCompCombo");
		if (clsCompCombo.size() > 0) {
        	int dataCount = clsCompCombo.size();
        	ScgImdgCompGrpVO[] vos = new ScgImdgCompGrpVO[dataCount];
        	clsCompCombo.toArray(vos);

        	for (int i = 0; i < dataCount; i++) {
        		if (i != 0) {
        			clsCompComboItem.append("|");
        		}
        		clsCompComboItem.append(vos[i].getImdgCompGrpCd());
        	}
		}

		//6. UN No. Combo
		List<ScgImdgUnNoVO> unNoCombo = (List<ScgImdgUnNoVO>)eventResponse.getCustomData("unNoCombo");
		if (unNoCombo.size() > 0) {
        	int dataCount = unNoCombo.size();
        	ScgImdgUnNoVO[] vos = new ScgImdgUnNoVO[dataCount];
        	unNoCombo.toArray(vos);

        	for (int i = 0; i < dataCount; i++) {
        		if (i != 0) {
        			unNoComboItem.append("|");
        		}
        		unNoComboItem.append(vos[i].getImdgUnNo());
        	}
		}

		//7. POR Combo
		List<MdmLocationVO> porCombo = (List<MdmLocationVO>)eventResponse.getCustomData("porCombo");
		if (porCombo.size() > 0) {
        	int dataCount = porCombo.size();
        	MdmLocationVO[] vos = new MdmLocationVO[dataCount];
        	porCombo.toArray(vos);

        	for (int i = 0; i < dataCount; i++) {
        		if (i != 0) {
        			porComboItem.append("|");
        		}
        		porComboItem.append(vos[i].getLocCd());
        	}
		}

		//8. POL Combo
		List<MdmLocationVO> polCombo = (List<MdmLocationVO>)eventResponse.getCustomData("polCombo");
		if (polCombo.size() > 0) {
        	int dataCount = polCombo.size();
        	MdmLocationVO[] vos = new MdmLocationVO[dataCount];
        	polCombo.toArray(vos);

        	for (int i = 0; i < dataCount; i++) {
        		if (i != 0) {
        			polComboItem.append("|");
        		}
        		polComboItem.append(vos[i].getLocCd());
        	}
		}

		//9. POD Combo
		List<MdmLocationVO> podCombo = (List<MdmLocationVO>)eventResponse.getCustomData("podCombo");
		if (podCombo.size() > 0) {
        	int dataCount = podCombo.size();
        	MdmLocationVO[] vos = new MdmLocationVO[dataCount];
        	podCombo.toArray(vos);

        	for (int i = 0; i < dataCount; i++) {
        		if (i != 0) {
        			podComboItem.append("|");
        		}
        		podComboItem.append(vos[i].getLocCd());
        	}
		}

		//10. DEL Combo
		List<MdmLocationVO> delCombo = (List<MdmLocationVO>)eventResponse.getCustomData("delCombo");
		if (delCombo.size() > 0) {
        	int dataCount = delCombo.size();
        	MdmLocationVO[] vos = new MdmLocationVO[dataCount];
        	delCombo.toArray(vos);

        	for (int i = 0; i < dataCount; i++) {
        		if (i != 0) {
        			delComboItem.append("|");
        		}
        		delComboItem.append(vos[i].getLocCd());
        	}
		}

		//Pre Condition
		pop_mode     = request.getParameter("pop_mode")==null?"N":request.getParameter("pop_mode");
		imdg_un_no   = request.getParameter("imdg_un_no")==null?"":request.getParameter("imdg_un_no");
		imdg_clss_cd = request.getParameter("imdg_clss_cd")==null?"":request.getParameter("imdg_clss_cd");
		pol_cd       = request.getParameter("pol_cd")==null?"":request.getParameter("pol_cd");
		pod_cd       = request.getParameter("pod_cd")==null?"":request.getParameter("pod_cd");
		slan_cd      = request.getParameter("slan_cd")==null?"":request.getParameter("slan_cd");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>


<script type="text/javascript">
	//Pre Condition
	var preConds = {
		pop_mode       : "<%=StringUtil.xssFilter(pop_mode)%>",
		imdg_un_no     : "<%=StringUtil.xssFilter(imdg_un_no)%>",
		imdg_clss_cd   : "<%=StringUtil.xssFilter(imdg_clss_cd)%>",
		pol_cd         : "<%=StringUtil.xssFilter(pol_cd)%>",
		pod_cd         : "<%=StringUtil.xssFilter(pod_cd)%>",
		slan_cd        : "<%=StringUtil.xssFilter(slan_cd)%>"
	}

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if

		var comboItems = new Array();

		comboItems[0] = "<%=laneComboItem.toString()%>";    
		comboItems[1] = "<%=vslComboItem.toString()%>";    
		comboItems[2] = "<%=vslOprComboItem.toString()%>"; 
		comboItems[3] = "<%=cgoOprComboItem.toString()%>"; 
		comboItems[4] = "<%=classComboItem.toString()%>";  
		comboItems[5] = "<%=clsCompComboItem.toString()%>";                      
		comboItems[6] = "<%=unNoComboItem.toString()%>";                         
		comboItems[7] = "<%=porComboItem.toString()%>";                          
		comboItems[8] = "<%=polComboItem.toString()%>";                          
		comboItems[9] = "<%=podComboItem.toString()%>";                          
		comboItems[10] = "<%=delComboItem.toString()%>";  

		if( form.pImdg_un_no.value != ""){
		    ComScgMainToMakePopup();
		}

		loadPage(comboItems);
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="pImdg_un_no" value="<%=pImdg_un_no %>" id="pImdg_un_no" />

<% if (pop_mode.equals("Y")) { %>
<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>SPCL CGO Irregular List</span></h2>
		
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_Retrieve" 	id="btn_Retrieve">Retrieve</button><!--
		--><button type="button" class="btn_normal" name="btn_New" 		id="btn_New">New</button><!--
		--><button type="button" class="btn_normal" name="btn_DownExcel" id="btn_DownExcel">Down&nbsp;Excel</button><!-- 	
		--><button type="button"  class="btn_normal" name="btn_Close" id="btn_Close">Close</button>
		</div>
	</div>
</div>
<% }else{%>
<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_Retrieve" 	id="btn_Retrieve">Retrieve</button><!--
		--><button type="button" class="btn_normal" name="btn_New" 		id="btn_New">New</button><!--
		--><button type="button" class="btn_normal" name="btn_DownExcel" id="btn_DownExcel">Down Excel</button>
	</div>
	<!-- opus_design_btn (E) -->

	<!-- page_location(S) -->
	<div class="location">	
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
<% }%>	

<% if (pop_mode.equals("Y")) { %><div class="layer_popup_contents"><%}%>
<!-- opus_design_inquiry(S) -->
<div class= "wrap_search">
	<div class= "opus_design_inquiry wFit">
		<table>
			<tbody>
				<tr>
					<th>Option</th>
					<td colspan="11"><input name="irr_spcl_cgo_cate_cd" id="irr_spcl_cgo_cate_cd_all" type="radio" value="" checked=""><label for="irr_spcl_cgo_cate_cd_all">All</label><!-- 
					 --><input name="irr_spcl_cgo_cate_cd" id="irr_spcl_cgo_cate_cd_dg" type="radio" value="DG"><label for="irr_spcl_cgo_cate_cd_dg">Dangerous Goods</label><!-- 
					 --><input name="irr_spcl_cgo_cate_cd" id="irr_spcl_cgo_cate_cd_ac" type="radio" value="AC"><label for="irr_spcl_cgo_cate_cd_ac">Awkward Cargo</label>
					</td> 
				</tr>
				<tr>
					<th width="90">Period</th>
					<td width="60" colspan="3">
						<input name="irr_occr_from_dt" required="" type="text" style="width:80px;" class="input1" dataformat="ymd" caption="Period" maxlength="8" size="10" value="2014-01-01" id="irr_occr_from_dt" /><!-- 
						 -->~&nbsp;<!-- 
						 --><input name="irr_occr_to_dt" required="" type="text" style="width:80px;" class="input1" dataformat="ymd" caption="Period" maxlength="8" size="10" value="<%=DateTime.getFormatDate(new java.util.Date(),"yyyyMMdd") %>" id="irr_occr_to_dt" />
						<button type="button" id="btn_calendar" name="btn_calendar" class="calendar ir"></button>
					</td>
					<th width="50">Lane</th>
					<td width="60">
						<script type="text/javascript">ComComboObject('vsl_slan_cd', 1, 104, 0, 0, 0, false);</script>
					</td>
					<th width="70">Vessel</th>
					<td width="80">
						<script type="text/javascript">ComComboObject('vsl_cd', 1, 60, 0, 0, 0, false);</script>
					</td>
					<th width="70">VSL OPR</th>
					<td width="150">
						<script type="text/javascript">ComComboObject('vsl_opr_tp_cd', 1, 60, 0, 0, 0, false);</script>
					</td>
					<th width="50">CGO OPR</th>
					<td>
						<script type="text/javascript">ComComboObject('cgo_opr_cd', 1, 60, 0, 0, 0, false);</script>
					</td>
				</tr>
				<tr>
					<th>Irregulars Type</th>
					<td colspan="3">
						<script type="text/javascript">ComComboObject('com_spcl_cgo_irr_tp_cd', 3, 204, 0, 0, 0, false);</script>
					</td>
					<th>Class</th>
					<td>
						<script type="text/javascript">ComComboObject('imdg_clss_cd', 1, 60, 0, 0, 0, false);</script><!--
						--><script type="text/javascript">ComComboObject('imdg_comp_grp_cd', 1, 40, 0, 0, 0, false);</script>
					</td>
					<th>UN No.</th>
					<td>
						<script type="text/javascript">ComComboObject('imdg_un_no', 1, 60, 0, 0, 0, false);</script>
					</td>
					<th>AWK Type</th>
					<td colspan="3">
						<script type="text/javascript">ComComboObject('cnt_spcl_cgo_cate_cd', 1, 60, 0, 0, 0, false);</script>
					</td>
				</tr>
				<tr>
					<th title="Place of Receipt">POR</th>
					<td width="90">
						<script type="text/javascript">ComComboObject('por_cd', 1, 80, 0, 0, 0, false);</script>
					</td>
					<th title="Port of Loading">POL</th>
					<td width="10">
						<script type="text/javascript">ComComboObject('pol_cd', 1, 76, 0, 0, 0, false);</script>
					</td>
					<th title="Port of Discharging">POD</th>
					<td>
						<script type="text/javascript">ComComboObject('pod_cd', 1, 70, 0, 0, 0, false);</script>
					</td>
					<th>Delivery</th>
					<td>
						<script type="text/javascript">ComComboObject('del_cd', 1, 70, 0, 0, 0, false);</script>
					</td>
					<th>SHPR</th>
					<td><input name="s_cust_nm" type="text" style="width:140px;" class="input" value="" id="s_cust_nm" /> </td>
					<th>CNEE</th>
					<td><input name="c_cust_nm" type="text" style="width:140px;" class="input" value="" id="c_cust_nm" /> </td>
				</tr>
			</tbody>	
		</table>
	</div>
</div>
<!-- opus_design_inquiry(E) -->
<!-- opus_design_grid(S) -->
<div class="wrap_result">
	<div class="opus_design_grid clear" id="mainTable" >
			<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>
<!-- opus_design_grid(E) -->
<% if (pop_mode.equals("Y")) { %></div><%}%>
</form>
