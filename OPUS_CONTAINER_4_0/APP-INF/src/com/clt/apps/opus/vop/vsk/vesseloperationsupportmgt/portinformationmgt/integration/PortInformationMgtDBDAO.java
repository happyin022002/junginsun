/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PortInformationMgtDBDAO.java
*@FileTitle : Port Information Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.26
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2009.05.26 김종옥
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.portinformationmgt.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.portinformationmgt.basic.PortInformationMgtBCImpl;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.portinformationmgt.vo.MdmRhqComboVO;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.portinformationmgt.vo.MdmYardComboVO;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.portinformationmgt.vo.PortInformationConditionVO;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.portinformationmgt.vo.PortInformationMgtVO;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.portinformationmgt.vo.VskPortCnlPassCondVO;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.portinformationmgt.vo.VskPortCnlTrScgListVO;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.portinformationmgt.vo.VskPortDistVO;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.portinformationmgt.vo.VskPortDocBufTmVO;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.portinformationmgt.vo.VskPortNworkVO;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.portinformationmgt.vo.VskPortTrspCondVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.VskPortCnlTrScgVO;

/**
 * NIS2010 PortInformationMgtDBDAO <br>
 * - NIS2010-VesselOperationSupportMgt system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Kim Jong Ock
 * @see PortInformationMgtBCImpl 참조
 * @since J2EE 1.6
 */
public class PortInformationMgtDBDAO extends DBDAOSupport {

	/**
	 * Port Information Creation에 Maneuvering 을 조회 합니다.<br>
	 * 
	 * @param PortInformationConditionVO portInformationConditionVO
	 * @return List<PortInformationMgtVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<PortInformationMgtVO> searchManueveringList(PortInformationConditionVO portInformationConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PortInformationMgtVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(portInformationConditionVO != null){
				Map<String, String> mapVO = portInformationConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortInformationMgtDBDAOPortInformationMgtVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PortInformationMgtVO .class);
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
	 * Port Information Creation에 Terminal Non-Working 을 조회 합니다.<br>
	 * 
	 * @param PortInformationConditionVO portInformationConditionVO
	 * @return List<VskPortNworkVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<VskPortNworkVO> searchNonWorkingList(PortInformationConditionVO portInformationConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<VskPortNworkVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(portInformationConditionVO != null){
				Map<String, String> mapVO = portInformationConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortInformationMgtDBDAOVskPortNworkVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VskPortNworkVO .class);
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
	 * Port Information Creation에 Distance 을 조회 합니다.<br>
	 * 
	 * @param PortInformationConditionVO portInformationConditionVO
	 * @return List<VskPortDistVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<VskPortDistVO> searchDistanceList(PortInformationConditionVO portInformationConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<VskPortDistVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(portInformationConditionVO != null){
				Map<String, String> mapVO = portInformationConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortInformationMgtDBDAOVskPortDistVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VskPortDistVO .class);
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
	 * Port Information Creation에 Doc.&Dead Hrs 을 조회 합니다.<br>
	 * 
	 * @param PortInformationConditionVO portInformationConditionVO
	 * @return List<VskPortDocBufTmVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<VskPortDocBufTmVO> searchDocHourList(PortInformationConditionVO portInformationConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<VskPortDocBufTmVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(portInformationConditionVO != null){
				Map<String, String> mapVO = portInformationConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortInformationMgtDBDAOVskPortDocBufTmVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VskPortDocBufTmVO .class);
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
	 * Port Information Creation에 Canal 을 조회 합니다.<br>
	 * 
	 * @param PortInformationConditionVO portInformationConditionVO
	 * @return List<VskPortCnlPassCondVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<VskPortCnlPassCondVO> searchCanelList(PortInformationConditionVO portInformationConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<VskPortCnlPassCondVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(portInformationConditionVO != null){
				Map<String, String> mapVO = portInformationConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortInformationMgtDBDAOVskPortCnlPassCondVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VskPortCnlPassCondVO .class);
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
	 * Port Information Creation에 Canal 을 두번재 그리드 조회 합니다.<br>
	 * 
	 * @param PortInformationConditionVO portInformationConditionVO
	 * @return List<VskPortCnlTrScgListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<VskPortCnlTrScgListVO> searchPortCnlTrScgList(PortInformationConditionVO portInformationConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<VskPortCnlTrScgListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(portInformationConditionVO != null){
				Map<String, String> mapVO = portInformationConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortInformationMgtDBDAOVskPortCnlTrScgListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VskPortCnlTrScgListVO .class);
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
	 * Port Information Creation에 Canal 을 두번재 그리드 저장용 합니다.<br>
	 * 
	 * @param PortInformationConditionVO portInformationConditionVO
	 * @return List<VskPortCnlTrScgVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<VskPortCnlTrScgVO> searchPortCnlTrScg(PortInformationConditionVO portInformationConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<VskPortCnlTrScgVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(portInformationConditionVO != null){
				Map<String, String> mapVO = portInformationConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortInformationMgtDBDAOVskPortCnlTrScgVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VskPortCnlTrScgVO .class);
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
	 * Port Information Creation에 Trucking 을 조회 합니다.<br>
	 * 
	 * @param PortInformationConditionVO portInformationConditionVO
	 * @return List<VskPortTrspCondVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<VskPortTrspCondVO> searchTruckingList(PortInformationConditionVO portInformationConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<VskPortTrspCondVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(portInformationConditionVO != null){
				Map<String, String> mapVO = portInformationConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortInformationMgtDBDAOVskPortTrspCondVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VskPortTrspCondVO .class);
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
	 * Port Information Creation에 Railroad 을 조회 합니다.<br>
	 * 
	 * @param PortInformationConditionVO portInformationConditionVO
	 * @return List<VskPortTrspCondVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<VskPortTrspCondVO> searchRailLoadList(PortInformationConditionVO portInformationConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<VskPortTrspCondVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(portInformationConditionVO != null){
				Map<String, String> mapVO = portInformationConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortInformationMgtDBDAOVskPortTrspCondVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VskPortTrspCondVO .class);
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
	 *  Maneuvering에 등록 가능한 TMNL Code을 조회(콤보생성) 합니다.<br>
	 * 
	 * @param PortInformationConditionVO portInformationConditionVO
	 * @return List<MdmYardComboVO>
	 * @throws DAOException
		 */
	 @SuppressWarnings("unchecked")
	public List<MdmYardComboVO> searchMdmYardCombo(PortInformationConditionVO portInformationConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MdmYardComboVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(portInformationConditionVO != null){
				Map<String, String> mapVO = portInformationConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortInformationMgtDBDAOMdmYardComboRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MdmYardComboVO .class);
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
	 * 등록 가능한 Port 을 조회(콤보생성) 합니다.<br>
	 * 
	 * @param PortInformationConditionVO portInformationConditionVO
	 * @return List<MdmYardComboVO>
	 * @throws DAOException
		 */
	 @SuppressWarnings("unchecked")
	public List<MdmYardComboVO> searchMdmLocCdCombo(PortInformationConditionVO portInformationConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MdmYardComboVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(portInformationConditionVO != null){
				Map<String, String> mapVO = portInformationConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortInformationMgtDBDAOMdmLocCdComboRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MdmYardComboVO .class);
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
	  * 조회 조건에서 Port Code에 해당하는 RHQ를 조회 합니다.<br>
	 * 
	 * @param PortInformationConditionVO portInformationConditionVO
	 * @return List<MdmYardComboVO>
	 * @throws DAOException
		 */
	 @SuppressWarnings("unchecked")
	public List<MdmYardComboVO> searchMdmRhqLocCombo(PortInformationConditionVO portInformationConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MdmYardComboVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(portInformationConditionVO != null){
				Map<String, String> mapVO = portInformationConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortInformationMgtDBDAOMdmRhqLocComboRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MdmYardComboVO .class);
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
	 * Doc.&Dead Hrs 등록 가능한 Port 을 조회(콤보생성) 합니다.<br>
	 * 
	 * @param PortInformationConditionVO portInformationConditionVO
	 * @return List<MdmYardComboVO>
	 * @throws DAOException
		 */
	 @SuppressWarnings("unchecked")
	public List<MdmYardComboVO> searchMdmRhqDocLocCombo(PortInformationConditionVO portInformationConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MdmYardComboVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(portInformationConditionVO != null){
				Map<String, String> mapVO = portInformationConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortInformationMgtDBDAOMdmRhqDocLocComboRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MdmYardComboVO .class);
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
	 * RHQ Code 을 조회 합니다.<br>
	 * 
	 * @param PortInformationConditionVO portInformationConditionVO
	 * @return List<MdmYardComboVO>
	 * @throws DAOException
		 */
	 @SuppressWarnings("unchecked")
	public List<MdmYardComboVO> searchMdmTrspLocCombo(PortInformationConditionVO portInformationConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MdmYardComboVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(portInformationConditionVO != null){
				Map<String, String> mapVO = portInformationConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortInformationMgtDBDAOMdmTrspLocComboRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MdmYardComboVO .class);
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
	 * 등록 가능한 Port Code 을 조회(콤보생성) 합니다.<br>
	 * 
	 * @param PortInformationConditionVO portInformationConditionVO
	 * @return List<MdmRhqComboVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<MdmRhqComboVO> searchMdmRhqCombo(PortInformationConditionVO portInformationConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MdmRhqComboVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(portInformationConditionVO != null){
				Map<String, String> mapVO = portInformationConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortInformationMgtDBDAOMdmRhqComboRSQL(), param, velParam);
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
	 * Maneuvering 단건의 데이터를 생성한다.<br>
	 * 
	 * @param PortInformationMgtVO vo
	 * @throws DAOException
	 */
	public void addmanagePortInfo(PortInformationMgtVO vo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new PortInformationMgtDBDAOPortInformationMgtVOCSQL(), param, velParam);
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
	 * Maneuvering 단건의 데이터를 갱신한다.<br>
	 * 
	 * @param PortInformationMgtVO vo
	 * @return int
	 * @throws DAOException
	 */
	public int modifymanagePortInfo(PortInformationMgtVO vo) throws DAOException,Exception {
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
			result = sqlExe.executeUpdate((ISQLTemplate)new PortInformationMgtDBDAOPortInformationMgtVOUSQL(), param, velParam);
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
	 * Maneuvering 단건의 데이터를 삭제한다.<br>
	 * 
	 * @param PortInformationMgtVO vo
	 * @return int
	 * @throws DAOException
	 */
	public int removemanagePortInfo(PortInformationMgtVO vo) throws DAOException,Exception {
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
			result = sqlExe.executeUpdate((ISQLTemplate)new PortInformationMgtDBDAOPortInformationMgtVODSQL(), param, velParam);
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
	 * Maneuvering 다건의 데이터를 일괄적으로 생성한다.<br>
	 * 
	 * @param List<PortInformationMgtVO> insModels
	 * @throws DAOException
	 */
	public void addmanagePortInfoS(List<PortInformationMgtVO> insModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new PortInformationMgtDBDAOPortInformationMgtVOCSQL(), insModels,null);
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
	 * Maneuvering 다건의 데이터를 일괄적으로 갱신한다.<br>
	 * 
	 * @param List<PortInformationMgtVO> updModels
	 * @throws DAOException
	 */
	public void modifymanagePortInfoS(List<PortInformationMgtVO> updModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new PortInformationMgtDBDAOPortInformationMgtVOUSQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
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
	 * Maneuvering 다건의 데이터를 일괄적으로 삭제한다.<br>
	 * 
	 * @param List<PortInformationMgtVO> delModels
	 * @throws DAOException
	 */
	public void removemanagePortInfoS(List<PortInformationMgtVO> delModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new PortInformationMgtDBDAOPortInformationMgtVODSQL(), delModels,null);
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

/*tab2************************************start*/	
	
	 /**
	 * Terminal Non-Working 단건의 데이터를 생성한다.<br>
	 * 
	 * @param VskPortNworkVO vo
	 * @throws DAOException
	 */
	public void addPortNonWorking(VskPortNworkVO vo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new PortInformationMgtDBDAOVskPortNworkVOCSQL(), param, velParam);
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
	 * Terminal Non-Working 단건의 데이터를 갱신한다.<br>
	 * 
	 * @param VskPortNworkVO vo
	 * @return int
	 * @throws DAOException
	 */
	public int modifyPortNonWorking(VskPortNworkVO vo) throws DAOException,Exception {
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
			result = sqlExe.executeUpdate((ISQLTemplate)new PortInformationMgtDBDAOVskPortNworkVOUSQL(), param, velParam);
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
	 * Terminal Non-Working 단건의 데이터를 삭제한다.<br>
	 * 
	 * @param VskPortNworkVO vo
	 * @return int
	 * @throws DAOException
	 */
	public int removePortNonWorking(VskPortNworkVO vo) throws DAOException,Exception {
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
			result = sqlExe.executeUpdate((ISQLTemplate)new PortInformationMgtDBDAOVskPortNworkVODSQL(), param, velParam);
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
	 * Terminal Non-Working 다건의 데이터를 일괄적으로 생성한다.<br>
	 * 
	 * @param List<VskPortNworkVO> insModels
	 * @throws DAOException
	 */
	public void addPortNonWorkingS(List<VskPortNworkVO> insModels) throws DAOException,Exception {
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			VskPortNworkVO vskPortNworkVO = new VskPortNworkVO();
			
			if(insModels.size() > 0){
				for(int i = 0; i < insModels.size(); i++){
					vskPortNworkVO =  insModels.get(i);
					Map<String, String> mapVO = vskPortNworkVO.getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				
					int trd_result = sqlExe.executeUpdate((ISQLTemplate)new PortInformationMgtDBDAOVskPortNworkVOCSQL(), param, velParam);
					if(trd_result == Statement.EXECUTE_FAILED) {
						throw new DAOException("Fail to insert SQL");
					}						
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
	 * Terminal Non-Working 다건의 데이터를 일괄적으로 갱신한다.<br>
	 * 
	 * @param List<VskPortNworkVO> updModels
	 * @throws DAOException
	 */
	public void modifyPortNonWorkingS(List<VskPortNworkVO> updModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new PortInformationMgtDBDAOVskPortNworkVOUSQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
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
	 * Terminal Non-Working 다건의 데이터를 일괄적으로 삭제한다.<br>
	 * 
	 * @param List<VskPortNworkVO> delModels
	 * @throws DAOException
	 */
	public void removePortNonWorkingS(List<VskPortNworkVO> delModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new PortInformationMgtDBDAOVskPortNworkVODSQL(), delModels,null);
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
/*tab2************************************end*/
	
/*tab3************************************start*/	
	 /**
	 * Distance 단건의 데이터를 생성한다.<br>
	 * 
	 * @param VskPortDistVO vo
	 * @throws DAOException
	 */
	public void addPortDistance(VskPortDistVO vo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new PortInformationMgtDBDAOVskPortDistVOCSQL(), param, velParam);
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
	 * Distance 단건의 데이터를 갱신한다.<br>
	 * 
	 * @param VskPortDistVO vo
	 * @return int
	 * @throws DAOException
	 */
	public int modifyPortDistance(VskPortDistVO vo) throws DAOException,Exception {
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
			result = sqlExe.executeUpdate((ISQLTemplate)new PortInformationMgtDBDAOVskPortDistVOUSQL(), param, velParam);
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
	 * Distance 단건의 데이터를 삭제한다.<br>
	 * 
	 * @param VskPortDistVO vo
	 * @return int
	 * @throws DAOException
	 */
	public int removePortDistance(VskPortDistVO vo) throws DAOException,Exception {
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
			result = sqlExe.executeUpdate((ISQLTemplate)new PortInformationMgtDBDAOVskPortDistVODSQL(), param, velParam);
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
	 * Distance 다건의 데이터를 일괄적으로 생성한다.<br>
	 * 
	 * @param List<VskPortDistVO> insModels
	 * @throws DAOException
	 */
	public void addPortDistanceS(List<VskPortDistVO> insModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new PortInformationMgtDBDAOVskPortDistVOCSQL(), insModels,null);
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
	 * Distance 다건의 데이터를 일괄적으로 갱신한다.<br>
	 * 
	 * @param List<VskPortDistVO> updModels
	 * @throws DAOException
	 */
	public void modifyPortDistanceS(List<VskPortDistVO> updModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new PortInformationMgtDBDAOVskPortDistVOUSQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
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
	 * Distance 다건의 데이터를 일괄적으로 삭제한다.<br>
	 * 
	 * @param List<VskPortDistVO> delModels
	 * @throws DAOException
	 */
	public void removePortDistanceS(List<VskPortDistVO> delModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new PortInformationMgtDBDAOVskPortDistVODSQL(), delModels,null);
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
/*tab3************************************end*/

/*tab4************************************start*/
	 /**
	 * Doc.&Dead Hrs 단건의 데이터를 생성한다.<br>
	 * 
	 * @param VskPortDocBufTmVO vo
	 * @throws DAOException
	 */
	public void addPortDocHour(VskPortDocBufTmVO vo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new PortInformationMgtDBDAOVskPortDocBufTmVOCSQL(), param, velParam);
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
	 * Doc.&Dead Hrs 단건의 데이터를 갱신한다.<br>
	 * 
	 * @param VskPortDocBufTmVO vo
	 * @return int
	 * @throws DAOException
	 */
	public int modifyPortDocHour(VskPortDocBufTmVO vo) throws DAOException,Exception {
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
			result = sqlExe.executeUpdate((ISQLTemplate)new PortInformationMgtDBDAOVskPortDocBufTmVOUSQL(), param, velParam);
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
	 * Doc.&Dead Hrs 단건의 데이터를 삭제한다.<br>
	 * 
	 * @param VskPortDocBufTmVO vo
	 * @return int
	 * @throws DAOException
	 */
	public int removePortDocHour(VskPortDocBufTmVO vo) throws DAOException,Exception {
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
			result = sqlExe.executeUpdate((ISQLTemplate)new PortInformationMgtDBDAOVskPortDocBufTmVODSQL(), param, velParam);
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
	 * Doc.&Dead Hrs 다건의 데이터를 일괄적으로 생성한다.<br>
	 * 
	 * @param List<VskPortDocBufTmVO> insModels
	 * @throws DAOException
	 */
	public void addPortDocHourS(List<VskPortDocBufTmVO> insModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new PortInformationMgtDBDAOVskPortDocBufTmVOCSQL(), insModels,null);
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
	 * Doc.&Dead Hrs 다건의 데이터를 일괄적으로 갱신한다.<br>
	 * 
	 * @param List<VskPortDocBufTmVO> updModels
	 * @throws DAOException
	 */
	public void modifyPortDocHourS(List<VskPortDocBufTmVO> updModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new PortInformationMgtDBDAOVskPortDocBufTmVOUSQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
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
	 * Doc.&Dead Hrs 다건의 데이터를 일괄적으로 삭제한다.<br>
	 * 
	 * @param List<VskPortDocBufTmVO> delModels
	 * @throws DAOException
	 */
	public void removePortDocHourS(List<VskPortDocBufTmVO> delModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new PortInformationMgtDBDAOVskPortDocBufTmVODSQL(), delModels,null);
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
/*tab4************************************end*/	
	
/*tab5************************************start*/
	/**
	 * Canal 다건의 데이터를 일괄적으로 생성한다.<br>
	 * 
	 * @param List<VskPortCnlPassCondVO> insModels
	 * @throws DAOException
	 */
	public void addPortCanelS(List<VskPortCnlPassCondVO> insModels) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			VskPortCnlPassCondVO vskPortCnlPassCondVO = new VskPortCnlPassCondVO();
				
			if(insModels.size() > 0){
				for(int i = 0; i < insModels.size(); i++){
					vskPortCnlPassCondVO =  insModels.get(i);
					Map<String, String> mapVO = vskPortCnlPassCondVO.getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				
					int trd_result = sqlExe.executeUpdate((ISQLTemplate)new PortInformationMgtDBDAOVskPortCnlPassCondVOCSQL(), param, velParam);
					if(trd_result == Statement.EXECUTE_FAILED) {
						throw new DAOException("Fail to insert SQL");
					}						
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
	 * Canal 다건의 데이터를 일괄적으로 갱신한다.<br>
	 * 
	 * @param List<VskPortCnlPassCondVO> updModels
	 * @throws DAOException
	 */
	public void modifyPortCanelS(List<VskPortCnlPassCondVO> updModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new PortInformationMgtDBDAOVskPortCnlPassCondVOUSQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
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
	 * Canal 다건의 데이터를 일괄적으로 삭제한다.<br>
	 * 
	 * @param List<VskPortCnlPassCondVO> delModels
	 * @throws DAOException
	 */
	public void removePortCanelS(List<VskPortCnlPassCondVO> delModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new PortInformationMgtDBDAOVskPortCnlPassCondVODSQL(), delModels,null);
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
	 * Canal 두번째 그리드 다건의 데이터를 일괄적으로 갱신한다.<br>
	 * 
	 * @param List<VskPortCnlTrScgVO> updModels
	 * @throws DAOException
	 */
	public void modifyPortCnlTrScgS(List<VskPortCnlTrScgVO> updModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new PortInformationMgtDBDAOVskPortCnlTrScgVOUSQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
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
	 * Save Tier Surcharge<br>
	 * 
	 * @param List<VskPortCnlTrScgVO> tierScgVOList
	 * @throws DAOException
	 */
	public void addTierSurcharge(List<VskPortCnlTrScgVO> tierScgVOList) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(tierScgVOList.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new PortInformationMgtDBDAOAddTierSurchargeCSQL(), tierScgVOList, null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
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
	 * Delete Tier Surcharge<br>
	 * 
	 * @param List<VskPortCnlTrScgVO> tierScgVOList
	 * @throws DAOException
	 */
	public void removeTierSurcharge(List<VskPortCnlTrScgVO> tierScgVOList) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(tierScgVOList.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new PortInformationMgtDBDAORemoveTierSurchargeDSQL(), tierScgVOList, null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete No"+ i + " SQL");
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
/*tab5************************************end*/	

/*tab6************************************start*/
	 /**
	 * Trucking 단건의 데이터를 생성한다.<br>
	 * 
	 * @param VskPortTrspCondVO vo
	 * @throws DAOException
	 */
	public void addPortTrucking(VskPortTrspCondVO vo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new PortInformationMgtDBDAOVskPortTrspCondVOCSQL(), param, velParam);
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
	 * Trucking 단건의 데이터를 갱신한다.<br>
	 * 
	 * @param VskPortTrspCondVO vo
	 * @return int
	 * @throws DAOException
	 */
	public int modifyPortTrucking(VskPortTrspCondVO vo) throws DAOException,Exception {
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
			result = sqlExe.executeUpdate((ISQLTemplate)new PortInformationMgtDBDAOVskPortTrspCondVOUSQL(), param, velParam);
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
	 * Trucking 단건의 데이터를 삭제한다.<br>
	 * 
	 * @param VskPortTrspCondVO vo
	 * @return int
	 * @throws DAOException
	 */
	public int removePortTrucking(VskPortTrspCondVO vo) throws DAOException,Exception {
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
			result = sqlExe.executeUpdate((ISQLTemplate)new PortInformationMgtDBDAOVskPortTrspCondVODSQL(), param, velParam);
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
	 * Trucking 다건의 데이터를 일괄적으로 생성한다.<br>
	 * 
	 * @param List<VskPortTrspCondVO> insModels
	 * @throws DAOException
	 */
	public void addPortTruckingS(List<VskPortTrspCondVO> insModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new PortInformationMgtDBDAOVskPortTrspCondVOCSQL(), insModels,null);
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
	 * Trucking 다건의 데이터를 일괄적으로 갱신한다.<br>
	 * 
	 * @param List<VskPortTrspCondVO> updModels
	 * @throws DAOException
	 */
	public void modifyPortTruckingS(List<VskPortTrspCondVO> updModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new PortInformationMgtDBDAOVskPortTrspCondVOUSQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
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
	 * Trucking 다건의 데이터를 일괄적으로 삭제한다.<br>
	 * 
	 * @param List<VskPortTrspCondVO> delModels
	 * @throws DAOException
	 */
	public void removePortTruckingS(List<VskPortTrspCondVO> delModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new PortInformationMgtDBDAOVskPortTrspCondVODSQL(), delModels,null);
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
/*tab6************************************end*/	

/*tab7************************************start*/
	 /**
	 * Railroad 단건의 데이터를 생성한다.<br>
	 * 
	 * @param VskPortTrspCondVO vo
	 * @throws DAOException
	 */
	public void addPortRailLoad(VskPortTrspCondVO vo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new PortInformationMgtDBDAOVskPortTrspCondVOCSQL(), param, velParam);
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
	 * Railroad 단건의 데이터를 갱신한다.<br>
	 * 
	 * @param VskPortTrspCondVO vo
	 * @return int
	 * @throws DAOException
	 */
	public int modifyPortRailLoad(VskPortTrspCondVO vo) throws DAOException,Exception {
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
			result = sqlExe.executeUpdate((ISQLTemplate)new PortInformationMgtDBDAOVskPortTrspCondVOUSQL(), param, velParam);
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
	 * Railroad 단건의 데이터를 삭제한다.<br>
	 * 
	 * @param VskPortTrspCondVO vo
	 * @return int
	 * @throws DAOException
	 */
	public int removePortRailLoad(VskPortTrspCondVO vo) throws DAOException,Exception {
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
			result = sqlExe.executeUpdate((ISQLTemplate)new PortInformationMgtDBDAOVskPortTrspCondVODSQL(), param, velParam);
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
	 * 다건의 데이터를 일괄적으로 생성한다.<br>
	 * 
	 * @param List<VskPortTrspCondVO> insModels
	 * @throws DAOException
	 */
	public void addPortRailLoadS(List<VskPortTrspCondVO> insModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new PortInformationMgtDBDAOVskPortTrspCondVOCSQL(), insModels,null);
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
	 * Railroad 다건의 데이터를 일괄적으로 갱신한다.<br>
	 * 
	 * @param List<VskPortTrspCondVO> updModels
	 * @throws DAOException
	 */
	public void modifyPortRailLoadS(List<VskPortTrspCondVO> updModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new PortInformationMgtDBDAOVskPortTrspCondVOUSQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
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
	 * Railroad 다건의 데이터를 일괄적으로 삭제한다.<br>
	 * 
	 * @param List<VskPortTrspCondVO> delModels
	 * @throws DAOException
	 */
	public void removePortRailLoadS(List<VskPortTrspCondVO> delModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new PortInformationMgtDBDAOVskPortTrspCondVODSQL(), delModels,null);
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
/*tab7************************************end*/


	
}