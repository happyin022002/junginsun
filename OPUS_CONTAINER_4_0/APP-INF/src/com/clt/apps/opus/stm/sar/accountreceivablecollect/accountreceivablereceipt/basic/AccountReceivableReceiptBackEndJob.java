/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : AccountReceivableReceiptBackEndJob.java
 *@FileTitle : 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015.04.07
 *@LastModifier : SYPARK
 *@LastVersion : 0.1
 * 2015.04.07
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.stm.sap.accountpayableinvoice.AccountPayableInvoiceSC;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.basic.AccountPayableInvoiceBC;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.basic.AccountPayableInvoiceBCImpl;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.SapInvoiceInterfaceDetailVO;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.SapInvoiceInterfaceHeaderVO;
import com.clt.apps.opus.stm.sar.accountreceivableagent.accountreceivableagent.basic.AccountReceivableAgentBCImpl;
import com.clt.apps.opus.stm.sar.accountreceivableagent.accountreceivableagent.vo.ManageAgentCollectionListVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.vo.ApplyDetailVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.vo.ApplyHeaderVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.vo.ReceiptForAPInterfaceVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.vo.ReceiptMainVO;
import com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.basic.AccountReceivableCommonBC;
import com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.basic.AccountReceivableCommonBCImpl;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.layer.backend.BackEndCommandSupport;

/**
 * AccountReceivableReceipt Business Logic Basic Command implementation<br>
 * - AccountReceivableReceipt에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author SYPARK
 * @see AccountReceivableReceiptDBDAO 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class AccountReceivableReceiptBackEndJob extends BackEndCommandSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3466682561927769825L;
	
	
	private String lginUsrId = null;

	private String lginOfcCd = null;
	
	private ReceiptMainVO receiptMainVO = null;
	
	private ApplyHeaderVO[] applyHeaderVOs = null;
	
	private ApplyDetailVO[] applyDetailVOs = null;
	
	public String getLginUsrId() {
		return lginUsrId;
	}

	public void setLginUsrId(String lginUsrId) {
		this.lginUsrId = lginUsrId;
	}

	public String getLginOfcCd() {
		return lginOfcCd;
	}

	public void setLginOfcCd(String lginOfcCd) {
		this.lginOfcCd = lginOfcCd;
	}
	
	public ReceiptMainVO getReceiptMainVO() {
		return receiptMainVO;
	}

	public void setReceiptMainVO(ReceiptMainVO receiptMainVO) {
		this.receiptMainVO = receiptMainVO;
	}
	
	public ApplyHeaderVO[] getApplyHeaderVOs() {
		ApplyHeaderVO[] rtnVOs = null;
		if (this.applyHeaderVOs != null) {
			rtnVOs = new ApplyHeaderVO[applyHeaderVOs.length];
			System.arraycopy(applyHeaderVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setApplyHeaderVOs(ApplyHeaderVO[] applyHeaderVOs) {
		if (applyHeaderVOs != null) {
			ApplyHeaderVO[] tmpVOs = new ApplyHeaderVO[applyHeaderVOs.length];
			System.arraycopy(applyHeaderVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.applyHeaderVOs = tmpVOs;
		}
	}
	
	public ApplyDetailVO[] getApplyDetailVOs() {
		ApplyDetailVO[] rtnVOs = null;
		if (this.applyDetailVOs != null) {
			rtnVOs = new ApplyDetailVO[applyDetailVOs.length];
			System.arraycopy(applyDetailVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setApplyDetailVOs(ApplyDetailVO[] applyDetailVOs) {
		if (applyDetailVOs != null) {
			ApplyDetailVO[] tmpVOs = new ApplyDetailVO[applyDetailVOs.length];
			System.arraycopy(applyDetailVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.applyDetailVOs = tmpVOs;
		}
	}
	
	/**
	 * Receipt BackEndJob process
	 * 
	 * @author SYPARK
	 * @return Object
	 * @exception EventException
	 */

	public Object doStart() throws Exception {
		AccountReceivableReceiptBC command = new AccountReceivableReceiptBCImpl();
		AccountReceivableCommonBC command2 = new AccountReceivableCommonBCImpl();
		AccountPayableInvoiceBC command3 = new AccountPayableInvoiceBCImpl();
		AccountPayableInvoiceSC command4 = new AccountPayableInvoiceSC();
		AccountReceivableAgentBCImpl agtcommand = new AccountReceivableAgentBCImpl();
		
		List<ReceiptForAPInterfaceVO> receiptForAPInterfaceVOs = new ArrayList<ReceiptForAPInterfaceVO>();
		List<SapInvoiceInterfaceHeaderVO> sapInvoiceInterfaceHeaderVOs = new ArrayList<SapInvoiceInterfaceHeaderVO>();
		List<SapInvoiceInterfaceDetailVO> sapInvoiceInterfaceDetailVOs = new ArrayList<SapInvoiceInterfaceDetailVO>();
		
		String rctNo = "";
		String saveKindCd = "";
		String apIFSeq = "";
		String apIfFlg = "";
		
		try {
			
			//Search receipt number
			if(receiptMainVO.getRctSeq().equals("")){
				if(receiptMainVO.getLocalChgFlag().equals("Y")) {
					rctNo = command2.searchAdjustReceiptNoLocalChargeOffice(receiptMainVO.getBoundType(), receiptMainVO.getOtsOfcCd(), lginUsrId, lginOfcCd);
				} else {
					rctNo = command2.searchAdjustReceiptNo("REC", receiptMainVO.getOtsOfcCd(), lginUsrId, lginOfcCd);
				}
				receiptMainVO.setRctNo(rctNo);
			}else{
				rctNo = receiptMainVO.getRctNo();
			}
			
			saveKindCd = receiptMainVO.getSaveKindCd();
			
			if(saveKindCd.equals("S")){		//Process case in saving receipt info
				command.createReceiptApply(receiptMainVO, applyHeaderVOs, applyDetailVOs, lginUsrId);
			} else if(saveKindCd.equals("R")){		//Process case in reversing receipt info
				command.modifyReverseApplyHeader(receiptMainVO, applyHeaderVOs, applyDetailVOs, lginUsrId);
			} else if(saveKindCd.equals("C")){		//Process case in canceling receipt info
				command.modifyReceiptCancel(receiptMainVO, applyHeaderVOs, applyDetailVOs, lginUsrId);
			}
			
			//Search receipt info for AP interface (refund process)
			receiptForAPInterfaceVOs = command.searchReceiptForAPInterface(receiptMainVO, applyHeaderVOs, lginUsrId);
			
			if(receiptForAPInterfaceVOs != null){
				for(int i = 0; i < receiptForAPInterfaceVOs.size(); i++){
					SapInvoiceInterfaceHeaderVO sapInvoiceInterfaceHeaderVO = new SapInvoiceInterfaceHeaderVO();
					SapInvoiceInterfaceDetailVO sapInvoiceInterfaceDetailVO = new SapInvoiceInterfaceDetailVO();
					
					//Search AP invoice interface header sequence
					apIFSeq = command3.searchInoviceHeaderIFNextSeq();
					
					//Set AP invoice interface header info
					sapInvoiceInterfaceHeaderVO.setInvIfSeq(apIFSeq);
					sapInvoiceInterfaceHeaderVO.setInvNo(receiptForAPInterfaceVOs.get(i).getInvNo());
					sapInvoiceInterfaceHeaderVO.setInvTpLuCd(receiptForAPInterfaceVOs.get(i).getInvTpLuCd());
					sapInvoiceInterfaceHeaderVO.setInvDt(receiptForAPInterfaceVOs.get(i).getInvDt());
					sapInvoiceInterfaceHeaderVO.setVndrNo(receiptForAPInterfaceVOs.get(i).getVndrNo());
					sapInvoiceInterfaceHeaderVO.setInvAmt(receiptForAPInterfaceVOs.get(i).getInvAmt());
					sapInvoiceInterfaceHeaderVO.setInvCurrCd(receiptForAPInterfaceVOs.get(i).getInvCurrCd());
					sapInvoiceInterfaceHeaderVO.setInvXchRt(receiptForAPInterfaceVOs.get(i).getInvXchRt());
					sapInvoiceInterfaceHeaderVO.setInvXchRtTpCd(receiptForAPInterfaceVOs.get(i).getInvXchRtTpCd());
					sapInvoiceInterfaceHeaderVO.setInvXchDt(receiptForAPInterfaceVOs.get(i).getInvXchDt());
					sapInvoiceInterfaceHeaderVO.setInvTermNm(receiptForAPInterfaceVOs.get(i).getInvTermNm());
					sapInvoiceInterfaceHeaderVO.setInvDesc(receiptForAPInterfaceVOs.get(i).getInvDesc());
					sapInvoiceInterfaceHeaderVO.setAttrCateNm(receiptForAPInterfaceVOs.get(i).getAttrCateNm());
					sapInvoiceInterfaceHeaderVO.setAttrCtnt4(receiptForAPInterfaceVOs.get(i).getAttrCtnt4());
					sapInvoiceInterfaceHeaderVO.setInvIfStsCd("NEW");
					sapInvoiceInterfaceHeaderVO.setIfSrcNm("AR");
					sapInvoiceInterfaceHeaderVO.setInvPayCurrCd(receiptForAPInterfaceVOs.get(i).getInvCurrCd());
					sapInvoiceInterfaceHeaderVO.setApPayMzdLuCd(receiptForAPInterfaceVOs.get(i).getApPayMzdLuCd());
					sapInvoiceInterfaceHeaderVO.setPayGrpLuCd(receiptForAPInterfaceVOs.get(i).getPayGrpLuCd());
					sapInvoiceInterfaceHeaderVO.setInvRcvDt(receiptForAPInterfaceVOs.get(i).getInvDt());
					sapInvoiceInterfaceHeaderVO.setGlDt(receiptForAPInterfaceVOs.get(i).getGlDt());
					sapInvoiceInterfaceHeaderVO.setOfcCd(receiptForAPInterfaceVOs.get(i).getOfcCd());
					sapInvoiceInterfaceHeaderVO.setInvTermDt(receiptForAPInterfaceVOs.get(i).getInvDt());
					sapInvoiceInterfaceHeaderVO.setUsrId(lginUsrId);
					sapInvoiceInterfaceHeaderVO.setLiabCdCmbSeq(receiptForAPInterfaceVOs.get(i).getLiabCdCmbSeq());
					
					sapInvoiceInterfaceHeaderVOs.add(sapInvoiceInterfaceHeaderVO);
					
					//Set AP invoice interface detail info
					sapInvoiceInterfaceDetailVO.setInvIfSeq(apIFSeq);
					sapInvoiceInterfaceDetailVO.setInvLineNo("1");
					sapInvoiceInterfaceDetailVO.setLineTpLuCd("ITEM");
					sapInvoiceInterfaceDetailVO.setDtrbAmt(receiptForAPInterfaceVOs.get(i).getInvAmt());
					sapInvoiceInterfaceDetailVO.setAcctgDt(receiptForAPInterfaceVOs.get(i).getGlDt());
					sapInvoiceInterfaceDetailVO.setDtrbDesc(receiptForAPInterfaceVOs.get(i).getInvDesc());
					sapInvoiceInterfaceDetailVO.setFnlMtchStsCd("A");
					sapInvoiceInterfaceDetailVO.setAttrCtnt3(receiptForAPInterfaceVOs.get(i).getAttrCtnt3());
					sapInvoiceInterfaceDetailVO.setIfSrcNm("AR");
					sapInvoiceInterfaceDetailVO.setOfcCd(receiptForAPInterfaceVOs.get(i).getOfcCd());
					sapInvoiceInterfaceDetailVO.setUsrId(lginUsrId);
					sapInvoiceInterfaceDetailVO.setDtrbCdCmbSeq(receiptForAPInterfaceVOs.get(i).getDtrbCdCmbSeq());
					sapInvoiceInterfaceDetailVO.setInvNo(receiptForAPInterfaceVOs.get(i).getInvNo());
					sapInvoiceInterfaceDetailVO.setAttrCtnt11(receiptForAPInterfaceVOs.get(i).getAttrCtnt11());
					sapInvoiceInterfaceDetailVO.setAttrCtnt12(receiptForAPInterfaceVOs.get(i).getOfcCd());
					sapInvoiceInterfaceDetailVO.setAttrCtnt14("COM");
					sapInvoiceInterfaceDetailVO.setAttrCtnt1(rctNo);
					
					sapInvoiceInterfaceDetailVOs.add(sapInvoiceInterfaceDetailVO);
					
				}
				
				//Create AP invoice interface header/detail info
				command3.addInvoiceHeaderIF(sapInvoiceInterfaceHeaderVOs);
				command3.addInvoiceLineIF(sapInvoiceInterfaceDetailVOs);
				
				//Update AP interface status code to apply detail table
				command.modifyAPInterfaceStatus(receiptForAPInterfaceVOs, saveKindCd, lginUsrId);
				
			}
			
			//Call AP interface process
			if(receiptForAPInterfaceVOs != null){
				for(int i = 0; i < receiptForAPInterfaceVOs.size(); i++){
					EventResponse apEventResponse = new GeneralEventResponse();
					Map<String, String> mapVO = new HashMap<String, String>();
					
					apEventResponse = command4.manageSapIfValidateImportCheck("A/P", receiptForAPInterfaceVOs.get(i).getInvNo(), lginUsrId);
							
					//Get A/P interface status flag
					mapVO = apEventResponse.getETCData();
					apIfFlg = mapVO.get("SUCCESS_FLG");
					if(apIfFlg.equals("FAIL")){
						throw new EventException(new ErrorHandler("SAR00041", new String[]{mapVO.get("RESULT_MSG")}).getMessage());
					}
				}
			}
			
			//ASA DTL UPDATE
			if(!receiptMainVO.getAsaNo().equals("") && receiptMainVO.getAsaNo() != null){
				agtcommand.updateASADtlForCall(receiptMainVO.getAsaNo(), lginUsrId);
			}
			
		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage()); 
		}
		
		return rctNo;
	}
}