/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmSpc0026ViewAdapter.java
*@FileTitle : Allocation History
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.30
*@LastModifier : 주선영
*@LastVersion : 1.0
* 2009.10.30 주선영
* 1.0 Creation
* 2010.07.02 Lee Sang-Yong : [프로젝트] Ticket ID : CHM-201004171 53ft 추가 
* 2013.01.23 [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진 
=========================================================*/
package com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.event;

import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.ComplexMainVO;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlInquiryListVO;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.controller.ViewAdapter;

/**
 * 기본 IBSheet XML 생성<br>
 * - IBSheet로 반환할 서버처리결과를 XML로 변환하는 클래스이다.<br>
 * 
 * @author 한상훈
 * @see ViewAdapter 참조
 * @since J2EE 1.5
 */
public class EsmSpc0026ViewAdapter extends ViewAdapter{
	
	
	/**
	 * VO List를 Parsing하여 <Data>태그 부분의 XML문자열을 반환한다.<br>
	 * 
	 * @param vos List<AbstractValueObject> List 객체
	 * @param colOrder String[] Column명 문자열 
	 * @param prefix String IBSheet savename's prefix
	 * @return String <Data>태그 부분의 XML문자열
	 * @exception 
	 */	
	protected String makeDataTag(List<AbstractValueObject> vos, String prefix) 
	{
		StringBuilder sbufXML = new StringBuilder();
		ComplexMainVO complexMainVO = (ComplexMainVO)vos.get(0);
		
		List<SearchSpaceControlInquiryListVO> voList = complexMainVO.getSearchSpaceControlInquiryListVO();
		
		int totCnt  = voList.size();
		int realCnt = voList.size();
		
		if( complexMainVO.getEventCommand().equals("SEARCHLIST02")){	//2.1
				
			int lvl = 1;
			//int treeLvl = 0;
			String pol_yd_cd, pod_yd_cd;
			String vOffice = "";
			String controlPort = "";
			//String[] lvl_cds = {"", "O", "L", "D"};
			int lvl1Row = 0;
			int lvl2Row = 0;

			sbufXML.append("<DATA TOTAL='" + totCnt + "'>\n");
			
	
  		   for(int i=0;i<realCnt;i++){

				Map<String, String> colValues = voList.get(i).getColumnValues();
				
				pol_yd_cd = colValues.get("pol_yd_cd");
				pod_yd_cd = colValues.get("pod_yd_cd");
				
				
				if(pol_yd_cd.length()==7 &&  "00".equals(pol_yd_cd.substring(5))){
					pol_yd_cd = pol_yd_cd.substring(0,5);
				}

				if(pod_yd_cd.length()==7 &&  "00".equals(pod_yd_cd.substring(5))){
					pod_yd_cd = pod_yd_cd.substring(0,5);
				}
								
				lvl = Integer.parseInt(getNull(colValues.get("lvl")));
				
				
				vOffice = colValues.get("sls_ofc_cd");
				if("NULL".equals(vOffice)){
					vOffice = "";
				}
				if(lvl == 1){
					lvl1Row = -1;
				}
				if(lvl == 2){
					lvl2Row = -1;
				}
	
				lvl1Row = lvl1Row + 1;
				lvl2Row = lvl2Row + 1;
						
				sbufXML.append("<TR LEVEL='" + lvl + "'>\n");
	            sbufXML.append("<TD>" + colValues.get("aloc_gdt") + "</TD>");
	            sbufXML.append("<TD>" + colValues.get("user_nm")  + "</TD>");
	 			
	            if(lvl == 0){
				    sbufXML.append("<TD></TD>");
				    sbufXML.append("<TD></TD>");
				    sbufXML.append("<TD></TD>");
				    sbufXML.append("<TD></TD>");
				    sbufXML.append("<TD></TD>");
				    sbufXML.append("<TD></TD>");
				    sbufXML.append("<TD></TD>");
	            } else {
	            	sbufXML.append("<TD>" + ((lvl<1)?(""):vOffice) + "</TD>");
	            	sbufXML.append("<TD>" + ((lvl<1)?(""):colValues.get("acct_grp")) + "</TD>");
	            	sbufXML.append("<TD>"+colValues.get("usa_bkg_mod_cd")+"</TD>"); //Local/IPI(US MOD)
	            	sbufXML.append("<TD>"+colValues.get("cust_acct")+"</TD>"); //Account Code
	            	sbufXML.append("<TD>"+colValues.get("cust_lgl_eng_nm")+"</TD>"); //Account Name
	            	sbufXML.append("<TD>" + ((lvl<1)?(""):((lvl==1)?("LD".indexOf(controlPort)>=0?"-":"+"):pol_yd_cd)) + "</TD>");
	            	sbufXML.append("<TD>" + ((lvl<=1)?(""):((lvl==2)?("D".indexOf(controlPort)>=0?"-":"+"):pod_yd_cd)) + "</TD>");
	           }		
				
	            sbufXML.append("<TD>" + colValues.get("dest_loc_cd")		 + "</TD>"); //Dest
	            sbufXML.append("<TD>" + colValues.get("aloc_lod_qty")        + "</TD>");
	            sbufXML.append("<TD>" + colValues.get("aloc_20ft_dry_qty")    + "</TD>");//add
	            sbufXML.append("<TD>" + colValues.get("aloc_40ft_dry_qty")    + "</TD>");//add
	            sbufXML.append("<TD>" + colValues.get("aloc_40ft_hc_qty")    + "</TD>");
	            sbufXML.append("<TD>" + colValues.get("aloc_45ft_hc_qty")    + "</TD>");
	            sbufXML.append("<TD>" + colValues.get("aloc_53ft_qty")       + "</TD>");
	            sbufXML.append("<TD>" + colValues.get("aloc_rf_qty")         + "</TD>");
	            sbufXML.append("<TD>" + colValues.get("aloc_rd_qty")         + "</TD>");//add
	            sbufXML.append("<TD>" + colValues.get("aloc_ttl_wgt")        + "</TD>");
	            sbufXML.append("<TD>" + colValues.get("fcast_ttl_teu_qty")   + "</TD>");
	            sbufXML.append("<TD>" + colValues.get("fcast_ttl_qty")       + "</TD>");
	            sbufXML.append("<TD>" + colValues.get("fcast_20ft_dry_qty")   + "</TD>");//add
	            sbufXML.append("<TD>" + colValues.get("fcast_40ft_dry_qty")   + "</TD>");//add
	            sbufXML.append("<TD>" + colValues.get("fcast_40ft_hc_qty")   + "</TD>");
	            sbufXML.append("<TD>" + colValues.get("fcast_45ft_hc_qty")   + "</TD>");
	            sbufXML.append("<TD>" + colValues.get("fcast_53ft_qty")      + "</TD>");
	            sbufXML.append("<TD>" + colValues.get("fcast_rf_qty")        + "</TD>");
	            sbufXML.append("<TD>" + colValues.get("fcast_rd_qty")        + "</TD>");//add
	            sbufXML.append("<TD>" + colValues.get("fcast_ttl_wgt")       + "</TD>");
	            sbufXML.append("<TD>" + colValues.get("usd_bkg_ttl_qty")     + "</TD>");
	            sbufXML.append("<TD>" + colValues.get("usd_bkg_20ft_dry_qty")    + "</TD>");//add
	            sbufXML.append("<TD>" + colValues.get("usd_bkg_20ft_qty")    + "</TD>");
	            sbufXML.append("<TD>" + colValues.get("usd_bkg_40ft_dry_qty")    + "</TD>");//add
	            sbufXML.append("<TD>" + colValues.get("usd_bkg_40ft_qty")    + "</TD>");
	            sbufXML.append("<TD>" + colValues.get("usd_bkg_40ft_hc_qty") + "</TD>");
	            sbufXML.append("<TD>" + colValues.get("usd_bkg_45ft_hc_qty") + "</TD>");
	            sbufXML.append("<TD>" + colValues.get("usd_bkg_53ft_qty")    + "</TD>");
	            sbufXML.append("<TD>" + colValues.get("usd_bkg_rf_qty")      + "</TD>");
	            sbufXML.append("<TD>" + colValues.get("usd_bkg_rd_qty")      + "</TD>");//add
	            sbufXML.append("<TD>" + colValues.get("usd_bkg_ttl_wgt")     + "</TD>");
	            sbufXML.append("<TD>" + colValues.get("ctrt_fcast_ttl_teu_qty")   + "</TD>");
	            sbufXML.append("<TD>" + colValues.get("ctrt_fcast_ttl_qty")       + "</TD>");
	            sbufXML.append("<TD>" + colValues.get("ctrt_fcast_40ft_hc_qty")   + "</TD>");
	            sbufXML.append("<TD>" + colValues.get("ctrt_fcast_45ft_hc_qty")   + "</TD>");
	            sbufXML.append("<TD>" + colValues.get("ctrt_fcast_53ft_qty")      + "</TD>");
	            sbufXML.append("<TD>" + colValues.get("ctrt_fcast_rf_qty")        + "</TD>");
	            sbufXML.append("<TD>" + colValues.get("ctrt_fcast_ttl_wgt")       + "</TD>");
	            sbufXML.append("<TD>" + colValues.get("lvl")                 + "</TD>");
			    sbufXML.append("<TD></TD>");
	        
				sbufXML.append("</TR>\n");
				
				
					
			}//For End	

			sbufXML.append("</DATA>\n");
	
 	    }//if End

		
		return sbufXML.toString();
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