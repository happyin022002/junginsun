/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ScheduleNotificationManagementBC.java
*@FileTitle : Schedule Notification
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.19
*@LastModifier : 정상기
*@LastVersion : 1.0
* 2013.07.19 정상기
* 1.0 Creation
*  History
* 2013.07.19 [CHM-201325067]   [VOP-VSK] 스케줄 변경 시 개인별 설정 시간에 따라 개별 메일 통지 기능
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.scheduleutilitymanagement.schedulenotificationmanagement.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration.VesselScheduleMgtDBDAOSearchDirectionSeqRSQL;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.VslSkdCngHisVO;
import com.hanjin.apps.alps.vop.vsk.scheduleutilitymanagement.schedulenotificationmanagement.basic.ScheduleNotificationManagementBCImpl;
import com.hanjin.apps.alps.vop.vsk.scheduleutilitymanagement.schedulenotificationmanagement.vo.VslSkdCngNotificationSetupVO;
import com.hanjin.apps.alps.vop.vsk.scheduleutilitymanagement.schedulenotificationmanagement.vo.VslSkdCngNotificationTransmitLogVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.MdmVslSvcLaneDirVO;

/**
 * NIS2010 ScheduleNotificationManagementDBDAO <br>
 * - NIS2010-ScheduleNotificationManagement system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Jeong Sang-Ki
 * @see ScheduleNotificationManagementBCImpl 참조
 * @since J2EE 1.4
 */
public class ScheduleNotificationManagementDBDAO extends DBDAOSupport {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Vessel Schedule Notice 기본정보 setup 조회
	 * 
	 * @param  VslSkdCngNotificationSetupVO vslSkdCngNotificationSetupVO
	 * @return List<VslSkdCngNotificationSetupVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<VslSkdCngNotificationSetupVO> searchVslSkdCngNotificationSetupList(VslSkdCngNotificationSetupVO vslSkdCngNotificationSetupVO) throws DAOException {
		DBRowSet 							dbRowset 	= null;
		List<VslSkdCngNotificationSetupVO> 	list	 	= null;
		//query parameter
		Map<String, Object> 				param 		= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> 				velParam 	= new HashMap<String, Object>();

		try{
			if(vslSkdCngNotificationSetupVO != null){
				Map<String, String> mapVO = vslSkdCngNotificationSetupVO.getColumnValues();
				
				param.putAll	(mapVO);
				velParam.putAll	(mapVO);
			}
			dbRowset 	= new SQLExecuter("").executeQuery((ISQLTemplate)new ScheduleNotificationManagementDBDAOSearchVslSkdCngNotificationSetupListRSQL(), param, velParam);
			list 		= (List)RowSetUtil.rowSetToVOs(dbRowset, VslSkdCngNotificationSetupVO.class);
			
			log.info("\n\n ::jskjskjsk:: DBDAO.searchVslSkdCngNotificationSetupList size ["+list.size()+"]");
			
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
	 * Vessel Schedule Notice 기본정보 setup 저장<br>
	 * 
	 * @param VslSkdCngNotificationSetupVO vslSkdCngNotificationSetupVO
	 * @return int
	 * @exception DAOException
	 */
	public int manageVslSkdCngNotificationSetup(VslSkdCngNotificationSetupVO vslSkdCngNotificationSetupVO) throws DAOException {

		SQLExecuter sqlExe = new SQLExecuter("");
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();		
		
		try {
			int insupCnt	= 0;
			
			Map<String, String> mapVO = vslSkdCngNotificationSetupVO.getColumnValues();

			param.putAll	(mapVO);
			velParam.putAll	(mapVO);			

			insupCnt = sqlExe.executeUpdate((ISQLTemplate)new ScheduleNotificationManagementDBDAOCreateVslSkdCngNotificationSetupListCSQL(), param, velParam);
			return	insupCnt;
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Vessel Schedule Notice 기본정보 setup 삭제<br>
	 * 
	 * @param VslSkdCngNotificationSetupVO vslSkdCngNotificationSetupVO
	 * @return int
	 * @exception DAOException
	 */
	public int removeVslSkdCngNotificationSetup(VslSkdCngNotificationSetupVO vslSkdCngNotificationSetupVO) throws DAOException {

		SQLExecuter sqlExe = new SQLExecuter("");
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();		
		
		try {
			int delCnt	= 0;
			
			Map<String, String> mapVO = vslSkdCngNotificationSetupVO.getColumnValues();

			param.putAll	(mapVO);
			velParam.putAll	(mapVO);			

			delCnt = sqlExe.executeUpdate((ISQLTemplate)new ScheduleNotificationManagementDBDAORemoveVslSkdCngNotificationSetupListDSQL(), param, velParam);
			return	delCnt;
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	
	
	/**
	 * Vessel Schedule Notice 기본정보 setup PK 업데이트<br>
	 * 
	 * @param VslSkdCngNotificationSetupVO vslSkdCngNotificationSetupVO
	 * @return int
	 * @exception DAOException
	 */
	public int modifyVslSkdCngNotificationSetup(VslSkdCngNotificationSetupVO vslSkdCngNotificationSetupVO) throws DAOException {

		SQLExecuter sqlExe = new SQLExecuter("");
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();		
		
		try {
			int delCnt	= 0;
			
			Map<String, String> mapVO = vslSkdCngNotificationSetupVO.getColumnValues();

			param.putAll	(mapVO);
			velParam.putAll	(mapVO);			

			delCnt = sqlExe.executeUpdate((ISQLTemplate)new ScheduleNotificationManagementDBDAOModifyVslSkdCngNotificationSetupListUSQL(), param, velParam);
			return	delCnt;
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
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
	 * Vessel Schedule Notice 기본정보 setup 조회
	 * 
	 * @param  VslSkdCngNotificationTransmitLogVO tmpVO
	 * @return int
	 * @exception DAOException
	 */
	public int checkVslSkdCngNotificationTransmitByEst(VslSkdCngNotificationTransmitLogVO tmpVO) throws DAOException {
		 
		 DBRowSet 				dbRowset 	= null;
		 int					sExistKnt	= 0;
		//query parameter
		Map<String, Object>		param 		= new HashMap<String, Object>();	

		try{
			if(tmpVO != null){
				Map<String, String> mapVO = tmpVO.getColumnValues();
				param.putAll(mapVO);
			}

			dbRowset 	= new SQLExecuter("").executeQuery((ISQLTemplate)new ScheduleNotificationManagementDBDAOCheckVslSkdCngNotificationTransmitByEstRSQL(), param, null);
			if(dbRowset.next())	sExistKnt	= Integer.parseInt(dbRowset.getString(1));
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return sExistKnt;
	}
    

	/**
	 * Vessel Schedule Notice 기본정보 setup 조회
	 * 
	 * @param  List<VslSkdCngHisVO> vslSkdCngHisVOs
	 * @return List<VslSkdCngNotificationTransmitLogVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<VslSkdCngNotificationTransmitLogVO> searchVslSkdChangeNotificationTargetList(List<VslSkdCngHisVO> vslSkdCngHisVOs) throws DAOException {
		 
		 DBRowSet 									dbRowset 	= null;
		 List<VslSkdCngNotificationTransmitLogVO>	list		= new ArrayList<VslSkdCngNotificationTransmitLogVO>();
		 
		//query parameter
		//Map<String, Object> 				param 		= new HashMap<String, Object>();
		//query parameter
		Map<String, Object> 				velParam 		= new HashMap<String, Object>();		 

		try{
			if(vslSkdCngHisVOs != null && vslSkdCngHisVOs.size()>0){
				velParam.put	("velParam", vslSkdCngHisVOs);
			}

			dbRowset 	= new SQLExecuter("").executeQuery((ISQLTemplate)new ScheduleNotificationManagementDBDAOSelectVslSkdCngNotificationTransmitTargetListRSQL(), null, velParam);
			list 		= (List)RowSetUtil.rowSetToVOs(dbRowset, VslSkdCngNotificationTransmitLogVO.class);
			
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
	 * Vessel Schedule Change Notification 발송이력저장<br>
	 * 
	 * @param List<VslSkdCngNotificationTransmitLogVO> vslSkdCngNotificationTransmitLogVOs
	 * @exception DAOException
	 */
	public void createVslSkdChangeNotificationTransmitLog(List<VslSkdCngNotificationTransmitLogVO> vslSkdCngNotificationTransmitLogVOs) throws DAOException {
		
		SQLExecuter sqlExe = new SQLExecuter("");
		
		try {
			int insHisCnt[] = null;
			if(vslSkdCngNotificationTransmitLogVOs != null && vslSkdCngNotificationTransmitLogVOs.size() > 0){
				insHisCnt = sqlExe.executeBatch((ISQLTemplate)new ScheduleNotificationManagementDBDAOCreateVslSkdCngNotificationTransmitLogCSQL(), vslSkdCngNotificationTransmitLogVOs, null);
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
	 * Vessel Schedule Change Notification 발송이력 UPDATE<br>
	 * 
	 * @param List<VslSkdCngHisVO> vslSkdCngHisVOs
	 * @exception DAOException
	 */
	public void modifyVslSkdChangeNotificationTransmitLog(List<VslSkdCngHisVO> vslSkdCngHisVOs) throws DAOException {
		
		SQLExecuter sqlExe = new SQLExecuter("");
		
		try {
			int insHisCnt[] = null;
			if(vslSkdCngHisVOs != null && vslSkdCngHisVOs.size() > 0){
				insHisCnt = sqlExe.executeBatch((ISQLTemplate)new ScheduleNotificationManagementDBDAOModifyVslSkdCngNotificationSetupListUSQL(), vslSkdCngHisVOs, null);
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
	
	
	
	/* Sequence 사용 주석 처리 
	public int searchtrsmHisSeq() throws DAOException {
		DBRowSet dbRowset = null;
		int trsmHisSeq = 0;

		try {
			dbRowset = new SQLExecuter("")
					.executeQuery(
							(ISQLTemplate) new ScheduleNotificationManagementDBDAOSearchTrsmHisSeqRSQL(),
							null, null);
			dbRowset.next();
			trsmHisSeq = dbRowset.getInt("TRSM_HIS_SEQ");

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return trsmHisSeq;
	}
*/
	

/*	이메일 등록 테이블 주석 처리 
	public void manageEtaSendTgtSkdEml(EtaSendTgtVO etaSendTgtVO)
			throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = etaSendTgtVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			String usrEml = etaSendTgtVO.getUsrEml();

			if (VSKGeneralUtil.isNotNull(usrEml)) {
				String[] usrEmlArr = usrEml.split(";");
				if (usrEmlArr != null && usrEmlArr.length > 0) {
					for (int i = 0; i < usrEmlArr.length; i++) {
						param.put("usr_eml", usrEmlArr[i]);
						SQLExecuter sqlExe = new SQLExecuter("");
						int result = sqlExe
								.executeUpdate(
										(ISQLTemplate) new ScheduleNotificationManagementDBDAOManageEtaSendTgtSkdEmlCSQL(),
										param, velParam);
						if (result == Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to insert SQL");
					}
				}
			}

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
*/
	
}
