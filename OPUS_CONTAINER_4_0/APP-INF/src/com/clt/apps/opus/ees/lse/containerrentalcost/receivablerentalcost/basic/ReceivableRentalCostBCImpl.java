/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ReceivableRentalCostBCImpl.java
*@FileTitle : EQ Receivable Charge Summary By Charge Type
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.lse.containerrentalcost.receivablerentalcost.basic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.ees.lse.containerrentalcost.receivablerentalcost.integration.ReceivableRentalCostDBDAO;
import com.clt.apps.opus.ees.lse.containerrentalcost.receivablerentalcost.vo.ReceivableChargeDetailVO;
import com.clt.apps.opus.ees.lse.containerrentalcost.receivablerentalcost.vo.ReceivableChargeVO;
import com.clt.apps.opus.ees.lse.containerrentalcost.receivablerentalcost.vo.ReceivableInvoiceCostVO;
import com.clt.apps.opus.ees.lse.containerrentalcost.receivablerentalcost.vo.ReceivableInvoiceInquiryVO;
import com.clt.apps.opus.ees.lse.containerrentalcost.receivablerentalcost.vo.ReceivableInvoiceVO;
import com.clt.apps.opus.ees.lse.containerrentalcost.receivablerentalcost.vo.ReportSearchReceivableVO;
import com.clt.apps.opus.ees.lse.containerrentalcost.receivablerentalcost.vo.SearchParamVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.ARInterfaceCreationVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.InvArIfChgVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.InvArIfCntrVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.InvArIfMnVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.util.ScheduleUtil;

/**
 * ContainerRentalCost Business Logic Basic Command implementation<br>
 *
 * @author 
 * @see EES_LSE_0074EventResponse,ReceivableRentalCostBC
 * @since J2EE 1.6
 */
public class ReceivableRentalCostBCImpl extends BasicCommandSupport implements ReceivableRentalCostBC {

	// Database Access Object
	private transient ReceivableRentalCostDBDAO dbDao = null;

	/**
	 * creating ReceivableRentalCostBCImpl object<br>
	 * creating ReceivableRentalCostDBDAO<br>
	 */
	public ReceivableRentalCostBCImpl() {
		dbDao = new ReceivableRentalCostDBDAO();
	}
	/**
	 * retrieving for Receivable Invoice<br>
	 *
	 * @param  ReportSearchReceivableVO reportSearchReceivableVO
	 * @return List<ReportSearchReceivableVO>
	 * @exception EventException
	 */
	public List<ReportSearchReceivableVO> searchReceivableRentalReportBasic(ReportSearchReceivableVO reportSearchReceivableVO) throws EventException {
		List<ReportSearchReceivableVO> list = null;

		try {
			if( reportSearchReceivableVO.getReportType() != null  && "rp_0074".equals(reportSearchReceivableVO.getReportType())){
            	list  = dbDao.searchReceivableRentalReportByChargeTypeData(reportSearchReceivableVO); //0074
			}else if( reportSearchReceivableVO.getReportType() != null  && "rp_0075".equals(reportSearchReceivableVO.getReportType())){
            	list  = dbDao.searchReceivableRentalReportByTySzMonthData(reportSearchReceivableVO);      //0075
            }else if( reportSearchReceivableVO.getReportType() != null  && "rp_0076".equals(reportSearchReceivableVO.getReportType())){
            	list  = dbDao.searchReceivableRentalReportByChargeTypeTySzData(reportSearchReceivableVO); //0076
            }else if( reportSearchReceivableVO.getReportType() != null  && "rp_0077".equals(reportSearchReceivableVO.getReportType())){
            	list  = dbDao.searchReceivableRentalReportByLeaseTermMonthData(reportSearchReceivableVO); //0077
            }else if( reportSearchReceivableVO.getReportType() != null  && "rp_0078".equals(reportSearchReceivableVO.getReportType())){
            	list  = dbDao.searchReceivableRentalReportByLessorMonthData(reportSearchReceivableVO);    //0078
            }else if( reportSearchReceivableVO.getReportType() != null  && "rp_0079".equals(reportSearchReceivableVO.getReportType())){
            	list  = dbDao.searchReceivablebyLessorMonthReportData(reportSearchReceivableVO);    //0079
            }

		} catch(DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"ReceivableRentalReport Search"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"ReceivableRentalReport Search"}).getMessage(),ex);
		}
		return list;
	}

	/**
	 * checking Receivable Rental Charge execution<br>
	 *
	 * @param  SearchParamVO searchParamVO
	 * @return boolean
	 * @exception EventException
	 */
	public boolean isExecuteReceivableRentalChargeBasic(SearchParamVO searchParamVO) throws EventException {
		boolean execFlag = false;

		try {
			List<ReceivableChargeVO> resultVOs = dbDao.searchReceivableRentalChargeListData(searchParamVO);
			execFlag = resultVOs.size() > 0 ? true : false;
		} catch(DAOException de) {
			log.error("err " + de.getMessage(), de);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"ReceivableRentalChargeList Search"}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"ReceivableRentalChargeList Search"}).getMessage(),ex);
		}

		return execFlag;
	}

	/**
	 * retrieving for Receivable Rental Charge list<br>
	 *
	 * @param  SearchParamVO searchParamVO
	 * @return List<ReceivableChargeVO>
	 * @exception EventException
	 */
	public List<ReceivableChargeVO> searchReceivableRentalChargeListBasic(SearchParamVO searchParamVO) throws EventException {
		List<ReceivableChargeVO> resultVOs = null; 

		try {
			resultVOs = dbDao.searchReceivableRentalChargeListData(searchParamVO);
		} catch(DAOException de) {
			log.error("err " + de.getMessage(), de);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"ReceivableRentalChargeList Search"}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"ReceivableRentalChargeList Search"}).getMessage(),ex);
		}

		return resultVOs;
	}

	/**
	 * 입creating Receivable Rental Preparation list<br>
	 *
	 * @param SearchParamVO searchParamVO
	 * @param SignOnUserAccount userAccount
	 * @exception EventException
	 */
	public void createReceivableRentalPreparationListBasic(SearchParamVO searchParamVO, SignOnUserAccount userAccount) throws EventException {
		try {
			searchParamVO.setCreUsrId(userAccount.getUsr_id());
			searchParamVO.setOfcCd(userAccount.getOfc_cd());
			dbDao.addReceivableRentalPreparationListData(searchParamVO);
		} catch(DAOException de) {
			log.error("err " + de.getMessage(), de);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"ReceivableRentalPreparationList Create"}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"ReceivableRentalPreparationList Create"}).getMessage(),ex);
		}
	}

	/**
	 * 계creating Receivable Rental Charge Creation list<br>
	 *
	 * @param ReceivableChargeVO[] receivableChargeVOs
	 * @param SignOnUserAccount userAccount
	 * @exception EventException
	 */
	public void manageReceivableChargeCreationListBasic(ReceivableChargeVO[] receivableChargeVOs, SignOnUserAccount userAccount) throws EventException {
		
		List<ReceivableChargeDetailVO> resultVOs = null;
		ReceivableChargeDetailVO resultVO = null;
		final String strZero = "0";

		try {
			for(int i = 0; i < receivableChargeVOs.length; i++) {
				
				//0.saving Receivable Rental Charge Creation 
				if(receivableChargeVOs[i].getRcvRntlSeq().equals("")) {
					receivableChargeVOs[i].setCreUsrId(userAccount.getUsr_id());
					receivableChargeVOs[i].setOfcCd(userAccount.getOfc_cd());
					dbDao.addReceivableRentalChargeData(receivableChargeVOs[i]);
					String newRcvRntlSeq = dbDao.searchReceivableRentalChargeSeqbyManualData(receivableChargeVOs[i]);
					receivableChargeVOs[i].setRcvRntlSeq(newRcvRntlSeq);					
				}
				
				if(receivableChargeVOs[i].getRcvRntlSeq().equals("") == false) {
					
					//1.retrieving for Receivable Rental Charge Creation target
					resultVOs = dbDao.searchReceivableRentalChargeDetailListData(receivableChargeVOs[i]);
					int iRcvRntlDtlSeq = 1;

					//2.creating Receivable Rental Charge Detail Creation 
					for(int j = 0; j < resultVOs.size(); j++) {
						resultVO = resultVOs.get(j);
						resultVO.setCreUsrId(userAccount.getUsr_id());
						resultVO.setOfcCd(userAccount.getOfc_cd());

						//2-1.creating Receivable Rental Charge Detail Creation 
						resultVO.setRcvRntlDtlSeq(Integer.toString(iRcvRntlDtlSeq++));
						dbDao.addReceivableRentalChargeDetailData(resultVO);

						//creating PUC/PCR/LON/LOF for Receivable PDM Charge 
						if(resultVO.getLseRcvChgTpCd().equals("PDM")) {
							//2-2.creating Receivable Pick-Up Charge Detail Creation 
							if(resultVO.getPkupChgFlg().equals("NON") == false) {//Pick-Up Charge
						    	resultVO.setRcvRntlDtlSeq(Integer.toString(iRcvRntlDtlSeq++));
						    	resultVO.setTtlDys(strZero);
						    	resultVO.setFreeDys(strZero);
						    	resultVO.setBilDys(strZero);
						    	resultVO.setLseRcvChgTpCd(resultVO.getPkupChgFlg());
						    	resultVO.setChgRtAmt(resultVO.getPkupChgAmt());
						    	resultVO.setCostAmt(resultVO.getPkupChgAmt());
								dbDao.addReceivableRentalChargeDetailData(resultVO);
							}

							//2-3.creating Receivable Lift-On Charge Detail Creation 
							if(resultVO.getLonChgFlg().equals("NON") == false) {//Lift-On Charge
								resultVO.setRcvRntlDtlSeq(Integer.toString(iRcvRntlDtlSeq++));
								resultVO.setTtlDys(strZero);
						    	resultVO.setFreeDys(strZero);
						    	resultVO.setBilDys(strZero);
						    	resultVO.setLseRcvChgTpCd(resultVO.getLonChgFlg());
						    	resultVO.setChgRtAmt(resultVO.getLftChgAmt());
						    	resultVO.setCostAmt(resultVO.getLftChgAmt());
								dbDao.addReceivableRentalChargeDetailData(resultVO);
							}

							//2-4.creating Receivable Lift-Off Charge Detail Creation 
							if(resultVO.getLofChgFlg().equals("NON") == false) {//Lift-Off Charge
								resultVO.setRcvRntlDtlSeq(Integer.toString(iRcvRntlDtlSeq++));
								resultVO.setTtlDys(strZero);
						    	resultVO.setFreeDys(strZero);
						    	resultVO.setBilDys(strZero);
								resultVO.setLseRcvChgTpCd(resultVO.getLofChgFlg());
						    	resultVO.setChgRtAmt(resultVO.getLftChgAmt());
						    	resultVO.setCostAmt(resultVO.getLftChgAmt());
								dbDao.addReceivableRentalChargeDetailData(resultVO);
							}
							
							//2-5.creating Receivable Gate In Charge Detail Creation 
							if(resultVO.getGtiChgFlg().equals("GTI") == true) {//Gate In Charge
								resultVO.setRcvRntlDtlSeq(Integer.toString(iRcvRntlDtlSeq++));
								resultVO.setTtlDys(strZero);
						    	resultVO.setFreeDys(strZero);
						    	resultVO.setBilDys(strZero);
								resultVO.setLseRcvChgTpCd(resultVO.getGtiChgFlg());
						    	resultVO.setChgRtAmt(resultVO.getGtiChgAmt());
						    	resultVO.setCostAmt(resultVO.getGtiChgAmt());
								dbDao.addReceivableRentalChargeDetailData(resultVO);
							}	
							
							//2-6.creating Receivable Gate In Charge Detail Creation 
							if(resultVO.getGtoChgFlg().equals("GTO") == true) {//Gate OUT Charge
								resultVO.setRcvRntlDtlSeq(Integer.toString(iRcvRntlDtlSeq++));
								resultVO.setTtlDys(strZero);
						    	resultVO.setFreeDys(strZero);
						    	resultVO.setBilDys(strZero);
								resultVO.setLseRcvChgTpCd(resultVO.getGtoChgFlg());
						    	resultVO.setChgRtAmt(resultVO.getGtoChgAmt());
						    	resultVO.setCostAmt(resultVO.getGtoChgAmt());
								dbDao.addReceivableRentalChargeDetailData(resultVO);
							}							
						}
					}
				}

				if(receivableChargeVOs[i].getRcvRntlSeq().equals("")== false) {
					//0.saving Receivable Rental Charge Creation 
					receivableChargeVOs[i].setUpdUsrId(userAccount.getUsr_id());
					dbDao.modifyReceivableRentalChargeData(receivableChargeVOs[i]);					
				}

			}
		} catch(DAOException de) {
			log.error("err " + de.getMessage(), de);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"ReceivableChargeCreationList Manage"}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"ReceivableChargeCreationList Manage"}).getMessage(),ex);
		}
	}

	/**
	 * creating Receivable Rental Charge Recreation list<br>
	 *
	 * @param ReceivableChargeVO[] receivableChargeVOs
	 * @param SignOnUserAccount userAccount
	 * @exception EventException
	 */
	public void manageReceivableChargeRecreationListBasic(ReceivableChargeVO[] receivableChargeVOs, SignOnUserAccount userAccount) throws EventException {
		try {
			//1.removing Receivable Rental Charge Detail Creation 
			for(int i = 0; i < receivableChargeVOs.length; i++) {
				dbDao.removeReceivableRentalChargeDetailListData(receivableChargeVOs[i]);
			}

			//2.creating Receivable Rental Charge Creation 
			manageReceivableChargeCreationListBasic(receivableChargeVOs, userAccount);
		} catch(DAOException de) {
			log.error("err " + de.getMessage(), de);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"ReceivableChargeRecreationList Manage"}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"ReceivableChargeRecreationList Manage"}).getMessage(),ex);
		}
	}

	/**
	 * retrieving for Receivable Rental Charge (Re)Creation<br>
	 *
	 * @param SearchParamVO searchParamVO
	 * @return List<ReceivableChargeVO>
	 * @exception EventException
	 */
	public List<ReceivableChargeVO> searchReceivableRentalChargeInfoBasic(SearchParamVO searchParamVO) throws EventException {
		List<ReceivableChargeVO> resultVOs = null; 

		try {
			resultVOs = dbDao.searchReceivableRentalChargeInfoData(searchParamVO);
		} catch(DAOException de) {
			log.error("err " + de.getMessage(), de);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"ReceivableRentalChargeInfo Search"}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"ReceivableRentalChargeInfo Search"}).getMessage(),ex);
		}

		return resultVOs;
	}

	/**
	 * retrieving for new Receivable Rental Invoice Number<br>
	 *
	 * @param  String qtyYrmon
	 * @return String
	 * @exception EventException
	 */
	public String searchNewReceivableInvoiceNumberBasic(String qtyYrmon) throws EventException {
		String invoiceNo = null;

		try {
			invoiceNo = dbDao.searchNewReceivableInvoiceNumberData(qtyYrmon);
		} catch(DAOException de) {
			log.error("err " + de.getMessage(), de);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"NewReceivableInvoiceNumber Search"}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"NewReceivableInvoiceNumber Search"}).getMessage(),ex);
		}

		return invoiceNo;
	}

	/**
	 * retrieving for Receivable Charge avail<br>
	 *
	 * @param  String agmtSeq
	 * @param  String qtyYrmon
	 * @return List<ReceivableChargeVO>
	 * @exception EventException
	 */
	public List<ReceivableChargeVO> searchReceivableAgreementAvailInfoBasic(String agmtSeq, String qtyYrmon) throws EventException {
		List<ReceivableChargeVO> resultVOs = null; 

		try {
			resultVOs = dbDao.searchReceivableAgreementAvailInfoData(agmtSeq, qtyYrmon);
		} catch(DAOException de) {
			log.error("err " + de.getMessage(), de);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"ReceivableAgreementAvailInfo Search"}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"ReceivableAgreementAvailInfo Search"}).getMessage(),ex);
		}

		return resultVOs;
	}

	/**
	 * retrieving for Receivable Rental Invoice Summary <br>
	 *
	 * @param  SearchParamVO searchParamVO
	 * @return List<ReceivableInvoiceVO>
	 * @exception EventException
	 */
	public List<ReceivableInvoiceVO> searchReceivableInvoiceSummaryListBasic(SearchParamVO searchParamVO) throws EventException {
		List<ReceivableInvoiceVO> resultVOs = null; 

		try {
			resultVOs = dbDao.searchReceivableInvoiceSummaryListData(searchParamVO);
		} catch(DAOException de) {
			log.error("err " + de.getMessage(), de);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"ReceivableInvoiceSummaryList Search"}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"ReceivableInvoiceSummaryList Search"}).getMessage(),ex);
		}

		return resultVOs;
	}

	/**
	 * retrieving for Receivable Rental Invoice Amount <br>
	 *
	 * @param  SearchParamVO searchParamVO
	 * @return List<ReceivableInvoiceVO>
	 * @exception EventException
	 */
	public List<ReceivableInvoiceVO> searchReceivableInvoiceAmountInfoBasic(SearchParamVO searchParamVO) throws EventException {
		List<ReceivableInvoiceVO> resultVOs = null; 

		try {
			resultVOs = dbDao.searchReceivableInvoiceAmountInfoData(searchParamVO);
		} catch(DAOException de) {
			log.error("err " + de.getMessage(), de);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"ReceivableInvoiceAmountInfo Search"}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"ReceivableInvoiceAmountInfo Search"}).getMessage(),ex);
		}

		return resultVOs;
	}

	/**
	 * creating Receivable Rental Invoice Confirm by agreement No.<br>
	 *
	 * @param  SearchParamVO searchParamVO
	 * @return List<ARInterfaceCreationVO>
	 * @exception EventException
	 */
	public List<ARInterfaceCreationVO> searchGeneralARInterfaceCreationBasic(SearchParamVO searchParamVO) throws EventException {
		List<ARInterfaceCreationVO> resultVOs = new ArrayList<ARInterfaceCreationVO>(); 
		ARInterfaceCreationVO aRInterfaceCreationVO = new ARInterfaceCreationVO();

		InvArIfMnVO invArIfMnVO = new InvArIfMnVO();
		List<InvArIfChgVO> invArIfChgVOs = new ArrayList<InvArIfChgVO>();
		List<InvArIfCntrVO> invArIfCntrVOs = new ArrayList<InvArIfCntrVO>();

		try {
			invArIfMnVO    = dbDao.searchGeneralARInterfaceInvoiceInfoData(searchParamVO);
			invArIfChgVOs  = dbDao.searchGeneralARInterfaceChargeListData(searchParamVO);
			invArIfCntrVOs = dbDao.searchGeneralARInterfaceContainersData(searchParamVO);

			aRInterfaceCreationVO.setInvArIfMnVO(invArIfMnVO);
			aRInterfaceCreationVO.setInvArIfChgVOs(invArIfChgVOs);
			aRInterfaceCreationVO.setInvArIfCntrVOs(invArIfCntrVOs);

			resultVOs.add(aRInterfaceCreationVO);
		} catch(DAOException de) {
			log.error("err " + de.getMessage(), de);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"GeneralARInterfaceCreation Search"}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"GeneralARInterfaceCreation Search"}).getMessage(),ex);
		}

		return resultVOs;
	}

	/**
	 * creating Receivable Rental Invoice Creation by agreement No.<br>
	 *
	 * @param  ReceivableInvoiceVO[] receivableInvoiceVOs
	 * @param  SearchParamVO searchParamVO
	 * @param  SignOnUserAccount userAccount
	 * @exception EventException
	 */
	public void createReceivableInvoiceCreationListBasic(ReceivableInvoiceVO[] receivableInvoiceVOs, SearchParamVO searchParamVO, SignOnUserAccount userAccount) throws EventException {
		int trxCnt = 0;

		try {
			//1.retrieving for new Receivable Rental Invoice Number
			String invoiceNo = dbDao.searchNewReceivableInvoiceNumberData(searchParamVO.getQtyYrmon());
			if(invoiceNo.equals(searchParamVO.getInvNo()) == false) {//Invoice No 가 중복되는 경우
				throw new EventException(new ErrorHandler("LSE01094", new String[]{invoiceNo}).getMessage());
			}

			//2.updating Receivable Rental Invoice Creation 
			for(int i = 0; i < receivableInvoiceVOs.length; i++) {
				receivableInvoiceVOs[i].setInvNo(searchParamVO.getInvNo());
				//receivableInvoiceVOs[i].setInvAmt(receivableInvoiceVOs[i].getCostAmt());
				receivableInvoiceVOs[i].setSrcIfSeq("");
				receivableInvoiceVOs[i].setSrcIfDt("");
				receivableInvoiceVOs[i].setInvIsuDt(searchParamVO.getInvIsuDt());
				receivableInvoiceVOs[i].setInvDueDt(searchParamVO.getInvDueDt());
				receivableInvoiceVOs[i].setUpdUsrId(userAccount.getUsr_id());
				receivableInvoiceVOs[i].setOfcCd(userAccount.getOfc_cd());
				receivableInvoiceVOs[i].setCustCntCd(searchParamVO.getCustCntCd());
				receivableInvoiceVOs[i].setCustSeq(searchParamVO.getCustSeq());
				receivableInvoiceVOs[i].setLoclTaxFlg(searchParamVO.getLoclTaxFlg());
				receivableInvoiceVOs[i].setToCurrRt(searchParamVO.getToCurrRt());
				receivableInvoiceVOs[i].setToCurrCd(searchParamVO.getToCurrCd());
				receivableInvoiceVOs[i].setInvTaxRt(searchParamVO.getInvTaxRt());
				receivableInvoiceVOs[i].setCfmFlg("N");
				receivableInvoiceVOs[i].setCfmOfcCd("");
				receivableInvoiceVOs[i].setCfmIfFlg("N");
				receivableInvoiceVOs[i].setTaxAmount(searchParamVO.getTaxAmount());

				trxCnt += dbDao.modifyReceivableRentalInvoiceData(receivableInvoiceVOs[i]);
			}

			if(trxCnt == 0) {
				throw new EventException(new ErrorHandler("LSE01095",new String[]{"User Information"}).getMessage());
			}
		} catch(EventException ee) {
			log.error("err " + ee.getMessage(), ee);
			throw ee;
		} catch(DAOException de) {
			log.error("err " + de.getMessage(), de);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"ReceivableInvoiceCreationList Create"}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"ReceivableInvoiceCreationList Create"}).getMessage(),ex);
		}
	}

	/**
	 * creating Receivable Rental Invoice Confirm by agreement No.<br>
	 *
	 * @param  ReceivableInvoiceVO[] receivableInvoiceVOs
	 * @param  SearchParamVO searchParamVO
	 * @param  SignOnUserAccount userAccount
	 * @exception EventException
	 */
	public void createReceivableInvoiceConfirmListBasic(ReceivableInvoiceVO[] receivableInvoiceVOs, SearchParamVO searchParamVO, SignOnUserAccount userAccount) throws EventException {
		int trxCnt = 0;

		try {
			//String invoiceNo = dbDao.searchNewReceivableInvoiceNumberData(searchParamVO.getQtyYrmon());

			//if(invoiceNo.equals(searchParamVO.getInvNo()) == false) {
			//	throw new EventException(new ErrorHandler("LSE01094", new String[]{invoiceNo}).getMessage());
			//}

			//2.updating Receivable Rental Invoice Confirm
			for(int i = 0; i < receivableInvoiceVOs.length; i++) {
				receivableInvoiceVOs[i].setInvNo(searchParamVO.getInvNo());
				//receivableInvoiceVOs[i].setInvAmt(receivableInvoiceVOs[i].getCostAmt());
				receivableInvoiceVOs[i].setSrcIfSeq(searchParamVO.getSrcIfSeq());
				receivableInvoiceVOs[i].setSrcIfDt(searchParamVO.getSrcIfDt());
				receivableInvoiceVOs[i].setInvIsuDt(searchParamVO.getInvIsuDt());
				receivableInvoiceVOs[i].setInvDueDt(searchParamVO.getInvDueDt());
				receivableInvoiceVOs[i].setUpdUsrId(userAccount.getUsr_id());
				receivableInvoiceVOs[i].setOfcCd(userAccount.getOfc_cd());
				receivableInvoiceVOs[i].setCustCntCd(searchParamVO.getCustCntCd());
				receivableInvoiceVOs[i].setCustSeq(searchParamVO.getCustSeq());
				receivableInvoiceVOs[i].setLoclTaxFlg(searchParamVO.getLoclTaxFlg());
				receivableInvoiceVOs[i].setToCurrRt(searchParamVO.getToCurrRt());
				receivableInvoiceVOs[i].setToCurrCd(searchParamVO.getToCurrCd());
				receivableInvoiceVOs[i].setInvTaxRt(searchParamVO.getInvTaxRt());
				receivableInvoiceVOs[i].setCfmFlg("Y");
				receivableInvoiceVOs[i].setCfmOfcCd(userAccount.getOfc_cd());
				receivableInvoiceVOs[i].setCfmIfFlg("Y");
				receivableInvoiceVOs[i].setTaxAmount(searchParamVO.getTaxAmount());

				trxCnt += dbDao.modifyReceivableRentalInvoiceData(receivableInvoiceVOs[i]);
			}

			if(trxCnt == 0) {
				throw new EventException(new ErrorHandler("LSE01095",new String[]{"User Information"}).getMessage());
			}
		} catch(EventException ee) {
			log.error("err " + ee.getMessage(), ee);
			throw ee;
		} catch(DAOException de) {
			log.error("err " + de.getMessage(), de);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"ReceivableInvoiceConfirmList Create"}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"ReceivableInvoiceConfirmList Create"}).getMessage(),ex);
		}
	}

	/**
	 * retrieving for Receivable Rental Invoice Cost<br>
	 *
	 * @param  SearchParamVO searchParamVO
	 * @return List<ReceivableInvoiceCostVO>
	 * @exception EventException
	 */
	public List<ReceivableInvoiceCostVO> searchReceivableInvoiceCostListBasic(SearchParamVO searchParamVO) throws EventException {
		List<ReceivableInvoiceCostVO> resultVOs = null; 

		try {
			resultVOs = dbDao.searchReceivableInvoiceCostListData(searchParamVO);
		} catch(DAOException de) {
			log.error("err " + de.getMessage(), de);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"ReceivableInvoiceCostList Search"}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"ReceivableInvoiceCostList Search"}).getMessage(),ex);
		}

		return resultVOs;
	}

	/**
	 * saving Receivable Rental Invoice Cost<br>
	 *
	 * @param ReceivableInvoiceCostVO[] receivableInvoiceCostVOs
	 * @param SignOnUserAccount userAccount
	 * @exception EventException
	 */
	public void manageReceivableInvoiceCostListBasic(ReceivableInvoiceCostVO[] receivableInvoiceCostVOs, SignOnUserAccount userAccount) throws EventException {
		ReceivableChargeVO receivableChargeVO = null;

		try {
			for(int i = 0; i < receivableInvoiceCostVOs.length; i++) {
				//1.saving Receivable Rental Invoice Cost 
				if(receivableInvoiceCostVOs[i].getIbflag().equals("I")) {
					receivableInvoiceCostVOs[i].setCreUsrId(userAccount.getUsr_id());
					receivableInvoiceCostVOs[i].setOfcCd(userAccount.getOfc_cd());
					dbDao.addReceivableInvoiceCostData(receivableInvoiceCostVOs[i]);
				} else {
					String rcvChgCreCd = receivableInvoiceCostVOs[i].getIbflag();
					receivableInvoiceCostVOs[i].setLseRcvChgCreCd(rcvChgCreCd);
					receivableInvoiceCostVOs[i].setUpdUsrId(userAccount.getUsr_id());
					dbDao.modifyReceivableInvoiceCostData(receivableInvoiceCostVOs[i]);
				}

				receivableChargeVO = new ReceivableChargeVO();
				receivableChargeVO.setCostYrmon(receivableInvoiceCostVOs[i].getCostYrmon());
				receivableChargeVO.setAgmtCtyCd(receivableInvoiceCostVOs[i].getAgmtCtyCd());
				receivableChargeVO.setAgmtSeq(receivableInvoiceCostVOs[i].getAgmtSeq());
				receivableChargeVO.setRcvRntlSeq(receivableInvoiceCostVOs[i].getRcvRntlSeq());
				receivableChargeVO.setUpdUsrId(userAccount.getUsr_id());

				//2.saving Receivable Rental Charge Creation 
				dbDao.modifyReceivableRentalChargeData(receivableChargeVO);
			}

		} catch(DAOException de) {
			log.error("err " + de.getMessage(), de);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"ReceivableInvoiceCostList Manage"}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"ReceivableInvoiceCostList Manage"}).getMessage(),ex);
		}
	}

	/**
	 * retrieving for Receivable Rental Invoice Charge I/F<br>
	 *
	 * @param  SearchParamVO searchParamVO
	 * @return List<ReceivableInvoiceInquiryVO>
	 * @exception EventException
	 */
	public List<ReceivableInvoiceInquiryVO> searchReceivableInvoiceInquiryListBasic(SearchParamVO searchParamVO) throws EventException {
		List<ReceivableInvoiceInquiryVO> resultVOs = null; 

		try {
			resultVOs = dbDao.searchReceivableInvoiceInquiryListData(searchParamVO);
		} catch(DAOException de) {
			log.error("err " + de.getMessage(), de);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"ReceivableInvoiceInquiryList Search"}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"ReceivableInvoiceInquiryList Search"}).getMessage(),ex);
		}

		return resultVOs;
	}

	/**
	 * retrieving for Invoice Cancel & trasnforming Account Receivable I/F <br>
	 *
	 * @param  ReceivableInvoiceInquiryVO receivableInvoiceInquiryVO
	 * @return List<ARInterfaceCreationVO>
	 * @exception EventException
	 */
	public List<ARInterfaceCreationVO> searchGeneralARInterfaceCancelBasic(ReceivableInvoiceInquiryVO receivableInvoiceInquiryVO) throws EventException {
		List<ARInterfaceCreationVO> resultVOs = new ArrayList<ARInterfaceCreationVO>(); 
		ARInterfaceCreationVO aRInterfaceCreationVO = new ARInterfaceCreationVO();

		InvArIfMnVO invArIfMnVO = new InvArIfMnVO();
		List<InvArIfChgVO> invArIfChgVOs = new ArrayList<InvArIfChgVO>();
		List<InvArIfCntrVO> invArIfCntrVOs = new ArrayList<InvArIfCntrVO>();

		try {
			invArIfMnVO    = dbDao.searchGeneralARInterfaceInvoiceCancelData(receivableInvoiceInquiryVO);
			invArIfChgVOs  = dbDao.searchGeneralARInterfaceChargeCancelData(receivableInvoiceInquiryVO);
			invArIfCntrVOs = dbDao.searchGeneralARInterfaceContainersCancelData(receivableInvoiceInquiryVO);

			aRInterfaceCreationVO.setInvArIfMnVO(invArIfMnVO);
			aRInterfaceCreationVO.setInvArIfChgVOs(invArIfChgVOs);
			aRInterfaceCreationVO.setInvArIfCntrVOs(invArIfCntrVOs);

			resultVOs.add(aRInterfaceCreationVO);
		} catch(DAOException de) {
			log.error("err " + de.getMessage(), de);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"GeneralARInterfaceCancel Search"}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"GeneralARInterfaceCancel Search"}).getMessage(),ex);
		}

		return resultVOs;
	}

	/**
	 * canceling Receivable Rental Invoice Charge I/F<br>
	 *
	 * @param ReceivableInvoiceInquiryVO receivableInvoiceInquiryVO
	 * @param SignOnUserAccount userAccount
	 * @exception EventException
	 */
	public void cancelReceivableInvoiceInquiryBasic(ReceivableInvoiceInquiryVO receivableInvoiceInquiryVO, SignOnUserAccount userAccount) throws EventException {
		try {
			if(receivableInvoiceInquiryVO.getIbflag().equals("U")) {
				receivableInvoiceInquiryVO.setCreUsrId(userAccount.getUsr_id());
				dbDao.modifyReceivableInvoiceCancelData(receivableInvoiceInquiryVO);
			}
		} catch(DAOException de) {
			log.error("err " + de.getMessage(), de);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"ReceivableInvoiceInquiry Cancel"}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"ReceivableInvoiceInquiry Cancel"}).getMessage(),ex);
		}
	}
	
	
	/**
	 * 
	 * @param qtyYrMon
	 * @param userAccount
	 * @return String
	 * @throws EventException
	 */
	public String createReceivableInvoiceChargeCreationBatchService(String qtyYrMon, SignOnUserAccount userAccount) throws EventException {
		
		ScheduleUtil su = new ScheduleUtil();
		String yyyymm = qtyYrMon.replaceAll("-", "");
		boolean bIsRunning;
		try {
			bIsRunning = su.isRunning("EES_LSE_B002");
		} catch (DAOException e) {
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"ReceiableChargeCreation BackEndJob"}).getUserMessage(),e);
		}
		log.debug("\n bIsRunning>> " + bIsRunning);
		if(bIsRunning)
			return "6";
		else{
			try {
				su.directExecuteJob("EES_LSE_B002", yyyymm);
			} catch (IOException e) {
				throw new EventException(new ErrorHandler("LSE10005", new String[]{"Estimate Creation"}).getUserMessage(),e);
			} catch (InterruptedException e) {
				throw new EventException(new ErrorHandler("LSE10005", new String[]{"Estimate Creation"}).getUserMessage(),e);
			} catch (DAOException e) {
				throw new EventException(new ErrorHandler("LSE10005", new String[]{"Estimate Creation"}).getUserMessage(),e);
			}
			return "4";
		}
	}
}