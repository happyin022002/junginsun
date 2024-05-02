/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DisposalMgtBCImpl.java
*@FileTitle : Disposal
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.11
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2009.09.11 박명신
* 1.0 Creation 
* --------------------------------------------------------
* History
* 2011.11.21 신혜정 [CHM-201114467-01] Cancelled Disposal Invoice history 저장   
* 2012.01.18 신혜정 [CHM-201215791] My Bidding List의 Local Time 수정(로긴아이디의 office 정보로 조회 -> spp potal id 로 조회하는 방법으로 변경)
* 2012.04.12 신혜정 [CHM-201217048] Disposal Inquiry 화면에서 not pick-up 된 장비 list 조회 기능 추가 
* 2012.11.29 조경완 [CHM-201221414-01] ALPS-MNR-DISPOSAL-MANAGEMENT-MANAGEMENT INQUIRY 화면에서 수정 건 
* 2013.04.25 조경완 [CHM-201324321-01] [MNR] 동일 장비에 대해 중복 Disposal Request되는 현상 제거를 위한 기능 보완
* 2013.09.27 조경완 [CHM-201326609-01] ALPS MNR-Disposal-Disposal Management에서 비딩 결과를 이메일로 통보해주는 기능          
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.ees.mnr.accountmanage.incomemgt.vo.ReceivableInvoiceGRPVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.interfacemgt.vo.EmailSendInfoVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.interfacemgt.vo.GeneralMailFormVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.integration.DisposalMgtDBDAO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.vo.CustomBkgOtsDtlVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.vo.CustomDispInvDtIVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.vo.CustomMnrDispBuyerPartVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.vo.CustomMnrDispBuyrDtlPartVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.vo.CustomMnrDispCancelVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.vo.CustomMnrDispDtlVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.vo.CustomMnrDispHdrVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.vo.CustomMnrDispNoPickUpVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.vo.CustomMnrRcvInvWrkVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.vo.CustomMyBiddingDtlVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.vo.CustomMyBiddingHdrVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.vo.DisposalGRPVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.vo.DisposalInquiryGRPVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.vo.DisposalInquiryINVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.vo.DisposalNVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.vo.DisposalSoldGRPVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.vo.DisposalSoldINVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.vo.MyBiddingGRPVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.vo.MyBiddingINVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * alps-OperationManage Business Logic Basic Command implementation<br>
 * - alps-OperationManage에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author park myoung sin
 * @see EES_MNR_0139EventResponse,EES_MNR_0122HTMLAction,EQFlagMgtBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class DisposalMgtBCImpl extends BasicCommandSupport implements DisposalMgtBC {
	
	// Database Access Object
	private transient DisposalMgtDBDAO dbDao = null; 	
	
	
	/**
	 * DisposalMgtBCImpl 객체 생성<br>
	 * DisposalMgtDBDAO를 생성한다.<br>
	 */
	public DisposalMgtBCImpl() {
		dbDao = new DisposalMgtDBDAO(); 
	}
	  
	/**
	 * [EES_MNR_0164]Disposal Request의 정보를 조회 합니다. <br>
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
	 * [EES_MNR_0164]Disposal Request의 정보를 삭제(Reject) 합니다. <br>
	 *
	 * @param DisposalGRPVO disposalGRPVO
	 * @param SignOnUserAccount account
	 * @return DisposalGRPVO
	 * @exception EventException
	 */   
	public DisposalGRPVO removeDisposalListData(DisposalGRPVO disposalGRPVO, SignOnUserAccount account) throws EventException{
		try { 		
			List<CustomMnrDispHdrVO> customMnrDispHdrVOS = disposalGRPVO.getCustomMnrDispHdrVOS();
			for(int i = 0;i < customMnrDispHdrVOS.size(); i++){
				CustomMnrDispHdrVO customMnrDispHdrVO = customMnrDispHdrVOS.get(i);
				customMnrDispHdrVO.setUpdUsrId(account.getUsr_id());  
				customMnrDispHdrVO.setDispStsCd("HD");
				dbDao.modifyDisposalHRDData(customMnrDispHdrVO);
			}
			return disposalGRPVO;	
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal Request] removeDisposalListData"}).getMessage(),de);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal Request] removeDisposalListData"}).getMessage(),de);
		} 
	}  
	
	/**
	 * [EES_MNR_0093]Scrapping/Donation Creation의 정보를 조회 합니다. <br>
	 *
	 * @param DisposalGRPVO disposalGRPVO
	 * @param SignOnUserAccount account
	 * @return DisposalGRPVO
	 * @exception EventException
	 */ 
	public DisposalGRPVO searchDSPBuyerDTLPartBasic(DisposalGRPVO disposalGRPVO, SignOnUserAccount account) throws EventException {
		try {     
			List<CustomMnrDispBuyrDtlPartVO> customMnrDispBuyrDtlPartVOS = new ArrayList<CustomMnrDispBuyrDtlPartVO>(); 
			customMnrDispBuyrDtlPartVOS = dbDao.searchDSPBuyerDTLPartData(disposalGRPVO.getCustomMnrDispHdrVO(), account);
				
			disposalGRPVO.setCustomMnrDispBuyrDtlPartVOS(customMnrDispBuyrDtlPartVOS); 
			return disposalGRPVO; 
		} catch (DAOException ex) {            
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal Request] searchDSPBuyerDTLPartBasic"}).getMessage(),ex); 
		} catch (Exception ex) {            
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal Request] searchDSPBuyerDTLPartBasic"}).getMessage(),ex); 
		} 
	} 
		
	/**
	 * [EES_MNR_0159]Disposal 메일보낼 리스트 조회 <br>
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
			//메일 보낼 대상조회
			emailSendInfoVOS = dbDao.searchDisposalMailListData(customMnrDispHdrVO);
			
			//메일 내용을 만든다.	
			StringBuilder argument = new StringBuilder("");	
			String mailSubject = "";
			String saleType = "";
			String eqNoOrQty = "";
			String yardOrLoc = "";
			StringBuilder vCntrItems = new StringBuilder("");
			
			//DTL 구하기 
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
			//Detail Lsit
			argument.append("detail_list").append(";").append(vCntrItems.toString());
				
			for (int i = 0; i < emailSendInfoVOS.size(); i++) {
				///NIS2010/APP-INF/config/template/mailtemplate/EES_MNR_DISPOSAL_01T.html
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
	 * [EES_MNR_0159]Disposal Contract 메일보낼 리스트 조회 <br>
	 *
	 * @param DisposalGRPVO disposalGRPVO
	 * @return DisposalGRPVO
	 * @exception EventException
	 */ 
	public DisposalGRPVO searchDispContractMailListBasic(DisposalGRPVO disposalGRPVO) throws EventException {
		try {    
			CustomMnrDispHdrVO customMnrDispHdrVO = disposalGRPVO.getCustomMnrDispHdrVO();
			List<EmailSendInfoVO> emailSendInfoVOS = new ArrayList<EmailSendInfoVO>(); 
			List<CustomMnrDispDtlVO> eqCustomMnrDispDtlVOS = null;
			//메일 보낼 대상조회
			emailSendInfoVOS = dbDao.searchDispContractMailListData(customMnrDispHdrVO);
			
			//메일 내용을 만든다.	
			StringBuilder argument = new StringBuilder("");	
			String mailSubject = "";
			String recipientNm = "";
			String confirm_ofc_nm = "";
			String confirm_ofc_cd = "";
			String sender_nm = "";

			StringBuilder vCntrItems = new StringBuilder("");
			
			//DTL 구하기 
			customMnrDispHdrVO.setDispUtTpCd("E"); 
			eqCustomMnrDispDtlVOS = dbDao.searchDisposalDTLListData(customMnrDispHdrVO);	
			
			if(emailSendInfoVOS.size() > 0){
				mailSubject = emailSendInfoVOS.get(0).getSubject();
				recipientNm = emailSendInfoVOS.get(0).getRecipientNm();
				confirm_ofc_nm = emailSendInfoVOS.get(0).getSenderOfcNm();
				confirm_ofc_cd = emailSendInfoVOS.get(0).getSenderOfcCd();
				sender_nm = emailSendInfoVOS.get(0).getSenderNm();
			}
			argument.append("subject").append(";").append(mailSubject).append(",");
			argument.append("recipient").append(";").append(recipientNm).append(",");
			argument.append("confirm_ofc_nm").append(";").append(confirm_ofc_nm).append(",");
			argument.append("confirm_ofc_cd").append(";").append(confirm_ofc_cd).append(",");
			argument.append("disp_no").append(";").append(customMnrDispHdrVO.getDispNo()).append(",");
			argument.append("sender_nm").append(";").append(sender_nm).append(",");
			
			//Unit Detail
			if(eqCustomMnrDispDtlVOS.size() > 0){	
				for (int i = 0; i < eqCustomMnrDispDtlVOS.size(); i++) {
					vCntrItems.append("<tr align=\'center\'><td>").append(i+1).append("</td>");
					vCntrItems.append("<td>").append(eqCustomMnrDispDtlVOS.get(i).getDispNo()).append("</td>");
					vCntrItems.append("<td>").append(eqCustomMnrDispDtlVOS.get(i).getEqNo()).append("</td>");				
					vCntrItems.append("<td>").append(eqCustomMnrDispDtlVOS.get(i).getEqTpszCd()).append("</td>");
					vCntrItems.append("<td>").append(eqCustomMnrDispDtlVOS.get(i).getDispYdCd()).append("</td></tr>");				
				}
			} 								
			//Detail Lsit
			argument.append("detail_list").append(";").append(vCntrItems.toString());
				
			for (int i = 0; i < emailSendInfoVOS.size(); i++) {
				///NIS2010/APP-INF/config/template/mailtemplate/EES_MNR_DISPOSAL_01T.html
				emailSendInfoVOS.get(i).setTemplate("EES_MNR_DISPOSAL_02T.html");	
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
	 * [EES_MNR_0159]Disposal Management의 정보를 조회 합니다. <br>
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
	 * [EES_MNR_0200]Disposal Request의 정보를 조회 합니다. <br>
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
			   
			//Buyer Selection 구하기 
			customMnrDispBuyerPartVOS = dbDao.searchDisposalBuyerHeaderData(disposalGRPVO); 
				
			//DTL 구하기 
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
	 * [EES_MNR_0162]Disposal Approval Popup 화면에서 Buyer List를 조회한다. <br>
	 *
	 * @param DisposalGRPVO disposalGRPVO
	 * @return DisposalGRPVO
	 * @exception EventException
	 */
	public DisposalGRPVO searchDisposalBasicPopUp(DisposalGRPVO disposalGRPVO) throws EventException {
		try {    
			CustomMnrDispHdrVO customMnrDispHdrVO = disposalGRPVO.getCustomMnrDispHdrVO();
			
			List<CustomMnrDispBuyerPartVO> customMnrDispBuyerPartVOS = null;
			
			//Buyer Selection 구하기 
			customMnrDispBuyerPartVOS = dbDao.searchDisposalBuyerHeaderData(disposalGRPVO); 
				

			disposalGRPVO.setCustomMnrDispBuyerPartVOS(customMnrDispBuyerPartVOS);
			return disposalGRPVO; 
		} catch (DAOException ex) {            
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal Approval Pop up] searchDisposalBuyerHeaderData"}).getMessage(),ex); 
		} catch (Exception ex) {            
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal Approval Pop up] searchDisposalBuyerHeaderData"}).getMessage(),ex); 
		} 
	} 
	
	/**
	 * [EES_MNR_0159]Disposal Management의 정보를 작업 합니다. <br>
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
			
			//공통의로 필요한것	 	
			customMnrDispHdrVO.setCreUsrId(account.getUsr_id());
			customMnrDispHdrVO.setUpdUsrId(account.getUsr_id());
			
			// Disposal Type 이 없는 경우 입력되지 않도록 로직 처리함, 2014-04-30, 신용찬
			String disp_tp_cd = customMnrDispHdrVO.getDispTpCd(); 
			log.debug("\n---------------------- manageDisposalBasic Disposal Type : " + disp_tp_cd);
			
			if(disp_tp_cd==null || disp_tp_cd.equals("")) {  // Please select {?msg1} data.
				throw new EventException(new ErrorHandler("MNR00036", new String[]{"Disposal Type"}).getMessage());
			}				
			
			//헤더 기존 데이타 삭제    	
			dbDao.removeDisposalHRDData(customMnrDispHdrVO);
			//디테일 기존 데이타 삭제  
			dbDao.removeDisposalDTLData(customMnrDispHdrVO);
			//Buyer 기존 데이타 삭제   
			dbDao.removeDisposalBuyerHRDData(customMnrDispHdrVO);
			//mnr_disp_buyr_dtl_part 기존 데이타 삭제   
			dbDao.removeDisposalBuyerDTLData(customMnrDispHdrVO);
			
			//헤더 데이타 삽입 
			dbDao.addDisposalHRDData(customMnrDispHdrVO);   
				
			//디테일 뉴 데이타 삽입 
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
			
			//디테일 값 합계를 헤더 테이블에 넣는다 
			dbDao.modifyDisposalHDRSumData(customMnrDispHdrVO); 
				
			//디테일 매각 바이어 데이타 삽입   
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
	 * [EES_MNR_0159]Disposal Management의 정보를 작업 합니다. <br>
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
			//Array가 clone 이 안되서 ...   
			CustomMnrDispBuyrDtlPartVO[] arrCustomMnrDispBuyrDtlPartVOS2 = new CustomMnrDispBuyrDtlPartVO[arrCustomMnrDispBuyrDtlPartVOS.length];
			for(int i = 0;i < arrCustomMnrDispBuyrDtlPartVOS.length;i ++){ 
				arrCustomMnrDispBuyrDtlPartVOS2[i] = (CustomMnrDispBuyrDtlPartVO)arrCustomMnrDispBuyrDtlPartVOS[i].clone(); 
			} 
			
			// Disposal Type 이 없는 경우 입력되지 않도록 로직 처리함, 2014-04-30, 신용찬
			String disp_tp_cd = customMnrDispHdrVO.getDispTpCd(); 
			log.debug("\n---------------------- manageDisposalBasic Disposal Type : " + disp_tp_cd);
			
			if(disp_tp_cd==null || disp_tp_cd.equals("")) {  // Please select {?msg1} data.
				throw new EventException(new ErrorHandler("MNR00036", new String[]{"Disposal Type"}).getMessage());
			}	
			
			//공통의로 필요한것	 	
			customMnrDispHdrVO.setCreUsrId(account.getUsr_id());
			customMnrDispHdrVO.setUpdUsrId(account.getUsr_id());
			//헤더 기존 데이타 삭제    	
			dbDao.removeDisposalHRDData(customMnrDispHdrVO);
			//디테일 기존 데이타 삭제  
			dbDao.removeDisposalDTLData(customMnrDispHdrVO);
			//Buyer 기존 데이타 삭제   
			dbDao.removeDisposalBuyerHRDData(customMnrDispHdrVO);
			//mnr_disp_buyr_dtl_part 기존 데이타 삭제   
			dbDao.removeDisposalBuyerDTLData(customMnrDispHdrVO);
			//헤더 데이타 삽입 
			dbDao.addDisposalHRDData(customMnrDispHdrVO);   
			List<CustomMnrDispDtlVO> customMnrDispDtlVOS = new ArrayList<CustomMnrDispDtlVO>();
			List<CustomMnrDispBuyrDtlPartVO> customMnrDispBuyrDtlPartVOS = new ArrayList<CustomMnrDispBuyrDtlPartVO>();
				
			//디테일 뉴 데이타 삽입 
			if(arrCustomMnrDispDtlVOS != null){  
				for ( int i = 0; i < arrCustomMnrDispDtlVOS.length; i++ ) {      
					arrCustomMnrDispDtlVOS[i].setCreUsrId(account.getUsr_id());
					arrCustomMnrDispDtlVOS[i].setUpdUsrId(account.getUsr_id());
					arrCustomMnrDispDtlVOS[i].setDispNo(customMnrDispHdrVO.getDispNo());  
						
					for ( int x = 0; x < arrCustomMnrDispBuyrDtlPartVOS.length; x++ ){ 
						if(arrCustomMnrDispDtlVOS[i].getDispDtlSeq().equals(arrCustomMnrDispBuyrDtlPartVOS[x].getDispDtlSeq())){
							if(arrCustomMnrDispBuyrDtlPartVOS[x].getMnrDispCfmStsCd().equals("1")){
								//DTL 세팅        
								CustomMnrDispDtlVO customMnrDispDtlVO = (CustomMnrDispDtlVO)arrCustomMnrDispDtlVOS[i].clone();  
								customMnrDispDtlVO.setDispQty(arrCustomMnrDispBuyrDtlPartVOS[x].getDispCfmQty());
								customMnrDispDtlVO.setDispDtlSeq(customMnrDispDtlVOS.size() + 1 + "");  
								customMnrDispDtlVO.setMnrPrnrCntCd(arrCustomMnrDispBuyrDtlPartVOS[x].getMnrPrnrCntCd());
								customMnrDispDtlVO.setMnrPrnrSeq(arrCustomMnrDispBuyrDtlPartVOS[x].getMnrPrnrSeq()); 
									
								//BUYR DTL 세팅 
								CustomMnrDispBuyrDtlPartVO customMnrDispBuyrDtlPartVO = (CustomMnrDispBuyrDtlPartVO)arrCustomMnrDispBuyrDtlPartVOS[x].clone();  
								customMnrDispBuyrDtlPartVO.setDispDtlSeq(customMnrDispDtlVOS.size() + 1 + "");
								customMnrDispBuyrDtlPartVOS.add(customMnrDispBuyrDtlPartVO);       
									
								//Cofirm 아닌것도 그대로 넣어줌	 	
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
			//디테일 매각 바이어 데이타 삽입   
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
			//바이어 디테일 데이타 삽입 
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
	 * [EES_MNR_0157]Disposal Request의 정보를 추가/수정/삭제 합니다. <br>
	 *
	 * @param DisposalGRPVO disposalGRPVO
	 * @param SignOnUserAccount account
	 * @return DisposalGRPVO
	 * @exception EventException
	 */   
	@SuppressWarnings("unused")
	public DisposalGRPVO manageDisposalBasic(DisposalGRPVO disposalGRPVO, SignOnUserAccount account) throws EventException{
		try {		
			CustomMnrDispHdrVO customMnrDispHdrVO = disposalGRPVO.getCustomMnrDispHdrVO();
			
			CustomMnrDispDtlVO[] arrCustomMnrDispDtlVOS = disposalGRPVO.getArrCustomMnrDispDtlVOS(); 
			CustomMnrDispBuyerPartVO[] arrCustomMnrDispBuyerPartVOS = disposalGRPVO.getArrCustomMnrDispBuyerPartVOS(); 
			
			//공통의로 필요한것 
			customMnrDispHdrVO.setCreUsrId(account.getUsr_id());
			customMnrDispHdrVO.setUpdUsrId(account.getUsr_id());
			
			//해당 키값이 오지 않았다면 NEW를 통해 온것 
			if(customMnrDispHdrVO.getDispNo().equals("NEW")){  	
				String dispNo = dbDao.searchDisposalSeqData(account.getOfc_cd());  
				customMnrDispHdrVO.setDispNo(dispNo); 
			} else {	
				//조회한 데이타를 수정을 하는경우  기존거 삭제  	
				//헤더 기존 데이타 삭제    	
				dbDao.removeDisposalHRDData(customMnrDispHdrVO);
				//디테일 기존 데이타 삭제  
				dbDao.removeDisposalDTLData(customMnrDispHdrVO);
				//Buyer 기존 데이타 삭제  
				dbDao.removeDisposalBuyerHRDData(customMnrDispHdrVO);
			} 	 
			      
			//Request or Save 면    
			if(customMnrDispHdrVO.getDispStsCd().equals("HR") || customMnrDispHdrVO.getDispStsCd().equals("HS")){
				customMnrDispHdrVO.setRqstOfcCd(account.getOfc_cd()); 
				customMnrDispHdrVO.setRqstUsrId(account.getUsr_id()); 
			//Approval 면 
			} else if(customMnrDispHdrVO.getDispStsCd().equals("HA")){ 
				java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyyMMddHHmmss");
				String today = formatter.format(new java.util.Date()); 
				customMnrDispHdrVO.setAproDt(today);      
				customMnrDispHdrVO.setAproUsrId(account.getUsr_id());
			}
			
			// Disposal Type 이 없는 경우 입력되지 않도록 로직 처리함, 2014-04-30, 신용찬
			// Curr Code, Aprroval Office Code 없는 경우 입력되지 않도록 로직 처리함, 2015-06-16, 신용찬			
			String disp_tp_cd = customMnrDispHdrVO.getDispTpCd(); 
			String curr_cd    = customMnrDispHdrVO.getCurrCd(); 
			String apro_ofc_cd= customMnrDispHdrVO.getAproOfcCd(); 
			log.debug("\n---------------------- manageDisposalBasic Disposal Type   : " + disp_tp_cd);
			log.debug("\n---------------------- manageDisposalBasic Curr Code       : " + curr_cd);
			log.debug("\n---------------------- manageDisposalBasic Approval Office : " + apro_ofc_cd);
			
			if(disp_tp_cd==null || disp_tp_cd.equals("")) {  // Please select {?msg1} data.
				throw new EventException(new ErrorHandler("MNR00036", new String[]{"Disposal Type"}).getMessage());
			}else if (curr_cd==null || curr_cd.equals("")) {  // Please select {?msg1} data.
				throw new EventException(new ErrorHandler("MNR00036", new String[]{"Currency Code"}).getMessage());
			}else if(apro_ofc_cd==null || apro_ofc_cd.equals("")) {  // Please select {?msg1} data.
				throw new EventException(new ErrorHandler("MNR00036", new String[]{"Approval Office Code"}).getMessage());
			}					
				
			dbDao.addDisposalHRDData(customMnrDispHdrVO);   
			
			//디테일 뉴 데이타 삽입 
			boolean byerInputFlag = false;
			
			if(arrCustomMnrDispDtlVOS != null){ 
				//Cofirm 이고 Contract 일경우 
				String mnrPrnrCntCd = "";
				String mnrPrnrSeq = "";
				if(customMnrDispHdrVO.getDispStsCd().equals("HC") && customMnrDispHdrVO.getDispTpCd().equals("C") && arrCustomMnrDispBuyerPartVOS.length > 0){
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
				
			//DTL의 합계를 HRD에 입력한다.  Contract-> Confirm의 경우   addDisposalCofirmSumBasic에서 한번더 수행
			dbDao.modifyDisposalHDRSumData(customMnrDispHdrVO);
			
			//디테일 매각 바이어 데이타 삽입   
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
	 * [EES_MNR_0159]Disposal Request의 정보를 삭제 합니다. <br>
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
			//dbDao.removeDisposalHRDData(customMnrDispHdrVO);      
			//dbDao.removeDisposalDTLData(customMnrDispHdrVO);     
			//dbDao.removeDisposalBuyerHRDData(customMnrDispHdrVO); 
			//dbDao.removeDisposalBuyerDTLData(customMnrDispHdrVO);   	 
			return disposalGRPVO;	
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal Request] removeDisposalBasic"}).getMessage(),de);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal Request] removeDisposalBasic"}).getMessage(),de);
		} 
	}  
	
	/**
	 * [EES_MNR_0157]Disposal Request의 정보를 추가 합니다. <br>
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
	 * [EES_MNR0160] Retrive. <br>
	 * Disposal Sold Creation 의 Header 리스트를 조회합니다.
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
	 * [EES_MNR_0160]Disposal Sold Creation의 정보를 조회 합니다. <br>
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
			 
			//Buyer 리스트 조회 
			int iBuyerUpdate = 0;  
			List<List<CustomMnrDispBuyrDtlPartVO>> listCustomMnrDispBuyrDtlPartVOS = new ArrayList<List<CustomMnrDispBuyrDtlPartVO>>(); 	 
			for(int i=0; i<listCustomMnrDispDtlVO.size(); i++) {
				String chkDispNo 		= listCustomMnrDispDtlVO.get(i).getDispNo();
				String sDispDtlSeq	= listCustomMnrDispDtlVO.get(i).getDispDtlSeq();
				List<CustomMnrDispBuyrDtlPartVO> listCustomMnrDispBuyrDtlPartVO =  new ArrayList<CustomMnrDispBuyrDtlPartVO>();
				listCustomMnrDispBuyrDtlPartVO = dbDao.searchDispBuyrDtlPartData(chkDispNo, sDispDtlSeq);
				listCustomMnrDispBuyrDtlPartVOS.add(listCustomMnrDispBuyrDtlPartVO);
				//Buyer 업데이트 체크
				int iDispQty = Integer.parseInt(listCustomMnrDispDtlVO.get(i).getDispQty());
				if(iDispQty > 1) {
					iBuyerUpdate = 1; 
				}
			}
				
			//쪼개지지 않은 DTL QTY가 존재 할때만     
			if(iBuyerUpdate > 0) {
				CustomMnrDispHdrVO customMnrDispHdrVO = new CustomMnrDispHdrVO();
				customMnrDispHdrVO.setDispNo(listCustomMnrDispDtlVO.get(0).getDispNo());
	    		dbDao.removeDisposalBuyerDTLData(customMnrDispHdrVO);   
	    		
				//조회결과  리스트 재구성 시작///////////////////////////////////////////////////////////////
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
			    	//********************** invAmt 도 쪼개주어야 한다. ********************** //
			    	String invAmt			= listCustomMnrDispDtlVO.get(i).getInvAmt();
			    	if(!invAmt.equals("")){  
			    		double realInvAmt = Double.parseDouble(invAmt) / iDispQty;  
				    	invAmt = String.format("%.2f", realInvAmt);  
			    	} 
			    	//********************** invAmt 도 쪼개주어야 한다. ********************** //
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
			    	String dispTpNm			= listCustomMnrDispDtlVO.get(i).getDispTpNm();
			    	String currCd			= listCustomMnrDispDtlVO.get(i).getCurrCd();
			    	
			    	List<CustomMnrDispBuyrDtlPartVO> customMnrDispBuyrDtlPartVOS = listCustomMnrDispBuyrDtlPartVOS.get(i);
				    for(int j=0; j<iDispQty; j++) {
				    	CustomMnrDispDtlVO tempCustomMnrDispDtlVO = new CustomMnrDispDtlVO();
				    	tempCustomMnrDispDtlVO.setDispNo(dispNo);
				    	tempCustomMnrDispDtlVO.setDispDtlSeq((iDispDtlSeq+1)+"");
				    	
				    	// Buyer insert Start /////////////////////////////////
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
				    	// Buyer insert End ///////////////////////////////////// 
				    		
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
				    	tempCustomMnrDispDtlVO.setDispTpNm(dispTpNm);
				    	tempCustomMnrDispDtlVO.setCurrCd(currCd);
				    	
				    	newlistCustomMnrDispDtlVO.add(tempCustomMnrDispDtlVO);
				    		
				    	iDispDtlSeq++; 
				    }
				}
				//조회결과  리스트 재구성 끝///////////////////////////////////////////////////////////////
			
				//조회결과 리스트  최초 재구성시 저장실행 시작//////////////////////////////////////////////////////
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
					
				//DISP_NO로 DETAIL 전부 삭제 
				if ( deleteVoList.size() > 0 ) {	
					dbDao.removeDisposalSoldDetailData(deleteVoList);
			    }	
					
				if ( updateVoList.size() > 0 ) { 
					dbDao.addDisposalSoldDetailData(updateVoList);
				}
				
				//쪼깻으므로 써머리를 다시 구한다.    
				dbDao.modifyDisposalDetailAmountData(customMnrDispHdrVO);
				dbDao.modifyDisposalHDRSumData(customMnrDispHdrVO); 
			}
			
            //조회결과 리스트  최초 재구성시 저장실행 끝//////////////////////////////////////////////////////
			//박명신 수정 11-23 해당 벤더 시퀸스만 조회	       
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
	 * [EES_MNR0251] Sold Cancellation 의 Detail Information 리스트를 조회합니다. <br>
	 * 
	 * @param DisposalSoldINVO disposalSoldINVO
	 * @return List<CustomMnrDispCancelVO>
	 * @exception EventException
	 */
	public List<CustomMnrDispCancelVO> searchDisposalSoldCancelListBasic(DisposalSoldINVO disposalSoldINVO) throws EventException {
		try {
			return dbDao.searchDisposalSoldCancelListData(disposalSoldINVO); 
		} catch (DAOException ex) {            
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Sold Cancellation] searchDisposalSoldCancelListBasic"}).getMessage(),ex);
		} catch (Exception ex) {            
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Sold Cancellation] searchDisposalSoldCancelListBasic"}).getMessage(),ex);
		} 
	}	
	
	/**
	 * [EES_MNR_0251] Sold Cancellation의 정보를 저장 합니다. <br>
	 *
	 * @param CustomMnrDispCancelVO customMnrDispCancelVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */	 
	public void manageDisposalSoldCancel(CustomMnrDispCancelVO[] customMnrDispCancelVO, SignOnUserAccount account) throws EventException{
		try {
			List<CustomMnrDispCancelVO> updateVoList = new ArrayList<CustomMnrDispCancelVO>();

			for ( int i=0; i<customMnrDispCancelVO .length; i++ ) {
				if ( customMnrDispCancelVO[i].getIbflag().equals("U")){
					customMnrDispCancelVO[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(customMnrDispCancelVO[i]); 
				}
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modfyDisposalSoldCancelDetail(updateVoList);
			}
			
			dbDao.modifyDisposalSoldCancelForStatus(updateVoList);

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Sold Cancellation] manageDisposalSoldCancel"}).getMessage(),de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Sold Cancellation] manageDisposalSoldCancel"}).getMessage(),de);
		}
	}
	
	/**
	 * [EES_MNR_0163]Disposal Invoice Inquiry의 정보를 조회 합니다. <br>
	 *
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
	 * [EES_MNR_0163]Disposal Invoice Detail의 정보를 조회 합니다. <br>
	 *
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
	 * [EES_MNR_0163]Disposal Invoice Collection의 정보를 조회 합니다. <br>
	 *
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
	 * [EES_MNR_0160]Disposal Sold Creation의 정보를 추가/수정/삭제 합니다. <br>
	 *
	 * @param DisposalSoldGRPVO disposalSoldGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageDisposalSoldBasic(DisposalSoldGRPVO disposalSoldGRPVO, SignOnUserAccount account) throws EventException{
		
		try {
			CustomMnrDispDtlVO[]  arrayCustomMnrDispDtlVO  = disposalSoldGRPVO.getArrayCustomMnrDispDtlVO();
			
			//List<CustomMnrDispDtlVO> deleteVoList   = new ArrayList<CustomMnrDispDtlVO>();
			List<CustomMnrDispDtlVO> updateVoList   = new ArrayList<CustomMnrDispDtlVO>();
			
		    String dispNo = arrayCustomMnrDispDtlVO[0].getDispNo();
		    
			for ( int i=0; i< arrayCustomMnrDispDtlVO.length; i++ ) {
				arrayCustomMnrDispDtlVO[i].setCreUsrId(account.getUsr_id());
				arrayCustomMnrDispDtlVO[i].setUpdUsrId(account.getUsr_id());
				
				//삭제 로직 일단 삭제 2010-06-07     
				if(arrayCustomMnrDispDtlVO[i].getDispSoldDtFlg().equals("N")) {
					arrayCustomMnrDispDtlVO[i].setEqNo("");
					arrayCustomMnrDispDtlVO[i].setDispSoldDt("");
					arrayCustomMnrDispDtlVO[i].setDispRlseNo("");
					arrayCustomMnrDispDtlVO[i].setDispYdCd("");
					updateVoList.add(arrayCustomMnrDispDtlVO[i]);	   
				} else { 		
					updateVoList.add(arrayCustomMnrDispDtlVO[i]);	   
				}						 			
			}			
			/*
			if ( deleteVoList.size() > 0 ) { 			
				dbDao.removeDisposalSoldDetailbyDTLSeqData(deleteVoList);
		    } 	
		    */  		
			if ( updateVoList.size() > 0 ) { 		 
				dbDao.modfyDisposalSoldDetailData(updateVoList);	
			}
			
			//Status 변경 
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
	 * [EES_MNR_0160] Disposal Sold Creation 의 Release No 를 생성 조회 합니다. <br>
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
	 * [EES_MNR_0157,0159]Disposal Comfirm시 추가 Sum작업을 실행<br> 
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
	 * [EES_MNR_0161]Disposal Invoice Issue의 정보를 삭제 합니다. <br>
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
	 * [EES_MNR_0161]Disposal Invoice Issue의 정보를 수정 합니다. 
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
				arrayCustomMnrDispDtlVO[i].setUserOfcCd(account.getOfc_cd());
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
	
	/**
	 * [EES_MNR_0161]Cancelled Disposal Invoice history 정보를 저장한다.  
	 * @param receivableInvoiceGRPVO RCV_INV_SEQ 정보
	 * @throws EventException
	 */
	public void addDisposalHRDCancelledBasic(ReceivableInvoiceGRPVO receivableInvoiceGRPVO) throws EventException{
		try{
		
			dbDao.addDisposalHRDCancelledData(receivableInvoiceGRPVO.getReceivableINVInquiryINVO());	
		
		} catch (DAOException ex) {   	 
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal Invoice Issue] addDisposalHRDCancelledBasic"}).getMessage(), ex);
		} catch (Exception e) { 
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal Invoice Issue] addDisposalHRDCancelledBasic"}).getMessage(), e);
		}  
	}	
	
	/**
	 * [EES_MNR_0161]Cancelled Disposal Invoice history 정보를 저장한다.  
	 * @param receivableInvoiceGRPVO RCV_INV_SEQ 정보
	 * @throws EventException
	 */
	public void addDisposalDTLCancelledBasic(ReceivableInvoiceGRPVO receivableInvoiceGRPVO) throws EventException{
		try{
 			
			dbDao.addDisposalDTLCancelledData(receivableInvoiceGRPVO.getReceivableINVInquiryINVO());	
		
		} catch (DAOException ex) {   	 
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal Invoice Issue] addDisposalDTLCancelledBasic"}).getMessage(), ex);
		} catch (Exception e) { 
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal Invoice Issue] addDisposalDTLCancelledBasic"}).getMessage(), e);
		}  
	}	
	
	/**
	 * [EES_MNR_0256]Disposal Cancelled Invoice Inquiry의 정보를 조회 합니다. <br>
	 *
	 * @param DisposalInquiryGRPVO disposalInquiryGRPVO
	 * @return DisposalInquiryGRPVO
	 * @exception EventException
	 */
	public DisposalInquiryGRPVO searchDisposalCancelledInquiryListBasic(DisposalInquiryGRPVO disposalInquiryGRPVO) throws EventException {
		try {    
				List<CustomMnrRcvInvWrkVO> customMnrRcvInvWrkVOs = new ArrayList<CustomMnrRcvInvWrkVO>(); 
				customMnrRcvInvWrkVOs = dbDao.searchDisposalCancelledInquiryListData(disposalInquiryGRPVO.getDisposalInquiryINVO());
				disposalInquiryGRPVO.setCustomMnrRcvInvWrkVOs(customMnrRcvInvWrkVOs); 
				return disposalInquiryGRPVO; 
		} catch (DAOException ex) {            
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal Invoice Inquiry] searchDisposalCancelledInquiryListBasic"}). getMessage(),ex); 
		} catch (Exception ex) {            
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal Invoice Inquiry] searchDisposalCancelledInquiryListBasic"}). getMessage(),ex); 
		} 
	} 	
		
	/**
	 * [EES_MNR_0256]Disposal Cancelled Invoice Detail의 정보를 조회 합니다. <br>
	 *
	 * @param DisposalInquiryGRPVO disposalInquiryGRPVO
	 * @return DisposalInquiryGRPVO
	 * @exception EventException
	 */
	public DisposalInquiryGRPVO searchDisposalDetailCancelledInquiryListBasic(DisposalInquiryGRPVO disposalInquiryGRPVO) throws EventException {
		try {    
				List<CustomDispInvDtIVO> customDispInvDtIVOs = new ArrayList<CustomDispInvDtIVO>(); 
				customDispInvDtIVOs = dbDao.searchDisposalDetailCancelledInquiryListData(disposalInquiryGRPVO.getDisposalInquiryINVO());
				disposalInquiryGRPVO.setCustomDispInvDtIVOs(customDispInvDtIVOs); 
				return disposalInquiryGRPVO; 
		} catch (DAOException ex) {            
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal Invoice Inquiry] searchDisposalDetailCancelledInquiryListBasic"}).getMessage(),ex); 
		} catch (Exception ex) {            
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal Invoice Inquiry] searchDisposalDetailCancelledInquiryListBasic"}).getMessage(),ex); 
		} 
	}	

	/**
	 * [EES_MNR_0261] Disposal Inquiry 화면에서 not pick-up 된 장비 pop up list를 조회합니다.<br>
	 * 
	 * @param DisposalNVO disposalNVO
	 * @return List<CustomMnrDispNoPickUpVO>
	 * @throws EventException
	 */
	public List<CustomMnrDispNoPickUpVO> searchDisposalNoPickUpListBasic(DisposalNVO disposalNVO) throws EventException{
		try {
			return dbDao.searchDisposalNoPickUpListData(disposalNVO); 
			
		} catch (DAOException ex) {            
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Not Pick-up Container No] searchDisposalNoPickUpListBasic"}).getMessage(),ex);
		} catch (Exception ex) {            
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Not Pick-up Container No] searchDisposalNoPickUpListBasic"}).getMessage(),ex);
		} 	
	}
	
	/**
	 * [EES_MNR_0159]Disposal No 정보를 체크합니다. <br>
	 *
	 * @param DisposalGRPVO disposalGRPVO
	 * @return DisposalGRPVO
	 * @exception EventException
	 */
	@Override
	public DisposalGRPVO searchVerifyDisposalNoBasic(DisposalGRPVO disposalGRPVO)
			throws EventException {
		try {    
			List<CustomMnrDispHdrVO> list = new ArrayList<CustomMnrDispHdrVO>();
			List<CustomMnrDispHdrVO> result = new ArrayList<CustomMnrDispHdrVO>();
			DisposalNVO disposalINVO = new DisposalNVO();
			
			
			String[] dispNos = disposalGRPVO.getDisposalNVO().getDispNoList().split(",");
			for(int i = 0; i <dispNos.length; i++){
				CustomMnrDispHdrVO temp = new CustomMnrDispHdrVO();
				disposalINVO.setDispNoList(dispNos[i]);
				list = dbDao.searchVerifyDisposalNoData(disposalINVO);
				if(list.size() == 0 || list == null){
					temp.setDispNo(dispNos[i]);
					result.add(temp);
				}
			}
			
			disposalGRPVO.setCustomMnrDispHdrVOS(result); 
			return disposalGRPVO;
		} catch (DAOException ex) {            
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal Verify] searchVerifyDisposalNoBasic"}).getMessage(),ex); 
		} catch (Exception ex) {            
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal Verify] searchVerifyDisposalNoBasic"}).getMessage(),ex); 
		} 	
	}
	
	/**
	 * [EES_MNR_0156]Disposal No 중복체크를 합니다 <br>
	 *
	 * @param DisposalGRPVO disposalGRPVO 
	 * @return DisposalGRPVO
	 * @exception EventException
	 */
	public DisposalGRPVO searchDisposalNoDubChkBasic(DisposalGRPVO disposalGRPVO) throws EventException {
		try {    
				List<CustomMnrDispHdrVO> customMnrDispHdrVOS = new ArrayList<CustomMnrDispHdrVO>();  
				customMnrDispHdrVOS = dbDao.searchDisposalNoDubChkData(disposalGRPVO.getDisposalNVO()); 
				 
				disposalGRPVO.setCustomMnrDispHdrVOS(customMnrDispHdrVOS); 
				return disposalGRPVO; 
		} catch (DAOException ex) {            
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal Request] searchDisposalListBasic"}).getMessage(),ex); 
		} catch (Exception ex) {            
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal Request] searchDisposalListBasic"}).getMessage(),ex); 
		} 
	}

}
