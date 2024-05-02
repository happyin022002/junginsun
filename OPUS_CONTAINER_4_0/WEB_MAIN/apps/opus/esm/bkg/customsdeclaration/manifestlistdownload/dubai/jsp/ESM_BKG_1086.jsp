<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   ESM_BKG_1086.jsp
*@FileTitle  : ACI_Vessel Information 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/28
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.dubai.event.EsmBkg1086Event"%>
<%--<%@ page import="com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.us.event.EsmBkg0748Event"%> --%>
<%@ page import="org.apache.log4j.Logger" %>


<script type="text/javascript">
	function setupPage(){
		loadPage();
	
	}
</script>


<form name="form" id="form" method="post">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<!-- layer_popup_title(S) -->
 <div class="layer_popup_title">
    <!-- page_title_area(S) -->
    <div class="page_title_area clear">
        <!-- page_title(S) -->
        
        <h2 class="page_title"><span>Dubai Inbound Manifest – Package Unit</span></h2>
        <!-- page_title(E) -->
            
        <!-- opus_design_btn(S) -->
        <div class="opus_design_btn">
		<% if (request.getParameter("select") != null) { %><!--
			--><button type="button" class="btn_accent" name="btn_Select" id="btn_Select">Select</button><!--
		--><% } %><!--
			--><button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--  
			--><button type="button" class="btn_normal" name="btn_Save" id="btn_Save">Save</button><!--  
			--><button type="button" class="btn_normal" name="btn_Close" id="btn_Close" >Close</button>
        </div>
        <!-- opus_design_btn(E) --> 
    </div>
    <!-- page_title_area(E) -->
</div>
<!-- layer_popup_title(E) -->
	
	<div class="layer_popup_contents">
	<!-- opus_design_grid(S) -->
		<div class="wrap_search">
			<div class="opus_design_inquiry wFit">
			    <!-- 조회영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
			    <table>
			        <colgroup>
			            <col width="90px" />
			            <col width="100px" />
			            <col width="" />    	            
			        </colgroup>
			        <tbody>
						<tr>
							<th>Dubai PKG TP</th>
							<td>
								<input type="text" style="width:80;ime-mode:disabled" name="attr_ctnt1" caption="PKG TP" dataformat="engup">
							</td>
							<th>OPUS PKG TP</th>
							<td>
								<input type="text" style="width:80;ime-mode:disabled" name="attr_ctnt3" caption="PKG TP" dataformat="engup">
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		<!-- opus_design_grid(E) -->
		<div class="wrap_result">
			<div class="opus_design_grid">
		   		<!-- opus_design_btn(S) -->
	 		   <div class="opus_design_btn">
			        <!-- 그리드 버튼 영역(데이터 그리드 상단에 위치) -->
			        <!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
			        <button type="button" class="btn_normal" name="btn_RowAdd" id="btn_RowAdd">Row Add</button>
			        <button type="button" class="btn_normal" name="btn_RowDelete" id="btn_RowDelete">Row Delete</button>
			    </div>
			    <!-- opus_design_btn(E) -->
			    <!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
			    <script type="text/javascript">ComSheetObject('sheet1');</script>
			    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
			</div>
		</div>
	</div>
</form>
