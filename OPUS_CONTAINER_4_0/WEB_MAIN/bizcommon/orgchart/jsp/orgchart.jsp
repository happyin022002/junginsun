<%
/*=========================================================
*Copyright(c) 2008 CyberLogitec
*@FileName : orgchart.jsp
*@FileTitle : orgchart 정보조회(공통 Popup)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.3.17
*@LastModifier : 김경범
*@LastVersion : 1.0
* 2009.3.17 김경범
* 1.0 최초 생성
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%
	String cahrt = "";
	if(request.getParameter("Subscriber") != null || !request.getParameter("Subscriber").equals("")){
		cahrt = request.getParameter("Subscriber");
	}
%>
<html>
<script language="javascript" type="text/javascript" src="/opuscntr/js/common/OrganTree.js"></script>
<script language="javascript" type="text/javascript" src="/opuscntr/js/common/HashMap.js"></script>


<script language="javascript">
	function setupPage(){
		loadPage();
	}
</script>

<form name="form">
<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>Organization Chart</span></h2>
		
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_Search" id="btn_Search">Retrieve</button><!--  
			--><button type="button" class="btn_normal" name="btn_Confirm" id="btn_Confirm">Confirm</button><!--
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
						<td>
							<select name="groupBy" id="company" class="input" style="width:90px;" onchange="changeCompany('treeView', this.value)">
								<option value="hjs" selected>HJS</option>
								<option value="clt">CLT</option>
								<option value="sen">SEN</option>
							</select>
						</td>
						<th></th>
						<td align="right">
							<select  name="groupBy" id="search" class="input" style="width:120px; ">
								<option value="NAME" selected>Name (ENG+Local)</option>
								<option value="TEAMNM">Department</option>
								<option value="POS">Title</option>
								<option value="JOB">Job Info</option>
								<option value="CN">User ID</option>
							</select>
							<input type="text" style="width:100;" class="input" value="" name="search_text">
						</td>
						
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	<div class="wrap_result">
		<div class="opus_design_grid" >
			<div class="opus_design_grid">
			<table class="line_bluedot"></table>
				<!-- opus_grid_btn(E) -->
			</div>
			<script language="javascript">ComSheetObject('sheet1');</script>
		</div>
	</div>
</div>
</form>
</html>









<!-- <table width="100%" class="popup" cellpadding="10" border="0">  -->
<!-- <tr><td class="top"></td></tr> -->
<!-- <tr> -->
<!-- 		<td valign="top">Page Title, Historical (S) -->
<!-- 		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title"> -->
<!-- 			<tr> -->
<%-- 			<%if(cahrt.equals("")){ %> --%>
<!-- 				<td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"> People Search</td> -->
<%-- 			<%}else{%> --%>
<!-- 				<td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"> Notified Subscriber Inquiry</td> -->
<%-- 			<%}%> --%>
<!-- 			</tr> -->
<!-- 		</table> -->
<!-- 		<!--Page Title, Historical (E)--> 1 (S) -->
<!-- 		<table class="search">  -->
<!--             <tr><td class="bg"> -->
		
		
<!-- 			<table class="search" border="0"> -->
<!-- 			<tr class="h23"> -->
<!-- 				<td width="200" valign="top"> biz_1  (S) -->
<!-- 				<table class="search" border="0"> -->
<!-- 					<tr class="h23"> -->
<!-- 						<td><select id="company" onchange="changeCompany('treeView', this.value)"> -->
<!-- 							<option value="hjs">HJS</option> -->
<!-- 							<option value="clt">CLT</option> -->
<!-- 							<option value="sen">SEN</option> -->
<!-- 						</select></td> -->
<!-- 					</tr> -->
<!-- 				</table> -->
<!-- 			<!--  biz_1   (E) --> -->

<!-- 			<table class="line_bluedot"><tr><td></td></tr></table> -->

<!-- 			<!-- Grid (S) --> -->
<!-- 			<table id="mainTable"> -->
<!-- 				<tr> -->
<!-- 					<td> -->
<!-- 					<div id="treeView" style="overflow: auto; width: 200px; height: 262px; border-width: 1px; border-style: solid; border-color: #7F9DB9;"></div> -->
<!-- 					</td> -->
<!-- 				</tr> -->
<!-- 			</table> -->
<!-- 			</td> -->
<!-- 			<td width="20"></td> -->
<!-- 			<td valign="top"> biz_1  (S) -->
<!-- 				<table class="search" border="0"> -->
<!-- 					<tr class="h23"> -->
<!-- 						<td align="right"><select id="search"> -->
<!-- 							<option value="NAME">Name (ENG+Local)</option> -->
<!-- 							<option value="TEAMNM">Department</option> -->
<!-- 							<option value="POS">Title</option> -->
<!-- 							<option value="JOB">Job Info</option> -->
<!-- 							<option value="CN">User ID</option> -->
<!-- 						</select> -->
<!-- 						<input type="text" style="width:100;" class="input" value="" name="search_text">&nbsp;</td> -->
<!-- 						<td> -->
<!-- 							<table width="72" border="0" cellpadding="0" cellspacing="0" class="button"> -->
<!-- 								<tr><td class="btn1_left"></td> -->
<!-- 								<td class="btn1" name="btn_Search">Search</td> -->
<!-- 								<td class="btn1_right"></td> -->
<!-- 								</tr> -->
<!-- 							</table> -->
<!-- 						</td> -->
											
<!-- 				</tr> -->
<!-- 				</table> -->
<!-- 			<!--  biz_1   (E) --> -->

<!-- 			<table class="line_bluedot"> -->
<!-- 				<tr> -->
<!-- 					<td></td> -->
<!-- 				</tr> -->
<!-- 			</table> -->

<!-- 			<!-- Grid (S) --> -->
<!-- 			<table id="mainTable" width="100%"> -->
<!-- 				<tr> -->
<!-- 					<td> -->
<!-- 					<script language="javascript">ComSheetObject('sheet1');</script> -->
<!-- 					</td> -->
<!-- 				</tr> -->
<!-- 			</table> -->
<!-- 			</td> -->

<!-- 			</tr> -->
<!-- 		</table> -->
<!-- 		</td> -->
<!-- 	</tr> -->
<!-- </table> -->


<!-- 		</td> -->
<!-- 	</tr> -->
<!-- </table> -->

<!-- <table class="height_10"><tr><td></td></tr></table> -->


<!-- <!-- : ( Button : Sub ) (S) --> -->
<!-- <table width="100%" class="sbutton"> -->
<!-- <tr><td height="71" class="popup"> -->

<!-- 			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">  -->
<!--        		<tr><td class="btn3_bg"> -->
<!-- 		    	<table border="0" cellpadding="0" cellspacing="0"> -->
<!-- 		    	<tr> -->
<!-- 		    		<td> -->
<!-- 							<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button"> -->
<!-- 								<tr><td class="btn1_left"></td> -->
<!-- 								<td class="btn1" name="btn_Confirm">Confirm</td> -->
<!-- 								<td class="btn1_right"></td> -->
<!-- 								</tr> -->
<!-- 							</table> -->
<!-- 						</td> -->
<!-- 						<td> -->
<!-- 							<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button"> -->
<!-- 								<tr><td class="btn1_left"></td> -->
<!-- 								<td class="btn1" name="btn_Close">Close</td> -->
<!-- 								<td class="btn1_right"></td> -->
<!-- 								</tr> -->
<!-- 							</table> -->
<!-- 						</td> -->
<!-- 				</tr> -->
<!-- 				</table> -->
<!-- 			</td></tr> -->
<!-- 			</table> -->

<!-- </td></tr> -->
<!-- </table> -->
<!-- <!-- : ( Button : Sub ) (E) --> -->

<!-- </BODY> -->

<!-- </HTML> -->
<%--  <%@include file="../../include/common_alps.jsp"%> --%>