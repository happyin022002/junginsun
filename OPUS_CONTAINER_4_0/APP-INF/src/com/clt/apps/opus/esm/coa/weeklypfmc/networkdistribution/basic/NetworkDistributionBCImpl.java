/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : NetworkDistributionBCImpl.java
 *@FileTitle : Network Distribution BC Impl
 *Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
 * =========================================================
* History
 =========================================================*/

package com.clt.apps.opus.esm.coa.weeklypfmc.networkdistribution.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.clt.apps.opus.esm.coa.common.vo.ProcedureParamVO;
import com.clt.apps.opus.esm.coa.common.vo.SearchConditionVO;
import com.clt.apps.opus.esm.coa.weeklypfmc.networkdistribution.integration.NetworkDistributionDBDAO;
import com.clt.apps.opus.esm.coa.weeklypfmc.networkdistribution.vo.NetworkDistributionCommonVO;
import com.clt.apps.opus.esm.coa.weeklypfmc.networkdistribution.vo.SearchFixCostDistListVO;
import com.clt.apps.opus.esm.coa.weeklypfmc.networkdistribution.vo.SearchFixCostDistResultListVO;
import com.clt.apps.opus.esm.coa.weeklypfmc.networkdistribution.vo.SearchCOMSalesAmountListVO;
import com.clt.apps.opus.esm.coa.weeklypfmc.networkdistribution.vo.SearchMissingStatusVO;
import com.clt.apps.opus.esm.coa.weeklypfmc.networkdistribution.vo.SearchSpcChtrRevMssListVO;
import com.clt.apps.opus.esm.coa.weeklypfmc.weeklycm.integration.WeeklyCMDBDAO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.CoaFxAmtDtrbVO;

/**
 * WeeklyPFMC Business Logic Basic Command implementation<br>
 *
 * @author
 * @see EventResponse,NetworkDistributionBC reference the each DAO class 
 * @since J2EE 1.4
 */

public class NetworkDistributionBCImpl extends BasicCommandSupport implements NetworkDistributionBC {

	private transient NetworkDistributionDBDAO dbDao = null;
	private transient WeeklyCMDBDAO dbDaoNtAll = null;	//For the Nt cost All Procedure

	/**
	 * NetworkDistributionBCImpl Objects Creation<br>
	 * NetworkDistributionDBDAO  Creation<br>
	 */
	public NetworkDistributionBCImpl() {
		dbDao = new NetworkDistributionDBDAO();
		dbDaoNtAll = new WeeklyCMDBDAO();			
	}


	/**
	 * Handling the inquiry event<br>
	 * NetworkDistribution, Handling the inquiry event<br>
	 * 
	 * @param SearchConditionVO searchVo
	 * @param SignOnUserAccount account
	 * @return List<SearchCOMSalesAmountListVO> 
	 * @exception EventException
	 */
    public List<SearchCOMSalesAmountListVO> searchCOMSalesAmountList(SearchConditionVO searchVO, SignOnUserAccount account) throws EventException {
    	
        try {
            return dbDao.searchCOMSalesAmountList(searchVO);
        } catch (DAOException ex) {
            log.error("err "+ex.toString(),ex);
            throw new EventException(ex.getMessage(),ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(),ex);
        }
    }	

	/**
	 * Creation event handling<br>
	 * NetworkDistribution, Creation event handling<br>
	 * 
	 * @param SearchConditionVO searchVo
	 * @param NetworkDistributionCommonVO vo
	 * @param SignOnUserAccount account
	 * @return EventResponse
	 * @exception EventException
	 */
    public EventResponse createCOMSalesAmount(SearchConditionVO searchVo, NetworkDistributionCommonVO vo, SignOnUserAccount account) throws EventException{
        try{
    		String mss_chk_flg 	= "";
    		String pYear 		= "";
    		String fMon 		= "";
    		String tMon 		= "";
    		String fWeek 		= "";
    		String tWeek 		= "";
    		String chkPrd 		= "";
    
    		String trdCd 		= "";
    		String rlaneCd 		= "";
    		String iocCd 		= "";
    		String vslCd 		= "";
    		String skdVoyNo 	= "";
    		String dirCd 		= "";
    		String pUserId 		= "";
    		String fOpView = "";
    		String step = "";
    		
			pYear 	= searchVo.getFYear();
			fMon 	= searchVo.getFFmMon();
			tMon 	= searchVo.getFToMon();
			fWeek 	= searchVo.getFFmWk();
			tWeek 	= searchVo.getFToWk();
			chkPrd 	= searchVo.getFChkprd();

			trdCd 	   = searchVo.getFSeltrade();
			rlaneCd   = searchVo.getFSelrlane();
			iocCd     = searchVo.getFSelioc();
			vslCd     = searchVo.getFVslCd();
			skdVoyNo = searchVo.getFSkdVoyNo();
			dirCd     = searchVo.getFDirCd();
			
			pUserId    = account.getUsr_id();
			fOpView		= searchVo.getFOpView();

			// //////////////////////////////////////////////////////////////////////////////////////
			// in case of the current window: chkPrevCre = "N" ->  coaCreateNtwkCostALL
			// //////////////////////////////////////////////////////////////////////////////////////
			
            HashMap<String, String> qParam = new HashMap<String, String>();
            if (searchVo.getFChkprd().equals("M")) {
            	qParam.put("cost_year", searchVo.getFYear());
            	qParam.put("cost_month_s", searchVo.getFFmMon());
            	qParam.put("cost_month_e", searchVo.getFToMon());
            } else {
            	qParam.put("cost_year", searchVo.getFYear());
            	qParam.put("cost_week_s", searchVo.getFFmWk());
            	qParam.put("cost_week_e", searchVo.getFToWk());
            }

            if (!searchVo.getFSeltrade().equals("")) {
            	qParam.put("trd_cd", searchVo.getFSeltrade());
            }
            if (!searchVo.getFSelrlane().equals("")) {
            	qParam.put("rlane_cd", searchVo.getFSelrlane());
            }
            if (!searchVo.getFSelioc().equals("")) {
            	qParam.put("ioc_cd", searchVo.getFSelioc());
            }
            if (!searchVo.getFVslCd().trim().equals("")) {
            	qParam.put("vsl_cd", searchVo.getFVslCd());
            }
            if (!searchVo.getFSkdVoyNo().trim().equals("")) {
            	qParam.put("skd_voy_no", searchVo.getFSkdVoyNo());
            }
            if (!searchVo.getFDirCd().trim().equals("")) {
            	qParam.put("dir_cd", searchVo.getFDirCd());
            }
            // Co
            //Month 와 Week 처리 각각 처리하게 함.
            if (searchVo.getFChkprd().equals("M")) {
            	qParam.put("cost_year"   , searchVo.getFYear());
            	qParam.put("cost_month_s", searchVo.getFFmMon());
            	qParam.put("cost_month_e", searchVo.getFToMon());
            } else {
            	qParam.put("cost_year", searchVo.getFYear());
            	qParam.put("cost_week_s", searchVo.getFFmWk());
            	qParam.put("cost_week_e", searchVo.getFToWk());
            }

            if (!searchVo.getFSeltrade().equals("")) {
            	qParam.put("trd_cd", searchVo.getFSeltrade());
            }
            if (!searchVo.getFSelrlane().equals("")) {
            	qParam.put("rlane_cd", searchVo.getFSelrlane());
            }
            if (!searchVo.getFSelioc().equals("")) {
            	qParam.put("ioc_cd", searchVo.getFSelioc());
            }
            if (!searchVo.getFVslCd().trim().equals("")) {
            	qParam.put("vsl_cd", searchVo.getFVslCd());
            }
            if (!searchVo.getFSkdVoyNo().trim().equals("")) {
            	qParam.put("skd_voy_no", searchVo.getFSkdVoyNo());
            }
            if (!searchVo.getFDirCd().trim().equals("")) {
            	qParam.put("dir_cd", searchVo.getFDirCd());
            }            
            vo.setIndirectColumnValues(qParam);
           
            HashMap<String, Object> vParam = new HashMap<String, Object>();
            vParam.put("priod"     , searchVo.getFChkprd   ());
            vParam.put("trd_cd"    , searchVo.getFSeltrade ());
            vParam.put("rlane_cd"  , searchVo.getFSelrlane  ());
            vParam.put("ioc_cd"    , searchVo.getFSelioc   ());
            vParam.put("vsl_cd"    , searchVo.getFVslCd()   );
            vParam.put("skd_voy_no", searchVo.getFSkdVoyNo());
            vParam.put("dir_cd"    , searchVo.getFDirCd());
            vo.setIndirectVariableValues(vParam);
			
			
			      
            List<SearchMissingStatusVO> list = dbDao.searchMissingStatus(vo);
            int mssCnt = 0;
            if(list.size() > 0){
            	mssCnt = Integer.parseInt(((SearchMissingStatusVO)list.get(0)).getMssCnt());
            }
            
			// Procedure call order
				step = "5";
			if (mssCnt == 0) {
				mss_chk_flg = "Y";

	
				//rtnResult = dbDaoNtAll.createNtwkCostALL(pYear, fMon, tMon, fWeek, tWeek, chkPrd, "3", "N", mss_chk_flg, trd_cd, rlane_cd, ioc_cd,
				//		vsl_cd, skd_voy_no, dir_cd, null, pUserId);
				String out_err_cd	= "";
	    		String out_err_msg	= "";
				
				ProcedureParamVO procedureParamVO = new ProcedureParamVO();
				procedureParamVO.setInYr		(pYear);
				procedureParamVO.setInFmMon		(fMon);
				procedureParamVO.setInToMon		(tMon);
				procedureParamVO.setInFmWk		(fWeek);
				procedureParamVO.setInToWk		(tWeek);
				procedureParamVO.setInMonOrWk	(chkPrd);
				procedureParamVO.setInFmStep	(step);
				procedureParamVO.setInAllFlg	("N");
				procedureParamVO.setInInd		("");
				procedureParamVO.setInMssChkFlg	(mss_chk_flg);
				procedureParamVO.setInTrdCd		(trdCd);
				procedureParamVO.setInRlaneCd	(rlaneCd);
				procedureParamVO.setInIocCd		(iocCd);
				procedureParamVO.setInVslCd		(vslCd);
				procedureParamVO.setInSkdVoyNo	(skdVoyNo);
				procedureParamVO.setInDirCd		(dirCd);
				procedureParamVO.setInStndCostCd(null);
				procedureParamVO.setInUserId	(pUserId);
				procedureParamVO.setInLogLvl	("9");
				
				// 5 step : Co Sales/Slot Cht-out 
 
				ProcedureParamVO resultVO = new ProcedureParamVO();
				resultVO = dbDaoNtAll.createNtwkCostALL(procedureParamVO);
				
				if(resultVO != null){
					out_err_cd = resultVO.getOutErrCd();
					out_err_msg = resultVO.getOutErrMsg();
					log.debug("==========================================================================");
					log.debug("createNWCreForVVD- Result Error Code: " + out_err_cd);
					log.debug("createNWCreForVVD- Result Error Message: " + out_err_msg);
					log.debug("==========================================================================");
					if(out_err_cd.trim().equals("00000")){
						out_err_cd = "00000";
						out_err_msg = "Create Success!!";
						vo.setErrorCode(out_err_cd);
						vo.setErrorMsg(out_err_msg);
					} else if(out_err_cd.trim().equals("CHK05")){
						// Co Sales/Slot Cht-out 
						vo.setErrorCode(out_err_cd);
						vo.setErrorMsg(out_err_msg);
					} else {
	  
            			vo.setErrorCode(out_err_cd);
            			vo.setErrorMsg(new ErrorHandler("COA00025", out_err_msg).getMessage());
            			throw new DAOException(new ErrorHandler("COA00025",out_err_cd).getMessage());
					}
				}
			} else {
				// in case of Network cost Missing
				String[] errMessage = { "", "" };

				vo.setErrorCode("COA00023");
				log.debug(new ErrorHandler("COA00023", errMessage).getMessage()
						+"\nYou have to check the network cost at Network Cost by VVD");
				vo.setErrorMsg(new ErrorHandler("COA00023", errMessage).getMessage()
						+"\nYou have to check the network cost at Network Cost by VVD");

				log.debug("==========================================================================");
				log.debug("createCoSalesAmount Result :: " + vo.getErrorCode());
				log.debug("createCoSalesAmount Result :: " + vo.getErrorMsg());
				log.debug("==========================================================================");
			}

            GeneralEventResponse eventResponse = new GeneralEventResponse();
            eventResponse.setETCData("err_cd", vo.getErrorCode());
            eventResponse.setETCData("err_msg", vo.getErrorMsg());
            return eventResponse; // "SUCCESS"
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        } catch (Exception e){
            log.error("err "+e.toString(),e);
            throw new EventException(e.getMessage());        	
        }
    }	
    /**
	 * Handling the inquiry event<br>
	 * NetworkDistribution, Handling the inquiry event<br>
	 * 
	 * @param SearchConditionVO searchVO
	 * @param SignOnUserAccount account
	 * @return List<SearchFixCostDistListVO>
	 * @exception EventException
	 */
    public List<SearchFixCostDistListVO> searchFixCostDistList(SearchConditionVO searchVO, SignOnUserAccount account) throws EventException {
        try {
            return dbDao.searchFixCostDistList(searchVO);
        } catch (DAOException ex) {
            log.error("err "+ex.toString(),ex);
            throw new EventException(ex.getMessage(),ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(),ex);
        }
    }	

	/**
	 * Creation event handling<br>
	 * NetworkDistribution, Creation event handling<br>
	 * 
	 * @param SearchConditionVO searchVo
	 * @param SignOnUserAccount account
	 * @return EventResponse
	 * @exception EventException
	 */
    public EventResponse createFixCostDist(SearchConditionVO searchVo, SignOnUserAccount account) throws EventException{
		String mss_chk_flg 	= "";
		String pYear 		= "";
		String fMon 		= "";
		String tMon 		= "";
		String fWeek 		= "";
		String tWeek 		= "";
		String chkPrd 		= "";
		String trd_cd 		= "";
		String rlane_cd 	= "";
		String ioc_cd 		= "";
		String vsl_cd 		= "";
		String skd_voy_no 	= "";
		String dir_cd 		= "";
		String cost_cd 		= "";
		String pUserId 		= "";
		String inFmStep		= "";
		
        try{
			pYear 		= searchVo.getFYear();
			fMon 		= searchVo.getFFmMon();
			tMon 		= searchVo.getFToMon();
			fWeek 		= searchVo.getFFmWk();
			tWeek 		= searchVo.getFToWk();
			chkPrd 		= searchVo.getFChkprd();

			trd_cd 		= searchVo.getFSeltrade();
			rlane_cd 	= searchVo.getFSelrlane();
			ioc_cd 		= searchVo.getFSelioc();
			vsl_cd 		= searchVo.getFVslCd();
			skd_voy_no 	= searchVo.getFSkdVoyNo();
			dir_cd 		= searchVo.getFDirCd();
			cost_cd 	= searchVo.getFSelcost();

			pUserId     = account.getUsr_id();  
				
			// 6 step : TS delivery
			mss_chk_flg = "Y";
			inFmStep="6";
			

			//rtnResult = dbDaoNtAll.createNtwkCostALL(pYear, fMon, tMon, fWeek, tWeek, chkPrd, "6", "N", mss_chk_flg, trd_cd, rlane_cd,
			//		ioc_cd, vsl_cd, skd_voy_no, dir_cd, cost_cd, pUserId);
			String out_err_cd	= "";
    		String out_err_msg	= "";
			
			ProcedureParamVO procedureParamVO = new ProcedureParamVO();
			procedureParamVO.setInYr		(pYear);
			procedureParamVO.setInFmMon		(fMon);
			procedureParamVO.setInToMon		(tMon);
			procedureParamVO.setInFmWk		(fWeek);
			procedureParamVO.setInToWk		(tWeek);
			procedureParamVO.setInMonOrWk	(chkPrd);
			procedureParamVO.setInFmStep	(inFmStep);
			procedureParamVO.setInAllFlg	("N");
			procedureParamVO.setInInd		("");
			procedureParamVO.setInMssChkFlg	(mss_chk_flg);
			procedureParamVO.setInTrdCd		(trd_cd);
			procedureParamVO.setInRlaneCd	(rlane_cd);
			procedureParamVO.setInIocCd		(ioc_cd);
			procedureParamVO.setInVslCd		(vsl_cd);
			procedureParamVO.setInSkdVoyNo	(skd_voy_no);
			procedureParamVO.setInDirCd		(dir_cd);
			procedureParamVO.setInStndCostCd(cost_cd);
			procedureParamVO.setInUserId	(pUserId);
			procedureParamVO.setInLogLvl	("9");
			
			ProcedureParamVO resultVO = new ProcedureParamVO();
			resultVO = dbDaoNtAll.createNtwkCostALL(procedureParamVO);
			
			if(resultVO != null){
				out_err_cd = resultVO.getOutErrCd();
				out_err_msg = resultVO.getOutErrMsg();
				log.debug("==========================================================================");
				log.debug("createFixCostDist- Result Error Code: " + out_err_cd);
				log.debug("createFixCostDist- Result Error Message: " + out_err_msg);
				log.debug("==========================================================================");
				if(out_err_cd.trim().equals("00000")){
					out_err_cd = "00000";
					out_err_msg = "Create Success!!";  	
				} else {

					out_err_msg = new ErrorHandler("COA00025", out_err_msg).getMessage();
//        			throw new DAOException(new ErrorHandler("COA00025",out_err_cd).getMessage());
				}
			}

            GeneralEventResponse eventResponse = new GeneralEventResponse();
            eventResponse.setETCData("err_cd", out_err_cd);
            eventResponse.setETCData("err_msg",out_err_msg);

            return eventResponse; // "SUCCESS"
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }
    }	


	/**
	 * Handling the inquiry event<br>
	 * NetworkDistribution, Handling the inquiry event<br>
	 * 
	 * @param SearchConditionVO searchVo
	 * @param NetworkDistributionCommonVO vo
	 * @param SignOnUserAccount account
	 * @return List<SearchFixCostDistResultListVO>
	 * @exception EventException
	 */
    public List<SearchFixCostDistResultListVO> searchFixCostDistResultList(SearchConditionVO searchVo, NetworkDistributionCommonVO vo, SignOnUserAccount account) throws EventException {
    	
        try {
            HashMap<String, String> qParam = new HashMap<String, String>();
            if (!searchVo.getFSeltrade().equals("")){
                qParam.put("trd_cd", searchVo.getFSeltrade());
            }
            if (!searchVo.getFSelrlane().equals("")){
                qParam.put("rlane_cd", searchVo.getFSelrlane());
            }
            if (!searchVo.getFSelioc().equals("")){
                qParam.put("ioc_cd", searchVo.getFSelioc());
            }
            if (!searchVo.getFVslCd().equals("")){
                qParam.put("vsl_cd", searchVo.getFVslCd());
            }
            if (!searchVo.getFSkdVoyNo().equals("")){
                qParam.put("skd_voy_no", searchVo.getFSkdVoyNo());
            }
            if (!searchVo.getFDirCd().equals("")){
                qParam.put("dir_cd", searchVo.getFDirCd());
            }
            if (!searchVo.getFSelcost().equals("")){
                qParam.put("stnd_cost_cd", searchVo.getFSelcost());
            }
            if (searchVo.getFChkprd().equals("M")){
                if(!searchVo.getFFmMon().equals("")){
                    qParam.put("cost_yrmon_s", searchVo.getFYear() + searchVo.getFFmMon());
                    qParam.put("cost_yrmon_e", searchVo.getFYear() + searchVo.getFToMon());
                }else{
                    qParam.put("cost_yrmon", searchVo.getFYear());
                }

            } else if (searchVo.getFChkprd().equals("W")) {
                qParam.put("sls_yrmon", searchVo.getFYear() + "%");
                if(!searchVo.getFFmWk().equals("")){
                    qParam.put("cost_wk_s", searchVo.getFFmWk());
                    qParam.put("cost_wk_e", searchVo.getFToWk());
                }
            }
           
            vo.setIndirectColumnValues(qParam);

            HashMap<String, Object> vParam = new HashMap<String, Object>();
            vParam.put("trd_cd"      , searchVo.getFSeltrade() );
            vParam.put("rlane_cd"    , searchVo.getFSelrlane() );
            vParam.put("ioc_cd"      , searchVo.getFSelioc()   );
            vParam.put("vsl_cd"      , searchVo.getFVslCd()    );
            vParam.put("skd_voy_no"  , searchVo.getFSkdVoyNo() );
            vParam.put("dir_cd"      , searchVo.getFDirCd()    );
            vParam.put("stnd_cost_cd", searchVo.getFSelcost()  );
            vParam.put("priod"       , searchVo.getFChkprd()   );
            vParam.put("fmMonth"     , searchVo.getFFmMon()    );
            vParam.put("fmWeek"      , searchVo.getFFmWk()     );           
            vo.setIndirectVariableValues(vParam);

            return dbDao.searchFixCostDistResultList(vo);
        } catch (DAOException ex) {
            log.error("err "+ex.toString(),ex);
            throw new EventException(ex.getMessage(),ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(),ex);
        }
    }
	

	/**
	 * ESM_COA_106: APPLY event handling<br>
	 * NetworkDistribution, APPLY event handling<br>
	 * 
	 * @param SearchConditionVO searchVo
	 * @param NetworkDistributionCommonVO vo
	 * @param SignOnUserAccount account
	 * @return EventResponse
	 * @exception DAOException
	 */
    public EventResponse applyToPL(SearchConditionVO searchVo, NetworkDistributionCommonVO vo, SignOnUserAccount account) throws EventException{
        try{
            List createList  = new ArrayList();
            List createList2 = new ArrayList();
            List createList3 = new ArrayList();
            List updateList  = new ArrayList();

            //
            //----------------------------------------------------
            HashMap<String, String> param = new HashMap<String, String>();
            if (!searchVo.getFSeltrade().equals("")){
                param.put("trd_cd", searchVo.getFSeltrade());
            }
            if (!searchVo.getFSelrlane().equals("")){
                param.put("rlane_cd", searchVo.getFSelrlane());
            }
            if (!searchVo.getFSelioc().equals("")){
                param.put("ioc_cd", searchVo.getFSelioc());
            }
            if (!searchVo.getFVslCd().equals("")){
                param.put("vsl_cd", searchVo.getFVslCd());
            }
            if (!searchVo.getFSkdVoyNo().equals("")){
                param.put("skd_voy_no", searchVo.getFSkdVoyNo());
            }
            if (!searchVo.getFDirCd().equals("")){
                param.put("dir_cd", searchVo.getFDirCd());
            }
            if (searchVo.getFChkprd().equals("M")){
                if(!searchVo.getFFmMon().equals("")){
                    param.put("cost_yrmon_s", searchVo.getFYear() + searchVo.getFFmMon());
                    param.put("cost_yrmon_e", searchVo.getFYear() + searchVo.getFToMon());
                }else{
                    param.put("cost_yrmon", searchVo.getFYear());
                }

            } else if (searchVo.getFChkprd().equals("W")) {
                param.put("sls_yrmon", searchVo.getFYear() + "%");
                if(!searchVo.getFFmWk().equals("")){
                    param.put("cost_wk_s", searchVo.getFFmWk());
                    param.put("cost_wk_e", searchVo.getFToWk());
                }
            }
                        
            param.put("upd_usr_id", account.getUsr_id());
            param.put("cre_usr_id", account.getUsr_id());
            
            createList.add(param);  
            createList2.add(param);
            createList3.add(param);
            updateList.add(param);

            vo.setMultiCreateList (createList );
            vo.setMultiCreateList2(createList2);
            vo.setMultiCreateList3(createList3);
            vo.setMultiUpdateList (updateList );
            
            HashMap<String, Object> vParam = new HashMap<String, Object>();
            vParam.put("trd_cd"      , searchVo.getFSeltrade());
            vParam.put("rlane_cd"    , searchVo.getFSelrlane());
            vParam.put("ioc_cd"      , searchVo.getFSelioc()  );
            vParam.put("vsl_cd"      , searchVo.getFVslCd()   );
            vParam.put("skd_voy_no"  , searchVo.getFSkdVoyNo());
            vParam.put("dir_cd"      , searchVo.getFDirCd()   );
            vParam.put("priod"       , searchVo.getFChkprd()  );
            vParam.put("fmMonth"     , searchVo.getFFmMon()   );
            vParam.put("fmWeek"      , searchVo.getFFmWk()    );
            vo.setIndirectVariableValues(vParam);            

            
            dbDao.applyToPL(vo);			
            //############################################################################
            
            vo.setErrorCode("00000");
            vo.setErrorMsg("OK!");            
            
            GeneralEventResponse eventResponse = new GeneralEventResponse();
            eventResponse.setETCData("err_cd",vo.getErrorCode());
            eventResponse.setETCData("err_msg",vo.getErrorMsg());
            
            return eventResponse; // "SUCCESS"
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }
    }	

	/**
	 *ESM_COA_0153: Handling the inquiry event<br>
	 * 
	 * @param SearchConditionVO searchVo
	 * @param NetworkDistributionCommonVO vo
	 * @param SignOnUserAccount account
	 * @return List<SearchSpcChtrRevMssListVO>
	 * @exception EventException
	 */
    public List<SearchSpcChtrRevMssListVO> searchSpcChtrRevMssList(SearchConditionVO searchVo, NetworkDistributionCommonVO vo, SignOnUserAccount account) throws EventException {
        try {
            HashMap<String, String> qParam = new HashMap<String, String>();
            if (searchVo.getFChkprd().equals("M")){
                if(!searchVo.getFFmMon().equals("")){
                    qParam.put("cost_yrmon_s", searchVo.getFYear() + searchVo.getFFmMon());
                    qParam.put("cost_yrmon_e", searchVo.getFYear() + searchVo.getFToMon());
                }else{
                    qParam.put("cost_yrmon", searchVo.getFYear());
                }

            } else if (searchVo.getFChkprd().equals("W")) {
                qParam.put("sls_yrmon", searchVo.getFYear() + "%");
                if(!searchVo.getFFmWk().equals("")){
                    qParam.put("cost_wk_s", searchVo.getFFmWk());
                    qParam.put("cost_wk_e", searchVo.getFToWk());
                }
            }
            vo.setIndirectColumnValues(qParam);

            HashMap<String, Object> vParam = new HashMap<String, Object>();
            vParam.put("priod"  , searchVo.getFChkprd());
            vParam.put("fmMonth", searchVo.getFFmMon() );
            vParam.put("fmWeek" , searchVo.getFFmWk()  );
            vo.setIndirectVariableValues(vParam);

            return dbDao.searchSpcChtrRevMssList(vo);
        } catch (DAOException ex) {
            log.error("err "+ex.toString(),ex);
            throw new EventException(ex.getMessage(),ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(),ex);
        }
    }
    
	
    /**
	 * [Allocation Result(Internal Pricing)] Inquiry<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @return List<CoaFxAmtDtrbVO>
	 * @exception EventException
	 */
	public List<CoaFxAmtDtrbVO> searchAllocationResultInter(SearchConditionVO searchConditionVO) throws EventException {
		try {
            return dbDao.searchAllocationResultInter(searchConditionVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}
	
	/**
	 * Allocation Result(Internal Pricing) Create event handling<br>
	 * NetworkDistribution, Create event handling<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @param SignOnUserAccount account
	 * @return EventResponse
	 * @exception DAOException
	 */
    public EventResponse createAllocationResultInter(SearchConditionVO searchConditionVO, SignOnUserAccount account) throws EventException{
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	String inYr 		= "";
		String inFmMon 		= "";
		String inToMon 		= "";
		String inFmWk 		= "";
		String inToWk 		= "";
		String inMonOrWk	= "";

		String inTrdCd 		= "";
		String inRlaneCd 	= "";
		String inIocCd 		= "";
		String inVslCd 		= "";
		String inSkdVoyNo 	= "";
		String inDirCd 		= "";
		String inUserId		= "";
		String out_err_cd	= "";
		String out_err_msg	= "";
		
        try{
    		inYr 		= searchConditionVO.getFYear();
    		inFmMon 	= searchConditionVO.getFFmMon();
    		inToMon 	= searchConditionVO.getFToMon();
    		inFmWk 		= searchConditionVO.getFFmWk();
    		inToWk 		= searchConditionVO.getFToWk();
    		inMonOrWk	= searchConditionVO.getFChkprd();
    
    		inTrdCd 	= searchConditionVO.getFCobtrade();
    		inRlaneCd 	= searchConditionVO.getFCoblane();
    		inVslCd 	= searchConditionVO.getFVessel();
    		inSkdVoyNo 	= searchConditionVO.getFVoyage();
    		inDirCd 	= searchConditionVO.getFDir();
    		inUserId	= account.getUsr_id();

			ProcedureParamVO procedureParamVO = new ProcedureParamVO();
			procedureParamVO.setInFmStep    ("2");
			procedureParamVO.setInYr		(inYr);
			procedureParamVO.setInFmMon		(inFmMon);
			procedureParamVO.setInToMon		(inToMon);
			procedureParamVO.setInFmWk		(inFmWk);
			procedureParamVO.setInToWk		(inToWk);
			procedureParamVO.setInMonOrWk	(inMonOrWk);
			procedureParamVO.setInStndCostCd("54600000");
			procedureParamVO.setInTrdCd		(inTrdCd);
			procedureParamVO.setInRlaneCd	(inRlaneCd);
			procedureParamVO.setInIocCd		(inIocCd);
			procedureParamVO.setInVslCd		(inVslCd);
			procedureParamVO.setInSkdVoyNo	(inSkdVoyNo);
			procedureParamVO.setInDirCd		(inDirCd);
			procedureParamVO.setInStndCostCd(null);
			procedureParamVO.setInUserId	(inUserId);
			
			ProcedureParamVO resultVO = new ProcedureParamVO();
			resultVO = dbDao.createAllocationResultInter(procedureParamVO);
            
            if(resultVO != null){
    			
    			out_err_cd = resultVO.getOutErrCd();
    			out_err_msg = resultVO.getOutErrMsg();
                log.debug("==========================================================================");
                log.debug("createNWCreForVVD Result Error Code: " + out_err_cd);
                log.debug("createNWCreForVVD Result Error Message: " + out_err_msg);
                log.debug("==========================================================================");

                if(out_err_cd.trim().equals("00000")){
					out_err_cd = "00000";
					out_err_msg = "Create Success!!";  	
				} else {
					  
					out_err_msg = new ErrorHandler("COA00025", out_err_msg).getMessage();
//        			throw new DAOException(new ErrorHandler("COA00025",out_err_cd).getMessage());
        			throw new DAOException(new ErrorHandler("COA00025",out_err_cd).getMessage());
				}               
            }	            

            eventResponse.setETCData("err_cd",  out_err_cd);
            eventResponse.setETCData("err_msg", out_err_msg);

            return eventResponse; // "SUCCESS"
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }
    }
    /**
	 * ESM_COA_0107: APPLY event handling<br>
	 * NetworkDistribution, APPLY event handling<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @param SignOnUserAccount account
	 * @return EventResponse
	 * @exception DAOException
	 */
    public EventResponse applyToPLInter(SearchConditionVO searchConditionVO, SignOnUserAccount account) throws EventException{
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	String inYr 		= "";
		String inFmMon 		= "";
		String inToMon 		= "";
		String inFmWk 		= "";
		String inToWk 		= "";
		String inMonOrWk	= "";

		String inTrdCd 		= "";
		String inRlaneCd 	= "";
		String inIocCd 		= "";
		String inVslCd 		= "";
		String inSkdVoyNo 	= "";
		String inDirCd 		= "";
		String inUserId		= "";
		String out_err_cd	= "";
		String out_err_msg	= "";
		
        try{
    		inYr 		= searchConditionVO.getFYear();
    		inFmMon 	= searchConditionVO.getFFmMon();
    		inToMon 	= searchConditionVO.getFToMon();
    		inFmWk 		= searchConditionVO.getFFmWk();
    		inToWk 		= searchConditionVO.getFToWk();
    		inMonOrWk	= searchConditionVO.getFChkprd();
    
    		inTrdCd 	= searchConditionVO.getFCobtrade();
    		inRlaneCd 	= searchConditionVO.getFCoblane();
    		inVslCd 	= searchConditionVO.getFVessel();
    		inSkdVoyNo 	= searchConditionVO.getFVoyage();
    		inDirCd 	= searchConditionVO.getFDir();
    		inUserId	= account.getUsr_id();

			ProcedureParamVO procedureParamVO = new ProcedureParamVO();
			procedureParamVO.setInFmStep    ("9");
			procedureParamVO.setInYr		(inYr);
			procedureParamVO.setInFmMon		(inFmMon);
			procedureParamVO.setInToMon		(inToMon);
			procedureParamVO.setInFmWk		(inFmWk);
			procedureParamVO.setInToWk		(inToWk);
			procedureParamVO.setInMonOrWk	(inMonOrWk);
			procedureParamVO.setInStndCostCd("54600000");
			procedureParamVO.setInTrdCd		(inTrdCd);
			procedureParamVO.setInRlaneCd	(inRlaneCd);
			procedureParamVO.setInIocCd		(inIocCd);
			procedureParamVO.setInVslCd		(inVslCd);
			procedureParamVO.setInSkdVoyNo	(inSkdVoyNo);
			procedureParamVO.setInDirCd		(inDirCd);
			procedureParamVO.setInStndCostCd(null);
			procedureParamVO.setInUserId	(inUserId);
			
			ProcedureParamVO resultVO = new ProcedureParamVO();
			resultVO = dbDao.applyToPLInter(procedureParamVO);
            
            if(resultVO != null){
    			
    			out_err_cd = resultVO.getOutErrCd();
    			out_err_msg = resultVO.getOutErrMsg();
                log.debug("==========================================================================");
                log.debug("createNWCreForVVD Result Error Code: " + out_err_cd);
                log.debug("createNWCreForVVD Result Error Message: " + out_err_msg);
                log.debug("==========================================================================");

                if(out_err_cd.trim().equals("00000")){
					out_err_cd = "00000";
					out_err_msg = "Create Success!!";  	
				} else {
					  
					out_err_msg = new ErrorHandler("COA00025", out_err_msg).getMessage();
//        			throw new DAOException(new ErrorHandler("COA00025",out_err_cd).getMessage());
        			throw new DAOException(new ErrorHandler("COA00025",out_err_cd).getMessage());
				}                
            }	            

            eventResponse.setETCData("err_cd", out_err_cd);
            eventResponse.setETCData("err_msg", out_err_msg);      
            return eventResponse; // "SUCCESS"
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }
    }
}