<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TRS_0230.jsp
*@FileTitle  : Agreement Surcharge Rate History Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/11
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%
	Exception					serverException		= null;			//Server Exception
	String						strErrMsg			= "";								 //Error Message
	String	userId		= "";
	String	ofcCd		= "";

	String optionStr    = "";
	String selTRANSMODE = "";	//Trans Mode Combo
	String selCARGOMODE = "";	//Cargo Type Combo
	String selRAILSVC   = "";	//Rail Service Combo
	String selTrspScgCd	= "";
	
	selTRANSMODE	= JSPUtil.getCodeCombo("ufm_agmt_trsp_tp_cd", "01"	,"style='width:98px;' disabled", "CD00283", 0, optionStr);
	selCARGOMODE	= JSPUtil.getCodeCombo("ufm_cgo_tp_cd",	"01"	,"style='width:98px;' disabled", "CD00748", 0, optionStr);
	selRAILSVC		= JSPUtil.getCodeCombo("ufm_rail_svc_tp_cd",		"01"	,"style='width:136px;' disabled", "CD00916", 1, optionStr);
	selTrspScgCd	= JSPUtil.getCodeCombo("fm_trsp_scg_cd", "01"	,"style='width:98px;'", "CD00917", 0, optionStr);

	String agmt_no            = ((request.getParameter("fm_agmtno")==null )?"":request.getParameter("fm_agmtno"));		
	String trsp_agmt_rt_tp_cd = ((request.getParameter("fm_trsp_agmt_rt_tp_cd")==null )?"":request.getParameter("fm_trsp_agmt_rt_tp_cd"));
	String eq_knd_cd        = ((request.getParameter("fm_eq_knd_cd")==null )?"":request.getParameter("fm_eq_knd_cd"));
	String trsp_cost_mod_cd = ((request.getParameter("chk_trsp_cost_mod_cd")==null)?"":request.getParameter("chk_trsp_cost_mod_cd"));
	String agmt_trsp_tp_cd  = ((request.getParameter("chk_agmt_trsp_tp_cd")==null)?"":request.getParameter("chk_agmt_trsp_tp_cd"));
	String cgo_tp_cd        = ((request.getParameter("chk_cgo_tp_cd")==null)?"":request.getParameter("chk_cgo_tp_cd"));
	String cust_cd          = ((request.getParameter("chk_cust_cd")==null)?"":request.getParameter("chk_cust_cd"));
	String cmdt_grp_cd      = ((request.getParameter("chk_cmdt_grp_cd")==null)?"":request.getParameter("chk_cmdt_grp_cd"));
	String rail_svc_tp_cd   = ((request.getParameter("chk_rail_svc_tp_cd")==null)?"":request.getParameter("chk_rail_svc_tp_cd"));
	String fm_nod_cd        = ((request.getParameter("chk_fm_nod_cd")==null)?"":request.getParameter("chk_fm_nod_cd"));
	String fm_nod_yd        = ((request.getParameter("chk_fm_nod_yd")==null)?"":request.getParameter("chk_fm_nod_yd"));
	String via_nod_cd       = ((request.getParameter("chk_via_nod_cd")==null)?"":request.getParameter("chk_via_nod_cd"));
	String via_nod_yd       = ((request.getParameter("chk_via_nod_yd")==null)?"":request.getParameter("chk_via_nod_yd"));
	String dor_nod_cd       = ((request.getParameter("chk_dor_nod_cd")==null)?"":request.getParameter("chk_dor_nod_cd"));
	String dor_nod_yd       = ((request.getParameter("chk_dor_nod_yd")==null)?"":request.getParameter("chk_dor_nod_yd"));
	String to_nod_cd        = ((request.getParameter("chk_to_nod_cd")==null)?"":request.getParameter("chk_to_nod_cd"));
	String to_nod_yd        = ((request.getParameter("chk_to_nod_yd")==null)?"":request.getParameter("chk_to_nod_yd"));
	String trsp_scg_cd      = ((request.getParameter("chk_trsp_scg_cd")==null)?"":request.getParameter("chk_trsp_scg_cd"));
	String agmt_route_all_flg   = ((request.getParameter("chk_agmt_route_all_flg")==null)?"":request.getParameter("chk_agmt_route_all_flg"));

	try {
		SignOnUserAccount account	= (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   	userId						= account.getUsr_id();
	   	ofcCd						= account.getOfc_cd();

		serverException				= (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<script type="text/javascript">
  var fm_nod_yd = "";
  function setupPage(){
    loadPage();
    
    var formObject = document.form;
    formObject.ufm_agmtno.value = "<%=agmt_no%>";
//    formObject.ufm_trsp_agmt_rt_tp_cd.value = "<%=trsp_agmt_rt_tp_cd%>";
    formObject.ufm_trsp_cost_mod_cd.value = "<%=trsp_cost_mod_cd%>";
    formObject.ufm_agmt_trsp_tp_cd.value = "<%=agmt_trsp_tp_cd%>";
    formObject.ufm_cgo_tp_cd.value = "<%=cgo_tp_cd%>";
    formObject.ufm_cust_cd.value = "<%=cust_cd%>";
    formObject.ufm_cmdt_grp_cd.value = "<%=cmdt_grp_cd%>";
    formObject.ufm_rail_svc_tp_cd.value = "<%=rail_svc_tp_cd%>";
    
    formObject.fm_eq_knd_cd.value = "<%=eq_knd_cd%>";
    formObject.fm_fm_nod_cd.value = "<%=fm_nod_cd%>";
    formObject.fm_via_nod_cd.value = "<%=via_nod_cd%>";
    formObject.fm_dor_nod_cd.value = "<%=dor_nod_cd%>";
    formObject.fm_to_nod_cd.value = "<%=to_nod_cd%>";
    formObject.fm_trsp_scg_cd.value = "<%=trsp_scg_cd%>";
    formObject.fm_agmt_route_all_flg.value = "<%=agmt_route_all_flg%>";

    getComboList(formObject.fm_fm_nod_cd, document.fm_fm_nod_yd, 'F');
    getComboList(formObject.fm_via_nod_cd, document.fm_via_nod_yd, 'V');
    getComboList(formObject.fm_dor_nod_cd, document.fm_dor_nod_yd, 'D');
    getComboList(formObject.fm_to_nod_cd, document.fm_to_nod_yd, 'T');
    formObject.fm_fm_nod_yd.CODE = "<%=fm_nod_yd%>";
    formObject.fm_via_nod_yd.CODE = "<%=via_nod_yd%>";
    formObject.fm_dor_nod_yd.CODE = "<%=dor_nod_yd%>";
    formObject.fm_to_nod_yd.CODE = "<%=to_nod_yd%>";
  }
  
</script>
<form name="form" >
<input type="hidden" name="fm_account_ofc_cd" value="<%=ofcCd%>" id="fm_account_ofc_cd" />
<input type="hidden" name="fm_account_usr_id" value="<%=userId%>" id="fm_account_usr_id" />
<input type="hidden" name="fm_agmtno" value="<%=agmt_no%>" id="fm_agmtno" />
<input type="hidden" name="fm_trsp_agmt_rt_tp_cd" value="P" id="fm_trsp_agmt_rt_tp_cd" />
<input type="hidden" name="fm_trsp_cost_mod_cd" value="<%=trsp_cost_mod_cd%>" id="fm_trsp_cost_mod_cd" />
<input type="hidden" name="fm_agmt_trsp_tp_cd" value="<%=agmt_trsp_tp_cd%>" id="fm_agmt_trsp_tp_cd" />
<input type="hidden" name="fm_cgo_tp_cd" value="<%=cgo_tp_cd%>" id="fm_cgo_tp_cd" />
<input type="hidden" name="fm_cust_cd" value="<%=cust_cd%>" id="fm_cust_cd" />
<input type="hidden" name="fm_cmdt_grp_cd" value="<%=cmdt_grp_cd%>" id="fm_cmdt_grp_cd" />
<input type="hidden" name="fm_rail_svc_tp_cd" value="<%=rail_svc_tp_cd%>" id="fm_rail_svc_tp_cd" />
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="TRSP_SO_EQ_KIND" value="" id="TRSP_SO_EQ_KIND" />
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><span>Agreement Surcharge Rate History Inquiry</span></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent"  type="button" id="btn_retrieve" name="btn_retrieve">Retrieve</button>
	</div>
	<!-- opus_design_btn (E) -->
</div>
<!-- page_title_area(E) -->
<div class="wrap_search" id="MiniLayer">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="90">
				<col width="100">
				<col width="110">
				<col width="120">
				<col width="140">
				<col width="*">
			</colgroup>
			<tbody>
				<tr>
                     <th>Agreement No.</th>
                     <td><input name="ufm_agmtno" type="text" style="width:98px;" readonly id="ufm_agmtno" /> </td>
                     <th>Cost Mode</th>
                     <td>
                       <select style="width:98px;" class="input" name="ufm_trsp_cost_mod_cd" id="ufm_trsp_cost_mod_cd" disabled>
                         <option value="DR">DR</option>
                         <option value="CY">CY</option>
                         <option value="BS">BS</option>
                         <option value="BF">BF</option>
                         <option value="MF">MF</option>
                       </select>
                     </td>  
                     <th>Trans Mode</th>
                     <td><%=selTRANSMODE%></td>
               </tr>
          	</tbody>
        </table>
        <table>
        	<colgroup>
				<col width="90">
				<col width="100">
				<col width="110">
				<col width="110">
				<col width="150">
				<col width="120">
				<col width="80">
				<col width="*">
			</colgroup>
			<tbody>
               <tr>
                 <th>Cargo Type</th>
                 <td><%=selCARGOMODE%></td>
                 <th>Customer Code</th>
                 <td><input name="ufm_cust_cd" type="text" style="width:98px;" disabled="" id="ufm_cust_cd" /> </td>
                 <th>Commodity Group Code</th>
                 <td><input name="ufm_cmdt_grp_cd" type="text" style="width:98px;" disabled="" id="ufm_cmdt_grp_cd" /> </td>
                 <th>Rail Service</th>
                 <td><%=selRAILSVC%></td>
               </tr>
            </tbody>
        </table>
        <table>
        	<colgroup>
				<col width="90">
				<col width="100">
				<col width="110">
				<col width="120">
				<col width="140">
				<col width="120">
				<col width="80">
				<col width="*">
			</colgroup>
			<tbody>
               <tr>
                 <th>From</th>
                 <td>
                    <input name="fm_fm_nod_cd" type="text" style="width:50px;" class="input" onchange="getComboList(this, fm_fm_nod_yd, 'F');" onblur="setgetUpper(this);" id="fm_fm_nod_cd" /><!-- 
                	 --><script type="text/javascript">ComComboObject('fm_fm_nod_yd', 1, 44, 0)</script>
                 </td>
                 <th>Via</th>
                 <td>
                    <input name="fm_via_nod_cd" type="text" style="width:50px;" maxlength="5" onchange="getComboList(this, fm_via_nod_yd, 'V');" onblur="setgetUpper(this);" id="fm_via_nod_cd" /><!-- 
                    --><script type="text/javascript">ComComboObject('fm_via_nod_yd', 1, 44, 0);</script>
                 </td>
                 <th>Door</th>
                 <td>       
                    <input name="fm_dor_nod_cd" type="text" style="width:50px;" maxlength="5" onchange="getComboList(this, fm_dor_nod_yd, 'D');" onblur="setgetUpper(this);" id="fm_dor_nod_cd" /><!-- 
                 	 --><script type="text/javascript">ComComboObject('fm_dor_nod_yd', 1, 44, 0)</script>
                 </td>
                 <th>To</th>
                 <td>
                    <input name="fm_to_nod_cd" type="text" style="width:50px;" maxlength="5" onchange="getComboList(this, fm_to_nod_yd, 'T');" onblur="setgetUpper(this);" id="fm_to_nod_cd" /><!--
                     --><script type="text/javascript">ComComboObject('fm_to_nod_yd', 1, 44, 0);</script>
                 </td>
               </tr>
           </tbody>
       </table>
       <table>
        	<colgroup>
				<col width="90">
				<col width="10">
				<col width="200">
				<col width="110">
				<col width="150">
				<col width="*">
			</colgroup>
			<tbody>
               <tr>
                 <th>Route All</th>
                 <td>
                   <input name="fm_agmt_route_all_flg" class="trans" type="checkbox" id="fm_agmt_route_all_flg" />
                 </td>  
                 <th>Surcharge</th>
                 <td>
                   <%=selTrspScgCd%>
                 </td>
                 <th>Equipment Type</th>
                 <td>
                   <select style="width:98px;" class="input" name="fm_eq_knd_cd" id="fm_eq_knd_cd" >
                     <option value=""></option>
                     <option value="U">Container</option>
                     <option value="Z">Chassis</option>
                     <option value="G">Genset</option>
                   </select>
                 </td>
               </tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>
<div class="wrap_result">
	<div class="opus_design_grid" id="mainTable">
		 <script type="text/javascript">ComSheetObject('sheet0');</script>
	</div>
</div>	
</form>