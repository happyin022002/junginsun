<%--
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_COA_0070.jsp
*@FileTitle  : Weekly Sales Report By Office 1
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/15
               20140904 : tr0~tr3 수정
==========================================================*/
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%
	Exception serverException   = null;					//
	String strErrMsg 	= "";							//
	//String successFlag 	= "";
    String userId   = "";
    String ofc_cd   = "";
	String prevWeek = "";
	String f_ofc_lvl1 	= "";
	String f_ofc_cd 	= "";
	String f_ofc_lvl2 	= "";

	try {
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}else{
			SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
			userId = account.getUsr_id();
	        ofc_cd = account.getOfc_cd();  //.getUserOffice2();
		} // end else
	}catch(Exception e) {
		out.println(e.toString());
	}


%>
<script  type="text/javascript">
	function setupPage(){

		var errMessage = "<%=strErrMsg%>";

		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();

	}
</script>
<form name="form" onKeyDown="ComKeyEnter();">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="f_yearweek" id="f_yearweek" />
<input type="hidden" name="f_pre_week" id="f_pre_week" />
<input type="hidden" name="div_nm" id="div_nm" />
<input type="hidden" name="param_size" id="param_size" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" 	id="btn_retrieve">Retrieve</button><!--
		--><button type="button" class="btn_normal" name="btn_new" 		id="btn_new">New</button><!--
		--><button type="button" class="btn_normal" name="btn_downexcel"  		id="btn_downexcel">Down Excel</button>	
	</div>
	<!-- opus_design_btn(E) -->
	<!-- page_location(S) -->
	<div class="location">
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->

<!-- opus_design_inquiry(S) -->
<div class= "wrap_search_tab">
	<div class= "opus_design_inquiry">
		<table>
			<tbody>
				<colgroup>
					<col width="*"/>
			    </colgroup>
				<tr id="tr0" name="tr0">
					<td>
					<table border='0'>
						<colgroup>
							<col width="50"/>
							<col width="50"/>
							<col width="50"/>
							<col width="50"/>
							<col width="*"/>
					    </colgroup>	
					    <tr>
							<th>Year</th>
							<td><input type="text" style="width:40px;text-align:center;ime-mode:disabled;" class="input1" name="f_year2" id="f_year2" maxlength="4" dataformat="yyyy" onChange="setPeriod2(this);" onKeyDown="ComKeyEnter();"></td>
							<th>Week</th>
							<td><input type="text" style="width:30px;text-align:center;ime-mode:disabled" class="input1" name="f_wk" id="f_wk" maxlength="2" dataformat="num" onKeyDown="ComKeyEnter();" onChange="if(this.value!=''){this.value=ComLpad(this, 2, '0'); setPeriod2(this);} " ></td>
							<td><div id="div_period1" name="div_period1"></div></td><!-- SJH.20140904.MOD : div_period--div_period1 -->						    
					    </tr>	
					</table>			
					</td>
				</tr>	
				<tr id="tr1" name="tr1" style="display:none;"><td> <script  type="text/javascript">coaPeriod1("1","O");</script></td></tr>
			</tbody>
		</table>	
		<table>
			<tbody>
				<colgroup>
					<col width="100"/>
					<col width="100"/>
					<col width="150"/>
					<col width="100"/>
					<col width="100"/>
					<col width="100"/>
					<col width="100"/>
					<col width="100"/>
					<col width="*"/>
			    </colgroup>
				<tr><td class="line_bluedot" colspan="9"></td></tr>
				<tr>
					<td><span class="title_design">By View</span></td>
					<th>Profit View</th>
		            <td><script  type="text/javascript">ComComboObject('f_pro_vw',1, 140 , 0 )</script> </td>
		            <th>Office View</th>
		            <td><script  type="text/javascript">ComComboObject('f_ofc_vw',1, 100 , 0 )</script></td>
					<th style="display:none">Profit Level</th>
		            <td style="display:none"><script  type="text/javascript">ComComboObject('f_pro_lvl',1, 110 , 0 )</script></td>
                    <th>Report</th>
                    <td><script  type="text/javascript">ComComboObject('f_rpt_item',1, 100 , 0 )</script></td>		
				</tr>	
				<tr><td class="line_bluedot" colspan="9"></td></tr>
				<tr>
					<td><span class="title_design">By Office</span></td>
					<th>Office Level1</th>
					<td><script  type="text/javascript">ComComboObject('f_ofc_lvl1',1, 140 , 0 )</script></td>
					<th>Office</th>
					<td><script  type="text/javascript">ComComboObject('f_ofc_cd',1, 100 , 0 )</script></td>
					<th>Office Level2</th>
					<td ><script  type="text/javascript">ComComboObject('f_ofc_lvl2',1, 150 , 0 )</script></td>
					<td colspan="2"></td>
				</tr>
				<!-- SJH.20140904.MOD : 위치 변경 -->
			    <tr>
			    	<td>&nbsp;</td>
			    	<td colspan="5">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" class="trans" name="f_bkg_sts" id="f_bkg_sts" value="Y">&nbsp;&nbsp;<b>Waiting Booking Include</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    					<input type="checkbox" class="trans" name="f_dir_sts" id="f_dir_sts" value="Y" >&nbsp;<b>Bound Display</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		    			<input type="checkbox" class="trans" name="f_ofc_sts" id="f_ofc_sts" value="Y" >&nbsp;<b>Office Display</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				  		<input type="checkbox" class="trans" name="f_excl_sts" id="f_excl_sts" value="Y">&nbsp;<b>Excluding Sub</b>
				  	</td>
				    <td colspan="3" id="tr3" style="display:none"><input type="checkbox" class="trans" name="f_wk_sts" id="f_wk_sts" value="Y">&nbsp;<b>Week Display</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="checkbox" class="trans" name="f_rf_sts" id="f_rf_sts" value="Y">&nbsp;<b>Reefer Only</b> </td>				           
				</tr>				
			</tbody>
		</table>
		<table id="tr2" style="display:none">
			<tbody>
				<colgroup>
					<col width="100"/>
					<col width="100"/>
					<col width="150"/>
					<col width="100"/>
					<col width="100"/>
					<col width="100"/>
					<col width="100"/>
					<col width="100"/>
					<col width="400"/>
			    </colgroup>
				<tr>
                    <td class="line_bluedot" colspan="9"></td>
                </tr>
                <tr>
                    <td><span class="title_design">By Route</span></td>
                    <th>Trade</th>
                    <td><script  type="text/javascript">ComComboObject('f_trd_cd',1, 140 , 0 )</script></td>
                    <th>Lane</th>
                    <td><script  type="text/javascript">ComComboObject('f_rlane_cd',1, 100 , 0 )</script></td>
                    <th>Direction</th>
                    <td><script  type="text/javascript">ComComboObject('f_skd_dir_cd',1, 110 , 0 )</script></td>
                    <th title="Vessel Voyage Direction">VVD</th>
                    <td><input type="text" style="width:40px;" maxlength="4" name="f_vsl_cd" id="f_vsl_cd" dataformat="engup" onKeyPress="ComKeyOnlyAlphabet('uppernum');" onKeyUp="ComKeyEnter('LengthNextFocus');" style="ime-mode:disabled">
                        <input type="text" style="width:40px;" maxlength="4" name="f_skd_voy_no" dataformat="num" id="f_skd_voy_no" onKeyPress="ComKeyOnlyNumber(this);" onKeyUp="ComKeyEnter('LengthNextFocus');" style="ime-mode:disabled">
                        <input type="text" style="width:22px;" maxlength="1" name="f_dir_cd" id="f_dir_cd" dataformat="engup" onKeyPress="ComKeyOnlyAlphabet('upper');" style="ime-mode:disabled">
                    </td>
                </tr>            
			</tbody>
		</table>
	</div>
</div>
<!-- opus_design_inquiry(E) -->
<div class="wrap_result">
	<!-- opus_tab_btn(S) -->
		<div class="opus_design_tab sm">
			<script type="text/javascript">ComTabObject('tab1')</script>
		</div>
	<!-- TAB1 -->
	<!-- opus_tab_btn(E) -->
	<div id="tabLayer" style="display:inline; ">
		<div class= "opus_design_grid">
		<!--<h3 id="div_label1" class="title_design">Weekly Sales Report</h3>-->
		<h3 id="div_label1" class="title_design"></h3>
			<table>
				<tbody>
				<colgroup>
					<col width="150"/>
					<col width="*"/>
			    </colgroup>
				<tr>
					<td><h3 id="div_title" class="title_design">VS Pre. Week</h3></td>
					<td align="right">(1USD, TEU)
        				<div class="opus_design_btn" style="margin-left:4px;">
							<div id="div_zoom_in1" style="display:inline">
								<button type="button" class="btn_down" name="bu_zoom_in1" id="bu_zoom_in1" alt="Zoom in(+)"></button>
							</div>
							<div id="div_zoom_out1" style="display:none">
								<button type="button" class="btn_up" name="bu_zoom_out1" id="bu_zoom_out1" alt="Zoom out(-)"></button>
							</div>
						</div>
					</td>
				</tr>
				</tbody>
			</table>
		</div>
		<div class="opus_design_grid clear" style="margin-top:-5px">
			<div id="div_sheet1" name="div_sheet1"><script type="text/javascript">ComSheetObject('sheet1');</script></div>
		</div>	
		<div class= "opus_design_grid">
		
			<table>
				<tr><td><h3 class="title_design">BKG CM Variance Factor</h3></td>
					<td align="right">
        				<div class="opus_design_btn">
							<div id="div_zoom_in2" style="display:inline">
								<button type="button"  class="btn_down" name="bu_zoom_in2" id="bu_zoom_in2" alt="Zoom in(+)"></button>
							</div>
							<div id="div_zoom_out2" style="display:none">
								<button type="button"  class="btn_up" name="bu_zoom_out2" id="bu_zoom_out2" alt="Zoom out(-)"></button>
							</div>
						</div>
					</td>
				</tr>
			</table>		
		</div>	
		<div class="opus_design_grid clear" style="margin-top:-5px">		
		    <div id="div_sheet2" name="div_sheet2"><script type="text/javascript">ComSheetObject('sheet2');</script></div>	
		    <!-- SJH.20140904.ADD -->
			<table>			    
			    <tr>
			        <td align="right"><img src="/opuscntr/img/ico_star.gif" border="0" hspace="3" align="absmiddle">CPB - Cost Per Box &nbsp;</td>
			    </tr>
			    <tr><td height="20"><img src="/opuscntr/img/ico_star.gif" border="0" hspace="3" align="absmiddle"><strong>Remark</strong></td></tr>
			    <tr><td style="padding-left:11;" class="sm">&nbsp;
						<img src="/opuscntr/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0" vspace="3">
						CM = Freight Rev + Misc OP Rev - Full Cost - MT Cost - Agt Comm
					</td>
				</tr>				    
			</table>
		</div>	
	</div>
	
	<!-- TAB2 : SJH.20140904.ADD -->
	 <div id="tabLayer" style="display:none"> 
	 	<div class= "opus_design_grid">
	 	<h3 id="div_label2" class="title_design"></h3>
		 	<table>
				<tbody>
				<colgroup>
					<col width="150"/>
					<col width="*"/>
			    </colgroup>		 	
		 	   <tr>
					<td><h3 id="div_title2" class="title_design">VS QTA</h3></td>
					<td align="right">(1USD, TEU)
        				<div class="opus_design_btn" style="margin-left:4px;">
							<div id="div_zoom_in3" style="display:inline">
								<button type="button"  class="btn_down" name="bu_zoom_in3" id="bu_zoom_in3" alt="Zoom in(+)"></button>
							</div> 
							<div id="div_zoom_out3" style="display:none">
								<button type="button"  class="btn_up" name="bu_zoom_out3" id="bu_zoom_out3" alt="Zoom out(-)"></button>
							</div>
						</div>
					</td>
				</tr>	
				</tbody>
			</table>
		</div>
		<div class="opus_design_grid clear" style="margin-top:-5px">
			<div id="div_sheet3" name="div_sheet3"><script type="text/javascript">ComSheetObject('sheet3');</script></div>
		</div>	
		<div class= "opus_design_grid">
		 	<table>
				<tr><td><h3 class="title_design">BKG CM Variance Factor</h3></td>
					<td align="right">
        				<div class="opus_design_btn">
							<div id="div_zoom_in4" style="display:inline">
								<button type="button"  class="btn_down" name="bu_zoom_in4" id="bu_zoom_in4" alt="Zoom in(+)"></button>
							</div>
							<div id="div_zoom_out4" style="display:none">
								<button type="button"  class="btn_up" name="bu_zoom_out4" id="bu_zoom_out4" alt="Zoom out(-)"></button>
							</div>
						</div>
					</td>
				</tr>				
			</table>
		</div>
		<div class="opus_design_grid clear"style="margin-top:-5px" >
			<div id="div_sheet4" name="div_sheet4"><script type="text/javascript">ComSheetObject('sheet4');</script></div>
			<!-- SJH.20140904.ADD -->
			<table>			    
			    <tr>
			        <td align="right"><img src="/opuscntr/img/ico_star.gif" border="0" hspace="3" align="absmiddle">CPB - Cost Per Box &nbsp;</td>
			    </tr>
			    <tr><td height="20"><img src="/opuscntr/img/ico_star.gif" border="0" hspace="3" align="absmiddle"><strong>Remark</strong></td></tr>
			    <tr><td style="padding-left:11;" class="sm">&nbsp;
						<img src="/opuscntr/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0" vspace="3">
						CM = Freight Rev + Misc OP Rev - Full Cost - MT Cost - Agt Comm
					</td>
				</tr>				    
			</table>			
		</div>
	 </div>
</div>
</form>


