/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCim1029ViewAdapter.java
*@FileTitle : Cargo Flow Map
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.23
*@LastModifier : 문중철
*@LastVersion : 1.0
* 2009.06.23 문중철
* 1.0 Creation
* * ======================================================
* 2010.08.27 남궁진호 Ticket ID :Ticket ID : CHM-201005533-01
*            조회 조건 추가 (Loc_Loc)로 인한 Sheet 추가 
=========================================================*/
package com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.event;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.ViewAdapter;

/**
 * IBSheet XML 생성<br>
 * - IBSheet로 반환할 서버처리결과를 XML로 변환하는 클래스이다.<br>
 * 
 * @author Mun Jung Cheol
 * @see ViewAdapter 참조       
 * @since J2EE 1.5    
 */
public class EesCim1029ViewAdapter extends ViewAdapter { 

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
            
            if(vo.getMaxRows()>0){
                totCnt = vo.getMaxRows();
            }
            
            sbufXML.append("<DATA TOTAL='" + (totCnt-1) +"'>\n");
            
            int cnt = 0;
            for(int i=0;i<realCnt;i++){
            	Map<String, String> colValues = vos.get(i).getColumnValues();
                
            	String yard = JSPUtil.getNull(colValues.get("yard_cd"  ));
            	
            	if (yard.equals("Loc")){
//            		 sbufXML.append("<DATA TOTAL='" + (totCntt) +"'>\n");
            		sbufXML.append("<TR >");
            		sbufXML.append("<TD><![CDATA[R]]></TD>");
            		sbufXML.append("<TD><![CDATA["+JSPUtil.getNull(colValues.get("loc_cd"  ))+"]]></TD>");
                    sbufXML.append("<TD><![CDATA["+JSPUtil.getNull(colValues.get("vvd"     ))+"]]></TD>");
                   	sbufXML.append("<TD><![CDATA["+JSPUtil.getNull(colValues.get("division"))+"]]></TD>");
                    sbufXML.append("<TD><![CDATA["+JSPUtil.getNull(colValues.get("total"   ))+"]]></TD>");
                    
                    for (int j = 0 ; j < 40 ; j++) {                        
                          sbufXML.append("<TD><![CDATA["+JSPUtil.getNull(colValues.get("qty_"+j))+"]]></TD>");
                    }
					sbufXML.append("</TR>\n");

            	}else if (yard.equals("LocTrend")){
	            		sbufXML.append("<TR >");
	            		sbufXML.append("<TD><![CDATA[R]]></TD>");
	            		sbufXML.append("<TD><![CDATA["+JSPUtil.getNull(colValues.get("loc_cd"  ))+"]]></TD>");
	                    sbufXML.append("<TD><![CDATA["+JSPUtil.getNull(colValues.get("vvd"     ))+"]]></TD>");
                    	sbufXML.append("<TD><![CDATA["+JSPUtil.getNull(colValues.get("tp_sz"))+"]]></TD>");                    	
	                    sbufXML.append("<TD><![CDATA["+JSPUtil.getNull(colValues.get("total"   ))+"]]></TD>");
                    	sbufXML.append("<TD><![CDATA["+JSPUtil.getNull(colValues.get("division"))+"]]></TD>");	                    
	                    for (int j = 0 ; j < 40 ; j++) {                        
	                          sbufXML.append("<TD><![CDATA["+JSPUtil.getNull(colValues.get("qty_"+j))+"]]></TD>");
	                    }	                    
						sbufXML.append("</TR>\n");										
            	}else{
	                // XTC TP/SZ ViewFlag
	/*  */          Map<String, String> colViewYNValues = vos.get(0).getColumnValues();
	/*  */          if( i > 0 ){                
	                	
		                if("Total".equals(JSPUtil.getNull(colValues.get("division")))){
		                	sbufXML.append("<TR BGCOLOR ='201, 213, 235'>\n");
		                	
		                	if(cnt > 0){
		                		colValues.put("division","");
		                	}
		                	cnt++;
		                }
		                else{
		                	sbufXML.append("<TR>\n");
		                	cnt = 0;
		                }
	
	//	                int colCnt = realColNms.length;
	                    
	                    sbufXML.append("<TD><![CDATA["+JSPUtil.getNull(colValues.get("loc_cd"  ))+"]]></TD>");
	                    sbufXML.append("<TD><![CDATA["+JSPUtil.getNull(colValues.get("vvd"     ))+"]]></TD>");
	                    sbufXML.append("<TD><![CDATA["+JSPUtil.getNull(colValues.get("division"))+"]]></TD>");
	                    sbufXML.append("<TD><![CDATA["+JSPUtil.getNull(colValues.get("ibflag"  ))+"]]></TD>");
	                    sbufXML.append("<TD><![CDATA["+JSPUtil.getNull(colValues.get("total"   ))+"]]></TD>");
	                    
	                    for (int j = 0 ; j < 40 ; j++) {
	                        
	/*  */                  String xTempYNoVal = JSPUtil.getNull(colViewYNValues.get("qty_"+j));
	/*  */                  if( xTempYNoVal.equals("1")){                       
	                            sbufXML.append("<TD><![CDATA["+JSPUtil.getNull(colValues.get("qty_"+j))+"]]></TD>");
	/*  */                  }else{ // if( xTempYNoVal.equals("1")){
	/*  */                      sbufXML.append("<TD><![CDATA[]]></TD>");
	/*  */                  } // if( xTempYNoVal.equals("1")){
	
	                    }
						sbufXML.append("</TR>\n");
	                    
	/*  */          } // if( i > 0 ){
            	}
            }
            sbufXML.append("</DATA>\n");
//            log.debug("##################### AbstractValueObject sbufXML.toString() [\n" + sbufXML.toString() + "\n]");
            return sbufXML.toString();
        }

        /**
         * Double형을 받아서 소수점 밑을 자르고 String으로 리턴한다 
         * @param xTempVal
         * @return String
         * @exception 
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
         * @exception 
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
//                      log.debug("##################### DBRowSet getNull(rs.getObject("+j+")) [" + getNull(rs.getObject(j)) + "]");
                        sb.append(getNull(rs.getObject(j)) + DELIMITER);
                        int xTempVal = Integer.parseInt(getNull(rs.getObject(j))+"");
                        if( xTempVal >= 0 ){
                            sb.append("<TD><FONT COLOR='BLUE'><B>"+getNull(rs.getObject(j))+"%</B></FONT></TD>");
                        }else if( xTempVal < 0 ){
                            sb.append("<TD><FONT COLOR='RED'><B>"+getNull(rs.getObject(j))+"%</B></FONT></TD>");
                        }else{
                            sb.append("<TD>"+getNull(rs.getObject(j))+"</TD>");
                        }
                        //log.debug("##################### DBRowSet getNull(rs.getObject(j)) [" + getNull(rs.getObject(j)) + "]");
                    }   
                }
                sb.append("</DATA>\n");
            }catch(SQLException ex){  
                throw new RuntimeException(ex.getMessage());
            }catch(Exception e){  
                throw new RuntimeException(e.getMessage());  
            }
            //log.debug("##################### DBRowSet sb.toString() [\n" + sb.toString() + "\n]");
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


