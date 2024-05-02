<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : vop_vsk_0211.jsp
*@FileTitle : VSL Voyage Check
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/14
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.event.VopVsk0211Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import = "com.clt.framework.component.util.StringUtil" %>  
<% 
	VopVsk0211Event  	event 				= null;					//PDTO(Data Transfer Object including Parameters)
	Exception 			serverException   	= null;			//error from server
	String 				strErrMsg 			= "";						//error message
	int 				rowCount	 		= 0;						//count of DB ResultSet list
	
	String 				successFlag 		= "";
	String 				codeList  			= "";
	String 				pageRows  			= "100";

	String 				strUsr_id			= "";
	String 				strUsr_nm			= "";
	Logger 				log 				= Logger.getLogger("com.clt.apps.scheduleplanningoperation.vesselschedulemgt");
	
	String 				vsl_cd 				= request.getParameter("vsl_cd");
	String 				skd_voy_no 			= request.getParameter("skd_voy_no");
	String 				start_date 			= request.getParameter("start_date");
	String 				end_date 			= request.getParameter("end_date");
	String 				vsl_cnt 			= request.getParameter("vsl_cnt");
	String 				voy_no_type 		= request.getParameter("voy_no_type");
	String 				voy_type_cnt 		= request.getParameter("voy_type_cnt");
	String 				skd_dir_cd_1 		= request.getParameter("skd_dir_cd_1");
	String 				skd_dir_cd_2 		= request.getParameter("skd_dir_cd_2");
	String 				duration 			= request.getParameter("duration");
	
	vsl_cd 									= vsl_cd		==null?"":vsl_cd.trim();
	skd_voy_no 								= skd_voy_no	==null?"":skd_voy_no.trim();
	end_date 								= start_date	==null||end_date==null?"":end_date.trim();
	start_date 								= start_date	==null?"":start_date.trim();
	
	vsl_cnt 								= vsl_cnt		==null?"":vsl_cnt.trim();
	voy_no_type 							= voy_no_type	==null?"":voy_no_type.trim();
	voy_type_cnt 							= voy_type_cnt	==null?"":voy_type_cnt.trim();
	skd_dir_cd_1 							= skd_dir_cd_1	==null?"":skd_dir_cd_1.trim();
	skd_dir_cd_2 							= skd_dir_cd_2	==null?"":skd_dir_cd_2.trim();
	duration 								= duration		==null?"":duration.trim();
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
		event = (VopVsk0211Event)request.getAttribute("Event");
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
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>


<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="vsl_cd" 			value='<%=StringUtil.xssFilter(vsl_cd)%>'>
<input type="hidden" name="skd_voy_no" 		value='<%=StringUtil.xssFilter(skd_voy_no)%>'>
<input type="hidden" name="start_date" 		value='<%=StringUtil.xssFilter(start_date)%>'>
<input type="hidden" name="end_date" 		value='<%=StringUtil.xssFilter(end_date)%>'>
<input type="hidden" name="vsl_cnt" 		value='<%=StringUtil.xssFilter(vsl_cnt)%>'>
<input type="hidden" name="voy_no_type" 	value='<%=StringUtil.xssFilter(voy_no_type)%>'>
<input type="hidden" name="voy_type_cnt" 	value='<%=StringUtil.xssFilter(voy_type_cnt)%>'>
<input type="hidden" name="skd_dir_cd_1" 	value='<%=StringUtil.xssFilter(skd_dir_cd_1)%>'>
<input type="hidden" name="skd_dir_cd_2" 	value='<%=StringUtil.xssFilter(skd_dir_cd_2)%>'>
<input type="hidden" name="duration" 		value='<%=StringUtil.xssFilter(duration)%>'>
 
 <div class="layer_popup_title">	
	<div class="page_title_area clear">
		<h2 class="page_title"><span>Vessel Voyage Pre-Checking</span></h2>
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_simulation"	id="btn_simulation">Simulation Start</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_close"	id="btn_close">Close</button>
			
	    </div>
	</div>
</div>
 
<div class="layer_popup_contents">
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<div class="opus_design_inquiry">
		<table class="grid2" border="0" style="width:100%;"> 
			<tr class="tr2_head">
				<td align="left">Remark</td>
			</tr>	
			<tr>
				<td>
					<textarea style="width:100%;height:50" name="remark" id="remark" readonly></textarea>
				</td>
			</tr>	
		</table>	
	</div>
		
</div>

</form>			

