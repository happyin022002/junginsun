/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ARInvoiceExRateMgtBCImpl.java
 *@FileTitle : Ex. Rate Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier :
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.integration.ARInvoiceExRateMgtDBDAO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.vo.CheckReturnVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.vo.CustDailyExRateVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.vo.ExRateListVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.vo.ExchangeRateVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.vo.MultiCustomerVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.vo.SearchExRateVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.vo.SearchVVDExRateVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.vo.SearchVVDPortVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.vo.VVDExrateDateHisVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.vo.VVDExrateVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.vo.VVDandPortListVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.vo.ExRateHistoryVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.vo.DailyExchangeRateTmpVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.core.layer.integration.EAIException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.component.util.object.ObjectCloner;

/**
 * AccountReceivableInvoiceMasterDataMgt Business Logic Basic Command implementation<br>
 * 
 * @author saeil kim
 * @see UI_INV-0006EventResponse,ARInvoiceExRateMgtBC each DAO class reference
 * @since J2EE 1.4
 */
public class ARInvoiceExRateMgtBCImpl extends BasicCommandSupport implements ARInvoiceExRateMgtBC {
 
	// Database Access Object
	private transient ARInvoiceExRateMgtDBDAO dbDao = null;
	
	/**
	 * ARInvoiceExRateMgtBCImpl object creation<br>
	 * ARInvoiceExRateMgtDBDAO,ARInvoiceExRateMgtEAIDAO creation<br>
	 */
	public ARInvoiceExRateMgtBCImpl() {
		dbDao = new ARInvoiceExRateMgtDBDAO();
	}

	/**
	 * Each VVD rates retrieve<br>
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
	 * Daily (each daily )apply rates retrieve<br>
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
	 *  Vietnam, China Daily rates register/modify/delete. each daily rates Bound/each money register/modify/delete<br>
  	 *  ERP AR Interface(EAI : FNS019-0001).<br>
	 * 
	 * @param CustDailyExRateVO[] custDailyExrateVos
	 * @param String userId
	 * @param String str0008Flag
	 * @exception EventException
	 */
	public void manageCustomerDailyExchangeRate(CustDailyExRateVO[] custDailyExrateVos, String userId, String str0008Flag) throws EventException {
		try {
			List<CustDailyExRateVO> insertVoList = new ArrayList<CustDailyExRateVO>();
			List<CustDailyExRateVO> updateVoList = new ArrayList<CustDailyExRateVO>();
			List<CustDailyExRateVO> deleteVoList = new ArrayList<CustDailyExRateVO>();
			List<CustDailyExRateVO> vvdUpdateList = new ArrayList<CustDailyExRateVO>();
			
			
			List<ExRateHistoryVO> historyVoList = new ArrayList<ExRateHistoryVO>();
			
			//List<ExchangeRateVO> exchangeRateVOs = new ArrayList<ExchangeRateVO>();
			String ibFlag = "";
			
			
			if ( custDailyExrateVos != null ) {
				for (int i = 0; i < custDailyExrateVos.length; i++) {
					//ExchangeRateVO exchangeRateVO = new ExchangeRateVO();
					custDailyExrateVos[i].setUsrId(userId);

					
					if(str0008Flag.equals("Y")) {
						ibFlag = custDailyExrateVos[i].getTmpIbFlag();
					} else {
						ibFlag = custDailyExrateVos[i].getIbflag();
					}
					

					if (ibFlag.equals("I")) {
						custDailyExrateVos[i].setCreUsrId(userId);
						if ((custDailyExrateVos[i].getIoBndCd().trim().isEmpty()) || (custDailyExrateVos[i].getIoBndCd().trim().equals("ALL"))) {
							
							CustDailyExRateVO vo = new CustDailyExRateVO();						
							ObjectCloner.build(custDailyExrateVos[i], vo);
							vo.setIoBndCd("I");
							insertVoList.add(vo);
							
							vo = new CustDailyExRateVO();
							ObjectCloner.build(custDailyExrateVos[i], vo);
							vo.setIoBndCd("O");
							insertVoList.add(vo);
							
							//History List
							ExRateHistoryVO hisVO1 = new ExRateHistoryVO();
							ExRateHistoryVO hisVO2 = new ExRateHistoryVO();
							
							ObjectCloner.build(custDailyExrateVos[i], hisVO1);
							ObjectCloner.build(custDailyExrateVos[i], hisVO2);
							
							hisVO1.setIoBndCd("I");
							hisVO1.setOpStsNm("Added");
							hisVO2.setIoBndCd("O");
							hisVO2.setOpStsNm("Added");
							
							historyVoList.add(hisVO1);
							historyVoList.add(hisVO2);
							
	
						} else {
							insertVoList.add(custDailyExrateVos[i]);
							
							//History List
							ExRateHistoryVO hisVO1 = new ExRateHistoryVO();
							ObjectCloner.build(custDailyExrateVos[i], hisVO1);
							hisVO1.setOpStsNm("Added");
							historyVoList.add(hisVO1);
						}
					} else if (ibFlag.equals("U")) {
						custDailyExrateVos[i].setUpdUsrId(userId);
						if ((custDailyExrateVos[i].getIoBndCd().trim().isEmpty()) || (custDailyExrateVos[i].getIoBndCd().trim().equals("ALL"))) {
							
							CustDailyExRateVO vo = new CustDailyExRateVO();
							vo = custDailyExrateVos[i];
							vo.setIoBndCd("I");
							vo.setUpdUsrId(userId);
	
							updateVoList.add(vo);
							
							//VVD Ex.Rate 존재유무 체크
							if (custDailyExrateVos[i].getXchRtTpCd().equals("V")) { 
								if(str0008Flag.equals("Y")) {
									if (!"0".equals(custDailyExrateVos[i].getVvdCnt())) {
										vvdUpdateList.add(custDailyExrateVos[i]);	
									}
								} else {
									if (!"0".equals(dbDao.selectVVDExRateCnt(custDailyExrateVos[i]))) {
										vvdUpdateList.add(custDailyExrateVos[i]);	
									}
								}
							}
							
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
							
							//VVD Ex.Rate 존재유무 체크
							if (custDailyExrateVos[i].getXchRtTpCd().equals("V")) { 
								if(str0008Flag.equals("Y")) {
									if (!"0".equals(custDailyExrateVos[i].getVvdCnt())) {
										vvdUpdateList.add(custDailyExrateVos[i]);	
									}
								} else {
									if (!"0".equals(dbDao.selectVVDExRateCnt(custDailyExrateVos[i]))) {
										vvdUpdateList.add(custDailyExrateVos[i]);	
									}
								}
							}
							
							//History List
							ExRateHistoryVO hisVO1 = new ExRateHistoryVO();
							ExRateHistoryVO hisVO2 = new ExRateHistoryVO();
							
							ObjectCloner.build(custDailyExrateVos[i], hisVO1);
							ObjectCloner.build(custDailyExrateVos[i], hisVO2);
							
												
							hisVO1.setIoBndCd("I");
							hisVO1.setOpStsNm("Modified");
							hisVO2.setIoBndCd("O");
							hisVO2.setOpStsNm("Modified");
							
							historyVoList.add(hisVO1);
							historyVoList.add(hisVO2);
							
						} else {
							updateVoList.add(custDailyExrateVos[i]);
							
							//VVD Ex.Rate 존재유무 체크
							if (custDailyExrateVos[i].getXchRtTpCd().equals("V")) { 
								if(str0008Flag.equals("Y")) {
									if (!"0".equals(custDailyExrateVos[i].getVvdCnt())) {
										vvdUpdateList.add(custDailyExrateVos[i]);	
									}
								} else {
									if (!"0".equals(dbDao.selectVVDExRateCnt(custDailyExrateVos[i]))) {
										vvdUpdateList.add(custDailyExrateVos[i]);	
									}
								}
							}
								
							
							//History List
							ExRateHistoryVO hisVO1 = new ExRateHistoryVO();
							ObjectCloner.build(custDailyExrateVos[i], hisVO1);
							hisVO1.setOpStsNm("Modified");
							historyVoList.add(hisVO1);
						}
						
					} else if (ibFlag.equals("D")) {
						if ((custDailyExrateVos[i].getIoBndCd().trim().isEmpty()) || (custDailyExrateVos[i].getIoBndCd().trim().equals("ALL"))) {
							CustDailyExRateVO vo = new CustDailyExRateVO();
							vo = custDailyExrateVos[i];
							vo.setIoBndCd("I");
							
							//VVD Ex.Rate 존재유무 체크
							if (custDailyExrateVos[i].getXchRtTpCd().equals("V")) { 
								if(str0008Flag.equals("Y")) {
									if (!"0".equals(custDailyExrateVos[i].getVvdCnt())) {
										throw new EventException(new ErrorHandler("INV00189", new String[] {}).getMessage());
									}
								} else {
									if (!"0".equals(dbDao.selectVVDExRateCnt(custDailyExrateVos[i]))) {
										throw new EventException(new ErrorHandler("INV00189", new String[] {}).getMessage());
									}
								}								
							}
							
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
	
							//VVD Ex.Rate 존재유무 체크
							if (custDailyExrateVos[i].getXchRtTpCd().equals("V")) { 
								if(str0008Flag.equals("Y")) {
									if (!"0".equals(custDailyExrateVos[i].getVvdCnt())) {
										throw new EventException(new ErrorHandler("INV00189", new String[] {}).getMessage());
									}
								} else {
									if (!"0".equals(dbDao.selectVVDExRateCnt(custDailyExrateVos[i]))) {
										throw new EventException(new ErrorHandler("INV00189", new String[] {}).getMessage());
									}
								}
							}
							
							deleteVoList.add(vo);
							
							//History List
							ExRateHistoryVO hisVO1 = new ExRateHistoryVO();
							ExRateHistoryVO hisVO2 = new ExRateHistoryVO();
							
							ObjectCloner.build(custDailyExrateVos[i], hisVO1);
							ObjectCloner.build(custDailyExrateVos[i], hisVO2);
							
							hisVO1.setIoBndCd("I");
							hisVO1.setOpStsNm("Deleted");
							hisVO2.setIoBndCd("O");
							hisVO2.setOpStsNm("Deleted");
							
							historyVoList.add(hisVO1);
							historyVoList.add(hisVO2);
							
	
						} else {
							
							//VVD Ex.Rate 존재유무 체크
							if (custDailyExrateVos[i].getXchRtTpCd().equals("V")) { 
								if(str0008Flag.equals("Y")) {
									if (!"0".equals(custDailyExrateVos[i].getVvdCnt())) {
										throw new EventException(new ErrorHandler("INV00189", new String[] {}).getMessage());
									}
								} else {
									if (!"0".equals(dbDao.selectVVDExRateCnt(custDailyExrateVos[i]))) {
										throw new EventException(new ErrorHandler("INV00189", new String[] {}).getMessage());
									}
								}
							}
							
							deleteVoList.add(custDailyExrateVos[i]);
							//History List
							ExRateHistoryVO hisVO1 = new ExRateHistoryVO();
							ObjectCloner.build(custDailyExrateVos[i], hisVO1);
							hisVO1.setOpStsNm("Deleted");
							historyVoList.add(hisVO1);
						}
					}
				}
				
				if (insertVoList.size() > 0) {
					if(!str0008Flag.equals("Y")) {				
						CheckReturnVO checkReturnVO = dbDao.searchCustomerDailyExchangeRate(insertVoList);
		
						if(checkReturnVO != null){
							throw new EventException(new ErrorHandler("INV00052", new String[] {}).getMessage());
						}
					}
					
					dbDao.addCustomerDailyExchangeRate(insertVoList);
				}
				if (updateVoList.size() > 0) {
					dbDao.modifyCustomerDailyExchangeRate(updateVoList);
				}
				if (deleteVoList.size() > 0) {
					dbDao.removeCustomerDailyExchangeRate(deleteVoList);
				}
				
				if (vvdUpdateList.size() > 0) {
					dbDao.modifyVVDExRate(vvdUpdateList);
				}
				
				if (historyVoList.size() > 0  &&  str0008Flag.equals("Y") ) {
					dbDao.addExRateHistory(historyVoList);
				}
			}
		
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
	 *  Vietnam, China Daily rates register/modify/delete. each daily rates Bound/each money register/modify/delete<br>
  	 *  ERP AR Interface(EAI : FNS019-0001).<br>
	 * 
	 * @param CustDailyExRateVO[] custDailyExrateVos
	 * @param String userId
	 * @param String[] officeArr
	 * @return String
	 * @exception EventException
	 */
	public String manageCustomerDailyExchangeRateMulti(CustDailyExRateVO[] custDailyExrateVos, String userId, String[] officeArr) throws EventException {
		
		String tmpPK = "";
		
		try {
			
			tmpPK = JSPUtil.getKST("yyyyMMddHHmmss");
			
			List<DailyExchangeRateTmpVO> insertVoList = new ArrayList<DailyExchangeRateTmpVO>();
			
					
			for (int i = 0; i < custDailyExrateVos.length; i++) {
				custDailyExrateVos[i].setUsrId(userId);
				if (custDailyExrateVos[i].getIbflag().equals("I")) { 					
					
					//for(int k=0; k < officeArr.length ; k++) {
						//if(!officeArr[k].equals("ALL") && !officeArr[k].equals("")) { 
							if ((custDailyExrateVos[i].getIoBndCd().trim().isEmpty()) || (custDailyExrateVos[i].getIoBndCd().trim().equals("ALL"))) {
								
								DailyExchangeRateTmpVO vo = new DailyExchangeRateTmpVO();	
								
								
								ObjectCloner.build(custDailyExrateVos[i], vo);
						//		vo.setArOfcCd(officeArr[k]);
								vo.setArOfcCd("");
								vo.setIoBndCd("I");
								vo.setAttrCtnt1(tmpPK);		
								vo.setAttrCtnt2(custDailyExrateVos[i].getIbflag());
								vo.setAttrCtnt3(custDailyExrateVos[i].getIvsXchRt());
								vo.setAttrCtnt4(custDailyExrateVos[i].getCngRmk());
								vo.setAttrCtnt5(custDailyExrateVos[i].getUpdUsrId());
								insertVoList.add(vo);
								
								vo = new DailyExchangeRateTmpVO();
								ObjectCloner.build(custDailyExrateVos[i], vo);
							//	vo.setArOfcCd(officeArr[k]);
								vo.setArOfcCd("");
								vo.setAttrCtnt1(tmpPK);		
								vo.setAttrCtnt2(custDailyExrateVos[i].getIbflag());
								vo.setAttrCtnt3(custDailyExrateVos[i].getIvsXchRt());
								vo.setAttrCtnt4(custDailyExrateVos[i].getCngRmk());
								vo.setAttrCtnt5(custDailyExrateVos[i].getUpdUsrId());
								vo.setIoBndCd("O");
								insertVoList.add(vo);				
								
	
							} else {
								DailyExchangeRateTmpVO vo = new DailyExchangeRateTmpVO();	
								vo = new DailyExchangeRateTmpVO();
								ObjectCloner.build(custDailyExrateVos[i], vo);
							//	vo.setArOfcCd(officeArr[k]);
								vo.setArOfcCd("");
								vo.setAttrCtnt1(tmpPK);		
								vo.setAttrCtnt2(custDailyExrateVos[i].getIbflag());
								vo.setAttrCtnt3(custDailyExrateVos[i].getIvsXchRt());
								vo.setAttrCtnt4(custDailyExrateVos[i].getCngRmk());
								vo.setAttrCtnt5(custDailyExrateVos[i].getUpdUsrId());
								insertVoList.add(vo);
								
							}
						//}
					//}
				} else if (custDailyExrateVos[i].getIbflag().equals("U") || custDailyExrateVos[i].getIbflag().equals("D") ) { 
					DailyExchangeRateTmpVO vo = new DailyExchangeRateTmpVO();	
					vo = new DailyExchangeRateTmpVO();
					ObjectCloner.build(custDailyExrateVos[i], vo);
					vo.setAttrCtnt1(tmpPK);		
					vo.setAttrCtnt2(custDailyExrateVos[i].getIbflag());
					vo.setAttrCtnt3(custDailyExrateVos[i].getIvsXchRt());
					vo.setAttrCtnt4(custDailyExrateVos[i].getCngRmk());
					vo.setAttrCtnt5(custDailyExrateVos[i].getUpdUsrId());
					insertVoList.add(vo);
				}
				
				
			}
			
			if (insertVoList.size() > 0) {			
				dbDao.addDailyExchangeRateTmp(insertVoList);
			}

		} catch (EventException ex) {			
			throw ex;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("INV00053", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("INV00053", new String[] {}).getMessage(), ex);
		}
		
		return tmpPK;
	}
	

	
	/**
	 * Validation of Rate<br>
	 * @param targetVal : inputted rate
	 * @param baseVal : latest rate
	 * @param bound : Bound 
	 * @param Seq : Seq 
	 * @return 0 : 불가, 1 : OK  
	 * @author KIM OK RYE
	 * @version 2014.12.18
	 * @comment 입력된 환율과 가장 최근 날짜의 환율을 비교하여 30% 이상 차이 불가, 5%~30% 범위내 경고후 yes/no 선택후 진행여부 결정
	 *          최초 데이타 입력시 무조건 OK 
	 */		
/*	private boolean chkIORate(String targetVal, String baseVal, String bound, String office, String chgCurr) throws EventException {
		
		
		if (baseVal.equals("NO_DATA") || baseVal.equals("0")) {
			return true;
		}
		
		String preMsg = "[Office : "+office+", Bound : "+bound+", Charge Curr : " + chgCurr +"]";			
		
		float fTarget = Float.parseFloat(targetVal);
		float fBaseVal = Float.parseFloat(baseVal);
		float varRate = fTarget/fBaseVal;
		
		if((varRate > 1.3) || ((varRate < 0.7))) {   // +- 30% 초과
			//alert("+-30check");
			
			Double.parseDouble((fBaseVal * 1.3)+"");
			
			
			String plus30Rate =  ( fBaseVal * 1.3 ) + "";
			String minus30Rate = ( fBaseVal * 0.7 ) + "";
			
			throw new EventException(new ErrorHandler("INV00190", new String[] {preMsg,  minus30Rate + "~" + plus30Rate}).getMessage());
			
			
			//ComShowCodeMessage("INV00142",preMsg, minus30Rate + "~" + plus30Rate  );  //{?msg1}Rate exceed 30% tolerance of latest rate: {?msg2}\nYou do not have the securityto overwrite the exchange rate.
			//return 0;
			
			return false;
		} else	if( ((varRate >= 1.05) && (varRate <= 1.3)) ||  ((varRate >= 0.7) && (varRate <= 0.95))    ) {  // +-  5%이상, 30% 이하
			//alert("+-5~30check");
			String minus5Rate = ComRound ( fBaseVal * 0.95, 6 ) ;
			String plus30Rate = ComRound ( fBaseVal * 1.3, 6 ) ;
			
			//if (ComShowCodeConfirm("INV00143", preMsg , minus5Rate + "~" +plus30Rate)) {   //{?msg1}Rate exceed 5% tolerance level of latest rate {?msg2}\nDo you want to proceed anyway?
			//	return 1;
			//} else {
			//	return 0;
			//}
			
			return false;
		} else {
			return true;
			//return 1;
		}
		
	}
	*/

	/**
	 * Customer ratesregister various Customer same rates apply<br>
  	 * ERP AR Interface(EAI : FNS019-0001)<br>
	 * 
	 * @param MultiCustomerVO[] multiCustomerVos
	 * @param CustDailyExRateVO[] custDailyExRateVos
	 * @param String userId
	 * @exception EventException
	 */
	public void manageMultiCustomerExRate(MultiCustomerVO[] multiCustomerVos, CustDailyExRateVO[] custDailyExRateVos, String userId) throws EventException {
		try {
			List<CustDailyExRateVO> erpVoList = new ArrayList<CustDailyExRateVO>(); // For erp
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

							list = (List<CustDailyExRateVO>) dbDao.searchMultiCustomerExRate(custDailyExRateVos[j]);
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

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("INV00053", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("INV00053", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * rates Type Customer apply rates retrieve<br>
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
	 * Customer by month register rates check <br>
	 * 
	 * @param String cust_cnt_cd
	 * @param String cust_seq
	 * @param String mon
	 * @return int
	 * @exception EventException
	 */
	public int searchCustomerMonExRate(String cust_cnt_cd, String cust_seq, String mon) throws EventException {
		int cnt = 0; // retrieve data total count
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
	 * retrieve condition Port list data<br>
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
	 * VVD and Flight information reference rates retrieve <br>
   	 * select Bound I/B. O/B.<br>
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
	 * VVD  and Flight information reference rates retrieve<br>
   	 * select Triangle.<br>
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
	 * VVD  and Flight information reference rates retrieve<br>
   	 * select EUR.<br>
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
	 * EUR in case, Flight information Create VVD, PORT list retrieve<br>
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
	 *  rates taget VSL SKD retrieve, each VVD rates Bound/port/service scop/each money register<br>
	 * 
	 * @param List<VVDandPortListVO>  vvdPortListVos
	 * @param List<VVDExrateVO> vvdExRtVos
	 * @param String userId
	 * @exception EventException
	 */
	public void createVVDExchangeRate(List<VVDandPortListVO> vvdPortListVos, List<VVDExrateVO> vvdExRtVos, String userId) throws EventException {
		try {
			List<VVDExrateVO> erpVoList = new ArrayList<VVDExrateVO>(); // for erp
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
	 * ratesdelete  AR Invoice(Charge) validate data rates apply retrieve.<br>
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
	 * each VVD rates Bound/port/service scop/each money register/modify/delete<br>
     * ERP AR Interface(EAI : FNS019-0002).<br>
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

			for (int i = 0; i < vvdExrateVos.length; i++) {
				vvdExrateVos[i].setVslCd(vvdExrateVos[i].getVvdCd().substring(0, 4));
				vvdExrateVos[i].setSkdVoyNo(vvdExrateVos[i].getVvdCd().substring(4, 8));
				vvdExrateVos[i].setSkdDirCd(vvdExrateVos[i].getVvdCd().substring(8, 9));

				if (vvdExrateVos[i].getIbflag().equals("I")) {
					vvdExrateVos[i].setCreUsrId(userId);
					insertVoList.add(vvdExrateVos[i]);
				} else if (vvdExrateVos[i].getIbflag().equals("U")) {
					vvdExrateVos[i].setUpdUsrId(userId);
					updateVoList.add(vvdExrateVos[i]);
				} else if (vvdExrateVos[i].getIbflag().equals("D")) {
					deleteVoList.add(vvdExrateVos[i]);
				}
			}

			if (insertVoList.size() > 0) {
				int cnt = dbDao.searchVVDExRateDuplicate(insertVoList);
				if(cnt > 0){
					throw new EventException(new ErrorHandler("INV00052", new String[] {}).getMessage());
				}
				dbDao.addVVDExchangeRate(insertVoList);
			}
			if (updateVoList.size() > 0) {
				dbDao.modifyVVDExchangeRate(updateVoList);
			}
			if (deleteVoList.size() > 0) {
				dbDao.removeVVDExchangeRate(deleteVoList);
			}
			
		} catch (EventException ex) {			
			throw ex;
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
	 * rates type list retrieve<br>
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
				// Daily & China in case custCntCd, custSeq 'XX', '0' retrieve
				if (searchVVDexRateVO.getXchRtTpCd().equals("C") || searchVVDexRateVO.getXchRtTpCd().equals("D")) {
					searchExRateVO.setCustCntCd("XX");
					searchExRateVO.setCustSeq("0");
				}
				else {
					searchExRateVO.setCustCntCd(searchVVDexRateVO.getCustCntCd());
					searchExRateVO.setCustSeq(searchVVDexRateVO.getCustSeq());
				}
				if(searchVVDexRateVO.getXchRtTpCd().equals("D")) {
					searchExRateVO.setXchRtTpCd("V");
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
	 * Currency MDM_ORGANIZATION AR Currency register check<br>
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
	
	/**
	 * Vessel Schedule 테이블에서 VVD에 해당하는 PORT를 조회하여 해당 List에 Setting한다.<br>
	 * 
	 * @param String vvd
	 * @return List<String>
	 * @exception EventException
	 */
	public List<String> searchPortListbyVVD(String vvd) throws EventException {
		try {
			List<String> list = dbDao.searchPortListbyVVD(vvd);
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
	 * Vessel Schedule 의 Lane 으로 Service Scope 을 구해 List에 Setting한다.<br>
	 * 
	 * @param String vvd
	 * @return List<String>
	 * @exception EventException
	 */
	public List<String> searchSvcScpByLane(String vvd) throws EventException {
		try {
			List<String> list = dbDao.searchSvcScpByLane(vvd);
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
	 * INV_VVD_XCH_RT_DT 테이블에 조건에 해당하는 환율기준날짜를 조회한다.<br>
	 * 
	 * @param SearchVVDExRateVO searchVVDexRateVO
	 * @return List<VVDExrateVO>
	 * @exception EventException
	 */
	public List<VVDExrateVO> searchVVDExRateDateList(SearchVVDExRateVO searchVVDexRateVO) throws EventException {
		try {
			return dbDao.searchVVDExRateDateList(searchVVDexRateVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * VVD 환율기준날짜 및 VVD 환율을 입력/수정/삭제한다.<br>
	 * 
	 * @param VVDExrateVO[] vvdExrateVos
	 * @param String userId
	 * @param String uiFlag
	 * @return List<VVDExrateVO>
	 * @exception EventException
	 */
	public List<VVDExrateVO> manageVVDExchangeRateDate(VVDExrateVO[] vvdExrateVos, String userId, String uiFlag) throws EventException {
		try {
			List<VVDExrateVO> insertVoList = new ArrayList<VVDExrateVO>();
			List<VVDExrateVO> updateVoList = new ArrayList<VVDExrateVO>();
			List<VVDExrateVO> deleteVoList = new ArrayList<VVDExrateVO>();
			List<VVDExrateVO> targetVoList = new ArrayList<VVDExrateVO>();
			VVDExrateDateHisVO[] vvdExrateDateHisVos = new VVDExrateDateHisVO[vvdExrateVos.length];
			List<VVDExrateDateHisVO> insertHisVoList = new ArrayList<VVDExrateDateHisVO>();
			List<VVDExrateDateHisVO> updateHisVoList = new ArrayList<VVDExrateDateHisVO>();
			List<VVDExrateDateHisVO> deleteHisVoList = new ArrayList<VVDExrateDateHisVO>();

			for (int i = 0; i < vvdExrateVos.length; i++) {

				vvdExrateVos[i].setVslCd(vvdExrateVos[i].getVvdCd().substring(0, 4));
				vvdExrateVos[i].setSkdVoyNo(vvdExrateVos[i].getVvdCd().substring(4, 8));
				vvdExrateVos[i].setSkdDirCd(vvdExrateVos[i].getVvdCd().substring(8, 9));

				vvdExrateDateHisVos[i] = new VVDExrateDateHisVO();

				String hisSeq = dbDao.searchVVDExRateDateHistSeq();
				vvdExrateDateHisVos[i].setHisSeq(hisSeq);
				vvdExrateDateHisVos[i].setVslCd(vvdExrateVos[i].getVvdCd().substring(0, 4));
				vvdExrateDateHisVos[i].setSkdVoyNo(vvdExrateVos[i].getVvdCd().substring(4, 8));
				vvdExrateDateHisVos[i].setSkdDirCd(vvdExrateVos[i].getVvdCd().substring(8, 9));
				vvdExrateDateHisVos[i].setSkdVoyNo(vvdExrateVos[i].getSkdVoyNo());
				vvdExrateDateHisVos[i].setSkdDirCd(vvdExrateVos[i].getSkdDirCd());
				vvdExrateDateHisVos[i].setPortCd(vvdExrateVos[i].getPortCd());
				vvdExrateDateHisVos[i].setSvcScpCd(vvdExrateVos[i].getSvcScpCd());
				vvdExrateDateHisVos[i].setIoBndCd(vvdExrateVos[i].getIoBndCd());
				vvdExrateDateHisVos[i].setArOfcCd(vvdExrateVos[i].getArOfcCd());
				vvdExrateDateHisVos[i].setXchRtDt(vvdExrateVos[i].getXchRtDt());
				vvdExrateDateHisVos[i].setCngRmk(vvdExrateVos[i].getCngRmk());

				if (vvdExrateVos[i].getIbflag().equals("I")) {
					if(vvdExrateVos[i].getSvcScpCd().equals("ALL")){
						List<String> svcScpList = dbDao.searchSvcScpByLane(vvdExrateVos[i].getVvdCd());
						for (int j = 0; j < svcScpList.size(); j++) {
							VVDExrateVO vvdExrateVo = new VVDExrateVO();
							vvdExrateVo.setVslCd(vvdExrateVos[i].getVvdCd().substring(0, 4));
							vvdExrateVo.setSkdVoyNo(vvdExrateVos[i].getVvdCd().substring(4, 8));
							vvdExrateVo.setSkdDirCd(vvdExrateVos[i].getVvdCd().substring(8, 9));
							vvdExrateVo.setPortCd(vvdExrateVos[i].getPortCd());
							vvdExrateVo.setSvcScpCd(svcScpList.get(j));
							vvdExrateVo.setIoBndCd(vvdExrateVos[i].getIoBndCd());
							vvdExrateVo.setArOfcCd(vvdExrateVos[i].getArOfcCd());
							vvdExrateVo.setXchRtDt(vvdExrateVos[i].getXchRtDt());
							vvdExrateVo.setCngRmk(vvdExrateVos[i].getCngRmk());							
							vvdExrateVo.setCreUsrId(userId);
							insertVoList.add(vvdExrateVo);
							targetVoList.add(vvdExrateVo);
						}
					}else{
						vvdExrateVos[i].setCreUsrId(userId);
						insertVoList.add(vvdExrateVos[i]);
						targetVoList.add(vvdExrateVos[i]);
					}
					vvdExrateDateHisVos[i].setCreUsrId(userId);
					vvdExrateDateHisVos[i].setOpStsNm("added");
					insertHisVoList.add(vvdExrateDateHisVos[i]);
				} else if (vvdExrateVos[i].getIbflag().equals("U")) {
					vvdExrateVos[i].setCreUsrId(userId);
					vvdExrateVos[i].setUpdUsrId(userId);
					updateVoList.add(vvdExrateVos[i]);
					targetVoList.add(vvdExrateVos[i]);
					vvdExrateDateHisVos[i].setCreUsrId(userId);
					vvdExrateDateHisVos[i].setOpStsNm("modified");
					updateHisVoList.add(vvdExrateDateHisVos[i]);
				} else if (vvdExrateVos[i].getIbflag().equals("D")) {
					vvdExrateVos[i].setUpdUsrId(userId);
					deleteVoList.add(vvdExrateVos[i]);
					vvdExrateDateHisVos[i].setCreUsrId(userId);
					vvdExrateDateHisVos[i].setOpStsNm("deleted");
					deleteHisVoList.add(vvdExrateDateHisVos[i]);
				}
				//2015.05.27 Exchange Rate Creation for 3rd Office by IY Cho
				if(("Y").equals(uiFlag)){
					vvdExrateVos[i].setUpdUsrId(userId);
				    List<VVDExrateVO> vvd3rdVo = dbDao.search3rdExRate(vvdExrateVos[i]);
				    List<VVDExrateDateHisVO> vvd3rdHisVo = dbDao.search3rdExRateHis(vvdExrateVos[i]);
				    
				    for (int k = 0; k < vvd3rdVo.size(); k++){
				        updateVoList.add(vvd3rdVo.get(k));
				        targetVoList.add(vvd3rdVo.get(k));
				        updateHisVoList.add(vvd3rdHisVo.get(k));
				    }
				} 
			}

			if (insertVoList.size() > 0) {
				int cnt = dbDao.searchVVDExRateDuplicate(insertVoList);
				if(cnt > 0){
					throw new EventException(new ErrorHandler("INV00052", new String[] {}).getMessage());
				}
				dbDao.removeVVDExchangeRateByDate(insertVoList);
				dbDao.addVVDExchangeRateDate(insertVoList);
				dbDao.addVVDExchangeRateDateHis(insertHisVoList);
				dbDao.addVVDExchangeRateByDate(insertVoList);
			}
			if (updateVoList.size() > 0) {
				dbDao.modifyVVDExchangeRateDate(updateVoList);
				dbDao.addVVDExchangeRateDateHis(updateHisVoList);
				dbDao.removeVVDExchangeRateByDate(updateVoList);
				dbDao.addVVDExchangeRateByDate(updateVoList);
			}
			if (deleteVoList.size() > 0) {
				dbDao.removeVVDExchangeRateDate(deleteVoList);
				dbDao.addVVDExchangeRateDateHis(deleteHisVoList);
				dbDao.removeVVDExchangeRateByDate(deleteVoList);
			}
			
			return targetVoList;
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
	 * INV_VVD_XCH_RT_DT_HIS 테이블에서 환율기준날짜 History 를 조회한다.<br>
	 * 
	 * @param VVDExrateDateHisVO vvdExrateDateHisVO
	 * @return List<VVDExrateDateHisVO>
	 * @exception EventException
	 */
	public List<VVDExrateDateHisVO> searchVVDExRateDateHistList(VVDExrateDateHisVO vvdExrateDateHisVO) throws EventException {
		try {
			return dbDao.searchVVDExRateDateHistList(vvdExrateDateHisVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * INV AR CHARGE 테이블에서 해당 환율이 반영된 데이터가 존재하는지 체크한다.<br>
	 * 
	 * @param VVDExrateVO[] vvdExrateVos
	 * @return String
	 * @exception EventException
	 */
	public String searchARInvoiceExist2(VVDExrateVO[] vvdExrateVos) throws EventException {
		try {
			return dbDao.searchARInvoiceExist2(vvdExrateVos);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * DAILY 환율 (환율타입:V) 이 존재하는지 체크한다.<br>
	 * 
	 * @param VVDExrateVO[] vvdExrateVos
	 * @return String
	 * @exception EventException
	 */
	public String searchDailyExRateExist(VVDExrateVO[] vvdExrateVos) throws EventException {
		try {
			return dbDao.searchDailyExRateExist(vvdExrateVos);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * INV_VVD_XCH_RT 테이블의 환율을 조회한다.<br>
	 * 
	 * @param VVDExrateVO vvdExrateVO
	 * @return List<ExchangeRateVO>
	 * @exception DAOException
	 */
	public List<ExchangeRateVO> searchVVDExRate(VVDExrateVO vvdExrateVO) throws EventException {
		try {
			return dbDao.searchVVDExRate(vvdExrateVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * Ex.Rate History retrieve<br>
	 * 
	 * @param SearchExRateVO searchExRateVO
	 * @return List<ExRateHistoryVO>
	 * @exception EventException
	 */
	public List<ExRateHistoryVO> searchExRateHistoryList(SearchExRateVO searchExRateVO) throws EventException {
		try {
			return dbDao.searchExRateHistoryList(searchExRateVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}		
	}
	
	
	/**
	 * xch_rt_tp_cd retrieve<br>
	 * 
	 * @param String arOfcCd
	 * @return String
	 * @exception EventException
	 */
	public String searchXchRtTpCd(String arOfcCd) throws EventException {
		try {
			return dbDao.searchXchRtTpCd(arOfcCd);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}	
	}
	
	/**
	 * searchDailyExchangeRateTmpList retrieve<br>
	 * 
	 * @param String arOfcList
	 * @param String tmpPK
	 * @return List<DailyExchangeRateTmpVO>
	 * @exception EventException
	 */
	public List<DailyExchangeRateTmpVO> searchDailyExchangeRateTmpList(String arOfcList, String tmpPK) throws EventException {
		try {
			return dbDao.searchDailyExchangeRateTmpList(arOfcList, tmpPK);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}	
	}

	/**
	 * removeDailyExchangeRateTmpList <br>
	 * 
	 * @param String tmpPK
	 * @exception EventException
	 */
	public void removeDailyExchangeRateTmpList(String tmpPK) throws EventException {
		try {
			List<DailyExchangeRateTmpVO> dailyExchangeRateTmpVOs = new ArrayList<DailyExchangeRateTmpVO>();
			DailyExchangeRateTmpVO vo = new DailyExchangeRateTmpVO();
			vo.setAttrCtnt1(tmpPK);
			dailyExchangeRateTmpVOs.add(vo);
			dbDao.removeDailyExchangeRateTmp(dailyExchangeRateTmpVOs);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}	
	}
	
	/**
	 * Check whether VVD exchange rate date exists but VVD rate doesn't exist<br>
	 * 
	 * @param String fmDt
	 * @param String ofcList
	 * @return String
	 * @exception EventException
	 */
	public String search3rdExRateNotExist(String fmDt, String ofcList) throws EventException {
		try {
			return dbDao.search3rdExRateNotExist(fmDt, ofcList);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}
}