/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmSaq0164ViewAdapter.java
*@FileTitle : VVD Mapping
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.11
*@LastModifier : Choi.M.C
*@LastVersion : 1.0
* 2008-04-04 Y.S.CHOI (CSR No. N200804035819)
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacfmadjustment.event;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

import com.clt.apps.opus.esm.saq.common.common.vo.QuotaConditionVO;
import com.clt.apps.opus.esm.saq.common.common.vo.ReturnVO;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacfmadjustment.vo.SearchMonthlyQtaEditListVO;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.ViewAdapter;
import com.clt.framework.core.layer.event.EventResponse;

/**
 * 기본 IBSheet XML 생성<br>
 * - IBSheet로 반환할 서버처리결과를 XML로 변환하는 클래스이다.<br>
 * 
 * @author ChoiI.M.C
 * @see ViewAdapter 참조
 * @since J2EE 1.5
 */
public class EsmSaq0164ViewAdapter extends ViewAdapter {

	public EsmSaq0164ViewAdapter() {
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
	@SuppressWarnings("unchecked")
	@Override
	protected String makeDataTag(List<AbstractValueObject> vos, String prefix) {
		// TODO Auto-generated method stub
		StringBuilder sbufXML = new StringBuilder();
		
		ReturnVO listVO = (ReturnVO)vos.get(0);
		QuotaConditionVO conditionVO = listVO.getConditionVO();
		
		if(conditionVO.getChkCommand().equals("SEARCHLIST")){
			
			StringBuffer rlaneCds = new StringBuffer();
			StringBuffer bsaCds = new StringBuffer();
			String sub_trd_cd = null;
			String pre_sub_trd_cd = "";
			String rlane_cd = null;		
			String fnl_bsa_capa = null;
			String str_fnl_bsa_capa = null;
			TreeMap tmap = new TreeMap();
			Set set = null;
			Iterator iter = null;
			
			List<SearchMonthlyQtaEditListVO> list1 =  (List<SearchMonthlyQtaEditListVO>) listVO.getList(0);
			int totCnt = list1.size();
			
			//sbufXML.append("<SHEET>\n");
			sbufXML.append("<DATA>\n");
			
			for(int j=0; j<totCnt; j++){

				SearchMonthlyQtaEditListVO colValues = list1.get(j);
				
				sub_trd_cd = colValues.getSubTrdCd();
				rlane_cd = colValues.getRlaneCd();
				// filter 에 필요한 항목 리스트 작성
				if(rlaneCds.indexOf(rlane_cd) < 0){
					if( !pre_sub_trd_cd.equals(sub_trd_cd) ){
						if( pre_sub_trd_cd.length() != 0 ){
							rlaneCds.append("&");
						}
						rlaneCds.append(sub_trd_cd).append(";");
					}
					pre_sub_trd_cd = sub_trd_cd;						
					rlaneCds.append(rlane_cd).append("|");
				}
				fnl_bsa_capa = colValues.getFnlBsaCapa();
				str_fnl_bsa_capa = colValues.getStrFnlBsaCapa();
				if(tmap.get(str_fnl_bsa_capa) == null ){
					tmap.put(str_fnl_bsa_capa,"1");//JSPUtil.formatCurrency(fnl_bsa_capa));
				}
				
				
				sbufXML.append("<TR>");
				sbufXML.append("<TD>"+colValues.getTrdCd()+"</TD>");
				sbufXML.append("<TD>"+colValues.getDirCd()+"</TD>");
				sbufXML.append("<TD>"+colValues.getSubTrdCd()+"</TD>");
				sbufXML.append("<TD>"+colValues.getRlaneCd()+"</TD>");
				sbufXML.append("<TD>"+colValues.getSprtGrpCd()+colValues.getBsaGrpCd()+"</TD>");
				sbufXML.append("<TD>"+conditionVO.getYear()+"</TD>");
				sbufXML.append("<TD>"+colValues.getBseMon()+"</TD>");
				sbufXML.append("<TD>"+colValues.getBseWk()+"</TD>");
				sbufXML.append("<TD>"+colValues.getVslCd()+colValues.getSkdVoyNo()+colValues.getSkdDirCd()+"</TD>");
				sbufXML.append("<TD>"+Integer.parseInt(colValues.getFnlBsaCapa())/Integer.parseInt(conditionVO.getUnit())+"</TD>");
				sbufXML.append("<TD>"+colValues.getFnlBsaCapa()+"</TD>");
				sbufXML.append("<TD>N</TD>");
				sbufXML.append("<TD>"+colValues.getSprtGrpCd()+"</TD>");
				sbufXML.append("<TD>"+colValues.getBsaGrpCd()+"</TD>");
				sbufXML.append("<TD>"+colValues.getSprtGrpCd()+"</TD>");
				sbufXML.append("<TD>"+colValues.getBsaGrpCd()+"</TD>");
				sbufXML.append("<TD>"+colValues.getSprtGrpCd()+"</TD>");
				sbufXML.append("<TD>"+colValues.getBsaGrpCd()+"</TD>");
				sbufXML.append("<TD>"+conditionVO.getYear()+"</TD>");
				sbufXML.append("<TD>"+conditionVO.getQuarter()+"</TD>");
				
				sbufXML.append("<TD>"+colValues.getVslCd()+"</TD>");
				sbufXML.append("<TD>"+colValues.getSkdVoyNo()+"</TD>");
				sbufXML.append("<TD>"+colValues.getSkdDirCd()+"</TD>");
				sbufXML.append("<TD>"+colValues.getLstLodgPortEtdDt()+"</TD>");
				
				sbufXML.append("<TD>"+colValues.getIocCd()+"</TD>");
				sbufXML.append("<TD>"+colValues.getVvdSeq()+"</TD>");
				sbufXML.append("<TD>"+colValues.getIbflag()+"</TD>");
				sbufXML.append("<TD>"+colValues.getSubTrdCd()+colValues.getRlaneCd()+conditionVO.getYear()+colValues.getBseMon()+colValues.getBseWk()+colValues.getVslCd()+colValues.getSkdVoyNo()+colValues.getSkdDirCd()+"</TD>");
				sbufXML.append("<TD></TD>");
				sbufXML.append("<TD>"+colValues.getSubTrdCd()+colValues.getRlaneCd()+conditionVO.getYear()+colValues.getBseMon()+colValues.getBseWk()+"</TD>");
				sbufXML.append("</TR>\n");
				
				
				set = tmap.keySet();
				iter = set.iterator();
				bsaCds.setLength(0);
				
				while(iter.hasNext()){
					//bsaCds.append(JSPUtil.formatCurrency((String)i.next())).append("|");
					String key = (String)iter.next();
					String value = (String)tmap.get(key);
					bsaCds.append(value).append("|");
				}
				
			}
			sbufXML.append("</DATA>\n");
			
			sbufXML.append("<ETC-DATA>\n");
			sbufXML.append("<ETC KEY=\"status\">OK</ETC>\n");
			sbufXML.append("<ETC KEY=\"LANE\"><![CDATA["+rlaneCds.toString()+"]]></ETC>\n");
			sbufXML.append("<ETC KEY=\"BSA\"><![CDATA["+bsaCds.toString()+"]]></ETC>\n");
			sbufXML.append("</ETC-DATA>\n");
			
			sbufXML.append("</SHEET>+\n");
			
			
			List<SearchMonthlyQtaEditListVO> list2=  (List<SearchMonthlyQtaEditListVO>) listVO.getList(1);
			int totCnt2 = list2.size();
			pre_sub_trd_cd = "";
			
			sbufXML.append("<SHEET>\n");
			sbufXML.append("<DATA>\n");
			
			for(int j=0; j<totCnt2; j++){

				SearchMonthlyQtaEditListVO colValues = list2.get(j);
				
				sub_trd_cd = colValues.getSubTrdCd();
				rlane_cd = colValues.getRlaneCd();
				// filter 에 필요한 항목 리스트 작성
				if(rlaneCds.indexOf(rlane_cd) < 0){
					if( !pre_sub_trd_cd.equals(sub_trd_cd) ){
						if( pre_sub_trd_cd.length() != 0 ){
							rlaneCds.append("&");
						}
						rlaneCds.append(sub_trd_cd).append(";");
					}
					pre_sub_trd_cd = sub_trd_cd;
					rlaneCds.append(rlane_cd).append("|");
				}
				fnl_bsa_capa = colValues.getFnlBsaCapa();
				str_fnl_bsa_capa = colValues.getStrFnlBsaCapa();
				if(tmap.get(str_fnl_bsa_capa) == null ){
					tmap.put(str_fnl_bsa_capa,JSPUtil.formatCurrency(fnl_bsa_capa));
				}
				
				sbufXML.append("<TR>");
				sbufXML.append("<TD></TD>");
				sbufXML.append("<TD>"+colValues.getTrdCd()+"</TD>");
				sbufXML.append("<TD>"+colValues.getDirCd()+"</TD>");
				sbufXML.append("<TD>"+colValues.getSubTrdCd()+"</TD>");
				sbufXML.append("<TD>"+colValues.getRlaneCd()+"</TD>");
				
				sbufXML.append("<TD BGCOLOR='255, 255, 255'></TD>");
				sbufXML.append("<TD BGCOLOR='255, 255, 255'></TD>");
				sbufXML.append("<TD BGCOLOR='255, 255, 255'></TD>");
				sbufXML.append("<TD BGCOLOR='255, 255, 255'></TD>");
				sbufXML.append("<TD BGCOLOR='255, 255, 255'></TD>");
				
				sbufXML.append("<TD BGCOLOR='255, 255, 255'></TD>");
				sbufXML.append("<TD BGCOLOR='255, 255, 255'></TD>");
				sbufXML.append("<TD BGCOLOR='255, 255, 255'></TD>");
				sbufXML.append("<TD BGCOLOR='255, 255, 255'></TD>");
				
				sbufXML.append("<TD></TD>");
				sbufXML.append("<TD></TD>");
				
				sbufXML.append("<TD>"+colValues.getBseMon()+"</TD>");
				sbufXML.append("<TD>"+colValues.getBseWk()+"</TD>");
				sbufXML.append("<TD>"+colValues.getVslCd()+colValues.getSkdVoyNo()+colValues.getSkdDirCd()+"</TD>");
				sbufXML.append("<TD>"+Integer.parseInt(colValues.getFnlBsaCapa())/Integer.parseInt(conditionVO.getUnit())+"</TD>");
				sbufXML.append("<TD>"+colValues.getFnlBsaCapa()+"</TD>");
				
				sbufXML.append("<TD>"+colValues.getSprtGrpCd()+"</TD>");
				sbufXML.append("<TD>"+colValues.getBsaGrpCd()+"</TD>");
				sbufXML.append("<TD>"+colValues.getGrpMax()+"</TD>");
				sbufXML.append("<TD>"+conditionVO.getYear()+"</TD>");
				sbufXML.append("<TD>"+conditionVO.getQuarter()+"</TD>");
				
				sbufXML.append("<TD>"+colValues.getVslCd()+"</TD>");
				sbufXML.append("<TD>"+colValues.getSkdVoyNo()+"</TD>");
				sbufXML.append("<TD>"+colValues.getSkdDirCd()+"</TD>");
				sbufXML.append("<TD>"+conditionVO.getYear()+"</TD>");
				sbufXML.append("<TD>"+colValues.getEtdDt()+"</TD>");
				
				sbufXML.append("<TD>"+colValues.getIocCd()+"</TD>");
				sbufXML.append("<TD>"+colValues.getVvdSeq()+"</TD>");
				sbufXML.append("<TD>I</TD>");
				sbufXML.append("<TD></TD>");
				sbufXML.append("<TD>"+colValues.getSubTrdCd()+colValues.getRlaneCd()+conditionVO.getYear()+colValues.getBseMon()+colValues.getBseWk()+colValues.getVslCd()+colValues.getSkdVoyNo()+colValues.getSkdDirCd()+"</TD>");
				sbufXML.append("<TD>"+colValues.getSubTrdCd()+colValues.getRlaneCd()+conditionVO.getYear()+colValues.getBseMon()+colValues.getBseWk()+"</TD>");
				sbufXML.append("<TD></TD>");
				sbufXML.append("</TR>\n");
				
			}
			sbufXML.append("</DATA>\n");
			
			sbufXML.append("<ETC-DATA>\n");
			sbufXML.append("<ETC KEY=\"status\">OK</ETC>\n");
			sbufXML.append("<ETC KEY=\"LANE\"><![CDATA["+rlaneCds.toString()+"]]></ETC>\n");
			sbufXML.append("<ETC KEY=\"BSA\"><![CDATA["+bsaCds.toString()+"]]></ETC>\n");
			sbufXML.append("</ETC-DATA>\n");
			
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
				while(it.hasNext()) {
					String key = (String)it.next();
					String val = "" + etc_data.get(key); 
					sb.append("<ETC KEY='" + key + "'><![CDATA[" + val + "]]></ETC>\n");
					
				} 
			}

			sb.append("</ETC-DATA>\n"); 
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
