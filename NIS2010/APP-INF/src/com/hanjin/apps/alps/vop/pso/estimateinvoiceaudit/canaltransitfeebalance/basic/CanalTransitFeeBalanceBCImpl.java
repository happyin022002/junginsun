/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CanalTransitFeeBalanceBCImpl.java
*@FileTitle : Requested MSA
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.20
*@LastModifier : 김진일
*@LastVersion : 1.0
* 2009.05.20 김진일
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeebalance.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeebalance.integration.CanalTransitFeeBalanceDBDAO;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeebalance.vo.BalDiffAcctDtlVO;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeebalance.vo.BalDiffAcctMstVO;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeebalance.vo.BalDiffAcctVO;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeebalance.vo.CanalTzFeeBalDtlVO;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeebalance.vo.CanalTzFeeBalVO;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeebalance.vo.GlIfDataThisMonVO;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeebalance.vo.GlIfDataTtlVO;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeebalance.vo.GlIfGRPVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PsoMsaVO;

/**
 * ALPS-EstimateInvoiceAudit Business Logic Basic Command implementation<br>
 * - ALPS-EstimateInvoiceAudit에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Kim Jin Ihl
 * @see VOP_PSO-0020EventResponse,CanalTransitFeeBalanceBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class CanalTransitFeeBalanceBCImpl extends BasicCommandSupport implements CanalTransitFeeBalanceBC {

	// Database Access Object
	private transient CanalTransitFeeBalanceDBDAO dbDao = null;

	/**
	 * CanalTransitFeeBalanceBCImpl 객체 생성<br>
	 * CanalTransitFeeBalanceDBDAO를 생성한다.<br>
	 */
	public CanalTransitFeeBalanceBCImpl() {
		dbDao = new CanalTransitFeeBalanceDBDAO();
	}
	/**
	 * VOP_PSO_0020 : WindowsOpen<br>
	 *  Requested MSA 의 Statement of Balance 탭 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param canalTzFeeBalVO CanalTzFeeBalVO
	 * @return List<CanalTzFeeBalVO>
	 * @exception EventException
	 */
	public List<CanalTzFeeBalVO> searchCanalTzFeeBalSum(CanalTzFeeBalVO canalTzFeeBalVO) throws EventException {
		// TODO Auto-generated method stub
		try {
			return dbDao.searchCanalTzFeeBalSum(canalTzFeeBalVO); 
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Requested MSA"}).getUserMessage(),ex);
		} 
		catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Requested MSA"}).getUserMessage(),ex);
		}
	}
		
	/**
	 * VOP_PSO-0020-1 : Confirm Button Click<br/>
	 * 요청된 MSA에 대한 Confirm 처리를 시행한다.<br/>
	 * @param canalTzFeeBalVOs CanalTzFeeBalVO[] 
	 * @param account SignOnUserAccount 
	 * @exception EventException
	 */
	@Override
	public void createCanalTzFeeBal(CanalTzFeeBalVO[] canalTzFeeBalVOs,
			SignOnUserAccount account) throws EventException {
		// TODO Auto-generated method stub
		try {
			List<CanalTzFeeBalVO> insertVoList = new ArrayList<CanalTzFeeBalVO>();
			List<CanalTzFeeBalVO> updateVoList = new ArrayList<CanalTzFeeBalVO>();
			//List<CanalTzFeeBalVO> deleteVoList = new ArrayList<CanalTzFeeBalVO>();
			for ( int i=0; i<canalTzFeeBalVOs .length; i++ ) {
				if ( canalTzFeeBalVOs[i].getIbflag().equals("U")){
						canalTzFeeBalVOs[i].setUpdUsrId(account.getUsr_id());
						canalTzFeeBalVOs[i].setPsoMsaStsCd("A");//Approved 로 표시 
						canalTzFeeBalVOs[i].setPsoMsaAmtTpCd("A");//Working Month의 Beginning Bal로 설정 
						insertVoList.add(canalTzFeeBalVOs[i]);
						updateVoList.add(canalTzFeeBalVOs[i]);
				} 
			}

			//2009.08.14. 요청의해 막음 
//			if ( insertVoList.size() > 0 ) {
//				dbDao.addPsoMsaDtl(insertVoList);
//			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyPsoMsa(updateVoList);
			}
//			if ( deleteVoList.size() > 0 ) {
//				//dbDao.removePsoMsaDtlVOS(deleteVoList);
//			}
		} 
		catch (DAOException ex){
			throw new EventException(new ErrorHandler("PSO90011", new String[]{"Requested MSA"}).getUserMessage(),ex);
		} 
		catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90011", new String[]{"Requested MSA"}).getUserMessage(),ex);
		}
	}
	/**
	 * VOP_PSO-0020-1 Reject Button Click<br>
	 * 요청된 MSA의 취최 처리를 한다.<br>
	 * @param canalTzFeeBalVOs CanalTzFeeBalVO[] 
	 * @param account SignOnUserAccount 
	 * @exception EventException
	 */
	@Override
	public void removeCanalTzFeeBal(CanalTzFeeBalVO[] canalTzFeeBalVOs,
			SignOnUserAccount account) throws EventException {
		// TODO Auto-generated method stub
		try {
			List<CanalTzFeeBalVO> updateVoList = new ArrayList<CanalTzFeeBalVO>();
			List<CanalTzFeeBalVO> deleteVoList = new ArrayList<CanalTzFeeBalVO>();
			for ( int i=0; i<canalTzFeeBalVOs .length; i++ ) {
				if ( canalTzFeeBalVOs[i].getIbflag().equals("U")){
						canalTzFeeBalVOs[i].setUpdUsrId(account.getUsr_id());
						canalTzFeeBalVOs[i].setPsoMsaStsCd("R");//Ready 로 표시 
						//canalTzFeeBalVOs[i].setPsoMsaAmtTpCd("A");//Working Month의 Beginning Bal로 설정 
						deleteVoList.add(canalTzFeeBalVOs[i]);
						updateVoList.add(canalTzFeeBalVOs[i]);
				} 
			}
			//요청에 의해 막음 
//			if ( deleteVoList.size() > 0 ) {
//				dbDao.removePsoMsaDtl(deleteVoList);
//			}
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyPsoMsa(updateVoList);
			}
		} 
		catch (DAOException ex){
			throw new EventException(new ErrorHandler("PSO90011", new String[]{"Requested MSA"}).getUserMessage(),ex);
		} 
		catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90011", new String[]{"Requested MSA"}).getUserMessage(),ex);
		}
		
	}
	/**
	 * VOP_PSO-0020-2 Details of Remittance Tab Click <br />
	 * Requested MSA의 Remittance 정보를 조회한다.  <br />
	 * @param balDiffAcctVO CanalTzFeeBalDtlVO
	 * @return List<CanalTzFeeBalDtlVO>
	 * @exception EventException
	 */
	@Override
	public List<CanalTzFeeBalDtlVO> searchCanalTzFeeBalDtl(CanalTzFeeBalDtlVO balDiffAcctVO) throws EventException {
		// TODO Auto-generated method stub
		try {
			return dbDao.searchCanalTzFeeBalDtl(balDiffAcctVO); 
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Requested MSA"}).getUserMessage(),ex);
		} 
		catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Requested MSA"}).getUserMessage(),ex);
		}
	}
	
	/**
	 * VOP_PSO-0031 G/L Data 조회 
	 * @param PsoMsaVO psoMsaVO
	 * @return GlIfGRPVO
	 * @exception EventException
	 */
	public GlIfGRPVO searchGlifDateByMon(PsoMsaVO psoMsaVO) throws EventException {
		try {
			GlIfGRPVO glIfGRPVO = new GlIfGRPVO();
			
			List<GlIfDataThisMonVO> list1 = dbDao.searchGlifDateByMon(psoMsaVO);
			List<GlIfDataTtlVO> 	list2 = dbDao.searchGlifDateByMonSum(psoMsaVO);
			
			glIfGRPVO.setGlIfDataThisMonVOlist(list1);
			glIfGRPVO.setGlIfDataTtlVOlist(list2);
			
			return glIfGRPVO;
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"G/L Data"}).getUserMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"G/L Data"}).getUserMessage(),ex);
		}
	}
	
	/**
	 *  
	 * VOP_PSO-0032 Balance Diff. Account 
	 * 
	 * @param  BalDiffAcctVO balDiffAcctVO
	 * @return BalDiffAcctVO
	 * @exception EventException
	 */
	public BalDiffAcctVO searchBalDiffAcct(BalDiffAcctVO balDiffAcctVO) throws EventException {
		try {
			BalDiffAcctVO returnVO = new BalDiffAcctVO();
			
			List<BalDiffAcctMstVO> list1 = dbDao.searchBalDiffAcct(balDiffAcctVO);
			List<BalDiffAcctDtlVO> 	list2 = dbDao.searchBalDiffAcctDtl(balDiffAcctVO);
			
			returnVO.setBalDiffAcctMstVOlist(list1);
			returnVO.setBalDiffAcctDtlVOlist(list2);
			
			return returnVO;
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Balnace Diff. Account"}).getUserMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Balnace Diff. Account"}).getUserMessage(),ex);
		}
	}
	
	
}