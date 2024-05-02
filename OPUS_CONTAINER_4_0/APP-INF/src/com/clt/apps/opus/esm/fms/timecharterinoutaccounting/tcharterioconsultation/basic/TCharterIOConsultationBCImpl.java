/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TCharterIOSettlementBCImpl.java
*@FileTitle : Owner's Account to Expenses
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier :
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.basic;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.clt.apps.opus.esm.fms.fmscommonutil.BizComFmsUtil;
import com.clt.apps.opus.esm.fms.fmscommonutil.FmsConstants;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.integration.TCharterIOConsultationDBDAO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.ArMstRevVvdVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CondReverseCsrForSubletVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CondSearchInvoiceNoVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CondSearchSlipApprovalVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CondSearchSubletRevenueVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomArSlipApprovalDetailVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomArSlipApprovalHeaderVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomConsultationVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomCsulSlpSeqVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomCsulSlpVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomPamConsultationVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomPamCsulSlpVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomSlipApprovalDetailVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomSlipApprovalHeaderVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomTaxDtlVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomTaxVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchApSlipDetailListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchApVatSlipListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchArSlipDetailListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchBrokerageListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchCustomerCodeVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchInvoiceNoListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchManualSlipListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchPaymentSlipListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchPaymentSlipMasterVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchReverseCsrForSubletListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchReverseCsrForSubletSaveListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchSlipApprovalBillDetailVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchSlipApprovalBillVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchSlipApprovalListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchSlipApprovalOfficeVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchSlipApprovalOwnerVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchSlipApprovalTaxDetailVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchSlipApprovalTaxVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchSlipCorrectionDetailListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchSlipCorrectionListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchSlipDetailListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchSubletRevenueListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchSubletRevenueSlipListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchSubletReveuneDetailListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchTaxDetailEvidenceListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchTaxMasterEvidenceVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchVvdListByManualSlipVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.basic.AccountReceivableOutstandingBC;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.basic.AccountReceivableOutstandingBCImpl;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo.OutstandingInterfaceVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * OPUS-TimeCharterInOutAccounting Business Logic Basic Command implementation<br>
 * - Handling Business Logic of OPUS-TimeCharterInOutAccounting<br>
 *
 * @author 
 * @see ESM_FMS_0039EventResponse,TCharterIOSettlementBC refernce to each DAO Class
 * @since J2EE 1.6
 */
public class TCharterIOConsultationBCImpl extends BasicCommandSupport implements TCharterIOConsultationBC {

	// Database Access Object
	private transient TCharterIOConsultationDBDAO dbDao = null;
	//private transient TCharterIOConsultationEAIDAO eaiDao = null;

	/**
	 * Generating TCharterIOSettlementBCImpl object<br>
	 * Generating TCharterIOSettlementDBDAO<br>
	 */
	public TCharterIOConsultationBCImpl() {
		dbDao = new TCharterIOConsultationDBDAO();
		//eaiDao = new TCharterIOConsultationEAIDAO();
	}
	
	/**
	 * Registering Owner'sAccount Expense data<br>
	 * 
	 * @param customConsultationVO CustomConsultationVO
	 * @param customCsulSlpVOs CustomCsulSlpVO[]
	 * @param usrId String
	 * @return slpSerNo String
	 * @exception EventException
	 */
	/* 
	public String creationOwnerAccountExpense(CustomConsultationVO customConsultationVO, CustomCsulSlpVO[] customCsulSlpVOs, String usrId) throws EventException{
		
		try {
			
			
			String slpSerNo = ""; //dbDao.searchCsulSlpSeq(customConsultationVO.getSlpTpCd(), customConsultationVO.getSlpFuncCd(), customConsultationVO.getSlpOfcCd());
			
			customConsultationVO.setSlpSerNo(slpSerNo);
			customConsultationVO.setEffDt(customConsultationVO.getEffDt().replaceAll("-", ""));
			customConsultationVO.setSlpIssDt(customConsultationVO.getSlpIssDt().replaceAll("-", ""));
			customConsultationVO.setCsrUsrId(usrId);
			customConsultationVO.setCreUsrId(usrId);

			if (slpSerNo.equals("00001")) {
//				dbDao.addCsulSlpSeq ( customConsultationVO.getSlpTpCd(), customConsultationVO.getSlpFuncCd(), customConsultationVO.getSlpOfcCd() , slpSerNo , usrId );
			} else {
//				dbDao.modifyCsulSlpSeq ( customConsultationVO.getSlpTpCd(), customConsultationVO.getSlpFuncCd(), customConsultationVO.getSlpOfcCd() , slpSerNo , usrId );
			}

			
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

					
					CustomCsulSlpVO customCsulSlpVO = new CustomCsulSlpVO();
					customCsulSlpVO = (CustomCsulSlpVO)customCsulSlpVOs[i].clone();
					customCsulSlpVO.setAcctCd(customCsulSlpVOs[i].getRvsAcctCd());
					addCsulSlpVoList.add(customCsulSlpVO);

					
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
				//dbDao.addOwnerAccountExpenses(customConsultationVO, addCsulSlpVoList);
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
	*/
	
	
	/**
	 * Retrieving ReSublet Revenue slip data by ReSublet Revenue slip as a condition<br>
	 * 
	 * @param customCsulSlpSeqVO CustomCsulSlpSeqVO
	 * @return List<SearchSubletRevenueSlipListVO>
	 * @exception EventException
	 */
	public List<SearchSubletRevenueSlipListVO> searchSubletRevenueSlipList(CustomCsulSlpSeqVO customCsulSlpSeqVO) throws EventException {
		try {
			//customCsulSlpSeqVO.setSlpIssDt(customCsulSlpSeqVO.getSlpIssDt().replaceAll("-", ""));
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
	 * Checking Center Code / City Code value<br>
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
	 * Checking Bunker Vvd value<br>
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
	 * Retrieving Payment Slip information<br>
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
	 * Retrieving related costs have to be handled by work-site operation regardless of Agreement Creation aside from Charter/Hire Out costs <br>
	 * 
	 * @param customCsulSlpSeqVO CustomCsulSlpSeqVO
	 * @return List<SearchManualSlipListVO>
	 * @exception EventException
	 */
	public List<SearchManualSlipListVO> searchManualSlipList(CustomCsulSlpSeqVO customCsulSlpSeqVO) throws EventException {
		try {
			//customCsulSlpSeqVO.setSlpIssDt(customCsulSlpSeqVO.getSlpIssDt().replaceAll("-", ""));
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
	 * Retrieving Tax Master data relevant to CSR No. <br>
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
	 * Retrieving Tax Detail data relevant to CSR No. <br>
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
	 * Retrieving  Customer Code<br>
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
	 * Generating Slip by arranging prepayments in actual costs accounts <br>
	 * 
	 * @param customConsultationVO CustomConsultationVO
	 * @param customCsulSlpVOs CustomCsulSlpVO[]
	 * @param usrId String
	 * @return String
	 * @exception EventException
	 */
	public String managePrepaymentSettlement(CustomConsultationVO customConsultationVO, CustomCsulSlpVO[] customCsulSlpVOs, String usrId) throws EventException{
		
		try {
			
			// Saving generated slip number
			String slpSerNo = dbDao.searchCsulSlpSeq(customConsultationVO.getSlpTpCd(), customConsultationVO.getSlpFuncCd(), customConsultationVO.getSlpOfcCd());
			
			customConsultationVO.setSlpSerNo(slpSerNo);
			customConsultationVO.setEffDt(customConsultationVO.getEffDt().replaceAll("-", ""));
			String tmpSlpIssDt = BizComFmsUtil.getFormatSlpIssueDate(customConsultationVO.getSlpIssDt().replaceAll("-", ""));
			customConsultationVO.setSlpIssDt(tmpSlpIssDt); //yyMM 포맷으로 4자리로 변경.
			//customConsultationVO.setSlpIssDt(customConsultationVO.getSlpIssDt().replaceAll("-", ""));
			customConsultationVO.setCsrUsrId(usrId);
			customConsultationVO.setCsrUsrId(usrId);
			customConsultationVO.setCreUsrId(usrId);
	
			//FMS_CSUL_SLP_SEQ Add/Modify.
			this.manageCsulSlpSeq(customConsultationVO.getSlpTpCd(), customConsultationVO.getSlpFuncCd(), customConsultationVO.getSlpOfcCd() , slpSerNo , usrId);
			/*
			if (slpSerNo.equals("0001")) {//00001 4자리로 변경.
				dbDao.addCsulSlpSeq ( customConsultationVO.getSlpTpCd(), customConsultationVO.getSlpFuncCd(), customConsultationVO.getSlpOfcCd() , slpSerNo , usrId );
			} else {
				dbDao.modifyCsulSlpSeq ( customConsultationVO.getSlpTpCd(), customConsultationVO.getSlpFuncCd(), customConsultationVO.getSlpOfcCd() , slpSerNo , usrId );
			}
			 */
			List<CustomCsulSlpVO> addCsulSlpVoList = new ArrayList<CustomCsulSlpVO>();
			List<CustomCsulSlpVO> modifyCsulSlpVoList = new ArrayList<CustomCsulSlpVO>();

			for ( int i=0; i<customCsulSlpVOs .length; i++ ) {
					
				customCsulSlpVOs[i].setSlpTpCd(customConsultationVO.getSlpTpCd());
				customCsulSlpVOs[i].setSlpFuncCd(customConsultationVO.getSlpFuncCd());
				customCsulSlpVOs[i].setSlpOfcCd(customConsultationVO.getSlpOfcCd());
				customCsulSlpVOs[i].setSlpIssDt(customConsultationVO.getSlpIssDt());
				customCsulSlpVOs[i].setSlpSerNo(customConsultationVO.getSlpSerNo());
				customCsulSlpVOs[i].setCsrCurrCd(customConsultationVO.getCsrCurrCd());

				customCsulSlpVOs[i].setCreUsrId(usrId);

				addCsulSlpVoList.add(customCsulSlpVOs[i]);
				
				if (i==0) {
					customCsulSlpVOs[i].setUpdUsrId(usrId);
					modifyCsulSlpVoList.add(customCsulSlpVOs[i]);
					
					//Setting prepayments
					customConsultationVO.setCsrAmt(customCsulSlpVOs[i].getCsrAmt());
				}
				
				customConsultationVO.setEvidTpCd(FmsConstants.KEY_EVIDENCE_CLASS_F0);
			}

			dbDao.addPrepaymentSettlementMaster(customConsultationVO);
			
			if ( addCsulSlpVoList.size() > 0 ) {
				dbDao.addPrepaymentSettlementSlips(addCsulSlpVoList);
			}
			if ( modifyCsulSlpVoList.size() > 0 ) {
				dbDao.modifyPrepaymentSettlements(modifyCsulSlpVoList);
			}
			
			String rtnCsrNo =customConsultationVO.getSlpTpCd() 
							+customConsultationVO.getSlpFuncCd()
							+customConsultationVO.getSlpOfcCd()
							+customConsultationVO.getSlpIssDt()
							+customConsultationVO.getSlpSerNo();
			
			return rtnCsrNo;
			//return slpSerNo;
			
	
		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01500",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01500",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * In Charter case, when slip is consulted, it is sent to ERP A/P
	 * In Hire Out case, when slip is consulted, it is sent to ERP A/R<br>
	 * 
	 * @param fletCtrtTpCd String
	 * @param csrNo String
	 * @param aproFlg String
	 * @param cxlDesc String
	 * @param account SignOnUserAccount
	 * @return List<SearchArSlipDetailListVO>
	 * @throws EventException
	 */
	public List<SearchArSlipDetailListVO> manageSlipApproval(String fletCtrtTpCd, String csrNo, String aproFlg, String cxlDesc, SignOnUserAccount account) throws EventException {
		try {
			List<SearchArSlipDetailListVO> searchArSlipDetailListVO = null;
						
			if (aproFlg.equals("Y")) {
				//if (fletCtrtTpCd.equals("TI") || fletCtrtTpCd.equals("OW") || fletCtrtTpCd.equals("") || (fletCtrtTpCd.equals("TO") && csrNo.substring(0,2).equals("07"))) {	//AP
				if (FmsConstants.KEY_SLP_TP_CD_AP_07.equals(csrNo.substring(0,2))) {	//AP	
					log.debug("\n manageSlipApproval Approval AP Start  ==================.");
					
					this.manageApSlipApproval(csrNo, csrNo, account);
						
					List<SearchApVatSlipListVO> searchApVatSlipListVO = dbDao.searchApVatSlipList ( csrNo );
					if(searchApVatSlipListVO != null && searchApVatSlipListVO.size() > 0){
						for (int i=0; i<searchApVatSlipListVO.size(); i++) {
							this.manageApSlipApproval(searchApVatSlipListVO.get(i).getSlpTpCd() +
									searchApVatSlipListVO.get(i).getSlpFuncCd() +
									searchApVatSlipListVO.get(i).getSlpOfcCd() +
									searchApVatSlipListVO.get(i).getSlpIssDt() +
									searchApVatSlipListVO.get(i).getSlpSerNo() , csrNo, account);
						}
					}
					log.debug("\n manageSlipApproval Approval AP E n d  ==================.");
				} else {//AR
					log.debug("\n manageSlipApproval Approval AR Start  ==================.");
					
					searchArSlipDetailListVO = this.manageArSlipApproval(fletCtrtTpCd, csrNo, account);
					
					log.debug("\n manageSlipApproval Approval AR E n d  ==================.");
				}
			//Cancel
			} else {
				log.debug("\n manageSlipApproval Approval Cancel AP/AR Start  ==================.");
				//In case of canceling changing Consultation
				dbDao.modifySlipApprovalCancelConsultation(csrNo, cxlDesc, account.getUsr_id());
				//if (   fletCtrtTpCd.equals("TI") || (fletCtrtTpCd.equals("TO") && csrNo.substring(0,2).equals("07"))) {//AP
				if (FmsConstants.KEY_SLP_TP_CD_AP_07.equals(csrNo.substring(0,2))) {//AP
					//In case of canceling changing Consultation in original slip
					dbDao.modifySlipApprovalCancelOrginConsultation(csrNo, account.getUsr_id());
				}
				log.debug("\n manageSlipApproval Approval Cancel AP/AR  Start  ==================.");
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
	 * In Charter case, when slip is consulted, it is sent to ERP A/R
	 * 
	 * @param fletCtrtTpCd
	 * @param csrNo
	 * @param usrId
	 * @param cntCd
	 * @param ofcCd
	 * @throws EventException
	 */
	private List<SearchArSlipDetailListVO> manageArSlipApproval(String fletCtrtTpCd, String csrNo, SignOnUserAccount account) throws EventException {
		try {
			
			String usrId = account.getUsr_id();
			String cntCd = account.getCnt_cd();
			String ofcCd = account.getOfc_cd();
			
			log.debug("\n ============================================================"
					+ "\n manageArSlipApproval Start."
					+ "\n fletCtrtTpCd ["+fletCtrtTpCd+"] csrNo ["+csrNo+"] usrId ["+usrId+"] cntCd ["+cntCd+"] ofcCd ["+ofcCd+"]"
					+ "\n ============================================================");
			
			String itemKind = "H";
			List<SearchArSlipDetailListVO> searchArSlipDetailListVO = null;
			
			if (fletCtrtTpCd.equals("RV")) {//Reverse (Retrieving FMS_INV_DTL)
				
				//2015.11.10 Add Account 코드 추가.(Brokerage/Hire Revenue/Bunker
				List<String> acctCdList = new ArrayList<String>();
				acctCdList.add(FmsConstants.KEY_ACCT_CD_BY_BROKERAGE);
				acctCdList.add(FmsConstants.KEY_ACCT_CD_BY_HIRE_REVENUE);
				acctCdList.add(FmsConstants.KEY_ACCT_CD_BY_BUNKER);
				
				searchArSlipDetailListVO = dbDao.searchArRvsSlipDetailList(csrNo, acctCdList);
			} else {// (Retrieving FMS_CSUL_SLP)
				//In case of Hire Revenue 
				searchArSlipDetailListVO = dbDao.searchArSlipDetailList(csrNo);
				
				//In case of Bunker 
				if(searchArSlipDetailListVO == null || searchArSlipDetailListVO.size() == 0) {
					itemKind = "B";							
					searchArSlipDetailListVO = dbDao.searchArBunkerSlipDetailList(csrNo , FmsConstants.KEY_ACCT_CD_DEBIT); //2015.11.10 Add
				}
			}
			
			int listSize = searchArSlipDetailListVO != null ? searchArSlipDetailListVO.size() : 0;
			if (listSize > 0) {						
				
				String effDt = dbDao.searchCheckEffectiveDate(searchArSlipDetailListVO.get(0).getSlpOfcCd(), searchArSlipDetailListVO.get(0).getEffDt());
				
				if (effDt.equals("")) {
					throw new EventException(new ErrorHandler("FMS01556",new String[]{}).getMessage());
				}
										
				List<CustomArSlipApprovalHeaderVO> insertHdrVoList = new ArrayList<CustomArSlipApprovalHeaderVO>();					
				List<CustomArSlipApprovalDetailVO> insertDtlVoList = new ArrayList<CustomArSlipApprovalDetailVO>();
				List<OutstandingInterfaceVO> vosList = new ArrayList<OutstandingInterfaceVO>();
				
				//Checking financial voyage
				for (int i=0; i<listSize; i++) {
					//2015.01.09 VVD의 SLAN_CD 를 조회한다.
					String strTmpSlanCd = "";	
					String strTmpRlaneCd = "";
					if (!"".equals(searchArSlipDetailListVO.get(i).getVslCd())) {
						String vvd = searchArSlipDetailListVO.get(i).getVslCd()+ searchArSlipDetailListVO.get(i).getSkdVoyNo()+ searchArSlipDetailListVO.get(i).getSkdDirCd()+ searchArSlipDetailListVO.get(i).getRevDirCd();
						List<ArMstRevVvdVO> arMstRevVvdList = dbDao.searchCheckMdmVvdCode(vvd);
						
						if(null != arMstRevVvdList && arMstRevVvdList.size() > 0){
							strTmpSlanCd = arMstRevVvdList.get(0).getSlanCd();
							strTmpRlaneCd = arMstRevVvdList.get(0).getRlaneCd();
						}
						
						log.debug("\nAR Interface SlanCd ["+strTmpSlanCd+"] RlaneCd ["+strTmpRlaneCd+"] VVD ["+vvd+"]");
						
						if (null == arMstRevVvdList || ("").equals(strTmpSlanCd)) {
							throw new EventException(new ErrorHandler("FMS01558",new String[]{}).getMessage());
						}
					}

					
					CustomArSlipApprovalHeaderVO customArSlipApprovalHeaderVO = new CustomArSlipApprovalHeaderVO();
					customArSlipApprovalHeaderVO.setArIfNo(searchArSlipDetailListVO.get(i).getToIfNo());
					customArSlipApprovalHeaderVO.setArIfSerNo("1");
					customArSlipApprovalHeaderVO.setBlNo(searchArSlipDetailListVO.get(i).getBlNo());
					customArSlipApprovalHeaderVO.setArSrcCd("CDAM");
					customArSlipApprovalHeaderVO.setInvNo(searchArSlipDetailListVO.get(i).getInvNo());

					if (i==0) {
						//Checking customer
						List<SearchSlipApprovalOwnerVO> searchSlipApprovalOwnerVO = dbDao.searchSlipApprovalOwner("", searchArSlipDetailListVO.get(i).getCustCntCd(), searchArSlipDetailListVO.get(i).getCustSeq());
						if (searchSlipApprovalOwnerVO.size() == 0) {
							throw new EventException(new ErrorHandler("FMS01346",new String[]{}).getMessage());
						}
					}

					// Retrieving needed items from Office table and User table in case Slip Approval is approved
					List<SearchSlipApprovalOfficeVO> searchSlipApprovalOfficeVO = dbDao.searchSlipApprovalOffice(usrId, ofcCd);
					
					if (searchSlipApprovalOfficeVO.size() > 0) {
						log.debug("\nAR Interface AR Office CD Call ArOfcCd ["+searchSlipApprovalOfficeVO.get(0).getArOfcCd()+"] ArHdQtrOfcCd ["+searchSlipApprovalOfficeVO.get(0).getArHdQtrOfcCd()+"]");
						customArSlipApprovalHeaderVO.setArOfcCd(searchSlipApprovalOfficeVO.get(0).getArOfcCd());
						customArSlipApprovalHeaderVO.setRhqCd(searchSlipApprovalOfficeVO.get(0).getArHdQtrOfcCd());
						customArSlipApprovalHeaderVO.setInvCoaRgnCd(searchSlipApprovalOfficeVO.get(0).getFincRgnCd());
						customArSlipApprovalHeaderVO.setInvCoaCtrCd(searchSlipApprovalOfficeVO.get(0).getApCtrCd());
						//[2015.03.24] Modify AR_CURR_CD 추가.
						customArSlipApprovalHeaderVO.setArCurrCd(searchSlipApprovalOfficeVO.get(0).getArCurrCd());
					}
					
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
					
					//2015.01.09 NYK 조회한 SlanCd를 넣는다.CDM
					customArSlipApprovalHeaderVO.setSlanCd(strTmpSlanCd);//CDM
					customArSlipApprovalHeaderVO.setRlaneCd(strTmpRlaneCd);//CDMCO
					
					customArSlipApprovalHeaderVO.setIoBndCd("O");
					customArSlipApprovalHeaderVO.setCustCrFlg("Y");
					customArSlipApprovalHeaderVO.setDueDt(searchArSlipDetailListVO.get(i).getDueDt());
					customArSlipApprovalHeaderVO.setUsdAmt(searchArSlipDetailListVO.get(i).getInvAmt());
					customArSlipApprovalHeaderVO.setLoclAmt("0");
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
					customArSlipApprovalHeaderVO.setInvCoaAcctCd(FmsConstants.KEY_ACCT_CD_DEBIT);
					customArSlipApprovalHeaderVO.setInvCoaInterCoCd("00");
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
							searchSlipApprovalOfficeVO.get(0).getOfcCd() +
							searchArSlipDetailListVO.get(i).getSlpIssDt() +
							searchArSlipDetailListVO.get(i).getSlpSerNo());

					customArSlipApprovalHeaderVO.setCreUsrId(usrId);

					insertHdrVoList.add(customArSlipApprovalHeaderVO);

					//Detail
					CustomArSlipApprovalDetailVO customArSlipApprovalDetailVO = new CustomArSlipApprovalDetailVO();
					customArSlipApprovalDetailVO.setArIfNo(searchArSlipDetailListVO.get(i).getToIfNo());
					customArSlipApprovalDetailVO.setArIfSerNo("1");
					customArSlipApprovalDetailVO.setChgSeq("1");
					customArSlipApprovalDetailVO.setChgCd(FmsConstants.DEFAULT_AR_CHG_CD); //"CDM"
					customArSlipApprovalDetailVO.setRepChgCd("ERP");
					customArSlipApprovalDetailVO.setChgAmt(searchArSlipDetailListVO.get(i).getInvAmt());
					customArSlipApprovalDetailVO.setTrfRtAmt(searchArSlipDetailListVO.get(i).getInvAmt());
					customArSlipApprovalDetailVO.setRatAsCntrQty("1");
					customArSlipApprovalDetailVO.setSobId("1");
					customArSlipApprovalDetailVO.setChgFullNm("Charterage - Container");
					customArSlipApprovalDetailVO.setCurrCd(searchArSlipDetailListVO.get(i).getCurrCd());
					customArSlipApprovalDetailVO.setTaxAmt("0");
					customArSlipApprovalDetailVO.setRevCoaCoCd("01");
					customArSlipApprovalDetailVO.setRevCoaRgnCd(searchSlipApprovalOfficeVO.get(0).getFincRgnCd());
					customArSlipApprovalDetailVO.setRevCoaCtrCd(searchSlipApprovalOfficeVO.get(0).getApCtrCd());
					
					//2015.11.10 저장된 Acct로 넣어도 되지 않을까??? 화면에서 이미 Hire Revenue/Bunker 계정으로 넣고 있으니깐....좀더 로직을 살펴보아야 함.
					if(itemKind.equals("H")) {
						//Hire Revenue
						customArSlipApprovalDetailVO.setRevCoaAcctCd(FmsConstants.KEY_ACCT_CD_BY_HIRE_REVENUE); //Hire Revene Account
						customArSlipApprovalDetailVO.setAcctCd(FmsConstants.KEY_ACCT_CD_BY_HIRE_REVENUE);
						customArSlipApprovalDetailVO.setJoRevTpCd(FmsConstants.DEFAULT_AR_JO_REV_TP_CD_HIRE);
					} else {
						//Bunker(Other)...
						customArSlipApprovalDetailVO.setRevCoaAcctCd(FmsConstants.KEY_ACCT_CD_BY_BUNKER); //Bunker Account
						customArSlipApprovalDetailVO.setAcctCd(FmsConstants.KEY_ACCT_CD_BY_BUNKER);
						customArSlipApprovalDetailVO.setJoRevTpCd(FmsConstants.DEFAULT_AR_JO_REV_TP_CD_OTHER);
					}
					customArSlipApprovalDetailVO.setRevCoaInterCoCd("00");
					customArSlipApprovalDetailVO.setRevCoaVslCd("0000");
					customArSlipApprovalDetailVO.setRevCoaVoyNo("0000");
					customArSlipApprovalDetailVO.setRevCoaSkdDirCd("0");
					customArSlipApprovalDetailVO.setRevCoaDirCd("0");
					//customArSlipApprovalDetailVO.setAcctCd("411211"); //2015.11.10 위에서 구분해서 넣도록 수정함. AS-IS : 무조건 Hire Revenue 계정으로 넘기고 있음.
					//customArSlipApprovalDetailVO.setJoRevTpCd("CDM"); //2015.11.10 위에서 구분해서 넣는다.
					
					customArSlipApprovalDetailVO.setCreUsrId(usrId);

					insertDtlVoList.add(customArSlipApprovalDetailVO);
				
					// Need to modify IF_NO in FMS_INV_DTL
					searchArSlipDetailListVO.get(i).setUpdUsrId(usrId);
					
					
					vosList.add(setSarOtsIf(customArSlipApprovalHeaderVO, customArSlipApprovalDetailVO));
					
				}
				if (insertHdrVoList.size() > 0) {
					dbDao.addArSlipApprovalHeader(insertHdrVoList);
				}
				if (insertDtlVoList.size() > 0) {
					dbDao.addArSlipApprovalDetails(insertDtlVoList);
				}
				//if (insertHdrVoList.size() > 0) {
					//Send AR Invoice
					//eaiDao.sendSlipApprovalToAR(csrNo, insertHdrVoList, insertDtlVoList);
				//}
				//Updating Apro_flg = 'Y' in the slip 
				dbDao.modifySlipApprovalConsultation (csrNo ,usrId );
				
				// SAR OUTSTANDING INERFACE
				AccountReceivableOutstandingBC command = new AccountReceivableOutstandingBCImpl();
				command.addOutstandingInterface(vosList);
			}
			
			
			log.debug("\n ============================================================"
					+ "\n manageArSlipApproval E n d."
					+ "\n ============================================================");
			
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
	 * In Charter case, when slip is consulted, it is sent to ERP A/P
	 * 
	 * @param csrNo String
	 * @param orgCsrNo String
	 * @param usrId String
	 * @param cntCd String
	 * @param ofcCd String
	 * @exception EventException
	 */
	private void manageApSlipApproval(String csrNo, String orgCsrNo, SignOnUserAccount account) throws EventException {
		try {
			
			String usrId = account.getUsr_id();
			String cntCd = account.getCnt_cd();
			String ofcCd = account.getOfc_cd();
			
			log.debug("\n ============================================================"
					+ "\n manageApSlipApproval Start."
					+ "\n csrNo ["+csrNo+"] orgCsrNo ["+orgCsrNo+"] usrId ["+usrId+"] cntCd ["+cntCd+"] ofcCd ["+ofcCd+"]"
					+ "\n ============================================================");
			//Retrieving AP Slip Detail 
			List<SearchApSlipDetailListVO> searchApSlipDetailListVO = dbDao.searchApSlipDetailList(csrNo);
			
			int listSize = searchApSlipDetailListVO != null ? searchApSlipDetailListVO.size() : 0;
			
			log.debug("\n manageApSlipApproval listSize ["+listSize+"]");
			if (listSize > 0) {
				
				String effDt = dbDao.searchCheckEffectiveDate(searchApSlipDetailListVO.get(0).getSlpOfcCd(), searchApSlipDetailListVO.get(0).getEffDt());
				if (StringUtils.isEmpty(effDt)) {
					throw new EventException(new ErrorHandler("FMS01556",new String[]{}).getMessage());
				}
				
				String taxYn = "N";
				
				//2015.01.09 VVD의 SLAN_CD 를 조회한다.
				String strTmpSlanCd = "";	
				String strTmpRlaneCd = "";

				for (int i=0; i<listSize; i++) {
					//Checking financial voyage
					/*if (!searchApSlipDetailListVO.get(i).getVslCd().equals("")) {
						String vslCd = dbDao.searchCheckMdmVvdCode(searchApSlipDetailListVO.get(i).getVslCd()+ 
								searchApSlipDetailListVO.get(i).getSkdVoyNo()+
								searchApSlipDetailListVO.get(i).getSkdDirCd()+
								searchApSlipDetailListVO.get(i).getRevDirCd());

						if (vslCd.equals("")) {
							throw new EventException(new ErrorHandler("FMS01558",new String[]{}).getMessage());
						}
					}*/
					if (StringUtils.isNotEmpty(searchApSlipDetailListVO.get(i).getVslCd())) {
						String vvd = searchApSlipDetailListVO.get(i).getVslCd()+ searchApSlipDetailListVO.get(i).getSkdVoyNo()+ searchApSlipDetailListVO.get(i).getSkdDirCd()+ searchApSlipDetailListVO.get(i).getRevDirCd();
						List<ArMstRevVvdVO> arMstRevVvdList = dbDao.searchCheckMdmVvdCode(vvd);
						
						if(arMstRevVvdList != null && arMstRevVvdList.size() > 0){
							strTmpSlanCd = arMstRevVvdList.get(0).getSlanCd();
							strTmpRlaneCd = arMstRevVvdList.get(0).getRlaneCd();
						}
						
						log.debug("\nAP Interface SlanCd ["+strTmpSlanCd+"] RlaneCd ["+strTmpRlaneCd+"] VVD ["+vvd+"]");
						
						if (arMstRevVvdList == null || StringUtils.isEmpty(strTmpSlanCd)) {
							throw new EventException(new ErrorHandler("FMS01558",new String[]{}).getMessage());
						}
					}
					
					//Insert Tax information only in case account code is "111811"
					if (searchApSlipDetailListVO.get(i).getAcctCd().equals("111811")) {
						taxYn = "Y";
					}
					
				}
				
				//Checking Vendor 
				List<SearchSlipApprovalOwnerVO> searchSlipApprovalOwnerVO = dbDao.searchSlipApprovalOwner(searchApSlipDetailListVO.get(0).getVndrSeq(), searchApSlipDetailListVO.get(0).getCustCntCd(), searchApSlipDetailListVO.get(0).getCustSeq());
				
				if (searchSlipApprovalOwnerVO == null || searchSlipApprovalOwnerVO.size() == 0) {
					throw new EventException(new ErrorHandler("FMS01345",new String[]{}).getMessage());
				}
				
				//Generating VO to insert into AP Header(AP_INV_HDR) 
				String evidTpCd = searchApSlipDetailListVO.get(0).getEvidTpCd();
				CustomSlipApprovalHeaderVO customSlipApprovalHeaderVO = new CustomSlipApprovalHeaderVO();

				//Retrieving needed items from Office table and User table in case Slip Approval is approved
				List<SearchSlipApprovalOfficeVO> searchSlipApprovalOfficeVO = dbDao.searchSlipApprovalOffice(usrId, ofcCd);
				if (searchSlipApprovalOfficeVO.size() > 0) {
					customSlipApprovalHeaderVO.setAttrCtnt10(searchSlipApprovalOfficeVO.get(0).getUsrNm());
					customSlipApprovalHeaderVO.setUsrEml(searchSlipApprovalOfficeVO.get(0).getUsrEml());
				}
				customSlipApprovalHeaderVO.setCsrNo(csrNo);
				
				//NYK Modify 2014.11.04
				//1.MDM_VENDOR.PAY_MZD_CD 데이타 사용.
				//2.존재하지 않을시 "" 값을 넘김.
				//3.getSlpFuncCd().equals("S") && getAcctCd().equals("111431") : CLEARING >> N사에서는 PAY_MZD_CD 로 사용.
				String tmpPayMzdLuCd = (null != searchSlipApprovalOwnerVO && searchSlipApprovalOwnerVO.size() > 0) ? searchSlipApprovalOwnerVO.get(0).getPayMzdCd() : "";
				log.debug("\n FMS manageApSlipApproval PayMzdLuCd ["+tmpPayMzdLuCd+"]");
				if(null != tmpPayMzdLuCd &&  !tmpPayMzdLuCd.trim().equals("")){
					customSlipApprovalHeaderVO.setPayMzdLuCd(tmpPayMzdLuCd);
					log.debug("\n FMS manageApSlipApproval is Exists PayMzdLuCd ["+customSlipApprovalHeaderVO.getPayMzdLuCd()+"]");
				}else{
					customSlipApprovalHeaderVO.setPayMzdLuCd("");
					//customSlipApprovalHeaderVO.setPayMzdLuCd("WIRE");
					log.debug("\n FMS manageApSlipApproval is Not Exists PayMzdLuCd ["+customSlipApprovalHeaderVO.getPayMzdLuCd()+"]");
				}
				
				// AP_OFFICE 국가 코드가 KR이면 INTERNAL PAYMENT ELSE OFFICE CODE + "_O/EXP" PAY_GRP_LU_CD
				// AP_OFFICE 국가 코드가 KR이면 ZERO PAYMENT ELSE OFFICE CODE + "_O/EXP" PAY_GRP_LU_CD
				customSlipApprovalHeaderVO.setPayGrpLuCd(("KR".equals(cntCd) ? "INTERNAL PAYMENT" : searchSlipApprovalOfficeVO.get(0).getOfcCd() + "_O/EXP"));
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
						customSlipApprovalHeaderVO.setPayGrpLuCd(("KR".equals(cntCd) ? "ZERO PAYMENT" : searchSlipApprovalOfficeVO.get(0).getOfcCd() + "_O/EXP"));
					}
					customSlipApprovalHeaderVO.setPpayAplyFlg("N");
				}
				customSlipApprovalHeaderVO.setGlDt(searchApSlipDetailListVO.get(0).getEffDt());
				customSlipApprovalHeaderVO.setVndrNo(searchApSlipDetailListVO.get(0).getVndrSeq());
				customSlipApprovalHeaderVO.setCsrAmt(searchApSlipDetailListVO.get(0).getRqstAmt());
				customSlipApprovalHeaderVO.setPayAmt("0");
				customSlipApprovalHeaderVO.setCsrCurrCd(searchApSlipDetailListVO.get(0).getCsrCurrCd());
				customSlipApprovalHeaderVO.setInvDesc(searchApSlipDetailListVO.get(0).getCsrDesc());

				//customSlipApprovalHeaderVO.setInvDt("20"+searchApSlipDetailListVO.get(0).getSlpIssDt());
				//2014.10.02 NYK Modify 
				customSlipApprovalHeaderVO.setInvDt(searchApSlipDetailListVO.get(0).getCreDt());
				//2015.03.04 NYK Modify : ATTR_CATE_NM = 'Invoices'
				customSlipApprovalHeaderVO.setAttrCateNm(FmsConstants.DEFAULT_AP_INV_HDR_ATTR_CATE_NM);//ETC
				customSlipApprovalHeaderVO.setTaxDeclFlg("N");

				String taxCode = "";
				//2015.07.30 NYK Tax 를 사용하지 않으므로 아래 Tax 관련 로직은 타지 않음.
				if (FmsConstants.KEY_EVIDENCE_CLASS_F0.equals(evidTpCd)) {//Tax Invoice old 1
					//Header
					List<SearchSlipApprovalTaxVO> searchSlipApprovalTaxVO = dbDao.searchSlipApprovalTax(orgCsrNo);
					
					if (searchSlipApprovalTaxVO != null && searchSlipApprovalTaxVO.size() > 0) {
						
						//Only in case TAX_VAT_TP_CD=1 OR TAX_VAT_TP_CD=2 AND taxYn = 'Y', add information into Tax Invoice
						
						if (searchSlipApprovalTaxVO.get(0).getTaxVatTpCd().equals("1") ||						
							 (taxYn.equals("Y") && 	searchSlipApprovalTaxVO.get(0).getTaxVatTpCd().equals("2"))) {
							taxCode = StringUtils.isBlank(searchSlipApprovalTaxVO.get(0).getTaxCode()) ? "" : searchSlipApprovalTaxVO.get(0).getTaxCode() ;

							customSlipApprovalHeaderVO.setInvDt(searchSlipApprovalTaxVO.get(0).getIssDt());
							customSlipApprovalHeaderVO.setAttrCateNm("TAX");
							customSlipApprovalHeaderVO.setAttrCtnt2(searchSlipApprovalTaxVO.get(0).getSplRgstNo());
							customSlipApprovalHeaderVO.setAttrCtnt3(searchSlipApprovalTaxVO.get(0).getIssDtTime());
							customSlipApprovalHeaderVO.setAttrCtnt4(searchSlipApprovalTaxVO.get(0).getSplAmt());
							customSlipApprovalHeaderVO.setAttrCtnt5(searchSlipApprovalTaxVO.get(0).getOfcCd());
							customSlipApprovalHeaderVO.setAttrCtnt6(searchSlipApprovalTaxVO.get(0).getTaxAmt());
							customSlipApprovalHeaderVO.setAttrCtnt8(searchApSlipDetailListVO.get(0).getDocEvidTpCd());

							//Detail
							List<SearchSlipApprovalTaxDetailVO> searchSlipApprovalTaxDetailVO = dbDao.searchSlipApprovalTaxDetail(orgCsrNo);

							if(searchSlipApprovalTaxDetailVO != null && searchSlipApprovalTaxDetailVO.size() > 0){
								for (int i=0; i<searchSlipApprovalTaxDetailVO.size(); i++) {
									
									//Setting AP Header 
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
					
				} else if (FmsConstants.KEY_EVIDENCE_CLASS_E3.equals(evidTpCd)) { //evidTpCd.equals("4")
					//Bill Header
					List<SearchSlipApprovalBillVO> searchSlipApprovalBillVO = dbDao.searchSlipApprovalBill(csrNo);
					
					if (searchSlipApprovalBillVO != null && searchSlipApprovalBillVO.size() > 0) {
						//taxCode = searchSlipApprovalBillVO.get(0).getTaxCode();
						taxCode = StringUtils.isBlank(searchSlipApprovalBillVO.get(0).getTaxCode()) ? "" : searchSlipApprovalBillVO.get(0).getTaxCode() ;
						
						customSlipApprovalHeaderVO.setInvDt(searchSlipApprovalBillVO.get(0).getIssDt());
						customSlipApprovalHeaderVO.setAttrCateNm("TAX");
						customSlipApprovalHeaderVO.setAttrCtnt2(searchSlipApprovalBillVO.get(0).getSplRgstNo());
						customSlipApprovalHeaderVO.setAttrCtnt3(searchSlipApprovalBillVO.get(0).getIssDtTime());
						customSlipApprovalHeaderVO.setAttrCtnt4(searchSlipApprovalBillVO.get(0).getSplAmt());
						customSlipApprovalHeaderVO.setAttrCtnt5(searchSlipApprovalBillVO.get(0).getOfcCd());
						customSlipApprovalHeaderVO.setAttrCtnt6(searchSlipApprovalBillVO.get(0).getTaxAmt());
						customSlipApprovalHeaderVO.setAttrCtnt8(searchApSlipDetailListVO.get(0).getDocEvidTpCd());

						//Detail
						List<SearchSlipApprovalBillDetailVO> searchSlipApprovalBillDetailVO = dbDao.searchSlipApprovalBillDetail(csrNo);
						
						if(searchSlipApprovalBillDetailVO != null && searchSlipApprovalBillDetailVO.size() > 0){
							for (int i=0; i<searchSlipApprovalBillDetailVO.size(); i++) {
								
								//AP Header 
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
						}
						customSlipApprovalHeaderVO.setGloAttrCtnt13(searchSlipApprovalBillVO.get(0).getBillNo());
						customSlipApprovalHeaderVO.setTaxDeclFlg("Y");
					}
					
				}
				
				//taxCode null > "" 로 변환.
				taxCode = StringUtils.isBlank(taxCode) ? "" : taxCode ;
				
				customSlipApprovalHeaderVO.setSrcCtnt(FmsConstants.DEFAULT_AP_INV_HDR_SRC_CTNT);//2015.02.24 CDAM > FMS 로 변경.
				customSlipApprovalHeaderVO.setCoaCoCd(FmsConstants.DEFAULT_AP_INV_HDR_COA_CO_CD); // 01
				customSlipApprovalHeaderVO.setCoaRgnCd(searchSlipApprovalOfficeVO.get(0).getFincRgnCd());
				//customSlipApprovalHeaderVO.setCoaCtrCd(searchSlipApprovalOfficeVO.get(0).getApCtrCd());
				customSlipApprovalHeaderVO.setCoaCtrCd(searchApSlipDetailListVO.get(0).getCtrCd());
				customSlipApprovalHeaderVO.setCoaAcctCd(FmsConstants.DEFAULT_AP_INV_HDR_COA_ACCT_CD); //210111
				customSlipApprovalHeaderVO.setCoaVvdCd(FmsConstants.DEFAULT_AP_INV_HDR_COA_VVD_CD);//0000000000
				customSlipApprovalHeaderVO.setCoaInterCoCd(FmsConstants.DEFAULT_AP_INV_HDR_COA_INTER_CO_CD);//00
				customSlipApprovalHeaderVO.setCoaFtuN1stCd(FmsConstants.DEFAULT_AP_INV_HDR_COA_FTU_N1ST_CD);//000000
				customSlipApprovalHeaderVO.setCoaFtuN2ndCd(FmsConstants.DEFAULT_AP_INV_HDR_COA_FTU_N2ND_CD);//000000
				customSlipApprovalHeaderVO.setAproFlg(FmsConstants.DEFAULT_AP_INV_HDR_APRO_FLG);//Y
				customSlipApprovalHeaderVO.setTjOfcCd(searchSlipApprovalOfficeVO.get(0).getOfcCd());
				customSlipApprovalHeaderVO.setCreUsrId(usrId);
				
				List<CustomSlipApprovalDetailVO> insertVoList = new ArrayList<CustomSlipApprovalDetailVO>();

				for ( int i=0; i<listSize; i++ ) {
					//In case of Prepayment Settlement
					if (searchApSlipDetailListVO.get(i).getSlpFuncCd().equals("S") &&
					    searchApSlipDetailListVO.get(i).getAcctCd().equals("111431")) {
						customSlipApprovalHeaderVO.setCsrAmt(searchApSlipDetailListVO.get(i).getCsrAmt().replaceAll("-",""));
						//NYK Modify 2014.11.04
						//S, 111431 일대 payMzdLuCd : CLEARING 처리 부분 확인 필요. >> N사의 경우 Method에는 모두 지불과 관련된 Method을 사용중
						//customSlipApprovalHeaderVO.setPayMzdLuCd("CLEARING");
						customSlipApprovalHeaderVO.setPayGrpLuCd(("KR".equals(cntCd) ? "INTERNAL PAYMENT" : searchSlipApprovalOfficeVO.get(0).getOfcCd() + "_O/EXP"));
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
							//searchSlipApprovalOfficeVO.get(0).getOfcCd() +
							searchApSlipDetailListVO.get(i).getSlpIssDt() +
							searchApSlipDetailListVO.get(i).getSlpSerNo());
					customSlipApprovalDetailVO.setLineSeq(searchApSlipDetailListVO.get(i).getSlpSeqNo());
					customSlipApprovalDetailVO.setLineNo(searchApSlipDetailListVO.get(i).getSlpSeqNo());
					//if P and account != 111431,  MISCELLANEOUS else ITEM
					if (searchApSlipDetailListVO.get(i).getSlpFuncCd().equals("P") && !searchApSlipDetailListVO.get(i).getAcctCd().equals("111431")) {
						if(searchApSlipDetailListVO.get(i).getAcctCd().equals("111081")) {
							customSlipApprovalDetailVO.setLineTpLuCd("ITEM");
						} else {
							customSlipApprovalDetailVO.setLineTpLuCd("MISCELLANEOUS");
						}
					} else {
						if (searchApSlipDetailListVO.get(i).getAcctCd().equals("111811")) {
							customSlipApprovalDetailVO.setLineTpLuCd("TAX");
							customSlipApprovalDetailVO.setInvTaxCd(taxCode);
						} else {
							customSlipApprovalDetailVO.setLineTpLuCd("ITEM");
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
					customSlipApprovalDetailVO.setDtrbCoaInterCoCd("00"); 
					customSlipApprovalDetailVO.setDtrbCoaFtuN1stCd("000000"); 
					customSlipApprovalDetailVO.setDtrbCoaFtuN2ndCd("000000"); 
					customSlipApprovalDetailVO.setAttrCateNm(searchApSlipDetailListVO.get(i).getAcctCd());

					//NYK Modify 2015.03.04 AP_INV_DTRB 의 ATTR_CTNT1 : 전표의 Journal Type + Office + 년월 + SEQ
					customSlipApprovalDetailVO.setAttrCtnt1(customSlipApprovalDetailVO.getCsrNo().substring(2));
					
					customSlipApprovalDetailVO.setAttrCtnt2(searchApSlipDetailListVO.get(i).getCreDt());
					customSlipApprovalDetailVO.setAttrCtnt3(searchApSlipDetailListVO.get(i).getSlpLocCd());
					
					log.debug("manageApSlipApproval =====================\n"+
					          "\n setAttrCtnt1  csrNo       ["+customSlipApprovalDetailVO.getCsrNo().substring(2)+"]"+
					          "\n setAttrCtnt2  creDt       ["+searchApSlipDetailListVO.get(i).getCreDt()+"]"+
					          "\n setAttrCtnt3  slpLocCd    ["+searchApSlipDetailListVO.get(i).getSlpLocCd()+"]"+
					          "\n setAttrCtnt11 creDt       ["+searchApSlipDetailListVO.get(i).getCreDt()+"]"+
					          "\n setAttrCtnt12 slpOfcCd    ["+searchApSlipDetailListVO.get(i).getSlpOfcCd()+"]"+
					          "\n setAttrCtnt14 vslSlanCd   ["+searchApSlipDetailListVO.get(i).getVslSlanCd()+"]"+
					          "\n setAttrCtnt14 strTmpSlanCd["+strTmpSlanCd+"]"+
							  "");
					//NYK Modify 2014.10.13 Activity Date/Place I/F 항목 추가
					//NYK GAP AP_INV_DTRB.ATTR_CTNT2 : CSR Date(FMS), Issue Date(JOO) : CSR Date => Cre Date.
					customSlipApprovalDetailVO.setAttrCtnt11(searchApSlipDetailListVO.get(i).getCreDt());
					//NYK GAP AP_INV_DTRB.ATTR_CTNT3 : Requested By(FMS), Issue Team(JOO)
					//TODO Request By ?? FMS_CONSULTATION.SLP_OFC_CD? FMS_CSUL_SLP.SLP_LOC_CD
					customSlipApprovalDetailVO.setAttrCtnt12(searchApSlipDetailListVO.get(i).getSlpOfcCd());
					
					if(!StringUtils.isEmpty(searchApSlipDetailListVO.get(i).getVslSlanCd())){
						//NYK GAP 2014.10.10 AP_INV_DTRB.ATTR_CTNT14 : 아래 테이블 VVD연결하여 존재하는 경우만 추출하여 Interface : Detail 조회시 데이타를 같이 조회함.
						customSlipApprovalDetailVO.setAttrCtnt14(searchApSlipDetailListVO.get(i).getVslSlanCd());
					}else{
						if(StringUtils.isEmpty(strTmpSlanCd)){
							customSlipApprovalDetailVO.setAttrCtnt14(FmsConstants.DEFAULT_VSL_SLAN_CD); // "COM" 셋팅.
						}else{
							customSlipApprovalDetailVO.setAttrCtnt14(strTmpSlanCd); // "COM" 셋팅.
						}
					}
					
					//customSlipApprovalDetailVO.setAttrCtnt2("20"+searchApSlipDetailListVO.get(i).getSlpIssDt());
					//customSlipApprovalDetailVO.setAttrCtnt3(searchApSlipDetailListVO.get(i).getSlpLocCd());
					
					customSlipApprovalDetailVO.setActVvdCd(searchApSlipDetailListVO.get(i).getVslCd()+ 
							searchApSlipDetailListVO.get(i).getSkdVoyNo()+
							searchApSlipDetailListVO.get(i).getSkdDirCd()+
							searchApSlipDetailListVO.get(i).getRevDirCd());
					customSlipApprovalDetailVO.setPlnSctrDivCd("O"); 
					customSlipApprovalDetailVO.setCreUsrId(searchApSlipDetailListVO.get(i).getCsrUsrId());

					insertVoList.add(customSlipApprovalDetailVO);
				}
				
				//Generating AP Header(AP_INV_HDR) 
				dbDao.addApSlipApprovalHeader(customSlipApprovalHeaderVO);
				
				//Generating AP Detail(AP_INV_DTRB) 
				if (insertVoList.size() > 0) {
					dbDao.addApSlipApprovalDetails(insertVoList);
				}
				
				//Updating Apro_flg = 'Y' of the slip
				dbDao.modifySlipApprovalConsultation (csrNo ,usrId );
				
				//Retrieving InterfaceList of AP Invoice
				//List<SearchApSlipInterfaceListVO> searchApSlipInterfaceListVO = dbDao.searchApSlipInterfaceList(csrNo);
				
				//Send AP Invoice
				//eaiDao.sendSlipApprovalToAP(csrNo, searchApSlipInterfaceListVO);

				//Insert AP Interface(AP_INV_IF) 
				//dbDao.addApSlipApprovalInterfaces(searchApSlipInterfaceListVO);
			}	
			
			log.debug("\n ============================================================"
					+ "\n manageApSlipApproval E n d."
					+ "\n ============================================================");
	
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
	 * Retrieving Bond calculation amount Detail History about written Bond<br>
	 * 
	 * @param condSearchSubletRevenueVO CondSearchSubletRevenueVO
	 * @return List<SearchSubletRevenueListVO>
	 * @exception EventException
	 */
	public List<SearchSubletRevenueListVO> searchSubletReveuneList(CondSearchSubletRevenueVO condSearchSubletRevenueVO) throws EventException {
		try {
			condSearchSubletRevenueVO.setDebitAcctCd(FmsConstants.KEY_ACCT_CD_DEBIT);//2015.11.10 Add
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
	 * Retrieving conditional Slip Inquiry Master information of written slip<br>
	 * 
	 * @param condSearchSlipApprovalVO CondSearchSlipApprovalVO
	 * @return List<SearchSlipApprovalListVO>
	 * @exception EventException
	 */
	public List<SearchSlipApprovalListVO> searchSlipApprovalList(CondSearchSlipApprovalVO condSearchSlipApprovalVO) throws EventException {
		try {
			return dbDao.searchSlipApprovalList(condSearchSlipApprovalVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS01417",new String[]{}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01417",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Retrieving Bond calculation amount Detail History about written Bond<br>
	 * 
	 * @param toInvNo String
	 * @param csrNo String
	 * @return List<SearchSubletReveuneDetailListVO>
	 * @exception EventException
	 */
	public List<SearchSubletReveuneDetailListVO> searchSubletReveuneDetailList(String toInvNo, String csrNo) throws EventException {
		try {
			return dbDao.searchSubletReveuneDetailList(toInvNo, csrNo);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS01424",new String[]{}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01424",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Retrieving conditional Slip Correction - Master information of written slip <br>
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
	 * Modifying Description of Slip Master at Slip Correction <br>
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
	 * Retrieving created Bond to create import bond subtraction part<br>
	 * 
	 * @param condReverseCsrForSubletVO CondReverseCsrForSubletVO
	 * @return List<SearchReverseCsrForSubletVOList>
	 * @exception EventException
	 */
	public List<SearchReverseCsrForSubletListVO> searchReverseCsrForSubletList(CondReverseCsrForSubletVO condReverseCsrForSubletVO) throws EventException {
		try {
			condReverseCsrForSubletVO.setEffDt(condReverseCsrForSubletVO.getEffDt().replaceAll("-", ""));
			condReverseCsrForSubletVO.setDebitAcctCd(FmsConstants.KEY_ACCT_CD_DEBIT);//2015.11.10 Add
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
	 * Retrieving created Bond to create import bond subtraction part<br>
	 * 
	 * @param customConsultationVO CustomConsultationVO
	 * @param customCsulSlpVOs CustomCsulSlpVO[]
	 * @param usrid String
	 * @return String
	 * @exception EventException
	 */
	public String manageReverseCsrForSublet(CustomConsultationVO customConsultationVO, CustomCsulSlpVO[] customCsulSlpVOs, String usrId) throws EventException{
		try {
			
			
			String slpSerNo = dbDao.searchCsulSlpSeq(customConsultationVO.getSlpTpCd(), customConsultationVO.getSlpFuncCd(), customConsultationVO.getSlpOfcCd());
			//FMS_CSUL_SLP_SEQ Add/Modify.
			this.manageCsulSlpSeq(customConsultationVO.getSlpTpCd(), customConsultationVO.getSlpFuncCd(), customConsultationVO.getSlpOfcCd(), slpSerNo, usrId);
			/*			
			if (slpSerNo.equals("00001")) {
				dbDao.addCsulSlpSeq (customConsultationVO.getSlpTpCd(), customConsultationVO.getSlpFuncCd(), customConsultationVO.getSlpOfcCd(), slpSerNo, usrId);
			} else {
				dbDao.modifyCsulSlpSeq (customConsultationVO.getSlpTpCd(), customConsultationVO.getSlpFuncCd(), customConsultationVO.getSlpOfcCd(), slpSerNo, usrId);
			}
			 */

			customConsultationVO.setSlpSerNo(slpSerNo);
			customConsultationVO.setEffDt(customConsultationVO.getEffDt().replaceAll("-", ""));
			customConsultationVO.setSlpIssDt(BizComFmsUtil.getFormatSlpIssueDate(customConsultationVO.getSlpIssDt().replaceAll("-", "")));
			customConsultationVO.setRqstAmt(customConsultationVO.getRqstAmt().replaceAll(",", ""));
			customConsultationVO.setCsrAmt(customConsultationVO.getCsrAmt().replaceAll(",", ""));
			customConsultationVO.setCsrUsrId(usrId);
			customConsultationVO.setUpdUsrId(usrId);
			customConsultationVO.setCreUsrId(usrId);
			customConsultationVO.setEvidTpCd(FmsConstants.KEY_EVIDENCE_CLASS_F0);
			dbDao.addMasterReverseCsrForSublet(customConsultationVO);
			
			List<CustomCsulSlpVO> addCsulSlpListByDebit = new ArrayList<CustomCsulSlpVO>();
			List<CustomCsulSlpVO> addCsulSlpListByCredit = new ArrayList<CustomCsulSlpVO>();
			
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
					customCsulSlpVOs[i].setSlpIssDt(BizComFmsUtil.getFormatSlpIssueDate(customConsultationVO.getSlpIssDt().replaceAll("-", "")));
					customCsulSlpVOs[i].setVvdEffDt(customCsulSlpVOs[i].getVvdEffDt().replaceAll("-", ""));
					customCsulSlpVOs[i].setVvdExpDt(customCsulSlpVOs[i].getVvdExpDt().replaceAll("-", ""));
					customCsulSlpVOs[i].setTrnsCurrCd(customCsulSlpVOs[i].getCsrCurrCd());
					customCsulSlpVOs[i].setTrnsAmt(customCsulSlpVOs[i].getCsrAmt());
					customCsulSlpVOs[i].setFletSrcTpCd(FmsConstants.KEY_FLET_SRC_TP_CD_R1);
					customCsulSlpVOs[i].setUpdUsrId(usrId);
					customCsulSlpVOs[i].setCreUsrId(usrId);
					addCsulSlpListByDebit.add(customCsulSlpVOs[i]);
				}
			}
			
			if ( addCsulSlpListByDebit.size() > 0 ) {
				dbDao.addReverseCsrForSubletSlips(addCsulSlpListByDebit);
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
					customCsulSlpVOs[i].setSlpIssDt(BizComFmsUtil.getFormatSlpIssueDate(customConsultationVO.getSlpIssDt().replaceAll("-", "")));
					customCsulSlpVOs[i].setVvdEffDt(customCsulSlpVOs[i].getVvdEffDt().replaceAll("-", ""));
					customCsulSlpVOs[i].setVvdExpDt(customCsulSlpVOs[i].getVvdExpDt().replaceAll("-", ""));
					customCsulSlpVOs[i].setTrnsCurrCd(customCsulSlpVOs[i].getCsrCurrCd());
					customCsulSlpVOs[i].setTrnsAmt(customCsulSlpVOs[i].getCsrAmt());
					//2015.11.10 Reverse Account를 무조건 Hire Revenue Account 로 가야 하는지??? Hire Revenue Account로 Setting.
					customCsulSlpVOs[i].setAcctCd(FmsConstants.KEY_ACCT_CD_BY_HIRE_REVENUE);
					customCsulSlpVOs[i].setFletSrcTpCd(FmsConstants.KEY_FLET_SRC_TP_CD_R6);
					customCsulSlpVOs[i].setUpdUsrId(usrId);
					customCsulSlpVOs[i].setCreUsrId(usrId);
					addCsulSlpListByCredit.add(customCsulSlpVOs[i]);
				}
			}

			if ( addCsulSlpListByCredit.size() > 0 ) {
				dbDao.addReverseCsrForSubletSlips(addCsulSlpListByCredit);
			}

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
	 * Retrieving created Bond to create import bond subtraction part by Invoice condition <br>
	 * 
	 * @param customCsulSlpSeqVO CustomCsulSlpSeqVO
	 * @return List<SearchReverseCsrForSubletSaveListVO>
	 * @exception EventException
	 */
	public List<SearchReverseCsrForSubletSaveListVO> searchReverseCsrForSubletSaveList(CustomCsulSlpSeqVO customCsulSlpSeqVO) throws EventException {
		try {
			//customCsulSlpSeqVO.setSlpIssDt(customCsulSlpSeqVO.getSlpIssDt().replaceAll("-", ""));
			customCsulSlpSeqVO.setDebitAcctCd(FmsConstants.KEY_ACCT_CD_DEBIT); //2015.11.10 Add
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
	 * Generating Sublet Revenue slip<br>
	 * 
	 * @param customConsultationVO CustomConsultationVO
	 * @param customCsulSlpVOs CustomCsulSlpVO[]
	 * @param usrid String
	 * @return String
	 * @exception EventException
	 */
	public String manageSubletRevenueSlip(CustomConsultationVO customConsultationVO, CustomCsulSlpVO[] customCsulSlpVOs, String usrId) throws EventException{
		try {
			
			String slpSerNo = dbDao.searchCsulSlpSeq(customConsultationVO.getSlpTpCd(), customConsultationVO.getSlpFuncCd(), customConsultationVO.getSlpOfcCd());
			
			//FMS_CSUL_SLP_SEQ Add/Modify.
			this.manageCsulSlpSeq(customConsultationVO.getSlpTpCd(), customConsultationVO.getSlpFuncCd(), customConsultationVO.getSlpOfcCd(), slpSerNo, usrId);
			/*
			if (slpSerNo.equals("00001")) {
				dbDao.addCsulSlpSeq (customConsultationVO.getSlpTpCd(), customConsultationVO.getSlpFuncCd(), customConsultationVO.getSlpOfcCd(), slpSerNo, usrId);
			} else {
				dbDao.modifyCsulSlpSeq (customConsultationVO.getSlpTpCd(), customConsultationVO.getSlpFuncCd(), customConsultationVO.getSlpOfcCd(), slpSerNo, usrId);
			}
			 */
			
			customConsultationVO.setSlpSerNo(slpSerNo);
			customConsultationVO.setEffDt(customConsultationVO.getEffDt().replaceAll("-", ""));
			customConsultationVO.setSlpIssDt(BizComFmsUtil.getFormatSlpIssueDate(customConsultationVO.getSlpIssDt().replaceAll("-", "")));
			customConsultationVO.setCsrUsrId(usrId);
			customConsultationVO.setUpdUsrId(usrId);
			customConsultationVO.setCreUsrId(usrId);
			customConsultationVO.setEvidTpCd(FmsConstants.KEY_EVIDENCE_CLASS_F0);

			dbDao.addMasterSubletRevenueSlip(customConsultationVO);
			
			List<CustomCsulSlpVO> addCsulSlpList = new ArrayList<CustomCsulSlpVO>();

			for ( int i=0; i<customCsulSlpVOs .length; i++ ) {
				if ( customCsulSlpVOs[i].getIbflag().equals("I")){
					customCsulSlpVOs[i].setSlpSerNo(slpSerNo);
					customCsulSlpVOs[i].setSlpIssDt(BizComFmsUtil.getFormatSlpIssueDate(customCsulSlpVOs[i].getSlpIssDt().replaceAll("-", "")));
					customCsulSlpVOs[i].setVvdEffDt(customCsulSlpVOs[i].getVvdEffDt().replaceAll("-", ""));
					customCsulSlpVOs[i].setVvdExpDt(customCsulSlpVOs[i].getVvdExpDt().replaceAll("-", ""));
					if(customCsulSlpVOs[i].getAcctCd().equals(FmsConstants.KEY_ACCT_CD_DEBIT)) {//2015.11.10 Modify 차변계정
						customCsulSlpVOs[i].setFletSrcTpCd(FmsConstants.KEY_FLET_SRC_TP_CD_R1);
					} else if(   customCsulSlpVOs[i].getAcctCd().equals(FmsConstants.KEY_ACCT_CD_BY_HIRE_REVENUE)
							  || customCsulSlpVOs[i].getAcctCd().equals(FmsConstants.KEY_ACCT_CD_BY_BUNKER)) { //2015.11.10 Modify Hire Revenue/Bunker Account
						customCsulSlpVOs[i].setFletSrcTpCd(FmsConstants.KEY_FLET_SRC_TP_CD_R6);
					}
					customCsulSlpVOs[i].setUpdUsrId(usrId);
					customCsulSlpVOs[i].setCreUsrId(usrId);
					addCsulSlpList.add(customCsulSlpVOs[i]);
				}
			}

			if ( addCsulSlpList.size() > 0 ) {
				dbDao.addSubletRevenueSlips(addCsulSlpList);
			}

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
	 * Insert/Modify related costs have to be handled by work-site operation regardless of Agreement Creation aside from Charter/Hire Out costs<br>
	 * 
	 * @param customConsultationVO CustomConsultationVO
	 * @param customCsulSlpVOs CustomCsulSlpVO[]
	 * @param customTaxVOs CustomTaxVO[]
	 * @param customTaxDtlVOs CustomTaxDtlVO[]
	 * @param usrId String
	 * @return String
	 * @exception EventException
	 */
	public String manageManualSlip(CustomConsultationVO customConsultationVO, CustomCsulSlpVO[] customCsulSlpVOs, CustomTaxVO[] customTaxVOs, CustomTaxDtlVO[] customTaxDtlVOs, String usrId) throws EventException{
		
		try {
			
			String slpSerNo = dbDao.searchCsulSlpSeq(customConsultationVO.getSlpTpCd(), customConsultationVO.getSlpFuncCd(), customConsultationVO.getSlpOfcCd());

			customConsultationVO.setSlpSerNo(slpSerNo);
			customConsultationVO.setEffDt(customConsultationVO.getEffDt().replaceAll("-", ""));
			customConsultationVO.setRqstDt(customConsultationVO.getRqstDt().replaceAll("-", ""));
			customConsultationVO.setSlpIssDt(BizComFmsUtil.getFormatSlpIssueDate(customConsultationVO.getSlpIssDt().replaceAll("-", "")));
			customConsultationVO.setCsrAmt(customConsultationVO.getCsrAmt().replaceAll(",", ""));
			customConsultationVO.setRqstAmt(customConsultationVO.getRqstAmt().replaceAll(",", ""));
			customConsultationVO.setCsrUsrId(usrId);
			customConsultationVO.setUpdUsrId(usrId);
			customConsultationVO.setCreUsrId(usrId);
			
			//FMS_CSUL_SLP_SEQ Add/Modify.
			this.manageCsulSlpSeq(customConsultationVO.getSlpTpCd(), customConsultationVO.getSlpFuncCd(), customConsultationVO.getSlpOfcCd() , slpSerNo , usrId);
			/*
			if (slpSerNo.equals("00001")) {
				dbDao.addCsulSlpSeq(customConsultationVO.getSlpTpCd(), customConsultationVO.getSlpFuncCd(), customConsultationVO.getSlpOfcCd(), slpSerNo, usrId);
			} else {
				dbDao.modifyCsulSlpSeq(customConsultationVO.getSlpTpCd(), customConsultationVO.getSlpFuncCd(), customConsultationVO.getSlpOfcCd(), slpSerNo, usrId);
			}
			 */
			
			dbDao.addMasterManualSlip(customConsultationVO);

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
					customCsulSlpVOs[i].setSlpIssDt(BizComFmsUtil.getFormatSlpIssueDate(customConsultationVO.getSlpIssDt().replaceAll("-", "")));
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
				// Setting Tax Master information
				List<CustomTaxVO> addTaxVoList = new ArrayList<CustomTaxVO>();

				for (int i=0; i<customTaxVOs.length; i++ ) {
					if (customTaxVOs[i].getIbflag().equals("I")){
						customTaxVOs[i].setTaxSerNo(Integer.toString(i+1));
						customTaxVOs[i].setSlpTpCd(customConsultationVO.getSlpTpCd());
						customTaxVOs[i].setSlpFuncCd(customConsultationVO.getSlpFuncCd());
						customTaxVOs[i].setSlpOfcCd(customConsultationVO.getSlpOfcCd());
						customTaxVOs[i].setSlpIssDt(BizComFmsUtil.getFormatSlpIssueDate(customConsultationVO.getEffDt()));
						customTaxVOs[i].setSlpSerNo(slpSerNo);
						customTaxVOs[i].setCreUsrId(usrId);
						customTaxVOs[i].setUpdUsrId(usrId);
						
						addTaxVoList.add(customTaxVOs[i]);
					}
				}
				
				// Insert Tax Master / Bill Master information
				if (addTaxVoList.size() > 0) {
					if(customConsultationVO.getEvidTpCd().equals("1")) {
						//Tax Invoice
						dbDao.addPaymentTaxMasters(addTaxVoList);
					} else {
						//Invoice
						dbDao.addPaymentBillMasters(addTaxVoList);
					}
				}
				
				// Setting Tax Detail / Bill Detail information
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
				
				// inserting Tax Detail / Bil Detail 
				if (addTaxDtlVoList.size() > 0) {
					if(customConsultationVO.getEvidTpCd().equals("1")) {
						//Tax Invoice
						dbDao.addPaymentTaxDtls(addTaxDtlVoList);
					} else {
						//Invoice
						dbDao.addPaymentBilDtls(addTaxDtlVoList);
					}
				}
			}
			// -------------------------------------------------------------------

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
	 * Retrieving created Brokerage to handle it in Manual Slip<br>
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
	 * Retrieving Financial Voyage in Manual Slip<br>
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
	 * Retrieving approved slip number<br>
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
	 * Retrieving conditional Slip Inquiry Detail information of written slip<br>
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
	 * Modifying Description of Slip Detail at Slip Correction<br>
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
	 * Retrieving conditional Slip Correction - Detail information of written slip<br>
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
	 * Creating slip by using Prepayment, Vessel Operation Stoppage Cost, Charterer Cost, Owner's Account<br>
	 * 
	 * @param customPamConsultationVOs CustomPamConsultationVO[]
	 * @param customPamCsulSlpVOs CustomPamCsulSlpVO[]
	 * @param customTaxVOs CustomTaxVO[]
	 * @param customTaxDtlVOs CustomTaxDtlVO[]
	 * @return String
	 * @exception EventException
	 */
	public String managePaymentSlip(CustomPamConsultationVO[] customPamConsultationVOs, CustomPamCsulSlpVO[] customPamCsulSlpVOs, CustomTaxVO[] customTaxVOs, CustomTaxDtlVO[] customTaxDtlVOs) throws EventException {
		try {
			
			// 1 slip number 
			String csrNo = "";
			
			// Slp Desc(for 2 slip / 3 slip)
			String slpDesc = "";
			
			//  original SLP number1
			String orgSlpSerNo1 = "";
			
			// 1 slip's SEQ
			int slpSeqNo1 = FmsConstants.DEFAULT_SLP_SEQ_NO;//1
			
			// original SLP number2
			String orgSlpSerNo2 = "";
			
			// 2 slip's SEQ
			int slpSeqNo2 = FmsConstants.DEFAULT_SLP_SEQ_NO;//1
			
			// original SLP number3
			String orgSlpSerNo3 = "";
			
			// 3 slip's SEQ
			int slpSeqNo3 = FmsConstants.DEFAULT_SLP_SEQ_NO; //1
			
			// Original slip 
			String vatSlpSerNo = "";
			
			// saving Slip Generated number
			String slpSerNo = "";
			
			for (int i=0; i<customPamConsultationVOs.length; i++ ) {
				slpSerNo = dbDao.searchCsulSlpSeq(FmsConstants.KEY_SLP_TP_CD_AP_07, customPamConsultationVOs[i].getSlpTp(), customPamConsultationVOs[i].getSlpOfcCd());
				//slpSerNo = dbDao.searchCsulSlpSeq("07", customPamConsultationVOs[i].getSlpTp(), customPamConsultationVOs[i].getSlpOfcCd());
				
				customPamConsultationVOs[i].setCsrNo(slpSerNo);
				
				
				/*if(FmsConstants.KEY_EVIDENCE_CLASS_E3.equals(customPamConsultationVOs[i].getVatFlg())){
					vatSlpSerNo = slpSerNo;
					orgSlpSerNo1 = slpSerNo;
				}else{
					orgSlpSerNo3 = slpSerNo;
				}*/
				
				if("1".equals(customPamConsultationVOs[i].getVatFlg())) {
					vatSlpSerNo = slpSerNo;
					orgSlpSerNo1 = slpSerNo;

				} else if("2".equals(customPamConsultationVOs[i].getVatFlg())) {
					orgSlpSerNo2 = slpSerNo;

				} else {
					orgSlpSerNo3 = slpSerNo;
				}
				
				//FMS_CSUL_SLP_SEQ Add/Modify.
				this.manageCsulSlpSeq(FmsConstants.KEY_SLP_TP_CD_AP_07, customPamConsultationVOs[i].getSlpTp(), customPamConsultationVOs[i].getSlpOfcCd() , slpSerNo , customPamConsultationVOs[i].getCreUsrId() );
				/*
				if (slpSerNo.equals("0001")) {//0001
					dbDao.addCsulSlpSeq ( "07", customPamConsultationVOs[i].getSlpTp(), customPamConsultationVOs[i].getSlpOfcCd() , slpSerNo , customPamConsultationVOs[i].getCreUsrId() );
				} else {
					dbDao.modifyCsulSlpSeq ( "07", customPamConsultationVOs[i].getSlpTp(), customPamConsultationVOs[i].getSlpOfcCd() , slpSerNo , customPamConsultationVOs[i].getCreUsrId() );
				}
				*/
			}
			
			//csrNo = "07"+customPamConsultationVOs[0].getSlpTp()+customPamConsultationVOs[0].getSlpOfcCd()+customPamConsultationVOs[0].getSlpIssDt().substring(2)+vatSlpSerNo;
			csrNo = FmsConstants.KEY_SLP_TP_CD_AP_07+customPamConsultationVOs[0].getSlpTp()+customPamConsultationVOs[0].getSlpOfcCd()+BizComFmsUtil.getFormatSlpIssueDate(customPamConsultationVOs[0].getSlpIssDt())+vatSlpSerNo;
			
			// setting Consultation Master information
			List<CustomPamConsultationVO> addConsultationVoList = new ArrayList<CustomPamConsultationVO>();

			for (int i=0; i<customPamConsultationVOs.length; i++ ) {
				if (customPamConsultationVOs[i].getIbflag().equals("I")){
					
					if("1".equals(customPamConsultationVOs[i].getVatFlg()) ) {
						customPamConsultationVOs[i].setVatSlpTpCd("");
						customPamConsultationVOs[i].setVatSlpFuncCd("");
						customPamConsultationVOs[i].setVatSlpOfcCd("");
						customPamConsultationVOs[i].setVatSlpIssDt("");
						customPamConsultationVOs[i].setVatSlpSerNo("");

					} else {
						customPamConsultationVOs[i].setVatSlpTpCd(FmsConstants.KEY_SLP_TP_CD_AP_07);
						customPamConsultationVOs[i].setVatSlpFuncCd(customPamConsultationVOs[0].getSlpTp());
						customPamConsultationVOs[i].setVatSlpOfcCd(customPamConsultationVOs[0].getSlpOfcCd());
						customPamConsultationVOs[i].setVatSlpIssDt(BizComFmsUtil.getFormatSlpIssueDate(customPamConsultationVOs[0].getEffDt()));
						//customPamConsultationVOs[i].setVatSlpIssDt(customPamConsultationVOs[0].getEffDt());
						customPamConsultationVOs[i].setVatSlpSerNo(vatSlpSerNo);
						
						// re-setting slpDesc about 2 slip / 3 slip(previous slpDesc + 1 slip no)
						slpDesc = customPamConsultationVOs[i].getSlpDesc();
						customPamConsultationVOs[i].setSlpDesc(slpDesc + " " + csrNo);
					}
					
					// Setting publication division value into CustomPamConsultationVO to insert into Consultation table
					if(null != customTaxVOs) {
						customPamConsultationVOs[i].setTaxIssCd(customTaxVOs[0].getTaxIssCd());
						if(!((customTaxVOs[0].getTaxPlCd().equals("1")) && (i == 1))){
							addConsultationVoList.add(customPamConsultationVOs[i]);
						}
					}else{
						addConsultationVoList.add(customPamConsultationVOs[i]);
					}
				}
			}

			if (addConsultationVoList.size() > 0) {
				dbDao.addPaymentSlipMasters(addConsultationVoList);
			} 
			
			//  setting Consultation Detail 
			List<CustomPamCsulSlpVO> addCsulSlpVoList = new ArrayList<CustomPamCsulSlpVO>();
			if(null != customPamCsulSlpVOs){
				for (int i=0; i<customPamCsulSlpVOs.length; i++ ) {
					if (customPamCsulSlpVOs[i].getIbflag().equals("I")){
						
						// 2 slip
						if("2".equals(customPamCsulSlpVOs[i].getVatFlg())) {
							
							customPamCsulSlpVOs[i].setSeqNo(Integer.toString(slpSeqNo1++));
							customPamCsulSlpVOs[i].setSlpFuncCd("S");
							customPamCsulSlpVOs[i].setSlpSerNo(orgSlpSerNo2);
							customPamCsulSlpVOs[i].setCurrCd(customPamConsultationVOs[0].getCsrCurrCd());
						
						// 3 slip
						} else if("3".equals(customPamCsulSlpVOs[i].getVatFlg())) {
							
							customPamCsulSlpVOs[i].setSeqNo(Integer.toString(slpSeqNo2++));
							customPamCsulSlpVOs[i].setSlpFuncCd("S");
							customPamCsulSlpVOs[i].setSlpSerNo(orgSlpSerNo3);
							customPamCsulSlpVOs[i].setCurrCd("KRW");
						
						// 1 slip
						} else {
							customPamCsulSlpVOs[i].setSeqNo(Integer.toString(slpSeqNo3++));
							
							customPamCsulSlpVOs[i].setSlpSerNo(orgSlpSerNo1);
							
							// Handling in case Currency of Master information is KRW and Tax proof
							if(	  customPamConsultationVOs[0].getCsrCurrCd().equals("KRW") && customPamCsulSlpVOs[i].getFletSrcTpCd().equals("20")) {
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
						
						
						if(null != customTaxVOs) {
							if( ! ( ( customTaxVOs[0].getTaxPlCd().equals("1") ) && ( i == 2 ) ) && ! ( ( customTaxVOs[0].getTaxPlCd().equals("1") ) && ( i == 3 ) ) &&  ! ( ( customTaxVOs[0].getTaxPlCd().equals("1") ) && ( i == 5 ) ) && ! ( ( customTaxVOs[0].getTaxPlCd().equals("1") ) && ( i == 6 ) )){
								
								if( !( ( ( customTaxVOs[0].getTaxPlCd().equals("1") ) && ( i == 1 ) ) &&  ( customPamCsulSlpVOs[i].getSeqNo().equals("2") ) )){
									addCsulSlpVoList.add(customPamCsulSlpVOs[i]);
								}
							}
						}else{
							addCsulSlpVoList.add(customPamCsulSlpVOs[i]);
						}
						
					}
				}
			}

			if (addCsulSlpVoList.size() > 0) {
				dbDao.addPaymentSlipDetails(addCsulSlpVoList);
			}
			
			if(null != customTaxVOs) {
				
				// Setting Tax Master information
				List<CustomTaxVO> addTaxVoList = new ArrayList<CustomTaxVO>();
				
				for (int i=0; i<customTaxVOs.length; i++ ) {
					if (customTaxVOs[i].getIbflag().equals("I")){
						customTaxVOs[i].setTaxSerNo(Integer.toString(i+1));
						customTaxVOs[i].setSlpTpCd(FmsConstants.KEY_SLP_TP_CD_AP_07);
						customTaxVOs[i].setSlpFuncCd(customPamConsultationVOs[0].getSlpTp());
						customTaxVOs[i].setSlpOfcCd(customPamConsultationVOs[0].getSlpOfcCd());
						customTaxVOs[i].setSlpIssDt(BizComFmsUtil.getFormatSlpIssueDate(customPamConsultationVOs[0].getEffDt()));
						//customTaxVOs[i].setSlpIssDt(getFormatSlpIssDt(customPamConsultationVOs[0].getEffDt()));
						customTaxVOs[i].setSlpSerNo(vatSlpSerNo);
						customTaxVOs[i].setCreUsrId(customPamConsultationVOs[0].getCreUsrId());
						customTaxVOs[i].setUpdUsrId(customPamConsultationVOs[0].getUpdUsrId());
						
						addTaxVoList.add(customTaxVOs[i]);
					}
				}
				
				// Insert Tax Master / Bill Master information
				if (addTaxVoList.size() > 0) {
					if(FmsConstants.KEY_EVIDENCE_CLASS_E3.equals(customPamConsultationVOs[0].getEvidTpCd())) { // "1"
						//Tax Invoice
						dbDao.addPaymentTaxMasters(addTaxVoList);
					} else {
						//Invoice
						dbDao.addPaymentBillMasters(addTaxVoList);
					}
				}
				
				// Setting Tax Detail / Bill Detail information
				List<CustomTaxDtlVO> addTaxDtlVoList = new ArrayList<CustomTaxDtlVO>();
	
				for (int i=0; i<customTaxDtlVOs.length; i++ ) {
					if (customTaxDtlVOs[i].getIbflag().equals("I")){
						customTaxDtlVOs[i].setTaxInvYrmon(customTaxVOs[0].getTaxInvYrmon());
						customTaxDtlVOs[i].setOfcCd(customTaxVOs[0].getOfcCd());
						customTaxDtlVOs[i].setTaxSerNo(FmsConstants.DEFAULT_SEQ_NO_00001);
						customTaxDtlVOs[i].setTaxDtlSerNo(Integer.toString(i+1));
						customTaxDtlVOs[i].setCreUsrId(customPamConsultationVOs[0].getCreUsrId());
						customTaxDtlVOs[i].setUpdUsrId(customPamConsultationVOs[0].getUpdUsrId());
	
						addTaxDtlVoList.add(customTaxDtlVOs[i]);
					}
				}
				
				// Insert Tax Detail / Bil Detail information
				if (addTaxDtlVoList.size() > 0) {
					if(FmsConstants.KEY_EVIDENCE_CLASS_E3.equals(customPamConsultationVOs[0].getEvidTpCd())) {//"1"
						//Tax Invoice
						dbDao.addPaymentTaxDtls(addTaxDtlVoList);
					} else {
						//Invoice
						dbDao.addPaymentBilDtls(addTaxDtlVoList);
					}
				}
			}
			
			return vatSlpSerNo;
			

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS01401",new String[]{}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01401",new String[]{}).getMessage(), ex);
		}
	}
	
	private OutstandingInterfaceVO setSarOtsIf(CustomArSlipApprovalHeaderVO headerVO, CustomArSlipApprovalDetailVO detailVO) throws EventException{
		try {
			
			OutstandingInterfaceVO outVo = new OutstandingInterfaceVO();
			
			outVo.setIfNo             (headerVO.getArIfNo() + headerVO.getArIfSerNo());
			outVo.setRhqCd            (headerVO.getRhqCd());
			outVo.setArOfcCd          (headerVO.getArOfcCd());
			outVo.setBlNo             (headerVO.getBlNo());
			outVo.setInvNo            (headerVO.getInvNo());
			//[2015.03.24] Modify AS-IS: JOO_CSR.CSR_LOCL_CURR_CD TO-BE:MDM_ORGANIZATION.AR_CURR_CD
			outVo.setOfcCurrCd        (headerVO.getArCurrCd());
			//outVo.setOfcCurrCd        (headerVO.getCurrCd());
			outVo.setOtsSrcCd         (FmsConstants.DEFAULT_AR_OTS_SRC_CD); //"FMS"
			outVo.setLaneCd           (FmsConstants.DEFAULT_AR_MODULE_KEY); //"CDM"
			outVo.setBilToCustCntCd   (headerVO.getActCustCntCd());
			outVo.setBilToCustSeq     (headerVO.getActCustSeq());
			outVo.setShpToCustCntCd   (headerVO.getInvCustCntCd());
			outVo.setShpToCustSeq     (headerVO.getInvCustSeq());
			outVo.setBkgNo            ("");
			outVo.setBkgNoSplit       ("");
			outVo.setVslCd            (headerVO.getVslCd());
			outVo.setSkdVoyNo         (headerVO.getSkdVoyNo());
			outVo.setDirCd            (headerVO.getSkdDirCd());
			outVo.setTrnkVvdCd        (headerVO.getTrnkVslCd() + headerVO.getTrnkSkdVoyNo() + headerVO.getTrnkSkdDirCd());
			outVo.setSvcScpCd         ("OTH");//2016.02.23 Add
			//outVo.setLaneCd           (arMnChgVO.getRlaneCd());
			outVo.setSailArrDt        (headerVO.getSailArrDt());
			outVo.setBkgIoBndCd       (headerVO.getIoBndCd());
			outVo.setPorCd            (headerVO.getPorCd());
			outVo.setPolCd            (headerVO.getPolCd());
			outVo.setPodCd            (headerVO.getPodCd());
			outVo.setDelCd            (headerVO.getDelCd());
			outVo.setCustSrepCd       ("");
			outVo.setDueDt            (headerVO.getDueDt());
			outVo.setStlFlg           ("");
			outVo.setBkgRefNo         ("");
			//[2015.03.24] Modify AS-IS : JOO_CSR.CSR_OFFST_NO TO-BE: JOO_SLIP.SLP_TP_CD||B.SLP_FUNC_CD||B.SLP_OFC_CD||B.SLP_ISS_DT||B.SLP_SER_NO : CSR_NO
			outVo.setApArOffstNo      (headerVO.getSlpNo());
			//outVo.setApArOffstNo      (headerVO.getCsrOffstNo());
			outVo.setCrMkFlg          ("");
			outVo.setXchRtTpCd        (headerVO.getXchRtTpCd());
			outVo.setLstInvNo         ("");
			outVo.setOtsGrpTpCd       ("");
			outVo.setOtsTpCd          ("");
			outVo.setOtsRmk           (headerVO.getInvRmk());
			outVo.setIfDt             ("");
			outVo.setInvDt            ("");
			outVo.setCltOfcCd         (headerVO.getArOfcCd());
			outVo.setOtsRtFlg         ("Y");
			outVo.setScNo             ("");
			outVo.setCreUsrId         (headerVO.getUsrId());
			//outVo.setCreDt            (db sysdate)
			outVo.setUpdUsrId         (headerVO.getUsrId());
			//outVo.setUpdDt            (db sysdate)
			outVo.setTjSrcNm          (FmsConstants.DEFAULT_AR_TJ_SRC_NM); //"SALAR"
			outVo.setChgTpCd          (detailVO.getJoRevTpCd());
			outVo.setGlDt             (headerVO.getGlDt());
			outVo.setBlCurrCd         (headerVO.getCurrCd());
			outVo.setOtsAmt           (detailVO.getChgAmt());
			outVo.setOtsIfFlg         ("");
			outVo.setRevTpSrcCd       (FmsConstants.DEFAULT_AR_REV_TP_SRC_CD); //"CDM"
			outVo.setXchRtN3rdTpCd    ("");
			
			return outVo;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"VO Transfer", "SET"}).getMessage(), ex);
		}
	}

	/**
	 * manageCsulSlpSeq Dao.
	 * @param slpTpCd
	 * @param slpFuncCd
	 * @param slpOfcCd
	 * @param slpSerNo
	 * @param usrId
	 * @throws EventException
	 */
	public void manageCsulSlpSeq( String slpTpCd , String slpFuncCd, String slpOfcCd, String slpSerNo, String usrId ) throws EventException {
		try {
			if (FmsConstants.DEFAULT_SEQ_NO_0001.equals(slpSerNo)) {//00001 4자리로 변경.
				dbDao.addCsulSlpSeq ( slpTpCd, slpFuncCd, slpOfcCd , slpSerNo , usrId );
			} else {
				dbDao.modifyCsulSlpSeq ( slpTpCd, slpFuncCd, slpOfcCd , slpSerNo , usrId );
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01500",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01500",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Retrieving conditional Slip Inquiry information of written slip<br>
	 * 
	 * @param condSearchSlipApprovalVO CondSearchSlipApprovalVO
	 * @return List<SearchSlipApprovalListVO>
	 * @exception EventException
	 */
	public List<SearchSlipApprovalListVO> searchConsultationSlipList(CondSearchSlipApprovalVO condSearchSlipApprovalVO) throws EventException {
		try {
			return dbDao.searchConsultationSlipList(condSearchSlipApprovalVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS01417",new String[]{}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01417",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * CSR No. 에 해당하는 Consultation Master 데이타 조회<br>
	 * 
	 * @param csrNo String
	 * @return SearchPaymentSlipMasterVO
	 * @exception EventException
	 */
	public SearchPaymentSlipMasterVO searchPaymentSlipMaster(String csrNo) throws EventException {
		try {
			return dbDao.searchPaymentSlipMaster(csrNo);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS01461",new String[]{}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01461",new String[]{}).getMessage(), ex);
		}
	}
	
}