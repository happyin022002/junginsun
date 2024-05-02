/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsdSce0072ViewAdapter.java
*@FileTitle : EsdSce0072ViewAdapter
*Open Issues :
*Change history :
*@LastModifyDate : 2009-08-31
*@LastModifier : Jun Byoung Suk
*@LastVersion : 1.0
* 2009-08-31 Jun Byoung Suk
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.event;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.DefaultViewAdapter;
import com.hanjin.framework.core.controller.ViewAdapter;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;


/**
 * 기본 IBSheet XML 생성<br>
 * - IBSheet로 반환할 서버처리결과를 XML로 변환하는 클래스이다.<br>
 *
 * @author 전병석
 * @see DefaultViewAdapter 클래스 참조
 * @since J2EE 1.5
 */
public class EsdSce0072ViewAdapter extends com.hanjin.framework.core.controller.DefaultViewAdapter{
	Event event = null;
	String parm = null;
	String style1 = "COMBO";
	String style2 = "ETC_INPUT";
	/**
	 * @param request HttpServletRequest 
	 * @param response HttpServletResponse 
	 * @return String
	 * @throws 
	 */
	public String makeXML(HttpServletRequest request, HttpServletResponse response){
		parm = request.getParameter("style");        
		event		= (Event)request.getAttribute("Event");
		FormCommand		formcommand	= event.getFormCommand();
		log.debug("making xml....");	
		log.debug("##EsdSce0072- COMMAND:" + formcommand.getCommand());
		log.debug("##EsdSce0072- COMMAND STYLE:" + parm);
		return super.makeXML(request, response);
	}
	/**
	 * @param arg0 List<AbstractValueObject> 
	 * @param arg1 String 
	 * @return String
	 * @throws 
	 */	
	@Override
	protected String makeDataTag(List<AbstractValueObject> arg0, String arg1) {
		// TODO Auto-generated method stub
        log.debug("##EsdSce0072  Adapter starting....");
        //FormCommand		formcommand	= event.getFormCommand();
        
		if((event.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) || (event.getFormCommand().isCommand(FormCommand.SEARCHLIST02))){
			log.debug("##EsdSce0072- Adapter01 - SEARCHLIST01,SEARCHLIST02");
			return super.makeDataTag(arg0, arg1);
		
	    } else if(event.getFormCommand().isCommand(FormCommand.SEARCH03) || event.getFormCommand().isCommand(FormCommand.SEARCH04)){ 
	    	log.debug("##EsdSce0072- Adapter01 - SEARCH03,SEARCH04");
	    	return super.makeDataTag(arg0, arg1);
	    
	    }else if(event.getFormCommand().isCommand(FormCommand.SEARCH02)){ 
	    	log.debug("##EsdSce0072- Adapter01 - SEARCH02");
	    	log.debug("Wait for a while");
	    	return super.makeDataTag(arg0, arg1);
	    } else{//SEARCH01
	    	if(parm != null &&( parm.equals(style1) || parm.equals(style2))){
	    		log.debug("##EsdSce0072- Adapter01 - SEARCH01 For SelectionBox");
	    		return super.makeDataTag(arg0, arg1);
	    	}else{
	    		log.debug("##EsdSce0072- Adapter01 - SEARCH01 For Summation");
		    	//return makingXmlForSearch01(arg0, arg1);
	    		return super.makeDataTag(arg0, arg1);
	    	}

	    }//if
	}
//	/**
//	 * @param DBRowSet rowSet
//	 * @param String prefix
//	 * @return String
//	 * @throws 
//	 */		
//	private String makingXmlForSearch01(DBRowSet rowSet,String prefix){
//        int cnt = 0;		
//		StringBuilder sbufXML = new StringBuilder();
//		String temp = "";
//		int i =1;
//  if (rowSet != null) {
//	 try {
//
//		  while(rowSet.next()){//rowSet의 전체숫자를 구하는 반복문
//			  cnt++;
//		  }//while1
//		  
//		    rowSet.beforeFirst();//중요 처음으로 돌린다.
//			sbufXML.append("<DATA TOTAL='"+ cnt +"'>"); 
//			while (rowSet.next()){
//					sbufXML.append("<TR>" + "\n");
//					for (int j = 0 ; j < rowSet.getMetaData().getColumnCount()+1 ; j++) {
//			    		if(j != rowSet.getMetaData().getColumnCount()){
//			    			temp = JSPUtil.getNull(rowSet.getObject(i++)+ "");
//			    			sbufXML.append("<TD><![CDATA[" + temp + "]]></TD>");
//			    		} else {
//			    			sbufXML.append("<td MERGE='TRUE'></td>");
//			    		}//if
//			    		}//for2
//					 
//					 i = 1;//초기화
//					 sbufXML.append("</TR>" + "\n" + "<TR>");
//						
//					 double sum_temp = 0;
//					 double sum_temp1 = 0;
//					 double sum_temp2 = 0;
//					 double sum_temp_all = 0;
//					 int avg_cnt = 0;
//				
//						for (int j = 0 ; j < rowSet.getMetaData().getColumnCount() ; j++) {
//			        		temp = JSPUtil.getNull(rowSet.getObject(i++)+"");
//			        		double avg_temp = 0;
//			        		String [] arr_temp = temp.split("/");
//			        		String avg_temp_str = "";
//
//			        		if(arr_temp.length == 2){ 
//			        			String temp1 = arr_temp[0];
//			        			String temp2 = arr_temp[1];	
//								avg_temp = JSPUtil.round((Double.parseDouble(temp2) - Double.parseDouble(temp1))* 100/Double.parseDouble(temp2),-2);
////							N200902050103 : performance 계산을  과거  %의 평균에서 (누락 Count / 전체 Count) 로 Logic변경.
//								sum_temp1 = sum_temp1+JSPUtil.round((Double.parseDouble(temp1)),-5);
//								sum_temp2 = sum_temp2+JSPUtil.round((Double.parseDouble(temp2)),-5);
//								
//								avg_temp_str = avg_temp+"%";
//			            		sum_temp = sum_temp+avg_temp;
//			        		} else if(temp.equals("Missing")){
//			        			avg_temp_str = "PFMC(%)";
//			        			avg_cnt++;
//			        		} else {
//			        			avg_temp_str = "";
//			        			avg_cnt++;
//			        		}
//			        		
//			        		sbufXML.append("<TD><![CDATA[" + avg_temp_str + "]]></TD>");
//					 }//for3	
//					 
//					 sbufXML.append("<td MERGE='TRUE'>");
//						if((rowSet.getMetaData().getColumnCount() - avg_cnt ) != 0){
////						N200902050103 : performance 계산을  과거  %의 평균에서 (누락 Count / 전체 Count) 로 Logic변경.
//							sum_temp_all = JSPUtil.round((((sum_temp2-sum_temp1) / sum_temp2)* 100 ),-2);
//
//						}
//				  
//					 sbufXML.append("<![CDATA["+  sum_temp_all+ "%]]>");
//					 sbufXML.append("</td>");
//					 sbufXML.append("</TR>");
//					
//				}//while
//		} catch (NumberFormatException e) {
//			log.error(e.getMessage(),e);
//			throw new RuntimeException(e.getMessage());
//		} catch (SQLException e) {
//			log.error(e.getMessage(),e);
//			throw new RuntimeException(e.getMessage());
//		} catch (Exception e) {
//			log.error(e.getMessage(),e);
//			throw new RuntimeException(e.getMessage());
//		}//try
//   }//if1
//                sbufXML.append("</DATA>" + "\n");
//   return sbufXML.toString();
//   }
//	/**
//	 * @param prefix String  
//	 * @param rowSet DBRowSet
//	 * @return String
//	 * @throws 
//	 */			
//	private String makingXmlForSearch02(DBRowSet rowSet,String prefix){
//        int cnt = 0;
//		StringBuilder sbufXML = new StringBuilder();
//		String temp = "";
//		int i =1;
//  if (rowSet != null) {
//	 try {
//
//		  while(rowSet.next()){//rowSet의 전체숫자를 구하는 반복문
//			  cnt++;
//		  }//while1
//		  
//		    rowSet.beforeFirst();//중요 처음으로 돌린다.
//			sbufXML.append("<DATA TOTAL='"+ cnt +"'>");
//			
//			while (rowSet.next()){
//				sbufXML.append("<TR>" + "\n");
//			
//				for (int j = 0 ; j < rowSet.getMetaData().getColumnCount() ; j++) {
//					temp = JSPUtil.getNull(rowSet.getObject(i++)+"");
//					
//					if(temp.equals("1")){
//						temp = "~1 day";
//					} else if(temp.equals("2")){
//						temp = "1~2 days";
//					} else if(temp.equals("3")){
//						temp = "2~3 days";
//					} else if(temp.equals("etc")){
//						temp = "3 days ~";
//					}//if	
//					
//			    sbufXML.append("<TD><![CDATA[" + temp + "]]></TD>");
//			}//for
//			i = 1;
//			sbufXML.append("</TR>" + "\n");
//			sbufXML.append("<TR>");
//			
//			
//			double sum_temp = 0;
//
//			//N200902050103 : sum_temp1, sum_temp2, sum_temp_all 추가 
//				double sum_temp1 = 0;
//				double sum_temp2 = 0;
//				double sum_temp_all = 0;
//				int avg_cnt = 0;
//				for (int j = 0 ; j < rowSet.getMetaData().getColumnCount() ; j++) {
//					temp = JSPUtil.getNull(rowSet.getObject(i++)+"");
//					double avg_temp = 0;
//					String [] arr_temp = temp.split("/");
//					String avg_temp_str = "";
//
//					if(arr_temp.length == 2){ 
//						String temp1 = arr_temp[0];
//						String temp2 = arr_temp[1];	
//			    		avg_temp = JSPUtil.round(Double.parseDouble(temp1)* 100/Double.parseDouble(temp2),-2);
//			    		avg_temp_str = avg_temp+"%";
//			    		sum_temp = sum_temp+avg_temp;
////						N200902050103 : performance 계산을  과거  %의 평균에서 (누락 Count / 전체 Count) 로 Logic변경.		
//						sum_temp1 = sum_temp1+JSPUtil.round((Double.parseDouble(temp1)),-5);
//						sum_temp2 = sum_temp2+JSPUtil.round((Double.parseDouble(temp2)),-5);
//					} else if((temp.equals("1")) || (temp.equals("2")) || (temp.equals("3")) || (temp.equals("etc")) ){
//						avg_temp_str = "%";
//						avg_cnt++;
//					} else {
//						avg_temp_str = "";
//						avg_cnt++;
//					}
//					
//					sbufXML.append("<TD><![CDATA["+ avg_temp_str +"]]></TD>");
//				}//for
//				
//				sbufXML.append("<td>");
//				if((rowSet.getMetaData().getColumnCount() - avg_cnt ) != 0){
////					N200902050103 : performance 계산을  과거  %의 평균에서 (누락 Count / 전체 Count) 로 Logic변경.		
//					sum_temp_all = JSPUtil.round((((sum_temp2-sum_temp1) / sum_temp2)* 100 ),-2);
//				}
//				i = 1;
//				
//				sbufXML.append("<![CDATA[" + sum_temp_all + "%" + "]]>");
//				sbufXML.append("</td>");
//			    sbufXML.append("</TR>" + "\n");
//			
//			}//while
//		} catch (NumberFormatException e) {
//			log.error(e.getMessage(),e);
//			throw new RuntimeException(e.getMessage());
//		} catch (SQLException e) {
//			log.error(e.getMessage(),e);
//			throw new RuntimeException(e.getMessage());
//		} catch (Exception e) {
//			log.error(e.getMessage(),e);
//			throw new RuntimeException(e.getMessage());
//		}//try
// 
//	}//if
//  sbufXML.append("</DATA>" + "\n");
//  return sbufXML.toString();
//	}
	/**
	 * @param DBRowSet arg0
	 * @param String arg1
	 * @return String
	 * @throws 
	 */		
	@Override
	protected String makeDataTag(DBRowSet arg0, String arg1) {
		log.debug("##EsdSce0072  Adapter DBRowSet starting....");
        //FormCommand		formcommand	= event.getFormCommand();
        
		if((event.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) || (event.getFormCommand().isCommand(FormCommand.SEARCHLIST02))){
			log.debug("##EsdSce0072- Adapter02 - SEARCHLIST01,SEARCHLIST02");
			return super.makeDataTag(arg0, arg1);
		
	    } else if(event.getFormCommand().isCommand(FormCommand.SEARCH03) || event.getFormCommand().isCommand(FormCommand.SEARCH04)){ 
	    	log.debug("##EsdSce0072- Adapter02 - SEARCH03,SEARCH04");
	    	return super.makeDataTag(arg0, arg1);
	    
	    }else if(event.getFormCommand().isCommand(FormCommand.SEARCH02)){ 
	    	log.debug("##EsdSce0072- Adapter02 - SEARCH02");
	    	//return makingXmlForSearch02(arg0, arg1);
	    	return super.makeDataTag(arg0, arg1);
	    } else{//SEARCH01
	    	if(parm != null &&( parm.equals(style1) || parm.equals(style2))){
	    		log.debug("##EsdSce0072- Adapter02 - SEARCH01 For SelectionBox");
	    		return super.makeDataTag(arg0, arg1);
	    	}else{
	    		log.debug("##EsdSce0072- Adapter02 - SEARCH01 For Summation");
		    	//return makingXmlForSearch01(arg0, arg1);
	    		return super.makeDataTag(arg0, arg1);
	    	}

	    }//if
	}

}
