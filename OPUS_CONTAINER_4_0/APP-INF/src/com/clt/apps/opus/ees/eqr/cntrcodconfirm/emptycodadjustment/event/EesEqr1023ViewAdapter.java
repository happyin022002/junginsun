/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCim1023ViewAdapter.java
*@FileTitle : Location M/B by Logistics-Wise
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.eqr.cntrcodconfirm.emptycodadjustment.event;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.ViewAdapter;

/**
 * IBSheet XML <br>
 * @author 
 * @see ViewAdapter      
 * @since J2EE 1.5   
 */
public class EesEqr1023ViewAdapter extends ViewAdapter {

		/**
		 * VO List Parsing .<br>
		 * 
		 * @param vos List<AbstractValueObject> List 
		 * @param colOrder String[] Column
		 * @param prefix String IBSheet savename's prefix
		 * @return String <Data>
		 * @exception 
		 */	
	    protected String makeDataTag(List<AbstractValueObject> vos, String prefix) {
	        StringBuilder sbufXML = new StringBuilder();
	        
	        int totCnt = vos.size();
	        int realCnt = vos.size();
	
	        AbstractValueObject vo = (AbstractValueObject)vos.get(0);

	        if(vo.getMaxRows()>0){
	            totCnt = vo.getMaxRows();
	        }
	        
	        sbufXML.append("<DATA TOTAL='" + totCnt +"'>\n");
	
	        for(int i=0;i<realCnt;i++){
	
	
                Map<String, String> colValues = vos.get(i).getColumnValues();
                
                if("A".equals(JSPUtil.getNull(colValues.get("gubun"))) || JSPUtil.getNull(colValues.get("gubun")).equals(JSPUtil.getNull(colValues.get("div")).substring(0, 1))){
	                if("Total".equals(JSPUtil.getNull(colValues.get("vvd")))){
	                	sbufXML.append("<TR BGCOLOR ='201, 213, 235'>\n");
	                }
	                else{
	                	sbufXML.append("<TR>\n");
	                }
//	                int colCnt = realColNms.length;
	                
	                sbufXML.append("<TD><![CDATA["+JSPUtil.getNull(colValues.get("port"))+"]]></TD>\n");
	                sbufXML.append("<TD ><![CDATA["+ JSPUtil.getNull(colValues.get("vvd"))+"]]></TD>\n");
	                sbufXML.append("<TD ><![CDATA["+ JSPUtil.getNull(colValues.get("etb"))+"]]></TD>\n");
	                sbufXML.append("<TD ><![CDATA["+ JSPUtil.getNull(colValues.get("div"))+"]]></TD>\n");
	                sbufXML.append("<TD ><![CDATA["+ JSPUtil.getNull(colValues.get("total"))+"]]></TD>\n");
	
	                sbufXML.append("<TD ><![CDATA["+ JSPUtil.getNull(colValues.get("d2"))+"]]></TD>\n");
	                sbufXML.append("<TD ><![CDATA["+ JSPUtil.getNull(colValues.get("d4"))+"]]></TD>\n");
	                sbufXML.append("<TD ><![CDATA["+ JSPUtil.getNull(colValues.get("d5"))+"]]></TD>\n");
	                sbufXML.append("<TD ><![CDATA["+ JSPUtil.getNull(colValues.get("d7"))+"]]></TD>\n");
	                sbufXML.append("<TD ><![CDATA["+ JSPUtil.getNull(colValues.get("r2"))+"]]></TD>\n");
	                sbufXML.append("<TD ><![CDATA["+ JSPUtil.getNull(colValues.get("r5"))+"]]></TD>\n");
	                sbufXML.append("<TD ><![CDATA["+ JSPUtil.getNull(colValues.get("r9"))+"]]></TD>\n");
	                sbufXML.append("<TD ><![CDATA["+ JSPUtil.getNull(colValues.get("o2"))+"]]></TD>\n");
	                sbufXML.append("<TD ><![CDATA["+ JSPUtil.getNull(colValues.get("s2"))+"]]></TD>\n");
	                sbufXML.append("<TD ><![CDATA["+ JSPUtil.getNull(colValues.get("o4"))+"]]></TD>\n");
	                sbufXML.append("<TD ><![CDATA["+ JSPUtil.getNull(colValues.get("s4"))+"]]></TD>\n");
	                sbufXML.append("<TD ><![CDATA["+ JSPUtil.getNull(colValues.get("o5"))+"]]></TD>\n");
	                sbufXML.append("<TD ><![CDATA["+ JSPUtil.getNull(colValues.get("f2"))+"]]></TD>\n");
	                sbufXML.append("<TD ><![CDATA["+ JSPUtil.getNull(colValues.get("a2"))+"]]></TD>\n");
	                sbufXML.append("<TD ><![CDATA["+ JSPUtil.getNull(colValues.get("f4"))+"]]></TD>\n");
	                sbufXML.append("<TD ><![CDATA["+ JSPUtil.getNull(colValues.get("a4"))+"]]></TD>\n");
	                sbufXML.append("<TD ><![CDATA["+ JSPUtil.getNull(colValues.get("f5"))+"]]></TD>\n");
	
	                sbufXML.append( "</TR>\n");
                }
	            
	        } // end for(int i=0;i<realCnt;i++){
	        sbufXML.append("</DATA>\n");
	        return sbufXML.toString();
	    }


		/**
		 * DBRowSet Parsing.<br>
		 * 
		 * @param rs DBRowSet 		VO
		 * @param prefix String 		IBSheet savename's prefix string
		 * @return String IBSheet 		<DATA>태그
		 * @exception 
		 */
		protected String makeDataTag(DBRowSet rs,String prefix) {
			StringBuilder sb = new StringBuilder();
			
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
					sb.append("	<TR>");
					for (int j = 1 ; j < colCount ; j++) {
						sb.append(getNull(rs.getObject(j)) + DELIMITER);
						int xTempVal = Integer.parseInt(getNull(rs.getObject(j))+"");
						if( xTempVal >= 0 ){
							sb.append("<TD><FONT COLOR='BLUE'><B>"+getNull(rs.getObject(j))+"%</B></FONT></TD>");
						}else if( xTempVal < 0 ){
							sb.append("<TD><FONT COLOR='RED'><B>"+getNull(rs.getObject(j))+"%</B></FONT></TD>");
						}else{
							sb.append("<TD>"+getNull(rs.getObject(j))+"</TD>");
						}
					}	
				}
				sb.append("</DATA>\n");
			}catch(SQLException ex){  
				throw new RuntimeException(ex.getMessage());
			}catch(Exception e){  
				throw new RuntimeException(e.getMessage());  
			}
			return sb.toString();
		}

		/**
		 * Pivot Table Data tag<br>
		 * 
		 * @param rs			DBRowSet 		VO
		 * @return String 	IBSheet 			<DATA>
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
				throw new RuntimeException(ex.getMessage());
			}catch(Exception e){  
				throw new RuntimeException(e.getMessage());  
			}
			return sb.toString();
		}

	}


