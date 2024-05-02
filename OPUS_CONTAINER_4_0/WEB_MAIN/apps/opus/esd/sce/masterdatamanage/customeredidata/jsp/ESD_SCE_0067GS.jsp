<%-- =========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_SCE_0063GS.jsp
*@FileTitle : Vessel SKD 조회(공통 Popup)
*Open Issues :
*Change history :
*@LastModifyDate : 2006-08-02
*@LastModifier : Hyunsu, Ryu
*@LastVersion : 1.0
* 2006-08-02 Hyunsu, Ryu
* 1.0 최초 생성
=========================================================
--%>
<%@ page contentType="text/xml; charset=UTF-8"%>
<%@ page autoFlush="true" buffer="1kb" %>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.event.ESD_SCE_0067Event"%>
<%@ page import="com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.event.ESD_SCE_0067EventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.FormCommand"%>
<%

	Logger log = Logger.getLogger("com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.jsp.ESD_SCE_0067GS");

    ESD_SCE_0067Event event = null;
    ESD_SCE_0067EventResponse eventResponse = null;    //RDTO(Data Transfer Object including DB ResultSet)
    Exception serverException = null;                     //서버에서 발생한 에러
    DBRowSet rowSet = null;                               //DB ResultSet
    String strErrMsg = "";                                //에러메세지
    int cnt     = 0;                                 //DB ResultSet 리스트의 건수


    try {
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        //log.info("\n step1");
        //log.info(serverException);
        if (serverException != null && serverException.getMessage() != null ) {
            //log.info("\n step2");
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
            //log.info("\n step3");
            //log.info(strErrMsg);
        }else{
        	//log.info("\n step4");
			event = (ESD_SCE_0067Event)request.getAttribute("Event");
			//log.info("\n step5");
            eventResponse = (ESD_SCE_0067EventResponse)request.getAttribute("EventResponse");
            //log.info("\n step6");
            if (eventResponse != null) {
            	//log.info("\n step7");
                rowSet = eventResponse.getRs();
            } // end if
        } // end else
    }catch(Exception e) {
    	//log.info("\n step8");
    	out.println(e.toString());
    }

%>
<%
	if (serverException == null)  {
//log.info("\n step91");
        //js//FormCommand formcommand = event.getFormCommand();
        //화면에서 CUD가 발생하는 FormCommand인 경우에는 조회XML을 출력한다.
        //FormCommand가 다를 경우 조건문에 추가한다.
        //ServiceCommand에서는 재조회를 하지 않고 EventResponse만 return한다.
//js//        if( formcommand.isCommand(FormCommand.MULTI) || 
//js//            formcommand.isCommand(FormCommand.ADD) || 
//js//            formcommand.isCommand(FormCommand.MODIFY) || 
//js//            formcommand.isCommand(FormCommand.REMOVE) || 
//js//            formcommand.isCommand(FormCommand.REMOVELIST) ){    //저장XML인 경우
//js//log.info("\n step93");
%>

<SHEET>
  <DATA TOTAL="<%=cnt%>">
<%
log.info("\n step94");
            int i =1;
            if (rowSet != null) {
log.info("\n step95");
                while (rowSet.next()) {
%>
    <TR>
        <TD></TD>
<%
                    for (int j = 0 ; j < rowSet.getMetaData().getColumnCount() ; j++) {
log.info("\n step96");                    	
%>
        							<TD><![CDATA[<%=JSPUtil.getNull(rowSet.getString(i++))%>]]></TD>
<%
                    }

                    i = 1;
%>
    </TR>
<%
                }
            }
%>
  </DATA>
</SHEET>
<%
//js//        }
    } else {%>
<ERROR>
<MESSAGE> <![CDATA[ <%=strErrMsg%>]]> </MESSAGE>
</ERROR>
<%
log.info("\n step97");
    }
%>