/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName   : ConsortiumVoyageMgtDBDAO.java
*@FileTitle  : ConsortiumVoyageMgtDBDAO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.09.25
*@LastModifier : DONGSOO
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.scheduleutilitymanagement.consortiumvoyagemgt.integration;
 
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.vop.vsk.actualschedulemanagement.actualschedulemgt.integration.ActualScheduleMgtDBDAOModifyVskActPortSkdEdiLogUSQL;
import com.clt.apps.opus.vop.vsk.actualschedulemanagement.actualschedulemgt.integration.ActualScheduleMgtDBDAOSearchCallingIndicatorRSQL;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.basic.VesselScheduleMgtBCImpl;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration.VesselScheduleMgtDBDAOSearchVskVslPortSkdByVVDRSQL;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration.VesselScheduleMgtDBDAOSearchVskVslSkdByVVDRSQL;
import com.clt.apps.opus.vop.vsk.scheduleutilitymanagement.consortiumvoyagemgt.vo.ConsortiumVoyageVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.VskVslPortSkdVO;
import com.clt.syscommon.common.table.VskVslSkdVO;


/**
 * NIS2010 VesselScheduleMgtDBDAO <br>
 * - NIS2010-SchedulePlanningOperation system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author SEO CHANG YUL
 * @see VesselScheduleMgtBCImpl 참조
 * @since J2EE 1.4
 */
public class ConsortiumVoyageMgtDBDAO extends DBDAOSupport {

	private static final long serialVersionUID = 1L;

	/**
	 * Lane 별 Vessel Schedule 정보를 조회합니다.<br>
	 * 
	 * @param ConsortiumVoyageVO consortiumVoyageVO
	 * @return List<ConsortiumVoyageVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<ConsortiumVoyageVO> searchConsortiumVoyage(ConsortiumVoyageVO consortiumVoyageVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ConsortiumVoyageVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(consortiumVoyageVO != null){
				Map<String, String> mapVO = consortiumVoyageVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ConsortiumVoyageMgtDBDAOSearchConsortiumVoyageListRSQL(), param, velParam);
			
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ConsortiumVoyageVO.class);
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
	 * Lane 별 Vessel Schedule 정보를 조회합니다.<br>
	 * 
	 * @param List<ConsortiumVoyageVO> consortiumVoyageVOs
	 * @exception DAOException
	 */
	public void modifyConsortiumVoyage(List<ConsortiumVoyageVO> consortiumVoyageVOs) throws DAOException {
				
		try {						
			int insCnt[] = null;
			if(consortiumVoyageVOs.size() > 0) {				
				insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new ConsortiumVoyageMgtDBDAOConsortiumVoyageVOUSQL(), consortiumVoyageVOs, null, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}			
	}
	 
	 /**
	 * 데이타 모델을 DB에 저장한다.<br>
	 * 검색 조건에 따라 나타나지 않는 Virtual Port, 다음 항차의 첫번째 Port CSSM VOY No 업데이트 및 저장
	 * @param ConsortiumVoyageVO consortiumVoyageVO
	 * @throws DAOException
	 */
	public void updateVirtualConsortiumVoyage(ConsortiumVoyageVO consortiumVoyageVO) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			if(consortiumVoyageVO != null){
				Map<String, String> mapVO = consortiumVoyageVO .getColumnValues();
			 
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				int rtnCnt = sqlExe.executeUpdate((ISQLTemplate)new ConsortiumVoyageMgtDBDAOFirstVirtualPortConsortiumVoyageVOUSQL(), param, null);
				
				if(rtnCnt == Statement.EXECUTE_FAILED) throw new DAOException("Fail to Update SQL");
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
	 * 데이타 모델을 DB에 저장한다.<br>
	 * @param ConsortiumVoyageVO consortiumVoyageVO
	 * @throws DAOException
	 */
	public void updateConsortiumVoyage(ConsortiumVoyageVO consortiumVoyageVO) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			
			if(consortiumVoyageVO != null){
				Map<String, String> mapVO = consortiumVoyageVO .getColumnValues();
			 
				param.putAll(mapVO);
				
				int rtnCnt = sqlExe.executeUpdate((ISQLTemplate)new ConsortiumVoyageMgtDBDAOUpdateConsortiumVoyageUSQL(), param, null);
				
				if(rtnCnt == Statement.EXECUTE_FAILED) throw new DAOException("Fail to Update SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}  
	}
	
	
	// :: VIPS START ::
	 /**
	 * VIPS IF 를 위해 변경 사항 SKD정보를 찾는다.<br>
	 * 
	 * @param VskVslSkdVO vo
	 * @return VskVslSkdVO
	 * @throws DAOException
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
	 * VIPS IF 를 위해 변경 사항 SKD정보를 찾는다.<br>
	 * 
	 * @param VskVslSkdVO vo
	 * @return VskVslSkdVO
	 * @throws DAOException
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
	 * VIPS IF 를 위해 변경 사항 SKD정보를 찾는다.<br>
	 * 
	 * @param VskVslPortSkdVO vo
	 * @return List<VskVslPortSkdVO>
	 * @throws DAOException
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
	 * VIPS IF 를 위해 변경 사항 SKD정보를 찾는다.<br>
	 * 
	 * @param VskVslSkdVO vo
	 * @return List<VskVslPortSkdVO>
	 * @throws DAOException
	 */
	public List<VskVslPortSkdVO> searchVskVslPortSkdByVVD(VskVslSkdVO vo) throws DAOException {
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
	// :: VIPS END ::
}
