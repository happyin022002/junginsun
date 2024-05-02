/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EsmMas0192ViewAdapter.java
*@FileTitle : EsmMas0192ViewAdapter
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.28
*@LastModifier : Young-Heon Lee
*@LastVersion : 1.0
* 2015.05.28 Young-Heon Lee
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.multidimensionrpt.multidimensionrpt.event;

import java.sql.SQLException;
import java.util.List;

import com.hanjin.apps.alps.esm.mas.multidimensionrpt.multidimensionrpt.vo.MultiDimensionRptRtnVO;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.DefaultViewAdapter;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.core.layer.event.EventException;

/**
 * ESM_MAS_0192 에 대한 ViewAdapter<br>
 * - ESM_MAS_0192HTMLAction에서 작성<br>
 *
 * @author Young-Heon Lee
 * @see HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmMas0192ViewAdapter extends DefaultViewAdapter {
	
    public EsmMas0192ViewAdapter(){
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
    	log.debug("########### EsmMas0192ViewAdapter ########### [START]");
    	StringBuilder strBuilder = new StringBuilder();
        DBRowSet[] rowSet = null;
        MultiDimensionRptRtnVO listVo = null;
		
        strBuilder.append("      <DATA>");	
        
    	try{	
    		listVo = (MultiDimensionRptRtnVO)list.get(0);
    		rowSet = listVo.getRowSets();
    		
			if (rowSet != null) {
				
				String nextflag = ""; //그룹이 한개인 경우 표시 안함
				String lvl = "";
				String cnt = "";
				String colr_flg = "";
				
				String stnd_cost_cd = "";
				String itm_desc = "";
				
				String format_flg = ""; //DATA-FORMAT='dfFloatOrg' POINT-COUNT='2'
				
				String expand = "";
				String color = "";
				String bold = "";
				
				while (rowSet[0].next()) {
					lvl = JSPUtil.getNull(rowSet[0].getString("lv"));
					cnt = JSPUtil.getNull(rowSet[0].getString("cnt"));
					colr_flg = JSPUtil.getNull(rowSet[0].getString("rpt_itm_colr_flg"));
					
					stnd_cost_cd = JSPUtil.getNull(rowSet[0].getString("stnd_cost_cd"));
					itm_desc     = rowSet[0].getString("itm_desc");
					
					if (lvl.equals("1") && cnt.equals("1")) { // level이 '1'이고 건수가 1건이면, 현 line은 안보이게 하고,
						                                      // 다음 line의 level값을 '2'에서 '1'로 수정
						nextflag = "change";
						continue;
					}
					if (nextflag.equals("change")) {
						lvl = "1";
						nextflag = "";
					}
					
					if (lvl.equals("1")) {
						expand = " EXPAND='false'";
					} else {
						expand = "";
					}
					
					if (colr_flg.equals("Y")) {
						color = " COLOR='blue'";
						bold = " BOLD='true'";
					} else {
						color = "";
						bold = "";
					}
					if (stnd_cost_cd.equals("LOADFACT")) {
						format_flg = " DATA-FORMAT='dfFloatOrg' POINT-COUNT='1'";
				    } else {
//						format_flg = "";
						format_flg = " DATA-FORMAT='dfInteger'";
				    }

				    strBuilder.append("\n<TR LEVEL='").append(lvl).append("' ").append(expand).append(color).append(">");
				    
				    strBuilder.append("\n<TD ").append(bold).append("></TD>");
				    strBuilder.append("\n<TD ").append(bold).append(">").append(stnd_cost_cd).append("</TD>");
				    strBuilder.append("\n<TD ").append(bold).append("><![CDATA[").append(itm_desc).append("]]></TD>");
				    strBuilder.append("\n<TD ").append(bold).append(format_flg).append(">").append(JSPUtil.getNull(rowSet[0].getString("hh_wkly_amt"))).append("</TD>");
			    	strBuilder.append("\n<TD ").append(bold).append(format_flg).append(">").append(JSPUtil.getNull(rowSet[0].getString("bh_wkly_amt"))).append("</TD>");
			    	strBuilder.append("\n<TD ").append(bold).append(format_flg).append(">").append(JSPUtil.getNull(rowSet[0].getString("mb_wkly_amt"))).append("</TD>");
			    	strBuilder.append("\n<TD ").append(bold).append(format_flg).append(">").append(JSPUtil.getNull(rowSet[0].getString("ttl_wkly_amt"))).append("</TD>");
			    	strBuilder.append("\n<TD ").append(bold).append(format_flg).append(">").append(JSPUtil.getNull(rowSet[0].getString("hh_adj_amt"))).append("</TD>");
			    	strBuilder.append("\n<TD ").append(bold).append(format_flg).append(">").append(JSPUtil.getNull(rowSet[0].getString("bh_adj_amt"))).append("</TD>");
			    	strBuilder.append("\n<TD ").append(bold).append(format_flg).append(">").append(JSPUtil.getNull(rowSet[0].getString("mb_adj_amt"))).append("</TD>");
			    	strBuilder.append("\n<TD ").append(bold).append(format_flg).append(">").append(JSPUtil.getNull(rowSet[0].getString("ttl_adj_amt"))).append("</TD>");
			    	strBuilder.append("\n<TD ").append(bold).append(format_flg).append(">").append(JSPUtil.getNull(rowSet[0].getString("hh_mon_amt"))).append("</TD>");
			    	strBuilder.append("\n<TD ").append(bold).append(format_flg).append(">").append(JSPUtil.getNull(rowSet[0].getString("bh_mon_amt"))).append("</TD>");
			    	strBuilder.append("\n<TD ").append(bold).append(format_flg).append(">").append(JSPUtil.getNull(rowSet[0].getString("mb_mon_amt"))).append("</TD>");
			    	strBuilder.append("\n<TD ").append(bold).append(format_flg).append(">").append(JSPUtil.getNull(rowSet[0].getString("ttl_mon_amt"))).append("</TD>");
				    strBuilder.append("\n</TR>");
				}
			}
        }
        catch(SQLException ex){
            throw new RuntimeException(ex.getMessage());
        }
        catch(Exception ex){
            log.error(ex.getMessage(), ex);
            throw new RuntimeException(ex.getMessage());
        }	
        
        strBuilder.append("\n</DATA>");
		
		log.debug("########### EsmMas0192ViewAdapter ########### [END]");        
	    return strBuilder.toString();
    }     
}
