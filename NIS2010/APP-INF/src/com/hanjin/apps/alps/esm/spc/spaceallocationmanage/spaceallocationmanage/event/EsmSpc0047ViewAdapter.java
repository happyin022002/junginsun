/*========================================================= 
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmSpc0047ViewAdapter.java
*@FileTitle : spaceallocationmanage
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.07
*@LastModifier : 한상훈
*@LastVersion : 1.0
* 2009.09.07 한상훈
* 1.0 Creation
* 2010.07.05 CHOI.Y.S - [프로젝트] Ticket ID : CHM-201004171 - [프로젝트] 53FT 관련 필드 추가
* 2011.06.27 Kim jong jun : 소스 품질검토 결과 적용
* 2011.07.05 이석준 [CHM-201111880] control by HO 화면 보완 - IPC, TS 관련 
* 2011.07.20 김민아 [CHM-201112347-01] Control by HO/ RHQ 화면 QTA 및 CMPB 정보 보완 - 조회 필드 QTA CMB 및 CM Per Ton 항목 추가
* 2011.08.05 이행지 [CHM-201112741-01] Control by HO/RHQ 화면 보완 1차 - 주차별 CMB 항목 조회되도록 수정
* 2011.08.16 이행지 [CHM-201112741-01] Control by HO/RHQ 화면 보완 2차 - WAFIE Allocation 항목 색깔 반영되도록 수정
* 2012.01.02 김종준 [CHM-201110709-01] OP/OC/VL  추가
* 2013.01.23 [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
* 2014.12.16 신자영 [CHM-201433097] Control Option - A/C 및 CDMT추가 건 상세
* 2015.03.24 박은주 [CHM-201534916] Allocation by HO/RHQ 의 Edit기능에 Yield Group추가 요청 ->Sync 옵션추가
* 2015.06.11 김성욱 [CHM-201535211] SPC BKG 연동
* 2015.07.24 Arie [CHM-201537010] Control Option Management 및 VVD별 EDIT기능 보완  - Sync/Desync 빼고 Yield Group, Fixed Edit 추가
* 2016.05.18 최성민 Double Callling Route(Port/Tmnl)에 대한 물량집계 및 병목상 Logic 보완 사항 요청
=========================================================*/
package com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.event;
 
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.spc.common.common.vo.ConditionVO;
import com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SearchSpaceAllocation0047DetailListVO;
import com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SearchSpaceAllocation0047MasterListVO;
import com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SpaceAllocationManageVO;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.controller.ViewAdapter;
import com.hanjin.framework.core.layer.event.EventResponse;

/**
 * 기본 IBSheet XML 생성<br>
 * - IBSheet로 반환할 서버처리결과를 XML로 변환하는 클래스이다.<br>
 * 
 * @author 한상훈
 * @see ViewAdapter 참조
 * @since J2EE 1.5
 */

public class EsmSpc0047ViewAdapter extends ViewAdapter{
	
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
			
			List<SearchSpaceAllocation0047MasterListVO> viewList = new ArrayList<SearchSpaceAllocation0047MasterListVO>();
			viewList = spaceAllocationManageVO.getSearchSpaceAllocation0047MasterListVOs();
			
			if(viewList != null) rowCount = viewList.size();
			
//			sbufXML.append("<SHEET>\n");
			sbufXML.append("<DATA TOTAL=\""+rowCount+"\">\n");		
			if (viewList != null) {//3.1
			
				for(int i=0;i<rowCount;i++){
		
					sbufXML.append("<TR>\n");
					sbufXML.append("	<TD></TD>\n");	
					sbufXML.append("	<TD>"+viewList.get(i).getTrdCd()+"</TD>\n");
					sbufXML.append("	<TD>"+viewList.get(i).getSubTrdCd()+"</TD>\n");
					sbufXML.append("	<TD>"+viewList.get(i).getRlaneCd()+"</TD>\n");
					sbufXML.append("	<TD>"+viewList.get(i).getDirCd()+"</TD>\n");
					sbufXML.append("	<TD>"+viewList.get(i).getCostYr()+viewList.get(i).getCostWk()+"</TD>\n");
					sbufXML.append("	<TD>"+viewList.get(i).getVvd()+"</TD>\n");
					
					sbufXML.append("	<TD>"+viewList.get(i).getBsaVol()+"</TD>\n");	
					sbufXML.append("	<TD>"+viewList.get(i).getBsaWgt()+"</TD>\n");	
			
					sbufXML.append("	<TD>"+viewList.get(i).getLodVol()+"</TD>\n");
					sbufXML.append("	<TD>"+viewList.get(i).getLodWgt()+"</TD>\n");
					sbufXML.append("	<TD>"+viewList.get(i).getLodHc()+"</TD>\n");
					sbufXML.append("	<TD>"+viewList.get(i).getLod45()+"</TD>\n");	
					sbufXML.append("	<TD>"+viewList.get(i).getLodRf()+"</TD>\n");	
					
					sbufXML.append("	<TD>"+viewList.get(i).getFdVol()+"</TD>\n");	
					sbufXML.append("	<TD>"+viewList.get(i).getFdWgt()+"</TD>\n");	
			
					sbufXML.append("	<TD>"+viewList.get(i).getQtaOcn()+"</TD>\n");	
					sbufXML.append("	<TD>"+viewList.get(i).getQtaIpc()+"</TD>\n");	
			
					sbufXML.append("	<TD>"+viewList.get(i).getFcOcnVol()+"</TD>\n");
					sbufXML.append("	<TD>"+viewList.get(i).getFcOcnWgt()+"</TD>\n");
					sbufXML.append("	<TD>"+viewList.get(i).getFcIpcVol()+"</TD>\n");
					sbufXML.append("	<TD>"+viewList.get(i).getFcIpcWgt()+"</TD>\n");
					sbufXML.append("	<TD>"+viewList.get(i).getFcTsVol()+"</TD>\n");
					sbufXML.append("	<TD>"+viewList.get(i).getFcTsWgt()+"</TD>\n");
							
					Double bsaVol = 0.0;
					Double bsaWgt = 0.0;
					Double lodWgt = 0.0;

					if(viewList.get(i).getBsaVol().length() > 0 ){
//						bsaVol = Integer.parseInt(viewList.get(i).getBsaVol());
						bsaVol = Double.parseDouble(viewList.get(i).getBsaVol());
						bsaWgt= Double.parseDouble(viewList.get(i).getBsaWgt());
						lodWgt= Double.parseDouble(viewList.get(i).getLodWgt());
					}
					
					Double fcIpcVol = 0.0;
					Double bkgIpcWgt = 0.0;
					if(viewList.get(i).getFcIpcVol().length() > 0 ){
						fcIpcVol = Double.parseDouble(viewList.get(i).getFcIpcVol());
					}
					if(viewList.get(i).getBkgIpcWgt().length() > 0 ){
						bkgIpcWgt = Double.parseDouble(viewList.get(i).getBkgIpcWgt());
					}
					
					Double fcOcnVol = 0.0;
					Double bkgOcnWgt = 0.0;
					if(viewList.get(i).getFcOcnVol().length() > 0 ){
						fcOcnVol = Double.parseDouble(viewList.get(i).getFcOcnVol());
					}
					if(viewList.get(i).getBkgOcnWgt().length() > 0 ){
						bkgOcnWgt = Double.parseDouble(viewList.get(i).getBkgOcnWgt());
					}
					
					if ( bsaVol == 0 ) {
						sbufXML.append("	<TD>0</TD>\n");
					} else {
						sbufXML.append("	<TD>" +((viewList.get(i).getTrdCd().startsWith("I")?fcIpcVol:fcOcnVol) * 100 / bsaVol)+""+"</TD>\n");
					}
					if ( bsaWgt == 0 ) {
						if(lodWgt == 0){
							sbufXML.append("	<TD>0</TD>\n");	
						}else{
							sbufXML.append("	<TD>" +((viewList.get(i).getTrdCd().startsWith("I")?bkgIpcWgt:bkgOcnWgt) * 100 / lodWgt)+""+"</TD>\n");	
						}
					} else {
						sbufXML.append("	<TD>" +((viewList.get(i).getTrdCd().startsWith("I")?bkgIpcWgt:bkgOcnWgt) * 100 / bsaWgt)+""+"</TD>\n");
					}
					sbufXML.append("	<TD>"+viewList.get(i).getEpVol()+"</TD>\n");
			
					sbufXML.append("	<TD>"+viewList.get(i).getAlOcnVol()+"</TD>\n");
					sbufXML.append("	<TD>"+viewList.get(i).getAlOcnWgt()+"</TD>\n");
					sbufXML.append("	<TD>"+viewList.get(i).getAlIpcVol()+"</TD>\n");
					sbufXML.append("	<TD>"+viewList.get(i).getAlIpcWgt()+"</TD>\n");
					sbufXML.append("	<TD>"+viewList.get(i).getAlTsVol()+"</TD>\n");
					sbufXML.append("	<TD>"+viewList.get(i).getAlTsWgt()+"</TD>\n");					
			
					sbufXML.append("	<TD>"+viewList.get(i).getBkgOcnVol()+"</TD>\n");
					sbufXML.append("	<TD>"+viewList.get(i).getBkgOcnWgt()+"</TD>\n");				
					sbufXML.append("	<TD>"+viewList.get(i).getBkgIpcVol()+"</TD>\n");
					sbufXML.append("	<TD>"+viewList.get(i).getBkgIpcWgt()+"</TD>\n");
					sbufXML.append("	<TD>"+viewList.get(i).getBkgTsVol()+"</TD>\n");
					sbufXML.append("	<TD>"+viewList.get(i).getBkgTsWgt()+"</TD>\n");
					
					sbufXML.append("	<TD>"+viewList.get(i).getBkgOcnVolVgm()+"</TD>\n");
					sbufXML.append("	<TD>"+viewList.get(i).getBkgOcnWgtVgm()+"</TD>\n");
					sbufXML.append("	<TD>"+viewList.get(i).getBkgIpcVolVgm()+"</TD>\n");
					sbufXML.append("	<TD>"+viewList.get(i).getBkgIpcWgtVgm()+"</TD>\n");
					sbufXML.append("	<TD>"+viewList.get(i).getBkgTsVolVgm()+"</TD>\n");
					sbufXML.append("	<TD>"+viewList.get(i).getBkgTsWgtVgm()+"</TD>\n");
					
					sbufXML.append("	<TD>"+viewList.get(i).getBkgBsVol()+"</TD>\n");
					sbufXML.append("	<TD>"+viewList.get(i).getBkgBsWgt()+"</TD>\n");
					
					sbufXML.append("	<TD>"+viewList.get(i).getCmOp()+"</TD>\n");
					sbufXML.append("	<TD>"+viewList.get(i).getCmOc()+"</TD>\n");
					sbufXML.append("	<TD>"+viewList.get(i).getCmVl()+"</TD>\n");
			
//					sbufXML.append("<TD CALCU-LOGIC=\"|lod_vol|-|").append(viewList.get(i).getTrdCd().startsWith("I")?"alloc_ipc_vol":"alloc_ocn_vol").append("|\"></TD>\n");
					if ((getNull(viewList.get(i).getTrdCd()).startsWith("I"))){
						sbufXML.append("	<TD CALCU-LOGIC=\"|lod_vol|-|" + "alloc_ipc_vol|-|alloc_ts_vol"+"|\"></TD>");
						sbufXML.append("	<TD CALCU-LOGIC=\"|lod_wgt|-|" + "alloc_ipc_wgt|-|alloc_ts_wgt"+"|\"></TD>");
					} else {
						sbufXML.append("	<TD CALCU-LOGIC=\"|lod_vol|-|" + "alloc_ocn_vol|"+"|\"></TD>");				
						sbufXML.append("	<TD CALCU-LOGIC=\"|lod_wgt|-|" + "alloc_ocn_wgt|"+"|\"></TD>");
					}					
//					sbufXML.append("<TD CALCU-LOGIC=\"|lod_wgt|-|").append(viewList.get(i).getTrdCd().startsWith("I")?"alloc_ipc_wgt":"alloc_ocn_wgt").append("|\"></TD>\n");
					
					sbufXML.append("	<TD>"+viewList.get(i).getVslCd()+"</TD>\n");
					sbufXML.append("	<TD>"+viewList.get(i).getSkdVoyNo()+"</TD>\n");
					sbufXML.append("	<TD>"+viewList.get(i).getSkdDirCd()+"</TD>\n");
					sbufXML.append("	<TD>"+viewList.get(i).getCtrlSpcFlg()+"</TD>\n");
					sbufXML.append("	<TD>"+viewList.get(i).getCtrlPortFlg()+"</TD>\n");
					sbufXML.append("	<TD>"+viewList.get(i).getCtrl40ftHcFlg()+"</TD>\n");
					sbufXML.append("	<TD>"+viewList.get(i).getCtrl45ftHcFlg()+"</TD>\n");
					sbufXML.append("	<TD>"+viewList.get(i).getCtrl53ftFlg()+"</TD>\n");
					sbufXML.append("	<TD>"+viewList.get(i).getCtrlD2Flg()+"</TD>\n");
					sbufXML.append("	<TD>"+viewList.get(i).getCtrlD4Flg()+"</TD>\n");
					sbufXML.append("	<TD>"+viewList.get(i).getCtrlRdFlg()+"</TD>\n");
					sbufXML.append("	<TD>"+viewList.get(i).getCtrlEccFlg()+"</TD>\n");
					sbufXML.append("	<TD>"+viewList.get(i).getCtrlLocFlg()+"</TD>\n");
					sbufXML.append("	<TD>"+viewList.get(i).getCtrlUsaSvcModFlg()+"</TD>\n");
					sbufXML.append("	<TD>"+viewList.get(i).getCtrlAcctFlg()+"</TD>\n");  //account-commodity
					sbufXML.append("	<TD>"+viewList.get(i).getCtrlDestLvlCd()+"</TD>\n");
					sbufXML.append("	<TD>"+viewList.get(i).getCtrlRfFlg()+"</TD>\n");
					sbufXML.append("	<TD>"+viewList.get(i).getCtrlWgtFlg()+"</TD>\n");
					sbufXML.append("	<TD>"+viewList.get(i).getAcct()+"</TD>\n"); 		//account group(yield group)
					sbufXML.append("	<TD>"+viewList.get(i).getCtrlFxRtFlg()+"</TD>\n");  //fixed rate
					sbufXML.append("	<TD>"+viewList.get(i).getIbflag()+"</TD>\n"); 		//flag
					sbufXML.append("	<TD></TD>\n");  // ibflag
					sbufXML.append("	<TD>"+viewList.get(i).getMtyGnte()+"</TD>\n"); // mty
					sbufXML.append("	<TD></TD>\n");  // dataSeq
					sbufXML.append("	<TD>Y</TD>\n"); // edit_flg
					sbufXML.append("	<TD>Y</TD>\n"); // mnl_flg
					sbufXML.append("	<TD></TD>\n");  // 공백
					sbufXML.append("</TR>\n");
			
				}//4.9
			}//3.9
			
			sbufXML.append("</DATA>\n");
//			sbufXML.append("</SHEET>\n");
	
		}
		else if( spaceAllocationManageVO.getEventCommend().equals("SEARCHLIST02")){	//2.1
			
			List<SearchSpaceAllocation0047DetailListVO> detailList = new ArrayList<SearchSpaceAllocation0047DetailListVO>();
			detailList = spaceAllocationManageVO.getSearchSpaceAllocation0047DetailListVOs();
			
			if(detailList != null) rowCount = detailList.size();			
			
			ConditionVO conditionVO = spaceAllocationManageVO.getConditionVO();
			List<DBRowSet> dbRowSet = spaceAllocationManageVO.getRsList();
			String doubleCallChk = spaceAllocationManageVO.getDoubleCallChk();
				

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
			boolean controlUSA  = false;
			boolean controlAccount 	= false;
			boolean controlFixed       = false;
			
			String ctrl_dest = "";
			String ctrl_dest_lvl = "";
			
			String wafColor = "";
			
			try{
				int rowNum = 3;//rsEtc.getString("ACCT").equals("Y")?5:3;
				int rowOfc = 3;//rsEtc.getString("ACCT").equals("Y")?5:3;
				
				if(rsEtc != null && rsEtc.next()){
					controlVl = rsEtc.getString("volume").equals("Y");
					controlPort = rsEtc.getString("pol_pod");
					controlHC = rsEtc.getString("hc40").equals("Y");
					control45 = rsEtc.getString("hc45").equals("Y");
					control53 = rsEtc.getString("hc53").equals("Y");
					controlRF = rsEtc.getString("reefer").equals("Y");
					controlWGT = rsEtc.getString("weight").equals("Y");
					acctCtrl = rsEtc.getString("acct").equals("Y");
					controlD2 = rsEtc.getString("d2").equals("Y");
					controlD4 = rsEtc.getString("d4").equals("Y");
					controlRd = rsEtc.getString("rd").equals("Y");
					controlUSA  = rsEtc.getString("usa").equals("Y");
					controlAccount = rsEtc.getString("account").equals("Y");
					ctrl_dest = rsEtc.getString("ctrl_dest");
					ctrl_dest_lvl = rsEtc.getString("ctrl_dest_lvl");
					controlFixed = rsEtc.getString("ctrl_fx_rt_flg").equals("Y");   //fixed rate
					
					rowNum = rsEtc.getString("ACCT").equals("Y")?5:3;
					rowOfc = rsEtc.getString("ACCT").equals("Y")?5:3;
				}
				
				sbufXML.append("<DATA TOTAL=\""+rowCount+"\">\n");
				String rlane = conditionVO.getLane();
				String dir = conditionVO.getBound();
				String vvd = conditionVO.getVvd();
				String vsl_cd = vvd.substring(0, 4);
				String voy_no = vvd.substring(4, 8);
				String dir_cd = vvd.substring(8);
				String office = conditionVO.getOffice();
				String cust_ctrl_cd = "";
				String pol, pod, del;
				String oip;
				int lvl = 0;
				int lvl1Row = 0;
				int lvl2Row = 0;
				int lvl3Row = 0;
				int lvl4Row = 0;
				int lvl5Row = 0;
				int lvlTree = 0;
				String vOffice = "";
//				String vUsMod = "";
//				String vAccountCd = "";
				String editColor = "";
				boolean tsEdit = true;
				boolean past = false;
				boolean cfm_flg = false;
				String[] lvl_cds = {"", "", "",  "O", "L", "D", "T"};
				String editRow = "FALSE";
				
				boolean rowIoc = false;
				boolean rowDest  = false;
				
//				int rowNum = 3;//rsEtc.getString("ACCT").equals("Y")?5:3;
//				int rowOfc = 3;//rsEtc.getString("ACCT").equals("Y")?5:3;
//				if(rsEtc != null ){
//					rowNum = rsEtc.getString("ACCT").equals("Y")?5:3;
//					rowOfc = rsEtc.getString("ACCT").equals("Y")?5:3;
//				}
				for(int i=0;i<rowCount;i++){//while (rowSet.next()) {//4.1
					
					cust_ctrl_cd = getNull(detailList.get(i).getCustCtrlCd());
					pol = detailList.get(i).getPolCd();
					pod = detailList.get(i).getPodCd();
					del = detailList.get(i).getDelCd();
					//lvl = (pol.equals("+")|| pol.equals(""))?1:(pod.equals("+")?2:3);
					lvl = Integer.parseInt(detailList.get(i).getLvl());
					//lvl = Integer.parseInt(nullToZero(detailList.get(i).getLvl()));
					oip = detailList.get(i).getIocCd();
					vOffice = detailList.get(i).getOfcCd();
					
//					vUsMod = detailList.get(i).getUsMod();
//					vAccountCd = detailList.get(i).getAccountCd();
					if(vOffice.equals("NULL")){
						vOffice = "";
					}
					tsEdit = detailList.get(i).getEdit().equals("Y");
					past = detailList.get(i).getPast().equals("Y");
					cfm_flg = detailList.get(i).getCfmFlg().equals("Y");
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
					
					
					int childCnt = 0;
					if(!(oip.startsWith("EQ")||vOffice.equals("+"))){
						//String[] lvl_cds = {"", "", "",  "O", "L", "D", "T"};
						editRow = String.valueOf(controlPort.equals(lvl_cds[lvl]));
						// controlUSA, controlAccount에 따라 control 조
						switch(lvl){
						// level에 따른 editable 조정
						case 1:
							editRow = String.valueOf(!oip.startsWith("T-")&&controlPort.equals("O")&&rsEtc.getString("usa").equals("N")&&rsEtc.getString("account").equals("N"));
							break;
						case 2:
							editRow = String.valueOf(!oip.startsWith("T-")&&controlPort.equals("O")&&rsEtc.getString("usa").equals("Y")&&rsEtc.getString("account").equals("N"));
							break;
						case 3:
							editRow = String.valueOf(!oip.startsWith("T-")&&controlPort.equals("O")&&rsEtc.getString("usa").equals("Y")&&rsEtc.getString("account").equals("Y"));
							break;
						case 4:
							editRow = String.valueOf(!oip.startsWith("T-")&&controlPort.equals("L"));
							break;
						case 5:
							editRow = String.valueOf(oip.startsWith("T-")||controlPort.equals("D"));
							break;
						case 6:
							editRow = String.valueOf(oip.startsWith("T-")||controlPort.equals("T"));
							break;
						}
						
						if(detailList.get(i).getChildCnt().length() > 0) childCnt = Integer.parseInt(detailList.get(i).getChildCnt());
						
						if(childCnt <= 0){//if(rowSet.getInt("child_cnt") <= 0){
							editRow = "FALSE";
						}
					}
					else{
						if(detailList.get(i).getChildCnt().length() > 0) childCnt = Integer.parseInt(detailList.get(i).getChildCnt());
						editRow = "FALSE";
					}
					
					editRow = editRow.toUpperCase();
					
					if("Y".equals(rsEtc.getString("ACCT"))){
						rowIoc        = getNull(detailList.get(i).getRhqCd()).equals("")&&getNull(detailList.get(i).getOfcCd()).equals("+")&&getNull(detailList.get(i).getDelCd()).equals("+")?true:false;
						rowDest       = getNull(detailList.get(i).getRhqCd()).equals("")&&getNull(detailList.get(i).getOfcCd()).equals("+")&&!getNull(detailList.get(i).getDelCd()).equals("+")?true:false;
					}else{
						rowIoc        = getNull(detailList.get(i).getOfcCd()).equals("+")&&getNull(detailList.get(i).getDelCd()).equals("+")?true:false;
						rowDest       = getNull(detailList.get(i).getOfcCd()).equals("+")&&!getNull(detailList.get(i).getDelCd()).equals("+")?true:false;
					}

//					rowIoc  = getNull(detailList.get(i).getRhqCd()).equals("")&&vOffice.equals("+")?true:false;

					if( pol.equals("") && (vOffice.equals("HAMRU") || vOffice.equals("NYCRA")) ){
						wafColor = "BGCOLOR=\"194,238,238\"";					
					} else {
						wafColor = "";
					}
					
					if( cust_ctrl_cd.equals("+") && !vOffice.equals("+")){ //SMP sum
						wafColor = "BGCOLOR=\"223,232,247\"";					
					} else {
					}
					
					lvlTree = (cust_ctrl_cd.equals("+") || vOffice.equals("+"))?0:lvl;
					
					sbufXML.append("<TR LEVEL=\""+ lvlTree +"\" ");
					sbufXML.append("EDIT=\""+(editRow.equals("TRUE")?((rowIoc||cust_ctrl_cd.equals("+"))?"FALSE":"TRUE"):editRow)+"\" ");
					sbufXML.append(">");
					sbufXML.append("	<TD>"+oip+"</TD>");
					if(vOffice.equals("+")){
						sbufXML.append("	<TD INDENT='1'></TD>");
						sbufXML.append("	<TD INDENT='1'>"+(rowDest?"DEST TTL":(rowIoc?"TTL":""))+"</TD>");
						if(rsEtc.getString("ACCT").equals("Y")){
							sbufXML.append("	<TD " + (cust_ctrl_cd.equals("+")?"DATA-TYPE=\"dtImage\"":"") + ">" + (cust_ctrl_cd.equals("+")||cust_ctrl_cd.equals("DEST TOTAL")?"":cust_ctrl_cd) + "</TD>");
						}else{
							sbufXML.append("	<TD INDENT='1'></TD>");
						}
						//2014.07.21
						sbufXML.append("	<TD></TD>");
						sbufXML.append("	<TD></TD>");
						sbufXML.append("	<TD></TD>");
						sbufXML.append("	<TD></TD>");
						sbufXML.append("	<TD></TD>");
//						sbufXML.append("	<TD></TD>");
						sbufXML.append("	<TD ").append((rowDest&&!del.equals("OTHERS"))?" BOLD='TRUE' COLOR='BLUE'":"").append(">").append(rowDest?del:"").append("</TD>");
						sbufXML.append("	<TD></TD>");
					}else{
						sbufXML.append("	<TD INDENT='1'>"+getNull(detailList.get(i).getRhqCd())+"</TD>");
						sbufXML.append("	<TD INDENT='1'>"+vOffice+"</TD>");
						if(rsEtc.getString("ACCT").equals("Y")){
							//sbufXML.append("	<TD" + (lvlTree==0?" DATA-TYPE=\"dtImage\"":"") + ">" + (cust_ctrl_cd.equals("+")?"1":cust_ctrl_cd) + "</TD>");
							sbufXML.append("	<TD "+wafColor+"").append((lvl==0)?" DATA-TYPE=\"dtImage\"":"").append(">").append(lvl>=0?(detailList.get(i).getCustCtrlCd().equals("+")?"1":detailList.get(i).getCustCtrlCd()):"").append("</TD>");
			            }else{
							sbufXML.append("	<TD INDENT='1'></TD>");
						}
						//2014.07.21
		            	sbufXML.append("	<TD "+wafColor+"").append((lvl==1)?" DATA-TYPE=\"dtImage\"":"").append(">").append(lvl>=1?(detailList.get(i).getUsMod().equals("")?"1":detailList.get(i).getUsMod()):"").append("</TD>");
		            	sbufXML.append("	<TD "+wafColor+"").append((lvl==2)?" DATA-TYPE=\"dtImage\"":"").append(">").append(lvl>=2?(detailList.get(i).getAccountCd().equals("")?"1":detailList.get(i).getAccountCd()):"").append("</TD>");
		            	sbufXML.append("	<TD "+wafColor+"").append((lvl==2)?" DATA-TYPE=\"dtImage\"":"").append("><![CDATA[").append(lvl>=2?(detailList.get(i).getAccountCd().equals("")?"1":detailList.get(i).getAccountNm()):"").append("]]></TD>");
						//2014.07.30
						//rowIoc total 여부 
						sbufXML.append("	<TD "+wafColor+"").append((lvl==3)?" DATA-TYPE=\"dtImage\"":"").append(">").append((rowIoc&&lvl>=3?"-1":(lvlTree<3)?(""):((lvlTree==3)?(childCnt>0?("LD".indexOf(controlPort)>=0?"1":"0"):"-1"):pol))).append("</TD>");
						sbufXML.append("	<TD "+wafColor+"").append((lvl==4)?" DATA-TYPE=\"dtImage\"":"").append(">").append((rowIoc?"":(lvl<=3)?(""):((lvl==4)?(childCnt>0?("D".indexOf(controlPort)>=0?"1":"0"):"-1"):pod))).append("</TD>");
						sbufXML.append("	<TD "+wafColor+"").append((lvl==5)?" DATA-TYPE=\"dtImage\"":(lvl==6?(del.equals("OTHERS")? "":" BOLD='TRUE' COLOR='BLUE'"):"")).append(">").append((rowIoc?"":(lvl<=4)?(""):((lvl==5)?"1":del))).append("</TD>");
						sbufXML.append("	<TD "+wafColor+"></TD>");
					}
					sbufXML.append("	<TD "+wafColor+">"+detailList.get(i).getBkgQuota()+"</TD>");
					sbufXML.append("	<TD "+wafColor+">"+detailList.get(i).getBkgQtaCmb()+"</TD>");
					sbufXML.append("	<TD "+wafColor+">"+detailList.get(i).getCmb()+"</TD>");
					sbufXML.append("	<TD "+wafColor+">"+detailList.get(i).getCmbWgt()+"</TD>");
					sbufXML.append("	<TD "+wafColor+">"+detailList.get(i).getFctCmb()+"</TD>");
					
					
					sbufXML.append("	<TD " + wafColor + ((int) Math.round(Float.valueOf(nullToZero(getNull(detailList.get(i).getCmbTrend()))).floatValue())>0?" COLOR=\"0,0,255\"":((int) Math.round(Float.valueOf(nullToZero(getNull(detailList.get(i).getCmbTrend()))).floatValue())<0?" COLOR=\"255,0,0\"":"")) + ">" + getNull(detailList.get(i).getCmbTrend()) + "</TD>");
		            sbufXML.append("	<TD " + wafColor + ((int) Math.round(Float.valueOf(nullToZero(getNull(detailList.get(i).getCmbWgtTrend()))).floatValue())>0?" COLOR=\"0,0,255\"":((int) Math.round(Float.valueOf(nullToZero(getNull(detailList.get(i).getCmbWgtTrend()))).floatValue())<0?" COLOR=\"255,0,0\"":"")) + ">" + getNull(detailList.get(i).getCmbWgtTrend()) + "</TD>");
					
					// Weekly CMB 추가
		            sbufXML.append("	<TD "+wafColor+">"+detailList.get(i).getCmb1()+"</TD>");
		            sbufXML.append("	<TD "+wafColor+">"+detailList.get(i).getCmb2()+"</TD>");
		            sbufXML.append("	<TD "+wafColor+">"+detailList.get(i).getCmb3()+"</TD>");
		            sbufXML.append("	<TD "+wafColor+">"+detailList.get(i).getCmb4()+"</TD>");
		            sbufXML.append("	<TD "+wafColor+">"+detailList.get(i).getCmbWgt1()+"</TD>");
		            sbufXML.append("	<TD "+wafColor+">"+detailList.get(i).getCmbWgt2()+"</TD>");
		            sbufXML.append("	<TD "+wafColor+">"+detailList.get(i).getCmbWgt3()+"</TD>");
		            sbufXML.append("	<TD "+wafColor+">"+detailList.get(i).getCmbWgt4()+"</TD>");
		            
		            sbufXML.append("	<TD " + wafColor + ">" + getNull(detailList.get(i).getGuide()) + "</TD>");
	
					sbufXML.append("	<TD "+wafColor+" COLOR=\"").append(past?"BLUE":"").append("\">"+detailList.get(i).getFcTtlTeu()+"</TD>");
					sbufXML.append("	<TD "+wafColor+" COLOR=\"").append(past?"BLUE":"").append("\">"+detailList.get(i).getFcTeu()+"</TD>");
					sbufXML.append("	<TD "+wafColor+">"+detailList.get(i).getFcD2()+"</TD>");
					sbufXML.append("	<TD "+wafColor+">"+detailList.get(i).getFcD4()+"</TD>");
					sbufXML.append("	<TD "+wafColor+">"+detailList.get(i).getFcHc()+"</TD>");
					sbufXML.append("	<TD "+wafColor+">"+detailList.get(i).getFc45()+"</TD>");
					sbufXML.append("	<TD "+wafColor+">"+detailList.get(i).getFc53()+"</TD>");
					sbufXML.append("	<TD "+wafColor+">"+detailList.get(i).getFcRf()+"</TD>");
					sbufXML.append("	<TD "+wafColor+">"+detailList.get(i).getFcRd()+"</TD>");
					sbufXML.append("	<TD "+wafColor+">"+detailList.get(i).getFcWgt()+"</TD>");
	
		
					editColor = !vOffice.equals("+")&&(lvl==0||lvl==1)&&cfm_flg?"BLUE":"";
		
					int apTeu = 0;
					if(detailList.get(i).getApTeu().length()>0) apTeu = Integer.parseInt(detailList.get(i).getApTeu());
					
					editColor = (apTeu < 0)?"RED":"";//editColor = (rowSet.getInt("ap_teu") < rowSet.getInt("gt_teu"))?"RED":"";
		
					sbufXML.append("	<TD "+wafColor+" COLOR=\""+editColor+"\">"+detailList.get(i).getApTeu()+"</TD>");
					sbufXML.append("	<TD "+wafColor+" COLOR=\""+editColor+"\">"+detailList.get(i).getApD2()+"</TD>");
					sbufXML.append("	<TD "+wafColor+" COLOR=\""+editColor+"\">"+detailList.get(i).getApD4()+"</TD>");
					sbufXML.append("	<TD "+wafColor+" COLOR=\""+editColor+"\">"+detailList.get(i).getApHc()+"</TD>");
					sbufXML.append("	<TD "+wafColor+" COLOR=\""+editColor+"\">"+detailList.get(i).getAp45()+"</TD>");
					sbufXML.append("	<TD "+wafColor+" COLOR=\""+editColor+"\">"+detailList.get(i).getAp53()+"</TD>");
					sbufXML.append("	<TD "+wafColor+" COLOR=\""+editColor+"\">"+detailList.get(i).getApRf()+"</TD>");
					sbufXML.append("	<TD "+wafColor+" COLOR=\""+editColor+"\">"+detailList.get(i).getApRd()+"</TD>");
					sbufXML.append("	<TD "+wafColor+" COLOR=\""+editColor+"\">"+detailList.get(i).getApWgt()+"</TD>");
					
					sbufXML.append("	<TD "+wafColor+">"+detailList.get(i).getBtTeu()+"</TD>");
					sbufXML.append("	<TD "+wafColor+">"+detailList.get(i).getBt20()+"</TD>");
					sbufXML.append("	<TD "+wafColor+">"+detailList.get(i).getBtD2()+"</TD>");
					sbufXML.append("	<TD "+wafColor+">"+detailList.get(i).getBt40()+"</TD>");
					sbufXML.append("	<TD "+wafColor+">"+detailList.get(i).getBtD4()+"</TD>");
					sbufXML.append("	<TD "+wafColor+">"+detailList.get(i).getBtHc()+"</TD>");
					sbufXML.append("	<TD "+wafColor+">"+detailList.get(i).getBt45()+"</TD>");
					sbufXML.append("	<TD "+wafColor+">"+detailList.get(i).getBt53()+"</TD>");
					sbufXML.append("	<TD "+wafColor+">"+detailList.get(i).getBtRf()+"</TD>");
					sbufXML.append("	<TD "+wafColor+">"+detailList.get(i).getBtRd()+"</TD>");
					sbufXML.append("	<TD "+wafColor+">"+detailList.get(i).getBtWgt()+"</TD>");
		            sbufXML.append("	<TD "+wafColor+">" + detailList.get(i).getCmOp() + "</TD>");
		            sbufXML.append("	<TD "+wafColor+">" + detailList.get(i).getCmOc() + "</TD>");
		            sbufXML.append("	<TD "+wafColor+">" + detailList.get(i).getCmVl() + "</TD>");
	
					sbufXML.append("	<TD "+wafColor+">"+detailList.get(i).getApTeu()+"</TD>");
					sbufXML.append("	<TD "+wafColor+">"+detailList.get(i).getApD2()+"</TD>");
					sbufXML.append("	<TD "+wafColor+">"+detailList.get(i).getApD4()+"</TD>");
					sbufXML.append("	<TD "+wafColor+">"+detailList.get(i).getApHc()+"</TD>");
					sbufXML.append("	<TD "+wafColor+">"+detailList.get(i).getAp45()+"</TD>");
					sbufXML.append("	<TD "+wafColor+">"+detailList.get(i).getAp53()+"</TD>");
					sbufXML.append("	<TD "+wafColor+">"+detailList.get(i).getApRf()+"</TD>");
					sbufXML.append("	<TD "+wafColor+">"+detailList.get(i).getApRd()+"</TD>");
					sbufXML.append("	<TD "+wafColor+">"+detailList.get(i).getApWgt()+"</TD>");
					sbufXML.append("	<TD "+wafColor+">"+detailList.get(i).getBkgVolVgm()+"</TD>");
					sbufXML.append("	<TD "+wafColor+">"+detailList.get(i).getBkgWgtVgm()+"</TD>");			
					sbufXML.append("	<TD "+wafColor+">"+detailList.get(i).getBkgBsTeu()+"</TD>"); //bkg_bs_vol
					sbufXML.append("	<TD "+wafColor+">"+detailList.get(i).getBkgBsWgt()+"</TD>");//bkg_bs_wgt

					//sbufXML.append("	<TD "+wafColor+">").append((lvl<2)?"R":(detailList.get(i).getApMd().equals("0")?"I":"R")).append("</TD>");
					sbufXML.append("	<TD "+wafColor+">").append((lvl<5)?"R":(detailList.get(i).getApMd().equals("0")?"I":"R")).append("</TD>");
					sbufXML.append("	<TD "+wafColor+"></TD>");
	
					sbufXML.append("	<TD "+wafColor+">"+rlane+"</TD>");
					sbufXML.append("	<TD "+wafColor+">"+dir+"</TD>");
					sbufXML.append("	<TD "+wafColor+">"+vsl_cd+"</TD>");
					sbufXML.append("	<TD "+wafColor+">"+voy_no+"</TD>");
					sbufXML.append("	<TD "+wafColor+">"+dir_cd+"</TD>");
					sbufXML.append("	<TD "+wafColor+">").append((oip.indexOf("T/S")>=0)?"Y":"N").append("</TD>");
					sbufXML.append("	<TD "+wafColor+">").append(oip.startsWith("T-")?"Y":"N").append("</TD>");
					sbufXML.append("	<TD "+wafColor+">"+office+"</TD>");
					sbufXML.append("	<TD "+wafColor+">"+lvl1Row+"</TD>");
					sbufXML.append("	<TD "+wafColor+">"+lvl2Row+"</TD>");
					sbufXML.append("	<TD "+wafColor+">"+lvl3Row+"</TD>");
					sbufXML.append("	<TD "+wafColor+">"+lvl4Row+"</TD>");
					sbufXML.append("	<TD "+wafColor+">"+lvl5Row+"</TD>");
					sbufXML.append("	<TD "+wafColor+">"+detailList.get(i).getChildCnt()+"</TD>");
					sbufXML.append("	<TD "+wafColor+">"+detailList.get(i).getLeafCnt()+"</TD>");
					sbufXML.append("	<TD "+wafColor+">"+detailList.get(i).getPodCnt()+"</TD>");
					
					if(lvlTree == 0) {
						rowOfc = rowNum;
					}
					
					rowNum = rowNum + 1;
					sbufXML.append("	<TD "+wafColor+">").append(lvlTree).append("</TD>");
					
					sbufXML.append("	<TD "+wafColor+">").append((!vOffice.equals("+")&&!tsEdit)?"Y":"").append("</TD>");
					sbufXML.append("	<TD "+wafColor+">"+detailList.get(i).getTrdCd()+"</TD>");
					sbufXML.append("	<TD "+wafColor+">"+detailList.get(i).getSubTrdCd()+"</TD>");
					sbufXML.append("	<TD>" + rowIoc   + "</TD>");
					sbufXML.append("	<TD>" + rowDest  + "</TD>");
		            sbufXML.append("	<TD>" + rowOfc   + "</TD>");
					sbufXML.append("	<TD "+wafColor+"><![CDATA["+detailList.get(i).getSpcCtrlAlocRmk()+"]]></TD>");
					sbufXML.append("	<TD "+wafColor+"><![CDATA["+detailList.get(i).getSpcCtrlAlocPolRmk()+"]]></TD>");
					sbufXML.append("	<TD "+wafColor+"><![CDATA["+detailList.get(i).getSpcCtrlAlocPodRmk()+"]]></TD>");
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
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new RuntimeException(ex.getMessage());
		}
		return sb.toString();
	}
}