/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesLocYardInitialCommonViewAdapter.java
*@FileTitle : EES_LOCYARDINITIAL_COMMON  IBSheet Generation Class
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.eqr.cntrcommon.eqrcommon.event;

import java.util.List;

import com.clt.apps.opus.ees.eqr.cntrcommon.eqrcommon.vo.CommonVO;
import com.clt.apps.opus.ees.eqr.cntrcommon.eqrcommon.vo.EesCommonConditionVO;
import com.clt.apps.opus.ees.eqr.cntrcommon.eqrcommon.vo.EesCommonVO;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.component.util.object.ObjectCloner;
import com.clt.framework.core.controller.ViewAdapter;

/**
 * EES_LOCYARDINITIAL_COMMON, IBSheet XML <br>
 * 
 * @author 
 * @see ViewAdapter 
 * @since J2EE 1.6
 */
public class EesLocYardInitialVesselViewAdapter extends ViewAdapter {

	
	/**
	 * VO List Parsing<br>
	 * 
	 * @param vos List<AbstractValueObject> List 
	 * @param colOrder String[] Column
	 * @param prefix String IBSheet savename's prefix
	 * @return String <Data>
	 * @exception  
	 */	
	protected String makeDataTag(List<AbstractValueObject> OBVOS, String prefix) {
		StringBuilder sb = new StringBuilder();
		CommonVO listVO = new CommonVO();
		AbstractValueObject vo = (AbstractValueObject)OBVOS.get(0) ;
		ObjectCloner.build(vo, listVO);

		EesCommonConditionVO condiVO = (EesCommonConditionVO)listVO.getConditionVo();
		EesCommonVO retVO  = (EesCommonVO)listVO.getResultVo();
		String row 								= "";
		String colname                          = "";
		String initialEcc                       = "";
		String resultFlag                       = "";
		String[] locYard 						= null;
		
		try{
			row    	   = condiVO.getLocyardinitialRow();
			colname	   = condiVO.getLocyardinitialColname();
			initialEcc = condiVO.getLocyardinitialEcc();
			
			resultFlag = retVO.getResultset7();        
			locYard = retVO.getLocyardInitialResult();				
					
			if(resultFlag.equals("1")) { // vessel schedule yard 			
				sb.append("<DATA>\n");
				sb.append("<TR ROW=\""+row+"\" >");
				sb.append("	<TD COL=\""+ colname +"\" DATA-TYPE=\"dtData\" EDIT=\"false\" >"+JSPUtil.getNull(locYard[0])+"</TD>");
				sb.append("</TR>  ");
				sb.append("</DATA>\n");
				
			}else if(resultFlag.equals("2")) {  // vessel schedule yard > 2
				sb.append("<DATA>\n");
				sb.append("<TR ROW=\""+row+"\" >");
				sb.append("	<TD COL=\""+ colname +"\" DATA-TYPE=\"dtCombo\" COMBO-TEXT='"+JSPUtil.getNull(locYard[0].replace("'", " "))+"' COMBO-CODE='"+JSPUtil.getNull(locYard[1])+"' ></TD>");
				sb.append("</TR>  ");
				sb.append("</DATA>\n");
				
			}else { // resultFlag = 3
				if(locYard[0]==null || locYard[0].equals("")) { 
					locYard[0] = initialEcc;	
					sb.append("<DATA>\n");
					sb.append("<TR ROW=\""+row+"\" >");
					sb.append("	<TD COL=\""+ colname +"\" DATA-TYPE=\"dtData\" >"+JSPUtil.getNull(locYard[0])+"</TD>");
					sb.append("</TR>  ");
					sb.append("</DATA>\n");
					
				}else {						
					sb.append("<DATA>\n");
					sb.append("<TR ROW=\""+row+"\" >");
					sb.append("	<TD COL=\""+ colname +"\" DATA-TYPE=\"dtComboEdit\" COMBO-TEXT='"+JSPUtil.getNull(locYard[0].replace("'", " "))+"' COMBO-CODE='"+JSPUtil.getNull(locYard[1])+"' ></TD>");
					sb.append("</TR>  ");
					sb.append("</DATA>\n");
				}
			}
			
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new RuntimeException(ex.getMessage());
		}
		
		return sb.toString();
	}

	/**
	 * DBRowSet Parsing<br>
	 * @param rs DBRowSet 		VO
	 * @param prefix String 		IBSheet savename's prefix string
	 * @return String IBSheet 		<DATA>
	 * @exception 
	 */
	protected String makeDataTag(DBRowSet rowSet,String prefix) {
		StringBuilder sb = new StringBuilder();
		
		

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
		
		return sb.toString();
	}

}
