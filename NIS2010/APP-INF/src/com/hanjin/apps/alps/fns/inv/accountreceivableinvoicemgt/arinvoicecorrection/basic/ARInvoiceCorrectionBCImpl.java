/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ARInvoiceCorrectionBCImpl.java
*@FileTitle : Invoice Split Before Invoice Issue
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.04
*@LastModifier : 김세일
*@LastVersion : 1.0
* 2009.05.04 김세일
* 1.0 Creation
 * -------------------------------------------------------- 
 * History
 * 2011.05.02 최도순 [CHM-201109030-01] Intra - Europe Business 관련 VAT 기능 개발
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ARBkgInterfaceCreationVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ExrateInputVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ExrateTargetChgVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ExrateTargetMainVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.InvArCntrVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.InvArMnVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.integration.ARInvoiceCorrectionDBDAO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.ARCorrectionCkReturnVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.ARCorrectionCkVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.ARInvoiceChargeCorrectionVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.ARInvoiceCorrectionVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.ARInvoiceCustomerInputVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.ARInvoiceCustomerVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.ARInvoiceListByVesselMultiVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.ARInvoiceListByVesselVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.ARInvoiceSplitVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.BillInputVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.BkgNoCaNoVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.ChangeCustomerInputVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.DirectBillingInvoiceVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.DueDateInputVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.DueDateVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.InvArEuCntVatVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.InvArIfNoVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.InvByVVDVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.InvIssAtchVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.InvissAtchInputVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.InvoiceCustomerChangeChargeVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.InvoiceCustomerChangeListVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.InvoiceCustomerChangeVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.MDMCustomerVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.ManualInputVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.MarkingReverseChargeVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.UnmatchRevenueVesselVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.ARInvoiceChargeSumVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

/**
 * ALPS-AccountReceivableInvoiceMgt Business Logic Basic Command implementation<br>
 * - ALPS-AccountReceivableInvoiceMgt에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author saeil kim
 * @see FNS_INV_0018EventResponse,ARInvoiceCorrectionBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */

public class ARInvoiceCorrectionBCImpl extends BasicCommandSupport implements ARInvoiceCorrectionBC {

	// Database Access Object
	private transient ARInvoiceCorrectionDBDAO dbDao = null;

	/**
	 * ARInvoiceCorrectionBCImpl 객체 생성<br>
	 * ARInvoiceCorrectionDBDAO를 생성한다.<br>
	 */
	public ARInvoiceCorrectionBCImpl() {
		dbDao = new ARInvoiceCorrectionDBDAO();
	}	
	
	/**
	 * VVD 별로 Invoice 의 Item 들을 조회한다.<br>
	 * @author Dong Hoon Han
	 * @param InvByVVDVO invByVVDVO
	 * @return ARInvoiceListByVesselMultiVO
	 * @exception EventException 
	 */
	public ARInvoiceListByVesselMultiVO searchARInvoiceListByVVD(InvByVVDVO invByVVDVO) throws EventException {
		ARInvoiceListByVesselMultiVO aRInvoiceListByVesselMultiVO = new ARInvoiceListByVesselMultiVO();
		try {
			
			List<ARInvoiceListByVesselVO> list = null;
			String saDate = "";
			String invXchRt = "";
			//list = dbDao.searchARInvoiceListByVVD(invByVVDVO);			
			list = dbDao.searchARInvoiceListByVVD(invByVVDVO);	

			saDate = dbDao.searchSADate(invByVVDVO);			
			invXchRt = dbDao.searchVVDExrate(invByVVDVO);
					
			
			
			aRInvoiceListByVesselMultiVO.setListARInvoiceListByVesselVO(list);
			aRInvoiceListByVesselMultiVO.setSaDate(saDate);
			aRInvoiceListByVesselMultiVO.setInvXchRt(invXchRt);

			return aRInvoiceListByVesselMultiVO;
			//return dbDao.searchARInvoiceListByVVD(invByVVDVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage(), ex);
		}
	}

	/**
	 * OTS Summary Code 조회<br>
	 * FNS_INV_0016,FNS_INV_0017,FNS_INV_0018,FNS_INV_0033,FNS_INV_0094<br>
	 * 
	 * @param String ofcCd
	 * @return String
	 * @exception EventException
	 * 
	 */
	public String searchOTSSummary(String ofcCd) throws EventException {
		String otsSmryCd = null; 
		try {
			otsSmryCd       = dbDao.searchOTSSummary(ofcCd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage(), ex);
		}
		return otsSmryCd;
	}

	/**
	 * FNS_INV_0016 : Item Correction 조회
	 * @author saeil
	 * @param String ofcCd 
	 * @param String blNo 
	 * @param String invNo
	 * @param String otsSmryCd
	 * @return ARInvoiceCorrectionVO
	 * @exception EventException
	 */
	public ARInvoiceCorrectionVO searchARInvoiceByBL(String ofcCd , String blNo , String invNo, String otsSmryCd) throws EventException {
		try {
			ARInvoiceCorrectionVO aRInvoiceCorrectionVO = new ARInvoiceCorrectionVO();
			List<InvArMnVO> mnList = new ArrayList<InvArMnVO>();
			List<ARInvoiceChargeSumVO> totChgList = new ArrayList<ARInvoiceChargeSumVO>();
			List<ARInvoiceChargeCorrectionVO> chgList = new ArrayList<ARInvoiceChargeCorrectionVO>();
			List<InvArCntrVO> invList = new ArrayList<InvArCntrVO>();
			String ifNo = "";

			ifNo = dbDao.searchMaxInterfaceNoByBL(ofcCd, blNo, invNo);
			
			if (ifNo == null) {
				throw new EventException(new ErrorHandler("INV00095",new String[]{}).getMessage());

			} else {
				if (ifNo.equals("X")) {
					throw new EventException(new ErrorHandler("INV00030",new String[]{}).getMessage());
				}
			}	
			
			aRInvoiceCorrectionVO = dbDao.searchARInvoiceMainByIFNo(ifNo);
			totChgList = dbDao.searchARInvoiceChargeSumByIFNo(ifNo);
			chgList = dbDao.searchARInvoiceChargeByIFNo(ifNo);
			invList = dbDao.searchARInvoiceContainerByIFNo(ifNo);
			
			aRInvoiceCorrectionVO.setListInvoiceChargeSumVO(totChgList);
			aRInvoiceCorrectionVO.setListInvoiceChargeCorrectionVO(chgList);
			aRInvoiceCorrectionVO.setInvArCntrVO(invList);
			
			if(aRInvoiceCorrectionVO.getInvNo().equals("")&&(otsSmryCd.equals("INV")||otsSmryCd.equals("CLR"))){
				mnList = dbDao.searchARInvoiceMainList(ofcCd, blNo , ifNo);
				aRInvoiceCorrectionVO.setInvArMnVO(mnList);
			}			
			
			return aRInvoiceCorrectionVO;
			
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * FNS_INV_0016,FNS_INV_0017,FNS_INV_0018,FNS_INV_0033,FNS_INV_0094<br>
	 * Due Date 조회 이벤트 처리<br>
	 * @author saeil
	 * @param DueDateInputVO dueInputVo
	 * @return List <DueDateVO>
	 * @exception EventException
	 * 
	 */
	public List<DueDateVO> searchDueDate(DueDateInputVO dueInputVo) throws EventException {
		try {
			List<DueDateVO> list = new ArrayList<DueDateVO>();
			
			list = dbDao.searchDueDate(dueInputVo);
			
			return list;
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * FNS_INV_0016,FNS_INV_0017,FNS_INV_0018,FNS_INV_0033,FNS_INV_0094 <br>
	 * effectiveDt,zoneIoc,RevType 조회
	 * @author saeil
	 * @param ARCorrectionCkVO arCorrectionCkVO
	 * @return ARCorrectionCkReturnVO
	 * @exception EventException
	 * 
	 */
	public ARCorrectionCkReturnVO checkARCorrection(ARCorrectionCkVO arCorrectionCkVO) throws EventException {
		try {
			ARCorrectionCkReturnVO arCorrectionCkReturnVO = new ARCorrectionCkReturnVO();
			
			int cnt = 0;
			int podCnt=0;
			int polCnt = 0;
			String zoneIoc = null;
			String effectiveDt = null;
			
			if (arCorrectionCkVO.getBlInvCfmDt() == null) {
				cnt = dbDao.checkVesselSKD(arCorrectionCkVO.getVvdCd(),arCorrectionCkVO.getIoBndCd(),arCorrectionCkVO.getPol(),arCorrectionCkVO.getPod());
				log.info("==>"+cnt);
				
				if (cnt > 0) {
					podCnt = dbDao.checkPort(arCorrectionCkVO.getPod());
					polCnt = dbDao.checkPort(arCorrectionCkVO.getPol());
					
					if ((podCnt > 0) && (polCnt > 0)) {
						zoneIoc = dbDao.searchZoneIOC(arCorrectionCkVO.getPol(), arCorrectionCkVO.getPod());
						effectiveDt = dbDao.searchEffectiveDate(arCorrectionCkVO.getOfcCd(), arCorrectionCkVO.getSailingDt());
						arCorrectionCkReturnVO = dbDao.searchRevTypeSrc(arCorrectionCkVO.getBkgNo(), arCorrectionCkVO.getInvCustFlg()); 
					} else {
						throw new EventException(new ErrorHandler("INV00050",new String[]{}).getMessage());
					}
				} else {
					throw new EventException(new ErrorHandler("INV00005",new String[]{}).getMessage());
				}

			} else {
				effectiveDt = dbDao.searchEffectiveDate(arCorrectionCkVO.getOfcCd(), arCorrectionCkVO.getSailingDt());
				arCorrectionCkReturnVO = dbDao.searchRevTypeSrc(arCorrectionCkVO.getBkgNo(), arCorrectionCkVO.getInvCustFlg()); 
				
				if (effectiveDt == null) {
					throw new EventException(new ErrorHandler("INV00122",new String[]{}).getMessage());
				}
			
			}
			arCorrectionCkReturnVO.setEffectiveDt(effectiveDt);
			arCorrectionCkReturnVO.setZoneIoc(zoneIoc);
			
			
			return arCorrectionCkReturnVO;
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
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
	 * Invoice 발송시에 첨부되는 Wording 정보를 조회한다.<br>
	 * option V : VVD/port, C : customer
	 * 
	 * @author JungJin Park
	 * @param InvissAtchInputVO invissAtchInput
	 * @return InvIssAtchVO
	 * @exception EventException
	 */
	public InvIssAtchVO searchInvoiceWording (InvissAtchInputVO invissAtchInput) throws EventException {
		try {
			if (invissAtchInput.getSearchOption().equals("V")) {
				return dbDao.searchInvoiceWordingByVVD(invissAtchInput.getArOfcCd(), invissAtchInput.getVvd(), invissAtchInput.getPortCd());
			}
			else {
				return dbDao.searchInvoiceWordingByCustomer(invissAtchInput.getArOfcCd(), invissAtchInput.getCustCntCd(), invissAtchInput.getCustSeq());
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage(), ex);
		}
	}
	
	/**
	 * 등록 이벤트 처리<br>
	 * Invoice 발송시에 첨부되는 Wording 정보를 생성 및 갱신한다.<br>
	 * option V : VVD/port, C : customer
	 * 
	 * @author JungJin Park
	 * @param InvIssAtchVO invWordVo
	 * @param String userId
	 * @param String option
	 * @exception EventException
	 */
	public void modifyInvoiceWording (InvIssAtchVO invWordVo, String userId, String option) throws EventException{
		try {
			if(null != invWordVo){
				if (option.equals("V")) {
				
					InvIssAtchVO  invIssAtchVO = dbDao.searchInvoiceWordingByVVD(invWordVo.getArOfcCd(), invWordVo.getVvd(), invWordVo.getPortCd());
					
					List<InvIssAtchVO> addList = new ArrayList<InvIssAtchVO>(); 
					List<InvIssAtchVO> modifyList = new ArrayList<InvIssAtchVO>();
					
					boolean btnEventInsert = true;
					if (invIssAtchVO != null) {
						btnEventInsert = false;
					}
					
					for ( int i=0; i<5; i++ ) {
						InvIssAtchVO insertInvIssAtchVO = new InvIssAtchVO();
						
						insertInvIssAtchVO.setArOfcCd(invWordVo.getArOfcCd());
						insertInvIssAtchVO.setIbflag(invWordVo.getIbflag());
						insertInvIssAtchVO.setMaxRows(invWordVo.getMaxRows());
						insertInvIssAtchVO.setPortCd(invWordVo.getPortCd());
						insertInvIssAtchVO.setVvd(invWordVo.getVvd());
						insertInvIssAtchVO.setVslCd(invWordVo.getVvd().substring(0, 4));
						insertInvIssAtchVO.setSkdVoyNo(invWordVo.getVvd().substring(4, 8));
						insertInvIssAtchVO.setSkdDirCd(invWordVo.getVvd().substring(8, 9));
						insertInvIssAtchVO.setVvd(invWordVo.getVvd());
						
						insertInvIssAtchVO.setCreUsrId(userId);
						insertInvIssAtchVO.setUpdUsrId(userId);
						
						if (i == 0) {
							insertInvIssAtchVO.setTxtNo("1");
							insertInvIssAtchVO.setInvIssCtnt(invWordVo.getSubject());
							insertInvIssAtchVO.setFontBoldFlg("N");
							
							if (btnEventInsert) {
								addList.add(insertInvIssAtchVO);
							}
							else {
								modifyList.add(insertInvIssAtchVO);
							}
						}
						else if (i == 1) {
							insertInvIssAtchVO.setTxtNo("2");
							insertInvIssAtchVO.setInvIssCtnt(invWordVo.getText1());
							insertInvIssAtchVO.setFontBoldFlg(invWordVo.getHighLight1());
							
							if (btnEventInsert) {
								addList.add(insertInvIssAtchVO);
							}
							else {
								modifyList.add(insertInvIssAtchVO);
							}
						}
						else if (i == 2) {
							insertInvIssAtchVO.setTxtNo("3");
							insertInvIssAtchVO.setInvIssCtnt(invWordVo.getText2());
							insertInvIssAtchVO.setFontBoldFlg(invWordVo.getHighLight2());
							
							if (btnEventInsert) {
								addList.add(insertInvIssAtchVO);
							}
							else {
								modifyList.add(insertInvIssAtchVO);
							}
						}
						else if (i == 3) {
							insertInvIssAtchVO.setTxtNo("4");
							insertInvIssAtchVO.setInvIssCtnt(invWordVo.getText3());
							insertInvIssAtchVO.setFontBoldFlg(invWordVo.getHighLight3());
							
							if (btnEventInsert) {
								addList.add(insertInvIssAtchVO);
							}
							else {
								modifyList.add(insertInvIssAtchVO);
							}
						}
						else if (i == 4) {
							insertInvIssAtchVO.setTxtNo("5");
							insertInvIssAtchVO.setInvIssCtnt(invWordVo.getText4());
							insertInvIssAtchVO.setFontBoldFlg(invWordVo.getHighLight4());
							
							if (btnEventInsert) {
								addList.add(insertInvIssAtchVO);
							}
							else {
								modifyList.add(insertInvIssAtchVO);
							}
						}
					}
					
					if (btnEventInsert) {
						dbDao.addInvoiceWordingByVVD(addList);
					}
					else {
						dbDao.modifyInvoiceWordingByVVD(modifyList);
					}
				}
				else {
					InvIssAtchVO  invIssAtchVO = dbDao.searchInvoiceWordingByCustomer(invWordVo.getArOfcCd(), invWordVo.getCustCntCd(), invWordVo.getCustSeq());
					
					List<InvIssAtchVO> addList = new ArrayList<InvIssAtchVO>(); 
					List<InvIssAtchVO> modifyList = new ArrayList<InvIssAtchVO>();
					
					boolean btnEventInsert = true;
					if (invIssAtchVO != null) {
						btnEventInsert = false;
					}
					
					for ( int i=0; i<5; i++ ) {
						InvIssAtchVO insertInvIssAtchVO = new InvIssAtchVO();
						
						insertInvIssAtchVO.setArOfcCd(invWordVo.getArOfcCd());
						insertInvIssAtchVO.setIbflag(invWordVo.getIbflag());
						insertInvIssAtchVO.setMaxRows(invWordVo.getMaxRows());
						insertInvIssAtchVO.setCustCntCd(invWordVo.getCustCntCd());
						insertInvIssAtchVO.setCustSeq(invWordVo.getCustSeq());
						
						insertInvIssAtchVO.setCreUsrId(userId);
						insertInvIssAtchVO.setUpdUsrId(userId);
						
						if (i == 0) {
							insertInvIssAtchVO.setTxtNo("1");
							insertInvIssAtchVO.setInvIssCtnt(invWordVo.getSubject());
							insertInvIssAtchVO.setFontBoldFlg("N");
							
							if (btnEventInsert) {
								addList.add(insertInvIssAtchVO);
							}
							else {
								modifyList.add(insertInvIssAtchVO);
							}
						}
						else if (i == 1) {
							insertInvIssAtchVO.setTxtNo("2");
							insertInvIssAtchVO.setInvIssCtnt(invWordVo.getText1());
							insertInvIssAtchVO.setFontBoldFlg(invWordVo.getHighLight1());
							
							if (btnEventInsert) {
								addList.add(insertInvIssAtchVO);
							}
							else {
								modifyList.add(insertInvIssAtchVO);
							}
						}
						else if (i == 2) {
							insertInvIssAtchVO.setTxtNo("3");
							insertInvIssAtchVO.setInvIssCtnt(invWordVo.getText2());
							insertInvIssAtchVO.setFontBoldFlg(invWordVo.getHighLight2());
							
							if (btnEventInsert) {
								addList.add(insertInvIssAtchVO);
							}
							else {
								modifyList.add(insertInvIssAtchVO);
							}
						}
						else if (i == 3) {
							insertInvIssAtchVO.setTxtNo("4");
							insertInvIssAtchVO.setInvIssCtnt(invWordVo.getText3());
							insertInvIssAtchVO.setFontBoldFlg(invWordVo.getHighLight3());
							
							if (btnEventInsert) {
								addList.add(insertInvIssAtchVO);
							}
							else {
								modifyList.add(insertInvIssAtchVO);
							}
						}
						else if (i == 4) {
							insertInvIssAtchVO.setTxtNo("5");
							insertInvIssAtchVO.setInvIssCtnt(invWordVo.getText4());
							insertInvIssAtchVO.setFontBoldFlg(invWordVo.getHighLight4());
							
							if (btnEventInsert) {
								addList.add(insertInvIssAtchVO);
							}
							else {
								modifyList.add(insertInvIssAtchVO);
							}
						}
					}
					
					if (btnEventInsert) {
						dbDao.addInvoiceWordingByCustomer(addList);
					}
					else {
						dbDao.modifyInvoiceWordingByCustomer(modifyList);
					}
				}
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("INV00053",new String[]{}).getUserMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("INV00053",new String[]{}).getUserMessage(), ex);
		}
	}
	
	/**
	 * 삭제 이벤트 처리<br>
	 * Invoice 발송시에 첨부되는 Wording 정보를 삭제한다.<br>
	 * option V : VVD/port, C : customer
	 * 
	 * @author JungJin Park
	 * @param InvIssAtchVO invWordVo
	 * @param String option
	 * @exception EventException
	 */
	public void removeInvoiceWording (InvIssAtchVO invWordVo, String option) throws EventException{
		try {
			if (option.equals("V")) {
				dbDao.removeInvoiceWordingByVVD(invWordVo);
			}
			else {
				dbDao.removeInvoiceWordingByCustomer(invWordVo);
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("INV00053",new String[]{}).getUserMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("INV00053",new String[]{}).getUserMessage(), ex);
		}
	}
	
	/**
	 * 입력된 Container no가 등록된 장비 존재 여부  확인하고  type size를 가져온다. <br>
	 * 
	 * @param String cntrNo
	 * @return String
	 * @exception EventException
	 */
	public String searchContainerNo (String cntrNo) throws EventException {
		try {
			
			return dbDao.searchContainerNo(cntrNo);
			
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * FNS_INV_0017 Invoice Customer Correction by Date 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @author Choi Do Soon
	 * @param ARInvoiceCustomerInputVO aRInvoiceCustomerInputVO
	 * @return List <ARInvoiceCustomerVO>
	 * @exception EventException 
	 */
	public List<ARInvoiceCustomerVO> searchARInvoiceListByDate(ARInvoiceCustomerInputVO aRInvoiceCustomerInputVO) throws EventException {
		try {
			return dbDao.searchARInvoiceListByDate(aRInvoiceCustomerInputVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * FNS_INV_0017 Invoice Customer Correction by Date 화면 Customer 조회 이벤트 처리<br>
	 * 
	 * @author Choi Do Soon
	 * @param String ofcCd
	 * @param String custNm
	 * @param String shprCustCntCd
	 * @param String shprCustSeq
	 * @param String fwdrCustCntCd
	 * @param String fwdrCustSeq
	 * @return List <MDMCustomerVO>
	 * @exception EventException 
	 */
	public List<MDMCustomerVO> searchARCustomerList(String ofcCd, String custNm, String shprCustCntCd, String shprCustSeq, String fwdrCustCntCd, String fwdrCustSeq) throws EventException {
		try {
			return dbDao.searchARCustomerList(ofcCd, custNm, shprCustCntCd, shprCustSeq, fwdrCustCntCd, fwdrCustSeq);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * FNS_INV_0094_01 Invoice Customer Change (Single) 조회 이벤트 처리<br>
	 * 
	 * @author Choi Do Soon
	 * @param String ofcCd
	 * @param String invNo
	 * @return InvoiceCustomerChangeVO
	 * @exception EventException
	 */
	public InvoiceCustomerChangeVO searchChangeCustomerInvoice(String ofcCd , String invNo) throws EventException{
		try {
			InvoiceCustomerChangeVO invoiceCustomerChangeVO = new InvoiceCustomerChangeVO();
			List<InvoiceCustomerChangeChargeVO> invChgList = new ArrayList<InvoiceCustomerChangeChargeVO>();
			//List<DueDateInputVO> arIfNoList = new ArrayList<DueDateInputVO>();
			
			invoiceCustomerChangeVO = dbDao.searchChangeCustomerInvoiceMain(ofcCd,invNo);
			
			if(invoiceCustomerChangeVO.getInvNo()==null){
				throw new EventException(new ErrorHandler("INV00095", new String[] {}).getMessage());
			}
			invChgList = dbDao.searchChangeCustomerInvoiceCharge(ofcCd,invNo);
			//arIfNoList = dbDao.searchIfNoList(ofcCd,invNo);
			
			invoiceCustomerChangeVO.setInvoiceCustomerChangeChargeVOs(invChgList);
			//invoiceCustomerChangeVO.setDueDateInputVOs(arIfNoList);
			
			return invoiceCustomerChangeVO;
		} catch (EventException ex) {			
			throw ex;
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * FNS_INV_0094_01 Invoice Customer Change (Single) RepCustomer 체크 이벤트 처리<br>
	 * 
	 * @author Choi Do Soon
	 * @param String actCustCntCd
	 * @param String actCustSeq
	 * @return int Cnt
	 * @exception EventException
	 */
	public int checkRepCustomer ( String actCustCntCd, String actCustSeq ) throws EventException{
		try {
			return dbDao.checkRepCustomer(actCustCntCd,actCustSeq);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * FNS_INV_0094_02 Invoice Customer Change (Multi) 조회 이벤트 처리<br>
	 * 
	 * @author Choi Do Soon
	 * @param ChangeCustomerInputVO changeCustomerInputVO
	 * @return InvoiceCustomerChangeVO
	 * @exception EventException
	 */
	public InvoiceCustomerChangeVO searchChangeCustomerInvoiceList(ChangeCustomerInputVO changeCustomerInputVO) throws EventException{
		InvoiceCustomerChangeVO invoiceCustomerChangeVO = new InvoiceCustomerChangeVO();
		List<InvoiceCustomerChangeListVO> invChgList = new ArrayList<InvoiceCustomerChangeListVO>();
		List<DueDateInputVO> arIfNoList = new ArrayList<DueDateInputVO>();
		try {
			invChgList = dbDao.searchChangeCustomerInvoiceList(changeCustomerInputVO);
			arIfNoList = dbDao.searchChangeCustomerIfNoList(changeCustomerInputVO);
			
			invoiceCustomerChangeVO.setInvoiceCustomerChangeListVOs(invChgList);
			invoiceCustomerChangeVO.setDueDateInputVOs(arIfNoList);
			
			return invoiceCustomerChangeVO;
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * FNS_INV_0043 Invoice Report by Date 조회 이벤트 처리<br>
	 * 
	 * @author Choi Do Soon
	 * @param BillInputVO billInputVO
	 * @return List<DirectBillingInvoiceVO>
	 * @exception EventException
	 */
	public List<DirectBillingInvoiceVO> searchDirectBilling(BillInputVO billInputVO) throws EventException{
		try {
			return dbDao.searchDirectBilling(billInputVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * FNS_INV_0018 Invoice Split Before Invoice Issue 조회 이벤트 처리<br>
	 * 
	 * @author Choi Do Soon
	 * @param String ifNo
	 * @param String splitCnt
	 * @param String ofcCd
	 * @return ARInvoiceSplitVO
	 * @exception EventException
	 */
	public ARInvoiceSplitVO searchSplitARInvoiceByIFNo(String ifNo,String splitCnt, String ofcCd) throws EventException{
		ARInvoiceSplitVO aRInvoiceSplitVO = new ARInvoiceSplitVO();
		ARInvoiceCustomerVO aRInvoiceCustomerVO = new ARInvoiceCustomerVO();
		ARInvoiceCorrectionVO aRInvoiceCorrectionVO = new ARInvoiceCorrectionVO();
		List<ARInvoiceChargeCorrectionVO> aRInvoiceChargeCorrectionVOs = new ArrayList<ARInvoiceChargeCorrectionVO>();
		List<InvArCntrVO> invArCntrVOs = new ArrayList<InvArCntrVO>();
		
		try {
			String chkSplitIfNo = dbDao.searchSplitARInvoiceByIFNo (ifNo, ofcCd);
			String maxSeq = "";
			if (chkSplitIfNo.equals("X")){
				aRInvoiceCorrectionVO = dbDao.searchARInvoiceMainByIFNo (ifNo);
				aRInvoiceChargeCorrectionVOs = dbDao.searchARInvoiceChargeByIFNo(ifNo);
				invArCntrVOs = dbDao.searchARInvoiceContainerByIFNo(ifNo);
				aRInvoiceCustomerVO = dbDao.searchBKGCustomerList(aRInvoiceCorrectionVO.getBkgNo() , aRInvoiceCorrectionVO.getIoBndCd());
				maxSeq = dbDao.searchInterfaceNo (ofcCd, splitCnt);
				
				aRInvoiceSplitVO.setListInvoiceChargeCorrectionVO(aRInvoiceChargeCorrectionVOs);
				aRInvoiceSplitVO.setInvArCntrVOs(invArCntrVOs);
				aRInvoiceSplitVO.setARInvoiceCorrectionVO(aRInvoiceCorrectionVO);
				aRInvoiceSplitVO.setARInvoiceCustomerVO(aRInvoiceCustomerVO);				
				aRInvoiceSplitVO.setMaxSeq(maxSeq);
			}else{
				throw new EventException(new ErrorHandler("INV00080",new String[]{}).getMessage());
			}
			
			return aRInvoiceSplitVO;
		
		} catch (EventException ex) {			
			throw ex;
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("INV00080",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * FNS_INV_0033 Invoice Split Before Invoice Issue 조회 이벤트 처리<br>
	 * 
	 * @author Choi Do Soon
	 * @param String invNo
	 * @param String splitCnt
	 * @param String ofcCd
	 * @return ARInvoiceSplitVO
	 * @exception EventException
	 */
	public ARInvoiceSplitVO searchSplitARInvoiceByInvoiceNo(String invNo,String splitCnt, String ofcCd) throws EventException{
		ARInvoiceSplitVO aRInvoiceSplitVO = new ARInvoiceSplitVO();
		ARInvoiceCustomerVO aRInvoiceCustomerVO = new ARInvoiceCustomerVO();
		ARInvoiceCorrectionVO aRInvoiceCorrectionVO = new ARInvoiceCorrectionVO();
		List<ARInvoiceChargeCorrectionVO> aRInvoiceChargeCorrectionVOs = new ArrayList<ARInvoiceChargeCorrectionVO>();
		List<InvArCntrVO> invArCntrVOs = new ArrayList<InvArCntrVO>();
		List<InvArIfNoVO> invArIfNoVOs = new ArrayList<InvArIfNoVO>();
		try {
			invArIfNoVOs = dbDao.searchInterfaceListByInvoiceNo(ofcCd, invNo);
			
			String maxSeq = "";
			//int totSplitCnt = 0;
			if(invArIfNoVOs != null && invArIfNoVOs.size()>0) {				
				//totSplitCnt = Integer.parseInt(splitCnt)+invArIfNoVOs.size()-1;	
				
				aRInvoiceCorrectionVO = dbDao.searchARInvoiceMainByIFNo(invArIfNoVOs.get(0).getMaxIfNo().equals("")?invArIfNoVOs.get(0).getMIfNo():invArIfNoVOs.get(0).getMaxIfNo());
				aRInvoiceChargeCorrectionVOs = dbDao.searchARInvoiceChargeByInvoiceNo(ofcCd, invNo);
				invArCntrVOs = dbDao.searchARInvoiceContainerByIFNo(invArIfNoVOs.get(0).getMaxIfNo().equals("")?invArIfNoVOs.get(0).getIfNo():invArIfNoVOs.get(0).getMaxIfNo());
				aRInvoiceCustomerVO = dbDao.searchBKGCustomerList(aRInvoiceCorrectionVO.getBkgNo() , aRInvoiceCorrectionVO.getIoBndCd());
				
				//2009.11.05 ifno 별 cancel에서 invno 로 한건만 cancel 로 바뀜 
				//maxSeq = dbDao.searchInterfaceNo (ofcCd, Integer.toString(totSplitCnt));
				maxSeq = dbDao.searchInterfaceNo (ofcCd, splitCnt);
				/*
				int cancelSeq = 0;
				
				for(int i=0;i<invArIfNoVOs.size();i++){						
					cancelSeq = Integer.parseInt(maxSeq)-Integer.parseInt(splitCnt)-i;						
					invArIfNoVOs.get(i).setCancelIfNo(ofcCd.substring(0,3)+JSPUtil.getLPAD(Integer.toString(cancelSeq), 7, "0"));
				}
				*/
				/* REV TYPE 이 M TYPE 만 있는 INV NO 도 처리해야 해서 뺌 2010.01.27
				for(int i=0;i<invArIfNoVOs.size();i++){						
					if(invArIfNoVOs.get(i).getMaxIfNo().equals("")){
						throw new EventException(new ErrorHandler("INV00080",new String[]{}).getMessage());
					}
				}
				*/
				
				aRInvoiceSplitVO.setListInvoiceChargeCorrectionVO(aRInvoiceChargeCorrectionVOs);
				aRInvoiceSplitVO.setInvArCntrVOs(invArCntrVOs);
				aRInvoiceSplitVO.setARInvoiceCorrectionVO(aRInvoiceCorrectionVO);
				aRInvoiceSplitVO.setARInvoiceCustomerVO(aRInvoiceCustomerVO);				
				aRInvoiceSplitVO.setInvArIfNoVOs(invArIfNoVOs);				
				aRInvoiceSplitVO.setMaxSeq(maxSeq);
			}else{
				throw new EventException(new ErrorHandler("INV00080",new String[]{}).getMessage());
			}
			
			return aRInvoiceSplitVO;
		
		} catch (EventException ex) {			
			throw ex;
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("INV00080",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * FNS_INV_0028 Invoice 의 Manual Interface 대상 Bkg No, C/A No 를 조회한다.<br>
	 * 
	 * @author Choi Do Soon
	 * @param ManualInputVO manualInputVO
	 * @return List<BkgNoCaNoVO>
	 * @exception EventException
	 */
	public List<BkgNoCaNoVO> searchManualInterface(ManualInputVO manualInputVO) throws EventException{
		try {
			return dbDao.searchManualInterfaceList(manualInputVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * FNS_INV_0079<br>
	 * Booking 과의 Unmatch 난 Revenue VVD 정보들을 조회한다.<br>
	 * 
	 * @author Choi Woo-Seok
	 * @param String fromDt
	 * @param String toDt
	 * @param String bkgIfFlg
	 * @return List<UnmatchRevenueVesselVO>
	 * @exception EventException
	 */
	public List<UnmatchRevenueVesselVO> searchUnmatchRevenueVVDListByDate(String fromDt, String toDt, String bkgIfFlg) throws EventException{
		try {
			return dbDao.searchUnmatchRevenueVVDListByDate(fromDt.replaceAll("-", ""), toDt.replaceAll("-", ""), bkgIfFlg);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * FNS_INV_0027 Ex Rate Update by Date or VVD 환율이 미적용된 B/L 들에 대해 올바른 환율을 적용<br>
	 * 
	 * @author Choi Do Soon
	 * @param ExrateInputVO exrateInputVO
	 * @return List<ExrateTargetMainVO>
	 * @exception EventException
	 */
	public List<ExrateTargetMainVO> searchInvoiceForExrateList(ExrateInputVO exrateInputVO) throws EventException {
		try {
			return dbDao.searchInvoiceMainForExrateList(exrateInputVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * FNS_INV_0027 Ex Rate Update by Date or VVD Chg 테이블 조회<br>
	 * 
	 * @author Choi Do Soon
	 * @param String arIfNo
	 * @return List<ExrateTargetChgVO>
	 * @exception EventException
	 */
	public List<ExrateTargetChgVO> searchInvoiceChgForExrateList(String arIfNo) throws EventException {
		try {
			return dbDao.searchInvoiceChgForExrateList(arIfNo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
  	 * FNS_INV_0017 Customer 변경대상 arIFno 리스트를 BLno 로 조회<br>
  	 * 
	 * @param String ofcCd
	 * @param String blNo
	 * @param String ifNo
	 * @return List<InvArMnVO>
	 * @exception EventException
	 */
	public List<InvArMnVO> searchARInvoiceMainList ( String ofcCd, String blNo , String ifNo) throws EventException{
		try {
			return dbDao.searchARInvoiceMainList(ofcCd, blNo, ifNo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * FNS_INV_0027 BL 별 Max IfNo 조회 <br>
	 * 
	 * @param String ofcCd
	 * @param String blNo
	 * @param String invNo
	 * @return String
	 * @exception DAOException
	 */
	public String searchMaxInterfaceForExrate ( String ofcCd , String blNo , String invNo) throws EventException {
		String arIfNo = null; 
		try {
			arIfNo = dbDao.searchMaxInterfaceForExrate ( ofcCd, blNo, invNo );
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage(), ex);
		}
		return arIfNo;
	}
	
	/**
	 * FNS_INV_0079<br>
	 * Unmatch Revenue VVD 정보에 BKG Interface 처리여부를 update 한다.<br>
	 * 
	 * @author Choi Woo-Seok
	 * @param String bkgNo
	 * @exception EventException
	 */
	public void modifyBKGInterfaceFlag(String bkgNo) throws EventException{
		try {
			dbDao.modifyBKGInterfaceFlag(bkgNo);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("INV00053",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("INV00053",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Rev Type,Rev Src 조회한다<br>
	 * 
	 * @param String bkgNo
	 * @param String invCustFlg
	 * @return ARCorrectionCkReturnVO
	 * @exception EventException
	 * 
	 */
	public ARCorrectionCkReturnVO searchRevTypeSrc(String bkgNo, String invCustFlg) throws EventException {
		try {
			ARCorrectionCkReturnVO aRCorrectionCkReturnVO = new ARCorrectionCkReturnVO();
			
			aRCorrectionCkReturnVO = dbDao.searchRevTypeSrc(bkgNo, invCustFlg); 
			
			return aRCorrectionCkReturnVO;
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * FNS_INV_0027 iFNo 로 Inv No 조회 <br>
	 * 
	 * @param String arIfNo
	 * @return String
	 * @exception DAOException
	 */
	public String searchInvoiceNoByIfNo ( String arIfNo ) throws EventException {
		String invNo = null; 
		try {
			invNo = dbDao.searchInvoiceNoByIfNo ( arIfNo );
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage(), ex);
		}
		return invNo;
	}
	
	/**
	 * FNS_INV_0079 run 실행 <br>
	 * 
	 * @param String fromDt
	 * @param String toDt
	 * @param String usrId
	 * @exception DAOException
	 */
	public void createUnmatchRevenueVVDListByDate(String fromDt, String toDt, String usrId) throws EventException {
		try {
			dbDao.createUnmatchRevenueVVDListByDate (fromDt, toDt, usrId);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("INV00053",new String[]{}).getUserMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("INV00053",new String[]{}).getUserMessage(), ex);
		}
	}
	
	/**
	 * BKG_BOOKING 에서 VVD로 BKGNO 구해옴 <br>
	 * 
	 * @param String vvd
	 * @param String pol
	 * @param String pod
	 * @return String List<ARBkgInterfaceCreationVO>
	 * @exception DAOException
	 */
	public List<ARBkgInterfaceCreationVO> searchBkgNoByVvd ( String vvd, String pol, String pod )  throws EventException {
		try {
			return dbDao.searchBkgNoByVvd(vvd, pol, pod);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * 국가별 VAT 요율을 조회<br>
	 * 
	 * @return List<InvArEuCntVatVO>
	 * @exception EventException
	 */		
	public List<InvArEuCntVatVO> searchVatRatioEntryList() throws EventException {
		try{
			return dbDao.searchVatRatioEntryList();
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}
	
	
	/**
	 * 국가별 VAT 요율을 등록, 수정, 삭제한다.<br>
	 * 
	 * @param InvArEuCntVatVO[] invArEuCntVatVOs
	 * @param userId
	 * @exception EventException
	 */
	public void manageVatRatioEntry(InvArEuCntVatVO[] invArEuCntVatVOs, String userId) throws EventException {
		List<InvArEuCntVatVO> addVoList = new ArrayList<InvArEuCntVatVO>();
		List<InvArEuCntVatVO> updateVoList = new ArrayList<InvArEuCntVatVO>();
		try {
			for (int i = 0; i < invArEuCntVatVOs.length; i++) {
				if (invArEuCntVatVOs[i].getIbflag().equals("I")) {
					invArEuCntVatVOs[i].setCreUsrId(userId);
					invArEuCntVatVOs[i].setUpdUsrId(userId);					
					addVoList.add(invArEuCntVatVOs[i]);

				} else if (invArEuCntVatVOs[i].getIbflag().equals("U")) {
					invArEuCntVatVOs[i].setUpdUsrId(userId);
					updateVoList.add(invArEuCntVatVOs[i]);
				} else if (invArEuCntVatVOs[i].getIbflag().equals("D")) {
					invArEuCntVatVOs[i].setUpdUsrId(userId);
					invArEuCntVatVOs[i].setDeltFlg("Y");
					updateVoList.add(invArEuCntVatVOs[i]);
				}
			}
			if (addVoList.size() > 0) {
				dbDao.addVatRatioEntry(addVoList);
			}			
			if (updateVoList.size() > 0) {
				dbDao.modifyVatRatioEntry(updateVoList);
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
	 * MDM_COUNTRY에서 EURO Country List를 가져온다.<br>
	 * 
	 * @return List<String>
	 * @exception DAOException
	 */
	public List<String> searchEuroCountryList() throws EventException {
		try{
			return dbDao.searchEuroCountryList();
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * B/L No. 와 Ofc CD로 Reverse Charge 조회<br>
	 * 
	 * @param String blSrcNo
	 * @param String arOfcCd
	 * @return String List<MarkingReverseChargeVO>
	 * @exception DAOException
	 */
	public List<MarkingReverseChargeVO> searchMarkingReverseChargeByIfNo(String blSrcNo, String arOfcCd)  throws EventException {
		try {
			return dbDao.searchMarkingReverseChargeByIfNo(blSrcNo, arOfcCd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * Customer Correction 시 BL No의 Max If NO인지 체크 이벤트 처리<br>
	 * 
	 * @param String arOfcCd
	 * @param String blSrcNo
	 * @param String arIfNo
	 * @return int
	 * @exception EventException
	 */
	public int checkMaxIfNo ( String arOfcCd, String blSrcNo, String arIfNo ) throws EventException{
		try {
			return dbDao.checkMaxIfNo(arOfcCd, blSrcNo, arIfNo);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Split 시 If No 의 Split 가능여부 체크 이벤트 처리<br>
	 * 
	 * @param String ifNo
	 * @param String ofcCd
	 * @return String
	 * @exception EventException
	 */
	public String checkSplitARInvoiceByIFNo ( String ifNo, String ofcCd ) throws EventException{
		try {
			return dbDao.searchSplitARInvoiceByIFNo (ifNo, ofcCd);		
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Invoice Item Correction시 CHG의 금액의 합의 체크 이벤트 처리<br>
	 * 
	 * @param String blNo
	 * @param String ofcCd
	 * @return boolean
	 * @exception EventException
	 */	
	public boolean checkChgAmount (String blNo, String ofcCd) throws EventException{
		try {
			return dbDao.checkChgAmount(blNo, ofcCd);		
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	

	/**
	 * @param blSrcNo
	 * @param bkgNo
	 * @param splitCnt
	 * @param ofcCd
	 * @return
	 * @throws EventException
	 */
	public ARInvoiceSplitVO searchSplitARInvoiceByBL(String blSrcNo, String bkgNo, String splitCnt, String ofcCd) throws EventException	{
		ARInvoiceSplitVO aRInvoiceSplitVO = new ARInvoiceSplitVO();
		ARInvoiceCorrectionVO aRInvoiceCorrectionVO = new ARInvoiceCorrectionVO();
		List<ARInvoiceChargeCorrectionVO> aRInvoiceChargeCorrectionVOs = new ArrayList<ARInvoiceChargeCorrectionVO>();
		List<InvArCntrVO> invArCntrVOs = new ArrayList<InvArCntrVO>();
		try	{
			String chkSplitIfNo[] = dbDao.searchOTSSummaryInvDup(ofcCd);
			if(chkSplitIfNo[1].equals("N"))
				throw new EventException((new ErrorHandler("INV00161", new String[0])).getMessage());
			if(!chkSplitIfNo[0].equals("INV") && !chkSplitIfNo[0].equals("CLR")) {
				String ifNo = dbDao.searchSplitARInvoiceByBL(ofcCd, blSrcNo, bkgNo);
				aRInvoiceCorrectionVO = dbDao.searchARInvoiceMainByIFNo(ifNo);
				aRInvoiceChargeCorrectionVOs = dbDao.searchARInvoiceChargeByBL(ofcCd, blSrcNo, bkgNo);
				invArCntrVOs = dbDao.searchARInvoiceContainerByIFNo(ifNo);
				aRInvoiceSplitVO.setListInvoiceChargeCorrectionVO(aRInvoiceChargeCorrectionVOs);
				aRInvoiceSplitVO.setInvArCntrVOs(invArCntrVOs);
				
				// OFC_CD가 상파울로인 경우 SA_ARR_DT를 새로 구한다.
				if ("SAOSC".equals(ofcCd)) {
					String saArrDtNew = dbDao.searchActalSailingArrivalDate(aRInvoiceCorrectionVO);
					if (saArrDtNew != null && !"".equals(saArrDtNew)) {
						aRInvoiceCorrectionVO.setSailArrDt(saArrDtNew);
					}
				}
				
				aRInvoiceSplitVO.setARInvoiceCorrectionVO(aRInvoiceCorrectionVO);				
				
			} else {
				throw new EventException((new ErrorHandler("INV00080", new String[0])).getMessage());
			}
			return aRInvoiceSplitVO;
		} catch(EventException ex) {
			throw ex;
		} catch(DAOException ex) {
			throw new EventException((new ErrorHandler("INV00080", new String[0])).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException((new ErrorHandler("COM12240", new String[0])).getMessage(), ex);
		}
	}

	/**
	 * Max interface no 값을 리턴.
	 * 
	 * @param blSrcNo
	 * @param arOfcCd
	 * @return String
	 * @throws EventException
	 */
	public String searchMaxInterfaceNoByBL(String blSrcNo, String arOfcCd) throws EventException {
		try {
			return dbDao.searchMaxInterfaceNoByBL(blSrcNo, arOfcCd);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}	
	}
	
	/**
	 * DOD 건수 값을 리턴.
	 * 
	 * @param ofcCd
	 * @param invNo
	 * @return String
	 * @throws EventException
	 */
	public String searchDODCount(String ofcCd, String invNo) throws EventException {
		try {
			return dbDao.searchDODCount(ofcCd, invNo);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}	
	}
	
	/**
	 * 인도지역 Tax Invoice 발행여부 체크<br>
	 * 
	 * @param String arOfcCd
	 * @param String blSrcNo
	 * @return int
	 * @exception EventException
	 */
	public int checkTaxInvoice ( String arOfcCd, String blSrcNo) throws EventException{
		try {
			return dbDao.checkTaxInvoice(arOfcCd, blSrcNo);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
}