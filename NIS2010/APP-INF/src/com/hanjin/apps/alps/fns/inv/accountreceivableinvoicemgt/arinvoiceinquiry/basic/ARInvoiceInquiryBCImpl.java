/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ARInvoiceInquiryBCImpl.java
*@FileTitle : Invoice Inquiry by I/F No - General
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.04
*@LastModifier : 김세일
*@LastVersion : 1.0
* 2009.05.04 김세일
* 1.0 Creation
 * --------------------------------------------------------
 * History
 * 2010.12.28 최도순 [CHM-201007700] ALPS AR INV ''Transaction Data Comparison Report'' 기능 개발 요청(신규)
 * 2011.04.18 최도순 [CHM-201109030-01] Intra - Europe Business 관련 VAT 기능 개발
 * 2013.09.23 임옥영 [] Customer Inquiry by B/L No 개발
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.vo.CheckReturnVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.vo.CustDailyExRateVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.vo.ExchangeRateVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.ARInvoiceChargeCorrectionVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.ARInvoiceCorrectionVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.BillInputVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.integration.ARInvoiceInquiryDBDAO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.ARInvoiceByBLNoVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.ARInvoiceChargeByBLNoVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.ARInvoiceChargeSumVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.ARInvoiceContainerVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.ARInvoiceHistoryByBLNoVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.ARInvoiceInputByBLNoVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.ARInvoiceInquiryInPutVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.ARInvoiceIssueDateVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.ARInvoiceListByIFDateVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.ARInvoiceNoGoodInPutVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.ARInvoiceNoGoodNotIssueListVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.BKGForTaxByDateVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.BKGForTaxByVesselVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.DXBInvoiceListVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.ErpErrorInputVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.ErpErrorVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.FaxEmailSentDateVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.FaxEmailSentResultVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.GCFSAFChargeListVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.GSTChargeListVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.InvoiceDetailListVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.InvoiceDetailVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.InvoiceIssueDateVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.InvoiceIssueListInputVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.InvoiceIssueTVAListVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.InvoiceSumVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.InvoiceSummaryListVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.InvoiceTermAnalysisInputVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.InvoiceTermAnalysisVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.NYCInvoiceIssueDateVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.NotIssuedAgingInputVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.NotIssuedAgingVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.NotIssuedListVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.NotissuedInputVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.PCFRevExpnAmountVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.PCFStatusInfoInputVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.PCFStatusInfoVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.ReportForReverseChargeVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.SpainInvoiceEDIListCountVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.SpainInvoiceEDIListVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.TransDataComparisonReportInputVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.TransDataComparisonReportVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.CustomerListByBLVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.InvoiceAKLBAVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.GeneralInvoiceVO;
import com.hanjin.apps.alps.fns.inv.invcommon.invcommon.vo.AROfficeListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

/**
 * ALPS-AccountReceivableInvoiceMgt Business Logic Basic Command implementation<br>
 * - ALPS-AccountReceivableInvoiceMgt에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author saeil kim
 * @see FNS_INV_0011_01EventResponse,ARInvoiceInquiryBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */

public class ARInvoiceInquiryBCImpl extends BasicCommandSupport implements ARInvoiceInquiryBC {

	// Database Access Object
	private transient ARInvoiceInquiryDBDAO dbDao = null;

	/**
	 * ARInvoiceInquiryBCImpl 객체 생성<br>
	 * ARInvoiceInquiryDBDAO를 생성한다.<br>
	 */
	public ARInvoiceInquiryBCImpl() {
		dbDao = new ARInvoiceInquiryDBDAO();
	}

	/**
	 * 조회 이벤트 처리<br>
	 * Good Date / IF Date 로 invoice 정보를 조회한다.<br>
	 * BL count 및 USD total amount, local total amount 화면하단에 보여줌<br>
	 * max period one office : 1 month, All : 10 days
	 * 
	 * @author JungJin Park
	 * @param  ARInvoiceInquiryInPutVO    invByGoodVO
	 * @return List<ARInvoiceListByIFDateVO>
	 * @exception EventException
	 */
	public List<ARInvoiceListByIFDateVO> searchARInvoiceListByGoodDate(ARInvoiceInquiryInPutVO invByGoodVO) throws EventException {
		List<ARInvoiceListByIFDateVO> resultVOs = null; // 데이터 전송을 위해 VO 객체
		InvoiceSumVO invoiceSumVO = null;
		
		try {
			resultVOs = dbDao.searchARInvoiceListByGoodDate(invByGoodVO);
			
			if ( resultVOs.size() > 0 ) {
				invoiceSumVO = dbDao.searchARInvoiceSumByGoodDate(invByGoodVO);
				
				resultVOs.get(0).setInvoiceSumVO(invoiceSumVO);
			}
		} catch (DAOException ex) {
			if (ex.toString().contains("ORA-01013")) {
				throw new EventException(new ErrorHandler("COM12244", new String[]{}).getMessage(), ex);
			} else {
				throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
			}
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage(), ex);
		}
		
		return resultVOs;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * office별  Invoice 정보를 Office , SA Date or Sailing Date, <br>
	 * Confirm Flag, Issue Flag, Rep customer(해당 office대표Customer) flag, ExRate Flag 조건으로 조회하여 엑셀파일로 생성/저장한다. <br>
	 * BL_INV_IF_DT 기간 최근 1년 데이터대상임.(SYSDATE-365) <br>
	 * 
	 * @author JungJin Park
	 * @param  ARInvoiceNoGoodInPutVO    noGoodNoIssueVO
	 * @return List<ARInvoiceNoGoodNotIssueListVO>
	 * @exception EventException
	 */
	public List<ARInvoiceNoGoodNotIssueListVO> searchNoGoodNotIssueList(ARInvoiceNoGoodInPutVO noGoodNoIssueVO) throws EventException {
		try {
			return dbDao.searchNoGoodNotIssueList(noGoodNoIssueVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage(), ex);
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * Invoice 발행 정보를 Invoice No 별로 조회한다.<br>
	 * 
	 * @author JungJin Park
	 * @param String invNo
	 * @param String ofc
	 * @return ARInvoiceByBLNoVO
	 * @exception EventException
	 */
	public ARInvoiceByBLNoVO searchInvoiceByInvoiceNo(String invNo, String ofc) throws EventException {
		try {
			ARInvoiceByBLNoVO aRInvoiceByBLNoVO = dbDao.searchInvoiceMainByInvoiceNo(invNo, ofc);
			
			if (aRInvoiceByBLNoVO != null) {
				List<ARInvoiceChargeByBLNoVO> listInvoiceChargeByBLNoVO = dbDao.searchInvoiceChargeByInvoiceNo(invNo, ofc);
				
				aRInvoiceByBLNoVO.setListInvoiceChargeByBLNoVO(listInvoiceChargeByBLNoVO);
			}
			
			return aRInvoiceByBLNoVO;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage(), ex);
		}
	}

	/**
	 * 조회 이벤트 처리<br>
	 * Invoice 정보를 발행일자 기준으로 조회한다.<br>
	 * 
	 * @author JungJin Park
	 * @param  InvoiceIssueDateVO issueDateVo
	 * @return List<ARInvoiceIssueDateVO>
	 * @exception EventException
	 */
	public List<ARInvoiceIssueDateVO> searchInvoiceListByIssueDate(InvoiceIssueDateVO issueDateVo) throws EventException {
		try {
			return dbDao.searchInvoiceListByIssueDate(issueDateVo);
		} catch (DAOException ex) {
			if (ex.toString().contains("ORA-01013")) {
				throw new EventException(new ErrorHandler("COM12244", new String[]{}).getMessage(), ex);
			} else {
				throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
			}
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage(), ex);
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * Invoice 정보를 발행일자 기준으로 조회한다.<br>
	 * 
	 * @author JungJin Park
	 * @param  InvoiceIssueDateVO issueDateVo
	 * @return String
	 * @exception EventException
	 */
	public String searchInvoiceListByIssueDateSum(InvoiceIssueDateVO issueDateVo) throws EventException {
		try {
			return dbDao.searchInvoiceListByIssueDateSum(issueDateVo);
		} catch (DAOException ex) {
			if (ex.toString().contains("ORA-01013")) {
				throw new EventException(new ErrorHandler("COM12244", new String[]{}).getMessage(), ex);
			} else {
				throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
			}
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage(), ex);
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * 구주지역 TVA 관련된 발행된 Invoice 정보를 발행일자로 조회하여 엑셀파일로 다운로드 하는 기능이다.<br>
	 * 
	 * @author JungJin Park
	 * @param  InvoiceIssueListInputVO invTvaVo
	 * @return List<InvoiceIssueTVAListVO>
	 * @exception EventException
	 */
	public List<InvoiceIssueTVAListVO> searchInvoiceTvaListByDate(InvoiceIssueListInputVO invTvaVo) throws EventException {
		try {
			if (invTvaVo.getOffice().equals("SGNSC")) {
				return dbDao.searchInvoiceSGNBBVatListByDate(invTvaVo);
			}
			else if (invTvaVo.getOffice().equals("SYDSC")) {
				return dbDao.searchInvoiceSYDBBGstListByDate(invTvaVo);
			}
			else {
				return dbDao.searchInvoiceTvaListByDate(invTvaVo);
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage(), ex);
		}
	}
	
	/**
	 * 베트남(SGNSC) Office전용. Date 기준으로 Booking 의 각종 정보들을 구한다. <br>
	 * 
	 * @param String frDate
	 * @param String toDate
	 * @param String port
	 * @return List<BKGForTaxByDateVO>
	 * @exception EventException
	 */
	public List<BKGForTaxByDateVO> searchVIEBookingListByDate(String frDate, String toDate, String port) throws EventException {
		try {
			return dbDao.searchVIEBookingListByDate(frDate, toDate, port);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}

	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * 매출채권 및 Invoice 정보를 B/L No 로 조회한다.<br>
	 * 
	 * @author JungJin Park
	 * @param ARInvoiceInputByBLNoVO invInput
	 * @return ARInvoiceByBLNoVO
	 * @exception EventException
	 */
	public ARInvoiceByBLNoVO searchARInvoiceByBLNo(ARInvoiceInputByBLNoVO invInput) throws EventException {
		try {
			ARInvoiceByBLNoVO aRInvoiceByBLNoVO = new ARInvoiceByBLNoVO();
			List<String> arOfcCdList = new ArrayList<String>();
			
			if (invInput.getOffice().equals("")) {
				List<String> tmpOfcCdList = new ArrayList<String>();
				String arOfcCd = "";
				String tmpArOfcCd = "";
				
				tmpOfcCdList = dbDao.searchARInvoiceOfcListByBLNo(invInput.getBlSrcNo(), invInput.getBkgNo(), invInput.getLoginOfcCd());
				if (tmpOfcCdList != null && tmpOfcCdList.size() > 0) {
					for (int i=0; i<tmpOfcCdList.size(); i++) {
						tmpArOfcCd = tmpOfcCdList.get(i).toString();
						
						String[] tmpArray = tmpArOfcCd.split(",");
						// 오피스 코드가 없을 경우 최초 조회되는 오피스로 조회한다.
						if (i == 0) {
							arOfcCd = tmpArray[0];
						}
						
						arOfcCdList.add(tmpArray[0]+"^"+tmpArray[1]);
					}
				}
				
				invInput.setOffice(arOfcCd);
			}
			
			String maxIfNo = dbDao.searchARInvoiceMaxIfNo(invInput);
			
			if (maxIfNo != null && maxIfNo.length() > 0) {
				aRInvoiceByBLNoVO = dbDao.searchARInvoiceMainByBlNo(maxIfNo);
				
				if (aRInvoiceByBLNoVO != null) {
					List<ARInvoiceChargeSumVO> listInvoiceChargeSumVO = dbDao.searchARInvoiceChargeSumByBLNo(invInput);
					List<ARInvoiceChargeByBLNoVO> listInvoiceChargeByBLNoVO = dbDao.searchARInvoiceChargeByBlNo(invInput);
					List<ARInvoiceHistoryByBLNoVO> listInvoiceHistoryByBLNoVO = dbDao.searchARInvoiceHistoryListByBLNo(invInput);
					List<ARInvoiceContainerVO> listInvoiceContainerVO = dbDao.searchContainerNoList(maxIfNo);
					
					aRInvoiceByBLNoVO.setListInvoiceChargeSumVO(listInvoiceChargeSumVO);
					aRInvoiceByBLNoVO.setListInvoiceChargeByBLNoVO(listInvoiceChargeByBLNoVO);
					aRInvoiceByBLNoVO.setListInvoiceHistoryByBLNoVO(listInvoiceHistoryByBLNoVO);
					aRInvoiceByBLNoVO.setListInvoiceContainerVO(listInvoiceContainerVO);
				}
			}
			
			if (aRInvoiceByBLNoVO != null) {
				aRInvoiceByBLNoVO.setListArOfcCd(arOfcCdList);
			}
			
			return aRInvoiceByBLNoVO;
		} 
		catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage(), ex);
		}
		catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage(), ex);
		}
	}
	
	/**
	 * VVD 기준으로 Booking 의 각종 정보들을 구한다. <br>
	 * 
	 * @param String vvd
	 * @return List<BKGForTaxByVesselVO>
	 * @exception EventException
	 */
	public List<BKGForTaxByVesselVO> searchThaiBookingListByVVD(String vvd) throws EventException {
		try {
			return dbDao.searchThaiBookingListByVVD(vvd);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * VVD or S/A date기준으로 India 지역 Office의 해당 국가 PORT관련 Booking rate 및 cntr 정보들을 구한다.<br>
	 * 
	 * @param ARInvoiceInquiryInPutVO indBkgVO
	 * @return List<BKGForTaxByVesselVO>
	 * @exception EventException
	 */
	public List<BKGForTaxByVesselVO> searchIndiaBookingListByVVD(ARInvoiceInquiryInPutVO indBkgVO) throws EventException {
	
		try {
			return dbDao.searchIndiaBookingListByVVD(indBkgVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}	
	
	/**
	 * 조회 이벤트 처리<br>
	 * 매출채권 및 Invoice 정보를 Interface No 로 조회한다.<br>
	 * 
	 * @author JungJin Park
	 * @param String ifNo
	 * @param String ofc
	 * @return ARInvoiceCorrectionVO
	 * @exception EventException
	 */
	public ARInvoiceCorrectionVO searchARInvoiceByIFNo (String ifNo ,String ofc ) throws EventException {
		try {
			ARInvoiceCorrectionVO invoiceCorrectionVO = new ARInvoiceCorrectionVO();
			if (!ifNo.equals("")) {
				invoiceCorrectionVO = dbDao.searchARInvoiceMain(ifNo, ofc);
				
				if (invoiceCorrectionVO != null) {
					String viewIfNo = invoiceCorrectionVO.getArIfNo();
					
					List<ARInvoiceChargeSumVO> listInvoiceChargeSumVO = dbDao.searchARInvoiceChargeSum(viewIfNo);
					List<ARInvoiceChargeCorrectionVO> listInvoiceChargeCorrectionVO = dbDao.searchARInvoiceCharge(viewIfNo);
					List<ARInvoiceContainerVO> listInvoiceContainerVO = dbDao.searchContainerNoList(viewIfNo);
					
					invoiceCorrectionVO.setListInvoiceChargeSumVO(listInvoiceChargeSumVO);
					invoiceCorrectionVO.setListInvoiceChargeCorrectionVO(listInvoiceChargeCorrectionVO);
					invoiceCorrectionVO.setListInvoiceContainerVO(listInvoiceContainerVO);
				}
				else {
					invoiceCorrectionVO = new ARInvoiceCorrectionVO();
				}
			}

			return invoiceCorrectionVO;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage(), ex);
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * Invoice 의 Fax 및 E-mail 발송 결과와 현황을 조회한다.<br>
	 * 
	 * @author JungJin Park
	 * @param  FaxEmailSentDateVO sendDateVo
	 * @return List<FaxEmailSentResultVO>
	 * @exception EventException 
	 */
	public List<FaxEmailSentResultVO> searchFaxEmailSentResultListBySendDate (FaxEmailSentDateVO sendDateVo) throws EventException {
		try {
			return dbDao.searchFaxEmailSentResultListBySendDate(sendDateVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage(), ex);
		}
	}
	/**
	 * 조회 이벤트 처리<br>
	 * Spain(VLCSC)전용 Invoice 파일 다운로드기능.<br>
	 * Local System에 데이터  Upload하기 위해 요청된 format으로 텍스트파일 다운로드 하는 기능이다.<br>
	 * Invoice EDI for VLC인 경우는 issue date(입력된 일자로부터 -6일간)를 기준으로 하며 
	 * EDI send date가 없는 해당하는 데이터를 조회하여 텍스트파일로 생성한다.<br>
	 * 
	 * @author JungJin Park
	 * @param String ofcCd
	 * @param String issDate
	 * @return List<SpainInvoiceEDIListVO>
	 * @exception EventException
	 */
	public List<SpainInvoiceEDIListVO> searchSpainInvoiceList (String ofcCd, String issDate) throws EventException {
		try {
			return dbDao.searchSpainInvoiceEDIList(ofcCd, issDate);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage(), ex);
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * 매출채권 발생과 Invoice 발행사이의 Average Term 을 date 별로 조회한다.<br>
	 * Office code, issue date/Good date 조건으로 조회된 데이타의 issue date와 S/A  date, issue date와 Good date간의 Trem별 현황데이터를 조회해 온다.
	 * 
	 * @author JungJin Park
	 * @param InvoiceTermAnalysisInputVO invTermAnlsVo
	 * @return List<InvoiceTermAnalysisVO>
	 * @exception EventException
	 */
	public List<InvoiceTermAnalysisVO> searchInvoiceIssueTermByDate (InvoiceTermAnalysisInputVO invTermAnlsVo) throws EventException {
		try {
			return dbDao.searchInvoiceIssueTermByDate(invTermAnlsVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage(), ex);
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * Invoice Detail Inquiry by Date & Charge 조회한다.<br>
	 * @author Dong Hoon Han
	 * @param ARInvoiceInquiryInPutVO invDtlVO
	 * @return List<InvoiceDetailListVO>
	 * @exception EventException
	 */
	public InvoiceDetailVO searchDetailInvoiceListByDate (ARInvoiceInquiryInPutVO invDtlVO) throws EventException {
		try {
			InvoiceDetailVO invoiceDetailVO = new InvoiceDetailVO();
			
			List<InvoiceDetailListVO> invoiceDetailListVO = dbDao.searchDetailInvoiceListByDate(invDtlVO);
			
			invoiceDetailVO.setInvoiceDetailListVO(invoiceDetailListVO);
			
			return invoiceDetailVO;
			
		} catch (DAOException ex) {
			if (ex.toString().contains("ORA-01013")) {
				throw new EventException(new ErrorHandler("COM12244", new String[]{}).getMessage(), ex);
			} else {
				throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
			}
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage(), ex);
		}
	}

	/**
	 * 조회 이벤트 처리<br>
	 * Customer 별로 미발행 Invoice 현황을 조회한다.<br>
	 * 
	 * @author JungJin Park
	 * @param NotissuedInputVO notIssVo
	 * @return List<NotIssuedListVO>
	 * @exception EventException
	 */
	public List<NotIssuedListVO> searchNotIssueListByCustomer (NotissuedInputVO notIssVo) throws EventException {
		try {
			return dbDao.searchNotIssueListByCustomer(notIssVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage(), ex);
		}
	}

	/**
	 * 조회 이벤트 처리<br>
	 * Customer 별로 미발행 Invoice 의 전체 건수를 기간별로 보여준다.<br>
	 * 
	 * @author JungJin Park
	 * @param NotIssuedAgingInputVO notIssAgingVo
	 * @return List<NotIssuedListVO>
	 * @exception EventException
	 */
	public List<NotIssuedAgingVO> searchNotIssueAgingByCustomer (NotIssuedAgingInputVO notIssAgingVo) throws EventException {
		try {
			return dbDao.searchNotIssueAgingByCustomer(notIssAgingVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage(), ex);
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * 매출채권 및 Invoice 의 Summary 현황을 Date 기준으로 조회한다.<br>
	 * 
	 * @author JungJin Park
	 * @param ARInvoiceInquiryInPutVO invSumVo
	 * @return List<InvoiceSummaryListVO>
	 * @exception EventException
	 */
	public List<InvoiceSummaryListVO> searchSummaryInvoiceListByDate (ARInvoiceInquiryInPutVO invSumVo) throws EventException {
		try {
			return dbDao.searchSummaryInvoiceListByDate(invSumVo);
		} catch (DAOException ex) {
			if (ex.toString().contains("ORA-01013")) {
				throw new EventException(new ErrorHandler("COM12244", new String[]{}).getMessage(), ex);
			} else {
				throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
			}
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage(), ex);
		}
	}
	
	/**
	 * POP-UP 화면에서 Invoice 정보를 발행일자 기준으로 조회한다.(Re-Issue 화면에서 사용). <br>
	 * 
	 * @param InvoiceIssueDateVO issueDateVo
	 * @return List<ARInvoiceIssueDateVO>
	 * @exception EventException
	 */
	public List<ARInvoiceIssueDateVO> searchPopInvoiceListByIssueDate(InvoiceIssueDateVO issueDateVo) throws EventException {
		try {
			return dbDao.searchPopInvoiceListByIssueDate(issueDateVo);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}

	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * A/R HEAD QUARTER OFFICE CODE를 조회한다..<br>
	 * 
	 * @author JungJin Park
	 * @return List<String>
	 * @exception EventException
	 */
	public List<String> searchARRHQOfficeList() throws EventException {
		try {
			return dbDao.searchARRHQOfficeList();
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage(), ex);
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * BOMSC 지역이외 Office 에서 GST Charge 가 Rating 된 현황을 Date 별로 조회한다.<br>
	 * 
	 * @author JungJin Park
	 * @param String dateOption
	 * @param String fromDate
	 * @param String toDate
	 * @param String rhq
	 * @return List<GSTChargeListVO>
	 * @exception EventException
	 */
	public List<GSTChargeListVO> searchGSTListByDate (String dateOption, String fromDate, String toDate, String rhq) throws EventException {
		try {
			return dbDao.searchGSTListByDate (dateOption, fromDate, toDate, rhq);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage(), ex);
		}
	}
	
	/**
	 * POP-UP 화면에서 Invoice 정보를 발행일자 기준으로 조회한다.(Re-Issue 화면에서 사용). <br>
	 * 
	 * @param InvoiceIssueDateVO issueDateVo
	 * @return List<ARInvoiceListByIFDateVO>
	 * @exception EventException
	 */
	public List<ARInvoiceListByIFDateVO> searchPopSGNBBInvoiceListByIssueDate (InvoiceIssueDateVO issueDateVo) throws EventException {
		try {
			return dbDao.searchPopSGNBBInvoiceListByIssueDate(issueDateVo);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
	
	/**
	 * 조회 이벤트 처리<br>
	 * Sales Office의 A/R OFFICE CODE의 정보(INV_AR_STUP_OFC- INV_DUP_FLG)를 조회한다. <br>
	 * 
	 * @author JungJin Park
	 * @param String saleOfc
	 * @return AROfficeListVO
	 * @exception EventException
	 */
	public AROfficeListVO searchAROffice (String saleOfc) throws EventException {
		try {
			return dbDao.searchAROffice(saleOfc);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * FNS_INV_0110<br>
	 * Issue 대상 (DXBSC)INV B/L을 조회한다.<br>
	 * 
	 * @author Choi Woo-Seok
	 * @param GeneralInvoiceVO genInvVo
	 * @return List<DXBInvoiceListVO>
	 * @exception EventException
	 */
	public List<DXBInvoiceListVO> searchDXBInvoiceList(GeneralInvoiceVO genInvVo) throws EventException{
		try {
			return dbDao.searchDXBInvoiceList(genInvVo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * INV_AR_LOCL_CHG 있는 ar_ofc_cd를 조회한다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @return List<String>
	 * @exception EventException
	 */
	public List<String> searchLoclChgOfc() throws EventException {
		try {
			return dbDao.searchLoclChgOfc();
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage(), ex);
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * Spain(VLCSC)전용 Invoice 파일 다운로드기능.<br>
	 * Local System에 데이터  Upload하기 위해 요청된 format으로 텍스트파일 다운로드 하는 기능이다.<br>
	 * Invoice EDI for VLC인 경우는 issue date(입력된 일자로부터 -6일간)를 기준으로 하며 
	 * EDI send date가 없는 해당하는 데이터를 조회하여 텍스트파일로 생성한다.<br>
	 * 
	 * @param String ofcCd
	 * @param String issDate
	 * @return SpainInvoiceEDIListCountVO
	 * @exception EventException
	 */
	public SpainInvoiceEDIListCountVO searchSpainInvoiceListCount (String ofcCd, String issDate) throws EventException {
		try {
			return dbDao.searchSpainInvoiceEDIListCount(ofcCd, issDate);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage(), ex);
		}
	}
	
	/**
	 * ERP I/f Error 내역을 조회한다.<br>
	 * @author KIM HYUN HWA 
	 * @param ErpErrorInputVO erpErrorInputVO
	 * @return List<ErpErrorVO>
	 * @exception EventException
	 */
	public List<ErpErrorVO> searchErpErrorList(ErpErrorInputVO erpErrorInputVO) throws EventException {
	
		try {
			return dbDao.searchErpErrorList(erpErrorInputVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}	
	/**
	 * 사용가능한 Rhq를 조회한다.<br>
	 * 
	 * @param String useOfc
	 * @return List<String>
	 * @exception EventException
	 */ 
	public List<String> searchARRhqList(String useOfc) throws EventException {
		  List<String> rhqList = new ArrayList<String>();
          String rhq ="";
          
		try {
			 rhq = dbDao.searchARRhqByUserId(useOfc);
			 if ("SELHO".equals(rhq)){
				 rhqList = dbDao.searchARRHQOfficeList();
				 rhqList.add(0, "ALL"); 
			 } else {
				 rhqList.add(rhq); 
			 }
			 return  rhqList;
			 
		}catch(DAOException ex) {
	        throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
		    throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
		
	/**
	 * RHQ 소속의 A/R Office list를 조회한다.<br>
	 * 
	 * @param String rhq
	 * @param String usrOfc
	 * @return List<String>
	 * @exception EventException
	 */
	public List<String> searchAROfficeListByRhq(String rhq, String usrOfc ) throws EventException {
		  List<String> ofcList = new ArrayList<String>();
		  AROfficeListVO aROfficeListVO = new AROfficeListVO();
		  String arOfc ="";
		try {
		
			 aROfficeListVO = dbDao.searchAROffice(usrOfc);
			 arOfc = aROfficeListVO.getArOfcCd();
			
			  if (arOfc.equals(rhq)){
				  arOfc ="RHQ";
			  }
	      	     ofcList = dbDao.searchAROfficeListByRhq(rhq, arOfc);
      
			     return ofcList;
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}	
	
	
	/**
	 * AR Invoice에서 ERP로 I/F한  Transaction을 조회한다.
	 * 
	 * @param TransDataComparisonReportInputVO transDataComparisonReportInputVO
	 * @return  List<TransDataComparisonReportVO>
	 * @exception EventException
	 */
	public List<TransDataComparisonReportVO> searchTransactionDataComparisonReportList( TransDataComparisonReportInputVO transDataComparisonReportInputVO) throws EventException{
		try {
			return dbDao.searchTransactionDataComparisonReportList(transDataComparisonReportInputVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * AR에서 발생된 "Reverse Charge" Data 산출기능<br>
	 * 
	 * @param String arOfcCd
	 * @param String fmDt
	 * @param String toDt
	 * @return List<ReportForReverseChargeVO>
	 * @exception EventException
	 */
	public List<ReportForReverseChargeVO> searchReportForReverseChargeList(String arOfcCd, String fmDt, String toDt) throws EventException {
	
		try {
			return dbDao.searchReportForReverseChargeList(arOfcCd, fmDt, toDt);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * Split된 Invoice 발행 정보를 Bl No 별로 조회한다.<br>
	 * 
	 * @param blNo
	 * @param ofc
	 * @return
	 * @throws EventException
	 */
	public List<ARInvoiceChargeByBLNoVO> searchOtherSplitInvoicesForBL(String blNo, String ofc) throws EventException {
		try {
			List<ARInvoiceChargeByBLNoVO>  aRInvoiceChargeByBLNoVOs = dbDao.searchOtherSplitInvoicesForBL(blNo, ofc);
		
			return aRInvoiceChargeByBLNoVOs;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage(), ex);
		}
	}
	
	/**
	 * POP-UP 화면에서 Invoice 정보를 발행일자 기준으로 조회한다.(Re-Issue 화면에서 사용).-SAOSC <br>
	 * 
	 * @param InvoiceIssueDateVO issueDateVo
	 * @return List<ARInvoiceIssueDateVO>
	 * @exception EventException
	 */
	public List<ARInvoiceIssueDateVO> searchPopSplitInvoiceListByIssueDate(InvoiceIssueDateVO issueDateVo) throws EventException {
		try {
			return dbDao.searchPopSplitInvoiceListByIssueDate(issueDateVo);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}

	}
	
	/**BCImpl
	 * 조회 이벤트 처리<br>
	 * 사용자가 EXCEL로 업로드한 Bl No의 Customer정보를 조회한다<br>
	 * 
	 * @param blNos
	 * @return List<CustomerListByBLVO>
	 * @throws EventException
	 */
	public List<CustomerListByBLVO> searchCustomerListByBL(String blNos) throws EventException{
		try {
			List<CustomerListByBLVO> customerListByBLVO = dbDao.searchCustomerListByBL(blNos);
			return customerListByBLVO;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage(), ex);
		}
	}
	
	/**
	 * AKLBA의 Invoice Deatil 정보를 조회한다. <br>
	 * 
	 * @param BillInputVO billInputVO
	 * @return List<InvoiceAKLBAVO>
	 * @exception EventException
	 */
	public List<InvoiceAKLBAVO> searchInvoiceDetailForAKLBA(BillInputVO billInputVO) throws EventException {
		try {
			return dbDao.searchInvoiceDetailForAKLBA(billInputVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}

	}
	
	

	/**
	 * 조회 이벤트 처리<br>
	 * Invoice 정보를 발행일자 기준으로 조회한다.<br>
	 * 
	 * @author Dosoon Choi
	 * @param  InvoiceIssueDateVO issueDateVo
	 * @return List<NYCInvoiceIssueDateVO>
	 * @exception EventException
	 */
	public List<NYCInvoiceIssueDateVO> searchNYCInvoiceListByIssueDate(InvoiceIssueDateVO issueDateVo) throws EventException {
		try {
			return dbDao.searchNYCInvoiceListByIssueDate(issueDateVo);
		} catch (DAOException ex) {
			if (ex.toString().contains("ORA-01013")) {
				throw new EventException(new ErrorHandler("COM12244", new String[]{}).getMessage(), ex);
			} else {
				throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
			}
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage(), ex);
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * RHQ를 조건으로 BOMSC Office 아닌 타 Office 의 채권 데이터중 Option에 따라서 I/F date or S/A date를 비교하여 "GST"CHarge 가 있는 대상을 조회하여 USD, INR Currnecy로 환산하여 보여줌.<br>
	 * USD, INR Currnecy환산금액은 채권데이터의 GL_EFF_DT기준 경리환율로 계산한다.<br>
	 * 
	 * @author Seungil Baek
	 * @param String dateOption
	 * @param String fromDate
	 * @param String toDate
	 * @param String rhq
	 * @param String chgCd
	 * @param String scNo
	 * @return List<GCFSAFChargeListVO>
	 * @exception EventException
	 */
	public List<GCFSAFChargeListVO> searchGCFSAFListByData (String dateOption, String fromDate, String toDate, String rhq, String chgCd, String scNo) throws EventException {
		try {
			return dbDao.searchGCFSAFListByData (dateOption, fromDate, toDate, rhq , chgCd, scNo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage(), ex);
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * A/R HEAD QUARTER OFFICE CODE를 조회한다..<br>
	 * 
	 * @author JungJin Park
	 * @return List<String>
	 * @exception EventException
	 */
	public List<String> searchGCFSAFRHQOfficeList() throws EventException {
		try {
			return dbDao.searchGCFSAFRHQOfficeList();
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage(), ex);
		}
	}
	
	/**
	 * PCF Revenue, Expense 요율을 조회한다.<br>
	 * 
	 * @author SungYong Park
	 * @param String portCd
	 * @param String reDivrCd
	 * @return List<PCFRevExpnAmountVO>
	 * @exception EventException
	 */
	public List<PCFRevExpnAmountVO> searchPCFRevExpnAmount(String portCd, String reDivrCd) throws EventException {
		try {
			return dbDao.searchPCFRevExpnAmount(portCd, reDivrCd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage(), ex);
		}
	}
	
	/**
	 *  PCF 의 Revenue 및 Expense 요율을 등록/수정/삭제한다.<br>
	 * 
	 * @param PCFRevExpnAmountVO[] pcfRevExpnAmountVOs
	 * @param String userId
	 * @exception EventException
	 */
	public void managePCFRevExpnAmount(PCFRevExpnAmountVO[] pcfRevExpnAmountVOs, String userId) throws EventException {
		try {
			List<PCFRevExpnAmountVO> insertVoList = new ArrayList<PCFRevExpnAmountVO>();
			List<PCFRevExpnAmountVO> updateVoList = new ArrayList<PCFRevExpnAmountVO>();
			List<PCFRevExpnAmountVO> deleteVoList = new ArrayList<PCFRevExpnAmountVO>();
			
			for (int i = 0; i < pcfRevExpnAmountVOs.length; i++) {
				
				if (pcfRevExpnAmountVOs[i].getIbflag().equals("I")) {
				
					pcfRevExpnAmountVOs[i].setCreUsrId(userId);
					pcfRevExpnAmountVOs[i].setUpdUsrId(userId);
					
					insertVoList.add(pcfRevExpnAmountVOs[i]);
				
				} else if (pcfRevExpnAmountVOs[i].getIbflag().equals("U")) {
					
					pcfRevExpnAmountVOs[i].setUpdUsrId(userId);
					
					updateVoList.add(pcfRevExpnAmountVOs[i]);
					
				} else if (pcfRevExpnAmountVOs[i].getIbflag().equals("D")) {
					
					deleteVoList.add(pcfRevExpnAmountVOs[i]);
					
				}
			}
			
			if (insertVoList.size() > 0) {
				dbDao.addPCFRevExpnAmount(insertVoList);
			}
			
			if (updateVoList.size() > 0) {
				dbDao.modifyPCFRevExpnAmount(updateVoList);
			}
			
			if (deleteVoList.size() > 0) {
				dbDao.removePCFRevExpnAmount(deleteVoList);
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
	 * PCF status 정보를 조회한다.<br>
	 * 
	 * @author SungYong Park
	 * @param PCFStatusInfoInputVO pcfStatusInfoInputVo
	 * @return List<PCFStatusInfoVO>
	 * @exception EventException
	 */
	public List<PCFStatusInfoVO> searchPCFStatusInfo(PCFStatusInfoInputVO pcfStatusInfoInputVo) throws EventException {
		try {
			return dbDao.searchPCFStatusInfo(pcfStatusInfoInputVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage(), ex);
		}
	}
}