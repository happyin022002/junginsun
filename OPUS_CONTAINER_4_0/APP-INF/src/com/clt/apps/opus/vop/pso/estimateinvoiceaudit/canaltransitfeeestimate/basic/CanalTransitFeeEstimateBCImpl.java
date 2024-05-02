/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CanalTransitFeeEstimateBCImpl.java
 *@FileTitle : CanalTransitFeeEstimateBCImpl
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2010.10.04
 *@LastModifier : 유혁
 *@LastVersion : 1.0
 * 2009.06.08 박명종
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.estimateinvoiceaudit.canaltransitfeeestimate.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.vop.pso.estimateinvoiceaudit.canaltransitfeeestimate.integration.CanalTransitFeeEstimateDBDAO;
import com.clt.apps.opus.vop.pso.estimateinvoiceaudit.canaltransitfeeestimate.vo.AuditDataValidVO;
import com.clt.apps.opus.vop.pso.estimateinvoiceaudit.canaltransitfeeestimate.vo.CanalTzFeeEstDtlByVvdCondVO;
import com.clt.apps.opus.vop.pso.estimateinvoiceaudit.canaltransitfeeestimate.vo.CanalTzFeeEstDtlByVvdVO;
import com.clt.apps.opus.vop.pso.estimateinvoiceaudit.canaltransitfeeestimate.vo.CanalTzFeeHdVO;
import com.clt.apps.opus.vop.pso.estimateinvoiceaudit.canaltransitfeeestimate.vo.CanalTzFeeSumVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;

/**
 * ALPS-EstimateInvoiceAudit Business Logic Basic Command implementation<br>
 *
 * @author 
 * @see Reference each DAO class of VOP_PSO-0018EventResponse,CanalTransitFeeEstimateBC 
 * @since J2EE 1.6
 */
public class CanalTransitFeeEstimateBCImpl extends BasicCommandSupport implements CanalTransitFeeEstimateBC {

	// Database Access Object
	private transient CanalTransitFeeEstimateDBDAO dbDao = null;

	/**
	 * Creating object CanalTransitFeeEstimateBCImpl <br>
	 * Creating CanalTransitFeeEstimateDBDAO <br>
	 */
	public CanalTransitFeeEstimateBCImpl() {
		dbDao = new CanalTransitFeeEstimateDBDAO();
	}
	
	/**
	 * Requested Advanced Payment Confirm@CLICK
	 * get InvoiceNo calculated 
	 * @category VOP_PSO_0018_Confirm_CLICK
	 * @param CanalTzFeeHdVO canalTzFeeHdVO
	 * @return String
	 * @throws EventException
	 */
	@Override
	public String createCanalTzFeeEst(CanalTzFeeHdVO canalTzFeeHdVO)
			throws EventException {
		// TODO Auto-generated method stub
		try {
			return dbDao.searchInvoiceSeq(canalTzFeeHdVO); 
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Requested Advanced Payment"}).getUserMessage(),ex);
		} 
		catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Requested Advanced Payment"}).getUserMessage(),ex);
		}
	}
	
	/**
	 * retrieve Estimate Canal Transit Fee by VVD 
	 * @category VOP_PSO_0018_windows_open
	 * @param CanalTzFeeEstDtlByVvdCondVO canalTzFeeEstDtlByVvdCondVO
	 * @return List<CanalTzFeeEstDtlByVvdVO>
	 */
	public List<CanalTzFeeEstDtlByVvdVO> searchCanalTzFeeEstDtlByVvd(
			CanalTzFeeEstDtlByVvdCondVO canalTzFeeEstDtlByVvdCondVO) throws EventException {
		// TODO Auto-generated method stub
		try {
			List<CanalTzFeeEstDtlByVvdVO> canalTzFeeEstDtlByVvdVOs = dbDao.searchCanalTzFeeEstDtlByVvd(canalTzFeeEstDtlByVvdCondVO);
			for(CanalTzFeeEstDtlByVvdVO canalTzFeeEstDtlByVvdVO : canalTzFeeEstDtlByVvdVOs){
				canalTzFeeEstDtlByVvdVO.setDueDt(dbDao.getTempDueDate(canalTzFeeEstDtlByVvdVO));
				canalTzFeeEstDtlByVvdVO.setDueDt(dbDao.getDueDate(canalTzFeeEstDtlByVvdVO));
			}
			return canalTzFeeEstDtlByVvdVOs;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Requested Advanced Payment"}).getUserMessage(),ex);
		} 
		catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Requested Advanced Payment"}).getUserMessage(),ex);
		}
	}
	/**
	 * Retrieve Canal Invoice  
	 * @category VOP_PSO-0017 Retrieve
	 * @see com.clt.apps.opus.vop.pso.estimateinvoiceaudit.canaltransitfeebalance.basic.CanalTransitFeeBalanceBC#searchCanalTzFeeSumRpt(com.clt.apps.opus.vop.pso.estimateinvoiceaudit.canaltransitfeebalance.vo.CanalTzFeeSumVO)
	 * @param CanalTzFeeSumVO canalTzFeeSumVO
	 * @return List<CanalTzFeeSumVO>
	 */
	@Override
	public List<CanalTzFeeSumVO> searchCanalTzFeeSumRpt(
			CanalTzFeeSumVO canalTzFeeSumVO) throws EventException {
		// TODO Auto-generated method stub
		try {
			return dbDao.searchCanalTzFeeSumRpt(canalTzFeeSumVO); 
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Canal Invoice"}).getUserMessage(),ex);
		} 
		catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Canal Invoice"}).getUserMessage(),ex);
		}
	}

	/**
	 * cancel Requested Advance Payment 
	 * @category VOP_PSO_0018_reject_button_click
	 * @param CanalTzFeeEstDtlByVvdCondVO canalTzFeeEstDtlByVvdCondVO
	 */
	public void cancelCanalTzFeeEst(
			CanalTzFeeEstDtlByVvdCondVO canalTzFeeEstDtlByVvdCondVO) throws EventException{
		try {
			//1.delete PSO_CNL_TZ_FEE_DTL table
			
//			dbDao.removePsoCnlTzFeeDtl (canalTzFeeEstDtlByVvdCondVO);
//			dbDao.modifyCanalTzFeeDtl(auditDataValidVOs);
			//2.delete PSO_CNL_TZ_FEE table
//			dbDao.removePsoCnlTzFee (canalTzFeeEstDtlByVvdCondVO);
			//<<<--------------
			//
 
			
			//3.PsoTargetVvdUPdate.
//			dbDao.modifyPsoTargetVvd (canalTzFeeEstDtlByVvdCondVO);
			
			
			
		
			// change status info of PSO_CNL_TZ_FEE to UPDATE 
			dbDao.modifyPsoCnlTzFee (canalTzFeeEstDtlByVvdCondVO);

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90011", new String[]{"Requested Advance Payment"}).getUserMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90011", new String[]{"Requested Advance Payment"}).getUserMessage(),ex);
		}		
	}

	/**
	 * Renew CanalTzFee and CanalTzFeeDtl info
	 * used in VOP_PSO_0018,0019 Confirm 
	 * @category VOP_PSO_0018_0019_ConfirmClick
	 * @param AuditDataValidVO[] auditDataValidVOs
	 * @throws EventException
	 */
	public void manageCanalTzFee(AuditDataValidVO[] auditDataValidVOs)
			throws EventException {
		List<AuditDataValidVO> updateVoList = new ArrayList<AuditDataValidVO>();
		List<AuditDataValidVO> updateVoList2 = new ArrayList<AuditDataValidVO>();
		String strTyp = "";
		//>>>>>>>>>>>>>>>>>>>
		
		//log.debug("\n>>>>>>>>>YYY : " + auditDataValidVOs[0].getVvd() + " : " + auditDataValidVOs[0].getYdCd());
		for ( int i=0; i<auditDataValidVOs.length; i++ ) {
			updateVoList.add(auditDataValidVOs[i]);
			strTyp = auditDataValidVOs[i].getCnlTzBztpCd();
			
			//log.debug("\n>>>>>>>>>ZZZ : " + auditDataValidVOs[i].getVvd() + " : " + auditDataValidVOs[i].getYdCd());
			if(!"".equals(auditDataValidVOs[i].getYdCd())){
				log.debug("\n>>>>>>>>>XXX : " + auditDataValidVOs[i].getVvd() + " : " + auditDataValidVOs[i].getYdCd());
				updateVoList2.add(auditDataValidVOs[i]);			
			}
		}
	
		
		
		try {
			
			//Step1. UPDATE PSO_CNL_TZ_FEE_DTL items .
			dbDao.modifyCanalTzFeeDtl(updateVoList);
		
			
			//Step4.Update Status code of PSO_CNL_TZ_FEE to A(Approved)
			dbDao.modifyPsoCnlTzFeeStsCd(updateVoList2);
		
		} catch (DAOException ex) {
			if(strTyp.equals("E"))
				throw new EventException(new ErrorHandler("PSO90011", new String[]{"Requested Advance Payment"}).getUserMessage(),ex);
			else
				throw new EventException(new ErrorHandler("PSO90011", new String[]{"Requested Actual Invoice"}).getUserMessage(),ex);
		} catch (Exception ex) {
			if(strTyp.equals("E"))
				throw new EventException(new ErrorHandler("PSO90011", new String[]{"Requested Advance Payment"}).getUserMessage(),ex);
			else
				throw new EventException(new ErrorHandler("PSO90011", new String[]{"Requested Actual Invoice"}).getUserMessage(),ex);
		}		
		
	}

	/**
	 * renew remark info of CanalTzFeeDtl
	 * used in VOP_PSO_0018,0019 Reject 
	 * @category VOP_PSO_0018_0019_ConfirmClick
	 * @param AuditDataValidVO[] auditDataValidVOs
	 * @throws EventException
	 */
	public void modifyRemark(AuditDataValidVO[] auditDataValidVOs)
			throws EventException {
		List<AuditDataValidVO> updateVoList = new ArrayList<AuditDataValidVO>();
		String strTyp = "";

		if(auditDataValidVOs!=null){
			for ( int i=0; i<auditDataValidVOs.length; i++ ) {
				updateVoList.add(auditDataValidVOs[i]);
				strTyp = auditDataValidVOs[i].getCnlTzBztpCd();
			}
		}
		else{
			return;
		}
		try {
			dbDao.modifyRemark(updateVoList);
		} catch (DAOException ex) {
			if(strTyp.equals("E"))
				throw new EventException(new ErrorHandler("PSO90011", new String[]{"Requested Advance Payment"}).getUserMessage(),ex);
			else
				throw new EventException(new ErrorHandler("PSO90011", new String[]{"Requested Actual Invoice"}).getUserMessage(),ex);
		} catch (Exception ex) {
			if(strTyp.equals("E"))
				throw new EventException(new ErrorHandler("PSO90011", new String[]{"Requested Advance Payment"}).getUserMessage(),ex);
			else
				throw new EventException(new ErrorHandler("PSO90011", new String[]{"Requested Actual Invoice"}).getUserMessage(),ex);
		}		
	}

}