/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmSpc0066Event.java
*@FileTitle : Allocation Change by VVD
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.25
*@LastModifier : 최윤성
*@LastVersion : 1.0
* 2009.08.14 최윤성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.event;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.spc.common.common.vo.ConditionVO;
import com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SpaceAllocationManageTempListVO;
import com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SpaceAllocationManageVO;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.ViewAdapter;

/**
 * 기본 IBSheet XML 생성<br>
 * - IBSheet로 반환할 서버처리결과를 XML로 변환하는 클래스이다.<br>
 * 
 * @author CHOI Yun Sung
 * @see ViewAdapter 참조
 * @since CHOI Yun Sung
 */
public class EsmSpc0066ViewAdapter extends ViewAdapter {

	
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
		
		SpaceAllocationManageVO spaceAllocationManageVO = (SpaceAllocationManageVO)vos.get(0);
		ConditionVO conditionVO = spaceAllocationManageVO.getConditionVO();
		
		List<SpaceAllocationManageTempListVO> spaceAllocationManageTempVOs = spaceAllocationManageVO.getSpaceAllocationManageTempListVOs();
		AbstractValueObject vo = (AbstractValueObject)spaceAllocationManageTempVOs.get(0);
		
		int totCnt  = spaceAllocationManageTempVOs.size();
		int realCnt = spaceAllocationManageTempVOs.size();
		
		if(vo.getMaxRows()>0){
			totCnt = vo.getMaxRows();
		}
		
		String pol_cd     = conditionVO.getPolCd();
		String pod_cd     = conditionVO.getPodCd();
		String ts_flg     = (conditionVO.getIocCd().indexOf("T/S")>=0)?"Y":"N";
		String rlane_cd   = conditionVO.getRlaneCd();
		String dir_cd     = conditionVO.getDirCd();
		String vsl_cd     = conditionVO.getVslCd();
		String skd_voy_no = conditionVO.getSkdVoyNo();
		String skd_dir_cd = conditionVO.getSkdDirCd();
		String ofc_cd     = conditionVO.getOfcCd();
		String ioc_cd     = (conditionVO.getIocCd().indexOf("OCN")>=0)?"O":"I";
		
		sbufXML.append("<DATA TOTAL='" + totCnt + "'>\n");
		
		for(int i=0;i<realCnt;i++){
			Map<String, String> colValues = spaceAllocationManageTempVOs.get(i).getColumnValues();
			
			sbufXML.append("<TR>");
            sbufXML.append("	<TD></TD>");
            sbufXML.append("	<TD>" + (getNull(colValues.get("flag").equals("N")?"Y":"N")) + "</TD>");
            sbufXML.append("	<TD>" + getNull(colValues.get("flag")) + "</TD>");
            sbufXML.append("	<TD>" + getNull(colValues.get("ofc_cd"))  + "</TD>");
            sbufXML.append("	<TD>" + pol_cd + "</TD>");
            sbufXML.append("	<TD>" + pod_cd + "</TD>");
            sbufXML.append("	<TD>" + ts_flg + "</TD>");
            sbufXML.append("	<TD>" + rlane_cd + "</TD>");
            sbufXML.append("	<TD>" + dir_cd + "</TD>");
            sbufXML.append("	<TD>" + vsl_cd + "</TD>");
            sbufXML.append("	<TD>" + skd_voy_no + "</TD>");
            sbufXML.append("	<TD>" + skd_dir_cd + "</TD>");
            sbufXML.append("	<TD>" + ioc_cd + "</TD>");
            sbufXML.append("	<TD>" + ofc_cd + "</TD>");
			sbufXML.append("</TR>\n");
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