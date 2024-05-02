/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchSelfAuditListBackEndJob.java
*@FileTitle : Charge Filtering
*Open Issues :
*Change history :
*@LastModifyDate : 2011.04.19
*@LastModifier : 
*@LastVersion : 1.0
* 2011.04.19
* 1.0 Creation
* ======================================================================
* History
* 2011.05.12 이일민 [CHM-201109862-01] [BKG/DOC] BKG Creation Charge화면의 Self Audit기능 Transaction Time 변경 요청
* 2011.05.18 이일민 소스품질 결함 조치
* 2012.04.26 김진주 [CHM-201216859] [BKG/DOC - Revenue Audit System] 미주발 S/C B/L OFT 자동심사
* 2012.05.23 김진주 [CHM-201216859] [BKG/DOC - Revenue Audit System] 미주발 S/C B/L OFT 자동심사 - SC의 경우 OFT Success로 메세지 변경
* 2012.06.27 김진주 [CHM-201217633] 구주 Hinterland 업무 개선 T/F
* 2012.10.05 조정민 [CHM-201219854] [BKG] BKG 생성시 S/C 에 운임 조회 후 부재시 G/W 메일 SALES REP/PRICING STAFF 전송 기능 추가 
* 2012.11.02 김진주 [CHM-201220005] [BKG/DOC - Revenue Audit System] S/C B/L Surcharge 자동심사 시스템 보완 요청
* 2012.12.24 김진주 [CHM-201220395-04] Add-on management T/F
* 2013.02.04 김진주 [CHM-201322626] [BKG/DOC - Revenue Audit System] SZPBB, HKGBB의 DHF 심사로직 추가
* 2013.05.03 김진주 [CHM-201323001] [BKG/DOC - Revenud Audit System] S/C 적용 B/L 자동심사기능 개발 :: DHF 예외로직 삭제
* 2013.05.10 김진주 [CHM-201323001] [BKG/DOC - Revenud Audit System] S/C 적용 B/L 자동심사기능 개발
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
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.BkgCntrVgmInfoListVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.ScOftAutoratingListVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.SearchRfaOftAutoratingListVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.SearchScOftAutoratingListVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.SearchTaaOftAutoratingListVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.integration.UnmatchBLDBDAO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.RlstSearchSelfAuditListVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.UnmatchBLVO;
import com.hanjin.framework.component.util.code.CodeUtil;
import com.hanjin.framework.support.layer.backend.BackEndCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * Self Audit 리스트를 조회에 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author Sun-Woo, Ryu
 * @see UnmatchBLDBDAO
 * @since J2EE 1.6
 */
public class SearchSelfAuditListBackEndJob extends BackEndCommandSupport {

	private static final long serialVersionUID = 5227169002969712002L;
	private String blNo;
	private String caFlg;
	private SignOnUserAccount account;

	/**
	 * SearchSelfAuditListBackEndJob 생성자<br>
	 * 
	 * @param String blNo
	 * @param String caFlg
	 * @param SignOnUserAccount account
	 * @exception Exception
	 */
	public SearchSelfAuditListBackEndJob(String blNo, String caFlg, SignOnUserAccount account) throws Exception {
		this.blNo = blNo;
		this.caFlg = caFlg;
		this.account = account;
	}

	/**
	 * Self Audit 리스트를 조회한다. <br>
	 *  
	 * @return GeneralEventResponse
	 * @exception Exception
	 */
	public RlstSearchSelfAuditListVO doStart() throws Exception {
		String bkgNo, svcScpCd, ctrtTpCd, scRtTp, hinterFlg;
		UnmatchBLVO unmatchBLVO = null;
		List<UnmatchBLVO> list = null;
		List<UnmatchBLVO> listA1 = null;
		List<UnmatchBLVO> listA2 = null;
		List<UnmatchBLVO> listB = null;
		List<UnmatchBLVO> listC = null;
		List<UnmatchBLVO> listD = null;
		List<UnmatchBLVO> listE = null;
		List<UnmatchBLVO> listF = null;
		List<UnmatchBLVO> listG = null;
		UnmatchBLBC command = new UnmatchBLBCImpl();

		RfaOftAutoRatingBC rfaOftCmd = new RfaOftAutoRatingBCImpl();  // RFA
		TaaOftAutoRatingBC taaOftCmd = new TaaOftAutoRatingBCImpl();  // TAA
		ScOftAutoRatingBC scOftCmd = new ScOftAutoRatingBCImpl();  // SC
		List<SearchRfaOftAutoratingListVO> rfaOftList = null;
		List<SearchTaaOftAutoratingListVO> taaOftList = null;
		List<SearchScOftAutoratingListVO> scOftList = null;
		List<SearchScOftAutoratingListVO> surList = null;

		// AUD_STS_CD 상태 업데이트 : 'CD02456' => M, Y 
		// M (Success) => Y, U (Error) => E 
		String auditResultNm = "";
		String audSts = "";
        CodeUtil cdUtil = CodeUtil.getInstance();
		BlRatingBC blRateCmd = new BlRatingBCImpl();
		String rtAplyDt = ""; // YYYYMMDD 형태
		String passFlg = "N";
		RlstSearchSelfAuditListVO rlstSearchSelfAuditListVO = null;

		try {
			bkgNo = ""; svcScpCd = ""; ctrtTpCd = ""; scRtTp = ""; hinterFlg = "";
			
			unmatchBLVO = command.searchBkgCaFlg(blNo, caFlg);  //B/L No 로 BkgNo 와 ctrt_tp_cd를 조회
            if (unmatchBLVO != null ){	     
            	bkgNo    = unmatchBLVO.getBkgNo().toString();
            	ctrtTpCd = unmatchBLVO.getCtrtTpCd().toString();
            	svcScpCd = unmatchBLVO.getSvcScpCd().toString();
//            	caFlg    = unmatchBLVO.getCaFlg().toString();
            	scRtTp	 = unmatchBLVO.getScRtTp().toString();
            	hinterFlg= unmatchBLVO.getHinterFlg().toString();
            }
            
    		rlstSearchSelfAuditListVO = new RlstSearchSelfAuditListVO();

    		if (ctrtTpCd.equals("R") || ctrtTpCd.equals("S") || ctrtTpCd.equals("T")) {
    			list = new ArrayList<UnmatchBLVO>();
            	rtAplyDt = command.searchAuditRtAplyDt(bkgNo, caFlg);  // AutoratingList, SurchargeAutoratingList 에 필요한 rtAplyDt 조회
            	if (ctrtTpCd.equals("R")) { // RFA
            		if("FIC".equals(hinterFlg)) {
            			rfaOftList = rfaOftCmd.searchRfaFICOftAutoratingList(bkgNo, caFlg, "", rtAplyDt, svcScpCd, "");
            		}else if ("AEE".equals(svcScpCd) && "Y".equals(hinterFlg)) {
        				rfaOftList = rfaOftCmd.searchRfaAEEOftAutoratingList(bkgNo, caFlg, "", rtAplyDt, svcScpCd, "");
        			}else if ("AEW".equals(svcScpCd) && "Y".equals(hinterFlg)) {
        				rfaOftList = rfaOftCmd.searchRfaAEWOftAutoratingList(bkgNo, caFlg, "", rtAplyDt, svcScpCd, "");
        			}else{
        				rfaOftList = rfaOftCmd.searchRfaOftAutoratingList(bkgNo, caFlg, "", rtAplyDt, svcScpCd, "");  // RFA Temp
        			}
            		
            		List<BkgCntrVgmInfoListVO> bkgVGMList = blRateCmd.searchBkgCntrVGMInfoList(bkgNo, caFlg);            		        
    				
            		command.createRfaSurchargeInput(bkgNo, rfaOftCmd.checkVGMForIHCCorrection(rfaOftList, bkgVGMList), account);  // RFA Surcharge를 생성 : 경우의 수만큼  BKG_AUTO_RT_OCN_FRT_TMP 생성
            		command.createRevenueAuditOft();  // RFA RevenueAuditOft를 생성 : BKG_AUTO_RT_OCN_FRT_TMP => BKG_REV_AUD_CHG_TMP 입력
					ScOftAutoratingListVO surCmdVo = new ScOftAutoratingListVO();
					surCmdVo.setBkgNo(bkgNo);
					surCmdVo.setCaFlg(caFlg);
					surCmdVo.setRtAplyDt(rtAplyDt);
					surCmdVo.setsvcScpCd(svcScpCd);
					surCmdVo.setCtrtTpCd(ctrtTpCd);
					surCmdVo.setRtAudTpCd("A");
            		surList = scOftCmd.searchSurchargeAutoratingList(surCmdVo);  // surchargeautorating 등록
            		command.createRevenueAuditSurcharge(surList, account);  // BKG_REV_AUD_CHG_TMP 생성
            		           		
            		// Self Audit RFA 리스트
            		int cnt = 0;
            		listA1 = command.checkRfaEffectiveDateDiscrepancy(bkgNo, caFlg); // A1
        			listA2 = command.checkApplicationDateDiscrepancy(bkgNo, caFlg); // A2
        			listB  = command.checkRfaCustomerDiscrepancy(bkgNo, caFlg);     // B    
        			listC  = command.checkRfaCommodityDiscrepancy(bkgNo, caFlg);    // C
        			listD  = command.checkRfaNonchargedBl(bkgNo, caFlg);            // D 
        			listE  = command.checkRfaOftDiscrepancy(bkgNo, caFlg);               // E
        			listF  = command.checkRfaSurchargeDiscrepancy(bkgNo, caFlg, "S");         // F
        			listG  = command.checkAwkwardVoidSlotDiscrepancy(bkgNo, caFlg);         // G
        			passFlg = command.checkTotalBlAmount(bkgNo, caFlg);
        			/* Error Type 이 D or E or F 가 없으면 A2 는  Success 처리 */
        			list.addAll(listA1);
        			if (0<listD.size()) cnt++;
        			if (0<listE.size()) cnt++;
        			if (0<listF.size()) cnt++;
        			if (0<cnt && 0<listA2.size()) list.addAll(listA2);
        			list.addAll(listB);
        			list.addAll(listC);
        			list.addAll(listD);
        			if (0<listE.size() && "N".equals(passFlg)){
        				list.addAll(listE);
        			}
        			listF  = command.checkRfaSurchargeDiscrepancy(bkgNo, caFlg, "Y");         // F
        			if (0<listF.size()) list.addAll(listF);
        			if (0<listG.size()) list.addAll(listG);

        		} else if(ctrtTpCd.equals("S")) {
        			if("X".equals(scRtTp)){
        				list = command.checkScUnmatchBLbyBooking(bkgNo, caFlg, "S"); // S : 화면에 디테일 안보여줌
        			}else{
            			if("TPS".equals(scRtTp)){
            				scOftList = scOftCmd.searchScTPSOftAutoratingList(bkgNo, caFlg, "", rtAplyDt, svcScpCd, "", "A");
            			}else if("TAE".equals(scRtTp)){
            				scOftList = scOftCmd.searchScTAEOftAutoratingList(bkgNo, caFlg, "", rtAplyDt, svcScpCd, "", "A");
            			}else if("TAW".equals(scRtTp)){
            				scOftList = scOftCmd.searchScTAWOftAutoratingList(bkgNo, caFlg, "", rtAplyDt, svcScpCd, "", "A");
            			}else{
            				scOftList = scOftCmd.searchScETCOftAutoratingList(bkgNo, caFlg, "", rtAplyDt, svcScpCd, "", "A");            				
            			}
            			// Self Audit SC 리스트 - 전체
	            		command.createScSurchargeInput(bkgNo, caFlg, scOftList, account);
	            		command.createRevenueAuditOft();
	            		
	            		ScOftAutoratingListVO surCmdVo = new ScOftAutoratingListVO();
	            		surCmdVo.setBkgNo(bkgNo);
	            		surCmdVo.setCaFlg(caFlg);
	            		surCmdVo.setRtAplyDt(rtAplyDt);
	            		surCmdVo.setsvcScpCd(svcScpCd);
	            		surCmdVo.setCtrtTpCd(ctrtTpCd);
	            		surCmdVo.setRtAudTpCd("A");
	            		surList = scOftCmd.searchSurchargeAutoratingList(surCmdVo);
	            		command.createRevenueAuditSurcharge(surList, account);	  
	            		command.modifyORCOTHChargeRate(bkgNo, caFlg); // 특정 SC에 대해 OTH=ORC 호환하여 심사
	            		
	            		list = command.checkScUnmatchBLIncludeOFTbyBooking(bkgNo, caFlg, "S", "N"); //S : 화면에 디테일 안보여줌 , Self audit 시
        			}
                	
        		} else if(ctrtTpCd.equals("T")) {
        			// TAA Temp
        			// searchTaaOftAutoratingList (String bkgNo, String caFlag, String taaNo, String rtaplydt, String scpCd, String cmdtCd) throws EventException;
        			taaOftList = taaOftCmd.searchTaaOftAutoratingList(bkgNo, caFlg, "", rtAplyDt, svcScpCd, "");    
        			// TAA Surcharge를 생성 : 경우의 수만큼 BKG_AUTO_RT_OCN_FRT_TMP 생성, RFA Surcharge 와 다르게 TAA는 'OAR', 'DAR' 없다.
            		command.createTaaSurchargeInput(bkgNo, taaOftList, account);
            		// TAA RevenueAuditOft를 생성 : BKG_AUTO_RT_OCN_FRT_TMP => BKG_REV_AUD_CHG_TMP 입력
            		// RFA 랑 같다.
            		command.createRevenueAuditOft();
            		
            		ScOftAutoratingListVO surCmdVo = new ScOftAutoratingListVO();
            		surCmdVo.setBkgNo(bkgNo);
            		surCmdVo.setCaFlg(caFlg);
            		surCmdVo.setRtAplyDt(rtAplyDt);
            		surCmdVo.setsvcScpCd(svcScpCd);
            		surCmdVo.setCtrtTpCd(ctrtTpCd);
            		surCmdVo.setRtAudTpCd("A");
            		// surchargeautorating 등록            		
            		// RFA 랑 같다.
            		surList = scOftCmd.searchSurchargeAutoratingList(surCmdVo); 
        			// BKG_REV_AUD_CHG_TMP 생성
            		// RFA 랑 같다.
            		command.createRevenueAuditSurcharge(surList, account); 
        			// Self Audit TAA 리스트 - 전체 A ~ F
                	list = command.checkTaaUnmatchBLbyBooking(bkgNo, caFlg, "S"); // S : 화면에 디테일 안보여줌
        		}
        		// 리스트가 조회 건수가 없으면 성공 표시.
        		if (list.size() == 0) {
            		audSts = "Y";
            		auditResultNm = cdUtil.getCodeName("CD02456", "M"); // 성공 코드명.
        		} else if (list.size() > 0) {
        			// 한건의 Error 라도 있으면 Error 표시. 
            		for(int i = 0; i < list.size(); i++) {
            			audSts = "Y";
            			auditResultNm = list.get(i).getMtchUmchTpDesc();
            			log.debug("###########"+(i)+list.get(i).getMtchUmchTpDesc());
               			if(list.get(i).getMtchUmchTpCd().equals("U")) { // Error 건 있으면.
            				audSts = "E";
            				break;
            			}
            		}
        		}
        		// BKG_RATE.AUD_STS_CD 상태 업데이트
        		blRateCmd.modifyAudSts(bkgNo, audSts, account, caFlg);

        		rlstSearchSelfAuditListVO.setAuditResultNm(auditResultNm);
        		rlstSearchSelfAuditListVO.setUnmatchBlVoList(list);
        		rlstSearchSelfAuditListVO.setResult("");
            } else {
				//"Contract Type Code 가 잘못됐습니다"
            	rlstSearchSelfAuditListVO.setResult("Contract Type Code Not Exist");
			}
		} catch(Exception ex) {
	        throw ex;
		}
		return rlstSearchSelfAuditListVO;
	}

}