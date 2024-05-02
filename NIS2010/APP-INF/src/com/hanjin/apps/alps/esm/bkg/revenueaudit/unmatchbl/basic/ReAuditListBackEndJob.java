/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ReAuditListBackEndJob.java
*@FileTitle : Charge Filtering
*Open Issues :
*Change history :
*@LastModifyDate : 2014.02.13
*@LastModifier : 
*@LastVersion : 1.0
* 2014.02.13
* 1.0 Creation
* ======================================================================
* History
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.basic;
import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.basic.BlRatingBC;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.basic.BlRatingBCImpl;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.basic.RfaOftAutoRatingBC;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.basic.RfaOftAutoRatingBCImpl;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.basic.ScOftAutoRatingBC;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.basic.ScOftAutoRatingBCImpl;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.basic.TaaOftAutoRatingBC;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.basic.TaaOftAutoRatingBCImpl;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.ScOftAutoratingListVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.SearchRfaOftAutoratingListVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.SearchScOftAutoratingListVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.SearchTaaOftAutoratingListVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.integration.UnmatchBLDBDAO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.UnmatchBLVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.layer.backend.BackEndCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * Re Audit 리스트를 조회에 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author Jin-joo, Kim
 * @see UnmatchBLDBDAO
 * @since J2EE 1.6
 */
public class ReAuditListBackEndJob extends BackEndCommandSupport {

	private static final long serialVersionUID = -1149789439988228547L;
	private String[] bkgNoArr;
	private SignOnUserAccount account;

	/**
	 * SearchSelfAuditListBackEndJob 생성자<br>
	 * 
	 * @param String[] bkgNoArr
	 * @param SignOnUserAccount account
	 * @exception Exception
	 */
	public ReAuditListBackEndJob(String[] bkgNoArr, SignOnUserAccount account) throws Exception {
		this.bkgNoArr = bkgNoArr;
		this.account = account;
	}

	/**
	 * Self Audit 리스트를 조회한다. <br>
	 *  
	 * @return GeneralEventResponse
	 * @exception Exception
	 */ 
	public String doStart() throws Exception {
		String bkgStsCd, bkgNo, ctrtTpCd, corrNo, svcScpCd, scRtTp, hinterFlg;
		String maxUmchBkgSeq = "0";
		String tmpMtchUmchTpCd;
		boolean isExitUmnch = false;
		boolean isEquals = false; 
		List<UnmatchBLVO> listBkgStatus = null;
		List<UnmatchBLVO> unmatchList = null;
		List<UnmatchBLVO> listA1 = null;
		List<UnmatchBLVO> listA2 = null;
		List<UnmatchBLVO> listB = null;
		List<UnmatchBLVO> listC = null;
		List<UnmatchBLVO> listD = null;
		List<UnmatchBLVO> listE = null;
		List<UnmatchBLVO> listF = null;
		List<UnmatchBLVO> listG = null;
		String comp1Cnt = "0";
		String comp2Cnt = "0";
		String comp3Cnt = "0";
		String passFlg = "N";
		UnmatchBLVO modParamVo = null;
		//EsmBkg0256Event event = (EsmBkg0256Event) e;
		UnmatchBLBC command = new UnmatchBLBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		// RFA
		RfaOftAutoRatingBC rfaOftCmd = new RfaOftAutoRatingBCImpl();
		List<SearchRfaOftAutoratingListVO> rfaOftList = null;
		// TAA
		TaaOftAutoRatingBC taaOftCmd = new TaaOftAutoRatingBCImpl();
		List<SearchTaaOftAutoratingListVO> taaOftList = null;
		// SC, Surcharge
		ScOftAutoRatingBC scOftCmd = new ScOftAutoRatingBCImpl();
		List<SearchScOftAutoratingListVO> scOftList = null;
		List<SearchScOftAutoratingListVO> surList = null;
		//
		BlRatingBC blCmd = new BlRatingBCImpl();
		
		String rtAplyDt = ""; // YYYYMMDD 형태
		
		try {
			
			bkgStsCd = ""; ctrtTpCd = ""; corrNo = ""; svcScpCd = ""; scRtTp = ""; hinterFlg = "";
			
			for(int i = 0; i < bkgNoArr.length; i++) {
				
				bkgNo = bkgNoArr[i];
				
				rfaOftList = null;
				taaOftList = null;
				scOftList = null;
				surList = null;
				
				isExitUmnch = false;
				//bkg_no 로ctrt_tp_cd, caFlg 를 조회
				listBkgStatus = command.searchBkgStatus(bkgNo);
				
	            if (listBkgStatus != null && listBkgStatus.size() !=0 && listBkgStatus.get(0) != null){	     
	            	bkgStsCd = listBkgStatus.get(0).getBkgStsCd().toString();
	            	ctrtTpCd = listBkgStatus.get(0).getCtrtTpCd().toString();
	            	corrNo   = listBkgStatus.get(0).getCorrNo().toString();
	            	svcScpCd = listBkgStatus.get(0).getSvcScpCd().toString();
	            	scRtTp	 = listBkgStatus.get(0).getScRtTp().toString();
	            	hinterFlg= listBkgStatus.get(0).getHinterFlg().toString();
	            }
	            
	            //param, bkg_no set
	            modParamVo = new UnmatchBLVO();
            	modParamVo.setBkgNo(bkgNo);	            
            	modParamVo.setCorrNo(corrNo);
            	modParamVo.setBkgStsCd(bkgStsCd);
	            
	            
	            if(bkgStsCd.equals("X")) {
	            	
	            	//BKG_STS_CD 가 'X' 일때,
	                //또는 A ~ F 까지 Unmatch 가 하나도 없을때.. ( 'U' 가 하나도 없을때 )
	            	//REV_AUD_STL_KND_CD => DECODE(:bkg_sts_cd, 'X', 'C', 'A' )  ,
	            	modParamVo.setRevAudStlKndCd("C");
	        		command.modifyReauditUnmatchBLStatus(modParamVo, account);
	        		
	            } else {
	            	
	            	// AutoratingList, SurchargeAutoratingList 에 필요한 rtAplyDt 조회
	            	rtAplyDt = command.searchAuditRtAplyDt(bkgNo, "N");

	            	if( ctrtTpCd.equals("R") || ctrtTpCd.equals("S") || ctrtTpCd.equals("T") ) { 
	            		
	            		if(ctrtTpCd.equals("R")){ // RFA
		            		
	            			// RFA Temp
	            			// searchRfaOftAutoratingList (String bkgNo, String caFlag,String rfaNo, String Rtaplydt, String scpCd, String cmdtCd) throws EventException;
	            			if("FIC".equals(hinterFlg)){
	            				rfaOftList = rfaOftCmd.searchRfaFICOftAutoratingList(bkgNo, "N", "", rtAplyDt, svcScpCd, "");
	            			}else if("AEE".equals(svcScpCd) && "Y".equals(hinterFlg)) {
	            				rfaOftList = rfaOftCmd.searchRfaAEEOftAutoratingList(bkgNo, "N", "", rtAplyDt, svcScpCd, "");
	            			}else if("AEW".equals(svcScpCd) && "Y".equals(hinterFlg)){
	            				rfaOftList = rfaOftCmd.searchRfaAEWOftAutoratingList(bkgNo, "N", "", rtAplyDt, svcScpCd, "");
	            			}else{
	            				rfaOftList = rfaOftCmd.searchRfaOftAutoratingList(bkgNo, "N", "", rtAplyDt, svcScpCd, "");
		            			
	            			}
	            			// RFA Surcharge를 생성 : 경우의 수만큼  BKG_AUTO_RT_OCN_FRT_TMP 생성
		            		command.createRfaSurchargeInput(bkgNo, rfaOftList, account);
		            		// RFA RevenueAuditOft를 생성 : BKG_AUTO_RT_OCN_FRT_TMP => BKG_REV_AUD_CHG_TMP 입력		            		
		            		command.createRevenueAuditOft();
	            			
		            		ScOftAutoratingListVO surCmdVo = new ScOftAutoratingListVO();
		            		surCmdVo.setBkgNo(bkgNo);
		            		surCmdVo.setCaFlg("N");
		            		surCmdVo.setRtAplyDt(rtAplyDt);
		            		surCmdVo.setsvcScpCd(svcScpCd);
		            		surCmdVo.setCtrtTpCd(ctrtTpCd);
		            		surCmdVo.setRtAudTpCd("A");
		            		// surchargeautorating 등록		            		
		            		surList = scOftCmd.searchSurchargeAutoratingList(surCmdVo);
		        			// BKG_REV_AUD_CHG_TMP 생성	            			
	            			command.createRevenueAuditSurcharge(surList, account);	  
	            			                	    
	            			// Self Audit RFA 리스트 - 전체
//		            		unmatchList = command.checkRfaUnmatchBLbyBooking(bkgNo, "N", "C"); // C : 데이터 생성시 디테일 가져옴.

	                		int cnt = 0;
	                		listA1 = command.checkRfaEffectiveDateDiscrepancy(bkgNo, "N"); // A1
	            			listA2 = command.checkApplicationDateDiscrepancy(bkgNo, "N"); // A2
	            			listB  = command.checkRfaCustomerDiscrepancy(bkgNo, "N");     // B    
	            			listC  = command.checkRfaCommodityDiscrepancy(bkgNo, "N");    // C
	            			listD  = command.checkRfaNonchargedBl(bkgNo, "N");            // D 
	            			listE  = command.checkRfaOftDiscrepancy(bkgNo, "N");          // E
	            			listF  = command.checkRfaSurchargeDiscrepancy(bkgNo, "N", "C");    // F
	            			listG  = command.checkAwkwardVoidSlotDiscrepancy(bkgNo, "N"); // G
	            			passFlg = command.checkTotalBlAmount(bkgNo, "N");

	            			/* Error Type 이 D or E or F 가 없으면 A2 는  Success 처리 */
	            			unmatchList = new ArrayList<UnmatchBLVO>();
	            			unmatchList.addAll(listA1);
	            			if (0<listD.size()) cnt++;
	            			if (0<listE.size()) cnt++;
	            			if (0<listF.size()) cnt++;
	            			if (0<cnt && 0<listA2.size()) unmatchList.addAll(listA2);
	            			unmatchList.addAll(listB);
	            			unmatchList.addAll(listC);
	            			unmatchList.addAll(listD);
	            			if (0<listE.size() && "N".equals(passFlg)) {
	            				unmatchList.addAll(listE);
	            				if (listE.get(0).getMtchUmchTpCd().equals("U")) {
	            					unmatchList.addAll(command.checkRfaOftDiscrepancyDetail(bkgNo, "N")); // E Detail  
	            				}
	            			}
	            			if (0<listF.size()) {
	            				unmatchList.addAll(listF);
		        				if (listF.get(0).getMtchUmchTpCd().equals("U")) {
		        					unmatchList.addAll(command.checkRfaSurchargeDiscrepancyDetail(bkgNo, "N")); // F Detail
	            				}
	            			}
	            			unmatchList.addAll(listG);
	            			
	            		}else if(ctrtTpCd.equals("S")){ // SC 
	            			if("X".equals(scRtTp)){
	            				// Self Audit SC 리스트 - 전체	            			
			            		unmatchList = command.checkScUnmatchBLbyBooking(bkgNo, "N", "C"); // C : 데이터 생성시 디테일 가져옴.
	            			}else{
	            				if("TPS".equals(scRtTp)){
	            					scOftList = scOftCmd.searchScTPSOftAutoratingList(bkgNo, "N", "", rtAplyDt, svcScpCd, "", "A");
	            				}else if("TAE".equals(scRtTp)){
	            					scOftList = scOftCmd.searchScTAEOftAutoratingList(bkgNo, "N", "", rtAplyDt, svcScpCd, "", "A");
	            				}else if("TAW".equals(scRtTp)){
	            					scOftList = scOftCmd.searchScTAWOftAutoratingList(bkgNo, "N", "", rtAplyDt, svcScpCd, "", "A");
	            				}else{
	            					scOftList = scOftCmd.searchScETCOftAutoratingList(bkgNo, "N", "", rtAplyDt, svcScpCd, "", "A");
	            				}
	            				// Self Audit SC 리스트 - 전체
	    	            		command.createScSurchargeInput(bkgNo, "N", scOftList, account);
	    	            		command.createRevenueAuditOft();
	    	            		
			            		ScOftAutoratingListVO surCmdVo = new ScOftAutoratingListVO();
			            		surCmdVo.setBkgNo(bkgNo);
			            		surCmdVo.setCaFlg("N");
			            		surCmdVo.setRtAplyDt(rtAplyDt);
			            		surCmdVo.setsvcScpCd(svcScpCd);
			            		surCmdVo.setCtrtTpCd(ctrtTpCd);
			            		surCmdVo.setRtAudTpCd("A");
			            		// surchargeautorating 등록		            		
			            		surList = scOftCmd.searchSurchargeAutoratingList(surCmdVo);
			        			// BKG_REV_AUD_CHG_TMP 생성	            			
		            			command.createRevenueAuditSurcharge(surList, account);
		            			command.modifyORCOTHChargeRate(bkgNo, "N"); // 특정 SC에 대해 OTH=ORC 호환하여 심사
	    	            		unmatchList = command.checkScUnmatchBLIncludeOFTbyBooking(bkgNo, "N", "C", "N"); // C : 데이터 생성시 디테일 가져옴.
	            			}
	            			
	            			
		            		
	            		}else if(ctrtTpCd.equals("T")){ // TAA
	            			
	            			// TAA Temp
	            			// searchTaaOftAutoratingList (String bkgNo, String caFlag, String taaNo, String rtaplydt, String scpCd, String cmdtCd) throws EventException;
	            			taaOftList = taaOftCmd.searchTaaOftAutoratingList(bkgNo, "N", "", rtAplyDt, svcScpCd, "");    
	            			// TAA Surcharge를 생성 : 경우의 수만큼 BKG_AUTO_RT_OCN_FRT_TMP 생성, RFA Surcharge 와 다르게 TAA는 'OAR', 'DAR' 없다.	            			
	                		command.createTaaSurchargeInput(bkgNo, taaOftList, account);
		            		// RFA RevenueAuditOft를 생성 : BKG_AUTO_RT_OCN_FRT_TMP => BKG_REV_AUD_CHG_TMP 입력		            		
	                		// RFA 랑 같다.	                		
	                		command.createRevenueAuditOft(); 
	                		
	                		ScOftAutoratingListVO surCmdVo = new ScOftAutoratingListVO();
		            		surCmdVo.setBkgNo(bkgNo);
		            		surCmdVo.setCaFlg("N");
		            		surCmdVo.setRtAplyDt(rtAplyDt);
		            		surCmdVo.setsvcScpCd(svcScpCd);
		            		surCmdVo.setCtrtTpCd(ctrtTpCd);
		            		surCmdVo.setRtAudTpCd("A");
	                		// surchargeautorating 등록            		
	                		// RFA 랑 같다.
	                		surList = scOftCmd.searchSurchargeAutoratingList(surCmdVo);
	            			// BKG_REV_AUD_CHG_TMP 생성
	                		// RFA 랑 같다.
	                		command.createRevenueAuditSurcharge(surList, account); // RFA 랑 같다.
	                			            			
	            			// Self Audit TAA 리스트 - 전체
		            		unmatchList = command.checkTaaUnmatchBLbyBooking(bkgNo, "N", "C"); // C : 데이터 생성시 디테일 가져옴.
		            		
	            		}
	            		
			            // Umatch 유무확인.
	            		if (unmatchList != null && unmatchList.size() !=0 && unmatchList.get(0) != null){	     
		            		for(int u = 0; u < unmatchList.size(); u++) {
		            			tmpMtchUmchTpCd = unmatchList.get(u).getMtchUmchTpCd();
		            			if(null == tmpMtchUmchTpCd) { tmpMtchUmchTpCd = ""; }
		            			if(tmpMtchUmchTpCd.equals("U")) {
		            				isExitUmnch = true;
		            				break;
		            			}
		            			
		            		}
			            }
		            	
    	            	//BKG_STS_CD 가 'X' 일때,
    	                //또는 A ~ F 까지 Unmatch 가 하나도 없을때.. ( 'U' 가 하나도 없을때 )
    	            	//REV_AUD_STL_KND_CD => DECODE(:bkg_sts_cd, 'X', 'C', 'A' )  ,
	            		if(!isExitUmnch){
	            			
	    	            	modParamVo.setRevAudStlKndCd("A");
	    	        		command.modifyReauditUnmatchBLStatus(modParamVo, account);
	    	        		
	            		} else { // Unmatch 가 존재
	            		
			            	// 비교 데이터 생성위한 maxseq 
		            		maxUmchBkgSeq = command.searchMaxUmchBkgSeq(modParamVo, account);
				            
			            	//param
			            	modParamVo.setMaxUmchBkgSeq(maxUmchBkgSeq); // maxseq 넣어준다.
			            	modParamVo.setRevAudStsCd("U");
			            	modParamVo.setRevAudTpCd("R"); // 화면에서는 R, 배치에서 실행시 B
			            	
				            // 비교 데이터 생성
			            	command.addCompareBkgRevUmchAll(modParamVo, unmatchList, account); // bkg, itm, itm dtl
			            	
				            // 비교 1, 2, 3
			            	comp1Cnt = command.selectCompareBkgRevUmchBkg(modParamVo);
			            	comp2Cnt = command.selectCompareBkgRevUmchItm(modParamVo);		            
			            	comp3Cnt = command.selectCompareBkgRevUmchItmDtl(modParamVo);
				            if (comp1Cnt.equals("0") && comp2Cnt.equals("0") && comp3Cnt.equals("0")){	    
				            	isEquals = true;
				            }else{
				            	isEquals = false;			            	
				            }
		
			            	if(isEquals) { // 기존 존재하는 Unmatch B/L 과 비교해서 동일하면 : BKG_REV_UMCH_BKG.LST_UMCH_FND_DT 를 갱신
			            		// update 하기전에 비교 데이터 삭제
			            		command.removeCompareBkgRevUmchAll(modParamVo);
			            		// 기존 존재하는 Unmatch B/L 과 비교해서 동일하면 : BKG_REV_UMCH_BKG.LST_UMCH_FND_DT 를 갱신
			            		// LST_UMCH_FND_DT 를 SYSDATE 로 UPDATE ( 단, 바로 이전 UMCH_BKG_SEQ 의 REV_AUD_STS_CD 가 'S' 인 경우는 UPDATE 하지 않는다. )
			            		// 온라인만 : Re-audit 의 결과 UMCH_BKG_SEQ 가 증가되지 않는 않는 경우에도, REV_AUD_TP_CD 를 'R' 로 UPDATE 한다. sql 에서 구분함.
			            		command.modifyCompareBkgRevUmchBkgFndDt(modParamVo, account);
			            	}else{ 
			            		// 기존 존재하는 Unmatch B/L 과 비교해서 다르면    : MAX(UMCH_BKG_SEQ) + 1 로 신규 DATA INSERT => 이미함
			            		// 신규 생성 자동 커밋
		            			// remark, 금액 update
		            			command.modifyCompareBkgRevUmchBkg(modParamVo);
			            	}
			            	
			            	// 심사일자 up
			            	blCmd.modifyAudDt(bkgNo, "", account);
			            	
	            		}
		            	
		            } else {
		            	
		            	eventResponse.setETCData("result", "Contract Type Code Not Exist");
		            	
		            }
		            
	            }
	            
	            //Autorating및 심사를 위해 저장한 Global Temp Table의 데이터 삭제.
	            //BackEndJob 구조상 begin&commit 사용 불가로 인해 삭제 SQL 추가
	            scOftCmd.manageAutoratingTempTables();
	            
	            
	            
			} // end for

        	//eventResponse.setETCData("result", "");		
			//eventResponse.setRsVoList(list);
            	
		}catch(EventException ex) {
			throw ex;			
		}catch(Exception ex) {
	        throw new EventException(new ErrorHandler("BKG00244",new String[]{}).getMessage(), ex);
		}
		return "Y";
	}

}
