<%--/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_COMMON.jsp
*@FileTitle : getting scenario id
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.eqr.common.eqrcommon.event.EesCommonEvent"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.apps.opus.ees.eqr.common.eqrcommon.vo.EesCommonVO"%>
<%
	EesCommonEvent  event = null;							//PDTO(Data Transfer Object including Parameters)
	GeneralEventResponse eventResponse = null;			//RDTO(Data Transfer Object including DB ResultSet)
	Exception serverException   = null;						//error from server
	DBRowSet rowSet	  = null;							    //DB ResultSet
	String strErrMsg = "";								    //error message
	int      rowCount	 = 0;								    //count of DB resultSET list
	String   scnr_rmk  ="";
	String   type = "";
	
	String[] info 						= null;
	String[] info1 						= null;
	String[] info2 						= null;
	String   info3 						= null;
	String[] info4 						= null;
	String   info5 						= null;
	String   st_year 					= "";
	String   st_month 				= "";
	String   st_weekly 				= "";
	String   end_year 				= "";
	String   end_month 				= "";
	String   end_weekly 			= "";
	String   perfix_month 		= "";
	String   title_month 			= "";
	String   perfix_weekly 		= "";
	String   title_weekly 		= "";
	String   perfix_monthly 	=	"";
	String   monthly_count 		=	"";
	String   max_weekly 			= "";
	String   max_plnYr 				= "";
	String   max_plnMon 			= "";
	String   max_plnYrWk 			= "";
	String   todayWeekly 			= "";
	
	
	try {
		//SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		//userId=account.getUsr_id();
		//userAuth=account.getAuth(); 
	  	event = (EesCommonEvent)request.getAttribute("Event");
	  
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}else{
			eventResponse = (GeneralEventResponse)request.getAttribute("EventResponse");
			if (eventResponse != null) {
				EesCommonVO eesCommonVO = (EesCommonVO)eventResponse.getCustomData("RetVO");
				rowSet = eesCommonVO.getRowSet();
				//getting year, month, week
				info = eesCommonVO.getResultset();
				// getting month title
				info1 = eesCommonVO.getResultset1();
				// getting week title
				info2 = eesCommonVO.getResultset2();
				// getting month with week
				info3 = eesCommonVO.getResultset3();
				// getting max week
				info4 = eesCommonVO.getResultset4();
				// getting current year, week
				info5 = eesCommonVO.getResultset5();
				
				if(rowSet != null ){
					rowCount = rowSet.getRowCount();
					 while (rowSet.next()) {
					 scnr_rmk = JSPUtil.getNull(rowSet.getString("SCNR_RMK"));
					 type     = JSPUtil.getNull(rowSet.getString("STATUS"));
					 }
				}
				
				st_year 				= JSPUtil.getNull(info[0]);    // starting year
				st_weekly 				= JSPUtil.getNull(info[1]);   // strarting week 
				st_month 				= JSPUtil.getNull(info[2]);   // strarting month 
				end_year 				= JSPUtil.getNull(info[3]);    // ending year 
				end_weekly 				= JSPUtil.getNull(info[4]); // ending week. 
				end_month 				= JSPUtil.getNull(info[5]);   // ending month .
				perfix_month 			= JSPUtil.getNull(info1[0]);  
				title_month 			= JSPUtil.getNull(info1[1]);    
				perfix_weekly 			= JSPUtil.getNull(info2[0]);  
				title_weekly 			= JSPUtil.getNull(info2[1]);   
				perfix_monthly 			= JSPUtil.getNull(info2[2]); 
				monthly_count 			= JSPUtil.getNull(info3);  
				
				max_plnYr 				= JSPUtil.getNull(info4[3]); 
				max_weekly 				= JSPUtil.getNull(info4[4]); 
				max_plnMon  			= JSPUtil.getNull(info4[5]); 
				max_plnYrWk 			= max_plnYr + max_weekly; 
				todayWeekly 			= JSPUtil.getNull(info5);	
				
			} // end if
		} // end else
	}catch(Exception e) {
		out.println(e.toString());
	}
	
%>
<html>
<head>
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	function push()
	{
	
	    var keycheked = "<%=type%>";
	  	
	    if (keycheked != "") {
	        parent.document.form.scnr_rmk.value = document.form.remark.value;
	        parent.document.form.scnr_rmk.title = document.form.remark.value;
	        parent.document.form.st_year.value = "<%=st_year%>";
	        parent.document.form.st_month.value = "<%=st_month%>";
	        parent.document.form.st_weekly.value = "<%=st_weekly%>";
	        parent.document.form.end_year.value ="<%=end_year%>";
	        parent.document.form.end_month.value ="<%=end_month%>";
	        parent.document.form.end_weekly.value = "<%=end_weekly%>";
	        parent.document.form.perfix_month.value = "<%=perfix_month%>";
	        parent.document.form.title_month.value ="<%=title_month%>";
	        parent.document.form.perfix_weekly.value ="<%=perfix_weekly%>";
	        parent.document.form.title_weekly.value = "<%=title_weekly%>";
	        parent.document.form.monthly_count.value = "<%=monthly_count%>";
	        parent.document.form.status_type.value = "<%=type%>";
	        parent.document.form.max_weekly.value = "<%=max_weekly%>";
	        parent.document.form.max_plnYrWk.value = "<%=max_plnYrWk%>"; //  
	        if(parent.document.form.max_plnYr != null )  	parent.document.form.max_plnYr.value = "<%=max_plnYr%>";
	        if(parent.document.form.max_plnMon != null )  	parent.document.form.max_plnMon.value = "<%=max_plnMon%>";
	        if(parent.document.form.todayWeekly != null )  	parent.document.form.todayWeekly.value = "<%=todayWeekly%>";
	
	        parent.setEccCommon();
	    } else {
	        ComShowCodeMessage("EQR90002");
	        parent.document.form.scnr_rmk.value = "";
	        parent.document.form.st_year.value = "";
	        parent.document.form.st_month.value = "";
	        parent.document.form.st_weekly.value = "";
	        parent.document.form.end_year.value ="";
	        parent.document.form.end_month.value ="";
	        parent.document.form.end_weekly.value = "";
	        parent.document.form.perfix_month.value = "";
	        parent.document.form.title_month.value ="";
	        parent.document.form.perfix_weekly.value ="";
	        parent.document.form.title_weekly.value = "";
	        parent.document.form.monthly_count.value = "";
	        parent.document.form.status_type.value = "";
	        parent.document.form.max_weekly.value = "";
	        parent.document.form.max_plnYrWk.value = "";
	        if(parent.document.form.max_plnYr   != null )  	parent.document.form.max_plnYr.value   = "";
	        if(parent.document.form.max_plnMon  != null )  	parent.document.form.max_plnMon.value  = "";
	        if(parent.document.form.todayWeekly != null )  	parent.document.form.todayWeekly.value = "";
	        
	        parent.setEccCommon();
	    }
	  
	}

</script>
<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		push();
	}
</script>
</head>
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd"> 
<input type="hidden" name="remark" value="<%=scnr_rmk%>">
</form>
</body>
</html>