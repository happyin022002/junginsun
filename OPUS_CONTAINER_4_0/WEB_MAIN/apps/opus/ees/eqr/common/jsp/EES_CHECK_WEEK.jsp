<%--/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CHECK_WEEK.jsp
*@FileTitle : GET WEEK 
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
	EesCommonEvent  event = null;					//PDTO(Data Transfer Object including Parameters)
	GeneralEventResponse eventResponse = null;	//RDTO(Data Transfer Object including DB ResultSet)
	Exception serverException   = null;				//error from server
	
	String strErrMsg = "";							//error message
	
	String[] info = null;
	String   info1 = null;
	String[] info2 = null;
	String yr_4 = "";
	String wk_4_s= "";
	String wk_4_e= "";
	String yr_3= "";
	String wk_3_s= "";
	String wk_3_e= "";
	String yr_2= "";
	String wk_2_s= "";
	String wk_2_e= "";
	String yr_1= "";
	String wk_1_s= "";
	String wk_1_e= "";
	String fr_yyyy = "";
	String fr_week = "";
	String to_yyyy = "";
	String to_week = "";
	String scnr_id = "";
	
	try {
	   	
		event = (EesCommonEvent)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}else{
			eventResponse = (GeneralEventResponse)request.getAttribute("EventResponse");
			if (eventResponse != null) {
				EesCommonVO eesCommonVO = (EesCommonVO)eventResponse.getCustomData("RetVO");
				
				//Rresent Week   
				info = eesCommonVO.getResultset();
				//From Week Scnr_id
				info1 = eesCommonVO.getResultset5();
				info2 = eesCommonVO.getResultset6();
				
				 yr_4 = JSPUtil.getNull(info2[0]);
				 wk_4_s= JSPUtil.getNull(info2[1]);
				 wk_4_e= JSPUtil.getNull(info2[2]);
				 yr_3= JSPUtil.getNull(info2[3]);
				 wk_3_s= JSPUtil.getNull(info2[4]);
				 wk_3_e= JSPUtil.getNull(info2[5]);
				 yr_2= JSPUtil.getNull(info2[6]);
				 wk_2_s= JSPUtil.getNull(info2[7]);
				 wk_2_e= JSPUtil.getNull(info2[8]);
				 yr_1= JSPUtil.getNull(info2[9]);
				 wk_1_s= JSPUtil.getNull(info2[10]);
				 wk_1_e= JSPUtil.getNull(info2[11]);
				 fr_yyyy = JSPUtil.getNull(info[0]);
				 fr_week = JSPUtil.getNull(info[1]);
				 to_yyyy = JSPUtil.getNull(info[2]);
				 to_week = JSPUtil.getNull(info[3]);
				 scnr_id = JSPUtil.getNull(info1);
				
												
			} // end if
		} // end else
	}catch(Exception e) {
		out.println(e.toString());
	}
	
	  //S_ystem.out.println (" yr_4 ====>" + yr_4);
	  //S_ystem.out.println ("wk_4_s ====>" + wk_4_s);
	  //S_ystem.out.println ("wk_4_e ====>" + wk_4_e);
	  //S_ystem.out.println ("yr_3 ====>" + yr_3);
	  //S_ystem.out.println ("wk_3_s ====>" + wk_3_s);
	  //S_ystem.out.println ("wk_3_e ====>" + wk_3_e);
	  //S_ystem.out.println ("yr_2 ====>" + yr_2);
	  //S_ystem.out.println ("wk_2_s ====>" + wk_2_s);
	  //S_ystem.out.println ("wk_2_e ====>" + wk_2_e);
	  //S_ystem.out.println ("yr_1 ====>" + yr_1);
	  //S_ystem.out.println ("wk_1_s ====>" + wk_1_s);
	  //S_ystem.out.println ("wk_1_e ====>" + wk_1_e);
	  //S_ystem.out.println (" fr_yyyy ====>" + fr_yyyy);
	  //S_ystem.out.println ("fr_week  ====>" + fr_week);
	  //S_ystem.out.println ("to_yyyy  ====>" + to_yyyy);
	  //S_ystem.out.println ("to_week  ====>" + to_week);
	  //S_ystem.out.println ("scnr_id  ====>" + scnr_id);
%>
<html>
<head>
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
<!--
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if

		parent.document.form.yr_4.value = "<%=yr_4%>";
		parent.document.form.wk_4_s.value = "<%=wk_4_s%>";
		parent.document.form.wk_4_e.value = "<%=wk_4_e%>";
		parent.document.form.yr_3.value = "<%=yr_3%>";
		parent.document.form.wk_3_s.value = "<%=wk_3_s%>";
		parent.document.form.wk_3_e.value = "<%=wk_3_e%>";
		parent.document.form.yr_2.value = "<%=yr_2%>";
		parent.document.form.wk_2_s.value = "<%=wk_2_s%>";
		parent.document.form.wk_2_e.value = "<%=wk_2_e%>";
		parent.document.form.yr_1.value = "<%=yr_1%>";
		parent.document.form.wk_1_s.value = "<%=wk_1_s%>";
		parent.document.form.wk_1_e.value = "<%=wk_1_e%>";
		
		parent.document.form.fr_yyyy.value = "<%=fr_yyyy%>";
		parent.document.form.fr_week.value = "<%=fr_week%>";
		parent.document.form.to_yyyy.value = "<%=to_yyyy%>";
		parent.document.form.to_week.value = "<%=to_week%>";
		
		parent.document.form.scnr_id.value = "<%=scnr_id%>";
		
		parent.setCheckWeek();
	}
//-->
</script>

</head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input	ype="hidden" name="f_cmd"> 


</form>

</body>
</html>
