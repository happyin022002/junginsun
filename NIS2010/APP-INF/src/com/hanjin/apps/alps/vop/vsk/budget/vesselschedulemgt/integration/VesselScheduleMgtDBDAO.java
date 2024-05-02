/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VesselScheduleMgtDBDAO.java
*@FileTitle : VesselScheduleMgtDBDAO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.02.12
*@LastModifier : 정상기
*@LastVersion : 1.0
* 2011.02.10 진마리아
* 1.0 Creation
* 
* History
* 2011.02.22 진마리아 CHM-201108456-01 사업계획용 스케줄 정보 노출 대응을 위한 시스템 업데이트건
* 2011.04.11 진마리아 CHM-201109577-01 Delete Vessel Code에 대한 조회 로직 보완
* 2011.06.27 진마리아 CHM-201111838-01 소스품질 결함수정 - 객체에 null이 배정된 이후 객체에 대한 참조를 하지 말아야 한다.
* 2013.02.12 정상기 [CHM-201221671] VVD Sked EDI (Daily Berth Window Update) 전송시 lane담당자 정보 F/F 반영
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.budget.vesselschedulemgt.integration;
 
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.vop.vsk.budget.vesselschedulemgt.basic.VesselScheduleMgtBCImpl;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.ActivationVvdVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.CstSkdByPortVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.CstSkdByVvdVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.PfSkdDetailVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.PortSkdOnLongRangeVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.VslPortSkdVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.VvdBkgStsVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.VvdCheckVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.PfLaneTypeVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.VesselVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.VvdVO;
import com.hanjin.apps.alps.vop.vsk.vskcommonutil.vskgeneralutil.VSKGeneralUtil;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.MdmVslCntrVO;
import com.hanjin.syscommon.common.table.MdmVslSvcLaneDirVO;
import com.hanjin.syscommon.common.table.VskVslPortSkdVO;
import com.hanjin.syscommon.common.table.VskVslSkdVO;


/**
 * NIS2010 VesselScheduleMgtDBDAO <br> 
 * - NIS2010-SchedulePlanningOperation system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Maria Chin
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
	
//	/**
//	 * VVD에 정보가 변경 될 경우 ERP 시스템에 해당 정보를 전송하기 위한 데이터를 생성한다.
//	 * 
//	 * @param VvdVO vvdVO
//	 * @return List<EdiMsgToDLSVO>
//	 * @exception DAOException
//	 */
//	@SuppressWarnings("unchecked")
//	public List<EdiMsgToDLSVO> searchEdiMsgToDLS(VvdVO vvdVO) throws DAOException {
//		DBRowSet dbRowset = null;
//		List<EdiMsgToDLSVO> list = null;
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
//			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselScheduleMgtDBDAOSearchEdiMsgToDLSRSQL(), param, velParam);
//			list = (List)RowSetUtil.rowSetToVOs(dbRowset, EdiMsgToDLSVO.class);
//		}catch(SQLException se){
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(se).getMessage(), se);
//		}catch(Exception ex){
//			log.error(ex.getMessage(),ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
//		}
//		return list;
//	}
	
//	/**
//	 * Flat File 헤더에 붙일 내용을 생성한다.<br>
//	 * 
//	 * @return String
//	 * @exception DAOException
//	 * @author 
//	 */
//	public String searchEdiHdToDLS() throws DAOException {
//		DBRowSet dbRowset = null;
//		String rtnHeader = "";
//		//query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
//		//velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();
//		
//		try{
//			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselScheduleMgtDBDAOSearchEdiHdToDLSRSQL(), param, velParam);
//			if(dbRowset != null){
//				if(dbRowset.next()){
//					rtnHeader = dbRowset.getString("HEADER");
//				}
//			}
//		}catch(SQLException se){
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(se).getMessage(), se);
//		}catch(Exception ex){
//			log.error(ex.getMessage(),ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
//		}
//		return rtnHeader;
//	}

//	/**
//	 * EDI 전문 HEADER 부분에 붙을 식별자를 생성한다.<br>
//	 * 
//	 * @return String 
//	 * @exception DAOException
//	 */
//	public String searchEdiHdSeqToKlnet() throws DAOException {
//		DBRowSet dbRowset = null;
//		String headerSeq = null;
//		//query parameter
//		Map<String, Object> param = null;
//		//velocity parameter
//		Map<String, Object> velParam = null;
//		
//		try{
//			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselScheduleMgtDBDAOSearchEdiHdSeqToKlnetRSQL(), param, velParam);
//			if(dbRowset != null){
//				if(dbRowset.next()){
//					headerSeq = dbRowset.getString("HEADERSEQ");
//				}
//			}
//		}catch(SQLException se){
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(se).getMessage(), se);
//		}catch(Exception ex){
//			log.error(ex.getMessage(),ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
//		}
//		return headerSeq;
//	}
	
//	/**
//	 * VSK_CUST_EDI_LOG 정보를 등록합니다.
//	 * 
//	 * @param VskCustEdiLogVO vskCustEdiLogVO
//	 * @exception DAOException
//	 */
//	public void addVskCustEdiLogToDLS(VskCustEdiLogVO vskCustEdiLogVO) throws DAOException {
//		//query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
//		//velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();
//		try {
//			Map<String, String> mapVO = vskCustEdiLogVO.getColumnValues();
//			
//			param.putAll(mapVO);
//			velParam.putAll(mapVO);
//			
//			new SQLExecuter("").executeUpdate((ISQLTemplate)new VesselScheduleMgtDBDAOAddVskCustEdiLogVOCSQL(), param, velParam);
//		} catch (SQLException se) {
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(se).getMessage(), se);
//		}catch(Exception ex){
//			log.error(ex.getMessage(),ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
//		}
//	}
	
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
//	 * 해당 VVD를 사용하는 Booking 정보가 있는지 확인한다.
//	 * 
//	 * @param VvdVO vvdVO
//	 * @return int
//	 * @exception DAOException
//	 * @author jinwoo
//	 */
//	public int checkVvdApplyBooking(VvdVO vvdVO) throws DAOException {
//		DBRowSet dbRowset = null;
//		int rtnCnt = 0;
//		
//		//query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
//		//velocity parameter
////		Map<String, Object> velParam = new HashMap<String, Object>();
//		
//		try{
//			if(vvdVO != null){
//				param.put("vsl_cd", vvdVO.getVslCd());
//				param.put("skd_voy_no", vvdVO.getSkdVoyNo());
//				param.put("skd_dir_cd", vvdVO.getSkdDirCd());
//				
//				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselScheduleMgtDBDAOCheckVvdApplyBookingRSQL(), param, null);
//				if(dbRowset != null){
//					if(dbRowset.next()){
//						rtnCnt = dbRowset.getInt("CNT");
//					}
//				}
//			}
//		}catch(SQLException se){
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(se).getMessage(), se);
//		}catch(Exception ex){
//			log.error(ex.getMessage(),ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
//		}
//		return rtnCnt;
//	}
	
//	/**
//	 * 해당 VVD로 Actual Port Schedule이 입력되여 있는지 확인한다.
//	 * 
//	 * @param VvdVO vvdVO
//	 * @return int
//	 * @exception DAOException
//	 * @author jinwoo
//	 */
//	public int checkVvdActualSkdInput(VvdVO vvdVO) throws DAOException {
//		DBRowSet dbRowset = null;
//		int rtnCnt = 0;
//		
//		//query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
//		//velocity parameter
////		Map<String, Object> velParam = new HashMap<String, Object>();
//		
//		try{
//			if(vvdVO != null){
//				param.put("vsl_cd", vvdVO.getVslCd());
//				param.put("skd_voy_no", vvdVO.getSkdVoyNo());
//				param.put("skd_dir_cd", vvdVO.getSkdDirCd());
//				
//				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselScheduleMgtDBDAOCheckVvdActualSkdInputRSQL(), param, null);
//				if(dbRowset != null){
//					if(dbRowset.next()){
//						rtnCnt = dbRowset.getInt("CNT");
//					}
//				}
//			}
//		}catch(SQLException se){
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(se).getMessage(), se);
//		}catch(Exception ex){
//			log.error(ex.getMessage(),ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
//		}
//		return rtnCnt;
//	}
	
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
	 * VSK_VSL_PORT_SKD TABLE UPDATE<br>
	 * Virtual Port 수정 시 해당 Port 수정
	 * 
	 * @param List<VskVslPortSkdVO> vskVslPortSkdVOs
	 * @exception DAOException
	 */
	public void modifyVskVslPortSkdByNextPort(List<VskVslPortSkdVO> vskVslPortSkdVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
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
//	 * VVD의 Status 정보를 업데이트 합니다.
//	 * 
//	 * @param ActivationVvdVO[] activationVvdVOs
//	 * @exception DAOException
//	 */
//	public void modifyVslSkdListByLane(ActivationVvdVO[] activationVvdVOs) throws DAOException {
//		SQLExecuter sqlExe = new SQLExecuter("");
//		
//		List<ActivationVvdVO> list = Arrays.asList(activationVvdVOs);
//		
//		try {
//			int insCnt[] = null;
//			if(activationVvdVOs != null && activationVvdVOs.length > 0){
//				insCnt = sqlExe.executeBatch((ISQLTemplate)new VesselScheduleMgtDBDAOModifyVslSkdStatusUSQL(), list, null);
//				for(int i=0; i<insCnt.length; i++){
//					if(insCnt[i] == Statement.EXECUTE_FAILED)
//						throw new DAOException("Fail to update No"+ i + " SQL");
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
	
//	/**
//	 * 해당 VVD 스케쥴을 Activate 처리합니다.
//	 * 
//	 * @param ActivationVvdVO activationVvdVO
//	 * @exception DAOException
//	 */
//	public void manageSkdActivate(ActivationVvdVO activationVvdVO) throws DAOException {
//		//query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
//		//velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();
//		try {
//			Map<String, String> mapVO = activationVvdVO.getColumnValues();
//			
//			param.putAll(mapVO);
//			velParam.putAll(mapVO);
//			
//			SQLExecuter sqlExe = new SQLExecuter("");
//			int result = sqlExe.executeUpdate((ISQLTemplate)new VesselScheduleMgtDBDAOModifyVslSkdStatusActivateUSQL(), param, velParam);
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
//	 * VVD 정보의 P/F Type 정보를 수정합니다.<br>
//	 * 
//	 * @param List<ActivationVvdVO> activationVvdVOs
//	 * @exception DAOException
//	 * @author Hyuk Ryu
//	 * @date 2009. 11. 11.
//	 */
//	public void manageVvdPf(List<ActivationVvdVO> activationVvdVOs) throws DAOException {
//		try{
//			SQLExecuter sqlExe = new SQLExecuter("");
//			int insCnt[] = null;
//			if(activationVvdVOs.size() > 0){
//				insCnt = sqlExe.executeBatch((ISQLTemplate)new VesselScheduleMgtDBDAOModifyVskVslSkdPfTypeUSQL(), activationVvdVOs, null);
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
//	 * SWAP_CST_PORT의 자신에 VVD와 연결되는 Pre-VVD와 Next-VVD 정보를 찾아 온다..<br>
//	 * 
//	 * @param VvdVO vvdVO
//	 * @return List<VvdVO>
//	 * @exception DAOException
//	 */
//	 @SuppressWarnings("unchecked")
//	public List<VvdVO> searchConnectVvdSim(VvdVO vvdVO) throws DAOException {
//		DBRowSet dbRowset = null;
//		List<VvdVO> list = null;
//		//query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
//		//velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();
//
//		try{
//			if(vvdVO != null){
//				Map<String, String> mapVO = vvdVO .getColumnValues();
//			
//				param.putAll(mapVO);
//				velParam.putAll(mapVO);
//			}
//			
//			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselScheduleMgtDBDAOSearchConnectVvdSimRSQL(), param, null);
//			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VvdVO .class);
//		}catch(SQLException se){
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(se).getMessage(), se);
//		}catch(Exception ex){
//			log.error(ex.getMessage(),ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
//		}
//		return list;
//	}
	
//	 /**
//	 * Vsk_Swap_Cst_Port  데이터를 삭제한다.<br>
//	 * 자기 자신의 VVD 전 차수를 찾아서 REMOVE한다
//	 * 
//	 * @param VvdVO vvdVO
//	 * @return int
//	 * @exception DAOException
//	 */
//	public int removeVskSwapCstPortByPreVvd(VvdVO vvdVO) throws DAOException {
//		//query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
//		//velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();
//		
//		int result = 0;
//		try {
//			if(vvdVO != null){
//				Map<String, String> mapVO = vvdVO .getColumnValues();
//			
//				param.putAll(mapVO);
//				velParam.putAll(mapVO);
//			}
//			
//			SQLExecuter sqlExe = new SQLExecuter("");
//			result = sqlExe.executeUpdate((ISQLTemplate)new VesselScheduleMgtDBDAORemoveVskSwapCstPortByPreVvdDSQL(), param, null);
//			if(result == Statement.EXECUTE_FAILED)
//				throw new DAOException("Fail to remove SQL");
//		} catch (SQLException se) {
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(se).getMessage(), se);
//		}catch(Exception ex){
//			log.error(ex.getMessage(),ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
//		}
//		return result;
//	}	 
	
//	/**
//	 * Vsk_Swap_Cst_Port  데이터를 삭제한다.<br>
//	 * 자기 자신의 VVD를  REMOVE한다
//	 * 
//	 * @param VskSwapCstPortVO vskSwapCstPortVO
//	 * @return int
//	 * @exception DAOException
//	 */
//	public int removeVskSwapCstPort(VskSwapCstPortVO vskSwapCstPortVO) throws DAOException {
//		//query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
//		//velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();
//		
//		int result = 0;
//		try {
//			if(vskSwapCstPortVO != null){
//				Map<String, String> mapVO = vskSwapCstPortVO .getColumnValues();
//			
//				param.putAll(mapVO);
//				velParam.putAll(mapVO);
//			}
//			
//			SQLExecuter sqlExe = new SQLExecuter("");
//			result = sqlExe.executeUpdate((ISQLTemplate)new VesselScheduleMgtDBDAORemoveVskSwapCstPortDSQL(), param, velParam);
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
	
//	/**
//	 * Vsk_Swap_Cst_Port  데이터를 삭제한다.<br>
//	 * 자기 자신의 VVD의 다음 차수를 찾아서 UPDATE한다
//	 *  
//	 * @param VvdVO vvdVO
//	 * @return int
//	 * @exception DAOException
//	 */
//	public int modifyVskSwapCstPort(VvdVO vvdVO) throws DAOException {
//		//query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
//		//velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();
//		
//		int result = 0;
//		try {
//			if(vvdVO != null){
//				Map<String, String> mapVO = vvdVO .getColumnValues();
//			
//				param.putAll(mapVO);
//				velParam.putAll(mapVO);
//			}
//			
//			SQLExecuter sqlExe = new SQLExecuter("");
//			result = sqlExe.executeUpdate((ISQLTemplate)new VesselScheduleMgtDBDAOModifyVskSwapCstPortUSQL(), param, null);
//			if(result == Statement.EXECUTE_FAILED)
//					throw new DAOException("Fail to update SQL");
//		} catch (SQLException se) {
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(se).getMessage(), se);
//		}catch(Exception ex){
//			log.error(ex.getMessage(),ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
//		}
//		return result;
//	}	
	
//	/**
//	 * VSK_SWAP_CST_SIM TABLE 삭제를 위해 SIM_DT,SIM_NO를 조회한다..<br>
//	 * 
//	 * @param VvdVO vvdVO
//	 * @return List<VskSwapCstSimVO>
//	 * @exception DAOException
//	 */
//	 @SuppressWarnings("unchecked")
//	public List<VskSwapCstSimVO> searchSimNoVskSwapCstVvd(VvdVO vvdVO) throws DAOException {
//		DBRowSet dbRowset = null;
//		List<VskSwapCstSimVO> list = null;
//		//query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
//		//velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();
//
//		try{
//			if(vvdVO != null){
//				Map<String, String> mapVO = vvdVO .getColumnValues();
//			
//				param.putAll(mapVO);
//				velParam.putAll(mapVO);
//			}
//			
//			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselScheduleMgtDBDAOSearchSimNoVskSwapCstVvdRSQL(), param, null);
//			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VskSwapCstSimVO .class);
//		}catch(SQLException se){
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(se).getMessage(), se);
//		}catch(Exception ex){
//			log.error(ex.getMessage(),ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
//		}
//		return list;
//	}	
	
//	 /**
//	 * Vsk_Swap_Cst_Vvd  데이터를 삭제한다.<br>
//	 * 
//	 * @param VskSwapCstVvdVO vskSwapCstVvdVO
//	 * @return int
//	 * @exception DAOException
//	 */
//	public int removeVskSwapCstVvd(VskSwapCstVvdVO vskSwapCstVvdVO) throws DAOException {
//		//query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
//		//velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();
//		
//		int result = 0;
//		try {
//			if(vskSwapCstVvdVO != null){
//				Map<String, String> mapVO = vskSwapCstVvdVO .getColumnValues();
//			
//				param.putAll(mapVO);
//				velParam.putAll(mapVO);
//			}
//			
//			SQLExecuter sqlExe = new SQLExecuter("");
//			result = sqlExe.executeUpdate((ISQLTemplate)new VesselScheduleMgtDBDAORemoveVskSwapCstVvdDSQL(), param, velParam);
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

//	/**
//	 * Vsk_Swap_Cst_RMK  데이터를 삭제한다.<br>
//	 * 
//	 * @param VvdVO vvdVO
//	 * @return int
//	 * @exception DAOException
//	 */
//	public int removeVskSwapCstRmk(VvdVO vvdVO) throws DAOException {
//		//query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
//		//velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();
//		
//		int result = 0;
//		try {
//			if(vvdVO != null){
//				Map<String, String> mapVO = vvdVO .getColumnValues();
//			
//				param.putAll(mapVO);
//				velParam.putAll(mapVO);
//			}
//			
//			SQLExecuter sqlExe = new SQLExecuter("");
//			result = sqlExe.executeUpdate((ISQLTemplate)new VesselScheduleMgtDBDAORemoveVskSwapCstRmkDSQL(), param, null);
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

//	/**
//	 * Simulation No, Simulation Seq로 등록된 Simulation 정보가 있는지 확인<br>
//	 * 
//	 * @param VskSwapCstSimVO vskSwapCstSimVO
//	 * @return int
//	 * @exception DAOException
//	 */
//	public int searchVskSwapCstVvdCount(VskSwapCstSimVO vskSwapCstSimVO) throws DAOException {
//		DBRowSet dbRowset = null;
////		List<VskSwapCstSimVO> list = null;
//		//query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
//		//velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();
//		
//		int cnt = 0;
//
//		try{
//			if(vskSwapCstSimVO != null){
//				Map<String, String> mapVO = vskSwapCstSimVO .getColumnValues();
//			
//				param.putAll(mapVO);
//				velParam.putAll(mapVO);
//			}
//			
//			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselScheduleMgtDBDAOCheckVskSwapCstVvdRSQL(), param, null);
//			cnt = dbRowset.getRowCount();
//			//list = (List)RowSetUtil.rowSetToVOs(dbRowset, VskSwapCstSimVO .class);
//		}catch(SQLException se){
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(se).getMessage(), se);
//		}catch(Exception ex){
//			log.error(ex.getMessage(),ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
//		}
//		return cnt;
//	}	
	
//	/**
//	 * Vsk_Swap_Cst_SIM  데이터를 삭제한다.<br>
//	 * 
//	 * @param VskSwapCstSimVO  vskSwapCstSimVO
//	 * @return int
//	 * @exception DAOException
//	 */
//	public int removeVskSwapCstSim(VskSwapCstSimVO vskSwapCstSimVO) throws DAOException {
//		//query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
//		//velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();
//		
//		int result = 0;
//		try {
//			if(vskSwapCstSimVO != null){
//				Map<String, String> mapVO = vskSwapCstSimVO .getColumnValues();
//			
//				param.putAll(mapVO);
//				velParam.putAll(mapVO);
//			}
//			
//			SQLExecuter sqlExe = new SQLExecuter("");
//			result = sqlExe.executeUpdate((ISQLTemplate)new VesselScheduleMgtDBDAORemoveVskSwapCstSimDSQL(), param, null);
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
	
//	/**
//	 * 자신에 VVD와 연결되는 Pre-VVD와 Next-VVD 정보를 찾아 온다..<br>
//	 * 
//	  * @param VvdVO vvdVO
//	  * @return List<VskVslSkdHisVO>
//	  * @exception DAOException
//	  */
//	 @SuppressWarnings("unchecked")
//	public List<VskVslSkdHisVO> checkPreVvdBkgPodYard(VvdVO vvdVO) throws DAOException {
//		DBRowSet dbRowset = null;
//		List<VskVslSkdHisVO> list = null;
//		//query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
//		//velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();
//
//		try{
//			if(vvdVO != null){
//				Map<String, String> mapVO = vvdVO .getColumnValues();
//			
//				param.putAll(mapVO);
//				velParam.putAll(mapVO);
//			}
//			
//			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselScheduleMgtDBDAOCheckPreVvdBkgPodYardRSQL(), param, null);
//			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VskVslSkdHisVO.class);
//		}catch(SQLException se){
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(se).getMessage(), se);
//		}catch(Exception ex){
//			log.error(ex.getMessage(),ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
//		} 
//		return list;
//	}
	
//	 /**
//	 * VSK_VSL_SKD_HIS 단건의 데이터를 생성한다.<br>
//	 * 
//	 * @param VskVslSkdHisVO vskVslSkdHisVO
//	 * @exception DAOException
//	 */
//	public void addVslSkdHis(VskVslSkdHisVO vskVslSkdHisVO) throws DAOException {
//		//query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
//		//velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();
//		try {
//			Map<String, String> mapVO = vskVslSkdHisVO.getColumnValues();
//			
//			param.putAll(mapVO);
//			velParam.putAll(mapVO);
//			
//			SQLExecuter sqlExe = new SQLExecuter("");
////			int result = sqlExe.executeUpdate((ISQLTemplate)new VesselScheduleMgtDBDAOaddVslSkdHisCSQL(), param, velParam);
//			int result = sqlExe.executeUpdate((ISQLTemplate)new VesselScheduleMgtDBDAOAddVskVslSkdHisCSQL(), param, velParam);
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
	
//    /**
//	 * 입력된 VVD, Port 정보를 Booking System에서 사용하는지를 확인하고 Vessel Schedule 정보를 조회한다.
//	 * 
//	 * @param VslPortSkdVO vslPortSkdVO
//	 * @return VslPortSkdVO
//	 * @exception DAOException
//	 */
//	@SuppressWarnings("unchecked")
//	public VslPortSkdVO checkVslSkdByRowID(VslPortSkdVO vslPortSkdVO) throws DAOException {
//		DBRowSet dbRowset = null;
//		List<VslPortSkdVO> list = null;
//		VslPortSkdVO resultVO = null;
//		//query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
//		//velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();
//	
//		try{
//			if(vslPortSkdVO != null){
//				Map<String, String> mapVO = vslPortSkdVO .getColumnValues();
//			
//				param.putAll(mapVO);
//				velParam.putAll(mapVO);
//			}
//			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselScheduleMgtDBDAOCheckVslSkdByRowIDRSQL(), param, velParam);
//			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VslPortSkdVO .class);
//			
//			if(list != null && list.size()>0){
//				resultVO = list.get(0);
//			}
//		}catch(SQLException se){
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(se).getMessage(), se);
//		}catch(Exception ex){
//			log.error(ex.getMessage(),ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
//		}
//		return resultVO;
//	}
	
//	/**
//	 * VVD History 정보를 생성합니다.<br>
//	 * 
//	 * @param List<VskVslSkdHisVO> vskVslSkdHisVOs
//	 * @exception DAOException
//	 */
//	public void addVskVslSkdHis(List<VskVslSkdHisVO> vskVslSkdHisVOs) throws DAOException {
//		try {
//			SQLExecuter sqlExe = new SQLExecuter("");
//			
//			//query parameter
//			Map<String, Object> param = new HashMap<String, Object>();
//			//velocity parameter
//			Map<String, Object> velParam = new HashMap<String, Object>();
//			
//			if(vskVslSkdHisVOs.size() > 0){
//				int inCnt = vskVslSkdHisVOs.size();
//				for(int i=0; i<inCnt; i++){
//					Map<String, String> mapVO = vskVslSkdHisVOs.get(i) .getColumnValues();
//					
//					param.putAll(mapVO);
//					velParam.putAll(mapVO);
//					
//					int result = sqlExe.executeUpdate((ISQLTemplate)new VesselScheduleMgtDBDAOAddVskVslSkdHisCSQL(), param, null);
//					
//					if(result == Statement.EXECUTE_FAILED)
//						throw new DAOException("Fail to insert No "+ i + " SQL");
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
	
//	/**
//	 * 삭제된 VVD에 대한 History를 남긴다.
//	 * 
//	 * @param VskVslSkdHisVO vskVslSkdHisVO
//	 * @throws DAOException
//	 */
//	public void addVskVslSkdDelHis(VskVslSkdHisVO vskVslSkdHisVO) throws DAOException {
//		//query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
//		//velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();
//		try {
//			Map<String, String> mapVO = vskVslSkdHisVO.getColumnValues();
//			
//			param.putAll(mapVO);
//			velParam.putAll(mapVO);
//			
//			SQLExecuter sqlExe = new SQLExecuter("");
//			int result = sqlExe.executeUpdate((ISQLTemplate)new VesselScheduleMgtDBDAOAddVskVslSkdDelHisCSQL(), param, velParam);
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
	
	
	 /**
	 * Proforma Type 정보를 조회합니다.
	 * 
	 * @param PfLaneTypeVO pfLaneTypeListVO
	 * @return List<PfLaneTypeVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<PfLaneTypeVO> searchPfLaneTypeList(PfLaneTypeVO pfLaneTypeListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PfLaneTypeVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(pfLaneTypeListVO != null){
				Map<String, String> mapVO = pfLaneTypeListVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselScheduleMgtDBDAOPfLaneTypeVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PfLaneTypeVO .class);
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
	 * VOP_VSK_0113 에 대한 Retrieve 기능 - 이용준 추가 2014.07.15
	 * @author 이용준
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
	
}