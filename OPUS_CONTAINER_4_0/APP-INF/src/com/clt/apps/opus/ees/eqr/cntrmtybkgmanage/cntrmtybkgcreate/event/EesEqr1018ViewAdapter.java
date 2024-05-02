/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : EesEqr1018ViewAdapter.java
*@FileTitle : Execution Plan
*Open Issues :
*Change history : 1. 2014-03-07, CHM-201429123, ROB booking 기능 추가, YongChan Shin
*@LastModifyDate : 2013.08.06
*@LastModifier : 
*@LastVersion : 1.0
* 2013.08.06 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.cntrmtybkgmanage.cntrmtybkgcreate.event;

import java.sql.SQLException;
import java.util.List;

//import com.clt.apps.opus.ees.eqr.cntrmtybkgmanage.cntrmtybkgcreate.vo.EesEqr1018ConditionVO;
import com.clt.apps.opus.ees.eqr.cntrcommon.vo.CommonRsVO;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.ViewAdapter;

/**
 * 기본 IBSheet XML 생성<br>
 * - IBSheet로 반환할 서버처리결과를 XML로 변환하는 클래스이다.<br>
 * 
 * @author Lee SeungYol
 * @see ViewAdapter 참조
 * @since J2EE 1.5
 */
public class EesEqr1018ViewAdapter extends ViewAdapter {

	
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
		
		CommonRsVO commonRsVO = (CommonRsVO) vos.get(0);
//		EesEqr1018ConditionVO conditionVO = (EesEqr1018ConditionVO) commonRsVO.getConditionVO();
		DBRowSet rs = commonRsVO.getDbRowset();
		String[] realColNms		= getColHeader(rs);
		
		int totCnt = vos.size();				
		totCnt = rs.getRowCount();
//		log.debug("totCnt======== : " +totCnt);
		
		String editStatus			= "";
		String rowBgColor			= "";
		String dataFormat			= "";
		
		String sortNum	  = "";  // /	PLAN(1), Execution(2)
		String bkg_flag	  = "";  // bkg 여부
		String split_flag = "";	
		String trspModCd  = ""; // V,W(TRUNK, FEEDER)
		
		sbufXML.append("<DATA TOTAL='" + totCnt +"'>"+"\n");
		
		try{
			while ( rs.next() ){
				int colCnt = realColNms.length;

				sortNum    = rs.getString("ORD_SEQ");	//	PLAN(1), Execution(2)
				bkg_flag   = rs.getString("MTY_BKG_FLG");
				split_flag = rs.getString("MTY_BKG_SPLIT_FLG");
				trspModCd  = rs.getString("TRSP_MOD_CD");
				
				// ROW별 수정가능여부 결정
				if ( sortNum.equals("2") && ! bkg_flag.equals("Y")){// plan 아니고 MTY_BKG_FLG = n 이면 수정 가능
					editStatus			= "";
				} else {
					editStatus			= "EDIT=\"FALSE\" ";
				}
								
				// ROW별 색상셋팅
				if ( sortNum.equals("1") ){			// PLAN 라인	
					rowBgColor	= "BGCOLOR=\"203,239,234\" ";
				} else if ( sortNum.equals("2") && split_flag.equals("Y") ) {	// SPLIT EXECUTE 라인
					rowBgColor	= "BGCOLOR=\"215,215,213\" ";
				} else {
					rowBgColor	= "";
				}
				
				sbufXML.append("<TR " + rowBgColor + ">");
				sbufXML.append("<TD " + editStatus + "></TD>");
				sbufXML.append("<TD " + editStatus + ">R</TD>");  // HIDDEN EDITSTATUS
				
				for( int j=1; j<=colCnt; j++ ) {	
					if ( j == 7 ) {	// mty rob flg 제어
						if( sortNum.equals("1")) { // PLAN 인 경우
							dataFormat = "";
						}else { // PLAN 아닌고 TRUNK 인 겨우만 가능(결정 안됨)
//							if(trspModCd.equals("V")) dataFormat = " DATA-TYPE=\"dtCheckBox\" ";  // TRUNK 만 ROB 가능
//							else                      dataFormat = "";
							
							dataFormat = " DATA-TYPE=\"dtCheckBox\" ";  
						}
					}else {
						dataFormat = "";
					}
					
					sbufXML.append("<TD " + editStatus + dataFormat+ "><![CDATA[" + getNull(rs.getString(j))+ "]]></TD>");
				}
				
				sbufXML.append("</TR>"+"\n");
			}
		} catch(SQLException ex){
			throw new RuntimeException(ex.getMessage());
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new RuntimeException(ex.getMessage());
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
			
			while (rs.next()) { 				sb.append("	<TR><![CDATA[");
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
