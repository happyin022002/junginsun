/*=========================================================
*Copyright(c) 2008 CyberLogitec
*@FileName : OrganTreeViewAdapter.java
*@FileTitle : Organization Tree View Adapter
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.02
*@LastModifier : 문동규
*@LastVersion : 1.0
* 2009.06.02 문동규
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esm.pri.primasterdata.authorizationassignment.event;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.ViewAdapter;

/**
 * 조직도 IBSheet XML 생성<br>
 * - IBSheet로 반환할 서버처리결과를 XML로 변환하는 클래스이다.<br>
 * 
 * @author Moon Dong Gyu
 * @see ViewAdapter 참조
 * @since J2EE 1.5
 */
public class OrganTreeViewAdapter extends ViewAdapter {

    
    /**
     * VO List를 Parsing하여 <Data>태그 부분의 XML문자열을 반환한다.<br>
     * 
     * @param List<AbstractValueObject> vos List 객체
     * @param String prefix IBSheet savename's prefix
     * @return String <Data>태그 부분의 XML문자열
     * @exception 
     */ 
    protected String makeDataTag(List<AbstractValueObject> vos, String prefix) {
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
        Map<String, String> colValues = null;
        
        for(int i=0;i<realCnt;i++){
            colValues = vos.get(i).getColumnValues();
            sbufXML.append(" <TR");
            if(!getNull(colValues.get("lvl")).equals("")){
                sbufXML.append(" LEVEL=\"");
                sbufXML.append(getNull(colValues.get("lvl")));
                sbufXML.append("\"");
            }

            if(!getNull(colValues.get("have_child")).equals("")){
                sbufXML.append(" HAVE-CHILD=\"");
                sbufXML.append((getNull(colValues.get("have_child")).equals("0"))?"TRUE":"FALSE");
                sbufXML.append("\"");
            }
            sbufXML.append("><![CDATA[");

            int colCnt = realColNms.length;
            
            for (int j = 0 ; j < colCnt-1 ; j++) {
                sbufXML.append(JSPUtil.getNull(colValues.get(realColNms[j])) + DELIMITER);
            }
            sbufXML.append(JSPUtil.getNull(colValues.get(realColNms[colCnt-1])) + "]]></TR>\n");
        }
        sbufXML.append("</DATA>\n");
        
        return sbufXML.toString();
    }

    /**
     * DBRowSet를 Parsing하여 <DATA>태그를 생성한다.<br>
     * IBSheet의 prefix값이 있는 경우 COLORDER에 prefix를 붙인 column명으로 표시해 준다.<br>
     * 
     * @param DBRowSet rs       VO객체
     * @param String prefix         IBSheet savename's prefix string
     * @return String IBSheet       <DATA>태그
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
                sb.append(" <TR");
                if(!getNull(rs.getObject("lvl")).equals("")){
                    sb.append(" LEVEL=\"");
                    sb.append(getNull(rs.getObject("lvl")));
                    sb.append("\"");
                }

                if(!getNull(rs.getObject("have_child")).equals("")){
                    sb.append(" HAVE-CHILD=\"");
                    sb.append((getNull(rs.getObject("have_child")).equals("0"))?"TRUE":"FALSE");
                    sb.append("\"");
                }
                
                sb.append("><![CDATA[");
                
                for (int j = 1 ; j < colCount ; j++) {
                    sb.append(getNull(rs.getObject(j)) + DELIMITER);
                }   
                sb.append(getNull(rs.getObject(colCount))  + "]]></TR>\n");
            }
            sb.append("</DATA>\n");
        }catch(SQLException ex){
            throw new RuntimeException(ex.getMessage());
        }catch(Exception ex){
            throw new RuntimeException(ex.getMessage());
        }
        return sb.toString();
    }

    /**
     * Pivot Table용 Data tag를 생성한다.<br>
     * 
     * @param DBRowSet rs VO객체
     * @return String IBSheet           <DATA>태그
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
                    sb.append(" <TR><![CDATA[");
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
