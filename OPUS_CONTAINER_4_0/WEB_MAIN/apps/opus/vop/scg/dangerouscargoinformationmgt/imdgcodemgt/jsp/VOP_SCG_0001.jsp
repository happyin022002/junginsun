<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_SCG_0001.jsp
*@FileTitle  : UN Number (Creation)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/23
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
<%@ page import="com.clt.apps.opus.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.event.VopScg0001Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopScg0001Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg 	= "";						//error message
	int rowCount	 	= 0;						//count of DB resultSET list
	
	String successFlag 	= "";
	String codeList  	= "";
	String pageRows  	= "100";
	String strUsr_id	= "";
	String strUsr_nm	= "";
	String pop_yn       = "";
	String imdg_un_no   = "";
	String imdg_un_no_seq  = "";
	
	String cfr_flg      = "";	//2014-12-05 HDS
	
	Logger log = Logger.getLogger("com.clt.apps.DangerousCargoInformationMgt.IMDGCodeMgt");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
		event = (VopScg0001Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// add logic data extracting from server when loading initial screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		pop_yn      = request.getParameter("pop_mode")==null?"N":"Y";
		imdg_un_no  = request.getParameter("imdg_un_no")==null?"":request.getParameter("imdg_un_no");		
		imdg_un_no_seq = request.getParameter("imdg_un_no_seq")==null?"0":request.getParameter("imdg_un_no_seq");
		
// 		cfr_flg		= "Y".equals(request.getParameter("cfr_flg"))?"T":"F";	//2014-12-05 HDS
		
// 		if("F".equals(cfr_flg)){
// 			int seq = Integer.parseInt(imdg_un_no_seq);
// 			if(seq >= 490 && seq < 500){
// 				cfr_flg		= "T";
// 			}else{
// 				cfr_flg		= "F";
// 			}
// 		}
		
		if("Y".equals(request.getParameter("cfr_flg")) || "T".equals(request.getParameter("cfr_flg"))){
			cfr_flg = "T";
		}else{
			int seq = Integer.parseInt(imdg_un_no_seq);
			if(seq >= 490){
				cfr_flg		= "T";
			}else{
				cfr_flg		= "F";
			}
		}
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<script type="text/javascript">
	//call popup and initial retrieve condition
	var preConds = {
		pop_yn       : "<%=StringUtil.xssFilter(pop_yn)%>",
		imdg_un_no   : "<%=StringUtil.xssFilter(imdg_un_no)%>",
		imdg_un_no_seq  : "<%=StringUtil.xssFilter(imdg_un_no_seq)%>",
		cfr_flg		 : "<%=StringUtil.xssFilter(cfr_flg)%>"
	}
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<% if (pop_yn=="Y") { %>
<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>UN Number</span></h2>
		
		<div class="opus_design_btn">
			<button class="btn_accent" name="btn_Retrieve" id="btn_Retrieve" type="button">Retrieve</button><!--
		--><button class="btn_normal" name="btn_New" id="btn_New" type="button">New</button><!--
		--><button class="btn_normal" name="btn_Copy" id="btn_Copy" type="button">Copy</button><!--
		--><button class="btn_normal" name="btn_Delete" id="btn_Delete" type="button">Delete</button><!--
		--><button class="btn_normal" name="btn_Save" id="btn_Save" type="button">Save</button><!--
		--><button class="btn_normal" name="btn_Close" id="btn_Close" type="button">Close</button>
		</div>
	</div>
</div>
<% }else{%>
<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_Retrieve" id="btn_Retrieve" type="button">Retrieve</button><!--
		--><button class="btn_normal" name="btn_New" id="btn_New" type="button">New</button><!--
		--><button class="btn_normal" name="btn_Copy" id="btn_Copy" type="button">Copy</button><!--
		--><button class="btn_normal" name="btn_Delete" id="btn_Delete" type="button">Delete</button><!--
		--><button class="btn_normal" name="btn_Save" id="btn_Save" type="button">Save</button>
	</div>
	<!-- opus_design_btn (E) -->

	<!-- page_location(S) -->
	<div class="location">	
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
<% }%>	
</div>

<% if (pop_yn=="Y") { %><div class="layer_popup_contents"><%}%>
<!-- page_title_area(E) -->
<div class="wrap_search_tab">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry">
		<table>
			<colgroup>
				<col width="150"/>
				<col width="70"/>
    			<col width="50"/>
				<col width="70"/>
				<col width="30"/>
				<col width="50"/>
				<col width="100"/>
				<col width="50"/>
				<col width="99"/>
				<col width="50"/>
				<col width="70"/>
				<col width="50"/>
				<col width="*"/>
			</colgroup> 
			<tr>
				<th>Amdt No.</th>
				<td><script>ComComboObject('imdg_amdt_no', 2, 60, 1, 1);</script>
				    <input type="hidden" name="crte_imdg_un_no" id="crte_imdg_un_no" /></td>
				<th>(1) UN No.</th>
				<td><input type="text" name="imdg_un_no" caption="UN No." maxlength="4" style="width:50px;ime-mode:disabled;" class="input1" value="" id="imdg_un_no" /></td>
				<td><input type="checkbox" name="cfr_flg" caption="CFR flag" style="width:20px;ime-mode:disabled;" class="input1" id="cfr_flg" /><b>CFR</b></td><!-- value="T"  -->
				<th>Seq.</th>
				<td><input type="text" name="imdg_un_no_seq" caption="Seq." readonly style="width:40px;text-align:center;" class="input1" value="" id="imdg_un_no_seq" /><button type="button" class="btn_left" name="btn_SeqPrev" id="btn_SeqPrev" ></button><button type="button" class="btn_right" name="btn_SeqNext" id="btn_SeqNext"></button>
				<th>Max.</th>
				<td><input type="text" name="imdg_un_no_seq_max" caption="Max." readonly style="width:40px;text-align:center;" class="input2" value="" id="imdg_un_no_seq_max" /></td>
				<th>Min.</th>
				<td><input type="text" name="imdg_un_no_seq_min" caption="Min." readonly style="width:40px;text-align:center;" class="input2" value="" id="imdg_un_no_seq_min" /></td>
				<th>Total Data Count</th>
				<td><input type="text" name="imdg_un_no_seq_cnt" caption="Total Date Count" readonly style="width:40px;text-align:center;" class="input2" value="" id="imdg_un_no_seq_cnt" /></td>
			</tr>			
		</table>
		<table>
			<colgroup>
				<col width="150"/>
				<col width="120"/>
				<col width="270"/>	<!-- 485 -->			
				<col width="50"/>				
				<col width="*"/>				
			</colgroup> 			
			<tr>
				<th>Own Restrictions</th>
				<td><input type="text" name="frm_imdg_crr_rstr_expt_nm" style="width:259px;" readonly class="input2" value="" id="frm_imdg_crr_rstr_expt_nm" /></td>
				<td></td>
				<th>Update By</th>
				<td><input type="text" name="frm_upd_usr_id" style="width:100px;" class="input2" readonly value="" id="frm_upd_usr_id" /><input type="text" name="frm_upd_dt" style="width:110px;" readonly class="input2" value="" id="frm_upd_dt" /></td>
			</tr>
		</table>
		<table><tr><td colspan="15" class="line_bluedot"></td></tr></table>
		<table>
			<colgroup>
				<col width="150"/>								
				<col width="*"/>				
			</colgroup>		
			<tr>
				<th>(2) Proper Shipping Name</th>
				<td><input type="text" name="frm_prp_shp_nm" id="frm_prp_shp_nm" style="width:810px;ime-mode:disabled;" class="input1" value="" /> </td>
			</tr>
			<tr>
				<th>Variation Remarks</th>
				<td><input type="text" name="frm_prp_shp_nm_var_rmk" id="frm_prp_shp_nm_var_rmk" style="width:810px;ime-mode:disabled;" class="input" value="" maxlength="1000"/> </td>
			</tr>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">

	<!-- opus_tab_btn(S) -->
	<div class="opus_design_tab">
		<script type="text/javascript">ComTabObject('tab1')</script>
	</div>
	<!-- opus_tab_btn(E) -->
	

						
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid"  name="tabLayer" id="tabLayer" style="display:none;">
		<div class="opus_design_inquiry wFit">
			<table> 
				<colgroup>
					<col width="200"/>								
					<col width="200"/>								
					<col width="150"/>								
					<col width="400"/>								
					<col width="150"/>								
					<col width="*"/>				
				</colgroup>	
				<tr>
					<th>(3) Class or Division</th>
					<td><!-- 
						 --><script type="text/javascript">ComComboObject('frm_imdg_clss_cd', 2, 50, 1, 1);</script><!-- 
						 --><script type="text/javascript">ComComboObject('frm_imdg_comp_grp_cd', 1, 40, 1);</script><!-- 
					 --></td>
					<th>(4) Subsidiary risk(s)</th>
					<td><!-- 
						 --><script type="text/javascript">ComComboObject('frm_imdg_subs_rsk_lbl_cd1', 1, 50, 0);</script><!-- 
						 --><script type="text/javascript">ComComboObject('frm_imdg_subs_rsk_lbl_cd2', 1, 50, 0);</script><!-- 
						 --><script type="text/javascript">ComComboObject('frm_imdg_subs_rsk_lbl_cd3', 1, 50, 0);</script><!-- 
						 --><script type="text/javascript">ComComboObject('frm_imdg_subs_rsk_lbl_cd4', 1, 50, 0);</script><!-- 
					 --></td>
					<th>(4) Marine pollutant</th>
					<td>
						<script type="text/javascript">ComComboObject('frm_imdg_mrn_polut_cd', 1, 60, 0, 0, 0, false, '', true);</script>
					</td> 
				</tr>
			</table>
			<table>	
				<colgroup>
					<col width="400"/>											
					<col width="150"/>								
					<col width="*"/>				
				</colgroup>			
				<tr>
					<td></td>
					<th>SRL Remark(s)</th>
					<td>
						<input type="text" name="frm_imdg_subs_rsk_lbl_rmk" maxlength="4000" style="width:472px;ime-mode:disabled;" class="input" value="" id="frm_imdg_subs_rsk_lbl_rmk" />
					</td>
				</tr>
			</table>
			<table>	
				<colgroup>
					<col width="200"/>											
					<col width="200"/>											
					<col width="150"/>								
					<col width="*"/>				
				</colgroup>	
				<tr>
					<th>(5) Packing group</th>
					<td>
						<script type="text/javascript">ComComboObject('frm_imdg_pck_grp_cd', 1, 60, 0, 0, 0, false, '', true);</script>
					</td>
					<th>(6) Special Provisions</th>
					<td><!-- 
						 --><input type="text" name="frm_imdg_spcl_provi_no1" id="frm_imdg_spcl_provi_no1" caption="Special Provisions 1" dataformat="num" maxlength="3" style="width:33px;text-align:right;ime-mode:disabled;" class="input" value="" /><!--
						--><button type="button" id="btn_imdg_spcl_provi_no1" name="btn_imdg_spcl_provi_no1" class="input_seach_btn"></button><!--
						--><input type="text" name="frm_imdg_spcl_provi_no2" id="frm_imdg_spcl_provi_no2" caption="Special Provisions 2" dataformat="num" maxlength="3" style="width:33px;text-align:right;ime-mode:disabled;" class="input" value="" /><!--
						--><button type="button" id="btn_imdg_spcl_provi_no2" name="btn_imdg_spcl_provi_no2" class="input_seach_btn"></button><!--
						--><input type="text" name="frm_imdg_spcl_provi_no3" id="frm_imdg_spcl_provi_no3" caption="Special Provisions 3" dataformat="num" maxlength="3" style="width:33px;text-align:right;ime-mode:disabled;" class="input" value="" /><!--
						--><button type="button" id="btn_imdg_spcl_provi_no3" name="btn_imdg_spcl_provi_no3" class="input_seach_btn"></button><!--
						--><input type="text" name="frm_imdg_spcl_provi_no4" id="frm_imdg_spcl_provi_no4" caption="Special Provisions 4" dataformat="num" maxlength="3" style="width:30px;text-align:right;ime-mode:disabled;" class="input" value="" /><!--
						--><button type="button" id="btn_imdg_spcl_provi_no4" name="btn_imdg_spcl_provi_no4" class="input_seach_btn"></button><!--
						--><input type="text" name="frm_imdg_spcl_provi_no5" id="frm_imdg_spcl_provi_no5" caption="Special Provisions 5" dataformat="num" maxlength="3" style="width:40px;text-align:right;ime-mode:disabled;" class="input" value="" /><!--
						--><button type="button" id="btn_imdg_spcl_provi_no5" name="btn_imdg_spcl_provi_no5" class="input_seach_btn"></button><!--
						--><input type="text" name="frm_imdg_spcl_provi_no6" id="frm_imdg_spcl_provi_no6" caption="Special Provisions 6" dataformat="num" maxlength="3" style="width:30px;text-align:right;ime-mode:disabled;" class="input" value="" /><!--
						--><button type="button" id="btn_imdg_spcl_provi_no6" name="btn_imdg_spcl_provi_no6" class="input_seach_btn"></button><!--
						--><input type="text" name="frm_imdg_spcl_provi_no7" id="frm_imdg_spcl_provi_no7" caption="Special Provisions 7" dataformat="num" maxlength="3" style="width:30px;text-align:right;ime-mode:disabled;" class="input" value="" /><!--
						--><button type="button" id="btn_imdg_spcl_provi_no7" name="btn_imdg_spcl_provi_no7" class="input_seach_btn"></button><!--
						--><input type="text" name="frm_imdg_spcl_provi_no8" id="frm_imdg_spcl_provi_no8" caption="Special Provisions 8" dataformat="num" maxlength="3" style="width:30px;text-align:right;ime-mode:disabled;" class="input" value="" /><!--
						--><button type="button" id="btn_imdg_spcl_provi_no8" name="btn_imdg_spcl_provi_no8" class="input_seach_btn"></button><!-- 
					 --></td>
				</tr>
			</table>
			<table>	
				<colgroup>
					<col width="200"/>											
					<col width="200"/>											
					<col width="150"/>											
					<col width="290"/>											
					<col width="150"/>								
					<col width="*"/>				
				</colgroup>
				<tr>				
					<th>(7a) Limited Q'ty</th>
					<td><!-- 
						 --><input type="text" name="frm_imdg_lmt_qty" caption="Limited Q'ty" maxlength="4" style="width:50px;text-align:center;ime-mode:disabled;" class="input" value="" id="frm_imdg_lmt_qty" /><!-- 
						 --><select name="frm_imdg_lmt_qty_meas_ut_cd" style="width:65px;"><!-- 
							 --><option value=""></option><!-- 
							 --><option value="Ml">ml</option><!-- 
							 --><option value="L">l</option><!-- 
							 --><option value="G">g</option><!--
							--><option value="KG">kg</option><!--
							--><option value="ML">ml or g</option><!--
							--><option value="LKG">l or kg</option><!--
						--></select><!-- 
						 --><input type="text" name="frm_imdg_lmt_qty_desc" caption="Limited Q'ty Desc" maxlength="20" style="width:50px;ime-mode:disabled;" class="input" value="" id="frm_imdg_lmt_qty_desc" /><!-- 
					 --></td>
					<th>(7b) Excepted Q'ty</th>
					<td>
						<script type="text/javascript">ComComboObject('frm_imdg_expt_qty_cd', 1, 60, 0);</script>
						<input type="text" name="frm_imdg_expt_qty_desc" caption="Excepted Q'ty Desc" maxlength="20" style="width:126px;ime-mode:disabled;" class="input" value="" id="frm_imdg_expt_qty_desc" />
					</td>
					<th>(15) EmS No.</th>
					<td>
						<input type="text" name="frm_imdg_emer_no" maxlength="14" style="width:173px;text-align:left;ime-mode:disabled;" class="input" value="" id="frm_imdg_emer_no" />
					</td>
				</tr>
			</table>
			<table>	
				<colgroup>
					<col width="200"/>											
					<col width="200"/>	
					<col width="150"/>	
					<col width="230"/>															
					<col width="150"/>								
					<col width="*"/>				
				</colgroup>
				<tr>
					<th>Stowage category</th>
					<td><input type="text" name="frm_imdg_stwg_cate_cd" caption="Stowage category" dataformat="engup" maxlength="2" style="width:142px;text-align:center;ime-mode:disabled;" class="input" value="" id="frm_imdg_stwg_cate_cd" /></td>
					<th>Flash Point</th>
					<td><input type="text" name="frm_flsh_pnt_temp_ctnt" caption="Flash Point" maxlength="50" style="width:83px;text-align:right;ime-mode:disabled;" class="input" value="" id="frm_flsh_pnt_temp_ctnt" /> <strong>°C c.c</strong></td>
					<th>ERG</th>
					<td><input type="text" name="frm_emer_rspn_gid_no" caption="ERG" maxlength="3" style="width:108px;text-align:center;ime-mode:disabled;" class="input" value="" id="frm_emer_rspn_gid_no" /><input type="text" name="frm_emer_rspn_gid_chr_no" maxlength="2" style="width:121px;text-align:center;ime-mode:disabled;" class="input" value="" id="frm_emer_rspn_gid_chr_no" /></td>
				</tr>
			</table>
			<table>	
				<colgroup>
					<col width="200"/>											
					<col width="200"/>	
					<col width="150"/>	
					<col width="320"/>															
					<col width="50"/>								
					<col width="100"/>								
					<col width="50"/>								
					<col width="*"/>				
				</colgroup>
				<tr>
					<th>First schedule for Singapore</th>
					<td><input type="text" name="frm_psa_no" style="width:104px;text-align:center;ime-mode:disabled;" maxlength="12" class="input" value="" id="frm_psa_no" /> </td>
					<th>BPT</th>
					<td>
						<input type="text" name="frm_n1st_bom_port_trst_no" maxlength="2" dataformat="engup" style="width:52px;text-align:center;ime-mode:disabled;" class="input" value="" id="frm_n1st_bom_port_trst_no" />
						<input type="text" name="frm_n2nd_bom_port_trst_no" maxlength="2" dataformat="engup" style="width:52px;text-align:center;ime-mode:disabled;" class="input" value="" id="frm_n2nd_bom_port_trst_no" />
						<input type="text" name="frm_n3rd_bom_port_trst_no" maxlength="2" dataformat="engup" style="width:52px;text-align:center;ime-mode:disabled;" class="input" value="" id="frm_n3rd_bom_port_trst_no" />
						<input type="text" name="frm_n4th_bom_port_trst_no" maxlength="2" dataformat="engup" style="width:52px;text-align:center;ime-mode:disabled;" class="input" value="" id="frm_n4th_bom_port_trst_no" />
					</td>
					<th>LPK</th>
					<td><input type="text" name="frm_pkg_auth_no" maxlength="7" style="width:108px;text-align:center;ime-mode:disabled;" class="input" value="" id="frm_pkg_auth_no" /></td>
					<th>SLPA</th>
					<td><input type="text" name="frm_lk_port_auth_no" maxlength="7" style="width:77px;text-align:center;ime-mode:disabled;" class="input" value="" id="frm_lk_port_auth_no" /> </td>
				</tr>
			</table>
			<table>
				<colgroup>
					<col width="200"/>											
					<col width="*"/>				
				</colgroup>
				<tr>
					<th>Technical Name</th>
					<td><input type="text" name="frm_imdg_tec_nm_desc" style="width:962px;text-align:left" readonly class="input2" value="" id="frm_imdg_tec_nm_desc" /></td>
				</tr>
			</table>
			<table> 
				<colgroup>
					<col width="200"/>											
					<col width="*"/>				
				</colgroup>
				<tr>
					<th>(17) Properties and Observations</th>
					<!-- <td><textarea name="frm_imdg_sbst_ppt_desc" maxlength="4000" style="ime-mode:disabled;resize:none2;width:962px" rows="5"></textarea></td> -->
					<td><textarea name="frm_imdg_sbst_ppt_desc" maxlength="4000" style="ime-mode:disabled;" rows="5"></textarea></td>
				</tr>
			</table>
		</div>		
		
			<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">		
			<script type="text/javascript">ComSheetObject('sheet1');</script>		
		</div>
		<!-- opus_design_grid(E) -->
	
	</div>
	<!-- opus_design_grid(E) -->

	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid"  name="tabLayer" id="tabLayer" style="display:none;">
		<div class="opus_design_inquiry wFit">
			
			<table> 
				<colgroup>
					<col width="70"/>											
					<col width="100"/>											
					<col width="200"/>											
					<col width="*"/>				
				</colgroup>
				<tr>
					<td colspan="4">
						<h3 class="title_design">CFR Information</h3>
					</td>
				</tr>
				<tr>
					<th>RQ</th>
					<td><input type="text" name="frm_cfr_rpt_qty" caption="Reportable Quantity" dataformat="float" pointcount="3" maxlength="8" style="width:80px;text-align:right;ime-mode:disabled;" class="input" value="" id="frm_cfr_rpt_qty" /> </td>
					<th>Poison Inhalation Zone</th>
					<td><input type="text" name="frm_cfr_psn_inh_zn_cd" maxlength="10" style="width:80px;text-align:right;ime-mode:disabled;" class="input" value="" id="frm_cfr_psn_inh_zn_cd" /> </td>
				</tr>
			</table>
			<table>	
				<colgroup>
					<col width="70"/>											
					<col width="100"/>											
					<col width="200"/>											
					<col width="*"/>				
				</colgroup>
				<tr>
					<th>TOXIC</th>
					<td><input type="text" name="frm_cfr_toxc_cd" maxlength="7" style="width:80px;text-align:right;ime-mode:disabled;" class="input" value="" id="frm_cfr_toxc_cd" /> </td>
					<th>Dangerous when wet</th>
					<td><input type="text" name="frm_cfr_dg_wet_cd" maxlength="20" style="width:80px;text-align:right;ime-mode:disabled;" class="input" value="" id="frm_cfr_dg_wet_cd" /> </td>
				</tr>
			</table>
			<table>	
				<colgroup>
					<col width="70"/>	
					<col width="*"/>				
				</colgroup>
				<tr>
					<th>Port Rest.</th>
					<td><input type="text" name="frm_cfr_rstr_port_nm" maxlength="50" style="width:382px;ime-mode:disabled;" class="input" value="" id="frm_cfr_rstr_port_nm" /> </td>
				</tr>
			</table>
			<table>	
				<colgroup>
					<col width="70"/>											
					<col width="100"/>											
					<col width="200"/>											
					<col width="*"/>				
				</colgroup>
				<tr>
					<th>OPR Rest.</th>
					<td><input type="text" name="frm_cfr_rstr_opr_nm" maxlength="20" style="width:80px;text-align:right;ime-mode:disabled;" class="input" value="" id="frm_cfr_rstr_opr_nm" /> </td>
					<th>Extend Class.</th>
					<td style="padding-left:2"><script type="text/javascript">ComComboObject('frm_cfr_xtd_clss_cd', 1, 50, 0);</script></td>  
				</tr>
			</table>
			</div>
			<table  class="line_bluedot"><tr><td colspan="8"></td></tr></table>	
			<div class="opus_design_inquiry wFit">	
			<h3 class="title_design">HCDG</h3>			
			<table> 
				<tr><td><input type="checkbox" name="frm_hcdg_flg" value="Y" class="trans" id="frm_hcdg_flg" /><strong>&nbsp;&nbsp;&nbsp;HCDG&nbsp;&nbsp;&nbsp;&nbsp;</strong><input type="checkbox" name="frm_hcdg_dpnd_qty_flg" value="Y" class="trans" id="frm_hcdg_dpnd_qty_flg" /><strong>&nbsp;&nbsp;&nbsp;Depends on Q'ty</strong></td></tr>
			</table>
			
			<table class="grid_2"> 
				<tr>
					<th>HCDG<br>Remark(s)</th>
					<td><textarea name="frm_hcdg_rmk" maxlength="4000" style="ime-mode:disabled;" cols="167" rows="3"></textarea></td>
				</tr>
			</table>		
		</div>
	</div>
	<!-- opus_design_grid(E) -->
	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid"  name="tabLayer" id="tabLayer" style="display:none;">
		<div class="opus_design_inquiry wFit">
			
			<table>
				<colgroup>
					<col width="70"/>														
					<col width="*"/>				
				</colgroup>
				<tr>
					<td colspan="2">
					<h3 class="title_design">Packing / IBC / Tank Instructions & Provisions</h3>
					</td>
				</tr>
				<tr>
					<th>Packing Instructions</th>
					<td><!--
						--><input type="text" name="frm_n1st_imdg_pck_instr_cd" maxlength="10" style="width:100px;text-align:center;text-decoration:underline;color:#3a7cbf;ime-mode:disabled;" class="input" value="" id="frm_n1st_imdg_pck_instr_cd" /><img class="cursor" name="btns_n1st_imdg_pck_instr_cd" src="img/btns_file.gif" width="19px" height="20px" border="0" align="absmiddle"> <!--
						--><input type="text" name="frm_n2nd_imdg_pck_instr_cd" maxlength="10" style="width:100px;text-align:center;text-decoration:underline;color:#3a7cbf;ime-mode:disabled;" class="input" value="" id="frm_n2nd_imdg_pck_instr_cd" /><img class="cursor" name="btns_n2nd_imdg_pck_instr_cd" src="img/btns_file.gif" width="19px" height="20px" border="0" align="absmiddle"> <!--
						--><input type="text" name="frm_n3rd_imdg_pck_instr_cd" maxlength="10" style="width:100px;text-align:center;text-decoration:underline;color:#3a7cbf;ime-mode:disabled;" class="input" value="" id="frm_n3rd_imdg_pck_instr_cd" /><img class="cursor" name="btns_n3rd_imdg_pck_instr_cd" src="img/btns_file.gif" width="19px" height="20px" border="0" align="absmiddle"> <!--
						--><input type="hidden" name="frm_n1st_imdg_pck_instr_seq" value=""> <!--
						--><input type="hidden" name="frm_n2nd_imdg_pck_instr_seq" value=""> <!--
						--><input type="hidden" name="frm_n3rd_imdg_pck_instr_seq" value=""> <!-- 
					--></td>
				</tr>				
				<tr>
					<th>Packing Provisions</th>
					<td><!--
						--><input type="text" name="frm_n1st_imdg_pck_provi_cd" maxlength="10" style="width:100px;text-align:center;text-decoration:underline;color:#3a7cbf;ime-mode:disabled;" class="input" value="" id="frm_n1st_imdg_pck_provi_cd" /><!--
						--><img class="cursor" name="btns_n1st_imdg_pck_provi_cd" src="img/btns_file.gif" width="19px" height="20px" border="0" align="absmiddle"> <!--
						--><input type="text" name="frm_n2nd_imdg_pck_provi_cd" maxlength="10" style="width:100px;text-align:center;text-decoration:underline;color:#3a7cbf;ime-mode:disabled;" class="input" value="" id="frm_n2nd_imdg_pck_provi_cd" /><!--
						--><img class="cursor" name="btns_n2nd_imdg_pck_provi_cd" src="img/btns_file.gif" width="19px" height="20px" border="0" align="absmiddle"> <!--
						--><input type="text" name="frm_n3rd_imdg_pck_provi_cd" maxlength="10" style="width:100px;text-align:center;text-decoration:underline;color:#3a7cbf;ime-mode:disabled;" class="input" value="" id="frm_n3rd_imdg_pck_provi_cd" /><!--
						--><img class="cursor" name="btns_n3rd_imdg_pck_provi_cd" src="img/btns_file.gif" width="19px" height="20px" border="0" align="absmiddle"> <!--
						--><input type="text" name="frm_n4th_imdg_pck_provi_cd" maxlength="10" style="width:100px;text-align:center;text-decoration:underline;color:#3a7cbf;ime-mode:disabled;" class="input" value="" id="frm_n4th_imdg_pck_provi_cd" /><!--
						--><img class="cursor" name="btns_n4th_imdg_pck_provi_cd" src="img/btns_file.gif" width="19px" height="20px" border="0" align="absmiddle"> <!--
						--><input type="text" name="frm_n5th_imdg_pck_provi_cd" maxlength="10" style="width:100px;text-align:center;text-decoration:underline;color:#3a7cbf;ime-mode:disabled;" class="input" value="" id="frm_n5th_imdg_pck_provi_cd" /><!--
						--><img class="cursor" name="btns_n5th_imdg_pck_provi_cd" src="img/btns_file.gif" width="19px" height="20px" border="0" align="absmiddle"> <!--
						--><input type="hidden" name="frm_n1st_imdg_pck_provi_seq" value=""> <!--
						--><input type="hidden" name="frm_n2nd_imdg_pck_provi_seq" value=""> <!--
						--><input type="hidden" name="frm_n3rd_imdg_pck_provi_seq" value=""> <!--
						--><input type="hidden" name="frm_n4th_imdg_pck_provi_seq" value=""> <!--
						--><input type="hidden" name="frm_n5th_imdg_pck_provi_seq" value=""> <!--
					--></td> 
				</tr>
				<tr>
					<th>IBC Instructions</th>
					<td><!--
						--><input type="text" name="frm_n1st_imdg_ibc_instr_cd" maxlength="10" style="width:100px;text-align:center;text-decoration:underline;color:#3a7cbf;ime-mode:disabled;" class="input" value="" id="frm_n1st_imdg_ibc_instr_cd" /><!--
						--><img class="cursor" name="btns_n1st_imdg_ibc_instr_cd" src="img/btns_file.gif" width="19px" height="20px" border="0" align="absmiddle"> <!--
						--><input type="text" name="frm_n2nd_imdg_ibc_instr_cd" maxlength="10" style="width:100px;text-align:center;text-decoration:underline;color:#3a7cbf;ime-mode:disabled;" class="input" value="" id="frm_n2nd_imdg_ibc_instr_cd" /><!--
						--><img class="cursor" name="btns_n2nd_imdg_ibc_instr_cd" src="img/btns_file.gif" width="19px" height="20px" border="0" align="absmiddle"> <!--
						--><input type="text" name="frm_n3rd_imdg_ibc_instr_cd" maxlength="10" style="width:100px;text-align:center;text-decoration:underline;color:#3a7cbf;ime-mode:disabled;" class="input" value="" id="frm_n3rd_imdg_ibc_instr_cd" /><!--
						--><img class="cursor" name="btns_n3rd_imdg_ibc_instr_cd" src="img/btns_file.gif" width="19px" height="20px" border="0" align="absmiddle"> <!--
						--><input type="text" name="frm_n4th_imdg_ibc_instr_cd" maxlength="10" style="width:100px;text-align:center;text-decoration:underline;color:#3a7cbf;ime-mode:disabled;" class="input" value="" id="frm_n4th_imdg_ibc_instr_cd" /><!--
						--><img class="cursor" name="btns_n4th_imdg_ibc_instr_cd" src="img/btns_file.gif" width="19px" height="20px" border="0" align="absmiddle"> <!--
						--><input type="text" name="frm_n5th_imdg_ibc_instr_cd" maxlength="10" style="width:100px;text-align:center;text-decoration:underline;color:#3a7cbf;ime-mode:disabled;" class="input" value="" id="frm_n5th_imdg_ibc_instr_cd" /><!--
						--><img class="cursor" name="btns_n5th_imdg_ibc_instr_cd" src="img/btns_file.gif" width="19px" height="20px" border="0" align="absmiddle"> <!--
						--><input type="hidden" name="frm_n1st_imdg_ibc_instr_seq" value=""> <!--
						--><input type="hidden" name="frm_n2nd_imdg_ibc_instr_seq" value=""> <!--
						--><input type="hidden" name="frm_n3rd_imdg_ibc_instr_seq" value=""> <!--
						--><input type="hidden" name="frm_n4th_imdg_ibc_instr_seq" value=""> <!--
						--><input type="hidden" name="frm_n5th_imdg_ibc_instr_seq" value=""> <!--		
					--></td> 
				</tr>
				<tr>
					<th>IBC Provisions</th>
					<td><!--
						--><input type="text" name="frm_n1st_imdg_ibc_provi_cd" maxlength="10" style="width:100px;text-align:center;text-decoration:underline;color:#3a7cbf;ime-mode:disabled;" class="input" value="" id="frm_n1st_imdg_ibc_provi_cd" /><!--
						--><img class="cursor" name="btns_n1st_imdg_ibc_provi_cd" src="img/btns_file.gif" width="19px" height="20px" border="0" align="absmiddle"> <!--
						--><input type="text" name="frm_n2nd_imdg_ibc_provi_cd" maxlength="10" style="width:100px;text-align:center;text-decoration:underline;color:#3a7cbf;ime-mode:disabled;" class="input" value="" id="frm_n2nd_imdg_ibc_provi_cd" /><!--
						--><img class="cursor" name="btns_n2nd_imdg_ibc_provi_cd" src="img/btns_file.gif" width="19px" height="20px" border="0" align="absmiddle"> <!--
						--><input type="text" name="frm_n3rd_imdg_ibc_provi_cd" maxlength="10" style="width:100px;text-align:center;text-decoration:underline;color:#3a7cbf;ime-mode:disabled;" class="input" value="" id="frm_n3rd_imdg_ibc_provi_cd" /><!--
						--><img class="cursor" name="btns_n3rd_imdg_ibc_provi_cd" src="img/btns_file.gif" width="19px" height="20px" border="0" align="absmiddle"> <!--
						--><input type="text" name="frm_n4th_imdg_ibc_provi_cd" maxlength="10" style="width:100px;text-align:center;text-decoration:underline;color:#3a7cbf;ime-mode:disabled;" class="input" value="" id="frm_n4th_imdg_ibc_provi_cd" /><!--
						--><img class="cursor" name="btns_n4th_imdg_ibc_provi_cd" src="img/btns_file.gif" width="19px" height="20px" border="0" align="absmiddle"> <!--
						--><input type="text" name="frm_n5th_imdg_ibc_provi_cd" maxlength="10" style="width:100px;text-align:center;text-decoration:underline;color:#3a7cbf;ime-mode:disabled;" class="input" value="" id="frm_n5th_imdg_ibc_provi_cd" /><!--
						--><img class="cursor" name="btns_n5th_imdg_ibc_provi_cd" src="img/btns_file.gif" width="19px" height="20px" border="0" align="absmiddle"> <!--
						--><input type="hidden" name="frm_n1st_imdg_ibc_provi_seq" value=""><!--
						--><input type="hidden" name="frm_n2nd_imdg_ibc_provi_seq" value=""><!--
						--><input type="hidden" name="frm_n3rd_imdg_ibc_provi_seq" value=""><!--
						--><input type="hidden" name="frm_n4th_imdg_ibc_provi_seq" value=""><!--
						--><input type="hidden" name="frm_n5th_imdg_ibc_provi_seq" value=""><!--				
					--></td> 
				</tr>
				<tr>
					<th>UN Tank Instructions</th>
					<td><!--
						--><input type="text" name="frm_n1st_imdg_un_tnk_instr_cd" maxlength="10" style="width:100px;text-align:center;text-decoration:underline;color:#3a7cbf;ime-mode:disabled;" class="input" value="" id="frm_n1st_imdg_un_tnk_instr_cd" /><!--
						--><img class="cursor" name="btns_n1st_imdg_un_tnk_instr_cd" src="img/btns_file.gif" width="19px" height="20px" border="0" align="absmiddle"> <!--
						--><input type="text" name="frm_n2nd_imdg_un_tnk_instr_cd" maxlength="10" style="width:100px;text-align:center;text-decoration:underline;color:#3a7cbf;ime-mode:disabled;" class="input" value="" id="frm_n2nd_imdg_un_tnk_instr_cd" /><!--
						--><img class="cursor" name="btns_n2nd_imdg_un_tnk_instr_cd" src="img/btns_file.gif" width="19px" height="20px" border="0" align="absmiddle"><!--
						--><input type="hidden" name="frm_n1st_imdg_un_tnk_instr_seq" value=""> <!--
						--><input type="hidden" name="frm_n2nd_imdg_un_tnk_instr_seq" value=""> <!--
					--></td> 
				</tr>
				<tr>
					<th>Tank Special Provisions</th>
					<td><!-- 
						--><input type="text" name="frm_n1st_imdg_tnk_instr_provi_cd" maxlength="10" style="width:100px;text-align:center;text-decoration:underline;color:#3a7cbf;ime-mode:disabled;" class="input" value="" id="frm_n1st_imdg_tnk_instr_provi_cd" /><!--
						--><img class="cursor" name="btns_n1st_imdg_tnk_instr_provi_cd" src="img/btns_file.gif" width="19px" height="20px" border="0" align="absmiddle"> <!--
						--><input type="text" name="frm_n2nd_imdg_tnk_instr_provi_cd" maxlength="10" style="width:100px;text-align:center;text-decoration:underline;color:#3a7cbf;ime-mode:disabled;" class="input" value="" id="frm_n2nd_imdg_tnk_instr_provi_cd" /><!--
						--><img class="cursor" name="btns_n2nd_imdg_tnk_instr_provi_cd" src="img/btns_file.gif" width="19px" height="20px" border="0" align="absmiddle"> <!--
						--><input type="text" name="frm_n3rd_imdg_tnk_instr_provi_cd" maxlength="10" style="width:100px;text-align:center;text-decoration:underline;color:#3a7cbf;ime-mode:disabled;" class="input" value="" id="frm_n3rd_imdg_tnk_instr_provi_cd" /><!--
						--><img class="cursor" name="btns_n3rd_imdg_tnk_instr_provi_cd" src="img/btns_file.gif" width="19px" height="20px" border="0" align="absmiddle"> <!--
						--><input type="text" name="frm_n4th_imdg_tnk_instr_provi_cd" maxlength="10" style="width:100px;text-align:center;text-decoration:underline;color:#3a7cbf;ime-mode:disabled;" class="input" value="" id="frm_n4th_imdg_tnk_instr_provi_cd" /><!--
						--><img class="cursor" name="btns_n4th_imdg_tnk_instr_provi_cd" src="img/btns_file.gif" width="19px" height="20px" border="0" align="absmiddle"> <!--
						--><input type="text" name="frm_n5th_imdg_tnk_instr_provi_cd" maxlength="10" style="width:100px;text-align:center;text-decoration:underline;color:#3a7cbf;ime-mode:disabled;" class="input" value="" id="frm_n5th_imdg_tnk_instr_provi_cd" /><!--
						--><img class="cursor" name="btns_n5th_imdg_tnk_instr_provi_cd" src="img/btns_file.gif" width="19px" height="20px" border="0" align="absmiddle"> <!--
						--><input type="hidden" name="frm_n1st_imdg_tnk_instr_provi_seq" value=""><!--
						--><input type="hidden" name="frm_n2nd_imdg_tnk_instr_provi_seq" value=""><!--
						--><input type="hidden" name="frm_n3rd_imdg_tnk_instr_provi_seq" value=""><!--
						--><input type="hidden" name="frm_n4th_imdg_tnk_instr_provi_seq" value=""><!--
						--><input type="hidden" name="frm_n5th_imdg_tnk_instr_provi_seq" value=""><!--				
					--></td> 
				</tr>
			</table>
			</div>
			<table  class="line_bluedot"><tr><td colspan="8"></td></tr></table>
			<div class="opus_design_inquiry wFit">
			<h3 class="title_design">HCDG - Packing / IBC / Tank Restrictions</h3>			
			<table> 
				<colgroup>
					<col width="70"/>														
					<col width="*"/>				
				</colgroup>
				<tr>
					<th>Packaging</th>
					<td><input type="text" name="frm_hcdg_pck_rstr_desc" maxlength="100" style="width:100px;ime-mode:disabled;" class="input" value="" id="frm_hcdg_pck_rstr_desc" /> </td>
				</tr>
				<tr>
					<th>Intermediate Bulk</th>
					<td><input type="text" name="frm_hcdg_intmd_bc_rstr_desc" maxlength="100" style="width:100px;ime-mode:disabled;" class="input" value="" id="frm_hcdg_intmd_bc_rstr_desc" /> </td>
				</tr>
				<tr>
					<th>Tank</th>
					<td><input type="text" name="frm_hcdg_tnk_rstr_desc" maxlength="500" style="width:850px;ime-mode:disabled;" class="input" value="" id="frm_hcdg_tnk_rstr_desc" /> </td>
				</tr>
			</table>
		</div>
	</div>
	<!-- opus_design_grid(E) -->
	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid"  name="tabLayer" id="tabLayer" style="display:none;">
		<div class="opus_design_inquiry wFit">
			<table> 
				<colgroup>
					<col width="200"/>														
					<col width="*"/>				
				</colgroup>
				<tr>
					<th>(16) Stowage and Segregation</th>
					<td><input type="text" name="frm_segr_desc" maxlength="1000" style="width:780px;ime-mode:disabled;" class="input" value="" id="frm_segr_desc" /> </td>
				</tr>
				<tr>
					<th>(16-1) Stowage Instruction 1st Remark</th>
					<td><input type="text" name="frm_n1st_add_segr_desc" maxlength="1000" style="width:780px;ime-mode:disabled;" class="input" value="" id="frm_n1st_add_segr_desc" /> </td>
				</tr>				<tr>
					<th>(16-2) Stowage Instruction 2nd Remark</th>
					<td><input type="text" name="frm_n2nd_add_segr_desc" maxlength="1000" style="width:780px;ime-mode:disabled;" class="input" value="" id="frm_n2nd_add_segr_desc" /> </td>
				</tr>	          				
				
			</table>
			</div>
			<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
			<div class="opus_design_inquiry wFit">
			<h3 class="title_design">Stowage</h3>
			<table> 
				<colgroup>
					<col width="130"/>														
					<col width="200"/>														
					<col width="150"/>														
					<col width="200"/>		
					<col width="150"/>													
					<col width="*"/>				
				</colgroup>
				<tr>
					<th>Clear of Living Q'tr</th>
					<td><select name="frm_clr_liv_qtr_stwg_flg" id="frm_clr_liv_qtr_stwg_flg" style="width:96px;"><option selected="selected" value="N">No</option><option value="Y">Yes</option></select></td>
					<th>Foodstuffs</th>
					<td><select name="frm_imdg_fd_stuf_stwg_cd" id="frm_imdg_fd_stuf_stwg_cd" style="width:96px;"><option selected="selected" value="0">None</option><option value="1">Away from</option><option value="2">Separate from</option></select></td>
					<th>Source of Heat</th>
					<td><select name="frm_imdg_ht_src_stwg_cd" id="frm_imdg_ht_src_stwg_cd" style="width:96px;"><option selected="selected" value="0">None</option><option value="1">Away from</option><option value="2">Separate from</option></select></td>
				</tr>
			</table>
			</div>
			<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
			<div class="opus_design_inquiry wFit">
			<h3 class="title_design"> Segregation</h3></td>
			<table>			
				<tr>
					<td><input type="checkbox" name="frm_imdg_un_no_hld_flg" value="" class="trans" id="frm_imdg_un_no_hld_flg" /> <b>Pre-Checking  hold</b></td>
					<td align="right"><button class="btn_etc" name="btn_AutoCreation" id="btn_AutoCreation" type="button">Auto Creation</button></td>
				</tr>
			</table>
			<script type="text/javascript">ComSheetObject('sheet2');</script>
			<script type="text/javascript">ComSheetObject('sheet3');</script>
				
			<table class=""> 
				<colgroup>
					<col width="150"/>														
					<col width="100"/>														
					<col width="140"/>		
					<col width="180"/>													
					<col width="200"/>													
					<col width="*"/>				
				</colgroup>
				<tr>
					<td><input type="checkbox" name="frm_segr_as_for_imdg_clss_flg" value="" class="trans" id="frm_segr_as_for_imdg_clss_flg" /> <strong>Segregation as for</strong></td>
					<td><script type="text/javascript">ComComboObject('frm_segr_as_for_imdg_clss_cd', 1, 45, 0);</script></td>
					<td><input type="checkbox" name="frm_away_fm_imdg_clss_flg" value="" class="trans" id="frm_away_fm_imdg_clss_flg" /> <strong>Away from Class</strong></td>
					<td><script type="text/javascript">ComComboObject('frm_away_fm_imdg_clss_cd', 1, 120, 0);</script></td>
					<td><input type="checkbox" name="frm_sprt_fm_imdg_clss_flg" value="" class="trans" id="frm_sprt_fm_imdg_clss_flg" /> <strong>Separated from Class</strong></td>
					<td><script type="text/javascript">ComComboObject('frm_sprt_fm_imdg_clss_cd', 1, 120, 0);</script></td>
				</tr>
			</table>
			<table class="">
				<colgroup>
					<col width="270"/>														
					<col width="150"/>														
					<col width="200"/>														
					<col width="1500"/>																										
					<col width="*"/>				
				</colgroup>
				<tr>
					<td><input type="checkbox" name="frm_sprt_hld_fm_imdg_clss_flg" value="" class="trans" id="frm_sprt_hld_fm_imdg_clss_flg" /><strong> Separated by compartment or hold fm Class</strong></td>
					<td><script type="text/javascript">ComComboObject('frm_sprt_hld_fm_imdg_clss_cd', 1, 120, 0);</script></td>
					<td><input type="checkbox" name="frm_sprt_lon_fm_imdg_clss_flg" value="" class="trans" id="frm_sprt_lon_fm_imdg_clss_flg" /> <strong>Separated longitudinally fm Class</strong></td>
					<td><script type="text/javascript">ComComboObject('frm_sprt_lon_fm_imdg_clss_cd', 1, 120, 0);</script></td>
				</tr>
					<tr>
					<th>Segregation Groups </th>
					<td><input type="text" name="frm_hcdg_tnk_rstr_desc1" readonly style="width:40px;text-align:center" class="input2" value="" id="frm_hcdg_tnk_rstr_desc1"/><!--
						--><input type="text" name="frm_hcdg_tnk_rstr_desc2" readonly style="width:40px;text-align:center" class="input2" value="" id="frm_hcdg_tnk_rstr_desc2" /><!--
						--><input type="text" name="frm_hcdg_tnk_rstr_desc3" readonly style="width:40px;text-align:center" class="input2" value="" id="frm_hcdg_tnk_rstr_desc3" /><!--
						--><input type="text" name="frm_hcdg_tnk_rstr_desc4" readonly style="width:40px;text-align:center" class="input2" value="" id="frm_hcdg_tnk_rstr_desc4" /><!--
					--></td>
					<td><input type="checkbox" name="frm_away_fm_imdg_segr_grp_flg" value="" class="trans" id="frm_away_fm_imdg_segr_grp_flg" /> <strong>Away from SG</strong></td>
					<td><script type="text/javascript">ComComboObject('frm_away_dp_seq', 1, 120, 0);</script></td>
					<td><input type="checkbox" name="frm_sprt_fm_imdg_segr_grp_flg" value="" class="trans" id="frm_sprt_fm_imdg_segr_grp_flg" /> <strong>Separated from SG</strong></td>
					<td><script type="text/javascript">ComComboObject('frm_sprt_dp_seq', 1, 120, 0);</script></td>
				</tr>
			</table>
		</div>
	</div>
	<!-- opus_design_grid(E) -->
	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid"  name="tabLayer" id="tabLayer" style="display:none;">
		<div class="opus_design_inquiry wFit">
			<table> 
				<tr>
					<th>Classification</th>
					<td><!--
						--><select name="frm_imdg_org_ract_tp_cd" style="width:170px;"><!--
							--><option value=""></option><!--
							--><option value="P">Organic Peroxides</option><!--
							--><option value="S">Self-Reactive Substance</option><!--
						--></select>
					</td>
				</tr>
				<tr>
					<th>Technical Name</th>
					<td><input type="text" name="frm_imdg_tec_nm" maxlength="500" style="width:850px;ime-mode:disabled;" class="input" value="" id="frm_imdg_tec_nm" /> </td>
				</tr>
				<tr>
					<th>Concentration (%)</th>
					<td><input type="text" name="frm_imdg_conc_rt_ctnt" maxlength="50" style="width:228px;ime-mode:disabled;" class="input" value="" id="frm_imdg_conc_rt_ctnt" /> </td>
				</tr>
				<tr>
					<th>Packing Method</th>
					<td><input type="text" name="frm_imdg_pck_mzd_cd" maxlength="20" style="width:228px;ime-mode:disabled;" class="input" value="" id="frm_imdg_pck_mzd_cd" /> </td>
				</tr>
				<tr>
					<th>Control Temp (℃)</th>
					<td><input type="text" name="frm_imdg_ctrl_temp" caption="Control Temp (℃)" maxlength="6" dataformat="float" pointcount="3" style="width:228px;text-align:right;ime-mode:disabled;" class="input" value="" id="frm_imdg_ctrl_temp" /> </td>
				</tr>
				<tr>
					<th>Emergency Temp (℃)</th>
					<td><input type="text" name="frm_imdg_emer_temp" caption="Emergency Temp (℃)" maxlength="6" dataformat="float" pointcount="3" style="width:228px;text-align:right;ime-mode:disabled;" class="input" value="" id="frm_imdg_emer_temp" /> </td>
				</tr>
				<tr>
					<th>Subsidiary risk(s)</th>
					<td><!-- 
						--><input type="text" name="frm_n1st_imdg_subs_rsk_lbl_cd" readonly style="width:54px;text-align:center" class="input2" value="" id="frm_n1st_imdg_subs_rsk_lbl_cd" /><!--
						--><input type="text" name="frm_n2nd_imdg_subs_rsk_lbl_cd" readonly style="width:54px;text-align:center" class="input2" value="" id="frm_n2nd_imdg_subs_rsk_lbl_cd" /><!--
						--><input type="text" name="frm_n3rd_imdg_subs_rsk_lbl_cd" readonly style="width:54px;text-align:center" class="input2" value="" id="frm_n3rd_imdg_subs_rsk_lbl_cd" /><!--
						--><input type="text" name="frm_n4th_imdg_subs_rsk_lbl_cd" readonly style="width:54px;text-align:center" class="input2" value="" id="frm_n4th_imdg_subs_rsk_lbl_cd" /><!--
					--></td>
				</tr>
			</table>
		</div>
	</div>
	<!-- opus_design_grid(E) -->
</div>
<% if (pop_yn=="Y") { %></div><%}%>
</form>