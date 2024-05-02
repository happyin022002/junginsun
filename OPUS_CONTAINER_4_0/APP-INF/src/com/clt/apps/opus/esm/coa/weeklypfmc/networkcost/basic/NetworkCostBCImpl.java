/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : NetworkCostBCImpl.java
 *@FileTitle : Network Cost BC Impl
 *Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
  =========================================================*/
package com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.clt.apps.opus.esm.coa.common.Utils;
import com.clt.apps.opus.esm.coa.common.vo.CommonCoaRsVO;
import com.clt.apps.opus.esm.coa.common.vo.ProcedureParamVO;
import com.clt.apps.opus.esm.coa.common.vo.SearchConditionVO;
import com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.integration.NetworkCostDBDAO;
import com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.vo.CoaPortTrfParamVO;
import com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.vo.NetworkCostCommonVO;
import com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.vo.SearchBunkerTariff2MonthCountVO;
import com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.vo.SearchBunkerTariffListVO;
import com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.vo.SearchDailyHire2MonthCountVO;
import com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.vo.SearchDailyHireListVO;
import com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.vo.SearchFixCostByVVDListVO;
import com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.vo.SearchIntervalTransitTimeListVO;
import com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.vo.SearchMissingStatusListVO;
import com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.vo.SearchNWCreListVO;
import com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.vo.SearchNWCreRStatusListVO;
import com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.vo.SearchOptFixedCostListVO;
import com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.vo.SearchPortTariffDetailListVO;
import com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.vo.SearchPortTariffListVO;
import com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.vo.SearchSltChtrCreListVO;
import com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.vo.SearchSltChtrCreRStatusListVO;
import com.clt.apps.opus.esm.coa.weeklypfmc.weeklycm.integration.WeeklyCMDBDAO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.CoaBnkTrfVO;
import com.clt.syscommon.common.table.CoaInterPrcUtCostVO;
import com.clt.syscommon.common.table.CoaInterPrcVvdExpnVO;
import com.clt.syscommon.common.table.CoaMonVvdPortOpDysVO;
import com.clt.syscommon.common.table.CoaNtwkCostCreVO;
import com.clt.syscommon.common.table.CoaOwnVslDlyHirVO;
import com.clt.syscommon.common.table.CoaSltChtrInfoVO;
import com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.vo.PndlmSvcVO;				//20151001.ADD
import com.clt.framework.component.rowset.DBRowSet;									//20151001.ADD

/**
 * COA Business Logic Basic Command implementation<br>
 * 
 * @author
 * @see NetworkCostBC reference the each DAO class 
 * @since J2EE 1.4 
 */
public class NetworkCostBCImpl extends BasicCommandSupport implements NetworkCostBC {

	// Database Access Object
	private transient NetworkCostDBDAO dbDao = null;
	private transient WeeklyCMDBDAO dbDaoNtAll = null;	//for the Nt cost All Procedure
	

	/**
	 * NetworkCostBCImpl Object creation<br>
	 * NetworkCostDBDAO Creation<br>
	 */
	public NetworkCostBCImpl() {
		dbDao = new NetworkCostDBDAO();
		dbDaoNtAll = new WeeklyCMDBDAO();		
	}
	


	/**
	 * 1. Function : Create a transit time and ratio by route, Handling the inquiry event(ESM_COA_039)<p>
	 * 2. Overview : <p>
	 *    - Inquiry list (Create a transit time and ratio by route)
	 * 3. Caution : <p>
	 * ===================================<br>
	 * <p/>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @param SignOnUserAccount account
	 * @return List<SearchIntervalTransitTimeListVO>
	 * @exception EventException
	 */
    public List<SearchIntervalTransitTimeListVO> searchIntervalTransitTimeList(SearchConditionVO searchConditionVO, SignOnUserAccount account) throws EventException {
        try {            
            return dbDao.searchIntervalTransitTimeList(searchConditionVO);
        } catch (DAOException ex) {
            log.error("err "+ex.toString(),ex);
            throw new EventException(ex.getMessage(),ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(),ex);
        }
    }
	
	/**
	 * 1. Function : Create a transit time and ratio by route, Handling the save event(ESM_COA_039)<p>
	 * 2. Overview : <p>
	 *    - SAve list (Create a transit time and ratio by route)
	 * 3. Caution : <p>
	 * ===================================<br>

	 * <p/>
	 * 
	 * @param CoaMonVvdPortOpDysVO[] coaMonVvdPortOpDysVOs
	 * @param SignOnUserAccount account
	 * @return EventResponse
	 * @exception EventException
	 */
    public EventResponse multiIntervalTransitTime(CoaMonVvdPortOpDysVO[] coaMonVvdPortOpDysVOs, SignOnUserAccount account) throws EventException{
        try{
            List<CoaMonVvdPortOpDysVO> multiList        = new ArrayList<CoaMonVvdPortOpDysVO>();

            if(coaMonVvdPortOpDysVOs.length > 0){
                for(int i = 0 ; i < coaMonVvdPortOpDysVOs.length ; i++){
                	coaMonVvdPortOpDysVOs[i].setUpdUsrId(account.getUse_flg());
                	
                	multiList.add(coaMonVvdPortOpDysVOs[i]);
                }
            }
            
            dbDao.multiIntervalTransitTime(multiList);

            GeneralEventResponse eventResponse = new GeneralEventResponse();
            return eventResponse; // "SUCCESS"
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }
    }	

	/**
	 * 1. Function : Tariff Inquiry/Update by Port Class, Handling the inquiry event(ESM_COA_040)<p>
	 * 2. Overview : <p>
	 *    - Inquiry list (Tariff Inquiry/Update by Port Class) 
	 * 3. Caution : <p>
	 * ===================================<br>
	 * <p/>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @return List<SearchPortTariffListVO>
	 * @exception EventException
	 */
	public List<SearchPortTariffListVO> searchPortTariffList(SearchConditionVO searchConditionVO) throws EventException {
		try {
			String[] arrSearch = searchConditionVO.getFYearweek().split("[-]");
			String yrType = searchConditionVO.getFYrtype();
			String year = arrSearch[0];
			String cost_wk	= "";
			String cost_mon	= "";
			
			if( yrType.equals("W")) cost_wk = arrSearch[1];
			if( yrType.equals("M")) cost_mon = arrSearch[1];
			
			searchConditionVO.setFYear(year);
			searchConditionVO.setFFmWk(cost_wk);
			searchConditionVO.setFFmMon(cost_mon);
			
			return dbDao.searchPortTariffList(searchConditionVO);
		} catch (DAOException ex) {
			log.error("err "+ex.toString(),ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * 1. Function : Tariff Inquiry/Update by Port Class, 생성 event handling(ESM_COA_040)<p>
	 * 2. Overview : <p>
	 *    - Inquiry list (Tariff Inquiry/Update by Port Class) 
	 * 3. Caution : <p>
	 * ===================================<br>

	 * <p/>
	 *
	 * @param SearchConditionVO searchConditionVO
	 * @param SignOnUserAccount account
	 * @return EventResponse
	 * @throws EventException
	 */ 
	public EventResponse createPortTariff(SearchConditionVO searchConditionVO, SignOnUserAccount account) throws EventException{
		try{
			searchConditionVO.setFYear(searchConditionVO.getFYearweek().replaceAll("-", "").substring(0,4));
			searchConditionVO.setFCostYrmon(searchConditionVO.getFYearweek().replaceAll("-", ""));
			searchConditionVO.setFFmWk(searchConditionVO.getFYearweek().substring(5));

			dbDao.createPortTariff(searchConditionVO, account);
			//############################################################################

            GeneralEventResponse eventResponse = new GeneralEventResponse();
            return eventResponse; // "SUCCESS"
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }
	}
	

	/**
	 * 1. Function : fuel cost Inquiry/Update, Handling the inquiry event(ESM_COA_041)<p>
	 * 2. Overview : <p>
	 *    - Inquiry list (fuel cost Inquiry/Update)
	 * 3. Caution : <p>
	 * ===================================<br>

	 * <p/>
	 * 
	 * @param SearchConditionVO searchVo
	 * @param NetworkCostCommonVO vo
	 * @return List<SearchBunkerTariffListVO>
	 * @exception EventException
	 */
	public List<SearchBunkerTariffListVO> searchBunkerTariffList(SearchConditionVO searchVo, NetworkCostCommonVO vo) throws EventException {
		try {
			List<SearchBunkerTariff2MonthCountVO> list1 = null;
			List<SearchBunkerTariffListVO> list2 = null;
			
			String[] arrSearch = searchVo.getFYearweek().split("[-]");
			
            HashMap<String, String> qParam = new HashMap<String, String>();
            qParam.put("sls_yrmon"     , arrSearch[0]);
            qParam.put("cost_wk"       , arrSearch[1]);
            qParam.put("slan_cd"       , JSPUtil.getNull(searchVo.getFSelslane()));
            qParam.put("rlane_cd"      , JSPUtil.getNull(searchVo.getFSelrlane()));
            qParam.put("vsl_clss_capa" , JSPUtil.getNull(searchVo.getFSelclass()));
            vo.setIndirectColumnValues(qParam);	
	        
            HashMap<String, Object> vParam = new HashMap<String, Object>();
            vParam.put("yrType"        , searchVo.getFYrtype());
            vParam.put("slan_cd"       , JSPUtil.getNull(searchVo.getFSelslane()));
            vParam.put("slan_cd"       , JSPUtil.getNull(searchVo.getFSelrlane()));
            vParam.put("vsl_clss_capa", JSPUtil.getNull(searchVo.getFSelclass()));  	        
	        vo.setIndirectVariableValues(vParam);				
			
	        
	        
			list1 = dbDao.searchBunkerTariff2MonthCount(vo);
			
			SearchBunkerTariff2MonthCountVO retVo = list1.get(0);
			
			vo.setRtnRow(retVo.getCnt());
			
            HashMap<String, String> qParam2 = new HashMap<String, String>();
            qParam2.put("sls_yrmon"     , arrSearch[0]);
            qParam2.put("cost_wk"       , arrSearch[1]);
            qParam2.put("slan_cd"       , JSPUtil.getNull(searchVo.getFSelslane()));
            qParam2.put("rlane_cd"      , JSPUtil.getNull(searchVo.getFSelrlane()));
            qParam2.put("vsl_clss_capa" , JSPUtil.getNull(searchVo.getFSelclass()));
            vo.setIndirectColumnValues(qParam2);	
	        
            HashMap<String, Object> vParam2 = new HashMap<String, Object>();
            vParam2.put("yrType", searchVo.getFYrtype());
            vParam2.put("rtnRow", vo.getRtnRow());	
            vParam2.put("slan_cd"       , JSPUtil.getNull(searchVo.getFSelslane()));
            vParam2.put("rlane_cd"      , JSPUtil.getNull(searchVo.getFSelrlane()));
            vParam2.put("vsl_clss_capa" , JSPUtil.getNull(searchVo.getFSelclass()));
            
	        vo.setIndirectVariableValues(vParam2);					
			
			list2 = dbDao.searchBunkerTariffList(vo);
			
			return list2;
		} catch (DAOException ex) {
			log.error("err "+ex.toString(),ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
	}		

	/**
	 * 1. Function : fuel cost Inquiry/Update, Handling multi event(ESM_COA_041)<p> Inquiry list (fuel cost Inquiry/Update)
	 * 2. Overview : <p>
	 *    - Multi handling (fuel cost Inquiry/Update)
	 * 3. Caution : <p>
	 * ===================================<br>

	 * <p/>
	 * 
	 * @param SearchConditionVO searchVo
	 * @param NetworkCostCommonVO vo
	 * @param CoaBnkTrfVO[] vos
	 * @param String userId
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public EventResponse multiBunkerTariff(SearchConditionVO searchVo, NetworkCostCommonVO vo, CoaBnkTrfVO[] vos, String userId) throws EventException{
		try{
			List saveList = new ArrayList();
			// 
			//----------------------------------------------------			
            if(vos.length > 0){
                for(int i = 0 ; i < vos.length ; i++){
                    //query parameter
                    HashMap<String, String> param = vos[i].getColumnValues();
                    param.put("user_id"   , userId);
                    param.put("cre_usr_id", userId);
                    param.put("upd_usr_id", userId);
                    if(vos[i].getIbflag().equals("I") || vos[i].getIbflag().equals("U")) {
                    	param.put("cost_yrmon"		, vos[i].getCostYrmon());
                    	param.put("slan_cd"			, vos[i].getSlanCd());
                    	param.put("rlane_cd"		, vos[i].getRlaneCd());
                    	param.put("slan_dir_cd"		, vos[i].getSlanDirCd());
                    	param.put("vsl_clss_capa"	, vos[i].getVslClssCapa());
                    	param.put("foil_csm"		, vos[i].getFoilCsm());
                    	param.put("foil_uc_amt"		, vos[i].getFoilUcAmt());
                    	param.put("doil_csm"		, vos[i].getDoilCsm());
                    	param.put("doil_uc_amt"		, vos[i].getDoilUcAmt());
                    	saveList.add(param);
                    }                 
                }
            }               
            vo.setMultiSaveList(saveList);			
			

			dbDao.multiBunkerTariff(vo);
			//############################################################################
            
            GeneralEventResponse eventResponse = new GeneralEventResponse();
            return eventResponse; // "SUCCESS"
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }                
	}	

	/**
	 * 1. Function : Header Information Inquiry(ESM_COA_043)<p>
	 * 2. Overview : <p>
	 *    - Inquiry list (Fixed cost management)
	 * 3. Caution : <p>
	 * ===================================<br>

	 * <p/>
	 * 
	 * @param  SearchConditionVO searchVo
	 * @param  NetworkCostCommonVO vo
	 * @return List<NetworkCostCommonVO>
	 * @throws EventException
	 */
	public List<NetworkCostCommonVO> searchOptFixedCostList(SearchConditionVO searchVo, NetworkCostCommonVO vo) throws EventException {
		try {
			List<SearchOptFixedCostListVO> retList = null;

			retList = dbDao.searchOptFixedCostList(vo);
			
			//String headerCD = "";
			//String headerNM = "";	
			StringBuffer sbCD = new StringBuffer();
			StringBuffer sbNM = new StringBuffer();
			
			
			List<NetworkCostCommonVO> list = new ArrayList<NetworkCostCommonVO>();
			int size = retList.size();
			for(int i=0; i<size; i++){
				//headerCD = headerCD + ((SearchOptFixedCostListVO)(retList.get(i))).getStndCostCd();  
				//headerNM = headerNM + ((SearchOptFixedCostListVO)(retList.get(i))).getStndCostNm();
				sbCD.append(((SearchOptFixedCostListVO)(retList.get(i))).getStndCostCd());
				sbNM.append(((SearchOptFixedCostListVO)(retList.get(i))).getStndCostNm());
				
				
				if(i != (size-1)){
					//headerCD = headerCD + "|";
					//headerNM = headerNM + "|";
					sbCD.append("|");
					sbNM.append("|");					
				}
			}
			
			NetworkCostCommonVO tempVo = new NetworkCostCommonVO();
			tempVo.setHeaderCD(sbCD.toString());
			tempVo.setHeaderNM(sbNM.toString());
			list.add(tempVo);			

			return list;
		} catch (DAOException ex) {
			log.error("err "+ex.toString(),ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
	}	
		

	/**
	 * 1. Function : Fixed cost management, Handling the inquiry event(ESM_COA_043)<p>
	 * 2. Overview : <p>
	 *    - Inquiry list (Fixed cost management)
	 * 3. Caution : <p>
	 * ===================================<br>

	 * <p/>
	 * 
	 * @param SearchConditionVO searchVo
	 * @param NetworkCostCommonVO vo
	 * @return NetworkCostCommonVO
	 * @exception EventException
	 */
	public NetworkCostCommonVO searchOwnDailyHireList(SearchConditionVO searchVo, NetworkCostCommonVO vo) throws EventException {
		try {
			NetworkCostCommonVO[] rVoArray = new NetworkCostCommonVO[1];
	        String[] yearwk = searchVo.getFYearweek().split("[-]");
	        
	        vo.setIteratorList(vo.seperationParameter(searchVo.getFHeader().trim(), "|"));
	        vo.setIteratorCnt(vo.getIteratorList().size());
	        
            HashMap<String, String> qParam = new HashMap<String, String>();
            qParam.put("sls_yrmon", yearwk[0]);
            qParam.put("cost_wk"  , yearwk[1]);
            qParam.put("vsl_cd"   , Utils.iif(searchVo.getFSelvessel() == null, "", searchVo.getFSelvessel()));
            vo.setIndirectColumnValues(qParam);	
	        
            HashMap<String, Object> vParam = new HashMap<String, Object>();
            vParam.put("keyList"  , vo.getIteratorList()==null?"":vo.getIteratorList().iterator());
            vParam.put("keyList2" , vo.getIteratorList()==null?"":vo.getIteratorList().iterator());
            vParam.put("keyList3" , vo.getIteratorList()==null?"":vo.getIteratorList().iterator());
            vParam.put("yrType" , searchVo.getFYrtype());	        
	        vo.setIndirectVariableValues(vParam);
	        
            HashMap<String, Object> vParam2 = new HashMap<String, Object>();
            vParam2.put("keyList"  , vo.getIteratorList()==null?"":vo.getIteratorList().iterator());
            vParam2.put("keyList2" , vo.getIteratorList()==null?"":vo.getIteratorList().iterator());
            vParam2.put("keyList3" , vo.getIteratorList()==null?"":vo.getIteratorList().iterator());
            vParam2.put("yrType"   , searchVo.getFYrtype());	 
            
			rVoArray[0] = new NetworkCostCommonVO();
			rVoArray[0] = dbDao.searchOwnDailyHireList(vo);
			
			vo.setIndirectVariableValues(vParam2);
			/*
			rVoArray[1] = new NetworkCostCommonVO();
			rVoArray[1] = dbDao.searchOwnDHireByClassList(vo);
			*/
			vo.setNetworkCostCommonVOArray(rVoArray);	
			
			List<NetworkCostCommonVO> list = new ArrayList<NetworkCostCommonVO>();
			list.add(vo);
			
			return vo;
		} catch (DAOException ex) {
			log.error("err "+ex.toString(),ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}		
	}	
	

    

	/**
	 * 1. Function : Fixed cost management, Handling multi event(ESM_COA_043)<p>
	 * 2. Overview : <p>
	 *    - Muti handling (Fixed cost management)
	 * 3. Caution : <p>
	 * ===================================<br>

	 * <p/>
	 * 
	 * @param SearchConditionVO searchVo
	 * @param NetworkCostCommonVO vo
	 * @param CoaOwnVslDlyHirVO[] vos
	 * @param String userId
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse multiOwnDailyHire(SearchConditionVO searchVo, NetworkCostCommonVO vo, CoaOwnVslDlyHirVO[] vos, String userId) throws EventException{
		try{
			List<HashMap<String, String>> createList = new ArrayList<HashMap<String, String>>();	     
            String[] stnd_cost_cd   = searchVo.getFHeader().split("[|]");	
            
			// 
			//----------------------------------------------------
            if(vos.length > 0){
                for(int i = 0 ; i < vos.length ; i++){
                    for (int k = 0; k < stnd_cost_cd.length; k++) {
                        String[] dhir_amt = vo.getHashAttribute("t"+stnd_cost_cd[k]);
                        
                        //query parameter
                        HashMap<String, String> param = new HashMap<String, String>();
                        param.put("user_id"   , userId);
                        param.put("cre_usr_id", userId);
                        param.put("upd_usr_id", userId);               

                        if(vos[i].getIbflag().equals("I")||vos[i].getIbflag().equals("U")) {
                        	param.put("cost_yrmon"		, vos[i].getCostYrmon()  ); 
                        	param.put("vsl_cd"			, vos[i].getVslCd()      );
                        	param.put("stnd_cost_cd"	, stnd_cost_cd[k]        );
                        	param.put("dhir_amt"		, dhir_amt[i]            );
                        	param.put("own_vsl_rmk"		, vos[i].getOwnVslRmk()  );
                        	param.put("vsl_clss_capa"	, vos[i].getVslClssCapa());
                            createList.add(param);
                        }
                    }
                }
            }               
            vo.setMultiCreateList(createList);		
			

			dbDao.multiOwnDailyHire(vo);
			//############################################################################
			
            GeneralEventResponse eventResponse = new GeneralEventResponse();
            return eventResponse; // "SUCCESS"
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }                
	}	

	/**
	 * Handling the inquiry event<br>
	 * NetworkCost, Handling the inquiry event<br>
	 * 
	 * @param SearchConditionVO searchVo
	 * @param NetworkCostCommonVO vo
	 * @return List<SearchDailyHireListVO>
	 * @exception EventException
	 */
	public List<SearchDailyHireListVO> searchDailyHireList(SearchConditionVO searchVo, NetworkCostCommonVO vo) throws EventException {
		try {
			String yrType = searchVo.getFYrtype();	
			String[] arrSearch = searchVo.getFYearweek().split("[-]");
			
			int rtnRow = 0;
			if(!yrType.equals("yrmon")){
	            HashMap<String, String> qParam = new HashMap<String, String>();
	            qParam.put("sls_yrmon", arrSearch[0]);
	            qParam.put("cost_wk"  , arrSearch[1]);
	            qParam.put("vsl_cd"   , Utils.iif(searchVo.getFVslCd() == null, "", searchVo.getFVslCd()));
	            vo.setIndirectColumnValues(qParam);	

				List<SearchDailyHire2MonthCountVO> retList = dbDao.searchDailyHire2MonthCount(vo);
				SearchDailyHire2MonthCountVO retVo = (SearchDailyHire2MonthCountVO)retList.get(0);
				rtnRow = Integer.parseInt(retVo.getCnt());
			}
			
            HashMap<String, String> qParam2 = new HashMap<String, String>();
            qParam2.put("sls_yrmon", arrSearch[0]);
            qParam2.put("cost_wk"  , arrSearch[1]);
            qParam2.put("vsl_cd"   , Utils.iif(searchVo.getFVslCd() == null, "", searchVo.getFVslCd()));
            vo.setIndirectColumnValues(qParam2);	
	        
            HashMap<String, Object> vParam = new HashMap<String, Object>();
            vParam.put("yrType", searchVo.getFYrtype());
            vParam.put("rtnRow", rtnRow        );	        
	        vo.setIndirectVariableValues(vParam);	
			
			return dbDao.searchDailyHireList(vo);
		} catch (DAOException ex) {
			log.error("err "+ex.toString(),ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
	}
		

	/**
	 * Handling multi event<br>
	 * ESM_COA_0042, Handling multi event<br>
	 * 
	 * @param SearchConditionVO searchVo
	 * @param NetworkCostCommonVO vo
	 * @param NetworkCostCommonVO[] vos
	 * @param String userId
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public EventResponse multiDailyHire(SearchConditionVO searchVo, NetworkCostCommonVO vo, NetworkCostCommonVO[] vos, String userId) throws EventException{
		try{
			List createList = new ArrayList();
			List updateList = new ArrayList();	 	            
			
			// 
			//----------------------------------------------------
            if(vos.length > 0){
                for(int i = 0 ; i < vos.length ; i++){
                    //query parameter
                    HashMap<String, String> param = new HashMap<String, String>();
                    param.put("user_id"   , userId);
                    param.put("cre_usr_id", userId);
                    param.put("upd_usr_id", userId);
                    if(vos[i].getSStatus().equals("I")) {
                    	param.put("cost_yrmon"   , vos[i].getSYM()        );
                    	param.put("vsl_cd"       , vos[i].getSVslCd()     );
                    	param.put("chrg_dhir_amt", vos[i].getSDlyHireAmt());
                        createList.add(param);
                    }
                    else if(vos[i].getSStatus().equals("U")) {
                    	param.put("chrg_dhir_amt", vos[i].getSDlyHireAmt());
                    	param.put("cost_yrmon"   , vos[i].getSYM()        );   
                    	param.put("vsl_cd"       , vos[i].getSVslCd()     );  
                        updateList.add(param);
                    }                        
                }
            }               
            vo.setMultiCreateList(createList);
            vo.setMultiUpdateList(updateList);			
			

			dbDao.multiDailyHire(vo);
			//############################################################################
            
            GeneralEventResponse eventResponse = new GeneralEventResponse();
            return eventResponse; // "SUCCESS"
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }                
	}	

    /**
	 * Handling the inquiry event<br>
	 * NetworkCost, Handling the inquiry event<br>
	 * 
	 * @param SearchConditionVO searchVo
	 * @param NetworkCostCommonVO vo
	 * @param SignOnUserAccount account
	 * @return List<SearchFixCostByVVDListVO>
	 * @exception EventException
	 */
    public List<SearchFixCostByVVDListVO> searchFixCostByVVDList(SearchConditionVO searchVo, NetworkCostCommonVO vo, SignOnUserAccount account) throws EventException {
    	
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

            if (searchVo.getFChkprd().equals("M")) {
                if (!searchVo.getFFmMon().equals("")) {
                    qParam.put("cost_yrmon_s", searchVo.getFYear()+searchVo.getFFmMon());
                    qParam.put("cost_yrmon_e", searchVo.getFYear()+searchVo.getFToMon());
                } else {
                	qParam.put("cost_yrmon", searchVo.getFYear());
                }

            } else if (searchVo.getFChkprd().equals("W")) {
            	qParam.put("sls_yrmon", searchVo.getFYear()+ "%");
                if (!searchVo.getFFmWk().equals("")) {
                	qParam.put("cost_wk_s", searchVo.getFFmWk());
                	qParam.put("cost_wk_e", searchVo.getFToWk());
                }
            }
            vo.setIndirectColumnValues(qParam);

            HashMap<String, Object> vParam = new HashMap<String, Object>();
            vParam.put("trd_cd"    , searchVo.getFSeltrade());
            vParam.put("rlane_cd"  , searchVo.getFSelrlane());
            vParam.put("ioc_cd"    , searchVo.getFSelioc  ());
            vParam.put("vsl_cd"    , searchVo.getFVslCd   ());
            vParam.put("skd_voy_no", searchVo.getFSkdVoyNo());
            vParam.put("dir_cd"    , searchVo.getFDirCd   ());
            vParam.put("priod"     , searchVo.getFChkprd  ());
            vParam.put("cost_yrmon", searchVo.getFFmMon   ());
            vParam.put("cost_wk"   , searchVo.getFFmWk    ());
            vo.setIndirectVariableValues(vParam);
        	
            return dbDao.searchFixCostByVVDList(vo);
        } catch (DAOException ex) {
            log.error("err "+ex.toString(),ex);
            throw new EventException(ex.getMessage(),ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(),ex);
        }
    }	

	/**
	 * Handling the inquiry event<br>
	 * NetworkCost, Initializing, Handling the inquiry event<br>
	 * 
	 * @param SearchConditionVO searchVo
	 * @param NetworkCostCommonVO vo
	 * @param SignOnUserAccount account
	 * @return List<SearchNWCreListVO>
	 * @exception EventException
	 */
    public List<SearchNWCreListVO> searchNWCreList(SearchConditionVO searchVo, NetworkCostCommonVO vo, SignOnUserAccount account) throws EventException {
        try {
            List<SearchNWCreListVO> list = null;
            if(vo.getEventName().equals("EsmCoa0110Event")){
                list = dbDao.searchNWCreList(vo);
            }
            return list;
        } catch (DAOException ex) {
            log.error("err "+ex.toString(),ex);
            throw new EventException(ex.getMessage(),ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(),ex);
        }
    }	

	/**
	 * Handling the inquiry event<br>
	 * NetworkCost results, Handling the inquiry event<br>
	 * 
	 * @param SearchConditionVO searchVo
	 * @param NetworkCostCommonVO vo
	 * @param SignOnUserAccount account
	 * @return List<SearchNWCreRStatusListVO>
	 * @exception EventException
	 */
    public List<SearchNWCreRStatusListVO> searchNWCreRStatusList(SearchConditionVO searchVo, NetworkCostCommonVO vo, SignOnUserAccount account) throws EventException {
        try {
            List<SearchNWCreRStatusListVO> list = null;
            if(vo.getEventName().equals("EsmCoa0110Event")){
                list = dbDao.searchNWCreRStatusList(vo);
            }
            return list;
        } catch (DAOException ex) {
            log.error("err "+ex.toString(),ex);
            throw new EventException(ex.getMessage(),ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(),ex);
        }
    }	

	/**
	 * Handling the inquiry event<br>
	 * NetworkCost Initializing, Handling the inquiry event<br>
	 * 
	 * @param SearchConditionVO searchVo
	 * @param NetworkCostCommonVO vo
	 * @param SignOnUserAccount account
	 * @return List<SearchSltChtrCreListVO>
	 * @exception EventException
	 */
    public List<SearchSltChtrCreListVO> searchSltChtrCreList(SearchConditionVO searchVo, NetworkCostCommonVO vo, SignOnUserAccount account) throws EventException {
        try {
            List<SearchSltChtrCreListVO> list = null;
            if(vo.getEventName().equals("EsmCoa0110Event")){
                list = dbDao.searchSltChtrCreList(vo);
            }
            return list;
        } catch (DAOException ex) {
            log.error("err "+ex.toString(),ex);
            throw new EventException(ex.getMessage(),ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(),ex);
        }
    }	

	/**
	 * Handling the inquiry event<br>
	 * NetworkCost results, Handling the inquiry event<br>
	 * 
	 * @param SearchConditionVO searchVo
	 * @param NetworkCostCommonVO vo
	 * @param SignOnUserAccount account
	 * @return List<SearchSltChtrCreRStatusListVO>
	 * @exception EventException
	 */
    public List<SearchSltChtrCreRStatusListVO> searchSltChtrCreRStatusList(SearchConditionVO searchVo, NetworkCostCommonVO vo, SignOnUserAccount account) throws EventException {
        try {
            List<SearchSltChtrCreRStatusListVO> list = null;
            if(vo.getEventName().equals("EsmCoa0110Event")){
                list = dbDao.searchSltChtrCreRStatusList(vo);
            }
            return list;
        } catch (DAOException ex) {
            log.error("err "+ex.toString(),ex);
            throw new EventException(ex.getMessage(),ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(),ex);
        }
    }	

	/**
	 * Window : Network Cost by VVD <br>
	 * Path : Sales & Marketing > Cost Assignment > Estimated PFMC-PA > Create Network Cost  <br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @param CoaNtwkCostCreVO[] coaNtwkCostCreVOs
	 * @param SignOnUserAccount account
	 * @return EventResponse
	 * @exception EventException
	 */
    public EventResponse createNWCreForVVD(SearchConditionVO searchConditionVO, CoaNtwkCostCreVO[] coaNtwkCostCreVOs, SignOnUserAccount account) throws EventException{
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
		String inMssChkFlg 	= "";
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
			

			if ( inFmWk.equals(inToWk) ){
				inMssChkFlg = "N";
				
				List<CoaNtwkCostCreVO> createList = new ArrayList<CoaNtwkCostCreVO>();

	            // COA_NTWK_COST_CRE table Setting
	            //----------------------------------------------------

	            if(coaNtwkCostCreVOs.length > 0){
	                for(int i = 0 ; i < coaNtwkCostCreVOs.length ; i++){
	                	coaNtwkCostCreVOs[i].setCreUsrId(inUserId);
	                	coaNtwkCostCreVOs[i].setUpdUsrId(inUserId);
	                	coaNtwkCostCreVOs[i].setCreSlctFlg(Utils.change10ToYN(coaNtwkCostCreVOs[i].getCreSlctFlg()));

	                    createList.add(coaNtwkCostCreVOs[i]);
	                    //if(vos[i].getIbflag().equals("I")) {
	                    //    createList.add(param);
	                    //}
	                }
	            }		            


	            dbDao.multiNWCreForVVD(createList);
			}else{	// muli weeks
				inMssChkFlg = "Y";
			}
			

			//rtnResult = dbDaoNtAll.createNtwkCostALL(pYear, fMon, tMon, fWeek, tWeek, chkPrd, "3", "N", mss_chk_flg, trd_cd, rlane_cd, ioc_cd,
			//		vsl_cd, skd_voy_no, dir_cd, null, pUserId);
			
			ProcedureParamVO procedureParamVO = new ProcedureParamVO();
			procedureParamVO.setInYr		(inYr);
			procedureParamVO.setInFmMon		(inFmMon);
			procedureParamVO.setInToMon		(inToMon);
			procedureParamVO.setInFmWk		(inFmWk);
			procedureParamVO.setInToWk		(inToWk);
			procedureParamVO.setInMonOrWk	(inMonOrWk);
			procedureParamVO.setInFmStep	("3");
			procedureParamVO.setInAllFlg	("N");
			procedureParamVO.setInInd		("");
			procedureParamVO.setInMssChkFlg	(inMssChkFlg);
			procedureParamVO.setInTrdCd		(inTrdCd);
			procedureParamVO.setInRlaneCd	(inRlaneCd);
			procedureParamVO.setInIocCd		(inIocCd);
			procedureParamVO.setInVslCd		(inVslCd);
			procedureParamVO.setInSkdVoyNo	(inSkdVoyNo);
			procedureParamVO.setInDirCd		(inDirCd);
			procedureParamVO.setInStndCostCd(null);
			procedureParamVO.setInUserId	(inUserId);
			procedureParamVO.setInLogLvl	("9");
			
			ProcedureParamVO resultVO = new ProcedureParamVO();
			resultVO = dbDaoNtAll.createNtwkCostALL(procedureParamVO);
            
            if(resultVO != null){
    			
    			out_err_cd = resultVO.getOutErrCd();
    			out_err_msg = resultVO.getOutErrMsg();
                log.debug("==========================================================================");
                log.debug("createNWCreForVVD Result Error Code: " + out_err_cd);
                log.debug("createNWCreForVVD Result Error Message: " + out_err_msg);
                log.debug("==========================================================================");

//                String[] errMessage = {out_err_msg,out_err_cd};
//                if(!out_err_cd.trim().equals("")){
//                	if(!out_err_cd.equals("00000")){
//                		throw new DAOException(new ErrorHandler("COA00025",errMessage).getMessage());
//                	}
//                }
                if(out_err_cd.trim().equals("00000")){
                	out_err_cd = "00000";
                	out_err_msg = "Create Success!!";  	
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

	/**
	 * Creation event handling<br>
	 * NetworkCost, Creation event handling<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @param CoaSltChtrInfoVO[] coaSltChtrInfoVOs
	 * @param SignOnUserAccount account
	 * @return EventResponse
	 * @exception EventException
	 */
    public EventResponse createSltChtrCre(SearchConditionVO searchConditionVO, CoaSltChtrInfoVO[] coaSltChtrInfoVOs, SignOnUserAccount account) throws EventException{
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
		String inMssChkFlg 	= "";
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
            
			// one week
			if ( inFmWk.equals(inToWk) ){
				inMssChkFlg = "N";

	            //COA_SLT_CHTR_INFO table Setting
	            //----------------------------------------------------
				List<CoaSltChtrInfoVO> createList = new ArrayList<CoaSltChtrInfoVO>();
	            if(coaSltChtrInfoVOs.length > 0){
	                for(int i = 0 ; i < coaSltChtrInfoVOs.length ; i++){

	                	coaSltChtrInfoVOs[i].setCreSlctFlg(Utils.change10ToYN(coaSltChtrInfoVOs[i].getCreSlctFlg()));
	                	coaSltChtrInfoVOs[i].setCreUsrId(inUserId);
	                	coaSltChtrInfoVOs[i].setUpdUsrId(inUserId);
	                	
	                	createList.add(coaSltChtrInfoVOs[i]);
	                }
	            }
	            log.debug("createList.size() = "+createList.size());

	            
	            dbDao.multiSltChtrCre(createList);
			}else{	// multi weeks
				inMssChkFlg = "Y";
			}
			
			ProcedureParamVO procedureParamVO = new ProcedureParamVO();
			procedureParamVO.setInYr		(inYr);
			procedureParamVO.setInFmMon		(inFmMon);
			procedureParamVO.setInToMon		(inToMon);
			procedureParamVO.setInFmWk		(inFmWk);
			procedureParamVO.setInToWk		(inToWk);
			procedureParamVO.setInMonOrWk	(inMonOrWk);
			procedureParamVO.setInFmStep	("4");
			procedureParamVO.setInAllFlg	("N");
			procedureParamVO.setInInd		("");
			procedureParamVO.setInMssChkFlg	(inMssChkFlg);
			procedureParamVO.setInTrdCd		(inTrdCd);
			procedureParamVO.setInRlaneCd	(inRlaneCd);
			procedureParamVO.setInIocCd		(inIocCd);
			procedureParamVO.setInVslCd		(inVslCd);
			procedureParamVO.setInSkdVoyNo	(inSkdVoyNo);
			procedureParamVO.setInDirCd		(inDirCd);
			procedureParamVO.setInStndCostCd(null);
			procedureParamVO.setInUserId	(inUserId);
			procedureParamVO.setInLogLvl	("9");
			
			ProcedureParamVO resultVO = new ProcedureParamVO();
			resultVO = dbDaoNtAll.createNtwkCostALL(procedureParamVO);
            
            if(resultVO != null){
    			
    			out_err_cd = resultVO.getOutErrCd();
    			out_err_msg = resultVO.getOutErrMsg();
                log.debug("==========================================================================");
                log.debug("createSltChtrCre Result :: " + out_err_cd);
                log.debug("createSltChtrCre Result :: " + out_err_msg);
                log.debug("==========================================================================");
	            
                if(out_err_cd.trim().equals("0000")){
                	out_err_cd = "00000";
                	out_err_msg = "Create Success!!";  	
                }

                eventResponse.setETCData("err_cd", out_err_cd);
                eventResponse.setETCData("err_msg", out_err_msg);
            }
            
            return eventResponse; // "SUCCESS"
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }
    }	

	/**
	 * Handling the inquiry event<br>
	 * NetworkCost, Handling the inquiry event<br>
	 * 
	 * @param SearchConditionVO searchVo
	 * @param NetworkCostCommonVO vo
	 * @param SignOnUserAccount account
	 * @return List<SearchMissingStatusListVO>
	 * @exception EventException
	 */
    public List<SearchMissingStatusListVO> searchMissingStatusList(SearchConditionVO searchVo, NetworkCostCommonVO vo, SignOnUserAccount account) throws EventException {
        try {
            List<SearchMissingStatusListVO> list = null;
            if(vo.getEventName().equals("EsmCoa0114Event")){

            	HashMap<String, String> qParam = new HashMap<String, String>();
            	qParam.put("prc_nm", searchVo.getFStrprcnm());
            	log.debug("@@@@@@@@@@@@@@@@@@@getFChkBsazrflg="+searchVo.getFChkBsazrflg());
            	if (searchVo.getFChkBsazrflg() != null) {
            		qParam.put("bsa_zr_flg", searchVo.getFChkBsazrflg());
            	}
            	if(searchVo.getFStrchkprd().equals("W")) {
            		qParam.put("year", searchVo.getFStryear());
            		qParam.put("fm_week", searchVo.getFStrfmweek());
            		qParam.put("to_week", searchVo.getFStrtoweek());
            	}
            	else{
            		qParam.put("year", searchVo.getFStryear());
            		qParam.put("fm_month", searchVo.getFStrfmmonth());
            		qParam.put("to_month", searchVo.getFStrtomonth());
            	}
            	if (!searchVo.getFStrtrade().equals("")) {
            		qParam.put("trd_cd", searchVo.getFStrtrade());
            	}
            	
            	if (!searchVo.getFStrlane().equals("")) {
            		qParam.put("rlane_cd", searchVo.getFStrlane());
            	}
            	
            	if (!searchVo.getFStrvessel().equals("")) {
            		qParam.put("vsl_cd", searchVo.getFStrvessel());
            	}
            	
            	if (!searchVo.getFStrvoyage().equals("")) {
            		qParam.put("skd_voy_no", searchVo.getFStrvoyage());
            	}
            	
            	if (!searchVo.getFStrdir().equals("")) {
            		qParam.put("dir_cd", searchVo.getFStrdir());
            	}

            	if (!searchVo.getFCobcost().equals("")) {
            		qParam.put("stnd_cost_cd", searchVo.getFCobcost());
            	}
            	vo.setIndirectColumnValues(qParam);

            	HashMap<String, Object> vParam = new HashMap<String, Object>();
            	vParam.put("cost_yrwk"		, searchVo.getFStrchkprd());
            	vParam.put("bsa_zr_flg"		, searchVo.getFChkBsazrflg());
            	vParam.put("trd_cd"			, searchVo.getFStrtrade());
            	vParam.put("rlane_cd"		, searchVo.getFStrlane());
            	vParam.put("vsl_cd"			, searchVo.getFStrvessel());
            	vParam.put("skd_voy_no"		, searchVo.getFStrvoyage());
            	vParam.put("dir_cd"			, searchVo.getFStrdir());
            	vParam.put("stnd_cost_cd"	, searchVo.getFCobcost());
            	vo.setIndirectVariableValues(vParam);

                list = dbDao.searchMissingStatusList(vo);
            }
            return list;
        } catch (DAOException ex) {
            log.error("err "+ex.toString(),ex);
            throw new EventException(ex.getMessage(),ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(),ex);
        }
    }	
	  
	/**
	 * [Trunk IPC Internal Pricing unit cost] Inquiry<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @return List<CoaInterPrcUtCostVO>
	 * @exception EventException
	 */
	public List<CoaInterPrcUtCostVO> searchTrunkIPCPricing(SearchConditionVO searchConditionVO) throws EventException {
		try {
			return dbDao.searchTrunkIPCPricing(searchConditionVO.getFCostYrmon().replaceAll("-", ""));
		} catch(DAOException ex) { 
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}
	
	/**
	 * [Trunk IPC Internal Pricing] Insert/Update/Delete <br>
	 * 
	 * @param CoaInterPrcUtCostVO[] coaInterPrcUtCostVOs
	 * @param SignOnUserAccount account
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse multiTrunkIPCPricing(CoaInterPrcUtCostVO[] coaInterPrcUtCostVOs, SignOnUserAccount account) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<CoaInterPrcUtCostVO> insertVoList = new ArrayList<CoaInterPrcUtCostVO>();
			List<CoaInterPrcUtCostVO> updateVoList = new ArrayList<CoaInterPrcUtCostVO>();
			List<CoaInterPrcUtCostVO> deleteVoList = new ArrayList<CoaInterPrcUtCostVO>();
			for ( int i=0; i<coaInterPrcUtCostVOs .length; i++ ) {
				if ( coaInterPrcUtCostVOs[i].getIbflag().equals("I")){
					coaInterPrcUtCostVOs[i].setCreUsrId(account.getUsr_id());
					coaInterPrcUtCostVOs[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(coaInterPrcUtCostVOs[i]);
				} else if ( coaInterPrcUtCostVOs[i].getIbflag().equals("U")){
					coaInterPrcUtCostVOs[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(coaInterPrcUtCostVOs[i]);
				} else if ( coaInterPrcUtCostVOs[i].getIbflag().equals("D")){
					deleteVoList.add(coaInterPrcUtCostVOs[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addTrunkIPCPricing(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyTrunkIPCPricing(updateVoList);
			}
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return eventResponse;
	}
	/**
	 * [Re-Assignment by Bound(Internal Pricing)] Inquiry<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @return List<CoaInterPrcVvdExpnVO>
	 * @exception EventException
	 */
	public List<CoaInterPrcVvdExpnVO> searchFixCostByVVDInterPrcList(SearchConditionVO searchConditionVO) throws EventException {
		try {
			return dbDao.searchFixCostByVVDInterPrcList(searchConditionVO);
		} catch(DAOException ex) { 
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}

	/**
	 * [Re-Assignment by Bound(Internal Pricing)] Creation<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @param SignOnUserAccount account
	 * @return EventResponse
	 * @exception EventException
	 */
    public EventResponse createFixCostByVVDInterPrc(SearchConditionVO searchConditionVO, SignOnUserAccount account) throws EventException{
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
			procedureParamVO.setInFmStep    ("1");
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
			resultVO = dbDao.createFixCostByVVDInterPrc(procedureParamVO);
            
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
    
	/**
	 * DailyHire 단가를 생성한다.<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 * @SJH.20140728 ADD
	 */
	public String createDailyHire(SearchConditionVO searchConditionVO, SignOnUserAccount account) throws EventException {		
		HashMap<String, String> param = new HashMap<String, String>();	
		int rtn_rows=0;
		String cre_sts = "N";
		
		try {
			// 경리 환율을 Check 한다.
			rtn_rows = dbDao.checkExchangeRate(searchConditionVO.getFYearweek());
			
            if (rtn_rows == 0){
            	cre_sts = "X";
            	return cre_sts;
            }			
			//파라미터 세팅
			param.put("f_src_mon"		, searchConditionVO.getFYearweek());
			param.put("f_tar_mon"		, searchConditionVO.getFYearweek());
            param.put("user_id"   		, account.getUsr_id());

            //			 생성전에 table을 삭제 한다.
            dbDao.removeDailyHireIF(searchConditionVO.getFYearweek());
            dbDao.removeDailyHire(searchConditionVO.getFYearweek());
//			// I/F 한다
            dbDao.createDailyHireFromFMS(searchConditionVO,account);
//			// I/F값을 가지고 daily Hire 생성한다.
            dbDao.createDailyHireFromIFTable(searchConditionVO, account);
//			// Daily Hire Status값을 Update한다.
            dbDao.modifyDailyHireCreationStatus(param);

		} catch (DAOException de) {
    		log.error("err " + de.toString(), de);
    		throw new EventException(new ErrorHandler("COM12192",new String[]{}).getMessage(), de);
    	} catch (Exception de) {
    		log.error("err " + de.toString(), de);
    		throw new EventException(new ErrorHandler("COM12192",new String[]{}).getMessage(), de);
    	}

		return cre_sts;
	}
	
    
	/**
	 * Port Tariff Create 시 기존에 존재하는 항차를 삭제한다.<br>
	 * @param SearchPortTariffListVO[] listVos
	 * @exception EventException
	 */
	public void deletePortTariff(SearchPortTariffListVO[] listVos) throws EventException{
		try {
			List<SearchPortTariffListVO> deleteVoList = new ArrayList<SearchPortTariffListVO>();
			for ( int i=0; i<listVos .length; i++ ) {			   
			   deleteVoList.add(listVos[i]);				
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removePortTariff(deleteVoList);
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
	 * PSO에서 생성된 Port Tariff Data를 COA로 IF한다<br>
	 * @param SearchPortTariffListVO[] searchPortTariffListVOs
	 * @param String usr_id
	 * @return EventResponse
	 * @exception EventException
	 */
    public EventResponse createPortTariffFromPSO(SearchPortTariffListVO[] searchPortTariffListVOs, String usr_id) throws EventException{
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try{

    		List<SearchPortTariffListVO> insertVoList = new ArrayList<SearchPortTariffListVO>();
			
    		for ( int i=0; i< searchPortTariffListVOs .length; i++ ) {
				searchPortTariffListVOs[i].setUserId(usr_id);
				insertVoList.add(searchPortTariffListVOs[i]);
    		}
    		
			if ( insertVoList.size() > 0 ) {
				dbDao.createPortTariffFromPSO(insertVoList);
			}
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
    }
    
	/**
	 * 1. 기능 : Port Tariff 조회/변경 화면에 대한 조회 이벤트 처리(ESM_COA_0040)<p>
	 * 2. 처리개요 : <p>
	 *    - Port Tariff 조회/변경에 대한 리스트를 조회
	 * 3. 주의사항 : <p>
	 * ===================================<br>
	 * 4. 작성자/작성일 : 이석준/2011.07.06<br>
	 * ===================================<br>
	 * 5. 수정사항<p>
	 * 5.1 요구사항 ID :<p>
	 * ===================================<br>
	 * <p/>
	 *
	 * @param SearchConditionVO searchConditionVO
	 * @return List<SearchPortTariffDetailListVO>
	 * @exception EventException
	 */
	public List<SearchPortTariffDetailListVO> searchPortTariffDetailList(SearchConditionVO searchConditionVO) throws EventException {
		try {
			return dbDao.searchPortTariffDetailList(searchConditionVO);
		} catch (DAOException ex) {
			log.error("err "+ex.toString(),ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * 1. 기능 : Port Class별 Tariff 조회/변경 화면에 대한 멀티 이벤트 처리(ESM_COA_040)<p>
	 * 2. 처리개요 : <p>
	 *    - Port Class별 Tariff 조회/변경에 대한 리스트를 조회
	 * 3. 주의사항 : <p>
	 * ===================================<br>
	 * 4. 작성자/작성일 : Park eun ju /2006.11.16<br>
	 * ===================================<br>
	 * 5. 수정사항<p>
	 * 5.1 요구사항 ID :<p>
	 * - 수정자/수정일 :<p>
	 * - 수정사유/내역 :<p>
	 * ===================================<br>
	 * <p/>
	 *
	 * @param SearchConditionVO SearchConditionVO
	 * @param SearchPortTariffDetailListVO[] searchPortTariffDetailListVOs
	 * @param String userId
	 * @return EventResponse EventResponse
	 * @throws EventException
	 */
	public EventResponse multiPortTariffDetail(SearchConditionVO SearchConditionVO, SearchPortTariffDetailListVO[] searchPortTariffDetailListVOs, String userId) throws EventException{
		try{ 
			List<SearchPortTariffDetailListVO> updateList	= new ArrayList<SearchPortTariffDetailListVO>();

			boolean save_ind=true; // 화면에서 넘어온 데이터중 COA쪽 Data의 합이 0인 포트가 하나라고 있으면 SAVE 불가능
			//Double port_amt;
			//Double canal_amt;
            if(searchPortTariffDetailListVOs.length > 0){            	
                for(int i = 0 ; i < searchPortTariffDetailListVOs.length ; i++){
//                	port_amt = Double.parseDouble(JSPUtil.getNull(searchPortTariffDetailListVOs[i].getPortUsdAmt(), "0.0"));
//                	canal_amt = Double.parseDouble(JSPUtil.getNull(searchPortTariffDetailListVOs[i].getCnlUsdAmt(), "0.0"));
                	
//                	if ((port_amt + canal_amt) == 0.0){
//                		save_ind = false;
//                		break;
//                	}                	
                	searchPortTariffDetailListVOs[i].setCreUsrId(userId);
                	searchPortTariffDetailListVOs[i].setUpdUsrId(userId);                	
                    if(searchPortTariffDetailListVOs[i].getIbflag().equals("U"))
                        updateList.add(searchPortTariffDetailListVOs[i]);
                }
            }

            if( updateList.size() > 0 && save_ind) {
                dbDao.modifyPortTariffDetail(updateList);
            }
            
            GeneralEventResponse eventResponse = new GeneralEventResponse();
            return eventResponse; // "SUCCESS"
        }
		catch (Exception de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }
	}
	
	/**
	 * 1. Function : Tariff Inquiry/Update by Port Class, Handling multi event(ESM_COA_040)<p>
	 * 2. Overview : <p>
	 *    - Inquiry list (Tariff Inquiry/Update by Port Class) 
	 * 3. Caution : <p>
	 * ===================================<br>

	 * <p/>
	 * 
	 * @param SearchConditionVO SearchConditionVO
	 * @param SearchPortTariffListVO[] searchPortTariffListVOs
	 * @param String userId
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse multiPortTariff(SearchConditionVO SearchConditionVO, SearchPortTariffListVO[] searchPortTariffListVOs, String userId) throws EventException{
		try{
//			List<SearchPortTariffListVO> createList	= new ArrayList<SearchPortTariffListVO>();
			List<SearchPortTariffListVO> updateList	= new ArrayList<SearchPortTariffListVO>();
//			List<SearchPortTariffListVO> deleteList	= new ArrayList<SearchPortTariffListVO>();

            if(searchPortTariffListVOs.length > 0){
                for(int i = 0 ; i < searchPortTariffListVOs.length ; i++){
                	 
                	if ("N".equals(searchPortTariffListVOs[i].getCostSts())) continue; //COA에도 없고, PSO에도 create되지 않은 경우는 저장하지 않는다.
                	if ("0".equals(searchPortTariffListVOs[i].getChkFlag())) continue; //CHECK하지 않은것도 그냥 SKIP
                	if ("0".equals(searchPortTariffListVOs[i].getPsoCostPsoTtlAmt())) continue; //PSO에
                	
//                    if(searchPortTariffListVOs[i].getIbflag().equals("I"))
//                        createList.add(searchPortTariffListVOs[i]);
                	searchPortTariffListVOs[i].setUserId(userId);
                     if(searchPortTariffListVOs[i].getIbflag().equals("U"))
                        updateList.add(searchPortTariffListVOs[i]);
//                    else if(searchPortTariffListVOs[i].getIbflag().equals("D"))
//                    	deleteList.add(searchPortTariffListVOs[i]);
                }
            }

//            if( createList.size() > 0 )
//            	dbDao.addPortTariff(createList);
            if( updateList.size() > 0 )
                dbDao.modifyPortTariff(updateList);
//            if( deleteList.size() > 0 )
//            	dbDao.deletePortTariff(deleteList);

            GeneralEventResponse eventResponse = new GeneralEventResponse();
            return eventResponse; // "SUCCESS"
        }
		catch (Exception de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }
	}
	
	/**
	 * PSO에서 생성된 Port Tariff Data를 COA로 IF한다<br>
	 * @param SearchPortTariffListVO[] searchPortTariffListVOs
	 * @param String usr_id
	 * @return EventResponse
	 * @exception EventException
	 * @author SJH.20150206.ADD
	 */
    public EventResponse copyPortTariff(SearchPortTariffListVO[] searchPortTariffListVOs, String usr_id) throws EventException{
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try{
    		List<SearchPortTariffListVO> insertVoList = new ArrayList<SearchPortTariffListVO>();
			
    		for ( int i=0; i< searchPortTariffListVOs .length; i++ ) {
    			
            	if (!"E".equals(searchPortTariffListVOs[i].getCostSts())) continue; //COA에도 없고, PSO가 수행된경우만
            	if ("0".equals(searchPortTariffListVOs[i].getChkFlag())) continue; 	//CHECK하지 않은것도 그냥 SKIP
            	
				searchPortTariffListVOs[i].setUserId(usr_id);
				insertVoList.add(searchPortTariffListVOs[i]);
    		}
    		
			if ( insertVoList.size() > 0 ) {
				dbDao.createPortTariffFromPSO(insertVoList);
			}
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
    }    
	
	/**
	 * [Re-Assignment by VVD (Slot Internal Pricing)] Inquiry<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @return CommonCoaRsVO
	 * @exception EventException
	 * @author SJH.20141028
	 */
	public CommonCoaRsVO searchFixCostByVVDSltInterPrcList(SearchConditionVO searchConditionVO) throws EventException {
		try {
			CommonCoaRsVO retVo = new CommonCoaRsVO();
			
			retVo = dbDao.searchFixCostByVVDSltInterPrcList(searchConditionVO, retVo);
            return retVo;
		} catch(DAOException ex) { 
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}

	/**
	 * [Re-Assignment by VVD (Slot Internal Pricing)] Creation<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @param SignOnUserAccount account
	 * @return EventResponse
	 * @exception EventException
	 * @author SJH.20141028
	 */
    public EventResponse createFixCostByVVDSltInterPrc(SearchConditionVO searchConditionVO, SignOnUserAccount account) throws EventException{
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
    		//SJH.20141121.MOD
    		inTrdCd 	= searchConditionVO.getFSeltrade();
    		inRlaneCd 	= searchConditionVO.getFSelrlane();
    		inVslCd 	= searchConditionVO.getFVslCd();
    		inSkdVoyNo 	= searchConditionVO.getFSkdVoyNo();
    		inDirCd 	= searchConditionVO.getFDirCd();
    		inUserId	= account.getUsr_id();					//SJH.20141124.ADD

			ProcedureParamVO procedureParamVO = new ProcedureParamVO(); 
			procedureParamVO.setInFmStep    ("4");
			procedureParamVO.setInYr		(inYr);
			procedureParamVO.setInFmMon		(inFmMon);
			procedureParamVO.setInToMon		(inToMon);
			procedureParamVO.setInFmWk		(inFmWk);
			procedureParamVO.setInToWk		(inToWk);
			procedureParamVO.setInMonOrWk	(inMonOrWk);
			//procedureParamVO.setInStndCostCd("54600001");
			procedureParamVO.setInStndCostCd("54600002"); 		//SJH.20141104.MOD
			procedureParamVO.setInTrdCd		(inTrdCd);
			procedureParamVO.setInRlaneCd	(inRlaneCd);
			procedureParamVO.setInIocCd		(inIocCd);
			procedureParamVO.setInVslCd		(inVslCd);
			procedureParamVO.setInSkdVoyNo	(inSkdVoyNo);
			procedureParamVO.setInDirCd		(inDirCd);
			procedureParamVO.setInStndCostCd(null);
			procedureParamVO.setInUserId	(inUserId);
			
			ProcedureParamVO resultVO = new ProcedureParamVO();
			log.debug("==================procedureParamVO : "+procedureParamVO);
			resultVO = dbDao.createFixCostByVVDSltInterPrc(procedureParamVO);
            
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
    
	/**
	 * 조회 이벤트 처리<br>
	 * ESM_COA_4012 화면 대한 조회 이벤트 처리<br>
	 * 
	 * @param SearchConditionVO searchVO
	 * @return CommonCoaRsVO
	 * @exception EventException
	 * @author 20151001.ADD
	 */
    public CommonCoaRsVO searchPndlmSvcList(SearchConditionVO searchVO) throws EventException {
        try {
        	CommonCoaRsVO retVo = new CommonCoaRsVO();
			            
			retVo = dbDao.searchPndlmSvcList(searchVO);
            return retVo;
        } catch (DAOException ex) {
            log.error("err "+ex.toString(),ex);
            throw new EventException(ex.getMessage(),ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(),ex);
        }
    }  
    
	/**
	 * 조회 이벤트 처리<br>
	 * ESM_COA_4012 화면 대한 조회 이벤트 처리<br>
	 * 
	 * @param SearchConditionVO searchVO
	 * @return CommonCoaRsVO
	 * @exception EventException
	 * @author 20151001.ADD
	 */
	public CommonCoaRsVO searchPndlmSvcDtlList(SearchConditionVO searchVO) throws EventException {
		try {
			StringBuffer header = new StringBuffer();
			int cnt = 1;
			DBRowSet dbRowset = dbDao.searchPndlmSvcDtlHeaderList(searchVO);
    		while(dbRowset.next()){
    			header.append(dbRowset.getString("rlane_cd"));
    			if(cnt != dbRowset.getRowCount()) header.append("|");
    			cnt++;
			}
        	CommonCoaRsVO returnVo = dbDao.searchPndlmSvcDtlList(searchVO, header.toString());
        	returnVo.setHeader(header.toString());
			return returnVo;
		} catch (DAOException ex) {
			log.error("err "+ex.toString(),ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			log.error("err "+ex.toString(),ex);
			throw new EventException(ex.getMessage(),ex);
		}		
	}
    
	/**
	 * 조회 이벤트 처리<br>
	 * ESM_COA_4012화면 대한 멀티 이벤트 처리<br>
     * 
     * @param PndlmSvcVO[] pndlmSvcVO
     * @param SignOnUserAccount account 
     * @exception EventException
     * @return String
     * @author 20151001.ADD
     */
    public String multiPndlmSvcInfo(PndlmSvcVO[] pndlmSvcVO, SignOnUserAccount account) throws EventException{
		try {
			String result = "S";
			int checkCnt = 0;
			int batCnt[] = null;
			List<PndlmSvcVO> updateVoList = new ArrayList<PndlmSvcVO>();
			List<PndlmSvcVO> deleteVoList = new ArrayList<PndlmSvcVO>();
			
			for ( int i=0; i<pndlmSvcVO .length; i++ ) {				
				if ( pndlmSvcVO[i].getIbflag().equals("I")){
					 pndlmSvcVO[i].setCreUsrId(account.getUsr_id());
					 pndlmSvcVO[i].setUpdUsrId(account.getUsr_id());	
					 checkCnt = dbDao.checkPndlmSvcInt(pndlmSvcVO[i]);		//Dup Check
					 if(checkCnt == 0){						 
						 updateVoList.add(pndlmSvcVO[i]);
					 }else{
						result = "Dup";
						break;
					 }
				} else if ( pndlmSvcVO[i].getIbflag().equals("U")){
					pndlmSvcVO[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(pndlmSvcVO[i]);
				} else if ( pndlmSvcVO[i].getIbflag().equals("D")){
					pndlmSvcVO[i].setUpdUsrId(account.getUsr_id());	
					deleteVoList.add(pndlmSvcVO[i]);
				}
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.multiPndlmSvc(updateVoList);
				
				//EFF_TO_DT 일괄 update
				batCnt = dbDao.batchUpPndlmSvc(updateVoList);
				log.debug("######## batch update cnt : "+batCnt.length);
			}

			if ( deleteVoList.size() > 0 ) {
				dbDao.removePndlmDtlSvc(deleteVoList);
				dbDao.removePndlmSvc(deleteVoList);
			}
			
			return result;
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}       
    
	/**
	 * 조회 이벤트 처리<br>
	 * ESM_COA_4012화면 대한 멀티 이벤트 처리<br>
     * 
     * @param SearchConditionVO searchVO
     * @param CommonCoaRsVO commonCoaRsVO
     * @param PndlmSvcVO[] pndlmSvcVO
     * @param SignOnUserAccount account 
     * @exception EventException
     * @author 20151001.ADD
     */
    public void multiPndlmSvcDtlInfo(SearchConditionVO searchVO, CommonCoaRsVO commonCoaRsVO, PndlmSvcVO[] pndlmSvcVO, SignOnUserAccount account) throws EventException{    	
    	String[] hdCdArr = null;    	
		try {
			List<PndlmSvcVO> updateVoList = new ArrayList<PndlmSvcVO>();
			List<PndlmSvcVO> deleteVoList = new ArrayList<PndlmSvcVO>();
			hdCdArr = (searchVO.getFHeader()).split("[|]");
			
			if(pndlmSvcVO.length > 0){
				for ( int i=0; i<pndlmSvcVO .length; i++ ) {
					if ( pndlmSvcVO[i].getIbflag().equals("I")||pndlmSvcVO[i].getIbflag().equals("U")){
						for(int k = 0 ; k < hdCdArr.length ; k++){	
							PndlmSvcVO vo = new PndlmSvcVO();
							vo.setSlanCd(pndlmSvcVO[i].getSlanCd());
							vo.setDirCd(pndlmSvcVO[i].getDirCd());
							vo.setRlaneCd(hdCdArr[k]);
							vo.setYdCd(pndlmSvcVO[i].getYdCd());
							vo.setPndlmRto(commonCoaRsVO.getHashAttribute(hdCdArr[k].toLowerCase())[i]);
							vo.setEffFmDt(pndlmSvcVO[i].getEffFmDt());
							vo.setEffToDt(pndlmSvcVO[i].getEffToDt());
							vo.setCreUsrId(account.getUsr_id());
							vo.setUpdUsrId(account.getUsr_id());
							updateVoList.add(vo);                  		
	                 	}
					} else if ( pndlmSvcVO[i].getIbflag().equals("D")){
						pndlmSvcVO[i].setUpdUsrId(account.getUsr_id());	
						deleteVoList.add(pndlmSvcVO[i]);
					}
				}				
			}			
			if ( updateVoList.size() > 0 ) {
				dbDao.multiPndlmDtlSvc(updateVoList);
			}
			if ( deleteVoList.size() > 0 ) {
				dbDao.removePndlmDtlSvc(deleteVoList);
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
	 * 조회 이벤트 처리<br>
	 * ESM_COA_4012화면 대한 멀티 이벤트 처리<br>
     * 
     * @param SearchConditionVO searchVO
     * @param SignOnUserAccount account
     * @exception EventException
     * @author 20151001.ADD
     */
    public void createPndlmSvcDtlInfo(SearchConditionVO searchVO, SignOnUserAccount account) throws EventException{
		try {
			PndlmSvcVO creVo = new PndlmSvcVO();		
			PndlmSvcVO delVo = new PndlmSvcVO();
			List<PndlmSvcVO> deleteVoList = new ArrayList<PndlmSvcVO>();
			
			if ( searchVO.getFSelslane().length() > 0){
				delVo.setSlanCd(searchVO.getFSelslane());
				delVo.setDirCd(searchVO.getFSeldir());
				delVo.setEffFmDt(searchVO.getFFrom());    			
				deleteVoList.add(delVo);
				
				dbDao.removePndlmDtlSvc(deleteVoList);
			}
			
			DBRowSet dbRowset = dbDao.searchPndlmSvcDtlHeaderList(searchVO);
			
			creVo.setRsCnt(Integer.toString(dbRowset.getRowCount()));				//20151210.ADD : 총건수
    		while(dbRowset.next()){
    			creVo.setSlanCd(searchVO.getFSelslane());
    			creVo.setDirCd(searchVO.getFSeldir());        								
    			creVo.setRlaneCd(dbRowset.getString("rlane_cd"));
    			creVo.setEffFmDt(searchVO.getFFrom());  
    			creVo.setEffToDt(searchVO.getFTo());  
    			creVo.setCreUsrId(account.getUsr_id());
    			creVo.setUpdUsrId(account.getUsr_id());	
    			//20151210.ADD : 마지막여부
    			if(dbRowset.isLast()) 
    				creVo.setLastYn("Y");
    			else 
    				creVo.setLastYn("N");    			
    			dbDao.createPndlmDtlSvc(creVo);
			}		
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}    
    
}