<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_PRD_0083.jsp
*@FileTitle  : Product Catalog - Optimal Route Validation Check
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/15
=========================================================
--%>


<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.event.EsdPrd0083Event"%>
<%@ page import="com.clt.framework.core.controller.DefaultViewAdapter"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsdPrd0083Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
 
	//Logger log = Logger.getLogger("com.clt.apps.ProductCatalogManage.ProductCatalogManage");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);

		event = (EsdPrd0083Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
 
		DefaultViewAdapter adapter = new DefaultViewAdapter();   
 
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
 
<script language="javascript">
    function setupPage(){  
	    loadPage();
    }
</script>

<form name="form">
<input type="hidden" name="f_cmd" value="<%=JSPUtil.getParameter(request, "f_cmd") %>">
<input type="hidden" name="pctl_no" value="<%=JSPUtil.getParameter(request, "pctl_no") %>">
<input type="hidden" name="callFunc" value="<%=JSPUtil.getParameter(request, "func") %>">
<input type="hidden" name="valRmk" value="">

<div class="layer_popup_title">
    <!-- page_title_area(S) -->
    <div class="page_title_area clear">
        <!-- page_title(S) -->
        <h2 class="page_title">
            <span>Optimal Route Validation Check</span>
        </h2>
        <!-- page_title(E) -->

        <!-- opus_design_btn(S) -->
        <div class="opus_design_btn">
        	<button type="button" class="btn_normal" name="btn_ok" id="btn_ok">Select</button><!-- 
             --><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
        </div>
        <!-- opus_design_btn(E) --> 
    </div>
<!-- page_title_area(E) -->
</div>


<div class="layer_popup_contents">
	<div class="opus_design_inquiry wrap_result">
		<h3> 
			You just have selected the route with more t/s port or more cost than the optimal route in <br/>
			the first row. Please select the one reason for using of the route among the reasons below.
		</h3>
	
		<table class="search sm">
		<colgroup>
			<col width="150" />
				<col width="*" />
		</colgroup> 
		<tbody>
		<tr style="height:5px"> 
			<td colspan="2"></td>	
			</tr>
			<tr>
				<th class="align_left" style="padding-left:3px">
					<input type="radio" class="trans" name="valChkRadio" id="valChkR1" value="S" checked="checked" /><label for="valChkR1">Space Shortage</label>
				</th>
			</tr>
			<tr>
				<td class="pad_left_12">
					( Over Space Lane/VVD : 
				</td>
				<td>
					<input type="text" id="valRmk1" name="valRmk1" maxlength="100" style="width:370px;" value="" /> )
				</td>
			</tr>
			<tr>
				<th class="align_left" style="padding-left:3px">
					<input type="radio" class="trans" name="valChkRadio" id="valChkR2" value="P" /><label for="valChkR2">Port Skip</label>
				</th>
			</tr>
			<tr>
				<td class="pad_left_12">
					( Skipped Port/Lane : 			
				</td>
				<td>
					<input type="text" id="valRmk2" name="valRmk2" maxlength="100" style="width:370px;" value="" /> )			
				</td>
			</tr>
			<tr>
				<th class="align_left" style="padding-left:3px">
					<input type="radio" class="trans" name="valChkRadio" id="valChkR3" value="V" /><label for="valChkR3">VSL Phase Out</label>
				</th>
			</tr>
			<tr>
				<td class="pad_left_12">
					( Phased Port/Lane :
				</td>
				<td>
						<input type="text" id="valRmk3" name="valRmk3" maxlength="100" style="width:370px;" value="" /> )
				</td>
			</tr>
			<tr>
				<th class="align_left" style="padding:3px 0 0 3px">
					<input type="radio" class="trans" name="valChkRadio" id="valChkR4" value="R" /><label for="valChkR4">Customer Request</label>
				</th>
			</tr>
			<tr>
				<td> </td>
			</tr>
			<tr>
				<th class="align_left" style="padding:3px 0 0 3px">
					<input type="radio" class="trans" name="valChkRadio" id="valChkR5" value="C" /><label for="valChkR5">Customs Problems</label>
				</th>
			</tr>
			<tr>
				<td> </td>
			</tr>
			<tr>
				<th class="align_left" style="padding:3px 0 0 3px">
					<input type="radio" class="trans" name="valChkRadio" id="valChkR6" value="E" /><label for="valChkR6">Clerical Error</label>
				</th>
			</tr>
			<tr>
				<td> </td>
			</tr>
			</table>
			<table class="search sm">
		<colgroup>
			<col width="144" />
				<col width="*" />
		</colgroup> 
		<tbody>
			<tr>
				<th class="align_left" style="padding-left:3px">
					<input type="radio" class="trans" name="valChkRadio" id="valChkR7" value="Z" /><label for="valChkR7">The Others</label>				
				</th>
				<td>
					( <input type="text" id="valRmk4" name="valRmk4" maxlength="100" style="width:370px;" value="" /> )
				</td>
			</tr>
			<tr style="height:5px"> 
			<td colspan="2"></td>	
			</tr>
			</tbody>
		</table>
	</div>
	
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	
</div>
</form>			
