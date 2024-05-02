/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CalculateBCImpl.java
 *@FileTitle : Rate Proposal
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2010.03.24
 *@LastModifier : 송민석
 *@LastVersion : 1.0
 * 2010.03.24  송민석
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.profitabilitysimulation.calculate.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.calculate.integration.CalculateDBDAO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.calculate.vo.RsltPriPrsRoutActCostSimulationVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.calculate.vo.RsltPriPrsRoutCsMaxRoutCsNoVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.calculate.vo.RsltPriPrsRoutEstmCostSimulationVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.calculate.vo.RsltPriPrsUsdRoutCsInfoSimulationVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.vo.InPriPrsRoutCsVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * NIS2010-SCGuideline Business Logic Basic Command implementation<br>
 * - NIS2010-SCGuideline에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author Sungsoo, Park
 * @see UI_PRI_0030EventResponse,SCRateProposalBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */

public class CalculateBCImpl extends BasicCommandSupport implements CalculateBC {

	// Database Access Object
	private transient CalculateDBDAO dbDao = null;

	/**
	 * SCRateProposalBCImpl 객체 생성<br>
	 * SCRateProposalDBDAO를 생성한다.<br>
	 */
	public CalculateBCImpl() {
		dbDao = new CalculateDBDAO();
	}
 
	
	/**
	 * Route Case 내용을 Used 로 카피한다.. .<br>
	 * 
	 * @param InPriPrsRoutCsVO inPriPrsRoutCsVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void copyCoaCostInfoToOnlineCostInfo(InPriPrsRoutCsVO inPriPrsRoutCsVO,SignOnUserAccount account) throws EventException{	
		try {
			if( inPriPrsRoutCsVO != null ){
				inPriPrsRoutCsVO.setUpdUsrId(account.getUsr_id());
			}
			int cnt = dbDao.addPriPrsUsdRoutCsInfoSimulation(inPriPrsRoutCsVO);
			if( cnt != 0 ){
				dbDao.addPriPrsUsdRoutActCostSimulation(inPriPrsRoutCsVO);
				dbDao.addPriPrsUsdRoutEstmCostSimulation(inPriPrsRoutCsVO);
			}else{
				//Exception 발생?
			}
			
			
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
	} 
	
	/**
	 * Route Case 내용을 Used 로 카피한다.. .<br>
	 * 
	 * @param InPriPrsRoutCsVO inPriPrsRoutCsVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void copyOnlineCostInfoToBatchCostInfo(InPriPrsRoutCsVO inPriPrsRoutCsVO,SignOnUserAccount account) throws EventException{	
		try {
			if( inPriPrsRoutCsVO != null ){
				inPriPrsRoutCsVO.setUpdUsrId(account.getUsr_id());
			}
			
			List<RsltPriPrsUsdRoutCsInfoSimulationVO> infoList = dbDao.searchPriPrsUsdRoutCsInfoSimulationList(inPriPrsRoutCsVO);
			if( infoList != null && infoList.size() > 0 ){
				dbDao.addPriPrsRoutCsInfoSimulation(infoList);
				List<RsltPriPrsRoutActCostSimulationVO> actCostList = dbDao.searchPriPrsRoutActCostSimulationList(inPriPrsRoutCsVO);
			 	dbDao.addPriPrsRoutActCostSimulation(actCostList);
			 	List<RsltPriPrsRoutEstmCostSimulationVO> estmCostList = dbDao.searchPriPrsRoutEstmCostSimulationList(inPriPrsRoutCsVO);
				dbDao.addPriPrsRoutEstmCostSimulation(estmCostList);
			 
			}
			
			
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
	} 	
	
	
	/**
	 * BATCH DB에 Route Case를 추가 한다. .<br>
	 * 
	 * @param InPriPrsRoutCsVO inPriPrsRoutCsVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void managePriPrsRouteCase(InPriPrsRoutCsVO inPriPrsRoutCsVO, SignOnUserAccount account) throws EventException{	
		try {
			List<InPriPrsRoutCsVO> inPriPrsRoutCsVOs = new ArrayList<InPriPrsRoutCsVO>();
			if (inPriPrsRoutCsVO != null) {
				inPriPrsRoutCsVO.setUpdUsrId(account.getUsr_id());
				inPriPrsRoutCsVOs.add(inPriPrsRoutCsVO);
			}
			dbDao.addPriPrsRouteCase(inPriPrsRoutCsVOs);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
	}
	
	
	
	
	
	
	
	/**
	 *  
	 * ROUT_CS_NO를 sequence에서 조회 해 온다.
	 *  
	 * @param InPriPrsRoutCsVO inPriPrsRoutCsVO
	 * @return RsltPriPrsRoutCsMaxRoutCsNoVO
	 * @exception EventException
	 */
	public  RsltPriPrsRoutCsMaxRoutCsNoVO searchPriPrsRoutCsMaxRoutCsNoCalculate(InPriPrsRoutCsVO inPriPrsRoutCsVO) throws EventException {
		try {
			return dbDao.searchPriPrsRoutCsMaxRoutCsNoCalculate(inPriPrsRoutCsVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}		
	
	
	
	
	
		
}