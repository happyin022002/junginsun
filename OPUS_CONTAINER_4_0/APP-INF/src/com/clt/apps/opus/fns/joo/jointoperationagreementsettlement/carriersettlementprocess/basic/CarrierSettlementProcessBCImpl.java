/*=========================================================
*Copyright(c) 2009 CyberLogitec 
*@FileName : CarrierSettlementProcessBCImpl.java
*@FileTitle : War Risk Surcharge Settlement
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.basic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration.CarrierSettlementProcessDBDAO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration.CarrierSettlementProcessEAIDAO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.AdjustConditionVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.AdjustSettlementVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.CntrConditionVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.CntrConversionAndOptionVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.CntrConversionConditionVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.CntrPreviousVvdPortVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.CntrSettlementBackupReportVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.CntrStandardFormatVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.LoadingQtyVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.ManualStlVvdVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.McsStatusReportVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.McsStatusVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.McsVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.ProcSettlementVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.RdrByLaneVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.RdrLoadVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.SettlementRFVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.SettlementVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.SlotXchLaneVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.SlotXchPartnerVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.StlConditionVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.StlStatusBsaVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.StlStatusVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.TdrByLaneVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.TdrLoadVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.vo.EstmActRsltVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo.CombinedVO;
import com.clt.apps.opus.fns.joo.joocommonutil.JooConstants;
import com.clt.framework.component.backend.core.BackEndJobManager;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.JooSettlementVO;
import com.clt.syscommon.common.table.JooStlCmbDtlVO;
import com.clt.syscommon.common.table.JooStlDtlVO;
import com.clt.syscommon.common.table.JooStlVvdVO;
import com.clt.syscommon.common.table.MdmVslSvcLaneVO;

/**
 * OPUS-JointOperationAgreementSettlement Business Logic Basic Command implementation<br>
 * - OPUS-JointOperationAgreementSettlement: handling business logic<br>
 *
 * @author
 * @see FNS_JOO_0013EventResponse,CarrierSettlementProcessBC DAO class
 * @since J2EE 1.6
 */
public class CarrierSettlementProcessBCImpl extends BasicCommandSupport implements CarrierSettlementProcessBC {

	// Database Access Object
	private transient CarrierSettlementProcessDBDAO dbDao = null;

	/**
	 * CarrierSettlementProcessBCImpl object creation<br>
	 * CarrierSettlementProcessDBDAO creation<br>
	 */
	public CarrierSettlementProcessBCImpl() {
		dbDao = new CarrierSettlementProcessDBDAO();
	}
	/**
	 * retrieving JOO_SETTLEMENT(W/R, PBS, OTH, S/H, OUS RDR, OUS, TDR common)
	 * @param ProcSettlementVO procSettlementVO 
	 * @return List<ProcSettlementVO>
	 * @exception EventException
	 */
	public List<ProcSettlementVO> searchSettlementList(ProcSettlementVO procSettlementVO) throws EventException {
		try {
			return dbDao.searchSettlementList(procSettlementVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Settlement", "Retrieve"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Settlement", "Retrieve"}).getMessage(), ex);
		}
	}

	/**
	 * deleting multiple JOO_SETTLEMENT
	 * 
	 * -parameter : acct_yrmon, jo_crr_cd, re_divr_cd, trd_cd, rlane_cd, jo_stl_itm_cd, jo_mnu_nm
	 * @param ProcSettlementVO procSettlementVO
	 * @return ProcSettlementVO[]
	 * @throws EventException
	 */
	public ProcSettlementVO[] removeSettlement(ProcSettlementVO procSettlementVO) throws EventException {
		ProcSettlementVO[] procSettlementVOs = null;
		try {
			List<ProcSettlementVO> list = dbDao.searchJooSettlementListForDelete(procSettlementVO);
			log.debug("\n\n\nsize="+list.size()+"\n\n\n");
			//Settlement delete
			dbDao.removeSettlementS(list);
			
			procSettlementVOs = new ProcSettlementVO[list.size()];
			
			for(int i=0; i<list.size(); i++){
				procSettlementVOs[i] = list.get(i);
				procSettlementVOs[i].setIbflag("D");
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Settlement", "Remove"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Settlement", "Remove"}).getMessage(), ex);
		}
		return procSettlementVOs;
	}
	
	/**
	 * retrieving VVD not in Joo_settlement in case of clicking Create button in settlement
	 * @param ProcSettlementVO procSettlementVO
	 * @return List<ProcSettlementVO>
	 * @throws EventException
	 */
	public List<ProcSettlementVO> searchAddStlList(ProcSettlementVO procSettlementVO) throws EventException {
		try {
			if (!doesExistStlVvdForSettlement(procSettlementVO)){
				throw new EventException(new ErrorHandler("JOO10009").getMessage());
			}
			return dbDao.searchAddStlList(procSettlementVO);
		} catch (EventException ex){
			throw ex;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Setttlement", "Creation"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Setttlement", "Creation"}).getMessage(), ex);
		}
	}

	/**
	 * retrieving VVD infomation in joo_stl_vvd table in case of inputting VVD
	 * checking validation of inputted VVD
	 * @param ProcSettlementVO procSettlementVO
	 * @return List<ProcSettlementVO>
	 * @throws EventException
	 */
	public List<ProcSettlementVO> searchStlVvd(ProcSettlementVO procSettlementVO) throws EventException {
		try {
			return dbDao.searchStlVvd(procSettlementVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Settlement", "Check VVD"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Settlement", "Check VVD"}).getMessage(), ex);
		}
	}
	
	/**
	 * retrieving JOO_SETTLEMENT in 0037 screen
	 * @param McsStatusVO mcsStatusVO
	 * @return List<McsStatusVO>
	 * @throws EventException
	 */
	public List<McsStatusVO> searchSummaryOfMcsListByTrade (McsStatusVO mcsStatusVO) throws EventException {
		try { 
			mcsStatusVO.setFromDt(mcsStatusVO.getFromDt().replace("-", ""));
			mcsStatusVO.setToDt(mcsStatusVO.getToDt().replace("-", ""));
			return dbDao.searchSummaryOfMcsListByTrade(mcsStatusVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"", ""}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"", ""}).getMessage(), ex);
		}
	}

	/**
	 * retrieving VVD and information not in JOO_SETTLEMENT in case of clicking Create button in FNS_JOO_0007 Slot Hire
	 * @param ProcSettlementVO procSettlementVO
	 * @return List<ProcSettlementVO>
	 * @throws EventException
	 */
	public List<ProcSettlementVO> searchAddStlForSlotHireList(ProcSettlementVO procSettlementVO) throws EventException {
		try {
			//2015.12.14 Modify OPR 일때는 체크 하지 않고 진행 한다.
			if (!JooConstants.KEY_JO_STL_ITM_CD_OPR.equals(procSettlementVO.getJoStlItmCd()) && !doesExistStlVvdForSettlement(procSettlementVO)){
				throw new EventException(new ErrorHandler("JOO10009").getMessage());
			}
			//2015.07.14 Nyk Modify
			if(JooConstants.KEY_SH_OPTION_G6GA.equals(procSettlementVO.getSchTpCd())){
				return dbDao.searchAddStlForSlotHireByG6gaList(procSettlementVO);
			}else{
				return dbDao.searchAddStlForSlotHireList(procSettlementVO);
			}
		} catch (EventException ex){
			throw ex;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Slot Hire Settlement", "Creation"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Slot Hire Settlement", "Creation"}).getMessage(), ex);
		}
	}
	
	/**
	 * retrieving joo_settlement with carrier 0037
	 * @param McsStatusVO mcsStatusVO
	 * @return List<McsStatusVO>
	 * @throws EventException
	 */
	public List<McsStatusVO> searchSummaryOfMcsListByCarrier(McsStatusVO mcsStatusVO) throws EventException {
		try {
			mcsStatusVO.setFromDt(mcsStatusVO.getFromDt().replace("-", ""));
			mcsStatusVO.setToDt(mcsStatusVO.getToDt().replace("-", ""));

			return dbDao.searchSummaryOfMcsListByCarrier(mcsStatusVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"", ""}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"", ""}).getMessage(), ex);
		}
	}
	
	
	/**
	 * 
	 * @param ProcSettlementVO procSettlementVO
	 * @return List<ProcSettlementVO>
	 * @throws EventException
	 */
	public List<ProcSettlementVO> searchAddStlForOusRdrList(ProcSettlementVO procSettlementVO) throws EventException {
		try {
			if (!doesExistStlVvdForSettlement(procSettlementVO)){
				throw new EventException(new ErrorHandler("JOO10009").getMessage());
			}
			return dbDao.searchAddStlForOusRdrList(procSettlementVO);
		} catch (EventException ex){
			throw ex;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Over Used Settlement", "Creation"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Over Used Settlement", "Creation"}).getMessage(), ex);
		}
	}
    /**
     *  UID : FNS_JOO_0039
     *  Monthly Clearance Status by Carrier & Lane - Retrieve 
     *    
     * @param StlConditionVO stlConditionVO
     * @return List<McsVO>
     * @throws EventException
     * @author 
     */
    public List<McsVO> searchMcsListByCarNLane(
            StlConditionVO stlConditionVO) throws EventException {
        try {
            return dbDao.searchMcsListByCarNLane(stlConditionVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"", ""}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"", ""}).getMessage(), ex);
        }
    }
 
    /**
     *  Monthly Clearance Status by Carrier & Lane - Retrieve
     *     UID : FNS_JOO_0039
     * @param StlConditionVO stlConditionVO
     * @param JooSettlementVO[] jooSettlementVOs
     * @return List<McsVO>
     * @throws EventException
     */
    public List<McsVO> searchMccDtlListByCarNLane(StlConditionVO stlConditionVO, JooSettlementVO[] jooSettlementVOs) throws EventException{   
        try {
            return dbDao.searchMccDtlListByCarNLane(stlConditionVO, jooSettlementVOs);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"", ""}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"", ""}).getMessage(), ex);
        }
    }
 
    /**
     * retrieving unit price, used qty in case of selecting inter port / ocean
     * Search Condition : acct_yrmon, jo_crr_cd, re_divr_cd, trd_cd, rlane_cd, jo_stl_itm_cd, jo_mnu_nm, VVD
     * @param ProcSettlementVO procSettlementVO
     * @return List<ProcSettlementVO>
     * @throws EventException
     */
	public List<ProcSettlementVO> searchBsaSltPrc(ProcSettlementVO procSettlementVO) throws EventException {
		try {
			if(procSettlementVO.getIocCd().equals("I")){
				return dbDao.searchBsaSltPrcByInter(procSettlementVO);
			}else{
				return dbDao.searchBsaSltPrc(procSettlementVO);
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Settlement", "BSA Price Retrieve"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Settlement", "BSA Price Retrieve"}).getMessage(), ex);
		}
	}

	/**
	 * 
	 * @param ProcSettlementVO procSettlementVO
	 * @return List<ProcSettlementVO>
	 * @throws EventException
	 */
	public List<ProcSettlementVO> searchAddStlForOusTdrList(ProcSettlementVO procSettlementVO) throws EventException {
		try {
			if (!doesExistStlVvdForSettlement(procSettlementVO)){
				throw new EventException(new ErrorHandler("JOO10009").getMessage());
			}
			return dbDao.searchAddStlForOusTdrList(procSettlementVO);
		} catch (EventException ex){
			throw ex;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"OUS TDR", "Creation"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"OUS TDR", "Creation"}).getMessage(), ex);
		}
	}

	/**
	 * 
	 * @param ProcSettlementVO procSettlementVO
	 * @return List<ProcSettlementVO>
	 * @throws EventException
	 */
	public List<ProcSettlementVO> searchOusTdrFnl(ProcSettlementVO procSettlementVO) throws EventException {
		try {
			return dbDao.searchOusTdrFnl(procSettlementVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"OUS TDR", "Check VVD"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"OUS TDR", "Check VVD"}).getMessage(), ex);
		}
	}

	/**
	 *  
	 * @param ProcSettlementVO procSettlementVO
	 * @return List<ProcSettlementVO>
	 * @throws EventException
	 */
	public List<ProcSettlementVO> searchOusTdrUsedSlot(ProcSettlementVO procSettlementVO) throws EventException {
		try {
			return dbDao.searchOusTdrUsedSlot(procSettlementVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"OUS TDR", "BSA Price Retrieve"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"OUS TDR", "BSA Price Retrieve"}).getMessage(), ex);
		}
	}

	/**
	 * 
	 * @param ProcSettlementVO procSettlementVO
	 * @return List<ProcSettlementVO>
	 * @throws EventException
	 */
	public List<ProcSettlementVO> searchOusTdrUsedSlotPrice(ProcSettlementVO procSettlementVO) throws EventException {
		try {
			return dbDao.searchOusTdrUsedSlotPrice(procSettlementVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"OUS TDR", "Slot Price Retrieve"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"OUS TDR", "Slot Price Retrieve"}).getMessage(), ex);
		}
	}
	
	/**
	 *
	 * @param ProcSettlementVO procSettlementVO
	 * @return List<SettlementRFVO>
	 * @throws EventException
	 */
	public List<SettlementRFVO> searchSettlementRFList(ProcSettlementVO procSettlementVO) throws EventException {
		try {
			return dbDao.searchSettlementRFList(procSettlementVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Reefer Settlement", "Retrieve"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Reefer Settlement", "Retrieve"}).getMessage(), ex);
		}
	}

    /**
	 *
	 * @param ProcSettlementVO procSettlementVO
	 * @return List<SettlementRFVO>
     * @throws EventException
     */
	public List<SettlementRFVO> searchAddStlForRFList(ProcSettlementVO procSettlementVO) throws EventException {
		try {
			if (!doesExistStlVvdForSettlement(procSettlementVO)){
				throw new EventException(new ErrorHandler("JOO10009").getMessage());
			}
			return dbDao.searchAddStlForRFList(procSettlementVO);
		} catch (EventException ex){
			throw ex;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Reefer Settlement", "Creation"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Reefer Settlement", "Creation"}).getMessage(), ex);
		}
	}

	/**
	 * 
	 * @param ProcSettlementVO procSettlementVO
	 * @return List<SettlementRFVO>
     * @throws EventException
     */
	public List<SettlementRFVO> searchUsedReeferList(ProcSettlementVO procSettlementVO) throws EventException {
		try {
			return dbDao.searchUsedReeferList(procSettlementVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Reefer Settlement", "BSA Price Retrieve"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Reefer Settlement", "BSA Price Retrieve"}).getMessage(), ex);
		}
	}


	/**
	 * retrieving Adjustment Slot Hire
	 * @param AdjustConditionVO adjustConditionVO
	 * @return List<AdjustSettlementVO>
	 * @throws EventException
	 */
	public List<AdjustSettlementVO> searchAdjustSlotHireStlList(AdjustConditionVO adjustConditionVO) throws EventException {
		try {
			return dbDao.searchAdjustSlotHireStlList(adjustConditionVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"S/H Adjustment", "Retrieve"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"S/H Adjustment", "Retrieve"}).getMessage(), ex);
		}
	}

	/**
	 * saving Adjust Settlement
	 * @param AdjustSettlementVO[] adjustSettlementVOs 
	 * @param SignOnUserAccount signOnUserAccount
	 * @throws EventException
	 */
	public void manageAdjustSlotHireStl(AdjustSettlementVO[] adjustSettlementVOs, SignOnUserAccount signOnUserAccount) throws EventException{
		try {
			JooStlDtlVO jooStlDtlVO = null;
			AdjustSettlementVO adjustSettlementVO = null;
			JooSettlementVO jooSettlementVO = null;
			List<JooStlVvdVO> tmpTargetVVDVOs = new ArrayList<JooStlVvdVO>();
			for ( int i=0; i<adjustSettlementVOs.length; i++ ) {
				adjustSettlementVO = adjustSettlementVOs[i];
				
				if (adjustSettlementVO.getJoStlJbCd() == null || "".equals(adjustSettlementVO.getJoStlJbCd()))
					continue;
				
				if (adjustSettlementVO.getIbflag().equals("I")){
					
					tmpTargetVVDVOs = dbDao.searchStlVvdSeq(adjustSettlementVO);
					adjustSettlementVO.setStlVvdSeq(tmpTargetVVDVOs.get(0).getStlVvdSeq());

					adjustSettlementVO.setCreUsrId(signOnUserAccount.getUsr_id());
					adjustSettlementVO.setUpdUsrId(signOnUserAccount.getUsr_id());
					
					//         STL_ADJ_FLG   STL_LST_FLG
					//Adjust BEF     N             Y        
					//Adjust AFT     N             N
					//New Row(S/H)   Y             Y
					//NEW ROW(M/S)   Y             N   
					
					if ("0".equals(adjustSettlementVO.getStlAdjIrrFlg())){
						adjustSettlementVO.setStlAdjIrrFlg("N");
						adjustSettlementVO.setStlLstFlg   ("N");
						adjustSettlementVO.setStlAdjFlg   ("N");

					}else{
						adjustSettlementVO.setStlAdjIrrFlg("Y");
						adjustSettlementVO.setStlLstFlg   ("Y");
						adjustSettlementVO.setStlAdjFlg   ("N");
					}
					dbDao.modifyAdjustSettlement(adjustSettlementVO);
					
					if ("N".equals(adjustSettlementVO.getStlAdjIrrFlg())){
						int stlSeq = dbDao.searchNextStlSeq(adjustSettlementVO);
						adjustSettlementVO.setStlSeq(stlSeq+"");
						
						if ("M/S".equals(adjustSettlementVO.getJoMnuNm())){
							adjustSettlementVO.setStlLstFlg("N");
						}else{
							adjustSettlementVO.setStlLstFlg("Y");
						}
	
						adjustSettlementVO.setStlAdjFlg("Y");
						adjustSettlementVO.setStlAdjIrrFlg("N");
						adjustSettlementVO.setStlAdjIrrRmk("");
						adjustSettlementVO.setCmbCfmFlg("N");
						dbDao.addAdjustSettlement(adjustSettlementVO);
					
						if (adjustSettlementVO.getDtlBsaQty() != null && !adjustSettlementVO.getDtlBsaQty().equals("0")){
							jooStlDtlVO = makeJooStlDtlVOFromAdjustSettlementVO(adjustSettlementVO, "T");
							jooStlDtlVO.setCreUsrId(signOnUserAccount.getUsr_id());
							dbDao.addJooStlDtl(jooStlDtlVO);
						}
						
						if (adjustSettlementVO.getDtlBsaSltPrc() != null && !adjustSettlementVO.getDtlBsaSltPrc().equals("0") 
								&& StringUtils.isNotEmpty(adjustSettlementVO.getAdjBsaSltPrcLoclAmt())){
							jooStlDtlVO = makeJooStlDtlVOFromAdjustSettlementVO(adjustSettlementVO, "P");
							jooStlDtlVO.setCreUsrId(signOnUserAccount.getUsr_id());
							dbDao.addJooStlDtl(jooStlDtlVO);
						}
					}

				} else if ( adjustSettlementVO.getIbflag().equals("U")){
					if ("0".equals(adjustSettlementVO.getStlAdjIrrFlg()))
						adjustSettlementVO.setStlAdjIrrFlg("N");
					else
						adjustSettlementVO.setStlAdjIrrFlg("Y");
						
					adjustSettlementVO.setUpdUsrId(signOnUserAccount.getUsr_id());
					dbDao.modifyAdjustSettlement(adjustSettlementVO);
				} else if ( adjustSettlementVO.getIbflag().equals("D")){
					if ("0".equals(adjustSettlementVO.getStlAdjIrrFlg()))
						adjustSettlementVO.setStlAdjIrrFlg("N");
					else
						adjustSettlementVO.setStlAdjIrrFlg("Y");

					adjustSettlementVO.setStlLstFlg("Y");
					adjustSettlementVO.setUpdUsrId(signOnUserAccount.getUpd_usr_id());
					dbDao.modifyAdjustSettlement(adjustSettlementVO);

					dbDao.removeJooStlDtl(adjustSettlementVO);

					jooSettlementVO = makeJooSettlementVOFromAdjustSettlementVO(adjustSettlementVO);
					dbDao.removeSettlement(jooSettlementVO);
				}
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"S/H Adjustment", "Save"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"S/H Adjustment", "Save"}).getMessage(), ex);
		}
	}
	

	/**
	 * creating JooSettlementVO by AdjustSettlementVO
	 * @param AdjustSettlementVO adjustSettlementVO
	 * @return JooSettlementVO
	 * @throws EventException
	 */
	private JooSettlementVO makeJooSettlementVOFromAdjustSettlementVO(AdjustSettlementVO adjustSettlementVO) throws EventException{
		JooSettlementVO jooSettlementVO = new JooSettlementVO();
		try{
			jooSettlementVO.setAcctYrmon           (adjustSettlementVO.getAcctYrmon           ()); 
			jooSettlementVO.setStlSeq              (adjustSettlementVO.getStlSeq              ()); 
			jooSettlementVO.setStlVvdSeq           (adjustSettlementVO.getStlVvdSeq           ()); 
			jooSettlementVO.setTrdCd               (adjustSettlementVO.getTrdCd               ()); 
			jooSettlementVO.setJoCrrCd             (adjustSettlementVO.getJoCrrCd             ()); 
			jooSettlementVO.setRlaneCd             (adjustSettlementVO.getRlaneCd             ()); 
			jooSettlementVO.setReDivrCd            (adjustSettlementVO.getReDivrCd            ()); 
			jooSettlementVO.setJoStlItmCd          (adjustSettlementVO.getJoStlItmCd          ()); 
			jooSettlementVO.setJoMnuNm             (adjustSettlementVO.getJoMnuNm             ()); 
			jooSettlementVO.setVslCd               (adjustSettlementVO.getVslCd               ()); 
			jooSettlementVO.setSkdVoyNo            (adjustSettlementVO.getSkdVoyNo            ()); 
			jooSettlementVO.setSkdDirCd            (adjustSettlementVO.getSkdDirCd            ()); 
			jooSettlementVO.setRevDirCd            (adjustSettlementVO.getRevDirCd            ()); 
			jooSettlementVO.setStlBzcPortCd        (adjustSettlementVO.getStlBzcPortCd        ()); 
			jooSettlementVO.setEtaDt               (adjustSettlementVO.getEtaDt               ()); 
			jooSettlementVO.setJoStlJbCd           (adjustSettlementVO.getJoStlJbCd           ()); 
			jooSettlementVO.setBsaQty              (adjustSettlementVO.getBsaQty              ()); 
			jooSettlementVO.setBsaSltPrc           (adjustSettlementVO.getBsaSltPrc           ()); 
			jooSettlementVO.setLoclCurrCd          (adjustSettlementVO.getLoclCurrCd          ()); 
			jooSettlementVO.setAdjBsaQtyLoclAmt    (adjustSettlementVO.getAdjBsaQtyLoclAmt    ()); 
			jooSettlementVO.setAdjBsaSltPrcLoclAmt (adjustSettlementVO.getAdjBsaSltPrcLoclAmt ()); 
			jooSettlementVO.setStlLoclAmt          (adjustSettlementVO.getStlLoclAmt          ()); 
			jooSettlementVO.setStlUsdAmt           (adjustSettlementVO.getStlUsdAmt           ()); 
			jooSettlementVO.setIocCd               (adjustSettlementVO.getIocCd               ()); 
			jooSettlementVO.setScontiCd            (adjustSettlementVO.getScontiCd            ()); 
			jooSettlementVO.setFnlOwnBsaQty        (adjustSettlementVO.getFnlOwnBsaQty        ()); 
			jooSettlementVO.setFnlBsaWgt           (adjustSettlementVO.getFnlBsaWgt           ()); 
			jooSettlementVO.setUsdSltBsaQty        (adjustSettlementVO.getUsdSltBsaQty        ()); 
			jooSettlementVO.setUsdSltWgt           (adjustSettlementVO.getUsdSltWgt           ()); 
			jooSettlementVO.setBsaPerWgt           (adjustSettlementVO.getBsaPerWgt           ()); 
			jooSettlementVO.setFmPortCd            (adjustSettlementVO.getFmPortCd            ()); 
			jooSettlementVO.setToPortCd            (adjustSettlementVO.getToPortCd            ()); 
			jooSettlementVO.setRfScgStlTpCd        (adjustSettlementVO.getRfScgStlTpCd        ()); 
			jooSettlementVO.setRfScgPrc            (adjustSettlementVO.getRfScgPrc            ()); 
			jooSettlementVO.setStlRmk              (adjustSettlementVO.getStlRmk              ()); 
			jooSettlementVO.setCmbCfmFlg           (adjustSettlementVO.getCmbCfmFlg           ()); 
			jooSettlementVO.setStlTjNo             (adjustSettlementVO.getStlTjNo             ()); 
			jooSettlementVO.setStlAdjFlg           (adjustSettlementVO.getStlAdjFlg           ()); 
			jooSettlementVO.setPreAcctYrmon        (adjustSettlementVO.getPreAcctYrmon        ()); 
			jooSettlementVO.setPreStlVvdSeq        (adjustSettlementVO.getPreStlVvdSeq        ()); 
			jooSettlementVO.setPreStlSeq           (adjustSettlementVO.getPreStlSeq           ()); 
			jooSettlementVO.setStlLstFlg           (adjustSettlementVO.getStlLstFlg           ()); 
			jooSettlementVO.setUcBssPortCd         (adjustSettlementVO.getUcBssPortCd         ()); 
			jooSettlementVO.setUcBssPortEtdDt      (adjustSettlementVO.getUcBssPortEtdDt      ()); 
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Adjustment", "Moving Data From AdjustSettlementVO to JooSettlementVO"}).getMessage(), ex);
		}
		return jooSettlementVO;
	}

	/**
	 * creating AdjustSettlementVO by JooStlDtlVO
	 * @param AdjustSettlementVO adjustSettlementVO
	 * @param String flag 
	 * @return JooStlDtlVO
	 * @throws EventException
	 */
	private JooStlDtlVO makeJooStlDtlVOFromAdjustSettlementVO(AdjustSettlementVO adjustSettlementVO, String flag) throws EventException{
		JooStlDtlVO jooStlDtlVO = new JooStlDtlVO();
		try{
			jooStlDtlVO.setAcctYrmon (adjustSettlementVO.getAcctYrmon ()); 
			jooStlDtlVO.setStlSeq    (adjustSettlementVO.getStlSeq    ()); 
			jooStlDtlVO.setStlVvdSeq (adjustSettlementVO.getStlVvdSeq ());
			//TEU changed
			if ("T".equals(flag)){
				jooStlDtlVO.setStlDtlSeq ("1");
				jooStlDtlVO.setBsaQty    (adjustSettlementVO.getDtlBsaQty()); 
				jooStlDtlVO.setBsaSltPrc (adjustSettlementVO.getBsaSltPrc()); 
				jooStlDtlVO.setStlLoclAmt(adjustSettlementVO.getAdjBsaQtyLoclAmt());  //
			//Price changed
			}else if ("P".equals(flag)){
				jooStlDtlVO.setStlDtlSeq ("2");
				jooStlDtlVO.setBsaQty    (adjustSettlementVO.getBsaQty1     ()); 
				jooStlDtlVO.setBsaSltPrc (adjustSettlementVO.getDtlBsaSltPrc()); 
				jooStlDtlVO.setStlLoclAmt(adjustSettlementVO.getAdjBsaSltPrcLoclAmt()); // 
			}
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Adjustment", "Moving Data From AdjustSettlementVO to JooStlDtlVO"}).getMessage(), ex);
		}
		return jooStlDtlVO;
	}
    /**
     * 
     * FNS_JOO_0015 <br>
     * retrieving carrier infomation in Monthly Clearance by Carrier & Lane.<br>
     *
     * @param StlConditionVO stlConditionVO
     * @return List<SettlementVO>
     * @throws EventException
     * @author 
     */
    public List<SettlementVO> searchMonthlyClearanceList(
            StlConditionVO stlConditionVO) throws EventException {
        try {
            return dbDao.searchMonthlyClearanceList(stlConditionVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Monthly Clearance", "Retrieve"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Monthly Clearance", "Retrieve"}).getMessage(), ex);
        }
    }
    /**
     * FNS_JOO_0038 : Retrieve
     * D : [FnsJoo0038Event]<br>
     * retrieving Summary of Monthly Clearance Status by VVD<br>
     * 
     * @param McsStatusVO mcsStatusVO
     * @return List<McsStatusReportVO>
     * @throws EventException
     * @author 
     */
    public List<McsStatusReportVO> searchSummaryOfMcsListByVVD(
            McsStatusVO mcsStatusVO) throws EventException {
        try {
            return dbDao.searchSummaryOfMcsListByVVD(mcsStatusVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Summary of Monthly Clearance", "Retrieve"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Summary of Monthly Clearance", "Retrieve"}).getMessage(), ex);
        }
    }
    
    /**
     * FNS_JOO_0042 : Retrieve
     * D : [FnsJoo0042Event]<br>
     * retrieving Slot Exchange Status by Lane & Partner->Finance Lane.<br>
     *
     * @param  SlotXchLaneVO slotXchLaneVO
     * @return List<SlotXchLaneVO>
     * @throws EventException
     * @author 
     */
    public  List<SlotXchLaneVO> searchSlotXchStatusListByFinanceLane( SlotXchLaneVO slotXchLaneVO ) throws EventException{  
        try {
            return dbDao.searchSlotXchStatusListByFinanceLane(slotXchLaneVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Slot Exchange Status", "Retrieve"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Slot Exchange Status", "Retrieve"}).getMessage(), ex);
        }
    }

    /**
     * FNS_JOO_0043 : Retrieve
     * D : [FnsJoo0043Event]<br>
     * retrieving [ Slot Exchange Status by Lane & Partner->Finance  Partner]<br>
     *
     * @param  SlotXchPartnerVO slotXchPartnerVO
     * @return List<SlotXchPartnerVO>
     * @throws EventException
     * @author 
     */    
    public List<SlotXchPartnerVO> searchSlotXchStatusListByFinancePartner(
            SlotXchPartnerVO slotXchPartnerVO) throws EventException {
        try {
            return dbDao.searchSlotXchStatusListByFinancePartner( slotXchPartnerVO );
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Slot Exchange Status", "Retreive"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Slot Exchange Status", "Retreive"}).getMessage(), ex);
        }
    }    
    
//    /**
//     * 
//     * FNS_JOO_0040 <br> 
//     * 
//     *
//     * @param SlotXchLaneVO slotXchLaneVO
//     * @return List<SlotXchLaneVO>
//     * @throws EventException
//     * @author 
//     */
//    public  List<SlotXchLaneVO>    searchSlotXchStatusListBySpaceLane( SlotXchLaneVO slotXchLaneVO ) throws EventException{  
//        try {
//            return dbDao.searchSlotXchStatusListBySpaceLane(slotXchLaneVO);
//		} catch (DAOException ex) {
//			log.error("err " + ex.toString(), ex);
//			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Slot Exchange Status", "Retrieve"}).getMessage(), ex);
//		} catch (Exception ex) {
//			log.error("err " + ex.toString(), ex);
//			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Slot Exchange Status", "Retrieve"}).getMessage(), ex);
//        }
//    }
    
//    /**
//     * 
//     * FNS_JOO_0041 <br> 
//     * 
//     *
//     * @param SlotXchPartnerVO slotXchPartnerVO
//     * @return List<SlotXchPartnerVO>
//     * @throws EventException
//     * @author 
//     */
//    public  List<SlotXchPartnerVO> searchSlotXchStatusListBySpacePartner(SlotXchPartnerVO slotXchPartnerVO) throws EventException{
//        try {
//            return dbDao.searchSlotXchStatusListBySpacePartner(slotXchPartnerVO);
//		} catch (DAOException ex) {
//			log.error("err " + ex.toString(), ex);
//			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Slot Exchange Status", "Retrieve"}).getMessage(), ex);
//		} catch (Exception ex) {
//			log.error("err " + ex.toString(), ex);
//			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Slot Exchange Status", "Retrieve"}).getMessage(), ex);
//        }        
//        
//    }
    /**
     * FNS_JOO_0049 <br> 
     * retrieving [ Settlement Status for Basic Allocation]<br>
     *
     * @param  StlConditionVO stlConditionVO
     * @return  List<StlStatusBsaVO>
     * @throws EventException
     * @author 
     */
    public List<StlStatusBsaVO> searchStlStatusListForBSA(StlConditionVO stlConditionVO)
            throws EventException {
        try { 
            return dbDao.searchStlStatusListForBSA( stlConditionVO );
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Settlement Status for Basic Allocation", "Retrieve"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Settlement Status for Basic Allocation", "Retrieve"}).getMessage(), ex);
        }
    }

    /**
     * FNS_JOO_0050 <br> 
     * retrieving [ Target Voyage vs Unsettled Status]<br>
     *
     * @param  StlConditionVO stlConditionVO
     * @return  List<StlStatusVO>
     * @throws EventException
     * @author 
     */
    public List<StlStatusVO> searchTgtVoyVsUnstlStatusList(StlConditionVO stlConditionVO)
            throws EventException {
        try {
            return dbDao.searchTgtVoyVsUnstlStatusList( stlConditionVO );
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Target Voyage vs Unsettled Status", "Retrieve"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Target Voyage vs Unsettled Status", "Retrieve"}).getMessage(), ex);
        }
    }
   
    /**
     * FNS_JOO_0050 <br> 
     * retrieving [lane cd exists or not]<br>
     *
     * @param  MdmVslSvcLaneVO mdmVslSvcLaneVO
     * @return  List<MdmVslSvcLaneVO>
     * @throws EventException
     * @author
     */
    public List<MdmVslSvcLaneVO> searchLaneCdYn (MdmVslSvcLaneVO mdmVslSvcLaneVO)
            throws EventException {
        try {
            return dbDao.searchLaneCdYn(mdmVslSvcLaneVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Lane Cd", "Validation Check"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Lane Cd", "Validation Check"}).getMessage(), ex);
        }
    }

    /**
     * FNS_JOO_0054 <br> 
     * retrieving [ TDR Creation Inquiry]<br>
     *
     * @param String fromDt
     * @param String toDt
     * @param String lane
     * @return List<TdrByLaneVO>
     * @throws EventException
     * @author
     */
    public List<TdrByLaneVO> searchTDRCreateListByLane (String fromDt, String toDt, String lane)
            throws EventException {
        try {
            return dbDao.searchTDRCreateListByLane(fromDt, toDt, lane);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"TDR Creation", "Retrieve"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"TDR Creation", "Retrieve"}).getMessage(), ex);
        }
    }
    
    /**
     * FNS_JOO_0054 <br> 
     * retrieving [ RDR Upload Inquiry]<br>
     *
     * @param String fromDt
     * @param String toDt
     * @param String lane
     * @return List<RdrByLaneVO>
     * @throws EventException
     * @author
     */
    public List<RdrByLaneVO> searchRDRCreateListByLane (String fromDt, String toDt, String lane)
            throws EventException {
        try {
            return dbDao.searchRDRCreateListByLane(fromDt, toDt, lane);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"RDR Creation", "Retrieve"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"RDR Creation", "Retrieve"}).getMessage(), ex);
        }
    }

    /**
     * updating cmb_cfm_flg in settlement in case of combined work. 
     * @param CombinedVO[] combinedVOs
     * @param SignOnUserAccount signOnUserAccount
     * @throws EventException
     */
	public void manageCombinedMonthlyClearance(CombinedVO[] combinedVOs, SignOnUserAccount signOnUserAccount) throws EventException{
		try {
			for(int i=0; i<combinedVOs.length; i++){
				combinedVOs[i].setUpdUsrId(signOnUserAccount.getUsr_id());
				combinedVOs[i].setCmbCfmFlg("Y");
				dbDao.modifySettlementSetCmbCfmFlg(combinedVOs[i]);
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Combined Settlement", "Updating Combined Confirm Flag"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Combined Settlement", "Updating Combined Confirm Flag"}).getMessage(), ex);
		}
	}
	
	/**
	 * canceling combined settlement information
	 * @param CombinedVO[] combinedVOs
	 * @param SignOnUserAccount signOnUserAccount
	 * @throws EventException
	 */
	public void removeCombinedMonthlyClearance(CombinedVO[] combinedVOs, SignOnUserAccount signOnUserAccount) throws EventException{
		try {
			for(int i=0; i<combinedVOs.length; i++){
				combinedVOs[i].setUpdUsrId(signOnUserAccount.getUsr_id());
				combinedVOs[i].setCmbCfmFlg("N");
				dbDao.modifySettlementSetCmbCfmFlg(combinedVOs[i]);
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Combined Settlement", "Cancel"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Combined Settlement", "Cancel"}).getMessage(), ex);
		}
	}
	
	/**
	 * 
	 * @param List<JooStlCmbDtlVO> jooStlCmbDtlVOs
	 * @param SignOnUserAccount signOnUserAccount
	 * @throws EventException
	 */
	public void createReverseSlip(List<JooStlCmbDtlVO> jooStlCmbDtlVOs, SignOnUserAccount signOnUserAccount) throws EventException{
		try {
			@SuppressWarnings("rawtypes")
			Iterator iterator = jooStlCmbDtlVOs.iterator();
			CombinedVO combinedVO = new CombinedVO();
			while(iterator.hasNext()){
				JooStlCmbDtlVO jooStlCmbDtlVO = (JooStlCmbDtlVO)iterator.next();
				combinedVO.setAcctYrmon(jooStlCmbDtlVO.getAcctYrmon());
				combinedVO.setStlVvdSeq(jooStlCmbDtlVO.getStlVvdSeq());
				combinedVO.setStlSeq   (jooStlCmbDtlVO.getStlSeq   ());
				combinedVO.setUpdUsrId (signOnUserAccount.getUsr_id());
				combinedVO.setCmbCfmFlg("N");
				dbDao.modifySettlementSetCmbCfmFlgCxl(combinedVO);
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Reverse CSR Creation", "Update CMB_CFM_FLG"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Reverse CSR Creation", "Update CMB_CFM_FLG"}).getMessage(), ex);
		}
	}
    /**
     * FNS_JOO_0056: Retrieve
     * D : [FnsJoo0056Event]<br>
     * retrieving RDR Load DownLoad by Lane<br>
     * 
     * @param  RdrLoadVO rdrLoadVO
     * @return List<RdrLoadVO>
     * @throws EventException
     * @author 
     */
    public List<RdrLoadVO> searchRDRDownloadListByLane(RdrLoadVO rdrLoadVO) throws EventException{
        try {
            return dbDao.searchRDRDownloadListByLane( rdrLoadVO );
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"", ""}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"", ""}).getMessage(), ex);
        }
    }

    /**
     * FNS_JOO_0056: SAVE
     * D : [FnsJoo0056Event]<br>
     * saving JOO_RDR_VVD_CRR_RMK<br>
     * 
	 * @param  RdrLoadVO[] rdrLoadVOs
	 * @param  SignOnUserAccount account
     * @throws EventException
     */
	public void manageRDRVVDCrrRmk(RdrLoadVO[] rdrLoadVOs, SignOnUserAccount account) throws EventException{
		try {
			for (int i=0; i<rdrLoadVOs.length; i++) {
				rdrLoadVOs[i].setUsrId(account.getUsr_id());
				if (dbDao.addManageRDRVVDCrrRmk(rdrLoadVOs[i]) == 1) {
					dbDao.modifyManageRDRVVDCrrRmk(rdrLoadVOs[i]);
				}
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"", ""}).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"", ""}).getMessage(), ex);
		}
	}

    /**
     * retrieving in case of inputting VVD in Other-Other of settlement
     * @param ProcSettlementVO procSettlementVO
     * @return String
     * @throws EventException
     */
	public String searchStlVvdOth(ProcSettlementVO procSettlementVO) throws EventException {
		String rtnVal = "";
		try {
			
			List<EstmActRsltVO> list = dbDao.searchStlVvdOth(procSettlementVO);
			
			if (list.isEmpty()){
				rtnVal = "E";
			}else{
				String revYrmon = list.get(0).getRevYrmon(); 
				//FNS_JOO_0053 screen POP-UP
				if (revYrmon == null || "".equals(revYrmon) || "null".equals(revYrmon)){
					rtnVal = "P";
				}else{
					rtnVal = "N";
				}
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Other Settlement", "VVD Validation Check"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Other Settlement", "VVD Validation Check"}).getMessage(), ex);
		}
		return rtnVal;
	}
	
	/**
	 * retrieving slipped data
	 * @param ProcSettlementVO procSettlementVO
	 * @return List<ManualStlVvdVO>
	 * @throws EventException
	 */
	public List<ManualStlVvdVO> searchVVDOfNotExistRevMonList(ProcSettlementVO procSettlementVO) throws EventException {
		try {
			return dbDao.searchVVDOfNotExistRevMonList(procSettlementVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Other Settlement", "History of Slip Retrieve"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Other Settlement", "History of Slip Retrieve"}).getMessage(), ex);
		}
	}    
    /**
     * FNS_JOO_0057: Retrieve
     * D : [FnsJoo0057Event]<br>
     * retrieving RDR Load DownLoad by VVD<br>
     * 
     * @param TdrLoadVO tdrLoadVO
     * @return List<TdrLoadVO>
     * @throws EventException
     * @author 
     */
    public List<TdrLoadVO> searchTDRDownloadListByLane(TdrLoadVO tdrLoadVO)
            throws EventException {
        try {
            return dbDao.searchTDRDownloadListByLane( tdrLoadVO );
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"", ""}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"", ""}).getMessage(), ex);
		}
    }

    /**
     * 
     * @param AdjustConditionVO adjustConditionVO
     * @return List<AdjustOusRDRVO>
     * @throws EventException
     */
//	public List<AdjustOusRDRVO> searchAdjustOusListForRDR(AdjustConditionVO adjustConditionVO) throws EventException {
//		try {
//			return dbDao.searchAdjustOusListForRDR(adjustConditionVO);
//		} catch (DAOException ex) {
//			log.error("err " + ex.toString(), ex);
//			throw new EventException(new ErrorHandler("JOO10007", new String[]{"OUS RDR Adjustment", "Retrieve"}).getMessage(), ex);
//		} catch (Exception ex) {
//			log.error("err " + ex.toString(), ex);
//			throw new EventException(new ErrorHandler("JOO10007", new String[]{"OUS RDR Adjustment", "Retrieve"}).getMessage(), ex);
//		}
//	}
	
	/**
	 * checking whether data exists or not
	 * @param ProcSettlementVO procSettlementVO 
	 * @return boolean
	 * @exception EventException
	 */
	private boolean doesExistStlVvdForSettlement(ProcSettlementVO procSettlementVO) throws EventException {
		boolean aBol = false;
		try {
			List<ProcSettlementVO> list = dbDao.searchStlVvdForSettlement(procSettlementVO);
			
			if (!list.isEmpty()){
				aBol = true;
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Target VVD", "Retrieve For Settlement"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Target VVD", "Retrieve For Settlement"}).getMessage(), ex);
		}
		return aBol;
	}

	/**
	 * retrieving Revenue Direction List
	 * @param ProcSettlementVO procSettlementVO 
	 * @return List<ProcSettlementVO>
	 * @exception EventException
	 */
	public List<ProcSettlementVO> searchRevDirList(ProcSettlementVO procSettlementVO) throws EventException {
		try {
			return dbDao.searchRevDirList(procSettlementVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Revenue Direction List", "Retrieve"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Revenue Direction List", "Retrieve"}).getMessage(), ex);
		}
	}

    /**
     * retrieving Used Slot Information
     * parameter : jo_crr_cd, re_divr_cd, VVD
     * @param ProcSettlementVO procSettlementVO
     * @return List<ProcSettlementVO>
     * @throws EventException
     */
	public List<ProcSettlementVO> searchUsedSlotInfo(ProcSettlementVO procSettlementVO) throws EventException {
		try {
			return dbDao.searchUsedSlotInfo(procSettlementVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Used Slot Information", "Retrieve"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Used Slot Information", "Retrieve"}).getMessage(), ex);
		}
	}

	/**
	 * 
	 * checking validation of inputted VVD
	 * @param ProcSettlementVO procSettlementVO
	 * @return List<ProcSettlementVO>
	 * @throws EventException
	 */
	public List<ProcSettlementVO> searchStlVvdOusRdr(ProcSettlementVO procSettlementVO) throws EventException {
		try {
			return dbDao.searchStlVvdOusRdr(procSettlementVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Settlement", "Check VVD"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Settlement", "Check VVD"}).getMessage(), ex);
		}
	}

    /**
     * 
     * @param ProcSettlementVO procSettlementVO
     * @return List<SettlementRFVO>
     * @throws EventException
     */
	public List<SettlementRFVO> searchRfIOChange(ProcSettlementVO procSettlementVO) throws EventException {
		try {
			return dbDao.searchRfIOChange(procSettlementVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"R/F I/O Change", "Retrieve"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"R/F I/O Change", "Retrieve"}).getMessage(), ex);
		}
	}

    /**
     * 
     * @param ProcSettlementVO procSettlementVO
     * @return List<SettlementRFVO>
     * @throws EventException
     */
	public List<SettlementRFVO> searchRfRgnChange(ProcSettlementVO procSettlementVO) throws EventException {
		try {
			return dbDao.searchRfRgnChange(procSettlementVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"R/F RGN Change", "Retrieve"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"R/F RGN Change", "Retrieve"}).getMessage(), ex);
		}
	}
    /**
     * retrieving StlCmbSeq List of Monthly Clearance<br>
     * FNS_JOO_0015
     * @param StlConditionVO stlConditionVO
     * @throws EventException
     * @return List<SettlementVO>
     * @author 
     */
     public List<SettlementVO> searchMonthlyStlCmbSeqList(StlConditionVO stlConditionVO) throws EventException {
        try {
            return dbDao.searchMonthlyStlCmbSeqList(stlConditionVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("JOO10007", new String[]{"Monthly Clearance", "Retrieve"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("JOO10007", new String[]{"Monthly Clearance", "Retrieve"}).getMessage(), ex);
        }
    }

 	/**
 	 * checking duplication and saving
 	 * 적용 ITEM : P/B, W/R, OTH
 	 * @param ProcSettlementVO[] procSettlementVOs
 	 * @param SignOnUserAccount signOnUserAccount
 	 * @return List<ProcSettlementVO>
 	 * @throws EventException
 	 */
 	public List<ProcSettlementVO> manageSettlement(ProcSettlementVO[] procSettlementVOs, SignOnUserAccount signOnUserAccount) throws EventException{
 		List<ProcSettlementVO> list = null;
 		try {
 			list = new ArrayList<ProcSettlementVO>();
 			
 			for (int i=0; i < procSettlementVOs.length; i++){
 				list.add(procSettlementVOs[i]);
 				
 				
 				if ("D".equals(procSettlementVOs[i].getIbflag())){
 					dbDao.removeSettlement(list.get(i));
 				}
 			}

 			int iRtn = 0; 

 			String ibFlag = "";
 			String stlDupFlg= "";	
 			int iDupCnt = 0;

 			
 			for (int i=0; i < list.size(); i++){
 				
 				ibFlag = list.get(i).getIbflag();
 				
 				if ("R".equals(ibFlag) || "D".equals(ibFlag))
 					continue;

 				stlDupFlg = list.get(i).getStlDupFlg();
 				
 				if ("P/B".equals(list.get(i).getJoStlItmCd()) || "W/R".equals(list.get(i).getJoStlItmCd())){
 	 				iRtn  = dbDao.searchSettlementDupChkWithSlip(list.get(i));

 	 				if (iRtn == 0){
 	 	 				iRtn  = dbDao.searchSettlementDupChk(list.get(i));
 	 				}

 				}else{
 	 				iRtn  = dbDao.searchSettlementDupChk(list.get(i));
 				}

 				if ("U".equals(ibFlag)){

 					if (!"Y".equals(stlDupFlg)){
 						if (iRtn > 0){
 							list.get(i).setStlDupFlg("Y");
 							iDupCnt++;
 							break;
 						}

 					}else{
 						if (iRtn == 0){
 							list.get(i).setStlDupFlg("N");
 						}
 					}
 					list.get(i).setUpdUsrId(signOnUserAccount.getUsr_id());
 					dbDao.modifySettlement(list.get(i));
 				}else if ("I".equals(ibFlag)){
 					if (!"Y".equals(stlDupFlg)){
 						if (iRtn > 0){
 							list.get(i).setStlDupFlg("Y");
 							iDupCnt++;
 							break;
 						}
 					}
 					list.get(i).setCreUsrId(signOnUserAccount.getUsr_id());
 					dbDao.addSettlement(list.get(i));
 				}
 			}
 			
 			if (iDupCnt > 0){
 				list.get(0).setDupFlg("E");
 			}else{
 				list.get(0).setDupFlg("N");
 			}
 		} catch (DAOException ex) {
 			log.error("err " + ex.toString(), ex);
 			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Settlement", "Save"}).getMessage(), ex);
 		} catch (Exception ex) {
 			log.error("err " + ex.toString(), ex);
 			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Settlement", "Save"}).getMessage(), ex);
 		}
 		
 		return list;
 	}

 	
 	/**
 	 * creating SettlementRFVO by procSettlementVO
 	 * @param SettlementRFVO settlementRFVO
 	 * @param ProcSettlementVO procSettlementVO
 	 * @param String flg
 	 */
 	private void setSettlementRFVO2ProcSettlementVO(SettlementRFVO settlementRFVO, ProcSettlementVO procSettlementVO, String flg){
		procSettlementVO.setIbflag        (settlementRFVO.getIbflag        ());
		procSettlementVO.setVslCd         (settlementRFVO.getVslCd         ());
		procSettlementVO.setSkdVoyNo      (settlementRFVO.getSkdVoyNo      ());
		procSettlementVO.setSkdDirCd      (settlementRFVO.getSkdDirCd      ());
		procSettlementVO.setRevDirCd      (settlementRFVO.getRevDirCd      ());
		procSettlementVO.setStlBzcPortCd  (settlementRFVO.getStlBzcPortCd  ());
		procSettlementVO.setEtaDt         (settlementRFVO.getEtaDt         ());
		procSettlementVO.setUcBssPortCd   (settlementRFVO.getUcBssPortCd   ());
		procSettlementVO.setRfScgStlTpCd  (settlementRFVO.getRfScgStlTpCd  ());
		procSettlementVO.setIocCd         (settlementRFVO.getIocCd         ());
		procSettlementVO.setScontiCd      (settlementRFVO.getScontiCd      ());
		procSettlementVO.setFmPortCd      (settlementRFVO.getFmPortCd      ());
		procSettlementVO.setToPortCd      (settlementRFVO.getToPortCd      ());
		procSettlementVO.setLoclCurrCd    (settlementRFVO.getLoclCurrCd    ());
		procSettlementVO.setAcctYrmon     (settlementRFVO.getAcctYrmon     ());
		procSettlementVO.setStlVvdSeq     (settlementRFVO.getStlVvdSeq     ());
		procSettlementVO.setTrdCd         (settlementRFVO.getTrdCd         ());
		procSettlementVO.setJoCrrCd       (settlementRFVO.getJoCrrCd       ());
		procSettlementVO.setRlaneCd       (settlementRFVO.getRlaneCd       ());
		procSettlementVO.setReDivrCd      (settlementRFVO.getReDivrCd      ());
		procSettlementVO.setJoStlItmCd    (settlementRFVO.getJoStlItmCd    ());
		procSettlementVO.setJoMnuNm       (settlementRFVO.getJoMnuNm       ());
		procSettlementVO.setUcBssPortEtdDt(settlementRFVO.getUcBssPortEtdDt());
		
 		if ("20".equals(flg)){
 			procSettlementVO.setJoStlJbCd   ("301");
			procSettlementVO.setStlSeq      (settlementRFVO.getStlSeq20      ());
			procSettlementVO.setUsdSltBsaQty(settlementRFVO.getUsdSltBsaQty20());
			procSettlementVO.setRfScgPrc    (settlementRFVO.getRfScgPrc20    ());
			procSettlementVO.setStlLoclAmt  (settlementRFVO.getStlLoclAmt20  ());
			procSettlementVO.setStlAdjFlg   (settlementRFVO.getStlAdjFlg20   ());
			procSettlementVO.setStlLstFlg   (settlementRFVO.getStlLstFlg20   ());
			procSettlementVO.setStlDupFlg   (settlementRFVO.getStlDupFlg20   ());
 		}else if ("40".equals(flg)){
 			procSettlementVO.setJoStlJbCd   ("302");
			procSettlementVO.setStlSeq      (settlementRFVO.getStlSeq40      ());
			procSettlementVO.setUsdSltBsaQty(settlementRFVO.getUsdSltBsaQty40());
			procSettlementVO.setRfScgPrc    (settlementRFVO.getRfScgPrc40    ());
			procSettlementVO.setStlLoclAmt  (settlementRFVO.getStlLoclAmt40  ());
			procSettlementVO.setStlAdjFlg   (settlementRFVO.getStlAdjFlg40   ());
			procSettlementVO.setStlLstFlg   (settlementRFVO.getStlLstFlg40   ());
			procSettlementVO.setStlDupFlg   (settlementRFVO.getStlDupFlg40   ());
 		}
 	}


 	/**
 	 * checking duplication and saving
 	 * 
	 * @param SettlementRFVO[] settlementRFVOs
	 * @param SignOnUserAccount signOnUserAccount
	 * @return List<SettlementRFVO>
 	 * @throws EventException
 	 */
	public List<SettlementRFVO> manageSettlementRF(SettlementRFVO[] settlementRFVOs, SignOnUserAccount signOnUserAccount) throws EventException{
		List<SettlementRFVO> list = null;
		try {
			list = new ArrayList<SettlementRFVO>();
			
			ProcSettlementVO procSettlementVO20 = new ProcSettlementVO();
			ProcSettlementVO procSettlementVO40 = new ProcSettlementVO();

			for (int i=0; i < settlementRFVOs.length; i++){
				list.add(settlementRFVOs[i]);
				String flg = settlementRFVOs[i].getIbflag();
				if ("R".equals(flg))
					continue;

				
				if ("D".equals(flg)){
					this.setSettlementRFVO2ProcSettlementVO(settlementRFVOs[i], procSettlementVO20, "20");
					this.setSettlementRFVO2ProcSettlementVO(settlementRFVOs[i], procSettlementVO40, "40");
					dbDao.removeSettlement(procSettlementVO20);
					dbDao.removeSettlement(procSettlementVO40);
				}
			}
			
			int iRtn20 = 0; 
			int iRtn40 = 0; 

			String ibFlag = "";

			int iDupCnt = 0;

			
			for (int i=0; i < list.size(); i++){
				
				ibFlag = list.get(i).getIbflag();
				
				if ("R".equals(ibFlag) || "D".equals(ibFlag))
					continue;

				this.setSettlementRFVO2ProcSettlementVO(settlementRFVOs[i], procSettlementVO20, "20");
				this.setSettlementRFVO2ProcSettlementVO(settlementRFVOs[i], procSettlementVO40, "40");

				//iRtn20 = dbDao.searchSettlementDupChk(procSettlementVO20);
				//iRtn40 = dbDao.searchSettlementDupChk(procSettlementVO40);
				
				if ("U".equals(ibFlag)){
					
					if (iRtn20 > 0 && iRtn40 > 0){
						iDupCnt++;
						break;
					}else{
						procSettlementVO20.setUpdUsrId(signOnUserAccount.getUsr_id());
						procSettlementVO40.setUpdUsrId(signOnUserAccount.getUsr_id());
					}
					
					dbDao.modifySettlement(procSettlementVO20);
					dbDao.modifySettlement(procSettlementVO40);
				}else if ("I".equals(ibFlag)){
					if (iRtn20 > 0 && iRtn40 > 0){
						iDupCnt++;
						break;
					}else{
						procSettlementVO20.setCreUsrId(signOnUserAccount.getUsr_id());
						procSettlementVO40.setCreUsrId(signOnUserAccount.getUsr_id());
					}

					dbDao.addSettlement(procSettlementVO20);
					dbDao.addSettlement(procSettlementVO40);
				}
			}
			
			if (iDupCnt > 0){
				list.get(0).setDupFlg("E");
			}else{
				list.get(0).setDupFlg("N");
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"R/F Settlement", "Save"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"R/F Settlement", "Save"}).getMessage(), ex);
		}
		
		return list;
	}


 	/**
 	 * checking duplication and saving
 	 * ITEM : OUS(RDR, TDR), S/H
 	 * @param ProcSettlementVO[] procSettlementVOs
 	 * @param SignOnUserAccount signOnUserAccount
 	 * @return List<ProcSettlementVO>
 	 * @throws EventException
 	 */
 	public List<ProcSettlementVO> manageSettlementSH(ProcSettlementVO[] procSettlementVOs, SignOnUserAccount signOnUserAccount) throws EventException{
 		List<ProcSettlementVO> list = null;
 		try {
 			list = new ArrayList<ProcSettlementVO>();
 			
 			for (int i=0; i < procSettlementVOs.length; i++){
 				list.add(procSettlementVOs[i]);
 				
 				
 				if ("D".equals(procSettlementVOs[i].getIbflag())){
 					dbDao.removeSettlement(list.get(i));
 				}
 			}

 			int iRtn = 0; 

 			String ibFlag = "";
 			int iDupCnt = 0;

 			
 			for (int i=0; i < list.size(); i++){
 				
 				ibFlag = list.get(i).getIbflag();
 				
 				if ("R".equals(ibFlag) || "D".equals(ibFlag))
 					continue;

 				iRtn  = dbDao.searchSettlementDupChk(list.get(i));

 				if (iRtn > 0){
					iDupCnt++;
					break;
				}

 				if ("U".equals(ibFlag)){
 					list.get(i).setUpdUsrId(signOnUserAccount.getUsr_id());
 					dbDao.modifySettlement(list.get(i));
 				}else if ("I".equals(ibFlag)){
 					list.get(i).setCreUsrId(signOnUserAccount.getUsr_id());
 					dbDao.addSettlement(list.get(i));
 				}
 			}
 			
 			if (iDupCnt > 0){
 				list.get(0).setDupFlg("E");
 			}else{
 				list.get(0).setDupFlg("N");
 			}
 		} catch (DAOException ex) {
 			log.error("err " + ex.toString(), ex);
 			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Settlement", "Save"}).getMessage(), ex);
 		} catch (Exception ex) {
 			log.error("err " + ex.toString(), ex);
 			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Settlement", "Save"}).getMessage(), ex);
 		}
 		
 		return list;
 	}
    /**
     * Booking retrieving Discharge Port Qty by Loading Port<br>
     *
     * @param  LoadingQtyVO loadingQtyVO
     * @return DBRowSet
     * @throws EventException
     */
    public DBRowSet searchDischageForLoading(LoadingQtyVO loadingQtyVO ) throws EventException{
 
        try {

            return dbDao.searchDischageForLoading(loadingQtyVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("JOO10007", new String[]{"Loading Qty", "Retrieve"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("JOO10007", new String[]{"Loading Qty", "Retrieve"}).getMessage(), ex);
        }
    }
    /**
     * 
     * retrieving Discharge Port Qty header information by Booking Loading Port<br>
     *
     * @param  LoadingQtyVO loadingQtyVO
     * @return DBRowSet
     * @throws EventException
     */
    public DBRowSet searchDischageForLoadingHeader(LoadingQtyVO loadingQtyVO) throws EventException{
 
        try {
            
            return dbDao.searchDischageForLoadingHeader(loadingQtyVO);
 
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("JOO10007", new String[]{"Loading Qty", "Retrieve"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("JOO10007", new String[]{"Loading Qty", "Retrieve"}).getMessage(), ex);
        }
    }

    /**
     * 
     * @param List<JooStlCmbDtlVO> jooStlCmbDtlVOs
     * @param SignOnUserAccount signOnUserAccount
     * @throws EventException
     */
	public void createReverseSettlement(List<JooStlCmbDtlVO> jooStlCmbDtlVOs, SignOnUserAccount signOnUserAccount) throws EventException{
		try {
			for (int i=0; i<jooStlCmbDtlVOs.size(); i++){
				jooStlCmbDtlVOs.get(i).setUpdUsrId (signOnUserAccount.getUsr_id());
				//새로운 max(stl_seq)+1 (기존과 구별하기 위해 stl_cmb_seq에 넣는다.
				String stlCmbSeq = dbDao.searchNextStlSeq(jooStlCmbDtlVOs.get(i));
				jooStlCmbDtlVOs.get(i).setStlCmbSeq(stlCmbSeq);
				
				//settlement copy
				dbDao.addSettlement(jooStlCmbDtlVOs.get(i));
				//joo_stl_dtl copy
				dbDao.addStlDtl(jooStlCmbDtlVOs.get(i));
				
				//joo_stl_cmb_dtl update
				dbDao.updateCmbdtl(jooStlCmbDtlVOs.get(i));
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Reverse CSR Creation", "Settlement Copy"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Reverse CSR Creation", "Settlement Copy"}).getMessage(), ex);
		}
	}


	/**
	 * checking validation in case of inputting S/H BSA Type
	 * @param ProcSettlementVO procSettlementVO
	 * @return List<ProcSettlementVO>
	 * @throws EventException
	 */
	public List<ProcSettlementVO> searchBsaTypeValidationCheck(ProcSettlementVO procSettlementVO) throws EventException {
		try {
			return dbDao.searchBsaTypeValidationCheck(procSettlementVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Settlement", "Check BSA Type Validation"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Settlement", "Check BSA Type Validation"}).getMessage(), ex);
		}
	}
	
	/**
     * saving Remark
     * @param McsStatusVO[] mcsStatusVOs
     * @param SignOnUserAccount account
     * @throws EventException
     */
	public void manageSummaryOfMcsListByCarrier(McsStatusVO[] mcsStatusVOs, SignOnUserAccount account) throws EventException{
		try {
			List<McsStatusVO> insertVoList = new ArrayList<McsStatusVO>();
			List<McsStatusVO> updateVoList = new ArrayList<McsStatusVO>();
			List<McsStatusVO> list = new ArrayList<McsStatusVO>();
			
			if(mcsStatusVOs != null && mcsStatusVOs.length > 0){
				for ( int i=0; i<mcsStatusVOs.length; i++ ) {
					if ( mcsStatusVOs[i].getIbflag().equals("U")){
						list = dbDao.chkSummaryCrrRmk(mcsStatusVOs[i]);
						mcsStatusVOs[i].setCreUsrId(account.getUsr_id());
						if(list.isEmpty()){
							insertVoList.add(mcsStatusVOs[i]);
						}else{
						updateVoList.add(mcsStatusVOs[i]);
						}
					}
				}
			}
			
			if(insertVoList.size() > 0){
				dbDao.addSummaryOfMcsListByCarrier(insertVoList);
			}
			if(updateVoList.size() > 0){
				dbDao.modifySummaryOfMcsListByCarrier(updateVoList);
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Summary of Monthly Clearance Status by Carrier", "Save"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Summary of Monthly Clearance Status by Carrier", "Save"}).getMessage(), ex);
		}
	}

	/**
	 * deleting JOO_STL_DTL, JOO_SETTLMENT in case of deleting Target VVD
	 * @param JooStlVvdVO[] jooStlVvdVOs
	 * @return int
	 * @throws EventException
	 */
	public int removeStlDtlAndSettlement(JooStlVvdVO[] jooStlVvdVOs) throws EventException {
		int rtnVal = 0;;
		try {
			for (int i=0; i < jooStlVvdVOs.length; i++){
				dbDao.removeJooStlDtl(jooStlVvdVOs[i]);
				rtnVal = dbDao.removeSettlement(jooStlVvdVOs[i]);
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Settlement", "Remove"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Settlement", "Remove"}).getMessage(), ex);
		}
		return rtnVal;
	}

	/**
	 * updating Unsettlement Target VVD
	 * @param StlStatusVO[] stlStatusVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageJooTgtUnstlStsRmk(StlStatusVO[] stlStatusVOs, SignOnUserAccount account) throws EventException{
		try {
			int iRtn;
			for ( int i=0; i<stlStatusVOs.length; i++ ) {
				stlStatusVOs[i].setUsrId(account.getUsr_id());				

				iRtn = dbDao.addJooTgtUnstlStsRmk(stlStatusVOs[i]);
				if (iRtn == 1){
					dbDao.modifyJooTgtUnstlStsRmk(stlStatusVOs[i]);
				}
			}
			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Unsettlement Target VVD", "Save"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Unsettlement Target VVD", "Save"}).getMessage(), ex);
		}
	}
	
	/**
	 * Container List for settlement backup <br>
	 *
	 * @param  CntrSettlementBackupReportVO cntrSettlementBackupReportVO
	 * @return List<CntrSettlementBackupReportVO>
	 * @exception EventException
	 */
	public List<CntrSettlementBackupReportVO> searchCntrForSettlementBackupReportData(CntrSettlementBackupReportVO cntrSettlementBackupReportVO) throws EventException {
		List<CntrSettlementBackupReportVO> list = null;
		try {
			list = dbDao.searchCntrForSettlementBackupReportData(cntrSettlementBackupReportVO);
			if ( list.size() < 1 ) {
				new EventException(new ErrorHandler("JOO10007",new String[]{"Container List for Settlement backup Report"}).getMessage());
			} else {
				list.get(0).setMaxRows(dbDao.searchCntrForSettlementBackupReportCountData(cntrSettlementBackupReportVO));
			}
		} catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Container List for Settlement backup Report Search"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Container List for Settlement backup Report Search"}).getMessage(),ex);
		}
		return list;
	}	
	
	/**
	 * Container List for settlement backup.(BackEnd Job)<br>
	 * 
	 * @param CntrSettlementBackupReportVO cntrSettlementBackupReportVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @throws EventException
	 */
	public String searchCntrForSettlementBackupReportDataBackEndJob(CntrSettlementBackupReportVO cntrSettlementBackupReportVO, SignOnUserAccount account) throws EventException {
		CarrierSettlementProcessBCBackEndJob backEndJob = new CarrierSettlementProcessBCBackEndJob();
		String resultStr = "";
		try {
			backEndJob.setPgmNo(JooConstants.BACKEND_JOB_PGM_FNS_JOO_0084);//"FNS_JOO_0084"
			backEndJob.setCntrSettlementBackupReportVO(cntrSettlementBackupReportVO);
			resultStr = (new BackEndJobManager()).execute(backEndJob, account.getUsr_id(), "SearchCntrForSettlementBackupReportDataBackEndJob");
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Container List for Settlement backup Report Back End Job"}).getMessage(), ex);
		}
		return resultStr;
	}
	
	/**
	 * Container List for settlement backup/Standard format.(BackEndJob download)<br>
	 * 
	 * @param String key
	 * @return Object
	 * @throws EventException
	 */
	public Object searchCntrReportBackEndJobDataFile(String key) throws EventException {
		try {
			CarrierSettlementProcessEAIDAO eaiDao = new CarrierSettlementProcessEAIDAO();
			return  (Object) eaiDao.searchCntrReportBackEndJobDataFile(key);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * Standard format for previous vvd and last port 조회<<br>
	 * 
	 * @param CntrConditionVO cntrConditionVO
	 * @return DBRowSet
	 * @throws EventException
	 */
	public List<CntrPreviousVvdPortVO> searchCntrPreviousVvdPortInfo(CntrConditionVO cntrConditionVO) throws EventException{
        try {            
            return dbDao.searchCntrPreviousVvdPortInfo(cntrConditionVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("JOO10007", new String[]{"Previous VVD & Last Port Retrieve"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("JOO10007", new String[]{"Previous VVD & Last Port Retrieve"}).getMessage(), ex);
        }
    }
	
	/**
	 * Standard format Previous Voyage조회<br>
	 * 
	 * @param CntrConditionVO cntrConditionVO
	 * @return DBRowSet
	 * @throws EventException
	 */
	public List<CntrStandardFormatVO> searchCntrStandardFormatPreviousVoyageReportData(CntrConditionVO cntrConditionVO) throws EventException{
        try {            
            return dbDao.searchCntrStandardFormatPreviousVoyageReportData(cntrConditionVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("JOO10007", new String[]{"Standard Format Previous Retrieve"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("JOO10007", new String[]{"Standard Format Previous Retrieve"}).getMessage(), ex);
        }
    }
	
	/**
	 * Standard format Previous Voyage조회(BackEndJob)<br>
	 * 
	 * @param CntrConditionVO cntrConditionVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @throws EventException
	 */
	public String searchCntrStandardFormatPreviousVoyageReportDataBackEndJob(CntrConditionVO cntrConditionVO, SignOnUserAccount account) throws EventException{
		CarrierSettlementProcessBCBackEndJob backEndJob = new CarrierSettlementProcessBCBackEndJob();
		String resultStr = "";
		try {
			backEndJob.setPgmNo("FNS_JOO_0084_02");//"FNS_JOO_0084" PreviousVoyageRepor
			backEndJob.setCntrConditionVO(cntrConditionVO);
			resultStr = (new BackEndJobManager()).execute(backEndJob, account.getUsr_id(), "searchCntrStandardFormatPreviousVoyageReportDataBackEndJob");
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Standard Format  Previous for Back End Job"}).getMessage(), ex);
		}
		return resultStr;
    }
	
	/**
	 * Standard format 조회<<br>
	 * 
	 * @param CntrConditionVO cntrConditionVO
	 * @return DBRowSet
	 * @throws EventException
	 */
	public List<CntrStandardFormatVO> searchCntrStandardFormatReportData(CntrConditionVO cntrConditionVO) throws EventException{
        try {            
            return dbDao.searchCntrStandardFormatReportData(cntrConditionVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("JOO10007", new String[]{"Standard Format Previous Retrieve"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("JOO10007", new String[]{"Standard Format Previous Retrieve"}).getMessage(), ex);
        }
    }
	
	/**
	 * Standard format Summary 조회(BackEndJob)<br>
	 * 
	 * @param CntrConditionVO cntrConditionVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @throws EventException
	 */
	public String searchCntrStandardFormatReportDataBackEndJob(CntrConditionVO cntrConditionVO, SignOnUserAccount account) throws EventException{
		CarrierSettlementProcessBCBackEndJob backEndJob = new CarrierSettlementProcessBCBackEndJob();
		String resultStr = "";
		try {
			backEndJob.setPgmNo("FNS_JOO_0084_03");//"FNS_JOO_0084" Summary Report
			backEndJob.setCntrConditionVO(cntrConditionVO);
			resultStr = (new BackEndJobManager()).execute(backEndJob, account.getUsr_id(), "searchCntrStandardFormatReportDataBackEndJob");
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Standard Format  Summary for Back End Job"}).getMessage(), ex);
		}
		return resultStr;
    }
	
	/**
	 * Standard format Next Voyage조회 <br>
	 * 
	 * @param CntrConditionVO cntrConditionVO
	 * @return DBRowSet
	 * @throws EventException
	 */
	public List<CntrStandardFormatVO> searchCntrStandardFormatNextVoyageReportData(CntrConditionVO cntrConditionVO) throws EventException{
        try {            
            return dbDao.searchCntrStandardFormatNextVoyageReportData(cntrConditionVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("JOO10007", new String[]{"Standard Format Next Retrieve"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("JOO10007", new String[]{"Standard Format Next Retrieve"}).getMessage(), ex);
        }
    }
	
	/**
	 * Conversion Table TP/SZ Conversion 조회<br>
	 * 
	 * @param CntrConversionConditionVO cntrConversionConditionVO
	 * @return List<CntrConversionAndOptionVO>
	 * @throws EventException
	 */
	public List<CntrConversionAndOptionVO> searchCntrConverionByTpszList(CntrConversionConditionVO cntrConversionConditionVO) throws EventException{
        try {            
            return dbDao.searchCntrConverionByTpszList(cntrConversionConditionVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("JOO10007", new String[]{"Cargo Summary By Carrier TP/SZ Conversion Retrieve"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("JOO10007", new String[]{"Cargo Summary By Carrier TP/SZ Conversion Retrieve"}).getMessage(), ex);
        }
    }
	
	/**
	 * Conversion Table TEU Conversion 조회<br>
	 * 
	 * @param CntrConversionConditionVO cntrConversionConditionVO
	 * @return List<CntrConversionAndOptionVO>
	 * @throws EventException
	 */
	public List<CntrConversionAndOptionVO> searchCntrConverionByTeuList(CntrConversionConditionVO cntrConversionConditionVO) throws EventException{
        try {            
            return dbDao.searchCntrConverionByTeuList(cntrConversionConditionVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("JOO10007", new String[]{"Cargo Summary By Carrier TEU Conversion Retrieve"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("JOO10007", new String[]{"Cargo Summary By Carrier TEU Conversion Retrieve"}).getMessage(), ex);
        }
    }
	
	/**
	 * Conversion Table Void Conversion 조회<br>
	 * 
	 * @param CntrConversionConditionVO cntrConversionConditionVO
	 * @return List<CntrConversionAndOptionVO>
	 * @throws EventException
	 */
	public List<CntrConversionAndOptionVO> searchCntrConverionByVoidList(CntrConversionConditionVO cntrConversionConditionVO) throws EventException{
        try {            
            return dbDao.searchCntrConverionByVoidList(cntrConversionConditionVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("JOO10007", new String[]{"Cargo Summary By Carrier Void Conversion Retrieve"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("JOO10007", new String[]{"Cargo Summary By Carrier Void Conversion Retrieve"}).getMessage(), ex);
        }
    }
	
	/**
     * FNS_JOO_0086 : Save TP/SZ Tab
     * @param CntrConversionAndOptionVO[] cntrTpszConversionAndOptionVOs
     * @param SignOnUserAccount account
     * @throws EventException
     */
	public void manageCntrConversionByTpsz(CntrConversionAndOptionVO[] cntrTpszConversionAndOptionVOs, SignOnUserAccount account) throws EventException{
		try {
			List<CntrConversionAndOptionVO> insertVoList = new ArrayList<CntrConversionAndOptionVO>();
			List<CntrConversionAndOptionVO> deleteVoList = new ArrayList<CntrConversionAndOptionVO>();
			
			if(cntrTpszConversionAndOptionVOs != null && cntrTpszConversionAndOptionVOs.length > 0){
				for ( int i=0; i<cntrTpszConversionAndOptionVOs.length; i++ ) {
					cntrTpszConversionAndOptionVOs[i].setPptCd(JooConstants.KEY_COM_PPT_TPSZ);
					if ( cntrTpszConversionAndOptionVOs[i].getIbflag().equals("D")){
						deleteVoList.add(cntrTpszConversionAndOptionVOs[i]);
					}else{
						cntrTpszConversionAndOptionVOs[i].setCreUsrId(account.getUsr_id());
						insertVoList.add(cntrTpszConversionAndOptionVOs[i]);
					}
				}
				//삭제 건이 없고 Inset 건이 있으면 Inset 1번째 데이타를 DeleteList 에 넣는다.
				if(insertVoList.size() > 0){
					deleteVoList.add((CntrConversionAndOptionVO)insertVoList.get(0));
				}
			}
			
			//전체 삭제 후에 All Insert.
			if(deleteVoList.size() > 0){
				dbDao.removeCntrConversionTableAndOption((CntrConversionAndOptionVO)deleteVoList.get(0));
			}
			//All Insert.
			if(insertVoList.size() > 0){
				dbDao.addCntrConversionByTpszList(insertVoList);
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Cargo Summary By Carrier TP/SZ", "Save"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Cargo Summary By Carrier TP/SZ", "Save"}).getMessage(), ex);
		}
	}
	
	/**
     * FNS_JOO_0086 : Save TEU Tab
     * @param CntrConversionAndOptionVO[] cntrTpszConversionAndOptionVOs
     * @param SignOnUserAccount account
     * @throws EventException
     */
	public void manageCntrConversionByTeu(CntrConversionAndOptionVO[] cntrTpszConversionAndOptionVOs, SignOnUserAccount account) throws EventException{
		try {
			List<CntrConversionAndOptionVO> insertVoList = new ArrayList<CntrConversionAndOptionVO>();
			List<CntrConversionAndOptionVO> deleteVoList = new ArrayList<CntrConversionAndOptionVO>();
			
			if(cntrTpszConversionAndOptionVOs != null && cntrTpszConversionAndOptionVOs.length > 0){
				//Lane중복되지 않게 삭제 처리한다.
				String tmpSlanCd = "";
				for ( int i=0; i<cntrTpszConversionAndOptionVOs.length; i++ ) {
					cntrTpszConversionAndOptionVOs[i].setPptCd(JooConstants.KEY_COM_PPT_TEU);
					
					String chkSlanCd = cntrTpszConversionAndOptionVOs[i].getSlanCd();
					if(!StringUtils.isEmpty(chkSlanCd) && !tmpSlanCd.equals(chkSlanCd)){
						deleteVoList.add(cntrTpszConversionAndOptionVOs[i]);
						tmpSlanCd = chkSlanCd;
					}
					
					if ( !cntrTpszConversionAndOptionVOs[i].getIbflag().equals("D")){
						cntrTpszConversionAndOptionVOs[i].setCreUsrId(account.getUsr_id());
						insertVoList.add(cntrTpszConversionAndOptionVOs[i]);
					}
				}
			}			
			
			//상위 TPSZ MAP 삭제된 TP/SZ 데이타 삭제. 
			CntrConversionConditionVO relDelVo = new CntrConversionConditionVO();
			relDelVo.setPptCd(JooConstants.KEY_COM_PPT_TEU);
			relDelVo.setPptCd2(JooConstants.KEY_COM_PPT_TPSZ);
			dbDao.removeCntrConversionTableAndOptionByNotRel(relDelVo);
			
			//전체 삭제 후에 All Insert.(화면에 표시된 Lane)
			if(deleteVoList.size() > 0){
				for(CntrConversionAndOptionVO vo : deleteVoList){
					dbDao.removeCntrConversionTableAndOption(vo);
				}
			}
			
			//All Insert.
			if(insertVoList.size() > 0){
				//line_seq 를 새로 만든다.
				CntrConversionConditionVO cntrConversionConditionVO = new CntrConversionConditionVO();
				cntrConversionConditionVO.setPptCd(JooConstants.KEY_COM_PPT_TEU);
				int iMaxLineSeq = dbDao.searchCntrNextMaxLineSeq(cntrConversionConditionVO);
				
				for(CntrConversionAndOptionVO vo : insertVoList){
					vo.setLineSeq(String.valueOf(iMaxLineSeq));
					
					iMaxLineSeq++;
				}
				
				dbDao.addCntrConversionByTeuList(insertVoList);
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Cargo Summary By Carrier TEU", "Save"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Cargo Summary By Carrier TEU", "Save"}).getMessage(), ex);
		}
	}
	
	/**
     * FNS_JOO_0086 : Save Void Tab
     * @param CntrConversionAndOptionVO[] cntrTpszConversionAndOptionVOs
     * @param SignOnUserAccount account
     * @throws EventException
     */
	public void manageCntrConversionByVoid(CntrConversionAndOptionVO[] cntrTpszConversionAndOptionVOs, SignOnUserAccount account) throws EventException{
		try {
			List<CntrConversionAndOptionVO> insertVoList = new ArrayList<CntrConversionAndOptionVO>();
			List<CntrConversionAndOptionVO> deleteVoList = new ArrayList<CntrConversionAndOptionVO>();
			

			
			if(cntrTpszConversionAndOptionVOs != null && cntrTpszConversionAndOptionVOs.length > 0){
				//TEU CONVERSION 에 존재하는 SLAN_CD 를 조회 한다.
				CntrConversionConditionVO teuVo = new CntrConversionConditionVO();
				teuVo.setPptCd(JooConstants.KEY_COM_PPT_TEU);
				Map<String, String> slanMap = dbDao.searchCntrConversionTableByPptCd(teuVo);
				
				
				//Lane중복되지 않게 삭제 처리한다.
				String tmpSlanCd = "";
				for ( int i=0; i<cntrTpszConversionAndOptionVOs.length; i++ ) {
					cntrTpszConversionAndOptionVOs[i].setPptCd(JooConstants.KEY_COM_PPT_VOID);
					
					String chkSlanCd = cntrTpszConversionAndOptionVOs[i].getSlanCd();
					if(!StringUtils.isEmpty(chkSlanCd) && !tmpSlanCd.equals(chkSlanCd)){
						deleteVoList.add(cntrTpszConversionAndOptionVOs[i]);
						tmpSlanCd = chkSlanCd; 
					}
					
					if ( !cntrTpszConversionAndOptionVOs[i].getIbflag().equals("D")){
						//TEU CONVERSION에 존재하는 데이타만 Insert 한다.
						if(slanMap.containsKey(cntrTpszConversionAndOptionVOs[i].getSlanCd())){
							cntrTpszConversionAndOptionVOs[i].setCreUsrId(account.getUsr_id());
							insertVoList.add(cntrTpszConversionAndOptionVOs[i]);
						}
					}
				}
			}
			
			//상위 TEU CONVERSION 삭제된 Lane 데이타 삭제. 
			CntrConversionConditionVO relDelVo = new CntrConversionConditionVO();
			relDelVo.setPptCd(JooConstants.KEY_COM_PPT_VOID);
			relDelVo.setPptCd2(JooConstants.KEY_COM_PPT_TEU);
			dbDao.removeCntrConversionTableAndOptionByNotRel(relDelVo);
			
			//전체 삭제 후에 All Insert.(화면에 표시된 Lane)
			if(deleteVoList.size() > 0){
				for(CntrConversionAndOptionVO vo : deleteVoList){
					dbDao.removeCntrConversionTableAndOption(vo);
				}
			}			
						
			//All Insert.
			if(insertVoList.size() > 0){
				//line_seq 를 새로 만든다.
				CntrConversionConditionVO cntrConversionConditionVO = new CntrConversionConditionVO();
				cntrConversionConditionVO.setPptCd(JooConstants.KEY_COM_PPT_VOID);
				int iMaxLineSeq = dbDao.searchCntrNextMaxLineSeq(cntrConversionConditionVO);
				
				for(CntrConversionAndOptionVO vo : insertVoList){
					vo.setLineSeq(String.valueOf(iMaxLineSeq));
					
					iMaxLineSeq++;
				}
				
				dbDao.addCntrConversionByVoidList(insertVoList);
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Cargo Summary By Carrier Void", "Save"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Cargo Summary By Carrier Void", "Save"}).getMessage(), ex);
		}
	}
	
	/**
	 * Conversion Table Option 조회<br>
	 * 
	 * @param CntrConversionConditionVO cntrConversionConditionVO
	 * @return List<CntrConversionAndOptionVO>
	 * @throws EventException
	 */
	public List<CntrConversionAndOptionVO> searchCntrOptionList(CntrConversionConditionVO cntrConversionConditionVO) throws EventException{
        try {            
            return dbDao.searchCntrOptionList(cntrConversionConditionVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("JOO10007", new String[]{"Cargo Summary By Carrier Option Retrieve"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("JOO10007", new String[]{"Cargo Summary By Carrier Option Retrieve"}).getMessage(), ex);
        }
    }
	
	/**
     * FNS_JOO_0087 : Save
     * @param CntrConversionAndOptionVO[] cntrConversionAndOptionVOs
     * @param SignOnUserAccount account
     * @throws EventException
     */
	public void manageCntrOption(CntrConversionAndOptionVO[] cntrConversionAndOptionVOs, SignOnUserAccount account) throws EventException{
		try {
			List<CntrConversionAndOptionVO> insertVoList = new ArrayList<CntrConversionAndOptionVO>();
			List<CntrConversionAndOptionVO> deleteVoList = new ArrayList<CntrConversionAndOptionVO>();
			
			if(cntrConversionAndOptionVOs != null && cntrConversionAndOptionVOs.length > 0){
				//Lane중복되지 않게 삭제 처리한다.
				String tmpSlanCd = "";
				for ( int i=0; i<cntrConversionAndOptionVOs.length; i++ ) {
					cntrConversionAndOptionVOs[i].setPptCd(JooConstants.KEY_COM_PPT_OPTION);
					String chkSlanCd = cntrConversionAndOptionVOs[i].getSlanCd();
					if(!StringUtils.isEmpty(chkSlanCd) && !tmpSlanCd.equals(chkSlanCd)){
						deleteVoList.add(cntrConversionAndOptionVOs[i]);
						tmpSlanCd = chkSlanCd; 
					}
					
					if ( !cntrConversionAndOptionVOs[i].getIbflag().equals("D")){
						cntrConversionAndOptionVOs[i].setCreUsrId(account.getUsr_id());
						insertVoList.add(cntrConversionAndOptionVOs[i]);
					}
				}
				
			}
			
			//전체 삭제 후에 All Insert.(화면에 표시된 Lane)
			if(deleteVoList.size() > 0){
				for(CntrConversionAndOptionVO vo : deleteVoList){
					dbDao.removeCntrConversionTableAndOption(vo);
				}
			}
			
			//All Insert.
			if(insertVoList.size() > 0){
				dbDao.addCntrOptionList(insertVoList);
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Cargo Summary By Carrier Option", "Save"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Cargo Summary By Carrier Option", "Save"}).getMessage(), ex);
		}
	}
	
	/**
	 * Conversion Table Normal TP/SZ 조회<br>
	 * 
	 * @param CntrConversionConditionVO cntrConversionConditionVO
	 * @return List<CntrConversionAndOptionVO>
	 * @throws EventException
	 */
	public List<CntrConversionAndOptionVO> searchCntrNormalTpszList(CntrConversionConditionVO cntrConversionConditionVO) throws EventException{
        try {            
            return dbDao.searchCntrNormalTpszList(cntrConversionConditionVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("JOO10007", new String[]{"Cargo Summary By Carrier Normal TP/SZ Retrieve"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("JOO10007", new String[]{"Cargo Summary By Carrier Normal TP/SZ Retrieve"}).getMessage(), ex);
        }
    }
	
	
	/**
	 * Container List for settlement backup.(BackEnd Job)<br>
	 * 
	 * @param CntrConditionVO cntrConditionVO
	 * @param CntrStandardFormatVO[] cntrStandardFormatPreVOs
	 * @param CntrStandardFormatVO[] cntrStandardFormatSumVOs
	 * @param SignOnUserAccount account
	 * @return String
	 * @throws EventException
	 */
	public String searchCntrStandardFormatReportBackEndJob(CntrConditionVO cntrConditionVO, CntrStandardFormatVO[] cntrStandardFormatPreVOs, CntrStandardFormatVO[] cntrStandardFormatSumVOs, SignOnUserAccount account) throws EventException {
		CarrierSettlementProcessBCBackEndJob backEndJob = new CarrierSettlementProcessBCBackEndJob();
		String resultStr = "";
		try {
			backEndJob.setPgmNo(JooConstants.BACKEND_JOB_PGM_FNS_JOO_0084_01);//"FNS_JOO_0084"
			backEndJob.setCntrConditionVO(cntrConditionVO);
			backEndJob.setCntrStandardFormatPreVOs(cntrStandardFormatPreVOs);
			backEndJob.setCntrStandardFormatSumVOs(cntrStandardFormatSumVOs);
			resultStr = (new BackEndJobManager()).execute(backEndJob, account.getUsr_id(), "searchCntrStandardFormatReportBackEndJob");
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Cargo Summary By Standard Format Back End Job"}).getMessage(), ex);
		}
		return resultStr;
	}

    /**
     * retrieving Used Slot Information
     * 2015.08.12 Add
     * parameter : jo_crr_cd, re_divr_cd, VVD
     * @param ProcSettlementVO procSettlementVO
     * @return List<ProcSettlementVO>
     * @throws EventException
     */
	public List<ProcSettlementVO> searchUsedSlotByInterList(ProcSettlementVO procSettlementVO) throws EventException {
		try {
			return dbDao.searchUsedSlotByInterList(procSettlementVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Used Slot Information(Inter)", "Retrieve"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Used Slot Information(Inter)", "Retrieve"}).getMessage(), ex);
		}
	}
 
    /**
     * retrieving unit price, used qty in case of selecting inter port 
     * 2015.08.12 Add
     * Search Condition : acct_yrmon, jo_crr_cd, re_divr_cd, trd_cd, rlane_cd, jo_stl_itm_cd, jo_mnu_nm, VVD
     * @param ProcSettlementVO procSettlementVO
     * @return List<ProcSettlementVO>
     * @throws EventException
     */
	public List<ProcSettlementVO> searchBsaSltPrcByInter(ProcSettlementVO procSettlementVO) throws EventException {
		try {
			return dbDao.searchBsaSltPrcByInter(procSettlementVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Used Slot Information BSA Price(Inter)", "Retrieve"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Used Slot Information BSA Price(Inter)", "Retrieve"}).getMessage(), ex);
		}
	}
	
	/**
     * FNS_JOO_0086 : Save Default TP/SZ Tab
     * @param CntrConversionAndOptionVO[] cntrTpszConversionAndOptionVOs
     * @param SignOnUserAccount account
     * @throws EventException
     */
	public void manageCntrConversionByDefaultTpsz(CntrConversionAndOptionVO[] cntrTpszConversionAndOptionVOs, SignOnUserAccount account) throws EventException{
		try {
			List<CntrConversionAndOptionVO> insertVoList = new ArrayList<CntrConversionAndOptionVO>();
			List<CntrConversionAndOptionVO> deleteVoList = new ArrayList<CntrConversionAndOptionVO>();
			
			if(cntrTpszConversionAndOptionVOs != null && cntrTpszConversionAndOptionVOs.length > 0){
				for ( int i=0; i<cntrTpszConversionAndOptionVOs.length; i++ ) {
					cntrTpszConversionAndOptionVOs[i].setPptCd(JooConstants.KEY_COM_PPT_DEFAULT_TPSZ);
					if ( cntrTpszConversionAndOptionVOs[i].getIbflag().equals("D")){
						deleteVoList.add(cntrTpszConversionAndOptionVOs[i]);
					}else{
						cntrTpszConversionAndOptionVOs[i].setCreUsrId(account.getUsr_id());
						insertVoList.add(cntrTpszConversionAndOptionVOs[i]);
					}
				}
				//삭제 건이 없고 Inset 건이 있으면 Inset 1번째 데이타를 DeleteList 에 넣는다.
				if(insertVoList.size() > 0){
					deleteVoList.add((CntrConversionAndOptionVO)insertVoList.get(0));
				}
			}
			
			//전체 삭제 후에 All Insert.
			if(deleteVoList.size() > 0){
				dbDao.removeCntrConversionTableAndOption((CntrConversionAndOptionVO)deleteVoList.get(0));
			}
			//All Insert.
			if(insertVoList.size() > 0){
				dbDao.addCntrConversionByDefaultTpszList(insertVoList);
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Cargo Summary By Default TP/SZ", "Save"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Cargo Summary By Default TP/SZ", "Save"}).getMessage(), ex);
		}
	}
	
	/**
	 * Conversion Table Default TP/SZ 조회(Laden/Empty)<br>
	 * 
	 * @param CntrConversionConditionVO cntrConversionConditionVO
	 * @return List<CntrConversionAndOptionVO>
	 * @throws EventException
	 */
	public List<CntrConversionAndOptionVO> searchCntrConverionDefaultTpszList(CntrConversionConditionVO cntrConversionConditionVO) throws EventException{
        try {            
            return dbDao.searchCntrConverionDefaultTpszList(cntrConversionConditionVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("JOO10007", new String[]{"Cargo Summary By Carrier TP/SZ Conversion Retrieve"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("JOO10007", new String[]{"Cargo Summary By Carrier TP/SZ Conversion Retrieve"}).getMessage(), ex);
        }
    }
	
	/**
	 * Default Conversion Table TP/SZ & TEU Conversion 조회<br>
	 * 
	 * @param CntrConversionConditionVO cntrConversionConditionVO
	 * @return List<CntrConversionAndOptionVO>
	 * @throws EventException
	 */
	public List<CntrConversionAndOptionVO> searchDefaultCntrConverion(CntrConversionConditionVO cntrConversionConditionVO) throws EventException{
        try {            
            return dbDao.searchDefaultCntrConverion(cntrConversionConditionVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("JOO10007", new String[]{"Cargo Summary By Carrier Default TP/SZ & TEU Conversion Retrieve"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("JOO10007", new String[]{"Cargo Summary By Carrier Default TP/SZ & TEU Conversion Retrieve"}).getMessage(), ex);
        }
    }
	
	/**
	 * Default Conversion Table Option 조회<br>
	 * 
	 * @param CntrConversionConditionVO cntrConversionConditionVO
	 * @return List<CntrConversionAndOptionVO>
	 * @throws EventException
	 */
	public List<CntrConversionAndOptionVO> searchDefaultCntrOptionList(CntrConversionConditionVO cntrConversionConditionVO) throws EventException{
        try {            
            return dbDao.searchDefaultCntrOptionList(cntrConversionConditionVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("JOO10007", new String[]{"Cargo Summary By Carrier Default Option Retrieve"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("JOO10007", new String[]{"Cargo Summary By Carrier Default Option Retrieve"}).getMessage(), ex);
        }
    }
}