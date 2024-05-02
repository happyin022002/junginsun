/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChargeOfficeTransferMgtBCImpl.java
*@FileTitle : Office Transfer History
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtclosing.chargeofficetransfermgt.basic;

import java.util.List;

import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.ChargeArgumentVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.ChargeCalculationContainerVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.DmtResultVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargeofficetransfermgt.integration.ChargeOfficeTransferMgtDBDAO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargeofficetransfermgt.vo.DmtOfcTrnsHisVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargeofficetransfermgt.vo.OfficeTransferHistoryByContainerVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargeofficetransfermgt.vo.OfficeTransferParmVO;
import com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.integration.CommonFinderDBDAO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * OPUS-DMTClosing Business Logic Basic Command implementation<br>
 * @author
 * @see reference DAO of  EES_DMT_3001EventResponse,ChargeOfficeTransferMgtBC
 * @since J2EE 1.6
 */
public class ChargeOfficeTransferMgtBCImpl extends BasicCommandSupport implements ChargeOfficeTransferMgtBC {

	// Database Access Object
	private transient ChargeOfficeTransferMgtDBDAO dbDao = null;
	private transient CommonFinderDBDAO dbDao2 = null;
	
	/**
	 * ChargeOfficeTransferMgtBCImpl create object<br>
	 * create ChargeOfficeTransferMgtDBDAO.<br>
	 */
	public ChargeOfficeTransferMgtBCImpl() {
		dbDao = new ChargeOfficeTransferMgtDBDAO();
		dbDao2 = new CommonFinderDBDAO();
	}
	
	/**
	 * search Office Transfer by Office and date
	 * 
	 * @param OfficeTransferParmVO officeTransferParmVO
	 * @return List<DmtOfcTrnsHisVO>
	 * @exception EventException
	 */
	public List<DmtOfcTrnsHisVO> searchOfficeTransferHistoryList(OfficeTransferParmVO officeTransferParmVO) throws EventException {
		try {
			return dbDao.searchOfficeTransferHistoryList(officeTransferParmVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("DMT00006", new String[]{"Office Transfer History"}).getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("DMT00006", new String[]{"Office Transfer History"}).getMessage());
		}
	}
	
	
	/**
	 * modify Office  Charge Data for Office Transfer.
	 * Charge for Office Transfer 's  Status is  "F"(Finish) or "L"(Long Staying) 
	 * 
	 * @param	OfficeTransferParmVO[] officeTransferParmVOs
	 * @param	SignOnUserAccount account
	 * @return	String[]
	 * @exception EventException
	 */
	public String[] createOfficeTransferCharge(OfficeTransferParmVO[] officeTransferParmVOs, SignOnUserAccount account) throws EventException {
		try {
			// return contained array error message and infomations .
			String result[] = new String[2];
			
			// first VO
			OfficeTransferParmVO ofcTrnsParmVO = officeTransferParmVOs[0];
			
			//String fmSvrId = ofcTrnsParmVO.getSvrId();
			String fmOfcCd = ofcTrnsParmVO.getFmOfcCd();
			String toOfcCd = ofcTrnsParmVO.getToOfcCd();
			String trnsRsn = ofcTrnsParmVO.getTrnsRsn();
			
			DmtOfcTrnsHisVO dmtOfcTrnsHisVO = new DmtOfcTrnsHisVO();
			dmtOfcTrnsHisVO.setFmOfcCd(fmOfcCd);
			dmtOfcTrnsHisVO.setToOfcCd(toOfcCd);
			dmtOfcTrnsHisVO.setTrnsRsn(trnsRsn);
			dmtOfcTrnsHisVO.setCreUsrId(account.getUsr_id());
			dmtOfcTrnsHisVO.setCreOfcCd(account.getOfc_cd());
			
			// same RHQ Office: "N", different RHQ Office: "Y"
			String rhqChkFlg = dbDao.searchOfficeTransferToServerID(fmOfcCd, toOfcCd);

			String tempSvr = "";
			tempSvr = dbDao2.searchUserSysAreaGrpId(ofcTrnsParmVO.getToOfcCd());
			
			/*
			String svrFlag = "Y";
			if(fmSvrId.equals(toSvrId)) {
				svrFlag = "N";
			}*/
			/*else {
				if( (fmSvrId.equals("KOR") || fmSvrId.equals("CHN")) && (toSvrId.equals("KOR") || toSvrId.equals("CHN")) )
					svrFlag = "N";
			}*/
			
//			String updOfc =  account.getOfc_cd();
			
			/* check  Office Transferable other area Office */

//			if("Y".equals(rhqChkFlg) ) {
//				List<String> rsltList = dbDao2.searchRHQOfficeList();
//				int cnt = 0;
//				
//				for(int i=0; rsltList!=null && i<rsltList.size(); i++){
//				       if(updOfc.equals(rsltList.get(i))){ 
//				         cnt++; 
//				       } 
//				}
//				
//				if(cnt ==0){ 
//					 result[0] = "DMT01009"; 
//					 return result; 
//				} 
//				
//			} CSR #19871 - remove RHQ restriction

			for(int i=0; i < officeTransferParmVOs.length; i++) {
				ofcTrnsParmVO = officeTransferParmVOs[i];
				//ofcTrnsParmVO.setToSvrId(toSvrId);
				
				if(rhqChkFlg.equals("Y") && ofcTrnsParmVO.getDmdtChgStsCd().equals("L")) {
					result[0] = "DMT01010";
					return result;
				}
				
				ChargeArgumentVO chargeArgumentVO = new ChargeArgumentVO();
				chargeArgumentVO.setSvrId(ofcTrnsParmVO.getSvrId());
				chargeArgumentVO.setCntrNo(ofcTrnsParmVO.getCntrNo());
				chargeArgumentVO.setCntrCycNo(ofcTrnsParmVO.getCntrCycNo());
				chargeArgumentVO.setDmdtTrfCd(ofcTrnsParmVO.getDmdtTrfCd());
				chargeArgumentVO.setDmdtChgLocDivCd(ofcTrnsParmVO.getDmdtChgLocDivCd());
				chargeArgumentVO.setChgSeq(ofcTrnsParmVO.getChgSeq());
				chargeArgumentVO.setOfcCd(account.getOfc_cd());
				
//				int gapDate = dbDao.getFinishedGapDate(chargeArgumentVO);

//				if(gapDate > 30 && ofcTrnsParmVO.getDmdtChgStsCd().equals("F")) {
//					 List<String> rsltList = dbDao2.searchRHQOfficeList();
//					 int cnt = 0;
//					 
//					 for(int j=0; rsltList!=null && j<rsltList.size(); j++){
//					        if(updOfc.equals(rsltList.get(j))){ 
//					          cnt++; 
//					        } 
//					 }
//					 
//					 if(cnt ==0){
//						  result[0] = "DMT01011";
//						  result[1] = ofcTrnsParmVO.getCntrNo();
//						  return result;
//					 }
//				} CSR #19871 - remove RHQ restriction
				
				int ofcTrnsMaxSeq = dbDao.searchOfficeTransferMaxSEQ(chargeArgumentVO);
				
				dmtOfcTrnsHisVO.setSvrId(ofcTrnsParmVO.getSvrId());
				dmtOfcTrnsHisVO.setCntrNo(ofcTrnsParmVO.getCntrNo());
				dmtOfcTrnsHisVO.setCntrCycNo(ofcTrnsParmVO.getCntrCycNo());
				dmtOfcTrnsHisVO.setDmdtTrfCd(ofcTrnsParmVO.getDmdtTrfCd());
				dmtOfcTrnsHisVO.setDmdtChgLocDivCd(ofcTrnsParmVO.getDmdtChgLocDivCd());
				dmtOfcTrnsHisVO.setChgSeq(ofcTrnsParmVO.getChgSeq());
				dmtOfcTrnsHisVO.setOfcTrnsSeq(String.valueOf(ofcTrnsMaxSeq+1));
				
				dbDao.addOfficeTransferHistory(dmtOfcTrnsHisVO);
			}

			if( tempSvr.equals(ofcTrnsParmVO.getSvrId()) )
			{
			  rhqChkFlg = "N";
			}
			else 
			{
			  rhqChkFlg = "Y";
			}

			result[1] = rhqChkFlg;
			return result;
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("DMT00003", new String[]{"Office Transfer Charge"}).getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("DMT00003", new String[]{"Office Transfer Charge"}).getMessage());
		}
	}
	
	
	/**
	 * search Office Transfer History info. by Container.<br>
	 * 
	 * @param OfficeTransferParmVO officeTransferParmVO
	 * @return List<OfficeTransferHistoryByContainerVO>
	 * @exception EventException
	 */
	public List<OfficeTransferHistoryByContainerVO> searchOfficeTransferHistoryListByContainer(OfficeTransferParmVO officeTransferParmVO) throws EventException {
		
		try {
			return dbDao.searchOfficeTransferHistoryListByContainer(officeTransferParmVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("DMT00006", new String[]{"Office Transfer History"}).getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("DMT00006", new String[]{"Office Transfer History"}).getMessage());
		}
	}
	
	
	/**
	 * case in Office Transfered Charge is Partial,Office Transfer Flag of new created Charge to be "Y" ,
	 * also  create Office Transfer History.
	 * 
	 * @param	ChargeCalculationContainerVO[] chargeCalculationContainerVOs
	 * @param	SignOnUserAccount account
	 * @return	DmtResultVO
	 * @exception EventException
	 */
	public DmtResultVO createOfficeTransferHistoryByPartialPayment(ChargeCalculationContainerVO[] chargeCalculationContainerVOs, SignOnUserAccount account) throws EventException {
		try {
			DmtResultVO resultVO = new DmtResultVO();
			
			DmtOfcTrnsHisVO dmtOfcTrnsHisVO = new DmtOfcTrnsHisVO();
			//DmtOfcTrnsHisVO tmpDmtOfcTrnsHisVO = null;
			String orgChgSeq = null;
			
			// same RHQ Office: "N", different RHQ Office: "Y"
			//String rhqChkFlg = dbDao.searchOfficeTransferToServerID(fmOfcCd, toOfcCd);
			
			for(int i=0; i < chargeCalculationContainerVOs.length; i++) {
				
				ChargeCalculationContainerVO chgCalcCntrVO = chargeCalculationContainerVOs[i];
				
				//if OFC_TRNS_FLG is not  "Y" , then Skip
				if( !"Y".equals(chgCalcCntrVO.getOfcTrnsFlg()) ) {
					continue;
				}
				
				dmtOfcTrnsHisVO.setCntrNo(chgCalcCntrVO.getCntrNo());
				dmtOfcTrnsHisVO.setCntrCycNo(chgCalcCntrVO.getCntrCycNo());
				dmtOfcTrnsHisVO.setDmdtTrfCd(chgCalcCntrVO.getDmdtTrfCd());
				dmtOfcTrnsHisVO.setDmdtChgLocDivCd(chgCalcCntrVO.getDmdtChgLocDivCd());
				dmtOfcTrnsHisVO.setChgSeq(chgCalcCntrVO.getChgSeq());
				
				
				String chkVal = dbDao.checkOfficeTransferHistoryByPartialPayment(dmtOfcTrnsHisVO);
				
				// if Charge exist in  DMT_OFC_TRNS_HIS , then SKIP
				if(chkVal.equals("Y")) {
					//if(tmpDmtOfcTrnsHisVO == null)
					orgChgSeq = dmtOfcTrnsHisVO.getChgSeq();
					
					continue;
				}
				
				
				//dmtOfcTrnsHisVO.setChgSeq(chgCalcCntrVO.getChgSeq());
				if(orgChgSeq != null) dmtOfcTrnsHisVO.setOrgChgSeq(orgChgSeq);
				
				dbDao.addOfficeTransferHistoryByPartialPayment(dmtOfcTrnsHisVO);
			} // for - end
			
			//result[1] = rhqChkFlg;
			return resultVO;
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("DMT00003", new String[]{"Office Transfer Charge"}).getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("DMT00003", new String[]{"Office Transfer Charge"}).getMessage());
		}
	}
	
	
}