<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_COA_0002.jsp
*@FileTitle  : Register C/A Code 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/03
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.apps.opus.esm.coa.stdunitcost.coststructure.event.EsmCoa0002Event"%>

<%
    EsmCoa0002Event  event = null;              //PDTO(Data Transfer Object including Parameters)
    GeneralEventResponse eventResponse = null;  //RDTO(Data Transfer Object including DB ResultSet)

    Exception serverException   = null;         //Error from server
    String strErrMsg = "";                               //Error message

    String userId   = "";
    String userName = "";

    try {

        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        userId    = account.getUsr_id();
        //userAuth=account.getAuth();
        userName  = account.getUsr_nm();

        event = (EsmCoa0002Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

    }catch(Exception e) {
        out.println(e.toString());
    }
%>

<script type="text/javascript">
    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            ComShowMessage(errMessage);
        } // end if

        loadPage();
    }
</script>

<form name = "hiddenF" method="post" onKeyDown="ComKeyEnter();">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="sRow" value="" id="sRow" />
<input type="hidden" name="changeCol" value="" id="changeCol" />
<input type="hidden" name="changeValue" value="" id="changeValue" />
</form>
<form method="post" name="form" onKeyDown="ComKeyEnter();">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="iPage" id="iPage" />
<input type="hidden" name="cond1" value="1" id="cond1" />

	<!-- page_title_area(S) -->
	<div class="page_title_area clear">

		<!-- page_title(S) -->
	    <!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
		<!-- page_title(E) -->

		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_retrieve" id="btn_retrieve">Retrieve</button>
			<button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button>			
			<button type="button" class="btn_accent" name="btn_officecreation" id="btn_officecreation">Office Creation</button>

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
	<!--Page Title, Historical (E)-->


	<div class="wrap_search">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry">
			<!--  MiniLayer (S) -->
			<table>
				<colgroup>
					<col width="250" />					
					<col width="200" />
					<col width="45" />
					<col width="" />
				</colgroup>
				<tbody>
					<tr>						
						<th>
							<input type="radio" value="1" class="trans" name="code" id="code" checked /><label for="code_1">Cost Element</label><!-- 
                			 --><input type="radio" value="2" class="trans" name="code" id="code_2" onClick="goURL(2)"><label for="code_2">So Cost Code</label>
						</th>
						<th>Cost Year Month</th>
						<td>
							<input type="text" size="10" name="f_cost_yrmon" maxlength="6" style="ime-mode:disabled;" onkeypress="ComKeyOnlyNumber(this)" onKeyDown="ComKeyEnter();" onbeforedeactivate="ComAddSeparator(this)" onbeforeactivate="ComClearSeparator(this)" dataformat="ym" id="f_cost_yrmon" />
							
						</td>
						<td>
							<button type="button" class="btn_etc" name="btng_update" id="btng_update">Month Update</button>
						</td>
					</tr>
				</tbody>						
			</table>
		</div>
	</div>

	<div class="wrap_result">		
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid" id="mainTable">			
			<table>			
			  <tr>
				<td><h3 class="title_design">Register Cost Items</h3></td>					
					<td style="text-align:right;padding-bottom:4px">	
					<!-- SJH.20141226.ADD -->					
						<button type="button" class="btn_etc" onclick="javascript:ComOpenWindow2('ESM_COA_0130.do','','width=800,height=400, menubar=0, scrollbars=0, resizable=yes');">Report View Management</button>
						<button type="button" class="btn_etc" onclick="javascript:ComOpenWindow2('ESM_COA_0001.do','','width=500,height=500, menubar=0, scrollbars=0, resizable=yes')">Set List-boxes</button>
					<!--<img class="cursor" src="/opuscntr/img/opus/ico_newwin.gif" width="11" height="12" align="absmiddle" hspace="5">&nbsp; 
						 <a href="javascript:ComOpenWindow2('ESM_COA_0130.do','','width=800,height=400, menubar=0, scrollbars=0, resizable=yes');" class="purple"> Report View Management</a>&nbsp;&nbsp; 
                		 <img class="cursor" src="/opuscntr/img/opus/ico_newwin.gif" width="11" height="12" align="absmiddle" hspace="5">&nbsp;
                		 <a href="javascript:ComOpenWindow2('ESM_COA_0001.do','','width=500,height=500, menubar=0, scrollbars=0, resizable=yes')" class="purple">Set List-boxes</a>-->		
					</td>
				</tr>
			</table>
			<!-- opus_design_btn(S) -->
	        <div class="opus_design_btn">	        			
	            <button type="button" class="btn_normal" name="btng_rowadd" id="btng_rowadd">Row Add</button><!--
	            --><button type="button" class="btn_normal" name="btng_save" id="btng_save">Save</button>
	        </div>
	        <!-- opus_design_btn(E) -->			
	        <!-- opus_design_btn(E) --> 
			<!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
		    <script type="text/javascript">ComSheetObject('sheet1');</script>
		    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
		</div>
		<!-- opus_design_grid(E) -->
	</div>
</form>