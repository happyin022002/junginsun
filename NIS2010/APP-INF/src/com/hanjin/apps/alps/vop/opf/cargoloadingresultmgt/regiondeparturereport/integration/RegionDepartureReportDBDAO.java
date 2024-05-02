/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RegionDepartureReportDBDAO.java
*@FileTitle : RDR Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.20
*@LastModifier : 이선영
*@LastVersion : 1.0
* 2009.07.20 이선영
* 1.0 Creation
* ---------------------------------------------------------------------
* History
* 2011.08.24 김민아 [CHM-201113050-01] [VOP-OPF] RDR Inquiry 로직 변경 : RDR이 생성된 region만 보일수 있도록 로직 변경
* 2011.09.02 김민아 [CHM-201113284-01] [OPF-RDR] RDR CREATION 화면 HC/RT ADD SLOT 저장로직보완 : 저장 시 RDR Utilize 에 누락된 데이터를 생성하는 로직을 추가
* 2013.11.25 임옥영 [CHM-201327237] [VOP-OPF] RDR Summary 메뉴 추가 
=========================================================*/
package com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.basic.RegionDepartureReportBCImpl;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRAddSlotVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRAkVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRBbVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRCrtListOptionVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRDgVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRHcVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRListOptionVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRLoadVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRNextPortVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDROverUsedVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRRemarkVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRRfInterPortVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRRfMainTradeVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRSlotReleaseVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRSlotSwapVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRSlotUtilVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRSummaryVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRVslAllocVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRVslMvmtVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RdrCreatInfoVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRSearchRegionLastPortVO;
import com.hanjin.apps.alps.vop.opf.opfcommon.opfutil.integration.OpfUtilDBDAOSearchPortInfoRSQL;
import com.hanjin.apps.alps.vop.opf.opfcommon.opfutil.vo.OpfComboVO;
import com.hanjin.apps.alps.vop.opf.opfcommon.opfutil.vo.OpfUtilSearchOptVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.ComIntgCdDtlVO;


/**
 * ALPS RegionDepartureReportDBDAO <br>
 * - ALPS-CargoLoadingResultMgt system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author SunyoungLee
 * @see RegionDepartureReportBCImpl 참조
 * @since J2EE 1.6
 */
public class RegionDepartureReportDBDAO extends DBDAOSupport {
	
	/**
	 * [Common Code] 정보를 [조회] 합니다.<br>
	 * 
	 * @param String code
	 * @return List<ComIntgCdDtlVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<ComIntgCdDtlVO> searchComCodeList(String code) throws DAOException {
		DBRowSet dbRowset = null;
		List<ComIntgCdDtlVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(code != null){
				Map<String, String> mapVO = new HashMap<String, String>();
				mapVO.put("intg_cd_id", code);
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new RegionDepartureReportDBDAOComIntgCdDtlVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ComIntgCdDtlVO .class);
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
	 * [Operator] 정보를 [조회] 합니다.<br>
	 * 
	 * @param rdrListOptionVO RDRListOptionVO
	 * @return List<RDRListOptionVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RDRListOptionVO> searchCarrierList(RDRListOptionVO rdrListOptionVO) throws DAOException {
		DBRowSet dbRowset = null;
		//List<VskCarrierVO> list = null;
		List<RDRListOptionVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(rdrListOptionVO != null){
				Map<String, String> mapVO = rdrListOptionVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			//dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new RegionDepartureReportDBDAOVskCarrierVORSQL(), param, velParam);
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new RegionDepartureReportDBDAORDROperatorRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RDRListOptionVO .class);
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
	 * [RDR VESSAL MOVE] 정보를 [조회] 합니다.<br>
	 * 
	 * @param RDRListOptionVO rdrListOptionVO
	 * @return List<RDRVslMvmtVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RDRVslMvmtVO> searchRDRVSLMvmtList(RDRListOptionVO rdrListOptionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RDRVslMvmtVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(rdrListOptionVO != null){
				Map<String, String> mapVO = rdrListOptionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new RegionDepartureReportDBDAORDRVslMvmtVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RDRVslMvmtVO .class);
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
	 * [RDR NEXT PORT] 정보를 [조회] 합니다.<br>
	 * 
	 * @param RDRListOptionVO rdrListOptionVO
	 * @return List<RDRVslMvmtVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RDRNextPortVO> searchRDRNextPortList(RDRListOptionVO rdrListOptionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RDRNextPortVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(rdrListOptionVO != null){
				Map<String, String> mapVO = rdrListOptionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new RegionDepartureReportDBDAORDRNextPortVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RDRNextPortVO .class);
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
	 * [RDR SLOT HEADER] 정보를 [조회] 합니다.<br>
	 * 
	 * @param RDRListOptionVO rdrListOptionVO
	 * @return List<RDRListOptionVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RDRListOptionVO> searchRDRAddSlotHeaderList(RDRListOptionVO rdrListOptionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RDRListOptionVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(rdrListOptionVO != null){
				Map<String, String> mapVO = rdrListOptionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new RegionDepartureReportDBDAORDRAddSlotHeaderRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RDRListOptionVO .class);
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
	 * [RDR ADD SLOT] 정보를 [조회] 합니다.<br>
	 * 
	 * @param RDRListOptionVO rdrListOptionVO
	 * @return List<RDRAddSlotVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RDRAddSlotVO> searchRDRAddSlotList(RDRListOptionVO rdrListOptionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RDRAddSlotVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		List<String> aryOprCd = new ArrayList();
		try{
 
 
			if(rdrListOptionVO != null){
 
				Map<String, String> mapVO = rdrListOptionVO .getColumnValues();
				mapVO.put( "opt_opr_cd", rdrListOptionVO.getOprCd() ); 
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			List<RDRListOptionVO> list2 = searchRDRAddSlotHeaderList(rdrListOptionVO);
			if(list2 != null){
				for(int cnt = 0; cnt < list2.size(); cnt++){
					aryOprCd.add(list2.get(cnt).getOprCd());
				}
			}
			
			velParam.put("opr_cd", aryOprCd);

			
			
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new RegionDepartureReportDBDAORDRAddSlotVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RDRAddSlotVO .class);
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
	 * [RDR SLOT UTILIZE] 정보를 [조회] 합니다.<br>
	 * 
	 * @param RDRListOptionVO rdrListOptionVO
	 * @return List<RDRSlotUtilVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RDRSlotUtilVO> searchRDRSlotUtilList(RDRListOptionVO rdrListOptionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RDRSlotUtilVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(rdrListOptionVO != null){
				Map<String, String> mapVO = rdrListOptionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new RegionDepartureReportDBDAORDRSlotUtilVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RDRSlotUtilVO .class);
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
	 * [RDR AKWARD] 정보를 [조회] 합니다.<br>
	 * 
	 * @param RDRListOptionVO rdrListOptionVO
	 * @return List<RDRAkVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RDRAkVO> searchRDRAKList(RDRListOptionVO rdrListOptionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RDRAkVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(rdrListOptionVO != null){
				Map<String, String> mapVO = rdrListOptionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new RegionDepartureReportDBDAORDRAkVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RDRAkVO .class);
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
	 * [RDR BREAK BULK] 정보를 [조회] 합니다.<br>
	 * 
	 * @param RDRListOptionVO rdrListOptionVO
	 * @return List<RDRBbVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RDRBbVO> searchRDRBBList(RDRListOptionVO rdrListOptionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RDRBbVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(rdrListOptionVO != null){
				Map<String, String> mapVO = rdrListOptionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new RegionDepartureReportDBDAORDRBbVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RDRBbVO .class);
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
	 * [RDR HC] 정보를 [조회] 합니다.<br>
	 * 
	 * @param RDRListOptionVO rdrListOptionVO
	 * @return List<RDRHcVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RDRHcVO> searchRDRHCList(RDRListOptionVO rdrListOptionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RDRHcVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(rdrListOptionVO != null){
				Map<String, String> mapVO = rdrListOptionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new RegionDepartureReportDBDAORDRHcVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RDRHcVO .class);
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
	 * [RDR REFER MAIN TRADE] 정보를 [조회] 합니다.<br>
	 * 
	 * @param RDRListOptionVO rdrListOptionVO
	 * @return List<RDRRfMainTradeVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RDRRfMainTradeVO> searchRDRRfMainTradeList(RDRListOptionVO rdrListOptionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RDRRfMainTradeVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(rdrListOptionVO != null){
				Map<String, String> mapVO = rdrListOptionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new RegionDepartureReportDBDAORDRRfMainTradeVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RDRRfMainTradeVO .class);
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
	 * [RDR REFER INTER TRADE] 정보를 [조회] 합니다.<br>
	 * 
	 * @param RDRListOptionVO rdrListOptionVO
	 * @return List<RDRRfInterPortVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RDRRfInterPortVO> searchRDRRfInterPortList(RDRListOptionVO rdrListOptionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RDRRfInterPortVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(rdrListOptionVO != null){
				Map<String, String> mapVO = rdrListOptionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new RegionDepartureReportDBDAORDRRfInterPortVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RDRRfInterPortVO .class);
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
	 * [RDR DANGER CNTR] 정보를 [조회] 합니다.<br>
	 * 
	 * @param RDRListOptionVO rdrListOptionVO
	 * @return List<RDRDgVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RDRDgVO> searchRDRDGList(RDRListOptionVO rdrListOptionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RDRDgVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(rdrListOptionVO != null){
				Map<String, String> mapVO = rdrListOptionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new RegionDepartureReportDBDAORDRDgVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RDRDgVO .class);
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
	 * [RDR VESSEL ALLOCATION] 정보를 [조회] 합니다.<br>
	 * 
	 * @param RDRListOptionVO rdrListOptionVO
	 * @return List<RDRVslAllocVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RDRVslAllocVO> searchRDRVSLAllocList(RDRListOptionVO rdrListOptionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RDRVslAllocVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(rdrListOptionVO != null){
				Map<String, String> mapVO = rdrListOptionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new RegionDepartureReportDBDAORDRVslAllocVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RDRVslAllocVO .class);
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
	 * [RDR SLOT RELEASE] 정보를 [조회] 합니다.<br>
	 * 
	 * @param RDRListOptionVO rdrListOptionVO
	 * @return List<RDRSlotReleaseVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RDRSlotReleaseVO> searchRDRSlotReleaseList(RDRListOptionVO rdrListOptionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RDRSlotReleaseVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(rdrListOptionVO != null){
				Map<String, String> mapVO = rdrListOptionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new RegionDepartureReportDBDAORDRSlotReleaseVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RDRSlotReleaseVO .class);
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
	 * [RDR SLOT SWAP] 정보를 [조회] 합니다.<br>
	 * 
	 * @param RDRListOptionVO rdrListOptionVO
	 * @return List<RDRSlotSwapVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RDRSlotSwapVO> searchRDRSlotSwapList(RDRListOptionVO rdrListOptionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RDRSlotSwapVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(rdrListOptionVO != null){
				Map<String, String> mapVO = rdrListOptionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new RegionDepartureReportDBDAORDRSlotSwapVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RDRSlotSwapVO .class);
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
	 * [RDR LOAD HEADER] 정보를 [조회] 합니다.<br>
	 * 
	 * @param RDRListOptionVO rdrListOptionVO
	 * @return List<RDRListOptionVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RDRListOptionVO> searchRDRLoadHeaderList(RDRListOptionVO rdrListOptionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RDRListOptionVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(rdrListOptionVO != null){
				Map<String, String> mapVO = rdrListOptionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new RegionDepartureReportDBDAORDRLoadHeaderRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RDRListOptionVO .class);
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
	 * [RDR LOAD] 정보를 [조회] 합니다.<br>
	 * 
	 * @param RDRListOptionVO rdrListOptionVO
	 * @return List<RDRLoadVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RDRLoadVO> searchRDRLoadList(RDRListOptionVO rdrListOptionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RDRLoadVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		List<String> aryOprCd = new ArrayList();
		try{
			if(rdrListOptionVO != null){
				Map<String, String> mapVO = rdrListOptionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			List<RDRListOptionVO> list2 = searchRDRLoadHeaderList(rdrListOptionVO);
			if(list2 != null){
				for(int cnt = 0; cnt < list2.size(); cnt++){
					aryOprCd.add(list2.get(cnt).getOprCd());
				}
			}
			velParam.put("pol", aryOprCd);
			
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new RegionDepartureReportDBDAORDRLoadVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RDRLoadVO .class);
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
	 * [RDR IPC OVERUSED] 정보를 [조회] 합니다.<br>
	 * 
	 * @param RDRListOptionVO rdrListOptionVO
	 * @return List<RDROverUsedVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RDROverUsedVO> searchRDROverList(RDRListOptionVO rdrListOptionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RDROverUsedVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(rdrListOptionVO != null){
				Map<String, String> mapVO = rdrListOptionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new RegionDepartureReportDBDAORDROverUsedVORSQL(), param, velParam, true);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RDROverUsedVO .class);
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
	 * [RDR REMARK] 정보를 [조회] 합니다.<br>
	 * 
	 * @param RDRListOptionVO rdrListOptionVO
	 * @return List<RDRRemarkVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RDRRemarkVO> searchRDRRemarkList(RDRListOptionVO rdrListOptionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RDRRemarkVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(rdrListOptionVO != null){
				Map<String, String> mapVO = rdrListOptionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new RegionDepartureReportDBDAORDRRemarkVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RDRRemarkVO .class);
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
     * [RDR VESSAL MOVE] 정보를 [조회] 합니다.<br>
     * 
     * @param RDRCrtListOptionVO rDRCrtListOptionVO
     * @return List<RDRVslMvmtVO>
     * @throws DAOException
     */
    public List<RDRVslMvmtVO> searchRDRCrtVSLMvmtList(RDRCrtListOptionVO rDRCrtListOptionVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<RDRVslMvmtVO> list = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            if(rDRCrtListOptionVO != null){
                Map<String, String> mapVO = rDRCrtListOptionVO .getColumnValues();
            
                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new RegionDepartureReportDBDAORDRCreVslMvmtRSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, RDRVslMvmtVO .class);
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
     * Vessel Movement정보를 Import하기 위해 조회한다.<br>
     * 
     * @param RDRCrtListOptionVO rDRCrtListOptionVO
     * @return List<RdrCreatInfoVO>
     * @throws DAOException
     */
    public List<RdrCreatInfoVO> searchRDRImpVSLMvmtList(RDRCrtListOptionVO rDRCrtListOptionVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<RdrCreatInfoVO> list = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            if(rDRCrtListOptionVO != null){
                Map<String, String> mapVO = rDRCrtListOptionVO .getColumnValues();
            
                param.putAll(mapVO);
                velParam.putAll(mapVO); 
            }
            dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new RegionDepartureReportDBDAOSearchImpVslMvmtRSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, RdrCreatInfoVO .class);
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
     *  RDR REPORT HEADER 를 생성 합니다. <br>
     * 
     * @param  RDRCrtListOptionVO rDRCrtListOptionVO
     * @throws DAOException
     */
    public void addRdrHeader(RDRCrtListOptionVO rDRCrtListOptionVO) throws DAOException  {
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        int result = 0;
        try {
            Map<String, String> mapVO = rDRCrtListOptionVO.getColumnValues();
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
            result = sqlExe.executeUpdate((ISQLTemplate)new RegionDepartureReportDBDAOAddRdrHeaderCSQL(), param, velParam);
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
 
//    /**
//     * RDR MOVE 정보를 조회한다.<br>
//     * 
//     * @param RDRCrtListOptionVO rDRCrtListOptionVO
//     * @return List<RdrCreatInfoVO>
//     * @throws DAOException
//     */
//    public List<RdrCreatInfoVO> searchRdrMovement(RDRCrtListOptionVO rDRCrtListOptionVO) throws DAOException {
//        DBRowSet dbRowset = null;
//        List<RdrCreatInfoVO> list = null;
//        //query parameter
//        Map<String, Object> param = new HashMap<String, Object>();
//        //velocity parameter
//        Map<String, Object> velParam = new HashMap<String, Object>();
//
//        try{
//            if(rDRCrtListOptionVO != null){
//                Map<String, String> mapVO = rDRCrtListOptionVO .getColumnValues();
//            
//                param.putAll(mapVO);
//                velParam.putAll(mapVO); 
//            }
//            dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new RegionDepartureReportDBDAOSearchRdrMovementRSQL(), param, velParam);
//            list = (List)RowSetUtil.rowSetToVOs(dbRowset, RdrCreatInfoVO .class);
//        }catch(SQLException se){
//            log.error(se.getMessage(),se);
//            throw new DAOException(new ErrorHandler(se).getMessage());
//        }catch(Exception ex){
//            log.error(ex.getMessage(),ex);
//            throw new DAOException(new ErrorHandler(ex).getMessage());
//        }
//        return list;
//    }
    
    /**
     *  RDR REPORT MOVE 를 생성 합니다. <br>
     * 
     * @param  List<RdrCreatInfoVO> rdrCreatInfoVOs
     * @throws DAOException
     */
    public void addRdrMove(List<RdrCreatInfoVO> rdrCreatInfoVOs) throws DAOException,Exception {
        try {
 
            for(int i=0;i<rdrCreatInfoVOs.size();i++){
                RdrCreatInfoVO rDRCrtListOptionVO = rdrCreatInfoVOs.get(i);
                int result = 0;
                Map<String, Object> param = new HashMap<String, Object>();
                //velocity parameter
                Map<String, Object> velParam = new HashMap<String, Object>();
           
                    Map<String, String> mapVO = rDRCrtListOptionVO.getColumnValues();
                    
                    param.putAll(mapVO);
                    velParam.putAll(mapVO);
                    
                    SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
                    result = sqlExe.executeUpdate((ISQLTemplate)new RegionDepartureReportDBDAOAddRdrMoveCSQL(), param, velParam);
                    if(result == Statement.EXECUTE_FAILED)
                            throw new DAOException("Fail to insert SQL");
 
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
     *  RDR HEADER에 할당된 RDR REPORT MOVE 를 삭제 합니다. <br>
     * 
     * @param  RDRCrtListOptionVO rDRCrtListOptionVO
     * @throws DAOException
     */
    public void removeRdrMoveAll(RDRCrtListOptionVO rDRCrtListOptionVO) throws DAOException,Exception {
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        int result = 0;
        try { 
            Map<String, String> mapVO = rDRCrtListOptionVO.getColumnValues();
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
            result = sqlExe.executeUpdate((ISQLTemplate)new RegionDepartureReportDBDAORemoveRdrMoveAllDSQL(), param, velParam);
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
     * RDR Header정보를 조회한다.<br>
     * 
     * @param RDRCrtListOptionVO rDRCrtListOptionVO
     * @return List<RdrCreatInfoVO>
     * @throws DAOException
     */
    public List<RdrCreatInfoVO> searchRdrHeader(RDRCrtListOptionVO rDRCrtListOptionVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<RdrCreatInfoVO> list = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            if(rDRCrtListOptionVO != null){
                Map<String, String> mapVO = rDRCrtListOptionVO .getColumnValues();
            
                param.putAll(mapVO);
                velParam.putAll(mapVO); 
            }
            dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new RegionDepartureReportDBDAOSearchRdrHeaderRSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, RdrCreatInfoVO .class);
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
     * RDR Header정보를 존재여부 체크한다.<br>
     * 
     * @param RDRCrtListOptionVO rDRCrtListOptionVO
     * @return List<RdrCreatInfoVO>
     * @throws DAOException
     */
    public List<RdrCreatInfoVO> searchRdrHeaderCheck(RDRCrtListOptionVO rDRCrtListOptionVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<RdrCreatInfoVO> list = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            if(rDRCrtListOptionVO != null){
                Map<String, String> mapVO = rDRCrtListOptionVO .getColumnValues();
            
                param.putAll(mapVO);
                velParam.putAll(mapVO); 
            }
            dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new RegionDepartureReportDBDAOSearchRdrHeaderCheckRSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, RdrCreatInfoVO .class);
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list;
    }
//    /**
//     * RDR Move 정보를 조회한다.<br>
//     * 
//     * @param  RDRCrtListOptionVO rDRCrtListOptionVO
//     * @return List<RdrCreatInfoVO>
//     * @throws DAOException
//     */
//    public List<RdrCreatInfoVO> searchRdrMove(RDRCrtListOptionVO rDRCrtListOptionVO) throws DAOException {
//        DBRowSet dbRowset = null;
//        List<RdrCreatInfoVO> list = null;
//        //query parameter
//        Map<String, Object> param = new HashMap<String, Object>();
//        //velocity parameter
//        Map<String, Object> velParam = new HashMap<String, Object>();
//
//        try{
//            if(rDRCrtListOptionVO != null){
//                Map<String, String> mapVO = rDRCrtListOptionVO .getColumnValues();
//            
//                param.putAll(mapVO);
//                velParam.putAll(mapVO); 
//            }
//            dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new RegionDepartureReportDBDAOSearchRdrMoveRSQL(), param, velParam);
//            list = (List)RowSetUtil.rowSetToVOs(dbRowset, RdrCreatInfoVO .class);
//        }catch(SQLException se){
//            log.error(se.getMessage(),se);
//            throw new DAOException(new ErrorHandler(se).getMessage());
//        }catch(Exception ex){
//            log.error(ex.getMessage(),ex);
//            throw new DAOException(new ErrorHandler(ex).getMessage());
//        }
//        return list;
//    }
 
     /**
      * RDR Slot/WGT Util 정보를  조회한다.<br>
      * 
      * @param  RDRCrtListOptionVO rDRCrtListOptionVO
      * @return List<RdrCreatInfoVO>
      * @throws DAOException
      */
      public List<RdrCreatInfoVO> searchRdrSltWgtUtil(RDRCrtListOptionVO rDRCrtListOptionVO) throws DAOException { 
         DBRowSet dbRowset = null;
         List<RdrCreatInfoVO> list = null;
         //query parameter
         Map<String, Object> param = new HashMap<String, Object>();
         //velocity parameter
         Map<String, Object> velParam = new HashMap<String, Object>();

         try{
             if(rDRCrtListOptionVO != null){
                 Map<String, String> mapVO = rDRCrtListOptionVO.getColumnValues();
             
                 param.putAll(mapVO);
                 velParam.putAll(mapVO);
             }

             dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new RegionDepartureReportDBDAOSearchRdrSltWgtUtilRSQL(), param, velParam);
             list = (List)RowSetUtil.rowSetToVOs(dbRowset, RdrCreatInfoVO.class);
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
       *  RDR SLOT/WGT UTIL 를 생성 합니다. <br>
       * 
       * @param  List<RdrCreatInfoVO> rdrCreatInfoVOs
       * @throws DAOException
       */
      public void addRdrSlotWgtUtil(List<RdrCreatInfoVO> rdrCreatInfoVOs) throws DAOException,Exception {
          try {
              SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
              for(int i=0;i<rdrCreatInfoVOs.size();i++){
                  RdrCreatInfoVO rDRCrtListOptionVO = rdrCreatInfoVOs.get(i);
                  int result = 0;
                  Map<String, Object> param = new HashMap<String, Object>();
                  //velocity parameter
                  Map<String, Object> velParam = new HashMap<String, Object>();
 
                      Map<String, String> mapVO = rDRCrtListOptionVO.getColumnValues();
                      
                      param.putAll(mapVO);
                      velParam.putAll(mapVO);
  
                      result = sqlExe.executeUpdate((ISQLTemplate)new RegionDepartureReportDBDAOAddRdrUtilizeCSQL(), param, velParam);
                      if(result == Statement.EXECUTE_FAILED)
                              throw new DAOException("Fail to insert SQL");
  
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
       *  RDR SLOT/WGT UTIL 를 수정 합니다. <br>
       * 
       * @param  List<RdrCreatInfoVO> rdrCreatInfoVOs
       * @throws DAOException
       */
      public void modifyRdrSlotWgtUtil(List<RdrCreatInfoVO> rdrCreatInfoVOs) throws DAOException,Exception {
          try {
              SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
              int insCnt[] = null;
              if(rdrCreatInfoVOs.size() > 0){
                  insCnt = sqlExe.executeBatch((ISQLTemplate)new RegionDepartureReportDBDAOModifyRdrUtilizeUSQL(), rdrCreatInfoVOs, null);
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
       *  RDR HC/45에서 수정시, TYPE별 로직을 사용하여 수정한다.<br>
       * 
       * @param  RdrCreatInfoVO rdrCreatInfoVO
       * @throws DAOException
       */
      public void modifyUtilizeForHC45(RdrCreatInfoVO rdrCreatInfoVO ) throws DAOException,Exception {
          try {
 
              SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
 
 
              int result = 0;
              Map<String, Object> param = new HashMap<String, Object>();
              //velocity parameter
                  Map<String, Object> velParam = new HashMap<String, Object>();
 
                      Map<String, String> mapVO = rdrCreatInfoVO.getColumnValues();
                      
                      param.putAll(mapVO);
                      velParam.putAll(mapVO);
 
                      result = sqlExe.executeUpdate((ISQLTemplate)new RegionDepartureReportDBDAOmofifyRdrUtilHC45USQL(), param, velParam);
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
       *  RDR Utilize Load 를 수정 합니다. <br>
       * 
       * @param  List<RdrCreatInfoVO> rdrCreatInfoVOs
       * @throws DAOException
       */
      public void modifyRdrUtilizeLoad(List<RdrCreatInfoVO> rdrCreatInfoVOs) throws DAOException,Exception {
          try {
              SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
              int insCnt[] = null;
              if(rdrCreatInfoVOs.size() > 0){
                  insCnt = sqlExe.executeBatch((ISQLTemplate)new RegionDepartureReportDBDAOModifyRdrUtilizeForLoadUSQL(), rdrCreatInfoVOs, null);
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
       * 
       * HC45에서 Utilize 수정한다.
       *
       * @param  List<RdrCreatInfoVO> rdrCreatInfoVOs
       * @throws DAOException
       * @author jang kang cheol
       */
      public void mofifyRdrUtilHC45(List<RdrCreatInfoVO> rdrCreatInfoVOs) throws DAOException,Exception {
          try {
              SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
              int insCnt[] = null;
              if(rdrCreatInfoVOs.size() > 0){
                  insCnt = sqlExe.executeBatch((ISQLTemplate)new RegionDepartureReportDBDAOmofifyRdrUtilHC45USQL(), rdrCreatInfoVOs, null);
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
       *  HC45에서 삭제시, UTILIZE를 Load물량을 CLEAR  합니다. <br>
       * 
       * @param  List<RdrCreatInfoVO> rdrCreatInfoVOs
       * @throws DAOException
       */
      public void removeRdrUtilizeLoad(List<RdrCreatInfoVO> rdrCreatInfoVOs) throws DAOException,Exception {
          try {
              SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
              int insCnt[] = null;
              if(rdrCreatInfoVOs.size() > 0){
                  insCnt = sqlExe.executeBatch((ISQLTemplate)new RegionDepartureReportDBDAORemoveRdrUtilizeLoadUSQL(), rdrCreatInfoVOs, null);
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
       *  HC45에서 삭제시, UTILIZE를 High Cubic CLEAR  합니다. <br>
       * 
       * @param  List<RdrCreatInfoVO> rdrCreatInfoVOs
       * @throws DAOException
       */
      public void removeRdrUtilizeHC(List<RdrCreatInfoVO> rdrCreatInfoVOs) throws DAOException,Exception {
          try {
              SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
              int insCnt[] = null;
              if(rdrCreatInfoVOs.size() > 0){
                  insCnt = sqlExe.executeBatch((ISQLTemplate)new RegionDepartureReportDBDAORemoveRdrUtilizeHCUSQL(), rdrCreatInfoVOs, null);
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
       *  RDR SLOT/WGT UTIL 를 삭제 합니다. <br>
       * 
       * @param  List<RdrCreatInfoVO> rdrCreatInfoVOs
       * @throws DAOException
       */
      public void removeRdrSlotWgtUtil(List<RdrCreatInfoVO> rdrCreatInfoVOs) throws DAOException,Exception {
 
          for(int i=0;i<rdrCreatInfoVOs.size();i++){
              RdrCreatInfoVO rDRCrtListOptionVO = rdrCreatInfoVOs.get(i);
              int result = 0;
              Map<String, Object> param = new HashMap<String, Object>();
              //velocity parameter
              Map<String, Object> velParam = new HashMap<String, Object>();
              try {
                  Map<String, String> mapVO = rDRCrtListOptionVO.getColumnValues();
                  
                  param.putAll(mapVO);
                  velParam.putAll(mapVO);
                  
                  SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
                  result = sqlExe.executeUpdate((ISQLTemplate)new RegionDepartureReportDBDAORemoveRdrUtilizeUSQL(), param, velParam);
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
 
      } 
      
      /**
       *  RDR SLOT/WGT UTIL 를 삭제 합니다. <br>
       * 
       * @param  RDRCrtListOptionVO rDRCrtListOptionVO
       * @throws DAOException
       */
      public void removeRdrSltWgtUtilAll(RDRCrtListOptionVO rDRCrtListOptionVO) throws DAOException,Exception {
          int result = 0;
          Map<String, Object> param = new HashMap<String, Object>();
          //velocity parameter
          Map<String, Object> velParam = new HashMap<String, Object>();
          try {
              Map<String, String> mapVO = rDRCrtListOptionVO.getColumnValues();
              
              param.putAll(mapVO);
              velParam.putAll(mapVO);
              
              SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
              result = sqlExe.executeUpdate((ISQLTemplate)new RegionDepartureReportDBDAORemoveRdrUtilizeUSQL(), param, velParam);
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
       * RDR HC45 정보를  조회한다.<br>
       * 
       * @param  RDRCrtListOptionVO rDRCrtListOptionVO
       * @return List<RdrCreatInfoVO>
       * @throws DAOException
       */
       public List<RdrCreatInfoVO> searchRdrHC45(RDRCrtListOptionVO rDRCrtListOptionVO) throws DAOException { 
          DBRowSet dbRowset = null;
          List<RdrCreatInfoVO> list = null;
          //query parameter
          Map<String, Object> param = new HashMap<String, Object>();
          //velocity parameter
          Map<String, Object> velParam = new HashMap<String, Object>();

          try{
              if(rDRCrtListOptionVO != null){
                  Map<String, String> mapVO = rDRCrtListOptionVO.getColumnValues();
              
                  param.putAll(mapVO);
                  velParam.putAll(mapVO);
              }

              dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new RegionDepartureReportDBDAOSearchHC45RSQL(), param, velParam);
              list = (List)RowSetUtil.rowSetToVOs(dbRowset, RdrCreatInfoVO.class);
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
        * RDR Utilize  정보를  조회한다.<br>
        * 
        * @param  RdrCreatInfoVO rdrCreatInfoVO
        * @return List<RdrCreatInfoVO>
        * @throws DAOException
        */
        public List<RdrCreatInfoVO> searchRdrUtilize(RdrCreatInfoVO rdrCreatInfoVO) throws DAOException { 
           DBRowSet dbRowset = null;
           List<RdrCreatInfoVO> list = null;
           //query parameter
           Map<String, Object> param = new HashMap<String, Object>();
           //velocity parameter
           Map<String, Object> velParam = new HashMap<String, Object>();
    
           try{
               if(rdrCreatInfoVO != null){
                   Map<String, String> mapVO = rdrCreatInfoVO.getColumnValues();
               
                   param.putAll(mapVO);
                   velParam.putAll(mapVO);
               }
    
               dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new RegionDepartureReportDBDAOSearchRdrUtilizeRSQL(), param, velParam);
               list = (List)RowSetUtil.rowSetToVOs(dbRowset, RdrCreatInfoVO.class);
           }catch(SQLException se){
               log.error(se.getMessage(),se);
               throw new DAOException(new ErrorHandler(se).getMessage());
           }catch(Exception ex){
               log.error(ex.getMessage(),ex);
               throw new DAOException(new ErrorHandler(ex).getMessage());
           }
           return list;
       }
//        /**
//         * RDR Utilize  OprerCode까지 정보를  조회한다.<br>
//         * 
//         * @param  RdrCreatInfoVO rdrCreatInfoVO
//         * @return List<RdrCreatInfoVO>
//         * @throws DAOException
//         */
//         public List<RdrCreatInfoVO> searchRdrUtilizeForOprCode(RdrCreatInfoVO rdrCreatInfoVO) throws DAOException { 
//            DBRowSet dbRowset = null;
//            List<RdrCreatInfoVO> list = null;
//            //query parameter
//            Map<String, Object> param = new HashMap<String, Object>();
//            //velocity parameter
//            Map<String, Object> velParam = new HashMap<String, Object>();
//     
//            try{
//                if(rdrCreatInfoVO != null){
//                    Map<String, String> mapVO = rdrCreatInfoVO.getColumnValues();
//                
//                    param.putAll(mapVO);
//                    velParam.putAll(mapVO);
//                }
//     
//                dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new RegionDepartureReportDBDAOSearchHC45RSQL(), param, velParam);
//                list = (List)RowSetUtil.rowSetToVOs(dbRowset, RdrCreatInfoVO.class);
//            }catch(SQLException se){
//                log.error(se.getMessage(),se);
//                throw new DAOException(new ErrorHandler(se).getMessage());
//            }catch(Exception ex){
//                log.error(ex.getMessage(),ex);
//                throw new DAOException(new ErrorHandler(ex).getMessage());
//            }
//            return list;
//        } 
       /**
        * RDR HC45 Import Sub Allocation 정보를  조회한다.<br>
        * 
        * @param  RDRCrtListOptionVO rDRCrtListOptionVO
        * @return List<RdrCreatInfoVO>
        * @throws DAOException
        */
        public List<RdrCreatInfoVO> searchRDRImpHC45(RDRCrtListOptionVO rDRCrtListOptionVO) throws DAOException { 
           DBRowSet dbRowset = null;
           List<RdrCreatInfoVO> list = null;
           //query parameter
           Map<String, Object> param = new HashMap<String, Object>();
           //velocity parameter
           Map<String, Object> velParam = new HashMap<String, Object>();

           try{
               if(rDRCrtListOptionVO != null){
                   Map<String, String> mapVO = rDRCrtListOptionVO.getColumnValues();
               
                   param.putAll(mapVO);
                   velParam.putAll(mapVO);
               }

               dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new RegionDepartureReportDBDAOSearchRdrImpHC45RSQL(), param, velParam);
               list = (List)RowSetUtil.rowSetToVOs(dbRowset, RdrCreatInfoVO.class);
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
         * RDR BSA 정보를 조회한다.<br>
         * 
         * @param RdrCreatInfoVO rdrCreatInfoVO
         * @return List<RdrCreatInfoVO>
         * @throws DAOException
         */
        public List<RdrCreatInfoVO> searchRdrBsa(RdrCreatInfoVO rdrCreatInfoVO) throws DAOException {
            DBRowSet dbRowset = null;
            List<RdrCreatInfoVO> list = null;
            //query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            //velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();

            try{
                if(rdrCreatInfoVO != null){
                    Map<String, String> mapVO = rdrCreatInfoVO .getColumnValues();
                
                    param.putAll(mapVO);
                    velParam.putAll(mapVO); 
                }
                dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new RegionDepartureReportDBDAOSearchRdrBsaRSQL(), param, velParam);
                list = (List)RowSetUtil.rowSetToVOs(dbRowset, RdrCreatInfoVO .class);
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
         *  RDR HC45 를 생성시 RDR_BSA를 생성  합니다. <br>
         * 
         * @param  List<RdrCreatInfoVO> rdrCreatInfoVOs
         * @throws DAOException
         */
        public void addRdrHC45ForBSA(List<RdrCreatInfoVO> rdrCreatInfoVOs) throws DAOException,Exception {
            try {
                SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
                int insCnt[] = null;
                if(rdrCreatInfoVOs.size() > 0){
                    insCnt = sqlExe.executeBatch((ISQLTemplate)new RegionDepartureReportDBDAOAddRdrHC45CSQL(), rdrCreatInfoVOs, null);
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
         *  RDR BSA 를 수정 합니다. <br>
         * 
         * @param  List<RdrCreatInfoVO> rdrCreatInfoVOs
         * @throws DAOException
         */
        public void modifyRdrHC45ForBSA(List<RdrCreatInfoVO> rdrCreatInfoVOs) throws DAOException,Exception {
            try {
                SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
                int insCnt[] = null;
                if(rdrCreatInfoVOs.size() > 0){
                    insCnt = sqlExe.executeBatch((ISQLTemplate)new RegionDepartureReportDBDAOModifyRdrHC45ForBSAUSQL(), rdrCreatInfoVOs, null);
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
         *  HC45에서 삭제시, RDR BSA 를 삭제  합니다. <br>
         * 
         * @param  List<RdrCreatInfoVO> rdrCreatInfoVOs
         * @throws DAOException
         */
        public void removeRdrHC45ForBSA(List<RdrCreatInfoVO> rdrCreatInfoVOs) throws DAOException,Exception {
            try {
                SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
                int insCnt[] = null;
                if(rdrCreatInfoVOs.size() > 0){
                    insCnt = sqlExe.executeBatch((ISQLTemplate)new RegionDepartureReportDBDAORemoveRdrBsaDSQL(), rdrCreatInfoVOs, null);
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
         *  HC45에서 삭제시, RDR BSA 를 VVD, REGION별  삭제  합니다. <br>
         * 
         * @param  RDRCrtListOptionVO rdrCrtListOptionVO
         * @throws DAOException
         */
        public void removeRdrHC45ForBsaAll(RDRCrtListOptionVO rdrCrtListOptionVO) throws DAOException,Exception {
            int result = 0;
            Map<String, Object> param = new HashMap<String, Object>();
            //velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();
            try {
                Map<String, String> mapVO = rdrCrtListOptionVO.getColumnValues();
                
                param.putAll(mapVO);
                velParam.putAll(mapVO);
                
                SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
                result = sqlExe.executeUpdate((ISQLTemplate)new RegionDepartureReportDBDAORemoveRdrBsaAllDSQL(), param, velParam);
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
     *  HC45에서 삭제시, UTILIZE를 CLEAR  합니다. <br>
     * 
     * @param  RDRCrtListOptionVO rdrCrtListOptionVO
     * @throws DAOException
     */
    public void removeRdrUtilizeAll(RDRCrtListOptionVO rdrCrtListOptionVO) throws DAOException,Exception {
        int result = 0;
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = rdrCrtListOptionVO.getColumnValues();
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
            result = sqlExe.executeUpdate((ISQLTemplate)new RegionDepartureReportDBDAORemoveRdrUtilizeForBsaUSQL (), param, velParam);
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
     * RDR RF의 MainTrade 정보를 조회한다.<br>
     * 
     * @param  RDRCrtListOptionVO rDRCrtListOptionVO
     * @return List<RdrCreatInfoVO>
     * @throws DAOException
     */
    public List<RdrCreatInfoVO> searchRdrRfListMainTrade(RDRCrtListOptionVO rDRCrtListOptionVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<RdrCreatInfoVO> list = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            if(rDRCrtListOptionVO != null){
                Map<String, String> mapVO = rDRCrtListOptionVO .getColumnValues();
            
                param.putAll(mapVO);
                velParam.putAll(mapVO); 
            }
            dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new RegionDepartureReportDBDAOSearchRdrRfListMainTradeRSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, RdrCreatInfoVO .class);
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
     * RDR RF의 Inter Port 정보를 조회한다.<br>
     * 
     * @param  RDRCrtListOptionVO rDRCrtListOptionVO
     * @return List<RdrCreatInfoVO>
     * @throws DAOException
     */
    public List<RdrCreatInfoVO> searchRdrRfListInterPort(RDRCrtListOptionVO rDRCrtListOptionVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<RdrCreatInfoVO> list = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            if(rDRCrtListOptionVO != null){
                Map<String, String> mapVO = rDRCrtListOptionVO .getColumnValues();
            
                param.putAll(mapVO);
                velParam.putAll(mapVO); 
            }
            dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new RegionDepartureReportDBDAOSearchRdrRfListInterPortRSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, RdrCreatInfoVO .class);
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
     *  RDR REPORT RF(RDR Summary) 를 생성 합니다. <br>
     * 
     * @param  List<RdrCreatInfoVO> rdrCreatInfoVOs
     * @throws DAOException
     */
    public void addRdrRf(List<RdrCreatInfoVO> rdrCreatInfoVOs) throws DAOException,Exception {
        try {
            SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
            int insCnt[] = null;
            if(rdrCreatInfoVOs.size() > 0){
                insCnt = sqlExe.executeBatch((ISQLTemplate)new RegionDepartureReportDBDAOAddRdrRfCSQL(), rdrCreatInfoVOs, null);
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
     *  RDR REPORT RF 를 수정  합니다. <br>
     * 
     * @param  List<RdrCreatInfoVO> rdrCreatInfoVOs
     * @throws DAOException
     */
    public void modifyRdrRf(List<RdrCreatInfoVO> rdrCreatInfoVOs) throws DAOException,Exception {
        try {
            SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
            int insCnt[] = null;
            if(rdrCreatInfoVOs.size() > 0){
                insCnt = sqlExe.executeBatch((ISQLTemplate)new RegionDepartureReportDBDAOModifyRdrRfUSQL(), rdrCreatInfoVOs, null);
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
     *  RDR REPORT RF 를 삭제  합니다. <br>
     * 
     * @param  List<RdrCreatInfoVO> rdrCreatInfoVOs
     * @throws DAOException
     */
    public void removeRdrRf(List<RdrCreatInfoVO> rdrCreatInfoVOs) throws DAOException,Exception {
        try {
            SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
            int insCnt[] = null;
            if(rdrCreatInfoVOs.size() > 0){
                insCnt = sqlExe.executeBatch((ISQLTemplate)new RegionDepartureReportDBDAORemoveRdrRfDSQL(), rdrCreatInfoVOs, null);
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
     *  RDR REPORT RF 를 전제(VVD, REGION 별) 삭제  합니다. <br>
     * 
     * @param  RDRCrtListOptionVO rdrCrtListOptionVO
     * @throws DAOException
     */
    public void removeRdrRfAll(RDRCrtListOptionVO rdrCrtListOptionVO) throws DAOException,Exception {
 
        int result = 0;
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = rdrCrtListOptionVO.getColumnValues();
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
            result = sqlExe.executeUpdate((ISQLTemplate)new RegionDepartureReportDBDAORemoveRdrRfAllDSQL (), param, velParam);
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
     * RDR VSL Alloc 정보를  조회한다
     * 
     * @param  RDRCrtListOptionVO rdrCrtListOptionVO
     * @return List<RdrCreatInfoVO>
     * @throws DAOException
     */
    public List<RdrCreatInfoVO> searchRdrVSLAlloc(RDRCrtListOptionVO rdrCrtListOptionVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<RdrCreatInfoVO> list = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            if(rdrCrtListOptionVO != null){
                Map<String, String> mapVO = rdrCrtListOptionVO .getColumnValues();
            
                param.putAll(mapVO);
                velParam.putAll(mapVO); 
            }
            dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new RegionDepartureReportDBDAOSearchRdrVSLAllocRSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, RdrCreatInfoVO .class);
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
    * Import RDR VSL Alloc 정보를  조회한다. <br>
     * 
     * @param  RDRCrtListOptionVO rdrCrtListOptionVO
     * @return List<RdrCreatInfoVO>
     * @throws DAOException
     */
    public List<RdrCreatInfoVO> searchImpRdrVSLAlloc(RDRCrtListOptionVO rdrCrtListOptionVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<RdrCreatInfoVO> list = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            if(rdrCrtListOptionVO != null){
                Map<String, String> mapVO = rdrCrtListOptionVO .getColumnValues();
            
                param.putAll(mapVO);
                velParam.putAll(mapVO); 
            }
            dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new RegionDepartureReportDBDAOSearchImpRdrVSLAllocRSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, RdrCreatInfoVO .class);
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
     *  RDR REPORT ALLOCATION 를 조회 합니다. <br>
     * 
     * @return List<RdrCreatInfoVO>
     * @param  RdrCreatInfoVO rdrCreatInfoVO
     * @throws DAOException
     */
    public List<RdrCreatInfoVO> searchRdrAllocation(RdrCreatInfoVO rdrCreatInfoVO) throws DAOException,Exception {
        DBRowSet dbRowset = null;
        List<RdrCreatInfoVO> list = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            if(rdrCreatInfoVO != null){
                Map<String, String> mapVO = rdrCreatInfoVO .getColumnValues();
            
                param.putAll(mapVO);
                velParam.putAll(mapVO); 
            }
            dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new RegionDepartureReportDBDAOSearchRdrAllocationRSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, RdrCreatInfoVO .class);
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
     *  RDR REPORT ALLOCATION 를 생성 합니다. <br>
     * 
     * @param  List<RdrCreatInfoVO> rdrCreatInfoVOs
     * @throws DAOException
     */
    public void addRdrAllocation(List<RdrCreatInfoVO> rdrCreatInfoVOs) throws DAOException,Exception {
        try {
            SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
            int insCnt[] = null;
            if(rdrCreatInfoVOs.size() > 0){
                insCnt = sqlExe.executeBatch((ISQLTemplate)new RegionDepartureReportDBDAOAddRdrAllocationCSQL(), rdrCreatInfoVOs, null);
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
     *  RDR REPORT ALLOCATION 를 수정 합니다. <br>
     * 
     * @param  List<RdrCreatInfoVO> rdrCreatInfoVOs
     * @throws DAOException
     */
    public void modifyRdrAllocation(List<RdrCreatInfoVO> rdrCreatInfoVOs) throws DAOException,Exception {
        try {
            SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
            int insCnt[] = null;
            if(rdrCreatInfoVOs.size() > 0){
                insCnt = sqlExe.executeBatch((ISQLTemplate)new RegionDepartureReportDBDAOModifyRdrAllocationUSQL(), rdrCreatInfoVOs, null);
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
     *  RDR REPORT ALLOCATION 를 삭제 합니다. <br>
     * 
     * @param  List<RdrCreatInfoVO> rdrCreatInfoVOs
     * @throws DAOException
     */
    public void removeRdrAllocation( List<RdrCreatInfoVO> rdrCreatInfoVOs ) throws DAOException,Exception {
        try {
            SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
            int insCnt[] = null;
            if(rdrCreatInfoVOs.size() > 0){
                insCnt = sqlExe.executeBatch((ISQLTemplate)new RegionDepartureReportDBDAORemoveRdrAllocationDSQL(), rdrCreatInfoVOs, null);
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
     *  RDR REPORT ALLOCATION 를 전체(VVD, REGION 별) 삭제  합니다. <br>
     * 
     * @param  RDRCrtListOptionVO rdrCrtListOptionVO
     * @throws DAOException
     */
    public void removeRdrAllocationAll(RDRCrtListOptionVO rdrCrtListOptionVO) throws DAOException,Exception {
 
        int result = 0;
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = rdrCrtListOptionVO.getColumnValues();
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
            result = sqlExe.executeUpdate((ISQLTemplate)new RegionDepartureReportDBDAORemoveRdrAllocationAllDSQL(), param, velParam);
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
     *  RDR REPORT HEADER의 REMARK를 생성 합니다. <br>
     * 
     * @param  RDRCrtListOptionVO rDRCrtListOptionVO
     * @throws DAOException
     */
    public void modifyRdrHeaderForRemark(RDRCrtListOptionVO rDRCrtListOptionVO) throws DAOException  {
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        int result = 0;
        try { 
            Map<String, String> mapVO = rDRCrtListOptionVO.getColumnValues();
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
            result = sqlExe.executeUpdate((ISQLTemplate)new RegionDepartureReportDBDAOModifyRdrHeaderForRemarkUSQL(), param, velParam);
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
     *  RDR Header의 Remark 정보를 가져온다. <br>
     * 
     * @param  RDRCrtListOptionVO rdrCrtListOptionVO
     * @return List<RdrCreatInfoVO>
     * @throws DAOException
     */
    public List<RdrCreatInfoVO> searchRdrHeaderRemark(RDRCrtListOptionVO rdrCrtListOptionVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<RdrCreatInfoVO> list = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            if(rdrCrtListOptionVO != null){
                Map<String, String> mapVO = rdrCrtListOptionVO .getColumnValues();
            
                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new RegionDepartureReportDBDAOSearchRdrHeaderRemarkRSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, RdrCreatInfoVO .class);
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
     * [RDR NEXT PORT] 정보를 [조회] 합니다.<br>
     * 
     * @param  RDRCrtListOptionVO rdrCrtListOptionVO
     * @return List<RdrCreatInfoVO>
     * @throws DAOException
     */
 
    public List<RdrCreatInfoVO> searchRDRCreNextPortList(RDRCrtListOptionVO rdrCrtListOptionVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<RdrCreatInfoVO> list = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            if(rdrCrtListOptionVO != null){
                Map<String, String> mapVO = rdrCrtListOptionVO .getColumnValues();
            
                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new RegionDepartureReportDBDAOSearchRDRCreNextPortListRSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, RdrCreatInfoVO .class);
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
     * [RDR UTILIZE] 정보를 삭제  합니다.<br>
     * 
     * @param  RDRCrtListOptionVO rdrCrtListOptionVO
     * @throws DAOException
     */
 
    public void removeRdrUtilize(RDRCrtListOptionVO rdrCrtListOptionVO) throws DAOException {
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        int result = 0;
        try { 
            Map<String, String> mapVO = rdrCrtListOptionVO.getColumnValues();
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
            result = sqlExe.executeUpdate((ISQLTemplate)new RegionDepartureReportDBDAORemoveAllRdrUtilizeDSQL(), param, velParam);
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
     *  RDR REPORT HEADER의 정보를 삭제 합니다. <br>
     * 
     * @param  RDRCrtListOptionVO rDRCrtListOptionVO
     * @throws DAOException
     */
    public void removeRdrHeader (RDRCrtListOptionVO rDRCrtListOptionVO) throws DAOException  {
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        int result = 0;
        try { 
            Map<String, String> mapVO = rDRCrtListOptionVO.getColumnValues();
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
            result = sqlExe.executeUpdate((ISQLTemplate)new RegionDepartureReportDBDAORemoveRdrHeaderDSQL(), param, velParam);
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
     * [RDR Creation 화면 VVD 별 Last Port ] 정보를 [조회] 합니다.<br>
     * 
     * @param RDRCrtListOptionVO rDRCrtListOptionVO
     * @return List<RDRSearchRegionLastPortVO>
     * @throws DAOException
     */
    public List<RDRSearchRegionLastPortVO> searchRegionLastPort(RDRCrtListOptionVO rDRCrtListOptionVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<RDRSearchRegionLastPortVO> list = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            if(rDRCrtListOptionVO != null){
                Map<String, String> mapVO = rDRCrtListOptionVO .getColumnValues();
            
                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new RegionDepartureReportDBDAOSearchRegionLastPortVORSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, RDRSearchRegionLastPortVO .class);
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
	 * [Region Code] 정보를 [조회] 합니다.<br>
	 * 
	 * @param RDRListOptionVO rdrListOptionVO
	 * @return List<ComIntgCdDtlVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<ComIntgCdDtlVO> searchRDRRegionList(RDRListOptionVO rdrListOptionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ComIntgCdDtlVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(rdrListOptionVO != null){
				
				Map<String, String> mapVO = rdrListOptionVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new RegionDepartureReportDBDAOSearchRDRRegionListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ComIntgCdDtlVO .class);
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
	 * [Region Code] 정보를 [조회] 합니다.<br>
	 * 
	 * @param List<RdrCreatInfoVO> rdrCreatInfoVOs
	 * @param RDRCrtListOptionVO rdrCrtListOptionVO
	 * @return List<RdrCreatInfoVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RdrCreatInfoVO> searchMtyRdrUtilize(List<RdrCreatInfoVO> rdrCreatInfoVOs, RDRCrtListOptionVO rdrCrtListOptionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RdrCreatInfoVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		velParam.put("list_obj", rdrCreatInfoVOs);

		try{
			if(rdrCrtListOptionVO != null){
				
				Map<String, String> mapVO = rdrCrtListOptionVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new RegionDepartureReportDBDAOSearchMtyRdrUtilizeRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RdrCreatInfoVO .class);
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
		 * [RDR Summary] 정보를 [조회] 합니다.<br>
		 * 
		 * @param RDRSummaryVO rDRSummaryVO
		 * @return List<RDRSummaryVO>
		 * @throws DAOException
		 */
		 @SuppressWarnings("unchecked")
		public List<RDRSummaryVO> searchRDRSummaryList(RDRSummaryVO rDRSummaryVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<RDRSummaryVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(rDRSummaryVO != null){
					Map<String, String> mapVO = rDRSummaryVO.getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new RegionDepartureReportDBDAOsearchRDRSummaryListRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, RDRSummaryVO .class);
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
