<%--/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EES_EQR_094GS2.jsp
*@FileTitle : Inventory Container List
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/--%>
<%@ page contentType="text/xml; charset=UTF-8"%>
<%@ page autoFlush="true" buffer="1kb" %>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.event.EesEqr0094Event"%>
<%@ page import="com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.SearchCheckCntrInfoVO"%>
<%@ page import="com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.EesEqr0094ConditionVO"%>
<%@ page import="com.clt.framework.support.controller.html.FormCommand"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="java.util.List,java.util.Iterator"%>
<%
	List<SearchCheckCntrInfoVO> list = null;
	EesEqr0094Event event = null;
	GeneralEventResponse eventResponse = null;
	Exception serverException = null;					 //error from server
	
	String strErrMsg = "";								//error message
	int rowCount	 = 0;								 //count of DB resultSET list
	String row = null;
	String col = null;
	
	//String chk_cntrno = "";
	StringBuffer chk_cntrno = new StringBuffer();
	String checkno = "";


	try {
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}else{
			event = (EesEqr0094Event)request.getAttribute("Event");
			eventResponse = (GeneralEventResponse)request.getAttribute("EventResponse");
			EesEqr0094ConditionVO condiVO = event.getEesEqr0094ConditionVO();
			if (eventResponse != null) {
				list = eventResponse.getRsVoList();
				row = condiVO.getRow();
				col = condiVO.getCol();
				if(list != null){					
					 rowCount = list.size();
					 
				} // end if
			} // end if
		} // end else
	}catch(Exception e) {
		out.println(e.toString());
	}
	
	
	if (rowCount != 0) {	
		
		//chk_cntrno = "";
		chk_cntrno = new StringBuffer("");
		Iterator iterator = list.iterator();
		while(iterator.hasNext()){
			SearchCheckCntrInfoVO vo = (SearchCheckCntrInfoVO)iterator.next();
			chk_cntrno.append(JSPUtil.getNull(vo.getCntrNo())+",");
		}

		checkno = chk_cntrno.toString();		
		checkno = checkno.substring(0, checkno.length()-1);
					
	}else{
		chk_cntrno = new StringBuffer("");
		
	}
	
	
			
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
 	
		//parent.document.form.chk_cntrno.value = ;
		if( "<%=checkno %>" !=""){
		//EQR90094
			ComShowCodeMessage("EQR90092","<%=checkno%>");
			return false;
		}else {
			parent.setValue();
        }		
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
