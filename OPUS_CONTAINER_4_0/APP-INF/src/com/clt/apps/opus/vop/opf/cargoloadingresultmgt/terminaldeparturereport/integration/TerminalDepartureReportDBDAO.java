/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TerminalDepartureReportDBDAO.java
*@FileTitle : TDR Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.06
*@LastModifier : 장석현
*@LastVersion : 1.0
* 2009.07.06 장석현
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.basic.TerminalDepartureReportBCImpl;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.CgoHndPerformInputVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.CgoRhndPerformInputVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.DischVolSGTdrVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.MdmRhqComboVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.MissingTDRCondVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.MissingTDRVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.OpfTmlProdRptRsnCdVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.PortLogDetailVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.PortLogHeadVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.TdrAllocationBSAVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.TdrBsaVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.TdrDistLoadVolVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.TdrHeaderSkdVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.TdrListOptionVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.TdrSlotHC45VO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.TdrUtilizeSlotPortVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.TdrUtilizeVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.TerminalDepartureReportCondVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.TerminalDepartureReportConditionVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.TerminalDepartureReportVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.TmnlPerformInputVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.TmnlPerformVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.VskVslPortSkdSheetVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.MdmYardVO;
import com.clt.syscommon.common.table.OpfRstwgRsnCdVO;
import com.clt.syscommon.common.table.OpfTmlDepRptDtlVO;
import com.clt.syscommon.common.table.TdrAllocationVO;
import com.clt.syscommon.common.table.TdrCntrDetailVO;
import com.clt.syscommon.common.table.TdrCraneVO;
import com.clt.syscommon.common.table.TdrHeaderVO;
import com.clt.syscommon.common.table.TdrSummaryVO;


/**
 * OPUS TerminalDepartureReportDBDAO <br>
 * - OPUS-CargoLoadingResultMgt system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Jang Suk Hyun
 * @see TerminalDepartureReportBCImpl 참조
 * @since J2EE 1.6
 */
public class TerminalDepartureReportDBDAO extends DBDAOSupport {

	/**
	 * [Actual Schedule] 정보를 [조회] 합니다.<br>
	 * 
	 * @param TerminalDepartureReportCondVO terminalDepartureReportCondVO
	 * @return List<VskVslPortSkdSheetVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<VskVslPortSkdSheetVO> searchTdrSKDList(TerminalDepartureReportCondVO terminalDepartureReportCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<VskVslPortSkdSheetVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(terminalDepartureReportCondVO != null){
				Map<String, String> mapVO = terminalDepartureReportCondVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TerminalDepartureReportDBDAOVskVslPortSkdSheetVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VskVslPortSkdSheetVO.class);
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
	 * [TDR Header] 정보를 [조회] 합니다.<br>
	 * 
	 * @param TerminalDepartureReportCondVO terminalDepartureReportCondVO
	 * @return List<TdrHeaderVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<TdrHeaderSkdVO> searchTdrHeaderList(TerminalDepartureReportCondVO terminalDepartureReportCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<TdrHeaderSkdVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(terminalDepartureReportCondVO != null){
				Map<String, String> mapVO = terminalDepartureReportCondVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TerminalDepartureReportDBDAOTdrHeaderSkdVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, TdrHeaderSkdVO.class);
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
	 * [TDR Port Log Header] 정보를 [조회] 합니다.<br>
	 * 
	 * @param TerminalDepartureReportCondVO terminalDepartureReportCondVO
	 * @return List<PortLogHeadVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked") 
	public List<PortLogHeadVO> searchTdrPortLogHeadList(TerminalDepartureReportCondVO terminalDepartureReportCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PortLogHeadVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(terminalDepartureReportCondVO != null){
				Map<String, String> mapVO = terminalDepartureReportCondVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TerminalDepartureReportDBDAOPortLogHeadVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PortLogHeadVO.class);
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
	 * [TDR Crane] 정보를 [조회] 합니다.<br>
	 * 
	 * @param TerminalDepartureReportCondVO terminalDepartureReportCondVO
	 * @return List<PortLogDetailVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked") 
	public List<PortLogDetailVO> searchTdrPortLogDetailList(TerminalDepartureReportCondVO terminalDepartureReportCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PortLogDetailVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(terminalDepartureReportCondVO != null){
				Map<String, String> mapVO = terminalDepartureReportCondVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TerminalDepartureReportDBDAOPortLogDetailVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PortLogDetailVO.class);
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
	 * [BKG Total Vol.] 정보를 [조회] 합니다.<br>
	 * 
	 * @param TerminalDepartureReportCondVO terminalDepartureReportCondVO
	 * @return List<TdrDistLoadVolVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked") 
	public List<TdrDistLoadVolVO> searchBkgVolumeDischTotal(TerminalDepartureReportCondVO terminalDepartureReportCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<TdrDistLoadVolVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(terminalDepartureReportCondVO != null){
				Map<String, String> mapVO = terminalDepartureReportCondVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TerminalDepartureReportDBDAODischImportTotalVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, TdrDistLoadVolVO.class);
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
	 * [TDR Dich. Total Vol.] 정보를 [조회] 합니다.<br>
	 * 
	 * @param TerminalDepartureReportCondVO terminalDepartureReportCondVO
	 * @return List<TdrDistLoadVolVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked") 
	public List<TdrDistLoadVolVO> searchTdrDischargeTotalList(TerminalDepartureReportCondVO terminalDepartureReportCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<TdrDistLoadVolVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(terminalDepartureReportCondVO != null){
				Map<String, String> mapVO = terminalDepartureReportCondVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TerminalDepartureReportDBDAODischVolTotalTdrVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, TdrDistLoadVolVO.class);
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
	 * [BKG SCG Vol.] 정보를 [조회] 합니다.<br>
	 * 
	 * @param TerminalDepartureReportCondVO terminalDepartureReportCondVO
	 * @return List<DischVolSGTdrVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked") 
	public List<DischVolSGTdrVO> searchBkgVolumeDischSG(TerminalDepartureReportCondVO terminalDepartureReportCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<DischVolSGTdrVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(terminalDepartureReportCondVO != null){
				Map<String, String> mapVO = terminalDepartureReportCondVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TerminalDepartureReportDBDAODischImportSGVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, DischVolSGTdrVO.class);
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
	 * [TDR Dich. SCG Vol.] 정보를 [조회] 합니다.<br>
	 * 
	 * @param TerminalDepartureReportCondVO terminalDepartureReportCondVO
	 * @return List<DischVolSGTdrVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked") 
	public List<DischVolSGTdrVO> searchTdrDischargeSGList(TerminalDepartureReportCondVO terminalDepartureReportCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<DischVolSGTdrVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(terminalDepartureReportCondVO != null){
				Map<String, String> mapVO = terminalDepartureReportCondVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
//			}
			
				//if(!terminalDepartureReportCondVO.getSysCreate().equals("") && terminalDepartureReportCondVO.getSysCreate().substring(0, 2).toUpperCase().equals("IN")){
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TerminalDepartureReportDBDAODischVolSGTdrSummaryVORSQL(), param, velParam);
					list = (List)RowSetUtil.rowSetToVOs(dbRowset, DischVolSGTdrVO.class);
				//}else{
				//	dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TerminalDepartureReportDBDAODischVolSGTdrVORSQL(), param, velParam);
				//	list = (List)RowSetUtil.rowSetToVOs(dbRowset, DischVolSGTdrVO.class);
				//}
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
	 * [TDR Load. SCG Vol.] 정보를 [조회] 합니다.<br>
	 * 
	 * @param TerminalDepartureReportCondVO terminalDepartureReportCondVO
	 * @return List<DischVolSGTdrVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked") 
	public List<DischVolSGTdrVO> searchTdrLoadSGList(TerminalDepartureReportCondVO terminalDepartureReportCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<DischVolSGTdrVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(terminalDepartureReportCondVO != null){
				Map<String, String> mapVO = terminalDepartureReportCondVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TerminalDepartureReportDBDAOLoadVolSGTdrVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, DischVolSGTdrVO.class);
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
	 * [BKG Break Bulk Vol.] 정보를 [조회] 합니다.<br>
	 * 
	 * @param TerminalDepartureReportCondVO terminalDepartureReportCondVO
	 * @return List<TdrCntrDetailVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked") 
	public List<TdrCntrDetailVO> searchBkgVolumeDischBreak(TerminalDepartureReportCondVO terminalDepartureReportCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<TdrCntrDetailVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(terminalDepartureReportCondVO != null){
				Map<String, String> mapVO = terminalDepartureReportCondVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TerminalDepartureReportDBDAODischImportBreakVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, TdrCntrDetailVO.class);
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
	 * [TDR Break Bulk Vol.] 정보를 [조회] 합니다.<br>
	 * 
	 * @param TerminalDepartureReportCondVO terminalDepartureReportCondVO
	 * @return List<TdrCntrDetailVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked") 
	public List<TdrCntrDetailVO> searchTdrDischargeBreakList(TerminalDepartureReportCondVO terminalDepartureReportCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<TdrCntrDetailVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(terminalDepartureReportCondVO != null){
				Map<String, String> mapVO = terminalDepartureReportCondVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TerminalDepartureReportDBDAOTdrCntrDetailBreakVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, TdrCntrDetailVO.class);
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
	 * [TDR Ocean Vol.] 정보를 [조회] 합니다.<br>
	 * 
	 * @param TerminalDepartureReportCondVO terminalDepartureReportCondVO
	 * @return List<TdrDistLoadVolVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked") 
	public List<TdrDistLoadVolVO> searchTdrLoadOceanPortList(TerminalDepartureReportCondVO terminalDepartureReportCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<TdrDistLoadVolVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(terminalDepartureReportCondVO != null){
				Map<String, String> mapVO = terminalDepartureReportCondVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TerminalDepartureReportDBDAOLoadVolOceanTdrVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, TdrDistLoadVolVO.class);
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
	 * [BKG Load Total Vol.] 정보를 [조회] 합니다.<br>
	 * 
	 * @param TerminalDepartureReportCondVO terminalDepartureReportCondVO
	 * @return List<TdrDistLoadVolVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked") 
	public List<TdrDistLoadVolVO> searchBkgVolumeLoadTotal(TerminalDepartureReportCondVO terminalDepartureReportCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<TdrDistLoadVolVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(terminalDepartureReportCondVO != null){
				Map<String, String> mapVO = terminalDepartureReportCondVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TerminalDepartureReportDBDAOLoadImportTotalVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, TdrDistLoadVolVO.class);
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
	 * [BKG Load SCG Vol.] 정보를 [조회] 합니다.<br>
	 * 
	 * @param TerminalDepartureReportCondVO terminalDepartureReportCondVO
	 * @return List<TdrDistLoadVolVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked") 
	public List<DischVolSGTdrVO> searchBkgVolumeLoadSG(TerminalDepartureReportCondVO terminalDepartureReportCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<DischVolSGTdrVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(terminalDepartureReportCondVO != null){
				Map<String, String> mapVO = terminalDepartureReportCondVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TerminalDepartureReportDBDAOLoadImportSGVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, DischVolSGTdrVO.class);
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
	 * [BKG Load Break Bulk] 정보를 [조회] 합니다.<br>
	 * 
	 * @param TerminalDepartureReportCondVO terminalDepartureReportCondVO
	 * @return List<TdrDistLoadVolVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked") 
	public List<TdrCntrDetailVO> searchBkgVolumeLoadBreak(TerminalDepartureReportCondVO terminalDepartureReportCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<TdrCntrDetailVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(terminalDepartureReportCondVO != null){
				Map<String, String> mapVO = terminalDepartureReportCondVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TerminalDepartureReportDBDAOLoadImportBreakVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, TdrCntrDetailVO.class);
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
	 * [TDR COD] 정보를 [조회] 합니다.<br>
	 * 
	 * @param TerminalDepartureReportCondVO terminalDepartureReportCondVO
	 * @return List<TdrCntrDetailVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked") 
	public List<TdrCntrDetailVO> searchTdrCodList(TerminalDepartureReportCondVO terminalDepartureReportCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<TdrCntrDetailVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(terminalDepartureReportCondVO != null){
				Map<String, String> mapVO = terminalDepartureReportCondVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TerminalDepartureReportDBDAOCodContainerVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, TdrCntrDetailVO.class);
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
	 * [TDR REHandle] 정보를 [조회] 합니다.<br>
	 * 
	 * @param TerminalDepartureReportCondVO terminalDepartureReportCondVO
	 * @return List<TdrCntrDetailVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked") 
	public List<TdrCntrDetailVO> searchTdrRHList(TerminalDepartureReportCondVO terminalDepartureReportCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<TdrCntrDetailVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(terminalDepartureReportCondVO != null){
				Map<String, String> mapVO = terminalDepartureReportCondVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TerminalDepartureReportDBDAORHContainerVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, TdrCntrDetailVO.class);
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
	 * [TDR MisHandle] 정보를 [조회] 합니다.<br>
	 * 
	 * @param TerminalDepartureReportConditionVO terminalDepartureReportCondVO
	 * @return List<TdrCntrDetailVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked") 
	public List<TdrCntrDetailVO> searchTdrMisHandleList(TerminalDepartureReportConditionVO  terminalDepartureReportCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<TdrCntrDetailVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(terminalDepartureReportCondVO != null){
				Map<String, String> mapVO = terminalDepartureReportCondVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TerminalDepartureReportDBDAOMisHandleContainerVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, TdrCntrDetailVO.class);
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
	 * [TDR Slot Bsa] 정보를 [조회] 합니다.<br>
	 * 
	 * @param TerminalDepartureReportCondVO terminalDepartureReportCondVO
	 * @return List<TdrAllocationBSAVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked") 
	public List<TdrAllocationBSAVO> searchTdrSlotBSAList(TerminalDepartureReportCondVO terminalDepartureReportCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<TdrAllocationBSAVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(terminalDepartureReportCondVO != null){
				Map<String, String> mapVO = terminalDepartureReportCondVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TerminalDepartureReportDBDAOTdrAllocationBSAVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, TdrAllocationBSAVO.class);
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
	 * [TDR Slot Allocation] 정보를 [조회] 합니다.<br>
	 * 
	 * @param TdrAllocationVO tdrAllocationVO
	 * @return boolean
	 * @throws DAOException
	 */
	public boolean searchTdrAllocationList(TdrAllocationVO tdrAllocationVO) throws DAOException {
			DBRowSet dbRowset = null;
			boolean exsits = false;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(tdrAllocationVO != null){
					Map<String, String> mapVO = tdrAllocationVO.getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TerminalDepartureReportDBDAOTdrAllocationVORSQL(), param, velParam);
				if(dbRowset.next())
					exsits = true;
			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return exsits;
	}

	/**
	 * [BSA Import] 정보를 [조회] 합니다.<br>
	 * 
	 * @param TerminalDepartureReportCondVO terminalDepartureReportCondVO
	 * @return List<TdrAllocationBSAVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked") 
	public List<TdrAllocationBSAVO> searchTdrSlotBSAImportList(TerminalDepartureReportCondVO terminalDepartureReportCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<TdrAllocationBSAVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(terminalDepartureReportCondVO != null){
				Map<String, String> mapVO = terminalDepartureReportCondVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TerminalDepartureReportDBDAOBsaSlotSwapVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, TdrAllocationBSAVO.class);
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
	 * [TDR Slot HC45'] 정보를 [조회] 합니다.<br>
	 * 
	 * @param TerminalDepartureReportCondVO terminalDepartureReportCondVO
	 * @return List<TdrSlotHC45VO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked") 
	public List<TdrSlotHC45VO> searchTdrSlotHC45List(TerminalDepartureReportCondVO terminalDepartureReportCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<TdrSlotHC45VO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(terminalDepartureReportCondVO != null){
				Map<String, String> mapVO = terminalDepartureReportCondVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TerminalDepartureReportDBDAOTdrSlotHC45VORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, TdrSlotHC45VO.class);
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
	 * [BSA Slot HC45'] 정보를 [조회] 합니다.<br>
	 * 
	 * @param TerminalDepartureReportCondVO terminalDepartureReportCondVO
	 * @return List<TdrSlotHC45VO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked") 
	public List<TdrSlotHC45VO> searchTdrSlotHC45ImportList(TerminalDepartureReportCondVO terminalDepartureReportCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<TdrSlotHC45VO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(terminalDepartureReportCondVO != null){
				Map<String, String> mapVO = terminalDepartureReportCondVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TerminalDepartureReportDBDAOHc45DepImpVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, TdrSlotHC45VO.class);
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
	 * [TDR Load] 정보를 [조회] 합니다.<br>
	 * 
	 * @param TerminalDepartureReportCondVO terminalDepartureReportCondVO
	 * @return List<TdrUtilizeSlotPortVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked") 
	public List<TdrUtilizeSlotPortVO> searchTdrSlotPortImpList(TerminalDepartureReportCondVO terminalDepartureReportCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<TdrUtilizeSlotPortVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(terminalDepartureReportCondVO != null){
				Map<String, String> mapVO = terminalDepartureReportCondVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TerminalDepartureReportDBDAOSlotPortImpVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, TdrUtilizeSlotPortVO.class);
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
	 * [TDR Slot Dep] 정보를 [조회] 합니다.<br>
	 * 
	 * @param TerminalDepartureReportCondVO terminalDepartureReportCondVO
	 * @return List<TdrUtilizeSlotPortVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked") 
	public List<TdrUtilizeSlotPortVO> searchTdrSlotDepList(TerminalDepartureReportCondVO terminalDepartureReportCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<TdrUtilizeSlotPortVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(terminalDepartureReportCondVO != null){
				Map<String, String> mapVO = terminalDepartureReportCondVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TerminalDepartureReportDBDAOTdrUtilizeSlotDepVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, TdrUtilizeSlotPortVO.class);
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
	 * [TDR Slot Port] 정보를 [조회] 합니다.<br>
	 * 
	 * @param TerminalDepartureReportCondVO terminalDepartureReportCondVO
	 * @return List<TdrUtilizeSlotPortVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked") 
	public List<TdrUtilizeSlotPortVO> searchTdrSlotPortList(TerminalDepartureReportCondVO terminalDepartureReportCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<TdrUtilizeSlotPortVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(terminalDepartureReportCondVO != null){
				Map<String, String> mapVO = terminalDepartureReportCondVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TerminalDepartureReportDBDAOTdrUtilizeSlotPortVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, TdrUtilizeSlotPortVO.class);
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
	 * [TDR BSA] 정보를 [조회] 합니다.<br>
	 * 
	 * @param TerminalDepartureReportCondVO terminalDepartureReportCondVO
	 * @return List<TdrAllocationBSAVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked") 
	public List<TdrUtilizeSlotPortVO> searchTdrSlotDepImportList(TerminalDepartureReportCondVO terminalDepartureReportCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<TdrUtilizeSlotPortVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(terminalDepartureReportCondVO != null){
				Map<String, String> mapVO = terminalDepartureReportCondVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TerminalDepartureReportDBDAOTdrAllocationImportVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, TdrUtilizeSlotPortVO.class);
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
	 * [TDR TempStwg.] 정보를 [조회] 합니다.<br>
	 * 
	 * @param TerminalDepartureReportCondVO terminalDepartureReportCondVO
	 * @return List<TdrCntrDetailVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked") 
	public List<TdrCntrDetailVO> searchTdrTmpStwgList(TerminalDepartureReportCondVO terminalDepartureReportCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<TdrCntrDetailVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(terminalDepartureReportCondVO != null){
				Map<String, String> mapVO = terminalDepartureReportCondVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TerminalDepartureReportDBDAOTdrCntrDetailTmpStwgVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, TdrCntrDetailVO.class);
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
	 * [TDR ReHandle Code] 정보를 [조회] 합니다.<br>
	 * 
	 * @param OpfRstwgRsnCdVO opfRstwgRsnCdVO
	 * @return List<OpfRstwgRsnCdVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked") 
	public List<OpfRstwgRsnCdVO> searchTdrRHReasonCdList(OpfRstwgRsnCdVO opfRstwgRsnCdVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<OpfRstwgRsnCdVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(opfRstwgRsnCdVO != null){
					Map<String, String> mapVO = opfRstwgRsnCdVO.getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TerminalDepartureReportDBDAOOpfRstwgRsnCdVoRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, OpfRstwgRsnCdVO.class);
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
	 * [TDR Exclude Tpr] 정보를 [조회] 합니다.<br>
	 * 
	 * @param TerminalDepartureReportCondVO terminalDepartureReportCondVO
	 * @return List<OpfTmlProdRptRsnCdVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked") 
	public List<OpfTmlProdRptRsnCdVO> searchExcludeTpr(TerminalDepartureReportCondVO terminalDepartureReportCondVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<OpfTmlProdRptRsnCdVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(terminalDepartureReportCondVO != null){
					Map<String, String> mapVO = terminalDepartureReportCondVO.getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TerminalDepartureReportDBDAOOpfTmlProdRptRsnCdRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, OpfTmlProdRptRsnCdVO.class);
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
	 *  TERMINAL DEPARTURE REPORT HEADER를 생성 합니다. <br>
	 * 
	 * @param List<TdrHeaderVO> tdrHeaderVOs
	 * @throws DAOException
	 */
	public void addTdrS(List<TdrHeaderVO> tdrHeaderVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(tdrHeaderVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new TerminalDepartureReportDBDAOTdrHeaderVOCSQL(), tdrHeaderVOs, null);
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
	 *  TERMINAL DEPARTURE REPORT HEADER를 수정 합니다. <br>
	 * 
	 * @param List<TdrHeaderVO> tdrHeaderVOs
	 * @throws DAOException
	 */
	public void modifyTdrS(List<TdrHeaderVO> tdrHeaderVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(tdrHeaderVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new TerminalDepartureReportDBDAOTdrHeaderVOUSQL(), tdrHeaderVOs, null);
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
	 *  TERMINAL DEPARTURE REPORT CRANE를 생성 합니다. <br>
	 * 
	 * @param List<TdrCraneVO> tdrCraneVOs
	 * @throws DAOException
	 */
	public void addTdrCaneS(List<TdrCraneVO> tdrCraneVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(tdrCraneVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new TerminalDepartureReportDBDAOTdrCraneVOCSQL(), tdrCraneVOs, null);
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
	 *  TERMINAL DEPARTURE REPORT CRANE를 삭제 합니다. <br>
	 * 
	 * @param List<TdrCraneVO> tdrCraneVOs
	 * @throws DAOException
	 */
	public void deleteTdrCraneS(List<TdrCraneVO> tdrCraneVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(tdrCraneVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new TerminalDepartureReportDBDAOTdrCraneVODSQL(), tdrCraneVOs, null);
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
	 *  TERMINAL DEPARTURE REPORT SUMMARY를 생성 합니다. <br>
	 * 
	 * @param List<TdrSummaryVO> tdrSummaryVOs
	 * @throws DAOException
	 */
	public void addTdrSummaryS(List<TdrSummaryVO> tdrSummaryVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(tdrSummaryVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new TerminalDepartureReportDBDAOTdrSummaryVOCSQL(), tdrSummaryVOs, null);
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
     *  TERMINAL DEPARTURE REPORT SUMMARY(Load SG)를 삭제 합니다. <br>
     * 
     * @param List<TdrSummaryVO> tdrSummaryVOs
     * @throws DAOException
     */
    public void deleteTdrSummaryLoadSG(List<TdrSummaryVO> tdrSummaryVOs) throws DAOException,Exception {
        try {
            SQLExecuter sqlExe = new SQLExecuter("");
            int delCnt[] = null;
            if(tdrSummaryVOs.size() > 0){
                delCnt = sqlExe.executeBatch((ISQLTemplate)new TerminalDepartureReportDBDAOremoveTdrLoadSGDSQL(), tdrSummaryVOs, null);
                for(int i = 0; i < delCnt.length; i++){
                    if(delCnt[i]== Statement.EXECUTE_FAILED)
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
     *  TERMINAL DEPARTURE REPORT SUMMARY(Disch SG)를 삭제 합니다. <br>
     * 
     * @param List<TdrSummaryVO> tdrSummaryVOs
     * @throws DAOException
     */
    public void deleteTdrSummaryDischSG(List<TdrSummaryVO> tdrSummaryVOs) throws DAOException,Exception {
        try {
            SQLExecuter sqlExe = new SQLExecuter("");
            int delCnt[] = null;
            if(tdrSummaryVOs.size() > 0){
                delCnt = sqlExe.executeBatch((ISQLTemplate)new TerminalDepartureReportDBDAOdeleteTdrSummaryDischSGDSQL(), tdrSummaryVOs, null);
                for(int i = 0; i < delCnt.length; i++){
                    if(delCnt[i]== Statement.EXECUTE_FAILED)
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
     *  TERMINAL DEPARTURE REPORT SUMMARY(Disch Total)를 삭제 합니다. <br>
     * 
     * @param List<TdrSummaryVO> tdrSummaryVOs
     * @throws DAOException
     */
    public void deleteTdrSummaryDisTotal(List<TdrSummaryVO> tdrSummaryVOs) throws DAOException,Exception {
        try {
            SQLExecuter sqlExe = new SQLExecuter("");
            int delCnt[] = null;
            if(tdrSummaryVOs.size() > 0){
                delCnt = sqlExe.executeBatch((ISQLTemplate)new TerminalDepartureReportDBDAOremoveTdrDischTotalDSQL(), tdrSummaryVOs, null);
                for(int i = 0; i < delCnt.length; i++){
                    if(delCnt[i]== Statement.EXECUTE_FAILED)
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
	 *  TERMINAL DEPARTURE REPORT SUMMARY를 삭제 합니다. <br>
	 * 
	 * @param List<TdrSummaryVO> tdrSummaryVOs
	 * @throws DAOException
	 */
	public void deleteTdrSummaryTotalS(List<TdrSummaryVO> tdrSummaryVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(tdrSummaryVOs.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new TerminalDepartureReportDBDAOTdrSummaryTotalDSQL(), tdrSummaryVOs, null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
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
	 *  TERMINAL DEPARTURE REPORT SUMMARY를 삭제 합니다. <br>
	 * 
	 * @param List<TdrSummaryVO> tdrSummaryVOs
	 * @throws DAOException
	 */
	public void deleteTdrSummarySGS(List<TdrSummaryVO> tdrSummaryVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(tdrSummaryVOs.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new TerminalDepartureReportDBDAOTdrSummarySGDSQL(), tdrSummaryVOs, null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
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
	 *  TERMINAL DEPARTURE REPORT CNTR를 삭제 합니다. <br>
	 * 
	 * @param TdrCntrDetailVO tdrCntrDetailVO
	 * @throws DAOException
	 */
	public void removeTdrCntrDetailRH(TdrCntrDetailVO tdrCntrDetailVO) throws DAOException,Exception {
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try {
			SQLExecuter sqlExe 		= new SQLExecuter("");
			
			if(tdrCntrDetailVO != null){
				
				Map<String, String> mapVO = tdrCntrDetailVO.getColumnValues();
				
				param.putAll	(mapVO);
				
				int result = sqlExe.executeUpdate((ISQLTemplate)new TerminalDepartureReportDBDAOTdrCntrDetailRHDSQL(), mapVO, null);
					
				if(result == Statement.EXECUTE_FAILED) {
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
	 *  TERMINAL DEPARTURE REPORT CNTR를 생성 합니다. <br>
	 * 
	 * @param List<TdrCntrDetailVO> tdrCntrDetailVOs
	 * @throws DAOException
	 */
//	public void saveTdrCntrS(List<TdrCntrDetailVO> tdrCntrDetailVOs) throws DAOException,Exception {
//		try {
//			SQLExecuter sqlExe = new SQLExecuter("");
//			int insCnt[] = null;
//			if(tdrCntrDetailVOs.size() > 0){
//				insCnt = sqlExe.executeBatch((ISQLTemplate)new TerminalDepartureReportDBDAOTdrCntrDetailRHCSQL(), tdrCntrDetailVOs, null);
//				for(int i = 0; i < insCnt.length; i++){
//					if(insCnt[i]== Statement.EXECUTE_FAILED)
//						throw new DAOException("Fail to insert No"+ i + " SQL");
//				}
//			}
//		} catch (SQLException se) {
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		}catch(Exception ex){
//			log.error(ex.getMessage(),ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage());
//		}
//	}
	
	/**
	 *  TERMINAL DEPARTURE REPORT CNTR를 생성 합니다. <br>
	 * 
	 * @param List<TdrCntrDetailVO> tdrCntrDetailVOs
	 * @throws DAOException
	 */
	public void addTdrCntrS(List<TdrCntrDetailVO> tdrCntrDetailVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(tdrCntrDetailVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new TerminalDepartureReportDBDAOTdrCntrDetailVOCSQL(), tdrCntrDetailVOs, null);
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
	 *  TERMINAL DEPARTURE REPORT CNTR를 수정 합니다. <br>
	 * 
	 * @param List<TdrCntrDetailVO> tdrCntrDetailVOs
	 * @throws DAOException
	 */
	public void modifyTdrCntrS(List<TdrCntrDetailVO> tdrCntrDetailVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(tdrCntrDetailVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new TerminalDepartureReportDBDAOTdrCntrDetailVOUSQL(), tdrCntrDetailVOs, null);
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
	 *  TERMINAL DEPARTURE REPORT CNTR를 삭제 합니다. <br>
	 * 
	 * @param List<TdrCntrDetailVO> tdrCntrDetailVOs
	 * @throws DAOException
	 */
	public void removeTdrCntrS(List<TdrCntrDetailVO> tdrCntrDetailVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(tdrCntrDetailVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new TerminalDepartureReportDBDAOTdrCntrDetailVODSQL(), tdrCntrDetailVOs, null);
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
	 *  TERMINAL DEPARTURE REPORT CNTR Break Bulk를 삭제 합니다. <br>
	 * 
	 * @param List<TdrCntrDetailVO> tdrCntrDetailVOs
	 * @throws DAOException
	 */
	public void removeTdrCntrBreakS(List<TdrCntrDetailVO> tdrCntrDetailVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(tdrCntrDetailVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new TerminalDepartureReportDBDAOTdrCntrDetailBreakVODSQL(), tdrCntrDetailVOs, null);
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
	 *  TERMINAL DEPARTURE REPORT ALLOCATION를 생성 합니다. <br>
	 * 
	 * @param List<TdrAllocationVO> tdrAllocationVOs
	 * @throws DAOException
	 */
	public void addTdrSlotBSAS(List<TdrAllocationVO> tdrAllocationVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(tdrAllocationVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new TerminalDepartureReportDBDAOTdrAllocationVOCSQL(), tdrAllocationVOs, null);
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
	 *  TERMINAL DEPARTURE REPORT ALLOCATION를 수정 합니다. <br>
	 * 
	 * @param List<TdrAllocationVO> tdrAllocationVOs
	 * @throws DAOException
	 */
	public void modifyTdrSlotBSAS(List<TdrAllocationVO> tdrAllocationVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(tdrAllocationVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new TerminalDepartureReportDBDAOTdrAllocationVOUSQL(), tdrAllocationVOs, null);
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
	 *  TERMINAL DEPARTURE REPORT ALLOCATION를 삭제 합니다. <br>
	 * 
	 * @param List<TdrAllocationVO> tdrAllocationVOs
	 * @throws DAOException
	 */
	public void removeTdrSlotBSAS(List<TdrAllocationVO> tdrAllocationVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(tdrAllocationVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new TerminalDepartureReportDBDAOTdrAllocationVODSQL(), tdrAllocationVOs, null);
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
	 *  TERMINAL DEPARTURE REPORT UTILIZE를 생성 합니다. <br>
	 * 
	 * @param List<TdrUtilizeVO> tdrUtilizeVOs
	 * @throws DAOException
	 */
	public void addTdrSlotUtilizeS(List<TdrUtilizeVO> tdrUtilizeVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(tdrUtilizeVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new TerminalDepartureReportDBDAOTdrUtilizePortVOCSQL(), tdrUtilizeVOs, null);
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
	 *  TERMINAL DEPARTURE REPORT UTILIZE를 수정 합니다. <br>
	 * 
	 * @param List<TdrUtilizeVO> tdrUtilizeVOs
	 * @throws DAOException
	 */
	public void modifyTdrSlotUtilizeS(List<TdrUtilizeVO> tdrUtilizeVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(tdrUtilizeVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new TerminalDepartureReportDBDAOTdrUtilizePortVOUSQL(), tdrUtilizeVOs, null);
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
	 *  TERMINAL DEPARTURE REPORT UTILIZE를 삭제 합니다. <br>
	 * 
	 * @param List<TdrUtilizeVO> tdrUtilizeVOs
	 * @throws DAOException
	 */
	public void removeTdrSlotHC45UtilizeS(List<TdrUtilizeVO> tdrUtilizeVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(tdrUtilizeVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new TerminalDepartureReportDBDAOTdrHC45UtilizeVODSQL(), tdrUtilizeVOs, null);
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
	 *  TERMINAL DEPARTURE REPORT UTILIZE를 삭제 합니다. <br>
	 * 
	 * @param List<TdrUtilizeVO> tdrUtilizeVOs
	 * @throws DAOException
	 */
	public void removeTdrSlotPortUtilizeS(List<TdrUtilizeVO> tdrUtilizeVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(tdrUtilizeVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new TerminalDepartureReportDBDAOTdrPortUtilizeVODSQL(), tdrUtilizeVOs, null);
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
	 *  TERMINAL DEPARTURE REPORT BSA를 생성 합니다. <br>
	 * 
	 * @param List<TdrBsaVO> tdrBsaVOs
	 * @throws DAOException
	 */
	public void addTdrBsaS(List<TdrBsaVO> tdrBsaVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(tdrBsaVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new TerminalDepartureReportDBDAOTdrBsaVOCSQL(), tdrBsaVOs, null);
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
	 *  TERMINAL DEPARTURE REPORT BSA를 수정 합니다. <br>
	 * 
	 * @param List<TdrBsaVO> tdrBsaVOs
	 * @throws DAOException
	 */
	public void modifyTdrBsaS(List<TdrBsaVO> tdrBsaVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(tdrBsaVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new TerminalDepartureReportDBDAOTdrBsaVODSQL(), tdrBsaVOs, null);
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
	 *  TERMINAL DEPARTURE REPORT BSA를 삭제 합니다. <br>
	 * 
	 * @param List<TdrBsaVO> tdrBsaVOs
	 * @throws DAOException
	 */
	public void removeTdrBsaS(List<TdrBsaVO> tdrBsaVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(tdrBsaVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new TerminalDepartureReportDBDAOTdrBsaVODSQL(), tdrBsaVOs, null);
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
	 *  TERMINAL DEPARTURE REPORT를 전체 삭제 합니다. <br>
	 * 
	 * @param List<TdrHeaderVO> tdrHeaderVOs
	 * @throws DAOException
	 */
	public void removeTdrAll(List<TdrHeaderVO> tdrHeaderVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(tdrHeaderVOs.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new TerminalDepartureReportDBDAOTdrUtilizePortVODSQL(), tdrHeaderVOs, null);
				if(delCnt[0]== Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to Delete No SQL");

				delCnt = sqlExe.executeBatch((ISQLTemplate)new TerminalDepartureReportDBDAOTdrBsaVODSQL(), tdrHeaderVOs, null);
				if(delCnt[0]== Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to Delete No SQL");
				
				delCnt = sqlExe.executeBatch((ISQLTemplate)new TerminalDepartureReportDBDAOTdrSummaryPortVODSQL(), tdrHeaderVOs, null);
				if(delCnt[0]== Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to Delete No SQL");
				
				delCnt = sqlExe.executeBatch((ISQLTemplate)new TerminalDepartureReportDBDAOTdrCranePortVODSQL(), tdrHeaderVOs, null);
				if(delCnt[0]== Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to Delete No SQL");
				
				delCnt = sqlExe.executeBatch((ISQLTemplate)new TerminalDepartureReportDBDAOTdrCntrDetailPortVODSQL(), tdrHeaderVOs, null);
				if(delCnt[0]== Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to Delete No SQL");
				
				delCnt = sqlExe.executeBatch((ISQLTemplate)new TerminalDepartureReportDBDAOTdrAllocationPortVODSQL(), tdrHeaderVOs, null);
				if(delCnt[0]== Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to Delete No SQL");
				/*2010.03.29 Write by jkc*/
                delCnt = sqlExe.executeBatch((ISQLTemplate)new TerminalDepartureReportDBDAORemoveOpfTmlDepRptDtlVODSQL(), tdrHeaderVOs, null);
                if(delCnt[0]== Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to Delete No SQL");
 		
				delCnt = sqlExe.executeBatch((ISQLTemplate)new TerminalDepartureReportDBDAOTdrHeaderPortVODSQL(), tdrHeaderVOs, null);
				if(delCnt[0]== Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to Delete No SQL");
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
	 * [Exclude Tpr] 정보를 [조회] 합니다.<br>
	 * 
	 * @param OpfTmlDepRptDtlVO opfRstwgRsnCdVO
	 * @return boolean
	 * @throws DAOException
	 */
	public boolean existsExcludeTpr(OpfTmlDepRptDtlVO opfRstwgRsnCdVO) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		boolean rtnExists = false;
		try {
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			//먼저 있는지여부 체크...

			if(opfRstwgRsnCdVO != null){
				Map<String, String> mapVO = opfRstwgRsnCdVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TerminalDepartureReportDBDAOOpfTmlDepRptDtlVORSQL(), param, velParam);
			
			if(dbRowset.next())
				rtnExists = true;
			else
				rtnExists = false;
		} catch (SQLException se) {
			rtnExists = false;
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			rtnExists = false;
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return rtnExists;
	}

	/**
	 * Exclude Tpr를 생성 합니다. <br>
	 * 
	 * @param OpfTmlDepRptDtlVO opfTmlDepRptDtlVO
	 * @throws DAOException
	 */
	public void addExcludeTpr(OpfTmlDepRptDtlVO opfTmlDepRptDtlVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, String> mapVO = opfTmlDepRptDtlVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			int result = sqlExe.executeUpdate((ISQLTemplate)new TerminalDepartureReportDBDAOOpfTmlDepRptDtlVOCSQL(), mapVO, velParam);
				
			if(result == Statement.EXECUTE_FAILED) {
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
	 * Exclude Tpr를 수정 합니다. <br>
	 * 
	 * @param OpfTmlDepRptDtlVO opfTmlDepRptDtlVO
	 * @throws DAOException
	 */
	public void modifyExcludeTpr(OpfTmlDepRptDtlVO opfTmlDepRptDtlVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, String> mapVO = opfTmlDepRptDtlVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			int result = sqlExe.executeUpdate((ISQLTemplate)new TerminalDepartureReportDBDAOOpfTmlDepRptDtlVOUSQL(), mapVO, velParam);
				
			if(result == Statement.EXECUTE_FAILED) {
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
	 * Exclude Tpr를 삭제 합니다. <br>
	 * 
	 * @param OpfTmlDepRptDtlVO opfTmlDepRptDtlVO
	 * @throws DAOException
	 */
	public void removeExcludeTpr(OpfTmlDepRptDtlVO opfTmlDepRptDtlVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, String> mapVO = opfTmlDepRptDtlVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			int result = sqlExe.executeUpdate((ISQLTemplate)new TerminalDepartureReportDBDAOOpfTmlDepRptDtlVODSQL(), mapVO, velParam);
				
			if(result == Statement.EXECUTE_FAILED) {
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
	 *  Cargo Handling Performance 을 조회 합니다.<br>
	 * 
	 * @param TerminalDepartureReportConditionVO terminalDepartureReportConditionVO
	 * @return List<CgoHndPerformInputVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CgoHndPerformInputVO> searchCgoHndPerformList(TerminalDepartureReportConditionVO terminalDepartureReportConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CgoHndPerformInputVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(terminalDepartureReportConditionVO != null){
				Map<String, String> mapVO = terminalDepartureReportConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TerminalDepartureReportDBDAOCgoHndPerformInputVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CgoHndPerformInputVO .class);
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
	 * 조회조건에 Port Code 유효성(체크) 을 조회 합니다.<br>
	 * 
	 * @param TerminalDepartureReportConditionVO terminalDepartureReportConditionVO
	 * @return List<MdmYardVO> 
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<MdmYardVO> searchMdmYardCombo(TerminalDepartureReportConditionVO terminalDepartureReportConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MdmYardVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(terminalDepartureReportConditionVO != null){
				Map<String, String> mapVO = terminalDepartureReportConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TerminalDepartureReportDBDAOMdmYardVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MdmYardVO .class);
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
	 *  Cargo Re-Handling Performance 을 조회 합니다.<br>
	 * 
	 * @param TerminalDepartureReportConditionVO terminalDepartureReportConditionVO
	 * @return List<CgoRhndPerformInputVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CgoRhndPerformInputVO> searchCgoRhndPerformList(TerminalDepartureReportConditionVO terminalDepartureReportConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CgoRhndPerformInputVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(terminalDepartureReportConditionVO != null){
				Map<String, String> mapVO = terminalDepartureReportConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				ArrayList<String> restowReasonList = new ArrayList<String>(Arrays.asList(terminalDepartureReportConditionVO.getRestowReasonList().split(",")));
				velParam.put("restow_reason_list", restowReasonList);
				
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TerminalDepartureReportDBDAOCgoRhndPerformInputVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CgoRhndPerformInputVO .class);
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
		 *  Cargo Re-Handling Performance 을 조회 합니다.<br>
		 * 
		 * @param TerminalDepartureReportConditionVO terminalDepartureReportConditionVO
		 * @return List<CgoRhndPerformInputVO>
		 * @throws DAOException
		 */
		 @SuppressWarnings("unchecked")
		public List<CgoRhndPerformInputVO> searchRestowReasonList(TerminalDepartureReportConditionVO terminalDepartureReportConditionVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<CgoRhndPerformInputVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(terminalDepartureReportConditionVO != null){
					Map<String, String> mapVO = terminalDepartureReportConditionVO .getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TerminalDepartureReportDBDAOCgoRhndPerformInputRestowReasonCodeListRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, CgoRhndPerformInputVO .class);
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
	 *  VSL Condition Statistics 을 조회 합니다.<br>
	 * 
	 * @param TerminalDepartureReportConditionVO terminalDepartureReportConditionVO
	 * @return List<TdrListOptionVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<TdrListOptionVO> searchVslConditionList(TerminalDepartureReportConditionVO terminalDepartureReportConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<TdrListOptionVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(terminalDepartureReportConditionVO != null){
				Map<String, String> mapVO = terminalDepartureReportConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TerminalDepartureReportDBDAOTdrListOptionVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, TdrListOptionVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	 
//	/**
//	 *  Terminal Performance - Port 을 조회 합니다.<br>
//	 * 
//	 * @param TerminalDepartureReportConditionVO terminalDepartureReportConditionVO
//	 * @return List<TmnlPerformInputVO>
//	 * @throws DAOException
//	 */
//	 @SuppressWarnings("unchecked")
//	public List<TmnlPerformInputVO> searchTmnlPerformPortList(TerminalDepartureReportConditionVO terminalDepartureReportConditionVO) throws DAOException {
//		DBRowSet dbRowset = null;
//		List<TmnlPerformInputVO> list = null;
//		//query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
//		//velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();
//
//		try{
//			if(terminalDepartureReportConditionVO != null){
//				Map<String, String> mapVO = terminalDepartureReportConditionVO .getColumnValues();
//			
//				param.putAll(mapVO);
//				velParam.putAll(mapVO);
//			}
//			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TerminalDepartureReportDBDAOTmnlPerformInputPortRSQL(), param, velParam);
//			list = (List)RowSetUtil.rowSetToVOs(dbRowset, TmnlPerformInputVO .class);
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
	 *  Terminal Performance - Lane 을 조회 합니다.<br>
	 * 
	 * @param TerminalDepartureReportConditionVO terminalDepartureReportConditionVO
	 * @return List<TmnlPerformInputVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<TmnlPerformInputVO> searchTmnlPerformLaneList(TerminalDepartureReportConditionVO terminalDepartureReportConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<TmnlPerformInputVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(terminalDepartureReportConditionVO != null){
				Map<String, String> mapVO = terminalDepartureReportConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TerminalDepartureReportDBDAOTmnlPerformInputLaneRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, TmnlPerformInputVO .class);
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
	 *  Terminal Productivity Report 의 By Lane 조회 합니다.<br>
	 * 
	 * @param TerminalDepartureReportConditionVO terminalDepartureReportConditionVO
	 * @return List<TmnlPerformVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<TmnlPerformVO> searchTmnlProdList(TerminalDepartureReportConditionVO terminalDepartureReportConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<TmnlPerformVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(terminalDepartureReportConditionVO != null){
				Map<String, String> mapVO = terminalDepartureReportConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TerminalDepartureReportDBDAOTmnlPerformVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, TmnlPerformVO .class);
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
	 *  Terminal Productivity Report 의 By Month 조회 합니다.<br>
	 * 
	 * @param TerminalDepartureReportConditionVO terminalDepartureReportConditionVO
	 * @return List<TmnlPerformVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<TmnlPerformVO> searchTmnlProdMonthList(TerminalDepartureReportConditionVO terminalDepartureReportConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<TmnlPerformVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(terminalDepartureReportConditionVO != null){
				Map<String, String> mapVO = terminalDepartureReportConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TerminalDepartureReportDBDAOTmnlPerformMonthVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, TmnlPerformVO .class);
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
	 * 조회조건에 Port Code 유효성(체크) 을 조회 합니다.<br>
	 * 
	 * @param TerminalDepartureReportConditionVO terminalDepartureReportConditionVO
	 * @return List<MdmRhqComboVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<MdmRhqComboVO> searchMdmRhqCombo(TerminalDepartureReportConditionVO terminalDepartureReportConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MdmRhqComboVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(terminalDepartureReportConditionVO != null){
				Map<String, String> mapVO = terminalDepartureReportConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TerminalDepartureReportDBDAOMdmRhqComboRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MdmRhqComboVO .class);
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
	 *  TDR Details 의 By Lane 조회 합니다.<br>
	 * 
	 * @param TerminalDepartureReportConditionVO terminalDepartureReportConditionVO
	 * @return List<TerminalDepartureReportVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<TerminalDepartureReportVO> searchTdrDetailList(TerminalDepartureReportConditionVO terminalDepartureReportConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<TerminalDepartureReportVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(terminalDepartureReportConditionVO != null){
				Map<String, String> mapVO = terminalDepartureReportConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TerminalDepartureReportDBDAOTerminalDepartureReportVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, TerminalDepartureReportVO .class);
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
	 *  TDR Details 의 By Month 조회 합니다.<br>
	 * 
	 * @param TerminalDepartureReportConditionVO terminalDepartureReportConditionVO
	 * @return List<TerminalDepartureReportVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<TerminalDepartureReportVO> searchTdrDetailMonthList(TerminalDepartureReportConditionVO terminalDepartureReportConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<TerminalDepartureReportVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(terminalDepartureReportConditionVO != null){
				Map<String, String> mapVO = terminalDepartureReportConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TerminalDepartureReportDBDAOTerminalDepartureReportMonthVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, TerminalDepartureReportVO .class);
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
     * TDR Header 의 Total Container Handling Moves 수정한다. <br>
     * 
     * @param TdrHeaderVO tdrHeaderVO
     * @throws DAOException
     */
    public void modifyTdrHeaderMvs(TdrHeaderVO tdrHeaderVO) throws DAOException,Exception {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            SQLExecuter sqlExe = new SQLExecuter("");
            Map<String, String> mapVO = tdrHeaderVO.getColumnValues();
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            int result = sqlExe.executeUpdate((ISQLTemplate)new TerminalDepartureReportDBDAOmodifyTdrHeaderMvsUSQL(), mapVO, velParam);
                
            if(result == Statement.EXECUTE_FAILED) {
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
     *  Tot Moves 값을 구해 Header 에 Update<br>
     * 
     * @param  TerminalDepartureReportConditionVO terminalDepartureReportConditionVO
     * @return List<TerminalDepartureReportVO>
     * @throws DAOException
     */
    public List<TerminalDepartureReportVO> searchTotMoveData(TerminalDepartureReportConditionVO terminalDepartureReportConditionVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<TerminalDepartureReportVO> list = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            if(terminalDepartureReportConditionVO != null){
                Map<String, String> mapVO = terminalDepartureReportConditionVO .getColumnValues();
            
                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TerminalDepartureReportDBDAOsearchTotMoveDataRSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, TerminalDepartureReportVO .class);
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
     * VOP_OPF_0095 화면에서 조회시 호출하는 메쏘드
     * Missing TDR 조회
     * @param MissingTDRCondVO missingTDRCondVO
     * @return List<MissingTDRVO>
     * @throws DAOException
     */
	public List<MissingTDRVO> searchMissingTDRList(MissingTDRCondVO missingTDRCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MissingTDRVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(missingTDRCondVO != null){
				Map<String, String> mapVO = missingTDRCondVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TerminalDepartureReportDBDAOMissingTDRVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MissingTDRVO.class);
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
     * VOP_OPF_0095 화면에서 Port Code 변경시 Validation Check & RHQ_OFC_CD를 조회한다.
     * @param MissingTDRCondVO missingTDRCondVO
     * @return List<MissingTDRVO>
     * @throws DAOException
     */
	public List<MissingTDRVO> searchPortCodeNRhqOfcCdList(MissingTDRCondVO missingTDRCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MissingTDRVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(missingTDRCondVO != null){
				Map<String, String> mapVO = missingTDRCondVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TerminalDepartureReportDBDAOPortCdValidChkRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MissingTDRVO.class);
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
	 * Get Receiver Email Address
	 * 
	 * @param String vslCd
	 * @param String skdVoyNo
	 * @param String skdDirCd
	 * @param String portCd
	 * @param String spclCgoCateCd
	 * @return String
	 * @exception DAOException
	 * @author kjh
	 */
	public String searchReceiver(String vslCd, String skdVoyNo, String skdDirCd, String portCd, String spclCgoCateCd) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnVal = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			
				param.put("vsl_cd", vslCd);
				param.put("voy_no", skdVoyNo);
				param.put("dir_cd", skdDirCd);
				param.put("port_cd", portCd);
				param.put("spcl_cgo_cate_cd", spclCgoCateCd);
				
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TerminalDepartureReportDBDAOSearchReceiverInfoRSQL(), param, velParam);
			if(dbRowset != null){
				if(dbRowset.next()){
					rtnVal = dbRowset.getString("CNTC_PSON_EML_CTNT");
				}
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return rtnVal;
	}
	
}