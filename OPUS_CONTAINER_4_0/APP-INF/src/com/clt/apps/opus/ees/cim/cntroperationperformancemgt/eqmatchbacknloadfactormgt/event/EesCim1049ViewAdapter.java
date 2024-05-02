/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCim1050ViewAdapter.java
*@FileTitle : MatchBack By Vessel
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.24
*@LastModifier : 문중철
*@LastVersion : 1.0
* 2009.08.24 문중철
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.event;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.ViewAdapter;

/**
 * IBSheet XML 생성<br>
 * - IBSheet로 반환할 서버처리결과를 XML로 변환하는 클래스이다.<br>
 * 
 * @author Mun Jung Cheol
 * @see ViewAdapter 참조      
 * @since J2EE 1.5   
 */
public class EesCim1049ViewAdapter extends ViewAdapter {

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
//            String[] realColNms=getColHeader(vo);
            //String[] changedColNms = getChangedColNms(realColNms, prefix);
            
            if(vo.getMaxRows()>0){
                totCnt = vo.getMaxRows();
            }
            
            sbufXML.append("<DATA TOTAL='" + totCnt +"'>\n");

            for(int i=0;i<realCnt;i++){

                    Map<String, String> colValues = vos.get(i).getColumnValues();
                    
	                if("Total".equals(JSPUtil.getNull(colValues.get("company")))){
	                	sbufXML.append("<TR BGCOLOR ='201, 213, 235'>\n");
	                }
	                else{
	                	sbufXML.append("<TR>\n");
	                }
//                    int colCnt = realColNms.length;

                    sbufXML.append("<TD><![CDATA["+JSPUtil.getNull(colValues.get("colsorts"       ))+"]]></TD>\n");
                    sbufXML.append("<TD><![CDATA["+JSPUtil.getNull(colValues.get("company"       ))+"]]></TD>\n");
                    sbufXML.append("<TD><![CDATA["+JSPUtil.getNull(colValues.get("fromregion"    ))+"]]></TD>\n");
                    sbufXML.append("<TD><![CDATA["+JSPUtil.getNull(colValues.get("trade"     ))+"]]></TD>\n");
                    sbufXML.append("<TD><![CDATA["+JSPUtil.getNull(colValues.get("lane"      ))+"]]></TD>\n");
                    sbufXML.append("<TD><![CDATA["+JSPUtil.getNull(colValues.get("vvd"       ))+"]]></TD>\n");
                    sbufXML.append("<TD><![CDATA["+JSPUtil.getNull(colValues.get("port"  ))+"]]></TD>\n");
                    sbufXML.append("<TD><![CDATA["+JSPUtil.getNull(colValues.get("atd"       ))+"]]></TD>\n");
                    sbufXML.append("<TD><![CDATA["+JSPUtil.getNull(colValues.get("atd_week"      ))+"]]></TD>\n");
                    sbufXML.append("<TD><![CDATA["+JSPUtil.getNull(colValues.get("full20qty"   ))+"]]></TD>\n");
                    sbufXML.append("<TD><![CDATA["+JSPUtil.getNull(colValues.get("full40qty"   ))+"]]></TD>\n");
                    sbufXML.append("<TD><![CDATA["+JSPUtil.getNull(colValues.get("fullhcqty"   ))+"]]></TD>\n");
                    sbufXML.append("<TD><![CDATA["+JSPUtil.getNull(colValues.get("full45qty"   ))+"]]></TD>\n");
                    sbufXML.append("<TD><![CDATA["+JSPUtil.getNull(colValues.get("fulltotal"))+"]]></TD>\n");
                    sbufXML.append("<TD><![CDATA["+JSPUtil.getNull(colValues.get("mty20qty"    ))+"]]></TD>\n");
                    sbufXML.append("<TD><![CDATA["+JSPUtil.getNull(colValues.get("mty40qty"    ))+"]]></TD>\n");
                    sbufXML.append("<TD><![CDATA["+JSPUtil.getNull(colValues.get("mtyhcqty"    ))+"]]></TD>\n");
                    sbufXML.append("<TD><![CDATA["+JSPUtil.getNull(colValues.get("mty45qty"    ))+"]]></TD>\n");
                    sbufXML.append("<TD><![CDATA["+JSPUtil.getNull(colValues.get("mtytotal" ))+"]]></TD>\n");
                    sbufXML.append("<TD><![CDATA["+JSPUtil.getNull(colValues.get("boxtotal" ))+"]]></TD>\n");
                    sbufXML.append("<TD><![CDATA["+JSPUtil.getNull(colValues.get("teutotal" ))+"]]></TD>\n");
                    
                    sbufXML.append("<TD><![CDATA["+JSPUtil.getNull(colValues.get("deadslot" ))+"]]></TD>\n");
                    sbufXML.append("<TD><![CDATA["+JSPUtil.getNull(colValues.get("weighttotal" ))+"]]></TD>\n");
                    sbufXML.append("<TD><![CDATA["+JSPUtil.getNull(colValues.get("releasedteu" ))+"]]></TD>\n");
                    sbufXML.append("<TD><![CDATA["+JSPUtil.getNull(colValues.get("releasedweight" ))+"]]></TD>\n");
                    sbufXML.append("<TD><![CDATA["+JSPUtil.getNull(colValues.get("bsaspace" ))+"]]></TD>\n");
                    sbufXML.append("<TD><![CDATA["+JSPUtil.getNull(colValues.get("bsaweight" ))+"]]></TD>\n");
                    sbufXML.append("<TD><![CDATA["+JSPUtil.getNull(colValues.get("unusedspace" ))+"]]></TD>\n");
                    sbufXML.append("<TD><![CDATA["+JSPUtil.getNull(colValues.get("unusedweight" ))+"]]></TD>\n");
                   
                    sbufXML.append("<TD><![CDATA["+JSPUtil.getNull(colValues.get("lffull" ))+"%]]></TD>\n");
                    sbufXML.append("<TD><![CDATA["+JSPUtil.getNull(colValues.get("lfeq" ))+"%]]></TD>\n");
                    sbufXML.append("<TD><![CDATA["+JSPUtil.getNull(colValues.get("lfwgt" ))+"%]]></TD>\n");
                    
                    sbufXML.append("<TD><![CDATA["+JSPUtil.getNull(colValues.get("datasource"))+"]]></TD>\n");   
                    sbufXML.append("</TR>\n");
                
            } // end for(int i=0;i<realCnt;i++){
            sbufXML.append("</DATA>\n");
            //log.debug("##################### AbstractValueObject sbufXML.toString() [\n" + sbufXML.toString() + "\n]");
            return sbufXML.toString();
        }

         
        /**
         * DBRowSet를 Parsing하여 <DATA>태그를 생성한다.<br>
         * IBSheet의 prefix값이 있는 경우 COLORDER에 prefix를 붙인 column명으로 표시해 준다.<br>
         * 
         * @param rs DBRowSet       VO객체
         * @param prefix String         IBSheet savename's prefix string
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
                    sb.append(" <TR>");
                    for (int j = 1 ; j < colCount ; j++) {
                        log.debug("##################### DBRowSet getNull(rs.getObject("+j+")) [" + getNull(rs.getObject(j)) + "]");
//                      sb.append(getNull(rs.getObject(j)) + DELIMITER);
//                      int xTempVal = Integer.parseInt(getNull(rs.getObject(j))+"");
//                      if( xTempVal >= 0 ){
//                          sb.append("<TD><FONT COLOR='BLUE'><B>"+getNull(rs.getObject(j))+"%</B></FONT></TD>");
//                      }else if( xTempVal < 0 ){
//                          sb.append("<TD><FONT COLOR='RED'><B>"+getNull(rs.getObject(j))+"%</B></FONT></TD>");
//                      }else{
//                          sb.append("<TD>"+getNull(rs.getObject(j))+"</TD>");
//                      }
                        //log.debug("##################### DBRowSet getNull(rs.getObject(j)) [" + getNull(rs.getObject(j)) + "]");
                    }   
                }
                sb.append("</DATA>\n");
            }catch(SQLException ex){  
                throw new RuntimeException(ex.getMessage());
            }catch(Exception e){  
                throw new RuntimeException(e.getMessage());  
            }
            log.debug("##################### DBRowSet sb.toString() [\n" + sb.toString() + "\n]");
            return sb.toString();
        }

        /**
         * Pivot Table용 Data tag를 생성한다.<br>
         * 
         * @param rs            DBRowSet        VO객체
         * @return String   IBSheet             <DATA>태그
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
                        sb.append(" <TR><![CDATA[");
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


