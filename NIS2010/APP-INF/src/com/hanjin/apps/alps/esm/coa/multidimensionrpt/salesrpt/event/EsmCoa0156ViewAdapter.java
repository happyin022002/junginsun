/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmCoa0156ViewAdapter.java
*@FileTitle : EsmCoa0156ViewAdapter
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.23
*@LastModifier : 김기식
*@LastVersion : 1.0
* 2009.10.21 김기식
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.multidimensionrpt.salesrpt.event;

import java.util.List;

import com.hanjin.apps.alps.esm.coa.multidimensionrpt.salesrpt.vo.SalesOffiRepoRtnVO;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.DefaultViewAdapter;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.core.layer.event.EventException;

/**
 * ESM_COA_0156 에 대한 ViewAdapter<br>
 * - ESM_COA_0156HTMLAction에서 작성<br>
 *
 * @author 김기식
 * @see HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmCoa0156ViewAdapter extends DefaultViewAdapter {
	
    public EsmCoa0156ViewAdapter(){
    	super(); 
    }
    
	/**
	 * View Adapter 생성시 자동으로 호출된다.<br>
	 *  <br>
	 * 
	 * @param List list
	 * @param String prefix
	 * @return String
	 * @exception EventException
	 */	      
    protected String makeDataTag(List<AbstractValueObject> list, String prefix) {
    	log.debug("########### EsmCoa0156ViewAdapter ########### [START]");
    	SalesOffiRepoRtnVO listVo = (SalesOffiRepoRtnVO)list.get(0);
    	
    	DBRowSet[] rowSet = listVo.getRowSets(); //DB ResultSet
 		
 		StringBuilder ibStr = new StringBuilder();
 		StringBuilder tmpStr = new StringBuilder();
 		//String strErrMsg = "";								//에러메세지
    	
    	String header   = "";
    	String f_ctrt_ofc_cd   = "";
    	String f_sls_ofc_cd   = "";
    	String f_ioc   = "";
    	String f_rlane   = "";
    	String f_vvd   = "";
    	String f_sls_yrmon   = "";
    	String f_cost_wk   = "";
    	int i = 1;
		
		try{			
    		// 헤더 정보를 만든다.
			if(rowSet[3] != null){
				rowSet[3].beforeFirst();
				while(rowSet[3].next()){									
					tmpStr.append(rowSet[3].getString("spcl_cntr_tpsz_cd")).append("|");
				}
			}
			header = tmpStr.toString();
			
			ibStr.append("\n<ETC-DATA>");
			ibStr.append("\n<ETC KEY='xml_1'>");
			ibStr.append("\n<![CDATA[");
			ibStr.append("\n<SHEET>");
			ibStr.append("\n<DATA>");
			if (rowSet[0] != null) {
				while (rowSet[0].next()) {
					f_ctrt_ofc_cd = JSPUtil.getNull(rowSet[0].getString("ctrt_ofc_cd"));
					f_sls_ofc_cd  = JSPUtil.getNull(rowSet[0].getString("sls_ofc_cd"));
					f_ioc         = JSPUtil.getNull(rowSet[0].getString("ioc_cd"));
					f_rlane       = JSPUtil.getNull(rowSet[0].getString("rlane_cd"));
					f_vvd         = JSPUtil.getNull(rowSet[0].getString("vvd"));
					f_sls_yrmon   = JSPUtil.getNull(rowSet[0].getString("sls_yrmon"));
					f_cost_wk     = JSPUtil.getNull(rowSet[0].getString("cost_wk"));
					ibStr.append("\n<TR>");
					i=7;
					for (int j = 0 ; j < rowSet[0].getMetaData().getColumnCount()-6 ; j++) {
						ibStr.append("\n<TD>"+JSPUtil.getNull(rowSet[0].getString(i++))+"</TD>");
					}
					ibStr.append("\n</TR>");
					i = 8;
				}
			}
			ibStr.append("\n</DATA>");
			ibStr.append("\n</SHEET>]]>");
			ibStr.append("\n</ETC>");
			ibStr.append("\n<ETC KEY='xml_2'>");
			ibStr.append("\n<![CDATA[");
			ibStr.append("\n<SHEET>");
			ibStr.append("\n<DATA>");
			i = 1;
			if (rowSet[1] != null) {
				while (rowSet[1].next()) {
					ibStr.append("\n<TR>");
					for (int j = 0 ; j < rowSet[1].getMetaData().getColumnCount() ; j++) {
						ibStr.append("\n<TD>"+JSPUtil.getNull(rowSet[1].getString(i++))+"</TD>");
					}
					ibStr.append("\n</TR>");
					i = 1;
				}
			}
			ibStr.append("\n</DATA>");
			ibStr.append("\n</SHEET>]]>");
			ibStr.append("\n</ETC>");
			ibStr.append("\n<ETC KEY='xml_3'>");
			ibStr.append("\n<![CDATA[");
			ibStr.append("\n<SHEET>");
			ibStr.append("\n<DATA>");
			i = 1;
			if (rowSet[2] != null) {
				while (rowSet[2].next()) {
					ibStr.append("\n<TR>");
					for (int j = 0 ; j < rowSet[2].getMetaData().getColumnCount() ; j++) {
						ibStr.append("\n<TD>"+JSPUtil.getNull(rowSet[2].getString(i++))+"</TD>");
					}
					ibStr.append("\n</TR>");
					i = 1;
				}
			}
			ibStr.append("\n</DATA>");
			ibStr.append("\n</SHEET>]]>");
			ibStr.append("\n</ETC>");
			ibStr.append("\n<ETC KEY='header'>"+header+"</ETC>");
			ibStr.append("\n<ETC KEY='f_ctrt_ofc_cd'>"+f_ctrt_ofc_cd+"</ETC>");
			ibStr.append("\n<ETC KEY='f_sls_ofc_cd'>"+f_sls_ofc_cd+"</ETC>");
			ibStr.append("\n<ETC KEY='f_ioc'>"+f_ioc+"</ETC>");
			ibStr.append("\n<ETC KEY='f_rlane'>"+f_rlane+"</ETC>");
			ibStr.append("\n<ETC KEY='f_vvd'>"+f_vvd+"</ETC>");
			ibStr.append("\n<ETC KEY='f_sls_yrmon'>"+f_sls_yrmon+"</ETC>");
			ibStr.append("\n<ETC KEY='f_cost_wk'>"+f_cost_wk+"</ETC>");
			ibStr.append("\n</ETC-DATA>");
    				    
        }    	
    	catch(Exception ex){
            log.error(ex.getMessage(), ex);
            throw new RuntimeException(ex.getMessage());
        }    	
 		
        log.debug("########### EsmCoa0156ViewAdapter ########### [END]");
        return ibStr.toString();
    }
    
}
