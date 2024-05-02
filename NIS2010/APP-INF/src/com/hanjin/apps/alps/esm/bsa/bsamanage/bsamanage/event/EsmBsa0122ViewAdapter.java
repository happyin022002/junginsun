
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBsa0024ViewAdapter.java
*@FileTitle : EsmBsa0024ViewAdapter
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.14
*@LastModifier : 김기대
*@LastVersion : 1.0
* 2009.07.14 김기대 
* 1.0 Creation
* 
* 2012.08.24 이석준 [CHM-201219866] SPS INFO CREATION 의 OTHER SWAP NOTICE 삭제 기능 추가 요청
=========================================================*/
package com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.event;

import java.util.List;
import java.util.Map;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.DefaultViewAdapter;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.core.layer.event.EventException;

/**
 * ESM_BSA_0122 에 대한 ViewAdapter<br>
 * - ESM_BSA_0122HTMLAction에서 작성<br>
 *
 * @author 김기대
 * @see HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmBsa0122ViewAdapter extends DefaultViewAdapter {
	
    public EsmBsa0122ViewAdapter(){
    	super();
    }
    
	/**
	 * View Adapter 생성시 자동으로 호출된다.<br>
	 *  - RowSet 데이타에 대해서 XML을 구현한 문자열을 구현하여 준다.<br>
	 * 
	 * @param DBRowSet rs
	 * @param String prefix
	 * @return String
	 * @exception EventException
	 */	      
    @SuppressWarnings("unchecked")
	protected String makeDataTag(List<AbstractValueObject> vos, String prefix) {
    	StringBuilder strBuilder = new StringBuilder();

    	int totCnt = vos.size();
 
	    strBuilder.append("<DATA TOTAL=\""+totCnt+"\">");
	    if(totCnt > 0){
	    	try{
            
	            for(int i=0; i<totCnt; i++){
	            	Map colValues = ((AbstractValueObject)vos.get(i)).getColumnValues();
					strBuilder.append("<TR>");
					strBuilder.append("<TD>0</TD>");
					strBuilder.append("<TD>R</TD>");
					strBuilder.append("<TD>" +JSPUtil.getNull((String)colValues.get("bsa_fm_crr_cd"))+"</TD>");
					strBuilder.append("<TD>" +JSPUtil.getNull((String)colValues.get("crr_swap_capa"))+"</TD>");
					strBuilder.append("<TD>" +JSPUtil.getNull((String)colValues.get("bsa_to_crr_cd"))+"</TD>");
					strBuilder.append("</TR>");
	            }
            } catch(Exception ex){
                log.error(ex.getMessage(), ex);
                throw new RuntimeException(ex.getMessage());
            }
	    }
	    strBuilder.append("</DATA>");
	    return strBuilder.toString();
    }      
	
}
