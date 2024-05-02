/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : PanamaManifestListDownloadDBDAO.java
 *@FileTitle : UI_BKG-0017
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.21
 *@LastModifier : 김승민
 *@LastVersion : 1.0
 * 2009.04.21 김승민
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.panama.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.panama.vo.PanamaManifestTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.panama.basic.PanamaManifestListDownloadBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.panama.vo.PanamaManifestListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.panama.vo.PanamaManifestListEmptyCargoDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.panama.vo.PanamaManifestListGeneralCargoDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.panama.vo.PanamaManifestListHazardousCargoDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.panama.vo.PanamaVesselCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.panama.vo.PanamaVesselVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.VesselVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

/**
 * ALPS PanamaManifestListDownloadDBDAO <br>
 * - ALPS-CustomsDeclaration system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author KIM SEUNG MIN
 * @see PanamaManifestListDownloadBCImpl 참조
 * @since J2EE 1.4
 */
public class PanamaManifestListDownloadDBDAO extends DBDAOSupport {

	/**
	 * Vessel 정보를 조회한다. (laneCd, etaDt, polCd, podCd)<br>
	 * 
	 * @param Object panamaManifestListCondVO
	 * @return List<VesselVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<VesselVO> searchVslInfo( 
			Object panamaManifestListCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<VesselVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (panamaManifestListCondVO != null) {
				Map<String, String> mapVO = ((PanamaManifestListCondVO)panamaManifestListCondVO).getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			} 
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new PanamaManifestListDownloadDBDAOsearchVslInfoRSQL(),param, velParam,true);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,
					PanamaVesselVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}	
	
	/**
	 * Vessel Call Sequence 정보를 조회한다.<br>
	 * 
	 * @param PanamaManifestListCondVO panamaManifestListCondVO
	 * @return String callSeq
	 * @throws DAOException
	 */
	public String searchCallSeq(
			PanamaManifestListCondVO panamaManifestListCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		String callSeq = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (panamaManifestListCondVO != null) {
				Map<String, String> mapVO = panamaManifestListCondVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PanamaManifestListDownloadDBDAOsearchCallSeqRSQL(),param, velParam,true);
			 if (dbRowset.next()) {
				 callSeq = dbRowset.getString(1);
			 } else {
				 callSeq = "";					 
			 }			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return callSeq;
	}
	
	/**
	 * General Cargo Detail 정보를 조회한다.<br>
	 * 
	 * @param PanamaManifestListCondVO panamaManifestListCondVO
	 * @return List<PanamaManifestListGeneralCargoDetailVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<PanamaManifestListGeneralCargoDetailVO> searchGeneralCargoDetail(
			PanamaManifestListCondVO panamaManifestListCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PanamaManifestListGeneralCargoDetailVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (panamaManifestListCondVO != null) {
				Map<String, String> mapVO = panamaManifestListCondVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			} 
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new PanamaManifestListDownloadDBDAOsearchGeneralCargoDetailRSQL(),param, velParam,true);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset,
					PanamaManifestListGeneralCargoDetailVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * Empty Cargo Detail 정보를 조회한다.<br>
	 * 
	 * @param PanamaManifestListCondVO panamaManifestListCondVO
	 * @return List<PanamaManifestListEmptyCargoDetailVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<PanamaManifestListEmptyCargoDetailVO> searchEmptyCargoDetail(
			PanamaManifestListCondVO panamaManifestListCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PanamaManifestListEmptyCargoDetailVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (panamaManifestListCondVO != null) {
				Map<String, String> mapVO = panamaManifestListCondVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			} 
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new PanamaManifestListDownloadDBDAOsearchEmptyCargoDetailRSQL(),param, velParam,true);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,
					PanamaManifestListEmptyCargoDetailVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * Hazardous Cargo Detail 정보를 조회한다.<br>
	 * 
	 * @param PanamaManifestListCondVO panamaManifestListCondVO
	 * @return List<PanamaManifestListHazardousCargoDetailVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<PanamaManifestListHazardousCargoDetailVO> searchHazardousCargoDetail(
			PanamaManifestListCondVO panamaManifestListCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PanamaManifestListHazardousCargoDetailVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (panamaManifestListCondVO != null) {
				Map<String, String> mapVO = panamaManifestListCondVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			} 
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new PanamaManifestListDownloadDBDAOsearchHazardousCargoDetailRSQL(),param, velParam,true);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,
					PanamaManifestListHazardousCargoDetailVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}	

	/**
	 * Panama를 통과하는 화물에 대한 Manifest를 ACP(Authority of Canal of Panama)에 신고하기 위해 등록했던 Vessel 정보를 조회한다. <br>
	 * 
	 * @param PanamaVesselCondVO panamaVesselCondVO
	 * @return List<VesselVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<VesselVO> searchVesselList(
			PanamaVesselCondVO panamaVesselCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<VesselVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (panamaVesselCondVO != null) {
				Map<String, String> mapVO = panamaVesselCondVO
						.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			} 
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new PanamaManifestListDownloadDBDAOsearchVesselListRSQL(),param, velParam,true);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,
					PanamaVesselVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * 신규 입력된 Vessel 정보를 BKG CUSTOMS PANAMA VVD에 저장한다.<br>
	 * 
	 * @param PanamaVesselVO panamaVesselVO
	 * @throws DAOException
	 */
	public void addVessel(PanamaVesselVO panamaVesselVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = panamaVesselVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);		
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new PanamaManifestListDownloadDBDAOaddVesselCSQL(), param, velParam,true);
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
	 * 수정된 Vessel 정보를 BKG CUSTOMS PANAMA VVD에 저장한다.<br>
	 * 
	 * @param PanamaVesselVO panamaVesselVO
	 * @return int result
	 * @throws DAOException
	 */
	public int modifyVessel(PanamaVesselVO panamaVesselVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = panamaVesselVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);	 
			log.info("####################");
			log.info(param);
			log.info("####################");
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new PanamaManifestListDownloadDBDAOmodifyVesselUSQL(), param, velParam,true);
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
	 * 수정된 Vessel 정보를 BKG CUSTOMS PANAMA VVD에 저장한다.<br>
	 * 
	 * @param PanamaManifestTransmitVO panamaManifestTransmitVO
	 * @return int result
	 * @throws DAOException
	 */
	public int modifySendHist(PanamaManifestTransmitVO panamaManifestTransmitVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = panamaManifestTransmitVO.getColumnValues(); 
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);	
			log.info("####################");
			log.info(param);
			log.info("####################");
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new PanamaManifestListDownloadDBDAOmodifySendHistUSQL(), param, velParam,true);
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

}

