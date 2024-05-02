/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmMas0002ViewAdapter3.java
*@FileTitle : EsmMas0002ViewAdapter3
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.14
*@LastModifier : 김기대
*@LastVersion : 1.0
* 2009.07.14 김기대 
* 1.0 Creation
* 2010.02.05 임옥영 품질검토 결과 반영 (사용하지 않는 지역변수 주석처리 realColNms) 
* 2010.12.15 김기종 Ticket ID:CHM-201006305-01 MAS Architecture 위배사항 수정
=========================================================*/
package com.hanjin.apps.alps.esm.mas.stdunitcost.coststructure.event;

import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.mas.common.basic.CommonBC;
import com.hanjin.apps.alps.esm.mas.common.basic.CommonBCImpl;
import com.hanjin.apps.alps.esm.mas.stdunitcost.coststructure.vo.EsmMas0002ComboVO;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.DefaultViewAdapter;
import com.hanjin.framework.core.layer.event.EventException;

/**
 * ESM_MAS_0002 에 대한 ViewAdapter<br>
 * - ESM_MAS_0002HTMLAction에서 작성<br>
 *
 * @author 김기대
 * @see HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmMas0002ViewAdapter3 extends DefaultViewAdapter {
	
    public EsmMas0002ViewAdapter3(){
    	super();
    }

	/**
	 * View Adapter 생성시 자동으로 호출된다.<br>
	 *  - List 데이타에 대해서 XML을 구현한 문자열을 구현하여 준다.<br>
	 * 
	 * @param List<AbstractValueObject>
	 * @param  String prefix
	 * @return String
	 * @exception EventException
	 */
	protected String makeDataTag(List<AbstractValueObject> list, String prefix) {
    	EsmMas0002ComboVO vo = (EsmMas0002ComboVO)list.get(0);
    	
    	List<EsmMas0002ComboVO> retList = vo.getListSet();
		
    	int totCnt  = retList.size();  
    	
		//String realColNms[] = getColHeader(vo);
	      
	    if(vo.getMaxRows() > 0){
	      	totCnt = vo.getMaxRows();
	    }  
	    
	    StringBuilder strBuilder = new StringBuilder();
	    
	    //로직----------------------------------------
	    CommonBC commonBc = new CommonBCImpl();
		String sRow = "";
		String ibSgCd = "";
		String ibSgTxt = "";
//		String changeCol = "";	
		String changeValue = "";
		String[] tmpArr = null;
	    //----------------------------------------------
	    
	    strBuilder.append("<DATA>");
	    if(totCnt > 0){
	    	try{
	    		
	    		//로직-------------------------------------------------------------------------------------------------            
	            for(int i=0; i<totCnt; i++){
	            	Map colValues = ((AbstractValueObject)retList.get(i)).getColumnValues();

	        		sRow = JSPUtil.getNull((String)colValues.get("sRow"));
//	        		changeCol = JSPUtil.getNull((String)colValues.get("changeCol"));
	        		changeValue = JSPUtil.getNull((String)colValues.get("changeValue"));
	        		
	        		ibSgCd = commonBc.getIbCodeCombo("ra_sgrp_cost_cd", "raSubGrp", changeValue, "code").trim();
	        		ibSgTxt = commonBc.getIbCodeCombo("ra_sgrp_cost_cd","raSubGrp", changeValue, "name").trim();
	        		
	        		//맨앞의 "|"제거 
	        		if(ibSgCd.startsWith("|")) ibSgCd=ibSgCd.substring(1);
	        		if(ibSgTxt.startsWith("|")) ibSgTxt=ibSgTxt.substring(1);
	        		
	        		tmpArr = (ibSgCd.replace('|', ',')).split(",");
	        		
	        		strBuilder.append("<TR ROW=\""+ sRow +"\">");
	        		strBuilder.append("  <TD COL=\"ra_sgrp_cost_nm\" DATA-TYPE=\"dtCombo\" COMBO-TEXT=\""+ ibSgTxt +"\" COMBO-CODE=\""+ ibSgCd +"\"> </TD>");
	        		String temp = tmpArr.length>0?tmpArr[0]:"";
	        		strBuilder.append("  <TD COL=\"ra_sgrp_cost_cd\">"+temp+"</TD>");
	        		strBuilder.append("</TR>"); 
	            }
	            //-------------------------------------------------------------------------------------------------
            } catch(Exception e){
                log.error("err " + e.toString(), e);
            }	
            
	    }
	    
	    strBuilder.append("</DATA>");    
	    return strBuilder.toString();
    }       
}
