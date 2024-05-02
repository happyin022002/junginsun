/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmMas0035ViewAdapterGS.java
*@FileTitle : EsmMas0035ViewAdapterGS
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.23
*@LastModifier : 김기식
*@LastVersion : 1.0
* 2009.09.23 김기식
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.multidimensionrpt.salesrpt.event;

import java.util.List;

import com.hanjin.apps.alps.esm.mas.multidimensionrpt.salesrpt.vo.SalesOffiRepoRtnVO;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.DefaultViewAdapter;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.core.layer.event.EventException;

/**
 * ESM_MAS_0035 에 대한 ViewAdapter<br>
 * - ESM_MAS_0035HTMLAction에서 작성<br>
 *
 * @author 김기식
 * @see HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmMas0035ViewAdapterGS extends DefaultViewAdapter {
	
    public EsmMas0035ViewAdapterGS(){
    	super();
    }
    
	/**
	 * View Adapter 생성시 자동으로 호출된다.<br>
	 *  - List 데이타에 대해서 XML을 구현한 문자열을 구현하여 준다.<br>
	 * 
	 * @param List list
	 * @param String prefix
	 * @return String
	 * @exception EventException
	 */	      
    protected String makeDataTag(List<AbstractValueObject> list, String prefix) {
    	log.debug("########### EsmMas0035ViewAdapterGS ########### [START]");
		
    	SalesOffiRepoRtnVO listVo = (SalesOffiRepoRtnVO)list.get(0);
    	StringBuilder strBuilder = new StringBuilder();
 		//String strErrMsg = "";								//에러메세지
    	DBRowSet rowSet = null;							   	//DB ResultSet
 		
    	rowSet = listVo.getRowSet();
				
		try{			
			strBuilder.append("<DATA COLSEPARATOR='|'>");
			
			if(rowSet != null){			
				while(rowSet.next()){
					strBuilder.append("\n<tr><![CDATA[|");
					for(int k=1; k<=rowSet.getMetaData().getColumnCount(); k++){
						
						if(JSPUtil.getNull(rowSet.getString(k)).equals("")){
							strBuilder.append("|");
						} else {									
							strBuilder.append(JSPUtil.getNull(rowSet.getString(k)).trim().replaceAll("[|]", ""));
							strBuilder.append("|");
						}
					}
					strBuilder.append("\n]]></tr>");										
				}
			}
			
			strBuilder.append("      </DATA>");	    				    
        }        
        catch(Exception ex){
            log.error(ex.getMessage(), ex);
            throw new RuntimeException(ex.getMessage());
        }

		log.debug("########### EsmMas0035ViewAdapterGS ########### [END]");        
	    return strBuilder.toString();
    }     
}
