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
public class EesCim1050ViewAdapter extends ViewAdapter {

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
                    
	                if("Total".equals(JSPUtil.getNull(colValues.get("com"))) || "".equals(JSPUtil.getNull(colValues.get("com")))){
	                	sbufXML.append("<TR BGCOLOR ='201, 213, 235'>");
	                }
	                else{
	                	
	                	sbufXML.append("<TR>");
	                }
//                    int colCnt = realColNms.length;

                    sbufXML.append("<TD><![CDATA["+JSPUtil.getNull(colValues.get("seq"       ))+"]]></TD>");
                    sbufXML.append("<TD><![CDATA["+JSPUtil.getNull(colValues.get("com"       ))+"]]></TD>");
                    sbufXML.append("<TD><![CDATA["+JSPUtil.getNull(colValues.get("trade"     ))+"]]></TD>");
                    sbufXML.append("<TD><![CDATA["+JSPUtil.getNull(colValues.get("lane"      ))+"]]></TD>");
                    sbufXML.append("<TD><![CDATA["+JSPUtil.getNull(colValues.get("io"        ))+"]]></TD>");
                    sbufXML.append("<TD><![CDATA["+JSPUtil.getNull(colValues.get("region"    ))+"]]></TD>");
                    sbufXML.append("<TD><![CDATA["+JSPUtil.getNull(colValues.get("vvd"       ))+"]]></TD>");
                    sbufXML.append("<TD><![CDATA["+JSPUtil.getNull(colValues.get("lastport"  ))+"]]></TD>");
                    sbufXML.append("<TD><![CDATA["+JSPUtil.getNull(colValues.get("atd"       ))+"]]></TD>");
                    sbufXML.append("<TD><![CDATA["+JSPUtil.getNull(colValues.get("week"      ))+"]]></TD>");
                    sbufXML.append("<TD><![CDATA["+JSPUtil.getNull(colValues.get("full_20"   ))+"]]></TD>");
                    sbufXML.append("<TD><![CDATA["+JSPUtil.getNull(colValues.get("full_40"   ))+"]]></TD>");
                    sbufXML.append("<TD><![CDATA["+JSPUtil.getNull(colValues.get("full_hc"   ))+"]]></TD>");
                    sbufXML.append("<TD><![CDATA["+JSPUtil.getNull(colValues.get("full_45"   ))+"]]></TD>");
                    sbufXML.append("<TD><![CDATA["+JSPUtil.getNull(colValues.get("full_total"))+"]]></TD>");
                    sbufXML.append("<TD><![CDATA["+JSPUtil.getNull(colValues.get("mty_20"    ))+"]]></TD>");
                    sbufXML.append("<TD><![CDATA["+JSPUtil.getNull(colValues.get("mty_40"    ))+"]]></TD>");
                    sbufXML.append("<TD><![CDATA["+JSPUtil.getNull(colValues.get("mty_hc"    ))+"]]></TD>");
                    sbufXML.append("<TD><![CDATA["+JSPUtil.getNull(colValues.get("mty_45"    ))+"]]></TD>");
                    sbufXML.append("<TD><![CDATA["+JSPUtil.getNull(colValues.get("mty_total" ))+"]]></TD>");
                    sbufXML.append("<TD><![CDATA["+JSPUtil.getNull(colValues.get("box_total" ))+"]]></TD>");
                    sbufXML.append("<TD><![CDATA["+JSPUtil.getNull(colValues.get("teu_total" ))+"]]></TD>");
                    
                    String xTempVal01 = JSPUtil.getNull(colValues.get("teu_full"));
                    String xTempVal02 = JSPUtil.getNull(colValues.get("teu_eq"  ));
                    String xTempVal03 = JSPUtil.getNull(colValues.get("eq_20"   ));
                    String xTempVal04 = JSPUtil.getNull(colValues.get("eq_40"   ));
                    String xTempVal05 = JSPUtil.getNull(colValues.get("eq_hc"   ));
                    String xTempVal06 = JSPUtil.getNull(colValues.get("eq_45"   ));
                    String xTempVal07 = JSPUtil.getNull(colValues.get("eq_total"));
                    
                    String xTempVal08 = JSPUtil.getNull(colValues.get("lffull"));
                    String xTempVal09 = JSPUtil.getNull(colValues.get("lfeq"));
                    String xTempVal10 = JSPUtil.getNull(colValues.get("lfwgt"));
           
                    if( !xTempVal01.equals("") && xTempVal01!=null && xTempVal01.length()>0 && !xTempVal01.equals("null") ){
                        double xTempVal = Double.parseDouble(xTempVal01);
                        if( xTempVal >= 0 ){
                            sbufXML.append("<TD><![CDATA[" + checkStringRemoveZero( xTempVal ) + "%]]></TD>");
                        }else if( xTempVal < 0 ){
                            sbufXML.append("<TD COLOR='220,0,0'><![CDATA[" + checkStringRemoveZero( xTempVal ) + "%]]></TD>");
                        }
                    }else{
                        sbufXML.append("<TD><![CDATA[0%]]></TD>");
                    }
                    
                    if( !xTempVal02.equals("") && xTempVal02!=null && xTempVal02.length()>0 && !xTempVal02.equals("null") ){
                        double xTempVal = Double.parseDouble(xTempVal02);
                        if( xTempVal >= 0 ){
                            sbufXML.append("<TD><![CDATA[" + checkStringRemoveZero( xTempVal ) + "%]]></TD>");
                        }else if( xTempVal < 0 ){
                            sbufXML.append("<TD COLOR='220,0,0'><![CDATA[" + checkStringRemoveZero( xTempVal ) + "%]]></TD>");
                        }
                    }else{
                        sbufXML.append("<TD><![CDATA[0%]]></TD>");
                    }
                    
                    if( !xTempVal03.equals("") && xTempVal03!=null && xTempVal03.length()>0 && !xTempVal03.equals("null") ){
                        double xTempVal = Double.parseDouble(xTempVal03);
                        if( xTempVal >= 0 ){
                            sbufXML.append("<TD><![CDATA[" + checkStringRemoveZero( xTempVal ) + "%]]></TD>");
                        }else if( xTempVal < 0 ){
                            sbufXML.append("<TD COLOR='220,0,0'><![CDATA[" + checkStringRemoveZero( xTempVal ) + "%]]></TD>");
                        }
                    }else{
                        sbufXML.append("<TD><![CDATA[0%]]></TD>");
                    }
                    
                    if( !xTempVal04.equals("") && xTempVal04!=null && xTempVal04.length()>0 && !xTempVal04.equals("null") ){
                        double xTempVal = Double.parseDouble(xTempVal04);
                        if( xTempVal >= 0 ){
                            sbufXML.append("<TD><![CDATA[" + checkStringRemoveZero( xTempVal ) + "%]]></TD>");
                        }else if( xTempVal < 0 ){
                            sbufXML.append("<TD COLOR='220,0,0'><![CDATA[" + checkStringRemoveZero( xTempVal ) + "%]]></TD>");
                        }
                    }else{
                        sbufXML.append("<TD><![CDATA[0%]]></TD>");
                    }
                    
                    if( !xTempVal05.equals("") && xTempVal05!=null && xTempVal05.length()>0 && !xTempVal05.equals("null") ){
                        double xTempVal = Double.parseDouble(xTempVal05);
                        if( xTempVal >= 0 ){
                            sbufXML.append("<TD><![CDATA[" + checkStringRemoveZero( xTempVal ) + "%]]></TD>");
                        }else if( xTempVal < 0 ){
                            sbufXML.append("<TD COLOR='220,0,0'><![CDATA[" + checkStringRemoveZero( xTempVal ) + "%]]></TD>");
                        }
                    }else{
                        sbufXML.append("<TD><![CDATA[0%]]></TD>");
                    }
                    
                    if( !xTempVal06.equals("") && xTempVal06!=null && xTempVal06.length()>0 && !xTempVal06.equals("null") ){
                        double xTempVal = Double.parseDouble(xTempVal06);
                        if( xTempVal >= 0 ){
                            sbufXML.append("<TD><![CDATA[" + checkStringRemoveZero( xTempVal ) + "%]]></TD>");
                        }else if( xTempVal < 0 ){
                            sbufXML.append("<TD COLOR='220,0,0'><![CDATA[" + checkStringRemoveZero( xTempVal ) + "%]]></TD>");
                        }
                    }else{
                        sbufXML.append("<TD><![CDATA[0%]]></TD>");
                    }
                    
                    if( !xTempVal07.equals("") && xTempVal07!=null && xTempVal07.length()>0 && !xTempVal07.equals("null") ){
                        double xTempVal = Double.parseDouble(xTempVal07);
                        if( xTempVal >= 0 ){
                            sbufXML.append("<TD><![CDATA[" + checkStringRemoveZero( xTempVal ) + "%]]></TD>");
                        }else if( xTempVal < 0 ){
                            sbufXML.append("<TD COLOR='220,0,0'><![CDATA[" + checkStringRemoveZero( xTempVal ) + "%]]></TD>");
                        }
                    }else{
                        sbufXML.append("<TD><![CDATA[0%]]></TD>");
                    }

                    
                    sbufXML.append("<TD><![CDATA["+JSPUtil.getNull(colValues.get("deadslot" ))+"]]></TD>");
                    sbufXML.append("<TD><![CDATA["+JSPUtil.getNull(colValues.get("weighttotal" ))+"]]></TD>");
                    sbufXML.append("<TD><![CDATA["+JSPUtil.getNull(colValues.get("releasedteu" ))+"]]></TD>");
                    sbufXML.append("<TD><![CDATA["+JSPUtil.getNull(colValues.get("releasedweight" ))+"]]></TD>");
                    sbufXML.append("<TD><![CDATA["+JSPUtil.getNull(colValues.get("bsaspace" ))+"]]></TD>");
                    sbufXML.append("<TD><![CDATA["+JSPUtil.getNull(colValues.get("bsaweight" ))+"]]></TD>");
                    sbufXML.append("<TD><![CDATA[0]]></TD>");
                    sbufXML.append("<TD><![CDATA[0]]></TD>");

                    
                    if( !xTempVal08.equals("") && xTempVal08!=null && xTempVal08.length()>0 && !xTempVal08.equals("null") ){
                        double xTempVal = Double.parseDouble(xTempVal08);
                        if( xTempVal >= 0 ){
                            sbufXML.append("<TD><![CDATA[" + checkStringRemoveZero( xTempVal ) + "%]]></TD>");
                        }else if( xTempVal < 0 ){
                            sbufXML.append("<TD COLOR='220,0,0'><![CDATA[" + checkStringRemoveZero( xTempVal ) + "%]]></TD>");
                        }
                    }else{
                        sbufXML.append("<TD><![CDATA[0%]]></TD>");
                    }
                    
            		
                    if( !xTempVal09.equals("") && xTempVal09!=null && xTempVal09.length()>0 && !xTempVal09.equals("null") ){
                        double xTempVal = Double.parseDouble(xTempVal09);
                        if( xTempVal >= 0 ){
                            sbufXML.append("<TD><![CDATA[" + checkStringRemoveZero( xTempVal ) + "%]]></TD>");
                        }else if( xTempVal < 0 ){
                            sbufXML.append("<TD COLOR='220,0,0'><![CDATA[" + checkStringRemoveZero( xTempVal ) + "%]]></TD>");
                        }
                    }else{
                        sbufXML.append("<TD><![CDATA[0%]]></TD>");
                    }      
                    
                    if( !xTempVal10.equals("") && xTempVal10!=null && xTempVal10.length()>0 && !xTempVal10.equals("null") ){
                        double xTempVal = Double.parseDouble(xTempVal10);
                        if( xTempVal >= 0 ){
                            sbufXML.append("<TD><![CDATA[" + checkStringRemoveZero( xTempVal ) + "%]]></TD>");
                        }else if( xTempVal < 0 ){
                            sbufXML.append("<TD COLOR='220,0,0'><![CDATA[" + checkStringRemoveZero( xTempVal ) + "%]]></TD>");
                        }
                    }else{
                        sbufXML.append("<TD><![CDATA[0%]]></TD>");
                    }                     

                    
                    
                    sbufXML.append("<TD><![CDATA["+JSPUtil.getNull(colValues.get("datasource"))+"]]></TD>");                    
					sbufXML.append("</TR>\n");
                
            } // end for(int i=0;i<realCnt;i++){
            sbufXML.append("</DATA>\n");
            //log.debug("##################### AbstractValueObject sbufXML.toString() [\n" + sbufXML.toString() + "\n]");
            return sbufXML.toString();
        }

    /**
    * [ "0.0" 을 받아서 "0"]을 [return] 합니다.<br>
    * 
    * @param xTempVal
    * @return String 
    */
    public String checkStringRemoveZero( Double xTempVal ){
        String xVal01 = xTempVal+"";
//        log.debug("@@@@@@@ xVal01 [" + xVal01 + "]");        
        String xVal02 = "";
        if ( xVal01 == null || xVal01.equals("") ) { xVal01 = "0"; }
        if ( xVal01.equals("-0.0") ) { xVal01 = "0"; }
        if ( xVal01.indexOf(".") != -1 ) {
            xVal02 = xVal01.substring( xVal01.indexOf(".")+1 , xVal01.length() );
//            log.debug("@@@@@@@ xVal01.substring( " + xVal01.indexOf(".") + " , " + xVal01.length() + " ) [" + xVal01.substring( xVal01.indexOf(".") , xVal01.length() ) + "]");
            if ( xVal02.equals("0") ) {
                xVal01 = xVal01.substring( 0 , xVal01.indexOf(".") );
            }
        }
//        log.debug("@@@@@@@ ");
        return xVal01;
    }        
        
        /**
         * Double형을 받아서 소수점 밑을 자르고 String으로 리턴한다 
         * @param xTempVal
         * @return String
         */
        public String checkDoubleInteger( Double xTempVal ){
            String xVal01 = xTempVal+"";
//          log.debug("##################### AbstractValueObject 1 xVal01 [ "+ xVal01 + "]");
            if(xVal01 == null ||xVal01.equals("")){ xVal01 = "0"; }
            if(xVal01.indexOf(".")!=-1){
                xVal01 = xVal01.substring(0, xVal01.indexOf("."));
            }
//          log.debug("##################### AbstractValueObject 2 xVal01 [ "+ xVal01 + "]");
            return xVal01;
        }

        /**
         * String형을 받아서 소수점 밑을 자르고 String으로 리턴한다 
         * @param xTempVal
         * @return String
         */
        public String checkStringInteger( String xTempVal ){
            String xVal01 = xTempVal;
//          log.debug("##################### AbstractValueObject 3 xVal01 [ "+ xVal01 + "]");
            if(xVal01 == null ||xVal01.equals("")){ xVal01 = "0"; }
            if(xVal01.indexOf(".")!=-1){
                xVal01 = xVal01.substring(0, xVal01.indexOf("."));
            }
//          log.debug("##################### AbstractValueObject 4 xVal01 [ "+ xVal01 + "]");
            return xVal01;
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


