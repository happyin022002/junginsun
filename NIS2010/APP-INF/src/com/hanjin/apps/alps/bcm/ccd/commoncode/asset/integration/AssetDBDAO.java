/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : AssetDBDAO.java
*@FileTitle : Asset
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.24
*@LastModifier : 조인영
*@LastVersion : 1.0
* 2011.02.24 조인영
* 1.0 Creation
=========================================================*/
  
package com.hanjin.apps.alps.bcm.ccd.commoncode.asset.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.bcm.ccd.commoncode.asset.basic.AssetBCImpl;
import com.hanjin.apps.alps.bcm.ccd.commoncode.asset.vo.ContainerSizeVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.asset.vo.ContainerTypeSizeVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.asset.vo.ContainerTypeVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.asset.vo.ContainerVesselVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.asset.vo.ContainerVesselIfVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.salesrepresentative.integration.SalesRepresentativeDBDAOAddSlsRepCodeCSQL;
import com.hanjin.apps.alps.bcm.ccd.commoncode.salesrepresentative.integration.SalesRepresentativeDBDAOModifySlsRepCodeUSQL;
import com.hanjin.apps.alps.bcm.ccd.commoncode.salesrepresentative.vo.SalesRepVO;
import com.hanjin.apps.alps.bcm.cms.custmanage.custmain.integration.CustMainDBDAOCheckCntCodeRSQL;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

/**
 * OPUS_CNTR-Asset <br>
 * OPUS_CNTR-Asset system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author 조인영
 * @see AssetBCImpl 참조
 * @since J2EE 1.6
 */

public class AssetDBDAO extends DBDAOSupport {
	
	/**
	 * Container Type 정보를 가져온다<br>
	 * 
	 * @param String cntrTpCd
	 * @return List<ContainerTypeVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	 
	public ContainerTypeVO searchContainerType(String cntrTpCd) throws DAOException {
		DBRowSet dbRowset = null;
		
		List<ContainerTypeVO> containerTypeVO = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		//velocity parameter
		Map<String, Object> vparam = new HashMap<String, Object>();

		try{
			//query parameter
			param.put("cntr_tp_cd", cntrTpCd);
			vparam.put("cntr_tp_cd", cntrTpCd);
		
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AssetDBDAOSearchContainerTypeRSQL(), param, vparam);
			containerTypeVO = (List)RowSetUtil.rowSetToVOs(dbRowset, ContainerTypeVO.class);
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		if (containerTypeVO.size() > 0)
			return containerTypeVO.get(0);
		else
			return null;
	}
    
	/**
	 * Container Type 정보를 저장한다(입력)<br>
	 * 
	 * @param containerTypeVO List<ContainerTypeVO>
	 * @throws DAOException
	 */
	public void addContainerType(ContainerTypeVO containerTypeVO) throws DAOException,Exception {
		int creCnt = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(containerTypeVO != null){
				Map<String, String> mapVO = containerTypeVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			creCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new AssetDBDAOAddContainerTypeCSQL(), param, velParam);

		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Container Type 정보를 저장한다(수정)<br>
	 * 
	 * @param containerTypeVO List<ContainerTypeVO>
	 * @throws DAOException
	 */
	public void modifyContainerType(ContainerTypeVO containerTypeVO) throws DAOException,Exception {
		int creCnt = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(containerTypeVO != null){
				Map<String, String> mapVO = containerTypeVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			creCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new AssetDBDAOModifyContainerTypeUSQL(), param, velParam);

		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Container Type 유무를 확인.<br>
	 * 
	 * @param String cntrTpCd
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet checkCntrTpCode(String cntrTpCd) throws DAOException {
		DBRowSet dbRowset = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> param = new HashMap<String, Object>();//parameter
			try {
				if(cntrTpCd != null){
					param.put("cntr_tp_cd", cntrTpCd);
				}			
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AssetDBDAOSearchContainerTypeRSQL(), param, null);
			} catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());			
			} catch(Exception ex){
				log.error(ex.getMessage(),ex);			
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}

			return dbRowset;
	}
	
	/**
	 * Container Size 정보를 가져온다<br>
	 * 
	 * @param String cntrSzCd
	 * @return List<ContainerSizeVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	 
	public ContainerSizeVO searchContainerSize(String cntrSzCd) throws DAOException {
		 DBRowSet dbRowset = null;
			
		 List<ContainerSizeVO> containerSizeVO = null;
			
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		//velocity parameter
		Map<String, Object> vparam = new HashMap<String, Object>();

		try{
			//query parameter
			param.put("cntr_sz_cd", cntrSzCd);
			vparam.put("cntr_sz_cd", cntrSzCd);
		
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AssetDBDAOSearchContainerSizeRSQL(), param, vparam);
			containerSizeVO = (List)RowSetUtil.rowSetToVOs(dbRowset, ContainerSizeVO.class);
		 
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
			if (containerSizeVO.size() > 0)
				return containerSizeVO.get(0);
			else
				return null;
	}
    
	/**
	 * Container Size 정보를 저장한다(입력)<br>
	 * 
	 * @param containerSizeVO List<ContainerSizeVO>
	 * @throws DAOException
	 */
	public void addContainerSize(ContainerSizeVO containerSizeVO) throws DAOException,Exception {
		int creCnt = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(containerSizeVO != null){
				Map<String, String> mapVO = containerSizeVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			creCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new AssetDBDAOAddContainerSizeCSQL(), param, velParam);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Container Size 정보를 저장한다(수정)<br>
	 * 
	 * @param containerSizeVO List<ContainerSizeVO>
	 * @throws DAOException
	 */
	public void modifyContainerSize(ContainerSizeVO containerSizeVO) throws DAOException,Exception {
		int creCnt = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(containerSizeVO != null){
				Map<String, String> mapVO = containerSizeVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			creCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new AssetDBDAOModifyContainerSizeUSQL(), param, velParam);

		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Container Size 유무를 확인.<br>
	 * 
	 * @param String cntrSzCd
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet checkCntrSzCode(String cntrSzCd) throws DAOException {
		DBRowSet dbRowset = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> param = new HashMap<String, Object>();//parameter
			try {
				if(cntrSzCd != null){
					param.put("cntr_sz_cd", cntrSzCd);
				}			
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AssetDBDAOSearchContainerSizeRSQL(), param, null);
			} catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());			
			} catch(Exception ex){
				log.error(ex.getMessage(),ex);			
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}

			return dbRowset;
	}
	
	/**
	 * Container Type Size 정보를 가져온다<br>
	 * 
	 * @param String cntrTpSzCd
	 * @return ContainerTypeSizeVO
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	 
	public ContainerTypeSizeVO searchContainerTypeSize(String cntrTpSzCd) throws DAOException {
		 DBRowSet dbRowset = null;
			
		 List<ContainerTypeSizeVO> containerTypeSizeVO = null;
			
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		//velocity parameter
		Map<String, Object> vparam = new HashMap<String, Object>();

		try{
			//query parameter
			param.put("cntr_tpsz_cd", cntrTpSzCd);
			vparam.put("cntr_tpsz_cd", cntrTpSzCd);
		
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AssetDBDAOSearchContainerTypeSizeRSQL(), param, vparam);
			containerTypeSizeVO = (List)RowSetUtil.rowSetToVOs(dbRowset, ContainerTypeSizeVO.class);
		 
		 
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		if (containerTypeSizeVO.size() > 0)
			return containerTypeSizeVO.get(0);
		else
			return null;
	}
    
	/**
	 * Container Type Size 정보를 저장한다(입력)<br>
	 * 
	 * @param containerTypeSizeVO List<ContainerTypeSizeVO>
	 * @throws DAOException
	 */
	public void addContainerTypeSize(ContainerTypeSizeVO containerTypeSizeVO) throws DAOException,Exception {
		int creCnt = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(containerTypeSizeVO != null){
				Map<String, String> mapVO = containerTypeSizeVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			creCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new AssetDBDAOAddContainerTypeSizeCSQL(), param, velParam);
		
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Container Type Size 정보를 저장한다(수정)<br>
	 * 
	 * @param containerTypeSizeVO List<ContainerTypeSizeVO>
	 * @throws DAOException
	 */
	public void modifyContainerTypeSize(ContainerTypeSizeVO containerTypeSizeVO) throws DAOException,Exception {
		int creCnt = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(containerTypeSizeVO != null){
				Map<String, String> mapVO = containerTypeSizeVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			creCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new AssetDBDAOModifyContainerTypeSizeUSQL(), param, velParam);
		
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Container Size 유무를 확인.<br>
	 * 
	 * @param String cntrTpszCd
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet checkCntrTpszCode(String cntrTpszCd) throws DAOException {
		DBRowSet dbRowset = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> param = new HashMap<String, Object>();//parameter
			try {
				if(cntrTpszCd != null){
					param.put("cntr_tpsz_cd", cntrTpszCd);
				}			
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AssetDBDAOSearchContainerTypeSizeRSQL(), param, null);
			} catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());			
			} catch(Exception ex){
				log.error(ex.getMessage(),ex);			
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}

			return dbRowset;
	}
	
	/**
	 * Container Vessel 정보를 가져온다<br>
	 * 
	 * @param String vslCd
	 * @return List<ContainerVesselVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	 
	public List<ContainerVesselVO> searchContainerVessel(String vslCd) throws DAOException {
		DBRowSet dbRowset = null;
		
		List<ContainerVesselVO> containerVesselVO = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		//velocity parameter
		Map<String, Object> vparam = new HashMap<String, Object>();

		try{
			//query parameter
			param.put("vsl_cd", vslCd);
			vparam.put("vsl_cd", vslCd);
		
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AssetDBDAOSearchContainerVesselRSQL(), param, vparam);
			containerVesselVO = (List)RowSetUtil.rowSetToVOs(dbRowset, ContainerVesselVO.class);
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return containerVesselVO;
	}
	 
	 /**
		 * Container Vessel 정보를 가져온다<br>
		 * 
		 * @param rqstNo String
		 * @return List<ContainerVesselVO>
		 * @throws DAOException
		 */
		 @SuppressWarnings("unchecked")
		 
		public List<ContainerVesselVO> searchContainerVesselRqst(String rqstNo) throws DAOException {
			DBRowSet dbRowset = null;
			
			List<ContainerVesselVO> containerVesselVO = null;
			
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			
			//velocity parameter
			Map<String, Object> vparam = new HashMap<String, Object>();

			try{
				//query parameter
				param.put("rqst_no", rqstNo);
				vparam.put("rqst_no", rqstNo);
			
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AssetDBDAOSearchContainerVesselRqstRSQL(), param, vparam);
				containerVesselVO = (List)RowSetUtil.rowSetToVOs(dbRowset, ContainerVesselVO.class);
				
			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			return containerVesselVO;
		}
    
	/**
	 * Container Vessel 정보를 저장한다(입력)<br>
	 * 
	 * @param containerVesselVO List<ContainerVesselVO>
	 * @throws DAOException
	 */
	public void addContainerVessel(ContainerVesselVO containerVesselVO) throws DAOException,Exception {
		//query parameter ,String usrId
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		//parameter Setting
		
		int result = 0;
		try {
			if(containerVesselVO !=null){
				Map<String, String> mapVO = containerVesselVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new AssetDBDAOAddContainerVesselCSQL(), param,velParam);
			if(result== Statement.EXECUTE_FAILED){
				throw new DAOException("Fail to insert SQL");
		}


		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Container Vessel 정보를 저장한다(입력)<br>
	 * 
	 * @param containerVesselVO List<ContainerVesselVO>
	 * @throws DAOException
	 */
	public void addContainerVesselRqst(List<ContainerVesselVO> containerVesselVO) throws DAOException,Exception {
		try {
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(containerVesselVO.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AssetDBDAOAddContainerVesselRqstCSQL(), containerVesselVO, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Container Vessel 정보를 저장한다(수정)<br>
	 * 
	 * @param containerVesselVO List<ContainerVesselVO>
	 * @throws DAOException
	 */
	public void modifyContainerVessel(ContainerVesselVO containerVesselVO) throws DAOException,Exception {
		//query parameter ,String usrId
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		//parameter Setting
		
		int result = 0;
		try {
			if(containerVesselVO !=null){
				Map<String, String> mapVO = containerVesselVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);

			}
			SQLExecuter sqlExe = new SQLExecuter("");
			
			result = sqlExe.executeUpdate((ISQLTemplate) new AssetDBDAOModifyContainerVesselUSQL(), param,velParam);
			if(result== Statement.EXECUTE_FAILED){
					throw new DAOException("Fail to insert SQL");
			}
		
			} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Container Vessel 정보를 저장한다(수정)<br>
	 * 
	 * @param containerVesselVO List<ContainerVesselVO>
	 * @throws DAOException
	 */
	public void modifyContainerVesselRqst(List<ContainerVesselVO> containerVesselVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(containerVesselVO.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate) new AssetDBDAOModifyContainerVesselRqstUSQL(), containerVesselVO, null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Container Vessel EAI I/F 정보를 생성한다.(BCM_CCD_0008) For EAI I/F process<br>
	 *  
	 * @param ContainerVesselIfVO containervesselifVO
	 * @exception DAOException
	 */

	public void addContainerVesselIf(ContainerVesselIfVO containervesselifVO) throws DAOException, Exception {
		//query parameter ,String usrId
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		//parameter Setting
		
		int result = 0;
		try {
			if(containervesselifVO != null){
				Map<String, String> mapVO = containervesselifVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}							
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new AssetDBDAOAddContainerVesselIfCSQL(), param,velParam);
			if(result == Statement.EXECUTE_FAILED){
				throw new DAOException("Fail to insert SQL");		
		}

		}catch(SQLException se) 
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} 
		catch(Exception ex) 
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
	}
	
	/**
	 * Container Vessel Ibis I/F 정보를 생성한다.(BCM_CCD_0008) For EAI I/F process<br>
	 *  
	 * @param ContainerVesselIfVO containervesselifVO
	 * @exception DAOException
	 */

	public void addContainerVesselIbisIf(ContainerVesselIfVO containervesselifVO) throws DAOException, Exception {
		//query parameter ,String usrId
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		//parameter Setting
		
		int result = 0;
		try {
			if(containervesselifVO != null){
				Map<String, String> mapVO = containervesselifVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}							
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new AssetDBDAOAddContainerVesselIbisIfCSQL(), param,velParam);
			if(result == Statement.EXECUTE_FAILED){
				throw new DAOException("Fail to insert SQL");		
		}

		}catch(SQLException se) 
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} 
		catch(Exception ex) 
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
	}

	/**
	 * Container Vessel EAI I/F 의 테이블(MDM_VSL_CNTR_IF)의 VSL_CNTR_IF_SEQ 생성값을 조회 합니다.(BCM_CCD_0008)<br>
	 * 
	 * @return 	DBRowSet 
	 * @exception DAOException
	 */
	public DBRowSet searchContainerVesselIfSeq() throws DAOException {
		// TODO Auto-generated method stub
		DBRowSet dbRowset = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체	
		try {		
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AssetDBDAOSearchContainerVesselIfSeqRSQL(), null, null);
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());			
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}
}
