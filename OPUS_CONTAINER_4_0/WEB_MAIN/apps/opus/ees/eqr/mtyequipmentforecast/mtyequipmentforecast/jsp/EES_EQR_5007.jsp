<%@ page contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger" %>

<script language="javascript">
	function setupPage(){
	}
</script>

<form name="form">
<!-- OUTER - POPUP (S)tart -->
<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>Evaluation Rule</span></h2>
		
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_Close" id="btn_Close" onclick="window.close();">Close</button>
		</div>
	</div>
</div>

<div class="layer_popup_contents">
	<div class="wrap_search">
		<div class="opus_design_inquiry wFit">
			<table> 
				<tbody>
					<tr class="h23">
						<td style="padding: 0 0 10 0; color: #505151;">◎ Diff. (%) Formula = Diff. Vol ÷ FCST</td>
					</tr>
					<tr class="">
						<td style="padding: 0 0 15 0; color: #505151;">
						1) ECC’s Each EQ ;  (FCST – PFMC) ÷ FCST<br>      
					    2) ECC’s Total EQ ;  {Sum of abs(all EQ’s FCST – PFMC)} ÷ Sum of all EQ’s FCST<br>
					    3) Total’s Each EQ ; {Sum of abs(each EQ’s FCST – PFMC)} ÷ Sum of each EQ’s FCST<br>
					    4) Total’s Total EQ ; {Sum of abs(all EQ’s FCST – PFMC)} ÷ Sum of all EQ’s FCST<br>
					        * abs = abbreviation of absolute value         
						</td>
					</tr>
					<tr class="h23">
						<td style="padding: 0 0 10 0; color: #505151;">◎ Accuracy Evaluation (by Diff.(%) Range)</td>
					</tr>
					<tr class="">
						<td style="padding: 0 0 15 0; color: #505151;">
						    1) Excellent ; -3.0≤~0 ≤ 3.0%          2) Good ; ±3.0＜~≤±7.0%<br>
						    3) Not Good ; ±7.0%＜~≤±12.0%     4) Poor ; Over ±12%
  
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</div>
</form>