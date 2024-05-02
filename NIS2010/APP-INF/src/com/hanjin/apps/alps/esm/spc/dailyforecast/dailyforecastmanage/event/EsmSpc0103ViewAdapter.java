/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmSpc0103ViewAdapter.java
*@FileTitle : dailyforecastmanage
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.03
*@LastModifier : 한상훈
*@LastVersion : 1.0
* 2009.08.13 한상훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastmanage.event;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastmanage.vo.DailyforecastmanageMainVO;
import com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastmanage.vo.DailyforecastmanageConditionVO;
import com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastmanage.vo.SearchDailyForecastSrepAccountManageListVO;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.ViewAdapter;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.component.message.ErrorHandler;

/**
 * 기본 IBSheet XML 생성<br>
 * - IBSheet로 반환할 서버처리결과를 XML로 변환하는 클래스이다.<br>
 * 
 * @author 한상훈
 * @see ViewAdapter 참조
 * @since J2EE 1.5
 */
public class EsmSpc0103ViewAdapter extends ViewAdapter{
	/**
	public String makeXML(HttpServletRequest request, HttpServletResponse response)
    {
        GeneralEventResponse eventResponse = null;
        Exception serverException = null;
        String strXML = "";
        
        try
        {
            serverException = (Exception)request.getAttribute("com.hanjin.framework.core.comm.EXCEPTION_OBJECT      ");
            eventResponse = (GeneralEventResponse)request.getAttribute("EventResponse");
            if(eventResponse != null)
            {
            	if(eventResponse.getDataCntList().size() == 0)
            	{
            		log.debug("000000000");
                    strXML = getNoSearchResultXML(false, false, eventResponse);
            	}
            	else
            	{
            		log.debug("111111111111111");
                	strXML = makeDataTag(eventResponse.getRsVoList(),"");
            	}
            }            
        }
        catch(Exception ex)
        {
            log.error(ex.getMessage(), ex);
        }
        if(log.isDebugEnabled())
            log.debug((new StringBuilder("\n")).append(strXML).toString());
        return strXML;
    }
	*/
	/**
	 * VO List를 Parsing하여 <Data>태그 부분의 XML문자열을 반환한다.<br>
	 * 
	 * @param vos List<AbstractValueObject> List 객체
	 * @param colOrder String[] Column명 문자열 
	 * @param prefix String IBSheet savename's prefix
	 * @return String <Data>태그 부분의 XML문자열
	 * @exception 
	 */	
	protected String makeDataTag(List<AbstractValueObject> vos, String prefix) 
	{
		log.debug("EsmSpc0103ViewAdapter makeDataTag List<AbstractValueObject> vos, String prefix..............");
		StringBuilder sbufXML = new StringBuilder();
		
		DailyforecastmanageMainVO comMain = (DailyforecastmanageMainVO)vos.get(0);
		
		log.debug("comMain.getEventCommand()11:"+comMain.getEventCommand());
		
		
		List<SearchDailyForecastSrepAccountManageListVO> list = comMain.getVoList();
		
		int rowCount = list.size();
		
		//sbufXML.append("<SHEET>\n");
		sbufXML.append("<DATA TOTAL=\""+rowCount+"\">\n");
		
		if (rowCount > 0) {//3.1
			for(int i = 0; i < rowCount;i++){
		sbufXML.append("<TR>\n");
		sbufXML.append("<TD></TD>\n");
		sbufXML.append("<TD>"+list.get(i).getCustCntCd()+list.get(i).getCustSeq()+"</TD>\n");
		sbufXML.append("<TD><![CDATA["+list.get(i).getCustNm()+"]]></TD>\n");
		sbufXML.append("<TD>"+list.get(i).getSrepCd()+"</TD>\n");
		sbufXML.append("<TD>"+list.get(i).getTrdCd()+"</TD>\n");
		sbufXML.append("<TD>"+list.get(i).getSubTrdCd()+"</TD>\n");
		sbufXML.append("<TD>"+list.get(i).getRlaneCd()+"</TD>\n");
		sbufXML.append("<TD>"+list.get(i).getDirCd()+"</TD>\n");
		sbufXML.append("<TD>"+list.get(i).getIocTsCd()+"</TD>\n");
		sbufXML.append("<TD>"+list.get(i).getCustCntCd()+"</TD>\n");
		sbufXML.append("<TD>"+list.get(i).getCustSeq()+"</TD>\n");
		sbufXML.append("<TD>"+list.get(i).getFcastCustTpCd()+"</TD>\n");
		sbufXML.append("</TR>\n");
		
			}
		}
		sbufXML.append("</DATA>\n");
		//sbufXML.append("</SHEET>\n");	
		
	
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
		}catch(SQLException ex){
			throw new RuntimeException(ex.getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
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
		}catch(SQLException ex){
			log.error(ex.getMessage(),ex);
			throw new RuntimeException(ex.getMessage());
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
	
	
	
}