/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EsdSpe1003ViewAdapter.java
*@FileTitle : Default IBSheet Generation Class
*Open Issues :
*Change history :
*@LastModifyDate : 2015-03-26
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015-03-26 Park ChangJune
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.spe.egmaster.spservicecategory.event;
		
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esd.spe.egmaster.spservicecategory.vo.SpeSvcCateVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.LongRangeSkdInqVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.LongRangeSkdVO;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.ViewAdapter;

/**
 * 기본 IBSheet XML 생성<br>
 * - IBSheet로 반환할 서버처리결과를 XML로 변환하는 클래스이다.<br>
 * 
 * @author Park ChangJune
 * @see ViewAdapter 참조
 * @since J2EE 1.5
 */
public class EsdSpe1003ViewAdapter extends ViewAdapter {

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

		AbstractValueObject vo = (AbstractValueObject)vos.get(0);
		String[] realColNms = {"isflag"};
		
		if(vo.getMaxRows()>0){
			totCnt = vo.getMaxRows();
		}
		
		/**
		 * 변수선언
		 */
		String invCurrCd  = "";

		//sbufXML.append("<DATA " + "COLSEPARATOR='" + DELIMITER + "' TOTAL='" + totCnt +"'>\n");
		sbufXML.append("<DATA COLORDER='isflag|'  COLSEPARATOR='☜☞' TOTAL='1'>\n");

		for(int i=0;i<realCnt;i++){
			Map<String, String> colValues = vos.get(i).getColumnValues();
			
			sbufXML.append("<TR>");
			for (int j = 0 ; j < 1 ; j++) {
				sbufXML.append("<![CDATA[");
				sbufXML.append(JSPUtil.getNull(colValues.get(realColNms[j])));
			sbufXML.append("]]>\n");
			}
			sbufXML.append("</TR>\n");
			
			invCurrCd = "";
			
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
			DBRowSet rs2=rs.createCopy();
			String plusCol =""; 
			String[] plusColArr = null;
			if(rs2.next()){
				plusCol = rs2.getString("pluscol");
			}
			plusColArr = plusCol.split(",");
			String[] changedColNms = getChangedColNms(realColNms, prefix);
			
			sb.append("<DATA COLORDER='" + JSPUtil.convertStringArrayToString(changedColNms, "|")+plusCol.replaceAll(",", "|")+"|save_sc_val|" + "' COLSEPARATOR='" + DELIMITER + "' TOTAL='" + getRowSetCnt(rs) + "'>\n");
			
			int colCount = realColNms.length;
			String sp_seq = "";
			int forCnt=0;
			int rsFlag=0;
			String saveScVal = "";
			while (rs.next()) { 
				
				if(rsFlag!=0 &&!sp_seq.equals(rs.getString("sp_seq"))){
					if(forCnt<plusColArr.length){
						for(int k=forCnt;k<plusColArr.length;k++){
								sb.append(0 + DELIMITER);		
						}						
					}
					sb.append(saveScVal  + "]]></TR>\n");
					saveScVal = "";
					forCnt=0;
				}
				rsFlag++;
				if(!sp_seq.equals(rs.getString("sp_seq"))){
					sp_seq = rs.getString("sp_seq");
					sb.append("	<TR><![CDATA[");
					for (int j = 1 ; j < colCount ; j++) {
						sb.append(JSPUtil.getNull(rs.getObject(j)) + DELIMITER);
					}	
					sb.append(JSPUtil.getNull(rs.getObject(colCount))+ DELIMITER);
						for(int k=0;k<plusColArr.length;k++){
							if(plusColArr[k].equals(rs.getString("ev_svc_cate_cd"))){
								sb.append(1 + DELIMITER);
								saveScVal = saveScVal+plusColArr[k]+",";
								forCnt=k+1;
								k= plusColArr.length;
							}else{
								sb.append(0 + DELIMITER);
								forCnt=k+1;
								
							}
						}
				}else{
					
						for(int k=forCnt;k<plusColArr.length;k++){
							if(plusColArr[k].equals(rs.getString("ev_svc_cate_cd"))){
								sb.append(1 + DELIMITER);
								saveScVal = saveScVal+plusColArr[k]+",";
								forCnt=k+1;
								k= plusColArr.length;
							}else{
								sb.append(0 + DELIMITER);		
								forCnt=k+1;
								
							}
						}
					
				}
			}
			if(forCnt<plusColArr.length && !plusCol.equals("")){
				for(int k=forCnt;k<plusColArr.length;k++){
						sb.append(0 + DELIMITER);		
				}						
			}			
			if(!plusCol.equals("")){
				sb.append(saveScVal+"]]></TR>\n");
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
					arrRowSet[rowIdx][j-1] = JSPUtil.getNull(rs.getObject(j)).toString();
				}
				rowIdx++;
			}
		
	
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
			
		}catch(SQLException ex){
			log.error(ex.getMessage(),ex);
			throw new RuntimeException(ex.getMessage());
		

		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new RuntimeException(ex.getMessage());
		}
		return sb.toString();
	}

}
