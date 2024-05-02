/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName 		: WeeklyPFMCDBDAO.java
 *@FileTitle 		: Weekly PFMC DBDAO
 *Open Issues 		:
 *Change history 	: EMU화면(115) LCC레벨 추가
 *@LastModifyDate	: 2007-10-10
 *@LastModifier 	: Ari
 *@LastVersion 		: 1.0
 * 2006-10-23 Park Eun Ju
 * 1.0 최초 생성

 * =========================================================
 * History
 * 2008.01.03 박은주 N200712280005 MAS Report Error 수정 요청
 *                  3. Inquiry by Source Data : TP/SZ 선택 후 조회 시, SP2, SP4 Load 계산 오류[035]
 * 2008.02.15 박은주 N200801154874 주간 대상항차 기준 변경 관련 요청 
 *                  Month로 조회시 Cost_yrmon, Week 조회시 Sls_yrmon 으로 조회되도록 쿼리문 수정[035]
 * 2008.02.28 박은주 N200802250022 MAS_RD 관련 수정 요청 
 *                  화면에서 Excluding SOC Flag 체크시 SOC가 Y가 아닌것만 조회하도록 쿼리문 수정[035] 
 * 2008.03.19 전윤주 : CSR No. N200802290005 MAS_EMU, 샤시 비용 관련 수정[115]               
 * 2008.03.21 박은주 N200802280015 MAS_Report 관련 수정 요청_3번항목  
 *                - Sales Rep 정보 이원화 : C.S.Rep과 L.Rep으로 구분
 *                - OFC 정보 세분화 및 명칭 변경 : C.RHQ, C.AD, C.OFC, L.RHQ, L.AD, L.OFC
 *                - CMDT 관련 정보 위치 변경 : REP CMDT, CMDT CD, CMDT DESC
 *                - Cust CD = > CUST CD
 *                - CN CD + CUST CD에 해당하는 SHPR NM과 B/L SHPR NM으로 이원화[035] 
 * 2008.03.21 박은주 R200803125390 P/L 화면 보완 요청_1,2번항목  
 *                  Week선택시에 Month, Week를 입력할수 있도록 변경[035]
 * 2008.04.22 박칠서 N200803130011 Monthly VVD 확정 시 MAS only를 이유로 delete 된 항차의 경우, 
                                   SKD 배치가 돌때 항차가 다시 살아나지 않도록 수정
 * 2008.04.29 임옥영 N200804280007 Source Data Download 수정
 * 2008.06.24 박은주 N200806120005 MAS_Report 조회 오류[035] 
 * 2008.07.01 박은주 Office 조직 변경으로 인해 소스 변경[035] 
 * 2008.07.14 박은주 N200807077843 Creation 후 Vessel 정보를 넣어주는 것에 기간 제한을 둠[029]
 * 2008.07.14 박칠서 N200807070012 Creation 후 Vessel 정보를 넣어주는 것에 기간 제한을 둠[029]
 * 2008.07.15 박은주 N200806270002 Inquiry by Source Data 화면의 Misc 컬럼 제거 Total만 남겨둠[035]
 * 2008.07.23 전성진 CSR No.N200807230006
 * 						- SMU 저장 함수 추가 [117]
 * 2008.08.07 전윤주 CSR No.N200807170013 EMU 화면 변경 [115]
 *                      - POD 조회 조건 추가 및 화면 변경 
 * 2008.08.29 박은주 CSR No. N200807298360 Expense Detail로 테이블 변경하면서 화면단 모두 변경[060,062]
 * 2008.12.23 김태윤 CSR No. N200812230006 MAS Office 월별관리 후 table 수정 (MAS_OFC_LVL), mas_mon_vvd 와 조건 추가    
 * 2009.01.23 전윤주 CSR No. N200901230005 MAS_EMU Credit 내 EQ Cost 제외 [115]
 * 2009.04.14 전윤주 CSR No. N200904070092 EMU Internal EQ rental Base 에서 EQ Cost 제외 [115]
 *                                        POD ECC를 calling port flag 조건으로 수정 [115]
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
 * 2011.07.20 최성민 [CHM-201112295-01] [MAS] 내부거래단가 조건추가 : Actual Lane 정보
 * 2012.07.17 이석준 [CHM-201218919-01] SMU Cost (RA) 화면 Create 기능 추가    
 * 2012.09.12 이석준 [CHM-201220073-01] EMU Cost (RA) 에 Month Copy 기능 추가
 * 2013.05.08 성미영 [CHM-201324182] SMU 단가 화면 전월 copy 기능 추가 
=========================================================*/

package com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.mas.common.Utils;
import com.hanjin.apps.alps.esm.mas.common.vo.ProcedureParamVO;
import com.hanjin.apps.alps.esm.mas.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.basic.WeeklyCMBCImpl;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.vo.BsaProcedureParamVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.vo.ChassisCostReportVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.vo.DemDetCostDayBatRstVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.vo.DemDetCostRepbyBKGVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.vo.DEMDETCostReportbyBKGDetailVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.vo.DemDetCostReportbyBKGVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.vo.DemDetCostReportbyCustomerVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.vo.FullStorageDailyCalcVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.vo.IsLaneRgstVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.vo.MasEMUCreditListVO;
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
import com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.vo.SearchVslRgstCountVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.vo.SearchWeeklyTargetVVD0030ListVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.vo.SearchWeeklyTargetVVDListVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.vo.SearchYrWkDuVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.vo.StorageCalExcepNodeVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.vo.WeeklyCMCommonVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.MasUtCostCreStsVO;
import com.hanjin.syscommon.common.table.MasInterOwnTmlCostVO;
import com.hanjin.syscommon.common.table.MasLaneDirConvVO;
import com.hanjin.syscommon.common.table.MasMonVvdVO;
import com.hanjin.syscommon.common.table.MasSltMgmtUtVO;
import com.hanjin.syscommon.common.table.MasTmlTrfGrpVO;

/**
 * ALPS-MAS에 대한 DB 처리를 담당<br> -  ALPS-MAS Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author Park Eun Ju
 * @see WeeklyCMBCImpl 참조
 * @since J2EE 1.5
 */
public class WeeklyCMDBDAO extends DBDAOSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2449170496168100093L;

	/**
	 * 주차별 대상 항차/운항리수를 구한다.
	 *
	 * @param ProcedureParamVO procedureParamVO
	 * @return ProcedureParamVO
	 * @throws DAOException
	 */
    public ProcedureParamVO createNtwkCostALL(ProcedureParamVO procedureParamVO) throws DAOException {
		Map<String, Object> resultMap = new HashMap<String, Object>();
    	ProcedureParamVO result = new ProcedureParamVO();
    	
        try{
        	resultMap = new SQLExecuter("").executeSP((ISQLTemplate)new WeeklyCMDBDAOCreateNtwkCostALLCSQL(), procedureParamVO.getColumnValues(), null);
        	if ( resultMap != null) {
	        	result.setOutErrCd((String) resultMap.get("out_err_cd"));
	        	result.setOutErrMsg((String) resultMap.get("out_err_msg"));
        	}
        }catch (SQLException se) {
        	log.error("err " + se.toString(), se);
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
        	log.error("err " + ex.toString(), ex);
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return result;
    }

    /**
	 * MAS_MON_VVD 목록을 가져온다.<br>
	 * ESM_MAS_0142 화면 조회
	 * @param SearchVVDCheckListVO searchVVDCheckListVO
	 * @param SearchConditionVO searchConditionVO
	 * @return List<SearchVVDCheckListVO>
	 * @throws DAOException
	 */
	public List<SearchVVDCheckListVO> searchVVDCheckList(SearchVVDCheckListVO searchVVDCheckListVO
			                                            ,SearchConditionVO searchConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchVVDCheckListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchVVDCheckListVO != null){
				Map<String, String> mapVO = searchConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new WeeklyCMDBDAOSearchVVDCheckListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchVVDCheckListVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * MAS_MON_VVD 여러 데이타 모델을 지정된 ibflag 값에 따라 DB에 반영한다.(수정)<br>
	 * ESM_MAS_0142 화면 수정
	 * 
	 * 변경내역 ------------------------------------------------------------------------------
	 * - Trunk IPC와 Ocean 정보를 달리 가면서  Ocean 수정시 역내구간을 같이 수정해주는것을 해지
	 * - Ocean의 내용 변경시 역내구간 중 아주(IAS) 즉 Trunk IPC 를 제외한 구주역내구간은 
	 *   Ocean과 동일하게 가도록 변경[R200710194124][2007-10-30]
	 * ---------------------------------------------------------------------------------------
	 * 
	 * @param List<MasMonVvdVO> masMonVvdVO
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] modifymodifyVVDCheckS(List<MasMonVvdVO> masMonVvdVO) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(masMonVvdVO .size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new WeeklyCMDBDAOMasMonVvdVOChkUSQL(), masMonVvdVO,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return updCnt;
	}

	/**
	 * MAS_MON_VVD 목록을 가져온다.<br>
	 *
	 * @param SearchConditionVO searchConditionVO
	 * @return List<SearchWeeklyTargetVVDListVO>
	 * @throws DAOException
	 */
    public List<SearchWeeklyTargetVVDListVO> searchWeeklyTargetVVDList(SearchConditionVO searchConditionVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<SearchWeeklyTargetVVDListVO> list = null;
        //query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
        try{
            if(searchConditionVO != null){
            	param.putAll(searchConditionVO.getColumnValues());
            	velParam.putAll(searchConditionVO.getColumnValues());
	            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new WeeklyCMDBDAOSearchWeeklyTargetVVDListRSQL(), param, velParam);
	            list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchWeeklyTargetVVDListVO.class);
            }
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            log.error("err " + se.toString(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            log.error("err " + ex.toString(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list;
    }	
    
    /**
	 * MAS_VSL_RGST중 stnd_ldb_capa가 0인것의 갯수를 조회한다.<br>
	 * 
	 * @param SearchConditionVO vo
	 * @return List<SearchVslRgstCountVO>
	 * @throws DAOException
	 */
    public List<SearchVslRgstCountVO> searchVslRgstCount(SearchConditionVO vo) throws DAOException {
        DBRowSet dbRowset = null;
        List<SearchVslRgstCountVO> list = null;
        
        //query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
        try{
            if(vo == null) return null;
            param.putAll(vo.getColumnValues());
            velParam.putAll(vo.getColumnValues());
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new WeeklyCMDBDAOSearchVslRgstCountRSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchVslRgstCountVO.class);
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            log.error("err " + se.toString(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            log.error("err " + ex.toString(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list;
    }

	/**
	 * MAS_MON_VVD TABLE에 해당 VVD의 BKG실적을 UPDATE 한다.<br>
	 *
	 * @param WeeklyCMCommonVO vo
	 * @throws DAOException
	 */
    public void modifyBkgQtyToMonVVD(WeeklyCMCommonVO vo) throws DAOException {
        int updCnt[] = null;

        try{
            SQLExecuter sqlExe = new SQLExecuter("");
            if(vo.getMultiUpdateList().size() > 0){
                updCnt = sqlExe.executeBatch((ISQLTemplate)new WeeklyCMDBDAOModifyBkgQtyToMonVVDUSQL(), vo.getMultiUpdateList(), null);
                for(int i = 0; i < updCnt.length; i++){
                    if(updCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to update No"+ i + " SQL");
                }
            }
        }catch (SQLException se) {
            log.error("err " + se.toString(), se);
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error("err " + ex.toString(), ex);
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
    }	

	/**
	 * MAS_LANE_RGST에 유효한 정보인지를 확인한다.<br>
	 *
	 * @param WeeklyCMCommonVO vo
	 * @return List<IsLaneRgstVO>
	 * @throws DAOException
	 */
    public List<IsLaneRgstVO> isLaneRgst(WeeklyCMCommonVO vo) throws DAOException {
        DBRowSet dbRowset = null;
        List<IsLaneRgstVO> list = null;
        try{
            if(vo == null) return null;
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new WeeklyCMDBDAOIsLaneRgstRSQL(), null, vo.getIndirectVelocityParameter());
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, IsLaneRgstVO.class);
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            log.error("err " + se.toString(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            log.error("err " + ex.toString(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list;
    }

	/**
	 * MAS_MON_VVD 여러 데이타 모델을 지정된 ibflag 값에 따라 DB에 반영한다.(수정)<br>
	 * 변경내역 ------------------------------------------------------------------------------
	 * - Trunk IPC와 Ocean 정보를 달리 가면서  Ocean 수정시 역내구간을 같이 수정해주는것을 해지
	 * - Ocean의 내용 변경시 역내구간 중 아주(IAS) 즉 Trunk IPC 를 제외한 구주역내구간은 
	 *   Ocean과 동일하게 가도록 변경[R200710194124][2007-10-30]
	 * ---------------------------------------------------------------------------------------
	 * @param WeeklyCMCommonVO vo
	 * @return boolean(Insert 유무)
	 * @throws DAOException
	 */
    public boolean modifyWeeklyTargetVVD(WeeklyCMCommonVO vo) throws DAOException {
        int insCnt[]  = null;
        int updCnt[]  = null;
        int updCnt2[] = null;
        int updCnt3[] = null;

		boolean isInsert  = false;

        try{
            SQLExecuter sqlExe = new SQLExecuter("");
            if(vo.getMultiCreateList() != null && vo.getMultiCreateList().size() > 0){
                insCnt = sqlExe.executeBatch((ISQLTemplate)new WeeklyCMDBDAOMultiWeeklyTargetVVDCSQL(), vo.getMultiCreateList(), null);
                for(int i = 0; i < insCnt.length; i++){
                    if(insCnt[i]== Statement.EXECUTE_FAILED){
                    	isInsert = false;
                        throw new DAOException("Fail to insert No"+ i + " SQL");
                    }
                    else{
                    	isInsert = true;
                    }
                }
            }

            if(vo.getMultiUpdateList() != null && vo.getMultiUpdateList().size() > 0){
                updCnt = sqlExe.executeBatch((ISQLTemplate)new WeeklyCMDBDAOMultiWeeklyTargetVVD1USQL(), vo.getMultiUpdateList(), null);
                for(int i = 0; i < updCnt.length; i++){
                    if(updCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to update No"+ i + " SQL");
                }
            }
            
            if(vo.getMultiUpdateList2() != null && vo.getMultiUpdateList2().size() > 0){
                updCnt2 = sqlExe.executeBatch((ISQLTemplate)new WeeklyCMDBDAOMultiWeeklyTargetVVD2USQL(), vo.getMultiUpdateList2(), null);
                for(int i = 0; i < updCnt2.length; i++){
                    if(updCnt2[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to update No"+ i + " SQL");
                }
            }
            
            if(vo.getMultiUpdateList3() != null && vo.getMultiUpdateList3().size() > 0){
                updCnt3 = sqlExe.executeBatch((ISQLTemplate)new WeeklyCMDBDAOMultiWeeklyTargetVVD3USQL(), vo.getMultiUpdateList3(), null);
                for(int i = 0; i < updCnt3.length; i++){
                    if(updCnt3[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to update No"+ i + " SQL");
                }
            }            
            
            return isInsert;

        }catch (SQLException se) {
            log.error("err " + se.toString(), se);
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error("err " + ex.toString(), ex);
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
    }	

	/**
	 * MAS_MON_VVD 목록을 가져온다.<br>
	 * 
	 * @param SearchWeeklyTargetVVD0030ListVO searchWeeklyTargetVVD0030ListVO
	 * @param SearchConditionVO searchConditionVO
	 * @return List<SearchWeeklyTargetVVD0030ListVO>
	 * @throws DAOException
	 */
	public List<SearchWeeklyTargetVVD0030ListVO> searchWeeklyTargetVVD0030List(SearchWeeklyTargetVVD0030ListVO searchWeeklyTargetVVD0030ListVO
			                                                          ,SearchConditionVO searchConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchWeeklyTargetVVD0030ListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchWeeklyTargetVVD0030ListVO != null){
				Map<String, String> mapVO = searchConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new WeeklyCMDBDAOSearchWeeklyTargetVVD0030ListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchWeeklyTargetVVD0030ListVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * WeeklyCM의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * ESM_MAS_0115.do 조회
	 * @param SearchEMUPfmcListVO searchEMUPfmcListVO
	 * @param SearchConditionVO searchConditionVO
	 * @return List<SearchEMUPfmcListVO>
	 * @throws DAOException
	 */
	public List<SearchEMUPfmcListVO> searchEMUPfmcList(SearchEMUPfmcListVO searchEMUPfmcListVO
			                                          ,SearchConditionVO searchConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchEMUPfmcListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(searchEMUPfmcListVO != null){
				Map<String, String> mapVO = searchConditionVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new WeeklyCMDBDAOSearchEMUPfmcListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchEMUPfmcListVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * WeeklyCM의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * ESM_MAS_0117 조회
	 * @param SearchSMUPfmcListVO searchSMUPfmcListVO
	 * @param SearchConditionVO searchConditionVO
	 * @return List<SearchSMUPfmcListVO>
	 * @throws DAOException
	 */
	public List<SearchSMUPfmcListVO> searchSMUPfmcList(SearchSMUPfmcListVO searchSMUPfmcListVO
			                                          ,SearchConditionVO searchConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchSMUPfmcListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchConditionVO != null){
				Map<String, String> mapVO = searchConditionVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new WeeklyCMDBDAOSearchSMUPfmcListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSMUPfmcListVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}	
	
		
	/**
	 * WeeklyCM의 데이타 모델에 해당되는 값을 불러온 후 저장한다.<br>
	 * ESM_MAS_0117 저장
	 * @param List<MasSltMgmtUtVO> masSltMgmtUtVO
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] modifySMUPfmc(List<MasSltMgmtUtVO> masSltMgmtUtVO) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(masSltMgmtUtVO .size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new WeeklyCMDBDAOMasSltMgmtUtVOUSQL(), masSltMgmtUtVO,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return updCnt;
	}
	/**
	 * WeeklyCM의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * ESM_MAS_0120 조회
	 * @param SearchSeasonalSMUCostListVO searchSeasonalSMUCostListVO
	 * @param SearchConditionVO searchConditionVO
	 * @return List<SearchSMUPfmcListVO>
	 * @throws DAOException
	 */
	public List<SearchSeasonalSMUCostListVO> searchSeasonalSMUCostList(SearchSeasonalSMUCostListVO searchSeasonalSMUCostListVO
			                                          ,SearchConditionVO searchConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchSeasonalSMUCostListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchConditionVO != null){
				Map<String, String> mapVO = searchConditionVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new WeeklyCMDBDAOSearchSeasonalSMUCostListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSeasonalSMUCostListVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	/**
	 * WeeklyCM의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * [Bound Switch] ESM_MAS_0121 조회
	 * @param SearchSeasonalSMUCostPopListVO searchSeasonalSMUCostPopListVO
	 * @param SearchConditionVO searchConditionVO
	 * @return List<SearchSeasonalSMUCostPopListVO>
	 * @throws DAOException
	 */
	public List<SearchSeasonalSMUCostPopListVO> searchLaneBoundSwitchList(SearchSeasonalSMUCostPopListVO searchSeasonalSMUCostPopListVO
			                                          ,SearchConditionVO searchConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchSeasonalSMUCostPopListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchConditionVO != null){
				Map<String, String> mapVO = searchConditionVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new WeeklyCMDBDAOSearchSeasonalSMUCostPopListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSeasonalSMUCostPopListVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * [Bound Switch] 0121 정보를 [삽입] 합니다.<br>
	 *
	 * @param List<MasLaneDirConvVO> insertVoList
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] addLaneBoundSwitch(List<MasLaneDirConvVO> insertVoList) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insertVoList .size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new WeeklyCMDBDAOSearchSeasonalSMUCostPopListVOCSQL(), insertVoList,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}
	/**
	 * [Bound Switch] 정보를 [삭제] 합니다.<br>
	 *
	 * @param List<MasLaneDirConvVO> removeVoList
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] removeLaneBoundSwitch(List<MasLaneDirConvVO> removeVoList) throws DAOException,Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(removeVoList .size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new WeeklyCMDBDAOSearchSeasonalSMUCostPopListVODSQL(), removeVoList,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return delCnt;
	}
	/**
	 * WeeklyCM의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * ESM_MAS_0118 조회
	 * @param SearchOwnTMLPfmcListVO searchOwnTMLPfmcListVO
	 * @param SearchConditionVO searchConditionVO
	 * @return List<SearchOwnTMLPfmcListVO>
	 * @throws DAOException
	 */
	public List<SearchOwnTMLPfmcListVO> searchOwnTMLPfmcList(SearchOwnTMLPfmcListVO searchOwnTMLPfmcListVO
			                                                ,SearchConditionVO searchConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchOwnTMLPfmcListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchOwnTMLPfmcListVO != null){
				Map<String, String> mapVO = searchConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new WeeklyCMDBDAOSearchOwnTMLPfmcListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchOwnTMLPfmcListVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	
	/**
	 * WeeklyCM의 데이타 모델에 해당되는 값을 생성한 후 저장한다.<br>
	 * ESM_MAS_0118 저장
	 * @param List<MasInterOwnTmlCostVO> masInterOwnTmlCostVO
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] modifyOwnTMLPfmc(List<MasInterOwnTmlCostVO> masInterOwnTmlCostVO) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(masInterOwnTmlCostVO .size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new WeeklyCMDBDAOMasInterOwnTmlCostVOUSQL(), masInterOwnTmlCostVO,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return updCnt;
	}
	
	
	/**
	 * TML Internal Pricing 정보를 삭제한다.<br>
	 * 
	 * @param List<MasInterOwnTmlCostVO> delModels
	 * @exception DAOException
	 */
	public void removeOwnTMLPfmc(List<MasInterOwnTmlCostVO> delModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(delModels.size() > 0){				
				HashMap<String, Object> velParam = new HashMap<String, Object>();					
				delCnt = sqlExe.executeBatch((ISQLTemplate)new WeeklyCMDBDAOMasInterOwnTmlCostVODSQL(), delModels, velParam);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	
	/**
	 * WeeklyCM의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * ESM_MAS_0119 화면 조회
	 * @param SearchUOM0119ListVO searchUOM0119ListVO
	 * @return List<SearchUOM0119ListVO>
	 * @throws DAOException
	 */
	public List<SearchUOM0119ListVO> searchUOM0119List(SearchUOM0119ListVO searchUOM0119ListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchUOM0119ListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchUOM0119ListVO != null){
				Map<String, String> mapVO = searchUOM0119ListVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new WeeklyCMDBDAOSearchUOM0119ListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchUOM0119ListVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * WeeklyCM의 데이타 모델에 해당되는 값을 추가한다.<br>
	 * ESM_MAS_0119 화면 추가
	 * @param List<MasTmlTrfGrpVO> masTmlTrfGrpVO
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] addUOM0119(List<MasTmlTrfGrpVO> masTmlTrfGrpVO) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(masTmlTrfGrpVO .size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new WeeklyCMDBDAOMasTmlTrfGrpVOCSQL(), masTmlTrfGrpVO,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}
	/**
	 * WeeklyCM의 데이타 모델에 해당되는 값을 불러온 후 수정한다.<br>
	 * ESM_MAS_0119 화면 수정
	 * @param List<MasTmlTrfGrpVO> masTmlTrfGrpVO
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] modifyUOM0119(List<MasTmlTrfGrpVO> masTmlTrfGrpVO) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(masTmlTrfGrpVO .size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new WeeklyCMDBDAOMasTmlTrfGrpVOUSQL(), masTmlTrfGrpVO,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return updCnt;
	}

	/* -------------------------------------------------------------------------------------------------- */

	
	/**
	 * VVD Check With AR List 조회한다.<br>
	 * ESM_MAS_0112 조회
	 * @param SearchVVDChkWithARListVO searchVVDChkWithARListVO
	 * @param SearchConditionVO searchConditionVO
	 * @return List<SearchVVDChkWithARListVO>
	 * @throws DAOException
	 */
	public List<SearchVVDChkWithARListVO> searchVVDChkWithARList (SearchVVDChkWithARListVO searchVVDChkWithARListVO
			                                                     ,SearchConditionVO searchConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchVVDChkWithARListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchVVDChkWithARListVO != null){
				Map<String, String> mapVO = searchConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new WeeklyCMDBDAOSearchVVDChkWithARListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchVVDChkWithARListVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * VVD Check With AR List 추가 <br>
	 * ESM_MAS_0112 삽입
	 * @param List<SearchVVDChkWithARListVO> searchVVDChkWithARListVO
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] addVVDChkWithARList(List<SearchVVDChkWithARListVO> searchVVDChkWithARListVO) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(searchVVDChkWithARListVO .size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new WeeklyCMDBDAOMasMonVvdVOCSQL(), searchVVDChkWithARListVO ,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}
	/**
	 * VVD Check With AR List 수정 1<br>
	 * ESM_MAS_0112 수정 1
	 * @param List<SearchVVDChkWithARListVO> searchVVDChkWithARListVO
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] modifyVVDChkWithARList(List<SearchVVDChkWithARListVO> searchVVDChkWithARListVO) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(searchVVDChkWithARListVO .size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new WeeklyCMDBDAOMasMonVvdVOUSQL(), searchVVDChkWithARListVO,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return updCnt;
	}
		
	/**
	 * VVD Check With AR List 수정 2<br>
	 * ESM_MAS_0112 수정 2
	 * @param List<SearchVVDChkWithARListVO> searchVVDChkWithARListVO
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] modifyVVDChkWithARList2(List<SearchVVDChkWithARListVO> searchVVDChkWithARListVO) throws DAOException,Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(searchVVDChkWithARListVO .size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new WeeklyCMDBDAOMasMonVvdVO2USQL(), searchVVDChkWithARListVO, null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return delCnt;
	}
	
	/**
	 * 검색조건의 년 주차 기간을 조회한다. 
	 * 
	 * @param ProcedureParamVO durationParamVO
	 * @return SearchYrWkDuVO
	 * @throws DAOException
	 */
	public SearchYrWkDuVO searchYrWkDu(ProcedureParamVO durationParamVO) throws DAOException {
		DBRowSet dbRowset = null;
		SearchYrWkDuVO searchYrWkDuVO = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(durationParamVO != null){
				param.putAll(durationParamVO.getColumnValues());
				velParam.putAll(durationParamVO.getColumnValues());
				
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new WeeklyCMDBDAOSearchYrWkDuRSQL(), param, velParam);
				searchYrWkDuVO = (SearchYrWkDuVO) (RowSetUtil.rowSetToVOs(dbRowset, SearchYrWkDuVO.class)).get(0);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			log.error("err " + se.toString(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			log.error("err " + ex.toString(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return searchYrWkDuVO;
	}
	
	/**
	 * Daily Batch를 돌린다.
	 * 
	 * @param BsaProcedureParamVO dailyBatchConditionVO
	 * @return WeeklyCMCommonVO
	 * @throws DAOException
	 */
	public BsaProcedureParamVO bsaDailyBatch(BsaProcedureParamVO dailyBatchConditionVO) throws DAOException {
		Map<String, Object> result = null;
		
		try{
			if( dailyBatchConditionVO != null ){
				result = new HashMap<String, Object>();
				result.putAll(dailyBatchConditionVO.getColumnValues());
				SQLExecuter sqlExe = new SQLExecuter("");
				
				result = sqlExe.executeSP((ISQLTemplate)new WeeklyCMDBDAODailyBatchCSQL(), dailyBatchConditionVO.getColumnValues(), null);
				dailyBatchConditionVO.setPErrCd( (String)result.get("p_error_code") );
				dailyBatchConditionVO.setPErrMsg((String)result.get("p_error_msg") );
			}

		}catch (SQLException se) {
			log.error("err " + se.toString(), se);
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dailyBatchConditionVO;
	}
	
	/**
	 * SMU 단가를 삭제 한다.
	 *
	 * @param String yyyymm
	 * @throws DAOException
	 */
	public void removeSMUPfmc(String yyyymm) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		int saveCnt = 0;

        try{
            if(yyyymm != null){
            	param.put("yyyymm", yyyymm);
            	
        		saveCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new WeeklyCMDBDAORemoveSMUPfmcDSQL(), param, null);
        	}

            if(saveCnt== Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to modify SQL");

        }catch (SQLException se) {
            log.error("err " + se.toString(), se);
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error("err " + ex.toString(), ex);
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }

	}
	
	/**
	 * SAQ로부터 SMU 단가를 I/F 한다.
	 *
	 * @param SearchConditionVO searchConditionVO
	 * @param SignOnUserAccount account
	 * @throws DAOException
	 */
	public void createSMUPfmc(SearchConditionVO searchConditionVO, SignOnUserAccount account) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		int saveCnt = 0;

        try{
        	if( searchConditionVO != null ){
        		param.putAll(searchConditionVO.getColumnValues());
        		param.put("user_id", account.getUsr_id());
        		saveCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new WeeklyCMDBDAOCreateSMUPfmcCSQL(), param, null);
        	}

            if(saveCnt == Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to insert No SQL");

        } catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

	}
	
	
	/**
	 * SMU Cost (RA) 단가 전월 데이터를 copy 한다.
	 *
	 * @param HashMap<String, String> map
	 * @throws DAOException
	 */
	public void createSMUPfmcMonthCopy(HashMap<String, String> map) throws DAOException {

		int saveCnt = 0;
        try{
       		saveCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new WeeklyCMDBDAOCreateSMUPfmcMonthCopyCSQL(), map, null);
            if(saveCnt == Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to insert No SQL");

        } catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

	}		
	
	/**
	 * SMU 단가를 I/F 한뒤에 creation status를 update한다.
	 *
	 * @param HashMap<String, String> map
	 * @throws DAOException
	 */
	public void modifySMUPfmcCreationStatus(HashMap<String, String> map) throws DAOException {
		//query parameter
		int saveCnt = 0;

        try{
       		saveCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new WeeklyCMDBDAOUpdateSMUPfmcCreationStatusUSQL(), map, null);
            if(saveCnt == Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to insert No SQL");

        } catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

	}
	
	/**
	 * EMU Cost Table을 삭제 한다. 
	 *
	 * @param HashMap<String, String> map
	 * @throws DAOException
	 */
	public void removeEMUCostMonthCopy(HashMap<String, String> map) throws DAOException {
		int saveCnt = 0;

        try{
            	
        	saveCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new WeeklyCMDBDAORemoveEMUCostMonthCopyDSQL(), map, null);

            if(saveCnt== Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to modify SQL");

        }catch (SQLException se) {
            log.error("err " + se.toString(), se);
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error("err " + ex.toString(), ex);
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }

	}	
	/**
	 * EMU UC 월단가를 복사해서 생성한다.
	 *
	 * @param  HashMap<String, String> map
	 * @throws DAOException
	 */
	public void createEMUCostMonthCopy(HashMap<String, String> map) throws DAOException {
		int saveCnt = 0;

        try{
            saveCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new WeeklyCMDBDAOCreateEMUCostMonthCopyCSQL(), map, null);
            if(saveCnt== Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to modify SQL");

        }catch (SQLException se) {
            log.error("err " + se.toString(), se);
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error("err " + ex.toString(), ex);
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
	}
	
	/**
	 * EMU Cost UC 월단가 복사 상태를 단가 관리 table에 update한다. 
	 *
	 * @param  HashMap<String, String> map
	 * @throws DAOException
	 */
	public void modifyCostMonthCopyCreationStatus(HashMap<String, String> map) throws DAOException {
		int saveCnt = 0;

        try{
            saveCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new WeeklyCMDBDAOModifyEMUCostMonthCopyCreStsUSQL(), map, null);
            if(saveCnt== Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to modify SQL");

        }catch (SQLException se) {
            log.error("err " + se.toString(), se);
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error("err " + ex.toString(), ex);
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
	}
	
	

	/**
	 * [EMU Credit Ratio & Amount] 정보를 [조회] 합니다.<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @return List<MasEMUCreditListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<MasEMUCreditListVO> searchEmuCreditTableList(SearchConditionVO searchConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MasEMUCreditListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchConditionVO != null){
				Map<String, String> mapVO = searchConditionVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

				List listCntrTpszCd	= Utils.replaceStringToList(searchConditionVO.getFCntrTpszCd());

				velParam.put("list_cntr_tpsz_cd", listCntrTpszCd);
				
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new WeeklyCMDBDAOMasEMUCreditListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MasEMUCreditListVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	
	

    /**
	 * Del Credit Ratio by Port-Pair 리스트를 조회한다.<br>
	 * ESM_MAS_0222 화면 조회
	 * @param SearchOPCreditRtPortPairVO	searchOPCreditRtPortPairVO
	 * @param String queryType
	 * @return List<SearchOPCreditRtPortPairVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchOPCreditRtPortPairVO> searchCreditRtPortPairList(SearchOPCreditRtPortPairVO searchOPCreditRtPortPairVO, String queryType) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchOPCreditRtPortPairVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchOPCreditRtPortPairVO != null){
				Map<String, String> mapVO = searchOPCreditRtPortPairVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			if(queryType.equals("OP")){
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new WeeklyCMDBDAOSearchOPCreditRtPortPairRSQL(), param, velParam);
			}else{
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new WeeklyCMDBDAOSearchOPCreditRtPortPair2RSQL(), param, velParam);
			}
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchOPCreditRtPortPairVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * Exception List Management 리스트를 조회한다.<br>
	 * ESM_MAS_0250 화면 조회
	 * @param SearchExceptionListMgmtVO	searchExceptionListMgmtVO
	 * @return List<SearchExceptionListMgmtVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchExceptionListMgmtVO> searchExceptionListMgmtList(SearchExceptionListMgmtVO searchExceptionListMgmtVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchExceptionListMgmtVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchExceptionListMgmtVO != null){
				Map<String, String> mapVO = searchExceptionListMgmtVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new WeeklyCMDBDAOSearchExceptionListMgmtRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchExceptionListMgmtVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * Chassis Cost 리스트를 조회한다.<br>
	 * ESM_MAS_0253 화면 조회
	 * @param SearchChassisCostVO SearchChassisCostVO
	 * @return List<SearchChassisCostVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchChassisCostVO> searchChassisCostList(SearchChassisCostVO searchChassisCostVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchChassisCostVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchChassisCostVO != null){
				Map<String, String> mapVO = searchChassisCostVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new WeeklyCMDBDAOSearchChassisCostRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchChassisCostVO.class);
	
			//List listCntrTpszCd	= sUtils.replaceStringToList(searchConditionVO.getFCntrTpszCd());
			//velParam.put("list_cntr_tpsz_cd", listCntrTpszCd);			
			
			//dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new WeeklyCMDBDAOMasEMUCreditListVORSQL(), param, velParam);
			//list = (List)RowSetUtil.rowSetToVOs(dbRowset, MasEMUCreditListVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * Chassis Unit Cost 리스트를 조회한다.<br>
	 * ESM_MAS_0253 화면 조회
	 * @param SearchChassisCostVO searchChassisCostVO
	 * @return List<SearchChassisCostVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchChassisCostVO> searchChassisUnitCostList(SearchChassisCostVO searchChassisCostVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchChassisCostVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchChassisCostVO != null){
				Map<String, String> mapVO = searchChassisCostVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new WeeklyCMDBDAOSearchChassisUnitCostRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchChassisCostVO.class);
	
			//List listCntrTpszCd	= sUtils.replaceStringToList(searchConditionVO.getFCntrTpszCd());
			//velParam.put("list_cntr_tpsz_cd", listCntrTpszCd);			
			
			//dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new WeeklyCMDBDAOMasEMUCreditListVORSQL(), param, velParam);
			//list = (List)RowSetUtil.rowSetToVOs(dbRowset, MasEMUCreditListVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * [ESM_MAS_0253]<br>
	 * Chassis Cost 리스트를  추가<br>
	 * @param List<SearchChassisCostVO> searchChassisCostVOList
	 * @exception DAOException
	 * @exception Exception
	 */
	public void addChassisCostList(List<SearchChassisCostVO> searchChassisCostVOList) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(searchChassisCostVOList.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new WeeklyCMDBDAOAddChassisCostListCSQL(), searchChassisCostVOList, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * [ESM_MAS_0253]<br>
	 * Chassis Cost 리스트를  수정<br>
	 * @param List<SearchChassisCostVO> searchChassisCostVOList
	 * @exception DAOException
	 * @exception Exception
	 */
	public void modifyChassisCostList(List<SearchChassisCostVO> searchChassisCostVOList) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(searchChassisCostVOList.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new WeeklyCMDBDAOModifyChassisCostListUSQL(), searchChassisCostVOList, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * [ESM_MAS_0253]<br>
	 * Chassis Cost 리스트를  삭제<br>
	 * @param List<SearchChassisCostVO> searchChassisCostVOList
	 * @exception DAOException
	 * @exception Exception
	 */
	public void deleteChassisCostList(List<SearchChassisCostVO> searchChassisCostVOList) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(searchChassisCostVOList.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new WeeklyCMDBDAODeleteChassisCostListDSQL(), searchChassisCostVOList, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * [ESM_MAS_0250]<br>
	 * Exception List Management 리스트를  추가<br>
	 * @param List<SearchExceptionListMgmtVO> searchExceptionListMgmtVOList
	 * @exception DAOException
	 * @exception Exception
	 */
	public void addExceptionListMgmtList(List<SearchExceptionListMgmtVO> searchExceptionListMgmtVOList) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(searchExceptionListMgmtVOList.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new WeeklyCMDBDAOAddExceptionListMgmtListCSQL(), searchExceptionListMgmtVOList, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * [ESM_MAS_0250]<br>
	 * Exception List Management 리스트를  수정<br>
	 * @param List<SearchExceptionListMgmtVO> searchExceptionListMgmtVOList
	 * @exception DAOException
	 * @exception Exception
	 */
	public void modifyExceptionListMgmtList(List<SearchExceptionListMgmtVO> searchExceptionListMgmtVOList) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(searchExceptionListMgmtVOList.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new WeeklyCMDBDAOModifyExceptionListMgmtListUSQL(), searchExceptionListMgmtVOList, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * [ESM_MAS_0250]<br>
	 * Exception List Management 리스트를  삭제<br>
	 * @param List<SearchExceptionListMgmtVO> searchExceptionListMgmtVOList
	 * @exception DAOException
	 * @exception Exception
	 */
	public void deleteExceptionListMgmtList(List<SearchExceptionListMgmtVO> searchExceptionListMgmtVOList) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(searchExceptionListMgmtVOList.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new WeeklyCMDBDAODeleteExceptionListMgmtListDSQL(), searchExceptionListMgmtVOList, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
     * Unit Cost by Customer (Door. CY Exception) 리스트를 조회한다.(ESM_MAS_0251)<br>
     * ESM_MAS_0251 화면 조회
     * @param SearchConditionVO searchConditionVO
     * @return List<SearchUCbyCustomerListVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public List<SearchUCbyCustomerListVO> searchUCbyCustomerList(SearchConditionVO searchConditionVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<SearchUCbyCustomerListVO> list = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            if(searchConditionVO != null){
                Map<String, String> mapVO = searchConditionVO.getColumnValues();
            
                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new WeeklyCMDBDAOSearchUCbyCustomerListRSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchUCbyCustomerListVO.class);
        } catch(SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch(Exception ex) {
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list;
    }
	
    /**
     * [ESM_MAS_0251]<br>
     * Unit Cost by Customer (Door. CY Exception) 리스트를  추가<br>
     * @param List<SearchExceptionListMgmtVO> searchUCbyCustomerVOList
     * @exception DAOException
     * @exception Exception
     */
    public void addUCbyCustomerList(List<SearchUCbyCustomerListVO> searchUCbyCustomerVOList) throws DAOException, Exception {
        try {
            SQLExecuter sqlExe = new SQLExecuter("");
            int insCnt[] = null;
            if(searchUCbyCustomerVOList.size() > 0){
                insCnt = sqlExe.executeBatch((ISQLTemplate)new WeeklyCMDBDAOAddUCbyCustomerListCSQL(), searchUCbyCustomerVOList, null);
                for(int i = 0; i < insCnt.length; i++){
                    if(insCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No"+ i + " SQL");
                }
            }
        } catch (SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
    }
    
    /**
     * [ESM_MAS_0251]<br>
     * Unit Cost by Customer (Door. CY Exception) 리스트를  수정<br>
     * @param List<SearchExceptionListMgmtVO> searchUCbyCustomerVOList
     * @exception DAOException
     * @exception Exception
     */
    public void modifyUCbyCustomerList(List<SearchUCbyCustomerListVO> searchUCbyCustomerVOList) throws DAOException, Exception {
        try {
            SQLExecuter sqlExe = new SQLExecuter("");
            int insCnt[] = null;
            if(searchUCbyCustomerVOList.size() > 0){
                insCnt = sqlExe.executeBatch((ISQLTemplate)new WeeklyCMDBDAOModifyUCbyCustomerListUSQL(), searchUCbyCustomerVOList, null);
                for(int i = 0; i < insCnt.length; i++){
                    if(insCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No"+ i + " SQL");
                }
            }
        } catch (SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
    }
    
    /**
     * [ESM_MAS_0251]<br>
     * Unit Cost by Customer (Door. CY Exception) 리스트를  삭제<br>
     * @param List<SearchExceptionListMgmtVO> searchUCbyCustomerVOList
     * @exception DAOException
     * @exception Exception
     */
    public void deleteUCbyCustomerList(List<SearchUCbyCustomerListVO> searchUCbyCustomerVOList) throws DAOException, Exception {
        try {
            SQLExecuter sqlExe = new SQLExecuter("");
            int insCnt[] = null;
            if(searchUCbyCustomerVOList.size() > 0){
                insCnt = sqlExe.executeBatch((ISQLTemplate)new WeeklyCMDBDAODeleteUCbyCustomerListDSQL(), searchUCbyCustomerVOList, null);
                for(int i = 0; i < insCnt.length; i++){
                    if(insCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No"+ i + " SQL");
                }
            }
        } catch (SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
    }

	/*public SearchChassisCostVO searchChassisStandardCostCreate(SearchChassisCostVO searchChassisCostVOList) throws DAOException, Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> result = new HashMap<String, Object>();
		
		String err_cd ="";
		String err_msg ="";
		try{
			
			if(searchChassisCostVOList != null){
				Map<String, String> mapVO = searchChassisCostVOList .getColumnValues();
				param.putAll(mapVO);				
			}
			
				result = new SQLExecuter("").executeSP((ISQLTemplate)new WeeklyCMDBDAOChassisStandardCostCreateCSQL(), param, null);
	        	
//	        	err_cd = (String)result.get("p_err_cd");
//	        	err_msg = (String)result.get("p_err_msg");
				err_cd = "00000";
				err_msg = "Createion Completed";
	        	
				err_cd  = Utils.iif(err_cd == null, "99999", err_cd);
				err_msg = Utils.iif(err_msg== null, "PROCEDURE 수행 중 예상치 못한 에러가 발생하였습니다. 관리자에게 문의하십시오.",err_msg);
				
				searchChassisCostVOList.setErrCd(err_cd);
				searchChassisCostVOList.setErrMsg(err_msg);
				
				return searchChassisCostVOList;
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}*/
	/**
	 * Chassis 표준 단가를 구한다.<br>
	 * ESM_MAS_0253 화면 Creation
	 * @param SearchChassisCostVO searchChassisCostVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception DAOException
	 */	
	public String searchChassisStandardCostCreate(SearchChassisCostVO searchChassisCostVO, SignOnUserAccount account) throws DAOException {
		String pErrorCode = "";		
		try{
			Map<String, String> param = new HashMap<String, String>();		
						
			param.put("f_cost_yr", searchChassisCostVO.getFCostYr());
			param.put("f_cost_qtr_cd", searchChassisCostVO.getFCostQtrCd());
			param.put("f_eff_fm_yrmon", searchChassisCostVO.getFEffFmYrmon());
			param.put("f_eff_to_yrmon", searchChassisCostVO.getFEffToYrmon());
			param.put("user_id", account.getUsr_id());
			param.put("p_error_code", pErrorCode);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			
			@SuppressWarnings("unchecked")
			Map<String, Object> rtnrslt = sqlExe.executeSP((ISQLTemplate)new WeeklyCMDBDAOChassisStandardCostCreateCSQL(), param, null);
			
			if (rtnrslt != null){ 
				pErrorCode = (String) rtnrslt.get("p_error_code");
			}	
			
			return pErrorCode;
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}		
	}
	
	/**
	 * Chassis Cost Create BATCH 가 실행중인지를 check 한다.
	 * 
	 * @return List<MasUtCostCreStsVO>
	 * @throws DAOException
	 */
	public List<MasUtCostCreStsVO> checkChassisCostCreateBatchStatus() throws DAOException {
        DBRowSet dbRowset = null;
        List<MasUtCostCreStsVO> list = null;
      //query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
        try{
	        	dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new WeeklyCMDBDAOCheckChassisCostCreateBatchStatusRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, MasUtCostCreStsVO.class);        		
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            log.error("err " + se.toString(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            log.error("err " + ex.toString(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list;
    }
	
	/**
	 * Chassis Cost Create BATCH status 를 생성한다. <br>
	 * 
	 * @param List<SearchChassisCostVO> searchChassisCostVOList
	 * @throws DAOException
	 */
	public void addChassisCostCreateBatchStatus(List<SearchChassisCostVO> searchChassisCostVOList) throws DAOException {
        try{
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(searchChassisCostVOList.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new WeeklyCMDBDAOAddChassisCostCreateBatchStatusCSQL(), searchChassisCostVOList, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            log.error("err " + se.toString(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            log.error("err " + ex.toString(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
    }
	
	/**
	 * DEM/DET Cost Daily Batch Result 리스트를 조회한다.<br>
	 * ESM_MAS_0271 화면 조회
	 * @param DemDetCostDayBatRstVO demDetCostDayBatRstVO
	 * @return List<DemDetCostDayBatRstVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<DemDetCostDayBatRstVO> searchDemDetCostDayBatRstList(DemDetCostDayBatRstVO demDetCostDayBatRstVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<DemDetCostDayBatRstVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(demDetCostDayBatRstVO != null){
				Map<String, String> mapVO = demDetCostDayBatRstVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("MAS_HJSBAT").executeQuery((ISQLTemplate)new WeeklyCMDBDAOSearchDemDetCostDayBatRstRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, DemDetCostDayBatRstVO.class);
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * ESM_MAS_0275 조회<br>
	 * 
	 * @param DemDetCostRepbyBKGVO demDetCostRepbyBKGVO
	 * @return List<DemDetCostRepbyBKGVO>
	 * @throws DAOException
	 */
	public List<DemDetCostRepbyBKGVO> searchDemDetCostRepbyBKGList(DemDetCostRepbyBKGVO demDetCostRepbyBKGVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<DemDetCostRepbyBKGVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(demDetCostRepbyBKGVO != null){
				Map<String, String> mapVO = demDetCostRepbyBKGVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new WeeklyCMDBDAODemDetCostRepbyBKGRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, DemDetCostRepbyBKGVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * ESM_MAS_0275 - Insert<br>
	 * 
	 * @param List<DemDetCostRepbyBKGVO> mutiModels
	 * @throws DAOException
	 */
	public void addDemDetCostRepbyBKG(List<DemDetCostRepbyBKGVO> mutiModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(mutiModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new WeeklyCMDBDAODemDetCostRepbyBKGCSQL(), mutiModels, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * ESM_MAS_0275 - Modify<br>
	 *
	 * @param List<DemDetCostRepbyBKGVO> mutiModels
	 * @throws DAOException
	 * @throws Exception
	 */	
	public void modifyDemDetCostRepbyBKG(List<DemDetCostRepbyBKGVO> mutiModels) throws DAOException,Exception {
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(mutiModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new WeeklyCMDBDAODemDetCostRepbyBKGUSQL(), mutiModels, null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}			
		}catch (SQLException se) {
			log.error("err " + se.toString(), se);
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * ESM_MAS_0275 - Delete<br>
	 *
	 * @param  List<DemDetCostRepbyBKGVO> mutiModels
	 * @throws DAOException
	 * @throws Exception
	 */
	public void removeDemDetCostRepbyBKG(List<DemDetCostRepbyBKGVO> mutiModels) throws DAOException,Exception {
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;			
			if(mutiModels.size() > 0){
                delCnt = sqlExe.executeBatch((ISQLTemplate)new WeeklyCMDBDAODemDetCostRepbyBKGDSQL(), mutiModels, null);
                for(int i = 0; i < delCnt.length; i++){
                    if(delCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to delete No"+ i + " SQL");
                }            	
            }
		}catch (SQLException se) {
			log.error("err " + se.toString(), se);
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * ESM_MAS_0274 조회<br>
	 * @param StorageCalExcepNodeVO storageCalExcepNodeVO
	 * @return List<StorageCalExcepNodeVO>
	 * @throws DAOException
	 */
	public List<StorageCalExcepNodeVO> searchStorageCalExcepNode(StorageCalExcepNodeVO storageCalExcepNodeVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<StorageCalExcepNodeVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(storageCalExcepNodeVO != null){
				Map<String, String> mapVO = storageCalExcepNodeVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new WeeklyCMDBDAOStorageCalExcepNodeRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, StorageCalExcepNodeVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * ESM_MAS_0274 - Insert<br>
	 * @param List<StorageCalExcepNodeVO> mutiModels
	 * @throws DAOException
	 */
	public void addStorageCalExcepNode(List<StorageCalExcepNodeVO> mutiModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(mutiModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new WeeklyCMDBDAOStorageCalExcepNodeCSQL(), mutiModels, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * ESM_MAS_0274 - Modify<br>
	 * @param  List<StorageCalExcepNodeVO> mutiModels
	 * @throws DAOException
	 * @thrwos Exception
	 */	
	public void modifyStorageCalExcepNode(List<StorageCalExcepNodeVO> mutiModels) throws DAOException,Exception {
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(mutiModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new WeeklyCMDBDAOStorageCalExcepNodeUSQL(), mutiModels, null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}			
		}catch (SQLException se) {
			log.error("err " + se.toString(), se);
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * ESM_MAS_0274 - Delete<br>
	 * @param  List<StorageCalExcepNodeVO> mutiModels
	 * @throws DAOException
	 * @throws Exception
	 */
	public void removeStorageCalExcepNode(List<StorageCalExcepNodeVO> mutiModels) throws DAOException,Exception {
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;			
			if(mutiModels.size() > 0){
                delCnt = sqlExe.executeBatch((ISQLTemplate)new WeeklyCMDBDAOStorageCalExcepNodeDSQL(), mutiModels, null);
                for(int i = 0; i < delCnt.length; i++){
                    if(delCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to delete No"+ i + " SQL");
                }            	
            }
		}catch (SQLException se) {
			log.error("err " + se.toString(), se);
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Include Sub Office Code를 가져옴<br>
	 * 
	 * @param StorageCalExcepNodeVO storageCalExcepNodeVO
	 * @return List<StorageCalExcepNodeVO>
	 * @throws DAOException
	 */
	public List<StorageCalExcepNodeVO> searchSubOfficeSOManageList(StorageCalExcepNodeVO storageCalExcepNodeVO) throws DAOException{
		DBRowSet dbRowset = null;
		List<StorageCalExcepNodeVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(storageCalExcepNodeVO != null){
				Map<String, String> mapVO = storageCalExcepNodeVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new WeeklyCMDBDAOSearchSubOfficeSOManageListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, StorageCalExcepNodeVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * Sheet Auto Set<br>
	 * 
	 * @param storageCalExcepNodeVO
	 * @return List<StorageCalExcepNodeVO>
	 * @throws DAOException
	 */
	public List<StorageCalExcepNodeVO> searchYardCodeNameOfficeList(StorageCalExcepNodeVO storageCalExcepNodeVO) throws DAOException{
		DBRowSet dbRowset = null;
		List<StorageCalExcepNodeVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(storageCalExcepNodeVO != null){
				Map<String, String> mapVO = storageCalExcepNodeVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new WeeklyCMDBDAOSearchYardCodeNameOfficeListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, StorageCalExcepNodeVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * Full Storage Daily Calc 조회<br>
	 * 
	 * @param FullStorageDailyCalcVO fullStorageDailyCalcVO
	 * @return List<FullStorageDailyCalcVO>
	 * @throws DAOException
	 */
	public List<FullStorageDailyCalcVO> searchFullStorageDailyCalcList(FullStorageDailyCalcVO fullStorageDailyCalcVO) throws DAOException{
		DBRowSet dbRowset = null;
		List<FullStorageDailyCalcVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(fullStorageDailyCalcVO != null){
				Map<String, String> mapVO = fullStorageDailyCalcVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("MAS_HJSBAT").executeQuery((ISQLTemplate) new WeeklyCMDBDAOFullStorageDailyCalcRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, FullStorageDailyCalcVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * Office의 Sub Office 조회
	 * 
	 * @param String ofcCd
	 * @return String[]
	 * @throws DAOException
	 */
	public String[] searchSubOfficeList(String ofcCd) throws DAOException {
		String[] sResult = null;
		DBRowSet dbRowset = null;
		ArrayList<String> tmpList = new ArrayList<String>();
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			param.put("ofc_cd", ofcCd);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new WeeklyCMDBDAOSubOfficeRSQL(), param, null);
			while (dbRowset.next() ) {
				tmpList.add(dbRowset.getString("OFC_CD"));
			}
			if(!tmpList.isEmpty()) {
				sResult = (String[])tmpList.toArray(new String[0]);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return sResult;
	}
	
	/**
	 * ESM_MAS_0223 - 조회<br>
	 * @param OnewayCntrUploadVO onewayCntrUploadVO
	 * @return List<OnewayCntrUploadVO>
	 * @throws DAOException
	 */
	public List<OnewayCntrUploadVO> searchOnewayCntrUpload(OnewayCntrUploadVO onewayCntrUploadVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<OnewayCntrUploadVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(onewayCntrUploadVO != null){
				Map<String, String> mapVO = onewayCntrUploadVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new WeeklyCMDBDAOOnewayCntrUploadRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, OnewayCntrUploadVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * ESM_MAS_0223 - Insert<br>
	 * @param  List<OnewayCntrUploadVO> mutiModels
	 * @throws DAOException
	 */
	public void addOnewayCntrUpload(List<OnewayCntrUploadVO> mutiModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(mutiModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new WeeklyCMDBDAOOnewayCntrUploadCSQL(), mutiModels, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * ESM_MAS_0223 - Modify<br>
	 * @param  List<OnewayCntrUploadVO> mutiModels
	 * @throws DAOException
	 */	
	public void modifyOnewayCntrUpload(List<OnewayCntrUploadVO> mutiModels) throws DAOException,Exception {
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(mutiModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new WeeklyCMDBDAOOnewayCntrUploadUSQL(), mutiModels, null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}			
		}catch (SQLException se) {
			log.error("err " + se.toString(), se);
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * ESM_MAS_0223 - Delete<br>
	 * @param  List<OnewayCntrUploadVO> mutiModels
	 * @throws DAOException
	 */
	public void removeOnewayCntrUpload(List<OnewayCntrUploadVO> mutiModels) throws DAOException,Exception {
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;			
			if(mutiModels.size() > 0){
                delCnt = sqlExe.executeBatch((ISQLTemplate)new WeeklyCMDBDAOOnewayCntrUploadDSQL(), mutiModels, null);
                for(int i = 0; i < delCnt.length; i++){
                    if(delCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to delete No"+ i + " SQL");
                }            	
            }
		}catch (SQLException se) {
			log.error("err " + se.toString(), se);
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * ESM_MAS_0223 - Modify<br>
	 * @param  List<OnewayCntrUploadVO> mutiModels
	 * @throws DAOException
	 * @throws Exception
	 */	
	public void modifyOnewayBkgCostUploadSmry(List<OnewayCntrUploadVO> mutiModels) throws DAOException,Exception {
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(mutiModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new WeeklyCMDBDAOModifyOnewayBkgCostUploadSmryUSQL(), mutiModels, null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}			
		}catch (SQLException se) {
			log.error("err " + se.toString(), se);
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * ESM_MAS_0223 - Modify<br>
	 * @param  List<OnewayCntrUploadVO> mutiModels
	 * @throws DAOException
	 * @throws Exception
	 */	
	public void modifyOnewayBkgCostUploadGrpSmry(List<OnewayCntrUploadVO> mutiModels) throws DAOException,Exception {
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(mutiModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new WeeklyCMDBDAOModifyOnewayBkgCostUploadGrpSmryUSQL(), mutiModels, null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}			
		}catch (SQLException se) {
			log.error("err " + se.toString(), se);
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * ESM_MAS_0223 - Modify<br>
	 * @param  List<OnewayCntrUploadVO> mutiModels
	 * @throws DAOException
	 * @throws Exception
	 */	
	public void modifyOnewayBkgCostUploadSrcDtl(List<OnewayCntrUploadVO> mutiModels) throws DAOException,Exception {
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(mutiModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new WeeklyCMDBDAOModifyOnewayBkgCostUploadSrcDtlUSQL(), mutiModels, null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}			
		}catch (SQLException se) {
			log.error("err " + se.toString(), se);
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	

	/**
	 * ESM_MAS_0223 - MAS_BKG_COST_CALC 테이블에 BKG 번호 Insert<br>
	 * @param List<OnewayCntrUploadVO> mutiModels
	 * @throws DAOException
	 * @thrwos Exception
	 */
	public void addOnewayBkgCostCalc(List<OnewayCntrUploadVO> mutiModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(mutiModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new WeeklyCMDBDAOAddOnewayBkgCostCalcCSQL(), mutiModels, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * ESM_MAS_0006 - 조회<br>
	 * @param OfcRoleSetupVO ofcRoleSetupVO
	 * @return List<OfcRoleSetupVO>
	 * @throws DAOException
	 */
	public List<OfcRoleSetupVO> searchOfcRoleSetup(OfcRoleSetupVO ofcRoleSetupVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<OfcRoleSetupVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(ofcRoleSetupVO != null){
				Map<String, String> mapVO = ofcRoleSetupVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new WeeklyCMDBDAOOfcRoleSetupRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, OfcRoleSetupVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * ESM_MAS_0006 - Insert<br>
	 * @param  List<OfcRoleSetupVO> mutiModels
	 * @throws DAOException
	 */
	public void addOfcRoleSetup(List<OfcRoleSetupVO> mutiModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(mutiModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new WeeklyCMDBDAOOfcRoleSetupCSQL(), mutiModels, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * ESM_MAS_0006 - Modify<br>
	 * @param  List<OfcRoleSetupVO> mutiModels
	 * @throws DAOException
	 */	
	public void modifyOfcRoleSetup(List<OfcRoleSetupVO> mutiModels) throws DAOException,Exception {
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(mutiModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new WeeklyCMDBDAOOfcRoleSetupUSQL(), mutiModels, null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}			
		}catch (SQLException se) {
			log.error("err " + se.toString(), se);
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * ESM_MAS_0006 - Delete<br>
	 * @param  List<OfcRoleSetupVO> mutiModels
	 * @throws DAOException
	 */
	public void removeOfcRoleSetup(List<OfcRoleSetupVO> mutiModels) throws DAOException,Exception {
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;			
			if(mutiModels.size() > 0){
                delCnt = sqlExe.executeBatch((ISQLTemplate)new WeeklyCMDBDAOOfcRoleSetupDSQL(), mutiModels, null);
                for(int i = 0; i < delCnt.length; i++){
                    if(delCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to delete No"+ i + " SQL");
                }            	
            }
		}catch (SQLException se) {
			log.error("err " + se.toString(), se);
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * ESM_MAS_0279 - 조회<br>
	 * @param DEMDETCostReportbyBKGDetailVO dEMDETCostReportbyBKGDetailVO
	 * @return List<DEMDETCostReportbyBKGDetailVO>
	 * @throws DAOException
	 */
	public List<DEMDETCostReportbyBKGDetailVO> searchDEMDETCostReportbyBKGDetail(DEMDETCostReportbyBKGDetailVO dEMDETCostReportbyBKGDetailVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<DEMDETCostReportbyBKGDetailVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		List<String> aryBkg = new ArrayList();
		List<String> aryCntr = new ArrayList();
		
		String bkg = dEMDETCostReportbyBKGDetailVO.getFBkgno();
		String cntr = dEMDETCostReportbyBKGDetailVO.getFCntrno();
		
		try{
			if(dEMDETCostReportbyBKGDetailVO != null){
				Map<String, String> mapVO = dEMDETCostReportbyBKGDetailVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				if( bkg != null && bkg.indexOf(",")>-1){
					String[] ab = bkg.split(",");
					for(int i = 0; i <  ab.length ; i++){   
						aryBkg.add(ab[i]);   
					}
					velParam.put("f_bkgno", aryBkg);
				}
				if( cntr != null && cntr.indexOf(",")>-1){
					String[] ac = cntr.split(",");
					for(int i = 0; i <  ac.length ; i++){   
						aryCntr.add(ac[i]);   
					}
					velParam.put("f_cntrno", aryCntr);
				}
				
				
			}
			dbRowset = new SQLExecuter("MAS_HJSBAT").executeQuery((ISQLTemplate)new WeeklyCMDBDAODEMDETCostReportbyBKGDetailRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, DEMDETCostReportbyBKGDetailVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * ESM_MAS_0276 - 조회<br>
	 * @param DemDetCostReportbyBKGVO demDetCostReportbyBKGVO
	 * @return List<DemDetCostReportbyBKGVO>
	 * @throws DAOException
	 */
	public List<DemDetCostReportbyBKGVO> searchDemDetCostReportbyBKG(DemDetCostReportbyBKGVO demDetCostReportbyBKGVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<DemDetCostReportbyBKGVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(demDetCostReportbyBKGVO != null){
				Map<String, String> mapVO = demDetCostReportbyBKGVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("MAS_HJSBAT").executeQuery((ISQLTemplate)new WeeklyCMDBDAODemDetCostReportbyBKGRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, DemDetCostReportbyBKGVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * ESM_MAS_0277 - 조회<br>
	 * @param DemDetCostReportbyCustomerVO demDetCostReportbyCustomerVO
	 * @return List<DemDetCostReportbyCustomerVO>
	 * @throws DAOException
	 */
	public List<DemDetCostReportbyCustomerVO> searchDemDetCostReportbyCustomer(DemDetCostReportbyCustomerVO demDetCostReportbyCustomerVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<DemDetCostReportbyCustomerVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(demDetCostReportbyCustomerVO != null){
				Map<String, String> mapVO = demDetCostReportbyCustomerVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("MAS_HJSBAT").executeQuery((ISQLTemplate)new WeeklyCMDBDAODemDetCostReportbyCustomerRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, DemDetCostReportbyCustomerVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * ESM_MAS_0273 - 조회<br>
	 * @param ChassisCostReportVO chassisCostReportVO
	 * @return List<ChassisCostReportVO>
	 * @throws DAOException
	 */
	public List<ChassisCostReportVO> searchChassisCostReport(ChassisCostReportVO chassisCostReportVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ChassisCostReportVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(chassisCostReportVO != null){
				Map<String, String> mapVO = chassisCostReportVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("MAS_HJSBAT").executeQuery((ISQLTemplate)new WeeklyCMDBDAOChassisCostReportRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ChassisCostReportVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
		
}
