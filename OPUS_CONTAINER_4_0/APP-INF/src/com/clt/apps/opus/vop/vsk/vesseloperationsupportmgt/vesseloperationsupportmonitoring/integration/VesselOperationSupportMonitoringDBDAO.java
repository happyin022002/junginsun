/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VesselOperationSupportMonitoringDBDAO.java
*@FileTitle : VOSI Update Monitoring
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.10
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2009.07.10 김종옥
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.vesseloperationsupportmonitoring.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.portinformationmgt.vo.MdmRhqComboVO;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.vesseloperationsupportmonitoring.basic.VesselOperationSupportMonitoringBCImpl;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.vesseloperationsupportmonitoring.vo.VosiUpdateMonitoringConditionVO;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.vesseloperationsupportmonitoring.vo.VosiUpdateMonitoringVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;

/**
 * ALPS VesselOperationSupportMonitoringDBDAO <br>
 * - ALPS-VesselOperationSupportMgt system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Kim Jong Ock
 * @see VesselOperationSupportMonitoringBCImpl 참조
 * @since J2EE 1.6
 */
public class VesselOperationSupportMonitoringDBDAO extends DBDAOSupport {

	/**
	 *  VOSI Update Monitoring 을 조회 합니다.<br>
	 * 
	 * @param VosiUpdateMonitoringConditionVO vosiUpdateMonitoringConditionVO
	 * @return List<VosiUpdateMonitoringVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<VosiUpdateMonitoringVO> searchVOSIUpdateList(VosiUpdateMonitoringConditionVO vosiUpdateMonitoringConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<VosiUpdateMonitoringVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vosiUpdateMonitoringConditionVO != null){
				Map<String, String> mapVO = vosiUpdateMonitoringConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselOperationSupportMonitoringDBDAOVosiUpdateMonitoringVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VosiUpdateMonitoringVO .class);
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
	 * 조회조건에 Port Code 유효성 체크 및 해당 Rhq을 조회 합니다.<br>
	 * 
	 * @param VosiUpdateMonitoringConditionVO vosiUpdateMonitoringConditionVO
	 * @return List<MdmRhqComboVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<MdmRhqComboVO> searchMdmRhqCombo(VosiUpdateMonitoringConditionVO vosiUpdateMonitoringConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MdmRhqComboVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vosiUpdateMonitoringConditionVO != null){
				Map<String, String> mapVO = vosiUpdateMonitoringConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselOperationSupportMonitoringDBDAOMdmRhqComboRSQL(), param, velParam);
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
}