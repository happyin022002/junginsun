/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CountryCode.java
 *@FileTitle : CountryCode
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.29
 *@LastModifier : 김영출
 *@LastVersion : 1.0
 * 2009.04.23 김영출
 * 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.common;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.ViewAdapter;
import com.clt.framework.core.layer.event.EventResponse;

/**
 * 기본 IBSheet XML 생성<br>
 * - IBSheet로 반환할 서버처리결과를 XML로 변환하는 클래스이다.<br>
 * 
 * @author Lee SeungYol
 * @see ViewAdapter 참조
 * @since J2EE 1.5
 */
public class BkgViewAdapter extends ViewAdapter {

    /**
     * Bkg No Split이나 기타 Trim을 요하지 않는 경우를 위해
     */
    protected String nvl(Object object) {
        return object == null ? "" : object.toString();
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

        int totCnt = vos.size();
        int realCnt = vos.size();

        AbstractValueObject vo = (AbstractValueObject) vos.get(0);
        String[] realColNms = getColHeader(vo);
        String[] changedColNms = getChangedColNms(realColNms, prefix);

        if(vo.getMaxRows() > 0) {
            totCnt = vo.getMaxRows();
        }

        sbufXML.append("<DATA COLORDER='" + JSPUtil.convertStringArrayToString(changedColNms, "|") + "' COLSEPARATOR='"
                + DELIMITER + "' TOTAL='" + totCnt + "'>\n");

        for(int i = 0; i < realCnt; i++) {
            Map<String, String> colValues = vos.get(i).getColumnValues();

            sbufXML.append("	<TR><![CDATA[");
            int colCnt = realColNms.length;

            for(int j = 0; j < colCnt - 1; j++) {
                sbufXML.append(this.nvl(colValues.get(realColNms[j])) + DELIMITER);
            }
            sbufXML.append(this.nvl(colValues.get(realColNms[colCnt - 1])) + "]]></TR>\n");
        }
        sbufXML.append("</DATA>\n");

        return sbufXML.toString();
    }

    /**
     * DBRowSet를 Parsing하여 <DATA>태그를 생성한다.<br>
     * IBSheet의 prefix값이 있는 경우 COLORDER에 prefix를 붙인 column명으로 표시해 준다.<br>
     * 
     * @param rs DBRowSet VO객체
     * @param prefix String IBSheet savename's prefix string
     * @return String IBSheet <DATA>태그
     * @exception
     */
    protected String makeDataTag(DBRowSet rs, String prefix) {
        StringBuilder sb = new StringBuilder();

        // Pivot Table인 경우 makePivotDataTag 실행하여 return한
        if(rs.isPivot()) {
            sb.append(makePivotDataTag(rs));
            return sb.toString();
        }

        String[] realColNms = getColHeader(rs);

        try {
            String[] changedColNms = getChangedColNms(realColNms, prefix);

            sb.append("<DATA COLORDER='" + JSPUtil.convertStringArrayToString(changedColNms, "|") + "' COLSEPARATOR='"
                    + DELIMITER + "' TOTAL='" + getRowSetCnt(rs) + "'>\n");

            int colCount = realColNms.length;

            while(rs.next()) {
                sb.append("	<TR><![CDATA[");
                for(int j = 1; j < colCount; j++) {
                    sb.append(this.nvl(rs.getObject(j)) + DELIMITER);
                }
                sb.append(this.nvl(rs.getObject(colCount)) + "]]></TR>\n");
            }
            sb.append("</DATA>\n");
        } catch(Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }
        return sb.toString();
    }

    /**
     * Pivot Table용 Data tag를 생성한다.<br>
     * 
     * @param rs DBRowSet VO객체
     * @return String IBSheet <DATA>태그
     * @exception
     */
    protected String makePivotDataTag(DBRowSet rs) {
        StringBuilder sb = new StringBuilder();
        int colCnt = 0;
        int rowCnt = rs.getRowCount();

        String[][] arrRowSet = null;

        try {
            colCnt = rs.getMetaData().getColumnCount();
            arrRowSet = new String[rowCnt][colCnt];

            int rowIdx = 0;
            while(rs.next()) {
                for(int j = 1; j <= colCnt; j++) {
                    arrRowSet[rowIdx][j - 1] = this.nvl(rs.getObject(j)).toString();
                }
                rowIdx++;
            }
        } catch(Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new RuntimeException(ex.getMessage());
        }

        try {
            sb.append("<DATA COLSEPARATOR='" + DELIMITER + "'>\n");
            if(rowCnt > 0) {
                for(int coIdx = 0; coIdx < colCnt; coIdx++) {
                    sb.append("	<TR><![CDATA[");
                    for(int roIdx = 0; roIdx < rowCnt - 1; roIdx++) {
                        sb.append(arrRowSet[roIdx][coIdx] + DELIMITER);
                    }
                    sb.append(arrRowSet[rowCnt - 1][coIdx] + "]]></TR>\n");
                }// end for coIdx
            }// end for roIdx
            sb.append("</DATA>\n");
        } catch(Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new RuntimeException(ex.getMessage());
        }
        return sb.toString();
    }

    protected String getETCData(EventResponse eventResponse) {
        if(eventResponse == null) return "";

        StringBuilder sb = new StringBuilder();
        HashMap<String, String> etc_data = (HashMap<String, String>) eventResponse.getETCData();

        sb.append("<ETC-DATA>\n");
        if(etc_data != null && etc_data.size() > 0) {
            Iterator<String> it = etc_data.keySet().iterator();
            while(it.hasNext()) {
                String key = (String) it.next();
                sb.append("<ETC KEY='" + key + "'><![CDATA[" + this.nvl(etc_data.get(key)) + "]]></ETC>\n");
            }
        }
        // Pivot 관련 ETC-DATA생성
        sb.append(getPivotETCData(eventResponse));
        sb.append("</ETC-DATA>\n");

        return sb.toString();
    }
}
