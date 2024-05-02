/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : HongKongCustomsTransmissionDBDAO.java
*@FileTitle : UI_BKG-0282
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.20
*@LastModifier : 임재택
*@LastVersion : 1.0
* 2009.04.21 임재택
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.hongkong.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.hongkong.vo.HongKongManifestTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.hongkong.vo.HongKongSearchBkgQtyVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.hongkong.vo.HongKongSearchBkgVvdVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.hongkong.vo.HongKongSearchBlGeneralVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.hongkong.vo.HongKongSearchCntrDangerVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.hongkong.vo.HongKongSearchCntrDescVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.hongkong.vo.HongKongSearchCntrDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.hongkong.vo.HongKongSearchCntrListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.hongkong.vo.HongKongSearchMarksDescVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.hongkong.vo.HongKongSearchMsgHeaderVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.hongkong.vo.HongKongSearchQtyVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.hongkong.vo.HongKongSearchSentBlVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.hongkong.vo.HongKongSearchSentVslVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.hongkong.vo.HongKongSearchVslGeneralVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;


/**
 * NIS2010 HongKongCustomsTransmissionDBDAO <br>
 * - NIS2010-CustomsDeclaration system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author LIM JAE TAEK
 * @see HongKongCustomsTransmissionBCImpl 참조
 * @since J2EE 1.4
 */
public class HongKongCustomsTransmissionDBDAO extends DBDAOSupport {

	/**
	 * 홍콩세관에 전송한 Vessel 정보를 조회한다.
	 * searchVslGeneral ( ) 에서 사용
	 * @param HongKongManifestTransmitVO hongkongManifestTransmitVO
	 * @return List<HongKongSearchSentVslVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<HongKongSearchSentVslVO> searchSentVsl( 
			HongKongManifestTransmitVO hongkongManifestTransmitVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<HongKongSearchSentVslVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (hongkongManifestTransmitVO != null) {
				Map<String, String> mapVO = hongkongManifestTransmitVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			} 
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new HongKongCustomsTransmissionDBDAOsearchSentVslRSQL(),param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,
					HongKongSearchSentVslVO.class);
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
	 * 홍콩세관 신고용 Manifest Vessel General 정보를 조회한다.
	 * @param HongKongManifestTransmitVO hongkongManifestTransmitVO
	 * @return List<HongKongSearchVslGeneralVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<HongKongSearchVslGeneralVO> searchVslGeneral( 
			HongKongManifestTransmitVO hongkongManifestTransmitVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<HongKongSearchVslGeneralVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (hongkongManifestTransmitVO != null) {
				Map<String, String> mapVO = hongkongManifestTransmitVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			} 
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new HongKongCustomsTransmissionDBDAOsearchVslGeneralRSQL(),param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,
					HongKongSearchVslGeneralVO.class);
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
	 * 홍콩세관 신고용 Manifest Container List 를 조회한다.
	 * @param HongKongManifestTransmitVO hongkongManifestTransmitVO
	 * @return List<HongKongSearchCntrListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<HongKongSearchCntrListVO> searchCntrList( 
			HongKongManifestTransmitVO hongkongManifestTransmitVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<HongKongSearchCntrListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (hongkongManifestTransmitVO != null) {
				Map<String, String> mapVO = hongkongManifestTransmitVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			} 
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new HongKongCustomsTransmissionDBDAOsearchCntrListRSQL(),param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,
					HongKongSearchCntrListVO.class);
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
	 * 홍콩세관 신고용 Manifest Booking Qty 정보를 조회한다.
	 * @param HongKongManifestTransmitVO hongkongManifestTransmitVO
	 * @return List<HongKongSearchBkgQtyVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<HongKongSearchBkgQtyVO> searchBkgQty( 
			HongKongManifestTransmitVO hongkongManifestTransmitVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<HongKongSearchBkgQtyVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (hongkongManifestTransmitVO != null) {
				Map<String, String> mapVO = hongkongManifestTransmitVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			} 
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new HongKongCustomsTransmissionDBDAOsearchBkgQtyRSQL(),param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,
					HongKongSearchBkgQtyVO.class);
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
	 * 홍콩세관에 전송한 B/L 정보를 조회한다.
	 * @param HongKongManifestTransmitVO hongkongManifestTransmitVO
	 * @return List<HongKongSearchSentBlVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<HongKongSearchSentBlVO> searchSentBl( 
			HongKongManifestTransmitVO hongkongManifestTransmitVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<HongKongSearchSentBlVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (hongkongManifestTransmitVO != null) {
				Map<String, String> mapVO = hongkongManifestTransmitVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			} 
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new HongKongCustomsTransmissionDBDAOsearchSentBlRSQL(),param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,
					HongKongSearchSentBlVO.class);
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
	 * 홍콩세관 신고용 Manifest B/L General 정보를 조회한다.
	 * @param HongKongManifestTransmitVO hongkongManifestTransmitVO
	 * @return List<HongKongSearchBlGeneralVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<HongKongSearchBlGeneralVO> searchBlGeneral( 
			HongKongManifestTransmitVO hongkongManifestTransmitVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<HongKongSearchBlGeneralVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (hongkongManifestTransmitVO != null) {
				Map<String, String> mapVO = hongkongManifestTransmitVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			} 
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new HongKongCustomsTransmissionDBDAOsearchBlGeneralRSQL(),param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,
					HongKongSearchBlGeneralVO.class);
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
	 * 홍콩세관 신고용 Manifest Marks & Description 정보를 조회한다.
	 * @param HongKongManifestTransmitVO hongkongManifestTransmitVO
	 * @return List<HongKongSearchMarksDescVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<HongKongSearchMarksDescVO> searchMarkDesc( 
			HongKongManifestTransmitVO hongkongManifestTransmitVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<HongKongSearchMarksDescVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (hongkongManifestTransmitVO != null) {
				Map<String, String> mapVO = hongkongManifestTransmitVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			} 
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new HongKongCustomsTransmissionDBDAOsearchMarksDescRSQL(),param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,
					HongKongSearchMarksDescVO.class);
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
	 * 홍콩세관 신고용 Manifest Container Detail 정보를 조회한다.
	 * @param HongKongManifestTransmitVO hongkongManifestTransmitVO
	 * @return List<HongKongSearchCntrDetailVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<HongKongSearchCntrDetailVO> searchCntrDetail( 
			HongKongManifestTransmitVO hongkongManifestTransmitVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<HongKongSearchCntrDetailVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (hongkongManifestTransmitVO != null) {
				Map<String, String> mapVO = hongkongManifestTransmitVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			} 
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new HongKongCustomsTransmissionDBDAOsearchCntrDetailRSQL(),param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,
					HongKongSearchCntrDetailVO.class);
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
	 * 홍콩세관 신고용 Manifest Container Danger 정보를 조회한다.
	 * @param HongKongManifestTransmitVO hongkongManifestTransmitVO
	 * @return List<HongKongSearchCntrDangerVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<HongKongSearchCntrDangerVO> searchCntrDanger( 
			HongKongManifestTransmitVO hongkongManifestTransmitVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<HongKongSearchCntrDangerVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (hongkongManifestTransmitVO != null) {
				Map<String, String> mapVO = hongkongManifestTransmitVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			} 
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new HongKongCustomsTransmissionDBDAOsearchCntrDangerRSQL(),param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,
					HongKongSearchCntrDangerVO.class);
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
	 * 홍콩세관 신고용 Manifest Container Description 정보를 조회한다.
	 * @param HongKongManifestTransmitVO hongkongManifestTransmitVO
	 * @return List<HongKongSearchCntrDescVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<HongKongSearchCntrDescVO> searchCntrDesc( 
			HongKongManifestTransmitVO hongkongManifestTransmitVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<HongKongSearchCntrDescVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (hongkongManifestTransmitVO != null) {
				Map<String, String> mapVO = hongkongManifestTransmitVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			} 
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new HongKongCustomsTransmissionDBDAOsearchCntrDescRSQL(),param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,
					HongKongSearchCntrDescVO.class);
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
	 * 홍콩세관 신고용 Manifest Qty 정보를 조회한다.
	 * @param HongKongManifestTransmitVO hongkongManifestTransmitVO
	 * @return List<HongKongSearchQtyVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<HongKongSearchQtyVO> searchQty( 
			HongKongManifestTransmitVO hongkongManifestTransmitVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<HongKongSearchQtyVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (hongkongManifestTransmitVO != null) {
				Map<String, String> mapVO = hongkongManifestTransmitVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			} 
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new HongKongCustomsTransmissionDBDAOsearchQtyRSQL(),param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,
					HongKongSearchQtyVO.class);
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
	 * 홍콩세관 신고용 Manifest Booking VVD 정보를 조회한다.
	 * @param HongKongManifestTransmitVO hongkongManifestTransmitVO
	 * @return List<HongKongSearchBkgVvdVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<HongKongSearchBkgVvdVO> searchBkgVvd( 
			HongKongManifestTransmitVO hongkongManifestTransmitVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<HongKongSearchBkgVvdVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (hongkongManifestTransmitVO != null) {
				Map<String, String> mapVO = hongkongManifestTransmitVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			} 
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new HongKongCustomsTransmissionDBDAOsearchBkgVvdRSQL(),param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,
					HongKongSearchBkgVvdVO.class);
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
	 * 홍콩세관에 Manifest 신고한 VSL 전송 History를 생성한다.
	 * @param HongKongManifestTransmitVO hongkongManifestTransmitVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int addVslSendLog(HongKongManifestTransmitVO hongkongManifestTransmitVO) 
    throws DAOException,Exception {
		
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        
        int result = 0;
        try {
            Map<String, String> mapVO = hongkongManifestTransmitVO.getColumnValues();
            
           
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            result = new SQLExecuter("").executeUpdate((ISQLTemplate)new HongKongCustomsTransmissionDBDAOaddVslSendLogCSQL(), param, velParam);
            
            if(result == Statement.EXECUTE_FAILED) {
            	throw new DAOException("Fail to Update SQL");
            }
            
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
	 * 홍콩세관에 Manifest 신고한 BL 전송 History를 생성한다.
	 * @param HongKongManifestTransmitVO hongkongManifestTransmitVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int addBlSendLog(HongKongManifestTransmitVO hongkongManifestTransmitVO) 
    throws DAOException,Exception {
		
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        
        int result = 0;
        try {
            Map<String, String> mapVO = hongkongManifestTransmitVO.getColumnValues();
            
           
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            result = new SQLExecuter("").executeUpdate((ISQLTemplate)new HongKongCustomsTransmissionDBDAOaddBlSendLogCSQL(), param, velParam);
            
            if(result == Statement.EXECUTE_FAILED) {
            	throw new DAOException("Fail to Update SQL");
            }
            
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
	 * 전송 HEADER 내용을 가져온다.
	 * @return List<HongKongSearchMsgHeaderVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<HongKongSearchMsgHeaderVO> searchMsgHeader() throws DAOException {
		DBRowSet dbRowset = null;
		List<HongKongSearchMsgHeaderVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			 
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new HongKongCustomsTransmissionDBDAOsearchMsgHeaderRSQL(),param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,
					HongKongSearchMsgHeaderVO.class);
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
