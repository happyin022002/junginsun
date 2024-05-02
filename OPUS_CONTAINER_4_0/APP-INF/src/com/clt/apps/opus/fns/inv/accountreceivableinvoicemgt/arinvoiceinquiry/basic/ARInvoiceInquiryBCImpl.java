/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ARInvoiceInquiryBCImpl.java
*@FileTitle : Invoice Inquiry by I/F No - General
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
 =========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.ARInvoiceChargeCorrectionVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.ARInvoiceCorrectionVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.integration.ARInvoiceInquiryDBDAO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.ARInvoiceByBLNoVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.ARInvoiceChargeByBLNoVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.ARInvoiceChargeSumVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.ARInvoiceContainerVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.ARInvoiceHistoryByBLNoVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.ARInvoiceInputByBLNoVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.ARInvoiceInquiryInPutVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.ARInvoiceIssueDateVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.ARInvoiceListByIFDateVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.CPRIDListInputVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.CPRTInputVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.CPRTInvoiceVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.CPRTListVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.CPRTMainVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.CprtItemVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.DXBInvoiceListVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.ErpErrorInputVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.ErpErrorVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.FaxEmailSentDateVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.FaxEmailSentResultVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.InvCprtTmpltChgVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.InvoiceIssueDateVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.InvoiceSumVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.NotIssuedListVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.NotissuedInputVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.TemplateItemVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.TemplateVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.TransDataComparisonReportInputVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.TransDataComparisonReportVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.GeneralInvoiceVO;
import com.clt.apps.opus.fns.inv.invcommon.invcommon.vo.AROfficeListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;

/**
 * AccountReceivableInvoiceMgt Business Logic Basic Command implementation<br>
 * - AccountReceivableInvoiceMgt logic process.<br>
 *
 * @author saeil kim
 * @see FNS_INV_0011_01EventResponse,ARInvoiceInquiryBC
 * @since J2EE 1.4
 */

public class ARInvoiceInquiryBCImpl extends BasicCommandSupport implements ARInvoiceInquiryBC {

	// Database Access Object
	private transient ARInvoiceInquiryDBDAO dbDao = null;

	/**
	 * ARInvoiceInquiryBCImpl object creation.<br>
	 * ARInvoiceInquiryDBDAO creation.<br>
	 */
	public ARInvoiceInquiryBCImpl() {
		dbDao = new ARInvoiceInquiryDBDAO();
	}

	/**
	 * Retrieve event process<br>
	 * Good Date / IF Date invoice information retrieve.<br>
	 * Showing BL count and USD total amount, local total amount<br>
	 * max period one office : 1 month, All : 10 days
	 * 
	 * @author JungJin Park
	 * @param  ARInvoiceInquiryInPutVO    invByGoodVO
	 * @return List<ARInvoiceListByIFDateVO>
	 * @exception EventException
	 */
	public List<ARInvoiceListByIFDateVO> searchARInvoiceListByGoodDate(ARInvoiceInquiryInPutVO invByGoodVO) throws EventException {
		List<ARInvoiceListByIFDateVO> resultVOs = null;
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
	 * Retrieve event process<br>
	 * Invoice publication information Invoice No retrieve<br>
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
	 * Retrieve event process<br>
	 * Invoice information retrieve.<br>
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
	 * Retrieve event process<br>
	 * Receivables and Invoice information B/L No retrieve.<br>
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
						// Office code is null in case retrieve first office.
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
			
			if(aRInvoiceByBLNoVO != null && arOfcCdList != null){
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
	 * Retrieve event process<br>
	 * Receivables and Invoice information Interface No retrieve.<br>
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
			if (!"".equals(ifNo)) {
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
	 * Retrieve event process<br>
	 * Invoice's Fax and E-mail retrieve.<br>
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
	 * Retrieve event process<br>
	 * Invoice status retrieve.<br>
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
	 * POP-UP screen Invoice information retrieve. <br>
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
	 * Retrieve event process<br>
	 * A/R HEAD QUARTER OFFICE CODE retrieve.<br>
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
	 * Retrieve event process<br>
	 * Sales Office's A/R OFFICE CODE's (INV_AR_STUP_OFC- INV_DUP_FLG) retrieve. <br>
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
	 * Issue target (DXBBB)INV B/L retrieve.<br>
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
	 * ERP I/f Error history retrieve.<br>
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
	 * Available Rhq retrieve.<br>
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
	 * A/R Office list retrieve.<br>
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
	 * AR Invoice ERP I/F  Transaction retrieve.
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
	 * CPR(Customer Preferable Report)에서 사용. user 가 사용가능한 Template List 를 가져온다.<br>
	 * @author Dong Hoon Han
	 * @param String userId
	 * @param String ofc
	 * @return List<TemplateVO>
	 * @exception EventException
	 */		
	public List<TemplateVO> searchTemplateList(String userId, String ofc) throws EventException {
		List<TemplateVO> list = null;
		try {
			list = dbDao.searchTemplateList(userId, ofc);	
			return list;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * CPR(Customer Preferable Report)에서 사용.  조건 Template name 으로 저장된 Item들을 조회한다.<br>
	 * @author Dong Hoon Han
	 * @param String tmplate
	 * @param CPRTInputVO cprInputVo
	 * @return List<TemplateItemVO>
	 * @exception EventException
	 */		
	public List<TemplateItemVO> searchTemplateItemList(String tmplate,CPRTInputVO cprInputVo) throws EventException {
		List<TemplateItemVO> list = null;
		log.debug("BC===========================================");
		log.debug("----start-------tmplate-----------arOfcCd--------------------------------");
		log.debug(tmplate);
		log.debug("cprInputVo.getarOfcCd()>>>>>>>>>>>>>>>>>>>>>>>>"+cprInputVo.getArOfcCd());
		log.debug("cprInputVo.getScNo()>>>>>>>>>>>>>>>>>>>>>>>>"+cprInputVo.getScNo());
		log.debug("--- end----------tmplate-----------arOfcCd-------------------");
		try {
			list = dbDao.searchTemplateItemList(tmplate,cprInputVo);	
			return list;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * CPR 에서 bl preview 조회시 bkg_no가 없을 경우, 조회한다. <br>
	 * @author Dong Hoon Han
	 * @param String blNo
	 * @return String
	 * @throws EventException
	 */
	public String searchBlNo(String blNo) throws EventException {
		try {			
			String bkgNo = dbDao.searchBlNo(blNo);
			return bkgNo;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * CPRT(Customer Preferable Report) 생성 대상 내용을 BKG 정보에서 조회해 온다.<br>
	 * @author Dong Hoon Han
	 * @param CPRTInputVO cprInputVo
	 * @param String rptItmId
	 * @return TemplateVO
	 * @exception EventException
	 */		
	public List<CPRTInvoiceVO> searchCPRTInvoice(CPRTInputVO cprInputVo, String rptItmId) throws EventException {
//	public TemplateVO searchCPRTInvoice(CPRTInputVO cprInputVo, String rptItmId) throws EventException {
//		TemplateVO templateVO = new TemplateVO();
		List<CPRTInvoiceVO> listCPRTInvoiceVO = null;
		//String bl_nos = cprInputVo.getBlNos();	

		try {
			//if (!bl_nos.equals("")){
			//    listCPRTInvoiceVO = dbDao.searchCPRTByBL(cprInputVo, rptItmId);
			//    log.debug("======================bl_nos================================");
			//}else {
				listCPRTInvoiceVO = dbDao.searchCPRTInvoice(cprInputVo, rptItmId);
				log.debug("=====================not bl_nos================================");
			//}
			return listCPRTInvoiceVO;
			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			if (ex.toString().contains("ORA-01013")) {
				throw new EventException(new ErrorHandler("COM12244", new String[]{}).getMessage(), ex);
			} else {
				throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
			}
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage(), ex);
		}
	
	}
	
	/**
	 * CPRT(Customer Preferable Report) Report ID를 생성한다.<br>
	 * @author Dong Hoon Han
	 * @param String custNm
	 * @param CPRTInputVO cprInputVo
	 * @return String
	 * @exception EventException
	 */		
	public String issueCPRTInvoice(String custNm, CPRTInputVO cprInputVo) throws EventException {
		//CPRTMainVO cPRTMainVO = new CPRTMainVO();
		
		String reportId = "";
		try {
			if(cprInputVo != null){
				reportId = dbDao.searchMaxReporID(custNm, cprInputVo.getArOfcCd());
				//log.info("reportId===========>>>>>"+reportId);
				dbDao.addCPRTHistory(reportId, cprInputVo);
			}
			return reportId;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}	

	/**
	 * CPR(Customer Preferable Report)에서 사용. 선택가능한 모든 항목 List 와 를 가져온다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param String userId
	 * @param String ofc
	 * @return CPRT_ItemVO
	 * @exception EventException
	 */
	public CprtItemVO searchReportItemList(String userId, String ofc) throws EventException {
		// CPRT_ItemVO cPRT_ItemVO = null; // 데이터 전송을 위해 VO 객체
		CprtItemVO cprtItemVO = new CprtItemVO();
		try {
			cprtItemVO.setCprtItemListVOs(dbDao.searchItemList());
			//cprtItemVO.setCprtTmpltVOs(dbDao.searchTemplateList(userId, ofc));
			cprtItemVO.setRptTmpltNmVOs(dbDao.searchCPRTemplateList(userId, ofc));
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
		return cprtItemVO;
	}

	/**
	 * CPR(Customer Preferable Report)에서 사용. Template으로 등록된 선택한 항목 List 를 가져온다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param String tmplate
	 * @param String arOfcCd
	 * @return TemplateVO
	 * @exception EventException
	 */
	public TemplateVO searchSelectedItemList(String tmplate, String arOfcCd) throws EventException {
//		List<TemplateItemVO> templateItemVOs = null; // 데이터 전송을 위해 VO 객체
		TemplateVO templateVO = new TemplateVO();
		try {
			List<TemplateItemVO> listTemplateItemVO = dbDao.searchSelectedItemList(tmplate, arOfcCd);
			List<InvCprtTmpltChgVO> listInvCprtTmpltChgVO = dbDao.searchSelectedChildItemList(tmplate, arOfcCd);
			                                                   
			templateVO.setListTemplateItemVO(listTemplateItemVO);
			templateVO.setListInvCprtTmpltChgVO(listInvCprtTmpltChgVO);
	
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
		return templateVO;
	}

	/**
	 * CPR(Customer Preferable Report)에서 사용. 신규입력한 Template 명이 이미 존재하는지를 check한다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param String tmplate
	 * @return String
	 * @exception EventException
	 */

	public String searchTemplateName(String tmplate) throws EventException {
	
		String tmpleName = null; // 데이터 전송을 위해 VO 객체
		try {

			tmpleName = dbDao.searchTemplateName(tmplate);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
		return tmpleName;
	}

	/**
	 * Template name으로 선택한 item을 등록,수정, 삭제한다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param TemplateVO[] templateVOs
	 * @param InvCprtTmpltChgVO[] invCprtTmpltChgVOs 
	 * @param String userId
	 * @param String ofcCd
	 * @exception EventException
	 */
	public void manageTemplateItem(TemplateVO[] templateVOs, InvCprtTmpltChgVO[] invCprtTmpltChgVOs, String userId, String ofcCd) throws EventException {
		List<TemplateVO> insertVoList = new ArrayList<TemplateVO>();
		List<TemplateVO> updateVoList = new ArrayList<TemplateVO>();
		List<TemplateVO> deleteVoList = new ArrayList<TemplateVO>();
		List<InvCprtTmpltChgVO> chgVoList = new ArrayList<InvCprtTmpltChgVO>();
		String tmplate = templateVOs[0].getRptTmpltNm();
		//Template 등록 Office로 처리되도록 함. 2011.03.28
		String ofc = templateVOs[0].getArOfcCd();
	 	

		try {
			
			if(invCprtTmpltChgVOs == null || invCprtTmpltChgVOs.length == 0){
			            dbDao.removeInvCprTmpltChg(tmplate, ofc);
			}
			
			for (int i = 0; i < templateVOs.length; i++) {
				if (templateVOs[i].getIbflag().equals("I")) {
					templateVOs[i].setCreUsrId(userId);
					templateVOs[i].setUpdUsrId(userId);

					insertVoList.add(templateVOs[i]);
				} else if (templateVOs[i].getIbflag().equals("U")) {
					templateVOs[i].setUpdUsrId(userId);
					updateVoList.add(templateVOs[i]);
				} else if (templateVOs[i].getIbflag().equals("D")) {
					deleteVoList.add(templateVOs[i]);
				}
			}
			if (deleteVoList.size() > 0) {
				dbDao.removeTemplateItem(deleteVoList);
			}
			if (insertVoList.size() > 0) {
				dbDao.addTemplateItem(insertVoList);
			}
			if (updateVoList.size() > 0) {
				dbDao.modifyTemplateItem(updateVoList);
			}
			
			if(invCprtTmpltChgVOs != null && invCprtTmpltChgVOs.length > 0){
				for (int j = 0; j < invCprtTmpltChgVOs.length; j++) {
					
					invCprtTmpltChgVOs[j].setUpdUsrId(userId);
					chgVoList.add(invCprtTmpltChgVOs[j]);
					
				}
				
			
				if (chgVoList.size() > 0) {	
				    	dbDao.removeInvCprTmpltChg(tmplate, ofc);
				     	dbDao.addInvCprTmpltChg(chgVoList);
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
	 * CPR(Customer Preferable Report)에 사용하기 위해 등록한 Template을 삭제한다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param String tmplate
	 * @param String ofcCd
	 * @exception EventException
	 */
	public void removeTemplate(String tmplate, String ofcCd) throws EventException {
		// String tmpleName = null; // 데이터 전송을 위해 VO 객체
		try {
			dbDao.removeTemplate(tmplate, ofcCd);
			dbDao.removeInvCprTmpltChg(tmplate, ofcCd);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("INV00053", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("INV00053", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * CPRT(Customer Preferable Report)에서  한개 이상의 Report ID 로 생성내역을 조회한다.<br>
	 * @author Dong Hoon Han
	 * @param CPRTListVO cprIdVo
	 * @return List<CPRTMainVO>
	 * @exception EventException
	 */		
	public List<CPRTMainVO> searchCPRTHistoryList(CPRTListVO cprIdVo) throws EventException {
		List<CPRTMainVO> list = null;
		//log.info("########## genInvVo.getBlNos() : "+genInvVo.getBlNos());
		try {
			list = dbDao.searchCPRTHistoryList(cprIdVo);	
			return list;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}			
	}
	
	/**
	 * CPRT(Customer Preferable Report) 조회조건에 해당하는  Report ID 를 조회한다.<br>
	 * @author Dong Hoon Han
	 * @param CPRIDListInputVO cprsearchVo
	 * @return List<CPRTListVO>
	 * @exception EventException
	 */	
	public List<CPRTListVO> searchCPRTIDList(CPRIDListInputVO cprsearchVo) throws EventException {
		List<CPRTListVO> list = null;
		//log.info("########## genInvVo.getBlNos() : "+genInvVo.getBlNos());
		try {
			list = dbDao.searchCPRTIDList(cprsearchVo);	
			return list;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}			
	}
	
}