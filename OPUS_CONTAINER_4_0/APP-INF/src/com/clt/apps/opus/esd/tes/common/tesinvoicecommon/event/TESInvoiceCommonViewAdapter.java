/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TESInvoiceCommonViewAdapter.java
*@FileTitle : TES Invoice Common 관리
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.13
*@LastModifier : yOng hO lEE
*@LastVersion : 1.0
* 2009.07.13 yOng hO lEE
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tes.common.tesinvoicecommon.event;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.ViewAdapter;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * TesInvoiceCommon 에 대한 <br>
 * -  TesInvoiceCommon5ViewAdapter 작성<br>
 *
 * @author yOng hO lEE
 * @see TesInvoiceCommonHTMLAction 참조
 * @since J2EE 1.6
 */
public class TESInvoiceCommonViewAdapter extends ViewAdapter{
	
    /**
     * TESInvoiceCommonViewAdapter 
     */
    public TESInvoiceCommonViewAdapter()
    {
    	log = Logger.getLogger(getClass().getName());
    }
    
    /**
     * @param HttpServletRequest request
     * @param HttpServletResponse response
     * @return String
     * @see com.clt.framework.core.controller.ViewAdapter#makeXML(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public String makeXML(HttpServletRequest request, HttpServletResponse response)
    {
        Event event = null;
        GeneralEventResponse eventResponse = null;
        Exception serverException = null;
        String strXML = "";
        
        boolean isupload = isUploadFile(request);
        try
        {
            serverException = (Exception)request.getAttribute("com.clt.framework.core.comm.EXCEPTION_OBJECT      ");

            if(serverException != null)
            {
                strXML = getErrorXML((new ErrorHandler(serverException)).loadPopupMessage(), isupload);
            } else
            {
                boolean isUpload = isUploadFile(request);
                event = (Event)request.getAttribute("Event");
                eventResponse = (GeneralEventResponse)request.getAttribute("EventResponse");
                boolean isSave = isSaveCommand(event);
                if(eventResponse != null)
                {
                    
                    if(eventResponse.getDataCntList().size() == 0)
                        strXML = getNoSearchResultXML(isUpload, isSave, eventResponse, request);
                    else {
                        strXML = makeSuccessXML(isUpload, request, eventResponse);
                    }
                }
            }
        }
        catch(Exception ex)
        {
            log.error(ex.getMessage(), ex);
            strXML = getErrorXML((new ErrorHandler(ex)).loadPopupMessage(), isupload);
        }
        
        if(log.isDebugEnabled())
            log.debug((new StringBuilder("\n")).append(strXML).toString());
        
        return strXML;
    }

    /**
     * @param isUpload
     * @param isSave
     * @param eventResponse
     * @param request
     * @return String
     */
    protected String getNoSearchResultXML(boolean isUpload, boolean isSave, GeneralEventResponse eventResponse, HttpServletRequest request)
    {
        StringBuilder sb = new StringBuilder();
        if(isUpload)
            sb.append("<pre>\n");
        if(isSave)
        {
            sb.append("<RESULT>\n");
            sb.append("\t\t<TR-ALL>OK</TR-ALL>\n");
        } else
        {
            sb.append("<SHEET>\n");
            sb.append("<DATA  TOTAL='0'>\n");
            sb.append("</DATA>\n");
        }
        sb.append(getETCData(eventResponse, request));
        sb.append(getUserMessageXML(eventResponse));
        sb.append(getEndTag(sb));
        if(isUpload)
            sb.append("</pre>\n");
        return sb.toString();
    }

	
	/**
	 * VO List를 Parsing하여 <Data>태그 부분의 XML문자열을 반환한다.<br>
	 * 
	 * @param vos List<AbstractValueObject> List 객체
	 * @param colOrder String[] Column명 문자열 
	 * @param prefix String IBSheet savename's prefix
	 * @return String <Data>태그 부분의 XML문자열
	 */	
    @SuppressWarnings("unchecked")
	protected String makeDataTag(List vos, String prefix)
    {
        StringBuilder sbufXML = new StringBuilder();

        int totCnt = vos.size();
        int realCnt = vos.size();
        AbstractValueObject vo = (AbstractValueObject)vos.get(0);
        String realColNms[] = getColHeader(vo);
        String changedColNms[] = getChangedColNms(realColNms, prefix);

        if(vo.getMaxRows() > 0)
            totCnt = vo.getMaxRows();
        
        sbufXML.append((new StringBuilder("<DATA COLORDER='")).append(JSPUtil.convertStringArrayToString(changedColNms, "|")).append("' COLSEPARATOR='").append("\u261C\u261E").append("' TOTAL='").append(totCnt).append("'>\n").toString());
        for(int i = 0; i < realCnt; i++)
        {
            Map colValues = ((AbstractValueObject)vos.get(i)).getColumnValues();
            sbufXML.append("\t<TR><![CDATA[");
            int colCnt = realColNms.length;
            for(int j = 0; j < colCnt - 1; j++)
                sbufXML.append((new StringBuilder(String.valueOf(getNull((String)colValues.get(realColNms[j]))))).append("\u261C\u261E").toString());

            sbufXML.append((new StringBuilder(String.valueOf(getNull((String)colValues.get(realColNms[colCnt - 1]))))).append("]]></TR>\n").toString());
        }

        sbufXML.append("</DATA>\n");
        return sbufXML.toString();
    }

	/**
	 * VO List를 Parsing하여 <Data>태그 부분의 XML문자열을 반환한다.<br>
	 * 
	 * @param vos List<AbstractValueObject> List 객체
	 * @param colOrder String[] Column명 문자열 
	 * @param prefix String IBSheet savename's prefix
	 * @return String <Data>태그 부분의 XML문자열
	 */	
   @SuppressWarnings("unchecked")
   protected String makeDataTag(List vos, String prefix, Event event,EventResponse eventResponse)
    {
        StringBuilder		sbufXML	= new StringBuilder();
        StringBuilder		sbufVal	= new StringBuilder();

        AbstractValueObject			vo			= (AbstractValueObject)vos.get(0);
        HashMap<String, String>		etcData		= (HashMap<String, String>)eventResponse.getETCData();
        FormCommand					formcommand	= event.getFormCommand();
        
        String	realColNms[]	= getColHeader(vo);
		
        int		realCnt = vos.size();
        int		cnt		= 0;
        
        sbufXML.append( (new StringBuilder("<ETC-DATA>\n")).toString() );
        sbufXML.append( (new StringBuilder("<ETC KEY='")).toString() ).append((String)etcData.get("ETC_KEY_NAME")).append("'><![CDATA[");

		if ( formcommand.isCommand(FormCommand.SEARCH02) ) {

			for(int i = 0; i < realCnt; i++) {
	        	Map		colValues	= ((AbstractValueObject)vos.get(i)).getColumnValues();
	        	int		colCnt		= realColNms.length;

	        	for(int j = 0; j < colCnt - 1; j++) {
					sbufVal.append( (j>0?"--":"") );
					sbufVal.append( (new StringBuilder( String.valueOf(getNull((String)colValues.get(realColNms[j]))))).toString() );
	        	}//for..[]
	            cnt++;
        	}//for..[]
		} else {
	        for(int i = 0; i < realCnt; i++) {
	        	
	        	Map		colValues	= ((AbstractValueObject)vos.get(i)).getColumnValues();
	        	int		colCnt		= realColNms.length;

	        	sbufVal.append( cnt>0?"--":"" );
	            for(int j = 0; j < colCnt - 1; j++) {
					sbufVal.append( (j>0?"|":"") );
					sbufVal.append( (new StringBuilder( String.valueOf(getNull((String)colValues.get(realColNms[j]))))).toString() );
	        	}//for..[]
	            cnt++;
	            
        	}//for..[]
        }//for..[]

        sbufXML.append( sbufVal.toString() ).append("]]></ETC>\n");
        sbufXML.append("</ETC-DATA>\n");
        
        return sbufXML.toString();
    }

	/**
	 * DBRowSet를 Parsing하여 <DATA>태그를 생성한다.<br>
	 * IBSheet의 prefix값이 있는 경우 COLORDER에 prefix를 붙인 column명으로 표시해 준다.<br>
	 * 
	 * @param rs DBRowSet 		VO객체
	 * @param prefix String 		IBSheet savename's prefix string
	 * @return String IBSheet 		<DATA>태그
	 * @exception RuntimeException
	 */
    protected String makeDataTag(DBRowSet rs, String prefix)
    {
        StringBuilder sb = new StringBuilder();
        if(rs.isPivot())
        {
            sb.append(makePivotDataTag(rs));
            return sb.toString();
        }
        String realColNms[] = getColHeader(rs);
        try
        {
            String changedColNms[] = getChangedColNms(realColNms, prefix);
            sb.append((new StringBuilder("<DATA COLORDER='")).append(JSPUtil.convertStringArrayToString(changedColNms, "|")).append("' COLSEPARATOR='").append("\u261C\u261E").append("' TOTAL='").append(getRowSetCnt(rs)).append("'>\n").toString());
            int colCount = realColNms.length;
            for(; rs.next(); sb.append((new StringBuilder()).append(getNull(rs.getObject(colCount))).append("]]></TR>\n").toString()))
            {
                sb.append("\t<TR><![CDATA[");
                for(int j = 1; j < colCount; j++)
                    sb.append((new StringBuilder()).append(getNull(rs.getObject(j))).append("\u261C\u261E").toString());
            }

            sb.append("</DATA>\n");
        }
        catch(SQLException ex)
        {
            throw new RuntimeException(ex.getMessage());
        }
        catch(Exception ex)
        {
            log.error(ex.getMessage(), ex);
            throw new RuntimeException(ex.getMessage());
        }
        return sb.toString();
    }

	/**
	 * DBRowSet를 Parsing하여 <DATA>태그를 생성한다.<br>
	 * IBSheet의 prefix값이 있는 경우 COLORDER에 prefix를 붙인 column명으로 표시해 준다.<br>
     * @param rs
     * @param prefix
     * @param event
     * @param eventResponse
     * @return String
	 * @exception RuntimeException
     */
    protected String makeDataTag(DBRowSet rs, String prefix, Event event, EventResponse eventResponse)
    {
        StringBuilder				sb			= new StringBuilder();
        HashMap<String, String>		etcData		= (HashMap<String, String>)eventResponse.getETCData();
        FormCommand					formcommand	= event.getFormCommand();

        if(rs.isPivot())
        {
            sb.append(makePivotDataTag(rs));
            return sb.toString();
        }
        String realColNms[] = getColHeader(rs);
        try
        {

            sb.append( (new StringBuilder("<ETC-DATA>\n")).toString() );
            sb.append((new StringBuilder("<ETC KEY='")).append((String)etcData.get("ETC_KEY_NAME")).append("'><![CDATA[").toString());

            int colCount = realColNms.length;
			int	cnt	= 0;

            if ( formcommand.isCommand(FormCommand.SEARCH02) ) {

				while( rs.next() ) {
                    for(int j = 0; j < colCount; j++) {
                    	
                    	sb.append( (j>0?"--":"") );
                        sb.append((new StringBuilder()).append(getNull(rs.getObject(realColNms[j]))).toString());
                    }
                	cnt++;
                }
			} else {
                while( rs.next() ) {
                	sb.append( cnt>0?"--":"" );
                    for(int j = 0; j < colCount; j++) {
    	            	sb.append( (j>0?"|":"") );
                        sb.append((new StringBuilder()).append(getNull(rs.getObject(realColNms[j]))).toString());
                    }
                	cnt++;
                }
			}
            sb.append("]]></ETC>\n");
            sb.append("</ETC-DATA>\n");
            
        }
        catch(SQLException ex)
        {
            throw new RuntimeException(ex.getMessage());
        }
        catch(Exception ex)
        {
            log.error(ex.getMessage(), ex);
            throw new RuntimeException(ex.getMessage());
        }
        return sb.toString();
    }
    
    /**
     * @param rs
     * @return String
	 * @exception RuntimeException
     */
    protected String makePivotDataTag(DBRowSet rs)
    {
        StringBuilder sb = new StringBuilder();
        int colCnt = 0;
        int rowCnt = rs.getRowCount();
        String arrRowSet[][] = (String[][])null;
        try
        {
            colCnt = rs.getMetaData().getColumnCount();
            arrRowSet = new String[rowCnt][colCnt];
            for(int rowIdx = 0; rs.next(); rowIdx++)
            {
                for(int j = 1; j <= colCnt; j++)
                    arrRowSet[rowIdx][j - 1] = getNull(rs.getObject(j)).toString();

            }

        }
        catch(SQLException ex)
        {
//            log.error(ex.getMessage(), ex);
            throw new RuntimeException(ex.getMessage());
        }
        catch(Exception ex)
        {
//            log.error(ex.getMessage(), ex);
            throw new RuntimeException(ex.getMessage());
        }
        try
        {
            sb.append("<DATA COLSEPARATOR='\u261C\u261E'>\n");
            if(rowCnt > 0)
            {
                for(int coIdx = 0; coIdx < colCnt; coIdx++)
                {
                    sb.append("\t<TR><![CDATA[");
                    for(int roIdx = 0; roIdx < rowCnt - 1; roIdx++)
                        sb.append((new StringBuilder(String.valueOf(arrRowSet[roIdx][coIdx]))).append("\u261C\u261E").toString());

                    sb.append((new StringBuilder(String.valueOf(arrRowSet[rowCnt - 1][coIdx]))).append("]]></TR>\n").toString());
                }

            }
            sb.append("</DATA>\n");
        }
        catch(Exception ex)
        {
//            log.error(ex.getMessage(), ex);
            throw new RuntimeException(ex.getMessage());
        }
        return sb.toString();
    }
    
    /**
     * @param eventResponse
     * @param request
     * @return String
	 * @exception RuntimeException
     */
    @SuppressWarnings("unchecked")
	protected String getETCData(EventResponse eventResponse, HttpServletRequest request)
    {
        if(eventResponse == null)
            return "";
        StringBuilder	sb			= new StringBuilder();
        HashMap<String, String>			etcData	= (HashMap<String, String>)eventResponse.getETCData();

        sb.append("<ETC-DATA>\n");
        if(etcData != null && etcData.size() > 0)
        {
            String key;
            String val;
            for(Iterator it = etcData.keySet().iterator(); it.hasNext(); sb.append((new StringBuilder("<ETC KEY='")).append(key).append("'><![CDATA[").append(val).append("]]></ETC>\n").toString()))
            {
                key = (String)it.next();
                val = (new StringBuilder()).append((String)etcData.get(key)).toString();
            }//for..[]

        }
        sb.append(getPivotETCData(eventResponse));
        sb.append("</ETC-DATA>\n");
        
        return sb.toString();
    }

    /**
     * @param request
     * @return boolean
     */
    private boolean isUploadFile(HttpServletRequest request)
    {
        boolean isUpload = false;
        String contentType = request.getContentType();
        if(contentType != null && contentType.startsWith("multipart/form-data"))
            isUpload = true;
        return isUpload;
    }


    /**
     * @param sb
     * @return String
     */
    private String getEndTag(StringBuilder sb)
    {
        String endTag = "";
        String tmp = sb.toString();
        int sheetLoc = tmp.lastIndexOf("<SHEET>");
        int resultLoc = tmp.lastIndexOf("<RESULT>");
        if(sheetLoc > resultLoc)
            endTag = "</SHEET>\n";
        else
            endTag = "</RESULT>\n";
        return endTag;
    }

    /**
     * @param isFirstSheet
     * @param isSave
     * @param eventResponse
     * @param request
     * @return String
     */
    private String getStartTag(boolean isFirstSheet, boolean isSave, GeneralEventResponse eventResponse, HttpServletRequest request)
    {
        StringBuilder sb = new StringBuilder();
        if(isFirstSheet)
        {
            if(isSave)
            {
                sb.append("<RESULT>\n");
                sb.append("<TR-ALL>OK</TR-ALL>\n");
            } else
            {
                sb.append("<SHEET>\n");
            }
            sb.append(getETCData(eventResponse, request));
            sb.append(getUserMessageXML(eventResponse));
        } else
        {
            sb.append("|$$|<SHEET>\n");
        }
        return sb.toString();
    }


    /**
     * @param isUpload
     * @param request
     * @param eventResponse
     * @return String
     */
    @SuppressWarnings("unchecked")
	private String makeSuccessXML(boolean isUpload, HttpServletRequest request, GeneralEventResponse eventResponse)
    {
        Event			event		= (Event)request.getAttribute("Event");
        List			rsVoList	= eventResponse.getRsVoList();
        List			dataCntList = eventResponse.getDataCntList();
        StringBuilder	sb			= new StringBuilder();

        String	[]		prefixs		= getPrefixFromHttp(request);
        boolean			isSave		= isSaveCommand(event);
        boolean			isFirstSheet= true;
 
        
        if(isUpload)
            sb.append("<pre>\n");
        int setExeCnt = dataCntList.size();
        Iterator it = rsVoList.iterator();
        int curLoc = 0;
        for(int i = 0; i < setExeCnt; i++)
        {
            int voCnt = ((Integer)dataCntList.get(i)).intValue();
            if(voCnt == 0)
            {
                sb.append(getStartTag(isFirstSheet, isSave, eventResponse, request));
                sb.append("\t<DATA  TOTAL='0'>\n");
                sb.append("\t</DATA>\n");
                sb.append(getEndTag(sb));
                isFirstSheet = false;
            } else
            if(rsVoList.get(curLoc) instanceof DBRowSet)
            {
                sb.append(getStartTag(isFirstSheet, isSave, eventResponse, request));
                sb.append(makeDataTag((DBRowSet)it.next(), prefixs[i], event, eventResponse));
                sb.append(getEndTag(sb));
                curLoc++;
                isFirstSheet = false;
            } else
            {
                List tmpList = new ArrayList();
                for(int j = 0; j < voCnt; j++)
                {
                    Object obj = it.next();
                    tmpList.add(obj);
                    curLoc++;
                }

                sb.append(getStartTag(isFirstSheet, isSave, eventResponse, request));
                sb.append(makeDataTag(tmpList, prefixs[i], event, eventResponse));
                sb.append(getEndTag(sb));
                removeListAllElements(tmpList);
                isFirstSheet = false;
            }
        }

        if(isUpload)
            sb.append("</pre>\n");
        return sb.toString();
    }

    protected Logger log;
    protected final String DELIMITER = "\u261C\u261E";
    public static final String SHEET_DELIMITER = "|$$|";

}
