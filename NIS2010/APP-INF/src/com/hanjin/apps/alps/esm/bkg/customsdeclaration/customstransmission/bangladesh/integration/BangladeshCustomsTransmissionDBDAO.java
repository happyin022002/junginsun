/*=========================================================
 *Copyright(c) 2009 CyberLogitec
*@FileName : BangladeshCustomsTransmissionDBDAO.java
*@FileTitle : UI_BKG-0490
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.10
*@LastModifier : 임재택
*@LastVersion : 1.0
* 2009.04.21 임재택
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.bangladesh.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.bangladesh.vo.BangladeshManifestTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.bangladesh.vo.BangladeshSearchBkgNoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.bangladesh.vo.BangladeshSearchBlGeneralVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.bangladesh.vo.BangladeshSearchFlagVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.bangladesh.vo.BangladeshSearchEtaVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.bangladesh.vo.BangladeshSearchEtdVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.bangladesh.vo.BangladeshSearchMakeHeaderVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.bangladesh.vo.BangladeshSearchPrePortVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.bangladesh.vo.BangladeshSearchBlMarkDescVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.bangladesh.vo.BangladeshSearchContainerVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;


/**
 * NIS2010 BangladeshCustomsTransmissionDBDAO <br>
 * - NIS2010-CustomsDeclaration system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author LIM JAE TAEK
 * @see BangladeshCustomsTransmissionBCImpl 참조
 * @since J2EE 1.4
 */
@SuppressWarnings("serial")
public class BangladeshCustomsTransmissionDBDAO extends DBDAOSupport {

	 
	/**
	 * 방글라데시 세관 신고용 Manifest Pre Port 정보를 조회한다.
	 * @param bangladeshManifestTransmitVO	 
	 * @return List<BangladeshSearchPrePortVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BangladeshSearchPrePortVO> searchPrePort( 
			BangladeshManifestTransmitVO bangladeshManifestTransmitVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BangladeshSearchPrePortVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (bangladeshManifestTransmitVO != null) {
				Map<String, String> mapVO = bangladeshManifestTransmitVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			} 
			 
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new BangladeshCustomsTransmissionDBDAOsearchPrePortRSQL(),param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,
					BangladeshSearchPrePortVO.class);
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
	 * 방글라데시 세관 신고용 Manifest Flag(country name) Date 정보를 조회한다.
	 * @param bangladeshManifestTransmitVO	
	 * @return List<BangladeshSearchFlagVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BangladeshSearchFlagVO> searchFlag( 
			BangladeshManifestTransmitVO bangladeshManifestTransmitVO	) throws DAOException {
			DBRowSet dbRowset = null;
			List<BangladeshSearchFlagVO> list = null;
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			// velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			try {
				if (bangladeshManifestTransmitVO != null) {
					Map<String, String> mapVO = bangladeshManifestTransmitVO.getColumnValues();

					param.putAll(mapVO);
					velParam.putAll(mapVO);
				} 
				 
				dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new BangladeshCustomsTransmissionDBDAOsearchVesselFlagRSQL(),param, velParam);
				list = (List) RowSetUtil.rowSetToVOs(dbRowset,
						BangladeshSearchFlagVO.class);
				
			
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
	 *  방글라데시 세관 신고용 Manifest Estimated Date 정보를 조회한다.
	 * @param bangladeshManifestTransmitVO	
	 * @return List<BangladeshSearchEtaVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BangladeshSearchEtaVO> searchEta( 
			BangladeshManifestTransmitVO bangladeshManifestTransmitVO	) throws DAOException {
		DBRowSet dbRowset = null;
		List<BangladeshSearchEtaVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (bangladeshManifestTransmitVO != null) {
				Map<String, String> mapVO = bangladeshManifestTransmitVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			} 
			 
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new BangladeshCustomsTransmissionDBDAOsearchEtaRSQL(),param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,
					BangladeshSearchEtaVO.class);
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
	 * 방글라데시 세관 신고용 Manifest Estimated Date 정보를 조회한다.
	 * @param bangladeshManifestTransmitVO	
	 * @return List<BangladeshSearchEtdVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BangladeshSearchEtdVO> searchEtd( 
			BangladeshManifestTransmitVO bangladeshManifestTransmitVO	) throws DAOException {
			DBRowSet dbRowset = null;
			List<BangladeshSearchEtdVO> list = null;
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			// velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			try {
				if (bangladeshManifestTransmitVO != null) {
					Map<String, String> mapVO = bangladeshManifestTransmitVO.getColumnValues();

					param.putAll(mapVO);
					velParam.putAll(mapVO);
				} 
				 
				dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new BangladeshCustomsTransmissionDBDAOsearchEtdRSQL(),param, velParam);
				list = (List) RowSetUtil.rowSetToVOs(dbRowset,
						BangladeshSearchEtdVO.class);
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
	 * 방글라데시 세관 신고용 B/L의 Booking Number 및 Cargo Type Code 를 조회한다.
	 * @param bangladeshManifestTransmitVO	
	 * @return List<BangladeshSearchBkgNoVO>
	 * @throws DAOException
	 */
		@SuppressWarnings("unchecked")
		public List<BangladeshSearchBkgNoVO> searchBkgNo( 
				BangladeshManifestTransmitVO bangladeshManifestTransmitVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<BangladeshSearchBkgNoVO> list = null;
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			// velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			try {
				if (bangladeshManifestTransmitVO != null) {
					Map<String, String> mapVO = bangladeshManifestTransmitVO.getColumnValues();

					param.putAll(mapVO);
					velParam.putAll(mapVO);
				} 
		        
				dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new BangladeshCustomsTransmissionDBDAOsearchBkgNoRSQL(),param, velParam);
				list = (List) RowSetUtil.rowSetToVOs(dbRowset,
						BangladeshSearchBkgNoVO.class);
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
		 * 방글라데시 세관 신고용 Manifest B/L General 정보를 조회한다.
		 * @param bangladeshManifestTransmitVO	
		 * @return List<BangladeshSearchBlGeneralVO>
		 * @throws DAOException
		 */
		@SuppressWarnings("unchecked")
		public List<BangladeshSearchBlGeneralVO> searchBlGeneral( 
				BangladeshManifestTransmitVO bangladeshManifestTransmitVO) throws DAOException {
				DBRowSet dbRowset = null;
				List<BangladeshSearchBlGeneralVO> list = null;
				// query parameter
				Map<String, Object> param = new HashMap<String, Object>();
				// velocity parameter
				Map<String, Object> velParam = new HashMap<String, Object>();
				try {
					if (bangladeshManifestTransmitVO != null) {
						Map<String, String> mapVO = bangladeshManifestTransmitVO.getColumnValues();

						param.putAll(mapVO);
						velParam.putAll(mapVO);
					} 
			        			        
					dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new BangladeshCustomsTransmissionDBDAOsearchBlGeneralRSQL(),param, velParam);
					list = (List) RowSetUtil.rowSetToVOs(dbRowset,
							BangladeshSearchBlGeneralVO.class);
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
		 * 방글라데시 세관 신고용 Manifest Container 정보를 조회한다.
		 * @param bangladeshManifestTransmitVO	
		 * @return List<BangladeshSearchContainerVO>
		 * @throws DAOException
		 */
		@SuppressWarnings("unchecked")
		public List<BangladeshSearchContainerVO> searchContainer( 
				BangladeshManifestTransmitVO bangladeshManifestTransmitVO) throws DAOException {
				DBRowSet dbRowset = null;
				List<BangladeshSearchContainerVO> list = null;
				// query parameter
				Map<String, Object> param = new HashMap<String, Object>();
				// velocity parameter
				Map<String, Object> velParam = new HashMap<String, Object>();
				try {
					if (bangladeshManifestTransmitVO != null) {
						Map<String, String> mapVO = bangladeshManifestTransmitVO.getColumnValues();

						param.putAll(mapVO);
						velParam.putAll(mapVO);
					} 
			        
					dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new BangladeshCustomsTransmissionDBDAOsearchContainerRSQL(),param, velParam);
					list = (List) RowSetUtil.rowSetToVOs(dbRowset,
							BangladeshSearchContainerVO.class);
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
		 * 방글라데시 세관 신고용 Manifest B/L Marks Description 정보를 조회한다.
		 * @param bangladeshManifestTransmitVO	
		 * @return List<BangladeshSearchBlMarkDescVO>
		 * @throws DAOException
		 */
		@SuppressWarnings("unchecked")
		public List<BangladeshSearchBlMarkDescVO> searchBlMarkDesc( 
				BangladeshManifestTransmitVO bangladeshManifestTransmitVO) throws DAOException {
				DBRowSet dbRowset = null;
				List<BangladeshSearchBlMarkDescVO> list = null;
				// query parameter
				Map<String, Object> param = new HashMap<String, Object>();
				// velocity parameter
				Map<String, Object> velParam = new HashMap<String, Object>();
				try {
					if (bangladeshManifestTransmitVO != null) {
						Map<String, String> mapVO = bangladeshManifestTransmitVO.getColumnValues();

						param.putAll(mapVO);
						velParam.putAll(mapVO);
					} 
			        
					dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new BangladeshCustomsTransmissionDBDAOsearchBlMarkDescRSQL(),param, velParam);
					list = (List) RowSetUtil.rowSetToVOs(dbRowset,
							BangladeshSearchBlMarkDescVO.class);
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
		 * FlatFile 만들기위하여 header부분 생성작업
		 * @return List<BangladeshSearchMakeHeaderVO>
		 * @throws DAOException
		 */
		@SuppressWarnings("unchecked")
		public List<BangladeshSearchMakeHeaderVO> searchMakeHeader() throws DAOException {
				DBRowSet dbRowset = null;
				List<BangladeshSearchMakeHeaderVO> list = null;
				// query parameter
				Map<String, Object> param = new HashMap<String, Object>();
				// velocity parameter
				Map<String, Object> velParam = new HashMap<String, Object>();
				try {
					 
					 
					dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new BangladeshCustomsTransmissionDBDAOsearchMakeHeaderRSQL(),param, velParam);
					list = (List) RowSetUtil.rowSetToVOs(dbRowset,
							BangladeshSearchMakeHeaderVO.class);
				} catch (SQLException se) {
					log.error(se.getMessage(), se);
					throw new DAOException(new ErrorHandler(se).getMessage());
				} catch (Exception ex) {
					log.error(ex.getMessage(), ex);
					throw new DAOException(new ErrorHandler(ex).getMessage());
				}
				return list;
			}
		
		
} 

