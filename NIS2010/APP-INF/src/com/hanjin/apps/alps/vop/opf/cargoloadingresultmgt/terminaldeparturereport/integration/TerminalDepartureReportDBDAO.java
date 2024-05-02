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
* 
* History
* 2015.03.27 이병훈 [CHM-201534804] VNOR Report 신규화면 개발
* 2015.04.21 이병훈 [CHM-201535480] VNOR Report Creation 화면 기능 개선(Remark Submit)
* 2015.05.22 이병훈 [CHM-201535464] VNOR Report Summary Inquiry 개발
=========================================================*/
package com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.basic.TerminalDepartureReportBCImpl;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.CgoHndPerformInputVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.CgoRhndPerformInputVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.DischVolSGTdrVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.FleetStatusVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.MdmRhqComboVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.MissingTDRCondVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.MissingTDRVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.OpfTdrAtchFileVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.OpfTmlProdRptRsnCdVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.OpfVnorAtchFileVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.OpfVnorSummaryVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.PortLogDetailVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.PortLogHeadVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.RHContainerVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.TdrAllocationBSAVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.TdrBsaVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.TdrDistLoadVolVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.TdrHeaderSkdVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.TdrListOptionVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.TdrSlotHC45VO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.TdrUtilizeSlotPortVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.TdrUtilizeVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.TerminalDepartureReportCondVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.TerminalDepartureReportConditionVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.TerminalDepartureReportVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.TmnlPerformInputVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.TmnlPerformVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.VskVslPortSkdSheetVO;
import com.hanjin.apps.alps.vop.opf.opfcommon.opfutil.vo.ComComboVO;
import com.hanjin.apps.alps.vop.opf.opfcommon.opfutil.vo.OpfComboVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.MdmYardVO;
import com.hanjin.syscommon.common.table.OpfAtchFileVO;
import com.hanjin.syscommon.common.table.OpfRstwgRsnCdVO;
import com.hanjin.syscommon.common.table.OpfTmlDepRptDtlVO;
import com.hanjin.syscommon.common.table.OpfVnorEmlStupVO;
import com.hanjin.syscommon.common.table.OpfVnorItmVO;
import com.hanjin.syscommon.common.table.OpfVnorVO;
import com.hanjin.syscommon.common.table.TdrAllocationVO;
import com.hanjin.syscommon.common.table.TdrCntrDetailVO;
import com.hanjin.syscommon.common.table.TdrCraneVO;
import com.hanjin.syscommon.common.table.TdrHeaderVO;
import com.hanjin.syscommon.common.table.TdrSummaryVO;


/**
 * NIS2010 TerminalDepartureReportDBDAO <br>
 * - NIS2010-CargoLoadingResultMgt system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
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
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new TerminalDepartureReportDBDAOTdrHeaderSkdVORSQL(), param, velParam);
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
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new TerminalDepartureReportDBDAOPortLogHeadVORSQL(), param, velParam);
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
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new TerminalDepartureReportDBDAOPortLogDetailVORSQL(), param, velParam);
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
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new TerminalDepartureReportDBDAODischImportTotalVORSQL(), param, velParam);
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
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new TerminalDepartureReportDBDAODischVolTotalTdrVORSQL(), param, velParam);
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
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new TerminalDepartureReportDBDAODischImportSGVORSQL(), param, velParam);
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
			
			// Tdr을 ALPS에서 생성시에.. 
			if(!terminalDepartureReportCondVO.getSysCreate().equals("") && terminalDepartureReportCondVO.getSysCreate().substring(0, 2).toUpperCase().equals("IN")){
				dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new TerminalDepartureReportDBDAODischVolSGTdrSummaryVORSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, DischVolSGTdrVO.class);
			}else{
				dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new TerminalDepartureReportDBDAODischVolSGTdrVORSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, DischVolSGTdrVO.class);
			}
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
			
			// Tdr을 ALPS에서 생성시에.. 
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new TerminalDepartureReportDBDAOLoadVolSGTdrVORSQL(), param, velParam);
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
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new TerminalDepartureReportDBDAODischImportBreakVORSQL(), param, velParam);
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
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new TerminalDepartureReportDBDAOTdrCntrDetailBreakVORSQL(), param, velParam);
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
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new TerminalDepartureReportDBDAOLoadVolOceanTdrVORSQL(), param, velParam);
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
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new TerminalDepartureReportDBDAOLoadImportTotalVORSQL(), param, velParam);
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
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new TerminalDepartureReportDBDAOLoadImportSGVORSQL(), param, velParam);
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
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new TerminalDepartureReportDBDAOLoadImportBreakVORSQL(), param, velParam);
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
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new TerminalDepartureReportDBDAOCodContainerVORSQL(), param, velParam);
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
	 * @return List<RHContainerVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked") 
	public List<RHContainerVO> searchTdrRHList(TerminalDepartureReportCondVO terminalDepartureReportCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RHContainerVO> list = null;
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
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new TerminalDepartureReportDBDAORHContainerVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RHContainerVO.class);
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
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new TerminalDepartureReportDBDAOMisHandleContainerVORSQL(), param, velParam);
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
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new TerminalDepartureReportDBDAOTdrAllocationBSAVORSQL(), param, velParam);
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
				dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new TerminalDepartureReportDBDAOTdrAllocationVORSQL(), param, velParam);
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
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new TerminalDepartureReportDBDAOBsaSlotSwapVORSQL(), param, velParam);
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
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new TerminalDepartureReportDBDAOTdrSlotHC45VORSQL(), param, velParam);
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
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new TerminalDepartureReportDBDAOHc45DepImpVORSQL(), param, velParam);
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
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new TerminalDepartureReportDBDAOSlotPortImpVORSQL(), param, velParam);
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
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new TerminalDepartureReportDBDAOTdrUtilizeSlotDepVORSQL(), param, velParam);
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
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new TerminalDepartureReportDBDAOTdrUtilizeSlotPortVORSQL(), param, velParam);
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
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new TerminalDepartureReportDBDAOTdrAllocationImportVORSQL(), param, velParam);
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
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new TerminalDepartureReportDBDAOTdrCntrDetailTmpStwgVORSQL(), param, velParam);
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
				dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new TerminalDepartureReportDBDAOOpfRstwgRsnCdVoRSQL(), param, velParam);
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
				dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new TerminalDepartureReportDBDAOOpfTmlProdRptRsnCdRSQL(), param, velParam);
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
			SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
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
			SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
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
			SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
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
			SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
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
			SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
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
            SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
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
            SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
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
            SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
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
			SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
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
			SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
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
	 *  TERMINAL DEPARTURE REPORT CNTR를 생성 합니다. <br>
	 * 
	 * @param List<TdrCntrDetailVO> tdrCntrDetailVOs
	 * @throws DAOException
	 */
	public void addTdrCntrS(List<TdrCntrDetailVO> tdrCntrDetailVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
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
			SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
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
			SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
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
			SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
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
			SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
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
			SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
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
			SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
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
			SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
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
			SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
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
			SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
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
			SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
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
			SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
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
			SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
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
			SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
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
			SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
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
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new TerminalDepartureReportDBDAOOpfTmlDepRptDtlVORSQL(), param, velParam);
			
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
			SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
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
			SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
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
			SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
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
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new TerminalDepartureReportDBDAOCgoHndPerformInputVORSQL(), param, velParam);
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
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new TerminalDepartureReportDBDAOMdmYardVORSQL(), param, velParam);
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
			}
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new TerminalDepartureReportDBDAOCgoRhndPerformInputVORSQL(), param, velParam);
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
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new TerminalDepartureReportDBDAOTdrListOptionVORSQL(), param, velParam);
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
	 
	/**
	 *  Terminal Performance - Port 을 조회 합니다.<br>
	 * 
	 * @param TerminalDepartureReportConditionVO terminalDepartureReportConditionVO
	 * @return List<TmnlPerformInputVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<TmnlPerformInputVO> searchTmnlPerformPortList(TerminalDepartureReportConditionVO terminalDepartureReportConditionVO) throws DAOException {
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
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new TerminalDepartureReportDBDAOTmnlPerformInputPortRSQL(), param, velParam);
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
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new TerminalDepartureReportDBDAOTmnlPerformInputLaneRSQL(), param, velParam);
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
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new TerminalDepartureReportDBDAOTmnlPerformVORSQL(), param, velParam);
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
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new TerminalDepartureReportDBDAOTmnlPerformMonthVORSQL(), param, velParam);
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
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new TerminalDepartureReportDBDAOMdmRhqComboRSQL(), param, velParam);
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
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new TerminalDepartureReportDBDAOTerminalDepartureReportVORSQL(), param, velParam);
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
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new TerminalDepartureReportDBDAOTerminalDepartureReportMonthVORSQL(), param, velParam);
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
            SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
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
            dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new TerminalDepartureReportDBDAOsearchTotMoveDataRSQL(), param, velParam);
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
	 * Rehandling Account ( Carrier ) Code 의 유효성을 [조회] 합니다.<br>
	 * 
	 * @param TdrCntrDetailVO tdrCntrDetailVO
	 * @return List<OpfComboVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<OpfComboVO> checkReHndlAcctCd(TdrCntrDetailVO tdrCntrDetailVO) throws DAOException { 
		DBRowSet dbRowset = null;
		List<OpfComboVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(tdrCntrDetailVO != null){
				Map<String, String> mapVO = tdrCntrDetailVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TerminalDepartureReportDBDAOReHndlAcctCdCheckRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, OpfComboVO.class);
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
	 * [TDR Inter Port Vol.] 정보를 [조회] 합니다.<br>
	 * 
	 * @param TerminalDepartureReportCondVO terminalDepartureReportCondVO
	 * @return List<TdrDistLoadVolVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked") 
	public List<TdrDistLoadVolVO> searchTdrLoadInterPortList(TerminalDepartureReportCondVO terminalDepartureReportCondVO) throws DAOException {
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
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new TerminalDepartureReportDBDAOLoadVolInterPortTdrVORSQL(), param, velParam);
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
	 * TDR R/H 의 File Attached 건을 조회합니다.<br>
	 * 
	 * @param OpfTdrAtchFileVO opfTdrAtchFileVO
	 * @return List<OpfTdrAtchFileVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<OpfTdrAtchFileVO> searchOpfTdrAtchFileVO(OpfTdrAtchFileVO opfTdrAtchFileVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<OpfTdrAtchFileVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(opfTdrAtchFileVO != null){
				Map<String, String> mapVO = opfTdrAtchFileVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new TerminalDepartureReportDBDAOOpfTdrAtchFileVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, OpfTdrAtchFileVO .class);
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
	 * TDR R/H 의 File Attached 건을 생성합니다.(단건)<br>
	 * 
	 * @param OpfTdrAtchFileVO opfTdrAtchFileVO
	 * @exception DAOException
	 * @exception Exception
	 */
	public void addmanageOpfTdrAtchFileVO(OpfTdrAtchFileVO opfTdrAtchFileVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = opfTdrAtchFileVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
			int result = sqlExe.executeUpdate((ISQLTemplate)new TerminalDepartureReportDBDAOOpfTdrAtchFileVOCSQL(), param, velParam);
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
	 * TDR R/H 의 File Attached 건을 수정합니다.(단건)<br>
	 * 
	 * @param OpfTdrAtchFileVO opfTdrAtchFileVO
	 * @return int
	 * @exception DAOException
	 * @exception Exception
	 */
	public int modifymanageOpfTdrAtchFileVO(OpfTdrAtchFileVO opfTdrAtchFileVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = opfTdrAtchFileVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
			result = sqlExe.executeUpdate((ISQLTemplate)new TerminalDepartureReportDBDAOOpfTdrAtchFileVOUSQL(), param, velParam);
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
	 * TDR R/H 의 File Attached 건을 삭제합니다.(단건)<br>
	 * 
	 * @param OpfTdrAtchFileVO opfTdrAtchFileVO
	 * @return int
	 * @exception DAOException
	 * @exception Exception
	 */
	public int removemanageOpfTdrAtchFileVO(OpfTdrAtchFileVO opfTdrAtchFileVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = opfTdrAtchFileVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
			result = sqlExe.executeUpdate((ISQLTemplate)new TerminalDepartureReportDBDAOOpfTdrAtchFileVODSQL(), param, velParam);
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
	 * TDR R/H 의 File Attached 건을 생성합니다.(복수건)<br>
	 * 
	 * @param List<OpfTdrAtchFileVO> opfTdrAtchFileVO
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] addmanageOpfTdrAtchFileVOS(List<OpfTdrAtchFileVO> opfTdrAtchFileVO) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
			if(opfTdrAtchFileVO .size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new TerminalDepartureReportDBDAOOpfTdrAtchFileVOCSQL(), opfTdrAtchFileVO,null);
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
	 * TDR R/H 의 File Attached 건을 수정합니다.(복수건)<br>
	 * 
	 * @param List<OpfTdrAtchFileVO> opfTdrAtchFileVO
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] modifymanageOpfTdrAtchFileVOS(List<OpfTdrAtchFileVO> opfTdrAtchFileVO) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
			if(opfTdrAtchFileVO .size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new TerminalDepartureReportDBDAOOpfTdrAtchFileVOUSQL(), opfTdrAtchFileVO,null);
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
	 * TDR R/H 의 File Attached 건을 삭제합니다.(복수건)<br>
	 * 
	 * @param List<OpfTdrAtchFileVO> opfTdrAtchFileVO
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] removemanageOpfTdrAtchFileVOS(List<OpfTdrAtchFileVO> opfTdrAtchFileVO) throws DAOException,Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
			if(opfTdrAtchFileVO .size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new TerminalDepartureReportDBDAOOpfTdrAtchFileVODSQL(), opfTdrAtchFileVO,null);
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
	 * VOP_OPF_0065 : Retrieve <br>
	 * Fleet Status을 조회 합니다.<br>
	 * 
	 * @param FleetStatusVO fleetStatusVO
	 * @return List<FleetStatusVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<FleetStatusVO> searchFleetStatusList(FleetStatusVO fleetStatusVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<FleetStatusVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(fleetStatusVO != null){
				Map<String, String> mapVO = fleetStatusVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TerminalDepartureReportDBDAOSearchFleetStatusListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, FleetStatusVO.class);
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
	 * VOP_OPF_0071 : SEARCHLIST01 & SEARCHLIST02 & SEARCHLIST03<br>
	 * 콤보리스트를 조회한다.<br>
	 * 
	 * @param ComComboVO comComboVO
	 * @return List<ComComboVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<ComComboVO> searchComComboList(ComComboVO comComboVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ComComboVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(comComboVO != null){
				Map<String, String> mapVO = comComboVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TerminalDepartureReportDBDAOSearchVnorCodeListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ComComboVO.class);
			return list;
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	 /**
	 * VOP_OPF_0071 : SEARCHLIST04<br>
	 * 해당 Vessel의 Off-Hire Time List를 조회한다.<br>
	 * 
	 * @param String vslCd
	 * @return List<ComComboVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<ComComboVO> searchOffHireTimeList(String vslCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<ComComboVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			 if (vslCd != null) {
				 param.put("vsl_cd", vslCd);
				 velParam.put("vsl_cd", vslCd);
			 }
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new TerminalDepartureReportDBDAOSearchOffHireTimeListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ComComboVO.class);
			return list;
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	 
	/**
	 * VOP_OPF_0071 : SEARCH01<br>
	 * 유효한 Vessel Code 인지 체크한다.<br>
	 * 
	  * @param String vslCd
	  * @return String
	  * @exception DAOException
	  */
	public String checkVessel(String vslCd) throws DAOException {
		 DBRowSet dbRowset = null;
		 String isOk = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try {
			 if (vslCd != null) {
				 param.put("vsl_cd", vslCd);
				 velParam.put("vsl_cd", vslCd);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TerminalDepartureReportDBDAOCheckVesselRSQL(), param, velParam);
			 if (dbRowset.next()) {
				 isOk = dbRowset.getString("is_ok");
			 }
			 return isOk;
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
	}
	
	/**
	 * VOP_OPF_0071 : SEARCH02<br>
	 * 유효한 Voyage No 인지 체크한다.<br>
	 * 
	  * @param opfVnorVO
	  * @return String
	  * @exception DAOException
	  */
	public String checkVskSkd(OpfVnorVO opfVnorVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 String isOk = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try {
				if(opfVnorVO != null){
					Map<String, String> mapVO = opfVnorVO.getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TerminalDepartureReportDBDAOCheckVskSkdRSQL(), param, velParam);
			 if (dbRowset.next()) {
				 isOk = dbRowset.getString("is_ok");
			 }
			 return isOk;
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
	}
	
	/**
	 * VOP_OPF_0071 : SEARCH05<br>
	 * 유효한 Office Code 인지 체크한다.<br>
	 * 
	  * @param String ofcCd
	  * @return String
	  * @exception DAOException
	  */
	public String checkOfficeCode(String ofcCd) throws DAOException {
		 DBRowSet dbRowset = null;
		 String isOk = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try {
			 if (ofcCd != null) {
				 param.put("office_cd", ofcCd);
				 velParam.put("office_cd", ofcCd);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TerminalDepartureReportDBDAOCheckOfficeCodeRSQL(), param, velParam);
			 if (dbRowset.next()) {
				 isOk = dbRowset.getString("IS_OK");
			 }
			 return isOk;
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
	}
	
	/**
	 * VOP_OPF_0071 : SEARCH<br>
	 * Vessel Not Operationally Ready Report 조회한다.<br>
	 * 
	 * @param opfVnorVO
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public OpfVnorVO searchVnor(OpfVnorVO opfVnorVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<OpfVnorVO> list = null;
		OpfVnorVO returnVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(opfVnorVO != null){
				Map<String, String> mapVO = opfVnorVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new TerminalDepartureReportDBDAOSearchVNORRSQL(), param, velParam);
			if (dbRowset != null) {
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, OpfVnorVO .class);
				
				if (list != null && list.size() > 0) {
					returnVO = list.get(0);
				}
			}
			return returnVO;
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * VOP_OPF_0071 : SEARCH<br>
	 * Vessel Not Operationally Ready Report Item 조회한다.<br>
	 * 
	 * @param opfVnorVO
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<OpfVnorItmVO> searchVnorItm(OpfVnorVO opfVnorVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<OpfVnorItmVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(opfVnorVO != null){
				Map<String, String> mapVO = opfVnorVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new TerminalDepartureReportDBDAOSearchVNORItemRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, OpfVnorItmVO.class);
			return list;
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Off-Hire Time Duplicaton 체크한다.<br>
	 * 
	 * @param opfVnorVO
	 * @return
	 * @throws DAOException
	 */
	public String checkDupOffHireTime(OpfVnorVO opfVnorVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 String isOk = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try {
				if(opfVnorVO != null){
					Map<String, String> mapVO = opfVnorVO.getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
			 dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new TerminalDepartureReportDBDAOCheckDupOffHireTimeRSQL(), param, velParam);
			 if (dbRowset.next()) {
				 isOk = dbRowset.getString("is_ok");
			 }
			 return isOk;
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
	}
	
	/**
	 * Credit Off-Hire Time Duplicaton 체크한다.<br>
	 * 
	 * @param opfVnorVO
	 * @return
	 * @throws DAOException
	 */
	public String checkDupOffHireTimeCr(OpfVnorVO opfVnorVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 String isOk = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try {
				if(opfVnorVO != null){
					Map<String, String> mapVO = opfVnorVO.getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
			 dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new TerminalDepartureReportDBDAOCheckDupOffHireTimeCrRSQL(), param, velParam);
			 if (dbRowset.next()) {
				 isOk = dbRowset.getString("is_ok");
			 }
			 return isOk;
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
	}
	
	/**
	 * Next VNOR_SEQ 조회한다.<br>
	 * 
	 * @param vslCd
	 * @return
	 * @throws DAOException
	 */
	public String searchNextVnorSeq(String vslCd) throws DAOException {
		 DBRowSet dbRowset = null;
		 String nextVnorSeq = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try {
			 if (vslCd != null) {
				 param.put("vsl_cd", vslCd);
				 velParam.put("vsl_cd", vslCd);
			 }
			 
			 dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new TerminalDepartureReportDBDAOSearchNextVnorSeqRSQL(), param, velParam);
			 if (dbRowset.next()) {
				 nextVnorSeq = dbRowset.getString("NEXT_VNOR_SEQ");
			 }
			 return nextVnorSeq;
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
	}
	
	/**
	 * VOP_OPF_0071 : COMMAND01 <br>
	 * OPF_VNOR 테이블 Merge<br>
	 * 
	 * @param opfVnorVO
	 * @return
	 * @throws DAOException
	 */
	public int mergeVnor(OpfVnorVO opfVnorVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if(opfVnorVO != null){
				Map<String, String> mapVO = opfVnorVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			int mergeCnt = new SQLExecuter("OPF_HJSBAT").executeUpdate((ISQLTemplate)new TerminalDepartureReportDBDAOMergeVnorCSQL(), param, velParam);
			return mergeCnt;
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * VNOR 의 Item을 생성합니다.(복수건)<br>
	 * 
	 * @param opfVnorItmVOs
	 * @return
	 * @throws DAOException
	 */
	public int[] insertVnorItem(List<OpfVnorItmVO> opfVnorItmVOs) throws DAOException {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
			if(opfVnorItmVOs .size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new TerminalDepartureReportDBDAOInsertVnorItemCSQL(), opfVnorItmVOs, null);
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
	 * VNOR 의 Item을 갱신합니다.(복수건)<br>
	 * 
	 * @param opfVnorItmVOs
	 * @return
	 * @throws DAOException
	 */
	public int[] updateVnorItem(List<OpfVnorItmVO> opfVnorItmVOs) throws DAOException {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
			if(opfVnorItmVOs .size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new TerminalDepartureReportDBDAOUpdateVnorItemUSQL(), opfVnorItmVOs, null);
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
	 * VNOR 의 Item을 삭제합니다.(복수건)<br>
	 * 
	 * @param opfVnorItmVOs
	 * @return
	 * @throws DAOException
	 */
	public int[] deleteVnorItem(List<OpfVnorItmVO> opfVnorItmVOs) throws DAOException {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
			if(opfVnorItmVOs .size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new TerminalDepartureReportDBDAODeleteVnorItemDSQL(), opfVnorItmVOs, null);
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
	 * Vessel Not Operationally Ready Report 삭제
	 * 
	 * @param opfVnorVO
	 * @return
	 * @throws DAOException
	 */
	public int deleteVnor(OpfVnorVO opfVnorVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if(opfVnorVO != null){
				Map<String, String> mapVO = opfVnorVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			int deleteCnt = new SQLExecuter("OPF_HJSBAT").executeUpdate((ISQLTemplate)new TerminalDepartureReportDBDAODeleteVnorDSQL(), param, velParam);
			return deleteCnt;
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Vessel Not Operationally Ready Report Item 전체 삭제
	 * 
	 * @param opfVnorVO
	 * @return
	 * @throws DAOException
	 */
	public int deleteVnorItemAll(OpfVnorVO opfVnorVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if(opfVnorVO != null){
				Map<String, String> mapVO = opfVnorVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			int deleteCnt = new SQLExecuter("OPF_HJSBAT").executeUpdate((ISQLTemplate)new TerminalDepartureReportDBDAODeleteVnorItemAllDSQL(), param, velParam);
			return deleteCnt;
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * VOP_OPF_0072 : SEARCH<br>
	 * Item Attach File을 조회한다.<br>
	 * 
	 * @param opfAtchFileVO
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<OpfVnorAtchFileVO> searchItemAttachFile(OpfAtchFileVO opfAtchFileVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<OpfVnorAtchFileVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(opfAtchFileVO != null){
				Map<String, String> mapVO = opfAtchFileVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new TerminalDepartureReportDBDAOSearchItemAttachFileRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, OpfVnorAtchFileVO.class);
			return list;
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * VNOR 의 File Attached 건을 생성합니다.(복수건)<br>
	 * 
	 * @param List<OpfAtchFileVO> opfAtchFileVOs
	 * @return int[]
	 * @exception DAOException
	 */
	public int[] addmanageOpfVnorAtchFile(List<OpfAtchFileVO> opfAtchFileVOs) throws DAOException {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
			if(opfAtchFileVOs .size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new TerminalDepartureReportDBDAOInsertVnorAttachFileCSQL(), opfAtchFileVOs, null);
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
	 * VNOR 의 File Attached 건을 삭제합니다.(복수건)<br>
	 * 
	 * @param List<OpfAtchFileVO> opfAtchFileVOs
	 * @return int[]
	 * @exception DAOException
	 */
	public int[] removemanageOpfVnorAtchFile(List<OpfAtchFileVO> opfAtchFileVOs) throws DAOException {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
			if(opfAtchFileVOs .size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new TerminalDepartureReportDBDAODeleteVnorAttachFileDSQL(), opfAtchFileVOs, null);
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
	 * VOP_OPF_0072 : MULTI <br>
	 * VNOR Item의 File Attached 정보를 갱신합니다.<br>
	 * 
	 * @param vslCd
	 * @param vnorSeq
	 * @param vnorItmSeq
	 * @param atchfileLnkId
	 * @return
	 * @throws DAOException
	 */
	public int updateVnorItemAttachFile(String vslCd, String vnorSeq, String vnorItmSeq, String atchfileLnkId) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			 if (vslCd != null && vnorSeq != null && vnorItmSeq != null && atchfileLnkId != null) {
				 param.put("vsl_cd", vslCd);
				 param.put("vnor_seq", vnorSeq);
				 param.put("vnor_itm_seq", vnorItmSeq);
				 param.put("atch_file_lnk_id", atchfileLnkId);
				 velParam.put("vsl_cd", vslCd);
				 velParam.put("vnor_seq", vnorSeq);
				 velParam.put("vnor_itm_seq", vnorItmSeq);
				 velParam.put("atch_file_lnk_id", atchfileLnkId);
			 }
			int updCnt = new SQLExecuter("OPF_HJSBAT").executeUpdate((ISQLTemplate)new TerminalDepartureReportDBDAOUpdateVnorItemAttachFileUSQL(), param, velParam);
			return updCnt;
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * VNOR Email Setup 정보를 조회한다.<br>
	 * 
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<OpfVnorEmlStupVO> searchVnorEmlStup() throws DAOException {
		DBRowSet dbRowset = null;
		List<OpfVnorEmlStupVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new TerminalDepartureReportDBDAOSearchVnorEmlStupRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, OpfVnorEmlStupVO.class);
			return list;
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * VNOR All Code 가져온다.<br>
	 * 
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Map<String, String> getVnorAllCode() throws DAOException {
		DBRowSet dbRowset = null;
		List<ComComboVO> list = null;
		Map<String, String> resultMap = new HashMap<String, String>();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new TerminalDepartureReportDBDAOSearchVnorAllCodeRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ComComboVO.class);
			for (int i = 0; i < list.size(); i++) {
				resultMap.put(list.get(i).getIntgCdValCtnt(), list.get(i).getIntgCdValDpDesc());
			}
			return resultMap;
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * VNOR Email Setup 정보를 생성합니다.(복수건)<br>
	 * 
	 * @param List<OpfVnorEmlStupVO> opfVnorEmlStupVOs
	 * @return int[]
	 * @exception DAOException
	 */
	public int[] addVnorEmlStup(List<OpfVnorEmlStupVO> opfVnorEmlStupVOs) throws DAOException {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
			if(opfVnorEmlStupVOs .size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new TerminalDepartureReportDBDAOInsertVnorEmlStupCSQL(), opfVnorEmlStupVOs, null);
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
	 * VNOR Email Setup 정보를 삭제합니다.(복수건)<br>
	 * 
	 * @param opfVnorEmlStupVOs
	 * @return
	 * @throws DAOException
	 */
	public int[] removeVnorEmlStup(List<OpfVnorEmlStupVO> opfVnorEmlStupVOs) throws DAOException {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
			if(opfVnorEmlStupVOs .size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new TerminalDepartureReportDBDAODeleteVnorEmlStupDSQL(), opfVnorEmlStupVOs, null);
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
	 * 사선/용선 구분 코드를 가져온다.
	 * 
	 * @param vslCd
	 * @return
	 * @throws DAOException
	 */
	public String getVslOwnIndCd(String vslCd) throws DAOException {
		 DBRowSet dbRowset = null;
		 String vslOwnIndCd = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try {
			 if (vslCd != null) {
				 param.put("vsl_cd", vslCd);
				 velParam.put("vsl_cd", vslCd);
			 }
			 
			 dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new TerminalDepartureReportDBDAOSearchVslOwnIndCdRSQL(), param, velParam);
			 if (dbRowset.next()) {
				 vslOwnIndCd = dbRowset.getString("VSL_OWN_IND_CD");
			 }
			 return vslOwnIndCd;
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
	}
	
	/**
	 * 해당 Vessel / Voy No 의 SKD Port List를 조회한다.<br>
	 * 
	 * @param opfVnorVO
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<ComComboVO> searchSkdPortList(OpfVnorVO opfVnorVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ComComboVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(opfVnorVO != null){
				Map<String, String> mapVO = opfVnorVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new TerminalDepartureReportDBDAOSearchSkdPortListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ComComboVO.class);
			return list;
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 해당 Port의 Office Code List를 조회한다.<br>
	 * 
	 * @param opfVnorVO
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<ComComboVO> searchPortOfcCdList(OpfVnorVO opfVnorVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ComComboVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(opfVnorVO != null){
				Map<String, String> mapVO = opfVnorVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new TerminalDepartureReportDBDAOSearchPortOfcCdListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ComComboVO.class);
			return list;
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * VNOR Summary Inquiry 조회합니다.<br>
	 * 
	 * @param opfVnorSummaryVO
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<OpfVnorSummaryVO> searchVnorSummary(OpfVnorSummaryVO opfVnorSummaryVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<OpfVnorSummaryVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(opfVnorSummaryVO != null){
				Map<String, String> mapVO = opfVnorSummaryVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new TerminalDepartureReportDBDAOSearchVnorSummaryRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, OpfVnorSummaryVO.class);
			return list;
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * VNOR Summary Other Loss Item Remark 조회합니다.<br>
	 * 
	 * @param opfVnorSummaryVO
	 * @return
	 * @throws DAOException
	 */
	public List<String> searchOtItmRmk(OpfVnorSummaryVO opfVnorSummaryVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<String> list = new ArrayList<String>();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(opfVnorSummaryVO != null){
				Map<String, String> mapVO = opfVnorSummaryVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new TerminalDepartureReportDBDAOSearchVnorSummaryOtItmRmkRSQL(), param, velParam);
			 while (dbRowset.next()) {
				 list.add(dbRowset.getString("VNOR_ITM_RMK"));
			 }
			return list;
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 *  TERMINAL DEPARTURE REPORT HEADER의 AvgGang를 수정 합니다. <br>
	 * 
	 * @param List<TdrHeaderVO> tdrHeaderVOs
	 * @throws DAOException
	 */
	public void modifyTdrSAvgGang(List<TdrHeaderVO> tdrHeaderVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("OPF_HJSBAT");
			int insCnt[] = null;
			if(tdrHeaderVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new TerminalDepartureReportDBDAOTdrHeaderAvgGangVOUSQL(), tdrHeaderVOs, null);
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
	
}