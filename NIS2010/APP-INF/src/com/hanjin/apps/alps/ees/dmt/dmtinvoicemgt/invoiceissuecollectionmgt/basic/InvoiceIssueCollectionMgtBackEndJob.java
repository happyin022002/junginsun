/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtBackEndJob.java
*@FileTitle : Invoice Creation & Issue
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.23
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2009.08.05 김태균
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.basic.ChargeCalculationBC;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.basic.ChargeCalculationBCImpl;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.ChargeBookingInvoiceVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.ConfirmChargeListVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.DmtInvMnVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.InvoiceGroupMgtVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.InvoiceGroupParamVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.InvoiceIssueMgtVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.InvoiceIssueVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.IssuedInvoiceParamVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.layer.backend.BackEndCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * It's InvoiceIssueCollectionMgtBackEndJob.java
 * @author 김태균
 * @see BackEndCommandSupport
 * @since J2EE 1.6
 * 2010.02.23
 */

public class InvoiceIssueCollectionMgtBackEndJob extends BackEndCommandSupport {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 3268528797245615253L;

	// Login User Information
	private SignOnUserAccount account = null;
	
	private InvoiceGroupParamVO invoiceGroupParamVO = null;
	
	private ConfirmChargeListVO[] confirmChargeListVOs = null;
	
	private InvoiceIssueCollectionMgtBC command = null;
	
	private ChargeCalculationBC commandChrge = null;
	
	private String jobCommand = ""; 
	
	public InvoiceIssueCollectionMgtBackEndJob () {
		command = new InvoiceIssueCollectionMgtBCImpl();
		commandChrge = new ChargeCalculationBCImpl();
		
	}

	/**
	 * Group Invoice를 저장하는 BackEnd Job 으로 실행후 결과를 반환합니다.<br>
	 * 
	 * @return Object
	 * @exception Exception
	 */
	public Object doStart() throws Exception {
		
		InvoiceGroupMgtVO invoiceGroupMgtVO = new InvoiceGroupMgtVO();
        List<InvoiceIssueVO> chargeList = new ArrayList<InvoiceIssueVO>();
        
    	final String CHECKED = "1";
    	
    	// 서버 에러메시지
    	StringBuffer sbErrMsg = new StringBuffer();    	
    	
        try {
	    	//===================================================================================================================
	    	// 1. DMT Booking Container VVD 갱신
	    	//===================================================================================================================
        	log.debug("\n\n[ GROUP INVOICE ][ CREATION ] 1. UPDATE VVD INFO. FOR BOOKING CONTAINER\n\n");
        	modifyVslOfChgBkgCntr();
        		
        	
	    	//==================================================================================================================
	    	// 2. Invoice 생성시 입력한 Payer 정보가 DMT Payer 정보에 등록되어 있지 않은 경우 등록해 줍니다.
	    	//==================================================================================================================
	    	log.debug("\n\n[ GROUP INVOICE ][ CREATION ] 2. REGIST PAYER !! (Payer Code :: " + invoiceGroupParamVO.getPayerCd() + ")\n\n");
            if (!command.checkPayerAndSave(invoiceGroupParamVO.getPayerCd(), account)) {
            	throw new Exception("Error! - Payer Check and Save");
            }
            
            
            //==================================================================================================================
	    	// 3. Invoice 생성 및 후 처리
	    	//==================================================================================================================
	    	log.debug("\n\n[ GROUP INVOICE ][ CREATION ] 3. Invoice 생성 및 후 처리\n\n");            
			invoiceGroupMgtVO = command.issueInvoiceByGroup(invoiceGroupParamVO, confirmChargeListVOs, account);
			
			log.debug("\n\n[ GROUP INVOICE ][ CREATION ] 3-1) Invoice 생성 후 결과 :: " + invoiceGroupMgtVO.getInvoiceGroupParamVO().getErrCode() + "\n\n");            
			// 1) Invoice 생성 성공여부에 따른 후 처리
			if (StringUtils.isEmpty(invoiceGroupMgtVO.getInvoiceGroupParamVO().getErrCode())) {
			
	            // 0> INVOICE 발행에 대한 메시지
	    		sbErrMsg.append(new ErrorHandler("DMT03064").getUserMessage());				
				
				// 1> 발행된 Invoice No. 를 Charge 에 매핑해서 결과를 반환한다.
				chargeList = command.searchChargeBookingGroupInvoiceDetail(invoiceGroupMgtVO);
				// 2> Charge 상태를 Invoice 로 변환한다.
				commandChrge.changeChargeStatusForInvoiceByGroup(chargeList, account);
				
				// 3> Auto A/R I/F 대상인지 여부 조회
	    		String autoArIfYn = command.searchAutoARInfYnByOffice(account.getOfc_cd());
	    		invoiceGroupMgtVO.getInvoiceGroupParamVO().setAutoArIfYn(autoArIfYn);
	    		log.debug("\n\n[ GROUP INVOICE ][ CREATION ] 3-3) Auto A/R I/F 대상인지 여부 조회 :: " + autoArIfYn + "\n\n");
	    		
	    		// 4> Auto A/R I/F 대상일 경우
	    		if ("Y".equals(autoArIfYn)) {

	    			// Invoice No. 목록을 전송합니다.
	    			int invoiceCnt = 0;
	    			StringBuilder invoiceNos = new StringBuilder(); 
	    			for (InvoiceIssueVO invoiceIssueVO : chargeList) {
	    				if (invoiceNos.indexOf(invoiceIssueVO.getDmdtInvNo()) == -1) {
	    					if (invoiceNos.length() > 0) invoiceNos.append(",");
	    					invoiceNos.append(invoiceIssueVO.getDmdtInvNo());
	    					invoiceCnt++;
	    				}
	    			}
	    			
	    			DmtInvMnVO dmtInvMnVO = new DmtInvMnVO();
	    			dmtInvMnVO.setDmdtInvNo(invoiceNos.toString());
	    			dmtInvMnVO.setCreOfcCd(account.getOfc_cd());
	    			
		    		// Auto A/R I/F 대상인 경우, A/R I/F 실행
		    		boolean isResult = command.sendInvoiceToAr(dmtInvMnVO, account);
		    		log.debug("\n\n[ GROUP INVOICE ][ CREATION ] 4) Auto A/R I/F 실행 결과 :: " + (isResult ? "SUCCESS" : "FAIL") + "\n\n");
		    		
		    		// Auto A/R I/F 처리가 성공한 경우, A/R I/F 여부를 설정한다.
		    		if (isResult) {
		    			for (ConfirmChargeListVO cfmChgListVO : invoiceGroupMgtVO.getConfirmChargeListVOs()) {
		    				if (CHECKED.equals(cfmChgListVO.getCheckBox())) cfmChgListVO.setDmdtArIfCd("Y");
		    			}
		    			
		    			//---------------------------------------------------------------------------------------
		    			// 성공할 경우, 사용자 화면에 보여줄 메시지
		    			//---------------------------------------------------------------------------------------
		    			sbErrMsg.setLength(0);
			    		String msg = new ErrorHandler("DMT03067").getUserMessage();
			    		msg = msg.replaceAll("\\$1", String.valueOf(invoiceCnt)); // 전체 Count
			    		msg = msg.replaceAll("\\$2", String.valueOf(invoiceCnt)); // 성공 Count
			    		msg = msg.replaceAll("\\$3", "0"); 						  // 실패 Count
			    		sbErrMsg.append(msg.replaceAll("XXX123456", ""));
		    			//---------------------------------------------------------------------------------------
		    		}
		    		// Auto A/R I/F 처리에 실패한 경우(트랜잭션 Rollback 처리를 위해서 업무예외를 발생시킨다.)
		    		else {
		    			throw new EventException(dmtInvMnVO.getErrMsg());		    				
		    		}
	    		}
	    		
	    		// Group Invoice 발행에 성공한 경우, 사용자에게 보여줄 메시지
	    		invoiceGroupMgtVO.getInvoiceGroupParamVO().setErrMsg(sbErrMsg.toString());	    		
			}
			else {
				log.error("A system problem occurred while creating the invoice ( DMT04002 )");
				throw new EventException(new ErrorHandler("DMT04002").getUserMessage()); //A system problem occurred while creating the invoice
			}
        }
        catch(EventException ex) {
        	log.error(ex.getMessage(),ex);
        	throw ex;
        }
        catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(ex.getMessage()); //A system problem occurred while creating the invoice
		}
        
        return invoiceGroupMgtVO;
	}
	
	
	// CSR #XXXX Invoiced DEM/DET data auto Interface to ERP
	private void modifyVslOfChgBkgCntr() throws Exception {
		
        final String BKG_NO = "1";

    	InvoiceIssueMgtVO invoiceIssueMgtVO = new InvoiceIssueMgtVO();
    	List<InvoiceIssueVO> invoiceIssueList = new ArrayList<InvoiceIssueVO>();
    	IssuedInvoiceParamVO issuedInvoiceParamVO = new IssuedInvoiceParamVO();
    	
    	Map<String, ChargeBookingInvoiceVO> dupChkList = new HashMap<String, ChargeBookingInvoiceVO>();
		
		for (ConfirmChargeListVO cfmChgListVO : confirmChargeListVOs) {
			
			// 1. << Group By BKG No. >> 인 경우 CNTR 정보가 존재하지 않기 때문에, CNTR 목록을 조회해야 한다. 
        	if (BKG_NO.equals(invoiceGroupParamVO.getSGroupBy())) {	// CNTR 정보가 존재하지 않음. BKG NO. 로 CNTR 조회를 실행.
			
    			String dupChk = cfmChgListVO.getBkgNo().concat("||").concat(cfmChgListVO.getDmdtTrfCd()).concat("||").concat(cfmChgListVO.getOfcCd());
    			
    			// 중복된 정보가 존재하지 않은 경우
    			if (!dupChkList.containsKey(dupChk)) {
    				
    				// CNTR 목록 조회를 위한 조회조건 설정
	                issuedInvoiceParamVO.setSBkgNo(cfmChgListVO.getBkgNo());
	                issuedInvoiceParamVO.setSDmdtTrfCd(cfmChgListVO.getDmdtTrfCd());
	                issuedInvoiceParamVO.setSOfcCd(cfmChgListVO.getOfcCd());
	                issuedInvoiceParamVO.setSChgType("");
	                issuedInvoiceParamVO.setDmdtChgStsCds("C");
	                
	                // CNTR 목록 조회
	                invoiceIssueList = command.searchChargeBookingInvoiceDetail(issuedInvoiceParamVO);
	                
	                // CNTR 목록 조회 결과 후 처리.
	                if (invoiceIssueList != null && invoiceIssueList.size() > 0) {
		                invoiceIssueMgtVO.setInvoiceIssueList(invoiceIssueList);
		                
		                ChargeBookingInvoiceVO chargeBookingInvoiceVO = new ChargeBookingInvoiceVO();
		                chargeBookingInvoiceVO.setBkgNo(cfmChgListVO.getBkgNo());
		                chargeBookingInvoiceVO.setPolCd(cfmChgListVO.getPolCd());
		                chargeBookingInvoiceVO.setPodCd(cfmChgListVO.getPodCd());
		                chargeBookingInvoiceVO.setDmdtTrfCd(cfmChgListVO.getDmdtTrfCd());
		                invoiceIssueMgtVO.setChargeBookingInvoiceVO(chargeBookingInvoiceVO);
		                
		                // VVD 정보 갱신함.
		                command.modifyVslOfChgBkgCntr(invoiceIssueMgtVO);
		                
		                cfmChgListVO.setVslCd(chargeBookingInvoiceVO.getVslCd());
		                cfmChgListVO.setSkdVoyNo(chargeBookingInvoiceVO.getSkdVoyNo());
		                cfmChgListVO.setSkdDirCd(chargeBookingInvoiceVO.getSkdDirCd());
		                
		                dupChkList.put(dupChk, chargeBookingInvoiceVO);
	                }
    			}
    			// 중복된 정보가 존재하는 경우
    			else {
    				ChargeBookingInvoiceVO chargeBookingInvoiceVO = dupChkList.get(dupChk);
    				
	                cfmChgListVO.setVslCd(chargeBookingInvoiceVO.getVslCd());
	                cfmChgListVO.setSkdVoyNo(chargeBookingInvoiceVO.getSkdVoyNo());
	                cfmChgListVO.setSkdDirCd(chargeBookingInvoiceVO.getSkdDirCd());        				
    			}
        	}
			// 2. << Group By CNTR No. >> 인 경우 CNTR 정보가 존재하기 때문에, 따로 CNTR 목록을 조회해야 될 필요성이 없다.
        	else {
        		InvoiceIssueVO invoiceIssueVO = new InvoiceIssueVO();
        		invoiceIssueVO.setDmdtChgLocDivCd(cfmChgListVO.getDmdtChgLocDivCd());
        		invoiceIssueList = new ArrayList<InvoiceIssueVO>();
        		invoiceIssueList.add(invoiceIssueVO);
        		invoiceIssueMgtVO.setInvoiceIssueList(invoiceIssueList);
        		
                ChargeBookingInvoiceVO chargeBookingInvoiceVO = new ChargeBookingInvoiceVO();
                chargeBookingInvoiceVO.setBkgNo(cfmChgListVO.getBkgNo());
                chargeBookingInvoiceVO.setPolCd(cfmChgListVO.getPolCd());
                chargeBookingInvoiceVO.setPodCd(cfmChgListVO.getPodCd());
                chargeBookingInvoiceVO.setDmdtTrfCd(cfmChgListVO.getDmdtTrfCd());
                invoiceIssueMgtVO.setChargeBookingInvoiceVO(chargeBookingInvoiceVO);
        		
                // VVD 정보 갱신함.
                command.modifyVslOfChgBkgCntr(invoiceIssueMgtVO);
                
                cfmChgListVO.setVslCd(chargeBookingInvoiceVO.getVslCd());
                cfmChgListVO.setSkdVoyNo(chargeBookingInvoiceVO.getSkdVoyNo());
                cfmChgListVO.setSkdDirCd(chargeBookingInvoiceVO.getSkdDirCd());                  
        	}
		}		
	}
	
//	/**
//	 * Group Invoice를 저장하는 BackEnd Job 으로 실행후 결과를 반환합니다.<br>
//	 * 
//	 * @return Object
//	 * @exception Exception
//	 */
//	public Object doStart() throws Exception {
//		
//		InvoiceGroupMgtVO invoiceGroupMgtVO = new InvoiceGroupMgtVO();
//        List<InvoiceIssueVO> chargeList			= null;
//        List<VVDCheckDataVO> vVDCheckDataVOs = null;
//        String resultMsg = null;
//        
//        try{
//            ///////////////////////////////////////////////////////////////////////////////////////////////
//            //DMDT_CHG_LOC_DIV_CD의 값이 'TSP', 'SZP' 가 아니면, searchVVDNEta를 CALL하여 VVD CD를 Setting한다.
//            ///////////////////////////////////////////////////////////////////////////////////////////////
//        	vVDCheckDataVOs = command.searchChargeBookingGroupInvoiceVVDDetail(invoiceGroupParamVO, confirmChargeListVOs);
//        	for( int i = 0; i < vVDCheckDataVOs.size(); i++) {
//        		VVDCheckDataVO vVDCheckDataVO = (VVDCheckDataVO) vVDCheckDataVOs.get(i);
//        		
//        		//처음에는 무조건 저장한다.
//        		if(i == 0) {
//        			commandChrge.modifyBookingContainerVVD(vVDCheckDataVO);	//DMT_CHG_BKG_CNTR update
//        		}
//        		//동일한 값이 존재하면 SKIP
//        		boolean checkflag = false;
//        		for( int j = i; j > 0; j--) {
//        			VVDCheckDataVO vVDCheckDataVO2 = (VVDCheckDataVO) vVDCheckDataVOs.get(j);
//        			//같은 데이터는 skip
//        			if(vVDCheckDataVO.getBkgNo().equals(vVDCheckDataVO2.getBkgNo()) && vVDCheckDataVO.getPodCd().equals(vVDCheckDataVO2.getPodCd())
//        					&& vVDCheckDataVO.getPolCd().equals(vVDCheckDataVO2.getPolCd()) && vVDCheckDataVO.getIoBnd().equals(vVDCheckDataVO2.getIoBnd()))
//        			{
//        				checkflag = true;
//        				break;
//        			}
//        		}
//        		if(!checkflag){
//        			commandChrge.modifyBookingContainerVVD(vVDCheckDataVO);	//DMT_CHG_BKG_CNTR update
//        		}
//        	}
//       		confirmChargeListVOs = command.searchIssueInvoiceByGroupVVD(invoiceGroupParamVO, confirmChargeListVOs);
//            ///////////////////////////////////////////////////////////////////////////////////////////////
//       		
//        	//invoice group save
//			invoiceGroupMgtVO = command.issueInvoiceByGroup(invoiceGroupParamVO, confirmChargeListVOs, account);
//			
//	        if(!invoiceGroupMgtVO.getInvoiceGroupParamVO().getErrCode().equals("")) {//사용자 에러 메시지 발생
//	        	//resultMsg = new ErrorHandler(invoiceGroupMgtVO.getInvoiceGroupParamVO().getErrCode()).getUserMessage();
//	        	resultMsg = invoiceGroupMgtVO.getInvoiceGroupParamVO().getErrMsg();
//	        	throw new EventException(resultMsg);
//	        }else{
//	        	//charge에 전달할 데이터를 생성한다.
//            	chargeList = command.searchChargeBookingGroupInvoiceDetail(invoiceGroupMgtVO);
//            	
//                //charge status 변경
//            	commandChrge.changeChargeStatusForInvoiceByGroup(chargeList, account);
//	        }
//        }catch(Exception ex){
//			log.error(ex.getMessage(),ex);
//			throw ex;
//		}
//        return invoiceGroupMgtVO;
//	}

	public InvoiceGroupParamVO getInvoiceGroupParamVO() {
		return invoiceGroupParamVO;
	}

	public void setInvoiceGroupParamVO(InvoiceGroupParamVO invoiceGroupParamVO) {
		this.invoiceGroupParamVO = invoiceGroupParamVO;
	}

	public ConfirmChargeListVO[] getConfirmChargeListVOs() {
		return confirmChargeListVOs;
	}

	public void setConfirmChargeListVOs(ConfirmChargeListVO[] confirmChargeListVOs) {
		this.confirmChargeListVOs = confirmChargeListVOs;
	}

	public SignOnUserAccount getSignOnUserAccount() {
		return account;
	}

	public void setSignOnUserAccount(SignOnUserAccount account) {
		this.account = account;
	}

	public String getJobCommand() {
		return jobCommand;
	}

	public void setJobCommand(String jobCommand) {
		this.jobCommand = jobCommand;
	}
}
