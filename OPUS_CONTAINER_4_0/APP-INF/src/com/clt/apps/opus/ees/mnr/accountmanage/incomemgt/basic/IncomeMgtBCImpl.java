/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : IncomeMgtBCImpl.java
*@FileTitle : IncomeMgtBCImpl
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.mnr.accountmanage.incomemgt.basic;

import java.util.List;

import com.clt.apps.opus.ees.mnr.accountmanage.incomemgt.integration.IncomeMgtDBDAO;
import com.clt.apps.opus.ees.mnr.accountmanage.incomemgt.vo.CustomReceivableINVInquiryListVO;
import com.clt.apps.opus.ees.mnr.accountmanage.incomemgt.vo.CustomReceivableInvoiceDetailINVO;
import com.clt.apps.opus.ees.mnr.accountmanage.incomemgt.vo.ReceivableInvoiceGRPVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * COM-AccountManageBusiness Logic Basic Command implementation<br>
 *
 * @author    
 * @see EesMnr0161Event,IncomeMgtBC DAO class reference
 * @since J2EE 1.4     
 */         
      
public class IncomeMgtBCImpl extends BasicCommandSupport implements IncomeMgtBC {

	// Database Access Object 
	private transient IncomeMgtDBDAO dbDao = null; 
	 	
	/** 	
	 * creating IncomeMgtBCImpl object<br>
	 * creating IncomeMgtDBDAO.<br>
	 */    
	public IncomeMgtBCImpl() {  
		dbDao = new IncomeMgtDBDAO(); 
	} 
	
	/**
	 * retrieving [EES_MNR_0161 ] <br>
	 *
	 * @param ReceivableInvoiceGRPVO receivableInvoiceGRPVO
	 * @param SignOnUserAccount account
	 * @return ReceivableInvoiceGRPVO
	 * @exception EventException
	 */ 
	public ReceivableInvoiceGRPVO searchReceivableInvoiceListBasic(ReceivableInvoiceGRPVO receivableInvoiceGRPVO, SignOnUserAccount account) throws EventException {
		List<CustomReceivableINVInquiryListVO> customReceivableINVInquiryListVO = null;  
			
		try {  
 
			receivableInvoiceGRPVO.getReceivableINVInquiryINVO().setUserOfcCd(account.getOfc_cd());
			receivableInvoiceGRPVO.getReceivableINVInquiryINVO().setCreUsrId(account.getUsr_id());
			String kind = receivableInvoiceGRPVO.getReceivableINVInquiryINVO().getInvSchTypeCode();
			
			if(kind.equals("MI")){
				customReceivableINVInquiryListVO = dbDao.searchReceivableInvoiceListByDisposalData(receivableInvoiceGRPVO.getReceivableINVInquiryINVO()); 
			}else if(kind.equals("CO")){
				customReceivableINVInquiryListVO = dbDao.searchReceivableInvoiceListByINVData(receivableInvoiceGRPVO.getReceivableINVInquiryINVO()); 
			}
			
			if(customReceivableINVInquiryListVO != null)
				receivableInvoiceGRPVO.setCustomReceivableINVInquiryListVOs(customReceivableINVInquiryListVO);
			
			return receivableInvoiceGRPVO;  
		} catch (DAOException ex) {   	 
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Receivable Invoice List] searchReceivableInvoiceListBasic"}).getMessage(),ex);
		} catch (Exception e) { 
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Receivable Invoice List] searchReceivableInvoiceListBasic"}).getMessage(),e);
		}  
	} 	

	/**
	 * [EES_MNR_0161]retrieving Disposal Invoice Issue. <br>
	 *
	 * @param ReceivableInvoiceGRPVO receivableInvoiceGRPVO
	 * @return ReceivableInvoiceGRPVO
	 * @exception EventException
	 */
	public ReceivableInvoiceGRPVO searchReceivableInvoiceDetailListBasic(ReceivableInvoiceGRPVO receivableInvoiceGRPVO) throws EventException {
		List<CustomReceivableInvoiceDetailINVO> customReceivableInvoiceDetailINVOs = null;  

		try {  
			
			StringBuffer ordSeq = new StringBuffer();

			String kind = receivableInvoiceGRPVO.getReceivableINVInquiryINVO().getInvSchTypeCode();

			for ( int i=0; i<receivableInvoiceGRPVO.getArrayCustomReceivableINVInquiryListVOs().length; i++ ) {

				if(kind.equals("MI")){
					if(i==0){
						ordSeq.append(receivableInvoiceGRPVO.getArrayCustomReceivableINVInquiryListVOs()[i].getDispNo());
					}else{
						ordSeq.append(",").append(receivableInvoiceGRPVO.getArrayCustomReceivableINVInquiryListVOs()[i].getDispNo());
					}
				}else{
					if(i==0){
						ordSeq.append(receivableInvoiceGRPVO.getArrayCustomReceivableINVInquiryListVOs()[i].getInvNo());
					}else{
						ordSeq.append(",").append(receivableInvoiceGRPVO.getArrayCustomReceivableINVInquiryListVOs()[i].getInvNo());
					}
				}

			}	

			receivableInvoiceGRPVO.getReceivableINVInquiryINVO().setMnrOrdSeq(ordSeq.toString());


			if(kind.equals("MI")){
				customReceivableInvoiceDetailINVOs = dbDao.searchReceivableInvoiceDetailListByDisposalData(receivableInvoiceGRPVO.getReceivableINVInquiryINVO()); 
			}else if(kind.equals("CO")){
				customReceivableInvoiceDetailINVOs = dbDao.searchReceivableInvoiceDetailListINVData(receivableInvoiceGRPVO.getReceivableINVInquiryINVO()); 
			}
	
			if(customReceivableInvoiceDetailINVOs != null)
				receivableInvoiceGRPVO.setCustomReceivableInvoiceDetailINVOs(customReceivableInvoiceDetailINVOs);
			
			return receivableInvoiceGRPVO;  
		} catch (DAOException ex) {   	 
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal Invoice Issue] searchReceivableInvoiceDetailListBasic"}).getMessage(),ex);
		} catch (Exception e) { 
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal Invoice Issue] searchReceivableInvoiceDetailListBasic"}).getMessage(),e);
		}  
	} 	
	
	/**
	 * [EES_MNR_0161]adding/modification/deletion Disposal Invoice Issue. <br>
	 *
	 * @param ReceivableInvoiceGRPVO receivableInvoiceGRPVO
	 * @param SignOnUserAccount account
	 * @return ReceivableInvoiceGRPVO
	 * @exception EventException
	 */
	public ReceivableInvoiceGRPVO manageRepairReceivableInvoiceBasic(ReceivableInvoiceGRPVO receivableInvoiceGRPVO, SignOnUserAccount account) throws EventException {
		String rcvInvSeq = "";
		String invNo = "";
		
		try {  
			if(account.getOfc_cd().equalsIgnoreCase("JKTBA")){			
				receivableInvoiceGRPVO.getReceivableINVInquiryINVO().setUserOfcCd("JKTBB");	
			} else {
				receivableInvoiceGRPVO.getReceivableINVInquiryINVO().setUserOfcCd(account.getOfc_cd());
			}																	
			receivableInvoiceGRPVO.getReceivableINVInquiryINVO().setCreUsrId(account.getUsr_id());
					
			if(receivableInvoiceGRPVO.getReceivableINVInquiryINVO().getInputInvNo().equals("")){
				rcvInvSeq = dbDao.searchReceivableInvSeqData();
				//invNo.append(account.getOfc_cd()).append("-").append((new SimpleDateFormat("yyyyMM")).format(new Date())).append("-").append(rcvInvSeq);
				invNo = dbDao.searchReceivableInvoiceNoData(receivableInvoiceGRPVO.getReceivableINVInquiryINVO());
				
				receivableInvoiceGRPVO.getReceivableINVInquiryINVO().setInputInvNo(invNo);
			}else{
				rcvInvSeq = receivableInvoiceGRPVO.getReceivableINVInquiryINVO().getRcvInvSeq();
			}
			
			String retVal = dbDao.checkReceivableInvoiceData(receivableInvoiceGRPVO.getReceivableINVInquiryINVO()); 
			
			if(retVal.equals("")){
				if(receivableInvoiceGRPVO.getReceivableINVInquiryINVO().getRcvInvSeq().equals("")){
					receivableInvoiceGRPVO.getReceivableINVInquiryINVO().setRcvInvSeq(rcvInvSeq);
					dbDao.addReceivableInvoiceData(receivableInvoiceGRPVO.getReceivableINVInquiryINVO());	
				}else{
					dbDao.modifyReceivableInvoiceData(receivableInvoiceGRPVO.getReceivableINVInquiryINVO());
				}
			}else{
				throw new EventException(new ErrorHandler("MNR00178",new String[]{"Invoice No:" + receivableInvoiceGRPVO.getReceivableINVInquiryINVO().getInvNo()}).getMessage());
			}	
				
			receivableInvoiceGRPVO.setReceivableINVInquiryINVO(receivableInvoiceGRPVO.getReceivableINVInquiryINVO());
 
		} catch (EventException e){  
		    log.error("err " + e.toString(), e);
			throw e; 
		} catch (DAOException ex) {   	 
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal Invoice Issue] manageRepairReceivableInvoiceBasic"}).getMessage(),ex);
		} catch (Exception e) { 
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal Invoice Issue] manageRepairReceivableInvoiceBasic"}).getMessage(),e);
		}  
		return receivableInvoiceGRPVO; 
	} 	
	
	/**
	 * [EES_MNR_0161]deleting Disposal Invoice Issue. <br>
	 *
	 * @param ReceivableInvoiceGRPVO receivableInvoiceGRPVO
	 * @param SignOnUserAccount account
	 * @return ReceivableInvoiceGRPVO
	 * @exception EventException
	 */
	public ReceivableInvoiceGRPVO removeReceivableInvoiceBasic(ReceivableInvoiceGRPVO receivableInvoiceGRPVO, SignOnUserAccount account) throws EventException {

		try {  
			dbDao.removeReceivableInvoiceData(receivableInvoiceGRPVO.getReceivableINVInquiryINVO());				
		} catch (DAOException ex) {   	 
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal Invoice Issue] removeReceivableInvoiceBasic"}).getMessage(),ex);
		} catch (Exception e) { 
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal Invoice Issue] removeReceivableInvoiceBasic"}).getMessage(),e);
		}  
		return receivableInvoiceGRPVO; 
	} 	
	

	/**
	 * [EES_MNR_0161]modifying Disposal Invoice Issue. <br>
	 * 
	 * @param ReceivableInvoiceGRPVO receivableInvoiceGRPVO
	 * @param SignOnUserAccount account 
	 * @exception EventException   
	 */ 
	public void modifyReceivableInvoiceStatusBasic(ReceivableInvoiceGRPVO receivableInvoiceGRPVO,SignOnUserAccount account) throws EventException {
		try {  
			receivableInvoiceGRPVO.getReceivableINVInquiryINVO().setCreUsrId(account.getUsr_id());
			dbDao.modifyReceivableInvoiceStatusData(receivableInvoiceGRPVO.getReceivableINVInquiryINVO());
		} catch (DAOException ex) {   	 
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal Invoice Request] modifyReceivableInvoiceStatusBasic"}).getMessage(),ex);
		} catch (Exception e) { 
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal Invoice Request] modifyReceivableInvoiceStatusBasic"}).getMessage(),e);
		}  
	}	
	
}