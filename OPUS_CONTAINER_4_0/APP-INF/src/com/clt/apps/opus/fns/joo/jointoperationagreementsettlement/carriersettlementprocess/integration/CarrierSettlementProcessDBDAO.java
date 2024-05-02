/*=========================================================
*Copyright(c) 2009 CyberLogitec 
*@FileName : CarrierSettlementProcessDBDAO.java
*@FileTitle : War Risk Surcharge Settlement
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.03
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2009.05.26 박희동
* 1.0 Creation
* --------------------------------------------------------
* History
* 2010.11.03 진마리아 [CHM-201006730-01]
                    Summary of Monthly Clearance Status by Carrier 기능에 Due Date, Remark 컬럼 추가
* 2011.01.11 김상수 [CHM-201007350-01] JOO - RDR Inquiry by Lane 기능 보완 요청
*                   1. 보완 대상
*                      가. 조회  Option
*                         - Region Multi 선택
*                         - Carrier 추가 - Multi 선택
*                      나. Remark Pop up 추가 - 일부 Data 저장 및 해당 컬럼에 반영 (계산 Logic 포함)
*                      다. Asjusted Allocation 컬럼 추가 (계산Logic 포함)
*                      라. Over Used 계산 Logic( Allocation 참조 컬럼을  Adjusted Allocation으로 변경
*                      마. 기타 : 컬럼별 계산 Logic 수정
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.basic.CarrierSettlementProcessBCImpl;
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
import com.clt.bizcommon.comm.Constants;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.JooSettlementVO;
import com.clt.syscommon.common.table.JooStlCmbDtlVO;
import com.clt.syscommon.common.table.JooStlDtlVO;
import com.clt.syscommon.common.table.JooStlVvdVO;
import com.clt.syscommon.common.table.MdmVslSvcLaneVO;

/**
 * OPUS CarrierSettlementProcessDBDAO <br>
 * - OPUS-JointOperationAgreementSettlement system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Park Hee Dong
 * @see CarrierSettlementProcessBCImpl 참조
 * @since J2EE 1.6
 */
public class CarrierSettlementProcessDBDAO extends DBDAOSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	/**
	 * Settlement정보를 조회한다.(W/R, PBS, OTH, S/H, OUS RDR, OUS, TDR 공통으로 사용된다.)
	 * @param ProcSettlementVO procSettlementVO
	 * @return List<ProcSettlementVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<ProcSettlementVO> searchSettlementList(ProcSettlementVO procSettlementVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ProcSettlementVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(procSettlementVO != null){
				Map<String, String> mapVO = procSettlementVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CarrierSettlementProcessDBDAOProcSettlementVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ProcSettlementVO .class);
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
	 * JOO_SETTLEMENT에 data 한 건 입력한다.
	 * @param ProcSettlementVO procSettlementVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addSettlement(ProcSettlementVO procSettlementVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = procSettlementVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new CarrierSettlementProcessDBDAOJooSettlementVOCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Settlement정보를 수정한다.
	 * @param ProcSettlementVO procSettlementVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int modifySettlement(ProcSettlementVO procSettlementVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = procSettlementVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new CarrierSettlementProcessDBDAOJooSettlementVOUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	
	/**
	 * Settlement정보를 한 건 삭제한다. (acct_yrmon, stl_vvd_seq, stl_seq)
	 * @param ProcSettlementVO procSettlementVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int removeSettlement(ProcSettlementVO procSettlementVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = procSettlementVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new CarrierSettlementProcessDBDAOJooSettlementVODSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}

	/**
	 * Settlement정보를 한 건 삭제한다. (acct_yrmon, stl_vvd_seq, stl_seq)
	 * @param JooSettlementVO jooSettlementVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int removeSettlement(JooSettlementVO jooSettlementVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = jooSettlementVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new CarrierSettlementProcessDBDAOJooSettlementVODSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	
	/**
	 * 다건의 SETTLEMENT를 삭제한다.
	 * @param List<ProcSettlementVO> procSettlementVOs 
	 * @throws DAOException
	 * @throws Exception
	 */
	public void removeSettlementS(List<ProcSettlementVO> procSettlementVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			if(procSettlementVOs.size() > 0){
				//JO_STL_ITM_CD와 JO_MNU_NM은 모두 동일할 것이므로 첫번째것으로 velocity를 setting 해도 무방하다.
				Map<String, String> mapVO = procSettlementVOs.get(0).getColumnValues();
				velParam.putAll(mapVO);
				
				delCnt = sqlExe.executeBatch((ISQLTemplate)new CarrierSettlementProcessDBDAOJooSettlementVODSQL(), procSettlementVOs, velParam);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
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
	 * Settlement에서 Create 버튼을 눌렀을 경우 Joo_settlement에 없는 항차를 조회한다.
	 * @param ProcSettlementVO procSettlementVO 
	 * @return List<ProcSettlementVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<ProcSettlementVO> searchAddStlList(ProcSettlementVO procSettlementVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ProcSettlementVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(procSettlementVO != null){
				Map<String, String> mapVO = procSettlementVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CarrierSettlementProcessDBDAOJooSettlementCreRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ProcSettlementVO .class);
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
	 * VVD 입력시 joo_stl_vvd테이블에서 stl_vvd_seq와 locl_curr_cd등 항차에 관한 기본 정보를 읽어온다.
	 * 입력한 VVD의 Validation 체크를 겸한다.
	 * @param ProcSettlementVO procSettlementVO
	 * @return List<ProcSettlementVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<ProcSettlementVO> searchStlVvd(ProcSettlementVO procSettlementVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ProcSettlementVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(procSettlementVO != null){
				Map<String, String> mapVO = procSettlementVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CarrierSettlementProcessDBDAOJooSettlementCheckVVDRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ProcSettlementVO .class);
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
	 * 0037화면에서 JOO_SETTLEMENT를 읽어온다.
	 * @param McsStatusVO mcsStatusVO
	 * @return List<McsStatusVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<McsStatusVO> searchSummaryOfMcsListByTrade(McsStatusVO mcsStatusVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<McsStatusVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(mcsStatusVO != null){
				Map<String, String> mapVO = mcsStatusVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CarrierSettlementProcessDBDAOMcsStatusVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, McsStatusVO .class);
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
	 * FNS_JOO_0007 Slot Hire 의 Create 버튼을 눌렀을 경우 JOO_SETTLEMENT에 없는 항차와 정보들을 조회한다.
	 * @param ProcSettlementVO procSettlementVO 
	 * @return List<ProcSettlementVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<ProcSettlementVO> searchAddStlForSlotHireList(ProcSettlementVO procSettlementVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ProcSettlementVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(procSettlementVO != null){
				Map<String, String> mapVO = procSettlementVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CarrierSettlementProcessDBDAOCreSlotHireRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ProcSettlementVO .class);
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
	 * 0037 선사를 조회조건으로 joo_settlement를 조회한다.
	 * @param McsStatusVO mcsStatusVO
	 * @return List<McsStatusVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<McsStatusVO> searchSummaryOfMcsListByCarrier (McsStatusVO mcsStatusVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<McsStatusVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(mcsStatusVO != null){
				Map<String, String> mapVO = mcsStatusVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CarrierSettlementProcessDBDAOmcsStatusRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, McsStatusVO .class);
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
	 * FNS_JOO_0009 OUS RDR 화면의 Create버튼을 눌렀을 경우 JOO_SETTLEMENT에 존재하지 않는 항차와 정보들을 조회한다.
	 * @param ProcSettlementVO procSettlementVO
	 * @return List<ProcSettlementVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<ProcSettlementVO> searchAddStlForOusRdrList(ProcSettlementVO procSettlementVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ProcSettlementVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(procSettlementVO != null){
				Map<String, String> mapVO = procSettlementVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CarrierSettlementProcessDBDAOCreOusRdrRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ProcSettlementVO .class);
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
     * 
     *  UID : FNS_JOO_0039
     *  Monthly Clearance Status by Carrier & Lane - Retrieve 
     *
     * @param StlConditionVO stlConditionVO
     * @throws EventException
     * @return List<McsVO>
     * @author jang kang cheol
     */
	@SuppressWarnings({ "unchecked", "rawtypes" })
    public List<McsVO> searchMcsListByCarNLane(StlConditionVO stlConditionVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<McsVO> list = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
 
        try{
            if(stlConditionVO != null){
                Map<String, String> mapVO = stlConditionVO .getColumnValues();
            
                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CarrierSettlementProcessDBDAOSearchMcsListByCarnLaneRSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, McsVO .class);
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
     *  Monthly Clearance Status by Carrier & Lane - Retrieve
     *     UID : FNS_JOO_0039
     * @param StlConditionVO stlConditionVO
     * @param JooSettlementVO[] jooSettlementVOs
     * @return List<McsVO>
     * @throws EventException
     */
	@SuppressWarnings({ "unchecked", "rawtypes" })
    public List<McsVO> searchMccDtlListByCarNLane(StlConditionVO stlConditionVO, JooSettlementVO[] jooSettlementVOs) 
      throws DAOException{   
        DBRowSet dbRowset = null;
        List<McsVO> list = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
      
        try{
            if(jooSettlementVOs != null){
                Map<String, String> mapVO = jooSettlementVOs[0] .getColumnValues();
            
                param.putAll(mapVO);
                velParam.putAll(mapVO);
                
                List<String> aryYdSeq = new ArrayList();   
                for(int i = 0; i < jooSettlementVOs.length ; i++){   
                    aryYdSeq.add(jooSettlementVOs[i].getRlaneCd() );   
                }
                velParam.put("rlane_cds", aryYdSeq);                
            } 
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CarrierSettlementProcessDBDAOSearchMccDtlListByCarNLaneRSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, McsVO .class);
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
     * Inter Port / Ocean 선택시 단가, used qty등을 조회한다.
     * 조회조건 : acct_yrmon, jo_crr_cd, re_divr_cd, trd_cd, rlane_cd, jo_stl_itm_cd, jo_mnu_nm, VVD
     * @param ProcSettlementVO procSettlementVO
     * @return List<ProcSettlementVO>
     * @throws DAOException
     */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<ProcSettlementVO> searchBsaSltPrc(ProcSettlementVO procSettlementVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ProcSettlementVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(procSettlementVO != null){
				Map<String, String> mapVO = procSettlementVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CarrierSettlementProcessDBDAOGetBsaSltPrcRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ProcSettlementVO .class);
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
	 * FNS_JOO_0010 OUS TDR용 Create버튼을 눌렀을 경우  JOO_SETTLEMENT에 존재하지 않는 항차와 정보들을 조회한다.
	 * @param ProcSettlementVO procSettlementVO
	 * @return List<ProcSettlementVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<ProcSettlementVO> searchAddStlForOusTdrList(ProcSettlementVO procSettlementVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ProcSettlementVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(procSettlementVO != null){
				Map<String, String> mapVO = procSettlementVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CarrierSettlementProcessDBDAOCreOusTdrRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ProcSettlementVO .class);
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
	 * VVD와 from port 입력시 USED SLOT 의 TEU, WGT, USED SLOT PRICE를 조회한다. 
	 * @param ProcSettlementVO procSettlementVO
	 * @return List<ProcSettlementVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<ProcSettlementVO> searchOusTdrUsedSlot(ProcSettlementVO procSettlementVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ProcSettlementVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(procSettlementVO != null){
				Map<String, String> mapVO = procSettlementVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CarrierSettlementProcessDBDAOGetOusTdrUsedSlotRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ProcSettlementVO .class);
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
	 * VVD와 from port, to port 입력시 USED SLOT PRICE를 조회한다. 
	 * @param ProcSettlementVO procSettlementVO
	 * @return List<ProcSettlementVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<ProcSettlementVO> searchOusTdrUsedSlotPrice(ProcSettlementVO procSettlementVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ProcSettlementVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(procSettlementVO != null){
				Map<String, String> mapVO = procSettlementVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CarrierSettlementProcessDBDAOGetOusTdrSlotPriceRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ProcSettlementVO .class);
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
	 * OUS TDR에서 VVD 입력시 기본정보를 가져온다.
	 * @param ProcSettlementVO procSettlementVO 
	 * @return List<ProcSettlementVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<ProcSettlementVO> searchOusTdrFnl(ProcSettlementVO procSettlementVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ProcSettlementVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(procSettlementVO != null){
				Map<String, String> mapVO = procSettlementVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CarrierSettlementProcessDBDAOGetTdrInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ProcSettlementVO .class);
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
	 * FNS_JOO_0011 R/F settlement의 조회용 method임
	 * @param ProcSettlementVO procSettlementVO
	 * @return List<SettlementRFVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SettlementRFVO> searchSettlementRFList(ProcSettlementVO procSettlementVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SettlementRFVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(procSettlementVO != null){
				Map<String, String> mapVO = procSettlementVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CarrierSettlementProcessDBDAOSettlementRFVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SettlementRFVO .class);
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
	 * FNS_JOO_0011 R/F의 Creation용 조회 Method
	 * @param ProcSettlementVO procSettlementVO
	 * @return List<SettlementRFVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SettlementRFVO> searchAddStlForRFList(ProcSettlementVO procSettlementVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SettlementRFVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(procSettlementVO != null){
				Map<String, String> mapVO = procSettlementVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			
			
				if ("T".equals(procSettlementVO.getRfScgStlTpCd())){
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CarrierSettlementProcessDBDAOCreRfTdrRSQL(), param, velParam);
				}else{
					//else if ("R".equals(procSettlementVO.getRfScgStlTpCd())){	
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CarrierSettlementProcessDBDAOCreRfRdrRSQL(), param, velParam);
				}
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, SettlementRFVO .class);
			}
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
	 * FNS_JOO_0011 R/F의 Row Add에서 I/O, RGN, POL, POD변경시 Used R/F 데이터를 조회한다.
	 * @param ProcSettlementVO procSettlementVO
	 * @return List<SettlementRFVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SettlementRFVO> searchUsedReeferList(ProcSettlementVO procSettlementVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SettlementRFVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(procSettlementVO != null){
				Map<String, String> mapVO = procSettlementVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			
			
				if ("T".equals(procSettlementVO.getRfScgStlTpCd())){
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CarrierSettlementProcessDBDAOGetReeferTDRRSQL(), param, velParam);
				}else{
				//}else if ("R".equals(procSettlementVO.getRfScgStlTpCd())){
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CarrierSettlementProcessDBDAOGetReeferRDRRSQL(), param, velParam);
				}
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, SettlementRFVO .class);
			}
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
	 * FNS_JOO_0045 Adjustment Slot Hire를 조회한다.
	 * @param AdjustConditionVO adjustConditionVO
	 * @return List<AdjustSettlementVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<AdjustSettlementVO> searchAdjustSlotHireStlList(AdjustConditionVO adjustConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AdjustSettlementVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(adjustConditionVO != null){
				Map<String, String> mapVO = adjustConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			
				if ("Y".equals(adjustConditionVO.getDiffOnlyYn())){
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CarrierSettlementProcessDBDAOAdjustSettlementVORSQL(), param, velParam);
				}else{
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CarrierSettlementProcessDBDAOAdjustSettlementSHVORSQL(), param, velParam);
				}
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, AdjustSettlementVO.class);
			}
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
	 * ADJUST시에 차이나는 단가,수량,금액을 JOO_STL_DTL 에 insert 한다.
	 * @param JooStlDtlVO jooStlDtlVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addJooStlDtl(JooStlDtlVO jooStlDtlVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = jooStlDtlVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new CarrierSettlementProcessDBDAOJooStlDtlVOCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Adjust 취소시 JOO_STL_DTL 삭제한다.
	 * @param AdjustSettlementVO adjustSettlementVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void removeJooStlDtl(AdjustSettlementVO adjustSettlementVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = adjustSettlementVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new CarrierSettlementProcessDBDAOJooStlDtlVODSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * JOO_SETTLEMENT의 ACCT_YRMON, STL_VVD_SEQ 에 MAX(STL_SEQ)+1 값을 가져온다.
	 * @param AdjustSettlementVO adjustSettlementVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public int searchNextStlSeq(AdjustSettlementVO adjustSettlementVO) throws DAOException,Exception {
		int rtnVal = 1;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(adjustSettlementVO != null){
				Map<String, String> mapVO = adjustSettlementVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CarrierSettlementProcessDBDAOGetStlSeqRSQL(), param, velParam);
			List<AdjustSettlementVO> list = (List)RowSetUtil.rowSetToVOs(dbRowset, AdjustSettlementVO.class);
			
			if (!list.isEmpty()){
				AdjustSettlementVO rtnVO = (AdjustSettlementVO)list.get(0);
				rtnVal = Integer.parseInt(rtnVO.getStlSeq());
			}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnVal;
	}
	
	/**
	 * Adjust 하는 경우 기존 data의 STL_LST_FLG를 N으로 변경한다.
	 * @param AdjustSettlementVO adjustSettlementVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int modifyAdjustSettlement(AdjustSettlementVO adjustSettlementVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = adjustSettlementVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new CarrierSettlementProcessDBDAOAdjustSettlementVOUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return result;
	}

	/**
	 * Adjustment시 stl_seq를 입력받아서 joo_settlement에 한건을 insert 한다.
	 * @param AdjustSettlementVO adjustSettlementVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addAdjustSettlement(AdjustSettlementVO adjustSettlementVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = adjustSettlementVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new CarrierSettlementProcessDBDAOJooSettlementCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * FNS_JOO_0016 Combined Monthly Clearance에서 Combined No를 Settlement에 update한다.
	 * @param CombinedVO combinedVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int modifySettlementSetCmbCfmFlg(CombinedVO combinedVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = combinedVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new CarrierSettlementProcessDBDAOJooSettlementStlCmbSeqUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}

    /**
     * 
     * FNS_JOO_0015 <br>
     * Monthly Clearance by Carrier & Lane의 Carrier정보를 조회 합니다.<br>
     *
     * @param StlConditionVO stlConditionVO
     * @throws EventException
     * @return List<SettlementVO>
     * @author jang kang cheol
     */
	@SuppressWarnings({ "unchecked", "rawtypes" })
    public List<SettlementVO> searchMonthlyClearanceList(StlConditionVO stlConditionVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<SettlementVO> list = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
 
        try{
            if(stlConditionVO != null){
                Map<String, String> mapVO = stlConditionVO .getColumnValues();
            
                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CarrierSettlementProcessDBDAOSearchMonthlyClearanceListRSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, SettlementVO .class);
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
     * 
     * FNS_JOO_0015 <br>
     * Monthly Clearance의 StlCmbSeq List를 조회합니다.<br>
     *
     * @param StlConditionVO stlConditionVO
     * @throws EventException
     * @return List<SettlementVO>
     * @author jang kang cheol
     */
	@SuppressWarnings({ "unchecked", "rawtypes" })
    public List<SettlementVO> searchMonthlyStlCmbSeqList(StlConditionVO stlConditionVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<SettlementVO> list = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
 
        try{
            if(stlConditionVO != null){
                Map<String, String> mapVO = stlConditionVO .getColumnValues();
            
                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CarrierSettlementProcessDBDAOSearchMonthlyStlCmbSeqListRSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, SettlementVO .class);
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
     * searchSummaryOfMcsListByVVD
     * [MCS Letter Information Creation]을 [조회 Retrieve]합니다.<br>
     *
     * @param   McsStatusVO mcsStatusVO
     * @throws  DAOException
     * @return  List<McsStatusReportVO> 
     * @author  jang kang cheol
     */ 
	@SuppressWarnings({ "unchecked", "rawtypes" })
   public List<McsStatusReportVO>  searchSummaryOfMcsListByVVD(McsStatusVO mcsStatusVO) throws DAOException {
           DBRowSet dbRowset = null;
           List<McsStatusReportVO> list = null;
           //query parameter
           Map<String, Object> param = new HashMap<String, Object>();
           //velocity parameter
           Map<String, Object> velParam = new HashMap<String, Object>();
           try{ 
               Map<String, String> mapVO = mcsStatusVO.getColumnValues();

               param.putAll(mapVO);
               velParam.putAll(mapVO);


               dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CarrierSettlementProcessDBDAOSearchSummaryOfMcsListByVVDRSQL(), param, velParam);
               list = (List)RowSetUtil.rowSetToVOs(dbRowset, McsStatusReportVO .class);
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
    * [Slot Exchange Status by Lane & Partner->Finance Lane]을 [조회 Retrieve]합니다.<br>
    *
    * @param   SlotXchLaneVO slotXchLaneVO
    * @throws  DAOException
    * @return  List<SlotXchLaneVO>
    * @author  jang kang cheol
    */
	@SuppressWarnings({ "unchecked", "rawtypes" })       
   public List<SlotXchLaneVO> searchSlotXchStatusListByFinanceLane(SlotXchLaneVO slotXchLaneVO) throws DAOException {   
       DBRowSet dbRowset = null;
       List<SlotXchLaneVO> list = null;
       //query parameter
       Map<String, Object> param = new HashMap<String, Object>();
       //velocity parameter
       Map<String, Object> velParam = new HashMap<String, Object>();
       try{ 
           Map<String, String> mapVO = slotXchLaneVO.getColumnValues();
          

           param.putAll(mapVO);
           velParam.putAll(mapVO);


           dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CarrierSettlementProcessDBDAOSearchSlotXchStatusListByFinanceLaneRSQL(), param, velParam);
           list = (List)RowSetUtil.rowSetToVOs(dbRowset, SlotXchLaneVO .class);
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
    * FNS_JOO_0043 : Retrieve
    * D : [FnsJoo0043Event]<br>
    * [ Slot Exchange Status by Lane & Partner->Finance  Partner]을 [조회 Retrieve]합니다.<br>
    *
    * @param  SlotXchPartnerVO slotXchPartnerVO
    * @throws EventException
    * @return List<SlotXchPartnerVO>
    * @author jang kang cheol
    */    
	@SuppressWarnings({ "unchecked", "rawtypes" }) 
   public List<SlotXchPartnerVO> searchSlotXchStatusListByFinancePartner(SlotXchPartnerVO slotXchPartnerVO) throws DAOException {   
       DBRowSet dbRowset = null;
       List<SlotXchPartnerVO> list = null;
       //query parameter
       Map<String, Object> param = new HashMap<String, Object>();
       //velocity parameter
       Map<String, Object> velParam = new HashMap<String, Object>();
       try{ 
           Map<String, String> mapVO = slotXchPartnerVO.getColumnValues();
          

           param.putAll(mapVO);
           velParam.putAll(mapVO);


           dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CarrierSettlementProcessDBDAOSearchSlotXchStatusListByFinancePartnerRSQL(), param, velParam);
           list = (List)RowSetUtil.rowSetToVOs(dbRowset, SlotXchPartnerVO .class);
       }catch(SQLException se){
           log.error(se.getMessage(),se); 
           throw new DAOException(new ErrorHandler(se).getMessage());
       }catch(Exception ex){
           log.error(ex.getMessage(),ex);
           throw new DAOException(new ErrorHandler(ex).getMessage());
       }
       return list;              
   } 
//   /**
//    * 
//    * FNS_JOO_0040 <br> 
//    * Slot Exchange Status by Lane & Partner->Space On Lane 정보를 조회 합니다.<br>
//    *
//    * @param SlotXchLaneVO slotXchLaneVO
//    * @throws DAOException
//    * @return List<SlotXchLaneVO>
//    * @author jang kang cheol
//    */
//   public  List<SlotXchLaneVO>    searchSlotXchStatusListBySpaceLane( SlotXchLaneVO slotXchLaneVO ) throws DAOException{  
//       DBRowSet dbRowset = null;
//       List<SlotXchLaneVO> list = null;
//       //query parameter
//       Map<String, Object> param = new HashMap<String, Object>();
//       //velocity parameter
//       Map<String, Object> velParam = new HashMap<String, Object>();
//       try{ 
//           Map<String, String> mapVO = slotXchLaneVO.getColumnValues();
//
//           param.putAll(mapVO);
//           velParam.putAll(mapVO);
// 
//           dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CarrierSettlementProcessDBDAOSearchSlotXchStatusListBySpaceLaneRSQL(), param, velParam);
//           list = (List)RowSetUtil.rowSetToVOs(dbRowset, SlotXchLaneVO .class);
//       }catch(SQLException se){
//           log.error(se.getMessage(),se); 
//           throw new DAOException(new ErrorHandler(se).getMessage());
//       }catch(Exception ex){
//           log.error(ex.getMessage(),ex);
//           throw new DAOException(new ErrorHandler(ex).getMessage());
//       }
//       return list;              
//   }
//   /**
//    * FNS_JOO_0041 : Retrieve
//    * D : [FnsJoo0041Event]<br>
//    * Slot Exchange Status by Lane & Partner->Space On Partner 정보를 조회 합니다.<br>
//    *
//    * @param  SlotXchPartnerVO slotXchPartnerVO
//    * @throws EventException
//    * @return List<SlotXchPartnerVO>
//    * @author jang kang cheol
//    */     
//   public List<SlotXchPartnerVO> searchSlotXchStatusListBySpacePartner(SlotXchPartnerVO slotXchPartnerVO) throws DAOException {   
//       DBRowSet dbRowset = null;
//       List<SlotXchPartnerVO> list = null;
//       //query parameter
//       Map<String, Object> param = new HashMap<String, Object>();
//       //velocity parameter
//       Map<String, Object> velParam = new HashMap<String, Object>();
//       try{ 
//           Map<String, String> mapVO = slotXchPartnerVO.getColumnValues();
//          
//
//           param.putAll(mapVO);
//           velParam.putAll(mapVO);
//
//
//           dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CarrierSettlementProcessDBDAOSearchSlotXchStatusListBySpacePartnerRSQL(), param, velParam);
//           list = (List)RowSetUtil.rowSetToVOs(dbRowset, SlotXchPartnerVO .class);
//       }catch(SQLException se){
//           log.error(se.getMessage(),se); 
//           throw new DAOException(new ErrorHandler(se).getMessage());
//       }catch(Exception ex){
//           log.error(ex.getMessage(),ex);
//           throw new DAOException(new ErrorHandler(ex).getMessage());
//       }
//       return list;              
//   } 
   /**
    * FNS_JOO_0049
    * [   Settlement Status for Basic Allocation ]을 [조회 Retrieve]합니다.<br>
    *
    * @param  StlConditionVO stlConditionVO
    * @throws DAOException
    * @return List<StlStatusBsaVO>
    * @author jang kang cheol
    */
	@SuppressWarnings({ "unchecked", "rawtypes" })
   public List<StlStatusBsaVO> searchStlStatusListForBSA( StlConditionVO stlConditionVO) throws DAOException {   
       DBRowSet dbRowset = null;
       List<StlStatusBsaVO> list = null;
       //query parameter
       Map<String, Object> param = new HashMap<String, Object>();
       //velocity parameter
       Map<String, Object> velParam = new HashMap<String, Object>();
       
       try{ 

           if( stlConditionVO != null){
               Map<String, String> mapVO =  stlConditionVO.getColumnValues();
               
               param.putAll(mapVO);
               velParam.putAll(mapVO);
           }
               
		   SQLExecuter sqlExe = new SQLExecuter("");
		   dbRowset = sqlExe.executeQuery((ISQLTemplate)new CarrierSettlementProcessDBDAOSearchStlStatusListForBSARSQL(), param, velParam);
		   list = (List)RowSetUtil.rowSetToVOs(dbRowset, StlStatusBsaVO .class);
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
    * FNS_JOO_0050
    * [   Settlement Status for Basic Allocation ]을 [조회 Retrieve]합니다.<br>
    *
    * @param  StlConditionVO stlConditionVO
    * @throws DAOException
    * @return List<StlStatusVO>
    * @author jang kang cheol
    */
	@SuppressWarnings({ "unchecked", "rawtypes" })
   public List<StlStatusVO> searchTgtVoyVsUnstlStatusList( StlConditionVO stlConditionVO) throws DAOException {   
       DBRowSet dbRowset = null;
       List<StlStatusVO> list = null;
       //query parameter
       Map<String, Object> param = new HashMap<String, Object>();
       //velocity parameter
       Map<String, Object> velParam = new HashMap<String, Object>();
       try{ 

           if( stlConditionVO != null){
               Map<String, String> mapVO =  stlConditionVO.getColumnValues();
               
               param.putAll(mapVO);
               velParam.putAll(mapVO);
           }
               
           dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CarrierSettlementProcessDBDAOStlStatusVORSQL(), param, velParam);
           list = (List)RowSetUtil.rowSetToVOs(dbRowset, StlStatusVO .class);
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

    * [lane cd 유무를 [조회 Retrieve]합니다.<br>
    *
    * @param  MdmVslSvcLaneVO mdmVslSvcLaneVO
    * @throws DAOException
    * @return List<MdmVslSvcLaneVO>
    * @author jang chang su
    */
	@SuppressWarnings({ "unchecked", "rawtypes" })
   public List<MdmVslSvcLaneVO> searchLaneCdYn (MdmVslSvcLaneVO mdmVslSvcLaneVO) throws DAOException {   
       DBRowSet dbRowset = null;
       List<MdmVslSvcLaneVO> list = null;
       //query parameter
       Map<String, Object> param = new HashMap<String, Object>();
       //velocity parameter
       Map<String, Object> velParam = new HashMap<String, Object>();
       try{ 
           if( mdmVslSvcLaneVO != null){
               Map<String, String> mapVO =  mdmVslSvcLaneVO.getColumnValues();
               
               param.putAll(mapVO);
               velParam.putAll(mapVO);
           }
               
           dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CarrierSettlementProcessDBDAOsearchRDRLaneYnRSQL(), param, velParam);
           list = (List)RowSetUtil.rowSetToVOs(dbRowset, MdmVslSvcLaneVO .class);
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
    * FNS_JOO_0054
    * [   TDR Creation Inquiry를 [조회 Retrieve]합니다.<br>
    * @param String fromDt
    * @param String toDt
    * @param String lane
    * @return List<TdrByLaneVO>
    * @throws DAOException
    */
	@SuppressWarnings({ "unchecked", "rawtypes" })
   public List<TdrByLaneVO> searchTDRCreateListByLane (String fromDt , String toDt , String lane) throws DAOException {   
       DBRowSet dbRowset = null;
       List<TdrByLaneVO> list = null;
       //query parameter
       Map<String, Object> param = new HashMap<String, Object>();
       //velocity parameter
       Map<String, Object> velParam = new HashMap<String, Object>();
       try{ 
               param.put("fromDt", fromDt);
               param.put("toDt", toDt);
               param.put("lane", lane);

               velParam.put("fromDt", fromDt);
               velParam.put("toDt", toDt);
               velParam.put("lane", lane);
               
           dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CarrierSettlementProcessDBDAOsearchTDRCreateListByLaneRSQL(), param, velParam);
           list = (List)RowSetUtil.rowSetToVOs(dbRowset, TdrByLaneVO .class);
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
    * FNS_JOO_0055
    * [   RDR Upload Inquiry를 [조회 Retrieve]합니다.<br>
    *
    * @param  String fromDt
    * @param  String toDt
    * @param  String lane
    * @throws DAOException
    * @return List<RdrByLaneVO>
    * @author jang chang su
    */
	@SuppressWarnings({ "unchecked", "rawtypes" })
   public List<RdrByLaneVO> searchRDRCreateListByLane (String fromDt , String toDt , String lane) throws DAOException {   
       DBRowSet dbRowset = null;
       List<RdrByLaneVO> list = null;
       //query parameter
       Map<String, Object> param = new HashMap<String, Object>();
       //velocity parameter
       Map<String, Object> velParam = new HashMap<String, Object>();
       try{ 
               param.put("fromDt", fromDt);
               param.put("toDt", toDt);
               param.put("lane", lane);

               velParam.put("fromDt", fromDt);
               velParam.put("toDt", toDt);
               velParam.put("lane", lane);
               
           dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CarrierSettlementProcessDBDAOsearchRDRCreateListByLaneRSQL(), param, velParam);
           list = (List)RowSetUtil.rowSetToVOs(dbRowset, RdrByLaneVO .class);
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
    * Settlement 삭제시 acct_yrmon, jo_crr_cd, re_divr_cd, trd_cd, rlane_cd, jo_stl_itm_cd, jo_mnu_nm 조건으로 PK 조회 
    * @param ProcSettlementVO procSettlementVO
    * @return List<ProcSettlementVO>
    * @throws DAOException
    */
	@SuppressWarnings({ "unchecked", "rawtypes" })
   public List<ProcSettlementVO> searchJooSettlementListForDelete(ProcSettlementVO procSettlementVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ProcSettlementVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(procSettlementVO != null){
				Map<String, String> mapVO = procSettlementVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CarrierSettlementProcessDBDAOJooSettlementForDeleteRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ProcSettlementVO .class);
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
    * Settlement 저장시에 중복되는 데이터가 있는지 Duplicate Check를 한다.
    * (순수 Settlement만 ==> S/H, OUS, R/F, OTH)
    * @param ProcSettlementVO procSettlementVO
    * @return int
    * @throws DAOException
    */
   public int searchSettlementDupChk(ProcSettlementVO procSettlementVO) throws DAOException {
		DBRowSet dbRowset = null;
		
		int iRtn = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(procSettlementVO != null){
				Map<String, String> mapVO = procSettlementVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CarrierSettlementProcessDBDAOStlDupChkRSQL(), param, velParam);
			
			iRtn = dbRowset.getRowCount();
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return iRtn;
	}

   /**
    * Settlement 저장시에 중복되는 데이터가 있는지 Duplicate Check를 한다. 
    * (SLIP된 것 기준 ==> P/B, W/R)
    * @param ProcSettlementVO procSettlementVO
    * @return int
    * @throws DAOException
    */
   public int searchSettlementDupChkWithSlip(ProcSettlementVO procSettlementVO) throws DAOException {
		DBRowSet dbRowset = null;
		
		int iRtn = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(procSettlementVO != null){
				Map<String, String> mapVO = procSettlementVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CarrierSettlementProcessDBDAOStlDupChkWithSlipRSQL(), param, velParam);
			
			iRtn = dbRowset.getRowCount();
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return iRtn;
   }
   
   /**
    * FNS_JOO_0056: Retrieve
    * D : [FnsJoo0056Event]<br>
    * RDR Load DownLoad by Lane 을  조회 Retrieve합니다.<br>
    * @param RdrLoadVO rdrLoadVO
    * @return List<RdrLoadVO>
    * @throws DAOException
    * @author jang kang cheol
    */
	@SuppressWarnings({ "unchecked", "rawtypes" })
   public List<RdrLoadVO> searchRDRDownloadListByLane(RdrLoadVO rdrLoadVO) throws DAOException {   
       DBRowSet dbRowset = null;
       List<RdrLoadVO> list = null;
       //query parameter
       Map<String, Object> param = new HashMap<String, Object>();
       //velocity parameter
       Map<String, Object> velParam = new HashMap<String, Object>();
    
       try{
           if(rdrLoadVO != null){
               Map<String, String> mapVO = rdrLoadVO .getColumnValues();
           
               param.putAll(mapVO);
               velParam.putAll(mapVO);
           }
           dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CarrierSettlementProcessDBDAOSearchRDRDownloadListByLaneRSQL(), param, velParam);
           list = (List)RowSetUtil.rowSetToVOs(dbRowset, RdrLoadVO .class);
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
    * FNS_JOO_0056: Insert
    * D : [FnsJoo0056Event]<br>
    * RDR Load DownLoad by Lane 데이터중 JOO_RDR_VVD_CRR_RMK에 해당하는 단건을 입력합니다.<br>
    * 
    * @param  RdrLoadVO rdrLoadVO
    * @return int
    * @throws DAOException
    */
   public int addManageRDRVVDCrrRmk(RdrLoadVO rdrLoadVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = rdrLoadVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new CarrierSettlementProcessDBDAOAddManageRDRVVDCrrRmkCSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to Insert SQL");
		} catch (SQLException se) {
			if (se.getErrorCode() == 1) {
				result = 1;
			} else {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			}
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
   }

   /**
    * FNS_JOO_0056: Update
    * D : [FnsJoo0056Event]<br>
    * RDR Load DownLoad by Lane 데이터중 JOO_RDR_VVD_CRR_RMK에 해당하는 단건을 수정합니다.<br>
    * 
    * @param  RdrLoadVO rdrLoadVO
    * @throws DAOException
    */
   public void modifyManageRDRVVDCrrRmk(RdrLoadVO rdrLoadVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = rdrLoadVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new CarrierSettlementProcessDBDAOModifyManageRDRVVDCrrRmkUSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to Update SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
   }

   /**
    * Settlement OTH-OTH인 경우 VVD key-in시에 AR_MST_REV_VVD를 조회한다.
    * @param ProcSettlementVO procSettlementVO
    * @return List<EstmActRsltVO>
    * @throws DAOException
    */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<EstmActRsltVO> searchStlVvdOth(ProcSettlementVO procSettlementVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<EstmActRsltVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(procSettlementVO != null){
				Map<String, String> mapVO = procSettlementVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CarrierSettlementProcessDBDAOJooSettlementOTHCheckVVDRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, EstmActRsltVO .class);
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
	 * Settlement Oth-Oth인 경우 입력한 VVD가 취소됐을 때 FNS_JOO_0053 화면을 열어 해당 VVD로 SLIP된 data를 조회한다. 
	 * @param ProcSettlementVO procSettlementVO
	 * @return List<ManualStlVvdVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<ManualStlVvdVO> searchVVDOfNotExistRevMonList(ProcSettlementVO procSettlementVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ManualStlVvdVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(procSettlementVO != null){
				Map<String, String> mapVO = procSettlementVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CarrierSettlementProcessDBDAOManualStlVvdVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ManualStlVvdVO .class);
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
	* FNS_JOO_0057: Retrieve
	* D : [FnsJoo0057Event]<br>
	* RDR Load DownLoad by VVD 을  조회 Retrieve 합니다.<br>
	 * @param TdrLoadVO tdrLoadVO
	 * @return List<TdrLoadVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<TdrLoadVO> searchTDRDownloadListByLane(TdrLoadVO tdrLoadVO)  throws DAOException {   
       DBRowSet dbRowset = null;
       List<TdrLoadVO> list = null;
       //query parameter
       Map<String, Object> param = new HashMap<String, Object>();
       //velocity parameter
       Map<String, Object> velParam = new HashMap<String, Object>();
    
       try{
           if(tdrLoadVO != null){
               Map<String, String> mapVO = tdrLoadVO .getColumnValues();
           
               param.putAll(mapVO);
               velParam.putAll(mapVO);
           }
           dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CarrierSettlementProcessDBDAOSearchTDRDownloadListByLaneRSQL(), param, velParam);
           list = (List)RowSetUtil.rowSetToVOs(dbRowset, TdrLoadVO .class);
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
    * OUS RDR Adjustment내역을 조회한다.
    * @param AdjustConditionVO adjustConditionVO
    * @return List<AdjustOusRDRVO>
    * @throws DAOException
    */
//	public List<AdjustOusRDRVO> searchAdjustOusListForRDR(AdjustConditionVO adjustConditionVO) throws DAOException {
//		DBRowSet dbRowset = null;
//		List<AdjustOusRDRVO> list = null;
//		//query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
//		//velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();
//
//		try{
//			if(adjustConditionVO != null){
//				Map<String, String> mapVO = adjustConditionVO .getColumnValues();
//			
//				param.putAll(mapVO);
//				velParam.putAll(mapVO);
//			}
//			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CarrierSettlementProcessDBDAOAdjustOusRDRVORSQL(), param, velParam);
//			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AdjustOusRDRVO.class);
//		}catch(SQLException se){
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		}catch(Exception ex){
//			log.error(ex.getMessage(),ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage());
//		}
//		return list;
//	}

	/**
	 * Settlement Create하기전에 해당조건의 대상항차가 입력되었는지 체크한다.
	 * @param ProcSettlementVO procSettlementVO
	 * @return List<ProcSettlementVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<ProcSettlementVO> searchStlVvdForSettlement(ProcSettlementVO procSettlementVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ProcSettlementVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(procSettlementVO != null){
				Map<String, String> mapVO = procSettlementVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CarrierSettlementProcessDBDAOChkStlVvdForSettlementRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ProcSettlementVO .class);
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
	 * Settlement 에서 ROW ADD로 VVD 입력할 경우 9자리 입력하면 FIN. DIR LIST를 조회한다.
	 * @param ProcSettlementVO procSettlementVO
	 * @return List<ProcSettlementVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<ProcSettlementVO> searchRevDirList(ProcSettlementVO procSettlementVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ProcSettlementVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(procSettlementVO != null){
				Map<String, String> mapVO = procSettlementVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CarrierSettlementProcessDBDAORevDirListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ProcSettlementVO .class);
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
     * Region 정보 변경시 Used Slot 정보를 조회한다.
     * 조회조건 : acct_yrmon, jo_crr_cd, re_divr_cd, trd_cd, rlane_cd, jo_stl_itm_cd, jo_mnu_nm, VVD
     * @param ProcSettlementVO procSettlementVO
     * @return List<ProcSettlementVO>
     * @throws DAOException
     */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<ProcSettlementVO> searchUsedSlotInfo(ProcSettlementVO procSettlementVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ProcSettlementVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(procSettlementVO != null){
				Map<String, String> mapVO = procSettlementVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CarrierSettlementProcessDBDAOGetUsedSlotInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ProcSettlementVO .class);
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
	 * OUS RDR의 VVD 입력시 joo_stl_vvd테이블에서 stl_vvd_seq와 locl_curr_cd등 항차에 관한 기본 정보와 1st BSA, BSA Wgt Per TEU 를 읽어온다.
	 * 입력한 VVD의 Validation 체크를 겸한다.
	 * @param ProcSettlementVO procSettlementVO
	 * @return List<ProcSettlementVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<ProcSettlementVO> searchStlVvdOusRdr(ProcSettlementVO procSettlementVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ProcSettlementVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(procSettlementVO != null){
				Map<String, String> mapVO = procSettlementVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CarrierSettlementProcessDBDAOAddRowOusRdrRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ProcSettlementVO .class);
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
     * R/F의 I/O 변경시 RF Surcharge정보를 조회한다.  
     * @param ProcSettlementVO procSettlementVO
     * @return List<SettlementRFVO>
     * @throws DAOException
     */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SettlementRFVO> searchRfIOChange(ProcSettlementVO procSettlementVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SettlementRFVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(procSettlementVO != null){
				Map<String, String> mapVO = procSettlementVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CarrierSettlementProcessDBDAOGetRfIOChangeRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SettlementRFVO .class);
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
     * R/F의 RGN 변경시 Used RF, POL, POD, Used RF 정보를 조회한다.  
     * @param ProcSettlementVO procSettlementVO
     * @return List<SettlementRFVO>
     * @throws DAOException
     */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SettlementRFVO> searchRfRgnChange(ProcSettlementVO procSettlementVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SettlementRFVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(procSettlementVO != null){
				Map<String, String> mapVO = procSettlementVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			
				if ("T".equals(procSettlementVO.getRfScgStlTpCd())){
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CarrierSettlementProcessDBDAOGetRfTdrRgnChangeRSQL(), param, velParam);
				}else{
					//else if ("R".equals(procSettlementVO.getRfScgStlTpCd())){
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CarrierSettlementProcessDBDAOGetRfRdrRgnChangeRSQL(), param, velParam);
				} 
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, SettlementRFVO .class);
			}
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
     * 
     * Booking Loading Port별 Discharge Port의 Qty 정보를 조회 합니다.<br>
     *
     * @param  LoadingQtyVO loadingQtyVO
     * @return DBRowSet
     * @throws EventException
     */
    public DBRowSet searchDischageForLoading(LoadingQtyVO loadingQtyVO ) throws DAOException{
        DBRowSet dbRowset = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{ 
            if(loadingQtyVO != null){
                Map<String, String> mapVO = loadingQtyVO .getColumnValues();
            
                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset =  new SQLExecuter("").executeQuery((ISQLTemplate) new CarrierSettlementProcessDBDAOSearchDischageForLoadingRSQL(), param, velParam);
            return dbRowset;
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
    
    }
    /**
     * 
     * Booking Loading Port별 Discharge Port의 Qty 의 비고정된 헤더정보를  조회 합니다<br>
     *
     * @param  LoadingQtyVO loadingQtyVO
     * @return DBRowSet
     * @throws EventException
     */
    public DBRowSet searchDischageForLoadingHeader(LoadingQtyVO loadingQtyVO) throws DAOException{
 
 
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            if(loadingQtyVO != null){
                Map<String, String> mapVO = loadingQtyVO .getColumnValues();
            
                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
           return new SQLExecuter("").executeQuery((ISQLTemplate)new CarrierSettlementProcessDBDAOSearchDischageForLoadingHeaderRSQL(), param, velParam);
 
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
 
    }
 
    /**
	 * S/H Adjustment시 대상항차에 해당 VVD의 STL_VVD_SEQ가 없으면 새로 딴 다음 JOO_STL_VVD에
	 * insert한다.
	 * @param AdjustSettlementVO adjustSettlementVO
	 * @return List<JooStlVvdVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<JooStlVvdVO> searchStlVvdSeq(AdjustSettlementVO adjustSettlementVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<JooStlVvdVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (adjustSettlementVO != null) {
				Map<String, String> mapVO = adjustSettlementVO
						.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
							(ISQLTemplate) new CarrierSettlementProcessDBDAOAdjustSettlementSHGetStlVvdSeqRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, JooStlVvdVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * Reverse 전표 생성시 Settlement를 copy한다.
	 * @param JooStlCmbDtlVO jooStlCmbDtlVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addSettlement(JooStlCmbDtlVO jooStlCmbDtlVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = jooStlCmbDtlVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new CarrierSettlementProcessDBDAOReverseSettlementCreationCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Reverse 전표 생성시 JOO_STL_DTL을 copy한다.
	 * @param JooStlCmbDtlVO jooStlCmbDtlVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addStlDtl(JooStlCmbDtlVO jooStlCmbDtlVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = jooStlCmbDtlVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new CarrierSettlementProcessDBDAOCopyJooStlDtlCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	/**
	 * Reverse 전표 생성시 JOO_SETTLEMENT의 max(STL_SEQ)+1값을 구한다.
	 * @param JooStlCmbDtlVO jooStlCmbDtlVO
	 * @return String
	 * @throws DAOException
	 * @throws Exception
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public String searchNextStlSeq(JooStlCmbDtlVO jooStlCmbDtlVO) throws DAOException,Exception {
		String stlSeq = "1";
		DBRowSet dbRowset = null;
		List<JooStlCmbDtlVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (jooStlCmbDtlVO != null) {
				Map<String, String> mapVO = jooStlCmbDtlVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CarrierSettlementProcessDBDAONextStlSeqRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, JooStlCmbDtlVO.class);
			
			if (list.size() > 0){
				stlSeq = list.get(0).getStlCmbSeq();
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return stlSeq;
	}


	/**
	 * Other Settlement 화면에서 S/H의 BSA Type 입력시 validation을 체크한다.
	 * @param ProcSettlementVO procSettlementVO
	 * @return List<ProcSettlementVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<ProcSettlementVO> searchBsaTypeValidationCheck(ProcSettlementVO procSettlementVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ProcSettlementVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(procSettlementVO != null){
				Map<String, String> mapVO = procSettlementVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CarrierSettlementProcessDBDAOBsaTypeValidationCheckRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ProcSettlementVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/*
	 * CHM-201006730-01 Summary of Monthly Clearance Status by Carrier 기능에  Due Date,  Remark 컬럼 추가
	 */
	/**
	 * 0036 조건에 해당하는 remark를 등록한다.
	 * @param List<McsStatusVO> mcsStatusVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addSummaryOfMcsListByCarrier(List<McsStatusVO> mcsStatusVOs) throws DAOException,Exception {
	
		try {
			int insCnt[] = null;
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			if(mcsStatusVOs.size() > 0){
				Map<String, String> mapVO = mcsStatusVOs.get(0).getColumnValues();
				velParam.putAll(mapVO);
				
				insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new CarrierSettlementProcessDBDAOAddSummaryOfMcsListByCarrierCSQL(), mcsStatusVOs, velParam);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
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
	
	/*
	 * CHM-201006730-01 Summary of Monthly Clearance Status by Carrier 기능에  Due Date,  Remark 컬럼 추가
	 */
	/**
	 * 0036 조건에 해당하는 remark를 수정한다.
	 * @param List<McsStatusVO> mcsStatusVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void modifySummaryOfMcsListByCarrier(List<McsStatusVO> mcsStatusVOs) throws DAOException,Exception {
	
		try {
			int insCnt[] = null;
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			if(mcsStatusVOs.size() > 0){
				Map<String, String> mapVO = mcsStatusVOs.get(0).getColumnValues();
				velParam.putAll(mapVO);
				
				insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new CarrierSettlementProcessDBDAOModifySummaryOfMcsListByCarrierUSQL(), mcsStatusVOs, velParam);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update SQL");
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

	/*
	 * CHM-201006730-01 Summary of Monthly Clearance Status by Carrier 기능에  Due Date,  Remark 컬럼 추가
	 */
	/**
	 * 0036 조건에 해당하는 remark가 테이블에 이미 존재하는지 아닌지를 조회한다. 
	 * @param McsStatusVO mcsStatusVO
	 * @return List<McsStatusVO>
	 * @throws DAOException
	 * @throws Exception
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<McsStatusVO> chkSummaryCrrRmk(McsStatusVO mcsStatusVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<McsStatusVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(mcsStatusVO != null){
				Map<String, String> mapVO = mcsStatusVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CarrierSettlementProcessDBDAOchkSummaryCrrRmkRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, McsStatusVO .class);
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
	 * Adjust 시 생성된 Target VVD를 삭제했을 경우 JOO_STL_DTL도 삭제한다.
	 * @param JooStlVvdVO jooStlVvdVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void removeJooStlDtl(JooStlVvdVO jooStlVvdVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = jooStlVvdVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new CarrierSettlementProcessDBDAOJooStlDtlByVVDDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.debug("\n\n\n\n\n\n\n\nse.getErrorCode()="+se.getErrorCode()+"\n\n\n\n\n\n\n\n");
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Adjustment로 강제 생성된 Target VVD를 삭제할 경우 Settlement정보를 먼저 삭제한다. (acct_yrmon, stl_vvd_seq)
	 * @param JooStlVvdVO jooStlVvdVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int removeSettlement(JooStlVvdVO jooStlVvdVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = jooStlVvdVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new CarrierSettlementProcessDBDAOJooSettlementByVVDDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			if (2292 == se.getErrorCode()){
				result = se.getErrorCode();
			}else{
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			}
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}

	/**
	 * JOO_TGT_UNSTL_STS_RMK 테이블에 입력한다.
	 * @param StlStatusVO stlStatusVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int addJooTgtUnstlStsRmk(StlStatusVO stlStatusVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int iRtn = 0;
		try {
			Map<String, String> mapVO = stlStatusVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new CarrierSettlementProcessDBDAOJooTgtUnstlStsRmkCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			//DUPLICATE ERROR 가 나면 1을 return하여 update하도록 한다.
			if (se.getErrorCode() == 1){
				iRtn = se.getErrorCode();
			}else{			
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			}
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return iRtn;
	}

	/**
	 * JOO_TGT_UNSTL_STS_RMK 테이블을 수정한다.
	 * @param StlStatusVO stlStatusVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int modifyJooTgtUnstlStsRmk(StlStatusVO stlStatusVO)  throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = stlStatusVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new CarrierSettlementProcessDBDAOJooTgtUnstlStsRmkUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return result;
	}
	
	
	/**
	 * Reverse전표 생성시 Settlement의 stl_seq 값을 cmb_dtl의 stl_seq의 값에 update한다.
	 * @param JooStlCmbDtlVO jooStlCmbDtlVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void updateCmbdtl(JooStlCmbDtlVO jooStlCmbDtlVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = jooStlCmbDtlVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new CarrierSettlementProcessDBDAOReverseCmbDtlUpdateUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Interfade Error건 취소 Combined No를 Settlement에 update한다.
	 * @param CombinedVO combinedVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int modifySettlementSetCmbCfmFlgCxl(CombinedVO combinedVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = combinedVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new CarrierSettlementProcessDBDAOJooSettlementStlCmbSeqCxlUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	

	/**
	 * Container List for settlement backup 전체 건수 조회<br>
	 * 
	 * @param CntrSettlementBackupReportVO cntrSettlementBackupReportVO
	 * @return int
	 * @throws DAOException
	 */
	public int searchCntrForSettlementBackupReportCountData(CntrSettlementBackupReportVO cntrSettlementBackupReportVO) throws DAOException {
		int cnt  =0;
        DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
        
        try {
			if(cntrSettlementBackupReportVO != null){
				Map<String, String> mapVO = cntrSettlementBackupReportVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CarrierSettlementProcessDBDAOSearchCntrForSettlementBackupReportCountRSQL(), param, velParam);	
	    	if(dbRowset.next()) {
	    		cnt = dbRowset.getInt("TOTAL_COUNT");
	    	}
	    } catch (SQLException se) {
	    	log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
			
		return cnt;
	}
	
	

	/**
	 * Container List for settlement backup 조회<br>
	 * 
	 * @param CntrSettlementBackupReportVO cntrSettlementBackupReportVO
	 * @return List<CntrSettlementBackupReportVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<CntrSettlementBackupReportVO> searchCntrForSettlementBackupReportData(CntrSettlementBackupReportVO cntrSettlementBackupReportVO) throws DAOException {
		int currentPage = cntrSettlementBackupReportVO.getIPage();
		int startNo     = Constants.PAGE_SIZE_100 * (currentPage - 1) + 1;
		int endNo       = Constants.PAGE_SIZE_100 * currentPage;  
		 
		DBRowSet dbRowset = null;
		List<CntrSettlementBackupReportVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(cntrSettlementBackupReportVO != null){
				Map<String, String> mapVO = cntrSettlementBackupReportVO .getColumnValues();
			
				param.putAll(mapVO);
				param.put("startno", startNo);
				param.put("endno", endNo);

				velParam.putAll(mapVO);
				velParam.put("startno", startNo);
				velParam.put("endno", endNo);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CarrierSettlementProcessDBDAOSearchCntrForSettlementBackupReportRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CntrSettlementBackupReportVO.class);
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
	 * Standard format for previous vvd and last port 조회<br>
	 * 
	 * @param CntrConditionVO cntrConditionVO
	 * @return List<CntrPreviousVvdPortVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<CntrPreviousVvdPortVO> searchCntrPreviousVvdPortInfo(CntrConditionVO cntrConditionVO) throws DAOException{
		DBRowSet dbRowset = null;
		List<CntrPreviousVvdPortVO> list = null;
		//query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            if(cntrConditionVO != null){
                Map<String, String> mapVO = cntrConditionVO .getColumnValues();
            
                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CarrierSettlementProcessDBDAOSearchCntrPreviousVvdPortRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CntrPreviousVvdPortVO.class);
		
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
	 * Standard format 조회<br>
	 * 
	 * @param CntrConditionVO cntrConditionVO
	 * @return  List<CntrStandardFormatVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<CntrStandardFormatVO> searchCntrStandardFormatReportData(CntrConditionVO cntrConditionVO) throws DAOException{
		DBRowSet dbRowset = null;
		List<CntrStandardFormatVO> list = null;
		//query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{

			if(cntrConditionVO != null){
				
				StringTokenizer  st = new StringTokenizer(cntrConditionVO.getLadenTpszDatas(),"|");
				String prefix = "F";
				if ( st.hasMoreTokens() ) cntrConditionVO.setLadenTpszCd1  (prefix+st.nextToken());
				if ( st.hasMoreTokens() ) cntrConditionVO.setLadenTpszCd2  (prefix+st.nextToken());
				if ( st.hasMoreTokens() ) cntrConditionVO.setLadenTpszCd3  (prefix+st.nextToken());
				if ( st.hasMoreTokens() ) cntrConditionVO.setLadenTpszCd4  (prefix+st.nextToken());
				if ( st.hasMoreTokens() ) cntrConditionVO.setLadenTpszCd5  (prefix+st.nextToken());
				if ( st.hasMoreTokens() ) cntrConditionVO.setLadenTpszCd6  (prefix+st.nextToken());
				if ( st.hasMoreTokens() ) cntrConditionVO.setLadenTpszCd7  (prefix+st.nextToken());
				if ( st.hasMoreTokens() ) cntrConditionVO.setLadenTpszCd8  (prefix+st.nextToken());
				if ( st.hasMoreTokens() ) cntrConditionVO.setLadenTpszCd9  (prefix+st.nextToken());
				if ( st.hasMoreTokens() ) cntrConditionVO.setLadenTpszCd10 (prefix+st.nextToken());
				if ( st.hasMoreTokens() ) cntrConditionVO.setLadenTpszCd11 (prefix+st.nextToken());
				if ( st.hasMoreTokens() ) cntrConditionVO.setLadenTpszCd12 (prefix+st.nextToken());
				if ( st.hasMoreTokens() ) cntrConditionVO.setLadenTpszCd13 (prefix+st.nextToken());
				if ( st.hasMoreTokens() ) cntrConditionVO.setLadenTpszCd14 (prefix+st.nextToken());
				if ( st.hasMoreTokens() ) cntrConditionVO.setLadenTpszCd15 (prefix+st.nextToken());
				if ( st.hasMoreTokens() ) cntrConditionVO.setLadenTpszCd16 (prefix+st.nextToken());
				if ( st.hasMoreTokens() ) cntrConditionVO.setLadenTpszCd17 (prefix+st.nextToken());
				if ( st.hasMoreTokens() ) cntrConditionVO.setLadenTpszCd18 (prefix+st.nextToken());
				if ( st.hasMoreTokens() ) cntrConditionVO.setLadenTpszCd19 (prefix+st.nextToken());
				if ( st.hasMoreTokens() ) cntrConditionVO.setLadenTpszCd20 (prefix+st.nextToken());
				if ( st.hasMoreTokens() ) cntrConditionVO.setLadenTpszCd21 (prefix+st.nextToken());
				if ( st.hasMoreTokens() ) cntrConditionVO.setLadenTpszCd22 (prefix+st.nextToken());
				if ( st.hasMoreTokens() ) cntrConditionVO.setLadenTpszCd23 (prefix+st.nextToken());
				if ( st.hasMoreTokens() ) cntrConditionVO.setLadenTpszCd24 (prefix+st.nextToken());
				if ( st.hasMoreTokens() ) cntrConditionVO.setLadenTpszCd25 (prefix+st.nextToken());
				if ( st.hasMoreTokens() ) cntrConditionVO.setLadenTpszCd26 (prefix+st.nextToken());
				if ( st.hasMoreTokens() ) cntrConditionVO.setLadenTpszCd27 (prefix+st.nextToken());
				if ( st.hasMoreTokens() ) cntrConditionVO.setLadenTpszCd28 (prefix+st.nextToken());
				if ( st.hasMoreTokens() ) cntrConditionVO.setLadenTpszCd29 (prefix+st.nextToken());
				if ( st.hasMoreTokens() ) cntrConditionVO.setLadenTpszCd30 (prefix+st.nextToken());

				StringTokenizer  st2 = new StringTokenizer(cntrConditionVO.getEmptyTpszDatas(),"|");
				prefix = "E";
				if ( st2.hasMoreTokens() ) cntrConditionVO.setEmptyTpszCd1  (prefix+st2.nextToken());
				if ( st2.hasMoreTokens() ) cntrConditionVO.setEmptyTpszCd2  (prefix+st2.nextToken());
				if ( st2.hasMoreTokens() ) cntrConditionVO.setEmptyTpszCd3  (prefix+st2.nextToken());
				if ( st2.hasMoreTokens() ) cntrConditionVO.setEmptyTpszCd4  (prefix+st2.nextToken());
				if ( st2.hasMoreTokens() ) cntrConditionVO.setEmptyTpszCd5  (prefix+st2.nextToken());
				if ( st2.hasMoreTokens() ) cntrConditionVO.setEmptyTpszCd6  (prefix+st2.nextToken());
				if ( st2.hasMoreTokens() ) cntrConditionVO.setEmptyTpszCd7  (prefix+st2.nextToken());
				if ( st2.hasMoreTokens() ) cntrConditionVO.setEmptyTpszCd8  (prefix+st2.nextToken());
				if ( st2.hasMoreTokens() ) cntrConditionVO.setEmptyTpszCd9  (prefix+st2.nextToken());
				if ( st2.hasMoreTokens() ) cntrConditionVO.setEmptyTpszCd10 (prefix+st2.nextToken());
				if ( st2.hasMoreTokens() ) cntrConditionVO.setEmptyTpszCd11 (prefix+st2.nextToken());
				if ( st2.hasMoreTokens() ) cntrConditionVO.setEmptyTpszCd12 (prefix+st2.nextToken());
				if ( st2.hasMoreTokens() ) cntrConditionVO.setEmptyTpszCd13 (prefix+st2.nextToken());
				if ( st2.hasMoreTokens() ) cntrConditionVO.setEmptyTpszCd14 (prefix+st2.nextToken());
				if ( st2.hasMoreTokens() ) cntrConditionVO.setEmptyTpszCd15 (prefix+st2.nextToken());
				if ( st2.hasMoreTokens() ) cntrConditionVO.setEmptyTpszCd16 (prefix+st2.nextToken());
				if ( st2.hasMoreTokens() ) cntrConditionVO.setEmptyTpszCd17 (prefix+st2.nextToken());
				if ( st2.hasMoreTokens() ) cntrConditionVO.setEmptyTpszCd18 (prefix+st2.nextToken());
				if ( st2.hasMoreTokens() ) cntrConditionVO.setEmptyTpszCd19 (prefix+st2.nextToken());
				if ( st2.hasMoreTokens() ) cntrConditionVO.setEmptyTpszCd20 (prefix+st2.nextToken());
				if ( st2.hasMoreTokens() ) cntrConditionVO.setEmptyTpszCd21 (prefix+st2.nextToken());
				if ( st2.hasMoreTokens() ) cntrConditionVO.setEmptyTpszCd22 (prefix+st2.nextToken());
				if ( st2.hasMoreTokens() ) cntrConditionVO.setEmptyTpszCd23 (prefix+st2.nextToken());
				if ( st2.hasMoreTokens() ) cntrConditionVO.setEmptyTpszCd24 (prefix+st2.nextToken());
				if ( st2.hasMoreTokens() ) cntrConditionVO.setEmptyTpszCd25 (prefix+st2.nextToken());
				if ( st2.hasMoreTokens() ) cntrConditionVO.setEmptyTpszCd26 (prefix+st2.nextToken());
				if ( st2.hasMoreTokens() ) cntrConditionVO.setEmptyTpszCd27 (prefix+st2.nextToken());
				if ( st2.hasMoreTokens() ) cntrConditionVO.setEmptyTpszCd28 (prefix+st2.nextToken());
				if ( st2.hasMoreTokens() ) cntrConditionVO.setEmptyTpszCd29 (prefix+st2.nextToken());
				if ( st2.hasMoreTokens() ) cntrConditionVO.setEmptyTpszCd30 (prefix+st2.nextToken());
				//invtOptionVO.setHeadCntrTpszCd(invtOptionVO.getHeadCntrTpszCd().replace("|", ","));
				
				Map<String, String> mapVO = cntrConditionVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CarrierSettlementProcessDBDAOSearchCntrStandardFormatReportRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CntrStandardFormatVO.class);
		
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
	 * Standard format Previous Voyage조회<br>
	 * 
	 * @param CntrConditionVO cntrConditionVO
	 * @return  List<CntrStandardFormatVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<CntrStandardFormatVO> searchCntrStandardFormatPreviousVoyageReportData(CntrConditionVO cntrConditionVO) throws DAOException{
		DBRowSet dbRowset = null;
		List<CntrStandardFormatVO> list = null;
		//query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{

			if(cntrConditionVO != null){
				
				StringTokenizer  st = new StringTokenizer(cntrConditionVO.getLadenTpszDatas(),"|");
				String prefix = "F";
				if ( st.hasMoreTokens() ) cntrConditionVO.setLadenTpszCd1  (prefix+st.nextToken());
				if ( st.hasMoreTokens() ) cntrConditionVO.setLadenTpszCd2  (prefix+st.nextToken());
				if ( st.hasMoreTokens() ) cntrConditionVO.setLadenTpszCd3  (prefix+st.nextToken());
				if ( st.hasMoreTokens() ) cntrConditionVO.setLadenTpszCd4  (prefix+st.nextToken());
				if ( st.hasMoreTokens() ) cntrConditionVO.setLadenTpszCd5  (prefix+st.nextToken());
				if ( st.hasMoreTokens() ) cntrConditionVO.setLadenTpszCd6  (prefix+st.nextToken());
				if ( st.hasMoreTokens() ) cntrConditionVO.setLadenTpszCd7  (prefix+st.nextToken());
				if ( st.hasMoreTokens() ) cntrConditionVO.setLadenTpszCd8  (prefix+st.nextToken());
				if ( st.hasMoreTokens() ) cntrConditionVO.setLadenTpszCd9  (prefix+st.nextToken());
				if ( st.hasMoreTokens() ) cntrConditionVO.setLadenTpszCd10 (prefix+st.nextToken());
				if ( st.hasMoreTokens() ) cntrConditionVO.setLadenTpszCd11 (prefix+st.nextToken());
				if ( st.hasMoreTokens() ) cntrConditionVO.setLadenTpszCd12 (prefix+st.nextToken());
				if ( st.hasMoreTokens() ) cntrConditionVO.setLadenTpszCd13 (prefix+st.nextToken());
				if ( st.hasMoreTokens() ) cntrConditionVO.setLadenTpszCd14 (prefix+st.nextToken());
				if ( st.hasMoreTokens() ) cntrConditionVO.setLadenTpszCd15 (prefix+st.nextToken());
				if ( st.hasMoreTokens() ) cntrConditionVO.setLadenTpszCd16 (prefix+st.nextToken());
				if ( st.hasMoreTokens() ) cntrConditionVO.setLadenTpszCd17 (prefix+st.nextToken());
				if ( st.hasMoreTokens() ) cntrConditionVO.setLadenTpszCd18 (prefix+st.nextToken());
				if ( st.hasMoreTokens() ) cntrConditionVO.setLadenTpszCd19 (prefix+st.nextToken());
				if ( st.hasMoreTokens() ) cntrConditionVO.setLadenTpszCd20 (prefix+st.nextToken());
				if ( st.hasMoreTokens() ) cntrConditionVO.setLadenTpszCd21 (prefix+st.nextToken());
				if ( st.hasMoreTokens() ) cntrConditionVO.setLadenTpszCd22 (prefix+st.nextToken());
				if ( st.hasMoreTokens() ) cntrConditionVO.setLadenTpszCd23 (prefix+st.nextToken());
				if ( st.hasMoreTokens() ) cntrConditionVO.setLadenTpszCd24 (prefix+st.nextToken());
				if ( st.hasMoreTokens() ) cntrConditionVO.setLadenTpszCd25 (prefix+st.nextToken());
				if ( st.hasMoreTokens() ) cntrConditionVO.setLadenTpszCd26 (prefix+st.nextToken());
				if ( st.hasMoreTokens() ) cntrConditionVO.setLadenTpszCd27 (prefix+st.nextToken());
				if ( st.hasMoreTokens() ) cntrConditionVO.setLadenTpszCd28 (prefix+st.nextToken());
				if ( st.hasMoreTokens() ) cntrConditionVO.setLadenTpszCd29 (prefix+st.nextToken());
				if ( st.hasMoreTokens() ) cntrConditionVO.setLadenTpszCd30 (prefix+st.nextToken());

				StringTokenizer  st2 = new StringTokenizer(cntrConditionVO.getEmptyTpszDatas(),"|");
				prefix = "E";
				if ( st2.hasMoreTokens() ) cntrConditionVO.setEmptyTpszCd1  (prefix+st2.nextToken());
				if ( st2.hasMoreTokens() ) cntrConditionVO.setEmptyTpszCd2  (prefix+st2.nextToken());
				if ( st2.hasMoreTokens() ) cntrConditionVO.setEmptyTpszCd3  (prefix+st2.nextToken());
				if ( st2.hasMoreTokens() ) cntrConditionVO.setEmptyTpszCd4  (prefix+st2.nextToken());
				if ( st2.hasMoreTokens() ) cntrConditionVO.setEmptyTpszCd5  (prefix+st2.nextToken());
				if ( st2.hasMoreTokens() ) cntrConditionVO.setEmptyTpszCd6  (prefix+st2.nextToken());
				if ( st2.hasMoreTokens() ) cntrConditionVO.setEmptyTpszCd7  (prefix+st2.nextToken());
				if ( st2.hasMoreTokens() ) cntrConditionVO.setEmptyTpszCd8  (prefix+st2.nextToken());
				if ( st2.hasMoreTokens() ) cntrConditionVO.setEmptyTpszCd9  (prefix+st2.nextToken());
				if ( st2.hasMoreTokens() ) cntrConditionVO.setEmptyTpszCd10 (prefix+st2.nextToken());
				if ( st2.hasMoreTokens() ) cntrConditionVO.setEmptyTpszCd11 (prefix+st2.nextToken());
				if ( st2.hasMoreTokens() ) cntrConditionVO.setEmptyTpszCd12 (prefix+st2.nextToken());
				if ( st2.hasMoreTokens() ) cntrConditionVO.setEmptyTpszCd13 (prefix+st2.nextToken());
				if ( st2.hasMoreTokens() ) cntrConditionVO.setEmptyTpszCd14 (prefix+st2.nextToken());
				if ( st2.hasMoreTokens() ) cntrConditionVO.setEmptyTpszCd15 (prefix+st2.nextToken());
				if ( st2.hasMoreTokens() ) cntrConditionVO.setEmptyTpszCd16 (prefix+st2.nextToken());
				if ( st2.hasMoreTokens() ) cntrConditionVO.setEmptyTpszCd17 (prefix+st2.nextToken());
				if ( st2.hasMoreTokens() ) cntrConditionVO.setEmptyTpszCd18 (prefix+st2.nextToken());
				if ( st2.hasMoreTokens() ) cntrConditionVO.setEmptyTpszCd19 (prefix+st2.nextToken());
				if ( st2.hasMoreTokens() ) cntrConditionVO.setEmptyTpszCd20 (prefix+st2.nextToken());
				if ( st2.hasMoreTokens() ) cntrConditionVO.setEmptyTpszCd21 (prefix+st2.nextToken());
				if ( st2.hasMoreTokens() ) cntrConditionVO.setEmptyTpszCd22 (prefix+st2.nextToken());
				if ( st2.hasMoreTokens() ) cntrConditionVO.setEmptyTpszCd23 (prefix+st2.nextToken());
				if ( st2.hasMoreTokens() ) cntrConditionVO.setEmptyTpszCd24 (prefix+st2.nextToken());
				if ( st2.hasMoreTokens() ) cntrConditionVO.setEmptyTpszCd25 (prefix+st2.nextToken());
				if ( st2.hasMoreTokens() ) cntrConditionVO.setEmptyTpszCd26 (prefix+st2.nextToken());
				if ( st2.hasMoreTokens() ) cntrConditionVO.setEmptyTpszCd27 (prefix+st2.nextToken());
				if ( st2.hasMoreTokens() ) cntrConditionVO.setEmptyTpszCd28 (prefix+st2.nextToken());
				if ( st2.hasMoreTokens() ) cntrConditionVO.setEmptyTpszCd29 (prefix+st2.nextToken());
				if ( st2.hasMoreTokens() ) cntrConditionVO.setEmptyTpszCd30 (prefix+st2.nextToken());
				//invtOptionVO.setHeadCntrTpszCd(invtOptionVO.getHeadCntrTpszCd().replace("|", ","));
				
				Map<String, String> mapVO = cntrConditionVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CarrierSettlementProcessDBDAOSearchCntrStandardFormatPreviousReportRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CntrStandardFormatVO.class);
		
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
	 * Standard format Next Voyage 조회<br>
	 * 
	 * @param CntrConditionVO cntrConditionVO
	 * @return  List<CntrStandardFormatVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<CntrStandardFormatVO> searchCntrStandardFormatNextVoyageReportData(CntrConditionVO cntrConditionVO) throws DAOException{
		DBRowSet dbRowset = null;
		List<CntrStandardFormatVO> list = null;
		//query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{

			if(cntrConditionVO != null){
				
				StringTokenizer  st = new StringTokenizer(cntrConditionVO.getLadenTpszDatas(),"|");
				String prefix = "F";
				if ( st.hasMoreTokens() ) cntrConditionVO.setLadenTpszCd1  (prefix+st.nextToken());
				if ( st.hasMoreTokens() ) cntrConditionVO.setLadenTpszCd2  (prefix+st.nextToken());
				if ( st.hasMoreTokens() ) cntrConditionVO.setLadenTpszCd3  (prefix+st.nextToken());
				if ( st.hasMoreTokens() ) cntrConditionVO.setLadenTpszCd4  (prefix+st.nextToken());
				if ( st.hasMoreTokens() ) cntrConditionVO.setLadenTpszCd5  (prefix+st.nextToken());
				if ( st.hasMoreTokens() ) cntrConditionVO.setLadenTpszCd6  (prefix+st.nextToken());
				if ( st.hasMoreTokens() ) cntrConditionVO.setLadenTpszCd7  (prefix+st.nextToken());
				if ( st.hasMoreTokens() ) cntrConditionVO.setLadenTpszCd8  (prefix+st.nextToken());
				if ( st.hasMoreTokens() ) cntrConditionVO.setLadenTpszCd9  (prefix+st.nextToken());
				if ( st.hasMoreTokens() ) cntrConditionVO.setLadenTpszCd10 (prefix+st.nextToken());
				if ( st.hasMoreTokens() ) cntrConditionVO.setLadenTpszCd11 (prefix+st.nextToken());
				if ( st.hasMoreTokens() ) cntrConditionVO.setLadenTpszCd12 (prefix+st.nextToken());
				if ( st.hasMoreTokens() ) cntrConditionVO.setLadenTpszCd13 (prefix+st.nextToken());
				if ( st.hasMoreTokens() ) cntrConditionVO.setLadenTpszCd14 (prefix+st.nextToken());
				if ( st.hasMoreTokens() ) cntrConditionVO.setLadenTpszCd15 (prefix+st.nextToken());
				if ( st.hasMoreTokens() ) cntrConditionVO.setLadenTpszCd16 (prefix+st.nextToken());
				if ( st.hasMoreTokens() ) cntrConditionVO.setLadenTpszCd17 (prefix+st.nextToken());
				if ( st.hasMoreTokens() ) cntrConditionVO.setLadenTpszCd18 (prefix+st.nextToken());
				if ( st.hasMoreTokens() ) cntrConditionVO.setLadenTpszCd19 (prefix+st.nextToken());
				if ( st.hasMoreTokens() ) cntrConditionVO.setLadenTpszCd20 (prefix+st.nextToken());
				if ( st.hasMoreTokens() ) cntrConditionVO.setLadenTpszCd21 (prefix+st.nextToken());
				if ( st.hasMoreTokens() ) cntrConditionVO.setLadenTpszCd22 (prefix+st.nextToken());
				if ( st.hasMoreTokens() ) cntrConditionVO.setLadenTpszCd23 (prefix+st.nextToken());
				if ( st.hasMoreTokens() ) cntrConditionVO.setLadenTpszCd24 (prefix+st.nextToken());
				if ( st.hasMoreTokens() ) cntrConditionVO.setLadenTpszCd25 (prefix+st.nextToken());
				if ( st.hasMoreTokens() ) cntrConditionVO.setLadenTpszCd26 (prefix+st.nextToken());
				if ( st.hasMoreTokens() ) cntrConditionVO.setLadenTpszCd27 (prefix+st.nextToken());
				if ( st.hasMoreTokens() ) cntrConditionVO.setLadenTpszCd28 (prefix+st.nextToken());
				if ( st.hasMoreTokens() ) cntrConditionVO.setLadenTpszCd29 (prefix+st.nextToken());
				if ( st.hasMoreTokens() ) cntrConditionVO.setLadenTpszCd30 (prefix+st.nextToken());

				StringTokenizer  st2 = new StringTokenizer(cntrConditionVO.getEmptyTpszDatas(),"|");
				prefix = "E";
				if ( st2.hasMoreTokens() ) cntrConditionVO.setEmptyTpszCd1  (prefix+st2.nextToken());
				if ( st2.hasMoreTokens() ) cntrConditionVO.setEmptyTpszCd2  (prefix+st2.nextToken());
				if ( st2.hasMoreTokens() ) cntrConditionVO.setEmptyTpszCd3  (prefix+st2.nextToken());
				if ( st2.hasMoreTokens() ) cntrConditionVO.setEmptyTpszCd4  (prefix+st2.nextToken());
				if ( st2.hasMoreTokens() ) cntrConditionVO.setEmptyTpszCd5  (prefix+st2.nextToken());
				if ( st2.hasMoreTokens() ) cntrConditionVO.setEmptyTpszCd6  (prefix+st2.nextToken());
				if ( st2.hasMoreTokens() ) cntrConditionVO.setEmptyTpszCd7  (prefix+st2.nextToken());
				if ( st2.hasMoreTokens() ) cntrConditionVO.setEmptyTpszCd8  (prefix+st2.nextToken());
				if ( st2.hasMoreTokens() ) cntrConditionVO.setEmptyTpszCd9  (prefix+st2.nextToken());
				if ( st2.hasMoreTokens() ) cntrConditionVO.setEmptyTpszCd10 (prefix+st2.nextToken());
				if ( st2.hasMoreTokens() ) cntrConditionVO.setEmptyTpszCd11 (prefix+st2.nextToken());
				if ( st2.hasMoreTokens() ) cntrConditionVO.setEmptyTpszCd12 (prefix+st2.nextToken());
				if ( st2.hasMoreTokens() ) cntrConditionVO.setEmptyTpszCd13 (prefix+st2.nextToken());
				if ( st2.hasMoreTokens() ) cntrConditionVO.setEmptyTpszCd14 (prefix+st2.nextToken());
				if ( st2.hasMoreTokens() ) cntrConditionVO.setEmptyTpszCd15 (prefix+st2.nextToken());
				if ( st2.hasMoreTokens() ) cntrConditionVO.setEmptyTpszCd16 (prefix+st2.nextToken());
				if ( st2.hasMoreTokens() ) cntrConditionVO.setEmptyTpszCd17 (prefix+st2.nextToken());
				if ( st2.hasMoreTokens() ) cntrConditionVO.setEmptyTpszCd18 (prefix+st2.nextToken());
				if ( st2.hasMoreTokens() ) cntrConditionVO.setEmptyTpszCd19 (prefix+st2.nextToken());
				if ( st2.hasMoreTokens() ) cntrConditionVO.setEmptyTpszCd20 (prefix+st2.nextToken());
				if ( st2.hasMoreTokens() ) cntrConditionVO.setEmptyTpszCd21 (prefix+st2.nextToken());
				if ( st2.hasMoreTokens() ) cntrConditionVO.setEmptyTpszCd22 (prefix+st2.nextToken());
				if ( st2.hasMoreTokens() ) cntrConditionVO.setEmptyTpszCd23 (prefix+st2.nextToken());
				if ( st2.hasMoreTokens() ) cntrConditionVO.setEmptyTpszCd24 (prefix+st2.nextToken());
				if ( st2.hasMoreTokens() ) cntrConditionVO.setEmptyTpszCd25 (prefix+st2.nextToken());
				if ( st2.hasMoreTokens() ) cntrConditionVO.setEmptyTpszCd26 (prefix+st2.nextToken());
				if ( st2.hasMoreTokens() ) cntrConditionVO.setEmptyTpszCd27 (prefix+st2.nextToken());
				if ( st2.hasMoreTokens() ) cntrConditionVO.setEmptyTpszCd28 (prefix+st2.nextToken());
				if ( st2.hasMoreTokens() ) cntrConditionVO.setEmptyTpszCd29 (prefix+st2.nextToken());
				if ( st2.hasMoreTokens() ) cntrConditionVO.setEmptyTpszCd30 (prefix+st2.nextToken());
				//invtOptionVO.setHeadCntrTpszCd(invtOptionVO.getHeadCntrTpszCd().replace("|", ","));
				
				Map<String, String> mapVO = cntrConditionVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CarrierSettlementProcessDBDAOSearchCntrStandardFormatNextReportRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CntrStandardFormatVO.class);
		
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
	 * Conversion Table TP/SZ Conversion 조회<br>
	 * 
	 * @param CntrConversionConditionVO cntrConversionConditionVO
	 * @return List<CntrConversionAndOptionVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<CntrConversionAndOptionVO> searchCntrConverionByTpszList(CntrConversionConditionVO cntrConversionConditionVO) throws DAOException{
		DBRowSet dbRowset = null;
		List<CntrConversionAndOptionVO> list = null;
		//query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            if(cntrConversionConditionVO != null){
                Map<String, String> mapVO = cntrConversionConditionVO .getColumnValues();
            
                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CarrierSettlementProcessDBDAOSearchCntrConverionRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CntrConversionAndOptionVO.class);
		
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
	 * Conversion Table TEU Conversion 조회<br>
	 * 
	 * @param CntrConversionConditionVO cntrConversionConditionVO
	 * @return List<CntrConversionAndOptionVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<CntrConversionAndOptionVO> searchCntrConverionByTeuList(CntrConversionConditionVO cntrConversionConditionVO) throws DAOException{
		DBRowSet dbRowset = null;
		List<CntrConversionAndOptionVO> list = null;
		//query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            if(cntrConversionConditionVO != null){
                Map<String, String> mapVO = cntrConversionConditionVO .getColumnValues();
            
                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CarrierSettlementProcessDBDAOSearchCntrConverionRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CntrConversionAndOptionVO.class);
		
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
	 * Conversion Table Void Conversion 조회<br>
	 * 
	 * @param CntrConversionConditionVO cntrConversionConditionVO
	 * @return List<CntrConversionAndOptionVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<CntrConversionAndOptionVO> searchCntrConverionByVoidList(CntrConversionConditionVO cntrConversionConditionVO) throws DAOException{
		DBRowSet dbRowset = null;
		List<CntrConversionAndOptionVO> list = null;
		//query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            if(cntrConversionConditionVO != null){
                Map<String, String> mapVO = cntrConversionConditionVO .getColumnValues();
            
                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CarrierSettlementProcessDBDAOSearchCntrConverionRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CntrConversionAndOptionVO.class);
		
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
	 * 0086 Conversion TP/SZ All Insert.
	 * @param List<CntrConversionAndOptionVO> cntrConversionAndOptionVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addCntrConversionByTpszList(List<CntrConversionAndOptionVO> cntrConversionAndOptionVOs) throws DAOException,Exception {
	
		try {
			int insCnt[] = null;
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			if(cntrConversionAndOptionVOs.size() > 0){
				Map<String, String> mapVO = cntrConversionAndOptionVOs.get(0).getColumnValues();
				velParam.putAll(mapVO);
				
				insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new CarrierSettlementProcessDBDAOAddCntrConversionByTpszCSQL(), cntrConversionAndOptionVOs, velParam);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
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
	 * 0086 Conversion TEU All Insert.
	 * @param List<CntrConversionAndOptionVO> cntrConversionAndOptionVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addCntrConversionByTeuList(List<CntrConversionAndOptionVO> cntrConversionAndOptionVOs) throws DAOException,Exception {
	
		try {
			int insCnt[] = null;
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			if(cntrConversionAndOptionVOs.size() > 0){
				Map<String, String> mapVO = cntrConversionAndOptionVOs.get(0).getColumnValues();
				velParam.putAll(mapVO);
				
				insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new CarrierSettlementProcessDBDAOAddCntrConversionByTeuCSQL(), cntrConversionAndOptionVOs, velParam);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
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
	 * 0086 Conversion Void All Insert.
	 * @param List<CntrConversionAndOptionVO> cntrConversionAndOptionVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addCntrConversionByVoidList(List<CntrConversionAndOptionVO> cntrConversionAndOptionVOs) throws DAOException,Exception {
	
		try {
			int insCnt[] = null;
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			if(cntrConversionAndOptionVOs.size() > 0){
				Map<String, String> mapVO = cntrConversionAndOptionVOs.get(0).getColumnValues();
				velParam.putAll(mapVO);
				
				insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new CarrierSettlementProcessDBDAOAddCntrConversionByVoidCSQL(), cntrConversionAndOptionVOs, velParam);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
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
	 * Conversion Table Option 조회<br>
	 * 
	 * @param CntrConversionConditionVO cntrConversionConditionVO
	 * @return List<CntrConversionAndOptionVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<CntrConversionAndOptionVO> searchCntrOptionList(CntrConversionConditionVO cntrConversionConditionVO) throws DAOException{
		DBRowSet dbRowset = null;
		List<CntrConversionAndOptionVO> list = null;
		//query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            if(cntrConversionConditionVO != null){
                Map<String, String> mapVO = cntrConversionConditionVO .getColumnValues();
            
                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CarrierSettlementProcessDBDAOSearchCntrOptionRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CntrConversionAndOptionVO.class);
		
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
	 * 0087 Option All Insert.
	 * @param List<CntrConversionAndOptionVO> cntrConversionAndOptionVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addCntrOptionList(List<CntrConversionAndOptionVO> cntrConversionAndOptionVOs) throws DAOException,Exception {
	
		try {
			int insCnt[] = null;
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			if(cntrConversionAndOptionVOs.size() > 0){
				Map<String, String> mapVO = cntrConversionAndOptionVOs.get(0).getColumnValues();
				velParam.putAll(mapVO);
				
				insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new CarrierSettlementProcessDBDAOAddCntrOptionCSQL(), cntrConversionAndOptionVOs, velParam);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
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
	 * 0086/0087 Option All Delete.
	 * @param CntrConversionAndOptionVO cntrConversionAndOptionVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void removeCntrConversionTableAndOption(CntrConversionAndOptionVO cntrConversionAndOptionVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = cntrConversionAndOptionVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new CarrierSettlementProcessDBDAORemoveCntrConversionTableAndOptionDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	

	/**
	 * Conversion Table Normal TP/SZ 조회<br>
	 * 
	 * @param CntrConversionConditionVO cntrConversionConditionVO
	 * @return List<CntrConversionAndOptionVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<CntrConversionAndOptionVO> searchCntrNormalTpszList(CntrConversionConditionVO cntrConversionConditionVO) throws DAOException{
		DBRowSet dbRowset = null;
		List<CntrConversionAndOptionVO> list = null;
		//query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            if(cntrConversionConditionVO != null){
                Map<String, String> mapVO = cntrConversionConditionVO .getColumnValues();
            
                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CarrierSettlementProcessDBDAOSearchCntrNormalTpszRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CntrConversionAndOptionVO.class);
		
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
	 * Conversion / Option Table 에 MAX(LINE_SEQ)+1 값을 가져온다.
	 * @param CntrConversionConditionVO cntrConversionConditionVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public int searchCntrNextMaxLineSeq(CntrConversionConditionVO cntrConversionConditionVO) throws DAOException,Exception {
		int rtnVal = 1;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(cntrConversionConditionVO != null){
				Map<String, String> mapVO = cntrConversionConditionVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CarrierSettlementProcessDBDAOSearchCntrNextMaxLineSeqRSQL(), param, velParam);
			List<CntrConversionAndOptionVO> list = (List)RowSetUtil.rowSetToVOs(dbRowset, CntrConversionAndOptionVO.class);
			
			if (!list.isEmpty()){
				CntrConversionAndOptionVO rtnVO = (CntrConversionAndOptionVO)list.get(0);
				rtnVal = Integer.parseInt(rtnVO.getLineSeq());
			}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnVal;
	}

	/**
	 * FNS_JOO_0007 Slot Hire 의 Create 버튼을 눌렀을 경우 JOO_SETTLEMENT에 없는 항차와 정보들을 조회한다.
	 * G6GA Create.
	 * @param ProcSettlementVO procSettlementVO 
	 * @return List<ProcSettlementVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<ProcSettlementVO> searchAddStlForSlotHireByG6gaList(ProcSettlementVO procSettlementVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ProcSettlementVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(procSettlementVO != null){
				Map<String, String> mapVO = procSettlementVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CarrierSettlementProcessDBDAOCreSlotHireByG6gaRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ProcSettlementVO .class);
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
     * Region(Inter) 정보 변경시 Used Slot 정보를 조회한다.
     * 2015.08.12 Add
     * 조회조건 : acct_yrmon, jo_crr_cd, re_divr_cd, trd_cd, rlane_cd, jo_stl_itm_cd, jo_mnu_nm, VVD
     * @param ProcSettlementVO procSettlementVO
     * @return List<ProcSettlementVO>
     * @throws DAOException
     */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<ProcSettlementVO> searchUsedSlotByInterList(ProcSettlementVO procSettlementVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ProcSettlementVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(procSettlementVO != null){
				Map<String, String> mapVO = procSettlementVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CarrierSettlementProcessDBDAOGetUsedSlotByInterListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ProcSettlementVO .class);
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
     * Inter Port,From/To Port 선택시 단가, used qty등을 조회한다.
     * 2015.08.12 Add
     * 조회조건 : acct_yrmon, jo_crr_cd, re_divr_cd, trd_cd, rlane_cd, jo_stl_itm_cd, jo_mnu_nm, VVD
     * @param ProcSettlementVO procSettlementVO
     * @return List<ProcSettlementVO>
     * @throws DAOException
     */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<ProcSettlementVO> searchBsaSltPrcByInter(ProcSettlementVO procSettlementVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ProcSettlementVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(procSettlementVO != null){
				Map<String, String> mapVO = procSettlementVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CarrierSettlementProcessDBDAOGetBsaSltPrcByInterRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ProcSettlementVO .class);
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
	 * 0086 Conversion Default TP/SZ All Insert.
	 * @param List<CntrConversionAndOptionVO> cntrConversionAndOptionVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addCntrConversionByDefaultTpszList(List<CntrConversionAndOptionVO> cntrConversionAndOptionVOs) throws DAOException,Exception {
	
		try {
			int insCnt[] = null;
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			if(cntrConversionAndOptionVOs.size() > 0){
				Map<String, String> mapVO = cntrConversionAndOptionVOs.get(0).getColumnValues();
				velParam.putAll(mapVO);
				
				insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new CarrierSettlementProcessDBDAOAddCntrConversionByDefaultTpszCSQL(), cntrConversionAndOptionVOs, velParam);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
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
	 * Conversion Table Default TP/SZ 조회(Laden/Empty)<br>
	 * 
	 * @param CntrConversionConditionVO cntrConversionConditionVO
	 * @return List<CntrConversionAndOptionVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<CntrConversionAndOptionVO> searchCntrConverionDefaultTpszList(CntrConversionConditionVO cntrConversionConditionVO) throws DAOException{
		DBRowSet dbRowset = null;
		List<CntrConversionAndOptionVO> list = null;
		//query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            if(cntrConversionConditionVO != null){
                Map<String, String> mapVO = cntrConversionConditionVO .getColumnValues();
            
                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CarrierSettlementProcessDBDAOSearchCntrConverionDefaultTpszRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CntrConversionAndOptionVO.class);
		
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
	 * Default Conversion Table TEU Conversion 조회<br>
	 * 
	 * @param CntrConversionConditionVO cntrConversionConditionVO
	 * @return List<CntrConversionAndOptionVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<CntrConversionAndOptionVO> searchDefaultCntrConverion(CntrConversionConditionVO cntrConversionConditionVO) throws DAOException{
		DBRowSet dbRowset = null;
		List<CntrConversionAndOptionVO> list = null;
		//query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            if(cntrConversionConditionVO != null){
                Map<String, String> mapVO = cntrConversionConditionVO .getColumnValues();
            
                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CarrierSettlementProcessDBDAOSearchDefaultCntrConverionRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CntrConversionAndOptionVO.class);
		
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
	 * Default Conversion Table Option 조회<br>
	 * 
	 * @param CntrConversionConditionVO cntrConversionConditionVO
	 * @return List<CntrConversionAndOptionVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<CntrConversionAndOptionVO> searchDefaultCntrOptionList(CntrConversionConditionVO cntrConversionConditionVO) throws DAOException{
		DBRowSet dbRowset = null;
		List<CntrConversionAndOptionVO> list = null;
		//query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            if(cntrConversionConditionVO != null){
                Map<String, String> mapVO = cntrConversionConditionVO .getColumnValues();
            
                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CarrierSettlementProcessDBDAOSearchDefaultCntrOptionRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CntrConversionAndOptionVO.class);
		
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
	 * 0086 TEU CONVERSION/VOID CONVERSION 상위 삭제된 레코드 Delete.
	 * @param CntrConversionConditionVO cntrConversionConditionVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void removeCntrConversionTableAndOptionByNotRel(CntrConversionConditionVO cntrConversionConditionVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = cntrConversionConditionVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new CarrierSettlementProcessDBDAORemoveCntrConversionTableAndOptionByNotRelDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 0086 TEU CONVERSION Distinct Slane_cd 레코드 조회.
	 * @param CntrConversionConditionVO cntrConversionConditionVO
	 * @return Map<String, String>
	 * @throws DAOException
	 * @throws Exception
	 */
	public Map<String, String> searchCntrConversionTableByPptCd(CntrConversionConditionVO cntrConversionConditionVO) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		Map<String, String> rtnMap = new HashMap<String, String>();
		try {
			Map<String, String> mapVO = cntrConversionConditionVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CarrierSettlementProcessDBDAOSearchCntrConversionTableByPptCdRSQL(), param, velParam);
			
			while (dbRowset.next()) {
				String tmpKey = dbRowset.getString("SLAN_CD");
				rtnMap.put(tmpKey, tmpKey);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return rtnMap;
	}
}