/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : WeeklyPFMCBCImpl.java
*@FileTitle : Weekly PFMC BC Impl
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
* =========================================================
* History
=========================================================*/
package com.clt.apps.opus.esm.coa.weeklypfmc.weeklycm.basic;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import com.clt.apps.opus.esm.coa.common.Utils;
import com.clt.apps.opus.esm.coa.common.vo.GetCodeSelectVO;
import com.clt.apps.opus.esm.coa.common.vo.ProcedureParamVO;
import com.clt.apps.opus.esm.coa.common.vo.SearchConditionVO;
import com.clt.apps.opus.esm.coa.weeklypfmc.weeklycm.integration.WeeklyCMDBDAO;
import com.clt.apps.opus.esm.coa.weeklypfmc.weeklycm.vo.BsaProcedureParamVO;
import com.clt.apps.opus.esm.coa.weeklypfmc.weeklycm.vo.IsLaneRgstVO;
import com.clt.apps.opus.esm.coa.weeklypfmc.weeklycm.vo.SearchVVDCheckListVO;
import com.clt.apps.opus.esm.coa.weeklypfmc.weeklycm.vo.SearchVVDChkWithARListVO;
import com.clt.apps.opus.esm.coa.weeklypfmc.weeklycm.vo.SearchVslRgstCountVO;
import com.clt.apps.opus.esm.coa.weeklypfmc.weeklycm.vo.SearchWeeklyTargetVVDListVO;
import com.clt.apps.opus.esm.coa.weeklypfmc.weeklycm.vo.SearchYrWkDuVO;
import com.clt.apps.opus.esm.coa.weeklypfmc.weeklycm.vo.WeeklyCMCommonVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.CoaMonVvdVO;



/**
 * COA Business Logic Basic Commanimport java.util.List;
 * <br>
 *
 * @author
 * @see WeeklyPFMCBC reference the each DAO class 
 * @since J2EE 1.4
 */
public class WeeklyCMBCImpl extends BasicCommandSupport implements WeeklyCMBC {

	// Database Access Object
	private transient WeeklyCMDBDAO dbDao = null;
//	private transient BSACreateBC batchBc = null;

	/**
	 * WeeklyPFMCBCImpl Object creation<br>
	 * WeeklyPFMCDBDAO Creation<br>
	 */
	public WeeklyCMBCImpl(){
		dbDao = new WeeklyCMDBDAO();
	}



	/**
	 * <br>
	 * Function : Inquiry a week, trade, lane, bound matching list in the target VVD (ESM_COA_029)<p>
     * Overview : Inquiry a weekly target VVD
	 * ESM_COA_0142 Inquiry
	 * @param SearchVVDCheckListVO searchVVDCheckListVO
	 * @param SearchConditionVO searchConditionVO
	 * @return List<SearchVVDCheckListVO>
	 * @exception EventException
	 */
	public List<SearchVVDCheckListVO> searchVVDCheckList(SearchVVDCheckListVO searchVVDCheckListVO
			                                            ,SearchConditionVO searchConditionVO) throws EventException {
		try {
			return dbDao.searchVVDCheckList(searchVVDCheckListVO, searchConditionVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}

	}

	/**
	 * <br>
	 * Function : In case of update weekly, confirm weekly target flag (ESM_COA_029)<p>
	 * Overview : weekly target VVD management , Inquiry list<p>
	 * ESM_COA_0142 Update
	 * @param CoaMonVvdVO[] coaMonVvdVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyVVDCheck(CoaMonVvdVO[] coaMonVvdVO, SignOnUserAccount account) throws EventException{
		try {
			List<CoaMonVvdVO> updateVoList = new ArrayList<CoaMonVvdVO>();
			for ( int i=0; i<coaMonVvdVO .length; i++ ) {
			   if ( coaMonVvdVO[i].getIbflag().equals("U")){
					coaMonVvdVO[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(coaMonVvdVO[i]);
				}
			}
			if ( updateVoList.size() > 0 ) {
				dbDao.modifymodifyVVDCheckS(updateVoList);
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
	 * 1. Function : WeeklyCM weekly target VVD management, Handling the inquiry event(ESM_COA_029)<p>
	 * 2. Overview : <p>
	 *    - weekly target VVD management, Inquiry list
	 * 3. Caution : <p>
	 * ===================================<br>

	 * <p/>
	 *
	 * @param SearchConditionVO searchConditionVO
	 * @return List<SearchWeeklyTargetVVDListVO>
	 * @exception EventException
	 */
    public List<SearchWeeklyTargetVVDListVO> searchWeeklyTargetVVDList(SearchConditionVO searchConditionVO) throws EventException {
        try {
            String fChkdel       = searchConditionVO.getFChkdel()==null? "":searchConditionVO.getFChkdel();
        	searchConditionVO.setFChkdel(fChkdel);
            return dbDao.searchWeeklyTargetVVDList(searchConditionVO);
        } catch (DAOException ex) {
            log.error("err "+ex.toString(),ex);
            throw new EventException(ex.getMessage(),ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(),ex);
        }
    }

    /**
     * 1. Function : WeeklyCM weekly target VVD management, Handling multi event(ESM_COA_029)<p>
     * 2. Overview : <p>
     *    - weekly target VVD management, multi handling
     * 3. Caution : <p>
     * ===================================<br>
     * <p/>
     *
     * @param SearchConditionVO searchVo
     * @param WeeklyCMCommonVO vo
     * @param WeeklyCMCommonVO[] vos
     * @param CoaMonVvdVO[] tVos
     * @param SignOnUserAccount account
     * @return EventResponse
     * @exception EventException
     */
	public EventResponse multiWeeklyTargetVVD(SearchConditionVO searchVo, WeeklyCMCommonVO vo, WeeklyCMCommonVO[] vos, CoaMonVvdVO[] tVos, SignOnUserAccount account) throws EventException{
        try{
        	boolean insert    = false;
        	boolean checkLane = false;
        	boolean result    = false;
			long startTime = Calendar.getInstance().getTimeInMillis();
			log.debug("==============================================================================");
			log.debug(" multiWeeklyTargetVVD start : 0");
			log.debug("==============================================================================");

			for(int i=0; i<tVos.length; i++){
				if(tVos[i].getIbflag().equals("I")){
					insert = true;
				}
			}
			if(insert){

				StringBuffer keysBuff = new StringBuffer();
				for(int i=0; i<vos.length; i++){
					if(vos[i].getIbflag().equals("I")){
						if(i != 0){
							keysBuff.append("[|]");
						}
						keysBuff.append(vos[i].getRlaneCd() + vos[i].getDirCd() + vos[i].getTrdCd() + vos[i].getIocCd());
					}
				}
	            vo.setIteratorList(vo.seperationParameter(keysBuff.toString(), "[|]"));

	            HashMap<String, Object> selectVParam = new HashMap<String, Object>();
	            selectVParam.put("keyList", vo.getIteratorList()==null?"":vo.getIteratorList().iterator());
	            vo.setIndirectVariableValues(selectVParam);

				List<IsLaneRgstVO> laneRgstList = dbDao.isLaneRgst(vo);
				if(laneRgstList.size() > 0){
					if(Integer.parseInt(((IsLaneRgstVO)laneRgstList.get(0)).getCnt()) == tVos.length){
						checkLane = true;
					} else{
						checkLane = false;
					}
				}

				log.debug("\n checkLane : " + checkLane);
				if(!checkLane){
					throw new DAOException(new ErrorHandler("COA00027").getMessage());
				}
			}

            List createList  = new ArrayList();
            List updateList  = new ArrayList();
            List updateList2 = new ArrayList();
            List updateList3 = new ArrayList();

            //
            //----------------------------------------------------
            if(tVos.length > 0){
                for(int i = 0 ; i < tVos.length ; i++){

                    //query parameter
                    HashMap<String, String> param1 = tVos[i].getColumnValues();
                    param1.put("cre_usr_id", account.getUsr_id());
                    param1.put("upd_usr_id", account.getUsr_id());

                    HashMap<String, String> param2 = tVos[i].getColumnValues();
                    param2.put("cre_usr_id", account.getUsr_id());
                    param2.put("upd_usr_id", account.getUsr_id());

                    HashMap<String, String> param3 = tVos[i].getColumnValues();
                    param3.put("cre_usr_id", account.getUsr_id());
                    param3.put("upd_usr_id", account.getUsr_id());

                    HashMap<String, String> param4 = tVos[i].getColumnValues();
                    param4.put("cre_usr_id", account.getUsr_id());
                    param4.put("upd_usr_id", account.getUsr_id());


    				String wky_mnl = "";
    				String wky_tgt = "";
    				if(tVos[i].getWkyMnlFlg().equals("")) {
    					wky_mnl = "P";
    					wky_tgt = "Y";
    				} else if (!tVos[i].getWkyMnlFlg().equals("")) {
    					wky_mnl = "M";
    					wky_tgt = "Y";
    				}

    				if(tVos[i].getIbflag().equals("I")) {
                        String stWkyTgtFlg = "";
                        if(tVos[i].getWkyTgtFlg() != null){
                            if(tVos[i].getWkyTgtFlg().trim().equals("NO")){
                                stWkyTgtFlg = "N";
                            }else if(tVos[i].getWkyTgtFlg().trim().equals("YES")){
                                stWkyTgtFlg = "Y";
                            }
                        }
    					param1.put("trd_cd"				, tVos[i].getTrdCd()		);
    					param1.put("sub_trd_cd"		    , tVos[i].getSubTrdCd()     );
    					param1.put("rlane_cd"			, tVos[i].getRlaneCd()		);
    					param1.put("ioc_cd"				, tVos[i].getIocCd()		);
    					param1.put("vsl_cd"				, tVos[i].getVslCd()		);
    					param1.put("skd_voy_no"		  	, tVos[i].getSkdVoyNo()		);
    					param1.put("dir_cd"				, tVos[i].getDirCd()		);
    					param1.put("cost_yrmon"			, tVos[i].getCostYrmon()	);
    					param1.put("sls_yrmon"			, tVos[i].getSlsYrmon()		);
    					param1.put("cost_wk"			, Utils.fillSpace(tVos[i].getCostWk(),2,"0","left"));
    					param1.put("slan_cd"			, tVos[i].getSlanCd()		);
    					param1.put("lst_lodg_port_cd"	, tVos[i].getLstLodgPortCd());
    					param1.put("wky_tgt_flg"		, stWkyTgtFlg           	); // tVos[i].getWkyTgtFlg()
    					param1.put("wky_mnl_flg"		, tVos[i].getWkyMnlFlg()	);
    					param1.put("bsa_zr_flg"			, Utils.change10ToYN(tVos[i].getBsaZrFlg()));
    					createList.add(param1);

                        param2.put("vsl_cd"     , tVos[i].getVslCd        ());
                        param2.put("skd_voy_no" , tVos[i].getSkdVoyNo     ());
                        param2.put("skd_dir_cd" , tVos[i].getDirCd        ());
                        param2.put("vsl_cd"     , tVos[i].getVslCd        ());
                        param2.put("skd_voy_no" , tVos[i].getSkdVoyNo     ());
                        param2.put("skd_dir_cd" , tVos[i].getDirCd        ());
                        param2.put("vps_port_cd", tVos[i].getLstLodgPortCd());
                        param2.put("trd_cd"     , tVos[i].getTrdCd        ());
                        param2.put("rlane_cd"   , tVos[i].getRlaneCd      ());
                        param2.put("ioc_cd"     , tVos[i].getIocCd        ());
                        param2.put("vsl_cd"     , tVos[i].getVslCd        ());
                        param2.put("skd_voy_no" , tVos[i].getSkdVoyNo     ());
                        param2.put("dir_cd"     , tVos[i].getDirCd        ());

    					updateList.add(param2);
    				}
    				else if(tVos[i].getIbflag().equals("U")) {
    					String stChkDel = searchVo.getFChkdel();

    					String stDelFlg = "";
    					if(stChkDel.equals("Y")){
    						if(Utils.change10ToYN(vos[i].getIbSel()).equals("N")){
    							stDelFlg = "N";
    						} else{
    							stDelFlg = "Y";
    						}
    					}
    					else{
    						if(Utils.change10ToYN(vos[i].getIbDel()).equals("N")){
    							stDelFlg = "N";
    						} else{
    							stDelFlg = "Y";
    						}
    					}

                        param3.put("cost_yrmon" , tVos[i].getCostYrmon());
                        param3.put("sls_yrmon"  , tVos[i].getSlsYrmon ());
                        param3.put("cost_wk"    , tVos[i].getCostWk   ());
                        param3.put("wky_tgt_flg", wky_tgt               );
                        param3.put("wky_mnl_flg", wky_mnl               );
                        param3.put("delt_flg"   , stDelFlg              ); //tVos[i].getDeltFlg  ()
                        param3.put("bsa_zr_flg" , Utils.change10ToYN(tVos[i].getBsaZrFlg()));

//                      if(tVos[i].getTrdCd().equals("AES") || tVos[i].getTrdCd().equals("IES")){
//                      param3.put("trd_cd1", "AES");
//                      param3.put("trd_cd2", "IES");
//                  	}
                        if(tVos[i].getTrdCd().equals("AES")){
                        	param3.put("trd_cd1", "AES");
                        	param3.put("trd_cd2", "IES");
                        	param3.put("trd_cd3", tVos[i].getTrdCd());
                        	param3.put("trd_cd4", tVos[i].getTrdCd());
                        } else if(tVos[i].getTrdCd().equals("TPS")){
                        	param3.put("trd_cd1", "TPS");
                        	param3.put("trd_cd2", "IMS");
                        	param3.put("trd_cd3", tVos[i].getTrdCd());
                        	param3.put("trd_cd4", tVos[i].getTrdCd());
                        } else if(tVos[i].getTrdCd().equals("EMS")){
                        	param3.put("trd_cd1", "EMS");
                        	param3.put("trd_cd2", "IMS");
                        	param3.put("trd_cd3", tVos[i].getTrdCd());
                        	param3.put("trd_cd4", tVos[i].getTrdCd());
                        } else if(tVos[i].getTrdCd().equals("TAS")){
                        	param3.put("trd_cd1", "TAS");
                        	param3.put("trd_cd2", "IES");
                        	param3.put("trd_cd3", "IMS");
                        	param3.put("trd_cd4", tVos[i].getTrdCd());
                        } else if(tVos[i].getTrdCd().equals("IES")){
                        	param3.put("trd_cd1", "TAS");
                        	param3.put("trd_cd2", "IES");
                        	param3.put("trd_cd3", "EMS");
                        	param3.put("trd_cd4", tVos[i].getTrdCd());
                        } else if(tVos[i].getTrdCd().equals("IMS")){
                        	param3.put("trd_cd1", "IMS");
                        	param3.put("trd_cd2", "IES");
                        	param3.put("trd_cd3", "EMS");
                        	param3.put("trd_cd4", "TAS");
                        } else{
                            param3.put("trd_cd1", tVos[i].getTrdCd());
                            param3.put("trd_cd2", tVos[i].getTrdCd());
                            param3.put("trd_cd3", tVos[i].getTrdCd());
                            param3.put("trd_cd4", tVos[i].getTrdCd());
                        }

                        param3.put("rlane_cd"   , tVos[i].getRlaneCd  ());
                        param3.put("vsl_cd"     , tVos[i].getVslCd    ());
                        param3.put("skd_voy_no" , tVos[i].getSkdVoyNo ());
                        param3.put("dir_cd"     , tVos[i].getDirCd    ());

    					updateList2.add(param3);
    				}
    				else if(tVos[i].getIbflag().equals("D")) {
    					param4.put("delt_flg"  , "Y"                  );
                        param4.put("trd_cd"    , tVos[i].getTrdCd   ());
                        param4.put("rlane_cd"  , tVos[i].getRlaneCd ());
                        param4.put("ioc_cd"    , tVos[i].getIocCd   ());
                        param4.put("vsl_cd"    , tVos[i].getVslCd   ());
                        param4.put("skd_voy_no", tVos[i].getSkdVoyNo());
                        param4.put("dir_cd"    , tVos[i].getDirCd   ());

    					updateList3.add(param4);
    				}
                }
            }
            vo.setMultiCreateList (createList);
            vo.setMultiUpdateList (updateList);
            vo.setMultiUpdateList2(updateList2);
            vo.setMultiUpdateList3(updateList3);

            
			result = dbDao.modifyWeeklyTargetVVD(vo);
			WeeklyCMCommonVO retVo = new WeeklyCMCommonVO();


			//--------------------------------------------------------------------------
			if(result){
				if(insert) {
					//########### [batchBc.dailyBatch()] ########################### [START]

					//batchBc.dailyBatch (cost_yr, fm_wk, duration, "2", "N", "BSA", trd_cd, rlane_cd, ioc_cd, vsl_cd, skd_voy_no, dir_cd, pUserId);
					//  dao.bsaDailyBatch() ---> dao.createNtwkCostALL()
		    		String inYr 		= searchVo.getFYear();
		    		String inFmMon 		= searchVo.getFFmMon();
		    		String inToMon 		= searchVo.getFToMon();
		    		String inFmWk 		= searchVo.getFFmWk();
		    		String inToWk 		= searchVo.getFToWk();
		    		String inMonOrWk	= searchVo.getFChkprd();
		    
		    		String inTrdCd 		= searchVo.getFSeltrade();
		    		String inRlaneCd 	= searchVo.getFSelrlane();
		    		String inIocCd 		= searchVo.getFSelioc();
		    		String inVslCd 		= searchVo.getFVslCd();
		    		String inSkdVoyNo 	= searchVo.getFSkdVoyNo();
		    		String inDirCd 		= searchVo.getFDirCd();
		    		String inUserId		= account.getUsr_id();
		    		String out_err_cd	= "";
		    		String out_err_msg	= "";
					
					ProcedureParamVO procedureParamVO = new ProcedureParamVO();
					procedureParamVO.setInYr		(inYr);
					procedureParamVO.setInFmMon		(inFmMon);
					procedureParamVO.setInToMon		(inToMon);
					procedureParamVO.setInFmWk		(inFmWk);
					procedureParamVO.setInToWk		(inToWk);
					procedureParamVO.setInMonOrWk	(inMonOrWk);
					procedureParamVO.setInFmStep	("1");
					procedureParamVO.setInAllFlg	("N");
					procedureParamVO.setInInd		("BSA");
					procedureParamVO.setInMssChkFlg	("N");
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
					resultVO = dbDao.createNtwkCostALL(procedureParamVO);
					
					if(resultVO != null){
						out_err_cd = resultVO.getOutErrCd();
						out_err_msg = resultVO.getOutErrMsg();
						log.debug("==========================================================================");
						log.debug("multiWeeklyTargetVVD- CreateTargetVVD Result Error Code: " + out_err_cd);
						log.debug("multiWeeklyTargetVVD- CreateTargetVVD Result Error Message: " + out_err_msg);
						log.debug("==========================================================================");
						if(out_err_cd.trim().equals("00000")){
							out_err_cd = "00000";
							out_err_msg = "Create Success!!";  	
						} else {
							throw new DAOException(new ErrorHandler("COA00025",out_err_cd).getMessage());
						}
					}
				}
			}
			//--------------------------------------------------------------------------
            log.debug("==============================================================================");
			log.debug(" multiWeeklyTargetVVD end : "+ String.valueOf(Calendar.getInstance().getTimeInMillis()-startTime));
			log.debug("==============================================================================");

            GeneralEventResponse eventResponse = new GeneralEventResponse();
            eventResponse.setETCData("err_cd", retVo.getErrorCode()==null?"":retVo.getErrorCode());
            eventResponse.setETCData("err_msg",retVo.getErrorMsg()==null?"":retVo.getErrorMsg());
            eventResponse.setETCData("vsl_cd","");

            return eventResponse; // "SUCCESS"
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
		} catch (Exception et) {
			log.error("err " + et.toString(), et);
			throw new EventException(et.getMessage());
		}
    }

    /**
     * 1. Function : WeeklyCM weekly target VVD management, Create event handling(ESM_COA_029)<p>
     * 2. Overview : <p>
     *    - weekly target VVD management, Handling creation
     * 3. Caution : <p>
     * ===================================<br>
     * <p/>
     *
     * @param SearchConditionVO searchConditionVO
     * @param SignOnUserAccount account
     * @return EventResponse
     * @exception EventException
     */
	public EventResponse createTargetVVD(SearchConditionVO searchConditionVO, SignOnUserAccount account) throws EventException{
        try{
        	String type			= searchConditionVO.getFTypeCd();
    		String inYr 		= searchConditionVO.getFYear();
    		String inFmMon 		= searchConditionVO.getFFmMon();
    		String inToMon 		= searchConditionVO.getFToMon();
    		String inFmWk 		= searchConditionVO.getFFmWk();
    		String inToWk 		= searchConditionVO.getFToWk();
    		String inMonOrWk	= searchConditionVO.getFChkprd();
    
    		String inTrdCd 		= searchConditionVO.getFSeltrade();
    		String inRlaneCd 	= searchConditionVO.getFSelrlane();
    		String inIocCd 		= searchConditionVO.getFSelioc();
    		String inVslCd 		= searchConditionVO.getFVslCd();
    		String inSkdVoyNo 	= searchConditionVO.getFSkdVoyNo();
    		String inDirCd 		= searchConditionVO.getFDirCd();
    		String inUserId		= account.getUsr_id();
    		String inMssChkFlg	= "";
    		String inInd		= "";
    		String out_err_cd	= "";
    		String out_err_msg	= "";
    		String result 		= "";
    		
    		if ( type.equals("Weekly") ){
    			inMssChkFlg = "N";
    			inInd		= "COA";
    		} else if (type.equals("Creation") ){
    			inMssChkFlg = "N";
    			inInd		= "BSA";    			
    		}
            
            ProcedureParamVO procedureParamVO = new ProcedureParamVO();
			procedureParamVO.setInYr		(inYr);
			procedureParamVO.setInFmMon		(inFmMon);
			procedureParamVO.setInToMon		(inToMon);
			procedureParamVO.setInFmWk		(inFmWk);
			procedureParamVO.setInToWk		(inToWk);
			procedureParamVO.setInMonOrWk	(inMonOrWk);
			procedureParamVO.setInFmStep	("1");
			procedureParamVO.setInAllFlg	("N");
			procedureParamVO.setInInd		(inInd);
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
			resultVO = dbDao.createNtwkCostALL(procedureParamVO);
            
            if(resultVO != null){
    			
    			out_err_cd = resultVO.getOutErrCd();
    			out_err_msg = resultVO.getOutErrMsg();
                log.debug("==========================================================================");
                log.debug("createTargetVVD Result Error Code: " + out_err_cd);
                log.debug("createTargetVVD Result Error Message: " + out_err_msg);
                log.debug("==========================================================================");

                if(out_err_cd.trim().equals("00000")){
                	out_err_cd = "00000";
                	out_err_msg = "Create Success!!";  	
                } else {
                	throw new DAOException(new ErrorHandler("COA00025",out_err_cd).getMessage());
                }
            }


            List<SearchVslRgstCountVO> list = dbDao.searchVslRgstCount(searchConditionVO);
            
            StringBuffer sb1 = new StringBuffer();													//SJH.20150508.소스품질
            for(int i=0; list.size() > 0 && i < list.size(); i++) {
//        		result = result + "[" + ((SearchVslRgstCountVO)list.get(i)).getVslCd() + "]";
        		sb1.append("[").append(((SearchVslRgstCountVO)list.get(i)).getVslCd()).append("]");	//SJH.20150508.소스품질
        	}
            result = sb1.toString();																//SJH.20150508.소스품질

            GeneralEventResponse eventResponse = new GeneralEventResponse();
            eventResponse.setETCData("err_cd", out_err_cd);
            eventResponse.setETCData("err_msg", out_err_msg);
            eventResponse.setETCData("vsl_cd",result==null?"":result);

            return eventResponse; // "SUCCESS"
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }
    }

	/**
	 * 1. Function : WeeklyCM weekly target VVD management, Create event handling(ESM_COA_0029)<p>
	 * 2. Overview : <p>
	 *    - weekly target VVD management, Creation
	 * 3. Caution : <p>
	 * ===================================<br>

	 * <p/>
	 *
	 * @param SearchConditionVO searchConditionVO
	 * @param SignOnUserAccount account
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse createTSQty(SearchConditionVO searchConditionVO, SignOnUserAccount account) throws EventException{
        try{
        	GeneralEventResponse eventResponse = new GeneralEventResponse();
    		String inYr 		= searchConditionVO.getFYear();
    		String inFmMon 		= searchConditionVO.getFFmMon();
    		String inToMon 		= searchConditionVO.getFToMon();
    		String inFmWk 		= searchConditionVO.getFFmWk();
    		String inToWk 		= searchConditionVO.getFToWk();
    		String inMonOrWk	= searchConditionVO.getFChkprd();
    
    		String inTrdCd 		= searchConditionVO.getFSeltrade();
    		String inRlaneCd 	= searchConditionVO.getFSelrlane();
    		String inVslCd 		= searchConditionVO.getFVslCd();
    		String inSkdVoyNo 	= searchConditionVO.getFSkdVoyNo();
    		String inDirCd 		= searchConditionVO.getFDirCd();
    		String inUserId		= account.getUsr_id();
    		String inIocCd 		= searchConditionVO.getFSelioc();
    		String inMssChkFlg	= "Y";
    		String out_err_cd	= "";
    		String out_err_msg	= "";
            
            ProcedureParamVO procedureParamVO = new ProcedureParamVO();
			procedureParamVO.setInYr		(inYr);
			procedureParamVO.setInFmMon		(inFmMon);
			procedureParamVO.setInToMon		(inToMon);
			procedureParamVO.setInFmWk		(inFmWk);
			procedureParamVO.setInToWk		(inToWk);
			procedureParamVO.setInMonOrWk	(inMonOrWk);
			procedureParamVO.setInFmStep	("2");
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
			resultVO = dbDao.createNtwkCostALL(procedureParamVO);
            
            if(resultVO != null){
    			
    			out_err_cd = resultVO.getOutErrCd();
    			out_err_msg = resultVO.getOutErrMsg();
                log.debug("==========================================================================");
                log.debug("createTSQty Result Error Code: " + out_err_cd);
                log.debug("createTSQty Result Error Message: " + out_err_msg);
                log.debug("==========================================================================");

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
	 * ESM_COA_0029 : manual batch #1<br>
	 *
	 * @param SearchConditionVO searchConditionVO
	 * @param SignOnUserAccount account
	 * @return EventResponse
	 * @exception EventException
	 */
    public EventResponse dailyBatch(SearchConditionVO searchConditionVO, SignOnUserAccount account) throws EventException{
        try{
            GeneralEventResponse eventResponse = new GeneralEventResponse();

    		String inYr 		= searchConditionVO.getFYear();
    		String inFmMon 		= searchConditionVO.getFFmMon();
    		String inToMon 		= searchConditionVO.getFToMon();
    		String inFmWk 		= searchConditionVO.getFFmWk();
    		String inToWk 		= searchConditionVO.getFToWk();
    		String inMonOrWk	= searchConditionVO.getFChkprd();
    
    		String inTrdCd 		= searchConditionVO.getFSeltrade();
    		String inRlaneCd 	= searchConditionVO.getFSelrlane();
    		String inIocCd 		= "";
    		String inVslCd 		= "";
    		String inSkdVoyNo 	= "";
    		String inDirCd 		= searchConditionVO.getFDirCd();
    		String inUserId		= account.getUsr_id();
    		String out_err_cd	= "";
    		String out_err_msg	= "";
    		String duration = "0";

			//########### [batchBc.searchYrWkDu()] ########################### [START]
			ProcedureParamVO durationParamVO = new ProcedureParamVO();
        	durationParamVO.setInYr(inYr);
        	durationParamVO.setInFmWk(inFmWk);
        	durationParamVO.setInToWk(inToWk);
        	durationParamVO.setInFmMon(inFmMon);
        	durationParamVO.setInToMon(inToMon);
        	durationParamVO.setInMonOrWk(searchConditionVO.getFChkprd());
        	
        	SearchYrWkDuVO yrWkduList = dbDao.searchYrWkDu(durationParamVO);
			duration = yrWkduList.getCnt(); 
			
			//########### [batchBc.searchYrWkDu()] ########################### [END]
			if (!duration.equals("0")) {                    
                ProcedureParamVO procedureParamVO = new ProcedureParamVO();
    			procedureParamVO.setInYr		(inYr);
    			procedureParamVO.setInFmMon		(inFmMon);
    			procedureParamVO.setInToMon		(inToMon);
    			procedureParamVO.setInFmWk		(inFmWk);
    			procedureParamVO.setInToWk		(inToWk);
    			procedureParamVO.setInMonOrWk	(inMonOrWk);
    			procedureParamVO.setInFmStep	("1");
    			procedureParamVO.setInAllFlg	("N");
    			procedureParamVO.setInInd		("BSA");
    			procedureParamVO.setInMssChkFlg	("N");
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
    			resultVO = dbDao.createNtwkCostALL(procedureParamVO);
                
                if(resultVO != null){
        			
        			out_err_cd = resultVO.getOutErrCd();
        			out_err_msg = resultVO.getOutErrMsg();
                    log.debug("==========================================================================");
                    log.debug("dailyBatch-createTargetVVD Result Error Code: " + out_err_cd);
                    log.debug("dailyBatch-createTargetVVD Result Error Message: " + out_err_msg);
                    log.debug("==========================================================================");

                    if(out_err_cd.trim().equals("00000")){
                    	out_err_cd = "00000";
                    	out_err_msg = "Create Success!!";  	
                    }                
                }
                eventResponse.setETCData("err_cd", out_err_cd);
                eventResponse.setETCData("err_msg", out_err_msg);
	            
	            if(out_err_cd.equals("00000")){
					//########### [batchBc.dailyBatch()] ########################### [START]

	            	
    				BsaProcedureParamVO bsaProcedureParam = new BsaProcedureParamVO();
    				bsaProcedureParam.setPYear		(inYr);
    				bsaProcedureParam.setPWeek		(inFmWk);
    				bsaProcedureParam.setPDuration	(duration);
    				bsaProcedureParam.setPStep		("4");
    				bsaProcedureParam.setPOnlyStep	("N");
    				bsaProcedureParam.setPBsa		("BSA");
    				bsaProcedureParam.setPTrdCd		(inTrdCd);
    				bsaProcedureParam.setPRlaneCd	(inRlaneCd);
    				bsaProcedureParam.setPIocCd		(inIocCd);
    				bsaProcedureParam.setPVslCd		(inVslCd); 
    				bsaProcedureParam.setPSkdVoyNo	(inSkdVoyNo);
    				bsaProcedureParam.setPDirCd		(inDirCd);
    				bsaProcedureParam.setPUserId	(inUserId);
    				
    				BsaProcedureParamVO bsaResult = new BsaProcedureParamVO();
    				bsaResult = dbDao.bsaDailyBatch(bsaProcedureParam);
    				
    				if( bsaResult != null ){
    					out_err_cd = bsaResult.getPErrCd();
    	    			out_err_msg = bsaResult.getPErrMsg();
    	                log.debug("==========================================================================");
    	                log.debug("dailyBatch-BSA Result Error Code: " + out_err_cd);
    	                log.debug("dailyBatch-BSA Result Error Message: " + out_err_msg);
    	                log.debug("==========================================================================");

    	                if(out_err_cd.trim().equals("00000")){
    	                	out_err_cd = "00000";
    	                	out_err_msg = "Create Success!!";  	
    	                }                
    	            }
    	            eventResponse.setETCData("err_cd", out_err_cd);
    	            eventResponse.setETCData("err_msg", out_err_msg);
	            }
			}

            return eventResponse; // "SUCCESS"
        } catch (Exception de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }

    }

	/**
	 * ESM_COA_0029 : Setting the BSA VVD values to a 0 if the BSA Flag is Y <br>
	 *
	 * @param SearchConditionVO searchConditionVO
	 * @param SignOnUserAccount account
	 * @return EventResponse
	 * @exception EventException
	 */
    public EventResponse batchBSAVVDZero(SearchConditionVO searchConditionVO, SignOnUserAccount account) throws EventException{
        try{
        	GeneralEventResponse eventResponse = new GeneralEventResponse();
        	String duration = "0";
            //
            //----------------------------------------------------
			String user_id      = account.getUsr_id();
			String trd_cd       = searchConditionVO.getFSeltrade();
			String rlane_cd     = searchConditionVO.getFSelrlane();
			String ioc_cd       = ""; //event.getString("selIOC");
			String vsl_cd       = ""; //event.getString("txtVsl_cd");
			String skd_voy_no   = ""; //event.getString("txtSkd_voy_no");
			String dir_cd       = searchConditionVO.getFDirCd();

			String year         = searchConditionVO.getFYear();
			String fm_wk        = searchConditionVO.getFFmWk();
			String to_wk        = searchConditionVO.getFToWk();
			String fm_mon		= searchConditionVO.getFFmMon();
			String to_mon        = searchConditionVO.getFToMon();
			
			String out_err_cd	= "";
			String out_err_msg	= "";

			//########### [batchBc.searchYrWkDu()] ########################### [START]
			ProcedureParamVO durationParamVO = new ProcedureParamVO();
        	durationParamVO.setInYr(year);
        	durationParamVO.setInFmWk(fm_wk);
        	durationParamVO.setInToWk(to_wk);
        	durationParamVO.setInFmMon(fm_mon);
        	durationParamVO.setInToMon(to_mon);
        	durationParamVO.setInMonOrWk(searchConditionVO.getFChkprd());
        	
        	SearchYrWkDuVO yrWkduList = dbDao.searchYrWkDu(durationParamVO);
			duration = yrWkduList.getCnt(); 

			if (!duration.equals("0")) {
				BsaProcedureParamVO bsaProcedureParam = new BsaProcedureParamVO();
				bsaProcedureParam.setPYear		("");
				bsaProcedureParam.setPWeek		("");
				bsaProcedureParam.setPDuration	("");
				bsaProcedureParam.setPStep		("4");
				bsaProcedureParam.setPOnlyStep	("Y");
				bsaProcedureParam.setPBsa		("BSA");
				bsaProcedureParam.setPTrdCd		(trd_cd);
				bsaProcedureParam.setPRlaneCd	(rlane_cd);
				bsaProcedureParam.setPIocCd		(ioc_cd);
				bsaProcedureParam.setPVslCd		(vsl_cd);
				bsaProcedureParam.setPSkdVoyNo	(skd_voy_no);
				bsaProcedureParam.setPDirCd		(dir_cd);
				bsaProcedureParam.setPUserId	(user_id);
				
				BsaProcedureParamVO bsaResult = new BsaProcedureParamVO();
				bsaResult = dbDao.bsaDailyBatch(bsaProcedureParam);
				
				if( bsaResult != null ){
					out_err_cd = bsaResult.getPErrCd();
	    			out_err_msg = bsaResult.getPErrMsg();
	                log.debug("==========================================================================");
	                log.debug("batchBSAVVDZero Result Error Code: " + out_err_cd);
	                log.debug("batchBSAVVDZero Result Error Message: " + out_err_msg);
	                log.debug("==========================================================================");

	                if(out_err_cd.trim().equals("00000")){
	                	out_err_cd = "00000";
	                	out_err_msg = "Create Success!!";  	
	                }                
	            }

	            eventResponse.setETCData("err_cd", out_err_cd);
	            eventResponse.setETCData("err_msg", out_err_msg);
            }

            return eventResponse; // "SUCCESS"
        } catch (Exception de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }
    }


	/* ----------------------------------------------------------------------------------------------- */

	/**
	 * Handling the inquiry event<br>
	 * VVD Check With AR List Handling the inquiry event<br>
	 * ESM_COA_0112 Inquiry
	 * @param SearchVVDChkWithARListVO searchVVDChkWithARListVO
	 * @param SearchConditionVO searchConditionVO
	 * @return List<SearchVVDChkWithARListVO>
	 * @exception EventException
	 */
	public List<SearchVVDChkWithARListVO> searchVVDChkWithARList (SearchVVDChkWithARListVO searchVVDChkWithARListVO
			                                                     ,SearchConditionVO searchConditionVO) throws EventException {
		try {
			return dbDao.searchVVDChkWithARList (searchVVDChkWithARListVO, searchConditionVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}

	}

	/**
	 * Handling the save event<br>
	 * VVD Check With AR List, Handling the save event<br>
	 * ESM_COA_0112 multi
	 * @param CoaMonVvdVO[] coaMonVvdVO
	 * @param SearchConditionVO searchConditionVO
	 * @param SearchVVDChkWithARListVO[] searchVVDChkWithARListVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiVVDChkWithARList(CoaMonVvdVO[] coaMonVvdVO, SearchConditionVO searchConditionVO, SearchVVDChkWithARListVO[] searchVVDChkWithARListVO, SignOnUserAccount account) throws EventException{
		try {
			List<SearchVVDChkWithARListVO> insertVoList = new ArrayList<SearchVVDChkWithARListVO>();
			List<SearchVVDChkWithARListVO> updateVoList = new ArrayList<SearchVVDChkWithARListVO>();
			List<SearchVVDChkWithARListVO> updateVoList2 = new ArrayList<SearchVVDChkWithARListVO>();

			for ( int i=0; i<searchVVDChkWithARListVO.length; i++ ) {
				if ( searchVVDChkWithARListVO[i].getRsltCd().equals("A")){
					searchVVDChkWithARListVO[i].setCreUsrId(account.getUsr_id());
					searchVVDChkWithARListVO[i].setUpdUsrId(account.getUsr_id());
					searchVVDChkWithARListVO[i].setFCostYr(searchConditionVO.getFCostYr());
					searchVVDChkWithARListVO[i].setFCostFmMon(searchConditionVO.getFCostFmMon());
					insertVoList.add(searchVVDChkWithARListVO[i]);
				} else{
					searchVVDChkWithARListVO[i].setUpdUsrId(account.getUsr_id());
					searchVVDChkWithARListVO[i].setFCostYr(searchConditionVO.getFCostYr());
					searchVVDChkWithARListVO[i].setFCostFmMon(searchConditionVO.getFCostFmMon());
					updateVoList.add(searchVVDChkWithARListVO[i]);
				}
			}
			SearchVVDChkWithARListVO updVO = new SearchVVDChkWithARListVO();
			updVO.setUpdUsrId(account.getUsr_id());
			updVO.setFCostYr(searchConditionVO.getFCostYr());
			updVO.setFCostFmMon(searchConditionVO.getFCostFmMon());
			updateVoList2.add(searchVVDChkWithARListVO[0]);

			if ( updateVoList.size() > 0 ) {
				dbDao.modifyVVDChkWithARList(updateVoList);
			}

			if ( updateVoList2.size() > 0 ) {
				dbDao.modifyVVDChkWithARList2(updateVoList2);
			}

			if ( insertVoList.size() > 0 ) {
				dbDao.addVVDChkWithARList(insertVoList);
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
	 * Handling the inquiry event<br>
	 * Month VVD I/F, Handling the update event<br>
	 * ESM_COA_0112 Inquiry
	 * @param SearchVVDChkWithARListVO	searchVVDChkWithARListVO
	 * @exception EventException
	 */
	public void multiMonthVVDIFStatus (SearchVVDChkWithARListVO searchVVDChkWithARListVO) throws EventException {
		try {
			dbDao.removeMonthVVDIFStatus (searchVVDChkWithARListVO);
			dbDao.modifyMonthVVDIFStatus (searchVVDChkWithARListVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
}