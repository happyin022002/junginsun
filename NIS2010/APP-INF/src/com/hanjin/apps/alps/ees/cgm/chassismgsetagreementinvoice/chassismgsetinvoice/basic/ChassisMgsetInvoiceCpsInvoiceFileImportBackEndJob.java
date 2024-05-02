/*==========================================================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChassisMgsetInvoiceCpsInvoiceFileImportBackEndJob.java
*@FileTitle : EES_CGM_1204 Cps Invoice Import & Audit(summary) BackEndJob impl
*Open Issues :
*Change history :
*@LastModifyDate : 2014.07.31
*@LastModifier : Chang Young Kim
*@LastVersion : 1.0
* 2013.03.27 조경완
* 1.0 Creation
* -----------------------------------------------------------------------------------------
* Change History
* 2013.06.26 조경완 [CHM-201324911-01] ALPS-CHSS-COPS 기능 Trouble Shooting을 위한 CSR
* 2014.07.31 Modified by Chang Young Kim
==========================================================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.integration.ChassisMgsetInvoiceDBDAO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSChargeCreationINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSInvoiceImportAuditINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSInvoiceImportAuditMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.basic.ChassisMgsetInventoryVariationStatusBackEndJob;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.backend.BackEndCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;



/**
 * NIS2010-ChassisMgsetMgt Business Logic Basic Command implementation<br>
 * - NIS2010-ChassisMgsetMgt EES_CGM_1102 Status Change 인벤토리 조회(summary) 관련한 BACKEND에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author Chae-Shung Cho
 * @see ChassisMgsetInventoryVariationStatusBackEndJob 각 DAO 클래스 참조
 * @since J2EE 1.4
 */

public class ChassisMgsetInvoiceCpsInvoiceFileImportBackEndJob extends BackEndCommandSupport {
	
	private static final long serialVersionUID = -8569053557386320221L;
	
	/**
	 * Backend job을 위한 DAO
	 */
	private ChassisMgsetInvoiceDBDAO dbDao;

	private CHSInvoiceImportAuditINVO cHSInvoiceImportAuditINVO;
	
	private CHSInvoiceImportAuditINVO[] cHSInvoiceImportAuditINVOs;

	private SignOnUserAccount account = null; 
	


	/**
	 * BackEndJob시작전 VO 객체를 세팅한다.  [EES_CGM_1204] <br>
	 *  
	 * @param CHSInvoiceImportAuditINVO invoiceImportAuditINVO 
	 */		
	public void setCHSInvoiceImportAuditINVO(CHSInvoiceImportAuditINVO cHSInvoiceImportAuditINVO) {
		this.cHSInvoiceImportAuditINVO = cHSInvoiceImportAuditINVO;
	}
	
	public SignOnUserAccount getAccount() {
		return account;
	}

	public void setAccount(SignOnUserAccount account) {
		this.account = account;
	}

	public CHSInvoiceImportAuditINVO getCHSInvoiceImportAuditINVO() {
		return cHSInvoiceImportAuditINVO;
	}

	public CHSInvoiceImportAuditINVO[] getCHSInvoiceImportAuditINVOs() {
		CHSInvoiceImportAuditINVO[] rtnVOs = null;
		if (this.cHSInvoiceImportAuditINVOs != null) {
			rtnVOs = new CHSInvoiceImportAuditINVO[cHSInvoiceImportAuditINVOs.length];
			System.arraycopy(cHSInvoiceImportAuditINVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setCHSInvoiceImportAuditINVOs(CHSInvoiceImportAuditINVO[] cHSInvoiceImportAuditINVOs){
		if(cHSInvoiceImportAuditINVOs != null){
			CHSInvoiceImportAuditINVO[] tmpVOs = Arrays.copyOf(cHSInvoiceImportAuditINVOs, cHSInvoiceImportAuditINVOs.length);
			this.cHSInvoiceImportAuditINVOs = tmpVOs;
		}
	}
	
	/**
	 * Invoice File Import & Audit [EES_CGM_1204]<br>
	 * 
	 * @return List<CHSInventoryByVariationMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */		
	
	@SuppressWarnings("unchecked")
	public List doStart() throws Exception
	{
		List<CHSInvoiceImportAuditINVO> list = new ArrayList<CHSInvoiceImportAuditINVO>();
		this.dbDao = new ChassisMgsetInvoiceDBDAO();
		List<CHSInvoiceImportAuditINVO> list1 = new ArrayList<CHSInvoiceImportAuditINVO>();
		try {
			/*------------------------------
			Delete Charge 
			-------------------------------*/
			// charge sequence 가 존재할 경우만 삭제처리한다.
//			if(!cHSInvoiceImportAuditINVO.getChgCreSeq().equals("")){
//				
//				// CGM_LSE_CHG_DTL 삭제
//				dbDao.removeCHSCpsChargeDetailData(cHSInvoiceImportAuditINVO);
//				
//				// CGM_LSE_CHG_HDR 삭제
//				dbDao.removeCHSCpsChargeSummaryData(cHSInvoiceImportAuditINVO);
//			}
			/*
			 * LOGIC PROCESS (2014.02.07 기준)
			 * 1. CGM_LSE_CHG_HDR 테이블의 CHG_CRE_SEQ+1 생성 ( CGM_LSE_INV_TMP 테이블 작업 용)
			 * 2. CGM_LSE_CHG_HDR 테이블 HDR 데이터 입력 (CGM_AGREEMENT 에서 AGMT 기준으로 추출, 1개만 입력됨)
			 * 3. CGM_LSE_INV_TMP 테이블 삭제 (1. 에서 생성된 CHG_CRE_SEQ 만 삭제)
			 * 4. CGM_AGREEMENT 테이블에서 AGMT_VER_NO 조회 (HDR의 AGMT 기준, 2.와 동일한 데이터 추출됨)
			 * 5. CGM_LSE_INV_TMP 테이블에 EXCEL UPLOAD 된 INVOICE 입력
			 * 6. CGM_LSE_CHG_DTL 삭제(LSE_CHG_AUD_STS_CD = I OR NULL 인것을 대상)
			 * 7. CGM_LSE_CHG_DTL 수정(INVOICE 관련 정보 초기화)
			 * 8. CGM_LSE_CHG_HDR 수정(AMOUNT=0 처리)
			 * 9. CGM_LSE_CHG_DTL 입력(CGM_LSE_INV_TMP 에서 추출)
			 * 10.CGM_LSE_CHG_HDR 적용할 AMT 데이터 조회
			 * 11.CGM_LSE_CHG_HDR AMT 수정
			 */
		
			/*-------------------------------
			 	Charge Create Sequence
			 	CGM_LSE_CHG_HDR 테이블의 CHG_CRE_SEQ+1 생성
			--------------------------------*/
			long chgCreSeq = dbDao.searchCHSChargeCreateSeqData(); 
			cHSInvoiceImportAuditINVO.setChgCreSeq(String.valueOf(chgCreSeq));
			
			/*------------------------------
			  	파라	메터 설정
			-------------------------------*/
			// List<CHSChargeCreationINVO> 값 설정
			List<CHSChargeCreationINVO> chargeList = new ArrayList<CHSChargeCreationINVO>();
			
			
			CHSChargeCreationINVO tempINVO = new CHSChargeCreationINVO();
				
			tempINVO.setCostYrmon(cHSInvoiceImportAuditINVO.getCostYrmon());
			tempINVO.setEqKndCd(cHSInvoiceImportAuditINVO.getEqKndCd());
			tempINVO.setAgmtOfcCtyCd(cHSInvoiceImportAuditINVO.getAgmtOfcCtyCd());
			tempINVO.setAgmtSeq(cHSInvoiceImportAuditINVO.getAgmtSeq());
			tempINVO.setAgmtVerNo(cHSInvoiceImportAuditINVO.getAgmtVerNo());
			tempINVO.setChgCreSeq(String.valueOf(chgCreSeq));
			tempINVO.setCreOfcCd(account.getOfc_cd());
			tempINVO.setCreUsrId(account.getUsr_id());
			tempINVO.setUpdUsrId(account.getUsr_id());
			/* 2014.08.01 Chang Young Kim Added In accordance with the "미확정 CHM" (S) */
			tempINVO.setCmbInvTp(cHSInvoiceImportAuditINVO.getCmbInvTp());
			tempINVO.setInvNo(cHSInvoiceImportAuditINVO.getInvNo());
			tempINVO.setOrgInvNo(cHSInvoiceImportAuditINVO.getOrgInvNo());
			tempINVO.setLseChgStsCd("H");
			/* 2014.08.01 Chang Young Kim Added In accordance with the "미확정 CHM" (E) */
				
			chargeList.add(tempINVO);
	
			
			/*---------------------------
				Create Charge
			----------------------------*/
			
			// Create Charge Summary (header) (TABLE : CGM_LSE_CHG_HDR)
			/* 2014.08.01 Chang Young Kim Added In accordance with the "미확정 CHM" (S) */
			dbDao.addCHSCpsChageCreateSummaryData(chargeList);
			/* 2014.08.01 Chang Young Kim Added In accordance with the "미확정 CHM" (E) */
			// Remove CGM_LSE_INV_TMP 테이블 (where CHG_CRE_SEQ)
			dbDao.removeCHSLeaseInvoiceData(cHSInvoiceImportAuditINVO);
			// Search AGMT_VER_NO in table CGM_AGREEMENT
			String agmtVerNo = "";
			// CHM-201640236 COPS INVOICE 생성시 INVOICE 표기 로직 변경 : Version Parameter로 받아서 진행
			agmtVerNo = cHSInvoiceImportAuditINVO.getAgmtVerNo(); //dbDao.searchCHSAgmtVerNoData(cHSInvoiceImportAuditINVO);
			
			for(int i=0; i < cHSInvoiceImportAuditINVOs.length; i++){
				CHSInvoiceImportAuditINVO tmpChsInvoiceImportAuditINVO = new CHSInvoiceImportAuditINVO();
				
				String sVerifyStatus	= "";//"OK";
				String sAgmtOfcCtyCd	= cHSInvoiceImportAuditINVO.getAgmtOfcCtyCd();
				String sAgmtSeq			= cHSInvoiceImportAuditINVO.getAgmtSeq();
				String sAgmtVerNo		= agmtVerNo;
				String sAgmtLstmCd		= "";
				String sVerifySuccess	= "Y";//"Y";
				
				//공통
				tmpChsInvoiceImportAuditINVO.setEqKndCd(cHSInvoiceImportAuditINVO.getEqKndCd());
				tmpChsInvoiceImportAuditINVO.setCostYrmon(cHSInvoiceImportAuditINVO.getCostYrmon().replaceAll("-", ""));
				tmpChsInvoiceImportAuditINVO.setChgCreSeq(cHSInvoiceImportAuditINVO.getChgCreSeq());
				//EXCEL
				tmpChsInvoiceImportAuditINVO.setInvCustEqNo(cHSInvoiceImportAuditINVOs[i].getInvCustEqNo());
				tmpChsInvoiceImportAuditINVO.setInvEqNo(cHSInvoiceImportAuditINVOs[i].getInvEqNo());								// SML Chassis No.
				tmpChsInvoiceImportAuditINVO.setInvRefNo(cHSInvoiceImportAuditINVOs[i].getInvRefNo());
				
				tmpChsInvoiceImportAuditINVO.setInvNo(cHSInvoiceImportAuditINVO.getInvNo());
				
				tmpChsInvoiceImportAuditINVO.setChgCd(cHSInvoiceImportAuditINVOs[i].getChgCd());									// Charge Type
				tmpChsInvoiceImportAuditINVO.setInvChgTpNm(cHSInvoiceImportAuditINVOs[i].getInvChgTpNm());									// Charge Type
				
				tmpChsInvoiceImportAuditINVO.setInvEqOnhLocNm(cHSInvoiceImportAuditINVOs[i].getInvEqOnhLocNm());
				tmpChsInvoiceImportAuditINVO.setInvEqOnhDt(cHSInvoiceImportAuditINVOs[i].getInvEqOnhDt().replaceAll("-", ""));		// On-Hire Date
				tmpChsInvoiceImportAuditINVO.setInvBilStDt(cHSInvoiceImportAuditINVOs[i].getInvBilStDt().replaceAll("-", ""));		// Billing Start Date
				tmpChsInvoiceImportAuditINVO.setInvEqOffhLocNm(cHSInvoiceImportAuditINVOs[i].getInvEqOffhLocNm());	
				tmpChsInvoiceImportAuditINVO.setInvEqOffhDt(cHSInvoiceImportAuditINVOs[i].getInvEqOffhDt().replaceAll("-", ""));	// Off-Hire Date
				tmpChsInvoiceImportAuditINVO.setInvBilEndDt(cHSInvoiceImportAuditINVOs[i].getInvBilEndDt().replaceAll("-", ""));	// Billing End Date
				tmpChsInvoiceImportAuditINVO.setInvLseUseDys(cHSInvoiceImportAuditINVOs[i].getInvLseUseDys().replaceAll(",", "").replaceAll(" ", ""));
				tmpChsInvoiceImportAuditINVO.setInvLseRtAmt(cHSInvoiceImportAuditINVOs[i].getInvLseRtAmt().replaceAll(",", "").replaceAll(" ", ""));
				tmpChsInvoiceImportAuditINVO.setInvLseChgAmt(cHSInvoiceImportAuditINVOs[i].getInvLseChgAmt().replaceAll(",", "").replaceAll(" ", ""));
				tmpChsInvoiceImportAuditINVO.setTaxSmryAmt(cHSInvoiceImportAuditINVOs[i].getTaxSmryAmt().replaceAll(",", "").replaceAll(" ", ""));
				tmpChsInvoiceImportAuditINVO.setInvTaxAmt(cHSInvoiceImportAuditINVOs[i].getInvTaxAmt());
				tmpChsInvoiceImportAuditINVO.setInvBkgNo(cHSInvoiceImportAuditINVOs[i].getInvBkgNo());
				tmpChsInvoiceImportAuditINVO.setPayLseUseDys(cHSInvoiceImportAuditINVOs[i].getPayLseUseDys());
				tmpChsInvoiceImportAuditINVO.setInvBilUtDys(cHSInvoiceImportAuditINVOs[i].getInvBilUtDys());
				tmpChsInvoiceImportAuditINVO.setInvCustEqTpszNm(cHSInvoiceImportAuditINVOs[i].getInvCustEqTpszNm());
				tmpChsInvoiceImportAuditINVO.setInvGateActId(cHSInvoiceImportAuditINVOs[i].getInvGateActId());
				tmpChsInvoiceImportAuditINVO.setInvBilModRmk(cHSInvoiceImportAuditINVOs[i].getInvBilModRmk());
				//PRE INIT
				tmpChsInvoiceImportAuditINVO.setVrfyRsltDesc(sVerifyStatus);
				tmpChsInvoiceImportAuditINVO.setAgmtOfcCtyCd(sAgmtOfcCtyCd);
				tmpChsInvoiceImportAuditINVO.setAgmtSeq(sAgmtSeq);
				tmpChsInvoiceImportAuditINVO.setAgmtVerNo(sAgmtVerNo);
				tmpChsInvoiceImportAuditINVO.setAgmtLstmCd(sAgmtLstmCd);
				tmpChsInvoiceImportAuditINVO.setVrfyScsFlg(sVerifySuccess);		
				
				tmpChsInvoiceImportAuditINVO.setCreUsrId(account.getUsr_id());
				tmpChsInvoiceImportAuditINVO.setUpdUsrId(account.getUsr_id());
				
				list1.add(tmpChsInvoiceImportAuditINVO);
			}			
			if(list1.size()>0)
			{
				dbDao.addCHSCpsLeaseInvoiceData(list1);  // Insert to CGM_LSE_INV_TMP (invoice excel upload)
			}
			//--------------------------------------------
		 	//	데이터 삭제 처리
			//--------------------------------------------
			CHSInvoiceImportAuditINVO chsInvoiceImportAuditINVO3 = cHSInvoiceImportAuditINVO;
			chsInvoiceImportAuditINVO3.setUpdUsrId(account.getUsr_id());
			chsInvoiceImportAuditINVO3.setLseChgAudStsCd("H");
			chsInvoiceImportAuditINVO3.setLseChgStsCd("H");
			chsInvoiceImportAuditINVO3.setPayLseChgStsCd("H");
			
			dbDao.removeCHSInvImportDtlData(chsInvoiceImportAuditINVO3); // CGM_LSE_CHG_DTL 삭제
			dbDao.modifyCHSInvImportDtlData(chsInvoiceImportAuditINVO3); // CGM_LSE_CHG_DTL 수정(INVOICE 관련정보 초기화)
			dbDao.modifyCHSInvImportHdrData(chsInvoiceImportAuditINVO3); // CGM_LSE_CHG_HDR 수정(AMOUNT=0 처리)
		
			
			//--------------------------------------------
	 		//	데이터 Audit 처리 시작
		 	//--------------------------------------------
			

			
			cHSInvoiceImportAuditINVO.setAgmtVerNo(agmtVerNo);
			cHSInvoiceImportAuditINVO.setCreUsrId(account.getUsr_id());
			cHSInvoiceImportAuditINVO.setUpdUsrId(account.getUsr_id());
			
			dbDao.addCHSCpsAuditInvoiceDetailData(cHSInvoiceImportAuditINVO);  // CGM_LSE_CHG_DTL 입력
//			dbDao.modifyCHSAuditInvoiceDetailData(updateList);
//			dbDao.modifyCHSChargeOnlyUmchStatusData(cHSInvoiceImportAuditINVO);
			
			// Header Data 저장
			List<CHSInvoiceImportAuditMGTVO> targetList = dbDao.searchCHSInvImportSumAmtData(cHSInvoiceImportAuditINVO); // HDR AMT 수정할 데이터 조회
			List<CHSInvoiceImportAuditINVO> headerList = new ArrayList<CHSInvoiceImportAuditINVO>();
			for(int x=0; x < targetList.size(); x++){
				
				CHSInvoiceImportAuditMGTVO targetData = (CHSInvoiceImportAuditMGTVO)targetList.get(x);
				
				CHSInvoiceImportAuditINVO headerData = new CHSInvoiceImportAuditINVO();
				
				headerData.setAgmtOfcCtyCd(targetData.getAgmtOfcCtyCd());
				headerData.setAgmtSeq(targetData.getAgmtSeq());
				headerData.setCostYrmon(targetData.getCostYrmon());
				headerData.setEqKndCd(targetData.getEqKndCd());
				
				headerData.setAgmtVerNo(targetData.getAgmtVerNo());  		// 추가된 조건, 2014-02-07, 신용찬
				headerData.setCostYrmonSeq(targetData.getCostYrmonSeq());   // 추가된 조건, 2014-02-07, 신용찬
				
				headerData.setLseChgStsCd("A");	// AUDIT
				headerData.setCurrCd(cHSInvoiceImportAuditINVO.getCurrCd());
				headerData.setTaxSmryAmt(targetData.getTaxSmryAmt());
				headerData.setInvSmryAmt(targetData.getInvSmryAmt());
				headerData.setCrSmryAmt(targetData.getCrSmryAmt());
				headerData.setUpdUsrId(account.getUsr_id());
				
				headerList.add(headerData);
			}
			dbDao.modifyCHSAuditInvoiceHeaderData(headerList); // CGM_LSE_CHG_HDR 테이블 AMOUNT 업데이트
			list.add(cHSInvoiceImportAuditINVO);
		}catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(ex.getMessage(),ex);
		}
		return list;
	
	}
}