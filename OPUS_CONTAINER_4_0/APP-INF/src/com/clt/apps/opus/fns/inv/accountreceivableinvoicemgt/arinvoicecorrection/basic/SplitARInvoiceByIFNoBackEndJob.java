/*=========================================================
 *Copyright(c) 2016 CyberLogitec
 *@FileName : SplitARInvoiceByIFNoBackEndJob.java
 *@FileTitle : 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2016.07.28
 *@LastModifier : KIMOKRYE
 *@LastVersion : 0.1
 * 2016.07.28
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.basic;

//import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.basic.BookingARCreationBC;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.basic.BookingARCreationBCImpl;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration.BookingARCreationBackEndDBDAO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.CancelInvoiceVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.InvArAmtVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.InvArChgVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.InvArCntrVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.InvArMnVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.SysClearVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.basic.ARInvoiceCorrectionBC;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.basic.ARInvoiceCorrectionBCImpl;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.ARCorrectionCkReturnVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.ARCorrectionCkVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.ARInvoiceSplitVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.ARInvoiceSplitCondVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.InvArIfNoVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.basic.AccountReceivableOutstandingBC;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.basic.AccountReceivableOutstandingBCImpl;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;

import com.clt.framework.support.layer.backend.BackEndCommandSupport;



/**
 * AccountReceivableInvoiceCreation Business Logic Basic Command implementation<br>
 * - AccountReceivableInvoiceCreation에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Choi Do Soon
 * @see BookingARCreationBackEndDBDAO 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class SplitARInvoiceByIFNoBackEndJob extends BackEndCommandSupport {
	
	private static final long serialVersionUID = -3034414164961318353L;
	
	private InvArMnVO[] invArMnVOs;
	private InvArChgVO[] invArChgVOs;
	private InvArAmtVO[] invArAmtVOs;
	private InvArCntrVO[] invArCntrVOs;
	private ARInvoiceSplitCondVO condVO;

	
	public void setInvArMnVOs(InvArMnVO[] invArMnVOs) {
		if (invArMnVOs != null) {
			InvArMnVO[] tmpVOs = new InvArMnVO[invArMnVOs.length];
			System.arraycopy(invArMnVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.invArMnVOs = tmpVOs;
		}
	}

	public void setInvArChgVOs(InvArChgVO[] invArChgVOs) {
		if (invArMnVOs != null) {
			InvArChgVO[] tmpVOs = new InvArChgVO[invArChgVOs.length];
			System.arraycopy(invArChgVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.invArChgVOs = tmpVOs;
		}
	}

	public void setInvArAmtVOs(InvArAmtVO[] invArAmtVOs) {
		if (invArAmtVOs != null) {
			InvArAmtVO[] tmpVOs = new InvArAmtVO[invArAmtVOs.length];
			System.arraycopy(invArAmtVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.invArAmtVOs = tmpVOs;
		}
	}

	public void setInvArCntrVOs(InvArCntrVO[] invArCntrVOs) {
		if (invArCntrVOs != null) {
			InvArCntrVO[] tmpVOs = new InvArCntrVO[invArCntrVOs.length];
			System.arraycopy(invArCntrVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.invArCntrVOs = tmpVOs;
		}
	}

	public void setCondVO(ARInvoiceSplitCondVO condVO) {
		this.condVO = condVO;
	}


    /**
	 * doStart
	 * 
	 * @return String
	 * @see com.clt.framework.support.layer.backend.BackEndCommandSupport#doStart()
	 * @exception Exception
    */	
	public String doStart() throws Exception {
		
		String result = "";

		ARInvoiceCorrectionBC command = new ARInvoiceCorrectionBCImpl();
		BookingARCreationBC bcommand = new BookingARCreationBCImpl();
		AccountReceivableOutstandingBC command2 = new AccountReceivableOutstandingBCImpl();

		List<InvArIfNoVO> ifNos = new ArrayList<InvArIfNoVO>();
		InvArIfNoVO invArIfNoVO = new InvArIfNoVO();
		List<InvArIfNoVO> maxIfNos = new ArrayList<InvArIfNoVO>();
		InvArIfNoVO maxArIfNoVO = new InvArIfNoVO();
		
		ARCorrectionCkReturnVO arCorrectionCkReturnVO = null;
		
		String newIfNo="";
		
		String otsSmryCd = "";
		int repCustCnt = 0;

		String[] orgIfNoList = null;
		String[] cxlIfNoList = null;
		int loopCnt = 1;
		
		try {
			
			String maxIfNo = command.searchMaxIfNo(condVO.getIfNo());
			String issFlg = command.searchInvIssFlgByIfNo(condVO.getIfNo());
			
			if(!(maxIfNo).equals(condVO.getMaxIfNo()) || ("Y").equals(issFlg)){
				throw new EventException(new ErrorHandler("INV00191",new String[]{}).getMessage());
			}
			
			otsSmryCd = command.searchOTSSummary(condVO.getOfcCd());

			if(("Y").equals(condVO.getIssToSplitFlg())){
				orgIfNoList = condVO.getOrgIfNoList().split(",");
				cxlIfNoList = condVO.getCxlIfNoList().split(",");
				
				loopCnt = orgIfNoList.length;
			}
			
			for(int p = 0; p < loopCnt; p++){
				ARCorrectionCkVO aRCorrectionCkVO = new ARCorrectionCkVO();
	
				aRCorrectionCkVO.setBkgNo(condVO.getBkgNo());
				aRCorrectionCkVO.setInvCustFlg("");
				aRCorrectionCkVO.setOfcCd(condVO.getOfcCd());
				
				if(("Y").equals(condVO.getIssToSplitFlg())){
					String sailDt = command.searchSailDateByIfNo(orgIfNoList[p].substring(0,11));
					
					aRCorrectionCkVO.setSailingDt(sailDt);
					aRCorrectionCkVO.setBlInvCfmDt(sailDt);
				}else{
					aRCorrectionCkVO.setSailingDt(condVO.getSailDt());
					aRCorrectionCkVO.setBlInvCfmDt(condVO.getSailDt());
				}
				
				arCorrectionCkReturnVO = command.checkARCorrection(aRCorrectionCkVO);
				
				if(("Y").equals(condVO.getIssToSplitFlg())){
					bcommand.modifySplitCode(orgIfNoList[p].substring(0,11), "M", "", condVO.getUsrId());
				}else{
					bcommand.modifySplitCode(condVO.getIfNo(), "M", otsSmryCd, condVO.getUsrId());
				}
	
				CancelInvoiceVO cancelInvoiceVO = new CancelInvoiceVO();
	
				if(("Y").equals(condVO.getIssToSplitFlg())){
					cancelInvoiceVO.setIfNo(orgIfNoList[p].substring(0,11));
					cancelInvoiceVO.setNewIfNo(cxlIfNoList[p]);
				}else{
					cancelInvoiceVO.setIfNo(condVO.getIfNo());
					cancelInvoiceVO.setNewIfNo(condVO.getCancelIfNo());
				}
				
				cancelInvoiceVO.setEffDt(arCorrectionCkReturnVO.getEffectiveDt());
				
				if(("Y").equals(condVO.getIssToSplitFlg())){
					cancelInvoiceVO.setOtsSmryCd("");
				}else{
					cancelInvoiceVO.setOtsSmryCd(otsSmryCd);
				}
				
				cancelInvoiceVO.setRevTpCd(arCorrectionCkReturnVO.getRevTpCd());
				cancelInvoiceVO.setRevSrcCd(arCorrectionCkReturnVO.getRevSrcCd());
				//cancelInvoiceVO.setInvCurrCd(condVO.getInvCurrCd());
				cancelInvoiceVO.setUserId(condVO.getUsrId());
	
				// Cancel Data create
				newIfNo = bcommand.createARCancelSplitInvoice(cancelInvoiceVO);
				
				if(!newIfNo.equals("")){
					if(otsSmryCd.equals("INV")){
						maxArIfNoVO = new InvArIfNoVO();
						maxArIfNoVO.setIfNo(condVO.getIfNo());
						maxIfNos.add(maxArIfNoVO);
					}
					
					invArIfNoVO = new InvArIfNoVO();
					invArIfNoVO.setIfNo(newIfNo);
					ifNos.add(invArIfNoVO);
				}
				
				if(("N").equals(condVO.getIssToSplitFlg())){			
					//if(("N").equals(orgIfNoList[p].substring(11,12))){
					//	bcommand.modifySysClear(orgIfNoList[p].substring(0,11), condVO.getUsrId());
					//	bcommand.modifySysClear(cxlIfNoList[p], condVO.getUsrId());
					//}
				//} else {
					if(("BL").equals(otsSmryCd)){
						bcommand.modifySysClear(condVO.getIfNo(), condVO.getUsrId());
						bcommand.modifySysClear(condVO.getCancelIfNo(), condVO.getUsrId());
					}
				}
				
				/*
				SysClearVO sysClearVo = new SysClearVO();
				
				sysClearVo.setOfcCd(condVO.getOfcCd());
				sysClearVo.setBlNo(condVO.getBlSrcNo());
				sysClearVo.setUserId(condVO.getUsrId());
				sysClearVo.setVvdCd("");
				sysClearVo.setCustCd("");
				
				bcommand.modifySysClearList(sysClearVo);
				*/
			}
			
			if (invArMnVOs != null) {

				for (int i = 0; i < invArMnVOs.length; i++) {

					if((("Y").equals(condVO.getIssToSplitFlg()) && !("Y").equals(invArMnVOs[i].getDelFlg())) || ("N").equals(condVO.getIssToSplitFlg())){
						
						repCustCnt = command.checkRepCustomer(invArMnVOs[i].getActCustCntCd(), invArMnVOs[i].getActCustSeq());
	
						if (repCustCnt > 0) {
							throw new EventException(new ErrorHandler("INV00036",new String[]{}).getMessage());
						}
						

						ARInvoiceSplitVO invSplitVo = new ARInvoiceSplitVO();
						InvArMnVO invArMnVO = new InvArMnVO();
	
						invArMnVO.setActCustCntCd(invArMnVOs[i].getActCustCntCd());
						invArMnVO.setActCustSeq(invArMnVOs[i].getActCustSeq());
						invArMnVO.setBfrInvCurrCd(invArMnVOs[i].getBfrInvCurrCd());
	
						invArMnVO.setArIfNo(invArMnVOs[i].getArIfNo());
						invArMnVO.setBkgTeuQty(invArMnVOs[i].getBkgTeuQty());
						invArMnVO.setBkgFeuQty(invArMnVOs[i].getBkgFeuQty());
						invArMnVO.setInvRefNo(invArMnVOs[i].getInvRefNo());
						invArMnVO.setCoStfCtnt(invArMnVOs[i].getCoStfCtnt());
						invArMnVO.setInvRmk(invArMnVOs[i].getInvRmk());
						invArMnVO.setGlEffDt(arCorrectionCkReturnVO.getEffectiveDt());
						invArMnVO.setRevTpCd(arCorrectionCkReturnVO.getRevTpCd());
						invArMnVO.setRevSrcCd(arCorrectionCkReturnVO.getRevSrcCd());
						invSplitVo.setOtsSmryCd(otsSmryCd);
						invSplitVo.setUserId(condVO.getUsrId());
	
						List<InvArChgVO> invArChgVs = new ArrayList<InvArChgVO>();
						if (invArChgVOs != null) {
							for (int j = 0; j < invArChgVOs.length; j++) {
								if (invArChgVOs[j].getArIfNo().equals(invArMnVOs[i].getArIfNo())) {
									invArChgVs.add(invArChgVOs[j]);
								}
							}
						}
	
						List<InvArAmtVO> invArAmtVs = new ArrayList<InvArAmtVO>();
						if (invArAmtVOs != null) {
							for (int k = 0; k < invArAmtVOs.length; k++) {
								if (invArAmtVOs[k].getArIfNo().equals(invArMnVOs[i].getArIfNo())) {
									invArAmtVs.add(invArAmtVOs[k]);
								}
							}
						}
	
						List<InvArCntrVO> invArCntrVs = new ArrayList<InvArCntrVO>();
						if (invArCntrVOs != null) {
							for (int l = 0; l < invArCntrVOs.length; l++) {
								if (invArCntrVOs[l].getArIfNo().equals(invArMnVOs[i].getArIfNo())) {
									invArCntrVs.add(invArCntrVOs[l]);
								}
							}
						}
						invSplitVo.setIfNo(condVO.getIfNo());
						invSplitVo.setInvArMnVO(invArMnVO);
						invSplitVo.setInvArChgVOs(invArChgVs);
						invSplitVo.setInvArAmtVOs(invArAmtVs);
						invSplitVo.setInvArCntrVOs(invArCntrVs);
						//invSplitVo.setInvCurrCd(condVO.getInvCurrCd());
	
						// New Data create
						newIfNo = bcommand.createSplitInvoice(invSplitVo);
						
						if(!newIfNo.equals("")){
							invArIfNoVO = new InvArIfNoVO();
							invArIfNoVO.setIfNo(newIfNo);
							ifNos.add(invArIfNoVO);
						}
						
						/*
						SysClearVO splitSysClearVo = new SysClearVO();
						
						splitSysClearVo.setOfcCd(condVO.getOfcCd());
						splitSysClearVo.setBlNo(condVO.getBlSrcNo());
						splitSysClearVo.setUserId(condVO.getUsrId());
						splitSysClearVo.setVvdCd("");
						splitSysClearVo.setCustCd("");
						
						bcommand.modifySysClearList(splitSysClearVo);
						*/
					}
				}
			}
			
			/*
			SysClearVO finalSysClearVo = new SysClearVO();
			
			finalSysClearVo.setOfcCd(condVO.getOfcCd());
			finalSysClearVo.setBlNo(condVO.getBlSrcNo());
			finalSysClearVo.setUserId(condVO.getUsrId());
			finalSysClearVo.setVvdCd("");
			finalSysClearVo.setCustCd("");
			
			bcommand.modifySysClearList(finalSysClearVo);
			*/
			
			SysClearVO ifNoSysClearVo = new SysClearVO();
			
			ifNoSysClearVo.setOfcCd(condVO.getOfcCd());
			ifNoSysClearVo.setBlNo(condVO.getBlSrcNo());
			ifNoSysClearVo.setUserId(condVO.getUsrId());
			ifNoSysClearVo.setVvdCd("");
			ifNoSysClearVo.setCustCd("");
			
			command.modifySysClearByIFNo(ifNoSysClearVo);
			   
			if(ifNos!= null && ifNos.size()>0){
			    command2.createOutstandingInfo(ifNos);
			}
			
			result = "SUCCESS";
		} catch (EventException ex) {
			result = "FAIL";
			log.error("[EventException]"+ex.getMessage());
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			result = "FAIL";
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler("INV00053").getMessage(), ex);
		}
		
		return result;
	}
}