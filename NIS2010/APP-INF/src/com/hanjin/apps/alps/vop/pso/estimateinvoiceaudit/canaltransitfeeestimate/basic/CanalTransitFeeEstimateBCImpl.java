/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CanalTransitFeeEstimateBCImpl.java
*@FileTitle : Requested Advance Payment
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.09
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2009.06.15 김진일
* 1.0 Creation
* 
* History
* 2012.02.01 진마리아 CHM-201215859-01 전도금 비용 수정 기능 추가 요청건(spp로부터 입력받는 전도금을 alps 화면을 통해 수정하여 저장 가능하도록)
* 2012.03.09 진마리아 CHM-201216307-01 Canal invoice 화면 변경 및 File download 기능 개발
* 2012.04.09 진마리아 CHM-201217036-01 SPP-Port SO/ Actual Invoice 화면 변경 및 기능, 로직 추가 - file download는 전도금이 아닌 invoice 화면으로 수정
=========================================================*/
package com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeeestimate.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeeestimate.integration.CanalTransitFeeEstimateDBDAO;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeeestimate.vo.AuditDataValidVO;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeeestimate.vo.AuditDataValidOwnerAccountVO;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeeestimate.vo.CanalTzFeeEstDtlByVvdCondVO;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeeestimate.vo.CanalTzFeeEstDtlByVvdVO;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeeestimate.vo.CanalTzFeeHdVO;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeeestimate.vo.CanalTzFeeSumVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

/**
 * ALPS-EstimateInvoiceAudit Business Logic Basic Command implementation<br>
 * - ALPS-EstimateInvoiceAudit에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Kim Jin Ihl
 * @see VOP_PSO-0018EventResponse,CanalTransitFeeEstimateBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class CanalTransitFeeEstimateBCImpl extends BasicCommandSupport implements CanalTransitFeeEstimateBC {

	// Database Access Object
	private transient CanalTransitFeeEstimateDBDAO dbDao = null;

	/**
	 * CanalTransitFeeEstimateBCImpl 객체 생성<br>
	 * CanalTransitFeeEstimateDBDAO를 생성한다.<br>
	 */
	public CanalTransitFeeEstimateBCImpl() {
		dbDao = new CanalTransitFeeEstimateDBDAO();
	}
	 
	/**
	 * Requested Advanced Payment Confirm@CLICK
	 * InvoiceNo를 계산하여 가져온다. 
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
	 * VVD별로 Estimate Canal Transit Fee를 조회한다.
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
	 * Canal Invoice 조회 
	 * @category VOP_PSO-0017 Retrieve
	 * @see com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeebalance.basic.CanalTransitFeeBalanceBC#searchCanalTzFeeSumRpt(com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeebalance.vo.CanalTzFeeSumVO)
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
	 * Requested Advance Payment 취소처리
	 * @category VOP_PSO_0018_reject_button_click
	 * @param CanalTzFeeEstDtlByVvdCondVO canalTzFeeEstDtlByVvdCondVO
	 */
	public void cancelCanalTzFeeEst(
			CanalTzFeeEstDtlByVvdCondVO canalTzFeeEstDtlByVvdCondVO) throws EventException{
		try {
			//1.PSO_CNL_TZ_FEE_DTL테이블 삭제
			//--> 2009.07.28. FROM CHOI Request로 Comment Out 함.. [START] >>>>
//			dbDao.removePsoCnlTzFeeDtl (canalTzFeeEstDtlByVvdCondVO);
//			dbDao.modifyCanalTzFeeDtl(auditDataValidVOs);
			//2.PSO_CNL_TZ_FEE 테이블 삭제
//			dbDao.removePsoCnlTzFee (canalTzFeeEstDtlByVvdCondVO);
			//<<<--------------
			//
//			Tariff Engine에 의해 계산되어 채워 넣었던 정보를 delete해 주어야 된다. 
			
			//3.PsoTargetVvdUPdate.
//			dbDao.modifyPsoTargetVvd (canalTzFeeEstDtlByVvdCondVO);
			
			//<<<<<<<<<<--- 여기까진 OLD버전.. 
			
			//TODO: 임플리먼트가 향후 필요한 부분 
			//1. AP_ 재무팀의 charge,chg_dtl에 해당하는 테이블의 데이터가 처리가 된경우 
			// PSO_CHARGE, PSO_CHG_DTL테이블의 데이터는 삭제하지 않음.. 
			// 처리가 안된경우는.. 삭제  --> 판단기준은 PSO_CHARGE.INV_RGST_NO 가 존재 하느냐 않하느냐가 기준.. 
			// 존재하면 Message처리 필요.
			// 존재하지 않으면 삭제.

			// PSO_CNL_TZ_FEE의 상태정보를 UPDATE하도록 변경 
			dbDao.modifyPsoCnlTzFee (canalTzFeeEstDtlByVvdCondVO);

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90011", new String[]{"Requested Advance Payment"}).getUserMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90011", new String[]{"Requested Advance Payment"}).getUserMessage(),ex);
		}		
	}

	/**
	 * CanalTzFee 및 CanalTzFeeDtl의 정보를 갱신한다.
	 * VOP_PSO_0018,0019 Confirm 처리에서 사용
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
				updateVoList2.add(auditDataValidVOs[i]);//StatusUpdate를 위한 0번째 열 대입				
			}
		}
		//<<<<<<<<<<<<<<< OUT 대상 
		
		
		try {
			//>>>>>>>>>>>>>>>>>>>>>>>>>>
			//Step1.PSO_CNL_TZ_FEE_DTL의 항목을 UPDATE한다.
			dbDao.modifyCanalTzFeeDtl(updateVoList);
			//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< OUT ...
			
			//Step4.PSO_CNL_TZ_FEE의 Status코드를 A(Approved)로 UPdate한다.
			dbDao.modifyPsoCnlTzFeeStsCd(updateVoList2);
			//----------->>>>>> 이넘만 밖으로 빼면 됨.. 
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
	 * CanalTzFee 및 CanalTzFeeDtl의 정보를 갱신한다.(OA비용만)
	 * VOP_PSO_0019 Confirm 처리에서 사용
	 * @category VOP_PSO_0019_ConfirmClick
	 * @param AuditDataValidOwnerAccountVO[] auditDataValidOwnerAccounts
	 * @throws EventException
	 */
	public void manageCanalTzFeeOwnerAccount(AuditDataValidOwnerAccountVO[] auditDataValidOwnerAccounts)
			throws EventException {
		List<AuditDataValidOwnerAccountVO> updateVoList = new ArrayList<AuditDataValidOwnerAccountVO>();
		String strTyp = "";
	
		for ( int i=0; i<auditDataValidOwnerAccounts.length; i++ ) {
			updateVoList.add(auditDataValidOwnerAccounts[i]);
			strTyp = auditDataValidOwnerAccounts[i].getCnlTzBztpCd();
			}
		
		try {
			//>>>>>>>>>>>>>>>>>>>>>>>>>>
			//Step1.PSO_CNL_TZ_FEE_DTL의 항목을 UPDATE한다.
			dbDao.modifyCanalTzFeeDtlOwnerAccount(updateVoList);
			//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< OUT ...
			
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
	 * CanalTzFeeDtl의 Remark 정보를 갱신한다.
	 * VOP_PSO_0018,0019 Reject 처리에서 사용
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
			return;//처리할 데이터가 없음
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

	/**
	 * CanalTzFeeDtl의 Remark 정보를 갱신한다.
	 * VOP_PSO_0019 Reject 처리에서 사용
	 * @category VOP_PSO_0019_RejectClick
	 * @param AuditDataValidOwnerAccountVO[] auditDataValidOwnerAccountVOs
	 * @throws EventException
	 */
	public void modifyRemarkOwnerAccount(AuditDataValidOwnerAccountVO[] auditDataValidOwnerAccountVOs)
			throws EventException {
		List<AuditDataValidOwnerAccountVO> updateVoList = new ArrayList<AuditDataValidOwnerAccountVO>();
		String strTyp = "";

		if(auditDataValidOwnerAccountVOs!=null){
			for ( int i=0; i<auditDataValidOwnerAccountVOs.length; i++ ) {
				updateVoList.add(auditDataValidOwnerAccountVOs[i]);
				strTyp = auditDataValidOwnerAccountVOs[i].getCnlTzBztpCd();
			}
		}
		else{
			return;//처리할 데이터가 없음
		}
		try {
			dbDao.modifyRemarkOwnerAccount(updateVoList);
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
	 * CanalTzFeeDtl의 Rqst Amt, Rmk 정보를 갱신한다.
	 * @category VOP_PSO_0018_SaveClick
	 * @param AuditDataValidVO[] auditDataValidVOs
	 * @throws EventException
	 */
	public void manageCanalTzFeeRqstAmt(AuditDataValidVO[] auditDataValidVOs) throws EventException {
		try {
			
			List<AuditDataValidVO> updateVoList = new ArrayList<AuditDataValidVO>();
			for(int i=0; i<auditDataValidVOs.length; i++){
//				Remark만 수정한 경우도 저장하기 위하여, 모든 데이터를 update한다.
//				if(!auditDataValidVOs[i].getOrgRqstAmt().equals(auditDataValidVOs[i].getRqstAmt())){
					updateVoList.add(auditDataValidVOs[i]);
//				}
			}
			dbDao.modifyCanalTzFeeRqstAmt(updateVoList);

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90011", new String[]{"Requested Advance Payment Save"}).getUserMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90011", new String[]{"Requested Advance Payment Save"}).getUserMessage(),ex);
		}		
		
	}
}