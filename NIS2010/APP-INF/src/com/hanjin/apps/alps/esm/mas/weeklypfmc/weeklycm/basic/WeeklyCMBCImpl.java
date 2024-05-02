/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : WeeklyPFMCBCImpl.java
*@FileTitle : Weekly PFMC BC Impl
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-23
*@LastModifier : Ari
*@LastVersion : 1.0
* 2006-10-23 Park Eun Ju
* 1.0 최초 생성
* =========================================================
* History
* 2008.04.29 임옥영 N200804280007 Source Data Download 수정
* 2008.07.15 박은주 N200806270002 Inquiry by Source Data 화면의 Misc 컬럼 제거 Total만 남겨둠[035]
* 2008.07.23 전성진 CSR No.N200807230006
*						- SMU 단가 저장 기능 추가
* 2008.08.29 박은주 CSR No. N200807298360 Expense Detail로 테이블 변경하면서 화면단 모두 변경[060,062]
* 2008.09.08 전윤주 115번 화면 사용하지 않는 method 삭제
* 2009.09.04 박수훈 0030(029S)화면 New FrameWork 적용
* 2009.09.10 박수훈 0112 화면 New FrameWork 적용
* 2009.09.16 박수훈 0115 화면 New FrameWork 적용
* 2009.09.17 박수훈 0117 화면 New FrameWork 적용
* 2009.09.30 박수훈 0118 화면 New FrameWork 적용
* 2009.10.09 박수훈 0119 화면 New FrameWork 적용
* 2009.09.30 김기대 0040 화면 New FrameWork 적용
* 2009.09.30 김기대 0042 화면 New FrameWork 적용
* 2009.09.30 김기대 0043 화면 New FrameWork 적용
* 2009.09.30 김기대 0029 화면 New FrameWork 적용
* 2009.09.30 김기대 0059 화면 New FrameWork 적용
* 2009.09.30 김기대 0060 화면 New FrameWork 적용
* 2009.09.30 김기대 0039 화면 New FrameWork 적용
* 2009.09.30 김기대 0044 화면 New FrameWork 적용
* 2009.09.30 김기대 0047 화면 New FrameWork 적용
* 2009.10.16 박수훈 0142 화면 New FrameWork 적용
* 2010.01.05 박은주  대상항차 프로시저 변경으로 소스 수정
* 2010.01.11 김기식 0175 화면 New FrameWork 적용
* 2010.09.30 이윤정 [CHM-201006102-01] Target VVD 주차 변경관련 수정요청 [월,주차 변경시  Ocean과 Trunk IPC 정보를 동일하게 변경 시켜줌 (단 IAS 노선은 제외한다)]
* 2011.02.10 최성민 [CHM-201108533-01] 한개의 vessel 코드만 출력하는 것을 for 문 사용하여 여러개의 vessel 코드를 출력한다. 
* 2011.06.02 최성민 [CHM-201111115-01] Split 02-Split 03-ALPS Error 처리 요청 - BackEndJob으로 변환
* 2011.07.20 최성민 [CHM-201112295-01] [MAS] 내부거래단가 조건추가 : Actual Lane 정보 - multiOwnTMLPfmc() 변경
* 2012.07.17 이석준 [CHM-201218919-01] SMU Cost (RA) 화면 Create 기능 추가    
* 2012.07.18 이석준 [CHM-201219046-01] [MAS] Target VVD 배치 기능 추가 
* 2012.09.12 이석준 [CHM-201220073-01] EMU Cost (RA) 에 Month Copy 기능 추가
* 2013.05.08 성미영 [CHM-201324182] SMU 단가 화면 전월 copy 기능 추가 
* 2014.04.10 최성민 [CHM-201429154] Target VVD BSA Flag 처리 후 BSA 시스템 연동 로직 변경 요청
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.basic;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import com.hanjin.apps.alps.esm.mas.common.Utils;
import com.hanjin.apps.alps.esm.mas.common.vo.ProcedureParamVO;
import com.hanjin.apps.alps.esm.mas.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.integration.WeeklyCMDBDAO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.vo.BsaProcedureParamVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.vo.ChassisCostReportVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.vo.DEMDETCostReportbyBKGDetailVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.vo.DemDetCostDayBatRstVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.vo.DemDetCostRepbyBKGVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.vo.DemDetCostReportbyBKGVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.vo.DemDetCostReportbyCustomerVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.vo.FullStorageDailyCalcVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.vo.IsLaneRgstVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.vo.MasEMUCreditListVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.vo.MultiMasMonVvdVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.vo.OfcRoleSetupVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.vo.OnewayCntrUploadVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.vo.SearchChassisCostVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.vo.SearchEMUPfmcListVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.vo.SearchExceptionListMgmtVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.vo.SearchOPCreditRtPortPairVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.vo.SearchOwnTMLPfmcListVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.vo.SearchSMUPfmcListVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.vo.SearchSeasonalSMUCostListVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.vo.SearchSeasonalSMUCostPopListVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.vo.SearchUCbyCustomerListVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.vo.SearchUOM0119ListVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.vo.SearchVVDCheckListVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.vo.SearchVVDChkWithARListVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.vo.SearchWeeklyTargetVVD0030ListVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.vo.SearchWeeklyTargetVVDListVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.vo.SearchYrWkDuVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.vo.StorageCalExcepNodeVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.vo.WeeklyCMCommonVO;
import com.hanjin.framework.component.backend.core.BackEndJobManager;
import com.hanjin.framework.component.backend.support.BackEndJobException;
import com.hanjin.framework.component.backend.support.BackEndJobMetaDataSelector;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.MasInterOwnTmlCostVO;
import com.hanjin.syscommon.common.table.MasLaneDirConvVO;
import com.hanjin.syscommon.common.table.MasMonVvdVO;
import com.hanjin.syscommon.common.table.MasSltMgmtUtVO;
import com.hanjin.syscommon.common.table.MasTmlTrfGrpVO;
import com.hanjin.syscommon.common.table.MasUtCostCreStsVO;
import com.hanjin.syscommon.common.util.ScheduleUtil;

/**
 * eNIS-MAS Business Logic Basic Commanimport java.util.List; 
 * <br>
 * - eNIS-MAS에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Park Eun Ju
 * @see WeeklyPFMCBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class WeeklyCMBCImpl extends BasicCommandSupport implements WeeklyCMBC {

	// Database Access Object
	private transient WeeklyCMDBDAO dbDao = null;
//	private transient BSACreateBC batchBc = null;

	/**
	 * WeeklyPFMCBCImpl 객체  생성<br>
	 * WeeklyPFMCDBDAO를 생성한다.<br>
	 */
	public WeeklyCMBCImpl(){
		dbDao = new WeeklyCMDBDAO();
	}

	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 기능 : 대상항차에서 week, trade, lane, bound가 동일한 항목리스트를 조회한다.(ESM_MAS_029)<p>
     * 처리개요 : 주간 대상항차관리에 대한 리스트를 조회
	 * ESM_MAS_0142 화면 조회
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
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 기능 : weekly 수정시 weekly target flag 확정 (ESM_MAS_029)<p>
	 * 처리개요 : 주간 대상항차관리에 대한 리스트를 조회<p>
	 * ESM_MAS_0142 화면 수정
	 * @param MasMonVvdVO[] masMonVvdVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyVVDCheck(MasMonVvdVO[] masMonVvdVO, SignOnUserAccount account) throws EventException{
		try {
			List<MasMonVvdVO> updateVoList = new ArrayList<MasMonVvdVO>();
			for ( int i=0; i<masMonVvdVO .length; i++ ) {
			   if ( masMonVvdVO[i].getIbflag().equals("U")){
					masMonVvdVO[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(masMonVvdVO[i]);
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
	 * 1. 기능 : WeeklyCM 주간 대상항차관리 화면에 대한 조회 이벤트 처리(ESM_MAS_029)<p>
	 * 2. 처리개요 : <p>
	 *    - 주간 대상항차관리에 대한 리스트를 조회
	 * 3. 주의사항 : <p>
	 * ===================================<br>
	 * 4. 작성자/작성일 : Park eun ju /2006.10.23<br>
	 * ===================================<br>
	 * 5. 수정사항<p>
	 * 5.1 요구사항 ID :<p>
	 * - 수정자/수정일 :<p>
	 * - 수정사유/내역 :<p>
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
     * 1. 기능 : WeeklyCM 주간 대상항차관리 화면에 대한 멀티 이벤트 처리(ESM_MAS_029)<p>
     * 2. 처리개요 : <p>
     *    - 주간 대상항차관리에 대한 멀티처리
     * 3. 주의사항 : <p>
     * ===================================<br>
     * 4. 작성자/작성일 : Park eun ju /2006.10.23<br>
     * ===================================<br>
     * 5. 수정사항<p>
     * 5.1 요구사항 ID :<p>
     * - 수정자/수정일 :<p>
     * - 수정사유/내역 :<p>
     * ===================================<br>
     * <p/>
     *
     * @param SearchConditionVO searchVo
     * @param WeeklyCMCommonVO vo
     * @param WeeklyCMCommonVO[] vos
     * @param MultiMasMonVvdVO[] tVos
     * @param SignOnUserAccount account
     * @return EventResponse
     * @exception EventException
     */
	public EventResponse multiWeeklyTargetVVD(SearchConditionVO searchVo, WeeklyCMCommonVO vo, WeeklyCMCommonVO[] vos, MultiMasMonVvdVO[] tVos, SignOnUserAccount account) throws EventException{
        try{
        	boolean insert    = false;
        	boolean checkLane = false;
        	boolean result    = false;
			long startTime = Calendar.getInstance().getTimeInMillis();
			log.debug("==============================================================================");
			log.debug(" multiWeeklyTargetVVD start : 0");
			log.debug("==============================================================================");
			// Insert항목중 MAS_LANE_RGST에 없는 데이터면 에러처리한다.
			//--------------------------------------------------------------------------

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
					throw new DAOException(new ErrorHandler("MAS00027").getMessage());
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

    				// "P" : Per_Manual 변경 가능 , "A": Fix_Auto Creation시에 Fix, "M" : Fix_Manual User가 수동으로 Fix
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
                        /* 2010.09.27 이윤정 [CHM-201006102-01] Target VVD 주차 변경관련 수정요청
                         * 
                         * 월, 주차 변경시  Ocean과 Trunk IPC 정보를 동일하게 변경 시켜줌 (단 IAS 노선은 제외한다)
                         * 
                         * 화면에서 데이터 변경 할 때 아래 표와 같이 ‘O’ 인 것들에 대해서 둘 중 하나가 변경되어도 같이 변경되도록 프로그램 수정한다. 
                         * 프로그램 수정 전엔 AES, IES에 대해서만 동일하게 변경하도록 처리되어 있음.
                         * 
                         * AES	IES	O
                         * TAS	IES	O
                         * TAS	IMS	O
                         * TPS	IMS	O
                         * EMS	IMS	O
                         * AES	IAS	X
                         * TPS	IAS	X
                         * EMS	IAS	X
                         * */
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

            //[DB 실행]
			result = dbDao.modifyWeeklyTargetVVD(vo);
			WeeklyCMCommonVO retVo = new WeeklyCMCommonVO();

			// Inser항목이 있으면 Creation을 실행한다.
			//--------------------------------------------------------------------------
			if(result){
				if(insert) {
					//########### [batchBc.dailyBatch()] ########################### [START]
					// 대상항차 생성 - 대상항차 보정 - 운항일수 생성
					//batchBc.dailyBatch (cost_yr, fm_wk, duration, "2", "N", "BSA", trd_cd, rlane_cd, ioc_cd, vsl_cd, skd_voy_no, dir_cd, pUserId);
					//변경  dao.bsaDailyBatch() ---> dao.createNtwkCostALL()
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
							throw new DAOException(new ErrorHandler("MAS00025",out_err_cd).getMessage());
						}
					}
				}
			}
			
			//////////////////////////////////////////////
			//BSA Flag 나 Cost Week 정보가 변경됐을 경우 BSA 배치를 호출한다.
			//this.multiBsaDailyBatch(tVos, account);
			//////////////////////////////////////////////
			
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
	 * Target VVD 화면에서 BSA Flag 나  Cost Week 정보를 변경했을 때 BSA 배치를 호출한다.<br>
	 * @param MultiMasMonVvdVO[] multiVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiBsaDailyBatch(MultiMasMonVvdVO[] multiVOs, SignOnUserAccount account) throws EventException{
		try {
			BsaProcedureParamVO bsaParam = new BsaProcedureParamVO();

			for ( int i=0; i<multiVOs.length; i++ ) {
//				log.debug("+multiVOs[i].getIbflag()++++++++++++++++++++++++++++++++"+multiVOs[i].getIbflag());
//				log.debug("+multiVOs[i].getBsaZrFlg()++++++++++++++++++++++++++++++++"+multiVOs[i].getBsaZrFlg());
//				log.debug("+multiVOs[i].getOldBsaZrFlg()++++++++++++++++++++++++++++++++"+multiVOs[i].getOldBsaZrFlg());
//				log.debug("+multiVOs[i].getCostWk()++++++++++++++++++++++++++++++++"+multiVOs[i].getCostWk());
//				log.debug("+multiVOs[i].getOldCostWk()++++++++++++++++++++++++++++++++"+multiVOs[i].getOldCostWk());
				
				if(multiVOs[i].getIbflag().equals("U")) {
					if ( multiVOs[i].getBsaZrFlg().equals("1") && (!multiVOs[i].getBsaZrFlg().equals(multiVOs[i].getOldBsaZrFlg()))){	
						//BSA Flag Checked					
						
						bsaParam.setPYear		(multiVOs[i].getSlsYrmon().substring(0, 4));
						bsaParam.setPWeek		(multiVOs[i].getCostWk());
						bsaParam.setPDuration	("1");
						bsaParam.setPStep		("4");
						bsaParam.setPOnlyStep	("Y");
						bsaParam.setPBsa		("BSA");
						bsaParam.setPTrdCd		(multiVOs[i].getTrdCd());
						bsaParam.setPRlaneCd	(multiVOs[i].getRlaneCd());
						bsaParam.setPIocCd		(multiVOs[i].getIocCd());
						bsaParam.setPVslCd		(multiVOs[i].getVslCd());
						bsaParam.setPSkdVoyNo	(multiVOs[i].getSkdVoyNo());
						bsaParam.setPDirCd		(multiVOs[i].getDirCd());
						bsaParam.setPUserId	(account.getUsr_id());
						
						dbDao.bsaDailyBatch(bsaParam);
					} else if (multiVOs[i].getBsaZrFlg().equals("0") && (!multiVOs[i].getBsaZrFlg().equals(multiVOs[i].getOldBsaZrFlg()))){
						//BSA Flag UnChecked
						
						bsaParam.setPYear		(multiVOs[i].getSlsYrmon().substring(0, 4));
						bsaParam.setPWeek		(multiVOs[i].getCostWk());
						bsaParam.setPDuration	("1");
						bsaParam.setPStep		("2");
						bsaParam.setPOnlyStep	("Y");
						bsaParam.setPBsa		("BSA");
						bsaParam.setPTrdCd		(multiVOs[i].getTrdCd());
						bsaParam.setPRlaneCd	(multiVOs[i].getRlaneCd());
						bsaParam.setPIocCd		(multiVOs[i].getIocCd());
						bsaParam.setPVslCd		(multiVOs[i].getVslCd());
						bsaParam.setPSkdVoyNo	(multiVOs[i].getSkdVoyNo());
						bsaParam.setPDirCd		(multiVOs[i].getDirCd());
						bsaParam.setPUserId	(account.getUsr_id());
						
						dbDao.bsaDailyBatch(bsaParam);
						
						bsaParam.setPStep		("3");
						dbDao.bsaDailyBatch(bsaParam);
					} else if (!multiVOs[i].getCostWk().equals(multiVOs[i].getOldCostWk())){
						//Cost Week modify
						
						bsaParam.setPYear		(multiVOs[i].getSlsYrmon().substring(0, 4));
						bsaParam.setPWeek		(multiVOs[i].getCostWk());
						bsaParam.setPDuration	("1");
						bsaParam.setPStep		("2");
						bsaParam.setPOnlyStep	("Y");
						bsaParam.setPBsa		("BSA");
						bsaParam.setPTrdCd		(multiVOs[i].getTrdCd());
						bsaParam.setPRlaneCd	(multiVOs[i].getRlaneCd());
						bsaParam.setPIocCd		(multiVOs[i].getIocCd());
						bsaParam.setPVslCd		(multiVOs[i].getVslCd());
						bsaParam.setPSkdVoyNo	(multiVOs[i].getSkdVoyNo());
						bsaParam.setPDirCd		(multiVOs[i].getDirCd());
						bsaParam.setPUserId	(account.getUsr_id());
						
						dbDao.bsaDailyBatch(bsaParam);
						
						bsaParam.setPStep		("3");
						dbDao.bsaDailyBatch(bsaParam);
					}					
				} else if(multiVOs[i].getIbflag().equals("I")) {
					//Target VVD Insert
					
					bsaParam.setPYear		(multiVOs[i].getSlsYrmon().substring(0, 4));
					bsaParam.setPWeek		(multiVOs[i].getCostWk());
					bsaParam.setPDuration	("1");
					bsaParam.setPStep		("2");
					bsaParam.setPOnlyStep	("Y");
					bsaParam.setPBsa		("BSA");
					bsaParam.setPTrdCd		(multiVOs[i].getTrdCd());
					bsaParam.setPRlaneCd	(multiVOs[i].getRlaneCd());
					bsaParam.setPIocCd		(multiVOs[i].getIocCd());
					bsaParam.setPVslCd		(multiVOs[i].getVslCd());
					bsaParam.setPSkdVoyNo	(multiVOs[i].getSkdVoyNo());
					bsaParam.setPDirCd		(multiVOs[i].getDirCd());
					bsaParam.setPUserId	(account.getUsr_id());
					
					dbDao.bsaDailyBatch(bsaParam);
					
					bsaParam.setPStep		("3");
					dbDao.bsaDailyBatch(bsaParam);
					
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
     * 1. 기능 : WeeklyCM 주간 대상항차관리 화면에 대한 Create 이벤트 처리(ESM_MAS_029)<p>
     * 2. 처리개요 : <p>
     *    - 주간 대상항차관리에 대한 Create처리
     * 3. 주의사항 : <p>
     * ===================================<br>
     * 4. 작성자/작성일 : Park eun ju /2006.10.23<br>
     * ===================================<br>
     * 5. 수정사항<p>
     * 5.1 요구사항 ID :<p>
     * - 수정자/수정일 :<p>
     * - 수정사유/내역 :<p>
     * ===================================<br>
     * <p/>
     *
	 * @param SearchConditionVO searchVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
     */
	public String createTargetVVD(SearchConditionVO searchVO, SignOnUserAccount account) throws EventException {		
		ScheduleUtil su = new ScheduleUtil();
        
        String status = "";
			try {
				String params = searchVO.getFYear() + 
						"#" + searchVO.getFFmWk() + 
						"#" + searchVO.getFToWk() + 
						"#" + account.getUsr_id() + 
						"#" + searchVO.getFTypeCd() + 
						"#" + searchVO.getFSeltrade()  + 
						"#" + searchVO.getFSelrlane() + 
						"#" + searchVO.getFSeldir() + 
						"#" + searchVO.getFIocCd() + 
						"#" + searchVO.getFVslCd() + 
						"#" + searchVO.getFSkdVoyNo() + 
						"#" + searchVO.getFDirCd() +
						"#" + "1"; // Step:1 Target VVD Creation, param 의 맨 마지막에 위치, 배열은 끝부분이  null 일경우 배열개수에서 제외됨.

				log.debug("++++++++++++++++++++++++++++++++++++++++++params++++:"+params);
				status = su.directExecuteJob("ESM_MAS_B009",params);
				log.debug("++++++++++++++++++++++++++++++++++++++++++status++++"+status);
				
				
				
			} catch (IOException e) {
				log.error("err "+e.toString(),e);
				throw new EventException(new ErrorHandler("COM12213", new String[]{"Target VVD Creation"}).getMessage(),e);
			} catch (InterruptedException e) {
				log.error("err "+e.toString(),e);
				throw new EventException(new ErrorHandler("COM12213", new String[]{"Target VVD Creation"}).getMessage(),e);
			} catch (DAOException e) {
				log.error("err "+e.toString(),e);
				throw new EventException(new ErrorHandler("COM12213", new String[]{"Target VVD Creation"}).getMessage(),e);
			} catch (Exception e){
				log.error("err "+e.toString(),e);
				throw new EventException(new ErrorHandler("COM12213", new String[]{"Target VVD Creation"}).getMessage(),e);
			}
			return "4";//실행 성공
	}	
	
	

	/**
	 * WeeklyCM 주간 대상항차화면에 대한 조회 이벤트 처리.<br>
	 *
	 * @param SearchWeeklyTargetVVD0030ListVO searchWeeklyTargetVVD0030ListVO
	 * @param SearchConditionVO searchConditionVO
	 * @return List<SearchWeeklyTargetVVD0030ListVO>
	 * @exception EventException
	 */
	public List<SearchWeeklyTargetVVD0030ListVO> searchWeeklyTargetVVD0030List(SearchWeeklyTargetVVD0030ListVO searchWeeklyTargetVVD0030ListVO
			                                                                  ,SearchConditionVO searchConditionVO) throws EventException {
		try {
			return dbDao.searchWeeklyTargetVVD0030List(searchWeeklyTargetVVD0030ListVO, searchConditionVO);
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
	 * WeeklyCM 화면에 대한 조회 이벤트 처리<br>
	 * ESM_MAS_0115.do 조회
	 * @param SearchEMUPfmcListVO searchEMUPfmcListVO
	 * @param SearchConditionVO searchConditionVO
	 * @return List<SearchEMUPfmcListVO>
	 * @exception EventException
	 */
	public List<SearchEMUPfmcListVO> searchEMUPfmcList(SearchEMUPfmcListVO searchEMUPfmcListVO
			                                          ,SearchConditionVO searchConditionVO) throws EventException {
		try {
			return dbDao.searchEMUPfmcList(searchEMUPfmcListVO, searchConditionVO);
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
	 * WeeklyCM 화면에 대한 조회 이벤트 처리<br>
	 * ESM_MAS_0117 조회
	 * @param SearchSMUPfmcListVO searchSMUPfmcListVO
	 * @param SearchConditionVO searchConditionVO
	 * @return List<SearchSMUPfmcListVO>
	 * @exception EventException
	 */
	public List<SearchSMUPfmcListVO> searchSMUPfmcList(SearchSMUPfmcListVO searchSMUPfmcListVO
		                                            	,SearchConditionVO searchConditionVO) throws EventException {
		try {
			return dbDao.searchSMUPfmcList(searchSMUPfmcListVO, searchConditionVO);
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
	 * WeeklyCM 화면에 대한 조회 이벤트 처리<br>
	 * ESM_MAS_0120 조회
	 * @param SearchSeasonalSMUCostListVO searchSeasonalSMUCostListVO
	 * @param SearchConditionVO searchConditionVO
	 * @return List<SearchSeasonalSMUCostListVO>
	 * @exception EventException
	 */
	public List<SearchSeasonalSMUCostListVO> searchSeasonalSMUCostList(SearchSeasonalSMUCostListVO searchSeasonalSMUCostListVO
		                                            	,SearchConditionVO searchConditionVO) throws EventException {
		try {
			return dbDao.searchSeasonalSMUCostList(searchSeasonalSMUCostListVO, searchConditionVO);
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
	 * WeeklyCM 화면에 대한 조회 이벤트 처리<br>
	 * ESM_MAS_0121 조회
	 * @param SearchSeasonalSMUCostPopListVO searchSeasonalSMUCostPopListVO
	 * @param SearchConditionVO searchConditionVO
	 * @return List<SearchSeasonalSMUCostListVO>
	 * @exception EventException
	 */
	public List<SearchSeasonalSMUCostPopListVO> searchLaneBoundSwitchList(SearchSeasonalSMUCostPopListVO searchSeasonalSMUCostPopListVO
		                                            	,SearchConditionVO searchConditionVO) throws EventException {
		try {
			return dbDao.searchLaneBoundSwitchList(searchSeasonalSMUCostPopListVO, searchConditionVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}

	}
	/**
	 * [Bound Swith] - Seasonal SMU Cost (RA) POPUP]을 [삽입,삭제] 합니다.<br>
	 *
	 * @param MasLaneDirConvVO[] MasLaneDirConvVOs
	 * @param account SignOnUserAccount
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse multiLaneBoundSwitch(MasLaneDirConvVO[] masLaneDirConvVOs, SignOnUserAccount account) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<MasLaneDirConvVO> insertVoList = new ArrayList<MasLaneDirConvVO>();
			List<MasLaneDirConvVO> deleteVoList = new ArrayList<MasLaneDirConvVO>();
			for ( int i=0; i<masLaneDirConvVOs .length; i++ ) {
				if ( masLaneDirConvVOs[i].getIbflag().equals("I")){
					log.info("#	INSERT ");
					masLaneDirConvVOs[i].setCreUsrId(account.getUsr_id());
					masLaneDirConvVOs[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(masLaneDirConvVOs[i]);
				} else if ( masLaneDirConvVOs[i].getIbflag().equals("D")){
					deleteVoList.add(masLaneDirConvVOs[i]);
				}
			}
			if ( insertVoList.size() > 0 ) {
				dbDao.addLaneBoundSwitch(insertVoList);
			}
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeLaneBoundSwitch(deleteVoList);
			}
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return eventResponse;
	}
	/**
	 * 저장 이벤트 처리<br>
	 * WeeklyCM 화면에 대한 조회 이벤트 처리<br>
	 * ESM_MAS_0117 저장
	 * @param MasSltMgmtUtVO[] masSltMgmtUtVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void multiSMUPfmc(MasSltMgmtUtVO[] masSltMgmtUtVO, SignOnUserAccount account) throws EventException{
		try {
			List<MasSltMgmtUtVO> updateVoList = new ArrayList<MasSltMgmtUtVO>();

			for ( int i=0; i<masSltMgmtUtVO .length; i++ ) {
				 if ( masSltMgmtUtVO[i].getIbflag().equals("U")){
					  masSltMgmtUtVO[i].setCreUsrId(account.getUsr_id());
					  masSltMgmtUtVO[i].setUpdUsrId(account.getUsr_id());

					  updateVoList.add(masSltMgmtUtVO[i]);
				}
			}

			if ( updateVoList.size() > 0 ) {
				dbDao.modifySMUPfmc(updateVoList);
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
	 * ESM_MAS_0029 : 수동배치 처리 #1<br>
	 *
	 * @param SearchConditionVO searchConditionVO
	 * @param String commandId
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
    public String dailyBatch(SearchConditionVO searchConditionVO, String commandId, SignOnUserAccount account) throws EventException{
    	WeeklyCMBCBackEndJob backEndJob = new WeeklyCMBCBackEndJob();

		backEndJob.setWeeklyCMVO(searchConditionVO, commandId, account);
		BackEndJobManager backEndJobManager = new BackEndJobManager();
		try {
			return backEndJobManager.execute(backEndJob, account.getUsr_id(), "Target VVD - BSA & VVD Creation");		
        } catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
    }
    	
	/**
	 * 1. 기능 : WeeklyCM 주간 대상항차관리 화면에 대한 Create 이벤트 처리(ESM_MAS_0029)<p>
	 * 2. 처리개요 : <p>
	 *    - 주간 대상항차관리에 대한 Create처리<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @param String commandId
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */	
	public String createTSQty(SearchConditionVO searchConditionVO, String commandId, SignOnUserAccount account) throws EventException{
		WeeklyCMBCBackEndJob backEndJob = new WeeklyCMBCBackEndJob();

		backEndJob.setWeeklyCMVO(searchConditionVO, commandId, account);
		BackEndJobManager backEndJobManager = new BackEndJobManager();
		try {
			return backEndJobManager.execute(backEndJob, account.getUsr_id(), "Target VVD - Create T/S Q`ty");		
        } catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * ESM_MAS_0029 : BSA Flag가 Y인것들을 BSA VVD의 값을 0으로 만들어 준다<br>
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
			duration = yrWkduList.getCnt(); // duration : 수행 결과가 정상인지를 판별하기 위한 변수

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


    /**
	 * 조회 이벤트 처리<br>
	 * WeeklyCM 화면에 대한 조회 이벤트 처리<br>
	 * ESM_MAS_0118 조회
	 * @param SearchOwnTMLPfmcListVO searchOwnTMLPfmcListVO
	 * @param SearchConditionVO searchConditionVO
	 * @return List<SearchOwnTMLPfmcListVO>
	 * @exception EventException
	 */
	public List<SearchOwnTMLPfmcListVO> searchOwnTMLPfmcList(SearchOwnTMLPfmcListVO searchOwnTMLPfmcListVO
			                                                ,SearchConditionVO searchConditionVO) throws EventException {
		try {
			return dbDao.searchOwnTMLPfmcList(searchOwnTMLPfmcListVO, searchConditionVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}

	}

	/**
	 * 멀티 이벤트 처리<br>
	 * WeeklyCM 화면에 대한 멀티 이벤트 처리<br>
	 * ESM_MAS_0118 저장
	 * @param MasInterOwnTmlCostVO[] masInterOwnTmlCostVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void multiOwnTMLPfmc(MasInterOwnTmlCostVO[] masInterOwnTmlCostVO, SignOnUserAccount account) throws EventException{
		try {
			List<MasInterOwnTmlCostVO> updateVoList = new ArrayList<MasInterOwnTmlCostVO>();
			List<MasInterOwnTmlCostVO> insertVoList = new ArrayList<MasInterOwnTmlCostVO>();
			List<MasInterOwnTmlCostVO> deleteVoList = new ArrayList<MasInterOwnTmlCostVO>();
			
			for ( int i=0; i<masInterOwnTmlCostVO .length; i++ ) {
				 if ( masInterOwnTmlCostVO[i].getIbflag().equals("U")){
					masInterOwnTmlCostVO[i].setCreUsrId(account.getUsr_id());
					masInterOwnTmlCostVO[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(masInterOwnTmlCostVO[i]);
				} else if( masInterOwnTmlCostVO[i].getIbflag().equals("I")){
					masInterOwnTmlCostVO[i].setCreUsrId(account.getUsr_id());
					masInterOwnTmlCostVO[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(masInterOwnTmlCostVO[i]);
				} else if ( masInterOwnTmlCostVO[i].getIbflag().equals("D")){
					deleteVoList.add(masInterOwnTmlCostVO[i]);
				}
			}

			if ( updateVoList.size() > 0 ) {
				dbDao.modifyOwnTMLPfmc(updateVoList);
			}

			if ( insertVoList.size() > 0 ) {
				dbDao.modifyOwnTMLPfmc(insertVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeOwnTMLPfmc(deleteVoList);
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
	 * WeeklyCM 화면에 대한 조회 이벤트 처리<br>
	 * ESM_MAS_0119 화면 조회
	 * @param SearchUOM0119ListVO searchUOM0119ListVO
	 * @return List<SearchUOM0119ListVO>
	 * @exception EventException
	 */
	public List<SearchUOM0119ListVO> searchUOM0119List(SearchUOM0119ListVO searchUOM0119ListVO) throws EventException {
		try {
			return dbDao.searchUOM0119List(searchUOM0119ListVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}

	}

	/**
	 * 멀티 이벤트 처리<br>
	 * NWeeklyCM 화면에 대한 멀티 이벤트 처리<br>
	 * ESM_MAS_0119 화면 수정, 추가
	 * @param MasTmlTrfGrpVO[] masTmlTrfGrpVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void multiUOM0119(MasTmlTrfGrpVO[] masTmlTrfGrpVO, SignOnUserAccount account) throws EventException{
		try {
			List<MasTmlTrfGrpVO> insertVoList = new ArrayList<MasTmlTrfGrpVO>();
			List<MasTmlTrfGrpVO> updateVoList = new ArrayList<MasTmlTrfGrpVO>();
			for ( int i=0; i<masTmlTrfGrpVO .length; i++ ) {
				if ( masTmlTrfGrpVO[i].getIbflag().equals("I")){
					masTmlTrfGrpVO[i].setCreUsrId(account.getUsr_id());
					masTmlTrfGrpVO[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(masTmlTrfGrpVO[i]);
				} else if ( masTmlTrfGrpVO[i].getIbflag().equals("U")){
					masTmlTrfGrpVO[i].setUpdUsrId(account.getUsr_id());
					masTmlTrfGrpVO[i].setCreUsrId(account.getUsr_id());
					updateVoList.add(masTmlTrfGrpVO[i]);
				}
			}

			if ( insertVoList.size() > 0 ) {
				dbDao.addUOM0119(insertVoList);
			}

			if ( updateVoList.size() > 0 ) {
				dbDao.modifyUOM0119(updateVoList);
			}

		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/* ----------------------------------------------------------------------------------------------- */

	/**
	 * 조회 이벤트 처리<br>
	 * VVD Check With AR List 조회 이벤트 처리<br>
	 * ESM_MAS_0112 조회
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
	 * 저장 이벤트 처리<br>
	 * VVD Check With AR List 저장 이벤트 처리<br>
	 * ESM_MAS_0112 multi
	 * @param MasMonVvdVO[] masMonVvdVO
	 * @param SearchConditionVO searchConditionVO
	 * @param SearchVVDChkWithARListVO[] searchVVDChkWithARListVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiVVDChkWithARList(MasMonVvdVO[] masMonVvdVO, SearchConditionVO searchConditionVO, SearchVVDChkWithARListVO[] searchVVDChkWithARListVO, SignOnUserAccount account) throws EventException{
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
	 * 생성 이벤트 처리<br>
	 * NetworkCost화면에 대한 생성 이벤트 처리<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @param String userId
	 * @return EventResponse ESM_MAS_175EventResponse
	 * @exception EventException
	 */
	public EventResponse createFixCostByVVDOP4(SearchConditionVO searchConditionVO, String userId) throws EventException {
		try {
			GeneralEventResponse eventResponse = new GeneralEventResponse();
    		String inYr 		= searchConditionVO.getFYear();
    		String inFmMon 		= searchConditionVO.getFFmMon();
    		String inToMon 		= searchConditionVO.getFToMon();
    		String inFmWk 		= searchConditionVO.getFFmWk();
    		String inToWk 		= searchConditionVO.getFToWk();
    		String inMonOrWk	= searchConditionVO.getFChkprd();
    
    		String inTrdCd 		= searchConditionVO.getFTrdCd();
    		String inRlaneCd 	= searchConditionVO.getFRlaneCd();
    		String inVslCd 		= searchConditionVO.getFVslCd();
    		String inSkdVoyNo 	= searchConditionVO.getFSkdVoyNo();
    		String inDirCd 		= searchConditionVO.getFDirCd();
    		String inUserId		= userId;
    		String inIocCd 		= "";
    		String out_err_cd	= "";
    		String out_err_msg	= "";
            
            ProcedureParamVO procedureParamVO = new ProcedureParamVO();
			procedureParamVO.setInYr		(inYr);
			procedureParamVO.setInFmMon		(inFmMon);
			procedureParamVO.setInToMon		(inToMon);
			procedureParamVO.setInFmWk		(inFmWk);
			procedureParamVO.setInToWk		(inToWk);
			procedureParamVO.setInMonOrWk	(inMonOrWk);
			procedureParamVO.setInFmStep	("7");
			procedureParamVO.setInAllFlg	("N");
			procedureParamVO.setInInd		("");
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
			// 7단계 : Re-Assignment by Bound(OP4)
			resultVO = dbDao.createNtwkCostALL(procedureParamVO);
            
            if(resultVO != null){
    			
    			out_err_cd = resultVO.getOutErrCd();
    			out_err_msg = resultVO.getOutErrMsg();
                log.debug("==========================================================================");
                log.debug("createFixCostByVVDOP4 Result Error Code: " + out_err_cd);
                log.debug("createFixCostByVVDOP4 Result Error Message: " + out_err_msg);
                log.debug("==========================================================================");

                if(out_err_cd.trim().equals("00000")){
                	out_err_cd = "00000";
                	out_err_msg = "Create Success!!";  	
                }                
            }
            eventResponse.setETCData("err_cd", out_err_cd);
            eventResponse.setETCData("err_msg", out_err_msg);
            
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(new ErrorHandler(de).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
		
	/**
	 * BackEndJob의 상태값을 조회한다.<br>
	 * 
	 * @param String key
	 * @return String
	 * @exception EventException
	 */
	public String searchBackEndJobStatus(String key) throws EventException {
		DBRowSet rowSet;
		try {
			rowSet = new BackEndJobMetaDataSelector(key).getDbRowset();
			rowSet.next();
			Thread.sleep(1000);
			return (String) rowSet.getObject("jb_sts_flg");
		} catch (BackEndJobException e) {
			throw new EventException(e.getMessage());
		} catch (SQLException e) {
			throw new EventException(e.getMessage());
		} catch (InterruptedException e) {
			throw new EventException(e.getMessage());
		} catch(Exception e){
			throw new EventException(e.getMessage());
		}
	}
	
	/**
	 * 1. 기능 : SMU 단가 관리 화면에서화면에 대한 Create 이벤트 처리(ESM_MAS_0117)<p>
	 * 2. 처리개요 : <p>
	 *    - SMU 단가에 대한 Create처리<br> 
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */	
	public void createSMUPfmc(SearchConditionVO searchConditionVO, SignOnUserAccount account) throws EventException{
		HashMap<String, String> param = new HashMap<String, String>();	
		try {

			//파라미터 세팅
			param.put("f_src_mon"		, searchConditionVO.getFCostYrmon());
			param.put("f_tar_mon"		, searchConditionVO.getFCostYrmon());
            param.put("user_id"   		, account.getUsr_id());
			
			
//			 생성전에 table을 삭제 한다.
            dbDao.removeSMUPfmc(searchConditionVO.getFCostYrmon());
//			// I/F 한다
            dbDao.createSMUPfmc(searchConditionVO,account);
//			// Daily Hire Status값을 Update한다.
            dbDao.modifySMUPfmcCreationStatus(param);

		} catch (DAOException de) {
    		log.error("err " + de.toString(), de);
    		throw new EventException(new ErrorHandler("COM12192",new String[]{}).getMessage(), de);
    	} catch (Exception de) {
    		log.error("err " + de.toString(), de);
    		throw new EventException(new ErrorHandler("COM12192",new String[]{}).getMessage(), de);
    	}
	}

	
	/**
	 * SMU Cost (RA) 전월 단가를 copy 한다.<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void createSMUPfmcMonthCopy(SearchConditionVO searchConditionVO, SignOnUserAccount account) throws EventException{
		String costYrmon = searchConditionVO.getFTarMon().replaceAll("-", "");		
		HashMap<String, String> param = new HashMap<String, String>();		
		
		try {
			
			//파라미터 세팅
			param.put("f_src_mon"		, searchConditionVO.getFSrcMon().replaceAll("-", ""));
			param.put("f_tar_mon"		, costYrmon);
            param.put("user_id"   		, account.getUsr_id());

			
//			 생성전에 table을 삭제 한다.
            dbDao.removeSMUPfmc(costYrmon);
//			// SMU 를 Copy 한다
            dbDao.createSMUPfmcMonthCopy(param);
//			// SMU Status값을 Update한다.
            dbDao.modifySMUPfmcCreationStatus(param);

		} catch (DAOException de) {
    		log.error("err " + de.toString(), de);
    		throw new EventException(new ErrorHandler("COM12192",new String[]{}).getMessage(), de);
    	} catch (Exception de) {
    		log.error("err " + de.toString(), de);
    		throw new EventException(new ErrorHandler("COM12192",new String[]{}).getMessage(), de);
    	}
	}	
	
	/**
	 * 생성 이벤트 처리<br>
	 * EMU Cost를월단가를 복사해서 생성한다.<br>
	 *
	 * @param SearchConditionVO searchConditionVO
	 * @param SignOnUserAccount account
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse createEMUCostMonthCopy(SearchConditionVO searchConditionVO, SignOnUserAccount account) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		HashMap<String, String> param = new HashMap<String, String>();

		try {
			//파라미터 세팅
			param.put("f_src_mon"		, searchConditionVO.getFSrcMon().replaceAll("-", ""));
			param.put("f_tar_mon"		, searchConditionVO.getFTarMon().replaceAll("-", ""));
            param.put("user_id"   		, account.getUsr_id());

          //1. MAS_REPO_IF_MGMT테이블에서  TARGET 해당월을 삭제한다.
            dbDao.removeEMUCostMonthCopy(param);
          //2. MAS_REPO_IF_MGMT테이블에  SOURCE 해당월을 복사해서  TARGET 데이타를 생성한다.
            dbDao.createEMUCostMonthCopy(param);
          //3. 복사 상태를 단가 관리 table에 insert 한다.
            dbDao.modifyCostMonthCopyCreationStatus(param);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(new ErrorHandler(de).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}

		return eventResponse;
	}
	

	/**
	 * [EMU Credit Ratio&Amount]을 [조회] 합니다.<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @return List<MasEMUCreditListVO>
	 * @exception EventException
	 */
	public List<MasEMUCreditListVO> searchEmuCreditTableList (SearchConditionVO searchConditionVO) throws EventException{
		try {
			return dbDao.searchEmuCreditTableList(searchConditionVO);

		} catch (DAOException de) {
    		log.error("err " + de.toString(), de);
    		throw new EventException(new ErrorHandler("COM12192",new String[]{}).getMessage(), de);
    	} catch (Exception de) {
    		log.error("err " + de.toString(), de);
    		throw new EventException(new ErrorHandler("COM12192",new String[]{}).getMessage(), de);
    	}
	}	

	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 기능 : Del Credit Ratio by Port-Pair 리스트를 조회한다.(ESM_MAS_029)<p>
         * 처리개요 :Del Credit Ratio by Port-Pair 에 대한 리스트를 조회
	 * ESM_MAS_0222 화면 조회
	 * @param SearchOPCreditRtPortPairVO	searchOPCreditRtPortPairVO
	 * @param String queryType
	 * @return List<SearchOPCreditRtPortPairVO>
	 * @exception EventException
	 */
	public List<SearchOPCreditRtPortPairVO> searchCreditRtPortPairList(SearchOPCreditRtPortPairVO searchOPCreditRtPortPairVO,String queryType) throws EventException {
		try {
			return dbDao.searchCreditRtPortPairList(searchOPCreditRtPortPairVO,queryType);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}

	}	
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 기능 : Exception List Management 리스트를 조회한다.(ESM_MAS_0250)<p>
         * 처리개요 :Exception List Management 에 대한 리스트를 조회
	 * ESM_MAS_0250 화면 조회
	 * @param SearchExceptionListMgmtVO	searchExceptionListMgmtVO
	 * @param String queryType
	 * @return List<SearchExceptionListMgmtVO>
	 * @exception EventException
	 */
	public List<SearchExceptionListMgmtVO> searchExceptionListMgmtList(SearchExceptionListMgmtVO searchExceptionListMgmtVO) throws EventException {
		try {
			return dbDao.searchExceptionListMgmtList(searchExceptionListMgmtVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}

	}
	
	/**
     * 기능 : Unit Cost by Customer (Door. CY Exception) 리스트를 조회한다.(ESM_MAS_0251)<p>
     * ESM_MAS_0251 화면 조회
     * @param SearchConditionVO searchConditionVO
     * @return List<SearchUCbyCustomerListVO>
     * @exception EventException
     */
    public List<SearchUCbyCustomerListVO> searchUCbyCustomerList(SearchConditionVO searchConditionVO) throws EventException {
        try {
            return dbDao.searchUCbyCustomerList(searchConditionVO);
        } catch(DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
        }

    }
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 기능 : Chassis Cost 리스트를 조회한다.(ESM_MAS_0253)<p>
     * 처리개요 :Chassis Cost 에 대한 리스트를 조회
	 * ESM_MAS_0253 화면 조회
	 * @param SearchChassisCostVO searchChassisCostVO
	 * @param String queryType
	 * @return List<SearchChassisCostVO>
	 * @exception EventException
	 */
	public List<SearchChassisCostVO> searchChassisCostList(SearchChassisCostVO searchChassisCostVO) throws EventException {
		try {
			return dbDao.searchChassisCostList(searchChassisCostVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}

	}
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 기능 : Chassis Unit Cost 리스트를 조회한다.(ESM_MAS_0253)<p>
     * 처리개요 :Chassis Unit Cost 에 대한 리스트를 조회
	 * ESM_MAS_0253 화면 조회
	 * @param SearchChassisCostVO searchChassisCostVO
	 * @return List<SearchChassisCostVO>
	 * @exception EventException
	 */
	public List<SearchChassisCostVO> searchChassisUnitCostList(SearchChassisCostVO searchChassisCostVO) throws EventException {
		try {
			return dbDao.searchChassisUnitCostList(searchChassisCostVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}

	}
	
	/**
	 * 멀티 이벤트 처리<br>
	 * Chassis Cost 화면에 대한 멀티 이벤트 처리<br>
	 * ESM_MAS_0253 화면 수정, 추가
	 * @param SearchChassisCostVO[] searchChassisCostVOs
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void multiChassisCostList(SearchChassisCostVO[] searchChassisCostVOs, SignOnUserAccount account) throws EventException{
		try {
			List<SearchChassisCostVO> insertVoList = new ArrayList<SearchChassisCostVO>();
			List<SearchChassisCostVO> updateVoList = new ArrayList<SearchChassisCostVO>();
			List<SearchChassisCostVO> deleteVoList = new ArrayList<SearchChassisCostVO>();
			
			for ( int i=0; i<searchChassisCostVOs .length; i++ ) {
				searchChassisCostVOs[i].setUpdUsrId(account.getUsr_id());
				
				if ( searchChassisCostVOs[i].getIbflag().equals("I")){
					insertVoList.add(searchChassisCostVOs[i]);
				} else if ( searchChassisCostVOs[i].getIbflag().equals("U")){
					updateVoList.add(searchChassisCostVOs[i]);
				} else if ( searchChassisCostVOs[i].getIbflag().equals("D")){
					deleteVoList.add(searchChassisCostVOs[i]);
				}
			}

			if ( insertVoList.size() > 0 ) {
				dbDao.addChassisCostList(insertVoList);
			}

			if ( updateVoList.size() > 0 ) {
				dbDao.modifyChassisCostList(updateVoList);
			}

			if ( deleteVoList.size() > 0 ) {
				dbDao.deleteChassisCostList(deleteVoList);
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
	 * 멀티 이벤트 처리<br>
	 * Exception List Management 화면에 대한 멀티 이벤트 처리<br>
	 * ESM_MAS_0250 화면 추가, 수정, 삭제
	 * @param SearchExceptionListMgmtVO[] searchExceptionListMgmtVOs
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void multiExceptionListMgmtList(SearchExceptionListMgmtVO[] searchExceptionListMgmtVOs, SignOnUserAccount account) throws EventException{
		try {
			List<SearchExceptionListMgmtVO> insertVoList = new ArrayList<SearchExceptionListMgmtVO>();
			List<SearchExceptionListMgmtVO> updateVoList = new ArrayList<SearchExceptionListMgmtVO>();
			List<SearchExceptionListMgmtVO> deleteVoList = new ArrayList<SearchExceptionListMgmtVO>();
			
			for ( int i=0; i<searchExceptionListMgmtVOs .length; i++ ) {
				searchExceptionListMgmtVOs[i].setUpdUsrId(account.getUsr_id());
				
				if (!"".equals(searchExceptionListMgmtVOs[i].getActShprCd())) {
					String act_shpr_cd_1 = searchExceptionListMgmtVOs[i].getActShprCd().substring(0, 2);
					String act_shpr_cd_2 = searchExceptionListMgmtVOs[i].getActShprCd().substring(2);
					searchExceptionListMgmtVOs[i].setActShprCntCd(act_shpr_cd_1);
					searchExceptionListMgmtVOs[i].setActShprSeq(act_shpr_cd_2);
				} else {
					searchExceptionListMgmtVOs[i].setActShprCntCd("");
					searchExceptionListMgmtVOs[i].setActShprSeq("");
				}
				if ( searchExceptionListMgmtVOs[i].getIbflag().equals("I")){
					insertVoList.add(searchExceptionListMgmtVOs[i]);
				} else if ( searchExceptionListMgmtVOs[i].getIbflag().equals("U")){
					updateVoList.add(searchExceptionListMgmtVOs[i]);
				} else if ( searchExceptionListMgmtVOs[i].getIbflag().equals("D")){
					deleteVoList.add(searchExceptionListMgmtVOs[i]);
				}
			}

			if ( insertVoList.size() > 0 ) {
				dbDao.addExceptionListMgmtList(insertVoList);
			}

			if ( updateVoList.size() > 0 ) {
				dbDao.modifyExceptionListMgmtList(updateVoList);
			}

			if ( deleteVoList.size() > 0 ) {
				dbDao.deleteExceptionListMgmtList(deleteVoList);
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
     * 멀티 이벤트 처리<br>
     * Unit Cost by Customer (Door. CY Exception) 화면에 대한 멀티 이벤트 처리<br>
     * ESM_MAS_0251 화면 추가, 수정, 삭제
     * @param SearchUCbyCustomerListVO[] searchUCbyCustomerListVOs
     * @param account SignOnUserAccount
     * @exception EventException
     */
	public void multiUCbyCustomerList(SearchUCbyCustomerListVO[] searchUCbyCustomerListVOs, SignOnUserAccount account) throws EventException{
        try {
            List<SearchUCbyCustomerListVO> insertVoList = new ArrayList<SearchUCbyCustomerListVO>();
            List<SearchUCbyCustomerListVO> updateVoList = new ArrayList<SearchUCbyCustomerListVO>();
            List<SearchUCbyCustomerListVO> deleteVoList = new ArrayList<SearchUCbyCustomerListVO>();
            
            for ( int i=0; i<searchUCbyCustomerListVOs .length; i++ ) {
                searchUCbyCustomerListVOs[i].setUpdUsrId(account.getUsr_id());
                
                if ( searchUCbyCustomerListVOs[i].getIbflag().equals("I")){
                    insertVoList.add(searchUCbyCustomerListVOs[i]);
                } else if ( searchUCbyCustomerListVOs[i].getIbflag().equals("U")){
                    updateVoList.add(searchUCbyCustomerListVOs[i]);
                } else if ( searchUCbyCustomerListVOs[i].getIbflag().equals("D")){
                    deleteVoList.add(searchUCbyCustomerListVOs[i]);
                }
            }

            if ( insertVoList.size() > 0 ) {
                dbDao.addUCbyCustomerList(insertVoList);
            }

            if ( updateVoList.size() > 0 ) {
                dbDao.modifyUCbyCustomerList(updateVoList);
            }

            if ( deleteVoList.size() > 0 ) {
                dbDao.deleteUCbyCustomerList(deleteVoList);
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
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 기능 : Chassis 표준 단가를 구한다.(ESM_MAS_0253)<p>
     * 처리개요 :Chassis 표준 단가 산출
	 * ESM_MAS_0253 화면
	 * @param SearchChassisCostVO[] searchChassisCostVOs
	 * @param account SignOnUserAccount
	 * @return SearchChassisCostVO
	 * @exception EventException
	 */
	/*public SearchChassisCostVO searchChassisStandardCostCreate(SearchChassisCostVO[] searchChassisCostVOs, SignOnUserAccount account) throws EventException{
		try {			
			SearchChassisCostVO vo = new SearchChassisCostVO();
			
			for ( int i=0; i<searchChassisCostVOs .length; i++ ) {

				if (searchChassisCostVOs[i].getDelChk().equals("1")) {
					
					vo.setCostYr(searchChassisCostVOs[i].getCostYr());
					vo.setCostQtrCd(searchChassisCostVOs[i].getCostQtrCd());
					vo.setEffFmYrmon(searchChassisCostVOs[i].getEffFmYrmon());
					vo.setEffToYrmon(searchChassisCostVOs[i].getEffToYrmon());
					
					break;
				}
			}			
			vo = dbDao.searchChassisStandardCostCreate(vo);

			return vo;
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}*/
	public String searchChassisStandardCostCreate(SearchChassisCostVO searchChassisCostVO, SignOnUserAccount account) throws EventException {
		String pErrorCode = "";		
	    CreateChassisUnitCostBackEndJob backEndJob = new CreateChassisUnitCostBackEndJob();
	    backEndJob.setPgmNo("ESM_MAS_0253");
        String resultStr = "";
        
        backEndJob.setSearchChassisCostVO(searchChassisCostVO);
        backEndJob.setAccount(account);
        BackEndJobManager backEndJobManager = new BackEndJobManager();
        resultStr = backEndJobManager.execute(backEndJob , account.getUsr_id(), "CreateChassisUnitCostBackEndJob BackEndJob");
 
             
		return resultStr;
    }
	
	/**
	 * Chassis Cost Create BATCH 가 실행중인지를 check 한다.
	 * 
	 * @return String
	 * @throws EventException
	 */
	public String checkChassisCostCreateBatchStatus() throws EventException {
		String batchRunning ="C";
		try {
			List<MasUtCostCreStsVO> list = dbDao.checkChassisCostCreateBatchStatus();			
			// 돌고 있는 batch 가 있다
			if (list.size() > 0) { 
				batchRunning = "P";
			}		
		} catch (DAOException e) {
			log.error("err "+e.toString(),e);
			throw new EventException(new ErrorHandler("COM12213", new String[]{"Chassis Cost Create BATCH STATUS CHECK"}).getMessage(),e);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return batchRunning;
	}
	
	/**
	 * Chassis Cost Create BATCH status 를 생성한다. <br>
	 * 
	 * @param SearchChassisCostVO[] searchChassisCostVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void addChassisCostCreateBatchStatus(SearchChassisCostVO[] searchChassisCostVOs, SignOnUserAccount account) throws EventException{
		try{
			List<SearchChassisCostVO> createVOList = new ArrayList<SearchChassisCostVO>();
			
			// shipper 를 user id 담기 위해 사용
			for (int i=0; i<searchChassisCostVOs.length; i++) {
				if (searchChassisCostVOs[i].getIbflag().equals("U")) {
					searchChassisCostVOs[i].setUpdUsrId(account.getUsr_id());
					createVOList.add(searchChassisCostVOs[i]);
				}
			}
			dbDao.addChassisCostCreateBatchStatus(createVOList);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12203", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12203", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * Chassis Cost Create BATCH 를 수행한다. <br>
	 * 
	 * @param SearchChassisCostVO[] searchChassisCostVOs
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String createChassisCost(SearchChassisCostVO[] searchChassisCostVOs, SignOnUserAccount account) throws EventException {	
		ScheduleUtil su = new ScheduleUtil();
        String params = "";
		String inFmStep = "";
//log.info(searchConditionVO.getFCmdtCd());
		try {
			for (int i=0; i<searchChassisCostVOs.length; i++) {
//				if (searchChassisCostVOs[i].getDelChk().equals("1")) {
//					searchChassisCostVOs[i].setUpdUsrId(account.getUsr_id());
//					
//					params = searchChassisCostVOs[i].getCostYr()
//							+ "#" + searchChassisCostVOs[i].getCostQtrCd()
//							+ "#" + searchChassisCostVOs[i].getEffFmYrmon()
//							+ "#" + searchChassisCostVOs[i].getEffToYrmon();
//				}
			}
			log.debug("==============>:"+params);
			su.directExecuteJob("ESM_MAS_B011",params);

		} catch (IOException e) {
			log.error("err "+e.toString(),e);
			throw new EventException(new ErrorHandler("COM12213", new String[]{"Chassis Cost Creation"}).getMessage(),e);
		} catch (InterruptedException e) {
			log.error("err "+e.toString(),e);
			throw new EventException(new ErrorHandler("COM12213", new String[]{"Chassis Cost Creation"}).getMessage(),e);
		} catch (DAOException e) {
			log.error("err "+e.toString(),e);
			throw new EventException(new ErrorHandler("COM12213", new String[]{"Chassis Cost Creation"}).getMessage(),e);
		} catch (Exception e){
			log.error("err "+e.toString(),e);
			throw new EventException(new ErrorHandler("COM12213", new String[]{"Chassis Cost Creation"}).getMessage(),e);
		}
		return "R";//실행 성공
	}
	
	/**
	 * [DEM/DET Cost Daily Batch Result]를 [조회] 합니다.<br>
	 * ESM_MAS_0271 화면 조회
	 * @param DemDetCostDayBatRstVO demDetCostDayBatRstVO
	 * @return List<MasEMUCreditListVO>
	 * @exception EventException
	 */
	public List<DemDetCostDayBatRstVO> searchDemDetCostDayBatRstList (DemDetCostDayBatRstVO demDetCostDayBatRstVO) throws EventException{
		try {
			return dbDao.searchDemDetCostDayBatRstList(demDetCostDayBatRstVO);

		} catch (DAOException de) {
    		log.error("err " + de.toString(), de);
    		throw new EventException(new ErrorHandler("COM12192",new String[]{}).getMessage(), de);
    	} catch (Exception de) {
    		log.error("err " + de.toString(), de);
    		throw new EventException(new ErrorHandler("COM12192",new String[]{}).getMessage(), de);
    	}
	}
	
	/**
	 * ESM_MAS_0275 조회<br>
	 * 
	 * @param DemDetCostRepbyBKGVO demDetCostRepbyBKGVO
	 * @return List<DemDetCostRepbyBKGVO>
	 * @exception EventException
	 */
	public List<DemDetCostRepbyBKGVO> searchDemDetCostRepbyBKGList(DemDetCostRepbyBKGVO demDetCostRepbyBKGVO) throws EventException {
		try {			
			return dbDao.searchDemDetCostRepbyBKGList(demDetCostRepbyBKGVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * ESM_MAS_0275 - Save<br>
	 * @param DemDetCostRepbyBKGVO[] demDetCostRepbyBKGVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiDemDetCostRepbyBKG(DemDetCostRepbyBKGVO[] demDetCostRepbyBKGVOs, SignOnUserAccount account) throws EventException {		
		try {			
			List<DemDetCostRepbyBKGVO> insertVoList = new ArrayList<DemDetCostRepbyBKGVO>();
			List<DemDetCostRepbyBKGVO> updateVoList = new ArrayList<DemDetCostRepbyBKGVO>();
			List<DemDetCostRepbyBKGVO> deleteVoList = new ArrayList<DemDetCostRepbyBKGVO>();
			for ( int i=0; i<demDetCostRepbyBKGVOs.length; i++ ) {
				demDetCostRepbyBKGVOs[i].setCreUsrId(account.getUsr_id());
				demDetCostRepbyBKGVOs[i].setUpdUsrId(account.getUsr_id());
				
				if ( demDetCostRepbyBKGVOs[i].getIbflag().equals("I")){
					demDetCostRepbyBKGVOs[i].setTaxPct(demDetCostRepbyBKGVOs[i].getTaxPct().replaceAll("%", ""));					
					insertVoList.add(demDetCostRepbyBKGVOs[i]);
				} else if ( demDetCostRepbyBKGVOs[i].getIbflag().equals("U")){					
					demDetCostRepbyBKGVOs[i].setTaxPct(demDetCostRepbyBKGVOs[i].getTaxPct().replaceAll("%", ""));
					updateVoList.add(demDetCostRepbyBKGVOs[i]);
				} else if ( demDetCostRepbyBKGVOs[i].getIbflag().equals("D")){
					deleteVoList.add(demDetCostRepbyBKGVOs[i]);
				}			
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addDemDetCostRepbyBKG(insertVoList);
			}
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyDemDetCostRepbyBKG(updateVoList);
			}
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeDemDetCostRepbyBKG(deleteVoList);
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
	 * ESM_MAS_0274 - 조회<br>
	 * @param StorageCalExcepNodeVO storageCalExcepNodeVO
	 * @return List<StorageCalExcepNodeVO>
	 * @exception EventException
	 */
	public List<StorageCalExcepNodeVO> searchStorageCalExcepNode(StorageCalExcepNodeVO storageCalExcepNodeVO) throws EventException {
		try {			
			return dbDao.searchStorageCalExcepNode(storageCalExcepNodeVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * ESM_MAS_0274 - Save<br>
	 * @param StorageCalExcepNodeVO[] storageCalExcepNodeVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiStorageCalExcepNode(StorageCalExcepNodeVO[] storageCalExcepNodeVOs, SignOnUserAccount account) throws EventException {		
		try {			
			List<StorageCalExcepNodeVO> insertVoList = new ArrayList<StorageCalExcepNodeVO>();
			List<StorageCalExcepNodeVO> updateVoList = new ArrayList<StorageCalExcepNodeVO>();
			List<StorageCalExcepNodeVO> deleteVoList = new ArrayList<StorageCalExcepNodeVO>();
			for ( int i=0; i<storageCalExcepNodeVOs.length; i++ ) {
				storageCalExcepNodeVOs[i].setCreUsrId(account.getUsr_id());
				storageCalExcepNodeVOs[i].setUpdUsrId(account.getUsr_id());
				
				if ( storageCalExcepNodeVOs[i].getIbflag().equals("I")){
					//storageCalExcepNodeVOs[i].setTaxPct(storageCalExcepNodeVOs[i].getTaxPct().replaceAll("%", ""));					
					insertVoList.add(storageCalExcepNodeVOs[i]);
				} else if ( storageCalExcepNodeVOs[i].getIbflag().equals("U")){					
					//storageCalExcepNodeVOs[i].setTaxPct(storageCalExcepNodeVOs[i].getTaxPct().replaceAll("%", ""));
					updateVoList.add(storageCalExcepNodeVOs[i]);
				} else if ( storageCalExcepNodeVOs[i].getIbflag().equals("D")){
					deleteVoList.add(storageCalExcepNodeVOs[i]);
				}			
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addStorageCalExcepNode(insertVoList);
			}
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyStorageCalExcepNode(updateVoList);
			}
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeStorageCalExcepNode(deleteVoList);
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
	 * Include Sub Office Code를 가져옴<br>
	 * ESM_MAS_0274
	 * @param storageCalExcepNodeVO
	 * @return List<StorageCalExcepNodeVO>
	 * @throws com.hanjin.framework.core.layer.event.EventException
	 */
	@Override
	public List<StorageCalExcepNodeVO> searchSubOfficeSOManageList(StorageCalExcepNodeVO storageCalExcepNodeVO) throws EventException {
		try{
			return dbDao.searchSubOfficeSOManageList(storageCalExcepNodeVO);
		}catch(DAOException ex){
			throw new EventException(ex.getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}
	
	/**
	 * Sheet Auto Set<br>
	 * ESM_MAS_0274
	 * @param storageCalExcepNodeVO
	 * @return List<StorageCalExcepNodeVO>
	 * @throws com.hanjin.framework.core.layer.event.EventException
	 */
	@Override
	public List<StorageCalExcepNodeVO> searchYardCodeNameOfficeList(StorageCalExcepNodeVO storageCalExcepNodeVO) throws EventException {
		try{
			return dbDao.searchYardCodeNameOfficeList(storageCalExcepNodeVO);
		}catch(DAOException ex){
			throw new EventException(ex.getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}
	
	/**
	 * ESM_MAS_0272 - Search<br>
	 * @param FullStorageDailyCalcVO fullStorageDailyCalcVO
	 * @return List<FullStorageDailyCalcVO>
	 * @throws EventException
	 */
	public List<FullStorageDailyCalcVO> searchFullStorageDailyCalcList(FullStorageDailyCalcVO fullStorageDailyCalcVO) throws EventException {
	    String[] ctrtOfcCd1Arr	= null;
		String ctrtOfcCd1 		= "";
		try{
			//Contract Office Code #1
			ctrtOfcCd1Arr = fullStorageDailyCalcVO.getOfcCd().split(",");
			for( int idx=0; idx<ctrtOfcCd1Arr.length; idx++ ){
				if( idx == 0 && !ctrtOfcCd1Arr[idx].equals("") ){
					ctrtOfcCd1 = "'" + ctrtOfcCd1Arr[idx] + "'";
//					ctrtOfcCd1 = ctrtOfcCd1Arr[idx];
				} else if( idx > 0 ){
					ctrtOfcCd1 = ctrtOfcCd1 + ",'" + ctrtOfcCd1Arr[idx] + "'";
//					ctrtOfcCd1 = ctrtOfcCd1 + "','" + ctrtOfcCd1Arr[idx];
				}
			}
			fullStorageDailyCalcVO.setOfcCd(ctrtOfcCd1);
			return dbDao.searchFullStorageDailyCalcList(fullStorageDailyCalcVO);
		}catch(DAOException ex){
			throw new EventException(ex.getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}
	
	/**
	 * Office 의 Sub Office 조회
	 *
	 * @param String ofcCd
	 * @return String
	 * @throws EventException
	 */
	public String searchSubOfficeList(String ofcCd) throws EventException {
		try {
			String subOfcCdArr[] = dbDao.searchSubOfficeList(ofcCd);
			String subOfcCd = "";
			
			if(subOfcCdArr != null){
				for( int idx = 0; idx < subOfcCdArr.length; idx++ ){
					subOfcCd = subOfcCd.concat(",").concat(subOfcCdArr[idx]);
				}
			}
			return subOfcCd;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * ESM_MAS_0223 - 조회<br>
	 * @param OnewayCntrUploadVO onewayCntrUploadVO
	 * @return List<OnewayCntrUploadVO>
	 * @exception EventException
	 */
	public List<OnewayCntrUploadVO> searchOnewayCntrUpload(OnewayCntrUploadVO onewayCntrUploadVO) throws EventException {
		try {			
			return dbDao.searchOnewayCntrUpload(onewayCntrUploadVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * ESM_MAS_0223 - Save<br>
	 * @param OnewayCntrUploadVO[] onewayCntrUploadVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiOnewayCntrUpload(OnewayCntrUploadVO[] onewayCntrUploadVOs, SignOnUserAccount account) throws EventException {		
		try {			
			List<OnewayCntrUploadVO> insertVoList = new ArrayList<OnewayCntrUploadVO>();
			List<OnewayCntrUploadVO> updateVoList = new ArrayList<OnewayCntrUploadVO>();
			List<OnewayCntrUploadVO> deleteVoList = new ArrayList<OnewayCntrUploadVO>();
			for ( int i=0; i<onewayCntrUploadVOs.length; i++ ) {
				onewayCntrUploadVOs[i].setCreUsrId(account.getUsr_id());
				onewayCntrUploadVOs[i].setUpdUsrId(account.getUsr_id());
				
				if ( onewayCntrUploadVOs[i].getIbflag().equals("I")){
					//storageCalExcepNodeVOs[i].setTaxPct(storageCalExcepNodeVOs[i].getTaxPct().replaceAll("%", ""));					
					insertVoList.add(onewayCntrUploadVOs[i]);
				} else if ( onewayCntrUploadVOs[i].getIbflag().equals("U")){					
					//storageCalExcepNodeVOs[i].setTaxPct(storageCalExcepNodeVOs[i].getTaxPct().replaceAll("%", ""));
					updateVoList.add(onewayCntrUploadVOs[i]);
				} else if ( onewayCntrUploadVOs[i].getIbflag().equals("D")){
					deleteVoList.add(onewayCntrUploadVOs[i]);
				}			
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addOnewayCntrUpload(insertVoList);
//				dbDao.modifyOnewayBkgCostUploadSmry(insertVoList);	//BKG 번호에 대한 계정별('51102000','51302000','92202011','51801011','92801011') 비용을 0으로 변경 - MAS_BKG_COST_SMRY 테이블
//				dbDao.modifyOnewayBkgCostUploadGrpSmry(insertVoList);	//BKG 번호에 대한 계정별('51102000','51302000','92202011','51801011','92801011') 비용을 0으로 변경 - MAS_BKG_COST_ACT_GRP_SMRY 테이블
//				dbDao.modifyOnewayBkgCostUploadSrcDtl(insertVoList);	//BKG 번호에 대한 계정별('51102000','51302000','92202011','51801011','92801011') 비용을 0으로 변경 - MAS_BKG_COST_SRC_DTL 테이블
				dbDao.addOnewayBkgCostCalc(insertVoList);	//BKG 번호에 대하여 비용 재계산 되도록 일배치(MAS_BKG_COST_CALC) 테이블에 저장
			}
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyOnewayCntrUpload(updateVoList);
//				dbDao.modifyOnewayBkgCostUploadSmry(insertVoList);	//BKG 번호에 대한 계정별('51102000','51302000','92202011','51801011','92801011') 비용을 0으로 변경 - MAS_BKG_COST_SMRY 테이블
//				dbDao.modifyOnewayBkgCostUploadGrpSmry(insertVoList);	//BKG 번호에 대한 계정별('51102000','51302000','92202011','51801011','92801011') 비용을 0으로 변경 - MAS_BKG_COST_ACT_GRP_SMRY 테이블
//				dbDao.modifyOnewayBkgCostUploadSrcDtl(insertVoList);	//BKG 번호에 대한 계정별('51102000','51302000','92202011','51801011','92801011') 비용을 0으로 변경 - MAS_BKG_COST_SRC_DTL 테이블
				dbDao.addOnewayBkgCostCalc(updateVoList);	//BKG 번호에 대하여 비용 재계산 되도록 일배치(MAS_BKG_COST_CALC) 테이블에 저장
			}
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeOnewayCntrUpload(deleteVoList);
				dbDao.addOnewayBkgCostCalc(deleteVoList);	//BKG 번호에 대하여 비용 재계산 되도록 일배치(MAS_BKG_COST_CALC) 테이블에 저장
			}
			
//			dbDao.addOnewayBkgCostCalc(deleteVoList);	//BKG 번호에 대하여 비용 재계산 되도록 일배치(MAS_BKG_COST_CALC) 테이블에 저장

		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * ESM_MAS_0006 - 조회<br>
	 * @param OfcRoleSetupVO ofcRoleSetupVO
	 * @return List<OfcRoleSetupVO>
	 * @exception EventException
	 */
	public List<OfcRoleSetupVO> searchOfcRoleSetup(OfcRoleSetupVO ofcRoleSetupVO) throws EventException {
		try {			
			return dbDao.searchOfcRoleSetup(ofcRoleSetupVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * ESM_MAS_0006 - Save<br>
	 * @param OfcRoleSetupVO[] ofcRoleSetupVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiOfcRoleSetup(OfcRoleSetupVO[] ofcRoleSetupVOs, SignOnUserAccount account) throws EventException {		
		try {			
			List<OfcRoleSetupVO> insertVoList = new ArrayList<OfcRoleSetupVO>();
			List<OfcRoleSetupVO> updateVoList = new ArrayList<OfcRoleSetupVO>();
			List<OfcRoleSetupVO> deleteVoList = new ArrayList<OfcRoleSetupVO>();
			for ( int i=0; i<ofcRoleSetupVOs.length; i++ ) {
				ofcRoleSetupVOs[i].setCreUsrId(account.getUsr_id());
				ofcRoleSetupVOs[i].setUpdUsrId(account.getUsr_id());
				
				if ( ofcRoleSetupVOs[i].getIbflag().equals("I")){										
					insertVoList.add(ofcRoleSetupVOs[i]);
				} else if ( ofcRoleSetupVOs[i].getIbflag().equals("U")){
					updateVoList.add(ofcRoleSetupVOs[i]);
				} else if ( ofcRoleSetupVOs[i].getIbflag().equals("D")){
					deleteVoList.add(ofcRoleSetupVOs[i]);
				}			
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addOfcRoleSetup(insertVoList);
			}
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyOfcRoleSetup(updateVoList);
			}
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeOfcRoleSetup(deleteVoList);
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
	 * ESM_MAS_0279 - 조회<br>
	 * @param DEMDETCostReportbyBKGDetailVO dEMDETCostReportbyBKGDetailVO
	 * @return List<DEMDETCostReportbyBKGDetailVO>
	 * @exception EventException
	 */
	public List<DEMDETCostReportbyBKGDetailVO> searchDEMDETCostReportbyBKGDetail(DEMDETCostReportbyBKGDetailVO dEMDETCostReportbyBKGDetailVO) throws EventException {
		try {			
			return dbDao.searchDEMDETCostReportbyBKGDetail(dEMDETCostReportbyBKGDetailVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * ESM_MAS_0276 - 조회<br>
	 * @param DemDetCostReportbyBKGVO DemDetCostReportbyBKGVO
	 * @return List<DemDetCostReportbyBKGVO>
	 * @exception EventException
	 */
	public List<DemDetCostReportbyBKGVO> searchDemDetCostReportbyBKG(DemDetCostReportbyBKGVO demDetCostReportbyBKGVO) throws EventException {
		try {			
			return dbDao.searchDemDetCostReportbyBKG(demDetCostReportbyBKGVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * ESM_MAS_0277 - 조회<br>
	 * @param DemDetCostReportbyCustomerVO DemDetCostReportbyCustomerVO
	 * @return List<DemDetCostReportbyCustomerVO>
	 * @exception EventException
	 */
	public List<DemDetCostReportbyCustomerVO> searchDemDetCostReportbyCustomer(DemDetCostReportbyCustomerVO demDetCostReportbyCustomerVO) throws EventException {
		try {			
			return dbDao.searchDemDetCostReportbyCustomer(demDetCostReportbyCustomerVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * ESM_MAS_0273 - 조회<br>
	 * @param ChassisCostReportVO chassisCostReportVO
	 * @return List<ChassisCostReportVO>
	 * @exception EventException
	 */
	public List<ChassisCostReportVO> searchChassisCostReport(ChassisCostReportVO chassisCostReportVO) throws EventException {
		try {			
			return dbDao.searchChassisCostReport(chassisCostReportVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
}
