/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmCoa0153ViewAdapter.java
*@FileTitle : Pre CM/OP Simulation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.15
*@LastModifier : 송호진
*@LastVersion : 1.4
* 2009.09.15 송호진
* 1.0 Creation
* 2011.12.21 최윤성 [CHM-201115260-01] [COA] Pre CM/OP Simulation화면 U.I 변경요청 - avgLvlChk 필드 추가
=========================================================*/
package com.hanjin.apps.alps.esm.coa.multidimensionrpt.precmsimulation.event;

import java.util.List;

import com.hanjin.apps.alps.esm.coa.common.Utils;
import com.hanjin.apps.alps.esm.coa.common.vo.CommonCoaRsVO;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.DefaultViewAdapter;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.precmsimulation.vo.SearchCondition0153VO;;


/**
 * ESM_COA_0153 에 대한 ViewAdapter<br>
 * -  ESM_COA_0153HTMLAction에서 작성<br>
 *
 * @author Song Ho Jin
 * @see ESM_COA_0153HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmCoa0153ViewAdapter extends DefaultViewAdapter {

    public EsmCoa0153ViewAdapter(){
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
    	
        //##############################################################
    	CommonCoaRsVO vo = (CommonCoaRsVO)list.get(0);
    	//##############################################################
    	
    	String	eventName = "";
		String f_cob_profit_lv = "";

    	DBRowSet rowSet = vo.getDbRowset();
    	eventName = vo.getEventName();
    	
    	int totCnt = rowSet.getRowCount();

    	StringBuilder strBuilder = new StringBuilder();
	    strBuilder.append("<DATA TOTAL=\""+totCnt+"\">");
	    
	    if ( "GS".equals(eventName) ) {
		    if(totCnt > 0){
		    	try{
		    		if(totCnt > 0) {
			    		while(rowSet.next()){
			            	strBuilder.append("<TR><TD></TD>");
			            	String comStr = JSPUtil.getNull(rowSet.getString("remark"));
			            	if(comStr.length() == 1) {
			            		strBuilder.append("<TD>1</TD><TD>" + comStr + "</TD>" ); 
			            	}  else {
			            		strBuilder.append("<TD></TD><TD></TD>" ); 
			            	}
			            			
			            	strBuilder.append("<TD><![CDATA[" + JSPUtil.getNull(rowSet.getString("rout_flag")) + "]]> </TD>" );
			            	strBuilder.append("<TD><![CDATA[" + JSPUtil.getNull(rowSet.getString("por_cd")) + "]]></TD>" );
			            	strBuilder.append("<TD><![CDATA[" + JSPUtil.getNull(rowSet.getString("ob_itchg_ctnt")) + "]]></TD>" );
			            	strBuilder.append("<TD><![CDATA[" + JSPUtil.getNull(rowSet.getString("pol_cd")) + "]]></TD>" );
			            	strBuilder.append("<TD><![CDATA[" + JSPUtil.getNull(rowSet.getString("ts_route")) + "]]></TD>" );
			            	strBuilder.append("<TD><![CDATA[" + JSPUtil.getNull(rowSet.getString("pod_cd")) + "]]></TD>" );
			            	strBuilder.append("<TD><![CDATA[" + JSPUtil.getNull(rowSet.getString("ib_itchg_ctnt")) + "]]></TD>" );
			            	strBuilder.append("<TD><![CDATA[" + JSPUtil.getNull(rowSet.getString("del_cd")) + "]]></TD>");
			            	strBuilder.append("<TD><![CDATA[" + JSPUtil.getNull(rowSet.getString("mty_rtn_yd_cd")) + "]]></TD>");
			            	
			            	strBuilder.append("<TD><![CDATA[" + JSPUtil.getNull(rowSet.getString("ttl_tztm_hrs")) + "]]></TD>");
			            	strBuilder.append("<TD><![CDATA[" + JSPUtil.getNull(rowSet.getString("pctl_no")) + "]]></TD>" );
			            	strBuilder.append("<TD><![CDATA[" + JSPUtil.getNull(rowSet.getString("rout_cnst_seq")) + "]]> </TD>" );		
			            	strBuilder.append("<TD><![CDATA[" + JSPUtil.getNull(rowSet.getString("trnk_lane")) + "]]> </TD>" );
		                    strBuilder.append("</TR>");
		                    strBuilder.append("\n");
			    		}
		    		}	
	            } catch(Exception e){
	            	log.error("err "+e.toString(),e);
	            }
		    }
		    strBuilder.append("</DATA>");
	    }
	    else if ( "GS2".equals(eventName)) {
		    if(totCnt > 0){
		    	try{
			    	int lvl = 0;
					int cost_act_grp_seq = 0;
		
			    	//트리데이터로 가져온다. level과 expand를 세팅해준다.

			    	if (rowSet != null) {
			    		while (rowSet.next()) {
			    			lvl = rowSet.getInt("lvl");
			    			
			    			String slvl = new String ( "" + lvl);
							cost_act_grp_seq = rowSet.getInt("cost_act_grp_seq");

							/*
							strBuilder.append("<TR level='1' >" );
							*/
							
							strBuilder.append("<TR LEVEL='" + Utils.iif(lvl==0, "1", new String("" + slvl) ) + "' " + Utils.iif(lvl<=1, "SUM='FALSE' ", "") + Utils.iif(cost_act_grp_seq>=10, "EXPAND='TRUE' ", "")   );
							if ( lvl == 0 && cost_act_grp_seq < 5 ) {
								strBuilder.append(" BGCOLOR='255,255,180' " );
							} else if ( lvl == 0 ) {
								strBuilder.append(" BGCOLOR='236,231,247' " );
							}
							strBuilder.append(">" );
							strBuilder.append("<TD><![CDATA[" + JSPUtil.getNull(rowSet.getString("nod_cd")) + "]]></TD>" );
							strBuilder.append("<TD><![CDATA[" + JSPUtil.getNull(rowSet.getString("grp")) + "]]></TD>" );
			    			if(lvl==1){
			    				strBuilder.append("<TD><![CDATA[" + JSPUtil.getNull(rowSet.getString("nod_cd"))+ "]]></TD>" );
			    				strBuilder.append("<TD><![CDATA[" + JSPUtil.getNull(rowSet.getString("grp"))+ "]]></TD>" );
			    			} else {
			    				strBuilder.append("<TD></TD>" );
			    				strBuilder.append("<TD></TD>" );
			    			}
			    			if(lvl==1){
			    				strBuilder.append("<TD BGCOLOR='236,231,247'><![CDATA[" + JSPUtil.getNull(rowSet.getString("sgrp_cost_cd_desc"))+ "]]></TD>" );
			    				strBuilder.append("<TD BGCOLOR='236,231,247'><![CDATA[" + JSPUtil.getNull(rowSet.getString("sgrp_cost_cd_desc"))+ "]]></TD>" );
			    			} else {
			    				strBuilder.append("<TD><![CDATA[" + JSPUtil.getNull(rowSet.getString("stnd_cost_nm"))+ "]]></TD>" );
			    				strBuilder.append("<TD><![CDATA[ - " + JSPUtil.getNull(rowSet.getString("stnd_cost_nm"))+ "]]></TD>" );
			    			}
							strBuilder.append("<TD" + Utils.iif(lvl==1, " BGCOLOR='236,231,247'", "") + " ><![CDATA[" + JSPUtil.getNull(rowSet.getString("wtr_rcv_term_cd")) + "]]></TD>" );
							strBuilder.append("<TD" + Utils.iif(lvl==1, " BGCOLOR='236,231,247'", "") + " ><![CDATA[" + JSPUtil.getNull(rowSet.getString("wtr_de_term_cd")) + "]]></TD>" );
							strBuilder.append("<TD" + Utils.iif(lvl==1, " BGCOLOR='236,231,247'", "") + " ><![CDATA[" + JSPUtil.getNull(rowSet.getString("amt")) + "]]></TD>" );
							strBuilder.append("<TD><![CDATA[" + Utils.iif(lvl==0, "2", slvl) + "]]></TD>" );
							strBuilder.append("<TD><![CDATA[" + JSPUtil.getNull(rowSet.getString("avg_lvl_chk"))+ "]]></TD>" );
							strBuilder.append("<TD></TD><TD></TD><TD></TD>" );
			    			strBuilder.append("</TR>" );
			    			strBuilder.append("\n" );

			    		}
			    	}
			    	
			    	SearchCondition0153VO searchCondition0153VO = (SearchCondition0153VO)vo.getConditionVO();
					String f_ofc_lvl = JSPUtil.getNull(searchCondition0153VO.getFOfcLvl());
					String f_cob_profit_vw = JSPUtil.getNull(searchCondition0153VO.getFCobProfitVw()); 
					
					//OP의 경우 BKG OP 표시를 위해
					if("1".equals(f_ofc_lvl) || "2".equals(f_ofc_lvl)) { //HO이거나 RHQ의 경우는 Office Profit에 CM과 OP 모두 적용
						if("P".equals(f_cob_profit_vw)) {
							f_cob_profit_lv = JSPUtil.getNull(searchCondition0153VO.getFCobProfitLv2());  //JSPUtil.getNull(event.getString("cobProfitLv2")); //CM만 표시하느라 cobProfitLv2를 사용했음(Hard Coding)
						} else {
							f_cob_profit_lv = JSPUtil.getNull(searchCondition0153VO.getFCobProfitLv());  //JSPUtil.getNull(event.getString("cobProfitLv"));
						}				
					} else { //나머지는 
						f_cob_profit_lv = JSPUtil.getNull(searchCondition0153VO.getFCobProfitLv());  //JSPUtil.getNull(event.getString("cobProfitLv"));
					}
	            } catch(Exception e){
	            	log.error("err "+e.toString(),e);
	            }
		    }
            strBuilder.append("</DATA>" );
            strBuilder.append("<ETC-DATA>" );
            strBuilder.append("<ETC KEY='bkg_op_visible'>" + Utils.iif ( f_cob_profit_lv.equals("O"),"Y","N") +"</ETC>" );
            strBuilder.append("</ETC-DATA>" );
	    }
	    return strBuilder.toString();
    }    

}
