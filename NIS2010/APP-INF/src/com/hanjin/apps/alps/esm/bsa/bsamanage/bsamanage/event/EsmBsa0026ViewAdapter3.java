
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBsa0026ViewAdapter3.java
*@FileTitle : EsmBsa0026ViewAdapter3
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.14
*@LastModifier : 김기대
*@LastVersion : 1.0
* 2009.07.14 김기대 
* 1.0 Creation
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
 * ESM_BSA_0026 에 대한 ViewAdapter<br>
 * - ESM_BSA_0026HTMLAction에서 작성<br>
 *
 * @author 김기대
 * @see HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmBsa0026ViewAdapter3 extends DefaultViewAdapter {
	
    public EsmBsa0026ViewAdapter3(){
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
    @SuppressWarnings("unchecked")
	protected String makeDataTag(List list, String prefix) {
    	int totCnt  = list.size();  
    	
    	AbstractValueObject vo = (AbstractValueObject)list.get(0);
//	    String realColNms[] = getColHeader(vo);
//	    String changedColNms[] = getChangedColNms(realColNms, prefix);
	      
	    if(vo.getMaxRows() > 0){
	      	totCnt = vo.getMaxRows();
	    }  
	    
	    StringBuilder strBuilder = new StringBuilder();
	    
	    //로직----------------------------------------

	    //----------------------------------------------
	    
	    strBuilder.append("<DATA TOTAL=\""+totCnt+"\">");
	    if(totCnt > 0){
	    	try{
	    		
	    		//로직-------------------------------------------------------------------------------------------------            
	            for(int i=0; i<totCnt; i++){
	            	Map colValues = ((AbstractValueObject)list.get(i)).getColumnValues();
	            	   
	            	log.debug("JSPUtil.getNull((String)colValues.get(bsa_seq      )) = "+JSPUtil.getNull((String)colValues.get("bsa_seq"      )));
	            	log.debug("JSPUtil.getNull((String)colValues.get(bsa_fm_dt    )) = "+JSPUtil.getNull((String)colValues.get("bsa_fm_dt"    )));
	            	log.debug("JSPUtil.getNull((String)colValues.get(bsa_to_dt    )) = "+JSPUtil.getNull((String)colValues.get("bsa_to_dt"    )));
	            	log.debug("JSPUtil.getNull((String)colValues.get(trd_cd       )) = "+JSPUtil.getNull((String)colValues.get("trd_cd"       )));
	            	log.debug("JSPUtil.getNull((String)colValues.get(rlane_cd     )) = "+JSPUtil.getNull((String)colValues.get("rlane_cd"     )));
	            	log.debug("JSPUtil.getNull((String)colValues.get(dir_cd       )) = "+JSPUtil.getNull((String)colValues.get("dir_cd"       )));
	            	log.debug("JSPUtil.getNull((String)colValues.get(vsl_seq      )) = "+JSPUtil.getNull((String)colValues.get("vsl_seq"      )));
	            	log.debug("JSPUtil.getNull((String)colValues.get(vsl_cd       )) = "+JSPUtil.getNull((String)colValues.get("vsl_cd"       )));
	            	log.debug("JSPUtil.getNull((String)colValues.get(bsa_op_cd    )) = "+JSPUtil.getNull((String)colValues.get("bsa_op_cd"    )));
	            	log.debug("JSPUtil.getNull((String)colValues.get(bsa_op_jb_cd )) = "+JSPUtil.getNull((String)colValues.get("bsa_op_jb_cd" )));
	            	log.debug("JSPUtil.getNull((String)colValues.get(crr_cd       )) = "+JSPUtil.getNull((String)colValues.get("crr_cd"       )));
	            	log.debug("JSPUtil.getNull((String)colValues.get(stup_flg     )) = "+JSPUtil.getNull((String)colValues.get("stup_flg"     )));
	            	log.debug("JSPUtil.getNull((String)colValues.get(crr_bsa_capa      )) = "+JSPUtil.getNull((String)colValues.get("crr_bsa_capa"      )));
	            	   
	    			
                    strBuilder.append("<TR>");
                    strBuilder.append("  <TD>R</TD>");
                    
                    strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("bsa_seq"))+"</TD>");
                    strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("bsa_fm_dt"))+"</TD>");
                    strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("bsa_to_dt"))+"</TD>");
                    strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("trd_cd"))+"</TD>");
                    strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("rlane_cd"))+"</TD>");
                    strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("dir_cd"))+"</TD>");
                    
                    strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("vsl_seq"))+"</TD>");
                    strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("vsl_cd"))+"</TD>");
                    strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("bsa_op_cd"))+"</TD>");
                    strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("bsa_op_jb_cd"))+"</TD>");
                    strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("crr_cd"))+"</TD>");
                    
                    strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("stup_flg"))+"</TD>");
                    strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("crr_bsa_capa"))+"</TD>");
                    strBuilder.append("</TR>");   
	            }
	            //-------------------------------------------------------------------------------------------------
            } catch(Exception ex){
                log.error(ex.getMessage(), ex);
                throw new RuntimeException(ex.getMessage());
            }	
            
	    }
	    
	    strBuilder.append("</DATA>");  
	    
	    return strBuilder.toString();
    }       
	
}
