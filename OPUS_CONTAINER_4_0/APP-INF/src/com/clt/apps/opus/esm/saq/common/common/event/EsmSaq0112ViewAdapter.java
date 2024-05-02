/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName       : EsmSaq0112ViewAdapter.java
*@FileTitle      : remark
*Open Issues     :
*Change history  :
*@LastModifyDate : 
*@LastModifier   : 
*@LastVersion    : 1.0
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esm.saq.common.common.event;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.clt.apps.opus.esm.saq.common.common.vo.QuotaConditionVO;
import com.clt.apps.opus.esm.saq.common.common.vo.ReturnVO;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.ViewAdapter;
import com.clt.framework.core.layer.event.EventResponse;

/**
 * EsmSsa0112 화면 IBSheet XML 생성<br>
 * - IBSheet로 반환할 서버처리결과를 XML로 변환하는 클래스이다.<br>
 * 
 * @author M.C Choi
 * @see ViewAdapter 참조
 * @since J2EE 1.6
 */

public class EsmSaq0112ViewAdapter extends ViewAdapter {

	public EsmSaq0112ViewAdapter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * VO List를 Parsing하여 <Data>태그 부분의 XML문자열을 반환한다.<br>
	 * 
	 * @param vos List<AbstractValueObject> List 객체
	 * @param colOrder String[] Column명 문자열 
	 * @param prefix String IBSheet savename's prefix
	 * @return String <Data>태그 부분의 XML문자열
	 * @exception 
	 */	

	@Override
	protected String makeDataTag(List<AbstractValueObject> vos, String prefix){
		// TODO Auto-generated method stub
		StringBuilder sbufXML = new StringBuilder();

		ReturnVO listVO = (ReturnVO)vos.get(0);
		DBRowSet rowSet = listVO.getDbRowset();
		QuotaConditionVO quotaConditionVO = (QuotaConditionVO)listVO.getConditionVO();
		
		int totCnt = 0;
		
		try {
			
			if(rowSet != null){
				totCnt = rowSet.getRowCount();	
			}
			
			sbufXML.append("<DATA TOTAL='" + totCnt +"'>\n");
				
			if (quotaConditionVO.getChkCommand().equals("SEARCHLIST01")) {
				
				if (rowSet != null) {
					while (rowSet.next()) {
	
						sbufXML.append("<TR>");
						sbufXML.append("<TD><![CDATA["+getNull(rowSet.getString("mqta_step_cd")) +"]]></TD>\n");
						sbufXML.append("<TD><![CDATA["+getNull(rowSet.getString("bse_yr"      )) +"]]></TD>\n");
						sbufXML.append("<TD><![CDATA["+getNull(rowSet.getString("bse_qtr_cd"  )) +"]]></TD>\n");
						sbufXML.append("<TD><![CDATA["+getNull(rowSet.getString("trd_cd"      )) +"]]></TD>\n");
						sbufXML.append("<TD><![CDATA["+getNull(rowSet.getString("dir_cd"      )) +"]]></TD>\n");
						sbufXML.append("<TD><![CDATA["+getNull(rowSet.getString("mqta_ver_no" )) +"]]></TD>\n");
						sbufXML.append("<TD><![CDATA["+getNull(rowSet.getString("rlane_cd"    )) +"]]></TD>\n");
						sbufXML.append("<TD><![CDATA["+getNull(rowSet.getString("sprt_grp_cd" )) +"]]></TD>\n");
						sbufXML.append("<TD><![CDATA["+getNull(rowSet.getString("bsa_grp_cd"  )) +"]]></TD>\n");
						sbufXML.append("<TD><![CDATA["+getNull(rowSet.getString("ctrt_rhq_cd" )) +"]]></TD>\n");
						sbufXML.append("<TD><![CDATA["+getNull(rowSet.getString("bse_mon"     )) +"]]></TD>\n");
						
						sbufXML.append("<TD></TD>\n");
						
						sbufXML.append("<TD><![CDATA["+getNull(JSPUtil.replaceForHTML(rowSet.getString("subj_ctnt"))) +"]]></TD>\n");
						sbufXML.append("<TD><![CDATA["+getNull(rowSet.getString("cre_ofc_cd" )) +"]]></TD>\n");
						sbufXML.append("<TD><![CDATA["+getNull(JSPUtil.replaceForHTML(rowSet.getString("cmt_ctnt"))) +"]]></TD>\n");
						sbufXML.append("<TD><![CDATA["+getNull(rowSet.getString("rmk_cre_gdt")) +"]]></TD>\n");
						sbufXML.append("<TD><![CDATA["+getNull(rowSet.getString("saq_sts_cd" )) +"]]></TD>\n");
						
						sbufXML.append("<TD>R</TD>\n");
						sbufXML.append("<TD></TD>\n");
						sbufXML.append("<TD></TD>\n");
						sbufXML.append("</TR>");
					}
				}
				sbufXML.append("</DATA>\n");
				
	//			<ETC-DATA>
	//		     <ETC KEY="status">OK</ETC> 
	//		    </ETC-DATA>   	
				
			} else if (quotaConditionVO.getChkCommand().equals("SEARCHLIST02")) {
				
				if (rowSet != null) {
					while (rowSet.next()) {
	
						sbufXML.append("<TR>");
						sbufXML.append("<TD><![CDATA["+rowSet.getString("mqta_step_cd") +"]]></TD>\n");
						sbufXML.append("<TD><![CDATA["+rowSet.getString("bse_yr"      ) +"]]></TD>\n");
						sbufXML.append("<TD><![CDATA["+rowSet.getString("bse_qtr_cd"  ) +"]]></TD>\n");
						sbufXML.append("<TD><![CDATA["+rowSet.getString("trd_cd"      ) +"]]></TD>\n");
						sbufXML.append("<TD><![CDATA["+rowSet.getString("dir_cd"      ) +"]]></TD>\n");
						sbufXML.append("<TD><![CDATA["+rowSet.getString("mqta_ver_no" ) +"]]></TD>\n");
						sbufXML.append("<TD><![CDATA["+rowSet.getString("rlane_cd"    ) +"]]></TD>\n");
						sbufXML.append("<TD><![CDATA["+rowSet.getString("sprt_grp_cd" ) +"]]></TD>\n");
						sbufXML.append("<TD><![CDATA["+rowSet.getString("bsa_grp_cd"  ) +"]]></TD>\n");
						sbufXML.append("<TD></TD>\n");
						sbufXML.append("<TD><![CDATA["+rowSet.getString("bse_mon"     ) +"]]></TD>\n");
				
						sbufXML.append("<TD><![CDATA["+rowSet.getString("ctrt_rgn_ofc_cd") +"]]></TD>\n");
				
						sbufXML.append("<TD><![CDATA["+rowSet.getString("subj_ctnt"   ) +"]]></TD>\n");
						sbufXML.append("<TD><![CDATA["+rowSet.getString("cre_ofc_cd"  ) +"]]></TD>\n");
						sbufXML.append("<TD><![CDATA["+rowSet.getString("cmt_ctnt"    ) +"]]></TD>\n");
						sbufXML.append("<TD><![CDATA["+rowSet.getString("rmk_cre_gdt" ) +"]]></TD>\n");
						sbufXML.append("<TD><![CDATA["+rowSet.getString("saq_sts_cd"  ) +"]]></TD>\n");
				
						sbufXML.append("<TD>R</TD>\n");
						sbufXML.append("</TR>");
					}
				}
				sbufXML.append("</DATA>\n");
				
	//			<ETC-DATA>
	//		     <ETC KEY="status">OK</ETC> 
	//		    </ETC-DATA> 
				
			} else if (quotaConditionVO.getChkCommand().equals("SEARCHLIST03")) {
				
				if (rowSet != null) {
					while (rowSet.next()) {
	
						sbufXML.append("<TR>");
						sbufXML.append("<TD><![CDATA["+rowSet.getString("mqta_step_cd") +"]]></TD>\n");
						sbufXML.append("<TD><![CDATA["+rowSet.getString("bse_yr"      ) +"]]></TD>\n");
						sbufXML.append("<TD><![CDATA["+rowSet.getString("bse_qtr_cd"  ) +"]]></TD>\n");
						sbufXML.append("<TD><![CDATA["+rowSet.getString("trd_cd"      ) +"]]></TD>\n");
						sbufXML.append("<TD><![CDATA["+rowSet.getString("dir_cd"      ) +"]]></TD>\n");
						sbufXML.append("<TD><![CDATA["+rowSet.getString("mqta_ver_no" ) +"]]></TD>\n");
						sbufXML.append("<TD><![CDATA["+rowSet.getString("rlane_cd"    ) +"]]></TD>\n");
						sbufXML.append("<TD><![CDATA["+rowSet.getString("sprt_grp_cd" ) +"]]></TD>\n");
						sbufXML.append("<TD><![CDATA["+rowSet.getString("bsa_grp_cd"  ) +"]]></TD>\n");
						sbufXML.append("<TD></TD>\n");
						sbufXML.append("<TD><![CDATA["+rowSet.getString("bse_mon"     ) +"]]></TD>\n");
			
						sbufXML.append("<TD><![CDATA["+rowSet.getString("sls_rgn_ofc_cd") +"]]></TD>\n");
			
						sbufXML.append("<TD><![CDATA["+rowSet.getString("subj_ctnt"   ) +"]]></TD>\n");
						sbufXML.append("<TD><![CDATA["+rowSet.getString("cre_ofc_cd"  ) +"]]></TD>\n");
						sbufXML.append("<TD><![CDATA["+rowSet.getString("cmt_ctnt"    ) +"]]></TD>\n");
						sbufXML.append("<TD><![CDATA["+rowSet.getString("rmk_cre_gdt" ) +"]]></TD>\n");
						sbufXML.append("<TD><![CDATA["+rowSet.getString("saq_sts_cd"  ) +"]]></TD>\n");
			
						sbufXML.append("<TD>R</TD>\n");
						sbufXML.append("<TD><![CDATA["+rowSet.getString("pol_cd"  ) +"]]></TD>\n");
						sbufXML.append("<TD><![CDATA["+rowSet.getString("pod_cd"  ) +"]]></TD>\n");
						sbufXML.append("</TR>");
					}
				}
				sbufXML.append("</DATA>\n");
						
	//			<ETC-DATA>
	//		     <ETC KEY="status">OK</ETC> 
	//		    </ETC-DATA> 
	
			}
			
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
		}
		
		return sbufXML.toString();
	}
	
	@SuppressWarnings("unchecked")
	protected String getETCData(EventResponse eventResponse) { 
		if(eventResponse==null) 
		return ""; 

		StringBuilder sb = new StringBuilder(); 
		HashMap<String, String> etc_data = (HashMap<String, String>) eventResponse.getETCData();

		sb.append("<ETC-DATA>\n"); 
		if(etc_data !=null && etc_data.size()>0){ 
			Iterator it = etc_data.keySet().iterator(); 
			while(it.hasNext()){ 
				String key = (String)it.next(); 
				String val = "" + etc_data.get(key); 
				sb.append("<ETC KEY=\"" + key + "\"><![CDATA[" + val + "]]></ETC>\n"); 
				
			} 
		}
		
		sb.append("<ETC KEY=\"status\"><![CDATA[OK]]></ETC>\n");
		sb.append("</ETC-DATA>\n");
		sb.append("<TR-ALL>OK</TR-ALL>\n");
		
		//Pivot 관련 ETC-DATA생성 
		sb.append(getPivotETCData(eventResponse)); 
		
		return sb.toString(); 
	}

	/**
	 * DBRowSet를 Parsing하여 <DATA>태그를 생성한다.<br>
	 * IBSheet의 prefix값이 있는 경우 COLORDER에 prefix를 붙인 column명으로 표시해 준다.<br>
	 * 
	 * @param rs DBRowSet 		VO객체
	 * @param prefix String 		IBSheet savename's prefix string
	 * @return String IBSheet 		<DATA>태그
	 * @exception 
	 */
	@Override
	protected String makeDataTag(DBRowSet arg0, String arg1) {
		// TODO Auto-generated method stub
		return null;
	}

}
