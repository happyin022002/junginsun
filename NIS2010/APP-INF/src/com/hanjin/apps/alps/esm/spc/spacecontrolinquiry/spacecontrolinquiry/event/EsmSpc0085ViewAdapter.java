/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmSpc0085ViewAdapter.java
*@FileTitle : Quota Upload
*Open Issues :
*Change history :
*@LastModifyDate : 2012.09.21
*@LastModifier : KSJ
*@LastVersion : 1.0
* 2012.09.21 KSJ
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.event;

import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.ComplexMainVO;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.controller.ViewAdapter;
import com.hanjin.syscommon.common.table.SpcTeamQtaRtoVO;


/**
 * 기본 IBSheet XML 생성<br>
 * - IBSheet로 반환할 서버처리결과를 XML로 변환하는 클래스이다.<br>
 * 
 * @author 한상훈
 * @see ViewAdapter 참조
 * @since J2EE 1.5
 */
public class EsmSpc0085ViewAdapter extends ViewAdapter{
	
	
	/**
	 * VO List를 Parsing하여 <Data>태그 부분의 XML문자열을 반환한다.<br>
	 * 
	 * @param vos List<AbstractValueObject> List 객체
	 * @param colOrder String[] Column명 문자열 
	 * @param prefix String IBSheet savename's prefix
	 * @return String <Data>태그 부분의 XML문자열
	 * @exception 
	 */	
	protected String makeDataTag(List<AbstractValueObject> vos, String prefix) 
	{
		StringBuilder sbufXML = new StringBuilder();
		ComplexMainVO complexMainVO = (ComplexMainVO)vos.get(0);
		
		List<SpcTeamQtaRtoVO> voList = complexMainVO.getSpcTeamQtaRtoVOs();
		
		int totCnt  = voList.size();
		int realCnt = voList.size();
		int subTtl  = 0;
		int ttl     = 0;
		
		
		if( complexMainVO.getEventCommand().equals("SEARCHLIST01")){	//2.1
			sbufXML.append("<DATA TOTAL='" + totCnt + "'>\n");
				
  		   for(int i=0;i<realCnt;i++){

				Map<String, String> colValues = voList.get(i).getColumnValues();
						
				sbufXML.append("<TR>\n");
	            sbufXML.append("<TD></TD>");
	            sbufXML.append("<TD></TD>");
	 			
	            sbufXML.append("<TD>" + colValues.get("trd_cd")   + "</TD>");
	            sbufXML.append("<TD>" + colValues.get("sub_trd_cd")   + "</TD>");
	            sbufXML.append("<TD>" + colValues.get("rlane_cd") + "</TD>");
	            sbufXML.append("<TD>" + colValues.get("bse_yr")      + "</TD>");
	            sbufXML.append("<TD>" + colValues.get("bse_qtr_cd")      + "</TD>");
	            
	            int temp = 0;
	            subTtl = 0;
	            ttl = 0;
	            while(temp<4){
	            	
	            	sbufXML.append("<TD>" + voList.get(i).getColumnValues().get("team_qta_rto")      + "</TD>");
	            	
	            	if(voList.get(i).getColumnValues().get("team_qta_rto").isEmpty()){
	            		break;
	            	}
	            	
	            	subTtl += Integer.parseInt(voList.get(i).getColumnValues().get("team_qta_rto"));
	            	ttl += Integer.parseInt(voList.get(i).getColumnValues().get("team_qta_rto"));
	            	if(temp == 2){
	    	            sbufXML.append("<TD>" + subTtl + "</TD>");
	            	}else if(temp == 3){
	    	            sbufXML.append("<TD>" + ttl + "</TD>");
	            	}
	            	
	            	temp++;
	            	if(temp != 4) i++;
	            }
	        
				sbufXML.append("</TR>\n");
					
			}//For End	

			sbufXML.append("</DATA>\n");
	
 	    }else if( complexMainVO.getEventCommand().equals("SEARCHLIST02")){	//2.1
			sbufXML.append("<DATA TOTAL='" + totCnt + "'>\n");
			
	  		   for(int i=0;i<realCnt;i++){

					Map<String, String> colValues = voList.get(i).getColumnValues();
							
					sbufXML.append("<TR>\n");
		            sbufXML.append("<TD></TD>");
		            sbufXML.append("<TD></TD>");
		 			
		            sbufXML.append("<TD>" + colValues.get("trd_cd")   + "</TD>");
		            sbufXML.append("<TD>" + colValues.get("sub_trd_cd")   + "</TD>");
		            sbufXML.append("<TD>" + colValues.get("rlane_cd") + "</TD>");
		            sbufXML.append("<TD>" + (colValues.get("vsl_cd")).concat(colValues.get("skd_voy_no")).concat(colValues.get("skd_dir_cd"))      + "</TD>");
		            
		            int temp = 0;
		            subTtl = 0;
		            ttl = 0;
		            while(temp<4){
		            	
		            	if(voList.get(i).getColumnValues().get("team_qta_rto").isEmpty()){
		            		break;
		            	}
		            	
		            	sbufXML.append("<TD>" + voList.get(i).getColumnValues().get("team_qta_rto")      + "</TD>");
		            	
			           	subTtl += Integer.parseInt(voList.get(i).getColumnValues().get("team_qta_rto"));
		            	ttl += Integer.parseInt(voList.get(i).getColumnValues().get("team_qta_rto"));
		            	if(temp == 2){
		    	            sbufXML.append("<TD>" + subTtl + "</TD>");
		            	}else if(temp == 3){
		    	            sbufXML.append("<TD>" + ttl + "</TD>");
		            	}
		            	
		            	temp++;
		            	if(temp != 4) i++;
		            }
		        
					sbufXML.append("</TR>\n");
						
				}//For End	

				sbufXML.append("</DATA>\n");
		
	 	    }//if End

		
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
	@Override
	protected String makeDataTag(DBRowSet arg0, String arg1) {
		// TODO Auto-generated method stub
		return null;
	}
	
}