<%--=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_SCE_0024.jsp
*@FileTitle : COP Scheduling Logic Registration
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 
=========================================================--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.apps.opus.esd.sce.common.util.basic.CodeUtilBCImpl" %>
<%@ page import="com.clt.apps.opus.esd.sce.common.util.basic.CodeUtilBC" %>
<%@ page import="com.clt.framework.component.util.DateTime" %>

<%
	CodeUtilBC codeUtil = new CodeUtilBCImpl() ;
%>

<script language="javascript">
	<%=codeUtil.searchCodeComboSheet("actCD", "mdm_activity", "act_cd", "act_cd", "act_tp_cd='T' AND act_flg='Y'", null)%>
	<%=codeUtil.searchCodeNameListJsArray(true, "actNames","mdm_activity", "act_cd", "act_nm", "act_tp_cd='T' AND act_flg='Y'")%>
	var today = "<%=DateTime.getShortDateString()%>" ;

    function setupPage(){
	    loadPage();

       /*****************************************************************/
    }

</script>

<form name="form" id="from">
<input type="hidden" name="f_cmd">



	<!-- page_title_area(S) -->
	<div class="page_title_area clear ">
		<!-- page_title(S) -->
		<h2 class="page_title">
			<button type="button">
				<span id="title">COP Scheduling Logic</span>
			</button>
		</h2>
		<!-- page_title(E) -->
	
		    <!-- opus_design_btn(S) -->
		    <div class="opus_design_btn">
		        <!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
				<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_save"   id="btn_save">Save</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_downexcel"   id="btn_downexcel">Down Excel</button>
		    </div>
		    <!-- opus_design_btn(E) -->
	    
		<!-- page_location(S) -->
		<div class="location">
			<!-- location 내용 동적생성 (별도 코딩 불필요) -->
			<span id="navigation"></span>
		</div>
		<!-- page_location(E) -->
	
	</div>
	<!-- page_title_area(E) -->
	
	
<!-- wrap_result(S) -->
<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry">
	    <!-- 조회영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    <table>
	         <colgroup>
	            <col width="60px" />
	            <col width="" />
	        </colgroup> 
	        <tbody>
				<tr class="h23">
					<th>Logic No.</th>
					<td>
						<%=codeUtil.searchCodeCombo("p_cop_skd_lgc_no","sce_cop_skd_lgc","DISTINCT cop_skd_lgc_no a","cop_skd_lgc_no b", "a", "style='width:150;'; onChange='changeLogicNo()';", "1::ALL")%>
					</td>
					
				</tr>
				
			</tbody>
		</table>
	    <!-- 조회영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	</div>
</div>
	<!-- opus_design_inquiry(E) -->

<div class="wrap_result" >
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid"  id="mainTable">
	    
	    <!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    <script language="javascript">ComSheetObject('sheet1');</script>
	    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    
	</div>
	<!-- opus_design_grid(E) -->
</div>
<!-- wrap_result(E) -->	
	
</form>

