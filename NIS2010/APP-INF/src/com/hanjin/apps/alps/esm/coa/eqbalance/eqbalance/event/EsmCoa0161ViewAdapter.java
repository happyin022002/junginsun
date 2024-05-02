/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_COA_0136HTMLAction.java
*@FileTitle : From(POR) RCC For EQ Repo. Contribution
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.08
*@LastModifier : 박수훈
*@LastVersion : 1.1
* 2008.09.01 전윤주 CSR No.N200808260006 EQ repo rule-set(Rlane setting을 From-To ECC setting으로)
* 2009.10.07 박수훈 Alps New FrameWork 적용[0161] 
* 2010.02.05 임옥영 품질검토 결과 반영 (사용하지 않는 지역변수 주석처리 changedColNms) 
* 2010.02.12 임옥영 Line No. 54 Variable name : realColNms
* 2010.02.19 임옥영 소스품질검토 결과 반영  Line No. 56 Variable name : realColNms
=========================================================*/
package com.hanjin.apps.alps.esm.coa.eqbalance.eqbalance.event;

import java.util.List;
import java.util.Map;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.DefaultViewAdapter;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.core.layer.event.EventException;

/**
 * EsmCoa0004GS2 에 대한 ViewAdapter<br>
 *  EsmCoa0004GS2ViewAdapter 작성<br>
 *
 * @author 박수훈
 * @see HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmCoa0161ViewAdapter extends DefaultViewAdapter {
	
    public EsmCoa0161ViewAdapter(){
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
    
    protected String makeDataTag(List list, String prefix) {
    	StringBuilder strBuilder = new StringBuilder();

    	int totCnt  = list.size();  
    	
    	AbstractValueObject vo = (AbstractValueObject)list.get(0);
	    //String realColNms[] = getColHeader(vo);
	    //String changedColNms[] = getChangedColNms(realColNms, prefix);
	      
	    if(vo.getMaxRows() > 0){
	      	totCnt = vo.getMaxRows();
	    }      
	    try{
		    strBuilder.append("<DATA TOTAL='"+totCnt+"'>");
		    if(totCnt > 0){
	            for(int i=0; i<totCnt; i++){
	            	Map colValues = ((AbstractValueObject)list.get(i)).getColumnValues();
	            	String slevel = String.valueOf(colValues.get("slevel"));  
	            	
					strBuilder.append("\n<TR LEVEL='"+String.valueOf(slevel)+"'");
					strBuilder.append(" EXPAND='FALSE' ");		
					strBuilder.append(">");
					strBuilder.append("\n    <TD></TD>");					
					strBuilder.append("\n    <TD>"+JSPUtil.getNull((String)colValues.get("del_repo_flg"))+"</TD>");
					strBuilder.append("\n    <TD>"+JSPUtil.getNull((String)colValues.get("cost_yrmon"))+"</TD>");
					strBuilder.append("\n    <TD>"+JSPUtil.getNull((String)colValues.get("rcc_cd"))+"</TD>");
					strBuilder.append("\n    <TD>"+JSPUtil.getNull((String)colValues.get("ecc_cd"))+"</TD>");
					strBuilder.append("\n    <TD>"+JSPUtil.getNull((String)colValues.get("slevel"))+"</TD>");
					strBuilder.append("\n</TR>");  	
	            }
		    }
		    strBuilder.append("\n</DATA>");
		    
        } catch(Exception e){
			log.error("err "+e.toString(),e);
        }
	    
	    return strBuilder.toString();
    }    
}