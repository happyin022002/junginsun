/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ARInvoiceCorrectionBCImpl.java
*@FileTitle : Invoice Split Before Invoice Issue
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ARBkgInterfaceCreationVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ExrateInputVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ExrateTargetChgVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ExrateTargetMainVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.InvArCntrVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.InvArMnVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.SysClearVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.integration.GeneralARInvoiceCreationDBDAO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.ARInterfaceCreationVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.InvArIfChgVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.InvArIfCntrVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.InvArIfMnVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.integration.ARInvoiceCorrectionDBDAO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.ARCorrectionCkReturnVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.ARCorrectionCkVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.ARInvoiceChargeCorrectionVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.ARInvoiceCorrectionVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.ARInvoiceCustomerInputVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.ARInvoiceCustomerVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.ARInvoiceSplitVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.BkgNoCaNoVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.ChangeCustomerInputVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.DueDateInputVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.DueDateVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.InvArIfNoVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.InvoiceCustomerChangeChargeVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.InvoiceCustomerChangeListVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.InvoiceCustomerChangeVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.MDMCustomerVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.ManualInputVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.ARInvoiceChargeSumVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.ARInvoiceSplitCondVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.InvArChgVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.InvArAmtVO;
import com.clt.framework.component.backend.core.BackEndJobManager;
import com.clt.framework.component.backend.support.BackEndJobMetaDataSelector;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;

/**
 * AccountReceivableInvoiceMgt Business Logic Basic Command implementation<br>
 * - AccountReceivableInvoiceMgt logic process<br>
 *
 * @author saeil kim
 * @see FNS_INV_0018EventResponse,ARInvoiceCorrectionBC
 * @since J2EE 1.4
 */

public class ARInvoiceCorrectionBCImpl extends BasicCommandSupport implements ARInvoiceCorrectionBC {

	// Database Access Object
	private transient ARInvoiceCorrectionDBDAO dbDao = null;

	/**
	 * ARInvoiceCorrectionBCImpl object creation.<br>
	 * ARInvoiceCorrectionDBDAO creation.<br>
	 */
	public ARInvoiceCorrectionBCImpl() {
		dbDao = new ARInvoiceCorrectionDBDAO();
	}	
	
	

	/**
	 * OTS Summary Code retrieve<br>
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
	 * FNS_INV_0016 : Item Correction retrieve
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
			//List<InvArMnVO> mnList = new ArrayList<InvArMnVO>();
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
			
			/* block 2016.06.01
			if(aRInvoiceCorrectionVO.getInvNo().equals("")&&(otsSmryCd.equals("INV")||otsSmryCd.equals("CLR"))){
				mnList = dbDao.searchARInvoiceMainList(ofcCd, blNo , ifNo);
				aRInvoiceCorrectionVO.setInvArMnVO(mnList);
			}			
			*/
			
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
	 * Due Date retrieve event process<br>
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
	 * effectiveDt,zoneIoc,RevType retrieve
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
			if(zoneIoc != null){
				arCorrectionCkReturnVO.setZoneIoc(zoneIoc);
			} else {
				arCorrectionCkReturnVO.setZoneIoc(null);
			}
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
	 * Input Container No. check and get type size.<br>
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
	 * FNS_INV_0017 Invoice Customer Correction by Date screen retrieve event process<br>
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
	 * FNS_INV_0017 Invoice Customer Correction by Date screen Customer retrieve event process<br>
	 * 
	 * @author Choi Do Soon
	 * @param String ofcCd
	 * @param String custNm
	 * @return List <MDMCustomerVO>
	 * @exception EventException 
	 */
	public List<MDMCustomerVO> searchARCustomerList(String ofcCd, String custNm) throws EventException {
		try {
			return dbDao.searchARCustomerList(ofcCd, custNm);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * FNS_INV_0094_01 Invoice Customer Change (Single) retrieve event process<br>
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
	 * FNS_INV_0094_01 Invoice Customer Change (Single) RepCustomer check event process<br>
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
	 * FNS_INV_0094_02 Invoice Customer Change (Multi) retrieve event process<br>
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
	 * FNS_INV_0018 Invoice Split Before Invoice Issue retrieve event process<br>
	 * 
	 * @author Choi Do Soon
	 * @param String ifNo
	 * @param String splitCnt
	 * @param String ofcCd
	 * @param String issToSplitFlg
	 * @param String invDeltDivCd
	 * @return ARInvoiceSplitVO
	 * @exception EventException
	 */
	public ARInvoiceSplitVO searchSplitARInvoiceByIFNo(String ifNo,String splitCnt, String ofcCd, String issToSplitFlg, String invDeltDivCd) throws EventException{
		ARInvoiceSplitVO aRInvoiceSplitVO = new ARInvoiceSplitVO();
		ARInvoiceCustomerVO aRInvoiceCustomerVO = new ARInvoiceCustomerVO();
		ARInvoiceCorrectionVO aRInvoiceCorrectionVO = new ARInvoiceCorrectionVO();
		List<ARInvoiceChargeCorrectionVO> aRInvoiceChargeCorrectionVOs = new ArrayList<ARInvoiceChargeCorrectionVO>();
		List<InvArCntrVO> invArCntrVOs = new ArrayList<InvArCntrVO>();
		List<String> ifNoList = new ArrayList<String>();
		String orgIfNoList = "";
		String cxlIfNoList = "";
		
		try {
			
			//Add for checking splitted and no issued 2016.05.02
			if(("N").equals(issToSplitFlg)){
				int splitNoIssueCnt = dbDao.searchSplitNoIssueCount(ifNo);		
				if(splitNoIssueCnt > 0) throw new EventException(new ErrorHandler("INV00190",new String[]{}).getMessage());
			}
			
			String chkSplitIfNo = dbDao.searchSplitARInvoiceByIFNo (ifNo, ofcCd);
			String maxSeq = "";
			if (chkSplitIfNo.equals("X")){
				aRInvoiceCorrectionVO = dbDao.searchARInvoiceMainByIFNo (ifNo);
				aRInvoiceChargeCorrectionVOs = dbDao.searchARInvoiceChargeByIFNo(ifNo);
				invArCntrVOs = dbDao.searchARInvoiceContainerByIFNo(ifNo);
				aRInvoiceCustomerVO = dbDao.searchBKGCustomerList(aRInvoiceCorrectionVO.getBkgNo() , aRInvoiceCorrectionVO.getIoBndCd());
				
				if(("Y").equals(issToSplitFlg)){
					if(("N").equals(invDeltDivCd)) {
						ifNoList = dbDao.searchCancelTargetIFList(ifNo);
					} else {
						ifNoList.add(ifNo + "N");
					}
					
					if(ifNoList != null){
						String cxlIfSeq = "";
						
						for(int i = 0; i < ifNoList.size(); i++){
							orgIfNoList = orgIfNoList.concat(ifNoList.get(i));
							cxlIfSeq = dbDao.searchInterfaceNo (ofcCd, splitCnt);
							cxlIfNoList = cxlIfNoList.concat(ofcCd.substring(0,3) + JSPUtil.getLPAD(cxlIfSeq, 8, "0"));
							
							if(i < ifNoList.size() - 1){
								orgIfNoList = orgIfNoList + ",";
								cxlIfNoList = cxlIfNoList + ",";
							}
							
						}
						maxSeq = "0";
					}
				} else {
                    maxSeq = dbDao.searchInterfaceNo (ofcCd, splitCnt); 
                }
				
                String ifNoSeq = "";
                
                for(int i = 0; i < Integer.parseInt(splitCnt); i++){
                    ifNoSeq = dbDao.searchInterfaceNo (ofcCd, splitCnt);
                    maxSeq = maxSeq.concat("^").concat(ifNoSeq);
                }
				
				String maxIfNo = dbDao.searchMaxIfNo(ifNo);
				
				aRInvoiceSplitVO.setListInvoiceChargeCorrectionVO(aRInvoiceChargeCorrectionVOs);
				aRInvoiceSplitVO.setInvArCntrVOs(invArCntrVOs);
				aRInvoiceSplitVO.setARInvoiceCorrectionVO(aRInvoiceCorrectionVO);
				aRInvoiceSplitVO.setARInvoiceCustomerVO(aRInvoiceCustomerVO);				
				aRInvoiceSplitVO.setMaxSeq(maxSeq);
				aRInvoiceSplitVO.setOrgIfNoList(orgIfNoList);
				aRInvoiceSplitVO.setCxlIfNoList(cxlIfNoList);
				aRInvoiceSplitVO.setMaxIfNo(maxIfNo);
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
	 * FNS_INV_0033 Invoice Split Before Invoice Issue retrieve event process.<br>
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
				

				String ifNoSeq = "";
	                
                for(int i = 0; i < Integer.parseInt(splitCnt) + 1; i++){
                    ifNoSeq = dbDao.searchInterfaceNo (ofcCd, splitCnt);
                    if(i == 0) maxSeq = ifNoSeq;
                    else maxSeq = maxSeq.concat("^").concat(ifNoSeq);
                }

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
	 * FNS_INV_0028 Invoice's Manual Interface Bkg No, C/A No retrieve.<br>
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
	 * FNS_INV_0027 Ex Rate Update by Date or VVD rates unapplied B/L, validate rates apply<br>
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
	 * FNS_INV_0027 Ex Rate Update by Date or VVD Chg table retrieve<br>
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
  	 * FNS_INV_0017 Customer change target arIFno list BLno retrieve<br>
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
	 * FNS_INV_0027 BL Max IfNo retrieve <br>
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
	 * Rev Type,Rev Src retrieve<br>
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
	 * FNS_INV_0027 iFNo Inv No retrieve <br>
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
	 * BKG_BOOKING VVD BKGNO <br>
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
     * Search general interface table<br>
     * 
     * @param String srcIfDt
     * @param String srcIfSeq
     * @return List<ARInterfaceCreationVO>
     * @exception EventException
     */  
    public List<ARInterfaceCreationVO> searchGeneralARInvoiceInterface(String srcIfDt, String srcIfSeq) throws EventException {
    	
    	List<ARInterfaceCreationVO> genIfVosDb = new ArrayList<ARInterfaceCreationVO>();
		ARInterfaceCreationVO genIfVoDb = new ARInterfaceCreationVO();
		InvArIfMnVO invArIfMnVO = null;
		List<InvArIfChgVO> invArIfChgVOs = null;
		List<InvArIfCntrVO> invArIfCntrVOs = null;
		GeneralARInvoiceCreationDBDAO genDao = new GeneralARInvoiceCreationDBDAO();
		
    	try {
    		
    		invArIfMnVO = genDao.searchInvArIfMain(srcIfDt, srcIfSeq);			
			invArIfChgVOs = genDao.searchInvArIfChg(srcIfDt, srcIfSeq);			
			invArIfCntrVOs = genDao.searchInvArIfCntr(srcIfDt, srcIfSeq);
						
			genIfVoDb.setInvArIfMnVO(invArIfMnVO);			
			genIfVoDb.setInvArIfChgVOs(invArIfChgVOs);	
			genIfVoDb.setInvArIfCntrVOs(invArIfCntrVOs);						
			genIfVosDb.add(genIfVoDb);
   		
    		return genIfVosDb;    		
    	} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
    }  
    
    /**
     * Search split customer info<br>
     * 
     * @param String arIfNo
     * @return List<String>
     * @exception EventException
     */  
    public List<String> searchSplitCustInfo(String arIfNo) throws EventException {
    		
    	try {
    		return dbDao.searchSplitCustInfo(arIfNo);    		
    	} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
    }  
    
    /**
	 * Search Sailing date by i/f no<br>
	 * 
	 * @param String arIfNo
	 * @return String
	 * @exception EventException
	 * 
	 */
	public String searchSailDateByIfNo(String arIfNo) throws EventException {
		
		try {
			return dbDao.searchSailDateByIfNo(arIfNo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage(), ex);
		}
	}
	
	/**
	 * Search Not Issued Count<br>
	 * 
	 * @param String arOfcCd
	 * @param String invNo
	 * @return int
	 * @exception EventException
	 * 
	 */
	public int searchNotIssuedCount( String arOfcCd, String invNo ) throws EventException {
		
		try {
			return dbDao.searchNotIssuedCount(arOfcCd, invNo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage(), ex);
		}
	}

	/**
	 * Search Max Interface No By BL<br>
	 * 
	 * @param String ofcCd
	 * @param String blNo
	 * @param String invNo
	 * @return String
	 * @exception EventException
	 * 
	 */
	public String searchMaxInterfaceNoByBL( String ofcCd, String blNo, String invNo) throws EventException {
		
		try {
			return dbDao.searchMaxInterfaceNoByBL(ofcCd, blNo, invNo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage(), ex);
		}
	}
	
	/**
	 * Modify SysClear By IF No<br>
	 * 
	 * @param SysClearVO sysClearVo
	 * @exception EventException
	 */
	public void modifySysClearByIFNo(SysClearVO sysClearVo) throws EventException {
		
		List<SysClearVO> ifNoList = null;
		String arIfNoA = "";
		String arIfNoB = "";
		
		try {		
			
			ifNoList = dbDao.searchIFNoListForSysClear(sysClearVo);			
			
			if(ifNoList != null){
				for (int i=0; i<ifNoList.size(); i++) {
					arIfNoA = ifNoList.get(i).getArIfNo();
					
					for (int j=0; j<ifNoList.size(); j++) {
						arIfNoB = ifNoList.get(j).getArIfNo();
						
						if(!(arIfNoA).equals(arIfNoB)){
							dbDao.modifySysClearMainByIFNo(arIfNoA, arIfNoB, sysClearVo.getUserId());
							dbDao.modifySysClearChgByIFNo(arIfNoA, arIfNoB, sysClearVo.getUserId());
						}
					}
				}
			}

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage(), ex);
		}
	}
	
	/**
	 * [FNS_INV_0018]
	 * manageSplitARInvoiceByIFNo BackEndJob process
	 * 
	 * @author KIMOKRYE
	 * @param ARInvoiceSplitCondVO arSplitCondVO
	 * @param InvArMnVO[] invArMnVOs
	 * @param InvArChgVO[] invArChgVOs
	 * @param InvArAmtVO[] invArAmtVOs
	 * @param InvArCntrVO[] invArCntrVOs
	 * @param String usrId
	 * @return String
	 * @exception EventException
	 */
	public String manageSplitARInvoiceByIFNo(ARInvoiceSplitCondVO arSplitCondVO, InvArMnVO[] invArMnVOs, InvArChgVO[] invArChgVOs , InvArAmtVO[] invArAmtVOs,  InvArCntrVO[] invArCntrVOs, String usrId) throws EventException {
		SplitARInvoiceByIFNoBackEndJob splitARInvoiceByIFNoBackEndJob = new SplitARInvoiceByIFNoBackEndJob();
		BackEndJobManager backEndJobManager = new BackEndJobManager();

		try {
			
			splitARInvoiceByIFNoBackEndJob.setCondVO(arSplitCondVO);
			splitARInvoiceByIFNoBackEndJob.setInvArMnVOs(invArMnVOs);
			splitARInvoiceByIFNoBackEndJob.setInvArChgVOs(invArChgVOs);
			splitARInvoiceByIFNoBackEndJob.setInvArAmtVOs(invArAmtVOs);
			splitARInvoiceByIFNoBackEndJob.setInvArCntrVOs(invArCntrVOs);			

			return backEndJobManager.execute(splitARInvoiceByIFNoBackEndJob, usrId, "manageSplitARInvoiceByIFNo");
		 } catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12192", new String[]{"manageSplitARInvoiceByIFNo BackEndJob"}).getMessage(),ex);
		}
	}
	
	/**
	 * return result of  Back End Job.
	 *
	 * @param String key
	 * @return String[]
	 * @exception EventException
	 */
	public String[] checkBackEndJob(String key) throws EventException {
		DBRowSet rowSet;
		try {
			String[] result = new String[2];
			rowSet = new BackEndJobMetaDataSelector(key).getDbRowset();
			
			if(rowSet.next()) {
				//Thread.sleep(1000);
				result[0] = rowSet.getString("jb_sts_flg");
				result[1] = rowSet.getString("jb_usr_err_msg");
			}
			return result;
		} catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	
	
	/**
	 * Search Invoice No by I/F No<br>
	 * 
	 * @param String ifNo
	 * @return String
	 * @exception EventException
	 * 
	 */
	public String searchInvNoByIfNo( String ifNo) throws EventException {
		
		try {
			return dbDao.searchInvNoByIfNo(ifNo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage(), ex);
		}
	}
	
	/**
	 * Search Max I/F no by I/F No<br>
	 * 
	 * @param String ifNo
	 * @return String
	 * @exception EventException
	 * 
	 */
	public String searchMaxIfNo( String ifNo) throws EventException {
		
		try {
			return dbDao.searchMaxIfNo(ifNo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage(), ex);
		}
	}
	
	/**
	 * Search issue flag by I/F No<br>
	 * 
	 * @param String ifNo
	 * @return String
	 * @exception EventException
	 * 
	 */
	public String searchInvIssFlgByIfNo( String ifNo) throws EventException {
		
		try {
			return dbDao.searchInvIssFlgByIfNo(ifNo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage(), ex);
		}
	}
	
	/**
	 * Search Split Count<br>
	 * 
	 * @param String arIfNo
	 * @return int
	 * @exception EventException
	 * 
	 */
	public int searchSplitCountByIfNo( String arIfNo ) throws EventException {
		
		try {
			return dbDao.searchSplitCountByIfNo(arIfNo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage(), ex);
		}
	}
}