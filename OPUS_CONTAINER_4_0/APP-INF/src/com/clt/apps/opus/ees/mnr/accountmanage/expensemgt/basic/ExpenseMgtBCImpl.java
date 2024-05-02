/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ExpenseMgtBCImpl.java
*@FileTitle : ExpenseMgtBCImpl
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.mnr.accountmanage.expensemgt.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.ees.mnr.accountmanage.expensemgt.integration.ExpenseMgtDBDAO;
import com.clt.apps.opus.ees.mnr.accountmanage.expensemgt.vo.CustomMnrPayInvWrkVO;
import com.clt.apps.opus.ees.mnr.accountmanage.expensemgt.vo.CustomPayableINVInquiryListVO;
import com.clt.apps.opus.ees.mnr.accountmanage.expensemgt.vo.CustomPayableInvoiceDetailINVO;
import com.clt.apps.opus.ees.mnr.accountmanage.expensemgt.vo.GLEstimateINVO;
import com.clt.apps.opus.ees.mnr.accountmanage.expensemgt.vo.GLEstimateVO;
import com.clt.apps.opus.ees.mnr.accountmanage.expensemgt.vo.PayableInvoiceGRPVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * COM-AccountManageBusiness Logic Basic Command implementation<br>
 *
 * @author    
 * @see EesMnr0041Event,ExpenseMgtBC DAO class reference
 * @since J2EE 1.4     
 */         
        
public class ExpenseMgtBCImpl extends BasicCommandSupport implements ExpenseMgtBC {

	// Database Access Object 
	private transient ExpenseMgtDBDAO dbDao = null; 
	 	
	/** 	
	 * creating ExpenseMgtBCImpl object<br>
	 * creating ExpenseMgtDBDAO <br>
	 */    
	public ExpenseMgtBCImpl() {  
		dbDao = new ExpenseMgtDBDAO(); 
	} 
	
	/**
	 * [EES_MNR_0042] retrieving M&R Invoice Inquiry. <br>
	 *
	 * @param PayableInvoiceGRPVO payableInvoiceGRPVO
	 * @param SignOnUserAccount account
	 * @return PayableInvoiceGRPVO
	 * @exception EventException
	 */
	public PayableInvoiceGRPVO searchPayableINVInquiryListBasic(PayableInvoiceGRPVO payableInvoiceGRPVO, SignOnUserAccount account) throws EventException {
		List<CustomPayableINVInquiryListVO> customPayableINVInquiryListVO = null;  
			
		try {  
 
			payableInvoiceGRPVO.getPayableINVInquiryINVO().setUserOfcCd(account.getOfc_cd());
			payableInvoiceGRPVO.getPayableINVInquiryINVO().setCreUsrId(account.getUsr_id());
			String kind = payableInvoiceGRPVO.getPayableINVInquiryINVO().getInvSchTypeCode();
				
			if(kind.equals("WI")){
				customPayableINVInquiryListVO = dbDao.searchPayableInvoiceListByWEBData(payableInvoiceGRPVO.getPayableINVInquiryINVO()); 
			}else if(kind.equals("MI")){
				customPayableINVInquiryListVO = dbDao.searchPayableInvoiceListByWOData(payableInvoiceGRPVO.getPayableINVInquiryINVO()); 
			}else if(kind.equals("CO")){
			     if(account.getAccess_system().equals("ALP")){
			    	 customPayableINVInquiryListVO = dbDao.searchPayableInvoiceListByINVData(payableInvoiceGRPVO.getPayableINVInquiryINVO()); 
				 } else if(account.getAccess_system().equals("SPP")){
				  	 customPayableINVInquiryListVO = dbDao.searchPayableInvoiceListByINVSPPData(payableInvoiceGRPVO.getPayableINVInquiryINVO()); 
				 }				
			}
			if(customPayableINVInquiryListVO != null)
				payableInvoiceGRPVO.setCustomPayableINVInquiryListVOs(customPayableINVInquiryListVO);
			
			return payableInvoiceGRPVO;  
		} catch (DAOException ex) {   	 
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[M&R Invoice Inquiry] searchPayableINVInquiryListBasic"}).getMessage(),ex);
		} catch (Exception e) { 
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[M&R Invoice Inquiry] searchPayableINVInquiryListBasic"}).getMessage(),e);
		}  
	} 	

	/**
	 * [EES_MNR_0042] retrieving M&R Invoice Inquiry. <br>
	 *
	 * @param PayableInvoiceGRPVO payableInvoiceGRPVO
	 * @param SignOnUserAccount account
	 * @return PayableInvoiceGRPVO
	 * @exception EventException
	 */
	public PayableInvoiceGRPVO searchPayableINVInquiryDetailBasic(PayableInvoiceGRPVO payableInvoiceGRPVO, SignOnUserAccount account) throws EventException {
		List<CustomPayableInvoiceDetailINVO> customPayableInvoiceDetailINVOs = null;  

		try {  
			
			StringBuffer ordSeq = new StringBuffer();

			String kind = payableInvoiceGRPVO.getPayableINVInquiryINVO().getInvSchTypeCode();

			for ( int i=0; i<payableInvoiceGRPVO.getArrayCustomPayableINVInquiryListVOs().length; i++ ) {

				if(kind.equals("WI")){
					if(i==0){
						ordSeq.append(payableInvoiceGRPVO.getArrayCustomPayableINVInquiryListVOs()[i].getPayInvSeq());
					}else{
						ordSeq.append(",").append(payableInvoiceGRPVO.getArrayCustomPayableINVInquiryListVOs()[i].getPayInvSeq());
					}
				}else{
					if(i==0){
						ordSeq.append(payableInvoiceGRPVO.getArrayCustomPayableINVInquiryListVOs()[i].getWoNo());
					}else{
						ordSeq.append(",").append(payableInvoiceGRPVO.getArrayCustomPayableINVInquiryListVOs()[i].getWoNo());
					}
				}

			}	

			payableInvoiceGRPVO.getPayableINVInquiryINVO().setMnrOrdSeq(ordSeq.toString());
			payableInvoiceGRPVO.getPayableINVInquiryINVO().setUserOfcCd(account.getOfc_cd());

			if(kind.equals("WI")){
				customPayableInvoiceDetailINVOs = dbDao.searchInvoiceDetailListByWEBData(payableInvoiceGRPVO.getPayableINVInquiryINVO()); 
			}else if(kind.equals("MI")){
				customPayableInvoiceDetailINVOs = dbDao.searchInvoiceDetailListByWOData(payableInvoiceGRPVO.getPayableINVInquiryINVO()); 
			}else if(kind.equals("CO")){
			     if(account.getAccess_system().equals("ALP")){
					customPayableInvoiceDetailINVOs = dbDao.searchInvoiceDetailListByINVData(payableInvoiceGRPVO.getPayableINVInquiryINVO()); 
			     } else if(account.getAccess_system().equals("SPP")){
					customPayableInvoiceDetailINVOs = dbDao.searchInvoiceDetailListByINVSPPData(payableInvoiceGRPVO.getPayableINVInquiryINVO()); 
			     }
			}
			if(customPayableInvoiceDetailINVOs != null)
				payableInvoiceGRPVO.setCustomPayableInvoiceDetailINVOs(customPayableInvoiceDetailINVOs);
			
			return payableInvoiceGRPVO;  
		} catch (DAOException ex) {   	 
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[M&R Invoice Inquiry] searchPayableINVInquiryDetailBasic"}).getMessage(),ex);
		} catch (Exception e) { 
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[M&R Invoice Inquiry] searchPayableINVInquiryDetailBasic"}).getMessage(),e);
		}  
	} 	
	
	/**
	 * [EES_MNR_0041] adding/modification/deletion M&R Invoice Creation & Correction. <br>
	 *
	 * @param PayableInvoiceGRPVO payableInvoiceGRPVO
	 * @param SignOnUserAccount account
	 * @return PayableInvoiceGRPVO
	 * @exception EventException
	 */
	public PayableInvoiceGRPVO manageRepairPayableInvoiceBasic(PayableInvoiceGRPVO payableInvoiceGRPVO, SignOnUserAccount account) throws EventException {
//		List<CustomPayableInvoiceDetailINVO> customPayableInvoiceDetailINVO = null;  
		String payInvSeq = "";
		
		try {  
			if(!"S".equals(payableInvoiceGRPVO.getCustomMnrPayInvWrkVO().getMnrInpTpCd()) && !"N".equals(payableInvoiceGRPVO.getCustomMnrPayInvWrkVO().getMnrInpTpCd())){
				payableInvoiceGRPVO.getCustomMnrPayInvWrkVO().setIssOfcCd(account.getOfc_cd());
			}
			payableInvoiceGRPVO.getCustomMnrPayInvWrkVO().setCreUsrId(account.getUsr_id());
			
			String retVal = dbDao.checkPayableInvoiceData(payableInvoiceGRPVO.getCustomMnrPayInvWrkVO()); 
			
			payInvSeq = payableInvoiceGRPVO.getCustomMnrPayInvWrkVO().getPayInvSeq();

			if(retVal.equals("")){

				if(payInvSeq.equals("")){
					payInvSeq = dbDao.searchPayInvSeqData();
					payableInvoiceGRPVO.getCustomMnrPayInvWrkVO().setPayInvSeq(payInvSeq);
					
				     if(account.getAccess_system().equals("ALP")){
				    	 payableInvoiceGRPVO.getCustomMnrPayInvWrkVO().setMnrInpTpCd("M");
				     } else if(account.getAccess_system().equals("SPP")){
				    	 if(!"N".equals(payableInvoiceGRPVO.getCustomMnrPayInvWrkVO().getMnrInpTpCd())&&!"S".equals(payableInvoiceGRPVO.getCustomMnrPayInvWrkVO().getMnrInpTpCd())){
				    		 payableInvoiceGRPVO.getCustomMnrPayInvWrkVO().setMnrInpTpCd("W");
				    	 }
				     }
					
//				    payableInvoiceGRPVO.getCustomMnrPayInvWrkVO().setMnrInpTpCd("M");
				    
					payableInvoiceGRPVO.getCustomMnrPayInvWrkVO().setMnrInvRjctFlg("N");
					payableInvoiceGRPVO.getCustomMnrPayInvWrkVO().setHldFlg("N");
					
					dbDao.addPayableInvoiceData(payableInvoiceGRPVO.getCustomMnrPayInvWrkVO());	
				}else{
					dbDao.modifyPayableInvoiceData(payableInvoiceGRPVO.getCustomMnrPayInvWrkVO());
				}
			}else{
				String kind = payableInvoiceGRPVO.getPayableINVInquiryINVO().getInvSchTypeCode();
				if(kind.equals("WI")){
					dbDao.modifyPayableInvoiceData(payableInvoiceGRPVO.getCustomMnrPayInvWrkVO());
				}else{
					throw new EventException(new ErrorHandler("MNR00178",new String[]{"Invoice No:" + payableInvoiceGRPVO.getPayableINVInquiryINVO().getInvNo()}).getMessage());
				}
			}
			
		    if(account.getAccess_system().equals("SPP")){
				List<CustomPayableInvoiceDetailINVO> insertVoList = new ArrayList<CustomPayableInvoiceDetailINVO>();

				if(payableInvoiceGRPVO.getArrayCustomPayableInvoiceDetailINVOs() != null){
					CustomPayableInvoiceDetailINVO[] arrCustomPayableInvoiceDetailINVO = payableInvoiceGRPVO.getArrayCustomPayableInvoiceDetailINVOs();
					for ( int i = 0; i< arrCustomPayableInvoiceDetailINVO.length; i++ ) {  
						arrCustomPayableInvoiceDetailINVO[i].setCreUsrId(account.getUsr_id());
						arrCustomPayableInvoiceDetailINVO[i].setPayInvSeq(payInvSeq);
						arrCustomPayableInvoiceDetailINVO[i].setPayInvDtlSeq(Integer.toString(i+1));
						arrCustomPayableInvoiceDetailINVO[i].setInvNo(payableInvoiceGRPVO.getCustomMnrPayInvWrkVO().getInvNo());
						
						insertVoList.add(arrCustomPayableInvoiceDetailINVO[i]);  
					}                 
				}
			
				if ( insertVoList.size() > 0 ) {  
		
					dbDao.deleteWEBInvoiceLinkData(payableInvoiceGRPVO.getCustomMnrPayInvWrkVO());
					dbDao.addWEBInvoiceLinkData(insertVoList);

				}  
				if (payableInvoiceGRPVO.getCustomMnrPayInvWrkVO().getMnrInvStsCd().equals("SR")){
					dbDao.modifyWEBInvoiceFlagData(payableInvoiceGRPVO.getCustomMnrPayInvWrkVO());
				}
		    }
			
			
			payableInvoiceGRPVO.setCustomMnrPayInvWrkVO(payableInvoiceGRPVO.getCustomMnrPayInvWrkVO());
//			payableInvoiceGRPVO.setCustomPayableInvoiceDetailINVOs(customPayableInvoiceDetailINVO);
		} catch (EventException e){ 
		    log.error("err " + e.toString(), e);
			throw e; 
		} catch (DAOException ex) {   	 
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[M&R Invoice Creation & Correction] manageRepairPayableInvoiceBasic"}).getMessage(),ex);
		} catch (Exception e) { 
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[M&R Invoice Creation & Correction] manageRepairPayableInvoiceBasic"}).getMessage(),e);
		}  
		return payableInvoiceGRPVO; 
	} 	

	/**
	 * [EES_MNR_0041] deleting M&R Invoice Creation & Correction. <br>
	 *
	 * @param PayableInvoiceGRPVO payableInvoiceGRPVO
	 * @param SignOnUserAccount account
	 * @return PayableInvoiceGRPVO
	 * @exception EventException
	 */
	public PayableInvoiceGRPVO removePayableInvoiceBasic(PayableInvoiceGRPVO payableInvoiceGRPVO, SignOnUserAccount account) throws EventException {

		try {  
			payableInvoiceGRPVO.getPayableINVInquiryINVO().setCreUsrId(account.getUsr_id());
			
			dbDao.removePayableInvoiceData(payableInvoiceGRPVO.getPayableINVInquiryINVO());				
			
		    if(account.getAccess_system().equals("SPP")){
				dbDao.deleteWEBInvoiceLinkData(payableInvoiceGRPVO.getCustomMnrPayInvWrkVO());
		    }

		} catch (DAOException ex) {   	 
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[M&R Invoice Creation & Correction] removePayableInvoiceBasic"}).getMessage(),ex);
		} catch (Exception e) { 
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[M&R Invoice Creation & Correction] removePayableInvoiceBasic"}).getMessage(),e);
		}  
		return payableInvoiceGRPVO; 
	} 	

	/**
	 * [EES_MNR_0229] retrieving M&R Estimate expense.<br>
	 * 
	 * @param GLEstimateINVO gLEstimateINVO
	 * @param SignOnUserAccount account
	 * @return List<GLEstimateVO>
	 * @exception EventException
	 */
	public List<GLEstimateVO> searchGLEstimateIFListBasic(GLEstimateINVO gLEstimateINVO, SignOnUserAccount account) throws EventException {
		try {			
			return dbDao.searchGLEstimateIFListData(gLEstimateINVO,account);				
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[M&R Estimate expense] searchGLEstimateIFListBasic"}).getMessage(),ex);			
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[M&R Estimate expense] searchGLEstimateIFListBasic"}).getMessage(),ex);
		}		
	}		
	
	/**
	 * [EES_MNR_0229] checking M&R Estimate expense.<br>
	 * 
	 * @param GLEstimateINVO gLEstimateINVO 
	 * @param SignOnUserAccount account 
	 * @exception EventException 
	 */
	public void manageGLEstimateIFListBasic(GLEstimateINVO gLEstimateINVO,SignOnUserAccount account) throws EventException {
		try { 
			gLEstimateINVO.setUsrId(account.getUsr_id());  
			dbDao.removeGLEstimateIFData(gLEstimateINVO);     
			dbDao.addGLEstimateIFData(gLEstimateINVO);   
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[M&R Estimate expense] manageGLEstimateIFListBasic"}).getMessage(),ex);			
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[M&R Estimate expense] manageGLEstimateIFListBasic"}).getMessage(),ex);
		}		
	}		

	/**
	 * [EES_MNR_0096] saving Total Loss on Invoice <br>
	 * 
	 * @param  payableInvoiceGRPVO PayableInvoiceGRPVO
	 * @param SignOnUserAccount account 
	 * @return String[] 
	 * @exception EventException   
	 */ 
	public String[] manageTotalLossPayableInvoiceBasic(PayableInvoiceGRPVO payableInvoiceGRPVO, SignOnUserAccount account) throws EventException {
		try {  
			List<CustomMnrPayInvWrkVO> listCustomMnrPayInvWrkVOs = dbDao.searchTotalLossPayableInvoiceData(payableInvoiceGRPVO);
			
			String [] arrayPayInvSeq = new String[listCustomMnrPayInvWrkVOs.size()];
			if(listCustomMnrPayInvWrkVOs.size()>0){
				for (int i=0; i<listCustomMnrPayInvWrkVOs.size(); i++) {
					String payInvSeq = dbDao.searchPayInvSeqData();
					String validChk = dbDao.checkTraderContainerData(listCustomMnrPayInvWrkVOs.get(i).getMnrInvRmk());
					listCustomMnrPayInvWrkVOs.get(i).setPayInvSeq(payInvSeq);
					listCustomMnrPayInvWrkVOs.get(i).setUpdUsrId(account.getUsr_id());
					listCustomMnrPayInvWrkVOs.get(i).setCreUsrId(account.getUsr_id());
					if("X".equals(validChk)){
						listCustomMnrPayInvWrkVOs.get(i).setTtlLssDivCd("BBCOST");
					}else{
						listCustomMnrPayInvWrkVOs.get(i).setTtlLssDivCd("DVCOST");
					}
					dbDao.addTotalLossPayableInvoiceData(listCustomMnrPayInvWrkVOs.get(i));

					arrayPayInvSeq[i] =  payInvSeq;
					
				}
			}
			return arrayPayInvSeq;
		} catch (DAOException ex) {   	 
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Total Loss Request] manageTotalLossPayableInvoiceBasic"}).getMessage(),ex);
		} catch (Exception e) { 
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Total Loss Request] manageTotalLossPayableInvoiceBasic"}).getMessage(),e);
		}  
	}
	
	/**
	 * [EES_MNR_0096] modifying Total Loss on Invoice.<br>
	 * 
	 * @param String payInvSeq
	 * @param String invRgstNo
	 * @param SignOnUserAccount account 
	 * @exception EventException   
	 */ 
	public void modifyTotalLossPayableInvoiceBasic(String payInvSeq, String invRgstNo,SignOnUserAccount account) throws EventException {
		try {  
			
			String updUsrId = account.getUsr_id();
			dbDao.modifyTotalLossPayableInvoiceData(payInvSeq, invRgstNo, updUsrId);
		} catch (DAOException ex) {   	 
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Total Loss Request] modifyTotalLossPayableInvoiceBasic"}).getMessage(),ex);
		} catch (Exception e) { 
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Total Loss Request] modifyTotalLossPayableInvoiceBasic"}).getMessage(),e);
		}  
	}	
	
	/**
	 * [EES_MNR_0041] modifying Payable Invoice status. <br>
	 * 
	 * @param PayableInvoiceGRPVO payableInvoiceGRPVO
	 * @param SignOnUserAccount account 
	 * @exception EventException   
	 */ 
	public void modifyPayableInvoiceStatusBasic(PayableInvoiceGRPVO payableInvoiceGRPVO, SignOnUserAccount account) throws EventException {
		try {  
			
			payableInvoiceGRPVO.getPayableINVInquiryINVO().setCreUsrId(account.getUsr_id());
			dbDao.modifyPayableInvoiceStatusData(payableInvoiceGRPVO.getPayableINVInquiryINVO());
			dbDao.removeWODetailByPayINVSeqData(payableInvoiceGRPVO.getPayableINVInquiryINVO());
		} catch (DAOException ex) {   	 
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Payable Invoice Cancel] modifyPayableInvoiceStatusBasic"}).getMessage(),ex);
		} catch (Exception e) { 
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Payable Invoice Cancel] modifyPayableInvoiceStatusBasic"}).getMessage(),e);
		}  
	}

	/**
	 * [EES_MNR_0229] downloading excel M&R Estimate expense.<br>
	 * 
	 * @param
	 * @return String[]
	 * @exception
	 */	
	public String[] getColumns() {
		// defining excel column header
		String[] titleField = new String[19];
		    titleField[0] = "exe_yrmon";
			titleField[1] = "sys_src_id";
			titleField[2] = "rev_yrmon";
			titleField[3] = "acct_cd";
			titleField[4] = "biz_ut_id";
			titleField[5] = "loc_cd";
			titleField[6] = "vsl_cd";
			titleField[7] = "skd_voy_no";
			titleField[8] = "skd_dir_cd";
			titleField[9] = "rev_dir_cd";
			titleField[10] = "wo_no";
			titleField[11] = "cntr_tpsz_cd";
			titleField[12] = "cntr_qty";
			titleField[13] = "estm_amt";
			titleField[14] = "actu_amt";
			titleField[15] = "accl_amt";
			titleField[16] = "estm_vvd_tp_cd";
			titleField[17] = "estm_ioc_div_cd";
			titleField[18] = "estm_bc_div_cd";
		return titleField;
	}

	/**
	 * [EES_MNR_0229] Downloading Excel M&R Estimate expense.<br>
	 * 
	 * @param
	 * @return String[]
	 * @exception
	 */
	public String[] getTitle() {
		// defining excel column header
		String[] title = new String[19];
		title[0] = "Actual Month";
		title[1] = "SYS Name";
		title[2] = "Rev Month";
		title[3] = "ACCT Code";
		title[4] = "Biz Unit";
		title[5] = "Location";
		title[6] = "Vessel";
		title[7] = "Schedule Voyage Number";
		title[8] = "Vessel Direction Code";
		title[9] = "REV VVD";
		title[10] = "W/O No";
		title[11] = "TS";
		title[12] = "QTY";
		title[13] = "Estimated Cost";
		title[14] = "Actual Cost";
		title[15] = "Accural Cost";
		title[16] = "estm_vvd_tp_cd";
		title[17] = "estm_ioc_div_cd";
		title[18] = "estm_bc_div_cd";
		return title;
	}
}