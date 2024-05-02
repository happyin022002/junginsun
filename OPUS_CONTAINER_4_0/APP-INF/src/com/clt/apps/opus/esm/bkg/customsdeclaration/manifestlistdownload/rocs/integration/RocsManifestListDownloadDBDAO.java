/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : PanamaManifestListDownloadDBDAO.java
 *@FileTitle : UI_BKG-0234
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.19
 *@LastModifier : 임재택
 *@LastVersion : 1.0
 * 2009.05.19 임재택
 * 1.0 Creation
 * ---------------------------------------------------
 * History
 * 2011.10.19 김보배 [CHM-201113922] [BKG] [ROCS] ADD Lane - 하드코딩 제거, lane 추가 테이블 관리
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.integration;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.BlKeyVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.BlSeqVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.CrnVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ReceiveLogVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.RecieveHistLogVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.TransmitHistVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.VesselArrivalVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.VesselVO;
import com.clt.syscommon.common.table.BkgHrdCdgCtntVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.rocs.vo.RocsManifestTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.basic.RocsManifestListDownloadBCImpl;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.vo.RocsBlKeyVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.vo.RocsBlModificationVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.vo.RocsBlVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.vo.RocsCmdModificationVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.vo.RocsCntrModificationVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.vo.RocsHistoryListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.vo.RocsManifestConfirmationVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.vo.RocsManifestListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.vo.RocsRcvHistCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.vo.RocsReceiveLogCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.vo.RocsSearchBkgListForNVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.vo.RocsSearchBkgNoForYVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.vo.RocsSearchBkgNoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.vo.RocsSearchBlCountVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.vo.RocsSearchBlInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.vo.RocsSearchCRNForAddVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.vo.RocsSearchCRNVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.vo.RocsSearchCargoDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.vo.RocsSearchCntrListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.vo.RocsSearchDiffBkgForYVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.vo.RocsSearchInboundBlListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.vo.RocsSearchPortListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.vo.RocsSearchRocsRcvHistByBlVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.vo.RocsSearchRocsReceiveListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.vo.RocsSearchRocsReceiveLogVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.vo.RocsSearchRocsSendHistByBlVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.vo.RocsSearchRocsSendListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.vo.RocsSearchVesselArrivalVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.vo.RocsSearchVslInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.vo.RocsTransmitHistCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.vo.RocsTransmitHistListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.vo.RocsVesselArrivalCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.vo.RocscrnVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
/**
 * OPUS RocsManifestListDownloadDBDAO <br>
 * - OPUS-CustomsDeclaration system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author LIM JAE TAEK
 * @see RocsManifestListDownloadBCImpl 참조
 * @since J2EE 1.4
 */
@SuppressWarnings("serial")
public class RocsManifestListDownloadDBDAO extends DBDAOSupport {

	
	/**
	 * ROCS(ROTTERDAM) 세관에 신고할 대상 CRN 정보를 조회한다.   	
	 * @param rocsManifestListCondVO
	 * @return List<CrnVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CrnVO> searchCRN(
			RocsManifestListCondVO rocsManifestListCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CrnVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (rocsManifestListCondVO != null) {
				Map<String, String> mapVO = rocsManifestListCondVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			} 
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new RocsManifestListDownloadDBDAOsearchCRNRSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset,
					RocsSearchCRNVO.class);
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
	 * ROCS(ROTTERDAM) 세관에 신고할 대상 CRN Detail 정보를 조회한다.   	  
	 * @param rocsManifestListCondVO
	 * @return List<CrnVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CrnVO> searchCRNInfo(
			RocsManifestListCondVO rocsManifestListCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CrnVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (rocsManifestListCondVO != null) {
				Map<String, String> mapVO = rocsManifestListCondVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			} 
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new RocsManifestListDownloadDBDAOsearCNRInfoRSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset,
					RocscrnVO.class);
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
	 * ROCS(ROTTERDAM) 세관에 신고할 대상 VVD 정보를 조회한다.   	   	  
	 * @param String vslCd
	 * @param String skdVoyNo
	 * @param String skdDirCd
	 * @return List<CrnVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CrnVO> searchVvdReg(
			 String vslCd,String skdVoyNo,String skdDirCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<CrnVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("vsl_cd", vslCd);
            velParam.put("vsl_cd", vslCd);
            
            param.put("skd_voy_no", skdVoyNo);
            velParam.put("skd_voy_no", skdVoyNo);
            
            param.put("skd_dir_cd", skdDirCd);
            velParam.put("skd_dir_cd", skdDirCd);
			 
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new RocsManifestListDownloadDBDAOsearchVVDRegRSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RocscrnVO.class);
			 
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
	 * CRN Creation 하기전에 vvd ,사용여부 체크
	 * @param frmCrnNumber
	 * @param vslCd
	 * @param skdVoyNo
	 * @param skdDirCd
	 * @return List<RocsSearchCRNForAddVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RocsSearchCRNForAddVO> searchCRNForAdd(
			 String frmCrnNumber,String vslCd,String skdVoyNo,String skdDirCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<RocsSearchCRNForAddVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("frm_crn_number", frmCrnNumber);
	        velParam.put("frm_crn_number", frmCrnNumber);
	           
			param.put("vsl_cd", vslCd);
            velParam.put("vsl_cd", vslCd);
           
           param.put("skd_voy_no", skdVoyNo);
           velParam.put("skd_voy_no", skdVoyNo);
           
           param.put("skd_dir_cd", skdDirCd);
           velParam.put("skd_dir_cd", skdDirCd);
			 
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new RocsManifestListDownloadDBDAOsearchCRNForAddRSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RocscrnVO.class);
			 
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
	 * ROCS(ROTTERDAM) 세관 신고용 Booking No List를 조회한다. (B/L Creation Indicator = 'N')
	 * @param frmCrnNumber
	 * @param polCd
	 * @return List<RocsSearchBkgListForNVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RocsSearchBkgListForNVO> searchBkgListForN(
			 String frmCrnNumber,String polCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<RocsSearchBkgListForNVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("crn_number", frmCrnNumber);
           velParam.put("crn_number", frmCrnNumber);
           
           param.put("pol_cd", polCd);
           velParam.put("pol_cd", polCd);
           
           
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new RocsManifestListDownloadDBDAOsearchBkgListForNRSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RocsSearchBkgListForNVO.class);
			 
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
	 * ROCS(ROTTERDAM) 세관 신고용 Cargo List를 조회한다. (B/L Creation Indicator = 'N')
	 * @param String frmCrnNumber
	 * @param String polCd
	 * @param String vslCd
	 * @param String skdVoyNo
	 * @param String skdDirCd
	 * @return List<RocsSearchBkgListForNVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RocsSearchBkgListForNVO> searchBkgCargoListForN(
			 String frmCrnNumber,String polCd, String vslCd, String skdVoyNo, String skdDirCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<RocsSearchBkgListForNVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("crn_number", frmCrnNumber);
           velParam.put("crn_number", frmCrnNumber);
           
           param.put("vsl_cd", vslCd);
           velParam.put("vsl_cd", vslCd);
           
           param.put("skd_voy_no", skdVoyNo);
           velParam.put("skd_voy_no", skdVoyNo);
           
           param.put("skd_dir_cd", skdDirCd);
           velParam.put("skd_dir_cd", skdDirCd);
           
           param.put("pol_cd", polCd);
           velParam.put("pol_cd", polCd);
           
           
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new RocsManifestListDownloadDBDAOsearchCargoListForNRSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RocsSearchBkgListForNVO.class);
			 
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
	 * ROCS(ROTTERDAM) 세관 신고용 데이터 중 Booking Table에는 있는데 Rocs Table에는 없는 Booking No List를 조회한다. (B/L Creation Indicator = 'Y')
	 * @param blvO
	 * @return List<RocsSearchDiffBkgForYVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RocsSearchDiffBkgForYVO> searchDiffBkgForN(
			RocsBlVO blvO ) throws DAOException {
		DBRowSet dbRowset = null;
		List<RocsSearchDiffBkgForYVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			
			 Map<String, String> mapVO = blvO.getColumnValues();
			 
			 param.putAll(mapVO);
             velParam.putAll(mapVO);
          
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new RocsManifestListDownloadDBDAOsearchDiffBkgForYRSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RocsSearchDiffBkgForYVO.class);
			 
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
	 * ROCS(ROTTERDAM) 세관 신고용 데이터 중 Booking Table에는 있는데 Rocs Table에는 없는 Booking No List를 조회한다. (B/L Creation Indicator = 'Y')
	 * @param blvO
	 * @return List<RocsSearchDiffBkgForYVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RocsSearchDiffBkgForYVO> searchDiffBkgForY(
			RocsBlVO blvO ) throws DAOException {
		DBRowSet dbRowset = null;
		List<RocsSearchDiffBkgForYVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			
			 Map<String, String> mapVO = blvO.getColumnValues();
			 
			 param.putAll(mapVO);
             velParam.putAll(mapVO);
          
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new RocsManifestListDownloadDBDAOsearchDiffBkgForYRSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RocsSearchDiffBkgForYVO.class);
			 
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
	 * bkgNo 를 조회한다.
	 * @param RocsBlVO blvO
	 * @return List<RocsSearchBkgNoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RocsSearchBkgNoVO> searchBkgNo(
			RocsBlVO blvO ) throws DAOException {
		DBRowSet dbRowset = null;
		List<RocsSearchBkgNoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			
			 Map<String, String> mapVO = blvO.getColumnValues();
			 
			 param.putAll(mapVO);
             velParam.putAll(mapVO);
          
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new RocsSearchListDownloadDBDAOsearchBkgNoRSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RocsSearchBkgNoVO.class);
			 
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
	 *  bkgNo 를 조회한다.
	 * @param RocsBlKeyVO blKeyVO
	 * @return List<RocsSearchBkgNoForYVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RocsSearchBkgNoForYVO> searchBkgNoForY(
			RocsBlKeyVO blKeyVO ) throws DAOException {
		DBRowSet dbRowset = null;
		List<RocsSearchBkgNoForYVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			
			 Map<String, String> mapVO = blKeyVO.getColumnValues();
			 
			 param.putAll(mapVO);
             velParam.putAll(mapVO);
          
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new RocsManifestListDownloadDBDAOsearchBkgNoForYRSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RocsSearchBkgNoForYVO.class);
			 
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
	 * ROCS(ROTTERDAM) 세관에 신고할 대상 CRN 정보를 조회한다.  
	 * @param String frmCrnNumber
	 * @param String vslCd 	   	  
	 * @param String skdVoyNo
	 * @param String skdDirCd 	   	  
	 * @return List<CrnVO>
	  * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CrnVO> searchCRN(
			String frmCrnNumber,String vslCd,String skdVoyNo,String skdDirCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<CrnVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("vsl_cd", vslCd);
            velParam.put("vsl_cd", vslCd);
            
            param.put("skd_voy_no", skdVoyNo);
            velParam.put("skd_voy_no", skdVoyNo);
            
            param.put("skd_dir_cd", skdDirCd);
            velParam.put("skd_dir_cd", skdDirCd);
            
            param.put("frm_crn_number", frmCrnNumber);
            velParam.put("frm_crn_number", frmCrnNumber);
            
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new RocsManifestListDownloadDBDAOsearchCRNRSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset,
					RocscrnVO.class);
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
	 * 단건의 데이터를 생성한다.<br>
	 * 
	 * @param CrnVO crnVO
	 * @return int
	 * @throws DAOException
	 */
     public int addCRN(CrnVO crnVO) throws DAOException,Exception {
		
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        RocscrnVO  rocsCrnVO = new RocscrnVO();
    	rocsCrnVO = (RocscrnVO)crnVO;
        
        int result = 0;
        try {
            Map<String, String> mapVO = rocsCrnVO.getColumnValues();
            
           String vvdCd = mapVO.get("vvd_number");
			
			if(!vvdCd.equals("")) {
				mapVO.put("vsl_cd", vvdCd.substring(0, 4));
				mapVO.put("skd_voy_no", vvdCd.substring(4, 8));
				mapVO.put("skd_dir_cd", vvdCd.substring(8, 9));
			} 
			
             
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            result = new SQLExecuter("").executeUpdate((ISQLTemplate)new RocsManifestListDownloadDBDAOaddCRNCSQL(), param, velParam);
            
            if(result == Statement.EXECUTE_FAILED) {
            	throw new DAOException("Fail to insert SQL");
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
 	 * 단건의 데이터를 갱신한다.<br>
 	 * 
 	 * @param CrnVO crnVO
 	 * @return int
 	 * @throws DAOException
 	 */
      public int modifyCRN(CrnVO crnVO) throws DAOException,Exception {
 		
         //query parameter
         Map<String, Object> param = new HashMap<String, Object>();
         //velocity parameter
         Map<String, Object> velParam = new HashMap<String, Object>();
         RocscrnVO  rocsCrnVO = new RocscrnVO();
     	rocsCrnVO = (RocscrnVO)crnVO;
         int result = 0;
         try {
             Map<String, String> mapVO = rocsCrnVO.getColumnValues();
              
             param.putAll(mapVO);
             velParam.putAll(mapVO);
             
             result = new SQLExecuter("").executeUpdate((ISQLTemplate)new RocsManifestLIstDownloadDBDAOmodifyCRNUSQL(), param, velParam);
             
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
   	 * ROCS(ROTTERDAM) 세관에 신고할 대상 Vessel ETA, ETD, Booking Count 정보를 조회한다.<br>
   	 * 
   	 * @param RocsManifestListCondVO rocsManifestListCondVO
   	 * @return List<VesselVO>
   	 * @throws DAOException
   	 */
      @SuppressWarnings("unchecked")
	public List<VesselVO> searchVslInfo(
			RocsManifestListCondVO rocsManifestListCondVO) throws DAOException {
  		DBRowSet dbRowset = null;
  		List<VesselVO> list = null;
  		 
  		// query parameter
  		Map<String, Object> param = new HashMap<String, Object>();
  		// velocity parameter
  		Map<String, Object> velParam = new HashMap<String, Object>();

  		try {
  			Map<String, String> mapVO = rocsManifestListCondVO.getColumnValues();
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
  			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new RocsManifestListDownloadDBDAOsearchVslInfoRSQL(),param, velParam);
  			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RocsSearchVslInfoVO.class);
  		
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
     	 * ROCS(ROTTERDAM) 세관에 신고할 대상 BL 별 정보를 조회한다.<br>
     	 * 
     	 * @param RocsManifestListCondVO rocsManifestListCondVO
     	 * @return List<RocsManifestConfirmationVO>
     	 * @throws DAOException
     	 */
        @SuppressWarnings("unchecked")
  	public List<RocsManifestConfirmationVO> searchBlList(
  			RocsManifestListCondVO rocsManifestListCondVO) throws DAOException {
    		DBRowSet dbRowset = null;
    		List<RocsManifestConfirmationVO> list = null;
    		// query parameter
    		Map<String, Object> param = new HashMap<String, Object>();
    		// velocity parameter
    		Map<String, Object> velParam = new HashMap<String, Object>();

    		try {
    			Map<String, String> mapVO = rocsManifestListCondVO.getColumnValues();
              
              param.putAll(mapVO);
              velParam.putAll(mapVO);
    			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new RocsManifestListDownloadDBDAOsearchBlListRSQL(),param, velParam);
    			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RocsManifestConfirmationVO.class);
    		
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
    	 *ROCS(ROTTERDAM) 세관에 신고할 대상 POL 별 정보를 조회한다.	   	  
    	 * @param RocsManifestListCondVO rocsManifestListCondVO
     	 * @return List<RocsSearchPortListVO>
     	 * @throws DAOException
    	 */
        @SuppressWarnings("unchecked")
		public List<RocsSearchPortListVO> searchPortList(
    			RocsManifestListCondVO rocsManifestListCondVO) throws DAOException {
    		DBRowSet dbRowset = null;
    		List<RocsSearchPortListVO> list = null;
    		// query parameter
    		Map<String, Object> param = new HashMap<String, Object>();
    		// velocity parameter
    		Map<String, Object> velParam = new HashMap<String, Object>();

    		try {
    			if (rocsManifestListCondVO != null) {
    				Map<String, String> mapVO = rocsManifestListCondVO.getColumnValues();

    				param.putAll(mapVO);
    				velParam.putAll(mapVO);
    			} 
    			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new RocsManifestListDownloadDBDAOsearchPortListRSQL(),param, velParam);
    			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RocsSearchPortListVO.class);
    			 
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
    	 * BL별 count 정보를 가져온다.  	  
    	  * @param RocsManifestListCondVO rocsManifestListCondVO
     	 * @return List<RocsSearchBlCountVO>
     	 * @throws DAOException
    	 */
        @SuppressWarnings("unchecked")
		public List<RocsSearchBlCountVO> searchBlCount(
    			RocsManifestListCondVO rocsManifestListCondVO) throws DAOException {
    		DBRowSet dbRowset = null;
    		List<RocsSearchBlCountVO> list = null;
    		// query parameter
    		Map<String, Object> param = new HashMap<String, Object>();
    		// velocity parameter
    		Map<String, Object> velParam = new HashMap<String, Object>();

    		try {
    			if (rocsManifestListCondVO != null) {
    				Map<String, String> mapVO = rocsManifestListCondVO.getColumnValues();

    				param.putAll(mapVO);
    				velParam.putAll(mapVO);
    			} 
    			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new RocsManifestListDownloadDBDAOsearchBlCountRSQL(),param, velParam);
    			 
    			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RocsSearchBlCountVO.class);
    			 
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
    	 *ROCS(ROTTERDAM) 세관에 신고할 대상 Manifest List를 전송하기 전에 데이터를 확인했다는 의미로 Confirm Indicator를 업데이트할때 사용하기 위해
         *Container 정보가 존재하는지 여부를 조회한다.	   	  
    	 * @param RocsManifestConfirmationVO rocsManifestConfirmationVO
     	 * @return List<RocscrnVO>
     	 * @throws DAOException
    	 */
        @SuppressWarnings("unchecked")
		public List<RocscrnVO> searchCntrForCfm(
        		RocsManifestConfirmationVO rocsManifestConfirmationVO) throws DAOException {
    		DBRowSet dbRowset = null;
    		List<RocscrnVO> list = null;
    		// query parameter
    		Map<String, Object> param = new HashMap<String, Object>();
    		// velocity parameter
    		Map<String, Object> velParam = new HashMap<String, Object>();

    		try {
    			if (rocsManifestConfirmationVO != null) {
    				Map<String, String> mapVO = rocsManifestConfirmationVO.getColumnValues();

    				param.putAll(mapVO);
    				velParam.putAll(mapVO);
    			} 
    			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new RocsManifestListDownloadDBDAOsearchCntrForCfmRSQL(),param, velParam);
    			     			
    			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RocscrnVO.class);
    			 
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
    	 *ROCS(ROTTERDAM) 세관에 신고할 대상 Manifest List를 전송하기 전에 데이터를 확인했다는 의미로 Confirm Indicator를 업데이트할때 사용하기 위해
         *Cargo Description 정보가 존재하는지 여부를 조회한다.  	  
    	 * @param RocsManifestConfirmationVO rocsManifestConfirmationVO
     	 * @return List<RocscrnVO>
     	 * @throws DAOException
    	 */
        @SuppressWarnings("unchecked")
		public List<RocscrnVO> searchCmdForCfm(
        		RocsManifestConfirmationVO rocsManifestConfirmationVO) throws DAOException {
    		DBRowSet dbRowset = null;
    		List<RocscrnVO> list = null;
    		// query parameter
    		Map<String, Object> param = new HashMap<String, Object>();
    		// velocity parameter
    		Map<String, Object> velParam = new HashMap<String, Object>();

    		try {
    			if (rocsManifestConfirmationVO != null) {
    				Map<String, String> mapVO = rocsManifestConfirmationVO.getColumnValues();

    				param.putAll(mapVO);
    				velParam.putAll(mapVO);
    			} 
    			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new RocsManifestListDownloadDBDAOsearchCmdForCfmRSQL(),param, velParam);
    			     			
    			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RocscrnVO.class);
    			 
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
    	 *ROCS(ROTTERDAM) 세관 Manifest 신고용 데이터 삭제를 위해 CRN No 및 B/L No로 Booking No를 조회한다.	  
    	 * @param RocsBlKeyVO rocsBlKeyVO
     	 * @return List<RocsSearchBkgNoVO>
     	 * @throws DAOException
    	 */
        @SuppressWarnings("unchecked")
		public List<RocsSearchBkgNoVO> searchBkgNo(
        		RocsBlKeyVO rocsBlKeyVO) throws DAOException {
    		DBRowSet dbRowset = null;
    		List<RocsSearchBkgNoVO> list = null;
    		// query parameter
    		Map<String, Object> param = new HashMap<String, Object>();
    		// velocity parameter
    		Map<String, Object> velParam = new HashMap<String, Object>();

    		try {
    			if (rocsBlKeyVO != null) {
    				Map<String, String> mapVO = rocsBlKeyVO.getColumnValues();

    				param.putAll(mapVO);
    				velParam.putAll(mapVO);
    			} 
    			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new RocsManifestListDownloadDBDAOsearchBkgNoRSQL(),param, velParam);
    			 
    			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RocsSearchBkgNoVO.class);
    			 
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
    	 *ROCS(ROTTERDAM) 세관 신고용 B/L 일반 정보를 조회한다.
    	 * @param BlKeyVO blKeyVO
     	 * @return List<RocsSearchBlInfoVO>
     	 * @throws DAOException
    	 */
        @SuppressWarnings("unchecked")
		public List<RocsSearchBlInfoVO> searchBlInfo(
        		BlKeyVO blKeyVO) throws DAOException {
        	RocsBlKeyVO rocsBlKeyVO = (RocsBlKeyVO)blKeyVO;
        	
    		DBRowSet dbRowset = null;
    		List<RocsSearchBlInfoVO> list = null;
    		// query parameter
    		Map<String, Object> param = new HashMap<String, Object>();
    		// velocity parameter
    		Map<String, Object> velParam = new HashMap<String, Object>();

    		try {
    			if (rocsBlKeyVO != null) {
    				Map<String, String> mapVO = rocsBlKeyVO.getColumnValues();

    				param.putAll(mapVO);
    				velParam.putAll(mapVO);
    			} 
    			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new RocsManifestListDownloadDBDAOsearchBlInfoRSQL(),param, velParam);
    			 
    			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RocsSearchBlInfoVO.class);
    			 
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
    	 *ROCS(ROTTERDAM) 세관 신고용 B/L의 Container List를 조회한다.
    	 * @param BlKeyVO blKeyVO
     	 * @return List<RocsSearchCntrListVO>
     	 * @throws DAOException
    	 */
        @SuppressWarnings("unchecked")
		public List<RocsSearchCntrListVO> searchCntrList(
				BlKeyVO blKeyVO) throws DAOException {
        	RocsBlKeyVO rocsBlKeyVO = (RocsBlKeyVO)blKeyVO;
    		DBRowSet dbRowset = null;
    		List<RocsSearchCntrListVO> list = null;
    		// query parameter
    		Map<String, Object> param = new HashMap<String, Object>();
    		// velocity parameter
    		Map<String, Object> velParam = new HashMap<String, Object>();

    		try {
    			if (rocsBlKeyVO != null) {
    				Map<String, String> mapVO = rocsBlKeyVO.getColumnValues();

    				param.putAll(mapVO);
    				velParam.putAll(mapVO);
    			} 
    			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new RocsManifestListDownloadDBDAOsearchCntrListRSQL(),param, velParam);
    			 
    			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RocsSearchCntrListVO.class);
    			 
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
    	 *ROCS(ROTTERDAM) 세관 신고용 Container의 Cargo 정보를 조회한다.
    	 * @param BlKeyVO blKeyVO
     	 * @return List<RocsSearchCargoDetailVO>
     	 * @throws DAOException
    	 */
        @SuppressWarnings("unchecked")
		public List<RocsSearchCargoDetailVO> searchCarcgDetail(
				BlKeyVO blKeyVO) throws DAOException {
        	RocsBlKeyVO rocsBlKeyVO = (RocsBlKeyVO)blKeyVO;
    		DBRowSet dbRowset = null;
    		List<RocsSearchCargoDetailVO> list = null;
    		// query parameter
    		Map<String, Object> param = new HashMap<String, Object>();
    		// velocity parameter
    		Map<String, Object> velParam = new HashMap<String, Object>();

    		try {
    			if (rocsBlKeyVO != null) {
    				Map<String, String> mapVO = rocsBlKeyVO.getColumnValues();

    				param.putAll(mapVO);
    				velParam.putAll(mapVO);
    			} 
    			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new RocsManifestLIstDownloadDBDAOsearchCargoDetailRSQL(),param, velParam);
    			 
    			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RocsSearchCargoDetailVO.class);
    			 
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
    	 *ROCS(ROTTERDAM) 세관에 신고할 대상 Manifest List를 전송하기 전에 데이터를 확인했다는 의미로 Confirm Indicator를 업데이트 한다. 
         *(modifyConfirmIndD, modifyConfirmIndC 실행조건에 모두 해당하지 않는 경우 Confirm Indicator를 'Y'로 업데이트 한다.).
    	 * @param RocsManifestConfirmationVO rocsManifestConfirmationVO
     	 * @return int
     	 * @throws DAOException
    	 */
        public int modifyConfirmInd(RocsManifestConfirmationVO rocsManifestConfirmationVO) 
        throws DAOException,Exception {
    		
            //query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            //velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();
            
            
            int result = 0;
            try {
                Map<String, String> mapVO = rocsManifestConfirmationVO.getColumnValues();
                
               
                param.putAll(mapVO);
                velParam.putAll(mapVO);
                
                result = new SQLExecuter("").executeUpdate((ISQLTemplate)new RocsManifestListDownloadDBDAOmodifyConfirmIndUSQL(), param, velParam);
                
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
    	 *ROCS(ROTTERDAM) 세관에 신고할 대상 Manifest List를 전송하기 전에 데이터를 확인했다는 의미로 Confirm Indicator를 업데이트 하는데
         *Container 정보 미존재시(searchCntrForCfm 실행결과가 없는 경우) 'C'로 업데이트한다.
         *- modifyConfirmIndD 오퍼레이션 실행 조건(Full Cargo이면서 Cargo Description 정보 미존재)에 해당하여 이미 'D'로 업데이트 되어 있는 경우에도
         *Container 정보 미존재시 'C'로 다시 업데이트 한다.
    	 * @param RocsManifestConfirmationVO rocsManifestConfirmationVO
     	 * @return int
     	 * @throws DAOException
    	 */
        
        public int modifyConfirmIndC(RocsManifestConfirmationVO rocsManifestConfirmationVO) 
        throws DAOException,Exception {
    		
            //query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            //velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();
            
            
            int result = 0;
            try {
                Map<String, String> mapVO = rocsManifestConfirmationVO.getColumnValues();
                
               
                param.putAll(mapVO);
                velParam.putAll(mapVO);
                
                result = new SQLExecuter("").executeUpdate((ISQLTemplate)new RocsManifestListDownloadDBDAOmodifyConfirmIndCUSQL(), param, velParam);
                
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
    	 *ROCS(ROTTERDAM) 세관에 신고할 대상 Manifest List를 전송하기 전에 데이터를 확인했다는 의미로 Confirm Indicator를 업데이트 하는데
         *Full Cargo(B/L List F/M 항목값='F')이면서 Cargo Description 정보 미존재시(searchCmdForCfm 실행결과가 없는 경우) 'D'로 업데이트한다.
    	 * @param RocsManifestConfirmationVO rocsManifestConfirmationVO
     	 * @return int
     	 * @throws DAOException
    	 */
        public int modifyConfirmIndD(RocsManifestConfirmationVO rocsManifestConfirmationVO) 
        throws DAOException,Exception {
    		
            //query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            //velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();
            
            
            int result = 0;
            try {
                Map<String, String> mapVO = rocsManifestConfirmationVO.getColumnValues();
                
               
                param.putAll(mapVO);
                velParam.putAll(mapVO);
                
                result = new SQLExecuter("").executeUpdate((ISQLTemplate)new RocsManifestListDownloadDBDAOmodifyConfirmIndDUSQL(), param, velParam);
                
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
    	 * Change CRN의 중복여부를 check 한다.<br>
    	 * 
    	 * @param String vslCallRefNoOld
    	 * @param String vslCallRefNoNew
    	 * @return list
    	 * @throws DAOException
    	 * @throws Exception
    	 */
    	@SuppressWarnings("unchecked")
    	public List<CrnVO> checkDuplicateCrnNo(String vslCallRefNoOld, String vslCallRefNoNew) throws DAOException {
    		DBRowSet dbRowset = null;
    		List<CrnVO> list = null;
    		// query parameter
    		Map<String, Object> param = new HashMap<String, Object>();
    		// velocity parameter
    		Map<String, Object> velParam = new HashMap<String, Object>();
    		
			param.put("vsl_call_ref_no_old", vslCallRefNoOld);
			param.put("frm_crn_number", vslCallRefNoNew);
			param.put("vsl_cd", "");
			param.put("skd_voy_no", "");
			param.put("skd_dir_cd", "");
			velParam.put("frm_crn_number", vslCallRefNoNew);
			velParam.put("vsl_cd", "");
			velParam.put("skd_voy_no", "");
			velParam.put("skd_dir_cd", "");
    		try {
    			
    			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new RocsManifestListDownloadDBDAOsearCNRInfoRSQL(),param, velParam);
    			list = (List)RowSetUtil.rowSetToVOs(dbRowset,
    					RocscrnVO.class);
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
    	 * Change CRN 을 save 한다.<br>
    	 * 
    	 * @param String vslCallRefNoOld
    	 * @param String vslCallRefNoNew
    	 * @param String updUsrId
    	 * @return int
    	 * @throws DAOException
    	 * @throws Exception
    	 */
    	public int modifyCrnNo(String vslCallRefNoOld, String vslCallRefNoNew ,String updUsrId)
    			throws DAOException, Exception {

    		int result = 0;
    		try {
    			// query parameter
    			Map<String, Object> param = new HashMap<String, Object>();
    			param.put("vsl_call_ref_no_old", vslCallRefNoOld);
    			param.put("vsl_call_ref_no_new", vslCallRefNoNew);
    			param.put("upd_usr_id", updUsrId);

    			SQLExecuter sqlExe = new SQLExecuter("");
    			result = sqlExe.executeUpdate((ISQLTemplate) new RocsManifestListDownloadDBDAOmodifyCrnNoForVslUSQL(), param, null,	true);

    			if (result != Statement.EXECUTE_FAILED) {
    				result = sqlExe.executeUpdate((ISQLTemplate) new RocsManifestListDownloadDBDAOmodifyCrnNoForBlUSQL(), param, null, true);
    				if (result != Statement.EXECUTE_FAILED) {
    					result = sqlExe.executeUpdate((ISQLTemplate) new RocsManifestListDownloadDBDAOmodifyCrnNoForCntrUSQL(), param, null, true);
    					if (result != Statement.EXECUTE_FAILED) {
    						result = sqlExe.executeUpdate((ISQLTemplate) new RocsManifestListDownloadDBDAOmodifyCrnNoForCmUSQL(), param, null, true);
    					}
    				}
    			} else {
    				throw new DAOException("Fail to update SQL");
    			}
    			
    		} catch (SQLException se) {
    			log.error(se.getMessage(), se);
    			throw new DAOException(new ErrorHandler(se).getMessage());
    		} catch (Exception ex) {
    			log.error(ex.getMessage(), ex);
    			throw new DAOException(new ErrorHandler(ex).getMessage());
    		}
    		return result;
    	}        
    	
//    	/**
//    	 * Container Loading List(Korea) 전송 후 CLL Update Date를 업데이트 한다.<br>
//    	 * 
//    	 * @param String vslCallRefNoOld
//    	 * @param String vslCallRefNoNew
//    	 * @param String updUsrId
//    	 * @return int
//    	 * @throws DAOException
//    	 * @throws Exception
//    	 */
//    	public int modifyCrnNoForVsl(String vslCallRefNoOld, String vslCallRefNoNew, String updUsrId)
//    			throws DAOException, Exception {
//
//    		int result = 0;
//    		try {
//    			// query parameter
//    			Map<String, Object> param = new HashMap<String, Object>();
//    			param.put("vsl_call_ref_no_old", vslCallRefNoOld);
//    			param.put("vsl_call_ref_no_new", vslCallRefNoNew);
//    			param.put("upd_usr_id", updUsrId);
//
//    			SQLExecuter sqlExe = new SQLExecuter("");
//    			result = sqlExe.executeUpdate((ISQLTemplate) new RocsManifestListDownloadDBDAOmodifyCrnNoForVslUSQL(), param, null,
//    					true);
//    			if (result == Statement.EXECUTE_FAILED)
//    				throw new DAOException("Fail to update SQL");
//    		} catch (SQLException se) {
//    			log.error(se.getMessage(), se);
//    			throw new DAOException(new ErrorHandler(se).getMessage());
//    		} catch (Exception ex) {
//    			log.error(ex.getMessage(), ex);
//    			throw new DAOException(new ErrorHandler(ex).getMessage());
//    		}
//    		return result;
//    	}        
//    	
//    	/**
//    	 * Container Loading List(Korea) 전송 후 CLL Update Date를 업데이트 한다.<br>
//    	 * 
//    	 * @param String vslCallRefNoOld
//    	 * @param String vslCallRefNoNew
//    	 * @param String updUsrId
//    	 * @return int
//    	 * @throws DAOException
//    	 * @throws Exception
//    	 */
//    	public int modifyCrnNoForBl(String vslCallRefNoOld, String vslCallRefNoNew, String updUsrId)
//    			throws DAOException, Exception {
//
//    		int result = 0;
//    		try {
//    			// query parameter
//    			Map<String, Object> param = new HashMap<String, Object>();
//    			param.put("vsl_call_ref_no_old", vslCallRefNoOld);
//    			param.put("vsl_call_ref_no_new", vslCallRefNoNew);
//    			param.put("upd_usr_id", updUsrId);
//
//    			SQLExecuter sqlExe = new SQLExecuter("");
//    			result = sqlExe.executeUpdate((ISQLTemplate) new RocsManifestListDownloadDBDAOmodifyCrnNoForBlUSQL(), param, null,
//    					true);
//    			if (result == Statement.EXECUTE_FAILED)
//    				throw new DAOException("Fail to update SQL");
//    		} catch (SQLException se) {
//    			log.error(se.getMessage(), se);
//    			throw new DAOException(new ErrorHandler(se).getMessage());
//    		} catch (Exception ex) {
//    			log.error(ex.getMessage(), ex);
//    			throw new DAOException(new ErrorHandler(ex).getMessage());
//    		}
//    		return result;
//    	}   
//    	
//    	/**
//    	 * Container Loading List(Korea) 전송 후 CLL Update Date를 업데이트 한다.<br>
//    	 * 
//    	 * @param String vslCallRefNoOld
//    	 * @param String vslCallRefNoNew
//    	 * @param String updUsrId
//    	 * @return int
//    	 * @throws DAOException
//    	 * @throws Exception
//    	 */
//    	public int modifyCrnNoForCntr(String vslCallRefNoOld, String vslCallRefNoNew, String updUsrId)
//    			throws DAOException, Exception {
//
//    		int result = 0;
//    		try {
//    			// query parameter
//    			Map<String, Object> param = new HashMap<String, Object>();
//    			param.put("vsl_call_ref_no_old", vslCallRefNoOld);
//    			param.put("vsl_call_ref_no_new", vslCallRefNoNew);
//    			param.put("upd_usr_id", updUsrId);
//
//    			SQLExecuter sqlExe = new SQLExecuter("");
//    			result = sqlExe.executeUpdate((ISQLTemplate) new RocsManifestListDownloadDBDAOmodifyCrnNoForCntrUSQL(), param, null,
//    					true);
//    			if (result == Statement.EXECUTE_FAILED)
//    				throw new DAOException("Fail to update SQL");
//    		} catch (SQLException se) {
//    			log.error(se.getMessage(), se);
//    			throw new DAOException(new ErrorHandler(se).getMessage());
//    		} catch (Exception ex) {
//    			log.error(ex.getMessage(), ex);
//    			throw new DAOException(new ErrorHandler(ex).getMessage());
//    		}
//    		return result;
//    	}   
//    	
//    	/**
//    	 * Container Loading List(Korea) 전송 후 CLL Update Date를 업데이트 한다.<br>
//    	 * 
//    	 * @param String vslCallRefNoOld
//    	 * @param String vslCallRefNoNew
//    	 * @param String updUsrId
//    	 * @return int
//    	 * @throws DAOException
//    	 * @throws Exception
//    	 */
//    	public int modifyCrnNoForCm(String vslCallRefNoOld, String vslCallRefNoNew, String updUsrId)
//    			throws DAOException, Exception {
//
//    		int result = 0;
//    		try {
//    			// query parameter
//    			Map<String, Object> param = new HashMap<String, Object>();
//    			param.put("vsl_call_ref_no_old", vslCallRefNoOld);
//    			param.put("vsl_call_ref_no_new", vslCallRefNoNew);
//    			param.put("upd_usr_id", updUsrId);
//
//    			SQLExecuter sqlExe = new SQLExecuter("");
//    			result = sqlExe.executeUpdate((ISQLTemplate) new RocsManifestListDownloadDBDAOmodifyCrnNoForCmUSQL(), param, null,
//    					true);
//    			if (result == Statement.EXECUTE_FAILED)
//    				throw new DAOException("Fail to update SQL");
//    		} catch (SQLException se) {
//    			log.error(se.getMessage(), se);
//    			throw new DAOException(new ErrorHandler(se).getMessage());
//    		} catch (Exception ex) {
//    			log.error(ex.getMessage(), ex);
//    			throw new DAOException(new ErrorHandler(ex).getMessage());
//    		}
//    		return result;
//    	}       	
//        
        /**
    	 *ROCS(ROTTERDAM) 세관에 신고할 대상 Manifest List를 전송하기 전에 데이터를 확인했다는 의미로 Confirm Indicator를 업데이트 하는데
         *Full Cargo(B/L List F/M 항목값='F')이면서 Cargo Description 정보 미존재시(searchCmdForCfm 실행결과가 없는 경우) 'D'로 업데이트한다.
    	 * @param RocsBlKeyVO rocsBlKeyVO
     	 * @return int
     	 * @throws DAOException
    	 */
        public int removeRocsCmd(RocsBlKeyVO rocsBlKeyVO) 
        throws DAOException,Exception {
    		
            //query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            //velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();
            
            
            int result = 0;
            try {
                Map<String, String> mapVO = rocsBlKeyVO.getColumnValues();
                
               
                param.putAll(mapVO);
                velParam.putAll(mapVO);
                
                result = new SQLExecuter("").executeUpdate((ISQLTemplate)new RocsManifestListDownloadDBDAOremoveRocsCmdDSQL(), param, velParam);
                
                if(result == Statement.EXECUTE_FAILED) {
                	throw new DAOException("Fail to Delete SQL");
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
    	 *ROCS(ROTTERDAM) 세관 Manifest 신고용 Container 정보를 삭제한다.
    	 * @param RocsBlKeyVO rocsBlKeyVO
     	 * @return int
     	 * @throws DAOException
    	 */
        public int removeRocsCntr(RocsBlKeyVO rocsBlKeyVO) 
        throws DAOException,Exception {
    		
            //query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            //velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();
            
            
            int result = 0;
            try {
                Map<String, String> mapVO = rocsBlKeyVO.getColumnValues();
                
               
                param.putAll(mapVO);
                velParam.putAll(mapVO);
                
                result = new SQLExecuter("").executeUpdate((ISQLTemplate)new RocsManifestListDownloadDBDAOremoveRocsCntrDSQL(), param, velParam);
                
                if(result == Statement.EXECUTE_FAILED) {
                	throw new DAOException("Fail to Delete SQL");
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
    	 *ROCS(ROTTERDAM) 세관 Manifest 신고용 B/L 정보를 삭제한다.
    	 * @param RocsBlKeyVO rocsBlKeyVO
     	 * @return int
     	 * @throws DAOException
    	 */
        public int removeRocsBl(RocsBlKeyVO rocsBlKeyVO) 
        throws DAOException,Exception {
    		
            //query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            //velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();
            
            
            int result = 0;
            try {
                Map<String, String> mapVO = rocsBlKeyVO.getColumnValues();
                
               
                param.putAll(mapVO);
                velParam.putAll(mapVO);
                
                result = new SQLExecuter("").executeUpdate((ISQLTemplate)new RocsManifestLiatDownloadDBDAOremoveRocsBlDSQL(), param, velParam);
                
                if(result == Statement.EXECUTE_FAILED) {
                	throw new DAOException("Fail to Delete SQL");
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
    	 * ROCS(ROTTERDAM) 세관 신고용 신규 Container 정보를 생성한다.  	  
    	 * @param RocsCntrModificationVO rocsCntrModificationVO
    	 * @param vvdNumber
     	 * @return int
     	 * @throws DAOException
    	 */
        public int addCntrInfo(RocsCntrModificationVO rocsCntrModificationVO, String vvdNumber) 
        throws DAOException,Exception {
    		
            //query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            //velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();
            
            
            int result = 0;
            try {
                Map<String, String> mapVO = rocsCntrModificationVO.getColumnValues();
                
               
                param.putAll(mapVO);
                velParam.putAll(mapVO);
                param.put("vvd_number", vvdNumber);
                velParam.put("vvd_number", vvdNumber);
                
                result = new SQLExecuter("").executeUpdate((ISQLTemplate)new RocsManifestListDownloadDBDAOaddCntrInfoCSQL(), param, velParam);
                
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
    	 * ROCS(ROTTERDAM) 세관 신고용 수정된 Container 정보를 업데이트한다.    	  
    	 * @param RocsCntrModificationVO rocsCntrModificationVO
     	 * @return int
     	 * @throws DAOException
    	 */
        public int modifyCntrInfo(RocsCntrModificationVO rocsCntrModificationVO) 
        throws DAOException,Exception {
    		
            //query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            //velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();
            
            
            int result = 0;
            try {
                Map<String, String> mapVO = rocsCntrModificationVO.getColumnValues();
                
               
                param.putAll(mapVO);
                velParam.putAll(mapVO);
                
                result = new SQLExecuter("").executeUpdate((ISQLTemplate)new RocsManifestListDownloadDBDAOmodifyCntrInfoUSQL(), param, velParam);
                
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
    	 * ROCS(ROTTERDAM) 세관 신고용 수정된 B/L 일반 정보를 업데이트한다.   	  
    	 * @param RocsBlModificationVO rocsBlModificationVO
     	 * @return int
     	 * @throws DAOException
    	 */
        public int modifyBlInfo(RocsBlModificationVO rocsBlModificationVO) 
        throws DAOException,Exception {
    		
            //query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            //velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();
            
            
            int result = 0;
            try {
                Map<String, String> mapVO = rocsBlModificationVO.getColumnValues();
                
               
                param.putAll(mapVO);
                velParam.putAll(mapVO);
                
                result = new SQLExecuter("").executeUpdate((ISQLTemplate)new RocsManifestListDownloadDBDAOmodifyBlInfoUSQL(), param, velParam);
                
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
         * ROCS(ROTTERDAM) 세관 신고용 Container 정보로부터 Actual Weight 을 조회하여 B/L 정보를 업데이트한다.
         * @param rocsBlModificationVO
         * @return int
         * @throws DAOException
         * @throws Exception
         */
        public int modifyBlActWgtByCntr(RocsBlModificationVO rocsBlModificationVO) 
        throws DAOException,Exception {
    		
            //query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            //velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();
            
            
            int result = 0;
            try {
                Map<String, String> mapVO = rocsBlModificationVO.getColumnValues();
                
               
                param.putAll(mapVO);
                velParam.putAll(mapVO);
                
                result = new SQLExecuter("").executeUpdate((ISQLTemplate)new RocsManifestListDownloadDBDAOmodifyBlActWgtByCntrUSQL(), param, velParam);
                
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
    	 * ROCS(ROTTERDAM) 세관 신고용 수정된 B/L 일반 정보를 업데이트한다.   	  
    	 * @param RocsBlModificationVO rocsBlModificationVO
         * @return int
         * @throws DAOException
         * @throws Exception
    	 */
        public int modifyRocsNtfy(RocsBlModificationVO rocsBlModificationVO) 
        throws DAOException,Exception {
    		
            //query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            //velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();
            
            
            int result = 0;
            try {
                Map<String, String> mapVO = rocsBlModificationVO.getColumnValues();
                
               
                param.putAll(mapVO);
                velParam.putAll(mapVO);
                
                result = new SQLExecuter("").executeUpdate((ISQLTemplate)new RocsManifestListDownloadDBDAOmodifyRocsNtfyUSQL(), param, velParam);
                
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
    	 * ROCS(ROTTERDAM) 세관 신고용 Container 정보를 삭제한다.   	  
    	 * @param RocsCntrModificationVO rocsCntrModificationVO
         * @return int
         * @throws DAOException
         * @throws Exception
    	 */
        public int removeCntrInfo(RocsCntrModificationVO rocsCntrModificationVO) 
        throws DAOException,Exception {
    		
            //query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            //velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();
            
            
            int result = 0;
            try {
                Map<String, String> mapVO = rocsCntrModificationVO.getColumnValues();
                
               
                param.putAll(mapVO);
                velParam.putAll(mapVO);
                
                result = new SQLExecuter("").executeUpdate((ISQLTemplate)new RocsManifestListDownloadDBDAOremoveCntrInfoDSQL(), param, velParam);
                
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
    	 * ROCS(ROTTERDAM) 세관 신고용 수정된 CMD(Cargo) 정보를 업데이트한다.    	  
    	 * @param RocsCmdModificationVO rocsCmdModificationVO
         * @return int
         * @throws DAOException
         * @throws Exception
    	 */
        public int modifyCmdInfo(RocsCmdModificationVO rocsCmdModificationVO) 
        throws DAOException,Exception {
    		
            //query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            //velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();
            
            
            int result = 0;
            try {
                Map<String, String> mapVO = rocsCmdModificationVO.getColumnValues();
                
               
                param.putAll(mapVO);
                velParam.putAll(mapVO);
                
                result = new SQLExecuter("").executeUpdate((ISQLTemplate)new RocsManifestListDownloadDBDAOmodifyCmdInfoUSQL(), param, velParam);
                
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
    	 * ROCS(ROTTERDAM) 세관 신고용 CMD(Cargo) 정보를 삭제한다.
         * (Container No 없는 CMD Data Delete)    	  
    	 * @param RocsCmdModificationVO rocsCmdModificationVO
         * @return int
         * @throws DAOException
         * @throws Exception
    	 */
        public int removeCmdForNoCntr(RocsCmdModificationVO rocsCmdModificationVO) 
        throws DAOException,Exception {
    		
            //query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            //velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();
            
            
            int result = 0;
            try {
                Map<String, String> mapVO = rocsCmdModificationVO.getColumnValues();
                
               
                param.putAll(mapVO);
                velParam.putAll(mapVO);
                
                result = new SQLExecuter("").executeUpdate((ISQLTemplate)new RocsManifestListDownloadDBDAOremoveCmdForNoCntrDSQL(), param, velParam);
                
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
    	 * ROCS(ROTTERDAM) 세관 신고용 CMD(Cargo) 정보를 삭제한다.
         * (Container No 없는 CMD Data Delete)    	  
    	 * @param RocsCntrModificationVO rocsCntrModificationVO
         * @return int
         * @throws DAOException
         * @throws Exception
    	 */
        public int removeCmdForNoCntr(RocsCntrModificationVO rocsCntrModificationVO) 
        throws DAOException,Exception {
    		
            //query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            //velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();
            
            
            int result = 0;
            try {
                Map<String, String> mapVO = rocsCntrModificationVO.getColumnValues();
                
               
                param.putAll(mapVO);
                velParam.putAll(mapVO);
                
                result = new SQLExecuter("").executeUpdate((ISQLTemplate)new RocsManifestListDownloadDBDAOremoveCmdForNoCntrDSQL(), param, velParam);
                
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
    	 * ROCS(ROTTERDAM) 세관 신고용 신규 CMD(Cargo) 정보를 생성한다.
         * (Container No 없는 CMD Data Delete)    	  
    	 * @param RocsCmdModificationVO rocsCmdModificationVO
         * @return int
         * @throws DAOException
         * @throws Exception
    	 */
        public int addCmdInfo(RocsCmdModificationVO rocsCmdModificationVO) 
        throws DAOException,Exception {
    		
            //query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            //velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();
            
            
            int result = 0;
            try {
                Map<String, String> mapVO = rocsCmdModificationVO.getColumnValues();
                
               
                param.putAll(mapVO);
                velParam.putAll(mapVO);
                
                result = new SQLExecuter("").executeUpdate((ISQLTemplate)new RocsManifestListDownloadDBDAOaddCmdInfoCSQL(), param, velParam);
                
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
    	 * ROCS(ROTTERDAM) 세관 신고용 CMD(Cargo) 정보를 삭제한다.	  
    	 * @param RocsCmdModificationVO rocsCmdModificationVO
         * @return int
         * @throws DAOException
         * @throws Exception
    	 */
        public int removeCmdInfo(RocsCmdModificationVO rocsCmdModificationVO) 
        throws DAOException,Exception {
    		
            //query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            //velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();
            
            
            int result = 0;
            try {
                Map<String, String> mapVO = rocsCmdModificationVO.getColumnValues();
                
               
                param.putAll(mapVO);
                velParam.putAll(mapVO);
                
                result = new SQLExecuter("").executeUpdate((ISQLTemplate)new RocsManifestListDownloadDBDAOremoveCmdInfoDSQL(), param, velParam);
                
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
    	 * ROCS(ROTTERDAM) 세관에 신고할 대상 Vessel Arrival 정보 데이터를 조회한다.
    	 * 
    	 * @param RocsVesselArrivalCondVO rocsVesselArrivalCondVO
    	 * @param SignOnUserAccount account
         * @return List<VesselArrivalVO>
         * @throws DAOException
         * @throws Exception
    	 */
    	@SuppressWarnings("unchecked")
		public List<VesselArrivalVO> searchVesselArrival(
    			RocsVesselArrivalCondVO rocsVesselArrivalCondVO, SignOnUserAccount account) throws DAOException {
    		DBRowSet dbRowset = null;
    		List<VesselArrivalVO> list = null;
    		rocsVesselArrivalCondVO.setUpdUsrId(account.getUpd_usr_id());
    		// query parameter
    		Map<String, Object> param = new HashMap<String, Object>();
    		// velocity parameter
    		Map<String, Object> velParam = new HashMap<String, Object>();

    		try {
    			if (rocsVesselArrivalCondVO != null) {
    				Map<String, String> mapVO = rocsVesselArrivalCondVO
    						.getColumnValues();

    				param.putAll(mapVO);
    				velParam.putAll(mapVO);
    			} 
    			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new RocsManifestListDownloadDBDAOsearchVesselArrivalRSQL(),param, velParam);
    			list = (List) RowSetUtil.rowSetToVOs(dbRowset,
    					RocsSearchVesselArrivalVO.class);
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
    	 *ROCS(ROTTERDAM) 세관에 신고할 대상 POL 별 정보를 조회한다.	   	  
    	 * @param RocsVesselArrivalCondVO rocsVesselArrivalCondVOO
         * @return List<ManifestListVO>
         * @throws DAOException
         * @throws Exception
    	 */
        @SuppressWarnings("unchecked")
		public List<ManifestListVO> searchPortList(
				RocsVesselArrivalCondVO rocsVesselArrivalCondVOO) throws DAOException {
    		DBRowSet dbRowset = null;
    		List<ManifestListVO> list = null;
    		// query parameter
    		Map<String, Object> param = new HashMap<String, Object>();
    		// velocity parameter
    		Map<String, Object> velParam = new HashMap<String, Object>();

    		try {
    			if (rocsVesselArrivalCondVOO != null) {
    				Map<String, String> mapVO = rocsVesselArrivalCondVOO.getColumnValues();

    				param.putAll(mapVO);
    				velParam.putAll(mapVO);
    			} 
    			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new RocsManifestListDownloadDBDAOsearchPortListRSQL(),param, velParam);
    			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RocsSearchPortListVO.class);
    			 
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
    	 *ROCS(ROTTERDAM) 세관 신고용 B/L Info를 생성한다. (B/L Creation Indicator = 'N')	   	  
    	 * @param RocsBlVO blvO
         * @return int
         * @throws DAOException
         * @throws Exception
    	 */
        public int addBlForN(RocsBlVO blvO) 
        throws DAOException,Exception {
    		
            //query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            //velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();
            
            
            int result = 0;
            try {
                Map<String, String> mapVO = blvO.getColumnValues();
                
               
                param.putAll(mapVO);
                velParam.putAll(mapVO);
                
                result = new SQLExecuter("").executeUpdate((ISQLTemplate)new RocsManifestListDownloadDBDAOaddBlForNCSQL(), param, velParam);
                
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
         * ROCS(ROTTERDAM) 세관 신고용 B/L Info의 T1 Indicator를 업데이트 한다. (B/L Creation Indicator = 'N')
         * @param String crnNo
         * @return int
         * @throws DAOException
         * @throws Exception
         */
        public int modifyT1IndForN(String crnNo) 
        throws DAOException,Exception {
    		
            //query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            //velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();
            
            
            int result = 0;
            try {
            	param.put("crn_number", crnNo);
                velParam.put("crn_number", crnNo);
                
                result = new SQLExecuter("").executeUpdate((ISQLTemplate)new RocsManifestListDownloadDBDAOmodifyT1IndForNUSQL(), param, velParam);
                
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
         * ROCS(ROTTERDAM) 세관 신고용 B/L Notify Info를 생성한다. (B/L Creation Indicator = 'N')
         * @param String crnNo
         * @return int
         * @throws DAOException
         * @throws Exception
         */
        public int addNtfyForN(String crnNo) 
        throws DAOException,Exception {
        	 Map<String, Object> param = new HashMap<String, Object>();
             //velocity parameter
             Map<String, Object> velParam = new HashMap<String, Object>();
             
             
             int result = 0;
             try {
             	param.put("crn_number", crnNo);
                 velParam.put("crn_number", crnNo);
                 
                 result = new SQLExecuter("").executeUpdate((ISQLTemplate)new RocsmanifestListDownloadDBDAOaddNtfyForNCSQL(), param, velParam);
                 
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
         * ROCS(ROTTERDAM) 세관 신고용 B/L Container Info를 생성한다. (B/L Creation Indicator = 'N')
         * @param String crnNo
         * @param String polCd
         * @param String vslCd
         * @param String skdVoyNo
         * @param String skdDirCd
         * @param String ofcCd
         * @param String userId 
         * @return int
         * @throws DAOException
         * @throws Exception
         */
        public int addCntrForN(String crnNo ,String polCd ,String vslCd, String skdVoyNo, String skdDirCd, String ofcCd, String userId) 
        throws DAOException,Exception {
        	 Map<String, Object> param = new HashMap<String, Object>();
             //velocity parameter
             Map<String, Object> velParam = new HashMap<String, Object>();
             
             int result = 0;
             try {
             	param.put("crn_number", crnNo);
                velParam.put("crn_number", crnNo);
                
                param.put("ofc_cd", ofcCd);
                velParam.put("ofc_cd", ofcCd);
                
                param.put("user_id", userId);
                velParam.put("user_id", userId);
                
                param.put("pol_cd", polCd);
                velParam.put("pol_cd", polCd);
     
                param.put("vsl_cd", vslCd);
                velParam.put("vsl_cd", vslCd);
                
                param.put("skd_voy_no", skdVoyNo);
                velParam.put("skd_voy_no", skdVoyNo);
                
                param.put("skd_dir_cd", skdDirCd);
                velParam.put("skd_dir_cd", skdDirCd);
                 
                 result = new SQLExecuter("").executeUpdate((ISQLTemplate)new RocsManifestLIstDownloadDBDAOaddCntrForNCSQL(), param, velParam);
                 
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
         * ROCS(ROTTERDAM) 세관 신고용 B/L CMD Info를 생성한다. (B/L Creation Indicator = 'N')
         * @param String crnNo
         * @param String ofcCd
         * @param String userId
         * @param String bkgNo
         * @return int
         * @throws DAOException
         * @throws Exception
         */
        public int addCmdForN(String crnNo,String ofcCd,String userId,String bkgNo) 
        throws DAOException,Exception {
        	 Map<String, Object> param = new HashMap<String, Object>();
             //velocity parameter
             Map<String, Object> velParam = new HashMap<String, Object>();
             
             
             int result = 0;
             try {
             	param.put("crn_number", crnNo);
                 velParam.put("crn_number", crnNo);
                 
                 param.put("ofc_cd", ofcCd);
                 velParam.put("ofc_cd", ofcCd);
                 
                 param.put("user_id", userId);
                 velParam.put("user_id", userId);
                 
                 param.put("bkg_no", bkgNo);
                 velParam.put("bkg_no", bkgNo);
                 
                 result = new SQLExecuter("").executeUpdate((ISQLTemplate)new RocsManifestListDownLoadDBDAOaddCmdForNCSQL(), param, velParam);
                 
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
         * ROCS(ROTTERDAM) 세관 신고용 B/L Info를 생성한다. (B/L Creation Indicator = 'Y')
         * @param String crnNo
         * @param String ofcCd
         * @param String vslCd
         * @param String skdVoyNo
         * @param String skdDirCd
         * @param String userId
         * @param String bkgNo
         * @return int
         * @throws DAOException
         * @throws Exception
         */
        public int addBlForY(String crnNo, String ofcCd, String vslCd, String skdVoyNo, String skdDirCd, String userId,String bkgNo) 
        throws DAOException,Exception {
        	 Map<String, Object> param = new HashMap<String, Object>();
             //velocity parameter
             Map<String, Object> velParam = new HashMap<String, Object>();
             
             
             int result = 0;
             try {
             	param.put("crn_number", crnNo);
                 velParam.put("crn_number", crnNo);
                 
                 param.put("ofc_cd", ofcCd);
                 velParam.put("ofc_cd", ofcCd);
                 
                 param.put("user_id", userId);
                 velParam.put("user_id", userId);
                 
                 param.put("bkg_no", bkgNo);
                 velParam.put("bkg_no", bkgNo);
                 
                 param.put("vsl_cd", vslCd);
                 velParam.put("vsl_cd", vslCd);
                 
                 param.put("skd_voy_no", skdVoyNo);
                 velParam.put("skd_voy_no", skdVoyNo);
                 
                 param.put("skd_dir_cd", skdDirCd);
                 velParam.put("skd_dir_cd", skdDirCd);
                 
                 result = new SQLExecuter("").executeUpdate((ISQLTemplate)new RocsmanifestListDownloadDBDAOaddBlForYCSQL(), param, velParam);
                 
                 if(result == Statement.EXECUTE_FAILED) {
                 	throw new DAOException("Fail to Update SQL");
                 }
                 
             } catch(SQLIntegrityConstraintViolationException e)
			 {
					throw new EventException(new ErrorHandler("BKG03056", new String[] {"B/L No."}).getMessage(), e);
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
         * ROCS(ROTTERDAM) 세관 신고용 B/L Info의 T1 Indicator를 업데이트 한다. (B/L Creation Indicator = 'Y')
         * @param String crnNo
         * @param String bkgNo
         * @return int
         * @throws DAOException
         * @throws Exception
         */
        public int modifyT1IndForY(String crnNo,String bkgNo) 
        throws DAOException,Exception {
        	 Map<String, Object> param = new HashMap<String, Object>();
             //velocity parameter
             Map<String, Object> velParam = new HashMap<String, Object>();
             
             
             int result = 0;
             try {
             	param.put("crn_number", crnNo);
                 velParam.put("crn_number", crnNo);
                 
                 param.put("bkg_no", bkgNo);
                 velParam.put("bkg_no", bkgNo);
                 
                 result = new SQLExecuter("").executeUpdate((ISQLTemplate)new RocsManifestListDownloadDBDAOmodifyT1IndForYUSQL(), param, velParam);
                 
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
         * ROCS(ROTTERDAM) 세관 신고용 B/L Notify Info를 생성한다. (B/L Creation Indicator = 'Y')
         * @param String crnNo
         * @param String bkgNo
         * @return int
         * @throws DAOException
         * @throws Exception
         */
        public int addNtfyForY(String crnNo,String bkgNo) 
        throws DAOException,Exception {
        	 Map<String, Object> param = new HashMap<String, Object>();
             //velocity parameter
             Map<String, Object> velParam = new HashMap<String, Object>();
             
             
             int result = 0;
             try {
            	 param.put("crn_number", crnNo);
                 velParam.put("crn_number", crnNo);
                 
                 param.put("bkg_no", bkgNo);
                 velParam.put("bkg_no", bkgNo);
                 
                 result = new SQLExecuter("").executeUpdate((ISQLTemplate)new RocsmanifestListDownloadDBDAOaddNtfyForYCSQL(), param, velParam);
                 
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
         * ROCS(ROTTERDAM) 세관 신고용 B/L Container Info를 생성한다. (B/L Creation Indicator = 'Y')
         * @param String crnNo
         * @param String ofcCd
         * @param String vslCd
         * @param String skdVoyNo
         * @param String skdDirCd
         * @param String userId
         * @param String bkgNo
         * @return int
         * @throws DAOException
         * @throws Exception
         */
        public int addCntrForY(String crnNo,String ofcCd, String vslCd, String skdVoyNo, String skdDirCd,String userId,String bkgNo) 
        throws DAOException,Exception {
        	 Map<String, Object> param = new HashMap<String, Object>();
             //velocity parameter
             Map<String, Object> velParam = new HashMap<String, Object>();
             
             
             int result = 0;
             try {
            	 param.put("crn_number", crnNo);
                 velParam.put("crn_number", crnNo);
                 
                 param.put("ofc_cd", ofcCd);
                 velParam.put("ofc_cd", ofcCd);
                 
                 param.put("user_id", userId);
                 velParam.put("user_id", userId);
                 
                 param.put("bkg_no", bkgNo);
                 velParam.put("bkg_no", bkgNo);
                 
                 param.put("vsl_cd", vslCd);
                 velParam.put("vsl_cd", vslCd);
                 
                 param.put("skd_voy_no", skdVoyNo);
                 velParam.put("skd_voy_no", skdVoyNo);
                 
                 param.put("skd_dir_cd", skdDirCd);
                 velParam.put("skd_dir_cd", skdDirCd);
                 
                 result = new SQLExecuter("").executeUpdate((ISQLTemplate)new RocsManifestListDownloadDBDAOaddCntrForYCSQL(), param, velParam);
                 
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
         * ROCS(ROTTERDAM) 세관 신고용 B/L CMD Info를 생성한다. (B/L Creation Indicator = 'Y')
         * @param String crnNo
         * @param String ofcCd
         * @param String userId
         * @param String bkgNo
         * @return int
         * @throws DAOException
         * @throws Exception
         */
        public int addCmdForY(String crnNo,String ofcCd,String userId,String bkgNo) 
        throws DAOException,Exception {
        	 Map<String, Object> param = new HashMap<String, Object>();
             //velocity parameter
             Map<String, Object> velParam = new HashMap<String, Object>();
             
             
             int result = 0;
             try {
            	 param.put("crn_number", crnNo);
                 velParam.put("crn_number", crnNo);
                 
                 param.put("ofc_cd", ofcCd);
                 velParam.put("ofc_cd", ofcCd);
                 
                 param.put("user_id", userId);
                 velParam.put("user_id", userId);
                 
                 param.put("bkg_no", bkgNo);
                 velParam.put("bkg_no", bkgNo);
                 
                 result = new SQLExecuter("").executeUpdate((ISQLTemplate)new RocsManifestListDownloadDBDAOaddCmdForYCSQL(), param, velParam);
                 
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
         * ROCS(ROTTERDAM) 세관 신고용 B/L Create Indicator 를 업데이트 한다.
         * @param String crnNo
         * @param String userId
         * @param String vslCd
         * @param String skdVoyNo
         * @param String skdDirCd
         * @return int
         * @throws DAOException
         * @throws Exception
         */
        public int modifyCreateInd(String crnNo,String userId, String vslCd, String skdVoyNo, String skdDirCd) 
        throws DAOException,Exception {
        	 Map<String, Object> param = new HashMap<String, Object>();
             //velocity parameter
             Map<String, Object> velParam = new HashMap<String, Object>();
             
             
             int result = 0;
             try {
            	 param.put("crn_number", crnNo);
                 velParam.put("crn_number", crnNo);
                 
                 param.put("user_id", userId);
                 velParam.put("user_id", userId);
                 
     			 param.put("vsl_cd", vslCd);
                 velParam.put("vsl_cd", vslCd);
                
                 param.put("skd_voy_no", skdVoyNo);
                 velParam.put("skd_voy_no", skdVoyNo);
                
                 param.put("skd_dir_cd", skdDirCd);
                 velParam.put("skd_dir_cd", skdDirCd);
                 
                 result = new SQLExecuter("").executeUpdate((ISQLTemplate)new RocsManifestListDownloadDBDAOmodifyCreateIndUSQL(), param, velParam);
                 
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
         * ROCS system내에 I/B B/L File Form으로 출력할 대상 B/L List를 조회한다.
         * @param RocsManifestListCondVO rocsManifestListCondVO
         * @return List<RocsSearchInboundBlListVO>
         * @throws DAOException
         * @throws Exception
         */
        @SuppressWarnings("unchecked")
		public List<RocsSearchInboundBlListVO> searchInBoundBlList(
    			RocsManifestListCondVO rocsManifestListCondVO) throws DAOException {
    		DBRowSet dbRowset = null;
    		List<RocsSearchInboundBlListVO> list = null;
    		// query parameter
    		Map<String, Object> param = new HashMap<String, Object>();
    		// velocity parameter
    		Map<String, Object> velParam = new HashMap<String, Object>();

    		try {
    			if (rocsManifestListCondVO != null) {
    				Map<String, String> mapVO = rocsManifestListCondVO.getColumnValues();

    				param.putAll(mapVO);
    				velParam.putAll(mapVO);
    			} 
    			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new RocsManifestListDownloadDBDAOsearchInboundBlListRSQL(),param, velParam);
    			list = (List)RowSetUtil.rowSetToVOs(dbRowset,
    					RocsSearchInboundBlListVO.class);
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
         * 데이터 확인을 위한 BL List에서 B/L Seq를 수정한다.
         * @param BlSeqVO blSeqVo
         * @return int
         * @throws DAOException
         * @throws Exception
         */
        public int modifyBlSeq(BlSeqVO blSeqVo) throws DAOException,Exception {
    		
            //query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            //velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();
            
            
            int result = 0;
            try {
                Map<String, String> mapVO = blSeqVo.getColumnValues();
                
               
                param.putAll(mapVO);
                velParam.putAll(mapVO);
                
                result = new SQLExecuter("").executeUpdate((ISQLTemplate)new RocsManifestListDownloadDBDAOmodifyBlSeqUSQL(), param, velParam);
                
                if(result == Statement.EXECUTE_FAILED) {
                	throw new DAOException("Fail to insert SQL");
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
         * Rotterdem 세관에서 받은 EDI 현황을 보여준다.
         * @param RocsRcvHistCondVO rocsRcvHistCondVO
         * @return List<ReceiveLogVO>
         * @throws DAOException
         */
        @SuppressWarnings("unchecked")
		public List<ReceiveLogVO> searchRocsReceiveList(
        		RocsRcvHistCondVO rocsRcvHistCondVO) throws DAOException {
    		DBRowSet dbRowset = null;
    		List<ReceiveLogVO> list = null;
    		// query parameter
    		Map<String, Object> param = new HashMap<String, Object>();
    		// velocity parameter
    		Map<String, Object> velParam = new HashMap<String, Object>();

    		try {
    			if (rocsRcvHistCondVO != null) {
    				Map<String, String> mapVO = rocsRcvHistCondVO.getColumnValues();

    				param.putAll(mapVO);
    				velParam.putAll(mapVO);
    			} 
    			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new RocsManifestListDownloadDBDAOsearchRocsReceiveListRSQL(),param, velParam);
    			list = (List)RowSetUtil.rowSetToVOs(dbRowset,
    					RocsSearchRocsReceiveListVO.class);
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
         * Rotterdem 세관에서 받은 EDI 현황을 보여준다.
         * @param RocsHistoryListCondVO rocsHistoryListCondVO
         * @return List<RecieveHistLogVO>
         * @throws DAOException
         */
        @SuppressWarnings("unchecked")
		public List<RecieveHistLogVO> searchRocsRcvHistByBl(
        		RocsHistoryListCondVO rocsHistoryListCondVO) throws DAOException {
    		DBRowSet dbRowset = null;
    		List<RecieveHistLogVO> list = null;
    		// query parameter
    		Map<String, Object> param = new HashMap<String, Object>();
    		// velocity parameter
    		Map<String, Object> velParam = new HashMap<String, Object>();

    		try {
    			if (rocsHistoryListCondVO != null) {
    				Map<String, String> mapVO = rocsHistoryListCondVO.getColumnValues();

    				param.putAll(mapVO);
    				velParam.putAll(mapVO);
    			} 
    			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new RocsManifestListDownloadDBDAOsearchRocsRcvHistByBlRSQL(),param, velParam);
    			list = (List)RowSetUtil.rowSetToVOs(dbRowset,
    					RocsSearchRocsRcvHistByBlVO.class);
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
         * Send 나 Receive 된 메세지를 가져온다.
         * @param RocsReceiveLogCondVO rocsReceiveLogCondVO
         * @return List<ReceiveLogVO>
         * @throws DAOException
         */
        @SuppressWarnings("unchecked")
		public List<ReceiveLogVO> searchRocsReceiveLog(
				RocsReceiveLogCondVO rocsReceiveLogCondVO) throws DAOException {
    		DBRowSet dbRowset = null;
    		List<ReceiveLogVO> list = null;
    		// query parameter
    		Map<String, Object> param = new HashMap<String, Object>();
    		// velocity parameter
    		Map<String, Object> velParam = new HashMap<String, Object>();

    		try {
    			if (rocsReceiveLogCondVO != null) {
    				Map<String, String> mapVO = rocsReceiveLogCondVO.getColumnValues();

    				param.putAll(mapVO);
    				velParam.putAll(mapVO);
    			} 
    			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new RocsManifestListDownloadDBDAOsearchRocsReceiveLogRSQL(),param, velParam);
    			list = (List)RowSetUtil.rowSetToVOs(dbRowset,
    					RocsSearchRocsReceiveLogVO.class);
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
         *  Rotterdem 세관에 보낸 Send EDI 현황을 보여준다.
         * @param RocsTransmitHistCondVO rocsTransmitHistCondVO
         * @return List<TransmitHistVO>
         * @throws DAOException
         */
        @SuppressWarnings("unchecked")
		public List<TransmitHistVO> searchRocsSendList(
				RocsTransmitHistCondVO rocsTransmitHistCondVO) throws DAOException {
    		DBRowSet dbRowset = null;
    		List<TransmitHistVO> list = null;
    		// query parameter
    		Map<String, Object> param = new HashMap<String, Object>();
    		// velocity parameter
    		Map<String, Object> velParam = new HashMap<String, Object>();

    		try {
    			if (rocsTransmitHistCondVO != null) {
    				Map<String, String> mapVO = rocsTransmitHistCondVO.getColumnValues();

    				param.putAll(mapVO);
    				velParam.putAll(mapVO);
    			} 
    			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new RocsmanifestListDownloadDBDAOsearchRocsSendListRSQL(),param, velParam);
    			list = (List)RowSetUtil.rowSetToVOs(dbRowset,
    					RocsSearchRocsSendListVO.class);
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
         * Rotterdem 세관에 보낸 Send EDI History 현황을 보여준다.
         * @param RocsTransmitHistListCondVO rocsTransmitHistListCondVO
         * @return List<TransmitHistVO>
         * @throws DAOException
         */
        @SuppressWarnings("unchecked")
		public List<TransmitHistVO> searchRocsSendHistByBl(
				RocsTransmitHistListCondVO rocsTransmitHistListCondVO) throws DAOException {
    		DBRowSet dbRowset = null;
    		List<TransmitHistVO> list = null;
    		// query parameter
    		Map<String, Object> param = new HashMap<String, Object>();
    		// velocity parameter
    		Map<String, Object> velParam = new HashMap<String, Object>();

    		try {
    			if (rocsTransmitHistListCondVO != null) {
    				Map<String, String> mapVO = rocsTransmitHistListCondVO.getColumnValues();

    				param.putAll(mapVO);
    				velParam.putAll(mapVO);
    			} 
    			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new RocsManifestListDownloadDBDAOsearchRocsSendHistByBlRSQL(),param, velParam);
    			list = (List)RowSetUtil.rowSetToVOs(dbRowset,
    					RocsSearchRocsSendHistByBlVO.class);
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
         * ROCS(ROTTERDAM) 세관 Manifest B/L 전송 Status를 업데이트 한다. 
         * @param rocsManifestTransmitVO
         * @return int
         * @throws DAOException
         * @throws Exception
         */
        public int modifyBlReceivedSts(RocsManifestTransmitVO rocsManifestTransmitVO) 
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
                
                result = new SQLExecuter("").executeUpdate((ISQLTemplate)new RocsManifestListDownloadDBDAOmodifyBlReceiveStsUSQL(), param, velParam);
                
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
    	 * ROCS(ROTTERDAM) 세관 Manifest B/L 전송 Status를 업데이트 한다. <br>
    	 * @param RocsManifestTransmitVO rocsManifestTransmitVO
    	 * @return int
    	 * @throws DAOException 
    	 */
        public int modifyBlSndSts(RocsManifestTransmitVO rocsManifestTransmitVO) 
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
                
                result = new SQLExecuter("").executeUpdate((ISQLTemplate)new RocsManifestListDownloadDBDAOmodifyBlSndStsUSQL(), param, velParam);
                
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
	 * ROCS(ROTTERDAM) 세관 POL CD를 변경
    	 * @param List<RocsManifestTransmitVO> rocsManifestTransmitVOs
    	 * @throws DAOException, Exception
    	 */
        public void modifyBlPolCd(List<RocsManifestTransmitVO> rocsManifestTransmitVOs) 
        throws DAOException,Exception {
            
    		try
    		{
    			SQLExecuter sqlExe = new SQLExecuter("");
    			if (rocsManifestTransmitVOs.size() > 0)
    			{
    				int updCnt[] = null;
    				updCnt = sqlExe.executeBatch((ISQLTemplate) new RocsManifestListDownloadDBDAOmodifyBlPolCdUSQL(),
    						rocsManifestTransmitVOs, null);
    				for (int i = 0; i < updCnt.length; i++)
    				{
    					if (updCnt[i] == Statement.EXECUTE_FAILED)
    						throw new DAOException("Fail to update No" + i + " SQL");
    				}
    			}
            }catch(Exception ex){
                log.error(ex.getMessage(),ex);
                throw new DAOException(new ErrorHandler(ex).getMessage());
            }
    	}

        
	/**
	 * ESM_BKG_1135 : SEARCH <br>
	 * ROCS 의 CRN List 화면에서 Lane 을 조회한다.<br>
	 * 
	 * @return List<BkgHrdCdgCtntVO>
	 * @throws EventException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgHrdCdgCtntVO> searchRocsLane() throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgHrdCdgCtntVO> list = null;
	
		
		try {
			dbRowset = new SQLExecuter("")
					.executeQuery(
							(ISQLTemplate) new RocsManifestListDownloadDBDAOsearchRocsLaneRSQL(),
							null, null);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,
					BkgHrdCdgCtntVO.class);
		} catch (SQLException se) {
			
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	   /**
     * ROCS(ROTTERDAM) ROCS 컨테이너 정보를 삭제한다
     * @param String crnNo
     * @param String polCd
     * @param String vslCd
     * @param String skdVoyNo
     * @param String skdDirCd
     * @return int
     * @throws DAOException
     * @throws Exception
     */
    public int removeRocsCntrInfo(String crnNo, String polCd, String vslCd, String skdVoyNo, String skdDirCd) 
    throws DAOException,Exception {
    	 Map<String, Object> param = new HashMap<String, Object>();
         //velocity parameter
         Map<String, Object> velParam = new HashMap<String, Object>();
         
         
         int result = 0;
         try {
         	param.put("crn_number", crnNo);
         	velParam.put("crn_number", crnNo);
          	param.put("pol_cd", polCd);
            velParam.put("pol_cd", polCd);
          	param.put("vsl_cd", vslCd);
            velParam.put("vsl_cd", vslCd);
          	param.put("skd_voy_no", skdVoyNo);
            velParam.put("skd_voy_no", skdVoyNo);
          	param.put("skd_dir_cd", skdDirCd);
            velParam.put("skd_dir_cd", skdDirCd);
             
             result = new SQLExecuter("").executeUpdate((ISQLTemplate)new RocsManifestListDownloadDBDAOremoveRocsCntrInfoDSQL(), param, velParam);
             
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
     * ROCS(ROTTERDAM) ROCS Cargo 정보를 삭제한다.
     * @param String crnNo
     * @param String polCd
     * @param String vslCd
     * @param String skdVoyNo
     * @param String skdDirCd
     * @return int
     * @throws DAOException
     * @throws Exception
     */
    public int removeRocsCargoInfo(String crnNo ,String polCd, String vslCd, String skdVoyNo, String skdDirCd)
    throws DAOException,Exception {
    	 Map<String, Object> param = new HashMap<String, Object>();
         //velocity parameter
         Map<String, Object> velParam = new HashMap<String, Object>();
         
         
         int result = 0;
         try {
         	param.put("crn_number", crnNo);
         	velParam.put("crn_number", crnNo);
           	param.put("pol_cd", polCd);
            velParam.put("pol_cd", polCd);
          	param.put("vsl_cd", vslCd);
            velParam.put("vsl_cd", vslCd);
          	param.put("skd_voy_no", skdVoyNo);
            velParam.put("skd_voy_no", skdVoyNo);
          	param.put("skd_dir_cd", skdDirCd);
            velParam.put("skd_dir_cd", skdDirCd);
             
             result = new SQLExecuter("").executeUpdate((ISQLTemplate)new RocsManifestListDownloadDBDAOremoveRocsCmInfoDSQL(), param, velParam);
             
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
     * ROCS(ROTTERDAM) ROCS Notify 정보를 삭제한다.
     * @param String crnNo
     * @param String polCd
     * @param String vslCd
     * @param String skdVoyNo
     * @param String skdDirCd
     * @return int
     * @throws DAOException
     * @throws Exception
     */
    public int removeRocsNtfyInfo(String crnNo, String polCd, String vslCd, String skdVoyNo, String skdDirCd)
    throws DAOException,Exception {
    	 Map<String, Object> param = new HashMap<String, Object>();
         //velocity parameter
         Map<String, Object> velParam = new HashMap<String, Object>();
         
         
         int result = 0;
         try {
         	param.put("crn_number", crnNo);
         	velParam.put("crn_number", crnNo);
          	param.put("pol_cd", polCd);
            velParam.put("pol_cd", polCd);
          	param.put("vsl_cd", vslCd);
            velParam.put("vsl_cd", vslCd);
          	param.put("skd_voy_no", skdVoyNo);
            velParam.put("skd_voy_no", skdVoyNo);
          	param.put("skd_dir_cd", skdDirCd);
            velParam.put("skd_dir_cd", skdDirCd);
             
             result = new SQLExecuter("").executeUpdate((ISQLTemplate)new RocsManifestListDownloadDBDAOremoveRocsNtfyInfoDSQL(), param, velParam);
             
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
     * ROCS(ROTTERDAM) ROCS B/L 정보를 삭제한다.
     * @param String crnNo
     * @param String polCd
     * @param String vslCd
     * @param String skdVoyNo
     * @param String skdDirCd
     * @return int
     * @throws DAOException
     * @throws Exception
     */
    public int removeRocsBlInfo(String crnNo, String polCd, String vslCd, String skdVoyNo, String skdDirCd)
    throws DAOException,Exception {
    	 Map<String, Object> param = new HashMap<String, Object>();
         //velocity parameter
         Map<String, Object> velParam = new HashMap<String, Object>();
         
         
         int result = 0;
         try {
         	param.put("crn_number", crnNo);
         	velParam.put("crn_number", crnNo);
          	param.put("pol_cd", polCd);
            velParam.put("pol_cd", polCd);
          	param.put("vsl_cd", vslCd);
            velParam.put("vsl_cd", vslCd);
          	param.put("skd_voy_no", skdVoyNo);
            velParam.put("skd_voy_no", skdVoyNo);
          	param.put("skd_dir_cd", skdDirCd);
            velParam.put("skd_dir_cd", skdDirCd);
             
             result = new SQLExecuter("").executeUpdate((ISQLTemplate)new RocsManifestListDownloadDBDAOremoveRocsBlInfoDSQL(), param, velParam);
             
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

