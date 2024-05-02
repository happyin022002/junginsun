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
* =======================================================*/
package com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.basic;
import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.basic.BlRatingBC;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.basic.BlRatingBCImpl;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.basic.RfaOftAutoRatingBC;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.basic.RfaOftAutoRatingBCImpl;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.basic.ScOftAutoRatingBC;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.basic.ScOftAutoRatingBCImpl;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.basic.TaaOftAutoRatingBC;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.basic.TaaOftAutoRatingBCImpl;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.ScOftAutoratingListVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.SearchRfaOftAutoratingListVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.SearchScOftAutoratingListVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.SearchTaaOftAutoratingListVO;
import com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.integration.UnmatchBLDBDAO;
import com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.vo.RlstSearchSelfAuditListVO;
import com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.vo.UnmatchBLVO;
import com.clt.framework.component.util.code.CodeUtil;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.layer.backend.BackEndCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

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
		RlstSearchSelfAuditListVO rlstSearchSelfAuditListVO = null;

		try {
			bkgNo = ""; svcScpCd = ""; ctrtTpCd = ""; scRtTp = ""; hinterFlg = "";
			
			unmatchBLVO = command.searchBkgCaFlg(blNo, caFlg);  //B/L No 로 BkgNo 와 ctrt_tp_cd를 조회
            if (unmatchBLVO != null ){	     
            	bkgNo    = unmatchBLVO.getBkgNo().toString();
            	ctrtTpCd = unmatchBLVO.getCtrtTpCd().toString();
            	svcScpCd = unmatchBLVO.getSvcScpCd().toString();
//            	caFlg    = unmatchBLVO.getCaFlg().toString();
//            	scRtTp	 = unmatchBLVO.getScRtTp().toString();
//            	hinterFlg= unmatchBLVO.getHinterFlg().toString();
            }
            
    		rlstSearchSelfAuditListVO = new RlstSearchSelfAuditListVO();

    		if (ctrtTpCd.equals("R") || ctrtTpCd.equals("S") || ctrtTpCd.equals("T")) {
    			list = new ArrayList<UnmatchBLVO>();
            	rtAplyDt = command.searchAuditRtAplyDt(bkgNo, caFlg);  // AutoratingList, SurchargeAutoratingList 에 필요한 rtAplyDt 조회
            	if (ctrtTpCd.equals("R")) { // RFA
//            		if("FIC".equals(hinterFlg)) {
//            			rfaOftList = rfaOftCmd.searchRfaFICOftAutoratingList(bkgNo, caFlg, "", rtAplyDt, svcScpCd, "");
//            		}else if ("AEE".equals(svcScpCd) && "Y".equals(hinterFlg)) {
//        				rfaOftList = rfaOftCmd.searchRfaAEEOftAutoratingList(bkgNo, caFlg, "", rtAplyDt, svcScpCd, "");
//        			}else if ("AEW".equals(svcScpCd) && "Y".equals(hinterFlg)) {
//        				rfaOftList = rfaOftCmd.searchRfaAEWOftAutoratingList(bkgNo, caFlg, "", rtAplyDt, svcScpCd, "");
//        			}else{
        				rfaOftList = rfaOftCmd.searchRfaOftAutoratingList(bkgNo, caFlg, "", rtAplyDt, svcScpCd, "");  // RFA Temp
//        			}
    				
            		command.createRfaSurchargeInput(bkgNo, rfaOftList, account);  // RFA Surcharge를 생성 : 경우의 수만큼  BKG_AUTO_RT_OCN_FRT_TMP 생성
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
        			listE  = command.checkRfaSelfOftDiscrepancy(bkgNo, caFlg);               // E
        			listF  = command.checkRfaSelfSurchargeDiscrepancy(bkgNo, caFlg);         // F
//        			listG  = command.checkAwkwardVoidSlotDiscrepancy(bkgNo, caFlg);         // G
        			/* Error Type 이 D or E or F 가 없으면 A2 는  Success 처리 */
        			list.addAll(listA1);
        			if (0<listD.size()) cnt++;
        			if (0<listE.size()) cnt++;
        			if (0<listF.size()) cnt++;
        			if (0<cnt && 0<listA2.size()) list.addAll(listA2);
        			list.addAll(listB);
        			list.addAll(listC);
        			list.addAll(listD);
        			if (0<listE.size()) list.addAll(listE);
        			listF  = command.checkRfaSelfSurchargeDiscrepancy(bkgNo, caFlg);         // F
        			if (0<listF.size()) list.addAll(listF);

        		} else if(ctrtTpCd.equals("S")) {
        			if("X".equals(scRtTp)){
        				list = command.checkScUnmatchBLbyBooking(bkgNo, caFlg, "S"); // S : 화면에 디테일 안보여줌
        			}else{
//            			if("TPS".equals(scRtTp)){
//            				scOftList = scOftCmd.searchScTPSOftAutoratingList(bkgNo, caFlg, "", rtAplyDt, svcScpCd, "", "A");
//            			}else if("TAE".equals(scRtTp)){
//            				scOftList = scOftCmd.searchScTAEOftAutoratingList(bkgNo, caFlg, "", rtAplyDt, svcScpCd, "", "A");
//            			}else if("TAW".equals(scRtTp)){
//            				scOftList = scOftCmd.searchScTAWOftAutoratingList(bkgNo, caFlg, "", rtAplyDt, svcScpCd, "", "A");
//            			}else{
//            				scOftList = scOftCmd.searchScETCOftAutoratingList(bkgNo, caFlg, "", rtAplyDt, svcScpCd, "", "A");            				
//            			}  체크 해야 될듯 XXX
//        				searchScETCOftAutoratingList(String bkgNo, String caFlag, String scNo, String rtAplyDt, String scpCd ,String cmdtCd ) throws EventException{
        				scOftList = scOftCmd.searchScOftAutoratingList(bkgNo, caFlg, "", rtAplyDt, svcScpCd, "");    
            			// Self Audit SC 리스트 - 전체
	            		command.createScSurchargeInput(bkgNo, scOftList, account);
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
//	            		command.modifyORCOTHChargeRate(bkgNo, caFlg); // 특정 SC에 대해 OTH=ORC 호환하여 심사
	            		
	            		list = command.checkScUnmatchBLIncludeSelfOFTbyBooking(bkgNo, caFlg, "S"); //S : 화면에 디테일 안보여줌
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
                	list = command.checkTaaSelfBLbyBooking(bkgNo, caFlg, "S"); // S : 화면에 디테일 안보여줌
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
