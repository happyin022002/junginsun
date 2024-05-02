/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VoyagePerformanceMgtDBDAO.java
*@FileTitle : Voyage Performance
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.07
*@LastModifier : Choi Duk Woo
*@LastVersion : 1.0
* 2014.04.07 Choi Duk Woo
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.voyageperformancemgt.integration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.VslPortSkdVO;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.voyageperformancemgt.basic.VoyagePerformanceMgtBCImpl;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.voyageperformancemgt.vo.VoyagePerformanceVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;


/**
 * ALPS VoyagePerformanceMgtDBDAO <br>
 * - ALPS-Voyage Performance Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Choi Duk Woo
 * @see VoyagePerformanceMgtBCImpl 참조
 * @since J2EE 1.6
 */
public class VoyagePerformanceMgtDBDAO extends DBDAOSupport {

	private static final long serialVersionUID = 1L;
	
	/**
	 *  Voyage Performance 을 조회 합니다.<br>
	 * 
	 * @param VoyagePerformanceVO voyagePerformanceVO
	 * @return List<VoyagePerformanceVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<VoyagePerformanceVO> searchVoyagePerformance(VoyagePerformanceVO voyagePerformanceVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<VoyagePerformanceVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(voyagePerformanceVO != null){
				Map<String, String> mapVO = voyagePerformanceVO .getColumnValues();
			
				param.putAll	(mapVO);
				velParam.putAll	(mapVO);
				
				
				//Class 다중선택 값
/*				if(!voyagePerformanceVO.getVslCd().equals("")) {
					String vslCd = voyagePerformanceVO.getVslCd();
					List<String> vslCdList = new ArrayList<String>();
					StringTokenizer st2 = new StringTokenizer(vslCd, ",");
					if(!("").equals(vslCd)){
					    while (st2.hasMoreTokens()) {
					    	vslCdList.add(st2.nextToken());		
					    }
					    velParam.put("vsl_cd_list", vslCdList);
					}else {
						velParam.put("vsl_cd_list", "");
					}
				}*/
				
				//Class 다중선택 값
				if(!voyagePerformanceVO.getCntrDznCapa().equals("")) {
					String cntrDznCapa = voyagePerformanceVO.getCntrDznCapa();
					List<String> vslClassList = new ArrayList<String>();
					StringTokenizer st2 = new StringTokenizer(cntrDznCapa, ",");
					if(!("").equals(cntrDznCapa)){
					    while (st2.hasMoreTokens()) {
					    	vslClassList.add(st2.nextToken());		
					    }
					    velParam.put("vsl_class_list", vslClassList);
					}else {
						velParam.put("vsl_class_list", "");
					}
				}
				
				//Vessel Port to Port 다중선택 값
				if(!voyagePerformanceVO.getVslPort().equals("")) {
					String vslPort = voyagePerformanceVO.getVslPort();
					List<String> vslPortList = new ArrayList<String>();
					StringTokenizer st4 = new StringTokenizer(vslPort, ",");
					if(!("").equals(vslPort)){
					    while (st4.hasMoreTokens()) {
					    	vslPortList.add(st4.nextToken());		
					    }
					    velParam.put("vsl_port_list", vslPortList);
					}else {
						velParam.put("vsl_port_list", "");
					}
				}
				
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VoyagePerformanceMgtDBDAOSearchVoyagePerformanceListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VoyagePerformanceVO .class);
			
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
	 *  Vessel List 을 조회 합니다.<br>
	 * 
	 * @return List<VoyagePerformanceVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<VoyagePerformanceVO> searchVesselList() throws DAOException {
		DBRowSet dbRowset = null;
		List<VoyagePerformanceVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VoyagePerformanceMgtDBDAOSearchVesselListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VoyagePerformanceVO .class);
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
	 *  Lane List 을 조회 합니다.<br>
	 * 
	 * @return List<VoyagePerformanceVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<VoyagePerformanceVO> searchLanelList() throws DAOException {
		DBRowSet dbRowset = null;
		List<VoyagePerformanceVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VoyagePerformanceMgtDBDAOSearchLanelListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VoyagePerformanceVO .class);
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
	 * VVD 유효성을 체크 합니다.<br>
	 * 
	 * @param VoyagePerformanceVO voyagePerformanceVO
	 * @return List<VoyagePerformanceVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<VoyagePerformanceVO> checkVvdInvalid(VoyagePerformanceVO voyagePerformanceVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<VoyagePerformanceVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(voyagePerformanceVO != null){
				Map<String, String> mapVO = voyagePerformanceVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VoyagePerformanceMgtDBDAOCheckVvdInvalidRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VoyagePerformanceVO .class);
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
	 * VOP_VSK_0516 : Retrieve <br>
	 * VVD Port to Port 을 조회 합니다.<br>
	 * 
	 * @param VoyagePerformanceVO voyagePerformanceVO
	 * @return List<VoyagePerformanceVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<VoyagePerformanceVO> searchPortToPort(VoyagePerformanceVO voyagePerformanceVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<VoyagePerformanceVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(voyagePerformanceVO != null){
				Map<String, String> mapVO = voyagePerformanceVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VoyagePerformanceMgtDBDAOSearchPortToPortRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VoyagePerformanceVO .class);
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
	 * VOP_VSK_0516 : Retrieve <br>
	 * VVD Port to Port 을 조회 합니다.<br>
	 * 
	 * @param VslPortSkdVO vslPortSkdVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchCgoStowageCraneArrangement(VslPortSkdVO vslPortSkdVO) throws DAOException {
		
		DBRowSet 	dbRowset 	= null;
		String		sRtnValue	= null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			if(vslPortSkdVO != null){
				Map<String, String> mapVO = vslPortSkdVO.getColumnValues();
				param.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new VoyagePerformanceMgtDBDAOSearchCgoStowageCraneArrangementRSQL(), param, null);
			if(dbRowset.next())		sRtnValue	= dbRowset.getString(1);
			
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
	 * VOP_VSK_0516 : Retrieve <br>
	 * VVD Port to Port 을 조회 합니다.<br>
	 * 
	 * @param VslPortSkdVO vslPortSkdVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchCgoStowageCraneAvgArrangement(VslPortSkdVO vslPortSkdVO) throws DAOException {
		
		DBRowSet 	dbRowset 	= null;
		String		sRtnValue	= null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			if(vslPortSkdVO != null){
				Map<String, String> mapVO = vslPortSkdVO.getColumnValues();
				param.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("OPF_HJSBAT").executeQuery((ISQLTemplate)new VoyagePerformanceMgtDBDAOSearchCgoStowageCraneAvgArrangementRSQL(), param, null);
			if(dbRowset.next())		sRtnValue	= dbRowset.getString(1);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return sRtnValue;
	}
	
	
}