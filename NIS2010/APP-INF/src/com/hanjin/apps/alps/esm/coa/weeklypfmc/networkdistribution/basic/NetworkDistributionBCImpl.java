/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : NetworkDistributionBCImpl.java
 *@FileTitle : Network Distribution BC Impl
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2006-11-28
 *@LastModifier : KimJongBeom
 *@LastVersion : 1.0
 * 2006-11-28 KimJongBeom
 * 1.0 최초 생성
 * =========================================================
* History
* 2008.07.22 전윤주 N200807218173 Commercial Base U/C 화면 추가 
* 2009.09.24 임옥영 Ticket ID:CHM-200900832 CNTR BU 수지분석 기준 변경(Vessel Pool 및 표준원가 반영)
* 2009.09.30 김기대 0045 화면 New FrameWork 적용
* 2009.09.30 김기대 0047 화면 New FrameWork 적용
* 2009.09.30 김기대 0125 화면 New FrameWork 적용
* 2009.09.30 김기대 0106 화면 New FrameWork 적용
* 2009.09.30 김기대 0154 화면 New FrameWork 적용
* 2009.09.30 김기대 0159 화면 New FrameWork 적용
* 2010.01.05 박은주  대상항차 프로시저 변경으로 소스 수정
* 2010.02.05 임옥영 품질검토 결과 반영 (변수 이름은 소문자로 시작한다.dbDao_ntAll->dbDaoNtAll)
* 2009.12.09 최인경  Ticket ID:CHM-200901816 남북항로(SNT) 운항 변/고정비 배부를 위한 T/S Logic신규 개발 
*                                           로 인한 TS ALLOCATION(SNT)화면(ESM_COA_176) 추가
* 2010.02.05 이행지 Ticket ID:CHM-201002501 남북항로 시스템 조회 기능 수정요청
* 2010.02.10 박은주 Ticket ID:CHM-201002364 Vessel Pool 및 OP4 logic 보완 요청
* 2010.02.19 이행지 Ticket ID:CHM-201002398 Split 01-Vessel Pool 및 OP4 logic 보완 요청
* 2010.09.10 박은주 Ticket ID:CHM-201005891 Missing Check시 BSA Zero Flag = N 것을 대상으로 하도록 변경
*                                          Missing Check 하때 검색조건에 대한 매핑정보가 잘못되어 있어서 함께 수정
* 2010.10.01 김기종 Ticket ID:CHM-201006017-01[COA] 아주 노선 선복사용량에 대한 원양으로의 운항 변고정비 배부 로직(약정율) 추가 요청                                          
* 2010.10.22 이행지 [CHM-201006375-01][COA] Trunk IPC와 Ocean간 내부거래 신규 추가 
* 2011.05.26 최성민 [CHM-201006017-01] COA 약정율 로직 추가 - 테이블 변경으로 인한 VO 명 변경
* 2013.01.29 서미진 [CHM-201322638] 한 주차만 생성 가능하던 로직을 여러 주차 생성 가능하도록 신규 배치 생성으로 변경
* 2014.03.25 최성민 [CHM-201429403-01] [COA] Apply to P&L시 전 OP view에 대해서 장기주차 가능하도록 수정
 =========================================================*/

package com.hanjin.apps.alps.esm.coa.weeklypfmc.networkdistribution.basic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.hanjin.apps.alps.esm.coa.common.vo.ProcedureParamVO;
import com.hanjin.apps.alps.esm.coa.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.networkdistribution.integration.NetworkDistributionDBDAO;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.networkdistribution.vo.AllocResultCommitListVO;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.networkdistribution.vo.NetworkDistributionCommonVO;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.networkdistribution.vo.SearchFixCostDistListVO;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.networkdistribution.vo.SearchFixCostDistNewListVO;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.networkdistribution.vo.SearchFixCostDistResultListVO;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.networkdistribution.vo.SearchFixCostSntListVO;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.networkdistribution.vo.SearchHJSSalesAmountListVO;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.networkdistribution.vo.SearchLaneTSCommitmentListVO;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.networkdistribution.vo.SearchLaneTSUnitCostListVO;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.networkdistribution.vo.SearchMissingStatusVO;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.networkdistribution.vo.SearchSpcChtrRevMssListVO;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.weeklycm.integration.WeeklyCMDBDAO;
import com.hanjin.framework.component.backend.core.BackEndJobManager;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.CoaFxAmtDtrbVO;
import com.hanjin.syscommon.common.table.CoaLaneRgstVO;
import com.hanjin.syscommon.common.table.CoaLaneTsBsaCmmtVO;
import com.hanjin.syscommon.common.table.CoaLaneTsUtCostVO;
import com.hanjin.syscommon.common.table.CoaUtCostCreStsVO;
import com.hanjin.syscommon.common.util.ScheduleUtil;

/**
 * enis-WeeklyPFMC Business Logic Basic Command implementation<br>
 * - enis-WeeklyPFMC에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author KimJongBeom
 * @see EventResponse,NetworkDistributionBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */

public class NetworkDistributionBCImpl extends BasicCommandSupport implements NetworkDistributionBC {

	private transient NetworkDistributionDBDAO dbDao = null;
	private transient WeeklyCMDBDAO dbDaoNtAll = null;	//Nt cost All Procedure사용을 위해 BY LHI 2007.07.23	

	/**
	 * NetworkDistributionBCImpl 객체를 생성<br>
	 * NetworkDistributionDBDAO를  생성한다.<br>
	 */
	public NetworkDistributionBCImpl() {
		dbDao = new NetworkDistributionDBDAO();
		dbDaoNtAll = new WeeklyCMDBDAO();			
	}


	/**
	 * 조회 이벤트 처리<br>
	 * NetworkDistribution화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param SearchConditionVO searchVo
	 * @param SignOnUserAccount account
	 * @return List<SearchHJSSalesAmountListVO>
	 * @exception EventException
	 */
    public List<SearchHJSSalesAmountListVO> searchHJSSalesAmountList(SearchConditionVO searchVO, SignOnUserAccount account) throws EventException {
    	
        try {
            return dbDao.searchHJSSalesAmountList(searchVO);
        } catch (DAOException ex) {
            log.error("err "+ex.toString(),ex);
            throw new EventException(ex.getMessage(),ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(),ex);
        }
    }	

	/**
	 * 생성 이벤트 처리<br>
	 * NetworkDistribution화면에 대한 생성 이벤트 처리<br>
	 * 
	 * @param SearchConditionVO searchVo
	 * @param NetworkDistributionCommonVO vo
	 * @param SignOnUserAccount account
	 * @return EventResponse
	 * @exception EventException
	 */
    public EventResponse createHJSSalesAmount(SearchConditionVO searchVo, NetworkDistributionCommonVO vo, SignOnUserAccount account) throws EventException{
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
			// 현재 화면에서 chkPrevCre = "N" 되어 있어 coaCreateNtwkCostALL 만 실행됨
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
            // HJS
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
			
			
			//[DB 실행]      
            List<SearchMissingStatusVO> list = dbDao.searchMissingStatus(vo);
            int mssCnt = 0;
            if(list.size() > 0){
            	mssCnt = Integer.parseInt(((SearchMissingStatusVO)list.get(0)).getMssCnt());
            }
            
			// Procedure 콜하는 순서 지정
			if (fOpView.equals("OP1")){
				step = "5";
			}else if(fOpView.equals("OP4")){
				step = "11";
			}

			if (mssCnt == 0) {
				mss_chk_flg = "Y";

				// 2009.09.15 파라메타 vo방식으로 변경 		--------------------------------- START		
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
				
				// 5단계 : HJS Sales/Slot Cht-out 
				//Month 와 Week 처리 각각 처리하게 함. 
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
						// HJS Sales/Slot Cht-out 생성시 에러 있으면 
						vo.setErrorCode(out_err_cd);
						vo.setErrorMsg(out_err_msg);
					} else {
						// 다른 에러 일때  
            			vo.setErrorCode(out_err_cd);
            			vo.setErrorMsg(new ErrorHandler("COA00025", out_err_msg).getMessage());
            			throw new DAOException(new ErrorHandler("COA00025",out_err_cd).getMessage());
					}
				}
			} else {
				// Network cost 의 Missing이 존재시 
				String[] errMessage = { "", "" };

				vo.setErrorCode("COA00023");
				log.debug(new ErrorHandler("COA00023", errMessage).getMessage()
						+"\nYou have to check the network cost at Network Cost by VVD");
				vo.setErrorMsg(new ErrorHandler("COA00023", errMessage).getMessage()
						+"\nYou have to check the network cost at Network Cost by VVD");

				log.debug("==========================================================================");
				log.debug("createHJSSalesAmount Result :: " + vo.getErrorCode());
				log.debug("createHJSSalesAmount Result :: " + vo.getErrorMsg());
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
	 * 조회 이벤트 처리<br>
	 * NetworkDistribution화면에 대한 조회 이벤트 처리<br>
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
	 * T/S Allocation2 조회<br>
	 * 
	 * @param SearchConditionVO searchVo
	 * @param SignOnUserAccount account
	 * @return List<SearchFixCostDistNewListVO>
	 * @exception EventException
	 */
	public List<SearchFixCostDistNewListVO> searchFixCostDistNewList(SearchConditionVO searchVo, SignOnUserAccount account) throws EventException {
        try {
            return dbDao.searchFixCostDistNewList(searchVo);
        } catch (DAOException ex) {
            log.error("err "+ex.toString(),ex);
            throw new EventException(ex.getMessage(),ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(),ex);
        }
    }	

	/**
	 * 생성 이벤트 처리<br>
	 * NetworkDistribution화면에 대한 생성 이벤트 처리<br>
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
		String f_op_view	= "";
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
			f_op_view	= searchVo.getFOpView();
				
			// 6단계 : TS 배부 OR 8단계:TS 배부(Op4)  12 단계 : 약정율 적용 OP5, 13 단계 : 약정율 적용 OP6 
			mss_chk_flg = "Y";
			if (f_op_view.equals("OP4")){
				if (searchVo.getFCmdtCd().equalsIgnoreCase("EsmCoa0047Event")){
					inFmStep="8";
				}else if (searchVo.getFCmdtCd().equalsIgnoreCase("EsmCoa0050Event")){
					inFmStep="13";
				}
			}else{
				if (searchVo.getFCmdtCd().equalsIgnoreCase("EsmCoa0047Event")){
					inFmStep="6";
				}else if (searchVo.getFCmdtCd().equalsIgnoreCase("EsmCoa0050Event")){
					inFmStep="12";
				}
			}
			// 2009.09.15 파라메타 vo방식으로 변경 		--------------------------------- START		
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
					// 다른 에러 일때  
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
	 * 조회 이벤트 처리<br>
	 * NetworkDistribution화면에 대한 조회 이벤트 처리<br>
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
            
            if (!searchVo.getFOpView().equals("")){
                qParam.put("f_op_view", searchVo.getFOpView());
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
            vParam.put("f_op_view"   , searchVo.getFOpView()   );
            vParam.put("f_inout"   	 , searchVo.getFInout()   );
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
	 * Allocation Results(Commitment base) 조회 <br>
	 * 
	 * @param SearchConditionVO searchVo
	 * @return List<AllocResultCommitListVO>
	 * @exception EventException
	 */
	public List<AllocResultCommitListVO> searchAllocResultCommitList(SearchConditionVO searchVo) throws EventException {
		
		try{
			return dbDao.searchAllocResultCommitList(searchVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12203", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12203", new String[] {}).getMessage(), ex);
		}
	}


    /**
     * Apply to P/L <br>
     *
	 * @param SearchConditionVO searchVo
	 * @param NetworkDistributionCommonVO vo
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
     */
	public String applyToPL(SearchConditionVO searchVo, NetworkDistributionCommonVO vo, SignOnUserAccount account) throws EventException{
		NetworkDistributionBackEndJob backEndJob = new NetworkDistributionBackEndJob();

		backEndJob.setNetworkVO(searchVo, vo, account);
		BackEndJobManager backEndJobManager = new BackEndJobManager();
		try {
			return backEndJobManager.execute(backEndJob, account.getUsr_id(), "Allocation Results - Apply to P/L");		
        } catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
    }
	
//
//	/**
//	 * ESM_COA_106: APPLY 이벤트 처리<br>
//	 * NetworkDistribution화면에 대한 APPLY 이벤트 처리<br>
//	 * 
//	 * @param SearchConditionVO searchVo
//	 * @param NetworkDistributionCommonVO vo
//	 * @param SignOnUserAccount account
//	 * @return EventResponse
//	 * @exception DAOException
//	 */
//    public EventResponse applyToPL(SearchConditionVO searchVo, NetworkDistributionCommonVO vo, SignOnUserAccount account) throws EventException{
//        try{
//            List createList  = new ArrayList();
//            List createList2 = new ArrayList();
//            List createList3 = new ArrayList();
//            List updateList  = new ArrayList();
//
//            //
//            //----------------------------------------------------
//            HashMap<String, String> param = new HashMap<String, String>();
//            if (!searchVo.getFSeltrade().equals("")){
//                param.put("trd_cd", searchVo.getFSeltrade());
//            }
//            if (!searchVo.getFSelrlane().equals("")){
//                param.put("rlane_cd", searchVo.getFSelrlane());
//            }
//            if (!searchVo.getFSelioc().equals("")){
//                param.put("ioc_cd", searchVo.getFSelioc());
//            }
//            if (!searchVo.getFVslCd().equals("")){
//                param.put("vsl_cd", searchVo.getFVslCd());
//            }
//            if (!searchVo.getFSkdVoyNo().equals("")){
//                param.put("skd_voy_no", searchVo.getFSkdVoyNo());
//            }
//            if (!searchVo.getFDirCd().equals("")){
//                param.put("dir_cd", searchVo.getFDirCd());
//            }
//            if (searchVo.getFChkprd().equals("M")){
//                if(!searchVo.getFFmMon().equals("")){
//                    param.put("cost_yrmon_s", searchVo.getFYear() + searchVo.getFFmMon());
//                    param.put("cost_yrmon_e", searchVo.getFYear() + searchVo.getFToMon());
//                }else{
//                    param.put("cost_yrmon", searchVo.getFYear());
//                }
//
//            } else if (searchVo.getFChkprd().equals("W")) {
//                param.put("sls_yrmon", searchVo.getFYear() + "%");
//                if(!searchVo.getFFmWk().equals("")){
//                    param.put("cost_wk_s", searchVo.getFFmWk());
//                    param.put("cost_wk_e", searchVo.getFToWk());
//                }
//            }
//            
//            if (!searchVo.getFOpView().equals("")){
//                param.put("f_op_view", searchVo.getFOpView());
//            }
//            
//            param.put("upd_usr_id", account.getUsr_id());
//            param.put("cre_usr_id", account.getUsr_id());
//            
//            createList.add(param);  
//            createList2.add(param);
//            createList3.add(param);
//            updateList.add(param);
//
//            vo.setMultiCreateList (createList );
//            vo.setMultiCreateList2(createList2);
//            vo.setMultiCreateList3(createList3);
//            vo.setMultiUpdateList (updateList );
//            
//            HashMap<String, Object> vParam = new HashMap<String, Object>();
//            vParam.put("trd_cd"      , searchVo.getFSeltrade());
//            vParam.put("rlane_cd"    , searchVo.getFSelrlane());
//            vParam.put("ioc_cd"      , searchVo.getFSelioc()  );
//            vParam.put("vsl_cd"      , searchVo.getFVslCd()   );
//            vParam.put("skd_voy_no"  , searchVo.getFSkdVoyNo());
//            vParam.put("dir_cd"      , searchVo.getFDirCd()   );
//            vParam.put("priod"       , searchVo.getFChkprd()  );
//            vParam.put("fmMonth"     , searchVo.getFFmMon()   );
//            vParam.put("fmWeek"      , searchVo.getFFmWk()    );
//            vParam.put("f_op_view"   , searchVo.getFOpView()  );
//            vParam.put("f_inout"   	 , searchVo.getFInout()   );
//            vo.setIndirectVariableValues(vParam);            
//
//            //[DB 실행]
//            if (searchVo.getFOpView().equals("OP4") || searchVo.getFOpView().equals("OP6") ){
//				dbDao.applyToPLOP4(vo);
//			} else{
//				 dbDao.applyToPL(vo);
//			}
//            
//            //############################################################################
//            
//            vo.setErrorCode("00000");
//            vo.setErrorMsg("OK!");            
//            
//            GeneralEventResponse eventResponse = new GeneralEventResponse();
//            eventResponse.setETCData("err_cd",vo.getErrorCode());
//            eventResponse.setETCData("err_msg",vo.getErrorMsg());
//            
//            return eventResponse; // "SUCCESS"
//        } catch (DAOException de) {
//            log.error("err "+de.toString(),de);
//            throw new EventException(de.getMessage());
//        }
//    }	

	/**
	 * ESM_COA_0125: 조회 이벤트 처리<br>
	 * 
	 * @param SearchConditionVO searchVo
	 * @return List<SearchLaneTSCommitmentListVO>
	 * @exception EventException
	 */
    public List<SearchLaneTSCommitmentListVO> searchLaneTSCommitmentList(SearchConditionVO searchVo) throws EventException {
        try {
            return dbDao.searchLaneTSCommitmentList(searchVo);
        } catch (DAOException ex) {
            log.error("err "+ex.toString(),ex);
            throw new EventException(ex.getMessage(),ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(),ex);
        }
    }	

	/**
	 * ESM_COA_0159: 조회 이벤트 처리<br>
	 * 
	 * @param SearchConditionVO searchVo
	 * @param NetworkDistributionCommonVO vo
	 * @param SignOnUserAccount account
	 * @return List<SearchLaneTSUnitCostListVO>
	 * @exception EventException
	 */
    public List<SearchLaneTSUnitCostListVO> searchLaneTSUnitCostList(SearchConditionVO searchVo, NetworkDistributionCommonVO vo, SignOnUserAccount account) throws EventException {
        try {
        	String txtYear  = searchVo.getFYearmonth().replaceAll("-","").substring(0,4);

            HashMap<String, String> qParam = new HashMap<String, String>();
            qParam.put("cost_yr", txtYear);
            if (!searchVo.getFCobtrade().equals("")) {
                qParam.put("fm_trd_cd", searchVo.getFCobtrade());
            }
            if (!searchVo.getFCoblane().equals("")) {
                qParam.put("fm_rlane_cd", searchVo.getFCoblane());
            }
            if (!searchVo.getFCobioc().equals("")) {
                qParam.put("fm_ioc_cd", searchVo.getFCobioc());
            }
            if (!searchVo.getFCobdir().equals("")) {
                qParam.put("fm_skd_dir_cd", searchVo.getFCobdir());
            }
            vo.setIndirectColumnValues(qParam);

            HashMap<String, Object> vParam = new HashMap<String, Object>();
            vParam.put("fm_trd_cd"    , searchVo.getFCobtrade());
            vParam.put("fm_rlane_cd"  , searchVo.getFCoblane() );
            vParam.put("fm_ioc_cd"    , searchVo.getFCobioc()  );
            vParam.put("fm_skd_dir_cd", searchVo.getFCobdir()  );
            vo.setIndirectVariableValues(vParam);

            return dbDao.searchLaneTSUnitCostList(vo);
        } catch (DAOException ex) {
            log.error("err "+ex.toString(),ex);
            throw new EventException(ex.getMessage(),ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(),ex);
        }
    }	

	/**
	 *ESM_COA_0125: 멀티 이벤트 처리<br>
	 * 
	 * @param CoaLaneTsBsaCmmtVO[] vos
	 * @param SignOnUserAccount account
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse multiLaneTSCommitment(CoaLaneTsBsaCmmtVO[] vos, SignOnUserAccount account) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
		List<CoaLaneTsBsaCmmtVO> createList = new ArrayList<CoaLaneTsBsaCmmtVO>();	
		List<CoaLaneTsBsaCmmtVO> updateList = new ArrayList<CoaLaneTsBsaCmmtVO>();	
		List<CoaLaneTsBsaCmmtVO> deleteList = new ArrayList<CoaLaneTsBsaCmmtVO>();

		try {
			if(vos.length > 0){
				for(int i = 0 ; i < vos.length ; i++){
	            	if(vos[i].getIbflag().equals("I")) {
	            		vos[i].setCreUsrId(account.getUsr_id());
	            		vos[i].setUpdUsrId(account.getUsr_id());
	            		createList.add(vos[i]);
	            	} else if(vos[i].getIbflag().equals("U")) {
	            		vos[i].setUpdUsrId(account.getUsr_id());
	            		updateList.add(vos[i]);
	            	} else if(vos[i].getIbflag().equals("D")) {
	            		deleteList.add(vos[i]);
	            	}
				}
			}
			
			if ( createList.size() > 0 ) {
				dbDao.addLaneTSCommitment(createList);
			}
			if ( updateList.size() > 0 ) {
				dbDao.modifyLaneTSCommitment(updateList);
			}
			if ( deleteList.size() > 0 ) {
				dbDao.removeLaneTSCommitment(deleteList);
			}

		} catch (DAOException de) {
    		log.error("err " + de.toString(), de);
    		throw new EventException(new ErrorHandler("COM12192",new String[]{}).getMessage(), de);
    	} catch (Exception de) {
    		log.error("err " + de.toString(), de);
    		throw new EventException(new ErrorHandler("COM12192",new String[]{}).getMessage(), de);
    	}
    	
		return eventResponse;
	}
	
	/**
	 * ESM_COA_0159: 멀티 이벤트 처리<br>
	 * 
	 * @param SearchConditionVO searchVo
	 * @param NetworkDistributionCommonVO vo
	 * @param CoaLaneTsUtCostVO[] vos
	 * @param SignOnUserAccount account
	 * @return EventResponse
	 * @exception EventException
	 */
    public EventResponse multiLaneTSUnitCost(SearchConditionVO searchVo, NetworkDistributionCommonVO vo, CoaLaneTsUtCostVO[] vos, SignOnUserAccount account) throws EventException{
        try{
            List createList = new ArrayList();
            List updateList = new ArrayList();
            List deleteList = new ArrayList();
            
            //
            //----------------------------------------------------
            if(vos.length > 0){
                for(int i = 0 ; i < vos.length ; i++){

                    if(vos[i].getIbflag().equals("I")) {
                        //query parameter
                        HashMap<String, String> param = new HashMap<String, String>();
                        param.put("cost_yr"      , vos[i].getCostYr()    );
                        param.put("fm_trd_cd"    , vos[i].getFmTrdCd()   );
                        param.put("fm_rlane_cd"  , vos[i].getFmRlaneCd() );
                        param.put("fm_ioc_cd"    , vos[i].getFmIocCd()   );
                        param.put("fm_skd_dir_cd", vos[i].getFmSkdDirCd());
                        param.put("ts_uc_amt"    , vos[i].getTsUcAmt()   );
                        param.put("cre_usr_id"   , account.getUsr_id()   );
                        param.put("upd_usr_id"   , account.getUsr_id()   );
                        createList.add(param);
                    }
                    else if(vos[i].getIbflag().equals("U")) {
                        //query parameter
                        HashMap<String, String> param = new HashMap<String, String>();

                        param.put("ts_uc_amt"    , vos[i].getTsUcAmt()   );
                        param.put("upd_usr_id"   , account.getUsr_id()   );
                        param.put("cost_yr"      , vos[i].getCostYr()    );
                        param.put("fm_trd_cd"    , vos[i].getFmTrdCd()   );
                        param.put("fm_rlane_cd"  , vos[i].getFmRlaneCd() );
                        param.put("fm_ioc_cd"    , vos[i].getFmIocCd()   );
                        param.put("fm_skd_dir_cd", vos[i].getFmSkdDirCd());
                        updateList.add(param);
                    }
                    else if(vos[i].getIbflag().equals("D")) {
                        //query parameter
                        HashMap<String, String> param = new HashMap<String, String>();

                        param.put("cost_yr"      , vos[i].getCostYr()    );
                        param.put("fm_trd_cd"    , vos[i].getFmTrdCd()   );
                        param.put("fm_rlane_cd"  , vos[i].getFmRlaneCd() );
                        param.put("fm_ioc_cd"    , vos[i].getFmIocCd()   );
                        param.put("fm_skd_dir_cd", vos[i].getFmSkdDirCd());
                        deleteList.add(param);
                    }
                }
            }
            vo.setMultiCreateList(createList);
            vo.setMultiUpdateList(updateList);
            vo.setMultiDeleteList(deleteList);

            //[DB 실행]
            dbDao.multiLaneTSUnitCost(vo);
            //############################################################################

            GeneralEventResponse eventResponse = new GeneralEventResponse();
            return eventResponse; // "SUCCESS"
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }
    }	

	/**
	 *ESM_COA_0153: 조회 이벤트 처리<br>
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
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchConditionVO searchVo
	 * @param SignOnUserAccount account
	 * @return List<SearchFixCostDistListVO>
	 * @exception EventException
	 */
	public List<SearchFixCostSntListVO> searchFixCostSntList(SearchConditionVO searchVO, SignOnUserAccount account) throws EventException {
		try {
            return dbDao.searchFixCostSntList(searchVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}
	
	/**
	 * 생성 이벤트 처리<br>
	 * NetworkDistribution화면에 대한 생성 이벤트 처리<br>
	 * 
	 * @param SearchConditionVO searchVo 
	 * @param SignOnUserAccount account
	 * @return EventResponse
	 * @exception EventException
	 */
    public EventResponse createFixCostSnt(SearchConditionVO searchVo, SignOnUserAccount account) throws EventException{
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
		String f_op_view	= "";
		String inFmStep		= "";
		String out_err_cd	= "";
		String out_err_msg	= "";
		
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
			f_op_view	= searchVo.getFOpView();
					
			// 9단계 : TS 배부 OR 10단계:TS 배부(Op4)
			mss_chk_flg = "Y";
			if (f_op_view.equals("OP4")){
				inFmStep="10";
			}else{
				inFmStep="9";
			}
			// 2009.09.15 파라메타 vo방식으로 변경 		--------------------------------- START		
			//rtnResult = dbDaoNtAll.createNtwkCostALL(pYear, fMon, tMon, fWeek, tWeek, chkPrd, "6", "N", mss_chk_flg, trd_cd, rlane_cd,
			//		ioc_cd, vsl_cd, skd_voy_no, dir_cd, cost_cd, pUserId);
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
				log.debug("createFixCostSnt- Result Error Code: " + out_err_cd);
				log.debug("createFixCostSnt- Result Error Message: " + out_err_msg);
				log.debug("==========================================================================");
				if(out_err_cd.trim().equals("00000")){
					out_err_cd = "00000";
					out_err_msg = "Create Success!!";  	
				} else {
					// 다른 에러 일때  
					out_err_msg = new ErrorHandler("COA00025", out_err_msg).getMessage();
//        			throw new DAOException(new ErrorHandler("COA00025",out_err_cd).getMessage());
        			throw new DAOException(new ErrorHandler("COA00025",out_err_cd).getMessage());
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
	 * [Allocation Result(Internal Pricing)]을 [조회] 합니다.<br>
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
	 * Allocation Result(Internal Pricing) Create 이벤트 처리<br>
	 * NetworkDistribution화면에 대한 Create 이벤트 처리<br>
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
					// 다른 에러 일때  
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
	 * ESM_COA_0107: APPLY 이벤트 처리<br>
	 * NetworkDistribution화면에 대한 APPLY 이벤트 처리<br>
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
					// 다른 에러 일때  
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
	 * TS Allocation BATCH 가 실행중인지를 check 한다.
	 * 
	 * @return String
	 * @throws EventException
	 */
	public String checkTsAllocationCreateBatchStatus() throws EventException {
		String batchRunning ="C";
		try {
			List<CoaUtCostCreStsVO> list = dbDao.checkTsAllocationCreateBatchStatus();			
			// 돌고 있는 batch 가 있다
			if (list.size() > 0) { 
				batchRunning = "P";
			}		
		} catch (DAOException e) {
			log.error("err "+e.toString(),e);
			throw new EventException(new ErrorHandler("COM12213", new String[]{"TS Allocation BATCH STATUS CHECK"}).getMessage(),e);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return batchRunning;
	}
	
	/**
	 * TS Allocation BATCH status 를 생성한다. <br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void addTSAllocationBatchStatus(SearchConditionVO searchConditionVO, SignOnUserAccount account) throws EventException{
		try{
			// shipper 를 user id 담기 위해 사용
			searchConditionVO.setFShipper(account.getUsr_id());
			dbDao.addTSAllocationBatchStatus(searchConditionVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12203", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12203", new String[] {}).getMessage(), ex);
		}
	}
    
	/**
	 * Week 단위로 TS Allocation BATCH 를 수행한다. <br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String createTsAllocation(SearchConditionVO searchConditionVO, SignOnUserAccount account) throws EventException {	
		ScheduleUtil su = new ScheduleUtil();
        String params = "";
		String inFmStep = "";
//log.info(searchConditionVO.getFCmdtCd());
		try {
			if (searchConditionVO.getFOpView().equals("OP1")){
				if(searchConditionVO.getFCmdtCd().equals("EsmCoa0047Event")){
					inFmStep="6";				
				}else if (searchConditionVO.getFCmdtCd().equals("EsmCoa0050Event")){
					inFmStep="12";
				}
			}else{
				if(searchConditionVO.getFCmdtCd().equals("EsmCoa0047Event")){
					inFmStep="8";
				}else if (searchConditionVO.getFCmdtCd().equals("EsmCoa0050Event")){
					inFmStep="13";
				}
			}
			
			params = inFmStep
			+ "#"	+ searchConditionVO.getFYear()
			+ "#" + searchConditionVO.getFFmWk()
			+ "#" + searchConditionVO.getFToWk()
		 	+ "#" + account.getUsr_id();
//log.info(params);
			su.directExecuteJob("ESM_COA_B007",params);

		} catch (IOException e) {
			log.error("err "+e.toString(),e);
			throw new EventException(new ErrorHandler("COM12213", new String[]{"TS Allocation Creation"}).getMessage(),e);
		} catch (InterruptedException e) {
			log.error("err "+e.toString(),e);
			throw new EventException(new ErrorHandler("COM12213", new String[]{"TS Allocation Creation"}).getMessage(),e);
		} catch (DAOException e) {
			log.error("err "+e.toString(),e);
			throw new EventException(new ErrorHandler("COM12213", new String[]{"TS Allocation Creation"}).getMessage(),e);
		} catch (Exception e){
			log.error("err "+e.toString(),e);
			throw new EventException(new ErrorHandler("COM12213", new String[]{"TS Allocation Creation"}).getMessage(),e);
		}
		return "R";//실행 성공
	}
	

	/**
	 * Rlane, Direction 별 Haul bound 정보를 조회한다.<br>
	 * 
	 * @param SearchConditionVO searchVo
	 * @return List<CoaLaneRgstVO>
	 * @exception EventException
	 */
	public List<CoaLaneRgstVO> searchTradeDirbyLaneList(SearchConditionVO searchVo) throws EventException{
        try {
            return dbDao.searchTradeDirbyLaneList(searchVo);
        } catch (DAOException ex) {
            log.error("err "+ex.toString(),ex);
            throw new EventException(ex.getMessage(),ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(),ex);
        }
    }	
}