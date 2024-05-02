/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TCharterIOInvoiceBCImpl.java
*@FileTitle : Charterer's Account
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.basic;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.clt.apps.opus.esm.fms.fmscommonutil.BizComFmsUtil;
import com.clt.apps.opus.esm.fms.fmscommonutil.FmsConstants;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomCsulSlpVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomPamConsultationVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomPamCsulSlpVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchArSlipDetailListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.integration.TCharterIOContractDBDAO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.SearchContractListByPrepaymentHireNoVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.SearchHireSysDateVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.SearchOtrExpnSysDateListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.integration.TCharterIOInvoiceDBDAO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.integration.TCharterIOInvoiceEAIDAO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CondCalOffhireInvoiceVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CondCharterInvoiceVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CondSearchCalPrepaymentInvoiceListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CondSearchOwnerInvoiceAutoMatchVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CondSearchOwnerInvoiceVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CustomInvDtlVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CustomInvoiceVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CustomOffInvDtlVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CustomOffInvoiceVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CustomOwnrAcctSlpVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CustomPreInvDtlVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CustomPreInvoiceVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CustomSendEmailVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.InvoiceContainerVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchCalOffhireInvoiceListSumVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchCalOffhireInvoiceListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchCalPrepaymentInvoiceListSumVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchCalPrepaymentInvoiceListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchCharterInvoiceListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchCharterInvoiceSumVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchChaterInvoiceSdmsListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchInvoiceListByRevenueSlipVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchOffhireInvoiceListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchOffhireListByPaymentSlipVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchOffhireSelectionListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchOwnerInvoiceAutoMatchListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchOwnerInvoiceListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchOwnerListByPaymentSlipVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchPrepaymentHireNoListSumVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchPrepaymentHireNoListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchPrepaymentInvoiceVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchPrepaymentListByPaymentSlipVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchVvdListByCharterVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchVvdListByOffHireVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriosettlement.vo.SearchInvoiceByPaymentSlipVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchCharterListByPaymentSlipVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.util.DateTime;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;

/**
 * OPUS-TimeCharterInOutAccounting Business Logic Basic Command implementation<br>
 * - Handling Business Logic of OPUS-TimeCharterInOutAccounting<br>
 *
 * @author 
 * @see ESM_FMS_0016EventResponse,TCharterIOInvoiceBC Reference to each DAO Class
 * @since J2EE 1.5
 */

public class TCharterIOInvoiceBCImpl extends BasicCommandSupport implements TCharterIOInvoiceBC {

	// Database Access Object
	private transient TCharterIOInvoiceDBDAO  dbDao  = null;
	private transient TCharterIOInvoiceEAIDAO eaiDao = null;
	private transient TCharterIOContractDBDAO conDbDao = null; 

	/**
	 * Generating TCharterIOInvoiceBCImpl object<br>
	 * Generating TCharterIOInvoiceDBDAO<br>
	 */
	public TCharterIOInvoiceBCImpl() {
		dbDao  = new TCharterIOInvoiceDBDAO();
		eaiDao = new TCharterIOInvoiceEAIDAO();
		conDbDao = new TCharterIOContractDBDAO();
	}
	
	/**
	 * Retrieving data on Charterer's Account window(Retrieving account related to Charterer Costs)<br>
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
	 * Retrieving data on Charterer's Account window(Retrieving account related to Charterer Costs)<br>
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
	 * Getting Voyage corresponding to fletCtrlNo and bnkYrmon<br>
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
	 * Changing Charterer Costs on Charterer's Account window<br>
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
				//[2015.06.04]fms invoice 존재 유무 판단.
				if(!dbDao.searchCharterInvoiceExist(customInvoiceVO.getFletCtrtNo())){
					customInvoiceVO.setCreUsrId(usrId);
					customInvoiceVO.setUpdUsrId(usrId);
					dbDao.addCharterInvoice(customInvoiceVO);
				}
			}
			
			if(null != customInvDtlVOs){
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
				
				//Inserting data into FmsInvDtl table
				if(addVoList.size() > 0) {
					dbDao.addCharterInvDtls(addVoList);
				}
				
				//Modifying FmsInvDtl table
				if(modifyVoList.size() > 0) {
					dbDao.modifytCharterInvDtls(modifyVoList);
				}
				
				//Deleting data in FmsInvDtl table
				if(removeVoList.size() > 0) {
					dbDao.removeCharterInvDtls(removeVoList);
				}
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
	 * Sending Email on Agreement Creation window<br>
	 * 
	 * @param customSendEmailVO CustomSendEmailVO
	 * @param keys List<String>
	 * @return String
	 * @exception EventException
	 */
    public String sendEmail(CustomSendEmailVO customSendEmailVO, List<String> keys) throws EventException {
		try {
			return eaiDao.sendEmail(customSendEmailVO, keys);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS01320",new String[]{}).getMessage(), de);
		}
	}
    
    /**
	 * Defining type of registered receivable account to balance an acting Ship Owner costs in case of paying Owner Account<br>
	 * Retrieving data as condition<br>
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
	 * Defining type of registered receivable account to balance an acting Ship Owner costs in case of paying Owner Account<br>
	 * Changing data<br>
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
	 * Retrieving Owner Invoice data automatically matching by debtor and creditor costs related to Owner's Account costs<br>
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
	 * Retrieving data on Off-Hire Expenses window(In case of clicking Creation button)<br>
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
	 * Retrieving SUM data on Off-Hire Expenses window(In case of clicking Creation button)<br>
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
	 * Getting Voyage corresponding to CtrtNo and Duration <br>
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
	 * Registering and Changing Offhire Expenses information on Off-Hire Expenses window<br>
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
						//customOffInvDtlVOs[i].setEffDt(customOffInvoiceVO.getOriEffDt());
						//customOffInvDtlVOs[i].setExpDt(customOffInvoiceVO.getOriExpDt());
						//customOffInvDtlVOs[i].setInvUsdDys(customOffInvoiceVO.getInvUsdDys());
						customOffInvDtlVOs[i].setBunkerVvd(customOffInvoiceVO.getBunkerVvd());
						//customOffInvDtlVOs[i].setBrogFlg(customOffInvoiceVO.getBrogFlg());
						customOffInvDtlVOs[i].setCreUsrId(usrId);
						customOffInvDtlVOs[i].setUpdUsrId(usrId);
						
						if("Y".equals(customOffInvoiceVO.getBrogFlg()) && customOffInvDtlVOs[i].getAcctCd().equals(FmsConstants.KEY_ACCT_CD_BY_BROKERAGE)){
							customOffInvDtlVOs[i].setBrogFlg("Y");
						}else{
							customOffInvDtlVOs[i].setBrogFlg("N");
						}
						
						if(StringUtils.isBlank(customOffInvDtlVOs[i].getEffDt())){
							customOffInvDtlVOs[i].setEffDt(customOffInvoiceVO.getOriEffDt());
						}
						if(StringUtils.isBlank(customOffInvDtlVOs[i].getExpDt())){
							customOffInvDtlVOs[i].setExpDt(customOffInvoiceVO.getOriExpDt());
						}
						if(StringUtils.isBlank(customOffInvDtlVOs[i].getInvUsdDys())){
							customOffInvDtlVOs[i].setInvUsdDys(customOffInvoiceVO.getInvUsdDys());
						}
						
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
				
				//Inserting data into FmsInvDtl table
				if(addVoList.size() > 0) {
					for(CustomOffInvDtlVO addInvDtlVo : addVoList){
						String tmpfletIssTpCd = StringUtils.isEmpty(addInvDtlVo.getFletIssTpCd()) ? "OFF" : addInvDtlVo.getFletIssTpCd();
						//2015.09.22 Modify
						String newInvDtlSeq = dbDao.searchInvoiceDetailNewSeqInfo(customOffInvoiceVO.getFletCtrtNo(), tmpfletIssTpCd, customOffInvoiceVO.getInvSeq());
						addInvDtlVo.setInvDtlSeq(newInvDtlSeq);
						
						dbDao.addOffInvDtlInfo(addInvDtlVo);
					}					
					
					//dbDao.addOffInvDtls(addVoList);
				}
				
				//Modifying FmsInvDtl table
				if(modifyVoList.size() > 0) {
					dbDao.modifytOffInvDtls(modifyVoList);
				}
				
				//Deleting data in FmsInvDtl data
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
	 * Retrieving data on Off-Hire Expenses window(In case of clicking Inquiry button)<br>
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
	 * Retrieving SUM data on Off-Hire Expenses window(In case of clicking Inquiry button)<br>
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
	 * Retrieving data on Offhire Selection window(POPUP)<br>
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
	 * Deleting Offhire Expense information on Off-Hire Expenses window<br>
	 * 
	 * @param fletCtrtNo String
	 * @param invSeq String
	 * @exception EventException
	 */
	public void removeOffhireInvoice(String fletCtrtNo, String invSeq) throws EventException{
		try {
			//Deleting data in FMS_INV_DTL 
			dbDao.removeOffhireInvDtls(fletCtrtNo, invSeq);
			
			//Deleting data in FMS_INVOICE
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
	 * Retrieving data on Prepayments window(In case of clicking Creation button)<br>
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
			
			//2015.11.06 Modify TI/TO 에 따라 생성 쿼리 분리
			//TODO TI/TO분리 작업.
			if(FmsConstants.KEY_FLET_CTRT_TP_CD_TI.equals(condSearchCalPrepaymentInvoiceListVO.getFletCtrtTpGb())){
				return dbDao.searchCalPrepaymentInvoiceByTIList(condSearchCalPrepaymentInvoiceListVO);
			}else{
				return dbDao.searchCalPrepaymentInvoiceByTOList(condSearchCalPrepaymentInvoiceListVO);
			}
			//return dbDao.searchCalPrepaymentInvoiceList(condSearchCalPrepaymentInvoiceListVO);
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("FMS01112",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01112",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Retrieving SUM data on Prepayments window(In case of clicking Inquiry button)<br>
	 * 
	 * @param condSearchCalPrepaymentInvoiceListVO CondSearchCalPrepaymentInvoiceListVO
	 * @return List<SearchCalPrepaymentInvoiceListSumVO>
	 * @exception EventException
	 */
	public List<SearchCalPrepaymentInvoiceListSumVO> searchCalPrepaymentInvoiceListSum(CondSearchCalPrepaymentInvoiceListVO condSearchCalPrepaymentInvoiceListVO) throws EventException {
		try {
			//2015.11.06 Modify TI/TO 에 따라 생성 쿼리 분리
			//TODO TI/TO분리 작업.
			if(FmsConstants.KEY_FLET_CTRT_TP_CD_TI.equals(condSearchCalPrepaymentInvoiceListVO.getFletCtrtTpGb())){
				return dbDao.searchCalPrepaymentInvoiceByTIListSum(condSearchCalPrepaymentInvoiceListVO);
			}else{
				return dbDao.searchCalPrepaymentInvoiceByTOListSum(condSearchCalPrepaymentInvoiceListVO);
			}
			//return dbDao.searchCalPrepaymentInvoiceListSum(condSearchCalPrepaymentInvoiceListVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("FMS01112",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01112",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Registering Invoice information on Prepayments window<br>
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
						
						if("Y".equals(customPreInvoiceVO.getBrogFlg()) && customPreInvDtlVOs[i].getAcctCd().equals(FmsConstants.KEY_ACCT_CD_BY_BROKERAGE)){
							customPreInvDtlVOs[i].setBrogFlg("Y");
						}else{
							customPreInvDtlVOs[i].setBrogFlg("N");
						}
						
						if(StringUtils.isBlank(customPreInvDtlVOs[i].getEffDt())){
							customPreInvDtlVOs[i].setEffDt(customPreInvoiceVO.getOriEffDt());
						}
						if(StringUtils.isBlank(customPreInvDtlVOs[i].getExpDt())){
							customPreInvDtlVOs[i].setExpDt(customPreInvoiceVO.getOriExpDt());
						}
						if(StringUtils.isBlank(customPreInvDtlVOs[i].getInvUsdDys())){
							customPreInvDtlVOs[i].setInvUsdDys(customPreInvoiceVO.getInvUsdDys());
						}
						
						customPreInvDtlVOs[i].setCreUsrId(usrId);
						customPreInvDtlVOs[i].setUpdUsrId(usrId);
						
						addVoList.add(customPreInvDtlVOs[i]);
					}
				}
				
				//inserting data on FmsInvDtl table
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
	 * Changing/Deleting Invoice information on Prepayments window<br>
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
				
				//Modifying FmsInvDtl table
				if(modifyVoList.size() > 0) {
					dbDao.modifytPreInvDtls(modifyVoList);
				}
				
				//Deleting data in FmsInvDtl table
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
	 * Retrieving Contract information about Owner ship/Charter/Hire Out<br>
	 * Retrieving data on Prepayments window(In case of selecting Inquiry)<br>
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
			SearchHireSysDateVO searchHireSysDateVO = conDbDao.searchHireSysDate(fletCtrtNo);
			List<SearchOtrExpnSysDateListVO> searchOtrExpnSysDateListVOs = conDbDao.searchOtrExpnSysDateList(fletCtrtNo);
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
	 * Handing DELETE - Only in case slip is not generated<br>
	 * Handling DELETE event of Prepayments window<br>
	 * 
	 * @param fletCtrtNo String
	 * @param invSeq String
	 * @exception EventException
	 */
	public void removePrepaymentInvoice(String fletCtrtNo, String invSeq) throws EventException {

		try {	
			
			//Deleting data in FMS_INV_DTL 
			dbDao.removePrepaymentInvDtls(fletCtrtNo, invSeq);
			
			//Deleting data in FMS_INVOICE
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
	 * Changing Owner Account Expense <br>
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
					
					//2014.10.01 NYK Modify
					String tmpSlpIssDt = BizComFmsUtil.getFormatSlpIssueDate(customCsulSlpVOs[i].getSlpIssDt().replaceAll("-", ""));
					customCsulSlpVOs[i].setSlpIssDt(tmpSlpIssDt); //yyMM 포맷으로 4자리로 변경.
					
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
	 * Modifying Invoice account related to Broker in case of generating Manual slip<br>
	 * 
	 * @param customCsulSlpVOs CustomCsulSlpVO[]
	 * @exception EventException
	 */
	public void modifyManualSlip(CustomCsulSlpVO[] customCsulSlpVOs) throws EventException{
		try {
			List<CustomCsulSlpVO> modifyVoList = new ArrayList<CustomCsulSlpVO>();

			for ( int i=0; i<customCsulSlpVOs .length; i++ ) {
				if(!customCsulSlpVOs[i].getFletCtrtNo().equals("")) {
					//2014.10.01 NYK Modify yyMM Format.
					String tmpSlpIssDt = BizComFmsUtil.getFormatSlpIssueDate(customCsulSlpVOs[i].getSlpIssDt().replaceAll("-", ""));
					customCsulSlpVOs[i].setSlpIssDt(tmpSlpIssDt);
					
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
	 * Updating Invoice table after generating Slip <br>
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
	 * Updating Owner's Account table after generating slip<br>
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
	 * Retrieving payment data occurred by mistake of unloading among Owner payable accounts<br>
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
	 * Getting SDMS INV No.(Criteria of Existing/Not Existing)<br>
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
	 * Getting Hire No.(Criteria of Existing/Not Existing)<br>
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
	 * Retrieving basic information related to Calculation after selecting Contract number on Payment Slip window<br>
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
	 * Retrieving basic information related to Calculation after selecting Contract number on Payment Slip window<br>
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
	 * Retrieving Prepayments data which have not approved yet<br>
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
	 * Modifying related data in Calculation table when Hire Out Slip is generated<br>
	 * 
	 * @param customCsulSlpVOs CustomCsulSlpVO[]
	 * @exception EventException
	 */
	public void modifySubletRevenueSlip(CustomCsulSlpVO[] customCsulSlpVOs) throws EventException{
		try {
			List<CustomCsulSlpVO> modifyRevSlips = new ArrayList<CustomCsulSlpVO>();
			List<CustomCsulSlpVO> modifyRevSlipCommission = new ArrayList<CustomCsulSlpVO>();

			for ( int i=0; i<customCsulSlpVOs .length; i++ ) {
				if(customCsulSlpVOs[i].getAcctCd().equals(FmsConstants.KEY_ACCT_CD_BY_HIRE_REVENUE)) {
					
					//2014.10.01 NYK Modify yyMM Format.
					String tmpSlpIssDt = BizComFmsUtil.getFormatSlpIssueDate(customCsulSlpVOs[i].getSlpIssDt().replaceAll("-", ""));
					customCsulSlpVOs[i].setSlpIssDt(tmpSlpIssDt);
					
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
	 * Changing Slip number in Account into Null in case Charter Slip is canceled<br>
	 * 
	 * @param csrNo String
	 * @param usrId String
	 * @exception EventException
	 */
//	public void modifySlipApprovalCancelOwnerAccount(String csrNo, String usrId) throws EventException{
//		try {
//			
//			//FMS_OWNR_ACCT_SLP 테이블 수정
//			dbDao.modifySlipApprovalCancelOwnerAccount(csrNo, usrId);
//	
//		} catch (DAOException de) {   
//			log.error("err " + de.toString(), de);
//			throw new EventException(new ErrorHandler("FMS01419",new String[]{}).getMessage(), de);
//		} catch (Exception ex) {
//			log.error("err " + ex.toString(), ex);
//			throw new EventException(new ErrorHandler("FMS01419",new String[]{}).getMessage(), ex);
//		}
//	}
    
	/**
	 * Changing Slip number in Invoice into Null in case Charter Slip or Hire Out Slip is canceled<br>
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
	 * Updating IF NO into Invoice in case Hire Out Slip is approved<br>
	 * 
	 * @param searchArSlipDetailListVO List<SearchArSlipDetailListVO>
	 * @exception EventException
	 */
	public void modifySlipApprovalInvoice(List<SearchArSlipDetailListVO> searchArSlipDetailListVO) throws EventException{
		try {
			
			//Modifying FMS_INV_DTL table
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
	 * Retrieving Monthly data among created data When Hire Revenue Bond is generated<br>
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
	 * Retrieving the data which is selected to be handled as payment slip on created Offhire Expenses / Window<br>
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
	 * Retrieving the data which is selected to be handled as payment slip on created Owner’s Account / Window<br>
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
	 * 입력한 Duration이 유효한지 체크한다.<br>
	 * 
	 * @param CondSearchCalPrepaymentInvoiceListVO condSearchCalPrepaymentInvoiceListVO
	 * @return String chkFlag
	 * @exception EventException
	 */
    public String searchCalPrepaymentInvoiceCheckDuration(CondSearchCalPrepaymentInvoiceListVO condSearchCalPrepaymentInvoiceListVO) throws EventException {
		try {
			return dbDao.searchCalPrepaymentInvoiceCheckDuration(condSearchCalPrepaymentInvoiceListVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01189",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01189",new String[]{}).getMessage(), ex);
		}
	}
}