
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
package com.clt.apps.opus.esm.bsa.bsamanage.spcmanage.event;

import java.sql.SQLException;
import java.util.List;

import com.clt.apps.opus.esm.bsa.common.vo.CommonBsaRsVO;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.DefaultViewAdapter;
import com.clt.framework.core.controller.html.HTMLAction;

/**
 * ESM_BSA_0030 에 대한 ViewAdapter<br>
 * - ESM_BSA_0030HTMLAction에서 작성<br>
 *
 * @author 남궁진호
 * @see HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmBsa0030ViewAdapter extends DefaultViewAdapter {
	
    public EsmBsa0030ViewAdapter(){
    	super();
    }
    
    protected String makeDataTag(List<AbstractValueObject> list, String prefix) {
    	log.debug("########### EsmBsa0030ViewAdapter.makeDataTag(List<AbstractValueObject> list, String prefix) ########### [START]");
    	CommonBsaRsVO rsVo = (CommonBsaRsVO)list.get(0);
    	CommonBsaRsVO[] arrayVo = rsVo.getCommonBsaRsVOArray();
		
    	DBRowSet rowSet1 = arrayVo[0].getDbRowset();
		DBRowSet rowSet2 = arrayVo[1].getDbRowset();
		
		log.debug("arrayVo.length = " + arrayVo.length);
		
		if(rowSet1 == null || rowSet2 == null ){
			if(rowSet1 == null){
				log.debug("rowSet1 은 Null입니다.");
			}			
			if(rowSet2 == null){
				log.debug("rowSet2 은 Null입니다.");
			}
			return "";
		}
		log.debug("getRowSetCnt(rowSet1) = " + getRowSetCnt(rowSet1));
		log.debug("getRowSetCnt(rowSet2) = " + getRowSetCnt(rowSet2));
		// 첫번째 RowSet ========================================================================================== S
		// =======================================================================================================
		
		int cnt = 0;
		
		String bsa_op_jb_cd = "";
		String crr_cd = "";
		String crrCD = "";
		String saveNM = "";			// sheet의 save name
		String crr_cnt = "";	    // op_job_cd에 들어 있는 crr_cd의 갯수
		String tmp = "";
		
    	int totCnt  = getRowSetCnt(rowSet1);//rs.getRowCount()
    	
    	log.debug("totCnt = " + totCnt);

    	try{
		      
		    if(rowSet1.getMaxRows() > 0){
		      	totCnt = rowSet1.getMaxRows();
		    }  
		    
		    if(totCnt > 0){
		        StringBuffer sb1 = new StringBuffer();											//SJH.20150508.소스품질      		
		        StringBuffer sb2 = new StringBuffer();
		        
	    		while(rowSet1.next()){
	    			if(cnt == 0) rowSet1.first();
    				bsa_op_jb_cd = JSPUtil.getNull(rowSet1.getString("bsa_op_jb_cd"));
    				crr_cd = JSPUtil.getNull(rowSet1.getString("crr_cd"));
//    				saveNM = saveNM + crr_cd + bsa_op_jb_cd + "|";
//    				crrCD = crrCD  + crr_cd + "|";
    				sb1.append(crr_cd).append(bsa_op_jb_cd).append("|");						//SJH.20150508.소스품질      	
    				sb2.append(crr_cd).append("|");
    				saveNM = sb1.toString();	
    				crrCD  = sb2.toString();	
    				
    				if(tmp.equals("") || bsa_op_jb_cd.equals(tmp)){
						cnt++;
					} else {
						crr_cnt = crr_cnt + cnt +"|";
						cnt = 1;
					}
					tmp = JSPUtil.getNull(rowSet1.getString("bsa_op_jb_cd"));
	    		}
	    		crr_cnt = crr_cnt + cnt ;
				saveNM = saveNM.substring(0, saveNM.length()-1);
				crrCD = crrCD.substring(0, crrCD.length()-1);
		    }
        }
        catch(SQLException ex){
            throw new RuntimeException(ex.getMessage());
        }
        catch(Exception ex){
            log.error(ex.getMessage(), ex);
            throw new RuntimeException(ex.getMessage());
        }
        // =======================================================================================================
        // 첫번째 RowSet ========================================================================================== E
        
        
        // 두번째 RowSet ========================================================================================== S
        // =======================================================================================================
        
        StringBuilder strBuilder = new StringBuilder();
        if(rowSet2.isPivot()){
        	strBuilder.append(makePivotDataTag(rowSet2));
        	return strBuilder.toString();
        }        
        
    	int totCnt2  = getRowSetCnt(rowSet2);//rs.getRowCount()
    	
    	log.debug("totCnt2 = " + totCnt2);
        
    	String realColNms2[] = getColHeader(rowSet2);
    	try{
    		int colCount = realColNms2.length;
    		
		    if(rowSet2.getMaxRows() > 0){
		      	totCnt2 = rowSet2.getMaxRows();
		    }  
		    
		    strBuilder.append("<DATA TOTAL=\""+totCnt2+"\">");
		    if(totCnt2 > 0){
	    		while(rowSet2.next()){
	    			String edit_flag="";
	    			
	    			if (JSPUtil.getNull(rowSet2.getString("bsa_zr_flg")).equals("Y")){
	    				edit_flag="FALSE";
	    			}else{
	    				edit_flag="TRUE";
	    			}
	    			
					strBuilder.append("<TR EDIT=" + '"'+edit_flag +'"'+">");
					//ColumnCount 만큼 추출
					for(int idx=1; idx <= colCount; idx++) {
						
						strBuilder.append("   <TD>"+ JSPUtil.getNull(rowSet2.getString(idx))+ "</TD>");
						
					} // end of for
						
					strBuilder.append("</TR>");
					
					//log.debug("strBuilder = " + strBuilder);
	    		}
		    }
		    
		   
		    strBuilder.append("</DATA>");
		    strBuilder.append("<ETC-DATA>");
		    strBuilder.append("  <ETC KEY=\"crr_cnt\">"+crr_cnt+"</ETC>");
		    strBuilder.append("  <ETC KEY=\"crr_cd\">"+crrCD+"</ETC>");
		    strBuilder.append("  <ETC KEY=\"saveNM\">"+saveNM+"</ETC>");		    
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
		
		log.debug("########### EsmBsa0030ViewAdapter.makeDataTag(List<AbstractValueObject> list, String prefix) ########### [END]");
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
	protected String makeDataTag(DBRowSet rs,String prefix) {
		StringBuilder sb = new StringBuilder();
		//Pivot Table인 경우 makePivotDataTag 실행하여  return한
		if(rs.isPivot()){
			sb.append(makePivotDataTag(rs));
			return sb.toString();
		}

		String[] realColNms = getColHeader(rs);

		try{
			//String[] changedColNms = getChangedColNms(realColNms, prefix);
			
			sb.append("<DATA  TOTAL='" + getRowSetCnt(rs) + "'>\n");
			
			int colCount = realColNms.length;
		
 			while (rs.next()) { 
				sb.append("	<TR>");
				sb.append("	<TD></TD>");
				for (int j = 1 ; j <= colCount ; j++) {
					sb.append("<TD>"+getNull(rs.getObject(j)) + "</TD>");
				}	
				//sb.append(getNull(rs.getObject(colCount))  + "</TR>\n");
				sb.append("</TR>\n");
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
