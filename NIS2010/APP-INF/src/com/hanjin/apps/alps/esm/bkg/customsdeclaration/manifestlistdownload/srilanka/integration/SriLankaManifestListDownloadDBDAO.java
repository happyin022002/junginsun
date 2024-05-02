/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : SriLankaManifestListDownloadDBDAO.java
 *@FileTitle : UI_BKG-0490
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.08.04
 *@LastModifier : 임재택
 *@LastVersion : 1.0
 * 2009.05.19 임재택
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.srilanka.vo.SriLankaVesselArrivalTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.basic.SriLankaManifestListDownloadBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.vo.BkgCstmsSriVvdVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.vo.SriLankaManifestListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.vo.SriLankaSearchBlListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.vo.SriLankaSearchCaptainNameVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.vo.SriLankaSearchCntrListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.vo.SriLankaSearchEtdDtVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.vo.SriLankaSearchEtdVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.vo.SriLankaSearchManifestVpsVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.vo.SriLankaSearchRegNoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.vo.SriLankaSearchRegistNoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.vo.SriLankaSearchResponseVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.vo.SriLankaSearchVesselArrivalVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.vo.SriLankaSearchVesselRegistNoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.vo.SriLankaSearchVesselVpsVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.vo.SriLankaSearchVsselNameVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.vo.SriLankaVesselArrivalCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.vo.SriLankaVesselArrivalVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

/**  
 * NIS2010 SriLankaManifestListDownloadDBDAO <br>
 * - NIS2010-CustomsDeclaration system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author LIM JAE TAEK
 * @see SriLankaManifestListDownloadBCImpl 참조
 * @since J2EE 1.4
 */
public class SriLankaManifestListDownloadDBDAO extends DBDAOSupport {

	private static final SriLankaVesselArrivalTransmitVO sriLankaVesselArrivalVO = null;

	/**
	 * 스리랑카세관 신고용 Manifest Vessel Port Schedule 정보를 조회한다.
	 * @param vslCd
	 * @param skdVoyNo
	 * @param skdDirCd
	 * @return List<SriLankaSearchManifestVpsVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SriLankaSearchManifestVpsVO> searchManifestVps(SriLankaManifestListCondVO sriLankaManifestListCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SriLankaSearchManifestVpsVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (sriLankaManifestListCondVO != null) {
				Map<String, String> mapVO = sriLankaManifestListCondVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			 
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new SriLankaManifestListDownloadDBDAOsearchManifestVpsRSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SriLankaSearchManifestVpsVO.class);
			 
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
	 * Estimated Vessel Departure 정보를 조회한다.
	 * @param String vslCd
	 * @param String skdVoyNo
	 * @param String skdDirCd
	 * @param String callPort
	 * @return List<SriLankaSearchEtdDtVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SriLankaSearchEtdDtVO> searchEtdDt(SriLankaManifestListCondVO sriLankaManifestListCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SriLankaSearchEtdDtVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (sriLankaManifestListCondVO != null) {
				Map<String, String> mapVO = sriLankaManifestListCondVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			 
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new SriLankaManifestListDownloadDBDAOsearchEtdDtRSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SriLankaSearchEtdDtVO.class);
			 
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
	 * Vessel Name을 조회한다.
	 * @param vslCd
	 * @return List<SriLankaSearchVsselNameVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SriLankaSearchVsselNameVO> searchVesselName(
			 String vslCd ) throws DAOException {
		DBRowSet dbRowset = null;
		List<SriLankaSearchVsselNameVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("vsl_cd", vslCd);
            velParam.put("vsl_cd", vslCd);
          
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new SriLankaManifestListDownloadDBDAOsearchVsselNameRSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SriLankaSearchVsselNameVO.class);
			 
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
	 * 스리랑카세관 Vessel Auth No 정보를 조회한다.
	 * @param vslNm
	 * @param skdVoyNo
	 * @param skdDirCd
	 * @return List<SriLankaSearchRegistNoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SriLankaSearchRegistNoVO> searchRegistNo(
			 String vslNm,String skdVoyNo,String skdDirCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<SriLankaSearchRegistNoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("vsl_nm", vslNm);
			velParam.put("vsl_nm", vslNm);
         
			param.put("skd_voy_no", skdVoyNo);
			velParam.put("skd_voy_no", skdVoyNo);
         
			param.put("skd_dir_cd", skdDirCd);
			velParam.put("skd_dir_cd", skdDirCd);
			 
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new SriLankaManifestListDownloadDBDAOsearchRegistNoRSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SriLankaSearchRegistNoVO.class);
			 
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
	 * 스리랑카세관으로 부터 수신된 응답문서 내용을 조회한다.
	 * @param String vslNm
	 * @param String skdVoyNo
	 * @param String skdDirCd
	 * @param String srStsCd
	 * @param String lkCstmsRspnDivCd
	 * @return List<SriLankaSearchResponseVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SriLankaSearchResponseVO> searchResponse(
			 String vslNm,String skdVoyNo,String skdDirCd,String srStsCd,String lkCstmsRspnDivCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<SriLankaSearchResponseVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("vsl_nm", vslNm);
			velParam.put("vsl_nm", vslNm);
        
			param.put("skd_voy_no", skdVoyNo);
			velParam.put("skd_voy_no", skdVoyNo);
        
			param.put("skd_dir_cd", skdDirCd);
			velParam.put("skd_dir_cd", skdDirCd);
			
			param.put("sr_sts_cd", srStsCd);
			velParam.put("sr_sts_cd", srStsCd);
			
			param.put("lk_cstms_rspn_div_cd", lkCstmsRspnDivCd);
			velParam.put("lk_cstms_rspn_div_cd", lkCstmsRspnDivCd);
			 
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new SriLankaManifestListDownloadDBDAOsearchResponseRSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SriLankaSearchResponseVO.class);
			 
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
	 * 스리랑카세관 신고용 B/L List 를 조회한다.
	 * @param SriLankaManifestListCondVO sriLankaManifestListCondVO
	 * @return List<SriLankaSearchBlListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SriLankaSearchBlListVO> searchBlList(SriLankaManifestListCondVO sriLankaManifestListCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SriLankaSearchBlListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (sriLankaManifestListCondVO != null) {
				Map<String, String> mapVO = sriLankaManifestListCondVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new SriLankaManifestListDownloadDBDAOsearchBlListRSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SriLankaSearchBlListVO.class);

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
	 * 스리랑카세관 신고용 Container List 정보를 조회한다.
	 * @param bkgNo
	 * @return List<SriLankaSearchCntrListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SriLankaSearchCntrListVO> searchCntrList(
			 String bkgNo, String polCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<SriLankaSearchCntrListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("bkg_no", bkgNo);
			velParam.put("bkg_no", bkgNo);
			param.put("pol_cd", polCd);
			velParam.put("pol_cd", polCd);
        
			 
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new SriLankaManifestListDownloadDBDAOsearchCntrListRSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SriLankaSearchCntrListVO.class);
			 
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
	 * Vessel Registration No 자동 생성
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SriLankaSearchVesselRegistNoVO> searchVesselRegistNo(
			 ) throws DAOException {
		DBRowSet dbRowset = null;
		List<SriLankaSearchVesselRegistNoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			 
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new SriLankaManifestListDownloadDBDAOsearchVesselRegistNoRSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SriLankaSearchVesselRegistNoVO.class);
			 
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
	 * 스리랑카세관 Vessel Registration No 정보를 조회한다.
	 * @param vslCd
	 * @param skdVoyNo
	 * @param skdDirCd
	 * @param podCd
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SriLankaSearchRegNoVO> searchRegNo(SriLankaVesselArrivalCondVO sriLankaVesselArrivalCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SriLankaSearchRegNoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = sriLankaVesselArrivalCondVO.getColumnValues();          
	           
            param.putAll(mapVO);
            velParam.putAll(mapVO);
			 
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new SriLankaManifestListDownloadDBDAOsearchRegNoRSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SriLankaSearchRegNoVO.class);
			 
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
	 * Vessel Port Schedule 정보를 조회한다.
	 * @param vslCd
	 * @param skdVoyNo
	 * @param skdDirCd
	 * @param podCd
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SriLankaSearchVesselVpsVO> searchVesselVps(SriLankaVesselArrivalCondVO sriLankaVesselArrivalCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SriLankaSearchVesselVpsVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = sriLankaVesselArrivalCondVO.getColumnValues();          
	           
            param.putAll(mapVO);
            velParam.putAll(mapVO);
			 
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new SriLankaManifestListDownloadDBDAOsearchVesselVpsRSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SriLankaSearchVesselVpsVO.class);
			 
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
	 * Vessel Estimated Date 정보를 조회한다.
	 * @param String vslCd
	 * @param String skdVoyNo
	 * @param String skdDirCd
	 * @param String callPort
	 * @return List<SriLankaSearchEtdVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SriLankaSearchEtdVO> searchEtd(SriLankaVesselArrivalCondVO sriLankaVesselArrivalCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SriLankaSearchEtdVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = sriLankaVesselArrivalCondVO.getColumnValues();          
	           
            param.putAll(mapVO);
            velParam.putAll(mapVO);
			 
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new SriLankaManifestListDownloadDBDAOsearchEtdRSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SriLankaSearchEtdVO.class);
			 
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
	 * Vessel Captain Name 정보를 조회한다.
	 * @param String vslCd
	 * @param String skdVoyNo
	 * @param String skdDirCd
	 * @param String podCd
	 * @param String vslRgstNo
	 * @return List<SriLankaSearchCaptainNameVO>
	 * @throws DAOException
	 */
	
	@SuppressWarnings("unchecked")
	public List<SriLankaSearchCaptainNameVO> searchCaptainName(SriLankaVesselArrivalCondVO sriLankaVesselArrivalCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SriLankaSearchCaptainNameVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = sriLankaVesselArrivalCondVO.getColumnValues();          
	           
            param.putAll(mapVO);
            velParam.putAll(mapVO);
         
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new SriLankaManifestListDownloadDBDAOsearchCaptainNameRSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SriLankaSearchCaptainNameVO.class);
			 
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
	 * 스리랑카세관 신고용 Vessel Arrival 정보 신규 생성 및 변경 여부를 구분하기 위해 기존 정보 유무를 확인한다.
	 * @param String vslCd
	 * @param String skdVoyNo
	 * @param String skdDirVd
	 * @param String podCd
	 * @param String vslRgstNo
	 * @return List<SriLankaSearchVesselArrivalVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SriLankaSearchVesselArrivalVO> searchVesselArrival(SriLankaVesselArrivalVO sriLankaVesselArrivalVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SriLankaSearchVesselArrivalVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = sriLankaVesselArrivalVO.getColumnValues();          
	           
            param.putAll(mapVO);
            velParam.putAll(mapVO);
        
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new SriLankaManifestListDownloadDBDAOsearchVesselArrivalRSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SriLankaSearchVesselArrivalVO.class);
			 
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
	 * 스리랑카세관 신고용 Vessel Arrival 정보를 생성한다.
	 * @param bkgCstmsSriVvdVO
	 * @return
	 * @throws DAOException
	 * @throws Exception
	 */
	public int addVesselArrival(BkgCstmsSriVvdVO bkgCstmsSriVvdVO) 
    throws DAOException,Exception {
		
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        
        int result = 0;
        try {
            Map<String, String> mapVO = bkgCstmsSriVvdVO.getColumnValues();
            
           
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            result = new SQLExecuter("").executeUpdate((ISQLTemplate)new SriLankaManifestListDownloadDBDAOaddVesselArrivalCSQL(), param, velParam);
            
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
	 * 스리랑카세관 신고용 Vessel Arrival 정보를 수정한다.
	 * @param bkgCstmsSriVvdVO
	 * @return
	 * @throws DAOException
	 * @throws Exception
	 */
	public int modifyVesselArrival(BkgCstmsSriVvdVO bkgCstmsSriVvdVO) 
    throws DAOException,Exception {
		
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        
        int result = 0;
        try {
            Map<String, String> mapVO = bkgCstmsSriVvdVO.getColumnValues();
            
           
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            result = new SQLExecuter("").executeUpdate((ISQLTemplate)new SriLankaManifestListDownloadDBDAOmodifyVesselArrivalUSQL(), param, velParam);
            
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
	 * SriLanka 세관에 신고할 Vessel Arrival 데이터를 전송한 뒤 Send Date를 저장한다.
	 * @param vslCd
	 * @param skdVoyNo
	 * @param skdDirCd
	 * @param podCd
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int modifySendDt(SriLankaVesselArrivalTransmitVO sriLankaVesselArrivalTransmitVO) 
    throws DAOException,Exception {
		
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        
        int result = 0;
        try {
            Map<String, String> mapVO = sriLankaVesselArrivalTransmitVO.getColumnValues();
            
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            result = new SQLExecuter("").executeUpdate((ISQLTemplate)new SriLankaManifestListDownloadDBDAOmodifySendDtUSQL(), param, velParam);
            
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
}

