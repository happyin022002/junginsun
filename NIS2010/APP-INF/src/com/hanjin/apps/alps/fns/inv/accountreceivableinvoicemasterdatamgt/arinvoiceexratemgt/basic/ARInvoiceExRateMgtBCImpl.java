/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ARInvoiceExRateMgtBCImpl.java
 *@FileTitle : Ex. Rate Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.24
 *@LastModifier : 김세일
 *@LastVersion : 1.0
 * 2009.04.24 김세일
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.integration.ARInvoiceExRateMgtDBDAO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.integration.ARInvoiceExRateMgtEAIDAO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.vo.CustDailyExRateVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.vo.ExRateListVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.vo.ExchangeRateVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.vo.MultiCustomerVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.vo.SearchExRateVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.vo.SearchVVDExRateVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.vo.SearchVVDPortVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.vo.VVDExrateVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.vo.VVDandPortListVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.vo.CheckReturnVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.core.layer.integration.EAIException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

/**
 * ALPS-AccountReceivableInvoiceMasterDataMgt Business Logic Basic Command implementation<br>
 * - ALPS-AccountReceivableInvoiceMasterDataMgt에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author saeil kim
 * @see UI_INV-0006EventResponse,ARInvoiceExRateMgtBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class ARInvoiceExRateMgtBCImpl extends BasicCommandSupport implements ARInvoiceExRateMgtBC {

	// Database Access Object
	private transient ARInvoiceExRateMgtDBDAO dbDao = null;
	private transient ARInvoiceExRateMgtEAIDAO eaiDao = null;

	/**
	 * ARInvoiceExRateMgtBCImpl 객체 생성<br>
	 * ARInvoiceExRateMgtDBDAO,ARInvoiceExRateMgtEAIDAO를 생성한다.<br>
	 */
	public ARInvoiceExRateMgtBCImpl() {
		dbDao = new ARInvoiceExRateMgtDBDAO();
		eaiDao = new ARInvoiceExRateMgtEAIDAO();
	}

	/**
	 * VVD별 환율을 조회한다.<br>
	 * 
	 * @param SearchVVDExRateVO searchVVDexRateVO
	 * @return List<VVDExrateVO>
	 * @exception EventException
	 */
	public List<VVDExrateVO> searchVVDExchangeRateList(SearchVVDExRateVO searchVVDexRateVO) throws EventException {
		try {
			return dbDao.searchVVDExchangeRateList(searchVVDexRateVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Daily (일자별 )적용환율을 조회한다.<br>
	 * 
	 * @param SearchExRateVO searchExRateVO
	 * @return List<CustDailyExRateVO>
	 * @exception EventException
	 */
	public List<CustDailyExRateVO> searchDailyExchangeRateList(SearchExRateVO searchExRateVO) throws EventException {
		try {
			return dbDao.searchDailyExchangeRateList(searchExRateVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 *  베트남, 중국 Daily 환율등록/수정/삭제. 일자별 환율을 Bound/화폐별로 등록/수정/삭제한다.<br>
  	 *  ERP AR로 해당내용을 Interface 한다(EAI : FNS019-0001).<br>
	 * 
	 * @param CustDailyExRateVO[] custDailyExrateVos
	 * @param String userId
	 * @exception EventException
	 */
	public void manageCustomerDailyExchangeRate(CustDailyExRateVO[] custDailyExrateVos, String userId) throws EventException {
		try {
			List<CustDailyExRateVO> insertVoList = new ArrayList<CustDailyExRateVO>();
			List<CustDailyExRateVO> updateVoList = new ArrayList<CustDailyExRateVO>();
			List<CustDailyExRateVO> deleteVoList = new ArrayList<CustDailyExRateVO>();
			List<ExchangeRateVO> exchangeRateVOs = new ArrayList<ExchangeRateVO>();

			for (int i = 0; i < custDailyExrateVos.length; i++) {
				ExchangeRateVO exchangeRateVO = new ExchangeRateVO();
				
				if ((custDailyExrateVos[i].getIoBndCd().trim().isEmpty()) || (custDailyExrateVos[i].getIoBndCd().trim().equals("ALL"))) {
					exchangeRateVO = new ExchangeRateVO();
					
					exchangeRateVO.setFmDt(custDailyExrateVos[i].getFmDt());
					exchangeRateVO.setToDt(custDailyExrateVos[i].getToDt());
					exchangeRateVO.setChgCurrCd(custDailyExrateVos[i].getChgCurrCd());
					exchangeRateVO.setLoclCurrCd(custDailyExrateVos[i].getLoclCurrCd());
					exchangeRateVO.setXchRtTpCd(custDailyExrateVos[i].getXchRtTpCd());
					exchangeRateVO.setInvXchRt(custDailyExrateVos[i].getInvXchRt());
					exchangeRateVO.setCustCntCd(custDailyExrateVos[i].getCustCntCd());
					exchangeRateVO.setCustSeq(custDailyExrateVos[i].getCustSeq());
					exchangeRateVO.setIoBndCd("I");
					exchangeRateVO.setIbflag(custDailyExrateVos[i].getIbflag());
					exchangeRateVO.setArOfcCd(custDailyExrateVos[i].getArOfcCd());

					exchangeRateVOs.add(exchangeRateVO);
					
					exchangeRateVO = new ExchangeRateVO();
					
					exchangeRateVO.setFmDt(custDailyExrateVos[i].getFmDt());
					exchangeRateVO.setToDt(custDailyExrateVos[i].getToDt());
					exchangeRateVO.setChgCurrCd(custDailyExrateVos[i].getChgCurrCd());
					exchangeRateVO.setLoclCurrCd(custDailyExrateVos[i].getLoclCurrCd());
					exchangeRateVO.setXchRtTpCd(custDailyExrateVos[i].getXchRtTpCd());
					exchangeRateVO.setInvXchRt(custDailyExrateVos[i].getInvXchRt());
					exchangeRateVO.setCustCntCd(custDailyExrateVos[i].getCustCntCd());
					exchangeRateVO.setCustSeq(custDailyExrateVos[i].getCustSeq());
					exchangeRateVO.setIoBndCd("O");
					exchangeRateVO.setIbflag(custDailyExrateVos[i].getIbflag());
					exchangeRateVO.setArOfcCd(custDailyExrateVos[i].getArOfcCd());

					exchangeRateVOs.add(exchangeRateVO);
				} else {
					
					exchangeRateVO = new ExchangeRateVO();
					
					exchangeRateVO.setFmDt(custDailyExrateVos[i].getFmDt());
					exchangeRateVO.setToDt(custDailyExrateVos[i].getToDt());
					exchangeRateVO.setChgCurrCd(custDailyExrateVos[i].getChgCurrCd());
					exchangeRateVO.setLoclCurrCd(custDailyExrateVos[i].getLoclCurrCd());
					exchangeRateVO.setXchRtTpCd(custDailyExrateVos[i].getXchRtTpCd());
					exchangeRateVO.setInvXchRt(custDailyExrateVos[i].getInvXchRt());
					exchangeRateVO.setCustCntCd(custDailyExrateVos[i].getCustCntCd());
					exchangeRateVO.setCustSeq(custDailyExrateVos[i].getCustSeq());
					exchangeRateVO.setIoBndCd(custDailyExrateVos[i].getIoBndCd());
					exchangeRateVO.setIbflag(custDailyExrateVos[i].getIbflag());
					exchangeRateVO.setArOfcCd(custDailyExrateVos[i].getArOfcCd());

					exchangeRateVOs.add(exchangeRateVO);
				}

				if (custDailyExrateVos[i].getIbflag().equals("I")) {
					custDailyExrateVos[i].setCreUsrId(userId);
					if ((custDailyExrateVos[i].getIoBndCd().trim().isEmpty()) || (custDailyExrateVos[i].getIoBndCd().trim().equals("ALL"))) {
						
						CustDailyExRateVO vo = new CustDailyExRateVO();
						vo = custDailyExrateVos[i];
						vo.setIoBndCd("I");
						vo.setCreUsrId(custDailyExrateVos[i].getCreUsrId());
						
						insertVoList.add(vo);
						
						vo = new CustDailyExRateVO();
						vo.setIoBndCd("O");
						vo.setFmDt(custDailyExrateVos[i].getFmDt());
						vo.setToDt(custDailyExrateVos[i].getToDt());
						vo.setChgCurrCd(custDailyExrateVos[i].getChgCurrCd());
						vo.setLoclCurrCd(custDailyExrateVos[i].getLoclCurrCd());
						vo.setXchRtTpCd(custDailyExrateVos[i].getXchRtTpCd());
						vo.setArOfcCd(custDailyExrateVos[i].getArOfcCd());
						vo.setInvXchRt(custDailyExrateVos[i].getInvXchRt());
						vo.setCreUsrId(custDailyExrateVos[i].getCreUsrId());
						vo.setCustCntCd(custDailyExrateVos[i].getCustCntCd());
						vo.setCustSeq(custDailyExrateVos[i].getCustSeq());

						insertVoList.add(vo);

					} else {
						insertVoList.add(custDailyExrateVos[i]);
					}
				} else if (custDailyExrateVos[i].getIbflag().equals("U")) {
					
					if ((custDailyExrateVos[i].getIoBndCd().trim().isEmpty()) || (custDailyExrateVos[i].getIoBndCd().trim().equals("ALL"))) {
						
						CustDailyExRateVO vo = new CustDailyExRateVO();
						vo = custDailyExrateVos[i];
						vo.setIoBndCd("I");
						vo.setUpdUsrId(userId);

						updateVoList.add(vo);
						
						vo = new CustDailyExRateVO();
						vo.setIoBndCd("O");
						vo.setFmDt(custDailyExrateVos[i].getFmDt());
						vo.setToDt(custDailyExrateVos[i].getToDt());
						vo.setChgCurrCd(custDailyExrateVos[i].getChgCurrCd());
						vo.setLoclCurrCd(custDailyExrateVos[i].getLoclCurrCd());
						vo.setXchRtTpCd(custDailyExrateVos[i].getXchRtTpCd());
						vo.setInvXchRt(custDailyExrateVos[i].getInvXchRt());
						vo.setUpdUsrId(userId);
						vo.setCustCntCd(custDailyExrateVos[i].getCustCntCd());
						vo.setCustSeq(custDailyExrateVos[i].getCustSeq());

						updateVoList.add(vo);

					} else {
						updateVoList.add(custDailyExrateVos[i]);
					}
					
				} else if (custDailyExrateVos[i].getIbflag().equals("D")) {
					if ((custDailyExrateVos[i].getIoBndCd().trim().isEmpty()) || (custDailyExrateVos[i].getIoBndCd().trim().equals("ALL"))) {
						CustDailyExRateVO vo = new CustDailyExRateVO();
						vo = custDailyExrateVos[i];
						vo.setIoBndCd("I");

						deleteVoList.add(vo);
						vo = new CustDailyExRateVO();
						vo.setIoBndCd("O");
						vo.setFmDt(custDailyExrateVos[i].getFmDt());
						vo.setToDt(custDailyExrateVos[i].getToDt());
						vo.setChgCurrCd(custDailyExrateVos[i].getChgCurrCd());
						vo.setLoclCurrCd(custDailyExrateVos[i].getLoclCurrCd());
						vo.setXchRtTpCd(custDailyExrateVos[i].getXchRtTpCd());
						vo.setInvXchRt(custDailyExrateVos[i].getInvXchRt());
						vo.setUpdUsrId(userId);
						vo.setCustCntCd(custDailyExrateVos[i].getCustCntCd());
						vo.setCustSeq(custDailyExrateVos[i].getCustSeq());

						deleteVoList.add(vo);

					} else {
						deleteVoList.add(custDailyExrateVos[i]);
					}
				}
			}
			
			if (insertVoList.size() > 0) {
				CheckReturnVO checkReturnVO = dbDao.searchCustomerDailyExchangeRate(insertVoList);
				//중복된 날짜가 있을 경우 Exception 발생
				if(checkReturnVO != null){
					throw new EventException(new ErrorHandler("INV00052", new String[] {}).getMessage());
				}
				
				dbDao.addCustomerDailyExchangeRate(insertVoList);
			}
			if (updateVoList.size() > 0) {
				dbDao.modifyCustomerDailyExchangeRate(updateVoList);
			}
			if (deleteVoList.size() > 0) {
				dbDao.removeCustomerDailyExchangeRate(deleteVoList);
			}

			eaiDao.interfaceExRateToERPAR0190001(exchangeRateVOs, userId);
		
		} catch (EventException ex) {			
			throw ex;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("INV00053", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("INV00053", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Customer 환율등록시 여러Customer에 대해서 동일 환율 반영하도록 함.<br>
  	 * 사용자 confirm에 따라서  ERP AR로 해당내용을 Interface 한다(EAI : FNS019-0001)<br>
	 * 
	 * @param MultiCustomerVO[] multiCustomerVos
	 * @param CustDailyExRateVO[] custDailyExRateVos
	 * @param String userId
	 * @exception EventException
	 */
	public void manageMultiCustomerExRate(MultiCustomerVO[] multiCustomerVos, CustDailyExRateVO[] custDailyExRateVos, String userId) throws EventException {
		try {
			List<CustDailyExRateVO> erpVoList = new ArrayList<CustDailyExRateVO>(); // erp 를 위해서 담아 놓는다.
			List<ExchangeRateVO> exchangeRateVOs = new ArrayList<ExchangeRateVO>();

			for (int i = 0; i < multiCustomerVos.length; i++) {
				for (int j = 0; j < custDailyExRateVos.length; j++) {
					ExchangeRateVO exchangeRateVO = new ExchangeRateVO();

					exchangeRateVO.setFmDt(custDailyExRateVos[j].getFmDt());
					exchangeRateVO.setToDt(custDailyExRateVos[j].getToDt());
					exchangeRateVO.setChgCurrCd(custDailyExRateVos[j].getChgCurrCd());
					exchangeRateVO.setLoclCurrCd(custDailyExRateVos[j].getLoclCurrCd());
					exchangeRateVO.setXchRtTpCd(custDailyExRateVos[j].getXchRtTpCd());
					exchangeRateVO.setInvXchRt(custDailyExRateVos[j].getInvXchRt());
					exchangeRateVO.setCustCntCd(multiCustomerVos[i].getCustCntCd());
					exchangeRateVO.setCustSeq(multiCustomerVos[i].getCustSeq());
					exchangeRateVO.setIoBndCd(custDailyExRateVos[j].getIoBndCd());
					exchangeRateVO.setIbflag(custDailyExRateVos[j].getIbflag());
					exchangeRateVO.setArOfcCd(custDailyExRateVos[j].getArOfcCd());
					exchangeRateVOs.add(exchangeRateVO);

					List<CustDailyExRateVO> insertVoList = new ArrayList<CustDailyExRateVO>();

					custDailyExRateVos[j].setCustCntCd(multiCustomerVos[i].getCustCntCd());
					custDailyExRateVos[j].setCustSeq(multiCustomerVos[i].getCustSeq());

					if (custDailyExRateVos[j].getIbflag().equals("I")) {
						if (multiCustomerVos[i].getConfirmFlag().equals("I")) {

							custDailyExRateVos[j].setCreUsrId(userId);

							insertVoList.add(custDailyExRateVos[j]);
							dbDao.addCustomerDailyExchangeRate(insertVoList);
							erpVoList.add(custDailyExRateVos[j]);
						} else if (multiCustomerVos[i].getConfirmFlag().equals("U")) {
							custDailyExRateVos[j].setCreUsrId(userId);
							custDailyExRateVos[j].setUpdUsrId(userId);
							
							List<CustDailyExRateVO> list = new ArrayList<CustDailyExRateVO>();
							list =  dbDao.searchMultiCustomerExRate(custDailyExRateVos[j]);
							if (list.size() > 0) {
								dbDao.removeCustomerDailyExchangeRate(list);
								erpVoList.add(list.get(0));
							}

							insertVoList.add(custDailyExRateVos[j]);
							dbDao.addCustomerDailyExchangeRate(insertVoList);
							erpVoList.add(custDailyExRateVos[j]);
						}
					}
				}
			}

			eaiDao.interfaceExRateToERPAR0190001(exchangeRateVOs, userId);
			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("INV00053", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("INV00053", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * 환율 Type에 따라서 개별화주(Customer) 적용환율을 조회한다.<br>
	 * 
	 * @param SearchExRateVO searchExRateVO
	 * @return List<CustDailyExRateVO>
	 * @exception EventException
	 */
	public List<CustDailyExRateVO> searchCustomerExchangeRateList(SearchExRateVO searchExRateVO) throws EventException {
		try {
			List<CustDailyExRateVO> list = dbDao.searchCustomerExchangeRateList(searchExRateVO);
			List<CustDailyExRateVO> list2 = new ArrayList<CustDailyExRateVO>();

			for (int i = 0; i < list.size(); i++) {
				CustDailyExRateVO info = list.get(i);
				String checkVal = list.get(i).getInvXchRt().replace(".", "").replace("0", "");
				Integer checkRate = 0;
				if (checkVal.length() > 0) {
					for (int j = 0; j < checkVal.length(); j++) {
						checkRate = checkRate + Integer.parseInt(checkVal.substring(j, j + 1));

						info.setCheckDigit(checkRate.toString());
					}
				} else {
					info.setCheckDigit("0");
				}
				list2.add(info);
			}
			return list2;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Customer에 해당월로 등록된 환율이 있는지 확인한다. <br>
	 * 
	 * @param String cust_cnt_cd
	 * @param String cust_seq
	 * @param String mon
	 * @return int
	 * @exception EventException
	 */
	public int searchCustomerMonExRate(String cust_cnt_cd, String cust_seq, String mon) throws EventException {
		int cnt = 0; // 조회 데이터 총카운트
		try {
			cnt = dbDao.searchCustomerMonExRate(cust_cnt_cd, cust_seq, mon);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}

		return cnt;
	}

	/**
	 * 조회조건에 Port list에 보여주기 위한 데이터<br>
	 * 
	 * @param String svrId
	 * @param String ofc
	 * @return List<String>
	 * @exception EventException
	 */
	public List<String> searchPortList(String svrId, String ofc) throws EventException {
		try {
			List<String> list = dbDao.searchPortList(svrId, ofc);
			return list;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}

	}

	/**
	 * VVD  및 날짜기준운항정보참조하여 환율일괄 입력대상 조회한다. <br>
   	 * Bound를 I/B. O/B를 선택한 경우에 한함.<br>
	 * 
	 * @param SearchVVDPortVO searchByBndVo
	 * @return List<VVDandPortListVO>
	 * @exception EventException
	 */
	public List<VVDandPortListVO> searchPortListByBnd(SearchVVDPortVO searchByBndVo) throws EventException {
		try {
			return dbDao.searchPortListByBnd(searchByBndVo);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * VVD  및 날짜기준운항정보참조하여 환율일괄 입력대상 조회한다.<br>
   	 * Bound를 Triangle로 선택한 경우에 한함.<br>
	 * 
	 * @param SearchVVDPortVO searchByTriVo
	 * @return List<VVDandPortListVO>
	 * @exception EventException
	 */
	public List<VVDandPortListVO> searchPortListByTri(SearchVVDPortVO searchByTriVo) throws EventException {
		try {
			return dbDao.searchPortListByTri(searchByTriVo);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * VVD  및 날짜기준운항정보참조하여 환율일괄 입력대상 조회한다.<br>
   	 * EUR일 경우에 한함.<br>
	 * 
	 * @param SearchVVDPortVO searchByTriVo
	 * @return List<VVDandPortListVO>
	 * @exception EventException
	 */
	public List<VVDandPortListVO> searchEURPortList(SearchVVDPortVO searchByTriVo) throws EventException{
		try {
			return dbDao.searchEURPortList(searchByTriVo);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * EUR일때 운항정보에서 Create 대상 VVD, PORT list를 조회한다.<br>
	 * 
	 * @param String vvd_cd
	 * @return List<VVDandPortListVO>
	 * @exception EventException
	 */
	public List<VVDandPortListVO> searchEURVVDList(String vvd_cd) throws EventException {
		try {
			return dbDao.searchEURVVDList(vvd_cd);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * 조건에 맞는 환율입력대상을 VSL SKD에서 조회해오고 VVD별 환율을 Bound/port/service scop/화폐별로 일괄등록한다.<br>
     * 기 등록된 환율이 있는 경우는  Update 하도록 한다.<br>
	 * 
	 * @param List<VVDandPortListVO>  vvdPortListVos
	 * @param List<VVDExrateVO> vvdExRtVos
	 * @param String userId
	 * @exception EventException
	 */
	public void createVVDExchangeRate(List<VVDandPortListVO> vvdPortListVos, List<VVDExrateVO> vvdExRtVos, String userId) throws EventException {
		try {
			List<VVDExrateVO> erpVoList = new ArrayList<VVDExrateVO>(); // erp 를 위해서 담아 놓는다.
			List<ExchangeRateVO> exchangeRateVOs = new ArrayList<ExchangeRateVO>();

			for (int i = 0; i < vvdExRtVos.size(); i++) {
				if (vvdExRtVos.get(i).getIbflag() != "D") {
					for (int j = 0; j < vvdPortListVos.size(); j++) {
						ExchangeRateVO exchangeRateVO = new ExchangeRateVO();

						exchangeRateVO.setVslCd(vvdPortListVos.get(j).getVvdCd().substring(0, 4));
						exchangeRateVO.setSkdVoyNo(vvdPortListVos.get(j).getVvdCd().substring(4, 8));
						exchangeRateVO.setSkdDirCd(vvdPortListVos.get(j).getVvdCd().substring(8, 9));
						exchangeRateVO.setPortCd(vvdPortListVos.get(j).getVpsPortCd());
						exchangeRateVO.setSvcScpCd(vvdPortListVos.get(j).getSvcScpCd());
						exchangeRateVO.setIoBndCd(vvdPortListVos.get(j).getIoBndCd());
						exchangeRateVO.setChgCurrCd(vvdExRtVos.get(i).getChgCurrCd());
						exchangeRateVO.setLoclCurrCd(vvdExRtVos.get(i).getLoclCurrCd());
						exchangeRateVO.setInvXchRt(vvdExRtVos.get(i).getInvXchRt());
						exchangeRateVO.setIbflag(vvdPortListVos.get(j).getIbflag());
						exchangeRateVO.setArOfcCd(vvdExRtVos.get(i).getArOfcCd());

						List<VVDExrateVO> insertVoList = new ArrayList<VVDExrateVO>();

						vvdExRtVos.get(i).setVslCd(vvdPortListVos.get(j).getVvdCd().substring(0, 4));
						vvdExRtVos.get(i).setSkdVoyNo(vvdPortListVos.get(j).getVvdCd().substring(4, 8));
						vvdExRtVos.get(i).setSkdDirCd(vvdPortListVos.get(j).getVvdCd().substring(8, 9));
						vvdExRtVos.get(i).setPortCd(vvdPortListVos.get(j).getVpsPortCd());
						vvdExRtVos.get(i).setSvcScpCd(vvdPortListVos.get(j).getSvcScpCd());
						vvdExRtVos.get(i).setIoBndCd(vvdPortListVos.get(j).getIoBndCd());
						vvdExRtVos.get(i).setCreUsrId(userId);
						vvdExRtVos.get(i).setUpdUsrId(userId);

						int cnt = dbDao.searchVVDExchangeRate(vvdExRtVos.get(i));
						if (cnt > 0) { // update
							exchangeRateVO.setIbflag("U");

							insertVoList.add(vvdExRtVos.get(i));
							dbDao.modifyVVDExchangeRate(insertVoList);
							erpVoList.add(vvdExRtVos.get(i));
						} else { // insert
							exchangeRateVO.setIbflag("I");

							insertVoList.add(vvdExRtVos.get(i));
							dbDao.addVVDExchangeRate(insertVoList);
							erpVoList.add(vvdExRtVos.get(i));
						}

						exchangeRateVOs.add(exchangeRateVO);
					}
				}
			}
			
			List<ExchangeRateVO> exchangeRateEaiVOs = new ArrayList<ExchangeRateVO>();
			
			for(int i = 0; i < exchangeRateVOs.size();i++){				
				ExchangeRateVO exchangeRateVO = new ExchangeRateVO();
				exchangeRateVO = exchangeRateVOs.get(i);
				exchangeRateEaiVOs.add(exchangeRateVO);	
				
				if(exchangeRateEaiVOs.size()==100||i==exchangeRateVOs.size()-1){	
					eaiDao.interfaceExRateToERPAR0190002(exchangeRateEaiVOs, userId);
					exchangeRateEaiVOs.clear();
				}
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("INV00053", new String[] {}).getMessage(), ex);
		} catch (EAIException ea) {
			log.error("errbc1 " + ea.toString(), ea);
			throw new EventException(new ErrorHandler("INV00074", new String[] {}).getMessage(), ea);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("INV00053", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * 환율삭제시  AR Invoice(Charge부분) 중 유효한 데이터에 대하여 해당 환율에 적용된  것이 있는지를 조회해 온다.<br>
	 * 
	 * @param ExchangeRateVO exRateVo
	 * @return String
	 * @exception EventException
	 */
	public String searchARInvoiceExist(ExchangeRateVO exRateVo) throws EventException {
		try {
			return dbDao.searchARInvoiceExist(exRateVo);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * VVD별 환율을 Bound/port/service scop/화폐별로 등록/수정/삭제한다.<br>
     * ERP AR로 해당내용을 Interface 한다(EAI : FNS019-0002).<br>
	 * 
	 * @param VVDExrateVO[] vvdExrateVos
	 * @param String userId
	 * @exception EventException
	 */
	public void manageVVDExchangeRate(VVDExrateVO[] vvdExrateVos, String userId) throws EventException {
		try {
			List<VVDExrateVO> insertVoList = new ArrayList<VVDExrateVO>();
			List<VVDExrateVO> updateVoList = new ArrayList<VVDExrateVO>();
			List<VVDExrateVO> deleteVoList = new ArrayList<VVDExrateVO>();
			List<ExchangeRateVO> exchangeRateVOs = new ArrayList<ExchangeRateVO>();

			for (int i = 0; i < vvdExrateVos.length; i++) {
				vvdExrateVos[i].setVslCd(vvdExrateVos[i].getVvdCd().substring(0, 4));
				vvdExrateVos[i].setSkdVoyNo(vvdExrateVos[i].getVvdCd().substring(4, 8));
				vvdExrateVos[i].setSkdDirCd(vvdExrateVos[i].getVvdCd().substring(8, 9));

				ExchangeRateVO exchangeRateVO = new ExchangeRateVO();

				if (vvdExrateVos[i].getIbflag().equals("I")) {
					vvdExrateVos[i].setCreUsrId(userId);
					insertVoList.add(vvdExrateVos[i]);
				} else if (vvdExrateVos[i].getIbflag().equals("U")) {
					vvdExrateVos[i].setUpdUsrId(userId);
					updateVoList.add(vvdExrateVos[i]);
				} else if (vvdExrateVos[i].getIbflag().equals("D")) {
					deleteVoList.add(vvdExrateVos[i]);
				}

				exchangeRateVO.setVslCd(vvdExrateVos[i].getVvdCd().substring(0, 4));
				exchangeRateVO.setSkdVoyNo(vvdExrateVos[i].getVvdCd().substring(4, 8));
				exchangeRateVO.setSkdDirCd(vvdExrateVos[i].getVvdCd().substring(8, 9));
				exchangeRateVO.setPortCd(vvdExrateVos[i].getPortCd());
				exchangeRateVO.setSvcScpCd(vvdExrateVos[i].getSvcScpCd());
				exchangeRateVO.setIoBndCd(vvdExrateVos[i].getIoBndCd());
				exchangeRateVO.setChgCurrCd(vvdExrateVos[i].getChgCurrCd());
				exchangeRateVO.setLoclCurrCd(vvdExrateVos[i].getLoclCurrCd());
				exchangeRateVO.setInvXchRt(vvdExrateVos[i].getInvXchRt());
				exchangeRateVO.setIbflag(vvdExrateVos[i].getIbflag());
				exchangeRateVO.setArOfcCd(vvdExrateVos[i].getArOfcCd());

				exchangeRateVOs.add(exchangeRateVO);
			}

			if (insertVoList.size() > 0) {
				dbDao.addVVDExchangeRate(insertVoList);
			}
			if (updateVoList.size() > 0) {
				dbDao.modifyVVDExchangeRate(updateVoList);
			}
			if (deleteVoList.size() > 0) {
				dbDao.removeVVDExchangeRate(deleteVoList);
			}
			
			List<ExchangeRateVO> exchangeRateEaiVOs = new ArrayList<ExchangeRateVO>();
			
			for(int i = 0; i < exchangeRateVOs.size();i++){				
				ExchangeRateVO exchangeRateVO = new ExchangeRateVO();
				exchangeRateVO = exchangeRateVOs.get(i);
				exchangeRateEaiVOs.add(exchangeRateVO);		
				
				if(exchangeRateEaiVOs.size()==100||i==exchangeRateVOs.size()-1){	
					eaiDao.interfaceExRateToERPAR0190002(exchangeRateEaiVOs, userId);
					exchangeRateEaiVOs.clear();
				}
			}
			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("INV00053", new String[] {}).getMessage(), ex);
		} catch (EAIException ea) {
			log.error("errbc1 " + ea.toString(), ea);
			throw new EventException(new ErrorHandler("INV00074", new String[] {}).getMessage(), ea);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("INV00053", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * 환율 유형별 list 조회<br>
	 * 
	 * @param SearchVVDExRateVO searchVVDexRateVO
	 * @return ExRateListVO
	 * @exception EventException
	 */
	public ExRateListVO searchExchangeRateList(SearchVVDExRateVO searchVVDexRateVO) throws EventException {
		ExRateListVO exRateListVO = new ExRateListVO();

		try {
			// VVD
			if (searchVVDexRateVO.getXchRtTpCd().equals("V")) {
				exRateListVO.setVvdExrateList(dbDao.searchVVDExchangeRateInquiryList(searchVVDexRateVO));
			}
			// Customer & Daily & China 
			else if (searchVVDexRateVO.getXchRtTpCd().equals("I") || searchVVDexRateVO.getXchRtTpCd().equals("C") || searchVVDexRateVO.getXchRtTpCd().equals("D")) {
				SearchExRateVO searchExRateVO = new SearchExRateVO();

				searchExRateVO.setXchRtTpCd(searchVVDexRateVO.getXchRtTpCd());
				// Daily & China 인 경우 custCntCd, custSeq를 'XX', '0'으로 조회한다.
				if (searchVVDexRateVO.getXchRtTpCd().equals("C") || searchVVDexRateVO.getXchRtTpCd().equals("D")) {
					searchExRateVO.setCustCntCd("XX");
					searchExRateVO.setCustSeq("0");
				}
				else {
					searchExRateVO.setCustCntCd(searchVVDexRateVO.getCustCntCd());
					searchExRateVO.setCustSeq(searchVVDexRateVO.getCustSeq());
				}
				searchExRateVO.setFmDt(searchVVDexRateVO.getFromDt());
				searchExRateVO.setToDt(searchVVDexRateVO.getToDt());
				searchExRateVO.setLoclCurrCd(searchVVDexRateVO.getLoclCurrCd());
				searchExRateVO.setChgCurrCd(searchVVDexRateVO.getChgCurrCd());
				searchExRateVO.setArOfcCd(searchVVDexRateVO.getArOfcCd());
				searchExRateVO.setIoBndCd(searchVVDexRateVO.getIoBndCd());

				exRateListVO.setCustDailyExRateList(dbDao.searchCustomerDailyExchangeRateList(searchExRateVO));
			}
			// Monthly Accounting
			else if (searchVVDexRateVO.getXchRtTpCd().equals("A")) {
				String fromMon = searchVVDexRateVO.getFromDt();
				String toMon = searchVVDexRateVO.getToDt();
				String lclCur = searchVVDexRateVO.getLoclCurrCd();

				exRateListVO.setGlMonExrateList(dbDao.searchGLMonExRateList(fromMon, toMon, lclCur));
			}

			return exRateListVO;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * 해당 Currency 가 MDM_ORGANIZATION에 AR Currency로 등록되어 있는지 체크한다.<br>
	 * 
	 * @param String ofc
	 * @param String currCd
	 * @return int
	 * @exception EventException
	 */
	public int searchARCurrCd( String ofc, String currCd ) throws EventException {
		try {
			return dbDao.searchARCurrCd( ofc, currCd );
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}
}