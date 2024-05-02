/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : OwnersAccountBCImpl.java
*@FileTitle : Owner's Account
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.18
*@LastModifier : 손진환
*@LastVersion : 1.0
* 2016.02.18 손진환
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.ownersaccount.basic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hanjin.apps.alps.esm.fms.fmscommon.fmsfileupload.vo.FileUploadListVO;
import com.hanjin.apps.alps.esm.fms.ownersaccount.integration.OwnersAccountDBDAO;
import com.hanjin.apps.alps.esm.fms.ownersaccount.vo.CancelSlipVO;
import com.hanjin.apps.alps.esm.fms.ownersaccount.vo.CondOwnrAcctForCnclVO;
import com.hanjin.apps.alps.esm.fms.ownersaccount.vo.FmsConsultationVO;
import com.hanjin.apps.alps.esm.fms.ownersaccount.vo.FmsCsulSlpVO;
import com.hanjin.apps.alps.esm.fms.ownersaccount.vo.FmsOwnrAcctSlpVO;
import com.hanjin.apps.alps.esm.fms.ownersaccount.vo.OwnrCurrVO;
import com.hanjin.apps.alps.esm.fms.ownersaccount.vo.SearchApSlipDetailListVO;
import com.hanjin.apps.alps.esm.fms.ownersaccount.vo.SearchOwnrAcctForCnclListVO;
import com.hanjin.apps.alps.esm.fms.ownersaccount.vo.searchFinancialVVDForOtherOffcVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.integration.TCharterIOConsultationDBDAO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.integration.TCharterIOConsultationEAIDAO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomSlipApprovalDetailVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomSlipApprovalHeaderVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomTaxDtlVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomTaxVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchApSlipInterfaceListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchSlipApprovalOfficeVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchSlipApprovalOwnerVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.config.SiteConfigFactory;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.ApInvHdrVO;
import com.hanjin.apps.alps.esm.fms.ownersaccount.vo.OwnrAcctListVO;
import com.hanjin.apps.alps.esm.fms.ownersaccount.vo.OwnrAcctVO;
import com.hanjin.bizcommon.approval.integration.ApprovalDBDAO;
import com.hanjin.bizcommon.approval.vo.ApPayInvVO;
import com.hanjin.bizcommon.approval.vo.ApprovalCsrVO;

/**
 * Common CSR Business Logic Basic Command implementation<br> - Common CSR에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author Jung Ho Min
 * @see 
 * @since J2EE 1.4
 */


public class OwnersAccountBCImpl extends BasicCommandSupport implements OwnersAccountBC {

	// Database Access Object
	private transient OwnersAccountDBDAO dbDao = null;	
	private transient TCharterIOConsultationDBDAO tCIOdbDao = null;
	private transient TCharterIOConsultationEAIDAO eaiDao = null;
	
	/**
	 * OwnersAccountBCImpl 객체 생성<br>
	 * OwnersAccountDBDAO를 생성한다.<br>
	 */
	public OwnersAccountBCImpl() {
		dbDao = new OwnersAccountDBDAO();
		tCIOdbDao = new TCharterIOConsultationDBDAO();
		eaiDao = new TCharterIOConsultationEAIDAO();
	}
	
	/**
	 * [Owner's Account Consultation / Slip]을 [Save] 합니다.<br>
	 * 
	 * @param FmsConsultationVO fmsConsultationVO
	 * @param FmsCsulSlpVO[] fmsCsulSlpVOs
	 * @param SignOnUserAccount signOnUserAccount
	 * @param CustomTaxVO[] customTaxVOs
	 * @param CustomTaxDtlVO[] customTaxDtlVOs
	 * @return String
	 * @exception EventException
	 */
	public String manageOwnersAccountSlip(FmsConsultationVO fmsConsultationVO, FmsCsulSlpVO[] fmsCsulSlpVOs, SignOnUserAccount signOnUserAccount, CustomTaxVO[] customTaxVOs, CustomTaxDtlVO[] customTaxDtlVOs) throws EventException {
		try {

			String sFlg = fmsConsultationVO.getsFlg();			
			String slpSerNo = "";			
			
			
			// AP_OFC_CD 산출
			String apOfcCd = fmsConsultationVO.getSlpOfcCd();
			
			fmsConsultationVO.setSlpOfcCd(dbDao.searchApOfcCd(apOfcCd, signOnUserAccount.getUsr_id()));
			
			if("".equals(fmsConsultationVO.getSlpOfcCd())) {
				return slpSerNo;
			}
			
			if(!"".equals(sFlg)){ // sFlg 값이 있으면 Inquiry나 기타화면에서 Entry로 팝업호출 시 E / C / R / D / ESM_FMS_0101중에 하나 들어옴. 값이있으면 수정할 수 있음
				fmsConsultationVO.setSlpSerNo(fmsConsultationVO.getOrgSlpSerNo());
				fmsConsultationVO.setOaInvDt(fmsConsultationVO.getOaInvDt().replaceAll("-", ""));
				fmsConsultationVO.setEffDt(fmsConsultationVO.getEffDt().replaceAll("-", ""));
//				fmsConsultationVO.setSlpIssDt(fmsConsultationVO.getSlpIssDt().replaceAll("-", "").substring(2,8));
				fmsConsultationVO.setSlpIssDt(fmsConsultationVO.getSlpIssDt());				
				fmsConsultationVO.setRqstDt(fmsConsultationVO.getRqstDt().replaceAll("-", ""));
				fmsConsultationVO.setUpdUsrId(signOnUserAccount.getUsr_id());
				
				fmsConsultationVO.setCxlFlg("N");
				
				dbDao.modifyOwnersAccountMaster(fmsConsultationVO);
				slpSerNo = fmsConsultationVO.getOrgSlpSerNo();
				
			}else{
				// 전표 생성 번호 저장
				slpSerNo = dbDao.searchCsulSlpSeq(fmsConsultationVO.getSlpTpCd(), fmsConsultationVO.getSlpFuncCd(), fmsConsultationVO.getSlpOfcCd());
				
				log.debug("slpSerNo = "+slpSerNo);
				
				fmsConsultationVO.setSlpSerNo(slpSerNo);
				fmsConsultationVO.setOaInvDt(fmsConsultationVO.getOaInvDt().replaceAll("-", ""));
				fmsConsultationVO.setEffDt(fmsConsultationVO.getEffDt().replaceAll("-", ""));
				log.debug("\r\nfmsConsultationVO.getSlpIssDt() : " + fmsConsultationVO.getSlpIssDt());
				fmsConsultationVO.setSlpIssDt(fmsConsultationVO.getSlpIssDt().replaceAll("-", "").substring(2,8));
				fmsConsultationVO.setRqstDt(fmsConsultationVO.getRqstDt().replaceAll("-", ""));
				fmsConsultationVO.setCsrUsrId(signOnUserAccount.getUsr_id());
				fmsConsultationVO.setUpdUsrId(signOnUserAccount.getUsr_id());
				fmsConsultationVO.setCreUsrId(signOnUserAccount.getUsr_id());
				
				fmsConsultationVO.setCxlFlg("N");
				
				if (slpSerNo.equals("00001")) {
					dbDao.addCsulSlpSeq(fmsConsultationVO.getSlpTpCd(), fmsConsultationVO.getSlpFuncCd(), fmsConsultationVO.getSlpOfcCd(), slpSerNo, signOnUserAccount.getUsr_id());
				} else {
					dbDao.modifyCsulSlpSeq(fmsConsultationVO.getSlpTpCd(), fmsConsultationVO.getSlpFuncCd(), fmsConsultationVO.getSlpOfcCd(), slpSerNo, signOnUserAccount.getUsr_id());
				}
				
				dbDao.addOwnersAccountMaster(fmsConsultationVO);
			}
			
//---------------------------------------------------------------------------------			
			log.debug("\r\nsFlg : " + sFlg + " | slpSerNo : " + slpSerNo);
		
			List<FmsCsulSlpVO> insertVoList = new ArrayList<FmsCsulSlpVO>();
			List<FmsCsulSlpVO> updateVoList = new ArrayList<FmsCsulSlpVO>();
			List<FmsCsulSlpVO> deleteVoList = new ArrayList<FmsCsulSlpVO>();
						
			if(fmsCsulSlpVOs != null) {
				for ( int  i =0; i < fmsCsulSlpVOs.length; i++ ) {
					fmsCsulSlpVOs[i].setSlpTpCd(fmsConsultationVO.getSlpTpCd());
					fmsCsulSlpVOs[i].setSlpFuncCd(fmsConsultationVO.getSlpFuncCd());
					fmsCsulSlpVOs[i].setSlpOfcCd(fmsConsultationVO.getSlpOfcCd());
					fmsCsulSlpVOs[i].setSlpIssDt(fmsConsultationVO.getSlpIssDt());
					fmsCsulSlpVOs[i].setSlpSerNo(fmsConsultationVO.getSlpSerNo());
					fmsCsulSlpVOs[i].setCsrCurrCd(fmsConsultationVO.getCsrCurrCd());
					fmsCsulSlpVOs[i].setCreUsrId(signOnUserAccount.getUsr_id());
					fmsCsulSlpVOs[i].setUpdUsrId(signOnUserAccount.getUsr_id());
					
					if ( fmsCsulSlpVOs[i].getIbflag().equals("I")){
						insertVoList.add(fmsCsulSlpVOs[i]);
						
					} else if ( fmsCsulSlpVOs[i].getIbflag().equals("U")){
						updateVoList.add(fmsCsulSlpVOs[i]);
						
					} else if ( fmsCsulSlpVOs[i].getIbflag().equals("D")){
						deleteVoList.add(fmsCsulSlpVOs[i]);
						
					}					
				}
			}
						
			if ( insertVoList.size() > 0 ) {
				dbDao.addOwnersAccountSlips(insertVoList);
			}						
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyOwnersAccountSlips(updateVoList);
			}			
			if ( deleteVoList.size() > 0 ) {
				dbDao.deleteOwnersAccountSlips(deleteVoList);
			}
//-----------------------------------------------------------------------------------------------------------						
			if(customTaxVOs != null) {
				dbDao.deleteTaxDtl(fmsConsultationVO.getSlpTpCd(), fmsConsultationVO.getSlpFuncCd(), fmsConsultationVO.getSlpOfcCd(), fmsConsultationVO.getSlpIssDt(), slpSerNo);
				dbDao.deleteTax(fmsConsultationVO.getSlpTpCd(), fmsConsultationVO.getSlpFuncCd(), fmsConsultationVO.getSlpOfcCd(), fmsConsultationVO.getSlpIssDt(), slpSerNo);				
												
				// Tax Master 정보 setting
				List<CustomTaxVO> addTaxVoList = new ArrayList<CustomTaxVO>();
				for (int i=0; i<customTaxVOs.length; i++ ) {
					if (customTaxVOs[i].getIbflag().equals("I")){
						customTaxVOs[i].setTaxSerNo(Integer.toString(i+1));
						customTaxVOs[i].setSlpTpCd("07");
//						customTaxVOs[i].setSlpFuncCd(fmsConsultationVO.getSlpTp());					// 이전
						customTaxVOs[i].setSlpFuncCd(fmsConsultationVO.getSlpFuncCd());						
						customTaxVOs[i].setSlpOfcCd(fmsConsultationVO.getSlpOfcCd());
						customTaxVOs[i].setSlpIssDt(fmsConsultationVO.getEffDt());
//						customTaxVOs[i].setSlpSerNo(vatSlpSerNo);												// 이전
						customTaxVOs[i].setSlpSerNo(slpSerNo);																			
						customTaxVOs[i].setCreUsrId(fmsConsultationVO.getCreUsrId());
						customTaxVOs[i].setUpdUsrId(fmsConsultationVO.getUpdUsrId());
												
						addTaxVoList.add(customTaxVOs[i]);
					}
				}
												
				// Tax Master / Bill Master 정보 입력
				if (addTaxVoList.size() > 0) {
					if(fmsConsultationVO.getEvidTpCd().equals("1")) {						
						//세금 계산서						
						tCIOdbDao.addPaymentTaxMasters(addTaxVoList);
					} else {					
						//계산서 - 2017.04.25 주석해제
						tCIOdbDao.addPaymentBillMasters(addTaxVoList);
					}
				}
												
				// Tax Detail / Bill Detail 정보 setting
				List<CustomTaxDtlVO> addTaxDtlVoList = new ArrayList<CustomTaxDtlVO>();
				for (int i=0; i<customTaxDtlVOs.length; i++ ) {
					if (customTaxDtlVOs[i].getIbflag().equals("I")){
						customTaxDtlVOs[i].setTaxInvYrmon(customTaxVOs[0].getTaxInvYrmon());
						customTaxDtlVOs[i].setOfcCd(customTaxVOs[0].getOfcCd());
						customTaxDtlVOs[i].setTaxSerNo("00001");
						customTaxDtlVOs[i].setTaxDtlSerNo(Integer.toString(i+1));
						customTaxDtlVOs[i].setCreUsrId(fmsConsultationVO.getCreUsrId());
						customTaxDtlVOs[i].setUpdUsrId(fmsConsultationVO.getUpdUsrId());
	
						addTaxDtlVoList.add(customTaxDtlVOs[i]);
					}
				}
								
				// Tax Detail / Bil Detail 정보 입력
				if (addTaxDtlVoList.size() > 0) {
					if(fmsConsultationVO.getEvidTpCd().equals("1")) {						
						//세금 계산서						
						tCIOdbDao.addPaymentTaxDtls(addTaxDtlVoList);
					} else {
						//계산서 - 2017.04.25 주석해제
						tCIOdbDao.addPaymentBilDtls(addTaxDtlVoList);
					}
				}				
			}					
			return slpSerNo;
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}
	
	/**
	 * [Owner's Account Consultation / Slip]을 [Delete] 합니다.<br>
	 * 
	 * @param String csrNo
	 * @exception EventException
	 */
	public void removeOwnersAccountSlip(String csrNo) throws EventException {
		try {
			List<FmsCsulSlpVO> fmsCsulSlpVOs = dbDao.searchOwnersAccountCsulSlps(csrNo, "");
			for (int i = 0; i < fmsCsulSlpVOs.size(); i++) {
				FmsCsulSlpVO fmsCsulSlpVO = fmsCsulSlpVOs.get(i);
				if(!"".equals(fmsCsulSlpVO.getAtchFileOaLnkId())) {
					// 첨부파일이 존재하면 FMS_OWNR_ACCT_ATCH_FILE 삭제
					dbDao.removeAtchFile(fmsCsulSlpVO.getAtchFileOaLnkId());
					
					
					//취소전표 인 경우 원전표에 해당된 Pair 전표 칼럼  Null 처리
					if(!"".equals(fmsCsulSlpVO.getPairSlpTpCd())) {
						String orgCsrNo = fmsCsulSlpVO.getPairSlpTpCd() + fmsCsulSlpVO.getPairSlpFuncCd() + fmsCsulSlpVO.getPairSlpOfcCd() + 
								          fmsCsulSlpVO.getPairSlpIssDt() + fmsCsulSlpVO.getPairSlpSerNo() + fmsCsulSlpVO.getPairSlpSeqNo();
						
						log.debug("orgCsrNo = "+orgCsrNo);
						dbDao.modifyFmsCsulSlp(orgCsrNo);
						dbDao.modifyFmsOwnrAcctSlp(orgCsrNo);
						
					}	
				}
			}
/*					
			String SLP_TP_CD   = csrNo.substring(1, 2);
			String SLP_FUNC_CD = csrNo.substring(3, 1);
			String SLP_OFC_CD = "";
			if(csrNo.length() == 19){
				SLP_OFC_CD = csrNo.substring(4, 5);
			}else{
				SLP_OFC_CD = csrNo.substring(4, 6);
			}
			String SLP_ISS_DT = "";	
			if(csrNo.length() == 19){
				SLP_ISS_DT = csrNo.substring(9, 6);
			}else{
				SLP_ISS_DT = csrNo.substring(10, 6);
			}	
			String SLP_SER_NO = "";	
			if(csrNo.length() == 19){
				SLP_ISS_DT = csrNo.substring(15, 5);
			}else{
				SLP_ISS_DT = csrNo.substring(16, 5);
			}		
*/
			
			String SLP_TP_CD   = csrNo.substring(0, 2);
			String SLP_FUNC_CD = csrNo.substring(2, 3);
			String SLP_OFC_CD = "";
			if(csrNo.length() == 19){
				SLP_OFC_CD = csrNo.substring(3, 8);
			}else{
				SLP_OFC_CD = csrNo.substring(3, 9);
			}
			String SLP_ISS_DT = "";	
			if(csrNo.length() == 19){
				SLP_ISS_DT = csrNo.substring(8, 14);
			}else{
				SLP_ISS_DT = csrNo.substring(9, 15);
			}	
			String SLP_SER_NO = "";	
			if(csrNo.length() == 19){
				SLP_SER_NO = csrNo.substring(14, 19);
			}else{
				SLP_SER_NO = csrNo.substring(15, 20);
			}		
						
//07 S VLCSC 160406 00001					
//12 3 45678    901234 56789
			
			
			log.debug("csrNo = "+csrNo);
			log.debug(csrNo.length());
			log.debug("SLP_TP_CD = "+SLP_TP_CD);
			log.debug("SLP_FUNC_CD = "+SLP_FUNC_CD);
			log.debug("SLP_OFC_CD = "+SLP_OFC_CD);
			log.debug("SLP_ISS_DT = "+SLP_ISS_DT);			
			log.debug("SLP_SER_NO = "+SLP_SER_NO);			
			
			          
			// TAX 삭제
			dbDao.deleteTaxDtl(SLP_TP_CD, SLP_FUNC_CD,SLP_OFC_CD, SLP_ISS_DT, SLP_SER_NO);
			dbDao.deleteTax(SLP_TP_CD, SLP_FUNC_CD,SLP_OFC_CD, SLP_ISS_DT, SLP_SER_NO);			
			
			// FMS_CSUL_SLP 삭제
			dbDao.removeFmsCsulSlp(csrNo);
			
			// FMS_CONSULTATION 삭제
			dbDao.removeFmsConsultation(csrNo);

			
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * [Owner's Account Consultation / Slip]을 [Cancel전표 생성] 합니다.<br>
	 * 
	 * @param FmsConsultationVO fmsConsultationVO
	 * @param List<FmsCsulSlpVO> fmsCsulSlpVOs
	 * @param SignOnUserAccount signOnUserAccount
	 * @return CancelSlipVO
	 * @exception EventException
	 */
	public CancelSlipVO cancelOwnersAccountSlip(FmsConsultationVO fmsConsultationVO, List<FmsCsulSlpVO> fmsCsulSlpVOs, SignOnUserAccount signOnUserAccount) throws EventException {
		try {
			CancelSlipVO cancelSlipVO = new CancelSlipVO();
			
			String sFlg = fmsConsultationVO.getsFlg();
			
			String orgSlpIssDt = fmsConsultationVO.getSlpIssDt();
			String orgSlpSerNo = fmsConsultationVO.getSlpSerNo();
			String orgCsrAmt = fmsConsultationVO.getCsrAmt();
			
			String slpSerNo = "";
			
			// AP_OFC_CD 산출
			String apOfcCd = fmsConsultationVO.getSlpOfcCd();
			fmsConsultationVO.setSlpOfcCd(dbDao.searchApOfcCd(apOfcCd, signOnUserAccount.getUsr_id()));
			
			if("C".equals(sFlg)){ // Cancel CSR
				
				if(fmsConsultationVO.getSlpOfcCd() == "") {
			    	return cancelSlipVO;
			    }
				
				if(fmsConsultationVO.getSlpFuncCd().equals("S")) {
					fmsConsultationVO.setSlpFuncCd("C");
				}else {
					fmsConsultationVO.setSlpFuncCd("S");
				}
				
				fmsConsultationVO.setCsrAmt(String.format("%.2f", (Double.parseDouble(orgCsrAmt)*-1)));
				
			}else if("D".equals(sFlg)){ // Delete & Resubmit
				// 원전표 cxl_flg = "Y"
				String orgCsrNo = fmsConsultationVO.getSlpTpCd() + fmsConsultationVO.getSlpFuncCd() + fmsConsultationVO.getSlpOfcCd() + fmsConsultationVO.getSlpIssDt() + fmsConsultationVO.getSlpSerNo();
				log.debug("\r\norgCsrNo : " + orgCsrNo);
				FmsConsultationVO orgFmsConsultationVO = dbDao.searchOwnersAccountConsultation(orgCsrNo, sFlg);
				orgFmsConsultationVO.setCxlFlg("Y");
				orgFmsConsultationVO.setCxlDesc("Cancel");
				orgFmsConsultationVO.setUpdUsrId(signOnUserAccount.getUsr_id());
				dbDao.modifyOwnersAccountMaster(orgFmsConsultationVO);
				
				// AP_INV_HDR > APRO_FLG = "N"
				dbDao.modifyApInvHdr(orgCsrNo);
				
				// orgCsrNo로 자동생성된 데이터들 조회
				List<ApInvHdrVO> list = dbDao.searchApInvCsrNo(orgCsrNo);
				if(list.size() > 0) {
					for(int i = 0; i < list.size(); i++) {
						ApInvHdrVO apInvHdrVO = list.get(i);
						// 해당 데이터들 APRO_FLG = "N"
						dbDao.modifyApInvHdr(apInvHdrVO.getCsrNo());
					}					
				}
				
				// FMS_OWNR_ACCT_SLP
				dbDao.deleteOwnrAcctSlp(orgCsrNo);

			}
			
			fmsConsultationVO.setOaInvDt(fmsConsultationVO.getOaInvDt().replaceAll("-", ""));
			fmsConsultationVO.setEffDt(fmsConsultationVO.getEffDt().replaceAll("-", ""));
//			fmsConsultationVO.setSlpIssDt(fmsConsultationVO.getSlpIssDt().replaceAll("-", ""));
			// SYSDATE
			Date now = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
			fmsConsultationVO.setSlpIssDt(sdf.format(now));
			
			fmsConsultationVO.setRqstDt(fmsConsultationVO.getRqstDt().replaceAll("-", ""));
			fmsConsultationVO.setCsrUsrId(signOnUserAccount.getUsr_id());
			fmsConsultationVO.setUpdUsrId(signOnUserAccount.getUsr_id());
			fmsConsultationVO.setCreUsrId(signOnUserAccount.getUsr_id());
			
			// 전표 생성 번호 저장
			slpSerNo = dbDao.searchCsulSlpSeq(fmsConsultationVO.getSlpTpCd(), fmsConsultationVO.getSlpFuncCd(), fmsConsultationVO.getSlpOfcCd());
			fmsConsultationVO.setSlpSerNo(slpSerNo);
			
			if (slpSerNo.equals("00001")) {
				dbDao.addCsulSlpSeq(fmsConsultationVO.getSlpTpCd(), fmsConsultationVO.getSlpFuncCd(), fmsConsultationVO.getSlpOfcCd(), slpSerNo, signOnUserAccount.getUsr_id());
			} else {
				dbDao.modifyCsulSlpSeq(fmsConsultationVO.getSlpTpCd(), fmsConsultationVO.getSlpFuncCd(), fmsConsultationVO.getSlpOfcCd(), slpSerNo, signOnUserAccount.getUsr_id());
			}
			
			log.debug("\r\nsFlg : " + sFlg + " | orgSlpSerNo : " + orgSlpSerNo + " | slpSerNo : " + slpSerNo);

			dbDao.addOwnersAccountMaster(fmsConsultationVO);

			List<FmsCsulSlpVO> insertVoList = new ArrayList<FmsCsulSlpVO>();
			
			for ( int  i =0; i < fmsCsulSlpVOs.size(); i++ ) {
				FmsCsulSlpVO fmsCsulSlpVO = fmsCsulSlpVOs.get(i);
				fmsCsulSlpVO.setSlpTpCd(fmsConsultationVO.getSlpTpCd());
				fmsCsulSlpVO.setSlpFuncCd(fmsConsultationVO.getSlpFuncCd());
				fmsCsulSlpVO.setSlpOfcCd(fmsConsultationVO.getSlpOfcCd());
				fmsCsulSlpVO.setSlpIssDt(fmsConsultationVO.getSlpIssDt());
				fmsCsulSlpVO.setSlpSerNo(fmsConsultationVO.getSlpSerNo());
				fmsCsulSlpVO.setCsrCurrCd(fmsConsultationVO.getCsrCurrCd());
				fmsCsulSlpVO.setCreUsrId(signOnUserAccount.getUsr_id());
				fmsCsulSlpVO.setUpdUsrId(signOnUserAccount.getUsr_id());
				
				if("C".equals(sFlg)){
					String orgSlpCsrAmt = fmsCsulSlpVO.getCsrAmt();
					fmsCsulSlpVO.setCsrAmt(String.format("%.2f", (Double.parseDouble(orgSlpCsrAmt)*-1)));					
				
					// Cancel CSR - C전표에 S Pair 저장
					fmsCsulSlpVO.setPairSlpTpCd(fmsCsulSlpVO.getSlpTpCd());
					//fmsCsulSlpVO.setPairSlpFuncCd("S");
					
					if("C".equals(fmsCsulSlpVO.getSlpFuncCd())){
						fmsCsulSlpVO.setPairSlpFuncCd("S");
					}
					else {
						fmsCsulSlpVO.setPairSlpFuncCd("C");
					}

					fmsCsulSlpVO.setPairSlpOfcCd(fmsConsultationVO.getSlpOfcCd());
					fmsCsulSlpVO.setPairSlpIssDt(orgSlpIssDt);
					fmsCsulSlpVO.setPairSlpSerNo(orgSlpSerNo);
					fmsCsulSlpVO.setPairSlpSeqNo(fmsCsulSlpVO.getSlpSeqNo());
				}

				insertVoList.add(fmsCsulSlpVO);
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addOwnersAccountSlips(insertVoList);
			}
			
			if("C".equals(sFlg)){
				for( int j = 0; j < insertVoList.size(); j++ ) { // S전표에 C Pair값 Update
										
					/*2018.03.27 pair csr no 오류 보완
					FmsCsulSlpVO sourceCsulSlpVO = fmsCsulSlpVOs.get(j);
					sourceCsulSlpVO.setSlpTpCd(sourceCsulSlpVO.getPairSlpTpCd());
					sourceCsulSlpVO.setSlpFuncCd(sourceCsulSlpVO.getPairSlpFuncCd());
					sourceCsulSlpVO.setSlpOfcCd(sourceCsulSlpVO.getPairSlpOfcCd());
					sourceCsulSlpVO.setSlpIssDt(sourceCsulSlpVO.getPairSlpIssDt());
					sourceCsulSlpVO.setSlpSerNo(sourceCsulSlpVO.getPairSlpSerNo());
					sourceCsulSlpVO.setSlpSeqNo(sourceCsulSlpVO.getPairSlpSeqNo());
					
					sourceCsulSlpVO.setPairSlpTpCd(sourceCsulSlpVO.getSlpTpCd());
					sourceCsulSlpVO.setPairSlpFuncCd(fmsConsultationVO.getSlpFuncCd());
					sourceCsulSlpVO.setPairSlpOfcCd(sourceCsulSlpVO.getSlpOfcCd());
					sourceCsulSlpVO.setPairSlpIssDt(sourceCsulSlpVO.getSlpIssDt());
					sourceCsulSlpVO.setPairSlpSerNo(fmsConsultationVO.getSlpSerNo());
					sourceCsulSlpVO.setPairSlpSeqNo(sourceCsulSlpVO.getSlpSeqNo());
					*/
					
					FmsCsulSlpVO sourceCsulSlpVO = new FmsCsulSlpVO();
					
					sourceCsulSlpVO.setSlpTpCd(insertVoList.get(j).getPairSlpTpCd());
					sourceCsulSlpVO.setSlpFuncCd(insertVoList.get(j).getPairSlpFuncCd());
					sourceCsulSlpVO.setSlpOfcCd(insertVoList.get(j).getPairSlpOfcCd());
					sourceCsulSlpVO.setSlpIssDt(insertVoList.get(j).getPairSlpIssDt());
					sourceCsulSlpVO.setSlpSerNo(insertVoList.get(j).getPairSlpSerNo());
					sourceCsulSlpVO.setSlpSeqNo(insertVoList.get(j).getPairSlpSeqNo());
					
					sourceCsulSlpVO.setPairSlpTpCd(insertVoList.get(j).getSlpTpCd());
					sourceCsulSlpVO.setPairSlpFuncCd(insertVoList.get(j).getSlpFuncCd());
					sourceCsulSlpVO.setPairSlpOfcCd(insertVoList.get(j).getSlpOfcCd());
					sourceCsulSlpVO.setPairSlpIssDt(insertVoList.get(j).getSlpIssDt());
					sourceCsulSlpVO.setPairSlpSerNo(insertVoList.get(j).getSlpSerNo());
					sourceCsulSlpVO.setPairSlpSeqNo(insertVoList.get(j).getSlpSeqNo());
					
					dbDao.modifyOwnersAccountSlip(sourceCsulSlpVO); // Pair값 수정
				}
				
			}
			
			log.debug("\r\nCancel Slip... Ok... " + fmsConsultationVO.getSlpFuncCd() + " | " + insertVoList.get(0).getSlpFuncCd());
			cancelSlipVO.setFmsConsultationVO(fmsConsultationVO);
			cancelSlipVO.setFmsCsulSlpVOs(insertVoList);
			
			return cancelSlipVO;
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}
	
	/**
	 * [O/A Cancellation Consultation / Slip]을 [Cancel전표 생성] 합니다.<br>
	 * 
	 * @param List<FmsCsulSlpVO> fmsCsulSlpVOs
	 * @param SignOnUserAccount signOnUserAccount
	 * @return CancelSlipVO
	 * @exception EventException
	 */
	public CancelSlipVO manageOwnersAccountCancellationSlip(List<FmsCsulSlpVO> fmsCsulSlpVOs, SignOnUserAccount signOnUserAccount) throws EventException {
		try {
			CancelSlipVO cancelSlipVO = new CancelSlipVO();
			
			FmsConsultationVO fmsConsultationVO = new FmsConsultationVO();
			
			String slpSerNo = "";
			String ofcCd = "";
			String csrCurrCd = "";
			String vndrSeq = "";
			double csrAmt = 0d;

			String savedCsrNo = "";
			
			// AP_OFC_CD 산출
			//String apOfcCd = fmsConsultationVO.getSlpOfcCd();
			//fmsConsultationVO.setSlpOfcCd(dbDao.searchApOfcCd(apOfcCd));
			
			log.debug("\r\nfmsCsulSlpVOs.size() : " + fmsCsulSlpVOs.size());
			for (int i = 0; i < fmsCsulSlpVOs.size(); i++) {
				FmsCsulSlpVO fmsCsulSlpVO = fmsCsulSlpVOs.get(i);
				ofcCd = fmsCsulSlpVO.getSlpOfcCd();
				csrCurrCd = fmsCsulSlpVO.getCsrCurrCd();
				csrAmt += Double.parseDouble(fmsCsulSlpVO.getCsrAmt());
				vndrSeq = fmsCsulSlpVO.getVndrSeq();
			}
			
			fmsConsultationVO.setSlpTpCd("07");
			fmsConsultationVO.setSlpFuncCd("C");
			
			/*if(fmsConsultationVO.getSlpFuncCd().equals("S")) {
				fmsConsultationVO.setSlpFuncCd("C");
			}else {
				fmsConsultationVO.setSlpFuncCd("S");
			}*/
			
			
            // RHQ 산하 아니면 취소 못하게 처리
			if("".equals(dbDao.searchApOfcCd2(ofcCd, signOnUserAccount.getUsr_id()))) {
				return cancelSlipVO;
			}
			
			
			// AP_OFC_CD 산출
			fmsConsultationVO.setSlpOfcCd(dbDao.searchApOfcCd(ofcCd, signOnUserAccount.getUsr_id()));
			
			//fmsConsultationVO.setSlpOfcCd(ofcCd);
			
			if(fmsConsultationVO.getSlpOfcCd() == "") {
				log.debug("AAAAAAA " + fmsConsultationVO.getSlpOfcCd());
		    	return cancelSlipVO;
		    }
			
			// SYSDATE
			Date now = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
			fmsConsultationVO.setSlpIssDt(sdf.format(now));
			
			fmsConsultationVO.setCsrCurrCd(csrCurrCd);
			fmsConsultationVO.setCsrAmt(String.format("%.2f", (csrAmt*-1)));
			log.debug(fmsConsultationVO.getCsrCurrCd() + " | " + fmsConsultationVO.getCsrAmt());
			
			fmsConsultationVO.setCsrUsrId(signOnUserAccount.getUsr_id());
			fmsConsultationVO.setCsrDesc("O/A Cancellation");
			fmsConsultationVO.setRqstAmt(String.format("%.2f", (csrAmt*-1)));
			log.debug(fmsConsultationVO.getCsrCurrCd() + " | " + fmsConsultationVO.getRqstAmt());
			
			fmsConsultationVO.setEvidTpCd("5");
			fmsConsultationVO.setCreUsrId(signOnUserAccount.getUsr_id());
			fmsConsultationVO.setUpdUsrId(signOnUserAccount.getUsr_id());

			// 전표 생성 번호 저장
			slpSerNo = dbDao.searchCsulSlpSeq(fmsConsultationVO.getSlpTpCd(), fmsConsultationVO.getSlpFuncCd(), fmsConsultationVO.getSlpOfcCd());
			fmsConsultationVO.setSlpSerNo(slpSerNo);
			
			if (slpSerNo.equals("00001")) {
				dbDao.addCsulSlpSeq(fmsConsultationVO.getSlpTpCd(), fmsConsultationVO.getSlpFuncCd(), fmsConsultationVO.getSlpOfcCd(), slpSerNo, signOnUserAccount.getUsr_id());
			} else {
				dbDao.modifyCsulSlpSeq(fmsConsultationVO.getSlpTpCd(), fmsConsultationVO.getSlpFuncCd(), fmsConsultationVO.getSlpOfcCd(), slpSerNo, signOnUserAccount.getUsr_id());
			}
			
			log.debug("\r\nslpSerNo : " + slpSerNo + " slpIssDt : " + fmsConsultationVO.getSlpIssDt());

			dbDao.addOwnersAccountMasterCancellation(fmsConsultationVO, vndrSeq);
			
			savedCsrNo = fmsConsultationVO.getSlpTpCd() + fmsConsultationVO.getSlpFuncCd() + fmsConsultationVO.getSlpOfcCd()
					+ fmsConsultationVO.getSlpIssDt() + fmsConsultationVO.getSlpSerNo();
			
			FmsConsultationVO savedFmsConsultationVO = dbDao.searchOwnersAccountConsultation(savedCsrNo, "");
			List<FmsCsulSlpVO> insertVoList = new ArrayList<FmsCsulSlpVO>();
			
			for ( int  i =0; i < fmsCsulSlpVOs.size(); i++ ) {
				FmsCsulSlpVO fmsCsulSlpVO = fmsCsulSlpVOs.get(i);
				String orgSlpIssDt = fmsCsulSlpVO.getSlpIssDt();
				String orgSlpSerNo = fmsCsulSlpVO.getSlpSerNo();
				String orgSlpSeqNo = fmsCsulSlpVO.getSlpSeqNo();
				
				fmsCsulSlpVO.setSlpTpCd(savedFmsConsultationVO.getSlpTpCd());
				fmsCsulSlpVO.setSlpFuncCd(savedFmsConsultationVO.getSlpFuncCd());
				fmsCsulSlpVO.setSlpOfcCd(savedFmsConsultationVO.getSlpOfcCd());
				fmsCsulSlpVO.setSlpIssDt(savedFmsConsultationVO.getSlpIssDt());
				fmsCsulSlpVO.setSlpSerNo(savedFmsConsultationVO.getSlpSerNo());
				fmsCsulSlpVO.setCsrCurrCd(savedFmsConsultationVO.getCsrCurrCd());
				fmsCsulSlpVO.setCreUsrId(signOnUserAccount.getUsr_id());
				fmsCsulSlpVO.setUpdUsrId(signOnUserAccount.getUsr_id());
				fmsCsulSlpVO.setSlpSeqNo("");		//임시
				
				String orgSlpCsrAmt = fmsCsulSlpVO.getCsrAmt();
				fmsCsulSlpVO.setCsrAmt(String.format("%.2f", (Double.parseDouble(orgSlpCsrAmt)*-1)));					
			
				// Cancel CSR - C전표에 S Pair 저장
				fmsCsulSlpVO.setPairSlpTpCd(fmsCsulSlpVO.getSlpTpCd());
				fmsCsulSlpVO.setPairSlpFuncCd("S");
				fmsCsulSlpVO.setPairSlpOfcCd(savedFmsConsultationVO.getSlpOfcCd());
				fmsCsulSlpVO.setPairSlpIssDt(orgSlpIssDt);
				fmsCsulSlpVO.setPairSlpSerNo(orgSlpSerNo);								
				//fmsCsulSlpVO.setPairSlpSeqNo(fmsCsulSlpVO.getSlpSeqNo());
				fmsCsulSlpVO.setPairSlpSeqNo(orgSlpSeqNo);

				insertVoList.add(fmsCsulSlpVO);
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addOwnersAccountSlips(insertVoList);
			}
			
			List<FmsCsulSlpVO> savedFmsCsulSlpVOs = dbDao.searchOwnersAccountCsulSlps(savedCsrNo, "");
			for( int j = 0; j < savedFmsCsulSlpVOs.size(); j++ ) { // S전표에 C Pair값 Update
				FmsCsulSlpVO savedFmsCsulSlpVO = fmsCsulSlpVOs.get(j);
				String savedSlpTpCd = savedFmsCsulSlpVO.getSlpTpCd();
				String savedSlpFuncCd = savedFmsConsultationVO.getSlpFuncCd();
				String savedSlpOfcCd = savedFmsCsulSlpVO.getSlpOfcCd();
				String savedSlpIssDt = savedFmsCsulSlpVO.getSlpIssDt();
				String savedSlpSerNo = savedFmsConsultationVO.getSlpSerNo();
				//String savedSlpSeqNo = savedFmsCsulSlpVO.getSlpSeqNo();
				
				savedFmsCsulSlpVO.setSlpTpCd(savedFmsCsulSlpVO.getPairSlpTpCd());
				savedFmsCsulSlpVO.setSlpFuncCd(savedFmsCsulSlpVO.getPairSlpFuncCd());
				savedFmsCsulSlpVO.setSlpOfcCd(savedFmsCsulSlpVO.getPairSlpOfcCd());
				savedFmsCsulSlpVO.setSlpIssDt(savedFmsCsulSlpVO.getPairSlpIssDt());
				savedFmsCsulSlpVO.setSlpSerNo(savedFmsCsulSlpVO.getPairSlpSerNo());
				savedFmsCsulSlpVO.setSlpSeqNo(savedFmsCsulSlpVO.getPairSlpSeqNo());
				
				String pairCsrNo = savedFmsCsulSlpVO.getSlpTpCd() + savedFmsCsulSlpVO.getSlpFuncCd() + savedFmsCsulSlpVO.getSlpOfcCd()
					                + savedFmsCsulSlpVO.getSlpIssDt() + savedFmsCsulSlpVO.getSlpSerNo() + savedFmsCsulSlpVO.getSlpSeqNo();
				
				String lineNo = dbDao.searchOwnersAccountCsulSlpLineNo(pairCsrNo);
				
				savedFmsCsulSlpVO.setPairSlpTpCd(savedSlpTpCd);
				savedFmsCsulSlpVO.setPairSlpFuncCd(savedSlpFuncCd);
				savedFmsCsulSlpVO.setPairSlpOfcCd(savedSlpOfcCd);
				savedFmsCsulSlpVO.setPairSlpIssDt(savedSlpIssDt);
				savedFmsCsulSlpVO.setPairSlpSerNo(savedSlpSerNo);
				//savedFmsCsulSlpVO.setPairSlpSeqNo(savedSlpSeqNo);
				savedFmsCsulSlpVO.setPairSlpSeqNo(lineNo);
				
				dbDao.modifyOwnersAccountSlip(savedFmsCsulSlpVO); // Pair값 수정
			}
			
			log.debug("\r\nCancellation Slip... Ok... " + savedFmsConsultationVO.getSlpFuncCd() + " | " + insertVoList.get(0).getSlpFuncCd());
			cancelSlipVO.setFmsConsultationVO(savedFmsConsultationVO);
			cancelSlipVO.setFmsCsulSlpVOs(savedFmsCsulSlpVOs);
			
			return cancelSlipVO;
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}
	
	/**
	 * [Owner's Account Exchange Consultation / Slip]을 [Save] 합니다.<br>
	 * 환대체 전표 자동생성
	 * @param FmsConsultationVO fmsConsultationVO
	 * @param List<FmsCsulSlpVO> fmsCsulSlpVOs
	 * @param String usrId
	 * @param String ofcCd
	 * @param String canFlg
	 * @exception EventException
	 */
	public void manageOwnersAccountExchangeSlip(FmsConsultationVO fmsConsultationVO, List<FmsCsulSlpVO> fmsCsulSlpVOs, String usrId, String ofcCd, String canFlg) throws EventException{
		try {
			log.debug("\r\n### manageOwnersAccountExchangeSlip ### fmsCsulSlpVOs.size() : " + fmsCsulSlpVOs.size());
			
			String orgCsrNo = fmsConsultationVO.getSlpTpCd() + 
					fmsConsultationVO.getSlpFuncCd() +
					fmsConsultationVO.getSlpOfcCd() + 
					fmsConsultationVO.getSlpIssDt();
			
			String orgSlpSerNo = fmsConsultationVO.getSlpSerNo();
			
			String sysUsr = "SYSTEM";
			
			log.debug("\r\n### manageOwnersAccountExchangeSlip ### orgCsrNo : " + orgCsrNo + " orgSlpSerNo : " + orgSlpSerNo);

			if("USD".equals(fmsConsultationVO.getCsrCurrCd())){
				/*** 962111 -CSR_AMT, 111071 CSR_AMT
				 * 자동 생성전표는 심사팀에서 생성하는 것으로 SLP_OFC_CD를 SELADG로 변경해서 생성한다.
				 */
				fmsConsultationVO.setSlpFuncCd("S");
				fmsConsultationVO.setSlpOfcCd("SELADG");

				String currentDate = dbDao.searchSystemCurrentDate();
				
				log.debug("currentDate " + currentDate);
				
				// 자동생성될 전표 CSR_NO
				String autoGenCsrNo = fmsConsultationVO.getSlpTpCd() + fmsConsultationVO.getSlpFuncCd() + fmsConsultationVO.getSlpOfcCd() + currentDate;
				
				fmsConsultationVO.setCsrUsrId(sysUsr);
				fmsConsultationVO.setCreUsrId(sysUsr);
				fmsConsultationVO.setUpdUsrId(sysUsr);
				
				String slpSerNo1 = dbDao.searchCsulSlpSeq(fmsConsultationVO.getSlpTpCd(), fmsConsultationVO.getSlpFuncCd(), fmsConsultationVO.getSlpOfcCd());
				
				fmsConsultationVO.setSlpSerNo(slpSerNo1);
				fmsConsultationVO.setCsrAmt("0");
				fmsConsultationVO.setCsrDesc("O/A Currency Exchange(" + fmsConsultationVO.getCsrCurrCd() + " -> USD)" + " (" + orgCsrNo + orgSlpSerNo + ")");
				fmsConsultationVO.setOaInvDt("");
				
				if (slpSerNo1.equals("00001")) {
					dbDao.addCsulSlpSeq(fmsConsultationVO.getSlpTpCd(), fmsConsultationVO.getSlpFuncCd(), fmsConsultationVO.getSlpOfcCd(), slpSerNo1, usrId);
				} else {
					dbDao.modifyCsulSlpSeq(fmsConsultationVO.getSlpTpCd(), fmsConsultationVO.getSlpFuncCd(), fmsConsultationVO.getSlpOfcCd(), slpSerNo1, usrId);
				}
				
				dbDao.addOwnersAccountMaster(fmsConsultationVO);

				FmsCsulSlpVO sourceCsulSlpVO = null;
				List<FmsCsulSlpVO> autoGenSlps = null;
				String csrNo = "";

				
				log.debug("\r\nAutoGenSlps... " + fmsCsulSlpVOs.size());
				// 자동생성전표 line
				for(int i = 0; i < fmsCsulSlpVOs.size(); i++ ) {
					sourceCsulSlpVO = fmsCsulSlpVOs.get(i);
					csrNo = sourceCsulSlpVO.getSlpTpCd() + sourceCsulSlpVO.getSlpFuncCd()
							+ sourceCsulSlpVO.getSlpOfcCd() + sourceCsulSlpVO.getSlpIssDt() 
							+ sourceCsulSlpVO.getSlpSerNo() + sourceCsulSlpVO.getSlpSeqNo();
					log.debug("\r\ncsrNo : " + csrNo + " | " + sourceCsulSlpVO.getSlpSeqNo());
					autoGenSlps = dbDao.searchAutoGenSlps(csrNo, slpSerNo1, "");
					dbDao.addOwnersAccountSlips(autoGenSlps);
					autoGenSlps.clear();
				}

				//자동 전표의 Apro_flg = 'Y'로 업데이트한다.
//				tCIOdbDao.modifySlipApprovalConsultation (autoGenCsrNo + slpSerNo1, sysUsr);
//				log.debug("\r\nConsultation > Apro_flg = 'Y'");
				
				// AP_INV_HDR / AP_INV_DTRB
				log.debug("\r\nmanageApInvData : Original Slip...");
				this.manageApInvData(orgCsrNo + orgSlpSerNo, usrId, "Y"); // 원전표 AP로 보낼꺼
				log.debug("\r\nmanageApInvData : Exchange1 Slip...");
				this.manageApInvData(autoGenCsrNo + slpSerNo1, sysUsr, "N"); // 자동생성된 전표 데이터생성하고 AP로 보낼꺼 
				
			}else{

				/*** 962111 -CSR_AMT(LCL), 951111 CSR_AMT(LCL), 951111 -CSR_AMT(USD), 111071 CSR_AMT(USD)
				 * 자동 생성전표는 심사팀에서 생성하는 것으로 SLP_OFC_CD를 SELADG로 변경해서 생성한다.
				 */
				fmsConsultationVO.setSlpFuncCd("S");
				fmsConsultationVO.setSlpOfcCd("SELADG");

				String currentDate = dbDao.searchSystemCurrentDate();
						
				log.debug("currentDate " + currentDate);
				
				// 자동생성될 전표 CSR_NO
				String autoGenCsrNo = fmsConsultationVO.getSlpTpCd() + fmsConsultationVO.getSlpFuncCd() + fmsConsultationVO.getSlpOfcCd() + currentDate;
				
				fmsConsultationVO.setOaInvDt(fmsConsultationVO.getOaInvDt().replaceAll("-", ""));
				fmsConsultationVO.setEffDt(fmsConsultationVO.getEffDt().replaceAll("-", ""));
				fmsConsultationVO.setSlpIssDt(fmsConsultationVO.getSlpIssDt().replaceAll("-", ""));
				fmsConsultationVO.setRqstDt(fmsConsultationVO.getRqstDt().replaceAll("-", ""));
				
				fmsConsultationVO.setCsrUsrId(sysUsr);
				fmsConsultationVO.setCreUsrId(sysUsr);
				fmsConsultationVO.setUpdUsrId(sysUsr);
				
				String slpSerNo1 = dbDao.searchCsulSlpSeq(fmsConsultationVO.getSlpTpCd(), fmsConsultationVO.getSlpFuncCd(), fmsConsultationVO.getSlpOfcCd());
				
				fmsConsultationVO.setSlpSerNo(slpSerNo1);			
				fmsConsultationVO.setCsrAmt("0");
				fmsConsultationVO.setCsrDesc("O/A Currency Exchange(" + fmsConsultationVO.getCsrCurrCd() + " -> USD)" + " (" + orgCsrNo + orgSlpSerNo + ")");
				fmsConsultationVO.setOaInvDt("");
				
				if (slpSerNo1.equals("00001")) {
					dbDao.addCsulSlpSeq(fmsConsultationVO.getSlpTpCd(), fmsConsultationVO.getSlpFuncCd(), fmsConsultationVO.getSlpOfcCd(), slpSerNo1, usrId);
				} else {
					dbDao.modifyCsulSlpSeq(fmsConsultationVO.getSlpTpCd(), fmsConsultationVO.getSlpFuncCd(), fmsConsultationVO.getSlpOfcCd(), slpSerNo1, usrId);
				}
				
				dbDao.addOwnersAccountMaster(fmsConsultationVO);
				
				// 원전표의 통화코드를 USD로 환대체 생성
				String slpSerNo2 = dbDao.searchCsulSlpSeq(fmsConsultationVO.getSlpTpCd(), fmsConsultationVO.getSlpFuncCd(), fmsConsultationVO.getSlpOfcCd());
				
				fmsConsultationVO.setSlpSerNo(slpSerNo2);
				fmsConsultationVO.setCsrCurrCd("USD");
				fmsConsultationVO.setCsrAmt("0");
				fmsConsultationVO.setCsrDesc("O/A Currency Exchange(" + fmsConsultationVO.getCsrCurrCd() + " -> USD)" + " (" + orgCsrNo + orgSlpSerNo + ")");
				fmsConsultationVO.setOaInvDt("");
				
				if (slpSerNo2.equals("00001")) {
					dbDao.addCsulSlpSeq(fmsConsultationVO.getSlpTpCd(), fmsConsultationVO.getSlpFuncCd(), fmsConsultationVO.getSlpOfcCd(), slpSerNo2, usrId);
				} else {
					dbDao.modifyCsulSlpSeq(fmsConsultationVO.getSlpTpCd(), fmsConsultationVO.getSlpFuncCd(), fmsConsultationVO.getSlpOfcCd(), slpSerNo2, usrId);
				}
				
				dbDao.addOwnersAccountMaster(fmsConsultationVO);

				FmsCsulSlpVO sourceCsulSlpVO = null;
				List<FmsCsulSlpVO> autoGenSlps = null;
				String csrNo = "";

				
				log.debug("\r\nAutoGenSlps... " + fmsCsulSlpVOs.size());
				// 자동생성전표 line
				for(int i = 0; i < fmsCsulSlpVOs.size(); i++ ) {
					sourceCsulSlpVO = fmsCsulSlpVOs.get(i);
					csrNo = sourceCsulSlpVO.getSlpTpCd() + sourceCsulSlpVO.getSlpFuncCd()
							+ sourceCsulSlpVO.getSlpOfcCd() + sourceCsulSlpVO.getSlpIssDt() 
							+ sourceCsulSlpVO.getSlpSerNo() + sourceCsulSlpVO.getSlpSeqNo();
					log.debug("\r\ncsrNo : " + csrNo + " | " + sourceCsulSlpVO.getSlpSeqNo());
					autoGenSlps = dbDao.searchAutoGenSlps(csrNo, slpSerNo1, slpSerNo2);
					dbDao.addOwnersAccountSlips(autoGenSlps);
					autoGenSlps.clear();
				}

				//자동 전표의 Apro_flg = 'Y'로 업데이트한다.
//				tCIOdbDao.modifySlipApprovalConsultation (autoGenCsrNo + slpSerNo1, sysUsr);
//				tCIOdbDao.modifySlipApprovalConsultation (autoGenCsrNo + slpSerNo2, sysUsr);
//				log.debug("\r\nConsultation > Apro_flg = 'Y'");
				
				// AP_INV_HDR / AP_INV_DTRB
				log.debug("\r\nmanageApInvData : Original Slip...");
				this.manageApInvData(orgCsrNo + orgSlpSerNo, usrId, "Y"); // 원전표 AP로 보낼꺼
				log.debug("\r\nmanageApInvData : Exchange1 Slip...");
				this.manageApInvData(autoGenCsrNo + slpSerNo1, sysUsr, "N"); // 자동생성된 전표 데이터생성하고 AP로 보낼꺼 1
				log.debug("\r\nmanageApInvData : Exchange2 Slip...");
				this.manageApInvData(autoGenCsrNo + slpSerNo2, sysUsr, "N"); // 자동생성된 전표 데이터생성하고 AP로 보낼꺼 2

			}
			
			/*** FMS_OWNR_ACCT_SLP > OA_STL_STS_CD - Update
			 *
			 * 취소전표(C)가 죄종 승인처리될때 Pair에 CSR_NO로 원전표의 FMS_OWNR_ACCT_SLP를 찾아서 
			 * CSR_SLP_FLG컬럼에 값이 없으면 Payment Slip에서 차감처리가 완료되기 이전상태로 S전표의 FMS_OWNR_ACCT_SLP > OA_STL_STS_CD = 'CN' Cancel
			 * CSR_SLP_FLG컬럼에 값이 있으면 Payment Slip에서 차감처리가 완료된 상태로 C전표의 FMS_OWNR_ACCT_SLP > OA_STL_STS_CD = 'RF' Refund
			 * 케이스 어떻게 걸러올지 모름 OA_STL_STS_CD = 'ST' S전표 C전표 둘다 Update
			 */
			
			/*
			if("C".equals(orgSlpFuncCd)) {
				log.debug("\r\nFMS_OWNR_ACCT_SLP > OA_STL_STS_CD - Update");
				String csrNo = "";
				String pairCsrNo = "";
				String csrSlpFlg = "";
				List<FmsCsulSlpVO> csulSlpVOs = dbDao.searchOwnersAccountCsulSlps(orgCsrNo + orgSlpSerNo, "");
				FmsCsulSlpVO fmsCsulSlpVO = csulSlpVOs.get(0);
				csrNo = fmsCsulSlpVO.getSlpTpCd() + fmsCsulSlpVO.getSlpFuncCd() + fmsCsulSlpVO.getSlpOfcCd()
						+ fmsCsulSlpVO.getSlpIssDt() + fmsCsulSlpVO.getSlpSerNo() + fmsCsulSlpVO.getSlpSeqNo();
				
				pairCsrNo = fmsCsulSlpVO.getPairSlpTpCd() + fmsCsulSlpVO.getPairSlpFuncCd() + fmsCsulSlpVO.getPairSlpOfcCd()
						+ fmsCsulSlpVO.getPairSlpIssDt() + fmsCsulSlpVO.getPairSlpSerNo() + fmsCsulSlpVO.getPairSlpSeqNo();
				
				FmsOwnrAcctSlpVO fmsOwnrAcctSlpVO = dbDao.searchOwnrAcctSlp(pairCsrNo);
				csrSlpFlg = fmsOwnrAcctSlpVO.getCsrSlpFlg();
				
				if("Y".equals(csrSlpFlg)) {
					// Payment Slip에서 차감처리 완료
					dbDao.modifyOwnrAcctSlp(csrNo, "RF");
					
				}else if("N".equals(csrSlpFlg)) {
					// Payment Slip에서 차감처리 전
					dbDao.modifyOwnrAcctSlp(pairCsrNo, "CN");
					dbDao.modifyOwnrAcctSlp(csrNo, "CN");
					
				}
				
			}
			*/
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}

	/**
	 * AP_INV 테이블 데이터 생성
	 * 
	 * @param String csrNo
	 * @param String usrId
	 * @param String isOrg
	 * @exception EventException
	 */
	private void manageApInvData(String csrNo, String usrId, String isOrg) throws EventException {
		try {
			log.debug("\r\nmanageApInvData... csrNo : " + csrNo + " isOrg : " + isOrg);
			if("N".equals(isOrg)) { // 원전표가 아닐때만 데이터생성함 (AP_INV_HDR / AP_INV_DTRB)
				//AP 전표 Detail 계정 항목들을 조회한다 
				List<SearchApSlipDetailListVO> searchApSlipDetailListVO = dbDao.searchApSlipDetailList(csrNo);
				
				int listSize = searchApSlipDetailListVO.size();
				log.debug("\r\n>>> listSize : " + listSize);
				if (listSize > 0) {
					
					//회계일자 검사한다
					String effDt = tCIOdbDao.searchCheckEffectiveDate(searchApSlipDetailListVO.get(0).getSlpOfcCd(), searchApSlipDetailListVO.get(0).getEffDt());
					if (effDt.equals("")) {
						throw new EventException(new ErrorHandler("FMS01556",new String[]{}).getMessage());
					}
					
					for (int i=0; i<listSize; i++) {
						//재무항차 검사 
						if (!searchApSlipDetailListVO.get(i).getVslCd().equals("")) {
							String vslCd = tCIOdbDao.searchCheckMdmVvdCode(searchApSlipDetailListVO.get(i).getVslCd()+ 
									searchApSlipDetailListVO.get(i).getSkdVoyNo()+
									searchApSlipDetailListVO.get(i).getSkdDirCd()+
									searchApSlipDetailListVO.get(i).getRevDirCd());
							
							if (vslCd.equals("")) {
								throw new EventException(new ErrorHandler("FMS01558",new String[]{}).getMessage());
							}
						}
					}
					
					//Vendor 검사한다
					List<SearchSlipApprovalOwnerVO> searchSlipApprovalOwnerVO = tCIOdbDao.searchSlipApprovalOwner(searchApSlipDetailListVO.get(0).getVndrSeq(), searchApSlipDetailListVO.get(0).getCustCntCd(), searchApSlipDetailListVO.get(0).getCustSeq());
					
					if (searchSlipApprovalOwnerVO.size() == 0) {
						throw new EventException(new ErrorHandler("FMS01345",new String[]{}).getMessage());
					}
					
					//AP Header(AP_INV_HDR) 테이블에 넣을 VO를 생성한다
					CustomSlipApprovalHeaderVO customSlipApprovalHeaderVO = new CustomSlipApprovalHeaderVO();
					
					//Slip Approval 승인 시에 Office 및 User 테이블에서 필요 항목 조회한다
					List<SearchSlipApprovalOfficeVO> searchSlipApprovalOfficeVO = tCIOdbDao.searchSlipApprovalOffice(usrId);
					if (searchSlipApprovalOfficeVO.size() > 0) {
						customSlipApprovalHeaderVO.setAttrCtnt10(searchSlipApprovalOfficeVO.get(0).getUsrNm());
						customSlipApprovalHeaderVO.setUsrEml(searchSlipApprovalOfficeVO.get(0).getUsrEml());
					}
					
					// Header 
					customSlipApprovalHeaderVO.setCsrNo(csrNo); // CSR No
					customSlipApprovalHeaderVO.setCsrCurrCd(searchApSlipDetailListVO.get(0).getCsrCurrCd()); // Currency
					customSlipApprovalHeaderVO.setCoaCtrCd(searchApSlipDetailListVO.get(0).getCtrCd()); // Center
					customSlipApprovalHeaderVO.setCoaAcctCd("210121"); // Account
					customSlipApprovalHeaderVO.setCoaVvdCd("0000000000"); // VVD
					customSlipApprovalHeaderVO.setCsrAmt(searchApSlipDetailListVO.get(0).getRqstAmt()); // Amount
					customSlipApprovalHeaderVO.setPayGrpLuCd("대내지불"); // Pay Group
					if (searchApSlipDetailListVO.get(0).getRqstAmt().equals("0")) {
						customSlipApprovalHeaderVO.setPayGrpLuCd("ZERO PAYMENT");  // Pay Group
					}
					customSlipApprovalHeaderVO.setPayMzdLuCd("WIRE"); // Payment Method
					// Evidence
					customSlipApprovalHeaderVO.setVndrNo(searchApSlipDetailListVO.get(0).getVndrSeq()); // Supplier No
					// Supplier
					customSlipApprovalHeaderVO.setInvDesc(searchApSlipDetailListVO.get(0).getCsrDesc()); // Description
//				    customSlipApprovalHeaderVO.setActXchRt(searchApSlipDetailListVO.get(0).getActXchRt()); // Exchange Rate
					customSlipApprovalHeaderVO.setGlDt(searchApSlipDetailListVO.get(0).getEffDt()); // GL Date
					customSlipApprovalHeaderVO.setInvTermDt(searchApSlipDetailListVO.get(0).getRqstDt()); // Terms Date
					if (searchApSlipDetailListVO.get(0).getSlpFuncCd().equals("S")) {
						customSlipApprovalHeaderVO.setAttrCtnt6("STANDARD"); // Attribute6
					} else {
						customSlipApprovalHeaderVO.setAttrCtnt6("CREDIT");
					}
					customSlipApprovalHeaderVO.setSrcCtnt("EXCHANGE"); // Attribute51
					customSlipApprovalHeaderVO.setCreUsrId(usrId);
					
					// 기본포맷 --------------------------------------------------------------------------------
					customSlipApprovalHeaderVO.setCsrTpCd("STANDARD");
					customSlipApprovalHeaderVO.setInvDt("20" + searchApSlipDetailListVO.get(0).getSlpIssDt());
					customSlipApprovalHeaderVO.setVndrTermNm(searchSlipApprovalOwnerVO.get(0).getGenPayTermCd());
					customSlipApprovalHeaderVO.setAttrCateNm("Invoices");
					
					customSlipApprovalHeaderVO.setCoaCoCd("01");
					customSlipApprovalHeaderVO.setCoaRgnCd("11");
					customSlipApprovalHeaderVO.setCoaCtrCd("111234");
					customSlipApprovalHeaderVO.setCoaInterCoCd("00");
					customSlipApprovalHeaderVO.setCoaFtuN1stCd("000000");
					customSlipApprovalHeaderVO.setCoaFtuN2ndCd("000000");
					customSlipApprovalHeaderVO.setAproFlg("Y");
					customSlipApprovalHeaderVO.setTjOfcCd("SELADG");
					// 기본포맷 --------------------------------------------------------------------------------
					
					// Line
					//AP Detail 테이블에 생성된다
					List<CustomSlipApprovalDetailVO> insertVoList = new ArrayList<CustomSlipApprovalDetailVO>();
					
					for ( int i=0; i<listSize; i++ ) {
						CustomSlipApprovalDetailVO customSlipApprovalDetailVO = new CustomSlipApprovalDetailVO();
						
						customSlipApprovalDetailVO.setCsrNo(searchApSlipDetailListVO.get(i).getSlpTpCd()+
								searchApSlipDetailListVO.get(i).getSlpFuncCd() +
								searchApSlipDetailListVO.get(i).getSlpOfcCd() +																			
								searchApSlipDetailListVO.get(i).getSlpIssDt() +
								searchApSlipDetailListVO.get(i).getSlpSerNo());
						
						customSlipApprovalDetailVO.setDtrbCoaCtrCd(searchApSlipDetailListVO.get(0).getCtrCd()); // Center
						customSlipApprovalDetailVO.setDtrbCoaAcctCd(searchApSlipDetailListVO.get(i).getAcctCd()); // Account
						customSlipApprovalDetailVO.setActVvdCd(searchApSlipDetailListVO.get(i).getVslCd()+ 
								searchApSlipDetailListVO.get(i).getSkdVoyNo()+
								searchApSlipDetailListVO.get(i).getSkdDirCd()+
								searchApSlipDetailListVO.get(i).getRevDirCd()); // VVD
						customSlipApprovalDetailVO.setInvAmt(searchApSlipDetailListVO.get(i).getCsrAmt()); // Amount
						customSlipApprovalDetailVO.setInvDesc(searchApSlipDetailListVO.get(i).getSlpCsrDesc()); // Description
						customSlipApprovalDetailVO.setAttrCateNm(searchApSlipDetailListVO.get(i).getAcctCd()); // Attribute_category
						customSlipApprovalDetailVO.setAttrCtnt3(searchApSlipDetailListVO.get(i).getSlpLocCd()); // Attribute3 (Location Code)
						customSlipApprovalDetailVO.setAttrCtnt4(searchApSlipDetailListVO.get(i).getSlpTpCd()+
								searchApSlipDetailListVO.get(i).getSlpFuncCd() +
								searchApSlipDetailListVO.get(i).getSlpOfcCd() +																			
								searchApSlipDetailListVO.get(i).getSlpIssDt() +
								searchApSlipDetailListVO.get(i).getSlpSerNo()); // Attribute4
						customSlipApprovalDetailVO.setAttrCtnt5(searchApSlipDetailListVO.get(i).getCsrCurrCd()); // Attribute5
						customSlipApprovalDetailVO.setAttrCtnt6(searchApSlipDetailListVO.get(i).getCsrAmt()); // Attribute6
						customSlipApprovalDetailVO.setAttrCtnt8(searchApSlipDetailListVO.get(i).getSlpSeqNo()); // Attribute8
						
						customSlipApprovalDetailVO.setLineSeq(searchApSlipDetailListVO.get(i).getSlpSeqNo());
						customSlipApprovalDetailVO.setLineNo(searchApSlipDetailListVO.get(i).getSlpSeqNo());
						customSlipApprovalDetailVO.setLineTpLuCd("ITEM");
						
						if ((searchApSlipDetailListVO.get(i).getVslCd()+ 
								searchApSlipDetailListVO.get(i).getSkdVoyNo()+
								searchApSlipDetailListVO.get(i).getSkdDirCd()+
								searchApSlipDetailListVO.get(i).getRevDirCd()).equals("")) {
							customSlipApprovalDetailVO.setDtrbCoaVvdCd("0000000000"); 
						} else {
							customSlipApprovalDetailVO.setDtrbCoaVvdCd(searchApSlipDetailListVO.get(i).getVslCd()+ 
									searchApSlipDetailListVO.get(i).getSkdVoyNo()+
									searchApSlipDetailListVO.get(i).getSkdDirCd()+
									searchApSlipDetailListVO.get(i).getRevDirCd());
						}
						
//						customSlipApprovalDetailVO.setCreUsrId(searchApSlipDetailListVO.get(i).getCsrUsrId());
						customSlipApprovalDetailVO.setCreUsrId(usrId);
						
						customSlipApprovalDetailVO.setDtrbCoaCoCd("01");
						customSlipApprovalDetailVO.setDtrbCoaRgnCd("11");
						customSlipApprovalDetailVO.setDtrbCoaCtrCd("111234");
						customSlipApprovalDetailVO.setDtrbCoaInterCoCd("00");
						customSlipApprovalDetailVO.setDtrbCoaFtuN1stCd("000000");
						customSlipApprovalDetailVO.setDtrbCoaFtuN2ndCd("000000");
						
						insertVoList.add(customSlipApprovalDetailVO);
					}
					
					//AP Header(AP_INV_HDR) 생성
					tCIOdbDao.addApSlipApprovalHeader(customSlipApprovalHeaderVO);
					
					//AP Detail(AP_INV_DTRB) 생성
					if (insertVoList.size() > 0) {
						dbDao.addApSlipApprovalDetails(insertVoList);
					}
				}

			}else{ // 원전표 AP보내기 전에
				// 첨부파일 필수 컬럼 Y로 업데이트
				tCIOdbDao.modifyApInvHdrAgmtFileCd(csrNo, "Y");
				
			} // if end
			
			if("Y".equals(isOrg)) { // 원전표 일때 만
				//AP Invoice의 Interface할 데이터를 조회한다.
				List<SearchApSlipInterfaceListVO> searchApSlipInterfaceListVO = tCIOdbDao.searchApSlipInterfaceList(csrNo);
				
				//Send AP Invoice
				//String agmtCntYn = tCIOdbDao.searchAgmtCfmCd(csrNo);
				
				log.debug("\r\nSTART - eaiDao.sendSlipApprovalToAP... csrNo : " + csrNo);
				//this.approvalRequestAccount2(csrNo);
				eaiDao.sendSlipApprovalToAP(csrNo, searchApSlipInterfaceListVO, "A");
				
				//AP Interface(AP_INV_IF) 입력	--2016.04.05 사용하지않는 테이블이라고하여 주석처리함
				//log.debug("\r\nSTART - tCIOdbDao.addApSlipApprovalInterfaces... ");
				//tCIOdbDao.addApSlipApprovalInterfaces(searchApSlipInterfaceListVO);
			}
	
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01419",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01419",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * [Owner's Account Consulation]을 [Select] 합니다.<br>
	 * 
	 * @param String csrNo
	 * @param String sFlg
	 * @return FmsConsultationVO
	 * @exception EventException
	 */
	public FmsConsultationVO searchOwnersAccountConsultation(String csrNo, String sFlg) throws EventException{
		try {
			return dbDao.searchOwnersAccountConsultation(csrNo, sFlg);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * [Owner's Account Slip]을 [Select] 합니다.<br>
	 * 
	 * @param String csrNo
	 * @param String sFlg
	 * @return List<FmsCsulSlpVO>
	 * @exception EventException
	 */
	public List<FmsCsulSlpVO> searchOwnersAccountCsulSlps(String csrNo, String sFlg) throws EventException{
		try {
			return dbDao.searchOwnersAccountCsulSlps(csrNo, sFlg);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * [O/A Cancellation에서 취소를 위해 선택한 전표]을 [조회]합니다.<br>
	 * 
	 * @param String csrNo
	 * @return List<FmsCsulSlpVO>
	 * @exception EventException
	 */
	public List<FmsCsulSlpVO> searchOwnersAccountCancellationSlip(String csrNo) throws EventException{
		try {
			return dbDao.searchOwnersAccountCancellationSlip(csrNo);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * [Approval Type ( GW or ALPS) ]을 [Search] 합니다.<br>
	 * 
	 * @param String orgCur
	 * @param String orgAmt
	 * @return String
	 * @exception EventException
	 */
	public String searchApprovalType(String orgCur, String orgAmt) throws EventException{
		try {
			return dbDao.searchApprovalType(orgCur, orgAmt);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * [G/L Date ]을 [Search] 합니다.<br>
	 * 
	 * @param String ofcCd
	 * @return String
	 * @exception EventException
	 */
	public String searchGlDate(String ofcCd) throws EventException {
		try {
			return dbDao.searchGlDate(ofcCd);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * [G/L Date -  Payments Slip]을 [Search] 합니다.<br>
	 * 
	 * @param String ofcCd
	 * @return String
	 * @exception EventException
	 */
	public String searchGlDate2(String ofcCd) throws EventException {
		try {
			return dbDao.searchGlDate2(ofcCd);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * Owner's Account 목록을 조회한다<br>
	 * 
	 * @param OwnrAcctVO ownrAcctVO
	 * @param String offCd
	 * @return List<OwnrAcctListVO>
	 * @exception EventException
	 */
	public List<OwnrAcctListVO> searchOwnersAccountList(OwnrAcctVO ownrAcctVO, String offCd) throws EventException {
		try {
			return dbDao.searchOwnersAccountList(ownrAcctVO, offCd);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01800",new String[]{}).getMessage(), ex);
		} catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01800",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * Office 코드List를 조회한다.
	 * 
	 * @param String offCd
	 * @return List<OwnrAcctVO>
	 * @throws EventException
	 */	
	public List<OwnrAcctVO> searchOwnOfficeList(String offCd) throws EventException {
		try {
			return dbDao.searchOwnOfficeList(offCd);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Trade Code List", "Retrieve"}).getUserMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Trade Code List", "Retrieve"}).getUserMessage(), ex);
		}
	}
	
	/**
	 * Currency 코드List를 조회한다.
	 * 
	 * @param String offCd
	 * @return List<OwnrCurrVO>
	 * @throws EventException
	 */
	public List<OwnrCurrVO> searchOwnCurrList(String offCd) throws EventException {
		try {
			return dbDao.searchOwnCurrList(offCd);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Trade Code List", "Retrieve"}).getUserMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Trade Code List", "Retrieve"}).getUserMessage(), ex);
		}

	}
	
 	/**
	 * Invoice No 중복 체크<br>
	 * 
	 * @param String vndrSeq
	 * @param String toInvNo
	 * @param String csrNo
	 * @param String vvd
	 * @return Boolean
	 * @exception EventException
	 */
	public Boolean checkInvNo(String vndrSeq, String toInvNo, String csrNo, String vvd) throws EventException {
		try {
			return dbDao.checkInvNo(vndrSeq, toInvNo, csrNo, vvd);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Trade Code List", "Retrieve"}).getUserMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Trade Code List", "Retrieve"}).getUserMessage(), ex);
		}
	}
	
 	/**
	 * Local Currency 조회<br>
	 * 
	 * @param String ofcCd
	 * @return String
	 * @exception EventException
	 */
	public String searchLocalCurrency(String ofcCd) throws EventException {
		try {
			return dbDao.searchLocalCurrency(ofcCd);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Trade Code List", "Retrieve"}).getUserMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Trade Code List", "Retrieve"}).getUserMessage(), ex);
		}
	}
	
	/**
	 * Owner's Account For Cancellation 정보를 조회한다<br>
	 * [ESM_FMS_0101] O/A Inquiry for Cancellation
	 * 
	 * @param CondOwnrAcctForCnclVO condOwnrAcctForCnclVO
	 * @return List<SearchOwnrAcctForCnclListVO>
	 * @exception EventException
	 */
	public List<SearchOwnrAcctForCnclListVO> searchOwnrsAccntForCnclList(CondOwnrAcctForCnclVO condOwnrAcctForCnclVO) throws EventException {
		try {
			return dbDao.searchOwnrsAccntForCnclList(condOwnrAcctForCnclVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			// [FMS01115] Failed to retrieve Owner's Account. : Owner Account 조회 실패
			throw new EventException(new ErrorHandler("FMS01115",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			// [FMS01115] Failed to retrieve Owner's Account. : Owner Account 조회 실패
			throw new EventException(new ErrorHandler("FMS01115",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * [Owner's Account Exchange Consultation / Slip의 File]을 [Save] 합니다.<br>
	 * 
	 * @param String csrNo 
	 * @param FmsCsulSlpVO[] fmsCsulSlpVOs
	 * @param SignOnUserAccount signOnUserAccount
	 * @exception EventException
	 */
	public void manageFileSav(String csrNo, FmsCsulSlpVO[] fmsCsulSlpVOs, SignOnUserAccount signOnUserAccount) throws EventException{
		String fileSavId = "";
		String[] arrFile = null;		
		String vvd = "";
		
		try {
			for (int  i=0; i <fmsCsulSlpVOs.length; i++ ) {
				if ( fmsCsulSlpVOs[i].getIbflag().equals("I")){					
					if("962111".equals(fmsCsulSlpVOs[i].getAcctCd())){
						fileSavId = fmsCsulSlpVOs[i].getFileSavId();
						vvd = fmsCsulSlpVOs[i].getVvdCd();
						
						arrFile = fileSavId.split(",");
						
						for(int j=0; j<arrFile.length; j++){
							dbDao.addFmsOwnrAcctAtchFile(csrNo,vvd, i+1, j+1, arrFile[j], signOnUserAccount.getUsr_id());						
						}
					}					
				}
			}						
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}

	/**
	 * [Owner's Account Exchange Consultation / Slip의 File]을 [Save] 합니다.<br>
	 * 
	 * @param String csrNo 
	 * @param String newCsrNo
	 * @param int seqNo
	 * @param SignOnUserAccount signOnUserAccount
	 * @exception EventException
	 */
	public void manageCancelFileSav(String csrNo, String newCsrNo, int seqNo, SignOnUserAccount signOnUserAccount) throws EventException{
		
		try {			
			 log.debug("## manageCancelFileSav");
			 log.debug("## csrNo = "+csrNo);
			 log.debug("## newCsrNo = "+newCsrNo);
			 log.debug("## seqNo = "+seqNo);			 
			 
			 			
			  List<FileUploadListVO> fileUploadListVOs = dbDao.searchOwnersAccountAtchFile(csrNo);
//			  int flieCnt = dbDao.searchFileCnt(newCsrNo);
//			  log.debug(flieCnt);
//			  int fileSeq = flieCnt;
			  int fileSeq = 0;			  
			  
			  for (int i = 0; i < fileUploadListVOs.size(); i++) {
				  log.debug(fileSeq);
				  fileSeq = fileSeq +  1;	// 순번
				  
				  FileUploadListVO fileUploadListVO = new FileUploadListVO();
				  fileUploadListVO = fileUploadListVOs.get(i);
				  
				  String atchFileLnkId =  fileUploadListVO.getAtchFileOaLnkId();
				  String atchFileLnkSeq =  fileUploadListVO.getAtchFileOaLnkSeq();
				  
				  if(seqNo > 0){
					  // Multi-Cancellation for O/A에서 호출
					  log.debug("### Multi-Cancellation for O/A");
				      dbDao.addFmsOwnrAcctAtchFileCancel2(csrNo, newCsrNo, atchFileLnkId, atchFileLnkSeq, fileSeq, seqNo, signOnUserAccount.getUsr_id());					  
				  }else{
				      dbDao.addFmsOwnrAcctAtchFileCancel(csrNo, newCsrNo, atchFileLnkId, atchFileLnkSeq, signOnUserAccount.getUsr_id());					  
				  }	
			  }
			  
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	
 	/**
	 * 첨부파일 개수 조회<br>
	 * 
	 * @param String csrNo
	 * @return String
	 * @exception EventException
	 */
	public int searchFileCnt(String csrNo) throws EventException {
		try {
			return dbDao.searchFileCnt(csrNo);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"File Count", "Retrieve"}).getUserMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"File Count", "Retrieve"}).getUserMessage(), ex);
		}
	}	
	
 	/**
	 * CSR_NO에 해당하는 첨부파일을 GW폴더로 복사한다.<br>
	 * 
	 * @param String csrNo
	 * @exception EventException
	 */
	public void sendOwnersAccountAtchFile(String csrNo) throws EventException {
		String rootPath = (new StringBuilder(String.valueOf(SiteConfigFactory.get("COM.FILE.UPLOAD.DIRECTORY")))).toString();	///a_upload/FILE/
		
		try {
			List<FileUploadListVO> fileUploadListVOs = dbDao.searchOwnersAccountAtchFile(csrNo);
			
			log.debug("\r\nfileUploadListVOs.size() : " + fileUploadListVOs.size());
			for (int i = 0; i < fileUploadListVOs.size(); i++) {
				FileUploadListVO fileUploadListVO = new FileUploadListVO();
				fileUploadListVO = fileUploadListVOs.get(i);
				String orgFileSavId = fileUploadListVO.getFileSavId();
				String orgFilePathUrl = fileUploadListVO.getFilePathUrl();
				String orgFullPath = orgFilePathUrl + File.separator + orgFileSavId;
				String gwPath = rootPath + "GW_CSR_APRO" + File.separator + orgFileSavId;
				
				File orgFile = new File(orgFullPath);
				File targetFile = new File(gwPath);
//				try {
					log.debug("\r\n S-----------------fileCopy");
					log.debug("\r\norgFullPath : " + orgFullPath + " targetFullPath : " + gwPath);
					fileCopy(orgFile, targetFile);
					log.debug("\r\n E-----------------fileCopy");
//				} catch(IOException e) {
//					log.error("\n fileCopy ERROR!!");
//					log.error("err"+e.toString(),e);
//					throw new EventException(e.getMessage(), e);
//				}				
			}
			
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}
	
 	/**
	 * 첨부파일을 GW폴더로 복사.<br>
	 * 
	 * @param String csrNo
	 * @exception EventException
	 */
	private void fileCopy(File orgFile, File targetFile) throws IOException {
		  FileInputStream inputStream = new FileInputStream(orgFile);
		  if (!targetFile.isFile()) {
			  File fParent = new File (targetFile.getParent());
			  if (!fParent.exists()){
			    fParent.mkdir();
			  }
			  targetFile.createNewFile();
		  }
		  FileOutputStream outputStream = new FileOutputStream(targetFile);
		  FileChannel fcin =  inputStream.getChannel();
		  FileChannel fcout = outputStream.getChannel();
		  long size = fcin.size();
		  fcin.transferTo(0, size, fcout);
		  fcout.close();
		  fcin.close();
		  outputStream.close();
		  inputStream.close();
	}
	
	/**
	 * ESM_FSM_B002 CsulSlpOAIf로 부터 호출되며,<br>
	 * ERP I/F를 수행.
	 * 
	 * @param ArrayList<FmsConsultationVO> arrayCsulVo
	 * @exception EventException
	 */
	public void altSlpERPIf(ArrayList<FmsConsultationVO> arrayCsulVo) throws EventException {
		
		String sCsrNo = null;
		
		try{
			for(int idx = 0; idx < arrayCsulVo.size(); idx++) {
				sCsrNo = arrayCsulVo.get(idx).getsCsrNo();
				
				//AP Invoice의 Interface할 데이터를 조회한다.
				List<SearchApSlipInterfaceListVO> searchApSlipInterfaceListVO = tCIOdbDao.searchApSlipInterfaceList(sCsrNo);
				
				//Send AP Invoice
				//String agmtCntYn = tCIOdbDao.searchAgmtCfmCd(sCsrNo);
				
				log.debug("\r\nSTART - ESM_FMS_B002 eaiDao.sendSlipApprovalToAP... csrNo : " + sCsrNo);
				//this.approvalRequestAccount2(sCsrNo);
				eaiDao.sendSlipApprovalToAP(sCsrNo, searchApSlipInterfaceListVO, "N");
				
				tCIOdbDao.modifySlipApprovalConsultation (sCsrNo, "SYSTEM");
			}
		
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01419",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01419",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * ESM_FSM_B002 CsulSlpOAIf로 부터 호출되며,<br>
	 * 원전표 : 대상 목록을 FMS_OWNR_ACCT_SLP insert(Pair 포함),<br>
	 * 						FMS_OWNR_ACCT_SLP Update(pair 포함),<br>
	 * 						FMS_CONSULTATION update
	 * 
	 * @param ArrayList<FmsCsulSlpVO> arrayCsulSlpVo
	 * @exception EventException
	 */
	public void oriSlpManage(ArrayList<FmsCsulSlpVO> arrayCsulSlpVo) throws EventException {
		
		FmsCsulSlpVO sourceCsulSlpVO = null;
		String csrNo = "";
		String pairCsrNo = "";
		
		try {
			for(int i = 0; i < arrayCsulSlpVo.size(); i++ ) {
				sourceCsulSlpVO = arrayCsulSlpVo.get(i);
				csrNo = sourceCsulSlpVO.getSlpTpCd() + sourceCsulSlpVO.getSlpFuncCd()
						+ sourceCsulSlpVO.getSlpOfcCd() + sourceCsulSlpVO.getSlpIssDt() 
						+ sourceCsulSlpVO.getSlpSerNo() + sourceCsulSlpVO.getSlpSeqNo();
				pairCsrNo = sourceCsulSlpVO.getPairSlpTpCd() + sourceCsulSlpVO.getPairSlpFuncCd()
						+ sourceCsulSlpVO.getPairSlpOfcCd() + sourceCsulSlpVO.getPairSlpIssDt() 
						+ sourceCsulSlpVO.getPairSlpSerNo() + sourceCsulSlpVO.getPairSlpSeqNo();
				log.debug("\r\nESM_FMS_B002 csrNo : " + csrNo + " | pairCsrNo : " + pairCsrNo );

				// FMS_OWNR_ACCT_SLP Insert > Pair CSR_NO포함
				dbDao.addOwnersAccountSlip(csrNo, sourceCsulSlpVO.getCsrCurrCd(), sourceCsulSlpVO.getCsrAmt(), sourceCsulSlpVO.getCreUsrId());
				
				// FMS_OWNR_ACCT_SLP Update > 위에 생성한 Pair CSR_NO Update
				dbDao.modifyOwnersAccountSlipPairCsrNo(sourceCsulSlpVO);
				
				// FMS_CONSULTATION update : OA_IF_FLG = 'N'
				dbDao.modifyOriOASlp(sourceCsulSlpVO);
			
				if(!"".equals(pairCsrNo)){
	                FmsOwnrAcctSlpVO fmsOwnrAcctSlpVO = dbDao.searchOwnrAcctSlp(pairCsrNo);
	                		
	                if (fmsOwnrAcctSlpVO != null) {	
						String csrSlpFlg = "";
						csrSlpFlg = fmsOwnrAcctSlpVO.getCsrSlpFlg();
						
						if(csrSlpFlg != null){
							if(csrSlpFlg.equals("N")) {
								dbDao.modifyOwnrAcctSlp(pairCsrNo, "CN");
							} else if(csrSlpFlg.equals("Y")) {			//2017.04.27 Payments Slip 에서 차감된 경우 Refund 로 반영
								dbDao.modifyOwnrAcctSlp(csrNo, "RF");
							}
						}	
	                }	
                }
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01419",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01419",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * ESM_FMS_0095 : [COMMAND02]<br>
	 * [운항팀(PUSMOV)을 제외한 Office의 재무항차와 ETD를 [조회]합니다.<br>
	 *
	 * @param String vvdCd
	 * @param String oaLocCd
	 * @return searchFinancialVVDForOtherOffcVO
	 * @exception EventException 
	 */
	public searchFinancialVVDForOtherOffcVO searchFinancialVVDForOtherOffc(String vvdCd, String oaLocCd) throws EventException {
		searchFinancialVVDForOtherOffcVO rsVo = null;
		
		try {
			rsVo = dbDao.searchFinancialVVDForOtherOffc(vvdCd, oaLocCd);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			// FMS01321 : Failed to retrieve Revenue VVD.
			throw new EventException(new ErrorHandler("FMS01321",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			// FMS01321 : Failed to retrieve Revenue VVD.
			throw new EventException(new ErrorHandler("FMS01321",new String[]{}).getMessage(), ex);
		}
		
		return rsVo;
	}
	
	/**
	 * [Custom Tax]을 [Select] 합니다.<br>
	 * 
	 * @param String csrNo
	 * @return List<CustomTaxVO>
	 * @exception EventException
	 */
	public List<CustomTaxVO> searchCustomTax(String csrNo) throws EventException{
		try {
			return dbDao.searchCustomTax(csrNo);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * [Custom Tax Detal]을 [Select] 합니다.<br>
	 * 
	 * @param String csrNo
	 * @return List<CustomTaxDtlVO>
	 * @exception EventException
	 */
	public List<CustomTaxDtlVO> searchCustomTaxDtl(String csrNo) throws EventException{
		try {
			return dbDao.searchCustomTaxDtl(csrNo);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}	
	
 	/**
	 * 국가 코드 조회<br>
	 * 
	 * @param String ofcCd
	 * @return String
	 * @exception EventException
	 */
	public String searchCountryCodeByOfcCd(String ofcCd) throws EventException {
		try {
			return tCIOdbDao.searchCountryCodeByOfcCd(ofcCd);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Trade Code List", "Retrieve"}).getUserMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Trade Code List", "Retrieve"}).getUserMessage(), ex);
		}
	}	
	
	/**
	 * [Tax 과세 USD인 경우에 Owner's Account Consultation / Slip]을 [Save] 합니다.<br>
	 * 
	 * @param FmsConsultationVO fmsConsultationVO
	 * @param FmsCsulSlpVO[] fmsCsulSlpVOs
	 * @param SignOnUserAccount signOnUserAccount
	 * @param CustomTaxVO[] customTaxVOs
	 * @param CustomTaxDtlVO[] customTaxDtlVOs
	 * @return String
	 * @exception EventException
	 */
	public String manageOwnersAccountSlipTax(FmsConsultationVO fmsConsultationVO, FmsCsulSlpVO[] fmsCsulSlpVOs, SignOnUserAccount signOnUserAccount, CustomTaxVO[] customTaxVOs, CustomTaxDtlVO[] customTaxDtlVOs) throws EventException {
		try {

			String sFlg = fmsConsultationVO.getsFlg();			
			String slpSerNo = "";			
						
			// AP_OFC_CD 산출
			String apOfcCd = fmsConsultationVO.getSlpOfcCd();
			
			fmsConsultationVO.setSlpOfcCd(dbDao.searchApOfcCd(apOfcCd, signOnUserAccount.getUsr_id()));
			
			// 전표 생성 번호 저장
			slpSerNo = dbDao.searchCsulSlpSeq(fmsConsultationVO.getSlpTpCd(), fmsConsultationVO.getSlpFuncCd(), fmsConsultationVO.getSlpOfcCd());
			
			log.debug("slpSerNo = "+slpSerNo);
			
			fmsConsultationVO.setSlpSerNo(slpSerNo);
			fmsConsultationVO.setOaInvDt(fmsConsultationVO.getOaInvDt().replaceAll("-", ""));
			fmsConsultationVO.setEffDt(fmsConsultationVO.getEffDt().replaceAll("-", ""));
			log.debug("\r\nfmsConsultationVO.getSlpIssDt() : " + fmsConsultationVO.getSlpIssDt());
			fmsConsultationVO.setSlpIssDt(fmsConsultationVO.getSlpIssDt().replaceAll("-", "").substring(2,8));
			fmsConsultationVO.setRqstDt(fmsConsultationVO.getRqstDt().replaceAll("-", ""));
			fmsConsultationVO.setCsrUsrId(signOnUserAccount.getUsr_id());
			fmsConsultationVO.setUpdUsrId(signOnUserAccount.getUsr_id());
			fmsConsultationVO.setCreUsrId(signOnUserAccount.getUsr_id());
			
			fmsConsultationVO.setCxlFlg("N");
			
			if (slpSerNo.equals("00001")) {
				dbDao.addCsulSlpSeq(fmsConsultationVO.getSlpTpCd(), fmsConsultationVO.getSlpFuncCd(), fmsConsultationVO.getSlpOfcCd(), slpSerNo, signOnUserAccount.getUsr_id());
			} else {
				dbDao.modifyCsulSlpSeq(fmsConsultationVO.getSlpTpCd(), fmsConsultationVO.getSlpFuncCd(), fmsConsultationVO.getSlpOfcCd(), slpSerNo, signOnUserAccount.getUsr_id());
			}
			
			dbDao.addOwnersAccountMaster(fmsConsultationVO);			
//---------------------------------------------------------------------------------			
			log.debug("\r\nsFlg : " + sFlg + " | slpSerNo : " + slpSerNo);
			
			List<FmsCsulSlpVO> insertVoList = new ArrayList<FmsCsulSlpVO>();
			
			if(fmsCsulSlpVOs != null) {
				for ( int  i =0; i < fmsCsulSlpVOs.length; i++ ) {
					
					fmsCsulSlpVOs[i].setSlpTpCd(fmsConsultationVO.getSlpTpCd());
					fmsCsulSlpVOs[i].setSlpFuncCd(fmsConsultationVO.getSlpFuncCd());
					fmsCsulSlpVOs[i].setSlpOfcCd(fmsConsultationVO.getSlpOfcCd());
					// fmsCsulSlpVOs[i].setSlpIssDt(fmsConsultationVO.getSlpIssDt());
					fmsCsulSlpVOs[i].setSlpSerNo(fmsConsultationVO.getSlpSerNo());
					fmsCsulSlpVOs[i].setCsrCurrCd(fmsConsultationVO.getCsrCurrCd());
					fmsCsulSlpVOs[i].setCreUsrId(signOnUserAccount.getUsr_id());
					fmsCsulSlpVOs[i].setUpdUsrId(signOnUserAccount.getUsr_id());

					if ( fmsCsulSlpVOs[i].getIbflag().equals("I")){
						insertVoList.add(fmsCsulSlpVOs[i]);
					}
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addOwnersAccountSlips(insertVoList);
			}								
			return slpSerNo;
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}		
	}	
	
	/**
	 * AR_INV_HDR 의  RQST_APRO_STEP_FLG 업데이트<br>
	 * 
	 * @param csr_no String
	 * @exception EventException
	 */
	public void updateApInvHdr(String csr_no) throws EventException{		
		try {
			dbDao.updateApInvHdr(csr_no);
		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01425",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01425",new String[]{}).getMessage(), ex);
		}		
	}
}