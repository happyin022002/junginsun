/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TCharterIOSettlementBCImpl.java
*@FileTitle : Owner's Account to Expenses
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.25
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.05.25 윤세영
* 1.0 Creation
* -----------------------------------------------------------
* 2012.02.14 조병연 [CHM-201216090-01] 수정 
* 세금 계산서 기능보안
* 세금계산서 처리에서 영세 부분도 과세와 동일하게 처리.
* 
* 2012.06.07 전상화 [CHM-201218327] 수정 
* 세금 계산서 기능보안
* Payment Slip 에서 '영세 Tax Evidence' 를 선택했을 때,  발생하는 오류 수정
* 
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.basic;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.xmlbeans.XmlObject;

import com.hanjin.apps.alps.esm.fms.ownersaccount.basic.OwnersAccountBC;
import com.hanjin.apps.alps.esm.fms.ownersaccount.basic.OwnersAccountBCImpl;
import com.hanjin.apps.alps.esm.fms.ownersaccount.vo.FmsConsultationVO;
import com.hanjin.apps.alps.esm.fms.ownersaccount.vo.FmsCsulSlpVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.arapproval.basic.ArApprovalBC;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.arapproval.basic.ArApprovalBCImpl;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobunkerregister.basic.TCharterIOBunkerRegisterBC;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobunkerregister.basic.TCharterIOBunkerRegisterBCImpl;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.integration.TCharterIOConsultationDBDAO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.integration.TCharterIOConsultationEAIDAO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CondReverseCsrForSubletVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CondSearchInterfaceStatusVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CondSearchInvoiceNoVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CondSearchSlipApprovalVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CondSearchSubletRevenueVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomArSlipApprovalDetailVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomArSlipApprovalHeaderVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomConsultationVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomCsulSlpSeqVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomCsulSlpVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomInterfaceStatusVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomPamConsultationVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomPamCsulSlpVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomSlipApprovalDetailVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomSlipApprovalHeaderVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomTaxDtlVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomTaxVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchApSlipDetailListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchApSlipInterfaceListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchApVatSlipListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchArSlipDetailListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchBrokerageListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchCustomerCodeVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchInterfaceStatusDetailListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchInterfaceStatusListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchInvoiceNoListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchManualSlipListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchPaymentSlipListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchReverseCsrForSubletListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchReverseCsrForSubletSaveListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchSlipApprovalBillDetailVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchSlipApprovalBillVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchSlipApprovalCsrVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchSlipApprovalListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchSlipApprovalOfficeVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchSlipApprovalOwnerVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchSlipApprovalTaxDetailVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchSlipApprovalTaxVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchSlipCorrectionDetailListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchSlipCorrectionListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchSlipDetailListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchSubletRevenueListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchSubletRevenueSlipListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchSubletReveuneDetailListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchTaxDetailEvidenceListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchTaxMasterEvidenceVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchVvdListByManualSlipVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.basic.TCharterIOInvoiceBC;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.basic.TCharterIOInvoiceBCImpl;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CustomPreInvoiceVO;
import com.hanjin.bizcommon.approval.util.ApprovalUtil;
import com.hanjin.bizcommon.csr.csrapproval.vo.ComCsrRequestAgmtVO;
import com.hanjin.bizcommon.csr.csrapproval.vo.ComCsrRequestBodyVO;
import com.hanjin.bizcommon.csr.csrapproval.vo.ComCsrRequestFileVO;
import com.hanjin.bizcommon.csr.csrapproval.vo.ComCsrRequestHeaderVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.irep.erp.FNS012R002Document;
import com.hanjin.irep.erp.FNS012R002Document.FNS012R002;
import com.hanjin.syscommon.common.table.ComAproCsrDtlVO;
import com.hanjin.syscommon.common.table.ComAproRqstHdrVO;
import com.hanjin.syscommon.common.table.ComAproRqstRoutVO;

/**
 * NIS2010-TimeCharterInOutAccounting Business Logic Basic Command implementation<br>
 * - NIS2010-TimeCharterInOutAccounting에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Yoon, Seyeong 
 * @see ESM_FMS_0039EventResponse,TCharterIOSettlementBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class TCharterIOConsultationBCImpl extends BasicCommandSupport implements TCharterIOConsultationBC {

	// Database Access Object
	private transient TCharterIOConsultationDBDAO dbDao = null;
	private transient TCharterIOConsultationEAIDAO eaiDao = null;

	/**
	 * TCharterIOSettlementBCImpl 객체 생성<br>
	 * TCharterIOSettlementDBDAO를 생성한다.<br>
	 */
	public TCharterIOConsultationBCImpl() {
		dbDao = new TCharterIOConsultationDBDAO();
		eaiDao = new TCharterIOConsultationEAIDAO();
	}
	
	/**
	 * Owner'sAccount Expense 데이터를 등록한다<br>
	 * 
	 * @param customConsultationVO CustomConsultationVO
	 * @param customCsulSlpVOs CustomCsulSlpVO[]
	 * @param usrId String
	 * @return slpSerNo String
	 * @exception EventException
	 */
	public String creationOwnerAccountExpense(CustomConsultationVO customConsultationVO, CustomCsulSlpVO[] customCsulSlpVOs, String usrId) throws EventException{
		
		try {
			
			//전표 생성 번호 저장
			String slpSerNo = dbDao.searchCsulSlpSeq(customConsultationVO.getSlpTpCd(), customConsultationVO.getSlpFuncCd(), customConsultationVO.getSlpOfcCd());
			
			customConsultationVO.setSlpSerNo(slpSerNo);
			customConsultationVO.setEffDt(customConsultationVO.getEffDt().replaceAll("-", ""));
			customConsultationVO.setSlpIssDt(customConsultationVO.getSlpIssDt().replaceAll("-", ""));
			customConsultationVO.setCsrUsrId(usrId);
			customConsultationVO.setCreUsrId(usrId);

			if (slpSerNo.equals("00001")) {
				dbDao.addCsulSlpSeq ( customConsultationVO.getSlpTpCd(), customConsultationVO.getSlpFuncCd(), customConsultationVO.getSlpOfcCd() , slpSerNo , usrId );
			} else {
				dbDao.modifyCsulSlpSeq ( customConsultationVO.getSlpTpCd(), customConsultationVO.getSlpFuncCd(), customConsultationVO.getSlpOfcCd() , slpSerNo , usrId );
			}

			//Owner's Account Expense 저장
			List<CustomCsulSlpVO> addCsulSlpVoList = new ArrayList<CustomCsulSlpVO>();

			for ( int i=0; i<customCsulSlpVOs .length; i++ ) {
				if ( customCsulSlpVOs[i].getApplyChk().equals("1")){
					
					String acctCd = customCsulSlpVOs[i].getAcctCd();
					
					customCsulSlpVOs[i].setSlpTpCd(customConsultationVO.getSlpTpCd());
					customCsulSlpVOs[i].setSlpFuncCd(customConsultationVO.getSlpFuncCd());
					customCsulSlpVOs[i].setSlpOfcCd(customConsultationVO.getSlpOfcCd());
					customCsulSlpVOs[i].setSlpIssDt(customConsultationVO.getSlpIssDt());
					customCsulSlpVOs[i].setSlpSerNo(customConsultationVO.getSlpSerNo());
					customCsulSlpVOs[i].setCsrDesc(customConsultationVO.getCsrDesc());

					//Vendor Code
					customCsulSlpVOs[i].setVndrSeq(customConsultationVO.getVndrSeq());

					customCsulSlpVOs[i].setCreUsrId(usrId);

					//신규  계정으로 + 금액 만들기
					CustomCsulSlpVO customCsulSlpVO = new CustomCsulSlpVO();
					customCsulSlpVO = (CustomCsulSlpVO)customCsulSlpVOs[i].clone();
					customCsulSlpVO.setAcctCd(customCsulSlpVOs[i].getRvsAcctCd());
					addCsulSlpVoList.add(customCsulSlpVO);

					//기존 계정으로 - 금액 만들기
					customCsulSlpVOs[i].setAcctCd(acctCd);
					if (customCsulSlpVOs[i].getN1stAmt().substring(0,1).equals("-")) {
						customCsulSlpVOs[i].setN1stAmt(customCsulSlpVOs[i].getN1stAmt().substring(1));
					} else {
						customCsulSlpVOs[i].setN1stAmt("-"+customCsulSlpVOs[i].getN1stAmt());
					}
					addCsulSlpVoList.add(customCsulSlpVOs[i]);
				}
			}
			
			if ( addCsulSlpVoList.size() > 0 ) {
				dbDao.addOwnerAccountExpenses(customConsultationVO, addCsulSlpVoList);
			}
			
			return slpSerNo;

		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01504",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01504",new String[]{}).getMessage(), ex);
		}
		
	}
	
	/**
	 * Sublet Revenue slip(대선 전표)를 생성한다<br>
	 * 변경된 자료를 변경한다<br>
	 * 
	 * @param customConsultationVO CustomConsultationVO
	 * @param customCsulSlpVOs CustomCsulSlpVO[]
	 * @param SignOnUserAccount signOnUserAccount
	 * @return String
	 * @exception EventException
	 */
	public String manageSubletRevenueSlip(CustomConsultationVO customConsultationVO, CustomCsulSlpVO[] customCsulSlpVOs, SignOnUserAccount signOnUserAccount) throws EventException{
		try {
			
			// 전표 생성 번호 저장
			String slpSerNo = dbDao.searchCsulSlpSeq(customConsultationVO.getSlpTpCd(), customConsultationVO.getSlpFuncCd(), customConsultationVO.getSlpOfcCd());
			if (slpSerNo.equals("00001")) {
				dbDao.addCsulSlpSeq (customConsultationVO.getSlpTpCd(), customConsultationVO.getSlpFuncCd(), customConsultationVO.getSlpOfcCd(), slpSerNo, signOnUserAccount.getUsr_id());
			} else {
				dbDao.modifyCsulSlpSeq (customConsultationVO.getSlpTpCd(), customConsultationVO.getSlpFuncCd(), customConsultationVO.getSlpOfcCd(), slpSerNo, signOnUserAccount.getUsr_id());
			}
			
			customConsultationVO.setSlpSerNo(slpSerNo);
			customConsultationVO.setEffDt(customConsultationVO.getEffDt().replaceAll("-", ""));
			customConsultationVO.setSlpIssDt(customConsultationVO.getSlpIssDt().replaceAll("-", ""));
			customConsultationVO.setCsrUsrId(signOnUserAccount.getUsr_id());
			customConsultationVO.setUpdUsrId(signOnUserAccount.getUsr_id());
			customConsultationVO.setCreUsrId(signOnUserAccount.getUsr_id());

			dbDao.addMasterSubletRevenueSlip(customConsultationVO);
			
			List<CustomCsulSlpVO> addCsulSlpList = new ArrayList<CustomCsulSlpVO>();
			
			log.debug("\rcustomCsulSlpVOs.length : " + customCsulSlpVOs.length);
			for ( int i=0; i<customCsulSlpVOs .length; i++ ) {
				if ( customCsulSlpVOs[i].getIbflag().equals("I")){
					customCsulSlpVOs[i].setSlpSerNo(slpSerNo);
					customCsulSlpVOs[i].setSlpIssDt(customCsulSlpVOs[i].getSlpIssDt().replaceAll("-", ""));
					customCsulSlpVOs[i].setVvdEffDt(customCsulSlpVOs[i].getVvdEffDt().replaceAll("-", ""));
					customCsulSlpVOs[i].setVvdExpDt(customCsulSlpVOs[i].getVvdExpDt().replaceAll("-", ""));
					if(customCsulSlpVOs[i].getAcctCd().equals("110811")) {
						customCsulSlpVOs[i].setFletSrcTpCd("R1");
					} else if(   customCsulSlpVOs[i].getAcctCd().equals("954112")
							  || customCsulSlpVOs[i].getAcctCd().equals("954113")
							  || customCsulSlpVOs[i].getAcctCd().equals("954111")) {
						customCsulSlpVOs[i].setFletSrcTpCd("R6");
					}
					customCsulSlpVOs[i].setUpdUsrId(signOnUserAccount.getUsr_id());
					customCsulSlpVOs[i].setCreUsrId(signOnUserAccount.getUsr_id());
					addCsulSlpList.add(customCsulSlpVOs[i]);
				}
				log.debug("customCsulSlpVOs[i].getAcctCd() >>> " + customCsulSlpVOs[i].getAcctCd()
						+ "customCsulSlpVOs[i].getSlpSerNo() >>> " + customCsulSlpVOs[i].getSlpSerNo()
						+ "customCsulSlpVOs[i].getSlpSeqNo() >>> " + customCsulSlpVOs[i].getSlpSeqNo());
			}

			if ( addCsulSlpList.size() > 0 ) {
				dbDao.addSubletRevenueSlips(addCsulSlpList);
			}
			
			/***************************
			 * 결재라인 지정
			 ***************************/
			customConsultationVO.setMaxRows(customConsultationVO.getMaxRows()); //결재라인의 count를 위해
			this.createCSREPApproval(customConsultationVO, signOnUserAccount);

			return slpSerNo;

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS01410",new String[]{}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01410",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Sublet Revenue slip(대선 전표)를 조건으로 해서 대선 전표 계정 자료를 조회한다<br>
	 * 
	 * @param customCsulSlpSeqVO CustomCsulSlpSeqVO
	 * @return List<SearchSubletRevenueSlipListVO>
	 * @exception EventException
	 */
	public List<SearchSubletRevenueSlipListVO> searchSubletRevenueSlipList(CustomCsulSlpSeqVO customCsulSlpSeqVO) throws EventException {
		try {
			customCsulSlpSeqVO.setSlpIssDt(customCsulSlpSeqVO.getSlpIssDt().replaceAll("-", ""));
			return dbDao.searchSubletRevenueSlipList(customCsulSlpSeqVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS01410",new String[]{}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01410",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * 자발적, 비자발적 오류 처리할 전표에 대한 취소 작업 진행한다<br>
	 * 
	 * @param customInterfaceStatusVOs CustomInterfaceStatusVO[]
	 * @param statusFlag String
	 * @param SignOnUserAccount signOnUserAccount
	 * @param aproStep String
	 * @exception EventException
	 */
	public void manageInterfaceStatus(CustomInterfaceStatusVO[] customInterfaceStatusVOs, String statusFlag, SignOnUserAccount signOnUserAccount, String aproStep) throws EventException{
		
		try {
			
			CustomInterfaceStatusVO customInterfaceStatusVO = new CustomInterfaceStatusVO();
			customInterfaceStatusVO = (CustomInterfaceStatusVO)customInterfaceStatusVOs[0].clone();
			customInterfaceStatusVO.setCreUsrId(signOnUserAccount.getUsr_id());
			customInterfaceStatusVO.setUpdUsrId(signOnUserAccount.getUsr_id());
			customInterfaceStatusVO.setAproStep(aproStep);

			//전표 생성 번호 저장
			String slpSerNo = null;
			String slpOfcCd = customInterfaceStatusVOs[0].getSlpOfcCd();

			if (statusFlag.equals("E")) {// ERP I/F Error
				
				//FMS_CONSULTATION의 CXL_FLG='Y',CXL_DESC=INVOICE INTERFACE ERROR로 업데이트
				dbDao.modifyInterfaceStatusCsrCancel(customInterfaceStatusVO);

			} else {// A/P Cancellation
				//FMS_CONSULTATION의 AP_CXL_FLG='Y' Reject
				dbDao.modifyInterfaceStatusApCsrCancel(customInterfaceStatusVO);

				slpSerNo = dbDao.searchCsulSlpSeq(customInterfaceStatusVOs[0].getSlpTpCd(), customInterfaceStatusVOs[0].getSlpFuncCd(), slpOfcCd);
				
				if (slpSerNo.equals("00001")) {
					dbDao.addCsulSlpSeq ( customInterfaceStatusVOs[0].getSlpTpCd(), customInterfaceStatusVOs[0].getSlpFuncCd(), slpOfcCd , slpSerNo , signOnUserAccount.getUsr_id() );
				} else {
					dbDao.modifyCsulSlpSeq ( customInterfaceStatusVOs[0].getSlpTpCd(), customInterfaceStatusVOs[0].getSlpFuncCd(), slpOfcCd , slpSerNo , signOnUserAccount.getUsr_id() );
				}
				
				List<CustomInterfaceStatusVO> insertVoList = new ArrayList<CustomInterfaceStatusVO>();
		
				for ( int i=0; i<customInterfaceStatusVOs.length; i++ ) {

					customInterfaceStatusVOs[i].setCreUsrId(signOnUserAccount.getUsr_id());
					customInterfaceStatusVOs[i].setSlpSerNo(slpSerNo);
					customInterfaceStatusVOs[i].setSlpOfcCd(slpOfcCd);

					insertVoList.add(customInterfaceStatusVOs[i]);
					
				}
				
				customInterfaceStatusVO.setSlpSerNo(slpSerNo);
				dbDao.addInterfaceStatusRefectCsrMaster(customInterfaceStatusVO);
				
				if ( insertVoList.size() > 0 ) {
					dbDao.addInterfaceStatusRefectCsrSlip(insertVoList);
				}
				
				
				//ERP Cancelled 전표 시 20T 역분개 전표 자동 생성
				String pcsrNo = null;
				CustomInterfaceStatusVO customInterfaceStatusVO2 = new CustomInterfaceStatusVO();
				
				pcsrNo = dbDao.searchArCsrNo(customInterfaceStatusVOs[0].getOrgSlpTpCd(), customInterfaceStatusVOs[0].getOrgSlpFuncCd(), customInterfaceStatusVOs[0].getOrgSlpOfcCd(), customInterfaceStatusVOs[0].getOrgSlpIssDt(), customInterfaceStatusVOs[0].getOrgSlpSerNo());
				
				if (!pcsrNo.equals("")) {
				
					slpSerNo = dbDao.searchCsulSlpSeq("20", "T", slpOfcCd);
					
					if (slpSerNo.equals("00001")) {
						dbDao.addCsulSlpSeq ( "20", "T", slpOfcCd , slpSerNo , signOnUserAccount.getUsr_id() );
					} else {
						dbDao.modifyCsulSlpSeq ( "20", "T", slpOfcCd , slpSerNo , signOnUserAccount.getUsr_id() );
					}
					
					customInterfaceStatusVO2.setSlpTpCd("20");
					customInterfaceStatusVO2.setSlpFuncCd("T");
					customInterfaceStatusVO2.setSlpOfcCd(slpOfcCd);
					customInterfaceStatusVO2.setSlpIssDt(customInterfaceStatusVOs[0].getSlpIssDt());
					customInterfaceStatusVO2.setSlpSerNo(slpSerNo);
					customInterfaceStatusVO2.setCreUsrId(signOnUserAccount.getUsr_id());
					customInterfaceStatusVO2.setUpdUsrId(signOnUserAccount.getUsr_id());
					
					customInterfaceStatusVO2.setOrgSlpTpCd("20");
					customInterfaceStatusVO2.setOrgSlpFuncCd("T");
					customInterfaceStatusVO2.setOrgSlpOfcCd(slpOfcCd);
					customInterfaceStatusVO2.setOrgSlpIssDt(pcsrNo.substring(9, 15));
					customInterfaceStatusVO2.setOrgSlpSerNo(pcsrNo.substring(15, 20));
					
					customInterfaceStatusVO2.setAproStep(aproStep);
					
					dbDao.addInterfaceStatusRefectCsrMaster(customInterfaceStatusVO2);
					
					List<CustomInterfaceStatusVO> insertVoList2 = new ArrayList<CustomInterfaceStatusVO>();
	
					int j = 0;
					for ( int i=0; i < 4; i++ ) {
		
						CustomInterfaceStatusVO customInterfaceStatusVO3 = new CustomInterfaceStatusVO();
						
						customInterfaceStatusVO3.setSlpTpCd("20");
						customInterfaceStatusVO3.setSlpFuncCd("T");
						customInterfaceStatusVO3.setSlpOfcCd(slpOfcCd);
						customInterfaceStatusVO3.setSlpIssDt(customInterfaceStatusVOs[0].getSlpIssDt());
						customInterfaceStatusVO3.setSlpSerNo(slpSerNo);
						customInterfaceStatusVO3.setCreUsrId(signOnUserAccount.getUsr_id());
						customInterfaceStatusVO3.setUpdUsrId(signOnUserAccount.getUsr_id());
						
						customInterfaceStatusVO3.setOrgSlpTpCd("20");
						customInterfaceStatusVO3.setOrgSlpFuncCd("T");
						customInterfaceStatusVO3.setOrgSlpOfcCd(slpOfcCd);
						customInterfaceStatusVO3.setOrgSlpIssDt(pcsrNo.substring(9, 15));
						customInterfaceStatusVO3.setOrgSlpSerNo(pcsrNo.substring(15, 20));
						
						j = i+1;
						customInterfaceStatusVO3.setOrgSlpSeqNo("000"+j);
	
						insertVoList2.add(customInterfaceStatusVO3);
					}
								
					if ( insertVoList2.size() > 0 ) {
						dbDao.addInterfaceStatusRefectCsrSlip2(insertVoList2);
					}
					
					/***************************
					 * 결재라인 지정
					 ***************************/
					customInterfaceStatusVO2.setMaxRows(customInterfaceStatusVO2.getMaxRows()); //결재라인의 count를 위해
					this.createCSREPApproval2(customInterfaceStatusVO2, signOnUserAccount);
				}	
			}
			
			//정산 전표의 경우 선급금 원전표의 FMS_CSUL_SLP.STL_FLG=N 처리함. 
			List<CustomInterfaceStatusVO> modifyVoList = new ArrayList<CustomInterfaceStatusVO>();
			
			for ( int i=0; i<customInterfaceStatusVOs.length; i++ ) {

				if (!customInterfaceStatusVOs[0].getPreSlpTpCd().equals("")) {
					customInterfaceStatusVOs[i].setUpdUsrId(signOnUserAccount.getUsr_id());

					modifyVoList.add(customInterfaceStatusVOs[i]);
				}
				
			}
			
			if (modifyVoList.size() > 0) {
				dbDao.modifyInterfaceStatusSlip(modifyVoList);
			}
	
		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01425",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01425",new String[]{}).getMessage(), ex);
		}
		
	}

	/**
	 * 자발적, 비자발적 오류 처리할 전표를 조회한다<br>
	 * 
	 * @param condSearchInterfaceStatusVO CondSearchInterfaceStatusVO
	 * @return List<SearchInterfaceStatusListVO>
	 * @exception EventException
	 */
	public List<SearchInterfaceStatusListVO> searchInterfaceStatusList(CondSearchInterfaceStatusVO condSearchInterfaceStatusVO) throws EventException {
		try {
			return dbDao.searchInterfaceStatusList(condSearchInterfaceStatusVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS01414",new String[]{}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01414",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * 자발적, 비자발적 오류 처리할 전표를 계정별 조회한다<br>
	 * 
	 * @param csrNo String
	 * @return List<SearchInterfaceStatusDetailListVO>
	 * @exception EventException
	 */
	public List<SearchInterfaceStatusDetailListVO> searchInterfaceStatusDetailList(String csrNo) throws EventException {
		try {
			return dbDao.searchInterfaceStatusDetailList(csrNo);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS01426",new String[]{}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01426",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * 기 지급한 선급금을 실제 비용 계정으로 정리하여 전표를 생성한다<br>
	 * 
	 * @param customConsultationVO CustomConsultationVO
	 * @param customCsulSlpVOs CustomCsulSlpVO[]
	 * @param SignOnUserAccount signOnUserAccount
	 * @return String
	 * @exception EventException
	 */
	public String managePrepaymentSettlement(CustomConsultationVO customConsultationVO, CustomCsulSlpVO[] customCsulSlpVOs, SignOnUserAccount signOnUserAccount) throws EventException{
		
		try {
			
			//전표 생성 번호 저장
			String slpSerNo = dbDao.searchCsulSlpSeq(customConsultationVO.getSlpTpCd(), customConsultationVO.getSlpFuncCd(), customConsultationVO.getSlpOfcCd());
			
			customConsultationVO.setSlpSerNo(slpSerNo);
			customConsultationVO.setEffDt(customConsultationVO.getEffDt().replaceAll("-", ""));
			customConsultationVO.setSlpIssDt(customConsultationVO.getSlpIssDt().replaceAll("-", ""));
			customConsultationVO.setCsrUsrId(signOnUserAccount.getUsr_id());
			customConsultationVO.setCsrUsrId(signOnUserAccount.getUsr_id());
			customConsultationVO.setCreUsrId(signOnUserAccount.getUsr_id());
	
			if (slpSerNo.equals("00001")) {
				dbDao.addCsulSlpSeq ( customConsultationVO.getSlpTpCd(), customConsultationVO.getSlpFuncCd(), customConsultationVO.getSlpOfcCd() , slpSerNo , signOnUserAccount.getUsr_id() );
			} else {
				dbDao.modifyCsulSlpSeq ( customConsultationVO.getSlpTpCd(), customConsultationVO.getSlpFuncCd(), customConsultationVO.getSlpOfcCd() , slpSerNo , signOnUserAccount.getUsr_id() );
			}
	
			List<CustomCsulSlpVO> addCsulSlpVoList = new ArrayList<CustomCsulSlpVO>();
			List<CustomCsulSlpVO> modifyCsulSlpVoList = new ArrayList<CustomCsulSlpVO>();

			for ( int i=0; i<customCsulSlpVOs .length; i++ ) {
					
				customCsulSlpVOs[i].setSlpTpCd(customConsultationVO.getSlpTpCd());
				customCsulSlpVOs[i].setSlpFuncCd(customConsultationVO.getSlpFuncCd());
				customCsulSlpVOs[i].setSlpOfcCd(customConsultationVO.getSlpOfcCd());
				customCsulSlpVOs[i].setSlpIssDt(customConsultationVO.getSlpIssDt());
				customCsulSlpVOs[i].setSlpSerNo(customConsultationVO.getSlpSerNo());
				customCsulSlpVOs[i].setCsrCurrCd(customConsultationVO.getCsrCurrCd());

				customCsulSlpVOs[i].setCreUsrId(signOnUserAccount.getUsr_id());

				addCsulSlpVoList.add(customCsulSlpVOs[i]);
				
				if (i==0) {
					customCsulSlpVOs[i].setUpdUsrId(signOnUserAccount.getUsr_id());
					modifyCsulSlpVoList.add(customCsulSlpVOs[i]);
					
					//선급금 금액을 세팅
					customConsultationVO.setCsrAmt(customCsulSlpVOs[i].getCsrAmt());
				}
			}

			dbDao.addPrepaymentSettlementMaster(customConsultationVO);
			
			if ( addCsulSlpVoList.size() > 0 ) {
				dbDao.addPrepaymentSettlementSlips(addCsulSlpVoList);
			}
			if ( modifyCsulSlpVoList.size() > 0 ) {
				dbDao.modifyPrepaymentSettlements(modifyCsulSlpVoList);
			}
			
			/***************************
			 * 결재라인 지정
			 ***************************/
			customConsultationVO.setMaxRows(customConsultationVO.getMaxRows()); //결재라인의 count를 위해
			this.createCSREPApproval(customConsultationVO, signOnUserAccount);
			
			return slpSerNo;
	
		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01500",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01500",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * 작성된 채권에 대한 채권 계상액 Detail History 조회한다<br>
	 * 
	 * @param condSearchSubletRevenueVO CondSearchSubletRevenueVO
	 * @return List<SearchSubletRevenueListVO>
	 * @exception EventException
	 */
	public List<SearchSubletRevenueListVO> searchSubletReveuneList(CondSearchSubletRevenueVO condSearchSubletRevenueVO) throws EventException {
		try {
			return dbDao.searchSubletReveuneList(condSearchSubletRevenueVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS01411",new String[]{}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01411",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * 작성된 채권에 대한 채권 계상액 Detail History 조회한다<br>
	 * 
	 * @param toInvNo String
	 * @return List<SearchSubletReveuneDetailListVO>
	 * @exception EventException
	 */
	public List<SearchSubletReveuneDetailListVO> searchSubletReveuneDetailList(String toInvNo) throws EventException {
		try {
			return dbDao.searchSubletReveuneDetailList(toInvNo);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS01424",new String[]{}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01424",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * 작성된 전표의 조건별 Slip Approval Master 정보를 조회한다<br>
	 * 
	 * @param condSearchSlipApprovalVO CondSearchSlipApprovalVO
	 * @param String userId
	 * @return List<SearchSlipApprovalListVO>
	 * @exception EventException
	 */
	public List<SearchSlipApprovalListVO> searchSlipApprovalList(CondSearchSlipApprovalVO condSearchSlipApprovalVO, String userId) throws EventException {
		try {
			return dbDao.searchSlipApprovalList(condSearchSlipApprovalVO, userId);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS01417",new String[]{}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01417",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * 작성된 전표의 조건별 Submit to GW 정보를 조회한다<br>
	 * 
	 * @param condSearchSlipApprovalVO CondSearchSlipApprovalVO
	 * @return List<SearchSlipApprovalListVO>
	 * @exception EventException
	 */
	public List<SearchSlipApprovalListVO> searchSlipSubmitToGWList(CondSearchSlipApprovalVO condSearchSlipApprovalVO) throws EventException {
		try {
			return dbDao.searchSlipSubmitToGWList(condSearchSlipApprovalVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS01417",new String[]{}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01417",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * 작성된 전표의 조건별 Slip Inquiry Master 정보를 조회한다<br>
	 * 
	 * @param condSearchSlipApprovalVO CondSearchSlipApprovalVO
	 * @return List<SearchSlipApprovalListVO>
	 * @exception EventException
	 */
	public List<SearchSlipApprovalListVO> searchSlipInquiryList(CondSearchSlipApprovalVO condSearchSlipApprovalVO) throws EventException {
		try {
			return dbDao.searchSlipInquiryList(condSearchSlipApprovalVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS01417",new String[]{}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01417",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * 기 결제된 채권번호를 조회한다<br>
	 * 
	 * @param condSearchInvoiceNoVO CondSearchInvoiceNoVO
	 * @return List<SearchInvoiceNoListVO>
	 * @exception EventException
	 */
	public List<SearchInvoiceNoListVO> searchInvoiceNoList(CondSearchInvoiceNoVO condSearchInvoiceNoVO) throws EventException {
		try {
			return dbDao.searchInvoiceNoList(condSearchInvoiceNoVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS01413",new String[]{}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01413",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * 작성된 전표의 조건별 Slip Inquiry Detail 정보를 조회한다<br>
	 * 
	 * @param csrNo String
	 * @return List<SearchSlipDetailListVO>
	 * @exception EventException
	 */
	public List<SearchSlipDetailListVO> searchSlipDetailList(String csrNo) throws EventException {
		try {
			return dbDao.searchSlipDetailList(csrNo);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS01420",new String[]{}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01420",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * 작성된 전표의 조건별 Slip Correction - Master 정보를 조회한다<br>
	 * 
	 * @param condSearchSlipApprovalVO CondSearchSlipApprovalVO
	 * @return List<SearchSlipCorrectionListVO>
	 * @exception EventException
	 */
	public List<SearchSlipCorrectionListVO> searchSlipCorrectionList(CondSearchSlipApprovalVO condSearchSlipApprovalVO) throws EventException {
		try {
			return dbDao.searchSlipCorrectionList(condSearchSlipApprovalVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS01417",new String[]{}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01417",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Slip Correction 에서 Slip Master 의 Description 를 수정한다<br>
	 * 
	 * @param csrNo String
	 * @param csrDesc String
	 * @param usrId String
	 * @exception EventException
	 */
	public void modifySlipCorrection(String csrNo, String csrDesc, String usrId) throws EventException {
		try {
			
			dbDao.modifySlipCorrection(csrNo, csrDesc, usrId);

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS01421",new String[]{}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01421",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * 작성된 전표의 조건별 Slip Correction - Detail 정보를 조회한다<br>
	 * 
	 * @param csrNo String
	 * @return List<SearchSlipCorrectionDetailListVO>
	 * @exception EventException
	 */
	public List<SearchSlipCorrectionDetailListVO> searchSlipCorrectionDetailList(String csrNo) throws EventException {
		try {
			return dbDao.searchSlipCorrectionDetailList(csrNo);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS01420",new String[]{}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01420",new String[]{}).getMessage(), ex);
		}
	}
	
    /**
	 * 수입 채권 차감 분을 작성하기 위한 기 생성 채권을 조회한다<br>
	 * 
	 * @param condReverseCsrForSubletVO CondReverseCsrForSubletVO
	 * @return List<SearchReverseCsrForSubletVOList>
	 * @exception EventException
	 */
	public List<SearchReverseCsrForSubletListVO> searchReverseCsrForSubletList(CondReverseCsrForSubletVO condReverseCsrForSubletVO) throws EventException {
		try {
			condReverseCsrForSubletVO.setEffDt(condReverseCsrForSubletVO.getEffDt().replaceAll("-", ""));
			return dbDao.searchReverseCsrForSubletList(condReverseCsrForSubletVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS01415",new String[]{}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01415",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Slip Correction 에서 Slip Detail 의 Description 를 수정한다<br>
	 * 
	 * @param customCsulSlpVOs CustomCsulSlpVO
	 * @param csrNo String
	 * @param usrId String
	 * @exception EventException 
	 */
	public void modifySlipDetailCorrection(CustomCsulSlpVO[] customCsulSlpVOs, String csrNo, String usrId) throws EventException {
		try {
			List<CustomCsulSlpVO> modifyVoList = new ArrayList<CustomCsulSlpVO>();

			for (int i=0; i<customCsulSlpVOs.length; i++ ) {
				if (customCsulSlpVOs[i].getIbflag().equals("U")){
					customCsulSlpVOs[i].setCsrNo(csrNo);
					customCsulSlpVOs[i].setUpdUsrId(usrId);

					modifyVoList.add(customCsulSlpVOs[i]);
				}
			}

			if (modifyVoList.size() > 0) {
				dbDao.modifySlipDetailCorrection(modifyVoList);
			}

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS01422",new String[]{}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01422",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Center Code / City Code 값을 체크한다<br>
	 * 
	 * @param ctrCd String
	 * @return String
	 * @exception EventException
	 */
	public String checkCenterCode(String ctrCd) throws EventException{
		
		try {
			
			return dbDao.searchCheckCenterCode(ctrCd);

		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01344",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01344",new String[]{}).getMessage(), ex);
		}
		
	}
	
	/**
	 * Bunker Vvd 값을 체크한다<br>
	 * 
	 * @param bunkerVvd String
	 * @return String
	 * @exception EventException
	 */
	public String checkVvdCode(String bunkerVvd) throws EventException{
		
		try {
			
			return dbDao.searchCheckVvdCode(bunkerVvd);

		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01315",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01315",new String[]{}).getMessage(), ex);
		}
		
	}
	
	/**
	 * 수입 채권 차감 분을 작성하기 위한 기 생성 채권을 생성한다<br>
	 * 
	 * @param customConsultationVO CustomConsultationVO
	 * @param customCsulSlpVOs CustomCsulSlpVO[]
	 * @param SignOnUserAccount signOnUserAccount
	 * @return String
	 * @exception EventException
	 */
	public String manageReverseCsrForSublet(CustomConsultationVO customConsultationVO, CustomCsulSlpVO[] customCsulSlpVOs, SignOnUserAccount signOnUserAccount) throws EventException{
		try {
			
			// 전표 생성 번호 저장
			String slpSerNo = dbDao.searchCsulSlpSeq(customConsultationVO.getSlpTpCd(), customConsultationVO.getSlpFuncCd(), customConsultationVO.getSlpOfcCd());
			if (slpSerNo.equals("00001")) {
				dbDao.addCsulSlpSeq (customConsultationVO.getSlpTpCd(), customConsultationVO.getSlpFuncCd(), customConsultationVO.getSlpOfcCd(), slpSerNo, signOnUserAccount.getUsr_id());
			} else {
				dbDao.modifyCsulSlpSeq (customConsultationVO.getSlpTpCd(), customConsultationVO.getSlpFuncCd(), customConsultationVO.getSlpOfcCd(), slpSerNo, signOnUserAccount.getUsr_id());
			}

			customConsultationVO.setSlpSerNo(slpSerNo);
			customConsultationVO.setEffDt(customConsultationVO.getEffDt().replaceAll("-", ""));
			customConsultationVO.setSlpIssDt(customConsultationVO.getSlpIssDt().replaceAll("-", ""));
			customConsultationVO.setRqstAmt(customConsultationVO.getRqstAmt().replaceAll(",", ""));
			customConsultationVO.setCsrAmt(customConsultationVO.getCsrAmt().replaceAll(",", ""));
			customConsultationVO.setCsrUsrId(signOnUserAccount.getUsr_id());
			customConsultationVO.setUpdUsrId(signOnUserAccount.getUsr_id());
			customConsultationVO.setCreUsrId(signOnUserAccount.getUsr_id());
			dbDao.addMasterReverseCsrForSublet(customConsultationVO);
			
			List<CustomCsulSlpVO> addCsulSlpList110811 = new ArrayList<CustomCsulSlpVO>();
			List<CustomCsulSlpVO> addCsulSlpList954112 = new ArrayList<CustomCsulSlpVO>();
			
			int seqNo = 0;
			String slpSeqNo = "";
			
			for ( int i=0; i<customCsulSlpVOs .length; i++ ) {
				if (customCsulSlpVOs[i].getStlFlg().equals("1")) {
					seqNo++;
					if(String.valueOf(seqNo).length() == 1) {
						slpSeqNo = "000" + seqNo;
					} else if(String.valueOf(seqNo).length() == 2) {
						slpSeqNo = "00" + seqNo;
					} else if(String.valueOf(seqNo).length() == 3) {
						slpSeqNo = "0" + seqNo;
					} else {
						slpSeqNo = String.valueOf(seqNo);
					}

					customCsulSlpVOs[i].setSlpSerNo(slpSerNo);
					customCsulSlpVOs[i].setSlpSeqNo(slpSeqNo);
					customCsulSlpVOs[i].setSlpOfcCd(customConsultationVO.getSlpOfcCd());
					customCsulSlpVOs[i].setSlpIssDt(customConsultationVO.getSlpIssDt().replaceAll("-", ""));
					customCsulSlpVOs[i].setVvdEffDt(customCsulSlpVOs[i].getVvdEffDt().replaceAll("-", ""));
					customCsulSlpVOs[i].setVvdExpDt(customCsulSlpVOs[i].getVvdExpDt().replaceAll("-", ""));
					customCsulSlpVOs[i].setTrnsCurrCd(customCsulSlpVOs[i].getCsrCurrCd());
					customCsulSlpVOs[i].setTrnsAmt(customCsulSlpVOs[i].getCsrAmt());
					customCsulSlpVOs[i].setFletSrcTpCd("R1");
					customCsulSlpVOs[i].setUpdUsrId(signOnUserAccount.getUsr_id());
					customCsulSlpVOs[i].setCreUsrId(signOnUserAccount.getUsr_id());
					addCsulSlpList110811.add(customCsulSlpVOs[i]);
				}
			}
			
			if ( addCsulSlpList110811.size() > 0 ) {
				dbDao.addReverseCsrForSubletSlips(addCsulSlpList110811);
			}

			for ( int i=0; i<customCsulSlpVOs .length; i++ ) {
				if (customCsulSlpVOs[i].getStlFlg().equals("1")) {
					seqNo++;
					if(String.valueOf(seqNo).length() == 1) {
						slpSeqNo = "000" + seqNo;
					} else if(String.valueOf(seqNo).length() == 2) {
						slpSeqNo = "00" + seqNo;
					} else if(String.valueOf(seqNo).length() == 3) {
						slpSeqNo = "0" + seqNo;
					} else {
						slpSeqNo = String.valueOf(seqNo);
					}

					customCsulSlpVOs[i].setSlpSerNo(slpSerNo);
					customCsulSlpVOs[i].setSlpSeqNo(slpSeqNo);
					customCsulSlpVOs[i].setSlpOfcCd(customConsultationVO.getSlpOfcCd());
					customCsulSlpVOs[i].setSlpIssDt(customConsultationVO.getSlpIssDt().replaceAll("-", ""));
					customCsulSlpVOs[i].setVvdEffDt(customCsulSlpVOs[i].getVvdEffDt().replaceAll("-", ""));
					customCsulSlpVOs[i].setVvdExpDt(customCsulSlpVOs[i].getVvdExpDt().replaceAll("-", ""));
					customCsulSlpVOs[i].setTrnsCurrCd(customCsulSlpVOs[i].getCsrCurrCd());
					customCsulSlpVOs[i].setTrnsAmt(customCsulSlpVOs[i].getCsrAmt());
					customCsulSlpVOs[i].setAcctCd("954112");
					customCsulSlpVOs[i].setFletSrcTpCd("R6");
					customCsulSlpVOs[i].setUpdUsrId(signOnUserAccount.getUsr_id());
					customCsulSlpVOs[i].setCreUsrId(signOnUserAccount.getUsr_id());
					addCsulSlpList954112.add(customCsulSlpVOs[i]);
				}
			}

			if ( addCsulSlpList954112.size() > 0 ) {
				dbDao.addReverseCsrForSubletSlips(addCsulSlpList954112);
			}

			/***************************
			 * 결재라인 지정
			 ***************************/
			customConsultationVO.setMaxRows(customConsultationVO.getMaxRows()); //결재라인의 count를 위해
			this.createCSREPApproval(customConsultationVO, signOnUserAccount);
			
			return slpSerNo;

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS01415",new String[]{}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01415",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * 수입 채권 차감 분을 작성하기 위한 기 생성 채권을 Invoice 조건으로 조회한다<br>
	 * 
	 * @param customCsulSlpSeqVO CustomCsulSlpSeqVO
	 * @return List<SearchReverseCsrForSubletSaveListVO>
	 * @exception EventException
	 */
	public List<SearchReverseCsrForSubletSaveListVO> searchReverseCsrForSubletSaveList(CustomCsulSlpSeqVO customCsulSlpSeqVO) throws EventException {
		try {
			customCsulSlpSeqVO.setSlpIssDt(customCsulSlpSeqVO.getSlpIssDt().replaceAll("-", ""));
			return dbDao.searchReverseCsrForSubletSaveList(customCsulSlpSeqVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS01415",new String[]{}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01415",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * 용선인 경우 전표가 승인되면 ERP A/P 로 전송된다
	 * 대선인 경우 전표가 승인되면 ERP A/R 로 전송된다<br>
	 * 
	 * @param fletCtrtTpCd String
	 * @param csrNo String
	 * @param aproFlg String
	 * @param cxlDesc String
	 * @param usrId String
	 * @param interCoCd String
	 * @param arInterCoCd String
	 * @param aproFlgUpdateYn String
	 * @param ofcCd String
	 * @param String slipAproFlg
	 * @param String asaNo
	 * @return List<SearchArSlipDetailListVO> searchArSlipDetailListVO
	 * @exception EventException
	 */
	public List<SearchArSlipDetailListVO> manageSlipApproval(String fletCtrtTpCd, String csrNo, String aproFlg, String cxlDesc, String usrId, String interCoCd, String arInterCoCd, String aproFlgUpdateYn, String ofcCd, String slipAproFlg, String asaNo) throws EventException {
		try {						
			log.debug("### manageSlipApproval ###");			
			log.debug("fletCtrtTpCd = "+fletCtrtTpCd);
			log.debug("csrNo = "+csrNo);
			log.debug("aproFlg = "+aproFlg);
			log.debug("cxlDesc = "+cxlDesc);			
			log.debug("usrId = "+usrId);
			log.debug("interCoCd = "+interCoCd);
			log.debug("arInterCoCd = "+arInterCoCd);
			log.debug("aproFlgUpdateYn = "+aproFlgUpdateYn);
			log.debug("ofcCd = "+ofcCd);
			log.debug("slipAproFlg = "+slipAproFlg);
			log.debug("asaNo = "+asaNo);
			
			
			List<SearchArSlipDetailListVO> searchArSlipDetailListVO = null;
			
			String itemKind = "H";
			
			if (interCoCd.equals("")) {
				interCoCd = "00";
			}

			if (arInterCoCd.equals("")) {
				arInterCoCd = "00";
			}
			
			if (aproFlg.equals("Y")) {
				if (slipAproFlg.equals("Y")) {  // G/W 결재 전표가 아닌 경우
					SearchSlipApprovalCsrVO searchSlipApprovalCsrVO = null;
					searchSlipApprovalCsrVO = dbDao.searchAproRqstNo(csrNo, usrId); // usrId가 최종결재권자 인지 확인
					
					if (searchSlipApprovalCsrVO != null) {
						searchSlipApprovalCsrVO.setUpdUsrId(usrId);
						searchSlipApprovalCsrVO.setAproFlg(aproFlg);
						searchSlipApprovalCsrVO.setCxlDesc(cxlDesc);
						log.debug("\r\nSSSSS");
						dbDao.modifyComAproRqstRout(searchSlipApprovalCsrVO);
						dbDao.modifyComAproRqstHdr (searchSlipApprovalCsrVO);		
						log.debug("\r\nEEEEE");
						// 승인인경우 최종 결재권자가 아니면 approval step process 만 처리한다.
						if (!"Y".equals(searchSlipApprovalCsrVO.getLstAproFlg())){								
							return null;
						}
				   }
				}	
				
			  if (fletCtrtTpCd.equals("TI") || fletCtrtTpCd.equals("OW") || fletCtrtTpCd.equals("")
			  || (fletCtrtTpCd.equals("TO") && csrNo.substring(0,2).equals("07"))) {	//AP
			    //#############################################################################
					// ERP AP 전체 처리 메소드
					manageApSlipApproval(csrNo, csrNo, usrId, interCoCd, arInterCoCd, aproFlgUpdateYn, slipAproFlg, asaNo);
						
					List<SearchApVatSlipListVO> searchApVatSlipListVO = dbDao.searchApVatSlipList ( csrNo );
					
					for (int i=0; i<searchApVatSlipListVO.size(); i++) {
						manageApSlipApproval(searchApVatSlipListVO.get(i).getSlpTpCd() +
								searchApVatSlipListVO.get(i).getSlpFuncCd() +
								searchApVatSlipListVO.get(i).getSlpOfcCd() +
								searchApVatSlipListVO.get(i).getSlpIssDt() +
								searchApVatSlipListVO.get(i).getSlpSerNo() , csrNo, usrId, interCoCd, arInterCoCd, aproFlgUpdateYn, slipAproFlg, asaNo);
					}
					
					if (slipAproFlg.equals("N")) {  // G/W 결재 전표
						// 최종결재자가 승인 할 경우는 RQST_APRO_FLG를 'Y'로 세팅하면 안 된다.(201411 민정호)
						if(!"Y2".equals(aproFlgUpdateYn)){					
							//CSR생성 후 Approval Request 하기 위한 단계로 업데이트
							ApprovalUtil aproUtil = new ApprovalUtil();  
							aproUtil.updateAproGwFlg(csrNo, ofcCd);
						}
					}
					
					//KKKK 작업  Payments Slip 관련 전표 최종 결재 Settlement Status Code = 'ST' (OA 차감 및 Refund)
					//FMS approval 기능에서 누락되는 경우 발생하여 Y 조건 추가 2017.04.13
					if("Y2".equals(aproFlgUpdateYn) || "Y".equals(aproFlgUpdateYn)) {
						List<SearchApSlipDetailListVO> searchApSlipDetailListVO = dbDao.searchApSlipDetailList(csrNo);
						log.debug("\r\nOA searchApSlipDetailListVO.size() : " + searchApSlipDetailListVO.size());
						int listSize = searchApSlipDetailListVO.size();
						for (int i=0; i<listSize; i++) {
							String oaCsr = searchApSlipDetailListVO.get(i).getOaCsr();
							if (!"N".equals(oaCsr)) {	
								dbDao.modifyOwnrAcctSlp2(oaCsr, "ST");
							}
						}
					}
					
					// 951111 2건 & 111071 1건 생성
					if("Y3".equals(aproFlgUpdateYn)) {
						log.debug("### 환대체 전표 생성 ###");
						
						OwnersAccountBC command = new OwnersAccountBCImpl();
						FmsConsultationVO fmsConsultationVO = command.searchOwnersAccountConsultation(csrNo, "");						
						List<FmsCsulSlpVO> fmsCsulSlpVOs = command.searchOwnersAccountCsulSlps(csrNo, "");
						
						// 원전표에 대한 환대체 전표 951111 생성하고 111071 계정 데이터 생성
						command.manageOwnersAccountExchangeSlip(fmsConsultationVO, fmsCsulSlpVOs, usrId, ofcCd, "N");

						
					}
				    //##############################################################################					
				} else {//AR
					if (slipAproFlg.equals("Y")) {  // G/W 결재 전표가 아닌 경우
						SearchSlipApprovalCsrVO searchSlipApprovalCsrVO = null;
						searchSlipApprovalCsrVO = dbDao.searchAproRqstNo(csrNo, usrId);
						
						if (searchSlipApprovalCsrVO != null) {
							searchSlipApprovalCsrVO.setUpdUsrId(usrId);
							searchSlipApprovalCsrVO.setAproFlg(aproFlg);
							searchSlipApprovalCsrVO.setCxlDesc(cxlDesc);
							
							dbDao.modifyComAproRqstRout(searchSlipApprovalCsrVO);
							dbDao.modifyComAproRqstHdr (searchSlipApprovalCsrVO);		
		
							// 승인인경우 최종 결재권자가 아니면 approval step process 만 처리한다.
							if (!"Y".equals(searchSlipApprovalCsrVO.getLstAproFlg())){								
								return null;
							}
					   }
					}	

					//AR 전표 Detail 계정 항목들을 조회한다
					if (fletCtrtTpCd.equals("RV")) {//Reverse (FMS_INV_DTL 조회)
						searchArSlipDetailListVO = dbDao.searchArRvsSlipDetailList(csrNo);
					} else {// (FMS_CSUL_SLP 조회)
						//AR 전표 중 Hire Revenue 에 해당되는 경우
						searchArSlipDetailListVO = dbDao.searchArSlipDetailList(csrNo);
						
						//AR 전표 중 Bunker 에 해당되는 경우
						if(searchArSlipDetailListVO == null || searchArSlipDetailListVO.size() == 0) {
							itemKind = "B";
							
							searchArSlipDetailListVO = dbDao.searchArBunkerSlipDetailList(csrNo);
						}
						
						if (fletCtrtTpCd.equals("AR")) { //O/A, OUTLAY COMM
							itemKind = "H";
						}
					}
					
					// AR인경우 바로 EAI 실행					
					//======================================================================================================										
					
					int listSize = searchArSlipDetailListVO.size();
					if (listSize > 0) {
						
						//회계일자 검사한다
						String effDt = dbDao.searchCheckEffectiveDate2(searchArSlipDetailListVO.get(0).getSlpOfcCd(), searchArSlipDetailListVO.get(0).getEffDt());
						if (effDt.equals("")) {
							throw new EventException(new ErrorHandler("FMS01556",new String[]{}).getMessage());
						}
						
						//AR Header 테이블에 생성된다
						List<CustomArSlipApprovalHeaderVO> insertHdrVoList = new ArrayList<CustomArSlipApprovalHeaderVO>();
						
						//AR Detail 테이블에 생성된다
						List<CustomArSlipApprovalDetailVO> insertDtlVoList = new ArrayList<CustomArSlipApprovalDetailVO>();
						
						//재무항차 검사
						for (int i=0; i<listSize; i++) {
							if (!searchArSlipDetailListVO.get(i).getVslCd().equals("")) {
								String vslCd = dbDao.searchCheckMdmVvdCode(searchArSlipDetailListVO.get(i).getVslCd()+ 
										searchArSlipDetailListVO.get(i).getSkdVoyNo()+
										searchArSlipDetailListVO.get(i).getSkdDirCd()+
										searchArSlipDetailListVO.get(i).getRevDirCd());
	
								if (vslCd.equals("")) {
									throw new EventException(new ErrorHandler("FMS01558",new String[]{}).getMessage());
								}
							}

							//AR Header 테이블에 생성된다
							CustomArSlipApprovalHeaderVO customArSlipApprovalHeaderVO = new CustomArSlipApprovalHeaderVO();
							customArSlipApprovalHeaderVO.setArIfNo(searchArSlipDetailListVO.get(i).getToIfNo());
							customArSlipApprovalHeaderVO.setArIfSerNo("1");
							customArSlipApprovalHeaderVO.setBlNo(searchArSlipDetailListVO.get(i).getBlNo());
							customArSlipApprovalHeaderVO.setArSrcCd("CDAM");
							customArSlipApprovalHeaderVO.setInvNo(searchArSlipDetailListVO.get(i).getInvNo());

							if (i==0) {
								//Customer 검사한다
								List<SearchSlipApprovalOwnerVO> searchSlipApprovalOwnerVO = dbDao.searchSlipApprovalOwner("", searchArSlipDetailListVO.get(i).getCustCntCd(), searchArSlipDetailListVO.get(i).getCustSeq());
								if (searchSlipApprovalOwnerVO.size() == 0) {
									throw new EventException(new ErrorHandler("FMS01346",new String[]{}).getMessage());
								}
							}

							//Slip Approval 승인 시에 Office 및 User 테이블에서 필요 항목 조회한다
//							List<SearchSlipApprovalOfficeVO> searchSlipApprovalOfficeVO = dbDao.searchSlipApprovalOffice(usrId);							
							List<SearchSlipApprovalOfficeVO> searchSlipApprovalOfficeVO = dbDao.searchSlipArApprovalOffice (csrNo);
							
							
							if (searchSlipApprovalOfficeVO.size() > 0) {
								customArSlipApprovalHeaderVO.setRhqCd(searchSlipApprovalOfficeVO.get(0).getArHdQtrOfcCd());
								customArSlipApprovalHeaderVO.setInvCoaRgnCd(searchSlipApprovalOfficeVO.get(0).getFincRgnCd());
								customArSlipApprovalHeaderVO.setInvCoaCtrCd(searchSlipApprovalOfficeVO.get(0).getApCtrCd());
							}

							customArSlipApprovalHeaderVO.setArOfcCd(searchArSlipDetailListVO.get(i).getSlpOfcCd());
							customArSlipApprovalHeaderVO.setActCustCntCd(searchArSlipDetailListVO.get(i).getCustCntCd());
							customArSlipApprovalHeaderVO.setActCustSeq(searchArSlipDetailListVO.get(i).getCustSeq());
							customArSlipApprovalHeaderVO.setInvCustCntCd(searchArSlipDetailListVO.get(i).getCustCntCd());
							customArSlipApprovalHeaderVO.setInvCustSeq(searchArSlipDetailListVO.get(i).getCustSeq());
							customArSlipApprovalHeaderVO.setVslCd(searchArSlipDetailListVO.get(i).getVslCd());
							customArSlipApprovalHeaderVO.setSkdVoyNo(searchArSlipDetailListVO.get(i).getSkdVoyNo());
							customArSlipApprovalHeaderVO.setSkdDirCd(searchArSlipDetailListVO.get(i).getSkdDirCd());
							customArSlipApprovalHeaderVO.setTrnkVslCd(searchArSlipDetailListVO.get(i).getVslCd());
							customArSlipApprovalHeaderVO.setTrnkSkdVoyNo(searchArSlipDetailListVO.get(i).getSkdVoyNo());
							customArSlipApprovalHeaderVO.setTrnkSkdDirCd(searchArSlipDetailListVO.get(i).getSkdDirCd());
							customArSlipApprovalHeaderVO.setRevVslCd(searchArSlipDetailListVO.get(i).getVslCd());
							customArSlipApprovalHeaderVO.setRevSkdVoyNo(searchArSlipDetailListVO.get(i).getSkdVoyNo());
							customArSlipApprovalHeaderVO.setRevSkdDirCd(searchArSlipDetailListVO.get(i).getSkdDirCd());
							customArSlipApprovalHeaderVO.setRevDirCd(searchArSlipDetailListVO.get(i).getRevDirCd());
							customArSlipApprovalHeaderVO.setSailArrDt(searchArSlipDetailListVO.get(i).getEffDt());
							customArSlipApprovalHeaderVO.setPorCd(searchArSlipDetailListVO.get(i).getSlpLocCd());
							customArSlipApprovalHeaderVO.setPolCd(searchArSlipDetailListVO.get(i).getSlpLocCd());
							customArSlipApprovalHeaderVO.setPodCd(searchArSlipDetailListVO.get(i).getSlpLocCd());
							customArSlipApprovalHeaderVO.setDelCd(searchArSlipDetailListVO.get(i).getSlpLocCd());
							customArSlipApprovalHeaderVO.setSlanCd("CDM");
							customArSlipApprovalHeaderVO.setIoBndCd("O");
							customArSlipApprovalHeaderVO.setCustCrFlg("Y");
							customArSlipApprovalHeaderVO.setDueDt(searchArSlipDetailListVO.get(i).getDueDt());
							customArSlipApprovalHeaderVO.setUsdAmt(searchArSlipDetailListVO.get(i).getInvAmt());
							customArSlipApprovalHeaderVO.setLoclAmt("0");
							customArSlipApprovalHeaderVO.setRlaneCd("CDMCO");
							customArSlipApprovalHeaderVO.setZnIocCd("OO");
							customArSlipApprovalHeaderVO.setInvCtrtNo(searchArSlipDetailListVO.get(i).getFletCtrtNo());
							customArSlipApprovalHeaderVO.setCrTermDys("30");
							customArSlipApprovalHeaderVO.setSailDt(searchArSlipDetailListVO.get(i).getEffDt());
							customArSlipApprovalHeaderVO.setXchRtTpCd("A");
							customArSlipApprovalHeaderVO.setArTaxIndCd("0");
							customArSlipApprovalHeaderVO.setSlsOfcCd(searchArSlipDetailListVO.get(i).getSlpOfcCd());
							customArSlipApprovalHeaderVO.setInvRmk(searchArSlipDetailListVO.get(i).getInvDesc());
							customArSlipApprovalHeaderVO.setInvRmkEnc(searchArSlipDetailListVO.get(i).getInvDescEnc());
							customArSlipApprovalHeaderVO.setInvCoaCoCd("01");
							customArSlipApprovalHeaderVO.setInvCoaAcctCd("110811");
														
							//2012-02-14 하드코딩 제거 -> 화면에서 조회한 파라미터 값으로 셋팅
							//customArSlipApprovalHeaderVO.setInvCoaInterCoCd("00");
							customArSlipApprovalHeaderVO.setInvCoaInterCoCd(arInterCoCd);
							
							customArSlipApprovalHeaderVO.setInvCoaVslCd("0000");
							customArSlipApprovalHeaderVO.setInvCoaVoyNo("0000");
							customArSlipApprovalHeaderVO.setInvCoaSkdDirCd("0");
							customArSlipApprovalHeaderVO.setInvCoaRevDirCd("0");
							customArSlipApprovalHeaderVO.setGlDt(searchArSlipDetailListVO.get(i).getEffDt());
							customArSlipApprovalHeaderVO.setTaxXchRt("0");
							customArSlipApprovalHeaderVO.setArCtyCd(searchArSlipDetailListVO.get(i).getSlpLocCd());
							customArSlipApprovalHeaderVO.setCurrCd(searchArSlipDetailListVO.get(i).getCurrCd());
							customArSlipApprovalHeaderVO.setUsrId(usrId);
							customArSlipApprovalHeaderVO.setLogUpdDt((new SimpleDateFormat("yyyyMMddHHmmss")).format(new Date()));
							customArSlipApprovalHeaderVO.setIssDt((new SimpleDateFormat("yyyyMMdd")).format(new Date()));
							customArSlipApprovalHeaderVO.setSlpNo(searchArSlipDetailListVO.get(i).getSlpTpCd()+
									searchArSlipDetailListVO.get(i).getSlpFuncCd() +
									searchArSlipDetailListVO.get(i).getSlpOfcCd() +
									searchArSlipDetailListVO.get(i).getSlpIssDt() +
									searchArSlipDetailListVO.get(i).getSlpSerNo());

							customArSlipApprovalHeaderVO.setCreUsrId(usrId);

							insertHdrVoList.add(customArSlipApprovalHeaderVO);

							//Detail
							CustomArSlipApprovalDetailVO customArSlipApprovalDetailVO = new CustomArSlipApprovalDetailVO();
							customArSlipApprovalDetailVO.setArIfNo(searchArSlipDetailListVO.get(i).getToIfNo());
							customArSlipApprovalDetailVO.setArIfSerNo("1");
							customArSlipApprovalDetailVO.setChgSeq("1");
							
							if (fletCtrtTpCd.equals("AR")) {  // O/A, OUTLAY COMM
								
								if (searchArSlipDetailListVO.get(i).getChk().equals("N")) {
									if (Float.parseFloat(searchArSlipDetailListVO.get(i).getInvAmt()) >= 0) { 
										customArSlipApprovalDetailVO.setChgCd("OTH");
									}
									else {
										customArSlipApprovalDetailVO.setChgCd("XXX");
									}
								}
								else {
									if (Float.parseFloat(searchArSlipDetailListVO.get(i).getInvAmt()) >= 0) { 
										customArSlipApprovalDetailVO.setChgCd("XXX");
									}
									else {
										customArSlipApprovalDetailVO.setChgCd("OTH");
									}
								}
							}
							else {
								customArSlipApprovalDetailVO.setChgCd("CDM");
							}
							
							customArSlipApprovalDetailVO.setRepChgCd("ERP");
							customArSlipApprovalDetailVO.setChgAmt(searchArSlipDetailListVO.get(i).getInvAmt());
							customArSlipApprovalDetailVO.setTrfRtAmt(searchArSlipDetailListVO.get(i).getInvAmt());
							customArSlipApprovalDetailVO.setRatAsCntrQty("1");
							customArSlipApprovalDetailVO.setSobId("1");
							
							if (fletCtrtTpCd.equals("AR")) { // O/A, OUTLAY COMM
								if (searchArSlipDetailListVO.get(i).getChk().equals("N")) {
									if (Float.parseFloat(searchArSlipDetailListVO.get(i).getInvAmt()) >= 0) { 
										customArSlipApprovalDetailVO.setChgFullNm("MIS. REVENUE(CNTR) - OTHER");
									}
									else {
										customArSlipApprovalDetailVO.setChgFullNm("LEGACY SYSTEM CLEARING");
									}
							    }
								else {
									if (Float.parseFloat(searchArSlipDetailListVO.get(i).getInvAmt()) >= 0) { 
										customArSlipApprovalDetailVO.setChgFullNm("LEGACY SYSTEM CLEARING");
									}
									else {
										customArSlipApprovalDetailVO.setChgFullNm("MIS. REVENUE(CNTR) - OTHER");
									}
								}
							}
							else {
								customArSlipApprovalDetailVO.setChgFullNm("Charterage - Container");
							}
							
							customArSlipApprovalDetailVO.setCurrCd(searchArSlipDetailListVO.get(i).getCurrCd());
							customArSlipApprovalDetailVO.setTaxAmt("0");
							customArSlipApprovalDetailVO.setRevCoaCoCd("01");
							customArSlipApprovalDetailVO.setRevCoaRgnCd(searchSlipApprovalOfficeVO.get(0).getFincRgnCd());
							customArSlipApprovalDetailVO.setRevCoaCtrCd(searchSlipApprovalOfficeVO.get(0).getApCtrCd());
							
							if(itemKind.equals("H")) {								
								if (fletCtrtTpCd.equals("AR")) { // O/A, OUTLAY COMM
									if (searchArSlipDetailListVO.get(i).getChk().equals("N")) {
										if (Float.parseFloat(searchArSlipDetailListVO.get(i).getInvAmt()) >= 0) { 
											customArSlipApprovalDetailVO.setRevCoaAcctCd("954112");
										}
										else {
											customArSlipApprovalDetailVO.setRevCoaAcctCd("954113");
								 			}
									}	
									else {
										if (Float.parseFloat(searchArSlipDetailListVO.get(i).getInvAmt()) >= 0) { 
											customArSlipApprovalDetailVO.setRevCoaAcctCd("954113");
										}
										else {
											customArSlipApprovalDetailVO.setRevCoaAcctCd("954112");
										}
									}
								}
								
								else {
									customArSlipApprovalDetailVO.setRevCoaAcctCd("954112");
								}
							} else {
								customArSlipApprovalDetailVO.setRevCoaAcctCd("954111");
							}
    
							//2012-02-14 하드코딩 제거 -> 화면에서 조회한 파라미터 값으로 셋팅
							//customArSlipApprovalDetailVO.setRevCoaInterCoCd("00");
							customArSlipApprovalDetailVO.setRevCoaInterCoCd(arInterCoCd);
							
							customArSlipApprovalDetailVO.setRevCoaVslCd("0000");
							customArSlipApprovalDetailVO.setRevCoaVoyNo("0000");
							customArSlipApprovalDetailVO.setRevCoaSkdDirCd("0");
							customArSlipApprovalDetailVO.setRevCoaDirCd("0");
							
							if (fletCtrtTpCd.equals("AR")) { // O/A, OUTLAY COMM
								if (searchArSlipDetailListVO.get(i).getChk().equals("N")) {
									if (Float.parseFloat(searchArSlipDetailListVO.get(i).getInvAmt()) >= 0) { 
										customArSlipApprovalDetailVO.setAcctCd("411915");
									}
									else {
										customArSlipApprovalDetailVO.setAcctCd("");
									}
								}
								else {
									if (Float.parseFloat(searchArSlipDetailListVO.get(i).getInvAmt()) >= 0) { 
										customArSlipApprovalDetailVO.setAcctCd("");
									}
									else {
										customArSlipApprovalDetailVO.setAcctCd("411915");
									}
								}
							}
							else {
								customArSlipApprovalDetailVO.setAcctCd("411211");
							}
							
							customArSlipApprovalDetailVO.setJoRevTpCd("CDM");
							customArSlipApprovalDetailVO.setCreUsrId(usrId);

							insertDtlVoList.add(customArSlipApprovalDetailVO);
						
							//FMS_INV_DTL에 IF NO 수정하기 위해 필요
							searchArSlipDetailListVO.get(i).setUpdUsrId(usrId);
							
						}
						//========================================================================================						
						if (slipAproFlg.equals("N")) {  // AR 전표는 G/W 결재 하지 않음
							//2014.12. 민정호(AR경우 G/W에서 결재)
							// 최종 결재 인 경우, JOO_AR_MN저장
							if("Y2".equals(aproFlgUpdateYn)){							
								//AR인 경우만 실행
								if (insertHdrVoList.size() > 0) {
									dbDao.addArSlipApprovalHeader(insertHdrVoList);
								}
		
								//AR인 경우만 실행						
								if (insertDtlVoList.size() > 0) {
									dbDao.addArSlipApprovalDetails(insertDtlVoList);
								}
								
								//AR인 경우만 실행						
								if (insertHdrVoList.size() > 0) {
									//Send AR Invoice
									eaiDao.sendSlipApprovalToAR(csrNo, insertHdrVoList, insertDtlVoList);
								}							
							}else{
								ArApprovalBC arApprovalBC = new ArApprovalBCImpl();														
								//CSR생성 후 Approval Request 하기 위한 단계로 업데이트  
								arApprovalBC.updateAproGwFlg(csrNo, ofcCd);							
					        }
						} else {
						   //AR인 경우만 실행
							if (insertHdrVoList.size() > 0) {
								dbDao.addArSlipApprovalHeader(insertHdrVoList);
							}
	
							//AR인 경우만 실행						
							if (insertDtlVoList.size() > 0) {
								dbDao.addArSlipApprovalDetails(insertDtlVoList);
							}
							
							//AR인 경우만 실행						
							if (insertHdrVoList.size() > 0) {
								//Send AR Invoice
								eaiDao.sendSlipApprovalToAR(csrNo, insertHdrVoList, insertDtlVoList);
							}							
						}	
						
						if (slipAproFlg.equals("N")) {  // AR 전표는 G/W 결재 하지 않음
							if("Y".equals(aproFlgUpdateYn) || "Y2".equals(aproFlgUpdateYn)
									){
								//해당 전표의 Apro_flg = 'Y'로 업데이트한다.
								dbDao.modifySlipApprovalConsultation (csrNo ,usrId );
							}
						}	
						
						//해당 전표의 Apro_flg = 'Y'로 업데이트한다.
						dbDao.modifySlipApprovalConsultation (csrNo ,usrId );
					}
					
				}

			//Cancel
			} else {
				
				//disapproval 시 rqst 상태변경 로직 추가 2017.04.13
				if (slipAproFlg.equals("Y")) {  // G/W 결재 전표가 아닌 경우
					SearchSlipApprovalCsrVO searchSlipApprovalCsrVO = null;
					searchSlipApprovalCsrVO = dbDao.searchAproRqstNo(csrNo, usrId); // usrId가 최종결재권자 인지 확인
					
					if (searchSlipApprovalCsrVO != null) {
						searchSlipApprovalCsrVO.setUpdUsrId(usrId);
						searchSlipApprovalCsrVO.setAproFlg(aproFlg);
						searchSlipApprovalCsrVO.setCxlDesc(cxlDesc);
						
						dbDao.modifyComAproRqstRout(searchSlipApprovalCsrVO);
						dbDao.modifyComAproRqstHdr (searchSlipApprovalCsrVO);		
						
				   }
				}	
				
				//취소 시 Consultation 에 취소 변경한다
				dbDao.modifySlipApprovalCancelConsultation(csrNo, cxlDesc, usrId);
				
				if (fletCtrtTpCd.equals("TI")
					|| (fletCtrtTpCd.equals("TO") && csrNo.substring(0,2).equals("07"))) {//AP
					
					//취소 시 원전표의 Consultation 에 취소 변경한다
					dbDao.modifySlipApprovalCancelOrginConsultation(csrNo, usrId);
				}
				/*
				// 962111 취소전표 1건 & 951111 2건 & 111071 1건 생성
				if("Y3".equals(aproFlgUpdateYn)) {
					OwnersAccountBC command = new OwnersAccountBCImpl();
					FmsConsultationVO fmsConsultationVO = command.searchOwnersAccountConsultation(csrNo);						
					List<FmsCsulSlpVO> fmsCsulSlpVOs = command.searchOwnersAccountCsulSlps(csrNo);

					log.debug("### 취소전표 & 환대체 전표 생성 ###");
					// 원전표에 대한 취소전표 C 환대체 전표 951111 생성하고 111071 계정 데이터 생성
					command.manageOwnersAccountExchangeSlip(fmsConsultationVO, fmsCsulSlpVOs, usrId, ofcCd, "Y");

					
				}
				*/
			}

			return searchArSlipDetailListVO;

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
	 * 용선인 경우 전표가 승인되면 ERP A/P 로 전송된다
	 * 
	 * @param csrNo String
	 * @param orgCsrNo String
	 * @param usrId String
	 * @param interCoCd String
	 * @param aproFlgUpdateYn String
	 * @param asaNo String
	 * @exception EventException
	 */
	private void manageApSlipApproval(String csrNo, String orgCsrNo, String usrId, String interCoCd, String arInterCoCd, String aproFlgUpdateYn, String slipAproFlg, String asaNo) throws EventException {
		try {
			log.debug("### manageApSlipApproval");
			log.debug("csrNo = "+csrNo);
			log.debug("orgCsrNo = "+orgCsrNo);
			log.debug("usrId = "+usrId);
			log.debug("interCoCd = "+interCoCd);			
			log.debug("arInterCoCd = "+arInterCoCd);
			log.debug("aproFlgUpdateYn = "+aproFlgUpdateYn);
			log.debug("slipAproFlg = "+slipAproFlg);
			log.debug("asaNo = "+asaNo);	
			
			
			log.debug("PPPPPP aproFlgUpdateYn = "+aproFlgUpdateYn);	
			
			
			//AP 전표 Detail 계정 항목들을 조회한다
			List<SearchApSlipDetailListVO> searchApSlipDetailListVO = dbDao.searchApSlipDetailList(csrNo);
			
			log.debug("\r\nsearchApSlipDetailListVO.size() : " + searchApSlipDetailListVO.size());
			
			List<SearchSlipApprovalTaxVO> searchSlipApprovalTaxVO = null;			
			
			int listSize = searchApSlipDetailListVO.size();
			if (listSize > 0) {
				
				//회계일자 검사한다
				String effDt = dbDao.searchCheckEffectiveDate(searchApSlipDetailListVO.get(0).getSlpOfcCd(), searchApSlipDetailListVO.get(0).getEffDt());
				if (effDt.equals("")) {
					//throw new EventException(new ErrorHandler("FMS01556",new String[]{}).getMessage());
					this.approvalRequestAccount2(csrNo);
				}
				
				String taxYn = "N";

				for (int i=0; i<listSize; i++) {
					//재무항차 검사 
					if (!searchApSlipDetailListVO.get(i).getVslCd().equals("")) {
						String vslCd = dbDao.searchCheckMdmVvdCode(searchApSlipDetailListVO.get(i).getVslCd()+ 
								searchApSlipDetailListVO.get(i).getSkdVoyNo()+
								searchApSlipDetailListVO.get(i).getSkdDirCd()+
								searchApSlipDetailListVO.get(i).getRevDirCd());

						//if (vslCd.equals("")) {
						if ("".equals(vslCd)) {	
							throw new EventException(new ErrorHandler("FMS01558",new String[]{}).getMessage());
						}
					}
					
					//계정 코드가 111811인 경우만 세금 정보 넣음
					if (searchApSlipDetailListVO.get(i).getAcctCd().equals("111811")) {
						taxYn = "Y";
					}								
				}

				//Vendor 검사한다
				List<SearchSlipApprovalOwnerVO> searchSlipApprovalOwnerVO = dbDao.searchSlipApprovalOwner(searchApSlipDetailListVO.get(0).getVndrSeq(), searchApSlipDetailListVO.get(0).getCustCntCd(), searchApSlipDetailListVO.get(0).getCustSeq());
				
				if (searchSlipApprovalOwnerVO.size() == 0) {
					throw new EventException(new ErrorHandler("FMS01345",new String[]{}).getMessage());
				}
				
				//AP Header(AP_INV_HDR) 테이블에 넣을 VO를 생성한다
				String evidTpCd = searchApSlipDetailListVO.get(0).getEvidTpCd();
				CustomSlipApprovalHeaderVO customSlipApprovalHeaderVO = new CustomSlipApprovalHeaderVO();

				//Slip Approval 승인 시에 Office 및 User 테이블에서 필요 항목 조회한다
//				List<SearchSlipApprovalOfficeVO> searchSlipApprovalOfficeVO = dbDao.searchSlipApprovalOffice(csrNo);
				List<SearchSlipApprovalOfficeVO> searchSlipApprovalOfficeVO = dbDao.searchSlipArApprovalOffice(csrNo);


					
				if (searchSlipApprovalOfficeVO.size() > 0) {
					customSlipApprovalHeaderVO.setAttrCtnt10(searchSlipApprovalOfficeVO.get(0).getUsrNm());
					customSlipApprovalHeaderVO.setUsrEml(searchSlipApprovalOfficeVO.get(0).getUsrEml());
				}
				
				customSlipApprovalHeaderVO.setCsrNo(csrNo);
				customSlipApprovalHeaderVO.setPayMzdLuCd("WIRE");
				customSlipApprovalHeaderVO.setPayGrpLuCd("대내지불");
				if (searchApSlipDetailListVO.get(0).getSlpFuncCd().equals("P")) {
					customSlipApprovalHeaderVO.setCsrTpCd("PREPAYMENT");
					customSlipApprovalHeaderVO.setInvTermDt(searchApSlipDetailListVO.get(0).getRqstDt());
					customSlipApprovalHeaderVO.setVndrTermNm("0");
					customSlipApprovalHeaderVO.setPpayAplyFlg("Y");
				} else {
					if (searchApSlipDetailListVO.get(0).getSlpFuncCd().equals("S")) {
						customSlipApprovalHeaderVO.setCsrTpCd("STANDARD");
					} else {
						customSlipApprovalHeaderVO.setCsrTpCd("CREDIT");
					}
					customSlipApprovalHeaderVO.setInvTermDt(searchApSlipDetailListVO.get(0).getEffDt());
					customSlipApprovalHeaderVO.setVndrTermNm(searchSlipApprovalOwnerVO.get(0).getGenPayTermCd());
					if (searchApSlipDetailListVO.get(0).getRqstAmt().equals("0")) {
						customSlipApprovalHeaderVO.setPayGrpLuCd("ZERO PAYMENT");
					}
					customSlipApprovalHeaderVO.setPpayAplyFlg("N");
				}
				customSlipApprovalHeaderVO.setGlDt(searchApSlipDetailListVO.get(0).getEffDt());
				customSlipApprovalHeaderVO.setVndrNo(searchApSlipDetailListVO.get(0).getVndrSeq());
				customSlipApprovalHeaderVO.setCsrAmt(searchApSlipDetailListVO.get(0).getRqstAmt());
				customSlipApprovalHeaderVO.setPayAmt("0");
				customSlipApprovalHeaderVO.setCsrCurrCd(searchApSlipDetailListVO.get(0).getCsrCurrCd());
				customSlipApprovalHeaderVO.setInvDesc(searchApSlipDetailListVO.get(0).getCsrDesc());

				customSlipApprovalHeaderVO.setInvDt("20"+searchApSlipDetailListVO.get(0).getSlpIssDt());
				customSlipApprovalHeaderVO.setAttrCateNm("Invoices");
				customSlipApprovalHeaderVO.setTaxDeclFlg("N");
				log.debug("customSlipApprovalHeaderVO.setAttrCtnt2 asaNo1 = "+asaNo);
				if(!("".equals(asaNo) || asaNo == null)){
					log.debug("customSlipApprovalHeaderVO.setAttrCtnt2 asaNo2 = "+asaNo);
					customSlipApprovalHeaderVO.setAttrCtnt2(asaNo);		// ASA No.
				}
				
				String taxCode = null;
//				List<SearchSlipApprovalTaxVO> searchSlipApprovalTaxVO = null;	
				
				log.debug("evidTpCd = "+evidTpCd);
				
				
				if (evidTpCd.equals("1")) {//세금계산서
					//Header
//					List<SearchSlipApprovalTaxVO> searchSlipApprovalTaxVO = dbDao.searchSlipApprovalTax(orgCsrNo);
					searchSlipApprovalTaxVO = dbDao.searchSlipApprovalTax(orgCsrNo);					
					
					log.debug("searchSlipApprovalTaxVO.size() = "+searchSlipApprovalTaxVO.size());
					
					
					if (searchSlipApprovalTaxVO.size() > 0) {
						
						//TAX_VAT_TP_CD=1 OR TAX_VAT_TP_CD=2 AND taxYn = 'Y' 인 경우만 세금계산서 내용  추가함.
						
//						if (searchSlipApprovalTaxVO.get(0).getTaxVatTpCd().equals("1") ||						
//							 (taxYn.equals("Y") && searchSlipApprovalTaxVO.get(0).getTaxVatTpCd().equals("2"))) {
						

						if (searchSlipApprovalTaxVO.get(0).getTaxVatTpCd().equals("1") || searchSlipApprovalTaxVO.get(0).getTaxVatTpCd().equals("2")) {						
						
							taxCode = searchSlipApprovalTaxVO.get(0).getTaxCode();

							customSlipApprovalHeaderVO.setInvDt(searchSlipApprovalTaxVO.get(0).getIssDt());
							
							log.debug("PPPPPP account = "+searchApSlipDetailListVO.get(0).getAcctCd());	
							
							//if("111811".equals(searchApSlipDetailListVO.get(0).getAcctCd()) ||	//2017.05.10 과세처리 로직 보완	 
							if("Y".equals(taxYn) ||
							    "962111".equals(searchApSlipDetailListVO.get(0).getAcctCd())) {  //Owner Account
								customSlipApprovalHeaderVO.setAttrCateNm("세금계산서");
							}
							else { //Payments Slip
								customSlipApprovalHeaderVO.setAttrCateNm("Invoices");
							}
							
							//if("111811".equals(searchApSlipDetailListVO.get(0).getAcctCd()) ||	//2017.05.10 과세처리 로직 보완	 
							if("Y".equals(taxYn) ||
								"962111".equals(searchApSlipDetailListVO.get(0).getAcctCd())) {
									customSlipApprovalHeaderVO.setAttrCtnt2(searchSlipApprovalTaxVO.get(0).getSplRgstNo());
									customSlipApprovalHeaderVO.setAttrCtnt3(searchSlipApprovalTaxVO.get(0).getIssDtTime());
									customSlipApprovalHeaderVO.setAttrCtnt4(searchSlipApprovalTaxVO.get(0).getSplAmt());
									customSlipApprovalHeaderVO.setAttrCtnt5(searchSlipApprovalTaxVO.get(0).getOfcCd());
									customSlipApprovalHeaderVO.setAttrCtnt6(searchSlipApprovalTaxVO.get(0).getTaxAmt());
									customSlipApprovalHeaderVO.setAttrCtnt8(searchApSlipDetailListVO.get(0).getDocEvidTpCd());
						   }	

							//Detail
							List<SearchSlipApprovalTaxDetailVO> searchSlipApprovalTaxDetailVO = dbDao.searchSlipApprovalTaxDetail(orgCsrNo);

							for (int i=0; i<searchSlipApprovalTaxDetailVO.size(); i++) {
								
								//AP Header 만들기
								//if("111811".equals(searchApSlipDetailListVO.get(0).getAcctCd()) ||	//2017.05.10 과세처리 로직 보완	 
								if("Y".equals(taxYn) ||
									"962111".equals(searchApSlipDetailListVO.get(0).getAcctCd())) { //Owner Account
									if (i==0) {
										customSlipApprovalHeaderVO.setGloAttrCtnt1(searchSlipApprovalTaxDetailVO.get(i).getItmNm());
										customSlipApprovalHeaderVO.setGloAttrCtnt2(searchSlipApprovalTaxDetailVO.get(i).getSplAmt());
										customSlipApprovalHeaderVO.setGloAttrCtnt3(searchSlipApprovalTaxDetailVO.get(i).getTaxAmt());
									} else if (i==1) {
										customSlipApprovalHeaderVO.setGloAttrCtnt4(searchSlipApprovalTaxDetailVO.get(i).getItmNm());
										customSlipApprovalHeaderVO.setGloAttrCtnt5(searchSlipApprovalTaxDetailVO.get(i).getSplAmt());
										customSlipApprovalHeaderVO.setGloAttrCtnt6(searchSlipApprovalTaxDetailVO.get(i).getTaxAmt());
									} else if (i==2) {
										customSlipApprovalHeaderVO.setGloAttrCtnt7(searchSlipApprovalTaxDetailVO.get(i).getItmNm());
										customSlipApprovalHeaderVO.setGloAttrCtnt8(searchSlipApprovalTaxDetailVO.get(i).getSplAmt());
										customSlipApprovalHeaderVO.setGloAttrCtnt9(searchSlipApprovalTaxDetailVO.get(i).getTaxAmt());
									} else if (i==3) {
										customSlipApprovalHeaderVO.setGloAttrCtnt10(searchSlipApprovalTaxDetailVO.get(i).getItmNm());
										customSlipApprovalHeaderVO.setGloAttrCtnt11(searchSlipApprovalTaxDetailVO.get(i).getSplAmt());
										customSlipApprovalHeaderVO.setGloAttrCtnt12(searchSlipApprovalTaxDetailVO.get(i).getTaxAmt());
									}
								}		
								
							}
							customSlipApprovalHeaderVO.setGloAttrCtnt13(searchSlipApprovalTaxVO.get(0).getTaxNo());
							customSlipApprovalHeaderVO.setTaxDeclFlg("Y");
							
						}
					}
					
				} else if (evidTpCd.equals("4")) {//계산서
					//Bill Header
					List<SearchSlipApprovalBillVO> searchSlipApprovalBillVO = dbDao.searchSlipApprovalBill(csrNo);
					
					if (searchSlipApprovalBillVO.size() > 0) {
						taxCode = searchSlipApprovalBillVO.get(0).getTaxCode();
						
						customSlipApprovalHeaderVO.setInvDt(searchSlipApprovalBillVO.get(0).getIssDt());
						customSlipApprovalHeaderVO.setAttrCateNm("계산서");
						customSlipApprovalHeaderVO.setAttrCtnt2(searchSlipApprovalBillVO.get(0).getSplRgstNo());
						customSlipApprovalHeaderVO.setAttrCtnt3(searchSlipApprovalBillVO.get(0).getIssDtTime());
						customSlipApprovalHeaderVO.setAttrCtnt4(searchSlipApprovalBillVO.get(0).getSplAmt());
						customSlipApprovalHeaderVO.setAttrCtnt5(searchSlipApprovalBillVO.get(0).getOfcCd());
						customSlipApprovalHeaderVO.setAttrCtnt6(searchSlipApprovalBillVO.get(0).getTaxAmt());
						customSlipApprovalHeaderVO.setAttrCtnt8(searchApSlipDetailListVO.get(0).getDocEvidTpCd());

						//Detail
						List<SearchSlipApprovalBillDetailVO> searchSlipApprovalBillDetailVO = dbDao.searchSlipApprovalBillDetail(csrNo);
						
						for (int i=0; i<searchSlipApprovalBillDetailVO.size(); i++) {
							
							    //AP Header 만들기
								if (i==0) {
									customSlipApprovalHeaderVO.setGloAttrCtnt1(searchSlipApprovalBillDetailVO.get(i).getItmNm());
									customSlipApprovalHeaderVO.setGloAttrCtnt2(searchSlipApprovalBillDetailVO.get(i).getSplAmt());
									customSlipApprovalHeaderVO.setGloAttrCtnt3("0");
								} else if (i==1) {
									customSlipApprovalHeaderVO.setGloAttrCtnt4(searchSlipApprovalBillDetailVO.get(i).getItmNm());
									customSlipApprovalHeaderVO.setGloAttrCtnt5(searchSlipApprovalBillDetailVO.get(i).getSplAmt());
									customSlipApprovalHeaderVO.setGloAttrCtnt6("0");
								} else if (i==2) {
									customSlipApprovalHeaderVO.setGloAttrCtnt7(searchSlipApprovalBillDetailVO.get(i).getItmNm());
									customSlipApprovalHeaderVO.setGloAttrCtnt8(searchSlipApprovalBillDetailVO.get(i).getSplAmt());
									customSlipApprovalHeaderVO.setGloAttrCtnt9("0");
								} else if (i==3) {
									customSlipApprovalHeaderVO.setGloAttrCtnt10(searchSlipApprovalBillDetailVO.get(i).getItmNm());
									customSlipApprovalHeaderVO.setGloAttrCtnt11(searchSlipApprovalBillDetailVO.get(i).getSplAmt());
									customSlipApprovalHeaderVO.setGloAttrCtnt12("0");
								}
						}
						customSlipApprovalHeaderVO.setGloAttrCtnt13(searchSlipApprovalBillVO.get(0).getBillNo());
						customSlipApprovalHeaderVO.setTaxDeclFlg("Y");
					}
					
				}
				
				customSlipApprovalHeaderVO.setSrcCtnt("CDAM");
				customSlipApprovalHeaderVO.setCoaCoCd("01");
				customSlipApprovalHeaderVO.setCoaRgnCd(searchSlipApprovalOfficeVO.get(0).getFincRgnCd());
				//customSlipApprovalHeaderVO.setCoaCtrCd(searchSlipApprovalOfficeVO.get(0).getApCtrCd());
				customSlipApprovalHeaderVO.setCoaCtrCd(searchApSlipDetailListVO.get(0).getCtrCd());
				customSlipApprovalHeaderVO.setCoaAcctCd("210111");
				customSlipApprovalHeaderVO.setCoaVvdCd("0000000000");

				//2012-02-14 하드코딩 제거 -> 화면에서 조회한 파라미터 값으로 셋팅
				//customSlipApprovalHeaderVO.setCoaInterCoCd("00");
				//customSlipApprovalHeaderVO.setCoaInterCoCd(interCoCd);

				customSlipApprovalHeaderVO.setCoaInterCoCd(searchSlipApprovalOwnerVO.get(0).getCoCd());
				
				customSlipApprovalHeaderVO.setCoaFtuN1stCd("000000");
				customSlipApprovalHeaderVO.setCoaFtuN2ndCd("000000");
				customSlipApprovalHeaderVO.setAproFlg("Y");
				//customSlipApprovalHeaderVO.setTjOfcCd(searchSlipApprovalOfficeVO.get(0).getOfcCd());
				customSlipApprovalHeaderVO.setTjOfcCd(searchApSlipDetailListVO.get(0).getSlpOfcCd());
				customSlipApprovalHeaderVO.setCreUsrId(usrId);
				
				//AP Detail 테이블에 생성된다
				List<CustomSlipApprovalDetailVO> insertVoList = new ArrayList<CustomSlipApprovalDetailVO>();

				for ( int i=0; i<listSize; i++ ) {
					//Prepayment Settlement인 경우
					if (searchApSlipDetailListVO.get(i).getSlpFuncCd().equals("S") &&
					    searchApSlipDetailListVO.get(i).getAcctCd().equals("111431")) {
						customSlipApprovalHeaderVO.setCsrAmt(searchApSlipDetailListVO.get(i).getCsrAmt().replaceAll("-",""));
						customSlipApprovalHeaderVO.setPayMzdLuCd("CLEARING");
						customSlipApprovalHeaderVO.setPayGrpLuCd("대내지불");
						customSlipApprovalHeaderVO.setPpdNo(searchApSlipDetailListVO.get(i).getOrgSlpTpCd()+
								searchApSlipDetailListVO.get(i).getOrgSlpFuncCd() +
								searchApSlipDetailListVO.get(i).getOrgSlpOfcCd() +
								searchApSlipDetailListVO.get(i).getOrgIssDt() +
								searchApSlipDetailListVO.get(i).getOrgSlpSerNo());
						customSlipApprovalHeaderVO.setPpdDtrbNo("1");
						customSlipApprovalHeaderVO.setPpdAplyAmt(searchApSlipDetailListVO.get(i).getCsrAmt().replaceAll("-",""));
						customSlipApprovalHeaderVO.setPpdGlDt(searchApSlipDetailListVO.get(i).getEffDt());
						continue;
					}
					
					CustomSlipApprovalDetailVO customSlipApprovalDetailVO = new CustomSlipApprovalDetailVO();
					
					customSlipApprovalDetailVO.setCsrNo(searchApSlipDetailListVO.get(i).getSlpTpCd()+
							searchApSlipDetailListVO.get(i).getSlpFuncCd() +
						    searchApSlipDetailListVO.get(i).getSlpOfcCd() +																			
							searchApSlipDetailListVO.get(i).getSlpIssDt() +
							searchApSlipDetailListVO.get(i).getSlpSerNo());
														
					customSlipApprovalDetailVO.setLineSeq(searchApSlipDetailListVO.get(i).getSlpSeqNo());
					customSlipApprovalDetailVO.setLineNo(searchApSlipDetailListVO.get(i).getSlpSeqNo());
					//if P이고 계정이 111431 && 111091이 아닌 경우만  MISCELLANEOUS else ITEM
					if (searchApSlipDetailListVO.get(i).getSlpFuncCd().equals("P") && !searchApSlipDetailListVO.get(i).getAcctCd().equals("111431")) {
						if(searchApSlipDetailListVO.get(i).getAcctCd().equals("111081")||searchApSlipDetailListVO.get(i).getAcctCd().equals("111091") ) {   //2015.01.09 민정호 FMS-111091수정 보완
							
							log.debug("searchApSlipDetailListVO.get(i).getSlpFuncCd() = "+searchApSlipDetailListVO.get(i).getSlpFuncCd());
							log.debug("searchApSlipDetailListVO.get(i).getAcctCd() = "+searchApSlipDetailListVO.get(i).getAcctCd());
							
							
							customSlipApprovalDetailVO.setLineTpLuCd("ITEM");
						} else {
							customSlipApprovalDetailVO.setLineTpLuCd("MISCELLANEOUS");
						}
					} else {
						if (searchApSlipDetailListVO.get(i).getAcctCd().equals("111811")) {
							customSlipApprovalDetailVO.setLineTpLuCd("TAX");

							if(evidTpCd.equals("5")){		// 과세, USD인 경우
								List<SearchSlipApprovalTaxVO> searchSlipApprovalTaxVO2 = dbDao.searchSlipApprovalTax(orgCsrNo);
								taxCode = searchSlipApprovalTaxVO2.get(0).getTaxCode();
							}							
							customSlipApprovalDetailVO.setInvTaxCd(taxCode);
						} else {														
							
							log.debug("22 searchApSlipDetailListVO.get(i).getSlpSeqNo() = "+searchApSlipDetailListVO.get(i).getSlpSeqNo());
							log.debug("22 searchApSlipDetailListVO.get(i).getAcctCd() = "+searchApSlipDetailListVO.get(i).getAcctCd());
							if(searchApSlipDetailListVO.get(i).getSlpSeqNo().equals("4000") && searchApSlipDetailListVO.get(i).getAcctCd().equals("951111")){		// 과세, 951111계정일 경우
								
								log.debug("tax setting");
								
								customSlipApprovalDetailVO.setLineTpLuCd("TAX");
								customSlipApprovalDetailVO.setInvTaxCd("매입10%일반");
							}else{
								customSlipApprovalDetailVO.setLineTpLuCd("ITEM");								
							}
						}
					}
					customSlipApprovalDetailVO.setInvAmt(searchApSlipDetailListVO.get(i).getCsrAmt());
					customSlipApprovalDetailVO.setInvDesc(searchApSlipDetailListVO.get(i).getSlpCsrDesc());
					customSlipApprovalDetailVO.setDtrbCoaCoCd("01");
					customSlipApprovalDetailVO.setDtrbCoaRgnCd(searchSlipApprovalOfficeVO.get(0).getFincRgnCd());
					//customSlipApprovalDetailVO.setDtrbCoaCtrCd(searchSlipApprovalOfficeVO.get(0).getApCtrCd());
					customSlipApprovalDetailVO.setDtrbCoaCtrCd(searchApSlipDetailListVO.get(0).getCtrCd());
					customSlipApprovalDetailVO.setDtrbCoaAcctCd(searchApSlipDetailListVO.get(i).getAcctCd());
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

					//2012-02-14 하드코딩 제거 -> 화면에서 조회한 파라미터 값으로 셋팅
					//customSlipApprovalDetailVO.setDtrbCoaInterCoCd("00");
					//20160511  DtrbCoaInterCoCd 입력은 AP_INV_HDR의 COA_INTER_CO_CD랑 같게 한다.
					//customSlipApprovalDetailVO.setDtrbCoaInterCoCd(interCoCd);
					customSlipApprovalDetailVO.setDtrbCoaInterCoCd(searchSlipApprovalOwnerVO.get(0).getCoCd());					
					

					customSlipApprovalDetailVO.setDtrbCoaFtuN1stCd("000000"); 
					customSlipApprovalDetailVO.setDtrbCoaFtuN2ndCd("000000"); 
					customSlipApprovalDetailVO.setAttrCateNm(searchApSlipDetailListVO.get(i).getAcctCd());
					
					customSlipApprovalDetailVO.setAttrCtnt1(searchApSlipDetailListVO.get(i).getInvNo());
					customSlipApprovalDetailVO.setAttrCtnt2("20"+searchApSlipDetailListVO.get(i).getSlpIssDt());
					customSlipApprovalDetailVO.setAttrCtnt3(searchApSlipDetailListVO.get(i).getSlpLocCd());
					customSlipApprovalDetailVO.setActVvdCd(searchApSlipDetailListVO.get(i).getVslCd()+ 
							searchApSlipDetailListVO.get(i).getSkdVoyNo()+
							searchApSlipDetailListVO.get(i).getSkdDirCd()+
							searchApSlipDetailListVO.get(i).getRevDirCd());
					customSlipApprovalDetailVO.setPlnSctrDivCd("O"); 
					customSlipApprovalDetailVO.setCreUsrId(searchApSlipDetailListVO.get(i).getCsrUsrId());

					insertVoList.add(customSlipApprovalDetailVO);
				}

				//201410 10만불 2차개발
				//전표 생성 화면 (Payments Slip, Prepayments Settlement, Owner's Account to Expenses, Manual Slip)에서만 AP Header, AP Detail 입력 가능
				String sendFlg = "Y";
				if("N".equals(aproFlgUpdateYn)){
					
					/** Owner's Account 962111이면 아래항목 강제적용 ----- S */
					String acctCd = searchApSlipDetailListVO.get(0).getAcctCd();
					String ofcCd = searchApSlipDetailListVO.get(0).getSlpOfcCd();
					
					if("962111".equals(acctCd)){
						log.debug("\r\nOwner's Account 962111... : " + acctCd);
						String cntCd = "";
						customSlipApprovalHeaderVO.setPayMzdLuCd("CMS ACH");
						// 국내지역이면 대내지불로
						cntCd = dbDao.searchCountryCodeByOfcCd(ofcCd);
						if("KR".equals(cntCd)) {
							customSlipApprovalHeaderVO.setPayGrpLuCd("대내지불");
						}else{
							customSlipApprovalHeaderVO.setPayGrpLuCd(ofcCd + "_O/EXP");
						}

						if (searchApSlipDetailListVO.get(0).getRqstAmt().equals("0")) {
							if("KR".equals(cntCd)) {
								customSlipApprovalHeaderVO.setPayGrpLuCd("ZERO PAYMENT");
							}else{
								customSlipApprovalHeaderVO.setPayGrpLuCd(ofcCd + "_ZERO PAYMENT");
							}
						}
						
						customSlipApprovalHeaderVO.setCoaAcctCd("210121");						
						
						sendFlg = "N";
					}
					/** Owner's Account 962111 ----- E */
					log.debug("\r\ndbDao.addApSlipApprovalHeader??? : " + acctCd);
					//AP Header(AP_INV_HDR) 생성
					dbDao.addApSlipApprovalHeader(customSlipApprovalHeaderVO);
					log.debug("\r\nAP Header(AP_INV_HDR) 생성 : " + acctCd);
					/** Owner's Account 962111이면 아래항목 강제적용 ----- S */
					if("962111".equals(acctCd)){
						// 첨부파일 필수항목
						dbDao.modifyApInvHdrAgmtFileCd(csrNo, "Y");
					}
					/** Owner's Account 962111 ----- E */
					
					//AP Detail(AP_INV_DTRB) 생성
					if (insertVoList.size() > 0) {
						dbDao.addApSlipApprovalDetails(insertVoList);
					}
				}
				
				//201410 10만불 2차개발
				if("Y2".equals(aproFlgUpdateYn) || "Y3".equals(aproFlgUpdateYn)){ // Owner's Account일때도 추가
					//해당 전표의 Apro_flg = 'Y'로 업데이트한다.
					dbDao.modifySlipApprovalConsultation (csrNo ,usrId );
				}
				
				if("Y2".equals(aproFlgUpdateYn)){ // 
					//해당 전표의 Apro_flg = 'Y'로 업데이트한다.
					dbDao.modifySlipApprovalOwnereAccount (csrNo ,usrId );
				}
				
				if (slipAproFlg.equals("Y") && sendFlg.equals("Y")) {  // G/W 결재 전표가 아닌 경우 - Prepayments Settlement
					dbDao.modifySlipApprovalConsultation (csrNo ,usrId );
				}
				
				
				//AP Invoice의 Interface할 데이터를 조회한다.
				List<SearchApSlipInterfaceListVO> searchApSlipInterfaceListVO = dbDao.searchApSlipInterfaceList(csrNo);
				
				//201410 10만불 2차개발
				//AP인 경우에는 eai전송 삭제				
				if("Y2".equals(aproFlgUpdateYn)){				
					// AP에서는 ERP에서 전송					
					//Send AP Invoice
					eaiDao.sendSlipApprovalToAP(csrNo, searchApSlipInterfaceListVO, "");	
					//AP Interface(AP_INV_IF) 입력
					//dbDao.addApSlipApprovalInterfaces(searchApSlipInterfaceListVO);
				}   
				
				if (slipAproFlg.equals("Y") && sendFlg.equals("Y")) {  // G/W 결재 전표가 아닌 경우 - Prepayments Settlement
					//Send AP Invoice
					String agmtCntYn = dbDao.searchAgmtCfmCd(csrNo);
					
					eaiDao.sendSlipApprovalToAP(csrNo, searchApSlipInterfaceListVO, agmtCntYn);	
					//AP Interface(AP_INV_IF) 입력
					//dbDao.addApSlipApprovalInterfaces(searchApSlipInterfaceListVO);
				}

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
	 * Manual Slip에서 재무 항차 조회한다<br>
	 * 
	 * @param fletCtrtNo String
	 * @param fmDt String
	 * @param toDt String
	 * @return List<SearchVvdListByManualSlipVO>
	 * @exception EventException
	 */
	public List<SearchVvdListByManualSlipVO> searchVvdListByManualSlip(String fletCtrtNo, String fmDt, String toDt) throws EventException {
		try {
			return dbDao.searchVvdListByManualSlip(fletCtrtNo, fmDt, toDt);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS01455",new String[]{}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01455",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * 생성된 Brokerage를 Manual 전표에서 처리하기 위해 조회한다<br>
	 * 
	 * @param currCd String
	 * @return List<SearchBrokerageListVO>
	 * @exception EventException
	 */
	public List<SearchBrokerageListVO> searchBrokerageList(String currCd) throws EventException {
		try {
			return dbDao.searchBrokerageList(currCd);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS01429",new String[]{}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01429",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Prepayment, 운항정지비용, 용선주 비용, Owner's Account 관련를 이용하여 전표를 생성한다<br>
	 * 
	 * @param customPamConsultationVOs CustomPamConsultationVO[]
	 * @param customPamCsulSlpVOs CustomPamCsulSlpVO[]
	 * @param customTaxVOs CustomTaxVO[]
	 * @param customTaxDtlVOs CustomTaxDtlVO[]
	 * @param SignOnUserAccount signOnUserAccount
	 * @return String
	 * @exception EventException
	 */
	public String managePaymentSlip(CustomPamConsultationVO[] customPamConsultationVOs, CustomPamCsulSlpVO[] customPamCsulSlpVOs, CustomTaxVO[] customTaxVOs, CustomTaxDtlVO[] customTaxDtlVOs, SignOnUserAccount signOnUserAccount) throws EventException {
		try {
			
			// 1 전표 번호
			String csrNo = "";
			
			// Slp Desc(2 전표 / 3전표에 적용)
			String slpDesc = "";
			
			// 1 전표가 생성되는 SLP 번호
			String orgSlpSerNo1 = "";
			
			// 1 전표가 생성될때 SEQ
			int slpSeqNo1 = 1;
			
			// 2 전표가 생성되는 SLP 번호
			String orgSlpSerNo2 = "";
			
			// 2 전표가 생성될때 SEQ
			int slpSeqNo2 = 1;
			
			// 3 전표가 생성되는 SLP 번호
			String orgSlpSerNo3 = "";
			
			// 3 전표가 생성될때 SEQ
			int slpSeqNo3 = 1;
			
			//원 전표
			String vatSlpSerNo = "";
			
			//전표 생성 번호 저장
			String slpSerNo = "";
					
			for (int i=0; i<customPamConsultationVOs.length; i++ ) {
				
				slpSerNo = dbDao.searchCsulSlpSeq("07", customPamConsultationVOs[i].getSlpTp(), customPamConsultationVOs[i].getSlpOfcCd());
							
				customPamConsultationVOs[i].setCsrNo(slpSerNo);
				
				if(customPamConsultationVOs[i].getVatFlg().equals("1")) {
					vatSlpSerNo = slpSerNo;
					orgSlpSerNo1 = slpSerNo;

				} else if(customPamConsultationVOs[i].getVatFlg().equals("2")) {
					orgSlpSerNo2 = slpSerNo;

				} else {
					orgSlpSerNo3 = slpSerNo;
				}				
	
				if (slpSerNo.equals("00001")) {
					dbDao.addCsulSlpSeq ( "07", customPamConsultationVOs[i].getSlpTp(), customPamConsultationVOs[i].getSlpOfcCd() , slpSerNo , customPamConsultationVOs[i].getCreUsrId() );
				} else {
					dbDao.modifyCsulSlpSeq ( "07", customPamConsultationVOs[i].getSlpTp(), customPamConsultationVOs[i].getSlpOfcCd() , slpSerNo , customPamConsultationVOs[i].getCreUsrId() );
				}
			}
			
			// 1 전표 번호
			csrNo = "07"+customPamConsultationVOs[0].getSlpTp()+customPamConsultationVOs[0].getSlpOfcCd()+customPamConsultationVOs[0].getSlpIssDt().substring(2)+vatSlpSerNo;
		
			// Consultation Master 정보 setting
			List<CustomPamConsultationVO> addConsultationVoList = new ArrayList<CustomPamConsultationVO>();

			for (int i=0; i<customPamConsultationVOs.length; i++ ) {
									
				if (customPamConsultationVOs[i].getIbflag().equals("I")){
					
					if(customPamConsultationVOs[i].getVatFlg().equals("1")) {
						customPamConsultationVOs[i].setVatSlpTpCd("");
						customPamConsultationVOs[i].setVatSlpFuncCd("");
						customPamConsultationVOs[i].setVatSlpOfcCd("");
						customPamConsultationVOs[i].setVatSlpIssDt("");
						customPamConsultationVOs[i].setVatSlpSerNo("");

					} else {
						customPamConsultationVOs[i].setVatSlpTpCd("07");
						customPamConsultationVOs[i].setVatSlpFuncCd(customPamConsultationVOs[0].getSlpTp());
						customPamConsultationVOs[i].setVatSlpOfcCd(customPamConsultationVOs[0].getSlpOfcCd());
						customPamConsultationVOs[i].setVatSlpIssDt(customPamConsultationVOs[0].getEffDt());
						customPamConsultationVOs[i].setVatSlpSerNo(vatSlpSerNo);
						
						// 2전표 / 3전표에 대한 slpDesc 재 설정(기존 slpDesc + 1전표 번호)
						slpDesc = customPamConsultationVOs[i].getSlpDesc();
						customPamConsultationVOs[i].setSlpDesc(slpDesc + " " + csrNo);
					}
					
					//발행 구분값을 Consultaion 테이블에 Insert 하기위해 CustomPamConsultationVO에 Setting한다
					if(customTaxVOs != null) {
						customPamConsultationVOs[i].setTaxIssCd(customTaxVOs[0].getTaxIssCd());
					}
					
					//영세일 경우는 두번째 데이타는 제외한다.  
					/*2017.05.10 과세처리 로직 보완
					if(customTaxVOs != null) {
						if(!((customTaxVOs[0].getTaxPlCd().equals("1")) && (i == 1))){
							addConsultationVoList.add(customPamConsultationVOs[i]);
						}
					}else{ */
						addConsultationVoList.add(customPamConsultationVOs[i]);
					//}
					
					
				}
			}

			if (addConsultationVoList.size() > 0) {
				dbDao.addPaymentSlipMasters(addConsultationVoList);
			} 
			
			// Consultation Detail 정보 setting
			List<CustomPamCsulSlpVO> addCsulSlpVoList = new ArrayList<CustomPamCsulSlpVO>();

			for (int i=0; i<customPamCsulSlpVOs.length; i++ ) {
				if (customPamCsulSlpVOs[i].getIbflag().equals("I")){
					
					// 2 전표
					if(customPamCsulSlpVOs[i].getVatFlg().equals("2")) {
						
						customPamCsulSlpVOs[i].setSeqNo(Integer.toString(slpSeqNo1++));
						customPamCsulSlpVOs[i].setSlpFuncCd("S");
						
						customPamCsulSlpVOs[i].setSlpSerNo(orgSlpSerNo2);
						customPamCsulSlpVOs[i].setCurrCd("KRW");	//2017.05.10 과세처리 로직 보완
					
					// 3 전표
					/*2017.05.10 과세처리 로직 보완
					} else if(customPamCsulSlpVOs[i].getVatFlg().equals("3")) {
						
						customPamCsulSlpVOs[i].setSeqNo(Integer.toString(slpSeqNo2++));
						customPamCsulSlpVOs[i].setSlpFuncCd("S");
						customPamCsulSlpVOs[i].setSlpSerNo(orgSlpSerNo3);						
						customPamCsulSlpVOs[i].setCurrCd("KRW");
					*/
					// 1 전표
					} else {
						customPamCsulSlpVOs[i].setSeqNo(Integer.toString(slpSeqNo3++));	
						customPamCsulSlpVOs[i].setSlpSerNo(orgSlpSerNo1);
						
						// Master 정보의 Currency 가 KRW 이고 세금증빙일때 처리
						if(	  customPamConsultationVOs[0].getCsrCurrCd().equals("KRW")
						   && customPamCsulSlpVOs[i].getFletSrcTpCd().equals("20")) {
							
							customPamCsulSlpVOs[i].setSlpFuncCd("S");
							customPamCsulSlpVOs[i].setCurrCd("KRW");
							
						} else {
							customPamCsulSlpVOs[i].setSlpFuncCd(customPamConsultationVOs[0].getSlpTp());
							customPamCsulSlpVOs[i].setCurrCd(customPamConsultationVOs[0].getCsrCurrCd());
						}
					}
					
					customPamCsulSlpVOs[i].setSlpOfcCd(customPamConsultationVOs[0].getSlpOfcCd());
					customPamCsulSlpVOs[i].setVslCd(customPamConsultationVOs[0].getVslCd());
					customPamCsulSlpVOs[i].setCreUsrId(customPamConsultationVOs[0].getCreUsrId());
					customPamCsulSlpVOs[i].setUpdUsrId(customPamConsultationVOs[0].getUpdUsrId());
										
					// 영세일 경우는 첫번째 일부 데이타, 두번째 데이타, 세번째 일부 테이타는 제외한다.  
					// Editor : 2012.06.07 : 배열 순서로 IF 조건 된 것을 수정
					/*
					if(customTaxVOs != null) {						
						:  i IN (0, 1, 4) 
						if( ! ( ( customTaxVOs[0].getTaxPlCd().equals("1") ) && ( i == 2 ) ) &&
							! ( ( customTaxVOs[0].getTaxPlCd().equals("1") ) && ( i == 3 ) ) &&  
							! ( ( customTaxVOs[0].getTaxPlCd().equals("1") ) && ( i == 5 ) ) && 
							! ( ( customTaxVOs[0].getTaxPlCd().equals("1") ) && ( i == 6 ) )){							
								if(  ! ( (   ( customTaxVOs[0].getTaxPlCd().equals("1") ) 
										      && ( i == 1 ) ) 
										  &&   ( customPamCsulSlpVOs[i].getSeqNo().equals("2") ) 
										)
								  ){
								addCsulSlpVoList.add(customPamCsulSlpVOs[i]);
							}							
					}else{
						addCsulSlpVoList.add(customPamCsulSlpVOs[i]);
					}*/
					
					//-> Server에서 점검하던 로직을  Client에서 처리 : Editor : 2012.06.08
					addCsulSlpVoList.add(customPamCsulSlpVOs[i]);
									
				}// End 'if (customPamCsulSlpVOs[i].getIbflag().equals("I")){'
			}// End 'For'
			

			if (addCsulSlpVoList.size() > 0) {
				dbDao.addPaymentSlipDetails(addCsulSlpVoList);
			}
			
			if(customTaxVOs != null) {
				
				// Tax Master 정보 setting
				List<CustomTaxVO> addTaxVoList = new ArrayList<CustomTaxVO>();
				
				for (int i=0; i<customTaxVOs.length; i++ ) {
					if (customTaxVOs[i].getIbflag().equals("I")){
						customTaxVOs[i].setTaxSerNo(Integer.toString(i+1));
						customTaxVOs[i].setSlpTpCd("07");
						customTaxVOs[i].setSlpFuncCd(customPamConsultationVOs[0].getSlpTp());
						customTaxVOs[i].setSlpOfcCd(customPamConsultationVOs[0].getSlpOfcCd());
						customTaxVOs[i].setSlpIssDt(customPamConsultationVOs[0].getEffDt());
						customTaxVOs[i].setSlpSerNo(vatSlpSerNo);
						customTaxVOs[i].setCreUsrId(customPamConsultationVOs[0].getCreUsrId());
						customTaxVOs[i].setUpdUsrId(customPamConsultationVOs[0].getUpdUsrId());
						
						addTaxVoList.add(customTaxVOs[i]);
					}
				}
				
				// Tax Master / Bill Master 정보 입력
				if (addTaxVoList.size() > 0) {
					if(customPamConsultationVOs[0].getEvidTpCd().equals("1")) {
						//세금 계산서
						dbDao.addPaymentTaxMasters(addTaxVoList);
					} else {
						//계산서
						dbDao.addPaymentBillMasters(addTaxVoList);
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
						customTaxDtlVOs[i].setCreUsrId(customPamConsultationVOs[0].getCreUsrId());
						customTaxDtlVOs[i].setUpdUsrId(customPamConsultationVOs[0].getUpdUsrId());
	
						addTaxDtlVoList.add(customTaxDtlVOs[i]);
					}
				}
				
				// Tax Detail / Bil Detail 정보 입력
				if (addTaxDtlVoList.size() > 0) {
					if(customPamConsultationVOs[0].getEvidTpCd().equals("1")) {
						//세금 계산서
						dbDao.addPaymentTaxDtls(addTaxDtlVoList);
					} else {
						//계산서
						dbDao.addPaymentBilDtls(addTaxDtlVoList);
					}
				}
			}

			/***************************
			 * 결재라인 지정
			 ***************************/
			CustomConsultationVO customConsultationVO = new CustomConsultationVO();
			
			//customConsultationVO.setSlpSerNo(csrNo);
			customConsultationVO.setEffDt(customPamConsultationVOs[0].getEffDt().replaceAll("-", ""));
			customConsultationVO.setSlpIssDt(customPamConsultationVOs[0].getSlpIssDt().replaceAll("-", ""));
			customConsultationVO.setCsrUsrId(signOnUserAccount.getUsr_id());
			customConsultationVO.setCsrUsrId(signOnUserAccount.getUsr_id());
			customConsultationVO.setCreUsrId(signOnUserAccount.getUsr_id());
			
			customConsultationVO.setAproStep(customPamConsultationVOs[0].getAproStep());
			customConsultationVO.setSlpTpCd("07");
			customConsultationVO.setSlpFuncCd(customPamConsultationVOs[0].getSlpTp());
			customConsultationVO.setSlpOfcCd(customPamConsultationVOs[0].getSlpOfcCd());
			customConsultationVO.setSlpIssDt(customPamConsultationVOs[0].getSlpIssDt());
			customConsultationVO.setSlpSerNo(customPamConsultationVOs[0].getCsrNo()); //tax 추가된 경우 ser no 가 잘못 매핑되어 수정함 2017.04.13
			customConsultationVO.setRqstAmt(customPamConsultationVOs[0].getDrAmt());
			customConsultationVO.setVndrSeq(customPamConsultationVOs[0].getOwnrCd());
			customConsultationVO.setCsrCurrCd(customPamConsultationVOs[0].getCsrCurrCd());
			customConsultationVO.setRqstDt(customPamConsultationVOs[0].getRqstDt());
			
			customConsultationVO.setMaxRows(customConsultationVO.getMaxRows()); //결재라인의 count를 위해
			this.createCSREPApproval(customConsultationVO, signOnUserAccount);
			
			return vatSlpSerNo;
			

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS01401",new String[]{}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01401",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Payment Slip 정보를 조회한다<br>
	 * 
	 * @param csrNo String
	 * @return List<SearchPaymentSlipListVO>
	 * @exception EventException
	 */
	public List<SearchPaymentSlipListVO> searchPaymentSlipList(String csrNo) throws EventException {
		try {
			return dbDao.searchPaymentSlipList(csrNo);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de); 
			throw new EventException(new ErrorHandler("FMS01400",new String[]{}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01400",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * 용/ 대선료 관련 비용 이외에 선박계약(Agreement Creation)과 상관없이 현업에서 처리해야 할 관련 제반 비용을 등록 및 변경한다<br>
	 * 
	 * @param customConsultationVO CustomConsultationVO
	 * @param customCsulSlpVOs CustomCsulSlpVO[]
	 * @param customTaxVOs CustomTaxVO[]
	 * @param customTaxDtlVOs CustomTaxDtlVO[]
	 * @param usrId String
	 * @param SignOnUserAccount signOnUserAccount
	 * @return String
	 * @exception EventException
	 */
	public String manageManualSlip(CustomConsultationVO customConsultationVO, CustomCsulSlpVO[] customCsulSlpVOs, CustomTaxVO[] customTaxVOs, CustomTaxDtlVO[] customTaxDtlVOs, String usrId, SignOnUserAccount signOnUserAccount) throws EventException{
		
		try {
			//전표 생성 번호 저장
			String slpSerNo = dbDao.searchCsulSlpSeq(customConsultationVO.getSlpTpCd(), customConsultationVO.getSlpFuncCd(), customConsultationVO.getSlpOfcCd());

			customConsultationVO.setSlpSerNo(slpSerNo);
			customConsultationVO.setEffDt(customConsultationVO.getEffDt().replaceAll("-", ""));
			customConsultationVO.setRqstDt(customConsultationVO.getRqstDt().replaceAll("-", ""));
			customConsultationVO.setSlpIssDt(customConsultationVO.getSlpIssDt().replaceAll("-", ""));
			customConsultationVO.setCsrAmt(customConsultationVO.getCsrAmt().replaceAll(",", ""));
			customConsultationVO.setRqstAmt(customConsultationVO.getRqstAmt().replaceAll(",", ""));
			customConsultationVO.setCsrUsrId(usrId);
			customConsultationVO.setUpdUsrId(usrId);
			customConsultationVO.setCreUsrId(usrId);
			dbDao.addMasterManualSlip(customConsultationVO);

			if (slpSerNo.equals("00001")) {
				dbDao.addCsulSlpSeq(customConsultationVO.getSlpTpCd(), customConsultationVO.getSlpFuncCd(), customConsultationVO.getSlpOfcCd(), slpSerNo, usrId);
			} else {
				dbDao.modifyCsulSlpSeq(customConsultationVO.getSlpTpCd(), customConsultationVO.getSlpFuncCd(), customConsultationVO.getSlpOfcCd(), slpSerNo, usrId);
			}

			int seqNo = 0;
			String slpSeqNo = "";
			
			List<CustomCsulSlpVO> addCsulSlpVoList = new ArrayList<CustomCsulSlpVO>();
			
			for ( int i=0; i<customCsulSlpVOs .length; i++ ) {
				if (customCsulSlpVOs[i].getIbflag().equals("I")) {
					seqNo++;
					if(String.valueOf(seqNo).length() == 1) {
						slpSeqNo = "000" + seqNo;
					} else if(String.valueOf(seqNo).length() == 2) {
						slpSeqNo = "00" + seqNo;
					} else if(String.valueOf(seqNo).length() == 3) {
						slpSeqNo = "0" + seqNo;
					} else {
						slpSeqNo = String.valueOf(seqNo);
					}

					customCsulSlpVOs[i].setSlpTpCd(customConsultationVO.getSlpTpCd());
					customCsulSlpVOs[i].setSlpFuncCd(customConsultationVO.getSlpFuncCd());
					customCsulSlpVOs[i].setSlpOfcCd(customConsultationVO.getSlpOfcCd());
					customCsulSlpVOs[i].setSlpIssDt(customConsultationVO.getSlpIssDt().replaceAll("-", ""));
					customCsulSlpVOs[i].setSlpSerNo(slpSerNo);
					customCsulSlpVOs[i].setSlpSeqNo(slpSeqNo);
					customCsulSlpVOs[i].setCsrCurrCd(customConsultationVO.getCsrCurrCd());
					customCsulSlpVOs[i].setTrnsCurrCd(customConsultationVO.getCsrCurrCd());
					customCsulSlpVOs[i].setTrnsAmt(customCsulSlpVOs[i].getCsrAmt());
					customCsulSlpVOs[i].setUpdUsrId(usrId);
					customCsulSlpVOs[i].setCreUsrId(usrId);
					addCsulSlpVoList.add(customCsulSlpVOs[i]);
				}
			}

			if ( addCsulSlpVoList.size() > 0 ) {
				dbDao.addManualSlips(addCsulSlpVoList);
			}

			// -------------------------------------------------------------------
			// Tax Evidance
			// -------------------------------------------------------------------
			if(customTaxVOs != null) {
				// Tax Master 정보 setting
				List<CustomTaxVO> addTaxVoList = new ArrayList<CustomTaxVO>();

				for (int i=0; i<customTaxVOs.length; i++ ) {
					if (customTaxVOs[i].getIbflag().equals("I")){
						customTaxVOs[i].setTaxSerNo(Integer.toString(i+1));
						customTaxVOs[i].setSlpTpCd(customConsultationVO.getSlpTpCd());
						customTaxVOs[i].setSlpFuncCd(customConsultationVO.getSlpFuncCd());
						customTaxVOs[i].setSlpOfcCd(customConsultationVO.getSlpOfcCd());
						customTaxVOs[i].setSlpIssDt(customConsultationVO.getEffDt());
						customTaxVOs[i].setSlpSerNo(slpSerNo);
						customTaxVOs[i].setCreUsrId(usrId);
						customTaxVOs[i].setUpdUsrId(usrId);
						
						addTaxVoList.add(customTaxVOs[i]);
					}
				}
				
				// Tax Master / Bill Master 정보 입력
				if (addTaxVoList.size() > 0) {
					if(customConsultationVO.getEvidTpCd().equals("1")) {
						//세금 계산서
						dbDao.addPaymentTaxMasters(addTaxVoList);
					} else {
						//계산서
						dbDao.addPaymentBillMasters(addTaxVoList);
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
						customTaxDtlVOs[i].setCreUsrId(usrId);
						customTaxDtlVOs[i].setUpdUsrId(usrId);
						
						addTaxDtlVoList.add(customTaxDtlVOs[i]);
					}
				}
				
				// Tax Detail / Bil Detail 정보 입력
				if (addTaxDtlVoList.size() > 0) {
					if(customConsultationVO.getEvidTpCd().equals("1")) {
						//세금 계산서
						dbDao.addPaymentTaxDtls(addTaxDtlVoList);
					} else {
						//계산서
						dbDao.addPaymentBilDtls(addTaxDtlVoList);
					}
				}
			}
			// -------------------------------------------------------------------
			
			/***************************
			 * 결재라인 지정			 
			 ***************************/
			customConsultationVO.setMaxRows(customConsultationVO.getMaxRows()); //결재라인의 count를 위해
			this.createCSREPApproval(customConsultationVO, signOnUserAccount);

			return slpSerNo;
	
		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01428",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01428",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * 용/ 대선료 관련 비용 이외에 선박계약(Agreement Creation)과 상관없이 현업에서 처리해야 할 관련 제반 비용을 조회한다<br>
	 * 
	 * @param customCsulSlpSeqVO CustomCsulSlpSeqVO
	 * @return List<SearchManualSlipListVO>
	 * @exception EventException
	 */
	public List<SearchManualSlipListVO> searchManualSlipList(CustomCsulSlpSeqVO customCsulSlpSeqVO) throws EventException {
		try {
			customCsulSlpSeqVO.setSlpIssDt(customCsulSlpSeqVO.getSlpIssDt().replaceAll("-", ""));
			return dbDao.searchManualSlipList(customCsulSlpSeqVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS01427",new String[]{}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01427",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * CSR No. 에 해당하는 Tax Master 데이타 조회<br>
	 * 
	 * @param csrNo String
	 * @return SearchTaxMasterEvidenceVO
	 * @exception EventException
	 */
	public SearchTaxMasterEvidenceVO searchTaxMasterEvidence(String csrNo) throws EventException {
		try {
			return dbDao.searchTaxMasterEvidence(csrNo);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS01461",new String[]{}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01461",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * CSR No. 에 해당하는 Tax Detail 데이타 조회<br>
	 * 
	 * @param csrNo String
	 * @return List<SearchTaxDetailEvidenceListVO>
	 * @exception EventException
	 */
	public List<SearchTaxDetailEvidenceListVO> searchTaxDetailEvidenceList(String csrNo) throws EventException {
		try {
			return dbDao.searchTaxDetailEvidenceList(csrNo);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS01461",new String[]{}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01461",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * AR INTERFACE 결과를 업데이트 작업 진행한다<br>
	 * 
	 * @param xmlObject XmlObject
	 * @exception EventException
	 */
	public void receiveSlipApprovalToAR (XmlObject xmlObject) throws EventException{
		
		try {
			
			FNS012R002Document doc = (FNS012R002Document) xmlObject;
			FNS012R002 sync = doc.getFNS012R002();
			
			com.hanjin.irep.erp.FNS012R002Document.FNS012R002.DataArea data = sync.getDataArea();
			com.hanjin.irep.erp.FNS012R002Document.FNS012R002.DataArea.ROWSET rowset = data.getROWSET();
			com.hanjin.irep.erp.FNS012R002Document.FNS012R002.DataArea.ROWSET.ROW[] row = rowset.getROWArray();
			
			String ifNo = null;
			String ifResult = null;
			String errorMsg = null;
			if(row !=null && row.length > 0) {
				
				for (int i=0; i<row.length; i++) {
					ifNo = row[i].getIFNO();
					ifResult = row[i].getIFRESULT();
					errorMsg = row[i].getERRORMSG();

					//AR INTERFACE 결과 업데이트
					dbDao.receiveSlipApprovalToAR(ifNo, ifResult, errorMsg);

				}
				
			}
	
		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS00057",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS00057",new String[]{}).getMessage(), ex);
		}
		
	}
	
	/**
	 * Cumstomer Code를 조회한다<br>
	 * 
	 * @param fletCtrtNo String
	 * @return List<SearchCustomerCodeVO>
	 * @exception EventException
	 */
	public List<SearchCustomerCodeVO> searchCustomerCode(String fletCtrtNo) throws EventException {
		try {
			return dbDao.searchCustomerCode(fletCtrtNo);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS01302",new String[]{}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01302",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * 승인처리<br>
	 * 
	 * @param usrId String
	 * @param csrNo String
	 * @param ofcCd String
	 * @exception EventException
	 */
	public void manageApproveFMS(String usrId, String csrNo, String ofcCd) throws EventException {
		manageApproveFMS( usrId,  csrNo,  ofcCd, "N");
	}

	/**
	 * 승인처리<br>
	 * 
	 * @param usrId String
	 * @param csrNo String
	 * @param ofcCd String
	 * @param batchEvntYN String
	 * @exception EventException
	 */	
	public void manageApproveFMS(String usrId, String csrNo, String ofcCd, String batchEvntYN) throws EventException{		
		try {																			
			
			// AP만 해당
			
			CondSearchSlipApprovalVO condSearchSlipApprovalVO = new CondSearchSlipApprovalVO(); 
			condSearchSlipApprovalVO.setCsrNo(csrNo);
						
			List<SearchSlipApprovalListVO> searchSlipApprovalListVO = this.searchSlipInquiryList(condSearchSlipApprovalVO);
									
			//승인세팅
			searchSlipApprovalListVO.get(0).setAproFlg("Y");
			searchSlipApprovalListVO.get(0).setCxlDesc("");						
			
			/* 용선인 경우 전표가 승인되면 ERP A/P 로 전송된다
			 * 대선인 경우 전표가 승인되면 ERP A/R 로 전송된다*/								
			String fletCtrtTpCd = searchSlipApprovalListVO.get(0).getFletCtrtTpCd();
			String aproFlgUpdateYn  = "";
			if (searchSlipApprovalListVO.get(0).getSlipType().equals("RV")) {
				fletCtrtTpCd = "RV";
			} else if (searchSlipApprovalListVO.get(0).getSlipType().equals("AR")) {
				fletCtrtTpCd = "AR";
			}
			
			// Owner's Account 전표가 오면
			OwnersAccountBC command = new OwnersAccountBCImpl();
			List<FmsCsulSlpVO> list = command.searchOwnersAccountCsulSlps(csrNo, "");
			// 962111계정을 확인해서
			if("962111".equals(list.get(0).getAcctCd())) {
				aproFlgUpdateYn  = "Y3";					
			}else{
				aproFlgUpdateYn  = "Y2";
			}
			log.debug("Account Code : " + list.get(0).getAcctCd() 
					+ "\r\nbatchEvntYN : " + batchEvntYN);
			// 2014.12 민정호 : AP, AR G/W에서 결재
//			if (fletCtrtTpCd.equals("TI") || fletCtrtTpCd.equals("OW") || fletCtrtTpCd.equals("") || (fletCtrtTpCd.equals("TO") && csrNo.substring(0,2).equals("07"))) {	//AP
//				String aproFlgUpdateYn  = "Y2";				
				this.manageSlipApproval(
													  fletCtrtTpCd
													, searchSlipApprovalListVO.get(0).getCsrNo()
													, searchSlipApprovalListVO.get(0).getAproFlg()
													, searchSlipApprovalListVO.get(0).getCxlDesc()
													, usrId
													, searchSlipApprovalListVO.get(0).getInterCoCd()
													, searchSlipApprovalListVO.get(0).getArInterCoCd()
													, aproFlgUpdateYn
													, ofcCd
													, ""
													, ""
												 );
//			}			
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS00057",new String[]{}).getMessage(), ex);
		}		
	}	
	
	/**
	 * 비승인 처리<br>
	 * 
	 * @param usrId String
	 * @param csrNo String
	 * @param ofcCd String	  
	 * @exception EventException
	 */
	public void manageDisapproveFMS(String usrId, String csrNo, String ofcCd) throws EventException{
		
		try {
			
			// AP만 해당			
			
			CondSearchSlipApprovalVO condSearchSlipApprovalVO = new CondSearchSlipApprovalVO(); 
			condSearchSlipApprovalVO.setCsrNo(csrNo);
			
			List<SearchSlipApprovalListVO> searchSlipApprovalListVO = this.searchSlipInquiryList(condSearchSlipApprovalVO);
							
			//비승인 세팅
			searchSlipApprovalListVO.get(0).setAproFlg("N");			// 비승인
			searchSlipApprovalListVO.get(0).setCxlDesc("Cancel");						
			
			
			/* 용선인 경우 전표가 승인되면 ERP A/P 로 전송된다
			 * 대선인 경우 전표가 승인되면 ERP A/R 로 전송된다*/					
			String fletCtrtTpCd = searchSlipApprovalListVO.get(0).getFletCtrtTpCd();
			String aproFlgUpdateYn  = "";
			if (searchSlipApprovalListVO.get(0).getSlipType().equals("RV")) {
				fletCtrtTpCd = "RV";
			}
			else if (searchSlipApprovalListVO.get(0).getSlipType().equals("AR")) {
				fletCtrtTpCd = "AR";
			}
	
			// Owner's Account 전표가 오면
			OwnersAccountBC command = new OwnersAccountBCImpl();
			List<FmsCsulSlpVO> list = command.searchOwnersAccountCsulSlps(csrNo, "");
			// 962111계정을 확인해서
			if("962111".equals(list.get(0).getAcctCd())) {
				aproFlgUpdateYn  = "Y3";					
			}else{
				aproFlgUpdateYn  = "Y2";
			}
			log.debug("Account Code : " + list.get(0).getAcctCd());
			//2014.12 민정호 AP, AR 둘다 G/W에서 승인 취소
//			if (fletCtrtTpCd.equals("TI") || fletCtrtTpCd.equals("OW") || fletCtrtTpCd.equals("") || (fletCtrtTpCd.equals("TO") && csrNo.substring(0,2).equals("07"))) {	//AP				  
//				String aproFlgUpdateYn  = "Y2";			
				this.manageSlipApproval(
													  fletCtrtTpCd
													, searchSlipApprovalListVO.get(0).getCsrNo()
													, searchSlipApprovalListVO.get(0).getAproFlg()
													, searchSlipApprovalListVO.get(0).getCxlDesc()
													, usrId
													, searchSlipApprovalListVO.get(0).getInterCoCd()
													, searchSlipApprovalListVO.get(0).getArInterCoCd()
													, aproFlgUpdateYn
													, ofcCd
													, ""
													, ""																										
													);
//			}							
			
			//최종결재자가 비승인 했을 경우
			//TimeCharterInOutAccountingSC의 manageSlipApproval에서 Cancel인 경우
			TCharterIOInvoiceBC invcommand = new TCharterIOInvoiceBCImpl();
			
			//AP, AR 공통,  용선/대선 전표가 취소 되면 Invoice에 전표번호가 Null 로 변경된다
			invcommand.modifySlipApprovalCancelInvoice(searchSlipApprovalListVO.get(0).getCsrNo(), usrId);
			
			//AP - TI이거나 값이 없는 경우일때만 실행
			if (fletCtrtTpCd.equals("TI") || fletCtrtTpCd.equals("")) {
				//용선 전표가 취소 되면 Owner's Account 에 전표번호가 Null 로 변경된다
				invcommand.modifySlipApprovalCancelOwnerAccount(searchSlipApprovalListVO.get(0).getCsrNo(), usrId);

				TCharterIOBunkerRegisterBC bnkcommand = new TCharterIOBunkerRegisterBCImpl();
				//용선인 경우 전표가 취소되면 Bunker의 전표 정보도 Null 로 업데이트된다
				bnkcommand.modifySlipApprovalCancelBunker(searchSlipApprovalListVO.get(0).getCsrNo(), usrId);			
			}			
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS00057",new String[]{}).getMessage(), ex);
		}		
	}				
	
	/**
	 * CSR Agreement Info List<br>
	 * 
	 * @param csrNo
	 * @return List<ComCsrRequestAgmtVO>
	 * @exception EventException
	 */
	public List<ComCsrRequestAgmtVO> printFmsCsrAgmtInfo(String csrNo) throws EventException {
		try {
			return dbDao.printFmsCsrAgmtInfo(csrNo);
		} catch (Exception ex) {
			log.error("err "+ex.toString(),ex);
			throw new EventException(ex.getMessage());
		}
	}	
	
	
	/**
	 * CSR Body Info List
	 * @param csrNo
	 * @return List<ComCsrRequestBodyVO>
	 */
	public List<ComCsrRequestBodyVO> printComCsrBodyInfo(String csrNo) throws EventException {
		try {
			return dbDao.printComCsrBodyInfo(csrNo);
		} catch (Exception ex) {
			log.error("err "+ex.toString(),ex);
			throw new EventException(ex.getMessage());
		}
	}	
	
	/**
	 * CSR Header Info
	 * @param csrNo
	 * @return ComCsrRequestHeaderVO
	 */
	public ComCsrRequestHeaderVO printComCsrHeaderInfo(String csrNo) throws EventException {
		try {
			return dbDao.printComCsrHeaderInfo(csrNo);
		} catch (Exception ex) {
			log.error("err "+ex.toString(),ex);
			throw new EventException(ex.getMessage());
		}
	}
	
	/**
	 * AR-GW결재 AR_INV_HDR 저장한다.<br>
	 * 
	 * @param csrNo String
	 * @param usrId String
	 * @exception EventException
	 */
	public void manageArInvHdr(String csrNo, String usrId) throws EventException{		
		try {
			dbDao.delArInvHdr(csrNo);
			dbDao.addArInvHdr(csrNo, usrId);
		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01425",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01425",new String[]{}).getMessage(), ex);
		}		
	}	
	
	/**
	 * GW에서 결과 값 전송<br>
	 * AR_INV_HDR 의  GW Url, Request_id 업데이트<br>
	 * 
	 * @param csr_no String
	 * @param request_id String
	 * @param gw_url String
	 * @exception EventException
	 */
	public void updateAproGwUrl(String csr_no, String request_id, String gw_url) throws EventException{		
		try {
			dbDao.updateAproGwUrl(csr_no, request_id, gw_url);
		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01425",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01425",new String[]{}).getMessage(), ex);
		}		
	}	
	
	/**
	 * 결재라인 setting 하는 Process
	 * @param CustomConsultationVO slipProcessVO
	 * @param SignOnUserAccount signOnUserAccount
	 * @throws EventException
	 */
	private void createCSREPApproval(CustomConsultationVO slipProcessVO, SignOnUserAccount signOnUserAccount) throws EventException {
		String  sCsrNo        = slipProcessVO.getSlpTpCd()
								+ slipProcessVO.getSlpFuncCd()
								+ slipProcessVO.getSlpOfcCd ()
								+ slipProcessVO.getSlpIssDt ().substring(2)
								+ slipProcessVO.getSlpSerNo ();
		
		String  sTotalAmt     = slipProcessVO.getRqstAmt ();
		String  sCostOfcCd    = slipProcessVO.getSlpOfcCd  ();
		String  sUsrNm        = signOnUserAccount.getUsr_nm();
		
		String  sCreUsrId     = signOnUserAccount.getUsr_id();
		String  sAproStep     = slipProcessVO.getAproStep  ();
		String  sOfcNm        = signOnUserAccount.getOfc_eng_nm();
		String  sVndrSeq      = slipProcessVO.getVndrSeq  ();
		String  sCurrCd       = slipProcessVO.getCsrCurrCd   ();
		String  sCntCd        = ("07".equals(slipProcessVO.getSlpTpCd())?"1":slipProcessVO.getMaxRows()+""); // Invoice 숫자? AP = 1, AR BL# 갯수? <= 권상준수석
		String  sPaymentDueDt = slipProcessVO.getRqstDt();
		String  sInvSubSysCd  = "FMS";				
		String  sAproKndCd    = ("07".equals(slipProcessVO.getSlpTpCd())?"CSR":"REV"); //AP면 CSR, AR이면 REV

		try {
			ApprovalUtil util = new ApprovalUtil();

			// COM_APRO_RQST_HDR
			ComAproRqstHdrVO header = new ComAproRqstHdrVO();
			header.setSubSysCd (sInvSubSysCd);
			header.setAproKndCd(sAproKndCd); 
			header.setRqstOfcCd(sCostOfcCd);
			header.setRqstOfcNm(sOfcNm);
			header.setRqstUsrJbTitNm(""); // 직책
			header.setRqstUsrId(sCreUsrId);
			header.setRqstUsrNm(sUsrNm);
			header.setCreUsrId (sCreUsrId); 

			// COM_APRO_RQST_ROUT 
			//String apro_step = com.hanjin.bizcommon.approval.util.ApprovalUtil.getApprovalRoute("SELHO", "SCE");
			ComAproRqstRoutVO[] route = util.convertApprovalRoute(sAproStep);

			// COM_APRO_CSR_DTL
			ComAproCsrDtlVO csr = new ComAproCsrDtlVO();
			csr.setCsrNo(sCsrNo);
			csr.setCostOfcCd(sCostOfcCd);
			csr.setInvKnt(sCntCd);
			csr.setVndrSeq(sVndrSeq);
			//csr.setPay_due_dt(sGen_pay_term_cd);
			csr.setPayDueDt(sPaymentDueDt);
			csr.setCurrCd(sCurrCd);
			csr.setAproTtlAmt(sTotalAmt.replace(",", ""));
			csr.setCreUsrId(sCreUsrId);
			csr.setUpdUsrId(sCreUsrId);

			// 결재 등록
			util.saveCsrApro(header, route, csr);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01410", new String[]{"Approval Line", "Save"}).getMessage(), ex);
		}
	}

	/**
	 * 결재라인 setting 하는 Process - 20T 역분개 전표 자동 생성
	 * @param CustomInterfaceStatusVO slipProcessVO
	 * @param SignOnUserAccount signOnUserAccount
	 * @throws EventException
	 */
	private void createCSREPApproval2(CustomInterfaceStatusVO slipProcessVO, SignOnUserAccount signOnUserAccount) throws EventException {
		String  sCsrNo        = slipProcessVO.getSlpTpCd()
								+ slipProcessVO.getSlpFuncCd()
								+ slipProcessVO.getSlpOfcCd ()
								+ slipProcessVO.getSlpIssDt ()
								+ slipProcessVO.getSlpSerNo ();
		
		String  sTotalAmt     = "0";
		String  sCostOfcCd    = slipProcessVO.getSlpOfcCd  ();
		String  sUsrNm        = signOnUserAccount.getUsr_nm();
		
		String  sCreUsrId     = signOnUserAccount.getUsr_id();
		String  sAproStep     = slipProcessVO.getAproStep  ();
		String  sOfcNm        = signOnUserAccount.getOfc_eng_nm();
		String  sVndrSeq      = slipProcessVO.getVndrSeq  ();
		String  sCurrCd       = "USD";
		String  sCntCd        = ("07".equals(slipProcessVO.getSlpTpCd())?"1":slipProcessVO.getMaxRows()+""); // Invoice 숫자? AP = 1, AR BL# 갯수? <= 권상준수석
		String  sPaymentDueDt = slipProcessVO.getSlpIssDt ();
		String  sInvSubSysCd  = "FMS";				
		String  sAproKndCd    = ("07".equals(slipProcessVO.getSlpTpCd())?"CSR":"REV"); //AP면 CSR, AR이면 REV

		try {
			ApprovalUtil util = new ApprovalUtil();

			// COM_APRO_RQST_HDR
			ComAproRqstHdrVO header = new ComAproRqstHdrVO();
			header.setSubSysCd (sInvSubSysCd);
			header.setAproKndCd(sAproKndCd); 
			header.setRqstOfcCd(sCostOfcCd);
			header.setRqstOfcNm(sOfcNm);
			header.setRqstUsrJbTitNm(""); // 직책
			header.setRqstUsrId(sCreUsrId);
			header.setRqstUsrNm(sUsrNm);
			header.setCreUsrId (sCreUsrId); 

			// COM_APRO_RQST_ROUT 
			//String apro_step = com.hanjin.bizcommon.approval.util.ApprovalUtil.getApprovalRoute("SELHO", "SCE");
			ComAproRqstRoutVO[] route = util.convertApprovalRoute(sAproStep);

			// COM_APRO_CSR_DTL
			ComAproCsrDtlVO csr = new ComAproCsrDtlVO();
			csr.setCsrNo(sCsrNo);
			csr.setCostOfcCd(sCostOfcCd);
			csr.setInvKnt(sCntCd);
			csr.setVndrSeq(sVndrSeq);
			//csr.setPay_due_dt(sGen_pay_term_cd);
			csr.setPayDueDt(sPaymentDueDt);
			csr.setCurrCd(sCurrCd);
			csr.setAproTtlAmt(sTotalAmt.replace(",", ""));
			csr.setCreUsrId(sCreUsrId);
			csr.setUpdUsrId(sCreUsrId);

			// 결재 등록
			util.saveCsrApro(header, route, csr);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01410", new String[]{"Approval Line", "Save"}).getMessage(), ex);
		}
	}
	
	/**
	 * CSR File Info List
	 * @param csrNo
	 * @return List<ComCsrRequestFileVO>
	 */
	public List<ComCsrRequestFileVO> printComCsrFileInfo(String csrNo) throws EventException {
		try {
			return dbDao.printComCsrFileInfo(csrNo);
		} catch (Exception ex) {
			log.error("err "+ex.toString(),ex);
			throw new EventException(ex.getMessage());
		}
	}
	
	/**
	 * AR_INV_HDR 의  최신 GL_DT 업데이트<br>
	 * 
	 * @param csrNo String
	 * @exception EventException
	 */	
	private void approvalRequestAccount2(String csrNo) throws EventException{		
		try {
			dbDao.modifyApprovalStep(csrNo);
			dbDao.modifyApprovalStep2(csrNo);
			dbDao.modifyApprovalStep3(csrNo);
			
//			ApprovalCsrVO approvalCsrVO = new ApprovalCsrVO();
//			approvalCsrVO.setCsrNo(csrNo);
//			
//			ApPayInvVO gldtModel = dbDaoApproval.checkUpdateRevVVD(approvalCsrVO); // AP_INV_HDR를 통해 신규GL_DT를 구함					
//			String newGlDt  = gldtModel.getNewGlDt();
//			
//			// 최종 승인자 정보 및 GL_DT 정보를 CSR ERP AP Interface 테이블로 업데이트한다
//			dbDaoApproval.modifyApprovalStep2(csrNo, newGlDt); //AP_INV_HDR에 신규GL_DT 설정 및 Sending... 표시처리			
		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01425",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01425",new String[]{}).getMessage(), ex);
		}				
	}	

	/**
	 * CSR cancel 처리한다.<br>
	 * 
	 * @param fletCtrtTpCd String
	 * @param csrNo String
	 * @param cxlDesc String
	 * @param usrId String
	 * @exception EventException
	 */
	public void manageCsrCancel(String fletCtrtTpCd, String csrNo, String cxlDesc, String usrId) throws EventException {
		try {		
			dbDao.removeComAproRqstHdr(csrNo);		
			dbDao.removeComAproRqstRout(csrNo);
			dbDao.removeComAproCsrDtl(csrNo);
			
			//취소 시 Consultation 에 취소 변경한다
			dbDao.modifySlipApprovalCancelConsultation(csrNo, cxlDesc, usrId);
	
			if (fletCtrtTpCd.equals("TI")
				|| (fletCtrtTpCd.equals("TO") && csrNo.substring(0,2).equals("07"))) {//AP
	
				//취소 시 원전표의 Consultation 에 취소 변경한다
				dbDao.modifySlipApprovalCancelOrginConsultation(csrNo, usrId);
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
}