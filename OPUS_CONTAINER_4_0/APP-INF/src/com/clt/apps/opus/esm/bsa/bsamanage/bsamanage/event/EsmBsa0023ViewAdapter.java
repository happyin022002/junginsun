
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBsa0023ViewAdapter.java
*@FileTitle : EsmBsa0023ViewAdapter
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.14
*@LastModifier : 김기대
*@LastVersion : 1.0
* 2009.07.14 김기대
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bsa.bsamanage.bsamanage.event;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import com.clt.apps.opus.esm.bsa.common.vo.CommonBsaRsVO;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.DefaultViewAdapter;
import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.core.layer.event.EventException;

/**
 * ESM_BSA_0023 에 대한 ViewAdapter<br>
 * - ESM_BSA_0023HTMLAction에서 작성<br>
 *
 * @author 김기대
 * @see HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmBsa0023ViewAdapter extends DefaultViewAdapter {
	
    public EsmBsa0023ViewAdapter(){
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
	protected String makeDataTag(List<AbstractValueObject> list, String prefix) {
    	log.debug("########### EsmBsa0023ViewAdapter.makeDataTag(List<AbstractValueObject> list, String prefix) ########### [START]");
    	
    	CommonBsaRsVO vo = (CommonBsaRsVO)list.get(0);
    	CommonBsaRsVO[] arrayVo = vo.getCommonBsaRsVOArray();
		
		//log.debug("arrayVo.length = " + arrayVo.length);
		
		DBRowSet rowSet0 = arrayVo[0].getDbRowset();
		DBRowSet rowSet1 = arrayVo[1].getDbRowset();
		DBRowSet rowSet2 = arrayVo[2].getDbRowset();
		
		if(rowSet0 == null || rowSet1 == null || rowSet2 == null ){
			return "";
		}

		
		//Logic -----------------------------------------------------------------------START
		int uoc           =  3;  //필드수: 가변길이에서 보이는 한 필드는 실제는 UOC개 임
		int fixCnt        =  2;  //고정 컬럼수
		int varCnt        =  0;  //가변 컬럼수 = 데이터수 * UOC
		int totCnt        =  0;  //전체 컬럼수 = fixCnt + varCnt		
		
		//Hashtable detail = new Hashtable();
		HashMap detail = new HashMap();

		varCnt = rowSet0.getRowCount() * uoc;
		totCnt = fixCnt + varCnt; 

		String headTitleText = "";
		String[] groupCodes = new String[varCnt];
		String crrCd="";
		
		int curPos = 0;
		//Header
		

		// 첫번째 RowSet ========================================================================================== S
		// =======================================================================================================
   
    	try{
		    if(totCnt > 0){
		        StringBuffer sb1 = new StringBuffer();											//SJH.20150507.소스품질      		
		        StringBuffer sb2 = new StringBuffer();
		        
	    		while(rowSet0.next()){
	    			//UOC Dependent
//					headTitleText = headTitleText + "|" + JSPUtil.getNull(rowSet0.getString("crr_cd"))
//		                                          + "|" + JSPUtil.getNull(rowSet0.getString("crr_cd"))
//		                                          + "|" + JSPUtil.getNull(rowSet0.getString("crr_cd"));
//					
//					crrCd =crrCd + "|" + JSPUtil.getNull(rowSet0.getString("crr_cd"));					
    				sb1.append("|").append(JSPUtil.getNull(rowSet0.getString("crr_cd")))
    				   .append("|").append(JSPUtil.getNull(rowSet0.getString("crr_cd")))
    				   .append("|").append(JSPUtil.getNull(rowSet0.getString("crr_cd")));			//SJH.20150508.소스품질                    
    				sb2.append("|").append(JSPUtil.getNull(rowSet0.getString("crr_cd")));
    				headTitleText = sb1.toString();													//SJH.20150508.소스품질 
    				crrCd         = sb2.toString();			
					
					groupCodes[curPos] = JSPUtil.getNull(rowSet0.getString("crr_cd"));
					curPos++;		    			
	    		}
	    		
	    		while(rowSet2.next()){
					String key = JSPUtil.getNull(rowSet2.getString("key")) + "|" + JSPUtil.getNull(rowSet2.getString("crr_cd"));
					String flg = JSPUtil.getNull(rowSet2.getString("aply_flg"));
					detail.put(key, flg);						
	    		}		    		
		    }
        }
        catch(Exception ex){
            log.error(ex.getMessage(), ex);
            throw new RuntimeException(ex.getMessage());
        }
        // =======================================================================================================
        // 첫번째 RowSet ========================================================================================== E
        
        
        // 두번째 RowSet ========================================================================================== S
        // =======================================================================================================
        
        StringBuilder strBuilder = new StringBuilder();
        if(rowSet1.isPivot()){
        	strBuilder.append(makePivotDataTag(rowSet1));
        	return strBuilder.toString();
        }        
        
    	int totCnt2  = getRowSetCnt(rowSet1);//rs.getRowCount()
    	
    	//log.debug("totCnt2 = " + totCnt2);
        
    	try{
		    if(rowSet1.getMaxRows() > 0){
		      	totCnt2 = rowSet1.getMaxRows();
		    }  
		    
		    strBuilder.append("<DATA TOTAL=\""+totCnt2+"\">");
		    if(totCnt2 > 0){

	    		while(rowSet1.next()){
					String joinKey      = JSPUtil.getNull(rowSet1.getString("key"));
					String bsa_op_jb_nm = JSPUtil.getNull(rowSet1.getString("bsa_op_jb_nm"));

					StringBuffer buf = new StringBuffer();
					for (int idx=0; idx<(varCnt / uoc); idx++) {
						String dkey = joinKey + "|" + groupCodes[idx];
						String value = JSPUtil.getNull((String)detail.get(dkey));
						buf.append("\n");
						buf.append("<TD>R</TD>");
						buf.append("<TD>").append(dkey).append("</TD>");
						buf.append("<TD>").append(value).append("</TD>");
					}


					strBuilder.append("<TR>");
					strBuilder.append("  <TD>R</TD>");
					strBuilder.append("  <TD>"+bsa_op_jb_nm+"</TD>");
					strBuilder.append("  "+buf.toString()+"\n");
					strBuilder.append("</TR>");							
					
					//log.debug("strBuilder = " + strBuilder);
	    		}
		    
			    strBuilder.append("</DATA>");
			    
			    strBuilder.append("<ETC-DATA>");
			    strBuilder.append("  <ETC KEY=\"row\">"+varCnt+"</ETC>");
			    strBuilder.append("  <ETC KEY=\"header\">"+headTitleText+"</ETC>\n");
			    strBuilder.append("  <ETC KEY=\"crrCd\">"+crrCd+"</ETC>\n");			    
			    strBuilder.append("</ETC-DATA>");
		    }
        }
        catch(SQLException ex){
            throw new RuntimeException(ex.getMessage());
        }
        catch(Exception ex){
            log.error(ex.getMessage(), ex);
            throw new RuntimeException(ex.getMessage());
        }
        // =======================================================================================================
        // 두번째 RowSet ========================================================================================== E
        

		//Logic -----------------------------------------------------------------------END

		log.debug("########### EsmBsa0023ViewAdapter.makeDataTag(List<AbstractValueObject> list, String prefix) ########### [END]");
	    return strBuilder.toString();
    }        
	
}
