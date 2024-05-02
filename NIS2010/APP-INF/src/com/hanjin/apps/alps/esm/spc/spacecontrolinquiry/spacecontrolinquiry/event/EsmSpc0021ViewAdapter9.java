/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmSpc0021ViewAdapter9.java
*@FileTitle : spacecontrolinquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2012.12.04
*@LastModifier : 최윤성
*@LastVersion : 1.0
* 2012.12.04 최윤성
* 1.0 Creation
* 2012.12.04 최윤성 [CHM-201221640-01] FCST&PFMC by ACCT 신규 탭 추가
* 2013.01.23 [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
* 2013.04.25 진마리아 [CHM-201324211] 프로젝트 안정화 및 HELP DESK - weekly AVG 통합 
* 2013.08.02 진마리아 [CHM-201325983-01] Yield Group 추가, timeout 오류 수정
* 2013.08.23 진마리아 [Trouble shooting] CC,RC,LC별 grouping을 Yield Group별 grouping으로 변경
* 2014.02.04 [CHM-201428383-01] RFA 로직 추가
* 2014.07.02 김용습 R4J 패치 사전 작업
* 2014.11.05 [CHM-201432345] SMP Report 신규 생성(요건 변경으로 FCST&PFMC Status by ACCT탭 수정) 
				- Accout Class삭제, L.OFC 체크박스 추가, Fcast 체크박스 추가
				- TTL CM, CMPB, Load% BKG옆에 추가
				- Inqurity by Customized Condition 팝업링크 추가
* 2014.11.20 [CHM-201432864] Daily FCST보완
				- SUB Trade별 전체 실적 GUIDE추가(Acct)
				- SUB Trade, Trade 별 USMode/Account/Dest Sum 추가(HO/RHQ)
				- 체크박스 기능 재정의(HO/RHQ)
=========================================================*/
package com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.event;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.ComplexMainVO;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.ETCVO;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlInquiry021AllocPortViewListVO;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlInquiryConditionVO;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.ViewAdapter;
import com.hanjin.framework.core.layer.event.EventResponse;

/**
 * 기본 IBSheet XML 생성<br>
 * - IBSheet로 반환할 서버처리결과를 XML로 변환하는 클래스이다.<br>
 * 
 * @author 최윤성
 * @see ViewAdapter 참조
 * @since J2EE 1.5
 */
public class EsmSpc0021ViewAdapter9 extends ViewAdapter{
	
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
				
		ComplexMainVO comMain = (ComplexMainVO)vos.get(0);
		
		List<ETCVO> etc = new ArrayList<ETCVO>();
		List<SearchSpaceControlInquiry021AllocPortViewListVO> viewList = new ArrayList<SearchSpaceControlInquiry021AllocPortViewListVO>();
		etc = comMain.getEtc();
		viewList = comMain.getInquiry021AllocPortViewListVO();
		
		SearchSpaceControlInquiryConditionVO condition = comMain.getCondition();
		
		int rowCountetc  = etc.size();
		int rowCountview = viewList.size();
		
		sbufXML.append("<DATA TOTAL=\""+rowCountview+"\">\n");
		
		int weekCnt    = 0;
		String[] week  = null;
		String[] fdtd  = null;
		String strWeek = "";
		String strFdTd = "";
		String itemv   = condition.getChkview();
		
		//2014.07.02 김용습 R4J 패치 사전 작업
      	StringBuffer out1 = new StringBuffer();
    	StringBuffer out2 = new StringBuffer();
		
		if (rowCountetc > 0 && etc != null) {//3.1
			weekCnt = rowCountetc;
			week    = new String[weekCnt];
			fdtd    = new String[weekCnt];
			
			for(int i = 0; i<rowCountetc ; i++){
				week[i] = JSPUtil.getNull(etc.get(i).getCostYr()) + JSPUtil.getNull(etc.get(i).getCostWk1());
				fdtd[i] = JSPUtil.getNull(etc.get(i).getSlsFmDt()) + "~" + JSPUtil.getNull(etc.get(i).getSlsToDt());
				
				//2014.07.02 김용습 R4J 패치 사전 작업
				//strWeek = strWeek + "|" + week[i];
				//strFdTd = strFdTd + "|" + fdtd[i];
				out1.append("|").append(week[i]);
				out2.append("|").append(fdtd[i]);
			}
			//2014.07.02 김용습 R4J 패치 사전 작업
			strWeek = out1.toString();
			strFdTd = out2.toString();
		}//3.9
		
		if (rowCountview > 0 && viewList != null) {//3.1
			int duration = Integer.parseInt(condition.getDuration());
			
			String trd_cd      = "";
			String cust_grp_id = "";
			String cust_grp_nm = "";
			String cust_nm     = "";
			String cust_cnt_cd = "";
			String oth_cust_nm = "";
			String sc_no       = "";
			String rfa_no      = "";
			String ofc_cd      = "";
			String rlane_cd    = "";
			String ctrt_ofc    = "";
			String cust_clss   = "";
			String sub_trd_cd  = "";
			String acct_tp     = "";
			String bkg_avg     = "";
			String cust_ctrl_cd = "";
			String cust_no     = "";
			
			String view_type   = condition.getViewType11();
			String total_chk   = "N";
				
			if (rowCountview > 0 && viewList != null) {//3.1
				for(int i =0 ; i < rowCountview ; i++){
					
					trd_cd      = viewList.get(i).getTrdCd();
					cust_grp_id = viewList.get(i).getCustGrpId();//
					cust_grp_nm = viewList.get(i).getCustGrpNm();
					cust_nm     = viewList.get(i).getCustNm();
					cust_cnt_cd = viewList.get(i).getCustCntCd();
					oth_cust_nm = viewList.get(i).getOthCustNm();
					sc_no       = viewList.get(i).getScNo();
					rfa_no      = viewList.get(i).getRfaNo();
					ofc_cd      = viewList.get(i).getOfcCd();
					rlane_cd    = viewList.get(i).getRlaneCd();
					ctrt_ofc    = viewList.get(i).getCtrtOfcCd();					
					cust_clss   = viewList.get(i).getCustClss();					
					sub_trd_cd  = viewList.get(i).getSubTrdCd();					
					acct_tp     = viewList.get(i).getAcctTp();					
					bkg_avg     = viewList.get(i).getBkgAvgQty11();
					cust_ctrl_cd = viewList.get(i).getCustCtrlCd();
					cust_no     = viewList.get(i).getCustNo();//
					
					//
					if(!(cust_grp_id).equals("GTTL")) {
						if(acct_tp.equals("B")) acct_tp = "BO"; 
						else if(acct_tp.equals("N")) acct_tp = "NO";
					}
					
					if((view_type).equals("ACCT")) {
						if(    (!(cust_grp_id).equals("XX999999") && !(cust_grp_id).equals("") && (cust_nm).equals("") && (ofc_cd).equals(""))
							|| ((cust_grp_id).equals("XX999999") && (cust_cnt_cd).equals("") && (ofc_cd).equals(""))) {
							sbufXML.append("<tr BGCOLOR=\"247,231,236\">\n");
							total_chk = "Y";
						} else if ((cust_clss).equals("")){	//	전체 TTL
							sbufXML.append("<tr BGCOLOR=\"203,230,254\">\n");
							total_chk = "Y";
						} else if ((cust_grp_id).equals("")){	//	Group Account - KA / GA / RA / LA 별 TTL
							sbufXML.append("<tr BGCOLOR=\"232,255,198\"  HIDDEN='TRUE'>\n");
//							sbufXML.append("<tr BGCOLOR=\"232,255,198\">\n");
							total_chk = "G";
						} else if(!(ofc_cd).equals("") && (rlane_cd).equals("")){		// Sub Trade TTL
							sbufXML.append("<tr BGCOLOR=\"255,255,221\">\n");
							total_chk = "S";
					    } else if((cust_grp_id).equals("GTTL")){		// 하단 SUM
							sbufXML.append("<tr BGCOLOR=\"255,255,221\">\n");
//							sbufXML.append("<tr BGCOLOR=\"255,255,221\" MERGE='TRUE'>\n");							
//							total_chk = "S";
//					    } else if((cust_grp_id).equals("GTTL") && !(cust_ctrl_cd.equals("TTL"))){		// 하단 SUM
//							sbufXML.append("<tr BGCOLOR=\"255,255,221\" MERGE='TRUE'>\n");
////							total_chk = "S";
					    } else {
							sbufXML.append("<tr>\n");
							total_chk = "N";
						}

						sbufXML.append("<td>" + trd_cd + "</td>\n");
						sbufXML.append("<td>" + cust_clss + "</td>\n");
						
						if((cust_grp_id).equals("XX999999")) {
							if((cust_cnt_cd).equals("") && !(ofc_cd).equals("")){
								sbufXML.append("<td>0ther (+)</td>\n");
								sbufXML.append("<td>cust_grp_id</td>\n");
								sbufXML.append("<td>Other</td>\n");
								sbufXML.append("<td></td>\n");
								sbufXML.append("<td></td>\n");
								sbufXML.append("<td>cust_no</td>\n");
								sbufXML.append("<td></td>\n");
								sbufXML.append("<td></td>\n");
								sbufXML.append("<td></td>\n");
								sbufXML.append("<td>" + ctrt_ofc + "</td>\n");
								sbufXML.append("<td>" + ofc_cd + "</td>\n");
							} else {
								if(total_chk.equals("Y")) {
									sbufXML.append("<td>Other TTL</td>\n");
									sbufXML.append("<td>cust_grp_id</td>\n");
									sbufXML.append("<td>Other TTL</td>\n");
									sbufXML.append("<td>" + cust_ctrl_cd  + "</td>\n");
									sbufXML.append("<td></td>\n");
									sbufXML.append("<td>cust_no</td>\n");
									sbufXML.append("<td>" + sc_no  + "</td>\n");
									sbufXML.append("<td>" + rfa_no + "</td>\n");
									sbufXML.append("<td>" + acct_tp + "</td>\n");
									sbufXML.append("<td>" + ctrt_ofc + "</td>\n");
									sbufXML.append("<td></td>\n");
								} else {
									sbufXML.append("<td>22<![CDATA[" + oth_cust_nm + "]]></td>\n");
									sbufXML.append("<td>cust_grp_id</td>\n");
									sbufXML.append("<td>Other Detail</td>\n");
									sbufXML.append("<td>" + cust_ctrl_cd  + "</td>\n");
									sbufXML.append("<td></td>\n");
									sbufXML.append("<td>cust_no</td>\n");
									sbufXML.append("<td>" + sc_no  + "</td>\n");
									sbufXML.append("<td>" + rfa_no + "</td>\n");
									sbufXML.append("<td></td>\n");
									sbufXML.append("<td>" + ctrt_ofc + "</td>\n");
									sbufXML.append("<td>" + ofc_cd + "</td>\n");
								}
							}
						} else if((cust_clss).equals("")){
							sbufXML.append("<td>TTL</td>\n");
							sbufXML.append("<td>cust_grp_id</td>\n");
							sbufXML.append("<td>TTL</td>\n");
							sbufXML.append("<td></td>\n");
							sbufXML.append("<td></td>\n");
							sbufXML.append("<td>cust_no</td>\n");
							sbufXML.append("<td></td>\n");
							sbufXML.append("<td></td>\n");
							sbufXML.append("<td>" + acct_tp + "</td>\n");
							sbufXML.append("<td>" + ctrt_ofc + "</td>\n");
							sbufXML.append("<td></td>\n");
						} else if((cust_grp_id).equals("")){
							sbufXML.append("<td>" + cust_clss + " TTL</td>\n");
							sbufXML.append("<td>cust_grp_id</td>\n");
							sbufXML.append("<td>TTL</td>\n");
							sbufXML.append("<td></td>\n");
							sbufXML.append("<td></td>\n");
							sbufXML.append("<td></td>\n");
							sbufXML.append("<td>cust_no</td>\n");
							sbufXML.append("<td></td>\n");
							sbufXML.append("<td>" + acct_tp + "</td>\n");
							sbufXML.append("<td>" + ctrt_ofc + "</td>\n");
							sbufXML.append("<td></td>\n");
						} else {
							if(total_chk.equals("Y")) {
								if((cust_grp_id).equals("GTTL"))
									sbufXML.append("<td DATA-ALIGN='daCenter'>Guide TTL</td>\n");
								else 
									sbufXML.append("<td></td>\n");
								sbufXML.append("<td>cust_grp_id</td>\n");
							}else{
								sbufXML.append("<td><![CDATA[" + ((cust_grp_nm).equals("")?cust_nm.replace("|", ","):cust_grp_nm) + "]]></td>\n");
								sbufXML.append("<td>" + cust_grp_id + "</td>\n");
								
							}
							sbufXML.append("<td>Main</td>\n");
							if((cust_grp_id).equals("GTTL")) {
								sbufXML.append("<td DATA-ALIGN='daCenter'>" + cust_ctrl_cd  + "</td>\n");
								sbufXML.append("<td DATA-ALIGN='daCenter'>" + cust_ctrl_cd  + "</td>\n");
								sbufXML.append("<td>" + cust_no + "</td>\n");
								sbufXML.append("<td INDENT='" + (sc_no.equals("")?1:0) + "'>" + sc_no  + "</td>\n");
								sbufXML.append("<td INDENT='" + (rfa_no.equals("")?1:0) + "'>" + rfa_no + "</td>\n");
								sbufXML.append("<td></td>\n");
								sbufXML.append("<td></td>\n");
								sbufXML.append("<td></td>\n");
							} else {
								sbufXML.append("<td INDENT='" + (cust_ctrl_cd.equals("")?1:0) + "'>" + cust_ctrl_cd  + "</td>\n");
								sbufXML.append("<td DATA-ALIGN='daLeft'><![CDATA[" + cust_nm.replace("|", ",") + "]]></td>\n");
								sbufXML.append("<td>" + cust_no + "</td>\n");
								sbufXML.append("<td INDENT='" + (sc_no.equals("")?1:0) + "'>" + sc_no  + "</td>\n");
								sbufXML.append("<td INDENT='" + (rfa_no.equals("")?1:0) + "'>" + rfa_no + "</td>\n");
								sbufXML.append("<td>" + acct_tp + "</td>\n");
								sbufXML.append("<td INDENT='" + (ctrt_ofc.equals("")?1:0) + "'>" + ctrt_ofc + "</td>\n");
								if(total_chk.equals("Y")) {
									sbufXML.append("<td>G/ACCT TTL</td>\n");
								} else {
									sbufXML.append("<td>" + ofc_cd + "</td>\n");
								}
							}
							
						}
						if((cust_grp_id).equals("GTTL")) {
							sbufXML.append("<td></td>\n");
						} else {
							sbufXML.append("<td>" + sub_trd_cd + "</td>\n");
						}
						
						
						if(total_chk.equals("S")){
							sbufXML.append("<td>" + sub_trd_cd + " TTL"  + "</td>\n");
						}else {
							sbufXML.append("<td>" + rlane_cd  + "</td>\n");
						}
						
					} else { // L_OFC 
						cust_clss = "";
						if((sub_trd_cd).equals("") && !(ofc_cd).equals("")){	// Office TTL
							sbufXML.append("<tr BGCOLOR=\"247,231,236\">\n");
							total_chk = "Y";
						} else if ((ofc_cd).equals("")){	//	전체 TTL
							sbufXML.append("<tr BGCOLOR=\"203,230,254\">\n");
							total_chk = "Y";
						} else if(!(cust_ctrl_cd).equals("") && (cust_grp_id).equals("")){	// Yield Group별 TTL
							sbufXML.append("<tr BGCOLOR=\"232,255,198\">\n");
							total_chk = "G";
					    } else if((rlane_cd).equals("")){	// Sub Trade TTL
							sbufXML.append("<tr BGCOLOR=\"223,232,247\">\n");
							total_chk = "S";
					    } else if((cust_grp_id).equals("GTTL")){		// 하단 SUM
							sbufXML.append("<tr BGCOLOR=\"255,255,221\">\n");
					    } else {
							sbufXML.append("<tr>\n");
							total_chk = "N";
						}
						
						sbufXML.append("<td>" + trd_cd + "</td>\n");
						sbufXML.append("<td>" + (ofc_cd.equals("")?"Trade":ofc_cd) + "</td>\n");
						sbufXML.append("<td>" + (sub_trd_cd.equals("")?"TTL":sub_trd_cd) + "</td>\n");
						
						if(total_chk.equals("S")){
							sbufXML.append("<td>" + sub_trd_cd + " TTL"  + "</td>\n");
						}else {
							sbufXML.append("<td>" + rlane_cd  + "</td>\n");
						}
						
						if((cust_grp_id).equals("XX999999") || (!(ofc_cd).equals("") && (sub_trd_cd).equals(""))) {
							if((cust_grp_id).equals("XX999999") && (cust_cnt_cd).equals("")){
								sbufXML.append("<td>" + cust_ctrl_cd + "</td>\n");
								sbufXML.append("<td>Other (+)</td>\n");
								sbufXML.append("<td>cust_grp_id</td>\n");
								sbufXML.append("<td>Other</td>\n");
								sbufXML.append("<td INDENT='1'> </td>\n");
								sbufXML.append("<td></td>\n");
								sbufXML.append("<td>cust_no</td>\n");
								sbufXML.append("<td INDENT='1'> </td>\n");
								sbufXML.append("<td INDENT='1'> </td>\n");
								sbufXML.append("<td></td>\n");
							} else {
								sbufXML.append("<td>" + cust_ctrl_cd + "</td>\n");
								
								if(total_chk.equals("Y")) {
									sbufXML.append("<td></td>\n");
									sbufXML.append("<td>cust_grp_id</td>\n");
									sbufXML.append("<td>Office TTL</td>\n");
									sbufXML.append("<td INDENT='" + (cust_clss.equals("")?1:0) + "'>" + cust_clss + "</td>\n");
									sbufXML.append("<td></td>\n");
									sbufXML.append("<td>cust_no</td>\n");
									sbufXML.append("<td INDENT='" + (sc_no.equals("")?1:0) + "'>" + sc_no + "</td>\n");
									sbufXML.append("<td INDENT='" + (rfa_no.equals("")?1:0) + "'>" + rfa_no + "</td>\n");
									sbufXML.append("<td>" + acct_tp + "</td>\n");
								} else {
									sbufXML.append("<td><![CDATA[" + oth_cust_nm + "]]></td>\n");
									sbufXML.append("<td>cust_grp_id</td>\n");
									sbufXML.append("<td>Other Detail</td>\n");
									sbufXML.append("<td INDENT='" + (cust_clss.equals("")?1:0) + "'>" + cust_clss + "</td>\n");
									sbufXML.append("<td></td>\n");
									sbufXML.append("<td>cust_no</td>\n");
									sbufXML.append("<td INDENT='" + (sc_no.equals("")?1:0) + "'>" + sc_no + "</td>\n");
									sbufXML.append("<td INDENT='" + (rfa_no.equals("")?1:0) + "'>" + rfa_no + "</td>\n");
									sbufXML.append("<td></td>\n");
								}
								
							}
						} else if((ofc_cd).equals("")){							
							
							sbufXML.append("<td>" + cust_ctrl_cd + "</td>\n");
							sbufXML.append("<td></td>\n");
							sbufXML.append("<td>cust_grp_id</td>\n");
							sbufXML.append("<td>TTL</td>\n");
							sbufXML.append("<td></td>\n");
							sbufXML.append("<td></td>\n");
							sbufXML.append("<td>cust_no</td>\n");
							sbufXML.append("<td></td>\n");
							sbufXML.append("<td></td>\n");
							sbufXML.append("<td></td>\n");
						} else {							
							
							sbufXML.append("<td>" + cust_ctrl_cd + "</td>\n");
							
							if(total_chk.equals("G")) {
								sbufXML.append("<td>" + cust_ctrl_cd + " TTL</td>\n");
								sbufXML.append("<td>cust_grp_id</td>\n");
								sbufXML.append("<td>Group TTL</td>\n");
							} else {
								sbufXML.append("<td><![CDATA[" + ((cust_grp_nm).equals("")?cust_nm.replace("|", ","):cust_grp_nm) + "]]></td>\n");
								sbufXML.append("<td>" + cust_grp_id + "</td>\n");
								sbufXML.append("<td>Main</td>\n");
							}
							sbufXML.append("<td INDENT='" + (cust_clss.equals("")?1:0) + "'>" + cust_clss + "</td>\n");
							sbufXML.append("<td><![CDATA[" + ((cust_grp_nm).equals("")?cust_grp_nm:cust_nm.replace("|", ",")) + "]]></td>\n");
							sbufXML.append("<td>" + cust_no + "</td>\n");
							sbufXML.append("<td INDENT='" + (sc_no.equals("")?1:0) + "'>" + sc_no + "</td>\n");
							sbufXML.append("<td INDENT='" + (rfa_no.equals("")?1:0) + "'>" + rfa_no + "</td>\n");
							sbufXML.append("<td>" + acct_tp + "</td>\n");
						}
						
						sbufXML.append("<td INDENT='" + (ctrt_ofc.equals("")?1:0) + "'>" + ctrt_ofc + "</td>\n");
						
					}
					
					if(itemv.equals("1")){
						sbufXML.append("<td DATA-FORMAT=\"dfInteger\">" + bkg_avg + "</td>\n");
					}else{
						sbufXML.append("<td DATA-FORMAT=\"dfFloat\">" + bkg_avg + "</td>\n");
					}
					
					
					for(int j=1; j <= duration; j++){
						String temp1 = "";
						String temp2 = "";
						String temp3 = "";
						String temp4 = "";
//						String temp5 = "";
						String temp6 = "";
						String temp7 = "";
						String temp8 = "";
						String temp9 = "";
						
						
						switch(j){
						case 1: 
							temp1 = viewList.get(i).getVvd1();
							temp2 = viewList.get(i).getMaxQty11();
							temp3 = viewList.get(i).getFct11();
							temp4 = viewList.get(i).getBkg11();
//							temp5 = viewList.get(i).getBkgAvgQty11();
							temp6 = viewList.get(i).getCfct11();
							temp7 = viewList.get(i).getCm11();
							temp8 = viewList.get(i).getCmb11();
							temp9 = viewList.get(i).getRatio11();
							break;
						case 2: 
							temp1 = viewList.get(i).getVvd2();
							temp2 = viewList.get(i).getMaxQty21();
							temp3 = viewList.get(i).getFct21();
							temp4 = viewList.get(i).getBkg21();
//							temp5 = viewList.get(i).getBkgAvgQty21();
							temp6 = viewList.get(i).getCfct21();
							temp7 = viewList.get(i).getCm21();
							temp8 = viewList.get(i).getCmb21();
							temp9 = viewList.get(i).getRatio21();
							break;
						case 3: 
							temp1 = viewList.get(i).getVvd3();
							temp2 = viewList.get(i).getMaxQty31();
							temp3 = viewList.get(i).getFct31();
							temp4 = viewList.get(i).getBkg31();
//							temp5 = viewList.get(i).getBkgAvgQty31();
							temp6 = viewList.get(i).getCfct31();
							temp7 = viewList.get(i).getCm31();
							temp8 = viewList.get(i).getCmb31();
							temp9 = viewList.get(i).getRatio31();
							break;
						case 4: 
							temp1 = viewList.get(i).getVvd4();
							temp2 = viewList.get(i).getMaxQty41();
							temp3 = viewList.get(i).getFct41();
							temp4 = viewList.get(i).getBkg41();
//							temp5 = viewList.get(i).getBkgAvgQty41();
							temp6 = viewList.get(i).getCfct41();
							temp7 = viewList.get(i).getCm41();
							temp8 = viewList.get(i).getCmb41();
							temp9 = viewList.get(i).getRatio41();
							break;
						case 5: 
							temp1 = viewList.get(i).getVvd5();
							temp2 = viewList.get(i).getMaxQty51();
							temp3 = viewList.get(i).getFct51();
							temp4 = viewList.get(i).getBkg51();
//							temp5 = viewList.get(i).getBkgAvgQty51();
							temp6 = viewList.get(i).getCfct51();
							temp7 = viewList.get(i).getCm51();
							temp8 = viewList.get(i).getCmb51();
							temp9 = viewList.get(i).getRatio51();
							break;
						case 6: 
							temp1 = viewList.get(i).getVvd6();
							temp2 = viewList.get(i).getMaxQty61();
							temp3 = viewList.get(i).getFct61();
							temp4 = viewList.get(i).getBkg61();
//							temp5 = viewList.get(i).getBkgAvgQty61();
							temp6 = viewList.get(i).getCfct61();
							temp7 = viewList.get(i).getCm61();
							temp8 = viewList.get(i).getCmb61();
							temp9 = viewList.get(i).getRatio61();
							break;
						}
						
						if(total_chk.equals("Y")||total_chk.equals("G")||total_chk.equals("S")) {
							sbufXML.append("<td DATA-FORMAT=\"dfNone\"></td>\n");
						} else {
							sbufXML.append("<td DATA-FORMAT=\"dfNone\">" + temp1 + "</td>\n");
						}
						
						if(itemv.equals("1")){
							sbufXML.append("<td DATA-FORMAT=\"dfInteger\">" + temp2 + "</td>\n");
							sbufXML.append("<td DATA-FORMAT=\"dfInteger\">" + temp3 + "</td>\n");
							sbufXML.append("<td DATA-FORMAT=\"dfInteger\">" + temp4 + "</td>\n");
							sbufXML.append("<td DATA-FORMAT=\"dfInteger\">" + temp7 + "</td>\n");
							sbufXML.append("<td DATA-FORMAT=\"dfInteger\">" + temp8 + "</td>\n");							
							//sbufXML.append("<td DATA-FORMAT=\"dfInteger\">" + temp5 + "</td>\n");
							sbufXML.append("<td DATA-FORMAT=\"dfInteger\">" + temp6 + "</td>\n");
							sbufXML.append("<td DATA-FORMAT=\"dfNullInteger\">" + temp9 + "</td>\n");
						} else {
							sbufXML.append("<td DATA-FORMAT=\"dfFloat\">" + temp2 + "</td>\n");
							sbufXML.append("<td DATA-FORMAT=\"dfFloat\">" + temp3 + "</td>\n");
							sbufXML.append("<td DATA-FORMAT=\"dfFloat\">" + temp4 + "</td>\n");
							sbufXML.append("<td DATA-FORMAT=\"dfFloat\">" + temp7 + "</td>\n");
							sbufXML.append("<td DATA-FORMAT=\"dfFloat\">" + temp8 + "</td>\n");
							//sbufXML.append("<td DATA-FORMAT=\"dfFloat\">" + temp5 + "</td>\n");
							sbufXML.append("<td DATA-FORMAT=\"dfFloat\">" + temp6 + "</td>\n");
							sbufXML.append("<td DATA-FORMAT=\"dfNullFloat\">" + temp9 + "</td>\n");
						}
						
					}
					if((view_type).equals("ACCT")) {
						sbufXML.append("<td>"+("N".equals(total_chk)&& "".equals(ctrt_ofc)?1:0) + "</td>\n");
						sbufXML.append("<td>"+("N".equals(total_chk)&& !"".equals(ctrt_ofc)?1:("S".equals(total_chk)?1:0)) + "</td>\n");
						sbufXML.append("<td>"+ (cust_grp_id.equals("GTTL")?1:0) + "</td>\n");
					} else {
						sbufXML.append("<td></td>\n");
						sbufXML.append("<td></td>\n");
						sbufXML.append("<td></td>\n");
					}
					sbufXML.append("<td></td>\n");
					sbufXML.append("</tr>\n");
				}
				
			}
		}
		
//		else{		//3.9 데이타가 없는 경우
//			strWeek = strWeek;
//			strFdTd = strFdTd;
//		}
		
		sbufXML.append("</DATA>\n");
		sbufXML.append("<ETC-DATA>\n");
		sbufXML.append("<ETC KEY=\"week\">").append(strWeek.length()>0?strWeek.substring(1):"").append("</ETC>\n");
		sbufXML.append("<ETC KEY=\"fdtd\">").append(strFdTd.length()>0?strFdTd.substring(1):"").append("</ETC>\n");
		sbufXML.append("<ETC KEY=\"itemv\">" + itemv + "</ETC>\n");
		sbufXML.append("</ETC-DATA>\n");
		
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
	
	protected String getETCData(EventResponse eventResponse) {
		return "";
	}
}