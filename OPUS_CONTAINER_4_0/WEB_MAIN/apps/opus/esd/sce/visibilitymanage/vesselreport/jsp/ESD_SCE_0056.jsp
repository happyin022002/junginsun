<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_SCE_0056.jsp
*@FileTitle  : US Inland Operation Report 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================
--%>

<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.sce.visibilitymanage.vesselreport.event.EsdSce0056Event"%>
<%@ page import="com.clt.apps.opus.esd.sce.common.util.basic.CodeUtilBC" %>
<%@ page import="com.clt.apps.opus.esd.sce.common.util.basic.CodeUtilBCImpl" %>

<%
		CodeUtilBC codeUtil = new CodeUtilBCImpl() ;
		EsdSce0056Event  event = null;                		//PDTO(Data Transfer Object including Parameters)
		Exception serverException   = null;            		

		// Pickup Notice Pop-up call
		String eqOfcCd = JSPUtil.getNull(request.getParameter("eq_ofc_cd"));
		String popYn = JSPUtil.getNull(request.getParameter("popYn"));
		
		String strErrMsg = "";                                  
		DBRowSet rowSet      = null;                            //DB ResultSet
		int rowCount     = 0;                                   //DB ResultSet List Count
		SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
    	String userId=account.getUsr_id();

    	try{
	    	serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
	    	if (serverException != null) {
	            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
	        }else{
	        	event = (EsdSce0056Event)request.getAttribute("Event");
	        }
		} catch(Exception e) {
	        out.println(e.toString());
	    }
		
		int rowSize = 3000 ;
%>

<script type="text/javascript">

    function setupPage(){

        loadPage();
    }

</script>

<form method="post" name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" id="row_size" name="row_size" value="<%=rowSize%>">
<input type="hidden" id="coldesc1" name="coldesc1" value="SEQ,BKG,B/L No.,Unmatch List,BKG,BKG,COP,COP,Container,TY/SZ,MVMT,MVMT Yard,MVMT DT,DUP,VVD,Lane,ETA,SPE,Rail DEST,CSTMS\nCLR LOC,EQ Office,Term,Add,Rail,Rail,Rail,Truck(Shuttle),Truck(Shuttle),Truck(Shuttle),Truck(Additional),Truck(Additional),Truck(Additional),Truck(Door),Truck(Door),Truck(Door),Truck(Door),Truck(Door),Truck(Door),Truck(Door),Truck(Door),COP Status,From,Guide,P/UP Node,AVL Date,Free Date,F,O,C,CM,P/UP NO.,P/UP Office,P/UP End,S/C NO.,CNEE,CNEE Address,SHPR,SHPR Address,NTFY,NTFY Address,Filer,IT NO.,IT Date,PO NO.,Seal NO.,Weight,CLM,CLM,CLM,CLM,Remark">
<input type="hidden" id="coldesc2" name="coldesc2" value="SEQ,BKG,B/L No.,Unmatch List,POD,DEL,POD,DEL,Container,TY/SZ,MVMT,MVMT Yard,MVMT DT,DUP,VVD,Lane,ETA,SPE,Rail DEST,CSTMS\nCLR LOC,EQ Office,Term,Add,Plan,S/O,W/O,Plan,S/O,W/O,Plan,S/O,W/O,Plan,S/O,W/O,DR_WK,DR_FM,DR_TO,DR_S/P,DR_S/P Name,COP Status,From,Guide,P/UP Node,AVL Date,Free Date,F,O,C,CM,P/UP NO.,P/UP Office,P/UP End,S/C NO.,CNEE,CNEE Address,SHPR,SHPR Address,NTFY,NTFY Address,Filer,IT NO.,IT Date,PO NO.,Seal NO.,Weight,CLM Status,CLM Location,CLM ST,CLM Date,Remark">
<input type="hidden" id="iCheckRow" name="iCheckRow" value="2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|76|77">
<input type="hidden" id="chkcnt" name="chkcnt" value="76">
<input type="hidden" id="RptInfoCtnt" name="RptInfoCtnt" value="1111111111111111111111111111111111111111111111111111111111111111111111111111">
<input type="hidden" id="pgm_no" name="pgm_no" value="ESD_SCE_0057" >
<input type="hidden" id="totcnt" name="totcnt" >

<%if(popYn.equals("Y")){%>
<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>US Inland Operation Report</span></h2>
		
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
		 --><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!--
		 --><button type="button" class="btn_normal" name="btn_clm" id="btn_clm">CLM</button><!--
		 --><button type="button" class="btn_normal" name="btn_send" id="btn_send">324 EDI Send</button><!--
		 --><button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button><!--
		 --><button type="button" class="btn_normal" name="btn_downcsv" id="btn_downcsv">Down TXT</button><!--
		 --><button type="button" class="btn_normal" name="btn_downonly" id="btn_downonly">Down Only</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
		</div>
	</div>
</div>
<%}else{%>
<div class="page_title_area clear">
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>

	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
		--><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!--
		--><button type="button" class="btn_normal" name="btn_clm" id="btn_clm">CLM</button><!--
		--><button type="button" class="btn_normal" name="btn_send" id="btn_send">324 EDI Send</button><!--
		--><button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button><!--
		--><button type="button" class="btn_normal" name="btn_downcsv" id="btn_downcsv">Down TXT</button><!--
		--><button type="button" class="btn_normal" name="btn_downonly" id="btn_downonly">Down Only</button>
	</div>

   	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
        <span id="navigation"></span>
   	</div>
</div>
<%}%>

<%if(popYn.equals("Y")){%><div class="layer_popup_contents"><%}%>
<!-- opus_design_inquiry(S) -->
	<div class="wrap_search">
		<div class="opus_design_inquiry wFit">
			<!--  MiniLayer (S) -->
			<table>
				
					<tr>
						<th>Date <select name="dateselect" style="width:70px;">
								<option value="E">ETA</option>
								<option value="S">EDI Send</option>
								</select>
						</th>
						<td colspan="3"><input class="input1" type="text" style="width:78px ; text-transform:uppercase;" name="fm_dt" onKeyUp="chkField(this, 'date', false, null, null, '-')" onBlur="chkField(this, 'date', false, null, null, '-')">&nbsp;~&nbsp;<input class="input1" type="text" style="width:78px" name="to_dt" onKeyUp="chkField(this, 'date', false, null, null, '-')" onBlur="chkField(this, 'date', false, null, null, '-')"><button type="button" class="calendar ir" name="btn_calendar" id="btn_calendar"></button></td>
		                <th>Service Provider</th>
		                <td colspan="5">
		                    <input type='text' name='combo_svc_provider'  style="width:82px;" onChange='getTextVendorSeq(sheetObjects[0], document.form, this.value)' onKeyup='enterCheck(this)' dataformat="num"><!--
		                      --><input type="text" name='svc_provider' ReadOnly class="input2" style="width:453px;"><!--
		                      --><button type="button" class="input_seach_btn" name="btng_provider" id="btng_provider"></button>
		                </td>
					</tr>
					<tr>
						<th>Rail Billing Status</th>
						<td><select name="t_rail_billing_sts" style="width:100px;">
							<option value="" selected>All</option>
							<option value="Y">Issued</option>
							<option value="N">NotIssued</option>
							</select>
						</td>
						<th>Truck Status</th>
						<td><select name="t_truck_sts" style="width:100px;">
							<option value="" selected>All</option>
							<option value="Y">Issued</option>
							<option value="N">NotIssued</option>
							</select>
						</td>
						<th>Cost Mode</th>
						<td><select name="t_cost_mode" style="width:100px;">
							<option value="" selected>All</option>
							<option value="R">Rail</option>
							<option value="D">Door</option>
							<option value="S">Shuttle</option>
							<option value="A">Additional(CY)</option>
							</select>
						</td>
						<th>Equipment Office</th>
						<td><input type="text" style="width:100px" name="s_neweq_office" onKeyUp="chkField(this, 'eng_num', true, 5)" value="<%=eqOfcCd%>"></td>						
						<th>EDI Status</th>
						<td><select name="t_edi_sts" style="width:100px;">
								<option value="ALL" selected>All</option>
								<option value="Y">Y</option>
								<option value="N">N</option>
								</select>
						</td>
					</tr>
					<tr>
						<th>S/C No</th>
						<td><input type="text" style="width:100px" name="s_sc_no" onKeyUp="chkField(this, 'eng_num', true, 9)"></td>				
						<th title="Port of Discharging">POD</th>
						<td><input type="text" style="width:100px" name="s_pol_pod" id="s_pol_pod" onKeyUp="chkField(this, 'eng_num', true, 5)">
							<button type="button" class="btn_plus" onClick="openAddPaste('s_pol_pod')"></button></td>
						<th title="Place of Delivery">DEL</th>
						<td><input type="text" style="width:100px" name="s_del" onKeyUp="chkField(this, 'eng_num', true, 5)"></td>
						<th>Rail DEST</th>
						<td><input type="text" style="width:100px" name="s_rail_dest" id="s_rail_dest" onKeyUp="chkField(this, 'eng_num', true, 7)">
							<button type="button" class="btn_plus" onClick="openAddPaste('s_rail_dest')"></button></td>
						<th>End Status</th>
						<td><select name="t_end_sts" style="width:100px;">
							<option value="" selected>All</option>
							<option value="Y">Finished</option>
							<option value="N">Progress</option>
						</select></td>
					</tr>
					<tr>
						<th title="Vessel Voyage Direction">VVD</th>
						<td><input type="text" style="width:100px" name="s_vvd" onKeyUp="chkField(this, 'eng_num', true, 9)"></td>
						<th>Lane</th>
						<td><input type="text" style="width:100px" name="s_lane" onKeyUp="chkField(this, 'eng_num', true, 3)"></td>
						<th>P.No</th>
						<td><select name="t_p_no" style="width:100px;">
							<option value="" selected>All</option>
							<option value="Y">Updated</option>
							<option value="N">NotUpdated</option>
						</select></td>
						<th>P/UP Office</th>
						<td><input type="text" style="width:100px" name="s_pup_office" onKeyUp="chkField(this, 'eng_num', true, 5)"></td>
						<!-- 
						<th>P/UP Status</th>
						<td><select name="t_pup_sts" style="width:100px;">
							<option value="" selected>All</option>
							<option value="I">Issued</option>
							<option value="N">NotIssued</option>
						</select></td> -->
					</tr>
					<tr>
						<th>Booking No</th>
						<td>
							<input type="text" style="width:100px" name="s_bkg_no" id="s_bkg_no" onKeyUp="chkField(this, 'eng_num', true)">
							<button type="button" class="btn_plus" onClick="openAddPaste('s_bkg_no')"></button>
						</td>
						<th>Container No</th>
						<td><input type="text" style="width:100px" name="s_cntr_no" id="s_cntr_no" onKeyUp="chkField(this, 'eng_num', true)">
						    <button type="button" class="btn_plus" onClick="openAddPaste('s_cntr_no')"></button>							
						</td>
						<th>Master BKG</th>
						<td><select name="mst_bkg_sts" style="width:70px;">
							<option value="" selected>All</option>
							<option value="Y">Y</option>
							<option value="N">N</option>
							</select>
						</td>
					</tr>
		</table>
		<!-- 조회영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	</div>
	</div>
	<!-- opus_design_inquiry(E) -->
	
	<div class="wrap_result">
		<div class="opus_design_grid">
			<a href="javascript:openColumnList();" class="purple"><h3 class="title_design pad_btm_8" style="font-weight: bold;">Customized Report Form</h3></a>
			<br/>
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
	</div>

<!-- opus_design_grid(E) -->
<!-- page(E) -->
<%if(popYn.equals("true")){%></div><%}%>
</form>
<span id="new_form"></span>
