/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VesselScheduleMgtDBDAO.java
*@FileTitle : VesselScheduleMgtDBDAO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.08
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2009.05.04 서창열
* 1.0 Creation
* 
* History
* 2010.10.05 CHM-201006264-01 유혁 Session User ID 설정로직 변경
* 2010.12.08 CHM-201007135-01 진마리아 Actaul Carrier update 로직 변경 요청건
=========================================================*/
package com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration;
 
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.basic.VesselScheduleMgtBCImpl;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.ActivationVvdVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.ActualSkdBySimNoVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.BkgBdrLogVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.BkgListByVvdVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.CanalBnkSavVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.CanalTransitTargetVvdVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.CstSkdBerthWdoVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.CstSkdByPolPodVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.CstSkdByPortVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.CstSkdByVvdVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.CstSkdSimDtlCalcInfoVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.EdiMsgToDLSVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.IsReverseVesselPortScheduleVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.LoadWgtVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.PfSkdDetailVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.PortSkdOnLongRangeVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.SwapCstSkdSimVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.VslPortSkdVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.VslSkdCngHisDtlVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.VslSkdXtraHisVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.VvdBkgStsVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.VvdCheckVO;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.VvdPortLaneOtherVO;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.VvdVO;
import com.clt.apps.opus.vop.vsk.vskcommonutil.vskgeneralutil.VSKGeneralUtil;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.MdmVslCntrVO;
import com.clt.syscommon.common.table.MdmVslSvcLaneDirVO;
import com.clt.syscommon.common.table.VskCustEdiLogVO;
import com.clt.syscommon.common.table.VskDepRptVO;
import com.clt.syscommon.common.table.VskHydrstMtxVO;
import com.clt.syscommon.common.table.VskNoonRptVO;
import com.clt.syscommon.common.table.VskPortDistVO;
import com.clt.syscommon.common.table.VskPortTideVO;
import com.clt.syscommon.common.table.VskSwapCstPortVO;
import com.clt.syscommon.common.table.VskSwapCstSimVO;
import com.clt.syscommon.common.table.VskSwapCstVvdVO;
import com.clt.syscommon.common.table.VskVslPortSkdVO;
import com.clt.syscommon.common.table.VskVslSkdHisVO;
import com.clt.syscommon.common.table.VskVslSkdVO;


/**
 * NIS2010 VesselScheduleMgtDBDAO <br>
 * - NIS2010-SchedulePlanningOperation system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author SEO CHANG YUL
 * @see VesselScheduleMgtBCImpl 참조
 * @since J2EE 1.4
 */
public class VesselScheduleMgtDBDAO extends DBDAOSupport {

	private static final long serialVersionUID = 1L;

	/**
	 * Lane 별 Vessel Schedule 정보를 조회합니다.<br>
	 * 
	 * @param ActivationVvdVO activationVvdVO
	 * @return List<ActivationVvdVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<ActivationVvdVO> searchVslSkdListByLane(ActivationVvdVO activationVvdVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ActivationVvdVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(activationVvdVO != null){
				Map<String, String> mapVO = activationVvdVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselScheduleMgtDBDAOSearchVslSkdActCloseRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ActivationVvdVO .class);
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
	 * 해당 VVD가 존재하는지 검증합니다.<br>
	 * 
	 * @param VslPortSkdVO vslPortSkdVO
	 * @return VvdCheckVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
    public VvdCheckVO checkVskVslPortSkd(VslPortSkdVO vslPortSkdVO) throws DAOException {
        DBRowSet dbRowset = null;
		List<VvdCheckVO> list = null;
		VvdCheckVO vvdCheckVO = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vslPortSkdVO != null){
				Map<String, String> mapVO = vslPortSkdVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselScheduleMgtDBDAOCheckVskVslPortSkdRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VvdCheckVO .class);
			
			if(list != null && list.size()>0){
				vvdCheckVO = list.get(0);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	    return vvdCheckVO;
	}
	

	/**
	 * Checking VPS Reverse or not
	 * 
	 * @param VslPortSkdVO vslPortSkdVO
	 * @return boolean
	 * @exception EventException
	 * @author TOP
	 */
	public boolean isReverseVesselPortSchedule(VslPortSkdVO vslPortSkdVO) throws DAOException {
		
        DBRowSet 							dbRowset 	= null;
		List<IsReverseVesselPortScheduleVO> list 		= null;
		IsReverseVesselPortScheduleVO 		tmpVO 		= null;
		boolean								isReverse	= false;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vslPortSkdVO != null){
				Map<String, String> mapVO = vslPortSkdVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselScheduleMgtDBDAOIsReverseVesselPortScheduleRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, IsReverseVesselPortScheduleVO.class);
			
			if(list != null && list.size()>0){
				tmpVO = list.get(0);
			}
			
			if(tmpVO != null && "Y".equals(tmpVO.getVpsReverseFlg())){
				isReverse	= true;
			}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	    return isReverse;
	}
	 
	/**
	 * 
	 * @param MdmVslSvcLaneDirVO mdmVslSvcLaneDirVO
	 * @return String
	 * @throws DAOException
	 */
    public String searchDirectionSeq(MdmVslSvcLaneDirVO mdmVslSvcLaneDirVO) throws DAOException {
    	DBRowSet dbRowset = null;
    	String dirSeq = ""; 
		 
    	//query parameter
    	Map<String, Object> param = new HashMap<String, Object>();
    	//velocity parameter
    	Map<String, Object> velParam = new HashMap<String, Object>();
    	
    	try{
    		if(mdmVslSvcLaneDirVO != null){
    			Map<String, String> mapVO = mdmVslSvcLaneDirVO.getColumnValues();
    			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
    		}
    		
    		dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselScheduleMgtDBDAOSearchDirectionSeqRSQL(), param, velParam);
    		if(dbRowset != null){
				if(dbRowset.next()){
					dirSeq = dbRowset.getString("RNUM");
				}
			}
    	}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return dirSeq;
	}
		 
	/**
	 * 해당 VVD가 Booking VVD에 존재하는지 검증합니다.<br>
	 * 
	 * @param VvdVO vvdVO
	 * @return List<VvdVO>
	 * @exception DAOException
	 */
    @SuppressWarnings("unchecked")
    public List<VvdVO> checkBkgLinkDataByVvd(VvdVO vvdVO) throws DAOException {
        DBRowSet dbRowset = null;
		List<VvdVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vvdVO != null){
				Map<String, String> mapVO = vvdVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselScheduleMgtDBDAOBkgVvdVORSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VvdVO .class);
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
	 * VSL_PORT의 자신에 VVD와 연결되는 Pre-VVD와 Next-VVD 정보를 찾아 온다..<br>
	 * 
	 * @param VvdVO vvdVO
	 * @return List<VvdVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<VvdVO> searchConnectVvd(VvdVO vvdVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<VvdVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vvdVO != null){
				Map<String, String> mapVO = vvdVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselScheduleMgtDBDAOSearchConnectVvdRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VvdVO .class);
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
		 * 자신에 VVD와 연결되는 Pre-VVD와 Next-VVD 정보를 찾아 온다..<br>
		 * 
		  * @param VvdVO vvdVO
		  * @return List<VskVslSkdHisVO>
		  * @exception DAOException
		  */
		 @SuppressWarnings("unchecked")
		public List<VskVslSkdHisVO> checkCurVvdBkgPolPodYard(VvdVO vvdVO) throws DAOException {
			 
			DBRowSet 				dbRowset 	= null;
			List<VskVslSkdHisVO> 	list 		= null;
			//query parameter
			Map<String, Object> 	param 		= new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> 	velParam 	= new HashMap<String, Object>();

			try{
				
				if(vvdVO != null){
					Map<String, String> mapVO = vvdVO .getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}

				dbRowset 	= new SQLExecuter("").executeQuery((ISQLTemplate)new VesselScheduleMgtDBDAOCheckCurVvdBkgPolPodYardRSQL(), param, null);
				list 		= (List)RowSetUtil.rowSetToVOs(dbRowset, VskVslSkdHisVO.class);
			
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
	 * 자신에 VVD와 연결되는 Pre-VVD와 Next-VVD 정보를 찾아 온다..<br>
	 * 
	  * @param VvdVO vvdVO
	  * @return List<VskVslSkdHisVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	public List<VskVslSkdHisVO> checkPreVvdBkgPodYard(VvdVO vvdVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<VskVslSkdHisVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vvdVO != null){
				Map<String, String> mapVO = vvdVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselScheduleMgtDBDAOCheckPreVvdBkgPodYardRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VskVslSkdHisVO.class);
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
	 * VSK_VSL_PORT_SKD 데이터를 삭제한다.<br>
	 * 전차수의 VVD를 지운다
	 *
	 * @param VvdVO vvdVO
	 * @return int
	 * @exception DAOException
	 */
	public int removeVskVslPortSkdByPreVvd(VvdVO vvdVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			if(vvdVO != null){
				Map<String, String> mapVO = vvdVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new VesselScheduleMgtDBDAORemoveVskVslPortSkdByPreVvdDSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to remove SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
		
	/**
	 * VSK_VSL_PORT_SKD 데이터를 삭제한다.<br>
	 * 후차수의 VVD를 업데이트한다
	 * 
	 * @param VvdVO vvdVO
	 * @return int
	 * @exception DAOException
	 */
	public int modifyVskVslPortSkdNextTurnPort(VvdVO vvdVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			if(vvdVO != null){
				Map<String, String> mapVO = vvdVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new VesselScheduleMgtDBDAOModifyVskVslPortSkdNextTurnPortUSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
		 
//	/**
//	 * VSK_VSL_PORT_SKD 데이터를 삭제한다.<br>
//	 * 
//	 * @param String vslCd
//	 * @param String skdVoyNo
//	 * @param String skdDirCd
//	 * @return int
//	 * @exception DAOException
//	 */
//	public int removeVslPortSkdByVvd(String vslCd, String skdVoyNo, String skdDirCd) throws DAOException {
//		//query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
//		//velocity parameter
//		Map<String, Object> velParam = null;//new HashMap<String, Object>();
//		
//		int result = 0;
//		try {
//			param.put("vsl_cd",vslCd);
//			param.put("skd_voy_no",skdVoyNo);
//			param.put("skd_dir_cd",skdDirCd);
//			
//			SQLExecuter sqlExe = new SQLExecuter("");
//			result = sqlExe.executeUpdate((ISQLTemplate)new VesselScheduleMgtDBDAORemoveVslPortSkdByVvdDSQL(), param, velParam);
//			if(result == Statement.EXECUTE_FAILED)
//					throw new DAOException("Fail to remove SQL");
//		} catch (SQLException se) {
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(se).getMessage(), se);
//		}catch(Exception ex){
//			log.error(ex.getMessage(),ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
//		}
//		return result;
//	}
		
	/**
	 * SWAP_CST_PORT의 자신에 VVD와 연결되는 Pre-VVD와 Next-VVD 정보를 찾아 온다..<br>
	 * 
	 * @param VvdVO vvdVO
	 * @return List<VvdVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<VvdVO> searchConnectVvdSim(VvdVO vvdVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<VvdVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vvdVO != null){
				Map<String, String> mapVO = vvdVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselScheduleMgtDBDAOSearchConnectVvdSimRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VvdVO .class);
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
	 * Vsk_Swap_Cst_Port  데이터를 삭제한다.<br>
	 * 자기 자신의 VVD 전 차수를 찾아서 REMOVE한다
	 * 
	 * @param VvdVO vvdVO
	 * @return int
	 * @exception DAOException
	 */
	public int removeVskSwapCstPortByPreVvd(VvdVO vvdVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			if(vvdVO != null){
				Map<String, String> mapVO = vvdVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new VesselScheduleMgtDBDAORemoveVskSwapCstPortByPreVvdDSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to remove SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
		
	/**
	 * Vsk_Swap_Cst_Port  데이터를 삭제한다.<br>
	 * 자기 자신의 VVD를  REMOVE한다
	 * 
	 * @param VskSwapCstPortVO vskSwapCstPortVO
	 * @return int
	 * @exception DAOException
	 */
	public int removeVskSwapCstPort(VskSwapCstPortVO vskSwapCstPortVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			if(vskSwapCstPortVO != null){
				Map<String, String> mapVO = vskSwapCstPortVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new VesselScheduleMgtDBDAORemoveVskSwapCstPortDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to remove SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
		
	/**
	 * Vsk_Swap_Cst_Port  데이터를 삭제한다.<br>
	 * 자기 자신의 VVD의 다음 차수를 찾아서 UPDATE한다
	 *  
	 * @param VvdVO vvdVO
	 * @return int
	 * @exception DAOException
	 */
	public int modifyVskSwapCstPort(VvdVO vvdVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			if(vvdVO != null){
				Map<String, String> mapVO = vvdVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new VesselScheduleMgtDBDAOModifyVskSwapCstPortUSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
		
	/**
	 * VSK_SWAP_CST_SIM TABLE 삭제를 위해 SIM_DT,SIM_NO를 조회한다..<br>
	 * 
	 * @param VvdVO vvdVO
	 * @return List<VskSwapCstSimVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<VskSwapCstSimVO> searchSimNoVskSwapCstVvd(VvdVO vvdVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<VskSwapCstSimVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vvdVO != null){
				Map<String, String> mapVO = vvdVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselScheduleMgtDBDAOSearchSimNoVskSwapCstVvdRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VskSwapCstSimVO .class);
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
	 * Vsk_Swap_Cst_Vvd  데이터를 삭제한다.<br>
	 * 
	 * @param VskSwapCstVvdVO vskSwapCstVvdVO
	 * @return int
	 * @exception DAOException
	 */
	public int removeVskSwapCstVvd(VskSwapCstVvdVO vskSwapCstVvdVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			if(vskSwapCstVvdVO != null){
				Map<String, String> mapVO = vskSwapCstVvdVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new VesselScheduleMgtDBDAORemoveVskSwapCstVvdDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to remove SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
		
	/**
	 * Vsk_Swap_Cst_RMK  데이터를 삭제한다.<br>
	 * 
	 * @param VvdVO vvdVO
	 * @return int
	 * @exception DAOException
	 */
	public int removeVskSwapCstRmk(VvdVO vvdVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			if(vvdVO != null){
				Map<String, String> mapVO = vvdVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new VesselScheduleMgtDBDAORemoveVskSwapCstRmkDSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to remove SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
		
	/**
	 * Simulation No, Simulation Seq로 등록된 Simulation 정보가 있는지 확인<br>
	 * 
	 * @param VskSwapCstSimVO vskSwapCstSimVO
	 * @return int
	 * @exception DAOException
	 */
	public int searchVskSwapCstVvdCount(VskSwapCstSimVO vskSwapCstSimVO) throws DAOException {
		DBRowSet dbRowset = null;
//		List<VskSwapCstSimVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int cnt = 0;

		try{
			if(vskSwapCstSimVO != null){
				Map<String, String> mapVO = vskSwapCstSimVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselScheduleMgtDBDAOCheckVskSwapCstVvdRSQL(), param, null);
			cnt = dbRowset.getRowCount();
			//list = (List)RowSetUtil.rowSetToVOs(dbRowset, VskSwapCstSimVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return cnt;
	}
		 
	/**
	 * Vsk_Swap_Cst_SIM  데이터를 삭제한다.<br>
	 * 
	 * @param VskSwapCstSimVO  vskSwapCstSimVO
	 * @return int
	 * @exception DAOException
	 */
	public int removeVskSwapCstSim(VskSwapCstSimVO vskSwapCstSimVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			if(vskSwapCstSimVO != null){
				Map<String, String> mapVO = vskSwapCstSimVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new VesselScheduleMgtDBDAORemoveVskSwapCstSimDSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to remove SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
		
		
	/**
	 * Vsk_VSL_PORT_SKD  데이터를 삭제한다.<br>
	 * 
	 * @param VvdVO vvdVO
	 * @return int
	 * @exception DAOException
	 */
	public int removeVskVslPortSkdByVvd(VvdVO vvdVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			if(vvdVO != null){
				Map<String, String> mapVO = vvdVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new VesselScheduleMgtDBDAORemoveVskVslPortSkdByVvdDSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to remove SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
		
	/**
	 * VSK_VSL_SKD 데이터를 삭제한다.<br>
	 * 
	 * @param VvdVO vvdVO
	 * @return int
	 * @exception DAOException
	 */
	public int removeVskVslSkdByVvd(VvdVO vvdVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			if(vvdVO != null){
				Map<String, String> mapVO = vvdVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new VesselScheduleMgtDBDAORemoveVslSkdByVvdDSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to remove SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	 
	/**
	 * VSK_VSL_SKD 데이터를 삭제한다.<br>
	 * 
	 * @param VvdVO vvdVO
	 * @return int
	 * @exception DAOException
	 */
	public int removeVskVslSkdByEmptyVvd(VvdVO vvdVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			if(vvdVO != null){
				Map<String, String> mapVO = vvdVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new VesselScheduleMgtDBDAORemoveVslSkdByEmptyVvdDSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to remove SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	
	/**
	 * Booking 모쥴에 BDR 정보를 변경하기 위해 Target 정보를 조회한다.
	 * 
	 * @param VvdVO vvdVO
	 * @return List<BkgBdrLogVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgBdrLogVO> searchBkgBdrLog(VvdVO vvdVO) throws DAOException {
		List<BkgBdrLogVO> list = null;
		
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if(vvdVO != null){
				Map<String, String> mapVO = vvdVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			
				DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselScheduleMgtDBDAOSearchBkgBdrLogRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgBdrLogVO .class);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
		
	/**
	 * VSK_VSL_SKD_HIS 단건의 데이터를 생성한다.<br>
	 * 
	 * @param VskVslSkdHisVO vskVslSkdHisVO
	 * @exception DAOException
	 */
	public void addVslSkdHis(VskVslSkdHisVO vskVslSkdHisVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vskVslSkdHisVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
//			int result = sqlExe.executeUpdate((ISQLTemplate)new VesselScheduleMgtDBDAOaddVslSkdHisCSQL(), param, velParam);
			int result = sqlExe.executeUpdate((ISQLTemplate)new VesselScheduleMgtDBDAOAddVskVslSkdHisCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

//	/**
//	 * VSK_VSL_SKD_HIS 단건의 데이터를 생성한다.<br>
//	 * 
//	 * @param VvdPortLaneOtherVO vvdPortLaneOtherVO
//	 * @exception DAOException
//	 */
//	public void addVslSkdHis(VvdPortLaneOtherVO vvdPortLaneOtherVO) throws DAOException {
//		//query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
//		//velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();
//		try {
//			Map<String, String> mapVO = vvdPortLaneOtherVO.getColumnValues();
//			
//			param.putAll(mapVO);
//			velParam.putAll(mapVO);
//			
//			SQLExecuter sqlExe = new SQLExecuter("");
//			int result = sqlExe.executeUpdate((ISQLTemplate)new VesselScheduleMgtDBDAOaddVslSkdHisCSQL(), param, velParam);
//			if(result == Statement.EXECUTE_FAILED)
//					throw new DAOException("Fail to insert SQL");
//		} catch (SQLException se) {
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(se).getMessage(), se);
//		}catch(Exception ex){
//			log.error(ex.getMessage(),ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
//		}
//	}
	 
//	/**
//	 * VesselScheduleMgtDBDAO의 데이타 모델에 해당되는 값을 생성한다.<br>
//	 * 
//	 * @param model 데이타 모델
//	 * @return DBRowSet
//	 * @exception DAOException
//	 */
//	public void addVslSkd(List<VskSwapCstVvdVO> vos) throws DAOException {
//		try{
//			SQLExecuter sqlExe = new SQLExecuter("");
//			int insCnt[] = null;
//			if(vos.size() > 0){
//				insCnt = sqlExe.executeBatch((ISQLTemplate)new VesselScheduleMgtDBDAOVskSwapCstVvdVOCSQL(), vos, null);
//				for(int i = 0; i < insCnt.length; i++){
//					if(insCnt[i]== Statement.EXECUTE_FAILED)
//						throw new DAOException("Fail to insert No"+ i + " SQL");
//				}
//			}
//		} catch (SQLException se) {
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(se).getMessage(), se);
//		}catch(Exception ex){
//			log.error(ex.getMessage(),ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
//		}
//	}
//		 
//
//	/**
//	 * VesselScheduleMgtDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
//	 * 
//	 * @param model 데이타 모델
//	 * @return DBRowSet
//	 * @exception DAOException
//	 */
//	public void addVslPortSkd(List<VskSwapCstPortVO> vos) throws DAOException {
//		try {
//			SQLExecuter sqlExe = new SQLExecuter("");
//			int insCnt[] = null;
//			if(vos.size() > 0){
//				
//				insCnt = sqlExe.executeBatch((ISQLTemplate)new VesselScheduleMgtDBDAOVskVslPortSkdVOCSQL(), vos, null);
//				
//				for(int i = 0; i < insCnt.length; i++){
//					if(insCnt[i]== Statement.EXECUTE_FAILED)
//						throw new DAOException("Fail to insert No"+ i + " SQL");
//				}
//			}
//		} catch (SQLException se) {
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(se).getMessage(), se);
//		}catch(Exception ex){
//			log.error(ex.getMessage(),ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
//		}
//	}
//	
//	/**
//	 * VesselScheduleMgtDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
//	 * 
//	 * @param model 데이타 모델
//	 * @return DBRowSet
//	 * @exception DAOException
//	 */
//	public void addVslPortSkd(List<VskSwapCstPortVO> vos) throws DAOException {
//		try {
//			if(vos.size() > 0){
//				
//				for(int i=0; i<vos.size(); i++){
//					
//					asdf(vos.get(i));
//					
//				}
//				
//			}
//				
//		} catch (SQLException se) {
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(se).getMessage(), se);
//		}catch(Exception ex){
//			log.error(ex.getMessage(),ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
//		}
//	}
//		
//
//		public int asdf(VskSwapCstPortVO paramVO) throws DAOException {
//			//query parameter
//			Map<String, Object> param = new HashMap<String, Object>();
//			//velocity parameter
//			Map<String, Object> velParam = new HashMap<String, Object>();
//			
//			int result = 0;
//			try {
//				if(paramVO != null){
//					Map<String, String> mapVO = paramVO .getColumnValues();
//				
//					param.putAll(mapVO);
//					velParam.putAll(mapVO);
//				}
//				
//				SQLExecuter sqlExe = new SQLExecuter("");
//				result = sqlExe.executeUpdate((ISQLTemplate)new VesselScheduleMgtDBDAOVskVslPortSkdVOCSQL(), param, null);
//				if(result == Statement.EXECUTE_FAILED)
//						throw new DAOException("Fail to remove SQL");
//			} catch (SQLException se) {
//				log.error(se.getMessage(),se);
//				throw new DAOException(new ErrorHandler(se).getMessage(), se);
//			}catch(Exception ex){
//				log.error(ex.getMessage(),ex);
//				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
//			}
//			return result;
//		}
	 
	/**
	 * 이전 Calling한 Port 정보를 조회합니다.<br>
	 * 
	 * @param VvdVO vvdVO
	 * @return List<VskVslPortSkdVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<VskVslPortSkdVO> searchPreCallingPortList(VvdVO vvdVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<VskVslPortSkdVO> list = null;
		
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{
			if(vvdVO != null){
				Map<String, String> mapVO = vvdVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselScheduleMgtDBDAOPreCallingPortRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VskVslPortSkdVO .class);
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
	 * Calling할 Port 정보를 조회합니다.<br>
	 * 
	 * @param VvdVO vvdVO
	 * @return List<VskVslPortSkdVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<VskVslPortSkdVO> searchNextCallingPortList(VvdVO vvdVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<VskVslPortSkdVO> list = null;
		
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{
			if(vvdVO != null){
				Map<String, String> mapVO = vvdVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselScheduleMgtDBDAONextCallingPortRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VskVslPortSkdVO .class);
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
	 * VVD별 Vessel Schedule 정보를 조회합니다.<br>
	 * 
	 * @param CstSkdByVvdVO cstSkdByVvdVO
	 * @return List<CstSkdByVvdVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CstSkdByVvdVO> searchCstSkdByVvd(CstSkdByVvdVO cstSkdByVvdVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CstSkdByVvdVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{
			if(cstSkdByVvdVO != null){
				Map<String, String> mapVO = cstSkdByVvdVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselScheduleMgtDBDAOCstSkdByVvdRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CstSkdByVvdVO .class);
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
	 * Proforma Schedule 을 조회합니다.<br>
	 * 
	 * @param CstSkdByVvdVO cstSkdByVvdVO
	 * @return List<CstSkdByVvdVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CstSkdByVvdVO> searchCstSkdByPfSkdUse(CstSkdByVvdVO cstSkdByVvdVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CstSkdByVvdVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{
			if(cstSkdByVvdVO != null){
				Map<String, String> mapVO = cstSkdByVvdVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselScheduleMgtDBDAOSearchCstSkdByPfSkdUseRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CstSkdByVvdVO .class);
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
	 * Proforma Schedule 을 조회합니다.<br>
	 * 
	 * @param SwapCstSkdSimVO swapCstSkdSimVO
	 * @return List<SwapCstSkdSimVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SwapCstSkdSimVO> searchCstSkdByPfSkdSim(SwapCstSkdSimVO swapCstSkdSimVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SwapCstSkdSimVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{
			if(swapCstSkdSimVO != null){
				Map<String, String> mapVO = swapCstSkdSimVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselScheduleMgtDBDAOSearchCstSkdByPfSkdSimRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SwapCstSkdSimVO .class);
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
	 * Service Lane Code, Direction Code 가 MDM Service Lane Table에 등록되어 있는지 확인한다.
	 * 
	 * @param String laneCd
	 * @param String dirCd
	 * @return String
	 * @exception DAOException
	 * @author jinwoo
	 */
	public String checkLaneDir(String laneCd, String dirCd) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnFlag = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(VSKGeneralUtil.isNotNull(laneCd) && VSKGeneralUtil.isNotNull(dirCd)){
				param.put("vsl_slan_cd", laneCd);
				param.put("vsl_slan_dir_cd", dirCd);
				velParam.put("vsl_slan_cd", laneCd);
				velParam.put("vsl_slan_dir_cd", dirCd);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselScheduleMgtDBDAOCheckLaneDirRSQL(), param, velParam);
			if(dbRowset != null){
				if(dbRowset.next()){
					rtnFlag = dbRowset.getString("FLAG");
				}
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return rtnFlag;
	}
	
	/**
	 * MDM Container Vessel Code 정보에 등록되어 있는지 확인한다.
	 * 
	 * @param String vslCd
	 * @return int
	 * @exception DAOException
	 * @author jinwoo
	 */
	public int checkVslCntr(String vslCd) throws DAOException {
		DBRowSet dbRowset = null;
		int rtnCnt = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(VSKGeneralUtil.isNotNull(vslCd)){
				param.put("vsl_cd", vslCd);
				velParam.put("vsl_cd", vslCd);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselScheduleMgtDBDAOCheckVslCntrRSQL(), param, velParam);
			if(dbRowset != null){
				if(dbRowset.next()){
					rtnCnt = dbRowset.getInt("CNT");
				}
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return rtnCnt;
	}
	

	/**
	 * 해당 VVD를 사용하는 Booking 정보가 있는지 확인한다.
	 * 
	 * @param VvdVO vvdVO
	 * @return int
	 * @exception DAOException
	 * @author jinwoo
	 */
	public int checkVvdApplyBooking(VvdVO vvdVO) throws DAOException {
		DBRowSet dbRowset = null;
		int rtnCnt = 0;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(vvdVO != null){
				param.put("vsl_cd", vvdVO.getVslCd());
				param.put("skd_voy_no", vvdVO.getSkdVoyNo());
				param.put("skd_dir_cd", vvdVO.getSkdDirCd());
				
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselScheduleMgtDBDAOCheckVvdApplyBookingRSQL(), param, null);
				if(dbRowset != null){
					if(dbRowset.next()){
						rtnCnt = dbRowset.getInt("CNT");
					}
				}
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return rtnCnt;
	}
	

	/**
	 * 해당 VVD로 Actual Port Schedule이 입력되여 있는지 확인한다.
	 * 
	 * @param VvdVO vvdVO
	 * @return int
	 * @exception DAOException
	 * @author jinwoo
	 */
	public int checkVvdActualSkdInput(VvdVO vvdVO) throws DAOException {
		DBRowSet dbRowset = null;
		int rtnCnt = 0;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(vvdVO != null){
				param.put("vsl_cd", vvdVO.getVslCd());
				param.put("skd_voy_no", vvdVO.getSkdVoyNo());
				param.put("skd_dir_cd", vvdVO.getSkdDirCd());
				
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselScheduleMgtDBDAOCheckVvdActualSkdInputRSQL(), param, null);
				if(dbRowset != null){
					if(dbRowset.next()){
						rtnCnt = dbRowset.getInt("CNT");
					}
				}
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return rtnCnt;
	}
	

	/**
	 * 해당 VVD로 RUSE_PROHI_FLG 값을 확인한다.
	 * 
	 * @param VvdVO vvdVO
	 * @return String
	 * @exception DAOException
	 * @author jinwoo
	 */
	public String checkReuseVvd(VvdVO vvdVO) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnStr = "";
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(vvdVO != null){
				param.put("vsl_cd", vvdVO.getVslCd());
				param.put("skd_voy_no", vvdVO.getSkdVoyNo());
				param.put("skd_dir_cd", vvdVO.getSkdDirCd());
				
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselScheduleMgtDBDAOCheckReuseVvdRSQL(), param, null);
				if(dbRowset != null){
					if(dbRowset.next()){
						rtnStr = dbRowset.getString("RUSE_PROHI_FLG");
					}
				}
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return rtnStr;
	}
	
//	/**
//	 * @param vskVslSkdVOList List<VskVslSkdVO>
//	 * @exception DAOException
//	 */
//	public int addVskVslSkd(List<VskVslSkdVO> vskVslSkdVOList) throws DAOException {
//		int result = 0;
//		
//		try {
////			int insCnt[] = null;
//			
//			//query parameter
//			Map<String, Object> param = new HashMap<String, Object>();
//			//velocity parameter
//			Map<String, Object> velParam = new HashMap<String, Object>();
//			
//			if(vskVslSkdVOList.size() > 0){
//				SQLExecuter sqlExe = new SQLExecuter("");
//				int inCnt = vskVslSkdVOList.size();
//				for(int i=0; i<inCnt; i++){
//					Map<String, String> mapVO = vskVslSkdVOList.get(i) .getColumnValues();
//					
//					param.putAll(mapVO);
//					velParam.putAll(mapVO);
//
//					result = sqlExe.executeUpdate((ISQLTemplate)new VesselScheduleMgtDBDAOAddVskVslSkdCSQL(), param, null);
//				}
////				if(vskSwapCstSimVO != null){
//					
////				}
////				insCnt = sqlExe.executeBatch((ISQLTemplate)new VesselScheduleMgtDBDAOAddVskVslSkdCSQL(), vskVslSkdVOList, null);
//				
////				for(int i = 0; i < insCnt.length; i++){
////					if(insCnt[i] == Statement.EXECUTE_FAILED)
////						throw new DAOException("Fail to insert No"+ i + " SQL");
////				}
//			}
//		} catch (SQLException se) {
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(se).getMessage(), se);
//		}catch(Exception ex){
//			log.error(ex.getMessage(),ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
//		}
//		
//		return result;
//	}
	
	/**
	 * VSK_VSL_SKD의 VVD 정보를 생성합니다.<br>
	 * 
	 * @param List<VskVslSkdVO> vskVslSkdVOs
	 * @exception DAOException
	 */
	public void addVskVslSkd(List<VskVslSkdVO> vskVslSkdVOs) throws DAOException {
		try {
			int insCnt[] = null;
			
			if(vskVslSkdVOs.size() > 0){
				SQLExecuter sqlExe = new SQLExecuter("");
				
				insCnt = sqlExe.executeBatch((ISQLTemplate)new VesselScheduleMgtDBDAOAddVskVslSkdCSQL(), vskVslSkdVOs, null);
				
				for(int i=0; i<insCnt.length; i++){
					if(insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * VSK_VSL_SKD의 VVD 정보를 수정합니다.<br>
	 * 
	 * @param List<VskVslSkdVO> vskVslSkdVOs
	 * @exception DAOException
	 */
	public void modifyVskVslSkd(List<VskVslSkdVO> vskVslSkdVOs) throws DAOException {

		SQLExecuter sqlExe = new SQLExecuter("");
		
		try {
			int insCnt[] = null;
			if(vskVslSkdVOs != null && vskVslSkdVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new VesselScheduleMgtDBDAOModifyVskVslSkdUSQL(), vskVslSkdVOs, null);
				for(int i=0; i<insCnt.length; i++){
					if(insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * VVD Remark 정보를 수정합니다.<br>
	 * 
	 * @param List<VskVslSkdVO> vskVslSkdVOs
	 * @exception DAOException
	 */
	public void modifyVskVslSkdByRmk(List<VskVslSkdVO> vskVslSkdVOs) throws DAOException {

		SQLExecuter sqlExe = new SQLExecuter("");
		
		try {
			int insCnt[] = null;
			if(vskVslSkdVOs != null && vskVslSkdVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new VesselScheduleMgtDBDAOModifyVskVslSkdByRmkUSQL(), vskVslSkdVOs, null);
				for(int i=0; i<insCnt.length; i++){
					if(insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Actual SKD 삭제에 따른 Vessel Port Schedule 정보를 변경한다..<br>
	 * 
	 * @param List<VskVslPortSkdVO> vskVslPortSkdVOs
	 * @exception DAOException
	 */
	public void modifyVskVslPortSkdByActSkdDelelet(List<VskVslPortSkdVO> vskVslPortSkdVOs) throws DAOException {

		SQLExecuter sqlExe = new SQLExecuter("");
		
		try {
			int insCnt[] = null;
			if(vskVslPortSkdVOs != null && vskVslPortSkdVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new VesselScheduleMgtDBDAOModifyVskVslPortSkdByActSkdDeleletUSQL(), vskVslPortSkdVOs, null);
				for(int i=0; i<insCnt.length; i++){
					if(insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * 자동 Update 를 하기 위한 대상 목록 조회.
	 * 
	 * @param VskVslPortSkdVO vskVslPortSkdVO
	 * @return List<VskVslPortSkdVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<VskVslPortSkdVO> searchAutoSkdUpdate(VskVslPortSkdVO vskVslPortSkdVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<VskVslPortSkdVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if(vskVslPortSkdVO != null){
				Map<String, String> mapVO = vskVslPortSkdVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselScheduleMgtDBDAOSearchAutoSkdUpdateRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VskVslPortSkdVO .class);
		}catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return list;
	}
	
	/**
	 * Yard Call Ind Seq 를 생성.
	 * 
	 * @param List<VvdVO> vvdVOs
	 * @throws DAOException
	 */
	public void modifyYardCallSeq(List<VvdVO> vvdVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			if(vvdVOs.size() > 0){
				int inCnt = vvdVOs.size();
				for(int i=0; i<inCnt; i++){
					Map<String, String> mapVO = vvdVOs.get(i) .getColumnValues();
					
					param.putAll(mapVO);
					velParam.putAll(mapVO);
					
					int result = sqlExe.executeUpdate((ISQLTemplate)new VesselScheduleMgtDBDAOModifyYardCallSeqUSQL(), param, velParam);
					
					if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No "+ i + " SQL");
				}
			}
		}catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * VSK_VSL_SKD 정보를 삭제합니다.<br>
	 * 
	 * @param List<VskVslSkdVO> vskVslSkdVOs
	 * @exception DAOException
	 */
	public void removeVskVslSkd(List<VskVslSkdVO> vskVslSkdVOs) throws DAOException {

		SQLExecuter sqlExe = new SQLExecuter("");
		
		try {
			int insCnt[] = null;
			if(vskVslSkdVOs != null && vskVslSkdVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new VesselScheduleMgtDBDAORemoveVskVslSkdDSQL(), vskVslSkdVOs, null);
				for(int i=0; i<insCnt.length; i++){
					if(insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Port 정보를 검증합니다.<br>
	 * 
	 * @param String locCd
	 * @return String
	 * @exception DAOException
	 */
	public String checkPort(String locCd) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnFlag = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(VSKGeneralUtil.isNotNull(locCd)){
				param.put("loc_cd", locCd);
				velParam.put("loc_cd", locCd);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselScheduleMgtDBDAOCheckPortRSQL(), param, velParam);
			if(dbRowset != null){
				if(dbRowset.next()){
					rtnFlag = dbRowset.getString("FLAG");
				}
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return rtnFlag;
	}
	
	/**
	 * 첫번째 Port 인지 검사한다.<br>
	 * 
	 * @param VskVslPortSkdVO vskVslPortSkdVO
	 * @return String
	 * @exception DAOException
	 */
	public String checkFirstCallingPort(VskVslPortSkdVO vskVslPortSkdVO) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnFlag = "";
		
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(vskVslPortSkdVO != null){
				Map<String, String> mapVO = vskVslPortSkdVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselScheduleMgtDBDAOCheckFirstCallingPortRSQL(), param, velParam);
//			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VskVslPortSkdVO .class);
			if(dbRowset != null){
				if(dbRowset.next()){
					rtnFlag = dbRowset.getString("FLAG");
				}
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return rtnFlag;
	}
	
	/**
	 * CRR_CD 를 조회합니다.
	 * 
	 * @param String vslCd
	 * @return String
	 * @throws DAOException
	 */
	public String searchCarrierCode(String vslCd) throws DAOException {
		DBRowSet dbRowset = null;
		String crrCd = "";
		
		Map<String, Object> param = new HashMap<String, Object>();
		
		try{
			if(vslCd != null){
				param.put("vsl_cd", vslCd);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselScheduleMgtDBDAOSearchCarrierCodeRSQL(), param, null);
			if(dbRowset != null){
				if(dbRowset.next()){
					crrCd = dbRowset.getString("CRR_CD");
				}
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return crrCd;
	}
	
	/**
	 * MDM_VSL_CNTR 에서 SKD_STS_CD 를 조회해 온다.
	 * 
	 * @param String vslCd
	 * @return String
	 * @throws DAOException
	 */
	public String searchSkdStsCd(String vslCd) throws DAOException {
		DBRowSet dbRowset = null;
		String skdStsCd = "";
		
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(VSKGeneralUtil.isNotNull(vslCd)){
				param.put("vsl_cd", vslCd);
				velParam.put("vsl_cd", vslCd);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselScheduleMgtDBDAOSearchSkdStsCdRSQL(), param, velParam);
			if(dbRowset != null){
				if(dbRowset.next()){
					skdStsCd = dbRowset.getString("SKD_STS_CD");
				}
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return skdStsCd;
	}
	
	/**
	 * VVD 로 VSL_SLAN_DIR_SEQ 를 찾아온다.
	 * 
	 * @param VvdVO vvdVO
	 * @return List<MdmVslSvcLaneDirVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<MdmVslSvcLaneDirVO> searchSvcLaneDirByVvd(VvdVO vvdVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MdmVslSvcLaneDirVO> list = null;
		
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(vvdVO != null){
				Map<String, String> mapVO = vvdVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselScheduleMgtDBDAOSearchSvcLaneDirByVvdRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, MdmVslSvcLaneDirVO .class);
			}
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
	 * VVD Port Schedule 정보를 생성합니다.<br>
	 * 
	 * @param List<VslPortSkdVO> vslPortSkdVOs
	 * @exception DAOException
	 */
	public void addVskVslPortSkd(List<VslPortSkdVO> vslPortSkdVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(vslPortSkdVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new VesselScheduleMgtDBDAOAddVskVslPortSkdCSQL(), vslPortSkdVOs, null);
				
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * VVD Port Schedule 정보를 생성합니다.<br>
	 * 
	 * @param List<VslPortSkdVO> vslPortSkdVOs
	 * @exception DAOException
	 */
//	public void addVskVslPortSkdCoastalUpdate(List<VslPortSkdVO> vslPortSkdVOs) throws DAOException {
//		try {
//			SQLExecuter sqlExe = new SQLExecuter("");
//			int insCnt[] = null;
//			if(vslPortSkdVOs.size() > 0){
//				insCnt = sqlExe.executeBatch((ISQLTemplate)new VesselScheduleMgtDBDAOAddVskVslPortSkdForCoastalUpdateCSQL(), vslPortSkdVOs, null);
//				
//				for(int i = 0; i < insCnt.length; i++){
//					if(insCnt[i] == Statement.EXECUTE_FAILED)
//						throw new DAOException("Fail to insert No"+ i + " SQL");
//				}
//			}
//		} catch (SQLException se) {
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(se).getMessage(), se);
//		}catch(Exception ex){
//			log.error(ex.getMessage(),ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
//		}
//	}
	
	/**
	 * Virtual Port에 대한 VVD Port 정보를 조회합니다.<br>
	 * 
	 * @param VskVslPortSkdVO vskVslPortSkdVO
	 * @return List<VskVslPortSkdVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<VskVslPortSkdVO> searchVskVslPortSkdByVirtualPort(VskVslPortSkdVO vskVslPortSkdVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<VskVslPortSkdVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{
			if(vskVslPortSkdVO != null){
				Map<String, String> mapVO = vskVslPortSkdVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselScheduleMgtDBDAOSearchVskVslPortSkdByVirtualPortRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VskVslPortSkdVO .class);
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
	 * Port Schedule  상태를 수정합니다.<br>
	 * 
	 * @param List<VskVslPortSkdVO> vskVslPortSkdVOList
	 * @exception DAOException
	 */
	public void modifyVskVslPortSkdByActual(List<VskVslPortSkdVO> vskVslPortSkdVOList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(vskVslPortSkdVOList.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new VesselScheduleMgtDBDAOModifyVskVslPortSkdByActualUSQL(), vskVslPortSkdVOList, null);
				
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to modify No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * VVD Port Schedule 정보를 수정합니다.<br>
	 * 
	 * @param List<VslPortSkdVO> vslPortSkdVOs
	 * @exception DAOException
	 */
	public void modifyVskVslPortSkd(List<VslPortSkdVO> vslPortSkdVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			if(vslPortSkdVOs.size() > 0){
				int inCnt = vslPortSkdVOs.size();
				for(int i=0; i<inCnt; i++){
					Map<String, String> mapVO = vslPortSkdVOs.get(i) .getColumnValues();
					
					param.putAll(mapVO);
					velParam.putAll(mapVO);
					
					int result = sqlExe.executeUpdate((ISQLTemplate)new VesselScheduleMgtDBDAOModifyVskVslPortSkdUSQL(), param, velParam);
					
					if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No "+ i + " SQL");
				}
			}
		}catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * VVD Port Schedule 정보를 수정합니다.<br>
	 * 
	 * @param List<VskVslPortSkdVO> vskVslPortSkdVOs
	 * @throws DAOException
	 */
	public void modifyVskVslPortSkdByAutoUpdate(List<VskVslPortSkdVO> vskVslPortSkdVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			if(vskVslPortSkdVOs.size() > 0){
				int inCnt = vskVslPortSkdVOs.size();
				for(int i=0; i<inCnt; i++){
					Map<String, String> mapVO = vskVslPortSkdVOs.get(i) .getColumnValues();
					
					param.putAll(mapVO);
					velParam.putAll(mapVO);
					
					int result = sqlExe.executeUpdate((ISQLTemplate)new VesselScheduleMgtDBDAOModifyVskVslPortSkdByAutoUpdateUSQL(), param, velParam);
					
					if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No "+ i + " SQL");
				}
			}
		}catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * VVD Port Schedule 정보를 삭제합니다.<br>
	 * 
	 * @param List<VslPortSkdVO> vslPortSkdVOs
	 * @exception DAOException
	 */
	public void removeVskVslPortSkd(List<VslPortSkdVO> vslPortSkdVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(vslPortSkdVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new VesselScheduleMgtDBDAORemoveVskVslPortSkdDSQL(), vslPortSkdVOs, null);
				
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * VVD의 Virtual Port Schedule을 삭제.<br>
	 * Virtual Port 삭제 후 Clpt Seq 를 순차적으로 다시 생성.<br>
	 * 
	 * @param List<VskVslPortSkdVO> vskVslPortSkdVOs
	 * @exception DAOException
	 */
	public void removeVskVslPortSkdByVirtualPort(List<VskVslPortSkdVO> vskVslPortSkdVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(vskVslPortSkdVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new VesselScheduleMgtDBDAORemoveVskVslPortSkdByVirtualPortDSQL(), vskVslPortSkdVOs, null);
				
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete No"+ i + " SQL");
				}
				
				//Virtual Port Delete 후 Clpt Seq 를 순차적으로 다시 생성한다.
				insCnt = sqlExe.executeBatch((ISQLTemplate)new VesselScheduleMgtDBDAOModifyVskVslPortSkdByClptSeqUSQL(), vskVslPortSkdVOs, null);
				
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
				
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
//	/**
//	 * VesselScheduleMgtDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
//	 * CLPT_IND_SEQ 의 값을 생성한다.
//	 * 
//	 * @param vskVslPortSkdVO VskVslPortSkdVO
//	 * @return String
//	 * @exception DAOException
//	 */
//	@SuppressWarnings("unchecked")
//	public String searchNewClptIndSeq(VskVslPortSkdVO vskVslPortSkdVO) throws DAOException {
//		DBRowSet dbRowset = null;
////		List<VskVslPortSkdVO> list = null;
//		String clptIndSeq = "";
//		// query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
//		// velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();
//
//		try {
//			if (vskVslPortSkdVO != null) {
//				Map<String, String> mapVO = vskVslPortSkdVO.getColumnValues();
//
//				param.putAll(mapVO);
//				velParam.putAll(mapVO);
//			}
//			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new VesselScheduleMgtDBDAOSearchNewClptIndSeqRSQL(),	param, velParam);
//			dbRowset.next();
//			clptIndSeq = dbRowset.getString("CLPT_IND_SEQ");
//		} catch (SQLException se) {
//			log.error(se.getMessage(), se);
//			throw new DAOException(new ErrorHandler(se).getMessage(), se);
//		} catch (Exception ex) {
//			log.error(ex.getMessage(), ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
//		}
//		return clptIndSeq;
//	}
	
	/**
	 * Port Schedule의 TURN_CLPT_IND_SEQ 정보를 수정합니다.<br>
	 * 
	 * @param List<VskSwapCstPortVO> vskSwapCstPortVOs
	 * @exception DAOException
	 */
	public void modifyVskVslPortSkdByTurnPortClptIndSeq(List<VskSwapCstPortVO> vskSwapCstPortVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(vskSwapCstPortVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new VesselScheduleMgtDBDAOModifyVskVslPortSkdByTurnPortClptIndSeqUSQL(), vskSwapCstPortVOs, null);
				
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to modify No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * VVD이 Booking 상태를 검증합니다.<br>
	 * 
	 * @param List<VvdBkgStsVO> vvdBkgStsVOs
	 * @return List<VvdBkgStsVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<VvdBkgStsVO> checkBkgStsByVvd(List<VvdBkgStsVO> vvdBkgStsVOs)
			throws DAOException {
		DBRowSet dbRowset = null;
		List<VvdBkgStsVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			
			if(vvdBkgStsVOs != null){
				velParam.put("tgtVvd", vvdBkgStsVOs);
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new VesselScheduleMgtDBDAOVvdBkgStsVORSQL(),	param, velParam);
				list = (List) RowSetUtil.rowSetToVOs(dbRowset, VvdBkgStsVO.class);
			}else{
				list = new ArrayList<VvdBkgStsVO>();
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * VVD를 검증합니다.<br>
	 * 
	 * @param VskVslSkdVO vskVslSkdVO
	 * @return int
	 * @exception DAOException
	 */
	public int checkVvd(VskVslSkdVO vskVslSkdVO) throws DAOException {
		DBRowSet dbRowset = null;
		int rtnCnt = 0;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vskVslSkdVO != null){
				Map<String, String> mapVO = vskVslSkdVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselScheduleMgtDBDAOCheckVvdRSQL(), param, velParam);
			dbRowset.next();
			rtnCnt = dbRowset.getInt("CNT");
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	    return rtnCnt;
	}
	
	/**
	 * VVD History 정보를 생성합니다.<br>
	 * 
	 * @param List<VskVslSkdHisVO> vskVslSkdHisVOs
	 * @exception DAOException
	 */
	public void addVskVslSkdHis(List<VskVslSkdHisVO> vskVslSkdHisVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
//			int insCnt[] = null;
			if(vskVslSkdHisVOs.size() > 0){
				int inCnt = vskVslSkdHisVOs.size();
				for(int i=0; i<inCnt; i++){
					Map<String, String> mapVO = vskVslSkdHisVOs.get(i) .getColumnValues();
					
					param.putAll(mapVO);
					velParam.putAll(mapVO);
					
					int result = sqlExe.executeUpdate((ISQLTemplate)new VesselScheduleMgtDBDAOAddVskVslSkdHisCSQL(), param, null);
					
					if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No "+ i + " SQL");
				}
				
//				insCnt = sqlExe.executeBatch((ISQLTemplate)new VesselScheduleMgtDBDAOAddVskVslSkdHisCSQL(), vskVslSkdHisVOs, null);
//				
//				for(int i = 0; i < insCnt.length; i++){
//					if(insCnt[i] == Statement.EXECUTE_FAILED)
//						throw new DAOException("Fail to insert No"+ i + " SQL");
//				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * 입력된 VVD, Port 정보를 Booking System에서 사용하는지를 확인하고 Vessel Schedule 정보를 조회한다.
	 * 
	 * @param VslPortSkdVO vslPortSkdVO
	 * @return VslPortSkdVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public VslPortSkdVO checkVslSkdByRowID(VslPortSkdVO vslPortSkdVO) throws DAOException {
		
		DBRowSet 			dbRowset 	= null;
		List<VslPortSkdVO> 	list 		= null;
		VslPortSkdVO 		resultVO	= null;
		
		//query parameter
		Map<String, Object> param 		= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam 	= new HashMap<String, Object>();
	
		try{
			if(vslPortSkdVO != null){
				Map<String, String> mapVO = vslPortSkdVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselScheduleMgtDBDAOCheckVslSkdByRowIDRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VslPortSkdVO .class);

			if(list != null && list.size()>0){
				resultVO = list.get(0);
			}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return resultVO;
	}
	

	/**
	 * 입력된 VVD, Port 정보를 Booking System에서 사용하는지를 확인하고 Vessel Schedule 정보를 조회한다.
	 * 
	 * @param VslPortSkdVO vslPortSkdVO
	 * @return VslPortSkdVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public VslPortSkdVO checkVslSkdByRowID2(VslPortSkdVO vslPortSkdVO) throws DAOException {
		
		DBRowSet 			dbRowset 	= null;
		List<VslPortSkdVO> 	list 		= null;
		VslPortSkdVO 		resultVO	= null;
		
		//query parameter
		Map<String, Object> param 		= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam 	= new HashMap<String, Object>();
	
		try{
			if(vslPortSkdVO != null){
				Map<String, String> mapVO = vslPortSkdVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselScheduleMgtDBDAOCheckVslSkdByRowID2RSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VslPortSkdVO .class);

			if(list != null && list.size()>0){
				resultVO = list.get(0);
			}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return resultVO;
	}
	

	/**
	 * 입력된 VVD, Port 정보를 Booking System에서 사용하는지를 확인하고 Vessel Schedule 정보를 조회한다.
	 * 
	 * @param VslPortSkdVO vslPortSkdVO
	 * @return VslPortSkdVO
	 * @exception DAOException
	 */
//	@SuppressWarnings("unchecked")
//	public VslPortSkdVO checkVslSkdByRowID3(VslPortSkdVO vslPortSkdVO) throws DAOException {
//		
//		DBRowSet 			dbRowset 	= null;
//		List<VslPortSkdVO> 	list 		= null;
//		VslPortSkdVO 		resultVO	= null;
//		
//		//query parameter
//		Map<String, Object> param 		= new HashMap<String, Object>();
//		//velocity parameter
//		Map<String, Object> velParam 	= new HashMap<String, Object>();
//	
//		try{
//			if(vslPortSkdVO != null){
//				Map<String, String> mapVO = vslPortSkdVO .getColumnValues();
//			
//				param.putAll(mapVO);
//				velParam.putAll(mapVO);
//			}
//			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselScheduleMgtDBDAOCheckVslSkdByRowID3RSQL(), param, velParam);
//			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VslPortSkdVO .class);
//
//			if(list != null && list.size()>0){
//				resultVO = list.get(0);
//			}
//			
//		}catch(SQLException se){
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(se).getMessage(), se);
//		}catch(Exception ex){
//			log.error(ex.getMessage(),ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
//		}
//		return resultVO;
//	}
	
	/**
	 * 입력된 VVD, Port 정보를 Booking System에서 사용하는지를 확인하고 Vessel Schedule 정보를 조회한다.
	 * 
	 * @param VslPortSkdVO vslPortSkdVO
	 * @return List<VslPortSkdVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public VslPortSkdVO checkVslSkdByRowIDVirtualVVD(VslPortSkdVO vslPortSkdVO) throws DAOException {
		
		DBRowSet 			dbRowset 	= null;
		List<VslPortSkdVO> 	list 		= null;
		VslPortSkdVO 		resultVO	= null;
		
		//query parameter
		Map<String, Object> param 		= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam 	= new HashMap<String, Object>();
	
		try{
			if(vslPortSkdVO != null){
				Map<String, String> mapVO = vslPortSkdVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselScheduleMgtDBDAOCheckVslSkdByRowIDListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VslPortSkdVO .class);
			
			if(list != null && list.size()>0){
				resultVO = list.get(0);
			}

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return resultVO;
	}
	
	/**
	 * Swap Costal Schedule Simulation 정보를 조회합니다.<br>
	 * 
	 * @param SwapCstSkdSimVO swapCstSkdSimVO
	 * @return List<SwapCstSkdSimVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SwapCstSkdSimVO> searchCstSkdSrc(SwapCstSkdSimVO swapCstSkdSimVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SwapCstSkdSimVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{
			if(swapCstSkdSimVO != null){
				Map<String, String> mapVO = swapCstSkdSimVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselScheduleMgtDBDAOSwapCstSkdSimRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SwapCstSkdSimVO .class);
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
	 * 입력된 SIMULATION 정보와 COASTAL SCHEDULE간에 PK값에 변경이 발생했는지 확인한다.
	 * 
	 * @param VskSwapCstSimVO vskSwapCstSimVO
	 * @return List<String>
	 * @throws DAOException
	 */
	public List<String> searchCstSimDifference(VskSwapCstSimVO vskSwapCstSimVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<String> list = new ArrayList<String>();
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{
			if(vskSwapCstSimVO != null){
				Map<String, String> mapVO = vskSwapCstSimVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselScheduleMgtDBDAOSearchCstSimDifferenceRSQL(), param, velParam);
			if(dbRowset != null){
				while(dbRowset.next()){
					list.add(dbRowset.getString("CHK_CST_SIM"));
				}
			}
//			list = (List)RowSetUtil.rowSetToVOs(dbRowset, String .class);
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
	 * Simulation Schedule 정보에 입력된 Actual Schedule 정보를 조회한다.
	 * 
	 * @param VskSwapCstSimVO vskSwapCstSimVO
	 * @return List<ActualSkdBySimNoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ActualSkdBySimNoVO> searchActualSkdBySimNo(VskSwapCstSimVO vskSwapCstSimVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ActualSkdBySimNoVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{
			if(vskSwapCstSimVO != null){
				Map<String, String> mapVO = vskSwapCstSimVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselScheduleMgtDBDAOActualSkdBySimNoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ActualSkdBySimNoVO .class);
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
	 * Costal Schedule Simulation 정보를 조회합니다.<br>
	 * 
	 * @param SwapCstSkdSimVO swapCstSkdSimVO
	 * @return List<SwapCstSkdSimVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SwapCstSkdSimVO> searchCstSkdSim(SwapCstSkdSimVO swapCstSkdSimVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SwapCstSkdSimVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{
			if(swapCstSkdSimVO != null){
				Map<String, String> mapVO = swapCstSkdSimVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselScheduleMgtDBDAOSearchCstSkdSimRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SwapCstSkdSimVO .class);
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
	 * Port의 Costal Schedule 정보를 조회합니다.
	 * 
	 * @param VslPortSkdVO vslPortSkdVO
	 * @return VslPortSkdVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public VslPortSkdVO searchCstSkdByVvdPort(VslPortSkdVO vslPortSkdVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<VslPortSkdVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{
			if(vslPortSkdVO != null){
				Map<String, String> mapVO = vslPortSkdVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselScheduleMgtDBDAOSearchCstSkdByVvdPortRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VslPortSkdVO .class);
			if(list!=null && list.size()==1){
				return list.get(0);
			}else{
				return null;
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * 해당 Port의 Vessel Berth 정보를 조회합니다. 
	 * 
	 * @param CstSkdBerthWdoVO cstSkdBerthWdoVO
	 * @return List<CstSkdBerthWdoVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CstSkdBerthWdoVO> searchCstSkdBerthWdo(CstSkdBerthWdoVO cstSkdBerthWdoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CstSkdBerthWdoVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{
			if(cstSkdBerthWdoVO != null){
				Map<String, String> mapVO = cstSkdBerthWdoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				String ydCd = cstSkdBerthWdoVO.getYdCd();
				if (VSKGeneralUtil.isNotNull(ydCd)) {
					List<String> ydCdList = new ArrayList<String>();
					String[] ydCdArr = ydCd.split("\\,");
					if(ydCdArr != null && ydCdArr.length > 0){
						for(int i=0; i<ydCdArr.length; i++){
							ydCdList.add(ydCdArr[i]);
						}
						velParam.put("yd_cd", ydCdList);
					}
				}
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselScheduleMgtDBDAOCstSkdBerthWdoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CstSkdBerthWdoVO .class);
			
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
	 * Swap Costal Simulation 정보를 생성합니다.<br>
	 * 
	 * @param List<VskSwapCstSimVO> vskSwapCstSimVOs
	 * @exception DAOException
	 */
	public void addVskSwapCstSim(List<VskSwapCstSimVO> vskSwapCstSimVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(vskSwapCstSimVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new VesselScheduleMgtDBDAOAddVskSwapCstSimCSQL(), vskSwapCstSimVOs, null);
				
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Swap Costal VVD 정보를 생성합니다.<br>
	 * 
	 * @param List<VskSwapCstVvdVO> vskSwapCstVvdVOs
	 * @exception DAOException
	 */
	public void addVskSwapCstVvd(List<VskSwapCstVvdVO> vskSwapCstVvdVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(vskSwapCstVvdVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new VesselScheduleMgtDBDAOAddVskSwapCstVvdCSQL(), vskSwapCstVvdVOs, null);
				
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Swap Costal Port Schedule 정보를 생성합니다.<br>
	 * 
	 * @param List<VskSwapCstPortVO> vskSwapCstPortVOs
	 * @exception DAOException
	 */
	public void addVskSwapCstPort(List<VskSwapCstPortVO> vskSwapCstPortVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(vskSwapCstPortVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new VesselScheduleMgtDBDAOAddVskSwapCstPortCSQL(), vskSwapCstPortVOs, null);
				
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * PSO_VSL_CLSS_TRF 테이블에서 Port별 Port Expense 정보를 조회한다.
	 * 
	 * @param CstSkdSimDtlCalcInfoVO cstSkdSimDtlCalcInfoVO
	 * @return CstSkdSimDtlCalcInfoVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public CstSkdSimDtlCalcInfoVO searchPortExpenceByVessel(CstSkdSimDtlCalcInfoVO cstSkdSimDtlCalcInfoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CstSkdSimDtlCalcInfoVO> list = null;
		CstSkdSimDtlCalcInfoVO returnVO = null;
		
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{
			if(cstSkdSimDtlCalcInfoVO != null){
				Map<String, String> mapVO = cstSkdSimDtlCalcInfoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselScheduleMgtDBDAOSearchPortExpenceByVesselRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CstSkdSimDtlCalcInfoVO .class);
			if(list != null && list.size() > 0){
				returnVO = list.get(0);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return returnVO;
	}
	
	/**
	 * 두 Port간 거리 정보를 조회합니다.
	 * 
	 * @param String fmPortCd
	 * @param String toPortCd
	 * @return String
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public String searchVskPortDist(String fmPortCd, String toPortCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<VskPortDistVO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{
			if(fmPortCd != null && toPortCd != null){
				param.put("fm_loc_cd", fmPortCd);
				param.put("to_loc_cd", toPortCd);
				velParam.put("fm_loc_cd", fmPortCd);
				velParam.put("to_loc_cd", toPortCd);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselScheduleMgtDBDAOSearchVskPortDistRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VskPortDistVO .class);
			if(list!=null && list.size()==1){
				return list.get(0).getStndDist();
			}else{
				return null;
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * TES모쥴에 Terminal 비용 중 Re-Handling(20', 40') 단가 정보를 조회한다. 
	 * 
	 * @param CstSkdSimDtlCalcInfoVO cstSkdSimDtlCalcInfoVO
	 * @return CstSkdSimDtlCalcInfoVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public CstSkdSimDtlCalcInfoVO searchTmnlReHdlCost(CstSkdSimDtlCalcInfoVO cstSkdSimDtlCalcInfoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CstSkdSimDtlCalcInfoVO> list = null;
		CstSkdSimDtlCalcInfoVO returnVO = null;
		
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{
			if(cstSkdSimDtlCalcInfoVO != null){
				Map<String, String> mapVO = cstSkdSimDtlCalcInfoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselScheduleMgtDBDAOSearchTmnlReHdlCostRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CstSkdSimDtlCalcInfoVO .class);
			if(list != null && list.size() > 0){
				returnVO = list.get(0);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return returnVO;
	}
	
	/**
	 * 입력된 VVD 이전 VVD에 최근 TDR 정보를 이용한 Inbound 물량이 조회하고 있을 경우 평균 물량 정보를 조회합니다.
	 * 
	 * @param CstSkdSimDtlCalcInfoVO cstSkdSimDtlCalcInfoVO
	 * @return CstSkdSimDtlCalcInfoVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public CstSkdSimDtlCalcInfoVO searchCargoVolByBayPlan(CstSkdSimDtlCalcInfoVO cstSkdSimDtlCalcInfoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CstSkdSimDtlCalcInfoVO> list = null;
		CstSkdSimDtlCalcInfoVO returnVO = null;
		
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{
			if(cstSkdSimDtlCalcInfoVO != null){
				Map<String, String> mapVO = cstSkdSimDtlCalcInfoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselScheduleMgtDBDAOSearchCargoVolByBayPlanRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CstSkdSimDtlCalcInfoVO .class);
			if(list != null && list.size() > 0){
				returnVO = list.get(0);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return returnVO;
	}
	
	/**
	 * 입력된 VVD 이전 VVD에 최근 TDR 정보를 이용한 Inbound 물량이 조회하고 있을 경우 평균 물량 정보를 조회합니다.
	 * 
	 * @param CstSkdSimDtlCalcInfoVO cstSkdSimDtlCalcInfoVO
	 * @return CstSkdSimDtlCalcInfoVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public CstSkdSimDtlCalcInfoVO searchCargoVolByTDR(CstSkdSimDtlCalcInfoVO cstSkdSimDtlCalcInfoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CstSkdSimDtlCalcInfoVO> list = null;
		CstSkdSimDtlCalcInfoVO returnVO = null;
		
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{
			if(cstSkdSimDtlCalcInfoVO != null){
				Map<String, String> mapVO = cstSkdSimDtlCalcInfoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselScheduleMgtDBDAOSearchCargoVolByTDRRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CstSkdSimDtlCalcInfoVO .class);
			if(list != null && list.size() > 0){
				returnVO = list.get(0);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return returnVO;
	}
	
	/**
	 * POL, POD에 의한 Costal Schedule 정보를 조회합니다.<br>
	 * 
	 * @param CstSkdByPolPodVO cstSkdByPolPodVO
	 * @return List<CstSkdByPolPodVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CstSkdByPolPodVO> searchCstSkdByPolPod(CstSkdByPolPodVO cstSkdByPolPodVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CstSkdByPolPodVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (cstSkdByPolPodVO != null) {
				Map<String, String> mapVO = cstSkdByPolPodVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new VesselScheduleMgtDBDAOCstSkdByPolPodRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CstSkdByPolPodVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * 해당 Port의 Costal Schedule 정보를 조회합니다.<br>
	 * 
	 * @param CstSkdByPortVO cstSkdByPortVO
	 * @return List<CstSkdByPortVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CstSkdByPortVO> searchCstSkdByPort(CstSkdByPortVO cstSkdByPortVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CstSkdByPortVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (cstSkdByPortVO != null) {
				Map<String, String> mapVO = cstSkdByPortVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new VesselScheduleMgtDBDAOCstSkdByPortRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CstSkdByPortVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * Speed 변경 시 필요한 정보를 조회합니다.<br> 
	 * 
	 * @param CstSkdSimDtlCalcInfoVO cstSkdSimDtlCalcInfoVO
	 * @return CstSkdSimDtlCalcInfoVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public CstSkdSimDtlCalcInfoVO searchBunkerQtyBySpeed(CstSkdSimDtlCalcInfoVO cstSkdSimDtlCalcInfoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CstSkdSimDtlCalcInfoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if (cstSkdSimDtlCalcInfoVO != null) {
				Map<String, String> mapVO = cstSkdSimDtlCalcInfoVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new VesselScheduleMgtDBDAOSearchBunkerQtyBySpeedRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CstSkdSimDtlCalcInfoVO.class);
			if(list!=null && list.size()==1){
				return list.get(0);
			}else{
				return null;
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * 매뉴버링 관련 Port Schedule 정보를 조회합니다.<br>
	 * 
	 * @param CstSkdSimDtlCalcInfoVO cstSkdSimDtlCalcInfoVO
	 * @return CstSkdSimDtlCalcInfoVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public CstSkdSimDtlCalcInfoVO searchVskPortMnvrTimeZone (CstSkdSimDtlCalcInfoVO cstSkdSimDtlCalcInfoVO) throws DAOException {
		
		DBRowSet 						dbRowset 	= null;
		List<CstSkdSimDtlCalcInfoVO>	list		= null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			
			if (cstSkdSimDtlCalcInfoVO != null) {
				Map<String, String> mapVO = cstSkdSimDtlCalcInfoVO.getColumnValues();

				param.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new VesselScheduleMgtDBDAOSearchVskPortMnvrTimeZoneRSQL(), param, null);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CstSkdSimDtlCalcInfoVO.class);
			
			if(list!=null && list.size()==1){
				return list.get(0);
			}else{
				return null;
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * MDM Vessel CNTR 정보를 조회합니다.<br>
	 * 
	 * @param String vslCd
	 * @return MdmVslCntrVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public MdmVslCntrVO searchMdmVslCntr(String vslCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<MdmVslCntrVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if (vslCd != null) {
				param.put("vsl_cd", vslCd);
				velParam.put("vsl_cd", vslCd);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new VesselScheduleMgtDBDAOSearchMdmVslCntrRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, MdmVslCntrVO.class);
			if(list!=null && list.size()==1){
				return list.get(0);
			}else{
				return null;
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Time Zone 정보를 조회합니다.<br>
	 * 
	 * @param String portCd
	 * @return SwapCstSkdSimVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public SwapCstSkdSimVO searchTimeZone(String portCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<SwapCstSkdSimVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if (portCd != null) {
				param.put("loc_cd", portCd);
				velParam.put("loc_cd", portCd);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new VesselScheduleMgtDBDAOSearchTimeZoneRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SwapCstSkdSimVO.class);
			if(list!=null && list.size()==1){
				return list.get(0);
			}else{
				return null;
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Simulation No 정보를 조회합니다.<br>
	 * 
	 * @return VskSwapCstSimVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public VskSwapCstSimVO searchSimNo() throws DAOException {
		DBRowSet dbRowset = null;
		List<VskSwapCstSimVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new VesselScheduleMgtDBDAOSearchSimNoRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, VskSwapCstSimVO.class);
			if(list!=null && list.size()==1){
				return list.get(0);
			}else{
				return null;
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * VSL SKD history 정보를 조회해 온다.
	 * 
	 * @param VvdPortLaneOtherVO vvdPortLaneOtherVO
	 * @return List<VskVslSkdHisVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<VskVslSkdHisVO> searchCstSkdHisByVvd(VvdPortLaneOtherVO vvdPortLaneOtherVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<VskVslSkdHisVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if (vvdPortLaneOtherVO != null) {
				Map<String, String> mapVO = vvdPortLaneOtherVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new VesselScheduleMgtDBDAOSearchCstSkdHisByVvdRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, VskVslSkdHisVO.class);
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return list;
	}
	
	/**
	 * VSK_SWAP_CST_SIM TABLE을 UPDATE 한다.
	 * 
	 * @param VskSwapCstSimVO vskSwapCstSimVO
	 * @exception DAOException
	 */
	public void modifyVskSwapCstSim(VskSwapCstSimVO vskSwapCstSimVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			if(vskSwapCstSimVO != null){
				Map<String, String> mapVO = vskSwapCstSimVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new VesselScheduleMgtDBDAOModifyVskSwapCstSimUSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to modify SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * VSK_VSL_PORT_SKD TABLE UPDATE<br>
	 * Virtual Port 수정 시 해당 Port 수정
	 * 
	 * @param List<VskVslPortSkdVO> vskVslPortSkdVOs
	 * @exception DAOException
	 */
	public void modifyVskVslPortSkdByNextPort(List<VskVslPortSkdVO> vskVslPortSkdVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
//			//query parameter
//			Map<String, Object> param = new HashMap<String, Object>();
//			//velocity parameter
//			Map<String, Object> velParam = new HashMap<String, Object>();
//			
//			if(vskVslPortSkdVOs.size() > 0){
//				int inCnt = vskVslPortSkdVOs.size();
//				for(int i=0; i<inCnt; i++){
//					Map<String, String> mapVO = vskVslPortSkdVOs.get(i) .getColumnValues();
//					
//					param.putAll(mapVO);
//					velParam.putAll(mapVO);
//					
//					int result = sqlExe.executeUpdate((ISQLTemplate)new VesselScheduleMgtDBDAOModifyVskVslPortSkdByNextPortUSQL(), param, velParam);
//					
//					if(result == Statement.EXECUTE_FAILED)
//						throw new DAOException("Fail to update No "+ i + " SQL");
//				}
//			}
				
			int insCnt[] = null;
			if(vskVslPortSkdVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new VesselScheduleMgtDBDAOModifyVskVslPortSkdByNextPortUSQL(), vskVslPortSkdVOs, null);
				
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to modify No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * CNSHA Port 및 이전 Bound에 기항지 정보를 찾고 Bay Plan이 입력되는 Port를 조회한다.
	 * 
	 * @param VskVslPortSkdVO vskVslPortSkdVO
	 * @return List<VskVslPortSkdVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<VskVslPortSkdVO> searchBayPlanInputPort(VskVslPortSkdVO vskVslPortSkdVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<VskVslPortSkdVO> list = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if (vskVslPortSkdVO != null) {
				Map<String, String> mapVO = vskVslPortSkdVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new VesselScheduleMgtDBDAOSearchBayPlanInputPortRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, VskVslPortSkdVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * MDM_VSL_CNTR에서 VSL_CLASS, LIGHT_SHIP을 조회한다.
	 * 
	 * @param String vslCd
	 * @return MdmVslCntrVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public MdmVslCntrVO searchMdmVslCntrInfo(String vslCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<MdmVslCntrVO> list = null;
		MdmVslCntrVO mdmVslCntrVO = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if (vslCd != null && (!"".equals(vslCd))) {
				param.put("vsl_cd", vslCd);
				velParam.put("vsl_cd", vslCd);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new VesselScheduleMgtDBDAOSearchMdmVslCntrInfoRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, MdmVslCntrVO.class);
			
			if(list != null && list.size()>0) mdmVslCntrVO = list.get(0);
			
			return mdmVslCntrVO;
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	

	/**
	 * Departure Report에서 Fuel Oil, Diesel Oil, Fresh Water, Ballast 내용을 조회한다.
	 * 
	 * @param LoadWgtVO loadWgtVO
	 * @return VskDepRptVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public VskDepRptVO searchDeptureReport(LoadWgtVO loadWgtVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<VskDepRptVO> list = null;
		VskDepRptVO vskDepRptVO = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if (loadWgtVO != null) {
				Map<String, String> mapVO = loadWgtVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new VesselScheduleMgtDBDAOSearchDeptureReportRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, VskDepRptVO.class);
			
			if(list != null && list.size()>0) vskDepRptVO = list.get(0);
			
			return vskDepRptVO;
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * 입력 날짜에 해당하는 High Tide [Draft (at FW)] 값을 찾는다.
	 * 
	 * @param LoadWgtVO loadWgtVO
	 * @return VskPortTideVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public VskPortTideVO searchPortTide(LoadWgtVO loadWgtVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<VskPortTideVO> list = null;
		VskPortTideVO vskPortTideVO = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if (loadWgtVO != null) {
				Map<String, String> mapVO = loadWgtVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new VesselScheduleMgtDBDAOSearchPortTideRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, VskPortTideVO.class);
			
			if(list != null && list.size()>0) vskPortTideVO = list.get(0);
			
			return vskPortTideVO;
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * VSK_HYDRST_MTX 에서 TPC와 Displacement를 구한다.
	 * 
	 * @param String draft
	 * @param String vslCd
	 * @return VskHydrstMtxVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public VskHydrstMtxVO searchHydrstWgt(String draft, String vslCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<VskHydrstMtxVO> list = null;
		VskHydrstMtxVO vskHydrstMtxVO = new VskHydrstMtxVO();
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try {
			if (draft != null && vslCd != null) {
				param.put("draft", draft);
				param.put("vsl_cd", vslCd);

				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new VesselScheduleMgtDBDAOSearchHydrstWgtRSQL(), param, null);
				list = (List) RowSetUtil.rowSetToVOs(dbRowset, VskHydrstMtxVO.class);
			}
			
			if(list != null && list.size()>0) vskHydrstMtxVO = list.get(0);
			
			return vskHydrstMtxVO;
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * 입력된 VVD에 선사별 BSA(Basic Slot Allocation) 정보를 조회한다.
	 * 
	 * @param LoadWgtVO loadWgtVO
	 * @return List<LoadWgtVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<LoadWgtVO> searchCoaBsaByVvd(LoadWgtVO loadWgtVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<LoadWgtVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if (loadWgtVO != null) {
				Map<String, String> mapVO = loadWgtVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new VesselScheduleMgtDBDAOSearchCoaBsaByVvdRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, LoadWgtVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return list;
	}
	
//	/**
//	 * Long Range Schedule을 조회합니다.<br>
//	 * 
//	 * @param LongRangeSkdInqVO longRangeSkdInqVO
//	 * @return List<LongRangeSkdInqVO>
//	 * @exception DAOException
//	 */
//	public List<LongRangeSkdInqVO> searchLongRngSkd(LongRangeSkdInqVO longRangeSkdInqVO) throws DAOException {
//		DBRowSet dbRowset = null;
//		List<LongRangeSkdInqVO> list = null;
//		//query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
//		//velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();
//		
//		try {
//			if (longRangeSkdInqVO != null) {
//				Map<String, String> mapVO = longRangeSkdInqVO.getColumnValues();
//	
//				param.putAll(mapVO);
//				velParam.putAll(mapVO);
//			}
//			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new VesselScheduleMgtDBDAOLongRangeSkdInqRSQL(), param, velParam);
//			list = (List) RowSetUtil.rowSetToVOs(dbRowset, LongRangeSkdInqVO.class);
//			
//		} catch (SQLException se) {
//			log.error(se.getMessage(), se);
//			throw new DAOException(new ErrorHandler(se).getMessage(), se);
//		} catch (Exception ex) {
//			log.error(ex.getMessage(), ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
//		}
//		
//		return list;
//	}
//	
//	/**
//	 * KL-Net EDI : 헤더정보를 가져온다.
//	 * 
//	 * @param  String klnet
//	 * @return String 
//	 * @exception DAOException
//	 */
//	public String searchEdiHdVslSkdCstSkdBerthWdo(String klnet) throws DAOException {
//		DBRowSet dbRowset = null;
//		String header = null;
//		//query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
//		//velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();
//	
//		param.put("klnet", klnet);
//		velParam.put("klnet", klnet);
//		
//		try{
//			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselScheduleMgtDBDAOSearchEdiHdVslSkdCstSkdBerthWdoRSQL(), param, velParam);
//			dbRowset.next();
//			header = dbRowset.getString(1);
//			return header;
//		}catch(SQLException se){
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(se).getMessage(), se);
//		}catch(Exception ex){
//			log.error(ex.getMessage(),ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
//		}
//	}
	
//	/**
//	 * KL-Net EDI : 헤더정보를 가져온다.
//	 * 
//	 * @param  String klnet
//	 * @return String 
//	 * @exception DAOException
//	 */
//	public String searchEdiHdVslSkdCstSkdBerthWdo(String klnet) throws DAOException {
//		DBRowSet dbRowset = null;
//		String header = null;
//		//query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
//		//velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();
//	
//		param.put("klnet", klnet);
//		velParam.put("klnet", klnet);
//		
//		try{
//			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselScheduleMgtDBDAOSearchEdiHdVslSkdCstSkdBerthWdoRSQL(), param, velParam);
//			dbRowset.next();
//			header = dbRowset.getString(1);
//			return header;
//		}catch(SQLException se){
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(se).getMessage(), se);
//		}catch(Exception ex){
//			log.error(ex.getMessage(),ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
//		}
//	}
	
	/**
	 * Booking List 정보를 조회합니다.
	 * 
	 * @param String vslCd
	 * @param String skdVoyNo
	 * @param String skdDirCd
	 * @return List<BkgListByVvdVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgListByVvdVO> searchBkgListByVvd(String vslCd, String skdVoyNo, String skdDirCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgListByVvdVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if (vslCd != null && skdVoyNo != null && skdDirCd != null) {
				param.put("vsl_cd", vslCd);
				param.put("skd_voy_no", skdVoyNo);
				param.put("skd_dir_cd", skdDirCd);
				velParam.put("vsl_cd", vslCd);
				velParam.put("skd_voy_no", skdVoyNo);
				velParam.put("skd_dir_cd", skdDirCd);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new VesselScheduleMgtDBDAOBkgListByVvdVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgListByVvdVO.class);
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return list;
	}
	
	/**
	 * VVD의 Status 정보를 업데이트 합니다.
	 * 
	 * @param ActivationVvdVO[] activationVvdVOs
	 * @exception DAOException
	 */
	public void modifyVslSkdListByLane(ActivationVvdVO[] activationVvdVOs) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		
		List<ActivationVvdVO> list = Arrays.asList(activationVvdVOs);
		
		try {
			int insCnt[] = null;
			if(activationVvdVOs != null && activationVvdVOs.length > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new VesselScheduleMgtDBDAOModifyVslSkdStatusUSQL(), list, null);
				for(int i=0; i<insCnt.length; i++){
					if(insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * 해당 VVD 스케쥴을 Activate 처리합니다.
	 * 
	 * @param ActivationVvdVO activationVvdVO
	 * @exception DAOException
	 */
	public void manageSkdActivate(ActivationVvdVO activationVvdVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = activationVvdVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new VesselScheduleMgtDBDAOModifyVslSkdStatusActivateUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * [ESD061-0001] VMS 시스템에서 입력 받은 Noon Report를 생성한다.<br>
	 * 
	 * @param  VskNoonRptVO vskNoonRptVO
	 * @exception DAOException
	 */
	public void addVskNoonRpt(VskNoonRptVO vskNoonRptVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vskNoonRptVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new VesselScheduleMgtDBDAOAddVskNoonRptCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * VSK_NOON_RPT 데이터를 삭제한다.<br>
	 * 
	 * @param VskNoonRptVO vskNoonRptVO
	 * @return int
	 * @exception DAOException
	 */
	public int removeVskNoonRpt(VskNoonRptVO vskNoonRptVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			if(vskNoonRptVO != null){
				Map<String, String> mapVO = vskNoonRptVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new VesselScheduleMgtDBDAORemoveVskNoonRptDSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to remove SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	/**
	 * [ESD062-0001] VMS 시스템에서 입력 받은 Noon Report를 생성한다.<br>
	 * 
	 * @param  VskDepRptVO vskDepRptVO
	 * @exception DAOException
	 */
	public void addVskDepRpt(VskDepRptVO vskDepRptVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vskDepRptVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new VesselScheduleMgtDBDAOAddVskDepRptCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * VSK_DEPT_RPT 데이터를 삭제한다.<br>
	 * 
	 * @param VskDepRptVO vskDepRptVO
	 * @return int
	 * @exception DAOException
	 */
	public int removeVskDepRpt(VskDepRptVO vskDepRptVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			if(vskDepRptVO != null){
				Map<String, String> mapVO = vskDepRptVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new VesselScheduleMgtDBDAORemoveVskDeptRptDSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to remove SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	/**
	 * 운하별 통항 선박의 스케뷸 및 Surcharge를 조회합니다.
	 * 
	 * @param CanalTransitTargetVvdVO canalTransitTargetVvdVO
	 * @return List<CanalTransitTargetVvdVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CanalTransitTargetVvdVO> searchCanalTzList(CanalTransitTargetVvdVO canalTransitTargetVvdVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CanalTransitTargetVvdVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if(canalTransitTargetVvdVO != null){
				Map<String, String> mapVO = canalTransitTargetVvdVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselScheduleMgtDBDAOSearchCanalTzListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CanalTransitTargetVvdVO.class);
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
	 * 운하별 통항 선박의 스케뷸 및 Surcharge를 조회합니다.
	 * 
	 * @param List<CanalTransitTargetVvdVO> canalTransitTargetVvdVOs
	 * @return List<CanalTransitTargetVvdVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CanalTransitTargetVvdVO> searchCanalTzTierCalc(List<CanalTransitTargetVvdVO> canalTransitTargetVvdVOs) throws DAOException {
		
		DBRowSet dbRowset = null;
		List<CanalTransitTargetVvdVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if(canalTransitTargetVvdVOs != null){
				velParam.put("tgtVvd", canalTransitTargetVvdVOs);
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselScheduleMgtDBDAOSearchCanalTzTierCalcRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, CanalTransitTargetVvdVO.class);
			}else{
				list = new ArrayList<CanalTransitTargetVvdVO>();
			}
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
	 * 선박의 최대 선속으로 인한 Bunker 비용과 Canal Surcharge 비용 차이를 조회합니다.
	 * 
	 * @param CanalBnkSavVO canalBnkSavVO
	 * @return List<CanalBnkSavVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CanalBnkSavVO> calCanalBunkerSaving(CanalBnkSavVO canalBnkSavVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CanalBnkSavVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if(canalBnkSavVO != null){
				Map<String, String> mapVO = canalBnkSavVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselScheduleMgtDBDAOCalCanalBunkerSavingRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CanalBnkSavVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
//	/**
//	 * VVD에 정보가 변경 될 경우 ERP 시스템에 해당 정보를 전송하기 위한 데이터를 생성한다.
//	 * 
//	 * @param VvdVO vvdVO
//	 * @return List<ErpMsgFns017VO>
//	 * @exception DAOException
//	 */
//	@SuppressWarnings("unchecked")
//	public List<ErpMsgFns017VO> searchErpIfSendingData(VvdVO vvdVO) throws DAOException {
//		DBRowSet dbRowset = null;
//		List<ErpMsgFns017VO> list = null;
//		//query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
//		//velocity parameter
//		Map<String, Object> velParam = null;
//		
//		try {
//			if(vvdVO != null){
//				Map<String, String> mapVO = vvdVO.getColumnValues();
//			
//				param.putAll(mapVO);
//			}
//			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselScheduleMgtDBDAOSearchErpIfSendingDataRSQL(), param, velParam);
//			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ErpMsgFns017VO.class);
//		}catch(SQLException se){
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(se).getMessage(), se);
//		}catch(Exception ex){
//			log.error(ex.getMessage(),ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
//		}
//		return list;
//	}
	
	/**
	 * Flat File 헤더에 붙일 내용을 생성한다.<br>
	 * 
	 * @return String
	 * @exception DAOException
	 * @author 
	 */
	public String searchEdiHdToDLS() throws DAOException {
		DBRowSet dbRowset = null;
		String rtnHeader = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselScheduleMgtDBDAOSearchEdiHdToDLSRSQL(), param, velParam);
			if(dbRowset != null){
				if(dbRowset.next()){
					rtnHeader = dbRowset.getString("HEADER");
				}
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return rtnHeader;
	}
	
	/**
	 * VVD에 정보가 변경 될 경우 ERP 시스템에 해당 정보를 전송하기 위한 데이터를 생성한다.
	 * 
	 * @param VvdVO vvdVO
	 * @return List<EdiMsgToDLSVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<EdiMsgToDLSVO> searchEdiMsgToDLS(VvdVO vvdVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<EdiMsgToDLSVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = null;
		
		try {
			if(vvdVO != null){
				Map<String, String> mapVO = vvdVO.getColumnValues();
			
				param.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselScheduleMgtDBDAOSearchEdiMsgToDLSRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, EdiMsgToDLSVO.class);
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
	 * EDI 전문 HEADER 부분에 붙을 식별자를 생성한다.<br>
	 * 
	 * @return String 
	 * @exception DAOException
	 */
	public String searchEdiHdSeqToKlnet() throws DAOException {
		DBRowSet dbRowset = null;
		String headerSeq = null;
		//query parameter
		//Map<String, Object> param = null;
		//velocity parameter
		//Map<String, Object> velParam = null;
		
		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselScheduleMgtDBDAOSearchEdiHdSeqToKlnetRSQL(), null, null);
			if(dbRowset != null){
				if(dbRowset.next()){
					headerSeq = dbRowset.getString("HEADERSEQ");
				}
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return headerSeq;
	}
	
	/*
	 * CHM-201006264-01 Session User ID 설정로직 변경 getUpd_Usr_id() -> getUsr_id()
	 */
	/**
	 * VSK_CUST_EDI_LOG 테이블 KL-net EDI 전송 메세지를 Log 생성.<br>
	 * 
	 * @param CstSkdBerthWdoVO cstSkdBerthWdoVO
	 * @param SignOnUserAccount account
	 * @exception DAOException{
	 */
	public void addVskCustEdiLogToKlnet(CstSkdBerthWdoVO cstSkdBerthWdoVO, SignOnUserAccount account) throws DAOException{
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = null;
		try {
			if(cstSkdBerthWdoVO != null){
				Map<String, String> mapVO = cstSkdBerthWdoVO.getColumnValues();
				
				param.putAll(mapVO);
				
				//CHM-201006264-01 
//				param.put("upd_usr_id", account.getUpd_usr_id());
				param.put("upd_usr_id", account.getUsr_id());
				param.put("usr_id", account.getUsr_id());
				param.put("usr_nm", account.getUsr_nm());
				param.put("mphn_no", account.getMphn_no());
				param.put("fax_no", account.getFax_no());
				param.put("usr_eml", account.getUsr_eml());

			}
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new VesselScheduleMgtDBDAOAddVskCustEdiLogToKlnetCSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
//	/**
//	 * EDI 전문 HEADER 부분을 생성한다..<br>
//	 * 
//	 * @param String headerSeq
//	 * @return String
//	 * @exception DAOException
//	 */
//	public String searchEdiHdToKlnet(String headerSeq) throws DAOException {
//		DBRowSet dbRowset = null;
//		String header = null;
//		//query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
//		//velocity parameter
//		Map<String, Object> velParam = null;
//		
//		try{
//			if(VSKGeneralUtil.isNotNull(headerSeq)){
//				param.put("headerSeq", headerSeq);
//
//			}
//			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselScheduleMgtDBDAOSearchEdiHdToKlnetRSQL(), param, velParam);
//			if(dbRowset != null){
//				if(dbRowset.next()){
//					header = dbRowset.getString("HEADER");
//				}
//			}
//		}catch(SQLException se){
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(se).getMessage(), se);
//		}catch(Exception ex){
//			log.error(ex.getMessage(),ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
//		}
//		return header;
//	}
//	
//	/**
//	 * KL-NET에 전송한 EDI MESSAGE를 반환한다.<br>
//	 * 
//	 * @param cstSkdBerthWdoVO CstSkdBerthWdoVO 
//	 * @return String
//	 * @exception DAOException
//	 */
//	public String searchEdiMsgToKlnet(CstSkdBerthWdoVO cstSkdBerthWdoVO) throws DAOException {
//		DBRowSet dbRowset = null;
//		String message = null;
//		//query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
//		//velocity parameter
//		Map<String, Object> velParam = null;
//		
//		try{
//			if(cstSkdBerthWdoVO != null){
//				Map<String, String> mapVO = cstSkdBerthWdoVO .getColumnValues();
//			
//				param.putAll(mapVO);
//			}
//			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselScheduleMgtDBDAOSearchEdiMsgToKlnetRSQL(), param, velParam);
//			if(dbRowset != null){
//				if(dbRowset.next()){
//					message = dbRowset.getString("MSG_ALL");
//				}
//			}
//		}catch(SQLException se){
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(se).getMessage(), se);
//		}catch(Exception ex){
//			log.error(ex.getMessage(),ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
//		}
//		return message;
//	}
//	
//	/**
//	 * 신항(KRPUSHN) 보낼 EDI 전문 HEADER 부분을 생성한다.<br>
//	 * 
//	 * @param String headerSeq
//	 * @return String
//	 * @exception DAOException
//	 */
//	public String searchEdiHdToKRPUSHN(String headerSeq) throws DAOException {
//		DBRowSet dbRowset = null;
//		String header = null;
//		//query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
//		//velocity parameter
//		Map<String, Object> velParam = null;
//		
//		try{
//			if(VSKGeneralUtil.isNotNull(headerSeq)){
//				param.put("headerSeq", headerSeq);
//
//			}
//			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselScheduleMgtDBDAOSearchEdiHdToKRPUSHNRSQL(), param, velParam);
//			if(dbRowset != null){
//				if(dbRowset.next()){
//					header = dbRowset.getString("HEADER");
//				}
//			}
//		}catch(SQLException se){
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(se).getMessage(), se);
//		}catch(Exception ex){
//			log.error(ex.getMessage(),ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
//		}
//		return header;
//	}
	
	/**
	 * Vessel Port Schedule 테이블 Update 한다.<br>
	 * 
	 * @param CstSkdBerthWdoVO cstSkdBerthWdoVO
	 * @exception DAOException
	 */
	public void modifyVskVslPortSkdSendEdiCount(CstSkdBerthWdoVO cstSkdBerthWdoVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			if(cstSkdBerthWdoVO != null){
				Map<String, String> mapVO = cstSkdBerthWdoVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new VesselScheduleMgtDBDAOModifyVskVslPortSkdSendEdiCountUSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * VVD 정보의 P/F Type 정보를 수정합니다.<br>
	 * 
	 * @param List<ActivationVvdVO> activationVvdVOs
	 * @exception DAOException
	 * @author Hyuk Ryu
	 * @date 2009. 11. 11.
	 */
	public void manageVvdPf(List<ActivationVvdVO> activationVvdVOs) throws DAOException {
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(activationVvdVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new VesselScheduleMgtDBDAOModifyVskVslSkdPfTypeUSQL(), activationVvdVOs, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}		
	}
	
	/**   
	 * PORT의 PORT_BUF_HRS를 조회한다.
	 * 
	 * @param String vpsPortCd
	 * @return String
	 * @exception DAOException
	 */
	public String searchPortBufHrs(String vpsPortCd) throws DAOException {
		DBRowSet dbRowset = null;
		String portBufHrs = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = null;
		
		try{
			param.put("vps_port_cd", vpsPortCd);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselScheduleMgtDBDAOSearchPortBufHrsRSQL(), param, null);
			if(dbRowset != null){
				if(dbRowset.next()){
					portBufHrs = dbRowset.getString("PORT_BUF_HRS");
				}
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return portBufHrs;
	}
	
//	/**
//	 * VSK-0012
//	 * 
//	 * @param vskVslPortSkdVO 데이타 모델
//	 * @return List<VskVslPortSkdVO>
//	 * @exception DAOException
//	 */
//	@SuppressWarnings("unchecked")
//	public List<VskVslPortSkdVO> searchVskVslPortSkd(VskVslPortSkdVO vskVslPortSkdVO) throws DAOException {
//		DBRowSet dbRowset = null;
//		List<VskVslPortSkdVO> list = null;
//		//query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
//		//velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();
//	
//		try{
//			if(vskVslPortSkdVO != null){
//				Map<String, String> mapVO = vskVslPortSkdVO .getColumnValues();
//			
//				param.putAll(mapVO);
//				velParam.putAll(mapVO);
//			}
//			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselScheduleMgtDBDAOSearchVskVslPortSkdRSQL(), param, velParam);
//			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VskVslPortSkdVO.class);
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
	 * VSK PORT SKD를 조회한다.
	 * 
	 * @param PortSkdOnLongRangeVO portSkdOnLongRangeVO
	 * @return List<PortSkdOnLongRangeVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<PortSkdOnLongRangeVO> searchPortSkdOnLongRange(PortSkdOnLongRangeVO portSkdOnLongRangeVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PortSkdOnLongRangeVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{
			if(portSkdOnLongRangeVO != null){
				Map<String, String> mapVO = portSkdOnLongRangeVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselScheduleMgtDBDAOPortSkdOnLongRangeRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PortSkdOnLongRangeVO.class);
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
	 * @param PfSkdDetailVO pfSkdDetailVO
	 * @return List<PfSkdDetailVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<PfSkdDetailVO> searchPfSkdDetail(PfSkdDetailVO pfSkdDetailVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PfSkdDetailVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{
			if(pfSkdDetailVO != null){
				Map<String, String> mapVO = pfSkdDetailVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselScheduleMgtDBDAOSearchPfSkdDetailRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PfSkdDetailVO.class);
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
//	 * EDI011-0001 : Receive<br>
//	 * modifyEsdSettingReceiveJMS<br>
//	 * @param  List<VskCustSkdEdiSetVO> vskCustSkdEdiSetVOs
//	 * @exception EventException
//	 */
//	public void modifyEsdSettingReceiveJMS(List<VskCustSkdEdiSetVO> vskCustSkdEdiSetVOs ) throws DAOException, Exception {
//		try {
//			SQLExecuter sqlExe = new SQLExecuter("");
//			int updCnt1[] = null;
//			if (vskCustSkdEdiSetVOs .size() > 0) {
//				
//				//1	CUST_TRD_PRNR_ID 기준으로 기존 값이 있다면 나머지 CUST_TRD_PRNR_ID 는 모두 'N'으로 업데이트 한다 차후 EXISTS 로 수정
//				updCnt1 = sqlExe.executeBatch(
//						(ISQLTemplate) new VesselScheduleMgtDBDAOVskCustTrdPrnrIDCSQL(),
//						vskCustSkdEdiSetVOs , null);
//				for (int i = 0; i < updCnt1.length; i++) {
//					if (updCnt1[i] == Statement.EXECUTE_FAILED)
//						throw new DAOException("Fail to insert No" + i + " SQL");
//				}
//			}
//		} catch (SQLException se) {
//			log.error(se.getMessage(), se);
//			throw new DAOException(new ErrorHandler(se).getMessage(), se);
//		} catch (Exception ex) {
//			log.error(ex.getMessage(), ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
//		}
//	}
	
//	/**
//	 * EDI011-0001 : Receive<br>
//	 * addEsdSettingReceiveJMS<br>
//	 * @param  List<VskCustSkdEdiSetVO> vskCustSkdEdiSetVOs
//	 * @exception EventException
//	 */
//	public void addEsdSettingReceiveJMS(List<VskCustSkdEdiSetVO> vskCustSkdEdiSetVOs ) throws DAOException, Exception {
//		try {
//			SQLExecuter sqlExe = new SQLExecuter("");
//			int updCnt2[] = null;
//			if (vskCustSkdEdiSetVOs .size() > 0) {
//				//2	EDI_STUP_ID 기준으로 EDI_STUP_ID 기준으로 U, D이면 USE_FLG를 Y, D로 업데이트 일치하지 않는다면 INSERT
//				updCnt2 = sqlExe.executeBatch(
//								(ISQLTemplate) new VesselScheduleMgtDBDAOVskCustSkdEditSetCSQL(),
//								vskCustSkdEdiSetVOs , null);
//				for (int i = 0; i < updCnt2.length; i++) {
//					if (updCnt2[i] == Statement.EXECUTE_FAILED)
//						throw new DAOException("Fail to insert No" + i + " SQL");
//				}
//			}
//		} catch (SQLException se) {
//			log.error(se.getMessage(), se);
//			throw new DAOException(new ErrorHandler(se).getMessage(), se);
//		} catch (Exception ex) {
//			log.error(ex.getMessage(), ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
//		}
//	}
	
	/**
	 * 삭제된 VVD에 대한 History를 남긴다.
	 * 
	 * @param VskVslSkdHisVO vskVslSkdHisVO
	 * @throws DAOException
	 */
	public void addVskVslSkdDelHis(VskVslSkdHisVO vskVslSkdHisVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vskVslSkdHisVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new VesselScheduleMgtDBDAOAddVskVslSkdDelHisCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	
	
	/**
	 * VVD Port Schedule 정보를 수정합니다.<br>
	 * 
	 * @param List<VslPortSkdVO> vslPortSkdVOs
	 * @exception DAOException
	 */
	public void modifyVskVslPortSkdDataOnly(List<VslPortSkdVO> vslPortSkdVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			if(vslPortSkdVOs.size() > 0){
				int inCnt = vslPortSkdVOs.size();
				for(int i=0; i<inCnt; i++){
					Map<String, String> mapVO = vslPortSkdVOs.get(i) .getColumnValues();
					
					param.putAll(mapVO);
					velParam.putAll(mapVO);
					
					int result = sqlExe.executeUpdate((ISQLTemplate)new VesselScheduleMgtDBDAOModifyVskVslPortDataOnlyUSQL(), param, velParam);
					
					if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No "+ i + " SQL");
				}
			}
		}catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * VSK_CUST_EDI_LOG 정보를 등록합니다.
	 * 
	 * @param VskCustEdiLogVO vskCustEdiLogVO
	 * @exception DAOException
	 */
	public void addVskCustEdiLogToDLS(VskCustEdiLogVO vskCustEdiLogVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vskCustEdiLogVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			new SQLExecuter("").executeUpdate((ISQLTemplate)new VesselScheduleMgtDBDAOAddVskCustEdiLogVOCSQL(), param, velParam);
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/*
	 * CHM-201007135-01
	 */
	/**
	 * VOP_VSK_0018 : crr_cd 입력시 체크
	 * @param String crrCd
	 * @return String
	 * @exception DAOException
	 */
	public String searchCrrCd(String crrCd) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		String strRet = null;
		try {
			if(crrCd != null){
				param.put("crr_cd", crrCd);
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselScheduleMgtDBDAOSearchCrrCdRSQL(), param, null);
				if(dbRowset.next())
					strRet = dbRowset.getString(1);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return strRet;
	}
	
	/**
	 * ACTUAL PORT SKD를 CHECK<br>
	 * 
	 * @param VslPortSkdVO vslPortSkdVO
	 * @return int
	 * @exception DAOException
	 */
	public int checkVskActPortSkd(VslPortSkdVO vslPortSkdVO) throws DAOException {
		DBRowSet dbRowset = null;
		int rtnCnt = 0;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vslPortSkdVO != null){
				Map<String, String> mapVO = vslPortSkdVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselScheduleMgtDBDAOCheckVskActPortSkdRSQL(), param, velParam);
			dbRowset.next();
			rtnCnt = dbRowset.getInt("CNT");
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	    return rtnCnt;
	}
	
	
	/**
	 * Creation for Vessel Schedule History withou Bookings<br>
	 * 
	 * @param VslSkdXtraHisVO vslSkdXtraHisVO
	 * @exception DAOException
	 */
	public void createVesselScheduleExtraChangeHistory(VslSkdXtraHisVO vslSkdXtraHisVO) throws DAOException {
		
		SQLExecuter sqlExe = new SQLExecuter("");
		
		//query parameter
		Map<String, Object> 	param 		= new HashMap<String, Object>();
		
		try {
			
			Map<String, String> mapVO = vslSkdXtraHisVO.getColumnValues();
			
			param.putAll(mapVO);
			sqlExe.executeUpdate((ISQLTemplate)new VesselScheduleMgtDBDAOVesselScheduleExtraChangeHistoryCSQL(), param, null);
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	
	/**
	 * VSK_VSL_SKD_HIS_VVD_SEQ.NEXTVAL
	 * 
	 * @return String
	 * @throws DAOException
	 */
	public String createVesselScheduleOverallChangeHistorySequence() throws DAOException {
		
		DBRowSet 	dbRowset 	= null;
		String		sRtnValue	= null;
		
		try{			
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselScheduleMgtDBDAOCreateVesselScheduleOverallChangeHistorySequenceRSQL(), null, null);
			if(dbRowset.next()) sRtnValue = dbRowset.getString(1);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return sRtnValue;
	}
	
	/**
	 * Creation for Vessel Schedule History withou Bookings<br>
	 * 
	 * @param VslSkdCngHisDtlVO vslSkdCngHisDtlVO
	 * @exception DAOException
	 */
	public void createVesselScheduleOverallChangeHistory(VslSkdCngHisDtlVO vslSkdCngHisDtlVO) throws DAOException {
		
		SQLExecuter sqlExe = new SQLExecuter("");
		
		//query parameter
		Map<String, Object> 	param 		= new HashMap<String, Object>();
		
		try {
			
			Map<String, String> mapVO = vslSkdCngHisDtlVO.getColumnValues();
			
			param.putAll(mapVO);
			sqlExe.executeUpdate((ISQLTemplate)new VesselScheduleMgtDBDAOCreateVesselScheduleOverallChangeHistoryCSQL(), param, null);
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Creation for Vessel Schedule History withou Bookings<br>
	 * 
	 * @param VslSkdCngHisDtlVO vslSkdCngHisDtlVO
	 * @exception DAOException
	 */
	public void createVesselScheduleOverallChangeHistoryForDeletionOnly(VslSkdCngHisDtlVO vslSkdCngHisDtlVO) throws DAOException {
		
		SQLExecuter sqlExe = new SQLExecuter("");
		
		//query parameter
		Map<String, Object> 	param 		= new HashMap<String, Object>();
		
		try {
			
			Map<String, String> mapVO = vslSkdCngHisDtlVO.getColumnValues();
			
			param.putAll(mapVO);
			sqlExe.executeUpdate((ISQLTemplate)new VesselScheduleMgtDBDAOCreateVesselScheduleOverallChangeHistoryForDeletionOnlyCSQL(), param, null);
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Creation for Vessel Schedule History withou Bookings<br>
	 * 
	 * @param VslSkdCngHisDtlVO vslSkdCngHisDtlVO
	 * @exception DAOException
	 */
	public void createVesselScheduleOverallChangeHistoryDetail(VslSkdCngHisDtlVO vslSkdCngHisDtlVO) throws DAOException {
		
		SQLExecuter sqlExe = new SQLExecuter("");
		
		//query parameter
		Map<String, Object> 	param 		= new HashMap<String, Object>();
		
		try {
			
			Map<String, String> mapVO = vslSkdCngHisDtlVO.getColumnValues();
			
			param.putAll(mapVO);
			sqlExe.executeUpdate((ISQLTemplate)new VesselScheduleMgtDBDAOCreateVesselScheduleOverallChangeHistoryDetailCSQL(), param, null);
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 *  Counting Virtual Add Calling Port<br>
	 * 
	 * @param VslPortSkdVO virtualPortVO
	 * @return int
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
    public int searchVirtualAddCallPortCount(VslPortSkdVO virtualPortVO) throws DAOException {
		
		DBRowSet 	dbRowset 	= null;
        int			rtnValue	= 0;
        
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(virtualPortVO != null){
				Map<String, String> mapVO = virtualPortVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselScheduleMgtDBDAOSearchVirtualAddCallPortCountRSQL(), param, null);
			if(dbRowset.next()){
				rtnValue	= Integer.parseInt(dbRowset.getString("KNT"));
			}

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	    return rtnValue;
	}
	 
	

	/**
	 * Virtual Add Calling Port 포함된 VVD의 CLPT_SEQ 업데이트.<br>
	 * 
	 * @param VslPortSkdVO vslPortSkdVO
	 * @exception DAOException
	 */
	public void correctClptSeqforVirtualAddCallOnly(VslPortSkdVO vslPortSkdVO) throws DAOException {
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		int result = 0;
		try {
			
			if(vslPortSkdVO != null){
				Map<String, String> mapVO = vslPortSkdVO.getColumnValues();
			
				param.putAll(mapVO);
			}
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new VesselScheduleMgtDBDAOUpdateClptSeqforVirtualAddCallOnlyUSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED){
					throw new DAOException("Fail to remove SQL");
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * VVD 데이터 조회한다.<br>
	 * 
	 * @param VskVslSkdVO vo
	 * @return VskVslSkdVO
	 * @exception DAOException
	 */
	public VskVslSkdVO searchVskVslSkdByVVD2(VskVslSkdVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		List<VskVslSkdVO> list = null;
		VskVslSkdVO value = null;
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselScheduleMgtDBDAOSearchVskVslSkdByVVDRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VskVslSkdVO .class);
			if(list != null && list.size() > 0) {
				value = list.get(0);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return value;
	}
	
	/**
	 * VVD 데이터 조회한다.<br>
	 * 
	 * @param VskVslSkdVO vo
	 * @return List<VskVslSkdVO>
	 * @exception DAOException
	 */
	public List<VskVslSkdVO> searchVskVslSkdByVVD(VskVslSkdVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		List<VskVslSkdVO> list = null;
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselScheduleMgtDBDAOSearchVskVslSkdByVVDRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VskVslSkdVO .class);

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
	 * VVD 데이터 조회한다.<br>
	 * 
	 * @param VskVslPortSkdVO vo
	 * @return List<VskVslPortSkdVO>
	 * @exception DAOException
	 */
	public List<VskVslPortSkdVO> searchVskVslPortSkdByVVD(VskVslPortSkdVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		List<VskVslPortSkdVO> list = null;
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselScheduleMgtDBDAOSearchVskVslPortSkdByVVDRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VskVslPortSkdVO .class);
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
	 *  Counting Virtual Add Calling Port<br>
	 * 
	 * @param CstSkdByVvdVO cstSkdByVvdVO
	 * @return boolean
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
    public boolean checkFirstDirForLane(CstSkdByVvdVO cstSkdByVvdVO) throws DAOException {
		
		DBRowSet 	dbRowset 	= null;
        boolean		isRtnValue	= false;
        
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(cstSkdByVvdVO != null){
				Map<String, String> mapVO = cstSkdByVvdVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselScheduleMgtDBDAOCheckFirstDirForLaneRSQL(), param, null);
			if(dbRowset.next()){
				if(Integer.parseInt(dbRowset.getString("KNT"))>0){
					isRtnValue	= true;
				}
			}

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	    return isRtnValue;
	}
	
	

	/**
	 *  Counting Virtual Add Calling Port<br>
	 * 
	 * @param CstSkdByVvdVO cstSkdByVvdVO
	 * @return boolean
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
    public boolean checkFinalYardForSecondDir(CstSkdByVvdVO cstSkdByVvdVO) throws DAOException {
		
		DBRowSet 	dbRowset 	= null;
        boolean		isRtnValue	= false;
        
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(cstSkdByVvdVO != null){
				Map<String, String> mapVO = cstSkdByVvdVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselScheduleMgtDBDAOCheckFinalYardForSecondDirRSQL(), param, null);
			if(dbRowset.next()){
				if(Integer.parseInt(dbRowset.getString("KNT"))>0){
					isRtnValue	= true;
				}
			}

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	    return isRtnValue;
	}
	
	/**
	 *  Counting Virtual Add Calling Port<br>
	 * 
	 * @param CstSkdByVvdVO cstSkdByVvdVO
	 * @return boolean
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
    public boolean checkFinalYardForSecondDir2(CstSkdByVvdVO cstSkdByVvdVO) throws DAOException {
		
		DBRowSet 	dbRowset 	= null;
        boolean		isRtnValue	= false;
        
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(cstSkdByVvdVO != null){
				Map<String, String> mapVO = cstSkdByVvdVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselScheduleMgtDBDAOCheckFinalYardForSecondDir2RSQL(), param, null);
			if(dbRowset.next()){
				if(Integer.parseInt(dbRowset.getString("KNT"))>0){
					isRtnValue	= true;
				}
			}

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	    return isRtnValue;
	}
	
	//2016-01-15 VIPS START
	/**
	 * 마지막 Virtual Port 와  Connected 첫 번째 Port VVD 데이터 조회한다.<br>
	 * 
	 * @param VskVslPortSkdVO port
	 * @return List<VskVslPortSkdVO>
	 * @exception DAOException
	 */
	public List<VskVslPortSkdVO> searchConnectedVirtualPort(VskVslPortSkdVO port) throws DAOException {
		DBRowSet dbRowset = null;
		List<VskVslPortSkdVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(port != null){
				Map<String, String> mapVO = port.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselScheduleMgtDBDAOSearchConnectedVirtualPortRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VskVslPortSkdVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	//2016-01-15 VIPS End


	//2016-01-18 VIPS START
	/**
	 * Turning VVD 데이터 조회한다.<br>
	 * 
	 * @param VskVslPortSkdVO port
	 * @return List<VskVslPortSkdVO>
	 * @exception DAOException
	 */ 
	public List<VskVslPortSkdVO> searchTurningVVD(VskVslPortSkdVO port) throws DAOException {
		DBRowSet dbRowset = null;
		List<VskVslPortSkdVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(port != null){
				Map<String, String> mapVO = port.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselScheduleMgtDBDAOSearchTurningVVDRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VskVslPortSkdVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	//2016-01-18 VIPS End
	
	/**
	 *  Counting Virtual Add Calling Port<br>
	 * 
	 * @param CstSkdByVvdVO cstSkdByVvdVO
	 * @return boolean
	 * @exception DAOException
	 */
//	@SuppressWarnings("unchecked")
//    public boolean checkFirstDirForVVD(CstSkdByVvdVO cstSkdByVvdVO) throws DAOException {
//		
//		DBRowSet 	dbRowset 	= null;
//        boolean		isRtnValue	= false;
//        
//		//query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
//		//velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();
//
//		try{
//			if(cstSkdByVvdVO != null){
//				Map<String, String> mapVO = cstSkdByVvdVO.getColumnValues();
//			
//				param.putAll(mapVO);
//				velParam.putAll(mapVO);
//			}
//			
//			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselScheduleMgtDBDAOCheckFirstDirForVVDRSQL(), param, null);
//			if(dbRowset.next()){
//				if(Integer.parseInt(dbRowset.getString("KNT"))>0){
//					isRtnValue	= true;
//				}
//			}
//
//		}catch(SQLException se){
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(se).getMessage(), se);
//		}catch(Exception ex){
//			log.error(ex.getMessage(),ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
//		}
//	    return isRtnValue;
//	}
}
