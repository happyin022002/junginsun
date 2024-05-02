/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmSpc0042Event2.java
*@FileTitle : Allocation Change by VVD
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.17
*@LastModifier : 최윤성
*@LastVersion : 1.0
* 2009.08.17 최윤성
* 1.0 Creation
* 2010.06.23 CHOI.Y.S - [프로젝트] Ticket ID : CHM-201004171
* - [프로젝트] 53FT 관련 필드 추가
* 2011.06.27 Kim jong jun : 소스 품질검토 결과 적용
* 2011.07.20 김민아 [CHM-201112347-01] Control by HO/ RHQ 화면 QTA 및 CMPB 정보 보완 - 조회 필드 QTA CMB 및 CM Per Ton 항목 추가
* 2011.08.08 이행지 [CHM-201112741-01] Control by HO/RHQ 화면 보완 1차 - 주차별 CMB 항목 조회되도록 수정
* 2011.08.16 이행지 [CHM-201112741-01] Control by HO/RHQ 화면 보완 2차 - WAFIE Allocation 항목 색깔 반영되도록 수정
* 2012.01.02 김종준 [CHM-201110709-01] OP/OC/VL  추가
* 2013.01.23 [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
* 2013.08.08 진마리아 [선처리] Allocation 추가요건 - 성수기 ofc별 total 색 추가
* 2014.12.16 신자영 [CHM-201433097] Control Option - A/C 및 CDMT추가 건 상세
* 2015.02.17 Arie Im [CHM-201534437]Control Option Registration 기능 보완 - del all check, 상단 검색조건 추가
*            2014년 Level 추가 당시 IPC일 경우 수정가능하게 하는 부분 수정이 누락되어 323라인 ap_md부분 수정하여 위의 CSR에 포함시켜 반영
* 2015.06.11 김성욱 [CHM-201535211] SPC BKG 연동
* 2015.07.24 Arie [CHM-201537010] Control Option Management 및 VVD별 EDIT기능 보완  - Sync/Desync 빼고 Yield Group, Fixed Edit 추가
* 2016.05.18 최성민 Double Callling Route(Port/Tmnl)에 대한 물량집계 및 병목상 Logic 보완 사항 요청
=========================================================*/ 
package com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.event;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.spc.common.common.vo.ConditionVO;
import com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SearchSpaceAllocation0042DetailListVO;
import com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SpaceAllocationManageVO;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.ViewAdapter;
import com.hanjin.framework.core.layer.event.EventResponse;

/**
 * 기본 IBSheet XML 생성<br>
 * - IBSheet로 반환할 서버처리결과를 XML로 변환하는 클래스이다.<br>
 * 
 * @author CHOI Yun Sung
 * @see ViewAdapter 참조
 * @since CHOI Yun Sung
 */
public class EsmSpc0042ViewAdapter2 extends ViewAdapter {

	/**
	 * VO List를 Parsing하여 <Data>태그 부분의 XML문자열을 반환한다.<br>
	 * 
	 * @param vos List<AbstractValueObject> List 객체
	 * @param colOrder String[] Column명 문자열 
	 * @param prefix String IBSheet savename's prefix
	 * @return String <Data>태그 부분의 XML문자열
	 * @exception 
	 */	
	protected String makeDataTag(List<AbstractValueObject> vos, String prefix) {
		StringBuilder sbufXML = new StringBuilder();
		
		SpaceAllocationManageVO spaceAllocationManageVO = (SpaceAllocationManageVO)vos.get(0);
		ConditionVO conditionVO = spaceAllocationManageVO.getConditionVO();
		List<DBRowSet> dbRowSet = spaceAllocationManageVO.getRsList();
		DBRowSet rowSet1 = dbRowSet.get(0);
		
		List<SearchSpaceAllocation0042DetailListVO> searchSpaceAllocation0042DetailListVOs = spaceAllocationManageVO.getSearchSpaceAllocation0042DetailListVOs();

		/*
		AbstractValueObject vo = (AbstractValueObject)searchSpaceAllocation0042DetailListVOs.get(0);
		
		int totCnt  = searchSpaceAllocation0042DetailListVOs.size();
		int realCnt = searchSpaceAllocation0042DetailListVOs.size();
		*/
		AbstractValueObject vo = null;
		int totCnt = 0;
		int realCnt = 0;
		
		if(!searchSpaceAllocation0042DetailListVOs.isEmpty()){
			vo = (AbstractValueObject)searchSpaceAllocation0042DetailListVOs.get(0);
			

			totCnt  = searchSpaceAllocation0042DetailListVOs.size();
			realCnt = searchSpaceAllocation0042DetailListVOs.size();			

			if(vo.getMaxRows()>0){
				totCnt = vo.getMaxRows();
			}
			
		} 
		
		
		try{
//			String  controlPort = "";
			
//			if(rowSet1 != null && rowSet1.first()){
//				controlPort = rowSet1.getString("pol_pod");
//			}
			
			/*
			if(vo.getMaxRows()>0){
				totCnt = vo.getMaxRows();
			}
			*/
			
			String rlane  = conditionVO.getLane();
			String dir    = conditionVO.getBound();
			String vvd    = conditionVO.getVvd();
			String vsl_cd = vvd.substring(0, 4);
			String voy_no = vvd.substring(4, 8);
			String dir_cd = vvd.substring(8);
			String office = conditionVO.getOffice();
			String officeBGColor = "";
			String acct   = rowSet1.getString("ACCT");
			
			String pol;
//			String pod;
			String oip;
			int lvl     = 0;
			int lvl1Row = 0;
			int lvl2Row = 0;
			int lvl3Row = 0;
			int lvl4Row = 0;
			int lvl5Row = 0;
			String vOffice   = "";
//			String vUsMod   = "";
//			String vAccountCd   = "";
			boolean tsEdit   = true;
			boolean past     = false;
			boolean rowIoc   = false;
			boolean rowDest  = false;
			boolean smpTtl = false;
			
			int rowNum = acct.equals("Y")?5:3;
			int rowOfc = acct.equals("Y")?5:3;
			
			String editRow   = "FALSE";
			String wafColor  = "";
			
			sbufXML.append("<DATA TOTAL='" + totCnt + "'>\n");
			
			for(int i=0;i<realCnt;i++){
				Map<String, String> colValues = searchSpaceAllocation0042DetailListVOs.get(i).getColumnValues();
				
				
					pol     = getNull(colValues.get("pol_cd"));
//					pod     = getNull(colValues.get("pod_cd"));
					lvl     = Integer.parseInt(nullToZero(getNull(colValues.get("lvl"))));
					oip     = getNull(colValues.get("ioc_cd"));
					vOffice = getNull(colValues.get("ofc_cd"));
//					vUsMod = getNull(colValues.get("us_mod"));
//					vAccountCd = getNull(colValues.get("account_cd"));
					if(vOffice.equals("NULL")){
						vOffice = "";
					}
					
					tsEdit  = colValues.get("edit").equals("Y");
					past    = colValues.get("past").equals("Y");
					//기존 POL = local IPI
					if(lvl == 1){
						lvl1Row = -1;
					}
					//기존 POD --> Account
					if(lvl == 2){
						lvl2Row = -1;
					}
					//new POL
					if(lvl == 3){
						lvl3Row = -1;
					}
					//new POD
					if(lvl == 4){
						lvl4Row = -1;
					}
					//new DEL
					if(lvl == 5){
						lvl5Row = -1;
					}
					lvl1Row = lvl1Row + 1;
					lvl2Row = lvl2Row + 1;
					lvl3Row = lvl3Row + 1;
					lvl4Row = lvl4Row + 1;
					lvl5Row = lvl5Row + 1;
					if("Y".equals(acct)){
						rowIoc        = getNull(colValues.get("area_cd")).equals("")&&getNull(colValues.get("del_cd")).equals("+")?true:false;
						rowDest       = getNull(colValues.get("area_cd")).equals("")&&!getNull(colValues.get("del_cd")).equals("+")?true:false;
					}else{
						rowIoc        = getNull(colValues.get("ofc_cd")).equals("+")&&getNull(colValues.get("del_cd")).equals("+")?true:false;
						rowDest       = getNull(colValues.get("ofc_cd")).equals("+")&&!getNull(colValues.get("del_cd")).equals("+")?true:false;
					}
					
					smpTtl     = "Y".equals(acct)&& getNull(colValues.get("cust_ctrl_cd")).equals("+")?true:false;
					if("Y".equals(acct)){
						officeBGColor = smpTtl?"BGCOLOR=\"223,232,247\"":""; //전체 TTL ROW의 경우 Viewadapter와 무관하게 cospc에서 색상처리. 해당 색은 성수기시 ofc별 ttl line
					}else{
						officeBGColor = rowIoc?"BGCOLOR=\"245,250,255\"":"";
					}
					editRow       = String.valueOf(colValues.get("edit").equals("1"));
					
					if( pol.equals("") && (vOffice.equals("HAMRU") || vOffice.equals("NYCRA")) ){
						wafColor = "BGCOLOR=\"194,238,238\"";
					} else {
						wafColor = "";
					}
					
					sbufXML.append("<TR LEVEL='" + lvl+ "' EDIT='" + (editRow.equals("true")?(rowIoc?"FALSE":"TRUE"):editRow) + "'>");
		            sbufXML.append("	<TD>" + oip + "</TD>");
		            
		            sbufXML.append("	<TD INDENT='1'>" + getNull(colValues.get("area_cd")) + "</TD>");
		            sbufXML.append("	<TD INDENT='1' " + wafColor+">" + (vOffice.equals("")?"":(rowIoc?"TTL":(rowDest?"DEST TTL":vOffice))) + "</TD>");
		            if("Y".equals(acct)){
		            	// LVL + 3 기존의 3단계에서 6단계로 추가
		            	sbufXML.append("	<TD " + officeBGColor + (lvl==0?" DATA-TYPE=\"dtImage\"":"") + ">" + (getNull(colValues.get("cust_ctrl_cd")).equals("+")?"1":(getNull(colValues.get("cust_ctrl_cd")).equals("DEST TOTAL")?"":getNull(colValues.get("cust_ctrl_cd")))) + "</TD>");
		            	sbufXML.append("	<TD " + officeBGColor + wafColor + (lvl==1?" DATA-TYPE=\"dtImage\"":"") + ">" + (lvl>=1? getNull(colValues.get("us_mod")).equals("+")?"1":getNull(colValues.get("us_mod")):"") + "</TD>");
		            	sbufXML.append("	<TD " + officeBGColor + wafColor + (lvl==2?" DATA-TYPE=\"dtImage\"":"") + ">" + (lvl>=2? getNull(colValues.get("account_cd")).equals("+")?"1":getNull(colValues.get("account_cd")):"") + "</TD>");
		            	sbufXML.append("	<TD " + officeBGColor + wafColor + (lvl==2?" DATA-TYPE=\"dtImage\"":"") + "><![CDATA[" + (lvl>=2? getNull(colValues.get("account_cd")).equals("+")?"1":getNull(colValues.get("account_nm")):"") + "]]></TD>");
		            	sbufXML.append("	<TD " + officeBGColor + wafColor + (lvl==3?" DATA-TYPE=\"dtImage\"":"") + (Integer.parseInt(nullToZero(getNull(colValues.get("pol_skip"))))==1?" COLOR=\"BLUE\"":"") + ">" + (lvl>=3? getNull(colValues.get("pol_cd")).equals("+")?"1":getNull(colValues.get("pol_cd")):"") + "</TD>");
		            	sbufXML.append("	<TD " + officeBGColor + wafColor + (lvl==4?" DATA-TYPE=\"dtImage\"":"") + (Integer.parseInt(nullToZero(getNull(colValues.get("pod_skip"))))==1?" COLOR=\"BLUE\"":"") + ">" + (lvl>=4? getNull(colValues.get("pod_cd")).equals("+")?"1":getNull(colValues.get("pod_cd")):"") + "</TD>");
//		            	sbufXML.append("	<TD " + officeBGColor + wafColor + (lvl==5?" DATA-TYPE=\"dtImage\"":(lvl==6?(getNull(colValues.get("del_cd")).equals("OTHERS")? "":" BOLD='TRUE' COLOR='BLUE'"):"")) + ">" + (lvl>=5? getNull(colValues.get("del_cd")).equals("+")?"1":getNull(colValues.get("del_cd")):"") + "</TD>");
		            	sbufXML.append("	<TD " + officeBGColor + wafColor + (lvl==5?" DATA-TYPE=\"dtImage\"":(lvl==6||lvl==1?(getNull(colValues.get("del_cd")).equals("OTHERS")? "":" BOLD='TRUE' COLOR='BLUE'"):"")) + ">" 
		            						+ (lvl==1?(getNull(colValues.get("cust_ctrl_cd")).equals("DEST TOTAL")?getNull(colValues.get("del_cd")):""):(lvl>=5? getNull(colValues.get("del_cd")).equals("+")?"1":getNull(colValues.get("del_cd")):"")) + "</TD>");
		            	sbufXML.append("	<TD " + officeBGColor + wafColor + "></TD>");
						//sbufXML.append("	<TD BGCOLOR='" + bgColor[color_num] + "' INDENT='1'>" + (lvl1==1?"QTA/Alloc":(lvl1==3&&lvl2==0?"Alloc":(lvl1==3&&lvl2==1?"-":(lvl1==4&&lvl2==1?"CTRT FCST":(lvl2==0 && (lvl1==2 || (lvl1==4 && child>0)))?"-":pol)))) + "</TD>");
		            	//US Mod : 1 Account code : 2  POL 
//						sbufXML.append("	<TD " + officeBGColor + wafColor + ">" + (getNull(colValues.get("us_mod")).equals("+")?"":getNull(colValues.get("us_mod"))) + "</TD>");
//			            sbufXML.append("	<TD " + officeBGColor + wafColor + ">" + (getNull(colValues.get("account_cd")).equals("+")?"":getNull(colValues.get("account_cd"))) + "</TD>");
						//sbufXML.append("	<TD BGCOLOR='" + bgColor[color_num] + "'>" + (lvl1==1?"QTA/Alloc":(lvl1==4&&lvl2==1?"CTRT FCST":(lvl1>=2 && lvl2==2)?"-":pod)) + "</TD>");
		            }else{
		            	sbufXML.append("	<TD INDENT='1'></TD>");
		            	sbufXML.append("	<TD " + officeBGColor + wafColor + (lvl==1?" DATA-TYPE=\"dtImage\"":"") + ">" + (lvl>=1? getNull(colValues.get("us_mod")).equals("+")?"1":getNull(colValues.get("us_mod")):"") + "</TD>");
		            	sbufXML.append("	<TD " + officeBGColor + wafColor + (lvl==2?" DATA-TYPE=\"dtImage\"":"") + ">" + (lvl>=2? getNull(colValues.get("account_cd")).equals("+")?"1":getNull(colValues.get("account_cd")):"") + "</TD>");
		            	sbufXML.append("	<TD " + officeBGColor + wafColor + (lvl==2?" DATA-TYPE=\"dtImage\"":"") + "><![CDATA[" + (lvl>=2? getNull(colValues.get("account_cd")).equals("+")?"1":getNull(colValues.get("account_nm")):"") + "]]></TD>");
		            	sbufXML.append("	<TD " + officeBGColor + wafColor + (lvl==3?" DATA-TYPE=\"dtImage\"":"") + (Integer.parseInt(nullToZero(getNull(colValues.get("pol_skip"))))==1?" COLOR=\"BLUE\"":"") + ">" + (lvl>=3? getNull(colValues.get("pol_cd")).equals("+")?"1":getNull(colValues.get("pol_cd")):"") + "</TD>");
		            	sbufXML.append("	<TD " + officeBGColor + wafColor + (lvl==4?" DATA-TYPE=\"dtImage\"":"") + (Integer.parseInt(nullToZero(getNull(colValues.get("pod_skip"))))==1?" COLOR=\"BLUE\"":"") + ">" + (lvl>=4? getNull(colValues.get("pod_cd")).equals("+")?"1":getNull(colValues.get("pod_cd")):"") + "</TD>");
//		            	sbufXML.append("	<TD " + officeBGColor + wafColor + (lvl==5?" DATA-TYPE=\"dtImage\"":(lvl==6?(getNull(colValues.get("del_cd")).equals("OTHERS")? "":" BOLD='TRUE' COLOR='BLUE'"):"")) + ">" + (lvl>=5? getNull(colValues.get("del_cd")).equals("+")?"1":getNull(colValues.get("del_cd")):"") + "</TD>");
		            	sbufXML.append("	<TD " + officeBGColor + wafColor + (lvl==5?" DATA-TYPE=\"dtImage\"":(lvl==6||lvl==1?(getNull(colValues.get("del_cd")).equals("OTHERS")? "":" BOLD='TRUE' COLOR='BLUE'"):"")) + ">" 
		            			+ (lvl==1?(vOffice.equals("+")&&!getNull(colValues.get("del_cd")).equals("+")?getNull(colValues.get("del_cd")):""):(lvl>=5? getNull(colValues.get("del_cd")).equals("+")?"1":getNull(colValues.get("del_cd")):"")) + "</TD>");
		            	sbufXML.append("	<TD " + officeBGColor + wafColor + "></TD>");
//		            	sbufXML.append("	<TD " + officeBGColor + wafColor + ">" + (getNull(colValues.get("us_mod")).equals("+")?"":getNull(colValues.get("us_mod"))) + "</TD>");
//			            sbufXML.append("	<TD " + officeBGColor + wafColor + ">" + (getNull(colValues.get("account_cd")).equals("+")?"":getNull(colValues.get("account_cd"))) + "</TD>");
//			            sbufXML.append("	<TD " + officeBGColor + wafColor + (Integer.parseInt(nullToZero(getNull(colValues.get("pol_skip"))))==1?" COLOR=\"BLUE\"":"") + (lvl==1?" DATA-TYPE=\"dtImage\"":"") + ">" + (rowIoc&&lvl>=1?"-1":(lvl<1?"":(lvl==1?(Integer.parseInt(nullToZero(getNull(colValues.get("child_cnt"))))>0?("LD".indexOf(controlPort)>=0?"1":"0"):"-1"):pol))) + "</TD>");
//			            sbufXML.append("	<TD " + officeBGColor + wafColor + (Integer.parseInt(nullToZero(getNull(colValues.get("pod_skip"))))==1?" COLOR=\"BLUE\"":"") + (lvl==2?" DATA-TYPE=\"dtImage\"":"") + ">" + (rowIoc?"":(lvl<=1?"":(lvl==2?(Integer.parseInt(nullToZero(getNull(colValues.get("child_cnt"))))>0?("D".indexOf(controlPort)>=0?"1":"0"):"-1"):pod))) + "</TD>");
//			            
////			            sbufXML.append("	<TD " + officeBGColor + wafColor + (Integer.parseInt(nullToZero(getNull(colValues.get("pol_skip"))))==1?" COLOR=\"BLUE\"":"") + (lvl==3?" DATA-TYPE=\"dtImage\"":"") + ">" + (rowIoc&&lvl>=1?"-1":(lvl<3?"":(lvl==3?(Integer.parseInt(nullToZero(getNull(colValues.get("child_cnt"))))>0?("LD".indexOf(controlPort)>=0?"1":"0"):"-1"):pol))) + "</TD>");
////			            sbufXML.append("	<TD " + officeBGColor + wafColor + (Integer.parseInt(nullToZero(getNull(colValues.get("pod_skip"))))==1?" COLOR=\"BLUE\"":"") + (lvl==4?" DATA-TYPE=\"dtImage\"":"") + ">" + (rowIoc?"":(lvl<=3?"":(lvl==4?(Integer.parseInt(nullToZero(getNull(colValues.get("child_cnt"))))>0?("D".indexOf(controlPort)>=0?"1":"0"):"-1"):pod))) + "</TD>");
//			            
//			            sbufXML.append("	<TD " + officeBGColor + wafColor + ">" + (getNull(colValues.get("del_cd")).equals("+")?"":getNull(colValues.get("del_cd")))    + "</TD>");
		            }
		            
		           
		            
		            sbufXML.append("	<TD " + officeBGColor + wafColor + ">" + getNull(colValues.get("bkg_quota"))   + "</TD>");
		            sbufXML.append("	<TD " + officeBGColor + wafColor + ">" + getNull(colValues.get("bkg_qta_cmb")) + "</TD>");
		            sbufXML.append("	<TD " + officeBGColor + wafColor + ">" + getNull(colValues.get("cmb"))         + "</TD>");
		            sbufXML.append("	<TD " + officeBGColor + wafColor + ">" + getNull(colValues.get("cmb_wgt"))     + "</TD>");
		            sbufXML.append("	<TD " + officeBGColor + wafColor + ">0</TD>");
		            
		            sbufXML.append("	<TD " + officeBGColor + wafColor + ((int) Math.round(Float.valueOf(nullToZero(getNull(colValues.get("cmb_trend")))).floatValue())>0?" COLOR=\"0,0,255\"":((int) Math.round(Float.valueOf(nullToZero(getNull(colValues.get("cmb_trend")))).floatValue())<0?" COLOR=\"255,0,0\"":"")) + ">" + getNull(colValues.get("cmb_trend")) + "</TD>");
		            sbufXML.append("	<TD " + officeBGColor + wafColor + ((int) Math.round(Float.valueOf(nullToZero(getNull(colValues.get("cmb_wgt_trend")))).floatValue())>0?" COLOR=\"0,0,255\"":((int) Math.round(Float.valueOf(nullToZero(getNull(colValues.get("cmb_wgt_trend")))).floatValue())<0?" COLOR=\"255,0,0\"":"")) + ">" + getNull(colValues.get("cmb_wgt_trend")) + "</TD>");
		            
		            // Weekly CMB 추가
		            sbufXML.append("	<TD " + officeBGColor + wafColor + ">" + getNull(colValues.get("cmb1"))         + "</TD>");
		            sbufXML.append("	<TD " + officeBGColor + wafColor + ">" + getNull(colValues.get("cmb2"))         + "</TD>");
		            sbufXML.append("	<TD " + officeBGColor + wafColor + ">" + getNull(colValues.get("cmb3"))         + "</TD>");
		            sbufXML.append("	<TD " + officeBGColor + wafColor + ">" + getNull(colValues.get("cmb4"))         + "</TD>");
		            sbufXML.append("	<TD " + officeBGColor + wafColor + ">" + getNull(colValues.get("cmb_wgt1"))     + "</TD>");
		            sbufXML.append("	<TD " + officeBGColor + wafColor + ">" + getNull(colValues.get("cmb_wgt2"))     + "</TD>");
		            sbufXML.append("	<TD " + officeBGColor + wafColor + ">" + getNull(colValues.get("cmb_wgt3"))     + "</TD>");
		            sbufXML.append("	<TD " + officeBGColor + wafColor + ">" + getNull(colValues.get("cmb_wgt4"))     + "</TD>");
		            
		            sbufXML.append("	<TD BGCOLOR=\"223,232,247\">" + getNull(colValues.get("guide"))         + "</TD>");
		            
		            sbufXML.append("	<TD " + officeBGColor + wafColor + " COLOR='" + (past?"BLUE":"") + "'>" + getNull(colValues.get("fc_ttl_teu")) + "</TD>");
		            sbufXML.append("	<TD " + officeBGColor + wafColor + " COLOR='" + (past?"BLUE":"") + "'>" + getNull(colValues.get("fc_teu"))     + "</TD>");
		            sbufXML.append("	<TD " + officeBGColor + wafColor + ">" + getNull(colValues.get("fc_d2"))  + "</TD>");
		            sbufXML.append("	<TD " + officeBGColor + wafColor + ">" + getNull(colValues.get("fc_d4"))  + "</TD>");
		            sbufXML.append("	<TD " + officeBGColor + wafColor + ">" + getNull(colValues.get("fc_hc"))  + "</TD>");
		            sbufXML.append("	<TD " + officeBGColor + wafColor + ">" + getNull(colValues.get("fc_45"))  + "</TD>");
		            sbufXML.append("	<TD " + officeBGColor + wafColor + ">" + getNull(colValues.get("fc_53"))  + "</TD>");
		            sbufXML.append("	<TD " + officeBGColor + wafColor + ">" + getNull(colValues.get("fc_rf"))  + "</TD>");
		            sbufXML.append("	<TD " + officeBGColor + wafColor + ">" + getNull(colValues.get("fc_rd"))  + "</TD>");
		            sbufXML.append("	<TD " + officeBGColor + wafColor + ">" + getNull(colValues.get("fc_wgt")) + "</TD>");

		            sbufXML.append("	<TD " + officeBGColor + wafColor + (editRow.equals("FALSE")?officeBGColor:"") + " COLOR=''>" + getNull(colValues.get("ap_teu")) + "</TD>");
		            sbufXML.append("	<TD " + officeBGColor + wafColor + (editRow.equals("FALSE")?officeBGColor:"") + " COLOR=''>" + getNull(colValues.get("ap_d2"))  + "</TD>");
		            sbufXML.append("	<TD " + officeBGColor + wafColor + (editRow.equals("FALSE")?officeBGColor:"") + " COLOR=''>" + getNull(colValues.get("ap_d4"))  + "</TD>");
		            sbufXML.append("	<TD " + officeBGColor + wafColor + (editRow.equals("FALSE")?officeBGColor:"") + " COLOR=''>" + getNull(colValues.get("ap_hc"))  + "</TD>");
		            sbufXML.append("	<TD " + officeBGColor + wafColor + (editRow.equals("FALSE")?officeBGColor:"") + " COLOR=''>" + getNull(colValues.get("ap_45"))  + "</TD>");
		            sbufXML.append("	<TD " + officeBGColor + wafColor + (editRow.equals("FALSE")?officeBGColor:"") + " COLOR=''>" + getNull(colValues.get("ap_53"))  + "</TD>");
		            sbufXML.append("	<TD " + officeBGColor + wafColor + (editRow.equals("FALSE")?officeBGColor:"") + " COLOR=''>" + getNull(colValues.get("ap_rf"))  + "</TD>");
		            sbufXML.append("	<TD " + officeBGColor + wafColor + (editRow.equals("FALSE")?officeBGColor:"") + " COLOR=''>" + getNull(colValues.get("ap_rd"))  + "</TD>");
		            sbufXML.append("	<TD " + officeBGColor + wafColor + (editRow.equals("FALSE")?officeBGColor:"") + " COLOR=''>" + getNull(colValues.get("ap_wgt")) + "</TD>");
		            
		            // booking 11개
		            sbufXML.append("	<TD " + officeBGColor + wafColor + ">" + getNull(colValues.get("bt_teu")) + "</TD>");
		            sbufXML.append("	<TD " + officeBGColor + wafColor + ">" + getNull(colValues.get("bt_20"))  + "</TD>");
		            sbufXML.append("	<TD " + officeBGColor + wafColor + ">" + getNull(colValues.get("bt_d2"))  + "</TD>");
		            sbufXML.append("	<TD " + officeBGColor + wafColor + ">" + getNull(colValues.get("bt_40"))  + "</TD>");
		            sbufXML.append("	<TD " + officeBGColor + wafColor + ">" + getNull(colValues.get("bt_d4"))  + "</TD>");
		            sbufXML.append("	<TD " + officeBGColor + wafColor + ">" + getNull(colValues.get("bt_hc"))  + "</TD>");
		            sbufXML.append("	<TD " + officeBGColor + wafColor + ">" + getNull(colValues.get("bt_45"))  + "</TD>");
		            sbufXML.append("	<TD " + officeBGColor + wafColor + ">" + getNull(colValues.get("bt_53"))  + "</TD>");
		            sbufXML.append("	<TD " + officeBGColor + wafColor + ">" + getNull(colValues.get("bt_rf"))  + "</TD>");
		            sbufXML.append("	<TD " + officeBGColor + wafColor + ">" + getNull(colValues.get("bt_rd"))  + "</TD>");
		            sbufXML.append("	<TD " + officeBGColor + wafColor + ">" + getNull(colValues.get("bt_wgt")) + "</TD>");
		            sbufXML.append("	<TD " + officeBGColor + wafColor + ">" + getNull(colValues.get("bkg_vol_vgm")) + "</TD>");
		            sbufXML.append("	<TD " + officeBGColor + wafColor + ">" + getNull(colValues.get("bkg_wgt_vgm")) + "</TD>");
		            sbufXML.append("	<TD " + officeBGColor + wafColor + ">" + getNull(colValues.get("cm_op")) + "</TD>");
		            sbufXML.append("	<TD " + officeBGColor + wafColor + ">" + getNull(colValues.get("cm_oc")) + "</TD>");
		            sbufXML.append("	<TD " + officeBGColor + wafColor + ">" + getNull(colValues.get("cm_vl")) + "</TD>");
		            sbufXML.append("	<TD>" + getNull(colValues.get("ap_teu")) + "</TD>");
		            sbufXML.append("	<TD>" + getNull(colValues.get("ap_d2"))  + "</TD>");
		            sbufXML.append("	<TD>" + getNull(colValues.get("ap_d4"))  + "</TD>");
		            sbufXML.append("	<TD>" + getNull(colValues.get("ap_hc"))  + "</TD>");
		            sbufXML.append("	<TD>" + getNull(colValues.get("ap_45"))  + "</TD>");
		            sbufXML.append("	<TD>" + getNull(colValues.get("ap_53"))  + "</TD>");
		            sbufXML.append("	<TD>" + getNull(colValues.get("ap_rf"))  + "</TD>");
		            sbufXML.append("	<TD>" + getNull(colValues.get("ap_rd"))  + "</TD>");
		            sbufXML.append("	<TD>" + getNull(colValues.get("ap_wgt")) + "</TD>");
		            sbufXML.append("	<TD " + officeBGColor + wafColor + ">" + getNull(colValues.get("bs_teu"))  + "</TD>");
		            sbufXML.append("	<TD " + officeBGColor + wafColor + ">" + getNull(colValues.get("bs_wgt")) + "</TD>");
		            sbufXML.append("	<TD>" + (lvl<6?"R":getNull(colValues.get("ap_md")).equals("0")?"I":"R") + "</TD>");//2015.02.17 변경누락 확인하여 수정함
		            sbufXML.append("	<TD></TD>");
		            
		            sbufXML.append("	<TD>" + getNull(colValues.get("rhq_cd")) + "</TD>");
		            sbufXML.append("	<TD>" + rlane  + "</TD>");
		            sbufXML.append("	<TD>" + dir    + "</TD>");
		            sbufXML.append("	<TD>" + vsl_cd + "</TD>");
		            sbufXML.append("	<TD>" + voy_no + "</TD>");
		            sbufXML.append("	<TD>" + dir_cd + "</TD>");
		            sbufXML.append("	<TD>" + (oip.indexOf("T/S")>=0?"Y":"N") + "</TD>");
		            sbufXML.append("	<TD>" + (oip.startsWith("T-")?"Y":"N")  + "</TD>");
		            sbufXML.append("	<TD>" + office  + "</TD>");
		            sbufXML.append("	<TD>" + lvl1Row + "</TD>");
		            sbufXML.append("	<TD>" + lvl2Row + "</TD>");
		            sbufXML.append("	<TD>" + lvl3Row + "</TD>");
		            sbufXML.append("	<TD>" + lvl4Row + "</TD>");
		            sbufXML.append("	<TD>" + lvl5Row + "</TD>");
		            sbufXML.append("	<TD>" + getNull(colValues.get("child_cnt")) + "</TD>");
		            sbufXML.append("	<TD>" + getNull(colValues.get("leaf_cnt"))  + "</TD>");
		            sbufXML.append("	<TD>" + getNull(colValues.get("pod_cnt"))   + "</TD>");
		            
		            if(lvl == 0) {
						rowOfc = rowNum;
					}
					
					rowNum = rowNum + 1; 
		            
		            sbufXML.append("	<TD>" + lvl + "</TD>");
		            sbufXML.append("	<TD>" + (!vOffice.equals("+")&&!tsEdit?"Y":"") + "</TD>");
		            sbufXML.append("	<TD>" + getNull(colValues.get("trd_cd"))       + "</TD>");
		            sbufXML.append("	<TD>" + getNull(colValues.get("sub_trd_cd"))   + "</TD>");
		            sbufXML.append("	<TD>" + rowIoc   + "</TD>");
		            sbufXML.append("	<TD>" + rowDest   + "</TD>");
		            sbufXML.append("	<TD>" + rowOfc   + "</TD>");
		            
		            sbufXML.append("	<TD " + officeBGColor + wafColor+"><![CDATA[" + getNull(colValues.get("spc_ctrl_aloc_rmk"))     + "]]></TD>");
		            sbufXML.append("	<TD " + officeBGColor + wafColor+"><![CDATA[" + getNull(colValues.get("spc_ctrl_aloc_pol_rmk")) + "]]></TD>");
		            sbufXML.append("	<TD " + officeBGColor + wafColor+"><![CDATA[" + getNull(colValues.get("spc_ctrl_aloc_pod_rmk")) + "]]></TD>");
		            sbufXML.append("	<TD " + officeBGColor + wafColor+"></TD> ");
		            sbufXML.append("	<TD " + officeBGColor + wafColor+"></TD> ");
					sbufXML.append("</TR>\n");
				
					
			}
			sbufXML.append("</DATA>\n");
			
		}catch(SQLException ex){
			throw new RuntimeException(ex.getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new RuntimeException(ex.getMessage());
		}
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
	protected String makeDataTag(DBRowSet rs,String prefix) {
		StringBuilder sb = new StringBuilder();
		
		//Pivot Table인 경우 makePivotDataTag 실행하여  return한
		if(rs.isPivot()){
			sb.append(makePivotDataTag(rs));
			return sb.toString();
		}

		String[] realColNms = getColHeader(rs);

		try{
			String[] changedColNms = getChangedColNms(realColNms, prefix);
			
			sb.append("<DATA COLORDER='" + JSPUtil.convertStringArrayToString(changedColNms, "|") + "' COLSEPARATOR='" + DELIMITER + "' TOTAL='" + getRowSetCnt(rs) + "'>\n");
			
			int colCount = realColNms.length;
			
			while (rs.next()) { 
				sb.append("	<TR><![CDATA[");
				for (int j = 1 ; j < colCount ; j++) {
					sb.append(getNull(rs.getObject(j)) + DELIMITER);
				}	
				sb.append(getNull(rs.getObject(colCount))  + "]]></TR>\n");
			}
			sb.append("</DATA>\n");
		}catch(SQLException ex){
			throw new RuntimeException(ex.getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new RuntimeException(ex.getMessage());
		}

		return sb.toString();
	}

	/**
	 * Pivot Table용 Data tag를 생성한다.<br>
	 * 
	 * @param rs			DBRowSet 		VO객체
	 * @return String 	IBSheet 			<DATA>태그
	 * @exception 
	 */
	protected String makePivotDataTag(DBRowSet rs) {
		StringBuilder sb = new StringBuilder();
		int colCnt = 0;
		int rowCnt = rs.getRowCount();
		String[][] arrRowSet = null;

		try{
			colCnt = rs.getMetaData().getColumnCount();
			arrRowSet = new String[rowCnt][colCnt];
			
			int rowIdx = 0;
			while (rs.next()) { 
				for (int j = 1 ; j <= colCnt ; j++) {
					arrRowSet[rowIdx][j-1] = getNull(rs.getObject(j)).toString();
				}
				rowIdx++;
			}
		}catch(SQLException ex){
			log.error(ex.getMessage(),ex);
			throw new RuntimeException(ex.getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new RuntimeException(ex.getMessage());
		}

		
		try{
			sb.append("<DATA COLSEPARATOR='" + DELIMITER + "'>\n");
			if(rowCnt>0){
				for (int coIdx = 0 ;coIdx < colCnt ; coIdx++) {
					sb.append("	<TR><![CDATA[");
					for(int roIdx=0;roIdx < rowCnt-1; roIdx++){
						sb.append(arrRowSet[roIdx][coIdx] + DELIMITER);
					}
					sb.append(arrRowSet[rowCnt-1][coIdx]  + "]]></TR>\n");
				}//end for coIdx
			}//end for roIdx
			sb.append("</DATA>\n");
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new RuntimeException(ex.getMessage());
		}
		return sb.toString();
	}
	/**
	 * nullToZero를 생성한다.<br>
	 * @param rs			String
	 * @return String 	str
	 * @exception 
	 */
	private String nullToZero(String str) {
		if(str == null || str.equals("") )
			str = "0";
		return str;
	}
	/**
	 * getETCData 를 생성한다.<br>
	 * @param eventResponse			EventResponse
	 * @return String 	str
	 * @exception 
	 */
	protected String getETCData(EventResponse eventResponse) {
		StringBuilder sb = new StringBuilder();
		String headerWeek = "";
		
		if(eventResponse==null) 
			return "";
		
		try{
			if(eventResponse.getETCData() != null){				
				headerWeek = eventResponse.getETCData().get("headerWeek");
				if(headerWeek == null) headerWeek = "";
			}
				
			if( !headerWeek.equals("")){
				sb.append("<ETC-DATA>\n");
				sb.append("    <ETC KEY='headerWeek'><![CDATA["+headerWeek+"]]></ETC>\n");
				sb.append("</ETC-DATA>\n");
				return sb.toString();
			}
			if(eventResponse.getRsList() != null) {			
				SpaceAllocationManageVO spaceAllocationManageVO = (SpaceAllocationManageVO)eventResponse.getRsVoList().get(0);
				List<DBRowSet> dbRowSet = spaceAllocationManageVO.getRsList();
				String saqExistFlg = spaceAllocationManageVO.getSaqExistFlg();
				String doubleCallChk = spaceAllocationManageVO.getDoubleCallChk();
				
				DBRowSet rowSet1 = dbRowSet.get(0);
				
				boolean controlVl   = false;
				String  controlPort = "";
				boolean controlHC   = false;
				boolean control45   = false;
				boolean control53   = false;
				boolean controlRF   = false;
				boolean controlWGT  = false;
				boolean acctCtrl    = false;
				boolean controlD2    = false;
				boolean controlD4    = false;
				boolean controlRd    = false;
				boolean controlUSA    = false;
				boolean controlAccount = false;
				boolean controlFixed   = false;
				String ctrl_dest = "";
				String ctrl_dest_lvl = "";
				
				if(rowSet1 != null && rowSet1.next()){
					controlVl   = rowSet1.getString("volume").equals("Y");
					controlPort = rowSet1.getString("pol_pod");
					controlHC   = rowSet1.getString("hc40").equals("Y");
					control45   = rowSet1.getString("hc45").equals("Y");
					control53   = rowSet1.getString("hc53").equals("Y");
					controlRF   = rowSet1.getString("reefer").equals("Y");
					controlWGT  = rowSet1.getString("weight").equals("Y");
					acctCtrl    = rowSet1.getString("acct").equals("Y");             //smp flag
					controlD2   = rowSet1.getString("d2").equals("Y");
					controlD4   = rowSet1.getString("d4").equals("Y");
					controlRd   = rowSet1.getString("rd").equals("Y");
					controlUSA  = rowSet1.getString("usa").equals("Y");
					controlAccount = rowSet1.getString("account").equals("Y");
					ctrl_dest = rowSet1.getString("ctrl_dest");
					ctrl_dest_lvl = rowSet1.getString("ctrl_dest_lvl");	      
					controlFixed = rowSet1.getString("ctrl_fx_rt_flg").equals("Y");   //fixed rate
				}
				
				sb.append("<ETC-DATA>\n");
				sb.append("    <ETC KEY='volume'><![CDATA["   + (controlVl?"Y":"N")  + "]]></ETC>\n");
				sb.append("    <ETC KEY='pol_pod'><![CDATA["  + controlPort          + "]]></ETC>\n");
				sb.append("    <ETC KEY='hc40'><![CDATA["     + (controlHC?"Y":"N")  + "]]></ETC>\n");
				sb.append("    <ETC KEY='hc45'><![CDATA["     + (control45?"Y":"N")  + "]]></ETC>\n");
				sb.append("    <ETC KEY='53ft'><![CDATA["     + (control53?"Y":"N")  + "]]></ETC>\n");
				sb.append("    <ETC KEY='reefer'><![CDATA["   + (controlRF?"Y":"N")  + "]]></ETC>\n");
				sb.append("    <ETC KEY='weight'><![CDATA["   + (controlWGT?"Y":"N") + "]]></ETC>\n");
				sb.append("    <ETC KEY='acctCtrl'><![CDATA[" + (acctCtrl?"Y":"N")   + "]]></ETC>\n");
				sb.append("    <ETC KEY='d2'><![CDATA[" + (controlD2?"Y":"N")   + "]]></ETC>\n");
				sb.append("    <ETC KEY='d4'><![CDATA[" + (controlD4?"Y":"N")   + "]]></ETC>\n");
				sb.append("    <ETC KEY='rd'><![CDATA[" + (controlRd?"Y":"N")   + "]]></ETC>\n");
				sb.append("    <ETC KEY='usa'><![CDATA[" + (controlUSA?"Y":"N")   + "]]></ETC>\n");
				sb.append("    <ETC KEY='account'><![CDATA[" + (controlAccount?"Y":"N")   + "]]></ETC>\n");
				sb.append("    <ETC KEY='saqExistFlg'><![CDATA[" + saqExistFlg + "]]></ETC>\n");
				sb.append("    <ETC KEY='destLocTp'><![CDATA[" + ("N".equals(ctrl_dest)?"":ctrl_dest) + "]]></ETC>\n");
				sb.append("    <ETC KEY='destLvl'><![CDATA[" + ("N".equals(ctrl_dest_lvl)?"":ctrl_dest_lvl) + "]]></ETC>\n");
				sb.append("    <ETC KEY='fixed'><![CDATA[" + (controlFixed?"Y":"N")  + "]]></ETC>\n");
				sb.append("    <ETC KEY='DBL_CALL_CHK'><![CDATA[" + doubleCallChk + "]]></ETC>\n");
				sb.append("</ETC-DATA>\n");
			}
		}catch(SQLException ex){
			throw new RuntimeException(ex.getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new RuntimeException(ex.getMessage());
		}
		return sb.toString();
	} 

}
