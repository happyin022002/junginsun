/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChassisMgsetInvoiceBCImpl.java
*@FileTitle : Agreement Matching
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 
=========================================================*/
package com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.integration.ChassisMgsetInvoiceDBDAO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSChargeCreationINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSChargeCreationMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSCoPoolChargeINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSCoPoolChargeMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSConfirmPayableAmountINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSConfirmPayableAmountMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSConfirmPayableGRPVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSEstimateExpenseINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSEstimateExpenseMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSInvoiceImportAuditINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSInvoiceImportAuditMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSInvoiceInquiryINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSInvoiceInquiryMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSLessorAgmtMatchingINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSLessorAgmtMatchingMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSNuPoolChargeINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSNuPoolChargeMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSPayableInvoiceCreationINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSPayableInvoiceCreationMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.MGSChargeCreationINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.MGSChargeCreationMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.MGSConfirmPayableAmountINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.MGSConfirmPayableAmountMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.MGSEstimateExpenseINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.MGSEstimateExpenseMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.MGSInvoiceImportAuditINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.MGSInvoiceImportAuditMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.MGSInvoiceInquiryINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.MGSInvoiceInquiryMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.MGSLessorAgmtMatchingINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.MGSLessorAgmtMatchingMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.MGSPayableInvoiceCreationINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.MGSPayableInvoiceCreationMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.PoolEstmExpenseINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.PoolEstmExpenseMGTVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.ApPayInvDtlVO;
import com.clt.syscommon.common.table.ApPayInvVO;

/**
 * opus-ChassisMgsetAgreementInvoice Business Logic Basic Command implementation<br>
 *
 * @author 
 * @see ees_cgm_1028EventResponse,ChassisMgsetInvoiceBC each DAO class reference
 * @since J2EE 1.4 
 */

public class ChassisMgsetInvoiceBCImpl extends BasicCommandSupport implements ChassisMgsetInvoiceBC {

	// Database Access Object
	private transient ChassisMgsetInvoiceDBDAO dbDao = null;

	/**
	 * ChassisMgsetInvoiceBCImpl object creating<br>
	 * ChassisMgsetInvoiceDBDAO creating<br>
	 */
	public ChassisMgsetInvoiceBCImpl() {
		dbDao = new ChassisMgsetInvoiceDBDAO();
	}
	/**
	 *  Retrieve agreement data matched to Lessor.(Chassis)[EES_CGM_1028]<br>
	 * 
	 * @param chsLessorAgmtMatchingINVO   CHSLessorAgmtMatchingINVO
	 * @return List<CHSLessorAgmtMatchingMGTVO>
	 * @exception EventException
	 */
	public List<CHSLessorAgmtMatchingMGTVO> searchCHSLessorAgmtMatchingBasic(CHSLessorAgmtMatchingINVO chsLessorAgmtMatchingINVO) throws EventException {
		try {
			
			return dbDao.searchCHSLessorAgmtMatchingData(chsLessorAgmtMatchingINVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}
	/**
	 * Save agreement data matched to Lessor.(Chassis)[EES_CGM_1028]<br>
	 * 
	 * @param chsLessorAgmtMatchingINVO CHSLessorAgmtMatchingINVO[]
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageCHSLessorAgmtMatchingBasic (CHSLessorAgmtMatchingINVO[] chsLessorAgmtMatchingINVO, SignOnUserAccount account) throws EventException{
		try {
			List<CHSLessorAgmtMatchingINVO> insertVoList = new ArrayList<CHSLessorAgmtMatchingINVO>();
			List<CHSLessorAgmtMatchingINVO> updateVoList = new ArrayList<CHSLessorAgmtMatchingINVO>();
			List<CHSLessorAgmtMatchingINVO> deleteVoList = new ArrayList<CHSLessorAgmtMatchingINVO>();
			
			for ( int i=0; i<chsLessorAgmtMatchingINVO.length; i++ ) {
				
				if (chsLessorAgmtMatchingINVO[i].getInvRefNo()==null || chsLessorAgmtMatchingINVO[i].getAgmtOfcCtyCd()==null){
					throw new EventException(new ErrorHandler("CGM20012",new String[]{}).getMessage());
				}
				
				String agmtNo = chsLessorAgmtMatchingINVO[i].getAgmtNo();
				chsLessorAgmtMatchingINVO[i].setEqKndCd("Z");
				chsLessorAgmtMatchingINVO[i].setAgmtOfcCtyCd(agmtNo.substring(0, 3));
				chsLessorAgmtMatchingINVO[i].setAgmtSeq(agmtNo.substring(3));
				chsLessorAgmtMatchingINVO[i].setCreUsrId(account.getUsr_id());
				chsLessorAgmtMatchingINVO[i].setUpdUsrId(account.getUsr_id());
				                       
				if ( chsLessorAgmtMatchingINVO[i].getIbflag().equals("I")){
				//	if(chsLessorAgmtMatchingINVO[i].getDelChk().equals("1")){
						insertVoList.add(chsLessorAgmtMatchingINVO[i]);
				//	}
				} else if ( chsLessorAgmtMatchingINVO[i].getIbflag().equals("U")){
				//	if(chsLessorAgmtMatchingINVO[i].getDelChk().equals("1")){
						updateVoList.add(chsLessorAgmtMatchingINVO[i]);
				//	}
				} else if ( chsLessorAgmtMatchingINVO[i].getIbflag().equals("D")){
					deleteVoList.add(chsLessorAgmtMatchingINVO[i]);
				}
			}
			
			int checkCnt = 0;
			if ( insertVoList.size() > 0 ) {
				checkCnt = dbDao.checkCHSLessorAgmtMatchingCountData(insertVoList);
			}
			
			if(checkCnt==0){
				if ( insertVoList.size() > 0 ) {
					dbDao.addCHSLessorAgmtMatchingData(insertVoList);
				}
				
				if ( updateVoList.size() > 0 ) {
					dbDao.modifyCHSLessorAgmtMatchingData(updateVoList);
				}
				
				if ( deleteVoList.size() > 0 ) {
					dbDao.removeCHSLessorAgmtMatchingData(deleteVoList);
				}
			} else {
				// error message handling in case of existing
				//throw new EventException(new ErrorHandler("CGM20013",new String[]{"Reference No."}).getMessage());
				throw new EventException(new ErrorHandler("CGM10084").getMessage());
			}
		} catch (EventException ex){
			throw ex;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}
	
	/**
	 *  After insert Agreement No., Checking whether data exists or not when Focus Out.(Chassis)[EES_CGM_1028]<br>
	 * 
	 * @param chsLessorAgmtMatchingINVO	CHSLessorAgmtMatchingINVO
	 * @return CHSLessorAgmtMatchingMGTVO
	 * @exception EventException
	 */
	public CHSLessorAgmtMatchingMGTVO checkCHSAgmtBasic(CHSLessorAgmtMatchingINVO chsLessorAgmtMatchingINVO) throws EventException {
		
		CHSLessorAgmtMatchingMGTVO chsLessorAgmtMatchingMGTVO = null;
		try {
			chsLessorAgmtMatchingMGTVO = dbDao.checkCHSAgmtData(chsLessorAgmtMatchingINVO);
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
		
		return chsLessorAgmtMatchingMGTVO;
	}
	
	/**
	 *   Retrieve agreement data matched to Lessor.(M.G.Set)[EES_CGM_2086]<br>
	 * 
	 * @param mgsLessorAgmtMatchingINVO   MGSLessorAgmtMatchingINVO
	 * @return List<MGSLessorAgmtMatchingMGTVO>
	 * @exception EventException
	 */
	public List<MGSLessorAgmtMatchingMGTVO> searchMGSLessorAgmtMatchingBasic(MGSLessorAgmtMatchingINVO mgsLessorAgmtMatchingINVO) throws EventException {
		try {
			
			return dbDao.searchMGSLessorAgmtMatchingData(mgsLessorAgmtMatchingINVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}
	/**
	 * Save agreement data matched to Lessor.(M.G.Set)[EES_CGM_2086]<br>
	 * 
	 * @param mgsLessorAgmtMatchingINVO MGSLessorAgmtMatchingINVO[]
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageMGSLessorAgmtMatchingBasic (MGSLessorAgmtMatchingINVO[] mgsLessorAgmtMatchingINVO, SignOnUserAccount account) throws EventException{
		try {
			List<MGSLessorAgmtMatchingINVO> insertVoList = new ArrayList<MGSLessorAgmtMatchingINVO>();
			List<MGSLessorAgmtMatchingINVO> updateVoList = new ArrayList<MGSLessorAgmtMatchingINVO>();
			List<MGSLessorAgmtMatchingINVO> deleteVoList = new ArrayList<MGSLessorAgmtMatchingINVO>();
			
			for ( int i=0; i<mgsLessorAgmtMatchingINVO.length; i++ ) {
				
				if (mgsLessorAgmtMatchingINVO[i].getInvRefNo()==null || mgsLessorAgmtMatchingINVO[i].getAgmtOfcCtyCd()==null){
					throw new EventException(new ErrorHandler("CGM20012",new String[]{}).getMessage());
				}
				
				String agmtNo = mgsLessorAgmtMatchingINVO[i].getAgmtNo();
				
				mgsLessorAgmtMatchingINVO[i].setAgmtOfcCtyCd(agmtNo.substring(0, 3));
				mgsLessorAgmtMatchingINVO[i].setAgmtSeq(agmtNo.substring(3));
				mgsLessorAgmtMatchingINVO[i].setEqKndCd("G");
				mgsLessorAgmtMatchingINVO[i].setCreUsrId(account.getUsr_id());
				mgsLessorAgmtMatchingINVO[i].setUpdUsrId(account.getUsr_id());
				
				if ( mgsLessorAgmtMatchingINVO[i].getIbflag().equals("I")){
				//	if(mgsLessorAgmtMatchingINVO[i].getDelChk().equals("1")){
						insertVoList.add(mgsLessorAgmtMatchingINVO[i]);
				//	}
				} else if ( mgsLessorAgmtMatchingINVO[i].getIbflag().equals("U")){
				//	if(mgsLessorAgmtMatchingINVO[i].getDelChk().equals("1")){
						updateVoList.add(mgsLessorAgmtMatchingINVO[i]);
				//	}
				} else if ( mgsLessorAgmtMatchingINVO[i].getIbflag().equals("D")){
					deleteVoList.add(mgsLessorAgmtMatchingINVO[i]);
				}
			}
			
			int checkCnt = 0;
			if ( insertVoList.size() > 0 ) {
				checkCnt = dbDao.checkMGSLessorAgmtMatchingCountData(insertVoList);
			}
			
			if(checkCnt==0){
				if ( insertVoList.size() > 0 ) {
					dbDao.addMGSLessorAgmtMatchingData(insertVoList);
				}
				
				if ( updateVoList.size() > 0 ) {
					dbDao.modifyMGSLessorAgmtMatchingData(updateVoList);
				}
				
				if ( deleteVoList.size() > 0 ) {
					dbDao.removeMGSLessorAgmtMatchingData(deleteVoList);
				}
			} else {
				// error message handling in case of existing
				//throw new EventException(new ErrorHandler("CGM20013",new String[]{"Reference No."}).getMessage());
				throw new EventException(new ErrorHandler("CGM10084").getMessage());
			}
		} catch (EventException ex){
			throw ex;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}
	
	/**
	 *  After insert Agreement No., Checking whether data exists or not when Focus Out.(M.G.Set)[EES_CGM_2086]<br>
	 * 
	 * @param mgsLessorAgmtMatchingINVO   MGSLessorAgmtMatchingINVO
	 * @return MGSLessorAgmtMatchingMGTVO
	 * @exception EventException
	 */
	public MGSLessorAgmtMatchingMGTVO checkMGSAgmtBasic(MGSLessorAgmtMatchingINVO mgsLessorAgmtMatchingINVO) throws EventException {
		
		MGSLessorAgmtMatchingMGTVO mgsLessorAgmtMatchingMGTVO = null;
		try {
			mgsLessorAgmtMatchingMGTVO = dbDao.checkMGSAgmtData(mgsLessorAgmtMatchingINVO);
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
		
		return mgsLessorAgmtMatchingMGTVO;
	}
	
	/**
	 * Retrieve saved Pool Charge list.(Chassis)[EES_CGM_1123]<br>
	 * 
	 * @param chsCoPoolChargeINVO   CHSCoPoolChargeINVO
	 * @return List<CHSCoPoolChargeMGTVO>
	 * @exception EventException
	 */
	public List<CHSCoPoolChargeMGTVO> searchCHSCoPoolChargeListBasic(CHSCoPoolChargeINVO chsCoPoolChargeINVO) throws EventException {
		try {
			
			return dbDao.searchCHSCoPoolChargeListData(chsCoPoolChargeINVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}
	
	/**
	 * Retrieve initial Pool Charge list.(Chassis)[EES_CGM_1123]<br>
	 * 
	 * @param chsCoPoolChargeINVO   CHSCoPoolChargeINVO
	 * @return List<CHSCoPoolChargeMGTVO>
	 * @exception EventException
	 */
	public List<CHSCoPoolChargeMGTVO> searchCHSCoPoolChargeInitBasic(CHSCoPoolChargeINVO chsCoPoolChargeINVO) throws EventException {
		try {
			
			return dbDao.searchCHSCoPoolChargeInitData(chsCoPoolChargeINVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}
	
	/**
	 * Retrieve Co-Pool Charge Main imformation.(Chassis)[EES_CGM_1123]<br>
	 * 
	 * @param chsCoPoolChargeINVO   CHSCoPoolChargeINVO
	 * @return List<CHSCoPoolChargeMGTVO>
	 * @exception EventException
	 */
	public List<CHSCoPoolChargeMGTVO> searchCHSCoPoolChargeDtlBasic(CHSCoPoolChargeINVO chsCoPoolChargeINVO) throws EventException {
		try {
			
			List<CHSCoPoolChargeMGTVO> list = dbDao.searchCHSCoPoolChargeDtlData(chsCoPoolChargeINVO);
			CHSCoPoolChargeMGTVO data = dbDao.searchCHSCoPoolChargeMainData(chsCoPoolChargeINVO);
			
			if(list.size() > 0){
				
				if(data != null){
				
					// setting Main Data retrieve result to chsCoPoolChargeMGTVO
					CHSCoPoolChargeMGTVO  chsCoPoolChargeMGTVO = (CHSCoPoolChargeMGTVO)list.get(0);
					
					// setting Detail retrieve result to chsCoPoolChargeMGTVO
					chsCoPoolChargeMGTVO.setPayInvSeq(data.getPayInvSeq());
					chsCoPoolChargeMGTVO.setInvNo(data.getInvNo());
					chsCoPoolChargeMGTVO.setVndrSeq(data.getVndrSeq());
					chsCoPoolChargeMGTVO.setVndrLglEngNm(data.getVndrLglEngNm());
					chsCoPoolChargeMGTVO.setCostYrmon(data.getCostYrmon());
					chsCoPoolChargeMGTVO.setCostOfcCd(data.getCostOfcCd());
					chsCoPoolChargeMGTVO.setAgmtOfcCtyCd(data.getAgmtOfcCtyCd());
					chsCoPoolChargeMGTVO.setAgmtSeq(data.getAgmtSeq());
					chsCoPoolChargeMGTVO.setChssPoolCd(data.getChssPoolCd());
					chsCoPoolChargeMGTVO.setChssMgstInvKndCd(data.getChssMgstInvKndCd());
					chsCoPoolChargeMGTVO.setChssMgstInvStsCd(data.getChssMgstInvStsCd());
					chsCoPoolChargeMGTVO.setDiffRmk(data.getDiffRmk());
					chsCoPoolChargeMGTVO.setInvDt(data.getInvDt());
					
				}
			}
			
			return list;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}
	
	/**
	 * Retrieve Co-Pool Charge Main information.[EES_CGM_1123]<br>
	 * 
	 * @param chsCoPoolChargeINVO   CHSCoPoolChargeINVO
	 * @return CHSCoPoolChargeMGTVO
	 * @exception EventException
	 */
	public CHSCoPoolChargeMGTVO searchCHSCoPoolChargeMainBasic(CHSCoPoolChargeINVO chsCoPoolChargeINVO) throws EventException {
		try {
			return dbDao.searchCHSCoPoolChargeMainData(chsCoPoolChargeINVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}
	
	/**
	 * Manage Co Pool Charge.(Chassis)[EES_CGM_1123]<br>
	 * 
	 * @param chsCoPoolChargeINVOS CHSCoPoolChargeINVO[]
	 * @param chsCoPoolChargeINVO CHSCoPoolChargeINVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void createCHSCoPoolChargeBasic (CHSCoPoolChargeINVO[] chsCoPoolChargeINVOS, CHSCoPoolChargeINVO chsCoPoolChargeINVO, SignOnUserAccount account) throws EventException {
		
		List<CHSCoPoolChargeINVO> insertVoList = new ArrayList<CHSCoPoolChargeINVO>();
		
		try {
			
			/*-------------------------------
			 	setting VO value
			 --------------------------------*/
			// 'H' in cace of Save, 'S' in case of Confirm 		 	
			if(chsCoPoolChargeINVO != null){
				if(chsCoPoolChargeINVO.getActionflag().equals("SAVE")){
					chsCoPoolChargeINVO.setChssMgstInvStsCd("H");
				} else if (chsCoPoolChargeINVO.getActionflag().equals("CONFIRM")){
					chsCoPoolChargeINVO.setChssMgstInvStsCd("S");
				}
			
			
				chsCoPoolChargeINVO.setChssMgstInvKndCd("CP");
				chsCoPoolChargeINVO.setInvUsrId(account.getUsr_id());
				chsCoPoolChargeINVO.setCreUsrId(account.getUsr_id());
				chsCoPoolChargeINVO.setUpdUsrId(account.getUsr_id());
				
				// insert CGM_PAY_INV
				long payInvSeq = dbDao.searchCHSCoPoolChargePayInvSeqData(chsCoPoolChargeINVO);
				
				chsCoPoolChargeINVO.setPayInvSeq(String.valueOf(payInvSeq));
				
				dbDao.addCHSCoPoolChargeMainData(chsCoPoolChargeINVO);
				// insert CGM_PAY_INV_POOL_DTL 
				for (int k=0; k < chsCoPoolChargeINVOS.length; k++){
					
					CHSCoPoolChargeINVO chsCoPoolChargeINVO2 = new CHSCoPoolChargeINVO();
					
					chsCoPoolChargeINVO2.setPayInvSeq(String.valueOf(payInvSeq));
					chsCoPoolChargeINVO2.setDtlPoolCostItmCd(chsCoPoolChargeINVOS[k].getDtlPoolCostItmCd());
					chsCoPoolChargeINVO2.setPoolBsrtAmt(chsCoPoolChargeINVOS[k].getPoolBsrtAmt());
					chsCoPoolChargeINVO2.setCostBilDys(chsCoPoolChargeINVOS[k].getCostBilDys());
					chsCoPoolChargeINVO2.setCostAmt(chsCoPoolChargeINVOS[k].getCostAmt());
					chsCoPoolChargeINVO2.setCreUsrId(account.getUsr_id());
					chsCoPoolChargeINVO2.setUpdUsrId(account.getUsr_id());
											
					insertVoList.add(chsCoPoolChargeINVO2);
				}
				
				dbDao.addCHSCoPoolChargeDtlData(insertVoList);
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}
	
	/**
	 * Editing Co Pool Charge.(Chassis)[EES_CGM_1123]<br>
	 * 
	 * @param chsCoPoolChargeINVOS CHSCoPoolChargeINVO[]
	 * @param chsCoPoolChargeINVO CHSCoPoolChargeINVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyCHSCoPoolChargeBasic (CHSCoPoolChargeINVO[] chsCoPoolChargeINVOS, CHSCoPoolChargeINVO chsCoPoolChargeINVO, SignOnUserAccount account) throws EventException {
		
		List<CHSCoPoolChargeINVO> insertVoList = new ArrayList<CHSCoPoolChargeINVO>();
		
		try {
			
			// 'H' in cace of Save, 'S' in case of Confirm
			if(chsCoPoolChargeINVO != null){
				if(chsCoPoolChargeINVO.getActionflag().equals("SAVE")){
					chsCoPoolChargeINVO.setChssMgstInvStsCd("H");
				} else if (chsCoPoolChargeINVO.getActionflag().equals("CONFIRM")){
					chsCoPoolChargeINVO.setChssMgstInvStsCd("S");
				}
			
				chsCoPoolChargeINVO.setChssMgstInvKndCd("CP");
				chsCoPoolChargeINVO.setInvUsrId(account.getUsr_id());
				chsCoPoolChargeINVO.setUpdUsrId(account.getUsr_id());
				
				// edit CGM_PAY_INV 
				dbDao.modifyCHSCoPoolChargeMainData(chsCoPoolChargeINVO);
				
				// delete CGM_PAY_INV_POOL_DTL 
				dbDao.removeCHSCoPoolChargeDtlData(chsCoPoolChargeINVO);
				
				// insert CGM_PAY_INV_POOL_DTL 
				for (int k=0; k < chsCoPoolChargeINVOS.length; k++){
					
					CHSCoPoolChargeINVO chsCoPoolChargeINVO2 = new CHSCoPoolChargeINVO();
					
					chsCoPoolChargeINVO2.setPayInvSeq(chsCoPoolChargeINVO.getPayInvSeq());
					chsCoPoolChargeINVO2.setDtlPoolCostItmCd(chsCoPoolChargeINVOS[k].getDtlPoolCostItmCd());
					chsCoPoolChargeINVO2.setPoolBsrtAmt(chsCoPoolChargeINVOS[k].getPoolBsrtAmt());
					chsCoPoolChargeINVO2.setCostBilDys(chsCoPoolChargeINVOS[k].getCostBilDys());
					chsCoPoolChargeINVO2.setCostAmt(chsCoPoolChargeINVOS[k].getCostAmt());
					chsCoPoolChargeINVO2.setCreUsrId(account.getUsr_id());
					chsCoPoolChargeINVO2.setUpdUsrId(account.getUsr_id());
											
					insertVoList.add(chsCoPoolChargeINVO2);
				}
				
				dbDao.addCHSCoPoolChargeDtlData(insertVoList);
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}
	
	/**
	 * Deleting saved Pool Charge information.(Chassis)[EES_CGM_1123]<br>
	 * 
	 * @param chsCoPoolChargeINVO CHSCoPoolChargeINVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void removeCHSCoPoolChargeBasic (CHSCoPoolChargeINVO chsCoPoolChargeINVO, SignOnUserAccount account) throws EventException {
		
		try {
			dbDao.removeCHSCoPoolChargeDtlData(chsCoPoolChargeINVO);
			dbDao.removeCHSCoPoolChargeMainData(chsCoPoolChargeINVO);
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}
	
	/**
	 * Retrieve Charge creation list on this month.(Chassis)[EES_CGM_1029]<br>
	 * 
	 * @param chsChargeCreationINVO   CHSChargeCreationINVO
	 * @return List<CHSChargeCreationMGTVO>
	 * @exception EventException
	 */
	public List<CHSChargeCreationMGTVO> searchCHSChargeCreationListBasic(CHSChargeCreationINVO chsChargeCreationINVO) throws EventException {
		try {
			
			return dbDao.searchCHSChargeCreationListData(chsChargeCreationINVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}
	
	/**
	 * Retrieve Charge Creation result value.(Chassis)[EES_CGM_1029]<br>
	 * 
	 * @param chsChargeCreationINVO   CHSChargeCreationINVO
	 * @return List<CHSChargeCreationMGTVO>
	 * @exception EventException
	 */
	public List<CHSChargeCreationMGTVO> searchCHSChargeCreationResultBasic(CHSChargeCreationINVO chsChargeCreationINVO) throws EventException {
		try {
			
			return dbDao.searchCHSChargeCreationResultData(chsChargeCreationINVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}
	
	/**
	 * Create that month Charge of selected agreement this month.(Chassis)[EES_CGM_1029]<br>
	 * 
	 * @param chsChargeCreationINVOS CHSChargeCreationINVO[]
	 * @param chsChargeCreationINVO CHSChargeCreationINVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void createCHSChargeBasic (CHSChargeCreationINVO[] chsChargeCreationINVOS, 
			CHSChargeCreationINVO chsChargeCreationINVO, SignOnUserAccount account) throws EventException {
		
		try {
			
			/*------------------------------
				Delete Charge 
			-------------------------------*/
			// delete handling in case of existing charge sequence 
			if(!chsChargeCreationINVO.getChgCreSeq().equals("")){
				
				// delete CGM_LSE_CHG_DTL 
				dbDao.removeCHSChargeDetailData(chsChargeCreationINVO);
				
				// delete CGM_LSE_CHG_HDR 
				dbDao.removeCHSChargeSummaryData(chsChargeCreationINVO);
			}
		
			/*-------------------------------
			 	Charge Create Sequence
			--------------------------------*/
			long chgCreSeq = dbDao.searchCHSChargeCreateSeqData();
			chsChargeCreationINVO.setChgCreSeq(String.valueOf(chgCreSeq));
			
			/*------------------------------
			  	setting parameter
			-------------------------------*/
			// List<CHSChargeCreationINVO> value setting
			List<CHSChargeCreationINVO> chargeList = new ArrayList<CHSChargeCreationINVO>();
			
			for(int i=0; i< chsChargeCreationINVOS.length; i++){
				CHSChargeCreationINVO tempINVO = new CHSChargeCreationINVO();
				
				tempINVO.setCostYrmon(chsChargeCreationINVO.getCostYrmon());
				tempINVO.setEqKndCd(chsChargeCreationINVO.getEqKndCd());
				tempINVO.setAgmtOfcCtyCd(chsChargeCreationINVOS[i].getAgmtOfcCtyCd());
				tempINVO.setAgmtSeq(chsChargeCreationINVOS[i].getAgmtSeq());
				tempINVO.setChgCreSeq(String.valueOf(chgCreSeq));
				tempINVO.setCreOfcCd(account.getOfc_cd());
				tempINVO.setCreUsrId(account.getUsr_id());
				tempINVO.setUpdUsrId(account.getUsr_id());
				
				chargeList.add(tempINVO);
			}
			
			/*---------------------------
				Create Charge
			----------------------------*/
			
			// Create Charge Summary (header)
			dbDao.addCHSChageCreateSummaryData(chargeList);
			
			// Create PDM
			dbDao.addCHSChargeCreatePDMData(chargeList);
			
			// Create HON
			dbDao.addCHSChargeCreateHONData(chargeList);
			
			// Create HOF
			dbDao.addCHSChargeCreateHOFData(chargeList);
			
			// Update Charge Summary (header)
			dbDao.modifyCHSChargeCreateChgSummaryData(chargeList);
				    
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}
	
	/**
	 * Delete selected Charge.(Chassis)[EES_CGM_1029]<br>
	 * 
	 * @param chsChargeCreationINVOS CHSChargeCreationINVO[]
	 * @param chsChargeCreationINVO CHSChargeCreationINVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void removeCHSChargeBasic (CHSChargeCreationINVO[] chsChargeCreationINVOS, 
				CHSChargeCreationINVO chsChargeCreationINVO, SignOnUserAccount account) throws EventException {
		
		try {
			// CGM_LSE_CHG_DTL deleting
			dbDao.removeCHSChargeDetailData(chsChargeCreationINVO);
			
			// CGM_LSE_CHG_HDR deleting
			dbDao.removeCHSChargeSummaryData(chsChargeCreationINVO);
			
			// CGM_PAY_INV deleting (in case of P.Amt Confirm)
			if(chsChargeCreationINVO.getLseChgStsCd().equals("S")){
				dbDao.removeCHSChargeInvoiceData(chsChargeCreationINVO);
			}
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}
	
	/**
	 * Retrieve Charge creation list on this month.(M.G.Set)[EES_CGM_2032]<br>
	 * 
	 * @param mgsChargeCreationINVO   MGSChargeCreationINVO
	 * @return List<MGSChargeCreationMGTVO>
	 * @exception EventException
	 */
	public List<MGSChargeCreationMGTVO> searchMGSChargeCreationListBasic(MGSChargeCreationINVO mgsChargeCreationINVO) throws EventException {
		try {
			
			return dbDao.searchMGSChargeCreationListData(mgsChargeCreationINVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}
	
	/**
	 * Retrieve Charge Creation result value.(M.G.Set)[EES_CGM_2032]<br>
	 * 
	 * @param mgsChargeCreationINVO   MGSChargeCreationINVO
	 * @return List<MGSChargeCreationMGTVO>
	 * @exception EventException
	 */
	public List<MGSChargeCreationMGTVO> searchMGSChargeCreationResultBasic(MGSChargeCreationINVO mgsChargeCreationINVO) throws EventException {
		try {
			
			return dbDao.searchMGSChargeCreationResultData(mgsChargeCreationINVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}
	
	/**
	 * Create that month Charge of selected agreement that month.(M.G.Set)[EES_CGM_2032]<br>
	 * 
	 * @param mgsChargeCreationINVOS MGSChargeCreationINVO[]
	 * @param mgsChargeCreationINVO MGSChargeCreationINVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void createMGSChargeBasic (MGSChargeCreationINVO[] mgsChargeCreationINVOS, 
			MGSChargeCreationINVO mgsChargeCreationINVO, SignOnUserAccount account) throws EventException {
		
		try {
			
			/*------------------------------
				Delete Charge 
			-------------------------------*/
			// charge sequence deleting in case of existing
			if(!mgsChargeCreationINVO.getChgCreSeq().equals("")){
				
				// CGM_LSE_CHG_DTL deleting
				dbDao.removeMGSChargeDetailData(mgsChargeCreationINVO);
				
				// CGM_LSE_CHG_HDR deleting
				dbDao.removeMGSChargeSummaryData(mgsChargeCreationINVO);
			}
		
			/*-------------------------------
			 	Charge Create Sequence
			--------------------------------*/
			long chgCreSeq = dbDao.searchMGSChargeCreateSeqData();
			mgsChargeCreationINVO.setChgCreSeq(String.valueOf(chgCreSeq));
			
			/*------------------------------
			  	parameter setting
			-------------------------------*/
			// List<CHSChargeCreationINVO> value setting
			List<MGSChargeCreationINVO> chargeList = new ArrayList<MGSChargeCreationINVO>();
			
			for(int i=0; i< mgsChargeCreationINVOS.length; i++){
				MGSChargeCreationINVO tempINVO = new MGSChargeCreationINVO();
				
				tempINVO.setCostYrmon(mgsChargeCreationINVO.getCostYrmon());
				tempINVO.setEqKndCd(mgsChargeCreationINVO.getEqKndCd());
				tempINVO.setAgmtOfcCtyCd(mgsChargeCreationINVOS[i].getAgmtOfcCtyCd());
				tempINVO.setAgmtSeq(mgsChargeCreationINVOS[i].getAgmtSeq());
				tempINVO.setChgCreSeq(String.valueOf(chgCreSeq));
				tempINVO.setCreOfcCd(account.getOfc_cd());
				tempINVO.setCreUsrId(account.getUsr_id());
				tempINVO.setUpdUsrId(account.getUsr_id());
				
				chargeList.add(tempINVO);
			}
			
			/*---------------------------
				Create Charge
			----------------------------*/
			
			// Create Charge Summary (header)
			dbDao.addMGSChageCreateSummaryData(chargeList);
			
			// Create PDM
			dbDao.addMGSChargeCreatePDMData(chargeList);
			
			// Create HON
			dbDao.addMGSChargeCreateHONData(chargeList);
			
			// Create HOF
			dbDao.addMGSChargeCreateHOFData(chargeList);
			
			// Update Charge Summary (header)
			dbDao.modifyMGSChargeCreateChgSummaryData(chargeList);
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}
	
	/**
	 * Delete selected Charge.(M.G.Set)[EES_CGM_2032]<br>
	 * 
	 * @param mgsChargeCreationINVOS MGSChargeCreationINVO[]
	 * @param mgsChargeCreationINVO MGSChargeCreationINVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void removeMGSChargeBasic (MGSChargeCreationINVO[] mgsChargeCreationINVOS, 
				MGSChargeCreationINVO mgsChargeCreationINVO, SignOnUserAccount account) throws EventException {
		
		try {
			/*------------------------------
				Delete Charge 
			-------------------------------*/
			// CGM_LSE_CHG_DTL deleting
			dbDao.removeMGSChargeDetailData(mgsChargeCreationINVO);
			
			// CGM_LSE_CHG_HDR deleting
			dbDao.removeMGSChargeSummaryData(mgsChargeCreationINVO);
			
			// CGM_PAY_INV deleting (in case of P.Amt Confirm)
			if(mgsChargeCreationINVO.getLseChgStsCd().equals("S")){
				dbDao.removeMGSChargeInvoiceData(mgsChargeCreationINVO);
			}
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}
	
	/**
	 * Retrieve saved Pool Estimate Amount. Retrieve .  [EES_CGM_1125]<br>
	 * 
	 * @param poolEstmExpenseINVO PoolEstmExpenseINVO 
	 * @return List<PoolEstmExpenseMGTVO>
	 * @exception EventException
	 */
	public List<PoolEstmExpenseMGTVO> searchPoolEstimateAmtBasic(PoolEstmExpenseINVO poolEstmExpenseINVO)  throws EventException {
		try {
			if(poolEstmExpenseINVO.getChssPoolTpCd().equals("NP")){
				String chssPoolCd = "";
				String agmtSeq    = "";
				chssPoolCd = poolEstmExpenseINVO.getChssPoolCd().substring(0,3);
				agmtSeq    = poolEstmExpenseINVO.getChssPoolCd().substring(3,poolEstmExpenseINVO.getChssPoolCd().length());
				poolEstmExpenseINVO.setAgmtOfcCtyCd(chssPoolCd);
				poolEstmExpenseINVO.setAgmtSeq(""+Integer.parseInt(agmtSeq));
				poolEstmExpenseINVO.setChssPoolCd("");
			}
			return dbDao.searchPoolEstimateAmtData(poolEstmExpenseINVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}
	
	/**
	 * Save CGM_CHSS_POOL_EXPN_ESTM entity. Save .  [EES_CGM_1125]<br>
	 * 
	 * @param poolEstmExpenseMGTVOs PoolEstmExpenseMGTVO[] 
     * @param account SignOnUserAccount 
	 * @exception EventException
	 */
	public void modifyPoolEstimateAmtBasic (PoolEstmExpenseMGTVO[] poolEstmExpenseMGTVOs, SignOnUserAccount account) throws EventException  {
		
		List<PoolEstmExpenseMGTVO> updateVoList = new ArrayList<PoolEstmExpenseMGTVO>();
		List<PoolEstmExpenseMGTVO> indateVoList = new ArrayList<PoolEstmExpenseMGTVO>();
		
		try {
			log.debug("poolEstmExpenseMGTVOs.length============="+poolEstmExpenseMGTVOs.length);
			for ( int i=0; i<poolEstmExpenseMGTVOs.length; i++ ) {
				poolEstmExpenseMGTVOs[i].setCreUsrId(account.getUsr_id());
				poolEstmExpenseMGTVOs[i].setUpdUsrId(account.getUsr_id());
				if(poolEstmExpenseMGTVOs[i].getIbflag().equals("I")){
					if(poolEstmExpenseMGTVOs[i].getChssPoolTpCd().equals("NP")){
						String chssPoolCd = "";
						String agmtSeq    = "";
						chssPoolCd = poolEstmExpenseMGTVOs[i].getChssPoolCd().substring(0,3);
						agmtSeq    = poolEstmExpenseMGTVOs[i].getChssPoolCd().substring(3,poolEstmExpenseMGTVOs[i].getChssPoolCd().length());
						poolEstmExpenseMGTVOs[i].setAgmtOfcCtyCd(chssPoolCd);
						poolEstmExpenseMGTVOs[i].setAgmtSeq(""+Integer.parseInt(agmtSeq));
						poolEstmExpenseMGTVOs[i].setChssPoolCd("");
					}
					indateVoList.add(poolEstmExpenseMGTVOs[i]);
				} else {
					updateVoList.add(poolEstmExpenseMGTVOs[i]);
				}
			}
			
			if(indateVoList.size()>0){
				dbDao.addPoolEstimateAmtData(indateVoList);
			}	
			
			if(updateVoList.size()>0){
				dbDao.modifyPoolEstimateAmtData(updateVoList);
			}	
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}
	
	/**
	 * Retrieve Estimate amount by Year, Month, Pool List of Pool type. Retrieve .  [EES_CGM_1126]<br>
	 * 
	 * @param poolEstmExpenseINVO PoolEstmExpenseINVO 
	 * @return List<PoolEstmExpenseMGTVO>
	 * @exception EventException
	 */
	public List<PoolEstmExpenseMGTVO> searchPoolEstimateReportBasic(PoolEstmExpenseINVO poolEstmExpenseINVO)  throws EventException {
		try {
			List<PoolEstmExpenseMGTVO> resultData = new ArrayList<PoolEstmExpenseMGTVO>();
			
			String div = poolEstmExpenseINVO.getChssPoolTpCd();
			String[] values = div.split(",");
			for(int i=0; i< values.length; i++)
			{
				log.debug("chungpa>> values["+i+"] = " + values[i]);
				poolEstmExpenseINVO.setChssPoolTpCd(values[i]);
				List<PoolEstmExpenseMGTVO> resultOne =  dbDao.searchPoolEstimateReportData(poolEstmExpenseINVO);
				if(resultOne!= null)
				{
					if(	resultOne.size() > 0)
					{
						resultData.addAll(resultOne);
					}
				}
			}			
			return resultData;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}
	
	/**
	 * Action Verify by EQ unit Invoice draft data that loaded on page.(Chassis)[EES_CGM_1030]<br>
	 * 
	 * @param cHSInvoiceImportAuditINVOs CHSInvoiceImportAuditINVO[]
	 * @param cHSInvoiceImportAuditINVO CHSInvoiceImportAuditINVO
	 * @param account SignOnUserAccount 
	 * @return List<CHSInvoiceImportAuditMGTVO>
	 * @exception EventException
	 */
	public List<CHSInvoiceImportAuditMGTVO> verifyCHSInvoiceDraftBasic(CHSInvoiceImportAuditINVO[] cHSInvoiceImportAuditINVOs,
			CHSInvoiceImportAuditINVO cHSInvoiceImportAuditINVO,SignOnUserAccount account ) throws EventException 
	{
		List<CHSInvoiceImportAuditINVO> list1 = new ArrayList<CHSInvoiceImportAuditINVO>();
		List<CHSInvoiceImportAuditMGTVO> list2 = null;
		try {
			//VERIFY step.l> removeCHSLeaseInvoiceData calling
			dbDao.removeCHSLeaseInvoiceData(cHSInvoiceImportAuditINVO);
			
			//VERIFY step.2> addCHSLeaseInvoiceData calling
			for(int i=0; i < cHSInvoiceImportAuditINVOs.length; i++){
				CHSInvoiceImportAuditINVO tmpChsInvoiceImportAuditINVO = new CHSInvoiceImportAuditINVO();
				
				String sVerifyStatus	= "";//"OK";
				String sAgmtOfcCtyCd	= "";
				String sAgmtSeq			= "";
				String sAgmtVerNo		= "";
				String sAgmtLstmCd		= "";
				String sVerifySuccess	= "N";//"Y";
				
				//common
				tmpChsInvoiceImportAuditINVO.setEqKndCd(cHSInvoiceImportAuditINVO.getEqKndCd());
				tmpChsInvoiceImportAuditINVO.setCostYrmon(cHSInvoiceImportAuditINVO.getCostYrmon().replaceAll("-", ""));
				tmpChsInvoiceImportAuditINVO.setChgCreSeq(cHSInvoiceImportAuditINVO.getChgCreSeq());
				//EXCEL
				tmpChsInvoiceImportAuditINVO.setInvCustEqNo(cHSInvoiceImportAuditINVOs[i].getInvCustEqNo());
				tmpChsInvoiceImportAuditINVO.setInvEqNo(cHSInvoiceImportAuditINVOs[i].getInvEqNo());								// Chassis No.
				tmpChsInvoiceImportAuditINVO.setInvRefNo(cHSInvoiceImportAuditINVOs[i].getInvRefNo());
				tmpChsInvoiceImportAuditINVO.setInvNo(cHSInvoiceImportAuditINVOs[i].getInvNo());
				tmpChsInvoiceImportAuditINVO.setChgCd(cHSInvoiceImportAuditINVOs[i].getChgCd());									// Charge Type
				tmpChsInvoiceImportAuditINVO.setInvChgTpNm(cHSInvoiceImportAuditINVOs[i].getInvChgTpNm());									// Charge Type
				
				tmpChsInvoiceImportAuditINVO.setInvEqOnhLocNm(cHSInvoiceImportAuditINVOs[i].getInvEqOnhLocNm());
				tmpChsInvoiceImportAuditINVO.setInvEqOnhDt(cHSInvoiceImportAuditINVOs[i].getInvEqOnhDt().replaceAll("-", ""));		// On-Hire Date
				tmpChsInvoiceImportAuditINVO.setInvBilStDt(cHSInvoiceImportAuditINVOs[i].getInvBilStDt().replaceAll("-", ""));		// Billing Start Date
				tmpChsInvoiceImportAuditINVO.setInvEqOffhLocNm(cHSInvoiceImportAuditINVOs[i].getInvEqOffhLocNm());	
				tmpChsInvoiceImportAuditINVO.setInvEqOffhDt(cHSInvoiceImportAuditINVOs[i].getInvEqOffhDt().replaceAll("-", ""));	// Off-Hire Date
				tmpChsInvoiceImportAuditINVO.setInvBilEndDt(cHSInvoiceImportAuditINVOs[i].getInvBilEndDt().replaceAll("-", ""));	// Billing End Date
				tmpChsInvoiceImportAuditINVO.setInvLseUseDys(cHSInvoiceImportAuditINVOs[i].getInvLseUseDys().replaceAll(",", "").replaceAll(" ", ""));
				tmpChsInvoiceImportAuditINVO.setInvLseRtAmt(cHSInvoiceImportAuditINVOs[i].getInvLseRtAmt().replaceAll(",", "").replaceAll(" ", ""));
				tmpChsInvoiceImportAuditINVO.setInvLseChgAmt(cHSInvoiceImportAuditINVOs[i].getInvLseChgAmt().replaceAll(",", "").replaceAll(" ", ""));
				tmpChsInvoiceImportAuditINVO.setInvTaxAmt(cHSInvoiceImportAuditINVOs[i].getInvTaxAmt());
				//PRE INIT
				tmpChsInvoiceImportAuditINVO.setVrfyRsltDesc(sVerifyStatus);
				tmpChsInvoiceImportAuditINVO.setAgmtOfcCtyCd(sAgmtOfcCtyCd);
				tmpChsInvoiceImportAuditINVO.setAgmtSeq(sAgmtSeq);
				tmpChsInvoiceImportAuditINVO.setAgmtVerNo(sAgmtVerNo);
				tmpChsInvoiceImportAuditINVO.setAgmtLstmCd(sAgmtLstmCd);
				tmpChsInvoiceImportAuditINVO.setVrfyScsFlg(sVerifySuccess);		
				
				tmpChsInvoiceImportAuditINVO.setCreUsrId(account.getUsr_id());
				tmpChsInvoiceImportAuditINVO.setUpdUsrId(account.getUsr_id());
				
				list1.add(tmpChsInvoiceImportAuditINVO);
			}			
			if(list1.size()>0)
			{
				dbDao.addCHSLeaseInvoiceData(list1);
			}else{
				throw new DAOException();
			}
			
			//VERIFY step.3> searchCHSLeaseInvoiceVerifyData calling
			list2 = dbDao.searchCHSLeaseInvoiceVerifyData(cHSInvoiceImportAuditINVO); 
			return list2;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}
	
	/**
	 * Action Verify Insert by EQ unit Invoice draft data that loaded on page.(Chassis)[EES_CGM_1030]<br>
	 * 
	 * @param cHSInvoiceImportAuditINVOs CHSInvoiceImportAuditINVO[]
	 * @param cHSInvoiceImportAuditINVO CHSInvoiceImportAuditINVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void verifyCHSInvoiceDraftInsertBasic(CHSInvoiceImportAuditINVO[] cHSInvoiceImportAuditINVOs,
			CHSInvoiceImportAuditINVO cHSInvoiceImportAuditINVO,SignOnUserAccount account) throws EventException
	{
		List<CHSInvoiceImportAuditINVO> list1 = new ArrayList<CHSInvoiceImportAuditINVO>();
		try {
			//VERIFY step.1> removeCHSLeaseInvoiceData calling
			dbDao.removeCHSLeaseInvoiceData(cHSInvoiceImportAuditINVO);
			
			//VERIFY step.2> addCHSLeaseInvoiceData calling
			for(int i=0; i < cHSInvoiceImportAuditINVOs.length; i++){
				CHSInvoiceImportAuditINVO tmpChsInvoiceImportAuditINVO = new CHSInvoiceImportAuditINVO();
				
				String sVerifyStatus	= "";//"OK";
				String sAgmtOfcCtyCd	= "";
				String sAgmtSeq			= "";
				String sAgmtVerNo		= "";
				String sAgmtLstmCd		= "";
				String sVerifySuccess	= "N";//"Y";
				
				//common
				tmpChsInvoiceImportAuditINVO.setEqKndCd(cHSInvoiceImportAuditINVO.getEqKndCd());
				tmpChsInvoiceImportAuditINVO.setCostYrmon(cHSInvoiceImportAuditINVO.getCostYrmon().replaceAll("-", ""));
				tmpChsInvoiceImportAuditINVO.setChgCreSeq(cHSInvoiceImportAuditINVO.getChgCreSeq());
				//EXCEL
				tmpChsInvoiceImportAuditINVO.setInvCustEqNo(cHSInvoiceImportAuditINVOs[i].getInvCustEqNo());
				tmpChsInvoiceImportAuditINVO.setInvEqNo(cHSInvoiceImportAuditINVOs[i].getInvEqNo());								// Chassis No.
				tmpChsInvoiceImportAuditINVO.setInvRefNo(cHSInvoiceImportAuditINVOs[i].getInvRefNo());
				tmpChsInvoiceImportAuditINVO.setInvNo(cHSInvoiceImportAuditINVOs[i].getInvNo());
				tmpChsInvoiceImportAuditINVO.setChgCd(cHSInvoiceImportAuditINVOs[i].getChgCd());									// Charge Type
				tmpChsInvoiceImportAuditINVO.setInvChgTpNm(cHSInvoiceImportAuditINVOs[i].getInvChgTpNm());									// Charge Type
				
				tmpChsInvoiceImportAuditINVO.setInvEqOnhLocNm(cHSInvoiceImportAuditINVOs[i].getInvEqOnhLocNm());
				tmpChsInvoiceImportAuditINVO.setInvEqOnhDt(cHSInvoiceImportAuditINVOs[i].getInvEqOnhDt().replaceAll("-", ""));		// On-Hire Date
				tmpChsInvoiceImportAuditINVO.setInvBilStDt(cHSInvoiceImportAuditINVOs[i].getInvBilStDt().replaceAll("-", ""));		// Billing Start Date
				tmpChsInvoiceImportAuditINVO.setInvEqOffhLocNm(cHSInvoiceImportAuditINVOs[i].getInvEqOffhLocNm());	
				tmpChsInvoiceImportAuditINVO.setInvEqOffhDt(cHSInvoiceImportAuditINVOs[i].getInvEqOffhDt().replaceAll("-", ""));	// Off-Hire Date
				tmpChsInvoiceImportAuditINVO.setInvBilEndDt(cHSInvoiceImportAuditINVOs[i].getInvBilEndDt().replaceAll("-", ""));	// Billing End Date
				tmpChsInvoiceImportAuditINVO.setInvLseUseDys(cHSInvoiceImportAuditINVOs[i].getInvLseUseDys().replaceAll(",", "").replaceAll(" ", ""));
				tmpChsInvoiceImportAuditINVO.setInvLseRtAmt(cHSInvoiceImportAuditINVOs[i].getInvLseRtAmt().replaceAll(",", "").replaceAll(" ", ""));
				tmpChsInvoiceImportAuditINVO.setInvLseChgAmt(cHSInvoiceImportAuditINVOs[i].getInvLseChgAmt().replaceAll(",", "").replaceAll(" ", ""));
				tmpChsInvoiceImportAuditINVO.setInvTaxAmt(cHSInvoiceImportAuditINVOs[i].getInvTaxAmt());
				//PRE INIT
				tmpChsInvoiceImportAuditINVO.setVrfyRsltDesc(sVerifyStatus);
				tmpChsInvoiceImportAuditINVO.setAgmtOfcCtyCd(sAgmtOfcCtyCd);
				tmpChsInvoiceImportAuditINVO.setAgmtSeq(sAgmtSeq);
				tmpChsInvoiceImportAuditINVO.setAgmtVerNo(sAgmtVerNo);
				tmpChsInvoiceImportAuditINVO.setAgmtLstmCd(sAgmtLstmCd);
				tmpChsInvoiceImportAuditINVO.setVrfyScsFlg(sVerifySuccess);		
				
				tmpChsInvoiceImportAuditINVO.setCreUsrId(account.getUsr_id());
				tmpChsInvoiceImportAuditINVO.setUpdUsrId(account.getUsr_id());
				
				list1.add(tmpChsInvoiceImportAuditINVO);
			}			
			if(list1.size()>0)
			{
				dbDao.addCHSLeaseInvoiceData(list1);
			}else{
				throw new DAOException();
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}		
	}

	/**
	 *  Action Verify Search by EQ unit Invoice draft data that loaded on page.(Chassis)[EES_CGM_1030]<br>
	 * 
	 * @param cHSInvoiceImportAuditINVO CHSInvoiceImportAuditINVO
	 * @return List<CHSInvoiceImportAuditMGTVO>
	 * @exception EventException
	 */
	public List<CHSInvoiceImportAuditMGTVO> verifyCHSInvoiceDraftSearchBasic(CHSInvoiceImportAuditINVO cHSInvoiceImportAuditINVO) throws EventException
	{
		List<CHSInvoiceImportAuditMGTVO> list2 = null;
		try {
			//VERIFY step.3> searchCHSLeaseInvoiceVerifyData calling
			list2 = dbDao.searchCHSLeaseInvoiceVerifyData(cHSInvoiceImportAuditINVO); 
			return list2;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}		
	}

	/**
	 * Action Verify Insert by EQ unit Invoice draft data that loaded on page.(M.G.Set)[EES_CGM_2085]<br>
	 * 
	 * @param mGSInvoiceImportAuditINVOs MGSInvoiceImportAuditINVO[]
	 * @param mGSInvoiceImportAuditINVO MGSInvoiceImportAuditINVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void verifyMGSInvoiceDraftInsertBasic(MGSInvoiceImportAuditINVO[] mGSInvoiceImportAuditINVOs,
			MGSInvoiceImportAuditINVO mGSInvoiceImportAuditINVO,SignOnUserAccount account) throws EventException
	{
		List<MGSInvoiceImportAuditINVO> list1 = new ArrayList<MGSInvoiceImportAuditINVO>();
		try {
			//VERIFY step.1> removeMGSLeaseInvoiceData calling
			dbDao.removeMGSLeaseInvoiceData(mGSInvoiceImportAuditINVO);
			
			//VERIFY step.2> addMGSLeaseInvoiceData calling
			for(int i=0; i < mGSInvoiceImportAuditINVOs.length; i++){
				MGSInvoiceImportAuditINVO tmpMgsInvoiceImportAuditINVO = new MGSInvoiceImportAuditINVO();
				
				String sVerifyStatus	= "";//"OK";
				String sAgmtOfcCtyCd	= "";
				String sAgmtSeq			= "";
				String sAgmtVerNo		= "";
				String sAgmtLstmCd		= "";
				String sVerifySuccess	= "N";//"Y";
				
				//common
				tmpMgsInvoiceImportAuditINVO.setEqKndCd(mGSInvoiceImportAuditINVO.getEqKndCd());
				tmpMgsInvoiceImportAuditINVO.setCostYrmon(mGSInvoiceImportAuditINVO.getCostYrmon().replaceAll("-", ""));
				tmpMgsInvoiceImportAuditINVO.setChgCreSeq(mGSInvoiceImportAuditINVO.getChgCreSeq());
				//EXCEL
				tmpMgsInvoiceImportAuditINVO.setInvCustEqNo(mGSInvoiceImportAuditINVOs[i].getInvCustEqNo());
				tmpMgsInvoiceImportAuditINVO.setInvEqNo(mGSInvoiceImportAuditINVOs[i].getInvEqNo());								// Chassis No.
				tmpMgsInvoiceImportAuditINVO.setInvRefNo(mGSInvoiceImportAuditINVOs[i].getInvRefNo());
				tmpMgsInvoiceImportAuditINVO.setInvNo(mGSInvoiceImportAuditINVOs[i].getInvNo());
				tmpMgsInvoiceImportAuditINVO.setChgCd(mGSInvoiceImportAuditINVOs[i].getChgCd());									// Charge Type
				tmpMgsInvoiceImportAuditINVO.setInvChgTpNm(mGSInvoiceImportAuditINVOs[i].getInvChgTpNm());									// Charge Type
				
				tmpMgsInvoiceImportAuditINVO.setInvEqOnhLocNm(mGSInvoiceImportAuditINVOs[i].getInvEqOnhLocNm());
				tmpMgsInvoiceImportAuditINVO.setInvEqOnhDt(mGSInvoiceImportAuditINVOs[i].getInvEqOnhDt().replaceAll("-", ""));		// On-Hire Date
				tmpMgsInvoiceImportAuditINVO.setInvBilStDt(mGSInvoiceImportAuditINVOs[i].getInvBilStDt().replaceAll("-", ""));		// Billing Start Date
				tmpMgsInvoiceImportAuditINVO.setInvEqOffhLocNm(mGSInvoiceImportAuditINVOs[i].getInvEqOffhLocNm());	
				tmpMgsInvoiceImportAuditINVO.setInvEqOffhDt(mGSInvoiceImportAuditINVOs[i].getInvEqOffhDt().replaceAll("-", ""));	// Off-Hire Date
				tmpMgsInvoiceImportAuditINVO.setInvBilEndDt(mGSInvoiceImportAuditINVOs[i].getInvBilEndDt().replaceAll("-", ""));	// Billing End Date
				tmpMgsInvoiceImportAuditINVO.setInvLseUseDys(mGSInvoiceImportAuditINVOs[i].getInvLseUseDys().replaceAll(",", "").replaceAll(" ", ""));
				tmpMgsInvoiceImportAuditINVO.setInvLseRtAmt(mGSInvoiceImportAuditINVOs[i].getInvLseRtAmt().replaceAll(",", "").replaceAll(" ", ""));
				tmpMgsInvoiceImportAuditINVO.setInvLseChgAmt(mGSInvoiceImportAuditINVOs[i].getInvLseChgAmt().replaceAll(",", "").replaceAll(" ", ""));
				tmpMgsInvoiceImportAuditINVO.setInvTaxAmt(mGSInvoiceImportAuditINVOs[i].getInvTaxAmt());
				//PRE INIT
				tmpMgsInvoiceImportAuditINVO.setVrfyRsltDesc(sVerifyStatus);
				tmpMgsInvoiceImportAuditINVO.setAgmtOfcCtyCd(sAgmtOfcCtyCd);
				tmpMgsInvoiceImportAuditINVO.setAgmtSeq(sAgmtSeq);
				tmpMgsInvoiceImportAuditINVO.setAgmtVerNo(sAgmtVerNo);
				tmpMgsInvoiceImportAuditINVO.setAgmtLstmCd(sAgmtLstmCd);
				tmpMgsInvoiceImportAuditINVO.setVrfyScsFlg(sVerifySuccess);		
				
				tmpMgsInvoiceImportAuditINVO.setCreUsrId(account.getUsr_id());
				tmpMgsInvoiceImportAuditINVO.setUpdUsrId(account.getUsr_id());
				
				list1.add(tmpMgsInvoiceImportAuditINVO);
			}			
			if(list1.size()>0)
			{
				dbDao.addMGSLeaseInvoiceData(list1);
			}else{
				throw new DAOException();
			}

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}		
	}

	/**
	 * Action Verify Search by EQ unit Invoice draft data that loaded on page.(M.G.Set)[EES_CGM_2085]<br>
	 * 
	 * @param mGSInvoiceImportAuditINVO MGSInvoiceImportAuditINVO
	 * @return List<MGSInvoiceImportAuditMGTVO>
	 * @exception EventException
	 */
	public List<MGSInvoiceImportAuditMGTVO> verifyMGSInvoiceDraftSearchBasic(MGSInvoiceImportAuditINVO mGSInvoiceImportAuditINVO) throws EventException
	{
		List<MGSInvoiceImportAuditMGTVO> list2 = null;
		try {
			//VERIFY step.3> searchMGSLeaseInvoiceVerifyData calling
			list2 = dbDao.searchMGSLeaseInvoiceVerifyData(mGSInvoiceImportAuditINVO); 
			return list2;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}		
	}
	
	/**
	 *Audit and Save invoice draft that loaded on Invoice import page.(Chssis)[EES_CGM_1030]<br>
	 * 
	 * @param cHSInvoiceImportAuditINVOs CHSInvoiceImportAuditINVO[]
	 * @param cHSInvoiceImportAuditINVO CHSInvoiceImportAuditINVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void auditCHSInvoiceDraftBasic(CHSInvoiceImportAuditINVO[] cHSInvoiceImportAuditINVOs, 
			CHSInvoiceImportAuditINVO cHSInvoiceImportAuditINVO, SignOnUserAccount account) throws EventException 
	{
		try {
			
			//--------------------------------------------
		 	//	data delete handling
			//--------------------------------------------
			CHSInvoiceImportAuditINVO chsInvoiceImportAuditINVO3 = cHSInvoiceImportAuditINVO;
			chsInvoiceImportAuditINVO3.setUpdUsrId(account.getUsr_id());
			chsInvoiceImportAuditINVO3.setLseChgAudStsCd("H");
			chsInvoiceImportAuditINVO3.setLseChgStsCd("H");
			chsInvoiceImportAuditINVO3.setPayLseChgStsCd("H");
			
			dbDao.removeCHSInvImportDtlData(chsInvoiceImportAuditINVO3);
			dbDao.modifyCHSInvImportDtlData(chsInvoiceImportAuditINVO3);
			dbDao.modifyCHSInvImportHdrData(chsInvoiceImportAuditINVO3);
		
			
			//--------------------------------------------
	 		//	data delete handling start
		 	//--------------------------------------------
			
			List<CHSInvoiceImportAuditINVO> insertList = new ArrayList<CHSInvoiceImportAuditINVO>();
			List<CHSInvoiceImportAuditINVO> updateList = new ArrayList<CHSInvoiceImportAuditINVO>();
			insertList.clear();
			updateList.clear();
			for(int i=0; i < cHSInvoiceImportAuditINVOs.length; i++)
			{
				CHSInvoiceImportAuditINVO tempINVO = new CHSInvoiceImportAuditINVO();
				
				tempINVO.setAgmtOfcCtyCd(cHSInvoiceImportAuditINVOs[i].getAgmtOfcCtyCd());
				tempINVO.setAgmtSeq(cHSInvoiceImportAuditINVOs[i].getAgmtSeq());
				tempINVO.setAgmtVerNo(cHSInvoiceImportAuditINVOs[i].getAgmtVerNo());
				tempINVO.setCostYrmon(cHSInvoiceImportAuditINVO.getCostYrmon());
				tempINVO.setEqKndCd(cHSInvoiceImportAuditINVO.getEqKndCd());
				tempINVO.setEqNo(cHSInvoiceImportAuditINVOs[i].getInvEqNo());
				
				tempINVO.setChgCd(cHSInvoiceImportAuditINVOs[i].getChgCd());
				tempINVO.setLseChgAudStsCd(cHSInvoiceImportAuditINVOs[i].getLseChgAudStsCd());
				tempINVO.setPayLseChgStsCd(cHSInvoiceImportAuditINVOs[i].getLseChgAudStsCd());
				tempINVO.setLseChgAudRsltRsnCd(cHSInvoiceImportAuditINVOs[i].getLseChgAudRsltRsnCd());
				
				tempINVO.setInvNo(cHSInvoiceImportAuditINVOs[i].getInvNo());
				tempINVO.setInvSeq(cHSInvoiceImportAuditINVOs[i].getInvSeq());
				tempINVO.setInvRefNo(cHSInvoiceImportAuditINVOs[i].getInvRefNo());
				tempINVO.setInvEqNo(cHSInvoiceImportAuditINVOs[i].getInvEqNo());
				tempINVO.setInvCustEqNo(cHSInvoiceImportAuditINVOs[i].getInvCustEqNo());
				tempINVO.setInvEqOnhDt(cHSInvoiceImportAuditINVOs[i].getInvEqOnhDt().replaceAll("-", ""));
				tempINVO.setInvEqOnhLocNm(cHSInvoiceImportAuditINVOs[i].getInvEqOnhLocNm());
				tempINVO.setInvEqOffhDt(cHSInvoiceImportAuditINVOs[i].getInvEqOffhDt().replaceAll("-", ""));
				tempINVO.setInvEqOffhLocNm(cHSInvoiceImportAuditINVOs[i].getInvEqOffhLocNm());
				tempINVO.setInvBilStDt(cHSInvoiceImportAuditINVOs[i].getInvBilStDt().replaceAll("-", ""));
				tempINVO.setInvBilEndDt(cHSInvoiceImportAuditINVOs[i].getInvBilEndDt().replaceAll("-", ""));
				tempINVO.setInvLseUseDys(cHSInvoiceImportAuditINVOs[i].getInvLseUseDys().replaceAll(",", "").replaceAll(" ", ""));
	
				tempINVO.setInvLseRtAmt(cHSInvoiceImportAuditINVOs[i].getInvLseRtAmt().replaceAll(",", "").replaceAll(" ", ""));
				tempINVO.setInvLseChgAmt(cHSInvoiceImportAuditINVOs[i].getInvLseChgAmt().replaceAll(",", "").replaceAll(" ", ""));
				
				tempINVO.setCostCd(cHSInvoiceImportAuditINVOs[i].getCostCd());
				tempINVO.setAcctCd(cHSInvoiceImportAuditINVOs[i].getAcctCd());
				tempINVO.setCreUsrId(account.getUsr_id());
				tempINVO.setUpdUsrId(account.getUsr_id());
				
				tempINVO.setEqNo(cHSInvoiceImportAuditINVOs[i].getEqNo()); 
				if(tempINVO.getLseChgAudStsCd().equals("I")){
					insertList.add(tempINVO);
				} else {
					updateList.add(tempINVO);
				}
			}
			
			//--------------------------------------------
			// 	Audit data save to DB
			//--------------------------------------------
			
			// Detail Data save
			dbDao.addCHSAuditInvoiceDetailData(insertList);
			dbDao.modifyCHSAuditInvoiceDetailData(updateList);
			dbDao.modifyCHSChargeOnlyUmchStatusData(cHSInvoiceImportAuditINVO);
			
			// Header Data save
			List<CHSInvoiceImportAuditMGTVO> targetList = dbDao.searchCHSInvImportSumAmtData(cHSInvoiceImportAuditINVO);
			List<CHSInvoiceImportAuditINVO> headerList = new ArrayList<CHSInvoiceImportAuditINVO>();
			for(int x=0; x < targetList.size(); x++){
				
				CHSInvoiceImportAuditMGTVO targetData = (CHSInvoiceImportAuditMGTVO)targetList.get(x);
				
				CHSInvoiceImportAuditINVO headerData = new CHSInvoiceImportAuditINVO();
				
				headerData.setAgmtOfcCtyCd(targetData.getAgmtOfcCtyCd());
				headerData.setAgmtSeq(targetData.getAgmtSeq());
				headerData.setCostYrmon(targetData.getCostYrmon());
				headerData.setEqKndCd(targetData.getEqKndCd());
				
				headerData.setLseChgStsCd("A");	// AUDIT
				headerData.setCurrCd(cHSInvoiceImportAuditINVO.getCurrCd());
				headerData.setTaxSmryAmt(targetData.getTaxSmryAmt());
				headerData.setInvSmryAmt(targetData.getInvSmryAmt());
				headerData.setCrSmryAmt(targetData.getCrSmryAmt());
				headerData.setUpdUsrId(account.getUsr_id());
				
				headerList.add(headerData);
			}
			dbDao.modifyCHSAuditInvoiceHeaderData(headerList);

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
		
	}
	
	/**
	 * Verify Invoice draft data that loaded on page by EQ unit.(M.G.Set)[EES_CGM_2085]<br>
	 * 
	 * @param mGSInvoiceImportAuditINVOs MGSInvoiceImportAuditINVO[]
	 * @param mGSInvoiceImportAuditINVO MGSInvoiceImportAuditINVO
	 * @param account SignOnUserAccount
	 * @return List<MGSInvoiceImportAuditMGTVO>
	 * @exception EventException
	 */
	public List<MGSInvoiceImportAuditMGTVO> verifyMGSInvoiceDraftBasic(MGSInvoiceImportAuditINVO[] mGSInvoiceImportAuditINVOs,
			MGSInvoiceImportAuditINVO mGSInvoiceImportAuditINVO,SignOnUserAccount account ) throws EventException 
	{
		List<MGSInvoiceImportAuditINVO> list1 = new ArrayList<MGSInvoiceImportAuditINVO>();
		List<MGSInvoiceImportAuditMGTVO> list2 = null;
		try {
			//VERIFY step.1> removeMGSLeaseInvoiceData calling
			dbDao.removeMGSLeaseInvoiceData(mGSInvoiceImportAuditINVO);
			
			//VERIFY step.2> addMGSLeaseInvoiceData calling
			for(int i=0; i < mGSInvoiceImportAuditINVOs.length; i++){
				MGSInvoiceImportAuditINVO tmpMgsInvoiceImportAuditINVO = new MGSInvoiceImportAuditINVO();
				
				String sVerifyStatus	= "";//"OK";
				String sAgmtOfcCtyCd	= "";
				String sAgmtSeq			= "";
				String sAgmtVerNo		= "";
				String sAgmtLstmCd		= "";
				String sVerifySuccess	= "N";//"Y";
				
				//common
				tmpMgsInvoiceImportAuditINVO.setEqKndCd(mGSInvoiceImportAuditINVO.getEqKndCd());
				tmpMgsInvoiceImportAuditINVO.setCostYrmon(mGSInvoiceImportAuditINVO.getCostYrmon().replaceAll("-", ""));
				tmpMgsInvoiceImportAuditINVO.setChgCreSeq(mGSInvoiceImportAuditINVO.getChgCreSeq());
				//EXCEL
				tmpMgsInvoiceImportAuditINVO.setInvCustEqNo(mGSInvoiceImportAuditINVOs[i].getInvCustEqNo());
				tmpMgsInvoiceImportAuditINVO.setInvEqNo(mGSInvoiceImportAuditINVOs[i].getInvEqNo());								// Chassis No.
				tmpMgsInvoiceImportAuditINVO.setInvRefNo(mGSInvoiceImportAuditINVOs[i].getInvRefNo());
				tmpMgsInvoiceImportAuditINVO.setInvNo(mGSInvoiceImportAuditINVOs[i].getInvNo());
				tmpMgsInvoiceImportAuditINVO.setChgCd(mGSInvoiceImportAuditINVOs[i].getChgCd());									// Charge Type
				tmpMgsInvoiceImportAuditINVO.setInvChgTpNm(mGSInvoiceImportAuditINVOs[i].getInvChgTpNm());									// Charge Type
				
				tmpMgsInvoiceImportAuditINVO.setInvEqOnhLocNm(mGSInvoiceImportAuditINVOs[i].getInvEqOnhLocNm());
				tmpMgsInvoiceImportAuditINVO.setInvEqOnhDt(mGSInvoiceImportAuditINVOs[i].getInvEqOnhDt().replaceAll("-", ""));		// On-Hire Date
				tmpMgsInvoiceImportAuditINVO.setInvBilStDt(mGSInvoiceImportAuditINVOs[i].getInvBilStDt().replaceAll("-", ""));		// Billing Start Date
				tmpMgsInvoiceImportAuditINVO.setInvEqOffhLocNm(mGSInvoiceImportAuditINVOs[i].getInvEqOffhLocNm());	
				tmpMgsInvoiceImportAuditINVO.setInvEqOffhDt(mGSInvoiceImportAuditINVOs[i].getInvEqOffhDt().replaceAll("-", ""));	// Off-Hire Date
				tmpMgsInvoiceImportAuditINVO.setInvBilEndDt(mGSInvoiceImportAuditINVOs[i].getInvBilEndDt().replaceAll("-", ""));	// Billing End Date
				tmpMgsInvoiceImportAuditINVO.setInvLseUseDys(mGSInvoiceImportAuditINVOs[i].getInvLseUseDys().replaceAll(",", "").replaceAll(" ", ""));
				tmpMgsInvoiceImportAuditINVO.setInvLseRtAmt(mGSInvoiceImportAuditINVOs[i].getInvLseRtAmt().replaceAll(",", "").replaceAll(" ", ""));
				tmpMgsInvoiceImportAuditINVO.setInvLseChgAmt(mGSInvoiceImportAuditINVOs[i].getInvLseChgAmt().replaceAll(",", "").replaceAll(" ", ""));
				tmpMgsInvoiceImportAuditINVO.setInvTaxAmt(mGSInvoiceImportAuditINVOs[i].getInvTaxAmt());
				//PRE INIT
				tmpMgsInvoiceImportAuditINVO.setVrfyRsltDesc(sVerifyStatus);
				tmpMgsInvoiceImportAuditINVO.setAgmtOfcCtyCd(sAgmtOfcCtyCd);
				tmpMgsInvoiceImportAuditINVO.setAgmtSeq(sAgmtSeq);
				tmpMgsInvoiceImportAuditINVO.setAgmtVerNo(sAgmtVerNo);
				tmpMgsInvoiceImportAuditINVO.setAgmtLstmCd(sAgmtLstmCd);
				tmpMgsInvoiceImportAuditINVO.setVrfyScsFlg(sVerifySuccess);		
				
				tmpMgsInvoiceImportAuditINVO.setCreUsrId(account.getUsr_id());
				tmpMgsInvoiceImportAuditINVO.setUpdUsrId(account.getUsr_id());
				
				list1.add(tmpMgsInvoiceImportAuditINVO);
			}			
			if(list1.size()>0)
			{
				dbDao.addMGSLeaseInvoiceData(list1);
			}else{
				throw new DAOException();
			}
			
			//VERIFY step.3> searchMGSLeaseInvoiceVerifyData calling
			list2 = dbDao.searchMGSLeaseInvoiceVerifyData(mGSInvoiceImportAuditINVO); 
			return list2;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}
	
	/**
	 * Audit and Save invoice draft that loaded on Invoice import page.(M.G.Set)[EES_CGM_2085]<br>
	 * 
	 * @param mGSInvoiceImportAuditINVOs MGSInvoiceImportAuditINVO[]
	 * @param mGSInvoiceImportAuditINVO MGSInvoiceImportAuditINVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void auditMGSInvoiceDraftBasic(MGSInvoiceImportAuditINVO[] mGSInvoiceImportAuditINVOs, 
			MGSInvoiceImportAuditINVO mGSInvoiceImportAuditINVO, SignOnUserAccount account) throws EventException 
	{
		try {
			
			//--------------------------------------------
		 	//	data delete handling
			//--------------------------------------------
			MGSInvoiceImportAuditINVO mgsInvoiceImportAuditINVO3 = mGSInvoiceImportAuditINVO;
			mgsInvoiceImportAuditINVO3.setUpdUsrId(account.getUsr_id());
			mgsInvoiceImportAuditINVO3.setLseChgAudStsCd("H");
			mgsInvoiceImportAuditINVO3.setLseChgStsCd("H");
			mgsInvoiceImportAuditINVO3.setPayLseChgStsCd("H");
			
			dbDao.removeMGSInvImportDtlData(mgsInvoiceImportAuditINVO3);
			dbDao.modifyMGSInvImportDtlData(mgsInvoiceImportAuditINVO3);
			dbDao.modifyMGSInvImportHdrData(mgsInvoiceImportAuditINVO3);
		
			
			//--------------------------------------------
	 		//	data Audit handling start
		 	//--------------------------------------------
			
			List<MGSInvoiceImportAuditINVO> insertList = new ArrayList<MGSInvoiceImportAuditINVO>();
			List<MGSInvoiceImportAuditINVO> updateList = new ArrayList<MGSInvoiceImportAuditINVO>();
			insertList.clear();
			updateList.clear();
			for(int i=0; i < mGSInvoiceImportAuditINVOs.length; i++)
			{
				MGSInvoiceImportAuditINVO tempINVO = new MGSInvoiceImportAuditINVO();
				
				tempINVO.setAgmtOfcCtyCd(mGSInvoiceImportAuditINVOs[i].getAgmtOfcCtyCd());
				tempINVO.setAgmtSeq(mGSInvoiceImportAuditINVOs[i].getAgmtSeq());
				tempINVO.setAgmtVerNo(mGSInvoiceImportAuditINVOs[i].getAgmtVerNo());
				tempINVO.setCostYrmon(mGSInvoiceImportAuditINVO.getCostYrmon());
				tempINVO.setEqKndCd(mGSInvoiceImportAuditINVO.getEqKndCd());
				tempINVO.setEqNo(mGSInvoiceImportAuditINVOs[i].getInvEqNo());
				
				tempINVO.setChgCd(mGSInvoiceImportAuditINVOs[i].getChgCd());
				tempINVO.setLseChgAudStsCd(mGSInvoiceImportAuditINVOs[i].getLseChgAudStsCd());
				tempINVO.setPayLseChgStsCd(mGSInvoiceImportAuditINVOs[i].getLseChgAudStsCd());
				tempINVO.setLseChgAudRsltRsnCd(mGSInvoiceImportAuditINVOs[i].getLseChgAudRsltRsnCd());
				
				tempINVO.setInvNo(mGSInvoiceImportAuditINVOs[i].getInvNo());
				tempINVO.setInvSeq(mGSInvoiceImportAuditINVOs[i].getInvSeq());
				tempINVO.setInvRefNo(mGSInvoiceImportAuditINVOs[i].getInvRefNo());
				tempINVO.setInvEqNo(mGSInvoiceImportAuditINVOs[i].getInvEqNo());
				tempINVO.setInvCustEqNo(mGSInvoiceImportAuditINVOs[i].getInvCustEqNo());
				tempINVO.setInvEqOnhDt(mGSInvoiceImportAuditINVOs[i].getInvEqOnhDt().replaceAll("-", ""));
				tempINVO.setInvEqOnhLocNm(mGSInvoiceImportAuditINVOs[i].getInvEqOnhLocNm());
				tempINVO.setInvEqOffhDt(mGSInvoiceImportAuditINVOs[i].getInvEqOffhDt().replaceAll("-", ""));
				tempINVO.setInvEqOffhLocNm(mGSInvoiceImportAuditINVOs[i].getInvEqOffhLocNm());
				tempINVO.setInvBilStDt(mGSInvoiceImportAuditINVOs[i].getInvBilStDt().replaceAll("-", ""));
				tempINVO.setInvBilEndDt(mGSInvoiceImportAuditINVOs[i].getInvBilEndDt().replaceAll("-", ""));
				tempINVO.setInvLseUseDys(mGSInvoiceImportAuditINVOs[i].getInvLseUseDys().replaceAll(",", "").replaceAll(" ", ""));
	
				tempINVO.setInvLseRtAmt(mGSInvoiceImportAuditINVOs[i].getInvLseRtAmt().replaceAll(",", "").replaceAll(" ", ""));
				tempINVO.setInvLseChgAmt(mGSInvoiceImportAuditINVOs[i].getInvLseChgAmt().replaceAll(",", "").replaceAll(" ", ""));
				
				tempINVO.setCostCd(mGSInvoiceImportAuditINVOs[i].getCostCd());
				tempINVO.setAcctCd(mGSInvoiceImportAuditINVOs[i].getAcctCd());
				tempINVO.setCreUsrId(account.getUsr_id());
				tempINVO.setUpdUsrId(account.getUsr_id());
				
				tempINVO.setEqNo(mGSInvoiceImportAuditINVOs[i].getEqNo()); // actual EQ_NO
				if(tempINVO.getLseChgAudStsCd().equals("I")){
					insertList.add(tempINVO);
				} else {
					updateList.add(tempINVO);
				}
			}
			
			//--------------------------------------------
			// 	save Audit data to DB
			//--------------------------------------------
			
			// Detail Data save
			dbDao.addMGSAuditInvoiceDetailData(insertList);
			dbDao.modifyMGSAuditInvoiceDetailData(updateList);
			dbDao.modifyMGSChargeOnlyUmchStatusData(mGSInvoiceImportAuditINVO);
			
			// Header Data save
			List<MGSInvoiceImportAuditMGTVO> targetList = dbDao.searchMGSInvImportSumAmtData(mGSInvoiceImportAuditINVO);
			List<MGSInvoiceImportAuditINVO> headerList = new ArrayList<MGSInvoiceImportAuditINVO>();
			for(int x=0; x < targetList.size(); x++){
				
				MGSInvoiceImportAuditMGTVO targetData = (MGSInvoiceImportAuditMGTVO)targetList.get(x);
				
				MGSInvoiceImportAuditINVO headerData = new MGSInvoiceImportAuditINVO();
				
				headerData.setAgmtOfcCtyCd(targetData.getAgmtOfcCtyCd());
				headerData.setAgmtSeq(targetData.getAgmtSeq());
				headerData.setCostYrmon(targetData.getCostYrmon());
				headerData.setEqKndCd(targetData.getEqKndCd());
				
				headerData.setLseChgStsCd("A");	// AUDIT
				headerData.setCurrCd(mGSInvoiceImportAuditINVO.getCurrCd());
				headerData.setTaxSmryAmt(targetData.getTaxSmryAmt());
				headerData.setInvSmryAmt(targetData.getInvSmryAmt());
				headerData.setCrSmryAmt(targetData.getCrSmryAmt());
				headerData.setUpdUsrId(account.getUsr_id());
				
				headerList.add(headerData);
			}
			dbDao.modifyMGSAuditInvoiceHeaderData(headerList);

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}
	
	/**
	 * Retrieve  Agreement Audit result selected when Lease payable amount confirm page open. (Chassis)  [EES_CGM_1031]<br>
	 * 
	 * @param chsConfirmPayableAmountINVO CHSConfirmPayableAmountINVO 
	 * @return List<CHSConfirmPayableAmountMGTVO>
	 * @exception EventException
	 */
	public CHSConfirmPayableGRPVO searchCHSInvoiceAuditResultBasic(CHSConfirmPayableAmountINVO chsConfirmPayableAmountINVO) throws EventException{
		
		CHSConfirmPayableGRPVO resultVO = new CHSConfirmPayableGRPVO();
		
		try {
			
			List<List<CHSConfirmPayableAmountMGTVO>> list      = new ArrayList<List<CHSConfirmPayableAmountMGTVO>>();
			
			// Concidence list
			List<CHSConfirmPayableAmountMGTVO> concidenceList  = dbDao.searchCHSConcidenceStatusData(chsConfirmPayableAmountINVO);

			// Discrepancy list
			List<CHSConfirmPayableAmountMGTVO> discrepancyList = dbDao.searchCHSDiscrepancyStatusData(chsConfirmPayableAmountINVO);

			// Charge Only list
			List<CHSConfirmPayableAmountMGTVO> chargeOnlyList  = dbDao.searchCHSChargeOnlyStatusData(chsConfirmPayableAmountINVO);

			// Invoice Only list
			List<CHSConfirmPayableAmountMGTVO> invoiceOnlyList = dbDao.searchCHSInvoiceOnlyStatusData(chsConfirmPayableAmountINVO);

			list.add(concidenceList);
			list.add(discrepancyList);
			list.add(chargeOnlyList);
			list.add(invoiceOnlyList);

			resultVO.setcHSConfirmPayableAmountMGTVOs(list);
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
		
		return resultVO;
	}
	
	/**
	 * Save Invoice Audit result status by Eq. (Chassis)[EES_CGM_1031]<br>
	 * 
	 * @param chsConfirmPayableAmountINVOs List<CHSConfirmPayableAmountINVO[]> 
	 * @param chsConfirmPayableAmountINVO CHSConfirmPayableAmountINVO
	 * @param account SignOnUserAccount
	 * @return List<CHSConfirmPayableAmountMGTVO>
	 * @exception EventException
	 */
	public List<CHSConfirmPayableAmountMGTVO> manageCHSInvoiceAuditResultBasic(List<CHSConfirmPayableAmountINVO[]> chsConfirmPayableAmountINVOs, 
			CHSConfirmPayableAmountINVO chsConfirmPayableAmountINVO, SignOnUserAccount account) throws EventException{
		
		List<CHSConfirmPayableAmountMGTVO> rtnList = new ArrayList<CHSConfirmPayableAmountMGTVO>();
		
		try {
			CHSConfirmPayableAmountINVO[] concidenceINVO = (CHSConfirmPayableAmountINVO[])chsConfirmPayableAmountINVOs.get(0);
			CHSConfirmPayableAmountINVO[] discrepancyINVO = (CHSConfirmPayableAmountINVO[])chsConfirmPayableAmountINVOs.get(1);
			CHSConfirmPayableAmountINVO[] invoiceOnlyINVO = (CHSConfirmPayableAmountINVO[])chsConfirmPayableAmountINVOs.get(2);	
			
			/*------------------------------
			 	VO value setting
			 -------------------------------*/
			List<CHSConfirmPayableAmountINVO> concidenceList = new ArrayList<CHSConfirmPayableAmountINVO>();
			List<CHSConfirmPayableAmountINVO> discrepancyList = new ArrayList<CHSConfirmPayableAmountINVO>();
			List<CHSConfirmPayableAmountINVO> insInvoiceList = new ArrayList<CHSConfirmPayableAmountINVO>();
			List<CHSConfirmPayableAmountINVO> updInvoiceList = new ArrayList<CHSConfirmPayableAmountINVO>();
			List<CHSConfirmPayableAmountINVO> insUpdInvoiceList = new ArrayList<CHSConfirmPayableAmountINVO>(); // chungpa 20100104
			List<CHSConfirmPayableAmountINVO> delInvoiceList = new ArrayList<CHSConfirmPayableAmountINVO>(); 	// chungpa 20100104
			
			if(concidenceINVO != null){
				for(int i=0; i<concidenceINVO.length; i++){
					CHSConfirmPayableAmountINVO chsConfirmPayableAmountINVO2 = new CHSConfirmPayableAmountINVO();
					
					chsConfirmPayableAmountINVO2.setAgmtOfcCtyCd(concidenceINVO[i].getAgmtOfcCtyCd());
					chsConfirmPayableAmountINVO2.setAgmtSeq(concidenceINVO[i].getAgmtSeq());
					chsConfirmPayableAmountINVO2.setAgmtVerNo(concidenceINVO[i].getAgmtVerNo());
					chsConfirmPayableAmountINVO2.setCostYrmon(chsConfirmPayableAmountINVO.getCostYrmon());
					chsConfirmPayableAmountINVO2.setEqNo(concidenceINVO[i].getEqNo());
					chsConfirmPayableAmountINVO2.setChgCd(concidenceINVO[i].getChgCd());
					chsConfirmPayableAmountINVO2.setChgSeq(concidenceINVO[i].getChgSeq());
					chsConfirmPayableAmountINVO2.setEqKndCd(chsConfirmPayableAmountINVO.getEqKndCd());
					chsConfirmPayableAmountINVO2.setPayChgAudRmk(concidenceINVO[i].getPayChgAudRmk());
					
					concidenceList.add(chsConfirmPayableAmountINVO2);
					
				}
			}
			
			if(discrepancyINVO != null){
				for(int i=0; i<discrepancyINVO.length; i++){
					CHSConfirmPayableAmountINVO chsConfirmPayableAmountINVO3 = new CHSConfirmPayableAmountINVO();
					
					chsConfirmPayableAmountINVO3.setAgmtOfcCtyCd(discrepancyINVO[i].getAgmtOfcCtyCd());
					chsConfirmPayableAmountINVO3.setAgmtSeq(discrepancyINVO[i].getAgmtSeq());
					chsConfirmPayableAmountINVO3.setAgmtVerNo(discrepancyINVO[i].getAgmtVerNo());
					chsConfirmPayableAmountINVO3.setCostYrmon(chsConfirmPayableAmountINVO.getCostYrmon());
					chsConfirmPayableAmountINVO3.setEqNo(discrepancyINVO[i].getEqNo());
					chsConfirmPayableAmountINVO3.setChgCd(discrepancyINVO[i].getChgCd());
					chsConfirmPayableAmountINVO3.setChgSeq(discrepancyINVO[i].getChgSeq());
					chsConfirmPayableAmountINVO3.setEqKndCd(chsConfirmPayableAmountINVO.getEqKndCd());
					chsConfirmPayableAmountINVO3.setPayChgAudRmk(discrepancyINVO[i].getPayChgAudRmk());
					
					discrepancyList.add(chsConfirmPayableAmountINVO3);
				}
			}
			
			if(invoiceOnlyINVO != null){
				for(int k=0; k < invoiceOnlyINVO.length; k++){
					
					/*----------------------------
				 		COST_CD, ACCT_CD 
					 -----------------------------*/
					String costCd = "";
					String acctCd = "";
					
					String chgCd = invoiceOnlyINVO[k].getChgCd();
					String agmtLstmCd = invoiceOnlyINVO[k].getAgmtLstmCd();
					
					if(chgCd.equals("PDM")){
						if(agmtLstmCd.equals("ST")){
							costCd = "EQCZST";
							acctCd = "510832";
						} else if(agmtLstmCd.equals("LT")){
							costCd = "EQCZLT";
							acctCd = "510831";
						} else if(agmtLstmCd.equals("LP")){
							costCd = "EQCZLP";
							acctCd = "510833";
						} else {
							costCd = "EQCZST";
							acctCd = "510832";
						}
						
					} else if(chgCd.equals("WDP")){
						if(agmtLstmCd.equals("ST")){
							costCd = "EQCZST";
							acctCd = "510832";
						} else if(agmtLstmCd.equals("LT")){
							costCd = "EQCZLT";
							acctCd = "510831";
						} else if(agmtLstmCd.equals("LP")){
							costCd = "EQCZLP";
							acctCd = "510833";
						} else {
							costCd = "EQCZST";
							acctCd = "510832";
						}
					} else if(chgCd.equals("DOC")){
						if(agmtLstmCd.equals("ST")){
							costCd = "EQCZST";
							acctCd = "510834";
						} else if(agmtLstmCd.equals("LT")){
							costCd = "EQCZLT";
							acctCd = "510834";
						} else {
							costCd = "EQCZST";
							acctCd = "510834";
						}
					} else if(chgCd.equals("HON") || chgCd.equals("DON")){
						costCd = "EQCZLT";
						acctCd = "510835";
					} else if(chgCd.equals("HOF") || chgCd.equals("DOF")){	
						costCd = "EQCZLT";
						acctCd = "510835";
					} else if(chgCd.equals("GTO")){	
						costCd = "EQCZSB";
						acctCd = "510836";
					} else if (chgCd.equals("GTI")){
						costCd = "EQCZSB";
						acctCd = "510837";
					}else {	
						if(agmtLstmCd.equals("ST")){
							costCd = "EQXTXY";
							acctCd = "510838";
						} else if(agmtLstmCd.equals("LT")){
							costCd = "EQXTXX";
							acctCd = "510838";
						} else {
							costCd = "EQXTXY";
							acctCd = "510838";
						}
					}
				
					/*---------------------------
					 	Invoice Vo value setting
					 ---------------------------*/
					CHSConfirmPayableAmountINVO chsConfirmPayableAmountINVO4 = new CHSConfirmPayableAmountINVO();
					
					chsConfirmPayableAmountINVO4.setAgmtOfcCtyCd(invoiceOnlyINVO[k].getAgmtOfcCtyCd());
					chsConfirmPayableAmountINVO4.setAgmtSeq(invoiceOnlyINVO[k].getAgmtSeq());
					chsConfirmPayableAmountINVO4.setAgmtVerNo(invoiceOnlyINVO[k].getAgmtVerNo());
					chsConfirmPayableAmountINVO4.setCostYrmon(chsConfirmPayableAmountINVO.getCostYrmon());
					chsConfirmPayableAmountINVO4.setChgCd(invoiceOnlyINVO[k].getChgCd());
					chsConfirmPayableAmountINVO4.setChgSeq(invoiceOnlyINVO[k].getChgSeq());
					chsConfirmPayableAmountINVO4.setEqKndCd(chsConfirmPayableAmountINVO.getEqKndCd());
					chsConfirmPayableAmountINVO4.setLseChgAudStsCd("I");
					chsConfirmPayableAmountINVO4.setInvNo(invoiceOnlyINVO[k].getInvNo());
					chsConfirmPayableAmountINVO4.setInvRefNo(invoiceOnlyINVO[k].getInvRefNo());
					chsConfirmPayableAmountINVO4.setInvEqNo(invoiceOnlyINVO[k].getEqNo());
					chsConfirmPayableAmountINVO4.setEqNo(invoiceOnlyINVO[k].getEqNo());
					chsConfirmPayableAmountINVO4.setInvCustEqNo(invoiceOnlyINVO[k].getInvCustEqNo());
					chsConfirmPayableAmountINVO4.setInvEqOnhLocNm(invoiceOnlyINVO[k].getInvEqOnhLocNm());
					chsConfirmPayableAmountINVO4.setInvEqOffhLocNm(invoiceOnlyINVO[k].getInvEqOffhLocNm());
					chsConfirmPayableAmountINVO4.setInvBilStDt(invoiceOnlyINVO[k].getInvBilStDt());
					chsConfirmPayableAmountINVO4.setInvBilEndDt(invoiceOnlyINVO[k].getInvBilEndDt());
					chsConfirmPayableAmountINVO4.setInvLseUseDys(invoiceOnlyINVO[k].getInvLseUseDys());
					chsConfirmPayableAmountINVO4.setInvLseRtAmt(invoiceOnlyINVO[k].getInvLseRtAmt());
					chsConfirmPayableAmountINVO4.setInvLseChgAmt(invoiceOnlyINVO[k].getInvLseChgAmt());
					chsConfirmPayableAmountINVO4.setInvTaxAmt(invoiceOnlyINVO[k].getInvTaxAmt());
					chsConfirmPayableAmountINVO4.setInvCrAmt(invoiceOnlyINVO[k].getInvCrAmt());
					chsConfirmPayableAmountINVO4.setCostCd(costCd);
					chsConfirmPayableAmountINVO4.setAcctCd(acctCd);
					chsConfirmPayableAmountINVO4.setPayLseChgStsCd("I");
					chsConfirmPayableAmountINVO4.setPayChgAudRmk(invoiceOnlyINVO[k].getPayChgAudRmk());
					chsConfirmPayableAmountINVO4.setCreUsrId(account.getUsr_id());
					chsConfirmPayableAmountINVO4.setUpdUsrId(account.getUsr_id());
					
					chsConfirmPayableAmountINVO4.setChgCreSeq(chsConfirmPayableAmountINVO.getChgCreSeq());	
										
					if(invoiceOnlyINVO[k].getIbflag().equals("I")){
						// start with LSE_CHG_AUD_STS_CD is NULL in case of new input
						chsConfirmPayableAmountINVO4.setLseChgAudStsCd(null);
						// end with LSE_CHG_AUD_STS_CD is NULL in case of new input
						
						insInvoiceList.add(chsConfirmPayableAmountINVO4);
					} else if(invoiceOnlyINVO[k].getIbflag().equals("U")){
						// start with LSE_CHG_AUD_STS_CD is NULL in case of new input
						
						if(invoiceOnlyINVO[k].getLseChgAudStsCd().equals(""))
						{
							chsConfirmPayableAmountINVO4.setLseChgAudStsCd(null);
							insUpdInvoiceList.add(chsConfirmPayableAmountINVO4);
						}else
						{
							updInvoiceList.add(chsConfirmPayableAmountINVO4);
						}
						// end with LSE_CHG_AUD_STS_CD is NULL in case of new input
					}
					// start with LSE_CHG_AUD_STS_CD is NULL in case of new input
					else if(invoiceOnlyINVO[k].getIbflag().equals("D")){
						if(invoiceOnlyINVO[k].getLseChgAudStsCd().equals(""))
						{
							delInvoiceList.add(chsConfirmPayableAmountINVO4);
						}
					}
					// end with LSE_CHG_AUD_STS_CD is NULL in case of new input
				}
			}
			
			/*------------------------------
				Data value handling
			------------------------------*/
			if(concidenceList != null){
				// Concidence status value change handling 
				dbDao.modifyCHSAuditInvoiceConcidenceData(concidenceList);
			}
			
			if(discrepancyList != null){
				// Discrepancy editing  
				dbDao.modifyCHSAuditInvoiceDiscrepancyData(discrepancyList);
			}
			
			if(delInvoiceList != null)
			{
				dbDao.removeCHSAuditInvoiceOnlyDetailData(delInvoiceList);
			}
			
			if(insInvoiceList != null || updInvoiceList != null || insUpdInvoiceList != null){
				// Invoice Only new input (status ibflag = 'I')
				dbDao.addCHSAuditInvoiceOnlyDetailData(insInvoiceList);
				
				// Invoice Only editing(status ibflag = 'U')
				dbDao.modifyCHSAuditInvoiceOnlyDetailData(updInvoiceList);
	
				// start with LSE_CHG_AUD_STS_CD is NULL in case of new input
				// Invoice Only editing (new add data) 
				dbDao.modifyCHSAuditInvoiceOnlyDetailData(insUpdInvoiceList);
				// end with LSE_CHG_AUD_STS_CD is NULL in case of new input
				
				// Header Data editing  (INV_SMRY_AMT, CR_SMRY_AMT, TAX_SMRY_AMT)
				dbDao.modifyCHSInvoiceAuditResultHeaderData(insInvoiceList);
			}
			
			if(invoiceOnlyINVO != null){
				rtnList = dbDao.searchCHSInvoiceOnlyStatusData(chsConfirmPayableAmountINVO);
			}
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
		
		return rtnList;
	}
	
	/**
	 * Confirm handling cost by payable amount of page. (Chassis)[EES_CGM_1031]<br>
	 * 
	 * @param chsConfirmPayableAmountINVOS CHSConfirmPayableAmountINVO[]
	 * @param chsConfirmPayableAmountINVO CHSConfirmPayableAmountINVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void confirmCHSPayableAmountBasic(CHSConfirmPayableAmountINVO[] chsConfirmPayableAmountINVOS, 
			CHSConfirmPayableAmountINVO chsConfirmPayableAmountINVO, SignOnUserAccount account) throws EventException{
		
		try {
			
			// Checking Inv No matched to CGN_PAY_INV is existing or not 
			int invNoCnt = dbDao.checkCHSPayableInvoiceNoData(chsConfirmPayableAmountINVO);
			
			if(invNoCnt > 0){
				// error message in case of existing Invoice No  
				throw new EventException(new ErrorHandler("CGM20025",new String[]{}).getMessage());
			}
			
			List<CHSConfirmPayableAmountINVO> confirmPayableAmountList = new ArrayList<CHSConfirmPayableAmountINVO>();
			
			// setting parameter value from page
			if(chsConfirmPayableAmountINVOS != null){
				for(int i=0; i<chsConfirmPayableAmountINVOS.length; i++){
					
					CHSConfirmPayableAmountINVO chsConfirmPayableAmountINVO2 = new CHSConfirmPayableAmountINVO();
					
					chsConfirmPayableAmountINVO2.setCostYrmon(chsConfirmPayableAmountINVO.getCostYrmon());
					chsConfirmPayableAmountINVO2.setEqKndCd(chsConfirmPayableAmountINVO.getEqKndCd());
					chsConfirmPayableAmountINVO2.setAgmtOfcCtyCd(chsConfirmPayableAmountINVOS[i].getAgmtOfcCtyCd());
					chsConfirmPayableAmountINVO2.setAgmtSeq(chsConfirmPayableAmountINVOS[i].getAgmtSeq());
					chsConfirmPayableAmountINVO2.setAgmtVerNo(chsConfirmPayableAmountINVOS[i].getAgmtVerNo());
					chsConfirmPayableAmountINVO2.setEqNo(chsConfirmPayableAmountINVOS[i].getEqNo());
					chsConfirmPayableAmountINVO2.setChgCd(chsConfirmPayableAmountINVOS[i].getChgCd());
					chsConfirmPayableAmountINVO2.setChgCreSeq(chsConfirmPayableAmountINVO.getChgCreSeq());
					
					chsConfirmPayableAmountINVO2.setInvLseUseDys(chsConfirmPayableAmountINVOS[i].getInvLseUseDys());
					chsConfirmPayableAmountINVO2.setInvLseRtAmt(chsConfirmPayableAmountINVOS[i].getInvLseRtAmt());
					chsConfirmPayableAmountINVO2.setInvLseChgAmt(chsConfirmPayableAmountINVOS[i].getInvLseChgAmt());
					chsConfirmPayableAmountINVO2.setInvTaxAmt(chsConfirmPayableAmountINVOS[i].getInvTaxAmt());
					chsConfirmPayableAmountINVO2.setInvCrAmt(chsConfirmPayableAmountINVOS[i].getInvCrAmt());
					
					chsConfirmPayableAmountINVO2.setCreUsrId(account.getUsr_id());
					chsConfirmPayableAmountINVO2.setUpdUsrId(account.getUsr_id());
					
					//chg_seq add start
					chsConfirmPayableAmountINVO2.setChgSeq(chsConfirmPayableAmountINVOS[i].getChgSeq());
					//chg_seq add end 
					confirmPayableAmountList.add(chsConfirmPayableAmountINVO2);
				}
			}

			// Confirm Payable VO value setting
			chsConfirmPayableAmountINVO.setCostOfcCd(account.getOfc_cd());
			chsConfirmPayableAmountINVO.setIssOfcCd(account.getOfc_cd());
			chsConfirmPayableAmountINVO.setCostOfcCd(account.getOfc_cd());
			chsConfirmPayableAmountINVO.setInvUsrId(account.getUsr_id());
			
			chsConfirmPayableAmountINVO.setCreUsrId(account.getUsr_id());
			chsConfirmPayableAmountINVO.setUpdUsrId(account.getUsr_id());
			
			// CGM_LSE_CHG_DTL editing (Payable) - item update (all status change to 'C')
			dbDao.modifyCHSPayableAmountDetailData(confirmPayableAmountList);
			
			/*------------------------------------------
			 	Insert handling after CGM_PAY_INV 
			 -------------------------------------------*/
			
			// CGM_PAY_INV deleting (Concidence Data)
			dbDao.removeCHSPayableAmountData(chsConfirmPayableAmountINVO);
			
			// Payable Amount Insert
			dbDao.addCHSPayableAmountData(chsConfirmPayableAmountINVO);
			
			// CGM_LSE_CHG_DTL editing(Payable) - PAY_INV_SEQ update
			dbDao.modifyCHSPayableInvoiceSeqData(chsConfirmPayableAmountINVO);
			
			// CGM_LSE_CHG_HDR editing 
			// 1. LSE_CHG_STS_CD status value edit to 'S')
			// 2. CR_SMRY_AMT, TAX_SMRY_AMT value editing
			dbDao.modifyCHSPayableAmountHeaderData(chsConfirmPayableAmountINVO);
						
		} catch (EventException ex){
			throw ex;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}
	
	/**
	 * Cancel handling Confirmed cost by payable amount of page. (Chassis)[EES_CGM_1031]<br>
	 * 
	 * @param chsConfirmPayableAmountINVO CHSConfirmPayableAmountINVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void cancelCHSPayableAmountBasic(CHSConfirmPayableAmountINVO chsConfirmPayableAmountINVO, SignOnUserAccount account) throws EventException{
		
		try {
			chsConfirmPayableAmountINVO.setUpdUsrId(account.getUsr_id());
			
			// delete data added on Invoice Only page
			dbDao.removeCHSPayableAddInvOnlyData(chsConfirmPayableAmountINVO);
			
			// edit data to Invoice Import & Audit status
			dbDao.modifyCHSPayableChgDtlCancelData(chsConfirmPayableAmountINVO);
			
			// edit INV_SMRY_AMT, TAX_SMRY_AMT, CR_SMRY_AMT and status value of Header information('A')
			dbDao.modifyCHSPayableChgHdrCancelData(chsConfirmPayableAmountINVO);
			
			// Invoice data deleting
			dbDao.removeCHSPayableInvCreationData(chsConfirmPayableAmountINVO);
		
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}
	
	/**
	 * Retrieve Agreement Audit result that selected at Lease payable amount confirm page open. (M.G.Set) [EES_CGM_2098]<br>
	 * 
	 * @param mgsConfirmPayableAmountINVO MGSConfirmPayableAmountINVO 
	 * @return CHSConfirmPayableGRPVO
	 * @exception EventException
	 */
	public CHSConfirmPayableGRPVO searchMGSInvoiceAuditResultBasic(MGSConfirmPayableAmountINVO mgsConfirmPayableAmountINVO) throws EventException{
		
		CHSConfirmPayableGRPVO resultVO = new CHSConfirmPayableGRPVO();
		
		
		List<List<MGSConfirmPayableAmountMGTVO>> list = new ArrayList<List<MGSConfirmPayableAmountMGTVO>>();
		
		try {
			
			// Concidence list
			List<MGSConfirmPayableAmountMGTVO> concidenceList = dbDao.searchMGSConcidenceStatusData(mgsConfirmPayableAmountINVO);
			
			// Discrepancy list
			List<MGSConfirmPayableAmountMGTVO> discrepancyList = dbDao.searchMGSDiscrepancyStatusData(mgsConfirmPayableAmountINVO);
			
			// Charge Only list
			List<MGSConfirmPayableAmountMGTVO> chargeOnlyList = dbDao.searchMGSChargeOnlyStatusData(mgsConfirmPayableAmountINVO);
			
			// Invoice Only list
			List<MGSConfirmPayableAmountMGTVO> invoiceOnlyList = dbDao.searchMGSInvoiceOnlyStatusData(mgsConfirmPayableAmountINVO);
			
			list.add(concidenceList);
			list.add(discrepancyList);
			list.add(chargeOnlyList);
			list.add(invoiceOnlyList);
			
			resultVO.setmGSConfirmPayableAmountMGTVOs(list);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
		
		return resultVO;
	}
	
	/**
	 * Save Invoice Audit result status by Eq. (M.G.Set)[EES_CGM_2098]<br>
	 * 
	 * @param mgsConfirmPayableAmountINVOs List<MGSConfirmPayableAmountINVO[]> 
	 * @param mgsConfirmPayableAmountINVO MGSConfirmPayableAmountINVO
	 * @param account SignOnUserAccount
	 * @return List<MGSConfirmPayableAmountMGTVO>
	 * @exception EventException
	 */
	public List<MGSConfirmPayableAmountMGTVO> manageMGSInvoiceAuditResultBasic(List<MGSConfirmPayableAmountINVO[]> mgsConfirmPayableAmountINVOs, 
			MGSConfirmPayableAmountINVO mgsConfirmPayableAmountINVO, SignOnUserAccount account) throws EventException{
		
		List<MGSConfirmPayableAmountMGTVO> rtnList = new ArrayList<MGSConfirmPayableAmountMGTVO>();
		
		try {
			MGSConfirmPayableAmountINVO[] concidenceINVO = (MGSConfirmPayableAmountINVO[])mgsConfirmPayableAmountINVOs.get(0);
			MGSConfirmPayableAmountINVO[] discrepancyINVO = (MGSConfirmPayableAmountINVO[])mgsConfirmPayableAmountINVOs.get(1);
			MGSConfirmPayableAmountINVO[] invoiceOnlyINVO = (MGSConfirmPayableAmountINVO[])mgsConfirmPayableAmountINVOs.get(2);	
			
			/*------------------------------
			 	VO value setting
			 -------------------------------*/
			List<MGSConfirmPayableAmountINVO> concidenceList = new ArrayList<MGSConfirmPayableAmountINVO>();
			List<MGSConfirmPayableAmountINVO> discrepancyList = new ArrayList<MGSConfirmPayableAmountINVO>();
			List<MGSConfirmPayableAmountINVO> insInvoiceList = new ArrayList<MGSConfirmPayableAmountINVO>();
			List<MGSConfirmPayableAmountINVO> updInvoiceList = new ArrayList<MGSConfirmPayableAmountINVO>();
			List<MGSConfirmPayableAmountINVO> insUpdInvoiceList = new ArrayList<MGSConfirmPayableAmountINVO>(); 
			List<MGSConfirmPayableAmountINVO> delInvoiceList = new ArrayList<MGSConfirmPayableAmountINVO>(); 	
			
			if(concidenceINVO != null){
				for(int i=0; i<concidenceINVO.length; i++){
					MGSConfirmPayableAmountINVO mgsConfirmPayableAmountINVO2 = new MGSConfirmPayableAmountINVO();
					
					mgsConfirmPayableAmountINVO2.setAgmtOfcCtyCd(concidenceINVO[i].getAgmtOfcCtyCd());
					mgsConfirmPayableAmountINVO2.setAgmtSeq(concidenceINVO[i].getAgmtSeq());
					mgsConfirmPayableAmountINVO2.setAgmtVerNo(concidenceINVO[i].getAgmtVerNo());
					mgsConfirmPayableAmountINVO2.setCostYrmon(mgsConfirmPayableAmountINVO.getCostYrmon());
					mgsConfirmPayableAmountINVO2.setEqNo(concidenceINVO[i].getEqNo());
					mgsConfirmPayableAmountINVO2.setChgCd(concidenceINVO[i].getChgCd());
					mgsConfirmPayableAmountINVO2.setChgSeq(concidenceINVO[i].getChgSeq());					
					mgsConfirmPayableAmountINVO2.setEqKndCd(mgsConfirmPayableAmountINVO.getEqKndCd());
					mgsConfirmPayableAmountINVO2.setPayChgAudRmk(concidenceINVO[i].getPayChgAudRmk());
					
					concidenceList.add(mgsConfirmPayableAmountINVO2);
				}
			}
			
			if(discrepancyINVO != null){
				for(int i=0; i<discrepancyINVO.length; i++){
					MGSConfirmPayableAmountINVO mgsConfirmPayableAmountINVO3 = new MGSConfirmPayableAmountINVO();
					
					mgsConfirmPayableAmountINVO3.setAgmtOfcCtyCd(discrepancyINVO[i].getAgmtOfcCtyCd());
					mgsConfirmPayableAmountINVO3.setAgmtSeq(discrepancyINVO[i].getAgmtSeq());
					mgsConfirmPayableAmountINVO3.setAgmtVerNo(discrepancyINVO[i].getAgmtVerNo());
					mgsConfirmPayableAmountINVO3.setCostYrmon(mgsConfirmPayableAmountINVO.getCostYrmon());
					mgsConfirmPayableAmountINVO3.setEqNo(discrepancyINVO[i].getEqNo());
					mgsConfirmPayableAmountINVO3.setChgCd(discrepancyINVO[i].getChgCd());
					mgsConfirmPayableAmountINVO3.setChgSeq(discrepancyINVO[i].getChgSeq());
					mgsConfirmPayableAmountINVO3.setEqKndCd(mgsConfirmPayableAmountINVO.getEqKndCd());
					mgsConfirmPayableAmountINVO3.setPayChgAudRmk(discrepancyINVO[i].getPayChgAudRmk());
					
					discrepancyList.add(mgsConfirmPayableAmountINVO3);
				}
			}
			
			if(invoiceOnlyINVO != null){
				for(int k=0; k < invoiceOnlyINVO.length; k++){
					
					/*----------------------------
				 		COST_CD, ACCT_CD 
					 -----------------------------*/
					String costCd = "";
					String acctCd = "";
					
					String chgCd = invoiceOnlyINVO[k].getChgCd();
					String agmtLstmCd = invoiceOnlyINVO[k].getAgmtLstmCd();
					
					if(chgCd.equals("PDM")){
						if(agmtLstmCd.equals("ST")){
							costCd = "EQCGST";
							acctCd = "510842";
						} else if(agmtLstmCd.equals("LT")){
							costCd = "EQCGLT";
							acctCd = "510841";
						} else if(agmtLstmCd.equals("LP")){
							costCd = "EQCGLP";
							acctCd = "510843";
						} else {
							costCd = "EQCGST";
							acctCd = "510842";
						}
						
					} else if(chgCd.equals("WDP")){
						if(agmtLstmCd.equals("ST")){
							costCd = "EQCGST";
							acctCd = "510842";
						} else if(agmtLstmCd.equals("LT")){
							costCd = "EQCGLT";
							acctCd = "510841";
						} else if(agmtLstmCd.equals("LP")){
							costCd = "EQCGLP";
							acctCd = "510843";
						} else {
							costCd = "EQCGST";
							acctCd = "510842";
						}
					} else if(chgCd.equals("DOC")){
						if(agmtLstmCd.equals("ST")){
							costCd = "EQCGST";
							acctCd = "510844";
						} else if(agmtLstmCd.equals("LT")){
							costCd = "EQCGLT";
							acctCd = "510834";
						} else {
							costCd = "EQCGST";
							acctCd = "510844";
						}
					} else if(chgCd.equals("HON") || chgCd.equals("DON")){
						costCd = "EQCGLT";
						acctCd = "510845";
					} else if(chgCd.equals("HOF") || chgCd.equals("DOF")){	
						costCd = "EQCGLT";
						acctCd = "510845";
					} else if(chgCd.equals("GTO")){	
						costCd = "EQCZSB";
						acctCd = "510846";
					} else if(chgCd.equals("GTI")){
						costCd = "EQCZSB";
						acctCd = "510847";
					} else {		
						if(agmtLstmCd.equals("ST")){
							costCd = "EQXTXY";
							acctCd = "510848";
						} else if(agmtLstmCd.equals("LT")){
							costCd = "EQXTXX";
							acctCd = "510838";
						} else {
							costCd = "EQXTXY";
							acctCd = "510848";
						}
					}
				
					/*---------------------------
					 	Invoice Vo value setting
					 ---------------------------*/
					MGSConfirmPayableAmountINVO mgsConfirmPayableAmountINVO4 = new MGSConfirmPayableAmountINVO();
					
					mgsConfirmPayableAmountINVO4.setAgmtOfcCtyCd(invoiceOnlyINVO[k].getAgmtOfcCtyCd());
					mgsConfirmPayableAmountINVO4.setAgmtSeq(invoiceOnlyINVO[k].getAgmtSeq());
					mgsConfirmPayableAmountINVO4.setAgmtVerNo(invoiceOnlyINVO[k].getAgmtVerNo());
					mgsConfirmPayableAmountINVO4.setCostYrmon(mgsConfirmPayableAmountINVO.getCostYrmon());
					mgsConfirmPayableAmountINVO4.setChgCd(invoiceOnlyINVO[k].getChgCd());
					mgsConfirmPayableAmountINVO4.setChgSeq(invoiceOnlyINVO[k].getChgSeq());
					mgsConfirmPayableAmountINVO4.setEqKndCd(mgsConfirmPayableAmountINVO.getEqKndCd());
					mgsConfirmPayableAmountINVO4.setLseChgAudStsCd("I");
					mgsConfirmPayableAmountINVO4.setInvNo(invoiceOnlyINVO[k].getInvNo());
					mgsConfirmPayableAmountINVO4.setInvRefNo(invoiceOnlyINVO[k].getInvRefNo());
					mgsConfirmPayableAmountINVO4.setInvEqNo(invoiceOnlyINVO[k].getInvEqNo());
					mgsConfirmPayableAmountINVO4.setEqNo(invoiceOnlyINVO[k].getEqNo());
					mgsConfirmPayableAmountINVO4.setInvCustEqNo(invoiceOnlyINVO[k].getInvCustEqNo());
					mgsConfirmPayableAmountINVO4.setInvEqOnhLocNm(invoiceOnlyINVO[k].getInvEqOnhLocNm());
					mgsConfirmPayableAmountINVO4.setInvEqOffhLocNm(invoiceOnlyINVO[k].getInvEqOffhLocNm());
					mgsConfirmPayableAmountINVO4.setInvBilStDt(invoiceOnlyINVO[k].getInvBilStDt());
					mgsConfirmPayableAmountINVO4.setInvBilEndDt(invoiceOnlyINVO[k].getInvBilEndDt());
					mgsConfirmPayableAmountINVO4.setInvLseUseDys(invoiceOnlyINVO[k].getInvLseUseDys());
					mgsConfirmPayableAmountINVO4.setInvLseRtAmt(invoiceOnlyINVO[k].getInvLseRtAmt());
					mgsConfirmPayableAmountINVO4.setInvLseChgAmt(invoiceOnlyINVO[k].getInvLseChgAmt());
					mgsConfirmPayableAmountINVO4.setInvTaxAmt(invoiceOnlyINVO[k].getInvTaxAmt());
					mgsConfirmPayableAmountINVO4.setInvCrAmt(invoiceOnlyINVO[k].getInvCrAmt());
					mgsConfirmPayableAmountINVO4.setCostCd(costCd);
					mgsConfirmPayableAmountINVO4.setAcctCd(acctCd);
					mgsConfirmPayableAmountINVO4.setPayLseChgStsCd("I");
					mgsConfirmPayableAmountINVO4.setPayChgAudRmk(invoiceOnlyINVO[k].getPayChgAudRmk());
					mgsConfirmPayableAmountINVO4.setCreUsrId(account.getUsr_id());
					mgsConfirmPayableAmountINVO4.setUpdUsrId(account.getUsr_id());
					
					mgsConfirmPayableAmountINVO4.setChgCreSeq(mgsConfirmPayableAmountINVO.getChgCreSeq());	// for header editing
										
					if(invoiceOnlyINVO[k].getIbflag().equals("I")){
						// start with LSE_CHG_AUD_STS_CD is NULL in case of new input
						mgsConfirmPayableAmountINVO4.setLseChgAudStsCd(null);
						// end with LSE_CHG_AUD_STS_CD is NULL in case of new input
						insInvoiceList.add(mgsConfirmPayableAmountINVO4);
					} else if(invoiceOnlyINVO[k].getIbflag().equals("U")){
						// start with LSE_CHG_AUD_STS_CD is NULL in case of new input
						
						if(invoiceOnlyINVO[k].getLseChgAudStsCd().equals(""))
						{
							mgsConfirmPayableAmountINVO4.setLseChgAudStsCd(null);
							insUpdInvoiceList.add(mgsConfirmPayableAmountINVO4);
						}else
						{
							updInvoiceList.add(mgsConfirmPayableAmountINVO4);
						}
						//end with LSE_CHG_AUD_STS_CD is NULL in case of new input
					}					
					// start with LSE_CHG_AUD_STS_CD is NULL in case of new input
					else if(invoiceOnlyINVO[k].getIbflag().equals("D")){
						if(invoiceOnlyINVO[k].getLseChgAudStsCd().equals(""))
						{
							delInvoiceList.add(mgsConfirmPayableAmountINVO4);
						}
					}
					// end with LSE_CHG_AUD_STS_CD is NULL in case of new input	
				}
			}
			
			/*------------------------------
				Data value handling
			------------------------------*/
			if(concidenceList != null){
				// Concidence status value editing
				dbDao.modifyMGSAuditInvoiceConcidenceData(concidenceList);
			}
			
			if(discrepancyList != null){
				// Discrepancy editing
				dbDao.modifyMGSAuditInvoiceDiscrepancyData(discrepancyList);
			}
			
			if(delInvoiceList != null)
			{
				dbDao.removeMGSAuditInvoiceOnlyDetailData(delInvoiceList);
			}
			
			if(insInvoiceList != null || updInvoiceList != null || insUpdInvoiceList != null){
				// Invoice Only new input (status ibflag = 'I')
				dbDao.addMGSAuditInvoiceOnlyDetailData(insInvoiceList);
				
				// Invoice Only editing(status ibflag = 'U')
				dbDao.modifyMGSAuditInvoiceOnlyDetailData(updInvoiceList);
	
				//  end with LSE_CHG_AUD_STS_CD is NULL in case of new input
				// Invoice Only editing (new add data) 
				dbDao.modifyMGSAuditInvoiceOnlyDetailData(insUpdInvoiceList);
				// end with LSE_CHG_AUD_STS_CD is NULL in case of new input
				
				// Header Data editing  (INV_SMRY_AMT, CR_SMRY_AMT, TAX_SMRY_AMT)
				dbDao.modifyMGSInvoiceAuditResultHeaderData(insInvoiceList);
			}
			
			/*--------------------------------------------------------
			     Return result list of Concidence and Invoice Only 
			 ---------------------------------------------------------*/

			if(invoiceOnlyINVO != null){
				rtnList = dbDao.searchMGSInvoiceOnlyStatusData(mgsConfirmPayableAmountINVO);
			}
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
		
		return rtnList;
	}
	
	/**
	 * Confirm handling cost by payable amount of page. (M.G.Set)[EES_CGM_2098]<br>
	 * 
	 * @param mgsConfirmPayableAmountINVOS MGSConfirmPayableAmountINVO[]
	 * @param mgsConfirmPayableAmountINVO MGSConfirmPayableAmountINVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void confirmMGSPayableAmountBasic(MGSConfirmPayableAmountINVO[] mgsConfirmPayableAmountINVOS, 
			MGSConfirmPayableAmountINVO mgsConfirmPayableAmountINVO, SignOnUserAccount account) throws EventException{
		
		try {
			
			// Checking Inv No matched to CGN_PAY_INV is existing Inv No.
			int invNoCnt = dbDao.checkMGSPayableInvoiceNoData(mgsConfirmPayableAmountINVO);
			
			if(invNoCnt > 0){
				// error message in case of existing Invoice No
				throw new EventException(new ErrorHandler("CGM20025",new String[]{}).getMessage());
			}
			
			List<MGSConfirmPayableAmountINVO> confirmPayableAmountList = new ArrayList<MGSConfirmPayableAmountINVO>();
			
			// setting parameter value from page
			if(mgsConfirmPayableAmountINVOS != null){
				for(int i=0; i<mgsConfirmPayableAmountINVOS.length; i++){
					
					MGSConfirmPayableAmountINVO mgsConfirmPayableAmountINVO2 = new MGSConfirmPayableAmountINVO();
					
					mgsConfirmPayableAmountINVO2.setCostYrmon(mgsConfirmPayableAmountINVO.getCostYrmon());
					mgsConfirmPayableAmountINVO2.setEqKndCd(mgsConfirmPayableAmountINVO.getEqKndCd());
					mgsConfirmPayableAmountINVO2.setAgmtOfcCtyCd(mgsConfirmPayableAmountINVOS[i].getAgmtOfcCtyCd());
					mgsConfirmPayableAmountINVO2.setAgmtSeq(mgsConfirmPayableAmountINVOS[i].getAgmtSeq());
					mgsConfirmPayableAmountINVO2.setAgmtVerNo(mgsConfirmPayableAmountINVOS[i].getAgmtVerNo());
					mgsConfirmPayableAmountINVO2.setEqNo(mgsConfirmPayableAmountINVOS[i].getEqNo());
					mgsConfirmPayableAmountINVO2.setChgCd(mgsConfirmPayableAmountINVOS[i].getChgCd());
					mgsConfirmPayableAmountINVO2.setChgCreSeq(mgsConfirmPayableAmountINVO.getChgCreSeq());
					
					mgsConfirmPayableAmountINVO2.setInvLseUseDys(mgsConfirmPayableAmountINVOS[i].getInvLseUseDys());
					mgsConfirmPayableAmountINVO2.setInvLseRtAmt(mgsConfirmPayableAmountINVOS[i].getInvLseRtAmt());
					mgsConfirmPayableAmountINVO2.setInvLseChgAmt(mgsConfirmPayableAmountINVOS[i].getInvLseChgAmt());
					mgsConfirmPayableAmountINVO2.setInvTaxAmt(mgsConfirmPayableAmountINVOS[i].getInvTaxAmt());
					mgsConfirmPayableAmountINVO2.setInvCrAmt(mgsConfirmPayableAmountINVOS[i].getInvCrAmt());
					
					mgsConfirmPayableAmountINVO2.setCreUsrId(account.getUsr_id());
					mgsConfirmPayableAmountINVO2.setUpdUsrId(account.getUsr_id());
					
					//chg_seq add start
					mgsConfirmPayableAmountINVO2.setChgSeq(mgsConfirmPayableAmountINVOS[i].getChgSeq());
					//chg_seq add end
					
					confirmPayableAmountList.add(mgsConfirmPayableAmountINVO2);
				}
			}

			// Confirm Payable VO value setting
			mgsConfirmPayableAmountINVO.setCostOfcCd(account.getOfc_cd());
			mgsConfirmPayableAmountINVO.setIssOfcCd(account.getOfc_cd());
			mgsConfirmPayableAmountINVO.setCostOfcCd(account.getOfc_cd());
			mgsConfirmPayableAmountINVO.setInvUsrId(account.getUsr_id());
			
			mgsConfirmPayableAmountINVO.setCreUsrId(account.getUsr_id());
			mgsConfirmPayableAmountINVO.setUpdUsrId(account.getUsr_id());
			
			
			// // CGM_LSE_CHG_DTL editing (Payable) - item update 
			// 1. (status value edit to 'C')
			// 2. PAY_LSE_USE_DYS
			dbDao.modifyMGSPayableAmountDetailData(confirmPayableAmountList);
			
			/*------------------------------------------
			 	Insert handling after CGM_PAY_INV 
			 -------------------------------------------*/
			
			// CGM_PAY_INV deleting (Concidence Data)
			dbDao.removeMGSPayableAmountData(mgsConfirmPayableAmountINVO);
			
			// Payable Amount Insert
			dbDao.addMGSPayableAmountData(mgsConfirmPayableAmountINVO);
			
			// CGM_LSE_CHG_DTL editing(Payable) - PAY_INV_SEQ update
			dbDao.modifyMGSPayableInvoiceSeqData(mgsConfirmPayableAmountINVO);
			
			// CGM_LSE_CHG_HDR editing 
			// 1. LSE_CHG_STS_CD status value edit to 'S')
			// 2. CR_SMRY_AMT, TAX_SMRY_AMT value editing
			dbDao.modifyMGSPayableAmountHeaderData(mgsConfirmPayableAmountINVO);
			
		} catch (EventException ex){
			throw ex;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}
	
	/**
	 * Cancel handling Confirmed cost by payable amount of page. (M.G.Set)[EES_CGM_2098]<br>
	 * 
	 * @param mgsConfirmPayableAmountINVO MGSConfirmPayableAmountINVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void cancelMGSPayableAmountBasic(MGSConfirmPayableAmountINVO mgsConfirmPayableAmountINVO, SignOnUserAccount account) throws EventException{
		try {
			
			mgsConfirmPayableAmountINVO.setUpdUsrId(account.getUsr_id());
			
			// delete data added on Invoice Only page
			dbDao.removeMGSPayableAddInvOnlyData(mgsConfirmPayableAmountINVO);
			
			// edit data to Invoice Import & Audit status
			dbDao.modifyMGSPayableChgDtlCancelData(mgsConfirmPayableAmountINVO);
			
			// edit INV_SMRY_AMT, TAX_SMRY_AMT, CR_SMRY_AMT and status value of Header information('A')
			dbDao.modifyMGSPayableChgHdrCancelData(mgsConfirmPayableAmountINVO);
			
			// Invoice data deleting
			dbDao.removeMGSPayableInvCreationData(mgsConfirmPayableAmountINVO);
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}
	
	/**
	 * Check handling about Invoice No.(Chassis)[EES_CGM_1124]<br>
	 * 
	 * @param invNo String
	 * @param chssMgstInvKndCd String
	 * @param costYrmon String
	 * @exception EventException
	 */
	public void checkCHSInvoiceNoBasic(String invNo, String chssMgstInvKndCd, String costYrmon) throws EventException {
		try {
		
			// Exception handling in case of Invoice No of CGM_PAY_INV is existing in LS or NP
			long invNoCnt = dbDao.checkCHSInvoiceNoData(invNo, chssMgstInvKndCd);
			if(invNoCnt > 0){
				throw new EventException(new ErrorHandler("CGM20025",new String[]{invNo}).getMessage());
			}
			
			// Exception handling in case of existing Invoice No on different CP in different Cost Month CP
			long invNoByCostMonthCnt = dbDao.checkCHSInvoiceNoByCostMonthData(invNo, chssMgstInvKndCd, costYrmon);
			if(invNoByCostMonthCnt > 0){
				throw new EventException(new ErrorHandler("CGM20025",new String[]{}).getMessage());
			}
		
		} catch (EventException ex){
			throw ex;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}
	
	/**
	 * Retrieve Neutral Pool Charge list.(Chassis)[EES_CGM_1124]<br>
	 * 
	 * @param chsNuPoolChargeINVO   CHSNuPoolChargeINVO
	 * @return List<CHSNuPoolChargeMGTVO>
	 * @exception EventException
	 */
	public List<CHSNuPoolChargeMGTVO> searchCHSNuPoolChargeListBasic(CHSNuPoolChargeINVO chsNuPoolChargeINVO) throws EventException {
		try {
			
			return dbDao.searchCHSNuPoolChargeListData(chsNuPoolChargeINVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}
	
	/**
	 *  Retrieve initial item of Neutral Pool Charge list.(Chassis)[EES_CGM_1124]<br>
	 * 
	 * @param chsNuPoolChargeINVO   CHSNuPoolChargeINVO
	 * @return List<CHSNuPoolChargeMGTVO>
	 * @exception EventException
	 */
	public List<CHSNuPoolChargeMGTVO> searchCHSNuPoolChargeInitBasic(CHSNuPoolChargeINVO chsNuPoolChargeINVO) throws EventException {
		try {
			
			return dbDao.searchCHSNuPoolChargeInitData(chsNuPoolChargeINVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}
	
	/**
	 * Retrieve details of Neutral Pool Charge list.(Chassis)[EES_CGM_1124]<br>
	 * 
	 * @param chsNuPoolChargeINVO   CHSNuPoolChargeINVO
	 * @return List<CHSNuPoolChargeMGTVO>
	 * @exception EventException
	 */
	public List<CHSNuPoolChargeMGTVO> searchCHSNuPoolChargeDtlBasic(CHSNuPoolChargeINVO chsNuPoolChargeINVO) throws EventException {
		try {
			
			List<CHSNuPoolChargeMGTVO> list = dbDao.searchCHSNuPoolChargeDtlData(chsNuPoolChargeINVO);
			CHSNuPoolChargeMGTVO data = dbDao.searchCHSNuPoolChargeMainData(chsNuPoolChargeINVO);
			
			if(list.size() > 0){
				
				if(data != null){
				
					// setting Main Data to chsCoPoolChargeMGTVO
					CHSNuPoolChargeMGTVO  chsNuPoolChargeMGTVO = (CHSNuPoolChargeMGTVO)list.get(0);
					
					// setting retrieve result of Detail to chsCoPoolChargeMGTVO
					chsNuPoolChargeMGTVO.setPayInvSeq(data.getPayInvSeq());
					chsNuPoolChargeMGTVO.setInvNo(data.getInvNo());
					chsNuPoolChargeMGTVO.setVndrSeq(data.getVndrSeq());
					chsNuPoolChargeMGTVO.setVndrLglEngNm(data.getVndrLglEngNm());
					chsNuPoolChargeMGTVO.setCostYrmon(data.getCostYrmon());
					chsNuPoolChargeMGTVO.setCostOfcCd(data.getCostOfcCd());
					chsNuPoolChargeMGTVO.setAgmtOfcCtyCd(data.getAgmtOfcCtyCd());
					chsNuPoolChargeMGTVO.setAgmtSeq(data.getAgmtSeq());
					chsNuPoolChargeMGTVO.setChssMgstInvKndCd(data.getChssMgstInvKndCd());
					chsNuPoolChargeMGTVO.setChssMgstInvStsCd(data.getChssMgstInvStsCd());
					chsNuPoolChargeMGTVO.setPoolMaxRtAmt(data.getPoolMaxRtAmt());
					chsNuPoolChargeMGTVO.setPoolMinRtAmt(data.getPoolMinRtAmt());
					chsNuPoolChargeMGTVO.setDiffRmk(data.getDiffRmk());
					chsNuPoolChargeMGTVO.setInvDt(data.getInvDt());
			
				}
			}
			
			return list;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}
	
	/**
	 * Retrieve main information of Neutral Pool Charge list.(Chassis)[EES_CGM_1124]<br>
	 * 
	 * @param chsNuPoolChargeINVO   CHSNuPoolChargeINVO
	 * @return CHSNuPoolChargeMGTVO
	 * @exception EventException
	 */
	public CHSNuPoolChargeMGTVO searchCHSNuPoolChargeMainBasic(CHSNuPoolChargeINVO chsNuPoolChargeINVO) throws EventException {
		try {
			return dbDao.searchCHSNuPoolChargeMainData(chsNuPoolChargeINVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}
	
	/**
	 * Managing saved Neutral Charge.(Chassis)[EES_CGM_1124]<br>
	 * 
	 * @param chsNuPoolChargeINVOS CHSNuPoolChargeINVO[]
	 * @param chsNuPoolChargeINVO CHSNuPoolChargeINVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void createCHSNuPoolChargeBasic (CHSNuPoolChargeINVO[] chsNuPoolChargeINVOS, CHSNuPoolChargeINVO chsNuPoolChargeINVO, SignOnUserAccount account) throws EventException {
		
		List<CHSNuPoolChargeINVO> insertVoList = new ArrayList<CHSNuPoolChargeINVO>();
		
		try {
			
			/*-------------------------------
			 	VO value setting
			 --------------------------------*/
			// 'H' in cace of Save, 'S' in case of Confirm
			if(chsNuPoolChargeINVO != null){
				if(chsNuPoolChargeINVO.getActionflag().equals("SAVE")){
					chsNuPoolChargeINVO.setChssMgstInvStsCd("H");
				} else if (chsNuPoolChargeINVO.getActionflag().equals("CONFIRM")){
					chsNuPoolChargeINVO.setChssMgstInvStsCd("S");
				}
			
				chsNuPoolChargeINVO.setChssMgstInvKndCd("NP");
				chsNuPoolChargeINVO.setInvUsrId(account.getUsr_id());
				chsNuPoolChargeINVO.setCreUsrId(account.getUsr_id());
				chsNuPoolChargeINVO.setUpdUsrId(account.getUsr_id());
				
				// insert CGM_PAY_INV
				long payInvSeq = dbDao.searchCHSNuPoolChargePayInvSeqData(chsNuPoolChargeINVO);
				
				
				chsNuPoolChargeINVO.setPayInvSeq(String.valueOf(payInvSeq));
				
				dbDao.addCHSNuPoolChargeMainData(chsNuPoolChargeINVO);
				
				// insert CGM_PAY_INV_POOL_DTL 
				for (int k=0; k < chsNuPoolChargeINVOS.length; k++){
					
					CHSNuPoolChargeINVO chsNuPoolChargeINVO2 = new CHSNuPoolChargeINVO();
					
					chsNuPoolChargeINVO2.setPayInvSeq(String.valueOf(payInvSeq));
					chsNuPoolChargeINVO2.setDtlPoolCostItmCd(chsNuPoolChargeINVOS[k].getDtlPoolCostItmCd());
					chsNuPoolChargeINVO2.setCostChssQty(chsNuPoolChargeINVOS[k].getCostChssQty());
					chsNuPoolChargeINVO2.setCostBilDys(chsNuPoolChargeINVOS[k].getCostBilDys());
					chsNuPoolChargeINVO2.setCostAmt(chsNuPoolChargeINVOS[k].getCostAmt());
					chsNuPoolChargeINVO2.setCreUsrId(account.getUsr_id());
					chsNuPoolChargeINVO2.setUpdUsrId(account.getUsr_id());
											
					insertVoList.add(chsNuPoolChargeINVO2);
				}
				
				dbDao.addCHSNuPoolChargeDtlData(insertVoList);
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}
	
	/**
	 * Editing saved Neutral Charge.(Chassis)[EES_CGM_1124]<br>
	 * 
	 * @param chsNuPoolChargeINVOS CHSNuPoolChargeINVO[]
	 * @param chsNuPoolChargeINVO CHSNuPoolChargeINVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyCHSNuPoolChargeBasic (CHSNuPoolChargeINVO[] chsNuPoolChargeINVOS, CHSNuPoolChargeINVO chsNuPoolChargeINVO, SignOnUserAccount account) throws EventException {
		
		List<CHSNuPoolChargeINVO> insertVoList = new ArrayList<CHSNuPoolChargeINVO>();
		
		try {
			
			// 'H' in cace of Save, 'S' in case of Confirm 		
			if(chsNuPoolChargeINVO != null){
				if(chsNuPoolChargeINVO.getActionflag().equals("SAVE")){
					chsNuPoolChargeINVO.setChssMgstInvStsCd("H");
				} else if (chsNuPoolChargeINVO.getActionflag().equals("CONFIRM")){
					chsNuPoolChargeINVO.setChssMgstInvStsCd("S");
				}
				
				chsNuPoolChargeINVO.setChssMgstInvKndCd("NP");
				chsNuPoolChargeINVO.setInvUsrId(account.getUsr_id());
				chsNuPoolChargeINVO.setUpdUsrId(account.getUsr_id());
				
				// edit CGM_PAY_INV
				dbDao.modifyCHSNuPoolChargeMainData(chsNuPoolChargeINVO);
				
				// delete CGM_PAY_INV_POOL_DTL
				dbDao.removeCHSNuPoolChargeDtlData(chsNuPoolChargeINVO);
				
				// insert CGM_PAY_INV_POOL_DTL 
				for (int k=0; k < chsNuPoolChargeINVOS.length; k++){
					
					CHSNuPoolChargeINVO chsNuPoolChargeINVO2 = new CHSNuPoolChargeINVO();
					
					chsNuPoolChargeINVO2.setPayInvSeq(chsNuPoolChargeINVO.getPayInvSeq());
					chsNuPoolChargeINVO2.setDtlPoolCostItmCd(chsNuPoolChargeINVOS[k].getDtlPoolCostItmCd());
					chsNuPoolChargeINVO2.setCostChssQty(chsNuPoolChargeINVOS[k].getCostChssQty());
					chsNuPoolChargeINVO2.setCostBilDys(chsNuPoolChargeINVOS[k].getCostBilDys());
					chsNuPoolChargeINVO2.setCostAmt(chsNuPoolChargeINVOS[k].getCostAmt());
					chsNuPoolChargeINVO2.setCreUsrId(account.getUsr_id());
					chsNuPoolChargeINVO2.setUpdUsrId(account.getUsr_id());
											
					insertVoList.add(chsNuPoolChargeINVO2);
				}
				
				dbDao.addCHSNuPoolChargeDtlData(insertVoList);
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}
	
	/**
	 * Deleting saved Neutral Pool Charge information.(Chassis)[EES_CGM_1124]<br>
	 * 
	 * @param chsNuPoolChargeINVO CHSNuPoolChargeINVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void removeCHSNuPoolChargeBasic (CHSNuPoolChargeINVO chsNuPoolChargeINVO, SignOnUserAccount account) throws EventException {
		
		try {
			dbDao.removeCHSNuPoolChargeDtlData(chsNuPoolChargeINVO);
			dbDao.removeCHSNuPoolChargeMainData(chsNuPoolChargeINVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}
	
	/**
	 * Retrieve Invoice List.(Chassis)[EES_CGM_1034]<br>
	 * 
	 * @param chsPayableInvoiceCreationINVO CHSPayableInvoiceCreationINVO
	 * @param SignOnUserAccount account
	 * @return List<CHSPayableInvoiceCreationMGTVO>
	 * @exception EventException
	 */
	public List<CHSPayableInvoiceCreationMGTVO> searchCHSInvoiceListBasic (CHSPayableInvoiceCreationINVO chsPayableInvoiceCreationINVO, SignOnUserAccount account) throws EventException{
		try {
			chsPayableInvoiceCreationINVO.setUserOfcCd(account.getOfc_cd());
			return dbDao.searchCHSInvoiceListData(chsPayableInvoiceCreationINVO);
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}
	
	/**
	 * Retrieve detail of selected Invoice.(Chassis)[EES_CGM_1034]<br>
	 * 
	 * @param chsPayableInvoiceCreationINVO CHSPayableInvoiceCreationINVO
	 * @return List<CHSPayableInvoiceCreationMGTVO>
	 * @exception EventException
	 */
	public List<CHSPayableInvoiceCreationMGTVO> searchCHSInvoiceDetailBasic (CHSPayableInvoiceCreationINVO chsPayableInvoiceCreationINVO) throws EventException{
		try {
			return dbDao.searchCHSInvoiceDetailData(chsPayableInvoiceCreationINVO);
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}
	
	/**
	 * Creation invoice from contents of page (Issue date, effective date, receive date, revenue VVD, etc)(Chassis)[EES_CGM_1034]<br>
	 * 
	 * @param chsPayableInvoiceCreationINVOS CHSPayableInvoiceCreationINVO[]
	 * @param chsPayableInvoiceCreationINVO CHSPayableInvoiceCreationINVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void createCHSInvoiceBasic(CHSPayableInvoiceCreationINVO[] chsPayableInvoiceCreationINVOS, 
			CHSPayableInvoiceCreationINVO chsPayableInvoiceCreationINVO, SignOnUserAccount account) throws EventException{
		
		try {
			List<CHSPayableInvoiceCreationINVO> list = new ArrayList<CHSPayableInvoiceCreationINVO>();
			List<CHSPayableInvoiceCreationINVO> lseList = new ArrayList<CHSPayableInvoiceCreationINVO>();
			
			for(int i=0; i< chsPayableInvoiceCreationINVOS.length; i++){
				CHSPayableInvoiceCreationINVO chsPayableInvoiceCreationINVO2 = new CHSPayableInvoiceCreationINVO();
				
				String revVvd = chsPayableInvoiceCreationINVOS[i].getRevVvd();
				String revVslCd = "";
				String revSkdVoyNo = "";
				String revSkdDirCd = "";
				String revDirCd = "";
				
				if(!revVvd.equals("") && revVvd != null){
					if(revVvd.length()==10){
						revVslCd = revVvd.substring(0, 4);
						revSkdVoyNo = revVvd.substring(4, 8);
						revSkdDirCd = revVvd.substring(8, 9);
						revDirCd = revVvd.substring(9, 10);
					}
				}
				
				chsPayableInvoiceCreationINVO2.setRevVslCd(revVslCd);
				chsPayableInvoiceCreationINVO2.setRevSkdVoyNo(revSkdVoyNo);
				chsPayableInvoiceCreationINVO2.setRevSkdDirCd(revSkdDirCd);
				chsPayableInvoiceCreationINVO2.setRevDirCd(revDirCd);
				
				chsPayableInvoiceCreationINVO2.setInvTaxCltTpCd(chsPayableInvoiceCreationINVOS[i].getInvTaxCltTpCd());
				chsPayableInvoiceCreationINVO2.setInvTaxRt(chsPayableInvoiceCreationINVOS[i].getInvTaxRt());
				chsPayableInvoiceCreationINVO2.setInvSmryAmt(chsPayableInvoiceCreationINVOS[i].getInvSmryAmt());
				chsPayableInvoiceCreationINVO2.setInvRgstNo(chsPayableInvoiceCreationINVOS[i].getInvRgstNo());
				chsPayableInvoiceCreationINVO2.setUpdUsrId(account.getUsr_id());
				
				chsPayableInvoiceCreationINVO2.setPayInvSeq(chsPayableInvoiceCreationINVOS[i].getPayInvSeq());
				
				// information setting for Header editing
				chsPayableInvoiceCreationINVO2.setCostYrmon(chsPayableInvoiceCreationINVO.getCostYrmon());
				chsPayableInvoiceCreationINVO2.setEqKndCd(chsPayableInvoiceCreationINVO.getEqKndCd());
				chsPayableInvoiceCreationINVO2.setChgCreSeq(chsPayableInvoiceCreationINVOS[i].getChgCreSeq());
				
				if(chsPayableInvoiceCreationINVOS[i].getChssMgstInvKndCd().equals("LS")){
					lseList.add(chsPayableInvoiceCreationINVO2);
				}
				
				list.add(chsPayableInvoiceCreationINVO2);
			}
			
			dbDao.modifyCHSInvoiceCreationData(list);
			
			// update header data(charge seq) status to 'C'(in case of LS)
			dbDao.modifyCHSInvoiceCreationHeaderData(lseList);
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
		
		
	}
	
	/**
	 * Cancel handling Confirmed Invoice to Charge Creation status. (Chassis)[EES_CGM_1034]<br>
	 * 
	 * @param chsPayableInvoiceCreationINVOS CHSPayableInvoiceCreationINVO[]
	 * @param chsPayableInvoiceCreationINVO CHSPayableInvoiceCreationINVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void cancelCHSInvoiceBasic(CHSPayableInvoiceCreationINVO[] chsPayableInvoiceCreationINVOS, 
			CHSPayableInvoiceCreationINVO chsPayableInvoiceCreationINVO, SignOnUserAccount account) throws EventException{
		
		try {
			
			List<CHSPayableInvoiceCreationINVO> lseList = new ArrayList<CHSPayableInvoiceCreationINVO>();
			List<CHSPayableInvoiceCreationINVO> poolList = new ArrayList<CHSPayableInvoiceCreationINVO>();
			List<CHSPayableInvoiceCreationINVO> list = new ArrayList<CHSPayableInvoiceCreationINVO>();
			
			for(int i=0; i<chsPayableInvoiceCreationINVOS.length; i++){
				
				CHSPayableInvoiceCreationINVO chsPayableInvoiceCreationINVO2 = new CHSPayableInvoiceCreationINVO();
				
				chsPayableInvoiceCreationINVO2.setPayInvSeq(chsPayableInvoiceCreationINVOS[i].getPayInvSeq());
				chsPayableInvoiceCreationINVO2.setUpdUsrId(account.getUsr_id());
				
				chsPayableInvoiceCreationINVO2.setAgmtOfcCtyCd(chsPayableInvoiceCreationINVOS[i].getAgmtOfcCtyCd());
				chsPayableInvoiceCreationINVO2.setAgmtSeq(chsPayableInvoiceCreationINVOS[i].getAgmtSeq());
				chsPayableInvoiceCreationINVO2.setCostYrmon(chsPayableInvoiceCreationINVO.getCostYrmon());
				chsPayableInvoiceCreationINVO2.setEqKndCd(chsPayableInvoiceCreationINVO.getEqKndCd());
				chsPayableInvoiceCreationINVO2.setChgCreSeq(chsPayableInvoiceCreationINVOS[i].getChgCreSeq());
				
				
				if(chsPayableInvoiceCreationINVOS[i].getChssMgstInvKndCd().equals("LS")){
					lseList.add(chsPayableInvoiceCreationINVO2);
				} else {
					poolList.add(chsPayableInvoiceCreationINVO2);
				}
				
				list.add(chsPayableInvoiceCreationINVO2);
			}
			
			// change CGM_LSE_CHG_DTL to Charge Creation in case of LSE
			///dbDao.modifyCHSInvoiceDeleteDtlData(lseList);
				
			// change CGM_LSE_CHG_HDR to  P.Amt Confirm in case of LSE
			dbDao.modifyCHSInvoiceDeleteHdrData(lseList);
			
			// delete CGM_PAY_INV in case of LSE
			//dbDao.removeCHSInvoiceDeleteData(lseList);
		
			// change CGM_PAY_INV status to 'SAVE' in case of POOL
			dbDao.modifyCHSInvoiceDeleteData(list);
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
		
	}
	
	/**
	 * Retrieve value that pushed to AP_INV_MAIN from Payable Invoice Creation. (Chassis)[EES_CGM_1034]<br>
	 * 
	 * @param chsPayableInvoiceCreationINVO CHSPayableInvoiceCreationINVO
	 * @param account SignOnUserAccount
	 * @return ApPayInvVO
	 * @exception EventException
	 */
	public ApPayInvVO searchCHSInvoiceCreateMainBasic(CHSPayableInvoiceCreationINVO chsPayableInvoiceCreationINVO, SignOnUserAccount account) throws EventException{
		
		ApPayInvVO apPayInvVO = new ApPayInvVO();
		
		try {
			
			// retrieve data matched to pay_inv_seq
			List<CHSPayableInvoiceCreationMGTVO> list = dbDao.searchCHSInvoiceCreateMainData(chsPayableInvoiceCreationINVO);
			
			if(list != null){

				// setting input value and value loaded from DB to ApPayInvVO
				CHSPayableInvoiceCreationMGTVO chsPayableInvoiceCreationMGTVO = (CHSPayableInvoiceCreationMGTVO)list.get(0);
			
				apPayInvVO.setInvSubSysCd("CHS");
				apPayInvVO.setInvOfcCd(account.getOfc_cd());
				
				apPayInvVO.setCostOfcCd(chsPayableInvoiceCreationMGTVO.getCostOfcCd());
				apPayInvVO.setVndrSeq(chsPayableInvoiceCreationMGTVO.getVndrSeq());
				apPayInvVO.setInvNo(chsPayableInvoiceCreationMGTVO.getInvNo());
				
				apPayInvVO.setInvIssDt(chsPayableInvoiceCreationINVO.getInvIssDt().replaceAll("-", ""));
				apPayInvVO.setInvRcvDt(chsPayableInvoiceCreationINVO.getInvRcvDt().replaceAll("-", ""));
				apPayInvVO.setInvEffDt(chsPayableInvoiceCreationINVO.getInvEffDt().replaceAll("-", ""));
				
				apPayInvVO.setInvCfmDt(chsPayableInvoiceCreationMGTVO.getInvCfmDt());
				apPayInvVO.setVndrTermNm(chsPayableInvoiceCreationINVO.getGenPayTermCd());
				apPayInvVO.setInvCurrCd(chsPayableInvoiceCreationMGTVO.getCurrCd());
				apPayInvVO.setInvNetAmt(chsPayableInvoiceCreationMGTVO.getChgSmryAmt());
//				apPayInvVO.setActDt(chsPayableInvoiceCreationMGTVO.getActDt());

				
				Double invTaxRt = Double.parseDouble(chsPayableInvoiceCreationINVO.getInvTaxRt());
				Double chgSmryAmt = Double.parseDouble(chsPayableInvoiceCreationINVO.getChgSmryAmt());
				
				if(chsPayableInvoiceCreationINVO.getInvTaxCltTpCd().equals("VAT")){
						
					apPayInvVO.setInvVatAmt(String.valueOf(invTaxRt * chgSmryAmt / 100));
					apPayInvVO.setWhldTaxAmt("0");
				
				} else if(chsPayableInvoiceCreationINVO.getInvTaxCltTpCd().equals("WHT")){
					
					apPayInvVO.setInvVatAmt("0");
					apPayInvVO.setWhldTaxAmt(chsPayableInvoiceCreationINVO.getInvTaxRt());
					
				} else {
					apPayInvVO.setInvVatAmt("0");
					apPayInvVO.setWhldTaxAmt("0");	
				}
				
				Double invTtlAmt = chgSmryAmt + Double.parseDouble(apPayInvVO.getInvVatAmt()) - Double.parseDouble(apPayInvVO.getWhldTaxAmt());
				
				apPayInvVO.setInvTtlAmt(String.valueOf(invTtlAmt));
				apPayInvVO.setEqTpCd("Z");
			}
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
		
		return apPayInvVO;
	}
	
	/**
	 * Retrieve value that pushed to AP_INV_DTL from Payable Invoice Creation. (Chassis)[EES_CGM_1034]<br>
	 * 
	 * @param chsPayableInvoiceCreationINVO CHSPayableInvoiceCreationINVO
	 * @param account SignOnUserAccount
	 * @return ApPayInvVO
	 * @exception EventException
	 */
	public ApPayInvDtlVO[] searchCHSInvoiceCreateDetailBasic(CHSPayableInvoiceCreationINVO chsPayableInvoiceCreationINVO, SignOnUserAccount account) throws EventException{
		
		ApPayInvDtlVO[] apPayInvDtlVOs = null;
		
		try {
			List<CHSPayableInvoiceCreationMGTVO> list = dbDao.searchCHSInvoiceCreateDetailData(chsPayableInvoiceCreationINVO);
			
			if(list != null){
				apPayInvDtlVOs = new ApPayInvDtlVO[list.size()];
				
				for(int i=0; i<list.size(); i++){
					ApPayInvDtlVO apPayInvDtlVO = new ApPayInvDtlVO();
					
					CHSPayableInvoiceCreationMGTVO chsPayableInvoiceCreationMGTVO = (CHSPayableInvoiceCreationMGTVO)list.get(i);
					
					apPayInvDtlVO.setLgsCostCd(chsPayableInvoiceCreationMGTVO.getCostCd());
					apPayInvDtlVO.setAcctCd(chsPayableInvoiceCreationMGTVO.getAcctCd());
					apPayInvDtlVO.setVslCd(chsPayableInvoiceCreationMGTVO.getRevVslCd());
					apPayInvDtlVO.setSkdVoyNo(chsPayableInvoiceCreationMGTVO.getRevSkdVoyNo());
					apPayInvDtlVO.setSkdDirCd(chsPayableInvoiceCreationMGTVO.getRevSkdDirCd());
					apPayInvDtlVO.setRevDirCd(chsPayableInvoiceCreationMGTVO.getRevDirCd());
					apPayInvDtlVO.setSlanCd("CNT");
					apPayInvDtlVO.setActVvdCd(chsPayableInvoiceCreationMGTVO.getRevVvd());
					apPayInvDtlVO.setInvAmt(chsPayableInvoiceCreationMGTVO.getInvAmt());
					apPayInvDtlVO.setIbflag("I");	// Insert
					apPayInvDtlVO.setActPlc(chsPayableInvoiceCreationMGTVO.getActPlc());
					apPayInvDtlVO.setActDt(chsPayableInvoiceCreationMGTVO.getActDt());

					
					apPayInvDtlVOs[i] = apPayInvDtlVO;	
				}
			}
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}	
		
		return apPayInvDtlVOs;
	}
	
	/**
	 * Retrieve Invoice List. (M.G.Set)[EES_CGM_2035]<br>
	 * 
	 * @param mgsPayableInvoiceCreationINVO MGSPayableInvoiceCreationINVO
	 * @param SignOnUserAccount account
	 * @return List<MGSPayableInvoiceCreationMGTVO>
	 * @exception EventException
	 */
	public List<MGSPayableInvoiceCreationMGTVO> searchMGSInvoiceListBasic (MGSPayableInvoiceCreationINVO mgsPayableInvoiceCreationINVO, SignOnUserAccount account) throws EventException{
		try {
			mgsPayableInvoiceCreationINVO.setUserOfcCd(account.getOfc_cd());
			return dbDao.searchMGSInvoiceListData(mgsPayableInvoiceCreationINVO);
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}
	
	/**
	 * Retrieve detail of selected Invoice. (M.G.Set)[EES_CGM_2035]<br>
	 * 
	 * @param mgsPayableInvoiceCreationINVO MGSPayableInvoiceCreationINVO
	 * @return List<MGSPayableInvoiceCreationMGTVO>
	 * @exception EventException
	 */
	public List<MGSPayableInvoiceCreationMGTVO> searchMGSInvoiceDetailBasic (MGSPayableInvoiceCreationINVO mgsPayableInvoiceCreationINVO) throws EventException{
		try {
			return dbDao.searchMGSInvoiceDetailData(mgsPayableInvoiceCreationINVO);
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}
	
	/**
	 * Creation invoice from contents of page (Issue date, effective date, receive date, revenue VVD, etc) (M.G.Set)[EES_CGM_2035]<br>
	 * 
	 * @param mgsPayableInvoiceCreationINVOS MGSPayableInvoiceCreationINVO[]
	 * @param mgsPayableInvoiceCreationINVO MGSPayableInvoiceCreationINVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void createMGSInvoiceBasic(MGSPayableInvoiceCreationINVO[] mgsPayableInvoiceCreationINVOS, 
			MGSPayableInvoiceCreationINVO mgsPayableInvoiceCreationINVO, SignOnUserAccount account) throws EventException{
		
		try {
			List<MGSPayableInvoiceCreationINVO> list = new ArrayList<MGSPayableInvoiceCreationINVO>();
			
			for(int i=0; i< mgsPayableInvoiceCreationINVOS.length; i++){
				MGSPayableInvoiceCreationINVO mgsPayableInvoiceCreationINVO2 = new MGSPayableInvoiceCreationINVO();
				
				String revVvd = mgsPayableInvoiceCreationINVOS[i].getRevVvd();
				String revVslCd = "";
				String revSkdVoyNo = "";
				String revSkdDirCd = "";
				String revDirCd = "";
				
				if(!revVvd.equals("") && revVvd != null){
					if(revVvd.length()==10){
						revVslCd = revVvd.substring(0, 4);
						revSkdVoyNo = revVvd.substring(4, 8);
						revSkdDirCd = revVvd.substring(8, 9);
						revDirCd = revVvd.substring(9, 10);
					}
				}
				
				mgsPayableInvoiceCreationINVO2.setRevVslCd(revVslCd);
				mgsPayableInvoiceCreationINVO2.setRevSkdVoyNo(revSkdVoyNo);
				mgsPayableInvoiceCreationINVO2.setRevSkdDirCd(revSkdDirCd);
				mgsPayableInvoiceCreationINVO2.setRevDirCd(revDirCd);
				
				mgsPayableInvoiceCreationINVO2.setInvTaxCltTpCd(mgsPayableInvoiceCreationINVOS[i].getInvTaxCltTpCd());
				mgsPayableInvoiceCreationINVO2.setInvTaxRt(mgsPayableInvoiceCreationINVOS[i].getInvTaxRt());
				mgsPayableInvoiceCreationINVO2.setInvSmryAmt(mgsPayableInvoiceCreationINVOS[i].getInvSmryAmt());
				mgsPayableInvoiceCreationINVO2.setInvRgstNo(mgsPayableInvoiceCreationINVOS[i].getInvRgstNo());
				mgsPayableInvoiceCreationINVO2.setUpdUsrId(account.getUsr_id());
				
				mgsPayableInvoiceCreationINVO2.setPayInvSeq(mgsPayableInvoiceCreationINVOS[i].getPayInvSeq());
				
				// for header editing
				mgsPayableInvoiceCreationINVO2.setCostYrmon(mgsPayableInvoiceCreationINVO.getCostYrmon());
				mgsPayableInvoiceCreationINVO2.setEqKndCd(mgsPayableInvoiceCreationINVO.getEqKndCd());
				mgsPayableInvoiceCreationINVO2.setChgCreSeq(mgsPayableInvoiceCreationINVOS[i].getChgCreSeq());
				
				list.add(mgsPayableInvoiceCreationINVO2);
			}
			
			dbDao.modifyMGSInvoiceCreationData(list);
			
			// update header data(vndr_seq) status to 'C' 
			dbDao.modifyMGSInvoiceCreationHeaderData(list);
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
		
		
	}
	
	/**
	 * Cancel handling Confirmed Invoice to Charge Creation status. (M.G.Set)[EES_CGM_2035]<br>
	 * 
	 * @param mgsPayableInvoiceCreationINVOS MGSPayableInvoiceCreationINVO[]
	 * @param mgsPayableInvoiceCreationINVO MGSPayableInvoiceCreationINVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void cancelMGSInvoiceBasic(MGSPayableInvoiceCreationINVO[] mgsPayableInvoiceCreationINVOS, 
			MGSPayableInvoiceCreationINVO mgsPayableInvoiceCreationINVO, SignOnUserAccount account) throws EventException{
		
		try {
			
			List<MGSPayableInvoiceCreationINVO> lseList = new ArrayList<MGSPayableInvoiceCreationINVO>();
			
			for(int i=0; i<mgsPayableInvoiceCreationINVOS.length; i++){
				
				MGSPayableInvoiceCreationINVO mgsPayableInvoiceCreationINVO2 = new MGSPayableInvoiceCreationINVO();
				
				mgsPayableInvoiceCreationINVO2.setPayInvSeq(mgsPayableInvoiceCreationINVOS[i].getPayInvSeq());
				mgsPayableInvoiceCreationINVO2.setUpdUsrId(account.getUsr_id());
				
				mgsPayableInvoiceCreationINVO2.setAgmtOfcCtyCd(mgsPayableInvoiceCreationINVOS[i].getAgmtOfcCtyCd());
				mgsPayableInvoiceCreationINVO2.setAgmtSeq(mgsPayableInvoiceCreationINVOS[i].getAgmtSeq());
				mgsPayableInvoiceCreationINVO2.setCostYrmon(mgsPayableInvoiceCreationINVO.getCostYrmon());
				mgsPayableInvoiceCreationINVO2.setEqKndCd(mgsPayableInvoiceCreationINVO.getEqKndCd());
				mgsPayableInvoiceCreationINVO2.setChgCreSeq(mgsPayableInvoiceCreationINVOS[i].getChgCreSeq());
				
				lseList.add(mgsPayableInvoiceCreationINVO2);
				
			}
			
			// change CGM_LSE_CHG_DTL to Charge Creation in case of LSE
			//dbDao.modifyMGSInvoiceDeleteDtlData(lseList);
				
			// hange CGM_LSE_CHG_HDR to  P.Amt Confirm in case of LSE
			dbDao.modifyMGSInvoiceDeleteHdrData(lseList);
			
			// edit CGM_PAY_INV status value in case of LSE LSE
			dbDao.modifyMGSInvoiceDeleteData(lseList);
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
		
	}
	
	/**
	 * Retrieve value that pushed to AP_INV_MAIN from Payable Invoice Creation. (M.G.Set)[EES_CGM_2035]<br>
	 * 
	 * @param mgsPayableInvoiceCreationINVO MGSPayableInvoiceCreationINVO
	 * @param account SignOnUserAccount
	 * @return ApPayInvVO
	 * @exception EventException
	 */
	public ApPayInvVO searchMGSInvoiceCreateMainBasic(MGSPayableInvoiceCreationINVO mgsPayableInvoiceCreationINVO, SignOnUserAccount account) throws EventException{
		
		ApPayInvVO apPayInvVO = new ApPayInvVO();
		
		try {
			
			// retrieve data matched to pay_inv_seq
			List<MGSPayableInvoiceCreationMGTVO> list = dbDao.searchMGSInvoiceCreateMainData(mgsPayableInvoiceCreationINVO);
			
			if(list != null){

				// setting input value and value loaded from DB to ApPayInvVO
				MGSPayableInvoiceCreationMGTVO mgsPayableInvoiceCreationMGTVO = (MGSPayableInvoiceCreationMGTVO)list.get(0);
			
				apPayInvVO.setInvSubSysCd("MGS");
				apPayInvVO.setInvOfcCd(account.getOfc_cd());
				
				apPayInvVO.setCostOfcCd(mgsPayableInvoiceCreationMGTVO.getCostOfcCd());
				apPayInvVO.setVndrSeq(mgsPayableInvoiceCreationMGTVO.getVndrSeq());
				apPayInvVO.setInvNo(mgsPayableInvoiceCreationMGTVO.getInvNo());
				
				apPayInvVO.setInvIssDt(mgsPayableInvoiceCreationINVO.getInvIssDt().replaceAll("-", ""));
				apPayInvVO.setInvRcvDt(mgsPayableInvoiceCreationINVO.getInvRcvDt().replaceAll("-", ""));
				apPayInvVO.setInvEffDt(mgsPayableInvoiceCreationINVO.getInvEffDt().replaceAll("-", ""));
				
				apPayInvVO.setInvCfmDt(mgsPayableInvoiceCreationMGTVO.getInvCfmDt());
				apPayInvVO.setVndrTermNm(mgsPayableInvoiceCreationINVO.getGenPayTermCd());
				apPayInvVO.setInvCurrCd(mgsPayableInvoiceCreationMGTVO.getCurrCd());
				apPayInvVO.setInvNetAmt(mgsPayableInvoiceCreationMGTVO.getChgSmryAmt());
				
//				apPayInvVO.setActDt(mgsPayableInvoiceCreationMGTVO.getActDt()); // 2014.10.20. 추가


				
				Double invTaxRt = Double.parseDouble(mgsPayableInvoiceCreationINVO.getInvTaxRt());
				Double chgSmryAmt = Double.parseDouble(mgsPayableInvoiceCreationINVO.getChgSmryAmt());
				
				if(mgsPayableInvoiceCreationINVO.getInvTaxCltTpCd().equals("VAT")){
						
					apPayInvVO.setInvVatAmt(String.valueOf(invTaxRt * chgSmryAmt / 100));
					apPayInvVO.setWhldTaxAmt("0");
				
				} else if(mgsPayableInvoiceCreationINVO.getInvTaxCltTpCd().equals("WHT")){
					
					apPayInvVO.setInvVatAmt("0");
					apPayInvVO.setWhldTaxAmt(mgsPayableInvoiceCreationINVO.getInvTaxRt());
					
				} else {
					apPayInvVO.setInvVatAmt("0");
					apPayInvVO.setWhldTaxAmt("0");	
				}
				
				Double invTtlAmt = chgSmryAmt + Double.parseDouble(apPayInvVO.getInvVatAmt()) -  Double.parseDouble(apPayInvVO.getWhldTaxAmt());
				
				apPayInvVO.setInvTtlAmt(String.valueOf(invTtlAmt));
				apPayInvVO.setEqTpCd("G");
			}
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
		
		return apPayInvVO;
	}
	
	/**
	 * Retrieve value that pushed to AP_INV_DTL from Payable Invoice Creation. (M.G.Set)[EES_CGM_2035]<br>
	 * 
	 * @param mgsPayableInvoiceCreationINVO MGSPayableInvoiceCreationINVO
	 * @param account SignOnUserAccount
	 * @return ApPayInvDtlVO[]
	 * @exception EventException
	 */
	public ApPayInvDtlVO[] searchMGSInvoiceCreateDetailBasic(MGSPayableInvoiceCreationINVO mgsPayableInvoiceCreationINVO, SignOnUserAccount account) throws EventException{
		
		ApPayInvDtlVO[] apPayInvDtlVOs = null;
		
		try {
			List<MGSPayableInvoiceCreationMGTVO> list = dbDao.searchMGSInvoiceCreateDetailData(mgsPayableInvoiceCreationINVO);
			
			if(list != null){
				apPayInvDtlVOs = new ApPayInvDtlVO[list.size()];
				
				for(int i=0; i<list.size(); i++){
					ApPayInvDtlVO apPayInvDtlVO = new ApPayInvDtlVO();
					
					MGSPayableInvoiceCreationMGTVO mgsPayableInvoiceCreationMGTVO = (MGSPayableInvoiceCreationMGTVO)list.get(i);
					
					apPayInvDtlVO.setLgsCostCd(mgsPayableInvoiceCreationMGTVO.getCostCd());
					apPayInvDtlVO.setAcctCd(mgsPayableInvoiceCreationMGTVO.getAcctCd());
					apPayInvDtlVO.setVslCd(mgsPayableInvoiceCreationMGTVO.getRevVslCd());
					apPayInvDtlVO.setSkdVoyNo(mgsPayableInvoiceCreationMGTVO.getRevSkdVoyNo());
					apPayInvDtlVO.setSkdDirCd(mgsPayableInvoiceCreationMGTVO.getRevSkdDirCd());
					apPayInvDtlVO.setRevDirCd(mgsPayableInvoiceCreationMGTVO.getRevDirCd());
					apPayInvDtlVO.setSlanCd("CNT");
					apPayInvDtlVO.setActVvdCd(mgsPayableInvoiceCreationMGTVO.getRevVvd());
					apPayInvDtlVO.setInvAmt(mgsPayableInvoiceCreationMGTVO.getInvAmt());
					apPayInvDtlVO.setIbflag("I");	// Insert
					apPayInvDtlVO.setActPlc(mgsPayableInvoiceCreationMGTVO.getActPlc()); // 2014.10.20
					apPayInvDtlVO.setActDt(mgsPayableInvoiceCreationMGTVO.getActDt()); // 2014.10.20


					
					apPayInvDtlVOs[i] = apPayInvDtlVO;	
				}
			}
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}	
		
		return apPayInvDtlVOs;
	}
	
	/**
	 * Retrieve chassis Estimated settlement by month. [EES_CGM_1107]<br>
	 * 
	 * @param cHSEstimateExpenseINVO CHSEstimateExpenseINVO
	 * @return List<CHSEstimateExpenseMGTVO>
	 * @exception EventException
	 */
	public List<CHSEstimateExpenseMGTVO> searchCHSEstimateExpenseBasic(CHSEstimateExpenseINVO cHSEstimateExpenseINVO) throws EventException
	{
		try {
			
			String div = cHSEstimateExpenseINVO.getDiv();
			if(div != null && !div.equals("")){
				div = "'" + div.replaceAll(",", "','") + "'";
				cHSEstimateExpenseINVO.setDiv(div);
			}
			
			return dbDao.searchCHSEstimateExpenseData(cHSEstimateExpenseINVO);
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}
	
	/**
	 * Calculate chassis Estimated settlement by month. [EES_CGM_1107]<br>
	 * 
	 * @param cHSEstimateExpenseINVO CHSEstimateExpenseINVO
	 * @return List<CHSEstimateExpenseMGTVO>
	 * @exception EventException
	 */
	public List<CHSEstimateExpenseMGTVO> searchCHSEstimateExpenseCalcBasic(CHSEstimateExpenseINVO cHSEstimateExpenseINVO) throws EventException
	{
		try {
			return dbDao.searchCHSEstimateExpenseCalcData(cHSEstimateExpenseINVO);
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}
	
	/**
	 * Retrieve chassis Estimated settlement summary by month. [EES_CGM_1107]<br>
	 * 
	 * @param cHSEstimateExpenseINVO CHSEstimateExpenseINVO
	 * @return List<CHSEstimateExpenseMGTVO>
	 * @exception EventException
	 */
	public List<CHSEstimateExpenseMGTVO> searchCHSEstimateExpenseSummaryBasic(CHSEstimateExpenseINVO cHSEstimateExpenseINVO) throws EventException
	{
		try {
			String div = cHSEstimateExpenseINVO.getDiv();
			if(div != null && !div.equals("")){
				div = "'" + div.replaceAll(",", "','") + "'";
				cHSEstimateExpenseINVO.setDiv(div);
			}			
			return dbDao.searchCHSEstimateExpenseSummaryData(cHSEstimateExpenseINVO);
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}
	
	/**
	 * Handling chassis Estimated settlement by month. [EES_CGM_1107]<br>
	 * 
	 * @param cHSEstimateExpenseINVO CHSEstimateExpenseINVO
	 * @param cHSEstimateExpenseINVOs CHSEstimateExpenseINVO[]
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageCHSEstimateExpenseCalcBasic(CHSEstimateExpenseINVO cHSEstimateExpenseINVO, CHSEstimateExpenseINVO[] cHSEstimateExpenseINVOs,SignOnUserAccount account) throws EventException
	{
		try
		{
			//All delete before insert
			dbDao.removeCHSEstimateExpenseCalcData(cHSEstimateExpenseINVO);
			
			//insert
			for(int i=0; i<cHSEstimateExpenseINVOs.length; i++){

				cHSEstimateExpenseINVOs[i].setUpdUsrId(account.getUsr_id());
				dbDao.addCHSEstimateExpenseCalcData(cHSEstimateExpenseINVOs[i]);
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}

	/**
	 * Retrieve M.G. Set Estimated settlement by month. [EES_CGM_2206]<br>
	 * 
	 * @param mGSEstimateExpenseINVO MGSEstimateExpenseINVO
	 * @return List<MGSEstimateExpenseMGTVO>
	 * @exception EventException
	 */
	public List<MGSEstimateExpenseMGTVO> searchMGSEstimateExpenseBasic(MGSEstimateExpenseINVO mGSEstimateExpenseINVO) throws EventException
	{
		try {
			return dbDao.searchMGSEstimateExpenseData(mGSEstimateExpenseINVO);
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}
	
	/**
	 * Calculate  M.G. Set Estimated settlement by month. [EES_CGM_2206]<br>
	 * 
	 * @param mgSEstimateExpenseINVO MGSEstimateExpenseINVO
	 * @return List<MGSEstimateExpenseMGTVO>
	 * @exception EventException
	 */
	public List<MGSEstimateExpenseMGTVO> searchMGSEstimateExpenseCalcBasic(MGSEstimateExpenseINVO mgSEstimateExpenseINVO) throws EventException
	{
		try {
			return dbDao.searchMGSEstimateExpenseCalcData(mgSEstimateExpenseINVO);
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}
	
	/**
	 * Retrieve M.G. Set Estimated settlement summary by month. [EES_CGM_2206]<br>
	 * 
	 * @param mgSEstimateExpenseINVO MGSEstimateExpenseINVO
	 * @return List<MGSEstimateExpenseMGTVO>
	 * @exception EventException
	 */
	public List<MGSEstimateExpenseMGTVO> searchMGSEstimateExpenseSummaryBasic(MGSEstimateExpenseINVO mgSEstimateExpenseINVO) throws EventException
	{
		try {
			return dbDao.searchMGSEstimateExpenseSummaryData(mgSEstimateExpenseINVO);
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}
	
	/**
	 * Handling M.G. Set Estimated settlement by month. [EES_CGM_2206]<br>
	 * 
	 * @param mGSEstimateExpenseINVO MGSEstimateExpenseINVO
	 * @param mGSEstimateExpenseINVOs MGSEstimateExpenseINVO[]
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageMGSEstimateExpenseCalcBasic(MGSEstimateExpenseINVO mGSEstimateExpenseINVO, MGSEstimateExpenseINVO[] mGSEstimateExpenseINVOs,SignOnUserAccount account) throws EventException
	{
		try
		{
			//All delete before insert
			dbDao.removeMGSEstimateExpenseCalcData(mGSEstimateExpenseINVO);
			
			//insert
			for(int i=0; i<mGSEstimateExpenseINVOs.length; i++){
				
				mGSEstimateExpenseINVOs[i].setUpdUsrId(account.getUsr_id());
				dbDao.addMGSEstimateExpenseCalcData(mGSEstimateExpenseINVOs[i]);
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}
	
	/**
	 *  Retrieve invoice summary of chassis.(Chassis)[EES_CGM_1035]<br>
	 * 
	 * @param cHSInvoiceInquiryINVO CHSInvoiceInquiryINVO
	 * @return List<CHSInvoiceInquiryMGTVO>
	 * @exception EventException
	 */
	public List<CHSInvoiceInquiryMGTVO> searchCHSInvoiceInqListBasic (CHSInvoiceInquiryINVO cHSInvoiceInquiryINVO) throws EventException
	{
		try {
			
			String chssMgstInvKndCd = cHSInvoiceInquiryINVO.getChssMgstInvKndCd();
			String invCsrNo = cHSInvoiceInquiryINVO.getInvCsrNo();

			if(chssMgstInvKndCd != null && !chssMgstInvKndCd.equals("")){
				chssMgstInvKndCd = "'" + chssMgstInvKndCd.replaceAll(",", "','") + "'";
				cHSInvoiceInquiryINVO.setChssMgstInvKndCd(chssMgstInvKndCd);
			}
			
			if(invCsrNo != null && !invCsrNo.equals("")){
				invCsrNo = "'" + invCsrNo.replaceAll(",", "','") + "'";
				cHSInvoiceInquiryINVO.setInvCsrNo(invCsrNo);
			}

			return dbDao.searchCHSInvoiceInqListData (cHSInvoiceInquiryINVO);
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}		
	}
	
	/**
	 * Retrieve invoice detail data of chassis.(Chassis)[EES_CGM_1035]<br>
	 * 
	 * @param cHSInvoiceInquiryINVO CHSInvoiceInquiryINVO
	 * @return List<CHSInvoiceInquiryMGTVO>
	 * @exception EventException
	 */
	public List<CHSInvoiceInquiryMGTVO> searchCHSInvoiceInqDtlBasic (CHSInvoiceInquiryINVO cHSInvoiceInquiryINVO) throws EventException
	{
		try {
			return dbDao.searchCHSInvoiceInqDtlData (cHSInvoiceInquiryINVO);
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}		
	}

	/**
	 * Retrieve invoice summary of M.G.Set.(M.G.Set)[EES_CGM_2036]<br>
	 * 
	 * @param mGSInvoiceInquiryINVO MGSInvoiceInquiryINVO
	 * @return List<MGSInvoiceInquiryMGTVO>
	 * @exception EventException
	 */
	public List<MGSInvoiceInquiryMGTVO> searchMGSInvoiceInqListBasic (MGSInvoiceInquiryINVO mGSInvoiceInquiryINVO) throws EventException
	{
		try {
			
			String chssMgstInvKndCd = mGSInvoiceInquiryINVO.getChssMgstInvKndCd();
			String invCsrNo = mGSInvoiceInquiryINVO.getInvCsrNo();

			if(chssMgstInvKndCd != null && !chssMgstInvKndCd.equals("")){
				chssMgstInvKndCd = "'" + chssMgstInvKndCd.replaceAll(",", "','") + "'";
				mGSInvoiceInquiryINVO.setChssMgstInvKndCd(chssMgstInvKndCd);
			}
			
			if(invCsrNo != null && !invCsrNo.equals("")){
				invCsrNo = "'" + invCsrNo.replaceAll(",", "','") + "'";
				mGSInvoiceInquiryINVO.setInvCsrNo(invCsrNo);
			}

			return dbDao.searchMGSInvoiceInqListData (mGSInvoiceInquiryINVO);
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}		
	}
	
	/**
	 * Retrieve invoice detail data of M.G.Set.(M.G.Set)[EES_CGM_2036]<br>
	 * 
	 * @param mGSInvoiceInquiryINVO MGSInvoiceInquiryINVO
	 * @return List<MGSInvoiceInquiryMGTVO>
	 * @exception EventException
	 */
	public List<MGSInvoiceInquiryMGTVO> searchMGSInvoiceInqDtlBasic (MGSInvoiceInquiryINVO mGSInvoiceInquiryINVO) throws EventException
	{
		try {
			return dbDao.searchMGSInvoiceInqDtlData (mGSInvoiceInquiryINVO);
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}			
	}
	
}