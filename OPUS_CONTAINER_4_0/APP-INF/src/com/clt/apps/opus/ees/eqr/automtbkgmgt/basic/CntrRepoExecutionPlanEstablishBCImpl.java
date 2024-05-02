/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CntrRepoExecutionPlanEstablishBCImpl.java
*@FileTitle : Execution Plan
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.eqr.automtbkgmgt.basic;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.bcm.sup.valuemanage.util.OfficeCodeMgr;
import com.clt.apps.opus.ees.eqr.common.Constants;
import com.clt.apps.opus.ees.eqr.common.Utils;
import com.clt.apps.opus.ees.eqr.common.eqrcommon.integration.CommonDBDAO;
import com.clt.apps.opus.ees.eqr.common.eqrcommon.vo.CommonVO;
import com.clt.apps.opus.ees.eqr.common.eqrcommon.vo.EesCommonConditionVO;
import com.clt.apps.opus.ees.eqr.common.eqrcommon.vo.EesCommonVO;
import com.clt.apps.opus.ees.eqr.common.vo.CommonRsVO;

import com.clt.apps.opus.ees.eqr.automtbkgmgt.vo.AutoMtBkgVO;
import com.clt.apps.opus.ees.eqr.automtbkgmgt.integration.AutoMtBkgMgtDBDAO;

import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.integration.CntrRepoExecutionPlanEstablishDBDAO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.integration.CntrRepoExecutionPlanEstablishEAIDAO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.CheckBkgVolumeTargetVO;
import com.clt.apps.opus.ees.eqr.automtbkgmgt.vo.EesEqr0059ConditionVO;
import com.clt.apps.opus.ees.eqr.automtbkgmgt.vo.EesEqr0059MultiVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.EesEqr0080MultiVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.EesEqr0081MultiVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.EesEqr0083MultiVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.EesEqr0094ConditionVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.EesEqr0108ConditionVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.EesEqr0108MultiVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.EesEqr0112ConditionVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.EesEqr0113ConditionVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.EesEqr0130ConditionVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.EesEqr0131ConditionVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.EesEqr0143MultiVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.ModifyFromTrsOffHireReturnVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.MtyBkgCntrVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.MtyBkgVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.SearchBeforeCntrInfoVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.SearchCheckCntrInfoVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.SearchCntrRepoExecutionPlanEstablishVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.SearchEqrAllWeeksPlanAccessGrantVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.SearchEqrOnfHirExePlnByOffHireReturnVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.SearchEqrOrganizationVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.SearchExecutionPlanBkgNoVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.SearchExecutionPlanCntrInfoExcelVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.SearchExecutionPlanCntrInfoVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.SearchExecutionPlanCntrListVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.SearchExecutionPlanSplitCntrVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.SearchSendHistoryVO;
import com.clt.apps.opus.esd.trs.cydoorsomanage.singletransportationsomanage.vo.SingleTransportationVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.MtyBookingCreateVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.MtyBookingSplitVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.MtyBookingVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.MtyCntrVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.MtyQtyVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.MtyVvdVO;
import com.clt.framework.component.fax.FaxSendException;
import com.clt.framework.component.javamail.MailerAppException;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.object.ObjectCloner;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.EqrEccInterExePlnQtyVO;
import com.clt.syscommon.common.table.EqrEccInterExePlnVO;
import com.clt.syscommon.common.table.EqrExePlnCntrVO;
import com.clt.syscommon.common.table.EqrInlndTrspExePlnQtyVO;
import com.clt.syscommon.common.table.EqrInlndTrspExePlnVO;
import com.clt.syscommon.common.table.EqrInlndTrspPlnQtyVO;
import com.clt.syscommon.common.table.EqrInlndTrspPlnVO;
import com.clt.syscommon.common.table.EqrOnfHirExePlnQtyVO;
import com.clt.syscommon.common.table.EqrOnfHirExePlnVO;
import com.clt.syscommon.common.table.EqrOnfHirPlnQtyVO;
import com.clt.syscommon.common.table.EqrOnfHirPlnVO;
import com.clt.syscommon.common.table.EqrRepoExeSoIfVO;
import com.clt.syscommon.common.table.EqrVslExePlnQtyVO;
import com.clt.syscommon.common.table.EqrVslLodgDchgExePlnVO;
import com.clt.syscommon.common.table.EqrVslLodgDchgPlnQtyVO;

/**
 * -RepoPlanManage Business Logic Basic Command implementation<br>
 *
 * @author 
 * @see EES_EQR_0059EventResponse,CntrRepoExecutionPlanEstablishBC
 * @since J2EE 1.6
 */
public class CntrRepoExecutionPlanEstablishBCImpl extends BasicCommandSupport implements CntrRepoExecutionPlanEstablishBC {

	// Database Access Object
	private transient CntrRepoExecutionPlanEstablishDBDAO dbDao = null;

	/**
	 * creating CntrRepoExecutionPlanEstablishBCImpl<br>
	 * creating CntrRepoExecutionPlanEstablishDBDAO<br>
	 */
	public CntrRepoExecutionPlanEstablishBCImpl() {
		dbDao = new CntrRepoExecutionPlanEstablishDBDAO(); 
	}
	
	/**
	 * [EES_EQR_0059 : ]<br>
	 * saving trunk vessel and feeder cntr repo plan
	 * @param eesEqr0059multiVOs	EesEqr0059MultiVO[] 
	 * @param account				SignOnUserAccount 
	 * @exception EventException
	 */
	public void modifyTrunkVesselAndFeederCntrRepoPlan(EesEqr0059MultiVO[] eesEqr0059multiVOs, SignOnUserAccount account) throws EventException {
		try {
			String repoPlnId = null;
			String refId = null;
			String fmYdCd = null;
			String toYdCd = null;
			String coCd = null;
			String trspModCd = null;
			String mtyBkgNo = null;
			String splitRepoPlnFlg = null;
			String cntrNo = null;
			String tpszNo = null;
			
			List<String> volList			= null;
			List<String> tpszList			= null;
			List<String> flagListArr		= null;
			List<String> unitcostListArr	= null;
			List<String> fromcostListArr	= null;
			List<String> tocostListArr		= null;
			
			String vol = null;    // volum for each type size
			String unitcost = null;
	    	String fromcost = null;
	    	String tocost   = null;
	    	String[] tableCost = null;
	    	String ctnrTpszCd = null;
	    	String flag = null;
	    	String cntrDel = null;
	    	String oldBkgGrpNo = null;

			String usrId				= account.getUsr_id();
			
			if(eesEqr0059multiVOs != null && eesEqr0059multiVOs.length > 0){				
				for ( int i=0; i< eesEqr0059multiVOs.length; i++ ) {					
					repoPlnId		= eesEqr0059multiVOs[i].getRepoPlnId();
					fmYdCd			= eesEqr0059multiVOs[i].getFmYdCd();
					toYdCd			= eesEqr0059multiVOs[i].getToYdCd();
					coCd			= eesEqr0059multiVOs[i].getCoCd();
					trspModCd		= eesEqr0059multiVOs[i].getTrspModCd();
					mtyBkgNo		= eesEqr0059multiVOs[i].getMtyBkgNo();
					splitRepoPlnFlg	= eesEqr0059multiVOs[i].getSplitRepoPlnFlg();
					cntrNo			= eesEqr0059multiVOs[i].getCntrNo();
					tpszNo			= eesEqr0059multiVOs[i].getTpszNo();
					cntrDel			= eesEqr0059multiVOs[i].getCntrDel();
					
					tpszList			= eesEqr0059multiVOs[i].getTpszList();
					volList				= eesEqr0059multiVOs[i].getVolList();
					flagListArr			= eesEqr0059multiVOs[i].getFlagList();
					unitcostListArr		= eesEqr0059multiVOs[i].getUnitcostList();
					fromcostListArr		= eesEqr0059multiVOs[i].getFromcostList();
					tocostListArr		= eesEqr0059multiVOs[i].getTocostList();
					
					
					
					oldBkgGrpNo		= eesEqr0059multiVOs[i].getOldBkgGrpNo();
					
					if ( eesEqr0059multiVOs[i].getIbflag().equals("I") ){
						EqrVslLodgDchgExePlnVO eqrVslLodgDchgExePlnVO = new EqrVslLodgDchgExePlnVO();
						ObjectCloner.build(eesEqr0059multiVOs[i], eqrVslLodgDchgExePlnVO);
						
						if( splitRepoPlnFlg.equals("Y") && !mtyBkgNo.equals("") || 
							!splitRepoPlnFlg.equals("Y")){
							refId	= dbDao.makeRefIDCntrRepoPlan("EQR_VSL_LODG_DCHG_EXE_PLN", coCd, repoPlnId, fmYdCd, trspModCd);
						}

						// EXE Table[EQR_VSL_LODG_DCHG_EXE_PLN ] Setting..
						
						if(refId != null) eqrVslLodgDchgExePlnVO.setRefId(refId);
						eqrVslLodgDchgExePlnVO.setCreUsrId(usrId);
						eqrVslLodgDchgExePlnVO.setUpdUsrId(usrId);
						eqrVslLodgDchgExePlnVO.setOldBkgGrpNo(oldBkgGrpNo);
						
						dbDao.modifyTrunkVesselAndFeederCntrRepoPlan("I",eqrVslLodgDchgExePlnVO);
						
						for ( int j=0; j < tpszList.size(); j++ ) {
							// QTY Table[EQR_VSL_EXE_Pln_QTY ] Setting..
							EqrVslExePlnQtyVO eqrVslExePlnQtyVO = new EqrVslExePlnQtyVO();
							ObjectCloner.build(eqrVslLodgDchgExePlnVO, eqrVslExePlnQtyVO);
							
							ctnrTpszCd	= tpszList.get(j);
							vol			= volList.get(j);
							unitcost	= unitcostListArr.get(j);
							fromcost	= fromcostListArr.get(j);
							tocost		= tocostListArr.get(j);
							flag		= flagListArr.get(j);
							
					       	// in case of unit cost doesn't exist, retirevie for unit cost, from cost, to cost
					       	if( unitcost.equals("0") || unitcost.equals("") ){
					       		tableCost = dbDao.searchUnitCost( "E", fmYdCd, toYdCd, trspModCd, ctnrTpszCd ).getResultStrArray();
					       		
					       		fromcost = tableCost[0];
					       		tocost   = tableCost[1];
					       		unitcost = tableCost[2];	
					       	}
					       	String lodgDchgCostAmt = String.valueOf( Integer.parseInt(vol) * Float.parseFloat(unitcost) );
					       	
					       	int ivol = 0;
					       	ivol = Integer.parseInt(vol);
					       	if ( ivol > 0) {
								eqrVslExePlnQtyVO.setCntrTpszCd(ctnrTpszCd);
								eqrVslExePlnQtyVO.setCntrQty(vol);
								eqrVslExePlnQtyVO.setPlnUcAmt(unitcost);
								eqrVslExePlnQtyVO.setLodgPortUcAmt(fromcost);
								eqrVslExePlnQtyVO.setDchgPortUcAmt(tocost);
								eqrVslExePlnQtyVO.setLodgDchgCostAmt(lodgDchgCostAmt);
								eqrVslExePlnQtyVO.setCreUsrId(usrId);
								eqrVslExePlnQtyVO.setUpdUsrId(usrId);
								
								dbDao.modifyTrunkVesselAndFeederCntrRepoPlanQty("I", eqrVslExePlnQtyVO);
					       	}
						}
						
						// EQR_EXE_PLN_CNTR Table Setting..
						if (!splitRepoPlnFlg.equals("Y") && cntrNo != null && !cntrNo.equals("")){
							EqrExePlnCntrVO eqrExePlnCntrVO = new EqrExePlnCntrVO();
							ObjectCloner.build(eqrVslLodgDchgExePlnVO, eqrExePlnCntrVO);
							
							eqrExePlnCntrVO.setCntrNo(cntrNo);
							eqrExePlnCntrVO.setCntrTpszCd(tpszNo);
							eqrExePlnCntrVO.setCreUsrId(usrId);
							eqrExePlnCntrVO.setUpdUsrId(usrId);
							eqrExePlnCntrVO.setFmEccCd(eesEqr0059multiVOs[i].getFrlocEcc());
							eqrExePlnCntrVO.setToEccCd(eesEqr0059multiVOs[i].getTolocEcc());							
							
							dbDao.modifyCntrRepoPlanDetail("I", eqrExePlnCntrVO, usrId );
						}
					} else if ( eesEqr0059multiVOs[i].getIbflag().equals("U") ){
						EqrVslLodgDchgExePlnVO eqrVslLodgDchgExePlnVO = new EqrVslLodgDchgExePlnVO();
						ObjectCloner.build(eesEqr0059multiVOs[i], eqrVslLodgDchgExePlnVO);
						
						eqrVslLodgDchgExePlnVO.setUpdUsrId(usrId);
						dbDao.modifyTrunkVesselAndFeederCntrRepoPlan("U",eqrVslLodgDchgExePlnVO);
						
						for ( int j=0; j < tpszList.size(); j++ ) {
							// QTY Table[EQR_VSL_EXE_Pln_QTY ] Setting..
							EqrVslExePlnQtyVO eqrVslExePlnQtyVO = new EqrVslExePlnQtyVO();
							ObjectCloner.build(eesEqr0059multiVOs[i], eqrVslExePlnQtyVO);
							
							ctnrTpszCd	= tpszList.get(j);
							flag = flagListArr.get(j);
							vol			= volList.get(j);
							unitcost	= unitcostListArr.get(j);
							fromcost	= fromcostListArr.get(j);
							tocost		= tocostListArr.get(j);
							flag		= flagListArr.get(j);
							
							if(flag.equals("T")) {
						       	// in case of unit cost doesn't exist, retirevie for unit cost, from cost, to cost
								if( unitcost.equals("0") || unitcost.equals("") ){
						       		tableCost = dbDao.searchUnitCost( "E", fmYdCd, toYdCd, trspModCd, ctnrTpszCd ).getResultStrArray();
						       		
						       		fromcost = tableCost[0];
						       		tocost   = tableCost[1];
						       		unitcost = tableCost[2];	
						       	}
						       	String lodgDchgCostAmt = String.valueOf( Integer.parseInt(vol) * Float.parseFloat(unitcost) );
						       	
								eqrVslExePlnQtyVO.setCntrTpszCd(ctnrTpszCd);
								eqrVslExePlnQtyVO.setCntrQty(vol);
								eqrVslExePlnQtyVO.setPlnUcAmt(unitcost);
								eqrVslExePlnQtyVO.setLodgPortUcAmt(fromcost);
								eqrVslExePlnQtyVO.setDchgPortUcAmt(tocost);
								eqrVslExePlnQtyVO.setLodgDchgCostAmt(lodgDchgCostAmt);
								eqrVslExePlnQtyVO.setCreUsrId(usrId);
								eqrVslExePlnQtyVO.setUpdUsrId(usrId);
								
								dbDao.modifyTrunkVesselAndFeederCntrRepoPlanQty("M", eqrVslExePlnQtyVO);
							}
						}
						
						// insert new data to EQR_EXE_PLN_CNTR after removing old data
						EqrExePlnCntrVO eqrExePlnCntrVO = new EqrExePlnCntrVO();
						ObjectCloner.build(eesEqr0059multiVOs[i], eqrExePlnCntrVO);
						eqrExePlnCntrVO.setCntrTpszCd(eesEqr0059multiVOs[i].getTpszNo());
						eqrExePlnCntrVO.setFmEccCd(eesEqr0059multiVOs[i].getFrlocEcc());
						eqrExePlnCntrVO.setToEccCd(eesEqr0059multiVOs[i].getTolocEcc());
						
						if(cntrNo!=null && !cntrNo.equals("")) {
							dbDao.modifyCntrRepoPlanDetail("D", eqrExePlnCntrVO, usrId);				         		
							dbDao.modifyCntrRepoPlanDetail("I", eqrExePlnCntrVO, usrId);				         		
						} 
		        		
		        		// in case of cntrDel = 'Y', revmove all data on EQR_EXE_PLN_CNTR
		        		if(cntrDel.equals("Y")) {
		        			dbDao.modifyCntrRepoPlanDetail("D", eqrExePlnCntrVO, usrId);				         		
						}
					} else if ( eesEqr0059multiVOs[i].getIbflag().equals("D") ){
						EqrVslLodgDchgExePlnVO eqrVslLodgDchgExePlnVO = new EqrVslLodgDchgExePlnVO();
						EqrVslExePlnQtyVO eqrVslExePlnQtyVO = new EqrVslExePlnQtyVO();
						EqrExePlnCntrVO eqrExePlnCntrVO = new EqrExePlnCntrVO();
						
						ObjectCloner.build(eesEqr0059multiVOs[i], eqrVslLodgDchgExePlnVO);
						ObjectCloner.build(eqrVslLodgDchgExePlnVO, eqrVslExePlnQtyVO);
						ObjectCloner.build(eqrVslLodgDchgExePlnVO, eqrExePlnCntrVO); 
						
						// removing EQR_EXE_PLN_CNTR
						if (eqrExePlnCntrVO != null )
							dbDao.modifyCntrRepoPlanDetail("D", eqrExePlnCntrVO, usrId);
						
						// removing EQR_VSL_EXE_PLN_QTY
						if (eqrVslExePlnQtyVO != null)
							dbDao.modifyTrunkVesselAndFeederCntrRepoPlanQty("D", eqrVslExePlnQtyVO);
						
						// removing EQR_VSL_LODG_DCHG_EXE_PLN
						if (eqrVslLodgDchgExePlnVO != null)
							dbDao.modifyTrunkVesselAndFeederCntrRepoPlan("D",eqrVslLodgDchgExePlnVO);
					}
				}
			}
		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * [EES_EQR_0059 : BKG/DOC Interface - Mty Booking Creation ]<br>
	 * creating repo BKG
	 * @param commonVO	CommonVO
	 * @param account	SignOnUserAccount 
	 * @return MtyBookingCreateVO
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public MtyBookingCreateVO createRepoBKG(CommonVO commonVO, SignOnUserAccount account) throws EventException {
		MtyBookingCreateVO mtyBookingCreateVO = new MtyBookingCreateVO();
		MtyBookingVO mtyBookingVO = new MtyBookingVO();
		MtyVvdVO[] mtyVvdVOs = new MtyVvdVO[1];
		MtyCntrVO mtyCntrVO= null;
		MtyQtyVO mtyQtyVO = null;
		
		Collection<MtyCntrVO> mtyCntrVOs = new ArrayList<MtyCntrVO>();
		Collection<MtyQtyVO> mtyQtyVOs = new ArrayList<MtyQtyVO>();
		
		String targetServer = null;
		String office_code	= null;
		List<String> tpszList= null;
		
		String polClptIndSeq = null;
		String podClptIndSeq = null;
		String repoBkgFlg	= null;
        
        int sum_volum = 0;
		int bkg_div = 0;
		String fm_rcc = null;
		//String fm_ecc = null;
		String company = null;
		String eqRepoPurpCd = null;
		List<String[]> cntrType_list = null;
		String usrId	= account.getUsr_id();
		String vps_port	= null;
        
        String gubun = commonVO.getGubun();
        try {
        	if ( commonVO != null ) {
		        if ( gubun.equals("V") ){		// Vessel , EES_EQR_0059
		        	EesEqr0059MultiVO[] multiVOs = (EesEqr0059MultiVO[]) commonVO.getResultVo();
		        	EesEqr0059MultiVO multiVO = multiVOs[0];
		        	
		        	log.debug("=========EesEqr0059MultiVO===>>>>>> multiVO"); 
		        	tpszList		= multiVO.getTpszList();
					
					// targer server information
					fm_rcc			= multiVO.getFrlocRcc();
					company			= multiVO.getCoCd();
					
					log.debug("=========fm_rcc===" + fm_rcc);
					log.debug("=========company===" + company);
					/*
           * in case of BKG CRE, BKG SPLIT CRE and FROM LOC = 'EGAIS', RCC = 'DEHAM'
			 		/*
					fm_ecc	= multiVO.getFrlocEcc();
					
					if(fm_ecc.equals("EGAIS")) {
						fm_rcc = "DEHAM";
					}
					*/
					
					targetServer = dbDao.searchServerName(fm_rcc, "REPO").getField1();
					office_code = getOfficeCode(targetServer);
					
		        	if(company.equals("H"))  targetServer = transServerName(targetServer);
		        	
					log.debug("\n==================== createRepoBKG Vessel targetServer : " +targetServer);
					log.debug("\n==================== createRepoBKG Vessel office_code  : " +office_code);					
					log.debug("\n==AutoMtBkgmgtSC 파일에서 하드코딩한 값>>>tpszList.size()>>"+tpszList.size());
					log.debug("\n==tpszList.size() 값은 무조건 1이다.");
					
					for ( int i=0; i < tpszList.size(); i++ ){
						sum_volum = 0;
						mtyQtyVO = new MtyQtyVO();
						repoBkgFlg = multiVO.getRepobkgFlag();
						
						log.debug("\n=== sum_volum 값은 무조건 1이다.");
						if(repoBkgFlg.equals("T")) {	// Repo Booking 
							sum_volum = 1;
						}
						
						if(sum_volum > 0) {
							mtyQtyVO.setCntrTpszCd(tpszList.get(i));
							mtyQtyVO.setOpCntrQty(Integer.toString(sum_volum));
	
							mtyQtyVOs.add(mtyQtyVO);
						}
					}
					
					log.debug("\n=eesEqr0059MultiList 에서 설정한값= mtyQtyVO.getCntrTpszCd()>>"+mtyQtyVO.getCntrTpszCd());
					log.debug("\n=무조건 수량은 1= mtyQtyVO.getOpCntrQty()>>"+mtyQtyVO.getOpCntrQty());
					
					repoBkgFlg = multiVO.getRepobkgFlag();
					if(repoBkgFlg.equals("T")) {
						bkg_div++;
					}
					
					//배치시에는 처리하지 않는다.
					/*commonVO.setConditionVo((EesEqr0059MultiVO) multiVO);
					cntrType_list = dbDao.searchCntrNoTpSz(commonVO).getResultVOList();
					if(cntrType_list != null) {
						// multi cntrNo, cntr tpsz 
						for(int k=0; k<cntrType_list.size();k++) {
							mtyCntrVO = new MtyCntrVO();
							mtyCntrVO.setCntrNo(((String[])cntrType_list.get(k))[0]);
							mtyCntrVO.setCntrTpszCd(((String[])cntrType_list.get(k))[1]);
							mtyCntrVOs.add(mtyCntrVO);
						}
					}
					*/
					
					// 위에 주석처리한것을 아랫것으로 변경한다.
					mtyCntrVO = new MtyCntrVO();
					mtyCntrVO.setCntrNo(multiVO.getCntrNo());
					mtyCntrVO.setCntrTpszCd(multiVO.getCntrTpszCd());
					mtyCntrVOs.add(mtyCntrVO);
					
					/** mtyBookingVO Setting **/					
					mtyBookingVO.setCompInd		(multiVO.getCoCd());
					mtyBookingVO.setUsrId		(usrId);
					mtyBookingVO.setBkgCreSvrCd	(targetServer);
					mtyBookingVO.setVslCd		(multiVO.getVslCd());
					mtyBookingVO.setSkdVoyNo	(multiVO.getSkdVoyNo());
					mtyBookingVO.setSkdDirCd	(multiVO.getSkdDirCd());
					mtyBookingVO.setBkgOfcCd	(office_code);
					mtyBookingVO.setPkupYdCd	(multiVO.getFmYdCd());
					mtyBookingVO.setPreRlyPortCd("");
					mtyBookingVO.setPstRlyPortCd("");
					mtyBookingVO.setPolYdCd		(multiVO.getFmYdCd());
					//mtyBookingVO.setPolYdCd		("XXXXX");	
					mtyBookingVO.setPodYdCd(multiVO.getToYdCd());
					
					//  D, H, E, S in EQR --->  D, H, S in BKG/DOC
					// E, S ===> S 
		        	eqRepoPurpCd = multiVO.getEqRepoPurpCd();
					if(!eqRepoPurpCd.equals("D") && !eqRepoPurpCd.equals("H")) {	// E(Evacution), S(Stock Feeding) 
						mtyBookingVO.setMtyBkgStsCd("S");
					} else {														// H(Hanger Rack), D(Damage Repair) 
						mtyBookingVO.setMtyBkgStsCd(eqRepoPurpCd);
					}
					
					mtyBookingVO.setBkgRmk("");
					if(bkg_div==1){
						mtyBookingVO.setMtySplitAvalCd("Z");
					} else {
						mtyBookingVO.setMtySplitAvalCd("C");
					}
					
					/** mtyVvdVO Setting **/
					log.debug("\n=== polClptIndSeq 값을 가져오기 위한 값 정==");
					log.debug("\n=== eesEqr0059MultiVO.getVslCd()==" + multiVO.getVslCd());
					log.debug("\n=== eesEqr0059MultiVO.getSkdVoyNo()==" + multiVO.getSkdVoyNo());
					log.debug("\n=== eesEqr0059MultiVO.getSkdDirCd()==" + multiVO.getSkdDirCd());
					log.debug("\n=== eesEqr0059MultiVO.getVslLaneCd()==" + multiVO.getVslLaneCd());
					log.debug("\n=== eesEqr0059MultiVO.getVpsPort()==" + multiVO.getFrlocEcc());	
					vps_port = multiVO.getFrlocEcc();
					
					multiVO.setVpsPort(vps_port);
					commonVO.setConditionVo((EesEqr0059MultiVO) multiVO);
					polClptIndSeq = dbDao.searchClptIndSEq(commonVO).getResultString();
		
					vps_port = multiVO.getTolocEcc();
					multiVO.setVpsPort(vps_port);
					commonVO.setConditionVo((EesEqr0059MultiVO) multiVO);
					podClptIndSeq = dbDao.searchClptIndSEq(commonVO).getResultString();
					
					podClptIndSeq = ( podClptIndSeq.equals("") || podClptIndSeq == null ) ? "0" : podClptIndSeq;
					log.debug("\n=== searchClptIndSEq 쿼리 실행후 값 추출 polClptIndSeq>> "+ polClptIndSeq);
					log.debug("\n=== searchClptIndSEq 쿼리 실행후 값 추출 podClptIndSeq>> "+ podClptIndSeq);
					
					mtyVvdVOs[0] = new MtyVvdVO();
					mtyVvdVOs[0].setVslPrePstCd	("T");
					mtyVvdVOs[0].setVslSeq		("0");
					mtyVvdVOs[0].setVslCd		(multiVO.getVslCd());
					mtyVvdVOs[0].setSkdVoyNo		(multiVO.getSkdVoyNo());
					mtyVvdVOs[0].setSkdDirCd		(multiVO.getSkdDirCd());
					mtyVvdVOs[0].setPolYdCd		(multiVO.getFmYdCd());
					//mtyVvdVOs[0].setPolYdCd		("XXXXX");
					mtyVvdVOs[0].setPodYdCd(multiVO.getToYdCd());
					mtyVvdVOs[0].setPolClptIndSeq(polClptIndSeq);
					mtyVvdVOs[0].setPodClptIndSeq(podClptIndSeq);
					
					/** mtyBookingCreate VO Setting **/
					mtyBookingCreateVO.setMtyBookingVO(mtyBookingVO);
					mtyBookingCreateVO.setMtyVvdVOs( mtyVvdVOs );
					log.debug("mtyBookingCreate VO Setting>>>>");
					mtyBookingCreateVO.setMtyCntrVOs( (MtyCntrVO[]) mtyCntrVOs.toArray(new MtyCntrVO[mtyCntrVOs.size()]) );
					mtyBookingCreateVO.setMtyQtyVOs( (MtyQtyVO[]) mtyQtyVOs.toArray(new MtyQtyVO[mtyQtyVOs.size()]) );					
					log.debug("mtyBookingCreate VO Setting>>>>");
		        } else if ( gubun.equals("W") ){
		        	EesEqr0080MultiVO[] multiVOs = (EesEqr0080MultiVO[]) commonVO.getResultVo();
		        	EesEqr0080MultiVO multiVO = multiVOs[0];
		        	
					tpszList		= multiVO.getTpszList();
					
					// targer server information
					fm_rcc			= multiVO.getFrlocRcc();
					company			= multiVO.getCoCd();
					
 				  /*
           * in case of BKG CRE, BKG SPLIT CRE and FROM LOC = 'EGAIS' RCC = 'DEHAM'
					/*
					fm_ecc	= multiVO.getFrlocEcc();

					if(fm_ecc.equals("EGAIS")) {
						fm_rcc = "DEHAM";
					}
					*/
					targetServer = dbDao.searchServerName(fm_rcc, "REPO").getField1();	        	
					office_code = getOfficeCode(targetServer);
					
		        	if(company.equals("H"))  targetServer = transServerName(targetServer);
					
					log.debug("\n==================== createRepoBKG Water targetServer : " +targetServer);
					log.debug("\n==================== createRepoBKG Water office_code  : " +office_code);
		        	
					for ( int i=0; i < tpszList.size(); i++ ){
						sum_volum = 0;
						mtyQtyVO = new MtyQtyVO();
						repoBkgFlg = multiVO.getRepobkgFlag();
						if(repoBkgFlg.equals("T")) {	// Repo Booking 
							sum_volum += Integer.parseInt( multiVO.getVolList().get(i));
						}
						
						if(sum_volum > 0) {
							mtyQtyVO.setCntrTpszCd(tpszList.get(i));
							mtyQtyVO.setOpCntrQty(Integer.toString(sum_volum));	
							mtyQtyVOs.add(mtyQtyVO);							
						}
					}
					
					repoBkgFlg = multiVO.getRepobkgFlag();
					if(repoBkgFlg.equals("T")) {
						bkg_div++;
					}
					
					commonVO.setConditionVo((EesEqr0080MultiVO) multiVO);
					cntrType_list = dbDao.searchCntrNoTpSz(commonVO).getResultVOList();
					if(cntrType_list != null) {
						// multi cntrNo, cntr tpsz
						for(int k=0; k<cntrType_list.size();k++) {
							mtyCntrVO = new MtyCntrVO();
							mtyCntrVO.setCntrNo(((String[])cntrType_list.get(k))[0]);
							mtyCntrVO.setCntrTpszCd(((String[])cntrType_list.get(k))[1]);
							mtyCntrVOs.add(mtyCntrVO);
						}
					}
									
					/** mtyBookingVO Setting **/
					mtyBookingVO.setCompInd		(multiVO.getCoCd());
					mtyBookingVO.setUsrId		(usrId);
					mtyBookingVO.setBkgCreSvrCd	(targetServer);
					if ( multiVO.getVvd().length() >= 9) {
						mtyBookingVO.setVslCd		(multiVO.getVvd().substring(0,4));
						mtyBookingVO.setSkdVoyNo	(multiVO.getVvd().substring(4,8));
						mtyBookingVO.setSkdDirCd	(multiVO.getVvd().substring(8,9));
					}
					
					mtyBookingVO.setBkgOfcCd	(office_code);
					mtyBookingVO.setPkupYdCd	(multiVO.getToYdCd());
					mtyBookingVO.setPreRlyPortCd("");
					mtyBookingVO.setPstRlyPortCd("");
					mtyBookingVO.setPolYdCd		(multiVO.getFmYdCd());
					mtyBookingVO.setPodYdCd(multiVO.getToYdCd());
					
					//  D, H, E, S in EQR --->  D, H, S in BKG/DOC
					// E, S ===> S
		        	eqRepoPurpCd = multiVO.getEqRepoPurpCd();
					if(!eqRepoPurpCd.equals("D") && !eqRepoPurpCd.equals("H")) {	// E(Evacution), S(Stock Feeding) 
						mtyBookingVO.setMtyBkgStsCd("S");
					} else {														// H(Hanger Rack), D(Damage Repair)
						mtyBookingVO.setMtyBkgStsCd(eqRepoPurpCd);
					}
					
					mtyBookingVO.setBkgRmk("");
					mtyBookingVO.setMtySplitAvalCd("W");
					
					/** mtyVvdVO Setting **/
					vps_port = multiVO.getFrlocEcc();
					multiVO.setVpsPort(vps_port);
					commonVO.setConditionVo((EesEqr0080MultiVO) multiVO);
					polClptIndSeq = dbDao.searchClptIndSEq(commonVO).getResultString();
		
					vps_port = multiVO.getTolocEcc();
					multiVO.setVpsPort(vps_port);
					commonVO.setConditionVo((EesEqr0080MultiVO) multiVO);
					podClptIndSeq = dbDao.searchClptIndSEq(commonVO).getResultString();
					
					mtyVvdVOs[0] = new MtyVvdVO();
					mtyVvdVOs[0].setVslPrePstCd	("T");
					mtyVvdVOs[0].setVslSeq		("0");
	
					if ( multiVO.getVvd().length() >= 9) {
						mtyVvdVOs[0].setVslCd	(multiVO.getVvd().substring(0,4));
						mtyVvdVOs[0].setSkdVoyNo	(multiVO.getVvd().substring(4,8));
						mtyVvdVOs[0].setSkdDirCd	(multiVO.getVvd().substring(8,9));
					}
					mtyVvdVOs[0].setPolYdCd		(multiVO.getFmYdCd());
					mtyVvdVOs[0].setPodYdCd(multiVO.getToYdCd());
					mtyVvdVOs[0].setPolClptIndSeq(polClptIndSeq);
					mtyVvdVOs[0].setPodClptIndSeq(podClptIndSeq);
					
					/** mtyBookingCreate VO Setting **/
					mtyBookingCreateVO.setMtyBookingVO(mtyBookingVO);
					mtyBookingCreateVO.setMtyVvdVOs(mtyVvdVOs);
					mtyBookingCreateVO.setMtyCntrVOs( (MtyCntrVO[]) mtyCntrVOs.toArray(new MtyCntrVO[mtyCntrVOs.size()]) );
					mtyBookingCreateVO.setMtyQtyVOs( (MtyQtyVO[]) mtyQtyVOs.toArray(new MtyQtyVO[mtyQtyVOs.size()]) );
		        	
		        }
        	}
		} catch (Exception ex) {
	        log.error("err "+ex.toString(),ex);
	        throw new EventException(ex.getMessage());
	    }
		
		return mtyBookingCreateVO;
	}
	
	/**
	 * [EES_EQR_0059 : BKG/DOC Interface - Mty Booking Split ]<br>
	 * creating BKG Split No. 
	 * @param multiVO	EesEqr0059MultiVO
	 * @param account	SignOnUserAccount
	 * @return MtyBookingSplitVO
	 * @exception EventException
	 */
	public MtyBookingSplitVO createRepoBKGSplit(EesEqr0059MultiVO multiVO, SignOnUserAccount account) throws EventException {
		MtyBookingSplitVO mtyBookingSplitVO = new MtyBookingSplitVO();
		MtyBookingVO mtyBookingVO = new MtyBookingVO();
		MtyVvdVO[] mtyVvdVOs = new MtyVvdVO[1];
		MtyCntrVO mtyCntrVO= null;
		
		CommonVO commonVO = new CommonVO();				
		Collection<MtyCntrVO> mtyCntrVOs = new ArrayList<MtyCntrVO>();
        
        try {
        	if ( multiVO != null ) {
				String fmYdCd			= multiVO.getFmYdCd();
				String toYdCd			= multiVO.getToYdCd();
				String coCd				= multiVO.getCoCd();
				String oldBkgGrpNo		= multiVO.getOldBkgGrpNo();
				String mtyBkgNo			= multiVO.getMtyBkgNo();
				String cntrNo			= multiVO.getCntrNo();
				String tpszNo			= multiVO.getTpszNo();
				String eqRepoPurpCd 	= multiVO.getEqRepoPurpCd();
				String splitRepoPlnFlg	= multiVO.getSplitRepoPlnFlg();
        		//String fm_ecc			= multiVO.getFrlocEcc();
		    	String ibFlag			= multiVO.getIbflag();
		    	String trspModCd		= multiVO.getTrspModCd();
		    	String usrId			= account.getUsr_id();
		    	
        		String fm_rcc			= null;
				String targetServer = null;
				String office_code	= null;	
        		String refId = null;
        		String vps_port	= null;
        		String polClptIndSeq = null;
        		String podClptIndSeq = null;
				
      		if ( multiVO.getIbflag().equals("I") && splitRepoPlnFlg.equals("Y") ){
	        		commonVO.setGubun("V");
	        		
       		/*
           * in case of BKG CRE, BKG SPLIT CRE and FROM LOC = 'EGAIS', RCC = 'DEHAM'
					/*
					if(fm_ecc.equals("EGAIS")) {
						fm_rcc = "DEHAM";
					}
					*/
					// targer server information
					fm_rcc			= multiVO.getFrlocRcc();					
	
					targetServer = dbDao.searchServerName(fm_rcc, "REPO").getField1();
					office_code = getOfficeCode(targetServer);
					

		        	if(coCd.equals("H"))  targetServer = transServerName(targetServer);

					log.debug("\n==================== createRepoBKGSplit targetServer : " +targetServer);
					log.debug("\n==================== createRepoBKGSplit office_code  : " +office_code);

	        		mtyBookingVO.setCompInd(coCd);
	        		mtyBookingVO.setUsrId(usrId);
	        		mtyBookingVO.setBkgCreSvrCd(targetServer);
	        		mtyBookingVO.setBkgRmk("");
	        		mtyBookingVO.setMtySplitAvalCd("S");
	        		mtyBookingVO.setVslCd(multiVO.getVslCd());
	        		mtyBookingVO.setSkdVoyNo(multiVO.getSkdVoyNo());
	        		mtyBookingVO.setSkdDirCd(multiVO.getSkdDirCd());
	        		mtyBookingVO.setBkgOfcCd(office_code);
	        		mtyBookingVO.setPkupYdCd(fmYdCd);
	        		mtyBookingVO.setPreRlyPortCd("");
	        		mtyBookingVO.setPstRlyPortCd("");
	        		mtyBookingVO.setPolYdCd(fmYdCd);
	        		mtyBookingVO.setPodYdCd(toYdCd);
	        		
					//  D, H, E, S in EQR --->  D, H, S in BKG/DOC
					// E, S ===> S 
					if(!eqRepoPurpCd.equals("D") && !eqRepoPurpCd.equals("H")) {	// E(Evacution), S(Stock Feeding) 
						mtyBookingVO.setMtyBkgStsCd("S");
					} else {														// H(Hanger Rack), D(Damage Repair) 
						mtyBookingVO.setMtyBkgStsCd(eqRepoPurpCd);
					}
					
					/** mtyVvdVO Setting **/
					vps_port = multiVO.getFrlocEcc();
					multiVO.setVpsPort(vps_port);
					commonVO.setConditionVo(multiVO);
					polClptIndSeq = dbDao.searchClptIndSEq(commonVO).getResultString();
		
					vps_port = multiVO.getTolocEcc();
					multiVO.setVpsPort(vps_port);
					commonVO.setConditionVo(multiVO);
					podClptIndSeq = dbDao.searchClptIndSEq(commonVO).getResultString();				
					
					mtyVvdVOs[0] = new MtyVvdVO();
					mtyVvdVOs[0].setVslPrePstCd("T");
					mtyVvdVOs[0].setVslSeq("0");
					mtyVvdVOs[0].setVslCd(multiVO.getVslCd());
					mtyVvdVOs[0].setSkdVoyNo(multiVO.getSkdVoyNo());
					mtyVvdVOs[0].setSkdDirCd(multiVO.getSkdDirCd());
					mtyVvdVOs[0].setPolYdCd(fmYdCd);
					mtyVvdVOs[0].setPodYdCd(toYdCd);
					mtyVvdVOs[0].setPolClptIndSeq(polClptIndSeq);
					mtyVvdVOs[0].setPodClptIndSeq(podClptIndSeq);
					
					/** mtyCntrVOs Setting **/				
					String[] cntrno_arr    = null;
					String[] tpszno_arr    = null;
					String[] cnmvcd_arr    = null;
					
					cntrno_arr = cntrNo.split(",");
					tpszno_arr = tpszNo.split(",");
					cnmvcd_arr = multiVO.getCntrStatus().split(",");
					
					for(int k=0; k<cntrno_arr.length;k++) {
						mtyCntrVO = new MtyCntrVO();
						mtyCntrVO.setCntrNo(cntrno_arr[k]);
						mtyCntrVO.setCntrTpszCd(tpszno_arr[k]);
						mtyCntrVO.setCnmvStsCd(cnmvcd_arr[k]);					
						mtyCntrVOs.add(mtyCntrVO);
					}
	        	}
	        	
	        	/** mtyBookingSplitVO VO Setting **/
	        	mtyBookingSplitVO.setMtyBookingVO(mtyBookingVO);
	        	mtyBookingSplitVO.setMtyVvdVOs( mtyVvdVOs );
	        	mtyBookingSplitVO.setMtyCntrVOs( (MtyCntrVO[]) mtyCntrVOs.toArray(new MtyCntrVO[mtyCntrVOs.size()]) );
	        	
	        	EqrVslLodgDchgExePlnVO eqrVslLodgDchgExePlnVO = new EqrVslLodgDchgExePlnVO();
	        	
	        	// creating ref_id
	        	refId = dbDao.makeRefIDCntrRepoPlan("EQR_VSL_LODG_DCHG_EXE_PLN", coCd, multiVO.getRepoPlnId(), multiVO.getFmYdCd(), "V");
				ObjectCloner.build(multiVO, eqrVslLodgDchgExePlnVO);

				// EXE Table[EQR_VSL_LODG_DCHG_EXE_PLN ] Setting..
				
				eqrVslLodgDchgExePlnVO.setRefId(refId);
				eqrVslLodgDchgExePlnVO.setCreUsrId(usrId);
				eqrVslLodgDchgExePlnVO.setUpdUsrId(usrId);
				eqrVslLodgDchgExePlnVO.setMtyBkgNo(mtyBkgNo);
				eqrVslLodgDchgExePlnVO.setOldBkgGrpNo(oldBkgGrpNo);
				dbDao.modifyTrunkVesselAndFeederCntrRepoPlan("I",eqrVslLodgDchgExePlnVO);
				
				multiVO.setRefId(refId);
				// QTY Table Insert
				
			    	
				List<String> tpszList			= multiVO.getTpszList();
		    	List<String> volList			= multiVO.getVolList();
		    	List<String> flagListArr		= multiVO.getFlagList();
		    	List<String> unitcostListArr	= multiVO.getUnitcostList();
		    	List<String> fromcostListArr	= multiVO.getFromcostList();
		    	List<String> tocostListArr		= multiVO.getTocostList();	    	
				
		    	String[] tableCost = new String[3];
				String unitcost = null;
		    	String fromcost = null;
		    	String tocost   = null;

				String vol = null;    // volum for each type size
		    	String ctnrTpszCd = null;
		    	String flag = null;
		    	String cntrDel = null;

				for ( int j=0; j < tpszList.size(); j++ ) {
					// QTY Table[EQR_VSL_EXE_Pln_QTY ] Setting..
					EqrVslExePlnQtyVO eqrVslExePlnQtyVO = new EqrVslExePlnQtyVO();			
					ObjectCloner.build(multiVO, eqrVslExePlnQtyVO);
					
					ctnrTpszCd	= tpszList.get(j);
					vol			= volList.get(j);
					unitcost	= unitcostListArr.get(j);
					fromcost	= fromcostListArr.get(j);
					tocost		= tocostListArr.get(j);
					flag		= flagListArr.get(j);
			       	
			       	if ( ibFlag.equals("I") ) {
           // in case of BKG CRE, BKG SPLIT CRE and FROM LOC = 'EGAIS', RCC = 'DEHAM' 
				       	if( unitcost.equals("0") || unitcost.equals("") ){
				       		tableCost = dbDao.searchUnitCost( "E", fmYdCd, toYdCd, trspModCd, ctnrTpszCd ).getResultStrArray();
				       		
				       		fromcost = tableCost[0];
				       		tocost   = tableCost[1];
				       		unitcost = tableCost[2];	
				       	}

				       	String lodgDchgCostAmt = String.valueOf( Integer.parseInt(vol) * Float.parseFloat(unitcost) );
				       	
				       	int ivol = 0;
				       	ivol = Integer.parseInt(vol);
				       	if ( ivol > 0) {
							eqrVslExePlnQtyVO.setCntrTpszCd(ctnrTpszCd);
							eqrVslExePlnQtyVO.setCntrQty(vol);
							eqrVslExePlnQtyVO.setPlnUcAmt(unitcost);
							eqrVslExePlnQtyVO.setLodgPortUcAmt(fromcost);
							eqrVslExePlnQtyVO.setDchgPortUcAmt(tocost);
							eqrVslExePlnQtyVO.setLodgDchgCostAmt(lodgDchgCostAmt);
							eqrVslExePlnQtyVO.setCreUsrId(usrId);
							eqrVslExePlnQtyVO.setUpdUsrId(usrId);
							
							dbDao.modifyTrunkVesselAndFeederCntrRepoPlanQty("I", eqrVslExePlnQtyVO);
				       	}

			       	} else if ( ibFlag.equals("U") ) {
						if(flag.equals("T")) {
           // in case of BKG CRE, BKG SPLIT CRE and FROM LOC = 'EGAIS', RCC = 'DEHAM'
							if( unitcost.equals("0") || unitcost.equals("") ){
					       		tableCost = dbDao.searchUnitCost( "E", fmYdCd, toYdCd, trspModCd, ctnrTpszCd ).getResultStrArray();
					       		
					       		fromcost = tableCost[0];
					       		tocost   = tableCost[1];
					       		unitcost = tableCost[2];	
					       	}

					       	String lodgDchgCostAmt = String.valueOf( Integer.parseInt(vol) * Float.parseFloat(unitcost) );
					       	
							eqrVslExePlnQtyVO.setCntrTpszCd(ctnrTpszCd);
							eqrVslExePlnQtyVO.setCntrQty(vol);
							eqrVslExePlnQtyVO.setPlnUcAmt(unitcost);
							eqrVslExePlnQtyVO.setLodgPortUcAmt(fromcost);
							eqrVslExePlnQtyVO.setDchgPortUcAmt(tocost);
							eqrVslExePlnQtyVO.setLodgDchgCostAmt(lodgDchgCostAmt);
							eqrVslExePlnQtyVO.setCreUsrId(usrId);
							eqrVslExePlnQtyVO.setUpdUsrId(usrId);
							
							dbDao.modifyTrunkVesselAndFeederCntrRepoPlanQty("M", eqrVslExePlnQtyVO);
						}
			       	}
				}
				
				if ( ibFlag.equals("I") ) {
					// EQR_EXE_PLN_CNTR Table Setting..
					if (!splitRepoPlnFlg.equals("Y") && cntrNo != null && !cntrNo.equals("")){
						EqrExePlnCntrVO eqrExePlnCntrVO = new EqrExePlnCntrVO();
						ObjectCloner.build(multiVO, eqrExePlnCntrVO);
						
						eqrExePlnCntrVO.setCntrNo(cntrNo);
						eqrExePlnCntrVO.setCntrTpszCd(tpszNo);
						eqrExePlnCntrVO.setCreUsrId(usrId);
						eqrExePlnCntrVO.setUpdUsrId(usrId);
						eqrExePlnCntrVO.setFmEccCd(multiVO.getFrlocEcc());
						eqrExePlnCntrVO.setToEccCd(multiVO.getTolocEcc());							
						
						dbDao.modifyCntrRepoPlanDetail("I", eqrExePlnCntrVO, usrId );
					}
				} else if ( ibFlag.equals("U") ){
					// insert new data to EQR_EXE_PLN_CNTR after removing old data
					EqrExePlnCntrVO eqrExePlnCntrVO = new EqrExePlnCntrVO();
					ObjectCloner.build(multiVO, eqrExePlnCntrVO);
					eqrExePlnCntrVO.setCntrTpszCd(multiVO.getTpszNo());
					eqrExePlnCntrVO.setFmEccCd(multiVO.getFrlocEcc());
					eqrExePlnCntrVO.setToEccCd(multiVO.getTolocEcc());
					
					if(cntrNo!=null && !cntrNo.equals("")) {
						dbDao.modifyCntrRepoPlanDetail("D", eqrExePlnCntrVO, usrId);				         		
						dbDao.modifyCntrRepoPlanDetail("I", eqrExePlnCntrVO, usrId);				         		
					} 
	        		
	        		// in case of cntrDel = 'Y', removing EQR_EXE_PLN_CNTR 
	        		if(cntrDel != null && cntrDel.equals("Y")) {
	        			dbDao.modifyCntrRepoPlanDetail("D", eqrExePlnCntrVO, usrId);				         		
					}
				}
			}
		} catch (Exception ex) {
	        log.error("err "+ex.toString(),ex);
	        throw new EventException(ex.getMessage());
	    }
		
		return mtyBookingSplitVO;
	}

	/**
	 * [EES_EQR_0059 & EES_EQR_0080 :  ]<br>
	 * updating Bkg No., after MTY Booking Creation
	 * @param mtyBkgVO	MtyBkgVO
	 * @param commonVO	CommonVO
	 * @exception EventException
	 */
	public void modifyMtyBkgNo(MtyBkgVO mtyBkgVO, CommonVO commonVO) throws EventException {
		List<Map<String, Object>> updateVoList = new ArrayList<Map<String, Object>>();
		String gubun	= null;
		String usr_id	= null;
		String mtyBkgNo	= null;
		String oldBkgGrpNo = null;
		
		try {
			log.debug(">>>>>>>>>>>>>+"+mtyBkgVO);
			log.debug(">>>>>>>>>>>>>+"+mtyBkgVO.getGubun());
			log.debug(">>>>>>>>>>>>>+"+mtyBkgVO.getMtyBkgNo());
			log.debug(">>>>>>>>>>>>>+"+mtyBkgVO.getMtyBkgNo());
			log.debug(">>>>>>>>>>>>>+"+mtyBkgVO.getUsrId());
			if( mtyBkgVO != null) {
				gubun		= mtyBkgVO.getGubun();
				mtyBkgNo	= mtyBkgVO.getMtyBkgNo();
				oldBkgGrpNo	= mtyBkgVO.getMtyBkgNo();
				usr_id		= mtyBkgVO.getUsrId();
			}
			if(gubun != null) {
				if ( gubun.equals("V") ){
					EesEqr0059MultiVO[] multiVOs = (EesEqr0059MultiVO[]) commonVO.getResultVo();
					log.debug("multiVOs.length>>>>>>>>>>>>>+"+multiVOs.length);
					for ( int i=0; i < multiVOs .length; i++ ) {
						if(mtyBkgNo != null) multiVOs[i].setMtyBkgNo(mtyBkgNo);
						if(usr_id != null) multiVOs[i].setUpdUsrId(usr_id);
						Map<String, Object> list = new HashMap<String, Object>();
						list.putAll(multiVOs[i].getColumnValues());
						if(oldBkgGrpNo != null) list.put("old_bkg_grp_no", oldBkgGrpNo);
						updateVoList.add(list);
					}
				} else if ( gubun.equals("W") ){
					EesEqr0080MultiVO[] multiVOs = (EesEqr0080MultiVO[]) commonVO.getResultVo();
					
					for ( int i=0; i < multiVOs .length; i++ ) {
						if(mtyBkgNo != null) multiVOs[i].setMtyBkgNo(mtyBkgNo);
						if(usr_id != null) multiVOs[i].setUpdUsrId(usr_id);
						Map<String, Object> list = new HashMap<String, Object>();
						list.putAll(multiVOs[i].getColumnValues());
						updateVoList.add(list);
					}
				}
			}

			log.debug("updateVoList.size()>>>>>>>>>>>>>+"+updateVoList.size());
			if ( updateVoList.size() > 0 ) {
				if( mtyBkgVO != null) {
					dbDao.modifyMtyBkgNo(mtyBkgVO, updateVoList);
					dbDao.modifyMtyBkgNoForSoIf(mtyBkgVO, updateVoList);
				}
			}
		} catch (Exception ex) {
	        log.error("err "+ex.toString(),ex);
	        throw new EventException(ex.getMessage());
	    }
	}
	
	/**
	 * getting office code 
	 * @param targetServer	String
	 * @return String
	 * @exception EventException
	 */
	public String getOfficeCode(String targetServer) throws EventException {
		String ofc_cd = null;
		
		try {
			
			if(targetServer.equals("DKR")) 		ofc_cd =  OfficeCodeMgr.getOfficeCodeList("000002", "EQR").toString();//SHAAS 
			else if(targetServer.equals("DCH")) ofc_cd =  OfficeCodeMgr.getOfficeCodeList("000002", "EQR").toString();//SHAAS 
			else if(targetServer.equals("DSW")) ofc_cd =  OfficeCodeMgr.getOfficeCodeList("000003", "EQR").toString();//SINWA 
			else if(targetServer.equals("DEU")) ofc_cd =  OfficeCodeMgr.getOfficeCodeList("000004", "EQR").toString(); //HAMUR; 
			else if(targetServer.equals("DUS")) ofc_cd =  OfficeCodeMgr.getOfficeCodeList("000005", "EQR").toString(); //NYCNA;

			if(ofc_cd==null || ofc_cd.equals("")) {
				throw new EventException(new ErrorHandler("EQR10031", new String[]{"Office code"}).getMessage());
			}	
			
    		return ofc_cd;

		} catch (Exception ex) {
	        log.error("err "+ex.toString(),ex);
	        throw new EventException(ex.getMessage());
	    }
	}
	
	/**
	 * [BKG/DOC Interface : ]<br>
	 * changing Volume
	 * @param mtyBkgVO	MtyBkgVO
	 * @exception EventException
	 */
	public void modifyMtyBkgVolChange(MtyBkgVO mtyBkgVO) throws EventException {
		DBRowSet targetRs = null;
		List<CheckBkgVolumeTargetVO> list = null;
		List<EqrVslExePlnQtyVO>  eqrVslExePlnQtyVOs = null;
		List<EqrInlndTrspExePlnQtyVO> eqrInlndTrspExePlnQtyVOs = null;
		
		List<MtyBkgCntrVO> mtyBkgCntrVOs = null;
		
		String[] table_name = new String[2];
		String gubun = null;
		int diff_qty = 0;
		int rowCount = 0;
		int cntrQty = 0;
		String cntr_check = "N";
		String cntr_tpsz_cd= null;
		String[] tableCost = null;
		String	fromCost = null;
		String	toCost	= null;
		String	unitCost= null;
		String mty_bkg_no = null; 
		
		try {
			if( mtyBkgVO != null ){
				mty_bkg_no = mtyBkgVO.getMtyBkgNo();
			}
			if( mty_bkg_no != null ){
				// 01. checking vessel or water with Bkg No.
				targetRs = dbDao.checkTarget(mtyBkgVO).getDbRowset();
				int targetCount = targetRs.getRowCount();
				
				while ( targetRs.next() ){
					gubun	= targetRs.getString("GUBUN");
				}
				
				if( targetCount > 1) {
					// COM12114 -- Please check ($s)
					throw new EventException((String)new ErrorHandler("COM12242", "BKG No.("+mty_bkg_no+").").getMessage());
				} else if (targetCount == 1 ) {	// after checking
					mtyBkgVO.setGubun(gubun);
					
					if ( gubun.equals("V") ){
						table_name[0]	= "EQR_VSL_LODG_DCHG_EXE_PLN";
						table_name[1]	= "EQR_VSL_EXE_PLN_QTY";
					} else if ( gubun.equals("W") ){
						table_name[0]	= "EQR_INLND_TRSP_EXE_PLN";
						table_name[1]	= "EQR_INLND_TRSP_EXE_PLN_QTY";
					}
					mtyBkgVO.setTableName(table_name);
					
					// compare BKG_QUANTITY with EQR_VSL_LODG_DCHG_EXE_PLN 
					mtyBkgCntrVOs = dbDao.checkBkgVolumeChange(mtyBkgVO);
					
					for ( int i=0; i < mtyBkgCntrVOs.size(); i ++ ) {
						cntrQty = Integer.parseInt( mtyBkgCntrVOs.get(i).getCntrQty() );
						
						// 02. retrieving for Target on Exe Table with Bkg No.
						list = dbDao.checkBkgVolumeTarget(mtyBkgVO, mtyBkgCntrVOs.get(i));
						
						if ( list.size() > 0 ){
							diff_qty = Integer.parseInt(list.get(0).getCntrQty()) - cntrQty;
						} else {
							diff_qty = cntrQty;
						}
				
						rowCount = list.size();
					
						// in case of the Container Type Size doesn't exist
						if ( rowCount <= 0 ) {
							list = dbDao.checkBkgVolumeTargetExe(mtyBkgVO, mtyBkgCntrVOs.get(i));
							cntr_check = "Y";
							rowCount = list.size();
						}
						eqrVslExePlnQtyVOs = new ArrayList<EqrVslExePlnQtyVO>();
						eqrInlndTrspExePlnQtyVOs = new ArrayList<EqrInlndTrspExePlnQtyVO>();
						for ( int k=0; k < rowCount; k++ ){
						
							cntr_tpsz_cd = ( cntr_check.equals("Y")) ? mtyBkgCntrVOs.get(i).getCntrTpszCd() : list.get(k).getCntrTpszCd();

							// UNIT COST						
							tableCost = dbDao.searchUnitCost("E", list.get(k).getFmYdCd(), list.get(k).getToYdCd(), list.get(k).getTrspModCd(), cntr_tpsz_cd).getResultStrArray();
							fromCost	= tableCost[0];
							toCost		= tableCost[1];
							unitCost	= tableCost[2];

							if ( gubun.equals("V") ){
								EqrVslExePlnQtyVO vslQtyVO = new EqrVslExePlnQtyVO();
								vslQtyVO.setRepoPlnId(list.get(k).getRepoPlnId());
								vslQtyVO.setPlnYrwk(list.get(k).getPlnYrwk());
								vslQtyVO.setPlnSeq(list.get(k).getPlnSeq());
								vslQtyVO.setRefId(list.get(k).getRefId());
								vslQtyVO.setCntrTpszCd(cntr_tpsz_cd);
								vslQtyVO.setCreUsrId(mtyBkgVO.getUsrId());
								vslQtyVO.setUpdUsrId(mtyBkgVO.getUsrId());
								vslQtyVO.setCntrQty(Integer.toString(cntrQty));
								vslQtyVO.setLodgPortUcAmt(fromCost);
								vslQtyVO.setDchgPortUcAmt(toCost);
								vslQtyVO.setPlnUcAmt(unitCost);
								vslQtyVO.setLodgDchgCostAmt(Float.toString(cntrQty * Float.parseFloat(tableCost[2])));
								eqrVslExePlnQtyVOs.add(vslQtyVO);
							} else if ( gubun.equals("W") ){
								EqrInlndTrspExePlnQtyVO inlndQtyVO = new EqrInlndTrspExePlnQtyVO();
								inlndQtyVO.setRepoPlnId(list.get(k).getRepoPlnId());
								inlndQtyVO.setPlnYrwk(list.get(k).getPlnYrwk());
								inlndQtyVO.setPlnSeq(list.get(k).getPlnSeq());
								inlndQtyVO.setRefId(list.get(k).getRefId());
								inlndQtyVO.setCntrTpszCd(cntr_tpsz_cd);
								inlndQtyVO.setCreUsrId(mtyBkgVO.getUsrId());
								inlndQtyVO.setUpdUsrId(mtyBkgVO.getUsrId());
								inlndQtyVO.setCntrQty(Integer.toString(cntrQty));
								inlndQtyVO.setFmEccUcAmt(fromCost);
								inlndQtyVO.setToEccUcAmt(toCost);
								inlndQtyVO.setPlnUcAmt(unitCost);
								inlndQtyVO.setTrspCostAmt(Float.toString(cntrQty * Float.parseFloat(unitCost)));
								eqrInlndTrspExePlnQtyVOs.add(inlndQtyVO);
							}
							
							if ( list.get(k) != null ){
								// modify volum on execution table
								if ( gubun.equals("V") ){
									dbDao.modifyTrunkVesselAndFeederBkgVolDiff(eqrVslExePlnQtyVOs);
									
//									// in case of Split
//									if ( mtyBkgVO.getSplitFlg().equals("Y") ){
//										// Fixed Plan 
//										EqrVslLodgDchgPlnQtyVO eqrVslLodgDchgPlnQtyVO = new EqrVslLodgDchgPlnQtyVO();
//										ObjectCloner.build(eqrVslExePlnQtyVOs.get(0), eqrVslLodgDchgPlnQtyVO);
//		
//										eqrVslLodgDchgPlnQtyVO.setLodgPortCostAmt(fromCost);
//										eqrVslLodgDchgPlnQtyVO.setDchgPortCostAmt(toCost);
//										eqrVslLodgDchgPlnQtyVO.setPlnUcAmt(unitCost);
//										eqrVslLodgDchgPlnQtyVO.setCntrQty(Integer.toString(diff_qty));
//										
//										modifyFixedPlan(eqrVslLodgDchgPlnQtyVO);
//									}
									// in case of Original MTY BKG
//									else if (mtyBkgVO.getSplitFlg().equals("N") ){
									//if (mtyBkgVO.getSplitFlg() != null ){
										/*if (mtyBkgVO.getSplitFlg().equals("N")){
											// retrieving for Plan Table 
											EesEqr0059MultiVO eesEqr0059MultiVO = new EesEqr0059MultiVO();
	//										eesEqr0059MultiVO = mtyBkgVO.getEesEqr0059MultiVO();
											List<EqrVslLodgDchgPlnQtyVO> fixedPlanVOs = null;
											
											eesEqr0059MultiVO.setVslCd(list.get(k).getVslCd());
											eesEqr0059MultiVO.setSkdVoyNo(list.get(k).getSkdVoyNo());
											eesEqr0059MultiVO.setSkdDirCd(list.get(k).getSkdDirCd());
											eesEqr0059MultiVO.setFrlocEcc(list.get(k).getFmYdCd().substring(0, 5));
											eesEqr0059MultiVO.setTolocEcc(list.get(k).getToYdCd().substring(0, 5));
											eesEqr0059MultiVO.setCntrTpszCd(cntr_tpsz_cd);										
	
											fixedPlanVOs = dbDao.searchOrgFixedPlan(eesEqr0059MultiVO);
											
											for(int j=0; j<fixedPlanVOs.size(); j++){										
												EqrVslLodgDchgPlnQtyVO eqrVslLodgDchgPlnQtyVO = new EqrVslLodgDchgPlnQtyVO();
												ObjectCloner.build(fixedPlanVOs.get(j), eqrVslLodgDchgPlnQtyVO);
												eqrVslLodgDchgPlnQtyVO.setLodgPortCostAmt(fromCost);
												eqrVslLodgDchgPlnQtyVO.setDchgPortCostAmt(toCost);
												eqrVslLodgDchgPlnQtyVO.setPlnUcAmt(unitCost);
												eqrVslLodgDchgPlnQtyVO.setCreUsrId(mtyBkgVO.getUsrId());
												eqrVslLodgDchgPlnQtyVO.setUpdUsrId(mtyBkgVO.getUsrId());
												eqrVslLodgDchgPlnQtyVO.setCntrQty(Integer.toString(diff_qty));
												
												modifyFixedPlan(eqrVslLodgDchgPlnQtyVO);
											}
										}*/
									/*} else {
										throw new EventException((String)new ErrorHandler("SplitFlg is null.").getMessage());
									}*/
								} else if ( gubun.equals("W") ){
									dbDao.modifyTruckAndRailAndBargeBkgVolDiff(eqrInlndTrspExePlnQtyVOs);
								}
							}
						}
					}					
				}
			} else {
				// Data Not Found.
				throw new EventException((String)new ErrorHandler("EQR10009").getMessage());
			}
		} catch (Exception ex) {
	        log.error("err "+ex.toString(),ex);
	        throw new EventException(ex.getMessage());
	    }
	}
	
	/**
	 * [BOK/DOC InterFace :  ]<br>
	 * Canceling Mty Booking
	 * 
	 * @param mtyBkgVO	MtyBkgVO
	 * @exception EventException
	 */
	public void modifyMtyBkgCancel(MtyBkgVO mtyBkgVO) throws EventException {
		DBRowSet targetRs = null;
		String gubun = null;
		String check = null;
		String[] table_name = new String[1];
		
		int i=0;
		try {
			if( mtyBkgVO.getMtyBkgNo() != null ){
				// checking vessel or water with Bkg No.
				targetRs = dbDao.checkTarget(mtyBkgVO).getDbRowset();
				
				while (targetRs.next() ){
					check		= targetRs.getString("CHK");
					if ( check.equals("Y") ) {
						gubun	= targetRs.getString("GUBUN");
						i++;
					}
				}
				
				if ( i == 0 ){
					throw new EventException((String)new ErrorHandler("There is no BKG No.("+mtyBkgVO.getMtyBkgNo()+").").getMessage());
				}
				
				if( i > 1) {
					throw new EventException("wrong Bkg info.");
				} else {
					mtyBkgVO.setGubun(gubun);
					if ( gubun.equals("V") ){
						table_name[0] = "EQR_VSL_LODG_DCHG_EXE_PLN";
					} else if ( gubun.equals("W") ){
						table_name[0] = "EQR_INLND_TRSP_EXE_PLN";
					}
					
					mtyBkgVO.setTableName(table_name);
					dbDao.modifyBkgCancel(mtyBkgVO);
				}
			} else {
				throw new EventException(new ErrorHandler("COM12200", "MTY BKG No.").getMessage());
			}
		} catch (Exception ex) {
	        log.error("err "+ex.toString(),ex);
	        throw new EventException(ex.getMessage());
	    }
	}
	
	/**
	 * trans ServerName 
	 * 
	 * @param targetServer	String
	 * @return String	target_server
	 * @exception EventException
	 */
	public String transServerName(String targetServer) throws EventException {
		String target_server = null;
		
		try {
        	if(targetServer.equals("DKR"))      target_server = "KOR";
        	else if(targetServer.equals("DCH")) target_server = "CHN";
        	else if(targetServer.equals("DSW")) target_server = "SWA";
        	else if(targetServer.equals("DUS")) target_server = "USA";
        	else if(targetServer.equals("DEU")) target_server = "EUR";        		

			if(target_server==null || target_server.equals("")) {
				throw new DAOException(new ErrorHandler("EQR10031", "Target server").getMessage());
			}	

    		return target_server;

		} catch (Exception ex) {
	        log.error("err "+ex.toString(),ex);
	        throw new EventException(ex.getMessage());
	    }
	}

	/**
	 * retrieving for Cntr Repo Execution Plan Establish<br>
	 * 
	 * @param condiVO EesEqr0113ConditionVO
	 * @return List<SearchCntrRepoExecutionPlanEstablishVO>
	 * @exception EventException
	 */
	public List<SearchCntrRepoExecutionPlanEstablishVO> searchCntrRepoExecutionPlanEstablish(EesEqr0113ConditionVO condiVO) throws EventException {
	
		try {
			List<SearchCntrRepoExecutionPlanEstablishVO> list =dbDao.searchCntrRepoExecutionPlanEstablish(condiVO);
			return list;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * retrieving for CNTR Repo Execution Plan CNTR List<br>
	 * 
	 * @param  conditionVO EesEqr0094ConditionVO
	 * @return List<SearchExecutionPlanCntrListVO>
	 * @exception EventException
	 */
	public List<SearchExecutionPlanCntrListVO> searchCntrRepoExecutionPlanCntrList(EesEqr0094ConditionVO conditionVO) throws EventException {
		List<SearchExecutionPlanCntrListVO> list = null;
		try {
			
			list = dbDao.searchCntrRepoExecutionPlanCntrList(conditionVO);
			return list;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * retrieving for CNTR Repo Execution Plan CNTR Info<br>
	 * 
	 * @param  conditionVO EesEqr0094ConditionVO
	 * @return List<SearchExecutionPlanCntrInfoVO>
	 * @exception EventException
	 */
	public List<SearchExecutionPlanCntrInfoVO> searchCntrRepoExecutionPlanCntrInfo(EesEqr0094ConditionVO conditionVO) throws EventException {
		List<SearchExecutionPlanCntrInfoVO> list = null;
		try {
			list =dbDao.searchCntrRepoExecutionPlanCntrInfo(conditionVO);
			return list;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * retrieving CNTR Repo Execution Plan CNTR Info Excel<br>
	 * Excel
	 * @param  conditionVO EesEqr0094ConditionVO
	 * @return List<SearchExecutionPlanCntrInfoExcelVO>
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchExecutionPlanCntrInfoExcelVO> searchCntrRepoExecutionPlanCntrInfoExcel(EesEqr0094ConditionVO conditionVO) throws EventException {
		List<SearchExecutionPlanCntrInfoExcelVO> list = null;
		try { 
			List cntrNoArr	= Utils.replaceStrToList(conditionVO.getCntrNo()); 
			
			if(cntrNoArr.size() > 0) { // excel file format is correct
				list = dbDao.searchCntrRepoExecutionPlanCntrInfoExcel(conditionVO);
				return list;

			}else {	// excel file format is not correct, request check it
				throw new DAOException(new ErrorHandler("EQR10036").getMessage());
			}	
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * checking CNTR info<br>
	 * 
	 * @param  conditionVO EesEqr0094ConditionVO
	 * @return EventResponse EES-EQR-094EventResponse
	 * @exception EventException
	 */
	public List<SearchCheckCntrInfoVO> searchCheckCntrInfo(EesEqr0094ConditionVO conditionVO) throws EventException {
		List<SearchCheckCntrInfoVO> list = null;
		
		try {
			list = dbDao.searchCheckCntrInfo(conditionVO);
			return list;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * retrieving for before CNTR info<br>
	 * 
	 * @param  conditionVO EesEqr0094ConditionVO
	 * @return List<SearchBeforeCntrInfoVO>
	 * @exception EventException
	 */
	public List<SearchBeforeCntrInfoVO> searchBeforeCntrInfo(EesEqr0094ConditionVO conditionVO) throws EventException {
		List<SearchBeforeCntrInfoVO> list = null;
		try {
			list = dbDao.searchBeforeCntrInfo(conditionVO);
			return list;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	

	/**
	 * saving for truck and rail and barge CNTR repo plan<br>
      INSERT : - REF_ID 
               - EQR_INLND_TRSP_EXE_PLN 
               - EQR_EXE_PLN_CNTR 
               
      UPDATE : - EQR_INLND_TRSP_EXE_PLN     VOL 
               - EQR_EXE_PLN_CNTR 		

      DELETE : - EQR_EXE_PLN_CNTR 		
               - EQR_INLND_TRSP_EXE_PLN
	 * 
	 * @param conditionVO EesEqr0059ConditionVO
	 * @param vos EesEqr0080MultiVO[]
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyTruckAndRailAndBargeCntrRepoPlan(EesEqr0059ConditionVO conditionVO ,EesEqr0080MultiVO[] vos , SignOnUserAccount account) throws EventException {
	            
	    String user_id        = account.getUsr_id(); // user id information
	
	    try {
			// INSERT, UPDATE, DELETE 
	    	//dbDao.modifyTruckAndRailAndBargeCntrRepoPlan(event, userId, tpszInitial);
	    	if(vos != null && vos.length > 0){

    			String tpszType = conditionVO.getTpsztype();
				String[] tpszArr= tpszType.split(",");
				String[] tpszArrInitial= conditionVO.getTpszInitial().split(",");
	    		String ref_id_new = "";	 // ref_id 
	    		String soFlag = conditionVO.getSoFlag();
				                        
	            
	            List<String> volList 	 = null;
	        	int vol          = 0;    // volum for each type size

		    	
	        	List<String> flagList	 = null;
	        	String flag      = "";
	
	        	// VVL
	        	String vsl_cd     = null;
	        	String skd_voy_no = null;
	        	String skd_dir_cd = null;

		    	List<String> unitcostList 	= null;
		    	List<String> fromcostList 	= null;
		    	List<String> tocostList   	= null;
		    	float unitcost = 0;
		    	float fromcost = 0;
		    	float tocost   = 0;

	       		CommonDBDAO commondbDao = new CommonDBDAO(); // for creating new PLN_SEQ 

		    	String[] tableCost = null;
	    		for(int i = 0 ; i < vos.length ; i++){
	    			EesEqr0080MultiVO vo = (EesEqr0080MultiVO)vos[i];
	    			vol     = 0; 
	            	volList = new ArrayList<String>();
		        	
		        	unitcostList = new ArrayList<String>();
		        	fromcostList = new ArrayList<String>();
		        	tocostList   = new ArrayList<String>();
		        	unitcost     = 0;
		        	fromcost     = 0;
		        	tocost       = 0;
		        	
	            	flagList = new ArrayList<String>(); 
	            	flag     = "";
	            	
	            	tableCost = null;
	
	            	if(vo.getVvd().length() >= 9) {
	            		vsl_cd     = vo.getVvd().substring(0,4);            	
	            		skd_voy_no = vo.getVvd().substring(4,8);
	            		skd_dir_cd = vo.getVvd().substring(8,9);
	            	}
	            	if(vo.getIbflag().equals("I")) {	            		
	                	if(vo.getDiv().equals("Plan")) {  // Plan 
	                		// checking available PLAN INSERT
	                		EqrInlndTrspPlnVO  checkEqrInlndTrspPlnVO = new EqrInlndTrspPlnVO();
	                		checkEqrInlndTrspPlnVO.setRepoPlnId(vo.getRepoPlnId());
	                		checkEqrInlndTrspPlnVO.setPlnYrwk(vo.getPlnYrwk());
	                		checkEqrInlndTrspPlnVO.setTrspModCd(vo.getTrspModCd());
	                		checkEqrInlndTrspPlnVO.setFmEccCd(vo.getFmYdCd());
	                		checkEqrInlndTrspPlnVO.setFmYrwk(vo.getFmEtdDt());
	                		checkEqrInlndTrspPlnVO.setToEccCd(vo.getToYdCd());
	                		checkEqrInlndTrspPlnVO.setToYrwk(vo.getToEtaDt());
	                		
	                		if(dbDao.inlandInsertCheck(checkEqrInlndTrspPlnVO)) {
	                  			String line = Integer.toString(i+1);
	                			String[] errMessage ={line, vo.getRepoPlnId()+","+vo.getPlnYrwk()+","+vo.getPlnSeq()};
	                			throw new DAOException(new ErrorHandler("EQR10025", errMessage).getMessage());
	                		
	                        // checking PLAN INSERT target has LINK data
	                		}else if(dbDao.inlandInsertCheck_link(vo.getFmYdCd(), vo.getToYdCd(), vo.getTrspModCd())) {
	                			String[] errMessage ={" ("+vo.getFmYdCd()+"-"+vo.getToYdCd()+")"};
	                			log.debug(errMessage);
	                			throw new DAOException(new ErrorHandler("EQR10033", errMessage).getMessage());
	                			
	                		}else {	
	                			EqrInlndTrspPlnVO eqrInlndTrspPlnVO = new EqrInlndTrspPlnVO();
    				       		ObjectCloner.build(vo , eqrInlndTrspPlnVO );
    				       		
	                			String plnSeq = commondbDao.getNextPlnSeq("EQR_INLND_TRSP_PLN", vo.getRepoPlnId(), vo.getPlnYrwk()).getResultString(); // creating pln_seq 
	                			eqrInlndTrspPlnVO.setPlnSeq(plnSeq);
	                			eqrInlndTrspPlnVO.setFmEccCd(vo.getFmYdCd());
	                			eqrInlndTrspPlnVO.setToEccCd(vo.getToYdCd());
	                			eqrInlndTrspPlnVO.setFmYrwk(vo.getFmEtdDt()); 
	                			eqrInlndTrspPlnVO.setToYrwk(vo.getToEtaDt());
	                			eqrInlndTrspPlnVO.setPastRepoPlnFlg("N");
    				       		dbDao.insertInlandPlan(eqrInlndTrspPlnVO,user_id); // insert EQR_INLND_TRSP_PLN 
    				       		
	                			for(int m=0; m<tpszArrInitial.length; m++) { // 10 TPSZ in using to PLAN
	                				volList = vo.getVolList();
		                			vol    = Integer.parseInt((String)volList.get(m));
		                			
	                				tableCost = dbDao.searchUnitCost("P", vo.getFmYdCd(), vo.getToYdCd(), vo.getTrspModCd(), tpszArr[m]).getResultStrArray();
                                    
	    				       		fromcost = Float.parseFloat(tableCost[0]);
	    				       		tocost   = Float.parseFloat(tableCost[1]);
	    				       		unitcost = Float.parseFloat(tableCost[2]);	
	    				       		EqrInlndTrspPlnQtyVO eqrInlndTrspPlnQtyVO = new EqrInlndTrspPlnQtyVO();
	    				       		ObjectCloner.build(vo , eqrInlndTrspPlnQtyVO );
	    				       		eqrInlndTrspPlnQtyVO.setPlnSeq(plnSeq);
	    				       		eqrInlndTrspPlnQtyVO.setCntrTpszCd(tpszArr[m]);
	    				       		eqrInlndTrspPlnQtyVO.setPlnUcAmt(String.valueOf(unitcost));
	    				       		eqrInlndTrspPlnQtyVO.setFmEccCostAmt(String.valueOf(fromcost));
	    				       		eqrInlndTrspPlnQtyVO.setToEccCostAmt(String.valueOf(tocost));
	    				       		eqrInlndTrspPlnQtyVO.setCntrQty(String.valueOf(vol));
	    				       		dbDao.insertInlandPlanQty(eqrInlndTrspPlnQtyVO,user_id); // insert EQR_INLND_TRSP_PLN_QTY
	                			}
	                		}
	                	}else {  // insert Execution
	                		// creating ref_id
	                		ref_id_new = dbDao.makeRefIDCntrRepoPlan("EQR_INLND_TRSP_EXE_PLN", vo.getCoCd(), vo.getRepoPlnId(), vo.getFmYdCd(), vo.getTrspModCd());
	                		
	                		EqrInlndTrspExePlnVO eqrInlndTrspExePlnVO = new EqrInlndTrspExePlnVO();
	                		ObjectCloner.build(vo , eqrInlndTrspExePlnVO );
	                		eqrInlndTrspExePlnVO.setRefId(ref_id_new);
	                		if(vsl_cd != null) eqrInlndTrspExePlnVO.setVslCd(vsl_cd);
	                		if(skd_voy_no != null) eqrInlndTrspExePlnVO.setSkdVoyNo(skd_voy_no);
	                		if(skd_dir_cd != null) eqrInlndTrspExePlnVO.setSkdDirCd(skd_dir_cd);
	                		
	                		eqrInlndTrspExePlnVO.setDpSeq(Integer.toString(i + 1));
	                		dbDao.insertInlandExecute(eqrInlndTrspExePlnVO,user_id);  // inserting EQR_INLND_TRSP_EXE_PLN
	                		
	                		for(int m=0; m<tpszArr.length; m++) {
	                			// volum for each type size
	                			volList = vo.getVolList();
	                			vol    = Integer.parseInt((String)volList.get(m));	

	    				    	// amount for each type size * unitcost
	    				       	
	    				       	// unit cost, from cost, to cost for each type size
	    				    	unitcostList = vo.getUnitcostList();
	    				    	fromcostList = vo.getFromcostList();
	    				    	tocostList	 = vo.getTocostList();
	    				       	unitcost    = Float.parseFloat((String)unitcostList.get(m));	
	    				       	fromcost    = Float.parseFloat((String)fromcostList.get(m));	
	    				       	tocost      = Float.parseFloat((String)tocostList.get(m));	
	    				       	
	    				       	// in case of unit cost doesn't exist, retirevie for unit cost, from cost, to cost
	    				       	if(unitcost==0) {
	    				       		tableCost = dbDao.searchUnitCost("E", vo.getFmYdCd(), vo.getToYdCd(), vo.getTrspModCd() , tpszArr[m]).getResultStrArray();

	    				       		fromcost = Float.parseFloat(tableCost[0]);
	    				       		tocost   = Float.parseFloat(tableCost[1]);
	    				       		unitcost = Float.parseFloat(tableCost[2]);	    				       		
 				       		
	    				       	}
	    				       	
	    				       	EqrInlndTrspExePlnQtyVO eqrInlndTrspExePlnQtyVO = new EqrInlndTrspExePlnQtyVO();
	    				       	
		                		ObjectCloner.build(vo , eqrInlndTrspExePlnQtyVO );
		                		eqrInlndTrspExePlnQtyVO.setRefId(ref_id_new);
		                		eqrInlndTrspExePlnQtyVO.setCntrTpszCd(tpszArr[m]); 
		                		eqrInlndTrspExePlnQtyVO.setCntrQty(vol+"");
		                		eqrInlndTrspExePlnQtyVO.setTrspCostAmt((vol * unitcost)+"");
		                		eqrInlndTrspExePlnQtyVO.setPlnUcAmt(unitcost+"");
		                		eqrInlndTrspExePlnQtyVO.setFmEccUcAmt(fromcost+"");
		                		eqrInlndTrspExePlnQtyVO.setToEccUcAmt(tocost+"");
		                		
		                		dbDao.insertInlandExecuteQty(eqrInlndTrspExePlnQtyVO,user_id);  // inserting EQR_INLND_TRSP_EXE_PLN_QTY 	 
		                		
	                		}
	                		
	                		// inserting to EQR_EXE_PLN_CNTR
	                		if(vo.getCntrno()!=null && !vo.getCntrno().trim().equals("")) {
	                			
	                			EqrExePlnCntrVO eqrExePlnCntrVO = new EqrExePlnCntrVO();
	                			
	                			ObjectCloner.build(vo , eqrExePlnCntrVO );
	                			eqrExePlnCntrVO.setRefId(ref_id_new);
	                			eqrExePlnCntrVO.setCntrTpszCd(vo.getTpszno());
	                			eqrExePlnCntrVO.setCntrNo(vo.getCntrno());
	                			eqrExePlnCntrVO.setFmEccCd(vo.getFrlocEcc());
	                			eqrExePlnCntrVO.setToEccCd(vo.getTolocEcc());
	                			
	                			dbDao.modifyCntrRepoPlanDetail("I", eqrExePlnCntrVO, user_id);				         		
	                		} 
	                		
	                	}
	            	}else if(vo.getIbflag().equals("U")) {	   
					    for(int m=0; m<tpszArr.length; m++) {				    	
					    	// volume for each type size
					    	volList = vo.getVolList();
					       	vol    = Integer.parseInt((String)volList.get(m));	

					    	// volume for each type size * unitcost
					       	
					       	// flag info (T, F)
					       	flagList = vo.getFlagList();
					       	flag    = (String)flagList.get(m);	// flag
							
    				       	// unit cost, from cost, to cost for each type size
    				    	unitcostList = vo.getUnitcostList();
    				    	fromcostList = vo.getFromcostList();
    				    	tocostList	 = vo.getTocostList();
    				       	unitcost    = Float.parseFloat((String)unitcostList.get(m));	
    				       	fromcost    = Float.parseFloat((String)fromcostList.get(m));	
    				       	tocost      = Float.parseFloat((String)tocostList.get(m));	
    				       	
							if(flag.equals("T")) {

	    				       	// in case of unit cost doesn't exist, retirevie for unit cost, from cost, to cost
	    				       	if(unitcost==0) {
	    				       		tableCost = dbDao.searchUnitCost("E", vo.getFmYdCd(), vo.getToYdCd() , vo.getTrspModCd(), tpszArr[m]).getResultStrArray();
	    				       		
	    				       		fromcost = Float.parseFloat(tableCost[0]);
	    				       		tocost   = Float.parseFloat(tableCost[1]);
	    				       		unitcost = Float.parseFloat(tableCost[2]);

	    				       		//log.debug("\n------------------- in start UPDATE dao ---------- ");
	    				       		//log.debug("\n------------------- in start UPDATE dao ---------- tableCost[0] : " + tableCost[0]);
	    				       		//log.debug("\n------------------- in start UPDATE dao ---------- tableCost[0] : " + tableCost[1]);
	    				       		//log.debug("\n------------------- in start UPDATE dao ---------- tableCost[0] : " + tableCost[2]);
	    				       	}
	    				       	EqrInlndTrspExePlnQtyVO eqrInlndTrspExePlnQtyVO = new EqrInlndTrspExePlnQtyVO();
	    				       	ObjectCloner.build(vo , eqrInlndTrspExePlnQtyVO );
	    				       	//eqrInlndTrspExePlnQtyVO.setRefId(ref_id_new);
		                		eqrInlndTrspExePlnQtyVO.setCntrTpszCd(tpszArr[m]); 
		                		eqrInlndTrspExePlnQtyVO.setCntrQty(vol+"");
		                		eqrInlndTrspExePlnQtyVO.setTrspCostAmt((vol * unitcost)+"");
		                		eqrInlndTrspExePlnQtyVO.setPlnUcAmt(unitcost+"");
		                		eqrInlndTrspExePlnQtyVO.setFmEccUcAmt(fromcost+"");
		                		eqrInlndTrspExePlnQtyVO.setToEccUcAmt(tocost+"");
	    				       	dbDao.mergeInlandExecuteQty(eqrInlndTrspExePlnQtyVO, user_id, soFlag);
							}
							
					    }
					    EqrInlndTrspExePlnVO eqrInlndTrspExePlnVO = new EqrInlndTrspExePlnVO();
                		ObjectCloner.build(vo , eqrInlndTrspExePlnVO );
                		//eqrInlndTrspExePlnVO.setRefId(ref_id_new);
                		if(vsl_cd != null) eqrInlndTrspExePlnVO.setVslCd(vsl_cd);
                		if(skd_voy_no != null) eqrInlndTrspExePlnVO.setSkdVoyNo(skd_voy_no);
                		if(skd_dir_cd != null) eqrInlndTrspExePlnVO.setSkdDirCd(skd_dir_cd);
                		if(soFlag.equals("Y") && vo.getSoIssFlg().equals("1")){
                			eqrInlndTrspExePlnVO.setExeIssFlg("Y");
                		}
                		dbDao.updateInlandExecute(eqrInlndTrspExePlnVO,user_id, soFlag);  // EQR_INLND_TRSP_EXE_PLN 수정
                		// Inserting new data to EQR_ONF_HIR_EXE_PLN_CNTR after removing old data
	            		if(vo.getCntrno()!=null && !vo.getCntrno().trim().equals("")) {
	            			EqrExePlnCntrVO eqrExePlnCntrVO = new EqrExePlnCntrVO();
                			ObjectCloner.build(vo , eqrExePlnCntrVO );
                			//eqrExePlnCntrVO.setRefId(ref_id_new);
                			eqrExePlnCntrVO.setCntrTpszCd(vo.getTpszno());
                			eqrExePlnCntrVO.setCntrNo(vo.getCntrno());
                			eqrExePlnCntrVO.setFmEccCd(vo.getFrlocEcc());
                			eqrExePlnCntrVO.setToEccCd(vo.getTolocEcc());
                			dbDao.modifyCntrRepoPlanDetail("D", eqrExePlnCntrVO, user_id);			
                			dbDao.modifyCntrRepoPlanDetail("I", eqrExePlnCntrVO, user_id);					         		
	    				}    
	            		// removing EQR_ONF_HIR_EXE_PLN_CNTR
	            		if(vo.getCntrDel().equals("Y")) {
	            			EqrExePlnCntrVO eqrExePlnCntrVO = new EqrExePlnCntrVO();
                			ObjectCloner.build(vo , eqrExePlnCntrVO );
                			//eqrExePlnCntrVO.setRefId(ref_id_new);
                			eqrExePlnCntrVO.setCntrTpszCd(vo.getTpszno());
                			eqrExePlnCntrVO.setCntrNo(vo.getCntrno());
                			eqrExePlnCntrVO.setFmEccCd(vo.getFrlocEcc());
                			eqrExePlnCntrVO.setToEccCd(vo.getTolocEcc());
                			dbDao.modifyCntrRepoPlanDetail("D", eqrExePlnCntrVO, user_id);				         		
	    				}    
	            	}else if(vo.getIbflag().equals("D")) {	   
	            		// removing EQR_EXE_PLN_CNTR
	            		EqrExePlnCntrVO eqrExePlnCntrVO = new EqrExePlnCntrVO();
            			ObjectCloner.build(vo , eqrExePlnCntrVO );
            			//eqrExePlnCntrVO.setRefId(ref_id_new);
            			eqrExePlnCntrVO.setCntrTpszCd("");
            			eqrExePlnCntrVO.setCntrNo("");
            			eqrExePlnCntrVO.setFmEccCd("XXXXX");
            			eqrExePlnCntrVO.setToEccCd("XXXXX");
            			
            			if(vo.getDiv().equals("Plan")) {
            				dbDao.deleteEqrInlandTrspPlnQtyExecuteQty(eqrExePlnCntrVO);
            				
            				dbDao.deleteEqrInlandTrspPlnExecuteQty(eqrExePlnCntrVO);
            				
            			}else{
	            			dbDao.modifyCntrRepoPlanDetail("D", eqrExePlnCntrVO, user_id);	
	            			
	            			// removing EQR_ECC_INTER_EXE_PLN_QTY
	            			EqrInlndTrspExePlnQtyVO eqrInlndTrspExePlnQtyVO = new EqrInlndTrspExePlnQtyVO();
					       	ObjectCloner.build(vo , eqrInlndTrspExePlnQtyVO );
	            			dbDao.deleteInlandExecuteQty(eqrInlndTrspExePlnQtyVO);
	
	            			// removing EQR_ECC_INTER_EXE_PLN
	            			EqrInlndTrspExePlnVO eqrInlndTrspExePlnVO = new EqrInlndTrspExePlnVO();
	                		ObjectCloner.build(vo , eqrInlndTrspExePlnVO );
	            			dbDao.deleteInlandExecute(eqrInlndTrspExePlnVO);
            			}
	            	}
	    		}
	    	}
	    	
	    } catch (Exception de) {
	        log.error("err "+de.toString(),de);
	        throw new EventException(de.getMessage());
	    }
	}	

	/**
	 * sending truck and rail and barge CNTR repo plan<br>
     * 
     * @param conditionVO	EesEqr0059ConditionVO
	 * @param vos			EesEqr0080MultiVO[]
	 * @param account		SignOnUserAccount
     * @exception EventException
     */
    public void soSendTruckAndRailAndBargeCntrRepoPlan(EesEqr0059ConditionVO conditionVO ,EesEqr0080MultiVO[] vos , SignOnUserAccount account) throws EventException {
                
    	DBRowSet dbRowset = null;
    	String user_id = account.getUsr_id(); // user id information
    	
    	// dbDao.modifyTruckAndRailAndBargeCntrRepoPlan logic
    	
    	// modifying EQR_REPO_EXE_SO_IF 
    	// dbDao.soSendTruckAndRailAndBargeCntrRepoPlan(event, userId);      // EQR_REPO_EXE_SO_IF
    	String tpszType = conditionVO.getTpsztype();
		String[] tpszArr= tpszType.split(",");
        
        List<String> volList 	 = null;
        
    	int vol          = 0;    // volum for each type size

        int seq = 1; 		// REF_SEQ of EQR_REPO_EXE_SO_IF (starting with 1 for each ref_id) 
        int cntrSeq = 0;  	// CNTR_SEQ of EQR_EXE_PLN_CNTR

        // CNTR_TPSZ_CD, CNTR_NO of EQR_EXE_PLN_CNTR
        String[] cntrTpsz = null;
        String[] cntrNo   = null;
        ArrayList<String> v1 = null;
        ArrayList<String> v2 = null;
        
    	// VVL 
    	String vsl_cd     = null;
    	String skd_voy_no = null;
    	String skd_dir_cd = null;
    	
    	// office code
    	String office_code = null;
        try {        	         
        	        	
			/*
			 *  EAT --> WTC
			 * 
			 */
        	// ---- START

        	
        	if(vos != null && vos.length > 0){
        		for(int k=0; k< vos.length; k++) {
        			EesEqr0080MultiVO vo = vos[k];
        			if(vo.getSoIssFlg().equals("1")) {
        				// ------------ EQR_REPO_EXE_SO_IF INSERT LOGIC ---------------------
    	            	vol     = 0; 
    	            	volList = new ArrayList<String>();
    	            	cntrSeq = 0; // CNTR_SEQ of EQR_EXE_PLN_CNTR
    	            	seq = 1; 	 // REF_SEQ of EQR_REPO_EXE_SO_IF (starting with 1 for each ref_id) 
    	            	v1 = new ArrayList<String>();
    	            	v2 = new ArrayList<String>();
    	            	
    	            	if(vo.getVvd().length() >= 9) {
    	            		vsl_cd     = vo.getVvd().substring(0,4);            	
    	            		skd_voy_no = vo.getVvd().substring(4,8);
    	            		skd_dir_cd = vo.getVvd().substring(8,9);
    	            	}   
    	            	office_code = null;
    	            	for(int m=0; m<tpszArr.length; m++) {
    		            	
    	            		// volum for each type size
    	            		volList = vo.getVolList();
    	            		vol    = Integer.parseInt((String)volList.get(m));	
    	            		EqrExePlnCntrVO eqrExePlnCntrVO = new EqrExePlnCntrVO();
    	            		ObjectCloner.build(vo , eqrExePlnCntrVO );
    	            		eqrExePlnCntrVO.setCntrTpszCd(tpszArr[m]);
    	            		dbRowset = dbDao.searchInlandContainer(eqrExePlnCntrVO).getDbRowset();
    	            		while(dbRowset.next()){
    	            			v1.add(dbRowset.getString("CNTR_TPSZ_CD"));
    	        	        	v2.add(dbRowset.getString("CNTR_NO"));
    	            		}
    	            		cntrTpsz = new String[v1.size()];
    	        	        cntrNo   = new String[v2.size()];
    	        	        
    	        	        for(int v=0; v < v1.size(); v++) {
    	        	        	cntrTpsz[v] = (String)v1.get(v);
    	        	            cntrNo[v]   = (String)v2.get(v);        	            
    	                	}
    	

    	            		// search office code 
    	            		// retrieving for each type size
    	            		// only in case of co_cd = H & type size vol>0, retrieving for office code
    	            		// in case of co_cd = S, not retrieving for office code
    	        	        if( vol > 0) {
    	        	        	//if(vo.getTrspModCd().equals("R") && vo.getFrlocRcc().equals("USNYC") && !"MX".equals(vo.getFrlocEcc().substring(0, 2))) { // USNYC, RAIL = PHXSC except Mexico
    	        	        	//	office_code = "PHXSC";
    	        	        	//}else {
    	        	        		List<CommonVO> target_key_list = new ArrayList<CommonVO>();
    	        	        		CommonVO joinkey = new CommonVO();
    	        	        		joinkey.setField1("REPO_PLN_ID");
    	        	        		joinkey.setField2("REPO_PLN_ID");
    	        	        		target_key_list.add(joinkey);
    	        	        		joinkey = new CommonVO();
    	        	        		joinkey.setField1("PLN_YRWK");
    	        	        		joinkey.setField2("PLN_YRWK");
    	        	        		target_key_list.add(joinkey);
    	        	        		joinkey = new CommonVO();
    	        	        		joinkey.setField1("PLN_SEQ");
    	        	        		joinkey.setField2("PLN_SEQ");
    	        	        		target_key_list.add(joinkey);
    	        	        		joinkey = new CommonVO();
    	        	        		joinkey.setField1("REF_ID");
    	        	        		joinkey.setField2("REF_ID");
    	        	        		target_key_list.add(joinkey);
    	        	        		
    	        	        		office_code = dbDao.searchOfficeCode("EQR_INLND_TRSP_EXE_PLN","EQR_INLND_TRSP_EXE_PLN_QTY",target_key_list , vo.getRepoPlnId(), vo.getPlnYrwk(), vo.getRefId(),vo.getPlnSeq(), tpszArr[m]).getResultString();
    	        	        	//}
    	        	        }else {
    	        	        	office_code = null;
    	        	        }
    	        	        for(int j=0; j<vol; j++) {   
    	        				
    	        	        	EqrRepoExeSoIfVO eqrRepoExeSoIfVO = new EqrRepoExeSoIfVO();
    	        	        	ObjectCloner.build(vo , eqrRepoExeSoIfVO );
    	        	        	eqrRepoExeSoIfVO.setRefSeq((seq++)+"");
    	        	        	eqrRepoExeSoIfVO.setCntrTpszCd(tpszArr[m]);
    	        	        	eqrRepoExeSoIfVO.setSoIfDivCd(vo.getTrspModCd());
    	        	        	eqrRepoExeSoIfVO.setFmDt(vo.getFmEtdDt());
    	        	        	eqrRepoExeSoIfVO.setToDt(vo.getToEtaDt());
    	        	        	eqrRepoExeSoIfVO.setVslCd(vsl_cd);
    	        	        	eqrRepoExeSoIfVO.setSkdVoyNo(skd_voy_no);
    	        	        	eqrRepoExeSoIfVO.setSkdDirCd(skd_dir_cd);

    	        				if(cntrNo.length > 0) {
    	        					if(cntrNo.length > cntrSeq) {
    	        						eqrRepoExeSoIfVO.setCntrNo(cntrNo[cntrSeq++]); // CNTR_NO
    	        					}else{
    	        						eqrRepoExeSoIfVO.setCntrNo("");
    	        					}
    	        				}else{
    	        					eqrRepoExeSoIfVO.setCntrNo("");
    	        				}
    	        				eqrRepoExeSoIfVO.setWoExeFlg("N");
    	        				eqrRepoExeSoIfVO.setEqCtrlOfcCd(office_code);
    	        				eqrRepoExeSoIfVO.setSoRqstDt(vo.getFmEtdDt());
    	        				eqrRepoExeSoIfVO.setWoRqstFlg("Y");
    	        				eqrRepoExeSoIfVO.setTrspSoStsCd("P");
    	        				
    	        				dbDao.createInlandSoData(eqrRepoExeSoIfVO,user_id);
    	        				
    	        	        }    	        	        
    	            	}    	            		
        			}
        		}
        	}
        	// ----- END        	
        	
        } catch (Exception de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }
    }	    
    /**
	 * canceling sending truck and rail and barge CNTR repo plan
	 *          
     * @param conditionVO	EesEqr0059ConditionVO
     * @param vos			EesEqr0080MultiVO[]
     * @param account		SignOnUserAccount
     * @exception EventException
     */
    public void soCancelTruckAndRailAndBargeCntrRepoPlan(EesEqr0059ConditionVO conditionVO ,EesEqr0080MultiVO[] vos , SignOnUserAccount account) throws EventException {
    	String user_id = account.getUsr_id(); // user id information
    	String exeFlag = "N";
    	try
		{
    		//dbDao.soCancelTruckAndRailAndBargeCntrRepoPlan(event, userId);  
    		if(vos != null && vos.length > 0) {
	    		for(int i = 0 ; i < vos.length ; i++ ){
	    			EesEqr0080MultiVO vo = vos[i];
	    			// only in case of SO SEND checked && SO CANCEL='T', removing
	            	if(vo.getSoIssFlg().equals("1") && vo.getSoCancelFlag().equals("T")) {    
	            	
	            		// in case of exeFlag = "Y", removing 3 tables in order..
	            		exeFlag = dbDao.soCancelCheckCntrRepoPlan(vo.getRepoPlnId(), vo.getPlnYrwk(), vo.getPlnSeq() , vo.getRefId()).getResultString();
	            		if(exeFlag.equals("Y")) {
	            			
	            			// --- EQR_REPO_EXE_SO_IF  DELETE -------------------------------
	            			EqrRepoExeSoIfVO eqrRepoExeSoIfVO = new EqrRepoExeSoIfVO();
	        	        	ObjectCloner.build(vo , eqrRepoExeSoIfVO );
	        	        	
	        	        	dbDao.deleteInlandSoData(eqrRepoExeSoIfVO);

	        	        	
	               	   		// --- initailizing EQR_INLND_TRSP_EXE_PLN  SO FLAG -------------------- not initailizing EXE_RQST_DT
	        	        	EqrInlndTrspExePlnVO eqrInlndTrspExePlnVO = new EqrInlndTrspExePlnVO();
	        	        	ObjectCloner.build(vo , eqrInlndTrspExePlnVO );
	        	        	dbDao.updateInitInlandExecute(eqrInlndTrspExePlnVO, user_id);
	        	        		               	   		
	               	   		// --- EQR_EXE_PLN_CNTR   DELETE(only in case of existing WATER, BKG NO) -- 
	               	   		if(vo.getTrspModCd().equals("W") && vo.getRepoMtyBkgFlg().equals("1")) {
	               	   			
	               	   			EqrExePlnCntrVO eqrExePlnCntrVO = new EqrExePlnCntrVO();
	               	   			ObjectCloner.build(vo , eqrExePlnCntrVO );
	               	   			dbDao.deleteInlandCntr(eqrExePlnCntrVO);
	               	   		}
	               	   		
	                	}else {
	                		throw new DAOException(new ErrorHandler("EQR10027").getMessage());
	                	}  
	            	}
	    		}
    		}
    		
    		
		} catch (Exception de) {
	        log.error("err "+de.toString(),de);
	        throw new EventException(de.getMessage());
	    }
    }
	/**
	 * saving combin execution<br>
	 * 
	 * @param conditionVO	EesEqr0108ConditionVO
	 * @param vos			EesEqr0108MultiVO[]
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyCombineExecution(EesEqr0108ConditionVO conditionVO ,EesEqr0108MultiVO[] vos , SignOnUserAccount account) throws EventException
	{
		String repo_pln_id = conditionVO.getRepoPlanId();   // repo plan id			
		String tab = conditionVO.getTab();                  // 1: vessel, 2: truck
		try
		{
			String user_id = account.getUsr_id();
			String tpszType = conditionVO.getTpsztype();
			String[] tpszArr= tpszType.split(",");
			
			String ref_id_new = "";	 // ref_id
			String combin_ref_id = ""; // VESSEL, INLAND  REF_ID to insert EQR_ECC_INTER_EXE_PLN
            
            List<String> volList 	 = null;
        	int vol          = 0;    // volum for each type size

        	// VVL 분리
        	String vsl_cd     = "";
        	String skd_voy_no = "";
        	String skd_dir_cd = "";

        	String fromInterYard = null;  // ECC INTERNAL FROM YARD
        	String toInterYard   = null;  // ECC INTERNAL TO YARD
        	String fromInterDt   = null;  // ECC INTERNAL FROM DT
        	String toInterDt     = null;  // ECC INTERNAL TO DT
        	
        	String fromYard      = null;  // FROM YARD(VESSEL, TRUCK)
        	String toYard        = null;  // TO YARD(VESSEL, TRUCK)
        	String fromDt        = null;  // FROM DT(VESSEL, TRUCK)
        	String toDt          = null;  // TO DT(VESSEL, TRUCK)

        	//List amtList        = null;
	    	List<String> unitcostList 	= null;
	    	List<String> fromcostList 	= null;
	    	List<String> tocostList   	= null;	
			//float amt      = 0;
	    	float unitcost = 0;
	    	float fromcost = 0;
	    	float tocost   = 0;
	    	
	    	String[] tableCost = null;
	    	
	    	for(int k = 0 ; k < vos.length ; k++){
	    		EesEqr0108MultiVO vo = vos[k];
	    		vol     = 0; 
            	volList = new ArrayList<String>();

	        	unitcostList = new ArrayList<String>();
	        	fromcostList = new ArrayList<String>();
	        	tocostList   = new ArrayList<String>();
	        	
	        	unitcost     = 0;
	        	fromcost     = 0;
	        	tocost       = 0;
	        	
	        	tableCost = null;	  
	        	if(vo.getIbflag().equals("I")) {

                	// compare ECC1, ECC2, ECC3
                	// ECC are different,  ECC INTERNAL
                	// ECC are differnet and TAB : 1 - VESSEL
                	//                       TAB : 2 - TRUCK
                	
                	if(vo.getEcc1().equals(vo.getEcc2())) {
                		fromInterYard = vo.getYdCd1();//yd1[k];
                		toInterYard   = vo.getYdCd2();//yd2[k];
                		fromInterDt   = vo.getDt1().replaceAll("-", "").substring(0,8);
                		toInterDt     = vo.getDt2().replaceAll("-", "").substring(0,8);
                		
                		// VESSEL, TRUCK
                		fromYard      = vo.getYdCd2();
                		toYard        = vo.getYdCd3();
                		fromDt        = vo.getDt2();
                		toDt          = vo.getDt3();
                		
                	}else if(vo.getEcc2().equals(vo.getEcc3())) {
                		fromInterYard = vo.getYdCd2();
                		toInterYard   = vo.getYdCd3();
                		fromInterDt   = vo.getDt2().replaceAll("-", "").substring(0,8);
                		toInterDt     = vo.getDt3().replaceAll("-", "").substring(0,8);
                		
                		//  VESSEL, TRUCK
                		fromYard      = vo.getYdCd1();
                		toYard        = vo.getYdCd2();
                		fromDt        = vo.getDt1();
                		toDt          = vo.getDt2();                	
                	}
 
                	if(vo.getVvd().length() >= 9) {
                		vsl_cd     = vo.getVvd().substring(0,4);            	
                		skd_voy_no = vo.getVvd().substring(4,8);
                		skd_dir_cd = vo.getVvd().substring(8,9);
                	}
                	// ---- VESSEL (START) ---------------------------------------------
                	if(tab.equals("1")) {  		// VESSEL
                   	    // creating ref_id	
                		if(fromYard != null) {
                			ref_id_new = dbDao.makeRefIDCntrRepoPlan("EQR_VSL_LODG_DCHG_EXE_PLN", vo.getCoCd(), repo_pln_id, fromYard, "V");
                		}
                   	    combin_ref_id = ref_id_new;
                   	    EqrVslLodgDchgExePlnVO eqrVslLodgDchgExePlnVO = new EqrVslLodgDchgExePlnVO();
                   	    
                   	    ObjectCloner.build(vo , eqrVslLodgDchgExePlnVO );
                   	    eqrVslLodgDchgExePlnVO.setRepoPlnId(repo_pln_id);
                   	    eqrVslLodgDchgExePlnVO.setRefId(ref_id_new);
                   	    eqrVslLodgDchgExePlnVO.setTrspModCd(vo.getTrspMode());
                   	    eqrVslLodgDchgExePlnVO.setVslLaneCd(vo.getLane());
                   	    eqrVslLodgDchgExePlnVO.setVslCd(vsl_cd);
	                   	eqrVslLodgDchgExePlnVO.setSkdVoyNo(skd_voy_no);
	                   	eqrVslLodgDchgExePlnVO.setSkdDirCd(skd_dir_cd);
	                   	if(fromYard != null) eqrVslLodgDchgExePlnVO.setFmYdCd(fromYard);
	                   	if(fromDt != null) eqrVslLodgDchgExePlnVO.setFmEtdDt(fromDt);
	                   	if(toYard != null) eqrVslLodgDchgExePlnVO.setToYdCd(toYard);
	                   	if(toDt != null) eqrVslLodgDchgExePlnVO.setToEtbDt(toDt);
	                   	eqrVslLodgDchgExePlnVO.setSplitRepoPlnFlg("N");
	                   	eqrVslLodgDchgExePlnVO.setPastRepoPlnFlg("N");
	                   	
                   	    dbDao.insertCombineExecutionVessel(eqrVslLodgDchgExePlnVO, user_id); // inserting EQR_VSL_LODG_DCHG_EXE_PLN
                   	    
                   	    for(int m=0; m<tpszArr.length; m++) {
 				    	
	 				    	// volum for each type size
                   	    	volList = vo.getVolList();
	 				       	vol    = Integer.parseInt((String)volList.get(m));		
	 				       
	 				    	//amtList		= vo.getAmtList();
	 				    	unitcostList= vo.getUnitcostList();
	 				    	fromcostList= vo.getFromcostList();
	 				    	tocostList	= vo.getTocostList();
	 				    	//amt         = Float.parseFloat((String)amtList.get(m));	
	 				       	unitcost    = Float.parseFloat((String)unitcostList.get(m));	
	 				       	fromcost    = Float.parseFloat((String)fromcostList.get(m));	
	 				       	tocost      = Float.parseFloat((String)tocostList.get(m));	
	 				       	
	 				       	// in case of unit cost doesn't exist, retirevie for unit cost, from cost, to cost 
	 				       	if(unitcost==0) {
	 				       		if(fromYard != null && toYard != null) {
	 				       			tableCost = dbDao.searchUnitCost("E", fromYard, toYard, vo.getTrspMode(), tpszArr[m]).getResultStrArray();
	 				       		}
	 				       		
	 				       		fromcost = Float.parseFloat(tableCost[0]);
	 				       		tocost   = Float.parseFloat(tableCost[1]);
	 				       		unitcost = Float.parseFloat(tableCost[2]);	
	 				       	}
                  	    	
	 				       	EqrVslExePlnQtyVO eqrVslExePlnQtyVO = new EqrVslExePlnQtyVO();
	 				       	ObjectCloner.build(vo , eqrVslExePlnQtyVO );
	 				       	eqrVslExePlnQtyVO.setRepoPlnId(repo_pln_id);
	 				       	eqrVslExePlnQtyVO.setRefId(ref_id_new);
	 				       	eqrVslExePlnQtyVO.setCntrTpszCd(tpszArr[m]);
	 				       	eqrVslExePlnQtyVO.setCntrQty(vol+"");
	 				       	eqrVslExePlnQtyVO.setPlnUcAmt(unitcost+"");
	 				       	eqrVslExePlnQtyVO.setLodgPortUcAmt(fromcost+"");
	 				       	eqrVslExePlnQtyVO.setDchgPortUcAmt(tocost+"");
	 				       	eqrVslExePlnQtyVO.setLodgDchgCostAmt((vol * unitcost) +"");
	 				       	dbDao.insertCombineExecutionVesselQty(eqrVslExePlnQtyVO, user_id); // inserting EQR_VSL_LODG_DCHG_EXE_PLN_QTY
                   	    }
                   	    // inserting EQR_EXE_PLN_CNTR
                		if(vo.getCntrno()!=null && !vo.getCntrno().trim().equals("")) {
                			EqrExePlnCntrVO eqrExePlnCntrVO = new EqrExePlnCntrVO();
                			ObjectCloner.build(vo , eqrExePlnCntrVO );
                			eqrExePlnCntrVO.setRepoPlnId(repo_pln_id);
                			eqrExePlnCntrVO.setRefId(ref_id_new);
                			eqrExePlnCntrVO.setCntrTpszCd(vo.getTpszno());
                			eqrExePlnCntrVO.setTrspModCd(vo.getTrspMode());
                			eqrExePlnCntrVO.setCntrNo(vo.getCntrno());
                			eqrExePlnCntrVO.setFmEccCd(vo.getEcc1());
                			eqrExePlnCntrVO.setToEccCd(vo.getEcc3());
                			dbDao.modifyCntrRepoPlanDetail("I", eqrExePlnCntrVO, user_id);			         		
        				}  
                	// ---- TRUCK (START) ---------------------------------------------	
                	}else if(tab.equals("2")) { // TRUCK
                		 if(fromYard != null) {
                			 ref_id_new = dbDao.makeRefIDCntrRepoPlan("EQR_INLND_TRSP_EXE_PLN", vo.getCoCd(), repo_pln_id, fromYard, vo.getTrspMode());
                		 }
                    	 combin_ref_id = ref_id_new;
                    	 
	                	 EqrInlndTrspExePlnVO eqrInlndTrspExePlnVO = new EqrInlndTrspExePlnVO();
	                	 ObjectCloner.build(vo , eqrInlndTrspExePlnVO );
	                	 eqrInlndTrspExePlnVO.setRepoPlnId(repo_pln_id);	                	 
	                	 eqrInlndTrspExePlnVO.setRefId(ref_id_new);
	                	 eqrInlndTrspExePlnVO.setTrspModCd(vo.getTrspMode());
	                	 eqrInlndTrspExePlnVO.setVslLaneCd(vo.getLane());
	                	 eqrInlndTrspExePlnVO.setVslCd(vsl_cd);
	                	 eqrInlndTrspExePlnVO.setSkdVoyNo(skd_voy_no);
	                	 eqrInlndTrspExePlnVO.setSkdDirCd(skd_dir_cd);
	                	 if(fromYard != null) eqrInlndTrspExePlnVO.setFmYdCd(fromYard);
	                	 if(fromDt != null) eqrInlndTrspExePlnVO.setFmEtdDt(fromDt);
	                	 if(toYard != null) eqrInlndTrspExePlnVO.setToYdCd(toYard);
	                	 if(toDt != null) eqrInlndTrspExePlnVO.setToEtaDt(toDt);
	                	 eqrInlndTrspExePlnVO.setPastRepoPlnFlg("N");  // in case of past repo plan falg --> combined, 'N'
                	     	
	                	 dbDao.insertInlandExecute(eqrInlndTrspExePlnVO,user_id);  // same thing called by modifyTruckAndRailAndBargeCntrRepoPlan
                    	 
                    	 for(int m=0; m<tpszArr.length; m++) {
     				    	
                    		 // volum for each type size
                    		 volList = vo.getVolList();
                    		 vol    = Integer.parseInt((String)volList.get(m));	
                    		 
                    		 //amtList = vo.getAmtList();
                    		 unitcostList = vo.getUnitcostList();
                    		 fromcostList = vo.getFromcostList();
                    		 tocostList	  = vo.getTocostList();
                    		 //amt         = Float.parseFloat((String)amtList.get(m));	
                    		 unitcost    = Float.parseFloat((String)unitcostList.get(m));	
                    		 fromcost    = Float.parseFloat((String)fromcostList.get(m));	
                    		 tocost      = Float.parseFloat((String)tocostList.get(m));	
							
                    		 // in case of unit cost doesn't exist, retirevie for unit cost, from cost, to cost 
                    		 if(unitcost==0) {
                    			 if(fromYard != null && toYard != null) {
                    				 tableCost = dbDao.searchUnitCost("E", fromYard, toYard, vo.getTrspMode(), tpszArr[m]).getResultStrArray();
                    			 }
							
                    			 fromcost = Float.parseFloat(tableCost[0]);
                    			 tocost   = Float.parseFloat(tableCost[1]);
                    			 unitcost = Float.parseFloat(tableCost[2]);	    				       		
                    		 }
                    		 EqrInlndTrspExePlnQtyVO eqrInlndTrspExePlnQtyVO = new EqrInlndTrspExePlnQtyVO();
                    		 ObjectCloner.build(vo , eqrInlndTrspExePlnQtyVO );
                    		 eqrInlndTrspExePlnQtyVO.setRepoPlnId(repo_pln_id);
                    		 eqrInlndTrspExePlnQtyVO.setRefId(ref_id_new);
                    		 eqrInlndTrspExePlnQtyVO.setCntrTpszCd(tpszArr[m]); 
                    		 eqrInlndTrspExePlnQtyVO.setCntrQty(vol+"");
                    		 eqrInlndTrspExePlnQtyVO.setTrspCostAmt((vol * unitcost)+"");
                    		 eqrInlndTrspExePlnQtyVO.setPlnUcAmt(unitcost+"");
                    		 eqrInlndTrspExePlnQtyVO.setFmEccUcAmt(fromcost+"");
                    		 eqrInlndTrspExePlnQtyVO.setToEccUcAmt(tocost+"");
	                		
                    		 dbDao.insertInlandExecuteQty(eqrInlndTrspExePlnQtyVO,user_id);  // inserting EQR_INLND_TRSP_EXE_PLN_QTY	
                    		 
                    	 }
                    	// inserting EQR_EXE_PLN_CNTR
                 		if(vo.getCntrno()!=null && !vo.getCntrno().trim().equals("")) {
                 			EqrExePlnCntrVO eqrExePlnCntrVO = new EqrExePlnCntrVO();
                			ObjectCloner.build(vo , eqrExePlnCntrVO );
                			eqrExePlnCntrVO.setRepoPlnId(repo_pln_id);
                			eqrExePlnCntrVO.setRefId(ref_id_new);
                			eqrExePlnCntrVO.setCntrTpszCd(vo.getTpszno());
                			eqrExePlnCntrVO.setTrspModCd(vo.getTrspMode());
                			eqrExePlnCntrVO.setCntrNo(vo.getCntrno());
                			eqrExePlnCntrVO.setFmEccCd(vo.getEcc1());
                			eqrExePlnCntrVO.setToEccCd(vo.getEcc3());
                			dbDao.modifyCntrRepoPlanDetail("I", eqrExePlnCntrVO, user_id);	
         				}
                	}
                	// ---- ECC INTERNAL (START) ---------------------------------------------
               	    // creating ref_id	           	    	
                	if(fromInterYard != null) {
                		ref_id_new = dbDao.makeRefIDCntrRepoPlan("EQR_ECC_INTER_EXE_PLN", vo.getCoCd(), repo_pln_id, fromInterYard, "S");
                	}
               	    EqrEccInterExePlnVO eqrEccInterExePlnVO = new EqrEccInterExePlnVO();
               	    ObjectCloner.build(vo , eqrEccInterExePlnVO );
               	    eqrEccInterExePlnVO.setRepoPlnId(repo_pln_id);
               	    eqrEccInterExePlnVO.setRefId(ref_id_new);
               	    eqrEccInterExePlnVO.setCmbRefId(combin_ref_id);
           	    	// in case of COMBINED EXE,  'T'(TRUCK)
               	    eqrEccInterExePlnVO.setTrspModCd("T");
               	    
               	    if(fromInterYard != null) eqrEccInterExePlnVO.setFmYdCd(fromInterYard);
               	    if(fromInterDt != null) eqrEccInterExePlnVO.setFmEtdDt(fromInterDt);
               	    if(toInterYard != null) eqrEccInterExePlnVO.setToYdCd(toInterYard);
               	    if(toInterDt != null) eqrEccInterExePlnVO.setToEtaDt(toInterDt);
               	    
               	    
               	    dbDao.insertCombineExecutionInternal(eqrEccInterExePlnVO, user_id); // inserting EQR_ECC_INTER_EXE_PLN
               	    
               	    for(int m=0; m<tpszArr.length; m++) {
				    	
				    	// volum for each type size
               			volList = vo.getVolList();
				       	vol    = Integer.parseInt((String)volList.get(m));	

				       	// in case of unit cost doesn't exist, retirevie for unit cost, from cost, to cost 
				       	if(fromInterYard != null && toInterYard != null) {
				       		tableCost = dbDao.searchUnitCost("I", fromInterYard, toInterYard, "T", tpszArr[m]).getResultStrArray();
				       	}
				       		
				       	unitcost = Float.parseFloat(tableCost[2]);	 
				       	EqrEccInterExePlnQtyVO eqrEccInterExePlnQtyVO = new EqrEccInterExePlnQtyVO();
				       	ObjectCloner.build(vo , eqrEccInterExePlnQtyVO );
				       	eqrEccInterExePlnQtyVO.setCntrTpszCd(tpszArr[m]);
				       	eqrEccInterExePlnQtyVO.setRepoPlnId(repo_pln_id);
				       	eqrEccInterExePlnQtyVO.setRefId(ref_id_new);
				       	eqrEccInterExePlnQtyVO.setCntrQty(vol+"");
				       	eqrEccInterExePlnQtyVO.setTrspCostAmt((vol * unitcost)+"");
				       	dbDao.insertCombineExecutionInternalQty(eqrEccInterExePlnQtyVO, user_id); // inserting EQR_ECC_INTER_EXE_PLN_QTY
               	    }
				    // in case of COMBINED INSERT, inserting CNTR NO to REF_ID on ECC INTERNAL
            		// inserting EQR_EXE_PLN_CNTR
            		if(vo.getCntrno()!=null && !vo.getCntrno().trim().equals("")) {
            			EqrExePlnCntrVO eqrExePlnCntrVO = new EqrExePlnCntrVO();
            			ObjectCloner.build(vo , eqrExePlnCntrVO );
            			eqrExePlnCntrVO.setRepoPlnId(repo_pln_id);
            			eqrExePlnCntrVO.setRefId(ref_id_new);
            			eqrExePlnCntrVO.setCntrTpszCd(vo.getTpszno());
            			eqrExePlnCntrVO.setTrspModCd(vo.getTrspMode());
            			eqrExePlnCntrVO.setCntrNo(vo.getCntrno());
            			eqrExePlnCntrVO.setFmEccCd("XXXXX");
            			eqrExePlnCntrVO.setToEccCd("XXXXX");
            			// Add By 이병훈(2010.04.09)
            			eqrExePlnCntrVO.setPlnSeq("0");
            			dbDao.modifyCntrRepoPlanDetail("I", eqrExePlnCntrVO, user_id);
    				}  				    

                	// ---- ECC INTERNAL (END) ---------------------------------------------
	        	} // ibflag I                   	    
	    	}
	    } catch (Exception de) {
	        log.error("err "+de.toString(),de);
	        throw new EventException(de.getMessage());
	    }
	}
	
	/**
	 * [ EES_EQR_0130 : BKG Split Create]<br>
	 * retrieving for CNTR repo exection plan bkg no. info.
	 * @param String bkg_no
	 * @return List<SearchExecutionPlanBkgNoVO>
	 * @exception EventException
	 */
	public List<SearchExecutionPlanBkgNoVO> searchCntrRepoExecutionPlanBkgNoInfo(String bkg_no) throws EventException {
		try {
			return dbDao.searchCntrRepoExecutionPlanBkgNoInfo(bkg_no);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	/**
	 * [ EES_EQR_0130 : BKG Split Create - Container List] <br>
	 * retrieving for CNTR repo exection plan aplit CNTR list
	 * @param eesEqr0130ConditionVO EesEqr0130ConditionVO
	 * @return List<SearchExecutionPlanSplitCntrVO>
	 * @exception EventException
	 */
	public List<SearchExecutionPlanSplitCntrVO> searchCntrRepoExecutionPlanSplitCntrList(EesEqr0130ConditionVO eesEqr0130ConditionVO) throws EventException {
		try {
			return dbDao.searchCntrRepoExecutionPlanSplitCntrList(eesEqr0130ConditionVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * [ EES_EQR_0139 : EQR Organization Chart - Default ] <br>
	 * retrieving for EQR Oragnization cart count
	 * @return List<SearchExecutionPlanBkgNoVO>
	 * @exception EventException
	 */
	public SearchEqrOrganizationVO searchEqrOrganizationChartCount() throws EventException {
		try {
			return dbDao.searchEqrOrganizationChartCount();
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * [ EES_EQR_0139 : EQR Organization Chart - List ] <br>
	 * retrieving for EQR organization chart
	 * @return List<SearchEqrOrganizationVO>
	 * @exception EventException
	 */
	public List<SearchEqrOrganizationVO> searchEqrOrganizationChart() throws EventException {
		try {
			return dbDao.searchEqrOrganizationChart();
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	

    /**
     * saving for on hire and off hire CNTR repo plan<br>
     * 
     * @param eesEqr0059ConditionVO EesEqr0059ConditionVO
	 * @param vos EesEqr0081MultiVO[]
	 * @param account SignOnUserAccount 
     * @exception EventException
     */
	public void modifyOnHireAndOffHireCntrRepoPlan(EesEqr0059ConditionVO eesEqr0059ConditionVO ,EesEqr0081MultiVO[] vos , SignOnUserAccount account) throws EventException {
		
		String tpszType = eesEqr0059ConditionVO.getTpsztype();
		String[] tpszArrInitial = eesEqr0059ConditionVO.getTpszInitial().split(","); // only using in add plan
		String[] tpszArr= tpszType.split(",");
		String user_id	= account.getUsr_id();
		
		String ref_id_new = "";	 // ref_id
								
		int rowCount = (vos==null) ? 0 : vos.length;                            
        
        List<String> volList 	 = null;
    	int vol          = 0;    // volum for each type size
    	
    	List<String> flagList	 = null;
    	String flag      = "";

        List<String> amtList 	 = null;
    	float amt        = 0;    // amount of each type size
    	
    	List<String> unitcostList 	= null;
    	float unitcost = 0;

    	String[] tableCost = null;
    	String soFlag = eesEqr0059ConditionVO.getSoFlag();
    	try{
    		CommonDBDAO commondbDao = new CommonDBDAO(); 
    		
	    	for(int k=0; k<rowCount; k++) {
	    		EesEqr0081MultiVO vo = vos[k];
	    		vol     = 0; 
	        	volList = new ArrayList<String>();
	
	        	amt     = 0; 
	        	amtList = new ArrayList<String>();
	        	
	        	unitcostList = new ArrayList<String>();
	        	unitcost     = 0;
	        	
	        	flagList = new ArrayList<String>(); 
	        	flag     = "";           
	        	
	        	tableCost = null;
	            
				if(vo.getTrspModCd().equals("F")) vo.setTolocEcc("XXXXX");
				else                              vo.setFrlocEcc("XXXXX");
				if(vo.getIbflag().equals("I")) { // in case of PLAN
	            	if(vo.getDiv().equals("Plan")) {
	            		if(dbDao.onOffHireInsertCheck(vo.getRepoPlnId(), vo.getPlnYrwk(), vo.getTrspModCd(), vo.getFmYdCd(), vo.getLeaseTerm())) {
	            			
	            			// InsertOnOffHirePlan
	            			String plnSeq = commondbDao.getNextPlnSeq("EQR_ONF_HIR_PLN", vo.getRepoPlnId(), vo.getPlnYrwk()).getResultString(); // creating pln_seq
	            			EqrOnfHirPlnVO eqrOnfHirPlnVO = new EqrOnfHirPlnVO();
	            			ObjectCloner.build(vo , eqrOnfHirPlnVO );
	            			eqrOnfHirPlnVO.setPlnSeq(plnSeq);
	            			eqrOnfHirPlnVO.setOnfHirDivCd(vo.getTrspModCd());
	            			eqrOnfHirPlnVO.setEccCd(vo.getFmYdCd());
	            			eqrOnfHirPlnVO.setCntrLstmCd(vo.getLeaseTerm()); // default "XX"
	            			dbDao.insertOnOffHirePlan(eqrOnfHirPlnVO, user_id);
	            			
	            			for(int m=0; m<tpszArrInitial.length; m++) {
	            				volList = vo.getVolList();
	            				vol    = Integer.parseInt((String)volList.get(m));
	            				
        				       	// in case of unit cost doesn't exist, retirevie for unit cost, from cost, to cost 
        				       	tableCost = dbDao.searchUnitCost("P", vo.getFmYdCd(), vo.getToYdCd(),vo.getTrspModCd(), tpszArrInitial[m]).getResultStrArray();
        				       	// tpszArr[m] - > tpszArrInitial[m] 로 변경함 modify by ChungEunHo 09.10.19
        				       	unitcost = Float.parseFloat(tableCost[2]);	
        				       	
        				       	EqrOnfHirPlnQtyVO eqrOnfHirPlnQtyVO = new EqrOnfHirPlnQtyVO();
        				       	ObjectCloner.build(vo , eqrOnfHirPlnQtyVO );
        				       	eqrOnfHirPlnQtyVO.setPlnSeq(plnSeq);
        				       	eqrOnfHirPlnQtyVO.setCntrQty(String.valueOf(vol));
        				       //	eqrOnfHirPlnQtyVO.setCntrQty("0");
        				       	eqrOnfHirPlnQtyVO.setCntrTpszCd(tpszArrInitial[m]);
        				       	eqrOnfHirPlnQtyVO.setPlnUcAmt(unitcost+"");
        				       	dbDao.insertOnOffHirePlanQty(eqrOnfHirPlnQtyVO, user_id);
	            			}
	            		}else {
                			String line = Integer.toString(k+1);
                			String[] errMessage ={line, vo.getPlnYrwk()+","+ vo.getFmYdCd()};
                			throw new DAOException(new ErrorHandler("EQR10025", errMessage).getMessage());
                		}
	            	}else {  // inserting EXECUTE 
	            		
	            		ref_id_new = dbDao.makeRefIDCntrRepoPlan("EQR_ONF_HIR_EXE_PLN", vo.getCoCd(), vo.getRepoPlnId(), vo.getFmYdCd(), vo.getTrspModCd());
	            		EqrOnfHirExePlnVO eqrOnfHirExePlnVO = new EqrOnfHirExePlnVO();
	            		ObjectCloner.build(vo , eqrOnfHirExePlnVO );
	            		eqrOnfHirExePlnVO.setRefId(ref_id_new);
	            		eqrOnfHirExePlnVO.setOnfHirDivCd(vo.getTrspModCd());
	            		dbDao.insertOnOffHireExecute(eqrOnfHirExePlnVO, user_id);
	            		
	            		for(int m=0; m<tpszArr.length; m++) {
	            			// volum for each type size
	            			volList = vo.getVolList();
				       		vol    = Integer.parseInt((String)volList.get(m));	
				       		
					    	// amount of each type size
				       		amtList = vo.getCostList();
					       	amt   = Float.parseFloat((String)amtList.get(m));					       		

    				       	// unit cost, from cost, to cost of each type size
					       	unitcostList = vo.getUnitcostList();
    				       	unitcost    = Float.parseFloat((String)unitcostList.get(m));	

    				       	// in case of unit cost doesn't exist, retirevie for unit cost, from cost, to cost 
    				       	if(unitcost==0) {
    				       		tableCost = dbDao.searchUnitCost("E", vo.getFmYdCd(), vo.getToYdCd(), vo.getTrspModCd(), tpszArr[m]).getResultStrArray();
    				       		
    				       		unitcost = Float.parseFloat(tableCost[2]);	    				       		
 
    				       	}
    				       	
	            			EqrOnfHirExePlnQtyVO eqrOnfHirExePlnQtyVO = new EqrOnfHirExePlnQtyVO();
	            			ObjectCloner.build(vo , eqrOnfHirExePlnQtyVO );
	            			eqrOnfHirExePlnQtyVO.setRefId(ref_id_new);
	            			eqrOnfHirExePlnQtyVO.setCntrTpszCd(tpszArr[m]);
	            			eqrOnfHirExePlnQtyVO.setCntrQty(vol+"");
	            			eqrOnfHirExePlnQtyVO.setOnfHirCostAmt((vol * unitcost)+"");
	            			eqrOnfHirExePlnQtyVO.setPlnUcAmt(unitcost+"");
	            			dbDao.insertOnOffHireExecuteQty(eqrOnfHirExePlnQtyVO, user_id);
	            		}
	            		// inserting EQR_EXE_PLN_CNTR
                		if(vo.getCntrno()!=null && !vo.getCntrno().trim().equals("")) {
                			EqrExePlnCntrVO eqrExePlnCntrVO = new EqrExePlnCntrVO();
                			ObjectCloner.build(vo , eqrExePlnCntrVO );
                			eqrExePlnCntrVO.setRefId(ref_id_new);
                			eqrExePlnCntrVO.setCntrTpszCd(vo.getTpszno());
                			eqrExePlnCntrVO.setTrspModCd(vo.getTrspModCd());
                			eqrExePlnCntrVO.setCntrNo(vo.getCntrno());
                			eqrExePlnCntrVO.setFmEccCd(vo.getFrlocEcc());
                			eqrExePlnCntrVO.setToEccCd(vo.getTolocEcc());
                			dbDao.modifyCntrRepoPlanDetail("I", eqrExePlnCntrVO, user_id);
                							         		
    					}   
	            	  }
	            
				}else if(vo.getIbflag().equals("U")) {
					if(vo.getDiv().equals("Plan")) {  // inserting Plan
	            		if(dbDao.onOffHireInsertCheck(vo.getRepoPlnId(), vo.getPlnYrwk(), vo.getTrspModCd(), vo.getFmYdCd(), vo.getLeaseTerm())) {
	            			
	            			// InsertOnOffHirePlan
	            			String plnSeq = commondbDao.getNextPlnSeq("EQR_ONF_HIR_PLN", vo.getRepoPlnId(), vo.getPlnYrwk()).getResultString(); // creating pln_seq
	            			EqrOnfHirPlnVO eqrOnfHirPlnVO = new EqrOnfHirPlnVO();
	            			ObjectCloner.build(vo , eqrOnfHirPlnVO );
	            			eqrOnfHirPlnVO.setPlnSeq(plnSeq);
	            			eqrOnfHirPlnVO.setOnfHirDivCd(vo.getTrspModCd());
	            			eqrOnfHirPlnVO.setEccCd(vo.getFmYdCd());
	            			eqrOnfHirPlnVO.setCntrLstmCd(vo.getLeaseTerm()); // default "XX" 
	            			dbDao.insertOnOffHirePlan(eqrOnfHirPlnVO, user_id);
	            			
	            			for(int m=0; m<tpszArrInitial.length; m++) {
	            				volList = vo.getVolList();
	            				vol    = Integer.parseInt((String)volList.get(m));
	            				
        				       	// in case of unit cost doesn't exist, retirevie for unit cost, from cost, to cost 
        				       	tableCost = dbDao.searchUnitCost("P", vo.getFmYdCd(), vo.getToYdCd(),vo.getTrspModCd(), tpszArrInitial[m]).getResultStrArray();
        				       	// tpszArr[m] - > tpszArrInitial[m] 
        				       	unitcost = Float.parseFloat(tableCost[2]);	
        				       	
        				       	EqrOnfHirPlnQtyVO eqrOnfHirPlnQtyVO = new EqrOnfHirPlnQtyVO();
        				       	ObjectCloner.build(vo , eqrOnfHirPlnQtyVO );
        				       	eqrOnfHirPlnQtyVO.setPlnSeq(plnSeq);
        				       	eqrOnfHirPlnQtyVO.setCntrQty(String.valueOf(vol));
        				       //	eqrOnfHirPlnQtyVO.setCntrQty("0");
        				       	eqrOnfHirPlnQtyVO.setCntrTpszCd(tpszArrInitial[m]);
        				       	eqrOnfHirPlnQtyVO.setPlnUcAmt(unitcost+"");
        				       	dbDao.insertOnOffHirePlanQty(eqrOnfHirPlnQtyVO, user_id);
	            			}
	            		}else {
                			String line = Integer.toString(k+1);
                			String[] errMessage ={line, vo.getPlnYrwk()+","+ vo.getFmYdCd()};
                			throw new DAOException(new ErrorHandler("EQR10025", errMessage).getMessage());
                		}
	            	}else {
					// -- MERGE  EQR_ONF_HIR_EXE_PLN_QTY ----------------------------------  	                    	 
				    for(int m=0; m<tpszArr.length; m++) {				    	
				    	// volum for each type size
				    	volList = vo.getVolList();
				       	vol    = Integer.parseInt((String)volList.get(m));	

				    	// amount of each type size
				       	amtList = vo.getCostList();
				       	amt   = Float.parseFloat((String)amtList.get(m));	
				       	
				       	// flag (T, F)
				       	flagList = vo.getFlagList();
				       	flag  = (String)flagList.get(m);	// flag
						
						if(flag.equals("T")) {
							
    				       	// in case of unit cost doesn't exist, retirevie for unit cost, from cost, to cost 
    				       	if(unitcost==0) {
    				       		tableCost = dbDao.searchUnitCost("E", vo.getFmYdCd(), vo.getToYdCd(), vo.getTrspModCd(), tpszArr[m]).getResultStrArray();    				       		
    				       		unitcost = Float.parseFloat(tableCost[2]);	    		
    				       	}
    				       	
    				       	EqrOnfHirExePlnQtyVO eqrOnfHirExePlnQtyVO = new EqrOnfHirExePlnQtyVO();
    				       	ObjectCloner.build(vo , eqrOnfHirExePlnQtyVO );
    				       	eqrOnfHirExePlnQtyVO.setCntrTpszCd(tpszArr[m]);
    				       	eqrOnfHirExePlnQtyVO.setCntrQty(vol+"");
    				       	eqrOnfHirExePlnQtyVO.setOnfHirCostAmtUpdate(amt+"");
    				       	eqrOnfHirExePlnQtyVO.setPlnUcAmt(unitcost+"");
    				       	eqrOnfHirExePlnQtyVO.setOnfHirCostAmtInsert((vol * unitcost)+"");
    				       	
    				       	dbDao.mergeOnOffHireExecuteQty(eqrOnfHirExePlnQtyVO , user_id);
    				       	
						}
						
				    }
				    // modifying EQR_ONF_HIR_EXE_PLN
				    EqrOnfHirExePlnVO eqrOnfHirExePlnVO = new EqrOnfHirExePlnVO();
            		ObjectCloner.build(vo , eqrOnfHirExePlnVO );
            		eqrOnfHirExePlnVO.setOnfHirDivCd(vo.getTrspModCd());
            		//  so_iss_flg, non_so_iss_flg
       	    		if(soFlag.equals("Y")) {  // so send
        	    		// so_iss_flg
       	    			if(vo.getSoIssFlg().equals("1")){
       	    				eqrOnfHirExePlnVO.setSoIssFlg("Y");  // CHECKED
       	    			}
       	    			
       	    			// non_so_iss_flg
       	    			if(vo.getNosoIssFlg().equals("1")){
       	    				eqrOnfHirExePlnVO.setNonSoIssFlg("Y"); // CHECKED
       	    			}
       	    		}
       	    		
       	    		dbDao.updateOnOffHireExecute(eqrOnfHirExePlnVO,user_id , soFlag);
       	    		
       	    		// inserting new data to EQR_ONF_HIR_EXE_PLN_CNTR after removing old data
            		if(vo.getCntrno()!=null && !vo.getCntrno().trim().equals("")) {
            			EqrExePlnCntrVO eqrExePlnCntrVO = new EqrExePlnCntrVO();
            			ObjectCloner.build(vo , eqrExePlnCntrVO );
            			eqrExePlnCntrVO.setCntrNo("");
            			eqrExePlnCntrVO.setCntrTpszCd("");
            			eqrExePlnCntrVO.setTrspModCd("");
            			eqrExePlnCntrVO.setFmEccCd(vo.getFrlocEcc());
            			eqrExePlnCntrVO.setToEccCd(vo.getTolocEcc());
            			dbDao.modifyCntrRepoPlanDetail("D", eqrExePlnCntrVO, user_id);
            			
            			eqrExePlnCntrVO = new EqrExePlnCntrVO();
            			ObjectCloner.build(vo , eqrExePlnCntrVO );
            			eqrExePlnCntrVO.setCntrNo(vo.getCntrno());
            			eqrExePlnCntrVO.setCntrTpszCd(vo.getTpszno());
            			eqrExePlnCntrVO.setTrspModCd(vo.getTrspModCd());
            			eqrExePlnCntrVO.setFmEccCd(vo.getFrlocEcc());
            			eqrExePlnCntrVO.setToEccCd(vo.getTolocEcc());
            			dbDao.modifyCntrRepoPlanDetail("I", eqrExePlnCntrVO, user_id);            						         		
    				}    
            		// after removing EQR_ONF_HIR_EXE_PLN_CNTR
            		if(vo.getCntrDel().equals("Y")) {
            			EqrExePlnCntrVO eqrExePlnCntrVO = new EqrExePlnCntrVO();
            			ObjectCloner.build(vo , eqrExePlnCntrVO );
            			eqrExePlnCntrVO.setCntrNo("");
            			eqrExePlnCntrVO.setCntrTpszCd("");
            			eqrExePlnCntrVO.setTrspModCd("");
            			eqrExePlnCntrVO.setFmEccCd(vo.getFrlocEcc());
            			eqrExePlnCntrVO.setToEccCd(vo.getTolocEcc());
            			dbDao.modifyCntrRepoPlanDetail("D", eqrExePlnCntrVO, user_id);		         		
    				} 
	            	}
				}else if(vo.getIbflag().equals("D")) {  // removing logic (except CNTR_TPSZ_CD on PK)
					EqrExePlnCntrVO eqrExePlnCntrVO = new EqrExePlnCntrVO();
					ObjectCloner.build(vo , eqrExePlnCntrVO );
					
					EqrOnfHirExePlnQtyVO eqrOnfHirExePlnQtyVO = new EqrOnfHirExePlnQtyVO();
			       	ObjectCloner.build(vo , eqrOnfHirExePlnQtyVO );
			       	
			       	EqrOnfHirExePlnVO eqrOnfHirExePlnVO = new EqrOnfHirExePlnVO();
            		ObjectCloner.build(vo , eqrOnfHirExePlnVO );
            		
        			if(vo.getDiv().equals("Plan")) {
        				dbDao.deleteEqrOnfHirPlnQtyExecuteQty(eqrOnfHirExePlnQtyVO);
        				
        				dbDao.deleteEqrOnfHirExecuteQty(eqrOnfHirExePlnQtyVO);
        				
        			}else{
	            		// removing EQR_ONF_HIR_EXE_PLN_CNTR
	        			
	        			eqrExePlnCntrVO.setCntrNo("");
	        			eqrExePlnCntrVO.setCntrTpszCd("");
	        			eqrExePlnCntrVO.setTrspModCd("");
	        			eqrExePlnCntrVO.setFmEccCd(vo.getFrlocEcc());
	        			eqrExePlnCntrVO.setToEccCd(vo.getTolocEcc());
	        			dbDao.modifyCntrRepoPlanDetail("D", eqrExePlnCntrVO, user_id);
						
	
	        			// removing EQR_ONF_HIR_EXE_PLN_QTY 
	        			
				       	dbDao.deleteOnOffHireExecuteQty(eqrOnfHirExePlnQtyVO);
				       	
						// removing EQR_ONF_HIR_EXE_PLN 
	        			
	        			dbDao.deleteOnOffHireExecute(eqrOnfHirExePlnVO);
        			}
				}
				
	    	}
    	} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
     * 수sending on hire and off hire CNTR repo plan<br>
     * 
     * @param eesEqr0059ConditionVO EesEqr0059ConditionVO
     * @param vos					EesEqr0081MultiVO[]
     * @param account				SignOnUserAccount
     * @exception EventException
     */
    public void soSendOnHireAndOffHireCntrRepoPlan(EesEqr0059ConditionVO eesEqr0059ConditionVO , EesEqr0081MultiVO[] vos, SignOnUserAccount account) throws EventException {
    	DBRowSet dbRowset = null; 
        try {        	   	

        	String user_id = account.getUsr_id(); // user id information
        	String tpszType = eesEqr0059ConditionVO.getTpsztype();
			String[] tpszArr= tpszType.split(",");

        	// office code
        	String office_code = null;

            int rowCount = (vos==null) ? 0 : vos.length;
            
            List<String> volList 	 = null;
        	int vol          = 0;    // volum for each type size

            int seq = 1; 		// REF_SEQ of EQR_REPO_EXE_SO_IF (starting with 1 for each ref_id) 
            int cntrSeq = 0;  	// CNTR_SEQ of EQR_EXE_PLN_CNTR

            // CNTR_TPSZ_CD, CNTR_NO on EQR_EXE_PLN_CNTR
            String[] cntrTpsz = null;
            String[] cntrNo   = null;
            ArrayList<String> v1 = null;
            ArrayList<String> v2 = null;
            
            // so send check row   for loop
        	// type size          for loop
        	// type size vol   for loop            
            for(int k=0; k<rowCount; k++) {
            	EesEqr0081MultiVO vo = vos[k];
            	if(vo.getSoIssFlg().equals("1")) {    
            		vol     = 0; 
                	volList = new ArrayList<String>();
                	cntrSeq = 0; // CNTR_SEQ of EQR_EXE_PLN_CNTR
	            	seq = 1; 	 // REF_SEQ of EQR_REPO_EXE_SO_IF (starting with 1 for each ref_id) 
	                v1 = new ArrayList<String>();
	                v2 = new ArrayList<String>();

	            	
	            	office_code = null;
	            	for(int m=0; m<tpszArr.length; m++) {
	            		// volum for each type size
	            		volList = vo.getVolList();
                		vol    = Integer.parseInt((String)volList.get(m));
                		EqrExePlnCntrVO eqrExePlnCntrVO = new EqrExePlnCntrVO();
                		ObjectCloner.build(vo , eqrExePlnCntrVO );
                		eqrExePlnCntrVO.setCntrTpszCd(tpszArr[m]);
                		dbRowset = dbDao.searchOnOffHireContainer(eqrExePlnCntrVO).getDbRowset();
                		while(dbRowset.next()) {        	   
            	        	v1.add(dbRowset.getString("CNTR_TPSZ_CD"));
            	        	v2.add(dbRowset.getString("CNTR_NO"));
            	        }
                		
                		cntrTpsz = new String[v1.size()];
            	        cntrNo   = new String[v2.size()];
            	        
            	        
            	        for(int v=0; v < v1.size(); v++) {
            	        	cntrTpsz[v] = (String)v1.get(v);
            	            cntrNo[v]   = (String)v2.get(v);
                    	}

//	            		// search office code 
//	            		// retrieving for each type size
//	            		// only in csae of co_cd = H & type size vol>0, retrieving for office code
	        	        if(vo.getCoCd().equals("H") && vol > 0) {
	        	        	List<CommonVO> target_key_list = new ArrayList<CommonVO>();
        	        		CommonVO joinkey = new CommonVO();
        	        		joinkey.setField1("REPO_PLN_ID");
        	        		joinkey.setField2("REPO_PLN_ID");
        	        		target_key_list.add(joinkey);
        	        		joinkey = new CommonVO();
        	        		joinkey.setField1("PLN_YRWK");
        	        		joinkey.setField2("PLN_YRWK");
        	        		target_key_list.add(joinkey);
        	        		joinkey = new CommonVO();
        	        		joinkey.setField1("PLN_SEQ");
        	        		joinkey.setField2("PLN_SEQ");
        	        		target_key_list.add(joinkey);
        	        		joinkey = new CommonVO();
        	        		joinkey.setField1("REF_ID");
        	        		joinkey.setField2("REF_ID");
        	        		target_key_list.add(joinkey);
        	        		
        	        		office_code = dbDao.searchOfficeCode("EQR_ONF_HIR_EXE_PLN","EQR_ONF_HIR_EXE_PLN_QTY",target_key_list , vo.getRepoPlnId(), vo.getPlnYrwk(), vo.getRefId(),vo.getPlnSeq(), tpszArr[m]).getResultString();
       	        	
	        	        }else {
	        	        	office_code = null;
	        	        }
	        	        
	        	        for(int j=0; j<vol; j++) {    
	        	        	EqrRepoExeSoIfVO eqrRepoExeSoIfVO = new EqrRepoExeSoIfVO();
	        	        	ObjectCloner.build(vo , eqrRepoExeSoIfVO );
	        	        	eqrRepoExeSoIfVO.setRefSeq((seq++)+"");
	        	        	eqrRepoExeSoIfVO.setCntrTpszCd(tpszArr[m]);
	        	        	eqrRepoExeSoIfVO.setSoIfDivCd(vo.getTrspModCd());
	        	        	eqrRepoExeSoIfVO.setTrspModCd("T");
	        	        	eqrRepoExeSoIfVO.setFmDt(vo.getFmLocDt());
	        	        	eqrRepoExeSoIfVO.setToDt(vo.getToLocDt());
	        	        	eqrRepoExeSoIfVO.setWoRqstFlg("Y");
	        	        	eqrRepoExeSoIfVO.setTrspSoStsCd("P");
	        	        	// except on hire 
            				if(!vo.getTrspModCd().equals("O") && cntrNo.length>0) {
            					if(cntrNo.length > cntrSeq) {
            						eqrRepoExeSoIfVO.setCntrNo(cntrNo[cntrSeq++]);
            					}	
            				}     
            				eqrRepoExeSoIfVO.setWoExeFlg("N");
            				eqrRepoExeSoIfVO.setEqCtrlOfcCd(office_code);
            				eqrRepoExeSoIfVO.setSoRqstDt(vo.getFmLocDt());
            				dbDao.createOnOffHireSoData(eqrRepoExeSoIfVO, user_id);            				
	        	        }                		
	            	}
            	}
            }
        	
        } catch (Exception de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }
    }	   

	/**
     * Canceling sending on hire and off hire CNTR repo plan<br>
     * 
     * @param eesEqr0059ConditionVO EesEqr0059ConditionVO
     * @param vos EesEqr0081MultiVO[]
     * @param account SignOnUserAccount
     * @exception EventException
     */
    public void soCancelOnHireAndOffHireCntrRepoPlan(EesEqr0059ConditionVO eesEqr0059ConditionVO ,EesEqr0081MultiVO[] vos , SignOnUserAccount account) throws EventException {        
         try {   


        	String user_id = account.getUsr_id(); // user id information
        	int rowCount = (vos==null) ? 0 : vos.length; 
			//int i3 	= 1; 
			
			String exeFlag = "N";
			

			for(int k=0; k<rowCount; k++) {
				EesEqr0081MultiVO vo = vos[k];
            	// only in case of SO SEND, NO SOSEND checked  && SO CANCEL='T', be removed
            	if((vo.getSoIssFlg().equals("1") || vo.getNosoIssFlg().equals("1")) && vo.getSoCancelFlag().equals("T")) {    
            	
            		exeFlag = dbDao.soCancelCheckCntrRepoPlan(vo.getRepoPlnId(), vo.getPlnYrwk(), vo.getPlnSeq() , vo.getRefId()).getResultString();
            		if(exeFlag.equals("Y")) {   
            			EqrRepoExeSoIfVO eqrRepoExeSoIfVO = new EqrRepoExeSoIfVO();
            			ObjectCloner.build(vo , eqrRepoExeSoIfVO );
            			dbDao.deleteOnOffHireSoData(eqrRepoExeSoIfVO);
            			
            			EqrOnfHirExePlnVO  eqrOnfHirExePlnVO = new EqrOnfHirExePlnVO();
            			ObjectCloner.build(vo , eqrOnfHirExePlnVO );
            			dbDao.updateInitOnOffHireExecute(eqrOnfHirExePlnVO, user_id);
            		}else{
            			throw new DAOException(new ErrorHandler("EQR10027").getMessage());
            		}
            	}
			}
        
        } catch (Exception de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }
    }	    
    /**
	 * inserting data to INLAND with WRSTRS_SOIF
	 * inserting data to EQR_INLND_TRSP_PLN, EQR_INLND_TRSP_EXE_PLN, EQR_REPO_EXE_SO_IF 
	 * 
	 * @param current_date	String
	 * @param fm_yd_cd		String
	 * @param to_yd_cd		String
	 * @param trsp_mod_cd	String
	 * @param cntr_tpsz_cd	String
	 * @param qty			int
	 * @return ArrayList
     * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public ArrayList inlandWrsTrsSOIF(String current_date, String fm_yd_cd, String to_yd_cd, String trsp_mod_cd, String cntr_tpsz_cd, int qty) throws EventException {
        //boolean check 		= false;
        String repo_pln_id 	= "";
        String pln_yrwk		= "";
        String fm_week      = "";
        String to_week      = "";
        String etd_date     = "";
        String eta_date     = "";
        String ref_id 		= "";
        String fm_ecc 		= "";
        String to_ecc 		= "";
        String fm_rcc       = ""; // in case of inserting so if 
        String tpszInitial  = "";
        String[] max_repo_pln_id = null;
        
        ArrayList soifList = new ArrayList();
        String[] soifArr  = null;
        
        boolean dblink_result = false;

    	float unitcost = 0;
    	float fromcost = 0;
    	float tocost   = 0;    	
    	String[] tableCost = null;
        
        String exe_dup_refid  = "";  // ref id of duplicated location onexecute
        String exe_dup_plnseq = "";  // pln_seq of duplicated location onexecute
        int    max_ref_seq    = 1;   // max req seq of exe_dup_refid
        String plnSeq = "0";
        DBRowSet rowSet = null;
        
		try {			
			CommonDBDAO commondbDao = new CommonDBDAO();
			
			// repo pln id
			max_repo_pln_id = commondbDao.searchMaxRepoPlanId().getResultStrArray();
			repo_pln_id 	= "REPO"+max_repo_pln_id[0]+"W"+max_repo_pln_id[1];
			pln_yrwk       	= commondbDao.convertDayWeekly(current_date).getResultString();
			fm_week         = pln_yrwk;
			
			etd_date        = current_date;
			
//			log.debug("\n------------------ BEFORE ");
			eta_date        = commondbDao.searchEtaDate(etd_date, fm_yd_cd, to_yd_cd, trsp_mod_cd).getResultString();
//			log.debug("\n------------------ eta_date : " + eta_date);
			if(eta_date.equals("")) eta_date = etd_date;
			
			to_week         = commondbDao.convertDayWeekly(eta_date).getResultString();
						
			fm_ecc          = commondbDao.convertYardToECC(fm_yd_cd, "ECC_CD").getResultString();
			to_ecc          = commondbDao.convertYardToECC(to_yd_cd, "ECC_CD").getResultString();
			fm_rcc          = commondbDao.convertYardToECC(fm_yd_cd, "RCC_CD").getResultString();
			
//			log.debug("\n------------------ current_date: " + current_date);
//			log.debug("\n------------------ etd_date    : " + etd_date);
//			log.debug("\n------------------ eta_date    : " + eta_date);
//			log.debug("\n------------------ fm_yd_cd 	: " + fm_yd_cd);
//			log.debug("\n------------------ to_yd_cd 	: " + to_yd_cd);
//			log.debug("\n------------------ trsp_mod_cd : " + trsp_mod_cd);
//			log.debug("\n------------------ cntr_tpsz_cd: " + cntr_tpsz_cd);
//			log.debug("\n------------------ qty 		: " + qty);			
//			
//			log.debug("\n------------------ repo_pln_id : " + repo_pln_id);
//			log.debug("\n------------------ pln_yrwk    : " + pln_yrwk);
//			log.debug("\n------------------ fm_week     : " + fm_week);
//			log.debug("\n------------------ to_week     : " + to_week);
//			log.debug("\n------------------ ref_id      : " + ref_id);
//			log.debug("\n------------------ fm_ecc      : " + fm_ecc);
//			log.debug("\n------------------ to_ecc      : " + to_ecc);
//			log.debug("\n------------------ fm_rcc      : " + fm_rcc);
			
			// plan
			tpszInitial = commondbDao.getTpszInitial().getResultString();
			

			dblink_result = true;
			String[] tpszArrInitial= tpszInitial.split(","); // 10 of tpsz size
			EqrInlndTrspPlnVO  checkEqrInlndTrspPlnVO = new EqrInlndTrspPlnVO();
    		checkEqrInlndTrspPlnVO.setRepoPlnId(repo_pln_id);
    		checkEqrInlndTrspPlnVO.setPlnYrwk(pln_yrwk);
    		checkEqrInlndTrspPlnVO.setTrspModCd(trsp_mod_cd);
    		checkEqrInlndTrspPlnVO.setFmEccCd(fm_ecc);
    		checkEqrInlndTrspPlnVO.setFmYrwk(fm_week);
    		checkEqrInlndTrspPlnVO.setToEccCd(to_ecc);
    		checkEqrInlndTrspPlnVO.setToYrwk(to_week);    
            if(dbDao.inlandInsertCheck_link(fm_ecc, to_ecc, trsp_mod_cd)) { // checking PLAN INSERT target has link info
//            	String[] errMessage ={" ("+fm_ecc+"-"+to_ecc+")"};
//                log.debug(errMessage);
                dblink_result = false;
                //throw new DAOException(new ErrorHandler("EQR10033", errMessage).getMessage());
                			
            }
            boolean plnDUPCheck = dbDao.inlandInsertCheck(checkEqrInlndTrspPlnVO);
            if(!plnDUPCheck){// not duplicated, can be inserted
            	plnSeq = commondbDao.getNextPlnSeq("EQR_INLND_TRSP_PLN", repo_pln_id, pln_yrwk).getResultString(); // creating pln_seq
            	EqrInlndTrspPlnVO eqrInlndTrspPlnVO = new EqrInlndTrspPlnVO();
	       		eqrInlndTrspPlnVO.setRepoPlnId(repo_pln_id);
	       		eqrInlndTrspPlnVO.setPlnYrwk(pln_yrwk);
	       		eqrInlndTrspPlnVO.setPlnSeq(plnSeq);
	       		eqrInlndTrspPlnVO.setTrspModCd(trsp_mod_cd);
	       		eqrInlndTrspPlnVO.setFmEccCd(fm_ecc);
	       		eqrInlndTrspPlnVO.setFmYrwk(pln_yrwk);
	       		eqrInlndTrspPlnVO.setToEccCd(to_ecc);
	       		eqrInlndTrspPlnVO.setToYrwk(to_week);
	       		eqrInlndTrspPlnVO.setPastRepoPlnFlg("N");
	       		eqrInlndTrspPlnVO.setXterRqstPlnOwnrCd("T"); // it meaning that was inserted in TRS
	       		dbDao.insertInlandWrsTrsSOIFPlan(eqrInlndTrspPlnVO,"TRS_SOIF");
                for(int m=0; m<tpszArrInitial.length; m++) { // PLAN using 10 TPSZ

		       		tableCost = dbDao.searchUnitCost("P", fm_ecc, to_ecc, trsp_mod_cd, tpszArrInitial[m]).getResultStrArray();

		       		fromcost = Float.parseFloat(tableCost[0]);
		       		tocost   = Float.parseFloat(tableCost[1]);
		       		unitcost = Float.parseFloat(tableCost[2]);	    				       		
		       		
		       		EqrInlndTrspPlnQtyVO eqrInlndTrspPlnQtyVO = new EqrInlndTrspPlnQtyVO();
		       		eqrInlndTrspPlnQtyVO.setRepoPlnId(repo_pln_id);
		       		eqrInlndTrspPlnQtyVO.setPlnYrwk(pln_yrwk);
		       		eqrInlndTrspPlnQtyVO.setPlnSeq(plnSeq);
		       		eqrInlndTrspPlnQtyVO.setCntrTpszCd(tpszArrInitial[m]);
		       		eqrInlndTrspPlnQtyVO.setCntrQty("0");
		       		eqrInlndTrspPlnQtyVO.setPlnUcAmt(unitcost+"");
		       		eqrInlndTrspPlnQtyVO.setFmEccCostAmt(fromcost+"");
		       		eqrInlndTrspPlnQtyVO.setToEccCostAmt(tocost+"");
		       		dbDao.insertInlandWrsTrsSOIFPlanQty(eqrInlndTrspPlnQtyVO,"TRS_SOIF");
                } 
            }else{
            	plnSeq = dbDao.searchPlnSeqinlandInsertCheck(checkEqrInlndTrspPlnVO);
            }
//			log.debug("\n------------------- dblink_result : " +dblink_result);
			
			if(dblink_result) {
				
				// execute
				// checking duplicate, if it already exist, retrieve ref id
				EqrInlndTrspExePlnVO eqrInlndTrspExePlnVO  = new EqrInlndTrspExePlnVO();
				eqrInlndTrspExePlnVO.setRepoPlnId(repo_pln_id);
				eqrInlndTrspExePlnVO.setPlnYrwk(pln_yrwk);
				eqrInlndTrspExePlnVO.setTrspModCd(trsp_mod_cd);
				eqrInlndTrspExePlnVO.setFmYdCd(fm_yd_cd);
				eqrInlndTrspExePlnVO.setToYdCd(to_yd_cd);
				eqrInlndTrspExePlnVO.setFmEtdDt(etd_date);
				eqrInlndTrspExePlnVO.setToEtaDt(eta_date);
				String[] exeDupArr = dbDao.checkInlandWrsTrsSOIFDuplicate(eqrInlndTrspExePlnVO).getResultStrArray();
				exe_dup_refid = exeDupArr[0];
				exe_dup_plnseq = exeDupArr[1];
//				log.debug("\n ---- exe_dup_refid --------------- : " +exe_dup_refid);
//				log.debug("\n ---- exe_dup_plnseq --------------- : " +exe_dup_plnseq);
				// exist duplicate --> REF ID, TYPE SIZE's QTY +1 of EQR_INLND_TRSP_EXE_PLN 
				//                 --> REF ID's REF_SEQ + 1 of EQR_REPO_EXE_SO_IF 
				if(!exe_dup_refid.equals("")) {
//					log.debug("\n ---- DUP --------------- ");

					// retrieving for ref seq
					max_ref_seq = dbDao.searchInlandWrsTrsSOIFRefSeq(exe_dup_refid);
					
					// inserting or modifying execute (REF ID, CNTR TYPE duplicated --> modifying, CNTR TYPE not duplicated --> inserting)
					
					//dbDao.modifyInlandWrsTrsSOIFExecuteQty(repo_pln_id, pln_yrwk, exe_dup_refid, cntr_tpsz_cd, trsp_mod_cd, fm_yd_cd, to_yd_cd, etd_date, eta_date, qty);
					tableCost = dbDao.searchUnitCost("E", fm_yd_cd, to_yd_cd, trsp_mod_cd, cntr_tpsz_cd).getResultStrArray();
		       		
			       	fromcost = Float.parseFloat(tableCost[0]);
			       	tocost   = Float.parseFloat(tableCost[1]);
			       	unitcost = Float.parseFloat(tableCost[2]);	  
			       	
			       	EqrInlndTrspExePlnQtyVO eqrInlndTrspExePlnQtyVO = new EqrInlndTrspExePlnQtyVO();
			       	eqrInlndTrspExePlnQtyVO.setRepoPlnId(repo_pln_id);
			       	eqrInlndTrspExePlnQtyVO.setPlnYrwk(pln_yrwk);
			       	eqrInlndTrspExePlnQtyVO.setRefId(exe_dup_refid);
			       	eqrInlndTrspExePlnQtyVO.setPlnSeq(exe_dup_plnseq);
			       	eqrInlndTrspExePlnQtyVO.setCntrTpszCd(cntr_tpsz_cd);
			       	eqrInlndTrspExePlnQtyVO.setCntrQty(qty+"");
			       	eqrInlndTrspExePlnQtyVO.setTrspCostAmt((qty * unitcost)+"");
			       	eqrInlndTrspExePlnQtyVO.setPlnUcAmt(unitcost+"");
			       	eqrInlndTrspExePlnQtyVO.setFmEccUcAmt(fromcost+"");
			       	eqrInlndTrspExePlnQtyVO.setToEccUcAmt(tocost+"");
			       	dbDao.mergeInlandWrsTrsSOIFExecuteQty(eqrInlndTrspExePlnQtyVO , "TRS_SOIF");
					
					// inserting so if (ref id, ref seq = REF ID max ref seq + 1)
			       	String office_code = null;
					//dbDao.insertInlandWrsTrsSOIF(repo_pln_id, pln_yrwk, exe_dup_refid, cntr_tpsz_cd, trsp_mod_cd, fm_yd_cd, to_yd_cd, fm_rcc, etd_date, eta_date, qty, max_ref_seq + 1);
			       	//if(trsp_mod_cd.equals("R") && fm_rcc.equals("USNYC") && !"MX".equals(fm_ecc.substring(0, 2))) { // USNYC, RAIL = PHXSC except Mexico
		        	//	office_code = "PHXSC";
		        	//}else {
		        		List<CommonVO> target_key_list = new ArrayList<CommonVO>();
    	        		CommonVO joinkey = new CommonVO();
    	        		joinkey.setField1("REPO_PLN_ID");
    	        		joinkey.setField2("REPO_PLN_ID");
    	        		target_key_list.add(joinkey);
    	        		joinkey = new CommonVO();
    	        		joinkey.setField1("PLN_YRWK");
    	        		joinkey.setField2("PLN_YRWK");
    	        		target_key_list.add(joinkey);
    	        		joinkey = new CommonVO();
    	        		joinkey.setField1("PLN_SEQ");
    	        		joinkey.setField2("PLN_SEQ");
    	        		target_key_list.add(joinkey);
    	        		joinkey = new CommonVO();
    	        		joinkey.setField1("REF_ID");
    	        		joinkey.setField2("REF_ID");
    	        		target_key_list.add(joinkey);
		        		office_code = dbDao.searchOfficeCode("EQR_INLND_TRSP_EXE_PLN", "EQR_INLND_TRSP_EXE_PLN_QTY", target_key_list, repo_pln_id, pln_yrwk, exe_dup_refid,exe_dup_plnseq, cntr_tpsz_cd).getResultString();
		        	//}    
		       		int seq = max_ref_seq + 1; 				// REF_SEQ of EQR_REPO_EXE_SO_IF (starting with 1 for each ref_id) 
			       	for(int j=0; j<qty; j++) {    
			       		EqrRepoExeSoIfVO eqrRepoExeSoIfVO = new EqrRepoExeSoIfVO();
				       	eqrRepoExeSoIfVO.setRepoPlnId(repo_pln_id);
				       	eqrRepoExeSoIfVO.setPlnYrwk(pln_yrwk);
				       	eqrRepoExeSoIfVO.setRefId(exe_dup_refid);
				       	eqrRepoExeSoIfVO.setPlnSeq(exe_dup_plnseq);
				       	eqrRepoExeSoIfVO.setCntrTpszCd(cntr_tpsz_cd);
				       	eqrRepoExeSoIfVO.setTrspModCd(trsp_mod_cd);
				       	eqrRepoExeSoIfVO.setSoIfDivCd(trsp_mod_cd);
				       	eqrRepoExeSoIfVO.setFmYdCd(fm_yd_cd);
				       	eqrRepoExeSoIfVO.setToYdCd(to_yd_cd);
				       	eqrRepoExeSoIfVO.setFmDt(etd_date);
				       	eqrRepoExeSoIfVO.setToDt(eta_date);
				       	eqrRepoExeSoIfVO.setWoExeFlg("N");
				       	eqrRepoExeSoIfVO.setEqCtrlOfcCd(office_code);
			       		eqrRepoExeSoIfVO.setRefSeq((seq++)+"");
			       		dbDao.insertInlandWrsTrsSOIF(eqrRepoExeSoIfVO,"TRS_SOIF");
			       	}
			       	
					// soif pk search
					rowSet = dbDao.searchInlandWrsTrsSOIF(repo_pln_id, pln_yrwk, exe_dup_plnseq ,exe_dup_refid);
				
				}else { // not duplicated
//					log.debug("\n ---- NOT DUP --------------- " );
					
					// creating ref id
					ref_id = dbDao.makeRefIDCntrRepoPlan("EQR_INLND_TRSP_EXE_PLN", "H", repo_pln_id, fm_yd_cd, trsp_mod_cd);
					
			       	// retrieving for unit cost, from cost, to cost on unit cost table 
			       	tableCost = dbDao.searchUnitCost("E", fm_yd_cd, to_yd_cd, trsp_mod_cd, cntr_tpsz_cd).getResultStrArray();
			       		
			       	fromcost = Float.parseFloat(tableCost[0]);
			       	tocost   = Float.parseFloat(tableCost[1]);
			       	unitcost = Float.parseFloat(tableCost[2]);	  
					
					// creating new execute 
			       	eqrInlndTrspExePlnVO  = new EqrInlndTrspExePlnVO();
					eqrInlndTrspExePlnVO.setRepoPlnId(repo_pln_id);
					eqrInlndTrspExePlnVO.setPlnYrwk(pln_yrwk);
					eqrInlndTrspExePlnVO.setPlnSeq(plnSeq);
					eqrInlndTrspExePlnVO.setRefId(ref_id);
					eqrInlndTrspExePlnVO.setTrspModCd(trsp_mod_cd);
					eqrInlndTrspExePlnVO.setFmYdCd(fm_yd_cd);
					eqrInlndTrspExePlnVO.setToYdCd(to_yd_cd);
					eqrInlndTrspExePlnVO.setFmEtdDt(etd_date);
					eqrInlndTrspExePlnVO.setToEtaDt(eta_date);
					eqrInlndTrspExePlnVO.setCoCd("H");
					eqrInlndTrspExePlnVO.setExeIssFlg("Y");
					eqrInlndTrspExePlnVO.setXterRqstPlnOwnrCd("T"); // meaning it inserted by TRS
					dbDao.insertInlandWrsTrsSOIFExecute(eqrInlndTrspExePlnVO , "TRS_SOIF");
					EqrInlndTrspExePlnQtyVO eqrInlndTrspExePlnQtyVO = new EqrInlndTrspExePlnQtyVO();
			       	eqrInlndTrspExePlnQtyVO.setRepoPlnId(repo_pln_id);
			       	eqrInlndTrspExePlnQtyVO.setPlnYrwk(pln_yrwk);
			       	eqrInlndTrspExePlnQtyVO.setRefId(ref_id);
			       	eqrInlndTrspExePlnQtyVO.setPlnSeq(plnSeq);
			       	eqrInlndTrspExePlnQtyVO.setCntrTpszCd(cntr_tpsz_cd);
			       	eqrInlndTrspExePlnQtyVO.setCntrQty(qty+"");
			       	eqrInlndTrspExePlnQtyVO.setTrspCostAmt((qty * unitcost)+"");
			       	eqrInlndTrspExePlnQtyVO.setPlnUcAmt(unitcost+"");
			       	eqrInlndTrspExePlnQtyVO.setFmEccUcAmt(fromcost+"");
			       	eqrInlndTrspExePlnQtyVO.setToEccUcAmt(tocost+"");
			       	dbDao.insertInlandWrsTrsSOIFExecuteQty(eqrInlndTrspExePlnQtyVO , "TRS_SOIF");
					
					// inserting new so if
			       	String office_code = null;
					//dbDao.insertInlandWrsTrsSOIF(repo_pln_id, pln_yrwk, exe_dup_refid, cntr_tpsz_cd, trsp_mod_cd, fm_yd_cd, to_yd_cd, fm_rcc, etd_date, eta_date, qty, max_ref_seq + 1);
			       	//if(trsp_mod_cd.equals("R") && fm_rcc.equals("USNYC") && !"MX".equals(fm_ecc.substring(0, 2))) { // USNYC, RAIL = PHXSC except Mexico
		        	//	office_code = "PHXSC";
		        	//}else {
		        		List<CommonVO> target_key_list = new ArrayList<CommonVO>();
    	        		CommonVO joinkey = new CommonVO();
    	        		joinkey.setField1("REPO_PLN_ID");
    	        		joinkey.setField2("REPO_PLN_ID");
    	        		target_key_list.add(joinkey);
    	        		joinkey = new CommonVO();
    	        		joinkey.setField1("PLN_YRWK");
    	        		joinkey.setField2("PLN_YRWK");
    	        		target_key_list.add(joinkey);
    	        		joinkey = new CommonVO();
    	        		joinkey.setField1("PLN_SEQ");
    	        		joinkey.setField2("PLN_SEQ");
    	        		target_key_list.add(joinkey);
    	        		joinkey = new CommonVO();
    	        		joinkey.setField1("REF_ID");
    	        		joinkey.setField2("REF_ID");
    	        		target_key_list.add(joinkey);
		        		office_code = dbDao.searchOfficeCode("EQR_INLND_TRSP_EXE_PLN", "EQR_INLND_TRSP_EXE_PLN_QTY", target_key_list, repo_pln_id, pln_yrwk, ref_id ,plnSeq, cntr_tpsz_cd).getResultString();
		        	//}    
		       		int seq = 1; 				// REF_SEQ of EQR_REPO_EXE_SO_IF (starting with 1 for each ref_id) 
			       	for(int j=0; j<qty; j++) {    
			       		EqrRepoExeSoIfVO eqrRepoExeSoIfVO = new EqrRepoExeSoIfVO();
				       	eqrRepoExeSoIfVO.setRepoPlnId(repo_pln_id);
				       	eqrRepoExeSoIfVO.setPlnYrwk(pln_yrwk);
				       	eqrRepoExeSoIfVO.setRefId(ref_id);
				       	eqrRepoExeSoIfVO.setPlnSeq(plnSeq);
				       	eqrRepoExeSoIfVO.setCntrTpszCd(cntr_tpsz_cd);
				       	eqrRepoExeSoIfVO.setTrspModCd(trsp_mod_cd);
				       	eqrRepoExeSoIfVO.setSoIfDivCd(trsp_mod_cd);
				       	eqrRepoExeSoIfVO.setFmYdCd(fm_yd_cd);
				       	eqrRepoExeSoIfVO.setToYdCd(to_yd_cd);
				       	eqrRepoExeSoIfVO.setFmDt(etd_date);
				       	eqrRepoExeSoIfVO.setToDt(eta_date);
				       	eqrRepoExeSoIfVO.setWoExeFlg("N");
				       	eqrRepoExeSoIfVO.setEqCtrlOfcCd(office_code);
			       		eqrRepoExeSoIfVO.setRefSeq((seq++)+"");
			       		dbDao.insertInlandWrsTrsSOIF(eqrRepoExeSoIfVO,"TRS_SOIF");
			       	}			

					// soif pk search
					rowSet = dbDao.searchInlandWrsTrsSOIF(repo_pln_id, pln_yrwk, plnSeq , ref_id );
						
				}
				
				int i =1;
				if (rowSet != null) {

					while (rowSet.next()) {
						soifArr = new String[4];
						for(int j=0; j<rowSet.getMetaData().getColumnCount(); j++) {
							soifArr[j] = rowSet.getString(i++);
						}
						
						i = 1;
						
						soifList.add(soifArr);
					}
				}
				
//				String[] arr = null;
//				log.debug("\n------------------- soifList.size() : " + soifList.size());
//				for(int z=0; z<soifList.size(); z++) {
//					arr = (String[])soifList.get(z);
//					log.debug("\n------------------- arr["+z+"].length() : " + arr.length);
//					for(int zz=0; zz<arr.length; zz++) {
//						log.debug("\n------------------- arr["+zz+"] : " + arr[zz]);
//					}
//				}
				
			}else {
				soifList = null; // meaning unavailable db link  
			}
			
			return soifList;

		} catch (SQLException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		} catch(Exception e){
			log.error("err "+e.toString(),e);
			throw new EventException(e.getMessage());
		}		
	}
	/**
	 * EES_EQR_0131 eMail  Send.<br>
	 * sending email
	 * @param conditionVO EesEqr0131ConditionVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void sendEmail(EesEqr0131ConditionVO conditionVO, SignOnUserAccount account) throws EventException{
		try{
			String  eml_content = " \n" + 		
			 "To   : Person In Charge of Empty Repositioning \n" +			 		
			 "From : " + account.getUsr_nm() + "\n\n\n" + 
			 "We would like to arrange Empty Containers as attachment.  \n"+
			 "Please arrange them by Lane/VVD from loading port to discharging one in time.  \n\n"+				  
			 "Thank you for your cooperation in advance.  \n\n"+				 
			 "B.RGDS  \n";
			String	eml_subject = "Empty Reposition Notice(REPO#: " + conditionVO.getRepoPlnId() + ")";
			
			conditionVO.setEmlContent(eml_content);
			conditionVO.setEmlSubject(eml_subject);
			
			CntrRepoExecutionPlanEstablishEAIDAO eaiDao = new CntrRepoExecutionPlanEstablishEAIDAO();
			eaiDao.sendEmail(conditionVO, account);
		}catch(MailerAppException me){
			log.error("err "+me.toString(),me);
			throw new EventException(me.getMessage());
		}catch(Exception e){
			log.error("err "+e.toString(),e);
			throw new EventException(e.getMessage());
		}
	}

	/**
	 * EES_EQR_0131 Fax  Send.<br>
	 * sending fax
	 * @param conditionVO EesEqr0131ConditionVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void sendFax(EesEqr0131ConditionVO conditionVO, SignOnUserAccount account) throws EventException{
		try{
			String fax_subject = "Empty Reposition Notice(REPO#: " +  conditionVO.getRepoPlnId() + ")";
			conditionVO.setFaxSubject(fax_subject);
			
			CntrRepoExecutionPlanEstablishEAIDAO eaiDao = new CntrRepoExecutionPlanEstablishEAIDAO();
			eaiDao.sendFax(conditionVO, account);
			
		}catch(FaxSendException fe){
			log.error("err "+fe.toString(),fe);
			throw new EventException(fe.getMessage());
		}catch(Exception e){
			log.error("err "+e.toString(),e);
			throw new EventException(e.getMessage());
		}
	}
	/**
	 * EES_EQR_0132  <br>
	 * retrieving for Send History email / FAX
	 * @param target String 
	 * @param job_cd String
	 * @param user_id String
	 * @return List<SearchSendHistoryVO>
	 * @exception EventException
	 */
	public List<SearchSendHistoryVO> searchSenderHistory( String target , String job_cd , String user_id)throws EventException {
		List<SearchSendHistoryVO> list = null;
		try {
			if(target.equals("F")){
				list = dbDao.searchFAXSenderHistory(job_cd, user_id);
			}else{
				list = dbDao.searchMAILSenderHistory(job_cd, user_id);
			}
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	
	/**
	 * aving suttle CNTR repo plan<br>
	 * 
	 * @param eesEqr0059ConditionVO
	 * @param vos EesEqr0083MultiVO[]
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyShuttleCntrRepoPlan(EesEqr0059ConditionVO eesEqr0059ConditionVO , EesEqr0083MultiVO[] vos ,  SignOnUserAccount account) throws EventException {
		// so send button clicked, return 'Y'
		// only in case of so flag = 'Y', modifying so_iss_flg 
		String soFlag = eesEqr0059ConditionVO.getSoFlag(); 
		String user_id = account.getUsr_id();
		try{
			String tpszType = eesEqr0059ConditionVO.getTpsztype();
			String[] tpszArr= tpszType.split(",");
			
			String ref_id_new = "";	 // ref_id
									
			int rowCount = (vos==null) ? 0 : vos.length;                            
            
            List<String> volList 	 = null;
        	int vol          = 0;    // volum for each type size
        	
        	List<String> flagList	 = null;
        	String flag      = "";

        	String[] tableCost = null;
        	float unitcost = 0;
        	        	
            for(int k=0; k<rowCount; k++) {
            	EesEqr0083MultiVO vo = vos[k];
            	vol     = 0; 
            	volList = new ArrayList<String>();
            	
            	flagList = new ArrayList<String>(); 
            	flag     = "";
            	
            	tableCost = null;
            	            					       	          	    	           	    		
                if(vo.getIbflag().equals("I")) {
                	ref_id_new = dbDao.makeRefIDCntrRepoPlan("EQR_ECC_INTER_EXE_PLN", vo.getCoCd(), vo.getRepoPlnId(),vo.getFmYdCd(), "S");
                	EqrEccInterExePlnVO eqrEccInterExePlnVO = new EqrEccInterExePlnVO();
                	ObjectCloner.build(vo , eqrEccInterExePlnVO );
                	eqrEccInterExePlnVO.setRefId(ref_id_new);
                	dbDao.insertShuttleCntrRepoPlan(eqrEccInterExePlnVO, user_id);
                	
                	for(int m=0; m<tpszArr.length; m++) {
                		// volum for each type size				    
				    	volList = vo.getVolList();                    
				       	vol    	= Integer.parseInt((String)volList.get(m));	
				       	
				       	// in case of unit cost doesn't exist, retirevie for unit cost, from cost, to cost 
				       	tableCost = dbDao.searchUnitCost("I", vo.getFmYdCd(), vo.getToYdCd(), vo.getTrspModCd(),  tpszArr[m]).getResultStrArray();				       		
				       	unitcost = Float.parseFloat(tableCost[2]);	
				       	
                		EqrEccInterExePlnQtyVO eqrEccInterExePlnQtyVO = new EqrEccInterExePlnQtyVO();
                    	ObjectCloner.build(vo , eqrEccInterExePlnQtyVO );
                    	eqrEccInterExePlnQtyVO.setRefId(ref_id_new);
                    	eqrEccInterExePlnQtyVO.setCntrTpszCd(tpszArr[m]);    
                    	eqrEccInterExePlnQtyVO.setTrspCostAmt((vol * unitcost)+"");
                    	eqrEccInterExePlnQtyVO.setCntrQty(vol+"");
                    	dbDao.insertShuttleCntrRepoPlanQty(eqrEccInterExePlnQtyVO, user_id); // at first inserting, exe_rqst_dt = null 
                    	
                	}
                	// inserting EQR_EXE_PLN_CNTR
            		if(vo.getCntrno()!=null && !vo.getCntrno().trim().equals("")) {
            			EqrExePlnCntrVO eqrExePlnCntrVO = new EqrExePlnCntrVO();
            			ObjectCloner.build(vo , eqrExePlnCntrVO );
            			eqrExePlnCntrVO.setPlnSeq("0"); // setting EQR_ECC_INTER_EXE_PLN  PLN_SEQ with default value
            			eqrExePlnCntrVO.setRefId(ref_id_new);
            			eqrExePlnCntrVO.setCntrTpszCd(vo.getTpszno());
            			eqrExePlnCntrVO.setTrspModCd(vo.getTrspModCd());
            			eqrExePlnCntrVO.setCntrNo(vo.getCntrno());
            			eqrExePlnCntrVO.setFmEccCd("XXXXX");
            			eqrExePlnCntrVO.setToEccCd("XXXXX");
            			dbDao.modifyCntrRepoPlanDetail("I", eqrExePlnCntrVO, user_id);
            		}
                }else if(vo.getIbflag().equals("U")) {
                	// -- vol  ----------------------------------  	                    	 
				    for(int m=0; m<tpszArr.length; m++) {	
				    	// volum for each type size
				    	
				    	volList = vo.getVolList();						
				       	vol     = Integer.parseInt((String)volList.get(m));	
            	    	
				       	// flag 정보 (T, F)
				       	flagList = vo.getFlagList();        
				       	flag     = (String)flagList.get(m);	
				       	if(flag.equals("T")) {

    				       	// in case of unit cost doesn't exist, retirevie for unit cost, from cost, to cost 
    				       	tableCost = dbDao.searchUnitCost("I", vo.getFmYdCd(), vo.getToYdCd(), vo.getTrspModCd(), tpszArr[m]).getResultStrArray();

    				       	unitcost = Float.parseFloat(tableCost[2]);	 
    				       	EqrEccInterExePlnQtyVO eqrEccInterExePlnQtyVO = new EqrEccInterExePlnQtyVO();
                        	ObjectCloner.build(vo , eqrEccInterExePlnQtyVO );
                        	eqrEccInterExePlnQtyVO.setCntrTpszCd(tpszArr[m]);
  
                        	eqrEccInterExePlnQtyVO.setTrspCostAmt((vol * unitcost)+"");
                        	eqrEccInterExePlnQtyVO.setCntrQty(vol+"");
                        	
                        	dbDao.mergeShuttleCntrRepoPlan(eqrEccInterExePlnQtyVO , user_id , soFlag);
				       	}
				    }
				    // -- others  ----------------------
				    EqrEccInterExePlnVO eqrEccInterExePlnVO = new EqrEccInterExePlnVO();
                	ObjectCloner.build(vo , eqrEccInterExePlnVO );
                	//  so_iss_flg
       	    		if(soFlag.equals("Y")) {  // so send button was clicked
       	    			if(vo.getSoIssFlg().equals("1")){
       	    				eqrEccInterExePlnVO.setExeIssFlg("Y"); // CHECKED
       	    			}
       	    		}
       	    		dbDao.updateShuttleCntrRepoPlan(eqrEccInterExePlnVO, user_id, soFlag);
       	    		// inserting new data to EQR_EXE_PLN_CNTR after removing old data
            		if(vo.getCntrno()!=null && !vo.getCntrno().trim().equals("")) {
            			EqrExePlnCntrVO eqrExePlnCntrVO = new EqrExePlnCntrVO();
            			ObjectCloner.build(vo , eqrExePlnCntrVO );
            			eqrExePlnCntrVO.setPlnSeq("0"); // setting PLN_SEQ of EQR_ECC_INTER_EXE_PLN with default value
            			eqrExePlnCntrVO.setCntrTpszCd("");
            			eqrExePlnCntrVO.setTrspModCd("");
            			eqrExePlnCntrVO.setCntrNo("");
            			eqrExePlnCntrVO.setFmEccCd("XXXXX");
            			eqrExePlnCntrVO.setToEccCd("XXXXX");
            			dbDao.modifyCntrRepoPlanDetail("D", eqrExePlnCntrVO, user_id);	
            			
            			eqrExePlnCntrVO = new EqrExePlnCntrVO();
            			ObjectCloner.build(vo , eqrExePlnCntrVO );
            			eqrExePlnCntrVO.setPlnSeq("0"); // setting PLN_SEQ ofEQR_ECC_INTER_EXE_PLN with default value
            			eqrExePlnCntrVO.setCntrTpszCd(vo.getTpszno());
            			eqrExePlnCntrVO.setTrspModCd(vo.getTrspModCd());
            			eqrExePlnCntrVO.setCntrNo(vo.getCntrno());
            			eqrExePlnCntrVO.setFmEccCd("XXXXX");
            			eqrExePlnCntrVO.setToEccCd("XXXXX");
            			dbDao.modifyCntrRepoPlanDetail("I", eqrExePlnCntrVO, user_id);		         		
    				}    
            		// removing EQR_EXE_PLN_CNTR
            		if(vo.getCntrDel().equals("Y")) {
            			EqrExePlnCntrVO eqrExePlnCntrVO = new EqrExePlnCntrVO();
            			ObjectCloner.build(vo , eqrExePlnCntrVO );
            			eqrExePlnCntrVO.setPlnSeq("0"); // setting PLN_SEQ of EQR_ECC_INTER_EXE_PLN with default value
            			eqrExePlnCntrVO.setCntrTpszCd("");
            			eqrExePlnCntrVO.setTrspModCd("");
            			eqrExePlnCntrVO.setCntrNo("");
            			eqrExePlnCntrVO.setFmEccCd("XXXXX");
            			eqrExePlnCntrVO.setToEccCd("XXXXX");
            			dbDao.modifyCntrRepoPlanDetail("D", eqrExePlnCntrVO, user_id);			         		
    				}    
                	
				    
                }else if(vo.getIbflag().equals("D")) {  // removing logic(except CNTR_TPSZ_CD on PK)
                	// removing EQR_EXE_PLN_CNTR 
                	EqrExePlnCntrVO eqrExePlnCntrVO = new EqrExePlnCntrVO();
        			ObjectCloner.build(vo , eqrExePlnCntrVO );
        			eqrExePlnCntrVO.setPlnSeq("0"); // setting PLN_SEQ of EQR_ECC_INTER_EXE_PLN with default value
        			eqrExePlnCntrVO.setCntrTpszCd("");
        			eqrExePlnCntrVO.setTrspModCd("");
        			eqrExePlnCntrVO.setCntrNo("");
        			eqrExePlnCntrVO.setFmEccCd("XXXXX");
        			eqrExePlnCntrVO.setToEccCd("XXXXX");
        			dbDao.modifyCntrRepoPlanDetail("D", eqrExePlnCntrVO, user_id);	
                	// removing EQR_ECC_INTER_EXE_PLN_QTY
                	EqrEccInterExePlnQtyVO eqrEccInterExePlnQtyVO = new EqrEccInterExePlnQtyVO();
                	ObjectCloner.build(vo , eqrEccInterExePlnQtyVO );
                	dbDao.deleteShuttleCntrRepoPlanQty(eqrEccInterExePlnQtyVO);
        			// removing EQR_ECC_INTER_EXE_PLN
        			EqrEccInterExePlnVO eqrEccInterExePlnVO = new EqrEccInterExePlnVO();
                	ObjectCloner.build(vo , eqrEccInterExePlnVO );
                	dbDao.deleteShuttleCntrRepoPlan(eqrEccInterExePlnVO);
        			
                }
            }
			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
     * sending shuttle CNTR repo plan<br>
     * 
     * @param eesEqr0059ConditionVO
     * @param vos EesEqr0083MultiVO[]
     * @param account SignOnUserAccount
     * @exception EventException
     */
    @SuppressWarnings("unchecked")
	public void soSendShuttleCntrRepoPlan(EesEqr0059ConditionVO eesEqr0059ConditionVO , EesEqr0083MultiVO[] vos ,  SignOnUserAccount account) throws EventException {
                
        String user_id = account.getUsr_id();
        try {        	         
        	String tpszType = eesEqr0059ConditionVO.getTpsztype();
			String[] tpszArr= tpszType.split(",");

        	// office code
        	String office_code = null;

	        int rowCount = (vos==null) ? 0 : vos.length;
	        
	        List volList 	 = null;
	    	int vol          = 0;    // volum for each type size
	
	        //int k 	= 1; 	// counting bind
	        int seq = 1; 		// REF_SEQ of EQR_REPO_EXE_SO_IF (starting with 1 for each ref_id) 
	        int cntrSeq = 0;  	// CNTR_SEQ of EQR_EXE_PLN_CNTR
	
	        // CNTR_TPSZ_CD, CNTR_NO on EQR_EXE_PLN_CNTR
	        String[] cntrTpsz = null;
	        String[] cntrNo   = null;
	        //Vector v1 = new Vector();
	        //Vector v2 = new Vector();
	
//	        ArrayList v1 = new ArrayList();
//	        ArrayList v2 = new ArrayList();
            ArrayList v1 = null;
            ArrayList v2 = null;
	        
	    	// so send checked rows   for loop
	    	// type size          for loop
	    	// type size vol   for loop            
	        for(int k=0; k<rowCount; k++) {
	        	EesEqr0083MultiVO vo = vos[k];
	            if(vo.getSoIssFlg().equals("1")) {                  	
	    	        
	    	        // ------------ EQR_REPO_EXE_SO_IF INSERT LOGIC ---------------------
	            	vol     = 0; 
	            	volList = new ArrayList();
	            	cntrSeq = 0; // CNTR_SEQ of EQR_EXE_PLN_CNTR
	            	seq = 1; 	 // REF_SEQ of EQR_REPO_EXE_SO_IF (starting with 1 for each ref_id) 
	            	v1 = new ArrayList();
	            	v2 = new ArrayList();
	            	office_code = null;
	            	
	            	for(int m=0; m<tpszArr.length; m++) {
				    	
	            		// volum for each type size
	            		volList = vo.getVolList();				
	            		vol    = Integer.parseInt((String)volList.get(m));	
	            		EqrExePlnCntrVO eqrExePlnCntrVO = new EqrExePlnCntrVO();
	            		ObjectCloner.build(vo , eqrExePlnCntrVO );
	            		eqrExePlnCntrVO.setCntrTpszCd(tpszArr[m]);
	            		eqrExePlnCntrVO.setPlnSeq("0"); // setting default value
	            		DBRowSet dbRowset = dbDao.searchEccInternalContainer(eqrExePlnCntrVO).getDbRowset();
	            		while(dbRowset.next()) {        	   
	        	        	v1.add(dbRowset.getString("CNTR_TPSZ_CD"));
	        	        	v2.add(dbRowset.getString("CNTR_NO"));
	        	        }
	            		cntrTpsz = new String[v1.size()];
	        	        cntrNo   = new String[v2.size()];
	        	        
	        	        for(int v=0; v < v1.size(); v++) {
	        	        	//cntrTpsz[v] = (String)v1.elementAt(v);
	        	            //cntrNo[v]   = (String)v2.elementAt(v);
	        	        	cntrTpsz[v] = (String)v1.get(v);
	        	            cntrNo[v]   = (String)v2.get(v);
	                	}
	
	        	        List<CommonVO> target_key_list = new ArrayList<CommonVO>();
    	        		CommonVO joinkey = new CommonVO();
    	        		joinkey.setField1("REPO_PLN_ID");
    	        		joinkey.setField2("REPO_PLN_ID");
    	        		target_key_list.add(joinkey);
    	        		joinkey = new CommonVO();
    	        		joinkey.setField1("PLN_YRWK");
    	        		joinkey.setField2("PLN_YRWK");
    	        		target_key_list.add(joinkey);
    	        		joinkey = new CommonVO();
    	        		joinkey.setField1("REF_ID");
    	        		joinkey.setField2("REF_ID");
    	        		target_key_list.add(joinkey);
    	        		
	        	        office_code = dbDao.searchOfficeCode("EQR_ECC_INTER_EXE_PLN","EQR_ECC_INTER_EXE_PLN_QTY",target_key_list, vo.getRepoPlnId(), vo.getPlnYrwk() ,vo.getRefId(),"0", tpszArr[m]).getResultString();
	        	        
	        	        for(int j=0; j<vol; j++) {   
	        	        	EqrRepoExeSoIfVO eqrRepoExeSoIfVO = new EqrRepoExeSoIfVO();
	        	        	ObjectCloner.build(vo , eqrRepoExeSoIfVO );
	        	        	eqrRepoExeSoIfVO.setRefSeq((seq++)+"");
	        	        	eqrRepoExeSoIfVO.setCntrTpszCd(tpszArr[m]);
	        	        	eqrRepoExeSoIfVO.setSoIfDivCd("S");
	        	        	eqrRepoExeSoIfVO.setFmDt(vo.getFmEtdDt());
	        	        	eqrRepoExeSoIfVO.setToDt(vo.getToEtaDt());
	        	        	eqrRepoExeSoIfVO.setTrspSoStsCd("P");
	        	        	eqrRepoExeSoIfVO.setWoRqstFlg("Y");
	        	        	if(cntrNo.length > 0) {
	        					if(cntrNo.length > cntrSeq) {
	        						eqrRepoExeSoIfVO.setCntrNo(cntrNo[cntrSeq++]);
	        					}
	        				}
	        	        	eqrRepoExeSoIfVO.setWoExeFlg("N");
	        	        	eqrRepoExeSoIfVO.setEqCtrlOfcCd(office_code);
	        	        	eqrRepoExeSoIfVO.setSoRqstDt(vo.getFmEtdDt());
	        	        	eqrRepoExeSoIfVO.setPlnSeq("0"); // setting default value
	        	        	dbDao.createEccInternalSoData(eqrRepoExeSoIfVO, user_id);
	        	        }
	            		
	            	}
	            }
	        }
	            		
        	// ----- END                   	
        	  
        } catch (Exception de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }
    }	 
    /**
     * Canceling sending shuttle CNTR repo plan<br>
     * 
     * @param eesEqr0059ConditionVO
     * @param vos EesEqr0083MultiVO[]
     * @param account SignOnUserAccount
     * @exception EventException
     */
    public void soCancelShuttleCntrRepoPlan(EesEqr0059ConditionVO eesEqr0059ConditionVO , EesEqr0083MultiVO[] vos ,  SignOnUserAccount account) throws EventException {
    	
    	String user_id = account.getUsr_id();
    	try{
    		int rowCount = (vos==null) ? 0 : vos.length;
			
			String exeFlag = "N";

            for(int k=0; k<rowCount; k++) {
            	EesEqr0083MultiVO vo = vos[k];
            	// only in case of SO SEND checked && SO CANCEL='T', can be removed
            	if(vo.getSoIssFlg().equals("1") && vo.getSoCancelFlag().equals("T")) {    
            	
            		exeFlag = dbDao.soCancelCheckCntrRepoPlan(vo.getRepoPlnId(), vo.getPlnYrwk() , "0" , vo.getRefId()).getResultString();
            		if(exeFlag.equals("Y")) {   
            			EqrRepoExeSoIfVO eqrRepoExeSoIfVO = new EqrRepoExeSoIfVO();
            			ObjectCloner.build(vo , eqrRepoExeSoIfVO );
            			eqrRepoExeSoIfVO.setPlnSeq("0");
            			dbDao.deleteShuttleSoData(eqrRepoExeSoIfVO);

            			EqrEccInterExePlnQtyVO eqrEccInterExePlnQtyVO = new EqrEccInterExePlnQtyVO();
            			ObjectCloner.build(vo , eqrEccInterExePlnQtyVO );
            			dbDao.deleteShuttleExecuteQty(eqrEccInterExePlnQtyVO,user_id);
            			
            			EqrEccInterExePlnVO eqrEccInterExePlnVO = new EqrEccInterExePlnVO();
            			ObjectCloner.build(vo , eqrEccInterExePlnVO );
            			dbDao.deleteShuttleExecute(eqrEccInterExePlnVO,user_id);
            			
            		}else {
                		throw new DAOException(new ErrorHandler("EQR10027").getMessage());
                	} 
            	}
            }
    	} catch (Exception de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }
    }
    /**
	 * [ EES_EQR_0112 :  ]<br>
	 * Forecasted Land Inventory
	 * @param EesEqr0112ConditionVO eesEqr0112ConditionVO
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchLocalForecastedLandInv(EesEqr0112ConditionVO eesEqr0112ConditionVO) throws EventException {
		try {
			return dbDao.searchLocalForecastedLandInv(eesEqr0112ConditionVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/**
	 * in case of creating/modifying/removing S/O from TRS, updating S/O status on EQR_REPO_EXE_SO_IF
     * 
	 * @param singleTransportationVO
	 * @return boolean
	 * @exception EventException
	 */
	public boolean modifyFromTrsSOIFPlanSoSts( SingleTransportationVO singleTransportationVO) throws EventException {
		try {
			return dbDao.modifyFromTrsSOIFPlanSoSts(singleTransportationVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	/**
	 * modifying ONF_HIR_EXE_PLN, S/O , CNTR info(new REF_ID and TO_YD_CD )
	 * @param ModifyFromTrsOffHireReturnVO vo
	 * @param SignOnUserAccount account
	 * @return ModifyFromTrsOffHireReturnVO
	 * @exception EventException
	 */
	public ModifyFromTrsOffHireReturnVO modifyFromTrsOffHireReturn( ModifyFromTrsOffHireReturnVO vo , SignOnUserAccount account)throws EventException {
		ModifyFromTrsOffHireReturnVO retVO = new ModifyFromTrsOffHireReturnVO();
		try {
			ObjectCloner.build(vo , retVO );
			String newRefId = "";
			String returnCode = "";
			String user_id = "";
//			String chd_cntr_no = "";
			String old_ref_seq = "";
			
			// in case of from ETS 
			if(account != null && account.getUsr_id() != null){
				user_id = account.getUsr_id();
			}else{
				user_id = "TRS_ETS";
			}
			String trspSoStsCd = vo.getTrspSoStsCd();
			// returning REF_SEQ
			
			// 2-1 creating OLD DATA VO
			SearchEqrOnfHirExePlnByOffHireReturnVO oldEqrOnfHirExePlnVO = dbDao.searchEqrOnfHirExePlnByOffHireReturn(vo);
			// 2-1  actual S/O count oldEqrOnfHirExePlnQtyVO.getVolCnt()
			EqrOnfHirExePlnQtyVO oldEqrOnfHirExePlnQtyVO = dbDao.searchEqrOnfHirExePlnQtyByOffHireReturn(vo);
			// 2-2 selecting target with REF_SEQ
			List<EqrRepoExeSoIfVO> soList = dbDao.searchEqrRepoExeSoIfByOffHireReturn(vo);

			
//			if(!(vo.getCntrNoList().size() > 0 && vo.getOldRefSeqList().size() > 0 &&  vo.getCntrNoList().size() == vo.getOldRefSeqList().size())){
//				soList = null; 
//			}
			
			if(oldEqrOnfHirExePlnVO == null || oldEqrOnfHirExePlnQtyVO == null || soList == null || ( soList != null && soList.size() < 1)){
				returnCode = Constants.TRS_OFF_HIRE_RETURNCODE_FAIL_20; 
			}else{
				if(Integer.parseInt(vo.getChdCntrQty()) != soList.size() && Integer.parseInt(vo.getChdCntrQty()) != vo.getCntrNoList().size()){
					returnCode = Constants.TRS_OFF_HIRE_RETURNCODE_FAIL_40;
				}else{
					if(Integer.parseInt(vo.getChdCntrQty()) < 1 || Integer.parseInt(vo.getChdCntrQty()) > Integer.parseInt( oldEqrOnfHirExePlnQtyVO.getCntrQty())){
						returnCode = Constants.TRS_OFF_HIRE_RETURNCODE_FAIL_10;
					}else{						
						if(!oldEqrOnfHirExePlnVO.getOnfHirDivCd().equals("F")){
							returnCode = Constants.TRS_OFF_HIRE_RETURNCODE_FAIL_30;
						}else{
							
								boolean dupCheck = false;
								boolean dupQtyCheck = false;
								EqrOnfHirExePlnVO chkEqrOnfHirExePlnVO = new EqrOnfHirExePlnVO();
								ObjectCloner.build(oldEqrOnfHirExePlnVO , chkEqrOnfHirExePlnVO );
								chkEqrOnfHirExePlnVO.setToYdCd(vo.getChdToYdCd());
								chkEqrOnfHirExePlnVO.setUpdUsrId(user_id);
								
								
								String[] checkInfo = dbDao.checkDuplicateOnfHirExePlnByOffHireReturn(chkEqrOnfHirExePlnVO );
								int currCntrQty = 0;
								int currRefSeq  = -1;
								String currRefId = "NaN";
								if(checkInfo.length == 2){
									currRefId = checkInfo[0];
									currRefSeq = Integer.parseInt(checkInfo[1]);
								}
								if(currRefId != null && !currRefId.equals("NaN") && !currRefId.equals(vo.getRefId())){ 
									dupCheck = true;
								}else{
									currRefSeq = -1;
								}

				        		if(currRefSeq == -1){
				        			currRefSeq = 1;
				        		}else{
				        			currRefSeq = currRefSeq + 1; 
				        		}
				        		
				        		if(dupCheck){ // 
				        			String[] checkQtyInfo = dbDao.checkDuplicateOnfHirExePlnQtyByOffHireReturn(chkEqrOnfHirExePlnVO , vo.getCntrTpszCd() );
				        			if(checkQtyInfo.length == 2){
				        				currCntrQty = Integer.parseInt(checkQtyInfo[1]);
									}
				        		}
				        		
				        		if(currCntrQty > 0){ 
				        			dupQtyCheck = true;
				        		}

				        		
								String[] tableCost = null;
					        	float unitcost = 0;
					        	// retrieving for COST info
		            			tableCost = dbDao.searchUnitCost("E", oldEqrOnfHirExePlnVO.getFmYdCd(), vo.getChdToYdCd(), oldEqrOnfHirExePlnVO.getOnfHirDivCd(), vo.getCntrTpszCd()).getResultStrArray();
					       		
					       		unitcost = Float.parseFloat(tableCost[2]);	
					       		EqrOnfHirExePlnVO eqrOnfHirExePlnVO = new EqrOnfHirExePlnVO();
					       		
					        	if(dupCheck){
					        		newRefId = currRefId;
					        		retVO.setNewRefId(newRefId);
					        	}else{
									// 2-7-2 creating REF_ID
						        	newRefId = dbDao.makeRefIDCntrRepoPlan("EQR_ONF_HIR_EXE_PLN", oldEqrOnfHirExePlnVO.getCoCd(), vo.getRepoPlnId(), oldEqrOnfHirExePlnVO.getFmYdCd(), oldEqrOnfHirExePlnVO.getOnfHirDivCd());
									retVO.setNewRefId(newRefId);
									// INSERT INTO EQR_ONF_HIR_EXE_PLN
									eqrOnfHirExePlnVO = new EqrOnfHirExePlnVO();
				            		ObjectCloner.build(oldEqrOnfHirExePlnVO , eqrOnfHirExePlnVO );
				            		eqrOnfHirExePlnVO.setRefId(newRefId);
				            		eqrOnfHirExePlnVO.setToYdCd(vo.getChdToYdCd());
		//		            		eqrOnfHirExePlnVO.setToLocDt(vo.getChdToYdDt());
				            		dbDao.insertOnOffHireExecute(eqrOnfHirExePlnVO, user_id);
					        	}
						       	
						       	// Start. Before OffHireReturn UPDATE OR DELETE EQR_ONF_HIR_EXE_PLN_QTY  
					       		
					       		if(Integer.parseInt(vo.getChdCntrQty()) == Integer.parseInt( oldEqrOnfHirExePlnVO.getAllTpszVol())){ // removing last plan if it all changed
					       			// 3-1-1 DELETE EQR_ONF_HIR_EXE_PLN_QTY
					       			// removing EQR_ONF_HIR_EXE_PLN_QTY
				        			EqrOnfHirExePlnQtyVO eqrOnfHirExePlnQtyDelVO = new EqrOnfHirExePlnQtyVO();
							       	ObjectCloner.build(oldEqrOnfHirExePlnQtyVO , eqrOnfHirExePlnQtyDelVO );
							       	dbDao.deleteOnOffHireExecuteQty(eqrOnfHirExePlnQtyDelVO);
							       	
									// removing EQR_ONF_HIR_EXE_PLN
				        			eqrOnfHirExePlnVO = new EqrOnfHirExePlnVO();
				        			ObjectCloner.build(oldEqrOnfHirExePlnVO , eqrOnfHirExePlnVO );
				        			dbDao.deleteOnOffHireExecute(eqrOnfHirExePlnVO);
					       		}else{
					       			// 3-1-2 UPDATE EQR_ONF_HIR_EXE_PLN_QTY
					       			if(Integer.parseInt(vo.getChdCntrQty()) == Integer.parseInt( oldEqrOnfHirExePlnQtyVO.getCntrQty())){ 
					       				// removing existing EQR_ONF_HIR_EXE_PLN_QTY data if it all changed in TPSZ
					       				dbDao.deleteEqrOnfHirExePlnQtyByCntrTpSz(vo);
					       			}else{
					       				EqrOnfHirExePlnQtyVO oriEqrOnfHirExePlnQtyVO = new EqrOnfHirExePlnQtyVO();
					       				ObjectCloner.build(vo , oriEqrOnfHirExePlnQtyVO );
					       				oriEqrOnfHirExePlnQtyVO.setCntrQty((Integer.parseInt( oldEqrOnfHirExePlnQtyVO.getCntrQty()) - Integer.parseInt(vo.getChdCntrQty()))+""); 
					       				if(oldEqrOnfHirExePlnQtyVO.getPlnUcAmt() != null  && !oldEqrOnfHirExePlnQtyVO.getPlnUcAmt().equals("") && Double.parseDouble(oldEqrOnfHirExePlnQtyVO.getPlnUcAmt()) != 0  ){
					       					oriEqrOnfHirExePlnQtyVO.setOnfHirCostAmt((Integer.parseInt(oriEqrOnfHirExePlnQtyVO.getCntrQty()) * Float.parseFloat(oldEqrOnfHirExePlnQtyVO.getPlnUcAmt()))+"");
					       					oriEqrOnfHirExePlnQtyVO.setPlnUcAmt(oldEqrOnfHirExePlnQtyVO.getPlnUcAmt());
					       				}else{
					       					// retrieving for COST
					       					String[] oritableCost = null;
								        	float oriunitcost = 0;
								        	oritableCost = dbDao.searchUnitCost("E", oldEqrOnfHirExePlnVO.getFmYdCd(), oldEqrOnfHirExePlnVO.getToYdCd(), oldEqrOnfHirExePlnVO.getOnfHirDivCd(), vo.getCntrTpszCd()).getResultStrArray();
								       		
								        	oriunitcost = Float.parseFloat(oritableCost[2]);	
								       		oriEqrOnfHirExePlnQtyVO.setOnfHirCostAmt((Integer.parseInt(oriEqrOnfHirExePlnQtyVO.getCntrQty()) * oriunitcost)+"");
								       		oriEqrOnfHirExePlnQtyVO.setPlnUcAmt(oriunitcost+"");
					       				}
					       				
					       				dbDao.modifyCntrQtyOfEqrOnfHirExePlnQty(oriEqrOnfHirExePlnQtyVO,user_id);
					       			}
					       		}
						       	// End. Before OffHireReturn UPDATE OR DELETE EQR_ONF_HIR_EXE_PLN_QTY 
					       		if(dupQtyCheck){
					       			// 3-2-1 Row Update
					       			EqrOnfHirExePlnQtyVO oriEqrOnfHirExePlnQtyVO = new EqrOnfHirExePlnQtyVO();
				       				ObjectCloner.build(vo , oriEqrOnfHirExePlnQtyVO );
				       				oriEqrOnfHirExePlnQtyVO.setRefId(currRefId);
				       				
				       				oriEqrOnfHirExePlnQtyVO.setCntrQty(( currCntrQty + Integer.parseInt(vo.getChdCntrQty()))+""); 
				       				
			       					oriEqrOnfHirExePlnQtyVO.setOnfHirCostAmt((Integer.parseInt(oriEqrOnfHirExePlnQtyVO.getCntrQty()) * unitcost)+"");
			       					oriEqrOnfHirExePlnQtyVO.setPlnUcAmt(unitcost+"");				       				
				       				
				       				dbDao.modifyCntrQtyOfEqrOnfHirExePlnQty(oriEqrOnfHirExePlnQtyVO,user_id);
					       		}else{
							       	// 3-2-2 INSERT INTO EQR_ONF_HIR_EXE_PLN_QTY
						       		EqrOnfHirExePlnQtyVO eqrOnfHirExePlnQtyVO = new EqrOnfHirExePlnQtyVO();
				        			ObjectCloner.build(oldEqrOnfHirExePlnQtyVO , eqrOnfHirExePlnQtyVO );
				        			eqrOnfHirExePlnQtyVO.setRefId(newRefId);
				        			eqrOnfHirExePlnQtyVO.setCntrTpszCd(vo.getCntrTpszCd());
				        			eqrOnfHirExePlnQtyVO.setCntrQty(vo.getChdCntrQty());
				        			eqrOnfHirExePlnQtyVO.setOnfHirCostAmt((Integer.parseInt(vo.getChdCntrQty()) * unitcost)+"");
				        			eqrOnfHirExePlnQtyVO.setPlnUcAmt(unitcost+"");
				        			dbDao.insertOnOffHireExecuteQty(eqrOnfHirExePlnQtyVO, user_id);
					       		}
					       		
					       		// 3-3 updating CNTR info ( SO_IF )
					       		Iterator<EqrRepoExeSoIfVO> iterator = soList.iterator();
			        			int ref_seq = currRefSeq;
			        			while(iterator.hasNext()){
			        				EqrRepoExeSoIfVO epesiVO = iterator.next();
			        				
			        				if(trspSoStsCd == null || ( trspSoStsCd != null && trspSoStsCd.equals(""))){
										trspSoStsCd = epesiVO.getTrspSoStsCd();
									}
	//		        				epesiVO.setToDt(vo.getChdToYdDt());
			        				epesiVO.setToYdCd(vo.getChdToYdCd());
			        				epesiVO.setTrspSoStsCd(trspSoStsCd);
			        				
			        				//  CNTR NO to update
//			        				if(vo.getCntrNoList().size() > 0 && vo.getOldRefSeqList().size() > 0 ){
//			        					for(int i = 0 ; i < vo.getCntrNoList().size();i++ ){
//			        						if(epesiVO.getRefSeq().equals(vo.getOldRefSeqList().get(i))){
//			        							chd_cntr_no = vo.getCntrNoList().get(i);
//			        							old_ref_seq = epesiVO.getRefSeq();
//			        							i = vo.getCntrNoList().size()+1; // loop break
//			        						}
//			        					}
//			        				}
			        				old_ref_seq = epesiVO.getRefSeq();
			        				//epesiVO.setCntrNo(chd_cntr_no);
			        				epesiVO.setRefSeq((ref_seq++)+"");
			        				
			        				// UPDATE EQR_REPO_EXE_SO_IF
			        				dbDao.modifyFromTRSEqrRepoExeSoIf(epesiVO,newRefId,user_id , old_ref_seq);

			        				// return ref_seq  
			        				retVO.addRefSeqList(epesiVO.getRefSeq());
				        			
				        			// UPDATE EQR_EXE_PLN_CNTR
			        				vo.setCntrNo(epesiVO.getCntrNo());
			        				dbDao.modifyFromTRSEqrExePlnCntr(vo,newRefId , user_id);
			        			}
			        			
			        			returnCode=Constants.TRS_OFF_HIRE_RETURNCODE_SUCCESS;
			        		/*	
							}
							*/
						}
					}					
				}
			}
			
			retVO.setReturnCode(returnCode);
			return retVO;
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	/**
	 * Fixed Plan <br>
	 * 
	 * @param eqrVslLodgDchgPlnQtyVO EqrVslLodgDchgPlnQtyVO
	 * @exception 
	 */
	public void modifyFixedPlan(EqrVslLodgDchgPlnQtyVO eqrVslLodgDchgPlnQtyVO) throws EventException {
		try {
	       	String fixedPlnQty = dbDao.searchFixedPlanQty(eqrVslLodgDchgPlnQtyVO).getResultString();

	       	int diff_qty = Integer.parseInt(fixedPlnQty) - Integer.parseInt(eqrVslLodgDchgPlnQtyVO.getCntrQty());
	       	diff_qty = ( diff_qty < 0 ) ? 0 : diff_qty;
			
			eqrVslLodgDchgPlnQtyVO.setCntrQty(Integer.toString(diff_qty));
			eqrVslLodgDchgPlnQtyVO.setLodgDchgCostAmt(Float.toString(diff_qty * Float.parseFloat(eqrVslLodgDchgPlnQtyVO.getPlnUcAmt())));
			
			dbDao.modifyFixedPlanVolume(eqrVslLodgDchgPlnQtyVO);

		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * retreiving for EQR All-Weeks' Plan?Access Grant<br>
	 * 
	 * @return List<SearchEqrAllWeeksPlanAccessGrantVO>
	 * @exception EventException
	 */
	public List<SearchEqrAllWeeksPlanAccessGrantVO> searchEqrAllWeeksPlanAccessGrant() throws EventException {
		try {
			return dbDao.searchEqrAllWeeksPlanAccessGrant();
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * modifying EQR All-Weeks' Plan?Access Grant<br>
	 * 
	 * @param eesEqr0143MultiVOs EesEqr0143MultiVO[]
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyEqrAllWeeksPlanAccessGrant(EesEqr0143MultiVO[] eesEqr0143MultiVOs, SignOnUserAccount account) throws EventException {
		try {
			List<EesEqr0143MultiVO> updateVoList = new ArrayList<EesEqr0143MultiVO>();
			List<EesEqr0143MultiVO> deleteVoList = new ArrayList<EesEqr0143MultiVO>();
			
			for ( int i=0; i<eesEqr0143MultiVOs .length; i++ ) {
				if ( eesEqr0143MultiVOs[i].getIbflag().equals("U") || eesEqr0143MultiVOs[i].getIbflag().equals("I")){
					eesEqr0143MultiVOs[i].setCreUsrId(account.getUsr_id());
					eesEqr0143MultiVOs[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(eesEqr0143MultiVOs[i]);
				} else if (eesEqr0143MultiVOs[i].getIbflag().equals("D")) {
					eesEqr0143MultiVOs[i].setCreUsrId(account.getUsr_id());
					eesEqr0143MultiVOs[i].setUpdUsrId(account.getUsr_id());
					deleteVoList.add(eesEqr0143MultiVOs[i]);
				}
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.mergeEqrAllWeeksPlanAccessGrant(updateVoList);
			}
			if (deleteVoList.size() > 0) {
				dbDao.deleteEqrAllWeeksPlanAccessGrant(deleteVoList);
			}

		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * retrieving for LOC YARD <br>
	 * 
	 * @param conditionVO EesCommonConditionVO
	 * @return List<SearchCheckCntrInfoVO>
	 * @exception EventException
	 */
public EesCommonVO searchLocYardInfo(EesCommonConditionVO conditionVO) throws EventException {		
		
        String[] result = null;
       
		try {
			result = dbDao.searchLocYardInfo(conditionVO.getLocyardSearchword()).getResultStrArray();
			EesCommonVO eesCommonVO = new EesCommonVO();
			
			eesCommonVO.setLocyardResult(result);
			
			return eesCommonVO;
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
}