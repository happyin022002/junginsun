/*========================================================= 
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmSpc0044ViewAdapter.java
*@FileTitle : spaceallocationmanage
*Open Issues :
*@LastModifyDate : 2009.09.16
*@LastModifier : 한상훈
*@LastVersion : 1.0
* 2009.09.16 한상훈
* 1.0 Creation
*Change history :
* 1.0 
* 2008-02-18 김원섭 CSR : N200801300018 - Alloc 입력화면에서 History data 저장  - Office/POL 레벨 Tree 모양 변경 - Trade/Sub Trade 컬럼 추가
* 2008-02-20 김원섭 CSR : N200802180011   Control Option 적용대상 변경 - row edit 가능 여부 설정 처리 위치 변경. DB에서 생성
* 2008-02-21 김원섭  Source 품질 관련 사항 수정
* 2008-02-28 김원섭 CSR : N200802260009   Load target만 있는 office 조회  - Quota만 있는 행의 Office level의 tree 모양 제거 - Quota만 있는 행의 Office level Edit 불가능 하도록 설정
* 2008-10-14 서관영 CSR : N200810020013 - Allocation Control 2/3차 화면의 remark 기능 추가요청
* 2008-11-14 임옥영 CSR:N200811140010 -Remark 특수문자 처리
* 2008-12-12 CSR:N200812080003 Total TEU 컬럼 추가
* 2010.07.05 CHOI.Y.S - [프로젝트] Ticket ID : CHM-201004171 - [프로젝트] 53FT 관련 필드 추가
* 2011.07.05 이석준 [CHM-20111188] F'Case,Allocation,Bkg의 TS field 추가
* 2013.01.23 [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
* 2013.04.25 진마리아 [CHM-201324211] 프로젝트 안정화 및 HELP DESK - CMB Trend 추가
* 2014.12.16 신자영 [CHM-201433097] Control Option - A/C 및 CDMT추가 건 상세
* 2015.02.17 Arie Im [CHM-201534437]Control Option Registration 기능 보완 - del all check, 상단 검색조건 추가
* 2014년 Level 추가 당시 IPC일 경우 수정가능하게 하는 부분 수정이 누락되어 399라인 ap_md부분 수정하여 위의 CSR에 포함시켜 반영
* 2015.06.11 김성욱 [CHM-201535211] SPC BKG 연동
* 2015.07.24 Arie [CHM-201537010] Control Option Management 및 VVD별 EDIT기능 보완  - Sync/Desync 빼고 Yield Group, Fixed Edit 추가
* 2015.11.19 이혜민 [CHM-201538539] Allocation Control by Main office - Daily FCST Acct 화면 팝업 처리
* 2016.05.18 최성민 Double Callling Route(Port/Tmnl)에 대한 물량집계 및 병목상 Logic 보완 사항 요청
=========================================================*/
package com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.event;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.spc.common.common.vo.ConditionVO;
import com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SearchSpaceAllocation0044DetailListVO;
import com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SearchSpaceAllocation0044MasterListVO;
import com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SpaceAllocationManageVO;
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
public class EsmSpc0044ViewAdapter extends ViewAdapter{
	
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
				
		SpaceAllocationManageVO spaceAllocationManageVO = (SpaceAllocationManageVO)vos.get(0);
		
		int rowCount	 = 0;
		if( spaceAllocationManageVO.getEventCommend().equals("SEARCHLIST01")){	//2.1
			
			List<SearchSpaceAllocation0044MasterListVO> viewList = new ArrayList<SearchSpaceAllocation0044MasterListVO>();
			viewList = spaceAllocationManageVO.getSearchSpaceAllocation0044MasterListVOs();
			
			if(viewList != null) rowCount = viewList.size();
			
			sbufXML.append("<DATA TOTAL=\""+rowCount+"\">\n");		
			if (viewList != null) {//3.1
			
				for(int i=0;i<rowCount;i++){
					sbufXML.append("<TR>\n");
					sbufXML.append("<TD></TD>");
					sbufXML.append("<TD>"+viewList.get(i).getTrdCd()+"</TD>");
					sbufXML.append("<TD>"+viewList.get(i).getSubTrdCd()+"</TD>");
					sbufXML.append("<TD>"+viewList.get(i).getRlaneCd()+"</TD>");
					sbufXML.append("<TD>"+viewList.get(i).getDirCd()+"</TD>");
					sbufXML.append("<TD>"+viewList.get(i).getCostWk()+"</TD>");
					sbufXML.append("<TD>"+viewList.get(i).getVvd()+"</TD>");

					sbufXML.append("<TD>"+viewList.get(i).getAdVol()+"</TD>");
					sbufXML.append("<TD>"+viewList.get(i).getAdWgt()+"</TD>");
					sbufXML.append("<TD>"+viewList.get(i).getTsVol()+"</TD>");
					sbufXML.append("<TD>"+viewList.get(i).getTsWgt()+"</TD>");
											
					sbufXML.append("<TD>"+viewList.get(i).getQtaVol()+"</TD>");	
					sbufXML.append("<TD>"+viewList.get(i).getQtaCmb()+"</TD>");	

					sbufXML.append("<TD>"+viewList.get(i).getFcVol()+"</TD>");
					sbufXML.append("<TD>"+viewList.get(i).getFcWgt()+"</TD>");
					sbufXML.append("<TD>"+viewList.get(i).getFcTsVol()+"</TD>");
					sbufXML.append("<TD>"+viewList.get(i).getFcTsWgt()+"</TD>");
					
					sbufXML.append("<TD>"+viewList.get(i).getApVol()+"</TD>");
					sbufXML.append("<TD>"+viewList.get(i).getApWgt()+"</TD>");
					sbufXML.append("<TD>"+viewList.get(i).getApTsVol()+"</TD>");
					sbufXML.append("<TD>"+viewList.get(i).getApTsWgt()+"</TD>");

					sbufXML.append("<TD>"+viewList.get(i).getBkgVol()+"</TD>");
					sbufXML.append("<TD>"+viewList.get(i).getBkgWgt()+"</TD>");
					sbufXML.append("<TD>"+viewList.get(i).getBkgTsVol()+"</TD>");
					sbufXML.append("<TD>"+viewList.get(i).getBkgTsWgt()+"</TD>");
					
					sbufXML.append("<TD>"+viewList.get(i).getBkgVolVgm()+"</TD>");
					sbufXML.append("<TD>"+viewList.get(i).getBkgWgtVgm()+"</TD>");
					sbufXML.append("<TD>"+viewList.get(i).getBkgTsVolVgm()+"</TD>");
					sbufXML.append("<TD>"+viewList.get(i).getBkgTsWgtVgm()+"</TD>");
					
					sbufXML.append("<TD>"+viewList.get(i).getBkgBsTeu()+"</TD>");
					sbufXML.append("<TD>"+viewList.get(i).getBkgBsWgt()+"</TD>");
					
					sbufXML.append("<TD>"+viewList.get(i).getCmOp()+"</TD>");
					sbufXML.append("<TD>"+viewList.get(i).getCmOc()+"</TD>");
					sbufXML.append("<TD>"+viewList.get(i).getCmVl()+"</TD>");
					
					if ((getNull(viewList.get(i).getTrdCd()).startsWith("I"))){
						sbufXML.append("	<TD CALCU-LOGIC=\"|alloced_vol|+|alloced_ts_vol|-|alloc_vol|-|alloc_ts_vol"+"|\"></TD>");
					} else {
						sbufXML.append("	<TD CALCU-LOGIC=\"|alloced_vol|-|alloc_vol"+"|\"></TD>");				
					}
					sbufXML.append("<TD>"+viewList.get(i).getVslCd()+"</TD>");
					sbufXML.append("<TD>"+viewList.get(i).getSkdVoyNo()+"</TD>");
					sbufXML.append("<TD>"+viewList.get(i).getSkdDirCd()+"</TD>");
					sbufXML.append("<TD>"+viewList.get(i).getCtrlSpcFlg()+"</TD>");
					sbufXML.append("<TD>"+viewList.get(i).getCtrlPortFlg()+"</TD>");
					sbufXML.append("<TD>"+viewList.get(i).getCtrl40ftHcFlg()+"</TD>");
					sbufXML.append("<TD>"+viewList.get(i).getCtrl45ftHcFlg()+"</TD>");
					sbufXML.append("<TD>"+viewList.get(i).getCtrl53ftFlg()+"</TD>");
					sbufXML.append("<TD>"+viewList.get(i).getCtrlRfFlg()+"</TD>");
					sbufXML.append("<TD>"+viewList.get(i).getCtrlWgtFlg()+"</TD>");
					sbufXML.append("<TD>"+viewList.get(i).getAcct()+"</TD>");
					sbufXML.append("<TD>"+viewList.get(i).getCtrlFxRtFlg()+"</TD>");
					sbufXML.append("<TD>"+viewList.get(i).getIbflag()+"</TD>");
					sbufXML.append("<TD></TD>\n");  // ibflag
					sbufXML.append("<TD></TD>\n");  // dataSeq
					sbufXML.append("<TD>Y</TD>\n"); // edit_flg
					sbufXML.append("<TD>Y</TD>\n"); // mnl_flg
					sbufXML.append("<TD></TD>\n");  // 공백
					sbufXML.append("</TR>\n");
			
				}//4.9
			}//3.9
			
			sbufXML.append("</DATA>\n");
	
		}
		else if( spaceAllocationManageVO.getEventCommend().equals("SEARCHLIST02")){	//2.1
			
			List<SearchSpaceAllocation0044DetailListVO> detailList = new ArrayList<SearchSpaceAllocation0044DetailListVO>();
			detailList = spaceAllocationManageVO.getSearchSpaceAllocation0044DetailListVOs();
			if(detailList != null) rowCount = detailList.size();			
			
			ConditionVO conditionVO = spaceAllocationManageVO.getConditionVO();
			List<DBRowSet> dbRowSet = spaceAllocationManageVO.getRsList();
			String doubleCallChk = spaceAllocationManageVO.getDoubleCallChk();

			String modelDt = "";
			DBRowSet rsEtc = dbRowSet.get(0);
			boolean controlVl = false;
			String controlPort = "";
			boolean controlHC = false;
			boolean control45 = false;
			boolean control53 = false;
			boolean controlRF = false;
			boolean controlWGT = false;
			boolean acctCtrl   = false;
			boolean controlD2 = false;
			boolean controlD4 = false;
			boolean controlRd = false;
			boolean controlUSA = false;
			boolean controlAccount = false;
			boolean controlFixed   = false;
			String ctrl_dest = "";
			String ctrl_dest_lvl = "";
			String wafColor = "";
			
			try{
				int rowNum = 3; //rsEtc.getString("ACCT").equals("Y")?5:3;
				int rowOfc = 3; //rsEtc.getString("ACCT").equals("Y")?5:3;
				if(rsEtc != null && rsEtc.first()){
					controlVl =  rsEtc.getString("volume").equals("Y");
					controlPort = rsEtc.getString("pol_pod");
					controlHC = rsEtc.getString("hc40").equals("Y");
					control45 = rsEtc.getString("hc45").equals("Y");
					control53 = rsEtc.getString("hc53").equals("Y");
					controlRF = rsEtc.getString("reefer").equals("Y");
					controlWGT = rsEtc.getString("weight").equals("Y");
					controlD2 = rsEtc.getString("d2").equals("Y");
					controlD4 = rsEtc.getString("d4").equals("Y");
					controlRd = rsEtc.getString("rd").equals("Y");
					acctCtrl = rsEtc.getString("acct").equals("Y");
					controlUSA  = rsEtc.getString("usa").equals("Y");
					controlAccount = rsEtc.getString("account").equals("Y");
					ctrl_dest = rsEtc.getString("ctrl_dest");
					ctrl_dest_lvl = rsEtc.getString("ctrl_dest_lvl");	
					controlFixed = rsEtc.getString("ctrl_fx_rt_flg").equals("Y");   //fixed rate

					rowNum = rsEtc.getString("ACCT").equals("Y")?5:3;
					rowOfc = rsEtc.getString("ACCT").equals("Y")?5:3;
				}
	
//				rsEtc = dbRowSet.get(1);
//				if(rsEtc != null && rsEtc.next()){
//					modelDt = rsEtc.getString("mdl_dt");
//				}
	
//				sbufXML.append("<SHEET>\n");
				sbufXML.append("<DATA TOTAL=\""+rowCount+"\">\n");
			
				String trade = conditionVO.getTrade();
				String subTrade = conditionVO.getSubtrade();
				String rlane = conditionVO.getLane();
				String dir = conditionVO.getBound();
				String vvd = conditionVO.getVvd();
				String vsl_cd = vvd.substring(0, 4);
				String voy_no = vvd.substring(4, 8);
				String dir_cd = vvd.substring(8);
				String office = conditionVO.getOffice();
				String pol, pod;
				String oip;
				int lvl = 0;
				int lvl1Row = 0;
				int lvl2Row = 0;
				int lvl3Row = 0;
				int lvl4Row = 0;
				int lvl5Row = 0;
				String vOffice = "";
				String rhqOffice = "";
				String editColor = "";
				boolean tsEdit = true;
				boolean cfm_flg = false;
				boolean rowIoc = false;
				
//				int rowNum = 3; //rsEtc.getString("ACCT").equals("Y")?5:3;
//				int rowOfc = 3; //rsEtc.getString("ACCT").equals("Y")?5:3;
//				if(rsEtc != null && rsEtc.first()){
//					rowNum = rsEtc.getString("ACCT").equals("Y")?5:3;
//					rowOfc = rsEtc.getString("ACCT").equals("Y")?5:3;
//				}
				String editRow = "FALSE";
				
				for(int i=0;i<rowCount;i++){//while (rowSet.next()) {//4.1
					pol = detailList.get(i).getPolCd();
					pod = detailList.get(i).getPodCd();
					lvl = Integer.parseInt(detailList.get(i).getLvl());
					oip = detailList.get(i).getIocCd();
					vOffice = detailList.get(i).getOfcCd();
					rhqOffice = detailList.get(i).getRhqOfcCd();
					tsEdit = detailList.get(i).getEdit().equals("Y");
					cfm_flg = detailList.get(i).getCfmFlg().equals("Y");
					
					//현재 레벨에 맞는 LEVEL 값은 0 으로 하고 나머지는 1 증가 시킴. 해당 값 변경시 사용됨.
					if(lvl == 1){
						lvl1Row = -1;
					}
					if(lvl == 2){
						lvl2Row = -1;
					}
					if(lvl == 3){
						lvl3Row = -1;
					}
					if(lvl == 4){
						lvl4Row = -1;
					}
					if(lvl == 5){
						lvl5Row = -1;
					}
					lvl1Row = lvl1Row + 1;
					lvl2Row = lvl2Row + 1;
					lvl3Row = lvl3Row + 1;
					lvl4Row = lvl4Row + 1;
					lvl5Row = lvl5Row + 1;
					
					editRow = String.valueOf(detailList.get(i).getEdit().equals("1") && Integer.parseInt(detailList.get(i).getChildCnt()) > 0);
					rowIoc  = vOffice.equals("+")?true:false;
					
//					if( pol.equals("") && (vOffice.equals("HAMRU") || vOffice.equals("NYCRA")) ){
					if(lvl == 0) {
						wafColor = "BGCOLOR=\"223,232,247\"";	//희끄므리한 파란색
					} else {
						wafColor = "";
					}
//					} else {
//						wafColor = "";
//					}
//					if(vOffice.equals("+")){ //SMP sum
//						wafColor = "BGCOLOR=\"223,232,247\"";	
//					    wafColor = "BGCOLOR=\"194,238,238\"";	
//					} else {
//						wafColor = "";
//					}
//					sbufXML.append("<TR LEVEL='"+lvl+"' EDIT='"+editRow+"'>");
					sbufXML.append("<TR LEVEL='"+lvl+"' EDIT='"+(editRow.equals("true")?(rowIoc?"FALSE":"TRUE"):editRow)+"'>");
					sbufXML.append("<TD>"+oip+"</TD>");
					sbufXML.append("<TD>"+rhqOffice+"</TD>");//hidden
					sbufXML.append("<TD INDENT='1'>" + (rowIoc?"TTL":vOffice) + "</TD>");
					//sbufXML.append("<TD " + wafColor + " INDENT='1'>" + (rowIoc?"TTL":vOffice) + "</TD>");
					if(rsEtc.getString("ACCT").equals("Y")){
						sbufXML.append("<TD " +  wafColor  + (lvl==0?" DATA-TYPE=\"dtImage\"":"") + ">" + (getNull(detailList.get(i).getCustCtrlCd()).equals("+")?"1":getNull(detailList.get(i).getCustCtrlCd())) + "</TD>");
					}else{
						sbufXML.append("<TD INDENT='1'></TD>");
					}
					// 2014.07.31 US mod, Account Cd 추가
					sbufXML.append("<TD "  +  wafColor).append((lvl==1)?(detailList.get(i).getOfcCd().equals("+")?"":"  DATA-TYPE=\"dtImage\""):"").append(">").append(detailList.get(i).getOfcCd().equals("+")?"":(lvl>=1?(detailList.get(i).getUsMod().equals("+")?"":detailList.get(i).getUsMod()):"")).append("</TD>");
					sbufXML.append("<TD "  +  wafColor).append((lvl==2)?" DATA-TYPE=\"dtImage\"":"").append(">").append(lvl>=2?(detailList.get(i).getAccountCd().equals("+")?"1":detailList.get(i).getAccountCd()):"").append("</TD>");
					sbufXML.append("<TD "  +  wafColor).append((lvl==2)?" DATA-TYPE=\"dtImage\"":"").append("><![CDATA[").append(lvl>=2?(detailList.get(i).getAccountCd().equals("+")?"1":detailList.get(i).getAccountNm()):"").append("]]></TD>");
					
					
					if(lvl == 0){
					sbufXML.append("<TD " + wafColor + "></TD>");
					sbufXML.append("<TD " + wafColor + "></TD>");
					sbufXML.append("<TD " + wafColor + "></TD>");
					sbufXML.append("<TD " + wafColor + "></TD>");
					}else{
					sbufXML.append("<TD " + wafColor).append((lvl==3)?" DATA-TYPE=\"dtImage\"":"").append(">").append((lvl<3)?(""):(rowIoc&&lvl>=1?"-1":((lvl==3)?( Integer.parseInt(detailList.get(i).getChildCnt()) >0?("LD".indexOf(controlPort)>=0?"1":"0"):"-1"):pol))).append("</TD>");
					sbufXML.append("<TD " + wafColor).append((lvl==4)?" DATA-TYPE=\"dtImage\"":"").append(">").append((lvl<=3)?(""):((lvl==4)?( Integer.parseInt(detailList.get(i).getChildCnt()) >0?("D".indexOf(controlPort)>=0?"1":"0"):"-1"):pod)).append("</TD>");
					// DEL 추가
					sbufXML.append("<TD " + wafColor).append((lvl==5)?" DATA-TYPE=\"dtImage\"":(lvl==6?(getNull(detailList.get(i).getDelCd()).equals("OTHERS")? "":" BOLD='TRUE' COLOR='BLUE'"):"")).append(">").append((lvl<=4)?(""):((lvl==5)?"1":detailList.get(i).getDelCd())).append("</TD>");
					sbufXML.append("<TD " + wafColor + "></TD>");
					}
					
					sbufXML.append("<TD " + wafColor + ">"+detailList.get(i).getBkgQuota()+"</TD>");
					sbufXML.append("<TD " + wafColor + ">"+detailList.get(i).getCmb()+"</TD>");
					sbufXML.append("<TD " + wafColor + ">"+detailList.get(i).getCmbWgt()+"</TD>");
					sbufXML.append("<TD " + wafColor + ">"+detailList.get(i).getFctCmb()+"</TD>");
					
					sbufXML.append("<TD " + wafColor+((int) Math.round(Float.valueOf(nullToZero(getNull(detailList.get(i).getCmbTrend()))).floatValue())>0?" COLOR=\"0,0,255\"":((int) Math.round(Float.valueOf(nullToZero(getNull(detailList.get(i).getCmbTrend()))).floatValue())<0?" COLOR=\"255,0,0\"":"")) + ">" + getNull(detailList.get(i).getCmbTrend()) + "</TD>");
		            sbufXML.append("<TD " + wafColor+((int) Math.round(Float.valueOf(nullToZero(getNull(detailList.get(i).getCmbWgtTrend()))).floatValue())>0?" COLOR=\"0,0,255\"":((int) Math.round(Float.valueOf(nullToZero(getNull(detailList.get(i).getCmbWgtTrend()))).floatValue())<0?" COLOR=\"255,0,0\"":"")) + ">" + getNull(detailList.get(i).getCmbWgtTrend()) + "</TD>");
					sbufXML.append("<TD " + wafColor + ">"+detailList.get(i).getCmb1()+"</TD>");
					sbufXML.append("<TD " + wafColor + ">"+detailList.get(i).getCmb2()+"</TD>");
					sbufXML.append("<TD " + wafColor + ">"+detailList.get(i).getCmb3()+"</TD>");
					sbufXML.append("<TD " + wafColor + ">"+detailList.get(i).getCmb4()+"</TD>");
					sbufXML.append("<TD " + wafColor + ">"+detailList.get(i).getCmbWgt1()+"</TD>");
					sbufXML.append("<TD " + wafColor + ">"+detailList.get(i).getCmbWgt2()+"</TD>");
					sbufXML.append("<TD " + wafColor + ">"+detailList.get(i).getCmbWgt3()+"</TD>");
					sbufXML.append("<TD " + wafColor + ">"+detailList.get(i).getCmbWgt4()+"</TD>");
					sbufXML.append("<TD " + wafColor + ">"+detailList.get(i).getGuide()+"</TD>");

					sbufXML.append("<TD " + wafColor + ">"+detailList.get(i).getFcTtlTeu()+"</TD>");
					sbufXML.append("<TD " + wafColor + ">"+detailList.get(i).getFcTeu()+"</TD>");
					sbufXML.append("<TD " + wafColor + ">"+detailList.get(i).getFcD2()+"</TD>");
					sbufXML.append("<TD " + wafColor + ">"+detailList.get(i).getFcD4()+"</TD>");
					sbufXML.append("<TD " + wafColor + ">"+detailList.get(i).getFcHc()+"</TD>");
					sbufXML.append("<TD " + wafColor + ">"+detailList.get(i).getFc45()+"</TD>");
					sbufXML.append("<TD " + wafColor + ">"+detailList.get(i).getFc53()+"</TD>");
					sbufXML.append("<TD " + wafColor + ">"+detailList.get(i).getFcRf()+"</TD>");
					sbufXML.append("<TD " + wafColor + ">"+detailList.get(i).getFcRd()+"</TD>");
					sbufXML.append("<TD " + wafColor + ">"+detailList.get(i).getFcWgt()+"</TD>");
	
					editColor = !vOffice.equals("+")&&(lvl==1||lvl==2)&&cfm_flg?"BLUE":"";
					
					sbufXML.append("<TD " + wafColor + ">"+detailList.get(i).getBtTeu()+"</TD>");
					sbufXML.append("<TD " + wafColor + ">"+detailList.get(i).getBt20()+"</TD>");
					sbufXML.append("<TD " + wafColor + ">"+detailList.get(i).getBtD2()+"</TD>");
					sbufXML.append("<TD " + wafColor + ">"+detailList.get(i).getBt40()+"</TD>");
					sbufXML.append("<TD " + wafColor + ">"+detailList.get(i).getBtD4()+"</TD>");
					sbufXML.append("<TD " + wafColor + ">"+detailList.get(i).getBtHc()+"</TD>");
					sbufXML.append("<TD " + wafColor + ">"+detailList.get(i).getBt45()+"</TD>");
					sbufXML.append("<TD " + wafColor + ">"+detailList.get(i).getBt53()+"</TD>");
					sbufXML.append("<TD " + wafColor + ">"+detailList.get(i).getBtRf()+"</TD>");
					sbufXML.append("<TD " + wafColor + ">"+detailList.get(i).getBtRd()+"</TD>");
					sbufXML.append("<TD " + wafColor + ">"+detailList.get(i).getBtWgt()+"</TD>");

					sbufXML.append("<TD " + wafColor + ">"+detailList.get(i).getAdTeu()+"</TD>");
					sbufXML.append("<TD " + wafColor + ">"+detailList.get(i).getAdD2()+"</TD>");
					sbufXML.append("<TD " + wafColor + ">"+detailList.get(i).getAdD4()+"</TD>");
					sbufXML.append("<TD " + wafColor + ">"+detailList.get(i).getAdHc()+"</TD>");
					sbufXML.append("<TD " + wafColor + ">"+detailList.get(i).getAd45()+"</TD>");
					sbufXML.append("<TD " + wafColor + ">"+detailList.get(i).getAd53()+"</TD>");
					sbufXML.append("<TD " + wafColor + ">"+detailList.get(i).getAdRf()+"</TD>");
					sbufXML.append("<TD " + wafColor + ">"+detailList.get(i).getAdRd()+"</TD>");
					sbufXML.append("<TD " + wafColor + ">"+detailList.get(i).getAdWgt()+"</TD>");
					
					sbufXML.append("<TD " + wafColor + " COLOR=\""+editColor+"\">"+detailList.get(i).getApTeu()+"</TD>");
					sbufXML.append("<TD " + wafColor + " COLOR=\""+editColor+"\">"+detailList.get(i).getApD2()+"</TD>");
					sbufXML.append("<TD " + wafColor + " COLOR=\""+editColor+"\">"+detailList.get(i).getApD4()+"</TD>");
					sbufXML.append("<TD " + wafColor + " COLOR=\""+editColor+"\">"+detailList.get(i).getApHc()+"</TD>");
					sbufXML.append("<TD " + wafColor + " COLOR=\""+editColor+"\">"+detailList.get(i).getAp45()+"</TD>");
					sbufXML.append("<TD " + wafColor + " COLOR=\""+editColor+"\">"+detailList.get(i).getAp53()+"</TD>");
					sbufXML.append("<TD " + wafColor + " COLOR=\""+editColor+"\">"+detailList.get(i).getApRf()+"</TD>");
					sbufXML.append("<TD " + wafColor + " COLOR=\""+editColor+"\">"+detailList.get(i).getApRd()+"</TD>");
					sbufXML.append("<TD " + wafColor + " COLOR=\""+editColor+"\">"+detailList.get(i).getApWgt()+"</TD>");
					
					// CNTR Movement
					sbufXML.append("<TD " + wafColor + ">"+detailList.get(i).getCmOp()+"</TD>");
					sbufXML.append("<TD " + wafColor + ">"+detailList.get(i).getCmOc()+"</TD>");
					sbufXML.append("<TD " + wafColor + ">"+detailList.get(i).getCmVl()+"</TD>");

					sbufXML.append("<TD " + wafColor + ">"+detailList.get(i).getApTeu()+"</TD>");
					sbufXML.append("<TD " + wafColor + ">"+detailList.get(i).getApD2()+"</TD>");
					sbufXML.append("<TD " + wafColor + ">"+detailList.get(i).getApD4()+"</TD>");
					sbufXML.append("<TD " + wafColor + ">"+detailList.get(i).getApHc()+"</TD>");
					sbufXML.append("<TD " + wafColor + ">"+detailList.get(i).getAp45()+"</TD>");
					sbufXML.append("<TD " + wafColor + ">"+detailList.get(i).getAp53()+"</TD>");
					sbufXML.append("<TD " + wafColor + ">"+detailList.get(i).getApRf()+"</TD>");
					sbufXML.append("<TD " + wafColor + ">"+detailList.get(i).getApRd()+"</TD>");
					sbufXML.append("<TD " + wafColor + ">"+detailList.get(i).getApWgt()+"</TD>");
					sbufXML.append("<TD " + wafColor + ">"+detailList.get(i).getBkgVolVgm()+"</TD>");
					sbufXML.append("<TD " + wafColor + ">"+detailList.get(i).getBkgWgtVgm()+"</TD>");
					sbufXML.append("<TD " + wafColor + ">"+detailList.get(i).getBkgBsTeu()+"</TD>");
					sbufXML.append("<TD " + wafColor + ">"+detailList.get(i).getBkgBsWgt()+"</TD>");
					
					sbufXML.append("<TD>").append((lvl<6)?"R":(detailList.get(i).getApMd().equals("0")?"I":"R")).append("</TD>"); //2015.02.17 변경누락 확인하여 수정함
					sbufXML.append("<TD></TD>");

					sbufXML.append("<TD>"+rlane+"</TD>");
					sbufXML.append("<TD>"+dir+"</TD>");
					sbufXML.append("<TD>"+vsl_cd+"</TD>");
					sbufXML.append("<TD>"+voy_no+"</TD>");
					sbufXML.append("<TD>"+dir_cd+"</TD>");
					sbufXML.append("<TD>").append((oip.indexOf("T/S")>=0)?"Y":"N").append("</TD>");
					sbufXML.append("<TD>").append(oip.startsWith("T-")?"Y":"N").append("</TD>");
					sbufXML.append("<TD>"+office+"</TD>");
					sbufXML.append("<TD>"+lvl1Row+"</TD>");
					sbufXML.append("<TD>"+lvl2Row+"</TD>");
					sbufXML.append("<TD>"+lvl3Row+"</TD>");
					sbufXML.append("<TD>"+lvl4Row+"</TD>");
					sbufXML.append("<TD>"+lvl5Row+"</TD>");
					sbufXML.append("<TD>"+detailList.get(i).getChildCnt()+"</TD>");
					sbufXML.append("<TD>"+detailList.get(i).getLeafCnt()+"</TD>");
					sbufXML.append("<TD>"+detailList.get(i).getPodCnt()+"</TD>");

					if(lvl == 0){
						rowOfc = rowNum;
					}
					rowNum = rowNum + 1;
					
					sbufXML.append("<TD>"+(lvl==1?(detailList.get(i).getOfcCd().equals("+")?"0":lvl):lvl)+"</TD>");
					sbufXML.append("<TD>").append((!vOffice.equals("+")&&!tsEdit)?"Y":"").append("</TD>");
					sbufXML.append("<TD>"+trade+"</TD>");
					sbufXML.append("<TD>"+subTrade+"</TD>");
					sbufXML.append("<TD>"+rowIoc  +"</TD>");
		            sbufXML.append("<TD>"+rowOfc  +"</TD>");
					
					sbufXML.append("<TD " + wafColor + "><![CDATA["+detailList.get(i).getSpcCtrlAlocRmk()+"]]></TD>");
					sbufXML.append("<TD " + wafColor + "><![CDATA["+detailList.get(i).getSpcCtrlAlocPolRmk()+"]]></TD>");
					sbufXML.append("<TD " + wafColor + "><![CDATA["+detailList.get(i).getSpcCtrlAlocPodRmk()+"]]></TD>");
					sbufXML.append("</TR>\n");
			
				
				}//4.9
			
				sbufXML.append("</DATA>\n");
				sbufXML.append("<ETC-DATA>\n");
				sbufXML.append("<ETC KEY=\"volume\">").append(controlVl?"Y":"N").append("</ETC>\n");
				sbufXML.append("<ETC KEY=\"pol_pod\">"+controlPort+"</ETC>\n");
				sbufXML.append("<ETC KEY=\"hc40\">").append(controlHC?"Y":"N").append("</ETC>\n");
				sbufXML.append("<ETC KEY=\"hc45\">").append(control45?"Y":"N").append("</ETC>\n");
				sbufXML.append("<ETC KEY=\"53ft\">").append(control53?"Y":"N").append("</ETC>\n");
				sbufXML.append("<ETC KEY=\"reefer\">").append(controlRF?"Y":"N").append("</ETC>\n");
				sbufXML.append("<ETC KEY=\"weight\">").append(controlWGT?"Y":"N").append("</ETC>\n");
				sbufXML.append("<ETC KEY=\"acctCtrl\">").append(acctCtrl?"Y":"N").append("</ETC>\n");
				sbufXML.append("<ETC KEY=\"d2\">").append(controlD2?"Y":"N").append("</ETC>\n");
				sbufXML.append("<ETC KEY=\"d4\">").append(controlD4?"Y":"N").append("</ETC>\n");
				sbufXML.append("<ETC KEY=\"rd\">").append(controlRd?"Y":"N").append("</ETC>\n");
				sbufXML.append("<ETC KEY=\"usa\">").append(controlUSA?"Y":"N").append("</ETC>\n");
				sbufXML.append("<ETC KEY=\"account\">").append(controlAccount?"Y":"N").append("</ETC>\n");
				sbufXML.append("<ETC KEY=\"model_dt\">"+modelDt+"</ETC>\n");
				sbufXML.append("<ETC KEY=\"destLocTp\">").append("N".equals(ctrl_dest)?"":ctrl_dest).append("</ETC>\n");
				sbufXML.append("<ETC KEY=\"destLvl\">").append("N".equals(ctrl_dest_lvl)?"":ctrl_dest_lvl).append("</ETC>\n");
				sbufXML.append("<ETC KEY=\"fixed\">").append(controlFixed?"Y":"N").append("</ETC>\n");
				sbufXML.append("<ETC KEY='DBL_CALL_CHK'><![CDATA[" + doubleCallChk + "]]></ETC>\n");
				sbufXML.append("</ETC-DATA>\n");
//				sbufXML.append("</SHEET>\n");
				
			}catch(SQLException ex){
				throw new RuntimeException(ex.getMessage());
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new RuntimeException(ex.getMessage());
			}
			
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

		return sb.toString();
	}
	/**
	 *  nullToZero를 생성한다.<br>
	 * @param rs			String
	 * @return String 	str
	 * @exception 
	 */
	private String nullToZero(String str) {
		if(str == null || str.equals("") )
			str = "0";
		return str;
	}
}