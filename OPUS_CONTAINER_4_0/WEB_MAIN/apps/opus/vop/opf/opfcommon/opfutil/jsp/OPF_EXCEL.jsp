<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OPF_EXCEL.jsp
*@FileTitle : OPF_EXCEL
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.02
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.06.02 장강철 jkc
* 1.0 Creation
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>

<%@ page import="com.clt.apps.opus.vop.opf.opfcommon.opfutil.event.VopOpfExcelEvent"%>
  
<%@ page import="com.clt.framework.component.util.io.HttpUtil"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.apps.opus.vop.opf.opfcommon.opfutil.vo.ComExcelVO"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="java.util.Enumeration"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="org.apache.log4j.Logger" %>
<%!
    public String getExcelXml(HashMap hmVo){
        int startrow = 4;
        if( JSPUtil.getNull( hmVo.get("title")).equals("") ){
        	startrow = 1;
        }
        
        StringBuffer sXml = new StringBuffer();
        //sXml.append("<?xml version='1.0' ?>                                                                           \n");
        sXml.append("<Excel>                                                                                          \n");
        sXml.append(" <IBSheetSet>                                                                                    \n");
        sXml.append("     <StartRow>"+startrow+"</StartRow>                                                           \n");
        sXml.append(" </IBSheetSet>                                                                                   \n");
        sXml.append(" <PageSet>                                                                                       \n");
        sXml.append("     <PaperSize>A4</PaperSize>                                                                   \n");
        sXml.append("     <Orientation>"+JSPUtil.getNull( hmVo.get("orientation") )+"</Orientation>                   \n");
        sXml.append("     <Margins Top='1.5' Header='1.3' Left='1' Right='1' Bottom='1.5' Footer='1.3' >True</Margins>\n");
        sXml.append("     <Scaling>                                                                                   \n");
        sXml.append("         <Adjust Value='100'>true</Adjust>                                                       \n");
        sXml.append("         <Fit Height='1' Width='1'>false</Fit>                                                   \n");
        sXml.append("     </Scaling>                                                                                  \n");
        sXml.append("                                                                                                 \n");
        sXml.append("     <DefaultRowHeight>18</DefaultRowHeight>                                                     \n");
        sXml.append("     <DefaultFont Name='돋음체' size='9'/>                                                       \n");
        sXml.append(" </PageSet>                                                                                      \n");
        sXml.append(" <ColumnWidth Col1='1' Col2='End'>-1</ColumnWidth>                                               \n");
        String[] columnwidth =  ( (String)JSPUtil.getNull( hmVo.get("columnwidth") )  ).split("\\|");//12:50|40:60|
        if(!((String)JSPUtil.getNull( hmVo.get("columnwidth")) ).equals("")){
            for(int i=0;i<columnwidth.length;i++){
                String[] columnnum   =  columnwidth[i].split(":");//idx : 0 컬럼, i:컬럼 Width
                sXml.append(" <ColumnWidth Col1='"+columnnum[0]+"'>"+columnnum[1]+"</ColumnWidth>                         \n");
            }
        }
        String[] datarowheight =  ((String)JSPUtil.getNull( hmVo.get("datarowheight") )).split("\\|" );//12:50|40:60|
        if( !((String)JSPUtil.getNull( hmVo.get("datarowheight") )).equals("") ){
            for(int i=0;i<datarowheight.length;i++){
                String[] rowheight   = datarowheight[i].split( ":" );//idx : 0 Row, i:Row Height
               sXml.append(" <RowHeight Row1='"+(startrow+Integer.parseInt( rowheight[0] ))+"'  >"+rowheight[1]+"</RowHeight> \n");
            }
        }
        
        if( !JSPUtil.getNull( hmVo.get("title")).equals("") ){
	        sXml.append(" <Label>                                                                                         \n");
	        sXml.append("     <Range Row1='1' Col1='1' Row2='2' Col2='"+JSPUtil.getNull( hmVo.get("cols") )+"' RowHeight='18'> \n");
	        sXml.append("         <CellFormat>                                                                            \n");
	        sXml.append("             <Merge>True</Merge>                                                                 \n");
	        sXml.append("             <Alignment Horizantal='"+JSPUtil.getNull( hmVo.get("align") )+"' Vertical='Center'/> \n");
	        sXml.append("             <Interior BackColor='RGB(255,255,255)' />                                           \n");
	        sXml.append("             <Font Name='굴림' Bold='True'  Size='18' UnderLine='Single'              \n");
	        sXml.append("              Strikethrough='False' Superscript='False' Subscript='False' Color='RGB(0,0,0)'/>   \n");
	        sXml.append("         </CellFormat>                                                                           \n");
	        sXml.append("         <InputText>"+JSPUtil.getNull( hmVo.get("title") )+"</InputText>                         \n");
	        sXml.append("     </Range>                                                                                    \n");
	        sXml.append(" </Label>                                                                                        \n");
        }
        
        sXml.append("</Excel>                                                                                         \n");
        
        return sXml.toString();
    }
 
%>
<% 
    VopOpfExcelEvent  event     = null;	 
//	Exception serverException   = null;	 
//	String strErrMsg = "";	
//	Logger log       = Logger.getLogger(this.getClass().getName());
//	System.out.println("============= log "  + log);
	event            = (VopOpfExcelEvent)request.getAttribute("Event");
//	System.out.println("============= request.getAttribute "  + request.getAttribute("Event"));
	
//	System.out.println("============= event "  + event);

//	serverException  = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
	
//	if (serverException != null) {
//       strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
//	}
	
//	System.out.println("============= strErrMsg "  + strErrMsg);
	ComExcelVO comExcelVO = null;
	//try {
	    comExcelVO   = event.getComExcelVO();
	    HashMap<String,String> hmVo = comExcelVO.getColumnValues();
 
		String sXml   = getExcelXml(hmVo);
 
		//out.print(sXml);
		HttpUtil.forwardXML( sXml, response, null );
		
	/* }catch(Exception e) {
		out.println(e.toString());
	} */
%>