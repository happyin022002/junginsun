/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmCoa0072ViewAdapter.java
*@FileTitle : EsmCoa0072ViewAdapter
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.23
*@LastModifier : 김기식
*@LastVersion : 1.0
* 2009.10.23 김기식
* 1.0 Creation
* 2012.01.19 김종준 [CHM-201215724-01] L/F : 소수점 첫째자리까지만 존재 (둘째자리에서 반올림),나머지 모든 계정: 소숫점 존재 X (소숫점 첫째자리에서 반올림 )
* 2013.08.08 최성민 [CHM-201325911] [COA] P&L 화면 일부 로직 수정 -  By Account로 조회 시, E/B W/B가 아닌 H/H, B/H로 grouping 하여 표기
=========================================================*/
package com.hanjin.apps.alps.esm.coa.multidimensionrpt.multidimensionrpt.event;

import java.sql.SQLException;
import java.util.List;

import com.hanjin.apps.alps.esm.coa.multidimensionrpt.multidimensionrpt.vo.MultiDimensionRptRtnVO;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.DefaultViewAdapter;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.core.layer.event.EventException;

/**
 * ESM_COA_0072 에 대한 ViewAdapter<br>
 * - ESM_COA_0072HTMLAction에서 작성<br>
 *
 * @author 김기식
 * @see HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmCoa0072ViewAdapter extends DefaultViewAdapter {
	
    public EsmCoa0072ViewAdapter(){
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
    	log.debug("########### EsmCoa0072ViewAdapter ########### [START]");
    	StringBuilder strBuilder = new StringBuilder();
        DBRowSet[] rowSet = null;
        MultiDimensionRptRtnVO listVo = null;
        
        StringBuilder headCode = new StringBuilder(); //헤더가변
        StringBuilder headName = new StringBuilder(); //헤더가변
		
        strBuilder.append("      <DATA>");	
        
    	try{	
    		listVo = (MultiDimensionRptRtnVO)list.get(0);
    		rowSet = listVo.getRowSets();
    		
			if (rowSet != null) {
				int headCnt = rowSet[0].getRowCount();
				while (rowSet[0].next()) {
					headCode.append("|").append(JSPUtil.getNull(rowSet[0].getString("trd_cd")));
					headName.append("|").append(JSPUtil.getNull(rowSet[0].getString("trd_cd")));
				}
				
				String nextflag = ""; //그룹이 한개인 경우 표시 안함
				String lvl = "";
				String cnt = "";
				String colr_flg = "";
				
				String stnd_cost_cd = "";
				String itm_desc = "";
				
				String format_flg = ""; //DATA-FORMAT='dfFloatOrg' POINT-COUNT='2'
				String calcuLogic_flg = ""; //CALCU-LOGIC='' : ttl_amt필드의 7가지 경우에는 calc-logic를 해제
				
				String expand = "";
				String color = "";
				String bold = "";
				
				while (rowSet[1].next()) {
					lvl = JSPUtil.getNull(rowSet[1].getString("lv"));
					cnt = JSPUtil.getNull(rowSet[1].getString("cnt"));
					colr_flg = JSPUtil.getNull(rowSet[1].getString("rpt_itm_colr_flg"));
					
					stnd_cost_cd = JSPUtil.getNull(rowSet[1].getString("stnd_cost_cd"));
					itm_desc     = rowSet[1].getString("itm_desc");
					
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

				    if (stnd_cost_cd.equals("LOADFACT") || stnd_cost_cd.equals("RPB00000") || stnd_cost_cd.equals("CMCB0000") || 
				    	stnd_cost_cd.equals("CMB00000") || stnd_cost_cd.equals("OPCB0000") || stnd_cost_cd.equals("OPB00000") ||
				    	stnd_cost_cd.equals("BOPB0000") || stnd_cost_cd.equals("BOPB0000") ||
				    	stnd_cost_cd.equals("91401011") || stnd_cost_cd.equals("BCMB0000")) {
				    	calcuLogic_flg = " CALCU-LOGIC=''"; 
				    } else {
				    	calcuLogic_flg = ""; 
				    }
				    
				    strBuilder.append("\n<TR LEVEL='").append(lvl).append("' ").append(expand).append(color).append(">");
				    
				    strBuilder.append("\n<TD ").append(bold).append("></TD>");
				    strBuilder.append("\n<TD ").append(bold).append(">").append(stnd_cost_cd).append("</TD>");
				    strBuilder.append("\n<TD ").append(bold).append("><![CDATA[").append(itm_desc).append("]]></TD>");

				    //Detail수 만큼 추출
				    for(int idx=1; idx<=headCnt; idx++) {
				    	strBuilder.append("\n<TD ").append(bold).append(format_flg).append(">").append(JSPUtil.getNull(rowSet[1].getString("hh_amt" + idx))).append("</TD>");
				    	strBuilder.append("\n<TD ").append(bold).append(format_flg).append(">").append(JSPUtil.getNull(rowSet[1].getString("bh_amt" + idx))).append("</TD>");
				    	strBuilder.append("\n<TD ").append(bold).append(format_flg).append(">").append(JSPUtil.getNull(rowSet[1].getString("trd_amt" + idx))).append("</TD>");
				    }
				    
				    strBuilder.append("\n<TD ").append(bold).append(format_flg).append(calcuLogic_flg).append(">").append(JSPUtil.getNull(rowSet[1].getString("ttl_amt"))).append("</TD>");
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
        strBuilder.append("\n<ETC-DATA>");
        strBuilder.append("\n<ETC KEY='headCode'>").append(headCode.toString()).append("</ETC>");
        strBuilder.append("\n<ETC KEY='headName'>").append(headName.toString()).append("</ETC>");
        strBuilder.append("\n</ETC-DATA>");
		
		log.debug("########### EsmCoa0072ViewAdapter ########### [END]");        
	    return strBuilder.toString();
    }     
}
