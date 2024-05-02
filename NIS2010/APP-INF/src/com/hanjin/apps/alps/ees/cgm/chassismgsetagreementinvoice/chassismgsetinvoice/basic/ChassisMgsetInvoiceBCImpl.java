/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChassisMgsetInvoiceBCImpl.java
*@FileTitle : Agreement Matching
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.30
*@LastModifier : Chang Young Kim
*@LastVersion : 1.7
* 2009.04.29 김창식 1.0 Creation
* --------------------------------------------------------
* History
* 2011.12.23 신혜정 [선처리] tax 구분이 W.H.T일 경우, total amount는 net amount 에서 tax를 마이너스 처리.
* 2014.07.31 Modified by Chang Young Kim
* 2015.03.30 [CHM-201534562] 미주샷시 임차료(사용료) 추정 비용 로직 검토 의뢰 (EES_CGM_1107)
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.integration.ChassisMgsetInvoiceDBDAO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSChargeCreationINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSChargeCreationMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSCoPoolChargeINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSCoPoolChargeMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSConfirmPayableAmountINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSConfirmPayableAmountMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSConfirmPayableGRPVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSCpsAuditResultUpdateINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSCpsAuditResultUpdateMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSCpsConfirmPayableGRPVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSCpsInvoiceAuditResultCmmtCrMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSCpsPayableInvoiceCreationINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSCpsPayableInvoiceCreationMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSEstimateExpenseINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSEstimateExpenseMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSInvoiceImportAuditINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSInvoiceImportAuditMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSInvoiceInquiryINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSInvoiceInquiryMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSLessorAgmtMatchingINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSLessorAgmtMatchingMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSNuPoolChargeINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSNuPoolChargeMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSPayableInvoiceCreationINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSPayableInvoiceCreationMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSPoolSCCReportINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSPoolSCCReportMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSSCNOReportINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSSCNOReportMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSScExceptionINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.MGSChargeCreationINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.MGSChargeCreationMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.MGSConfirmPayableAmountINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.MGSConfirmPayableAmountMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.MGSEstimateExpenseINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.MGSEstimateExpenseMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.MGSInvoiceImportAuditINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.MGSInvoiceImportAuditMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.MGSInvoiceInquiryINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.MGSInvoiceInquiryMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.MGSLessorAgmtMatchingINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.MGSLessorAgmtMatchingMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.MGSPayableInvoiceCreationINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.MGSPayableInvoiceCreationMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.PoolEstmExpenseINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.PoolEstmExpenseMGTVO;
import com.hanjin.framework.component.backend.core.BackEndJobManager;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.ApPayInvDtlVO;
import com.hanjin.syscommon.common.table.ApPayInvVO;

/**
 * NIS2010-ChassisMgsetAgreementInvoice Business Logic Basic Command implementation<br>
 * - NIS2010-ChassisMgsetAgreementInvoice에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author KIM CHANG SIK
 * @see ees_cgm_1028EventResponse,ChassisMgsetInvoiceBC 각 DAO 클래스 참조
 * @since J2EE 1.4 
 */

public class ChassisMgsetInvoiceBCImpl extends BasicCommandSupport implements ChassisMgsetInvoiceBC {

	// Database Access Object
	private transient ChassisMgsetInvoiceDBDAO dbDao = null;

	/**
	 * ChassisMgsetInvoiceBCImpl 객체 생성<br>
	 * ChassisMgsetInvoiceDBDAO를 생성한다.<br>
	 */
	public ChassisMgsetInvoiceBCImpl() {
		dbDao = new ChassisMgsetInvoiceDBDAO();
	}
	/**
	 *  Lessor 와 match 되는 agreement 정보를 조회한다.(Chassis)[EES_CGM_1028]<br>
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
	 * Lessor 와 match 되는 agreement 정보를 저장한다.(Chassis)[EES_CGM_1028]<br>
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
					// Insert 대상 List에 저장
					if(chsLessorAgmtMatchingINVO[i].getDelChk().equals("1")){
						insertVoList.add(chsLessorAgmtMatchingINVO[i]);
					}
				} else if ( chsLessorAgmtMatchingINVO[i].getIbflag().equals("U")){
					// Update 대상 List 에 저장 
					if(chsLessorAgmtMatchingINVO[i].getDelChk().equals("1")){
						updateVoList.add(chsLessorAgmtMatchingINVO[i]);
					}
				} else if ( chsLessorAgmtMatchingINVO[i].getIbflag().equals("D")){
					// Delete 대상 List 에 저장
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
				// 기존에 등록된 데이터일 경우 에러 메시지 처리
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
	 *  Agreement No 입력 후 Focus Out 시 기존에 등록된 Agreement No. 인지 체크한다.(Chassis)[EES_CGM_1028]<br>
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
	 *  Lessor 와 match 되는 agreement 정보를 조회한다.(M.G.Set)[EES_CGM_2086]<br>
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
	 * Lessor 와 match 되는 agreement 정보를 저장한다.(M.G.Set)[EES_CGM_2086]<br>
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
					// Insert 대상 List 에 저장
					if(mgsLessorAgmtMatchingINVO[i].getDelChk().equals("1")){
						insertVoList.add(mgsLessorAgmtMatchingINVO[i]);
					}
				} else if ( mgsLessorAgmtMatchingINVO[i].getIbflag().equals("U")){
					// Update 대상 List 에 저장
					if(mgsLessorAgmtMatchingINVO[i].getDelChk().equals("1")){
						updateVoList.add(mgsLessorAgmtMatchingINVO[i]);
					}
				} else if ( mgsLessorAgmtMatchingINVO[i].getIbflag().equals("D")){
					// Delete 대상 List 에 저장
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
				// 기존에 등록된 데이터일 경우 에러 메시지 처리
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
	 *  Agreement No 입력 후 Focus Out 시 기존에 등록된 Agreement No. 인지 체크한다.(M.G.Set)[EES_CGM_2086]<br>
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
	 * 저장된 Pool Charge 목록을 조회한다.(Chassis)[EES_CGM_1123]<br>
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
	 * Co-op Pool Charge 초기 항목을 조회한다.(Chassis)[EES_CGM_1123]<br>
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
	 * 저장된 Pool Charge 상세 내역을 조회한다.(Chassis)[EES_CGM_1123]<br>
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
				
					// Main Data 조회 결과를 chsCoPoolChargeMGTVO 에 설정
					CHSCoPoolChargeMGTVO  chsCoPoolChargeMGTVO = (CHSCoPoolChargeMGTVO)list.get(0);
					
					// Detail 조회 결과를 chsCoPoolChargeMGTVO 에 설정
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
	 * Co-Pool Charge Main 정보를 조회한다.[EES_CGM_1123]<br>
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
	 * 입력된 Co Pool Charge 를 관리한다.(Chassis)[EES_CGM_1123]<br>
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
			 	VO 값 설정
			 --------------------------------*/
			// Save 일 경우 'H', Confirm 일 경우 'S'
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
			}

			// CGM_PAY_INV 입력
			long payInvSeq = dbDao.searchCHSCoPoolChargePayInvSeqData(chsCoPoolChargeINVO);
			
			if(chsCoPoolChargeINVO != null){
				chsCoPoolChargeINVO.setPayInvSeq(String.valueOf(payInvSeq));
			}
			dbDao.addCHSCoPoolChargeMainData(chsCoPoolChargeINVO);
			
			// CGM_PAY_INV_POOL_DTL 입력
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
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}
	
	/**
	 * 입력된 Co Pool Charge 를 수정한다.(Chassis)[EES_CGM_1123]<br>
	 * 
	 * @param chsCoPoolChargeINVOS CHSCoPoolChargeINVO[]
	 * @param chsCoPoolChargeINVO CHSCoPoolChargeINVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyCHSCoPoolChargeBasic (CHSCoPoolChargeINVO[] chsCoPoolChargeINVOS, CHSCoPoolChargeINVO chsCoPoolChargeINVO, SignOnUserAccount account) throws EventException {
		
		List<CHSCoPoolChargeINVO> insertVoList = new ArrayList<CHSCoPoolChargeINVO>();
		
		try {
			
			// Save 일 경우 'H', Confirm 일 경우 'S'
			if(chsCoPoolChargeINVO != null){
				if(chsCoPoolChargeINVO.getActionflag().equals("SAVE")){
					chsCoPoolChargeINVO.setChssMgstInvStsCd("H");
				} else if (chsCoPoolChargeINVO.getActionflag().equals("CONFIRM")){
					chsCoPoolChargeINVO.setChssMgstInvStsCd("S");
				}
				
				chsCoPoolChargeINVO.setChssMgstInvKndCd("CP");
				chsCoPoolChargeINVO.setInvUsrId(account.getUsr_id());
				chsCoPoolChargeINVO.setUpdUsrId(account.getUsr_id());				
			}
						
			// CGM_PAY_INV 수정
			dbDao.modifyCHSCoPoolChargeMainData(chsCoPoolChargeINVO);
			
			// CGM_PAY_INV_POOL_DTL 삭제
			dbDao.removeCHSCoPoolChargeDtlData(chsCoPoolChargeINVO);
			
			// CGM_PAY_INV_POOL_DTL 입력
			for (int k=0; k < chsCoPoolChargeINVOS.length; k++){
				
				CHSCoPoolChargeINVO chsCoPoolChargeINVO2 = new CHSCoPoolChargeINVO();
				
				chsCoPoolChargeINVO2.setPayInvSeq(chsCoPoolChargeINVOS[k].getPayInvSeq());
				chsCoPoolChargeINVO2.setDtlPoolCostItmCd(chsCoPoolChargeINVOS[k].getDtlPoolCostItmCd());
				chsCoPoolChargeINVO2.setPoolBsrtAmt(chsCoPoolChargeINVOS[k].getPoolBsrtAmt());
				chsCoPoolChargeINVO2.setCostBilDys(chsCoPoolChargeINVOS[k].getCostBilDys());
				chsCoPoolChargeINVO2.setCostAmt(chsCoPoolChargeINVOS[k].getCostAmt());
				chsCoPoolChargeINVO2.setCreUsrId(account.getUsr_id());
				chsCoPoolChargeINVO2.setUpdUsrId(account.getUsr_id());
										
				insertVoList.add(chsCoPoolChargeINVO2);
			}
			
			dbDao.addCHSCoPoolChargeDtlData(insertVoList);
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}
	
	/**
	 * 기저장된 Pool Charge 정보를 삭제한다.(Chassis)[EES_CGM_1123]<br>
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
	 * 해당월의 Charge 생성 리스트를 조회한다.(Chassis)[EES_CGM_1029]<br>
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
	 * Charge Creation 한 결과값을 조회한다.(Chassis)[EES_CGM_1029]<br>
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
	 * 선택된 Agreement 에 대해, 해당 월의 Charge 를 생성한다.(Chassis)[EES_CGM_1029]<br>
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
			// charge sequence 가 존재할 경우만 삭제처리한다.
			if(!chsChargeCreationINVO.getChgCreSeq().equals("")){
				
				// CGM_LSE_CHG_DTL 삭제
				dbDao.removeCHSChargeDetailData(chsChargeCreationINVO);
				
				// CGM_LSE_CHG_HDR 삭제
				dbDao.removeCHSChargeSummaryData(chsChargeCreationINVO);
			}
		
			/*-------------------------------
			 	Charge Create Sequence
			--------------------------------*/
			long chgCreSeq = dbDao.searchCHSChargeCreateSeqData();
			chsChargeCreationINVO.setChgCreSeq(String.valueOf(chgCreSeq));
			
			/*------------------------------
			  	파라	메터 설정
			-------------------------------*/
			// List<CHSChargeCreationINVO> 값 설정
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
	 * 선택된 Charge 를 삭제한다.(Chassis)[EES_CGM_1029]<br>
	 * 
	 * @param chsChargeCreationINVOS CHSChargeCreationINVO[]
	 * @param chsChargeCreationINVO CHSChargeCreationINVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void removeCHSChargeBasic (CHSChargeCreationINVO[] chsChargeCreationINVOS, 
				CHSChargeCreationINVO chsChargeCreationINVO, SignOnUserAccount account) throws EventException {
		
		try {
			// CGM_LSE_CHG_DTL 삭제
			dbDao.removeCHSChargeDetailData(chsChargeCreationINVO);
			
			// CGM_LSE_CHG_HDR 삭제
			dbDao.removeCHSChargeSummaryData(chsChargeCreationINVO);
			
			// CGM_PAY_INV 삭제 (P.Amt Confirm 일 경우)
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
	 * 해당월의 Charge 생성 리스트를 조회한다.(M.G.Set)[EES_CGM_2032]<br>
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
	 * Charge Creation 한 결과값을 조회한다.(M.G.Set)[EES_CGM_2032]<br>
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
	 * 선택된 Agreement 에 대해, 해당 월의 Charge 를 생성한다.(M.G.Set)[EES_CGM_2032]<br>
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
			// charge sequence 가 존재할 경우만 삭제처리한다.
			if(!mgsChargeCreationINVO.getChgCreSeq().equals("")){
				
				// CGM_LSE_CHG_DTL 삭제
				dbDao.removeMGSChargeDetailData(mgsChargeCreationINVO);
				
				// CGM_LSE_CHG_HDR 삭제
				dbDao.removeMGSChargeSummaryData(mgsChargeCreationINVO);
			}
		
			/*-------------------------------
			 	Charge Create Sequence
			--------------------------------*/
			long chgCreSeq = dbDao.searchMGSChargeCreateSeqData();
			mgsChargeCreationINVO.setChgCreSeq(String.valueOf(chgCreSeq));
			
			/*------------------------------
			  	파라	메터 설정
			-------------------------------*/
			// List<CHSChargeCreationINVO> 값 설정
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
	 * 선택된 Charge 를 삭제한다.(M.G.Set)[EES_CGM_2032]<br>
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
			// CGM_LSE_CHG_DTL 삭제
			dbDao.removeMGSChargeDetailData(mgsChargeCreationINVO);
			
			// CGM_LSE_CHG_HDR 삭제
			dbDao.removeMGSChargeSummaryData(mgsChargeCreationINVO);
			
			// CGM_PAY_INV 삭제 (P.Amt Confirm 일 경우)
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
	 * 저장된 Pool Estimate Amount 를 조회한다. Retrieve .  [EES_CGM_1125]<br>
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
	 * CGM_CHSS_POOL_EXPN_ESTM 엔티티에 저장 . Save .  [EES_CGM_1125]<br>
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
	 * 입력된 년도, Pool TYPE 에 해당하는 Pool List 별, 월별 Estimate amount 를 조회하였다. Retrieve .  [EES_CGM_1126]<br>
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
	 * 화면에 LOAD 된 Invoice draft 데이터를 EQ 단위로 Verify 수행한다.(Chassis)[EES_CGM_1030]<br>
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
			//VERIFY 1단계> removeCHSLeaseInvoiceData 호출
			dbDao.removeCHSLeaseInvoiceData(cHSInvoiceImportAuditINVO);
			
			//VERIFY 2단계> addCHSLeaseInvoiceData 호출
			for(int i=0; i < cHSInvoiceImportAuditINVOs.length; i++){
				CHSInvoiceImportAuditINVO tmpChsInvoiceImportAuditINVO = new CHSInvoiceImportAuditINVO();
				
				String sVerifyStatus	= "";//"OK";
				String sAgmtOfcCtyCd	= "";
				String sAgmtSeq			= "";
				String sAgmtVerNo		= "";
				String sAgmtLstmCd		= "";
				String sVerifySuccess	= "N";//"Y";
				
				//공통
				tmpChsInvoiceImportAuditINVO.setEqKndCd(cHSInvoiceImportAuditINVO.getEqKndCd());
				tmpChsInvoiceImportAuditINVO.setCostYrmon(cHSInvoiceImportAuditINVO.getCostYrmon().replaceAll("-", ""));
				tmpChsInvoiceImportAuditINVO.setChgCreSeq(cHSInvoiceImportAuditINVO.getChgCreSeq());
				//EXCEL
				tmpChsInvoiceImportAuditINVO.setInvCustEqNo(cHSInvoiceImportAuditINVOs[i].getInvCustEqNo());
				tmpChsInvoiceImportAuditINVO.setInvEqNo(cHSInvoiceImportAuditINVOs[i].getInvEqNo());								// SML Chassis No.
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
			
			//VERIFY 3단계> searchCHSLeaseInvoiceVerifyData 호출
			list2 = dbDao.searchCHSLeaseInvoiceVerifyData(cHSInvoiceImportAuditINVO); 
			return list2;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}
	
	/**
	 * 화면에 LOAD 된 Invoice draft 데이터를 EQ 단위로 Verify Insert수행한다.(Chassis)[EES_CGM_1030]<br>
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
			//VERIFY 1단계> removeCHSLeaseInvoiceData 호출
			dbDao.removeCHSLeaseInvoiceData(cHSInvoiceImportAuditINVO);
			
			//VERIFY 2단계> addCHSLeaseInvoiceData 호출
			for(int i=0; i < cHSInvoiceImportAuditINVOs.length; i++){
				CHSInvoiceImportAuditINVO tmpChsInvoiceImportAuditINVO = new CHSInvoiceImportAuditINVO();
				
				String sVerifyStatus	= "";//"OK";
				String sAgmtOfcCtyCd	= "";
				String sAgmtSeq			= "";
				String sAgmtVerNo		= "";
				String sAgmtLstmCd		= "";
				String sVerifySuccess	= "N";//"Y";
				
				//공통
				tmpChsInvoiceImportAuditINVO.setEqKndCd(cHSInvoiceImportAuditINVO.getEqKndCd());
				tmpChsInvoiceImportAuditINVO.setCostYrmon(cHSInvoiceImportAuditINVO.getCostYrmon().replaceAll("-", ""));
				tmpChsInvoiceImportAuditINVO.setChgCreSeq(cHSInvoiceImportAuditINVO.getChgCreSeq());
				//EXCEL
				tmpChsInvoiceImportAuditINVO.setInvCustEqNo(cHSInvoiceImportAuditINVOs[i].getInvCustEqNo());
				tmpChsInvoiceImportAuditINVO.setInvEqNo(cHSInvoiceImportAuditINVOs[i].getInvEqNo());								// SML Chassis No.
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
	 * 화면에 LOAD 된 Invoice draft 데이터를 EQ 단위로 Verify Search수행한다.(Chassis)[EES_CGM_1030]<br>
	 * 
	 * @param cHSInvoiceImportAuditINVO CHSInvoiceImportAuditINVO
	 * @return List<CHSInvoiceImportAuditMGTVO>
	 * @exception EventException
	 */
	public List<CHSInvoiceImportAuditMGTVO> verifyCHSInvoiceDraftSearchBasic(CHSInvoiceImportAuditINVO cHSInvoiceImportAuditINVO) throws EventException
	{
		List<CHSInvoiceImportAuditMGTVO> list2 = null;
		try {
			//VERIFY 3단계> searchCHSLeaseInvoiceVerifyData 호출
			list2 = dbDao.searchCHSLeaseInvoiceVerifyData(cHSInvoiceImportAuditINVO); 
			return list2;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}		
	}

	/**
	 * 화면에 LOAD 된 Invoice draft 데이터를 EQ 단위로 Verify Insert수행한다.(M.G.Set)[EES_CGM_2085]<br>
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
			//VERIFY 1단계> removeMGSLeaseInvoiceData 호출
			dbDao.removeMGSLeaseInvoiceData(mGSInvoiceImportAuditINVO);
			
			//VERIFY 2단계> addMGSLeaseInvoiceData 호출
			for(int i=0; i < mGSInvoiceImportAuditINVOs.length; i++){
				MGSInvoiceImportAuditINVO tmpMgsInvoiceImportAuditINVO = new MGSInvoiceImportAuditINVO();
				
				String sVerifyStatus	= "";//"OK";
				String sAgmtOfcCtyCd	= "";
				String sAgmtSeq			= "";
				String sAgmtVerNo		= "";
				String sAgmtLstmCd		= "";
				String sVerifySuccess	= "N";//"Y";
				
				//공통
				tmpMgsInvoiceImportAuditINVO.setEqKndCd(mGSInvoiceImportAuditINVO.getEqKndCd());
				tmpMgsInvoiceImportAuditINVO.setCostYrmon(mGSInvoiceImportAuditINVO.getCostYrmon().replaceAll("-", ""));
				tmpMgsInvoiceImportAuditINVO.setChgCreSeq(mGSInvoiceImportAuditINVO.getChgCreSeq());
				//EXCEL
				tmpMgsInvoiceImportAuditINVO.setInvCustEqNo(mGSInvoiceImportAuditINVOs[i].getInvCustEqNo());
				tmpMgsInvoiceImportAuditINVO.setInvEqNo(mGSInvoiceImportAuditINVOs[i].getInvEqNo());								// SML Chassis No.
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
	 * 화면에 LOAD 된 Invoice draft 데이터를 EQ 단위로 Verify Search수행한다.(M.G.Set)[EES_CGM_2085]<br>
	 * 
	 * @param mGSInvoiceImportAuditINVO MGSInvoiceImportAuditINVO
	 * @return List<MGSInvoiceImportAuditMGTVO>
	 * @exception EventException
	 */
	public List<MGSInvoiceImportAuditMGTVO> verifyMGSInvoiceDraftSearchBasic(MGSInvoiceImportAuditINVO mGSInvoiceImportAuditINVO) throws EventException
	{
		List<MGSInvoiceImportAuditMGTVO> list2 = null;
		try {
			//VERIFY 3단계> searchMGSLeaseInvoiceVerifyData 호출
			list2 = dbDao.searchMGSLeaseInvoiceVerifyData(mGSInvoiceImportAuditINVO); 
			return list2;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}		
	}
	
	/**
	 * Invoice import 화면에서 로드된 invoice draft 를 Audit 하고 저장한다.(Chssis)[EES_CGM_1030]<br>
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
		 	//	데이터 삭제 처리
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
	 		//	데이터 Audit 처리 시작
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
				
				tempINVO.setEqNo(cHSInvoiceImportAuditINVOs[i].getEqNo()); // 실제 처리되는 EQ_NO
				if(tempINVO.getLseChgAudStsCd().equals("I")){
					insertList.add(tempINVO);
				} else {
					updateList.add(tempINVO);
				}
			}
			
			//--------------------------------------------
			// 	Audit 데이터를 DB에 저장
			//--------------------------------------------
			
			// Detail Data 저장
			dbDao.addCHSAuditInvoiceDetailData(insertList);
			dbDao.modifyCHSAuditInvoiceDetailData(updateList);
			dbDao.modifyCHSChargeOnlyUmchStatusData(cHSInvoiceImportAuditINVO);
			
			// Header Data 저장
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
				
				log.debug("=============== CostYrmonSeq : " + targetData.getCostYrmonSeq());
				log.debug("=============== AgmtVerNo    : " + targetData.getAgmtVerNo());
				
				headerData.setCostYrmonSeq(targetData.getCostYrmonSeq());
				headerData.setAgmtVerNo(targetData.getAgmtVerNo());
				
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
	 * 화면에 LOAD 된 Invoice draft 데이터를 EQ 단위로 Verify 수행한다.(M.G.Set)[EES_CGM_2085]<br>
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
			//VERIFY 1단계> removeMGSLeaseInvoiceData 호출
			dbDao.removeMGSLeaseInvoiceData(mGSInvoiceImportAuditINVO);
			
			//VERIFY 2단계> addMGSLeaseInvoiceData 호출
			for(int i=0; i < mGSInvoiceImportAuditINVOs.length; i++){
				MGSInvoiceImportAuditINVO tmpMgsInvoiceImportAuditINVO = new MGSInvoiceImportAuditINVO();
				
				String sVerifyStatus	= "";//"OK";
				String sAgmtOfcCtyCd	= "";
				String sAgmtSeq			= "";
				String sAgmtVerNo		= "";
				String sAgmtLstmCd		= "";
				String sVerifySuccess	= "N";//"Y";
				
				//공통
				tmpMgsInvoiceImportAuditINVO.setEqKndCd(mGSInvoiceImportAuditINVO.getEqKndCd());
				tmpMgsInvoiceImportAuditINVO.setCostYrmon(mGSInvoiceImportAuditINVO.getCostYrmon().replaceAll("-", ""));
				tmpMgsInvoiceImportAuditINVO.setChgCreSeq(mGSInvoiceImportAuditINVO.getChgCreSeq());
				//EXCEL
				tmpMgsInvoiceImportAuditINVO.setInvCustEqNo(mGSInvoiceImportAuditINVOs[i].getInvCustEqNo());
				tmpMgsInvoiceImportAuditINVO.setInvEqNo(mGSInvoiceImportAuditINVOs[i].getInvEqNo());								// SML Chassis No.
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
			
			//VERIFY 3단계> searchMGSLeaseInvoiceVerifyData 호출
			list2 = dbDao.searchMGSLeaseInvoiceVerifyData(mGSInvoiceImportAuditINVO); 
			return list2;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}
	
	/**
	 * Invoice import 화면에서 로드된 invoice draft 를 Audit 하고 저장한다.(M.G.Set)[EES_CGM_2085]<br>
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
		 	//	데이터 삭제 처리
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
	 		//	데이터 Audit 처리 시작
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
				
				tempINVO.setEqNo(mGSInvoiceImportAuditINVOs[i].getEqNo()); // 실제 처리되는 EQ_NO
				if(tempINVO.getLseChgAudStsCd().equals("I")){
					insertList.add(tempINVO);
				} else {
					updateList.add(tempINVO);
				}
			}
			
			//--------------------------------------------
			// 	Audit 데이터를 DB에 저장
			//--------------------------------------------
			
			// Detail Data 저장
			dbDao.addMGSAuditInvoiceDetailData(insertList);
			dbDao.modifyMGSAuditInvoiceDetailData(updateList);
			dbDao.modifyMGSChargeOnlyUmchStatusData(mGSInvoiceImportAuditINVO);
			
			// Header Data 저장
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
				
				headerData.setCostYrmonSeq(targetData.getCostYrmonSeq());
				headerData.setAgmtVerNo(targetData.getAgmtVerNo());
				
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
	 * Lease payable amount confirm 화면에서 화면 open 시 선택된 Agreement Audit result 를 조회한다. (Chassis)  [EES_CGM_1031]<br>
	 * 
	 * @param chsConfirmPayableAmountINVO CHSConfirmPayableAmountINVO 
	 * @return List<CHSConfirmPayableAmountMGTVO>
	 * @exception EventException
	 */
	public CHSConfirmPayableGRPVO searchCHSInvoiceAuditResultBasic(CHSConfirmPayableAmountINVO chsConfirmPayableAmountINVO) throws EventException{
		
		CHSConfirmPayableGRPVO resultVO = new CHSConfirmPayableGRPVO();
		
		try {
			
			List<List<CHSConfirmPayableAmountMGTVO>> list      = new ArrayList<List<CHSConfirmPayableAmountMGTVO>>();
			
			// Concidence 목록
			List<CHSConfirmPayableAmountMGTVO> concidenceList  = dbDao.searchCHSConcidenceStatusData(chsConfirmPayableAmountINVO);

			// Discrepancy 목록
			List<CHSConfirmPayableAmountMGTVO> discrepancyList = dbDao.searchCHSDiscrepancyStatusData(chsConfirmPayableAmountINVO);

			// Charge Only 목록
			List<CHSConfirmPayableAmountMGTVO> chargeOnlyList  = dbDao.searchCHSChargeOnlyStatusData(chsConfirmPayableAmountINVO);

			// Invoice Only 목록
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
	 * Eq 별 Invoice Audit result 상태를 저장한다. (Chassis)[EES_CGM_1031]<br>
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
			 	VO 값 설정
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
					chsConfirmPayableAmountINVO2.setCostYrmonSeq(chsConfirmPayableAmountINVO.getCostYrmonSeq());
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
					chsConfirmPayableAmountINVO3.setCostYrmonSeq(chsConfirmPayableAmountINVO.getCostYrmonSeq());					
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
				 		COST_CD, ACCT_CD 구하기 
					 -----------------------------*/
					String costCd = "";
					String acctCd = "";
					
					String chgCd = invoiceOnlyINVO[k].getChgCd();
					String agmtLstmCd = invoiceOnlyINVO[k].getAgmtLstmCd();
					
					if(chgCd.equals("PDM")){
						if(agmtLstmCd.equals("ST")){
							costCd = "EQCZST";
							acctCd = "510841";
						} else if(agmtLstmCd.equals("LT")){
							costCd = "EQCZLT";
							acctCd = "510831";
						} else if(agmtLstmCd.equals("LP")){
							costCd = "EQCZLP";
							acctCd = "510831";
						} else {
							costCd = "EQCZST";
							acctCd = "510841";
						}
						
					} else if(chgCd.equals("WDP")){
						if(agmtLstmCd.equals("ST")){
							costCd = "EQCZST";
							acctCd = "510841";
						} else if(agmtLstmCd.equals("LT")){
							costCd = "EQCZLT";
							acctCd = "510831";
						} else if(agmtLstmCd.equals("LP")){
							costCd = "EQCZLP";
							acctCd = "510831";
						} else {
							costCd = "EQCZST";
							acctCd = "510841";
						}
					} else if(chgCd.equals("DOC")){
						if(agmtLstmCd.equals("ST")){
							costCd = "EQCZST";
							acctCd = "510841";
						} else if(agmtLstmCd.equals("LT")){
							costCd = "EQCZLT";
							acctCd = "510831";
						} else {
							costCd = "EQCZST";
							acctCd = "510841";
						}
					} else if(chgCd.equals("HON") || chgCd.equals("DON")){
						costCd = "EQCZLT";
						acctCd = "510831";
					} else if(chgCd.equals("HOF") || chgCd.equals("DOF")){	
						costCd = "EQCZLT";
						acctCd = "510831";
					} else if(chgCd.equals("GTO") || chgCd.equals("GTI")){	
						if(agmtLstmCd.equals("FO")){
							costCd = "EQCZSB";
							acctCd = "510831";
						} else if(agmtLstmCd.equals("SB")){
							costCd = "EQCZSB";
							acctCd = "510831";
						} else if(agmtLstmCd.equals("SO")){
							costCd = "EQCZSB";
							acctCd = "510831";
						}
					} else {		
						if(agmtLstmCd.equals("ST")){
							costCd = "EQXTXY";
							acctCd = "510841";
						} else if(agmtLstmCd.equals("LT")){
							costCd = "EQXTXX";
							acctCd = "510831";
						} else {
							costCd = "EQXTXY";
							acctCd = "510841";
						}
					}
				
					/*---------------------------
					 	Invoice Vo 값 설정
					 ---------------------------*/
					CHSConfirmPayableAmountINVO chsConfirmPayableAmountINVO4 = new CHSConfirmPayableAmountINVO();
					
					chsConfirmPayableAmountINVO4.setAgmtOfcCtyCd(invoiceOnlyINVO[k].getAgmtOfcCtyCd());
					chsConfirmPayableAmountINVO4.setAgmtSeq(invoiceOnlyINVO[k].getAgmtSeq());
					chsConfirmPayableAmountINVO4.setAgmtVerNo(invoiceOnlyINVO[k].getAgmtVerNo());
					chsConfirmPayableAmountINVO4.setCostYrmon(chsConfirmPayableAmountINVO.getCostYrmon());
					chsConfirmPayableAmountINVO4.setCostYrmonSeq(chsConfirmPayableAmountINVO.getCostYrmonSeq());					
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
					
					chsConfirmPayableAmountINVO4.setChgCreSeq(chsConfirmPayableAmountINVO.getChgCreSeq());	// header 를 수정하기 위해 필요.
										
					if(invoiceOnlyINVO[k].getIbflag().equals("I")){
						// chungpa 20100104 신규 입력건은 LSE_CHG_AUD_STS_CD를 NULL로 start.
						chsConfirmPayableAmountINVO4.setLseChgAudStsCd(null);
						// chungpa 20100104 신규 입력건은 LSE_CHG_AUD_STS_CD를 NULL로 end.
						
						insInvoiceList.add(chsConfirmPayableAmountINVO4);
					} else if(invoiceOnlyINVO[k].getIbflag().equals("U")){
						// chungpa 20100104 신규 입력건은 LSE_CHG_AUD_STS_CD를 NULL로 start.
						// 기존 updInvoiceList.add(chsConfirmPayableAmountINVO4);
						
						if(invoiceOnlyINVO[k].getLseChgAudStsCd().equals(""))//값이 없을 경우 이것은 신규 add해서 lse_chg_aud_sts_cd가 null인경우이고 이것은 따로 처리한다.
						{
							chsConfirmPayableAmountINVO4.setLseChgAudStsCd(null);
							insUpdInvoiceList.add(chsConfirmPayableAmountINVO4);
						}else
						{
							updInvoiceList.add(chsConfirmPayableAmountINVO4);
						}
						// chungpa 20100104 신규 입력건은 LSE_CHG_AUD_STS_CD를 NULL로 end.
					}
					// chungpa 20100104 신규 입력건은 LSE_CHG_AUD_STS_CD를 NULL로 start.
					else if(invoiceOnlyINVO[k].getIbflag().equals("D")){
						if(invoiceOnlyINVO[k].getLseChgAudStsCd().equals(""))//값이 없을 경우 이것은 신규 add해서 lse_chg_aud_sts_cd가 null인경우이고 이것은 따로 처리한다.
						{
							delInvoiceList.add(chsConfirmPayableAmountINVO4);
						}
					}
					// chungpa 20100104 신규 입력건은 LSE_CHG_AUD_STS_CD를 NULL로 end.
				}
			}
			
			/*------------------------------
				Data 값 처리
			------------------------------*/
			if(concidenceList != null){
				// Concidence 상태값 변경처리
				dbDao.modifyCHSAuditInvoiceConcidenceData(concidenceList);
			}
			
			if(discrepancyList != null){
				// Discrepancy 수정 (비고) 
				dbDao.modifyCHSAuditInvoiceDiscrepancyData(discrepancyList);
			}
			
			if(delInvoiceList != null)
			{
				dbDao.removeCHSAuditInvoiceOnlyDetailData(delInvoiceList);
			}
			
			if(insInvoiceList != null || updInvoiceList != null || insUpdInvoiceList != null){
				// Invoice Only 신규입력 (상태 ibflag가  'I' 인 것만)
				dbDao.addCHSAuditInvoiceOnlyDetailData(insInvoiceList);
				
				// Invoice Only 수정 (비고)(상태 ibflag가  'U' 인 것만)
				dbDao.modifyCHSAuditInvoiceOnlyDetailData(updInvoiceList);
	
				// chungpa 20100104 신규 입력건은 LSE_CHG_AUD_STS_CD를 NULL로 start.
				// Invoice Only 수정 (신규 add 데이터) 
				dbDao.modifyCHSAuditInvoiceOnlyDetailData(insUpdInvoiceList);
				// chungpa 20100104 신규 입력건은 LSE_CHG_AUD_STS_CD를 NULL로 end.
				
				// Header Data 수정  (INV_SMRY_AMT, CR_SMRY_AMT, TAX_SMRY_AMT)
				dbDao.modifyCHSInvoiceAuditResultHeaderData(insInvoiceList);
			}
			
			
			/*--------------------------------------------------------
			 	Concidence 와 Invoice Only 결과 List 를 조회하여 Return
			 ---------------------------------------------------------*/
			/*
			// Concidence 목록
			if(concidenceINVO != null){
				rtnList = dbDao.searchCHSConcidenceStatusData(chsConfirmPayableAmountINVO);
			} 
			
			// Discrepancy 목록
			if(discrepancyINVO != null){
				rtnList = dbDao.searchCHSDiscrepancyStatusData(chsConfirmPayableAmountINVO);
			}
			*/
			// Invoice Only 목록 (입력된 값이 존재할 경우 조회)
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
	 * 화면의 Payable Amount 대로 비용 확정(confirm) 처리한다. (Chassis)[EES_CGM_1031]<br>
	 * 
	 * @param chsConfirmPayableAmountINVOS CHSConfirmPayableAmountINVO[]
	 * @param chsConfirmPayableAmountINVO CHSConfirmPayableAmountINVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void confirmCHSPayableAmountBasic(CHSConfirmPayableAmountINVO[] chsConfirmPayableAmountINVOS, 
			CHSConfirmPayableAmountINVO chsConfirmPayableAmountINVO, SignOnUserAccount account) throws EventException{
		
		try {
			
			// CGN_PAY_INV 에 Concidency 에 해당하는 Inv No 가 존재가 하는지  체크한다.
			int invNoCnt = dbDao.checkCHSPayableInvoiceNoData(chsConfirmPayableAmountINVO);
			
			if(invNoCnt > 0){
				// Invoice No 가 존재하면 에러메시지 처리
				throw new EventException(new ErrorHandler("CGM20025",new String[]{}).getMessage());
			}
			
			List<CHSConfirmPayableAmountINVO> confirmPayableAmountList = new ArrayList<CHSConfirmPayableAmountINVO>();
			
			// 화면에서 넘어온 파라메터 값 설정
			if(chsConfirmPayableAmountINVOS != null){
				for(int i=0; i<chsConfirmPayableAmountINVOS.length; i++){
					
					CHSConfirmPayableAmountINVO chsConfirmPayableAmountINVO2 = new CHSConfirmPayableAmountINVO();
					
					chsConfirmPayableAmountINVO2.setCostYrmon(chsConfirmPayableAmountINVO.getCostYrmon());
					chsConfirmPayableAmountINVO2.setCostYrmonSeq(chsConfirmPayableAmountINVO.getCostYrmonSeq());
					chsConfirmPayableAmountINVO2.setParentCostYrmonSeq(chsConfirmPayableAmountINVO.getParentCostYrmonSeq());
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
					
					//chungpa 20100518 chg_seq 추가 start
					chsConfirmPayableAmountINVO2.setChgSeq(chsConfirmPayableAmountINVOS[i].getChgSeq());
					//chungpa 20100518 chg_seq 추가 end 
					confirmPayableAmountList.add(chsConfirmPayableAmountINVO2);
				}
			}

			// Confirm Payable VO 값 설정
			chsConfirmPayableAmountINVO.setCostOfcCd(account.getOfc_cd());
			chsConfirmPayableAmountINVO.setIssOfcCd(account.getOfc_cd());
			chsConfirmPayableAmountINVO.setCostOfcCd(account.getOfc_cd());
			chsConfirmPayableAmountINVO.setInvUsrId(account.getUsr_id());
			
			chsConfirmPayableAmountINVO.setCreUsrId(account.getUsr_id());
			chsConfirmPayableAmountINVO.setUpdUsrId(account.getUsr_id());
			
			// CGM_LSE_CHG_DTL 수정 (Payable 관련 항목) - 항목 업데이트 (상태를 전부 'C'로 수정)
			dbDao.modifyCHSPayableAmountDetailData(confirmPayableAmountList);
			
			/*------------------------------------------
			 	CGM_PAY_INV 삭제 후 Insert 처리
			 -------------------------------------------*/
			
			// CGM_PAY_INV 삭제 (Concidence 대상 Data)
			dbDao.removeCHSPayableAmountData(chsConfirmPayableAmountINVO);
			
			// Payable Amount Insert
			dbDao.addCHSPayableAmountData(chsConfirmPayableAmountINVO);
			
			// CGM_LSE_CHG_DTL 수정 (Payable 관련 항목) - PAY_INV_SEQ 를 업데이트
			dbDao.modifyCHSPayableInvoiceSeqData(chsConfirmPayableAmountINVO);
			
			// CGM_LSE_CHG_HDR 수정 
			// 1. LSE_CHG_STS_CD 상태값을 'S' 로 수정)
			// 2. CR_SMRY_AMT, TAX_SMRY_AMT 값 수정
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
	 * 화면의 Payable Amount 대로 비용 확정(confirm) 취소처리한다. (Chassis)[EES_CGM_1031]<br>
	 * 
	 * @param chsConfirmPayableAmountINVO CHSConfirmPayableAmountINVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void cancelCHSPayableAmountBasic(CHSConfirmPayableAmountINVO chsConfirmPayableAmountINVO, SignOnUserAccount account) throws EventException{
		
		try {
			chsConfirmPayableAmountINVO.setUpdUsrId(account.getUsr_id());
			
			// Invoice Only 화면에서 추가한 데이터 삭제
			dbDao.removeCHSPayableAddInvOnlyData(chsConfirmPayableAmountINVO);
			
			// Invoice Import & Audit 상태로 데이터를 수정 
			dbDao.modifyCHSPayableChgDtlCancelData(chsConfirmPayableAmountINVO);
			
			// Header 정보의 INV_SMRY_AMT, TAX_SMRY_AMT, CR_SMRY_AMT 및 상태값을 수정 ('A')
			dbDao.modifyCHSPayableChgHdrCancelData(chsConfirmPayableAmountINVO);
			
			// Invoice 데이터를 삭제한다.
			dbDao.removeCHSPayableInvCreationData(chsConfirmPayableAmountINVO);
		
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}
	
	/**
	 * Lease payable amount confirm 화면에서 화면 open 시 선택된 Agreement Audit result 를 조회한다. (M.G.Set) [EES_CGM_2098]<br>
	 * 
	 * @param mgsConfirmPayableAmountINVO MGSConfirmPayableAmountINVO 
	 * @return CHSConfirmPayableGRPVO
	 * @exception EventException
	 */
	public CHSConfirmPayableGRPVO searchMGSInvoiceAuditResultBasic(MGSConfirmPayableAmountINVO mgsConfirmPayableAmountINVO) throws EventException{
		
		CHSConfirmPayableGRPVO resultVO = new CHSConfirmPayableGRPVO();
		
		
		List<List<MGSConfirmPayableAmountMGTVO>> list = new ArrayList<List<MGSConfirmPayableAmountMGTVO>>();
		
		try {
			
			// Concidence 목록
			List<MGSConfirmPayableAmountMGTVO> concidenceList = dbDao.searchMGSConcidenceStatusData(mgsConfirmPayableAmountINVO);
			
			// Discrepancy 목록
			List<MGSConfirmPayableAmountMGTVO> discrepancyList = dbDao.searchMGSDiscrepancyStatusData(mgsConfirmPayableAmountINVO);
			
			// Charge Only 목록
			List<MGSConfirmPayableAmountMGTVO> chargeOnlyList = dbDao.searchMGSChargeOnlyStatusData(mgsConfirmPayableAmountINVO);
			
			// Invoice Only 목록
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
	 * Eq 별 Invoice Audit result 상태를 저장한다. (M.G.Set)[EES_CGM_2098]<br>
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
			 	VO 값 설정
			 -------------------------------*/
			List<MGSConfirmPayableAmountINVO> concidenceList = new ArrayList<MGSConfirmPayableAmountINVO>();
			List<MGSConfirmPayableAmountINVO> discrepancyList = new ArrayList<MGSConfirmPayableAmountINVO>();
			List<MGSConfirmPayableAmountINVO> insInvoiceList = new ArrayList<MGSConfirmPayableAmountINVO>();
			List<MGSConfirmPayableAmountINVO> updInvoiceList = new ArrayList<MGSConfirmPayableAmountINVO>();
			List<MGSConfirmPayableAmountINVO> insUpdInvoiceList = new ArrayList<MGSConfirmPayableAmountINVO>(); // chungpa 20100104
			List<MGSConfirmPayableAmountINVO> delInvoiceList = new ArrayList<MGSConfirmPayableAmountINVO>(); 	// chungpa 20100104
			
			if(concidenceINVO != null){
				for(int i=0; i<concidenceINVO.length; i++){
					MGSConfirmPayableAmountINVO mgsConfirmPayableAmountINVO2 = new MGSConfirmPayableAmountINVO();
					
					mgsConfirmPayableAmountINVO2.setAgmtOfcCtyCd(concidenceINVO[i].getAgmtOfcCtyCd());
					mgsConfirmPayableAmountINVO2.setAgmtSeq(concidenceINVO[i].getAgmtSeq());
					mgsConfirmPayableAmountINVO2.setAgmtVerNo(concidenceINVO[i].getAgmtVerNo());
					mgsConfirmPayableAmountINVO2.setCostYrmon(mgsConfirmPayableAmountINVO.getCostYrmon());
					mgsConfirmPayableAmountINVO2.setCostYrmonSeq(mgsConfirmPayableAmountINVO.getCostYrmonSeq());
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
					mgsConfirmPayableAmountINVO3.setCostYrmonSeq(mgsConfirmPayableAmountINVO.getCostYrmonSeq());
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
				 		COST_CD, ACCT_CD 구하기 
					 -----------------------------*/
					String costCd = "";
					String acctCd = "";
					
					String chgCd = invoiceOnlyINVO[k].getChgCd();
					String agmtLstmCd = invoiceOnlyINVO[k].getAgmtLstmCd();
					
					if(chgCd.equals("PDM")){
						if(agmtLstmCd.equals("ST")){
							costCd = "EQCZST";
							acctCd = "510841";
						} else if(agmtLstmCd.equals("LT")){
							costCd = "EQCZLT";
							acctCd = "510831";
						} else if(agmtLstmCd.equals("LP")){
							costCd = "EQCZLP";
							acctCd = "510831";
						} else {
							costCd = "EQCZST";
							acctCd = "510841";
						}
						
					} else if(chgCd.equals("WDP")){
						if(agmtLstmCd.equals("ST")){
							costCd = "EQCZST";
							acctCd = "510841";
						} else if(agmtLstmCd.equals("LT")){
							costCd = "EQCZLT";
							acctCd = "510831";
						} else if(agmtLstmCd.equals("LP")){
							costCd = "EQCZLP";
							acctCd = "510831";
						} else {
							costCd = "EQCZST";
							acctCd = "510841";
						}
					} else if(chgCd.equals("DOC")){
						if(agmtLstmCd.equals("ST")){
							costCd = "EQCZST";
							acctCd = "510841";
						} else if(agmtLstmCd.equals("LT")){
							costCd = "EQCZLT";
							acctCd = "510831";
						} else {
							costCd = "EQCZST";
							acctCd = "510841";
						}
					} else if(chgCd.equals("HON") || chgCd.equals("DON")){
						costCd = "EQCZLT";
						acctCd = "510831";
					} else if(chgCd.equals("HOF") || chgCd.equals("DOF")){	
						costCd = "EQCZLT";
						acctCd = "510831";
					} else if(chgCd.equals("GTO") || chgCd.equals("GTI")){	
						if(agmtLstmCd.equals("FO")){
							costCd = "EQCZSB";
							acctCd = "510831";
						} else if(agmtLstmCd.equals("SB")){
							costCd = "EQCZSB";
							acctCd = "510831";
						} else if(agmtLstmCd.equals("SO")){
							costCd = "EQCZSB";
							acctCd = "510831";
						}
					} else {		
						if(agmtLstmCd.equals("ST")){
							costCd = "EQXTXY";
							acctCd = "510841";
						} else if(agmtLstmCd.equals("LT")){
							costCd = "EQXTXX";
							acctCd = "510831";
						} else {
							costCd = "EQXTXY";
							acctCd = "510841";
						}
					}
				
					/*---------------------------
					 	Invoice Vo 값 설정
					 ---------------------------*/
					MGSConfirmPayableAmountINVO mgsConfirmPayableAmountINVO4 = new MGSConfirmPayableAmountINVO();
					
					mgsConfirmPayableAmountINVO4.setAgmtOfcCtyCd(invoiceOnlyINVO[k].getAgmtOfcCtyCd());
					mgsConfirmPayableAmountINVO4.setAgmtSeq(invoiceOnlyINVO[k].getAgmtSeq());
					mgsConfirmPayableAmountINVO4.setAgmtVerNo(invoiceOnlyINVO[k].getAgmtVerNo());
					mgsConfirmPayableAmountINVO4.setCostYrmon(mgsConfirmPayableAmountINVO.getCostYrmon());
					mgsConfirmPayableAmountINVO4.setCostYrmonSeq(mgsConfirmPayableAmountINVO.getCostYrmonSeq());
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
					
					mgsConfirmPayableAmountINVO4.setChgCreSeq(mgsConfirmPayableAmountINVO.getChgCreSeq());	// header 를 수정하기 위해 필요.
										
					if(invoiceOnlyINVO[k].getIbflag().equals("I")){
						// chungpa 20100104 신규 입력건은 LSE_CHG_AUD_STS_CD를 NULL로 start.
						mgsConfirmPayableAmountINVO4.setLseChgAudStsCd(null);
						// chungpa 20100104 신규 입력건은 LSE_CHG_AUD_STS_CD를 NULL로 end.
						insInvoiceList.add(mgsConfirmPayableAmountINVO4);
					} else if(invoiceOnlyINVO[k].getIbflag().equals("U")){
						// chungpa 20100104 신규 입력건은 LSE_CHG_AUD_STS_CD를 NULL로 start.
						// 기존 updInvoiceList.add(mgsConfirmPayableAmountINVO4);
						
						if(invoiceOnlyINVO[k].getLseChgAudStsCd().equals(""))//값이 없을 경우 이것은 신규 add해서 lse_chg_aud_sts_cd가 null인경우이고 이것은 따로 처리한다.
						{
							mgsConfirmPayableAmountINVO4.setLseChgAudStsCd(null);
							insUpdInvoiceList.add(mgsConfirmPayableAmountINVO4);
						}else
						{
							updInvoiceList.add(mgsConfirmPayableAmountINVO4);
						}
						// chungpa 20100104 신규 입력건은 LSE_CHG_AUD_STS_CD를 NULL로 end.
					}					
					// chungpa 20100104 신규 입력건은 LSE_CHG_AUD_STS_CD를 NULL로 start.
					else if(invoiceOnlyINVO[k].getIbflag().equals("D")){
						if(invoiceOnlyINVO[k].getLseChgAudStsCd().equals(""))//값이 없을 경우 이것은 신규 add해서 lse_chg_aud_sts_cd가 null인경우이고 이것은 따로 처리한다.
						{
							delInvoiceList.add(mgsConfirmPayableAmountINVO4);
						}
					}
					// chungpa 20100104 신규 입력건은 LSE_CHG_AUD_STS_CD를 NULL로 end.	
				}
			}
			
			/*------------------------------
				Data 값 처리
			------------------------------*/
			if(concidenceList != null){
				// Concidence 상태값 변경처리
				dbDao.modifyMGSAuditInvoiceConcidenceData(concidenceList);
			}
			
			if(discrepancyList != null){
				// Discrepancy 수정 (비고) 
				dbDao.modifyMGSAuditInvoiceDiscrepancyData(discrepancyList);
			}
			
			if(delInvoiceList != null)
			{
				dbDao.removeMGSAuditInvoiceOnlyDetailData(delInvoiceList);
			}
			
			if(insInvoiceList != null || updInvoiceList != null || insUpdInvoiceList != null){
				// Invoice Only 신규입력 (상태 ibflag가  'I' 인 것만)
				dbDao.addMGSAuditInvoiceOnlyDetailData(insInvoiceList);
				
				// Invoice Only 수정 (비고)(상태 ibflag가  'U' 인 것만)
				dbDao.modifyMGSAuditInvoiceOnlyDetailData(updInvoiceList);
	
				// chungpa 20100104 신규 입력건은 LSE_CHG_AUD_STS_CD를 NULL로 start.
				// Invoice Only 수정 (신규 add 데이터) 
				dbDao.modifyMGSAuditInvoiceOnlyDetailData(insUpdInvoiceList);
				// chungpa 20100104 신규 입력건은 LSE_CHG_AUD_STS_CD를 NULL로 end.
				
				// Header Data 수정  (INV_SMRY_AMT, CR_SMRY_AMT, TAX_SMRY_AMT)
				dbDao.modifyMGSInvoiceAuditResultHeaderData(insInvoiceList);
			}
			
			/*--------------------------------------------------------
			 	Concidence 와 Invoice Only 결과 List 를 조회하여 Return
			 ---------------------------------------------------------*/
			/*
			// Concidence 목록
			if(concidenceINVO != null){
				rtnList = dbDao.searchMGSConcidenceStatusData(mgsConfirmPayableAmountINVO);
			} 
			
			// Discrepancy 목록
			if(discrepancyINVO != null){
				rtnList = dbDao.searchMGSDiscrepancyStatusData(mgsConfirmPayableAmountINVO);
			}
			*/
			// Invoice Only 목록
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
	 * 화면의 Payable Amount 대로 비용 확정(confirm) 처리한다. (M.G.Set)[EES_CGM_2098]<br>
	 * 
	 * @param mgsConfirmPayableAmountINVOS MGSConfirmPayableAmountINVO[]
	 * @param mgsConfirmPayableAmountINVO MGSConfirmPayableAmountINVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void confirmMGSPayableAmountBasic(MGSConfirmPayableAmountINVO[] mgsConfirmPayableAmountINVOS, 
			MGSConfirmPayableAmountINVO mgsConfirmPayableAmountINVO, SignOnUserAccount account) throws EventException{
		
		try {
			
			// CGN_PAY_INV 에 Concidency 에 해당하는 Inv No 가 존재가 하는지  체크한다.
			int invNoCnt = dbDao.checkMGSPayableInvoiceNoData(mgsConfirmPayableAmountINVO);
			
			if(invNoCnt > 0){
				// Invoice No 가 존재하면 에러메시지 처리
				throw new EventException(new ErrorHandler("CGM20025",new String[]{}).getMessage());
			}
			
			List<MGSConfirmPayableAmountINVO> confirmPayableAmountList = new ArrayList<MGSConfirmPayableAmountINVO>();
			
			// 화면에서 넘어온 파라메터 값 설정
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
					
					//chungpa 20100518 chg_seq 추가 start
					mgsConfirmPayableAmountINVO2.setChgSeq(mgsConfirmPayableAmountINVOS[i].getChgSeq());
					//chungpa 20100518 chg_seq 추가 end 
					
					confirmPayableAmountList.add(mgsConfirmPayableAmountINVO2);
				}
			}

			// Confirm Payable VO 값 설정
			mgsConfirmPayableAmountINVO.setCostOfcCd(account.getOfc_cd());
			mgsConfirmPayableAmountINVO.setIssOfcCd(account.getOfc_cd());
			mgsConfirmPayableAmountINVO.setCostOfcCd(account.getOfc_cd());
			mgsConfirmPayableAmountINVO.setInvUsrId(account.getUsr_id());
			
			mgsConfirmPayableAmountINVO.setCreUsrId(account.getUsr_id());
			mgsConfirmPayableAmountINVO.setUpdUsrId(account.getUsr_id());
			
			
			// CGM_LSE_CHG_DTL 수정 (Payable 관련 항목) - 항목 업데이트 
			// 1. (상태를 전부 'C'로 수정)
			// 2. PAY_LSE_USE_DYS
			dbDao.modifyMGSPayableAmountDetailData(confirmPayableAmountList);
			
			/*------------------------------------------
			 	CGM_PAY_INV 삭제 후 Insert 처리
			 -------------------------------------------*/
			
			// CGM_PAY_INV 삭제 (Concidence 대상 Data)
			dbDao.removeMGSPayableAmountData(mgsConfirmPayableAmountINVO);
			
			// Payable Amount Insert
			dbDao.addMGSPayableAmountData(mgsConfirmPayableAmountINVO);
			
			// CGM_LSE_CHG_DTL 수정 (Payable 관련 항목) - PAY_INV_SEQ 를 업데이트
			dbDao.modifyMGSPayableInvoiceSeqData(mgsConfirmPayableAmountINVO);
			
			// CGM_LSE_CHG_HDR 수정 
			// 1. LSE_CHG_STS_CD 상태값을 'S' 로 수정)
			// 2. INV_SMRY_AMT, CR_SMRY_AMT, TAX_SMRY_AMT 값 수정
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
	 * 화면의 Payable Amount 대로 비용 확정(cancel) 취소 처리한다. (M.G.Set)[EES_CGM_2098]<br>
	 * 
	 * @param mgsConfirmPayableAmountINVO MGSConfirmPayableAmountINVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void cancelMGSPayableAmountBasic(MGSConfirmPayableAmountINVO mgsConfirmPayableAmountINVO, SignOnUserAccount account) throws EventException{
		try {
			
			mgsConfirmPayableAmountINVO.setUpdUsrId(account.getUsr_id());
			
			// Invoice Only 화면에서 추가한 데이터 삭제
			dbDao.removeMGSPayableAddInvOnlyData(mgsConfirmPayableAmountINVO);
			
			// Invoice Import & Audit 상태로 데이터를 수정 
			dbDao.modifyMGSPayableChgDtlCancelData(mgsConfirmPayableAmountINVO);
			
			// Header 정보의 INV_SMRY_AMT, TAX_SMRY_AMT, CR_SMRY_AMT 및 상태값을 수정 ('A')
			dbDao.modifyMGSPayableChgHdrCancelData(mgsConfirmPayableAmountINVO);
			
			// Invoice 데이터를 삭제한다.
			dbDao.removeMGSPayableInvCreationData(mgsConfirmPayableAmountINVO);
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}
	
	/**
	 * Invoice No 에 대한 체크 처리한다.(Chassis)[EES_CGM_1123][EES_CGM_1124][EES_CGM_1223]<br>
	 * 
	 * @param invNo String
	 * @param chssMgstInvKndCd String
	 * @param costYrmon String
	 * @exception EventException
	 */
	public void checkCHSInvoiceNoBasic(String invNo, String chssMgstInvKndCd, String costYrmon) throws EventException {
		try {
		
			// CGM_PAY_INV의 다른 풀코드(chssMgstInvKndCd)에 동일한 Invoice No 가 존재하는지 체크하여 Exception 처리
			long invNoCnt = dbDao.checkCHSInvoiceNoData(invNo, chssMgstInvKndCd);
			if(invNoCnt > 0){
				throw new EventException(new ErrorHandler("CGM20025",new String[]{invNo}).getMessage());
			}
			
			// CGM_PAY_INV의 같은 풀코드(chssMgstInvKndCd) 안에서 다른 Cost Month에 동일한 Invoice No 가 존재하는지 체크하여 Exception 처리
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
	 * 저장된 Neutral Pool Charge 목록을 조회한다.(Chassis)[EES_CGM_1124]<br>
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
	 * Neutral Pool Charge 초기 항목을 조회한다.(Chassis)[EES_CGM_1124]<br>
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
	 * 저장된 Neutral Pool Charge 상세 내역을 조회한다.(Chassis)[EES_CGM_1124]<br>
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
				
					// Main Data 조회 결과를 chsCoPoolChargeMGTVO 에 설정
					CHSNuPoolChargeMGTVO  chsNuPoolChargeMGTVO = (CHSNuPoolChargeMGTVO)list.get(0);
					
					// Detail 조회 결과를 chsCoPoolChargeMGTVO 에 설정
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
	 * Neutral Charge Main 정보를 조회한다.(Chassis)[EES_CGM_1124]<br>
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
	 * 입력된 Neutral Charge 를 관리한다.(Chassis)[EES_CGM_1124]<br>
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
			 	VO 값 설정
			 --------------------------------*/
			// Save 일 경우 'H', Confirm 일 경우 'S'
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
			}
			

			
			// CGM_PAY_INV 입력
			long payInvSeq = dbDao.searchCHSNuPoolChargePayInvSeqData(chsNuPoolChargeINVO);			
			if(chsNuPoolChargeINVO != null){
				chsNuPoolChargeINVO.setPayInvSeq(String.valueOf(payInvSeq));
			}
			dbDao.addCHSNuPoolChargeMainData(chsNuPoolChargeINVO);
			
			// CGM_PAY_INV_POOL_DTL 입력
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
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}
	
	/**
	 * 입력된 Neutral Charge 를 수정한다.(Chassis)[EES_CGM_1124]<br>
	 * 
	 * @param chsNuPoolChargeINVOS CHSNuPoolChargeINVO[]
	 * @param chsNuPoolChargeINVO CHSNuPoolChargeINVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyCHSNuPoolChargeBasic (CHSNuPoolChargeINVO[] chsNuPoolChargeINVOS, CHSNuPoolChargeINVO chsNuPoolChargeINVO, SignOnUserAccount account) throws EventException {
		
		List<CHSNuPoolChargeINVO> insertVoList = new ArrayList<CHSNuPoolChargeINVO>();
		
		try {
			
			// Save 일 경우 'H', Confirm 일 경우 'S'
			if(chsNuPoolChargeINVO != null){
				if(chsNuPoolChargeINVO.getActionflag().equals("SAVE")){
					chsNuPoolChargeINVO.setChssMgstInvStsCd("H");
				} else if (chsNuPoolChargeINVO.getActionflag().equals("CONFIRM")){
					chsNuPoolChargeINVO.setChssMgstInvStsCd("S");
				}
				
				chsNuPoolChargeINVO.setChssMgstInvKndCd("NP");
				chsNuPoolChargeINVO.setInvUsrId(account.getUsr_id());
				chsNuPoolChargeINVO.setUpdUsrId(account.getUsr_id());				
			}
				

			
			// CGM_PAY_INV 수정
			dbDao.modifyCHSNuPoolChargeMainData(chsNuPoolChargeINVO);
			
			// CGM_PAY_INV_POOL_DTL 삭제
			dbDao.removeCHSNuPoolChargeDtlData(chsNuPoolChargeINVO);
			
			// CGM_PAY_INV_POOL_DTL 입력
			for (int k=0; k < chsNuPoolChargeINVOS.length; k++){
				
				CHSNuPoolChargeINVO chsNuPoolChargeINVO2 = new CHSNuPoolChargeINVO();
				
				chsNuPoolChargeINVO2.setPayInvSeq(chsNuPoolChargeINVOS[k].getPayInvSeq());
				chsNuPoolChargeINVO2.setDtlPoolCostItmCd(chsNuPoolChargeINVOS[k].getDtlPoolCostItmCd());
				chsNuPoolChargeINVO2.setCostChssQty(chsNuPoolChargeINVOS[k].getCostChssQty());
				chsNuPoolChargeINVO2.setCostBilDys(chsNuPoolChargeINVOS[k].getCostBilDys());
				chsNuPoolChargeINVO2.setCostAmt(chsNuPoolChargeINVOS[k].getCostAmt());
				chsNuPoolChargeINVO2.setCreUsrId(account.getUsr_id());
				chsNuPoolChargeINVO2.setUpdUsrId(account.getUsr_id());
										
				insertVoList.add(chsNuPoolChargeINVO2);
			}
			
			dbDao.addCHSNuPoolChargeDtlData(insertVoList);
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}
	
	/**
	 * 기저장된 Neutral Pool Charge 정보를 삭제한다.(Chassis)[EES_CGM_1124]<br>
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
	 * Invoice List 를 조회한다.(Chassis)[EES_CGM_1034]<br>
	 * 
	 * @param chsPayableInvoiceCreationINVO CHSPayableInvoiceCreationINVO
	 * @return List<CHSPayableInvoiceCreationMGTVO>
	 * @exception EventException
	 */
	public List<CHSPayableInvoiceCreationMGTVO> searchCHSInvoiceListBasic (CHSPayableInvoiceCreationINVO chsPayableInvoiceCreationINVO) throws EventException{
		try {
	
			return dbDao.searchCHSInvoiceListData(chsPayableInvoiceCreationINVO);
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}
	
	/**
	 * 선택된 Invoice 에 속한 Detail 건들을 조회한다.(Chassis)[EES_CGM_1034]<br>
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
	 * Invoice Creation 화면에서 입력된 제반 사항(Issue date, effective date, receive date, revenue VVD 등) <br>
	 * 내용으로 Invoice 를 생성한다. (Chassis)[EES_CGM_1034]<br>
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
				
//				String revVvd = chsPayableInvoiceCreationINVOS[i].getRevVvd();
//				String revVslCd = "";
//				String revSkdVoyNo = "";
//				String revSkdDirCd = "";
//				String revDirCd = "";
//				
//				if(!revVvd.equals("") && revVvd != null){
//					if(revVvd.length()==10){
//						revVslCd = revVvd.substring(0, 4);
//						revSkdVoyNo = revVvd.substring(4, 8);
//						revSkdDirCd = revVvd.substring(8, 9);
//						revDirCd = revVvd.substring(9, 10);
//					}
//				}
//				
//				chsPayableInvoiceCreationINVO2.setRevVslCd(revVslCd);
//				chsPayableInvoiceCreationINVO2.setRevSkdVoyNo(revSkdVoyNo);
//				chsPayableInvoiceCreationINVO2.setRevSkdDirCd(revSkdDirCd);
//				chsPayableInvoiceCreationINVO2.setRevDirCd(revDirCd);
				
				chsPayableInvoiceCreationINVO2.setInvTaxCltTpCd(chsPayableInvoiceCreationINVOS[i].getInvTaxCltTpCd());
				chsPayableInvoiceCreationINVO2.setInvTaxRt(chsPayableInvoiceCreationINVOS[i].getInvTaxRt());
				chsPayableInvoiceCreationINVO2.setInvSmryAmt(chsPayableInvoiceCreationINVOS[i].getInvSmryAmt());
				chsPayableInvoiceCreationINVO2.setInvRgstNo(chsPayableInvoiceCreationINVOS[i].getInvRgstNo());
				chsPayableInvoiceCreationINVO2.setUpdUsrId(account.getUsr_id());
				
				chsPayableInvoiceCreationINVO2.setPayInvSeq(chsPayableInvoiceCreationINVOS[i].getPayInvSeq());
				
				// Header 부분을 수정하기 위한 정보 설정
				chsPayableInvoiceCreationINVO2.setCostYrmon(chsPayableInvoiceCreationINVO.getCostYrmon());
				chsPayableInvoiceCreationINVO2.setEqKndCd(chsPayableInvoiceCreationINVO.getEqKndCd());
				chsPayableInvoiceCreationINVO2.setChgCreSeq(chsPayableInvoiceCreationINVOS[i].getChgCreSeq());
				
				if(chsPayableInvoiceCreationINVOS[i].getChssMgstInvKndCd().equals("LS")){
					lseList.add(chsPayableInvoiceCreationINVO2);
				}
				
				list.add(chsPayableInvoiceCreationINVO2);
			}
			
			dbDao.modifyCHSInvoiceCreationData(list);
			
			// charge seq 에 해당하는 header 데이터의 상태를 'C' 로 업데이트. (LS 일 경우에만 실행)
			dbDao.modifyCHSInvoiceCreationHeaderData(lseList);
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
		
		
	}
	
	/**
	 * Confirm 된 Invoice 를 Charge Creation 상태로 Cancel 처리한다. (Chassis)[EES_CGM_1034]<br>
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
			
			// LSE 일 경우 CGM_LSE_CHG_DTL 를  Charge Creation 상태로 변경
			///dbDao.modifyCHSInvoiceDeleteDtlData(lseList);
				
			// LSE 일 경우 CGM_LSE_CHG_HDR 를  P.Amt Confirm 상태로 변경
			dbDao.modifyCHSInvoiceDeleteHdrData(lseList);
			
			// LSE 일 경우 CGM_PAY_INV 를  삭제
			//dbDao.removeCHSInvoiceDeleteData(lseList);
		
			// POOL 일 경우 CGM_PAY_INV 상태만 저장상태로 변경
			dbDao.modifyCHSInvoiceDeleteData(list);
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
		
	}
	
	/**
	 * Payable Invoice Creation 에서 AP_INV_MAIN 에 넘길 값을 조회한다. (Chassis)[EES_CGM_1034]<br>
	 * 
	 * @param chsPayableInvoiceCreationINVO CHSPayableInvoiceCreationINVO
	 * @param account SignOnUserAccount
	 * @return ApPayInvVO
	 * @exception EventException
	 */
	public ApPayInvVO searchCHSInvoiceCreateMainBasic(CHSPayableInvoiceCreationINVO chsPayableInvoiceCreationINVO, SignOnUserAccount account) throws EventException{
		
		ApPayInvVO apPayInvVO = new ApPayInvVO();
		
		try {
			
			// 해당 pay_inv_seq 에 해당하는 데이터를 가져온다.
			List<CHSPayableInvoiceCreationMGTVO> list = dbDao.searchCHSInvoiceCreateMainData(chsPayableInvoiceCreationINVO);
			
			if(list != null){

				// 입력받은 값과 DB에서 읽어온 값을 ApPayInvVO 에 설정한다.
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
				
				Double invTaxRt = Double.parseDouble(chsPayableInvoiceCreationINVO.getInvTaxRt());
				Double chgSmryAmt = Double.parseDouble(chsPayableInvoiceCreationINVO.getChgSmryAmt());
				Double invTtlAmt = null;
				
				if(chsPayableInvoiceCreationINVO.getInvTaxCltTpCd().equals("VAT")){
						
					apPayInvVO.setInvVatAmt(String.valueOf(invTaxRt * chgSmryAmt / 100));
					apPayInvVO.setWhldTaxAmt("0");
					invTtlAmt = chgSmryAmt + Double.parseDouble(apPayInvVO.getInvVatAmt());					
				
				} else if(chsPayableInvoiceCreationINVO.getInvTaxCltTpCd().equals("WHT")){
					
					apPayInvVO.setInvVatAmt("0");
					apPayInvVO.setWhldTaxAmt(chsPayableInvoiceCreationINVO.getInvTaxRt());
					invTtlAmt = chgSmryAmt - Double.parseDouble(apPayInvVO.getWhldTaxAmt());
					
				} else {
					apPayInvVO.setInvVatAmt("0");
					apPayInvVO.setWhldTaxAmt("0");	
					invTtlAmt = chgSmryAmt;
				}
				
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
	 * Payable Invoice Creation 에서 AP_INV_DTL 에 넘길 값을 조회한다. (Chassis)[EES_CGM_1034]<br>
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
					apPayInvDtlVO.setIbflag("I");	// 무조건 Insert 하도록  I 로 설정
					
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
	 * Invoice List 를 조회한다. (M.G.Set)[EES_CGM_2035]<br>
	 * 
	 * @param mgsPayableInvoiceCreationINVO MGSPayableInvoiceCreationINVO
	 * @return List<MGSPayableInvoiceCreationMGTVO>
	 * @exception EventException
	 */
	public List<MGSPayableInvoiceCreationMGTVO> searchMGSInvoiceListBasic (MGSPayableInvoiceCreationINVO mgsPayableInvoiceCreationINVO) throws EventException{
		try {
	
			return dbDao.searchMGSInvoiceListData(mgsPayableInvoiceCreationINVO);
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}
	
	/**
	 * 선택된 Invoice 에 속한 Detail 건들을 조회한다. (M.G.Set)[EES_CGM_2035]<br>
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
	 * Invoice Creation 화면에서 입력된 제반 사항(Issue date, effective date, receive date, revenue VVD 등) <br>
	 * 내용으로 Invoice 를 생성한다. (M.G.Set)[EES_CGM_2035]<br>
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
				
				// Header 부분을 수정하기 위한 정보 설정
				mgsPayableInvoiceCreationINVO2.setCostYrmon(mgsPayableInvoiceCreationINVO.getCostYrmon());
				mgsPayableInvoiceCreationINVO2.setEqKndCd(mgsPayableInvoiceCreationINVO.getEqKndCd());
				mgsPayableInvoiceCreationINVO2.setChgCreSeq(mgsPayableInvoiceCreationINVOS[i].getChgCreSeq());
				
				list.add(mgsPayableInvoiceCreationINVO2);
			}
			
			dbDao.modifyMGSInvoiceCreationData(list);
			
			// vndr_seq 에 해당하는 header 데이터의 상태를 'C' 로 업데이트.
			dbDao.modifyMGSInvoiceCreationHeaderData(list);
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
		
		
	}
	
	/**
	 * Confirm 된 Invoice 를 Charge Creation 상태로 Cancel 처리한다. (M.G.Set)[EES_CGM_2035]<br>
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
			
			// LSE 일 경우 CGM_LSE_CHG_DTL 를  Charge Creation 상태로 변경
			//dbDao.modifyMGSInvoiceDeleteDtlData(lseList);
				
			// LSE 일 경우 CGM_LSE_CHG_HDR 를  P.Amt Confirm 상태로 변경
			dbDao.modifyMGSInvoiceDeleteHdrData(lseList);
			
			// LSE 일 경우 CGM_PAY_INV 의 상태값 수정
			dbDao.modifyMGSInvoiceDeleteData(lseList);
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
		
	}
	
	/**
	 * Payable Invoice Creation 에서 AP_INV_MAIN 에 넘길 값을 조회한다. (M.G.Set)[EES_CGM_2035]<br>
	 * 
	 * @param mgsPayableInvoiceCreationINVO MGSPayableInvoiceCreationINVO
	 * @param account SignOnUserAccount
	 * @return ApPayInvVO
	 * @exception EventException
	 */
	public ApPayInvVO searchMGSInvoiceCreateMainBasic(MGSPayableInvoiceCreationINVO mgsPayableInvoiceCreationINVO, SignOnUserAccount account) throws EventException{
		
		ApPayInvVO apPayInvVO = new ApPayInvVO();
		
		try {
			
			// 해당 pay_inv_seq 에 해당하는 데이터를 가져온다.
			List<MGSPayableInvoiceCreationMGTVO> list = dbDao.searchMGSInvoiceCreateMainData(mgsPayableInvoiceCreationINVO);
			
			if(list != null){

				// 입력받은 값과 DB에서 읽어온 값을 ApPayInvVO 에 설정한다.
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
				
				Double invTtlAmt = chgSmryAmt + Double.parseDouble(apPayInvVO.getInvVatAmt()) +  Double.parseDouble(apPayInvVO.getWhldTaxAmt());
				
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
	 * Payable Invoice Creation 에서 AP_INV_DTL 에 넘길 값을 조회한다. (M.G.Set)[EES_CGM_2035]<br>
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
					apPayInvDtlVO.setIbflag("I");	// 무조건 Insert 하도록  I 로 설정
					
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
	 * 월별 Chassis 추정결산 조회. [EES_CGM_1107]<br>
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
	 * 월별 Chassis 추정결산 산정. BackEndJob [EES_CGM_1107]<br>
	 * 
	 * @param cHSEstimateExpenseINVO CHSEstimateExpenseINVO
	 * @param account SignOnUserAccount
	 * @return String
	 * @exception EventException
	 */
	public String searchCHSEstimateExpenseCalcBasicBackEndJobStart(CHSEstimateExpenseINVO cHSEstimateExpenseINVO, SignOnUserAccount account) throws EventException
	{
		ChassisMgsetInvoiceInvoiceEstimateExpenseBackEndJob command = new ChassisMgsetInvoiceInvoiceEstimateExpenseBackEndJob();
		// Execute Month(period_eddt)의 전년도 4자리를 가져오기 위한 변수
		int iBeforeYear = 0;
		String sBeforeYear = null;
		
		iBeforeYear = Integer.parseInt(cHSEstimateExpenseINVO.getPeriodEddt().substring(0,4)) - 1;
		sBeforeYear = Integer.toString(iBeforeYear);
		
		// 전년도 4자리를 exe_yrmon에 세팅
		cHSEstimateExpenseINVO.setExeYrmon(sBeforeYear);
		command.setCHSEstimateExpenseINVO(cHSEstimateExpenseINVO);
		command.setAccount(account);
		BackEndJobManager backEndJobManager = new BackEndJobManager();
		
		try {
			String key = backEndJobManager.execute(command, account.getUsr_id() ,"CGM Invoice Estimate Expense");
			
			return key;
			
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}
	
	/**
	 * 월별 Chassis 추정결산 Summary 조회. [EES_CGM_1107]<br>
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
	 * 월별 Chassis 추정결산 처리. [EES_CGM_1107]<br>
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
			//insert직전 모두 삭제.
			dbDao.removeCHSEstimateExpenseCalcData(cHSEstimateExpenseINVO);
			
			//insert
			for(int i=0; i<cHSEstimateExpenseINVOs.length; i++){
				// chungpa 20100201 CRE_USR_ID는 이제부터 Calculation시 결정됨. 주석처리함.
				//cHSEstimateExpenseINVOs[i].setCreUsrId(account.getUsr_id());
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
	 * 월별 M.G. Set 추정결산 조회. [EES_CGM_2206]<br>
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
	 * 월별 M.G. Set 추정결산 산정. [EES_CGM_2206]<br>
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
	 * 월별 M.G. Set 추정결산 Summary 조회. [EES_CGM_2206]<br>
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
	 * 월별 M.G. Set 추정결산 처리. [EES_CGM_2206]<br>
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
			//insert직전 모두 삭제.
			dbDao.removeMGSEstimateExpenseCalcData(mGSEstimateExpenseINVO);
			
			//insert
			for(int i=0; i<mGSEstimateExpenseINVOs.length; i++){
				// chungpa 20100201 CRE_USR_ID는 이제부터 Calculation시 결정됨. 주석처리함. 
				//mGSEstimateExpenseINVOs[i].setCreUsrId(account.getUsr_id());
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
	 * Chassis의 INVOICE를 Summary 하여 보여준다.(Chassis)[EES_CGM_1035]<br>
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
	 * Chassis의 INVOICE Detail 데이터를 보여준다.(Chassis)[EES_CGM_1035]<br>
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
	 * M.G.Set의 INVOICE를 Summary 하여 보여준다.(M.G.Set)[EES_CGM_2036]<br>
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
	 * M.G.Set의 INVOICE Detail 데이터를 보여준다.(M.G.Set)[EES_CGM_2036]<br>
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
	
	/**
	 * Cps Charge Creation 할 대상을 조회한다.(Cps Chassis)[EES_CGM_1203]<br>
	 * 
	 * @param chsChargeCreationINVO CHSChargeCreationINVO
	 * @return List<CHSChargeCreationMGTVO>
	 * @exception EventException
	 */
	@Override
	public List<CHSChargeCreationMGTVO> searchCHSCpsChargeCreationListBasic(CHSChargeCreationINVO chsChargeCreationINVO) throws EventException {
		try {
				return dbDao.searchCHSCpsChargeCreationListData(chsChargeCreationINVO);
			} catch (DAOException ex) {
				throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
			} catch (Exception ex) {
				throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
			}
	}
	
	/**
	 * Cps Charge Creation 한 결과값을 조회한다.(Cps Chassis)[EES_CGM_1203]<br>
	 * 
	 * @param chsChargeCreationINVO   CHSChargeCreationINVO
	 * @return List<CHSChargeCreationMGTVO>
	 * @exception EventException
	 */
	public List<CHSChargeCreationMGTVO> searchCHSCpsChargeCreationResultBasic(CHSChargeCreationINVO chsChargeCreationINVO) throws EventException {
		try {
			
			return dbDao.searchCHSChargeCreationResultData(chsChargeCreationINVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}
	
	/**
	 * Invoice import 화면에서 로드된 invoice draft 를 Audit 하고 저장한다.(Chssis)[EES_CGM_1204]<br>
	 * 
	 * @param cHSInvoiceImportAuditINVOs CHSInvoiceImportAuditINVO[]
	 * @param cHSInvoiceImportAuditINVO CHSInvoiceImportAuditINVO
	 * @param account SignOnUserAccount
	 * @return String
	 * @exception EventException
	 */
	public String auditCHSCpsInvoiceDraftBackEndJobStart (CHSInvoiceImportAuditINVO[] cHSInvoiceImportAuditINVOs, 
			CHSInvoiceImportAuditINVO cHSInvoiceImportAuditINVO, SignOnUserAccount account) throws EventException
	{
		ChassisMgsetInvoiceCpsInvoiceFileImportBackEndJob command = new ChassisMgsetInvoiceCpsInvoiceFileImportBackEndJob();
		command.setCHSInvoiceImportAuditINVO(cHSInvoiceImportAuditINVO);
		command.setCHSInvoiceImportAuditINVOs(cHSInvoiceImportAuditINVOs);
		command.setAccount(account);
		BackEndJobManager backEndJobManager = new BackEndJobManager();
		
		try {			
			String key = backEndJobManager.execute(command, account.getUsr_id() ,"CGM CPS INVOICE AUDIT");
			log.debug("=======호출 번호:" + key);
			return key;
		}catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}	
	}
	
	/**
	 * Invoice import 화면에서 Usage/Rebill를 제외한 Invoice Type을 Save한다. : Only CGM_LSE_CHG_HDR (Chassis)[EES_CGM_1204]<br>
	 * 
	 * @param cHSInvoiceImportAuditINVO CHSInvoiceImportAuditINVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void saveCHSCpsInvoiceDraft (CHSInvoiceImportAuditINVO cHSInvoiceImportAuditINVO, SignOnUserAccount account) throws EventException {
		
		try {
			/*-------------------------------
		 	Charge Create Sequence
		 	CGM_LSE_CHG_HDR 테이블의 CHG_CRE_SEQ+1 생성
			--------------------------------*/
			long chgCreSeq = dbDao.searchCHSChargeCreateSeqData(); 
			cHSInvoiceImportAuditINVO.setChgCreSeq(String.valueOf(chgCreSeq));
			
			/*------------------------------
		  	파라	메터 설정
			-------------------------------*/
			// List<CHSChargeCreationINVO> 값 설정
			List<CHSChargeCreationINVO> chargeList = new ArrayList<CHSChargeCreationINVO>();
			
			
			CHSChargeCreationINVO tempINVO = new CHSChargeCreationINVO();
				
			tempINVO.setCostYrmon(cHSInvoiceImportAuditINVO.getCostYrmon());
			tempINVO.setEqKndCd(cHSInvoiceImportAuditINVO.getEqKndCd());
			tempINVO.setAgmtOfcCtyCd(cHSInvoiceImportAuditINVO.getAgmtOfcCtyCd());
			tempINVO.setAgmtSeq(cHSInvoiceImportAuditINVO.getAgmtSeq());
			tempINVO.setAgmtVerNo(cHSInvoiceImportAuditINVO.getAgmtVerNo());
			tempINVO.setChgCreSeq(String.valueOf(chgCreSeq));
			tempINVO.setCreOfcCd(account.getOfc_cd());
			tempINVO.setCreUsrId(account.getUsr_id());
			tempINVO.setUpdUsrId(account.getUsr_id());
			/* 2014.08.01 Chang Young Kim Added In accordance with the "미확정 CHM" (S) */
			tempINVO.setCmbInvTp(cHSInvoiceImportAuditINVO.getCmbInvTp());
			tempINVO.setInvNo(cHSInvoiceImportAuditINVO.getInvNo());
			tempINVO.setOrgInvNo(cHSInvoiceImportAuditINVO.getOrgInvNo());
			tempINVO.setLseChgStsCd("A");
			/* 2014.08.01 Chang Young Kim Added In accordance with the "미확정 CHM" (E) */
				
			chargeList.add(tempINVO);
	
			
			/*---------------------------
				Create Charge
			----------------------------*/
		
			// Create Charge Summary (header) (TABLE : CGM_LSE_CHG_HDR)
			/* 2014.08.01 Chang Young Kim Added In accordance with the "미확정 CHM" (S) */
//			dbDao.addCHSCpsChageCreateSummaryData(chargeList);
			dbDao.addCHSCpsInvoiceDraft(tempINVO);
			/* 2014.08.01 Chang Young Kim Added In accordance with the "미확정 CHM" (E) */
			

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}
	
	/**
	 * CPS payable amount confirm 화면에서 화면 open 시 선택된 Agreement Audit result 를 조회한다. (Chassis)  [EES_CGM_1205]<br>
	 * Invoice Type :	Usage/Rebill	[UNR]
	 * 					Repo(Migration)	[MIG]
	 * 					Min Commitment	[CMT]
	 * 					MH Credit		[MCD]
	 * 					Revenue Sharing	[RSH]
	 * 					Cost Sharing	[CSH]
	 * 
	 * @param CHSCpsPayableInvoiceCreationINVO chsCpsPayableInvoiceCreationINVO
	 * @return CHSCpsConfirmPayableGRPVO
	 * @exception EventException
	 */
	public CHSCpsConfirmPayableGRPVO searchCHSCpsInvoiceAuditResultBasic(CHSCpsPayableInvoiceCreationINVO chsCpsPayableInvoiceCreationINVO) throws EventException{
		
		CHSCpsConfirmPayableGRPVO resultVO = new CHSCpsConfirmPayableGRPVO();
		
		try {
			
			List<List<CHSCpsPayableInvoiceCreationMGTVO>> list      = new ArrayList<List<CHSCpsPayableInvoiceCreationMGTVO>>();
			
			chsCpsPayableInvoiceCreationINVO.setPayLseChgStsCd("C");
			// Concidence 목록
			List<CHSCpsPayableInvoiceCreationMGTVO> concidenceList  = dbDao.searchCHSCpsAuditStatusData(chsCpsPayableInvoiceCreationINVO);
			
			chsCpsPayableInvoiceCreationINVO.setPayLseChgStsCd("D");
			// Discrepancy 목록
			List<CHSCpsPayableInvoiceCreationMGTVO> discrepancyList = dbDao.searchCHSCpsAuditStatusData(chsCpsPayableInvoiceCreationINVO);
			
			chsCpsPayableInvoiceCreationINVO.setPayLseChgStsCd("I");
			// Invoice Only 목록
			List<CHSCpsPayableInvoiceCreationMGTVO> invoiceOnlyList = dbDao.searchCHSCpsAuditStatusData(chsCpsPayableInvoiceCreationINVO);
			
			// Min Commitment/MH Credit 목록. (CGM_LSE_CHG_CMMT_CR_DTL)
			List<CHSCpsInvoiceAuditResultCmmtCrMGTVO> cmtMcdList = 
					dbDao.searchCHSCpsInvoiceAuditResultCmmtCrData(chsCpsPayableInvoiceCreationINVO.getParentAgmtOfcCtyCd()
																,chsCpsPayableInvoiceCreationINVO.getParentAgmtSeq()
																,chsCpsPayableInvoiceCreationINVO.getParentAgmtVerNo()
																,chsCpsPayableInvoiceCreationINVO.getCostYrmon()
																,chsCpsPayableInvoiceCreationINVO.getParentCostYrmonSeq() );
			
			list.add(concidenceList);
			list.add(discrepancyList);
			list.add(invoiceOnlyList);

			resultVO.setCHSCpsPayableInvoiceCreationMGTVOs(list);
			resultVO.setcHSCpsInvoiceAuditResultCmmtCrMGTVO(cmtMcdList);
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
		
		return resultVO;
	}
	
	/**
	 * CPS payable amount confirm 화면에서 화면 open 시 선택된 Agreement Audit result 를 조회한다.(Chassis) [EES_CGM_1205]<br>
	 * Invoice Type : Min Commitment[CMT], MH Credit[MCD]
	 * 
	 * @param String agmtOfcCtyCd
	 * @param String agmtSeq
	 * @param String agmtVerNo
	 * @param String costYrmon
	 * @param String costYrmonSeq 
	 * @return List<CHSCpsInvoiceAuditResultCmmtCrMGTVO>
	 * @exception EventException
	 */
	public List<CHSCpsInvoiceAuditResultCmmtCrMGTVO> searchCHSCpsInvoiceAuditResultCmmtCrBasic(String agmtOfcCtyCd, String agmtSeq, String agmtVerNo, String costYrmon, String costYrmonSeq) throws EventException {
		
		List<CHSCpsInvoiceAuditResultCmmtCrMGTVO> resultVOs = null;
		
		try {
			
			resultVOs = dbDao.searchCHSCpsInvoiceAuditResultCmmtCrData(agmtOfcCtyCd, agmtSeq, agmtVerNo, costYrmon, costYrmonSeq);
			
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
		
		return resultVOs;
		
	}
	
	/**
	 * Eq 별 Invoice Audit result 상태를 저장한다. (Chassis)[EES_CGM_1205]<br>
	 * 
	 * @param List<CHSCpsPayableInvoiceCreationINVO[]> chsCpsPayableInvoiceCreationINVOs
	 * @param CHSCpsPayableInvoiceCreationINVO chsCpsPayableInvoiceCreationINVO
	 * @param SignOnUserAccount account
	 * @return List<CHSCpsPayableInvoiceCreationMGTVO>
	 * @exception EventException
	 */
	public List<CHSCpsPayableInvoiceCreationMGTVO> manageCHSCpsInvoiceAuditResultBasic(List<CHSCpsPayableInvoiceCreationINVO[]> chsCpsPayableInvoiceCreationINVOs, CHSCpsPayableInvoiceCreationINVO chsCpsPayableInvoiceCreationINVO, SignOnUserAccount account) throws EventException{
		
		List<CHSCpsPayableInvoiceCreationMGTVO> rtnList = new ArrayList<CHSCpsPayableInvoiceCreationMGTVO>();
		
		try {
			CHSCpsPayableInvoiceCreationINVO[] concidenceINVO = (CHSCpsPayableInvoiceCreationINVO[])chsCpsPayableInvoiceCreationINVOs.get(0);
			CHSCpsPayableInvoiceCreationINVO[] discrepancyINVO = (CHSCpsPayableInvoiceCreationINVO[])chsCpsPayableInvoiceCreationINVOs.get(1);
			CHSCpsPayableInvoiceCreationINVO[] invoiceOnlyINVO = (CHSCpsPayableInvoiceCreationINVO[])chsCpsPayableInvoiceCreationINVOs.get(2);	
			
			/*------------------------------
			 	VO 값 설정
			 -------------------------------*/
			List<CHSCpsPayableInvoiceCreationINVO> concidenceList = new ArrayList<CHSCpsPayableInvoiceCreationINVO>();
			List<CHSCpsPayableInvoiceCreationINVO> discrepancyList = new ArrayList<CHSCpsPayableInvoiceCreationINVO>();
			List<CHSCpsPayableInvoiceCreationINVO> insInvoiceList = new ArrayList<CHSCpsPayableInvoiceCreationINVO>();
			List<CHSCpsPayableInvoiceCreationINVO> updInvoiceList = new ArrayList<CHSCpsPayableInvoiceCreationINVO>();
			List<CHSCpsPayableInvoiceCreationINVO> delInvoiceList = new ArrayList<CHSCpsPayableInvoiceCreationINVO>(); 	// chungpa 20100104
			
			if(concidenceINVO != null){
				for(int i=0; i<concidenceINVO.length; i++){
					CHSCpsPayableInvoiceCreationINVO chsCpsPayableInvoiceCreationINVO2 = new CHSCpsPayableInvoiceCreationINVO();
					
//					chsCpsPayableInvoiceCreationINVO2.setAgmtOfcCtyCd(concidenceINVO[i].getAgmtOfcCtyCd());
//					chsCpsPayableInvoiceCreationINVO2.setAgmtSeq(concidenceINVO[i].getAgmtSeq());
//					chsCpsPayableInvoiceCreationINVO2.setAgmtVerNo(concidenceINVO[i].getAgmtVerNo());
//					chsCpsPayableInvoiceCreationINVO2.setCostYrmon(chsCpsPayableInvoiceCreationINVO.getCostYrmon());
//					chsCpsPayableInvoiceCreationINVO2.setEqNo(concidenceINVO[i].getInvEqNo());
//					chsCpsPayableInvoiceCreationINVO2.setChgCd(concidenceINVO[i].getChgCd());
//					chsCpsPayableInvoiceCreationINVO2.setChgSeq(concidenceINVO[i].getChgSeq());
//					chsCpsPayableInvoiceCreationINVO2.setEqKndCd(chsCpsPayableInvoiceCreationINVO.getEqKndCd());
//					chsCpsPayableInvoiceCreationINVO2.setPayChgAudRmk(concidenceINVO[i].getPayChgAudRmk());
//					
//					concidenceList.add(chsCpsPayableInvoiceCreationINVO2);
					
					/*----------------------------
			 			COST_CD, ACCT_CD 구하기 
					 -----------------------------*/
					String costCd = "EQCZNP";
					String acctCd = "510851";
					
					chsCpsPayableInvoiceCreationINVO2.setAgmtOfcCtyCd(concidenceINVO[i].getAgmtOfcCtyCd());
					chsCpsPayableInvoiceCreationINVO2.setAgmtSeq(concidenceINVO[i].getAgmtSeq());
					chsCpsPayableInvoiceCreationINVO2.setAgmtVerNo(concidenceINVO[i].getAgmtVerNo());
					chsCpsPayableInvoiceCreationINVO2.setCostYrmon(chsCpsPayableInvoiceCreationINVO.getCostYrmon());
					chsCpsPayableInvoiceCreationINVO2.setChgCd(concidenceINVO[i].getChgCd());
					chsCpsPayableInvoiceCreationINVO2.setChgSeq(concidenceINVO[i].getChgSeq());
					chsCpsPayableInvoiceCreationINVO2.setEqKndCd(chsCpsPayableInvoiceCreationINVO.getEqKndCd());
					chsCpsPayableInvoiceCreationINVO2.setLseChgAudStsCd("C");
					chsCpsPayableInvoiceCreationINVO2.setInvNo(concidenceINVO[i].getInvNo());
					chsCpsPayableInvoiceCreationINVO2.setInvRefNo(concidenceINVO[i].getInvRefNo());
					chsCpsPayableInvoiceCreationINVO2.setInvEqNo(concidenceINVO[i].getInvEqNo());
					
					// modified by yongchan shin, 2014-03-19 (getInvEqNo --> getEqNo)
					chsCpsPayableInvoiceCreationINVO2.setEqNo(concidenceINVO[i].getEqNo());

					chsCpsPayableInvoiceCreationINVO2.setInvCustEqNo(concidenceINVO[i].getInvCustEqNo());
					chsCpsPayableInvoiceCreationINVO2.setEqTpszCd(concidenceINVO[i].getEqTpszCd());
					chsCpsPayableInvoiceCreationINVO2.setInvEqOnhLocNm(concidenceINVO[i].getInvEqOnhLocNm());
					chsCpsPayableInvoiceCreationINVO2.setInvEqOnhDt(concidenceINVO[i].getInvEqOnhDt());
					chsCpsPayableInvoiceCreationINVO2.setInvEqOffhDt(concidenceINVO[i].getInvEqOffhDt());
					chsCpsPayableInvoiceCreationINVO2.setInvBilStDt(concidenceINVO[i].getInvBilStDt());
					chsCpsPayableInvoiceCreationINVO2.setInvBilEndDt(concidenceINVO[i].getInvBilEndDt());
					chsCpsPayableInvoiceCreationINVO2.setInvLseUseDys(concidenceINVO[i].getInvLseUseDys());
					chsCpsPayableInvoiceCreationINVO2.setInvBilUtDys(concidenceINVO[i].getInvBilUtDys());
					chsCpsPayableInvoiceCreationINVO2.setInvLseRtAmt(concidenceINVO[i].getInvLseRtAmt());
					chsCpsPayableInvoiceCreationINVO2.setInvLseChgAmt(concidenceINVO[i].getInvLseChgAmt());
					chsCpsPayableInvoiceCreationINVO2.setLseChgAudRsltRsnCd(concidenceINVO[i].getLseChgAudRsltRsnCd());
					chsCpsPayableInvoiceCreationINVO2.setInvTaxAmt(concidenceINVO[i].getInvTaxAmt());
					chsCpsPayableInvoiceCreationINVO2.setInvCrAmt(concidenceINVO[i].getInvCrAmt());
					chsCpsPayableInvoiceCreationINVO2.setEqFmMvmtCd(concidenceINVO[i].getEqFmMvmtCd());
					chsCpsPayableInvoiceCreationINVO2.setEqFmMvmtDt(concidenceINVO[i].getEqFmMvmtDt());
					chsCpsPayableInvoiceCreationINVO2.setEqFmYdCd(concidenceINVO[i].getEqFmYdCd());
					chsCpsPayableInvoiceCreationINVO2.setEqToMvmtCd(concidenceINVO[i].getEqToMvmtCd());
					chsCpsPayableInvoiceCreationINVO2.setEqToMvmtDt(concidenceINVO[i].getEqToMvmtDt());
					chsCpsPayableInvoiceCreationINVO2.setEqToYdCd(concidenceINVO[i].getEqToYdCd());
					chsCpsPayableInvoiceCreationINVO2.setLseUseDys(concidenceINVO[i].getLseUseDys());
					chsCpsPayableInvoiceCreationINVO2.setLseBilUtDys(concidenceINVO[i].getLseBilUtDys());
					chsCpsPayableInvoiceCreationINVO2.setLseTaxAmt(concidenceINVO[i].getLseTaxAmt());
					chsCpsPayableInvoiceCreationINVO2.setLseChgAmt(concidenceINVO[i].getLseChgAmt());
					chsCpsPayableInvoiceCreationINVO2.setInvScNo(concidenceINVO[i].getInvScNo());
					chsCpsPayableInvoiceCreationINVO2.setInvBkgNo(concidenceINVO[i].getInvBkgNo());
					chsCpsPayableInvoiceCreationINVO2.setInvBkgTermCd(concidenceINVO[i].getInvBkgTermCd());
					chsCpsPayableInvoiceCreationINVO2.setCostCd(costCd);
					chsCpsPayableInvoiceCreationINVO2.setAcctCd(acctCd);
					chsCpsPayableInvoiceCreationINVO2.setPayLseChgStsCd("C");
					
					chsCpsPayableInvoiceCreationINVO2.setInvTaxRtAmt(concidenceINVO[i].getInvTaxRtAmt());
					chsCpsPayableInvoiceCreationINVO2.setInvLseChgTtlAmt(concidenceINVO[i].getInvLseChgTtlAmt());
					chsCpsPayableInvoiceCreationINVO2.setLseTaxRtAmt(concidenceINVO[i].getLseTaxRtAmt());
					chsCpsPayableInvoiceCreationINVO2.setLseChgTtlAmt(concidenceINVO[i].getLseChgTtlAmt());
					
					chsCpsPayableInvoiceCreationINVO2.setPayChgAudRmk(concidenceINVO[i].getPayChgAudRmk());
					chsCpsPayableInvoiceCreationINVO2.setCreUsrId(account.getUsr_id());
					chsCpsPayableInvoiceCreationINVO2.setUpdUsrId(account.getUsr_id());
					
					chsCpsPayableInvoiceCreationINVO2.setChgCreSeq(chsCpsPayableInvoiceCreationINVO.getChgCreSeq());	// header 를 수정하기 위해 필요.
					chsCpsPayableInvoiceCreationINVO2.setCostYrmonSeq(concidenceINVO[i].getCostYrmonSeq());	// cost_yrmon_seq.
										
					if(concidenceINVO[i].getIbflag().equals("I")){
						chsCpsPayableInvoiceCreationINVO2.setLseChgAudStsCd(null);
						
						insInvoiceList.add(chsCpsPayableInvoiceCreationINVO2);
					} else if(concidenceINVO[i].getIbflag().equals("U")){
						concidenceList.add(chsCpsPayableInvoiceCreationINVO2);
					}

					else if(concidenceINVO[i].getIbflag().equals("D")){
						if(concidenceINVO[i].getLseChgAudStsCd().equals(""))//값이 없을 경우 이것은 신규 add해서 lse_chg_aud_sts_cd가 null인경우이고 이것은 따로 처리한다.
						{
							delInvoiceList.add(chsCpsPayableInvoiceCreationINVO2);
						}
					}
					
					
				}
			}
			
			if(discrepancyINVO != null){
				for(int i=0; i<discrepancyINVO.length; i++){
					CHSCpsPayableInvoiceCreationINVO chsCpsPayableInvoiceCreationINVO3 = new CHSCpsPayableInvoiceCreationINVO();
					
					chsCpsPayableInvoiceCreationINVO3.setAgmtOfcCtyCd(discrepancyINVO[i].getAgmtOfcCtyCd());
					chsCpsPayableInvoiceCreationINVO3.setAgmtSeq(discrepancyINVO[i].getAgmtSeq());
					chsCpsPayableInvoiceCreationINVO3.setAgmtVerNo(discrepancyINVO[i].getAgmtVerNo());
					chsCpsPayableInvoiceCreationINVO3.setCostYrmon(chsCpsPayableInvoiceCreationINVO.getCostYrmon());
					
					// modified by yongchan shin, 2014-03-19 (getInvEqNo --> getEqNo)
					chsCpsPayableInvoiceCreationINVO3.setEqNo(discrepancyINVO[i].getEqNo());
					
					chsCpsPayableInvoiceCreationINVO3.setChgCd(discrepancyINVO[i].getChgCd());
					chsCpsPayableInvoiceCreationINVO3.setChgSeq(discrepancyINVO[i].getChgSeq());
					chsCpsPayableInvoiceCreationINVO3.setEqKndCd(chsCpsPayableInvoiceCreationINVO.getEqKndCd());
					chsCpsPayableInvoiceCreationINVO3.setPayChgAudRmk(discrepancyINVO[i].getPayChgAudRmk());
					chsCpsPayableInvoiceCreationINVO3.setCostYrmonSeq(discrepancyINVO[i].getCostYrmonSeq());
					
					discrepancyList.add(chsCpsPayableInvoiceCreationINVO3);
				}
			}
			
			if(invoiceOnlyINVO != null){
				for(int k=0; k < invoiceOnlyINVO.length; k++){
					
					/*----------------------------
				 		COST_CD, ACCT_CD 구하기 
					 -----------------------------*/
					String costCd = "EQCZNP";
					String acctCd = "510851";

					/*---------------------------
					 	Invoice Vo 값 설정
					 ---------------------------*/
					CHSCpsPayableInvoiceCreationINVO chsCpsPayableInvoiceCreationINVO4 = new CHSCpsPayableInvoiceCreationINVO();
					
					chsCpsPayableInvoiceCreationINVO4.setAgmtOfcCtyCd(invoiceOnlyINVO[k].getAgmtOfcCtyCd());
					chsCpsPayableInvoiceCreationINVO4.setAgmtSeq(invoiceOnlyINVO[k].getAgmtSeq());
					chsCpsPayableInvoiceCreationINVO4.setAgmtVerNo(invoiceOnlyINVO[k].getAgmtVerNo());
					chsCpsPayableInvoiceCreationINVO4.setCostYrmon(chsCpsPayableInvoiceCreationINVO.getCostYrmon());
					chsCpsPayableInvoiceCreationINVO4.setChgCd(invoiceOnlyINVO[k].getChgCd());
					chsCpsPayableInvoiceCreationINVO4.setChgSeq(invoiceOnlyINVO[k].getChgSeq());
					chsCpsPayableInvoiceCreationINVO4.setEqKndCd(chsCpsPayableInvoiceCreationINVO.getEqKndCd());
					chsCpsPayableInvoiceCreationINVO4.setLseChgAudStsCd("I");
					chsCpsPayableInvoiceCreationINVO4.setInvNo(invoiceOnlyINVO[k].getInvNo());
					chsCpsPayableInvoiceCreationINVO4.setInvRefNo(invoiceOnlyINVO[k].getInvRefNo());
					chsCpsPayableInvoiceCreationINVO4.setInvEqNo(invoiceOnlyINVO[k].getInvEqNo());
					
					// modified by yongchan shin, 2014-03-19 (getInvEqNo --> getEqNo)
					chsCpsPayableInvoiceCreationINVO4.setEqNo(invoiceOnlyINVO[k].getEqNo());
					
					chsCpsPayableInvoiceCreationINVO4.setInvCustEqNo(invoiceOnlyINVO[k].getInvCustEqNo());
					chsCpsPayableInvoiceCreationINVO4.setEqTpszCd(invoiceOnlyINVO[k].getEqTpszCd());
					chsCpsPayableInvoiceCreationINVO4.setInvEqOnhLocNm(invoiceOnlyINVO[k].getInvEqOnhLocNm());
					chsCpsPayableInvoiceCreationINVO4.setInvEqOnhDt(invoiceOnlyINVO[k].getInvEqOnhDt());
					chsCpsPayableInvoiceCreationINVO4.setInvEqOffhDt(invoiceOnlyINVO[k].getInvEqOffhDt());
					chsCpsPayableInvoiceCreationINVO4.setInvBilStDt(invoiceOnlyINVO[k].getInvBilStDt());
					chsCpsPayableInvoiceCreationINVO4.setInvBilEndDt(invoiceOnlyINVO[k].getInvBilEndDt());
					chsCpsPayableInvoiceCreationINVO4.setInvLseUseDys(invoiceOnlyINVO[k].getInvLseUseDys());
					chsCpsPayableInvoiceCreationINVO4.setInvBilUtDys(invoiceOnlyINVO[k].getInvBilUtDys());
					chsCpsPayableInvoiceCreationINVO4.setInvLseRtAmt(invoiceOnlyINVO[k].getInvLseRtAmt());
					chsCpsPayableInvoiceCreationINVO4.setInvLseChgAmt(invoiceOnlyINVO[k].getInvLseChgAmt());
					chsCpsPayableInvoiceCreationINVO4.setLseChgAudRsltRsnCd(invoiceOnlyINVO[k].getLseChgAudRsltRsnCd());
					chsCpsPayableInvoiceCreationINVO4.setInvTaxAmt(invoiceOnlyINVO[k].getInvTaxAmt());
					chsCpsPayableInvoiceCreationINVO4.setInvCrAmt(invoiceOnlyINVO[k].getInvCrAmt());
					chsCpsPayableInvoiceCreationINVO4.setEqFmMvmtCd(invoiceOnlyINVO[k].getEqFmMvmtCd());
					chsCpsPayableInvoiceCreationINVO4.setEqFmMvmtDt(invoiceOnlyINVO[k].getEqFmMvmtDt());
					chsCpsPayableInvoiceCreationINVO4.setEqFmYdCd(invoiceOnlyINVO[k].getEqFmYdCd());
					chsCpsPayableInvoiceCreationINVO4.setEqToMvmtCd(invoiceOnlyINVO[k].getEqToMvmtCd());
					chsCpsPayableInvoiceCreationINVO4.setEqToMvmtDt(invoiceOnlyINVO[k].getEqToMvmtDt());
					chsCpsPayableInvoiceCreationINVO4.setEqToYdCd(invoiceOnlyINVO[k].getEqToYdCd());
					chsCpsPayableInvoiceCreationINVO4.setPayLseUseDys(invoiceOnlyINVO[k].getPayLseUseDys());
					chsCpsPayableInvoiceCreationINVO4.setPayBilUtDys(invoiceOnlyINVO[k].getPayBilUtDys());
					chsCpsPayableInvoiceCreationINVO4.setPayTaxAmt(invoiceOnlyINVO[k].getPayTaxAmt());
					chsCpsPayableInvoiceCreationINVO4.setPayLseChgAmt(invoiceOnlyINVO[k].getPayLseChgAmt());
					chsCpsPayableInvoiceCreationINVO4.setInvScNo(invoiceOnlyINVO[k].getInvScNo());
					chsCpsPayableInvoiceCreationINVO4.setInvBkgNo(invoiceOnlyINVO[k].getInvBkgNo());
					chsCpsPayableInvoiceCreationINVO4.setInvBkgTermCd(invoiceOnlyINVO[k].getInvBkgTermCd());
					chsCpsPayableInvoiceCreationINVO4.setCostCd(costCd);
					chsCpsPayableInvoiceCreationINVO4.setAcctCd(acctCd);
					chsCpsPayableInvoiceCreationINVO4.setPayLseChgStsCd("I");
					chsCpsPayableInvoiceCreationINVO4.setPayChgAudRmk(invoiceOnlyINVO[k].getPayChgAudRmk());
					chsCpsPayableInvoiceCreationINVO4.setCreUsrId(account.getUsr_id());
					chsCpsPayableInvoiceCreationINVO4.setUpdUsrId(account.getUsr_id());
					
					chsCpsPayableInvoiceCreationINVO4.setInvTaxRtAmt(invoiceOnlyINVO[k].getInvTaxRtAmt());
					chsCpsPayableInvoiceCreationINVO4.setInvLseChgTtlAmt(invoiceOnlyINVO[k].getInvLseChgTtlAmt());
					
					chsCpsPayableInvoiceCreationINVO4.setChgCreSeq(chsCpsPayableInvoiceCreationINVO.getChgCreSeq());	// header 를 수정하기 위해 필요.
					chsCpsPayableInvoiceCreationINVO4.setCostYrmonSeq(invoiceOnlyINVO[k].getCostYrmonSeq());	// cost_yrmon_seq
										
					if(invoiceOnlyINVO[k].getIbflag().equals("U")){
						updInvoiceList.add(chsCpsPayableInvoiceCreationINVO4);
					}
				}
			}
			
			/*------------------------------
				Data 값 처리
			------------------------------*/
			if(concidenceList != null){
				// Concidence 상태값 변경처리
				dbDao.modifyCHSCpsAuditInvoiceConcidenceData(concidenceList);
			}
			
			if(discrepancyList != null){
				// Discrepancy 수정 (비고) 
				dbDao.modifyCHSCpsAuditInvoiceDiscrepancyData(discrepancyList);
			}
			
			if(delInvoiceList != null)
			{
				dbDao.removeCHSCpsAuditInvoiceOnlyDetailData(delInvoiceList);
			}
			
			if(insInvoiceList != null){
				// Concidence 신규입력 (상태 ibflag가  'I' 인 것만)
				dbDao.addCHSCpsAuditCoincidenceDetailData(insInvoiceList);
				
				// Header Data 수정  (INV_SMRY_AMT, CR_SMRY_AMT, TAX_SMRY_AMT)
				dbDao.modifyCHSCpsInvoiceAuditResultHeaderData(insInvoiceList);
			}
			
			if(updInvoiceList != null){
				// Invoice Only 수정 (비고)(상태 ibflag가  'U' 인 것만)
				dbDao.modifyCHSCpsAuditInvoiceOnlyDetailData(updInvoiceList);
			}
			
			
			/*--------------------------------------------------------
			 	Concidence 와 Invoice Only 결과 List 를 조회하여 Return
			 ---------------------------------------------------------*/
			/*
			// Concidence 목록
			if(concidenceINVO != null){
				rtnList = dbDao.searchCHSConcidenceStatusData(chsConfirmPayableAmountINVO);
			} 
			
			// Discrepancy 목록
			if(discrepancyINVO != null){
				rtnList = dbDao.searchCHSDiscrepancyStatusData(chsConfirmPayableAmountINVO);
			}
			*/
			// Invoice Only 목록 (입력된 값이 존재할 경우 조회)
			if(concidenceINVO != null){
				chsCpsPayableInvoiceCreationINVO.setPayLseChgStsCd("C");
				rtnList = dbDao.searchCHSCpsAuditStatusData(chsCpsPayableInvoiceCreationINVO);
			}
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
		
		return rtnList;
	}
	
	/**
	 * 화면의 Payable Amount 대로 비용 확정(confirm) 처리한다. (Chassis)[EES_CGM_1205]<br>
	 * 
	 * @param CHSCpsPayableInvoiceCreationINVO[] chsCpsPayableInvoiceCreationINVOs
	 * @param CHSConfirmPayableAmountINVO chsConfirmPayableAmountINVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void confirmCHSCpsPayableAmountBasic(CHSCpsPayableInvoiceCreationINVO[] chsCpsPayableInvoiceCreationINVOs, 
			CHSConfirmPayableAmountINVO chsConfirmPayableAmountINVO, SignOnUserAccount account) throws EventException{
		
		try {
			
			// CGN_PAY_INV 에 Concidency 에 해당하는 Inv No 가 존재가 하는지  체크한다.
			int invNoCnt = dbDao.checkCHSPayableInvoiceNoData(chsConfirmPayableAmountINVO);
			
			if(invNoCnt > 0){
				// Invoice No 가 존재하면 에러메시지 처리
				throw new EventException(new ErrorHandler("CGM20025",new String[]{}).getMessage());
			}
			
			List<CHSConfirmPayableAmountINVO> confirmPayableAmountList = new ArrayList<CHSConfirmPayableAmountINVO>();
			
			// 화면에서 넘어온 파라메터 값 설정
			if(chsCpsPayableInvoiceCreationINVOs != null){
				for(int i=0; i<chsCpsPayableInvoiceCreationINVOs.length; i++){
					
					CHSConfirmPayableAmountINVO chsConfirmPayableAmountINVO2 = new CHSConfirmPayableAmountINVO();
					
					chsConfirmPayableAmountINVO2.setCostYrmon(chsConfirmPayableAmountINVO.getCostYrmon());
					chsConfirmPayableAmountINVO2.setEqKndCd(chsConfirmPayableAmountINVO.getEqKndCd());
					chsConfirmPayableAmountINVO2.setParentCostYrmonSeq(chsConfirmPayableAmountINVO.getParentCostYrmonSeq());
					log.debug("\n------------ setCostYrmonSeq : " +chsConfirmPayableAmountINVO.getParentCostYrmonSeq()); 
					chsConfirmPayableAmountINVO2.setAgmtOfcCtyCd(chsCpsPayableInvoiceCreationINVOs[i].getAgmtOfcCtyCd());
					chsConfirmPayableAmountINVO2.setAgmtSeq(chsCpsPayableInvoiceCreationINVOs[i].getAgmtSeq());
					chsConfirmPayableAmountINVO2.setAgmtVerNo(chsCpsPayableInvoiceCreationINVOs[i].getAgmtVerNo());
					chsConfirmPayableAmountINVO2.setEqNo(chsCpsPayableInvoiceCreationINVOs[i].getEqNo());
					chsConfirmPayableAmountINVO2.setChgCd(chsCpsPayableInvoiceCreationINVOs[i].getChgCd());

					
					chsConfirmPayableAmountINVO2.setChgCreSeq(chsConfirmPayableAmountINVO.getChgCreSeq());
					
					
					chsConfirmPayableAmountINVO2.setInvLseUseDys(chsCpsPayableInvoiceCreationINVOs[i].getInvLseUseDys());
					chsConfirmPayableAmountINVO2.setInvLseRtAmt(chsCpsPayableInvoiceCreationINVOs[i].getInvLseRtAmt());
					chsConfirmPayableAmountINVO2.setInvLseChgAmt(chsCpsPayableInvoiceCreationINVOs[i].getInvLseChgAmt());
					chsConfirmPayableAmountINVO2.setInvTaxAmt(chsCpsPayableInvoiceCreationINVOs[i].getInvTaxAmt());
					chsConfirmPayableAmountINVO2.setInvCrAmt(chsCpsPayableInvoiceCreationINVOs[i].getInvCrAmt());
					
					chsConfirmPayableAmountINVO2.setCreUsrId(account.getUsr_id());
					chsConfirmPayableAmountINVO2.setUpdUsrId(account.getUsr_id());
					
					chsConfirmPayableAmountINVO2.setInvCrAmt(chsCpsPayableInvoiceCreationINVOs[i].getCostYrmonSeq());
					
					//chungpa 20100518 chg_seq 추가 start
					chsConfirmPayableAmountINVO2.setChgSeq(chsCpsPayableInvoiceCreationINVOs[i].getChgSeq());
					//chungpa 20100518 chg_seq 추가 end 
					confirmPayableAmountList.add(chsConfirmPayableAmountINVO2);
				}
			}

			// Confirm Payable VO 값 설정
			chsConfirmPayableAmountINVO.setCostOfcCd(account.getOfc_cd());
			chsConfirmPayableAmountINVO.setIssOfcCd(account.getOfc_cd());
			chsConfirmPayableAmountINVO.setCostOfcCd(account.getOfc_cd());
			chsConfirmPayableAmountINVO.setInvUsrId(account.getUsr_id());
			
			chsConfirmPayableAmountINVO.setCreUsrId(account.getUsr_id());
			chsConfirmPayableAmountINVO.setUpdUsrId(account.getUsr_id());
			
			// CGM_LSE_CHG_DTL 수정 (Payable 관련 항목) - 항목 업데이트 (상태를 전부 'C'로 수정)
			dbDao.modifyCHSPayableAmountDetailData(confirmPayableAmountList);
			
			/*------------------------------------------
			 	CGM_PAY_INV 삭제 후 Insert 처리
			 -------------------------------------------*/
			
			// CGM_PAY_INV 삭제 (Concidence 대상 Data)
			dbDao.removeCHSPayableAmountData(chsConfirmPayableAmountINVO);
			
			// Payable Amount Insert
			dbDao.addCHSCpsPayableAmountData(chsConfirmPayableAmountINVO);
			
			// CGM_LSE_CHG_DTL 수정 (Payable 관련 항목) - PAY_INV_SEQ 를 업데이트
			dbDao.modifyCHSPayableInvoiceSeqData(chsConfirmPayableAmountINVO);
			
			// CGM_LSE_CHG_HDR 수정 
			// 1. LSE_CHG_STS_CD 상태값을 'S' 로 수정)
			// 2. CR_SMRY_AMT, TAX_SMRY_AMT 값 수정
			dbDao.modifyCHSCpsPayableAmountHeaderData(chsConfirmPayableAmountINVO);
						
		} catch (EventException ex){
			throw ex;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}
	
	/**
	 * 화면의 Payable Amount 대로 비용 확정(confirm) 취소처리한다. (Chassis)[EES_CGM_1025]<br>
	 * 
	 * @param CHSCpsPayableInvoiceCreationINVO cHSCpsPayableInvoiceCreationINVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelCHSCpsPayableAmountBasic(CHSCpsPayableInvoiceCreationINVO cHSCpsPayableInvoiceCreationINVO, SignOnUserAccount account) throws EventException{
		
		try {
			cHSCpsPayableInvoiceCreationINVO.setUpdUsrId(account.getUsr_id());
			
			// Invoice Only 화면에서 추가한 데이터 삭제
			dbDao.removeCHSCpsPayableAddInvOnlyData(cHSCpsPayableInvoiceCreationINVO);
			
			// Invoice Import & Audit 상태로 데이터를 수정 
			dbDao.modifyCHSCpsPayableChgDtlCancelData(cHSCpsPayableInvoiceCreationINVO);
			
			// Header 정보의 INV_SMRY_AMT, TAX_SMRY_AMT, CR_SMRY_AMT 및 상태값을 수정 ('A')
			dbDao.modifyCHSCpsPayableChgHdrCancelData(cHSCpsPayableInvoiceCreationINVO);
			
			// Invoice 데이터를 삭제한다.
			dbDao.removeCHSCpsPayableInvCreationData(cHSCpsPayableInvoiceCreationINVO);
			
			// Min Commitment/MH Credit 데이터가 존재한다면 삭제한다. (CGM_LSE_CHG_CMMT_CR_DTL)
			CHSCpsInvoiceAuditResultCmmtCrMGTVO deleteVoList = new CHSCpsInvoiceAuditResultCmmtCrMGTVO();
			
			deleteVoList.setAgmtOfcCtyCd(cHSCpsPayableInvoiceCreationINVO.getParentAgmtOfcCtyCd());
			deleteVoList.setAgmtSeq(cHSCpsPayableInvoiceCreationINVO.getParentAgmtSeq());
			deleteVoList.setAgmtVerNo(cHSCpsPayableInvoiceCreationINVO.getParentAgmtVerNo());
			deleteVoList.setCostYrmon(cHSCpsPayableInvoiceCreationINVO.getCostYrmon());
			deleteVoList.setCostYrmonSeq(cHSCpsPayableInvoiceCreationINVO.getParentCostYrmonSeq());
			
			// CGM_LSE_CHG_CMMT_CR_DTL 에 VO로 담아온 PK에 해당하는 Data가 존재가 하는지 Check한다.
			int dataCnt = dbDao.checkCHSCpsInvoiceAuditResultCmmtCrData(deleteVoList);
			
			if(dataCnt > 0) {
				dbDao.removeCHSCpsInvoiceAuditResultCmmtCrData(deleteVoList);
			}
		
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}
	
	/**
	 * Min Commitment/MH Credit Tab의 내용을 저장한다.(Chassis)[EES_CGM_1205] <br>
	 * 
	 * @param CHSCpsInvoiceAuditResultCmmtCrMGTVO[] cHSCpsInvoiceAuditResultCmmtCrMGTVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageCHSCpsInvoiceAuditResultCmmtCrBasic(CHSCpsInvoiceAuditResultCmmtCrMGTVO[] cHSCpsInvoiceAuditResultCmmtCrMGTVOs, SignOnUserAccount account) throws EventException {
		
		try {
			
			List<CHSCpsInvoiceAuditResultCmmtCrMGTVO> insertVoList = new ArrayList<CHSCpsInvoiceAuditResultCmmtCrMGTVO>();
			List<CHSCpsInvoiceAuditResultCmmtCrMGTVO> updateVoList = new ArrayList<CHSCpsInvoiceAuditResultCmmtCrMGTVO>();
			
			if(cHSCpsInvoiceAuditResultCmmtCrMGTVOs != null){
				// CGM_LSE_CHG_CMMT_CR_DTL 에 VO로 담아온 PK에 해당하는 Data가 존재가 하는지 Check한다.
				int dataCnt = dbDao.checkCHSCpsInvoiceAuditResultCmmtCrData(cHSCpsInvoiceAuditResultCmmtCrMGTVOs[0]);
				
				for ( int i=0; i<cHSCpsInvoiceAuditResultCmmtCrMGTVOs.length; i++ ) {
					
					cHSCpsInvoiceAuditResultCmmtCrMGTVOs[i].setCreOfcCd(account.getOfc_cd());
					cHSCpsInvoiceAuditResultCmmtCrMGTVOs[i].setCreUsrId(account.getUsr_id());
					cHSCpsInvoiceAuditResultCmmtCrMGTVOs[i].setUpdUsrId(account.getUsr_id());
					                       
					if(dataCnt == 0){
						// Insert 대상 List에 저장
						insertVoList.add(cHSCpsInvoiceAuditResultCmmtCrMGTVOs[i]);
					} else {
						// Update 대상 List 에 저장 
						updateVoList.add(cHSCpsInvoiceAuditResultCmmtCrMGTVOs[i]);
					} 
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addCHSCpsInvoiceAuditResultCmmtCrData(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyCHSCpsInvoiceAuditResultCmmtCrData(updateVoList);
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
	 * 선택된 Charge 를 삭제한다.(Chassis)[EES_CGM_1203]<br>
	 * 
	 * @param chsChargeCreationINVOS CHSChargeCreationINVO[]
	 * @param chsChargeCreationINVO CHSChargeCreationINVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void removeCHSCpsChargeBasic (CHSChargeCreationINVO[] chsChargeCreationINVOS, CHSChargeCreationINVO chsChargeCreationINVO, SignOnUserAccount account) throws EventException {
		
		try {
			// CGM_LSE_CHG_DTL 삭제
			dbDao.removeCHSChargeDetailData(chsChargeCreationINVO);
			
			// CGM_LSE_CHG_HDR 삭제
			dbDao.removeCHSChargeSummaryData(chsChargeCreationINVO);
			
			CHSInvoiceImportAuditINVO cHSInvoiceImportAuditINVO = new CHSInvoiceImportAuditINVO();
			cHSInvoiceImportAuditINVO.setChgCreSeq(chsChargeCreationINVO.getChgCreSeq());
			dbDao.removeCHSLeaseInvoiceData(cHSInvoiceImportAuditINVO);
			
			// CGM_PAY_INV 삭제 (P.Amt Confirm 일 경우)
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
	 * Invoice List 를 조회한다.(Chassis)[EES_CGM_1207]<br>
	 * 
	 * @param chsPayableInvoiceCreationINVO CHSPayableInvoiceCreationINVO
	 * @return List<CHSPayableInvoiceCreationMGTVO>
	 * @exception EventException
	 */
	public List<CHSPayableInvoiceCreationMGTVO> searchCHSCpsInvoiceListBasic (CHSPayableInvoiceCreationINVO chsPayableInvoiceCreationINVO) throws EventException{
		try {
	
			return dbDao.searchCHSCpsInvoiceListData(chsPayableInvoiceCreationINVO);
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}
	
	/**
	 * 선택된 Invoice 에 속한 Detail 건들을 조회한다.(Chassis)[EES_CGM_1207]<br>
	 * 
	 * @param chsPayableInvoiceCreationINVO CHSPayableInvoiceCreationINVO
	 * @return List<CHSPayableInvoiceCreationMGTVO>
	 * @exception EventException
	 */
	public List<CHSPayableInvoiceCreationMGTVO> searchCHSCpsInvoiceDetailBasic (CHSPayableInvoiceCreationINVO chsPayableInvoiceCreationINVO) throws EventException{
		try {
			return dbDao.searchCHSCpsInvoiceDetailData(chsPayableInvoiceCreationINVO);
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}
	
	/**
	 * Invoice Creation 화면에서 입력된 제반 사항(Issue date, effective date, receive date) <br>
	 * 내용으로 Invoice 를 생성한다. (Chassis)[EES_CGM_1207]<br>
	 * 
	 * @param chsPayableInvoiceCreationINVOS CHSPayableInvoiceCreationINVO[]
	 * @param chsPayableInvoiceCreationINVO CHSPayableInvoiceCreationINVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void createCHSCpsInvoiceBasic(CHSPayableInvoiceCreationINVO[] chsPayableInvoiceCreationINVOS, CHSPayableInvoiceCreationINVO chsPayableInvoiceCreationINVO, SignOnUserAccount account) throws EventException{
		
		try {
			List<CHSPayableInvoiceCreationINVO> list = new ArrayList<CHSPayableInvoiceCreationINVO>();
			
			for(int i=0; i< chsPayableInvoiceCreationINVOS.length; i++){
				CHSPayableInvoiceCreationINVO chsPayableInvoiceCreationINVO2 = new CHSPayableInvoiceCreationINVO();
				
				chsPayableInvoiceCreationINVO2.setInvTaxCltTpCd(chsPayableInvoiceCreationINVOS[i].getInvTaxCltTpCd());
				chsPayableInvoiceCreationINVO2.setInvTaxRt(chsPayableInvoiceCreationINVOS[i].getInvTaxRt());
				chsPayableInvoiceCreationINVO2.setInvSmryAmt(chsPayableInvoiceCreationINVOS[i].getInvSmryAmt());
				chsPayableInvoiceCreationINVO2.setInvRgstNo(chsPayableInvoiceCreationINVOS[i].getInvRgstNo());
				chsPayableInvoiceCreationINVO2.setUpdUsrId(account.getUsr_id());
				
				chsPayableInvoiceCreationINVO2.setPayInvSeq(chsPayableInvoiceCreationINVOS[i].getPayInvSeq());
				
				// Header 부분을 수정하기 위한 정보 설정
				chsPayableInvoiceCreationINVO2.setCostYrmon(chsPayableInvoiceCreationINVO.getCostYrmon());
				chsPayableInvoiceCreationINVO2.setEqKndCd(chsPayableInvoiceCreationINVO.getEqKndCd());
				chsPayableInvoiceCreationINVO2.setChgCreSeq(chsPayableInvoiceCreationINVOS[i].getChgCreSeq());
				
				list.add(chsPayableInvoiceCreationINVO2);
			}
			
			dbDao.modifyCHSInvoiceCreationData(list);
			
			// charge seq 에 해당하는 header 데이터의 상태를 'C' 로 업데이트.
			dbDao.modifyCHSInvoiceCreationHeaderData(list);
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
		
		
	}
	
	/**
	 * Confirm 된 Invoice 를 Charge Creation 상태로 Cancel 처리한다. (Chassis)[EES_CGM_1207]<br>
	 * 
	 * @param chsPayableInvoiceCreationINVOS CHSPayableInvoiceCreationINVO[]
	 * @param chsPayableInvoiceCreationINVO CHSPayableInvoiceCreationINVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void cancelCHSCpsInvoiceBasic(CHSPayableInvoiceCreationINVO[] chsPayableInvoiceCreationINVOS, CHSPayableInvoiceCreationINVO chsPayableInvoiceCreationINVO, SignOnUserAccount account) throws EventException{
		
		try {
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
				
				list.add(chsPayableInvoiceCreationINVO2);
			}

			dbDao.modifyCHSInvoiceDeleteHdrData(list);
			dbDao.modifyCHSInvoiceDeleteData(list);
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
		
	}
	
	/**
	 * 현재일을 기준으로 -3월, 현재월 을 조회<br>
	 * 
	 * @return CHSPoolSCCReportINVO
	 * @exception EventException
	 */
	public CHSPoolSCCReportINVO searchDefaultMonthWeek() throws EventException {
		CHSPoolSCCReportINVO chsPoolSCCReportINVO = null;
		try {
			chsPoolSCCReportINVO = dbDao.searchDefaultMonthWeek();
			return chsPoolSCCReportINVO;
			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20031", new String[]{"Month Week Retrieve"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032", new String[]{"Month Week Retrieve"}).getMessage(),ex);
		}
	}			
	
	/**
	 * 주어진 기간의 주차와,년월 목록을 조회<br>
	 * 
	 * @param CHSPoolSCCReportINVO chsPoolSCCReportINVO
	 * @return List<CHSPoolSCCReportMGTVO>
	 * @exception EventException
	 */
	public List<CHSPoolSCCReportMGTVO> searchMonthList(CHSPoolSCCReportINVO chsPoolSCCReportINVO) throws EventException {
		List<CHSPoolSCCReportMGTVO> list = null;
		try {
			list = dbDao.searchMonthList(chsPoolSCCReportINVO);
			return list;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20031", new String[]{"Month Week List"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032", new String[]{"Month Week List"}).getMessage(),ex);
		}		
	}			
	
	/**
	 * Chassis Amount Pool단위 조회 <br>
	 * 
	 * @param CHSPoolSCCReportINVO chsPoolSCCReportINVO
	 * @return List<CHSPoolSCCReportMGTVO>
	 * @exception EventException
	 */
	public List<CHSPoolSCCReportMGTVO> searchCHSPoolReportBasic(CHSPoolSCCReportINVO chsPoolSCCReportINVO) throws EventException {
		try {
			return dbDao.searchCHSPoolReportData(chsPoolSCCReportINVO);
			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			//throw new EventException(new ErrorHandler(ex).getMessage());
			throw new EventException(new ErrorHandler("CGM20031", new String[]{"Chassis Amount Pool Report Retrieve"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032", new String[]{"Chassis Amount Pool Report Retrieve"}).getMessage(),ex);
		}
	}	
	
	/**
	 * Chassis Amount S/C NO단위 조회 <br>
	 * 
	 * @param CHSSCNOReportINVO chsSCNOReportINVO
	 * @return List<CHSSCNOReportMGTVO>
	 * @exception EventException
	 */
	public List<CHSSCNOReportMGTVO> searchCHSSCNOReportBasic(CHSSCNOReportINVO chsSCNOReportINVO) throws EventException {
		try {
			return dbDao.searchCHSSCNOReportData(chsSCNOReportINVO);
			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			//throw new EventException(new ErrorHandler(ex).getMessage());
			throw new EventException(new ErrorHandler("CGM20031", new String[]{"Chassis Amount SCNO Report Retrieve"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032", new String[]{"Chassis Amount SCNO Report Retrieve"}).getMessage(),ex);
		}
	}
	
	/**
	 * Chassis Exception Qinquiry list 조회 <br>
	 * 
	 * @param CHSScExceptionINVO cHSScExceptionINVO
	 * @return List<CHSScExceptionINVO>
	 * @exception EventException
	 */
	public List<CHSScExceptionINVO> searchCHSSCExceptionService(CHSScExceptionINVO cHSScExceptionINVO) throws EventException {
		try {
			return dbDao.searchCHSSCExceptionService(cHSScExceptionINVO);
			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			//throw new EventException(new ErrorHandler(ex).getMessage());
			throw new EventException(new ErrorHandler("CGM20031", new String[]{"Chassis Exception Inquiry Retrieve"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032", new String[]{"Chassis Exception Inquiry Retrieve"}).getMessage(),ex);
		}
	}
	
	/**
	 * SCC정보를 체크합니다. <br>
	 *
	 * @param CHSScExceptionINVO cHSScExceptionINVO
	 * @return List<CHSScExceptionINVO>
	 * @exception EventException
	 */
	@Override
	public List<CHSScExceptionINVO> searchVerifySccService(CHSScExceptionINVO cHSScExceptionINVO)
			throws EventException {
		try {    
			List<CHSScExceptionINVO> list = new ArrayList<CHSScExceptionINVO>();
			List<CHSScExceptionINVO> result = new ArrayList<CHSScExceptionINVO>();
						
			String[] locCds = cHSScExceptionINVO.getLocCd().split(",");
			for(int i = 0; i <locCds.length; i++){
				CHSScExceptionINVO temp = new CHSScExceptionINVO();
				cHSScExceptionINVO.setLocCd(locCds[i]);
				list = dbDao.searchVerifySccService(cHSScExceptionINVO);
				
				if(list.size() == 0 || list == null){
					temp.setLocCd((locCds[i]));
					result.add(temp);
				}
			}
			
			return result;
			
		} catch (DAOException ex) {            
			throw new EventException(new ErrorHandler("CGM00001", new String[]{"[SCC Verify] searchVerifySccService"}).getMessage(),ex); 
		} catch (Exception ex) {            
			throw new EventException(new ErrorHandler("CGM00001", new String[]{"[SCC Verify] searchVerifySccService"}).getMessage(),ex); 
		} 	
	}
	
	
	/**
	 * SCNo.정보를 체크합니다. <br>
	 *
	 * @param CHSScExceptionINVO cHSScExceptionINVO
	 * @return List<CHSScExceptionINVO>
	 * @exception EventException
	 */
	@Override
	public List<CHSScExceptionINVO> searchVerifyScNoService(CHSScExceptionINVO cHSScExceptionINVO)
			throws EventException {
		try {    
			List<CHSScExceptionINVO> list = new ArrayList<CHSScExceptionINVO>();
			List<CHSScExceptionINVO> result = new ArrayList<CHSScExceptionINVO>();
						
			String[] scNos = cHSScExceptionINVO.getScNo().split(",");
			for(int i = 0; i <scNos.length; i++){
				CHSScExceptionINVO temp = new CHSScExceptionINVO();
				cHSScExceptionINVO.setScNo(scNos[i]);
				list = dbDao.searchVerifyScNoService(cHSScExceptionINVO);
				
				if(list.size() == 0 || list == null){
					temp.setScNo((scNos[i]));
					result.add(temp);
				}
			}
			
			return result;
			
		} catch (DAOException ex) {            
			throw new EventException(new ErrorHandler("CGM00001", new String[]{"[SCC Verify] searchVerifySccService"}).getMessage(),ex); 
		} catch (Exception ex) {            
			throw new EventException(new ErrorHandler("CGM00001", new String[]{"[SCC Verify] searchVerifySccService"}).getMessage(),ex); 
		} 	
	}
	
	/**
	 * "CGM_LSE_INV_TMP"."CHG_CRE_SEQ"의 MAX Value를 전달.<br>
	 *
	 * @return int
	 * @exception EventException
	 */ 
	public int getMaxSeqAuditResultUpdate() throws EventException {
		try {    
			int maxSeq = 0;
						
			maxSeq = dbDao.getMaxSeqAuditResultUpdate();
			
			return maxSeq;
			
		} catch (DAOException ex) {            
			throw new EventException(new ErrorHandler("CGM20031", new String[]{"Audit Result Update Check"}).getMessage(),ex); 
		} catch (Exception ex) {            
			throw new EventException(new ErrorHandler("CGM20032", new String[]{"Audit Result Update Check"}).getMessage(),ex); 
		}
	}
	
	/**
	 * 데이터를 CGM_LSE_INV_TMP에 insert. <br>
	 *
	 * @param CHSCpsAuditResultUpdateINVO[] cHSCpsAuditResultUpdateINVOS
	 * @param int maxSeq
	 * @param SignOnUserAccount account
	 * @return int insCnt
	 * @exception EventException
	 */ 
	public int insertAuditResultUpdate(CHSCpsAuditResultUpdateINVO[] cHSCpsAuditResultUpdateINVOS, int maxSeq, SignOnUserAccount account) throws EventException {
		try {
			List<CHSCpsAuditResultUpdateINVO> insertVoList = new ArrayList<CHSCpsAuditResultUpdateINVO>();
			int insCnt = 0;
			
			for ( int i=0; i<cHSCpsAuditResultUpdateINVOS.length; i++ ) {
				// insert 대상 List 에 전달된 parma을 담는다
				cHSCpsAuditResultUpdateINVOS[i].setChgCreSeq(Integer.toString(maxSeq));
				cHSCpsAuditResultUpdateINVOS[i].setCreUsrId(account.getUsr_id());
				cHSCpsAuditResultUpdateINVOS[i].setUpdUsrId(account.getUsr_id());
				
				insertVoList.add(cHSCpsAuditResultUpdateINVOS[i]);
			}
			
			insCnt = dbDao.insertAuditResultUpdate(insertVoList);
			
			return insCnt;
			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20031", new String[]{"Audit Result Update Check"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032", new String[]{"Audit Result Update Check"}).getMessage(),ex);
		}
	}
	
	/**
	 * CGM_LSE_INV_TMP에 insert된 데이터를 CGM_LSE_CHG_DTL와 비교 Check한 후 <br>
	 * 데이터 List를 조회 후 전달 <br>
	 *
	 * @param int maxSeq
	 * @param String costYrmon
	 * @param String costYrmonSeq
	 * @param String agmtOfcCtyCd
	 * @param String agmtSeq
	 * @param String agmtVerNo
	 * @return List<CHSCpsAuditResultUpdateMGTVO>
	 * @exception EventException
	 */ 
	public List<CHSCpsAuditResultUpdateMGTVO> checkAuditResultUpdate(int maxSeq, String costYrmon, String costYrmonSeq, String agmtOfcCtyCd, String agmtSeq, String agmtVerNo) throws EventException {
		try{
			List<CHSCpsAuditResultUpdateMGTVO> voList = new ArrayList<CHSCpsAuditResultUpdateMGTVO>();
			
			voList = dbDao.checkAuditResultUpdate(maxSeq, costYrmon, costYrmonSeq, agmtOfcCtyCd, agmtSeq, agmtVerNo);
			
			return voList;
			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			//throw new EventException(new ErrorHandler(ex).getMessage());
			throw new EventException(new ErrorHandler("CGM20031", new String[]{"Audit Result Update [Check]"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032", new String[]{"Audit Result Update [Check]"}).getMessage(),ex);
		}
	}
	
	/**
	 * 데이터를 CGM_LSE_CHG_DTL에 update. <br>
	 *
	 * @param CHSCpsAuditResultUpdateINVO[] cHSCpsAuditResultUpdateINVOS
	 * @param SignOnUserAccount account
	 * @return int insCnt
	 * @exception EventException
	 */ 
	public int updateAuditResultUpdate(CHSCpsAuditResultUpdateINVO[] cHSCpsAuditResultUpdateINVOS, SignOnUserAccount account) throws EventException {
		try {
			List<CHSCpsAuditResultUpdateINVO> updateVoList = new ArrayList<CHSCpsAuditResultUpdateINVO>();
			int updCnt = 0;
			
			for ( int i=0; i<cHSCpsAuditResultUpdateINVOS.length; i++ ) {
				// Update 대상 List 에 저장 
				if(cHSCpsAuditResultUpdateINVOS[i].getDelChk().equals("1")){
					updateVoList.add(cHSCpsAuditResultUpdateINVOS[i]);
				}
			}
			
				updCnt = dbDao.updateAuditResultUpdate(updateVoList, account);
			
			return updCnt;
			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20031", new String[]{"Audit Result Update [Update]"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032", new String[]{"Audit Result Update [Update]"}).getMessage(),ex);
		}
	}
	
	/**
	 * Invoice No 중복 체크 처리한다.(Chassis)[EES_CGM_1204]<br> 
	 * @param CHSInvoiceImportAuditINVO cHSInvoiceImportAuditINVO
	 * @return long invNoCnt
	 * @exception EventException
	 */
	public long checkCHSInvoiceNoDupBasic(CHSInvoiceImportAuditINVO cHSInvoiceImportAuditINVO) throws EventException {
		try {
		
			// CGM_PAY_INV의 "ZP"가 아닌 풀코드에 동일한 Invoice No가 존재하는지 체크하여 Exception 처리
			String invNo = cHSInvoiceImportAuditINVO.getInvNo();			
			long invNoCnt = dbDao.checkCHSInvoiceNoData(invNo, "ZP"); // ZP : COPS Pool

			return invNoCnt;
		
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}
	
	/**
	 * MAS(MAS_DMDT_COST_RPT_BKG_DTL)에서 Pool Estimate Amount 를 조회한다. Calculation (BackEndJob) [EES_CGM_1225]<br>
	 * 
	 * @param poolEstmExpenseINVO PoolEstmExpenseINVO
	 * @param account SignOnUserAccount
	 * @return String
	 * @exception EventException
	 */
	public String searchZPPoolEstimateAmtFromMASBasicBackEndJobStart(PoolEstmExpenseINVO poolEstmExpenseINVO, SignOnUserAccount account) throws EventException {
		ChassisMgsetInvoiceEstmExpnsFrMASBackEndJob command = new ChassisMgsetInvoiceEstmExpnsFrMASBackEndJob();
		// Execute Month(period_eddt)의 전년도 4자리를 가져오기 위한 변수

		command.setPoolEstmExpenseINVO(poolEstmExpenseINVO);
		command.setAccount(account);
		BackEndJobManager backEndJobManager = new BackEndJobManager();
		
		try {
			String key = backEndJobManager.execute(command, account.getUsr_id() ,"CGM COPS Estimate Expense");
			
			return key;
			
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
		
	}
	
	/**
	 * 저장된 Pool Estimate Amount(ZP) 를 조회한다. Retrieve .  [EES_CGM_1225]<br>
	 * 
	 * @param poolEstmExpenseINVO PoolEstmExpenseINVO 
	 * @return List<PoolEstmExpenseMGTVO>
	 * @exception EventException
	 */
	public List<PoolEstmExpenseMGTVO> searchZPPoolEstimateAmtBasic(PoolEstmExpenseINVO poolEstmExpenseINVO)  throws EventException {
		try {

			return dbDao.searchZPPoolEstimateAmtData(poolEstmExpenseINVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}
	
	/**
	 * CGM_CHSS_POOL_EXPN_ESTM 엔티티에 저장 . Save .  [EES_CGM_1225]<br>
	 * 
	 * @param poolEstmExpenseMGTVOs PoolEstmExpenseMGTVO[] 
     * @param account SignOnUserAccount 
	 * @exception EventException
	 */
	public void modifyZPPoolEstimateAmtBasic (PoolEstmExpenseMGTVO[] poolEstmExpenseMGTVOs, SignOnUserAccount account) throws EventException  {
		
		List<PoolEstmExpenseMGTVO> updateVoList = new ArrayList<PoolEstmExpenseMGTVO>();
		List<PoolEstmExpenseMGTVO> indateVoList = new ArrayList<PoolEstmExpenseMGTVO>();
		
		try {
			log.debug("poolEstmExpenseMGTVOs.length============="+poolEstmExpenseMGTVOs.length);
			for ( int i=0; i<poolEstmExpenseMGTVOs.length; i++ ) {
				poolEstmExpenseMGTVOs[i].setCreUsrId(account.getUsr_id());
				poolEstmExpenseMGTVOs[i].setUpdUsrId(account.getUsr_id());
				
				// CGM_CHSS_POOL_EXPN_ESTM에 데이터 유무를 체크하여 insertVo와 updateVo로 분기생성한다.
				if(dbDao.checkPoolEstimateAmtData(poolEstmExpenseMGTVOs[i]) == 0) {
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
	
}