/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VesselScheduleMgtDBDAO.java
*@FileTitle : VesselScheduleMgtDBDAO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.02.12
*@LastModifier : 정상기
*@LastVersion : 1.0
* 2009.05.04 서창열
* 1.0 Creation
*
* History
* 2010.10.05 CHM-201006264-01 유혁 Session User ID 설정로직 변경
* 2010.12.08 CHM-201007135-01 진마리아 Actaul Carrier update 로직 변경 요청건
* 2011.04.11 CHM-201109577-01 진마리아 Delete Vessel Code에 대한 조회 로직 보완
* 2011.10.26 김민아 [CHM-201114112-01] VSL SKD History Inquiry 화면 로직 변경
* 2012.05.24 CHM-201217916-01 이준범 스케줄 History 로직 변경
* 2012.10.24 CHM-201220527-01 진마리아 Departure/Noon Report 데이터를 FCM 데이터와 I/F하도록 변경 요청
* 2012.11.28 CHM-201220890-01 진마리아 double calling port 에 대한 virtual port calling seq. 수정
* 2012.12.03 [긴급반영] 진마리아 2012.11.28 로직 원복
* 2012.12.18 김상수 [CHM-201221884-01] CNTR 진행기준 대상항차 선정기능 보완
* 2013.02.12 정상기 [CHM-201221671] VVD Sked EDI (Daily Berth Window Update) 전송시 lane담당자 정보 F/F 반영
* 2013.09.10 정상기 [CHM-201325067]   [VOP-VSK] 스케줄 변경 시 개인별 설정 시간에 따라 개별 메일 통지 기능
* 2015.09.04 이병훈 [CHM-201537542] Yarc Code 말풍선 도움말 기능 지원
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.basic.VesselScheduleMgtBCImpl;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.ActivationVvdVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.ActualSkdBySimNoVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.BkgBdrLogVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.BkgCllCngNtfyUserLaneInfoVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.BkgListByVvdVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.CanalBnkSavVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.CanalTransitTargetVvdVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.CstSkdBerthWdoVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.CstSkdByPolPodVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.CstSkdByPortVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.CstSkdByVvdVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.CstSkdHisByVvdVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.CstSkdSimDtlCalcInfoVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.EdiMsgToDLSVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.ErpMsgFns017VO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.LoadWgtVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.PfSkdDetailVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.PortSkdOnLongRangeVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.ReversedPortInfoVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.SwapCstSkdSimVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.VskVslSkdPhsIoHisVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.VslPortSkdVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.VslSkdCngHisDtlVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.VslSkdCngHisVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.VslSkdHisInVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.VslSkdRepeatErpIfVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.VvdBkgStsVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.VvdCheckVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.VvdPortTariffVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.VesselVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.VvdPortLaneOtherVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.VvdVO;
import com.hanjin.apps.alps.vop.vsk.vskcommonutil.vskgeneralutil.VSKGeneralUtil;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.MdmVslCntrVO;
import com.hanjin.syscommon.common.table.MdmVslSvcLaneDirVO;
import com.hanjin.syscommon.common.table.VskCustEdiLogVO;
import com.hanjin.syscommon.common.table.VskCustSkdEdiSetVO;
import com.hanjin.syscommon.common.table.VskDepRptVO;
import com.hanjin.syscommon.common.table.VskHydrstMtxVO;
import com.hanjin.syscommon.common.table.VskPortDistVO;
import com.hanjin.syscommon.common.table.VskPortTideVO;
import com.hanjin.syscommon.common.table.VskSwapCstPortVO;
import com.hanjin.syscommon.common.table.VskSwapCstSimVO;
import com.hanjin.syscommon.common.table.VskSwapCstVvdVO;
import com.hanjin.syscommon.common.table.VskVslPortSkdVO;
import com.hanjin.syscommon.common.table.VskVslSkdHisVO;
import com.hanjin.syscommon.common.table.VskVslSkdVO;


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
	 @SuppressWarnings({ "unchecked", "rawtypes" })
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
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
    @SuppressWarnings({ "unchecked", "rawtypes" })
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
	 @SuppressWarnings({ "unchecked", "rawtypes" })
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
	 @SuppressWarnings({ "unchecked", "rawtypes" })
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
	 @SuppressWarnings({ "unchecked", "rawtypes" })
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
	 @SuppressWarnings({ "unchecked", "rawtypes" })
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
	 * Booking 모쥴에 BDR 정보를 변경하기 위해 Target 정보를 조회한다.
	 *
	 * @param VvdVO vvdVO
	 * @return List<BkgBdrLogVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
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
	 * @param VesselVO vesselVO
	 * @return int
	 * @exception DAOException
	 * @author jinwoo
	 */
	public int checkVslCntr(VesselVO vesselVO) throws DAOException {
		DBRowSet dbRowset = null;
		int rtnCnt = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vesselVO != null){
				Map<String, String> mapVO = vesselVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
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
	public void modifyVskVslPortSkdByActSkdDelete(List<VskVslPortSkdVO> vskVslPortSkdVOs) throws DAOException {

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
	@SuppressWarnings({ "unchecked", "rawtypes" })
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
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
	 * Virtual Port에 대한 VVD Port 정보를 조회합니다.<br>
	 *
	 * @param VskVslPortSkdVO vskVslPortSkdVO
	 * @return List<VskVslPortSkdVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
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
	 * Virtual Port에 대한 VVD Port 정보를 조회합니다.<br>
	 *
	 * @param VskVslPortSkdVO vskVslPortSkdVO
	 * @return List<VskVslPortSkdVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<ReversedPortInfoVO> checkVslSkdReversedPortInfo(VskVslPortSkdVO vskVslPortSkdVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ReversedPortInfoVO> list = null;
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselScheduleMgtDBDAOCheckVslSkdReversedPortInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ReversedPortInfoVO .class);
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public VslPortSkdVO checkVslSkdByRowID(VslPortSkdVO vslPortSkdVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<VslPortSkdVO> list = null;
		VslPortSkdVO resultVO = null;
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
	 * Swap Costal Schedule Simulation 정보를 조회합니다.<br>
	 *
	 * @param SwapCstSkdSimVO swapCstSkdSimVO
	 * @return List<SwapCstSkdSimVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
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
	 * Vessel / Lane 에 대해서 마지막 Port 의 정보를 조회한다.
	 * 
	 * @param swapCstSkdSimVO swapCstSkdSimVO
	 * @return VslPortSkdVO
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public VslPortSkdVO searchVesselLaneLastPort(SwapCstSkdSimVO swapCstSkdSimVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<VslPortSkdVO> list = null;
		VslPortSkdVO resultVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(swapCstSkdSimVO != null){
				Map<String, String> mapVO = swapCstSkdSimVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselScheduleMgtDBDAOSearchVesselLaneLastPortRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VslPortSkdVO.class);

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
	@SuppressWarnings({ "unchecked", "rawtypes" })
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
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

				// CTRL Office List
				String ctrl_ofc = cstSkdByPortVO.getVopPortCtrlOfcCd();
				if (VSKGeneralUtil.isNotNull(ctrl_ofc)) {
					List<String> ctrlOfcList = new ArrayList<String>();
					String[] ctrlOfcArr = ctrl_ofc.split("\\,");
					if(ctrlOfcArr != null && ctrlOfcArr.length > 0){
						for(int i=0; i<ctrlOfcArr.length; i++){
							ctrlOfcList.add(ctrlOfcArr[i]);
						}
						velParam.put("vop_port_ctrl_ofc_cd", ctrlOfcList);
					}
				}

				// TMNL List
				String tmnl = cstSkdByPortVO.getTmlCd();
				if (VSKGeneralUtil.isNotNull(tmnl)) {
					List<String> tmnlList = new ArrayList<String>();
					String[] tmlArr = tmnl.split("\\,");
					if(tmlArr != null && tmlArr.length > 0){
						for(int i=0; i<tmlArr.length; i++){
							tmnlList.add(tmlArr[i]);
						}
						velParam.put("tml_cd", tmnlList);
					}
				}
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
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
	 * @param String portCd
	 * @param String yardCd
	 * @return SwapCstSkdSimVO
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public SwapCstSkdSimVO searchVskPortMnvrTimeZone (String portCd, String yardCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<SwapCstSkdSimVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (portCd != null && yardCd != null) {
				param.put("loc_cd", portCd);
				velParam.put("yd_cd", yardCd);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new VesselScheduleMgtDBDAOSearchVskPortMnvrTimeZoneRSQL(), param, velParam);
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
	 * MDM Vessel CNTR 정보를 조회합니다.<br>
	 *
	 * @param String vslCd
	 * @return MdmVslCntrVO
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
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
	 * @return List<CstSkdHisByVvdVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<CstSkdHisByVvdVO> searchCstSkdHisByVvd(VvdPortLaneOtherVO vvdPortLaneOtherVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CstSkdHisByVvdVO> list = null;
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
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CstSkdHisByVvdVO.class);

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
	@SuppressWarnings({ "unchecked", "rawtypes" })
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
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
	 * 운하별 통항 선박의 스케뷸 및 Surcharge를 조회합니다.
	 *
	 * @param CanalTransitTargetVvdVO canalTransitTargetVvdVO
	 * @return List<CanalTransitTargetVvdVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
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
	 * Panama 운하의 통항을 위한 Booking 정보를 저장한다
	 *
	 * @param List<CanalTransitTargetVvdVO> canalTransitTargetVvdVOs
	 * @exception DAOException
	 */
	public void manageCanalTzBkg(List<CanalTransitTargetVvdVO> canalTransitTargetVvdVOs) throws DAOException, Exception{
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(canalTransitTargetVvdVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate) new VesselScheduleMgtDBDAOModifyCanalTzBKGCSQL(), canalTransitTargetVvdVOs, null);
				for(int i=0; i<updCnt.length; i++){
					if(updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i +"SQL");
					}
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
	 * 운하별 통항 선박의 스케뷸 및 Surcharge를 조회합니다.
	 *
	 * @param List<CanalTransitTargetVvdVO> canalTransitTargetVvdVOs
	 * @return List<CanalTransitTargetVvdVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
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

	/**
	 * VVD에 정보가 변경 될 경우 ERP 시스템에 해당 정보를 전송하기 위한 데이터를 생성한다.
	 *
	 * @param VvdVO vvdVO
	 * @return List<ErpMsgFns017VO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<ErpMsgFns017VO> searchErpIfSendingData(VvdVO vvdVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ErpMsgFns017VO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
//		Map<String, Object> velParam = null;

		try {
			if(vvdVO != null){
				Map<String, String> mapVO = vvdVO.getColumnValues();

				param.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselScheduleMgtDBDAOSearchErpIfSendingDataRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ErpMsgFns017VO.class);
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<EdiMsgToDLSVO> searchEdiMsgToDLS(VvdVO vvdVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<EdiMsgToDLSVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
//		Map<String, Object> velParam = null;

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
//		Map<String, Object> param = null;
		//velocity parameter
//		Map<String, Object> velParam = null;

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
	

	/**
	 * EDI 전문 HEADER 부분에 붙을 식별자를 생성한다.<br>
	 *
	 * @param  String sIndicator
	 * @return String
	 * @exception DAOException
	 */
	public String searchEdiHdSeqToOtherCoutryExceptKr(String sIndicator) throws DAOException {
		DBRowSet 	dbRowset 	= null;
		String 		headerSeq 	= null;

		try{
			
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("indicator", sIndicator);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselScheduleMgtDBDAOSearchEdiHdSeqForTerminalTransmitRSQL(), param, null);
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
//		Map<String, Object> velParam = null;
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


	/**
	 * EDI 전문 HEADER 부분을 생성한다..<br>
	 *
	 * @param String headerSeq
	 * @return String
	 * @exception DAOException
	 */
	public String searchEdiHdToKlnet(String headerSeq) throws DAOException {
		DBRowSet dbRowset = null;
		String header = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
//		Map<String, Object> velParam = null;

		try{
			if(VSKGeneralUtil.isNotNull(headerSeq)){
				param.put("headerSeq", headerSeq);

			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselScheduleMgtDBDAOSearchEdiHdToKlnetRSQL(), param, null);
			if(dbRowset != null){
				if(dbRowset.next()){
					header = dbRowset.getString("HEADER");
				}
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return header;
	}
	
	/**
	 * EDI 전문 HEADER 부분을 생성한다..<br>
	 *
	 * @param String senderId
	 * @param String receiverId
	 * @param String headerSeq
	 * @return String
	 * @exception DAOException
	 */
	public String searchEdiHdToExceptKor(String senderId, String receiverId, String headerSeq) throws DAOException {
		DBRowSet dbRowset = null;
		String header = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
//		Map<String, Object> velParam = null;

		try{
			if(VSKGeneralUtil.isNotNull(headerSeq)){
				param.put("sender_id"	, senderId	);
				param.put("receiver_id"	, receiverId);
				param.put("header_seq"	, headerSeq	);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselScheduleMgtDBDAOSearchEdiHdToExceptKorRSQL(), param, null);
			if(dbRowset != null){
				if(dbRowset.next()){
					header = dbRowset.getString("HEADER");
				}
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return header;
	}
	

	/**
	 * 신항(KRPUSHN) 보낼 EDI 전문 HEADER 부분을 생성한다.<br>
	 *
	 * @param String headerSeq
	 * @return String
	 * @exception DAOException
	 */
	public String searchEdiHdToKRPUSHN(String headerSeq) throws DAOException {
		DBRowSet dbRowset = null;
		String header = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
//		Map<String, Object> velParam = null;

		try{
			if(VSKGeneralUtil.isNotNull(headerSeq)){
				param.put("headerSeq", headerSeq);

			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselScheduleMgtDBDAOSearchEdiHdToKRPUSHNRSQL(), param, null);
			if(dbRowset != null){
				if(dbRowset.next()){
					header = dbRowset.getString("HEADER");
				}
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return header;
	}
	
	
	/**
	 * KL-NET에 전송한 EDI MESSAGE를 반환한다.<br>
	 *
	 * @param cstSkdBerthWdoVO CstSkdBerthWdoVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchEdiMsgToKlnet(CstSkdBerthWdoVO cstSkdBerthWdoVO) throws DAOException {
		DBRowSet dbRowset = null;
		String message = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
//		Map<String, Object> velParam = null;

		try{
			if(cstSkdBerthWdoVO != null){
				Map<String, String> mapVO = cstSkdBerthWdoVO .getColumnValues();

				param.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselScheduleMgtDBDAOSearchEdiMsgToKlnetRSQL(), param, null);
			if(dbRowset != null){
				if(dbRowset.next()){
					message = dbRowset.getString("MSG_ALL");
				}
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return message;
	}

	/**
	 * EUR(Only)에 전송할 EDI MESSAGE를 반환한다.<br>
	 *
	 * @param cstSkdBerthWdoVO CstSkdBerthWdoVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchEdiMsgToEUROnly(CstSkdBerthWdoVO cstSkdBerthWdoVO) throws DAOException {
		DBRowSet dbRowset = null;
		String message = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
//		Map<String, Object> velParam = null;

		try{
			if(cstSkdBerthWdoVO != null){
				Map<String, String> mapVO = cstSkdBerthWdoVO .getColumnValues();

				param.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselScheduleMgtDBDAOSearchEdiMsgToEUROnlyRSQL(), param, null);
			if(dbRowset != null){
				if(dbRowset.next()){
					message = dbRowset.getString("MSG_ALL");
				}
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return message;
	}
	

	/**
	 * EUR(Only)에 전송할 EDI MESSAGE를 반환한다.<br>
	 *
	 * @param String sContiCd
	 * @param String sCntCd
	 * @return boolean
	 * @exception DAOException
	 */
	public boolean isCheckContiForCountry(String sContiCd, String sCntCd) throws DAOException {
		DBRowSet 	dbRowset = null;
		boolean 	isResult = false;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
//		Map<String, Object> velParam = null;

		try{
			if(sContiCd != null && sCntCd != null){
				param.put("conti_cd", sContiCd	);
				param.put("cnt_cd"	, sCntCd	);
				
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselScheduleMgtDBDAOCheckContiForCountryRSQL(), param, null);
				if(dbRowset != null){
					if(dbRowset.next()){
						if(Integer.parseInt(dbRowset.getString("KNT"))>0)	isResult	= true;
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
		return isResult;
	}

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
//		Map<String, Object> velParam = null;

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
	@SuppressWarnings({ "unchecked", "rawtypes" })
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
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

	/**
	 * EDI011-0001 : Receive<br>
	 * modifyEsdSettingReceiveJMS<br>
	 * @param  List<VskCustSkdEdiSetVO> vskCustSkdEdiSetVOs
	 * @exception EventException
	 */
	public void modifyEsdSettingReceiveJMS(List<VskCustSkdEdiSetVO> vskCustSkdEdiSetVOs ) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt1[] = null;
			if (vskCustSkdEdiSetVOs .size() > 0) {

				//1	CUST_TRD_PRNR_ID 기준으로 기존 값이 있다면 나머지 CUST_TRD_PRNR_ID 는 모두 'N'으로 업데이트 한다 차후 EXISTS 로 수정
				updCnt1 = sqlExe.executeBatch(
						(ISQLTemplate) new VesselScheduleMgtDBDAOVskCustTrdPrnrIDCSQL(),
						vskCustSkdEdiSetVOs , null);
				for (int i = 0; i < updCnt1.length; i++) {
					if (updCnt1[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
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
	 * EDI011-0001 : Receive<br>
	 * addEsdSettingReceiveJMS<br>
	 * @param  List<VskCustSkdEdiSetVO> vskCustSkdEdiSetVOs
	 * @exception EventException
	 */
	public void addEsdSettingReceiveJMS(List<VskCustSkdEdiSetVO> vskCustSkdEdiSetVOs ) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt2[] = null;
			if (vskCustSkdEdiSetVOs .size() > 0) {
				//2	EDI_STUP_ID 기준으로 EDI_STUP_ID 기준으로 U, D이면 USE_FLG를 Y, D로 업데이트 일치하지 않는다면 INSERT
				updCnt2 = sqlExe.executeBatch(
								(ISQLTemplate) new VesselScheduleMgtDBDAOVskCustSkdEditSetCSQL(),
								vskCustSkdEdiSetVOs , null);
				for (int i = 0; i < updCnt2.length; i++) {
					if (updCnt2[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
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

			if(vslPortSkdVOs != null && vslPortSkdVOs.size() > 0){
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
	 * PF 선택시 삭제된 yard가 존재하는지 check한다.
	 *
	 * @param String vslSlanCd
	 * @param String pfSvcTpCd
	 * @return List<String>
	 * @throws DAOException
	 */
	public List<String> checkDeltYardByPF(String vslSlanCd, String pfSvcTpCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<String> list = new ArrayList<String>();
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (vslSlanCd != null && pfSvcTpCd != null) {
				param.put("vsl_slan_cd", vslSlanCd);
				param.put("pf_svc_tp_cd", pfSvcTpCd);
				velParam.put("vsl_slan_cd", vslSlanCd);
				velParam.put("pf_svc_tp_cd", pfSvcTpCd);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselScheduleMgtDBDAOCheckDeltYardByPFRSQL(), param, velParam);
			if(dbRowset != null){
				while(dbRowset.next()){
					list.add(dbRowset.getString("YD_CD"));
				}
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
	 * VSL SKD History 정보 중 Skip Call, Skip Call Cancel를 확인한다.
	 *
	 * @param VslSkdHisInVO vslSkdHisInVO
	 * @return boolean
	 * @throws DAOException
	 */
	public boolean checkSkipCallHistory(VslSkdHisInVO vslSkdHisInVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int rtnCnt = 0;

		try {
			Map<String, String> mapVO = vslSkdHisInVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselScheduleMgtDBDAOCheckSkipCallHistoryRSQL(), param, velParam);
			dbRowset.next();
			rtnCnt = dbRowset.getInt("SKIP_CANCEL_FLAG");

			if (rtnCnt == 0){
				return false ;
			}

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return true;
	}

	/**
	 * [VOP_VSK_0095]
	 * ERP로 전송 할 VVD SKD 목록을 조회<br>
	 *
	 * @param VslSkdRepeatErpIfVO vslSkdRepeatErpIfVO
	 * @return List<VslSkdRepeatErpIfVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	public List<VslSkdRepeatErpIfVO> searchVslSkdRepeatErpIf(VslSkdRepeatErpIfVO vslSkdRepeatErpIfVO) throws DAOException {
		
		DBRowSet 					dbRowset 	= null;
		List<VslSkdRepeatErpIfVO> 	list 		= null;
		//query parameter
		Map<String, Object> 		param 		= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> 		velParam 	= new HashMap<String, Object>();

		try{
			if (vslSkdRepeatErpIfVO != null) {
				Map<String, String> mapVO = vslSkdRepeatErpIfVO.getColumnValues();

				param.putAll	(mapVO);
				velParam.putAll	(mapVO);
			}
			dbRowset 	= new SQLExecuter("").executeQuery((ISQLTemplate)new VesselScheduleMgtDBDAOSearchVslSkdRepeatErpIfRSQL(), param, velParam);
			list 		= (List)RowSetUtil.rowSetToVOs(dbRowset, VslSkdRepeatErpIfVO.class);
			
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	 
		/**
		 * [VOP_VSK_0095]
		 * ERP로 전송 할 VVD SKD 목록을 조회<br>
		 *
		 * @param VslSkdRepeatErpIfVO vslSkdRepeatErpIfVO
		 * @return List<VslSkdRepeatErpIfVO>
		 * @exception DAOException
		 */
		 @SuppressWarnings({ "unchecked", "rawtypes" })
		public List<VslSkdRepeatErpIfVO> searchDeletedVslSkdRepeatErpIf(VslSkdRepeatErpIfVO vslSkdRepeatErpIfVO) throws DAOException {
			
			 DBRowSet 					dbRowset 	= null;
			List<VslSkdRepeatErpIfVO> 	list 		= null;
			//query parameter
			Map<String, Object> 		param 		= new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> 		velParam 	= new HashMap<String, Object>();

			try{
				if (vslSkdRepeatErpIfVO != null) {
					Map<String, String> mapVO = vslSkdRepeatErpIfVO.getColumnValues();

					param.putAll	(mapVO);
					velParam.putAll	(mapVO);
				}
				dbRowset 	= new SQLExecuter("").executeQuery((ISQLTemplate)new VesselScheduleMgtDBDAOSearchDeletedVslSkdRepeatErpIfRSQL(), param, velParam);
				list 		= (List)RowSetUtil.rowSetToVOs(dbRowset, VslSkdRepeatErpIfVO.class);
				
			} catch(SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch(Exception ex) {
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return list;
		}	 
	 
		/**
		 * [VOP_VSK_0017]
		 * KRLET EDI 전송시 포함할 User Lane Info 정보 조회<br>
		 * 
		 * @param		String sLaneCd
		 * @param		String sSkdDirCd
		 * @param		String sVpsPortCd
		 * @return		List<BkgCllCngNtfyUserLaneInfoVO>
		 * @exception	DAOException
		 */
		@SuppressWarnings({ "unchecked", "rawtypes" })
		public List<BkgCllCngNtfyUserLaneInfoVO> searchBkgCllCngNtfyUserLaneInfo(String sLaneCd, String sSkdDirCd, String sVpsPortCd) throws DAOException {
			
			DBRowSet 							dbRowset 	= null;
			List<BkgCllCngNtfyUserLaneInfoVO> 	list 		= null;

			Map<String, Object> 	param 		= new HashMap<String, Object>();
			Map<String, Object> 	velParam 	= new HashMap<String, Object>();
			
			try {
				
				if(sLaneCd != null && !"".equals(sLaneCd)){
					param.put	("slan_cd"		, sLaneCd	);
					param.put	("skd_dir_cd"	, sSkdDirCd	);
					param.put	("vps_port_cd"	, sVpsPortCd);
					velParam.put("slan_cd"		, sLaneCd	);
					velParam.put("skd_dir_cd"	, sSkdDirCd	);
					velParam.put("vps_port_cd"	, sVpsPortCd);
				}

				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselScheduleMgtDBDAOSearchBkgCllCngNtfyUserLaneInfoRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgCllCngNtfyUserLaneInfoVO.class);
				
				return list;
				
			} catch (SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
		}
		

		/**
		 * Port Tariff Calculation >> Surcharge/Discount Exist Checking<br>
		 * 
		 * @param VvdPortTariffVO vvdPortTariffVO
		 * @return String
		 * @exception DAOException
		 */
		public String searchPortTariffSurchargeDiscountExist(VvdPortTariffVO vvdPortTariffVO) throws DAOException {
			
			DBRowSet 				dbRowset 	= null;
			String					rtnValue	= "";

			Map<String, Object> 	param 		= new HashMap<String, Object>();
			Map<String, Object> 	velParam 	= new HashMap<String, Object>();
			
			try {
				
				if(vvdPortTariffVO != null && !"".equals(vvdPortTariffVO)){
					
					log.info("\n\n ################################################################################### ");
					log.info("\n\n ############# ::jskjskjsk:: DBDAO.searchPortTariffSurchargeDiscountExistList ######");
					log.info("\n\n ################################################################################### ");
					
					param.putAll(vvdPortTariffVO.getColumnValues());
					
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselScheduleMgtDBDAOSearchPortTariffSurchargeDiscountExistRSQL(), param, velParam);
					
					if(dbRowset.next())	rtnValue	= dbRowset.getString(1);
				}

			} catch (SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			
			return rtnValue;
		}	
		
		/**
		 * VSK_VSL_SKD의 삭제VVD의 이력데이터생성합니다.<br>
		 * 
		 * @param List<VslSkdCngHisVO> vslSkdCngHisVOs
		 * @exception DAOException
		 */
		public void createVskVslSkdChangeHistoryMstOnly(List<VslSkdCngHisVO> vslSkdCngHisVOs) throws DAOException {
			
			SQLExecuter sqlExe = new SQLExecuter("");
			
			try {
				int insCnt[] = null;
				if(vslSkdCngHisVOs != null && vslSkdCngHisVOs.size() > 0){
					insCnt = sqlExe.executeBatch((ISQLTemplate)new VesselScheduleMgtDBDAOCreateVslSkdChangeHistoryMstOnlyCSQL(), vslSkdCngHisVOs, null);
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
		 * VSK_VSL_SKD의 VVD의 변경이력데이터생성을 위한 VVD_HIS_SEQ 생성합니다.<br>
		 * @param List<VslSkdCngHisVO> vslSkdCngHisVOs
		 * @return String
		 * @exception DAOException
		 */
		public String createVslSkdChangeVvdHisSeq(List<VslSkdCngHisVO> vslSkdCngHisVOs) throws DAOException {
			DBRowSet 				dbRowset 	= null;
			//query parameter
			Map<String, Object> 	param 		= new HashMap<String, Object>();
			String					sVvdHisSeq	= null;
			try {
				if(vslSkdCngHisVOs != null && vslSkdCngHisVOs.size()>0)
				{
					for(int inx=0; inx<vslSkdCngHisVOs.size(); inx++){
						VslSkdCngHisVO	tmpVO	= new VslSkdCngHisVO();
						tmpVO					= vslSkdCngHisVOs.get(inx);
						
						log.info("\n\n ::jskjskjsk:: DAO.vsl_cd ["+tmpVO.getVslCd()+"]");
						log.info("\n\n ::jskjskjsk:: DAO.skd_voy_no ["+tmpVO.getSkdVoyNo()+"]");
						log.info("\n\n ::jskjskjsk:: DAO.skd_dir_cd ["+tmpVO.getSkdDirCd()+"]");
						
						param.put	("vsl_cd"		, tmpVO.getVslCd	()	);
						param.put	("skd_voy_no"	, tmpVO.getSkdVoyNo	()	);
						param.put	("skd_dir_cd"	, tmpVO.getSkdDirCd	()	);
						
						dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselScheduleMgtDBDAOCreateVslSkdChangeHistoryVvdHisSeqRSQL(), param, null);
						
						if(dbRowset.next())
							sVvdHisSeq = dbRowset.getString(1);						
					}

				}
			} catch (SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			return sVvdHisSeq;
		}
		
		/**
		 * VSK_VSL_SKD의 VVD의 변경이력데이터생성합니다.<br>
		 * 
		 * @param List<VslSkdCngHisVO> vslSkdCngHisVOs
		 * @exception DAOException
		 */
		public void createVslSkdChangeHistory(List<VslSkdCngHisVO> vslSkdCngHisVOs) throws DAOException {
			
			SQLExecuter sqlExe = new SQLExecuter("");
			
			try {
				int insHisCnt[] = null;
				if(vslSkdCngHisVOs != null && vslSkdCngHisVOs.size() > 0){
					insHisCnt = sqlExe.executeBatch((ISQLTemplate)new VesselScheduleMgtDBDAOCreateVslSkdChangeHistoryCSQL(), vslSkdCngHisVOs, null);
					for(int i=0; i<insHisCnt.length; i++){
						if(insHisCnt[i] == Statement.EXECUTE_FAILED)
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
		 * VSK_VSL_PORT_SKD의 VVD의 변경이력데이터생성합니다.<br>
		 * 
		 * @param List<VslSkdCngHisDtlVO> vslSkdCngHisDtlVOs
		 * @exception DAOException
		 */
		public void createVslSkdChangeHistoryDetailByVvd(List<VslSkdCngHisDtlVO> vslSkdCngHisDtlVOs) throws DAOException {
			
			SQLExecuter sqlExe = new SQLExecuter("");
			
			try {
				int insHisCnt[] = null;
				if(vslSkdCngHisDtlVOs != null && vslSkdCngHisDtlVOs.size() > 0){
					
					log.info("\n\n ################################################################################### ");
					log.info("\n\n ############# ::jskjskjsk:: DBDAO.createVslSkdChangeHistoryDetail size is  ["+vslSkdCngHisDtlVOs.size()+"]");
					log.info("\n\n ################################################################################### ");
					
					insHisCnt = sqlExe.executeBatch((ISQLTemplate)new VesselScheduleMgtDBDAOCreateVslSkdChangeHistoryDetailByVvdCSQL(), vslSkdCngHisDtlVOs, null);
					
					for(int i=0; i<insHisCnt.length; i++){
						if(insHisCnt[i] == Statement.EXECUTE_FAILED)
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
		 * VSK_VSL_PORT_SKD의 VVD의 변경이력데이터생성합니다.<br>
		 * 
		 * @param List<VslSkdCngHisDtlVO> vslSkdCngHisDtlVOs
		 * @exception DAOException
		 */
		public void createVslSkdChangeHistoryDetailByVvdPort(List<VslSkdCngHisDtlVO> vslSkdCngHisDtlVOs) throws DAOException {
			
			SQLExecuter sqlExe = new SQLExecuter("");
			
			try {
				int insHisCnt[] = null;
				if(vslSkdCngHisDtlVOs != null && vslSkdCngHisDtlVOs.size() > 0){
					
					log.info("\n\n ################################################################################### ");
					log.info("\n\n ############# ::jskjskjsk:: DBDAO.createVslSkdChangeHistoryDetail size is  ["+vslSkdCngHisDtlVOs.size()+"]");
					log.info("\n\n ################################################################################### ");
					
					insHisCnt = sqlExe.executeBatch((ISQLTemplate)new VesselScheduleMgtDBDAOCreateVslSkdChangeHistoryDetailByVvdPortCSQL(), vslSkdCngHisDtlVOs, null);
					
					for(int i=0; i<insHisCnt.length; i++){
						if(insHisCnt[i] == Statement.EXECUTE_FAILED)
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
		 * Yard Code 정보로 Yard Name을 조회합니다.
		 * 
		 * @param ydCd
		 * @return
		 * @throws DAOException
		 */
		public String searchYardName(String ydCd) throws DAOException {
			 DBRowSet dbRowset = null;
			 String ydNm = null;
			 //query parameter
			 Map<String, Object> param = new HashMap<String, Object>();
			 //velocity parameter
			 Map<String, Object> velParam = new HashMap<String, Object>();
			 
			 try {
				 if (ydCd != null) {
					 param.put("yd_cd", ydCd);
					 velParam.put("yd_cd", ydCd);
				 }
				 
				 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselScheduleMgtDBDAOSearchYardNameRSQL(), param, velParam);
				 if (dbRowset.next()) {
					 ydNm = dbRowset.getString("YD_NM");
				 }
				 return ydNm;
			 } catch(SQLException se) {
				 log.error(se.getMessage(),se);
				 throw new DAOException(new ErrorHandler(se).getMessage());
			 } catch(Exception ex) {
				 log.error(ex.getMessage(),ex);
				 throw new DAOException(new ErrorHandler(ex).getMessage());
			 }
		}
		
		/**
		 * Phase In/Out에 대한 히스토리 정보를 저장
		 * @param  List<VskVslSkdPhsIoHisVO> vskVslSkdPhsIoHisVOs
		 * @exception EventException
		 */
		public void createVslSkdPhaseInOutHistory(List<VskVslSkdPhsIoHisVO> vskVslSkdPhsIoHisVOs ) throws DAOException, Exception {
			try {
				SQLExecuter sqlExe = new SQLExecuter("");
				int updCnt1[] = null;
				if (vskVslSkdPhsIoHisVOs .size() > 0) {
					updCnt1 = sqlExe.executeBatch((ISQLTemplate) new VesselScheduleMgtDBDAOCreateVslSkdPhaseInOutHistoryCSQL(), vskVslSkdPhsIoHisVOs , null);
					for (int i = 0; i < updCnt1.length; i++) {
						if (updCnt1[i] == Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to insert No" + i + " SQL");
					}
				}
			} catch (SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			} catch (Exception ex) {
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
		}
		
}
