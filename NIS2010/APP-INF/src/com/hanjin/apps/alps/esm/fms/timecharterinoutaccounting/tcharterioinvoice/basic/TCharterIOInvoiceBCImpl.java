/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TCharterIOInvoiceBCImpl.java
*@FileTitle : Charterer's Account
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.13
*@LastModifier : 정윤태
*@LastVersion : 1.0
* 2009.04.13 정윤태
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.basic;

import java.util.ArrayList;
import java.util.List;

import org.apache.xmlbeans.XmlObject;

import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomCsulSlpVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomInterfaceStatusVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomPamConsultationVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomPamCsulSlpVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchArSlipDetailListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriocontract.integration.TCharterIOContractDBDAO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.SearchContractListByPrepaymentHireNoVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.SearchHireSysDateVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.SearchOtrExpnSysDateListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.integration.TCharterIOInvoiceDBDAO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.integration.TCharterIOInvoiceEAIDAO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CondCalOffhireInvoiceVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CondCharterInvoiceVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CondSearchCalPrepaymentInvoiceListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CondSearchManhourListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CondSearchOffhireInvoiceVmsVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CondSearchOwnerAccountVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CondSearchOwnerInvoiceAutoMatchVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CondSearchOwnerInvoiceVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CustomInvDtlVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CustomInvoiceVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CustomManHrChgVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CustomManHrListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CustomOffHireExpenseInterfaceVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CustomOffInvDtlVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CustomOffInvoiceVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CustomOffhExpnVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CustomOwnerAccountInterfaceVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CustomOwnrAcctSlpVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CustomPreInvDtlVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CustomPreInvoiceVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CustomSendEmailVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.InvoiceContainerVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchBunkerPriceInterfaceListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchCalOffhireInvoiceListSumVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchCalOffhireInvoiceListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchCalPrepaymentInvoiceListSumVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchCalPrepaymentInvoiceListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchCharterInvoiceListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchCharterInvoiceSumVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchCharterListByPaymentSlipVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchChaterInvoiceSdmsListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchInvoiceListByRevenueSlipVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchManhourItemListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchManhourItemRegistrationListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchManhourListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchOffhireExpensesListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchOffhireInvoiceListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchOffhireInvoiceVmsListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchOffhireListByPaymentSlipVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchOffhireSelectionListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchNewOwnerAccountListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchOwnerInvoiceAutoMatchListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchOwnerInvoiceListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchOwnerListByPaymentSlipVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchPrepaymentHireNoListSumVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchPrepaymentHireNoListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchPrepaymentInvoiceVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchPrepaymentListByPaymentSlipVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchVesselCodeInvoiceInterfaceVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchVvdListByCharterVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchVvdListByOffHireVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriosettlement.vo.SearchInvoiceByPaymentSlipVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.DateTime;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.irep.enisEsm.ESM0660001Document;
import com.hanjin.irep.enisEsm.ESM0660001Document.ESM0660001;
import com.hanjin.irep.erp.FNS0560001Document;
import com.hanjin.irep.erp.FNS0560001Document.FNS0560001;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.FmsVnorItmVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.FmsVnorVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.integration.TCharterIOConsultationDBDAO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomSlipApprovalDetailVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomSlipApprovalHeaderVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchApSlipDetailListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchApSlipInterfaceListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchSlipApprovalBillDetailVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchSlipApprovalBillVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchSlipApprovalOfficeVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchSlipApprovalOwnerVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchSlipApprovalTaxDetailVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchSlipApprovalTaxVO;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.FrgnExchangeTransactionVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.FrgnExchangeVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchCsrInfoVO;
import com.hanjin.bizcommon.approval.util.ApprovalUtil;
import com.hanjin.syscommon.common.table.ComAproCsrDtlVO;
import com.hanjin.syscommon.common.table.ComAproRqstHdrVO;
import com.hanjin.syscommon.common.table.ComAproRqstRoutVO;
import com.hanjin.syscommon.common.table.FmsConsultationVO;
import com.hanjin.syscommon.common.table.FmsCsulSlpVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.OwnerAccountByPaymentSlipVO;
import com.hanjin.apps.alps.esm.fms.fmscommon.fmsfileupload.vo.FileUploadListVO;

/**
 * ALPS-TimeCharterInOutAccounting Business Logic Basic Command implementation<br>
 * - ALPS-TimeCharterInOutAccounting에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Yoon-Tae, Jung
 * @see ESM_FMS_0016EventResponse,TCharterIOInvoiceBC 각 DAO 클래스 참조
 * @since J2EE 1.5 
 */

public class TCharterIOInvoiceBCImpl extends BasicCommandSupport implements TCharterIOInvoiceBC {

	// Database Access Object
	private transient TCharterIOInvoiceDBDAO  dbDao  = null;
	private transient TCharterIOInvoiceEAIDAO eaiDao = null;
	private transient TCharterIOContractDBDAO conDbDao = null;
	private transient TCharterIOConsultationDBDAO dbDao1 = null;
	
	/**
	 * TCharterIOInvoiceBCImpl 객체 생성<br>
	 * TCharterIOInvoiceDBDAO를 생성한다.<br>
	 */
	public TCharterIOInvoiceBCImpl() {
		dbDao  = new TCharterIOInvoiceDBDAO();
		eaiDao = new TCharterIOInvoiceEAIDAO();
		conDbDao = new TCharterIOContractDBDAO();
		dbDao1 = new TCharterIOConsultationDBDAO();
	}
	
	/**
	 * Charterer's Account 화면에서 데이타 조회(용선주 비용에 관련된 계정을 조회한다)<br>
	 * 
	 * @param condCharterInvoiceVO CondCharterInvoiceVO
	 * @return List<SearchCharterInvoiceListVO>
	 * @exception EventException
	 */
    public List<SearchCharterInvoiceListVO> searchCharterInvoiceList(CondCharterInvoiceVO condCharterInvoiceVO) throws EventException {
		try {
			return dbDao.searchCharterInvoiceList(condCharterInvoiceVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS01114",new String[]{}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01114",new String[]{}).getMessage(), ex);
		}
	}
    
    /**
	 * Charterer's Account 화면에서 데이타 조회(용선주 비용에 관련된 계정을 조회한다)<br>
	 * 
	 * @param condCharterInvoiceVO CondCharterInvoiceVO
	 * @return List<SearchCharterInvoiceSumVO>
	 * @exception EventException
	 */
    public List<SearchCharterInvoiceSumVO> searchCharterInvoiceSum(CondCharterInvoiceVO condCharterInvoiceVO) throws EventException {
		try {
			return dbDao.searchCharterInvoiceSum(condCharterInvoiceVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS01131",new String[]{}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01131",new String[]{}).getMessage(), ex);
		}
	}
    
    /**
	 * fletCtrlNo와 bnkYrmon에 해당하는 항차 가져오기<br>
	 * 
	 * @param fletCtrtNo String
	 * @param revYrmon String
	 * @return List<SearchVvdByBunkerVO>
	 * @exception EventException
	 */
    public List<SearchVvdListByCharterVO> searchVvdListByCharter(String fletCtrtNo, String revYrmon) throws EventException {
		try {
			return dbDao.searchVvdListByCharter(fletCtrtNo, revYrmon);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS01111",new String[]{}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01111",new String[]{}).getMessage(), ex);
		}
	}
	
    /**
	 * Charterer's Account 화면에서 용선주 비용을 변경한다<br>
	 * 
	 * @param customInvoiceVO CustomInvoiceVO
	 * @param customInvDtlVOs CustomInvDtlVO[]
	 * @param usrId String
	 * @exception EventException
	 */
    public void manageCharterInvoice(CustomInvoiceVO customInvoiceVO, CustomInvDtlVO[] customInvDtlVOs, String usrId) throws EventException{
    	try {
			List<CustomInvDtlVO> addVoList 	  = new ArrayList<CustomInvDtlVO>();
			List<CustomInvDtlVO> modifyVoList = new ArrayList<CustomInvDtlVO>();
			List<CustomInvDtlVO> removeVoList = new ArrayList<CustomInvDtlVO>();
			
			if(customInvoiceVO.getIbflag().equals("I")) {
				customInvoiceVO.setCreUsrId(usrId);
				customInvoiceVO.setUpdUsrId(usrId);
				dbDao.addCharterInvoice(customInvoiceVO);
			}
			
			int dtlSeq = dbDao.searchInvDtlSeq(customInvoiceVO.getFletCtrtNo(), customInvDtlVOs[0].getInvSeq());

			for(int i=0; i<customInvDtlVOs.length; i++) {
				if(customInvDtlVOs[i].getIbflag().equals("I")) {
					customInvDtlVOs[i].setDtlSeq(Integer.toString(dtlSeq + i));
					customInvDtlVOs[i].setChtrPayRcvCd(customInvoiceVO.getChtrPayRcvCd());
					customInvDtlVOs[i].setCreUsrId(usrId);
					customInvDtlVOs[i].setUpdUsrId(usrId);
					addVoList.add(customInvDtlVOs[i]);
					
				} else if(customInvDtlVOs[i].getIbflag().equals("U")) {
					customInvDtlVOs[i].setUpdUsrId(usrId);
					modifyVoList.add(customInvDtlVOs[i]);
					
				} else if(customInvDtlVOs[i].getIbflag().equals("D")) {
					removeVoList.add(customInvDtlVOs[i]);
				}
			}
			
			//FmsInvDtl 테이블 데이타 입력
			if(addVoList.size() > 0) {
				dbDao.addCharterInvDtls(addVoList);
			}
			
			//FmsInvDtl 테이블 데이타 수정
			if(modifyVoList.size() > 0) {
				dbDao.modifytCharterInvDtls(modifyVoList);
			}
			
			//FmsInvDtl 테이블 데이타 삭제
			if(removeVoList.size() > 0) {
				dbDao.removeCharterInvDtls(removeVoList);
			}
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS01106",new String[]{}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01106",new String[]{}).getMessage(), ex);
		}
	}
    
    /**
	 * Agreement Creation 화면에서 메일을 발송한다<br>
	 * 
	 * @param customSendEmailVO CustomSendEmailVO
	 * @param keys List<String>
	 * @param csrNo String 
	 * @return String
	 * @exception EventException
	 */
    public String sendEmail(CustomSendEmailVO customSendEmailVO, List<String> keys, String csrNo) throws EventException {
		try {			
			List<FileUploadListVO> fileUpladListVOs = dbDao.searchCsrFileUploadList(csrNo);								
			return eaiDao.sendEmail(customSendEmailVO, keys, fileUpladListVOs);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS01320",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS01320",new String[]{}).getMessage(), de);
		}
	}
    
    /**
	 * 선주 대행 비용을 선주 비용 지불 시 차감하기 위해 기 등록된 미수 계정의 성격 규명하는 작업이다<br>
	 * 조건대로 자료를 조회한다<br>
	 * 
	 * @param condSearchOwnerInvoiceVO CondSearchOwnerInvoiceVO
	 * @return List<SearchOwnerInvoiceListVO>
	 * @exception EventException
	 */
	public List<SearchOwnerInvoiceListVO> searchOwnerInvoiceList(CondSearchOwnerInvoiceVO condSearchOwnerInvoiceVO) throws EventException {
		try {
			condSearchOwnerInvoiceVO.setEffDt1(condSearchOwnerInvoiceVO.getEffDt1().replaceAll("-", ""));
			condSearchOwnerInvoiceVO.setEffDt2(condSearchOwnerInvoiceVO.getEffDt2().replaceAll("-", ""));
			return dbDao.searchOwnerInvoiceList(condSearchOwnerInvoiceVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(" FMS01115",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(" FMS01115",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * 선주 대행 비용을 선주 비용 지불 시 차감하기 위해 기 등록된 미수 계정의 성격 규명하는 작업이다<br>
	 * 변경된 자료를 변경한다<br>
	 * 
	 * @param customOwnrAcctSlpVOs CustomOwnrAcctSlpVO[]
	 * @param usrid String
	 * @exception EventException
	 */
	public void modifyOwnerInvoice(CustomOwnrAcctSlpVO[] customOwnrAcctSlpVOs, String usrid) throws EventException{
		try {
			List<CustomOwnrAcctSlpVO> modifyVoList = new ArrayList<CustomOwnrAcctSlpVO>();
			
			for ( int i=0; i<customOwnrAcctSlpVOs .length; i++ ) {
				if ( customOwnrAcctSlpVOs[i].getIbflag().equals("U")){
					if (customOwnrAcctSlpVOs[i].getStlFlg().equals("1")) {
						customOwnrAcctSlpVOs[i].setStlFlg("Y");
					} else {
						customOwnrAcctSlpVOs[i].setStlFlg("N");
					}
					customOwnrAcctSlpVOs[i].setUpdUsrId(usrid);
					modifyVoList.add(customOwnrAcctSlpVOs[i]);
				}
			}

			if ( modifyVoList.size() > 0 ) {
				dbDao.modifyOwnerInvoices(modifyVoList);
			}

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS01107",new String[]{}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01107",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Owner's Account 비용에 관련된 차변/대변 금액을 기준으로 자동으로 Matching 하도록 조회를 한다<br>
	 * 
	 * @param condSearchOwnerInvoiceAutoMatchVO CondSearchOwnerInvoiceAutoMatchVO
	 * @return List<SearchOwnerInvoiceAutoMatchListVO>
	 * @exception EventException
	 */
	public List<SearchOwnerInvoiceAutoMatchListVO> searchOwnerInvoiceAutoMatchList(CondSearchOwnerInvoiceAutoMatchVO condSearchOwnerInvoiceAutoMatchVO) throws EventException {
		try {
			condSearchOwnerInvoiceAutoMatchVO.setEffDt1(condSearchOwnerInvoiceAutoMatchVO.getEffDt1().replaceAll("-", ""));
			condSearchOwnerInvoiceAutoMatchVO.setEffDt2(condSearchOwnerInvoiceAutoMatchVO.getEffDt2().replaceAll("-", ""));
			return dbDao.searchOwnerInvoiceAutoMatchList(condSearchOwnerInvoiceAutoMatchVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(" FMS01110",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(" FMS01110",new String[]{}).getMessage(), ex);
		}
	}

	
	/**
	 * Off-Hire Expenses 화면에서 데이타 조회(Creation 버튼 클릭 시)<br>
	 * 
	 * @param condCalOffhireInvoiceVO CondCalOffhireInvoiceVO
	 * @return List<SearchCalOffhireInvoiceListVO>
	 * @exception EventException
	 */
	public List<SearchCalOffhireInvoiceListVO> searchCalOffhireInvoiceCheck(CondCalOffhireInvoiceVO condCalOffhireInvoiceVO) throws EventException {
		try {

			return dbDao.searchCalOffhireInvoiceCheck(condCalOffhireInvoiceVO);
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("FMS01117",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01117",new String[]{}).getMessage(), ex);
		}
	}
	
	
	
	/**
	 * Off-Hire Expenses 화면에서 데이타 조회(Creation 버튼 클릭 시)<br>
	 * 
	 * @param condCalOffhireInvoiceVO CondCalOffhireInvoiceVO
	 * @return List<SearchCalOffhireInvoiceListVO>
	 * @exception EventException
	 */
	public List<SearchCalOffhireInvoiceListVO> searchCalOffhireInvoiceList(CondCalOffhireInvoiceVO condCalOffhireInvoiceVO) throws EventException {
		try {
			return dbDao.searchCalOffhireInvoiceList(condCalOffhireInvoiceVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("FMS01117",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01117",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Off-Hire Expenses 화면에서 SUM 데이타 조회(Creation 버튼 클릭 시)<br>
	 * 
	 * @param condCalOffhireInvoiceVO CondCalOffhireInvoiceVO
	 * @return List<SearchCalOffhireInvoiceListSumVO>
	 * @exception EventException
	 */
	public List<SearchCalOffhireInvoiceListSumVO> searchCalOffhireInvoiceListSum(CondCalOffhireInvoiceVO condCalOffhireInvoiceVO) throws EventException {
		try {
			return dbDao.searchCalOffhireInvoiceListSum(condCalOffhireInvoiceVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("FMS01117",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01117",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * CtrtNo와 Duration 에 해당하는 항차 가져오기<br>
	 * 
	 * @param fletCtrtNo String
	 * @param effDt String
	 * @param expDt String
	 * @param vslCd String
	 * @return List<SearchVvdListByOffHireVO>
	 * @exception EventException
	 */
    public List<SearchVvdListByOffHireVO> searchVvdListByOffHire(String fletCtrtNo, String effDt, String expDt, String vslCd) throws EventException {
		try {
			return dbDao.searchVvdListByOffHire(fletCtrtNo, effDt, expDt, vslCd);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS01103",new String[]{}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01103",new String[]{}).getMessage(), ex);
		}
	}


	/**
	 * TCharterIOInvoice화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @return List<SearchManhourItemListVO>
	 * @exception EventException
	 */
	public List<SearchManhourItemListVO> searchManhourItemList() throws EventException {
		try {
			return dbDao.searchManhourItemList();
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("FMS01137",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01137",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Off-Hire Expenses 화면에서 Offhire Expenses 정보를 등록 및 변경한다<br>
	 * 
	 * @param customOffInvoiceVO CustomOffInvoiceVO
	 * @param customOffInvDtlVOs CustomOffInvDtlVO[]
	 * @param usrId String
	 * @exception EventException
	 */
    public void manageOffhireInvoice(CustomOffInvoiceVO customOffInvoiceVO, CustomOffInvDtlVO[] customOffInvDtlVOs, String usrId) throws EventException{
		try {
			List<CustomOffInvDtlVO> addVoList 	 = new ArrayList<CustomOffInvDtlVO>();
			List<CustomOffInvDtlVO> modifyVoList = new ArrayList<CustomOffInvDtlVO>();
			List<CustomOffInvDtlVO> removeVoList = new ArrayList<CustomOffInvDtlVO>();
			
			if(customOffInvoiceVO.getIbflag().equals("I")) {
				customOffInvoiceVO.setCreUsrId(usrId);
				customOffInvoiceVO.setUpdUsrId(usrId);
				dbDao.addOffInvoice(customOffInvoiceVO);
			} else {
				customOffInvoiceVO.setUpdUsrId(usrId);
				dbDao.modifyOffInvoice(customOffInvoiceVO);
			}
			
			if(customOffInvDtlVOs != null) {
				for(int i=0; i<customOffInvDtlVOs.length; i++) {
					if(customOffInvDtlVOs[i].getIbflag().equals("I")) {
						customOffInvDtlVOs[i].setEffDt(customOffInvoiceVO.getOriEffDt());
						customOffInvDtlVOs[i].setExpDt(customOffInvoiceVO.getOriExpDt());
						customOffInvDtlVOs[i].setInvUsdDys(customOffInvoiceVO.getInvUsdDys());
						customOffInvDtlVOs[i].setBunkerVvd(customOffInvoiceVO.getBunkerVvd());
						customOffInvDtlVOs[i].setBrogFlg(customOffInvoiceVO.getBrogFlg());
						customOffInvDtlVOs[i].setCreUsrId(usrId);
						customOffInvDtlVOs[i].setUpdUsrId(usrId);
						
						addVoList.add(customOffInvDtlVOs[i]);
						
					} else if(customOffInvDtlVOs[i].getIbflag().equals("U")) {
						customOffInvDtlVOs[i].setInvSeq(customOffInvoiceVO.getInvSeq());
						customOffInvDtlVOs[i].setBunkerVvd(customOffInvoiceVO.getBunkerVvd());
						//customOffInvDtlVOs[i].setInvDesc(customOffInvoiceVO.getInvDesc());
						customOffInvDtlVOs[i].setUpdUsrId(usrId);
						modifyVoList.add(customOffInvDtlVOs[i]);
						
					} else if(customOffInvDtlVOs[i].getIbflag().equals("D")) {
						customOffInvDtlVOs[i].setInvSeq(customOffInvoiceVO.getInvSeq());
						removeVoList.add(customOffInvDtlVOs[i]);
					}
				}
				
				//FmsInvDtl 테이블 데이타 입력
				if(addVoList.size() > 0) {
					dbDao.addOffInvDtls(addVoList);
				}
				
				//FmsInvDtl 테이블 데이타 수정
				if(modifyVoList.size() > 0) {
					dbDao.modifytOffInvDtls(modifyVoList);
				}
				
				//FmsInvDtl 테이블 데이타 삭제
				if(removeVoList.size() > 0) {
					dbDao.removeOffInvDtls(removeVoList);
				}
			}
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS01105",new String[]{}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01105",new String[]{}).getMessage(), ex);
		}
	}
    
    /**
	 * Man Hour 항목 조회한다<br>
	 * 
	 * @param condSearchManhourListVO CondSearchManhourListVO
	 * @return List<SearchManhourListVO>
	 * @exception EventException
	 */
	public List<SearchManhourListVO> searchManhourList(CondSearchManhourListVO condSearchManhourListVO) throws EventException {
		try {
			return dbDao.searchManhourList(condSearchManhourListVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("FMS01127",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01127",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Owner’s Account에서 특정 항목에 대해서 추가 금액을 상정하는 화면, Item 별 항목 자료를 저장한다<br>
	 * 
	 * @param customManHrChgVOs CustomManHrChgVO[]
	 * @param usrid String
	 * @exception EventException
	 */
	public void manageManhourList(CustomManHrChgVO[] customManHrChgVOs, String usrid) throws EventException {
		try {
			List<CustomManHrChgVO> addVoList = new ArrayList<CustomManHrChgVO>();
			List<CustomManHrChgVO> modifyVoList = new ArrayList<CustomManHrChgVO>();
			List<CustomManHrChgVO> remofeVoList = new ArrayList<CustomManHrChgVO>();
			for ( int i=0; i<customManHrChgVOs .length; i++ ) {
				if ( customManHrChgVOs[i].getIbflag().equals("I")){
					customManHrChgVOs[i].setCreUsrId(usrid);
					customManHrChgVOs[i].setUpdUsrId(usrid);
					addVoList.add(customManHrChgVOs[i]);
				} else if ( customManHrChgVOs[i].getIbflag().equals("U")){
					customManHrChgVOs[i].setUpdUsrId(usrid);
					modifyVoList.add(customManHrChgVOs[i]);
				} else if ( customManHrChgVOs[i].getIbflag().equals("D")){
					remofeVoList.add(customManHrChgVOs[i]);
				}
			}
			
			if ( addVoList.size() > 0 ) {
				dbDao.addManHrChgs(addVoList);
				dbDao.modifyOwnrAcctSlpManHrChgs(addVoList);
			}

			if ( modifyVoList.size() > 0 ) {
				dbDao.modifyManHrChgs(modifyVoList);
				dbDao.modifyOwnrAcctSlpManHrChgs(modifyVoList);
			}

			if ( remofeVoList.size() > 0 ) {
				dbDao.removeManhrChgs(remofeVoList);
				dbDao.modifyOwnrAcctSlpManHrChgs(remofeVoList);
			}
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS01128",new String[]{}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01128",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Off-Hire Expenses 화면에서 데이타 조회(Inquery 버튼 클릭 시)<br>
	 * 
	 * @param fletCtrtNo String
	 * @param invSeq String
	 * @return List<SearchOffhireInvoiceListVO>
	 * @exception EventException
	 */
	public List<SearchOffhireInvoiceListVO> searchOffhireInvoiceList(String fletCtrtNo, String invSeq) throws EventException {
		try {
			return dbDao.searchOffhireInvoiceList(fletCtrtNo, invSeq);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("FMS01113",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01113",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Off-Hire Expenses 화면에서 SUM 데이타 조회(Inquery 버튼 클릭 시)<br>
	 * 
	 * @param fletCtrtNo String
	 * @param invSeq String
	 * @return List<SearchCalOffhireInvoiceListSumVO>
	 * @exception EventException
	 */
	public List<SearchCalOffhireInvoiceListSumVO> searchOffhireInvoiceListSum(String fletCtrtNo, String invSeq) throws EventException {
		try {
			return dbDao.searchOffhireInvoiceListSum(fletCtrtNo, invSeq);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("FMS01113",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01113",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Offhire Selection 화면에서 데이타 조회(POPUP)<br>
	 * 
	 * @param fletCtrtNo String
	 * @return List<SearchOffhireSelectionListVO>
	 * @exception EventException
	 */
	public List<SearchOffhireSelectionListVO> searchOffhireSelectionList(String fletCtrtNo) throws EventException {
		try {
			return dbDao.searchOffhireSelectionList(fletCtrtNo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("FMS01132",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01132",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Off-Hire Expenses 화면에서 Offhire Expenses 정보를 삭제한다<br>
	 * 
	 * @param fletCtrtNo String
	 * @param invSeq String
	 * @exception EventException
	 */
	public void removeOffhireInvoice(String fletCtrtNo, String invSeq) throws EventException{
		try {
			//FMS_INV_DTL 테이블 삭제
			dbDao.removeOffhireInvDtls(fletCtrtNo, invSeq);
			
			//FMS_INVOICE 테이블 삭제
			dbDao.removeOffhireInvoice(fletCtrtNo, invSeq);

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS01109",new String[]{}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01109",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Manhour Item을 관리하는 항목이고  Item 별 자료를 조회한다<br>
	 * 
	 * @return List<SearchManhourItemRegistrationListVO>
	 * @exception EventException
	 */
	public List<SearchManhourItemRegistrationListVO> searchManhourItemRegistrationList() throws EventException {
		try {
			return dbDao.searchManhourItemRegistrationList();
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("FMS01129",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01129",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Manhour Item을 관리하는 항목이고  Item 별 자료를 저장한다<br>
	 * 
	 * @param customManHrListVOs CustomManHrListVO[]
	 * @param usrid String
	 * @exception EventException
	 */
	public void manageManhourItemRegistration(CustomManHrListVO[] customManHrListVOs, String usrid) throws EventException {
		try {
			List<CustomManHrListVO> addVoList = new ArrayList<CustomManHrListVO>();
			List<CustomManHrListVO> modifyVoList = new ArrayList<CustomManHrListVO>();
			List<CustomManHrListVO> remofeVoList = new ArrayList<CustomManHrListVO>();
			for ( int i=0; i<customManHrListVOs .length; i++ ) {
				if ( customManHrListVOs[i].getIbflag().equals("I")){
					customManHrListVOs[i].setCreUsrId(usrid);
					customManHrListVOs[i].setUpdUsrId(usrid);
					addVoList.add(customManHrListVOs[i]);
				} else if ( customManHrListVOs[i].getIbflag().equals("U")){
					customManHrListVOs[i].setUpdUsrId(usrid);
					modifyVoList.add(customManHrListVOs[i]);
				} else if ( customManHrListVOs[i].getIbflag().equals("D")){
					remofeVoList.add(customManHrListVOs[i]);
				}
			}
			
			if ( addVoList.size() > 0 ) {
				dbDao.addManHrLists(addVoList);
			}

			if ( modifyVoList.size() > 0 ) {
				dbDao.modifyManHrLists(modifyVoList);
			}

			if ( remofeVoList.size() > 0 ) {
				dbDao.removeManHrLists(remofeVoList);
			}
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS01130",new String[]{}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01130",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Offhire Expenses from VMS 화면에서 데이타 조회(POPUP)<br>
	 * 
	 * @param condSearchOffhireInvoiceVmsVO CondSearchOffhireInvoiceVmsVO
	 * @return List<SearchOffhireInvoiceVmsListVO>
	 * @exception EventException
	 */
	public List<SearchOffhireInvoiceVmsListVO> searchOffhireInvoiceVmsList(CondSearchOffhireInvoiceVmsVO condSearchOffhireInvoiceVmsVO) throws EventException {
		try {
			return dbDao.searchOffhireInvoiceVmsList(condSearchOffhireInvoiceVmsVO);
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("FMS01123",new String[]{}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01123",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Offhire Expenses from VMS 화면에서 등록 정보를 변경한다<br>
	 * 
	 * @param customOffhExpnVOs CustomOffhExpnVO
	 * @param usrid String
	 * @exception EventException
	 */
	public void modifyOffhireInvoiceVms(CustomOffhExpnVO[] customOffhExpnVOs, String usrid) throws EventException {
		try {
			List<CustomOffhExpnVO> modifyVoList = new ArrayList<CustomOffhExpnVO>();

			for ( int i=0; i<customOffhExpnVOs.length; i++ ) {
				if ( customOffhExpnVOs[i].getIbflag().equals("U")){
					customOffhExpnVOs[i].setUpdUsrId(usrid);
					modifyVoList.add(customOffhExpnVOs[i]);
				}
			}

			if (modifyVoList.size() > 0) {
				dbDao.modifyOffhireInvoiceVms(modifyVoList);
			}

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS01122",new String[]{}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01122",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Prepayments 화면에서 데이타 조회(Creation 버튼 클릭 시)<br>
	 * 
	 * @param condSearchCalPrepaymentInvoiceListVO CondSearchCalPrepaymentInvoiceListVO
	 * @return List<SearchCalPrepaymentInvoiceListVO>
	 * @exception EventException
	 */
	public List<SearchCalPrepaymentInvoiceListVO> searchCalPrepaymentInvoiceList(CondSearchCalPrepaymentInvoiceListVO condSearchCalPrepaymentInvoiceListVO) throws EventException {
		try {
			String effDt = condSearchCalPrepaymentInvoiceListVO.getOriEffDt().substring(0,8);
			String expDt = condSearchCalPrepaymentInvoiceListVO.getOriExpDt().substring(0,8);
			
			//String months = ""+(DateTime.monthsBetween(effDt, expDt) - 1);
			
			String months = ""+(DateTime.monthsBetween(effDt, expDt));

			condSearchCalPrepaymentInvoiceListVO.setMonths(months);

			return dbDao.searchCalPrepaymentInvoiceList(condSearchCalPrepaymentInvoiceListVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("FMS01112",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01112",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Prepayments 화면에서 SUM 데이타 조회(Inquery 버튼 클릭 시)<br>
	 * 
	 * @param condSearchCalPrepaymentInvoiceListVO CondSearchCalPrepaymentInvoiceListVO
	 * @return List<SearchCalPrepaymentInvoiceListSumVO>
	 * @exception EventException
	 */
	public List<SearchCalPrepaymentInvoiceListSumVO> searchCalPrepaymentInvoiceListSum(CondSearchCalPrepaymentInvoiceListVO condSearchCalPrepaymentInvoiceListVO) throws EventException {
		try {
			return dbDao.searchCalPrepaymentInvoiceListSum(condSearchCalPrepaymentInvoiceListVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("FMS01112",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01112",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Prepayments 화면에서 Invoice 정보를 등록한다<br>
	 * 
	 * @param customPreInvoiceVO CustomPreInvoiceVO
	 * @param customPreInvDtlVOs CustomPreInvDtlVO[]
	 * @param usrId String
	 * @exception EventException
	 */
    public void creatPrepaymentInvoice(CustomPreInvoiceVO customPreInvoiceVO, CustomPreInvDtlVO[] customPreInvDtlVOs, String usrId) throws EventException{
		try {
			List<CustomPreInvDtlVO> addVoList = new ArrayList<CustomPreInvDtlVO>();
			
			if(customPreInvoiceVO.getIbflag().equals("I")) {
				customPreInvoiceVO.setCreUsrId(usrId);
				customPreInvoiceVO.setUpdUsrId(usrId);
				dbDao.addPreInvoice(customPreInvoiceVO);
			}
			
			if(customPreInvDtlVOs != null) {
				for(int i=0; i<customPreInvDtlVOs.length; i++) {
					if(customPreInvDtlVOs[i].getIbflag().equals("I")) {
						customPreInvDtlVOs[i].setVslCd(customPreInvoiceVO.getVslCd());
						customPreInvDtlVOs[i].setFletCtrtTpGb(customPreInvoiceVO.getFletCtrtTpGb());
						customPreInvDtlVOs[i].setBrogFlg(customPreInvoiceVO.getBrogFlg());
						
						customPreInvDtlVOs[i].setEffDt(customPreInvoiceVO.getOriEffDt());
						customPreInvDtlVOs[i].setExpDt(customPreInvoiceVO.getOriExpDt());
						customPreInvDtlVOs[i].setInvUsdDys(customPreInvoiceVO.getInvUsdDys());
						
						customPreInvDtlVOs[i].setCreUsrId(usrId);
						customPreInvDtlVOs[i].setUpdUsrId(usrId);
						
						addVoList.add(customPreInvDtlVOs[i]);
					}
				}
				
				//FmsInvDtl 테이블 데이타 입력
				if(addVoList.size() > 0) {
					dbDao.addPreInvDtls(addVoList);
				}
			}
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS01100",new String[]{}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01100",new String[]{}).getMessage(), ex);
		}
	}
    
    /**
	 * Prepayments 화면에서 Invoice 정보를 변경/삭제한다<br>
	 * 
	 * @param customPreInvoiceVO CustomPreInvoiceVO
	 * @param customPreInvDtlVOs CustomPreInvDtlVO[]
	 * @param usrId String
	 * @exception EventException
	 */
    public void managePrepaymentInvoice(CustomPreInvoiceVO customPreInvoiceVO, CustomPreInvDtlVO[] customPreInvDtlVOs, String usrId) throws EventException{
		try {
			List<CustomPreInvDtlVO> modifyVoList = new ArrayList<CustomPreInvDtlVO>();
			List<CustomPreInvDtlVO> removeVoList = new ArrayList<CustomPreInvDtlVO>();
			
			if(customPreInvDtlVOs != null) {
				for(int i=0; i<customPreInvDtlVOs.length; i++) {	
					if(customPreInvDtlVOs[i].getIbflag().equals("U")) {
						customPreInvDtlVOs[i].setUpdUsrId(usrId);
						modifyVoList.add(customPreInvDtlVOs[i]);
						
					} else if(customPreInvDtlVOs[i].getIbflag().equals("D")) {
						removeVoList.add(customPreInvDtlVOs[i]);
					}
				}
				
				//FmsInvDtl 테이블 데이타 수정
				if(modifyVoList.size() > 0) {
					dbDao.modifytPreInvDtls(modifyVoList);
				}
				
				//FmsInvDtl 테이블 데이타 삭제
				if(removeVoList.size() > 0) {
					dbDao.removePreInvDtls(removeVoList);
				}
			}
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS01104",new String[]{}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01104",new String[]{}).getMessage(), ex);
		}
	}
    
    /**
	 * 사선/용선/대선에 대한 계약정보 조회<br>
	 * Prepayments 화면에서 데이타 조회(Inquiry 선택시)<br>
	 * 
	 * @param fletCtrtNo String
	 * @param ppayHirNo String
	 * @param invSeq String
	 * @return InvoiceContainerVO
	 * @exception EventException
	 */
	public InvoiceContainerVO searchPrepaymentInvoiceList(String fletCtrtNo, String ppayHirNo, String invSeq) throws EventException {	
		
		InvoiceContainerVO invoiceContainerVO = new InvoiceContainerVO();	
		
		try {
			SearchPrepaymentInvoiceVO searchPrepaymentInvoiceVO = dbDao.searchPrepaymentInvoice(fletCtrtNo, ppayHirNo);
			SearchHireSysDateVO searchHireSysDateVO = conDbDao.searchHireSysDate2(fletCtrtNo, ppayHirNo);
			List<SearchOtrExpnSysDateListVO> searchOtrExpnSysDateListVOs = conDbDao.searchOtrExpnSysDate2List(fletCtrtNo, ppayHirNo);
			List<SearchPrepaymentHireNoListVO> searchPrepaymentHireNoListVOs= dbDao.searchPrepaymentHireNoList(fletCtrtNo, ppayHirNo);
			List<SearchPrepaymentHireNoListSumVO> searchPrepaymentHireNoListSumVOs = dbDao.searchPrepaymentHireNoListSum(fletCtrtNo, ppayHirNo);

			invoiceContainerVO.setSearchPrepaymentInvoiceVO(searchPrepaymentInvoiceVO);
			invoiceContainerVO.setSearchHireSysDateVO(searchHireSysDateVO);
			invoiceContainerVO.setSearchOtrExpnSysDateListVOs(searchOtrExpnSysDateListVOs);
			invoiceContainerVO.setSearchPrepaymentHireNoListVOs(searchPrepaymentHireNoListVOs);
			invoiceContainerVO.setSearchPrepaymentHireNoListSumVOs(searchPrepaymentHireNoListSumVOs);
			
			if(!ppayHirNo.equals(invSeq)) {
				List<SearchContractListByPrepaymentHireNoVO> searchContractListByPrepaymentHireNoVOs = conDbDao.searchContractListByPrepaymentHireNo(fletCtrtNo);
				invoiceContainerVO.setSearchContractListByPrepaymentHireNoVOs(searchContractListByPrepaymentHireNoVOs);
			}
			
			return invoiceContainerVO;
				
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS01112",new String[]{}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01112",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * DELETE 처리-전표가 생성되지 않은 경우에만 해당됨<br>
	 * Prepayments 화면에 대한 DELETE 이벤트 처리<br>
	 * 
	 * @param fletCtrtNo String
	 * @param invSeq String
	 * @exception EventException
	 */
	public void removePrepaymentInvoice(String fletCtrtNo, String invSeq) throws EventException {

		try {	
			
			//FMS_INV_DTL 테이블 삭제
			dbDao.removePrepaymentInvDtls(fletCtrtNo, invSeq);
			
			//FMS_INVOICE 테이블 삭제
			dbDao.removePrepaymentInvoice(fletCtrtNo, invSeq);
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS01108",new String[]{}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01108",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * Owner Account Expense 변경 작업이다<br>
	 * 변경된 자료를 변경한다<br>
	 * 
	 * @param customCsulSlpVOs CustomCsulSlpVO[]
	 * @param usrid String
	 * @exception EventException
	 */
	public void modifyOwnerAccountExpense(CustomCsulSlpVO[] customCsulSlpVOs, String usrid) throws EventException{
		try {
			List<CustomCsulSlpVO> modifyVoList = new ArrayList<CustomCsulSlpVO>();
			
			for ( int i=0; i<customCsulSlpVOs .length; i++ ) {
				if ( customCsulSlpVOs[i].getApplyChk().equals("1")){
					customCsulSlpVOs[i].setUpdUsrId(usrid);
					modifyVoList.add(customCsulSlpVOs[i]);
				}
			}
	
			if ( modifyVoList.size() > 0 ) {
				dbDao.modifyOwnerAccountExpenses(modifyVoList);
			}
	
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS01504",new String[]{}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01504",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * ERP AP에서 Owner’s account 관련 비용을 가지고 와서 생성 및 변경한다<br>
	 * 
	 * @param xmlObject XmlObject
	 * @exception DAOException, Exception
	 */
	public void manageOwnerAccountInterface(XmlObject xmlObject) throws EventException{
		try {
			FNS0560001Document doc = (FNS0560001Document) xmlObject;
			FNS0560001 sync = doc.getFNS0560001();
			com.hanjin.irep.erp.FNS0560001Document.FNS0560001.DataArea data = sync.getDataArea();
			com.hanjin.irep.erp.FNS0560001Document.FNS0560001.DataArea.ROWSET rowset = data.getROWSET();
			com.hanjin.irep.erp.FNS0560001Document.FNS0560001.DataArea.ROWSET.ROW[] row = rowset.getROWArray();
			
			if(row !=null && row.length > 0) {
				for (int i=0; i<row.length; i++) {
					CustomOwnerAccountInterfaceVO customOwnerAccountInterfaceVO = new CustomOwnerAccountInterfaceVO();
					customOwnerAccountInterfaceVO.setSlpTpCd(row[i].getTSTPCD());
					customOwnerAccountInterfaceVO.setSlpFuncCd(row[i].getFUNCCD());
					customOwnerAccountInterfaceVO.setSlpOfcCd(row[i].getTMCD());
					customOwnerAccountInterfaceVO.setSlpIssDt(row[i].getISSDT());
					customOwnerAccountInterfaceVO.setSlpSerNo(row[i].getSLPSER());
					customOwnerAccountInterfaceVO.setSlpSeqNo(row[i].getSLPSEQ());
					customOwnerAccountInterfaceVO.setVslCd(row[i].getVSLCD());
					customOwnerAccountInterfaceVO.setSkdVoyNo(row[i].getVOYNO());
					customOwnerAccountInterfaceVO.setSkdDirCd(row[i].getDIR());
					customOwnerAccountInterfaceVO.setRevDirCd(row[i].getDIR());
					customOwnerAccountInterfaceVO.setAcctCd(row[i].getACCTCD());
					customOwnerAccountInterfaceVO.setEffDt(row[i].getEFFDT());
					customOwnerAccountInterfaceVO.setCtrCd(row[i].getCTRCD());
					customOwnerAccountInterfaceVO.setN1stCurrCd(row[i].getCURRCD1());
					customOwnerAccountInterfaceVO.setN2ndCurrCd(row[i].getCURRCD2());
					customOwnerAccountInterfaceVO.setN1stAmt(row[i].getAMT1());
					customOwnerAccountInterfaceVO.setN2ndAmt(row[i].getAMT2());
					customOwnerAccountInterfaceVO.setLoclXchRtAmt(row[i].getCURRRATE());
					customOwnerAccountInterfaceVO.setApDesc(row[i].getDESCRIPTION());
					customOwnerAccountInterfaceVO.setCreUsrId(row[i].getCREID());
					customOwnerAccountInterfaceVO.setUpdUsrId(row[i].getUPDID());
					customOwnerAccountInterfaceVO.setCreDt(row[i].getCREDT());
					customOwnerAccountInterfaceVO.setUpdDt(row[i].getUPDDT());

					int updCnt = dbDao.modifyOwnerAccountInterfaces(customOwnerAccountInterfaceVO);
					if(updCnt == 0) {
						dbDao.addOwnerAccountInterfaces(customOwnerAccountInterfaceVO);
					}
				}
			}
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS00050",new String[]{}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS00050",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * 대선 수입 채권 발생 시 기존 생성해놓은 Hire 정보 중 당 월 자료를 조회한다<br>
	 * 
	 * @param fletCtrtNo String
	 * @param currCd String
	 * @param slpOfcCd String
	 * @return List<SearchInvoiceListByRevenueSlipVO>
	 * @exception EventException, Exception
	 */
	public List<SearchInvoiceListByRevenueSlipVO> searchPrepaymentListByRevenueSlip(String fletCtrtNo, String currCd, String slpOfcCd) throws EventException {
		try {
			return dbDao.searchPrepaymentByRevenueSlipList(fletCtrtNo, currCd, slpOfcCd);
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("FMS01412",new String[]{}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01412",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * 대선 전표가 생성되면 정산 테이블에 관련 항목들에 대해서 수정한다<br>
	 * 
	 * @param customCsulSlpVOs CustomCsulSlpVO[]
	 * @exception EventException
	 */
	public void modifySubletRevenueSlip(CustomCsulSlpVO[] customCsulSlpVOs) throws EventException{
		try {
			List<CustomCsulSlpVO> modifyRevSlips = new ArrayList<CustomCsulSlpVO>();
			List<CustomCsulSlpVO> modifyRevSlipCommission = new ArrayList<CustomCsulSlpVO>();

			for ( int i=0; i<customCsulSlpVOs .length; i++ ) {
				if(customCsulSlpVOs[i].getAcctCd().equals("954112")) {
					modifyRevSlips.add(customCsulSlpVOs[i]);
					modifyRevSlipCommission.add(customCsulSlpVOs[i]);
				}
			}
	
			if ( modifyRevSlips.size() > 0 ) {
				dbDao.modifySubletRevenueSlips(modifyRevSlips);
				dbDao.modifySubletRevenueSlipCommission(modifyRevSlipCommission);
			}
	
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS01411",new String[]{}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01411",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * VMS에서 용선선박 용선료를 조회한다<br>
	 * 
	 * @param vslCd String
	 * @param effDt String
	 * @return String
	 * @exception EventException
	 */
    public String searchVesselCodeHireInterface(String vslCd, String effDt) throws EventException {
		try {
			return dbDao.searchVesselCodeHireInterface(vslCd, effDt);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS00055",new String[]{}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS00055",new String[]{}).getMessage(), ex);
		}
	}
    
    /**
	 * VMS에서 CDAM 정산 데이터를 조회한다<br>
	 * 
	 * @param vslCd String
	 * @param effDt String
	 * @param expDt String
	 * @return List<SearchVesselCodeInvoiceInterfaceVO>
	 * @exception EventException
	 */
    public List<SearchVesselCodeInvoiceInterfaceVO> searchVesselCodeInvoiceInterface(String vslCd, String effDt, String expDt) throws EventException {
		try {
			return dbDao.searchVesselCodeInvoiceInterface(vslCd, effDt, expDt);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS00056",new String[]{}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS00055",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 *  Payment Slip화면에서 계약번호 선택 후 정산 관련 기본 정보를 조회한다<br>
	 * 
	 * @param fletCtrtNo String
	 * @return List<SearchInvoiceByPaymentSlipVO>
	 * @exception EventException
	 */
	public List<SearchInvoiceByPaymentSlipVO> searchInvoiceByPaymentSlip(String fletCtrtNo) throws EventException {
		try {
			return dbDao.searchInvoiceByPaymentSlip(fletCtrtNo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("FMS01505",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("FMS01505",new String[]{}).getMessage(), ex);
				}
	}

	

	/**
	 *  Payment Slip화면에서 계약번호 선택 후 정산 관련 기본 정보를 조회한다<br>
	 * 
	 * @param fletCtrtNo String
	 * @return List<SearchInvoiceByPaymentSlipVO>
	 * @exception EventException
	 */
	public List<SearchInvoiceByPaymentSlipVO> searchInvoiceByPaymentSlip2(String fletCtrtNo) throws EventException {
		try {
			return dbDao.searchInvoiceByPaymentSlip2(fletCtrtNo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("FMS01505",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("FMS01505",new String[]{}).getMessage(), ex);
		}
	}
	/**
	 * VMS 에서 실시간으로 Offhire Expense 자료가 수신되면 FMS_OFFH_EXPN 테이블에 입력된다<br>
	 * 
	 * @param xmlObject XmlObject
	 * @exception EventException
	 */
	public void manageOffHireExpenseInterface(XmlObject xmlObject) throws EventException {
		List<CustomOffHireExpenseInterfaceVO> customOffHireExpenseInterfaceVOs = new ArrayList<CustomOffHireExpenseInterfaceVO>();
		
		try {
			
			ESM0660001Document doc = (ESM0660001Document) xmlObject;
			ESM0660001 sync = doc.getESM0660001();
			com.hanjin.irep.enisEsm.ESM0660001Document.ESM0660001.DataArea data = sync.getDataArea();
			com.hanjin.irep.enisEsm.ESM0660001Document.ESM0660001.DataArea.ROWSET rowset = data.getROWSET();
			com.hanjin.irep.enisEsm.ESM0660001Document.ESM0660001.DataArea.ROWSET.ROW[] row = rowset.getROWArray();
			
			if(row !=null && row.length > 0) {
				for (int i=0; i<row.length; i++) {
					CustomOffHireExpenseInterfaceVO recvData = new CustomOffHireExpenseInterfaceVO();
					recvData.setVslCd(row[i].getVSLCD());
					recvData.setOffhDt(row[i].getOFFHDT());
					recvData.setOnhDt(row[i].getONHDT());
					recvData.setOffhDurDys(row[i].getOFFHDURDYS());
					recvData.setFletAccTpCd(row[i].getFLETACCTPCD());
					recvData.setFoilQty(row[i].getFOILQTY());
					recvData.setDoilQty(row[i].getDOILQTY());
					recvData.setOffhRsn(row[i].getOFFHRSN());
					recvData.setOffhDesc(row[i].getOFFHDESC());
					if(row[i].getOFFHDELT().equals("D")) {
						recvData.setDeltFlg("Y");
					} else {
						recvData.setDeltFlg("N");
					}
					recvData.setUpdUsrId("ESM066_0001");
					recvData.setCreUsrId("ESM066_0001");

					customOffHireExpenseInterfaceVOs.add(recvData);
				}
			}
			
			if ( customOffHireExpenseInterfaceVOs.size() > 0 ) {
				dbDao.mergeOffHireExpenseInterfaces(customOffHireExpenseInterfaceVOs);
			}
	
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS00054",new String[]{}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS00054",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * 자발적, 비자발적 오류 처리할 전표에 대한 취소 작업 진행한다<br>
	 * 
	 * @param customInterfaceStatusVO CustomInterfaceStatusVO
	 * @param usrId String
	 * @exception EventException
	 */
	public void modifyInterfaceStatusInvoice(CustomInterfaceStatusVO customInterfaceStatusVO, String usrId) throws EventException{
		try {
			
			customInterfaceStatusVO.setUpdUsrId(usrId);

			dbDao.modifyInterfaceStatusInvoice(customInterfaceStatusVO);
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS01425",new String[]{}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01425",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Bunker Price 를 Interface 해 온다<br>
	 * 
	 * @param locCd String
	 * @param fromDt String
	 * @param toDt String
	 * @return List<SearchBunkerPriceInterfaceListVO>
	 * @exception EventException
	 */
	public List<SearchBunkerPriceInterfaceListVO> searchBunkerPriceInterfaceList(String locCd, String fromDt, String toDt) throws EventException {
		try {
			return dbDao.searchBunkerPriceInterfaceList(locCd, fromDt, toDt);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("FMS01102",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01102",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * 품의되지 않은 선급금 대상 자료를 조회한다<br>
	 * 
	 * @param fletCtrtNo String
	 * @param ofcCd String
	 * @param csrCurrCd String
	 * @return List<SearchPrepaymentListByPaymentSlipVO>
	 * @exception EventException
	 */
	public List<SearchPrepaymentListByPaymentSlipVO> searchPrepaymentListByPaymentSlip(String fletCtrtNo, String ofcCd, String csrCurrCd) throws EventException {
		try {
			return dbDao.searchPrepaymentListByPaymentSlip(fletCtrtNo, ofcCd, csrCurrCd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("FMS01403",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01403",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * 용선/대선 전표가 취소 되면 Invoice 에 전표번호가 Null 로 변경된다<br>
	 * 
	 * @param csrNo String
	 * @param usrId String
	 * @exception EventException
	 */
	public void modifySlipApprovalCancelInvoice(String csrNo, String usrId) throws EventException{
		try {
			
			//FMS_INV_DTL 테이블 수정
			dbDao.modifySlipApprovalCancelInvoice(csrNo, usrId);
	
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS01419",new String[]{}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01419",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * 용선 전표가 취소 되면 Account Account 에 전표번호가 Null 로 변경된다<br>
	 * 
	 * @param csrNo String
	 * @param usrId String
	 * @exception EventException
	 */
	public void modifySlipApprovalCancelOwnerAccount(String csrNo, String usrId) throws EventException{
		try {
			
			//FMS_OWNR_ACCT_SLP 테이블 수정
			dbDao.modifySlipApprovalCancelOwnerAccount(csrNo, usrId);
	
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS01419",new String[]{}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01419",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * 품의되지 않은 Charterer's Account 대상 자료를 조회한다<br>
	 * 
	 * @param fletCtrtNo String
	 * @param ofcCd String
	 * @param csrCurrCd String
	 * @return List<SearchCharterListByPaymentSlipVO>
	 * @exception EventException
	 */
	public List<SearchCharterListByPaymentSlipVO> searchCharterListByPaymentSlip(String fletCtrtNo, String ofcCd, String csrCurrCd) throws EventException {
		try {
			return dbDao.searchCharterListByPaymentSlip(fletCtrtNo, ofcCd, csrCurrCd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("FMS01404",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01404",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * 기 작성된 Offhire Expenses / Window 중 지급 전표로 처리할 항목 선정 대상 자료를 조회한다<br>
	 * 
	 * @param fletCtrtNo String
	 * @param ofcCd String
	 * @param csrCurrCd String
	 * @return List<SearchOffhireListByPaymentSlipVO>
	 * @exception EventException
	 */
	public List<SearchOffhireListByPaymentSlipVO> searchOffhireListByPaymentSlip(String fletCtrtNo, String ofcCd, String csrCurrCd) throws EventException {
		try {
			return dbDao.searchOffhireListByPaymentSlip(fletCtrtNo, ofcCd, csrCurrCd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("FMS01405",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01405",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * 기 작성된 Owner’s Account / Window 중 지급 전표로 처리할 항목 선정 대상 자료를 조회한다<br>
	 * 
	 * @param fletCtrtNo String
	 * @param ofcCd String
	 * @param csrCurrCd String
	 * @return List<SearchOwnerListByPaymentSlipVO>
	 * @exception EventException
	 */
	public List<SearchOwnerListByPaymentSlipVO> searchOwnerListByPaymentSlip(String fletCtrtNo, String ofcCd, String csrCurrCd) throws EventException {
		try {
			return dbDao.searchOwnerListByPaymentSlip(fletCtrtNo, ofcCd, csrCurrCd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("FMS01406",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01406",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * 대선 전표가 승인 되면 Invoice 에 IF NO를 업데이트한다<br>
	 * 
	 * @param searchArSlipDetailListVO List<SearchArSlipDetailListVO>
	 * @exception EventException
	 */
	public void modifySlipApprovalInvoice(List<SearchArSlipDetailListVO> searchArSlipDetailListVO) throws EventException{
		try {
			
			//FMS_INV_DTL 테이블 수정
			dbDao.modifySlipApprovalInvoice(searchArSlipDetailListVO);
	
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS01419",new String[]{}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01419",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * Manual 전표 생성 시 Broker 관련 Invoice 계정에 수정한다<br>
	 * 
	 * @param customCsulSlpVOs CustomCsulSlpVO[]
	 * @exception EventException
	 */
	public void modifyManualSlip(CustomCsulSlpVO[] customCsulSlpVOs) throws EventException{
		try {
			List<CustomCsulSlpVO> modifyVoList = new ArrayList<CustomCsulSlpVO>();

			for ( int i=0; i<customCsulSlpVOs .length; i++ ) {
				if(!customCsulSlpVOs[i].getFletCtrtNo().equals("")) {
					modifyVoList.add(customCsulSlpVOs[i]);
				}
			}

			if ( modifyVoList.size() > 0 ) {
				dbDao.modifyManualSlip(modifyVoList);
			}
	
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS01428",new String[]{}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01428",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * 전표 생성 완료 후 Invoice 테이블을 업데이트한다<br>
	 * 
	 * @param customPamConsultationVOs CustomPamConsultationVO[]
	 * @param customPamCsulSlpVOs CustomPamCsulSlpVO[]
	 * @param slpSerNo String
	 * @exception EventException
	 */
	public void modifyPaymentSlipInvoices(CustomPamConsultationVO[] customPamConsultationVOs, CustomPamCsulSlpVO[] customPamCsulSlpVOs, String slpSerNo) throws EventException{
		try {
			List<CustomPamCsulSlpVO> modifyVoList = new ArrayList<CustomPamCsulSlpVO>();

			for(int i=0; i<customPamCsulSlpVOs.length; i++) {
				if(   customPamCsulSlpVOs[i].getIbflag().equals("I")
				   && !customPamCsulSlpVOs[i].getInvSeq().equals("")
				   && !customPamCsulSlpVOs[i].getInvDtlSeq().equals("")
				   && !customPamCsulSlpVOs[i].getFletIssTpCd().equals("")
				   && !customPamCsulSlpVOs[i].getFletCtrtNo().equals("")) {
					
					customPamCsulSlpVOs[i].setSlpFuncCd(customPamConsultationVOs[0].getSlpTp());
					customPamCsulSlpVOs[i].setSlpOfcCd(customPamConsultationVOs[0].getSlpOfcCd());
					customPamCsulSlpVOs[i].setSlpSerNo(slpSerNo);
					customPamCsulSlpVOs[i].setUpdUsrId(customPamConsultationVOs[0].getUpdUsrId());
					
					modifyVoList.add(customPamCsulSlpVOs[i]);
					
				}
			}
			
			//데이타 수정
			if(modifyVoList.size() > 0) {
				dbDao.modifyPaymentSlipInvoices(modifyVoList);
			}
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS01401",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS01401",new String[]{}).getMessage(), de);
		}
	}
	
	/**
	 * 전표 생성 완료 후 Owner's Account 테이블을 업데이트한다<br>
	 * 
	 * @param customPamConsultationVOs CustomPamConsultationVO[]
	 * @param customPamCsulSlpVOs CustomPamCsulSlpVO[]
	 * @param slpSerNo String
	 * @exception EventException
	 */
	public void modifyPaymentSlipOwnerAccounts(CustomPamConsultationVO[] customPamConsultationVOs, CustomPamCsulSlpVO[] customPamCsulSlpVOs, String slpSerNo) throws EventException{
		try {
			List<CustomPamCsulSlpVO> modifyVoList = new ArrayList<CustomPamCsulSlpVO>();

			for(int i=0; i<customPamCsulSlpVOs.length; i++) {
				if(   customPamCsulSlpVOs[i].getIbflag().equals("I")
				   && !customPamCsulSlpVOs[i].getApSlpTpCd().equals("")
				   && !customPamCsulSlpVOs[i].getApSlpFuncCd().equals("")
				   && !customPamCsulSlpVOs[i].getApSlpOfcCd().equals("")
				   && !customPamCsulSlpVOs[i].getApSlpIssDt().equals("")
				   && !customPamCsulSlpVOs[i].getApSlpSerNo().equals("")
				   && !customPamCsulSlpVOs[i].getApSlpSeqNo().equals("")) {
					
					customPamCsulSlpVOs[i].setCsulSlpFuncCd(customPamConsultationVOs[0].getSlpTp());
					customPamCsulSlpVOs[i].setCsulSlpOfcCd(customPamConsultationVOs[0].getSlpOfcCd());
					customPamCsulSlpVOs[i].setCsulSlpSerNo(slpSerNo);
					customPamCsulSlpVOs[i].setUpdUsrId(customPamConsultationVOs[0].getUpdUsrId());
					
					modifyVoList.add(customPamCsulSlpVOs[i]);
					
				}
			}
			
			//데이타 수정
			if(modifyVoList.size() > 0) {
				dbDao.modifyPaymentSlipOwnerAccounts(modifyVoList);
			}
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS01401",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS01401",new String[]{}).getMessage(), de);
		}
	}
	
	/**
	 * 선주 지불 예정 비용 중 하역 실수로 발생한 비용에 대한 지불 처리 대상 자료를 조회한다<br>
	 * 
	 * @param fletCtrtNo String
	 * @param fromPayDt String
	 * @param toPayDt String
	 * @param appFlg String
	 * @return List<SearchChaterInvoiceSdmsListVO>
	 * @exception EventException
	 */
	public List<SearchChaterInvoiceSdmsListVO> searchChaterInvoiceSdmsList(String fletCtrtNo, String fromPayDt, String toPayDt, String appFlg) throws EventException {
		try {
			return dbDao.searchChaterInvoiceSdmsList(fletCtrtNo, fromPayDt, toPayDt, appFlg);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("FMS01125",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01125",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * SDMS INV No. 가져오기(존재/미존재 판단기준)<br>
	 * 
	 * @param invNo String
	 * @return String
	 * @exception EventException
	 */
    public String checkSdmsInvoiceNo(String invNo) throws EventException {
		try {
			return dbDao.searchCheckSdmsInvoiceNo(invNo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01176",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01176",new String[]{}).getMessage(), ex);
		}
	}
    
    /**
	 * Hire No. 가져오기(존재/미존재 판단기준)<br>
	 * 
	 * @param fletCtrtNo String 
	 * @param hireNo String
	 * @return String
	 * @exception EventException
	 */
    public String searchHireNo(String fletCtrtNo, String hireNo) throws EventException {
		try {
			return dbDao.searchCheckHireNo(fletCtrtNo, hireNo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01189",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01189",new String[]{}).getMessage(), ex);
		}
	}
    
    
    
    /**
	 * 선주 대행 비용을 선주 비용 지불 시 차감하기 위해 기 등록된 미수 계정을 비교하여 조회 하는 작업이다<br>
	 * 조건대로 자료를 조회한다<br>
	 * 
	 * @param condSearchOwnerInvoiceVO CondSearchOwnerInvoiceVO
	 * @return List<SearchOwnerInvoiceListVO>
	 * @exception EventException
	 */
	public List<SearchOwnerInvoiceListVO> searchGlInquiryOwnerInvoiceList(CondSearchOwnerInvoiceVO condSearchOwnerInvoiceVO) throws EventException {
		try {
			
			condSearchOwnerInvoiceVO.setLdgrDt(condSearchOwnerInvoiceVO.getLdgrDt().replaceAll("-", ""));
			condSearchOwnerInvoiceVO.setEffDt1(condSearchOwnerInvoiceVO.getEffDt1().replaceAll("-", ""));
			condSearchOwnerInvoiceVO.setEffDt2(condSearchOwnerInvoiceVO.getEffDt2().replaceAll("-", ""));
			return dbDao.searchGlInquiryOwnerInvoiceList(condSearchOwnerInvoiceVO);
			
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(" FMS01115",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(" FMS01115",new String[]{}).getMessage(), ex);
		}
	}
		
//###################################################################################################	
//###################################################################################################
//###################################################################################################	
    /**
	 * Off-Hire Expenses CNFM 정보를 조회한다<br>
	 * 
	 * @param SearchOffhireExpensesListVO vo
	 * @return List<SearchOffhireExpensesListVO>
	 * @throws EventException
	 */
	public List<SearchOffhireExpensesListVO> searchOffhireCnfmList(SearchOffhireExpensesListVO vo) throws EventException {
		try {
			return dbDao.searchOffhireCnfmList(vo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("FMS01125",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01125",new String[]{}).getMessage(), ex);
		}
	}
		
	/**
	 * FMS VNOR ITEM을 수정한다.<br>
	 * 
	 * @param searchOffhireExpensesListVOs SearchOffhireExpensesListVO[]
	 * @param usrId String
	 * @param vnorItmProcCd String
	 * @exception EventException
	 */
	public void modifyVnorItm(SearchOffhireExpensesListVO[] searchOffhireExpensesListVOs, String usrId, String vnorItmProcCd) throws EventException{
		try {			
			
			FmsVnorItmVO fmsVnorItmVO = null;
			List<FmsVnorItmVO> modifyVoList = new ArrayList<FmsVnorItmVO>();
						
			for ( int i=0; i<searchOffhireExpensesListVOs.length; i++ ) {
				if ( searchOffhireExpensesListVOs[i].getIbflag().equals("U")){
					fmsVnorItmVO = new FmsVnorItmVO();
					fmsVnorItmVO.setVslCd(searchOffhireExpensesListVOs[i].getVslCd());
					fmsVnorItmVO.setVnorSeq(searchOffhireExpensesListVOs[i].getVnorSeq());
					fmsVnorItmVO.setVnorItmSeq(searchOffhireExpensesListVOs[i].getVnorItmSeq());	
					fmsVnorItmVO.setVnorItmFletRmk(searchOffhireExpensesListVOs[i].getVnorItmFletRmk());
					fmsVnorItmVO.setVnorItmProcCd(vnorItmProcCd);									
					fmsVnorItmVO.setCreUsrId(usrId);					
					modifyVoList.add(fmsVnorItmVO);
				}
			}
			
			if ( modifyVoList.size() > 0 ) {
				dbDao.modifyVnorItm(modifyVoList);
			}
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS01306",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS01306",new String[]{}).getMessage(), de);
		}
	}	
	
	/**
	 * Off-Hire Expenses 정보를 저장한다.<br>
	 * 
	 * @param searchOffhireExpensesListVOs SearchOffhireExpensesListVO[]
	 * @param usrId String
	 * @exception EventException
	 */
	public void manageOffhireExpenses(SearchOffhireExpensesListVO[] searchOffhireExpensesListVOs, String usrId) throws EventException{
		try {			
			
			FmsVnorVO fmsVnorVO = null;
			FmsVnorItmVO fmsVnorItmVO = null;
			
			List<FmsVnorVO> addVoList = new ArrayList<FmsVnorVO>();			
//			List<FmsVnorVO> updateVoList = new ArrayList<FmsVnorVO>();
			List<FmsVnorVO> deleteVoList = new ArrayList<FmsVnorVO>();
						
			List<FmsVnorItmVO> addItmVoList = new ArrayList<FmsVnorItmVO>();			
			List<FmsVnorItmVO> updateItmVoList = new ArrayList<FmsVnorItmVO>();
			List<FmsVnorItmVO> deleteItmVoList = new ArrayList<FmsVnorItmVO>();
						
			for ( int i=0; i<searchOffhireExpensesListVOs.length; i++ ) {
				
				fmsVnorVO = new FmsVnorVO();
				
				fmsVnorVO.setVslCd(searchOffhireExpensesListVOs[i].getVslCd());
				fmsVnorVO.setVnorSeq(searchOffhireExpensesListVOs[i].getVnorSeq());				
				fmsVnorVO.setVslCd(searchOffhireExpensesListVOs[i].getVslCd());				
				fmsVnorVO.setVnorOffhFmDt(searchOffhireExpensesListVOs[i].getVnorOffhFmDt()+searchOffhireExpensesListVOs[i].getVnorOffhFmDtHm());
				fmsVnorVO.setVnorOffhToDt(searchOffhireExpensesListVOs[i].getVnorOffhToDt()+searchOffhireExpensesListVOs[i].getVnorOffhToDtHm());								
				fmsVnorVO.setCrChkFlg(searchOffhireExpensesListVOs[i].getCrChkFlg());
				fmsVnorVO.setSkdVoyNo(searchOffhireExpensesListVOs[i].getSkdVoyNo());
				fmsVnorVO.setSkdDirCd(searchOffhireExpensesListVOs[i].getSkdDirCd());
				fmsVnorVO.setVnorOffhKndCd(searchOffhireExpensesListVOs[i].getVnorOffhKndCd());
				fmsVnorVO.setVnorOffhTpCd(searchOffhireExpensesListVOs[i].getVnorOffhTpCd());
				fmsVnorVO.setVnorVslStsCd(searchOffhireExpensesListVOs[i].getVnorVslStsCd());
				fmsVnorVO.setVnorFmPortCd(searchOffhireExpensesListVOs[i].getVnorFmPortCd());
				fmsVnorVO.setVnorToPortCd(searchOffhireExpensesListVOs[i].getVnorToPortCd());
				fmsVnorVO.setCreUsrId(usrId);
				fmsVnorVO.setUpdUsrId(usrId);										
												
				fmsVnorItmVO = new FmsVnorItmVO();

				fmsVnorItmVO.setVslCd(searchOffhireExpensesListVOs[i].getVslCd());
				fmsVnorItmVO.setVnorSeq(searchOffhireExpensesListVOs[i].getVnorSeq());
				fmsVnorItmVO.setVnorItmSeq(searchOffhireExpensesListVOs[i].getVnorItmSeq());
				fmsVnorItmVO.setVnorMnItmFlg(searchOffhireExpensesListVOs[i].getVnorMnItmFlg());
				fmsVnorItmVO.setVnorItmCd(searchOffhireExpensesListVOs[i].getVnorItmCd());
				fmsVnorItmVO.setVnorItmOfcCd(searchOffhireExpensesListVOs[i].getVnorItmOfcCd());
				fmsVnorItmVO.setVnorItmUtCd(searchOffhireExpensesListVOs[i].getVnorItmUtCd());				
				fmsVnorItmVO.setVnorItmVal(searchOffhireExpensesListVOs[i].getVnorItmVal());
				fmsVnorItmVO.setVnorItmRmk(searchOffhireExpensesListVOs[i].getVnorItmRmk());
				fmsVnorItmVO.setVnorItmFletRmk(searchOffhireExpensesListVOs[i].getVnorItmFletRmk());
				fmsVnorItmVO.setAtchFileFletLnkId(searchOffhireExpensesListVOs[i].getAtchFileFletLnkId());
				fmsVnorItmVO.setAtchFileOpKnt(searchOffhireExpensesListVOs[i].getAtchFileOpKnt());				
				fmsVnorItmVO.setAtchFileOpLnkId(searchOffhireExpensesListVOs[i].getAtchFileOpLnkId());				
				fmsVnorItmVO.setAtchFileFletKnt(searchOffhireExpensesListVOs[i].getAtchFileFletKnt());
				fmsVnorItmVO.setVnorItmFletAddCd(searchOffhireExpensesListVOs[i].getVnorItmFletAddCd());
				fmsVnorItmVO.setVnorItmProcCd("C");
				fmsVnorItmVO.setVnorItmRsltCd(searchOffhireExpensesListVOs[i].getVnorItmRsltCd());
				fmsVnorItmVO.setFletCtrtNo(searchOffhireExpensesListVOs[i].getFletCtrtNo());				
				fmsVnorItmVO.setFletIssTpCd(searchOffhireExpensesListVOs[i].getFletIssTpCd());
				fmsVnorItmVO.setInvSeq(searchOffhireExpensesListVOs[i].getInvSeq());
				fmsVnorItmVO.setInvDtlSeq(searchOffhireExpensesListVOs[i].getInvDtlSeq());
				fmsVnorItmVO.setCreUsrId(usrId);								
				fmsVnorItmVO.setUpdUsrId(usrId);
				
				
				if ( searchOffhireExpensesListVOs[i].getIbflag().equals("I")){
					addVoList.add(fmsVnorVO);
					addItmVoList.add(fmsVnorItmVO);					
				}else if ( searchOffhireExpensesListVOs[i].getIbflag().equals("U")){
//					updateVoList.add(fmsVnorVO);
					updateItmVoList.add(fmsVnorItmVO);										
				}else if ( searchOffhireExpensesListVOs[i].getIbflag().equals("D")){					
					deleteVoList.add(fmsVnorVO);
					deleteItmVoList.add(fmsVnorItmVO);					
				}
			}
									
			if ( addVoList.size() > 0 ) {
				for(int i=0; i<addVoList.size(); i++){
					String vnorSeq = dbDao.searchVnorSeq(addVoList.get(i).getVslCd());
					
					addVoList.get(i).setVnorSeq(vnorSeq);		
					addItmVoList.get(i).setVnorSeq(vnorSeq);
					dbDao.addVnor(addVoList.get(i));
					dbDao.addVnorItm(addItmVoList.get(i));
				}				
			}
			if ( updateItmVoList.size() > 0 ) {
//				dbDao.updateVnor(updateVoList);
//				dbDao.updateVnorItm(updateItmVoList);
				dbDao.modifyAuditComment(updateItmVoList);
				
			}				
			if ( deleteVoList.size() > 0 ) {
				dbDao.deleteVnor(deleteVoList);
				dbDao.deleteVnorItm(deleteItmVoList);
			}														
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS01306",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS01306",new String[]{}).getMessage(), de);
		}		
	}
	
	/**
	 * Off-Hire Expenses 정보에서 FMS VNOR Seq를 조회한다.<br>
	 * 
	 * @param vslCd String
	 * @param vnorOffhFmDt String
	 * @param vnorOffhToDt String
	 * @param crChkFlg String  
	 * @return int
     * @throws Exception
     */
	public int searchVnorSeq(String vslCd, String vnorOffhFmDt, String vnorOffhToDt, String crChkFlg) throws EventException{
		int retVal = 0;
        try {
        	String sRetVal = dbDao.searchVnorSeq(vslCd, vnorOffhFmDt, vnorOffhToDt,crChkFlg);        	
        	retVal = Integer.parseInt(sRetVal);        	
        } catch (DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("FMS01306", new String[] {}).getMessage(), de);
        } catch (Exception e) {
            log.error("err " + e.toString(), e);
            throw new EventException(new ErrorHandler("FMS01306", new String[] {}).getMessage(), e);
        }
        return retVal;
	}		
				
	
	/**
	 * Off-Hire Expenses 정보에서 FMS VNOR Itm Seq를 조회한다.<br>
	 * 
	 * @param vslCd String
	 * @param vnorOffhFmDt String
	 * @param vnorOffhToDt String 
	 * @param crChkFlg String
	 * @return int
	 * @exception EventException
     */
	public int searchVnorItmSeq(String vslCd, String vnorOffhFmDt, String vnorOffhToDt, String crChkFlg) throws EventException{
		int retVal = 0;
        try {
        	String sRetVal = dbDao.searchVnorItmSeq(vslCd, vnorOffhFmDt, vnorOffhToDt,crChkFlg);        	
        	retVal = Integer.parseInt(sRetVal);        	
        } catch (DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("FMS01306", new String[] {}).getMessage(), de);
        } catch (Exception e) {
            log.error("err " + e.toString(), e);
            throw new EventException(new ErrorHandler("FMS01306", new String[] {}).getMessage(), e);
        }
        return retVal;
	}		
	
	
	/**
	 * Off-Hire Expenses 정보에서 FMS VNOR를 저장한다.<br>
	 * 
	 * @param fmsVnorVO FmsVnorVO
	 * @exception EventException
	 */
	public void addFmsVnor(FmsVnorVO fmsVnorVO) throws EventException{
		try {											
			dbDao.addVnor(fmsVnorVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS01306",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS01306",new String[]{}).getMessage(), de);
		}		
	}		
	
	/**
	 * Off-Hire Expenses 정보에서 FMS VNOR ITEM을 저장한다.<br>
	 * 
	 * @param fmsVnorItmVO FmsVnorItmVO
	 * @exception EventException
	 */
	public void addFmsVnorItm(FmsVnorItmVO fmsVnorItmVO) throws EventException{
		try {											
			dbDao.addVnorItm(fmsVnorItmVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS01306",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS01306",new String[]{}).getMessage(), de);
		}		
	}			
	
	/**
	 * Audit Comment를 수정한다.<br>
	 * 
	 * @param searchOffhireExpensesListVOs SearchOffhireExpensesListVO[]
	 * @param usrId String
	 * @exception EventException
	 */
	public void modifyAuditComment(SearchOffhireExpensesListVO[] searchOffhireExpensesListVOs, String usrId) throws EventException{
		try {			
			
			FmsVnorItmVO fmsVnorItmVO = null;
			List<FmsVnorItmVO> modifyVoList = new ArrayList<FmsVnorItmVO>();
						
			for ( int i=0; i<searchOffhireExpensesListVOs.length; i++ ) {
				if ( searchOffhireExpensesListVOs[i].getIbflag().equals("U")){
					fmsVnorItmVO = new FmsVnorItmVO();
					fmsVnorItmVO.setVslCd(searchOffhireExpensesListVOs[i].getVslCd());
					fmsVnorItmVO.setVnorSeq(searchOffhireExpensesListVOs[i].getVnorSeq());
					fmsVnorItmVO.setVnorItmSeq(searchOffhireExpensesListVOs[i].getVnorItmSeq());
					fmsVnorItmVO.setVnorItmFletRmk(searchOffhireExpensesListVOs[i].getVnorItmFletRmk());
					fmsVnorItmVO.setUpdUsrId(usrId);	
					modifyVoList.add(fmsVnorItmVO);
				}
			}
			
			if ( modifyVoList.size() > 0 ) {
				dbDao.modifyAuditComment(modifyVoList);
			}
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS01306",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS01306",new String[]{}).getMessage(), de);
		}
	}
	
	/**
	 * Retrieve 조회<br>
	 * [ESM_FMS_0097] (New) Owner’s Account<br>
	 * 
	 * @param CondSearchOwnerAccountVO condSearchOwnerAccountVO
	 * @return List<SearchNewOwnerAccountListVO>
	 * @exception EventException
	 */
	public List<SearchNewOwnerAccountListVO> searchNewOwnerAccountList(CondSearchOwnerAccountVO condSearchOwnerAccountVO) throws EventException {
		try {
			return dbDao.searchNewOwnerAccountList(condSearchOwnerAccountVO);
		} catch (DAOException ex) {
			// Account Code 조회 실패
			throw new EventException(new ErrorHandler("FMS01115",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			// Account Code 조회 실패
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01115",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Save 저장<br>
	 * [ESM_FMS_0097] (New) Owner’s Account<br>
	 * 
	 * @param searchNewOwnerAccountListVOs SearchNewOwnerAccountListVO[]
	 * @param usrId String
	 * @exception EventException
	 */
	public void manageNewOwnerAccount(SearchNewOwnerAccountListVO[] searchNewOwnerAccountListVOs, String usrId) throws EventException {
		try {
			List<SearchNewOwnerAccountListVO> modifyVoList	= new ArrayList<SearchNewOwnerAccountListVO>();
			
			if(searchNewOwnerAccountListVOs != null) {
				for(int i=0; i<searchNewOwnerAccountListVOs.length; i++) {
					if(searchNewOwnerAccountListVOs[i].getIbflag().equals("U")) {
						searchNewOwnerAccountListVOs[i].setUsrId(usrId);
						searchNewOwnerAccountListVOs[i].setVslCd(searchNewOwnerAccountListVOs[i].getVvd().substring(0,4));
						searchNewOwnerAccountListVOs[i].setSkdVoyNo(searchNewOwnerAccountListVOs[i].getVvd().substring(4,8));
						searchNewOwnerAccountListVOs[i].setSkdDirCd(searchNewOwnerAccountListVOs[i].getVvd().substring(8,9));
						searchNewOwnerAccountListVOs[i].setRevDirCd(searchNewOwnerAccountListVOs[i].getVvd().substring(9,10));
						
						modifyVoList.add(searchNewOwnerAccountListVOs[i]);
						
//					} else if(searchNewOwnerAccountListVOs[i].getIbflag().equals("I")) {
//						// The event will not happen
//						
//					} else if(searchNewOwnerAccountListVOs[i].getIbflag().equals("D")) {
//						// The event will not happen
					}
				}
				
				//FMS_OWNR_ACCT_SLP 테이블 데이타 수정
				if(modifyVoList.size() > 0) {
					dbDao.modifytNewOwnerAccount(modifyVoList);
				}
				
			}
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS01107",new String[]{}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01107",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * VVD 체크<br>
	 * [ESM_FMS_0097] (New) Owner’s Account<br>
	 * 
	 * @param strVvd String
	 * @return Boolean
	 * @exception EventException
	 */
	public Boolean checkVvdInFmsCntrct(String strVvd) throws EventException {
		try {
			return dbDao.checkVvdInFmsCntrct(strVvd);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS01144",new String[]{}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01144",new String[]{}).getMessage(), ex);
		}
	}
	
//#####################################################################################################
	   /**
	   * FRGN Exchange Transaction(O/A) 정보를 조회한다<br>
	   * 
	   * @param FrgnExchangeTransactionVO vo
	   * @return List<FrgnExchangeTransactionVO>
	   * @throws EventException
	   */
	  public List<FrgnExchangeTransactionVO> searchFrgnExchangeTransactionList(FrgnExchangeTransactionVO vo) throws EventException {
		 	try {
				return dbDao.searchFrgnExchangeTransactionList(vo);
			} catch (DAOException ex) {
				throw new EventException(new ErrorHandler("FMS01125",new String[]{}).getMessage(), ex);
			} catch (Exception ex) {
				log.error("err " + ex.toString(), ex);
				throw new EventException(new ErrorHandler("FMS01125",new String[]{}).getMessage(), ex);
			}
	   }
	 
	  /**
	   * FRGN Exchange Transaction(O/A)를 수정한다.<br>
	   * 
	   * @param FrgnExchangeTransactionVO frgnExchangeTransactionVO
	   * @param FrgnExchangeVO[] frgnExchangeVOs 
	   * @param SignOnUserAccount signOnUserAccount
	   * @return String
	   * @exception EventException
	   */
	  public String  manageFrgmExchangeTransaction(FrgnExchangeTransactionVO frgnExchangeTransactionVO ,FrgnExchangeVO[] frgnExchangeVOs, SignOnUserAccount signOnUserAccount) throws EventException{
		        FmsConsultationVO fmsConsultationVO = null;
		        FmsCsulSlpVO fmsCsulSlpVO = null; //orgin csr 처리 vo
		        FmsCsulSlpVO fmsCsulSlpVO1 = null;//취소전표 csr 처리 vo
		        FmsCsulSlpVO fmsCsulSlpVO2 = null; // 대차전표 csr 처리 vo
		        List<FmsCsulSlpVO> fmsCsulSlpList = null;
		        List<SearchCsrInfoVO> searchCsrInfoVOs = null;
		        List<SearchCsrInfoVO> searchCsrInfoVOsCancel = null;
		        int selSeqNo = 0;
		        String effMinDate[] = new String[2];
		        String csrDesc = "";
		        String newCsrNo ="";
		        String ofc_cd  = "";
		        double orgingAmt = (double) 0.0;
		        double cancellAmt = (double) 0.0;
		        double payAmt = (double) 0.0;
		       
			try {
				
				// SLP_SER_NO를 조회를 해온다.
			    String slpSerNo = dbDao1.searchCsulSlpSeq( "07" , "S", frgnExchangeTransactionVO.getSupplierCd());
			    effMinDate = dbDao.searchEffMinDate(frgnExchangeTransactionVO.getSupplierCd());
				if (slpSerNo.equals("00001")) {
					dbDao1.addCsulSlpSeq ( "07" , "S", frgnExchangeTransactionVO.getSupplierCd() , slpSerNo , signOnUserAccount.getUsr_id() );
				} else {
					dbDao1.modifyCsulSlpSeq ( "07" , "S", frgnExchangeTransactionVO.getSupplierCd() , slpSerNo , signOnUserAccount.getUsr_id() );
				}
				ofc_cd = frgnExchangeTransactionVO.getSupplierCd();
				fmsCsulSlpList = new ArrayList<FmsCsulSlpVO>();
				
				// FMS_CONSULTATION 입력 
				fmsConsultationVO = new FmsConsultationVO();
				fmsConsultationVO.setSlpTpCd("07");
				fmsConsultationVO.setSlpFuncCd("S");
				fmsConsultationVO.setSlpSerNo(slpSerNo);
				fmsConsultationVO.setSlpIssDt(effMinDate[1]);
				fmsConsultationVO.setSlpOfcCd(ofc_cd);
				fmsConsultationVO.setCsrCurrCd("USD");
				fmsConsultationVO.setCsrAmt("0");
				fmsConsultationVO.setCsrUsrId(signOnUserAccount.getUsr_id());
				if(frgnExchangeTransactionVO.getFromEffDt().equals(frgnExchangeTransactionVO.getToEffDt())){
					csrDesc = frgnExchangeTransactionVO.getFromEffDt() +"월 O/A 취소 전표 외환차익/차손 정리";
					fmsConsultationVO.setCsrDesc(csrDesc);
				}else {
					csrDesc = frgnExchangeTransactionVO.getFromEffDt() +"~"+ frgnExchangeTransactionVO.getToEffDt() +"월 O/A 취소 전표 외환차익/차손 정리";
					fmsConsultationVO.setCsrDesc(csrDesc);
				}
				fmsConsultationVO.setDiffAmt("0");
				fmsConsultationVO.setRqstAmt("0");
				fmsConsultationVO.setRqstDt(effMinDate[0]);
				fmsConsultationVO.setEffDt(effMinDate[0]);
				fmsConsultationVO.setEvidTpCd("5");
				fmsConsultationVO.setAproFlg("N");
				fmsConsultationVO.setCxlFlg("N");
				fmsConsultationVO.setMnlTpFlg("N");
				fmsConsultationVO.setCreUsrId(signOnUserAccount.getUsr_id());
				fmsConsultationVO.setUpdUsrId(signOnUserAccount.getUsr_id());
				//fmsConsultationVO.setOaInvDt(effMinDate[0]);
				
				// FMS_CONSULTATION 저장
				dbDao.addFmsConsultation(fmsConsultationVO);
				
				newCsrNo = fmsConsultationVO.getSlpTpCd() + fmsConsultationVO.getSlpFuncCd() + fmsConsultationVO.getSlpOfcCd() + fmsConsultationVO.getSlpIssDt() + fmsConsultationVO.getSlpSerNo();
				
				log.debug("### newCsrNo = "+newCsrNo);
				log.debug("### frgnExchangeVOs.length = "+frgnExchangeVOs.length);				
								
				for ( int i=0; i<frgnExchangeVOs.length; i++ ) {
					if ( frgnExchangeVOs[i].getSelectCheck().equals("1")){
						//orgin csr no 조회 
						// 2018.05.02 getSlpOfcCd 에서 getSupplierCd 로 변경
						searchCsrInfoVOs = dbDao.searchCsrInfo(frgnExchangeTransactionVO.getSupplierCd() ,frgnExchangeVOs[i].getOri1CsrNo());
						if(searchCsrInfoVOs != null){
							
							log.debug(i);
							selSeqNo = selSeqNo + 1 ;
							
							fmsCsulSlpVO = new FmsCsulSlpVO();
							fmsCsulSlpVO.setSlpTpCd("07");
							fmsCsulSlpVO.setSlpFuncCd("S");
							fmsCsulSlpVO.setSlpOfcCd(fmsConsultationVO.getSlpOfcCd());
							fmsCsulSlpVO.setSlpIssDt(effMinDate[1]);
							fmsCsulSlpVO.setSlpSerNo(slpSerNo);
							log.debug("### selSeqNo22 = "+selSeqNo);							
							fmsCsulSlpVO.setSlpSeqNo(Integer.toString(selSeqNo));
							fmsCsulSlpVO.setAcctCd("111071");
							fmsCsulSlpVO.setCtrCd(searchCsrInfoVOs.get(0).getCtrCd());
							fmsCsulSlpVO.setSlpLocCd(searchCsrInfoVOs.get(0).getLocCd());
							fmsCsulSlpVO.setCsrCurrCd("USD");
							orgingAmt = Double.parseDouble(searchCsrInfoVOs.get(0).getN1stAmt());
							if(orgingAmt > 0) {
								fmsCsulSlpVO.setCsrAmt("-"+ Double.toString(Math.abs(orgingAmt)));	
							}else {
								fmsCsulSlpVO.setCsrAmt(Double.toString(Math.abs(orgingAmt)));
							}
							fmsCsulSlpVO.setCsrDesc(searchCsrInfoVOs.get(0).getApDesc() + " (" + frgnExchangeVOs[i].getOri1CsrNo() + ")");
							fmsCsulSlpVO.setVndrSeq(searchCsrInfoVOs.get(0).getVndrSeq());
							fmsCsulSlpVO.setVatFlg("N");
							fmsCsulSlpVO.setStlFlg("N");
							fmsCsulSlpVO.setFletSrcTpCd("90");
							fmsCsulSlpVO.setVslCd(searchCsrInfoVOs.get(0).getVslCd());
							fmsCsulSlpVO.setSkdVoyNo(searchCsrInfoVOs.get(0).getSkdVoyNo());
							fmsCsulSlpVO.setSkdDirCd(searchCsrInfoVOs.get(0).getSkdDirCd());
							fmsCsulSlpVO.setRevDirCd(searchCsrInfoVOs.get(0).getSkdDirCd());
							fmsCsulSlpVO.setCreUsrId(signOnUserAccount.getUsr_id());
							fmsCsulSlpVO.setUpdUsrId(signOnUserAccount.getUsr_id());
							fmsCsulSlpVO.setOrgSlpTpCd(searchCsrInfoVOs.get(0).getSlpTpCd());
							fmsCsulSlpVO.setOrgSlpFuncCd(searchCsrInfoVOs.get(0).getSlpFuncCd());
							fmsCsulSlpVO.setOrgSlpOfcCd(searchCsrInfoVOs.get(0).getSlpOfcCd());
							fmsCsulSlpVO.setOrgIssDt(searchCsrInfoVOs.get(0).getSlpIssDt());
							fmsCsulSlpVO.setOrgSlpSerNo(searchCsrInfoVOs.get(0).getSlpSerNo());
							fmsCsulSlpVO.setOrgSlpSeqNo(searchCsrInfoVOs.get(0).getSlpSeqNo());
							fmsCsulSlpVO.setCreUsrId(signOnUserAccount.getUsr_id());		// 추가
							fmsCsulSlpVO.setUpdUsrId(signOnUserAccount.getUsr_id());		// 추가													
							fmsCsulSlpList.add(fmsCsulSlpVO);
						}
						
						
						//취소전표 csr no 조회 
						// 2018.05.02 getSlpOfcCd 에서 getSupplierCd 로 변경
						 searchCsrInfoVOsCancel = dbDao.searchCsrInfo(frgnExchangeTransactionVO.getSupplierCd() ,frgnExchangeVOs[i].getOri2CsrNo());
						
						if(searchCsrInfoVOsCancel != null){							
							selSeqNo = selSeqNo + 1 ;
														
							fmsCsulSlpVO1 = new FmsCsulSlpVO();
							fmsCsulSlpVO1.setSlpTpCd("07");
							fmsCsulSlpVO1.setSlpFuncCd("S");
							fmsCsulSlpVO1.setSlpOfcCd(fmsConsultationVO.getSlpOfcCd());
							fmsCsulSlpVO1.setSlpIssDt(effMinDate[1]);
							log.debug("### selSeqNo44 = "+selSeqNo);
							fmsCsulSlpVO1.setSlpSerNo(slpSerNo);
							fmsCsulSlpVO1.setSlpSeqNo(Integer.toString(selSeqNo));
							fmsCsulSlpVO1.setAcctCd("111071");
							fmsCsulSlpVO1.setCtrCd(searchCsrInfoVOsCancel.get(0).getCtrCd());
							fmsCsulSlpVO1.setSlpLocCd(searchCsrInfoVOsCancel.get(0).getLocCd());
							fmsCsulSlpVO1.setCsrCurrCd("USD");
							cancellAmt = Double.parseDouble(searchCsrInfoVOsCancel.get(0).getN1stAmt());
							
							if(cancellAmt > 0) {
								fmsCsulSlpVO1.setCsrAmt("-"+ Double.toString(Math.abs(cancellAmt)));	
							}else {
								fmsCsulSlpVO1.setCsrAmt(Double.toString(Math.abs(cancellAmt)));
							}
							fmsCsulSlpVO1.setCsrDesc(searchCsrInfoVOsCancel.get(0).getApDesc() + " (" + frgnExchangeVOs[i].getOri2CsrNo() + ")");
							fmsCsulSlpVO1.setVndrSeq(searchCsrInfoVOsCancel.get(0).getVndrSeq());
							fmsCsulSlpVO1.setVatFlg("N");
							fmsCsulSlpVO1.setStlFlg("N");
							fmsCsulSlpVO1.setFletSrcTpCd("90");
							fmsCsulSlpVO1.setVslCd(searchCsrInfoVOsCancel.get(0).getVslCd());
							fmsCsulSlpVO1.setSkdVoyNo(searchCsrInfoVOsCancel.get(0).getSkdVoyNo());
							fmsCsulSlpVO1.setSkdDirCd(searchCsrInfoVOsCancel.get(0).getSkdDirCd());
							fmsCsulSlpVO1.setRevDirCd(searchCsrInfoVOsCancel.get(0).getSkdDirCd());
							fmsCsulSlpVO1.setCreUsrId(signOnUserAccount.getUsr_id());
							fmsCsulSlpVO1.setUpdUsrId(signOnUserAccount.getUsr_id());
							fmsCsulSlpVO1.setOrgSlpTpCd(searchCsrInfoVOsCancel.get(0).getSlpTpCd());
							fmsCsulSlpVO1.setOrgSlpFuncCd(searchCsrInfoVOsCancel.get(0).getSlpFuncCd());
							fmsCsulSlpVO1.setOrgSlpOfcCd(searchCsrInfoVOsCancel.get(0).getSlpOfcCd());
							fmsCsulSlpVO1.setOrgIssDt(searchCsrInfoVOsCancel.get(0).getSlpIssDt());
							fmsCsulSlpVO1.setOrgSlpSerNo(searchCsrInfoVOsCancel.get(0).getSlpSerNo());
							fmsCsulSlpVO1.setOrgSlpSeqNo(searchCsrInfoVOsCancel.get(0).getSlpSeqNo());
				        	fmsCsulSlpVO1.setCreUsrId(signOnUserAccount.getUsr_id());		// 추가
				        	fmsCsulSlpVO1.setUpdUsrId(signOnUserAccount.getUsr_id());		// 추가						
							fmsCsulSlpList.add(fmsCsulSlpVO1);
						}
						   // 대차전표 생성 
						if(searchCsrInfoVOs != null && searchCsrInfoVOsCancel != null){
					        if( searchCsrInfoVOs.size() > 0 && searchCsrInfoVOsCancel.size() > 0 ){				        	
					        	selSeqNo = selSeqNo + 1 ;
												        	
					        	fmsCsulSlpVO2 = new FmsCsulSlpVO();
					        	fmsCsulSlpVO2.setSlpTpCd("07");
					        	fmsCsulSlpVO2.setSlpFuncCd("S");
					        	fmsCsulSlpVO2.setSlpOfcCd(fmsConsultationVO.getSlpOfcCd());
					        	fmsCsulSlpVO2.setSlpIssDt(effMinDate[1]);
					        	log.debug("### selSeqNo66 = "+selSeqNo);
					        	fmsCsulSlpVO2.setSlpSerNo(slpSerNo);
					        	fmsCsulSlpVO2.setSlpSeqNo(Integer.toString(selSeqNo));
					        	fmsCsulSlpVO2.setCtrCd(searchCsrInfoVOsCancel.get(0).getCtrCd());
					        	fmsCsulSlpVO2.setSlpLocCd(searchCsrInfoVOsCancel.get(0).getLocCd());
					        	fmsCsulSlpVO2.setCsrCurrCd("USD");
					        	payAmt = Math.abs(orgingAmt)  -  Math.abs(cancellAmt);
					        	if (payAmt > 0){				        	
					        		fmsCsulSlpVO2.setAcctCd("580111");
					        		fmsCsulSlpVO2.setCsrDesc(searchCsrInfoVOsCancel.get(0).getVslCd()+searchCsrInfoVOsCancel.get(0).getSkdVoyNo()+searchCsrInfoVOsCancel.get(0).getSkdDirCd() +"OA 외환차손" + " (" + frgnExchangeVOs[i].getOri1CsrNo() + "-" + frgnExchangeVOs[i].getOri2CsrNo() + ")");
					        		fmsCsulSlpVO2.setCsrAmt(Double.toString(payAmt));
					        	}else{
					        		fmsCsulSlpVO2.setAcctCd("421211");
					        		fmsCsulSlpVO2.setCsrDesc(searchCsrInfoVOsCancel.get(0).getVslCd()+searchCsrInfoVOsCancel.get(0).getSkdVoyNo()+searchCsrInfoVOsCancel.get(0).getSkdDirCd() +"OA 외환차익" + " (" + frgnExchangeVOs[i].getOri1CsrNo() + "-" + frgnExchangeVOs[i].getOri2CsrNo() + ")");
					        		fmsCsulSlpVO2.setCsrAmt(Double.toString(payAmt));
					        	}
					        	fmsCsulSlpVO2.setVndrSeq(searchCsrInfoVOsCancel.get(0).getVndrSeq());
					        	fmsCsulSlpVO2.setVatFlg("N");
					        	fmsCsulSlpVO2.setStlFlg("N");
					        	fmsCsulSlpVO2.setFletSrcTpCd("90");
					        	fmsCsulSlpVO2.setCreUsrId(signOnUserAccount.getUsr_id());
					        	fmsCsulSlpVO2.setUpdUsrId(signOnUserAccount.getUsr_id());
					        	fmsCsulSlpList.add(fmsCsulSlpVO2);
					        }
						}
					}
				}
				
				log.debug("### fmsCsulSlpList.size() = "+fmsCsulSlpList.size());
				
				
				  // fmsCsulSlp 저장을 한다.
				if ( fmsCsulSlpList.size() > 0 ) {
//					dbDao.modifyfmsCsulSlp(fmsCsulSlpList);				
					for(int i=0; i<fmsCsulSlpList.size(); i++){
						dbDao.insertfmsCsulSlp(fmsCsulSlpList.get(i));						
					}
				}
					manageApSlipApprovalFngn(newCsrNo, "", fmsConsultationVO.getUpdUsrId(), "00", "00", "N", "N");
					log.debug("====new csr no ====" + newCsrNo);
					createCSREPApprovalFrgn(fmsConsultationVO, searchCsrInfoVOs.get(0).getVndrSeq() ,frgnExchangeTransactionVO.getAproStep() ,signOnUserAccount);
			//	}
				
			} catch (DAOException de) {
				log.error("err " + de.toString(), de);
				throw new EventException(new ErrorHandler("FMS01306",new String[]{}).getMessage(), de);
			} catch (Exception de) {
				log.error("err " + de.toString(), de);
				throw new EventException(new ErrorHandler("FMS01306",new String[]{}).getMessage(), de);
			}
			
			return newCsrNo;
		}

	 
	  /**
		 * 용선인 경우 전표가 승인되면 ERP A/P 로 전송된다
		 * 
		 * @param csrNo String
		 * @param orgCsrNo String
		 * @param usrId String
		 * @param interCoCd String
		 * @param aproFlgUpdateYn String
		 * @exception EventException
		 */
		private void manageApSlipApprovalFngn(String csrNo, String orgCsrNo, String usrId, String interCoCd, String arInterCoCd, String aproFlgUpdateYn, String slipAproFlg) throws EventException {
			try {
				
				//AP 전표 Detail 계정 항목들을 조회한다
				List<SearchApSlipDetailListVO> searchApSlipDetailListVO = dbDao.searchApSlipDetailListFngn(csrNo);
				
				int listSize = searchApSlipDetailListVO.size();
				if (listSize > 0) {
					
					//회계일자 검사한다
					String effDt = dbDao.searchCheckEffectiveDateFrgn(searchApSlipDetailListVO.get(0).getSlpOfcCd(), searchApSlipDetailListVO.get(0).getEffDt());
					if (effDt.equals("")) {
						throw new EventException(new ErrorHandler("FMS01556",new String[]{}).getMessage());
					}
					
					//String taxYn = "N";

					for (int i=0; i<listSize; i++) {
						//재무항차 검사 
						if (!searchApSlipDetailListVO.get(i).getVslCd().equals("")) {
							String vslCd = dbDao.searchCheckMdmVvdCodeFrgn(searchApSlipDetailListVO.get(i).getVslCd()+ 
									searchApSlipDetailListVO.get(i).getSkdVoyNo()+
									searchApSlipDetailListVO.get(i).getSkdDirCd()+
									searchApSlipDetailListVO.get(i).getRevDirCd());

							if (vslCd.equals("")) {
								throw new EventException(new ErrorHandler("FMS01558",new String[]{}).getMessage());
							}
						}
						
						//계정 코드가 111811인 경우만 세금 정보 넣음
						//if (searchApSlipDetailListVO.get(i).getAcctCd().equals("111811")) {
							//taxYn = "Y";
						//}
						
					}
					
					//Vendor 검사한다
					List<SearchSlipApprovalOwnerVO> searchSlipApprovalOwnerVO = dbDao.searchSlipApprovalOwnerFrgn(searchApSlipDetailListVO.get(0).getVndrSeq(), searchApSlipDetailListVO.get(0).getCustCntCd(), searchApSlipDetailListVO.get(0).getCustSeq());
					
					if (searchSlipApprovalOwnerVO.size() == 0) {
						throw new EventException(new ErrorHandler("FMS01345",new String[]{}).getMessage());
					}
					
					//AP Header(AP_INV_HDR) 테이블에 넣을 VO를 생성한다
//					String evidTpCd = searchApSlipDetailListVO.get(0).getEvidTpCd();
					CustomSlipApprovalHeaderVO customSlipApprovalHeaderVO = new CustomSlipApprovalHeaderVO();

					//Slip Approval 승인 시에 Office 및 User 테이블에서 필요 항목 조회한다
					List<SearchSlipApprovalOfficeVO> searchSlipApprovalOfficeVO = dbDao.searchSlipApprovalOfficeFrgn(usrId);
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

					//String taxCode = null;
//					if (evidTpCd.equals("1")) {//세금계산서
//						//Header
//						List<SearchSlipApprovalTaxVO> searchSlipApprovalTaxVO = dbDao.searchSlipApprovalTax(orgCsrNo);
//						
//						if (searchSlipApprovalTaxVO.size() > 0) {
//							
//							//TAX_VAT_TP_CD=1 OR TAX_VAT_TP_CD=2 AND taxYn = 'Y' 인 경우만 세금계산서 내용  추가함.
//							
//							if (searchSlipApprovalTaxVO.get(0).getTaxVatTpCd().equals("1") ||						
//								 (taxYn.equals("Y") && 	searchSlipApprovalTaxVO.get(0).getTaxVatTpCd().equals("2"))) {
//								taxCode = searchSlipApprovalTaxVO.get(0).getTaxCode();
	//
//								customSlipApprovalHeaderVO.setInvDt(searchSlipApprovalTaxVO.get(0).getIssDt());
//								customSlipApprovalHeaderVO.setAttrCateNm("세금계산서");
//								customSlipApprovalHeaderVO.setAttrCtnt2(searchSlipApprovalTaxVO.get(0).getSplRgstNo());
//								customSlipApprovalHeaderVO.setAttrCtnt3(searchSlipApprovalTaxVO.get(0).getIssDtTime());
//								customSlipApprovalHeaderVO.setAttrCtnt4(searchSlipApprovalTaxVO.get(0).getSplAmt());
//								customSlipApprovalHeaderVO.setAttrCtnt5(searchSlipApprovalTaxVO.get(0).getOfcCd());
//								customSlipApprovalHeaderVO.setAttrCtnt6(searchSlipApprovalTaxVO.get(0).getTaxAmt());
//								customSlipApprovalHeaderVO.setAttrCtnt8(searchApSlipDetailListVO.get(0).getDocEvidTpCd());
	//
//								//Detail
//								List<SearchSlipApprovalTaxDetailVO> searchSlipApprovalTaxDetailVO = dbDao.searchSlipApprovalTaxDetail(orgCsrNo);
	//
//								for (int i=0; i<searchSlipApprovalTaxDetailVO.size(); i++) {
//									
//									//AP Header 만들기
//									if (i==0) {
//										customSlipApprovalHeaderVO.setGloAttrCtnt1(searchSlipApprovalTaxDetailVO.get(i).getItmNm());
//										customSlipApprovalHeaderVO.setGloAttrCtnt2(searchSlipApprovalTaxDetailVO.get(i).getSplAmt());
//										customSlipApprovalHeaderVO.setGloAttrCtnt3(searchSlipApprovalTaxDetailVO.get(i).getTaxAmt());
//									} else if (i==1) {
//										customSlipApprovalHeaderVO.setGloAttrCtnt4(searchSlipApprovalTaxDetailVO.get(i).getItmNm());
//										customSlipApprovalHeaderVO.setGloAttrCtnt5(searchSlipApprovalTaxDetailVO.get(i).getSplAmt());
//										customSlipApprovalHeaderVO.setGloAttrCtnt6(searchSlipApprovalTaxDetailVO.get(i).getTaxAmt());
//									} else if (i==2) {
//										customSlipApprovalHeaderVO.setGloAttrCtnt7(searchSlipApprovalTaxDetailVO.get(i).getItmNm());
//										customSlipApprovalHeaderVO.setGloAttrCtnt8(searchSlipApprovalTaxDetailVO.get(i).getSplAmt());
//										customSlipApprovalHeaderVO.setGloAttrCtnt9(searchSlipApprovalTaxDetailVO.get(i).getTaxAmt());
//									} else if (i==3) {
//										customSlipApprovalHeaderVO.setGloAttrCtnt10(searchSlipApprovalTaxDetailVO.get(i).getItmNm());
//										customSlipApprovalHeaderVO.setGloAttrCtnt11(searchSlipApprovalTaxDetailVO.get(i).getSplAmt());
//										customSlipApprovalHeaderVO.setGloAttrCtnt12(searchSlipApprovalTaxDetailVO.get(i).getTaxAmt());
//									}
//									
//								}
//								customSlipApprovalHeaderVO.setGloAttrCtnt13(searchSlipApprovalTaxVO.get(0).getTaxNo());
//								customSlipApprovalHeaderVO.setTaxDeclFlg("Y");
//								
//							}
//						}
//						
//					} else if (evidTpCd.equals("4")) {//계산서
//						//Bill Header
//						List<SearchSlipApprovalBillVO> searchSlipApprovalBillVO = dbDao.searchSlipApprovalBill(csrNo);
//						
//						if (searchSlipApprovalBillVO.size() > 0) {
//							taxCode = searchSlipApprovalBillVO.get(0).getTaxCode();
//							
//							customSlipApprovalHeaderVO.setInvDt(searchSlipApprovalBillVO.get(0).getIssDt());
//							customSlipApprovalHeaderVO.setAttrCateNm("계산서");
//							customSlipApprovalHeaderVO.setAttrCtnt2(searchSlipApprovalBillVO.get(0).getSplRgstNo());
//							customSlipApprovalHeaderVO.setAttrCtnt3(searchSlipApprovalBillVO.get(0).getIssDtTime());
//							customSlipApprovalHeaderVO.setAttrCtnt4(searchSlipApprovalBillVO.get(0).getSplAmt());
//							customSlipApprovalHeaderVO.setAttrCtnt5(searchSlipApprovalBillVO.get(0).getOfcCd());
//							customSlipApprovalHeaderVO.setAttrCtnt6(searchSlipApprovalBillVO.get(0).getTaxAmt());
//							customSlipApprovalHeaderVO.setAttrCtnt8(searchApSlipDetailListVO.get(0).getDocEvidTpCd());
	//
//							//Detail
//							List<SearchSlipApprovalBillDetailVO> searchSlipApprovalBillDetailVO = dbDao.searchSlipApprovalBillDetail(csrNo);
//							
//							for (int i=0; i<searchSlipApprovalBillDetailVO.size(); i++) {
//								
//								//AP Header 만들기
//								if (i==0) {
//									customSlipApprovalHeaderVO.setGloAttrCtnt1(searchSlipApprovalBillDetailVO.get(i).getItmNm());
//									customSlipApprovalHeaderVO.setGloAttrCtnt2(searchSlipApprovalBillDetailVO.get(i).getSplAmt());
//									customSlipApprovalHeaderVO.setGloAttrCtnt3("0");
//								} else if (i==1) {
//									customSlipApprovalHeaderVO.setGloAttrCtnt4(searchSlipApprovalBillDetailVO.get(i).getItmNm());
//									customSlipApprovalHeaderVO.setGloAttrCtnt5(searchSlipApprovalBillDetailVO.get(i).getSplAmt());
//									customSlipApprovalHeaderVO.setGloAttrCtnt6("0");
//								} else if (i==2) {
//									customSlipApprovalHeaderVO.setGloAttrCtnt7(searchSlipApprovalBillDetailVO.get(i).getItmNm());
//									customSlipApprovalHeaderVO.setGloAttrCtnt8(searchSlipApprovalBillDetailVO.get(i).getSplAmt());
//									customSlipApprovalHeaderVO.setGloAttrCtnt9("0");
//								} else if (i==3) {
//									customSlipApprovalHeaderVO.setGloAttrCtnt10(searchSlipApprovalBillDetailVO.get(i).getItmNm());
//									customSlipApprovalHeaderVO.setGloAttrCtnt11(searchSlipApprovalBillDetailVO.get(i).getSplAmt());
//									customSlipApprovalHeaderVO.setGloAttrCtnt12("0");
//								}
//								
//							}
//							customSlipApprovalHeaderVO.setGloAttrCtnt13(searchSlipApprovalBillVO.get(0).getBillNo());
//							customSlipApprovalHeaderVO.setTaxDeclFlg("Y");
//						}
//						
//					}
					
					customSlipApprovalHeaderVO.setSrcCtnt("CDAM");
					customSlipApprovalHeaderVO.setCoaCoCd("01");
					customSlipApprovalHeaderVO.setCoaRgnCd(searchSlipApprovalOfficeVO.get(0).getFincRgnCd());
					//customSlipApprovalHeaderVO.setCoaCtrCd(searchSlipApprovalOfficeVO.get(0).getApCtrCd());
					customSlipApprovalHeaderVO.setCoaCtrCd(searchApSlipDetailListVO.get(0).getCtrCd());
					customSlipApprovalHeaderVO.setCoaAcctCd("210111");
					customSlipApprovalHeaderVO.setCoaVvdCd("0000000000");

					//2012-02-14 하드코딩 제거 -> 화면에서 조회한 파라미터 값으로 셋팅
					//customSlipApprovalHeaderVO.setCoaInterCoCd("00");
					customSlipApprovalHeaderVO.setCoaInterCoCd(interCoCd);
					
					customSlipApprovalHeaderVO.setCoaFtuN1stCd("000000");
					customSlipApprovalHeaderVO.setCoaFtuN2ndCd("000000");
					customSlipApprovalHeaderVO.setAproFlg("Y");
					customSlipApprovalHeaderVO.setTjOfcCd(searchSlipApprovalOfficeVO.get(0).getOfcCd());
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
								customSlipApprovalDetailVO.setLineTpLuCd("ITEM");
							} else {
								customSlipApprovalDetailVO.setLineTpLuCd("MISCELLANEOUS");
							}
						} else {
							if (searchApSlipDetailListVO.get(i).getAcctCd().equals("111811")) {
								customSlipApprovalDetailVO.setLineTpLuCd("TAX");
//								customSlipApprovalDetailVO.setInvTaxCd(taxCode); 								
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

						//2012-02-14 하드코딩 제거 -> 화면에서 조회한 파라미터 값으로 셋팅
						//customSlipApprovalDetailVO.setDtrbCoaInterCoCd("00");
						customSlipApprovalDetailVO.setDtrbCoaInterCoCd(interCoCd);

						customSlipApprovalDetailVO.setDtrbCoaFtuN1stCd("000000"); 
						customSlipApprovalDetailVO.setDtrbCoaFtuN2ndCd("000000"); 
						customSlipApprovalDetailVO.setAttrCateNm(searchApSlipDetailListVO.get(i).getAcctCd());
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
					if("N".equals(aproFlgUpdateYn)){				
						//AP Header(AP_INV_HDR) 생성
						    dbDao.addApSlipApprovalHeaderFrgn(customSlipApprovalHeaderVO);
		
						    
						//AP Detail(AP_INV_DTRB) 생성
						if (insertVoList.size() > 0) {
							dbDao.addApSlipApprovalDetailsFrgn(insertVoList);
						}
					}
					
//					//201410 10만불 2차개발
//					if("Y2".equals(aproFlgUpdateYn)){
//						//해당 전표의 Apro_flg = 'Y'로 업데이트한다.
//						dbDao.modifySlipApprovalConsultation (csrNo ,usrId );
//					}
//					
//					if (slipAproFlg.equals("Y")) {  // G/W 결재 전표가 아닌 경우 - Prepayments Settlement
//						dbDao.modifySlipApprovalConsultation (csrNo ,usrId );
//					}
//					
//					
//					//AP Invoice의 Interface할 데이터를 조회한다.
//					List<SearchApSlipInterfaceListVO> searchApSlipInterfaceListVO = dbDao.searchApSlipInterfaceList(csrNo);
//					
//					//201410 10만불 2차개발
//					//AP인 경우에는 eai전송 삭제				
//					if("Y2".equals(aproFlgUpdateYn)){				
//						// AP에서는 ERP에서 전송					
//						//Send AP Invoice
//						eaiDao.sendSlipApprovalToAP(csrNo, searchApSlipInterfaceListVO, "");	
//						//AP Interface(AP_INV_IF) 입력
//						dbDao.addApSlipApprovalInterfaces(searchApSlipInterfaceListVO);
//					}   
//					
//					if (slipAproFlg.equals("Y")) {  // G/W 결재 전표가 아닌 경우 - Prepayments Settlement
//						//Send AP Invoice
//						String agmtCntYn = dbDao.searchAgmtCfmCd(csrNo);
//						
//						eaiDao.sendSlipApprovalToAP(csrNo, searchApSlipInterfaceListVO, agmtCntYn);	
//						//AP Interface(AP_INV_IF) 입력
//						dbDao.addApSlipApprovalInterfaces(searchApSlipInterfaceListVO);
//					}

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
		 * 결재라인 setting 하는 Process
		 * @param SlipProcessVO slipProcessVO
		 * @param SignOnUserAccount signOnUserAccount
		 * @throws EventException
		 */
		private void createCSREPApprovalFrgn(FmsConsultationVO fmsConsultationVO, String vederSeq, String aproStep, SignOnUserAccount signOnUserAccount) throws EventException {
			String  sCsrNo        = fmsConsultationVO.getSlpTpCd()
									+ fmsConsultationVO.getSlpFuncCd()
									+ fmsConsultationVO.getSlpOfcCd ()
									+ fmsConsultationVO.getSlpIssDt ()
									+ fmsConsultationVO.getSlpSerNo ();
			
			String  sTotalAmt     = fmsConsultationVO.getRqstAmt ();
			String  sCostOfcCd    = fmsConsultationVO.getSlpOfcCd  ();
			String  sUsrNm        = signOnUserAccount.getUsr_nm();
			
			String  sCreUsrId     = signOnUserAccount.getUsr_id();
			String  sAproStep     = aproStep;
			String  sOfcNm        = signOnUserAccount.getOfc_eng_nm();
			String  sVndrSeq      = vederSeq;
			String  sCurrCd       = fmsConsultationVO.getCsrCurrCd   ();
			String  sCntCd        = ("07".equals(fmsConsultationVO.getSlpTpCd())?"1":fmsConsultationVO.getMaxRows()+""); // Invoice 숫자? AP = 1, AR BL# 갯수? <= 권상준수석
			String  sPaymentDueDt = fmsConsultationVO.getRqstDt();
			String  sInvSubSysCd  = "FMS";				
			String  sAproKndCd    = ("07".equals(fmsConsultationVO.getSlpTpCd())?"CSR":"REV"); //AP면 CSR, AR이면 REV

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
		 * 기 작성된 Owner’s Account / Window 중 지급 전표로 처리할 항목 선정 대상 자료를 조회한다(Prepayment, Standard)<br>
		 * 
		 * @param fletCtrtNo String
		 * @param ofcCd String
		 * @param csrCurrCd String
		 * @param slpTp String
		 * @return List<OwnerAccountByPaymentSlipVO>
		 * @exception EventException
		 */
		public List<OwnerAccountByPaymentSlipVO> searchOwnerAccountListByPaymentSlip(String fletCtrtNo, String ofcCd, String csrCurrCd, String slpTp) throws EventException {
			try {
				return dbDao.searchOwnerAccountListByPaymentSlip(fletCtrtNo, ofcCd, csrCurrCd, slpTp);
			} catch (DAOException ex) {
				throw new EventException(new ErrorHandler("FMS01406",new String[]{}).getMessage(), ex);
			} catch (Exception ex) {
				log.error("err " + ex.toString(), ex);
				throw new EventException(new ErrorHandler("FMS01406",new String[]{}).getMessage(), ex);
			}
		}	
		
		/**
		 * GL 대사이후 Settle Date 를 update 한다.<br>
		 * 
		 * @param searchOwnerInvoiceListVO SearchOwnerInvoiceListVO[]
		 * @exception EventException
		 */
		public void modifySettleDate(SearchOwnerInvoiceListVO[] searchOwnerInvoiceListVO) throws EventException{
			try {
				List<SearchOwnerInvoiceListVO> modifyVoList = new ArrayList<SearchOwnerInvoiceListVO>();
				
				for (int i = 0; i < searchOwnerInvoiceListVO.length; i++) {
					modifyVoList.add(searchOwnerInvoiceListVO[i]);
				}

				if (modifyVoList.size() > 0) {
					dbDao.modifySettleDate(modifyVoList);		
				}
			} catch (DAOException de) {
				log.error("err " + de.toString(), de);
				throw new EventException(new ErrorHandler("FMS01401",new String[]{}).getMessage(), de);
			} catch (Exception de) {
				log.error("err " + de.toString(), de);
				throw new EventException(new ErrorHandler("FMS01401",new String[]{}).getMessage(), de);
			}
		}
}