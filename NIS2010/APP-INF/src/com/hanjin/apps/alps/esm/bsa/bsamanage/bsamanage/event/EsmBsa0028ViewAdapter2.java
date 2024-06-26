
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBsa0021ViewAdapter.java
*@FileTitle : EsmBsa0021ViewAdapter
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.14
*@LastModifier : 김기대
*@LastVersion : 1.0
* 2009.07.14 김기대
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.event;

import java.sql.SQLException;
import java.util.List;

import com.hanjin.apps.alps.esm.bsa.common.vo.CommonBsaRsVO;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.controller.DefaultViewAdapter;
import com.hanjin.framework.core.controller.html.HTMLAction;

/**
 * ESM_BSA_0028 에 대한 ViewAdapter<br>
 * - ESM_BSA_0028HTMLAction에서 작성<br>
 *
 * @author 남궁진호
 * @see HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmBsa0028ViewAdapter2 extends DefaultViewAdapter {
	
    public EsmBsa0028ViewAdapter2(){
    	super();
    }
    
    protected String makeDataTag(List<AbstractValueObject> list, String prefix) {
    	log.debug("########### EsmBsa0028ViewAdapter.makeDataTag(List<AbstractValueObject> list, String prefix) ########### [START]");
    	CommonBsaRsVO rsVo = (CommonBsaRsVO)list.get(0);
    	CommonBsaRsVO[] arrayVo = rsVo.getCommonBsaRsVOArray();
		
		log.debug("arrayVo.length = " + arrayVo.length);
		
		DBRowSet rowSet1 = arrayVo[0].getDbRowset();
		
		
		if(rowSet1 == null  ){
			if(rowSet1 == null){
				log.debug("rowSet1 은 널입니다.");
			}			
			return "";
		}
		log.debug("getRowSetCnt(rowSet1) = " + getRowSetCnt(rowSet1));
		        
        // RowSet ========================================================================================== S
        // =======================================================================================================
        
        StringBuilder strBuilder = new StringBuilder();
        if(rowSet1.isPivot()){
        	strBuilder.append(makePivotDataTag(rowSet1));
        	return strBuilder.toString();
        }        
        
    	int totCnt2  = getRowSetCnt(rowSet1);//rs.getRowCount()
    	
    	log.debug("totCnt2 = " + totCnt2);
    	
    	String[] realColNms = getColHeader(rowSet1);
    	int colCount = realColNms.length;
    	try{
		      
		    if(rowSet1.getMaxRows() > 0){
		      	totCnt2 = rowSet1.getMaxRows();
		    }  
		    
		    strBuilder.append("<DATA TOTAL=\""+totCnt2+"\">");
		    if(totCnt2 > 0){
	    		while(rowSet1.next()){		
					strBuilder.append("<TR>");
					strBuilder.append("  <TD></TD>");
					strBuilder.append("  <TD>R</TD>");
					
					strBuilder.append("	<TD>"+getNull(rowSet1.getString("grp"))+"</TD>");
					strBuilder.append("	<TD>"+getNull(rowSet1.getString("maxseq"))+"</TD>");
					strBuilder.append("	<TD>"+getNull(rowSet1.getString("rf_scg_slt_prc_seq"))+"</TD>");
					strBuilder.append("	<TD>"+getNull(rowSet1.getString("rf_scg_slt_prc_seq"))+"</TD>");
					strBuilder.append("	<TD>"+getNull(rowSet1.getString("vvd_cd"))+"</TD>");
					strBuilder.append("	<TD>"+getNull(rowSet1.getString("bsa_slt_prc_fm_dt"))+"</TD>");
					strBuilder.append("	<TD>"+getNull(rowSet1.getString("bsa_slt_prc_to_dt"))+"</TD>");
					strBuilder.append("	<TD>"+getNull(rowSet1.getString("trd_cd"))+"</TD>");
					strBuilder.append("	<TD>"+getNull(rowSet1.getString("rlane_cd"))+"</TD>");
					strBuilder.append("	<TD>"+getNull(rowSet1.getString("dir_cd"))+"</TD>");
					strBuilder.append("	<TD>"+getNull(rowSet1.getString("rt_teu_flg"))+"</TD>");
					strBuilder.append("	<TD>"+getNull(rowSet1.getString("bsa_slt_cost_tp_cd"))+"</TD>");
					for (int j = 12 ; j <= colCount ; j++) {
						strBuilder.append("<TD>"+getNull(rowSet1.getObject(j)) + "</TD>");
					}	
					strBuilder.append("</TR>\n");
					
					//log.debug("strBuilder = " + strBuilder);
	    		}
		    }
		    
		   
		    strBuilder.append("</DATA>");
		    strBuilder.append("<ETC-DATA>");		    
		    strBuilder.append("</ETC-DATA>");			    
        }
        catch(SQLException ex){
            throw new RuntimeException(ex.getMessage());
        }
        catch(Exception ex){
            log.error(ex.getMessage(), ex);
            throw new RuntimeException(ex.getMessage());
        }
        // =======================================================================================================
        // 두번째 RowSet ========================================================================================== E
		
		log.debug("########### EsmBsa0028ViewAdapter.makeDataTag(List<AbstractValueObject> list, String prefix) ########### [END]");
	    return strBuilder.toString();
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
//	protected String makeDataTag(DBRowSet rs,String prefix) {
//		StringBuilder sb = new StringBuilder();
//		//Pivot Table인 경우 makePivotDataTag 실행하여  return한
//		if(rs.isPivot()){
//			sb.append(makePivotDataTag(rs));
//			return sb.toString();
//		}
//
//		String[] realColNms = getColHeader(rs);
//
//		try{
//			//String[] changedColNms = getChangedColNms(realColNms, prefix);
//			
//			sb.append("<DATA  TOTAL='" + getRowSetCnt(rs) + "'>\n");
//			
//			int colCount = realColNms.length;
//		
// 			while (rs.next()) { 
//				sb.append("	<TR>");
//				sb.append("	<TD></TD>");
//				for (int j = 1 ; j <= colCount ; j++) {
//					sb.append("<TD>"+getNull(rs.getObject(j)) + "</TD>");
//				}	
//				//sb.append(getNull(rs.getObject(colCount))  + "</TR>\n");
//				sb.append("</TR>\n");
//			}
//			sb.append("</DATA>\n");
//		}catch(SQLException ex){
//			throw new RuntimeException(ex.getMessage());
//		}catch(Exception ex){
//			log.error(ex.getMessage(),ex);
//			throw new RuntimeException(ex.getMessage());
//		}
//
//		return sb.toString();
//	}
//
//	/**
//	 * Pivot Table용 Data tag를 생성한다.<br>
//	 * 
//	 * @param rs			DBRowSet 		VO객체
//	 * @return String 	IBSheet 			<DATA>태그
//	 * @exception 
//	 */
//	protected String makePivotDataTag(DBRowSet rs) {
//		StringBuilder sb = new StringBuilder();
//		int colCnt = 0;
//		int rowCnt = rs.getRowCount();
//		
//		String[][] arrRowSet = null;
//
//		try{
//			colCnt = rs.getMetaData().getColumnCount();
//			arrRowSet = new String[rowCnt][colCnt];
//			
//			int rowIdx = 0;
//			while (rs.next()) { 
//				for (int j = 1 ; j <= colCnt ; j++) {
//					arrRowSet[rowIdx][j-1] = getNull(rs.getObject(j)).toString();
//				}
//				rowIdx++;
//			}
//		}catch(SQLException ex){
//			log.error(ex.getMessage(),ex);
//			throw new RuntimeException(ex.getMessage());
//		}catch(Exception ex){
//			log.error(ex.getMessage(),ex);
//			throw new RuntimeException(ex.getMessage());
//		}
//
//		
//		try{
//			sb.append("<DATA COLSEPARATOR='" + DELIMITER + "'>\n");
//			if(rowCnt>0){
//				for (int coIdx = 0 ;coIdx < colCnt ; coIdx++) {
//					sb.append("	<TR><![CDATA[");
//					for(int roIdx=0;roIdx < rowCnt-1; roIdx++){
//						sb.append(arrRowSet[roIdx][coIdx] + DELIMITER);
//					}
//					sb.append(arrRowSet[rowCnt-1][coIdx]  + "]]></TR>\n");
//				}//end for coIdx
//			}//end for roIdx
//			sb.append("</DATA>\n");
//		}catch(Exception ex){
//			log.error(ex.getMessage(),ex);
//			throw new RuntimeException(ex.getMessage());
//		}
//		return sb.toString();
//	}        
	
}
