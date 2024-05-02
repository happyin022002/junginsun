
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0010ViewAdapter.java
*@FileTitle : EesEqr121 화면 IBSheet Generation Class
*Open Issues :
*Change history :
*@LastModifyDate : 2009-09-14
*@LastModifier : chae chang Ho
*@LastVersion : 1.0
* 2009-07-15 chae chang Ho
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.simulationmanage.onewaysimulate.event;

import java.sql.SQLException;
import java.util.List;

import com.hanjin.apps.alps.ees.eqr.common.vo.CommonRsVO;
import com.hanjin.apps.alps.ees.eqr.simulationmanage.onewaysimulate.vo.EesEqr0010ConditionVO;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.util.object.ObjectCloner;
import com.hanjin.framework.core.controller.ViewAdapter;

/**
 * EesEqr121 화면 IBSheet XML 생성<br>
 * - IBSheet로 반환할 서버처리결과를 XML로 변환하는 클래스이다.<br>
 * 
 * @author chung eun ho
 * @see ViewAdapter 참조
 * @since J2EE 1.5
 */
public class EesEqr0010ViewAdapter extends ViewAdapter {

	
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
		StringBuilder sb = new StringBuilder();
		String[] volInfo = null;
		String[] maxArr  = null;
		String[] gapArr  = null;
		
		
		
		CommonRsVO listVO = new CommonRsVO();
		AbstractValueObject vo = (AbstractValueObject)vos.get(0);
		ObjectCloner.build(vo, listVO);
		EesEqr0010ConditionVO condiVO = (EesEqr0010ConditionVO)listVO.getConditionVO();
		DBRowSet rowSet				  = listVO.getDbRowset();
		
		volInfo = condiVO.getVolInfo();
		maxArr = condiVO.getMaxInfo();
		gapArr = condiVO.getGapInfo();

		int[] hapArr 	= new int[volInfo.length];
		int[] hapgapArr = new int[volInfo.length];
		//String[] gapArr 	= new String[volInfo.length];
		//String[] maxArr 	= new String[volInfo.length];
		Boolean[] keyArr    = new Boolean[volInfo.length];
		
		// 값 초기화
		
		for(int k = 0 ; k < volInfo.length ; k++ ){
			hapArr[k] 		= 0;
			hapgapArr[k] 	= 0;
			//gapArr[k]		= "";
			//maxArr[k]		= "";
			keyArr[k]		= true;
		}
		
		try{
			sb.append("<DATA TOTAL='"+getRowSetCnt(rowSet)+"'> ");
			
			if (rowSet != null) {
				while (rowSet.next()) {	
					sb.append("<TR>");
					sb.append("<TD>R</TD>");
					sb.append("<TD></TD>");
					if (JSPUtil.getNull(rowSet.getString(15)).equals("1")) {	
						for(int j = 1 ; j <= rowSet.getMetaData().getColumnCount() ; j++){
							sb.append("<TD EDIT ='FALSE'><![CDATA["+JSPUtil.getNull(rowSet.getString(j))+"]]></TD>");
						}
					}else { 
						sb.append("<TD EDIT ='FALSE'><![CDATA["+JSPUtil.getNull(rowSet.getString(1))+"]]></TD>");
						sb.append("<TD EDIT ='FALSE'><![CDATA["+JSPUtil.getNull(rowSet.getString(2))+"]]></TD>");
						sb.append("<TD EDIT ='FALSE'><![CDATA["+JSPUtil.getNull(rowSet.getString(3))+"]]></TD>");
						sb.append("<TD EDIT ='FALSE'><![CDATA["+JSPUtil.getNull(rowSet.getString(4))+"]]></TD>");
						int j = 0;
						for(j = 0 ; j < volInfo.length ; j++ ){
							//--------------------- TP SZ 별 값 적용 
						    if (keyArr[j]){ 
						    	if (JSPUtil.getNull(rowSet.getString(5+j)).equals(maxArr[j])) {
						           	if (hapgapArr[j] < 0) {
						           		keyArr[j] = false;
								    	hapArr[j] = Integer.parseInt(JSPUtil.getNull(rowSet.getString(5), "0"))+ hapgapArr[j]; 
								    	      if (hapArr[j] < 0 ) {
								    	    	  hapgapArr[j] = hapArr[j];
								    	    	  keyArr[j] = true;
								    	    	  hapArr[j] =0;
								        	  }else {
								        	      keyArr[j] = false;
								              }
						            }else{
						            	keyArr[j] = false;
						        		hapArr[j] = Integer.parseInt(JSPUtil.getNull(rowSet.getString(5) , "0"))+ Integer.parseInt(JSPUtil.getNull(gapArr[j],"0")); 
						        	         if (hapArr[j] < 0 ) {
						        	    	     hapgapArr[j] = hapArr[j];
						        	    	     keyArr[j] = true;
						        	    	     hapArr[j] =0;
						        	         }else {
						        	    	     keyArr[j] = false;
						                     }
						             }
	  
						    sb.append("<TD><![CDATA["+Integer.toString(hapArr[j])+"]]></TD>");
						         } else {
						    sb.append("<TD><![CDATA["+JSPUtil.getNull(rowSet.getString(5+j))+"]]></TD>");
						         } 
						    } else { 
						    sb.append("<TD><![CDATA["+JSPUtil.getNull(rowSet.getString(5+j))+"]]></TD>");
						    } 
						}
					    sb.append("<TD EDIT ='FALSE'><![CDATA["+JSPUtil.getNull(rowSet.getString(5+j))+"]]></TD>");
					    sb.append("<TD EDIT ='FALSE'><![CDATA["+JSPUtil.getNull(rowSet.getString(6+j))+"]]></TD>");
					}
					sb.append("</TR>\n");
				}
				
			}
	
			sb.append(" </DATA>");					
		}catch(SQLException ex){
			throw new RuntimeException(ex.getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new RuntimeException(ex.getMessage());
		}

		return sb.toString();

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
		return null;
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
		
		return sb.toString();
	}
}