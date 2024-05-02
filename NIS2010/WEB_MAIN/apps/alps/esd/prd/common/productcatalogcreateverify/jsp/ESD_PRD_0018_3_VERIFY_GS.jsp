<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_PRD_0018GS.jsp
*@FileTitle : Product Catalog 생성결과 조회 화면
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-21
*@LastModifier : jungsunyoung
*@LastVersion : 1.0
* 2006-11-21 jungsunyoung
* 1.0 최초 생성
=========================================================*/
--%>
<%@ page contentType="text/xml; charset=UTF-8"%>
<%@ page autoFlush="true" buffer="1kb" %>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.prd.common.productcatalogcreateverify.event.ProductCatalogCreateVerifyEvent"%>
<%@ page import="com.hanjin.apps.alps.esd.prd.common.productcatalogcreateverify.event.ProductCatalogCreateVerifyEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.FormCommand"%>
<%

	ProductCatalogCreateVerifyEvent event = null;
	ProductCatalogCreateVerifyEventResponse eventResponse = null;	//RDTO(Data Transfer Object including DB ResultSet)
	Exception serverException = null;					 //서버에서 발생한 에러
	DBRowSet rowSet = null;							   //DB ResultSet
	DBRowSet rowSetEq = null;							   //DB ResultSet(EQ)	
	String strErrMsg = "";								//에러메세지
	int rowCount	 = 0;								 //DB ResultSet 리스트의 건수
 
	String retErrMsg = "";								//에러메세지
	String msgF ="";
	String msgL ="";
	FormCommand formcommand = null;
 
	
	try {
		
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		event = (ProductCatalogCreateVerifyEvent)request.getAttribute("Event");
		formcommand = event.getFormCommand();

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
			
		}else{
			
			eventResponse = (ProductCatalogCreateVerifyEventResponse)request.getAttribute("EventResponse");
			if (eventResponse != null) {
 
//				strErrMsg = eventResponse.getErrMsg();  
				strErrMsg = eventResponse.getOcnErrMsg().append("\n"+eventResponse.getOutBndErrMsg()).append( "\n"+eventResponse.getInBndErrMsg()).append( "\n"+eventResponse.getEtcBndErrMsg()).append( "\n"+eventResponse.getSkdErrMsg()).toString();  
//				System.out.println("Remark : " + cnstRemark + "Auto PRD" + autoPrd);
				
//				if(retErrMsg.indexOf("#@") >0) {
//					msgF = retErrMsg.substring(0,retErrMsg.indexOf("#@"));
//					msgL = retErrMsg.substring(retErrMsg.indexOf("#@"));
//					msgL = JSPUtil.replace(JSPUtil.replace(msgL,"<||>　 　　　　　 ",""),"#@","<||>");
//					strErrMsg = msgF+msgL;		
					
//				} else {
//					strErrMsg = retErrMsg;
//				}
//				 실패시 처리 ------------
				
//				if(rowSet != null){
//					 rowCount = rowSet.getRowCount();
					 
//				} // end if
				 

			} // end if
		} // end else
	}catch(Exception e) {
		out.println(e.toString());
	}

	if (serverException == null) {
		formcommand = event.getFormCommand();
		//화면에서 CUD가 발생하는 FormCommand인 경우에는 조회XML을 출력한다.
		//FormCommand가 다를 경우 조건문에 추가한다.
		//ServiceCommand에서는 재조회를 하지 않고 EventResponse만 return한다.
		if( formcommand.isCommand(FormCommand.MULTI) || 
			formcommand.isCommand(FormCommand.ADD) || 
			formcommand.isCommand(FormCommand.MODIFY) || 
			formcommand.isCommand(FormCommand.REMOVE) || 
			formcommand.isCommand(FormCommand.COMMAND01) || 
			formcommand.isCommand(FormCommand.REMOVELIST) ){	//저장XML인 경우
%>
<RESULT>
  <TR-ALL>OK</TR-ALL>
</RESULT>
<%
		   } else {	//조회XML인 경우%>
<SHEET>

  <DATA  >
 
  </DATA>

  
<%
 if(formcommand.isCommand(FormCommand.COMMAND19)) { // -->3번째단. 
%>

 <ETC-DATA>
      	<ETC KEY="retErrMsg"><![CDATA[<%=strErrMsg%>]]></ETC>
      	
 </ETC-DATA>	   

 <%
 }
 %>
</SHEET>

<%
		}
	} else { %>
<ERROR>
<%
		event = (ProductCatalogCreateVerifyEvent)request.getAttribute("Event");
		formcommand = event.getFormCommand();
 		if(formcommand.isCommand(FormCommand.COMMAND19)) { 
%> 		
 	<ETC-DATA>
 	      	<ETC KEY="retErrMsg"><![CDATA[<%="err 정교화 메세지 테스트!!!!!"%>]]></ETC>
    	 	      	
 	 </ETC-DATA> 	
<% 	 	
 		} 
%>
</ERROR>
<%
	}
%>