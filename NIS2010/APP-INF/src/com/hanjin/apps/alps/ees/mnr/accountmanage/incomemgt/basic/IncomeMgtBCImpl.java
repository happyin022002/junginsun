/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : IncomeMgtBCImpl.java
*@FileTitle : IncomeMgtBCImpl
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.21
*@LastModifier : 함형석
*@LastVersion : 1.0
* 2009.09.21 함형석
* 1.0 Creation
* --------------------------------------------------------
* History
* 2011.11.21 신혜정 [CHM-201114467-01] Cancelled Disposal Invoice history 저장   
* 2012.04.05 신혜정 [CHM-201217201] Disposal Invoice Issue 화면내 [Confirm], [Cancel] 처리시, invoice no 체크 로직 추가
					  1. [Confirm] 처리시, invoice no 유,무에 따른 체크 로직 추가
					   - invoice no 가 있을 경우 confirm 된 데이타 확인 후 존재시 return 처리
					   - invoice no 가 없을 경우(invoice status=New) Verify List 의 disposal no, eq_no 리스트로 invoice no 존재 확인후 있으면 return 처리
					  2. [Cancel] 처리시, Cancel invoice no 체크 로직 추가
					   - 기 Cancel invoice no 존재시 return 처리
* 2013.07.05 조경완  [CHM-201325280-01] ALPS MNR-Disposal-Invoice 이중 Interface 건 검토/Data 수정 및 로직 검토					   
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.accountmanage.incomemgt.basic;

import java.util.ArrayList;
import java.util.List;
import com.hanjin.apps.alps.ees.mnr.accountmanage.incomemgt.integration.IncomeMgtDBDAO;
import com.hanjin.apps.alps.ees.mnr.accountmanage.incomemgt.vo.CustomReceivableINVInquiryListVO;
import com.hanjin.apps.alps.ees.mnr.accountmanage.incomemgt.vo.CustomReceivableInvoiceDetailINVO;
import com.hanjin.apps.alps.ees.mnr.accountmanage.incomemgt.vo.ReceivableINVInquiryINVO;
import com.hanjin.apps.alps.ees.mnr.accountmanage.incomemgt.vo.ReceivableInvoiceGRPVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.vo.CustomMnrDispDtlVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * alps-AccountManageBusiness Logic Basic Command implementation<br>
 * - alps-AccountManage 에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author HamHyungSeok   
 * @see EesMnr0161Event,IncomeMgtBC 각 DAO 클래스 참조
 * @since J2EE 1.4     
 */         
      
public class IncomeMgtBCImpl extends BasicCommandSupport implements IncomeMgtBC {

	// Database Access Object 
	private transient IncomeMgtDBDAO dbDao = null; 
	 	
	/** 	
	 * IncomeMgtBCImpl 객체 생성<br>
	 * IncomeMgtDBDAO를 생성한다.<br>
	 */    
	public IncomeMgtBCImpl() {  
		dbDao = new IncomeMgtDBDAO(); 
	} 
	
	/**
	 * [EES_MNR_0161 ] 의 정보를 조회 합니다. <br>
	 *
	 * @param ReceivableInvoiceGRPVO receivableInvoiceGRPVO
	 * @param SignOnUserAccount account
	 * @return ReceivableInvoiceGRPVO
	 * @exception EventException
	 */ 
	public ReceivableInvoiceGRPVO searchReceivableInvoiceListBasic(ReceivableInvoiceGRPVO receivableInvoiceGRPVO, SignOnUserAccount account) throws EventException {
		List<CustomReceivableINVInquiryListVO> customReceivableINVInquiryListVO = new ArrayList<CustomReceivableINVInquiryListVO>();  
			
		try {  
 
			receivableInvoiceGRPVO.getReceivableINVInquiryINVO().setUserOfcCd(account.getOfc_cd());
			receivableInvoiceGRPVO.getReceivableINVInquiryINVO().setCreUsrId(account.getUsr_id());
			String kind = receivableInvoiceGRPVO.getReceivableINVInquiryINVO().getInvSchTypeCode();
			
			if(kind.equals("MI")){
				customReceivableINVInquiryListVO = dbDao.searchReceivableInvoiceListByDisposalData(receivableInvoiceGRPVO.getReceivableINVInquiryINVO()); 
			}else if(kind.equals("CO")){
				customReceivableINVInquiryListVO = dbDao.searchReceivableInvoiceListByINVData(receivableInvoiceGRPVO.getReceivableINVInquiryINVO()); 
			}

			receivableInvoiceGRPVO.setCustomReceivableINVInquiryListVOs(customReceivableINVInquiryListVO);
			return receivableInvoiceGRPVO;  
		} catch (DAOException ex) {   	 
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Receivable Invoice List] searchReceivableInvoiceListBasic"}).getMessage(),ex);
		} catch (Exception e) { 
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Receivable Invoice List] searchReceivableInvoiceListBasic"}).getMessage(),e);
		}  
	} 	

	/**
	 * [EES_MNR_0161]Disposal Invoice Issue의 정보를 조회 합니다. <br>
	 *
	 * @param ReceivableInvoiceGRPVO receivableInvoiceGRPVO
	 * @return ReceivableInvoiceGRPVO
	 * @exception EventException
	 */
	public ReceivableInvoiceGRPVO searchReceivableInvoiceDetailListBasic(ReceivableInvoiceGRPVO receivableInvoiceGRPVO) throws EventException {
		List<CustomReceivableInvoiceDetailINVO> customReceivableInvoiceDetailINVOs = new ArrayList<CustomReceivableInvoiceDetailINVO>();  

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
	
			receivableInvoiceGRPVO.setCustomReceivableInvoiceDetailINVOs(customReceivableInvoiceDetailINVOs);
			
			return receivableInvoiceGRPVO;  
		} catch (DAOException ex) {   	 
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal Invoice Issue] searchReceivableInvoiceDetailListBasic"}).getMessage(),ex);
		} catch (Exception e) { 
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal Invoice Issue] searchReceivableInvoiceDetailListBasic"}).getMessage(),e);
		}  
	} 	
	
	/**
	 * [EES_MNR_0161]Disposal Invoice Issue의 정보를 추가/수정/삭제 합니다. <br>
	 *
	 * @param ReceivableInvoiceGRPVO receivableInvoiceGRPVO
	 * @param SignOnUserAccount account
	 * @return ReceivableInvoiceGRPVO
	 * @exception EventException
	 */
	public ReceivableInvoiceGRPVO manageRepairReceivableInvoiceBasic(ReceivableInvoiceGRPVO receivableInvoiceGRPVO, SignOnUserAccount account) throws EventException {
		//List<CustomReceivableInvoiceDetailINVO> customReceivableInvoiceDetailINVO = null;  
		String rcvInvSeq = "";
		String invNo = "";
		
		try {  
			//회사 운영방침에 의거 AR상에서 JKTBA는 더이상 사용하지 않으며, 
			//모든 AR 인보이스는 JKTSC로 변경하여 사용해야한다는 수입관리팀 요청이 있었음
			if(account.getOfc_cd().equalsIgnoreCase("JKTBA")){			
				receivableInvoiceGRPVO.getReceivableINVInquiryINVO().setUserOfcCd("JKTSC");	
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
			
			//2011.06.14
			//객체에 null이 배정된 이후 객체에 대한 참조를 하지 말아야 한다.
			//receivableInvoiceGRPVO.setCustomReceivableInvoiceDetailINVOs(customReceivableInvoiceDetailINVO);
 
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
	 * [EES_MNR_0161]Disposal Invoice Issue의 State 정보를 수정 합니다. <br>
	 *
	 * @param ReceivableInvoiceGRPVO receivableInvoiceGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageRepairReceivableInvoiceStateHsBasic(ReceivableInvoiceGRPVO receivableInvoiceGRPVO, SignOnUserAccount account) throws EventException {

		String invNo = "";
		
		try {  
			//회사 운영방침에 의거 AR상에서 JKTBA는 더이상 사용하지 않으며, 
			//모든 AR 인보이스는 JKTSC로 변경하여 사용해야한다는 수입관리팀 요청이 있었음
			if(account.getOfc_cd().equalsIgnoreCase("JKTBA")){			
				receivableInvoiceGRPVO.getReceivableINVInquiryINVO().setUserOfcCd("JKTSC");	
			} else {
				receivableInvoiceGRPVO.getReceivableINVInquiryINVO().setUserOfcCd(account.getOfc_cd());
			}																	
			receivableInvoiceGRPVO.getReceivableINVInquiryINVO().setCreUsrId(account.getUsr_id());
					
			if(receivableInvoiceGRPVO.getReceivableINVInquiryINVO().getInputInvNo().equals("")){
				invNo = dbDao.searchReceivableInvoiceNoData(receivableInvoiceGRPVO.getReceivableINVInquiryINVO());
				receivableInvoiceGRPVO.getReceivableINVInquiryINVO().setInputInvNo(invNo);
			} 
			
			dbDao.modifyReceivableInvoiceStateHsData(receivableInvoiceGRPVO.getReceivableINVInquiryINVO());
		} catch (DAOException ex) {   	 
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal Invoice Request] manageRepairReceivableInvoiceStateHsBasic"}).getMessage(),ex);
		} catch (Exception e) { 
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal Invoice Request] manageRepairReceivableInvoiceStateHsBasic"}).getMessage(),e);
		}
	} 		
	
	/**
	 * [EES_MNR_0161]Disposal Invoice Issue의 정보를 삭제 합니다. <br>
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
	 * [EES_MNR_0161]Disposal Invoice Issue의 상태정보를 수정 합니다. <br>
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
	
	/**
	 * [EES_MNR_0161]Cancelled Disposal Invoice history 정보를 저장한다.  
	 * @param receivableInvoiceGRPVO RCV_INV_SEQ 정보
	 * @param account 사용자 계정
	 * @throws EventException
	 */
	public void addReceivableInvoiceCancelledBasic(ReceivableInvoiceGRPVO receivableInvoiceGRPVO, SignOnUserAccount account) throws EventException{
		try{
			receivableInvoiceGRPVO.getReceivableINVInquiryINVO().setCreUsrId(account.getUsr_id());
			dbDao.addReceivableInvoiceCancelledData(receivableInvoiceGRPVO.getReceivableINVInquiryINVO());	
		
		} catch (DAOException ex) {   	 
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal Invoice Issue] addReceivableInvoiceCancelledBasic"}).getMessage(), ex);
		} catch (Exception e) { 
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal Invoice Issue] addReceivableInvoiceCancelledBasic"}).getMessage(), e);
		}  
	}

	/**
	 * [EES_MNR_0161]Disposal Invoice Issue 내 Confirm, Cancel 시 invoice no 중복여부를 점검합니다.<br>   
	 *  
	 * @param ReceivableINVInquiryINVO receivableINVInquiryINVO
	 * @return String
	 * @throws EventException
	 */
	public String checkReceivableInvNoBasic(ReceivableINVInquiryINVO receivableINVInquiryINVO) throws EventException{
		try{
			String rtnVal = "";
			int invSum = 0;
			
			rtnVal = dbDao.checkReceivableInvNoData(receivableINVInquiryINVO);	
			if(!"X".equals(rtnVal)&&"HC".equals(receivableINVInquiryINVO.getMnrInvStsCd())){
				invSum = dbDao.checkReceivableInvSumData(receivableINVInquiryINVO);
				if(invSum != 0){
					rtnVal = "N";
				}
			}
			
			return rtnVal;
		} catch (DAOException ex) {   	 
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal Invoice Issue] checkReceivableInvNoBasic"}).getMessage(), ex);
		} catch (Exception e) { 
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal Invoice Issue] checkReceivableInvNoBasic"}).getMessage(), e);
		}  
	}	
	
	/**
	 * [EES_MNR_0161]Disposal Invoice Issue 내 Confirm 시 invoice no 중복여부를 점검합니다.<br>   
	 *   
	 * @param CustomMnrDispDtlVO customMnrDispDtlVO
	 * @return String
	 * @throws EventException
	 */
	public String checkVerifiedInvNoBasic(CustomMnrDispDtlVO customMnrDispDtlVO) throws EventException{
		try{
			String rtnVal = "";
			rtnVal = dbDao.checkVerifiedInvNoData(customMnrDispDtlVO);
			
			return rtnVal;
		} catch (DAOException ex) {   	 
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal Invoice Issue] checkVerifiedInvNoBasic"}).getMessage(), ex);
		} catch (Exception e) { 
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal Invoice Issue] checkVerifiedInvNoBasic"}).getMessage(), e);
		}  
	}		
	
}