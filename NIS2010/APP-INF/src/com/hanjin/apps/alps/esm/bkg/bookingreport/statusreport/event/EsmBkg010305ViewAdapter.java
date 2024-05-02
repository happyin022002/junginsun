/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0103_03ViewAdapter.java
*@FileTitle : Booking Status Report REEFER
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.24
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2009.05.25 김경섭
* 1.0 Creation 
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.event;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.ViewAdapter;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;

/**
 * 기본 IBSheet XML 생성<br>
 * - IBSheet로 반환할 서버처리결과를 XML로 변환하는 클래스이다.<br>
 * 
 * @author Kim Gyoung Sub
 * @see ViewAdapter 참조
 * @since J2EE 1.6
 */
public class EsmBkg010305ViewAdapter extends ViewAdapter {

    private String getStartTag(boolean isFirstSheet, boolean isSave, GeneralEventResponse eventResponse)
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
            sb.append(getETCData(eventResponse));
            sb.append(getUserMessageXML(eventResponse));
        } else
        {
            sb.append("|$$|<SHEET>\n");
        }
        return sb.toString();
    }
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
	   @SuppressWarnings("unchecked")
	private String makeSuccessXML(boolean isUpload, HttpServletRequest request, GeneralEventResponse eventResponse)
	    {
	        Event event = (Event)request.getAttribute("Event");
	        boolean isSave = isSaveCommand(event);
	        StringBuilder sb = new StringBuilder();
	        List rsVoList = eventResponse.getRsVoList();
	        //int cnt = rsVoList.size();
	        //String preVOName = "";
	        boolean isFirstSheet = true;
	        //List voList = new ArrayList();
	        String prefixs[] = getPrefixFromHttp(request);
	        List dataCntList = eventResponse.getDataCntList();
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
	                sb.append(getStartTag(isFirstSheet, isSave, eventResponse));
	                sb.append("\t<DATA  TOTAL='0'>\n");
	                sb.append("\t</DATA>\n");
	                sb.append(getEndTag(sb));
	                isFirstSheet = false;
	            } else
	            if(rsVoList.get(curLoc) instanceof DBRowSet)
	            {
	                sb.append(getStartTag(isFirstSheet, isSave, eventResponse));
	                sb.append(makeDataTag((DBRowSet)it.next(), prefixs[i]));
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

	               // sb.append(getStartTag(isFirstSheet, isSave, eventResponse));
	                sb.append(makeDataTag(tmpList, prefixs[i]));
	                //sb.append(getEndTag(sb));
	                removeListAllElements(tmpList);
	                isFirstSheet = false;
	            }
	        }

	        if(isUpload)
	            sb.append("</pre>\n");
	        return sb.toString();
	    }
	   
	/**
	 * makeXML
	 * 
	 * @param HttpServletRequest request
	 * @param HttpServletResponse response
	 * @return String
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
	            serverException = (Exception)request.getAttribute("com.hanjin.framework.core.comm.EXCEPTION_OBJECT      ");
	            if(serverException != null)
	            {
	                strXML = getErrorXML((new ErrorHandler(serverException)).loadPopupMessage(), isupload);
	            } else
	            {
	                boolean isUpload = isUploadFile(request);
	                event = (Event)request.getAttribute("Event");
	                eventResponse = (GeneralEventResponse)request.getAttribute("EventResponse");
	                //List rsVoList = null;
	                /* R4J 결함 복구 isSave 는 사용 하지 않아 주석 처리함 */
	                isSaveCommand(event);
//	                boolean isSave = isSaveCommand(event);
	                if(eventResponse != null)
	                {
	                    //rsVoList = eventResponse.getRsVoList();
	                    if(eventResponse.getRsVoList().size() == 0){
	                        //strXML = getNoSearchResultXML(isUpload, isSave, eventResponse);
	                        strXML = "<SHEET> <ETC-DATA> </ETC-DATA> 	<DATA  TOTAL='0'> 	</DATA> </SHEET>";
	                    }else{
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
	 
	 	private boolean isUploadFile(HttpServletRequest request)
	    {
	        boolean isUpload = false;
	        String contentType = request.getContentType();
	        if(contentType != null && contentType.startsWith("multipart/form-data"))
	            isUpload = true;
	        return isUpload;
	    }	 
	/**
	 * VO List를 Parsing하여 <Data>태그 부분의 XML문자열을 반환한다.<br>
	 * 
	 * @param vos List<AbstractValueObject> List 객체
	 * @param colOrder String[] Column명 문자열 
	 * @param prefix String IBSheet savename's prefix
	 * @return String <Data>태그 부분의 XML문자열
	 * @exception 
	 */	
	protected String makeDataTag(List<AbstractValueObject> vos, String prefix) {
		StringBuilder sbufXML = new StringBuilder();
		//log.debug("*************************************** prefix"+prefix);
		int totCnt = vos.size();
		int realCnt = vos.size();

		AbstractValueObject vo = (AbstractValueObject)vos.get(0);
		//String[] realColNms=getColHeader(vo);
		//String[] changedColNms = getChangedColNms(realColNms, prefix);
		
		if(vo.getMaxRows()>0){
			totCnt = vo.getMaxRows();
		}
		

		Map<String, String> colValues = null;
		Map<String, String> colValues2 = null;
		String orderByTemp = "";
		String orderByTitle = "";
		
		sbufXML.append("<SHEET>\n");
		//토탈 개수 조정 - 페이징 처리에 필요하였으나 현재는 페이징 없이 가져오므로 필요 없음
		sbufXML.append("\n<DATA>\n");
		
		for(int i=0;i<realCnt;i++){
			colValues = vos.get(i).getColumnValues();
			orderByTemp =colValues.get("orderby_title");
			//log.debug(orderByTemp.toString());
			
			//이전 OrderBy Title과 현재 데이타의 값이 틀리면 제목을 새로 생성한다.
			if(!orderByTitle.equals(orderByTemp)){
				if(i > 0){
					colValues2 = vos.get(i-1).getColumnValues();
					sbufXML.append("	<TR BGCOLOR='235,235,235'>\n");
					sbufXML.append("		<TD><![CDATA[Sub Total]]></TD>\n");
					sbufXML.append("		<TD><![CDATA[ ").append(colValues2.get("sub_f_bkg_qty"))     .append(" ]]></TD>\n");
					sbufXML.append("		<TD><![CDATA[ ").append(colValues2.get("sub_f_teu"))         .append(" ]]></TD>\n");
					sbufXML.append("		<TD><![CDATA[ ").append(colValues2.get("sub_p_bkg_qty"))     .append(" ]]></TD>\n");
					sbufXML.append("		<TD><![CDATA[ ").append(colValues2.get("sub_p_teu"))         .append(" ]]></TD>\n");
					sbufXML.append("		<TD><![CDATA[ ").append(colValues2.get("sub_r_bkg_qty"))     .append(" ]]></TD>\n");
					sbufXML.append("		<TD><![CDATA[ ").append(colValues2.get("sub_r_teu"))         .append(" ]]></TD>\n");
					sbufXML.append("		<TD><![CDATA[ ").append(colValues2.get("sub_t_bkg_qty"))     .append(" ]]></TD>\n");
					sbufXML.append("		<TD><![CDATA[ ").append(colValues2.get("sub_t_teu"))         .append(" ]]></TD>\n");
					sbufXML.append("		<TD><![CDATA[ ").append(colValues2.get("sub_bkg_cnt"))       .append(" ]]></TD>\n");
					sbufXML.append("	</TR>\n");
					sbufXML.append(" <TR MERGE=\"TRUE\" HIDDEN='TRUE'> </TR>\n");
				}
				//OrderBy XML생성
				sbufXML.append(" <TR MERGE=\"TRUE\">\n");
				sbufXML.append("		<TD BOLD='TRUE' DATA-ALIGN='daLeft'><![CDATA[").append(orderByTemp).append("]]></TD>\n");
				for (int j = 0; j < 10; j++) {
					sbufXML.append("		<TD><![CDATA[").append(orderByTemp).append("]]></TD>\n");
				}
				
				sbufXML.append("	</TR>\n");
				//log.debug("sbufXML title>>>>>>>>>>>>>>>>>>>>>>"+sbufXML.toString());
				orderByTitle = orderByTemp;
				//orderbyCnt++;
			}
			
			sbufXML.append("	<TR>\n");
			sbufXML.append("		<TD><![CDATA[ ").append(colValues.get("tp_sz"))         .append(" ]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[ ").append(colValues.get("f_bkg_qty"))     .append(" ]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[ ").append(colValues.get("f_teu"))         .append(" ]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[ ").append(colValues.get("p_bkg_qty"))     .append(" ]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[ ").append(colValues.get("p_teu"))         .append(" ]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[ ").append(colValues.get("r_bkg_qty"))     .append(" ]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[ ").append(colValues.get("r_teu"))         .append(" ]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[ ").append(colValues.get("t_bkg_qty"))     .append(" ]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[ ").append(colValues.get("t_teu"))         .append(" ]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[ ").append(colValues.get("bkg_cnt"))       .append(" ]]></TD>\n");   
			
			sbufXML.append("	</TR>\n");
			sbufXML.append(" <TR MERGE=\"TRUE\" HIDDEN='TRUE'> </TR>\n");
		}
		
		if(realCnt > 0){
			colValues = vos.get(realCnt-1).getColumnValues();
			sbufXML.append("	<TR BGCOLOR='235,235,235'>\n");
			sbufXML.append("		<TD><![CDATA[Sub Total]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[ ").append(colValues.get("sub_f_bkg_qty"))     .append(" ]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[ ").append(colValues.get("sub_f_teu"))         .append(" ]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[ ").append(colValues.get("sub_p_bkg_qty"))     .append(" ]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[ ").append(colValues.get("sub_p_teu"))         .append(" ]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[ ").append(colValues.get("sub_r_bkg_qty"))     .append(" ]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[ ").append(colValues.get("sub_r_teu"))         .append(" ]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[ ").append(colValues.get("sub_t_bkg_qty"))     .append(" ]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[ ").append(colValues.get("sub_t_teu"))         .append(" ]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[ ").append(colValues.get("sub_bkg_cnt"))       .append(" ]]></TD>\n");
			sbufXML.append("	</TR>\n");
			sbufXML.append(" <TR MERGE=\"TRUE\" HIDDEN='TRUE'> </TR>\n");
			sbufXML.append("	<TR BGCOLOR='225,225,225'>\n");
			sbufXML.append("		<TD><![CDATA[Grand Total]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[ ").append(colValues.get("grd_f_bkg_qty"))     .append(" ]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[ ").append(colValues.get("grd_f_teu"))         .append(" ]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[ ").append(colValues.get("grd_p_bkg_qty"))     .append(" ]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[ ").append(colValues.get("grd_p_teu"))         .append(" ]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[ ").append(colValues.get("grd_r_bkg_qty"))     .append(" ]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[ ").append(colValues.get("grd_r_teu"))         .append(" ]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[ ").append(colValues.get("grd_t_bkg_qty"))     .append(" ]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[ ").append(colValues.get("grd_t_teu"))         .append(" ]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[ ").append(colValues.get("grd_bkg_cnt"))       .append(" ]]></TD>\n");
			sbufXML.append("	</TR>\n");
		}
		sbufXML.append("</DATA>\n");
		sbufXML.append("<ETC-DATA>");
		sbufXML.append("</ETC-DATA>");		
		sbufXML.append("</SHEET>\n");
		
		//log.debug("########################## >> "+sbufXML);
		return sbufXML.toString();
	}
	
	
	/**
	 * VO List를 Parsing하여 <Data>태그 부분의 XML문자열을 반환한다.<br>
	 * 
	 * @param vos List<AbstractValueObject> List 객체
	 * @param colOrder String[] Column명 문자열 
	 * @param prefix String IBSheet savename's prefix
	 * @return String <Data>태그 부분의 XML문자열
	 * @exception 
	 */	
	protected String makeDataTagDefault(List<AbstractValueObject> vos, String prefix) {
		StringBuilder sbufXML = new StringBuilder();
		
		int totCnt = vos.size();
		int realCnt = vos.size();

		AbstractValueObject vo = (AbstractValueObject)vos.get(0);
		String[] realColNms=getColHeader(vo);
		String[] changedColNms = getChangedColNms(realColNms, prefix);
		
		if(vo.getMaxRows()>0){
			totCnt = vo.getMaxRows();
		}
		
		sbufXML.append("<DATA COLORDER='" + JSPUtil.convertStringArrayToString(changedColNms, "|") + "' COLSEPARATOR='" + DELIMITER + "' TOTAL='" + totCnt +"'>\n");

		for(int i=0;i<realCnt;i++){
			Map<String, String> colValues = vos.get(i).getColumnValues();
			
			sbufXML.append("	<TR><![CDATA[");
			int colCnt = realColNms.length;
			
			for (int j = 0 ; j < colCnt-1 ; j++) {
				sbufXML.append(getNull(colValues.get(realColNms[j])) + DELIMITER);
	        }
			sbufXML.append(getNull(colValues.get(realColNms[colCnt-1])) + "]]></TR>\n");
		}
		sbufXML.append("</DATA>\n");
		
		return sbufXML.toString();
	}	

	/**
	 * DBRowSet를 Parsing하여 <DATA>태그를 생성한다.<br>
	 * IBSheet의 prefix값이 있는 경우 COLORDER에 prefix를 붙인 column명으로 표시해 준다.<br>
	 * 
	 * @param rs DBRowSet 		VO객체
	 * @param prefix String 		IBSheet savename's prefix string
	 * @return String IBSheet 		<DATA>태그
	 * @exception 
	 */
	protected String makeDataTag(DBRowSet rs,String prefix) {
		StringBuilder sb = new StringBuilder();
		
		//Pivot Table인 경우 makePivotDataTag 실행하여  return한
		if(rs.isPivot()){
			sb.append(makePivotDataTag(rs));
			return sb.toString();
		}

		String[] realColNms = getColHeader(rs);

		try{
			String[] changedColNms = getChangedColNms(realColNms, prefix);
			
			sb.append("<DATA COLORDER='" + JSPUtil.convertStringArrayToString(changedColNms, "|") + "' COLSEPARATOR='" + DELIMITER + "' TOTAL='" + getRowSetCnt(rs) + "'>\n");
			
			int colCount = realColNms.length;
			
			while (rs.next()) { 
				sb.append("	<TR><![CDATA[");
				for (int j = 1 ; j < colCount ; j++) {
					sb.append(getNull(rs.getObject(j)) + DELIMITER);
				}	
				sb.append(getNull(rs.getObject(colCount))  + "]]></TR>\n");
			}
			sb.append("</DATA>\n");
		}catch(Exception ex){
			throw new RuntimeException(ex.getMessage());
		}
		return sb.toString();
	}
	/**
	 * Pivot Table용 Data tag를 생성한다.<br>
	 * 
	 * @param rs			DBRowSet 		VO객체
	 * @return String 	IBSheet 			<DATA>태그
	 * @exception 
	 */
	protected String makePivotDataTag(DBRowSet rs) {
		StringBuilder sb = new StringBuilder();
		int colCnt = 0;
		int rowCnt = rs.getRowCount();
		
		String[][] arrRowSet = null;

		try{
			colCnt = rs.getMetaData().getColumnCount();
			arrRowSet = new String[rowCnt][colCnt];
			
			int rowIdx = 0;
			while (rs.next()) { 
				for (int j = 1 ; j <= colCnt ; j++) {
					arrRowSet[rowIdx][j-1] = getNull(rs.getObject(j)).toString();
				}
				rowIdx++;
			}
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new RuntimeException(ex.getMessage());
		}
		
		try{
			sb.append("<DATA COLSEPARATOR='" + DELIMITER + "'>\n");
			if(rowCnt>0){
				for (int coIdx = 0 ;coIdx < colCnt ; coIdx++) {
					sb.append("	<TR><![CDATA[");
					for(int roIdx=0;roIdx < rowCnt-1; roIdx++){
						sb.append(arrRowSet[roIdx][coIdx] + DELIMITER);
					}
					sb.append(arrRowSet[rowCnt-1][coIdx]  + "]]></TR>\n");
				}//end for coIdx
			}//end for roIdx
			sb.append("</DATA>\n");
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new RuntimeException(ex.getMessage());
		}
		return sb.toString();
	}
	
	 protected String getETCData(EventResponse eventResponse)
	    {
	        if(eventResponse == null)
	            return "";
	        StringBuilder sb = new StringBuilder();
	        Map<String,String> etc_data = eventResponse.getETCData();
	        sb.append("<ETC-DATA>\n");
	        if(etc_data != null && etc_data.size() > 0)
	        {
	            String key;
	            String val;
	            for(Iterator<String> it = etc_data.keySet().iterator(); it.hasNext(); sb.append((new StringBuilder("<ETC KEY='")).append(key).append("'><![CDATA[").append(val).append("]]></ETC>\n").toString()))
	            {
	                key = (String)it.next();
	                val = (new StringBuilder()).append((String)etc_data.get(key)).toString();
	            }

	        }
	        sb.append(getPivotETCData(eventResponse));
	        sb.append("</ETC-DATA>\n");
	        return sb.toString();
	    }

}
