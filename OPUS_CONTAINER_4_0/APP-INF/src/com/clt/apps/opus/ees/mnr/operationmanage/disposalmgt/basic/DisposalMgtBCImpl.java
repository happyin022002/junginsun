/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DisposalMgtBCImpl.java
*@FileTitle : Disposal
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.mnr.operationmanage.disposalmgt.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.vo.EmailSendInfoVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.vo.GeneralMailFormVO;
import com.clt.apps.opus.ees.mnr.operationmanage.disposalmgt.integration.DisposalMgtDBDAO;
import com.clt.apps.opus.ees.mnr.operationmanage.disposalmgt.vo.CustomBkgOtsDtlVO;
import com.clt.apps.opus.ees.mnr.operationmanage.disposalmgt.vo.CustomDispInvDtIVO;
import com.clt.apps.opus.ees.mnr.operationmanage.disposalmgt.vo.CustomMnrDispBuyerPartVO;
import com.clt.apps.opus.ees.mnr.operationmanage.disposalmgt.vo.CustomMnrDispBuyrDtlPartVO;
import com.clt.apps.opus.ees.mnr.operationmanage.disposalmgt.vo.CustomMnrDispDtlVO;
import com.clt.apps.opus.ees.mnr.operationmanage.disposalmgt.vo.CustomMnrDispHdrVO;
import com.clt.apps.opus.ees.mnr.operationmanage.disposalmgt.vo.CustomMnrRcvInvWrkVO;
import com.clt.apps.opus.ees.mnr.operationmanage.disposalmgt.vo.CustomMyBiddingDtlVO;
import com.clt.apps.opus.ees.mnr.operationmanage.disposalmgt.vo.CustomMyBiddingHdrVO;
import com.clt.apps.opus.ees.mnr.operationmanage.disposalmgt.vo.DisposalGRPVO;
import com.clt.apps.opus.ees.mnr.operationmanage.disposalmgt.vo.DisposalInquiryGRPVO;
import com.clt.apps.opus.ees.mnr.operationmanage.disposalmgt.vo.DisposalInquiryINVO;
import com.clt.apps.opus.ees.mnr.operationmanage.disposalmgt.vo.DisposalSoldGRPVO;
import com.clt.apps.opus.ees.mnr.operationmanage.disposalmgt.vo.MyBiddingGRPVO;
import com.clt.apps.opus.ees.mnr.operationmanage.disposalmgt.vo.MyBiddingINVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * COM-OperationManage Business Logic Basic Command implementation<br>
 * - COM-OperationManage interface of business logic<br>
 *
 * @author
 * @see EES_MNR_0139EventResponse, EES_MNR_0122HTMLAction, EQFlagMgtBC, DAO Class
 * @since J2EE 1.4
 */
public class DisposalMgtBCImpl extends BasicCommandSupport implements DisposalMgtBC {
	
	// Database Access Object
	private transient DisposalMgtDBDAO dbDao = null; 	
	
	/**
	 * DisposalMgtBCImpl Creating object<br>
	 * DisposalMgtDBDAO creating object<br>
	 */
	public DisposalMgtBCImpl() {
		dbDao = new DisposalMgtDBDAO(); 
	}

	/**
	 * [EES_MNR_0164]Retrieving "Disposal Request" data<br>
	 *
	 * @param DisposalGRPVO disposalGRPVO
	 * @param SignOnUserAccount account 
	 * @return DisposalGRPVO
	 * @exception EventException
	 */
	public DisposalGRPVO searchDisposalListBasic(DisposalGRPVO disposalGRPVO,SignOnUserAccount account) throws EventException {
		try {    
				List<CustomMnrDispHdrVO> customMnrDispHdrVOS = new ArrayList<CustomMnrDispHdrVO>();  
				customMnrDispHdrVOS = dbDao.searchDisposalListData(disposalGRPVO.getDisposalNVO(),account); 
				 
				disposalGRPVO.setCustomMnrDispHdrVOS(customMnrDispHdrVOS); 
				return disposalGRPVO; 
		} catch (DAOException ex) {            
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal Request] searchDisposalListBasic"}).getMessage(),ex); 
		} catch (Exception ex) {            
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal Request] searchDisposalListBasic"}).getMessage(),ex); 
		} 
	} 
	 
	/**
	 * [EES_MNR_0093]Retrieving "Scraping/Donation Creation" data<br>
	 *
	 * @param DisposalGRPVO disposalGRPVO
	 * @return DisposalGRPVO
	 * @exception EventException
	 */
	public DisposalGRPVO searchDSPBuyerDTLPartBasic(DisposalGRPVO disposalGRPVO) throws EventException {
		try {     
			List<CustomMnrDispBuyrDtlPartVO> customMnrDispBuyrDtlPartVOS = new ArrayList<CustomMnrDispBuyrDtlPartVO>(); 
			customMnrDispBuyrDtlPartVOS = dbDao.searchDSPBuyerDTLPartData(disposalGRPVO.getCustomMnrDispHdrVO());
				
			disposalGRPVO.setCustomMnrDispBuyrDtlPartVOS(customMnrDispBuyrDtlPartVOS); 
			return disposalGRPVO; 
		} catch (DAOException ex) {            
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal Request] searchDSPBuyerDTLPartBasic"}).getMessage(),ex); 
		} catch (Exception ex) {            
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal Request] searchDSPBuyerDTLPartBasic"}).getMessage(),ex); 
		} 
	} 
		
	/**
	 * [EES_MNR_0159]Retrieving "Disposal Request" data<br>
	 *
	 * @param DisposalGRPVO disposalGRPVO
	 * @return DisposalGRPVO
	 * @exception EventException
	 */
	public DisposalGRPVO searchDisposalMailListBasic(DisposalGRPVO disposalGRPVO) throws EventException {
		try {    
			CustomMnrDispHdrVO customMnrDispHdrVO = disposalGRPVO.getCustomMnrDispHdrVO();
			List<EmailSendInfoVO> emailSendInfoVOS = new ArrayList<EmailSendInfoVO>(); 
			List<CustomMnrDispDtlVO> eqCustomMnrDispDtlVOS = null;
			List<CustomMnrDispDtlVO> qtycustomMnrDispDtlVOS = null;
			//Retrieving e-mail recipient
			emailSendInfoVOS = dbDao.searchDisposalMailListData(customMnrDispHdrVO);
			
			//Creating e-mail content
			StringBuilder argument = new StringBuilder("");	
			String mailSubject = "";
			String saleType = "";
			String eqNoOrQty = "";
			String yardOrLoc = "";
			StringBuilder vCntrItems = new StringBuilder("");
			
			//Retrieving DTL list
			customMnrDispHdrVO.setDispUtTpCd("E"); 
			eqCustomMnrDispDtlVOS = dbDao.searchDisposalDTLListData(customMnrDispHdrVO); 
			customMnrDispHdrVO.setDispUtTpCd("Q");
			qtycustomMnrDispDtlVOS = dbDao.searchDisposalDTLListData(customMnrDispHdrVO);	
			if(eqCustomMnrDispDtlVOS.size() > 0){
				saleType = "Unit";
				eqNoOrQty = "EQ No";
				yardOrLoc = "Yard";
			} else {
				saleType = "Bulk";		
				eqNoOrQty = "Qty";		
				yardOrLoc = "Location";		
			}
			
			if(emailSendInfoVOS.size() > 0){
				mailSubject = emailSendInfoVOS.get(0).getSubject();
			}
			argument.append("subject").append(";").append(mailSubject).append(",");
			argument.append("bid_status").append(";").append(disposalGRPVO.getNoticeMailType()).append(",");
			argument.append("sale_type").append(";").append(saleType).append(" Sale,");
			argument.append("curr").append(";").append(customMnrDispHdrVO.getCurrCd()).append(",");
			argument.append("start_dt").append(";").append(customMnrDispHdrVO.getDispStDt()).append(",");
			argument.append("end_dt").append(";").append(customMnrDispHdrVO.getDispEndDt()).append(",");
			argument.append("eqNoOrQty").append(";").append(eqNoOrQty).append(",");			
			argument.append("yardOrLoc").append(";").append(yardOrLoc).append(",");			
			
			//Unit Detail
			if(eqCustomMnrDispDtlVOS.size() > 0){	
				for (int i = 0; i < eqCustomMnrDispDtlVOS.size(); i++) {
					vCntrItems.append("<tr align=\'center\'><td>").append(eqCustomMnrDispDtlVOS.get(i).getEqNo()).append("</td>");
					vCntrItems.append("<td>").append(eqCustomMnrDispDtlVOS.get(i).getEqTpszDesc()).append("</td>");
					vCntrItems.append("<td>").append(eqCustomMnrDispDtlVOS.get(i).getDispUtPrc()).append("</td>");				
					vCntrItems.append("<td>").append(eqCustomMnrDispDtlVOS.get(i).getDispYdCd()).append("</td></tr>");				
				}						
			//Bulk Detail	
			} else {												
				for (int i = 0; i < qtycustomMnrDispDtlVOS.size(); i++) {	
					vCntrItems.append("<tr align=\'center\'><td>").append(qtycustomMnrDispDtlVOS.get(i).getDispQty()).append("</td>");
					vCntrItems.append("<td>").append(qtycustomMnrDispDtlVOS.get(i).getEqTpszDesc()).append("</td>");	
					vCntrItems.append("<td>").append(qtycustomMnrDispDtlVOS.get(i).getDispUtPrc()).append("</td>");							
					vCntrItems.append("<td>").append(qtycustomMnrDispDtlVOS.get(i).getDispYdCd()).append("</td></tr>");	
				}										
			}								
			//Detail List
			argument.append("detail_list").append(";").append(vCntrItems.toString());
				
			for (int i = 0; i < emailSendInfoVOS.size(); i++) {
				///OPUS_CNTR/APP-INF/config/template/mailtemplate/EES_MNR_DISPOSAL_01T.html
				emailSendInfoVOS.get(i).setTemplate("EES_MNR_DISPOSAL_01T.html");	
				emailSendInfoVOS.get(i).setArgument(argument.toString());		
			}												
			
			disposalGRPVO.setEmailSendInfoVOS(emailSendInfoVOS);   
			return disposalGRPVO;	 	 	
		} catch (DAOException ex) {             
			throw new EventException(new ErrorHandler(ex).getMessage()); 
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal Request] searchDisposalMailListBasic"}).getMessage(),de);
		} 
	} 	
	
	/**
	 * [EES_MNR_0159]Retrieving "Disposal Management" data<br>
	 *
	 * @param DisposalGRPVO disposalGRPVO
	 * @return DisposalGRPVO
	 * @exception EventException
	 */
	public DisposalGRPVO searchDSPConfirmMailListBasic(DisposalGRPVO disposalGRPVO) throws EventException {
		try {     
			List<GeneralMailFormVO> generalMailFormVOS = new ArrayList<GeneralMailFormVO>(); 
			generalMailFormVOS = dbDao.searchDSPConfirmMailListData(disposalGRPVO.getCustomMnrDispHdrVO());
			disposalGRPVO.setGeneralMailFormVOS(generalMailFormVOS);   
			return disposalGRPVO;   
		} catch (DAOException ex) {             
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal Management] searchDSPConfirmMailListBasic"}).getMessage(),ex); 
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal Management] searchDSPConfirmMailListBasic"}).getMessage(),de);
		} 
	} 	
	
	/**
	 * [EES_MNR_0200]Retrieving "Disposal Request" data<br>
	 *
	 * @param DisposalGRPVO disposalGRPVO
	 * @return DisposalGRPVO
	 * @exception EventException
	 */
	public DisposalGRPVO searchDisposalBasic(DisposalGRPVO disposalGRPVO) throws EventException {
		try {    
			CustomMnrDispHdrVO customMnrDispHdrVO = disposalGRPVO.getCustomMnrDispHdrVO();
			
			List<CustomMnrDispBuyerPartVO> customMnrDispBuyerPartVOS = null;
			List<CustomMnrDispDtlVO> eqCustomMnrDispDtlVOS = null;
			List<CustomMnrDispDtlVO> qtycustomMnrDispDtlVOS = null;
			   
			//Retrieving "Buyer Selection" 
			customMnrDispBuyerPartVOS = dbDao.searchDisposalBuyerHeaderData(customMnrDispHdrVO); 
				
			//Retrieving DTL data 
			customMnrDispHdrVO.setDispUtTpCd("E"); 
			eqCustomMnrDispDtlVOS = dbDao.searchDisposalDTLListData(customMnrDispHdrVO); 
			customMnrDispHdrVO.setDispUtTpCd("Q");
			qtycustomMnrDispDtlVOS = dbDao.searchDisposalDTLListData(customMnrDispHdrVO);  	
				
			disposalGRPVO.setCustomMnrDispBuyerPartVOS(customMnrDispBuyerPartVOS);
			disposalGRPVO.setEqCustomMnrDispDtlVOS(eqCustomMnrDispDtlVOS);
			disposalGRPVO.setQtyCustomMnrDispDtlVOS(qtycustomMnrDispDtlVOS);
			return disposalGRPVO; 
		} catch (DAOException ex) {            
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal Request] searchDisposalBasic"}).getMessage(),ex); 
		} catch (Exception ex) {            
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal Request] searchDisposalBasic"}).getMessage(),ex); 
		} 
	} 
	
	/**
	 * [EES_MNR_0159]Modifying "Disposal Management" data<br>
	 *
	 * @param DisposalGRPVO disposalGRPVO
	 * @param SignOnUserAccount account
	 * @return DisposalGRPVO
	 * @exception EventException
	 */
	public DisposalGRPVO reBiddingDisposalBasic(DisposalGRPVO disposalGRPVO, SignOnUserAccount account) throws EventException{
		try {		
			CustomMnrDispHdrVO customMnrDispHdrVO = disposalGRPVO.getCustomMnrDispHdrVO();
			
			CustomMnrDispDtlVO[] arrCustomMnrDispDtlVOS = disposalGRPVO.getArrCustomMnrDispDtlVOS(); 
			CustomMnrDispBuyerPartVO[] arrCustomMnrDispBuyerPartVOS = disposalGRPVO.getArrCustomMnrDispBuyerPartVOS(); 
			
			//Setting user information	 	
			customMnrDispHdrVO.setCreUsrId(account.getUsr_id());
			customMnrDispHdrVO.setUpdUsrId(account.getUsr_id());
			
			//Deleting existing "header data"    	
			dbDao.removeDisposalHRDData(customMnrDispHdrVO);
			//Deleting existing "detail data"  
			dbDao.removeDisposalDTLData(customMnrDispHdrVO);
			//Deleting existing "buyer data"   
			dbDao.removeDisposalBuyerHRDData(customMnrDispHdrVO);
			//Deleting existing "mnr_disp_buyr_dtl_part"   
			dbDao.removeDisposalBuyerDTLData(customMnrDispHdrVO);
			
			//Inserting header data 
			dbDao.addDisposalHRDData(customMnrDispHdrVO);   
				
			//Inserting detail data 
			if(arrCustomMnrDispDtlVOS != null){ 
				List<CustomMnrDispDtlVO> insertVoList = new ArrayList<CustomMnrDispDtlVO>();
				for ( int i = 0; i < arrCustomMnrDispDtlVOS.length; i++ ) {      
					arrCustomMnrDispDtlVOS[i].setCreUsrId(account.getUsr_id());
					arrCustomMnrDispDtlVOS[i].setUpdUsrId(account.getUsr_id());
					arrCustomMnrDispDtlVOS[i].setDispDtlSeq(i + 1 + "");  
					arrCustomMnrDispDtlVOS[i].setDispNo(customMnrDispHdrVO.getDispNo()); 
					insertVoList.add(arrCustomMnrDispDtlVOS[i]);   
				}   		 
				if ( insertVoList.size() > 0 ) {	
					dbDao.addDisposalDTLData(insertVoList); 
				}  	
				
			}
			
			//Modifying header data after detail data sum 
			dbDao.modifyDisposalHDRSumData(customMnrDispHdrVO); 
				
			//Inserting detail buyer data
			if(arrCustomMnrDispBuyerPartVOS != null){ 
				List<CustomMnrDispBuyerPartVO> insertVoList = new ArrayList<CustomMnrDispBuyerPartVO>();
				for ( int i = 0; i < arrCustomMnrDispBuyerPartVOS.length; i++ ) {       
					arrCustomMnrDispBuyerPartVOS[i].setCreUsrId(account.getUsr_id());  
					arrCustomMnrDispBuyerPartVOS[i].setUpdUsrId(account.getUsr_id());  
					arrCustomMnrDispBuyerPartVOS[i].setDispNo(customMnrDispHdrVO.getDispNo()); 
					arrCustomMnrDispBuyerPartVOS[i].setOfcCd(account.getOfc_cd()); 
					arrCustomMnrDispBuyerPartVOS[i].setMnrPrnrEml(customMnrDispHdrVO.getDispEmlFlg());
					insertVoList.add(arrCustomMnrDispBuyerPartVOS[i]);  
				} 	       		 
				if ( insertVoList.size() > 0 ) {		
					dbDao.addDisposalBuyerHeaderData(insertVoList);
				}  	 	
			}	
			
			return disposalGRPVO;	
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal Management] reBiddingDisposalBasic"}).getMessage(),de);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal Management] reBiddingDisposalBasic"}).getMessage(),de);
		} 
	}  
	
	/**
	 * [EES_MNR_0159]Modifying "Disposal Management" data<br>
	 *
	 * @param DisposalGRPVO disposalGRPVO
	 * @param SignOnUserAccount account
	 * @return DisposalGRPVO
	 * @exception EventException
	 */
	public DisposalGRPVO confirmDisposalBasic(DisposalGRPVO disposalGRPVO, SignOnUserAccount account) throws EventException{
		try {	
			CustomMnrDispHdrVO customMnrDispHdrVO = disposalGRPVO.getCustomMnrDispHdrVO();
			CustomMnrDispBuyerPartVO[] arrCustomMnrDispBuyerPartVOS = disposalGRPVO.getArrCustomMnrDispBuyerPartVOS(); 
			CustomMnrDispDtlVO[] arrCustomMnrDispDtlVOS = disposalGRPVO.getArrCustomMnrDispDtlVOS(); 
			CustomMnrDispBuyrDtlPartVO[] arrCustomMnrDispBuyrDtlPartVOS = disposalGRPVO.getArrCustomMnrDispBuyrDtlPartVOS(); 

			CustomMnrDispBuyrDtlPartVO[] arrCustomMnrDispBuyrDtlPartVOS2 = new CustomMnrDispBuyrDtlPartVO[arrCustomMnrDispBuyrDtlPartVOS.length];
			for(int i = 0;i < arrCustomMnrDispBuyrDtlPartVOS.length;i ++){ 
				arrCustomMnrDispBuyrDtlPartVOS2[i] = (CustomMnrDispBuyrDtlPartVO)arrCustomMnrDispBuyrDtlPartVOS[i].clone(); 
			} 

			customMnrDispHdrVO.setCreUsrId(account.getUsr_id());
			customMnrDispHdrVO.setUpdUsrId(account.getUsr_id());

			//Deleting existing header data
			dbDao.removeDisposalHRDData(customMnrDispHdrVO);
			//Deleting existing detail data
			dbDao.removeDisposalDTLData(customMnrDispHdrVO);
			//Deleting existing buyer data
			dbDao.removeDisposalBuyerHRDData(customMnrDispHdrVO);
			//Deleting existing mnr_disp_buyr_dtl_part data   
			dbDao.removeDisposalBuyerDTLData(customMnrDispHdrVO);
			//Inserting header data 
			dbDao.addDisposalHRDData(customMnrDispHdrVO);   
			List<CustomMnrDispDtlVO> customMnrDispDtlVOS = new ArrayList<CustomMnrDispDtlVO>();
			List<CustomMnrDispBuyrDtlPartVO> customMnrDispBuyrDtlPartVOS = new ArrayList<CustomMnrDispBuyrDtlPartVO>();
				
			//Inserting new detail data 
			if(arrCustomMnrDispDtlVOS != null){  
				for ( int i = 0; i < arrCustomMnrDispDtlVOS.length; i++ ) {      
					arrCustomMnrDispDtlVOS[i].setCreUsrId(account.getUsr_id());
					arrCustomMnrDispDtlVOS[i].setUpdUsrId(account.getUsr_id());
					arrCustomMnrDispDtlVOS[i].setDispNo(customMnrDispHdrVO.getDispNo());  
						
					for ( int x = 0; x < arrCustomMnrDispBuyrDtlPartVOS.length; x++ ){ 
						if(arrCustomMnrDispDtlVOS[i].getDispDtlSeq().equals(arrCustomMnrDispBuyrDtlPartVOS[x].getDispDtlSeq())){
							if(arrCustomMnrDispBuyrDtlPartVOS[x].getMnrDispCfmStsCd().equals("1")){
								//Setting DTL data        
								CustomMnrDispDtlVO customMnrDispDtlVO = (CustomMnrDispDtlVO)arrCustomMnrDispDtlVOS[i].clone();  
								customMnrDispDtlVO.setDispQty(arrCustomMnrDispBuyrDtlPartVOS[x].getDispCfmQty());
								customMnrDispDtlVO.setDispDtlSeq(customMnrDispDtlVOS.size() + 1 + "");  
								customMnrDispDtlVO.setMnrPrnrCntCd(arrCustomMnrDispBuyrDtlPartVOS[x].getMnrPrnrCntCd());
								customMnrDispDtlVO.setMnrPrnrSeq(arrCustomMnrDispBuyrDtlPartVOS[x].getMnrPrnrSeq()); 
									
								//Setting BUYR DTL data 
								CustomMnrDispBuyrDtlPartVO customMnrDispBuyrDtlPartVO = (CustomMnrDispBuyrDtlPartVO)arrCustomMnrDispBuyrDtlPartVOS[x].clone();  
								customMnrDispBuyrDtlPartVO.setDispDtlSeq(customMnrDispDtlVOS.size() + 1 + "");
								customMnrDispBuyrDtlPartVOS.add(customMnrDispBuyrDtlPartVO);       
									
								for ( int y = 0; y < arrCustomMnrDispBuyrDtlPartVOS2.length; y++ ) {        
									if(arrCustomMnrDispDtlVOS[i].getDispDtlSeq().equals(arrCustomMnrDispBuyrDtlPartVOS2[y].getDispDtlSeq())){
										if(y != x && arrCustomMnrDispBuyrDtlPartVOS2[y].getMnrDispCfmStsCd().equals("0")){      
											CustomMnrDispBuyrDtlPartVO customMnrDispBuyrDtlPartVO2 = (CustomMnrDispBuyrDtlPartVO)arrCustomMnrDispBuyrDtlPartVOS2[y].clone();  
											customMnrDispBuyrDtlPartVO2.setDispCfmQty("0");   
											customMnrDispBuyrDtlPartVO2.setDispDtlSeq(customMnrDispDtlVOS.size() + 1 + "");
											customMnrDispBuyrDtlPartVO2.setDispQty(arrCustomMnrDispBuyrDtlPartVOS[x].getDispCfmQty()); 
											customMnrDispBuyrDtlPartVOS.add(customMnrDispBuyrDtlPartVO2);     
										}	 	    	      					 
									}					
								}	 			
								customMnrDispDtlVOS.add(customMnrDispDtlVO);       
								arrCustomMnrDispBuyrDtlPartVOS[x].setMnrDispCfmStsCd("0");     
							}				
						}			
					} 	 	       
				}   		 
				
				if ( customMnrDispDtlVOS.size() > 0 ) {	
					dbDao.addDisposalDTLData(customMnrDispDtlVOS); 
				}   	
				
			} 

			//Inserting buyer data   
			if(arrCustomMnrDispBuyerPartVOS != null){ 
				List<CustomMnrDispBuyerPartVO> insertVoList = new ArrayList<CustomMnrDispBuyerPartVO>();
				for ( int i = 0; i < arrCustomMnrDispBuyerPartVOS.length; i++ ) {       
					arrCustomMnrDispBuyerPartVOS[i].setCreUsrId(account.getUsr_id());  
					arrCustomMnrDispBuyerPartVOS[i].setUpdUsrId(account.getUsr_id());  
					arrCustomMnrDispBuyerPartVOS[i].setDispNo(customMnrDispHdrVO.getDispNo()); 
					arrCustomMnrDispBuyerPartVOS[i].setOfcCd(account.getOfc_cd()); 
					arrCustomMnrDispBuyerPartVOS[i].setMnrPrnrEml(customMnrDispHdrVO.getDispEmlFlg());
					insertVoList.add(arrCustomMnrDispBuyerPartVOS[i]);  
				}	       		 
				if ( insertVoList.size() > 0 ) {		
					dbDao.addDisposalBuyerHeaderData(insertVoList);
				}   	 	
			}
			
			//Inserting detail buyer data 
			if(customMnrDispBuyrDtlPartVOS != null){  
				for ( int i = 0; i < customMnrDispBuyrDtlPartVOS.size(); i++ ) {       
					customMnrDispBuyrDtlPartVOS.get(i).setCreUsrId(account.getUsr_id());  
					customMnrDispBuyrDtlPartVOS.get(i).setUpdUsrId(account.getUsr_id());  
					customMnrDispBuyrDtlPartVOS.get(i).setMnrDispCfmUsrId(account.getUsr_id());     
					customMnrDispBuyrDtlPartVOS.get(i).setDispNo(customMnrDispHdrVO.getDispNo()); 
				}	
				
				if ( customMnrDispBuyrDtlPartVOS.size() > 0 ) {		
					dbDao.addDisposalBuyerDetailData(customMnrDispBuyrDtlPartVOS);
				}	  	 	
			}
			return disposalGRPVO;	
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal Management] confirmDisposalBasic"}).getMessage(),de);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal Management] confirmDisposalBasic"}).getMessage(),de);
		} 
	}  
	
	/**
	 * [EES_MNR_0157]Adding, modifying, deleting "Disposal Request" data<br>
	 *
	 * @param DisposalGRPVO disposalGRPVO
	 * @param SignOnUserAccount account
	 * @return DisposalGRPVO
	 * @exception EventException
	 */
	public DisposalGRPVO manageDisposalBasic(DisposalGRPVO disposalGRPVO, SignOnUserAccount account) throws EventException{
		try {		
			CustomMnrDispHdrVO customMnrDispHdrVO = disposalGRPVO.getCustomMnrDispHdrVO();
			
			CustomMnrDispDtlVO[] arrCustomMnrDispDtlVOS = disposalGRPVO.getArrCustomMnrDispDtlVOS(); 
			CustomMnrDispBuyerPartVO[] arrCustomMnrDispBuyerPartVOS = disposalGRPVO.getArrCustomMnrDispBuyerPartVOS(); 
			
			customMnrDispHdrVO.setCreUsrId(account.getUsr_id());
			customMnrDispHdrVO.setUpdUsrId(account.getUsr_id());
			
			//In case of new data 
			if(customMnrDispHdrVO.getDispNo().equals("NEW")){  	
				String dispNo = dbDao.searchDisposalSeqData(account.getOfc_cd());  
				customMnrDispHdrVO.setDispNo(dispNo); 
			} else {	
				//Deleting existing header data    	
				dbDao.removeDisposalHRDData(customMnrDispHdrVO);
				//Deleting existing detail data
				dbDao.removeDisposalDTLData(customMnrDispHdrVO);
				//Deleting existing buyer data
				dbDao.removeDisposalBuyerHRDData(customMnrDispHdrVO);
			} 	 
			      
			//Case of Request or Save
			if(customMnrDispHdrVO.getDispStsCd().equals("HR") || customMnrDispHdrVO.getDispStsCd().equals("HS")){
				customMnrDispHdrVO.setRqstOfcCd(account.getOfc_cd()); 
				customMnrDispHdrVO.setRqstUsrId(account.getUsr_id()); 
			//Case of Approval 
			} else if(customMnrDispHdrVO.getDispStsCd().equals("HA")){ 
				java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyyMMddHHmmss");
				String today = formatter.format(new java.util.Date()); 
				customMnrDispHdrVO.setAproDt(today);      
				customMnrDispHdrVO.setAproUsrId(account.getUsr_id());
			}
				
			dbDao.addDisposalHRDData(customMnrDispHdrVO);   
			
			//Inserting new detail data 
			boolean byerInputFlag = false;
			
			//Case of confirm and contract
			if(arrCustomMnrDispDtlVOS != null){ 
				String mnrPrnrCntCd = "";
				String mnrPrnrSeq = "";
				if(customMnrDispHdrVO.getDispStsCd().equals("HC") && arrCustomMnrDispBuyerPartVOS.length > 0){
					byerInputFlag = true; 
					mnrPrnrCntCd = arrCustomMnrDispBuyerPartVOS[0].getMnrPrnrCntCd();	
					mnrPrnrSeq = arrCustomMnrDispBuyerPartVOS[0].getMnrPrnrSeq();	
				} 	   
					
				List<CustomMnrDispDtlVO> insertVoList = new ArrayList<CustomMnrDispDtlVO>();
				for ( int i = 0; i < arrCustomMnrDispDtlVOS.length; i++ ) {      
					arrCustomMnrDispDtlVOS[i].setCreUsrId(account.getUsr_id());
					arrCustomMnrDispDtlVOS[i].setUpdUsrId(account.getUsr_id());
					arrCustomMnrDispDtlVOS[i].setDispDtlSeq(i + 1 + "");  
					arrCustomMnrDispDtlVOS[i].setDispNo(customMnrDispHdrVO.getDispNo()); 
					if(byerInputFlag){ 
						arrCustomMnrDispDtlVOS[i].setMnrPrnrCntCd(mnrPrnrCntCd);
						arrCustomMnrDispDtlVOS[i].setMnrPrnrSeq(mnrPrnrSeq);  
					} 		   
					insertVoList.add(arrCustomMnrDispDtlVOS[i]);   
				}		   		 
				if ( insertVoList.size() > 0 ) {		
					dbDao.addDisposalDTLData(insertVoList);	  
				}   	 
			}   	
			
			//Modifying detail data sum
			dbDao.modifyDisposalHDRSumData(customMnrDispHdrVO);

			//Inserting detail buyer data
			if(arrCustomMnrDispBuyerPartVOS != null){ 
				List<CustomMnrDispBuyerPartVO> insertVoList = new ArrayList<CustomMnrDispBuyerPartVO>();
				for ( int i = 0; i < arrCustomMnrDispBuyerPartVOS.length; i++ ) {       
					arrCustomMnrDispBuyerPartVOS[i].setCreUsrId(account.getUsr_id());  
					arrCustomMnrDispBuyerPartVOS[i].setUpdUsrId(account.getUsr_id());  
					arrCustomMnrDispBuyerPartVOS[i].setDispNo(customMnrDispHdrVO.getDispNo()); 
					arrCustomMnrDispBuyerPartVOS[i].setOfcCd(account.getOfc_cd()); 
					arrCustomMnrDispBuyerPartVOS[i].setMnrPrnrEml(customMnrDispHdrVO.getDispEmlFlg());
					insertVoList.add(arrCustomMnrDispBuyerPartVOS[i]);  
				}
				
				if ( insertVoList.size() > 0 ) {		
					dbDao.addDisposalBuyerHeaderData(insertVoList);
				}  	  	
			}	
			
			return disposalGRPVO;	
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal Request] manageDisposalBasic"}).getMessage(),de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal Request] manageDisposalBasic"}).getMessage(),de);
		} 
	}  
	 
	/**
	 * [EES_MNR_0159]Deleting "Disposal Request"" data<br>
	 *
	 * @param DisposalGRPVO disposalGRPVO
	 * @param SignOnUserAccount account
	 * @return DisposalGRPVO
	 * @exception EventException
	 */
	public DisposalGRPVO removeDisposalBasic(DisposalGRPVO disposalGRPVO, SignOnUserAccount account) throws EventException{
		try { 		
			CustomMnrDispHdrVO customMnrDispHdrVO = disposalGRPVO.getCustomMnrDispHdrVO();
			customMnrDispHdrVO.setUpdUsrId(account.getUsr_id());  
			customMnrDispHdrVO.setDispStsCd("HD");
			dbDao.modifyDisposalHRDData(customMnrDispHdrVO);
			return disposalGRPVO;	
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal Request] removeDisposalBasic"}).getMessage(),de);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal Request] removeDisposalBasic"}).getMessage(),de);
		} 
	}  
	
	/**
	* [EES_MNR_0157]Adding "Disposal Request" data<br>
	*
	* @param DisposalGRPVO disposalGRPVO
	* @exception EventException
	*/
	public void addContractDisposalBuyerDTLBasic(DisposalGRPVO disposalGRPVO) throws EventException{
		try {  		
			CustomMnrDispHdrVO customMnrDispHdrVO = disposalGRPVO.getCustomMnrDispHdrVO();
			dbDao.addContractDisposalBuyerDTLData(customMnrDispHdrVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal Request] addContractDisposalBuyerDTLBasic"}).getMessage(),de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal Request] addContractDisposalBuyerDTLBasic"}).getMessage(),de);
		} 
	}  
	
	/**
	 * [EES_MNR0160] Retrieving "Disposal Sold Creation" header list<br>
	 * @param DisposalSoldGRPVO disposalSoldGRPVO
	 * @param SignOnUserAccount account
	 * @return DisposalSoldGRPVO
	 * @exception EventException
	 */
	public DisposalSoldGRPVO searchDisposalSoldListBasic(DisposalSoldGRPVO disposalSoldGRPVO, SignOnUserAccount account) throws EventException {
		try {    
			List<CustomMnrDispHdrVO> listCustomMnrDispHdrVO = new ArrayList<CustomMnrDispHdrVO>(); 
			listCustomMnrDispHdrVO = dbDao.searchDisposalSoldListData(disposalSoldGRPVO,account);
			 
			disposalSoldGRPVO.setListCustomMnrDispHdrVO(listCustomMnrDispHdrVO); 
			return disposalSoldGRPVO; 
		} catch (DAOException ex) {            
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal Sold Creation] searchDisposalSoldListBasic"}).getMessage(),ex);
		} catch (Exception ex) {            
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal Sold Creation] searchDisposalSoldListBasic"}).getMessage(),ex);
		} 
	}	
	
	/**
	 * [EES_MNR_0160]Retrieving "Disposal Sold Creation" data<br>
	 *
	 * @param DisposalSoldGRPVO disposalSoldGRPVO
	 * @param SignOnUserAccount account
	 * @return DisposalSoldGRPVO
	 * @exception EventException
	 */
	public DisposalSoldGRPVO searchDisposalSoldDetailBasic(DisposalSoldGRPVO disposalSoldGRPVO, SignOnUserAccount account) throws EventException {
		try {     
			List<CustomMnrDispDtlVO> listCustomMnrDispDtlVO = new ArrayList<CustomMnrDispDtlVO>(); 
			listCustomMnrDispDtlVO = dbDao.searchDisposalSoldDetailData(disposalSoldGRPVO);
			 
			//Retrieving Buyer list 
			int iBuyerUpdate = 0;  
			List<List<CustomMnrDispBuyrDtlPartVO>> listCustomMnrDispBuyrDtlPartVOS = new ArrayList<List<CustomMnrDispBuyrDtlPartVO>>(); 	 
			for(int i=0; i<listCustomMnrDispDtlVO.size(); i++) {
				String chkDispNo 		= listCustomMnrDispDtlVO.get(i).getDispNo();
				String sDispDtlSeq	= listCustomMnrDispDtlVO.get(i).getDispDtlSeq();
				List<CustomMnrDispBuyrDtlPartVO> listCustomMnrDispBuyrDtlPartVO =  new ArrayList<CustomMnrDispBuyrDtlPartVO>();
				listCustomMnrDispBuyrDtlPartVO = dbDao.searchDispBuyrDtlPartData(chkDispNo, sDispDtlSeq);
				listCustomMnrDispBuyrDtlPartVOS.add(listCustomMnrDispBuyrDtlPartVO);

				//Checking updated buyer
				int iDispQty = Integer.parseInt(listCustomMnrDispDtlVO.get(i).getDispQty());
				if(iDispQty > 1) {
					iBuyerUpdate = 1; 
				}
			}
				
			//Case of unpartitioned detail quantity     
			if(iBuyerUpdate > 0) {
				CustomMnrDispHdrVO customMnrDispHdrVO = new CustomMnrDispHdrVO();
				customMnrDispHdrVO.setDispNo(listCustomMnrDispDtlVO.get(0).getDispNo());
	    		dbDao.removeDisposalBuyerDTLData(customMnrDispHdrVO);   
	    		
	    		//Re-assigning by retrieved data///////////////////////////////////////////////////////////////
				List<CustomMnrDispDtlVO> newlistCustomMnrDispDtlVO = new ArrayList<CustomMnrDispDtlVO>();
				int iDispDtlSeq = 0;
				for(int i=0; i<listCustomMnrDispDtlVO.size(); i++) {
					
					int iDispQty = Integer.parseInt(listCustomMnrDispDtlVO.get(i).getDispQty());
					
					//From Detail Table
			    	String dispNo 			= listCustomMnrDispDtlVO.get(i).getDispNo();
			    	String dispUtTpCd		= listCustomMnrDispDtlVO.get(i).getDispUtTpCd();
			    	String eqNo				= listCustomMnrDispDtlVO.get(i).getEqNo();
			    	String eqTpszCd			= listCustomMnrDispDtlVO.get(i).getEqTpszCd();
			    	String dispYdCd			= listCustomMnrDispDtlVO.get(i).getDispYdCd();
			    	String dispSoldDt		= listCustomMnrDispDtlVO.get(i).getDispSoldDt();
			    	String dispTrkrNm		= listCustomMnrDispDtlVO.get(i).getDispTrkrNm();
			    	String dispRlseNo		= listCustomMnrDispDtlVO.get(i).getDispRlseNo();
			    	String dispUtPrc		= listCustomMnrDispDtlVO.get(i).getDispUtPrc();
			    	String dispRsnCd		= listCustomMnrDispDtlVO.get(i).getDispRsnCd();
			    	String partAmt			= listCustomMnrDispDtlVO.get(i).getPartAmt();
			    	
			    	//********************** Dividing "invAmt" ********************** //
			    	String invAmt			= listCustomMnrDispDtlVO.get(i).getInvAmt();
			    	if(!invAmt.equals("")){  
			    		double realInvAmt = Double.parseDouble(invAmt) / iDispQty;  
				    	invAmt = String.format("%.2f", realInvAmt);  
			    	} 
			    	//********************** Dividing "invAmt" ********************** //
			    	
			    	String fileSeq			= listCustomMnrDispDtlVO.get(i).getFileSeq();
			    	String invNo			= listCustomMnrDispDtlVO.get(i).getInvNo();
			    	String rcvInvSeq		= listCustomMnrDispDtlVO.get(i).getRcvInvSeq();
			    	String mnrDispDtlRmk	= listCustomMnrDispDtlVO.get(i).getMnrDispDtlRmk();
			    	String mnrPrnrCntCd		= listCustomMnrDispDtlVO.get(i).getMnrPrnrCntCd();
			    	String mnrPrnrSeq		= listCustomMnrDispDtlVO.get(i).getMnrPrnrSeq();
			    	String creUsrId			= listCustomMnrDispDtlVO.get(i).getCreUsrId();
			    	String creDt			= listCustomMnrDispDtlVO.get(i).getCreDt();
			    	String dispSoldDtFlg	= listCustomMnrDispDtlVO.get(i).getDispSoldDtFlg(); 
			    	String eqKndCd			= listCustomMnrDispDtlVO.get(i).getEqKndCd();
			    	String dispRlseNoFlg	= listCustomMnrDispDtlVO.get(i).getDispRlseNoFlg();
			    	String oldEqNo			= listCustomMnrDispDtlVO.get(i).getOldEqNo();
			    	String oldEqTpszCd		= listCustomMnrDispDtlVO.get(i).getOldEqTpszCd();
			    	String oldEqDispYdCd	= listCustomMnrDispDtlVO.get(i).getOldEqDispYdCd();
			    	//From Master Table
			    	String currCd			= listCustomMnrDispDtlVO.get(i).getCurrCd();
			    	
			    	List<CustomMnrDispBuyrDtlPartVO> customMnrDispBuyrDtlPartVOS = listCustomMnrDispBuyrDtlPartVOS.get(i);
				    for(int j=0; j<iDispQty; j++) {
				    	CustomMnrDispDtlVO tempCustomMnrDispDtlVO = new CustomMnrDispDtlVO();
				    	tempCustomMnrDispDtlVO.setDispNo(dispNo);
				    	tempCustomMnrDispDtlVO.setDispDtlSeq((iDispDtlSeq+1)+"");
				    	
				    	//Inserting Buyer
				    	if(iBuyerUpdate>0) {
					    	String checkTarget = ""; 
					    	for(int k=0; k<customMnrDispBuyrDtlPartVOS.size(); k++){
					    		CustomMnrDispBuyrDtlPartVO tempCustomMnrDispBuyrDtlPartVO = customMnrDispBuyrDtlPartVOS.get(k);
					    		if(Integer.parseInt(tempCustomMnrDispBuyrDtlPartVO.getDispCfmQty()) > 0){
					    			int currentQty = Integer.parseInt(tempCustomMnrDispBuyrDtlPartVO.getDispCfmQty()) - 1;
					    			customMnrDispBuyrDtlPartVOS.get(k).setDispCfmQty(currentQty+"");
					    			checkTarget = tempCustomMnrDispBuyrDtlPartVO.getMnrPrnrCntCd() + tempCustomMnrDispBuyrDtlPartVO.getMnrPrnrSeq();
					    			break;
					    		}
					    	}
				    	 
					    	for(int k=0; k<customMnrDispBuyrDtlPartVOS.size(); k++){
					    		CustomMnrDispBuyrDtlPartVO customMnrDispBuyrDtlPartVO = customMnrDispBuyrDtlPartVOS.get(k);
					    		
					    		if(checkTarget.equals(customMnrDispBuyrDtlPartVO.getMnrPrnrCntCd() + customMnrDispBuyrDtlPartVO.getMnrPrnrSeq())){
					    			customMnrDispBuyrDtlPartVO.setDispCfmQty("1");
					    			customMnrDispBuyrDtlPartVO.setMnrDispCfmStsCd("C");
					    		} else {
					    			customMnrDispBuyrDtlPartVO.setDispCfmQty("0");
					    			customMnrDispBuyrDtlPartVO.setMnrDispCfmStsCd("N");
					    		}
					    		
					    		customMnrDispBuyrDtlPartVO.setDispDtlSeq((iDispDtlSeq+1)+"");
					    		
					    		dbDao.addDispBuyrDtlPartData(customMnrDispBuyrDtlPartVO);
					    	}
				    	}
				    	//Inserting Buyer 
				    		
				    	tempCustomMnrDispDtlVO.setDispUtTpCd(dispUtTpCd);
				    	tempCustomMnrDispDtlVO.setEqNo(eqNo);
				    	tempCustomMnrDispDtlVO.setEqTpszCd(eqTpszCd);
				    	tempCustomMnrDispDtlVO.setDispYdCd(dispYdCd);
				    	tempCustomMnrDispDtlVO.setDispQty("1");
				    	tempCustomMnrDispDtlVO.setDispSoldDt(dispSoldDt);
				    	tempCustomMnrDispDtlVO.setDispTrkrNm(dispTrkrNm);
				    	tempCustomMnrDispDtlVO.setDispRlseNo(dispRlseNo);
				    	tempCustomMnrDispDtlVO.setDispUtPrc(dispUtPrc);
				    	tempCustomMnrDispDtlVO.setDispRsnCd(dispRsnCd);
				    	tempCustomMnrDispDtlVO.setPartAmt(partAmt); 
				    	tempCustomMnrDispDtlVO.setInvAmt(invAmt); 
				    	tempCustomMnrDispDtlVO.setFileSeq(fileSeq);
				    	tempCustomMnrDispDtlVO.setInvNo(invNo);
				    	tempCustomMnrDispDtlVO.setRcvInvSeq(rcvInvSeq);
				    	tempCustomMnrDispDtlVO.setMnrDispDtlRmk(mnrDispDtlRmk);
				    	tempCustomMnrDispDtlVO.setMnrPrnrCntCd(mnrPrnrCntCd);
				    	tempCustomMnrDispDtlVO.setMnrPrnrSeq(mnrPrnrSeq);
				    	tempCustomMnrDispDtlVO.setCreUsrId(creUsrId);
				    	tempCustomMnrDispDtlVO.setCreDt(creDt);
				    	tempCustomMnrDispDtlVO.setDispSoldDtFlg(dispSoldDtFlg);
				    	tempCustomMnrDispDtlVO.setEqKndCd(eqKndCd);
				    	tempCustomMnrDispDtlVO.setDispRlseNoFlg(dispRlseNoFlg);
				    	tempCustomMnrDispDtlVO.setOldEqNo(oldEqNo);
				    	tempCustomMnrDispDtlVO.setOldEqTpszCd(oldEqTpszCd);
				    	tempCustomMnrDispDtlVO.setOldEqDispYdCd(oldEqDispYdCd);
				    	tempCustomMnrDispDtlVO.setCurrCd(currCd);
				    	
				    	newlistCustomMnrDispDtlVO.add(tempCustomMnrDispDtlVO);
				    		
				    	iDispDtlSeq++; 
				    }
				}
				//Re-assigning by retrieved data///////////////////////////////////////////////////////////////
			
				//Saving by retrieved data
				List<CustomMnrDispDtlVO> deleteVoList   = new ArrayList<CustomMnrDispDtlVO>();
				List<CustomMnrDispDtlVO> updateVoList   = new ArrayList<CustomMnrDispDtlVO>();
				
				for ( int i=0; i< newlistCustomMnrDispDtlVO.size(); i++ ) {
					if(i==0) {
						deleteVoList.add( newlistCustomMnrDispDtlVO.get(i));
					}	
					newlistCustomMnrDispDtlVO.get(i).setCreUsrId(account.getUsr_id());
					newlistCustomMnrDispDtlVO.get(i).setUpdUsrId(account.getUsr_id());
					updateVoList.add(newlistCustomMnrDispDtlVO.get(i));
				}	 	
					
				//Deleting detail data 
				if ( deleteVoList.size() > 0 ) {	
					dbDao.removeDisposalSoldDetailData(deleteVoList);
			    }	
					
				if ( updateVoList.size() > 0 ) { 
					dbDao.addDisposalSoldDetailData(updateVoList);
				}
				
				//Modifying header data after detail data sum    
				dbDao.modifyDisposalDetailAmountData(customMnrDispHdrVO);
				dbDao.modifyDisposalHDRSumData(customMnrDispHdrVO); 
			}
			
			List<CustomMnrDispDtlVO> byBuyerCustomMnrDispDtlVOS = new ArrayList<CustomMnrDispDtlVO>(); 
			byBuyerCustomMnrDispDtlVOS = dbDao.searchDisposalSoldDTLByBuyerData(disposalSoldGRPVO); 
			disposalSoldGRPVO.setListCustomMnrDispDtlVO(byBuyerCustomMnrDispDtlVOS); 
			return disposalSoldGRPVO;   
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal Sold Creation] searchDisposalSoldDetailBasic"}).getMessage(),de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal Sold Creation] searchDisposalSoldDetailBasic"}).getMessage(),de);
		}
	}	

	/**
	 * [EES_MNR_0163]Retrieving "Disposal Invoice Inquiry" data<br>
	 * @param DisposalInquiryGRPVO disposalInquiryGRPVO
	 * @return DisposalInquiryGRPVO
	 * @exception EventException
	 */
	public DisposalInquiryGRPVO searchDisposalInquiryListBasic(DisposalInquiryGRPVO disposalInquiryGRPVO) throws EventException {
		try {    
				List<CustomMnrRcvInvWrkVO> customMnrRcvInvWrkVOs = new ArrayList<CustomMnrRcvInvWrkVO>(); 
				customMnrRcvInvWrkVOs = dbDao.searchDisposalInquiryListData(disposalInquiryGRPVO.getDisposalInquiryINVO());
				disposalInquiryGRPVO.setCustomMnrRcvInvWrkVOs(customMnrRcvInvWrkVOs); 
				return disposalInquiryGRPVO; 
		} catch (DAOException ex) {            
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal Invoice Inquiry] searchDisposalInquiryListBasic"}).getMessage(),ex); 
		} catch (Exception ex) {            
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal Invoice Inquiry] searchDisposalInquiryListBasic"}).getMessage(),ex); 
		} 
	} 

	/**
	 * [EES_MNR_0163]Retrieving "Disposal Invoice Detail" data<br>
	 * @param DisposalInquiryGRPVO disposalInquiryGRPVO
	 * @return DisposalInquiryGRPVO
	 * @exception EventException
	 */
	public DisposalInquiryGRPVO searchDisposalDetailInquiryListBasic(DisposalInquiryGRPVO disposalInquiryGRPVO) throws EventException {
		try {    
				List<CustomDispInvDtIVO> customDispInvDtIVOs = new ArrayList<CustomDispInvDtIVO>(); 
				customDispInvDtIVOs = dbDao.searchDisposalDetailInquiryListData(disposalInquiryGRPVO.getDisposalInquiryINVO());
				disposalInquiryGRPVO.setCustomDispInvDtIVOs(customDispInvDtIVOs); 
				return disposalInquiryGRPVO; 
		} catch (DAOException ex) {            
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal Invoice Inquiry] searchDisposalInquiryListBasic"}).getMessage(),ex); 
		} catch (Exception ex) {            
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal Invoice Inquiry] searchDisposalInquiryListBasic"}).getMessage(),ex); 
		} 
	} 
	
	/**
	 * [EES_MNR_0163]Retrieving "Disposal Invoice Collection" data<br>
	 * @param DisposalInquiryGRPVO disposalInquiryGRPVO
	 * @return DisposalInquiryGRPVO
	 * @exception EventException
	 */
	public DisposalInquiryGRPVO searchDisposalCollectionInquiryListBasic(DisposalInquiryGRPVO disposalInquiryGRPVO) throws EventException {
		try {    
				List<CustomBkgOtsDtlVO> customBkgOtsDtlVOs = new ArrayList<CustomBkgOtsDtlVO>(); 
				customBkgOtsDtlVOs = dbDao.searchDisposalCollectionInquiryListData(disposalInquiryGRPVO.getDisposalInquiryINVO());
				disposalInquiryGRPVO.setCustomBkgOtsDtlVOs(customBkgOtsDtlVOs); 
				return disposalInquiryGRPVO; 
		} catch (DAOException ex) {            
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal Invoice Inquiry] searchDisposalInquiryListBasic"}).getMessage(),ex); 
		} catch (Exception ex) {            
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal Invoice Inquiry] searchDisposalInquiryListBasic"}).getMessage(),ex); 
		} 
	} 
	
	/**
	 * [EES_MNR_0160]Adding, modifying, deleting "Disposal Sold Creation" data<br>
	 *
	 * @param DisposalSoldGRPVO disposalSoldGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageDisposalSoldBasic(DisposalSoldGRPVO disposalSoldGRPVO, SignOnUserAccount account) throws EventException{
		
		try {
			CustomMnrDispDtlVO[]  arrayCustomMnrDispDtlVO  = disposalSoldGRPVO.getArrayCustomMnrDispDtlVO();
			
			List<CustomMnrDispDtlVO> updateVoList   = new ArrayList<CustomMnrDispDtlVO>();
			
		    String dispNo = arrayCustomMnrDispDtlVO[0].getDispNo();
		    
			for ( int i=0; i< arrayCustomMnrDispDtlVO.length; i++ ) {
				arrayCustomMnrDispDtlVO[i].setCreUsrId(account.getUsr_id());
				arrayCustomMnrDispDtlVO[i].setUpdUsrId(account.getUsr_id());
				
//				if(arrayCustomMnrDispDtlVO[i].getDispSoldDtFlg().equals("N")) {
//					arrayCustomMnrDispDtlVO[i].setEqNo("");
//					arrayCustomMnrDispDtlVO[i].setDispSoldDt("");
//					arrayCustomMnrDispDtlVO[i].setDispRlseNo("");
//					arrayCustomMnrDispDtlVO[i].setDispYdCd("");
//					updateVoList.add(arrayCustomMnrDispDtlVO[i]);	   
//				} else { 		
					updateVoList.add(arrayCustomMnrDispDtlVO[i]);	   
//				}						 			
			}			

			if ( updateVoList.size() > 0 ) { 		 
				dbDao.modfyDisposalSoldDetailData(updateVoList);	
			}
			
			//Changing status 
			dbDao.modifyDisposalSoldListForStatusData(dispNo);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal Sold Creation] manageDisposalSoldBasic"}).getMessage(),de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal Sold Creation] manageDisposalSoldBasic"}).getMessage(),de);
		}
	}

	/**
	 * [EES_MNR_0160]Retrieving the data of created "ReleaseNo"<br>
	 *
	 * @param SignOnUserAccount account
	 * @return DisposalSoldGRPVO
	 * @exception EventException
	 */
	public DisposalSoldGRPVO searchDispRlseNoBasic(SignOnUserAccount account) throws EventException {
		try { 
			String ofcCd = account.getOfc_cd();
			String dispRlseNo = dbDao.searchDispRlseNoData(ofcCd); 
			DisposalSoldGRPVO disposalSoldGRPVO = new DisposalSoldGRPVO();
			disposalSoldGRPVO.setDispRlseNo(dispRlseNo); 
			return disposalSoldGRPVO;
			
		} catch (DAOException ex) {          
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal Sold Creation ] searchDispRlseNoBasic"}).getMessage(),ex);
		} catch (Exception e) { 
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal Sold Creation ] searchDispRlseNoBasic"}).getMessage(),e);
		}  
	}    
	
	/**
	 * [EES_MNR_0157,0159]Modifying data sum when "Disposal the data confirm"<br> 
	 * 
	 * @param DisposalGRPVO disposalGRPVO
	 * @exception EventException
	 */
	public void addDisposalCofirmSumBasic(DisposalGRPVO disposalGRPVO) throws EventException{
		try {    	 	     
			CustomMnrDispHdrVO customMnrDispHdrVO = disposalGRPVO.getCustomMnrDispHdrVO();
			dbDao.modifyDisposalDetailAmountData(customMnrDispHdrVO);       
			dbDao.modifyDisposalHDRSumData(customMnrDispHdrVO);       
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal Request] addDisposalCofirmSumBasic"}).getMessage(),de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal Request] addDisposalCofirmSumBasic"}).getMessage(),de);
		} 
	}  
	
	/**
	 * [EES_MNR_0161]Deleting "Disposal Invoice Issue" data<br>
	 * 
	 * @param DisposalGRPVO disposalGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException  
	 */
	public void modifyDisposalInvoiceLinkClearBasic(DisposalGRPVO disposalGRPVO, SignOnUserAccount account) throws EventException{
		try {    	 	     
			CustomMnrDispDtlVO customMnrDispDtlVO = disposalGRPVO.getCustomMnrDispDtlVO();

			customMnrDispDtlVO.setUpdUsrId(account.getUsr_id());
			
			dbDao.modifyDisposalInvoiceLinkClearData(customMnrDispDtlVO);       
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal Invoice Issue] modifyDisposalInvoiceLinkClearBasic"}).getMessage(),de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal Invoice Issue] modifyDisposalInvoiceLinkClearBasic"}).getMessage(),de);
		} 
	}  
	
	/**
	 * [EES_MNR_0161]Modifying "Disposal Invoice Issue" data<br>
	 * 
	 * @param DisposalGRPVO disposalGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException  
	 */
	public void modifyDisposalInvoiceLinkBasic(DisposalGRPVO disposalGRPVO,SignOnUserAccount account) throws EventException{
		try {    	 
			CustomMnrDispDtlVO[]  arrayCustomMnrDispDtlVO  = disposalGRPVO.getArrCustomMnrDispDtlVOS();
			
			List<CustomMnrDispDtlVO> updateVoList   = new ArrayList<CustomMnrDispDtlVO>();
			   
			for ( int i=0; i< arrayCustomMnrDispDtlVO.length; i++ ) {
				arrayCustomMnrDispDtlVO[i].setCreUsrId(account.getUsr_id());
				arrayCustomMnrDispDtlVO[i].setUpdUsrId(account.getUsr_id());
				updateVoList.add(arrayCustomMnrDispDtlVO[i]);  
			}             

			if ( updateVoList.size() > 0 ) { 
				dbDao.modifyDisposalInvoiceLinkData(updateVoList);
		    }  

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal Invoice Issue] modifyDisposalInvoiceLinkBasic"}).getMessage(),de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal Invoice Issue] modifyDisposalInvoiceLinkBasic"}).getMessage(),de);
		} 
	}  	
	
	/**
	 * [EES_MNR_S308] 파트너 정보를 조회 합니다.  
	 * 
	 * @param DisposalInquiryGRPVO disposalInquiryGRPVO
	 * @param SignOnUserAccount account
	 * @return DisposalInquiryGRPVO
	 * @exception EventException  
	 */   
	public DisposalInquiryGRPVO searchPartnerBasic(DisposalInquiryGRPVO disposalInquiryGRPVO, SignOnUserAccount account) throws EventException {
		DisposalInquiryINVO  disposalInquiryINVO = null;
		try {

			disposalInquiryINVO = dbDao.searchPartnerData(account.getUsr_id());
			
			disposalInquiryGRPVO.setDisposalInquiryINVO(disposalInquiryINVO);

			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return disposalInquiryGRPVO;
	}	
	
	/**
	 * [EES_MNR_S304] My Bidding List 헤더 목록을 조회합니다.<br>
	 * 
	 * @param  MyBiddingGRPVO myBiddingGRPVO
	 * @return MyBiddingGRPVO 
	 * @exception EventException   	
	 */ 
	public MyBiddingGRPVO searchMyBiddingHdrListBasic(MyBiddingGRPVO myBiddingGRPVO) throws EventException {
		List<CustomMyBiddingHdrVO> listcustomMyBiddingHdrVOs = null;  
		try {  	
			listcustomMyBiddingHdrVOs = dbDao.searchMyBiddingHdrListData(myBiddingGRPVO);
			myBiddingGRPVO.setListCustomMyBiddingHdrVO(listcustomMyBiddingHdrVOs);
			return myBiddingGRPVO;  
		} catch (DAOException ex) {   	 
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception e) { 
			throw new EventException(new ErrorHandler(e).getMessage());
		}  
	}	
	
	/**
	 * [EES_MNR_S304] My Bidding List 디테일 목록을 조회합니다.<br>
	 *
	 * @param MyBiddingGRPVO myBiddingGRPVO
	 * @return MyBiddingGRPVO
	 * @exception EventException
	 */
	public MyBiddingGRPVO searchMyBiddingDtlListBasic(MyBiddingGRPVO myBiddingGRPVO) throws EventException {
		try {    
			List<CustomMyBiddingDtlVO> listEqCustomMyBiddingDtlVO = null;
			List<CustomMyBiddingDtlVO> listQtyCustomMyBiddingDtlVO = null;
			   
			//DTL 구하기 
			myBiddingGRPVO.getMyBiddingINVO().setDispUtTpCd("E"); 
			listEqCustomMyBiddingDtlVO = dbDao.searchMyBiddingDtlListData(myBiddingGRPVO); 
			myBiddingGRPVO.getMyBiddingINVO().setDispUtTpCd("Q"); 
			listQtyCustomMyBiddingDtlVO = dbDao.searchMyBiddingDtlListData(myBiddingGRPVO);  	
				
			myBiddingGRPVO.setListEqCustomMyBiddingDtlVO(listEqCustomMyBiddingDtlVO);
			myBiddingGRPVO.setListQtyCustomMyBiddingDtlVO(listQtyCustomMyBiddingDtlVO);
			return myBiddingGRPVO; 
		} catch (DAOException ex) {            
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[My Bidding Lis] searchMyBiddingDtlListBasic"}).getMessage(),ex); 
		} catch (Exception ex) {            
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[My Bidding Lis] searchMyBiddingDtlListBasic"}).getMessage(),ex); 
		} 
	}
	
	/**
	 * [EES_MNR_S304] 선택된 Bidding No의 Bidding Status을 조회합니다.<br>
	 * 
	 * @param  MyBiddingINVO myBiddingINVO
	 * @return List<CustomMyBiddingHdrVO> 
	 * @exception EventException   	
	 */ 
	public List<CustomMyBiddingHdrVO> searchMyBiddingStatus(MyBiddingINVO myBiddingINVO) throws EventException {

		try {  	
			return dbDao.searchMyBiddingStatus(myBiddingINVO);
		} catch (DAOException ex) {   	 
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception e) { 
			throw new EventException(new ErrorHandler(e).getMessage());
		}  
	}

	/**
	 * [EES_MNR_S304]My Bidding List의 디테일 목록 정보를 추가/수정 합니다. <br>
	 *
	 * @param MyBiddingGRPVO myBiddingGRPVO
	 * @param SignOnUserAccount account
	 * @return MyBiddingGRPVO
	 * @exception EventException
	 */   
	public MyBiddingGRPVO manageMyBiddingDtlListBasic(MyBiddingGRPVO myBiddingGRPVO, SignOnUserAccount account) throws EventException{
		try {		
			CustomMyBiddingDtlVO[] arrayCustomMyBiddingDtlVOs = myBiddingGRPVO.getArrayCustomMyBiddingDtlVO();
			List<CustomMyBiddingDtlVO> insertVoList   = new ArrayList<CustomMyBiddingDtlVO>();
			List<CustomMyBiddingDtlVO> updateVoList   = new ArrayList<CustomMyBiddingDtlVO>();
			List<CustomMyBiddingDtlVO> deleteVoList   = new ArrayList<CustomMyBiddingDtlVO>();
			
			if(arrayCustomMyBiddingDtlVOs != null){
				//Open Check 
				String sDispNo = arrayCustomMyBiddingDtlVOs[0].getDispNo();
				myBiddingGRPVO.setDispNo(sDispNo);
				for ( int i = 0; i < arrayCustomMyBiddingDtlVOs.length; i++ ) {
					Double myOfferAmt =  Double.parseDouble(arrayCustomMyBiddingDtlVOs[i].getPartUtAmt());
					//금액이 0 이상인 것만 입찰로 인정 
					if(myOfferAmt != 0){
						String dispNo		= arrayCustomMyBiddingDtlVOs[i].getDispNo();
						String dispDtlNo	= arrayCustomMyBiddingDtlVOs[i].getDispDtlSeq();
						String mnrPrnrCntCd	= arrayCustomMyBiddingDtlVOs[i].getMnrPrnrCntCd();
						String mnrPrnrSeq	= arrayCustomMyBiddingDtlVOs[i].getMnrPrnrSeq();
						int cnt = dbDao.checkMyBiddingDtlListUIStatusData(dispNo, dispDtlNo, mnrPrnrCntCd, mnrPrnrSeq);
							
						//insert
						if (cnt == 0){
							arrayCustomMyBiddingDtlVOs[i].setCreUsrId(account.getUsr_id());
							arrayCustomMyBiddingDtlVOs[i].setUpdUsrId(account.getUsr_id());
							insertVoList.add(arrayCustomMyBiddingDtlVOs[i]);
						//update	
						} else {	
							arrayCustomMyBiddingDtlVOs[i].setUpdUsrId(account.getUsr_id());
							updateVoList.add(arrayCustomMyBiddingDtlVOs[i]);
						}		
					} else {
						deleteVoList.add(arrayCustomMyBiddingDtlVOs[i]);
					}
				}	   		 
			    		
				String spPtalId = myBiddingGRPVO.getMyBiddingINVO().getSpPtalId();
				if ( insertVoList.size() > 0 ) {
					dbDao.addMyBiddingDtlListData(insertVoList, spPtalId);
			    }  
				if ( updateVoList.size() > 0) {
					dbDao.modifyMyBiddingDtlListData(updateVoList);
				}
				if ( deleteVoList.size() > 0) {			  
					dbDao.removeMyBiddingDtlListData(deleteVoList);
				}
			}
			
			return myBiddingGRPVO;	
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[My Bidding List] manageMyBiddingDtlListBasic"}).getMessage(),de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[My Bidding List] manageMyBiddingDtlListBasic"}).getMessage(),de);
		} 
	}
	
	/**
	 * [EES_MNR_S304]My Bidding List의 디테일 목록 정보를 삭제 합니다. <br>
	 *
	 * @param MyBiddingGRPVO myBiddingGRPVO
	 * @param SignOnUserAccount account
	 * @return MyBiddingGRPVO
	 * @exception EventException
	 */   
	public MyBiddingGRPVO removeMyBiddingDtlListBasic(MyBiddingGRPVO myBiddingGRPVO, SignOnUserAccount account) throws EventException{
		try {		
			CustomMyBiddingDtlVO[] arrayCustomMyBiddingDtlVOs = myBiddingGRPVO.getArrayCustomMyBiddingDtlVO();
			List<CustomMyBiddingDtlVO> deleteVoList   = new ArrayList<CustomMyBiddingDtlVO>();
			
			if(arrayCustomMyBiddingDtlVOs != null){
				String sDispNo = arrayCustomMyBiddingDtlVOs[0].getDispNo();
				myBiddingGRPVO.setDispNo(sDispNo);
				for ( int i = 0; i < arrayCustomMyBiddingDtlVOs.length; i++ ) {
					if(arrayCustomMyBiddingDtlVOs[i].getIbflag().equals("D")) {
						deleteVoList.add(arrayCustomMyBiddingDtlVOs[i]);
					}
				}   		 
				
				if ( deleteVoList.size() > 0) {
					dbDao.removeMyBiddingDtlListData(deleteVoList);
				}
			}
			
			return myBiddingGRPVO;	
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[My Bidding List] removeMyBiddingDtlListBasic"}).getMessage(),de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[My Bidding List] removeMyBiddingDtlListBasic"}).getMessage(),de);
		} 
	}	

	/**
	 * [EES_MNR_S304] My Bidding List의  Local Time을 조회 합니다.<br>
	 * 
	 * @param MyBiddingGRPVO myBiddingGRPVO
	 * @param SignOnUserAccount account
	 * @return MyBiddingGRPVO
	 * @exception EventException  
	 */   
	public MyBiddingGRPVO searchMyBiddingLoaclTimeListBasic(MyBiddingGRPVO myBiddingGRPVO, SignOnUserAccount account) throws EventException {
		MyBiddingINVO  myBiddingINVO = null;
		try { 
			myBiddingINVO = dbDao.searchMyBiddingLocalTimeListData(account.getUsr_id());
			
			myBiddingGRPVO.setMyBiddingINVO(myBiddingINVO);
			
			
		} catch (DAOException ex) {          
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[My Bidding List Local Time] searchMyBiddingLoaclTimeListBasic"}).getMessage(),ex);
		} catch (Exception e) { 
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[My Bidding List Local Time] searchMyBiddingLoaclTimeListBasic"}).getMessage(),e);
		}  
		return myBiddingGRPVO;
	}	
}
