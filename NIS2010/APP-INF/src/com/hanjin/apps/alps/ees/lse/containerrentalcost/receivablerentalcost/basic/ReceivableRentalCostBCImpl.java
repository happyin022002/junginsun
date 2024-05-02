/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ReceivableRentalCostBCImpl.java
*@FileTitle : EQ Receivable Charge Summary By Charge Type
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.17
*@LastModifier : 진준성
*@LastVersion : 1.0
* 2009.08.17 진준성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerrentalcost.receivablerentalcost.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.ees.lse.containerrentalcost.receivablerentalcost.integration.ReceivableRentalCostDBDAO;
import com.hanjin.apps.alps.ees.lse.containerrentalcost.receivablerentalcost.vo.ReceivableChargeDetailVO;
import com.hanjin.apps.alps.ees.lse.containerrentalcost.receivablerentalcost.vo.ReceivableChargeVO;
import com.hanjin.apps.alps.ees.lse.containerrentalcost.receivablerentalcost.vo.ReceivableInvoiceCostVO;
import com.hanjin.apps.alps.ees.lse.containerrentalcost.receivablerentalcost.vo.ReceivableInvoiceInquiryVO;
import com.hanjin.apps.alps.ees.lse.containerrentalcost.receivablerentalcost.vo.ReceivableInvoiceVO;
import com.hanjin.apps.alps.ees.lse.containerrentalcost.receivablerentalcost.vo.ReportSearchReceivableVO;
import com.hanjin.apps.alps.ees.lse.containerrentalcost.receivablerentalcost.vo.SearchParamVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.ARInterfaceCreationVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.InvArIfChgVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.InvArIfCntrVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.InvArIfMnVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-ContainerRentalCost Business Logic Basic Command implementation<br>
 * - ALPS-ContainerRentalCost에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Jin Jun Sung
 * @see EES_LSE_0074EventResponse,ReceivableRentalCostBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class ReceivableRentalCostBCImpl extends BasicCommandSupport implements ReceivableRentalCostBC {

	// Database Access Object
	private transient ReceivableRentalCostDBDAO dbDao = null;

	/**
	 * ReceivableRentalCostBCImpl 객체 생성<br>
	 * ReceivableRentalCostDBDAO를 생성한다.<br>
	 */
	public ReceivableRentalCostBCImpl() {
		dbDao = new ReceivableRentalCostDBDAO();
	}
	/**
	 * Receivable Invoice 한 결과에 대하여 Charge Type별로 실적을 조회<br>
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
	 * 입력 월에 대한 Receivable Rental Charge 작업 실행여부를 확인합니다.<br>
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
	 * 입력 월에 대한 Receivable Rental Charge 작업 현황목록을 조회합니다.<br>
	 *
	 * @param  SearchParamVO searchParamVO
	 * @return List<ReceivableChargeVO>
	 * @exception EventException
	 */
	public List<ReceivableChargeVO> searchReceivableRentalChargeListBasic(SearchParamVO searchParamVO) throws EventException {
		List<ReceivableChargeVO> resultVOs = null; // 데이터 전송을 위해 VO 객체

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
	 * 입력 월에 대한 Receivable Rental Preparation 일괄작업을 수행합니다.<br>
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
	 * 계약번호별 Receivable Rental Charge Creation 일괄작업을 수행합니다.<br>
	 *
	 * @param ReceivableChargeVO[] receivableChargeVOs
	 * @param SignOnUserAccount userAccount
	 * @exception EventException
	 */
	public void manageReceivableChargeCreationListBasic(ReceivableChargeVO[] receivableChargeVOs, SignOnUserAccount userAccount) throws EventException {
		//데이터 전송을 위해 VO 객체
		List<ReceivableChargeDetailVO> resultVOs = null;
		ReceivableChargeDetailVO resultVO = null;
		final String strZero = "0";

		try {
			for(int i = 0; i < receivableChargeVOs.length; i++) {
				if(receivableChargeVOs[i].getRcvRntlSeq().equals("") == false) {
					//1.계약번호별 Receivable Rental Charge Creation 작업대상 장비목록을 조회합니다.
					resultVOs = dbDao.searchReceivableRentalChargeDetailListData(receivableChargeVOs[i]);
					int iRcvRntlDtlSeq = 1;

					//2.계약번호별 Receivable Rental Charge Detail Creation 자료를 일괄 생성합니다.
					for(int j = 0; j < resultVOs.size(); j++) {
						resultVO = resultVOs.get(j);
						resultVO.setCreUsrId(userAccount.getUsr_id());
						resultVO.setOfcCd(userAccount.getOfc_cd());

						//2-1.장비번호별 Receivable Rental Charge Detail Creation 자료를 생성합니다.
						resultVO.setRcvRntlDtlSeq(Integer.toString(iRcvRntlDtlSeq++));
						dbDao.addReceivableRentalChargeDetailData(resultVO);

						//Receivable PDM Charge 자료에 대하여만 PUC/PCR/LON/LOF 자료를 추가생성한다.
						if(resultVO.getLseRcvChgTpCd().equals("PDM")) {
							//2-2.장비번호별 Receivable Pick-Up Charge Detail Creation 자료를 생성합니다.
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

							//2-3.장비번호별 Receivable Lift-On Charge Detail Creation 자료를 생성합니다.
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

							//2-4.장비번호별 Receivable Lift-Off Charge Detail Creation 자료를 생성합니다.
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
						}
					}
				}


				//3.계약번호별 Receivable Rental Charge Creation 자료를 개별 저장합니다.
				if(receivableChargeVOs[i].getRcvRntlSeq().equals("")) {
					receivableChargeVOs[i].setCreUsrId(userAccount.getUsr_id());
					receivableChargeVOs[i].setOfcCd(userAccount.getOfc_cd());
					dbDao.addReceivableRentalChargeData(receivableChargeVOs[i]);
				} else {
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
	 * 계약번호별 Receivable Rental Charge Recreation 일괄작업을 수행합니다.<br>
	 *
	 * @param ReceivableChargeVO[] receivableChargeVOs
	 * @param SignOnUserAccount userAccount
	 * @exception EventException
	 */
	public void manageReceivableChargeRecreationListBasic(ReceivableChargeVO[] receivableChargeVOs, SignOnUserAccount userAccount) throws EventException {
		try {
			//1.장비번호별 Receivable Rental Charge Detail Creation 자료를 삭제합니다.
			for(int i = 0; i < receivableChargeVOs.length; i++) {
				dbDao.removeReceivableRentalChargeDetailListData(receivableChargeVOs[i]);
			}

			//2.계약번호별 Receivable Rental Charge Creation 일괄작업을 수행합니다.
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
	 * Receivable Rental Charge Creation 처리된 내역을 조회합니다.<br>
	 *
	 * @param SearchParamVO searchParamVO
	 * @return List<ReceivableChargeVO>
	 * @exception EventException
	 */
	public List<ReceivableChargeVO> searchReceivableRentalChargeInfoBasic(SearchParamVO searchParamVO) throws EventException {
		List<ReceivableChargeVO> resultVOs = null; // 데이터 전송을 위해 VO 객체

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
	 * 신규 Receivable Rental Invoice Number를 조회합니다.<br>
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
	 * 입력받은 AGMT No.에 대한 Receivable Charge 허용여부를 조회합니다.<br>
	 *
	 * @param  String agmtSeq
	 * @param  String qtyYrmon
	 * @return List<ReceivableChargeVO>
	 * @exception EventException
	 */
	public List<ReceivableChargeVO> searchReceivableAgreementAvailInfoBasic(String agmtSeq, String qtyYrmon) throws EventException {
		List<ReceivableChargeVO> resultVOs = null; // 데이터 전송을 위해 VO 객체

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
	 * Receivable Rental Invoice Summary 내역을 조회합니다.<br>
	 *
	 * @param  SearchParamVO searchParamVO
	 * @return List<ReceivableInvoiceVO>
	 * @exception EventException
	 */
	public List<ReceivableInvoiceVO> searchReceivableInvoiceSummaryListBasic(SearchParamVO searchParamVO) throws EventException {
		List<ReceivableInvoiceVO> resultVOs = null; // 데이터 전송을 위해 VO 객체

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
	 * Receivable Rental Invoice Amount 정보를 확인합니다.<br>
	 *
	 * @param  SearchParamVO searchParamVO
	 * @return List<ReceivableInvoiceVO>
	 * @exception EventException
	 */
	public List<ReceivableInvoiceVO> searchReceivableInvoiceAmountInfoBasic(SearchParamVO searchParamVO) throws EventException {
		List<ReceivableInvoiceVO> resultVOs = null; // 데이터 전송을 위해 VO 객체

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
	 * Invoice 정보를 조회하여 Account Receivable I/F 요청자료로 변환한다.<br>
	 *
	 * @param  SearchParamVO searchParamVO
	 * @return List<ARInterfaceCreationVO>
	 * @exception EventException
	 */
	public List<ARInterfaceCreationVO> searchGeneralARInterfaceCreationBasic(SearchParamVO searchParamVO) throws EventException {
		List<ARInterfaceCreationVO> resultVOs = new ArrayList<ARInterfaceCreationVO>(); // 데이터 전송을 위해 VO 객체
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
	 * 계약번호별 Receivable Rental Invoice Creation 일괄작업을 수행합니다.<br>
	 *
	 * @param  ReceivableInvoiceVO[] receivableInvoiceVOs
	 * @param  SearchParamVO searchParamVO
	 * @param  SignOnUserAccount userAccount
	 * @exception EventException
	 */
	public void createReceivableInvoiceCreationListBasic(ReceivableInvoiceVO[] receivableInvoiceVOs, SearchParamVO searchParamVO, SignOnUserAccount userAccount) throws EventException {
		int trxCnt = 0;

		try {
			//1.신규 Receivable Rental Invoice Number를 조회합니다.
			String invoiceNo = dbDao.searchNewReceivableInvoiceNumberData(searchParamVO.getQtyYrmon());
			if(invoiceNo.equals(searchParamVO.getInvNo()) == false) {//Invoice No 가 중복되는 경우
				throw new EventException(new ErrorHandler("LSE01094", new String[]{invoiceNo}).getMessage());
			}

			//2.계약번호별 Receivable Rental Invoice Creation 자료를 갱신합니다.
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
				receivableInvoiceVOs[i].setCfmFlg("N");
				receivableInvoiceVOs[i].setCfmOfcCd("");
				receivableInvoiceVOs[i].setCfmIfFlg("N");

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
	 * 계약번호별 Receivable Rental Invoice Confirm 일괄작업을 수행합니다.<br>
	 *
	 * @param  ReceivableInvoiceVO[] receivableInvoiceVOs
	 * @param  SearchParamVO searchParamVO
	 * @param  SignOnUserAccount userAccount
	 * @exception EventException
	 */
	public void createReceivableInvoiceConfirmListBasic(ReceivableInvoiceVO[] receivableInvoiceVOs, SearchParamVO searchParamVO, SignOnUserAccount userAccount) throws EventException {
		int trxCnt = 0;

		try {
			//-------------------------------------------------------------------------------------------------
			//[주]INV I/F 와의 생성 Invoice Number 의 동기화 위하여 searchGeneralARInterfaceCreationBasic()로 이관 - 2010.03.15
			//-------------------------------------------------------------------------------------------------
			//1.신규 Receivable Rental Invoice Number를 조회합니다.
			//String invoiceNo = dbDao.searchNewReceivableInvoiceNumberData(searchParamVO.getQtyYrmon());

			//if(invoiceNo.equals(searchParamVO.getInvNo()) == false) {//Invoice No 가 중복되는 경우
			//	throw new EventException(new ErrorHandler("LSE01094", new String[]{invoiceNo}).getMessage());
			//}

			//2.계약번호별 Receivable Rental Invoice Confirm 자료를 갱신합니다.
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
				receivableInvoiceVOs[i].setCfmFlg("Y");
				receivableInvoiceVOs[i].setCfmOfcCd(userAccount.getOfc_cd());
				receivableInvoiceVOs[i].setCfmIfFlg("Y");

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
	 * Receivable Rental Invoice Cost 목록을 조회합니다.<br>
	 *
	 * @param  SearchParamVO searchParamVO
	 * @return List<ReceivableInvoiceCostVO>
	 * @exception EventException
	 */
	public List<ReceivableInvoiceCostVO> searchReceivableInvoiceCostListBasic(SearchParamVO searchParamVO) throws EventException {
		List<ReceivableInvoiceCostVO> resultVOs = null; // 데이터 전송을 위해 VO 객체

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
	 * Receivable Rental Invoice Cost 내역에 대한 일괄작업을 수행합니다.<br>
	 *
	 * @param ReceivableInvoiceCostVO[] receivableInvoiceCostVOs
	 * @param SignOnUserAccount userAccount
	 * @exception EventException
	 */
	public void manageReceivableInvoiceCostListBasic(ReceivableInvoiceCostVO[] receivableInvoiceCostVOs, SignOnUserAccount userAccount) throws EventException {
		ReceivableChargeVO receivableChargeVO = null;

		try {
			for(int i = 0; i < receivableInvoiceCostVOs.length; i++) {
				//1.Receivable Rental Invoice Cost 자료를 개별 저장합니다.
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

				//2.Receivable Rental Charge Creation 자료를 개별 갱신합니다.
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
	 * Receivable Rental Invoice Charge I/F 현황을 조회합니다.<br>
	 *
	 * @param  SearchParamVO searchParamVO
	 * @return List<ReceivableInvoiceInquiryVO>
	 * @exception EventException
	 */
	public List<ReceivableInvoiceInquiryVO> searchReceivableInvoiceInquiryListBasic(SearchParamVO searchParamVO) throws EventException {
		List<ReceivableInvoiceInquiryVO> resultVOs = null; // 데이터 전송을 위해 VO 객체

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
	 * Invoice Cancel 정보를 조회하여 Account Receivable I/F 요청자료로 변환한다.<br>
	 *
	 * @param  ReceivableInvoiceInquiryVO receivableInvoiceInquiryVO
	 * @return List<ARInterfaceCreationVO>
	 * @exception EventException
	 */
	public List<ARInterfaceCreationVO> searchGeneralARInterfaceCancelBasic(ReceivableInvoiceInquiryVO receivableInvoiceInquiryVO) throws EventException {
		List<ARInterfaceCreationVO> resultVOs = new ArrayList<ARInterfaceCreationVO>(); // 데이터 전송을 위해 VO 객체
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
	 * Receivable Rental Invoice Charge I/F 처리내역을 취소합니다.<br>
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
}