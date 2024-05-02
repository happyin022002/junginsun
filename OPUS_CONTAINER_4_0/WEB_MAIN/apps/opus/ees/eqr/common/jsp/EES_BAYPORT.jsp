<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName       : EES_BAYPORT.jsp
*@FileTitle      : retrieving Bay Port
*Open Issues     : 
*Change history  :
*@LastModifyDate : 
*@LastModifier   : 
*@LastVersion    : 1.0
*@Create         : Ver 1.0   
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
<%@ page import="com.clt.framework.component.util.StringUtil"%>
<%
	EesCommonEvent  event = null;					//PDTO(Data Transfer Object including Parameters)
	GeneralEventResponse eventResponse = null;	//RDTO(Data Transfer Object including DB ResultSet)
	Exception serverException   = null;				//error from server
	String strErrMsg = "";							//error message
	
	String[] result = null;
	String list = "";
	String vvd = "";
	
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
				result = eesCommonVO.getResultset();
				vvd = StringUtil.xssFilter(request.getParameter("vvd"));
			} // end if
			else {
			}
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
<!--
	function setupPage(){
		parent.document.form.check_load.value = "N";
		var comboObj = parent.comboObjects[0];
    	var errMessage = "<%=strErrMsg%>";
		var arrPort	= new Array();
		var arrSeq	= new Array();
		var cnt = 0;

		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if


		arrPort	= "<%=result[0]%>".split("*");
		arrSeq	= "<%=result[1]%>".split("*");
		comboObj.removeAll();
		
		//alert("arrPort--"+arrPort+"\narrSeq---"+arrSeq);
		
		if(arrPort[0] == "" || arrPort[0] == null){
			parent.document.form.check_load.value = "N";
			//comboObj.Enable=false;
			parent.ComShowMessage(ComGetMsg("EQR90186","<%=vvd%>"));
	        //parent.docObjects[0].RemoveAll();
            parent.sheetObjects[0].RemoveAll();
    		return false;
		}
		
		//comboObj.Enable=true;
		comboObj.SetColAlign("left|left");
		comboObj.SetColWidth("100|25");
		comboObj.MultiSelect = false;
        comboObj.UseEdit = true;///////
		comboObj.MaxSelect = arrPort.length ;
        comboObj.MultiSeparator = "*";
        

		
		if(arrPort.length != 0){
			for(i=arrPort.length-1; i>=0; i--){
				comboObj.InsertItem(cnt++, arrPort[i], arrSeq[i]);
			}
			comboObj.Index =0;
			
			parent.document.form.basis_port.value = arrSeq[arrPort.length-1];
			parent.document.form.bayport.value = arrSeq[arrPort.length-1];
			parent.document.form.check_load.value = "Y";
		}
	}
//-->
</script>

</head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">

</form>

</body>
</html>
