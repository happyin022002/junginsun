/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0940ViewAdapter.java
*@FileTitle : 0940 I/B DOC Performance Report 정보를 조회합니다.
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.25
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2009.05.25 김경섭
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event;

import java.util.List;
import java.util.Map;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.ViewAdapter;

/**
 * 기본 IBSheet XML 생성<br>
 * - IBSheet로 반환할 서버처리결과를 XML로 변환하는 클래스이다.<br>
 * 
 * @author Kim Gyoung Sub
 * @see ViewAdapter 참조
 * @since J2EE 1.6
 */
public class EsmBkg0940ViewAdapter extends ViewAdapter{

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
		//String[] realColNms=getColHeader(vo);
		//String[] changedColNms = getChangedColNms(realColNms, prefix);
		
		if(vo.getMaxRows()>0){
			totCnt = vo.getMaxRows();
		}
		String groupingCd     = ""; //새로운 행을 만들기 위한 기준코드
		String tempGroupingCd = "";//새로운 행을 만들기 위한 기준코드 템프
		
		sbufXML.append("\n<DATA TOTAL='").append(totCnt).append("'>\n");
		Map<String, String> colValues = null;
		
		StringBuilder sbufXMLTotal = new StringBuilder();
		for(int i=0;i<realCnt;i++){
			colValues = vos.get(i).getColumnValues();
			tempGroupingCd =colValues.get("weeks");
			log.debug("~~~~~~~~~~~~"+vos.get(i).getColumnValues().get("dura_cd"));
			
			//이전 SR NO와 현재 데이타의 값이 틀리면 제목을 새로 생성한다.
			if(i > 0 && !groupingCd.equals(tempGroupingCd)){
				/* Duration option 이 Weekly Base 일때만 보여준다 */
				if(vos.get(0).getColumnValues().get("dura_cd").equals("W")){
					sbufXML.append("	<TR BGCOLOR='247,225,236' MERGE='TRUE'>\n");
					sbufXML.append("		<TD><![CDATA[").append(vos.get(i-1).getColumnValues().get("yyyy")).append(" YEAR ").append(vos.get(i-1).getColumnValues().get("weeks")) .append(" WEEK]]></TD>\n");
					sbufXML.append("		<TD><![CDATA[").append(vos.get(i-1).getColumnValues().get("yyyy")).append(" YEAR ").append(vos.get(i-1).getColumnValues().get("weeks")) .append(" WEEK]]></TD>\n");
					sbufXML.append("		<TD><![CDATA[").append(vos.get(i-1).getColumnValues().get("yyyy")).append(" YEAR ").append(vos.get(i-1).getColumnValues().get("weeks")) .append(" WEEK]]></TD>\n");
					sbufXML.append("		<TD><![CDATA[").append(vos.get(i-1).getColumnValues().get("yyyy")).append(" YEAR ").append(vos.get(i-1).getColumnValues().get("weeks")) .append(" WEEK]]></TD>\n");
					sbufXML.append("		<TD><![CDATA[").append(vos.get(i-1).getColumnValues().get("yyyy")).append(" YEAR ").append(vos.get(i-1).getColumnValues().get("weeks")) .append(" WEEK]]></TD>\n");
					sbufXML.append("		<TD><![CDATA[").append(vos.get(i-1).getColumnValues().get("yyyy")).append(" YEAR ").append(vos.get(i-1).getColumnValues().get("weeks")) .append(" WEEK]]></TD>\n");
					sbufXML.append("		<TD><![CDATA[").append(vos.get(i-1).getColumnValues().get("yyyy")).append(" YEAR ").append(vos.get(i-1).getColumnValues().get("weeks")) .append(" WEEK]]></TD>\n");
					sbufXML.append("		<TD><![CDATA[").append(vos.get(i-1).getColumnValues().get("yyyy")).append(" YEAR ").append(vos.get(i-1).getColumnValues().get("weeks")) .append(" WEEK]]></TD>\n");
					sbufXML.append("		<TD><![CDATA[").append(vos.get(i-1).getColumnValues().get("yyyy")).append(" YEAR ").append(vos.get(i-1).getColumnValues().get("weeks")) .append(" WEEK]]></TD>\n");
					sbufXML.append("		<TD><![CDATA[").append(vos.get(i-1).getColumnValues().get("yyyy")).append(" YEAR ").append(vos.get(i-1).getColumnValues().get("weeks")) .append(" WEEK]]></TD>\n");
					
			        sbufXML.append("		<TD><![CDATA[ ")                   .append(vos.get(i-1).getColumnValues().get("sum_ib_bl")).append(" ]]></TD>\n");
	           		
					sbufXML.append("		<TD><![CDATA[  ")                  .append(vos.get(i-1).getColumnValues().get("sum_d2"))   .append("  ]]></TD>\n");                 
					sbufXML.append("		<TD><![CDATA[   ")                 .append(vos.get(i-1).getColumnValues().get("sum_d4"))   .append("   ]]></TD>\n");                
					sbufXML.append("		<TD><![CDATA[    ")                .append(vos.get(i-1).getColumnValues().get("sum_d5"))   .append("    ]]></TD>\n");               
					sbufXML.append("		<TD><![CDATA[     ")               .append(vos.get(i-1).getColumnValues().get("sum_d7"))   .append("     ]]></TD>\n");              
																																	                                                       																							
					sbufXML.append("		<TD><![CDATA[      ")              .append(vos.get(i-1).getColumnValues().get("sum_r2"))   .append("      ]]></TD>\n");             
					sbufXML.append("		<TD><![CDATA[       ")             .append(vos.get(i-1).getColumnValues().get("sum_r45"))  .append("       ]]></TD>\n");            
					sbufXML.append("		<TD><![CDATA[        ")            .append(vos.get(i-1).getColumnValues().get("sum_o2"))   .append("        ]]></TD>\n");           
					sbufXML.append("		<TD><![CDATA[         ")           .append(vos.get(i-1).getColumnValues().get("sum_o4"))   .append("         ]]></TD>\n");           
					sbufXML.append("		<TD><![CDATA[          ")          .append(vos.get(i-1).getColumnValues().get("sum_o5"))   .append("          ]]></TD>\n");           					
																																	                                                       																							
					sbufXML.append("		<TD><![CDATA[           ")         .append(vos.get(i-1).getColumnValues().get("sum_f2"))   .append("           ]]></TD>\n");          
					sbufXML.append("		<TD><![CDATA[            ")        .append(vos.get(i-1).getColumnValues().get("sum_f4"))   .append("            ]]></TD>\n");         
					sbufXML.append("		<TD><![CDATA[             ")       .append(vos.get(i-1).getColumnValues().get("sum_t2"))   .append("             ]]></TD>\n");        
					sbufXML.append("		<TD><![CDATA[              ")      .append(vos.get(i-1).getColumnValues().get("sum_t4"))   .append("              ]]></TD>\n");       
																																	                                                       																							
					sbufXML.append("		<TD><![CDATA[               ")     .append(vos.get(i-1).getColumnValues().get("sum_ttl40")).append("               ]]></TD>\n");      
					sbufXML.append("		<TD><![CDATA[                ")    .append(vos.get(i-1).getColumnValues().get("sum_ttl20")).append("                ]]></TD>\n");     
																																	                                                       																							
					sbufXML.append("		<TD><![CDATA[                 ")   .append(vos.get(i-1).getColumnValues().get("sum_ts_bl")).append("                 ]]></TD>\n");    
																			 														                                                       																							
					sbufXML.append("		<TD><![CDATA[                  ")  .append(vos.get(i-1).getColumnValues().get("sum_ts40")) .append("                  ]]></TD>\n");   
					sbufXML.append("		<TD><![CDATA[                   ") .append(vos.get(i-1).getColumnValues().get("sum_ts20")) .append("                   ]]></TD>\n");  
																																	                                                       		
				//	sbufXML.append("		<TD><![CDATA[                   ") .append(vos.get(i-1).getColumnValues().get("sum_jik40")).append("                   ]]></TD>\n"); 
				//	sbufXML.append("		<TD><![CDATA[                    ").append(vos.get(i-1).getColumnValues().get("sum_jik20")).append("                    ]]></TD>\n");				
					
					sbufXML.append("	</TR>\n");
					sbufXML.append("	\n");
				}
			}
			
			if(i > 0 && !(vos.get(i-1).getColumnValues().get("vvd_cd1")+vos.get(i-1).getColumnValues().get("vvd_cd2")).equals(colValues.get("vvd_cd1")+colValues.get("vvd_cd2"))){
				sbufXML.append("	<TR HIDDEN='true'></TR>\n");
			}
				
			sbufXML.append("	<TR BGCOLOR='255,255,255' MERGE='false'>\n");
			sbufXML.append("		<TD><![CDATA[").append(colValues.get("lane_cd")) .append("]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[").append(colValues.get("pod_cd")) .append("]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[").append(colValues.get("pod_yard_cd")) .append("]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[").append(colValues.get("del_cd")) .append("]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[").append(colValues.get("staff_id")) .append("]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[").append(colValues.get("staff_nm")) .append("]]></TD>\n");
			
			sbufXML.append("		<TD><![CDATA[").append(colValues.get("vvd_cd1")) .append("]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[").append(colValues.get("vvd_cd2")) .append("]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[").append(colValues.get("ata_cd1")) .append("]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[").append(colValues.get("ata_cd2")) .append("]]></TD>\n");			
			sbufXML.append("		<TD><![CDATA[").append(colValues.get("ib_bl")) .append("]]></TD>\n");
			
			sbufXML.append("		<TD><![CDATA[").append(colValues.get("d2")) .append("]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[").append(colValues.get("d4")) .append("]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[").append(colValues.get("d5")) .append("]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[").append(colValues.get("d7")) .append("]]></TD>\n");
			
			sbufXML.append("		<TD><![CDATA[").append(colValues.get("r2")) .append("]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[").append(colValues.get("r45")) .append("]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[").append(colValues.get("o2")) .append("]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[").append(colValues.get("o4")) .append("]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[").append(colValues.get("o5")) .append("]]></TD>\n");
			
			sbufXML.append("		<TD><![CDATA[").append(colValues.get("f2")) .append("]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[").append(colValues.get("f4")) .append("]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[").append(colValues.get("t2")) .append("]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[").append(colValues.get("t4")) .append("]]></TD>\n");
			
			sbufXML.append("		<TD><![CDATA[").append(colValues.get("ttl40")) .append("]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[").append(colValues.get("ttl20")) .append("]]></TD>\n");
			
			sbufXML.append("		<TD><![CDATA[").append(colValues.get("ts_bl")) .append("]]></TD>\n");
			
			sbufXML.append("		<TD><![CDATA[").append(colValues.get("ts40")) .append("]]></TD>\n");
			sbufXML.append("		<TD><![CDATA[").append(colValues.get("ts20")) .append("]]></TD>\n");
			
			//sbufXML.append("		<TD><![CDATA[").append(colValues.get("jik40")) .append("]]></TD>\n");
			//sbufXML.append("		<TD><![CDATA[").append(colValues.get("jik20")) .append("]]></TD>\n");
			sbufXML.append("	</TR>\n");
			sbufXML.append("	\n");
			
			if(i == realCnt -1){
				/* Duration option 이 Weekly Base 일때만 보여준다 */
				if(vos.get(0).getColumnValues().get("dura_cd").equals("W")){
					sbufXML.append("	<TR BGCOLOR='247,225,236' MERGE='true'>\n");
					sbufXML.append("		<TD><![CDATA[").append(colValues.get("yyyy")).append(" YEAR ").append(colValues.get("weeks")) .append(" WEEK]]></TD>\n");
					sbufXML.append("		<TD><![CDATA[").append(colValues.get("yyyy")).append(" YEAR ").append(colValues.get("weeks")) .append(" WEEK]]></TD>\n");
					sbufXML.append("		<TD><![CDATA[").append(colValues.get("yyyy")).append(" YEAR ").append(colValues.get("weeks")) .append(" WEEK]]></TD>\n");
					sbufXML.append("		<TD><![CDATA[").append(colValues.get("yyyy")).append(" YEAR ").append(colValues.get("weeks")) .append(" WEEK]]></TD>\n");
					sbufXML.append("		<TD><![CDATA[").append(colValues.get("yyyy")).append(" YEAR ").append(colValues.get("weeks")) .append(" WEEK]]></TD>\n");
					sbufXML.append("		<TD><![CDATA[").append(colValues.get("yyyy")).append(" YEAR ").append(colValues.get("weeks")) .append(" WEEK]]></TD>\n");
					sbufXML.append("		<TD><![CDATA[").append(colValues.get("yyyy")).append(" YEAR ").append(colValues.get("weeks")) .append(" WEEK]]></TD>\n");
					sbufXML.append("		<TD><![CDATA[").append(colValues.get("yyyy")).append(" YEAR ").append(colValues.get("weeks")) .append(" WEEK]]></TD>\n");
					sbufXML.append("		<TD><![CDATA[").append(colValues.get("yyyy")).append(" YEAR ").append(colValues.get("weeks")) .append(" WEEK]]></TD>\n");
					sbufXML.append("		<TD><![CDATA[").append(colValues.get("yyyy")).append(" YEAR ").append(colValues.get("weeks")) .append(" WEEK]]></TD>\n");
					
			        sbufXML.append("		<TD><![CDATA[ ")                   .append(colValues.get("sum_ib_bl")).append(" ]]></TD>\n");
					
					sbufXML.append("		<TD><![CDATA[  ")                  .append(colValues.get("sum_d2"))   .append("  ]]></TD>\n");                 
					sbufXML.append("		<TD><![CDATA[   ")                 .append(colValues.get("sum_d4"))   .append("   ]]></TD>\n");                
					sbufXML.append("		<TD><![CDATA[    ")                .append(colValues.get("sum_d5"))   .append("    ]]></TD>\n");               
					sbufXML.append("		<TD><![CDATA[     ")               .append(colValues.get("sum_d7"))   .append("     ]]></TD>\n");              
																																																																									
					sbufXML.append("		<TD><![CDATA[      ")              .append(colValues.get("sum_r2"))   .append("      ]]></TD>\n");             
					sbufXML.append("		<TD><![CDATA[       ")             .append(colValues.get("sum_r45"))  .append("       ]]></TD>\n");            
					sbufXML.append("		<TD><![CDATA[        ")            .append(colValues.get("sum_o2"))   .append("        ]]></TD>\n");           
					sbufXML.append("		<TD><![CDATA[         ")           .append(colValues.get("sum_o4"))   .append("         ]]></TD>\n");
					sbufXML.append("		<TD><![CDATA[          ")          .append(colValues.get("sum_o5"))   .append("          ]]></TD>\n");
																																																																									
					sbufXML.append("		<TD><![CDATA[           ")         .append(colValues.get("sum_f2"))   .append("           ]]></TD>\n");          
					sbufXML.append("		<TD><![CDATA[            ")        .append(colValues.get("sum_f4"))   .append("            ]]></TD>\n");         
					sbufXML.append("		<TD><![CDATA[             ")       .append(colValues.get("sum_t2"))   .append("             ]]></TD>\n");        
					sbufXML.append("		<TD><![CDATA[              ")      .append(colValues.get("sum_t4"))   .append("              ]]></TD>\n");       
																																																																									
					sbufXML.append("		<TD><![CDATA[               ")     .append(colValues.get("sum_ttl40")).append("               ]]></TD>\n");      
					sbufXML.append("		<TD><![CDATA[                ")    .append(colValues.get("sum_ttl20")).append("                ]]></TD>\n");     
																																																																									
					sbufXML.append("		<TD><![CDATA[                 ")   .append(colValues.get("sum_ts_bl")).append("                 ]]></TD>\n");    
																																																																									
					sbufXML.append("		<TD><![CDATA[                  ")  .append(colValues.get("sum_ts40")) .append("                  ]]></TD>\n");   
					sbufXML.append("		<TD><![CDATA[                   ") .append(colValues.get("sum_ts20")) .append("                   ]]></TD>\n");  
																																																				
					//sbufXML.append("		<TD><![CDATA[                   ") .append(colValues.get("sum_jik40")).append("                   ]]></TD>\n"); 
					//sbufXML.append("		<TD><![CDATA[                    ").append(colValues.get("sum_jik20")).append("                    ]]></TD>\n");		
					
					sbufXML.append("	</TR>\n");
					sbufXML.append("	\n");
				}
				
				sbufXML.append("	<TR HIDDEN='true'></TR>\n");
				
				sbufXMLTotal.append("	<TR BGCOLOR='247,225,236' MERGE='true'>\n");
				sbufXMLTotal.append("		<TD><![CDATA[ TOTAL ]]></TD>\n");
				sbufXMLTotal.append("		<TD><![CDATA[ TOTAL ]]></TD>\n");
				sbufXMLTotal.append("		<TD><![CDATA[ TOTAL ]]></TD>\n");
				sbufXMLTotal.append("		<TD><![CDATA[ TOTAL ]]></TD>\n");
				sbufXMLTotal.append("		<TD><![CDATA[ TOTAL ]]></TD>\n");
				sbufXMLTotal.append("		<TD><![CDATA[ TOTAL ]]></TD>\n");
				sbufXMLTotal.append("		<TD><![CDATA[ TOTAL ]]></TD>\n");
				sbufXMLTotal.append("		<TD><![CDATA[ TOTAL ]]></TD>\n");
				sbufXMLTotal.append("		<TD><![CDATA[ TOTAL ]]></TD>\n");
				sbufXMLTotal.append("		<TD><![CDATA[ TOTAL ]]></TD>\n");
				
				sbufXMLTotal.append("		<TD><![CDATA[ ")                   .append(colValues.get("total_sum_ib_bl")).append(" ]]></TD>\n");
				
				sbufXMLTotal.append("		<TD><![CDATA[  ")                  .append(colValues.get("total_sum_d2"))   .append("  ]]></TD>\n");                 
				sbufXMLTotal.append("		<TD><![CDATA[   ")                 .append(colValues.get("total_sum_d4"))   .append("   ]]></TD>\n");                
				sbufXMLTotal.append("		<TD><![CDATA[    ")                .append(colValues.get("total_sum_d5"))   .append("    ]]></TD>\n");               
				sbufXMLTotal.append("		<TD><![CDATA[     ")               .append(colValues.get("total_sum_d7"))   .append("     ]]></TD>\n");              
																																																																											
				sbufXMLTotal.append("		<TD><![CDATA[      ")              .append(colValues.get("total_sum_r2"))   .append("      ]]></TD>\n");             
				sbufXMLTotal.append("		<TD><![CDATA[       ")             .append(colValues.get("total_sum_r45"))  .append("       ]]></TD>\n");            
				sbufXMLTotal.append("		<TD><![CDATA[        ")            .append(colValues.get("total_sum_o2"))   .append("        ]]></TD>\n");           
				sbufXMLTotal.append("		<TD><![CDATA[         ")           .append(colValues.get("total_sum_o4"))   .append("         ]]></TD>\n");  
				sbufXMLTotal.append("		<TD><![CDATA[          ")          .append(colValues.get("total_sum_o5"))   .append("          ]]></TD>\n");  
																																																																											
				sbufXMLTotal.append("		<TD><![CDATA[           ")         .append(colValues.get("total_sum_f2"))   .append("           ]]></TD>\n");          
				sbufXMLTotal.append("		<TD><![CDATA[            ")        .append(colValues.get("total_sum_f4"))   .append("            ]]></TD>\n");         
				sbufXMLTotal.append("		<TD><![CDATA[             ")       .append(colValues.get("total_sum_t2"))   .append("             ]]></TD>\n");        
				sbufXMLTotal.append("		<TD><![CDATA[              ")      .append(colValues.get("total_sum_t4"))   .append("              ]]></TD>\n");       
																																																																											
				sbufXMLTotal.append("		<TD><![CDATA[               ")     .append(colValues.get("total_sum_ttl40")).append("               ]]></TD>\n");      
				sbufXMLTotal.append("		<TD><![CDATA[                ")    .append(colValues.get("total_sum_ttl20")).append("                ]]></TD>\n");     
																																																																											
				sbufXMLTotal.append("		<TD><![CDATA[                 ")   .append(colValues.get("total_sum_ts_bl")).append("                 ]]></TD>\n");    
																		 																																																									
				sbufXMLTotal.append("		<TD><![CDATA[                  ")  .append(colValues.get("total_sum_ts40")) .append("                  ]]></TD>\n");   
				sbufXMLTotal.append("		<TD><![CDATA[                   ") .append(colValues.get("total_sum_ts20")) .append("                   ]]></TD>\n");  
																																
				//sbufXMLTotal.append("		<TD><![CDATA[                   ") .append(colValues.get("total_sum_jik40")).append("                   ]]></TD>\n"); 
				//sbufXMLTotal.append("		<TD><![CDATA[                    ").append(colValues.get("total_sum_jik20")).append("                    ]]></TD>\n");		
				sbufXMLTotal.append("	</TR>\n");
				sbufXMLTotal.append("	\n");
			}

			
			groupingCd = tempGroupingCd;
		}
		
		sbufXML.append(sbufXMLTotal.toString());
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
		}catch(Exception ex){
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
