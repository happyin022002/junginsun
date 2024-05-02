/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : LaneSimulationDBDAO.java
*@FileTitle : 항로 Simulation 마스터 및 W/F 생성/조회/변경
*Open Issues :
*Change history :
*@LastModifyDate : 2006-08-25
*@LastModifier : eunju park
*@LastVersion : 1.12
* 2009-12-02 Yoon jin young
* 1.0 최초 생성
* =======================================================
* History
* 2008.02.19 박은주 N200802040018 COA 내 항로 Simulation 로직 변경
* 2008.10.06 박은주 N200811050011 단가입력란은 Vessel code 업데이트에서 제외하게 변경
* 2009.03.31 박은주, 임옥영, 박상희 S2K-09U-002(Lane Simulation System 개선)
* 2009.06.15 배진환 N200905220060 Lane Simulation System 수정사항
* 2009.06.30 송호진 N200905220061 Lane Simulation 수정사항 ( 각 계정별 수식 수정 createSimSummaryReport, multiSimSummaryReport, searchSimSummaryReportList )
* 2009.07.20 윤진영 ALPS 전환개발
* 2010.02.05 임옥영 품질검토 결과 반영 (사용하지 않는 지역변수 주석처리 cnt4), 주석들 변경 
* 2010.02.16 임옥영 소스품질검토 결과 반영 Line No. 2132 :  : shall be matched with type of parameter(SearchSimLaneRPBListVO vs List<SearchSimLaneRPBListVO>)
*                                                                               chkTurnPortInd(SearchTMLOPDysListVO) Line No. 3601 :  : shall be matched with size of parameter -->해당 메소드 없음
*                                                                               chkTurnPortInd(SearchTMLOPDysListVO)  Line No. 3601 :  : shall be matched with size of @return-->해당 메소드 없음
*                                                                               chkTurnPortInd(SearchTMLOPDysListVO) Line No. 3609 Variable name : i-->해당 메소드 없음
* 2010.02.19 임옥영 소스품질검토 결과 반영 chkTurnPortInd(SearchTMLOPDysListVO) Line No. 3605 :  : shall be matched with size of parameter
*																				chkTurnPortInd(SearchTMLOPDysListVO) Line No. 3605 :  : shall be matched with size of @return
* 2010.10.08 박은주 CHM-201006307 Session 정보 변경 및 프로그램 오류수정
* 2011.03.08 김상수 Ticket ID:CHM-201109234-01 lane simulation 기능 보완
*                   - searchSimCgoCostList메소드내의 잘못된 subString 수정
* 2011.07.13 최성민 [CHM-201111826] R4J Rule Upgrade 관련 소스품질 향상을 위한 조치
=========================================================*/
package com.clt.apps.opus.esm.coa.lanesimulation.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.coa.common.vo.SearchConditionVO;
import com.clt.apps.opus.esm.coa.lanesimulation.basic.LaneSimulationBCImpl;
import com.clt.apps.opus.esm.coa.lanesimulation.event.EsmCoa0052Event;
import com.clt.apps.opus.esm.coa.lanesimulation.event.EsmCoa0053Event;
import com.clt.apps.opus.esm.coa.lanesimulation.event.EsmCoa0151Event;
import com.clt.apps.opus.esm.coa.lanesimulation.vo.CreateSimDailyHireVO;
import com.clt.apps.opus.esm.coa.lanesimulation.vo.LaneInfoListConditionVO;
import com.clt.apps.opus.esm.coa.lanesimulation.vo.LaneSimulationCommonVO;
import com.clt.apps.opus.esm.coa.lanesimulation.vo.MergyVolProjConditionVO;
import com.clt.apps.opus.esm.coa.lanesimulation.vo.MultiSimSummaryRptVO;
import com.clt.apps.opus.esm.coa.lanesimulation.vo.SearchBSAbyVVDListConditionVO;
import com.clt.apps.opus.esm.coa.lanesimulation.vo.SearchBSAbyVVDListVO;
import com.clt.apps.opus.esm.coa.lanesimulation.vo.SearchFileMgmtListVO;
import com.clt.apps.opus.esm.coa.lanesimulation.vo.SearchLaneInfoListVO;
import com.clt.apps.opus.esm.coa.lanesimulation.vo.SearchReportConditionVO;
import com.clt.apps.opus.esm.coa.lanesimulation.vo.SearchSimBunkerListVO;
import com.clt.apps.opus.esm.coa.lanesimulation.vo.SearchSimConditionVO;
import com.clt.apps.opus.esm.coa.lanesimulation.vo.SearchSimContiPairListVO;
import com.clt.apps.opus.esm.coa.lanesimulation.vo.SearchSimDailyHireInfoVO;
import com.clt.apps.opus.esm.coa.lanesimulation.vo.SearchSimLaneListConditionVO;
import com.clt.apps.opus.esm.coa.lanesimulation.vo.SearchSimLaneListVO;
import com.clt.apps.opus.esm.coa.lanesimulation.vo.SearchSimLaneRPBListVO;
import com.clt.apps.opus.esm.coa.lanesimulation.vo.SearchSimPortChargeListVO;
import com.clt.apps.opus.esm.coa.lanesimulation.vo.SearchSimPortListVO;
import com.clt.apps.opus.esm.coa.lanesimulation.vo.SearchSimReportMasterListVO;
import com.clt.apps.opus.esm.coa.lanesimulation.vo.SearchSimRtnRowSetVO;
import com.clt.apps.opus.esm.coa.lanesimulation.vo.SearchSimVesselListConditionVO;
import com.clt.apps.opus.esm.coa.lanesimulation.vo.SearchSimVesselListVO;
import com.clt.apps.opus.esm.coa.lanesimulation.vo.SearchSimYardConditionVO;
import com.clt.apps.opus.esm.coa.lanesimulation.vo.SearchSimYardListVO;
import com.clt.apps.opus.esm.coa.lanesimulation.vo.SearchTMLOPDysListVO;
import com.clt.apps.opus.esm.coa.lanesimulation.vo.SearchTocHireListVO;
import com.clt.apps.opus.esm.coa.lanesimulation.vo.SearchTsVolumeVO;
import com.clt.apps.opus.esm.coa.lanesimulation.vo.SearchVesselInfoConditionVO;
import com.clt.apps.opus.esm.coa.lanesimulation.vo.SearchVesselInfoVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.CoaBnkCsmVO;
import com.clt.syscommon.common.table.CoaSimBnkCostVO;
import com.clt.syscommon.common.table.CoaSimCtrbMgnCostVO;
import com.clt.syscommon.common.table.CoaSimDlyHirVO;
import com.clt.syscommon.common.table.CoaSimIntrTrnsVolVO;
import com.clt.syscommon.common.table.CoaSimNonOpExpnVO;
import com.clt.syscommon.common.table.CoaSimPortChgVO;
import com.clt.syscommon.common.table.CoaSimTmlInfoVO;
import com.clt.syscommon.common.table.CoaTmChtrOutHirVO;

/**
 * ALPS-COA에 대한 DB 처리를 담당<br>
 * - ALPS-COA Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author eunju park
 * @see LaneSimulationBCImpl 참조
 * @since J2EE 1.4
 */
public class LaneSimulationDBDAO extends DBDAOSupport {
    /**
	 * 
	 */
	private static final long serialVersionUID = -8482860273427145838L;
	/**
     * COA_SIM_SVC_LANE의 목록을 가져온다.<br>
     *
     * @param  SearchSimLaneListConditionVO searchSimLaneListConditionVO
     * @return List<SearchSimLaneListVO>
     * @throws DAOException
     */
    public List<SearchSimLaneListVO> searchSimLaneList(SearchSimLaneListConditionVO searchSimLaneListConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchSimLaneListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(searchSimLaneListConditionVO != null){
				Map<String, String> mapVO = searchSimLaneListConditionVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LaneSimulationDBDAOSearchSimLaneListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSimLaneListVO .class);
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
	 * S.Lane의 목록을 가져온다.<br>
	 * COA_SIM_INFO, COA_LANE_RGST 데이터 유무를 확인한다
	 * newLane = dbDao.chkSLane(event.getString("f_slan_cd"));
	 * @param slan_cd
	 * @return String
	 * @throws DAOException
	 */ 
	public String searchSLane2(String slan_cd) throws DAOException {
		DBRowSet dbRowset = null;
		String result= "N";
		Map<String, String> param = new HashMap<String, String>();
		Map<String, String> velParam = new HashMap<String, String>();
		try{
			if(slan_cd != null){
				param.put("slan_cd", slan_cd);
				velParam.put("slan_cd", slan_cd);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LaneSimulationDBDAOChkSLane2RSQL(), param, velParam);
			if(dbRowset != null){
				while(dbRowset.next()){
					if(!dbRowset.getString("slan_cd").equals("")) result = "Y";
				}
			}			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;		
	}
    /**
     * COA_SIM_SVC_LANE의 여러 데이타 모델을 지정된 ibflag 값에 따라 DB에 반영한다.(삭제)<br>
     * 
     * @param SearchSimLaneListConditionVO searchSimLaneListConditionVO
     * @throws DAOException
     */
    public void removeSimLane(SearchSimLaneListConditionVO searchSimLaneListConditionVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(searchSimLaneListConditionVO != null){
				for(int i=1;i<11;i++) {
					Map<String, String> mapVO = searchSimLaneListConditionVO .getColumnValues();
					param.putAll(mapVO);
					param.put("tname",i);
					if(i==3) param.put("sect_no","");
					velParam.putAll(mapVO);
					velParam.put("tname",i);
					SQLExecuter sqlExe = new SQLExecuter("");
					int result = sqlExe.executeUpdate((ISQLTemplate)new LaneSimulationDBDAOMultiSimLaneDSQL(), param, velParam);
					if(result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert SQL");		
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());

		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
    }
    /**
     * COA_SIM_INFO의 목록을 가져온다.<br>
     * 
     * @param  ori_sim_dt
     * @param  sim_no 
     * @return DBRowSet
     * @throws DAOException
     */
    public DBRowSet searchSimulationNo(String ori_sim_dt,String sim_no) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			param.put("sim_dt",ori_sim_dt);
			param.put("sim_no",sim_no);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LaneSimulationDBDAOSelSimulationNoRSQL(), param, null);
			return dbRowset;
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
    }
    
    /**
     * COA_SIM_INFO테이블에 데이터를 입력 수정한다
     * 
     * @param SearchSimLaneListVO vo
     * @throws DAOException
     */
    public void addSimLane(SearchSimLaneListVO vo) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new LaneSimulationDBDAOMultiSimMInfoListCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
    }
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SearchSimLaneListVO vo
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addmultiSimLane(SearchSimLaneListVO vo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new LaneSimulationDBDAOMultiSimLaneCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	
	/**
	 * vessel 정보를 입력 합니다.<br>
	 * 
	 * @param SearchSimVesselListVO vo
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addSimVslInfo(SearchSimVesselListVO vo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new LaneSimulationDBDAOAddSimVsInfoCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	
	/**
	 * vessel 정보를 수정 합니다.<br>
	 * 
	 * @param SearchSimVesselListVO vo
	 * @throws DAOException
	 * @throws Exception
	 */
	public void modifySimVslInfo(SearchSimVesselListVO vo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new LaneSimulationDBDAOModifySimVslInfoUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	
	
	

	/**
	 * vessel 정보를 삭제 합니다.<br>
	 * 
	 * @param SearchSimVesselListVO vo
	 * @throws DAOException
	 * @throws Exception
	 */
	public void deleteSimVesselInfo(SearchSimVesselListVO vo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new LaneSimulationDBDAODeleteSimVesselInfoDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	
	
	
	
	/**
	 * vessel 정보를 삭제 합니다.<br>
	 * 
	 * @param SearchSimVesselListVO vo
	 * @throws DAOException
	 * @throws Exception
	 */
	public void deleteSimVesselInfo2(SearchSimVesselListVO vo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new LaneSimulationDBDAODeleteSimVesselInfo2DSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}		
	
	
	/**
	 * vessel 정보를 입력 합니다.<br>
	 * 
	 * @param SearchSimVesselListVO vo
	 * @throws DAOException
	 * @throws Exception
	 */
	public void insertSimVesselInfo(SearchSimVesselListVO vo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new LaneSimulationDBDAOInsertSimVesselInfoCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	
	
	
	
	/**
	 * vessel 정보를 입력 합니다.<br>
	 * 
	 * @param SearchSimVesselListVO vo
	 * @throws DAOException
	 * @throws Exception
	 */
	public void updateSimVesselInfo(SearchSimVesselListVO vo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new LaneSimulationDBDAOUpdateSimVesselInfoUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	
	
	
	
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SearchSimLaneListVO vo
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int modifymultiSimLane(SearchSimLaneListVO vo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new LaneSimulationDBDAOMultiSimLaneUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}

    /**
     * Vessel정보를 조회한다.<br>
     * 
     * @param  SearchVesselInfoConditionVO searchVesselInfoConditionVO
     * @return List<SearchVesselInfoVO>
     * @throws DAOException
     */
    public List<SearchVesselInfoVO> searchVesselInfo(SearchVesselInfoConditionVO searchVesselInfoConditionVO) throws DAOException {
    	
        DBRowSet dbRowset = null;			// 데이터 전송을 위해 DB ResultSet을 구현한 객체
        List<SearchVesselInfoVO> list = null;
        Map<String, Object> param = new HashMap<String,Object>();
        Map<String, Object> velparam = new HashMap<String,Object>();
        try {
        	if(searchVesselInfoConditionVO != null) {
        		Map<String, String> mapVO = searchVesselInfoConditionVO.getColumnValues();
        		param.putAll(mapVO);
        	}
        	dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LaneSimulationDBDAOSearchVesselListRSQL(),param,velparam);
        	list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchVesselInfoVO .class);
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
     * COA_SIM_VSL_SET_INFO의 목록을 가져온다.<br>
     * 2009.02.18 수정 
     * @param  SearchSimVesselListConditionVO searchSimVesselListConditionVO
     * @return List<SearchSimVesselListVO>
     * @throws DAOException
     */
    public List<SearchSimVesselListVO> searchSimVesselList(SearchSimVesselListConditionVO searchSimVesselListConditionVO) throws DAOException {
    	DBRowSet dbRowset = null;
		List<SearchSimVesselListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
        
		try{
			if(searchSimVesselListConditionVO != null){
				Map<String, String> mapVO = searchSimVesselListConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LaneSimulationDBDAOSearchSimVesselListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSimVesselListVO .class);
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
     * Lane Info I/F : MDM의 Lane 정보 및 P/F SKD의 frequency 정보 I/F (port_rotn_seq기준 내림차순 정렬)<br>
     * @param  LaneInfoListConditionVO laneInfoListConditionVO
     * @return List<SearchLaneInfoListVO>
     * @throws DAOException
     */
	public List<SearchLaneInfoListVO> searchLaneInfoList(LaneInfoListConditionVO laneInfoListConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchLaneInfoListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(laneInfoListConditionVO != null){
				Map<String, String> mapVO = laneInfoListConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LaneSimulationDBDAOSearchLaneInfoListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchLaneInfoListVO .class);
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
     * Simulation 연동된 Continent pair 정보를 조회한다.<br>
     * 9008633 2009.03.14
     * @param  SearchSimContiPairListVO  searchSimContiPairListVO
     * @return List<SearchSimContiPairListVO>
     * @throws DAOException
     */
    public List<SearchSimContiPairListVO> searchSimContiPairList (SearchSimContiPairListVO  searchSimContiPairListVO ) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchSimContiPairListVO > list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(searchSimContiPairListVO != null){
				Map<String, String> mapVO = searchSimContiPairListVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LaneSimulationDBDAOSearchSimContiPairListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSimContiPairListVO .class);
			
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
     * COA_SIM_DTL_REV_LANE 의 여러 데이타 모델을 지정된 ibflag 값에 따라 DB에 반영한다.(I/U)<br>
     * 9008633 2009.08.24
     * @param SearchSimContiPairListVO vo
     * @throws DAOException
     *
     */
	public void addSimContiPairList(SearchSimContiPairListVO vo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new LaneSimulationDBDAOMultiSimContiPairCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
    /**
     * COA_SIM_DTL_REV_LANE 의 여러 데이타 모델을 지정된 ibflag 값에 따라 DB에 반영한다.(I/U)<br>
     * 9008633 2009.03.14
     * @param SearchSimContiPairListVO vo
     * @throws DAOException
     *
     */
	public void modifySimContiPairList(SearchSimContiPairListVO vo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new LaneSimulationDBDAOMultiSimContiPairUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
    /**
     * COA_SIM_DTL_REV_LANE 의 여러 데이타 모델을 지정된 ibflag 값에 따라 DB에 반영한다.(I/U)<br>
     * 9008633 2009.03.14
     * @param SearchSimContiPairListVO vo
     * @throws DAOException
     *
     */
	public void deleteSimContiPairList(SearchSimContiPairListVO vo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new LaneSimulationDBDAOMultiSimContiPairDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Step1 :IAS T/S Volume 팝업화면 정보를 조회한다.[ESM_COA_0169]<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @return List<SearchTsVolumeVO>
	 * @throws DAOException
	 */
	public List<SearchTsVolumeVO> searchSimTsVolumeList(SearchConditionVO searchConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchTsVolumeVO> list = null;
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LaneSimulationDBDAOSearchTsVolumeRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchTsVolumeVO.class);
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
	 * Step1 :IAS T/S Volume 팝업화면 정보를 저장한다.[ESM_COA_0169]<br>
	 * 
	 * @param List<CoaSimIntrTrnsVolVO> insModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] addmultiSimTsVolumeS(List<CoaSimIntrTrnsVolVO> insModels) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new LaneSimulationDBDAOMultiTsVolumeCSQL(), insModels,null);
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
	 * Step1 :IAS T/S Volume 팝업화면 정보를 수정한다.[ESM_COA_0169]<br>
	 * 
	 * @param List<CoaSimIntrTrnsVolVO> updModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] modifymultiSimTsVolumeS(List<CoaSimIntrTrnsVolVO> updModels) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new LaneSimulationDBDAOMultiTsVolumeUSQL(), updModels,null);
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
	 * Step1 :IAS T/S Volume 팝업화면 정보를 삭제한다.[ESM_COA_0169]<br>
	 * 
	 * @param List<CoaSimIntrTrnsVolVO> delModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] removemultiSimTsVolumeS(List<CoaSimIntrTrnsVolVO> delModels) throws DAOException,Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new LaneSimulationDBDAOMultiTsVolumeDSQL(), delModels,null);
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
	 * Step1 :Non Operating Expense 팝업화면 정보를 조회한다.[ESM_COA_0164]<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @return List<CoaSimNonOpExpnVO>
	 * @throws DAOException
	 */
	public List<CoaSimNonOpExpnVO> searchNonOpExpnList(SearchConditionVO searchConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CoaSimNonOpExpnVO> list = null;
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LaneSimulationDBDAOSearchNonOpExpnRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CoaSimNonOpExpnVO.class);
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
	 * Step1 :Non Operating Expense 팝업화면 정보를 저장한다.[ESM_COA_0164]<br>
	 * 
	 * @param List<CoaSimNonOpExpnVO> insModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] addmultiNonOpExpn(List<CoaSimNonOpExpnVO> insModels) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new LaneSimulationDBDAOMultiNonOpExpnCSQL(), insModels,null);
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
	 * Step1 :Non Operating Expense 팝업화면 정보를 수정한다.[ESM_COA_0169]<br>
	 * 
	 * @param List<CoaSimNonOpExpnVO> updModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] modifymultiNonOpExpn(List<CoaSimNonOpExpnVO> updModels) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new LaneSimulationDBDAOMultiNonOpExpnUSQL(), updModels,null);
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
	 * Step1 :Non Operating Expense 팝업화면 정보를 삭제한다.[ESM_COA_0169]<br>
	 * 
	 * @param List<CoaSimNonOpExpnVO> delModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] removemultiNonOpExpn(List<CoaSimNonOpExpnVO> delModels) throws DAOException,Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new LaneSimulationDBDAOMultiNonOpExpnDSQL(), delModels,null);
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
     * COA_SIM_INFO, COA_SIM_RPT_MST 목록을 가져온다.<br>
     * 2009.02.18 수정 
     * 
     * @param  SearchFileMgmtListVO searchFileMgmtListVO
     * @return List<SearchFileMgmtListVO>
     * @throws DAOException
     */
    public List<SearchFileMgmtListVO> searchFileMgmtList (SearchFileMgmtListVO searchFileMgmtListVO) throws DAOException {
    	DBRowSet dbRowset = null;
		List<SearchFileMgmtListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			if(searchFileMgmtListVO != null){
				param.put("f_slan_cd",searchFileMgmtListVO.getSlanCd());
				param.put("user_id",searchFileMgmtListVO.getUserId());
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LaneSimulationDBDAOSearchFileMgmtListRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchFileMgmtListVO .class);
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
     *  Step2 : Tab2 : Report 정보를 삭제 한다. <br>
     * 
     * @param SearchFileMgmtListVO[] vos
     * @throws DAOException
     */
    public void multiFileMgmt(SearchFileMgmtListVO[] vos) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam =null;
		String[] tableArr = {"coa_sim_smry_rpt","coa_sim_rpt_mst"};
		String[] tableArr2 = {"coa_sim_smry_rpt","coa_sim_rpt_mst"
							,"coa_sim_ntwk_cost","coa_sim_bnk_cost","coa_sim_dly_hir","coa_sim_port_chg"
							,"coa_sim_ctrb_mgn_cost","coa_sim_vol_prj","coa_sim_tml_op_dys","coa_sim_tml_info"
							,"coa_sim_intr_trns_vol","coa_sim_vsl_set_info","coa_sim_svc_lane","coa_sim_info"};
		try {
			for(int i=0;i<vos.length;i++) {
				if(vos[i].getIbflag().equals("D")) {
					if(!vos[i].getReport().substring(2, 5).equals("001")) {
						for(int j=0;j < tableArr.length-1;j++) {
							param.put("sim_dt",vos[i].getSimDt());
							param.put("sim_no",vos[i].getSimNo());
							param.put("sim_rpt_no",vos[i].getSimRptNo());
							velParam= new HashMap<String, Object>();
							velParam.put("table_name", tableArr[j]);
							SQLExecuter sqlExe = new SQLExecuter("");
							int result = sqlExe.executeUpdate((ISQLTemplate)new LaneSimulationDBDAOMultiFileMgmtDSQL(), param, velParam);
							if(result == Statement.EXECUTE_FAILED)
								throw new DAOException("Fail to insert SQL");
						}
					} else {
						for(int j=0;j < tableArr2.length-1;j++) {	
							param.put("sim_dt",vos[i].getSimDt());
							param.put("sim_no",vos[i].getSimNo());
							velParam= new HashMap<String, Object>();
							velParam.put("table_name", tableArr2[j]);
							SQLExecuter sqlExe = new SQLExecuter("");
							int result = sqlExe.executeUpdate((ISQLTemplate)new LaneSimulationDBDAOMultiFileMgmtDSQL(), param, velParam);
							if(result == Statement.EXECUTE_FAILED)
								throw new DAOException("Fail to insert SQL");
						}
					}
				}
			}
		}  catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
    } 

    /**
     * BSA by VVD (Popup)<br>
     * 
     * @param  SearchBSAbyVVDListConditionVO searchBSAbyVVDListConditionVO
     * @return SearchBSAbyVVDListVO
     * @throws DAOException
     */
   	public SearchBSAbyVVDListVO searchBSAbyVVDList(SearchBSAbyVVDListConditionVO searchBSAbyVVDListConditionVO) throws DAOException {
    		DBRowSet dbRowset = null;
    		SearchBSAbyVVDListVO rVo = null;
    		//query parameter
    		Map<String, Object> param = new HashMap<String, Object>();
    		//velocity parameter
    		Map<String, Object> velParam = new HashMap<String, Object>();

    		try{
    			if(searchBSAbyVVDListConditionVO != null){
    				Map<String, String> mapVO = searchBSAbyVVDListConditionVO .getColumnValues();
    			
    				param.putAll(mapVO);
    				velParam.putAll(mapVO);
    			}
    			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LaneSimulationDBDAOSearchBSAbyVVDListRSQL(), param, velParam);
    			//list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchBSAbyVVDListVO .class);
    			rVo = new SearchBSAbyVVDListVO();
    			rVo.setRowSet(dbRowset);    			
    		} catch(SQLException se) {
    			log.error(se.getMessage(),se);
    			throw new DAOException(new ErrorHandler(se).getMessage());
    		} catch(Exception ex) {
    			log.error(ex.getMessage(),ex);
    			throw new DAOException(new ErrorHandler(ex).getMessage());
    		}
    		return rVo;
    } 
    
    /*  ESM_COA_0052 ======================================================================================================================================= */
    /**
     * Step2 : Tab1 : Port/TMNL Setting > Port 정보 변경시 해당 Yard Code를 조회한다.<br>
     * 
     * @param SearchSimYardConditionVO vo
     * @param String newLine
     * @return List<SearchSimYardListVO>
     * @throws DAOException
     */
    public List<SearchSimYardListVO> searchSimYardList(SearchSimYardConditionVO vo,String newLine) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchSimYardListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vo != null){
				Map<String, String> mapVO = vo .getColumnValues();
				param.putAll(mapVO);
				velParam.put("newLine",newLine);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LaneSimulationDBDAOSearchSimYardListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSimYardListVO .class);
			
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
     * Step2 : Tab1 : Port/TMNL Setting > Retrieve <br>
     * 
     * @param  SearchSimLaneListConditionVO searchSimLaneListConditionVO
     * @return List<SearchSimPortListVO>
     * @throws DAOException
     */
    public List<SearchSimPortListVO> searchSimPortList(SearchSimLaneListConditionVO searchSimLaneListConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchSimPortListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchSimLaneListConditionVO != null){
				Map<String, String> mapVO = searchSimLaneListConditionVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LaneSimulationDBDAOSearchSimPortListRSQL(), param, velParam);
			//vo.setDbRowset(dbRowset);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSimPortListVO .class);
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
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SearchSimPortListVO vo
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int modifySimInfo(SearchSimPortListVO vo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		int result = 0;
		try {
			param.put("sim_dt",vo.getSimDt());
			param.put("sim_no", vo.getSimNo());
			param.put("f_svc_dur_dys", vo.getSvcDurDys());
			param.put("f_brth_itval_dys", vo.getBrthItvalDys());
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new LaneSimulationDBDAOModifySimInfoUSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
    
    
    /**
     * Step2 : Tab1 : Port/TMNL Setting > Insert <br>
     * 
     * @param List<SearchSimPortListVO> insModels
     * @return int[]
     * @throws DAOException
     * @throws Exception
     */
    
	public int[] addSimPortInfo(List<SearchSimPortListVO> insModels) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new LaneSimulationDBDAOMultiSimPortListCSQL(), insModels,null);
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
     * Step2 : Tab1 : Port/TMNL Setting > Update <br>
     * 
     * @param List<CoaSimTmlInfoVO> insModels
     * @return int[]
     * @throws DAOException
     * @throws Exception
     */
	
	public int[] updateSimPortInfo(List<CoaSimTmlInfoVO> insModels) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new LaneSimulationDBDAOMultiSimPortListUSQL(), insModels,null);
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
     * Step2 : Tab1 : Port/TMNL Setting > Delete <br>
     * 
     * @param List<SearchSimPortListVO> insModels
     * @return int[]
     * @throws DAOException
     * @throws Exception
     */
	
	public int[] deleteSimPortInfo(List<SearchSimPortListVO> insModels) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insModels.size() > 0){
				Map<String, Object> velparam = new HashMap<String, Object>();
				for(int i=0;i<insModels.size();i++) {
					velparam.put("skd_dir_cd",insModels.get(i).getSkdDirCd());
					velparam.put("tml_cd",insModels.get(i).getTmlCd());
					velparam.put("vsl_dbl_call_seq",insModels.get(i).getVslDblCallSeq());
				}
				insCnt = sqlExe.executeBatch((ISQLTemplate)new LaneSimulationDBDAOMultiSimPortListDSQL(), insModels,velparam);
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
     * Step2 : Tab1 : Port/TMNL Setting > Vessel ranking 3 <br>
     * 
     * @param SearchSimLaneListConditionVO vo
     * @return SearchSimPortListVO
     * @throws DAOException
     */
	
	public SearchSimPortListVO searchVslClassRank3(SearchSimLaneListConditionVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		SearchSimPortListVO rVo = null;
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			if(vo!= null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LaneSimulationDBDAOSearchVslClassRank3RSQL(),param, null);
			rVo = new SearchSimPortListVO();
			rVo.setRowSet(dbRowset);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			log.error("err "+se.toString(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			log.error("err "+ex.toString(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rVo;		
	}   
	
	/**
     * Step2 : Tab1 : Port/TMNL Setting > INSERT 시 MANU IN / OUT 값을 조회 <br>
     * 
     * @param SearchSimLaneListConditionVO vo
     * @return SearchSimPortListVO
     * @throws DAOException
     */
	
	public SearchSimPortListVO searchManuInOut(SearchSimLaneListConditionVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		SearchSimPortListVO rVo = null;
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			if(vo!= null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LaneSimulationDBDAOSearchManuInOutRSQL(),param, null);
			rVo = new SearchSimPortListVO();
			rVo.setRowSet(dbRowset);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			log.error("err "+se.toString(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			log.error("err "+ex.toString(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rVo;		
	}   	
	
    /**
     * Step2 : Tab1 : Port/TMNL Setting > INSERT 시 DISTANCE,PORT BUFFER,CRN_KNT,TML_PROD_QTY를 조회 <br>
     * 
     * @param SearchSimLaneListConditionVO vo
     * @return SearchSimPortListVO
     * @throws DAOException
     */	
	
	public SearchSimPortListVO searchTmlDistance(SearchSimLaneListConditionVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		SearchSimPortListVO rVo = null;
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			if(vo!= null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LaneSimulationDBDAOSearchTmlDistanceRSQL(),param, null);
			rVo = new SearchSimPortListVO();
			rVo.setRowSet(dbRowset);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			log.error("err "+se.toString(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			log.error("err "+ex.toString(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rVo;		
	} 	
	
	
    /**
     * Step2 : Tab1 : Port/TMNL Setting > INSERT 시 vessel의 평균 속도를 조회 <br>
     * 
     * @param SearchSimLaneListConditionVO vo
     * @return SearchSimPortListVO
     * @throws DAOException
     */	
	
	public SearchSimPortListVO searchTmlSeaSpeed(SearchSimLaneListConditionVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		SearchSimPortListVO rVo = null;
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			if(vo!= null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LaneSimulationDBDAOSearchTmlSeaSpeedRSQL(),param, null);
			rVo = new SearchSimPortListVO();
			rVo.setRowSet(dbRowset);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			log.error("err "+se.toString(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			log.error("err "+ex.toString(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rVo;		
	}

    /**
     * Step2 : Tab1 : Port/TMNL Setting > Ocean Outbound qty 가져오기 <br>
     * 
     * @param String simDt
     * @param String simNo
     * @return LaneSimulationCommonVO
     * @throws DAOException
     */		
		
	public LaneSimulationCommonVO searchOceanQty(String simDt,String simNo) throws DAOException {
		DBRowSet dbRowset = null;
		LaneSimulationCommonVO rVo = null;
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			if(simDt != null){
				param.put("f_sim_dt",simDt);
				param.put("f_sim_no",simNo);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LaneSimulationDBDAOTransferPortSendRSQL(),param, null);
			rVo = new LaneSimulationCommonVO();
			rVo.setRowSet(dbRowset);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			log.error("err "+se.toString(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			log.error("err "+ex.toString(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rVo;		
	}

    /**
     * Step2 : Tab3 : TMNL Transit Time > Retrieve
     *                            COA_SIM_TML_OP_DYS 의 목록을 가져온다.<br>
     * 
     * @param  SearchTMLOPDysListVO vo
     * @return List<SearchTMLOPDysListVO>
     * @throws DAOException
     */
    public List<SearchTMLOPDysListVO> searchTMLOPDysList(SearchTMLOPDysListVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchTMLOPDysListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vo != null){
				Map<String, String> mapVO = vo .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LaneSimulationDBDAOSearchTMLOPDysListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchTMLOPDysListVO .class);
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
     * Step2 : Tab3 : TMNL Transit Time > Save
     *                                    COA_SIM_TML_OP_DYS 의 데이터를 수정한다..<br>
     * 
     * @param SearchTMLOPDysListVO vo
     * @return int[]
     * @throws DAOException
     * @throws Exception
     */
	public int[] modifyTMLOPDys(SearchTMLOPDysListVO vo) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(vo.getMultiUpdateList().size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new LaneSimulationDBDAOModifyTMLOPDysListUSQL(), vo.getMultiUpdateList(),null);
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
     * Step2 : Tab3 : TMNL Transit Time > Create
     * COA_SIM_TML_OP_DYS 의 데이터를 생성한다..<br>
     * 
     * @param SearchTMLOPDysListVO vo
     * @throws DAOException
     * @throws Exception
     */
	
	public void deleteTMLOPDys(SearchTMLOPDysListVO vo) throws DAOException,Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			if(vo != null) {
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				SQLExecuter sqlExe = new SQLExecuter("");
				sqlExe.executeUpdate((ISQLTemplate)new LaneSimulationDBDAODeleteTMLOPDysListDSQL(), param, null);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	
    /**
     * Step2 : Tab3 : TMNL Transit Time > OPDys create
     * COA_SIM_TML_OP_DYS 의 데이터를 생성한다..<br>
     * 
     * @param SearchTMLOPDysListVO vo
     * @throws DAOException
     * @throws Exception
     */	
	public void createTMLOPDys(SearchTMLOPDysListVO vo) throws DAOException,Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			if(vo != null) {
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				SQLExecuter sqlExe = new SQLExecuter("");
				sqlExe.executeUpdate((ISQLTemplate)new LaneSimulationDBDAOCreateTMLOPDysCSQL(), param, null);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	
	
    /**
     * Step2 : Tab2 : Route Projection - Lane G.RPB Projection > Retrieve
     *                                                           COA_SIM_SVC_LANE의 목록을 가져온다.<br>
     * @param  SearchSimLaneListConditionVO searchSimLaneListConditionVO
     * @return List<SearchSimLaneRPBListVO>
     * @throws DAOException
     */


    public List<SearchSimLaneRPBListVO> searchSimLaneRPBList(SearchSimLaneListConditionVO searchSimLaneListConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchSimLaneRPBListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchSimLaneListConditionVO!= null){
				Map<String, String> mapVO = searchSimLaneListConditionVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LaneSimulationDBDAOSearchSimLaneRPBListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSimLaneRPBListVO .class);
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
     * Step2 : Tab2 : Route Projection - Lane G.RPB Projection > Save
     *                                                           COA_SIM_SVC_LANE의 여러 데이타 모델을 지정된 ibflag 값에 따라 DB에 반영한다.(수정)<br>
     * 
     * @param SearchSimLaneRPBListVO vo
     * @param SignOnUserAccount account
     * @throws DAOException
     */
    public void modifySimGrpb(SearchSimLaneRPBListVO vo,SignOnUserAccount account) throws DAOException {
    	
    	//LaneSimulationDBDAOModifySimGrpbUSQL.Query
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			param.putAll(mapVO);
			param.put("upd_usr_id", account.getUpd_usr_id());
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new LaneSimulationDBDAOModifySimGrpbUSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
    }
    /**
     * Step2 : Tab2 : Route Projection - Lane G.RPB Projection > Volume 에서 Creation 후 GRPB 값을 변경한다.
     *                                                           COA_SIM_SVC_LANE의 여러 데이타 모델을 지정된 ibflag 값에 따라 DB에 반영한다.(수정)<br>
     * 
     * @param List<MergyVolProjConditionVO> vo
     * @throws DAOException
     */
	public void modifySimGrpb2(List<MergyVolProjConditionVO> vo) throws DAOException {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(vo.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new LaneSimulationDBDAOModifySimGrpb2CSQL(), vo,null);
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
	}	    


    /**
     * Step2 : Tab2 : Route Projection - Volume > Header 정보를 조회한다.
     * 
     * @param  SearchSimConditionVO vo
     * @return SearchSimRtnRowSetVO
     * @throws DAOException
     */

	
	public SearchSimRtnRowSetVO searchSimPort(SearchSimConditionVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		SearchSimRtnRowSetVO rtnVO = null;
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			if(vo!= null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
			} 
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LaneSimulationDBDAOSearchSimPortRSQL(),param, null);
			rtnVO = new SearchSimRtnRowSetVO();
			rtnVO.setRowSet(dbRowset);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			log.error("err "+se.toString(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			log.error("err "+ex.toString(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return rtnVO;		
	}   
    /**
     * Step2 : Tab2 : Route Projection - Volume > Header 정보를 조회한다.
     * 
     * @param  SearchSimLaneListConditionVO vo
     * @return SearchSimRtnRowSetVO
     * @throws DAOException
     */
	public SearchSimRtnRowSetVO searchSimPort(SearchSimLaneListConditionVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		SearchSimRtnRowSetVO rVo = null;
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			if(vo!= null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LaneSimulationDBDAOSearchSimPortRSQL(),param, null);
			rVo = new SearchSimRtnRowSetVO();
			//vo.setRowSet(dbRowset);
			rVo.setRowSet(dbRowset);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			log.error("err "+se.toString(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			log.error("err "+ex.toString(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return rVo;		
	}    	
	
    /**
     * Step2 : Tab2 : Route Projection - Volume > Retrieve
     *                                            COA_SIM_VOL_PRJ 목록을 가져온다.<br>
     * 
     * @param  SearchSimConditionVO searchSimConditionVO
     * @param  String pHeader
     * @return SearchSimRtnRowSetVO
     * @throws DAOException
     */
	public SearchSimRtnRowSetVO searchSimVolProjList(SearchSimConditionVO searchSimConditionVO, String pHeader) throws DAOException {
		DBRowSet dbRowset = null;
		SearchSimRtnRowSetVO rVo = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();		
		try{
			if(searchSimConditionVO!= null){
				String tmpStr = pHeader;
		        if(tmpStr.equals("")) tmpStr = " | ";
		        String[] header = tmpStr.split("[|]");
				Map<String, String> mapVO = searchSimConditionVO.getColumnValues();
				param.putAll(mapVO);
				List<String> aryYdSeq = new ArrayList();   
				for(int i = 0; i < header.length; i++){   
				    aryYdSeq.add(header[i]);   
				}   
				velParam.put("header", aryYdSeq);
				int header_size = header.length-1;
				velParam.put("header_size", header_size);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LaneSimulationDBDAOSearchSimVolProjListRSQL(), param, velParam);
			rVo = new SearchSimRtnRowSetVO();
			rVo.setRowSet(dbRowset);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			log.error("err "+se.toString(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			log.error("err "+ex.toString(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rVo;		
	}	

    /**
     * Step2 : Tab2 : Route Projection - Volume > Save
     *                                            COA_SIM_VOL_PRJ의 여러 데이타 모델을 지정된 ibflag 값에 따라 DB에 반영한다.(수정)<br>
     * 
     * @param MergyVolProjConditionVO vo
     * @throws DAOException
     */
	
	public void multiSimVolProj(MergyVolProjConditionVO vo) throws DAOException {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(vo.getMultiCreateList().size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new LaneSimulationDBDAOMultiSimVolProjCSQL(), vo.getMultiCreateList(),null);
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
	}	 
    
    /**
     * Step2 : Tab2 : Route Projection - Volume > Save
     *                                            COA_SIM_VOL_PRJ의 여러 데이타 모델을 지정된 ibflag 값에 따라 DB에 반영한다.(수정)<br>
     * 
     * @param List<MergyVolProjConditionVO> vo
     * @throws DAOException
     */

	public void multiSimCtrbMgnCost(List<MergyVolProjConditionVO> vo) throws DAOException {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(vo.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new LaneSimulationDBDAOMultiSimCtrbMgnCostCSQL(), vo,null);
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
	}	 

    /**
     * Step2 : Tab2 : Route Projection - Volume > Creation
     *                                            Ccoa_sim_vol_prj 데이터 삭제.
     * 
     * @param MergyVolProjConditionVO vo
     * @throws DAOException
     */
	
	public void deleteSimVolProj(MergyVolProjConditionVO vo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new LaneSimulationDBDAOCreateSimVolProjDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
    /**
     * Step2 : Tab2 : Route Projection - Volume > Creation
     *                                            coa_sim_ctrb_mgn_cost 데이터 삭제.
     * 
     * @param MergyVolProjConditionVO vo
     * @throws DAOException
     */
	
	public void deleteSimVolProj2(MergyVolProjConditionVO vo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new LaneSimulationDBDAOCreateSimVolProj2DSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	
    /**
     * Step2 : Tab2 : Route Projection - Volume > Creation
     *                                            COA_SIM_VOL_PRJ, COA_SIM_CTRB_MGN_COST 데이터 생성.
     * 
     * @param MergyVolProjConditionVO vo
     * @param SearchSimRtnRowSetVO vo2
     * @param SignOnUserAccount account
     * @throws DAOException
     */	
	public void createSimVolProj1(MergyVolProjConditionVO vo,SearchSimRtnRowSetVO vo2,SignOnUserAccount account) throws DAOException {
		DBRowSet dbRowset = null;
		List<MergyVolProjConditionVO> parentArr = new ArrayList<MergyVolProjConditionVO>(); 
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
	    String sim_dt    = JSPUtil.getNull(vo.getSimDt()).replaceAll("-","");
	    String sim_no    = JSPUtil.getNull(vo.getSimNo());
	    int prd_cd    = Integer.parseInt(JSPUtil.getNull(vo.getPrdCd()));
	    String trd_cd    = JSPUtil.getNull(vo.getTrdCd());
	    String rlane_cd  = JSPUtil.getNull(vo.getRLaneCd());
	    String dir_cd    = JSPUtil.getNull(vo.getDirCd());
	    
		try{
			param.put("cre_usr_id",account.getUsr_id());
			param.put("upd_usr_id",account.getUsr_id());
			param.put("trd_cd"    ,trd_cd);
			param.put("rlane_cd"  ,rlane_cd);
			param.put("dir_cd"	  ,dir_cd);
			param.put("sim_dt"	  ,sim_dt);
			param.put("sim_no"	  ,sim_no);
			param.put("prd_cd"	  ,prd_cd);			
			if(vo2!= null){
				dbRowset = vo2.getRowSet();
				velParam.put("rowcnt", dbRowset.getRowCount());
				//Map<String, Object> Mapvo = new HashMap<String, Object>();
				while(dbRowset.next()) {
					MergyVolProjConditionVO retVo = new MergyVolProjConditionVO();
					retVo.setDTmlCd(dbRowset.getString("tml_cd"));
					retVo.setDNum(dbRowset.getString("num"));
					retVo.setDSectNo(dbRowset.getString("sect_no"));
					parentArr.add(retVo);
				}
				velParam.put("parentArr", parentArr);
			}
			velParam.put("trd_cd"    ,trd_cd);
			velParam.put("prd_cd", prd_cd);
			velParam.put("rlane_cd"  ,rlane_cd);
			velParam.put("dir_cd"	 ,dir_cd);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new LaneSimulationDBDAOCreateSimVolProj1CSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			log.error("err "+se.toString(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			log.error("err "+ex.toString(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	
    /**
     * Step2 : Tab2 : Route Projection - Volume > Creation
     *                                            COA_SIM_VOL_PRJ, COA_SIM_CTRB_MGN_COST 데이터 생성.
     * 
     * @param MergyVolProjConditionVO vo
     * @param SignOnUserAccount account
     * @throws DAOException
     */	
	public void createSimVolProj2(MergyVolProjConditionVO vo,SignOnUserAccount account) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();	
	    String sim_dt    = JSPUtil.getNull(vo.getSimDt()).replaceAll("-","");
	    String sim_no    = JSPUtil.getNull(vo.getSimNo());
	    int prd_cd       = Integer.parseInt(JSPUtil.getNull(vo.getPrdCd()));
	    String trd_cd    = JSPUtil.getNull(vo.getTrdCd());
	    String rlane_cd  = JSPUtil.getNull(vo.getRLaneCd());
	    String dir_cd    = JSPUtil.getNull(vo.getDirCd());		
	    try{
			param.put("cre_usr_id",account.getUsr_id());
			param.put("upd_usr_id",account.getUsr_id());
			param.put("trd_cd"    ,trd_cd);
			param.put("rlane_cd"  ,rlane_cd);
			param.put("dir_cd"	  ,dir_cd);
			param.put("sim_dt"	  ,sim_dt);
			param.put("sim_no"	  ,sim_no);
			param.put("prd_cd"	  ,prd_cd);
			velParam.put("trd_cd"    ,trd_cd);
			velParam.put("rlane_cd"  ,rlane_cd);
			velParam.put("dir_cd"	  ,dir_cd);
			velParam.put("prd_cd", prd_cd);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new LaneSimulationDBDAOCreateSimVolProj2CSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			log.error("err "+se.toString(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			log.error("err "+ex.toString(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	   	
	
    /**
     * Step2 : Tab2 : Route Projection - G.RPB > Retrieve
     *                                            COA_SIM_VOL_PRJ 목록을 가져온다.<br>
     * 
     * @param  SearchSimConditionVO searchSimConditionVO
     * @param  String pHeader
     * @return SearchSimRtnRowSetVO
     * @throws DAOException
     */

	public SearchSimRtnRowSetVO searchSimGrpbProjList(SearchSimConditionVO searchSimConditionVO, String pHeader) throws DAOException {
		DBRowSet dbRowset = null;
		SearchSimRtnRowSetVO rVo = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();		
		try{
			if(searchSimConditionVO!= null){
				String tmpStr = pHeader;
		        if(tmpStr.equals("")) tmpStr = " | ";
		        String[] header = tmpStr.split("[|]");
				Map<String, String> mapVO = searchSimConditionVO.getColumnValues();
				param.putAll(mapVO);
				List<String> aryYdSeq = new ArrayList();   
				for(int i = 0; i < header.length; i++){   
				    aryYdSeq.add(header[i]);   
				}   
				velParam.put("header", aryYdSeq);
				int header_size = header.length-1;
				velParam.put("header_size", header_size);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LaneSimulationDBDAOSearchSimGrpbProjListRSQL(), param, velParam);
			rVo = new SearchSimRtnRowSetVO();
			rVo.setRowSet(dbRowset);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			log.error("err "+se.toString(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			log.error("err "+ex.toString(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rVo;		
	}	    

    /**
     * Step2 : Tab2 : Route Projection - G.RPB > Save
     *                                            COA_SIM_VOL_PRJ의 여러 데이타 모델을 지정된 ibflag 값에 따라 DB에 반영한다.(수정)<br>
     * 
     * @param MergyVolProjConditionVO vo
     * @throws DAOException
     */
    
	public void multiSimGrpbProj(MergyVolProjConditionVO vo) throws DAOException {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(vo.getMultiCreateList().size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new LaneSimulationDBDAOMultiSimGrpbProjUSQL(), vo.getMultiCreateList(),null);
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
	}	    

    /**
     * Step2 : Tab2 : Route Projection - G.RPB > Save<br>
     * COA_SIM_VOL_PRJ의 여러 데이타 모델을 지정된 ibflag 값에 따라 DB에 반영한다.(수정)<br>
     * 
     * @param SearchSimLaneRPBListVO vo
     * @param SignOnUserAccount account
     * @throws DAOException
     */
    public void modifySimGrpbProj(SearchSimLaneRPBListVO vo,SignOnUserAccount account) throws DAOException {
    	//LaneSimulationDBDAOModifySimGrpbProjUSQL.java    	
    	Map<String, Object> param = new HashMap<String, Object>();
    	try {
    		Map<String, String> mapVO = vo.getColumnValues();
    		param.putAll(mapVO);
    		param.put("upd_usr_id", account.getUpd_usr_id());
    		SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new LaneSimulationDBDAOModifySimGrpbProjUSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
    	}
    }
    /**
     * Step2 : Tab2 : Route Projection - G.RPB > Save<br>
     *  COA_SIM_VOL_PRJ의 여러 데이타 모델을 지정된 ibflag 값에 따라 DB에 반영한다.(수정)<br>
     * 
     * @param List<SearchSimLaneRPBListVO> vo
     * @throws DAOException
     */
	public void modifySimGrpbProj(List<SearchSimLaneRPBListVO> vo) throws DAOException {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(vo.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new LaneSimulationDBDAOModifySimGrpbProjUSQL(), vo,null);
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
	}
    
    /*  ESM_COA_0053 ======================================================================================================================================= */
    /**
     * Step3 : Tab1 : CM_Lane Summary > Retrieve.<br>
     * COA_SIMPORT_FNC function 사용(port정보를 '|' 구분자로 연결해서 리턴한다.) 
     * @param  SearchSimConditionVO vo
     * @return SearchSimRtnRowSetVO
     * @throws DAOException
     */
	public SearchSimRtnRowSetVO searchSimCgoCostList(SearchSimConditionVO vo) throws DAOException {
		DBRowSet rowSet = null;
		SearchSimRtnRowSetVO rtnVO = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();	
		
		try{
			if(vo!= null){
				String cm_header = vo.getFCmHeader();
		        if(cm_header.equals("")) cm_header = " | ";
		        String[] header = cm_header.split("[|]");
		        
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				List<String> aryYdSeq = new ArrayList();   
				for(int i = 0; i < header.length; i++){
				    aryYdSeq.add(header[i]);   
				}   
				velParam.put("header", aryYdSeq);
				int header_size = header.length-1;
				velParam.put("header_size", header_size);
			}
			rowSet = new SQLExecuter("").executeQuery((ISQLTemplate)new LaneSimulationDBDAOSearchSimCgoCostListRSQL(), param, velParam);
			rtnVO = new SearchSimRtnRowSetVO();
			rtnVO.setRowSet(rowSet);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			log.error("err "+se.toString(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			log.error("err "+ex.toString(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnVO;		
	}		
    /**
     * Step3 : Tab1 : CM_Route Summary1 > Retrieve.<br>
     * 
     * @param  SearchSimConditionVO vo
     * @param  String pHeader
     * @return SearchSimRtnRowSetVO
     * @throws DAOException
     */
	public SearchSimRtnRowSetVO searchSimCMCostList(SearchSimConditionVO vo, String pHeader) throws DAOException {
		DBRowSet rowSet = null;
		SearchSimRtnRowSetVO rtnVO = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();		
		try{
			if(vo!= null){
				String tmpStr = pHeader;
		        if(tmpStr.equals("")) tmpStr = " | ";
		        String[] header = tmpStr.split("[|]");
		        
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				
				List<String> aryYdSeq = new ArrayList();   
				for(int i = 0; i < header.length; i++){
				    aryYdSeq.add(header[i]);   
				}   
				velParam.put("header", aryYdSeq);
				int header_size = header.length-1;
				velParam.put("rowcnt", header_size);
			}
			
			rowSet = new SQLExecuter("").executeQuery((ISQLTemplate)new LaneSimulationDBDAOSearchSimCMCostListRSQL(), param, velParam);
			rtnVO = new SearchSimRtnRowSetVO();
			rtnVO.setRowSet(rowSet);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			log.error("err "+se.toString(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			log.error("err "+ex.toString(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnVO;		
	}		
    /**
     * Step3 : Tab1 : CM_Route Summary1 > Save.<br>
     * 
     * @param List<CoaSimCtrbMgnCostVO> list
     * @return int[]
     * @throws DAOException
     */
    public int[] addSimCMCost(List<CoaSimCtrbMgnCostVO> list) throws DAOException {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(list.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new LaneSimulationDBDAOModifySimCMCostCSQL(), list,null);
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
     * Step3 : Tab1 : CM_Route Summary1 > Save.<br>
     * 
     * @param SearchSimConditionVO vo
     * @return int
     * @throws DAOException
     */
    public int removeSimCMCost(SearchSimConditionVO vo) throws DAOException {
		int delCnt = 0;
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			if(vo!= null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				
				SQLExecuter sqlExe = new SQLExecuter("");
				delCnt = sqlExe.executeUpdate((ISQLTemplate)new LaneSimulationDBDAOModifySimCMCostDSQL(), param,null);
				if(delCnt== Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert No SQL");
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
     * Step3 : Tab1 : CM_Route Summary1 > Retrieve.<br>
     * 
     * @param  SearchSimConditionVO vo
     * @param  String pHeader
     * @return SearchSimRtnRowSetVO
     * @throws DAOException
     */							
	public SearchSimRtnRowSetVO searchSimVolProjList2(SearchSimConditionVO vo, String pHeader) throws DAOException {
		DBRowSet rowSet = null;
		SearchSimRtnRowSetVO rtnVO = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();		
		try{
			if(vo!= null){
				String tmpStr = pHeader;
		        if(tmpStr.equals("")) tmpStr = " | ";
		        String[] header = tmpStr.split("[|]");
		        
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				
				List<String> aryYdSeq = new ArrayList();   
				for(int i = 0; i < header.length; i++){
				    aryYdSeq.add(header[i]);   
				}   
				velParam.put("header", aryYdSeq);
				int header_size = header.length-1;
				velParam.put("rowcnt", header_size);
			}
			
			rowSet = new SQLExecuter("").executeQuery((ISQLTemplate)new LaneSimulationDBDAOSearchSimVolProjList2RSQL(), param, velParam);
			rtnVO = new SearchSimRtnRowSetVO();
			rtnVO.setRowSet(rowSet);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			log.error("err "+se.toString(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			log.error("err "+ex.toString(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnVO;		
	}	    

    /**
     * Step3 : Tab2 : Port Charge > Retrieve.<br>
     * 
     * @param  SearchSimConditionVO vo
     * @return List<SearchSimPortChargeListVO>
     * @throws DAOException
     */
	public List<SearchSimPortChargeListVO> searchSimPortChargeList(SearchSimConditionVO vo) throws DAOException {
		DBRowSet rowSet = null;
		List<SearchSimPortChargeListVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			if(vo!= null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
			}
			
			rowSet = new SQLExecuter("").executeQuery((ISQLTemplate)new LaneSimulationDBDAOSearchSimPortChargeListRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(rowSet, SearchSimPortChargeListVO.class);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			log.error("err "+se.toString(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			log.error("err "+ex.toString(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;		
	}		

    /**
     * Step3 : Tab2 : Port Charge > Save.<br>
     * 
     * @param list List<CoaSimPortChgVO>
     * @return int[]
     * @throws DAOException
     */
    public int[] addSimPortCharge(List<CoaSimPortChgVO> list) throws DAOException {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(list.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new LaneSimulationDBDAOMultiSimPortChargeCSQL(), list, null);
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
     * Step3 : Tab2 : Port Charge > Save.<br>
     * 
     * @param list List<CoaSimPortChgVO>
     * @return int[]
     * @throws DAOException
     */
    public int[] modifySimPortCharge(List<CoaSimPortChgVO> list) throws DAOException {
		int uptCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(list.size() > 0){
				uptCnt = sqlExe.executeBatch((ISQLTemplate)new LaneSimulationDBDAOMultiSimPortChargeUSQL(), list, null);
				for(int i = 0; i < uptCnt.length; i++){
					if(uptCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to Update No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return uptCnt;    	
    }
    
    /**
     * Step3 : Tab2 : Port Charge > Create.<br>
     * 
     * @param  vo SearchSimConditionVO 
     * @return int
     * @throws DAOException
     */
	public int createSimPortCharge(SearchSimConditionVO vo) throws DAOException {
		int insCnt = 0;
		int uptCnt = 0;
		int delCnt = 0;
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			if(vo!= null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
			}
			
			delCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new LaneSimulationDBDAOCreateSimPortChargeDSQL(), param, null);
			insCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new LaneSimulationDBDAOCreateSimPortChargeCSQL(), param, null);
			uptCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new LaneSimulationDBDAOCreateSimPortChargeUSQL(), param, null);
			
			if(delCnt== Statement.EXECUTE_FAILED) throw new DAOException("Fail to Delete No SQL");
			if(insCnt== Statement.EXECUTE_FAILED) throw new DAOException("Fail to Insert No SQL");
			if(uptCnt== Statement.EXECUTE_FAILED) throw new DAOException("Fail to Update No SQL");
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			log.error("err "+se.toString(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			log.error("err "+ex.toString(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return uptCnt;		
	}    
 
    
    /**
     * Step3 : Tab3 : Bunker Cost > Retrieve.<br>
     * 
     * @param  SearchSimConditionVO vo
     * @return List<SearchSimBunkerListVO>
     * @throws DAOException
     */
	public List<SearchSimBunkerListVO> searchSimBunkerList(SearchSimConditionVO vo) throws DAOException {
		DBRowSet rowSet = null;
		List<SearchSimBunkerListVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			if(vo!= null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
			}
			rowSet = new SQLExecuter("").executeQuery((ISQLTemplate)new LaneSimulationDBDAOSearchSimBunkerListRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(rowSet, SearchSimBunkerListVO.class);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			log.error("err "+se.toString(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			log.error("err "+ex.toString(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;		
	}		
	
    /**
     *  Step3 : Tab3 : Bunker Cost > Basic <p>
     *  
     * @param  List<CoaSimBnkCostVO> list
     * @return int[]
     * @throws DAOException
     */
	public int[] createSimBunkerList(List<CoaSimBnkCostVO> list) throws DAOException {
		int uptCnt[] = null;
		try{
			uptCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new LaneSimulationDBDAOCreateSimBunkerListUSQL(), list, null);
			for(int i = 0; i < uptCnt.length; i++){
				if(uptCnt[i]== Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to Update No"+ i + " SQL");
			}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			log.error("err "+se.toString(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			log.error("err "+ex.toString(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return uptCnt;		
	}    
	
    /**
     * Step3 : Tab3 : Bunker Cost > Save<br>
     * 
     * @param List<CoaSimBnkCostVO> list
     * @return int[]
     * @throws DAOException
     */
    public int[] addSimBnkCost(List<CoaSimBnkCostVO> list) throws DAOException {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(list.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new LaneSimulationDBDAOMultiSimBunkerCostCSQL(), list, null);
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
     * Step3 : Tab3 : Bunker Cost > Save.<br>
     * 
     * @param list List<CoaSimPortChgVO>
     * @return int[]
     * @see EsmCoa0053Event
     * @throws DAOException
     */
    public int[] removeSimBnkCost(List<CoaSimBnkCostVO> list) throws DAOException {
		int uptCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(list.size() > 0){
				uptCnt = sqlExe.executeBatch((ISQLTemplate)new LaneSimulationDBDAOMultiSimBunkerCostDSQL(), list, null);
				for(int i = 0; i < uptCnt.length; i++){
					if(uptCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to Update No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return uptCnt;    	
    }
    

    /**
     * Step3 : Tab3 : Bunker Cost > Consumption Matrix by Class(Popup) > Retrieve.<br>
     * 
     * @param  CoaBnkCsmVO vo
     * @return List<CoaBnkCsmVO>
     * @throws DAOException
     */
	public List<CoaBnkCsmVO> searchSimConsumList(CoaBnkCsmVO vo) throws DAOException {
		DBRowSet rowSet = null;
		List<CoaBnkCsmVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			if(vo!= null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
			}
			rowSet = new SQLExecuter("").executeQuery((ISQLTemplate)new LaneSimulationDBDAOSearchSimConsumListRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(rowSet, CoaBnkCsmVO.class);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			log.error("err "+se.toString(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			log.error("err "+ex.toString(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;		
	}	    
    
    /**
     * Step3 : Tab3 : Bunker Cost > Consumption Matrix by Class(Popup) > Save <br>
     * 
     * @param List<CoaBnkCsmVO> list
     * @see   EsmCoa0151Event
     * @return int[]
     * @throws DAOException
     */
	
    public int[] addMultiSimConsum(List<CoaBnkCsmVO> list) throws DAOException {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(list.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new LaneSimulationDBDAOMultiSimConsumCSQL(), list, null);
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
     * Step3 : Tab3 : Bunker Cost > Consumption Matrix by Class(Popup) > Update <br>
     * 
     * @param List<CoaBnkCsmVO> list
     * @see   EsmCoa0151Event
     * @return int[]
     * @throws DAOException
     */    
    public int[] modifyMultiSimConsum(List<CoaBnkCsmVO> list) throws DAOException {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(list.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new LaneSimulationDBDAOMultiSimConsumUSQL(), list, null);
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
     * Step3 : Tab3 : Bunker Cost > Consumption Matrix by Class(Popup) > Delete <br>
     * 
     * @param List<CoaBnkCsmVO> list
     * @see   EsmCoa0151Event
     * @return int[]
     * @throws DAOException
     */    
    public int[] deleteMultiSimConsum(List<CoaBnkCsmVO> list) throws DAOException {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(list.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new LaneSimulationDBDAOMultiSimConsumDSQL(), list, null);
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
     * Step3 : Tab4 : Hire/TC Rev/Layup(Daily) > Retrieve <br>
     * 
     * @param  CoaSimCtrbMgnCostVO vo
     * @return SearchSimDailyHireINfoVO
     * @throws DAOException
     */
	public SearchSimDailyHireInfoVO searchSimDailyHireList(CoaSimCtrbMgnCostVO vo) throws DAOException {
		DBRowSet rowSet = null;
		SearchSimDailyHireInfoVO retVo = new SearchSimDailyHireInfoVO();
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(vo!= null){
				String tmpStr = vo.getPodCd();
		        if(tmpStr.equals("")) tmpStr = " | ";
		        String[] header = tmpStr.split("[|]");
				param.put("sim_dt",vo.getSimDt());
				param.put("sim_no",vo.getSimNo());
				List<String> aryYdSeq = new ArrayList();   
				for(int i = 0; i < header.length; i++){   
				    aryYdSeq.add(header[i]);   
				}   
				velParam.put("header", aryYdSeq);
				int header_size = header.length-1;
				velParam.put("header_size", header_size);
			}
			rowSet = new SQLExecuter("").executeQuery((ISQLTemplate)new LaneSimulationDBDAOSearchSimDailyHireListRSQL(), param, velParam);
			retVo.setDbRowset(rowSet);
			return retVo;
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			log.error("err "+se.toString(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			log.error("err "+ex.toString(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	    
    
    /**
     * Step3 : Tab4 : Hire/TC Rev/Layup(Daily) > Create <br>
     * 
     * @param  CreateSimDailyHireVO vo
     * @param  SignOnUserAccount account
     * @return int
     * @throws DAOException
     */
	
	public int createSimDailyHire(CreateSimDailyHireVO vo,SignOnUserAccount account) throws DAOException {
		int insCnt = 0;
		int delCnt = 0;
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			if(vo!= null){
				param.put("cre_usr_id", account.getUsr_id());
				param.put("upd_usr_id", account.getUsr_id());
				param.put("f_sim_dt", vo.getFSimDt());
				param.put("f_sim_no", vo.getFSimNo());
				param.put("f_fm_yyyymm", vo.getFFmYyyymm().replace("-", ""));
				param.put("f_to_yyyymm", vo.getFToYyyymm().replace("-", ""));
			}
			
			delCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new LaneSimulationDBDAOCreateSimDailyHireDSQL(), param, null);
			insCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new LaneSimulationDBDAOCreateSimDailyHireCSQL(), param, null);
			
			if(delCnt== Statement.EXECUTE_FAILED) throw new DAOException("Fail to Delete No SQL");
			if(insCnt== Statement.EXECUTE_FAILED) throw new DAOException("Fail to Insert No SQL");
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			log.error("err "+se.toString(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			log.error("err "+ex.toString(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;		
	}  	

    /**
     * Step3 : Tab4 : Hire/TC Rev/Layup(Daily) > Save <br>
     * 
     * @param CreateSimDailyHireVO vo
     * @see EsmCoa0053Event
     * @return int
     * @throws DAOException
     */
    public int deleteDailyHire(CreateSimDailyHireVO vo) throws DAOException {
		int delCnt = 0;
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			if(vo!= null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				
				SQLExecuter sqlExe = new SQLExecuter("");
				delCnt = sqlExe.executeUpdate((ISQLTemplate)new LaneSimulationDBDAOMultiSimDailyHireDSQL(), param,null);
				if(delCnt== Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert No SQL");
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
     * Step3 : Tab4 : Hire/TC Rev/Layup(Daily) > Insert <br>
     * 
     * @param List<CoaSimDlyHirVO> list
     * @see EsmCoa0053Event
     * @return int[]
     * @throws DAOException
     */
    public int[] addDailyHire(List<CoaSimDlyHirVO> list) throws DAOException {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(list.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new LaneSimulationDBDAOMultiSimDailyHireCSQL(), list,null);
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
     * Step3 : Tab4 : Hire/TC Rev/Layup(Daily) > Delete & Insert <br>
     * 
     * @param CreateSimDailyHireVO vo
     * @param SignOnUserAccount account
     * @see EsmCoa0053Event
     * @return int
     * @throws DAOException
     */	
	public int multiSimDailyHire(CreateSimDailyHireVO vo,SignOnUserAccount account) throws DAOException {
		int insCnt = 0;
		int delCnt = 0;
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			if(vo!= null){
				param.put("cre_usr_id", account.getUsr_id());
				param.put("upd_usr_id", account.getUsr_id());
				param.put("f_sim_dt", vo.getFSimDt());
				param.put("f_sim_no", vo.getFSimNo());
				param.put("f_fm_yyyymm", vo.getFFmYyyymm().replace("-", ""));
				param.put("f_to_yyyymm", vo.getFToYyyymm().replace("-", ""));
			}
			
			delCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new LaneSimulationDBDAOCreateSimDailyHireDSQL(), param, null);
			insCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new LaneSimulationDBDAOCreateSimDailyHireCSQL(), param, null);
			
			if(delCnt== Statement.EXECUTE_FAILED) throw new DAOException("Fail to Delete No SQL");
			if(insCnt== Statement.EXECUTE_FAILED) throw new DAOException("Fail to Insert No SQL");
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			log.error("err "+se.toString(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			log.error("err "+ex.toString(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;		
	}  		

    /**
     * Step3 : Tab5 : Network Cost > Create<br>
     * 
     * @param  CoaSimCtrbMgnCostVO vo
     * @param  SignOnUserAccount account
     * @return int
     * @throws DAOException
     */
	
	public int createSimNWCost(CoaSimCtrbMgnCostVO vo,SignOnUserAccount account) throws DAOException {
		int insCnt,delCnt = 0;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(vo!= null){
				String tmpStr = vo.getPodCd();
		        if(tmpStr.equals("")) tmpStr = " | ";
		        String[] header = tmpStr.split("[|]");
				param.put("sim_dt",vo.getSimDt());
				param.put("sim_no",vo.getSimNo());
				param.put("cre_usr_id", account.getUsr_id());
				param.put("upd_usr_id", account.getUsr_id());
				List<String> aryYdSeq = new ArrayList();   
				for(int i = 0; i < header.length; i++){   
				    aryYdSeq.add(header[i]);   
				}   
				velParam.put("header", aryYdSeq);
				int header_size = header.length-1;
				velParam.put("header_size", header_size);
			}
			delCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new LaneSimulationDBDAOCreateSimNWCostDSQL(), param, null); 
			insCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new LaneSimulationDBDAOCreateSimNWCostCSQL(), param, velParam);			
			return insCnt;
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			log.error("err "+se.toString(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			log.error("err "+ex.toString(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}	
	}
	
   /**
     *  Step3 : Tab5 : Network Cost > Retrieve<br>
     * 
     * @param  CoaSimCtrbMgnCostVO vo
     * @return SearchSimDailyHireInfoVO
     * @throws DAOException
     */
	public SearchSimDailyHireInfoVO searchSimNWCostList(CoaSimCtrbMgnCostVO vo) throws DAOException {
		DBRowSet rowSet = null;
		SearchSimDailyHireInfoVO retVo = new SearchSimDailyHireInfoVO();
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(vo!= null){
				String tmpStr = vo.getPodCd();
		        if(tmpStr.equals("")) tmpStr = " | ";
		        String[] header = tmpStr.split("[|]");
				param.put("sim_dt",vo.getSimDt());
				param.put("sim_no",vo.getSimNo());
				List<String> aryYdSeq = new ArrayList();   
				for(int i = 0; i < header.length; i++){   
				    aryYdSeq.add(header[i]);   
				}   
				velParam.put("header", aryYdSeq);
				int header_size = header.length-1;
				velParam.put("header_size", header_size);
			}
			rowSet = new SQLExecuter("").executeQuery((ISQLTemplate)new LaneSimulationDBDAOSearchSimNWCostListRSQL(), param, velParam);
			retVo.setDbRowset(rowSet);
			return retVo;
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			log.error("err "+se.toString(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			log.error("err "+ex.toString(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	    
    /**
     *  Step3 : Tab6 : After Ocean T/S > Retrieve<br>
     * 
     * @param  CoaSimCtrbMgnCostVO vo
     * @return SearchSimDailyHireInfoVO
     * @throws DAOException
     */
	public SearchSimDailyHireInfoVO searchSimAfterOcenaTSList(CoaSimCtrbMgnCostVO vo) throws DAOException {
		DBRowSet rowSet = null;
		SearchSimDailyHireInfoVO retVo = new SearchSimDailyHireInfoVO();
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(vo!= null){
				String tmpStr = vo.getPodCd();
		        if(tmpStr.equals("")) tmpStr = " | ";
		        String[] header = tmpStr.split("[|]");
				param.put("sim_dt",vo.getSimDt());
				param.put("sim_no",vo.getSimNo());
				List<String> aryYdSeq = new ArrayList();   
				for(int i = 0; i < header.length; i++){   
				    aryYdSeq.add(header[i]);   
				}   
				velParam.put("header", aryYdSeq);
				int header_size = header.length-1;
				velParam.put("header_size", header_size);
			}
			rowSet = new SQLExecuter("").executeQuery((ISQLTemplate)new LaneSimulationDBDAOSearchSimAfterOcenaTSListRSQL(), param, velParam);
			retVo.setDbRowset(rowSet);
			return retVo;
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			log.error("err "+se.toString(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			log.error("err "+ex.toString(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	

    /**
     *  Step3 : Tab4 : TO/C Hire Popup ( Hire/TC Rev/Layup(Daily) Open)  > Retrieve <p>
     * 
     * @return List<SearchTocHireListVO>
     * @throws DAOException
     */
    public List<SearchTocHireListVO> searchTOCHireList() throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchTocHireListVO> list = null;
		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LaneSimulationDBDAOSearchTocHireListRSQL(), null, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchTocHireListVO .class);
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
     * Step3 : Tab4 : TO/C Hire Popup ( Hire/TC Rev/Layup(Daily) Open)  > Save <p>
     * 
     * @param  List<CoaTmChtrOutHirVO> list
     * @return int[]
     * @throws DAOException
     */
    public int[] addMultiTOCHire(List<CoaTmChtrOutHirVO> list) throws DAOException {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(list.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new LaneSimulationDBDAOMultiTOCHireCSQL(), list, null);
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
     * Step3 : Tab4 : TO/C Hire Popup ( Hire/TC Rev/Layup(Daily) Open)  > Update <p>
     * 
     * @param  List<CoaTmChtrOutHirVO> list
     * @return int[]
     * @throws DAOException
     */    
    public int[] modifyMultiTOCHire(List<CoaTmChtrOutHirVO> list) throws DAOException {
    	int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(list.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new LaneSimulationDBDAOMultiTOCHireUSQL(), list, null);
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
     * Step3 : Tab4 : TO/C Hire Popup ( Hire/TC Rev/Layup(Daily) Open)  > DELETE <p>
     * 
     * @param  List<CoaTmChtrOutHirVO> list
     * @return int[]
     * @throws DAOException
     */  
    public int[] deleteMultiTOCHire(List<CoaTmChtrOutHirVO> list) throws DAOException {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(list.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new LaneSimulationDBDAOMultiTOCHireDSQL(), list, null);
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
     * Simulation Report의 Header정보를 조회한다.<br>
     * 
     * @param  SearchSimLaneListConditionVO vo
     * @return SearchSimLaneListConditionVO
     * @throws DAOException
     */
    public SearchSimLaneListConditionVO searchSectionNoList(SearchSimLaneListConditionVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		SearchSimLaneListConditionVO rtnVo = new SearchSimLaneListConditionVO();
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			param.put("f_sim_no", vo.getFSimNo());
			param.put("f_sim_dt", vo.getFSimDt());
			param.put("f_trd_cd", vo.getFTrdCd());
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LaneSimulationDBDAOSearchSectionNoListRSQL(), param, param);
			rtnVo.setDbRowSet(dbRowset);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnVo;
	}       

    /**
	 * Simulation Report의 Report No. 멀티콤보 세팅을 위한 데이터 조회
	 * 
	 * @param SearchSimLaneListConditionVO vo
	 * @return SearchSimLaneListConditionVO
	 * @throws DAOException
	 */    
    public SearchSimLaneListConditionVO searchSimReportNoList(SearchSimLaneListConditionVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		SearchSimLaneListConditionVO rtnVo = new SearchSimLaneListConditionVO();
		Map<String, Object> param = new HashMap<String, Object>();
		
		try{
			param.put("f_sim_no", vo.getFSimNo());
			param.put("f_sim_dt", vo.getFSimDt());
			param.put("f_trd_cd", vo.getFTrdCd());
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LaneSimulationDBDAOSearchSimReportNoListRSQL(), param, param);
			rtnVo.setDbRowSet(dbRowset);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnVo;
	}    

    /**
	 * COA_SIM_SMRY_RPT 목록을 가져온다.<br>
	 * 
	 * @param SearchReportConditionVO vo
	 * @param String headerStr
	 * @param String headerNmStr
	 * @return DBRowSet
	 * @throws DAOException
	 */

	public SearchReportConditionVO searchSimSummaryReportList(SearchReportConditionVO vo,String headerStr,String headerNmStr) throws DAOException {
		DBRowSet rowSet = null;
		SearchReportConditionVO retVo = new SearchReportConditionVO();
		int num=1;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
	    if(vo.getFSearchitem2().equals("2")) num = 53;//		
		try{
			if(vo!= null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				String tmpStr = headerStr;
		        if(tmpStr.equals("")) tmpStr = " | ";
		        String[] header = tmpStr.split("[|]");
				List<String> aryYdSeq = new ArrayList();   
				for(int i = 0; i < header.length; i++){   
				    aryYdSeq.add(header[i]);   
				}   
				velParam.put("header", aryYdSeq);
				int header_size = header.length-1;
				velParam.put("header_size", header_size);
				velParam.put("f_searchItem2", vo.getFSearchitem2());
				velParam.put("f_voy_view", vo.getFVoyView());
				velParam.put("f_trd_cd", vo.getFTrdCd());
				velParam.put("f_vsl_cd", vo.getFVslCd());
				velParam.put("num", num);
			}
			rowSet = new SQLExecuter("").executeQuery((ISQLTemplate)new LaneSimulationDBDAOSearchSimSummaryReportListRSQL(), param, velParam);
			retVo.setDbRowSet(rowSet);
			retVo.setHeader(headerNmStr);
			return retVo;
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			log.error("err "+se.toString(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			log.error("err "+ex.toString(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	
    
    /**
     * COA_SIM_RPT_MST에 데이터가 있는지 여부 확인
     * 
     * @param SearchSimLaneListConditionVO vo
	 * @return int
	 * @throws DAOException
     */
    public int searchSimReportMasterCount(SearchSimLaneListConditionVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		int rtnCnt = 0;
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			param.put("f_sim_no", vo.getFSimNo());
			param.put("f_sim_dt", vo.getFSimDt());
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LaneSimulationDBDAOSearchSimReportMasterCountRSQL(), param,null);
			if(dbRowset != null && dbRowset.next()) {
				rtnCnt = dbRowset.getInt("cnt");
			}
			return rtnCnt;
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}    	
    }
   
    /**
     * COA_SIM_SMRY_RPT 데이터 생성 
     * 처음인 경우(cnt==0) INSERT해주고, 
     * 두번째부터는 처음 데이터를 COPY해서 필요한 항목만 수정해서 넣어준다.
     * 
     * @param SearchSimLaneListConditionVO vo
     * @param SignOnUserAccount account
     * @return int
	 * @throws DAOException
     */
    public int createSimSummaryReport(SearchSimLaneListConditionVO vo,SignOnUserAccount account) throws DAOException{
    	String default_rpt_no = "AA001";
    	int insCnt = 0;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velparam = new HashMap<String, Object>();
    	try {
    		param.put("f_sim_dt", vo.getFSimDt());
    		param.put("f_sim_no", vo.getFSimNo());
    		param.put("cre_usr_id", account.getUsr_id());
    		param.put("upd_usr_id", account.getUsr_id());
    		velparam.put("default_rpt_no", default_rpt_no);
    		insCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new LaneSimulationDBDAOCreateSimSummaryReportInsQCSQL(),      param, velparam); 
    		insCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new LaneSimulationDBDAOCreateSimSummaryReportOpdayCSQL(),     param, velparam);
    		insCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new LaneSimulationDBDAOCreateSimSummaryReportAddAccntCSQL(),  param, velparam);
    		insCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new LaneSimulationDBDAOCreateSimSummaryReportAddAccnt2CSQL(), param, velparam);
    		
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
     * COA_SIM_RPT_MST 데이터 생성 
     * 처음인 경우(cnt==0) INSERT해주고, 
     * 두번째부터는 처음 데이터를 COPY해서 필요한 항목만 수정해서 넣어준다.
     * 
     * @param SearchSimLaneListConditionVO vo
     * @param SignOnUserAccount account
     * @return int
	 * @throws DAOException
     */
    public int createSimReportMaster(SearchSimLaneListConditionVO vo,SignOnUserAccount account) throws DAOException{
    	String default_rpt_no = "AA001";
    	int insCnt = 0;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velparam = new HashMap<String, Object>();
    	try {
    		param.put("f_sim_dt", vo.getFSimDt());
    		param.put("f_sim_no", vo.getFSimNo());
    		param.put("cre_usr_id", account.getUsr_id());
    		param.put("upd_usr_id", account.getUsr_id());
    		velparam.put("default_rpt_no", default_rpt_no);
    		
    		insCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new LaneSimulationDBDAOCreateSimReportMasterCSQL(), param, velparam); 
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
     * Simulation에서 사용하는 Creation (Variant Change)팝업 정보를 조회
     * 
     * @param SearchSimLaneListConditionVO vo
	 * @return List<SearchSimReportMasterListVO>
	 * @throws DAOException
     */

    public List<SearchSimReportMasterListVO> searchSimReportMasterList(SearchSimLaneListConditionVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchSimReportMasterListVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			param.put("f_sim_dt", vo.getFSimDt());
			param.put("f_sim_no", vo.getFSimNo());
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LaneSimulationDBDAOSearchSimReportMasterListRSQL(), param, param);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSimReportMasterListVO .class);
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
     * Simulation 에서 사용하는 Creation (Variant Change)팝업 정보를 생성
     * 
     * @param List<MultiSimSummaryRptVO> vo
	 * @throws DAOException
     */
    
    public void multiSimReportMaster(List<MultiSimSummaryRptVO> vo) throws DAOException{
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(vo.size() > 0){
				//velparam.put("");
				insCnt = sqlExe.executeBatch((ISQLTemplate)new LaneSimulationDBDAOMultiSimReportMasterCSQL(), vo,null);
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
    }        
    
    /**
     * Simulation 에서 사용하는 Creation (Variant Change)팝업 정보를 생성
     * 
     * @param List<MultiSimSummaryRptVO> vo
	 * @throws DAOException
     */
    
    public void multiSimSummaryReport(List<MultiSimSummaryRptVO> vo) throws DAOException{
		int insCnt[] = null;
		int mg1Cnt[] = null;
		int mg2Cnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(vo.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new LaneSimulationDBDAOMultiSimSummaryReportInsCSQL(), vo,null);
				mg1Cnt = sqlExe.executeBatch((ISQLTemplate)new LaneSimulationDBDAOMultiSimSummaryReportMgCSQL() , vo,null);
				mg2Cnt = sqlExe.executeBatch((ISQLTemplate)new LaneSimulationDBDAOMultiSimSummaryReportMg2CSQL(), vo,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
				for(int i = 0; i < mg1Cnt.length; i++){
					if(mg1Cnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to mergy1 No"+ i + " SQL");
				}
				for(int i = 0; i < mg2Cnt.length; i++){
					if(mg2Cnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to mergy2 No"+ i + " SQL");
				}

			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
    }         
    
    /**
     * Step2 : Tab1 : Port/TMNL Setting > Save <br>
     * 
     * @param SearchSimLaneListConditionVO vo
     * @param SignOnUserAccount account
     * @see EsmCoa0052Event
     * @throws DAOException
     */

    public void multiSimPortGetOpDay(SearchSimLaneListConditionVO vo,SignOnUserAccount account) throws DAOException{
		//int insCnt = 0;
		int delCnt = 0;
		Map<String, Object> param = new HashMap<String, Object>();
		
		try {
			param.put("f_sim_dt", vo.getFSimDt());
			param.put("f_sim_no", vo.getFSimNo());
			param.put("f_slan_cd", vo.getFSlanCd());
			param.put("cre_usr_id",account.getUsr_id());
			param.put("upd_usr_id",account.getUsr_id());
			if(vo != null){
				delCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new LaneSimulationDBDAOMultiSimPortGetOpDayDSQL(), param, null);
				//AS-IS 는 del & ins to-be는 del & sel
				//insCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new LaneSimulationDBDAOMultiSimPortGetOpDayCSQL(), param, null);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
    }
    /**
     * Step2 : Tab1 : Port/TMNL Setting > GetOpDay <br>
     * 
     * @param SearchSimLaneListConditionVO vo
     * @return List<SearchSimPortListVO>
     * @see EsmCoa0052Event
     * @throws DAOException
     */    
    public List<SearchSimPortListVO> searchSimPortGetOpDay(SearchSimLaneListConditionVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchSimPortListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vo != null){
				Map<String, String> mapVO = vo .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LaneSimulationDBDAOSearchSimPortGetOpDayRSQL(), param, velParam);
			//vo.setDbRowset(dbRowset);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSimPortListVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}    
   
    /*================================================================================================================*/
    /**
     * VSK에서 넘겨준 이 후 데이터가 생성된것이 있는지 체크
     * - 기준을 COA_SIM_VOL_PRJ 테이블에 정보가 생성되었는지 확인
     * 
     * @param vo SearchSimLaneListConditionVO
	 * @return int
	 * @throws DAOException
     */
    
    /**
     * VSK에서 넘어오 데이터를 가지고 정보를 생성한다.
     * 
     * @param Map<String, Object> param
	   * @param List<CoaSimTmlInfoVO> list
	   * @param String ind
	   * @throws DAOException
     */
    public void createCoaSimRqst(Map<String, Object> param, List<CoaSimTmlInfoVO> list, String ind) throws DAOException{
		int cnt1 = 0;
		int cnt2 = 0;
		int cnt3 = 0;
		//int cnt4[] = null;
		Map<String, Object> valParam = new HashMap<String, Object>();
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			if(ind.equals("U")){
				//COA_SIM_TML_INFO
				valParam.put("skd_dir_cd", "");
				valParam.put("tml_cd", "");
				valParam.put("vsl_dbl_call_seq", "");
				
				// 삭제 
				sqlExe.executeUpdate((ISQLTemplate)new LaneSimulationDBDAOMultiSimPortListDSQL(), param,valParam);
				// 입력
//				cnt4 = sqlExe.executeBatch((ISQLTemplate)new LaneSimulationDBDAOMultiSimPortListCSQL(), list,null);
//				for(int i = 0; i < cnt4.length; i++){
//					if(cnt4[i]== Statement.EXECUTE_FAILED){
//						throw new DAOException("Fail to insert COA_SIM_TML_INFO No"+ i + " SQL");
//					}
//				}
				Map<String, Object> paramTemp = new HashMap<String, Object>();
				//velocity parameter
				Map<String, Object> velParamTemp = new HashMap<String, Object>();
				int result = 0;
				//COA_SIM_TML_INFO
				for(int j=0; j<list.size(); j++){
					Map<String, String> mapVO = list.get(j).getColumnValues();//vvdVO .getColumnValues();
					
					paramTemp.putAll(mapVO);
					velParamTemp.putAll(mapVO);
					//cnt4 = sqlExe.executeBatch((ISQLTemplate)new LaneSimulationDBDAOMultiSimPortListCSQL(), list,null);
					paramTemp.put("cre_usr_id", list.get(j).getCreUsrId());
					paramTemp.put("upd_usr_id", list.get(j).getUpdUsrId());
					result = sqlExe.executeUpdate((ISQLTemplate)new LaneSimulationDBDAOMultiSimPortListCSQL(), paramTemp,velParamTemp);
					
					if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to Insert SQL");
//					for(int i = 0; i < cnt4.length; i++){
//						if(cnt4[i]== Statement.EXECUTE_FAILED){
//							throw new DAOException("Fail to insert COA_SIM_TML_INFO No"+ i + " SQL");
//						}
//					}
				}
				
			}else {
				if(list.size() > 0){
					// COA_SIM_INFO
					valParam.put("param", "COA_SIM_INFO");
					cnt1 = sqlExe.executeUpdate((ISQLTemplate)new LaneSimulationDBDAOCreateCoaSimRqst1CSQL(), param,valParam);
					if(cnt1== Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to insert COA_SIM_INFO SQL");
					}
					// COA_SIM_SVC_LANE
					valParam.put("param", "COA_SIM_SVC_LANE");
					cnt2 = sqlExe.executeUpdate((ISQLTemplate)new LaneSimulationDBDAOCreateCoaSimRqst1CSQL(), param,valParam);
					if(cnt2== Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to insert COA_SIM_SVC_LANE SQL");
					}
					// COA_SIM_VSL_SET_INFO
					valParam.put("param", "COA_SIM_VSL_SET_INFO");
					cnt3 = sqlExe.executeUpdate((ISQLTemplate)new LaneSimulationDBDAOCreateCoaSimRqst1CSQL(), param,valParam);
					if(cnt3== Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to insert COA_SIM_VSL_SET_INFO SQL");
					}

					Map<String, Object> paramTemp = new HashMap<String, Object>();
					//velocity parameter
					Map<String, Object> velParamTemp = new HashMap<String, Object>();
					int result = 0;
					
					//COA_SIM_TML_INFO
					for(int j=0; j<list.size(); j++){
						Map<String, String> mapVO = list.get(j).getColumnValues();//vvdVO .getColumnValues();
						
						paramTemp.putAll(mapVO);
						velParamTemp.putAll(mapVO);
						//cnt4 = sqlExe.executeBatch((ISQLTemplate)new LaneSimulationDBDAOMultiSimPortListCSQL(), list,null);
						paramTemp.put("cre_usr_id", list.get(j).getCreUsrId());
						paramTemp.put("upd_usr_id", list.get(j).getUpdUsrId());
						result = sqlExe.executeUpdate((ISQLTemplate)new LaneSimulationDBDAOMultiSimPortListCSQL(), paramTemp,velParamTemp);
						
						if(result == Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to Insert SQL");
//						for(int i = 0; i < cnt4.length; i++){
//							if(cnt4[i]== Statement.EXECUTE_FAILED){
//								throw new DAOException("Fail to insert COA_SIM_TML_INFO No"+ i + " SQL");
//							}
//						}
					}
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
    }    
    
    /**
     * VSK에서 넘겨준 이 후 데이터가 생성된것이 있는지 체크
     * - 기준을 COA_SIM_VOL_PRJ 테이블에 정보가 생성되었는지 확인
     * 
     * @param vo SearchSimLaneListConditionVO
	 * @return int
	 * @throws DAOException
     */
    public int searchSimProCount(SearchSimLaneListConditionVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		int rtnCnt = 0;
		Map<String, Object> param = new HashMap<String, Object>();
		
		try{
			param.put("sim_no", vo.getFSimNo());
			param.put("sim_dt", vo.getFSimDt());
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LaneSimulationDBDAOSearchSimProCountRSQL(), param,null);
			if(dbRowset != null && dbRowset.next()) {
				rtnCnt = dbRowset.getInt("cnt");
			}
			return rtnCnt;
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}    	
    }
    /**
     * Turning Port Indicator 조회.
     * 
     * @param SearchTMLOPDysListVO vo
	 * @return boolean
	 * @throws DAOException
     */    
    public boolean searchTurnPortInd(SearchTMLOPDysListVO vo) throws DAOException {
    	DBRowSet dbRowset = null;
    	boolean turnPortIndFlg = true;
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			param.put("f_sim_no", vo.getSimNo());
			param.put("f_sim_dt", vo.getSimDt());
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LaneSimulationDBDAOChkTurnPortIndRSQL(), param,null);
			//int i=0;
			while(dbRowset.next()) {
				if(dbRowset.getString("turn_port_ind_cd")==null ||  dbRowset.getString("turn_port_ind_cd").length() < 1) {
					turnPortIndFlg = false;
				}
			}
			return turnPortIndFlg;
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}    	
    }
}
