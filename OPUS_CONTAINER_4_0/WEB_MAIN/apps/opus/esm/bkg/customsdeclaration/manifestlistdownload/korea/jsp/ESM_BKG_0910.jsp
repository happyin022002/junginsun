<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_BKG_0910.jsp
*@FileTitle  : << Korea Main Menu >>
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/30
=========================================================
--%>

<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<script type="text/javascript">
    function setupPage(){  
	    loadPage();
    }
</script> 

<form name="form">
<input type="hidden" name="f_cmd" value="">

<!-- OUTER - POPUP (S)tart -->


<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
    <h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
    <!-- page_title(E) -->
    
    <!-- page_location(S) -->
    <div class="location">
        <span id="navigation"></span>
    </div>
    <!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->


<!-- layout_wrap(S) -->
<div class="layout_wrap">
    <div class="sm pad_rgt_12 pad_left_12 pad_btm_8 pad_top_8 mar_top_12">
		<h3 class="title_design">Manifest Preparation</h3>		
		<table>
			<colgroup>
				<col width="150" />
				<col width="*" />
			</colgroup>
			<tbody>
				<tr>
					<td class="pad_btm_4">						
						<button type="button" style="width:140px" class="btn_etc align_left" name="btn_mrnCreate" id="btn_mrnCreate" >1. MRN Create</button>
					</td>
					<td class="pad_btm_4">					
						<button type="button" style="width:320px" class="btn_etc align_left" name="btn_manifestGen" id="btn_manifestGen" >1. Manifest Generate</button>
					</td>
				</tr>
				<tr>
					<td class="pad_btm_4">					
						<button type="button" style="width:140px" class="btn_etc align_left" name="btn_mrnInquiry" id="btn_mrnInquiry" >2. MRN Inquiry</button>
					</td>
					<td class="pad_btm_4">					
						<button type="button" style="width:320px" class="btn_etc align_left" name="btn_whAssign" id="btn_whAssign" >2. Warehouse Assign by B/L</button>
					</td>
				</tr>
				<tr>
					<td></td>
					<td class="pad_btm_4">				
						<button type="button" style="width:320px" class="btn_etc align_left" name="btn_printIfm" id="btn_printIfm" >3. Print IFM by VVD / POL</button>
					</td>
				</tr>
				<tr>
					<td></td>
					<td class="pad_btm_4">				
						<button type="button" style="width:320px" class="btn_etc align_left" name="btn_printDisch" id="btn_printDisch" >4. Print Discharging CY Declare List by VVD</button>
					</td>
				</tr>
			</tbody>
		</table>
		
		<h3 class="title_design">Stage 1 : Transmission</h3>
		<table>
			<colgroup>
				<col width="*" />
			</colgroup>
			<tbody>
				<tr>
					<td class="pad_btm_4">				
						<button type="button" style="width:390px" class="btn_etc align_left" name="btn_downLoad" id="btn_downLoad" >1. Data Download & Transmit</button>
					</td>
				</tr>
			</tbody>
		</table>
		
		<h3 class="title_design">Stage 2 : Amendment</h3>
		<table>
			<colgroup>
				<col width="*" />
			</colgroup>
			<tbody>
				<tr>
					<td class="pad_btm_4">				
						<button type="button" style="width:390px" class="btn_etc align_left" name="btn_amendTrans" id="btn_amendTrans" >1. Amendment Transmit</button>
					</td>
				</tr>
			</tbody>
		</table>
		
		<h3 class="title_design">Stage 3 : Closing</h3>
		<table>
			<colgroup>
				<col width="*" />
			</colgroup>
			<tbody>
				<tr>
					<td class="pad_btm_4">					
						<button type="button" style="width:390px" class="btn_etc align_left" name="btn_transHist" id="btn_transHist" >1. Transmit History</button>	
					</td>
				</tr>
				<tr>
					<td class="pad_btm_4">					
						<button type="button" style="width:390px" class="btn_etc align_left" name="btn_recvHist" id="btn_recvHist" >2. Receive History</button>
					</td>
				</tr>
				<tr>
					<td class="pad_btm_4">				
						<button type="button" style="width:390px" class="btn_etc align_left" name="btn_transCargo" id="btn_transCargo" >3. Transmit DG Cargo Manifest</button>
					</td>
				</tr>
				<tr>
					<td class="pad_btm_4">				
						<button type="button" style="width:390px" class="btn_etc align_left" name="btn_transVessel" id="btn_transVessel" >4. Transmit Vessel Inform and Manifest</button>
					</td>
				</tr>
				<tr>
					<td class="pad_btm_4">				
						<button type="button" style="width:390px" class="btn_etc align_left" name="btn_downloadHist" id="btn_downloadHist" >5. Download History</button>					
					</td>
				</tr>
				<tr>
					<td class="pad_btm_4">				
						<button type="button" style="width:390px" class="btn_etc align_left" name="btn_cargoPrint" id="btn_cargoPrint" >6. Cargo Manifest print by B/L No</button>					
					</td>
				</tr>
				<tr>
					<td class="pad_btm_4">				
						<button type="button" style="width:390px" class="btn_etc align_left" name="btn_genCargoManifest" id="btn_genCargoManifest" >7. General Cargo Manifest by VVD/PORT</button>					
					</td>
				</tr>
			</tbody>
		</table>
	</div>		
</div>			
</form>