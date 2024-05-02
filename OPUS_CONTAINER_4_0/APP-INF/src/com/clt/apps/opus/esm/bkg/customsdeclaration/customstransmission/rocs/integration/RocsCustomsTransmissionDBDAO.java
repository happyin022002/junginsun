/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RocsCustomsTransmissionDBDAO.java
*@FileTitle : UI_BKG-0061
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.15
*@LastModifier : 임재택
*@LastVersion : 1.0
* 2009.04.21 임재택
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.rocs.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.rocs.basic.RocsCustomsTransmissionBCImpl;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.rocs.vo.RocsManifestTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.rocs.vo.RocsSearchAwkCgoInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.rocs.vo.RocsSearchBlInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.rocs.vo.RocsSearchCmInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.rocs.vo.RocsSearchCntrInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.rocs.vo.RocsSearchDgCntrInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.rocs.vo.RocsSearchRfCntrInfoVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;


/**
 * OPUS RocsCustomsTransmissionDBDAO <br>
 * - OPUS-CustomsDeclaration system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author KIM SEUNG MIN
 * @see RocsCustomsTransmissionBCImpl 참조
 * @since J2EE 1.4
 */
public class RocsCustomsTransmissionDBDAO extends DBDAOSupport {

	/**
	 * RocsManifestListDownloadDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param RocsManifestTransmitVO rocsManifestTransmitVO
	 * @return List<RocsSearchBlInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RocsSearchBlInfoVO> searchBlInfo( 
			RocsManifestTransmitVO rocsManifestTransmitVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RocsSearchBlInfoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (rocsManifestTransmitVO != null) {
				Map<String, String> mapVO = rocsManifestTransmitVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			} 
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new RocsCustomsTransmissionDBDAOsearchBlInfoRSQL(),param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,
					RocsSearchBlInfoVO.class);
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
	 * RocsManifestListDownloadDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param RocsManifestTransmitVO rocsManifestTransmitVO
	 * @return List<RocsSearchCmInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RocsSearchCmInfoVO> searchCmInfo( 
			RocsManifestTransmitVO rocsManifestTransmitVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RocsSearchCmInfoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (rocsManifestTransmitVO != null) {
				Map<String, String> mapVO = rocsManifestTransmitVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			} 
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new RocsCustomsTransmissionDBDAOsearchCmInfoRSQL(),param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,
					RocsSearchCmInfoVO.class);
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
	 * RocsManifestListDownloadDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param RocsManifestTransmitVO rocsManifestTransmitVO
	 * @return List<RocsSearchDgCntrInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RocsSearchDgCntrInfoVO> searchDgCntrInfo( 
			RocsManifestTransmitVO rocsManifestTransmitVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RocsSearchDgCntrInfoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (rocsManifestTransmitVO != null) {
				Map<String, String> mapVO = rocsManifestTransmitVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			} 
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new RocsCustomsTransmissionDBDAOsearchDgCntrInfoRSQL(),param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,
					RocsSearchDgCntrInfoVO.class);
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
	 * RocsManifestListDownloadDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param RocsManifestTransmitVO rocsManifestTransmitVO
	 * @return List<RocsSearchRfCntrInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RocsSearchRfCntrInfoVO> searchRfCntrInfo( 
			RocsManifestTransmitVO rocsManifestTransmitVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RocsSearchRfCntrInfoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (rocsManifestTransmitVO != null) {
				Map<String, String> mapVO = rocsManifestTransmitVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			} 
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new RocsCustomsTransmissionDBDAOsearchRfCntrInfoRSQL(),param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,
					RocsSearchRfCntrInfoVO.class);
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
	 * RocsManifestListDownloadDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param RocsSearchCntrInfoVO rocsSearchCntrInfoVO
	 * @return List<RocsSearchAwkCgoInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RocsSearchAwkCgoInfoVO> searchAwkCgoInfo( 
			RocsSearchCntrInfoVO rocsSearchCntrInfoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RocsSearchAwkCgoInfoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (rocsSearchCntrInfoVO != null) {
				Map<String, String> mapVO = rocsSearchCntrInfoVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			} 
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new RocsCustomsTransmissionDBDAOsearchAwkCgoInfoRSQL(),param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,
					RocsSearchAwkCgoInfoVO.class);
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
	 * RocsManifestListDownloadDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param RocsManifestTransmitVO rocsManifestTransmitVO
	 * @return List<RocsSearchCntrInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RocsSearchCntrInfoVO> searchCntrInfo( 
			RocsManifestTransmitVO rocsManifestTransmitVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RocsSearchCntrInfoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (rocsManifestTransmitVO != null) {
				Map<String, String> mapVO = rocsManifestTransmitVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			} 
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new RocsCustomsTransmissionDBDAOsearchCntrInfoRSQL(),param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,
					RocsSearchCntrInfoVO.class);
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
	 * ROCS(ROTTERDAM) 세관 Manifest 전송 로그를 생성한다.
     * @param RocsManifestTransmitVO rocsManifestTransmitVO
	 * @return int 
     * @throws DAOException
     * @throws Exception	 
	 */
    public int addSendLog(RocsManifestTransmitVO rocsManifestTransmitVO) 
    throws DAOException,Exception {
		
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        
        int result = 0;
        try {
            Map<String, String> mapVO = rocsManifestTransmitVO.getColumnValues();
            
           
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            result = new SQLExecuter("").executeUpdate((ISQLTemplate)new RocsCustomsTransmissionDBDAOaddSendLogCSQL(), param, velParam);
            
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
     * ROCS(ROTTERDAM) 세관 Manifest Received 로그를 생성한다.
     * @param RocsManifestTransmitVO rocsManifestTransmitVO
     * @return int
     * @throws DAOException
     * @throws Exception
     */
    public int addReceivedLog(RocsManifestTransmitVO rocsManifestTransmitVO) 
    throws DAOException,Exception {
		
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        
        int result = 0;
        try {
            Map<String, String> mapVO = rocsManifestTransmitVO.getColumnValues();
            
           
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            result = new SQLExecuter("").executeUpdate((ISQLTemplate)new RocsCustomsTransmissionDBDAOaddReceivedLogCSQL(), param, velParam);
            
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
	 * ROCS(ROTTERDAM) 세관 Manifest 전송 로그(Detail)를 생성한다.
     * @param RocsManifestTransmitVO rocsManifestTransmitVO
	 * @return int
     * @throws DAOException
     * @throws Exception
	 */
    public int addSendLogDetail(RocsManifestTransmitVO rocsManifestTransmitVO) 
    throws DAOException,Exception {
		
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        
        int result = 0;
        try {
            Map<String, String> mapVO = rocsManifestTransmitVO.getColumnValues();
            
           
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            result = new SQLExecuter("").executeUpdate((ISQLTemplate)new RocsCustomsTransmissionDBDAOaddSendLogDetailCSQL(), param, velParam);
            
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
     *  ROCS(ROTTERDAM) 세관 Manifest Reseived 로그(Detail)를 생성한다.
     * @param RocsManifestTransmitVO rocsManifestTransmitVO
     * @return int
     * @throws DAOException
     * @throws Exception
     */
    public int addReceivedLogDetail(RocsManifestTransmitVO rocsManifestTransmitVO) 
    throws DAOException,Exception {
		
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        
        int result = 0;
        try {
            Map<String, String> mapVO = rocsManifestTransmitVO.getColumnValues();
            
           
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            result = new SQLExecuter("").executeUpdate((ISQLTemplate)new RocsCustomsTransmissionDBDAOaddReceivedLogDetailCSQL(), param, velParam);
            
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
     * ROCS (ROTTERDAM) 세관 Manifest 신고용 msgDt 를 조회한다. (Reference No로 사용)
     *조회한 msgDt는 Header 생성이나 modifyBlSndSts, addSendLog, addSendLogDetail 오퍼레이션의 Input 파라미터로 쓰인다.
     * @return String
     * @throws DAOException
     * @throws Exception
     */
    public String searchMsgDt() throws DAOException {
		String retVal = "";
		
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new RocsCustomsTransmissionDBDAOsearchMsgDtRSQL(), param, velParam);

			if(dbRowset.getRowCount() > 0) {
				
				if (dbRowset.next()) {
					retVal = dbRowset.getString(1);
				}
				
			}

			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return retVal;
	}
}
