<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_EQR_1057.jsp
*@FileTitle  : Match-back by Vessel
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/08
=========================================================*/
%>     
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.eqr.cntrcodconfirm.emptycodadjustment.event.EesEqr1057Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.component.util.StringUtil"%>
<%
	EesEqr1057Event  event = null;              //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         
    String strErrMsg = "";                      
    int rowCount     = 0;                       //DB ResultSet

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    String tVvd = "";
    String tPod = "";
    String tVersion = "";
//    Logger log = Logger.getLogger("com.clt.apps.cntrcodconfirm.emptycodadjustment");

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();


        event = (EesEqr1057Event)request.getAttribute("Event");
        tVvd = (String)request.getParameter("vvd");
        tPod = (String)request.getParameter("pod");
        tVersion = (String)request.getParameter("version");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

    }catch(Exception e) {
        out.println(e.toString());
    }
%>
<script language="javascript">
    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            ComShowMessage(errMessage);
        } // end if
        loadPage();
    }
</script>
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="version" value="<%= StringUtil.xssFilter(tVersion) %>">

<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>Hanger Rack MTY CNTR List</span></h2>
		
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
			 --><button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button><!--
			 --><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
		</div>
	</div>
</div>

<div class="layer_popup_contents">
	<div class="wrap_search">
		<div class="opus_design_inquiry">
			<table>
				<tbody>
					<tr>
	                	<th width="30">VVD</th>
		                <td width="90"><input type="text" id="vvd" name="vvd" style="width:80px;ime-mode:disabled" class="input1" dataformat="engup" maxlength="9" value="<%= StringUtil.xssFilter(tVvd) %>" ></td>
		                <th width="30">POD</th>
		                <td>
		                    <select style="width:90px;" class="input" id="pod" name="pod">
		                    <option value="" selected></option>
		                    </select>
		                </td>
	            	</tr> 
				</tbody>
			</table>
		</div>
	</div>

	<div class="wrap_result">
		<div class="layout_wrap">
		
	    	<div class="layout_vertical_2 pad_rgt_4">
		        <div class="opus_design_grid"  id="mainTable">
		        	<h3 class="title_design">Source : Master</h3>
			    	<script type="text/javascript">ComSheetObject('sheet1');</script>
		   		</div>
		    </div>
		    
	    	<div class="layout_vertical_2 pad_left_4">
		        <div class="opus_design_grid"  id="mainTable">
		        	<h3 class="title_design">Source : MTY BKG</h3>
			    	<script type="text/javascript">ComSheetObject('sheet2');</script>
		   		</div>
		    </div>
		    
		</div>

		<div class="opus_design_grid" >
			<script language="javascript">ComSheetObject('sheet3');</script>
		</div>
	</div>
</div>

</form>